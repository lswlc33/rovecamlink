package com.rovecamlink.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.graphics.ImageBitmap
import com.rovecamlink.app.brand.xtu.HisiliconOtaTransport
import com.rovecamlink.app.brand.xtu.XtuSocketOtaTransport
import com.rovecamlink.app.core.model.CameraMode
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraWifi
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.UiTestDevice
import com.rovecamlink.app.core.model.DeviceEvent
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.ModeFamily
import com.rovecamlink.app.core.model.ModeTrigger
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.model.workMode
import com.rovecamlink.app.core.transport.CameraRequest
import com.rovecamlink.app.core.transport.CameraRequestClass
import com.rovecamlink.app.core.transport.withCameraRequest
import com.rovecamlink.app.core.nearby.NearbyController
import com.rovecamlink.app.core.ota.ChainedOtaTransport
import com.rovecamlink.app.core.ota.FirmwareOffer
import com.rovecamlink.app.core.ota.FirmwarePackage
import com.rovecamlink.app.core.ota.FirmwareUpdater
import com.rovecamlink.app.core.ota.OtaCoordinator
import com.rovecamlink.app.core.ota.OtaState
import com.rovecamlink.app.core.ota.PackageResult
import com.rovecamlink.app.core.ota.UpdatePlan
import com.rovecamlink.app.core.ota.pickCameraFirmwarePackage
import com.rovecamlink.app.core.ota.firmwareLocalPickerAvailable
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
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull
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
enum class Op { Capture, Record, Mode, Refresh, Delete, Settings, FormatSd, FactoryReset, Reboot, DeviceInfo, AccessPoint, Wifi }

/** What the user decided about the running proxy: the two buttons, and what a dismissal means. */
enum class VpnChoice {
    /** Ignore the warning and let the attempt run. */
    Proceed,

    /** Abandon this attempt and take the user to the system screen that stops the proxy. */
    CloseProxy,
}

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
 * A page pushed over the tab content, with its own bar and back arrow.
 *
 * These are not tabs: nobody looks for the log or the about page on the way to a
 * shooting setting, but both have to be reachable from wherever a failure happened.
 */
enum class Page { Log, LogSettings, About, Permissions }

/**
 * Central observable state + orchestration. One instance for the app.
 * All long-running work is launched on [scope].
 */
class AppState(private val graph: AppGraph, private val scope: CoroutineScope) {

    var phase by mutableStateOf(Phase.Idle)
        private set

    /**
     * The pushed pages sitting on top of whichever tab is showing.
     *
     * A stack rather than a flag because the log page pushes its own settings, and 返回
     * from there has to land back on the log — the same reason the library's own
     * sub-pages carry a back arrow instead of a close box.
     */
    private val pages = mutableStateListOf<Page>()

    /** The page on top, or null when the tab underneath is reachable. */
    val topPage: Page? get() = pages.lastOrNull()

    /** Whether any pushed page (the log, its settings, the about page) is showing. */
    val diagnosticsOpen: Boolean get() = pages.isNotEmpty()

    fun pushPage(page: Page) {
        if (pages.lastOrNull() == page) return
        pages += page
        Diag.info(LogTag.LOG, "page ${page.name} opened (depth ${pages.size})")
    }

    /** Back one page; the last one out closes the pushed layer entirely. */
    fun popPage() {
        if (pages.isEmpty()) return
        val gone = pages.removeAt(pages.lastIndex)
        Diag.info(LogTag.LOG, "page ${gone.name} closed (depth ${pages.size})")
    }

    /** Last phase, kept only so a transition line can say where we came from. */
    private var lastPhase: Phase = Phase.Idle

