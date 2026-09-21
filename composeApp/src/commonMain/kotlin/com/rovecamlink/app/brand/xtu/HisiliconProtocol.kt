package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.brand.xtu.HiVarParser.bool
import com.rovecamlink.app.brand.xtu.HiVarParser.int
import com.rovecamlink.app.brand.xtu.HiVarParser.long
import com.rovecamlink.app.brand.xtu.HiVarParser.mb
import com.rovecamlink.app.core.model.Brand
import com.rovecamlink.app.core.model.CameraMode
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceEvent
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.ModeFamily
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.SdCardState
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.protocol.CameraProtocol
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
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
 *  - Preview: rtsp://<ip>:554/livestream/12 — the only RTSP path the official app ever
 *    builds (`SSCommandUtil.java:50`, `HaisiCommandUtil.java:50`, `AmbaPreviewActivity.java:972`).
 *    The APK does contain a second, HTTP preview URL though:
 *    `http://<ip>:80/11|12?trans=tcp&action=play&media=video_data`, where 11 is used when
 *    `DV.isPreviewBigBitRate()` (prefer.previewVideo == "Big") — see `DV.java:332-341`.
 *    So "/11" is real, but it is an HTTP mux path, not an RTSP high-bitrate stream.
 *    It also plays that RTSP URL over RTP/TCP, not UDP — see core.media.CameraPreview.
 *  - Media download: http://<ip>/<path>; thumbnail: same path with extension swapped to .THM
 */
class HisiliconProtocol(private val http: CameraHttp) : CameraProtocol {

    override val platform = DevicePlatform.HISILICON

    /**
     * `XTUCam_*` is what the S7Pro actually broadcast in the 2026-09-21 field
     * session (`XTUCam_f9e5e2`, next to the BLE name `XTU_S7Pro_f9e5e2`). The bare
     * `XTU` prefix is deliberately **not** claimed here: XTU's Ambarella models
     * (S7 / S7Pro Max) use the same naming and do not answer CGI on port 80, so a
     * prefix that wide would send this plugin at a camera it cannot speak to.
     */
    override val wifiSsidPrefixes = listOf("XTUCam_")

    /** SSConstant.SS_IP — the AP hands out itself as the gateway, on every firmware. */
    override val fixedHost: String? get() = "192.168.0.1"

    /** docs/03: the XTU factory passphrase, what the official app fills in silently. */
    override val defaultWifiPassword: String? get() = "12345678"

    private val json = Json { ignoreUnknownKeys = true; isLenient = true }
    private val _events = MutableSharedFlow<DeviceEvent>(extraBufferCapacity = 8)
    override val events: Flow<DeviceEvent> = _events

    /** The endpoints whose verdict lives somewhere other than the `Success` sentinel. */
    private val maintenance = HiMaintenance(http) { cgi(it.host, it.port) }

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
    private fun CameraSession.strMode() = extras["strMode"] ?: "Normal Video"

    /**
     * The work-mode string to pass as `-workmode=`. Read live rather than frozen at
     * connect time: the menu belongs to whichever mode the camera is in *now*, and a
     * session that began in "Normal Video" and was switched to "Normal Photo" must not
     * keep being served the video menu.
     */
    private val liveMode = mutableMapOf<String, String>()

    private suspend fun currentStrMode(session: CameraSession, refresh: Boolean = false): String {
        if (!session.newApp()) return session.strMode()
        if (!refresh) liveMode[session.host]?.let { return it }
        val fresh = HiVarParser.parse(http.getText("${cgi(session.host, session.port)}/getcurworkmode.cgi"))
        val name = (fresh["workmode"] ?: fresh["value"])?.split(",")?.firstOrNull()?.trim()
        return if (name.isNullOrEmpty()) session.strMode() else name.also { liveMode[session.host] = it }
    }

