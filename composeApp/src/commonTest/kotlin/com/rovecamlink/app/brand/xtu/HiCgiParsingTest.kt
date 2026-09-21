package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.brand.xtu.HiVarParser.int
import com.rovecamlink.app.brand.xtu.HiVarParser.mb
import com.rovecamlink.app.core.model.CameraSetting
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Regression tests for the XTU Hisilicon CGI reader, pinned to responses captured
 * verbatim from a real camera.
 *
 * Every literal below is what an XTU S7PRO (Hi3519DV500, firmware
 * 20.8.6.1.20260710, `hardversion=NewAPP`) actually answered during the
 * 2026-09-21 field session exported into `logs/` — including the two shapes that
 * broke the settings page and the record/stop button: the primary menu that puts
 * both of its variables on one line, and a refusal delivered as HTTP 200.
 */
class HiCgiParsingTest {

    /** The captured `getprimarymenuitem.cgi?-workmode=Normal Video` body, one line. */
    private val primaryMenuBody =
        "var item=\"Resolution,Gyro EIS,Segment,Audio,LDC,VideoEncode,Pre-Recording," +
            "Meter Mode,Exposure,Shutter,ISO,AWB,Scene Mode,Sharpness,Image Quality,Filter," +
            "brightness,Contrast,Saturation,EIS Anti-Blur\";" +
            "var cur=\"1080P30,Super Enhance,Auto,ON,ON,H.265,OFF,Average,0,Auto,Auto,Auto," +
            "Auto,High,High,Normal,2,2,2,ON\";"

    @Test
    fun `two var statements on one line are read as two values`() {
        val vars = HiVarParser.parse(primaryMenuBody)
        assertEquals(2, vars.size, "the primary menu must yield exactly `item` and `cur`")
        assertFalse(
            vars.getValue("item").contains("var cur"),
            "the item list swallowed the current-value list — this is the 39-item settings bug",
        )
        assertEquals(20, vars.getValue("item").split(',').size)
        assertEquals(20, vars.getValue("cur").split(',').size)
    }

    @Test
    fun `multi line assignments still parse`() {
        val vars = HiVarParser.parse(
            "var mode=\"Normal Video\";\r\nvar state=\"21\";\r\nvar event=\"0\";\r\nvar pasttime=\"0\";\r\n",
        )
        assertEquals("Normal Video", vars["mode"])
        assertEquals(21, vars.int("state"))
        assertEquals(0, vars.int("pasttime"))
    }

    @Test
    fun `primary menu pairs each item with its own current value`() {
        val menu = HiMenu.parsePrimary(primaryMenuBody)
        assertEquals(20, menu.size)
        assertEquals("Resolution" to "1080P30", menu.first())
        assertEquals("EIS Anti-Blur" to "ON", menu.last())
        assertEquals("VideoEncode" to "H.265", menu[5])
        // The bug this replaces produced 39 rows whose names alternated with values.
        assertFalse(menu.map { it.first }.contains("Super Enhance"), "a value leaked into the name list")
    }

    @Test
    fun `second menu gives the authoritative options and value`() {
        val body = "var item=\"4K30,4K30 HDR,4K30 SuperView,2.7K50,2.7K30,2.7K30 HDR," +
            "1440P60(4:3),1440P30(4:3),1080P120,1080P60,1080P30,1080P30 HDR,1080P30 SuperView," +
            "720P240,720P120,720P60,720P30\";\nvar value=\"1080P30\";\n"
        val item = HiMenu.parseSecondary("Resolution", body)!!
        assertEquals(17, item.options.size)
        assertEquals("1080P30", item.value)
        assertEquals("1440P60(4:3)", item.options[6].value, "a value containing parens must survive the split")
    }

    @Test
    fun `a menu name the camera does not have is dropped, not listed`() {
        // Exactly what the mis-split menu asked for: a *value* used as a name.
        assertNull(HiMenu.parseSecondary("Super Enhance", "SvrFuncResult=\"-2222\""))
        assertNull(HiMenu.parseSecondary("Auto", "SvrFuncResult=\"-2222\""))
    }

    @Test
    fun `gyro eis options keep their non-ascii member`() {
        val item = HiMenu.parseSecondary(
            "Gyro EIS",
            "var item=\"OFF,Super,Super Enhance,Gyro Flow,Tilt Correction,Horizon Stabilization," +
                "360° Horizon Correction\";\nvar value=\"Super Enhance\";\n",
        )!!
        assertEquals(7, item.options.size)
        assertEquals("360° Horizon Correction", item.options.last().value)
    }

    @Test
    fun `sd capacities carry their unit`() {
        val sd = HiVarParser.parse("var sdstate=\"SDOK\";\nvar total=\"59882 MB\";\nvar used=\"18829 MB\";\n")
        assertEquals("SDOK", sd["sdstate"])
        assertEquals(59_882L, sd.mb("total"), "\"59882 MB\" is not an int; reading it as one hid the free space")
        assertEquals(18_829L, sd.mb("used"))
        assertEquals(1_024L, mapOf("k" to "1 GB").mb("k"))
        assertNull(mapOf("k" to "n/a").mb("k"))
    }

    @Test
    fun `a command is refused only when the body says so`() {
        assertTrue(Cgi.verdict("Success").isOk)
        assertTrue(Cgi.verdict(null) is CgiReply.NoAnswer)
        assertFalse(Cgi.verdict("").isOk)
        val rejected = Cgi.verdict("SvrFuncResult=\"0xFFFFF752\"") as CgiReply.Rejected
        assertEquals("-2222", rejected.code, "the camera sends the two's-complement hex of -2222")
        assertTrue(Cgi.explain("-2222").contains("-2222"))
    }

    @Test
    fun `hex and decimal refusals normalise to the same code`() {
        assertEquals("-2222", Cgi.normaliseCode("0xFFFFF752"))
        assertEquals("-2222", Cgi.normaliseCode("-2222"))
        assertEquals("0", Cgi.normaliseCode("0"))
        assertEquals("weird", Cgi.normaliseCode("weird"))
    }

    @Test
    fun `query values are encoded the way the camera's thttpd expects`() {
        assertEquals("Normal%20Video", Cgi.param("Normal Video"))
        assertEquals("Pre-Recording", Cgi.param("Pre-Recording"))
        assertEquals("1080P30", Cgi.param("1080P30"))
        assertEquals("360%C2%B0%20Horizon%20Correction", Cgi.param("360° Horizon Correction"))
    }

    @Test
    fun `on-off menus render as switches`() {
        fun options(vararg values: String) = values.map { CameraSetting.Option(it, it) }
        assertTrue(CameraSetting("Audio", "Audio", "ON", options("ON", "OFF")).isToggle)
        assertTrue(CameraSetting("flip", "Flip", "1", options("1", "0")).isToggle)
        assertFalse(
            CameraSetting("Segment", "Segment", "Auto", options("Auto", "1Min", "3Min")).isToggle,
        )
        val audio = CameraSetting("Audio", "Audio", "ON", options("ON", "OFF"))
        assertEquals("OFF", audio.toggleValue(false))
        assertEquals("ON", audio.toggleValue(true))
    }

}
