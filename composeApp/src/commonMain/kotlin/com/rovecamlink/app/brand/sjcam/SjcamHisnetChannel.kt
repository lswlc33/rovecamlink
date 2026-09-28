package com.rovecamlink.app.brand.sjcam

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.CameraMode
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.ModeFamily
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.SdCardState
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import okio.Path

/**
 * Hisilicon **hisnet** channel — today that is exactly one product, the SJ10 MAX
 * (`HisCamera.SJ10_MAX = "Hi3559V200-DV-IMX458"`, `docs/evidence/sjcam.md` §4.2).
 *
 * The dialect looks like the hi3510 CGI family (both answer `var key = "value";` text) but
 * is a different command set on a different path root: `/cgi-bin/hisnet/<cmd>.cgi` on
 * `192.168.0.1` with `-option/-values/-workmode` style parameters (`HisCamera.java:90-133`),
 * versus `brand/xtu`'s `/cgi-bin/hi3510/<cmd>.cgi` on `192.168.0.1` with `-name/-value`.
 * That is why this lives here and not as a mode of the XTU plugin — and why the probe
 * insists on the model string: a TUWIN Ride5 recorder speaks hisnet too, and only the
 * model separates the two brands (archive §5).
 *
 * **Recording is not driven from the app.** The official client's only shutter call is
 * `sendclickkey.cgi&-type=KEY_MENU` (`HisCamera.take`, `:677-694`) — a key press handed to
 * the camera's own state machine; there is no start/stop-record endpoint in the whole
 * APK. [record] therefore reports the failure instead of inventing a command, and the
 * recording state is read from `getworkstate.cgi` (`var running` + `var time`, `:1182`,
 * `:597-607`).
 */
internal class SjcamHisnetChannel(private val http: CameraHttp) : SjcamChannel {

    override val id = ID
    override val displayName = "SJCAM hisnet (SJ10 MAX)"

    private fun base(session: CameraSession) = "http://${session.host}:${session.port}/cgi-bin/hisnet"

    // ---------- probe / connect ----------

    /**
     * `getdeviceattr.cgi` answers `var model`/`var softversion`; only the SJ10 MAX marketing
     * string claims the channel. A broader "any `var model` body" test would swallow TUWIN's
     * Ride5 recorder, which speaks this same CGI dialect (`docs/evidence/tuwin` §1.4).
     */
    override suspend fun probe(host: String, port: Int): Boolean {
        val body = http.getText("http://$host:$port/cgi-bin/hisnet/getdeviceattr.cgi")
        val model = varOf(body, "var model")
        val verdict = model != null && model.contains(MODEL_SJ10_MAX)
        Diag.d(LogTag.PROTO) { "sjcam-hisnet probe $host:$port -> $verdict model=${LogFormat.safe(model)}" }
        return verdict
    }

    override suspend fun connect(host: String, port: Int): CameraSession? {
        val body = http.getText("http://$host:$port/cgi-bin/hisnet/getdeviceattr.cgi")
        val model = varOf(body, "var model")?.takeIf { it.contains(MODEL_SJ10_MAX) } ?: return null
        Diag.i(LogTag.PROTO) { "sjcam-hisnet connect model=${LogFormat.safe(model)}" }
        return newSession(host, port, model)
    }

    // ---------- status ----------

