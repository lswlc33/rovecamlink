package com.rovecamlink.app.core.protocol

import com.rovecamlink.app.core.model.CameraMode
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.LiveConfig
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

    /**
     * The camera's own sensor rotation right now, in degrees clockwise (90 = turned
     * clockwise, 270 = counter-clockwise), or null when this protocol cannot say.
     *
     * The live preview turns for it in addition to the phone's own orientation: the stream
     * is rotated by the camera, and counter-rotated by how the phone is held, so the box has
     * to account for both. Defaults to null — a protocol with no such read simply leaves the
     * preview following the phone alone.
     */
    suspend fun currentRotation(session: CameraSession): Int? = null
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

    /**
     * Delete **every** file on the camera's card in one command, for the album's
     * 「全部删除」.
     *
     * The hi3510 CGI family has a single endpoint for this (`deleteallfiles.cgi`), and
     * the official app treats a bare 200 as success — no second confirmation, no count
     * echoed back. The UI therefore owns the confirmation and the "N deleted" readout;
     * this call is the device half only.
     *
     * Protocols without such a command report a failure with the reason, and the UI
     * falls back to the per-file batch delete it already has.
     */
    suspend fun deleteAllFiles(session: CameraSession): CmdResult =
        CmdResult.Failure("This camera has no delete-all command")

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

    /**
     * Hand the camera everything it needs to push an RTMP stream **by itself**: the Wi-Fi
     * to join, the URL to push to, and the three encoder parameters.
     *
     * The camera is the RTMP client here, not this app — the official client has no
     * streaming code either, it only passes the parameters on and then polls its own
     * cloud for the room state (`docs/08-官方APK全量逆向档案/02-XTUGO-档案.md` §10.4-10.5).
     * Which channel carries them is the family's business: the Hi35xx socket takes the
     * whole payload on port 8080, and the Ambarella / newer models take it over
     * Bluetooth as `R006` (network) + `R007` (parameters).
     *
     * Success means **the camera accepted the parameters**, not that a stream is up. On
     * the socket transport the link is closed before the camera has had time to join
     * anything, and there is no acknowledgement later — the official client's own
     * "streaming" screen is a local timer, not a report from the camera.
     */
    suspend fun startLive(session: CameraSession, config: LiveConfig): CmdResult =
        CmdResult.Failure("This camera has no live-streaming command")

    /**
     * Whether [startLive] is wired up for this family, so the UI can say why before the
     * button is pressed rather than after.
     *
     * Same shape as [supportsReboot], and for the same reason: the alternative is a UI
     * that branches on the platform, which has to be edited every time a family is added.
     */
    val supportsLive: Boolean get() = false

    /** Absolute RTSP (or fallback) URL for live preview. */
    fun previewUrl(session: CameraSession): String

    /** Static identity for the About screen (firmware version, serial, ...). Null if unreachable. */
    suspend fun getDeviceInfo(session: CameraSession): DeviceInfo?

    /** Format the SD card (destructive — the UI must confirm first). */
    suspend fun formatSd(session: CameraSession): CmdResult

    /** Restore factory settings. The camera may reboot or drop the session. */
    suspend fun factoryReset(session: CameraSession): CmdResult

    /**
     * Remote reboot. The default reports the failure, which is what a family with no
     * reboot endpoint should do — it overrides [supportsReboot] instead of this.
     */
    suspend fun reboot(session: CameraSession): CmdResult =
        CmdResult.Failure("This camera has no remote reboot command")

    /**
     * Whether [reboot] is wired up for this family, so the settings page can decide
     * whether to offer the button **before** it is pressed.
     *
     * The hi3510 family has no reboot endpoint at all: the archive found no
     * `reboot.cgi` / `restart.cgi` / `poweroff.cgi` / `shutdown.cgi` among the 22,620
     * own-string literals and 405 recovered URL literals, and the nearest commands are
     * *scheduled* power actions (`getautoshutdown.cgi`, `setscreenautosleep.cgi`) —
     * see `docs/08-官方APK全量逆向档案/02-XTUGO-档案.md` §8.4 and §12, which reached the
     * same dead end on the official `reset.cgi` naming.
     *
     * This exists so the UI asks the protocol rather than naming a brand: the danger
     * section used to hide the button behind `platform == DevicePlatform.TUWIN_REST`,
     * which is the kind of branch that has to be edited every time a family is added.
     */
    val supportsReboot: Boolean get() = true

    /** Set the camera clock to the phone's current local time. */
    suspend fun syncTime(session: CameraSession): CmdResult

    /** Change the camera's own Wi-Fi network (the AP it broadcasts) name/password. */
    suspend fun setWifi(session: CameraSession, ssid: String, password: String): CmdResult

    /**
     * Read back the Wi-Fi network the camera is actually broadcasting: name and
     * passphrase, as [setWifi] wrote them.
     *
     * Without this the rename screen is a form with no values in it — you can set a
     * password you cannot see again, and the camera's own hotspot name is only
     * guessable from the phone's Wi-Fi list. The command exists on the hi3510 CGI
     * family (`getwifi.cgi`, see the plugin's note for the field evidence) and the
     * official app reads it to populate exactly this dialog.
     *
     * Null means "this camera cannot tell us", which the UI must show as a reason
     * rather than as an empty field.
     */
    suspend fun getWifi(session: CameraSession): com.rovecamlink.app.core.model.CameraWifi? = null

    /**
     * The channel the camera's own hotspot broadcasts on, or null when it cannot say.
     *
     * 2.4 GHz reaches further but is crowded by every neighbour's router; 5 GHz is clean
     * and fast but drops through walls — which one a camera should use is a real decision
     * a user makes about their own room, and it is invisible unless the app can read it.
     */
    suspend fun getWifiChannel(session: CameraSession): Int? = null

    /**
     * Move the hotspot to [channel]. Protocols without the command report a failure with
     * the reason, and the UI shows it rather than leaving a silent no-op.
     */
    suspend fun setWifiChannel(session: CameraSession, channel: Int): CmdResult =
        CmdResult.Failure("This camera cannot change its Wi-Fi channel")

    /**
     * Put the camera back into **access-point** mode, i.e. raise the hotspot again
     * without Bluetooth.
     *
     * The second half of the user's complaint about Bluetooth provisioning: the
     * official app has a way to make the camera broadcast again that does not go
     * through GATT at all, and it is a plain HTTP call — which means it works exactly
     * when the camera is reachable but the phone has been dropped from it (the
     * firmware's STA mode, a sleep, or a hotspot that died while the app was closed).
     * It cannot help when the camera is not on the network at all, so Bluetooth stays
     * the primary route; this is the fallback the connection screen can offer.
     *
     * Protocols without such a command report a failure with the reason.
     */
    suspend fun ensureAccessPoint(session: CameraSession): CmdResult =
        CmdResult.Failure("This camera has no way to raise its hotspot from the app")

    /**
     * Called when a session ends. Protocols that cache per-host firmware facts (work-mode
     * tables, menu listings) drop them here, so a camera replaced on the same IP cannot
     * be served another model's table.
     */
    suspend fun onSessionClosed(session: CameraSession) {}

    /**
     * What this camera says it can do, as the firmware's own tokens.
     *
     * The hi3510 family answers `getdevcapabilities.cgi?` with one comma-separated
     * string (`Setting.getDevCapabilities` → key `devcapabilities`,
     * `Setting.java:529-531`) and the official client reads exactly one token out of it:
     * `DV.supportWakeSleep()` returns true when the string contains `standby`
     * (`DV.java:736-743`), which is what gates its sleep/wake buttons.
     *
     * That one token is the whole reason this exists — it is the difference between
     * offering a sleep button that works and offering one the camera ignores. Tokens
     * this app does not know are still returned, verbatim, because the set is the
     * firmware's answer and not ours to trim.
     *
     * Empty means "the camera did not say" (an older firmware, or the read failed), and
     * the UI must treat that as unknown rather than as "cannot".
     */
    suspend fun deviceCapabilities(session: CameraSession): Set<String> = emptySet()

    /**
     * The values this camera accepts for one setting, asked of the camera itself:
     * `getcapability.cgi?&-workmode=%d&-type=%d`, key `capability`
     * (`Setting.java:541-543`). The reply is one comma-separated string — the official
     * client splits it on `,` (`DV.java:200`) and treats it as the option list for the
     * matching parameter read.
     *
     * [workMode] and [configType] are the firmware's numeric work mode and `CONFIG_*`
     * slot (`Common.java:12-26`), not app enums. Empty means the camera declined or the
     * endpoint is absent — note that the official client skips this call entirely on
     * NewAPP firmware (`DV.getCapability` returns null), where the self-describing menu
     * already carries the values.
     */
    suspend fun capabilities(session: CameraSession, workMode: Int, configType: Int): List<String> =
        emptyList()

    /**
     * Put the camera to sleep — the battery-powered models' standby.
     *
     * `wifisleep.cgi?` with no arguments (`Setting.java:463-465`, `doForSuccess`), which
     * means the body verdict is the only evidence: the camera drops off the network
     * without answering. A protocol without the command reports a failure with the
     * reason, and the UI must show it rather than pretend the camera slept.
     */
    suspend fun sleep(session: CameraSession): CmdResult =
        CmdResult.Failure("This camera cannot be put to sleep from the app")

    /**
     * Wake a sleeping camera over the network.
     *
     * The hi3510 family has **no wake command** — the official client sends a Wake-on-LAN
     * magic packet instead (`Setting.wakeupDevice`, `Setting.java:483-511`): 102 bytes of
     * `0xFF×6` followed by the MAC sixteen times, UDP to `<first three octets>.255:9`,
     * five bursts, fire-and-forget. If the camera's Wi-Fi chip does not implement WoL the
     * packet is silently ignored, which is why [deviceCapabilities] is consulted first.
     *
     * [mac] is the camera AP's BSSID, read off the phone's own Wi-Fi association — not a
     * camera endpoint (the official client does the same: `TelevisionActivity.java:170`
     * feeds `connectionInfo.getBSSID()` into `DV.setMacAddress`). Null or malformed means
     * there is nothing to send, and the failure says so.
     */
    suspend fun wake(session: CameraSession, mac: String?): CmdResult =
        CmdResult.Failure("This camera cannot be woken over the network")

    /** Optional event stream. */
    val events: Flow<com.rovecamlink.app.core.model.DeviceEvent>
}

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
