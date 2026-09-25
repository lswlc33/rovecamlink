package com.rovecamlink.app.brand.icatch

import com.rovecamlink.app.brand.xtu.HiFiles
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
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
import com.rovecamlink.app.core.protocol.CameraProtocol
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import okio.Path

/**
 * iCatch-family HTTP profiles from the idGoLive app (package `com.id221.golive`,
 * Java namespace `com.icatch.golive`) — the dash-cam / white-label branch of the
 * iCatchTek lineup (优达尔 and the other ODM badges). Evidence:
 * `docs/08-官方APK全量逆向档案/03-idGoLive-档案.md` + its appendix B command tables.
 *
 * The idGoLive app is really three transports. This plugin implements the two plain
 * HTTP ones and deliberately leaves the third alone:
 *
 * - **LyIC** (`profile = "ly"`) — Novatek-style `?custom=1&cmd=NNNN&par=|str=` on
 *   `192.168.1.254`, XML answers, plus an XML-over-TCP:3333 push channel we do not
 *   implement (polling covers what the UI needs; see the design doc §1).
 * - **QzIC / YzIC** (`profile = "qz"`) — `/app/…` JSON `{result, info}` on
 *   `192.168.169.1`.
 * - **PTP/IP** (`192.168.1.1`) — the whole stack lives in `libcontrol.so` and the
 *   port is statically unknowable (archive §3.5); it needs a real device. Not here.
 *
 * **One plugin, two profiles.** The registry is keyed by platform, so both families
 * share `ICATCH` and ride one implementation; `connect` stamps which profile the
 * probe matched into `session.extras["profile"]` and every method dispatches on it.
 *
 * **No SSID prefixes, no fixed host.** The official app has no SSID vocabulary at all
 * (archive §3.2 — identity is just "whatever SSID the phone is on"), and its two
 * families answer on *different* gateway IPs, so claiming a fixed host here would
 * misroute the other family. Discovery walks the candidate list and the probe below
 * claims the device; that is the "no model table, probe-routed" fallback docs/03 §12
 * asks for.
 *
 * Success criteria: QzIC write endpoints answer `{"result":0}` and are judged by
 * [QzJson.accepted] (same shape as the TUWIN envelope); LyIC write endpoints are
 * fire-and-forget in the official client (`ApiCaller` bodies are never parsed), so a
 * 2xx with a body is Ok — the same "weak verdict" the hi3510 plugin documents for its
 * `deletefile.cgi` family. LyIC *reads* must parse their target tag to count.
 */
class IcatchHttpProtocol(private val http: CameraHttp) : CameraProtocol {

    override val platform = DevicePlatform.ICATCH

    override val wifiSsidPrefixes: List<String> = emptyList()
    override val fixedHost: String? = null
    override val defaultWifiPassword: String? = null

    override val supportsReboot: Boolean get() = false

    private val _events = MutableSharedFlow<DeviceEvent>(extraBufferCapacity = 8)
    override val events: Flow<DeviceEvent> = _events

    // ---------- probe / connect ----------

    /**
     * Ly first: on a `.254` device that also serves `/app/…` (the combination the
     * official `LyCmdWithYzIC` class exists for but never selects), the official app
     * still speaks Novatek, so the probe order mirrors that precedent.
     */
    override suspend fun probe(host: String, port: Int): Boolean {
        val ly = probeLy(host, port)
        if (ly) return true
        return probeQz(host, port)
    }

    private suspend fun probeLy(host: String, port: Int): Boolean {
        val body = http.getText("http://$host:$port/?custom=1&cmd=3029")
        val verdict = body != null && body.contains("<SSID", ignoreCase = true)
        Diag.d(LogTag.PROTO) { "icatch-ly probe $host:$port -> $verdict" }
        return verdict
    }

    private suspend fun probeQz(host: String, port: Int): Boolean {
        val body = http.getText("http://$host:$port/app/getdeviceattr")
        // The official getSSID reads `info.ssid` (QzIC.java:389-402); require both keys
        // so a TUWIN-style {status:…} JSON on the same path cannot be claimed by mistake.
        val verdict = body != null && body.contains("\"result\"") && body.contains("ssid", ignoreCase = true)
        Diag.d(LogTag.PROTO) { "icatch-qz probe $host:$port -> $verdict" }
        return verdict
    }

