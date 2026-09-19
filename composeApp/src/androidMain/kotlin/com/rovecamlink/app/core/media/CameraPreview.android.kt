package com.rovecamlink.app.core.media

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import io.github.alexzhirkevich.cupertino.CupertinoText

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
actual fun CameraPreviewView(rtspUrl: String?, modifier: Modifier) {
    val context = LocalContext.current

    val player = remember(rtspUrl) {
        if (rtspUrl.isNullOrBlank()) null else {
            ExoPlayer.Builder(context).build().apply {
                setMediaItem(MediaItem.fromUri(Uri.parse(rtspUrl)))
                repeatMode = Player.REPEAT_MODE_ALL
                playWhenReady = true
                prepare()
            }
        }
    }

    DisposableEffect(rtspUrl) {
        onDispose { player?.release() }
    }

    Box(modifier.fillMaxSize().background(Color.Black), contentAlignment = Alignment.Center) {
        if (player != null) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { ctx ->
                    PlayerView(ctx).apply {
                        useController = false
                        setShutterBackgroundColor(android.graphics.Color.BLACK)
                    }
                },
                update = { view -> view.player = player },
            )
        } else {
            CupertinoText("No preview", color = Color(0xFF8E8E93))
        }
    }
}
