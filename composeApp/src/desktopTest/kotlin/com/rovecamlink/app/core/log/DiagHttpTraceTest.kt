package com.rovecamlink.app.core.log

import com.rovecamlink.app.brand.xtu.HisiliconProtocol
import com.rovecamlink.app.core.transport.CameraHttp
import java.io.File
import java.net.InetSocketAddress
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpServer
import okio.Path.Companion.toPath

/**
 * End-to-end proof that a real camera exchange lands in the exported file.
 *
 * Everything else in the logging stack can be checked with unit tests; this one is
 * the reason the feature exists — a submitted TXT has to show what actually went
 * over the wire, including the failure shapes that used to be swallowed as `null`.
 *
 * Desktop/JVM only because it stands up a real HTTP server (jdk.httpserver) and a
 * real client socket, which is what exercises Ktor + okio + the actor together.
 */
class DiagHttpTraceTest {

    private val varBody = "var name=\"XTU X7 Pro (sim)\";\r\nvar hardversion=\"NewAPP\";\r\nvar softversion=\"20260101.0\";\r\n"

    private fun HttpExchange.reply(status: Int, body: ByteArray, contentType: String = "text/plain") {
        responseHeaders.add("Content-Type", contentType)
        responseHeaders.add("Server", "RoveCamSim/1.0")
        sendResponseHeaders(status, body.size.toLong())
        responseBody.use { it.write(body) }
    }

    private fun startServer(): HttpServer {
        val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        server.createContext("/") { ex ->
            val path = ex.requestURI.path
            val query = ex.requestURI.rawQuery.orEmpty()
            when {
                path.endsWith("/getdeviceattr.cgi") -> ex.reply(200, varBody.encodeToByteArray())
                path.endsWith("/getcurworkmode.cgi") ->
                    ex.reply(200, "var workmode=\"NormalVideo\";\r\n".encodeToByteArray())
                path.endsWith("/getcamerastatus.cgi") ->
                    ex.reply(200, "var status=\"1\";\r\n".encodeToByteArray())
                path.endsWith("/deletefile.cgi") ->
                    // The shape a camera uses to refuse a command: HTTP 500 + a body that explains it.
                    ex.reply(500, "var SvrFuncResult=\"file is protected\";\r\n".encodeToByteArray())
                path.endsWith("/setwifi.cgi") -> ex.reply(200, "Success\r\n".encodeToByteArray())
                path.endsWith("/getfilelistinfoios.cgi") -> ex.reply(
                    200,
                    """[{"path":"MOVIE/2026010112000000.MP4","size":2048,"create":"20260101120000"}]""".encodeToByteArray(),
                )
                path.startsWith("/MOVIE/") -> {
                    val payload = ByteArray(2048) { (it % 251).toByte() }
                    if (query.contains("bytes=")) {
                        ex.responseHeaders.add("Content-Range", "bytes 0-${payload.size - 1}/${payload.size}")
                        ex.reply(206, payload, "video/mp4")
                    } else {
                        ex.reply(200, payload, "video/mp4")
                    }
                }
                else -> ex.reply(404, "nope".encodeToByteArray())
            }
        }
        server.start()
        return server
    }