    override suspend fun connect(host: String, port: Int): CameraSession {
        val lyBody = http.getText("http://$host:$port/?custom=1&cmd=3029")
        if (lyBody != null && lyBody.contains("<SSID", ignoreCase = true)) {
            val ssid = LyXml.firstTag(lyBody, "SSID")
            val passphrase = LyXml.firstTag(lyBody, "PASSPHRASE")
            return Diag.inOp("icatch-ly-connect", "target=$host:$port") {
                // The official connect opens the RTSP secondary stream right after the
                // handshake (cmd=2015&par=1, RequestInfo.java:44) so the player has a
                // feed before the user reaches the live page. Best-effort here too.
                http.getText("http://$host:$port/?custom=1&cmd=2015&par=1")
                Diag.i(LogTag.PROTO) { "icatch ly connect ssid=${LogFormat.safe(ssid)} has_pwd=${passphrase != null}" }
                CameraSession(
                    host = host, port = port, platform = platform, brand = Brand.ICATCH,
                    model = ssid ?: "iCatch Ly",
                    extras = mapOf(EXTRA_PROFILE to PROFILE_LY),
                )
            }
        }
        val attrBody = http.getText("http://$host:$port/app/getdeviceattr")
        val info = QzJson.infoObject(attrBody)
        val ssid = info?.stringKey("ssid")
        return Diag.inOp("icatch-qz-connect", "target=$host:$port") {
            Diag.i(LogTag.PROTO) { "icatch qz connect ssid=${LogFormat.safe(ssid)}" }
            CameraSession(
                host = host, port = port, platform = platform, brand = Brand.ICATCH,
                model = ssid ?: "iCatch Qz",
                extras = mapOf(EXTRA_PROFILE to PROFILE_QZ),
            )
        }
    }

    private fun profile(session: CameraSession): String =
        session.extras[EXTRA_PROFILE] ?: PROFILE_LY

    private fun isLy(session: CameraSession): Boolean = profile(session) == PROFILE_LY

    // ---------- status ----------

    override suspend fun getStatus(session: CameraSession): DeviceStatus =
        if (isLy(session)) lyStatus(session) else qzStatus(session)

    private suspend fun lyStatus(session: CameraSession): DeviceStatus {
        val base = "http://${session.host}:${session.port}/?custom=1"
        val battery = LyXml.firstTag(http.getText("$base&cmd=8013"), "Value")?.toIntOrNull()
        val freeSpaceMb = LyXml.firstTag(http.getText("$base&cmd=3017"), "Value")?.toLongOrNull()
        val cardState = LyXml.firstTag(http.getText("$base&cmd=3024"), "Value")
        // cmd=2016's Value is seconds recorded on the current clip (LyIC.getRecDuration
        // parses it with TimeTools.stringToInt); > 0 means recording.
        val recSec = LyXml.firstTag(http.getText("$base&cmd=2016"), "Value")?.toIntOrNull()
        val recording = (recSec ?: 0) > 0
        return DeviceStatus(
            battery = battery?.takeIf { it in 0..100 },
            recording = recording,
            busy = recording,
            videoTimeSec = recSec,
            sdFreeMb = freeSpaceMb,
            sdState = cardState?.let { SdCardState.fromRaw(it) },
            raw = mapOf("sdstate" to (cardState ?: "")),
        )
    }

    private suspend fun qzStatus(session: CameraSession): DeviceStatus {
        val base = session.baseUrl
        // `param=rec` is the official app's heartbeat endpoint (4000 ms, QzIC.java:239);
        // its `info.value` is 1 while recording.
        val recBody = http.getText("$base/app/getparamvalue?param=rec")
        val recValue = QzJson.infoObject(recBody)?.stringKey("value")
        val recording = recValue == "1" || recValue?.toIntOrNull() == 1
        val sdBody = http.getText("$base/app/getsdinfo")
        val sd = QzJson.infoObject(sdBody)
        val sdStatus = sd?.stringKey("status")
        return DeviceStatus(
            recording = recording,
            busy = recording,
            sdFreeMb = sd?.longKey("freespace") ?: sd?.longKey("free"),
            sdTotalMb = sd?.longKey("totalspace") ?: sd?.longKey("total"),
            sdState = sdStatus?.let { SdCardState.fromRaw(it) },
            raw = mapOf(
                "rec" to (recValue ?: ""),
                "sdstatus" to (sdStatus ?: ""),
            ),
        )
    }

