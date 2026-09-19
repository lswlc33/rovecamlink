package com.rovecamlink.app.core.media

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.github.alexzhirkevich.cupertino.CupertinoText

/**
 * iOS preview scaffold. A real implementation would wrap AVPlayer in a
 * UIViewController via UIKitView. Left as a placeholder so the shared module
 * compiles for iOS targets.
 */
@Composable
actual fun CameraPreviewView(rtspUrl: String?, modifier: Modifier) {
    Box(modifier.fillMaxSize().background(Color(0xFF1C1C1E)), contentAlignment = Alignment.Center) {
        CupertinoText(
            text = rtspUrl?.let { "iOS preview (AVPlayer) not wired yet\n$it" } ?: "No preview",
            color = Color(0xFFAEAEB2),
        )
    }
}
