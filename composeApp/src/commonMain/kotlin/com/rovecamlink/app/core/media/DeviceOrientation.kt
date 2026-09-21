package com.rovecamlink.app.core.media

import androidx.compose.runtime.Composable
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * Which way the live picture has to be turned to read upright.
 *
 * The camera's RTSP stream is one fixed landscape frame, so holding the phone on its
 * side shows it sideways. The field report (2026-09-21 item 10) asks for the picture to
 * follow the hand and, explicitly, for the app not to: 「不是旋转应用，只旋转画面」. With
 * the tab bar and the control list swinging round mid-shot, whatever you were framing
 * moves out from under you — so only the preview gets a `graphicsLayer.rotationZ`.
 *
 * [enabled] is for a screen that is composed but not on screen: it unsubscribes from the
 * sensor and re-seeds the angle, so switching it back on re-derives the picture from the
 * next live sample. That re-seed is also the manual reset — if this ever reads as the
 * wrong way up, a layout can flip [enabled] false and true to make it look again.
 */
@Composable
expect fun rememberDeviceOrientation(
    mode: OrientationMode = OrientationMode.Snapped,
    enabled: Boolean = true,
): DeviceOrientation

/** How far the orientation sensor is allowed to move the picture. */
enum class OrientationMode {
    /**
     * Keep the picture at one of 0/90/180/270, with hysteresis (see
     * [SNAP_BREAK_DEGREES]). The default: a live view that slides through 45° every time
     * you shift your grip is unwatchable, and each intermediate angle is another
     * relayout of the player surface.
     */
    Snapped,

    /**
     * Follow the sensor through any angle, republishing after [FREE_UPDATE_STEP_DEGREES]
     * of movement. Good for reading the real angle out of the diagnostics log; a
     * hand-held phone never stops moving, so it is not good for watching.
     */
    Free,
}

/**
 * Feed [degrees] straight into `graphicsLayer.rotationZ`.
 *
 * Sign convention, because getting it backwards is invisible on a desk: [degrees] is
 * clockwise in screen coordinates (the layer's y axis points down), so 90 tips the top of
 * the picture toward the screen's right edge. It is the phone's own counter-clockwise
 * tilt as seen by the viewer, which is the rotation the layer has to undo. Negate it and
 * the picture drifts twice as far from upright as the hand does.
 */
data class DeviceOrientation(
    /** What `graphicsLayer.rotationZ` wants: clockwise on screen, [0, 360). */
    val degrees: Float,
    val mode: OrientationMode = OrientationMode.Snapped,
    /**
     * The newest sensor angle that was *actually* measured, in the same degrees as
     * [degrees], or null when the phone has never been off the table. Kept for the log
     * line and the diagnostics overlay: when the picture looks wrong, this says whether
     * the sensor and the snapper disagree or only the snapper does. It never moves on its
     * own — it is refreshed exactly when [degrees] is, so it cannot cause a recomposition.
     *
     * Null here does not mean "broken sensor", and a phone that stayed flat on a desk is
     * indistinguishable from a platform with no sensor at all: both keep [degrees] at the
     * identity 0. That is the intended reading, since the alternative is guessing.
     */
    val rawDegrees: Float? = null,
) {
    /**
     * True when the picture ends up a landscape frame *to the eye* — the phone is on its
     * side, so [degrees] is 90 or 270 — which inside the app's portrait canvas is a box
     * that stands taller than wide: `aspectRatio(9f / 16f)`, not the stream's own 16:9.
     */
    val isLandscapeFrame: Boolean get() = nearestCardinal(degrees) % 180f == 90f

    /** True when [degrees] is one of the four cardinals rather than a live angle. */
    val isSnapped: Boolean get() = mode == OrientationMode.Snapped

    companion object {
        /**
         * Desktop's permanent answer, and the value every platform starts on. A phone
         * lying flat on a table resolves no angle at all ([FLAT_UP_Z_LIMIT]), so the
         * first frame the user sees is the stream's own 16:9 one.
         */
        val Identity: DeviceOrientation = DeviceOrientation(0f)
    }
}

/** Geometric mid-point between two cardinals: 45° off the one being shown. */
const val SNAP_BOUNDARY_DEGREES = 45f

