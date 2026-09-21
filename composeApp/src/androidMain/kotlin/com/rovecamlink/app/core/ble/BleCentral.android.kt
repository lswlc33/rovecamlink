@file:Suppress("MissingPermission")

package com.rovecamlink.app.core.ble

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.bluetooth.BluetoothStatusCodes
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.bluetooth.le.ScanSettings
import android.content.Context
import android.os.Build
import com.rovecamlink.app.PermissionBridge
import com.rovecamlink.app.androidContext
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.monotonicMillis
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import java.util.ArrayDeque
import java.util.UUID

/**
 * Android Bluetooth LE client. Two jobs: find cameras by advertisement name before
 * any Wi-Fi exists, then run a profile's handshake over GATT so the camera opens
 * its own hotspot and reports the credentials back to us.
 *
 * Every step is logged under [LogTag.BLE]-adjacent tags (the handshake stage names
 * come from the shared state machine), because "did the camera answer Bluetooth at
 * all" is the first question any connection report has to answer.
 */
private class AndroidBleCentral : BleCentral {

    @Volatile private var active: GattSession? = null

    private val adapter: BluetoothAdapter?
        get() = (androidContext.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager)?.adapter

    override val isAvailable: Boolean get() = adapter != null

    override fun isAdapterEnabled(): Boolean = adapter?.isEnabled == true

    override suspend fun ensurePermissions(): Boolean = PermissionBridge.request(blePermissions())

    override suspend fun wakeAndFetch(
        camera: BleCamera,
        profile: BleCameraProfile,
        pairingKey: String?,
        timeoutMs: Long,
    ): BleOutcome {
        val bt = adapter ?: return BleOutcome.Unsupported
        if (!bt.isEnabled) return BleOutcome.BluetoothOff
        val device = runCatching { bt.getRemoteDevice(camera.address) }
            .getOrElse { return BleOutcome.Failed("无法解析相机蓝牙地址 ${camera.address}") }
        Diag.info(LogTag.NET, "BLE connect ${camera.name} (${camera.address}) rssi=${camera.rssi}")
        val session = GattSession(
            device = device,
            camera = camera,
            handshake = profile.newSession(camera, pairingKey),
            expectedGateway = profile.expectedGateway,
        )
        active = session
        return try {
            session.run(timeoutMs)
        } finally {
            active = null
            session.shutdown()
        }
    }

    override suspend fun scan(
        profiles: List<BleCameraProfile>,
        timeoutMs: Long,
        onFound: (List<BleCamera>) -> Unit,
    ): List<BleCamera> {
        val scanner = adapter?.bluetoothLeScanner ?: return emptyList()
        val found = LinkedHashMap<String, BleCamera>()
        val stopped = CompletableDeferred<Unit>()
        val callback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult) = ingest(result)

            override fun onBatchScanResults(results: MutableList<ScanResult>) {
                results.forEach { ingest(it) }
            }

            override fun onScanFailed(errorCode: Int) {
                Diag.warn(LogTag.NET, "BLE scan failed code=$errorCode (adapter busy, or permission revoked)")
                stopped.complete(Unit)
            }

            private fun ingest(result: ScanResult) {
                val device = result.device ?: return
                // device.name needs BLUETOOTH_CONNECT and is null without it far too
                // often to be the only source, so the raw advertisement is the fallback.
                val name = runCatching { device.name }.getOrNull()
                    ?: result.scanRecord?.deviceName
                    ?: return
                val profile = profiles.firstOrNull { it.matches(name) } ?: return
                val previous = found[name]
                if (previous != null && previous.rssi >= result.rssi) return
                found[name] = BleCamera(device.address ?: "", name, result.rssi, profile.id)
                onFound(found.values.sortedByDescending { it.rssi })
            }
        }
        return try {
            runCatching {
                scanner.startScan(
                    null,
                    ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build(),
                    callback,
                )
            }.onFailure {
                Diag.error(LogTag.NET, "BLE startScan threw ${Diag.causeChain(it)}")
                return emptyList()
            }
            Diag.debug(LogTag.NET, "BLE scan started (LOW_LATENCY, ${timeoutMs}ms budget)")
            coroutineScope {
                launch {
                    delay(timeoutMs)
                    stopped.complete(Unit)
                }
                stopped.await()
            }
            Diag.info(LogTag.NET, "BLE scan found ${found.size}: ${found.keys.joinToString(", ")}")
            found.values.sortedByDescending { it.rssi }
        } finally {
            runCatching { scanner.stopScan(callback) }
        }
    }

    override fun abort() {
        active?.closeNow()
    }
}

