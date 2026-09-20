package com.rovecamlink.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.graphics.ImageBitmap
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.protocol.CameraProtocol
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
    ConnectingWifi,
    IdentifyingDevice,
    ConnectingProtocol,
    Connected,
    Error,
}

/** A discrete user/system operation so the UI can grey out only the relevant control. */
enum class Op { Capture, Record, Mode, Refresh, Delete, Settings }

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
    var statusMessage by mutableStateOf<LocalizedString?>(null)
        private set
    var errorMessage by mutableStateOf<LocalizedString?>(null)

    var networks by mutableStateOf<List<CameraNetwork>>(emptyList())
        private set

    var session by mutableStateOf<CameraSession?>(null)
        private set
    var deviceStatus by mutableStateOf<DeviceStatus?>(null)
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

    /**
     * Bound to the live connection and cancelled on disconnect, so a refresh or
     * download started against a dead session can never write back into the UI.
     */
    private var sessionScope: CoroutineScope? = null
    private var consecutivePollFailures = 0
    private val protocol: CameraProtocol?
        get() = session?.let { graph.registry.protocolFor(it.platform) }

    init {
        // A hotspot the user joined from system settings never passes through
        // connect(), so watch the default network and auto-discover camera SSIDs.
        graph.wifi.watchWifiChanges { ssid ->
            if (ssid == null || session != null) return@watchWifiChanges
            if (phase != Phase.Idle && phase != Phase.Error) return@watchWifiChanges
            if (DEFAULT_PREFIXES.none { ssid.startsWith(it, ignoreCase = true) }) return@watchWifiChanges
            connect()
        }
    }

    /** Public accessor for the UI (e.g. to build the preview URL). */
    fun protocolOrNull(): CameraProtocol? = protocol

    fun isBusy(op: Op): Boolean = busy.contains(op)
    private fun setBusy(op: Op, on: Boolean) {
        if (on && !busy.contains(op)) busy.add(op)
        if (!on) busy.remove(op)
    }

    // ---------- WiFi + discovery ----------

    fun scanWifi() = scope.launch {
        phase = Phase.ScanningWifi
        errorMessage = null
        // Scanning needs ACCESS_FINE_LOCATION on every API level (NEARBY_WIFI_DEVICES
        // alone is not enough for scan results). Without this the platform denies the
        // scan and we would silently report "no cameras".
        val granted = runCatching { graph.permissions.ensureWifiPermissions() }
            .getOrElse {
                phase = Phase.Idle
                errorMessage = localized(Res.string.err_permission_ask_failed, it.message ?: "")
                return@launch
            }
        if (!granted) {
            phase = Phase.Idle
            errorMessage = localized(Res.string.err_scan_needs_location)
            return@launch
        }
        runCatching { graph.scanner.scan() }
            .onSuccess { networks = it }
            .onFailure { errorMessage = localized(Res.string.err_scan_failed, it.message ?: "") }
        if (phase == Phase.ScanningWifi) phase = Phase.Idle
    }

    /** Full auto-connect: join WiFi (or use current), find device, pick protocol, connect. */
    fun connect(ssid: String? = null, password: String? = null, manualHost: String? = null) = scope.launch {
        errorMessage = null
        try {
            var host = manualHost
            var port = 80
            if (host != null && host.contains(":")) {
                val parts = host.split(":")
                host = parts[0]
                port = parts[1].toIntOrNull() ?: 80
            }
            if (host == null) {
                // Joining a network we're already on is a no-op the OS rejects (or
                // re-prompts for), so skip it when the user joined in system settings.
                val alreadyOnTarget = ssid != null &&
                    graph.wifi.currentCameraSsid().equals(ssid, ignoreCase = true)
                if (ssid != null && !alreadyOnTarget) {
                    phase = Phase.ConnectingWifi
                    statusMessage = localized(Res.string.status_joining_wifi, ssid)
                    val ok = graph.permissions.ensureWifiPermissions()
                    if (!ok) { fail(localized(Res.string.err_wifi_permissions_denied)); return@launch }
                    when (val r = graph.wifi.connect(ssid, password)) {
                        is WifiResult.Connected -> {
                            statusMessage = localized(Res.string.status_wifi_joined_locating)
                        }
                        is WifiResult.Failed -> { fail(localized(Res.string.err_wifi_failed, r.message)); return@launch }
                        WifiResult.Cancelled -> { fail(localized(Res.string.err_wifi_cancelled)); return@launch }
                    }
                } else if (alreadyOnTarget) {
                    statusMessage = localized(Res.string.status_already_on_wifi, ssid)
                }
                phase = Phase.IdentifyingDevice
                statusMessage = localized(Res.string.status_detecting_model)
                val found = graph.discovery.discover(graph.wifi.gateway())
                if (found == null) { fail(localized(Res.string.err_no_camera_found)); return@launch }
                host = found.first
            }

            phase = Phase.ConnectingProtocol
            statusMessage = localized(Res.string.status_connecting_to_camera)
            val h = host ?: run { fail(localized(Res.string.err_no_host_resolved)); return@launch }
            val platform: DevicePlatform = graph.discovery.identify(h, port)
                ?: run { fail(localized(Res.string.err_unsupported_camera, h, port)); return@launch }
            val proto = graph.registry.protocolFor(platform) ?: run { fail(localized(Res.string.err_no_plugin, platform.displayName)); return@launch }
            val s = proto.connect(h, port)
            session = s
            sessionScope = CoroutineScope(scope.coroutineContext + Job())
            consecutivePollFailures = 0
            phase = Phase.Connected
            statusMessage = localized(Res.string.status_connected_platform, platform.displayName)
            startPolling()
            loadSettings()
            refreshFiles()
        } catch (t: Throwable) {
            fail(t.message?.let(::raw) ?: localized(Res.string.err_connection_error))
        }
    }

    fun disconnect() = scope.launch {
        // Kill everything bound to the session first: an in-flight refresh or
        // download would otherwise repopulate state for a session that's gone.
        sessionScope?.cancel()
        sessionScope = null
        pollJob?.cancel()
        pollJob = null
        session = null
        deviceStatus = null
        files = emptyList()
        settings = emptyList()
        thumbnails.clear()
        thumbsInFlight.clear()
        thumbFailed.clear()
        downloads.clear()
        busy.clear()
        phase = Phase.Idle
        statusMessage = null
        runCatching { graph.wifi.disconnect() }
    }

    private fun startPolling() {
        val owner = sessionScope ?: return
        pollJob?.cancel()
        pollJob = owner.launch {
            val proto = protocol ?: return@launch
            val s = session ?: return@launch
            while (true) {
                runCatching { proto.getStatus(s) }
                    .onSuccess {
                        deviceStatus = it
                        consecutivePollFailures = 0
                    }
                    .onFailure {
                        // One hiccup is normal on a congested hotspot; a run of them
                        // means the camera is gone, and the pill must say so.
                        if (++consecutivePollFailures == POLL_FAILURES_BEFORE_LOST) {
                            errorMessage = localized(Res.string.err_camera_stopped)
                            disconnect()
                        }
                    }
                delay(1500)
            }
        }
    }

    // ---------- Controls ----------

    fun capture() = runOp(Op.Capture) { proto, s -> proto.capture(s) }
    fun record(start: Boolean) = runOp(Op.Record) { proto, s -> proto.record(s, start) }
    fun setMode(mode: WorkMode) = runOp(Op.Mode) { proto, s -> proto.setMode(s, mode) }

    fun loadSettings() = runOp(Op.Settings) { proto, s ->
        settings = proto.getSettings(s)
        CmdResult.Ok
    }

    fun setSetting(id: String, value: String) = runOp(Op.Settings) { proto, s ->
        val r = proto.setSetting(s, id, value)
        if (r.isOk) loadSettingsBlocking(proto, s)
        r
    }

    private suspend fun loadSettingsBlocking(proto: CameraProtocol, s: CameraSession) {
        runCatching { settings = proto.getSettings(s) }
    }

    fun refreshFiles() = runOp(Op.Refresh) { proto, s ->
        val listed = proto.listFiles(s, 0, 999)
        // Forget thumbnails for files that no longer exist; keep the rest so a
        // refresh doesn't re-download images we already have.
        val present = listed.mapTo(mutableSetOf()) { it.name }
        thumbnails.keys.retainAll(present)
        thumbFailed.retainAll(present)
        files = listed
        CmdResult.Ok
    }

    /**
     * Fetches and decodes the preview image for [file] once. Safe to call from a
     * composition: repeat calls for the same file are ignored while one is in
     * flight or already resolved.
     */
    fun loadThumbnail(file: RemoteFile) {
        val proto = protocol ?: return
        val s = session ?: return
        val owner = sessionScope ?: return
        if (thumbnails.containsKey(file.name) || thumbFailed.contains(file.name)) return
        if (!thumbsInFlight.add(file.name)) return
        owner.launch {
            try {
                val bytes = runCatching { proto.thumbnail(s, file) }.getOrNull()
                val bitmap = bytes?.let {
                    withContext(Dispatchers.Default) {
                        runCatching { it.decodeToImageBitmap() }.getOrNull()
                    }
                }
                if (bitmap != null) {
                    thumbnails[file.name] = bitmap
                    trimThumbnails()
                } else {
                    // Don't cache a permanent null: a transient hotspot failure would
                    // otherwise blank this thumbnail for the rest of the session.
                    thumbFailed.add(file.name)
                }
            } finally {
                thumbsInFlight.remove(file.name)
            }
        }
    }

    private fun trimThumbnails() {
        while (thumbnails.size > MAX_CACHED_THUMBNAILS) {
            thumbnails.remove(thumbnails.keys.first())
        }
    }

    fun deleteFile(file: RemoteFile) = runOp(Op.Delete) { proto, s ->
        val r = proto.deleteFile(s, file)
        if (r.isOk) {
            files = files.filterNot { it.name == file.name }
            thumbnails.remove(file.name)
            thumbFailed.remove(file.name)
        }
        r
    }

    fun download(file: RemoteFile) {
        val proto = protocol ?: return
        val s = session ?: return
        val owner = sessionScope ?: return
        val current = downloads.firstOrNull { it.file.name == file.name }
        if (current != null && current.state != DownloadItem.State.Failed) return
        if (current != null) downloads.remove(current)
        downloads.add(DownloadItem(file, state = DownloadItem.State.Running))
        owner.launch {
            try {
                // Pre-API-29 saving goes through public external storage and needs
                // WRITE_EXTERNAL_STORAGE; on 29+ this is a no-op returning true.
                if (!graph.permissions.ensureStoragePermissions()) {
                    markFailed(file, localized(Res.string.err_storage_permission))
                    return@launch
                }
                val dir = graph.fileSaver.downloadsDir()
                // The name came from the device's own listing; never let it escape
                // the staging directory.
                val dest: Path = dir / sanitizeFileName(file.name)
                val have = runCatching { okio.FileSystem.SYSTEM.metadata(dest).size }.getOrNull() ?: 0L
                // Resume only into a genuinely partial file; a complete or oversized
                // leftover has to be re-fetched from zero.
                val resumeFrom = if (have > 0L && (file.sizeBytes <= 0L || have < file.sizeBytes)) have else 0L
                val written = proto.download(s, file, dest, resumeFrom) { p ->
                    val i = downloads.indexOfFirst { it.file.name == file.name }
                    if (i >= 0) downloads[i] = downloads[i].copy(progress = p)
                }
                if (written < 0L) {
                    markFailed(file, localized(Res.string.err_download_interrupted))
                    return@launch
                }
                if (file.sizeBytes > 0L && written != file.sizeBytes) {
                    markFailed(file, localized(Res.string.err_download_incomplete, written, file.sizeBytes))
                    return@launch
                }
                val mime = if (file.type == com.rovecamlink.app.core.model.FileType.PHOTO) "image/jpeg" else "video/mp4"
                val published = runCatching { graph.fileSaver.publishToGallery(dest, file.name, mime) }.getOrNull()
                val i = downloads.indexOfFirst { it.file.name == file.name }
                if (i >= 0) downloads[i] = downloads[i].copy(
                    state = DownloadItem.State.Done, progress = 1f, localPath = published ?: dest.toString(),
                )
                if (published == null) {
                    errorMessage = localized(Res.string.err_gallery_rejected)
                }
            } catch (t: Throwable) {
                markFailed(file, t.message?.let(::raw) ?: localized(Res.string.err_download_failed))
            }
        }
    }

    /** True while this file has a queued/running transfer. */
    fun downloadState(name: String): DownloadItem.State? =
        downloads.firstOrNull { it.file.name == name }?.state

    fun downloadError(name: String): LocalizedString? =
        downloads.firstOrNull { it.file.name == name }?.error

    private fun markFailed(file: RemoteFile, reason: LocalizedString) {
        val i = downloads.indexOfFirst { it.file.name == file.name }
        if (i >= 0) downloads[i] = downloads[i].copy(state = DownloadItem.State.Failed, error = reason)
        errorMessage = reason
    }

    private inline fun runOp(op: Op, crossinline block: suspend (CameraProtocol, CameraSession) -> CmdResult) = (sessionScope ?: scope).launch {
        val proto = protocol ?: return@launch
        val s = session ?: return@launch
        setBusy(op, true)
        try {
            val r = block(proto, s)
            if (r is CmdResult.Failure) errorMessage = raw(r.message)
            // refresh status promptly after a control action
            runCatching { deviceStatus = proto.getStatus(s) }
        } catch (t: Throwable) {
            errorMessage = t.message?.let(::raw) ?: localized(Res.string.err_command_failed)
        } finally {
            setBusy(op, false)
        }
    }

    private fun fail(msg: LocalizedString) {
        errorMessage = msg
        phase = Phase.Error
        statusMessage = null
    }
}

private const val POLL_FAILURES_BEFORE_LOST = 3

/** Decoded thumbnails held at once; beyond this the oldest are evicted. */
private const val MAX_CACHED_THUMBNAILS = 120
