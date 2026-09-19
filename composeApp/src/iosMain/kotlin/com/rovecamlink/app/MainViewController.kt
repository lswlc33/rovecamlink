package com.rovecamlink.app

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

/**
 * iOS entry point. Hosts the shared Compose [App] inside a UIKit view controller.
 * Referenced from the iosApp Xcode shell via the ComposeApp framework.
 */
fun MainViewController(): UIViewController = ComposeUIViewController { App() }
