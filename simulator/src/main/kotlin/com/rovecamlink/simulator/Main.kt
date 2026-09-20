package com.rovecamlink.simulator

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import java.awt.BasicStroke
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

/**
 * Desktop simulator for an XTU Hisilicon Hi35xx ("hi3510") action camera.
 *
 * It speaks the exact CGI wire protocol recovered from the official XTU GO app:
 * `var key="value";\r\n` responses (not JSON), the `/cgi-bin/hi3510/<cmd>.cgi`
 * path scheme, the `-param` query convention, JSON file list from
 * getfilelistinfoios.cgi, and plain HTTP media/thumbnail downloads.
 *
 * Run it, then in the desktop app use Manual connect → 127.0.0.1:8080.
 */

private var recording = false
private var workMode = "NormalVideo"
private val settings = linkedMapOf(
    "Resolution" to "1080P60",
    "ImageStabilize" to "ON",
    "AV Out" to "OFF",
)
private val resolutionOptions = listOf("720P100", "1080P60", "2.7K30", "4K30")
private val onOffOptions = listOf("ON", "OFF")

private data class SimFile(val path: String, val create: String, val time: Int, val size: Long)

private val files = listOf(
    SimFile("MOVIE/2026010112000000.MP4", "20260101120000", 32, 12_582_912),
    SimFile("DCIM/2026010112010000.JPG", "20260101120100", 0, 2_411_724),
    SimFile("MOVIE/2026010112020000.MP4", "20260101120200", 47, 20_971_520),
    SimFile("DCIM/2026010112030000.JPG", "20260101120300", 0, 3_145_728),
)

private fun varargBody(vararg pairs: Pair<String, String>): String =
    pairs.joinToString("") { (k, v) -> "var $k=\"$v\";\r\n" }

fun main() {
    val port = (System.getenv("SIM_PORT")?.toIntOrNull()) ?: 8080
    println("RoveCamLink XTU Hisilicon simulator on http://127.0.0.1:$port  (connect in-app via 127.0.0.1:$port)")
    embeddedServer(CIO, port = port, host = "0.0.0.0", module = Application::simulatorModule).start(wait = true)
}

fun Application.simulatorModule() {
    routing {
        route("/cgi-bin/hi3510") {
            get("{cmd}.cgi") {
                val cmd = call.parameters["cmd"] ?: ""
                val q = call.request.queryParameters
                val text = handleCgi(cmd, q)
                if (text == null) call.respondText("not found", status = HttpStatusCode.NotFound)
                else call.respondText(text, ContentType.Text.Plain)
            }
        }

        // Media + thumbnail downloads: /MOVIE/xxx.MP4 , /DCIM/xxx.JPG , /MOVIE/xxx.THM
        get("{dir}/{name}") {
            val name = call.parameters["name"] ?: ""
            val lower = name.lowercase()
            val bytes = when {
                // Thumbnails get a real JPEG so the app's decode path is exercised.
                lower.endsWith(".thm") -> thumbnailJpeg(name)
                lower.endsWith(".jpg") || lower.endsWith(".jpeg") -> photoJpeg(name)
                else -> fakeVideoBytes(name)
            }
            val ct = if (lower.endsWith(".mp4") || lower.endsWith(".lrv")) ContentType.Video.MP4
            else ContentType.Image.JPEG
            call.respondBytes(bytes, ct)
        }
    }
}

