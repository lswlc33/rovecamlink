package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.Brand
import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.LiveBitrate
import com.rovecamlink.app.core.model.LiveConfig
import com.rovecamlink.app.core.model.LiveFps
import com.rovecamlink.app.core.model.LiveResolution
import com.rovecamlink.app.core.transport.CameraTcp
import com.rovecamlink.app.core.transport.CameraTcpConnection
import java.io.IOException
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking

/**
 * The live hand-off is four wire facts the firmware never complains about: the 72-byte
 * header's command and length, the go-ahead read, the payload's byte-exact text, and the
 * order those happen in. A camera that is handed a wrong `res:` value does not answer — it
 * just sits there — so none of this is discoverable on a device.
 *
 * The socket itself is faked rather than stood up on 8080: [XtuRtmpPush] opens the
 * firmware's fixed port by constant, not by anything a caller can pass, and a test that
 * squats on 8080 either fails on a machine that is already using it or silently stops
 * testing the real thing. What is checked here is the exchange
 * [CameraTcpConnection] carries, which is where all four facts live.
 *
 * Desktop/JVM only, for `runBlocking` — the same rule the rest of `desktopTest` follows.
 */
class XtuRtmpPushTest {

    private val session = CameraSession(
        host = "192.168.1.77",
        port = 80,
        platform = DevicePlatform.HISILICON,
        brand = Brand.XTU,
        model = "XTU S7PRO",
    )

    private val config = LiveConfig(
        ssid = "LiveNet",
        password = "secret",
        rtmpUrl = "rtmp://push.example.com/live/key123",
        resolution = LiveResolution.R1080,
        fps = LiveFps.F30,
        bitrate = LiveBitrate.Smooth,
    )

    /** What the vendor app's `TCPClient.format` produces, spelled out rather than rebuilt. */
    private val expectedPayload =
        "ssid:LiveNet;pwd:secret;live_type:tiktokCN;res:1080;fps:30;rtmp_url:rtmp://push.example.com/live/key123;"

    private fun goAhead(length: Int = 0) = TcpMsgS.encode(TcpMsgType.RECV_RTMP.code, length, "")

    @Test
    fun `the header announces RECV_RTMP on the firmware port with no name`() = runBlocking {
        val tcp = FakeTcp()
        assertEquals(CmdResult.Ok, XtuRtmpPush(tcp).start(session, config))

        assertEquals(Triple("192.168.1.77", 8080, 5000), tcp.opened)
        assertEquals(XtuRtmpPush.RTMP_TCP_PORT, tcp.opened!!.second)
        assertEquals(72, tcp.conn.writes.first().size, "the first thing on the wire is one full frame")

        val header = TcpMsgS.decode(tcp.conn.writes.first())
        assertEquals(TcpMsgType.RECV_RTMP.code, header.cmd)
        assertEquals(expectedPayload.length, header.length)
        assertEquals("", header.name, "an empty name slot: the payload is announced by the length alone")
    }

    @Test
    fun `the payload goes out verbatim and only after the camera answers`() = runBlocking {
        val tcp = FakeTcp()
        assertEquals(CmdResult.Ok, XtuRtmpPush(tcp).start(session, config))

        assertEquals(2, tcp.conn.writes.size, "a header and then a payload — nothing else")
        assertEquals(expectedPayload, tcp.conn.writes[1].decodeToString())
        assertEquals(1, tcp.conn.reads, "exactly one read: no completion packet is waited for")
        assertTrue(tcp.conn.closed, "the sender closes the link; the camera pushes from there")
    }

    @Test
    fun `a camera that answers another command is refused and never gets the payload`() = runBlocking {
        // The vendor's own refusal shape: RECV_FAILED carrying a negative code.
        val tcp = FakeTcp(answer = TcpMsgS.encode(TcpMsgType.RECV_FAILED.code, -100004, ""))
        val result = XtuRtmpPush(tcp).start(session, config)

        val failure = result as CmdResult.Failure
        assertEquals(XtuRtmpPush.ERR_CMD_MISMATCH, failure.code)
        assertEquals(1, tcp.conn.writes.size, "the payload must not be written after a refusal")
        assertTrue(tcp.conn.closed)
    }

    @Test
    fun `a camera that says nothing fails the handshake and gets no payload`() = runBlocking {
        val tcp = FakeTcp(answer = null)
        val result = XtuRtmpPush(tcp).start(session, config)

        assertEquals(XtuRtmpPush.ERR_HANDSHAKE_READ, (result as CmdResult.Failure).code)
        assertEquals(1, tcp.conn.writes.size)
        assertTrue(tcp.conn.closed)
    }

    @Test
    fun `a socket that will not open keeps the vendor's error family`() = runBlocking {
        val tcp = FakeTcp(openError = IOException("Connection refused"))
        val result = XtuRtmpPush(tcp).start(session, config)

        val failure = result as CmdResult.Failure
        assertEquals(XtuRtmpPush.ERR_CONNECT, failure.code)
        assertTrue(failure.message.contains("Connection refused"), "the cause belongs in the log line: ${failure.message}")
    }

