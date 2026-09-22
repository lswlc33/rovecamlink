package com.rovecamlink.app.brand.xtu

/**
 * The fixed 72-byte header of the XTU firmware socket (port 8080), both directions.
 *
 * Layout, little-endian throughout:
 *
 * ```
 *  [0..3]   int32  cmd     — one of [TcpMsgType]
 *  [4..7]   int32  length  — for RECV_FILE, the byte length of the file being pushed
 *  [8..71]  char[64] name  — the file's **name**, not a path; NUL-padded, never more
 *                           than 63 bytes so slot 64 is guaranteed to terminate it
 * ```
 *
 * The layout is not documented anywhere by the vendor; it is read straight off the
 * official app. `TCP_MSG_S` is a `ByteBuffer.allocate(72)` written as
 * `putInt(cmd); putInt(len); put(szData /* byte[64] */)` with
 * `ByteOrder.nativeOrder()` — little-endian on every camera and phone in this family
 * (_work/xtu_src/sources/com/gku/loginmodule/ui/activity/TCP_MSG_S.java:11-32) — and
 * `RegisterDeviceToServer` hand-rolls the same frame with `toLH()` byte shuffling at
 * offsets 0 / 4 / 8
 * (_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/model/RegisterDeviceToServer.java:12-38).
 * Two independent implementations of the same offsets is what makes the layout safe to
 * rely on; the field evidence that the socket is the real OTA path is in
 * [XtuSocketOtaTransport].
 *
 * This object is pure encode/decode — no socket, no coroutines — so the byte-level
 * contract is unit-testable in `commonTest` (TcpMsgSTest).
 */
object TcpMsgS {
    /** Total frame size; both the write and the read-back are exactly this long. */
    const val SIZE: Int = 72

    /** The `[8..71]` slot, and the 63-byte write cap that keeps its last byte NUL. */
    const val NAME_MAX_BYTES: Int = 63

    private const val CMD_OFFSET = 0
    private const val LEN_OFFSET = 4
    private const val NAME_OFFSET = 8
    private const val NAME_SLOT = 64

    /** A decoded header. [name] is the slot cut at its first NUL. */
    data class Header(val cmd: Int, val length: Int, val name: String)

    /**
     * Build the 72 bytes. [name] is UTF-8 encoded and trimmed **by byte count**, at a
     * code-point boundary: the official copy is
     * `System.arraycopy(name.getBytes(UTF_8), 0, msg.szData, 0, Math.min(name.length(), 63))`
     * (SendSoftActivity.java:113), which measures the cap in *characters* while copying
     * *bytes* — so a Chinese file name can overrun the slot and get sliced mid-sequence.
     * Trimming at a boundary keeps the camera's own UTF-8 decode of the name intact and
     * is the only place the two readings can be reconciled.
     */
    fun encode(cmd: Int, length: Int, name: String): ByteArray {
        val out = ByteArray(SIZE)
        writeIntLe(out, CMD_OFFSET, cmd)
        writeIntLe(out, LEN_OFFSET, length)
        val raw = name.encodeToByteArray()
        val n = utf8Prefix(raw, NAME_MAX_BYTES)
        raw.copyInto(out, NAME_OFFSET, 0, n)
        // Everything past `n` is still 0 from the allocation, which is what terminates
        // the string for the firmware's `char[64]`.
        return out
    }

    /**
     * Read a header back. Accepts anything at least [SIZE] bytes long (the rest of the
     * buffer is the next message or the file itself, so it is not ours to touch).
     */
    fun decode(bytes: ByteArray): Header {
        require(bytes.size >= SIZE) { "a $SIZE-byte header was expected, got ${bytes.size} bytes" }
        return Header(
            cmd = readIntLe(bytes, CMD_OFFSET),
            length = readIntLe(bytes, LEN_OFFSET),
            name = decodeName(bytes),
        )
    }

    private fun decodeName(bytes: ByteArray): String {
        // Cut at the first NUL rather than decoding all 64 bytes: the slot is a C string,
        // and a firmware that answers with a shorter name would otherwise come back with
        // the padding in it.
        val slotEnd = NAME_OFFSET + NAME_SLOT
        var end = slotEnd
        for (i in NAME_OFFSET until slotEnd) {
            if (bytes[i].toInt() == 0) {
                end = i
                break
            }
        }
        // throwOnInvalidSequence: the camera answers with whatever its firmware puts in
        // the slot, and there is no reason to fail a transfer over an unprintable name.
        return bytes.decodeToString(NAME_OFFSET, end, throwOnInvalidSequence = false)
    }

    /** How many leading bytes of [raw] fit in [maxBytes] without splitting a code point. */
    private fun utf8Prefix(raw: ByteArray, maxBytes: Int): Int {
        var n = 0
        while (n < raw.size) {
            val width = utf8Width(raw[n])
            if (n + width > maxBytes) break
            n += width
        }
        return n
    }

    /** Bytes in the UTF-8 sequence starting at [b]; stray continuation bytes count as one. */
    private fun utf8Width(b: Byte): Int {
        val v = b.toInt() and 0xFF
        return when {
            v < 0x80 -> 1
            v >= 0xF0 -> 4
            v >= 0xE0 -> 3
            v >= 0xC0 -> 2
            else -> 1
        }
    }

    private fun writeIntLe(dst: ByteArray, offset: Int, value: Int) {
        dst[offset] = (value and 0xFF).toByte()
        dst[offset + 1] = ((value shr 8) and 0xFF).toByte()
        dst[offset + 2] = ((value shr 16) and 0xFF).toByte()
        dst[offset + 3] = ((value shr 24) and 0xFF).toByte()
    }

    private fun readIntLe(src: ByteArray, offset: Int): Int =
        (src[offset].toInt() and 0xFF) or
            ((src[offset + 1].toInt() and 0xFF) shl 8) or
            ((src[offset + 2].toInt() and 0xFF) shl 16) or
            ((src[offset + 3].toInt() and 0xFF) shl 24)
}

/**
 * The commands that travel in the header's `cmd` field, in the order of the official
 * enum (`GET_FILE, GET_FAILED, RECV_FILE, RECV_FAILED, RECV_RTMP`) whose `ordinal()` the
 * app sends verbatim (_work/xtu_src/sources/com/gku/loginmodule/ui/activity/MSG_TYPE.java:4-10,
 * used as `MSG_TYPE.RECV_FILE.ordinal()` at SendSoftActivity.java:111).
 */
enum class TcpMsgType(val code: Int) {
    /** Phone asking the camera to send a file. */
    GET_FILE(0),

    /** Negative answer to [GET_FILE]. */
    GET_FAILED(1),

    /** Phone announcing a file it is about to push — the firmware-upload command. */
    RECV_FILE(2),

    /** Negative answer to [RECV_FILE]. */
    RECV_FAILED(3),

    /** RTMP stream hand-off (the same socket also carries this; see `sendRtmp2Hisi`). */
    RECV_RTMP(4),
}
