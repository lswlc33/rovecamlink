package com.rovecamlink.app

import androidx.compose.ui.window.ComposeUIViewController
import com.rovecamlink.app.ui.theme.RoveMiuixTheme
import platform.UIKit.UIViewController

/**
 * iOS entry point. Hosts the shared Compose [App] inside a UIKit view controller,
 * wrapped in [RoveMiuixTheme] like the other two platforms so the appearance override
 * flips this window too.
 * Referenced from the iosApp Xcode shell via the ComposeApp framework.
 */
fun MainViewController(): UIViewController = ComposeUIViewController { RoveMiuixTheme { App() } }