    /** Work-state codes the SigmaStar/Hi35xx firmware reports in `getcurallinfo`. */
    private companion object {
        /** Camera is busy in the current work mode — recording, or mid-capture. */
        const val STATE_WORKING = 20

        /** Camera is idle and accepts capture/mode commands. */
        const val STATE_STANDBY = 21

        /**
         * `pasttime` counts **seconds** on this firmware.
         *
         * The official app divides it by 2 on the Ambarella path
         * (`AmbaPreviewPresenter.showRecordCDTime(pasttime / 2)`), which implies
         * half-second ticks there. The S7PRO disagrees: in the 2026-09-21 session
         * recording restarted at +121.42 s and `pasttime` read 16 at +138.82 s —
         * 17.4 elapsed seconds for 16 ticks, and +127.19→+138.82 gave 4→16 over
         * 11.63 s. Treating it as half-seconds would run the on-screen timer at
         * exactly half speed, which is how this line was first measured wrong.
         * If another Hi/XTU model reports a timer advancing twice as fast as the
         * clock, that unit is per-firmware and belongs in the profile, not here.
         */
        const val PASTTIME_TICKS_PER_SECOND = 1

        /** Work-mode strings the NewAPP firmware accepts when it hides `getallworkmode`. */
        const val VIDEO_MODE_STRING = "Normal Video"
        const val PHOTO_MODE_STRING = "Normal Photo"

        /** The endpoint every video-family mode shoots with; see [HiModes.VIDEO_SHAPE]. */
        const val VIDEO_ENDPOINT = "record.cgi"

        /**
         * Ceiling for a `.THM` read. The S7PRO's thumbnails measured 6–28 KB in the
         * 2026-09-21 session, so anything past a mebibyte is not a preview and is
         * refused by the transport rather than decoded ([CameraHttp.getBytes]).
         */
        const val MAX_THUMBNAIL_BYTES: Int = 1024 * 1024

        /** A `-`-prefixed CGI query value, percent-encoded. */
        fun param(value: String): String = Cgi.param(value)
    }

    /**
     * The work-mode names this firmware actually accepts, split into the video and
     * photo families. `setcurworkmode.cgi` rejects anything outside this list with
     * `SvrFuncResult="-2222"`, so mode switches resolve their target string here
     * instead of guessing at a spelling.
     *
     * Cached per host for the life of the session: the table is static, and it is
     * consulted on every status poll to tell "recording" from "mid-capture".
     */
    private val workModeCache = mutableMapOf<String, Map<String, List<String>>>()

    /** Hosts whose work-mode table was already tried and failed. */
    private val workModeUnsupported = mutableSetOf<String>()

    /**
     * The named mode list resolved per host — from `getallworkmode.cgi` when the
     * firmware answers it, otherwise from [probeModes]. Static for a camera's life,
     * so it is resolved once per session like [workModeCache].
     */
    private val namedModeCache = mutableMapOf<String, List<CameraMode>>()

    /** The device's own (`-workmode=System`) item names, for the same reason as [menuCache]. */
    private val deviceMenuCache = mutableMapOf<String, List<String>>()

    private suspend fun workModeNames(session: CameraSession): Map<String, List<String>> {
        workModeCache[session.host]?.let { return it }
        if (session.host in workModeUnsupported) return emptyMap()
        val loaded = runCatching {
            val body = http.getText("${cgi(session.host, session.port)}/getallworkmode.cgi") ?: return@runCatching emptyMap()
            val parsed = HiVarParser.parse(body)
            mapOf(
                "video" to parsed["video"].csvOrList(),
                "photo" to parsed["photo"].csvOrList(),
            ).filterValues { it.isNotEmpty() }
        }.getOrDefault(emptyMap())
        // Record the negative answer too: consulted on every status poll, a silent
        // retry would be one wasted camera request every 1.5 seconds forever.
        if (loaded.isEmpty()) workModeUnsupported.add(session.host) else workModeCache[session.host] = loaded
        return loaded
    }

    /** Drop a resolved firmware table when its session goes away. */
    override fun onSessionClosed(session: CameraSession) {
        workModeCache.remove(session.host)
        workModeUnsupported.remove(session.host)
        namedModeCache.remove(session.host)
        menuCache.remove(session.host)
        deviceMenuCache.remove(session.host)
        liveMode.remove(session.host)
    }

    /** Forget the cached mode/menu for a host after the camera's mode changed. */
    private fun invalidateModeCache(session: CameraSession) {
        liveMode.remove(session.host)
        menuCache.remove(session.host)
    }

    private fun String?.csvOrList(): List<String> =
        this?.split(',', '\n')?.map { it.trim() }?.filter { it.isNotEmpty() } ?: emptyList()

    /** The firmware name for the requested family, or [fallback] when the table is unavailable. */
    private fun resolveModeName(modes: Map<String, List<String>>, family: String, fallback: String): String =
        modes[family].orEmpty().firstOrNull { it.equals(fallback, ignoreCase = true) }
            ?: modes[family].orEmpty().firstOrNull() ?: fallback

