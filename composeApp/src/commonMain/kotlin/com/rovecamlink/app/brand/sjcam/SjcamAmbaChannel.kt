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
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.transport.CameraHttp
import com.rovecamlink.app.core.transport.CameraTcp
import com.rovecamlink.app.core.transport.CameraTcpConnection
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put
import okio.Path

/**
 * Ambarella channel — **JSON over raw TCP 7878**, the family the SJ8 Pro / SJ9 Strike / SJ10 Pro
 * boards speak (`docs/evidence/sjcam.md` §4.3).
 *
 * The handshake is the Ambarella SDK's: `{"msg_id":257,"token":0}` opens a session, the reply
 * carries the token every later command must echo (`AmbProtocol.java:317-343`). The vendor's
 * client reads that token from the reply's `param` field; the same protocol in XTU's app reads
 * `token` — so this implementation accepts either and says so in the diagnostic line (archive
 * §6 keeps the ambiguity on record).
 *
 * Message ids are `AmbProtocol.Constans` (`:87-143`): `1/2/3/9` settings, `4` format, `11` device
 * info, `12` shutdown, `13` battery, `257/258` session, `513/514` record, `515` record time,
 * `769` shutter, `1281` delete, `483/485` file lists. Single values come back in `param`
 * (`((Integer) getParam())` for battery/record-time, `AmbaCamera.java:164,364`), and settings
 * writes ride `msg_id=2` with `type`/`param` (`AmbaCamera.java:639-675`; camera-mode switch is
 * `type="camera_mode"`, `:572`).
 *
 * **Reads are serialized and framed by "does it parse yet"** — the wire has no length prefix and
 * no delimiter, and the camera also interleaves notifications (`msg_id=7`), so a reply whose id
 * is not the one in flight is skipped and reading continues until the budget runs out. Bytes are
 * taken one at a time because [CameraTcpConnection.readFully] is all-or-nothing; for the small
 * JSON replies here that is a handful of syscalls, not a hot path.
 *
 * **Not implemented**: the 8787 data socket (thumbnails / chunked file fetch, which needs a
 * second connection and an `msg_id=261` client registration first — `AmbaCamera.java:1241-1245`).
 * File downloads use the camera's HTTP mirror instead (`/tmp/SD0/…` → `/SD/…`,
 * `AmbaCamera.java:62`), and thumbnails report "none" rather than blocking the file list.
 */