    @Test
    fun aRealSessionProducesAReadableReport(): Unit = runBlocking {
        val server = startServer()
        try {
            val port = server.address.port
            val http = CameraHttp()
            val proto = HisiliconProtocol(http)
            val op = "c${Diag.nextId()}:test-session"

            Diag.config.minLevel = LogLevel.DEBUG
            Diag.config.captureBodies = true
            Diag.config.captureSecrets = false
            Diag.config.sampleSteadyTraffic = true
            Diag.clear()

            val session = com.rovecamlink.app.core.model.CameraSession(
                host = "127.0.0.1", port = port, platform = com.rovecamlink.app.core.model.DevicePlatform.HISILICON,
                brand = com.rovecamlink.app.core.model.Brand.XTU, model = "sim",
            )
            kotlinx.coroutines.withContext(OpContext(op)) {
                // 1. Happy path: a CGI that answers with the `var k="v"` shape.
                proto.probe(session.host, session.port)
                // 2. A command the camera refuses, with the reason in the body.
                http.getText("http://127.0.0.1:$port/cgi-bin/hi3510/deletefile.cgi?&-name=MOVIE/a.MP4")
                // 3. A passphrase that must never reach the exported file.
                http.getText("http://127.0.0.1:$port/cgi-bin/hi3510/setwifi.cgi?&-wifissid=XTU-1&-wifikey=Sup3rSecretPass")
                // 4. Steady polling, which has to be sampled rather than dumped.
                repeat(25) { proto.getStatus(session) }
                // 5. A file listing plus a real streamed download.
                val files = proto.listFiles(session, 0, 10)
                val dest = File("build/test-output/MOVIE-2026010112000000.MP4").absolutePath.toPath()
                proto.download(session, files.first(), dest, 0L) {}
                // 6. A transport failure: nothing listening on that port.
                http.getText("http://127.0.0.1:1/cgi-bin/hi3510/getdeviceattr.cgi")
                // 7. A 404 with a body.
                http.getText("http://127.0.0.1:$port/cgi-bin/hi3510/nosuch.cgi")
            }
            Diag.awaitDrained()

            val bundle = Diag.exportBundle()
            File("build/diagnostics-sample.txt").apply { parentFile?.mkdirs() }.writeText(bundle)
            println(bundle)

            // ---- header ----
            assertTrue(bundle.contains("format=${Diag.FORMAT_ID}"), "header must declare the grammar")
            assertTrue(bundle.contains("op=$op"), "the operation id must thread into nested lines")
            assertTrue(bundle.contains("config:"), "the export must state what was captured")

            // ---- the exchange detail a developer needs ----
            assertTrue(bundle.contains("getdeviceattr.cgi"), "request URL")
            assertTrue(bundle.contains("var name=\"XTU X7 Pro (sim)\""), "response body preview")
            assertTrue(bundle.contains("RoveCamSim/1.0"), "response headers are part of the diagnosis")
            assertTrue(
                Regex("""deletefile\.cgi\S*\s+-> 500""").containsMatchIn(bundle),
                "non-2xx status with its query intact: ${bundle.lines().filter { "deletefile" in it }}",
            )
            assertTrue(bundle.contains("file is protected"), "the refusal reason in the body")
            assertTrue(Regex("""ms \d+ch""").containsMatchIn(bundle), "duration + body size")

            // ---- redaction ----
            assertFalse(bundle.contains("Sup3rSecretPass"), "a passphrase must never leave the phone by default")
            assertTrue(bundle.contains("wifikey=***"), "masked, but its length is still visible")

            // ---- failures ----
            assertTrue(bundle.contains("FAIL"), "a request with no reply gets its own line")
            assertTrue(
                Regex("""throw=\w*(Connect|Socket|UnknownHost|IO)""").containsMatchIn(bundle),
                "the exception chain names the real cause: ${bundle.lines().filter { "throw=" in it }}",
            )

            // ---- sampling of the poll loop ----
            val pollLines = bundle.lines().filter { "getcamerastatus" in it && "  -> 200" in it }
            assertTrue(pollLines.size <= 3, "25 identical polls must be sampled, got ${pollLines.size}: $pollLines")
            assertTrue(bundle.contains("run=21"), "the surviving line has to report the folded run")
            val summary = bundle.substringAfter("==== SUMMARY ====")
            assertTrue(summary.contains("cgi:getcamerastatus"), "the endpoint table groups polls")
            assertTrue(summary.contains("operations="), "named operations are counted: $summary")

            // ---- downloads ----
            assertTrue(bundle.contains("media:.mp4"), "a media transfer is bucketed by kind, not by file name")
            assertTrue(
                Regex("""STREAM media:\.mp4 200[^\n]*expected=2048""").containsMatchIn(bundle),
                "the stream is reported open with its expected size before the bytes flow",
            )
            assertTrue(Regex("""progress 100% \d+ ?(B|KB)/2 KB""").containsMatchIn(bundle), "milestone progress")

            // ---- the rolling file itself (crash safety) ----
            val path = Diag.sessionFile()
            assertTrue(path != null && File(path).length() > 500, "session file must exist and have content: $path")
            val onDisk = File(path!!).readText()
            assertTrue(onDisk.contains("deletefile.cgi"), "the file holds the same exchanges as the export")
            assertFalse(onDisk.contains("Sup3rSecretPass"), "the file is redacted like the export")
        } finally {
            server.stop(0)
        }
    }
}
