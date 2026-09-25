package com.rovecamlink.app.brand.tuwin

import com.rovecamlink.app.core.model.SdCardState
import com.rovecamlink.app.core.model.WorkMode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Guard for TUWIN's probe fingerprint.
 *
 * The positive cases are the two shapes the two sources disagree about (the archive's
 * nested `info` fields, and the flat names the plugin reads itself) — both must be
 * accepted, because a camera that answers either one is a camera this plugin can talk to.
 *
 * The negative cases are the ones that matter more: every body below is a **real reply
 * from another family**, transcribed from the simulators and the reverse-engineering
 * archives. A probe that claims one of them takes that camera away from the plugin that
 * works.
 */
class TuwinStatusTest {

    @Test
    fun `the documented status fields are recognised under the envelope`() {
        // docs/08 01-TUWIN-档案.md §2.1 row 4 — Ride3ProDeviceStatusInfo's own fields.
        val body = """
            {"result":0,"info":{"adapter_status":1,"battery_percent":87,"current_mode":0,
            "mode_active":1,"recording_time":42,"exception_flags":0,"hdr_chk_cnt":3}}
        """.trimIndent()
        assertTrue(TuwinStatus.looksLike(body))
    }

    @Test
    fun `the documented alternate spellings are recognised`() {
        // @SerializedName(alternate={"battery_level"}, value="battery_percent")
        assertTrue(TuwinStatus.looksLike("""{"result":0,"info":{"battery_level":42}}"""))
    }

    @Test
    fun `the names the plugin reads itself are recognised`() {
        // The flat reading list in TuwinRestProtocol.getStatus. Whatever the firmware
        // actually answers, a body carrying one of these is one this plugin consumes.
        assertTrue(TuwinStatus.looksLike("""{"result":0,"battery":87,"record":1}"""))
        assertTrue(TuwinStatus.looksLike("""{"recordtime":42}"""))
        assertTrue(TuwinStatus.looksLike("""{"result":0,"info":{"mode":0}}"""))
    }

    @Test
    fun `an iCatch Qz reply is not TUWIN's`() {
        // /app/getdeviceattr, verbatim from simulator/IcatchSimulator.kt. This is the
        // regression the old `startsWith("{")` rule let through.
        val qz = """{"result":0,"info":{"ssid":"QZ_DASH_SIM","mac":"aa:bb:cc:dd:ee:ff"}}"""
        assertFalse(TuwinStatus.looksLike(qz))
    }

    @Test
    fun `an iCatch Qz SD reply is not TUWIN's`() {
        // /app/getsdinfo, verbatim from the same simulator. It carries a nested `status`,
        // which is why that name is deliberately not part of the fingerprint.
        val qzSd = """{"result":0,"info":{"status":"0","totalspace":30436,"freespace":15200}}"""
        assertFalse(TuwinStatus.looksLike(qzSd))
    }

    @Test
    fun `an iCatch Qz parameter reply is not TUWIN's`() {
        assertFalse(TuwinStatus.looksLike("""{"result":0,"info":{"value":"1"}}"""))
        assertFalse(TuwinStatus.looksLike("""{"result":0,"info":{"rec_resolution":"1080P","switchcam":"0"}}"""))
    }

    @Test
    fun `a Hisilicon CGI reply is not TUWIN's`() {
        // The hi3510 family answers `var name="…";` text, never JSON.
        assertFalse(TuwinStatus.looksLike("""var name="XTU S7PRO"; var softversion="20.8.6.1";"""))
    }

    @Test
    fun `an iCatch Ly reply is not TUWIN's`() {
        assertFalse(TuwinStatus.looksLike("<Function><SSID>DVR_C5Pro</SSID><PASSPHRASE>1234567890</PASSPHRASE></Function>"))
    }

    @Test
    fun `the envelope alone is not evidence`() {
        // Both families use `result` + `info` for every reply, so an empty envelope is
        // exactly the case a shape test cannot tell apart.
        assertFalse(TuwinStatus.looksLike("""{"result":0}"""))
        assertFalse(TuwinStatus.looksLike("""{"result":0,"info":{}}"""))
        assertFalse(TuwinStatus.looksLike("""{"info":"ok"}"""))
    }

