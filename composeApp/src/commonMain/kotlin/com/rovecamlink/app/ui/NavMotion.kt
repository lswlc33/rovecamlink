package com.rovecamlink.app.ui

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.ContentTransform
import androidx.compose.ui.unit.IntOffset
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
 * - the **0.5 dim scrim** drawn under the top layer: this app's background is near-black, so a
 *   half-black scrim over it is invisible, and the covered page already carries the official
 *   alpha falloff;
 * - the **leading-corner clip** (`NavCornerClipMode.Leading`): upstream clips to the *platform's*
 *   screen corner radius, which needs a per-platform API for a sub-pixel detail during the
 *   animation;
 * - **pixel-snapping** the entering offset: upstream does it so a corner-clipped page's
 *   anti-aliased edge does not shimmer, and with no clip there is no shimmer to fix.
 */
object NavMotion {

    /** Upstream `NavDriverSpec.PROGRAMMATIC_DURATION_MILLIS`: the established ~500 ms step. */
    const val DURATION_MS = 500

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
     * The transition between two depths of the page stack.
     *
     * [push] is decided by the caller from the two depths, because the same `Page` can be on
     * either side of a move: 日志 → 日志设置 is a push while the reverse is a pop, and both
     * have a non-null page on each end.
     */
    fun stackTransition(push: Boolean): ContentTransform {
        val spec = tween<IntOffset>(DURATION_MS, easing = NavProgrammaticEasing)
        val fade = tween<Float>(DURATION_MS, easing = NavProgrammaticEasing)
        return if (push) {
            // The new page arrives full width; the one it covers gives ground and dims.
            ContentTransform(
                targetContentEnter = slideInHorizontally(spec) { width -> width },
                initialContentExit = slideOutHorizontally(spec) { width ->
                    -(width * COVERED_PARALLAX).toInt()
                } + fadeOut(fade, targetAlpha = COVERED_ALPHA),
            )
        } else {
            // Back: the top page leaves the way it came, and the page below returns to rest.
            ContentTransform(
                targetContentEnter = slideInHorizontally(spec) { width ->
                    -(width * COVERED_PARALLAX).toInt()
                } + fadeIn(fade, initialAlpha = COVERED_ALPHA),
                initialContentExit = slideOutHorizontally(spec) { width -> width },
            )
        }
    }
}

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
