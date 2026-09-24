package com.rovecamlink.app.ui

import android.view.TextureView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import java.io.File
import kotlinx.coroutines.delay
import top.yukonga.miuix.kmp.basic.Text
import androidx.compose.ui.unit.sp

/** How long the picture may stay unplayed before the player is rebuilt, as in the live view. */
private const val STALL_LIMIT_MS = 6_000L

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
    val retry = remember(localPath) { intArrayOf(0) }
    val rebuilding = remember(localPath) { booleanArrayOf(false) }
    var generation by remember(localPath) { mutableIntStateOf(0) }
    var notice by remember(localPath) { mutableStateOf<String?>(null) }

    val player = remember(localPath, generation) {
        val file = File(localPath)
        if (!file.exists() || file.length() == 0L) {
            // Said out loud: a zero-byte file is what a download interrupted at the very
            // end leaves behind, and "the player shows nothing" would not say that.
            Diag.warn(LogTag.FILE, "video: missing or empty $localPath (${file.length()}B)")
            null
        } else {
            Diag.info(LogTag.FILE, "video open $displayName ${file.length()}B attempt=${retry[0]}")
            ExoPlayer.Builder(context).build().apply {
                addListener(
                    object : Player.Listener {
                        override fun onPlaybackStateChanged(playbackState: Int) {
                            if (playbackState == Player.STATE_READY) {
                                retry[0] = 0
                                rebuilding[0] = false
                                notice = null
                                Diag.info(LogTag.FILE, "video READY $displayName")
                            }
                            if (playbackState == Player.STATE_ENDED) {
                                Diag.info(LogTag.FILE, "video ended $displayName")
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
                            val attempt = retry[0] + 1
                            retry[0] = attempt
                            if (attempt > MAX_ATTEMPTS || rebuilding[0]) {
                                notice = error.errorCodeName
                                return
                            }
                            rebuilding[0] = true
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

    DisposableEffect(player) {
        onDispose {
            Diag.info(LogTag.FILE, "video released $displayName")
            runCatching { player?.release() }
        }
    }

    Box(modifier.background(Color.Black), contentAlignment = Alignment.Center) {
        if (player != null) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { ctx -> TextureView(ctx) },
                update = { view -> player.setVideoTextureView(view) },
                onRelease = { runCatching { player.setVideoTextureView(null) } },
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
 * Bump the generation from a plain handler rather than from the player's callback thread.
 *
 * Kept as a tiny local helper so the call site above reads as one line; the main looper is
 * where Compose state may be written.
 */
private fun delay0(block: () -> Unit) {
    android.os.Handler(android.os.Looper.getMainLooper()).post(block)
}
