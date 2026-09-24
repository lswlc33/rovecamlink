package com.rovecamlink.app.ui

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow

/**
 * Nothing to follow yet: the iOS edge swipe is the system's own ([PlatformBackHandler] is a no-op
 * here too), and nothing feeds this app's pages a progress stream on that side. Kept as a no-op so
 * the call site can stay in `App` next to the page stack it is about.
 */
@Composable
actual fun PlatformPredictiveBackHandler(
    enabled: Boolean,
    onProgress: suspend (Flow<Float>) -> Unit,
    onCommit: suspend () -> Unit,
    onCancel: suspend () -> Unit,
) = Unit