private fun handleCgi(cmd: String, q: io.ktor.http.Parameters): String? = when (cmd) {
    "getdeviceattr" -> varargBody(
        "model" to "X7Pro", "name" to "XTU X7 Pro (Sim)", "serialnum" to "SIM0000001",
        "softversion" to "1.0.4", "hardversion" to "NewAPP", "type" to "117",
        "region" to "G", "pcbrevision" to "V1.0",
    )
    "getcamerastatus" -> varargBody("count" to files.size.toString(), "status" to if (recording) "20" else "1")
    "getcurallinfo", "getallinfo" -> varargBody(
        "mode" to workMode, "state" to if (recording) "0" else "3", "event" to "0",
        "pasttime" to if (recording) "12" else "0",
    )
    "getbatterycapacity" -> varargBody("capacity" to "82", "charge" to "0", "ac" to "0")
    "getsdstate" -> varargBody("sdstate" to "SDOK", "total" to "30436", "used" to "11742")
    "getfilecount" -> varargBody("count" to files.size.toString())

    "photo" -> "Success"
    "record" -> {
        val c = q["-cmd"]
        recording = c == "start"
        "Success"
    }
    "setcamerastatus" -> { recording = q["-status"] == "20"; "Success" }

    "getcurworkmode" -> varargBody("workmode" to workMode, "value" to workMode)
    "getallworkmode" -> varargBody("photo" to "NormalPhoto,TimerPhoto,Burst", "video" to "NormalVideo,CarMode,VideoLapse,SlowRec")
    "setcurworkmode" -> { workMode = q["-workmode"] ?: workMode; "Success" }
    "getworkmode" -> varargBody("workmode" to if (workMode.contains("Video")) "20" else "0")
    "setworkmode" -> "Success"

    "getprimarymenuitem" -> varargBody(
        "item" to settings.keys.joinToString(","),
        "cur" to settings.values.joinToString(","),
    )
    "getsecondmenuitem" -> {
        val name = q["-name"]
        val opts = when (name) {
            "Resolution" -> resolutionOptions
            else -> onOffOptions
        }
        varargBody("item" to opts.joinToString(","), "value" to (settings[name] ?: opts.first()))
    }
    "setcurparameter" -> {
        val name = q["-name"]; val value = q["-value"]
        if (name != null && value != null) settings[name] = value
        "Success"
    }

    "getfilelistinfoios" -> {
        val start = q["-start"]?.toIntOrNull() ?: 0
        val end = q["-end"]?.toIntOrNull() ?: files.size
        val slice = files.subList(start.coerceIn(0, files.size), end.coerceIn(start, files.size))
        buildJsonArray {
            slice.forEach { f ->
                add(buildJsonObject {
                    put("path", f.path)
                    put("create", f.create)
                    put("time", f.time)
                    put("size", f.size)
                })
            }
        }.toString()
    }
    "getfilelist" -> files.joinToString(";") { it.path }
    "getfileinfo" -> {
        val name = q["-name"]
        val f = files.firstOrNull { it.path == name } ?: files.first()
        varargBody("create" to f.create, "size" to f.size.toString(), "time" to f.time.toString())
    }
    "deletefile" -> "Success"
    "deleteallfiles" -> "Success"
    "sdcommand" -> varargBody("sdstatus" to "1")

    // A few legacy getters so the legacy settings path also works.
    "getvideoinfo" -> varargBody("resolution" to "1080P60", "fps" to "60")
    "getbitrate" -> varargBody("bitrate" to "24")
    "getlooprecord" -> varargBody("enable" to "1")
    "getbuzzer" -> varargBody("enable" to "1")
    "getledstate" -> varargBody("enable" to "1")
    "getflip" -> varargBody("enable" to "0")
    "getaudioencode" -> varargBody("enable" to "1")

    else -> null
}

private fun fakeVideoBytes(name: String): ByteArray {
    // Deterministic ~1 MB payload so download progress/resume can be exercised.
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


/**
 * Generates a real, decodable JPEG so the app's thumbnail decode path is exercised
 * rather than fed a stub. The image is a deterministic gradient derived from the
 * file name, so each file looks different and a stale/cached thumbnail is obvious.
 */
private fun generatedJpeg(name: String, w: Int = 320, h: Int = 180): ByteArray {
    val img = BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
    val seed = name.hashCode()
    val hue = ((seed % 360) + 360) % 360
    for (y in 0 until h) {
        for (x in 0 until w) {
            val fx = x.toFloat() / (w - 1)
            val fy = y.toFloat() / (h - 1)
            val rgb = Color.getHSBColor(
                (hue / 360f + fx * 0.15f) % 1f,
                0.45f + 0.35f * fy,
                0.35f + 0.5f * (1f - fy),
            )
            img.setRGB(x, y, rgb.rgb)
        }
    }
    // A diagonal marker makes orientation/rotation bugs visible at a glance.
    val g = img.createGraphics()
    g.color = java.awt.Color.WHITE
    g.stroke = java.awt.BasicStroke(3f)
    g.drawLine(0, h - 1, w - 1, 0)
    g.dispose()

    return ByteArrayOutputStream().use { out ->
        ImageIO.write(img, "jpg", out)
        out.toByteArray()
    }
}

/** Video thumbnail (.THM) — real JPEG. */
private fun thumbnailJpeg(name: String): ByteArray = generatedJpeg(name)

/** Photo thumbnail/download — real JPEG. */
private fun photoJpeg(name: String): ByteArray = generatedJpeg(name)
