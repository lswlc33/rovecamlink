package com.rovecamlink.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.graphics.ImageBitmap
import com.rovecamlink.app.brand.xtu.HisiliconOtaTransport
import com.rovecamlink.app.core.model.CameraMode
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceEvent
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.ModeFamily
import com.rovecamlink.app.core.model.ModeTrigger
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.model.workMode
import com.rovecamlink.app.core.nearby.NearbyController
import com.rovecamlink.app.core.ota.OtaCoordinator
import com.rovecamlink.app.core.ota.OtaState
import com.rovecamlink.app.core.ota.pickCameraFirmwarePackage
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.OpContext
import com.rovecamlink.app.core.protocol.CameraProtocol
import com.rovecamlink.app.core.provision.ProvisioningController
import com.rovecamlink.app.core.storage.sanitizeFileName
import com.rovecamlink.app.core.wifi.CameraNetwork
import com.rovecamlink.app.core.wifi.DEFAULT_PREFIXES
import com.rovecamlink.app.core.wifi.WifiResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okio.Path
import org.jetbrains.compose.resources.decodeToImageBitmap

/** High-level connection lifecycle phase, surfaced in the UI. */
enum class Phase {
    Idle,
    ScanningWifi,

    /** Looking for cameras over Bluetooth LE. */
    ScanningBle,

    /** Connected over BLE; waiting for the camera to open its hotspot. */
    WakingAp,
    ConnectingWifi,
    IdentifyingDevice,
    ConnectingProtocol,
    SyncingTime,
    Connected,
    Error,
}

/** A discrete user/system operation so the UI can grey out only the relevant control. */
enum class Op { Capture, Record, Mode, Refresh, Delete, Settings, FormatSd, FactoryReset, Reboot, DeviceInfo }

/** Download queue entry. */
data class DownloadItem(
    val file: RemoteFile,
    val progress: Float = 0f,
    val state: State = State.Queued,
    val localPath: String? = null,
    val error: LocalizedString? = null,
) {
    enum class State { Queued, Running, Done, Failed }
}

/**
 * Central observable state + orchestration. One instance for the app.
 * All long-running work is launched on [scope].
 */
class AppState(private val graph: AppGraph, private val scope: CoroutineScope) {

    var phase by mutableStateOf(Phase.Idle)
        private set

    /** Whether the full-screen diagnostics/log preview is showing. */
    var diagnosticsOpen by mutableStateOf(false)
        private set

    /** Last phase, kept only so a transition line can say where we came from. */
    private var lastPhase: Phase = Phase.Idle

    /** Move to [next] and record the transition; phases are the connection timeline. */
    private fun goPhase(next: Phase) {
        if (lastPhase == next) return
        val prev = lastPhase
        lastPhase = next
        phase = next
        Diag.at(
            if (next == Phase.Error) LogLevel.WARN else LogLevel.INFO, LogTag.APP,
            "PHASE $prev -> $next",
        )
    }

    fun openDiagnostics() {
        refreshDiagnosticsEnv()
        diagnosticsOpen = true
        Diag.at(LogLevel.INFO, LogTag.LOG, "preview opened")
    }

    fun closeDiagnostics() {
        diagnosticsOpen = false
    }

    var statusMessage by mutableStateOf<LocalizedString?>(null)
        private set
    var errorMessage by mutableStateOf<LocalizedString?>(null)

    /**
     * Hotspot the user has to type a passphrase for. Set by
     * [connectNearby] when the strongest camera in range is WPA-protected and we
     * have neither a Bluetooth report nor a saved credential for it; the connection
     * screen turns it into a password row, and clearing it is the screen's job.
     */
    var askPasswordFor by mutableStateOf<CameraNetwork?>(null)

    /** SSID the phone is joined to right now, when the platform will tell us. */
    val currentWifiSsid: String? get() = graph.wifi.currentCameraSsid()

    /**
     * Whether the phone's default network is a VPN tunnel while we talk to the
     * camera. Camera traffic then survives only because sockets are pinned to the
     * Wi-Fi network (see core.wifi.adoptCurrentNetwork / requestNetwork), so the UI
     * can say that out loud instead of letting "no camera found" look like a bug.
     */
    var vpnActive by mutableStateOf(false)
        private set

    var session by mutableStateOf<CameraSession?>(null)
        private set
    var deviceStatus by mutableStateOf<DeviceStatus?>(null)
        private set
    var deviceInfo by mutableStateOf<DeviceInfo?>(null)
        private set
    var otaState by mutableStateOf<OtaState>(OtaState.Idle)
        private set

    var settings by mutableStateOf<List<CameraSetting>>(emptyList())
        private set
    var files by mutableStateOf<List<RemoteFile>>(emptyList())
        private set

    /** Per-operation in-progress flags (so a disabled control can explain itself). */
    val busy = mutableStateListOf<Op>()

    val downloads = mutableStateListOf<DownloadItem>()

    /**
     * Decoded preview thumbnails keyed by [RemoteFile.name]. A present-but-null
     * entry means "fetched and failed" so we don't retry it every recomposition.
     */
    val thumbnails = mutableStateMapOf<String, ImageBitmap?>()
    private val thumbsInFlight = mutableSetOf<String>()

    /** Files whose thumbnail already failed once, so we stop retrying per refresh. */
    private val thumbFailed = mutableSetOf<String>()

    private var pollJob: Job? = null
    private var otaCoordinator: OtaCoordinator? = null

    /**
     * Bound to the live connection and cancelled on disconnect, so a refresh or
     * download started against a dead session can never write back into the UI.
     */
    private var sessionScope: CoroutineScope? = null
    private var consecutivePollFailures = 0
    private val protocol: CameraProtocol?
        get() = session?.let { graph.registry.protocolFor(it.platform) }

    init {
        // The export header has to describe the session, not just the phone, so the
        // logger asks this object instead of knowing about it.
        Diag.envProvider = { diagnosticsEnv() }
        Diag.at(LogLevel.INFO, LogTag.APP, "session start phase=${phase.name}")
        // A hotspot the user joined from system settings never passes through
        // connect(), so watch the default network and auto-discover camera SSIDs.
        graph.wifi.watchWifiChanges { ssid ->
            Diag.at(LogLevel.INFO, LogTag.WIFI, "default-network ssid changed to ${ssid ?: "(none)"}")
            refreshVpnState()
            if (ssid == null || session != null) return@watchWifiChanges
            if (phase != Phase.Idle && phase != Phase.Error) return@watchWifiChanges
            if (DEFAULT_PREFIXES.none { ssid.startsWith(it, ignoreCase = true) }) return@watchWifiChanges
            Diag.at(LogLevel.INFO, LogTag.APP, "AUTO-CONNECT on camera-like SSID $ssid")
            connect()
        }
    }

    /** Re-read whether a VPN owns the default route; cheap, called on wifi changes + connect. */
    private fun refreshVpnState() {
        val now = graph.wifi.isVpnActive()
        if (now != vpnActive) {
            vpnActive = now
            Diag.at(LogLevel.INFO, LogTag.NET, "VPN default route ${if (now) "ACTIVE (camera sockets stay pinned to Wi-Fi)" else "gone"}")
        }
    }

    /** Key/value lines describing the live session for the diagnostics header. */
    fun diagnosticsEnv(): List<Pair<String, String>> = envSnapshot

