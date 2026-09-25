package com.rovecamlink.simulator

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.server.request.receive
import io.ktor.server.request.receiveText
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

/**
 * Desktop simulators for the two iCatch HTTP profiles spoken by the idGoLive app
 * (wire facts from docs/08-官方APK全量逆向档案/03-idGoLive-档案.md appendix B):
 *
 * - `SIM_PROFILE=ly` — the Novatek-style `?custom=1&cmd=` XML family on 192.168.1.254.
 * - `SIM_PROFILE=qz` — the `/app/…` JSON family on 192.168.169.1.
 *
 * Run one, then in the app use Manual connect → 127.0.0.1:8080. The default profile
 * (`hi3510`) is the XTU Hisilicon fake in [SimulatorMain]; these live apart so each
 * fake stays shaped like exactly one camera.
 */

private var recording = false
private var secondsRecorded = 0

private val lySettings = linkedMapOf(
    "2002" to "11", // 1080p@30fps per the §8.1 table
    "2003" to "0", // OFF
    "2004" to "1", // WDR on
    "2008" to "1", // date watermark on
    "2011" to "2", // G-Sensor Med
    "3044" to "0", // lens rotation off
    "8010" to "0", // body mic
    "8011" to "1", // audio on
)

private val lyResolutionOptions = listOf("1", "6", "10", "11", "14", "15")
private val lyLoopOptions = listOf("0", "1", "2", "3")
private val lySensorOptions = listOf("0", "1", "2", "3", "4")
private val lyMicOptions = listOf("0", "1")
private val lyOnOff = listOf("0", "1")

private data class LyFile(val dir: String, val name: String, val time: String, val size: Long)

private val lyFiles = listOf(
    LyFile("normal", "20260101120000.mp4", "20260101120000", 12_582_912L),
    LyFile("normal", "20260101120200.mp4", "20260101120200", 20_971_520L),
    LyFile("photo", "20260101120300.jpg", "20260101120300", 2_411_724L),
    LyFile("sos", "20260101120400.mp4", "20260101120400", 8_388_608L),
)

private val qzSettings = linkedMapOf(
    "rec_resolution" to "1",
    "switchcam" to "0",
)

private val qzResolutionItems = listOf("2160p@30", "1440p@30", "1080p@60", "1080p@30", "720p@60", "720p@30")
private val qzResolutionIndex = listOf(1, 6, 10, 11, 14, 15)
private val qzSwitchItems = listOf("front", "back")
private val qzSwitchIndex = listOf(0, 1)

private data class QzFile(val folder: String, val name: String, val duration: Int, val size: Long, val created: Long, val type: Int)

private val qzFiles = listOf(
    QzFile("loop", "/mnt/sdcard/normal/20260101120001.mp4", 61, 12_582_912L, 1_767_225_601L, 1),
    QzFile("loop", "/mnt/sdcard/normal/20260101120200.mp4", 60, 20_971_520L, 1_767_225_720L, 1),
    QzFile("event", "/mnt/sdcard/photo/20260101120300.jpg", 0, 2_411_724L, 1_767_225_780L, 2),
    QzFile("emr", "/mnt/sdcard/emr/20260101120400.mp4", 30, 8_388_608L, 1_767_225_840L, 1),
)

/**
 * Entry point for the iCatch fakes, run as a separate main class so the Gradle
 * `mainClass` (MainKt, the hi3510 fake) stays untouched:
 *   gradlew :simulator:run -PsimMain=IcatchSimulatorKt  (or java -cp ... directly)
 * with SIM_PROFILE choosing ly/qz inside.
 */
fun main() {
    val profile = System.getenv("SIM_PROFILE") ?: "ly"
    require(profile in setOf("ly", "qz")) { "SIM_PROFILE must be ly or qz (the hi3510 fake lives in Main.kt)" }
    val port = (System.getenv("SIM_PORT")?.toIntOrNull()) ?: 8080
    println("RoveCamLink iCatch '$profile' simulator on http://127.0.0.1:$port  (connect in-app via 127.0.0.1:$port)")
    embeddedServer(CIO, port = port, host = "0.0.0.0") {
        if (profile == "ly") lyModule() else qzModule()
    }.start(wait = true)
}