/** API 31+ has the runtime BLUETOOTH pair; below that scanning rides on location. */
private fun blePermissions(): Array<String> =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        arrayOf(Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT)
    } else {
        arrayOf(Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN)
    }

actual fun createBleCentral(): BleCentral = AndroidBleCentral()

/**
 * One GATT connection driving one [BleHandshake].
 *
 * The firmware is unforgiving about ordering, and every rule here came from the
 * official client: notifications must be enabled (CCCD written) before the camera
 * answers anything, writes must be serialised (one in flight, advanced by
 * `onCharacteristicWrite`), and a reply can arrive split over two notifications
 * because the MTU exchange has not settled when the first one lands.
 */
private class GattSession(
    private val device: BluetoothDevice,
    private val camera: BleCamera,
    private val handshake: BleHandshake,
    private val expectedGateway: String?,
) {
    private val writes = ArrayDeque<ByteArray>()
    private val result = CompletableDeferred<BleOutcome>()
    private var buffer = ByteArray(0)

    @Volatile private var gatt: BluetoothGatt? = null
    @Volatile private var characteristic: BluetoothGattCharacteristic? = null
    @Volatile private var writeInFlight = false
    @Volatile private var notifyReady = false
    @Volatile private var closed = false

    suspend fun run(timeoutMs: Long): BleOutcome = coroutineScope {
        val opened = runCatching {
            device.connectGatt(androidContext, false, callback, BluetoothDevice.TRANSPORT_LE)
        }.getOrNull()
        if (opened == null) {
            Diag.error(LogTag.NET, "connectGatt threw for ${camera.name}")
            return@coroutineScope BleOutcome.Failed("无法发起蓝牙连接")
        }
        gatt = opened
        val ticker = launch {
            while (isActive) {
                delay(TICK_MS)
                handshake.onTick(monotonicMillis()).forEach { enqueue(it.bytes) }
            }
        }
        val outcome = try {
            withTimeoutOrNull(timeoutMs) { result.await() }
                ?: BleOutcome.Failed(
                    "相机没有回应蓝牙握手（等了 ${timeoutMs / 1000} 秒）",
                    BleFailure.NoAnswer,
                )
        } finally {
            ticker.cancel()
        }
        Diag.info(LogTag.NET, "BLE handshake ${camera.name} -> ${outcome::class.simpleName}")
        outcome
    }

    private val callback = object : BluetoothGattCallback() {
        override fun onConnectionStateChange(g: BluetoothGatt, status: Int, newState: Int) {
            when (newState) {
                BluetoothProfile.STATE_CONNECTED ->
                    if (!runCatching { g.requestMtu(MTU) }.isSuccess) discover(g)
                BluetoothProfile.STATE_DISCONNECTED -> failOpen("蓝牙连接中断")
            }
        }

        override fun onMtuChanged(g: BluetoothGatt, mtu: Int, status: Int) {
            Diag.debug(LogTag.NET, "BLE mtu=$mtu status=$status")
            discover(g)
        }

        override fun onServicesDiscovered(g: BluetoothGatt, status: Int) = discover(g)

        override fun onDescriptorWrite(
            g: BluetoothGatt,
            descriptor: BluetoothGattDescriptor,
            status: Int,
        ) {
            if (status != BluetoothGatt.GATT_SUCCESS) return failOpen("打不开蓝牙通知")
            notifyReady = true
            handshake.start().forEach { enqueue(it.bytes) }
        }

        override fun onCharacteristicWrite(
            g: BluetoothGatt,
            ch: BluetoothGattCharacteristic,
            status: Int,
        ) {
            writeInFlight = false
            if (status != BluetoothGatt.GATT_SUCCESS) return failOpen("蓝牙写入失败")
            drain()
        }

        @Suppress("DEPRECATION")
        override fun onCharacteristicChanged(g: BluetoothGatt, ch: BluetoothGattCharacteristic) {
            val value = ch.value ?: return
            buffer += value
            if (buffer.size > MAX_BUFFER) buffer = value
            when (val progress = handshake.onNotify(buffer)) {
                // Keep accumulating: the reply may still be on its way in pieces.
                BleProgress.Waiting -> Unit
                is BleProgress.Send -> {
                    reset()
                    progress.frames.forEach { enqueue(it.bytes) }
                }
                is BleProgress.Offered -> {
                    reset()
                    Diag.info(LogTag.NET, "BLE gave us ${progress.ssid} (pass=${progress.password?.length ?: 0}ch)")
                    result.complete(
                        BleOutcome.WifiOffered(
                            BleWifiOffer(
                                ssid = progress.ssid,
                                password = progress.password,
                                camera = camera,
                                expectedGateway = expectedGateway,
                            ),
                        ),
                    )
                }
                is BleProgress.Failed -> {
                    reset()
                    result.complete(BleOutcome.Failed(progress.message, progress.kind))
                }
            }
        }
    }

    /**
     * Pick the characteristic the camera actually talks on. These firmwares do not
     * advertise a stable service UUID, so — exactly like the official client — the
     * rule is "the last characteristic that has a CCCD, or the 8888 one".
     */
    private fun discover(g: BluetoothGatt) {
        if (characteristic != null || closed) return
        val all = g.services.flatMap { it.characteristics }
        val chosen = all.lastOrNull { c -> c.descriptors.any { it.uuid == CCCD } }
            ?: all.lastOrNull { it.uuid == XTU_CHAR }
            ?: all.firstOrNull { it.properties and BluetoothGattCharacteristic.PROPERTY_WRITE > 0 }
        if (chosen == null) {
            Diag.error(LogTag.NET, "no usable BLE characteristic on ${camera.name} (${g.services.size} services)")
            return failOpen("相机的蓝牙服务不认识")
        }
        characteristic = chosen
        enableNotifications(g, chosen)
    }

    @Suppress("DEPRECATION")
    private fun enableNotifications(g: BluetoothGatt, ch: BluetoothGattCharacteristic) {
        if (!runCatching { g.setCharacteristicNotification(ch, true) }.getOrDefault(false)) {
            return failOpen("打不开蓝牙通知")
        }
        val cccd = ch.getDescriptor(CCCD)
        if (cccd == null) {
            // Indicate-only characteristic: the camera may still talk, so try the
            // handshake instead of failing on a descriptor we cannot write.
            Diag.warn(LogTag.NET, "${ch.uuid} has no CCCD; proceeding on indications")
            notifyReady = true
            handshake.start().forEach { enqueue(it.bytes) }
            return
        }
        // The classic descriptor write still works on every API level we support and
        // is the only form that behaves the same on the Chinese stacks in the field.
        val written = runCatching {
            cccd.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            g.writeDescriptor(cccd)
        }.getOrDefault(false)
        if (!written) failOpen("写蓝牙描述符失败")
    }

    private fun enqueue(bytes: ByteArray) {
        if (closed) return
        writes.addLast(bytes)
        drain()
    }

    /** One write in flight; the stack advances us through onCharacteristicWrite. */
    @Suppress("DEPRECATION")
    private fun drain() {
        val g = gatt ?: return
        val ch = characteristic ?: return
        if (writeInFlight) return
        val next = writes.pollFirst() ?: return
        writeInFlight = true
        val ok = runCatching {
            ch.value = next
            g.writeCharacteristic(ch)
        }.getOrDefault(false)
        if (!ok) failOpen("蓝牙写入失败")
    }

    private fun failOpen(message: String) {
        if (result.isCompleted) return
        Diag.warn(LogTag.NET, "BLE ${camera.name}: $message (notify_ready=$notifyReady)")
        result.complete(BleOutcome.Failed(message))
    }

    private fun reset() {
        buffer = ByteArray(0)
    }

    fun closeNow() {
        closed = true
        if (!result.isCompleted) result.complete(BleOutcome.Failed("已取消"))
        runCatching { gatt?.disconnect() }
    }

    fun shutdown() {
        closed = true
        writes.clear()
        val g = gatt ?: return
        gatt = null
        runCatching { g.close() }
    }

    companion object {
        /** The official client asks for 512 too; a 20-byte MTU cannot carry a reply. */
        private const val MTU = 512
        private const val TICK_MS = 500L
        private const val MAX_BUFFER = 512
        private val CCCD: UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")
        private val XTU_CHAR: UUID = UUID.fromString("00008888-0000-1000-8000-00805f9b34fb")
    }
}