    /**
     * Cached on purpose: [buildDiagnosticsEnv] reads Compose snapshot state (`busy`,
     * `downloads`, `thumbnails`), which is unsafe to walk from the logger's writer
     * thread that builds the export. So the UI refreshes this snapshot and the logger
     * only ever reads the already-built list.
     */
    private var envSnapshot: List<Pair<String, String>> = emptyList()

    fun refreshDiagnosticsEnv() {
        envSnapshot = runCatching { buildDiagnosticsEnv() }
            .getOrElse { listOf("session_env_error" to (it.message ?: "?")) }
    }

    private fun buildDiagnosticsEnv(): List<Pair<String, String>> = buildList {
        add("session.phase" to phase.name)
        add("session.op_busy" to if (busy.isEmpty()) "none" else busy.joinToString(","))
        val s = session
        if (s == null) {
            add("camera" to "not connected")
        } else {
            add("camera.model" to s.model)
            add("camera.brand" to s.brand.displayName)
            add("camera.platform" to s.platform.displayName)
            add("camera.host" to "${s.host}:${s.port}")
            add("camera.session_extras" to s.extras.entries.joinToString(",") { (k, v) -> "$k=$v" })
            add("camera.preview_url" to (graph.registry.protocolFor(s.platform)?.previewUrl(s) ?: "-"))
            deviceInfo?.let {
                add("camera.firmware" to (it.softVersion ?: "-"))
                add("camera.hardware" to (it.hardVersion ?: "-"))
                add("camera.serial" to (it.serialNumber ?: "-"))
                add("camera.wifi_ssid" to (it.ssid ?: "-"))
            }
            deviceStatus?.let {
                add("camera.battery" to (it.battery?.toString() ?: "-"))
                add("camera.sd" to "${it.sdState} free=${it.sdFreeMb}MB total=${it.sdTotalMb}MB")
                add("camera.recording" to it.recording.toString())
            }
        }
        add("wifi.bound" to graph.wifi.isConnectedToCamera.toString())
        add("wifi.current_ssid" to (graph.wifi.currentCameraSsid() ?: "-"))
        add("wifi.gateway" to (graph.wifi.gateway() ?: "-"))
        add("net.vpn" to graph.wifi.isVpnActive().toString())
        add("files" to "${files.size} listed, ${downloads.size} queued transfers, ${thumbnails.size} thumbs")
        add("ota" to otaState.toString())
    }

    /** Public accessor for the UI (e.g. to build the preview URL). */
    fun protocolOrNull(): CameraProtocol? = protocol

    fun isBusy(op: Op): Boolean = busy.contains(op)
    private fun setBusy(op: Op, on: Boolean) {
        if (on && !busy.contains(op)) busy.add(op)
        if (!on) busy.remove(op)
    }

    // ---------- WiFi + discovery ----------

    /**
     * Bluetooth provisioning: wake the camera's hotspot and get the credentials. It
     * owns its own observable state so the connection screen can show what Bluetooth
     * is doing without the session state machine having to learn about GATT. When it
     * succeeds it feeds the same [connect] entry point the Wi-Fi list uses.
     */
    val provisioning = ProvisioningController(
        graph = graph,
        scope = scope,
        onCredentials = { ssid, password -> connect(ssid, password) },
        onStage = { stage ->
            when (stage) {
                "ble-wake" -> {
                    goPhase(Phase.WakingAp)
                    statusMessage = localized(Res.string.status_waking_camera)
                }
                else -> if (phase == Phase.WakingAp) {
                    // The Bluetooth step is over (often because it could not start);
                    // leaving "正在唤醒相机" on screen would read as still working.
                    goPhase(Phase.Idle)
                    statusMessage = null
                }
            }
        },
    )

    /**
     * What is in range: camera advertisements over Bluetooth and camera hotspots over
     * Wi-Fi, re-read on their own every couple of seconds while the device tab is
     * open. Discovery is no longer a button the user has to find — see
     * [com.rovecamlink.app.core.nearby.NearbyController].
     */
    val nearby = NearbyController(graph, scope)

    /** The camera-like hotspot the phone is already joined to, when there is one. */
    val joinedCameraNetwork: String?
        get() = currentWifiSsid?.takeIf { ssid ->
            ssid.isNotBlank() && DEFAULT_PREFIXES.any { ssid.startsWith(it, ignoreCase = true) }
        }

    /**
     * The one tap of the connection screen. Reaches the best camera in range by the
     * cheapest route that can work, in the order the field evidence put things:
     *
     * 1. Already on a camera hotspot → never ask the system to rejoin it, adopt the
     *    network and talk. Re-requesting a network we are on is what made a join from
     *    system Settings look like a failure, and what let a VPN keep the route.
     * 2. A camera answering Bluetooth → Bluetooth wakes the hotspot and brings the
     *    passphrase back with it, so nothing is ever typed. Strongest signal wins.
     * 3. A camera hotspot we can already get into (saved or factory passphrase).
     * 4. A camera hotspot that needs a passphrase we do not have → ask for that one
     *    thing instead of failing with "找不到相机".
     */
    fun connectNearby() {
        errorMessage = null
        joinedCameraNetwork?.let {
            Diag.info(LogTag.APP, "CONNECT nearby: already on $it, adopting without a join")
            connect()
            return
        }
        val camera = nearby.bestBluetooth()
        if (camera != null && provisioning.supported() && !provisioning.busy) {
            Diag.info(LogTag.APP, "CONNECT nearby: BLE ${camera.name} (${camera.rssi}dBm)")
            provisioning.connect(camera)
            return
        }
        val network = nearby.bestNetwork()
        if (network != null) {
            val saved = graph.wifiCredentials.passwordFor(network.ssid)
            val factory = graph.registry.defaultPasswordFor(network.ssid)
            val passphrase = saved ?: factory.takeIf { network.secured }
            Diag.info(
                LogTag.APP,
                "CONNECT nearby: wifi ${network.ssid} secured=${network.secured} " +
                    "credential=${if (saved != null) "saved" else if (passphrase != null) "factory" else "none"}",
            )
            if (network.secured && passphrase == null) {
                askPasswordFor = network
                errorMessage = localized(Res.string.err_passphrase_needed, network.ssid)
            } else {
                connect(network.ssid, passphrase)
            }
            return
        }
        // Nothing in range: restart the search and say so, rather than leaving an
        // empty screen to be interpreted.
        nearby.refreshNow()
        errorMessage = localized(Res.string.err_no_camera_nearby)
    }

    /** Re-read both radios now — the 刷新 button. */
    fun refreshNearby() {
        askPasswordFor = null
        nearby.refreshNow()
    }

    /** Join a hotspot the user picked from the Wi-Fi list, with the passphrase they typed. */
    fun connectToNetwork(network: CameraNetwork, passphrase: String?) {
        askPasswordFor = null
        connect(network.ssid, passphrase)
    }

    /** True when we already hold a passphrase for [ssid], so the row needs no typing. */
    fun hasSavedPassword(ssid: String): Boolean = graph.wifiCredentials.passwordFor(ssid) != null