    // ---------- modes / capture / record ----------

    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult =
        if (isLy(session)) {
            val par = when (mode) {
                WorkMode.PHOTO -> 0
                WorkMode.VIDEO -> 1
                WorkMode.PLAYBACK -> 2
            }
            if (lyCmd(session, "3001", par = par)) CmdResult.Ok
            else CmdResult.Failure("setmode failed")
        } else {
            val path = when (mode) {
                WorkMode.VIDEO -> "/app/enterrecorder"
                WorkMode.PLAYBACK -> "/app/playback?param=enter"
                WorkMode.PHOTO -> "/app/setting?param=enter"
            }
            if (qzPost(session, path)) CmdResult.Ok else CmdResult.Failure("setmode failed")
        }

    override suspend fun capture(session: CameraSession): CmdResult =
        if (isLy(session)) {
            if (lyCmd(session, "2017")) CmdResult.Ok else CmdResult.Failure("capture failed")
        } else {
            if (qzPost(session, "/app/snapshot")) CmdResult.Ok else CmdResult.Failure("capture failed")
        }

    override suspend fun record(session: CameraSession, start: Boolean): CmdResult {
        val ok = if (isLy(session)) {
            // Official sequence: opening the live/secondary stream gates the recorder —
            // ready2CamLive sends 3001&par=1 → 2015&par=1 → 2001&par=1, and stopMovieRecord
            // ends the clip before closing the stream (2001&par=0 → 2015&par=0).
            if (start) lyCmd(session, "2015", par = 1) && lyCmd(session, "2001", par = 1)
            else lyCmd(session, "2001", par = 0) && lyCmd(session, "2015", par = 0)
        } else {
            if (start) {
                qzPost(session, "/app/enterrecorder") &&
                    qzPost(session, "/app/setparamvalue?param=rec&value=1")
            } else {
                qzPost(session, "/app/setparamvalue?param=rec&value=0") &&
                    qzPost(session, "/app/setting?param=enter")
            }
        }
        if (!ok) return CmdResult.Failure("record failed")
        _events.tryEmit(DeviceEvent.RecordingChanged(start))
        return CmdResult.Ok
    }

    // ---------- settings ----------

    override suspend fun getSettings(session: CameraSession): List<CameraSetting> =
        if (isLy(session)) lySettings(session) else qzSettings(session)

    private suspend fun lySettings(session: CameraSession): List<CameraSetting> {
        val base = "http://${session.host}:${session.port}/?custom=1"
        // cmd=3014 answers the current value of every requested setting as
        // <Cmd>NNNN</Cmd><Status>value</Status> pairs — one request instead of eight.
        val statusPairs = LyXml.cmdStatusPairs(http.getText("$base&cmd=3014"))
        // cmd=3031&str=all lets the firmware redefine the choice set of
        // 2003/2011/8010/8011 (the official app overwrites its tables with this answer).
        val menu3031 = LyXml.menuItems(http.getText("$base&cmd=3031&str=all"))
        // cmd=3030 returns the recording-resolution capability indices (Item Index list);
        // intersect with the §8.1 table like handleList3030 does.
        val resIndices3030 = LyXml.indices(http.getText("$base&cmd=3030")).toSet()

        return IcatchSettings.LY_ITEMS.mapNotNull { item ->
            val options: List<IcatchSettings.Option> = when {
                item.cmd == "2002" ->
                    if (resIndices3030.isEmpty()) IcatchSettings.VIDEO_RESOLUTIONS
                    else IcatchSettings.VIDEO_RESOLUTIONS.filter { it.value in resIndices3030 }
                item.cmd in IcatchSettings.MENU_OVERRIDABLE -> {
                    val ids = menu3031[item.cmd].orEmpty()
                    if (ids.isEmpty()) item.options()
                    else ids.mapNotNull { triple ->
                        item.options().firstOrNull { it.value == triple.id }
                            ?.copy(value = triple.index)
                            ?: IcatchSettings.Option(value = triple.index, label = triple.id)
                    }
                }
                else -> item.options()
            }
            val current = statusPairs[item.cmd] ?: return@mapNotNull null
            CameraSetting(
                id = item.cmd,
                title = item.title,
                value = current,
                options = options.map { CameraSetting.Option(it.value, it.label) },
            )
        }
    }

    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult =
        if (isLy(session)) {
            // `id` is the wire cmd. 2002 rides `cmd=2002&par=`, the rest are their own
            // cmd with a par value — same shape either way, and the official app commits
            // accumulated menu writes with cmd=3021, which we send after each write.
            val wrote = lyCmd(session, id, par = value.toIntOrNull())
            if (wrote) lyCmd(session, "3021")
            if (wrote) CmdResult.Ok else CmdResult.Failure("setparameter failed")
        } else {
            val r = http.getText("${session.baseUrl}/app/setparamvalue?param=${urlEnc(id)}&value=${urlEnc(value)}")
            if (QzJson.accepted(r)) CmdResult.Ok else CmdResult.Failure("setparamvalue failed")
        }