// ---------- LyIC: Novatek ?custom=1&cmd= XML ----------

private fun Application.lyModule() {
    routing {
        get("/") {
            val cmd = call.request.queryParameters["cmd"]
            val par = call.request.queryParameters["par"]
            val str = call.request.queryParameters["str"]
            if (cmd == null) {
                call.respondText("missing cmd", ContentType.Text.Plain, HttpStatusCode.BadRequest)
                return@get
            }
            val body = handleLyCmd(cmd, par, str)
            println("SIM ly: cmd=$cmd par=$par str=$str -> ${body.take(80)}")
            call.respondText(body, ContentType.Text.Xml)
        }
        get("/Novatek/{dir}/{name}") {
            val name = call.parameters["name"] ?: ""
            val wantsThumb = call.request.queryParameters["cmd"] == "4002"
            val lower = name.lowercase()
            val isImage = lower.endsWith(".jpg") || lower.endsWith(".jpeg")
            val bytes = when {
                wantsThumb -> generatedJpeg(name)
                isImage -> generatedJpeg(name)
                else -> fakeVideoBytes(name)
            }
            val ct = if (wantsThumb || isImage) ContentType.Image.JPEG else ContentType.Video.MP4
            call.respondBytes(bytes, ct)
        }
    }
}

private fun handleLyCmd(cmd: String, par: String?, str: String?): String {
    val id = cmd.toIntOrNull()
    when (id) {
        3029 -> return xml("SSID" to "DVR_C5Pro_SIM", "PASSPHRASE" to "1234567890")
        2015 -> return "OK" // RTSP secondary stream open/close; no body the client parses
        2016 -> return xml("Value" to secondsRecorded.toString())
        2017 -> {
            println("SIM ly: photo captured")
            return "OK"
        }
        2001 -> {
            recording = par == "1"
            if (recording) secondsRecorded = 12 else secondsRecorded = 0
            return "OK"
        }
        3001 -> return "OK" // mode change: 0 photo / 1 movie / 2 playback
        3010 -> return "OK" // format
        3011 -> return "OK" // factory reset
        3012 -> return xml("Value" to "1.3.6")
        3014 -> {
            // One <Cmd>/<Status> pair per tracked setting — the shape LyXml.cmdStatusPairs reads.
            return buildString {
                append("<Function>")
                for ((k, v) in lySettings) {
                    append("<Cmd>").append(k).append("</Cmd><Status>").append(v).append("</Status>")
                }
                append("</Function>")
            }
        }
        3015 -> {
            return buildString {
                append("<Function>")
                for (f in lyFiles) {
                    append("<ALLFile>")
                    append("<NAME>").append(f.name).append("</NAME>")
                    append("<FPATH>A:\\").append(f.dir).append("\\").append(f.name).append("</FPATH>")
                    append("<SIZE>").append(f.size).append("</SIZE>")
                    append("<TIMECODE>0</TIMECODE>")
                    append("<TIME>").append(f.time).append("</TIME>")
                    append("<ATTR>33</ATTR>")
                    append("</ALLFile>")
                }
                append("</Function>")
            }
        }
        3017 -> return xml("Value" to "15200")
        3021 -> return "OK" // commit menu writes
        3024 -> return xml("Value" to "1") // card OK
        3029 -> return xml("SSID" to "DVR_C5Pro_SIM", "PASSPHRASE" to "1234567890")
        3030 -> return buildString {
            append("<Function>")
            for (v in lyResolutionOptions) append("<Item><Index>").append(v).append("</Index></Item>")
            append("</Function>")
        }
        3031 -> {
            if (str != "all") return "OK"
            return buildString {
                append("<Function>")
                lyLoopOptions.forEachIndexed { i, v -> append("<Cmd>2003</Cmd><Index>$i</Index><Id>$v</Id>") }
                lySensorOptions.forEachIndexed { i, v -> append("<Cmd>2011</Cmd><Index>$i</Index><Id>$v</Id>") }
                lyMicOptions.forEachIndexed { i, v -> append("<Cmd>8010</Cmd><Index>$i</Index><Id>$v</Id>") }
                lyOnOff.forEachIndexed { i, v -> append("<Cmd>8011</Cmd><Index>$i</Index><Id>$v</Id>") }
                append("</Function>")
            }
        }
        4002 -> return "OK" // thumbnail append; bytes served by /Novatek route
        4003 -> {
            println("SIM ly: delete $str")
            return "OK"
        }
        4004 -> {
            println("SIM ly: delete ALL")
            return "OK"
        }
        8013 -> return xml("Value" to "82")
        3003 -> return "OK" // set SSID
        3004 -> return "OK" // set passphrase
        3005, 3006 -> {
            println("SIM ly: time sync $str")
            return "OK"
        }
        3018 -> return "OK" // reconnect wifi
    }
    // Setting writes: the settings cmds double as their own write (cmd=2003&par=2 etc.).
    if (id != null && par != null && id.toString() in lySettings.keys) {
        lySettings[id.toString()] = par
        return "OK"
    }
    return "OK"
}

