package com.rovecamlink.app.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.viewer_cannot_open
import com.rovecamlink.app.viewer_close
import com.rovecamlink.app.viewer_counter
import com.rovecamlink.app.viewer_loading
import com.rovecamlink.app.viewer_preparing
import com.rovecamlink.app.viewer_retry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.FileSystem
import okio.Path.Companion.toPath
import org.jetbrains.compose.resources.decodeToImageBitmap
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Close
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * The full-screen media viewer.
 *
 * Drawn over the shell by `App.kt` rather than inside the files page, because it covers
 * the navigation bar and has to survive that page recomposing underneath it. The shell
 * already has a "something owns the whole window" flag for the live view's fullscreen
 * mode; this reuses the same idea through [AppState.viewer].
 *
 * Two quite different things share one surface: a still is decoded from the bytes already
 * on disk, a clip is handed to ExoPlayer. What they share is the chrome — a close button,
 * a position counter, and a horizontal swipe between the run's members.
 */
@Composable
fun MediaViewer(state: AppState) {
    val target = state.viewer ?: return
    val file = target.current ?: return
    val haptics = androidx.compose.ui.platform.LocalHapticFeedback.current

    // Local preview needs the file on disk, which `openViewer` starts. This is the same
    // staged path a download uses, so nothing here waits on the camera twice.
    val localPath = state.localPathOf(file.name)
    val transfer = state.downloadState(file.name)
    var failed by remember(file.name) { mutableStateOf(false) }
    var retryNonce by remember(file.name) { mutableStateOf(0) }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .systemBarsPadding(),
    ) {
        when {
            localPath != null -> {
                if (file.type == FileType.VIDEO) {
                    VideoStage(localPath, file)
                } else {
                    PhotoStage(localPath, file, retryNonce) { failed = it }
                }
            }
            transfer == com.rovecamlink.app.DownloadItem.State.Failed || failed -> {
                ViewerNotice(
                    text = stringResource(Res.string.viewer_cannot_open),
                    actionLabel = stringResource(Res.string.viewer_retry),
                    onAction = {
                        failed = false
                        retryNonce++
                        state.download(file, force = true)
                    },
                )
            }
            else -> {
                ViewerSpinner(stringResource(Res.string.viewer_loading))
            }
        }

        // Chrome floats over the picture on its own row so a tap on the photo cannot hit
        // the close button, and the counter stays readable over a bright frame.
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = {
                    haptics.tick()
                    state.closeViewer()
                },
                backgroundColor = Color.Black.copy(alpha = 0.35f),
            ) {
                Icon(
                    MiuixIcons.Close,
                    contentDescription = stringResource(Res.string.viewer_close),
                    tint = Color.White,
                    modifier = Modifier.size(20.dp),
                )
            }
            Spacer(Modifier.weight(1f))
            if (target.files.size > 1) {
                Text(
                    text = stringResource(
                        Res.string.viewer_counter,
                        target.index + 1,
                        target.files.size,
                    ),
                    color = Color.White,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .clip(RoundedCornerShape(11.dp))
                        .background(Color.Black.copy(alpha = 0.35f))
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                )
            }
        }

        // The name sits at the bottom, where the picture usually has less detail to hide.
        Text(
            text = file.name.substringAfterLast('/'),
            color = Color.White.copy(alpha = 0.82f),
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 18.dp, start = 16.dp, end = 16.dp),
        )

        // The swipe layer is last so it sits above the image but below nothing else that
        // matters; a drag shorter than the threshold is left to the stages themselves,
        // which is what lets a zoomed photo pan without also changing frames.
        SwipeToStep(state) { delta ->
            haptics.tick()
            state.stepViewer(delta)
        }
    }
}

/**
 * Horizontal swipes between members of the run.
 *
 * Deliberately a separate layer rather than a `Pager`: the stages below need the same
 * gesture for panning a zoomed image, and a pager would take every drag before the zoom
 * could see it. This only claims a drag once it is clearly horizontal and longer than
 * [SWIPE_STEP_PX], and lets everything else through.
 */
