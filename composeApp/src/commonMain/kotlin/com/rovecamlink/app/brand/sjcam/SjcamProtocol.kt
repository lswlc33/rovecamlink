package com.rovecamlink.app.brand.sjcam

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.Brand
import com.rovecamlink.app.core.model.CameraMode
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceEvent
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.model.workMode
import com.rovecamlink.app.core.protocol.CameraProtocol
import com.rovecamlink.app.core.transport.CameraHttp
import com.rovecamlink.app.core.transport.CameraTcp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import okio.Path

/**
 * SJCAM (山狗) plugin — one brand, four transports.
 *
 * The SJCAM Zone app is a **multi-SoC client**: five camera channels live side by side in it
 * and are routed by the AP gateway IP plus the model string the camera reports
 * (`docs/evidence/sjcam.md` §3.2). This plugin mirrors that structure: it owns
 * [DevicePlatform.SJCAM] and dispatches every call to the channel its probe matched.
 *
 * | channel | transport | gateway | models | archive |
 * |---|---|---|---|---|
 * | [SjcamAmbaChannel] | JSON over TCP 7878 | 192.168.42.1 | `SJCAMSJ8PRO`, `SJCAMSJ9PRO`, `SJCAMSJ10PRO`, … | §4.3 |
 * | [SjcamLyChannel] | `?custom=1&cmd=` HTTP + RTSP/8192 | 192.168.1.254 | `660-…`/`675-…`/`580-…`/`683-…` Novatek family | §4.1 |
 * | [SjcamHisnetChannel] | `/cgi-bin/hisnet/<cmd>.cgi` | 192.168.0.1 | `Hi3559V200-DV-IMX458` (SJ10 MAX) | §4.2 |
 * | [SjcamAllwinnerChannel] | `:8082/api/…` JSON | 192.168.10.1 / 192.168.100.1 | `V536-CDR` (SJ10_A) | §4.4 |
 *
 * **Probe order is ly → hisnet → allwinner → amba, and each probe claims only its own
 * family's answer.** That matters twice over: the LY dialect (`?custom=1&cmd=…` with
 * `<Function>` replies) is the *same* wire language the iCatch dash cams speak — the
 * difference is the model vocabulary, so the LY probe reads `cmd=3012` and requires an
 * SJCAM model token rather than "any XML came back" (`SjcamLyChannel.probe`). And the
 * hisnet probe requires exactly the SJ10 MAX model string, so a TUWIN Ride5 recorder
 * (same CGI dialect, `HI3516CV610-S-FV-CARRECORDER`) is left to the TUWIN plugin.
 *
 * **No SSID-derived routing.** The brand's own list (`view/WifiBottomPopup.java:252-254`)
 * is only a hint that a hotspot *might* be an SJCAM camera; which channel it speaks is
 * decided by the live probe, exactly like every other plugin here. The prefixes are
 * still declared so the scan filter can badge such hotspots.
 *
 * **Not implemented, on purpose** (archive §5): the iCatch PTP channel (`"ICatch"` models —
 * native stack, same call as `brand/icatch`), and the three push channels (Ly TCP 3333,
 * hisnet back-connect TCP 9000, Amba `msg_id=7` notifications) — this plugin polls
 * instead, which is what the official app does for battery and status too.
 */