private fun xml(vararg pairs: Pair<String, String>): String =
    buildString {
        append("<?xml version=\"1.0\" ?>")
        append("<Function>")
        for ((k, v) in pairs) append("<").append(k).append(">").append(v).append("</").append(k).append(">")
        append("</Function>")
    }

// ---------- QzIC: /app/... JSON ----------

private fun Application.qzModule() {
    routing {
        get("/app/getdeviceattr") { call.respondText("""{"result":0,"info":{"ssid":"QZ_DASH_SIM","mac":"aa:bb:cc:dd:ee:ff"}}""", ContentType.Application.Json) }
        get("/app/getproductinfo") { call.respondText("""{"result":0,"info":{"product":"Qz Dash Sim","swver":"1.0.0","hwver":"2.1","uuid":"SIM-QZ-0001"}}""", ContentType.Application.Json) }
        get("/app/getsdinfo") { call.respondText("""{"result":0,"info":{"status":"0","totalspace":30436,"freespace":15200}}""", ContentType.Application.Json) }
        get("/app/getparamvalue") {
            val param = call.request.queryParameters["param"]
            when (param) {
                "rec" -> call.respondText("""{"result":0,"info":{"value":"${if (recording) "1" else "0"}"}}""", ContentType.Application.Json)
                "all" -> call.respondText(
                    """{"result":0,"info":{"rec_resolution":"${qzSettings["rec_resolution"]}","switchcam":"${qzSettings["switchcam"]}"}}""",
                    ContentType.Application.Json,
                )
                else -> call.respondText("""{"result":0,"info":{"value":"${qzSettings[param] ?: ""}"}}""", ContentType.Application.Json)
            }
        }
        post("/app/getparamvalue") {
            call.receiveText()
            val param = call.request.queryParameters["param"]
            if (param == "all") {
                call.respondText(
                    """{"result":0,"info":{"rec_resolution":"${qzSettings["rec_resolution"]}","switchcam":"${qzSettings["switchcam"]}"}}""",
                    ContentType.Application.Json,
                )
            } else {
                call.respondText("""{"result":0,"info":{"value":"${qzSettings[param] ?: ""}"}}""", ContentType.Application.Json)
            }
        }
        post("/app/getparamitems") {
            call.receiveText()
            val param = call.request.queryParameters["param"]
            if (param == "rec_resolution" || param == "all") {
                call.respondText(
                    """{"result":0,"info":[{"name":"rec_resolution","items":${qzResolutionItems.toQuotedJson()},"index":$qzResolutionIndex}]}""",
                    ContentType.Application.Json,
                )
            } else if (param == "switchcam") {
                call.respondText(
                    """{"result":0,"info":[{"name":"switchcam","items":${qzSwitchItems.toQuotedJson()},"index":$qzSwitchIndex}]}""",
                    ContentType.Application.Json,
                )
            } else {
                call.respondText("""{"result":0,"info":[]}""", ContentType.Application.Json)
            }
        }
        post("/app/setparamvalue") {
            val param = call.request.queryParameters["param"]
            val value = call.request.queryParameters["value"]
            if (param != null && value != null) {
                qzSettings[param] = value
                println("SIM qz: setparamvalue $param=$value")
            }
            call.respondText("""{"result":0,"info":{}}""", ContentType.Application.Json)
        }
        post("/app/enterrecorder") { recording = true; call.respondText("""{"result":0}""", ContentType.Application.Json) }
        post("/app/exitrecorder") { recording = false; call.respondText("""{"result":0}""", ContentType.Application.Json) }
        post("/app/snapshot") { call.respondText("""{"result":0}""", ContentType.Application.Json) }
        get("/app/getfilelist") {
            val folder = call.request.queryParameters["folder"] ?: "loop"
            val matches = qzFiles.filter { it.folder == folder }
            call.respondText(
                """{"result":0,"info":[{"folder":"$folder","files":${matches.joinToString(",", prefix = "[", postfix = "]") { f ->
                    """{"name":"${f.name}","duration":${f.duration},"size":${f.size},"createtime":${f.created},"createtimestr":"2026-01-01 12:00:00","type":${f.type}}"""
                }}}]}""",
                ContentType.Application.Json,
            )
        }
        get("/app/getthumbnail") {
            val file = call.request.queryParameters["file"] ?: ""
            call.respondBytes(generatedJpeg(file), ContentType.Image.JPEG)
        }
        get("/app/deletefile") {
            val file = call.request.queryParameters["file"]
            println("SIM qz: delete $file")
            call.respondText("""{"result":0}""", ContentType.Application.Json)
        }
        get("/app/sdformat") { println("SIM qz: format SD"); call.respondText("""{"result":0}""", ContentType.Application.Json) }
        get("/app/reset") { println("SIM qz: factory reset"); call.respondText("""{"result":0}""", ContentType.Application.Json) }
        get("/app/setsystime") {
            println("SIM qz: time sync ${call.request.queryParameters["date"]}")
            call.respondText("""{"result":0}""", ContentType.Application.Json)
        }
        get("/app/setwifi") {
            println("SIM qz: setwifi ${call.request.queryParameters["wifissid"]} / ${call.request.queryParameters["wifipwd"]?.length ?: 0} chars")
            call.respondText("""{"result":0}""", ContentType.Application.Json)
        }
        get("/app/wifireboot") { call.respondText("""{"result":0}""", ContentType.Application.Json) }
        post("/app/playback") { call.respondText("""{"result":0}""", ContentType.Application.Json) }
        post("/app/setting") { call.respondText("""{"result":0}""", ContentType.Application.Json) }
        // Media download: serve deterministic bytes for any /app/downloadfile or raw path.
        get("/app/downloadfile") {
            val file = call.request.queryParameters["file"] ?: "sim.mp4"
            call.respondBytes(fakeVideoBytes(file), ContentType.Video.MP4)
        }
    }
}

