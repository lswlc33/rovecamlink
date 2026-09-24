package com.rovecamlink.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.theme.darkColorScheme
import top.yukonga.miuix.kmp.theme.lightColorScheme

/**
 * Which palette the app draws in, independent of the OS setting.
 *
 * [System] is the default the app always had — follow the phone. The other two are the
 * override the 2026-09-23 report asked for: a picker that actually changes the colours,
 * not a stub. See [AppearanceState].
 */
enum class ThemeMode { System, Dark, Light }

/**
 * The one place the appearance override lives, read by [RoveMiuixTheme] at each of the
 * three platform entry points so a change flips the whole window at once.
 *
 * A plain observable holder rather than a store: the choice is a session preference, not
 * something that has to survive a restart, and threading a persistence layer through the
 * three `actual` mains for one enum would be more surface than the feature is worth.
 */
object AppearanceState {
    var mode by mutableStateOf(ThemeMode.System)
}

/**
 * The HyperOS ambient that every miuix widget reads. Stock `lightColorScheme()` /
 * `darkColorScheme()` rather than a hand-picked palette: the `Colors` object carries 53
 * tokens and Xiaomi's own values are the point of using this library.
 *
 * Every screen sits inside it — the platform entry points wrap the whole app — so the
 * `MiuixTheme.colorScheme` a widget resolves is always this one. Whether it is the dark
 * or the light set is [AppearanceState.mode], falling back to the system when the user
 * has not overridden it.
 *
 * Requires a Java 21 runtime, not the 17 the rest of this build targets: miuix's desktop
 * jars are compiled to class-file 65, so anything below 21 throws
 * `UnsupportedClassVersionError` the first time a miuix symbol is touched — at compile time
 * Kotlin does not complain, so it only shows up when the window opens. The `jvmTarget =
 * JVM_17` in the build file and the comment above it predate this dependency.
 */
/**
 * Whether the app is painting in its dark palette right now — the same answer
 * [RoveMiuixTheme] hands the colour scheme.
 *
 * Public because a widget sometimes has to branch on the mode rather than read a token:
 * the vendored iOS-style navigation bar picks its drop shadow and its indicator tint
 * from it, because neither is a `Colors` entry (`ui/glass/LiquidGlassNavigationBar.kt`).
 */
@Composable
fun isInDarkTheme(): Boolean = when (AppearanceState.mode) {
    ThemeMode.System -> isSystemInDarkTheme()
    ThemeMode.Dark -> true
    ThemeMode.Light -> false
}

@Composable
fun RoveMiuixTheme(content: @Composable () -> Unit) {
    val dark = isInDarkTheme()
    MiuixTheme(
        colors = if (dark) darkColorScheme() else lightColorScheme(),
        content = content,
    )
}