@Composable
private fun SwipeToStep(state: AppState, onStep: (Int) -> Unit) {
    var drag by remember { mutableFloatStateOf(0f) }
    Box(
        Modifier
            .fillMaxSize()
            .pointerInput(state.viewer?.index) {
                detectHorizontalDragGestures(
                    onDragEnd = {
                        val step = if (drag <= -SWIPE_STEP_PX) 1 else if (drag >= SWIPE_STEP_PX) -1 else 0
                        if (step != 0) onStep(step)
                        drag = 0f
                    },
                    onDragCancel = { drag = 0f },
                ) { _, amount -> drag += amount }
            },
    )
}

/**
 * Distance a horizontal drag must cover to move one frame.
 *
 * Low enough to feel like a flick on a 1080px-wide phone, high enough that the small
 * sideways slip in a pan gesture on a zoomed photo does not change frames.
 */
private const val SWIPE_STEP_PX = 120f

/**
 * A still, with pinch-zoom and pan.
 *
 * The bytes come off the staged file rather than through the small-body GET: a camera
 * JPEG is routinely several megabytes and that path refuses anything over 1 MiB, so it
 * would fail on exactly the pictures worth opening.
 */
@Composable
private fun PhotoStage(
    localPath: String,
    file: RemoteFile,
    retryNonce: Int,
    onFailed: (Boolean) -> Unit,
) {
    var bitmap by remember(localPath, retryNonce) { mutableStateOf<ImageBitmap?>(null) }
    var scale by remember(localPath) { mutableFloatStateOf(1f) }
    var offsetX by remember(localPath) { mutableFloatStateOf(0f) }
    var offsetY by remember(localPath) { mutableFloatStateOf(0f) }

    LaunchedEffect(localPath, retryNonce) {
        bitmap = null
        val decoded = withContext(Dispatchers.Default) {
            runCatching {
                val bytes = FileSystem.SYSTEM.read(localPath.toPath()) { readByteArray() }
                bytes.decodeToImageBitmap()
            }.onFailure {
                // A decode that fails on a file the camera described as a JPEG is a
                // protocol finding, so the payload it choked on is worth a line.
                Diag.at(
                    com.rovecamlink.app.core.log.LogLevel.WARN, LogTag.PARSE,
                    "viewer decode failed ${file.name} ${Diag.causeChain(it)}",
                )
            }.getOrNull()
        }
        bitmap = decoded
        onFailed(decoded == null)
    }

    val shown = bitmap
    if (shown == null) {
        ViewerSpinner(stringResource(Res.string.viewer_preparing))
        return
    }

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            bitmap = shown,
            contentDescription = file.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    translationX = offsetX,
                    translationY = offsetY,
                )
                .pointerInput(localPath) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        val next = (scale * zoom).coerceIn(1f, 6f)
                        scale = next
                        if (next > 1f) {
                            offsetX += pan.x
                            offsetY += pan.y
                        } else {
                            // Snap home rather than leaving a zoomed-out image stranded
                            // off-centre, which reads as the photo having moved by itself.
                            offsetX = 0f
                            offsetY = 0f
                        }
                    }
                }
                .clickable(
                    interactionSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() },
                    indication = null,
                ) {
                    // A tap toggles between fit and 2x — the one zoom level that is
                    // useful on a phone and needs no second control on screen.
                    val next = if (scale > 1f) 1f else 2f
                    scale = next
                    if (next == 1f) {
                        offsetX = 0f
                        offsetY = 0f
                    }
                },
        )
    }
}

/**
 * A clip, played by the platform player.
 *
 * Delegates to [VideoPlayerView] because Media3 lives in `androidMain`: the composable is
 * an `expect`/`actual` pair, and desktop/iOS show a notice rather than pretending.
 */
@Composable
private fun VideoStage(localPath: String, file: RemoteFile) {
    VideoPlayerView(localPath, file.name, Modifier.fillMaxSize())
}

/** The viewer's own centred message, used while loading and when a stage cannot show. */
@Composable
private fun ViewerSpinner(text: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text, color = Color.White.copy(alpha = 0.75f), fontSize = 13.sp)
    }
}

/** A message with one action — the shape every "nothing to show" in here takes. */
@Composable
private fun ViewerNotice(text: String, actionLabel: String, onAction: () -> Unit) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(text, color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
            Text(
                text = actionLabel,
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MiuixTheme.colorScheme.primary)
                    .clickable(onClick = onAction)
                    .padding(horizontal = 20.dp, vertical = 8.dp),
            )
        }
    }
}
