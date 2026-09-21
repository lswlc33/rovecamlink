package com.rovecamlink.app.ui

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * Coverage guard for the XTU S7PRO video-mode menu.
 *
 * The 20 names below are what the camera listed in the 2026-09-21 field session
 * (`getprimarymenuitem.cgi?-workmode=Normal Video`). If a firmware update renames
 * or adds an item, the settings page still works — unrecognised items fall through
 * to [SettingGroup.Other] with the firmware's own label — but this test is where a
 * translated name going missing gets noticed instead of silently shipping.
 */
class MenuCatalogTest {

    private val s7ProVideoMenu = listOf(
        "Resolution", "Gyro EIS", "Segment", "Audio", "LDC", "VideoEncode", "Pre-Recording",
        "Meter Mode", "Exposure", "Shutter", "ISO", "AWB", "Scene Mode", "Sharpness",
        "Image Quality", "Filter", "brightness", "Contrast", "Saturation", "EIS Anti-Blur",
    )

    @Test
    fun `every s7pro video menu item has a Chinese name, a help line and a group`() {
        s7ProVideoMenu.forEach { name ->
            val meta = assertNotNull(MenuCatalog.of(name), "$name has no catalog entry")
            assertTrue(
                meta.zhTitle.any { it.code in 0x4E00..0x9FFF },
                "$name is not translated: ${meta.zhTitle}",
            )
            assertTrue(meta.zhHelp.length >= 12, "$name needs an explanation, not a stub")
            assertTrue(meta.group != SettingGroup.Other, "$name must be filed under a real group")
        }
    }

    @Test
    fun `the catalogue knows exactly the items this camera lists`() {
        // Both directions matter: an entry with a name the camera never sends is dead
        // weight that hides typos, and a missing one silently loses its translation.
        assertEquals(s7ProVideoMenu.toSet(), MenuCatalog.knownItems)
    }

    @Test
    fun `the firmware item is still reachable when we have no entry for it`() {
        val unknown = "Some New Firmware Item"
        assertEquals(null, MenuCatalog.of(unknown))
        assertEquals(SettingGroup.Other, MenuCatalog.groupOf(unknown))
        assertEquals(
            unknown,
            MenuCatalog.titleOf(unknown, unknown),
            "an unmapped item must keep the camera's own wording",
        )
    }

    @Test
    fun `values are translated with the firmware spelling kept alongside`() {
        assertEquals("开（ON）", MenuCatalog.valueLabel("Audio", "ON"))
        assertEquals("自动（Auto）", MenuCatalog.valueLabel("Segment", "Auto"))
        assertEquals("超级增强（Super Enhance）", MenuCatalog.valueLabel("Gyro EIS", "Super Enhance"))
        // Resolutions are specifications, not words — leave them alone.
        assertEquals("1080P30", MenuCatalog.valueLabel("Resolution", "1080P30"))
    }

    @Test
    fun `group order covers every group exactly once`() {
        assertEquals(SettingGroup.entries.toList().toSet(), MenuCatalog.groupOrder.toSet())
        assertEquals(SettingGroup.entries.size, MenuCatalog.groupOrder.size)
    }
}
