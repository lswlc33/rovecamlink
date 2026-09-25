package com.rovecamlink.app.core.wifi

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Guard for "what counts as a camera hotspot".
 *
 * The rule is a **union**: what the plugins claim, plus the generic hints
 * ([DEFAULT_PREFIXES]) that predate the registry. The property that matters is
 * one-directional — registering a plugin may only ever make *more* SSIDs match. A new
 * brand must never be able to take a match away from a camera that already worked, and
 * must never have to edit a list shared with every other brand.
 */
class CameraLikePrefixesTest {

    @Test
    fun `a plugin's prefixes are added to the generic hints`() {
        val merged = cameraLikePrefixes(listOf("ACME_CAM_"))
        assertTrue("ACME_CAM_" in merged, "a newly declared prefix must reach the scanner")
        DEFAULT_PREFIXES.forEach { assertTrue(it in merged, "generic hint $it was dropped") }
    }

    @Test
    fun `nothing the generic list matched before stops matching`() {
        // The no-regression property, stated as a test: every SSID the old constant list
        // recognised is still recognised once the registry feeds in.
        val merged = cameraLikePrefixes(listOf("XTUCam_", "TUWIN_R3P_", "TUWIN_R6_"))
        val previouslyMatched = listOf(
            "XTU_abc123",
            "X7_pro",
            "X5-cam",
            "GO_0001",
            "RIDE5_xyz",
            "R3_0001",
            "R6_0001",
            "R5_0001",
            "M3_0001",
            "SJ4000",
            "AKASO_brave7",
        )
        previouslyMatched.forEach { ssid ->
            assertTrue(anyPrefixMatches(merged, ssid), "$ssid used to be listed as a camera")
        }
    }

    @Test
    fun `the union does not duplicate a prefix already generic`() {
        // "XTU" is both a generic hint and a plausible plugin declaration.
        val merged = cameraLikePrefixes(listOf("XTU", "XTUCam_"))
        assertEquals(merged.size, merged.distinct().size, "merged list has duplicates: $merged")
        assertEquals(1, merged.count { it == "XTU" })
    }

    @Test
    fun `matching is case-insensitive, like the firmware's own hotspot names`() {
        val merged = cameraLikePrefixes(listOf("ACME_CAM_"))
        assertTrue(anyPrefixMatches(merged, "acme_cam_01"))
        assertTrue(anyPrefixMatches(merged, "AcMe_CaM_02"))
    }

    @Test
    fun `no SSID at all is never a camera`() {
        val merged = cameraLikePrefixes(listOf("ACME_CAM_"))
        assertFalse(anyPrefixMatches(merged, null))
        assertFalse(anyPrefixMatches(merged, ""))
        assertFalse(anyPrefixMatches(merged, "   "))
    }

    @Test
    fun `an unrelated network does not match`() {
        // The other half of the contract: this is a prefix test, not "any Wi-Fi is a
        // camera". Home routers end up in the list's neighbourhood every day.
        val merged = cameraLikePrefixes(listOf("ACME_CAM_"))
        assertFalse(anyPrefixMatches(merged, "TP-LINK_5G"))
        assertFalse(anyPrefixMatches(merged, "CMCC-Home"))
    }
}
