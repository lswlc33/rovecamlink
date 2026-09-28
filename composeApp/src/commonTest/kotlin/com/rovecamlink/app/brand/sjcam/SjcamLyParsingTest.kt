package com.rovecamlink.app.brand.sjcam

import com.rovecamlink.app.core.model.FileType
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Guard for the LY (Novatek) channel's parsers and its probe fingerprint.
 *
 * The probe is the load-bearing part. The `?custom=1&cmd=` dialect is shared with iCatch's
 * dash cams (`docs/evidence/idgolive` appendix B), so "some XML came back" must **not** be
 * enough — the claim has to rest on SJCAM's own model vocabulary (`docs/evidence/sjcam` §2.1(b)),
 * and this test holds it to that. The negative bodies below are the other families' real
 * replies, transcribed from the archives and the simulators.
 */
class SjcamLyParsingTest {

    // ---------- probe fingerprint ----------

    @Test
    fun `the vendor's model strings are recognised`() {
        listOf("660-SJ10X", "683-SJ9", "580-SJ20_580", "672-C100", "655-SJ4000WIFI", "658-SJ8AIR", "a10")
            .forEach { assertTrue(SjcamLyChannel.looksLikeSjcamModel(it), "$it should be an SJCAM model") }
    }

    @Test
    fun `another brand's model strings are not claimed`() {
        // iCatch's own dash-cam names (docs/evidence/idgolive §3.1) — the family the LY
        // dialect would otherwise be confused with.
        listOf("DVR_C5Pro", "QZ_DASH", "C5S", "BC2", "", "   ")
            .forEach { assertFalse(SjcamLyChannel.looksLikeSjcamModel(it), "$it must not be claimed") }
    }

    @Test
    fun `the version reply is read from Value and falls back to String`() {
        assertEquals(
            "660-SJ10X",
            SjcamLyChannel.modelOf("<Function><Cmd>3012</Cmd><Status>0</Status><Value>660-SJ10X</Value></Function>"),
        )
        assertEquals(
            "683-SJ9",
            SjcamLyChannel.modelOf("<Function><Cmd>3012</Cmd><String>683-SJ9</String></Function>"),
        )
        // The iCatch Ly handshake reply carries neither tag → no model, so no claim.
        assertNull(
            SjcamLyChannel.modelOf("<Function><SSID>DVR_C5Pro_SIM</SSID><PASSPHRASE>1234567890</PASSPHRASE></Function>"),
        )
    }

    // ---------- cmd=3014 settings dictionary ----------

    @Test
    fun `cmd 3014 is read as a Cmd-to-Status dictionary`() {
        val body = """
            <Function><Cmd>2002</Cmd><Status>2</Status></Function>
            <Function><Cmd>2006</Cmd><Status>0</Status></Function>
            <Function><Cmd>3009</Cmd><Status>1</Status></Function>
        """.trimIndent()
        val settings = SjcamLyChannel.settingsOf(body)
        assertEquals(mapOf("2002" to "2", "2006" to "0", "3009" to "1"), settings)
    }

    @Test
    fun `an unwrapped dictionary is still read`() {
        // Some builds drop the <Function> wrappers; the pairs are still in order.
        val settings = SjcamLyChannel.settingsOf("<Cmd>2002</Cmd><Status>7</Status>")
        assertEquals(mapOf("2002" to "7"), settings)
    }

    // ---------- the camera's HTML directory listing ----------

    private val listing = """
        <html><body><table>
        <tr><td><a href="/DCIM/MOVIE/20260101120000.MP4"><b>20260101120000.MP4</b></a><td align=right>12582912<td align=right>2026-01-01 12:00<td align=right><a href="#"><b>play</b></a>
        <tr><td><a href="/DCIM/MOVIE/20260101120200.MP4"><b>20260101120200.MP4</b></a><td align=right>20971520<td align=right>2026-01-01 12:02<td align=right><a href="#"><b>play</b></a>
        <tr><td><a href="/DCIM/MOVIE/20260101120300.WAV"><b>20260101120300.WAV</b></a><td align=right>1024<td align=right>2026-01-01 12:03<td align=right><a href="#"><b>play</b></a>
        <tr><td><a href="/DCIM/MOVIE/.."><b>..</b></a><td align=right>0<td align=right>-
        </table></body></html>
    """.trimIndent()

    @Test
    fun `listing rows become files with sizes and a download URL`() {
        val files = SjcamLyChannel.parseListing(listing, "192.168.1.254", 80, FileType.VIDEO)
        assertEquals(2, files.size, "the .wav voice note and the .. row are skipped")
        val first = files[0]
        assertEquals("20260101120000.MP4", first.name)
        assertEquals(FileType.VIDEO, first.type)
        assertEquals(12_582_912L, first.sizeBytes)
        assertEquals("http://192.168.1.254:80/DCIM/MOVIE/20260101120000.MP4", first.downloadUrl)
        assertNull(first.thumbnailUrl, "videos have no separate thumbnail path on this family")
    }

    @Test
    fun `photo extensions win over the directory's fallback type`() {
        val body = """<tr><td><a href="/DCIM/MOVIE/1.JPG"><b>1.JPG</b></a><td align=right>2048<td align=right>x"""
        val files = SjcamLyChannel.parseListing(body, "192.168.1.254", 80, FileType.VIDEO)
        assertEquals(1, files.size)
        assertEquals(FileType.PHOTO, files[0].type)
        assertEquals(files[0].downloadUrl, files[0].thumbnailUrl)
    }

    @Test
    fun `an empty or foreign body yields no files`() {
        assertTrue(SjcamLyChannel.parseListing(null, "h", 80, FileType.VIDEO).isEmpty())
        assertTrue(SjcamLyChannel.parseListing("nope", "h", 80, FileType.VIDEO).isEmpty())
    }
}
