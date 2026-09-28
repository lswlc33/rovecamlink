package com.rovecamlink.app.core.net

import com.rovecamlink.app.brand.icatch.IcatchHttpProtocol
import com.rovecamlink.app.brand.sjcam.SjcamProtocol
import com.rovecamlink.app.brand.tuwin.TuwinRestProtocol
import com.rovecamlink.app.brand.xtu.HisiliconProtocol
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.protocol.CameraProtocol
import com.rovecamlink.app.core.protocol.CameraProtocolRegistry
import com.rovecamlink.app.core.transport.CameraHttp
import com.rovecamlink.app.core.transport.createCameraTcp
import com.sun.net.httpserver.HttpServer
import kotlinx.coroutines.runBlocking
import java.net.InetSocketAddress
import java.net.ServerSocket
import kotlin.concurrent.thread
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Which plugin claims which camera — the invariant that keeps a new family from taking
 * somebody else's device.
 *
 * Detection asks the plugins **in registration order** and the first one whose probe says
 * yes wins ([DeviceDiscovery.identify]). So a probe is not a private question about a
 * camera; it is a claim on it. A probe that answers "yes" for a body it does not really
 * recognise silently steals that camera and then drives it with the wrong requests — the
 * failure looks like "this camera does not work", not like a detection bug.
 *
 * The setup is deliberately hostile: **every** path answers with the same family's body, so
 * each plugin is asked its own question and handed a foreign answer. That is the worst case
 * a real camera cannot produce (it would 404 a path it does not implement), which is what
 * makes it a guard rather than a replay.
 *
 * Bodies are transcriptions, not inventions — the XTU one from the hi3510 simulator, the
 * iCatch pair from `IcatchSimulator` (which itself mirrors what the official apps parse),
 * and TUWIN's from `docs/evidence/tuwin` §2.1 row 4.
 */
class ProbeExclusivityTest {

    /** One family's signature reply, and the platform that should claim it. */
    private data class Family(val name: String, val body: String, val platform: DevicePlatform)

    private val xtu = Family(
        name = "XTU hi3510",
        body = "var model=\"X7Pro\";\r\n" +
            "var name=\"XTU X7 Pro (Sim)\";\r\n" +
            "var softversion=\"20.8.6.1.20260710\";\r\n" +
            "var hardversion=\"NewAPP\";\r\n" +
            "var type=\"117\";\r\n",
        platform = DevicePlatform.HISILICON,
    )

    private val tuwin = Family(
        name = "TUWIN REST",
        body = """{"result":0,"info":{"adapter_status":1,"battery_percent":87,"current_mode":0,""" +
            """"mode_active":1,"recording_time":42}}""",
        platform = DevicePlatform.TUWIN_REST,
    )

    private val icatchLy = Family(
        name = "iCatch Ly (Novatek)",
        body = "<Function><SSID>DVR_C5Pro_SIM</SSID><PASSPHRASE>1234567890</PASSPHRASE></Function>",
        platform = DevicePlatform.ICATCH,
    )

    private val icatchQz = Family(
        name = "iCatch Qz",
        body = """{"result":0,"info":{"ssid":"QZ_DASH_SIM","mac":"aa:bb:cc:dd:ee:ff"}}""",
        platform = DevicePlatform.ICATCH,
    )

    /**
     * SJCAM's LY channel answers the **same** `?custom=1&cmd=` vocabulary as iCatch's Ly
     * profile — the claim rests on the model string (`docs/evidence/sjcam` §2.1(b)), which is
     * exactly what this pair of families checks: the SJCAM model is claimed by SJCAM, and
     * iCatch's `<SSID>`-only reply is not.
     */
    private val sjcamLy = Family(
        name = "SJCAM Ly",
        body = "<Function><Cmd>3012</Cmd><Status>0</Status><Value>660-SJ10X</Value></Function>",
        platform = DevicePlatform.SJCAM,
    )

    private val sjcamHisnet = Family(
        name = "SJCAM hisnet (SJ10 MAX)",
        body = "var model = \"Hi3559V200-DV-IMX458\";\r\nvar softversion = \"V1.0.9\";\r\n",
        platform = DevicePlatform.SJCAM,
    )

