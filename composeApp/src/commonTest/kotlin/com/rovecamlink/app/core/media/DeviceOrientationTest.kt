package com.rovecamlink.app.core.media

import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * The snapping rules are the whole feature, and none of them can be felt on a desk —
 * in the field the picture either lands upright in the hand or it strobes, and only the
 * owner's test can tell which way. So everything downstream of the raw sensor numbers
 * (angle, snap, hysteresis, the near-flat freeze, the publish gate) is pinned here.
 */
class DeviceOrientationTest {

    /** A grip the snapper has already judged, which is when hysteresis applies at all. */
    private fun settled(degrees: Float) =
        DeviceOrientation(degrees, OrientationMode.Snapped, rawDegrees = degrees)

    /**
     * Feed raw tilts through the publish gate, carrying the announced value forward.
     * A `null` entry is a sample the sensor could not resolve, not an angle of zero.
     */
    private fun feed(
        rawAngles: List<Float?>,
        from: DeviceOrientation = DeviceOrientation.Identity,
    ): DeviceOrientation {
        var current = from
        rawAngles.forEach { current.updatedWith(it)?.let { next -> current = next } }
        return current
    }

    /** The angles that reached Compose, in order: a chatter test is really a count test. */
    private fun published(
        rawAngles: List<Float?>,
        from: DeviceOrientation = DeviceOrientation.Identity,
    ): List<Float> {
        val seen = mutableListOf<Float>()
        var current = from
        rawAngles.forEach { raw ->
            current.updatedWith(raw)?.let { next ->
                seen += next.degrees
                current = next
            }
        }
        return seen
    }

    @Test
    fun `the two snap limits meet so no angle is ever left unclaimed`() {
        // Retuning SNAP_DEADBAND_DEGREES on one side only would stop BREAK + CAPTURE
        // from being 90 and open a band where the phone is too far from the cardinal it
        // shows and not close enough to the next: the picture then holds at a wrong angle
        // for the whole middle of a turn.
        assertEquals(90f, SNAP_BREAK_DEGREES + SNAP_CAPTURE_DEGREES, 0.001f)
        assertEquals(45f, SNAP_BOUNDARY_DEGREES, 0.001f)
        assertTrue(SNAP_BREAK_DEGREES > SNAP_BOUNDARY_DEGREES)
        assertTrue(SNAP_CAPTURE_DEGREES < SNAP_BOUNDARY_DEGREES)
    }

    @Test
    fun `the four accelerometer poses read the four cardinals`() {
        // Up vectors exactly as the SensorEvent docs state them for a phone whose natural
        // orientation is portrait, screen towards the viewer.
        assertEquals(0f, assertNotNull(rollDegreesFromUpVector(0f, 9.81f, 0f)), 0.01f)
        assertEquals(90f, assertNotNull(rollDegreesFromUpVector(9.81f, 0f, 0f)), 0.01f)
        assertEquals(180f, assertNotNull(rollDegreesFromUpVector(0f, -9.81f, 0f)), 0.01f)
        assertEquals(270f, assertNotNull(rollDegreesFromUpVector(-9.81f, 0f, 0f)), 0.01f)
    }

    @Test
    fun `tilting the phone towards the face does not turn the picture`() {
        // The same portrait grip laid back 45 degrees: only the in-plane part of up is an
        // angle, which is why z serves as a flatness check and never as a measurement.
        assertEquals(0f, assertNotNull(rollDegreesFromUpVector(0f, 6.93f, 7.0f)), 0.01f)
        assertEquals(45f, assertNotNull(rollDegreesFromUpVector(6.94f, 6.94f, 0f)), 0.01f)
    }

    @Test
    fun `a phone near flat resolves no angle at all, whichever way it points`() {
        // 1 degree of in-plane against 9.6 of z: an angle read there is the difference
        // between two noise samples, and the phone is not being looked at anyway.
        assertNull(rollDegreesFromUpVector(1f, 1f, 9.6f))
        assertNull(rollDegreesFromUpVector(-1f, -1f, 9.6f))
        assertNull(rollDegreesFromUpVector(0f, 0f, 9.81f))
        assertNull(rollDegreesFromUpVector(0f, 0f, -9.81f))
        // 2.6 of in-plane at the very same 45 degrees of grip clears the limit, so the
        // freeze is about how flat the phone lies, not about which way it faces.
        assertEquals(45f, assertNotNull(rollDegreesFromUpVector(2.6f, 2.6f, 9.0f)), 0.01f)
    }

    @Test
    fun `a sensor that has not spoken is not an angle`() {
        assertNull(rollDegreesFromUpVector(0f, 0f, 0f))
        // Half-initialised buffers must not be able to poison a graphicsLayer.
        assertEquals(0f, normalizeDegrees(Float.NaN), 0f)
        assertEquals(0f, nearestCardinal(Float.NaN), 0f)
        assertEquals(0f, nearestCardinal(Float.POSITIVE_INFINITY), 0f)
    }

