package com.rovecamlink.simulator

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.cio.CIO
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.put
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.net.ServerSocket
import java.net.Socket
import javax.imageio.ImageIO
import kotlin.concurrent.thread

/**
 * Desktop fakes for SJCAM's four camera channels (wire facts from `docs/evidence/sjcam` §4).
 *
 * Run one, then in the app use Manual connect → `127.0.0.1:<port>`:
 *
 * ```
 * SIM_PROFILE=sjcam-ly       gradlew :simulator:run -PsimMain=SjcamSimulatorKt   # or java -cp
 * SIM_PROFILE=sjcam-hisnet   …
 * SIM_PROFILE=sjcam-allwinner …
 * SIM_PROFILE=sjcam-amba     …    (raw TCP, default port 7878)
 * ```
 *
 * `SIM_MODEL` overrides the model string each fake reports, so the probe's model-vocabulary
 * check can be exercised without a second build (`660-SJ10X` for LY, `Hi3559V200-DV-IMX458`
 * for hisnet, `V536-CDR` for Allwinner, `SJCAMSJ8PRO` for Amba).
 *
 * These fakes are shaped like exactly one camera each, on purpose: the LY fake answers only
 * `?custom=1&cmd=`, the hisnet fake only `/cgi-bin/hisnet/…`, and so on. A fake that answered
 * everything would let the app's probe order look correct while hiding a wrong claim.
 */

// ---------- shared state (one fake per process) ----------

private var lyRecording = false
private var lyRecordSeconds = 0
private var lyMode = 3 // video side of the 3016 code space
private var lyModel = System.getenv("SIM_MODEL")?.takeIf { it.isNotBlank() } ?: "660-SJ10X"
private val lySettings = linkedMapOf(
    "2002" to "6",  // resolution index (M20Cmd.CMD_MOVIE_REC_SIZE)
    "2004" to "0",  // HDR off
    "2006" to "0",  // motion detection off
    "2008" to "1",  // date stamp on
    "3008" to "1",  // language
    "3009" to "0",  // TV format
)

private var hisRecording = false
private var hisRecordMs = 0
private var hisMode = "Normal"
private var hisModel = System.getenv("SIM_MODEL")?.takeIf { it.isNotBlank() } ?: "Hi3559V200-DV-IMX458"
private val hisSettings = linkedMapOf(
    "Speaker volume" to "3",
    "Brightness" to "2",
    "Language" to "English",
)
private val hisMedia = linkedMapOf(
    "Resolution" to "1080P60",
    "Loop Recording" to "3 min",
    "Date Stamp" to "Open",
)
private val hisFiles = listOf(
    Triple("/mnt/sd/DCIM/MOVIE/20260101120000.MP4", "12582912", "20260101120000"),
    Triple("/mnt/sd/DCIM/MOVIE/20260101120200.MP4", "20971520", "20260101120200"),
    Triple("/mnt/sd/DCIM/PHOTO/20260101120300.JPG", "2411724", "20260101120300"),
)

private var allwRecording = false
private var allwMode = 1
private var allwModel = System.getenv("SIM_MODEL")?.takeIf { it.isNotBlank() } ?: "V536-CDR"
private val allwSettings = linkedMapOf(
    "2002" to Triple("Resolution", 1, listOf("4K30" to 0, "1080P60" to 11, "720P120" to 14)),
    "2008" to Triple("Date Stamp", 0, listOf("Close" to 0, "Open" to 1)),
)

private var ambaRecording = false
private var ambaRecordSeconds = 0
private var ambaModel = System.getenv("SIM_MODEL")?.takeIf { it.isNotBlank() } ?: "SJCAMSJ8PRO"
private val ambaSettings = mapOf(
    "normal_record" to linkedMapOf("Resolution" to "4K30", "EIS" to "on"),
    "System" to linkedMapOf("FLIP" to "off"),
)
private val ambaFiles = listOf(
    "/tmp/SD0/DCIM/100MEDIA/20260101120000.MP4" to 12_582_912L,
    "/tmp/SD0/DCIM/100MEDIA/20260101120100.JPG" to 2_411_724L,
)

