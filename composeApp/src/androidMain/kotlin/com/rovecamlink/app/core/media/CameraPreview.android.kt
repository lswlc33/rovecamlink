package com.rovecamlink.app.core.media

import android.net.Uri
import android.view.TextureView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.rtsp.RtspMediaSource
import androidx.media3.exoplayer.source.MediaSource
import top.yukonga.miuix.kmp.basic.Text
import com.rovecamlink.app.Res
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.monotonicMillis
import com.rovecamlink.app.preview_none
import com.rovecamlink.app.preview_stalled
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
 * How long the picture may stay unplayed before this view rebuilds the player itself.
 *
 * ExoPlayer has no such limit of its own for an RTSP source that simply stops sending:
 * it sits in BUFFERING until its socket timeout fires, and the 2026-09-23 field log
 * shows a mode switch leaving the view frozen for 7.6 s with no error at all — which
 * reads as "the app broke the picture", because nothing said otherwise. Rebuilding
 * after six seconds turns that into a two-second blink instead of a dead frame.
 */
private const val STALL_LIMIT_MS = 6_000L

/** How often the watchdog looks at the player. */
private const val WATCHDOG_TICK_MS = 1_000L

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
    // One failed player used to schedule two rebuilds, because releasing it while its
    // RTSP reader is wedged raises `Detaching surface timed out` and then
    // `Player release timed out` — two errors, two retries, and the 2026-09-22 log at
    // 23:21:48 shows the pair arriving 500 ms apart. This flag makes the first one win
    // and the rest of that player's complaints fall on the floor it is already on.
    val rebuilding = remember(rtspUrl) { booleanArrayOf(false) }
    var generation by remember(rtspUrl) { mutableIntStateOf(0) }
    var stalled by remember(rtspUrl) { mutableStateOf(false) }

    /** Schedule the next rebuild, or give up out loud once the ladder is spent. */
    fun scheduleRebuild(reason: String) {
        if (rebuilding[0]) {
            Diag.debug(LogTag.PREV, "rebuild already scheduled — ignoring extra $reason")
            return
        }
        val attempt = retry[0] + 1
        retry[0] = attempt
        if (attempt > MAX_PLAYBACK_ATTEMPTS) {
            if (attempt == MAX_PLAYBACK_ATTEMPTS + 1) {
                // Said once. The watchdog keeps asking every six seconds for as long as
                // the picture stays down, and a log that repeats the surrender every tick
                // buries the one line that explains it.
                Diag.error(
                    LogTag.PREV,
                    "preview given up after $attempt attempt(s) on $rtspUrl ($reason) — " +
                        "the pill on the picture restarts it",
                )
            }
            stalled = true
            return
        }
        rebuilding[0] = true
        stalled = true
        val waitMs = backoffMs(attempt)
        Diag.warn(LogTag.PREV, "preview retry #$attempt in ${waitMs}ms ($reason)")
        scope.launch {
            delay(waitMs)
            rebuilding[0] = false
            probe.startedAt = 0L
            probe.readyAt = 0L
            generation++
        }
    }

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
                                if (playbackState == Player.STATE_BUFFERING) {
                                    // Timed from here to the next READY. Started on every
                                    // buffering spell rather than only the first, because
                                    // the field log showed the opposite — one timestamp for
                                    // the whole visit, so each later READY reported a
                                    // "first_frame" of 17 s, 21 s… that was the age of the
                                    // first buffer, not a stall.
                                    probe.startedAt = monotonicMillis()
                                }
                                if (playbackState == Player.STATE_READY && probe.startedAt > 0L) {
                                    val waitedMs = monotonicMillis() - probe.startedAt
                                    probe.startedAt = 0L
                                    retry[0] = 0
                                    rebuilding[0] = false
                                    stalled = false
                                    val milestone = if (probe.readyAt == 0L) "first_frame" else "resumed"
                                    probe.readyAt = monotonicMillis()
                                    Diag.info(
                                        LogTag.PREV,
                                        "state=READY $milestone=${waitedMs}ms " +
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
                                scheduleRebuild("error ${error.errorCodeName}")
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

    // The watchdog. `isPlaying` is the only honest signal that frames are moving: a
    // source can sit in STATE_READY with nothing arriving, and STATE_BUFFERING is what
    // every ordinary 30 ms hiccup looks like too, so the test is "has it been playing
    // at all recently", not "what state is it in right now".
    val watched = player
    LaunchedEffect(rtspUrl, generation, watched) {
        val p = watched ?: return@LaunchedEffect
        var lastAlive = monotonicMillis()
        while (true) {
            delay(WATCHDOG_TICK_MS)
            val now = monotonicMillis()
            if (p.isPlaying) {
                lastAlive = now
                if (stalled || retry[0] != 0) {
                    stalled = false
                    retry[0] = 0
                }
            } else if (now - lastAlive >= STALL_LIMIT_MS) {
                val frozenFor = now - lastAlive
                lastAlive = now
                scheduleRebuild("nothing playing for ${frozenFor}ms")
            }
        }
    }

    // Keyed on the player, not on the URL: a retry builds a replacement through
    // `generation`, and with `rtspUrl` as the only key every retry left its old player
    // — decoder thread, RTSP socket and all — alive until the screen was left. Six
    // retries is six players on a camera link that already carries the preview.
    val livePlayer = player
    DisposableEffect(livePlayer) {
        onDispose {
            Diag.info(LogTag.PREV, "player released url=${livePlayer?.currentMediaItem?.localConfiguration?.uri}")
            runCatching { livePlayer?.release() }
        }
    }

    Box(modifier.fillMaxSize().background(Color.Black), contentAlignment = Alignment.Center) {
        if (player != null) {
            AndroidView(
                // A `TextureView`, not a `PlayerView`. `PlayerView` hands the video to a
                // `SurfaceView`, which the system composites in its own layer outside the
                // view hierarchy — so the `Modifier.rotate` that
                // [com.rovecamlink.app.ui.CameraPreviewFrame] applies to this view moves
                // everything *except* the picture. That is the 2026-09-22 report
                // 「横过来时画面被拉伸，但是没有旋转」: the swapped measure box took effect
                // (the frame is stretched), the rotation did not. A TextureView draws
                // through the view, so it turns with the layer it sits in.
                //
                // Nothing is given up by dropping PlayerView: the controller was already
                // off, and the aspect comes from the swapped constraints upstream rather
                // than from its `AspectRatioFrameLayout`.
                modifier = Modifier.fillMaxSize(),
                // No background of its own: `TextureView.setBackgroundDrawable` throws
                // `UnsupportedOperationException` on every Android version, and
                // `setBackgroundColor` routes through it — so the line that was here
                // until now killed the process the moment this view was created, which
                // is the 2026-09-22 「打开实时页面会闪退」. Black is already painted by
                // the Box below and by the caller's clipped container.
                factory = { ctx -> TextureView(ctx) },
                update = { view -> player.setVideoTextureView(view) },
                onRelease = {
                    runCatching { player.setVideoTextureView(null) }
                },
            )
            // Said out loud rather than left as a frozen frame: a picture that stops is
            // indistinguishable from a camera that stopped, and the one thing this view
            // must not do is let the user shoot blind believing it is still live.
            if (stalled) {
                Box(
                    Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 10.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color.Black.copy(alpha = 0.62f))
                        .clickable {
                            Diag.info(LogTag.PREV, "preview reconnect requested by tap on $rtspUrl")
                            retry[0] = 0
                            rebuilding[0] = false
                            generation++
                        }
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                ) {
                    Text(
                        stringResource(Res.string.preview_stalled),
                        color = Color.White,
                        fontSize = 12.sp,
                    )
                }
            }
        } else {
            Text(stringResource(Res.string.preview_none), color = Color(0xFF8E8E93))
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
