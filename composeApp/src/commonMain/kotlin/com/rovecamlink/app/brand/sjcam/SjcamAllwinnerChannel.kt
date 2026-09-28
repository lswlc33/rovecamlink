package com.rovecamlink.app.brand.sjcam

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.transport.CameraHttp
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okio.Path

/**
 * Allwinner (V536) channel — the SJ10_A / `V536-CDR` product (`docs/evidence/sjcam.md` §4.4).
 *
 * A JSON API on a **non-80 port**: reads go to `http://<host>:8082/api/getdeviceinfo/?custom=1&cmd=`
 * and writes to `…/api/setdeviceinfo/…` (`AllWinnerCameraHttp.java:56-58`). That port is why this
 * probe ignores the port it is handed — discovery walks hosts on 80, and this family is simply
 * not there.
 *
 * Command ids (`AllWinnerCameraHttp.AllWinnerCmd`, `:73-79`):
 * `RECORD=1100` · `CAPTURE=1101` · `MODE_CHANGE=1110` · `GET_VERSION=2001` · `RECORD_STATE=2005`
 * · `GET_MODEL=3030` · `GET_MODEL_LIST=3031`. Response keys are the firmware's own, including
 * its typo: `RecodStatus` (one `r` short — kept verbatim, `:272`), `workmode`, `device_name`
 * (`AllWinnerCameraHttp.java:242-246`, where `ak.J` resolves to `"device_name"`).
 *
 * **Two gaps, stated rather than papered over**: the file browser (the official client pulls the
 * camera's SQLite index `sunxi.db` and reads it locally, `:539` — a SQLite reader is out of
 * scope here), and battery/SD reads (no command for either exists in the APK's table).
 */
internal class SjcamAllwinnerChannel(private val http: CameraHttp) : SjcamChannel {

    override val id = ID
    override val displayName = "SJCAM Allwinner (SJ10_A)"

    private val json = Json { ignoreUnknownKeys = true; isLenient = true }

    private object Cmd {
        const val RECORD = 1100
        const val CAPTURE = 1101
        const val MODE_CHANGE = 1110
        const val GET_VERSION = 2001
        const val RECORD_STATE = 2005
        const val GET_MODEL = 3030
        const val GET_MODEL_LIST = 3031
    }

    private suspend fun get(host: String, port: Int, cmd: Int, par: String? = null): String? = http.getText(
        "http://$host:$port/api/getdeviceinfo/?custom=1&cmd=$cmd" + (par?.let { "&par=$it" } ?: ""),
    )

    private suspend fun set(session: CameraSession, cmd: Int, par: String): String? =
        http.getText("http://${session.host}:${session.port}/api/setdeviceinfo/?custom=1&cmd=$cmd&par=$par")

    private fun obj(body: String?): JsonObject? =
        body?.let { runCatching { json.parseToJsonElement(it).jsonObject }.getOrNull() }

    private fun str(o: JsonObject?, key: String): String? =
        (o?.get(key) as? JsonPrimitive)?.contentOrNull

    private fun int(o: JsonObject?, key: String): Int? = str(o, key)?.toIntOrNull()

    // ---------- probe / connect ----------

    /**
     * `cmd=2001` answers `{"device_name": …, "software": …}` (`:242-246`). Both keys are
     * required before the channel claims the host: a camera-less HTTP server that happens to
     * answer JSON on 8082 must not be driven with SJCAM's command ids.
     */
    override suspend fun probe(host: String, port: Int): Boolean {
        val answered = answeringPort(host, port)
        val o = obj(get(host, answered ?: port, Cmd.GET_VERSION))
        val model = str(o, "device_name")
        val software = str(o, "software")
        val verdict = answered != null && model != null && software != null
        Diag.d(LogTag.PROTO) {
            "sjcam-allwinner probe $host:$port -> $verdict on=${answered ?: "-"} model=${LogFormat.safe(model)}"
        }
        return verdict
    }

