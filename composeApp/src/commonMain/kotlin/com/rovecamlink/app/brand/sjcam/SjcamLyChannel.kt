package com.rovecamlink.app.brand.sjcam

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.SdCardState
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import okio.Path

/**
 * Novatek ("Ly") channel — the family most of the brand ships on.
 *
 * Wire facts, all from `docs/evidence/sjcam.md` §4.1:
 *  - control: `http://192.168.1.254/?custom=1&cmd=<id>[&par=][&str=]`, parameters appended in
 *    `cmd`→`par`→`str` order (the vendor builds them from a `TreeMap`, `LYCamera.java:1850-1887`);
 *  - replies are `<Function><Cmd>…</Cmd><Status>…</Status><Value>…</Value><Total>/<Free>…</Function>`
 *    pseudo-XML read tag-by-tag (`LyDataPack`, `LYCamera.java:1888-1988`);
 *  - `cmd=3014` answers **one `<Cmd>`/`<Status>` pair per setting**, i.e. the current settings
 *    dictionary; writing a setting is the same id with `&par=<value>` (`LYCamera.java:1814-1840`);
 *  - the file browser is the camera's **HTML directory index** scraped with Jsoup
 *    (`/DCIM/<MOVIE|PHOTO|EVENT>/`, `LYCameraFileList.java:46-136`) — this channel does the same
 *    with a regex over the `tr/td` rows the vendor's own selector reads.
 *
 * The command ids live in `LYCamera.LyCmd` (`LYCamera.java:140-164`); the label table below
 * reuses the ids named in `M20CDCamera.M20Cmd` (`M20CDCamera.java:176-189`) — the rest of the
 * id space is only known numerically, so those rows show as `配置项 <id>` until a real camera
 * or a per-model params file fills them in (archive §6).
 */
internal class SjcamLyChannel(private val http: CameraHttp) : SjcamChannel {

    override val id = ID
    override val displayName = "SJCAM Ly (Novatek)"

    /** `LYCamera.java:73,97-98` — one control base, one photo-mode stream port, one RTSP path. */
    private val base get() = "http://192.168.1.254/?custom=1"

    private object Ly {
        const val CAPTURE = 1001
        const val RECORD = 2001
        const val RECORD_TIME = 2016
        const val SET_DATA = 3005
        const val SET_DATA_TIME = 3006
        const val SHUTDOWN = 3007
        const val FORMAT_SD = 3010
        const val RESET = 3011
        const val GET_VERSION = 3012
        const val ALL_SETTINGS = 3014
        const val GET_MODEL = 3016
        const val DISK_SPACE = 3017
        const val BATTERY = 3019
        const val MODE_CHANGE = 3001
        const val DELETE_FILE = 4003
    }

    private fun url(cmd: Int, par: String? = null, str: String? = null): String = buildString {
        append(base).append("&cmd=").append(cmd)
        if (par != null) append("&par=").append(par)
        if (str != null) append("&str=").append(str)
    }

    // ---------- probe / connect ----------

    /**
     * The reply to `cmd=3012` (firmware/model string) is the claim ticket.
     *
     * The wire dialect alone must not be the test: iCatch's dash cams answer the same
     * `?custom=1&cmd=` vocabulary (`docs/evidence/idgolive` appendix B), so a probe that
     * accepted any `<Function>` body would steal them and drive them with SJCAM's ids.
     * What separates the two is the model vocabulary — SJCAM's Novatek models report
     * `<芯片号>-<型号>` strings (`660-SJ10X`, `683-SJ9`, …; archive §2.1(b)).
     */
    override suspend fun probe(host: String, port: Int): Boolean {
        val body = http.getText("http://$host:$port/?custom=1&cmd=${Ly.GET_VERSION}")
        val model = modelOf(body)
        val verdict = model != null && looksLikeSjcamModel(model)
        Diag.d(LogTag.PROTO) { "sjcam-ly probe $host:$port -> $verdict model=${LogFormat.safe(model)}" }
        return verdict
    }