    /**
     * The modes this camera offers, in the firmware's own order and spelling.
     *
     * `getallworkmode.cgi` is the source of truth (`var video="Normal Video,Slow
     * Motion,…"; var photo="…";`, comma-split with the spaces **kept** —
     * `SSResponseParse.java:203-213` splits on the comma and trims nothing). When it
     * does not answer — the XTU S7PRO ignored it for the whole 2026-09-21 session —
     * the mode set is recovered by [probeModes] instead, and both results are cached
     * per host for the life of the session.
     *
     * An empty list means "this firmware generation has no named modes" (the legacy
     * int-mode cameras), which the UI reads as "offer the coarse video/photo pair".
     */
    override suspend fun listModes(session: CameraSession): List<CameraMode> {
        if (!session.newApp()) {
            Diag.d(LogTag.PROTO) { "listModes skipped: legacy firmware has no named work modes" }
            return emptyList()
        }
        namedModeCache[session.host]?.let { return it }
        val table = workModeNames(session)
        val modes = if (table.isNotEmpty()) {
            buildList {
                table["video"].orEmpty().forEach { add(HiModes.modeFor(it, ModeFamily.VIDEO)) }
                table["photo"].orEmpty().forEach { add(HiModes.modeFor(it, ModeFamily.PHOTO)) }
            }.also {
                Diag.i(LogTag.PROTO) {
                    "modes from getallworkmode: n=${it.size} ${it.joinToString(",") { m -> m.name }.take(240)}"
                }
            }
        } else {
            probeModes(session) ?: return emptyList()
        }
        // A conclusive answer is cached even when it found nothing: this camera then
        // said `-2222` to all 22 names, and re-asking on every call is not a fallback,
        // it is a denial of service on a link that also carries the live view.
        // [probeModes] returning null (inconclusive) deliberately skips this line.
        namedModeCache[session.host] = modes
        return modes
    }

    /**
     * Which named modes exist, discovered **read-only**.
     *
     * `getprimarymenuitem.cgi?-workmode=<candidate>` is a getter, and the firmware
     * answers `SvrFuncResult="-2222"` for a mode it does not have (`Cgi.explain`'s
     * "unknown name/value") versus an item list for one it does. `setcurworkmode.cgi`
     * would answer just as distinctly — and would also put the camera into the mode,
     * so a mode *listing* would change what the camera is doing. It is never used here.
     *
     * Null means the probe told us nothing worth caching: either the camera said
     * something other than `-2222` (busy, or a firmware whose refusal is numbered
     * differently), or it never answered a name we also have no positive answer for.
     * An empty body is not a "no": `getcamerastatus.cgi` answers exactly that on the
     * S7PRO while still being a live endpoint, so one silent candidate is skipped
     * rather than ending the run.
     */
    private suspend fun probeModes(session: CameraSession): List<CameraMode>? {
        val base = cgi(session.host, session.port)
        val found = ArrayList<CameraMode>()
        val absent = ArrayList<String>()
        val silent = ArrayList<String>()
        var stopped: String? = null
        for ((family, name) in HiModes.candidates) {
            val body = http.getText("$base/getprimarymenuitem.cgi?-workmode=${param(name)}")
            when (val verdict = Cgi.verdict(body)) {
                is CgiReply.Accepted -> {
                    // A mode the camera has answers with its menu; one it has not is
                    // `-2222`. An accepted body with no items is neither, and listing
                    // it would offer the user a mode that cannot be read or written.
                    if (HiVarParser.parse(body)["item"].orEmpty().isNotBlank()) {
                        found += HiModes.modeFor(name, family)
                    } else {
                        absent += "$name(empty menu)"
                    }
                }
                is CgiReply.Rejected ->
                    if (verdict.code == HiModes.UNKNOWN_NAME) absent += name else {
                        stopped = "\"$name\" answered ${verdict.code} — the camera is not simply missing modes"
                        break
                    }
                CgiReply.NoAnswer -> silent += name
            }
        }
        val inconclusive = stopped != null || (found.isEmpty() && silent.isNotEmpty())
        Diag.i(LogTag.PROTO) {
            buildString {
                append("mode probe ").append(if (inconclusive) "INCONCLUSIVE" else "complete").append(": ")
                append("answered=").append(found.size)
                append(" (").append(found.joinToString(",") { it.name }).append(") ")
                append("rejected-2222=").append(absent.size)
                append(" (").append(absent.joinToString(",")).append(")")
                if (silent.isNotEmpty()) {
                    append(" no-answer=").append(silent.size).append(" (").append(silent.joinToString(",")).append(")")
                }
                stopped?.let { append(" reason=").append(it) }
            }
        }
        return found.takeIf { !inconclusive }
    }

    /** The family a mode name belongs to, from this session's resolved list first. */
    private suspend fun familyOf(session: CameraSession, name: String?): ModeFamily? {
        if (name.isNullOrEmpty()) return null
        namedModeCache[session.host]?.firstOrNull { it.name == name }?.let { return it.family }
        HiModes.familyOf(name)?.let { return it }
        val table = workModeNames(session)
        return when {
            name in table["video"].orEmpty() -> ModeFamily.VIDEO
            name in table["photo"].orEmpty() -> ModeFamily.PHOTO
            else -> null
        }
    }