    private val sjcamAllwinner = Family(
        name = "SJCAM Allwinner (V536)",
        body = """{"device_name":"V536-CDR","software":"V1.1.2"}""",
        platform = DevicePlatform.SJCAM,
    )

    private val families = listOf(xtu, tuwin, icatchLy, icatchQz, sjcamLy, sjcamHisnet, sjcamAllwinner)

    private fun plugins(http: CameraHttp): List<CameraProtocol> = listOf(
        HisiliconProtocol(http, createCameraTcp()),
        TuwinRestProtocol(http),
        IcatchHttpProtocol(http),
        SjcamProtocol(http, createCameraTcp()),
    )

    /** A server that answers every path with [body], whatever path is asked. */
    private fun serverServing(body: String): HttpServer {
        val server = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        server.createContext("/") { exchange ->
            val bytes = body.encodeToByteArray()
            exchange.responseHeaders.add("Content-Type", "text/plain")
            exchange.sendResponseHeaders(200, bytes.size.toLong())
            exchange.responseBody.use { it.write(bytes) }
        }
        server.start()
        return server
    }

    /**
     * The one overlap the hostile matrix allows, named so it cannot grow.
     *
     * The matrix answers *every* path with the same body — including `/cgi-bin/hi3510/…`,
     * which a real SJ10 MAX does not serve at all (it 404s; the hisnet family's paths are
     * under `/cgi-bin/hisnet/`). XTU's hi3510 probe accepts any body containing `var `
     * (`HisiliconProtocol.probe`), and SJCAM's hisnet reply is exactly that shape. So the
     * matrix's "foreign body on every path" premise reaches a case the field cannot: the two
     * CGI dialects are told apart by their path, which the test deliberately flattens.
     *
     * Everything else is held to strict exclusivity, and this set is asserted to be the
     * *complete* list of exceptions — a new accidental claim still fails the test.
     */
    private val knownMatrixOverlaps = setOf(
        "SJCAM hisnet (SJ10 MAX)" to DevicePlatform.HISILICON,
    )

    @Test
    fun `a foreign body is never claimed by the wrong plugin`() {
        val http = CameraHttp()
        for (family in families) {
            val server = serverServing(family.body)
            try {
                val host = server.address.address.hostAddress
                val port = server.address.port
                for (plugin in plugins(http)) {
                    val claimed = runBlocking { plugin.probe(host, port) }
                    val expected = plugin.platform == family.platform
                    if (!expected && (family.name to plugin.platform) in knownMatrixOverlaps) {
                        // The documented exception must still actually overlap — if a probe is
                        // tightened later, the entry has to go rather than linger as a licence.
                        assertTrue(
                            claimed,
                            "${family.name} no longer overlaps ${plugin.platform.displayName}: " +
                                "remove it from knownMatrixOverlaps",
                        )
                        continue
                    }
                    // iCatch owns two profiles (Ly + Qz) that share one platform, so
                    // "expected" is per-platform: both of its replies belong to it.
                    assertEquals(
                        expected,
                        claimed,
                        "${plugin.platform.displayName} claimed a ${family.name} reply " +
                            "(${if (expected) "should have" else "must not have"})",
                    )
                }
            } finally {
                server.stop(0)
            }
        }
    }

    @Test
    fun `detection picks the family that answered, not the first plugin asked`() {
        // The end-to-end version of the rule above, through the real registry and the real
        // walk order. An iCatch Qz camera is the case that used to break: its reply is a
        // JSON object, so a TUWIN probe that only wanted a `{` claimed it, and — because
        // TUWIN is registered before iCatch — it won.
        val http = CameraHttp()
        val registry = CameraProtocolRegistry(plugins(http))
        val server = serverServing(icatchQz.body)
        try {
            val platform = runBlocking {
                DeviceDiscovery(registry, http)
                    .identify(server.address.address.hostAddress, server.address.port)
            }
            assertEquals(DevicePlatform.ICATCH, platform, "a Qz dashboard was misidentified")
        } finally {
            server.stop(0)
        }
    }

