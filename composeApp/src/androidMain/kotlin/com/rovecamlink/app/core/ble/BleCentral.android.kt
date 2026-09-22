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
import kotlinx.coroutines.CoroutineScope
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

    override fun startScan(profiles: List<BleCameraProfile>): Boolean {
        val bt = adapter ?: return false
        if (!bt.isEnabled) {
            Diag.info(LogTag.NET, "BLE scan refused: adapter is off")
            return false
        }
        val scanner = bt.bluetoothLeScanner ?: run {
            Diag.error(LogTag.NET, "BLE scan refused: no BluetoothLeScanner on this device")
            return false
        }
        synchronized(scanLock) {
            if (scanCallback != null) return true
            val callback = object : ScanCallback() {
                override fun onScanResult(callbackType: Int, result: ScanResult) = ingest(result)

                override fun onBatchScanResults(results: MutableList<ScanResult>) {
                    results.forEach { ingest(it) }
                }

                override fun onScanFailed(errorCode: Int) {
                    // 2 == SCAN_FAILED_ALREADY_STARTED, which for us means an earlier
                    // scan is still registered and results are still arriving.
                    if (errorCode == 2) {
                        Diag.debug(LogTag.NET, "BLE startScan reported ALREADY_STARTED")
                        return
                    }
                    Diag.error(LogTag.NET, "BLE scan failed code=$errorCode (adapter busy, or permission revoked)")
                    synchronized(scanLock) { if (scanCallback === this) scanCallback = null }
                }

                private fun ingest(result: ScanResult) {
                    val device = result.device ?: return
                    // device.name needs BLUETOOTH_CONNECT and is null without it far too
                    // often to be the only source, so the raw advertisement is the fallback.
                    val name = runCatching { device.name }.getOrNull()
                        ?: result.scanRecord?.deviceName
                        ?: return
                    val profile = profiles.firstOrNull { it.matches(name) } ?: return
                    remember(
                        // The pair is keyed by name, so a firmware that rotates its
                        // address still reads as the same camera.
                        name,
                        BleCamera(runCatching { device.address }.getOrNull() ?: "", name, result.rssi, profile.id),
                    )
                }
            }
            val started = runCatching {
                scanner.startScan(
                    null,
                    ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build(),
                    callback,
                )
            }.isSuccess
            if (!started) {
                Diag.error(LogTag.NET, "BLE startScan threw; permission revoked or adapter busy")
                return false
            }
            scanCallback = callback
            Diag.info(LogTag.NET, "BLE scan started (LOW_LATENCY, names ${profiles.joinToString(",") { p -> p.namePrefixes.joinToString("/") }})")
            return true
        }
    }

    override fun scannedCameras(): List<BleCamera> {
        val now = monotonicMillis()
        return synchronized(scanLock) {
            seen.entries.filter { now - it.value.second <= BleCentral.STALE_AFTER_MS }
                .map { it.value.first }
                .sortedByDescending { it.rssi }
        }
    }

    override fun stopScan() {
        val scanner = adapter?.bluetoothLeScanner
        synchronized(scanLock) {
            val cb = scanCallback ?: return
            scanCallback = null
            runCatching { scanner?.stopScan(cb) }
                .onFailure { Diag.debug(LogTag.NET, "BLE stopScan threw ${Diag.causeChain(it)}") }
        }
    }

    override fun clearScanResults() {
        synchronized(scanLock) { seen.clear() }
    }

    /** Record one advertisement, keeping the strongest signal seen for this name. */
    private fun remember(name: String, camera: BleCamera) {
        synchronized(scanLock) {
            val previous = seen[name]
            val best = if (previous != null && previous.first.rssi >= camera.rssi) previous.first else camera
            // lastSeen always moves forward: a weaker report is still proof the
            // camera is in range, and dropping it would blink the row off the list.
            seen[name] = best to monotonicMillis()
        }
    }

    override fun abort() {
        active?.closeNow()
    }

    private val scanLock = Any()

    /** name → (camera, monotonic time of its last advertisement). Guarded by [scanLock]. */
    private val seen = LinkedHashMap<String, Pair<BleCamera, Long>>()

    @Volatile private var scanCallback: ScanCallback? = null
}

/** API 31+ has the runtime BLUETOOTH pair; below that scanning rides on location. */
private fun blePermissions(): Array<String> =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        arrayOf(Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT)
    } else {
        arrayOf(Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN)
    }

/**
 * Log-safe form of a notification: the keys and the shape stay, the passphrase
 * becomes its length. The diagnostics TXT leaves the phone through a share sheet,
 * and `PWD=` is the one field in the whole handshake that grants network access.
 */
private fun maskPassphrase(text: String): String =
    text.replace(Regex("PWD=([^,]*)")) { "PWD=<${it.groupValues[1].length}ch>" }

actual fun createBleCentral(): BleCentral = AndroidBleCentral()

