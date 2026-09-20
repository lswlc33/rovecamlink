package com.rovecamlink.app.brand.tuwin

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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull
import okio.Path
import kotlin.random.Random

/**
 * TUWIN REST protocol (Ride3Pro / Ride6). Seed-based auth handshake then plain
 * `/api/...` JSON endpoints. Live preview over RTSP on :8080.
 *
 * Endpoints recovered from the official TUWIN app:
 *   /api/authdevice?seed=, /api/device/info, /api/device/status,
 *   /api/rtspstatus?seed=, /api/capture, /api/record/start|stop,
 *   /api/setmode?mode=, /api/menu/getparameter?id=, /api/menu/setparameter?id=&value=,
 *   /api/sd/info, /api/playback/filelist
 */
class TuwinRestProtocol(private val http: CameraHttp) : CameraProtocol {

    override val platform = DevicePlatform.TUWIN_REST
    private val json = Json { ignoreUnknownKeys = true; isLenient = true }
    private val _events = MutableSharedFlow<DeviceEvent>(extraBufferCapacity = 8)
    override val events: Flow<DeviceEvent> = _events

    override suspend fun probe(host: String, port: Int): Boolean {
        val body = http.getText("http://$host:$port/api/device/status") ?: return false
        return body.contains("status", true) || body.trim().startsWith("{")
    }

    override suspend fun connect(host: String, port: Int): CameraSession {
        val seed = Random.nextLong(Long.MAX_VALUE).toString()
        // Auth handshake; token may be echoed back. Best-effort.
        val authBody = http.getText("http://$host:$port/api/authdevice?seed=$seed")
        val token = authBody?.let { runCatching { json.parseToJsonElement(it) }.getOrNull() }
            ?.jsonObject?.get("token")?.jsonPrimitiveOrNull()
        http.getText("http://$host:$port/api/rtspstatus?seed=$seed")
        val info = http.getText("http://$host:$port/api/device/info")
        val model = info?.let { runCatching { json.parseToJsonElement(it) }.getOrNull() }
            ?.jsonObject?.get("model")?.jsonPrimitiveOrNull() ?: "TUWIN"
        return CameraSession(
            host = host, port = port, platform = platform, brand = Brand.TUWIN,
            model = model, authToken = token ?: seed,
        )
    }

    override suspend fun getStatus(session: CameraSession): DeviceStatus {
        val base = session.baseUrl
        val statusBody = http.getText("$base/api/device/status")
        val sdBody = http.getText("$base/api/sd/info")
        val obj = statusBody?.toObj()
        val sd = sdBody?.toObj()
        return DeviceStatus(
            battery = obj?.int("battery") ?: obj?.int("batterylevel"),
            recording = (obj?.int("record") ?: obj?.int("recording") ?: 0) == 1,
            mode = obj?.int("mode")?.let { WorkMode.fromCode(it) },
            videoTimeSec = obj?.int("recordtime") ?: obj?.int("videotime"),
            sdTotalMb = sd?.long("total") ?: sd?.long("totalspace"),
            sdFreeMb = sd?.long("free") ?: sd?.long("freespace") ?: sd?.long("available"),
            photoCount = sd?.int("photocount"),
            videoCount = sd?.int("videocount"),
            raw = obj?.rawMap() ?: emptyMap(),
        )
    }

    override suspend fun getSettings(session: CameraSession): List<CameraSetting> {
        // TUWIN exposes a menu XML; we surface a minimal known set via menu params.
        val ids = listOf("resolution", "bitrate", "exposure", "whitebalance", "wdr", "audio")
        return ids.mapNotNull { id ->
            val v = http.getText("${session.baseUrl}/api/menu/getparameter?id=$id")?.toObj()?.string("value")
                ?: http.getText("${session.baseUrl}/api/menu/getparameter?id=$id")
            if (v == null) null else CameraSetting(id, id.replaceFirstChar { c -> c.uppercase() }, v.toString())
        }
    }

    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult {
        val r = http.getText("${session.baseUrl}/api/menu/setparameter?id=$id&value=$value")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("setparameter failed")
    }

    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult {
        val r = http.getText("${session.baseUrl}/api/setmode?mode=${mode.code}")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("setmode failed")
    }

    override suspend fun capture(session: CameraSession): CmdResult {
        val r = http.getText("${session.baseUrl}/api/capture")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("capture failed")
    }

    override suspend fun record(session: CameraSession, start: Boolean): CmdResult {
        val r = http.getText("${session.baseUrl}/api/record/${if (start) "start" else "stop"}")
        _events.tryEmit(DeviceEvent.RecordingChanged(start))
        return if (r != null) CmdResult.Ok else CmdResult.Failure("record failed")
    }

    override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> {
        val body = http.getText("${session.baseUrl}/api/playback/filelist?start=$start&end=$end") ?: return emptyList()
        val arr = runCatching { json.parseToJsonElement(body) }.getOrNull()
            ?.let { el -> el.jsonObject["files"]?.jsonArray ?: el.jsonArray } ?: return emptyList()
        return arr.mapNotNull { el ->
            val o = el.jsonObject
            val name = o.string("name") ?: o.string("filename") ?: return@mapNotNull null
            val isVideo = (o.string("type")?.contains("video", true) == true) ||
                name.endsWith(".mp4", true) || name.endsWith(".mov", true)
            RemoteFile(
                name = name,
                type = if (isVideo) FileType.VIDEO else FileType.PHOTO,
                sizeBytes = o.long("size") ?: 0L,
                downloadUrl = o.string("url")?.let { absolute(session, it) }
                    ?: "${session.baseUrl}/api/playback/download?file=$name",
                thumbnailUrl = "${session.baseUrl}/api/playback/thumbnail?file=$name",
                dateMillis = o.long("time") ?: o.long("date"),
            )
        }
    }

    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult {
        val r = http.getText("${session.baseUrl}/api/playback/delete?file=${file.name}")
        return if (r != null) CmdResult.Ok else CmdResult.Failure("delete failed")
    }

    override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? =
        http.getBytes(file.thumbnailUrl ?: "${session.baseUrl}/api/playback/thumbnail?file=${file.name}")

    override suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long = http.download(file.downloadUrl, dest, alreadyHaveBytes, onProgress)

    override fun previewUrl(session: CameraSession): String =
        "rtsp://${session.host}:8080/?action=stream"

    // ---- helpers ----
    private fun absolute(session: CameraSession, url: String) =
        if (url.startsWith("http")) url else session.baseUrl + url

    private fun String.toObj(): JsonObject? =
        runCatching { json.parseToJsonElement(this).jsonObject }.getOrNull()

    private fun JsonObject.jsonPrimitiveOrNull(): String? =
        (this as? JsonPrimitive)?.contentOrNull

    private fun JsonElement.jsonPrimitiveOrNull(): String? =
        (this as? JsonPrimitive)?.contentOrNull

    private fun JsonObject.string(key: String): String? =
        (get(key) as? JsonPrimitive)?.contentOrNull

    private fun JsonObject.int(key: String): Int? =
        (get(key) as? JsonPrimitive)?.intOrNull ?: (get(key) as? JsonPrimitive)?.contentOrNull?.toIntOrNull()

    private fun JsonObject.long(key: String): Long? =
        (get(key) as? JsonPrimitive)?.longOrNull ?: (get(key) as? JsonPrimitive)?.contentOrNull?.toLongOrNull()

    private fun JsonObject.rawMap(): Map<String, String> =
        entries.associate { (k, v) -> k to ((v as? JsonPrimitive)?.contentOrNull ?: v.toString()) }
}