    private suspend fun qzSettings(session: CameraSession): List<CameraSetting> {
        val base = session.baseUrl
        // POST per the official client (M1RequestInfo declares both getparamitems and
        // getparamvalue as POSTs); the values reply is {info:{param:value,…}}.
        val values = QzJson.infoObject(http.postText("$base/app/getparamvalue?param=all"))
        val items = QzJson.paramItems(http.postText("$base/app/getparamitems?param=all"))
        val known = setOf("rec_resolution", "switchcam", "encodec", "rec")
        return values?.entries.orEmpty()
            .filter { (k, _) -> k !in known || k == "rec_resolution" }
            .mapNotNull { (key, value) ->
                val raw = (value as? JsonPrimitive)?.contentOrNull ?: value.toString()
                if (raw.isBlank()) return@mapNotNull null
                val options = items[key].orEmpty().map { CameraSetting.Option(it.value, it.label) }
                CameraSetting(
                    id = key,
                    title = key.replaceFirstChar { c -> c.uppercase() },
                    value = raw,
                    options = options,
                )
            }
    }

    // ---------- files ----------

    override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> =
        if (isLy(session)) lyListFiles(session) else qzListFiles(session, start, end)

    private suspend fun lyListFiles(session: CameraSession): List<RemoteFile> {
        val body = http.getText("http://${session.host}:${session.port}/?custom=1&cmd=3015") ?: return emptyList()
        return LyXml.fileList(body).mapNotNull { f ->
            if (f.name.isBlank() || f.fpath.isBlank()) return@mapNotNull null
            // The official client sorts by which directory the FPATH carries
            // (LyIC.getFileList, LyIC.java:205-211) and builds the media URL from the
            // last two backslash segments: http://<ip>/Novatek/<dir>/<name>
            // (FileInfo 6-arg ctor, FileInfo.java:52-55). Keep both rules verbatim.
            val segments = f.fpath.split('\\')
            val dir = segments.getOrNull(segments.size - 2) ?: return@mapNotNull null
            val name = segments.lastOrNull()?.ifEmpty { null } ?: return@mapNotNull null
            val mediaUrl = "http://${session.host}:${session.port}/Novatek/$dir/$name"
            val lower = f.fpath.lowercase()
            val type = when {
                lower.contains("/movie/") || lower.contains("/sos/") -> FileType.VIDEO
                lower.contains("/photo/") -> FileType.PHOTO
                name.endsWith(".mp4", true) || name.endsWith(".mov", true) ||
                    name.endsWith(".avi", true) -> FileType.VIDEO
                name.endsWith(".jpg", true) || name.endsWith(".jpeg", true) ||
                    name.endsWith(".png", true) -> FileType.PHOTO
                else -> FileType.UNKNOWN
            }
            RemoteFile(
                name = f.name.ifEmpty { name },
                type = type,
                sizeBytes = f.size,
                downloadUrl = mediaUrl,
                thumbnailUrl = "$mediaUrl?custom=1&cmd=4002",
                dateMillis = parseLyTime(f.time),
            )
        }
    }