/**
 * One GATT connection driving one [BleHandshake].
 *
 * The firmware is unforgiving about ordering, and every rule here came from the
 * official client: connect → **`discoverServices()`** → pick the characteristic →
 * enable notifications (CCCD written) → only then `requestMtu(512)` → write.
 * Writes are serialised (one in flight, advanced by `onCharacteristicWrite`), and a
 * reply can arrive split over two notifications because the MTU exchange has not
 * settled when the first one lands.
 *
 * The `discoverServices()` step is not optional and was the reason Bluetooth
 * provisioning never sent a single byte: the 2026-09-22 field log reads
 * `BLE mtu=512 status=0` followed by `no usable BLE characteristic: 0 services`
 * ten times out of ten. `BluetoothGatt.getServices()` is a *cache* that Android only
 * fills from the `discoverServices()` round-trip, so reading it after the MTU
 * exchange (as this class used to) always saw an empty table and gave up before
 * writing `R003_`.
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

    /** Captured in [run] so a GATT callback can schedule a delayed retry. */
    @Volatile private var scope: CoroutineScope? = null

    @Volatile private var gatt: BluetoothGatt? = null
    @Volatile private var characteristic: BluetoothGattCharacteristic? = null
    @Volatile private var writeInFlight = false
    @Volatile private var notifyReady = false
    @Volatile private var started = false
    @Volatile private var closed = false
    @Volatile private var discoveryAttempts = 0

    suspend fun run(timeoutMs: Long): BleOutcome = coroutineScope {
        scope = this
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
                BluetoothProfile.STATE_CONNECTED -> {
                    if (status != BluetoothGatt.GATT_SUCCESS) {
                        return failOpen("蓝牙链路建立失败（status=$status）")
                    }
                    Diag.debug(LogTag.NET, "BLE linked ${camera.name}, discovering services")
                    discover(g)
                }
                BluetoothProfile.STATE_DISCONNECTED -> failOpen("蓝牙连接中断")
            }
        }

        override fun onMtuChanged(g: BluetoothGatt, mtu: Int, status: Int) {
            Diag.debug(LogTag.NET, "BLE mtu=$mtu status=$status")
            // The MTU no longer gates discovery — it used to, which is how the empty
            // service table went unnoticed. It only releases the first write, and the
            // settle timer covers a stack that never reports back.
            later(SETTLE_MS) { beginHandshake() }
        }

        override fun onServicesDiscovered(g: BluetoothGatt, status: Int) = discovered(g, status)

        override fun onDescriptorWrite(
            g: BluetoothGatt,
            descriptor: BluetoothGattDescriptor,
            status: Int,
        ) {
            if (status != BluetoothGatt.GATT_SUCCESS) return failOpen("打不开蓝牙通知")
            notifyReady = true
            armMtuAndStart(g)
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
            // Log what the camera actually said before we interpret it. Every field of
            // the XTU handshake has been re-derived from the APK at least once, and the
            // one thing the APK cannot answer is what *this* firmware replies with —
            // so the raw notification, passphrase masked, has to be in the log we get
            // back from a failed field test.
            Diag.info(
                LogTag.NET,
                "BLE notify ${camera.name} stage=${handshake.stage()} " +
                    "len=${value.size} ${maskPassphrase(decodeBlePayload(value))}",
            )
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
     * Ask the stack what the camera exposes. Every answer arrives through
     * [onServicesDiscovered]; a stack that refuses the call outright is retried here
     * so a single `false` cannot end the handshake.
     */
    private fun discover(g: BluetoothGatt) {
        if (characteristic != null || closed) return
        discoveryAttempts++
        val requested = runCatching { g.discoverServices() }.getOrDefault(false)
        Diag.debug(LogTag.NET, "BLE discoverServices #$discoveryAttempts requested=$requested")
        if (requested) return
        if (discoveryAttempts >= MAX_DISCOVERY_ATTEMPTS) return failOpen("读不到相机的蓝牙服务")
        later(DISCOVERY_RETRY_MS) { gatt?.let { discover(it) } }
    }

    /**
     * Handle one discovery result: pick the characteristic the camera actually talks
     * on, then enable notifications on it.
     *
     * An empty table is retried rather than fatal. Android caches the GATT table per
     * peer, and a cache left stale by an earlier attempt (or a peripheral that only
     * allows one central and was still being held) answers status 0 with zero
     * services — the official client's own reconnect loop is the reason that shape is
     * survivable.
     *
     * The command channel is `00008888` — `BluetoothConnector.java:242` asks for
     * exactly `getService(0000180a).getCharacteristic(00008888)`, and `8888` is the
     * only hard-coded characteristic UUID in the whole APK. It is also what the live
     * data path uses, so it is the one place a real device reliably writes to.
     *
     * The order below is deliberately the *strict* version of the official
     * `BLEConnectUtils.java:541` test, which accepts "has a CCCD **or** is 8888" and
     * therefore lets the last characteristic of an unrelated service (battery,
     * device-info) win the race on a full GATT table — `DeviceAddWaveFragment.java:285`
     * is the same app's own corrected **and** test. We try 8888 first, and only fall
     * back to a CCCD-bearing writable characteristic when the camera does not expose
     * it, which is what an earlier version of this file assumed was normal.
     */
    private fun discovered(g: BluetoothGatt, status: Int) {
        if (characteristic != null || closed) return
        val all = g.services.flatMap { it.characteristics }
        Diag.debug(
            LogTag.NET,
            "BLE services status=$status services=${g.services.size} chars=" +
                all.joinToString(",") { c -> "${c.uuid}:0x${c.properties.toString(16)}" },
        )
        val writable = BluetoothGattCharacteristic.PROPERTY_WRITE or
            BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE
        fun hasCccd(c: BluetoothGattCharacteristic) = c.descriptors.any { it.uuid == CCCD }
        val chosen = all.lastOrNull { it.uuid == XTU_CHAR && hasCccd(it) }
            ?: all.firstOrNull { it.uuid == XTU_CHAR }
            ?: all.lastOrNull { hasCccd(it) && it.properties and writable > 0 }
            ?: all.lastOrNull { hasCccd(it) }
            ?: all.firstOrNull { it.properties and writable > 0 }
        if (chosen == null) {
            if (discoveryAttempts < MAX_DISCOVERY_ATTEMPTS) {
                Diag.warn(
                    LogTag.NET,
                    "BLE ${camera.name}: nothing usable after $discoveryAttempts discovery round(s) " +
                        "(${g.services.size} services), discovering again",
                )
                later(DISCOVERY_RETRY_MS) { gatt?.let { discover(it) } }
                return
            }
            Diag.error(
                LogTag.NET,
                "no usable BLE characteristic on ${camera.name}: ${g.services.size} services, " +
                    "chars=${all.joinToString(",") { c -> "${c.uuid}:${c.properties}" }}",
            )
            return failOpen("相机的蓝牙服务不认识")
        }
        Diag.info(
            LogTag.NET,
            "BLE command channel = ${chosen.uuid} (write=0x${chosen.properties.toString(16)}, " +
                "cccd=${chosen.descriptors.any { it.uuid == CCCD }}) of ${g.services.size} services",
        )
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
            armMtuAndStart(g)
            return
        }
        // The classic descriptor write still works on every API level we support and
        // is the only form that behaves the same on the Chinese stacks in the field.
        val written = runCatching {
            cccd.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            g.writeDescriptor(cccd)
        }.getOrDefault(false)
        if (!written) return failOpen("写蓝牙描述符失败")
        // Some stacks complete the write without ever calling us back; without this
        // the session would sit silent until the caller's 25 s budget expired.
        later(NOTIFY_CONFIRM_TIMEOUT_MS) {
            if (!notifyReady) {
                Diag.warn(LogTag.NET, "BLE ${camera.name}: no CCCD write callback, assuming notifications are on")
                notifyReady = true
                gatt?.let { armMtuAndStart(it) }
            }
        }
    }

    /**
     * Official order: MTU is raised only once notifications are on, and the first
     * command waits for the link to settle — a 20-byte MTU cannot carry an `R001_`
     * reply, and commands written during the exchange are dropped.
     */
    private fun armMtuAndStart(g: BluetoothGatt) {
        if (!runCatching { g.requestMtu(MTU) }.getOrDefault(false)) {
            Diag.debug(LogTag.NET, "BLE requestMtu($MTU) refused; writing at the current MTU")
        }
        later(SETTLE_MS) { beginHandshake() }
    }

    /** Send the first handshake frame exactly once, from whichever event lands first. */
    private fun beginHandshake() {
        if (started || closed || !notifyReady) return
        started = true
        handshake.start().forEach { enqueue(it.bytes) }
    }

    private fun later(ms: Long, block: () -> Unit) {
        scope?.launch {
            delay(ms)
            if (!closed) block()
        }
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
        // Writing before the CCCD is settled is how the official client reports
        // "connected but the camera never answers": keep the queue and let
        // [beginHandshake] release it.
        if (!notifyReady || writeInFlight) return
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

        /**
         * How long to hold the first command back after the MTU exchange, matching the
         * official client's `postDelayed(…, 300L)` before its first write.
         */
        private const val SETTLE_MS = 300L

        /** A GATT table this empty is a stale cache, so try again before giving up. */
        private const val DISCOVERY_RETRY_MS = 400L
        private const val MAX_DISCOVERY_ATTEMPTS = 3

        /** A stack that completes the CCCD write without calling us back. */
        private const val NOTIFY_CONFIRM_TIMEOUT_MS = 2_000L

        private val CCCD: UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")
        private val XTU_CHAR: UUID = UUID.fromString("00008888-0000-1000-8000-00805f9b34fb")
    }
}