    @Test
    fun `angles wrap across the seam instead of taking the long way round`() {
        assertEquals(2f, angleDelta(359f, 1f), 0.001f)
        assertEquals(-2f, angleDelta(1f, 359f), 0.001f)
        assertEquals(180f, angleDelta(0f, 180f), 0.001f)
        assertEquals(270f, normalizeDegrees(-90f), 0.001f)
        assertEquals(90f, normalizeDegrees(450f), 0.001f)
        assertEquals(0f, nearestCardinal(359f), 0f)
        assertEquals(270f, nearestCardinal(314f), 0f)
    }

    @Test
    fun `the first grip after a reset commits to its nearest cardinal`() {
        // The app opens on Identity, and so does every re-enable: with nothing announced
        // there is nothing to protect, so a phone held at 50 degrees shows 90 rather than
        // holding the identity 0 until the break limit.
        assertEquals(90f, feed(listOf(50f)).degrees, 0f)
        assertEquals(90f, feed(listOf(100f)).degrees, 0f)
        assertEquals(270f, feed(listOf(280f)).degrees, 0f)
        // Every angle resolves to its own quadrant on the very first sample.
        for (raw in 0..359) {
            assertEquals(
                nearestCardinal(raw.toFloat()),
                feed(listOf(raw.toFloat())).degrees,
                0.01f,
                "first sample at raw=$raw",
            )
        }
        // 0 is already what Identity shows, so there is still nothing to publish.
        assertNull(DeviceOrientation.Identity.updatedWith(20f))
    }

    @Test
    fun `upside down is a frame not a glitch`() {
        // An inverted mount and a phone handed over top-down both have to reach 180,
        // which is why the snapper keeps all four cardinals in play instead of treating
        // anything past 90 as a mistake to filter out.
        assertEquals(listOf(180f), published(listOf(175f, 182f), from = settled(90f)))
        assertEquals(180f, feed(listOf(175f, 182f, 178f), from = settled(90f)).degrees, 0f)
        // And it stays there rather than being pulled back to portrait.
        assertEquals(listOf<Float>(), published(listOf(178f, 183f), from = settled(180f)))
    }

    @Test
    fun `a slow wander across the middle does not move the picture`() {
        // Plain nearest-cardinal would already be showing 90 degrees from the second
        // sample on. The deadband says a hand that has not committed sees nothing.
        val wander = listOf(40f, 44f, 46f, 44f, 46f, 50f, 45f, 30f)
        assertEquals(listOf<Float>(), published(wander, from = settled(0f)))
        assertEquals(settled(0f), feed(wander, from = settled(0f)))
    }

    @Test
    fun `a committed turn flips once and does not flip back until it is unwound`() {
        val short = SNAP_BREAK_DEGREES - 1f // 59: not yet
        val past = SNAP_BREAK_DEGREES + 1f // 61: committed
        val capturePoint = SNAP_CAPTURE_DEGREES - 1f // 29: unwound
        val sequence = listOf(short, past, 50f, 36f, capturePoint)
        assertEquals(listOf(90f, 0f), published(sequence, from = settled(0f)))
        // 50 and 36 sit on either side of the 45 degree middle and move nothing: the way
        // back happens later than the way out, and that lag is the whole point.
        assertEquals(listOf<Float>(), published(listOf(past), from = settled(90f)))
    }

    @Test
    fun `a hand that hovers over the boundary flips once and stays`() {
        // The walk symptom in isolation: hovering across 45 degrees must not return to 0.
        // Once it has committed, everything after that first flip is chatter.
        val past = SNAP_BREAK_DEGREES + 1f
        val hover = listOf(45f, past, 45f, past, 45f, past, 44f, 46f)
        assertEquals(listOf(90f), published(hover, from = settled(0f)))
        assertEquals(90f, feed(hover, from = settled(0f)).degrees, 0f)
    }

    @Test
    fun `a slow turn through three quadrants costs one flip per boundary`() {
        // Two, not more: 0 -> 90 at 61 degrees and 90 -> 180 at 151 degrees, with the
        // samples in between and after settled on their cardinal.
        val turn = listOf(20f, 40f, 61f, 80f, 100f, 121f, 141f, 161f, 181f, 190f)
        assertEquals(listOf(90f, 180f), published(turn, from = settled(0f)))
        // One sample that lands far away must not walk there one cardinal at a time.
        assertEquals(listOf(180f), published(listOf(190f), from = settled(0f)))
        assertEquals(listOf(270f), published(listOf(275f), from = settled(0f)))
    }

    @Test
    fun `a full turn of the wrist visits each cardinal once and returns`() {
        val sweep = (0..360).map { it.toFloat() } + (360 downTo 0).map { it.toFloat() }
        val seen = published(sweep)
        // Four flips out (the first commit at 46 degrees, then 151, 241, 331) and four
        // back (299, 209, 119, 29). Anything past 8 in a clean round turn is chatter the
        // user watches as a preview that will not settle.
        assertEquals(listOf(90f, 180f, 270f, 0f, 270f, 180f, 90f, 0f), seen)
        assertEquals(0f, feed(sweep).degrees, 0f)
        assertTrue(seen.all { abs(it % 90f) < 0.001f }, "snapped output must stay cardinal")
    }