    @Test
    fun `a header that will not go out is reported before anything is sent`() = runBlocking {
        val tcp = FakeTcp(headerWriteError = IOException("Broken pipe"))
        val result = XtuRtmpPush(tcp).start(session, config)

        assertEquals(XtuRtmpPush.ERR_HEADER_WRITE, (result as CmdResult.Failure).code)
        assertEquals(0, tcp.conn.writes.size)
        assertTrue(tcp.conn.closed)
    }

    @Test
    fun `a payload that will not go out is reported on its own`() = runBlocking {
        val tcp = FakeTcp(payloadWriteError = IOException("Broken pipe"))
        val result = XtuRtmpPush(tcp).start(session, config)

        assertEquals(XtuRtmpPush.ERR_PAYLOAD_WRITE, (result as CmdResult.Failure).code)
        assertEquals(1, tcp.conn.writes.size, "the header made it; only the payload did not")
    }

    @Test
    fun `the length field counts characters the way the vendor app counts them`() = runBlocking {
        // `s32DataLen` is `payload.length()` on a String while the bytes written are UTF-8
        // (BroadcastDouyinFragment3). For a non-ASCII SSID the two disagree, and the
        // firmware has only ever been handed the smaller number.
        val chinese = config.copy(ssid = "客厅网络", password = "")
        val tcp = FakeTcp()
        assertEquals(CmdResult.Ok, XtuRtmpPush(tcp).start(session, chinese))

        val payload = XtuRtmpPush.payload(chinese)
        assertEquals("ssid:客厅网络;pwd:;live_type:tiktokCN;res:1080;fps:30;rtmp_url:rtmp://push.example.com/live/key123;", payload)
        assertEquals(payload.length, TcpMsgS.decode(tcp.conn.writes.first()).length)
        assertTrue(
            payload.encodeToByteArray().size > payload.length,
            "the fixture has to be multi-byte or it proves nothing",
        )
        assertContentEquals(payload.encodeToByteArray(), tcp.conn.writes[1])
    }

    @Test
    fun `an open network is handed over with an empty pwd field`() = runBlocking {
        val tcp = FakeTcp()
        assertEquals(CmdResult.Ok, XtuRtmpPush(tcp).start(session, config.copy(password = "")))

        assertTrue(tcp.conn.writes[1].decodeToString().contains("pwd:;"), "the field stays, the value is empty")
    }

    @Test
    fun `the payload spells every field, in the vendor's order, with a trailing separator`() {
        // Field order and the `;` after every field — including the last — are the
        // official shape. A "tidier" rendering is a different command to the firmware.
        assertEquals(expectedPayload, XtuRtmpPush.payload(config))
        assertEquals(
            "ssid:Net;pwd:pw;live_type:tiktokCN;res:720;fps:25;rtmp_url:rtmp://h/s;",
            XtuRtmpPush.payload(
                config.copy(
                    ssid = "Net",
                    password = "pw",
                    rtmpUrl = "rtmp://h/s",
                    resolution = LiveResolution.R720,
                    fps = LiveFps.F25,
                ),
            ),
        )
    }

    @Test
    fun `the port is the firmware's own constant`() {
        // Hard-coded in the vendor client and shared with the OTA push: not the CGI port
        // and not derived from it.
        assertEquals(8080, XtuRtmpPush.RTMP_TCP_PORT)
    }

    // ---- the fake socket -------------------------------------------------------------

    /**
     * A [CameraTcp] with no socket behind it, recording what a camera would have seen and
     * replaying whatever answer a test asks for. [answer] = null models a camera that
     * accepts the connection and then says nothing.
     */
    private class FakeTcp(
        private val answer: ByteArray? = TcpMsgS.encode(TcpMsgType.RECV_RTMP.code, 0, ""),
        private val openError: Throwable? = null,
        private val headerWriteError: Throwable? = null,
        private val payloadWriteError: Throwable? = null,
    ) : CameraTcp {
        var opened: Triple<String, Int, Int>? = null
        lateinit var conn: FakeConn

        override suspend fun open(host: String, port: Int, timeoutMs: Int): CameraTcpConnection {
            opened = Triple(host, port, timeoutMs)
            openError?.let { throw it }
            conn = FakeConn(answer, headerWriteError, payloadWriteError)
            return conn
        }
    }

    private class FakeConn(
        private val answer: ByteArray?,
        private val headerWriteError: Throwable?,
        private val payloadWriteError: Throwable?,
    ) : CameraTcpConnection {
        val writes = mutableListOf<ByteArray>()
        var reads = 0
        var closed = false

        override suspend fun write(bytes: ByteArray, offset: Int, count: Int) {
            when (writes.size) {
                0 -> headerWriteError?.let { throw it }
                1 -> payloadWriteError?.let { throw it }
            }
            writes.add(bytes.copyOfRange(offset, offset + count))
        }

        override suspend fun readFully(dst: ByteArray): Boolean {
            reads++
            val a = answer ?: return false
            a.copyInto(dst, 0, 0, minOf(a.size, dst.size))
            return true
        }

        override fun flush() = Unit

        override suspend fun close() {
            closed = true
        }
    }
}