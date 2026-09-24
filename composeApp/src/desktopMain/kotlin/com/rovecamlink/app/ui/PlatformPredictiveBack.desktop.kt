package com.rovecamlink.app.ui

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow

/**
 * Nothing to follow: a desktop window has no back gesture, so there is no stream to hand the
 * pages. Kept as a no-op so the call site can stay in `App` next to the page stack it is about —
 * the window's own controls and the in-app back arrows are the way out.
 */
@Composable
actual fun PlatformPredictiveBackHandler(
    enabled: Boolean,
    onProgress: suspend (Flow<Float>) -> Unit,
    onCommit: suspend () -> Unit,
    onCancel: suspend () -> Unit,
) = Unit