    private suspend fun qzListFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> {
        val base = session.baseUrl
        // Two pages: loop = normal clips, event = photos. The official app fetches emr
        // (emergency) into a third tab; we fold it in as video, which is what it is.
        val bodies = listOf(
            http.getText("$base/app/getfilelist?folder=loop&start=$start&end=$end"),
            http.getText("$base/app/getfilelist?folder=event&start=$start&end=$end"),
            http.getText("$base/app/getfilelist?folder=emr&start=$start&end=$end"),
        )
        return bodies.flatMap { body -> QzJson.fileList(body) }.map { f ->
            val mediaUrl = "http://${session.host}:${session.port}:80/app/downloadfile?file=${urlEnc(f.name)}"
            val type = when (f.folder) {
                "loop", "emr" -> FileType.VIDEO
                "event" -> FileType.PHOTO
                else -> if (f.leafName.endsWith(".jpg", true) || f.leafName.endsWith(".jpeg", true)) {
                    FileType.PHOTO
                } else {
                    FileType.VIDEO
                }
            }
            RemoteFile(
                name = f.leafName,
                type = type,
                sizeBytes = f.sizeBytes,
                downloadUrl = mediaUrl,
                thumbnailUrl = "$base/app/getthumbnail?file=${urlEnc(f.name)}",
                dateMillis = f.createTime?.takeIf { it > 0 },
            )
        }
    }

    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult {
        val ok = if (isLy(session)) {
            // The device path is what cmd=4003 wants (str=<fpath>); RemoteFile only
            // carries the leaf name, so the URL we built for the thumbnail keeps the
            // original path — rebuild it from the media URL instead of guessing.
            val path = file.downloadUrl.substringAfter("/Novatek/", missingDelimiterValue = "")
            if (path.isEmpty()) return CmdResult.Failure("delete failed: no device path")
            lyCmdRaw(session, "4003", str = "/mnt/sdcard/$path".let { p -> p })
        } else {
            QzJson.accepted(http.getText("${session.baseUrl}/app/deletefile?file=${urlEnc(devicePathOf(session, file))}"))
        }
        return if (ok) CmdResult.Ok else CmdResult.Failure("delete failed")
    }

    override suspend fun deleteAllFiles(session: CameraSession): CmdResult =
        if (isLy(session)) {
            // The Novatek family has a real delete-all (cmd=4004, RequestInfo.java:15);
            // the UI owns the confirmation, exactly as with deleteallfiles.cgi upstream.
            if (lyCmd(session, "4004")) CmdResult.Ok
            else CmdResult.Failure("delete all failed")
        } else {
            CmdResult.Failure("This camera has no delete-all command")
        }

    override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? =
        http.getBytes(file.thumbnailUrl ?: return null)

    override suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long = http.download(file.downloadUrl, dest, alreadyHaveBytes, onProgress)

    // ---------- device info / maintenance ----------

    override suspend fun getDeviceInfo(session: CameraSession): DeviceInfo? =
        if (isLy(session)) {
            val base = "http://${session.host}:${session.port}/?custom=1"
            val fw = LyXml.firstTag(http.getText("$base&cmd=3012"), "Value")
                ?: LyXml.firstTag(http.getText("$base&cmd=3012"), "Version")
            val ssid = LyXml.firstTag(http.getText("$base&cmd=3029"), "SSID")
            DeviceInfo(
                name = ssid,
                softVersion = fw,
                raw = mapOf("profile" to PROFILE_LY),
            )
        } else {
            val base = session.baseUrl
            val product = QzJson.infoObject(http.getText("$base/app/getproductinfo?"))
            val attr = QzJson.infoObject(http.getText("$base/app/getdeviceattr"))
            val model = product?.firstOf("product", "model", "name", "device_name")
                ?: attr?.stringKey("ssid")
            DeviceInfo(
                name = attr?.stringKey("ssid"),
                model = model,
                softVersion = product?.firstOf("swver", "version", "softver"),
                hardVersion = product?.firstOf("hwver", "hardver"),
                serialNumber = product?.firstOf("uuid", "sn", "serial"),
                mac = product?.firstOf("mac") ?: attr?.stringKey("mac"),
                ssid = attr?.stringKey("ssid"),
                raw = buildMap {
                    put("profile", PROFILE_QZ)
                    // No putIfAbsent here: it is a JVM-only MutableMap extension, and
                    // this file is commonMain (the iOS target compile caught it).
                    product?.let { p ->
                        p.forEach { (k, v) ->
                            val key = "product.$k"
                            if (!containsKey(key)) put(key, v.toString())
                        }
                    }
                },
            )
        }