/**
 * Half-width of the no-man's-land around [SNAP_BOUNDARY_DEGREES].
 *
 * A deadband is what stops the chatter: 45° is exactly where two cardinals are equally
 * close, and the tremor of one hand is a few degrees there, so a snapper without one
 * picks a new winner several times a second while you look at a spinning preview.
 *
 * 15°, not 10°, because the failure to design against is walking, not fidgeting: a phone
 * carried at the hip sweeps through roughly 20° of extra roll per step, which is more
 * than a ±10° band can absorb if the average grip happens to sit near the middle. The
 * cost is paid only mid-turn — the picture waits until it is 60° off instead of 55° off,
 * which is a few tens of milliseconds of a motion the user is making on purpose, and it
 * still lands as soon as the hand does.
 */
const val SNAP_DEADBAND_DEGREES = 15f

/** The picture leaves the cardinal it is showing only past this distance from it. */
const val SNAP_BREAK_DEGREES = SNAP_BOUNDARY_DEGREES + SNAP_DEADBAND_DEGREES

/** ... and it may only land on a new one this close to it. 90 - [SNAP_BREAK_DEGREES]. */
const val SNAP_CAPTURE_DEGREES = SNAP_BOUNDARY_DEGREES - SNAP_DEADBAND_DEGREES

/**
 * Resolve no angle at all while the screen normal is within this cosine of world-up —
 * the phone lying flatter than ~16° from a table.
 *
 * Two reasons to freeze instead of guess. The measured one: there the in-plane part of
 * gravity is under 3 m/s^2, so the 0.1-0.3 m/s^2 of per-axis noise a phone
 * accelerometer carries is worth ±5° of angle, enough to walk across the deadband on
 * its own. The user-facing one: a phone put down on the seat of a car has no up for the
 * viewer at all, and any angle chosen is a coin flip the picture would then chase.
 * Freezing keeps the last announced angle — which is what was on screen the moment
 * before the phone left the hand.
 *
 * The accepted cost, written down because it is a real behaviour change: a phone
 * deliberately laid flat — strapped to a wrist mount, propped face-up on a dashboard —
 * keeps whatever angle it last had instead of choosing one. On a table the picture is
 * then upright for nobody, but it is upright for *someone* a second later when the phone
 * is lifted again, and the alternative is a preview that spins every time it is set down.
 */
const val FLAT_UP_Z_LIMIT = 0.96f

/** Free mode republishes only after this much movement, so a still hand costs no frames. */
const val FREE_UPDATE_STEP_DEGREES = 2f

/** Below this the "up vector" is not a measurement at all (a sensor that has not spoken). */
private const val UP_VECTOR_EPSILON = 1e-4f

/** Radians -> degrees, spelled out so no platform `toDegrees` is needed in common code. */
private const val RAD_TO_DEG = 57.29578f

/**
 * Wrap into [0, 360), and make anything unusable (NaN from a dead sensor, 720 from a
 * double-counting caller) come out as a flat 0 rather than poisoning a graphicsLayer.
 */
fun normalizeDegrees(degrees: Float): Float {
    if (!degrees.isFinite()) return 0f
    val wrapped = degrees % 360f
    return if (wrapped < 0f) wrapped + 360f else wrapped
}

/**
 * Signed shortest way from [from] to [to], in (-180, 180].
 *
 * Every threshold in here runs through this, and it is the reason 359° reads as -1°: a
 * phone held a hair past its own portrait must not look like a 359° rotation and flip
 * the picture to 270°.
 */
fun angleDelta(from: Float, to: Float): Float {
    var delta = normalizeDegrees(to) - normalizeDegrees(from)
    while (delta > 180f) delta -= 360f
    while (delta <= -180f) delta += 360f
    return delta
}

/** Nearest of 0/90/180/270, wrapping correctly across the 0° seam. */
fun nearestCardinal(degrees: Float): Float {
    // A perfect diagonal rounds up; which of the two wins there is a matter of taste,
    // and the hysteresis below means it only ever decides the very first sample.
    val quadrant = (normalizeDegrees(degrees) / 90f).roundToInt() % 4
    return quadrant * 90f
}

/**
 * The device's tilt, in degrees, from an "up vector expressed in device coordinates".
 *
 * That vector is exactly what `TYPE_ACCELEROMETER` reports — the sensor reads the
 * reaction to gravity, so a phone resting screen-up reads (0, 0, +9.81) and one tipped
 * onto its left edge reads (+9.81, 0, 0), per the SensorEvent docs — and also row 3 of
 * the rotation matrix built from `TYPE_ROTATION_VECTOR`, which is the same gravity
 * estimate after gyro+magnetometer fusion. The two paths therefore need one formula.
 *
 * `atan2(x, y)` rather than `atan2(y, x)` on purpose: the angle is measured from the
 * device's top edge towards its right edge, which is the in-plane tilt. Tilting the
 * phone towards your face (pitch) does not change it — pitch is not a thing a portrait
 * canvas can show, and the camera frame does not need it.
 *
 * Null near flat; see [FLAT_UP_Z_LIMIT].
 */
