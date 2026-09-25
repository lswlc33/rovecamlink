package com.rovecamlink.app

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * The wiring between the plugin registry and the Wi-Fi layer, on the real graph.
 *
 * [com.rovecamlink.app.core.wifi.cameraLikePrefixes] and
 * [com.rovecamlink.app.core.protocol.CameraProtocolRegistry.claimedSsidPrefixes] each have
 * their own test, but neither of those proves the two are **connected**: the scan filter,
 * the auto-connect trigger and the adopt gate all read [AppGraph.cameraSsidPrefixes], and an
 * empty list handed to it would leave every test above passing while no camera hotspot was
 * recognisable. One line in this file is what a new brand's declaration travels along, which
 * is why it gets an assertion of its own.
 */
class AppGraphPrefixWiringTest {

    private val graph = AppGraph()

    @Test
    fun `every registered plugin's declared prefixes reach the Wi-Fi layer`() {
        val claimed = graph.registry.claimedSsidPrefixes
        assertTrue(claimed.isNotEmpty(), "no plugin declares a hotspot prefix — has the registry changed?")
        claimed.forEach { prefix ->
            assertTrue(
                prefix in graph.cameraSsidPrefixes,
                "declared prefix \"$prefix\" never reaches the scanner",
            )
        }
    }

    @Test
    fun `a camera hotspot the plugins claim is recognised`() {
        // The S7Pro's own hotspot name from the 2026-09-21 field session.
        assertTrue(graph.isCameraLikeSsid("XTUCam_f9e5e2"))
        assertTrue(graph.isCameraLikeSsid("TUWIN_R3P_abc123"))
    }

    @Test
    fun `the generic hints still match, so nothing the old list caught is lost`() {
        // The no-regression property at the level the app actually uses it. These names are
        // not what any plugin claims (XTU's own family broadcasts `XTU…`, which the
        // Hisilicon plugin deliberately leaves unclaimed), so they can only match through
        // the merged generic list.
        listOf("XTU_abc123", "RIDE5_xyz", "AKASO_brave7").forEach { ssid ->
            assertTrue(graph.isCameraLikeSsid(ssid), "$ssid stopped being recognised as a camera")
        }
    }

    @Test
    fun `a home router is not a camera`() {
        assertFalse(graph.isCameraLikeSsid("TP-LINK_5G"))
        assertFalse(graph.isCameraLikeSsid(null))
        assertFalse(graph.isCameraLikeSsid(""))
    }
}