    override suspend fun connect(host: String, port: Int): CameraSession? {
        val apiPort = answeringPort(host, port) ?: return null
        val o = obj(get(host, apiPort, Cmd.GET_VERSION))
        val model = str(o, "device_name") ?: return null
        val mode = int(obj(get(host, apiPort, Cmd.GET_MODEL)), "workmode")
        Diag.i(LogTag.PROTO) { "sjcam-allwinner connect model=${LogFormat.safe(model)} mode=$mode port=$apiPort" }
        return newSession(host, apiPort, model, mapOf(EXTRA_MODE to (mode?.toString() ?: "")))
    }

    /**
     * Which port the API answers on: the one discovery handed us (a forwarded setup), else the
     * family's own 8082. Discovery walks hosts on 80, and this camera is not there — without the
     * second try the whole channel would be unreachable during auto-detection.
     */
    private suspend fun answeringPort(host: String, givenPort: Int): Int? {
        for (candidate in listOf(givenPort, PORT).distinct()) {
            val o = obj(get(host, candidate, Cmd.GET_VERSION))
            if (str(o, "device_name") != null && str(o, "software") != null) return candidate
        }
        return null
    }

    // ---------- status ----------

    override suspend fun status(session: CameraSession): DeviceStatus {
        val record = int(obj(get(session.host, session.port, Cmd.RECORD_STATE)), "RecodStatus")
        val mode = int(obj(get(session.host, session.port, Cmd.GET_MODEL)), "workmode")
        Diag.d(LogTag.PARSE) { "sjcam-allwinner status record=$record mode=$mode" }
        return DeviceStatus(
            // No battery or card command exists on this channel (archive §4.4); nulls keep the
            // UI honest instead of drawing 0%.
            battery = null,
            recording = record == 1,
            mode = modeOf(mode),
            modeName = mode?.toString(),
        )
    }

    private fun modeOf(code: Int?): WorkMode? = when (code) {
        1, 3, 4, 8 -> WorkMode.VIDEO   // NORMAL/LOOP/AUTO_TIME_RECORD/SLOW (`AllwinnerCamera.java:92-99`)
        2, 5, 6, 7 -> WorkMode.PHOTO  // NORMAL/TIME/AUTO_TIME/NOTION CAPTURE
        9 -> WorkMode.PLAYBACK        // the menu id the main-menu list skips for playback
        else -> null
    }

    // ---------- settings ----------

    /**
     * `cmd=3031&par=<mode>` answers `{"Menu":[{"Cmd","Name","Value","Type","MenuList":[{"id","Index"}]}]}`
     * (`:360-425`): each entry is a setting whose current value is the index into its own
     * option list. Ids are the firmware's `Cmd` numbers, options carry the wire `Index`.
     */
    override suspend fun getSettings(session: CameraSession): List<CameraSetting> {
        val mode = session.extras[EXTRA_MODE]?.takeIf { it.isNotBlank() } ?: "1"
        val rows = parseMenu(get(session.host, session.port, Cmd.GET_MODEL_LIST, mode))
        Diag.d(LogTag.PARSE) { "sjcam-allwinner settings mode=$mode -> ${rows.size} rows" }
        return rows
    }

    override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult {
        val body = set(session, id.toIntOrNull() ?: return CmdResult.Failure("bad setting id $id"), value)
        // Success is `{"Value":0}` on this channel (`:716`).
        val ok = int(obj(body), "Value") == 0
        Diag.d(LogTag.PROTO) { "sjcam-allwinner set $id=$value -> $ok" }
        return if (ok) CmdResult.Ok else CmdResult.Failure("$id 写入被拒绝")
    }

    // ---------- capture ----------

