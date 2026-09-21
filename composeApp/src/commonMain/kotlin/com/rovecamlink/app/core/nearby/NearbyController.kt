package com.rovecamlink.app.core.nearby

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.rovecamlink.app.AppGraph
import com.rovecamlink.app.LocalizedString
import com.rovecamlink.app.Res
import com.rovecamlink.app.err_bluetooth_off
import com.rovecamlink.app.err_bluetooth_unsupported
import com.rovecamlink.app.err_scan_needs_location
import com.rovecamlink.app.raw
import com.rovecamlink.app.localized
import com.rovecamlink.app.core.ble.BleCamera
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.wifi.CameraNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * The two radio lists the connection screen shows: cameras advertising over
 * Bluetooth LE, and camera hotspots in Wi-Fi range.
 *
 * The user's complaint this answers is that picking a camera used to take four taps
 * and a guess. Both lists now refresh on their own, so the one tap left is 连接:
 *
 *  - **Bluetooth keeps one scan running** rather than starting and stopping one per
 *    refresh ([com.rovecamlink.app.core.ble.BleCentral.startScan] says why: the
 *    2-second gaps are where advertisements get missed).
 *  - **Wi-Fi is re-read every cycle** and a *real* `startScan()` is only requested
 *    on the platform's own cadence, because Android answers `false` when it is
 *    rate-limiting us — the 2026-09-21 field log shows two requests three seconds
 *    apart both refused, which would otherwise look like a frozen list.
 *
 * It only observes. What to do with a candidate is [com.rovecamlink.app.AppState]'s
 * decision, and the Bluetooth handshake is
 * [com.rovecamlink.app.core.provision.ProvisioningController]'s.
 */
class NearbyController(
    private val graph: AppGraph,
    private val scope: CoroutineScope,
) {
    /** Cameras seen over BLE, strongest signal first. */
    var bluetooth by mutableStateOf<List<BleCamera>>(emptyList())
        private set

    /** Camera-like hotspots in range, strongest signal first. */
    var networks by mutableStateOf<List<CameraNetwork>>(emptyList())
        private set

    /** True while the first cycle is still gathering, so the UI can say 搜索中. */
    var searching by mutableStateOf(false)
        private set

    /** Monotonic millis of the last completed cycle — the "x 秒前" stamp. */
    var lastUpdateAt by mutableStateOf(0L)
        private set

    /** Anything worth saying out loud: adapter off, permission denied, nothing found. */
    var notice by mutableStateOf<LocalizedString?>(null)
        private set

    private var loop: Job? = null
    private var permissionsAsked = false
    private var nudge = false

    val hasCandidate: Boolean get() = bluetooth.isNotEmpty() || networks.isNotEmpty()

    /** The camera to reach by default: the strongest signal the phone can see. */
    fun bestBluetooth(): BleCamera? = bluetooth.firstOrNull()
    fun bestNetwork(): CameraNetwork? = networks.firstOrNull()

    /** Begin the refresh loop. Safe to call on every recomposition; only one runs. */
    fun start() {
        if (loop?.isActive == true) return
        searching = true
        loop = scope.launch {
            runCatching { cycle() }
                .onFailure { Diag.error(LogTag.APP, "nearby loop died ${Diag.causeChain(it)}") }
        }
    }

    /** Stop scanning: called when a session is up or the screen goes away. */
    fun stop() {
        loop?.cancel()
        loop = null
        searching = false
        graph.ble.stopScan()
    }

    /**
     * One tap on 刷新. Speeds the loop up to its fast cadence and re-asks for
     * permissions, because the most common reason for an empty list is that the
     * user has just switched Wi-Fi/location/BT on in system settings.
     */
    fun refreshNow() {
        nudge = true
        permissionsAsked = false
        if (loop?.isActive != true) start()
    }

    private suspend fun cycle() {
        val allowed = permissions()
        if (allowed) startBluetoothScan()
        while (true) {
            val started = Diag.uptimeMillis()
            if (allowed) {
                readWifi(force = nudge)
                publishBluetooth()
            }
            lastUpdateAt = Diag.uptimeMillis()
            searching = false
            val wait = if (nudge) FAST_CYCLE_MS else CYCLE_MS
            nudge = false
            // Slice the wait so 刷新 interrupts a cycle in flight instead of queueing
            // behind it — the user reads a two-second delay as the button not working.
            val deadline = started + wait
            while (Diag.uptimeMillis() < deadline && !nudge) delay(SLICE_MS)
        }
    }

    /**
     * Ask once per visit, never once per cycle: an Android permission dialog
     * re-requested every two seconds either stacks dialogs or silently flips to
     * "never ask again", and both are worse than the notice this app shows instead.
     */
    private suspend fun permissions(): Boolean {
        if (permissionsAsked) return allowed
        permissionsAsked = true
        val wifi = runCatching { graph.permissions.ensureWifiPermissions() }.getOrDefault(false)
        val ble = runCatching { graph.ble.ensurePermissions() }.getOrDefault(false)
        allowed = wifi || ble
        Diag.info(LogTag.PERM, "nearby permissions wifi=$wifi ble=$ble")
        notice = when {
            !wifi -> localized(Res.string.err_scan_needs_location)
            !ble && graph.ble.isAvailable && !graph.ble.isAdapterEnabled() ->
                localized(Res.string.err_bluetooth_off)
            else -> null
        }
        return allowed
    }

    private var allowed = false

    private fun startBluetoothScan() {
        if (!graph.ble.isAvailable) return
        if (!graph.ble.isAdapterEnabled()) {
            notice = localized(Res.string.err_bluetooth_off)
            return
        }
        if (!graph.ble.startScan(graph.bleProfiles)) {
            notice = localized(Res.string.err_bluetooth_unsupported)
        }
    }

    private suspend fun readWifi(force: Boolean) {
        val found = runCatching { graph.scanner.scan(force = force) }
            .onFailure { Diag.w(LogTag.WIFI) { "nearby wifi scan threw ${Diag.causeChain(it)}" } }
            .getOrDefault(emptyList())
        networks = found
        if (found.isNotEmpty()) notice = null
    }

    private fun publishBluetooth() {
        val seen = graph.ble.scannedCameras()
        if (seen != bluetooth) {
            bluetooth = seen
            Diag.info(LogTag.NET, "nearby: BLE ${seen.joinToString(",") { c -> "${c.name}(${c.rssi})" }.ifEmpty { "-" }}")
        }
    }

    companion object {
        /** The cadence the connection screen refreshes at, per the user's spec. */
        private const val CYCLE_MS = 2_000L

        /** While 刷新 is held down / just tapped, poll this often instead. */
        private const val FAST_CYCLE_MS = 500L

        private const val SLICE_MS = 150L
    }
}
