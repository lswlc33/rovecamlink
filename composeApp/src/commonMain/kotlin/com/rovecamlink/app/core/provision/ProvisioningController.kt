package com.rovecamlink.app.core.provision

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import com.rovecamlink.app.AppGraph
import com.rovecamlink.app.Res
import com.rovecamlink.app.err_bluetooth_denied
import com.rovecamlink.app.err_bluetooth_off
import com.rovecamlink.app.err_bluetooth_unsupported
import com.rovecamlink.app.label_bluetooth_none
import com.rovecamlink.app.localized
import com.rovecamlink.app.raw
import com.rovecamlink.app.LocalizedString
import com.rovecamlink.app.core.ble.BleCamera
import com.rovecamlink.app.core.ble.BleCameraProfile
import com.rovecamlink.app.core.ble.BleOutcome
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * The Bluetooth half of "tap and it connects", kept out of [com.rovecamlink.app.AppState]
 * so the connection screen has one obvious owner for BLE state and the state machine
 * stays testable without a phone.
 *
 * What it does: scan for cameras, wake the one the user picked, and hand the hotspot
 * it reported to [onCredentials] — which is the same entry point the Wi-Fi list uses.
 * What it never does: touch the network itself.
 */
class ProvisioningController(
    private val graph: AppGraph,
    private val scope: CoroutineScope,
    private val onCredentials: (ssid: String, password: String?) -> Unit,
    private val onStage: (String) -> Unit,
    /** Called when Bluetooth cannot deliver, so the Wi-Fi list still gets filled. */
    private val onFallback: () -> Unit = {},
) {
    /** Cameras seen over BLE, strongest signal first. */
    val cameras = mutableStateListOf<BleCamera>()

    var busy by mutableStateOf(false)
        private set

    /** True once a scan has actually run, so "nothing found" never shows before the first search. */
    var scanned by mutableStateOf(false)
        private set

    /** Any message worth showing: permission denied, adapter off, camera silent. */
    var notice by mutableStateOf<LocalizedString?>(null)
        private set

    fun supported(): Boolean = graph.ble.isAvailable

    /** True once this camera has accepted a code from us — the tap is then silent. */
    fun isPaired(camera: BleCamera): Boolean = graph.pairingKeys.keyFor(camera.name) != null

    /**
     * Scan for cameras over BLE. Every way this can fail produces a [notice] rather
     * than an empty list, because "nothing found" and "you denied Bluetooth" look
     * identical to the user otherwise.
     */
    fun scan() {
        if (!supported()) {
            notice = localized(Res.string.err_bluetooth_unsupported)
            onFallback()
            return
        }
        notice = null
        busy = true
        onStage("ble-scan")
        scope.launch {
            try {
                if (!graph.ble.ensurePermissions()) {
                    notice = localized(Res.string.err_bluetooth_denied)
                    return@launch
                }
                if (!graph.ble.isAdapterEnabled()) {
                    notice = localized(Res.string.err_bluetooth_off)
                    onFallback()
                    return@launch
                }
                cameras.clear()
                scanned = true
                val found = graph.ble.scan(graph.bleProfiles) { latest ->
                    cameras.clear()
                    cameras.addAll(latest)
                }
                Diag.i(LogTag.APP) { "BLE scan returned ${found.size} camera(s)" }
                if (found.isEmpty()) {
                    notice = localized(Res.string.label_bluetooth_none)
                    onFallback()
                }
            } finally {
                busy = false
                onStage("")
            }
        }
    }

    /**
     * Wake [camera] and take its hotspot. The first time we meet a camera this
     * offers the code it remembered for this camera, or invents a fresh one —
     * the camera takes it without any prompt, exactly like the official app.
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

    private fun handshake(camera: BleCamera, profile: BleCameraProfile, code: String?) {
        busy = true
        onStage("ble-wake")
        scope.launch {
            val outcome = graph.ble.wakeAndFetch(camera, profile, code)
            busy = false
            onStage("")
            when {
                outcome is BleOutcome.WifiOffered -> {
                    Diag.i(LogTag.APP) {
                        "BLE offered ${outcome.offer.ssid} " +
                            "(gateway=${outcome.offer.expectedGateway ?: "-"})"
                    }
                    onCredentials(outcome.offer.ssid, outcome.offer.password)
                }
                outcome is BleOutcome.Failed -> notice = raw(outcome.message)
                else -> notice = localized(Res.string.err_bluetooth_unsupported)
            }
        }
    }
}
