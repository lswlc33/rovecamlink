package com.rovecamlink.app.ui

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow

/**
 * The platform's back gesture, with the finger's own progress.
 *
 * [PlatformBackHandler] only hears the press, and by then there is nothing left to show: the
 * answer is a canned slide and the user never sees what they are going back to. Android's
 * predictive back (API 33+; progress from 34) instead hands over a stream that starts at
 * touch-down, which is what lets the page follow the hand and the bottom bar come back with it.
 *
 * Exactly one of [onCommit] / [onCancel] runs per gesture. The platform decides which, from its
 * own distance and velocity thresholds — so this side never second-guesses the gesture, it just
 * follows [onProgress] and then settles the way it was told.
 *
 * An `expect` for the same reason the discrete handler is one: only Android has the gesture.
 * Desktop and iOS keep the no-op they had, so the call site can stay in `App` where the stack is.
 */
@Composable
expect fun PlatformPredictiveBackHandler(
    enabled: Boolean,
    onProgress: suspend (Flow<Float>) -> Unit,
    onCommit: suspend () -> Unit,
    onCancel: suspend () -> Unit,
)