    // ---------- status ----------

    override suspend fun getStatus(session: CameraSession): DeviceStatus {
        val base = cgi(session.host, session.port)
        val allInfo = HiVarParser.parse(
            http.getText("$base/getcurallinfo.cgi") ?: http.getText("$base/getallinfo.cgi"),
        )
        val batt = HiVarParser.parse(http.getText("$base/getbatterycapacity.cgi?"))
        val sd = HiVarParser.parse(http.getText("$base/getsdstate.cgi?"))
        val count = HiVarParser.parse(http.getText("$base/getfilecount.cgi?"))

        // `getcamerastatus.cgi` answers `200 OK` with an empty body on the XTU S7PRO
        // (firmware 20.8.6.1.20260710), so it is only worth a request when
        // getcurallinfo did not carry a work state at all.
        val state = allInfo.int("state")
        val camStatus = if (state == null) {
            HiVarParser.parse(http.getText("$base/getcamerastatus.cgi"))
        } else {
            emptyMap()
        }

        val modeName = allInfo["mode"]?.trim().orEmpty()
        val working = (state == STATE_WORKING) || (state == null && camStatus.int("status") == STATE_WORKING)
        // State 20 only means "recording" in a video-family mode; in a photo mode the
        // same code means the camera is mid-capture and must simply not be poked.
        val recording = working && isVideoModeName(modeName, session)
        val total = sd.mb("total")
        val used = sd.mb("used")
        val free = if (total != null && used != null) (total - used).coerceAtLeast(0) else null

        return DeviceStatus(
            battery = batt.int("capacity")?.coerceIn(0, 100),
            charging = batt.bool("charge") ?: batt.bool("ac"),
            recording = recording,
            busy = working && !recording,
            mode = mapMode(if (modeName.isEmpty()) null else modeName),
            modeName = modeName.ifEmpty { null },
            workState = state ?: camStatus.int("status"),
            videoTimeSec = (allInfo.int("pasttime") ?: camStatus.int("pasttime"))
                ?.let { it / PASTTIME_TICKS_PER_SECOND },
            sdTotalMb = total,
            sdFreeMb = free,
            sdState = SdCardState.fromRaw(sd["sdstate"]),
            photoCount = count.int("count"),
            raw = (camStatus + allInfo + batt + sd + count),
        )
    }

