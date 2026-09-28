package com.rovecamlink.app.brand.sjcam

import com.rovecamlink.app.core.model.SdCardState
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Guard for the hisnet channel's `var key = "value";` reader.
 *
 * Two things are being pinned here. First the **probe fingerprint**: the SJ10 MAX model
 * string claims the channel and a TUWIN Ride5 recorder's model string does not — both speak
 * the same CGI dialect, so the model is the only separator (`docs/evidence/sjcam` §5).
 * Second the **parallel-array reader** the file list and the settings menu both rely on
 * (`var path`/`var size`/`var create`, `var item`/`var value`).
 */
class SjcamHisnetParsingTest {

    @Test
    fun `the SJ10 MAX model claims the channel and a TUWIN recorder does not`() {
        val sj10 = """
            var model = "Hi3559V200-DV-IMX458";
            var softversion = "V1.0.9";
        """.trimIndent()
        assertEquals(
            "Hi3559V200-DV-IMX458",
            SjcamHisnetChannel.varOf(sj10, "var model"),
        )
        assertTrue(SjcamHisnetChannel.varOf(sj10, "var model")!!.contains(SjcamHisnetChannel.MODEL_SJ10_MAX))

        // TUWIN Ride5's own identity string (docs/evidence/tuwin §1.2): same CGI, other brand.
        val ride5 = """var model = "HI3516CV610-S-FV-CARRECORDER";"""
        val ride5Model = SjcamHisnetChannel.varOf(ride5, "var model")
        assertEquals("HI3516CV610-S-FV-CARRECORDER", ride5Model)
        assertTrue(ride5Model?.contains(SjcamHisnetChannel.MODEL_SJ10_MAX) != true)
    }

    @Test
    fun `quoted and bare values are both read`() {
        val body = """
            var capacity = 82;
            var charge = "1";
            var workmode = "Normal";
        """.trimIndent()
        assertEquals("82", SjcamHisnetChannel.varOf(body, "var capacity"))
        assertEquals("1", SjcamHisnetChannel.varOf(body, "var charge"))
        assertEquals("Normal", SjcamHisnetChannel.varOf(body, "var workmode"))
    }

    @Test
    fun `parallel arrays keep their document order and alignment`() {
        // The file list's own shape (HisCamera.java:960-1010).
        val body = """
            var path = "/mnt/sd/DCIM/MOVIE/1.MP4";
            var size = "12582912";
            var create = "20260101120000";
            var path = "/mnt/sd/DCIM/PHOTO/2.JPG";
            var size = "2400000";
            var create = "20260101120100";
        """.trimIndent()
        val paths = SjcamHisnetChannel.varsOf(body, "var path")
        val sizes = SjcamHisnetChannel.varsOf(body, "var size")
        val creates = SjcamHisnetChannel.varsOf(body, "var create")
        assertEquals(listOf("/mnt/sd/DCIM/MOVIE/1.MP4", "/mnt/sd/DCIM/PHOTO/2.JPG"), paths)
        assertEquals(listOf("12582912", "2400000"), sizes)
        assertEquals(listOf("20260101120000", "20260101120100"), creates)
    }

    @Test
    fun `the settings menu pairs item with value`() {
        val body = """
            var item = "Resolution";
            var value = "1080P60";
            var item = "Speaker volume";
            var value = "3";
        """.trimIndent()
        val items = SjcamHisnetChannel.varsOf(body, "var item")
        val values = SjcamHisnetChannel.varsOf(body, "var value")
        assertEquals(listOf("Resolution", "Speaker volume"), items)
        assertEquals(listOf("1080P60", "3"), values)
    }

    @Test
    fun `missing keys yield nothing rather than a wrong value`() {
        assertNull(SjcamHisnetChannel.varOf("var other = 1;", "var capacity"))
        assertNull(SjcamHisnetChannel.varOf(null, "var capacity"))
        assertTrue(SjcamHisnetChannel.varsOf("", "var path").isEmpty())
    }

    @Test
    fun `the card word the firmware does not document is never read as OK`() {
        // `getsdstatus.cgi`'s answer is not documented in the APK, so the parse must not guess:
        // `0` and `OK` are the two words the vendor's code itself treats as ready, and anything
        // else must not come back as a healthy card.
        assertEquals(SdCardState.OK, SjcamHisnetChannel.sdStateOf("0"))
        assertEquals(SdCardState.OK, SjcamHisnetChannel.sdStateOf("OK"))
        assertNotEquals(SdCardState.OK, SjcamHisnetChannel.sdStateOf("SOMETHING_ELSE"))
        assertNull(SjcamHisnetChannel.sdStateOf(null))
    }
}