private fun List<String>.toQuotedJson(): String = joinToString(",", prefix = "[", postfix = "]") { "\"$it\"" }

// ---------- shared fakes (kept apart from Main.kt on purpose: no composeApp dependency) ----------
// NOTE: paths below are written as "Novatek-slash-dir" shapes without star sequences —
// a literal `/Novatek/…` inside a Kotlin block comment opens a nested comment and never
// closes (Kotlin supports nested block comments; Java does not).

private fun fakeVideoBytes(name: String): ByteArray {
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

private fun generatedJpeg(name: String, w: Int = 320, h: Int = 180): ByteArray {
    val img = BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
    val seed = name.hashCode()
    val hue = ((seed % 360) + 360) % 360
    for (y in 0 until h) {
        for (x in 0 until w) {
            val fx = x.toFloat() / (w - 1)
            val fy = y.toFloat() / (h - 1)
            val rgb = java.awt.Color.getHSBColor(
                (hue / 360f + fx * 0.15f) % 1f,
                0.45f + 0.35f * fy,
                0.35f + 0.5f * (1f - fy),
            )
            img.setRGB(x, y, rgb.rgb)
        }
    }
    return ByteArrayOutputStream().use { out ->
        ImageIO.write(img, "jpg", out)
        out.toByteArray()
    }
}