fun main() {
    val profile = System.getenv("SIM_PROFILE") ?: "sjcam-ly"
    val port = System.getenv("SIM_PORT")?.toIntOrNull()
        ?: if (profile == "sjcam-amba") 7878 else 8080
    println("RoveCamLink '$profile' simulator on 127.0.0.1:$port  (connect in-app via 127.0.0.1:$port)")
    when (profile) {
        "sjcam-ly" -> embeddedServer(CIO, port = port, host = "0.0.0.0", module = Application::sjcamLyModule).start(wait = true)
        "sjcam-hisnet" -> embeddedServer(CIO, port = port, host = "0.0.0.0", module = Application::sjcamHisnetModule).start(wait = true)
        "sjcam-allwinner" -> embeddedServer(CIO, port = port, host = "0.0.0.0", module = Application::sjcamAllwinnerModule).start(wait = true)
        "sjcam-amba" -> runAmbaFake(port)
        else -> {
            System.err.println("SIM: unknown SIM_PROFILE '$profile' (sjcam-ly|sjcam-hisnet|sjcam-allwinner|sjcam-amba)")
            kotlin.system.exitProcess(2)
        }
    }
}

// ---------- Ly: ?custom=1&cmd= (docs/evidence/sjcam §4.1) ----------

/** `<Function><Cmd>n</Cmd>…</Function>` — the pseudo-XML the firmware answers with. */
private fun fn(vararg pairs: Pair<String, String>): String =
    "<Function>" + pairs.joinToString("") { (k, v) -> "<$k>$v</$k>" } + "</Function>"

private fun Application.sjcamLyModule() {
    routing {
        get("/") {
            val q = call.request.queryParameters
            val cmd = q["cmd"]
            if (cmd == null) {
                call.respondText("missing cmd", ContentType.Text.Plain, HttpStatusCode.BadRequest)
                return@get
            }
            val par = q["par"]
            val body = when (cmd) {
                "3012" -> fn("Cmd" to "3012", "Status" to "0", "Value" to lyModel)
                "3016" -> fn("Cmd" to "3016", "Status" to lyMode.toString())
                "3017" -> fn("Cmd" to "3017", "Status" to "1", "Total" to "30436", "Free" to "11742")
                "3019" -> fn("Cmd" to "3019", "Status" to "0", "Value" to "82")
                "2016" -> fn("Cmd" to "2016", "Status" to "0", "Value" to lyRecordSeconds.toString())
                // 3014 is the settings dictionary: one Function per setting id.
                "3014" -> lySettings.entries.joinToString("") { (k, v) ->
                    fn("Cmd" to k, "Status" to v)
                }
                "3001" -> {
                    lyMode = par?.toIntOrNull() ?: lyMode
                    "Success"
                }
                "1001" -> "Success" // photo
                "2001" -> {
                    lyRecording = par == "1"
                    if (!lyRecording) lyRecordSeconds = 0
                    "Success"
                }
                "2009" -> fn("Cmd" to "2009", "Status" to "0", "Value" to "210")
                "3005", "3006" -> "Success"
                "3010" -> "Success" // format
                "3011" -> "Success" // factory reset
                "3007" -> "Success" // power off
                "4003" -> "Success" // delete
                else -> {
                    println("SIM ly: unhandled cmd=$cmd par=$par")
                    fn("Cmd" to cmd, "Status" to "0")
                }
            }
            // The app's own writes must round-trip: 3014 writes carry &par=<value>.
            if (cmd in lySettings.keys && par != null) lySettings[cmd] = par
            println("SIM ly: cmd=$cmd par=$par -> ${body.take(90)}")
            call.respondText(body, ContentType.Text.Xml)
        }

        // The file browser is the camera's HTML directory listing (vendor table shape).
        get("/DCIM/{dir}/") {
            val dir = call.parameters["dir"] ?: ""
            val rows = SIM_FILES.filter { it.first == dir }.joinToString("") { (_, name, size) ->
                "<tr><td><a href=\"/DCIM/$dir/$name\"><b>$name</b></a>" +
                    "<td align=right>$size<td align=right>2026-01-01 12:00" +
                    "<td align=right><a href=\"#\"><b>play</b></a>\n"
            }
            val html = "<html><body><table>\n" +
                "<tr><td><a href=\"/DCIM/\"><b>..</b></a><td align=right>0<td align=right>-\n" +
                rows + "</table></body></html>"
            println("SIM ly: listing /DCIM/$dir -> ${SIM_FILES.count { it.first == dir }} files")
            call.respondText(html, ContentType.Text.Html)
        }

        get("/DCIM/{dir}/{name}") {
            val name = call.parameters["name"] ?: ""
            val lower = name.lowercase()
            val bytes = if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) sjcamJpeg(name) else sjcamVideoBytes(name)
            println("SIM ly: download $name (${bytes.size} bytes)")
            call.respondBytes(bytes, if (lower.endsWith(".jpg")) ContentType.Image.JPEG else ContentType.Video.MP4)
        }
    }
}