    override suspend fun connect(host: String, port: Int): CameraSession? {
        val body = http.getText("http://$host:$port/?custom=1&cmd=${Ly.GET_VERSION}")
        val model = modelOf(body)?.takeIf { looksLikeSjcamModel(it) } ?: return null
        // Mode is carried in the session extras because previewUrl() has to choose between
        // the RTSP stream (video modes) and the :8192 stream (photo modes) — the split the
        // official app makes in `mVideoUrl` (`LYCamera.java:615,810,868`).
        val modeCode = tag(http.getText(urlOn(host, port, Ly.GET_MODEL)), "Status")?.toIntOrNull()
        Diag.i(LogTag.PROTO) { "sjcam-ly connect model=${LogFormat.safe(model)} mode=$modeCode" }
        return newSession(host, port, model, mapOf(EXTRA_MODE to (modeCode?.toString() ?: "")))
    }

    private fun urlOn(host: String, port: Int, cmd: Int): String = "http://$host:$port/?custom=1&cmd=$cmd"

    // ---------- status ----------

    override suspend fun status(session: CameraSession): DeviceStatus {
        val battery = tag(http.getText(urlOn(session.host, session.port, Ly.BATTERY)), "Value")?.toIntOrNull()
        val sdBody = http.getText(urlOn(session.host, session.port, Ly.DISK_SPACE))
        val modeBody = http.getText(urlOn(session.host, session.port, Ly.GET_MODEL))
        val recordBody = http.getText(urlOn(session.host, session.port, Ly.RECORD_TIME))
        val modeCode = tag(modeBody, "Status")?.toIntOrNull()
        val recordTime = tag(recordBody, "Value")?.toIntOrNull()
        val sdStatus = tag(sdBody, "Status")?.toIntOrNull()
        Diag.d(LogTag.PARSE) {
            "sjcam-ly status battery=$battery sdStatus=$sdStatus mode=$modeCode recordTime=$recordTime"
        }
        return DeviceStatus(
            battery = battery,
            recording = (recordTime ?: 0) > 0,
            mode = modeFamily(modeCode),
            modeName = modeCode?.toString(),
            sdTotalMb = tag(sdBody, "Total")?.toLongOrNull(),
            sdFreeMb = tag(sdBody, "Free")?.toLongOrNull(),
            // `3017`'s own status word: 1 = ready. The official client only checks it
            // non-empty (`LYCamera.java:1209-1212`), so anything non-1 is "not OK" here.
            sdState = when (sdStatus) {
                null -> null
                1 -> SdCardState.OK
                else -> SdCardState.ERROR
            },
            videoTimeSec = recordTime?.takeIf { it > 0 },
        )
    }

    /**
     * Mode codes seen in `3016`'s `<Status>` (`LYCamera.java:615,810,868`): 0/4/6 are the
     * photo side, 1/3/8/9/10/11 the video side; 2/5/7 are transient (mode switch, recording,
     * photo in flight) and map to no family.
     */
    private fun modeFamily(code: Int?): WorkMode? = when (code) {
        0, 4, 6 -> WorkMode.PHOTO
        1, 3, 8, 9, 10, 11 -> WorkMode.VIDEO
        else -> null
    }

    // ---------- settings ----------

    /**
     * One `cmd=3014` read answers every setting as `<Cmd>id</Cmd><Status>value</Status>` pairs.
     * Options are not known statically (the vendor ships a per-model params file), so each row
     * carries its value only and the UI renders it read-only until a real camera's list is
     * recorded — archive §6 item on params.
     */
    override suspend fun getSettings(session: CameraSession): List<CameraSetting> {
        val body = http.getText(urlOn(session.host, session.port, Ly.ALL_SETTINGS)) ?: return emptyList()
        val settings = settingsOf(body)
        Diag.d(LogTag.PARSE) { "sjcam-ly settings ${settings.size} rows (${settings.keys.joinToString(",")})" }
        return settings.entries
            // 3016/3019 are status probes the vendor's own map also carries; they are not
            // user settings and would render as two unlabelled numeric rows.
            .filterNot { it.key in setOf("2016", "3016", "3017", "3019") }
            .map { (k, v) -> CameraSetting(id = k, title = LY_LABELS[k] ?: "配置项 $k", value = v) }
    }

    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult {
        val body = http.getText("http://${session.host}:${session.port}/?custom=1&cmd=$id&par=${sjcamUrlEnc(value)}")
        // A write is judged by the same envelope the reads use: `<Status>` present means the
        // firmware answered; `Cmd` echoing back means it took the id. An empty/garbage body is
        // a failure, not a silent success (the TUWIN "any body = OK" mistake).
        val accepted = body != null && (tag(body, "Status") != null || body.contains("Success"))
        Diag.d(LogTag.PROTO) { "sjcam-ly set $id=$value -> ${if (accepted) "ok" else "fail"} (${LogFormat.bodyField(body, Diag.config.captureSecrets)})" }
        return if (accepted) CmdResult.Ok else CmdResult.Failure("相机拒绝了 $id 的写入")
    }

