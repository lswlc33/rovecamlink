package com.rovecamlink.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.protocol.CameraProtocol
import com.rovecamlink.app.core.wifi.CameraNetwork
import com.rovecamlink.app.core.wifi.WifiResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okio.Path

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
enum class Op { Capture, Record, Mode, Refresh, Download, Delete, Settings }

/** Download queue entry. */
data class DownloadItem(
    val file: RemoteFile,
    val progress: Float = 0f,
    val state: State = State.Queued,
    val localPath: String? = null,
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
    var statusMessage by mutableStateOf("")
        private set
    var errorMessage by mutableStateOf<String?>(null)

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

    private var pollJob: Job? = null
    private val protocol: CameraProtocol?
        get() = session?.let { graph.registry.protocolFor(it.platform) }

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
        runCatching { graph.scanner.scan() }
            .onSuccess { networks = it }
            .onFailure { errorMessage = "Scan failed: ${it.message}" }
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
                if (ssid != null) {
                    phase = Phase.ConnectingWifi
                    statusMessage = "Joining $ssid…"
                    val ok = graph.permissions.ensureWifiPermissions()
                    if (!ok) { fail("WiFi permissions denied"); return@launch }
                    when (val r = graph.wifi.connect(ssid, password)) {
                        is WifiResult.Connected -> {
                            statusMessage = "WiFi joined. Locating camera…"
                        }
                        is WifiResult.Failed -> { fail("WiFi: ${r.message}"); return@launch }
                        WifiResult.Cancelled -> { fail("WiFi connect cancelled"); return@launch }
                    }
                }
                phase = Phase.IdentifyingDevice
                statusMessage = "Detecting camera model…"
                val found = graph.discovery.discover(graph.wifi.gateway())
                if (found == null) { fail("No camera found on this network"); return@launch }
                host = found.first
            }

            phase = Phase.ConnectingProtocol
            statusMessage = "Connecting to camera…"
            val h = host ?: run { fail("No camera host resolved"); return@launch }
            val platform: DevicePlatform = graph.discovery.identify(h, port)
                ?: run { fail("Unsupported camera at $h:$port"); return@launch }
            val proto = graph.registry.protocolFor(platform) ?: run { fail("No plugin for $platform"); return@launch }
            val s = proto.connect(h, port)
            session = s
            phase = Phase.Connected
            statusMessage = "Connected · ${platform.displayName}"
            startPolling()
            loadSettings()
            refreshFiles()
        } catch (t: Throwable) {
            fail(t.message ?: "Connection error")
        }
    }

    fun disconnect() = scope.launch {
        pollJob?.cancel()
        session = null
        deviceStatus = null
        files = emptyList()
        settings = emptyList()
        phase = Phase.Idle
        statusMessage = ""
        runCatching { graph.wifi.disconnect() }
    }

    private fun startPolling() {
        pollJob?.cancel()
        pollJob = scope.launch {
            val proto = protocol ?: return@launch
            val s = session ?: return@launch
            while (true) {
                runCatching { proto.getStatus(s) }
                    .onSuccess { deviceStatus = it }
                    .onFailure { /* transient; keep last status */ }
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
        files = proto.listFiles(s, 0, 999)
        CmdResult.Ok
    }

    fun deleteFile(file: RemoteFile) = runOp(Op.Delete) { proto, s ->
        val r = proto.deleteFile(s, file)
        if (r.isOk) files = files.filterNot { it.name == file.name }
        r
    }

    fun download(file: RemoteFile) {
        val proto = protocol ?: return
        val s = session ?: return
        if (downloads.any { it.file.name == file.name && it.state != State_Done }) return
        val item = DownloadItem(file)
        downloads.add(item)
        scope.launch {
            setBusy(Op.Download, true)
            try {
                val idx = downloads.indexOfFirst { it.file.name == file.name }
                downloads[idx] = downloads[idx].copy(state = DownloadItem.State.Running)
                val dir = graph.fileSaver.downloadsDir()
                val dest: Path = dir / file.name
                val existing = runCatching { okio.FileSystem.SYSTEM.metadata(dest).size ?: 0L }.getOrDefault(0L)
                val written = proto.download(s, file, dest) { p ->
                    val i = downloads.indexOfFirst { it.file.name == file.name }
                    if (i >= 0) downloads[i] = downloads[i].copy(progress = p)
                }
                if (written > 0) {
                    val mime = if (file.type == com.rovecamlink.app.core.model.FileType.PHOTO) "image/jpeg" else "video/mp4"
                    val published = runCatching { graph.fileSaver.publishToGallery(dest, file.name, mime) }.getOrNull()
                    val i = downloads.indexOfFirst { it.file.name == file.name }
                    if (i >= 0) downloads[i] = downloads[i].copy(
                        state = DownloadItem.State.Done, progress = 1f, localPath = published ?: dest.toString(),
                    )
                } else {
                    markFailed(file)
                }
            } catch (_: Throwable) {
                markFailed(file)
            } finally {
                setBusy(Op.Download, false)
            }
        }
    }

    private fun markFailed(file: RemoteFile) {
        val i = downloads.indexOfFirst { it.file.name == file.name }
        if (i >= 0) downloads[i] = downloads[i].copy(state = DownloadItem.State.Failed)
    }

    private inline fun runOp(op: Op, crossinline block: suspend (CameraProtocol, CameraSession) -> CmdResult) = scope.launch {
        val proto = protocol ?: return@launch
        val s = session ?: return@launch
        setBusy(op, true)
        try {
            val r = block(proto, s)
            if (r is CmdResult.Failure) errorMessage = r.message
            // refresh status promptly after a control action
            runCatching { deviceStatus = proto.getStatus(s) }
        } catch (t: Throwable) {
            errorMessage = t.message ?: "Command failed"
        } finally {
            setBusy(op, false)
        }
    }

    private fun fail(msg: String) {
        errorMessage = msg
        phase = Phase.Error
        statusMessage = ""
    }
}

private val State_Done = DownloadItem.State.Done
