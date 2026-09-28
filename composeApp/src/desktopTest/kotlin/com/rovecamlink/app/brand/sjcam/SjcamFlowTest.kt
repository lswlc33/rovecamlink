package com.rovecamlink.app.brand.sjcam

import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.SdCardState
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.transport.CameraHttp
import com.rovecamlink.app.core.transport.createCameraTcp
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpServer
import java.io.File
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import kotlin.concurrent.thread
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import okio.Path.Companion.toPath

/**
 * End-to-end runs of the SJCAM plugin against fakes that speak each channel's wire format —
 * the same shapes the desktop simulator serves (`simulator/.../SjcamSimulator.kt`) and the
 * archive records (`docs/evidence/sjcam` §4).
 *
 * This is the layer the unit tests cannot reach: probe → connect → status → settings →
 * shutter → file list → download, through the real `CameraHttp`/`CameraTcp` and the real
 * plugin dispatch. What it deliberately does **not** prove is that a physical camera answers
 * these bytes — there is no camera, and the archive's §6 says so.
 */
class SjcamFlowTest {

    private val http = CameraHttp()

    // ---------- LY (Novatek): the channel the desktop fake defaults to ----------

    private class LyFake {
        val writes = mutableListOf<Pair<String, String>>()
        var recordSeconds = 0
        var mode = 3
        val settings = linkedMapOf(
            "2002" to "6", "2004" to "0", "2006" to "0", "2008" to "1", "3008" to "1", "3009" to "0",
        )
        private val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)

        val port get() = server.address.port

        private fun fn(vararg pairs: Pair<String, String>) =
            "<Function>" + pairs.joinToString("") { (k, v) -> "<$k>$v</$k>" } + "</Function>"

        fun start(): LyFake {
            server.createContext("/") { ex ->
                val path = ex.requestURI.path
                val params = ex.requestURI.query.orEmpty().split('&').mapNotNull {
                    val i = it.indexOf('=')
                    if (i <= 0) null else it.substring(0, i) to it.substring(i + 1)
                }.toMap()
                when {
                    // Directory pages end with '/'; the file rows below them do not.
                    path.startsWith("/DCIM/") && path.endsWith("/") ->
                        respond(ex, listing(path).toByteArray(), "text/html")
                    path.startsWith("/DCIM/") ->
                        respond(ex, mediaBytes(path), "application/octet-stream")
                    else -> respond(ex, command(params["cmd"], params["par"]).toByteArray(), "text/xml")
                }
            }
            server.start()
            return this
        }

        private fun command(cmd: String?, par: String?): String = when (cmd) {
            "3012" -> fn("Cmd" to "3012", "Status" to "0", "Value" to "660-SJ10X")
            "3016" -> fn("Cmd" to "3016", "Status" to mode.toString())
            "3017" -> fn("Cmd" to "3017", "Status" to "1", "Total" to "30436", "Free" to "11742")
            "3019" -> fn("Cmd" to "3019", "Status" to "0", "Value" to "82")
            "2016" -> fn("Cmd" to "2016", "Status" to "0", "Value" to recordSeconds.toString())
            "3014" -> settings.entries.joinToString("") { (k, v) -> fn("Cmd" to k, "Status" to v) }
            "3001" -> {
                mode = par?.toIntOrNull() ?: mode
                "Success"
            }
            "2001" -> {
                if (par == "0") recordSeconds = 0
                "Success"
            }
            "1001" -> "Success"
            else -> {
                if (par != null && cmd != null && settings.containsKey(cmd)) {
                    settings[cmd] = par
                    writes += cmd to par
                }
                "Success"
            }
        }

        private fun listing(dir: String) = when {
            dir.endsWith("/DCIM/MOVIE/") ->
                row("MOVIE", "20260101120000.MP4", 12_582_912) + row("MOVIE", "20260101120200.MP4", 20_971_520)
            dir.endsWith("/DCIM/PHOTO/") -> row("PHOTO", "20260101120300.JPG", 2_411_724)
            dir.endsWith("/DCIM/EVENT/") -> row("EVENT", "20260101120400.MP4", 8_388_608)
            else -> ""
        }.let { "<html><body><table>\n$it</table></body></html>" }