    // ---------- capture ----------

    /**
     * Mode switch is `cmd=3001&par=<mode code>` (`LYCamera.changeCameraModel`, `LYCamera.java:816`).
     * The per-model mode list is not static in the APK, so the coarse pair maps to the first
     * code of each side (photo 0 / video 1) — the codes the archive confirms for both families.
     */
    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult {
        val code = when (mode) {
            WorkMode.VIDEO -> "1"
            WorkMode.PHOTO -> "0"
            WorkMode.PLAYBACK -> "11" // 11 is the playback side in `take()`'s photo/video split
        }
        val body = http.getText("http://${session.host}:${session.port}/?custom=1&cmd=${Ly.MODE_CHANGE}&par=$code")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("模式切换无应答")
    }

    /** `take()`: photo side is `cmd=1001`, no parameters (`LYCamera.java:1011-1026`). */
    override suspend fun capture(session: CameraSession): CmdResult {
        val body = http.getText(urlOn(session.host, session.port, Ly.CAPTURE))
        return if (body != null) CmdResult.Ok else CmdResult.Failure("拍照无应答")
    }

    /** `take()`: `cmd=2001&par=1|0` (`LYCamera.java:1015-1021`). */
    override suspend fun record(session: CameraSession, start: Boolean): CmdResult {
        val body = http.getText("http://${session.host}:${session.port}/?custom=1&cmd=${Ly.RECORD}&par=${if (start) 1 else 0}")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("录像命令无应答")
    }

    // ---------- files ----------

    /**
     * The camera's own HTTP directory listing, one request per media type.
     *
     * Paths and the row shape come from `LYCameraFileList` (`:46-136`): `/DCIM/MOVIE/` for
     * videos, `/DCIM/PHOTO/` for stills, `/DCIM/EVENT/` for event clips; each row is
     * `<a href="…"><b>name</b></a>` followed by size and time cells. Downloads are plain
     * `HOST + href`. `.wav` (voice notes) and `raw` entries are skipped, as the official
     * parser does.
     */
    override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> {
        val all = buildList {
            addAll(listDir(session, "/DCIM/MOVIE/", FileType.VIDEO))
            addAll(listDir(session, "/DCIM/PHOTO/", FileType.PHOTO))
            addAll(listDir(session, "/DCIM/EVENT/", FileType.VIDEO))
        }
        Diag.d(LogTag.PARSE) { "sjcam-ly files ${all.size} (range asked $start..$end)" }
        // The HTML listing has no paging; the range is honoured locally so the UI's pager
        // still behaves.
        return all.drop(start).take((end - start + 1).coerceAtLeast(0))
    }

    private suspend fun listDir(session: CameraSession, dir: String, type: FileType): List<RemoteFile> {
        val body = http.getText("http://${session.host}:${session.port}$dir") ?: return emptyList()
        val rows = parseListing(body, session.host, session.port, type)
        Diag.d(LogTag.PARSE) { "sjcam-ly $dir -> ${rows.size} files (body=${body.length} chars)" }
        return rows
    }

    /**
     * `cmd=4003&par=<path>` (`LyCmd.DELETE_FILE`). The parameter shape is inferred from the
     * only call site (`setPar(...)` with the file's path, `LYCamera.java:1236-1248`); the
     * diagnostic log records the exact URL so a real camera can confirm it (archive §6).
     */
    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult {
        val path = file.downloadUrl.substringAfter("http://${session.host}:${session.port}")
        val body = http.getText("http://${session.host}:${session.port}/?custom=1&cmd=${Ly.DELETE_FILE}&par=${sjcamUrlEnc(path)}")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("删除无应答")
    }

    override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? =
        file.thumbnailUrl?.let { http.getBytes(it) }

    override suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long = http.download(file.downloadUrl, dest, alreadyHaveBytes, onProgress)