    /** Mode ids are the menu ids the official client enumerates (`id` 0..9, `:365-380`). */
    override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult {
        val id = when (mode) {
            WorkMode.VIDEO -> "1"
            WorkMode.PHOTO -> "2"
            WorkMode.PLAYBACK -> "9"
        }
        val body = set(session, Cmd.MODE_CHANGE, id)
        return if (int(obj(body), "Value") == 0) CmdResult.Ok else CmdResult.Failure("模式切换被拒绝")
    }

    override suspend fun capture(session: CameraSession): CmdResult {
        val body = set(session, Cmd.CAPTURE, "1")
        return if (int(obj(body), "Value") == 0) CmdResult.Ok else CmdResult.Failure("拍照被拒绝")
    }

    override suspend fun record(session: CameraSession, start: Boolean): CmdResult {
        val body = set(session, Cmd.RECORD, if (start) "1" else "0")
        return if (int(obj(body), "Value") == 0) CmdResult.Ok else CmdResult.Failure("录像命令被拒绝")
    }

    // ---------- files (documented gap) ----------

    override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> {
        Diag.w(LogTag.PARSE) {
            "sjcam-allwinner file browser not implemented: official client reads the camera's " +
                "sqlite index (sunxi.db), not an HTTP listing"
        }
        return emptyList()
    }

    override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult =
        CmdResult.Failure("该机型族的文件操作未实现（官方走 sqlite 索引）")

    override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? = null

    override suspend fun download(
        session: CameraSession,
        file: RemoteFile,
        dest: Path,
        alreadyHaveBytes: Long,
        onProgress: (Float) -> Unit,
    ): Long = -1L

    override fun previewUrl(session: CameraSession): String = "rtsp://${session.host}:8554/ch01"

    override suspend fun getDeviceInfo(session: CameraSession): DeviceInfo? {
        val o = obj(get(session.host, session.port, Cmd.GET_VERSION)) ?: return null
        return DeviceInfo(
            name = str(o, "device_name"),
            model = str(o, "device_name"),
            softVersion = str(o, "software"),
        )
    }

    companion object {
        const val ID = "allwinner"
        const val PORT = 8082
        const val MODEL = "V536-CDR"
        const val EXTRA_MODE = "sjcam.allwinner.mode"

        private val menuJson = Json { ignoreUnknownKeys = true; isLenient = true }

        /**
         * `{"Menu":[…]}` → settings rows. Pure (no channel state), so the test can hold the
         * vendor's own nesting — `MenuList[i].id` as the label and `Index` as the wire value —
         * without a camera.
         */
        internal fun parseMenu(body: String?): List<CameraSetting> {
            val root = runCatching { menuJson.parseToJsonElement(body ?: return emptyList()).jsonObject }
                .getOrNull() ?: return emptyList()
            val menu = root["Menu"] as? JsonArray ?: return emptyList()
            fun asInt(o: JsonObject, key: String): Int? =
                (o[key] as? JsonPrimitive)?.contentOrNull?.toIntOrNull()
            fun asStr(o: JsonObject, key: String): String? =
                (o[key] as? JsonPrimitive)?.contentOrNull
            return menu.mapNotNull { el ->
                val o = el as? JsonObject ?: return@mapNotNull null
                val cmd = asInt(o, "Cmd") ?: return@mapNotNull null
                val name = asStr(o, "Name") ?: "配置项 $cmd"
                val options = (o["MenuList"] as? JsonArray)?.mapNotNull { opt ->
                    val oo = opt as? JsonObject ?: return@mapNotNull null
                    val id = asStr(oo, "id") ?: return@mapNotNull null
                    val index = asInt(oo, "Index") ?: return@mapNotNull null
                    CameraSetting.Option(value = index.toString(), label = id)
                } ?: emptyList()
                val idx = asInt(o, "Value")
                val current = idx?.let { options.getOrNull(it)?.value } ?: idx?.toString().orEmpty()
                CameraSetting(id = cmd.toString(), title = name, value = current, options = options)
            }
        }
    }
}
