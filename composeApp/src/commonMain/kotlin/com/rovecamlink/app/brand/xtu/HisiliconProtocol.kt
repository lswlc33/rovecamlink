package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.brand.xtu.HiVarParser.bool
import com.rovecamlink.app.brand.xtu.HiVarParser.int
import com.rovecamlink.app.brand.xtu.HiVarParser.long
import com.rovecamlink.app.core.model.Brand
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceEvent
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.SdCardState
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.ota.zeroPad
import com.rovecamlink.app.core.protocol.CameraProtocol
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
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
        val body = http.getText("${cgi(host, port)}/getdeviceattr.cgi")
        val verdict = body != null && (body.contains("var ") || body.contains("name=") || body.contains("\"name\""))
        Diag.d(LogTag.PROTO) {
            "hi3510 probe $host:$port -> $verdict (body=${body?.length ?: "null"} chars, " +
                "starts=${LogFormat.safe(body?.take(40))})"
        }
        return verdict
    }

    override suspend fun connect(host: String, port: Int): CameraSession =
        Diag.inOp("hi3510-connect", "target=$host:$port") {
            val attr = HiVarParser.parse(http.getText("${cgi(host, port)}/getdeviceattr.cgi"))
                ?: error("getdeviceattr.cgi gave no answer at $host:$port")
            val name = attr["name"]?.trim().orEmpty()
            val model = if (name.isNotEmpty()) name else (attr["model"] ?: "XTU Hi35xx")
            val newApp = attr["hardversion"]?.trim() == "NewAPP"
            // Current string work-mode (new-app firmware). Falls back to NormalVideo.
            var strMode = "NormalVideo"
            if (newApp) {
                val wm = HiVarParser.parse(http.getText("${cgi(host, port)}/getcurworkmode.cgi"))
                (wm["workmode"] ?: wm["value"])?.takeIf { it.isNotBlank() }?.let { strMode = it.split(",").first() }
            }
            Diag.d(LogTag.PROTO) {
                "deviceattr keys=${attr.keys.joinToString(",")} hardversion=${attr["hardversion"]} " +
                    "newApp=$newApp strMode=$strMode type=${attr["type"]} softversion=${attr["softversion"]}"
            }
            CameraSession(
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
            sdState = SdCardState.fromRaw(sd["sdstate"]),
            photoCount = count.int("count"),
            raw = (camStatus + allInfo + batt + sd + count),
        )
    }

    private fun mapMode(raw: String?): WorkMode? {
        if (raw.isNullOrBlank()) return null
        // Integer mode (getallinfo replaceMode / legacy workmode) or string mode.
        raw.trim().toIntOrNull()?.let { code ->
            val m = when {
                code in 20..26 -> WorkMode.VIDEO
                code in 0..12 -> WorkMode.PHOTO
                else -> null
            }
            Diag.debug(LogTag.PARSE, "mapMode int $code -> ${m?.name ?: "unmapped"}")
            return m
        }
        val s = raw.trim()
        val m = when {
            s.contains("video", true) || s.contains("car", true) ||
                s.contains("loop", true) || s.contains("slow", true) || s.contains("rec", true) -> WorkMode.VIDEO
            s.contains("photo", true) || s.contains("burst", true) || s.contains("lapse", true) -> WorkMode.PHOTO
            else -> null
        }
        Diag.debug(LogTag.PARSE, "mapMode string \"$s\" -> ${m?.name ?: "unmapped"}")
        return m
    }

    // ---------- controls ----------

    override suspend fun capture(session: CameraSession): CmdResult {
        val r = http.getText("${cgi(session.host, session.port)}/photo.cgi?&-type=photo")
        if (r != null && r.contains("SvrFuncResult")) {
            Diag.w(LogTag.PROTO) { "photo.cgi refused: ${extractSvrError(r)} (body=${LogFormat.bodyField(r, Diag.config.captureSecrets)})" }
            return CmdResult.Failure(extractSvrError(r))
        }
        return if (r != null) CmdResult.Ok else CmdResult.Failure("capture failed (no answer from photo.cgi)")
    }

    override suspend fun record(session: CameraSession, start: Boolean): CmdResult {
        val cmd = if (start) "start" else "stop"
        val r = http.getText("${cgi(session.host, session.port)}/record.cgi?&-cmd=$cmd")
        _events.tryEmit(DeviceEvent.RecordingChanged(start))
        return if (r != null) CmdResult.Ok else CmdResult.Failure("record $cmd failed (no answer from record.cgi)")
    }

    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult {
        val base = cgi(session.host, session.port)
        val (url, how) = if (session.newApp()) {
            val v = if (mode == WorkMode.VIDEO) "NormalVideo" else "NormalPhoto"
            "$base/setcurworkmode.cgi?-workmode=${v.replace(" ", "%20")}" to "string-mode(newApp)"
        } else {
            val code = if (mode == WorkMode.VIDEO) 20 else 0
            "$base/setworkmode.cgi?&-workmode=$code" to "int-mode(legacy)"
        }
        Diag.d(LogTag.PROTO) { "setMode $mode via $how" }
        val r = http.getText(url)
        return if (r != null) CmdResult.Ok else CmdResult.Failure("setMode failed via $how")
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
            Diag.d(LogTag.PROTO) { "menu primary items=${items.size} cur=${curs.size} workmode=${session.strMode()}" }
            if (items.isNotEmpty()) {
                val out = items.mapIndexed { i, name ->
                    val second = HiVarParser.parse(
                        http.getText("$base/getsecondmenuitem.cgi?-workmode=${session.strMode().replace(" ", "%20")}&-name=${name.replace(" ", "%20")}"),
                    )
                    val options = second["item"]?.split(",")?.map { it.trim() }?.filter { it.isNotEmpty() }
                        ?.map { CameraSetting.Option(it, it) } ?: emptyList()
                    Diag.v(LogTag.PARSE) { "menu item \"$name\" options=${options.size} cur=${curs.getOrNull(i) ?: second["value"]}" }
                    CameraSetting(
                        id = name,
                        title = name,
                        value = curs.getOrNull(i) ?: second["value"] ?: "",
                        options = options,
                    )
                }
                return out
            }
            Diag.w(LogTag.PROTO) { "newApp menu had no items — falling back to legacy getters" }
        }
        // Legacy fallback: probe each getter; skip ones the firmware doesn't answer.
        val legacy = legacySettings.mapNotNull { ls ->
            val m = HiVarParser.parse(http.getText("$base/${ls.getCmd}"))
            val v = m[ls.getKey] ?: return@mapNotNull null
            val options = if (ls.boolean) listOf(
                CameraSetting.Option("1", "On"), CameraSetting.Option("0", "Off"),
            ) else emptyList()
            CameraSetting(ls.id, ls.title, v, options)
        }
        Diag.d(LogTag.PROTO) { "legacy settings answered ${legacy.size}/${legacySettings.size}: ${legacy.joinToString(",") { "${it.id}=${it.value}" }}" }
        return legacy
    }

    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult {
        val base = cgi(session.host, session.port)
        if (session.newApp()) {
            val url = "$base/setcurparameter.cgi?-workmode=${session.strMode().replace(" ", "%20")}" +
                "&-name=${id.replace(" ", "%20")}&-value=${value.replace(" ", "%20")}"
            Diag.d(LogTag.PROTO) {
                "setSetting via setcurparameter name=$id value=${LogFormat.settingValue(id, value, Diag.config.captureSecrets)}"
            }
            val r = http.getText(url)
            return if (r != null) CmdResult.Ok
            else CmdResult.Failure("set $id failed (no answer from setcurparameter.cgi)")
        }
        val ls = legacySettings.firstOrNull { it.id == id }
            ?: return CmdResult.Failure("Unknown setting $id")
        val url = "$base/" + ls.setCmd.replace("%s", value)
        Diag.d(LogTag.PROTO) {
            "setSetting via ${ls.setCmd.substringBefore('?')} value=${LogFormat.settingValue(id, value, Diag.config.captureSecrets)}"
        }
        val r = http.getText(url)
        return if (r != null) CmdResult.Ok else CmdResult.Failure("set $id failed (no answer from ${LogFormat.endpointKey(url)})")
    }

    // ---------- files ----------

    override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> =
        Diag.inOp("hi3510-list", "range=$start..$end") {
            val base = cgi(session.host, session.port)
            val host = media(session.host, session.port)
            // Primary: JSON array with metadata.
            val body = http.getText("$base/getfilelistinfoios.cgi?&-start=$start&-end=$end")
            if (!body.isNullOrBlank()) {
                val arr = runCatching { json.parseToJsonElement(body).jsonArray }
                    .onFailure {
                        // A listing that is not JSON usually means the CGI answered with an
                        // error page — the body preview on the exchange line says what.
                        Diag.w(LogTag.PARSE) { "getfilelistinfoios.cgi is not a JSON array: ${it.message}" }
                    }
                    .getOrNull()
                if (arr != null) {
                    val files = arr.mapNotNull { el ->
                        val o = el.jsonObject
                        val path = o["path"]?.jsonPrimitive?.content ?: return@mapNotNull null
                        buildFile(host, path, o["size"]?.jsonPrimitive?.longOrNull ?: 0L, o["create"]?.jsonPrimitive?.content)
                    }
                    Diag.d(LogTag.PARSE) {
                        "list via json: ${arr.size} entries, ${files.size} usable " +
                            "(unknown_type=${files.count { it.type == FileType.UNKNOWN }})"
                    }
                    return@inOp files
                }
            }
            // Fallback: semicolon-separated names.
            val names = http.getText("$base/getfilelist.cgi?&-start=$start&-end=$end")
                ?.split(";")?.map { it.trim() }?.filter { it.isNotEmpty() }
            if (names.isNullOrEmpty()) {
                Diag.d(LogTag.PARSE) { "list empty (json=${body?.length ?: "none"} chars, plain list=${names?.size ?: "none"})" }
                return@inOp emptyList()
            }
            Diag.d(LogTag.PARSE) { "list via getfilelist fallback: ${names.size} names, no sizes/dates" }
            names.map { buildFile(host, it, 0L, null) }
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

    /** create format yyyyMMddHHmmss -> epoch millis (best effort, local time — camera filenames are local). */
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
                .toInstant(TimeZone.currentSystemDefault()).toEpochMilliseconds()
        }.getOrNull()
    }

    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult {
        val r = http.getText("${cgi(session.host, session.port)}/deletefile.cgi?&-name=${file.name}")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("delete failed (deletefile.cgi did not answer)")
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

    // ---------- device info / maintenance ----------

    override suspend fun getDeviceInfo(session: CameraSession): DeviceInfo? {
        val attr = HiVarParser.parse(http.getText("${cgi(session.host, session.port)}/getdeviceattr.cgi")) ?: return null
        return DeviceInfo(
            name = attr["name"]?.trim()?.ifEmpty { null },
            model = attr["model"]?.trim()?.ifEmpty { null },
            serialNumber = attr["serialnum"]?.trim()?.ifEmpty { null },
            softVersion = attr["softversion"]?.trim()?.ifEmpty { null },
            hardVersion = attr["hardversion"]?.trim()?.ifEmpty { null },
            region = attr["region"]?.trim()?.ifEmpty { null },
            raw = attr,
        )
    }

    override suspend fun formatSd(session: CameraSession): CmdResult {
        val r = http.getText("${cgi(session.host, session.port)}/sdcommand.cgi?-format&-partition=1")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("format SD failed")
    }

    override suspend fun factoryReset(session: CameraSession): CmdResult {
        val r = http.getText("${cgi(session.host, session.port)}/reset.cgi")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("factory reset failed")
    }

    override suspend fun reboot(session: CameraSession): CmdResult =
        CmdResult.Failure("Reboot is not supported on this camera")

    override suspend fun syncTime(session: CameraSession): CmdResult {
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val stamp = zeroPad(now.year, 4) + zeroPad(now.monthNumber, 2) + zeroPad(now.dayOfMonth, 2) +
            zeroPad(now.hour, 2) + zeroPad(now.minute, 2) + zeroPad(now.second, 2)
        Diag.i(LogTag.PROTO) { "setsystime cgi stamp=$stamp (device clock is the phone's local time)" }
        val r = http.getText("${cgi(session.host, session.port)}/setsystime.cgi?-time=$stamp")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("time sync failed (setsystime.cgi did not answer)")
    }

    override suspend fun setWifi(session: CameraSession, ssid: String, password: String): CmdResult {
        val url = "${cgi(session.host, session.port)}/setwifi.cgi?&-wifissid=${urlencode(ssid)}&-wifikey=${urlencode(password)}"
        Diag.i(LogTag.PROTO) { "setwifi ssid=$ssid keylen=${password.length} (value redacted unless secrets capture is on)" }
        val r = http.getText(url)
        return if (r != null) CmdResult.Ok else CmdResult.Failure("setwifi failed (setwifi.cgi did not answer)")
    }

    private fun urlencode(s: String): String =
        s.replace(" ", "%20").replace("&", "%26").replace("=", "%3D").replace("+", "%2B")
}