class SjcamProtocol(
    private val http: CameraHttp,
    private val tcp: CameraTcp,
) : CameraProtocol {

    override val platform = DevicePlatform.SJCAM

    /**
     * `isSjWifi` verbatim (`_work/sjcam_src/sources/org/jght/sjcam/zone/view/WifiBottomPopup.java:252-254`):
     * SJ* plus the C/A/M families that predate the SJ naming. `SJ` is deliberately broad —
     * the brand's own app accepts it, and a hotspot merely matching here still has to answer
     * the live probe before anything talks to it.
     */
    override val wifiSsidPrefixes: List<String> =
        listOf("SJ", "C100", "C200", "A10", "A20", "A30", "M20")

    /** Four gateways, four channels — a fixed host would misroute three of them. */
    override val fixedHost: String? = null

    /** No factory passphrase found in the APK; the connection screen stays user-driven. */
    override val defaultWifiPassword: String? = null

    private val _events = MutableSharedFlow<DeviceEvent>(extraBufferCapacity = 8)
    override val events: Flow<DeviceEvent> = _events

    private val channels: List<SjcamChannel> = listOf(
        SjcamLyChannel(http),
        SjcamHisnetChannel(http),
        SjcamAllwinnerChannel(http),
        SjcamAmbaChannel(tcp, http),
    )

    private val byId: Map<String, SjcamChannel> = channels.associateBy { it.id }

    // ---------- probe / connect ----------

    override suspend fun probe(host: String, port: Int): Boolean =
        Diag.inOp("sjcam-probe", "target=$host:$port") {
            for (channel in channels) {
                val verdict = runCatching { channel.probe(host, port) }.getOrElse { t ->
                    Diag.d(LogTag.PROTO) { "sjcam ${channel.id} probe $host:$port error ${Diag.causeChain(t)}" }
                    false
                }
                Diag.d(LogTag.PROTO) { "sjcam ${channel.id} probe $host:$port -> $verdict" }
                if (verdict) return@inOp true
            }
            false
        }

    override suspend fun connect(host: String, port: Int): CameraSession =
        Diag.inOp("sjcam-connect", "target=$host:$port") {
            for (channel in channels) {
                val session = runCatching { channel.connect(host, port) }.getOrNull()
                if (session != null) {
                    Diag.i(LogTag.PROTO) {
                        "sjcam connected channel=${channel.id} model=${session.model} host=$host"
                    }
                    return@inOp session
                }
            }
            // Nothing claimed it; still hand back an LY-shaped session so the caller gets a
            // concrete failure on the first request instead of a null dereference.
            CameraSession(
                host = host, port = port, platform = platform, brand = Brand.SJCAM,
                model = "SJCAM", extras = mapOf(EXTRA_CHANNEL to SjcamLyChannel.ID),
            )
        }

    private fun channelOf(session: CameraSession): SjcamChannel =
        byId[session.extras[EXTRA_CHANNEL]] ?: channels.first()

    override suspend fun onSessionClosed(session: CameraSession) {
        runCatching { channelOf(session).close(session) }
    }

    // ---------- status ----------

    override suspend fun getStatus(session: CameraSession): DeviceStatus =
        channelOf(session).status(session)

    override val reportsRecordingState: Boolean
        get() = true

    /**
     * Read-back after a write is cheap on every channel here (one `cmd=` / one CGI), so the
     * UI can show what the firmware actually holds instead of echoing the request.
     */
    override suspend fun readBack(session: CameraSession, id: String): CameraSetting? =
        channelOf(session).getSettings(session).firstOrNull { it.id == id }

    // ---------- settings ----------

    override suspend fun getSettings(session: CameraSession): List<CameraSetting> =
        channelOf(session).getSettings(session)

    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult =
        channelOf(session).setSetting(session, id, value)

    override suspend fun getDeviceSettings(session: CameraSession): List<CameraSetting> =
        channelOf(session).getDeviceSettings(session)

    override suspend fun setDeviceSetting(session: CameraSession, id: String, value: String): CmdResult =
        channelOf(session).setDeviceSetting(session, id, value)

    // ---------- capture ----------

    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult =
        channelOf(session).setMode(session, mode)

    override suspend fun listModes(session: CameraSession): List<CameraMode> =
        channelOf(session).listModes(session)

    override suspend fun setNamedMode(session: CameraSession, mode: CameraMode): CmdResult =
        channelOf(session).setNamedMode(session, mode)

    override suspend fun capture(session: CameraSession): CmdResult =
        channelOf(session).capture(session)

    override suspend fun record(session: CameraSession, start: Boolean): CmdResult {
        val result = channelOf(session).record(session, start)
        // Announce only an accepted command — a refusal that still emitted the event would
        // leave the UI showing a recording the camera never started (the TUWIN lesson).
        if (result.isOk) _events.tryEmit(DeviceEvent.RecordingChanged(start))
        return result
    }

    // ---------- files ----------

    override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> =
        channelOf(session).listFiles(session, start, end)

    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult =
        channelOf(session).deleteFile(session, file)

    override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? =
        channelOf(session).thumbnail(session, file)

    override suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long = channelOf(session).download(session, file, dest, alreadyHaveBytes, onProgress)

    override fun previewUrl(session: CameraSession): String = channelOf(session).previewUrl(session)

    // ---------- identity / maintenance ----------

    override suspend fun getDeviceInfo(session: CameraSession): DeviceInfo? =
        channelOf(session).getDeviceInfo(session)

    override suspend fun formatSd(session: CameraSession): CmdResult =
        channelOf(session).formatSd(session)

    override suspend fun factoryReset(session: CameraSession): CmdResult =
        channelOf(session).factoryReset(session)

    override suspend fun syncTime(session: CameraSession): CmdResult =
        channelOf(session).syncTime(session)

    override val supportsReboot: Boolean
        get() = false

    /** LY's `cmd=3007` and Amba's `msg_id=12` are power-off, not standby — see [SjcamLyChannel.sleep]. */
    override suspend fun sleep(session: CameraSession): CmdResult =
        channelOf(session).sleep(session)

    override suspend fun setWifi(session: CameraSession, ssid: String, password: String): CmdResult =
        channelOf(session).setWifi(session, ssid, password)

    companion object {
        /** Which channel claimed this session; stamped by [connect], read by [channelOf]. */
        const val EXTRA_CHANNEL = "sjcam.channel"
    }
}