    /**
     * A row the user tapped in the Wi-Fi list. Open network or a passphrase we hold →
     * join it now; otherwise ask for that one thing. Bluetooth still wins for the
     * automatic path, because only it opens a hotspot that is switched off — this is
     * the manual route, taken when the user named the network themselves.
     */
    fun pickNetwork(network: CameraNetwork) {
        errorMessage = null
        val passphrase = graph.wifiCredentials.passwordFor(network.ssid)
            ?: graph.registry.defaultPasswordFor(network.ssid)
        when {
            !network.secured -> connectToNetwork(network, null)
            passphrase != null -> connectToNetwork(network, passphrase)
            else -> askPasswordFor = network
        }
    }

    fun scanWifi() = scope.launch {
        goPhase(Phase.ScanningWifi)
        errorMessage = null
        Diag.i(LogTag.APP) { "SCAN wifi begin" }
        // Scanning needs ACCESS_FINE_LOCATION on every API level (NEARBY_WIFI_DEVICES
        // alone is not enough for scan results). Without this the platform denies the
        // scan and we would silently report "no cameras".
        val granted = runCatching { graph.permissions.ensureWifiPermissions() }
            .getOrElse {
                Diag.at(LogLevel.ERROR, LogTag.PERM, "wifi permission request threw ${Diag.causeChain(it)}")
                goPhase(Phase.Idle)
                errorMessage = localized(Res.string.err_permission_ask_failed, it.message ?: "")
                return@launch
            }
        Diag.i(LogTag.PERM) { "wifi permissions granted=$granted" }
        if (!granted) {
            goPhase(Phase.Idle)
            errorMessage = localized(Res.string.err_scan_needs_location)
            return@launch
        }
        runCatching { graph.scanner.scan(force = true) }
            .onSuccess {
                Diag.i(LogTag.WIFI) {
                    "scan found ${it.size} camera-like networks: " +
                        it.joinToString(", ") { n -> "${n.ssid}(${n.rssi}dBm,${if (n.secured) "wpa" else "open"})" }
                        .ifEmpty { "-" }
                }
            }
            .onFailure {
                Diag.at(LogLevel.ERROR, LogTag.WIFI, "scan failed ${Diag.causeChain(it)}")
                errorMessage = localized(Res.string.err_scan_failed, it.message ?: "")
            }
        if (phase == Phase.ScanningWifi) goPhase(Phase.Idle)
    }

    /**
     * The one connect that is allowed to run. Starting a second connect must cancel
     * the first: `discover()` walks eight candidate gateways and each dead probe
     * costs two 8s timeouts, so the 2026-09-21 S7PRO session kept a stale walk
     * running for two whole minutes after the camera had already answered — it
     * threw 15 connect timeouts at the network while the live view was trying to
     * deliver frames.
     */
    private var connectJob: Job? = null

    /** When a control last changed the recording state locally; see [startPolling]. */
    private var localRecordFlipAt = 0L

    /** Full auto-connect: join WiFi (or use current), find device, pick protocol, connect. */
    fun connect(ssid: String? = null, password: String? = null, manualHost: String? = null) {
        connectJob?.cancel()
        val job = scope.launch {
            val op = "c${Diag.nextId()}:connect"
            withContext(OpContext(op)) { connectBlocking(ssid, password, manualHost) }
        }
        connectJob = job
        job.invokeOnCompletion { if (connectJob === job) connectJob = null }
    }

    private suspend fun connectBlocking(ssid: String?, password: String?, manualHost: String?) {
        errorMessage = null
        Diag.i { "CONNECT begin ssid=${ssid ?: "-"} manual_host=${manualHost ?: "-"} already_bound=${graph.wifi.isConnectedToCamera}" }
        try {
            // Pin our sockets to the Wi-Fi the phone is on *before* touching the
            // network. A hotspot joined from Settings never passed through
            // connect(), so without this every request follows the default route —
            // and when a VPN owns that route the camera simply stops existing.
            refreshVpnState()
            if (!graph.wifi.isConnectedToCamera) {
                when (val adopt = graph.wifi.adoptCurrentNetwork(force = manualHost != null)) {
                    is WifiResult.Connected ->
                        Diag.i(LogTag.WIFI) { "adopted the already-joined Wi-Fi (${adopt.ssid.ifEmpty { "unknown" }})" }
                    is WifiResult.Failed ->
                        Diag.d(LogTag.WIFI) { "no Wi-Fi adopted: ${adopt.message} (continuing on the default network)" }
                    WifiResult.Cancelled -> Unit
                }
            }
            var host = manualHost
            var port = 80
            if (host != null && host.contains(":")) {
                val parts = host.split(":")
                host = parts[0]
                port = parts[1].toIntOrNull() ?: 80
                Diag.d { "manual host parsed into host=$host port=$port" }
            }
            // Which brand this hotspot belongs to, when we recognise the name: gives
            // discovery a first address to try instead of walking nine candidates.
            val knownSsid = ssid ?: currentWifiSsid
            val preferredHost = manualHost?.substringBefore(':') ?: graph.registry.fixedHostFor(knownSsid)
            if (ssid != null && !password.isNullOrBlank()) graph.wifiCredentials.remember(ssid, password)
            // Filled by the fixed-host probe below, so a camera found where its brand
            // says it is does not get identified a second time.
            var identified: DevicePlatform? = null
            if (host == null) {
                // Joining a network we're already on is a no-op the OS rejects (or
                // re-prompts for), so skip it when the user joined in system settings.
                val current = graph.wifi.currentCameraSsid()
                val alreadyOnTarget = ssid != null && current.equals(ssid, ignoreCase = true)
                Diag.d { "wifi state current_ssid=${current ?: "-"} target=${ssid ?: "-"} already_on=$alreadyOnTarget" }
                if (ssid != null && !alreadyOnTarget) {
                    goPhase(Phase.ConnectingWifi)
                    statusMessage = localized(Res.string.status_joining_wifi, ssid)
                    val ok = graph.permissions.ensureWifiPermissions()
                    if (!ok) {
                        Diag.i { "abort: wifi permissions denied" }
                        fail(localized(Res.string.err_wifi_permissions_denied)); return
                    }
                    val t0 = Diag.uptimeMillis()
                    when (val r = graph.wifi.connect(ssid, password)) {
                        is WifiResult.Connected -> {
                            Diag.i(LogTag.WIFI) { "joined $ssid in ${Diag.uptimeMillis() - t0}ms" }
                            statusMessage = localized(Res.string.status_wifi_joined_locating)
                        }
                        is WifiResult.Failed -> {
                            Diag.at(LogLevel.ERROR, LogTag.WIFI, "join $ssid failed in ${Diag.uptimeMillis() - t0}ms: ${r.message}")
                            fail(localized(Res.string.err_wifi_failed, r.message, ssid)); return
                        }
                        WifiResult.Cancelled -> {
                            Diag.i(LogTag.WIFI) { "join $ssid cancelled by the user" }
                            fail(localized(Res.string.err_wifi_cancelled)); return
                        }
                    }
                } else if (alreadyOnTarget) {
                    statusMessage = localized(Res.string.status_already_on_wifi, ssid)
                }
                goPhase(Phase.IdentifyingDevice)
                statusMessage = localized(Res.string.status_detecting_model)
                val direct = preferredHost
                if (direct != null) {
                    Diag.i { "asking the fixed host $direct for ${knownSsid ?: "-"} before consulting the gateway" }
                    identified = graph.discovery.identify(direct, port)
                    if (identified != null) host = direct
                }
                if (identified == null) {
                    val gw = graph.wifi.gateway()
                    Diag.d { "gateway resolved to ${gw ?: "(none)"}" }
                    val found = graph.discovery.discover(gw, preferredHost = direct)
                    if (found == null) {
                        Diag.i { "abort: discovery found no camera (preferred=${direct ?: "none"} gateway=${gw ?: "none"})" }
                        fail(localized(Res.string.err_no_camera_found)); return
                    }
                    host = found.first
                    identified = found.second
                }
            }

            goPhase(Phase.ConnectingProtocol)
            statusMessage = localized(Res.string.status_connecting_to_camera)
            val h = host ?: run {
                Diag.i { "abort: no host resolved" }
                fail(localized(Res.string.err_no_host_resolved)); return
            }
            val platform: DevicePlatform = identified
                ?: graph.discovery.identify(h, port)
                ?: run {
                    Diag.i { "abort: unsupported camera at $h:$port" }
                    fail(localized(Res.string.err_unsupported_camera, h, port)); return
                }
            val proto = graph.registry.protocolFor(platform) ?: run {
                Diag.at(LogLevel.ERROR, LogTag.APP, "no plugin registered for $platform")
                fail(localized(Res.string.err_no_plugin, platform.displayName)); return
            }
            val s = proto.connect(h, port)
            session = s
            sessionScope = CoroutineScope(scope.coroutineContext + Job())
            consecutivePollFailures = 0
            Diag.i { "session up ${s.brand.displayName}/${s.platform.displayName} model=\"${s.model}\" host=${s.host}:${s.port} extras=${s.extras}" }
            collectEvents(proto)
            // Time sync is a named connection step (TUWIN makes it one too); it's
            // best-effort so a camera that rejects it still connects.
            goPhase(Phase.SyncingTime)
            statusMessage = localized(Res.string.status_syncing_time)
            runCatching { proto.syncTime(s) }
                .onSuccess { r -> Diag.opOutcome("syncTime", r.isOk, if (r is CmdResult.Failure) r.message else "") }
                .onFailure { Diag.at(LogLevel.WARN, LogTag.PROTO, "syncTime threw ${Diag.causeChain(it)} (ignored)") }
            goPhase(Phase.Connected)
            // The radios have done their job: an LE scan still running competes with
            // the hotspot for the combo chip on some phones, and a Wi-Fi scan request
            // now costs the camera a deauth cycle for no reason.
            nearby.stop()
            askPasswordFor = null
            statusMessage = localized(Res.string.status_connected_platform, platform.displayName)
            Diag.i { "CONNECT done host=${s.host} platform=${platform.displayName} (poll + list now start)" }
            startPolling()
            loadDeviceInfo()
            // The mode table first: which settings menu is worth asking for depends on
            // which mode the camera is in, and the mode list is what the UI shows.
            loadModes()
            loadSettings()
            loadDeviceSettings()
            refreshFiles()
        } catch (t: Throwable) {
            Diag.at(LogLevel.ERROR, LogTag.APP, "CONNECT threw ${Diag.causeChain(t)}${Diag.stackSuffix(t)}")
            fail(t.message?.let(::raw) ?: localized(Res.string.err_connection_error))
        }
    }

