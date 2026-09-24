package com.rovecamlink.app.ui

import android.view.TextureView
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.VideoSize
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import java.io.File
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.delay
import top.yukonga.miuix.kmp.basic.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** How long the picture may stay unplayed before the player is rebuilt, as in the live view. */
private const val STALL_LIMIT_MS = 6_000L

/** How often the progress bar re-reads the player's position. */
private const val PROGRESS_TICK_MS = 300L

/** How often the watchdog looks at the player. */
private const val WATCHDOG_TICK_MS = 1_000L

/** Rebuilds before it gives up and says so. */
private const val MAX_ATTEMPTS = 3

/**
 * ExoPlayer over a downloaded file.
 *
 * Same shape as the live view's player — a `TextureView` rather than a `PlayerView`, a
 * watchdog on `isPlaying`, a bounded rebuild ladder, and a release tied to the player
 * instance rather than to the path — because that shape was arrived at against real field
 * logs and applies here too. What is *not* copied is the RTSP source and the live-only
 * buffering targets: a local file has no network behind it, so the default load control is
 * the right one and there is nothing to keep "fresh".
 *
 * A `TextureView` is used for consistency with the live view even though nothing rotates
 * here; it also composites inside the view hierarchy, so the viewer's own layering (chrome
 * over picture) behaves the same on both surfaces.
 */
@androidx.annotation.OptIn(UnstableApi::class)
@Composable
actual fun VideoPlayerView(localPath: String, displayName: String, modifier: Modifier) {
    val context = LocalContext.current
    val retry = remember(localPath) { AtomicInteger(0) }
    val rebuilding = remember(localPath) { AtomicBoolean(false) }
    var generation by remember(localPath) { mutableIntStateOf(0) }
    var notice by remember(localPath) { mutableStateOf<String?>(null) }
    // 0 = "fill the view", which is what the container falls back to until the first
    // frame reports its own ratio.
    var videoAspect by remember(localPath) { mutableFloatStateOf(0f) }
    var positionMs by remember(localPath) { mutableLongStateOf(0L) }
    var durationMs by remember(localPath) { mutableLongStateOf(0L) }
    // Non-null while a finger owns the bar: the thumb follows this instead of the player.
    var scrubbing by remember(localPath) { mutableStateOf<Float?>(null) }

    val player = remember(localPath, generation) {
        val file = File(localPath)
        if (!file.exists() || file.length() == 0L) {
            // Said out loud: a zero-byte file is what a download interrupted at the very
            // end leaves behind, and "the player shows nothing" would not say that.
            Diag.warn(LogTag.FILE, "video: missing or empty $localPath (${file.length()}B)")
            null
        } else {
            Diag.info(LogTag.FILE, "video open $displayName ${file.length()}B attempt=${retry.get()}")
            ExoPlayer.Builder(context).build().apply {
                addListener(
                    object : Player.Listener {
                        override fun onPlaybackStateChanged(playbackState: Int) {
                            if (playbackState == Player.STATE_READY) {
                                retry.set(0)
                                rebuilding.set(false)
                                notice = null
                                Diag.info(LogTag.FILE, "video READY $displayName")
                            }
                            if (playbackState == Player.STATE_ENDED) {
                                Diag.info(LogTag.FILE, "video ended $displayName")
                            }
                        }

                        override fun onVideoSizeChanged(videoSize: VideoSize) {
                            if (videoSize.height > 0) {
                                videoAspect =
                                    videoSize.width * videoSize.pixelWidthHeightRatio / videoSize.height
                            }
                        }

                        override fun onPlayerError(error: PlaybackException) {
                            // A container the platform cannot decode is a finding about
                            // the file, not a UI bug — the vendor AVI case in particular.
                            Diag.error(
                                LogTag.FILE,
                                "video error code=${error.errorCodeName} msg=${Diag.causeChain(error)} " +
                                    "file=$displayName",
                            )
                            val attempt = retry.get() + 1
                            retry.set(attempt)
                            if (attempt > MAX_ATTEMPTS || rebuilding.get()) {
                                notice = error.errorCodeName
                                return
                            }
                            rebuilding.set(true)
                            // Off the player's own callback thread: rebuilding inside it
                            // deadlocks against the release of the player being replaced.
                            delay0 { generation++ }
                        }
                    },
                )
                setMediaItem(MediaItem.fromUri(file.toURI().toString()))
                playWhenReady = true
                prepare()
            }
        }
    }

    // Watchdog: `isPlaying` is the only honest signal that frames are moving, for the
    // reason the live view documents — READY with nothing arriving looks the same as a
    // healthy player from the outside.
    LaunchedEffect(player) {
        val p = player ?: return@LaunchedEffect
        var lastAlive = 0L
        while (true) {
            delay(WATCHDOG_TICK_MS)
            val now = System.currentTimeMillis()
            if (lastAlive == 0L) lastAlive = now
            if (p.isPlaying || p.playbackState == Player.STATE_ENDED) {
                lastAlive = now
            } else if (now - lastAlive >= STALL_LIMIT_MS) {
                lastAlive = now
                Diag.warn(LogTag.FILE, "video stalled ${STALL_LIMIT_MS}ms, rebuilding $displayName")
                generation++
            }
        }
    }

    // Progress for the bar. Polled rather than pushed: ExoPlayer has no position callback,
    // and 300 ms is finer than the bar can show. Skipped while a finger owns the bar so a
    // tick cannot yank the thumb back mid-drag.
    LaunchedEffect(player) {
        val p = player ?: return@LaunchedEffect
        while (true) {
            if (scrubbing == null) {
                positionMs = p.currentPosition.coerceAtLeast(0L)
                durationMs = p.duration.let { if (it > 0L) it else 0L }
            }
            delay(PROGRESS_TICK_MS)
        }
    }

    DisposableEffect(player) {
        onDispose {
            Diag.info(LogTag.FILE, "video released $displayName")
            runCatching { player?.release() }
        }
    }

    Box(modifier.background(Color.Black), contentAlignment = Alignment.Center) {
        if (player != null) {
            // An `AspectRatioFrameLayout`, not a bare `TextureView`: ExoPlayer stretches
            // its output to whatever surface it is handed, so filling the screen with the
            // texture is exactly what distorted every clip. The frame layout letterboxes
            // it at the clip's own ratio instead (2026-09-24 report 「图库视频全屏拉伸」).
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { ctx ->
                    AspectRatioFrameLayout(ctx).apply {
                        resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                        addView(
                            TextureView(ctx),
                            ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT,
                            ),
                        )
                    }
                },
                update = { frame ->
                    frame.setAspectRatio(videoAspect)
                    player.setVideoTextureView(frame.getChildAt(0) as? TextureView)
                },
                onRelease = { frame ->
                    runCatching {
                        player.setVideoTextureView(null)
                        (frame.getChildAt(0) as? TextureView)?.let { frame.removeView(it) }
                    }
                },
            )
            SeekBar(
                positionMs = positionMs,
                durationMs = durationMs,
                scrubbing = scrubbing,
                onScrub = { scrubbing = it },
                onCommit = { fraction ->
                    if (durationMs > 0L) {
                        runCatching { player.seekTo((durationMs * fraction).toLong()) }
                    }
                    scrubbing = null
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
            )
        } else {
            Text(
                "—",
                color = Color.White.copy(alpha = 0.6f),
                fontSize = 20.sp,
            )
        }
        notice?.let {
            Text(
                text = "Unsupported: $it",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 13.sp,
            )
        }
    }
}