    private suspend fun isVideoModeName(name: String, session: CameraSession): Boolean {
        if (name.isEmpty()) return false
        val modes = workModeNames(session)
        if (modes.isNotEmpty()) {
            val video = modes["video"].orEmpty()
            val photo = modes["photo"].orEmpty()
            if (video.contains(name) || photo.contains(name)) return video.contains(name)
        }
        // No work-mode table (older firmware, or getallworkmode unsupported).
        return name.contains("video", true) || name.contains("car", true) ||
            name.contains("loop", true) || name.contains("slow", true) || name.contains("rec", true)
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

    /**
     * One cheap request that answers "what is the camera doing right now", so a
     * control command can be refused before it is sent instead of being silently
     * dropped by the firmware.
     */
    private suspend fun peekWorkState(session: CameraSession): Pair<Int?, String?> {
        val base = cgi(session.host, session.port)
        val info = HiVarParser.parse(
            http.getText("$base/getcurallinfo.cgi") ?: http.getText("$base/getallinfo.cgi"),
        )
        return info.int("state") to info["mode"]?.trim()
    }

    /**
     * Take a picture in **whatever mode the camera is in right now**.
     *
     * The official command table does not have one photo command; it looks the
     * current mode up and sends the CGI that mode's shutter understands
     * (`Command.java:9-31`, dispatched by the mode→index map at
     * `HaisiPreviewModel.java:340-394`). [HiModes] is that table here, so the CGI,
     * the query and whether a stop is needed all come from one row.
     *
     * The mode is read from the camera (`getcurallinfo`'s `mode`, falling back to
     * `getcurworkmode`), never from what the UI last asked for: a camera that timed
     * itself out of a mode, or was switched on its own buttons, would otherwise get a
     * `phototimelapse` start while the user thinks they are taking one still.
     */
    override suspend fun capture(session: CameraSession): CmdResult {
        val base = cgi(session.host, session.port)
        val (state, reportedMode) = peekWorkState(session)
        if (state != null && state != STATE_STANDBY) {
            // Verified on an XTU S7PRO: `photo.cgi` while the camera is working does
            // not take a still — it reset the running recording instead, and no file
            // ever appeared (`getfilecount` stayed put all session).
            return CmdResult.Failure("Camera is busy (state $state) — wait for it to go idle before taking a photo")
        }
        val modeName = reportedMode?.takeIf { it.isNotEmpty() } ?: currentStrMode(session)
        val family = familyOf(session, modeName) ?: if (session.newApp()) ModeFamily.PHOTO else null
        val shape = HiModes.shapeFor(modeName, family ?: ModeFamily.PHOTO, session.newApp())
        if (family == ModeFamily.VIDEO || shape.endpoint == VIDEO_ENDPOINT) {
            // A video-family mode has no still to take. Guessing one (which the old
            // code did whenever the mode table was unavailable) leaves the user with
            // a photo they never asked for, or a recording restarted behind their back.
            return CmdResult.Failure(
                "Camera is in video mode \"${modeName ?: "?"}\" — the record button starts that one, not capture",
            )
        }
        val url = shape.startUrl(base)
        Diag.d(LogTag.PROTO) { "capture in \"$modeName\" (family=${family?.name ?: "unknown"}) -> $url" }
        val r = http.getText(url)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> {
                Diag.i(LogTag.PROTO) { "${shape.endpoint} accepted (mode=${modeName ?: "?"} state=${state ?: "?"})" }
                CmdResult.Ok
            }
            is CgiReply.Rejected -> refuse(shape.endpoint, verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("capture failed (no answer from ${shape.endpoint})")
        }
    }

    /**
     * End a running capture sequence (定时拍照 / 延时拍照), which the camera keeps
     * taking frames for until it is told to stop — see [HiModes.TIMING_PHOTO] and
     * [HiModes.TIMELAPSE_PHOTO]. A single-shot mode has nothing to end and says so
     * without a request; a video-family mode's "stop" is the record stop, so this
     * delegates rather than inventing a third spelling.
     */
    override suspend fun stopCapture(session: CameraSession): CmdResult {
        val base = cgi(session.host, session.port)
        val (_, reportedMode) = peekWorkState(session)
        val modeName = reportedMode?.takeIf { it.isNotEmpty() } ?: currentStrMode(session)
        val family = familyOf(session, modeName) ?: HiModes.familyOf(modeName)
        val shape = HiModes.shapeFor(modeName, family ?: ModeFamily.PHOTO, session.newApp())
        val url = shape.stopUrl(base)
        if (url == null) {
            if (shape.endpoint == VIDEO_ENDPOINT) return record(session, start = false)
            Diag.d(LogTag.PROTO) { "stopCapture in \"$modeName\" is a no-op: one press, one picture" }
            return CmdResult.Ok
        }
        Diag.d(LogTag.PROTO) { "stopCapture in \"$modeName\" -> $url" }
        val r = http.getText(url)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> {
                Diag.i(LogTag.PROTO) { "${shape.endpoint} stop accepted (mode=${modeName ?: "?"})" }
                CmdResult.Ok
            }
            is CgiReply.Rejected -> refuse("${shape.endpoint} stop", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("stop failed (no answer from ${shape.endpoint})")
        }
    }

    /**
     * Switch to a named mode, verbatim: the value sent is the one the camera
     * itself reported through [listModes], spaces and all.
     */
    override suspend fun setNamedMode(session: CameraSession, mode: CameraMode): CmdResult {
        if (!session.newApp()) {
            // Legacy firmware addresses modes by number; there is no name to send.
            return setMode(session, if (mode.family == ModeFamily.VIDEO) WorkMode.VIDEO else WorkMode.PHOTO)
        }
        val base = cgi(session.host, session.port)
        val (state, current) = peekWorkState(session)
        if (state == STATE_WORKING) {
            return CmdResult.Failure("Camera is busy (recording or capturing) — stop it before changing mode")
        }
        if (current == mode.name) {
            Diag.d(LogTag.PROTO) { "setNamedMode \"${mode.name}\" skipped: already in it" }
            return CmdResult.Ok
        }
        val url = "$base/setcurworkmode.cgi?-workmode=${param(mode.name)}"
        Diag.d(LogTag.PROTO) { "setNamedMode \"${mode.name}\" (${mode.family.name}/${mode.trigger.name}) -> $url" }
        val r = http.getText(url)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> {
                // The menu and the "current mode" both follow the mode, and the
                // camera's own answer is now stale on both counts.
                liveMode[session.host] = mode.name
                menuCache.remove(session.host)
                CmdResult.Ok
            }
            is CgiReply.Rejected -> refuse("setNamedMode \"${mode.name}\"", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("setNamedMode \"${mode.name}\" failed (no answer from setcurworkmode.cgi)")
        }
    }

    override suspend fun record(session: CameraSession, start: Boolean): CmdResult {
        val cmd = if (start) "start" else "stop"
        val r = http.getText("${cgi(session.host, session.port)}/record.cgi?&-cmd=$cmd")
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> {
                // Only claim a state change the camera actually took: an optimistic
                // push that a later poll contradicts makes the record button flicker.
                _events.tryEmit(DeviceEvent.RecordingChanged(start))
                CmdResult.Ok
            }
            is CgiReply.Rejected -> refuse("record.cgi cmd=$cmd", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("record $cmd failed (no answer from record.cgi)")
        }
    }

    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult {
        val base = cgi(session.host, session.port)
        if (mode == WorkMode.PLAYBACK) {
            // These firmwares expose no app-selectable playback work mode; the camera
            // browses its own card. Silently mapping this to photo mode switched the
            // user into "Normal Photo" and looked like a bug.
            return CmdResult.Failure("This camera has no app-controlled playback mode — browse files from the app")
        }
        val (state, current) = peekWorkState(session)
        if (state == STATE_WORKING) {
            return CmdResult.Failure("Camera is busy (recording or capturing) — stop it before changing mode")
        }
        val url = if (session.newApp()) {
            val modes = workModeNames(session)
            val fallback = if (mode == WorkMode.VIDEO) VIDEO_MODE_STRING else PHOTO_MODE_STRING
            // The firmware rejects an unknown name with -2222; the spelling that was
            // here before ("NormalPhoto", no space) was exactly such an unknown name.
            if (current != null && current.equals(resolveModeName(modes, mode.family(), fallback), ignoreCase = true)) {
                Diag.d(LogTag.PROTO) { "setMode $mode skipped: already in \"$current\"" }
                return CmdResult.Ok
            }
            "$base/setcurworkmode.cgi?-workmode=${param(resolveModeName(modes, mode.family(), fallback))}" to "string-mode(newApp)"
        } else {
            val code = if (mode == WorkMode.VIDEO) 20 else 0
            "$base/setworkmode.cgi?&-workmode=$code" to "int-mode(legacy)"
        }
        val (target, how) = url
        Diag.d(LogTag.PROTO) { "setMode $mode via $how -> $target" }
        val r = http.getText(target)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> {
                // The menu follows the mode, so both cached facts about it are now wrong.
                invalidateModeCache(session)
                CmdResult.Ok
            }
            is CgiReply.Rejected -> refuse("setMode $how", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("setMode failed via $how")
        }
    }

    /** Which `getallworkmode` family a [WorkMode] belongs to. */
    private fun WorkMode.family(): String = when (this) {
        WorkMode.VIDEO -> "video"
        else -> "photo"
    }

    private suspend fun refuse(endpoint: String, verdict: CgiReply.Rejected): CmdResult.Failure {
        val detail = Cgi.explain(verdict.code)
        Diag.w(LogTag.PROTO) { "$endpoint refused: code=${verdict.code} — $detail (body=${LogFormat.bodyField(verdict.body, Diag.config.captureSecrets)})" }
        return CmdResult.Failure("$endpoint: $detail")
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
            // Read the mode live, because which items exist is a property of the mode.
            val modeName = currentStrMode(session, refresh = true)
            val out = readMenu(session, modeName, menuCache)
            if (out.isNotEmpty()) return out
            Diag.w(LogTag.PROTO) { "newApp menu produced no rows for \"$modeName\" — falling back to legacy getters" }
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

    /**
     * Walk one menu: `getprimarymenuitem.cgi?-workmode=<[workmode]>` for the rows,
     * then one `getsecondmenuitem.cgi` per row for its options and authoritative
     * value, and record the item names in [nameCache] so a write can be checked
     * before it is sent.
     *
     * Shared by the per-mode menu and the device menu (`System`) because they are the
     * same two endpoints addressed by a different `-workmode=` — see
     * [getDeviceSettings].
     */
    private suspend fun readMenu(
        session: CameraSession,
        workmode: String,
        nameCache: MutableMap<String, List<String>>,
    ): List<CameraSetting> {
        val base = cgi(session.host, session.port)
        val wp = param(workmode)
        val primary = HiMenu.parsePrimaryItems(http.getText("$base/getprimarymenuitem.cgi?-workmode=$wp"))
        Diag.d(LogTag.PROTO) {
            "menu primary items=${primary.size} workmode=$workmode " +
                "names=${primary.take(6).joinToString(",") { it.name }}"
        }
        val out = primary.mapNotNull { row ->
            val second = HiMenu.parseSecondary(
                row.name,
                http.getText("$base/getsecondmenuitem.cgi?-workmode=$wp&-name=${param(row.name)}"),
            )
            if (second == null) {
                // The camera answered `SvrFuncResult="-2222"`. Listing such an
                // item gives the user a dead row that cannot be read or written —
                // unless the primary listing already said it has no value, which is
                // what an action row looks like from here.
                if (!row.isAction) {
                    Diag.w(LogTag.PARSE) { "menu item \"${row.name}\" rejected by the camera — dropped" }
                    return@mapNotNull null
                }
                Diag.d(LogTag.PARSE) { "menu row \"${row.name}\" is an action (no value) — listed as a button" }
                return@mapNotNull CameraSetting(id = row.name, title = row.name, value = "")
            }
            // Prefer the item's own answer; the primary list is positional and
            // can be off by one when a name or a value contains a comma.
            val value = second.value.ifEmpty { row.value }
            Diag.v(LogTag.PARSE) { "menu item \"${row.name}\" options=${second.options.size} cur=$value" }
            CameraSetting(id = row.name, title = row.name, value = value, options = second.options)
        }
        nameCache[session.host] = out.map { it.id }
        Diag.i(LogTag.PROTO) { "menu read ${out.size}/${primary.size} items for \"$workmode\"" }
        return out
    }

    /** The menu item names the last successful [getSettings] returned, per host. */
    private val menuCache = mutableMapOf<String, List<String>>()

    /**
     * The device's own settings — the menu that is not a function of the shooting
     * mode. The official app reads it as `getprimarymenuitem.cgi?-workmode=System`
     * (`SSDeviceSettingActivity.java:48`'s `curMode = "System"`, sent by
     * `SetDataUtils.getDeviceSetData`), and writes it with the same
     * `setcurparameter.cgi` under the same pseudo-mode.
     *
     * Which items appear is a firmware property — the official table knows
     * `Inversion Mode, Date Stamp, Brand Stamp, Key Tone, Cap Tone, Power Tone,
     * Remote Control, Face Detection, Grid, Auto Sync Time, Voice Control,
     * Time Stamp, Wi-Fi, SD Format, Factory Reset, Information, Time Set, FLIP,
     * WiFi Frequency`, and a camera shows a subset of that — so whatever the camera
     * lists is rendered as it comes back, never filtered against this list.
     */
    override suspend fun getDeviceSettings(session: CameraSession): List<CameraSetting> {
        if (!session.newApp()) {
            Diag.w(LogTag.PROTO) { "getDeviceSettings skipped: this firmware has no System menu (legacy getters only)" }
            return emptyList()
        }
        return readMenu(session, HiModes.SYSTEM_WORKMODE, deviceMenuCache)
    }

    /** Write one row of [getDeviceSettings]: [setSetting]'s request with `-workmode=System`. */
    override suspend fun setDeviceSetting(session: CameraSession, id: String, value: String): CmdResult {
        if (!session.newApp()) {
            return CmdResult.Failure("This firmware has no System device menu — use the per-mode settings")
        }
        val known = deviceMenuCache[session.host]
        if (known != null && known.isNotEmpty() && id !in known) {
            Diag.w(LogTag.PROTO) { "setDeviceSetting \"$id\" not in the System menu (${known.joinToString(",")}) — refused" }
            return CmdResult.Failure("\"$id\" is not a device setting")
        }
        return setParameter(session, HiModes.SYSTEM_WORKMODE, id, value, "device setting")
    }

    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult {
        val base = cgi(session.host, session.port)
        if (session.newApp()) {
            // A menu name the primary listing never returned is the one failure we can
            // catch before sending it: the firmware answers such names with -2222.
            val known = menuCache[session.host]
            if (known != null && known.isNotEmpty() && id !in known) {
                Diag.w(LogTag.PROTO) { "setSetting \"$id\" not in the current menu (${known.joinToString(",")}) — refused" }
                return CmdResult.Failure("\"$id\" is not a setting of the current mode")
            }
            return setParameter(session, currentStrMode(session), id, value, "setting")
        }
        val ls = legacySettings.firstOrNull { it.id == id }
            ?: return CmdResult.Failure("Unknown setting $id")
        val url = "$base/" + ls.setCmd.replace("%s", value)
        Diag.d(LogTag.PROTO) {
            "setSetting via ${ls.setCmd.substringBefore('?')} value=${LogFormat.settingValue(id, value, Diag.config.captureSecrets)}"
        }
        val r = http.getText(url)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> CmdResult.Ok
            is CgiReply.Rejected -> refuse("set $id", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("set $id failed (no answer from ${LogFormat.endpointKey(url)})")
        }
    }

    /**
     * One `setcurparameter.cgi` write, addressed by [workmode] — the shooting mode's
     * name for [setSetting], [HiModes.SYSTEM_WORKMODE] for [setDeviceSetting].
     */
    private suspend fun setParameter(
        session: CameraSession,
        workmode: String,
        id: String,
        value: String,
        kind: String,
    ): CmdResult {
        val url = "${cgi(session.host, session.port)}/setcurparameter.cgi?-workmode=${param(workmode)}" +
            "&-name=${param(id)}&-value=${param(value)}"
        Diag.d(LogTag.PROTO) {
            "set$kind via setcurparameter workmode=$workmode name=$id " +
                "value=${LogFormat.settingValue(id, value, Diag.config.captureSecrets)}"
        }
        val r = http.getText(url)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> CmdResult.Ok
            is CgiReply.Rejected -> refuse("set $id", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("set $id failed (no answer from setcurparameter.cgi)")
        }
    }

    /**
     * Read back one menu item after a write, so the row shows what the firmware
     * actually holds instead of what we asked for. Deliberately a single request:
     * re-running [getSettings] costs one `getsecondmenuitem` per item, and the
     * 2026-09-21 S7PRO log shows six of those full walks burning 234 requests
     * during a three-minute session that also had to serve the live view.
     *
     * The item may come from either menu, and `-workmode=` has to name the one it
     * lives in or the camera answers `-2222` — hence the [deviceMenuCache] check
     * before falling back to the current shooting mode.
     */
    override suspend fun readBack(session: CameraSession, id: String): CameraSetting? {
        if (!session.newApp()) return null
        val base = cgi(session.host, session.port)
        val workmode = if (deviceMenuCache[session.host]?.contains(id) == true) {
            HiModes.SYSTEM_WORKMODE
        } else {
            currentStrMode(session)
        }
        val item = HiMenu.parseSecondary(
            id,
            http.getText("$base/getsecondmenuitem.cgi?-workmode=${param(workmode)}&-name=${param(id)}"),
        ) ?: return null
        return CameraSetting(id = item.name, title = item.name, value = item.value, options = item.options)
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
        val type = HiFiles.typeOf(path)
        // Every file on this protocol has a `.THM` sibling — video *and* photo — and
        // the original is never an acceptable preview URL: see [HiFiles.thumbnailPath].
        val thumbPath = HiFiles.thumbnailPath(path)
        return RemoteFile(
            name = path,
            type = type,
            sizeBytes = size,
            downloadUrl = "$host/$path",
            thumbnailUrl = thumbPath?.let { "$host/$it" },
            dateMillis = HiFiles.parseCreate(create),
        )
    }

    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult {
        // An answered CGI is not an accepted command: this camera answers a refusal
        // with HTTP 200 and `SvrFuncResult` in the body, which the old `r != null`
        // test reported to the user as "deleted".
        //
        // The name is encoded (`sd/DCIM/100XTUDV/NORM0011.MP4` → `sd%2FDCIM%2F…`),
        // which the official app does NOT do (`RemoteFileManager.deleteFile` interpolates
        // the path raw). thttpd percent-decodes query values, so both should reach the
        // firmware as the same name, and only the encoded one survives a name with a
        // space or a comma in it. If deletions start failing on a new firmware, this is
        // the first thing to test against the camera.
        val url = "${cgi(session.host, session.port)}/deletefile.cgi?&-name=${param(file.name)}"
        Diag.d(LogTag.PROTO) { "delete ${LogFormat.safe(file.name)} -> $url" }
        val r = http.getText(url)
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> CmdResult.Ok
            is CgiReply.Rejected -> refuse("delete ${file.name.substringAfterLast('/')}", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("delete failed (deletefile.cgi did not answer)")
        }
    }

    /**
     * The card's `.THM` preview, capped at [MAX_THUMBNAIL_BYTES].
     *
     * There is deliberately no fallback to `file.downloadUrl`: an old one made every
     * file whose `.THM` was missing request its original — a 1.2 GB clip or a 48 MP
     * JPEG — into a grid cell. Null means "no preview", and the UI shows a placeholder.
     */
    override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? {
        val url = file.thumbnailUrl
        if (url == null) {
            Diag.d(LogTag.PROTO) { "no thumbnail for ${LogFormat.safe(file.name)}: the card has no .THM sibling" }
            return null
        }
        return http.getBytes(url, MAX_THUMBNAIL_BYTES)
    }

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

    override suspend fun formatSd(session: CameraSession): CmdResult = maintenance.formatSd(session)

    override suspend fun factoryReset(session: CameraSession): CmdResult {
        val r = http.getText("${cgi(session.host, session.port)}/reset.cgi")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("factory reset failed")
    }

    override suspend fun reboot(session: CameraSession): CmdResult =
        CmdResult.Failure("Reboot is not supported on this camera")

    override suspend fun syncTime(session: CameraSession): CmdResult = maintenance.syncTime(session)

    override suspend fun setWifi(session: CameraSession, ssid: String, password: String): CmdResult =
        maintenance.setWifi(session, ssid, password)
}