    /**
     * Wires the protocol's push events into observable state. Launched on
     * [sessionScope] so it is cancelled together with the session on disconnect;
     * a device that never pushes events simply keeps the polling loop as the
     * authority for status.
     */
    private fun collectEvents(proto: CameraProtocol) {
        val owner = sessionScope ?: return
        owner.launch {
            proto.events.collect { ev ->
                Diag.i(LogTag.STATE) { "PUSH event ${ev::class.simpleName} $ev" }
                when (ev) {
                    is DeviceEvent.RecordingChanged -> {
                        // Stamp it: a status poll issued *before* this command still
                        // carries the pre-command answer and must not undo the change.
                        localRecordFlipAt = Diag.uptimeMillis()
                        deviceStatus = deviceStatus?.copy(recording = ev.recording)
                    }
                    is DeviceEvent.BatteryChanged ->
                        deviceStatus = deviceStatus?.copy(battery = ev.percent)
                    is DeviceEvent.Disconnected -> {
                        Diag.at(LogLevel.WARN, LogTag.STATE, "device reported disconnect reason=${ev.reason ?: "-"}")
                        // Camera-supplied text: shown as-is, not a translatable resource.
                        errorMessage = ev.reason?.let(::raw)
                        disconnect()
                    }
                }
            }
        }
    }

    fun disconnect() = scope.launch {
        Diag.i(LogTag.APP, "c${Diag.nextId()}:disconnect") {
            "DISCONNECT begin (was ${session?.let { "${it.platform.displayName} ${it.host}" } ?: "not connected"}, " +
                "busy=${busy.joinToString(",").ifEmpty { "none" }}, downloads=${downloads.count { it.state == DownloadItem.State.Running }} running)"
        }
        // Kill everything bound to the session first: an in-flight refresh or
        // download would otherwise repopulate state for a session that's gone.
        sessionScope?.cancel()
        sessionScope = null
        pollJob?.cancel()
        pollJob = null
        connectJob?.cancel()
        connectJob = null
        localRecordFlipAt = 0L
        // Let the plugin forget firmware facts it cached for this host, so swapping
        // cameras on the same 192.168.0.1 cannot serve the previous model's tables.
        val closing = session
        if (closing != null) runCatching { protocol?.onSessionClosed(closing) }
        session = null
        deviceStatus = null
        deviceInfo = null
        otaState = OtaState.Idle
        otaCoordinator = null
        files = emptyList()
        settings = emptyList()
        modes = emptyList()
        deviceSettings = emptyList()
        thumbnails.clear()
        thumbsInFlight.clear()
        thumbFailed.clear()
        downloads.clear()
        busy.clear()
        goPhase(Phase.Idle)
        statusMessage = null
        runCatching { graph.wifi.disconnect() }
            .onFailure { Diag.at(LogLevel.WARN, LogTag.WIFI, "wifi disconnect threw ${Diag.causeChain(it)}") }
        Diag.i(LogTag.APP) { "DISCONNECT done, state cleared" }
    }

    private fun startPolling() {
        val owner = sessionScope ?: return
        pollJob?.cancel()
        pollJob = owner.launch {
            val proto = protocol ?: return@launch
            val s = session ?: return@launch
            Diag.i(LogTag.STATE) { "poll loop started (every ${POLL_INTERVAL_MS}ms, gives up after $POLL_FAILURES_BEFORE_LOST failures)" }
            while (true) {
                val t0 = Diag.uptimeMillis()
                runCatching { proto.getStatus(s) }
                    .onSuccess {
                        if (consecutivePollFailures > 0) {
                            Diag.i(LogTag.STATE) { "poll recovered after $consecutivePollFailures failure(s)" }
                        }
                        consecutivePollFailures = 0
                        // A poll that left the phone before the record button was pressed
                        // describes the old state. Trusting it is what made the button
                        // snap back to "录像" a moment after recording had started.
                        val stale = t0 < localRecordFlipAt
                        if (stale) {
                            Diag.d(LogTag.STATE) { "ignoring recording=${it.recording} from a poll issued before the record command" }
                        }
                        logStatusChange(deviceStatus, it, Diag.uptimeMillis() - t0)
                        deviceStatus = if (stale) {
                            it.copy(recording = deviceStatus?.recording == true)
                        } else {
                            it
                        }
                    }
                    .onFailure { err ->
                        // One hiccup is normal on a congested hotspot; a run of them
                        // means the camera is gone, and the pill must say so.
                        consecutivePollFailures++
                        Diag.at(
                            if (consecutivePollFailures >= POLL_FAILURES_BEFORE_LOST) LogLevel.ERROR else LogLevel.WARN,
                            LogTag.STATE,
                            "poll failed ($consecutivePollFailures/$POLL_FAILURES_BEFORE_LOST) after ${Diag.uptimeMillis() - t0}ms " +
                                "${Diag.causeChain(err)}",
                        )
                        if (consecutivePollFailures == POLL_FAILURES_BEFORE_LOST) {
                            errorMessage = localized(Res.string.err_camera_stopped)
                            disconnect()
                        }
                    }
                delay(POLL_INTERVAL_MS)
            }
        }
    }

