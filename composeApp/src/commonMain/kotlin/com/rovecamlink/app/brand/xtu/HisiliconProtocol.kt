package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.brand.xtu.HiVarParser.bool
import com.rovecamlink.app.brand.xtu.HiVarParser.int
import com.rovecamlink.app.brand.xtu.HiVarParser.long
import com.rovecamlink.app.core.model.Brand
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceEvent
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.protocol.CameraProtocol
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.datetime.toInstant
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull
import okio.Path

/**
 * XTU Hisilicon Hi35xx ("hi3510") HTTP CGI protocol — the wire protocol spoken
 * by the XTU X7 Pro and most XTU/TUWIN Hi-based action cameras.
 *
 * Wire facts recovered verbatim from the official XTU GO app:
 *  - CGI base:  http://<ip>/cgi-bin/hi3510/   (default ip 192.168.0.1, port 80)
 *  - Responses are `var k="v";` assignments (NOT JSON), except getfilelistinfoios.cgi (JSON array).
 *  - Query params are prefixed with '-'; getters end with '?', setters use '?&-param=value'.
 *  - Preview: rtsp://<ip>:554/livestream/12  (low bitrate) or /11 (high)
 *  - Media download: http://<ip>/<path>; thumbnail: same path with extension swapped to .THM
 */
class HisiliconProtocol(private val http: CameraHttp) : CameraProtocol {

    override val platform = DevicePlatform.HISILICON
    private val json = Json { ignoreUnknownKeys = true; isLenient = true }
    private val _events = MutableSharedFlow<DeviceEvent>(extraBufferCapacity = 8)
    override val events: Flow<DeviceEvent> = _events

    private fun cgi(host: String, port: Int) = "http://$host:$port/cgi-bin/hi3510"
    private fun media(host: String, port: Int) = "http://$host:$port"

    // ---------- probe / connect ----------

    override suspend fun probe(host: String, port: Int): Boolean {
        val body = http.getText("${cgi(host, port)}/getdeviceattr.cgi") ?: return false
        return body.contains("var ") || body.contains("name=") || body.contains("\"name\"")
    }

    override suspend fun connect(host: String, port: Int): CameraSession {
        val attr = HiVarParser.parse(http.getText("${cgi(host, port)}/getdeviceattr.cgi"))
        val name = attr["name"]?.trim().orEmpty()
        val model = if (name.isNotEmpty()) name else (attr["model"] ?: "XTU Hi35xx")
        val newApp = attr["hardversion"]?.trim() == "NewAPP"
        // Current string work-mode (new-app firmware). Falls back to NormalVideo.
        var strMode = "NormalVideo"
        if (newApp) {
            val wm = HiVarParser.parse(http.getText("${cgi(host, port)}/getcurworkmode.cgi"))
            (wm["workmode"] ?: wm["value"])?.takeIf { it.isNotBlank() }?.let { strMode = it.split(",").first() }
        }
        return CameraSession(
            host = host, port = port, platform = platform, brand = Brand.XTU, model = model,
            extras = mapOf(
                "newApp" to newApp.toString(),
                "strMode" to strMode,
                "softversion" to (attr["softversion"] ?: ""),
                "type" to (attr["type"] ?: "117"),
            ),
        )
    }

    private fun CameraSession.newApp() = extras["newApp"] == "true"
    private fun CameraSession.strMode() = extras["strMode"] ?: "NormalVideo"

    // ---------- status ----------

    override suspend fun getStatus(session: CameraSession): DeviceStatus {
        val base = cgi(session.host, session.port)
        val camStatus = HiVarParser.parse(http.getText("$base/getcamerastatus.cgi"))
        val allInfo = HiVarParser.parse(
            http.getText("$base/getcurallinfo.cgi") ?: http.getText("$base/getallinfo.cgi"),
        )
        val batt = HiVarParser.parse(http.getText("$base/getbatterycapacity.cgi?"))
        val sd = HiVarParser.parse(http.getText("$base/getsdstate.cgi?"))
        val count = HiVarParser.parse(http.getText("$base/getfilecount.cgi?"))

        val state = allInfo.int("state")
        // WORK_STATE_RECORD = 0, IDLE = 3 (Common.java)
        val recording = (state == 0) || (camStatus.int("status") == 20)
        val total = sd.int("total")?.toLong()
        val used = sd.int("used")?.toLong()
        val free = if (total != null && used != null) (total - used).coerceAtLeast(0) else null

        return DeviceStatus(
            battery = batt.int("capacity")?.coerceIn(0, 100),
            charging = batt.bool("charge") ?: batt.bool("ac"),
            recording = recording,
            mode = mapMode(allInfo["mode"]),
            videoTimeSec = allInfo.int("pasttime"),
            sdTotalMb = total,
            sdFreeMb = free,
            photoCount = count.int("count"),
            raw = (camStatus + allInfo + batt + sd + count),
        )
    }