    override suspend fun formatSd(session: CameraSession): CmdResult {
        val ok = if (isLy(session)) lyCmd(session, "3010", par = 1)
        else QzJson.accepted(http.getText("${session.baseUrl}/app/sdformat"))
        return if (ok) CmdResult.Ok else CmdResult.Failure("format SD failed")
    }

    override suspend fun factoryReset(session: CameraSession): CmdResult {
        val ok = if (isLy(session)) lyCmd(session, "3011")
        else QzJson.accepted(http.getText("${session.baseUrl}/app/reset"))
        return if (ok) CmdResult.Ok else CmdResult.Failure("factory reset failed")
    }

    override suspend fun syncTime(session: CameraSession): CmdResult {
        val now = Clock.System.now()
        val ok = if (isLy(session)) {
            // Two independent requests in the official client (LyIC.syncLocalTime
            // inlines both, LyIC.java:392-393): date then time.
            val local = now.toString()
            val date = local.substringBefore('T')
            val time = local.substringAfter('T', "").substringBefore('.').ifEmpty { "00:00:00" }
            lyCmdRaw(session, "3005", str = date) && lyCmdRaw(session, "3006", str = time)
        } else {
            val ldt = now.toLocalDateTime(TimeZone.currentSystemDefault())
            val stamp = buildString {
                append(ldt.year)
                append(ldt.monthNumber.toString().padStart(2, '0'))
                append(ldt.dayOfMonth.toString().padStart(2, '0'))
                append(ldt.hour.toString().padStart(2, '0'))
                append(ldt.minute.toString().padStart(2, '0'))
                append(ldt.second.toString().padStart(2, '0'))
            }
            QzJson.accepted(http.getText("${session.baseUrl}/app/setsystime?date=$stamp"))
        }
        return if (ok) CmdResult.Ok else CmdResult.Failure("time sync failed")
    }

    override suspend fun setWifi(session: CameraSession, ssid: String, password: String): CmdResult {
        val ok = if (isLy(session)) {
            // 3003 = SSID, 3004 = passphrase, then 3018 makes the camera reconnect
            // (RequestInfo.java:53/58/59).
            lyCmdRaw(session, "3003", str = ssid) &&
                lyCmdRaw(session, "3004", str = password) &&
                lyCmd(session, "3018")
        } else {
            // Parameter names from the official settings page itself
            // (YdeviceSettingActivity.java:77-79: wifipwd= / wifissid=).
            QzJson.accepted(
                http.getText("${session.baseUrl}/app/setwifi?wifissid=${urlEnc(ssid)}"),
            ) && QzJson.accepted(
                http.getText("${session.baseUrl}/app/setwifi?wifipwd=${urlEnc(password)}"),
            ) && QzJson.accepted(http.getText("${session.baseUrl}/app/wifireboot"))
        }
        return if (ok) CmdResult.Ok else CmdResult.Failure("setwifi failed")
    }

    override fun previewUrl(session: CameraSession): String =
        // The official IC handlers return a bare rtsp://<ip> with no path and no port
        // (LyIC.java:168/220, QzIC.java:165); the player fills the rest. :554 is the
        // RTSP default; the full URL shape is archive open-question #11, to be
        // confirmed against a real device.
        "rtsp://${session.host}:554/"

    // ---------- transport helpers ----------

    /** `?custom=1&cmd=<cmd>&par=<par>` — the Novatek write/read shape. */
    private suspend fun lyCmd(session: CameraSession, cmd: String, par: Int? = null): Boolean {
        val suffix = if (par != null) "&par=$par" else ""
        return lyCmdRaw(session, cmd, suffix = suffix)
    }