    /**
     * Log only what actually changed in the polled status. A field that flaps is a
     * protocol bug worth seeing; 40 identical samples a minute are not.
     */
    private fun logStatusChange(prev: DeviceStatus?, next: DeviceStatus, ms: Long) {
        if (prev == null) {
            Diag.info(LogTag.STATE, "status first=${describeStatus(next)} (${ms}ms)")
            return
        }
        val diff = buildList {
            if (prev.battery != next.battery) add("battery ${prev.battery}=>${next.battery}")
            if (prev.recording != next.recording) add("recording ${prev.recording}=>${next.recording}")
            if (prev.busy != next.busy) add("busy ${prev.busy}=>${next.busy}")
            if (prev.mode != next.mode) add("mode ${prev.mode}=>${next.mode}${next.modeName?.let { " (\"$it\")" } ?: ""}")
            if (prev.workState != next.workState) add("work_state ${prev.workState}=>${next.workState}")
            if (prev.sdState != next.sdState) add("sd ${prev.sdState}=>${next.sdState}")
            if (prev.sdFreeMb != next.sdFreeMb) add("sd_free ${prev.sdFreeMb}=>${next.sdFreeMb}MB")
            if (prev.videoTimeSec != next.videoTimeSec) add("rec_time ${prev.videoTimeSec}=>${next.videoTimeSec}s")
            if (prev.photoCount != next.photoCount) add("photos ${prev.photoCount}=>${next.photoCount}")
            if (prev.charging != next.charging) add("charging ${prev.charging}=>${next.charging}")
        }
        if (diff.isNotEmpty()) {
            Diag.info(LogTag.STATE, "status ${diff.joinToString(" ")} (${ms}ms)")
        } else {
            Diag.trace(LogTag.STATE, "status unchanged ${describeStatus(next)} (${ms}ms)")
        }
    }

