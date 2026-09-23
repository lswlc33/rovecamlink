package com.rovecamlink.app.core.media

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import top.yukonga.miuix.kmp.basic.Text

/**
 * Desktop has no bundled RTSP decoder, so we show a placeholder with the stream
 * URL. The desktop build is primarily for exercising the CGI protocol against
 * the :simulator and for UI work; live RTSP preview is an Android feature.
 */
@Composable
actual fun CameraPreviewView(rtspUrl: String?, modifier: Modifier) {
    Box(modifier.fillMaxSize().background(Color(0xFF1C1C1E)), contentAlignment = Alignment.Center) {
        Text(
            text = rtspUrl?.let { "RTSP preview (Android only)\n$it" } ?: "No preview",
            color = Color(0xFFAEAEB2),
        )
    }
}
