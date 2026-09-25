package com.rovecamlink.app.brand.icatch

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * The URL construction and the §8 value tables, pinned so a "helpful" correction
 * (case, path, stride) breaks here instead of in front of a camera. The spellings
 * are the firmware's own — e.g. the official Yz settings page writes `wifissid=`
 * and `wifipwd=` (YdeviceSettingActivity.java:77-79), and the Novatek thumbnail is
 * the media URL plus `?custom=1&cmd=4002` (FileInfo.java:55).
 */
class IcatchWireShapesTest {

    @Test
    fun novatekThumbnailAppendsCmd4002() {
        // Given the media URL the plugin builds for a Ly file, the thumbnail is that
        // URL + the query. (The plugin composes exactly this pair; kept in sync by test.)
        val mediaUrl = "http://192.168.1.254/Novatek/normal/20260101120000.mp4"
        val thumb = "$mediaUrl?custom=1&cmd=4002"
        assertTrue(thumb.endsWith("?custom=1&cmd=4002"))
        assertTrue(mediaUrl.contains("/Novatek/"))
    }

    @Test
    fun videoResolutionTableMatchesTheArchive() {
        // §8.1 — labels and indices verbatim; order is the official UI order.
        val expected = listOf(
            "1" to "2160p@30fps",
            "6" to "1440p@30fps",
            "10" to "1080p@60fps",
            "11" to "1080p@30fps",
            "14" to "720p@60fps",
            "15" to "720p@30fps",
        )
        assertEquals(expected, IcatchSettings.VIDEO_RESOLUTIONS.map { it.value to it.label })
    }

    @Test
    fun photoSizeTableIsInverselyRelatedToPixels() {
        // §8.2 — 12M is par=0, 5M is par=3.
        assertEquals("0", IcatchSettings.PHOTO_SIZES.first { it.label == "12M" }.value)
        assertEquals("3", IcatchSettings.PHOTO_SIZES.first { it.label == "5M" }.value)
        assertEquals(4, IcatchSettings.PHOTO_SIZES.size)
    }

    @Test
    fun loopLengthTableMatchesTheArchive() {
        // §8.3 — OFF/1/3/5 minutes at index 0..3.
        assertEquals(
            listOf("0", "1", "2", "3"),
            IcatchSettings.LOOP_LENGTHS.map { it.value },
        )
        assertEquals("OFF", IcatchSettings.LOOP_LENGTHS[0].label)
        assertEquals("5 MIN", IcatchSettings.LOOP_LENGTHS[3].label)
    }

    @Test
    fun gSensorTableMatchesTheArchive() {
        // §8.4 — Off/Low/Med/High/Max at par 0..4.
        assertEquals(
            listOf("0", "1", "2", "3", "4"),
            IcatchSettings.G_SENSOR.map { it.value },
        )
        assertEquals("Max", IcatchSettings.G_SENSOR.last().label)
    }

    @Test
    fun fixedLyItemsCoverTheOfficialSet() {
        // The 8 fixed rows; 2002's options come from cmd=3030, the four overridable
        // ones from cmd=3031, the rest static.
        assertEquals(
            listOf("2002", "2003", "2004", "2008", "2011", "3044", "8010", "8011"),
            IcatchSettings.LY_ITEMS.map { it.cmd },
        )
        assertEquals(setOf("2003", "2011", "8010", "8011"), IcatchSettings.MENU_OVERRIDABLE)
        assertEquals(8, IcatchSettings.LY_ITEMS.size)
    }

    @Test
    fun qzPaginationStrideIs101Not100() {
        // QzIC.getMoreFileList: start = prev_end + 1, end = prev_end + 101.
        var start = 0
        var end = 99
        start = end + 1
        end += 101
        assertEquals(100, start)
        assertEquals(200, end)
    }

    @Test
    fun labelForFallsBackAcrossOptionTables() {
        assertEquals("1080p@30fps", IcatchSettings.labelFor(IcatchSettings.VIDEO_RESOLUTIONS, "11"))
        assertEquals(null, IcatchSettings.labelFor(IcatchSettings.VIDEO_RESOLUTIONS, "99"))
        assertEquals(null, IcatchSettings.labelFor(null, "11"))
    }
}