/** `dir`, `name`, `size` — the LY camera's own folder split (`LYCameraFileList.java:50-70`). */
private val SIM_FILES = listOf(
    Triple("MOVIE", "20260101120000.MP4", 12_582_912L),
    Triple("MOVIE", "20260101120200.MP4", 20_971_520L),
    Triple("PHOTO", "20260101120300.JPG", 2_411_724L),
    Triple("EVENT", "20260101120400.MP4", 8_388_608L),
)

// ---------- hisnet: /cgi-bin/hisnet/<cmd>.cgi (docs/evidence/sjcam §4.2) ----------

private fun Application.sjcamHisnetModule() {
    routing {
        route("/cgi-bin/hisnet") {
            get("{cmd}.cgi") {
                val cmd = call.parameters["cmd"] ?: ""
                val q = call.request.queryParameters
                val body = when (cmd) {
                    "getdeviceattr" -> "var model = \"$hisModel\";\r\nvar softversion = \"V1.0.9\";\r\nvar hardversion = \"V1.0\";\r\n"
                    "getworkmode" -> "var workmode = \"$hisMode\";\r\n"
                    "setworkmode" -> {
                        hisMode = q["-workmode"] ?: hisMode
                        "var result = \"success\";\r\n"
                    }
                    "getworkstate" -> "var running = ${if (hisRecording) "\"true\"" else "\"false\""};\r\n" +
                        "var time = $hisRecordMs;\r\n"
                    "getbatterystate" -> "var capacity = 82;\r\nvar charge = \"0\";\r\n"
                    "getsdstatus" -> "var sdstatus = 1;\r\nvar totalspace = 30436;\r\nvar freespace = 11742;\r\n"
                    "getfilecount" -> "var count = ${hisFiles.size};\r\n"
                    "getfilelist" -> {
                        val start = q["-start"]?.toIntOrNull() ?: 0
                        val end = q["-end"]?.toIntOrNull() ?: hisFiles.size
                        val slice = hisFiles.subList(start.coerceIn(0, hisFiles.size), end.coerceIn(start, hisFiles.size))
                        slice.joinToString("") { (path, size, create) ->
                            "var path = \"$path\";\r\nvar size = \"$size\";\r\nvar create = \"$create\";\r\n"
                        }
                    }
                    "getfileinfo" -> {
                        val f = hisFiles.firstOrNull { it.first == q["-name"] } ?: hisFiles.first()
                        "var path = \"${f.first}\";\r\nvar size = \"${f.second}\";\r\nvar create = \"${f.third}\";\r\n"
                    }
                    "deletefile", "deleteallfiles", "sdcommand", "sendclickkey",
                    "setsystime", "reset", "poweroff", "client" -> "var result = \"success\";\r\n"
                    "getsetting" -> hisSettings.entries.joinToString("") { (k, v) ->
                        "var item = \"$k\";\r\nvar value = \"$v\";\r\n"
                    }
                    "setsetting" -> {
                        val option = q["-option"]
                        val values = q["-values"]
                        if (option != null && values != null) hisSettings[option] = values
                        "var result = \"success\";\r\n"
                    }
                    "getmedia" -> hisMedia.entries.joinToString("") { (k, v) ->
                        "var item = \"$k\";\r\nvar value = \"$v\";\r\n"
                    }
                    "setmedia" -> {
                        val option = q["-option"]
                        val values = q["-values"]
                        if (option != null && values != null) hisMedia[option] = values
                        "var result = \"success\";\r\n"
                    }
                    "getitem" -> "var cur = \"1080P60\";\r\nvar value = \"4K30\";\r\nvar value = \"1080P60\";\r\n"
                    "getallmode" -> "var mode = \"Normal\";\r\nvar mode = \"Photo\";\r\n"
                    "getlang" -> "var langsimple = \"en\";\r\nvar langFull = \"English\";\r\n"
                    "getresource" -> "var item = \"1080P60\";\r\nvar value = \"4K30\";\r\nvar value = \"1080P60\";\r\n"
                    else -> {
                        println("SIM hisnet: unhandled $cmd")
                        "var result = \"unknown\";\r\n"
                    }
                }
                if (cmd == "deletefile" || cmd == "sdcommand") {
                    println("SIM hisnet: $cmd ${q.entries().joinToString(" ") { "${it.key}=${it.value}" }}")
                }
                if (cmd != "getfilelist") println("SIM hisnet: $cmd -> ${body.take(80)}")
                call.respondText(body, ContentType.Text.Plain)
            }
        }

        // Media is served as base+path (MediaModel.java:61).
        get("/mnt/sd/{dir}/{name}") {
            val name = call.parameters["name"] ?: ""
            val lower = name.lowercase()
            val bytes = if (lower.endsWith(".jpg")) sjcamJpeg(name) else sjcamVideoBytes(name)
            println("SIM hisnet: download $name (${bytes.size} bytes)")
            call.respondBytes(bytes, if (lower.endsWith(".jpg")) ContentType.Image.JPEG else ContentType.Video.MP4)
        }
    }
}

