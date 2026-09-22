package com.rovecamlink.simulator

import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.server.request.receive
import io.ktor.server.response.respondBytes
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
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
import java.io.IOException
import java.io.InputStream
import java.net.ServerSocket
import java.net.Socket
import java.security.MessageDigest
import javax.imageio.ImageIO
import kotlin.concurrent.thread

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
private var simTime: String? = null
private var softVersion = "1.0.4"
private var uploadedFirmwareName: String? = null

/**
 * The hotspot this fake camera is broadcasting, and the pair `getwifi.cgi` answers with.
 * Mutated by `setwifi.cgi` so a rename followed by a read-back round-trips the same way
 * the firmware's does — the alternative (two unrelated constants) would let the app's
 * read path pass while its write path was broken.
 */
private var simWifiSsid = "XTUCam_f9e5e2"
private var simWifiKey = "12345678"
private val settings = linkedMapOf(
    "Resolution" to "1080P60",
    "Gyro EIS" to "High",
    "Exposure" to "-1",
    "Meter Mode" to "Average",
    "AWB" to "Auto",
    "AV Out" to "OFF",
)
private val resolutionOptions = listOf("720P100", "1080P60", "2.7K30", "4K30")
private val onOffOptions = listOf("ON", "OFF")

/**
 * The per-row option lists, for the rows the live page's quick-adjust panel reads.
 *
 * `Exposure` is verbatim from the XTU S7PRO's `getsecondmenuitem` answer in the
 * 2026-09-23 field log — **descending**, which is the ordering the slider exists to
 * turn around — and the rest use the vocabulary `MenuCatalog` records from the
 * 2026-09-21 session on the same camera. A fake, but a fake shaped like the real menu,
 * so a change to that panel can be looked at instead of fielded.
 */
private val optionsByName = mapOf(
    "Resolution" to resolutionOptions,
    "Exposure" to listOf("+2", "+1.5", "+1", "+0.5", "0", "-0.5", "-1", "-1.5", "-2"),
    "Meter Mode" to listOf("Average", "Center", "Spot"),
    "AWB" to listOf("Auto", "Daylight", "Cloudy", "Incandescent", "Fluorescent", "Shade"),
    "Gyro EIS" to listOf("OFF", "Low", "Middle", "High", "Super"),
)

private data class SimFile(val path: String, val create: String, val time: Int, val size: Long)

private var files = listOf(
    SimFile("MOVIE/2026010112000000.MP4", "20260101120000", 32, 12_582_912),
    SimFile("DCIM/2026010112010000.JPG", "20260101120100", 0, 2_411_724),
    SimFile("MOVIE/2026010112020000.MP4", "20260101120200", 47, 20_971_520),
    SimFile("DCIM/2026010112030000.JPG", "20260101120300", 0, 3_145_728),
)

private fun varargBody(vararg pairs: Pair<String, String>): String =
    pairs.joinToString("") { (k, v) -> "var $k=\"$v\";\r\n" }