    override suspend fun status(session: CameraSession): DeviceStatus {
        val b = base(session)
        val battery = varOf(http.getText("$b/getbatterystate.cgi"), "var capacity")?.toIntOrNull()
        val charge = varOf(http.getText("$b/getbatterystate.cgi"), "var charge")
        val state = http.getText("$b/getworkstate.cgi")
        val running = varOf(state, "var running")?.trim()?.equals("true", ignoreCase = true) == true
        val timeMs = varOf(state, "var time")?.toLongOrNull()
        val workMode = varOf(http.getText("$b/getworkmode.cgi"), "var workmode")
        val sd = http.getText("$b/getsdstatus.cgi")
        Diag.d(LogTag.PARSE) {
            "sjcam-hisnet status battery=$battery charge=$charge running=$running timeMs=$timeMs mode=$workMode"
        }
        return DeviceStatus(
            battery = battery,
            charging = charge?.let { it == "1" || it.equals("true", ignoreCase = true) },
            recording = running,
            mode = modeOf(workMode),
            modeName = workMode,
            sdTotalMb = varOf(sd, "var totalspace")?.toLongOrNull() ?: varOf(sd, "var total")?.toLongOrNull(),
            sdFreeMb = varOf(sd, "var freespace")?.toLongOrNull() ?: varOf(sd, "var free")?.toLongOrNull(),
            sdState = sdStateOf(varOf(sd, "var sdstatus") ?: varOf(sd, "var status")),
            videoTimeSec = timeMs?.takeIf { it > 0 }?.let { (it / 1000).toInt() },
        )
    }

    // ---------- modes ----------

    /**
     * The firmware's own mode words (`HisCamera.Mode`, `:136-147`); every one of them is a
     * valid `setworkmode.cgi&-workmode=` value and the list is small enough to offer whole.
     */
    override suspend fun listModes(session: CameraSession): List<CameraMode> = MODES

    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult {
        val word = when (mode) {
            WorkMode.VIDEO -> "Normal"
            WorkMode.PHOTO -> "Photo"
            WorkMode.PLAYBACK -> "Filelist"
        }
        return setNamedMode(session, CameraMode(word, ModeFamily.OTHER))
    }

    override suspend fun setNamedMode(session: CameraSession, mode: CameraMode): CmdResult {
        val body = http.getText("${base(session)}/setworkmode.cgi?&-workmode=${sjcamUrlEnc(mode.name)}")
        Diag.d(LogTag.PROTO) { "sjcam-hisnet setworkmode ${mode.name} -> ${body != null}" }
        return if (body != null) CmdResult.Ok else CmdResult.Failure("模式切换无应答")
    }

    // ---------- settings ----------

    /** Shooting-menu items (`getmedia.cgi`, `HisCamera.java:104,731-785`). */
    override suspend fun getSettings(session: CameraSession): List<CameraSetting> =
        itemsOf(http.getText("${base(session)}/getmedia.cgi"), prefix = "media")

    /** Device-menu items (`getsetting.cgi`, `HisCamera.java:97,785-818`). */
    override suspend fun getDeviceSettings(session: CameraSession): List<CameraSetting> =
        itemsOf(http.getText("${base(session)}/getsetting.cgi"), prefix = "dev")

    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult =
        write(session, "setmedia.cgi", id.removePrefix("media:"), value)

    override suspend fun setDeviceSetting(session: CameraSession, id: String, value: String): CmdResult =
        write(session, "setsetting.cgi", id.removePrefix("dev:"), value)

    private suspend fun write(session: CameraSession, cgi: String, option: String, value: String): CmdResult {
        val body = http.getText(
            "${base(session)}/$cgi?&-option=${sjcamUrlEnc(option)}&-values=${sjcamUrlEnc(value)}",
        )
        Diag.d(LogTag.PROTO) { "sjcam-hisnet $cgi $option=$value -> ${body != null}" }
        return if (body != null) CmdResult.Ok else CmdResult.Failure("$option 写入无应答")
    }

    /** `var item`/`var value` parallel arrays (`HisCamera.java:798-815`). */
    private fun itemsOf(body: String?, prefix: String): List<CameraSetting> {
        val items = varsOf(body, "var item")
        val values = varsOf(body, "var value")
        if (items.isEmpty()) return emptyList()
        return items.mapIndexedNotNull { i, name ->
            val v = values.getOrNull(i) ?: return@mapIndexedNotNull null
            CameraSetting(id = "$prefix:$name", title = name, value = v)
        }
    }

    // ---------- capture ----------