    /**
     * The step a failed connection died on, so the screen can say what to try next
     * rather than only that it failed. Reset at the start of every attempt.
     */
    private var failedPhase by mutableStateOf<Phase?>(null)

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
        pushPage(Page.Log)
    }

    fun closeDiagnostics() {
        pages.clear()
    }

    /**
     * The UI test mode: [UiTestDevice] in place of a camera.
     *
     * Every page then has real-shaped data to draw — both menus, the mode table, the
     * status line, a file list — with nothing in the room. Turning it off puts the app
     * back exactly where an unconnected start would have left it.
     */
    private var uiTestModeState by mutableStateOf(false)

    /** Read-only so the only way in is [setUiTestMode], which sets the device up too. */
    val uiTestMode: Boolean get() = uiTestModeState

    /** Advances the recording clock while the fake camera is "recording". */
    private var uiTestTicker: Job? = null

    fun setUiTestMode(on: Boolean) {
        if (on == uiTestModeState) return
        uiTestModeState = on
        if (on) {
            session = UiTestDevice.session()
            settings = UiTestDevice.settings()
            deviceSettings = UiTestDevice.deviceSettings()
            modes = UiTestDevice.modes()
            files = UiTestDevice.files()
            deviceStatus = UiTestDevice.status()
            goPhase(Phase.Connected)
            Diag.warn(LogTag.APP, "UI TEST MODE on: ${settings.size}+${deviceSettings.size} menu rows, nothing is sent")
            uiTestTicker = scope.launch {
                while (true) {
                    delay(1_000)
                    val st = deviceStatus ?: continue
                    if (st.recording || st.busy) {
                        deviceStatus = st.copy(videoTimeSec = (st.videoTimeSec ?: 0) + 1)
                    }
                }
            }
        } else {
            uiTestTicker?.cancel()
            uiTestTicker = null
            session = null
            settings = emptyList()
            deviceSettings = emptyList()
            modes = emptyList()
            files = emptyList()
            deviceStatus = null
            goPhase(Phase.Idle)
            Diag.info(LogTag.APP, "UI TEST MODE off")
        }
    }

    /**
     * True when the caller must not touch the camera. Every write path opens with this:
     * the mode exists to look at the UI, and a half-sent command would make what is on
     * screen a lie about the device.
     */
    private fun uiTestSkipped(what: String): Boolean {
        if (!uiTestMode) return false
        Diag.warn(LogTag.APP, "UI TEST $what (nothing sent)")
        return true
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
     * Wi-Fi network (see core.wifi.adoptCurrentNetwork / requestNetwork) — and the
     * official apps fail the same way with a proxy up, so a running VPN is worth
     * asking about out loud *once*, at the start of a connection attempt. That is
     * what [vpnPromptOpen] exists for; nothing else in the UI mentions VPN.
     */
    var vpnActive by mutableStateOf(false)
        private set

    /**
     * Shows the connect-time VPN dialog. Set by [askAboutVpn] and cleared by
     * [answerVpnPrompt] or when the attempt is cancelled — never by a timer in the
     * UI, because the dialog is a gate on the connection, not a notice.
     */
    var vpnPromptOpen by mutableStateOf(false)
        private set

    /** Resolved by [answerVpnPrompt]; [askAboutVpn] waits on it. */
    private var vpnGate: CompletableDeferred<VpnChoice>? = null

    /**
     * Stop a connection attempt and ask the user what to do about a running proxy.
     *
     * Called before anything touches Wi-Fi, because the expensive part of a connect
     * — joining the hotspot, walking candidate gateways — is exactly what a VPN eats,
     * and a hotspot woken over Bluetooth closes again while the user reads the dialog.
     * So this waits: [VPN_PROMPT_TIMEOUT_MS] gives the answer budget, after which the
     * attempt continues as if 忽略 was pressed rather than hanging forever on an
     * unanswered question.
     */
    private suspend fun askAboutVpn(): VpnChoice {
        val gate = CompletableDeferred<VpnChoice>()
        vpnGate = gate
        vpnPromptOpen = true
        Diag.info(LogTag.NET, "vpn prompt shown, waiting up to ${VPN_PROMPT_TIMEOUT_MS}ms")
        val answer = try {
            withTimeoutOrNull(VPN_PROMPT_TIMEOUT_MS) { gate.await() }
        } finally {
            vpnPromptOpen = false
            vpnGate = null
        }
        val choice = answer ?: VpnChoice.Proceed
        Diag.info(LogTag.NET, "vpn prompt answered $choice${if (answer == null) " (nobody answered)" else ""}")
        return choice
    }

    /** The dialog's only entry point: [choice] is the button the user pressed. */
    fun answerVpnPrompt(choice: VpnChoice) {
        vpnGate?.complete(choice)
    }

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

    /**
     * When a file's thumbnail last failed, by name. A failed fetch is retried after
     * [THUMB_RETRY_AFTER_MS] rather than dropped for the session: the 2026-09-22 log
     * shows every `.THM` refused because the camera was briefly overwhelmed, and a
     * permanent mark turned that into a gallery of blank cells that never came back.
     */
    private val thumbFailedAt = mutableMapOf<String, Long>()

    /**
     * Insertion order of [thumbnails], so eviction drops what the user has scrolled
     * past rather than what happens to hash first. Only ever touched on the main
     * thread, like the map itself.
     */
    private val thumbSeen = ArrayDeque<String>()

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
            Diag.at(LogLevel.INFO, LogTag.NET, "VPN default route ${if (now) "ACTIVE" else "gone"}")
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
        add("ota" to otaState.toString())    }

    /** Public accessor for the UI (e.g. to build the preview URL). */
    fun protocolOrNull(): CameraProtocol? = protocol

    /**
     * The protocol plugins compiled into this build, for the about page's 已支持的相机
     * list. Read-only: the about page names what the app can talk to, it does not touch
     * the registry.
     */
    fun supportedPlatforms(): Set<DevicePlatform> = graph.registry.platforms()

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
        onHandshakeFailed = { connectBestNetwork() },
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
            connectBestNetwork()
            return
        }
        // Nothing in range: restart the search and say so, rather than leaving an
        // empty screen to be interpreted.
        nearby.refreshNow()
        errorMessage = localized(Res.string.err_no_camera_nearby)
    }

    /**
     * Policy step 3/4: the strongest hotspot we can see, joined with whatever
     * credential we have for it. Also what a dead Bluetooth handshake falls back to,
     * so one radio failing never costs the user the tap.
     */
    private fun connectBestNetwork() {
        val network = nearby.bestNetwork() ?: run {
            errorMessage = localized(Res.string.err_no_camera_nearby)
            return
        }
        val saved = graph.wifiCredentials.passwordFor(network.ssid)
        val factory = graph.registry.defaultPasswordFor(network.ssid)
        val passphrase = saved ?: factory.takeIf { network.secured }
        Diag.info(
            LogTag.APP,
            "CONNECT wifi ${network.ssid} secured=${network.secured} " +
                "credential=${if (saved != null) "saved" else if (passphrase != null) "factory" else "none"}",
        )
        if (network.secured && passphrase == null) askPasswordFor = network else connect(network.ssid, passphrase)
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
        failedPhase = null
        Diag.i { "CONNECT begin ssid=${ssid ?: "-"} manual_host=${manualHost ?: "-"} already_bound=${graph.wifi.isConnectedToCamera}" }
        try {
            // Pin our sockets to the Wi-Fi the phone is on *before* touching the
            // network. A hotspot joined from Settings never passed through
            // connect(), so without this every request follows the default route —
            // and when a VPN owns that route the camera simply stops existing.
            refreshVpnState()
            // The official apps cannot talk to a camera through a running proxy
            // either, so this is the user's call to make, not ours to guess at: the
            // dialog pauses the attempt until they answer, and 去关闭代理 leaves the
            // Wi-Fi alone rather than half-joining a hotspot they just decided to
            // stop the tunnel for.
            if (vpnActive && askAboutVpn() == VpnChoice.CloseProxy) {
                val opened = graph.wifi.openVpnSettings()
                Diag.info(LogTag.NET, "connect aborted so the proxy can be turned off (settings opened=$opened)")
                goPhase(Phase.Idle)
                statusMessage = null
                return
            }
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
                            // Only a passphrase that actually got us associated is
                            // worth keeping: caching a typo would let it outrank the
                            // factory default on every later attempt, forever.
                            if (!password.isNullOrBlank()) graph.wifiCredentials.remember(ssid, password)
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
                    val found = graph.discovery.discover(gw, preferredHost = direct, alreadyTried = listOfNotNull(direct))
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
            // Replace the previous session's scope outright. It was cancelled by
            // disconnect(), but inheriting its (dead) Job meant a connect that never went
            // through disconnect — an auto-connect racing a manual one — left the old
            // protocol's event collector subscribed forever.
            sessionScope?.cancel()
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
        } catch (t: kotlinx.coroutines.CancellationException) {
            // A superseded connect is not a failed one. connect() cancels the previous
            // attempt before starting a new one — the auto-connect on a Settings-joined
            // hotspot racing a tap on 连接 does exactly that — and reporting it as an
            // error put a red banner over a connection that was still being made.
            Diag.info(LogTag.APP, "CONNECT cancelled (superseded or screen gone)")
            throw t
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
        // Belongs to the camera that just went away, and it is a credential: leaving it
        // set would show the previous camera's hotspot name and passphrase on the next
        // connect until somebody pressed 读取 again.
        cameraWifi = null
        files = emptyList()
        settings = emptyList()
        modes = emptyList()
        deviceSettings = emptyList()
        thumbnails.clear()
        thumbSeen.clear()
        thumbsInFlight.clear()
        thumbFailedAt.clear()
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
                // A firmware check or download holds the **internet** route for its whole
                // duration (see WifiController.withInternetRoute), so a poll issued now
                // would leave the phone on the wrong network and come back as "the camera
                // vanished" — which the pill would report and the user would act on.
                // Skipping a tick is cheap; the loop resumes the moment the route is back.
                val s0 = otaState
                if (s0 is OtaState.Checking || s0 is OtaState.Downloading) {
                    Diag.d(LogTag.STATE) { "poll skipped: firmware transfer holds the network route" }
                    delay(POLL_INTERVAL_MS)
                    continue
                }
                // Status polls are bookkeeping, but they must not queue behind a menu
                // walk: the lane lets them over Enumerate so "is the camera still
                // here" is answered promptly even while the gallery is filling in.
                runCatching { withCameraRequest(CameraRequestClass.Status) { proto.getStatus(s) } }
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

    fun capture() {
        if (uiTestSkipped("capture")) {
            deviceStatus = (deviceStatus ?: UiTestDevice.status())
                .copy(photoCount = (deviceStatus?.photoCount ?: 0) + 1)
            return
        }
        runOp(Op.Capture) { proto, s -> proto.capture(s) }
    }

    /**
     * End a running start/stop capture sequence (the camera's 延时拍照 / 定时拍照
     * modes). A mode whose shutter is a single shot never needs this, so the UI only
     * offers it while [captureRunning] is true for a [ModeTrigger.TOGGLE] mode.
     */
    fun stopCapture() {
        if (uiTestSkipped("stopCapture")) return
        runOp(Op.Capture) { proto, s -> proto.stopCapture(s) }
    }

    fun record(start: Boolean) {
        if (uiTestSkipped("record start=$start")) {
            deviceStatus = (deviceStatus ?: UiTestDevice.status()).copy(
                recording = start,
                busy = start,
                workState = if (start) 20 else 0,
                videoTimeSec = if (start) 1 else 0,
            )
            return
        }
        runOp(Op.Record) { proto, s -> proto.record(s, start) }
    }

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
    fun selectMode(mode: CameraMode) {
        if (uiTestSkipped("selectMode ${mode.name}")) {
            deviceStatus = (deviceStatus ?: UiTestDevice.status())
                .copy(modeName = mode.name, mode = mode.family.workMode())
            return
        }
        runOp(Op.Mode) { proto, s ->
            val r = proto.setNamedMode(s, mode)
            if (r.isOk) {
                reloadSettingsForMode(proto, s)
                // The status poll reads at most every POLL_INTERVAL_MS; without this the
                // mode strip would keep highlighting the mode we just left.
                deviceStatus = deviceStatus?.copy(modeName = mode.name, mode = mode.family.workMode())
            }
            r
        }
    }

    /**
     * Change the camera's work mode, then re-read the settings menu: which items
     * exist is a function of the mode, so a stale menu would keep offering
     * video-only settings after the camera moved into a photo mode.
     */
    fun setMode(mode: WorkMode) {
        if (uiTestSkipped("setMode $mode")) {
            deviceStatus = (deviceStatus ?: UiTestDevice.status()).copy(mode = mode)
            return
        }
        runOp(Op.Mode) { proto, s ->
            val r = proto.setMode(s, mode)
            if (r.isOk) reloadSettingsForMode(proto, s)
            r
        }
    }

    fun loadDeviceSettings() = runOp(Op.Settings) { proto, s ->
        val listed = withCameraRequest(CameraRequestClass.Enumerate) { proto.getDeviceSettings(s) }
        deviceSettings = listed
        Diag.i(LogTag.PROTO) { "device settings loaded n=${listed.size} ids=${listed.joinToString(",") { it.id }.take(240)}" }
        CmdResult.Ok
    }

    fun setDeviceSetting(id: String, value: String) {
        if (uiTestSkipped("SET(device) $id -> $value")) {
            deviceSettings = deviceSettings.map { if (it.id == id) it.copy(value = value) else it }
            return
        }
        runOp(Op.Settings) { proto, s ->
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
    }

    fun loadSettings() = runOp(Op.Settings) { proto, s ->
        // A menu walk is one request per row, so it rides the bookkeeping queue: the
        // shutter and the health poll outrank it, and the lane drops it outright while
        // the camera is refusing.
        settings = withCameraRequest(CameraRequestClass.Enumerate) { proto.getSettings(s) }
        Diag.i(LogTag.PROTO) { "settings loaded n=${settings.size} ids=${settings.joinToString(",") { it.id }.take(240)}" }
        CmdResult.Ok
    }

    fun setSetting(id: String, value: String) {
        if (uiTestSkipped("SET $id -> $value")) {
            settings = settings.map { if (it.id == id) it.copy(value = value) else it }
            return
        }
        runOp(Op.Settings) { proto, s ->
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
    }

    /** Re-read the settings menu, which is a function of the camera's work mode. */
    private suspend fun reloadSettingsForMode(proto: CameraProtocol, s: CameraSession) {
        runCatching { withCameraRequest(CameraRequestClass.Enumerate) { proto.getSettings(s) } }
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
        thumbFailedAt.keys.retainAll(present)
        thumbSeen.retainAll(present)
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
        val failedAt = thumbFailedAt[file.name] ?: 0L
        if (thumbnails.containsKey(file.name) || Diag.uptimeMillis() - failedAt < THUMB_RETRY_AFTER_MS) return
        if (thumbsInFlight.size >= MAX_THUMBS_IN_FLIGHT) {
            Diag.debug(
                LogTag.FILE,
                "thumb queued behind ${thumbsInFlight.size} transfers ${file.name}",
            )
            // Ask again shortly. `LaunchedEffect(file.name)` in the row only fires once
            // per row, so dropping the request here would leave that thumbnail blank for
            // the rest of the visit — which reads exactly like "the camera has no
            // preview for this file".
            owner.launch {
                delay(THUMB_RETRY_MS)
                loadThumbnail(file)
            }
            return
        }
        if (!thumbsInFlight.add(file.name)) return
        owner.launch {
            try {
                // Thumbnails are the most optional traffic in the app, so they ride the
                // queue the camera gets to breathe on: below the poll, below the
                // shutter, and dropped outright while the lane is cooling down.
                val bytes = runCatching {
                    withCameraRequest(CameraRequestClass.Enumerate) { proto.thumbnail(s, file) }
                }.getOrNull()
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
                    thumbSeen.addLast(file.name)
                    Diag.v(LogTag.FILE) { "thumb ok ${file.name} ${bytes.size}B ${bitmap.width}x${bitmap.height}" }
                } else {
                    Diag.d(LogTag.FILE) { "thumb unavailable ${file.name} (bytes=${bytes?.size ?: "null"})" }
                    // Don't cache a permanent null: a transient hotspot failure would
                    // otherwise blank this thumbnail for the rest of the session.
                    thumbFailedAt[file.name] = Diag.uptimeMillis()
                }
            } finally {
                thumbsInFlight.remove(file.name)
            }
        }
    }

    /**
     * Evict before inserting, not after: a cache that trims afterwards has already
     * paid for the new bitmap, and one decoded 12 MP frame is ~48 MB of ARGB on a phone
     * this app measured with a 256 MB heap class.
     *
     * Oldest-first comes from [thumbSeen] rather than from `thumbnails.keys`: a
     * snapshot map has no defined iteration order, so "the first key" is as likely to
     * be a row on screen as one scrolled past — the visible thumbnails were the ones
     * disappearing.
     */
    private fun trimThumbnails() {
        while (thumbnails.size >= MAX_CACHED_THUMBNAILS) {
            val oldest = thumbSeen.removeFirstOrNull() ?: thumbnails.keys.firstOrNull() ?: return
            thumbnails.remove(oldest)
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

    fun deleteFile(file: RemoteFile) {
        if (uiTestSkipped("DELETE ${file.name}")) {
            files = files.filterNot { it.name == file.name }
            return
        }
        runOp(Op.Delete) { proto, s ->
            Diag.i(LogTag.FILE) { "DELETE ${file.name} (${file.sizeBytes}B)" }
            val r = proto.deleteFile(s, file)
            if (r.isOk) {
                files = files.filterNot { it.name == file.name }
                thumbnails.remove(file.name)
                thumbFailedAt.remove(file.name)
                thumbSeen.remove(file.name)
            }
            r
        }
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
            thumbFailedAt.remove(f.name)
            thumbSeen.remove(f.name)
        }
        val removed = list.mapTo(mutableSetOf()) { it.name }
        files = files.filterNot { removed.contains(it.name) }
        if (failed > 0) CmdResult.Failure("$failed of ${list.size} files could not be deleted")
        else CmdResult.Ok
    }

    /**
     * Empty the card with a single command, for the album's 「全部删除」.
     *
     * One request instead of [deleteFiles]'s N: on a card holding hundreds of clips the
     * per-file walk is minutes of HTTP, and a session that drops midway leaves the grid
     * half-deleted with no way to tell where it stopped. This is destructive with no
     * second confirmation on the device side (the official app takes a bare 200 as
     * success), so the confirm dialog and the "N deleted" readout live in the UI.
     */
    fun deleteAllFiles() {
        val listed = files.size
        if (uiTestSkipped("DELETE ALL")) {
            clearFileCaches()
            return
        }
        runOp(Op.Delete) { proto, s ->
            Diag.i(LogTag.FILE) { "DELETE ALL ($listed listed)" }
            val r = proto.deleteAllFiles(s)
            if (r.isOk) clearFileCaches()
            r
        }
    }

    /** Drop every per-file cache the grid reads, after the camera's card is emptied. */
    private fun clearFileCaches() {
        files = emptyList()
        thumbnails.clear()
        thumbFailedAt.clear()
        thumbSeen.clear()
    }

    // ---------- device info / maintenance ----------

    /**
     * The hotspot this camera is broadcasting, name and passphrase, read back from the
     * camera itself. Null until somebody asks (`读取` on the settings page, or any
     * 刷新设备信息).
     */
    var cameraWifi by mutableStateOf<CameraWifi?>(null)
        private set

    /** Whether this camera family can answer [readCameraWifi] at all. */
    fun canReadCameraWifi(): Boolean =
        session?.platform == DevicePlatform.HISILICON

    /**
     * Ask the camera what its own hotspot is called and what key it wants.
     *
     * This is the read half of 相机 Wi-Fi; without it the rename form below it is the
     * only thing on the screen, i.e. you can set a password you can never see again.
     */
    fun readCameraWifi() = runOp(Op.Wifi) { proto, s ->
        val wifi = proto.getWifi(s)
        if (wifi == null) {
            cameraWifi = null
            CmdResult.Failure("这台相机没有回读 Wi-Fi 信息（getwifi.cgi 未给出 wifissid）")
        } else {
            cameraWifi = wifi
            // Never the passphrase itself: the log is exported and shared, and unlike
            // every other field here it is a credential. Length only, matching what
            // setwifi already logs about the same value.
            Diag.info(LogTag.DEV, "camera wifi read ssid=${wifi.ssid} keylen=${wifi.password?.length ?: 0}")
            CmdResult.Ok
        }
    }

    fun loadDeviceInfo() = runOp(Op.DeviceInfo) { proto, s ->
        val info = proto.getDeviceInfo(s)
        deviceInfo = info
        // One press of 刷新设备信息 refreshes the identity *and* the hotspot, because the
        // About group shows the SSID and a rename is exactly the moment a stale one
        // misleads someone. Kept separate from `cameraWifi`'s own op so the Wi-Fi row
        // can also be refreshed on its own.
        runCatching { proto.getWifi(s) }
            .onSuccess { wifi ->
                if (wifi != null) {
                    cameraWifi = wifi
                    Diag.info(LogTag.DEV, "camera wifi during device-info refresh ssid=${wifi.ssid} keylen=${wifi.password?.length ?: 0}")
                }
            }
            .onFailure { Diag.debug(LogTag.DEV, "getwifi alongside device info threw ${Diag.causeChain(it)}") }
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

    /**
     * The SSID to show in the About group: the camera's own answer if we have it, and
     * otherwise whatever `getdeviceattr` happened to include. There is deliberately no
     * third source — the phone's current Wi-Fi is not evidence about the camera.
     */
    fun displayedSsid(): String? = cameraWifi?.ssid ?: deviceInfo?.ssid

    fun formatSd() = runOp(Op.FormatSd) { proto, s ->
        Diag.w(LogTag.FILE) { "FORMAT SD requested — this erases the card" }
        val r = proto.formatSd(s)
        if (r.isOk) {
            // Formatting wipes the card: drop cached listings and thumbnails, then
            // repull so the UI shows the (empty) card instead of stale files.
            thumbnails.clear()
            thumbSeen.clear()
            thumbFailedAt.clear()
            files = proto.listFiles(s, 0, LISTING_PAGE)
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

    /**
     * Ask the camera to raise its hotspot again. The non-Bluetooth half of "the
     * camera is on but the phone cannot see it": useful when the firmware was left in
     * STA mode, or its AP stopped while the app was closed.
     */
    fun raiseAccessPoint() = runOp(Op.AccessPoint) { proto, s -> proto.ensureAccessPoint(s) }

    /** Whether this camera family can be told to broadcast again at all. */
    fun canRaiseAccessPoint(): Boolean =
        session?.platform == DevicePlatform.HISILICON

    // ---------- firmware OTA ----------

    /**
     * Whether the connected camera family supports firmware updates yet. Only the
     * Hisilicon CGI transport is implemented so far (doc 04's "start with Hisilicon").
     */
    fun firmwareUpdateSupported(): Boolean =
        session?.platform == DevicePlatform.HISILICON

    private val firmwareUpdater: FirmwareUpdater by lazy {
        FirmwareUpdater(graph.http, graph.wifi, graph.fileSaver.firmwareDir())
    }

    /** The coroutine behind whichever OTA phase is running — the one thing cancel can act on. */
    private var otaJob: Job? = null

    /**
     * The build the camera is running, preferring what the last full `getDeviceInfo`
     * read to what `connect` cached, because the user can 刷新设备信息 without
     * reconnecting and a firmware update is exactly when they would.
     */
    private fun installedFirmware(): String? =
        deviceInfo?.softVersion?.takeIf { it.isNotBlank() }
            ?: session?.extras?.get("softversion")?.takeIf { it.isNotBlank() }

    /**
     * Ask the vendor's public index whether this camera has a newer build.
     *
     * Read-only, and the one step of the whole feature that cannot damage anything, so
     * it is the row the screen offers first. The request goes out on the internet route
     * while the camera link is parked (see [FirmwareUpdater]).
     */
    fun checkForFirmwareUpdate() {
        val base = session ?: run {
            otaState = OtaState.Failed("没有连接相机，无法检查更新。")
            return
        }
        val owner = sessionScope ?: return
        if (!firmwareUpdateSupported()) {
            Diag.at(LogLevel.WARN, LogTag.OTA, "check unsupported on ${base.platform.displayName}")
            otaState = OtaState.Failed("暂不支持为 ${base.model} 这个系列的相机检查固件更新。")
            return
        }
        cancelOtaWork("superseded by a new check")
        val installed = installedFirmware()
        Diag.info(LogTag.OTA, "check requested for ${base.model} installed=${installed ?: "?"} at ${base.host}")
        otaState = OtaState.Checking
        otaJob = owner.launch {
            val plan = runCatching { firmwareUpdater.check(base.model, installed) }.getOrElse {
                Diag.at(LogLevel.ERROR, LogTag.OTA, "check threw ${Diag.causeChain(it)}")
                otaState = OtaState.Failed("检查更新失败：${it.message ?: "网络错误"}")
                return@launch
            }
            otaState = when (plan) {
                is UpdatePlan.Available -> OtaState.Available(plan.installed, plan.offer)
                is UpdatePlan.UpToDate -> OtaState.UpToDate(plan.installed)
                is UpdatePlan.NoEntry -> OtaState.NoEntry(plan.installed)
                is UpdatePlan.NewerInstalled -> OtaState.Failed(
                    "相机当前的固件（${plan.installed ?: "?"}）比云端公布的最新包（${plan.newest.version}）更新，" +
                        "本 App 不做降级。",
                )
                is UpdatePlan.CannotCompare -> OtaState.Failed(
                    "无法比较版本：相机上报的「${plan.installed ?: "无"}」里没有一个可比较的 8 位日期号，" +
                        "请改用「选择本地固件包」。",
                )
            }
        }
    }

    /**
     * Fetch the package the index offered. The whole of [otaState]'s download phase
     * happens here; the camera is not touched and does not need to be touched, which is
     * why a download can be resumed after a dropped connection without re-pairing.
     */
    fun downloadFirmwareUpdate(offer: FirmwareOffer) {
        val owner = sessionScope ?: return
        cancelOtaWork("superseded by a new download")
        Diag.info(LogTag.OTA, "download requested ${offer.fileName} ${LogFormat.size(offer.sizeBytes)}")
        otaState = OtaState.Downloading(0f, 0L, offer.sizeBytes)
        otaJob = owner.launch {
            // Progress arrives far faster than the frame clock; publishing every chunk
            // would recompose the settings list ~1,700 times per package for a bar that
            // can show 1% steps.
            var lastPublished = 0L
            val result = firmwareUpdater.download(offer) { fraction, done, total ->
                val now = Diag.uptimeMillis()
                if (now - lastPublished >= 250L || (total > 0 && done >= total)) {
                    lastPublished = now
                    otaState = OtaState.Downloading(fraction, done, total)
                }
            }
            when (result) {
                is PackageResult.Ready -> {
                    Diag.info(LogTag.OTA, "package verified ${result.path.name} ${LogFormat.size(result.bytes)}")
                    otaState = OtaState.ReadyToInstall(offer, result.path, result.bytes)
                }
                is PackageResult.Failed -> {
                    Diag.at(LogLevel.ERROR, LogTag.OTA, "download failed: ${result.message}")
                    otaState = OtaState.Failed(result.message)
                }
            }
        }
    }

    /** Install the package that is already on disk and verified. */
    fun installPreparedFirmware() {
        val ready = otaState as? OtaState.ReadyToInstall ?: return
        startInstall(
            FirmwarePackage(
                path = ready.path,
                sizeBytes = ready.bytes,
                fileName = ready.offer.fileName,
                version = ready.offer.normalized ?: ready.offer.version,
            ),
        )
    }

    /** Whether to offer the "install a file I chose myself" row on this platform. */
    fun supportsLocalFirmwarePackage(): Boolean = firmwareLocalPickerAvailable

    /** Desktop-only escape hatch: install a file the user picked themselves. */
    fun installChosenFirmwarePackage() {
        val owner = sessionScope ?: return
        if (!firmwareUpdateSupported()) {
            otaState = OtaState.Failed("暂不支持为这台相机更新固件。")
            return
        }
        cancelOtaWork("superseded by a locally chosen package")
        otaJob = owner.launch {
            val pkg = runCatching { pickCameraFirmwarePackage() }.getOrElse {
                Diag.at(LogLevel.ERROR, LogTag.OTA, "firmware picker failed ${Diag.causeChain(it)}")
                null
            }
            if (pkg == null) {
                Diag.i(LogTag.OTA) { "no package chosen; aborting" }
                if (!otaState.isTerminal) otaState = OtaState.Cancelled
                return@launch
            }
            startInstall(pkg)
        }
    }

    /**
     * Hand a package to the camera and see the update through its reboot.
     *
     * Must not be running while the internet route is held — [FirmwareUpdater] releases
     * it as soon as the download ends, and the transfers below go back out over the
     * camera network.
     */
    private fun startInstall(pkg: FirmwarePackage) {
        val base = session ?: return
        val proto = protocol ?: return
        val owner = sessionScope ?: return
        Diag.info(
            LogTag.OTA,
            "install ${pkg.fileName} ${LogFormat.size(pkg.sizeBytes)} version=${pkg.version ?: "?"} via ${base.platform.displayName}",
        )
        cancelOtaWork("superseded by an install")
        val coord = OtaCoordinator(
            transport = ChainedOtaTransport(
                channels = listOf(
                    // The channel the official app ships for this camera class first, and
                    // the CGI pair behind it; see ChainedOtaTransport for why that order is
                    // safe to fall through.
                    XtuSocketOtaTransport(graph.tcp, graph.http),
                    HisiliconOtaTransport(graph.http),
                ),
                preHandshakeFailures = setOf(
                    XtuSocketOtaTransport.ERR_CONNECT,
                    XtuSocketOtaTransport.ERR_HEADER_WRITE,
                    XtuSocketOtaTransport.ERR_CMD_MISMATCH,
                    XtuSocketOtaTransport.ERR_HANDSHAKE_READ,
                    XtuSocketOtaTransport.ERR_MD5_WRITE,
                ),
            ),
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
        otaJob = owner.launch { coord.run(pkg) }
    }

    /** Stop whatever OTA coroutine is running, without announcing a cancellation. */
    private fun cancelOtaWork(reason: String) {
        otaCoordinator?.cancel()
        otaCoordinator = null
        otaJob?.let {
            if (it.isActive) Diag.debug(LogTag.OTA, "cancelling the running OTA phase ($reason)")
            it.cancel()
        }
        otaJob = null
    }

    fun cancelFirmwareUpdate() {
        Diag.warn(LogTag.OTA, "cancel requested at ${otaState::class.simpleName}")
        // Cancelling the coordinator only flips its state; the coroutine keeps pushing
        // bytes until its job goes too, which is the difference between a cancelled
        // download and a package that finishes downloading into a screen saying 已取消.
        cancelOtaWork("user pressed 取消")
        if (!otaState.isTerminal) otaState = OtaState.Cancelled
    }

    /** Dismiss a terminal OTA state so the update button returns. */
    fun resetOtaState() {
        if (otaState.isTerminal) otaState = OtaState.Idle
    }

    fun download(file: RemoteFile, force: Boolean = false) {
        if (uiTestSkipped("DOWNLOAD ${file.name}")) return
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
                    // A file the phone already holds in full is not fetched again: the
                    // old path fell through to a from-zero re-download here (resume only
                    // engages on a *partial* file), so a batch quietly pulled gigabytes
                    // the user already had. `force` is the escape hatch for a genuinely
                    // corrupt local copy.
                    if (!force && file.sizeBytes > 0L && have == file.sizeBytes) {
                        Diag.i(LogTag.DL) { "SKIP ${file.name} — already on disk (${LogFormat.size(have)})" }
                        markDone(file, dest.toString())
                        return@withContext
                    }
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
                    if (ms > 0) lastRateBps = written * 1000 / ms
                    markDone(file, published ?: dest.toString())
                    Diag.i(LogTag.DL) {
                        "DONE ${file.name} ${LogFormat.size(written)} in ${ms}ms " +
                            "(${LogFormat.size(lastRateBps)}/s) -> ${published ?: dest}"
                    }
                    if (published == null) {
                        errorMessage = localized(Res.string.err_gallery_rejected)
                    }
                } catch (t: kotlinx.coroutines.CancellationException) {
                    // Disconnecting cancels the session scope, and this coroutine lives
                    // in it. Banner-ing "download interrupted" for a transfer the user
                    // ended on purpose — and then marking the queue entry failed — turned
                    // every clean disconnect into a red error.
                    Diag.info(LogTag.DL, "download ${file.name} cancelled (${t.message ?: "scope closed"})")
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

    private fun markDone(file: RemoteFile, localPath: String) {
        val i = downloads.indexOfFirst { it.file.name == file.name }
        if (i >= 0) downloads[i] = downloads[i].copy(
            state = DownloadItem.State.Done, progress = 1f, localPath = localPath,
        )
    }

    /** Bytes/second from the last completed transfer; 0 until one finishes. */
    private var lastRateBps: Long = 0

    /**
     * Seconds left on the queue, from the bytes still owed and the last measured rate.
     * Null when nothing is running or no transfer has finished yet — a guessed speed
     * would be a worse answer than no number at all. Files the camera never sized
     * contribute nothing, so the estimate is a floor, never a fabrication.
     */
    fun downloadEtaSeconds(): Int? {
        val pending = downloads.filter {
            it.state == DownloadItem.State.Running || it.state == DownloadItem.State.Queued
        }
        if (pending.isEmpty()) return null
        val remaining = pending.sumOf { d ->
            val total = d.file.sizeBytes
            if (total <= 0L) 0L else (total - (total * d.progress).toLong()).coerceAtLeast(0L)
        }
        val rate = lastRateBps
        if (remaining <= 0L || rate <= 0L) return null
        return (remaining / rate).coerceAtLeast(1L).toInt()
    }

    private fun runOp(op: Op, block: suspend (CameraProtocol, CameraSession) -> CmdResult) =
        (sessionScope ?: scope).launch {
            // The backstop for the UI test mode: the write paths that have something to
            // show for themselves (settings, shutter, mode) return before ever getting
            // here, and everything else — listings, deletes, time sync, the Wi-Fi and OTA
            // walks — stops here rather than reaching a camera that is not there.
            if (uiTestMode) {
                Diag.warn(LogTag.APP, "UI TEST skipped $op: no camera behind the test device")
                return@launch
            }
            val proto = protocol
            val s = session
            if (proto == null || s == null) {
                Diag.at(LogLevel.WARN, LogTag.APP, "SKIP $op: no live session (phase=${phase.name})")
                return@launch
            }
            withContext(OpContext("c${Diag.nextId()}:${op.name.lowercase()}") + CameraRequest(op.requestClass())) {
                runOperation(op, proto, s, block)
            }
        }

    /**
     * Which queue this operation's camera requests ride.
     *
     * Everything the user pressed is a [CameraRequestClass.Command] — the shutter must
     * never wait behind a menu walk. Listing and device-info reads are bookkeeping and
     * yield to both the shutter and the health poll.
     */
    private fun Op.requestClass(): CameraRequestClass = when (this) {
        Op.Refresh, Op.DeviceInfo -> CameraRequestClass.Enumerate
        else -> CameraRequestClass.Command
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

    /**
     * What to try next after a failed connection, keyed by the step it died on.
     *
     * The official app carries a "solutions" line for the two dead ends users hit most —
     * the camera never appearing, and the join timing out — and those dead ends are
     * exactly where it leaves you watching a spinner. Three groups cover every phase this
     * app can fail on; null when the last attempt did not fail.
     */
    fun connectRemedy(): LocalizedString? = when (failedPhase) {
        Phase.ScanningWifi, Phase.ScanningBle -> localized(Res.string.remedy_not_found)
        Phase.WakingAp, Phase.ConnectingWifi -> localized(Res.string.remedy_join_failed)
        Phase.IdentifyingDevice, Phase.ConnectingProtocol -> localized(Res.string.remedy_unidentified)
        else -> null
    }

    private fun fail(msg: LocalizedString) {
        // The phase we were in *before* Error is the step that failed — read here because
        // goPhase() below overwrites lastPhase.
        failedPhase = lastPhase
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
 * How long [com.rovecamlink.app.AppState.askAboutVpn] waits for an answer before it
 * treats silence as 忽略 and carries on. It has to outlast reading a dialog plus
 * finding the proxy app — but the camera's hotspot was woken over Bluetooth for this
 * attempt, and sitting on an unanswered question lets it close again, so the wait is
 * bounded rather than forever.
 */
private const val VPN_PROMPT_TIMEOUT_MS = 60_000L

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
 * Preview fetches allowed at the same moment. One hotspot serves the status poll, the
 * live view and this list; the requests themselves are now serialised by the transport
 * lane, so this cap is about how many decodes the phone holds at once rather than how
 * many sockets the camera sees. Two is enough to keep the strip moving.
 */
private const val MAX_THUMBS_IN_FLIGHT = 2

/** How long a thumbnail turned away by the cap waits before asking again. */
private const val THUMB_RETRY_MS = 400L

/**
 * How long a failed thumbnail waits before it is worth asking again. Long enough for
 * the lane's cooldown to end, short enough that a gallery fills in by itself instead
 * of staying blank because one request lost a race.
 */
private const val THUMB_RETRY_AFTER_MS = 10_000L