fun main() {
    val port = (System.getenv("SIM_PORT")?.toIntOrNull()) ?: 8080
    // A real camera answers HTTP on 80 and takes firmware on 8080, so its two ports can
    // never collide. One process on one host cannot have both on 8080, hence the separate
    // default here. To exercise the pairing the camera actually uses, run
    // `SIM_PORT=8081 SIM_OTA_TCP_PORT=8080` and connect the app to 127.0.0.1:8081 — the
    // app always dials 8080 for firmware, exactly as the official client does.
    val otaPort = (System.getenv("SIM_OTA_TCP_PORT")?.toIntOrNull()) ?: 8081
    if (otaPort == port) {
        System.err.println("SIM: SIM_OTA_TCP_PORT must differ from SIM_PORT ($port) — one process cannot bind both.")
        kotlin.system.exitProcess(2)
    }
    println("RoveCamLink XTU Hisilicon simulator on http://127.0.0.1:$port  (connect in-app via 127.0.0.1:$port)")
    println("SIM: firmware RECV_FILE on tcp://127.0.0.1:$otaPort (a real camera uses 8080; the app always dials 8080)")
    startFirmwareSocketListener(otaPort, port)
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

            // OTA upload: fileupload.cgi is a POST with a multipart body. We only need
            // the field's filename (it carries the yyyyMMdd version token in real packages).
            post("fileupload.cgi") {
                val body = call.receive<ByteArray>()
                val name = filenameFromMultipart(body)
                uploadedFirmwareName = name
                println("SIM: firmware package uploaded -> ${name ?: "<no filename>"} (${body.size} bytes)")
                call.respondText("Success", ContentType.Text.Plain)
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

/** The firmware's own work state for the situation the fake is in: 20 working, 21 standby. */
private fun workState(): String = if (recording) "20" else "21"

private fun handleCgi(cmd: String, q: io.ktor.http.Parameters): String? = when (cmd) {
    "getdeviceattr" -> varargBody(
        "model" to "X7Pro", "name" to "XTU X7 Pro (Sim)", "serialnum" to "SIM0000001",
        "softversion" to softVersion, "hardversion" to "NewAPP", "type" to "117",
        "region" to "G", "pcbrevision" to "V1.0",
    )
    "getcamerastatus" -> varargBody("count" to files.size.toString(), "status" to workState())
    // The two codes the firmware actually answers: 20 = working (recording, or
    // mid-capture), 21 = standby. This used to answer 0 / 3, and `getStatus` reads
    // `state` first and only falls back to `getcamerastatus` when it is absent — so the
    // app could never observe a recording at all, and the live page's record state was
    // untestable without a real camera.
    "getcurallinfo", "getallinfo" -> varargBody(
        "mode" to workMode, "state" to workState(), "event" to "0",
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
        val opts = optionsByName[name] ?: onOffOptions
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
    "sdcommand" -> {
        // `sdcommand.cgi?-format&-partition=1` from the app's Format SD action:
        // wipe the card so the empty listing is visible in the UI.
        if (q["-format"] != null) {
            files = emptyList()
            println("SIM: SD card formatted — file list cleared")
        }
        varargBody("sdstatus" to "1")
    }
    "setsystime" -> {
        simTime = q["-time"]
        println("SIM: camera clock set to $simTime")
        "Success"
    }
    "setwifi" -> {
        val ssid = q["-wifissid"]
        val key = q["-wifikey"]
        // Mirror the firmware's own behaviour: whatever was not sent stays as it was, so
        // `getwifi` below answers with a real round-trip of a rename rather than a
        // constant, which is the only way the read-back path gets tested honestly.
        if (!ssid.isNullOrEmpty()) simWifiSsid = ssid
        if (!key.isNullOrEmpty()) simWifiKey = key
        println("SIM: camera Wi-Fi set ssid=${ssid ?: "<unchanged>"} key=${if (key.isNullOrEmpty()) "<unchanged>" else "••••"}")
        "Success"
    }
    "getwifi" -> {
        // `getwifi.cgi` is the read half of the rename dialog: the official app's
        // SetDataUtils.getWifiInfor() calls it and only opens the dialog when both keys
        // are present (SetDataUIUtils.java:306).
        println("SIM: getwifi -> $simWifiSsid (key length ${simWifiKey.length})")
        varargBody("wifissid" to simWifiSsid, "wifikey" to simWifiKey)
    }
    "reset" -> {
        recording = false
        workMode = "NormalVideo"
        settings.clear()
        println("SIM: factory reset")
        "Success"
    }
    "upgrade" -> {
        // upgrade.cgi applies the previously-uploaded package. Real firmware carries a
        // yyyyMMdd version token in its file name, so echo that back as the new version —
        // exactly what the app's post-install version-confirm will compare against.
        val name = uploadedFirmwareName
        if (name != null) {
            val next = Regex("\\d{8}").find(name)?.value
            if (next != null) {
                softVersion = "$next.0"
            }
            uploadedFirmwareName = null
            println("SIM: firmware upgrade applied -> softversion=$softVersion (camera rebooting)")
            "Success"
        } else {
            "no firmware"
        }
    }

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

/**
 * Extracts the `filename="..."` from a multipart body without a full parser — we send a
 * known layout, so the first match on the ISO-8859-1 (byte-transparent) decode is enough.
 */
private fun filenameFromMultipart(body: ByteArray): String? {
    val text = body.toString(Charsets.ISO_8859_1)
    val m = Regex("""filename="([^"]+)"""", RegexOption.IGNORE_CASE).find(text) ?: return null
    return m.groupValues[1].takeIf { it.isNotEmpty() }
}

// ---------- firmware socket: the OTA channel that is not HTTP ----------

/** The XTU frame: int32 cmd, int32 payload length, char[64] name — all little-endian. */
private const val OTA_FRAME_BYTES = 72
private const val OTA_NAME_OFFSET = 8
private const val OTA_NAME_SLOT = 64
private const val OTA_MD5_CHARS = 32

/** The app's chunk size (`byte[] bArr2 = new byte[65536]`, SendSoftActivity.java:140). */
private const val OTA_CHUNK_BYTES = 65_536

/**
 * The camera's firmware channel is a raw TCP socket on port 8080, not a CGI: the official
 * app dials `createSocket(ip, 8080)` (SendSoftActivity.java:108), writes one [OTA_FRAME_BYTES]-byte
 * header (TCP_MSG_S.java:11-32) carrying `RECV_FILE`, the file's byte length and its
 * **name**, waits for the camera to echo a header with the same cmd, then writes the
 * file's MD5 as 32 ASCII hex characters and streams the package. Nothing comes back at
 * the end — the camera reboots as it takes the image, and the official client calls the
 * last write success (SendSoftActivity.java:191-192) — so this listener answers the
 * handshake, discards the bytes while hashing them, and applies the same version
 * bookkeeping `upgrade.cgi` does on the CGI channel.
 *
 * [com.rovecamlink.app.brand.xtu.TcpMsgS] on the app side defines the same layout. It is
 * re-typed here rather than imported on purpose: the simulator has no dependency on
 * `composeApp`, and a fake that shares the client's protocol code cannot disagree with it,
 * which is the only reason a fake exists.
 *
 * **Port:** a real camera serves CGI and this socket on the *same* 8080, which one process
 * on one host cannot do, so the two are split by default (CGI 8080, this 8081) and refused
 * when they are set equal. To exercise the socket channel the way the app will use it — it
 * always dials `host:8080`, like the official client — run
 * `SIM_PORT=8081 SIM_OTA_TCP_PORT=8080` and connect in-app to `127.0.0.1:8081`.
 */
private fun startFirmwareSocketListener(otaPort: Int, cgiPort: Int) {
    val server = try {
        ServerSocket(otaPort)
    } catch (t: IOException) {
        println("SIM: firmware socket could NOT bind tcp://127.0.0.1:$otaPort — ${t.message}")
        if (otaPort == cgiPort) {
            println("SIM:   CGI and the firmware socket both want $otaPort; run the CGI side elsewhere (SIM_PORT=${otaPort + 1})")
        }
        return
    }
    thread(isDaemon = true, name = "sim-firmware-socket") {
        println("SIM: firmware socket listening on tcp://127.0.0.1:$otaPort (RECV_FILE)")
        while (true) {
            val connection = try {
                server.accept()
            } catch (t: IOException) {
                println("SIM: firmware socket listener stopped: ${t.message}")
                return@thread
            }
            thread(isDaemon = true, name = "sim-firmware-receive") { receiveFirmwarePackage(connection) }
        }
    }
}

/** One firmware push: handshake, then consume the package and report what actually arrived. */
private fun receiveFirmwarePackage(connection: Socket) {
    try {
        connection.use { socket ->
            // Generous, but armed: without it a client that dies mid-stream parks this
            // thread forever, and the log would just stop explaining itself.
            socket.soTimeout = 120_000
            val input = socket.getInputStream()
            val output = socket.getOutputStream()

            val header = input.readExactly(OTA_FRAME_BYTES)
            if (header == null) {
                println("SIM: firmware socket closed before a full $OTA_FRAME_BYTES-byte header")
                return
            }
            val cmd = littleEndianInt(header, 0)
            val advertised = littleEndianInt(header, 4)
            val name = cString(header, OTA_NAME_OFFSET, OTA_NAME_SLOT)
            println("SIM: firmware push cmd=$cmd name=$name advertised=${advertised}B — answering with the same cmd")

            output.write(encodeFrame(cmd, 0, ""))
            output.flush()

            val givenMd5 = input.readExactly(OTA_MD5_CHARS)?.toString(Charsets.US_ASCII)
            if (givenMd5 == null) {
                println("SIM: firmware push aborted: no $OTA_MD5_CHARS-character MD5 arrived after the handshake")
                return
            }

            // The rest is the package. Real images are tens of megabytes, so this hashes as
            // it goes and keeps none of it — the same depth of "virtual SD card" that
            // fileupload.cgi has, which also only remembers the name it was given.
            val digest = MessageDigest.getInstance("MD5")
            val chunk = ByteArray(OTA_CHUNK_BYTES)
            var received = 0L
            while (true) {
                val read = input.read(chunk)
                if (read <= 0) break
                digest.update(chunk, 0, read)
                received += read
            }
            val computed = digest.digest().joinToString("") { (it.toInt() and 0xFF).toString(16).padStart(2, '0') }
            println("SIM: firmware package received name=$name advertised=${advertised}B actual=${received}B md5(given)=$givenMd5 md5(computed)=$computed")
            if (givenMd5 != computed) println("SIM:   MD5 MISMATCH — a real camera would reject the image here")

            // This channel has no upgrade.cgi follow-up: the image is applied as it lands, so
            // the version bookkeeping happens here, off the same yyyyMMdd name token.
            uploadedFirmwareName = name
            val next = Regex("\\d{8}").find(name)?.value
            if (next != null) {
                softVersion = "$next.0"
                uploadedFirmwareName = null
                println("SIM: firmware upgrade applied -> softversion=$softVersion (camera rebooting)")
            }
        }
    } catch (t: IOException) {
        println("SIM: firmware socket broke mid-transfer: ${t.message}")
    }
}

/** Fill-loop read of exactly [n] bytes, or null if the peer stops short of that. */
private fun InputStream.readExactly(n: Int): ByteArray? {
    val dst = ByteArray(n)
    var off = 0
    while (off < n) {
        val read = read(dst, off, n - off)
        if (read <= 0) return null
        off += read
    }
    return dst
}

private fun littleEndianInt(src: ByteArray, offset: Int): Int =
    (src[offset].toInt() and 0xFF) or
        ((src[offset + 1].toInt() and 0xFF) shl 8) or
        ((src[offset + 2].toInt() and 0xFF) shl 16) or
        ((src[offset + 3].toInt() and 0xFF) shl 24)

private fun putLittleEndianInt(dst: ByteArray, offset: Int, value: Int) {
    dst[offset] = (value and 0xFF).toByte()
    dst[offset + 1] = ((value shr 8) and 0xFF).toByte()
    dst[offset + 2] = ((value shr 16) and 0xFF).toByte()
    dst[offset + 3] = ((value shr 24) and 0xFF).toByte()
}

private fun encodeFrame(cmd: Int, length: Int, name: String): ByteArray {
    val out = ByteArray(OTA_FRAME_BYTES)
    putLittleEndianInt(out, 0, cmd)
    putLittleEndianInt(out, 4, length)
    val raw = name.toByteArray(Charsets.UTF_8)
    // One byte short of the slot, so the answer always terminates.
    raw.copyInto(out, OTA_NAME_OFFSET, 0, minOf(raw.size, OTA_NAME_SLOT - 1))
    return out
}

/** The NUL-terminated string in the [offset]..[offset]+[slot] window; the slot may be filled right to its end. */
private fun cString(src: ByteArray, offset: Int, slot: Int): String {
    val limit = offset + slot
    var end = limit
    for (i in offset until limit) {
        if (src[i].toInt() == 0) {
            end = i
            break
        }
    }
    return src.decodeToString(offset, end, throwOnInvalidSequence = false)
}