    @Test
    fun `near-flat samples hold the angle instead of hunting`() {
        val started = feed(listOf(95f))
        assertEquals(90f, started.degrees, 0f)
        // Put the phone down on the seat, then lift it back into the same grip: the
        // picture must be exactly where it was, with no 0-degree blink in between.
        assertNull(started.updatedWith(rollDegreesFromUpVector(1f, 1f, 9.6f)))
        assertEquals(listOf<Float>(), published(listOf(null, null, null), from = started))
        assertEquals(90f, feed(listOf(null, null, 95f, null), from = started).degrees, 0f)
        // A phone that has only ever been flat keeps the identity angle and says so.
        assertEquals(DeviceOrientation.Identity, feed(listOf(null, null)))
    }

    @Test
    fun `the measured angle rides along without ever moving on its own`() {
        // rawDegrees exists for the log line, so the two rules that matter are: it tracks
        // the sensor even while the picture holds a cardinal, and a sample that is not
        // published leaves the announced value completely alone — no recomposition.
        val turned = feed(listOf(100f))
        assertEquals(90f, turned.degrees, 0f)
        assertEquals(100f, assertNotNull(turned.rawDegrees), 0.01f)
        assertNull(DeviceOrientation.Identity.rawDegrees)
        assertNull(turned.updatedWith(50f))
        assertEquals(100f, assertNotNull(feed(listOf(100f, 50f)).rawDegrees), 0.01f)
        assertEquals(100f, assertNotNull(feed(listOf(100f, null)).rawDegrees), 0.01f)
        val free = assertNotNull(DeviceOrientation(0f, OrientationMode.Free).updatedWith(7.5f))
        assertEquals(free.degrees, assertNotNull(free.rawDegrees), 0.01f)
    }

    @Test
    fun `a canvas the system already turned is subtracted before snapping`() {
        // A phone tipped clockwise 90 degrees reads 270 degrees of tilt. If the activity
        // was allowed to rotate with it, the canvas is already at 270 and the picture
        // needs nothing; portrait-locked, the canvas is 0 and the picture carries the
        // whole turn.
        assertEquals(270f, assertNotNull(rollDegreesFromUpVector(-9.81f, 0f, 0f)), 0.01f)
        assertEquals(270f, assertNotNull(rollDegreesFromUpVector(-9.81f, 0f, 0f, 0f)), 0.01f)
        assertEquals(0f, assertNotNull(rollDegreesFromUpVector(-9.81f, 0f, 0f, 270f)), 0.01f)
    }

    @Test
    fun `free mode still ignores movement too small to see`() {
        val free = DeviceOrientation(0f, OrientationMode.Free)
        assertNull(free.updatedWith(1.5f))
        assertEquals(3f, assertNotNull(free.updatedWith(3f)?.degrees), 0.01f)
        val at3 = feed(listOf(3f), from = free)
        assertFalse(at3.isSnapped)
        assertNull(at3.updatedWith(4f))
        // The seam is an ordinary place for the shortest-angle rule to matter.
        assertEquals(359f, assertNotNull(at3.updatedWith(359f)?.degrees), 0.01f)
    }

    @Test
    fun `the layout flag tracks which way the picture ended up`() {
        // isLandscapeFrame answers the container's question: turned 90/270 the picture
        // stands taller than wide inside the canvas, so the box wants 9:16 then and the
        // stream's own 16:9 otherwise.
        assertTrue(DeviceOrientation(90f).isLandscapeFrame)
        assertTrue(DeviceOrientation(270f).isLandscapeFrame)
        assertFalse(DeviceOrientation(0f).isLandscapeFrame)
        assertFalse(DeviceOrientation(180f).isLandscapeFrame)
        // Mid-turn in free mode it follows the cardinal the angle is heading for.
        assertTrue(DeviceOrientation(60f, OrientationMode.Free).isLandscapeFrame)
        assertFalse(DeviceOrientation(30f, OrientationMode.Free).isLandscapeFrame)
        assertTrue(DeviceOrientation(90f).isSnapped)
    }

    @Test
    fun `no quadrant can be entered but not left`() {
        // The failure mode hysteresis is prone to: a cardinal you get stuck on. Every
        // neighbour has to be one committed sample away, in both directions, wherever
        // the approach comes from.
        for (from in listOf(0f, 90f, 180f, 270f)) {
            for (step in listOf(90f, 180f, 270f)) {
                val target = (from + step) % 360f
                assertEquals(
                    listOf(target),
                    published(listOf(target), from = settled(from)),
                    "stuck at $from degrees",
                )
            }
        }
    }
}