    private fun mapMode(raw: String?): WorkMode? {
        if (raw.isNullOrBlank()) return null
        // Integer mode (getallinfo replaceMode / legacy workmode) or string mode.
        raw.trim().toIntOrNull()?.let { code ->
            return when {
                code in 20..26 -> WorkMode.VIDEO
                code in 0..12 -> WorkMode.PHOTO
                else -> null
            }
        }
        val s = raw.trim()
        return when {
            s.contains("video", true) || s.contains("car", true) ||
                s.contains("loop", true) || s.contains("slow", true) || s.contains("rec", true) -> WorkMode.VIDEO
            s.contains("photo", true) || s.contains("burst", true) || s.contains("lapse", true) -> WorkMode.PHOTO
            else -> null
        }
    }

    // ---------- controls ----------

    override suspend fun capture(session: CameraSession): CmdResult {
        val r = http.getText("${cgi(session.host, session.port)}/photo.cgi?&-type=photo")
        return if (r != null && !r.contains("SvrFuncResult")) CmdResult.Ok
        else CmdResult.Failure(r?.let { extractSvrError(it) } ?: "capture failed")
    }

    override suspend fun record(session: CameraSession, start: Boolean): CmdResult {
        val cmd = if (start) "start" else "stop"
        val r = http.getText("${cgi(session.host, session.port)}/record.cgi?&-cmd=$cmd")
        _events.tryEmit(DeviceEvent.RecordingChanged(start))
        return if (r != null) CmdResult.Ok else CmdResult.Failure("record $cmd failed")
    }

    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult {
        val base = cgi(session.host, session.port)
        val r = if (session.newApp()) {
            val v = if (mode == WorkMode.VIDEO) "NormalVideo" else "NormalPhoto"
            http.getText("$base/setcurworkmode.cgi?-workmode=${v.replace(" ", "%20")}")
        } else {
            val code = if (mode == WorkMode.VIDEO) 20 else 0
            http.getText("$base/setworkmode.cgi?&-workmode=$code")
        }
        return if (r != null) CmdResult.Ok else CmdResult.Failure("setMode failed")
    }

    private fun extractSvrError(body: String): String {
        val i = body.indexOf("SvrFuncResult")
        if (i < 0) return "device error"
        val rest = body.substring(i)
        val q1 = rest.indexOf('"')
        val q2 = rest.lastIndexOf('"')
        return if (q1 in 0 until q2) rest.substring(q1 + 1, q2) else "device error"
    }

    // ---------- settings ----------

    /** Legacy get/set descriptors: id -> (title, getCmd, getKey, setCmd template, boolean?). */
    private data class LegacySetting(
        val id: String,
        val title: String,
        val getCmd: String,
        val getKey: String,
        val setCmd: String, // template with %s for value
        val boolean: Boolean = false,
    )

    private val legacySettings = listOf(
        LegacySetting("videoinfo", "Video resolution", "getvideoinfo.cgi?", "resolution", "setvideoinfo.cgi?&-resolution=%s&-fps=30"),
        LegacySetting("bitrate", "Bitrate", "getbitrate.cgi?", "bitrate", "setbitrate.cgi?&-bitrate=%s"),
        LegacySetting("fov", "Field of view", "getviewfield.cgi?", "fov", "setviewfield.cgi?&-fov=%s"),
        LegacySetting("looprecord", "Loop record", "getlooprecord.cgi?", "enable", "setlooprecord.cgi?&-enable=%s", true),
        LegacySetting("flip", "Flip", "getflip.cgi?", "enable", "setflip.cgi?&-enable=%s", true),
        LegacySetting("audio", "Audio", "getaudioencode.cgi?", "enable", "setaudioencode.cgi?&-enable=%s", true),
        LegacySetting("buzzer", "Buzzer", "getbuzzer.cgi?", "enable", "setbuzzer.cgi?&-enable=%s", true),
        LegacySetting("led", "LED", "getledstate.cgi?", "enable", "setledstate.cgi?&-enable=%s", true),
        LegacySetting("videonorm", "Video standard", "getvideonorm.cgi?", "videonorm", "setvideonorm.cgi?&-videonorm=%s"),
        LegacySetting("autoshutdown", "Auto shutdown", "getautoshutdown.cgi?", "time", "setautoshutdown.cgi?&-time=%s"),
        LegacySetting("brightness", "Screen brightness", "getscreenbrightness.cgi?", "brightness", "setscreenbrightness.cgi?&-brightness=%s"),
    )

