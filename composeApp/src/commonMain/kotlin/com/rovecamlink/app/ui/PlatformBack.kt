package com.rovecamlink.app.ui

import androidx.compose.runtime.Composable

/**
 * Intercept the platform's back gesture while [enabled].
 *
 * The app's own back control is the arrow in the top bar of a pushed page, which is why the
 * log, its settings, the about page and the permission notes each carry one. The system
 * gesture is the *other* way out of those pages and Android users reach for it by reflex —
 * without this, back on a pushed page fell through to the activity and closed the app,
 * which is what the 2026-09-24 emulator pass caught.
 *
 * An `expect` because "back" is a platform idea: Android has an `OnBackPressedDispatcher`,
 * iOS has the edge-swipe the system already handles, and the desktop window has neither.
 * Only Android wires anything up; the other two are no-ops rather than absent so the call
 * site stays in `App`, where the page stack lives.
 */
@Composable
expect fun PlatformBackHandler(enabled: Boolean, onBack: () -> Unit)
