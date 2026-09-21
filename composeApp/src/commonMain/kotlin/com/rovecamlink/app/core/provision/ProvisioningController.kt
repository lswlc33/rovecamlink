package com.rovecamlink.app.core.provision

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.rovecamlink.app.AppGraph
import com.rovecamlink.app.LocalizedString
import com.rovecamlink.app.Res
import com.rovecamlink.app.err_bluetooth_denied
import com.rovecamlink.app.err_bluetooth_off
import com.rovecamlink.app.err_bluetooth_unsupported
import com.rovecamlink.app.raw
import com.rovecamlink.app.localized
import com.rovecamlink.app.core.ble.BleCamera
import com.rovecamlink.app.core.ble.BleCameraProfile
import com.rovecamlink.app.core.ble.BleOutcome
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * The Bluetooth half of "tap and it connects", kept out of [com.rovecamlink.app.AppState]
 * so the connection screen has one obvious owner for GATT state and the connection
 * state machine stays testable without a phone.
 *
 * What it does: run the handshake for the camera it is handed, and give the hotspot
 * that camera opened to [onCredentials] — the same entry point the Wi-Fi list uses,
 * so there is one join path and two ways to learn what to join.
 * What it does not do: scan (see
 * [com.rovecamlink.app.core.nearby.NearbyController]) or touch the network itself.
 *
 * Every failure arrives as a [notice] rather than silence, because "nothing was
 * found" and "you denied Bluetooth" look identical to the user otherwise.
 */
class ProvisioningController(
    private val graph: AppGraph,
    private val scope: CoroutineScope,
    private val onCredentials: (ssid: String, password: String?) -> Unit,
    private val onStage: (stage: String) -> Unit,
) {
    var busy by mutableStateOf(false)
        private set

    /** Any message worth showing: permission denied, adapter off, camera silent. */
    var notice by mutableStateOf<LocalizedString?>(null)
        private set

    fun supported(): Boolean = graph.ble.isAvailable

    /** True once this camera has accepted a code from us — the next tap is silent. */
    fun isPaired(camera: BleCamera): Boolean = graph.pairingKeys.keyFor(camera.name) != null

    /**
     * Wake [camera] and take its hotspot. The first time we meet a camera this offers
     * the code it remembered for that camera, or invents a fresh one — the camera
     * takes it without any prompt, exactly like the official app, which generates
     * `%04d(System.currentTimeMillis() % 10000)` on the phone and only ever *displays*
     * it (`DeviceAddDeviceListFragment.java:458`, `DeviceAddSetKeyFragment.java:64-67`).
     */
    fun connect(camera: BleCamera) {
        notice = null
        val profile = graph.bleProfileFor(camera.profileId)
        if (profile == null) {
            notice = raw("No Bluetooth profile for ${camera.name}")
            return
        }
        handshake(camera, profile, graph.pairingKeys.keyFor(camera.name))
    }

    /** Give up on the in-flight handshake (user tapped 取消, or we are connecting another way). */
    fun cancel() {
        if (!busy) return
        graph.ble.abort()
    }

    private fun handshake(camera: BleCamera, profile: BleCameraProfile, code: String?) {
        busy = true
        onStage("ble-wake")
        scope.launch {
            val outcome = runCatching { graph.ble.wakeAndFetch(camera, profile, code) }
                .onFailure { Diag.error(LogTag.NET, "BLE wake threw ${Diag.causeChain(it)}") }
                .getOrElse { BleOutcome.Failed("蓝牙握手异常：${it.message ?: it::class.simpleName}") }
            busy = false
            onStage("")
            when {
                outcome is BleOutcome.WifiOffered -> {
                    val offer = outcome.offer
                    val password = offer.password ?: graph.wifiCredentials.passwordFor(offer.ssid)
                    Diag.i(LogTag.APP) {
                        "BLE offered ${offer.ssid} (pass=${password?.let { "${it.length}ch" } ?: "none"} " +
                            "gateway=${offer.expectedGateway ?: "-"})"
                    }
                    // Remember what the camera volunteered: the next connect over the
                    // Wi-Fi list needs no Bluetooth at all.
                    if (!password.isNullOrEmpty()) graph.wifiCredentials.remember(offer.ssid, password)
                    onCredentials(offer.ssid, password)
                }
                outcome is BleOutcome.BluetoothOff -> notice = localized(Res.string.err_bluetooth_off)
                outcome is BleOutcome.PermissionsDenied -> notice = localized(Res.string.err_bluetooth_denied)
                outcome is BleOutcome.Unsupported -> notice = localized(Res.string.err_bluetooth_unsupported)
                outcome is BleOutcome.Failed -> notice = raw(outcome.message)
                else -> notice = localized(Res.string.err_bluetooth_unsupported)
            }
        }
    }
}
