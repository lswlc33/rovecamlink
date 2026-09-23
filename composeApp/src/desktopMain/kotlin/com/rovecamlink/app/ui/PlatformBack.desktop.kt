package com.rovecamlink.app.ui

import androidx.compose.runtime.Composable

/**
 * Nothing to intercept: a desktop window has no back gesture, and Escape closes whatever is
 * on top without the app being asked. Kept as a no-op so the call site can stay in `App`
 * next to the page stack it is about.
 */
@Composable
actual fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit) = Unit
