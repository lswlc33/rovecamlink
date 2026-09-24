package com.rovecamlink.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import top.yukonga.miuix.kmp.basic.Text

/**
 * No player on this target — see the desktop actual for why. Kept as its own file so the
 * three targets stay symmetric rather than one of them leaning on a shared fallback.
 */
@Composable
actual fun VideoPlayerView(localPath: String, displayName: String, modifier: Modifier) {
    Box(
        modifier.background(Color.Black),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Video playback is Android-only",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 13.sp,
        )
    }
}
