package com.rovecamlink.app.core.protocol

import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.coroutines.flow.Flow
import okio.Path

/**
 * A protocol plugin. One implementation per [DevicePlatform]. Adding support for
 * a new camera family = implement this interface + register it in
 * [CameraProtocolRegistry]; nothing else in the app needs to change.
 */
interface CameraProtocol {
    val platform: DevicePlatform

    /**
     * Cheap probe: returns true when the device at host:port speaks this
     * protocol. Used by auto-detection to pick the right plugin at runtime.
     */
    suspend fun probe(host: String, port: Int): Boolean

    /** Establish a session (auth handshake where required). */
    suspend fun connect(host: String, port: Int): CameraSession

    suspend fun getStatus(session: CameraSession): DeviceStatus
    suspend fun getSettings(session: CameraSession): List<CameraSetting>
    suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult

    /**
     * Re-read a single setting after [setSetting] accepted it, so the UI can show what
     * the firmware actually holds. A full [getSettings] is often one request per item,
     * which is far too expensive to run after every tap; protocols that can address one
     * item override this. Null means "no cheap read-back — update locally".
     */
    suspend fun readBack(session: CameraSession, id: String): CameraSetting? = null

    suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult
    suspend fun capture(session: CameraSession): CmdResult
    suspend fun record(session: CameraSession, start: Boolean): CmdResult

    suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile>
    suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult
    suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray?

    /**
     * Streams [file] into [dest]. Pass the size of an existing partial file as
     * [alreadyHaveBytes] to resume it; pass 0 to start over. Returns bytes on
     * disk, or -1 if the transfer failed or was truncated.
     */
    suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long

    /** Absolute RTSP (or fallback) URL for live preview. */
    fun previewUrl(session: CameraSession): String

    /** Static identity for the About screen (firmware version, serial, ...). Null if unreachable. */
    suspend fun getDeviceInfo(session: CameraSession): DeviceInfo?

    /** Format the SD card (destructive — the UI must confirm first). */
    suspend fun formatSd(session: CameraSession): CmdResult

    /** Restore factory settings. The camera may reboot or drop the session. */
    suspend fun factoryReset(session: CameraSession): CmdResult

    /** Remote reboot. Returns a Failure on cameras without a reboot command. */
    suspend fun reboot(session: CameraSession): CmdResult

    /** Set the camera clock to the phone's current local time. */
    suspend fun syncTime(session: CameraSession): CmdResult

    /** Change the camera's own Wi-Fi network (the AP it broadcasts) name/password. */
    suspend fun setWifi(session: CameraSession, ssid: String, password: String): CmdResult

    /**
     * Called when a session ends. Protocols that cache per-host firmware facts (work-mode
     * tables, menu listings) drop them here, so a camera replaced on the same IP cannot
     * be served another model's table.
     */
    fun onSessionClosed(session: CameraSession) {}

    /** Optional event stream. */
    val events: Flow<com.rovecamlink.app.core.model.DeviceEvent>
}

/**
 * Static metadata describing how to reach/identify a device family before a
 * protocol is chosen: candidate ports, probe paths, expected model strings.
 */
data class CameraProfile(
    val platform: DevicePlatform,
    val brand: com.rovecamlink.app.core.model.Brand,
    val candidatePorts: List<Int>,
    val probePaths: List<String>,
    val previewPort: Int,
    val previewPath: String,
    val expectedModels: Set<String> = emptySet(),
)

/** Registry of available protocol plugins, keyed by platform. */
class CameraProtocolRegistry(protocols: List<CameraProtocol>) {
    private val byPlatform: Map<DevicePlatform, CameraProtocol> =
        protocols.associateBy { it.platform }

    fun protocolFor(platform: DevicePlatform): CameraProtocol? = byPlatform[platform]
    fun all(): Collection<CameraProtocol> = byPlatform.values
    fun platforms(): Set<DevicePlatform> = byPlatform.keys
}