    /**
     * The single key the official client sends (`KEY_MENU`). On the camera that key is the
     * shutter/OK button, so one press is a photo in still modes and a record toggle in video
     * modes — which is also why [record] has no command of its own.
     */
    override suspend fun capture(session: CameraSession): CmdResult {
        val body = http.getText("${base(session)}/sendclickkey.cgi?&-type=KEY_MENU")
        Diag.d(LogTag.PROTO) { "sjcam-hisnet clickkey KEY_MENU -> ${body != null}" }
        return if (body != null) CmdResult.Ok else CmdResult.Failure("按键命令无应答")
    }

    override suspend fun record(session: CameraSession, start: Boolean): CmdResult =
        CmdResult.Failure("SJ10 MAX 的录像起停由相机自身按键驱动，APK 里没有对应命令")

    // ---------- files ----------

    /**
     * `getfilelist.cgi?&-start=&-end=` → parallel `var path`/`var size`/`var create` arrays
     * (`HisCamera.java:960-1010`); the media URL is `http://192.168.0.1/` + path
     * (`MediaModel.java:61`). `-end` is exclusive in the official client's loop.
     */
    override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> {
        val body = http.getText("${base(session)}/getfilelist.cgi?&-start=$start&-end=$end")
        val paths = varsOf(body, "var path")
        val sizes = varsOf(body, "var size")
        val creates = varsOf(body, "var create")
        Diag.d(LogTag.PARSE) { "sjcam-hisnet filelist $start..$end -> ${paths.size} entries" }
        return paths.mapIndexedNotNull { i, path ->
            val name = path.trim().substringAfterLast('/')
            if (name.isEmpty()) return@mapIndexedNotNull null
            val lower = name.lowercase()
            RemoteFile(
                name = name,
                type = if (lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png")) {
                    FileType.PHOTO
                } else {
                    FileType.VIDEO
                },
                sizeBytes = sizes.getOrNull(i)?.toLongOrNull() ?: 0L,
                // The vendor's own media URL is `http://192.168.0.1/` + path (MediaModel.java:61).
                // We keep the session's port in front of it so a camera reached through a
                // forwarded port (or the desktop simulator on 8080) is downloaded from the
                // same endpoint that was probed, not from an assumed :80.
                downloadUrl = "http://${session.host}:${session.port}/${path.trim().trimStart('/')}",
                thumbnailUrl = null,
                dateMillis = creates.getOrNull(i)?.let { parseCreateTime(it) },
            )
        }
    }

    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult {
        val name = file.downloadUrl.substringAfter("http://${session.host}:${session.port}/")
        val body = http.getText("${base(session)}/deletefile.cgi?&-name=${sjcamUrlEnc(name)}")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("删除无应答")
    }

    override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? = null

    override suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long = http.download(file.downloadUrl, dest, alreadyHaveBytes, onProgress)

    override fun previewUrl(session: CameraSession): String = "rtsp://${session.host}:554/livestream/12"

    override suspend fun getDeviceInfo(session: CameraSession): DeviceInfo? {
        val body = http.getText("${base(session)}/getdeviceattr.cgi") ?: return null
        return DeviceInfo(
            name = varOf(body, "var model"),
            model = varOf(body, "var model"),
            softVersion = varOf(body, "var softversion"),
            hardVersion = varOf(body, "var hardversion"),
            serialNumber = varOf(body, "var serialnum"),
            raw = varOf(body, "var model")?.let { mapOf("model" to it) } ?: emptyMap(),
        )
    }

    override suspend fun formatSd(session: CameraSession): CmdResult {
        val body = http.getText("${base(session)}/sdcommand.cgi?&-format")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("格式化无应答")
    }

    override suspend fun factoryReset(session: CameraSession): CmdResult {
        val body = http.getText("${base(session)}/reset.cgi")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("恢复出厂无应答")
    }

    /** `setsystime.cgi?[&-time=%s][&-timeformat=0][&-timezone=0]` (`HisCamera.java:130`). */
    override suspend fun syncTime(session: CameraSession): CmdResult {
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val t = "${now.year}${now.monthNumber.toString().padStart(2, '0')}${now.dayOfMonth.toString().padStart(2, '0')}" +
            "${now.hour.toString().padStart(2, '0')}${now.minute.toString().padStart(2, '0')}${now.second.toString().padStart(2, '0')}"
        val body = http.getText("${base(session)}/setsystime.cgi?&-time=$t&-timeformat=0&-timezone=0")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("对时无应答")
    }

