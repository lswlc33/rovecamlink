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
import com.robinpcrd.cupertino.CupertinoText
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag

private fun playbackStateName(state: Int): String = when (state) {
    Player.STATE_IDLE -> "IDLE"
    Player.STATE_BUFFERING -> "BUFFERING"
    Player.STATE_READY -> "READY"
    Player.STATE_ENDED -> "ENDED"
    else -> "state$state"
}

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
actual fun CameraPreviewView(rtspUrl: String?, modifier: Modifier) {
    val context = LocalContext.current

    val player = remember(rtspUrl) {
        if (rtspUrl.isNullOrBlank()) {
            Diag.info(LogTag.PREV, "preview: no URL for this platform/session")
            null
        } else {
            Diag.info(LogTag.PREV, "player start url=$rtspUrl")
            ExoPlayer.Builder(context).build().apply {
                addListener(
                    object : Player.Listener {
                        override fun onPlaybackStateChanged(playbackState: Int) {
                            Diag.info(LogTag.PREV, "state=${playbackStateName(playbackState)} url=$rtspUrl")
                        }

                        override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                            // The RTSP handshake failing is a protocol finding, not a UI bug.
                            Diag.error(
                                LogTag.PREV,
                                "player error code=${error.errorCodeName} msg=${Diag.causeChain(error)} url=$rtspUrl",
                            )
                        }
                    },
                )
                setMediaItem(MediaItem.fromUri(Uri.parse(rtspUrl)))
                repeatMode = Player.REPEAT_MODE_ALL
                playWhenReady = true
                prepare()
            }
        }
    }

    DisposableEffect(rtspUrl) {
        onDispose {
            Diag.info(LogTag.PREV, "player released url=${player?.currentMediaItem?.localConfiguration?.uri}")
            player?.release()
        }
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
