package com.rovecamlink.app.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.calculatePan
import androidx.compose.foundation.gestures.calculateZoom
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.DownloadItem
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
import kotlinx.coroutines.delay
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
import kotlin.math.abs
import kotlin.math.min

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
 *
 * **The still owns the whole gesture set**, which is the fix for the 2026-09-25 report
 * 「文件图片打开来没法放大缩小，这和正常的相册预览有区别」. A full-size transparent box used to
 * be laid over the photo to catch swipes between frames, and in Compose a full-size node
 * bearing a `pointerInput` takes every hit whether or not it consumes what it is given — so
 * the photo's own pinch, pan and tap never saw a single event. There is no way to have both
 * as siblings; the two gestures have to be decided inside one detector, which is what
 * [detectViewerGestures] is. It also removes the "is it zoomed?" flag the swipe layer was
 * gated on: the detector itself knows, because it is the thing that zoomed it.
 *
 * The loading text was the other half of that report — 「点开照片的瞬间会出现下载中弹窗…这个弹窗
 * 会闪一下，导致布局闪现」. It is now late and animated; see [ViewerLoadingNotice].
 */
@Composable
fun MediaViewer(state: AppState) {
    val target = state.viewer ?: return
    val file = target.current ?: return
    val haptics = LocalHapticFeedback.current

    // Local preview needs the file on disk, which `openViewer` starts. This is the same
    // staged path a download uses, so nothing here waits on the camera twice.
    val localPath = state.localPathOf(file.name)
    val isVideo = file.type == FileType.VIDEO
    val failed = state.downloadState(file.name) == DownloadItem.State.Failed
    var decodeFailed by remember(file.name) { mutableStateOf(false) }
    var retryNonce by remember(file.name) { mutableStateOf(0) }
    // Whether the still on screen has been decoded. Owned here rather than inside the stage so
    // there is exactly one loading notice for the whole viewer: two of them, one per branch,
    // meant the delay restarted when the file arrived and the text changed twice.
    var photoReady by remember(file.name) { mutableStateOf(false) }

    // A clip is up as soon as its path is: the player draws its own first frame. A still is up
    // only once it has actually decoded, which is the whole point of the notice below.
    val stageReady = localPath != null && (isVideo || photoReady)
    val showLoading = !failed && !decodeFailed && !stageReady

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .systemBarsPadding(),
    ) {
        when {
            failed || decodeFailed -> {
                ViewerNotice(
                    text = stringResource(Res.string.viewer_cannot_open),
                    actionLabel = stringResource(Res.string.viewer_retry),
                    onAction = {
                        decodeFailed = false
                        retryNonce++
                        state.download(file, force = true)
                    },
                )
            }
            localPath != null && isVideo -> VideoStage(localPath, file)
            localPath != null -> PhotoStage(
                localPath = localPath,
                file = file,
                retryNonce = retryNonce,
                onFailed = { decodeFailed = it },
                onReady = { photoReady = it },
                onStep = { delta ->
                    haptics.tick()
                    state.stepViewer(delta)
                },
            )
        }

        // Swiping to the next member is offered to the stages that cannot do it themselves: a
        // clip, which wants its controls tapped rather than its surface dragged, and a still that
        // has not arrived yet — there is nothing on screen to pan, and waiting for a photo to
        // load before being allowed to move on would be the worse behaviour. A still that *is* up
        // handles the swipe itself, inside the same detector as its zoom.
        if (localPath == null || isVideo) {
            SwipeToStep(state) { delta ->
                haptics.tick()
                state.stepViewer(delta)
            }
        }

        ViewerLoadingNotice(
            text = stringResource(
                if (localPath == null) Res.string.viewer_loading else Res.string.viewer_preparing,
            ),
            visible = showLoading,
        )

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
    }
}

/**
 * Horizontal swipes between members of the run, for the stages that do not handle their own.
 *
 * Deliberately a separate layer rather than a `Pager`: a pager would take every drag before a
 * zoomed still could see it, which is the bug this file's comment describes. This only claims a
 * drag once it is clearly horizontal and longer than [SWIPE_STEP_PX], and lets everything else
 * through.
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

/** Zoom limits on a still: 1 is "fitted", and past [MAX_VIEWER_SCALE] it is only mush. */
private const val MIN_VIEWER_SCALE = 1f
private const val MAX_VIEWER_SCALE = 6f

