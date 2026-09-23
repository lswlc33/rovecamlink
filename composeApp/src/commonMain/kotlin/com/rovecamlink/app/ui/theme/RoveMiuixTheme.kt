package com.rovecamlink.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.theme.darkColorScheme
import top.yukonga.miuix.kmp.theme.lightColorScheme

/**
 * The HyperOS ambient that every miuix widget reads. Stock `lightColorScheme()` /
 * `darkColorScheme()` rather than a hand-picked palette: the `Colors` object carries 53
 * tokens and Xiaomi's own values are the point of using this library.
 *
 * Every screen sits inside it — the platform entry points wrap the whole app — so the
 * `MiuixTheme.colorScheme` a widget resolves is always this one.
 *
 * Requires a Java 21 runtime, not the 17 the rest of this build targets: miuix's desktop
 * jars are compiled to class-file 65, so anything below 21 throws
 * `UnsupportedClassVersionError` the first time a miuix symbol is touched — at compile time
 * Kotlin does not complain, so it only shows up when the window opens. The `jvmTarget =
 * JVM_17` in the build file and the comment above it predate this dependency.
 */
@Composable
fun RoveMiuixTheme(content: @Composable () -> Unit) {
    MiuixTheme(
        colors = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme(),
        content = content,
    )
}
