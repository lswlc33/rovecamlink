package com.rovecamlink.app.core.media

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.rtsp.RtspMediaSource
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.ui.PlayerView
import com.robinpcrd.cupertino.CupertinoText
import com.rovecamlink.app.Res
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.monotonicMillis
import com.rovecamlink.app.preview_none
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

private fun playbackStateName(state: Int): String = when (state) {
    Player.STATE_IDLE -> "IDLE"
    Player.STATE_BUFFERING -> "BUFFERING"
    Player.STATE_READY -> "READY"
    Player.STATE_ENDED -> "ENDED"
    else -> "state$state"
}

/**
 * Buffer targets for the live view, in ms / bytes.
 *
 * ExoPlayer's defaults hold a live stream back until it has
 * `bufferForPlaybackMs = 2500` before it paints anything, and keep a 50 MB target
 * buffer on top of that — for a 1.5 Mbps camera stream that is tens of seconds of
 * material. On a motion camera that delay is the difference between framing a shot
 * and missing it, and the 2026-09-21 field session measured 2.6 s just to reach
 * READY on top of whatever the pipeline then sat behind. These values aim at about
 * a third of a second of smoothing, which is enough to ride out the WiFi jitter a
 * camera AP produces without turning the view into a recording of the past.
 */
private const val MIN_BUFFER_MS = 1_000
private const val MAX_BUFFER_MS = 3_000
private const val PLAYBACK_BUFFER_MS = 150
private const val REBUFFER_PLAYBACK_MS = 150
private const val TARGET_BUFFER_BYTES = 256 * 1024

/** Set when the player starts, so the log can say how long live view really takes. */
private class LatencyProbe(var startedAt: Long = 0L, var readyAt: Long = 0L)

/**
 * How long to wait before rebuilding the player after the n-th failure.
 *
 * A camera that refuses 554 usually needs seconds, not milliseconds: the same field
 * log that shows `ECONNREFUSED` also shows the device briefly refusing *everything*
 * while it recovered, so an immediate retry loop would be the app doing to itself what
 * the previous section describes the camera doing to itself.
 */
private fun backoffMs(attempt: Int): Long = when (attempt) {
    1 -> 1_000L
    2 -> 2_000L
    3 -> 5_000L
    else -> 10_000L
}

/** Retries per visit to the live view before it stops and says so in the log. */
private const val MAX_PLAYBACK_ATTEMPTS = 6

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
actual fun CameraPreviewView(rtspUrl: String?, modifier: Modifier) {
    val context = LocalContext.current
    val probe = remember(rtspUrl) { LatencyProbe() }
    val scope = rememberCoroutineScope()
    // The live view used to be a one-shot: after the error the log shows at +128.4 s
    // (`ECONNREFUSED` on 554) the player sat in IDLE with a black rectangle until the
    // user left the screen and came back, because REPEAT_MODE_ALL does not re-prepare a
    // source that failed fatally. So an error now schedules a rebuild with a growing
    // delay, and a stream that reaches READY resets the ladder.
    val retry = remember(rtspUrl) { intArrayOf(0) }
    var generation by remember(rtspUrl) { mutableIntStateOf(0) }

    val player = remember(rtspUrl, generation) {
        if (rtspUrl.isNullOrBlank()) {
            Diag.info(LogTag.PREV, "preview: no URL for this platform/session")
            null
        } else {
            Diag.info(LogTag.PREV, "player start url=$rtspUrl attempt=${retry[0]}")
            val loadControl = DefaultLoadControl.Builder()
                .setBufferDurationsMs(
                    MIN_BUFFER_MS,
                    MAX_BUFFER_MS,
                    PLAYBACK_BUFFER_MS,
                    REBUFFER_PLAYBACK_MS,
                )
                .setTargetBufferBytes(TARGET_BUFFER_BYTES)
                // Prefer keeping the playback position fresh over filling a byte budget;
                // the byte budget is what makes a low-bitrate stream run far behind.
                .setPrioritizeTimeOverSizeThresholds(true)
                .build()

            ExoPlayer.Builder(context)
                .setLoadControl(loadControl)
                .build().apply {
                    addListener(
                        object : Player.Listener {
                            override fun onPlaybackStateChanged(playbackState: Int) {
                                if (playbackState == Player.STATE_BUFFERING && probe.startedAt == 0L) {
                                    probe.startedAt = monotonicMillis()
                                }
                                if (playbackState == Player.STATE_READY && probe.startedAt > 0L) {
                                    probe.readyAt = monotonicMillis()
                                    retry[0] = 0
                                    Diag.info(
                                        LogTag.PREV,
                                        "state=READY first_frame=${probe.readyAt - probe.startedAt}ms " +
                                            "buffer=${PLAYBACK_BUFFER_MS}ms url=$rtspUrl",
                                    )
                                    return
                                }
                                Diag.info(LogTag.PREV, "state=${playbackStateName(playbackState)} url=$rtspUrl")
                            }

                            override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                                // The RTSP handshake failing is a protocol finding, not a UI bug.
                                Diag.error(
                                    LogTag.PREV,
                                    "player error code=${error.errorCodeName} msg=${Diag.causeChain(error)} url=$rtspUrl",
                                )
                                val attempt = retry[0] + 1
                                retry[0] = attempt
                                if (attempt > MAX_PLAYBACK_ATTEMPTS) {
                                    Diag.error(
                                        LogTag.PREV,
                                        "preview given up after $attempt attempt(s) on $rtspUrl — " +
                                            "leave the screen and reopen to try again",
                                    )
                                    return
                                }
                                val waitMs = backoffMs(attempt)
                                Diag.warn(LogTag.PREV, "preview retry #$attempt in ${waitMs}ms")
                                scope.launch {
                                    delay(waitMs)
                                    probe.startedAt = 0L
                                    probe.readyAt = 0L
                                    generation++
                                }
                            }
                        },
                    )
                    setMediaSource(liveMediaSource(rtspUrl))
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
            CupertinoText(stringResource(Res.string.preview_none), color = Color(0xFF8E8E93))
        }
    }
}

/**
 * The preview transport.
 *
 * The official XTU GO app builds this stream with ijkplayer and, for every
 * non-Ambarella camera type — which is what the Hi3519DV500 in the S7PRO is —
 * sets `rtsp_flags = prefer_tcp` (`sigmastar/widget/SSVideoView.java:604-607`);
 * only the AMBA/CV75 cameras get `rtsp_transport = udp`. RTP-over-TCP matters here
 * beyond reliability: an RTSP receiver that loses UDP packets cannot render a
 * frame until the next keyframe, so every dropped burst costs a full GOP of delay,
 * which is exactly the multi-second stall this view kept showing.
 */
private fun liveMediaSource(rtspUrl: String): MediaSource =
    RtspMediaSource.Factory()
        .setForceUseRtpTcp(true)
        .createMediaSource(MediaItem.fromUri(Uri.parse(rtspUrl)))
