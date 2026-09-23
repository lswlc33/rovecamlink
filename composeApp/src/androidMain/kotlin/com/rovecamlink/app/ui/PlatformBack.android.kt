package com.rovecamlink.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

/**
 * Android's back gesture, routed through the activity's dispatcher so an open dialog or
 * popup still gets first refusal — miuix's own popups register their own handler, and this
 * one only sees the press once they have declined it.
 */
@Composable
actual fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit) {
    BackHandler(enabled = enabled, onBack = onBack)
}
