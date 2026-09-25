package com.rovecamlink.app.ui

import com.rovecamlink.app.core.model.DevicePlatform
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Guard for the supported-devices page's data.
 *
 * The page is a promise to a user holding a camera in their hand: 「这个型号本 App 能连」
 * must never be claimed about a platform that has no protocol plugin, and the model
 * list has to stay aligned with the archive it was transcribed from
 * (`docs/03-品牌型号与协议矩阵.md`) — a typo in a model name there is a user who
 * cannot find their camera here.
 */
class DeviceCatalogTest {

    @Test
    fun `every entry carries a platform the enum knows`() {
        DeviceCatalog.brands.flatMap { it.models }.forEach { m ->
            assertTrue(
                DevicePlatform.entries.contains(m.platform),
                "${m.model} names a platform outside the enum",
            )
        }
    }

    @Test
    fun `brand platform sets are exactly what their models need`() {
        // A brand claiming a platform no model of its uses overstates what 未适配
        // means — the page would mark a brand 未适配 for a chip nobody listed.
        DeviceCatalog.brands.forEach { brand ->
            assertEquals(
                brand.models.map { it.platform }.toSet(),
                brand.platforms,
                "${brand.name}: the platform set and the models disagree",
            )
        }
    }

    @Test
    fun `model names survive a round trip`() {
        // These are the names a user matches against the box. The two CONFIRMED
        // XTU spellings with spaces are the archive's own 命名坑 — one lost space
        // and the row no longer reads as the camera it names.
        val all = DeviceCatalog.brands.flatMap { it.models }.map { it.model }
        assertTrue("XTU S7PRO" in all)
        assertTrue("XTU S7PRO MAX" in all)
        assertTrue("TUWIN Ride3 Pro" in all)
    }

    @Test
    fun `the catalogue covers both brands the archive documents`() {
        assertEquals(listOf("XTU", "TUWIN"), DeviceCatalog.brands.map { it.name })
    }

    @Test
    fun `adaptation follows the registry, not the catalogue`() {
        // A build whose registry covers HISILICON and TUWIN_REST drives the XTU CGI
        // family and TUWIN's Ride models, but not XTU's Ambarella / iCatch models or
        // TUWIN's M3 — so neither brand block may claim full adaptation.
        val partial = setOf(DevicePlatform.HISILICON, DevicePlatform.TUWIN_REST)
        DeviceCatalog.brands.forEach { brand ->
            assertFalse(
                DeviceCatalog.isAdapted(brand) { it in partial },
                "${brand.name} must not read 已适配 while parts of it have no plugin",
            )
        }
        // Every platform registered → the brand is adapted.
        DeviceCatalog.brands.forEach { brand ->
            assertTrue(
                DeviceCatalog.isAdapted(brand) { true },
                "${brand.name} with every plugin present must read 已适配",
            )
        }
    }
}
