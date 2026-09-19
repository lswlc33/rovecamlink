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
                lower.endsWith(".thm") || lower.endsWith(".jpg") || lower.endsWith(".jpeg") -> TINY_JPEG
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

/** Minimal valid 1x1 white JPEG (for thumbnails). */
private val TINY_JPEG: ByteArray = intArrayOf(
    0xFF, 0xD8, 0xFF, 0xE0, 0x00, 0x10, 0x4A, 0x46, 0x49, 0x46, 0x00, 0x01,
    0x01, 0x00, 0x00, 0x01, 0x00, 0x01, 0x00, 0x00, 0xFF, 0xDB, 0x00, 0x43, 0x00,
    0x08, 0x06, 0x06, 0x07, 0x06, 0x05, 0x08, 0x07, 0x07, 0x07, 0x09, 0x09, 0x08, 0x0A, 0x0C,
    0x14, 0x0D, 0x0C, 0x0B, 0x0B, 0x0C, 0x19, 0x12, 0x13, 0x0F, 0x14, 0x1D, 0x1A, 0x1F, 0x1E,
    0x1D, 0x1A, 0x1C, 0x1C, 0x20, 0x24, 0x2E, 0x27, 0x20, 0x22, 0x2C, 0x23, 0x1C, 0x1C, 0x28,
    0x37, 0x29, 0x2C, 0x30, 0x31, 0x34, 0x34, 0x34, 0x1F, 0x27, 0x39, 0x3D, 0x38, 0x32, 0x3C,
    0x2E, 0x33, 0x34, 0x32, 0xFF, 0xC0, 0x00, 0x0B, 0x08, 0x00, 0x01, 0x00, 0x01,
    0x01, 0x01, 0x11, 0x00, 0xFF, 0xC4, 0x00, 0x1F, 0x00, 0x00, 0x01, 0x05,
    0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01,
    0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0xFF, 0xC4,
    0x00, 0xB5, 0x10, 0x00, 0x02, 0x01, 0x03, 0x03, 0x02, 0x04, 0x03, 0x05, 0x05, 0x04,
    0x04, 0x00, 0x00, 0x01, 0x7D, 0x01, 0x02, 0x03, 0x00, 0x04, 0x11, 0x05, 0x12, 0x21, 0x31,
    0x41, 0x06, 0x13, 0x51, 0x61, 0x07, 0x22, 0x71, 0x14, 0x32, 0x81, 0x91, 0xA1, 0x08,
    0x23, 0x42, 0xB1, 0xC1, 0x15, 0x52, 0xD1, 0xF0, 0x24,
    0x33, 0x62, 0x72, 0x82, 0x09, 0x0A, 0x16, 0x17, 0x18, 0x19, 0x1A, 0x25, 0x26, 0x27, 0x28,
    0x29, 0x2A, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x3A, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48,
    0x49, 0x4A, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58, 0x59, 0x5A, 0x63, 0x64, 0x65, 0x66, 0x67,
    0x68, 0x69, 0x6A, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A, 0x83, 0x84, 0x85, 0x86,
    0x87, 0x88, 0x89, 0x8A, 0x92, 0x93, 0x94, 0x95, 0x96, 0x97, 0x98, 0x99, 0x9A, 0xA2,
    0xA3, 0xA4, 0xA5, 0xA6, 0xA7, 0xA8,
    0xA9, 0xAA, 0xB2, 0xB3, 0xB4, 0xB5,
    0xB6, 0xB7, 0xB8, 0xB9, 0xBA, 0xC2,
    0xC3, 0xC4, 0xC5, 0xC6, 0xC7, 0xC8,
    0xC9, 0xCA, 0xD2, 0xD3, 0xD4, 0xD5,
    0xD6, 0xD7, 0xD8, 0xD9, 0xDA, 0xE1,
    0xE2, 0xE3, 0xE4, 0xE5, 0xE6, 0xE7,
    0xE8, 0xE9, 0xEA, 0xF1, 0xF2, 0xF3,
    0xF4, 0xF5, 0xF6, 0xF7, 0xF8, 0xF9,
    0xFA, 0xFF, 0xDA, 0x00, 0x08, 0x01, 0x01, 0x00, 0x00, 0x3F, 0x00,
    0x7B, 0x94, 0x11, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
    0x00, 0x00, 0xFF, 0xD9,
).map { it.toByte() }.toByteArray()