// ---------- Allwinner: :8082/api/{get,set}deviceinfo (docs/evidence/sjcam §4.4) ----------

private fun Application.sjcamAllwinnerModule() {
    routing {
        get("/api/getdeviceinfo/") {
            val cmd = call.request.queryParameters["cmd"] ?: ""
            val par = call.request.queryParameters["par"]
            val json = when (cmd) {
                "2001" -> buildJsonObject {
                    put("device_name", allwModel)
                    put("software", "V1.1.2")
                }
                "3030" -> buildJsonObject { put("workmode", allwMode) }
                "2005" -> buildJsonObject { put("RecodStatus", if (allwRecording) 1 else 0) }
                "3031" -> buildJsonObject {
                    put("Menu", buildJsonArray {
                        // par is the mode id; the fake answers the same menu for every mode.
                        allwSettings.entries.forEach { (cmdId, t) ->
                            val (name, current, options) = t
                            add(buildJsonObject {
                                put("Cmd", cmdId.toInt())
                                put("Name", name)
                                put("Value", current)
                                put("Type", 3)
                                put("MenuList", buildJsonArray {
                                    options.forEach { (label, index) ->
                                        add(buildJsonObject {
                                            put("id", label)
                                            put("Index", index)
                                        })
                                    }
                                })
                            })
                        }
                    })
                    par?.let { put("mode", it) }
                }
                else -> buildJsonObject { put("Value", 0) }
            }
            println("SIM allwinner: GET cmd=$cmd par=$par -> $json")
            call.respondText(json.toString(), ContentType.Application.Json)
        }

        get("/api/setdeviceinfo/") {
            val cmd = call.request.queryParameters["cmd"] ?: ""
            val par = call.request.queryParameters["par"]
            when (cmd) {
                "1100" -> allwRecording = par == "1"
                "1110" -> allwMode = par?.toIntOrNull() ?: allwMode
                else -> Unit
            }
            val json = buildJsonObject { put("Value", 0) }
            println("SIM allwinner: SET cmd=$cmd par=$par -> $json")
            call.respondText(json.toString(), ContentType.Application.Json)
        }
    }
}

// ---------- Amba: JSON over TCP 7878 (docs/evidence/sjcam §4.3) ----------

/**
 * One session per connection, plain JSON. The real camera interleaves notifications
 * (`msg_id=7`) and has no framing at all; the fake answers exactly one object per request,
 * which is the shape the client's accumulate-and-parse reader expects.
 */
private fun runAmbaFake(port: Int) {
    val server = ServerSocket(port)
    println("SIM amba: JSON session on tcp://127.0.0.1:$port (model=$ambaModel)")
    thread(isDaemon = true) {
        while (true) {
            val socket = try {
                server.accept()
            } catch (t: Exception) {
                return@thread
            }
            thread(isDaemon = true) {
                socket.use { s -> serveAmba(s) }
            }
        }
    }
    Thread.currentThread().join()
}