/** What a tap toggles to — the one level worth having with no control on screen. */
private const val TAP_ZOOM_SCALE = 2f

/**
 * How long the viewer waits before admitting it is loading.
 *
 * A photo goes from "no staged file" to "decoded and on screen" from local storage in a couple of
 * frames, so the notice used to be drawn and taken away inside one gesture — a word flashing in
 * the middle of a black screen, which is the layout flash the 2026-09-25 report saw. A load that
 * finishes inside this window now never says anything at all, and every path this viewer takes is
 * a local one: the wait only ever applies to a camera that is genuinely slow, or to a decode of a
 * 48 MP frame, which is exactly when the user needs to be told something.
 */
private const val LOADING_NOTICE_DELAY_MS = 350L

/** The notice's own fade, so even a real delay does not arrive as a jolt. */
private const val LOADING_FADE_MS = 140

/**
 * The viewer's "still working" text.
 *
 * An overlay in the parent `Box`, so it never takes part in layout and cannot move anything when
 * it comes or goes — the other half of the flash above. [visible] is the *intent* to show it; this
 * holds it back for [LOADING_NOTICE_DELAY_MS] first.
 */
@Composable
private fun ViewerLoadingNotice(text: String, visible: Boolean) {
    // `settled` is the delayed truth: false for the whole of a fast load, whatever the text is.
    var settled by remember { mutableStateOf(false) }
    LaunchedEffect(visible) {
        if (!visible) {
            settled = false
            return@LaunchedEffect
        }
        delay(LOADING_NOTICE_DELAY_MS)
        settled = true
    }
    AnimatedVisibility(
        visible = settled,
        enter = fadeIn(tween(LOADING_FADE_MS)),
        exit = fadeOut(tween(LOADING_FADE_MS)),
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text, color = Color.White.copy(alpha = 0.75f), fontSize = 13.sp)
        }
    }
}

/**
 * A still, with pinch-zoom, pan, tap-to-zoom and a swipe to the next picture.
 *
 * The bytes come off the staged file rather than through the small-body GET: a camera
 * JPEG is routinely several megabytes and that path refuses anything over 1 MiB, so
 * it would fail on exactly the pictures worth opening.
 */
@Composable
private fun PhotoStage(
    localPath: String,
    file: RemoteFile,
    retryNonce: Int,
    onFailed: (Boolean) -> Unit,
    onReady: (Boolean) -> Unit,
    onStep: (Int) -> Unit,
) {
    var bitmap by remember(localPath, retryNonce) { mutableStateOf<ImageBitmap?>(null) }
    var scale by remember(localPath) { mutableFloatStateOf(MIN_VIEWER_SCALE) }
    var offset by remember(localPath) { mutableStateOf(Offset.Zero) }
    var boxSize by remember { mutableStateOf(IntSize.Zero) }
    val haptics = LocalHapticFeedback.current

    LaunchedEffect(localPath, retryNonce) {
        bitmap = null
        onReady(false)
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
        onReady(decoded != null)
    }

    val shown = bitmap ?: return
    // How far the picture may be dragged before an edge would come inside the box. Depends on the
    // *fitted* size, so it needs the box and the bitmap rather than just the zoom level.
    val panLimit = remember(boxSize, shown, scale) { panLimit(boxSize, shown, scale) }
    // Through a `State` because the detector below is created once (keyed on the path) and would
    // otherwise keep the first composition's limit: this value changes on every zoom step, and
    // re-keying the `pointerInput` on it would tear the running gesture down mid-pinch.
    val limitNow = rememberUpdatedState(panLimit)

    fun applyZoom(next: Float) {
        scale = next
        // A picture back at fit has no edge to be off, so it returns to the centre rather than
        // staying wherever the fingers left it.
        if (next <= MIN_VIEWER_SCALE) offset = Offset.Zero
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
                .onSizeChanged { boxSize = it }
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    translationX = offset.x,
                    translationY = offset.y,
                )
                .pointerInput(localPath) {
                    detectViewerGestures(
                        currentZoom = { scale },
                        onZoom = ::applyZoom,
                        onPan = { delta ->
                            val limit = limitNow.value
                            offset = Offset(
                                (offset.x + delta.x).coerceIn(-limit.x, limit.x),
                                (offset.y + delta.y).coerceIn(-limit.y, limit.y),
                            )
                        },
                        onTap = {
                            haptics.tick()
                            applyZoom(if (scale > MIN_VIEWER_SCALE) MIN_VIEWER_SCALE else TAP_ZOOM_SCALE)
                        },
                        onStep = onStep,
                    )
                },
        )
    }
}

