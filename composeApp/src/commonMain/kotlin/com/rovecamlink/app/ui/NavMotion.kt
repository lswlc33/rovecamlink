package com.rovecamlink.app.ui

import androidx.compose.animation.core.Easing
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * The page transition, borrowed from miuix's own navigation rather than invented here.
 *
 * The design comes from the upstream `miuix-nav` module (`NavTransitions.MiuixDefault`,
 * `NavDriverSpec`, `NavSettleEasing` — Apache-2.0, compose-miuix-ui contributors), which is
 * the motion the official demo ships. Two things are taken from it verbatim:
 *
 * 1. **Geometry.** The entering page slides in *full width* from the trailing edge; the page
 *    it covers does not sit still — it parallaxes a *quarter width* toward the leading edge
 *    with a light alpha falloff, so the two surfaces read as one stack moving rather than one
 *    sheet being thrown over another.
 * 2. **Curve.** A 500 ms tween whose easing is an underdamped spring's step response baked
 *    into a curve (`response = 0.8`, `damping = 0.95`): a brisk middle and a long gentle tail.
 *    Upstream bakes the spring into an easing precisely so the duration is fixed rather than
 *    distance-dependent, and so it never bounces; see [NavProgrammaticEasing].
 *
 * Deliberately **not** adopted, and why:
 * - the **0.5 dim scrim**: upstream draws it over the *covered* entry, not over the window
 *   behind, and a half-black layer over a page that already carries the official alpha falloff
 *   adds nothing on this app's near-black background;
 * - the **leading-corner clip** (`NavCornerClipMode.Leading`): upstream clips to the *platform's*
 *   screen corner radius, which needs a per-platform API for a sub-pixel detail during the
 *   animation.
 *
 * The **pixel-snapping** is adopted, for the moving layer only — see [layerPlacement].
 */
object NavMotion {

    /**
     * Upstream `NavDriverSpec.PROGRAMMATIC_DURATION_MILLIS` is 500 ms, and this departs from it
     * on purpose: the 2026-09-24 field report called the step 「有点长…要等很久」. Upstream spends
     * that long because its own navigation is finger-driven most of the time and the programmatic
     * duration only has to match the settle of a spring it is already carrying velocity into; here
     * every arrow tap and stack change goes through this one number, so it is the felt speed of
     * the whole app rather than the tail of a gesture.
     *
     * 300 ms keeps the same curve and the same geometry — the middle is still the brisk part and
     * the tail still lands rather than stops — and finishes fast enough that the next touch is not
     * something the user waits for.
     */
    const val DURATION_MS = 300

    /**
     * Upstream `NavTransitions.MiuixDefault`, covered segment: the page below slides a quarter
     * of the width toward the leading edge...
     */
    private const val COVERED_PARALLAX = 0.25f

    /**
     * ...and fades to 0.9, not to 0. It is still the page you are coming back to, and dimming
     * it to nothing would read as "it closed" rather than "it is behind".
     */
    private const val COVERED_ALPHA = 0.9f

    /**
     * Where one layer of the stack sits while [frame] is played at [progress].
     *
     * Two shapes, both upstream `NavTransitions.MiuixDefault`:
     *
     * - the layer on top of the stack — the one arriving on a push or leaving on a pop — slides a
     *   full width from or to the trailing edge;
     * - the layer it covers parallaxes a quarter width toward the leading edge and dims to 0.9.
     *   It is still the page being come back to, and taking it to nothing would read as "it
     *   closed" rather than "it is behind".
     *
     * [NavPlacement.snapToPixels] is set for the moving layer only. Upstream rounds just that one
     * so a corner-clipped page's anti-aliased edge does not shimmer over the scrim while it
     * moves; the parallax underneath is deliberately left on fractional pixels.
     */
    fun layerPlacement(layerDepth: Int, frame: NavFrame, progress: Float): NavPlacement {
        // Settled: nothing is moving, so nothing is offset — whatever `progress` and the last
        // direction happen to be.
        if (!frame.moving) return NavPlacement(fractionX = 0f, alpha = 1f, snapToPixels = true)
        return if (layerDepth == frame.topDepth) {
            NavPlacement(
                fractionX = if (frame.forward) 1f - progress else progress,
                alpha = 1f,
                snapToPixels = true,
            )
        } else {
            val cover = if (frame.forward) progress else 1f - progress
            NavPlacement(
                fractionX = -cover * COVERED_PARALLAX,
                alpha = 1f - (1f - COVERED_ALPHA) * cover,
                snapToPixels = false,
            )
        }
    }
}

/**
 * Where a layer of the stack sits, in fractions of the layer's own size so the caller can read
 * its width off the graphics layer instead of being handed it.
 */
class NavPlacement(
    val fractionX: Float,
    val alpha: Float,
    val snapToPixels: Boolean,
)

/**
 * The enter/exit curve of miuix navigation, reproduced point for point.
 *
 * This is the step response of an underdamped spring baked into an [Easing] and played over a
 * fixed duration (upstream `NavSettleEasing`): a live spring's settle time scales with distance
 * and threshold, while this always completes in exactly [NavMotion.DURATION_MS], which is what
 * makes a push and a pop feel like the same gesture in two directions.
 *
 * `transform(1f)` lands at ≈0.99933 rather than exactly 1 — upstream says the same, and the
 * tween's final frame snaps the residue. The curve is monotone over the played window, so it
 * never bounces.
 */
val NavProgrammaticEasing: Easing = object : Easing {
    private val response = 0.8
    private val damping = 0.95

    private val r: Float
    private val w: Float
    private val c2: Float

    init {
        val omega = 2.0 * PI / response
        val k = omega * omega
        val c = damping * 4.0 * PI / response
        w = (sqrt(4.0 * k - c * c) / 2.0).toFloat()
        r = (-c / 2.0).toFloat()
        c2 = r / w
    }

    override fun transform(fraction: Float): Float {
        val t = fraction.toDouble()
        val decay = exp(r * t)
        return (decay * (-cos(w * t) + c2 * sin(w * t)) + 1.0).toFloat()
    }
}