    @Test
    fun `nothing at all is not a camera`() {
        assertFalse(TuwinStatus.looksLike(null))
        assertFalse(TuwinStatus.looksLike(""))
        assertFalse(TuwinStatus.looksLike("   "))
        assertFalse(TuwinStatus.looksLike("nope"))
    }

    @Test
    fun `a JSON value that is not an object is not TUWIN's`() {
        // An array or a bare number on this path is somebody else's protocol, and
        // jsonObject would throw on both — the probe must answer, not crash.
        assertFalse(TuwinStatus.looksLike("""[{"battery":87}]"""))
        assertFalse(TuwinStatus.looksLike("""42"""))
        assertFalse(TuwinStatus.looksLike("""{"unterminated":"""))
    }

    @Test
    fun `key case does not decide the verdict`() {
        assertTrue(TuwinStatus.looksLike("""{"RESULT":0,"INFO":{"Battery_Percent":87}}"""))
    }

    // ---- what the reply means ------------------------------------------------

    @Test
    fun `the documented fields are read out of the envelope`() {
        // The shape docs/08 01-TUWIN-档案.md §2.1 row 4 describes: everything inside `info`.
        // Every one of these used to come back null, because the plugin read the top level.
        val status = TuwinStatus.parse(
            statusBody = """{"result":0,"info":{"adapter_status":1,"battery_percent":87,""" +
                """"current_mode":2,"mode_active":1,"recording_time":42,"exception_flags":0}}""",
            sdBody = """{"result":0,"info":{"status":0,"total":30436,"free":15200}}""",
        )
        assertEquals(87, status.battery)
        assertEquals(WorkMode.PLAYBACK, status.mode)
        assertEquals(42, status.videoTimeSec)
        assertEquals(30436L, status.sdTotalMb)
        assertEquals(15200L, status.sdFreeMb)
        assertEquals(SdCardState.OK, status.sdState)
    }

    @Test
    fun `the battery alias is accepted`() {
        // @SerializedName(alternate={"battery_level"}, value="battery_percent")
        val status = TuwinStatus.parse("""{"result":0,"info":{"battery_level":42}}""", null)
        assertEquals(42, status.battery)
    }

    @Test
    fun `a card the firmware calls healthy is not reported as an error`() {
        // The regression: `status = 0` means "fine" on this family, and SdCardState.fromRaw
        // reads it as ERROR because that vocabulary is the hi3510 family's SDOK / NOSD words.
        val ok = TuwinStatus.parse(null, """{"result":0,"info":{"status":0,"total":1,"free":1}}""")
        assertEquals(SdCardState.OK, ok.sdState)
    }

    @Test
    fun `the card codes follow this family, not the other one's words`() {
        fun sd(status: Any?, total: Int?): SdCardState? {
            val fields = buildList {
                if (status != null) add(""""status":${if (status is String) "\"$status\"" else status}""")
                if (total != null) add(""""total":$total""")
            }.joinToString(",")
            return TuwinStatus.parse(null, """{"result":0,"info":{$fields}}""").sdState
        }
        // §5.2.2: 0 = normal, 2 = no card, anything else = 「点击去格式化」.
        assertEquals(SdCardState.MISSING, sd(2, 0))
        assertEquals(SdCardState.ERROR, sd(1, 0))
        assertEquals(SdCardState.ERROR, sd(7, 0))
        // Missing status falls back to the capacity, exactly as the official app does.
        assertEquals(SdCardState.MISSING, sd(null, 30436))
        assertEquals(SdCardState.ERROR, sd(null, 0))
        // A word instead of a code still goes through the shared vocabulary.
        assertEquals(SdCardState.OK, sd("SDOK", 0))
        assertEquals(SdCardState.MISSING, sd("NOSD", 0))
    }

    @Test
    fun `a flat reply is still read`() {
        // Back-compat with the shape the first implementation assumed. Nothing in the
        // archive forbids a firmware answering this way, and dropping it would be a
        // regression for anyone whose camera does.
        val status = TuwinStatus.parse(
            """{"result":0,"battery":55,"recordtime":7}""",
            """{"result":0,"total":100,"free":40}""",
        )
        assertEquals(55, status.battery)
        assertEquals(7, status.videoTimeSec)
        assertEquals(100L, status.sdTotalMb)
        assertEquals(40L, status.sdFreeMb)
    }

