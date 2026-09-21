package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.core.model.ModeFamily
import com.rovecamlink.app.core.model.ModeTrigger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * The mode→shutter table, pinned to the official command strings.
 *
 * These wire literals are the whole feature: a mode labelled TOGGLE whose stop
 * request is wrong leaves an XTU camera taking frames for minutes after the user
 * let go of the button, and a video-family name that reaches `photo.cgi` restarts
 * the running recording instead of taking a still — both verified on the S7PRO in
 * the 2026-09-21 session.
 */
class HiModesTest {

    private val cgiBase = "http://192.168.0.1/cgi-bin/hi3510"

    private fun start(name: String, family: ModeFamily = HiModes.familyOf(name) ?: ModeFamily.PHOTO) =
        HiModes.shapeFor(name, family, newApp = true).startUrl(cgiBase)

    @Test
    fun `every video mode fires the plain record cgi and never photo cgi`() {
        for (name in HiModes.videoCandidates) {
            val shape = HiModes.shapeFor(name, ModeFamily.VIDEO, newApp = true)
            assertEquals("record.cgi", shape.endpoint, "\"$name\" left the video shutter")
            assertEquals(
                "http://192.168.0.1/cgi-bin/hi3510/record.cgi?&-cmd=start",
                shape.startUrl(cgiBase),
                "\"$name\" does not send the command the official NewAPP path remaps every video index to",
            )
        }
    }

    @Test
    fun `a name the firmware listed under video cannot reach photo cgi`() {
        // The table itself says photo for these; the family the camera reported wins.
        val shape = HiModes.shapeFor("Night Scene", ModeFamily.VIDEO, newApp = true)
        assertEquals("record.cgi", shape.endpoint)
    }

    @Test
    fun `single-shot photo modes carry the official type spellings`() {
        assertEquals("http://192.168.0.1/cgi-bin/hi3510/photo.cgi?&-type=photo", start("Raw Photo"))
        assertEquals("http://192.168.0.1/cgi-bin/hi3510/photo.cgi?&-type=photo", start("Night Photo"))
        assertEquals("http://192.168.0.1/cgi-bin/hi3510/photo.cgi?&-type=photo", start("Long Exposure"))
        assertEquals("http://192.168.0.1/cgi-bin/hi3510/photo.cgi?&-type=photo", start("Lapse Burst"))
        assertEquals("http://192.168.0.1/cgi-bin/hi3510/photo.cgi?&-type=photoburst", start("Burst Photo"))
    }

    @Test
    fun `normal photo keeps the spelling the field note proved out`() {
        // `?-type=photo&-cmd=start` is what produced a file on the 2026-09-21 S7PRO;
        // the legacy action table's `?&-type=photo` is the competing spelling. Switch
        // the row in HiModes only after a field test says which one the camera wants.
        assertEquals("http://192.168.0.1/cgi-bin/hi3510/photo.cgi?-type=photo&-cmd=start", start(HiModes.NORMAL_PHOTO))
        assertEquals(HiModes.PHOTO_SINGLE_NEWAPP, HiModes.spec(HiModes.NORMAL_PHOTO)?.shape)
    }

    @Test
    fun `timed photo modes carry both halves of the sequence`() {
        assertEquals(
            "http://192.168.0.1/cgi-bin/hi3510/photo.cgi?&-type=phototimer&-cmd=start",
            start("Timing Photo"),
        )
        assertEquals(
            "http://192.168.0.1/cgi-bin/hi3510/photo.cgi?&-type=phototimer&-cmd=stop",
            HiModes.shapeFor("Timing Photo", ModeFamily.PHOTO, true).stopUrl(cgiBase),
        )
        for (name in listOf("Timelapse Photo", "Lapse Photo", "Night Timelapse Photo", "Night Scene")) {
            val shape = HiModes.shapeFor(name, ModeFamily.PHOTO, newApp = true)
            assertEquals("http://192.168.0.1/cgi-bin/hi3510/photo.cgi?&-type=phototimelapse&-cmd=start", shape.startUrl(cgiBase), name)
            assertEquals("http://192.168.0.1/cgi-bin/hi3510/photo.cgi?&-type=phototimelapse&-cmd=stop", shape.stopUrl(cgiBase), name)
        }
    }

    @Test
    fun `a mode is toggle only when its row carries a stop`() {
        val toggles = HiModes.specs.filter { it.family == ModeFamily.PHOTO && it.shape.stopUrl(cgiBase) != null }
        assertEquals(
            setOf("Timing Photo", "Timelapse Photo", "Lapse Photo", "Night Timelapse Photo", "Night Scene"),
            toggles.map { it.name }.toSet(),
        )
        for (spec in HiModes.specs) {
            val hasStop = spec.shape.stopUrl(cgiBase) != null
            val isToggle = spec.family == ModeFamily.PHOTO && hasStop
            assertEquals(isToggle, spec.shape.trigger == ModeTrigger.TOGGLE, "${spec.name} trigger/shape disagree")
            assertEquals(
                if (isToggle) ModeTrigger.TOGGLE else ModeTrigger.SINGLE,
                HiModes.modeFor(spec.name, spec.family).trigger,
                "${spec.name} label does not come from its capture row",
            )
        }
    }

    @Test
    fun `an unknown photo mode defaults to one picture per press`() {
        assertEquals(HiModes.PHOTO_SINGLE_NEWAPP, HiModes.shapeFor("Firmware 21 Surprise", ModeFamily.PHOTO, true))
        assertEquals(HiModes.PHOTO_SINGLE_LEGACY, HiModes.shapeFor("Firmware 21 Surprise", ModeFamily.PHOTO, false))
        assertEquals(ModeTrigger.SINGLE, HiModes.modeFor("Firmware 21 Surprise", ModeFamily.PHOTO).trigger)
    }

    @Test
    fun `probe candidates are the official union in the official order`() {
        assertEquals(
            listOf(
                "Normal Video", "Slow Motion", "Timelapse Video", "Car Looping", "Quick Stories",
                "Quick Video", "Under Water", "Video and Photo", "Time Stretch", "Manual Recsnap",
                "Loop Video",
            ),
            HiModes.videoCandidates,
        )
        assertEquals(
            listOf(
                "Normal Photo", "Raw Photo", "Burst Photo", "Timing Photo", "Timelapse Photo",
                "Lapse Photo", "Long Exposure", "Night Timelapse Photo", "Night Photo", "Night Scene",
                "Lapse Burst",
            ),
            HiModes.photoCandidates,
        )
        assertEquals(
            HiModes.videoCandidates.map { ModeFamily.VIDEO to it } + HiModes.photoCandidates.map { ModeFamily.PHOTO to it },
            HiModes.candidates,
            "the probe order must be video first, then photo, each in the order the APK lists them",
        )
    }

    @Test
    fun `names keep the spacing the camera sent them with`() {
        assertTrue(HiModes.candidates.all { (family, name) -> HiModes.familyOf(name) == family })
        assertNotNullName("Normal Video")
        assertNotNullName("Normal Photo")
        assertNull(HiModes.spec("NormalVideo"), "the legacy no-space spelling is an unknown name on NewAPP (-2222)")
        assertNull(HiModes.spec("normal photo"), "matching is verbatim, not case-folded")
        assertEquals(HiModes.SYSTEM_WORKMODE, "System")
    }

    private fun assertNotNullName(name: String) {
        assertTrue(HiModes.spec(name) != null, "\"$name\" is missing from the table")
        assertFalse(name.contains("  "), "$name has a doubled space")
    }
}
