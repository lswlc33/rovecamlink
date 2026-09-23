package com.rovecamlink.app.ui

import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import top.yukonga.miuix.kmp.utils.springAnimateToPage

/**
 * Which of the four pages is showing, kept in step with the bottom bar in **both** directions.
 *
 * The bottom bar can change the page (a tap) and the pager can change it too (a swipe), so
 * there are two writers for one fact. Left alone they fight: tapping 设置 while a swipe is
 * still settling makes the bar highlight one page and the pager land on another, and the
 * highlight then sticks to the wrong one.
 *
 * The shape of the fix is miuix's own (`MainPagerState` in the upstream demo, Apache-2.0,
 * compose-miuix-ui contributors): [selectedPage] is what the bar draws, and it is *pessimistic
 * in one direction and optimistic in the other* —
 *
 * - a tap sets it immediately (the bar must answer the finger, not the animation) and then
 *   [isNavigating] suppresses the pager's own reports until the spring lands;
 * - a swipe is adopted by [syncPage], which is only believed when nothing is being animated.
 *
 * The re-sync at the end of [animateToPage] is the safety net: if the spring was cancelled or
 * clamped short, the bar follows the pager rather than the other way round.
 */
@Stable
class PagerNavState(
    val pagerState: PagerState,
    private val scope: CoroutineScope,
) {
    /** The page the bottom bar highlights. */
    var selectedPage by mutableIntStateOf(pagerState.currentPage)
        private set

    /** True while [animateToPage]'s spring is in flight; a swipe is ignored for that window. */
    var isNavigating by mutableStateOf(false)
        private set

    private var navJob: Job? = null

    /** Jump to [target] with miuix's own pager spring, cancelling any run still in flight. */
    fun animateToPage(target: Int) {
        if (target == selectedPage) return
        navJob?.cancel()
        selectedPage = target
        isNavigating = true
        navJob = scope.launch {
            val mine = coroutineContext.job
            try {
                pagerState.springAnimateToPage(target)
            } finally {
                // Only the newest run may clear the flag: an older job's `finally` must not
                // reopen the window while a newer spring is still moving.
                if (navJob === mine) {
                    isNavigating = false
                    if (pagerState.currentPage != target) selectedPage = pagerState.currentPage
                }
            }
        }
    }

    /** Adopt the pager's page after a swipe. Ignored while a tap-driven spring is settling. */
    fun syncPage() {
        if (!isNavigating && selectedPage != pagerState.currentPage) {
            selectedPage = pagerState.currentPage
        }
    }
}

@Composable
fun rememberPagerNavState(pagerState: PagerState): PagerNavState {
    val scope = rememberCoroutineScope()
    return remember(pagerState, scope) { PagerNavState(pagerState, scope) }
}
