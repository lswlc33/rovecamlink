package com.rovecamlink.app.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import com.rovecamlink.app.Page

/**
 * One page of the stack, carrying the depth it sits at.
 *
 * The depth rides along because a page alone cannot say which way a move went: pushing 日志设置
 * from 日志 and popping back are both "one non-null page to another", and depth is the only
 * thing that differs.
 */
data class NavKey(val page: Page?, val depth: Int)

/**
 * One move of the stack: the key being left, and the key being arrived at.
 *
 * Both are drawn while the move is in flight. Which of the two sits on top is decided by depth
 * rather than by the direction of travel — on a push the arriving page is the deeper one, and on
 * a pop the leaving one is.
 */
data class NavFrame(val from: NavKey, val to: NavKey, val forward: Boolean) {
    val moving: Boolean get() = from != to

    /** The deeper of the two, i.e. the layer drawn above the other. */
    val topDepth: Int get() = maxOf(from.depth, to.depth)
}

/**
 * The page stack's motion, held as a single fraction the way upstream miuix drives its own
 * navigation with one `Animatable<Float>` (`animatedTop`, `NavDriver`).
 *
 * `AnimatedContent` would be the cheaper way to get a push and a pop, but it disposes whichever
 * of its two slots is not the target once a move settles. That is what made a return look wrong:
 * the page underneath was thrown away on a push and rebuilt the moment the pop began, so the
 * revealed page arrived empty and lost its scroll position, while the bottom bar — a boolean on
 * the outside of the transition — appeared mid-slide instead of moving with the pages. Owning the
 * fraction means owning the composition: the layer below can stay put, and the bar can read the
 * same number the pages do.
 *
 * [progress] runs from 0 (the frame's [NavFrame.from] at rest) to 1 ([NavFrame.to] at rest). A
 * move the app makes on its own snaps to 0 and plays to 1; a back gesture drives it from the
 * finger and then settles to whichever end the gesture chose.
 */
@Stable
class NavStackState internal constructor(initial: NavKey) {

    var frame by mutableStateOf(NavFrame(initial, initial, forward = true))
        private set

    val progress = Animatable(1f)

    /** Set while a gesture owns the transition, so the programmatic path keeps out of it. */
    private var gestureOwned = false

    private fun move(from: NavKey, to: NavKey) {
        frame = NavFrame(from = from, to = to, forward = to.depth > from.depth)
    }

    private suspend fun rest(key: NavKey) {
        frame = NavFrame(key, key, frame.forward)
        progress.snapTo(1f)
    }

    /**
     * A move the app made on its own: a page pushed, an arrow tapped, a bottom-bar item picked.
     *
     * A no-op when the stack is already where [key] says it is. That is load-bearing rather than
     * an optimisation: a gesture commits by popping the stack and *then* settling its frame, and
     * the recomposition that follows lands here with the two already agreeing.
     */
    internal suspend fun programmatic(key: NavKey) {
        if (key == frame.to) return
        if (gestureOwned) return
        move(frame.to, key)
        progress.snapTo(0f)
        progress.animateTo(1f, tween(NavMotion.DURATION_MS, easing = NavProgrammaticEasing))
        rest(key)
    }

    /**
     * Start previewing a pop toward [target]; the caller has not touched the stack yet, so the
     * page being previewed is still the live one and the revealed layer is the one warm below it.
     */
    internal suspend fun beginGesture(target: NavKey) {
        gestureOwned = true
        move(frame.to, target)
        progress.snapTo(0f)
    }

    /** The finger's own position. */
    internal suspend fun driveGesture(fraction: Float) {
        progress.snapTo(fraction.coerceIn(0f, MAX_FINGER_PROGRESS))
    }

    /** The gesture committed: finish the move and rest on [target]. */
    internal suspend fun commitGesture(target: NavKey) {
        progress.animateTo(1f, GESTURE_SETTLE)
        rest(target)
        gestureOwned = false
    }

    /** The gesture was let go short of committing: go back to where it started. */
    internal suspend fun cancelGesture() {
        val from = frame.from
        progress.animateTo(0f, GESTURE_SETTLE)
        rest(from)
        gestureOwned = false
    }

    companion object {
        /**
         * Upstream `NavDriverSpec.MAX_FINGER_PROGRESS`: a finger never reaches 1, so the last
         * sliver is left to the settle that follows the release rather than to the gesture.
         */
        const val MAX_FINGER_PROGRESS = 0.999f

        /**
         * Upstream `NavMotion.Default` settles a *gesture* with a critically damped spring
         * (`DAMPING_RATIO = 1f`, `STIFFNESS = 146f`). The 500 ms tween is the other half of that
         * default and belongs to a move that starts from rest — a finger-lead release should
         * carry the velocity it already has, which is what a spring does and a fixed tween cannot.
         */
        val GESTURE_SETTLE = spring<Float>(dampingRatio = 1f, stiffness = 146f)
    }
}

@Composable
fun rememberNavStack(key: NavKey): NavStackState {
    val stack = remember { NavStackState(key) }
    LaunchedEffect(key) { stack.programmatic(key) }
    return stack
}

/**
 * Swallow every pointer event before it reaches anything inside.
 *
 * A covered layer is kept composed so that the page below is already there when a return reveals
 * it — and a composed page still answers taps. Without this, a control on the page underneath
 * would fire through the page covering it. Consuming during [PointerEventPass.Initial] is what
 * makes it arrive at the children already consumed, which is the hint `clickable` and the drag
 * detectors act on; it is the same job upstream's `blockInput` modifier does for a covered entry.
 */
fun Modifier.blockPointerInput(): Modifier = pointerInput(Unit) {
    awaitPointerEventScope {
        while (true) {
            awaitPointerEvent(PointerEventPass.Initial).changes.forEach { it.consume() }
        }
    }
}
