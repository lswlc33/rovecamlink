package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.brand.xtu.HiVarParser.bool
import com.rovecamlink.app.brand.xtu.HiVarParser.int
import com.rovecamlink.app.brand.xtu.HiVarParser.long
import com.rovecamlink.app.brand.xtu.HiVarParser.mb
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
 *  - Preview: rtsp://<ip>:554/livestream/12 — the only path the official app ever
 *    builds (`SSCommandUtil.java:50`, `HaisiCommandUtil.java:50`); a "/11 = high
 *    bitrate" stream is folklore, that string appears nowhere in the APK. It also
 *    plays that URL over RTP/TCP, not UDP — see core.media.CameraPreview.
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
        menuCache.remove(session.host)
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

    override suspend fun capture(session: CameraSession): CmdResult {
        val base = cgi(session.host, session.port)
        val (state, modeName) = peekWorkState(session)
        if (state != null && state != STATE_STANDBY) {
            // Verified on an XTU S7PRO: `photo.cgi` while the camera is working does
            // not take a still — it reset the running recording instead, and no file
            // ever appeared (`getfilecount` stayed put all session).
            return CmdResult.Failure("Camera is busy (state $state) — wait for it to go idle before taking a photo")
        }
        val modes = workModeNames(session)
        if (session.newApp() && modes["photo"].orEmpty().isNotEmpty() &&
            modeName != null && modeName in modes["video"].orEmpty()
        ) {
            return CmdResult.Failure("Camera is in video mode \"$modeName\" — switch to a photo mode to take a picture")
        }
        // Two dialects were recovered from the official app: the legacy action table
        // sends `photo.cgi?&-type=photo`, the SigmaStar builder appends `-cmd=start`.
        // NewAPP firmware is the SigmaStar side of that split.
        val query = if (session.newApp()) "?-type=photo&-cmd=start" else "?&-type=photo"
        val r = http.getText("$base/photo.cgi$query")
        return when (val verdict = Cgi.verdict(r)) {
            is CgiReply.Accepted -> {
                Diag.i(LogTag.PROTO) { "photo.cgi accepted (mode=${modeName ?: "?"} state=${state ?: "?"})" }
                CmdResult.Ok
            }
            is CgiReply.Rejected -> refuse("photo.cgi", verdict)
            CgiReply.NoAnswer -> CmdResult.Failure("capture failed (no answer from photo.cgi)")
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
            // New-app menu: getprimarymenuitem -> item/cur lists; getsecondmenuitem -> allowed values.
            // Read the mode live, because which items exist is a property of the mode.
            val modeName = currentStrMode(session, refresh = true)
            val workmode = param(modeName)
            val primary = HiMenu.parsePrimary(http.getText("$base/getprimarymenuitem.cgi?-workmode=$workmode"))
            Diag.d(LogTag.PROTO) {
                "menu primary items=${primary.size} workmode=$modeName " +
                    "names=${primary.take(6).joinToString(",") { it.first }}"
            }
            if (primary.isNotEmpty()) {
                val out = primary.mapNotNull { (name, listed) ->
                    val second = HiMenu.parseSecondary(
                        name,
                        http.getText("$base/getsecondmenuitem.cgi?-workmode=$workmode&-name=${param(name)}"),
                    )
                    if (second == null) {
                        // The camera answered `SvrFuncResult="-2222"`. Listing such an
                        // item gives the user a dead row that cannot be read or written.
                        Diag.w(LogTag.PARSE) { "menu item \"$name\" rejected by the camera — dropped" }
                        return@mapNotNull null
                    }
                    // Prefer the item's own answer; the primary list is positional and
                    // can be off by one when a name or a value contains a comma.
                    val value = second.value.ifEmpty { listed }
                    Diag.v(LogTag.PARSE) { "menu item \"$name\" options=${second.options.size} cur=$value" }
                    CameraSetting(id = name, title = name, value = value, options = second.options)
                }
                menuCache[session.host] = out.map { it.id }
                Diag.i(LogTag.PROTO) { "menu read ${out.size}/${primary.size} items for \"$modeName\"" }
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

    /** The menu item names the last successful [getSettings] returned, per host. */
    private val menuCache = mutableMapOf<String, List<String>>()

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
            val url = "$base/setcurparameter.cgi?-workmode=${param(currentStrMode(session))}" +
                "&-name=${param(id)}&-value=${param(value)}"
            Diag.d(LogTag.PROTO) {
                "setSetting via setcurparameter name=$id value=${LogFormat.settingValue(id, value, Diag.config.captureSecrets)}"
            }
            val r = http.getText(url)
            return when (val verdict = Cgi.verdict(r)) {
                is CgiReply.Accepted -> CmdResult.Ok
                is CgiReply.Rejected -> refuse("set $id", verdict)
                CgiReply.NoAnswer -> CmdResult.Failure("set $id failed (no answer from setcurparameter.cgi)")
            }
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
     * Read back one menu item after a write, so the row shows what the firmware
     * actually holds instead of what we asked for. Deliberately a single request:
     * re-running [getSettings] costs one `getsecondmenuitem` per item, and the
     * 2026-09-21 S7PRO log shows six of those full walks burning 234 requests
     * during a three-minute session that also had to serve the live view.
     */
    override suspend fun readBack(session: CameraSession, id: String): CameraSetting? {
        if (!session.newApp()) return null
        val base = cgi(session.host, session.port)
        val item = HiMenu.parseSecondary(
            id,
            http.getText("$base/getsecondmenuitem.cgi?-workmode=${param(currentStrMode(session))}&-name=${param(id)}"),
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