private fun serveAmba(s: Socket) {
    s.soTimeout = 60_000
    val input = s.getInputStream()
    val out = s.getOutputStream()
    val buf = ByteArray(4096)
    val acc = StringBuilder()
    var token = 0
    while (true) {
        val n = try {
            input.read(buf)
        } catch (t: Exception) {
            return
        }
        if (n <= 0) return
        acc.append(String(buf, 0, n))
        if (!acc.endsWith("}")) continue
        val text = acc.toString()
        acc.setLength(0)
        val msgId = runCatching { Json.parseToJsonElement(text).jsonObject["msg_id"]?.let { (it as JsonPrimitive).contentOrNull } }
            .getOrNull()?.toIntOrNull() ?: continue
        val reply: JsonObject = when (msgId) {
            257 -> {
                token = 123
                buildJsonObject {
                    put("msg_id", 257)
                    put("rval", 0)
                    put("token", token)
                }
            }
            11 -> buildJsonObject {
                put("msg_id", 11)
                put("rval", 0)
                put("param", buildJsonObject {
                    put("model", ambaModel)
                    put("sw_version", "1.2.9")
                    put("serial_number", "SIM0000001")
                })
            }
            13 -> buildJsonObject { put("msg_id", 13); put("rval", 0); put("param", 82) }
            515 -> buildJsonObject { put("msg_id", 515); put("rval", 0); put("param", ambaRecordSeconds) }
            513 -> {
                ambaRecording = true
                buildJsonObject { put("msg_id", 513); put("rval", 0) }
            }
            514 -> {
                ambaRecording = false
                ambaRecordSeconds = 0
                buildJsonObject { put("msg_id", 514); put("rval", 0) }
            }
            769 -> buildJsonObject { put("msg_id", 769); put("rval", 0) }
            3 -> buildJsonObject {
                put("msg_id", 3)
                put("rval", 0)
                put("param", buildJsonObject {
                    ambaSettings.forEach { (workMode, group) ->
                        put(workMode, buildJsonObject { group.forEach { (k, v) -> put(k, v) } })
                    }
                })
            }
            2 -> {
                // Settings write: type/param, or the camera-mode switch.
                val obj = runCatching { Json.parseToJsonElement(text).jsonObject }.getOrNull()
                val type = obj?.get("type")?.let { (it as? JsonPrimitive)?.contentOrNull }
                val param = obj?.get("param")?.let { (it as? JsonPrimitive)?.contentOrNull }
                println("SIM amba: set type=$type param=$param")
                buildJsonObject { put("msg_id", 2); put("rval", 0) }
            }
            4 -> buildJsonObject { put("msg_id", 4); put("rval", 0) }
            1281 -> buildJsonObject { put("msg_id", 1281); put("rval", 0) }
            485 -> buildJsonObject {
                put("msg_id", 485)
                put("rval", 0)
                put("fileinfolist", ambaFiles.joinToString(",") { (path, size) ->
                    val name = path.substringAfterLast('/').substringBeforeLast('.')
                    "$path;20260101120000;1767225600000;$size"
                })
            }
            483 -> buildJsonObject {
                put("msg_id", 483)
                put("rval", 0)
                put("filelist", ambaFiles.joinToString(",") { it.first })
            }
            else -> buildJsonObject { put("msg_id", msgId); put("rval", -1) }
        }
        println("SIM amba: msg_id=$msgId -> ${reply.toString().take(120)}")
        out.write(reply.toString().toByteArray())
        out.flush()
    }
}

// ---------- media bytes ----------
//
// Deliberately local copies of the hi3510 fake's generators (Main.kt keeps its own private):
// three simulators sharing one helper would also share its bugs, and this pair is small.

/** A real, decodable JPEG so the app's thumbnail decode path is exercised. */
private fun sjcamJpeg(name: String, w: Int = 320, h: Int = 180): ByteArray {
    val img = BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
    val hue = ((name.hashCode() % 360) + 360) % 360
    for (y in 0 until h) {
        for (x in 0 until w) {
            img.setRGB(x, y, java.awt.Color.getHSBColor((hue / 360f + x * 0.15f / w) % 1f, 0.5f, 0.4f + 0.4f * y / h).rgb)
        }
    }
    return ByteArrayOutputStream().use { out ->
        ImageIO.write(img, "jpg", out)
        out.toByteArray()
    }
}

/** A deterministic ~1 MiB payload so download progress and resume have something to chew. */
private fun sjcamVideoBytes(name: String): ByteArray {
    val size = 1_048_576
    val out = ByteArray(size)
    var seed = name.hashCode()
    for (i in 0 until size step 4) {
        seed = seed * 1103515245 + 12345
        out[i] = (seed ushr 16).toByte()
        if (i + 1 < size) out[i + 1] = (seed ushr 8).toByte()
        if (i + 2 < size) out[i + 2] = seed.toByte()
        if (i + 3 < size) out[i + 3] = 0
    }
    return out
}