        private fun row(dir: String, name: String, size: Long) =
            "<tr><td><a href=\"/DCIM/$dir/$name\"><b>$name</b></a><td align=right>$size<td align=right>2026-01-01 12:00\n"

        private fun mediaBytes(path: String): ByteArray =
            if (path.endsWith(".JPG")) ByteArray(2048) { 0x11 } else ByteArray(4096) { 0x22 }

        private fun respond(ex: HttpExchange, bytes: ByteArray, ctype: String) {
            ex.responseHeaders.add("Content-Type", ctype)
            ex.sendResponseHeaders(200, bytes.size.toLong())
            ex.responseBody.use { it.write(bytes) }
        }

        fun stop() = server.stop(0)
    }

    @Test
    fun `the ly channel runs probe connect status settings shutter and files end to end`() {
        val fake = LyFake().start()
        val plugin = SjcamProtocol(http, createCameraTcp())
        try {
            runBlocking {
                assertTrue(plugin.probe("127.0.0.1", fake.port), "the version reply claims the channel")

                val session = plugin.connect("127.0.0.1", fake.port)
                assertEquals(DevicePlatform.SJCAM, session.platform)
                assertEquals("660-SJ10X", session.model)
                assertEquals(SjcamLyChannel.ID, session.extras[SjcamProtocol.EXTRA_CHANNEL])

                val idle = plugin.getStatus(session)
                assertEquals(82, idle.battery)
                assertEquals(30_436L, idle.sdTotalMb)
                assertEquals(11_742L, idle.sdFreeMb)
                assertEquals(SdCardState.OK, idle.sdState)
                assertFalse(idle.recording)

                // Shutter: photo then record, and the status read-back follows the fake's state.
                assertTrue(plugin.capture(session).isOk)
                assertTrue(plugin.record(session, true).isOk)
                fake.recordSeconds = 12
                val recording = plugin.getStatus(session)
                assertTrue(recording.recording)
                assertEquals(12, recording.videoTimeSec)
                assertTrue(plugin.record(session, false).isOk)

                // Settings: the 3014 dictionary, labelled through the vendor's own id names.
                val settings = plugin.getSettings(session)
                assertEquals(6, settings.size)
                val resolution = settings.first { it.id == "2002" }
                assertEquals("录像分辨率", resolution.title)
                assertEquals("6", resolution.value)
                assertTrue(plugin.setSetting(session, "2002", "4").isOk)
                assertEquals(listOf("2002" to "4"), fake.writes)
                assertEquals("4", plugin.readBack(session, "2002")?.value)

                // Mode switch, and the preview URL the photo/video split produces.
                assertTrue(plugin.setMode(session, WorkMode.VIDEO).isOk)
                assertEquals(1, fake.mode)
                assertEquals("rtsp://127.0.0.1:554/xxx.mp4", plugin.previewUrl(session))

                // Files: the camera's HTML listing across all three folders.
                val files = plugin.listFiles(session, 0, 99)
                assertEquals(4, files.size)
                val photo = files.first { it.name.endsWith(".JPG") }
                assertEquals(FileType.PHOTO, photo.type)
                assertEquals("http://127.0.0.1:${fake.port}/DCIM/PHOTO/20260101120300.JPG", photo.downloadUrl)
                assertNotNull(photo.thumbnailUrl, "stills are their own thumbnail on this family")

                // thumbnail + download + delete all reach the fake.
                assertEquals(2048, plugin.thumbnail(session, photo)?.size)
                val dest = File("build/test-output/sjcam-20260101120300.JPG").absolutePath.toPath()
                File(dest.toString()).parentFile?.mkdirs()
                assertEquals(2048L, plugin.download(session, photo, dest, 0L) {})

                val video = files.first { it.name.endsWith(".MP4") }
                assertTrue(plugin.deleteFile(session, video).isOk)
            }
        } finally {
            fake.stop()
        }
    }

    // ---------- hisnet (SJ10 MAX) ----------

    @Test
    fun `the hisnet channel runs the same flow against the CGI set`() {
        val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        val writes = mutableListOf<String>()
        server.createContext("/") { ex ->
            val q = ex.requestURI.query.orEmpty()
            val path = ex.requestURI.path
            val bytes: ByteArray
            val ctype: String
            when {
                path.contains("/mnt/sd/") -> {
                    bytes = ByteArray(1024) { 0x33 }
                    ctype = "application/octet-stream"
                }
                path.endsWith("/getdeviceattr.cgi") -> {
                    bytes = "var model = \"Hi3559V200-DV-IMX458\";\r\n".toByteArray()
                    ctype = "text/plain"
                }
                path.endsWith("/getworkmode.cgi") -> {
                    bytes = "var workmode = \"Normal\";\r\n".toByteArray()
                    ctype = "text/plain"
                }
                path.endsWith("/getworkstate.cgi") -> {
                    bytes = "var running = \"true\";\r\nvar time = 12000;\r\n".toByteArray()
                    ctype = "text/plain"
                }
                path.endsWith("/getbatterystate.cgi") -> {
                    bytes = "var capacity = 77;\r\nvar charge = \"1\";\r\n".toByteArray()
                    ctype = "text/plain"
                }
                path.endsWith("/getsdstatus.cgi") -> {
                    bytes = "var sdstatus = 1;\r\nvar totalspace = 60000;\r\nvar freespace = 30000;\r\n".toByteArray()
                    ctype = "text/plain"
                }
                path.endsWith("/getfilelist.cgi") -> {
                    bytes = (
                        "var path = \"/mnt/sd/DCIM/MOVIE/A.MP4\";\r\nvar size = \"4096\";\r\nvar create = \"20260101120000\";\r\n" +
                            "var path = \"/mnt/sd/DCIM/PHOTO/B.JPG\";\r\nvar size = \"2048\";\r\nvar create = \"20260101120100\";\r\n"
                        ).toByteArray()
                    ctype = "text/plain"
                }
                path.endsWith("/getmedia.cgi") -> {
                    bytes = "var item = \"Resolution\";\r\nvar value = \"1080P60\";\r\n".toByteArray()
                    ctype = "text/plain"
                }
                path.endsWith("/getsetting.cgi") -> {
                    bytes = "var item = \"Speaker volume\";\r\nvar value = \"3\";\r\n".toByteArray()
                    ctype = "text/plain"
                }
                path.contains("setmedia.cgi") || path.contains("setsetting.cgi") ||
                    path.contains("setworkmode.cgi") || path.contains("sendclickkey.cgi") -> {
                    writes += "$path?$q"
                    bytes = "var result = \"success\";\r\n".toByteArray()
                    ctype = "text/plain"
                }
                else -> {
                    bytes = "var result = \"success\";\r\n".toByteArray()
                    ctype = "text/plain"
                }
            }
            ex.responseHeaders.add("Content-Type", ctype)
            ex.sendResponseHeaders(200, bytes.size.toLong())
            ex.responseBody.use { it.write(bytes) }
        }
        server.start()
        val plugin = SjcamProtocol(http, createCameraTcp())
        try {
            runBlocking {
                assertTrue(plugin.probe("127.0.0.1", server.address.port))
                val session = plugin.connect("127.0.0.1", server.address.port)
                assertEquals(SjcamHisnetChannel.ID, session.extras[SjcamProtocol.EXTRA_CHANNEL])

                val status = plugin.getStatus(session)
                assertEquals(77, status.battery)
                assertEquals(true, status.charging)
                assertTrue(status.recording)
                assertEquals(12, status.videoTimeSec)
                assertEquals(WorkMode.VIDEO, status.mode)

                assertEquals(1, plugin.getSettings(session).size)
                assertEquals(1, plugin.getDeviceSettings(session).size)
                val media = plugin.getSettings(session).first()
                assertEquals("media:Resolution", media.id)
                assertTrue(plugin.setSetting(session, media.id, "4K30").isOk)
                assertTrue(plugin.setDeviceSetting(session, "dev:Speaker volume", "7").isOk)
                assertTrue(writes.any { it.contains("setmedia.cgi") && it.contains("option=Resolution") })
                assertTrue(writes.any { it.contains("setsetting.cgi") && it.contains("option=Speaker") })

                // The shutter is the KEY_MENU click; recording has no command on this family.
                assertTrue(plugin.capture(session).isOk)
                assertFalse(plugin.record(session, true).isOk, "no record command exists in the APK")

                val files = plugin.listFiles(session, 0, 10)
                assertEquals(2, files.size)
                assertEquals(FileType.VIDEO, files[0].type)
                assertEquals("http://127.0.0.1:${server.address.port}/mnt/sd/DCIM/MOVIE/A.MP4", files[0].downloadUrl)
                assertEquals(4096L, files[0].sizeBytes)

                assertTrue(plugin.setMode(session, WorkMode.PHOTO).isOk)
                assertTrue(writes.any { it.contains("setworkmode.cgi") && it.contains("workmode=Photo") })
                assertEquals("rtsp://127.0.0.1:554/livestream/12", plugin.previewUrl(session))

                val dest = File("build/test-output/sjcam-hisnet-A.MP4").absolutePath.toPath()
                File(dest.toString()).parentFile?.mkdirs()
                assertEquals(1024L, plugin.download(session, files[0], dest, 0L) {})
            }
        } finally {
            server.stop(0)
        }
    }

    // ---------- Allwinner (V536-CDR) ----------

    @Test
    fun `the allwinner channel reads its menu and controls the camera on the non-80 port`() {
        val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        var recording = false
        server.createContext("/") { ex ->
            val path = ex.requestURI.path
            val q = ex.requestURI.query.orEmpty()
            val cmd = Regex("cmd=(\\d+)").find(q)?.groupValues?.get(1)
            val par = Regex("par=([^&]+)").find(q)?.groupValues?.get(1)
            val json = when {
                path.contains("setdeviceinfo") -> {
                    if (cmd == "1100") recording = par == "1"
                    """{"Value":0}"""
                }
                cmd == "2001" -> """{"device_name":"V536-CDR","software":"V1.1.2"}"""
                cmd == "3030" -> """{"workmode":1}"""
                cmd == "2005" -> """{"RecodStatus":${if (recording) 1 else 0}}"""
                cmd == "3031" -> """{"Menu":[{"Cmd":2002,"Name":"Resolution","Value":1,"Type":3,
                    "MenuList":[{"id":"4K30","Index":0},{"id":"1080P60","Index":11}]}]}"""
                else -> """{"Value":0}"""
            }
            ex.responseHeaders.add("Content-Type", "application/json")
            val bytes = json.toByteArray()
            ex.sendResponseHeaders(200, bytes.size.toLong())
            ex.responseBody.use { it.write(bytes) }
        }
        server.start()
        val plugin = SjcamProtocol(http, createCameraTcp())
        try {
            runBlocking {
                // Discovery hands the plugin port 80; the channel has to find the API itself.
                assertTrue(plugin.probe("127.0.0.1", server.address.port))
                val session = plugin.connect("127.0.0.1", server.address.port)
                assertEquals(SjcamAllwinnerChannel.ID, session.extras[SjcamProtocol.EXTRA_CHANNEL])

                assertTrue(plugin.record(session, true).isOk)
                assertTrue(plugin.getStatus(session).recording)
                val settings = plugin.getSettings(session)
                assertEquals(1, settings.size)
                assertEquals("11", settings[0].value, "Value is an index into MenuList, not the value")
                assertTrue(plugin.setSetting(session, "2002", "0").isOk)
                assertTrue(plugin.capture(session).isOk)
                assertEquals("rtsp://127.0.0.1:8554/ch01", plugin.previewUrl(session))
                // The file browser is a documented gap (the vendor reads a sqlite index).
                assertTrue(plugin.listFiles(session, 0, 10).isEmpty())
            }
        } finally {
            server.stop(0)
        }
    }

    // ---------- Amba (Ambarella) ----------

    /** Session state the fake's replies read, so the flow test can drive it. */
    private class AmbaState {
        var recording = false
        var recordSeconds = 0
    }

    @Test
    fun `the ambarella channel runs the JSON socket flow`() {
        // The Ambarella control port is fixed at 7878 (`SjcamAmbaChannel.PORT`, archive §4.3) —
        // discovery walks hosts on 80, so the channel always dials this one itself.
        val server = ServerSocket(7878)
        val state = AmbaState()
        thread(isDaemon = true, name = "sjcam-amba-fake") {
            while (!server.isClosed) {
                val socket = try {
                    server.accept()
                } catch (t: Exception) {
                    return@thread
                }
                thread(isDaemon = true) { serveAmba(socket, state) }
            }
        }
        val plugin = SjcamProtocol(http, createCameraTcp())
        try {
            runBlocking {
                assertTrue(plugin.probe("127.0.0.1", 7878), "the SJCAM model claims the channel")
                val session = plugin.connect("127.0.0.1", 7878)
                assertEquals(SjcamAmbaChannel.ID, session.extras[SjcamProtocol.EXTRA_CHANNEL])
                assertEquals("SJCAMSJ8PRO", session.model)

                val status = plugin.getStatus(session)
                assertEquals(82, status.battery)
                assertFalse(status.recording)

                assertTrue(plugin.capture(session).isOk)
                assertTrue(plugin.record(session, true).isOk)
                state.recordSeconds = 5
                assertTrue(plugin.getStatus(session).recording)

                val settings = plugin.getSettings(session)
                assertTrue(settings.any { it.id == "normal_record/Resolution" })
                assertTrue(plugin.setSetting(session, "normal_record/Resolution", "1080P60").isOk)

                val files = plugin.listFiles(session, 0, 10)
                assertEquals(2, files.size)
                assertEquals(
                    "http://127.0.0.1/SD/DCIM/100MEDIA/20260101120000.MP4",
                    files[0].downloadUrl,
                    "the /tmp/SD0 path is translated to the camera's HTTP mirror",
                )
                assertTrue(plugin.setMode(session, WorkMode.PHOTO).isOk)
                assertEquals("rtsp://127.0.0.1/live", plugin.previewUrl(session))
                assertEquals("SJCAMSJ8PRO", plugin.getDeviceInfo(session)?.model)
                plugin.onSessionClosed(session)
            }
        } finally {
            server.close()
        }
    }

    /**
     * One JSON request → one JSON reply, per connection, mirroring the Amba SDK session.
     * An HTTP request (the other channels' probe reaching this port) is closed at once so the
     * HTTP client fails fast instead of waiting out its read timeout.
     */
    private fun serveAmba(socket: Socket, state: AmbaState) {
        socket.use { s ->
            s.soTimeout = 5_000
            val input = s.getInputStream()
            val out = s.getOutputStream()
            val buf = ByteArray(4096)
            val acc = StringBuilder()
            while (true) {
                val n = try {
                    input.read(buf)
                } catch (t: Exception) {
                    return
                }
                if (n <= 0) return
                acc.append(String(buf, 0, n))
                val text = acc.toString()
                if (text.startsWith("GET ") || text.startsWith("POST ")) return // another channel probing
                if (!text.endsWith("}")) continue
                acc.setLength(0)
                val msgId = Regex("\"msg_id\":(\\d+)").find(text)?.groupValues?.get(1)?.toIntOrNull() ?: continue
                val reply = when (msgId) {
                    257 -> """{"msg_id":257,"rval":0,"token":123}"""
                    11 -> """{"msg_id":11,"rval":0,"param":{"model":"SJCAMSJ8PRO","sw_version":"1.2.9"}}"""
                    13 -> """{"msg_id":13,"rval":0,"param":82}"""
                    515 -> """{"msg_id":515,"rval":0,"param":${if (state.recording) state.recordSeconds else 0}}"""
                    513 -> {
                        state.recording = true
                        """{"msg_id":513,"rval":0}"""
                    }
                    514 -> {
                        state.recording = false
                        state.recordSeconds = 0
                        """{"msg_id":514,"rval":0}"""
                    }
                    3 -> """{"msg_id":3,"rval":0,"param":{"normal_record":{"Resolution":"4K30","EIS":"on"}}}"""
                    485 -> """{"msg_id":485,"rval":0,"fileinfolist":"/tmp/SD0/DCIM/100MEDIA/20260101120000.MP4;20260101120000;1767225600000;12582912,/tmp/SD0/DCIM/100MEDIA/20260101120100.JPG;20260101120100;1767225660000;2411724"}"""
                    else -> """{"msg_id":$msgId,"rval":0}"""
                }
                out.write(reply.toByteArray())
                out.flush()
            }
        }
    }
}