    override suspend fun getSettings(session: CameraSession): List<CameraSetting> {
        val base = cgi(session.host, session.port)
        if (session.newApp()) {
            // New-app menu: getprimarymenuitem -> item/cur lists; getsecondmenuitem -> allowed values.
            val primary = HiVarParser.parse(http.getText("$base/getprimarymenuitem.cgi?-workmode=${session.strMode().replace(" ", "%20")}"))
            val items = primary["item"]?.split(",")?.map { it.trim() }?.filter { it.isNotEmpty() } ?: emptyList()
            val curs = primary["cur"]?.split(",")?.map { it.trim() } ?: emptyList()
            if (items.isNotEmpty()) {
                return items.mapIndexed { i, name ->
                    val second = HiVarParser.parse(
                        http.getText("$base/getsecondmenuitem.cgi?-workmode=${session.strMode().replace(" ", "%20")}&-name=${name.replace(" ", "%20")}"),
                    )
                    val options = second["item"]?.split(",")?.map { it.trim() }?.filter { it.isNotEmpty() }
                        ?.map { CameraSetting.Option(it, it) } ?: emptyList()
                    CameraSetting(
                        id = name,
                        title = name,
                        value = curs.getOrNull(i) ?: second["value"] ?: "",
                        options = options,
                    )
                }
            }
        }
        // Legacy fallback: probe each getter; skip ones the firmware doesn't answer.
        return legacySettings.mapNotNull { ls ->
            val m = HiVarParser.parse(http.getText("$base/${ls.getCmd}"))
            val v = m[ls.getKey] ?: return@mapNotNull null
            val options = if (ls.boolean) listOf(
                CameraSetting.Option("1", "On"), CameraSetting.Option("0", "Off"),
            ) else emptyList()
            CameraSetting(ls.id, ls.title, v, options)
        }
    }

    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult {
        val base = cgi(session.host, session.port)
        if (session.newApp()) {
            val url = "$base/setcurparameter.cgi?-workmode=${session.strMode().replace(" ", "%20")}" +
                "&-name=${id.replace(" ", "%20")}&-value=${value.replace(" ", "%20")}"
            val r = http.getText(url)
            return if (r != null) CmdResult.Ok else CmdResult.Failure("set $id failed")
        }
        val ls = legacySettings.firstOrNull { it.id == id }
            ?: return CmdResult.Failure("Unknown setting $id")
        val url = "$base/" + ls.setCmd.replace("%s", value)
        val r = http.getText(url)
        return if (r != null) CmdResult.Ok else CmdResult.Failure("set $id failed")
    }

    // ---------- files ----------

    override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> {
        val base = cgi(session.host, session.port)
        val host = media(session.host, session.port)
        // Primary: JSON array with metadata.
        val body = http.getText("$base/getfilelistinfoios.cgi?&-start=$start&-end=$end")
        if (!body.isNullOrBlank()) {
            val arr = runCatching { json.parseToJsonElement(body).jsonArray }.getOrNull()
            if (arr != null) {
                return arr.mapNotNull { el ->
                    val o = el.jsonObject
                    val path = o["path"]?.jsonPrimitive?.content ?: return@mapNotNull null
                    buildFile(host, path, o["size"]?.jsonPrimitive?.longOrNull ?: 0L, o["create"]?.jsonPrimitive?.content)
                }
            }
        }
        // Fallback: semicolon-separated names.
        val names = http.getText("$base/getfilelist.cgi?&-start=$start&-end=$end")
            ?.split(";")?.map { it.trim() }?.filter { it.isNotEmpty() } ?: return emptyList()
        return names.map { buildFile(host, it, 0L, null) }
    }

    private fun buildFile(host: String, path: String, size: Long, create: String?): RemoteFile {
        val lower = path.lowercase()
        val type = when {
            lower.endsWith(".mp4") || lower.endsWith(".lrv") || lower.endsWith(".mov") -> FileType.VIDEO
            lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".dng") || lower.endsWith(".png") -> FileType.PHOTO
            else -> FileType.UNKNOWN
        }
        val thumbPath = if (type == FileType.VIDEO && path.length > 4) path.substring(0, path.length - 4) + ".THM" else path
        return RemoteFile(
            name = path,
            type = type,
            sizeBytes = size,
            downloadUrl = "$host/$path",
            thumbnailUrl = "$host/$thumbPath",
            dateMillis = parseCreateDate(create),
        )
    }

    /** create format yyyyMMddHHmmss -> epoch millis (best effort, UTC). */
    @OptIn(kotlin.time.ExperimentalTime::class)
    private fun parseCreateDate(create: String?): Long? {
        if (create == null || create.length < 14) return null
        return runCatching {
            val y = create.substring(0, 4).toInt()
            val mo = create.substring(4, 6).toInt()
            val d = create.substring(6, 8).toInt()
            val h = create.substring(8, 10).toInt()
            val mi = create.substring(10, 12).toInt()
            val s = create.substring(12, 14).toInt()
            kotlinx.datetime.LocalDateTime(y, mo, d, h, mi, s)
                .toInstant(kotlinx.datetime.TimeZone.UTC).toEpochMilliseconds()
        }.getOrNull()
    }

    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult {
        val r = http.getText("${cgi(session.host, session.port)}/deletefile.cgi?&-name=${file.name}")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("delete failed")
    }

    override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? =
        http.getBytes(file.thumbnailUrl ?: file.downloadUrl)

    override suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long = http.download(file.downloadUrl, dest, alreadyHaveBytes, onProgress)

    override fun previewUrl(session: CameraSession): String =
        "rtsp://${session.host}:554/livestream/12"
}