fun rollDegreesFromUpVector(
    upX: Float,
    upY: Float,
    upZ: Float,
    canvasRollDegrees: Float = 0f,
): Float? {
    val magnitude = sqrt(upX * upX + upY * upY + upZ * upZ)
    if (magnitude < UP_VECTOR_EPSILON) return null
    if (abs(upZ) / magnitude >= FLAT_UP_Z_LIMIT) return null
    val deviceRoll = atan2(upX, upY) * RAD_TO_DEG
    // The canvas is not always aligned with the phone: if the system is allowed to
    // rotate the activity along with it, the picture is already upright and turning it
    // again would put it upside down. Subtract whatever the canvas has already turned.
    return normalizeDegrees(deviceRoll - canvasRollDegrees)
}

/**
 * The cardinal to announce for one more sensor sample, keeping [current] unless the
 * phone has clearly committed elsewhere.
 *
 * [current] is always itself a cardinal, because this function's only caller feeds its
 * own output back in. The two limits overlap by design ([SNAP_BREAK_DEGREES] +
 * [SNAP_CAPTURE_DEGREES] == 90), so there is no gap where the phone is too far from one
 * and not close enough to the other; on the exact boundary the current one wins, since
 * a picture that changed its mind is a more visible mistake than one that is 15° shy.
 *
 * A fast turn across several quadrants is one decision, not several: the target is
 * [nearestCardinal] of the sample itself, so a wrist flick that lands at 190° goes
 * straight to 180 and never stops at 90 on the way.
 *
 * There is deliberately no dwell timer in front of this. A ~50 ms "hold still before you
 * may flip" gate is the obvious addition and the wrong one: it is the same 55°/35°
 * boundary judged on the rate of change instead of the distance, so it delays the one
 * flip the user is asking for while adding a clock, a reset rule and an untestable
 * latency to a decision that a 60° break already makes unreachable by accident. The
 * field symptom this whole file exists to avoid is a picture that moves on its own; a
 * picture that moves late reads as a broken sensor.
 *
 * 180 is a real target and not a glitch to filter out: the report's use case is a camera
 * on an inverted mount, and handing a phone over top-down is common. Android refuses
 * reverse portrait to *apps* because of hardware buttons and cutouts; a picture has no
 * such excuse, so `nearestCardinal` keeps the quadrant and the flip stays available.
 */
fun snapWithHysteresis(current: Float, rawDegrees: Float): Float {
    val nearest = nearestCardinal(rawDegrees)
    if (abs(angleDelta(current, rawDegrees)) <= SNAP_BREAK_DEGREES) return current
    return if (abs(angleDelta(nearest, rawDegrees)) <= SNAP_CAPTURE_DEGREES) nearest else current
}

/**
 * The value to publish for one more sample, or null to say nothing.
 *
 * This is the only gate between the sensor and Compose, which is why it lives here
 * rather than in each platform actual: the ~50 Hz callback is supposed to cost
 * arithmetic, not frames. In [OrientationMode.Snapped] mode that is absolute — an angle
 * that does not change the announced cardinal never reaches a recomposition at all, and
 * [DeviceOrientation.rawDegrees] moves only in step with [DeviceOrientation.degrees].
 *
 * A null [rawDegrees] means "near flat, nothing to report", and the answer to that is to
 * keep holding [DeviceOrientation.degrees].
 */
fun DeviceOrientation.updatedWith(rawDegrees: Float?): DeviceOrientation? {
    if (rawDegrees == null) return null
    val measured = normalizeDegrees(rawDegrees)
    return when (mode) {
        OrientationMode.Snapped -> {
            // Nothing announced yet (rawDegrees still null: a cold start, a phone that
            // was flat on the table, or a reset through [enabled]) means there is no
            // angle the user is looking at to protect, so commit to the nearest cardinal
            // at once. Holding the identity 0 for the first 60° of a deliberate diagonal
            // grip is the one case where hysteresis costs a wrong picture instead of a
            // flicker.
            val tested = this@updatedWith.rawDegrees != null
            val snapped = if (tested) snapWithHysteresis(degrees, measured) else nearestCardinal(measured)
            if (snapped == normalizeDegrees(degrees)) null
            else copy(degrees = snapped, rawDegrees = measured)
        }

        OrientationMode.Free -> {
            if (abs(angleDelta(degrees, measured)) < FREE_UPDATE_STEP_DEGREES) null
            else copy(degrees = measured, rawDegrees = measured)
        }
    }
}