    /**
     * Video modes stream RTSP on 554, photo modes stream over HTTP on 8192
     * (`LYCamera.java:97-98` and the `mVideoUrl` split). The `xxx.mp4` path is the vendor's
     * own literal — the firmware ignores it and serves the live stream.
     */
    override fun previewUrl(session: CameraSession): String {
        val mode = session.extras[EXTRA_MODE]?.toIntOrNull()
        return if (modeFamily(mode) == WorkMode.PHOTO) {
            "http://${session.host}:8192"
        } else {
            "rtsp://${session.host}:554/xxx.mp4"
        }
    }

    override suspend fun getDeviceInfo(session: CameraSession): DeviceInfo? {
        val version = modelOf(http.getText(urlOn(session.host, session.port, Ly.GET_VERSION)))
        val mode = tag(http.getText(urlOn(session.host, session.port, Ly.GET_MODEL)), "Status")
        if (version == null) return null
        return DeviceInfo(
            name = version,
            model = version,
            softVersion = version,
            raw = buildMap {
                mode?.let { put("mode", it) }
            },
        )
    }

    override suspend fun formatSd(session: CameraSession): CmdResult {
        val body = http.getText("http://${session.host}:${session.port}/?custom=1&cmd=${Ly.FORMAT_SD}&par=1")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("格式化无应答")
    }

    /** `reSetCamera()` — bare string id `"3011"&par=1` (`LYCamera.java:1163`). */
    override suspend fun factoryReset(session: CameraSession): CmdResult {
        val body = http.getText("http://${session.host}:${session.port}/?custom=1&cmd=${Ly.RESET}&par=1")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("恢复出厂无应答")
    }

    /** `cmd=3005&str=yyyy-MM-dd` then `cmd=3006&str=HH:mm:ss` (`LYCamera.java:1477-1483`). */
    override suspend fun syncTime(session: CameraSession): CmdResult {
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val date = "${now.year}-${now.monthNumber.toString().padStart(2, '0')}-${now.dayOfMonth.toString().padStart(2, '0')}"
        val time = "${now.hour.toString().padStart(2, '0')}:${now.minute.toString().padStart(2, '0')}:${now.second.toString().padStart(2, '0')}"
        http.getText("http://${session.host}:${session.port}/?custom=1&cmd=${Ly.SET_DATA}&str=$date")
        val body = http.getText("http://${session.host}:${session.port}/?custom=1&cmd=${Ly.SET_DATA_TIME}&str=$time")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("对时无应答")
    }

    /**
     * `cmd=3007` is the brand's **power-off** (`M20Cmd.CMD_POWEROFF`, and the call site sends
     * `par=4`, or `6` on C400/SJ6Ultra, `LYCamera.java:884`). It is mapped to [CameraProtocol.sleep]
     * rather than reboot because the camera does not come back on its own.
     */
    override suspend fun sleep(session: CameraSession): CmdResult {
        val par = if (session.model.contains("C400") || session.model.contains("SJ6Ultra")) "6" else "4"
        val body = http.getText("http://${session.host}:${session.port}/?custom=1&cmd=${Ly.SHUTDOWN}&par=$par")
        return if (body != null) CmdResult.Ok else CmdResult.Failure("关机无应答")
    }