    @Test
    fun `detection reports nothing for a host that answers as no camera does`() {
        val http = CameraHttp()
        val registry = CameraProtocolRegistry(plugins(http))
        val server = serverServing("nope")
        try {
            val platform = runBlocking {
                DeviceDiscovery(registry, http)
                    .identify(server.address.address.hostAddress, server.address.port)
            }
            // Null is what sends discovery on to the next candidate host, so "nothing
            // claimed it" must stay distinguishable from "one of them guessed".
            assertEquals(null, platform)
        } finally {
            server.stop(0)
        }
    }

    /**
     * The Ambarella channel is the one SJCAM transport that is not HTTP: session + device info
     * over raw TCP 7878 (`docs/evidence/sjcam` §4.3). It is tested apart from the matrix above
     * because its port is fixed and its probe is a two-message handshake, not a body shape —
     * and what the claim rests on there is again the model string: the same 7878 JSON belongs
     * to every Ambarella product, only `SJCAM…` is this brand's.
     */
    @Test
    fun `the ambarella channel claims its own model over TCP and nothing else`() {
        assertFalse(
            ambaClaimsWith("XTUS6Pro"),
            "an Ambarella camera that is not SJCAM must not be claimed",
        )
        assertTrue(
            ambaClaimsWith("SJCAMSJ8PRO"),
            "an SJ8 Pro (Ambarella) must be claimed by its own plugin",
        )
    }

    /** Serve one 7878 session whose device info reports [model]; return whether SJCAM claimed it. */
    private fun ambaClaimsWith(model: String): Boolean {
        val server = ServerSocket(7878)
        thread(isDaemon = true, name = "amba-fake-$model") {
            try {
                while (!server.isClosed) {
                    val socket = server.accept()
                    thread(isDaemon = true) {
                        socket.use { s ->
                            s.soTimeout = 3_000
                            val input = s.getInputStream()
                            val out = s.getOutputStream()
                            val buf = ByteArray(4096)
                            val accumulated = StringBuilder()
                            while (true) {
                                val n = try {
                                    input.read(buf)
                                } catch (t: java.io.IOException) {
                                    break
                                }
                                if (n <= 0) break
                                accumulated.append(String(buf, 0, n))
                                // The client writes one JSON object per message and waits for a
                                // reply before the next, so a complete object is a complete read.
                                if (!accumulated.endsWith("}")) continue
                                val request = accumulated.toString()
                                accumulated.setLength(0)
                                val reply = when {
                                    request.contains("\"msg_id\":257") ->
                                        """{"msg_id":257,"rval":0,"token":123}"""
                                    request.contains("\"msg_id\":11") ->
                                        """{"msg_id":11,"rval":0,"param":{"model":"$model","sw_version":"1.2.9"}}"""
                                    else -> """{"msg_id":0,"rval":-1}"""
                                }
                                out.write(reply.toByteArray())
                                out.flush()
                            }
                        }
                    }
                }
            } catch (t: java.io.IOException) {
                // Server closed by the test.
            }
        }
        return try {
            runBlocking { SjcamProtocol(CameraHttp(), createCameraTcp()).probe("127.0.0.1", 7878) }
        } finally {
            server.close()
        }
    }

    @Test
    fun `the shipped plugins are distinct and all reachable`() {
        // On the real plugin list, not a fake one: two of the shipped plugins declaring the
        // same platform would leave one of them unreachable — the registry drops it without
        // an error — and the plugin that lost would look like a broken probe.
        val protocols = plugins(CameraHttp())
        val registry = CameraProtocolRegistry(protocols)
        assertEquals(
            protocols.size,
            registry.all().size,
            "two shipped plugins declare the same platform: " +
                protocols.map { it.platform }.groupingBy { it }.eachCount(),
        )
        protocols.forEach { plugin ->
            assertEquals(
                plugin.platform,
                registry.protocolFor(plugin.platform)?.platform,
                "${plugin.platform.displayName} is not reachable through the registry",
            )
        }
    }
}