    private fun describeStatus(s: DeviceStatus): String =
        "battery=${s.battery} rec=${s.recording} mode=${s.mode}${s.modeName?.let { "(\"$it\")" } ?: ""} " +
            "state=${s.workState} sd=${s.sdState} free=${s.sdFreeMb}MB time=${s.videoTimeSec}s photos=${s.photoCount}"


    // ---------- Controls ----------

    fun capture() = runOp(Op.Capture) { proto, s -> proto.capture(s) }

    /**
     * End a running start/stop capture sequence (the camera's 延时拍照 / 定时拍照
     * modes). A mode whose shutter is a single shot never needs this, so the UI only
     * offers it while [captureRunning] is true for a [ModeTrigger.TOGGLE] mode.
     */
    fun stopCapture() = runOp(Op.Capture) { proto, s -> proto.stopCapture(s) }

    fun record(start: Boolean) = runOp(Op.Record) { proto, s -> proto.record(s, start) }

    /**
     * The shooting modes this camera offers. Empty until a session is up, or on a
     * plugin that cannot enumerate them — the UI then falls back to the coarse
     * video/photo pair, which is what [WorkMode] still means.
     */
    var modes by mutableStateOf<List<CameraMode>>(emptyList())
        private set

    /** The mode the camera reports right now, in its own spelling. */
    val currentMode: CameraMode? get() = modes.firstOrNull { it.name == deviceStatus?.modeName?.trim() }

    /**
     * True while a [ModeTrigger.TOGGLE] capture sequence is running. `getcurallinfo`
     * state 20 means "recording" only in a video-family mode, and "mid-capture" in a
     * plain photo mode; in a timelapse/timer photo mode it genuinely means the camera
     * is taking frames until told to stop, which is the case the two-state shutter
     * exists for.
     */
    val captureRunning: Boolean
        get() = deviceStatus?.busy == true && currentMode?.trigger == ModeTrigger.TOGGLE

    /**
     * Whether the shutter would have to refuse a photo right now. With no mode table
     * the coarse [WorkMode] is the only clue, and on the S7PRO a `photo.cgi` fired from
     * a video mode started a recording and produced no file at all — so the button
     * stays off until the camera is actually in a photo family.
     */
    fun needsPhotoModeForShutter(): Boolean =
        currentMode?.family != ModeFamily.PHOTO && deviceStatus?.mode != WorkMode.PHOTO

    /** The device's own menu (`workmode=System` on the CGI family) — not per-mode settings. */
    var deviceSettings by mutableStateOf<List<CameraSetting>>(emptyList())
        private set

    /** Read the mode table, then the menus it implies. */
    fun loadModes() = runOp(Op.Mode) { proto, s ->
        val listed = proto.listModes(s)
        modes = listed
        Diag.i(LogTag.PROTO) { "modes offered n=${listed.size} ${listed.joinToString(",") { it.name }.take(240)}" }
        CmdResult.Ok
    }

    /**
     * Change the camera's shooting mode by its firmware name, then re-read the
     * settings menu: which items exist is a function of the mode, so a stale menu
     * would keep offering video-only settings after the camera moved into a photo mode.
     */
    fun selectMode(mode: CameraMode) = runOp(Op.Mode) { proto, s ->
        val r = proto.setNamedMode(s, mode)
        if (r.isOk) {
            reloadSettingsForMode(proto, s)
            // The status poll reads at most every POLL_INTERVAL_MS; without this the
            // mode strip would keep highlighting the mode we just left.
            deviceStatus = deviceStatus?.copy(modeName = mode.name, mode = mode.family.workMode())
        }
        r
    }

    /**
     * Change the camera's work mode, then re-read the settings menu: which items
     * exist is a function of the mode, so a stale menu would keep offering
     * video-only settings after the camera moved into a photo mode.
     */
    fun setMode(mode: WorkMode) = runOp(Op.Mode) { proto, s ->
        val r = proto.setMode(s, mode)
        if (r.isOk) reloadSettingsForMode(proto, s)
        r
    }

    fun loadDeviceSettings() = runOp(Op.Settings) { proto, s ->
        val listed = proto.getDeviceSettings(s)
        deviceSettings = listed
        Diag.i(LogTag.PROTO) { "device settings loaded n=${listed.size} ids=${listed.joinToString(",") { it.id }.take(240)}" }
        CmdResult.Ok
    }

    fun setDeviceSetting(id: String, value: String) = runOp(Op.Settings) { proto, s ->
        val before = deviceSettings.firstOrNull { it.id == id }?.value
        Diag.i(LogTag.PROTO) { "SET(device) $id ${before ?: "?"} -> ${LogFormat.settingValue(id, value, Diag.config.captureSecrets)}" }
        val r = proto.setDeviceSetting(s, id, value)
        if (r.isOk) {
            deviceSettings = deviceSettings.map { if (it.id == id) it.copy(value = value) else it }
            val read = runCatching { proto.readBack(s, id) }.getOrNull()
            if (read != null) deviceSettings = deviceSettings.map { if (it.id == id) read else it }
        }
        if (r is CmdResult.Failure) Diag.at(LogLevel.ERROR, LogTag.PROTO, "SET(device) $id refused: ${LogFormat.field(r.message)}")
        r
    }

    fun loadSettings() = runOp(Op.Settings) { proto, s ->
        settings = proto.getSettings(s)
        Diag.i(LogTag.PROTO) { "settings loaded n=${settings.size} ids=${settings.joinToString(",") { it.id }.take(240)}" }
        CmdResult.Ok
    }

    fun setSetting(id: String, value: String) = runOp(Op.Settings) { proto, s ->
        val before = settings.firstOrNull { it.id == id }?.value
        Diag.i(LogTag.PROTO) { "SET $id ${before ?: "?"} -> ${LogFormat.settingValue(id, value, Diag.config.captureSecrets)}" }
        val r = proto.setSetting(s, id, value)
        if (r.isOk) {
            // Show the firmware's answer, not our request. A full getSettings() costs
            // one request per menu item; see HisiliconProtocol.readBack for why that
            // is the wrong thing to do after every tap.
            settings = settings.map { if (it.id == id) it.copy(value = value) else it }
            val read = runCatching { proto.readBack(s, id) }
                .onFailure { Diag.d(LogTag.PROTO) { "read-back of $id failed ${Diag.causeChain(it)}" } }
                .getOrNull()
            if (read != null) {
                settings = settings.map { if (it.id == id) read else it }
                if (read.value != value) {
                    Diag.w(LogTag.PROTO) { "SET $id accepted but camera reports ${read.value}; asked $value" }
                }
            }
        }
        if (r is CmdResult.Failure) Diag.at(LogLevel.ERROR, LogTag.PROTO, "SET $id refused: ${LogFormat.field(r.message)}")
        r
    }

    /** Re-read the settings menu, which is a function of the camera's work mode. */
    private suspend fun reloadSettingsForMode(proto: CameraProtocol, s: CameraSession) {
        runCatching { proto.getSettings(s) }
            .onSuccess { loaded ->
                settings = loaded
                Diag.i(LogTag.PROTO) { "settings re-read after mode change: n=${loaded.size}" }
            }
            .onFailure { Diag.at(LogLevel.WARN, LogTag.PROTO, "settings re-read failed ${Diag.causeChain(it)}") }
    }

    fun refreshFiles() = runOp(Op.Refresh) { proto, s ->
        val listed = proto.listFiles(s, 0, LISTING_PAGE)
        val previous = files.size
        // Forget thumbnails for files that no longer exist; keep the rest so a
        // refresh doesn't re-download images we already have.
        val present = listed.mapTo(mutableSetOf()) { it.name }
        val gone = files.map { it.name }.filterNotTo(mutableSetOf()) { present.contains(it) }
        thumbnails.keys.retainAll(present)
        thumbFailed.retainAll(present)
        files = listed
        Diag.i(LogTag.FILE) {
            "list ${listed.size} files (was $previous)" +
                (if (gone.isEmpty()) "" else " removed=${gone.size} [${gone.joinToString(",") { it.substringAfterLast('/') }.take(160)}]") +
                (if (listed.isEmpty()) " — empty card or the listing endpoint returned nothing" else "")
        }
        CmdResult.Ok
    }

    /**
     * Fetches and decodes the preview image for [file] once. Safe to call from a
     * composition: repeat calls for the same file are ignored while one is in
     * flight or already resolved.
     *
     * The in-flight cap exists because a camera listing is not bounded by what the
     * screen can show: `listFiles(0, 999)` plus a preview request per row put ~50
     * simultaneous GETs on one hotspot, and the whole card's JPEGs behind them on
     * one heap. Rows ask again as the list recomposes, so a request that is turned
     * away here is not lost — it is just queued by the UI's own rhythm.
     */
    fun loadThumbnail(file: RemoteFile) {
        val proto = protocol ?: return
        val s = session ?: return
        val owner = sessionScope ?: return
        if (thumbnails.containsKey(file.name) || thumbFailed.contains(file.name)) return
        if (thumbsInFlight.size >= MAX_THUMBS_IN_FLIGHT) {
            Diag.debug(
                LogTag.FILE,
                "thumb queued behind ${thumbsInFlight.size} transfers ${file.name}",
            )
            return
        }
        if (!thumbsInFlight.add(file.name)) return
        owner.launch {
            try {
                val bytes = runCatching { proto.thumbnail(s, file) }.getOrNull()
                val bitmap = bytes?.let {
                    withContext(Dispatchers.Default) {
                        runCatching { it.decodeToImageBitmap() }
                            .onFailure { err ->
                                // "Camera answered but the image is unusable" is a protocol
                                // finding, not a UI bug: log the payload it choked on.
                                Diag.at(
                                    LogLevel.WARN, LogTag.PARSE,
                                    "thumb decode failed ${file.name} ${it.size}B ${Diag.causeChain(err)}" +
                                        "\n${LogFormat.CONT}first=${LogFormat.hexPreview(it, minOf(32, it.size))}",
                                )
                            }
                            .getOrNull()
                    }
                }
                if (bitmap != null) {
                    trimThumbnails()
                    thumbnails[file.name] = bitmap
                    Diag.v(LogTag.FILE) { "thumb ok ${file.name} ${bytes.size}B ${bitmap.width}x${bitmap.height}" }
                } else {
                    Diag.d(LogTag.FILE) { "thumb unavailable ${file.name} (bytes=${bytes?.size ?: "null"})" }
                    // Don't cache a permanent null: a transient hotspot failure would
                    // otherwise blank this thumbnail for the rest of the session.
                    thumbFailed.add(file.name)
                }
            } finally {
                thumbsInFlight.remove(file.name)
            }
        }
    }

    /**
     * Evict before inserting, not after: a cache that trims afterwards has already
     * paid for the new bitmap, and one decoded 12 MP frame is ~48 MB of ARGB on a
     * phone this app measured with a 256 MB heap class.
     */
    private fun trimThumbnails() {
        while (thumbnails.size >= MAX_CACHED_THUMBNAILS) {
            thumbnails.remove(thumbnails.keys.firstOrNull() ?: return)
        }
    }

    /**
     * A progress callback for [CameraHttp.download], which reports from its own
     * dispatcher. [downloads] is a snapshot list the composition iterates on the main
     * thread, so writing it from the transfer thread is a
     * `ConcurrentModificationException` waiting for a fast file; every update is
     * re-posted to the app scope instead, floored at one post per 2 % so a 19 MB/s
     * transfer cannot flood that queue.
     */
    private fun progressWriter(name: String): (Float) -> Unit {
        var lastPosted = -1f
        return { p ->
            if (p >= 1f || p - lastPosted >= 0.02f) {
                lastPosted = p
                scope.launch {
                    val i = downloads.indexOfFirst { it.file.name == name }
                    if (i >= 0) downloads[i] = downloads[i].copy(progress = p)
                }
            }
        }
    }

    fun deleteFile(file: RemoteFile) = runOp(Op.Delete) { proto, s ->
        Diag.i(LogTag.FILE) { "DELETE ${file.name} (${file.sizeBytes}B)" }
        val r = proto.deleteFile(s, file)
        if (r.isOk) {
            files = files.filterNot { it.name == file.name }
            thumbnails.remove(file.name)
            thumbFailed.remove(file.name)
        }
        r
    }

    /**
     * Batch delete inside a single operation. Iterating [deleteFile] from a loop
     * would spawn concurrent read-modify-write on `files` and silently drop
     * updates, so the whole batch runs sequentially and rebuilds the list once.
     */
    fun deleteFiles(list: List<RemoteFile>) = runOp(Op.Delete) { proto, s ->
        if (list.isEmpty()) return@runOp CmdResult.Ok
        Diag.i(LogTag.FILE) { "DELETE batch n=${list.size} ${list.joinToString(",") { it.name.substringAfterLast('/') }.take(240)}" }
        var failed = 0
        for (f in list) {
            if (!proto.deleteFile(s, f).isOk) failed++
            thumbnails.remove(f.name)
            thumbFailed.remove(f.name)
        }
        val removed = list.mapTo(mutableSetOf()) { it.name }
        files = files.filterNot { removed.contains(it.name) }
        if (failed > 0) CmdResult.Failure("$failed of ${list.size} files could not be deleted")
        else CmdResult.Ok
    }

    // ---------- device info / maintenance ----------

    fun loadDeviceInfo() = runOp(Op.DeviceInfo) { proto, s ->
        val info = proto.getDeviceInfo(s)
        deviceInfo = info
        if (info == null) {
            Diag.at(LogLevel.WARN, LogTag.DEV, "device info unavailable")
        } else {
            Diag.i(LogTag.DEV) {
                "device name=${info.name} model=${info.model} serial=${info.serialNumber} " +
                    "soft=${info.softVersion} hard=${info.hardVersion} region=${info.region} mac=${info.mac} " +
                    "ssid=${info.ssid} keys=${info.raw.size}"
            }
            Diag.v(LogTag.DEV) {
                "device raw ${info.raw.entries.joinToString(",") { (k, v) -> "$k=${LogFormat.safe(v)}" }}"
            }
        }
        CmdResult.Ok
    }

    fun formatSd() = runOp(Op.FormatSd) { proto, s ->
        Diag.w(LogTag.FILE) { "FORMAT SD requested — this erases the card" }
        val r = proto.formatSd(s)
        if (r.isOk) {
            // Formatting wipes the card: drop cached listings and thumbnails, then
            // repull so the UI shows the (empty) card instead of stale files.
            thumbnails.clear()
            thumbFailed.clear()
            files = proto.listFiles(s, 0, 999)
            runCatching { deviceStatus = proto.getStatus(s) }
            Diag.i(LogTag.FILE) { "format done, listing now ${files.size} files" }
        }
        r
    }

    fun factoryReset() = runOp(Op.FactoryReset) { proto, s ->
        Diag.w(LogTag.APP) { "FACTORY RESET requested" }
        val r = proto.factoryReset(s)
        if (r.isOk) errorMessage = localized(Res.string.notice_factory_reset)
        r
    }

    fun reboot() = runOp(Op.Reboot) { proto, s ->
        Diag.w(LogTag.APP) { "REBOOT requested" }
        val r = proto.reboot(s)
        if (r.isOk) errorMessage = localized(Res.string.notice_reboot)
        r
    }

    fun syncTime() = runOp(Op.Settings) { proto, s -> proto.syncTime(s) }

    /** Change the camera's own Wi-Fi name/password (A4). */
    fun setCameraWifi(ssid: String, password: String) =
        runOp(Op.Settings) { proto, s -> proto.setWifi(s, ssid, password) }

    // ---------- firmware OTA ----------

    /**
     * Whether the connected camera family supports firmware updates yet. Only the
     * Hisilicon CGI transport is implemented so far (doc 04's "start with Hisilicon").
     */
    fun firmwareUpdateSupported(): Boolean =
        session?.platform == DevicePlatform.HISILICON

    /**
     * Pick a local firmware package and run the update. Launched on [sessionScope]
     * so it dies with the session; state is surfaced through [otaState].
     */
    fun installFirmwareUpdate() {
        val base = session ?: return
        val proto = protocol ?: return
        val owner = sessionScope ?: return
        Diag.info(LogTag.OTA, "OTA requested for ${base.platform.displayName} at ${base.host}")
        if (!firmwareUpdateSupported()) {
            Diag.at(LogLevel.WARN, LogTag.OTA, "OTA unsupported on ${base.platform.displayName}")
            otaState = OtaState.Failed("Firmware update is not yet supported for this camera")
            return
        }
        val transport = HisiliconOtaTransport(graph.http)
        val coord = OtaCoordinator(
            transport = transport,
            connect = { proto.connect(base.host, base.port) },
        )
        coord.onState = {
            otaState = it
            Diag.at(
                if (it is OtaState.Failed) LogLevel.ERROR else LogLevel.INFO, LogTag.OTA,
                "state -> ${it::class.simpleName}",
            )
        }
        otaCoordinator = coord
        owner.launch {
            val pkg = runCatching { pickCameraFirmwarePackage() }.getOrElse {
                Diag.at(LogLevel.ERROR, LogTag.OTA, "firmware picker failed ${Diag.causeChain(it)}")
                null
            }
            if (pkg == null) {
                Diag.i(LogTag.OTA) { "no package chosen; aborting" }
                if (!otaState.isTerminal) otaState = OtaState.Cancelled
                return@launch
            }
            Diag.i(LogTag.OTA) { "package ${pkg.fileName} version=${pkg.version} bytes=${LogFormat.size(pkg.bytes.size.toLong())}" }
            coord.run(pkg)
        }
    }

    fun cancelFirmwareUpdate() {
        Diag.warn(LogTag.OTA, "cancel requested at ${otaState::class.simpleName}")
        otaCoordinator?.cancel()
    }

    /** Dismiss a terminal OTA state so the update button returns. */
    fun resetOtaState() {
        if (otaState.isTerminal) otaState = OtaState.Idle
    }

    fun download(file: RemoteFile) {
        val proto = protocol ?: return
        val s = session ?: return
        val owner = sessionScope ?: return
        val current = downloads.firstOrNull { it.file.name == file.name }
        if (current != null && current.state != DownloadItem.State.Failed) {
            Diag.debug(LogTag.DL, "ignore duplicate download of ${file.name} (state=${current.state})")
            return
        }
        if (current != null) downloads.remove(current)
        downloads.add(DownloadItem(file, state = DownloadItem.State.Running))
        owner.launch {
            val op = "c${Diag.nextId()}:download"
            withContext(OpContext(op)) {
                val t0 = Diag.uptimeMillis()
                try {
                    // Pre-API-29 saving goes through public external storage and needs
                    // WRITE_EXTERNAL_STORAGE; on 29+ this is a no-op returning true.
                    if (!graph.permissions.ensureStoragePermissions()) {
                        Diag.at(LogLevel.ERROR, LogTag.PERM, "storage permission denied for download")
                        markFailed(file, localized(Res.string.err_storage_permission))
                        return@withContext
                    }
                    val dir = graph.fileSaver.downloadsDir()
                    // The name came from the device's own listing; never let it escape
                    // the staging directory.
                    val dest: Path = dir / sanitizeFileName(file.name)
                    val have = runCatching { okio.FileSystem.SYSTEM.metadata(dest).size }.getOrNull() ?: 0L
                    // Resume only into a genuinely partial file; a complete or oversized
                    // leftover has to be re-fetched from zero.
                    val resumeFrom = if (have > 0L && (file.sizeBytes <= 0L || have < file.sizeBytes)) have else 0L
                    Diag.i(LogTag.DL) {
                        "START ${file.name} size=${LogFormat.size(file.sizeBytes)} on_disk=${LogFormat.size(have)} " +
                            "resume_from=$resumeFrom dest=$dest"
                    }
                    val written = proto.download(s, file, dest, resumeFrom, progressWriter(file.name))
                    val ms = Diag.uptimeMillis() - t0
                    if (written < 0L) {
                        Diag.at(
                            LogLevel.ERROR, LogTag.DL,
                            "FAILED ${file.name} after ${ms}ms (partial file kept for resume)",
                        )
                        markFailed(file, localized(Res.string.err_download_interrupted))
                        return@withContext
                    }
                    if (file.sizeBytes > 0L && written != file.sizeBytes) {
                        Diag.at(
                            LogLevel.ERROR, LogTag.DL,
                            "SIZE MISMATCH ${file.name} wrote=$written expected=${file.sizeBytes} in ${ms}ms",
                        )
                        markFailed(file, localized(Res.string.err_download_incomplete, written, file.sizeBytes))
                        return@withContext
                    }
                    val mime = if (file.type == com.rovecamlink.app.core.model.FileType.PHOTO) "image/jpeg" else "video/mp4"
                    val published = runCatching { graph.fileSaver.publishToGallery(dest, file.name, mime) }
                        .onFailure { Diag.at(LogLevel.WARN, LogTag.DL, "gallery publish threw ${Diag.causeChain(it)}") }
                        .getOrNull()
                    val i = downloads.indexOfFirst { it.file.name == file.name }
                    if (i >= 0) downloads[i] = downloads[i].copy(
                        state = DownloadItem.State.Done, progress = 1f, localPath = published ?: dest.toString(),
                    )
                    Diag.i(LogTag.DL) {
                        "DONE ${file.name} ${LogFormat.size(written)} in ${ms}ms " +
                            "(${LogFormat.size(if (ms > 0) written * 1000 / ms else 0)}/s) -> ${published ?: dest}"
                    }
                    if (published == null) {
                        errorMessage = localized(Res.string.err_gallery_rejected)
                    }
                } catch (t: Throwable) {
                    Diag.at(LogLevel.ERROR, LogTag.DL, "download ${file.name} threw ${Diag.causeChain(t)}")
                    markFailed(file, t.message?.let(::raw) ?: localized(Res.string.err_download_failed))
                }
            }
        }
    }

    /** True while this file has a queued/running transfer. */
    fun downloadState(name: String): DownloadItem.State? =
        downloads.firstOrNull { it.file.name == name }?.state

    fun downloadError(name: String): LocalizedString? =
        downloads.firstOrNull { it.file.name == name }?.error

    /** Drop finished entries from the in-session queue (files stay on disk). */
    fun clearFinishedDownloads() {
        val n = downloads.count { it.state == DownloadItem.State.Done }
        downloads.removeAll { it.state == DownloadItem.State.Done }
        Diag.info(LogTag.DL, "cleared $n finished entries")
    }

    /** Re-queue every failed download (resumes from whatever bytes already landed). */
    fun retryFailedDownloads() {
        val failed = downloads.filter { it.state == DownloadItem.State.Failed }
        Diag.info(LogTag.DL, "retrying ${failed.size} failed transfers")
        failed.forEach { download(it.file) }
    }

    private fun markFailed(file: RemoteFile, reason: LocalizedString) {
        val i = downloads.indexOfFirst { it.file.name == file.name }
        if (i >= 0) downloads[i] = downloads[i].copy(state = DownloadItem.State.Failed, error = reason)
        errorMessage = reason
    }

    private fun runOp(op: Op, block: suspend (CameraProtocol, CameraSession) -> CmdResult) =
        (sessionScope ?: scope).launch {
            val proto = protocol
            val s = session
            if (proto == null || s == null) {
                Diag.at(LogLevel.WARN, LogTag.APP, "SKIP $op: no live session (phase=${phase.name})")
                return@launch
            }
            withContext(OpContext("c${Diag.nextId()}:${op.name.lowercase()}")) { runOperation(op, proto, s, block) }
        }

    private suspend fun runOperation(
        op: Op,
        proto: CameraProtocol,
        s: CameraSession,
        block: suspend (CameraProtocol, CameraSession) -> CmdResult,
    ) {
        setBusy(op, true)
        try {
            val r = block(proto, s)
            Diag.opOutcome(op.name, r.isOk, if (r is CmdResult.Failure) LogFormat.safe(r.message) else "")
            if (r is CmdResult.Failure) errorMessage = raw(r.message)
            // refresh status promptly after a control action
            runCatching { deviceStatus = proto.getStatus(s) }
                .onFailure { Diag.d(LogTag.STATE) { "post-$op status refresh failed ${Diag.causeChain(it)}" } }
        } catch (t: Throwable) {
            Diag.at(
                level = LogLevel.ERROR, tag = LogTag.APP,
                text = "$op threw ${Diag.causeChain(t)}${Diag.stackSuffix(t)}",
                statsOp = { it.noteOperation(op.name, false) },
            )
            errorMessage = t.message?.let(::raw) ?: localized(Res.string.err_command_failed)
        } finally {
            setBusy(op, false)
        }
    }

    private fun fail(msg: LocalizedString) {
        errorMessage = msg
        goPhase(Phase.Error)
        statusMessage = null
        // Dynamic texts (camera/OS wording) are loggable verbatim; a localized resource
        // has no string outside a composition, and the reason is always logged separately.
        val detail = (msg as? LocalizedString.Raw)?.text ?: "see the lines above"
        Diag.at(LogLevel.ERROR, LogTag.APP, "CONNECT failed: $detail")
    }
}

private const val POLL_FAILURES_BEFORE_LOST = 3

/**
 * Upper bound on one card listing. The camera answers with whatever it has, so this
 * is a guard against a 2 000-file card becoming 2 000 rows the UI has to build and
 * 2 000 thumbnail requests behind them.
 */
private const val LISTING_PAGE = 300

/** Status polling interval; it is a load characteristic of the camera, so it belongs in the log. */
private const val POLL_INTERVAL_MS = 1_500L

/** Decoded thumbnails held at once; beyond this the oldest are evicted. */
private const val MAX_CACHED_THUMBNAILS = 24

/**
 * Preview fetches allowed at the same moment. One hotspot serves the status poll,
 * the live view and this list, and the 2026-09-21 session showed ten thumbnail GETs
 * firing inside a 110 ms window — the same card with 200 files would have fired 200.
 */
private const val MAX_THUMBS_IN_FLIGHT = 4