    companion object {
        const val ID = "ly"
        const val EXTRA_MODE = "sjcam.ly.mode"

        /** `<Value>` first — `3012` answers the model there on every build seen; `<String>` is the fallback. */
        internal fun modelOf(body: String?): String? =
            tag(body, "Value")?.takeIf { it.isNotBlank() }
                ?: tag(body, "String")?.takeIf { it.isNotBlank() }

        /**
         * Model vocabulary of the Novatek family (archive §2.1(b)): `<芯片号>-<型号>` or one of
         * the bare tokens the older models use.
         */
        internal fun looksLikeSjcamModel(model: String): Boolean {
            val m = model.trim()
            if (m.isEmpty()) return false
            if (Regex("^\\d{3}-").containsMatchIn(m)) return true
            val upper = m.uppercase()
            return listOf("SJ", "C100", "C200", "C300", "C400", "C110", "A10", "A20", "A30", "A50", "M10", "M20", "P500")
                .any { upper.contains(it) }
        }

        /** The `<Status>`/`<Value>`-per-`<Cmd>` dictionary `cmd=3014` answers with. */
        internal fun settingsOf(body: String?): Map<String, String> {
            if (body.isNullOrBlank()) return emptyMap()
            val out = LinkedHashMap<String, String>()
            for (block in Regex("<Function>(.*?)</Function>", RegexOption.DOT_MATCHES_ALL).findAll(body)) {
                val cmd = tag(block.value, "Cmd")?.takeIf { it.isNotBlank() } ?: continue
                val value = tag(block.value, "Status") ?: continue
                out[cmd.trim()] = value.trim()
            }
            if (out.isNotEmpty()) return out
            // Some builds answer the dictionary without <Function> wrappers: <Cmd>x</Cmd><Status>y</Status>…
            val cmds = Regex("<Cmd>(.*?)</Cmd>", RegexOption.DOT_MATCHES_ALL).findAll(body).map { it.groupValues[1] }.toList()
            val values = Regex("<Status>(.*?)</Status>", RegexOption.DOT_MATCHES_ALL).findAll(body).map { it.groupValues[1] }.toList()
            cmds.forEachIndexed { i, c -> values.getOrNull(i)?.let { out[c.trim()] = it.trim() } }
            return out
        }

        /** `<name>…</name>` extraction; the replies are XML-ish but not always well-formed. */
        internal fun tag(body: String?, name: String): String? {
            if (body == null) return null
            val open = "<$name>"
            val close = "</$name>"
            val a = body.indexOf(open)
            if (a < 0) return null
            val start = a + open.length
            val b = body.indexOf(close, start)
            return if (b < 0) null else body.substring(start, b)
        }

        /** `tr/td` rows of the directory listing; groups: href, name. */
        private val LY_ROW = Regex(
            "<a[^>]+href=\"([^\"]+)\"[^>]*>\\s*<b>([^<]+)</b>",
            RegexOption.IGNORE_CASE,
        )

        /** The size cell that follows the name in the vendor's own table shape. */
        private val LY_SIZE = Regex("<td[^>]*align\\s*=\\s*right[^>]*>\\s*([0-9]+)", RegexOption.IGNORE_CASE)

        /**
         * Parse one directory page into files. Pure, so a test can hold it to the vendor's
         * own table shape without a camera; `.wav`/`raw` entries are skipped exactly as
         * `LYCameraFileList.getFileListNew` does (`LYCameraFileList.java:110-133`).
         */
        internal fun parseListing(body: String?, host: String, port: Int, fallback: FileType): List<RemoteFile> {
            if (body.isNullOrBlank()) return emptyList()
            // One <tr> = one file. Sizes are read per row rather than as one global list, so a
            // header or `..` row cannot shift every following file's size (the vendor's own
            // selector walks rows for the same reason, `LYCameraFileList.java:96-120`).
            return body.split(Regex("<tr", RegexOption.IGNORE_CASE)).mapNotNull { row ->
                val m = LY_ROW.find(row) ?: return@mapNotNull null
                val href = m.groupValues[1]
                val name = m.groupValues[2].trim()
                if (name.isEmpty() || name == "..") return@mapNotNull null
                val lower = name.lowercase()
                if (lower.endsWith(".wav") || lower.endsWith("raw")) return@mapNotNull null
                val fileType = when {
                    lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png") -> FileType.PHOTO
                    lower.endsWith(".mp4") || lower.endsWith(".mov") || lower.endsWith(".avi") ||
                        lower.endsWith(".mkv") -> FileType.VIDEO
                    else -> fallback
                }
                RemoteFile(
                    name = name,
                    type = fileType,
                    sizeBytes = LY_SIZE.find(row)?.groupValues?.get(1)?.toLongOrNull() ?: 0L,
                    downloadUrl = "http://$host:$port$href",
                    // Stills can be shown straight from their own URL; the LY family exposes no
                    // separate thumbnail path in the listing (archive §6 keeps this open).
                    thumbnailUrl = if (fileType == FileType.PHOTO) "http://$host:$port$href" else null,
                )
            }
        }

        /**
         * Labels for the id space the APK names outright (`M20CDCamera.M20Cmd`,
         * `M20CDCamera.java:176-189`); anything else renders as its id.
         */
        private val LY_LABELS = mapOf(
            "1002" to "照片尺寸",
            "2002" to "录像分辨率",
            "2003" to "循环录像",
            "2004" to "HDR",
            "2005" to "曝光补偿",
            "2006" to "移动侦测",
            "2007" to "录音",
            "2008" to "日期水印",
            "2011" to "重力感应灵敏度",
            "2012" to "开机自动录像",
            "3008" to "语言",
            "3009" to "电视制式",
        )
    }
}