    private suspend fun lyCmdRaw(
        session: CameraSession,
        cmd: String,
        str: String? = null,
        suffix: String = "",
    ): Boolean {
        val url = buildString {
            append("http://${session.host}:${session.port}/?custom=1&cmd=$cmd")
            append(suffix)
            if (str != null) append("&str=${urlEnc(str)}")
        }
        val body = http.getText(url)
        // Fire-and-forget upstream: ApiCaller never parses these bodies, so "2xx with a
        // body" is the whole verdict. Reads go through LyXml and must parse to count.
        val ok = !body.isNullOrBlank()
        Diag.d(LogTag.PROTO) { "ly cmd=$cmd${if (suffix.isEmpty() && str == null) "" else " args"} -> ${if (ok) "ok" else "no answer"}" }
        return ok
    }

    private suspend fun qzPost(session: CameraSession, path: String): Boolean =
        QzJson.accepted(http.postText("${session.baseUrl}$path"))

    private fun devicePathOf(session: CameraSession, file: RemoteFile): String {
        // The Qz file list's `name` field is the full device path; our RemoteFile keeps
        // only the leaf. The thumbnail URL preserved it verbatim after `file=`.
        val fromThumb = file.thumbnailUrl?.substringAfter("file=", missingDelimiterValue = "")
        if (!fromThumb.isNullOrEmpty()) return urlDecode(fromThumb)
        return file.name
    }

    // ---------- small helpers ----------

    private fun parseLyTime(raw: String): Long? =
        // `TIME` is a bare yyyyMMddHHmmss-ish stamp in the 3015 reply; the same digits
        // shape the hi3510 file list answers with, so reuse its parser instead of a
        // second one (and stay off java.util.Calendar, which is JVM-only).
        HiFiles.parseCreate(raw)

    private val HEX = "0123456789ABCDEF".toCharArray()

    private fun urlEnc(s: String): String = buildString(s.length) {
        for (byte in s.encodeToByteArray()) {
            val b = byte.toInt() and 0xFF
            val isUnreserved = b in 'a'.code..'z'.code || b in 'A'.code..'Z'.code ||
                b in '0'.code..'9'.code || b == '-'.code || b == '.'.code ||
                b == '_'.code || b == '~'.code
            if (isUnreserved) append(b.toChar()) else append("%").append(HEX[b shr 4]).append(HEX[b and 0x0F])
        }
    }

    private fun urlDecode(s: String): String = buildString {
        var i = 0
        val bytes = mutableListOf<Byte>()
        fun flush() {
            if (bytes.isNotEmpty()) {
                append(bytes.toByteArray().decodeToString())
                bytes.clear()
            }
        }
        while (i < s.length) {
            val c = s[i]
            when {
                c == '%' && i + 2 < s.length -> {
                    val hi = HEX.indexOf(s[i + 1].uppercaseChar())
                    val lo = HEX.indexOf(s[i + 2].uppercaseChar())
                    if (hi >= 0 && lo >= 0) {
                        bytes.add(((hi shl 4) or lo).toByte())
                        i += 3
                    } else {
                        flush(); append(c); i++
                    }
                }
                c == '+' -> { flush(); append(' '); i++ }
                else -> { flush(); append(c); i++ }
            }
        }
        flush()
    }

    companion object {
        const val EXTRA_PROFILE = "profile"
        const val PROFILE_LY = "ly"
        const val PROFILE_QZ = "qz"
    }
}

/** First present key's text, for the flexible product-info shapes (open question #9). */
private fun kotlinx.serialization.json.JsonObject.firstOf(vararg keys: String): String? {
    for (key in keys) {
        val v = (this[key] as? JsonPrimitive)?.contentOrNull
        if (!v.isNullOrEmpty()) return v
    }
    return null
}

private fun kotlinx.serialization.json.JsonObject.stringKey(key: String): String? =
    (this[key] as? JsonPrimitive)?.contentOrNull

private fun kotlinx.serialization.json.JsonObject.longKey(key: String): Long? =
    (this[key] as? JsonPrimitive)?.contentOrNull?.toLongOrNull()