/**
 * The half-extent the picture may be dragged to, in pixels, at [zoom].
 *
 * `ContentScale.Fit` fits the whole frame inside the box, so at zoom 1 both halves are zero and
 * the picture does not move — which is what makes this clamp also enforce "you cannot pan an
 * unzoomed photo", without a separate rule. Past that the picture is bigger than the box in
 * whichever direction the zoom overflowed, and it may move by half the difference: exactly far
 * enough for an edge to reach the box's edge, and no further.
 */
private fun panLimit(box: IntSize, image: ImageBitmap, zoom: Float): Offset {
    if (box.width <= 0 || box.height <= 0 || image.width <= 0 || image.height <= 0) return Offset.Zero
    val fit = min(box.width / image.width.toFloat(), box.height / image.height.toFloat())
    val width = image.width * fit * zoom
    val height = image.height * fit * zoom
    return Offset(
        ((width - box.width) / 2f).coerceAtLeast(0f),
        ((height - box.height) / 2f).coerceAtLeast(0f),
    )
}

/**
 * One detector for everything a still answers to, because one node is all a hit test will give.
 *
 * The decision it has to make, and the reason it cannot be `detectTransformGestures` plus
 * something else: at fit, a sideways drag means "next picture"; zoomed in, the very same drag
 * means "pan". Two detectors would each see the drag and each act on it, and a full-size overlay
 * would mean only one of them ever saw anything at all. So the drag is routed once, by the state
 * this detector itself has been maintaining:
 *
 * - a **second finger**, or any change in finger distance, means the gesture is on the picture —
 *   zoom, and pan once it is bigger than the box. It is committed to from that moment on, so
 *   letting one finger up mid-pinch cannot turn the rest of the motion into a frame change;
 * - otherwise the drag is accumulated, and on release either moves one frame (past
 *   [SWIPE_STEP_PX]) or is discarded;
 * - a gesture that never left the slop circle is a **tap**, which toggles the zoom.
 *
 * Movement is only consumed past the slop, so the small tremor at the start of a press still
 * belongs to nobody. What the consume buys is that this node, once it has decided, is
 * unambiguously the one acting on the drag.
 */
private suspend fun PointerInputScope.detectViewerGestures(
    currentZoom: () -> Float,
    onZoom: (Float) -> Unit,
    onPan: (Offset) -> Unit,
    onTap: () -> Unit,
    onStep: (Int) -> Unit,
) {
    awaitEachGesture {
        awaitFirstDown(requireUnconsumed = false)
        val touchSlop = viewConfiguration.touchSlop
        var zoom = currentZoom()
        var travel = 0f
        var stepDrag = 0f
        // Already zoomed when the finger landed: this gesture is a pan from its first pixel.
        var onPicture = zoom > MIN_VIEWER_SCALE
        while (true) {
            val event = awaitPointerEvent()
            if (event.changes.none { it.pressed }) break
            // Something else took this gesture — a parent, or a child that claimed it first.
            // Dropping out is how Compose's own transform detector reads the same signal.
            if (event.changes.any { it.isConsumed }) return@awaitEachGesture
            val zoomChange = event.calculateZoom()
            val panChange = event.calculatePan()
            if (event.changes.count { it.pressed } > 1 || zoomChange != 1f) onPicture = true
            if (onPicture) {
                if (zoomChange != 1f) {
                    zoom = (zoom * zoomChange).coerceIn(MIN_VIEWER_SCALE, MAX_VIEWER_SCALE)
                    onZoom(zoom)
                }
                if (panChange != Offset.Zero) onPan(panChange)
                event.changes.forEach { it.consume() }
            } else {
                travel += panChange.getDistance()
                stepDrag += panChange.x
                if (travel > touchSlop) event.changes.forEach { it.consume() }
            }
        }
        when {
            !onPicture && travel <= touchSlop -> onTap()
            !onPicture && abs(stepDrag) >= SWIPE_STEP_PX -> onStep(if (stepDrag < 0f) 1 else -1)
        }
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