    /** `poweroff.cgi` — the hisnet family's only power control (`HisCamera.java:111`). */
    override suspend fun sleep(session: CameraSession): CmdResult {
        val body = http.getText("${base(session)}/poweroff.cgi")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("关机无应答")
    }

    companion object {
        const val ID = "hisnet"
        const val MODEL_SJ10_MAX = "Hi3559V200-DV-IMX458"

        /** Every word is a `setworkmode.cgi&-workmode=` value (`HisCamera.Mode`, `:136-147`). */
        private val MODES = listOf(
            CameraMode("Normal", ModeFamily.VIDEO),
            CameraMode("Car Looping", ModeFamily.VIDEO),
            CameraMode("RecLpse", ModeFamily.VIDEO),
            CameraMode("Slow", ModeFamily.VIDEO),
            CameraMode("RecSnap", ModeFamily.VIDEO),
            CameraMode("Photo", ModeFamily.PHOTO),
            CameraMode("Burst", ModeFamily.PHOTO),
            CameraMode("Lapse", ModeFamily.PHOTO),
            CameraMode("Filelist", ModeFamily.OTHER),
        )

        private fun modeOf(word: String?): WorkMode? = when (word?.trim()) {
            null, "" -> null
            "Photo", "Burst", "Lapse" -> WorkMode.PHOTO
            "Filelist" -> WorkMode.PLAYBACK
            else -> WorkMode.VIDEO
        }

        /**
         * `getsdstatus.cgi`'s word is not documented anywhere in the APK (only
         * `getsdstatus.cgi` itself appears, `HisCamera.java:107`); the parse is therefore
         * defensive and unknown words stay [SdCardState.UNKNOWN] rather than being guessed.
         */
        internal fun sdStateOf(raw: String?): SdCardState? {
            if (raw == null) return null
            val t = raw.trim()
            if (t.isEmpty()) return null
            if (t == "0" || t.equals("ok", true) || t.equals("normal", true) || t.equals("1", true)) return SdCardState.OK
            return SdCardState.fromRaw(t)
        }

        /** `var key = "value";` / `var key=value;` — one occurrence. */
        internal fun varOf(body: String?, key: String): String? = varsOf(body, key).firstOrNull()

        /** All occurrences of `var key = …;`, in document order (the file list's parallel arrays). */
        internal fun varsOf(body: String?, key: String): List<String> {
            if (body.isNullOrBlank()) return emptyList()
            val out = ArrayList<String>()
            var from = 0
            while (true) {
                val at = body.indexOf(key, from)
                if (at < 0) break
                var i = at + key.length
                while (i < body.length && (body[i] == ' ' || body[i] == '=' || body[i] == '\t')) i++
                val value = if (i < body.length && body[i] == '"') {
                    val end = body.indexOf('"', i + 1)
                    if (end < 0) break
                    body.substring(i + 1, end).also { from = end + 1 }
                } else {
                    val end = body.indexOfAny(charArrayOf(';', '\r', '\n'), i).let { if (it < 0) body.length else it }
                    body.substring(i, end).trim().also { from = end }
                }
                out.add(value)
            }
            return out
        }

        /** `var create` is `yyyyMMddHHmmss` in the official client's own format (`:1005-1010`). */
        private fun parseCreateTime(raw: String): Long? {
            val t = raw.trim().trim('"')
            if (t.length < 14) return null
            return runCatching {
                val y = t.substring(0, 4).toInt()
                val mo = t.substring(4, 6).toInt()
                val d = t.substring(6, 8).toInt()
                val h = t.substring(8, 10).toInt()
                val mi = t.substring(10, 12).toInt()
                val s = t.substring(12, 14).toInt()
                kotlinx.datetime.LocalDateTime(y, mo, d, h, mi, s)
                    .toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()
            }.getOrNull()
        }
    }
}
