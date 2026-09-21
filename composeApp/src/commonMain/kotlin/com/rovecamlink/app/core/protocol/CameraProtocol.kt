package com.rovecamlink.app.core.protocol

import com.rovecamlink.app.core.model.CameraMode
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.ModeFamily
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
     * SSID prefixes this family's hotspots start with. Lets the connection screen
     * say "this is an XTU camera, so its address is fixed" instead of guessing, and
     * keeps the brand table out of the Wi-Fi layer: a new brand adds a plugin rather
     * than editing a shared prefix list.
     */
    val wifiSsidPrefixes: List<String> get() = emptyList()

    /**
     * The IP the camera's own AP always answers on, for families that fix it
     * (XTU: 192.168.0.1). Null means "this family varies, walk the candidates".
     *
     * Worth its weight: the 2026-09-21 S7PRO session resolved the gateway to a VPN
     * address, then probed nine hosts at two 8-second timeouts each and threw 15
     * `ConnectTimeoutException`s at the network while the live view starved.
     */
    val fixedHost: String? get() = null

    /**
     * The camera's factory hotspot passphrase, for brands that ship one instead of
     * generating a key per device. Only ever used when Bluetooth and the saved
     * credentials both came up empty.
     */
    val defaultWifiPassword: String? get() = null

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

    /**
     * The shooting modes this camera actually offers, in the firmware's own order and
     * spelling. [WorkMode] is the coarse video/photo family; a camera with a 延时拍照
     * or 长曝光 mode is invisible to a UI that only knows two, so the list comes from
     * the device rather than from a table in this app.
     *
     * Empty means "this plugin cannot enumerate modes" — the UI then offers the
     * [WorkMode] pair instead.
     */
    suspend fun listModes(session: CameraSession): List<CameraMode> = emptyList()

    /** Switch to one of [listModes]'s entries, verbatim. */
    suspend fun setNamedMode(session: CameraSession, mode: CameraMode): CmdResult =
        setMode(session, if (mode.family == ModeFamily.VIDEO) WorkMode.VIDEO else WorkMode.PHOTO)

    /**
     * End a [ModeTrigger.TOGGLE] capture (a running 延时拍照 sequence). Protocols whose
     * shutter is always single-shot leave this as a no-op success.
     */
    suspend fun stopCapture(session: CameraSession): CmdResult = CmdResult.Ok

    /**
     * The **device's** own settings — the menu that is not a function of the shooting
     * mode (firmware-labelled items like watermarks, tones, grid, auto power-off, the
     * clock, SD format). XTU's CGI family calls this menu `workmode=System`.
     *
     * Empty when the family has no such page; the UI shows the per-mode settings
     * alone rather than an empty group.
     */
    suspend fun getDeviceSettings(session: CameraSession): List<CameraSetting> = emptyList()

    /** Write one item from [getDeviceSettings]. */
    suspend fun setDeviceSetting(session: CameraSession, id: String, value: String): CmdResult =
        setSetting(session, id, value)

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

    /** Longest prefix first: `XTUCam_` must win over another brand's `XTU`. */
    private val bySsidPrefix: List<Pair<String, CameraProtocol>> =
        protocols.flatMap { p -> p.wifiSsidPrefixes.map { it to p } }
            .sortedByDescending { it.first.length }

    fun protocolFor(platform: DevicePlatform): CameraProtocol? = byPlatform[platform]
    fun all(): Collection<CameraProtocol> = byPlatform.values
    fun platforms(): Set<DevicePlatform> = byPlatform.keys

    /** The plugin whose family broadcasts this hotspot name, when one recognises it. */
    fun forSsid(ssid: String?): CameraProtocol? {
        if (ssid.isNullOrBlank()) return null
        return bySsidPrefix.firstOrNull { (prefix, _) ->
            ssid.startsWith(prefix, ignoreCase = true)
        }?.second
    }

    /** The address to try first for a known hotspot, or null when nothing recognises it. */
    fun fixedHostFor(ssid: String?): String? = forSsid(ssid)?.fixedHost

    fun defaultPasswordFor(ssid: String?): String? = forSsid(ssid)?.defaultWifiPassword
}
