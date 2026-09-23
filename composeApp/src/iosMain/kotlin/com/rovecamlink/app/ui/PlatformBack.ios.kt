package com.rovecamlink.app.ui

import androidx.compose.runtime.Composable

/**
 * Nothing to intercept: iOS delivers the interactive edge-swipe to the navigation
 * controller, and this app's page stack is drawn inside one screen rather than being a
 * `UINavigationController`, so there is no gesture to claim. Kept as a no-op so the call
 * site can stay in `App` next to the page stack it is about.
 */
@Composable
actual fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit) = Unit