internal class SjcamAmbaChannel(
    private val tcp: CameraTcp,
    private val http: CameraHttp,
) : SjcamChannel {

    override val id = ID
    override val displayName = "SJCAM Amba (Ambarella)"

    private val json = Json { ignoreUnknownKeys = true; isLenient = true }

    private inner class Conn(val connection: CameraTcpConnection) {
        val lock = Mutex()
        var token: Int = -1
    }

    private val conns = mutableMapOf<String, Conn>()

    private object Msg {
        const val SET = 2
        const val ALL_CURRENT_SETTINGS = 3
        const val FORMAT = 4
        const val START_SESSION = 257
        const val STOP_SESSION = 258
        const val START_RECORD = 513
        const val STOP_RECORD = 514
        const val RECORD_TIME = 515
        const val TAKE_PHOTO = 769
        const val GET_DEVICE_INFO = 11
        const val GET_BATTERY = 13
        const val SHUTDOWN = 12
        const val DELETE_FILE = 1281
        const val FILE_COUNT = 482
        const val FILE_LIST = 483
        const val FILELIST_INFO_IOS = 485
        const val NOTIFICATION = 7
    }

    private suspend fun openConnection(host: String): Conn? {
        conns[host]?.let { return it }
        return try {
            val conn = tcp.open(host, PORT, TIMEOUT_MS)
            val c = Conn(conn)
            // Session token first; every later command echoes it.
            val tokenReply = sendRaw(c, buildJsonObject {
                put("msg_id", START_MSG)
                put("token", 0)
            }) ?: run {
                runCatching { conn.close() }
                return null
            }
            val token = tokenOf(tokenReply)
            if (token == null || rval(tokenReply) != 0) {
                Diag.w(LogTag.PROTO) { "sjcam-amba session refused: $tokenReply" }
                runCatching { conn.close() }
                return null
            }
            c.token = token
            conns[host] = c
            Diag.i(LogTag.PROTO) { "sjcam-amba session open host=$host token=$token" }
            c
        } catch (t: Throwable) {
            Diag.d(LogTag.PROTO) { "sjcam-amba open $host:$PORT failed: ${Diag.causeChain(t)}" }
            null
        }
    }

    private suspend fun sendRaw(c: Conn, request: JsonObject): JsonObject? = c.lock.withLock {
        val text = request.toString()
        Diag.d(LogTag.PROTO) { "sjcam-amba tx $text" }
        runCatching {
            c.connection.write(text.encodeToByteArray(), 0, text.encodeToByteArray().size)
            c.connection.flush()
        }.getOrElse { t ->
            Diag.w(LogTag.PROTO) { "sjcam-amba write failed: ${Diag.causeChain(t)}" }
            return@withLock null
        }
        val wanted = (request["msg_id"] as? JsonPrimitive)?.contentOrNull?.toIntOrNull()
        readReply(c.connection, wanted)
    }

    private suspend fun command(host: String, msgId: Int, fields: Map<String, String> = emptyMap(), rawJson: Map<String, JsonElement> = emptyMap()): JsonObject? {
        val c = openConnection(host) ?: return null
        val request = buildJsonObject {
            put("msg_id", msgId)
            put("token", c.token)
            for ((k, v) in fields) put(k, v)
            for ((k, v) in rawJson) put(k, v)
        }
        return sendRaw(c, request)
    }

    /**
     * Read one JSON reply. Bytes arrive in whatever chunks the camera sends; the message ends
     * when the accumulated text parses, or when the read budget runs out. Notifications
     * (`msg_id=7`) and replies to other ids are skipped while the wanted id is still pending.
     */
    private suspend fun readReply(conn: CameraTcpConnection, wantedMsgId: Int?): JsonObject? {
        val buf = StringBuilder()
        val one = ByteArray(1)
        val deadline = Diag.uptimeMillis() + TIMEOUT_MS
        while (Diag.uptimeMillis() < deadline) {
            val ok = try {
                conn.readFully(one)
            } catch (t: Throwable) {
                false
            }
            if (!ok) break
            buf.append(one[0].toInt().toChar())
            val text = buf.toString().trim()
            if (text.length < 2 || !text.startsWith("{") || !text.endsWith("}")) continue
            val obj = runCatching { json.parseToJsonElement(text).jsonObject }.getOrNull() ?: continue
            val id = (obj["msg_id"] as? JsonPrimitive)?.contentOrNull?.toIntOrNull()
            if (id == wantedMsgId || wantedMsgId == null) {
                Diag.d(LogTag.PROTO) { "sjcam-amba rx ${text.take(200)}" }
                return obj
            }
            // Some other id (a notification or an earlier reply): drop the buffer and keep reading.
            Diag.d(LogTag.PROTO) { "sjcam-amba rx-skip msg_id=$id (wanted $wantedMsgId)" }
            buf.setLength(0)
        }
        return null
    }

    // ---------- probe / connect ----------

    /**
     * Session + device info; only a `SJCAM*` model claims the channel (`AmbaCamera.java:63-68`,
     * archive §2.1(a)). Other Ambarella products speak the same 7878 protocol — the model string
     * is what makes this SJCAM's business.
     */
    override suspend fun probe(host: String, port: Int): Boolean {
        val c = openConnection(host) ?: return false
        val reply = sendRaw(c, buildJsonObject {
            put("msg_id", GET_INFO_MSG)
            put("token", c.token)
        })
        val model = modelOf(reply)
        val verdict = model != null && model.uppercase().contains("SJCAM")
        Diag.d(LogTag.PROTO) { "sjcam-amba probe $host:$PORT -> $verdict model=${LogFormat.safe(model)}" }
        return verdict
    }

    override suspend fun connect(host: String, port: Int): CameraSession? {
        val c = openConnection(host) ?: return null
        val reply = sendRaw(c, buildJsonObject {
            put("msg_id", GET_INFO_MSG)
            put("token", c.token)
        })
        val model = modelOf(reply)?.takeIf { it.uppercase().contains("SJCAM") } ?: return null
        Diag.i(LogTag.PROTO) { "sjcam-amba connect model=${LogFormat.safe(model)}" }
        return newSession(host, PORT, model)
    }

    /**
     * Drop the socket. `msg_id=258` (stop session) is deliberately not sent first: the session
     * is being abandoned because the UI is done with it, and a failed write on a dead socket is
     * the only thing that "goodbye" could add.
     */
    override suspend fun close(session: CameraSession) {
        val c = conns.remove(session.host) ?: return
        runCatching { c.connection.close() }
    }

    // ---------- status ----------

    /** Battery is `msg_id=13` with the percentage in `param`; record time is `msg_id=515`. */
    override suspend fun status(session: CameraSession): DeviceStatus {
        val battery = intParam(command(session.host, Msg.GET_BATTERY))
        val recordSec = intParam(command(session.host, Msg.RECORD_TIME))
        Diag.d(LogTag.PARSE) { "sjcam-amba status battery=$battery recordSec=$recordSec" }
        return DeviceStatus(
            battery = battery,
            recording = (recordSec ?: 0) > 0,
            videoTimeSec = recordSec?.takeIf { it > 0 },
        )
    }

    // ---------- settings ----------

    /**
     * `msg_id=3` answers every current setting; the vendor client reassembles a long reply by
     * hand (`AmbProtocol.java:461-467`), which is the reason this channel's reader is
     * accumulate-and-parse rather than one-shot. The reply's `param` object maps
     * `workmode → {name → value}` on the boards documented in `docs/evidence/xtugo` appendix A.
     */
    override suspend fun getSettings(session: CameraSession): List<CameraSetting> {
        val reply = command(session.host, Msg.ALL_CURRENT_SETTINGS) ?: return emptyList()
        val param = reply["param"] as? JsonObject ?: return emptyList()
        val rows = ArrayList<CameraSetting>()
        for ((workMode, value) in param) {
            val group = value as? JsonObject ?: continue
            for ((name, v) in group) {
                rows += CameraSetting(
                    id = "$workMode/$name",
                    title = name,
                    value = (v as? JsonPrimitive)?.contentOrNull ?: v.toString(),
                )
            }
        }
        Diag.d(LogTag.PARSE) { "sjcam-amba settings ${rows.size} rows" }
        return rows
    }

    /** `msg_id=2` with `type`/`param` (`AmbaCamera.java:639-675`); id is `<workmode>/<name>`. */
    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult {
        val name = id.substringAfterLast('/')
        val workmode = id.substringBeforeLast('/', "")
        val reply = command(
            session.host, Msg.SET,
            fields = buildMap {
                if (workmode.isNotEmpty()) put("workmode", workmode)
                put("name", name)
                put("value", value)
            },
        )
        val ok = reply != null && rval(reply) == 0
        Diag.d(LogTag.PROTO) { "sjcam-amba set $id=$value -> $ok" }
        return if (ok) CmdResult.Ok else CmdResult.Failure("$name 写入被拒绝")
    }

    // ---------- capture ----------

    /**
     * Camera-mode switch is `msg_id=2, type="camera_mode"` (`AmbaCamera.java:572`). Playback has
     * no confirmed value on this family, so it reports the failure instead of guessing.
     */
    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult {
        val word = when (mode) {
            WorkMode.VIDEO -> "normal_record"
            WorkMode.PHOTO -> "normal_capture"
            WorkMode.PLAYBACK -> return CmdResult.Failure("Amba 家族没有已确认的回放模式切换值")
        }
        val reply = command(session.host, Msg.SET, fields = mapOf("type" to "camera_mode", "param" to word))
        return if (reply != null && rval(reply) == 0) CmdResult.Ok else CmdResult.Failure("模式切换被拒绝")
    }

    override suspend fun capture(session: CameraSession): CmdResult {
        val reply = command(session.host, Msg.TAKE_PHOTO)
        return if (reply != null && rval(reply) == 0) CmdResult.Ok else CmdResult.Failure("拍照被拒绝")
    }

    override suspend fun record(session: CameraSession, start: Boolean): CmdResult {
        val reply = command(session.host, if (start) Msg.START_RECORD else Msg.STOP_RECORD)
        return if (reply != null && rval(reply) == 0) CmdResult.Ok else CmdResult.Failure("录像命令被拒绝")
    }

    // ---------- files ----------

    /**
     * `msg_id=485` (`fileinfolist`, records `name;createTime;timeLong;size`) with `start`/`end`,
     * falling back to `msg_id=483`'s comma-separated `filelist` when 485 answers nothing
     * (`docs/evidence/xtugo` appendix A, msg 268435483/268435485).
     */
    override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> {
        val info = command(session.host, Msg.FILELIST_INFO_IOS, fields = mapOf("start" to "$start", "end" to "$end"))
        val list = (info?.get("fileinfolist") as? JsonPrimitive)?.contentOrNull
        if (!list.isNullOrBlank()) {
            val rows = list.split(',').mapNotNull { rec ->
                val parts = rec.split(';')
                if (parts.size < 4) return@mapNotNull null
                val path = parts[0].trim()
                val name = path.substringAfterLast('/')
                if (name.isEmpty()) return@mapNotNull null
                RemoteFile(
                    name = name,
                    type = typeOf(name),
                    sizeBytes = parts[3].trim().toLongOrNull() ?: 0L,
                    downloadUrl = httpUrl(session.host, path),
                    thumbnailUrl = null,
                    dateMillis = parts[2].trim().toLongOrNull(),
                )
            }
            if (rows.isNotEmpty()) {
                Diag.d(LogTag.PARSE) { "sjcam-amba files(485) ${rows.size}" }
                return rows
            }
        }
        val plain = command(session.host, Msg.FILE_LIST, fields = mapOf("start" to "$start", "end" to "$end"))
        val csv = (plain?.get("filelist") as? JsonPrimitive)?.contentOrNull
        val rows = csv.orEmpty().split(',').mapNotNull { p ->
            val path = p.trim()
            if (path.isEmpty()) return@mapNotNull null
            val name = path.substringAfterLast('/')
            RemoteFile(
                name = name,
                type = typeOf(name),
                sizeBytes = 0L,
                downloadUrl = httpUrl(session.host, path),
            )
        }
        Diag.d(LogTag.PARSE) { "sjcam-amba files(483) ${rows.size}" }
        return rows
    }

    private fun typeOf(name: String): FileType {
        val lower = name.lowercase()
        return if (lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png") ||
            lower.endsWith(".dng")
        ) {
            FileType.PHOTO
        } else {
            FileType.VIDEO
        }
    }

    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult {
        // Delete takes the camera-side path (`AmbaCamera.java:1254`), which we reconstruct from
        // the HTTP mirror the file carries.
        val path = file.downloadUrl.substringAfter("http://${session.host}").let { "/tmp/SD0${it.removePrefix("/SD")}" }
        val reply = command(session.host, Msg.DELETE_FILE, fields = mapOf("param" to path))
        return if (reply != null && rval(reply) == 0) CmdResult.Ok else CmdResult.Failure("删除被拒绝")
    }

    /** The 8787 data socket is out of scope (class docs); the UI shows a type glyph instead. */
    override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? = null

    override suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long = httpDownload(file.downloadUrl, dest, alreadyHaveBytes, onProgress)

    override fun previewUrl(session: CameraSession): String = "rtsp://${session.host}/live"

    override suspend fun getDeviceInfo(session: CameraSession): DeviceInfo? {
        val reply = command(session.host, Msg.GET_DEVICE_INFO) ?: return null
        val param = reply["param"] as? JsonObject ?: return null
        fun key(vararg names: String): String? = names.firstNotNullOfOrNull { n ->
            (param[n] as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() }
        }
        val raw = param.entries.mapNotNull { (k, v) -> (v as? JsonPrimitive)?.contentOrNull?.let { k to it } }.toMap()
        return DeviceInfo(
            name = key("model", "device_name", "name"),
            model = key("model", "device_name", "name"),
            softVersion = key("sw_version", "version", "firmware", "fw_version"),
            serialNumber = key("serial_number", "serial", "uuid"),
            ssid = key("ssid"),
            raw = raw,
        )
    }

    override suspend fun formatSd(session: CameraSession): CmdResult {
        val reply = command(session.host, Msg.FORMAT)
        return if (reply != null && rval(reply) == 0) CmdResult.Ok else CmdResult.Failure("格式化被拒绝")
    }

    override suspend fun factoryReset(session: CameraSession): CmdResult {
        val reply = command(session.host, Msg.SET, fields = mapOf("type" to "default_setting", "param" to "on"))
        return if (reply != null && rval(reply) == 0) CmdResult.Ok else CmdResult.Failure("恢复出厂被拒绝")
    }

    /** `msg_id=2, type="camera_clock"` with `yyyy-MM-dd HH:mm:ss` (`AmbaCamera.java:1276`). */
    override suspend fun syncTime(session: CameraSession): CmdResult {
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val t = "${now.year}-${p(now.monthNumber)}-${p(now.dayOfMonth)} ${p(now.hour)}:${p(now.minute)}:${p(now.second)}"
        val reply = command(session.host, Msg.SET, fields = mapOf("type" to "camera_clock", "param" to t))
        return if (reply != null && rval(reply) == 0) CmdResult.Ok else CmdResult.Failure("对时被拒绝")
    }

    /** `msg_id=12` with `param="cam_off"` (`AmbProtocol.java:134`). */
    override suspend fun sleep(session: CameraSession): CmdResult {
        val reply = command(session.host, Msg.SHUTDOWN, fields = mapOf("param" to "cam_off"))
        return if (reply != null && rval(reply) == 0) CmdResult.Ok else CmdResult.Failure("关机被拒绝")
    }

    private fun p(v: Int) = v.toString().padStart(2, '0')

    // ---------- helpers ----------

    companion object {
        const val ID = "amba"
        const val PORT = 7878
        private const val TIMEOUT_MS = 5_000
        private const val START_MSG = 257
        private const val STOP_SESSION_MSG = 258
        private const val GET_INFO_MSG = 11

        internal fun rval(o: JsonObject): Int? = (o["rval"] as? JsonPrimitive)?.contentOrNull?.toIntOrNull()

        /** The Amba file path root is `/tmp/SD0/…`; its HTTP mirror is `/SD/…` (`AmbaCamera.java:42,62`). */
        internal fun httpUrl(host: String, path: String): String {
            val mirror = path.replace("/tmp/SD0", "/SD").trimStart('/')
            return "http://$host/$mirror"
        }

        /**
         * The session token: the vendor client reads `param` (`AmbProtocol.java:524`), the same
         * protocol under XTU's app reads `token` — accept both, prefer `token`.
         */
        internal fun tokenOf(o: JsonObject): Int? =
            (o["token"] as? JsonPrimitive)?.contentOrNull?.toIntOrNull()
                ?: (o["param"] as? JsonPrimitive)?.contentOrNull?.toIntOrNull()

        internal fun intParam(o: JsonObject?): Int? =
            o?.let { (it["param"] as? JsonPrimitive)?.contentOrNull?.toIntOrNull() }

        internal fun modelOf(o: JsonObject?): String? {
            val param = o?.get("param") as? JsonObject ?: return null
            return listOf("model", "device_name", "name")
                .firstNotNullOfOrNull { k -> (param[k] as? JsonPrimitive)?.contentOrNull?.takeIf { it.isNotBlank() } }
        }
    }

    /** The control channel is the socket; media is plain HTTP on the same host. */
    private suspend fun httpDownload(url: String, dest: Path, alreadyHaveBytes: Long, onProgress: (Float) -> Unit): Long =
        http.download(url, dest, alreadyHaveBytes, onProgress)
}
