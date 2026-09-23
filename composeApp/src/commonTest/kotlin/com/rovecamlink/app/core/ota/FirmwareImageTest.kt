package com.rovecamlink.app.core.ota

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * The image-header guard (`docs/04 §6.1` R1/R2).
 *
 * The bytes are built here from the offsets in `docs/04 §5.4` rather than read from a real
 * image: a 54 MB fixture is not something a unit test should carry, and the thing under test
 * is the parser and the judgement, not the file I/O. The magic is written out literally so
 * that a change to it has to be a deliberate change to this test too.
 */
class FirmwareImageTest {

    private val magic = byteArrayOf(
        0x15, 0x25, 0x12, 0x08, 0xE3.toByte(), 0x9C.toByte(), 0x68, 0x11,
    )

    /** A 256-byte header laid out the way the measured images are. */
    private fun header(
        model: String = "XTUS7PRO",
        version: String = "20.8.6.1.20260910",
        declaredBytes: Long = 54_490_165L,
        headerBytes: Long = 256L,
        magicBytes: ByteArray = magic,
    ): ByteArray {
        val out = ByteArray(FirmwareImage.HEADER_BYTES)
        magicBytes.copyInto(out, 0, 0, minOf(magicBytes.size, 8))
        writeU32(out, 0x0c, declaredBytes)
        writeU32(out, 0x10, headerBytes)
        model.encodeToByteArray().copyInto(out, 0x14, 0, minOf(model.length, 32))
        version.encodeToByteArray().copyInto(out, 0x54, 0, minOf(version.length, 32))
        return out
    }

    private fun writeU32(target: ByteArray, at: Int, value: Long) {
        for (i in 0 until 4) target[at + i] = ((value shr (8 * i)) and 0xFF).toByte()
    }

    @Test
    fun `a matching image is accepted and its own version is read`() {
        val parsed = assertNotNull(FirmwareImage.parse(header()))
        assertEquals("XTUS7PRO", parsed.model)
        assertEquals("20.8.6.1.20260910", parsed.version)
        assertEquals(54_490_165L, parsed.declaredBytes)
        assertEquals(256L, parsed.headerBytes)

        val check = FirmwareImage.judge(parsed, actualBytes = 54_490_165L, expectedModel = "XTUS7PRO")
        assertTrue(check is FirmwareImage.Check.Ok, "expected Ok, got $check")
    }

    @Test
    fun `the camera name's spaces are stripped before the model is compared`() {
        // `getdeviceattr.cgi` answers "XTU S7 Pro"-shaped names; the header says XTUS7PRO.
        // The index's own lookup does the whitespace stripping (and keeps the vendor's
        // casing), so the guard reuses it and the comparison is case-insensitive on top —
        // the two can then never disagree about what this camera is called.
        val expected = GkuFirmwareIndex.firmwareModelOf("XTU S7 Pro")
        assertEquals("XTUS7Pro", expected)
        val check = FirmwareImage.judge(
            FirmwareImage.parse(header(model = "xtus7pro")),
            actualBytes = 54_490_165L,
            expectedModel = expected,
        )
        assertTrue(check is FirmwareImage.Check.Ok, "expected Ok, got $check")
    }

    @Test
    fun `an image for another model is refused, and says which`() {
        val parsed = FirmwareImage.parse(header(model = "XTUMAX3"))
        val check = FirmwareImage.judge(parsed, actualBytes = 54_490_165L, expectedModel = "XTUS7PRO")
        assertTrue(check is FirmwareImage.Check.WrongModel, "expected WrongModel, got $check")
        assertEquals("XTUMAX3", check.found)
        assertEquals("XTUS7PRO", check.expected)
    }

    @Test
    fun `a length that disagrees with the file is refused`() {
        val parsed = FirmwareImage.parse(header(declaredBytes = 54_490_165L))
        val check = FirmwareImage.judge(parsed, actualBytes = 40_000_000L, expectedModel = "XTUS7PRO")
        assertTrue(check is FirmwareImage.Check.Truncated, "expected Truncated, got $check")
        assertEquals(54_490_165L, check.declaredBytes)
        assertEquals(40_000_000L, check.actualBytes)
    }

    @Test
    fun `a model mismatch outranks nothing - it is checked even when the camera reported no model`() {
        // A camera that reports no name cannot have its model checked; the length still is,
        // and the answer is Ok rather than a false refusal.
        val parsed = FirmwareImage.parse(header())
        val check = FirmwareImage.judge(parsed, actualBytes = 54_490_165L, expectedModel = null)
        assertTrue(check is FirmwareImage.Check.Ok, "expected Ok, got $check")
    }

    @Test
    fun `a file with no XTU header is unrecognised rather than accepted`() {
        assertNull(FirmwareImage.parse(ByteArray(256) { 0x42 }))
        val check = FirmwareImage.judge(null, actualBytes = 1000L, expectedModel = "XTUS7PRO")
        assertTrue(check is FirmwareImage.Check.Unrecognised, "expected Unrecognised, got $check")
    }

    @Test
    fun `a right magic with a nonsense header length is still not an image`() {
        // The header-length field is the one field that can be checked against the buffer
        // itself, which is what keeps a coincidental magic from being taken as a header.
        assertNull(FirmwareImage.parse(header(headerBytes = 4096L)))
        assertNull(FirmwareImage.parse(header(headerBytes = 0L)))
    }

    @Test
    fun `a short read is not mistaken for a header`() {
        assertNull(FirmwareImage.parse(header().copyOfRange(0, 64)))
    }

    @Test
    fun `the version field is trimmed of its padding and optional`() {
        val parsed = assertNotNull(FirmwareImage.parse(header(version = "")))
        assertNull(parsed.version, "an empty version field must read as unknown, not as an empty string")
        assertEquals("XTUS7PRO", parsed.model)
    }
}
