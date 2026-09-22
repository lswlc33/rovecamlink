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

    /**
     * A long value drops the parenthetical in a row's trailing slot but keeps it in the
     * picker. `Gyro EIS` answering `360° Horizon Correction` is what squeezed
     * 「陀螺仪防抖」 into one character per line on 2026-09-22.
     */
    @Test
    fun `a long value stays compact on the row and full in the picker`() {
        val long = "360° Horizon Correction"
        assertEquals("360° 全向水平线矫正", MenuCatalog.valueLabel("Gyro EIS", long))
        assertEquals(
            "360° 全向水平线矫正（360° Horizon Correction）",
            MenuCatalog.valueOptionLabel("Gyro EIS", long),
        )
        assertTrue(
            MenuCatalog.valueLabel("Gyro EIS", long).length <= 12,
            "the trailing slot has to stay narrow enough for the title",
        )
    }

    @Test
    fun `group order covers every group exactly once`() {
        assertEquals(SettingGroup.entries.toList().toSet(), MenuCatalog.groupOrder.toSet())
        assertEquals(SettingGroup.entries.size, MenuCatalog.groupOrder.size)
    }

    /**
     * The device menu, same guard as the shooting menu.
     *
     * These 21 names are `-workmode=System` on the XTU S7PRO as exported in the
     * 2026-09-22 field log. The report that asked for them was literally "设备设置没有
     * 中文", so an untranslated row here is a user-visible defect, not a cosmetic one.
     */
    private val s7ProDeviceMenu = listOf(
        "WiFi Frequency", "Wi-Fi", "Auto Dormant", "Auto Power Off", "Language", "Video Format",
        "Frequency", "Voice Volume", "SubScreen Display", "LEDs", "Date Stamp", "Stamp",
        "Power Tone", "Key Tone", "Cap Tone", "Grid", "Quick-Start Switch", "Voice Control",
        "SD Format", "Factory Reset", "Information",
    )

    @Test
    fun `every s7pro device menu item has a Chinese name, a help line and a group`() {
        s7ProDeviceMenu.forEach { name ->
            val meta = assertNotNull(MenuCatalog.deviceOf(name), "$name has no device catalog entry")
            assertTrue(
                meta.zhTitle.any { it.code in 0x4E00..0x9FFF },
                "$name is not translated: ${meta.zhTitle}",
            )
            assertTrue(meta.zhHelp.length >= 12, "$name needs an explanation, not a stub")
            assertTrue(meta.group != DeviceGroup.Other, "$name must be filed under a real group")
        }
    }

    @Test
    fun `the device catalogue knows exactly the items this camera lists`() {
        assertEquals(s7ProDeviceMenu.toSet(), MenuCatalog.knownDeviceItems)
    }

    @Test
    fun `device and shooting menus stay separate axes`() {
        // A `System` item must not answer for a shooting item of the same name, and an
        // unknown name must keep the firmware's own wording on both pages.
        assertEquals(null, MenuCatalog.of("SD Format"))
        assertEquals("存储卡格式化", MenuCatalog.titleOf("SD Format", "SD Format", device = true))
        assertEquals("SD Format", MenuCatalog.titleOf("SD Format", "SD Format"))
        val unknown = "Some New Firmware Item"
        assertEquals(DeviceGroup.Other, MenuCatalog.deviceGroupOf(unknown))
        assertEquals(unknown, MenuCatalog.titleOf(unknown, unknown, device = true))
    }

    @Test
    fun `device values are translated and the firmware spelling stays beside them`() {
        assertEquals("5 GHz（5G）", MenuCatalog.valueLabel("WiFi Frequency", "5G", device = true))
        assertEquals("60 秒（60Sec）", MenuCatalog.valueLabel("Auto Dormant", "60Sec", device = true))
        assertEquals("开（ON）", MenuCatalog.valueLabel("LEDs", "ON", device = true))
        // A language name is already what the user reads; do not decorate it.
        assertEquals("简体中文", MenuCatalog.valueLabel("Language", "简体中文", device = true))
    }

    @Test
    fun `device group order covers every device group exactly once`() {
        assertEquals(DeviceGroup.entries.toList().toSet(), MenuCatalog.deviceGroupOrder.toSet())
        assertEquals(DeviceGroup.entries.size, MenuCatalog.deviceGroupOrder.size)
    }
}