/**
 * A thin progress bar that can be dragged to seek.
 *
 * Hand-built rather than the library's `SliderPreference`: that one is a whole settings
 * row (label + value + slider), and the bare `Slider` behind it is not part of the surface
 * this module imports. A drag moves a local [scrubbing] fraction so the thumb follows the
 * finger while the clip plays underneath, and the seek is issued once, on release — the
 * same "commit on release" rule the live view's quick-adjust slider follows.
 */
@Composable
private fun SeekBar(
    positionMs: Long,
    durationMs: Long,
    scrubbing: Float?,
    onScrub: (Float?) -> Unit,
    onCommit: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    val live = scrubbing
        ?: if (durationMs > 0L) (positionMs.toFloat() / durationMs).coerceIn(0f, 1f) else 0f
    BoxWithConstraints(modifier.height(26.dp)) {
        Box(
            Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth()
                .height(3.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.28f)),
        )
        Box(
            Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth(live)
                .height(3.dp)
                .clip(CircleShape)
                .background(Color.White),
        )
        Box(
            Modifier
                .align(Alignment.CenterStart)
                .offset(x = (maxWidth - 12.dp) * live)
                .size(12.dp)
                .background(Color.White, CircleShape),
        )
        Box(
            Modifier
                .matchParentSize()
                .pointerInput(durationMs) {
                    if (durationMs <= 0L) return@pointerInput
                    val width = size.width.coerceAtLeast(1)
                    fun fraction(x: Float) = (x / width).coerceIn(0f, 1f)
                    var current = 0f
                    detectHorizontalDragGestures(
                        onDragStart = { offset ->
                            current = fraction(offset.x)
                            onScrub(current)
                        },
                        onDragEnd = {
                            onScrub(null)
                            onCommit(current)
                        },
                        onDragCancel = { onScrub(null) },
                    ) { change, _ ->
                        current = fraction(change.position.x)
                        onScrub(current)
                    }
                },
        )
    }
}

/**
 * Bump the generation from a plain handler rather than from the player's callback thread.
 *
 * Kept as a tiny local helper so the call site above reads as one line; the main looper is
 * where Compose state may be written.
 */
private fun delay0(block: () -> Unit) {
    android.os.Handler(android.os.Looper.getMainLooper()).post(block)
}
