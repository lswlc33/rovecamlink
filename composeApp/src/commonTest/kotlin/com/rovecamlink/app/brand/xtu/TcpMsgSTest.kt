package com.rovecamlink.app.brand.xtu

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * The 72-byte frame is the whole contract of the port-8080 firmware channel, and the
 * camera gives no feedback when it is wrong — it just stops answering. So every offset,
 * the endianness, and the name-slot truncation rule are pinned here rather than discovered
 * on a device.
 */
class TcpMsgSTest {

    @Test fun `frame is 72 bytes with cmd and length as little-endian int32 at offsets 0 and 4`() {
        val bytes = TcpMsgS.encode(cmd = TcpMsgType.RECV_FILE.code, length = 0x12345678, name = "fw.zip")

        assertEquals(72, bytes.size)
        assertContentEquals(
            byteArrayOf(0x02, 0x00, 0x00, 0x00, 0x78, 0x56, 0x34, 0x12),
            bytes.copyOf(8),
        )
    }

    @Test fun `cmd and length are signed int32 so a negative answer code round-trips`() {
        val header = TcpMsgS.decode(TcpMsgS.encode(TcpMsgType.RECV_FAILED.code, -100004, ""))
        assertEquals(TcpMsgType.RECV_FAILED.code, header.cmd)
        assertEquals(-100004, header.length)
    }

    @Test fun `name lands at offset 8 and the rest of the slot stays zero-filled`() {
        val bytes = TcpMsgS.encode(TcpMsgType.RECV_FILE.code, 4096, "fw.zip")

        assertContentEquals("fw.zip".encodeToByteArray(), bytes.copyOfRange(8, 14))
        // The firmware reads the slot as a char[64]: everything after the name has to be 0
        // or the name it logs back is the padding too.
        for (i in 14 until 72) assertEquals(0, bytes[i].toInt(), "byte $i should be zero padding")
    }

    @Test fun `decode round-trips what encode produced`() {
        val header = TcpMsgS.decode(TcpMsgS.encode(cmd = 2, length = 123_456_789, name = "GK1000_20260710.zip"))
        assertEquals(TcpMsgS.Header(2, 123_456_789, "GK1000_20260710.zip"), header)
    }

    @Test fun `a name longer than the slot is capped at 63 bytes and still NUL terminated`() {
        val long = "F".repeat(60) + "_firmware_package_v2.zip"
        val bytes = TcpMsgS.encode(cmd = 2, length = 1, name = long)

        assertEquals(72, bytes.size)
        assertEquals(0, bytes[71].toInt(), "the 64th slot byte must stay 0")
        val header = TcpMsgS.decode(bytes)
        assertEquals(long.take(63), header.name)
        assertEquals(TcpMsgS.NAME_MAX_BYTES, header.name.length)
    }

    @Test fun `the 63-byte cap is measured in bytes and never splits a multi-byte name`() {
        // 62 ASCII bytes plus a 3-byte code point does not fit; the official code would
        // have copied 63 bytes and left the camera half a character (SendSoftActivity.java:113).
        val name = "A".repeat(62) + "摄像头.zip"
        val header = TcpMsgS.decode(TcpMsgS.encode(cmd = 2, length = 1, name = name))

        assertEquals("A".repeat(62), header.name)
    }

    @Test fun `a name the camera fills right up to the slot end is still read back whole`() {
        val bytes = ByteArray(72).also { out ->
            out[0] = 2
            "GK1000-20260710-XTU-S7PRO-FULL-SLOT-IMAGE-0123456789abcdef0123456789ab".take(64).encodeToByteArray()
                .copyInto(out, 8)
        }
        val header = TcpMsgS.decode(bytes)

        assertEquals(2, header.cmd)
        assertEquals(64, header.name.length)
    }

    @Test fun `a short read is refused instead of being guessed at`() {
        assertFailsWith<IllegalArgumentException> { TcpMsgS.decode(ByteArray(71)) }
    }

    @Test fun `every documented command keeps its official ordinal`() {
        // MSG_TYPE.java:4-10 — the app sends ordinal(), so a re-ordered enum silently
        // turns a firmware push into a file request.
        assertContentEquals(
            intArrayOf(0, 1, 2, 3, 4),
            TcpMsgType.entries.map { it.code }.toIntArray(),
        )
    }
}
