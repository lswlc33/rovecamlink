package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.FileType
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * File-listing facts pinned to the bytes a real XTU S7PRO card produced.
 *
 * The literals below are the `getfilelistinfoios.cgi` body captured in
 * `logs/rovecamlink-log-20260921-205746.txt`, including the two things that used to
 * break: a `create` that is not `yyyyMMddHHmmss`, and a photo whose "thumbnail" was
 * the 12–48 MP original.
 */
@OptIn(kotlin.time.ExperimentalTime::class) // Instant.toEpochMilliseconds() is opt-in in this kotlinx-datetime
class HiFilesTest {

    private val utc = TimeZone.UTC

    /** The reference instant, built with the same API the parser uses. */
    private fun stamp(y: Int, mo: Int, d: Int, h: Int, mi: Int, s: Int): Long =
        LocalDateTime(y, mo, d, h, mi, s).toInstant(utc).toEpochMilliseconds()

    @Test
    fun `the dashed create stamp this firmware answers is parsed`() {
        val millis = HiFiles.parseCreate("2026-09-21 18:37:52", utc)
        assertEquals(
            stamp(2026, 9, 21, 18, 37, 52),
            millis,
            "this firmware answers \"2026-09-21 18:37:52\"; reading only the compact form dated every file 1970",
        )
    }

    @Test
    fun `the compact create stamp still parses`() {
        assertEquals(stamp(2026, 9, 21, 18, 37, 52), HiFiles.parseCreate("20260921183752", utc))
    }

    @Test
    fun `both spellings agree and a nonsense stamp parses to nothing`() {
        assertEquals(HiFiles.parseCreate("2026-09-21 18:37:52", utc), HiFiles.parseCreate("20260921183752", utc))
        assertEquals(HiFiles.parseCreate("2026-09-21T18:37:52", utc), HiFiles.parseCreate("20260921183752", utc))
        assertNull(HiFiles.parseCreate(null))
        assertNull(HiFiles.parseCreate(""))
        assertNull(HiFiles.parseCreate("0", utc), "a duration is not a date")
        assertNull(HiFiles.parseCreate("no timestamp here", utc))
        assertNull(HiFiles.parseCreate("2026-19-45 99:99:99", utc), "an out-of-range field is not a date either")
    }

    @Test
    fun `every file type gets the THM sibling, never the original`() {
        assertEquals(
            "sd/DCIM/100XTUDV/NORM0011.THM",
            HiFiles.thumbnailPath("sd/DCIM/100XTUDV/NORM0011.MP4"),
        )
        assertEquals(
            "sd/DCIM/100XTUDV/NORM0012.THM",
            HiFiles.thumbnailPath("sd/DCIM/100XTUDV/NORM0012.JPG"),
            "a photo preview is the .THM too — decoding the original JPEG is what crashed the listing",
        )
        assertEquals("sd/A.THM", HiFiles.thumbnailPath("sd/A.MP4"))
        assertNull(HiFiles.thumbnailPath("sd/DCIM/NOEXT"), "nothing to swap: say there is no preview")
        assertNull(HiFiles.thumbnailPath("sd/.hidden"), "a dot file's leading dot is not an extension")
        assertNull(HiFiles.thumbnailPath("sd/TRAILING."), "an empty extension is not a name to swap either")
    }

    @Test
    fun `file type comes from the extension the card uses`() {
        assertEquals(FileType.VIDEO, HiFiles.typeOf("sd/DCIM/100XTUDV/NORM0011.MP4"))
        assertEquals(FileType.PHOTO, HiFiles.typeOf("sd/DCIM/100XTUDV/NORM0012.JPG"))
        assertEquals(FileType.PHOTO, HiFiles.typeOf("sd/DCIM/100XTUDV/DSC_0003.DNG"))
        assertEquals(FileType.VIDEO, HiFiles.typeOf("sd/DCIM/100XTUDV/CLIP.LRV"))
        assertEquals(FileType.UNKNOWN, HiFiles.typeOf("sd/DCIM/100XTUDV/README.TXT"))
    }
}