/**
 * One SoC family's wire behaviour. Every method has a "this family cannot do it" default so a
 * channel only implements what its firmware actually exposes (archive §5 records which is which).
 */
internal interface SjcamChannel {
    val id: String
    val displayName: String

    suspend fun probe(host: String, port: Int): Boolean

    /**
     * Build a session **only when this channel recognises the camera**. Returning a session
     * for a host that merely answered is not a neutral act: [SjcamProtocol.connect] walks the
     * channels in order, so a channel that always answers takes the camera away from the one
     * that speaks it (the LY profile did exactly that until the flow test caught it).
     * Null means "not this family, keep asking".
     */
    suspend fun connect(host: String, port: Int): CameraSession?

    suspend fun status(session: CameraSession): DeviceStatus
    suspend fun getSettings(session: CameraSession): List<CameraSetting>
    suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult

    suspend fun getDeviceSettings(session: CameraSession): List<CameraSetting> = emptyList()
    suspend fun setDeviceSetting(session: CameraSession, id: String, value: String): CmdResult =
        setSetting(session, id, value)

    suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult =
        CmdResult.Failure("$displayName cannot switch mode from here")

    suspend fun listModes(session: CameraSession): List<CameraMode> = emptyList()

    suspend fun setNamedMode(session: CameraSession, mode: CameraMode): CmdResult =
        setMode(session, mode.family.workMode())

    suspend fun capture(session: CameraSession): CmdResult =
        CmdResult.Failure("$displayName has no shutter command")

    suspend fun record(session: CameraSession, start: Boolean): CmdResult =
        CmdResult.Failure("$displayName has no record command")

    suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile>
    suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult
    suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray?
    suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long

    fun previewUrl(session: CameraSession): String

    suspend fun getDeviceInfo(session: CameraSession): DeviceInfo? = null
    suspend fun formatSd(session: CameraSession): CmdResult =
        CmdResult.Failure("$displayName cannot format the card")
    suspend fun factoryReset(session: CameraSession): CmdResult =
        CmdResult.Failure("$displayName cannot restore factory settings")
    suspend fun syncTime(session: CameraSession): CmdResult =
        CmdResult.Failure("$displayName cannot set the clock")
    suspend fun sleep(session: CameraSession): CmdResult =
        CmdResult.Failure("$displayName cannot be put to sleep from the app")
    suspend fun setWifi(session: CameraSession, ssid: String, password: String): CmdResult =
        CmdResult.Failure("$displayName cannot rename its hotspot")

    /** Drop per-session resources (open sockets) when the session ends. */
    suspend fun close(session: CameraSession) {}

    fun newSession(host: String, port: Int, model: String, extras: Map<String, String> = emptyMap()) =
        CameraSession(
            host = host, port = port, platform = DevicePlatform.SJCAM, brand = Brand.SJCAM,
            model = model, extras = extras + (SjcamProtocol.EXTRA_CHANNEL to id),
        )
}

/** Percent-encodes a query parameter value; the family's own encoder is equally minimal. */
internal fun sjcamUrlEnc(s: String): String = buildString(s.length) {
    for (byte in s.encodeToByteArray()) {
        val b = byte.toInt() and 0xFF
        val unreserved = b in 'a'.code..'z'.code || b in 'A'.code..'Z'.code ||
            b in '0'.code..'9'.code || b == '-'.code || b == '.'.code || b == '_'.code || b == '~'.code
        if (unreserved) append(b.toChar())
        else append('%').append(HEX[b shr 4]).append(HEX[b and 0x0F])
    }
}

private val HEX = "0123456789ABCDEF".toCharArray()