    @Test
    fun `recording is never claimed from this family's status`() {
        // Not a guess: there is no recording field in the reply (docs/08 §5.3), so the
        // plugin declares reportsRecordingState = false and this false is never trusted.
        // A `recording_time` that happens to be non-zero must not turn into "recording".
        // The plugin-side flag itself is pinned in PluginCapabilitiesTest.
        val status = TuwinStatus.parse("""{"result":0,"info":{"recording_time":42}}""", null)
        assertEquals(false, status.recording)
    }

    @Test
    fun `another family's reply yields no facts at all`() {
        // The Qz body reaches probe() first, but a mis-routed read must not invent numbers.
        val status = TuwinStatus.parse(
            """{"result":0,"info":{"ssid":"QZ_DASH_SIM","mac":"aa:bb:cc:dd:ee:ff"}}""",
            """{"result":0,"info":{"status":"0","totalspace":30436,"freespace":15200}}""",
        )
        assertEquals(null, status.battery)
        assertEquals(null, status.mode)
        assertEquals(null, status.videoTimeSec)
        assertEquals(null, status.sdTotalMb)
        assertEquals(null, status.sdFreeMb)
        // Note what is *not* asserted: `status` and `status:"0"` are this family's own key,
        // and iCatch's SD body carries one too. Nothing here can tell the two apart, which is
        // exactly why the probe — not the parser — is what keeps a Qz camera on its own
        // plugin, and why that separation is pinned in ProbeExclusivityTest.
    }

    @Test
    fun `a failed request leaves every field unknown rather than zero`() {
        val status = TuwinStatus.parse(null, null)
        assertEquals(null, status.battery)
        assertEquals(null, status.sdState)
        assertEquals(null, status.sdTotalMb)
        assertEquals(0, status.raw.size)
    }

    @Test
    fun `the raw echo carries the firmware's own fields`() {
        // The diagnostics export prints this, so it has to be the camera's keys and not the
        // envelope around them.
        val status = TuwinStatus.parse(
            """{"result":0,"info":{"battery_percent":87,"current_mode":0}}""",
            null,
        )
        assertEquals("87", status.raw["battery_percent"])
        assertEquals("0", status.raw["current_mode"])
        assertEquals(false, "info" in status.raw)
    }

    // ---- device info ---------------------------------------------------------

    @Test
    fun `device info is read out of the envelope`() {
        // §2.1 row 3. Every one of these used to be blank on a camera that answered fine.
        val info = TuwinStatus.deviceInfo(
            """{"result":0,"info":{"model":"RIDE6","uuid":"SIM-0001","soc":"v57",""" +
                """"ssid":"TUWIN_R6_abc","mac":"aa:bb:cc:dd:ee:ff","swver":"1.2.3","hwver":"V2"}}""",
        )
        assertEquals("RIDE6", info?.model)
        assertEquals("1.2.3", info?.softVersion)
        assertEquals("V2", info?.hardVersion)
        assertEquals("SIM-0001", info?.serialNumber)
        assertEquals("aa:bb:cc:dd:ee:ff", info?.mac)
        assertEquals("TUWIN_R6_abc", info?.ssid)
        assertEquals("v57", info?.soc)
    }

    @Test
    fun `the hotspot passphrase never reaches the diagnostics echo`() {
        // The same reply answers `pwd`, and DeviceInfo.raw is printed into exported logs —
        // the exact shape core.model.CameraWifi was introduced to keep secrets out of.
        val info = TuwinStatus.deviceInfo(
            """{"result":0,"info":{"model":"RIDE6","ssid":"TUWIN_R6_abc","pwd":"hunter2"}}""",
        )
        assertEquals("RIDE6", info?.model)
        assertEquals(false, "pwd" in (info?.raw ?: emptyMap()))
        assertFalse(
            (info?.raw ?: emptyMap()).values.any { it.contains("hunter2") },
            "the passphrase leaked into the log echo",
        )
    }

    @Test
    fun `a reply with nothing in it is not device info`() {
        // "the camera said nothing" must stay distinguishable from "no model reported",
        // which the About page renders differently.
        assertEquals(null, TuwinStatus.deviceInfo(null))
        assertEquals(null, TuwinStatus.deviceInfo("nope"))
        assertEquals(null, TuwinStatus.deviceInfo("""{"result":0}"""))
        assertEquals(null, TuwinStatus.deviceInfo("""{"result":0,"info":{}}"""))
    }
}
