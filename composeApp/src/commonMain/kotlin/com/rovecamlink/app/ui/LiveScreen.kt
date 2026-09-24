package com.rovecamlink.app.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Op
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_photo
import com.rovecamlink.app.action_record
import com.rovecamlink.app.action_start_lapse
import com.rovecamlink.app.action_stop
import com.rovecamlink.app.action_stop_lapse
import com.rovecamlink.app.core.media.CameraPreviewView
import com.rovecamlink.app.core.media.OrientationMode
import com.rovecamlink.app.core.media.rememberDeviceOrientation
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.ModeFamily
import com.rovecamlink.app.core.model.ModeTrigger
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.hint_locked_adjust
import com.rovecamlink.app.hint_locked_mode
import com.rovecamlink.app.hint_photo_needs_photo_mode
import com.rovecamlink.app.hint_quick_adjust
import com.rovecamlink.app.hint_rotate_picture
import com.rovecamlink.app.label_battery
import com.rovecamlink.app.label_locked
import com.rovecamlink.app.label_photo_count
import com.rovecamlink.app.label_sd_free
import com.rovecamlink.app.rec_busy
import com.rovecamlink.app.section_capture_mode
import com.rovecamlink.app.section_quick_adjust
import com.rovecamlink.app.tab_live
import com.rovecamlink.app.workmode_photo
import com.rovecamlink.app.workmode_video
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.TabRowWithContour
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.preference.SliderPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme
import kotlin.math.roundToInt

/**
 * The live view: the picture pinned to the top, the camera's controls under it, and a
 * shutter floating over both.
 *
 * Four things the 2026-09-22 field page asked for, and what each one cost:
 *
 * **The picture does not scroll away.** It used to be the first row of the same list as
 * every control, so one swipe down to reach 白平衡 took the framing with it. The preview
 * is now the page's pinned header, and only the controls move.
 *
 * **The shutter is always under the thumb.** It used to be a full-width button at the
 * bottom of a list you had to find first. It is now a floating button that stays in the
 * corner while the panel scrolls, and it changes *shape* — a disc to start, a square to
 * stop — instead of changing its label.
 *
 * **Quick adjust has more than exposure in it.** ISO, 快门速度 and the picture-style rows
 * are bars too, and the short menu items (防抖、测光、白平衡、画质、滤镜) are tappable chip
 * rows. They used to disappear wholesale while the camera was recording; now they grey
 * out and say why, which is the rule every other disabled control in this app follows.
 *
 * **None of the above is a list this app keeps.** `getallworkmode.cgi` decides which
 * modes exist and `getprimarymenuitem.cgi` decides which items the current mode has; the
 * ids named below only say which of whatever comes back is worth a row on *this* page. A
 * camera that offers neither shows neither section.
 *
 * The preview picture still rotates with how the phone is held (item 10) — the picture
 * only: the app's own layout stays put, and the frame swaps 16:9 / 9:16 so a rotated
 * view fills its box instead of turning into a letterbox inside a letterbox.
 */
@Composable
fun LiveScreen(state: AppState, outerPadding: PaddingValues) {
    val liveTitle = stringResource(Res.string.tab_live)
    val session = state.session
    if (session == null) {
        MiuixPage(title = liveTitle, outerPadding = outerPadding, state = state) {
            notConnectedItem()
        }
        return
    }
    val previewUrl = state.protocolOrNull()?.previewUrl(session)
    val st = state.deviceStatus
    val recording = st?.recording == true
    val busy = st?.busy == true
    val modes = state.modes
    val current = state.currentMode
    val rotating = remember { mutableStateOf(true) }
    val orientation = rememberDeviceOrientation(OrientationMode.Snapped, enabled = rotating.value)

    // The picture follows the phone, and the quadrant it snaps to is a 90° step. The sensor side
    // already deadens the edges (±15° dead band, 60°/30° hysteresis), so a shake cannot rattle the
    // quadrant — but the step itself used to land in one frame, next to a measurement swap and a
    // preview box that changes shape, which read as a jolt rather than as the frame settling
    // (2026-09-24 「图传旋转建议有可以打断的旋转动画」).
    //
    // `Animatable` is what makes it interruptible: a new quadrant cancels the flight in progress
    // and continues from wherever the angle got to, so turning the phone quickly is one continuous
    // turn instead of a queue of queued 90° hops. `swap` is then read off the *animated* angle, not
    // off the target, so the box turns with the picture instead of a beat ahead of it.
    // The camera's own rotation rides the *same* animated target as the phone's, so turning
    // the camera animates exactly like turning the phone does. Adding it after the
    // `Animatable` (the first cut) made a camera turn a one-frame jump next to an animated
    // phone turn (2026-09-24 「由相机旋转引起的旋转图传没有动画」).
    //
    // It is *subtracted*: `rotation` counts the camera's clockwise turn and the stream
    // arrives already turned that way, so the frame has to undo it. Adding it instead left
    // every camera-portrait shot upside down (2026-09-24 「相机旋转竖版的是反的，上下颠倒了」).
    val cameraDegrees = (state.cameraRotation ?: 0).toFloat()
    val spinTarget = orientation.degrees - cameraDegrees
    val spin = remember { Animatable(spinTarget) }
    LaunchedEffect(spinTarget) {
        val from = spin.value
        // Shortest way round: 350° to 10° is 20°, not 340°.
        val delta = ((spinTarget - from + 540f) % 360f) - 180f
        spin.animateTo(from + delta, spring(dampingRatio = 1f, stiffness = 260f))
    }
    val spinDegrees = spin.value
    val spinSwap = ((spinDegrees % 360f + 360f) % 360f / 90f).roundToInt() % 2 == 1

    // The official client syncs the clock every time the preview screen is built
    // (`HaisiPreviewModel.requestPreviewParams`), not just once at connect: a camera
    // that has been sitting switched-off for a week otherwise stamps every clip with
    // the wrong hour. Best-effort, and silent.
    LaunchedEffect(session.host) { state.syncTime() }

    val scheme = MiuixTheme.colorScheme
    val family = current?.family ?: st?.mode?.workModeFamily() ?: ModeFamily.VIDEO
    val videoLike = family == ModeFamily.VIDEO
    val toggle = current?.trigger == ModeTrigger.TOGGLE
    val working = recording || busy
    // A 定时/延时 capture is "busy" *and* waiting for a second press to end it, so the
    // shutter has to stay live in exactly the case the old full-width button switched
    // itself off in — which left a running timelapse with no way to stop it from here.
    val lapseRunning = state.captureRunning
    val commandInFlight = state.isBusy(Op.Capture) || state.isBusy(Op.Record)
    val shutterEnabled = !commandInFlight &&
        (videoLike || lapseRunning || (!busy && !state.needsPhotoModeForShutter()))
    val shutterReason = when {
        shutterEnabled -> null
        !videoLike && modes.isEmpty() -> stringResource(Res.string.hint_photo_needs_photo_mode)
        else -> stringResource(Res.string.rec_busy)
    }
    val shutterLabel = when {
        videoLike && recording -> stringResource(Res.string.action_stop)
        videoLike -> stringResource(Res.string.action_record)
        lapseRunning -> stringResource(Res.string.action_stop_lapse)
        toggle -> stringResource(Res.string.action_start_lapse)
        else -> stringResource(Res.string.action_photo)
    }

    val modeTitle = stringResource(Res.string.section_capture_mode)
    val batteryLbl = stringResource(Res.string.label_battery)
    val sdFreeLbl = stringResource(Res.string.label_sd_free)
    val photoCountLbl = stringResource(Res.string.label_photo_count)
    val lockedLbl = stringResource(Res.string.label_locked)
    val rotateLbl = stringResource(Res.string.hint_rotate_picture)
    val lockedModeMsg = stringResource(Res.string.hint_locked_mode)
    val quickAdjustTitle = stringResource(Res.string.section_quick_adjust)
    val quickAdjustHint = stringResource(Res.string.hint_quick_adjust)
    val adjustLockedMsg = stringResource(Res.string.hint_locked_adjust)

    // The list stops where the shutter band begins. Reserving that space with padding
    // alone only kept the *last* row clear: every other row scrolled underneath the
    // shutter, and the exposure slider's right half plus the mode chips sat un-tappable
    // while they were in that band. The optional "why is it off" chip grows the band by
    // its own height + margin.
    val shutterBand = 108.dp + if (shutterReason != null) 36.dp else 0.dp

    // The bar's second line used to read 已连接 — a fact the picture right under it already
    // states, and states louder when it is wrong. What the bar is uniquely placed to carry
    // is the camera's own vitals, which used to be a row of three numbers inside the status
    // card below: reading them there cost a glance away from the frame on a page whose whole
    // subject is the frame (2026-09-24 「实时页面的已连接几个字用处不大 替换为电量、SD 卡、
    // 照片」).
    val barStatus = buildString {
        append(batteryLbl).append(' ')
        append(st?.battery?.let { "$it%" } ?: "—")
        append("  ·  ")
        append(sdFreeLbl).append(' ')
        append(st?.sdFreeMb?.let { humanBytes(it * 1024 * 1024) } ?: "—")
        append("  ·  ")
        append(photoCountLbl).append(' ')
        append(st?.photoCount?.toString() ?: "—")
    }

    val listState = rememberLazyListState()
    val shrinkDistancePx = with(LocalDensity.current) { PreviewShrinkDistance.toPx() }
    // How far down the page has been scrolled, 0 at the top and 1 once the first
    // [PreviewShrinkDistance] is behind it. The picture gives height back as this grows:
    // a rotated frame pinned at three quarters of the screen leaves the quick-adjust rows
    // in a strip too short to drag a slider in (2026-09-24 「图传图像横屏时 图传因为占用过大，
    // 会影响下方快速设置使用，所以图像横屏时可以随着滚动最多缩小至半屏」).
    val scrolled by remember(shrinkDistancePx) {
        derivedStateOf {
            if (listState.firstVisibleItemIndex > 0) {
                1f
            } else {
                (listState.firstVisibleItemScrollOffset / shrinkDistancePx).coerceIn(0f, 1f)
            }
        }
    }

    val shutter: @Composable BoxScope.() -> Unit = {
        Column(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = 18.dp,
                    bottom = outerPadding.calculateBottomPadding() + 18.dp,
                ),
            horizontalAlignment = Alignment.End,
        ) {
            shutterReason?.let {
                Box(
                    Modifier
                        .padding(bottom = 10.dp)
                        .clip(RoundedCornerShape(13.dp))
                        .background(scheme.surfaceVariant)
                        .border(1.dp, scheme.outline, RoundedCornerShape(13.dp))
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                ) {
                    Text(
                        it,
                        fontSize = 11.sp,
                        color = scheme.onSurfaceVariantSummary,
                        modifier = Modifier.widthIn(max = 196.dp),
                    )
                }
            }
            ShutterButton(
                stop = shutterStop(videoLike, recording, lapseRunning),
                videoLike = videoLike,
                enabled = shutterEnabled,
                busy = commandInFlight,
                label = shutterLabel,
                onClick = {
                    when {
                        videoLike -> state.record(!recording)
                        lapseRunning -> state.stopCapture()
                        else -> state.capture()
                    }
                },
            )
        }
    }

    // The full-screen picture: no bar, no list, no scroll — just the frame and the shutter
    // that has to stay reachable while it is up. It is the same picture composable, so the
    // rotation, the flash and the stream rebuild all behave identically; what changes is
    // only how much room it is given (2026-09-24 「图传部分可以通过长按变成全屏预览状态（此时
    // 会保留录制键依旧悬浮）再次长按退出」).
    if (state.previewFullscreen) {
        // The fraction is the shell's, not this page's: a back gesture pulls the picture down and
        // decides whether to let it go, and the gesture reaches `App`, not here. At rest it is 1 and
        // this is a plain full-screen box.
        Box(
            Modifier.fillMaxSize().graphicsLayer {
                val reveal = state.previewReveal
                alpha = reveal
                translationY = (1f - reveal) * size.height * 0.18f
                val shrink = 0.94f + 0.06f * reveal
                scaleX = shrink
                scaleY = shrink
            },
        ) {
            Box(Modifier.fillMaxSize().background(Color.Black)) {
                CameraPreviewFrame(previewUrl, Modifier.fillMaxSize(), spinDegrees, spinSwap)
                // A long press anywhere on the picture puts it back. No tap handler: the shutter
                // below is the only thing on this screen that a tap should reach.
                Box(
                    Modifier
                        .fillMaxSize()
                        .pointerInput(Unit) {
                            detectTapGestures(onLongPress = { state.setFullscreenPreview(false) })
                        },
                )
                shutter()
            }
        }
        return
    }

    MiuixPage(
        title = liveTitle,
        outerPadding = outerPadding,
        state = state,
        subtitle = barStatus,
        listBottomInset = shutterBand,
        listState = listState,
        // 自动跟随 rides in the overflow now (2026-09-23 「自动跟随移入更多菜单」): the toggle
        // does not belong in a card under a live video surface, and the ⋯ menu is where
        // per-page switches live across the app. The check mark reflects the current state.
        menuItems = listOf(
            AppBarMenuItem(label = rotateLbl, checked = rotating.value) {
                rotating.value = !rotating.value
            },
        ),
        header = {
            Column {
                PreviewHeader(
                    url = previewUrl,
                    degrees = spinDegrees,
                    swap = spinSwap,
                    recording = recording,
                    busy = busy,
                    recTimeSec = st?.videoTimeSec ?: 0,
                    photos = st?.photoCount,
                    flashNonce = state.captureFlash,
                    shrink = scrolled,
                    onLongPress = { state.setFullscreenPreview(true) },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        },
        floating = shutter,
    ) {
        // Every card on this page shields horizontal drags: the tab pager underneath would
        // otherwise take a drag that began on a card's padding or on the label beside a slider,
        // and change tab instead of moving the control under the finger.
        //
        // There used to be a 状态 card above this one, repeating 录制 and 模式 as a two-value
        // line. Both facts are already on screen and in a better place: the camera is in
        // whatever mode the chip below is lit for, and 录制 is the picture's own badge — a
        // pulsing dot with the elapsed time — plus the shutter turning into a square. A row
        // that only ever repeated the two controls under it was a card that cost a screenful
        // and said nothing (2026-09-24 「去掉状态一块，反正拍摄模式也能看出状态」).
        section(title = modeTitle, swipeShield = true) {
            ModeStrip(
                modes = modes,
                selected = current?.name,
                locked = working,
                videoLabel = stringResource(Res.string.workmode_video),
                photoLabel = stringResource(Res.string.workmode_photo),
                onSelect = { state.selectMode(it) },
                onSelectFamily = { state.setMode(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 4.dp),
            )
            if (working) valueItem(lockedLbl, lockedModeMsg)
        }

        // The quick-adjust rows, straight from the current mode's own menu: an id named
        // below only earns a row when `getprimarymenuitem` actually sent it.
        val bars = quickBarIds.mapNotNull { id -> state.settings.firstOrNull { it.id == id } }
            .filter { it.options.size >= 2 && !it.isToggle }
        val chips = quickChoiceIds.mapNotNull { id -> state.settings.firstOrNull { it.id == id } }
            .filter { it.options.size >= 2 }
        if (bars.isNotEmpty() || chips.isNotEmpty()) {
            section(title = quickAdjustTitle, swipeShield = true) {
                bars.forEach { s ->
                    QuickAdjustBar(
                        setting = s,
                        enabled = !working && !state.isBusy(Op.Settings),
                        onCommit = { value -> state.setSetting(s.id, value) },
                    )
                }
                chips.forEach { s ->
                    QuickChoiceRow(
                        setting = s,
                        enabled = !working && !state.isBusy(Op.Settings),
                        onCommit = { value -> state.setSetting(s.id, value) },
                    )
                }
                hintLine(if (working) adjustLockedMsg else quickAdjustHint)
            }
        }
    }
}

/**
 * Which of the two shapes the shutter wears: a square to stop, a disc to start.
 *
 * Same priority as the label and the click branch further up: a video family follows the
 * camera's own `recording` flag — a timelapse the camera has not reported as recording
 * keeps the disc its 录制 label names — and only a photo family lets a running lapse
 * decide it. Reading `lapseRunning` first here drew a square over a button that was
 * labelled 录制 and would have started one.
 */
private fun shutterStop(videoLike: Boolean, recording: Boolean, lapseRunning: Boolean): Boolean =
    if (videoLike) recording else lapseRunning

/**
 * The pinned preview block: the picture, a badge over it while the camera is working,
 * and a flash of white when a photo actually lands.
 *
 * The box is *sized* rather than left to `aspectRatio` alone because the rotated case is
 * tall — a 9:16 box on a phone is ~700dp, which on a pinned header would push every
 * control off the screen. The cap keeps the picture's own proportions and leaves the
 * panel below something to be scrolled through.
 *
 * [shrink] is that cap moving, 0 for the full height and 1 for the small one: the rotated
 * picture takes three quarters of the screen, which is right for framing and wrong for the
 * sliders underneath it, so scrolling trades the picture's height for theirs and scrolling
 * back gives it up again (2026-09-24 「图传图像横屏时可以随着滚动最多缩小至半屏」). Only the
 * rotated case shrinks — the upright picture is already a third of the screen.
 *
 * A long press asks for the full-screen view. The gesture is on the picture because the
 * picture is the thing that goes full screen; it is not on the frame itself (that is a
 * `TextureView`, which does not consume touches) but on the Compose box drawn over it.
 *
 * The flash is keyed to the camera's own photo count rather than to the tap: a shutter
 * that flashed on request would claim a picture the camera then refused to take.
 */
@Composable
private fun PreviewHeader(
    url: String?,
    degrees: Float,
    swap: Boolean,
    recording: Boolean,
    busy: Boolean,
    recTimeSec: Int,
    photos: Int?,
    flashNonce: Int = 0,
    shrink: Float = 0f,
    onLongPress: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    var flashed by remember { mutableStateOf(false) }
    var lastPhotos by remember { mutableStateOf<Int?>(null) }
    var lastFlash by remember { mutableStateOf(flashNonce) }
    LaunchedEffect(photos) {
        val before = lastPhotos
        lastPhotos = photos
        if (before != null && photos != null && photos > before) {
            flashed = true
            delay(110)
            flashed = false
        }
    }
    // The press flash. Fires the moment the shutter is touched instead of when the camera
    // publishes its new photo count — waiting for that count is what made the old feedback
    // read as 2–3 s late, because `photo.cgi` answers before the card is updated.
    LaunchedEffect(flashNonce) {
        if (flashNonce != lastFlash) {
            lastFlash = flashNonce
            flashed = true
            delay(110)
            flashed = false
        }
    }
    val flashAlpha by animateFloatAsState(
        if (flashed) 0.5f else 0f,
        tween(if (flashed) 40 else 320),
        label = "flash",
    )

    BoxWithConstraints(modifier.padding(horizontal = 12.dp, vertical = 4.dp)) {
        val wanted = if (swap) maxWidth * 16f / 9f else maxWidth * 9f / 16f
        // The rotated case gets most of the screen on purpose. Turning the phone puts a
        // 9:16 box in a portrait canvas, and capping it at half the height — which is
        // what this did — leaves a picture narrower than the phone is wide, so the
        // framing he turned the phone *for* was smaller than the one he gets holding it
        // straight (2026-09-23 「画面横屏时太小了 看不清」). Three quarters leaves the
        // control panel a scrollable strip; the shutter floats, so it stays reachable.
        // Scrolling walks that three quarters down to a half — the two thirds the slider
        // rows need — and the shutter keeps floating over whatever is left.
        val limit = maxHeight * if (swap) (0.76f - 0.26f * shrink.coerceIn(0f, 1f)) else 0.42f
        val boxH = minOf(wanted, limit)
        val boxW = if (swap) boxH * 9f / 16f else maxWidth
        Box(
            Modifier
                .align(Alignment.Center)
                .size(boxW, boxH)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black)
                .pointerInput(Unit) {
                    detectTapGestures(onLongPress = { onLongPress() })
                },
            contentAlignment = Alignment.Center,
        ) {
            CameraPreviewFrame(url, Modifier.fillMaxSize(), degrees, swap)
            // Drawn over the picture, but with no input handler of its own, so it never
            // stands between the user and the frame underneath.
            Box(Modifier.fillMaxSize().background(Color.White.copy(alpha = flashAlpha)))
            if (recording || busy) {
                Row(
                    Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(Color.Black.copy(alpha = 0.55f))
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // The pulse lives in its own composable so that the frame loop it
                    // needs exists only while the camera is actually recording. Left
                    // running idle it recomposes this subtree sixty times a second
                    // beside a video decoder, for a dot nobody is looking at.
                    if (recording) PulsingDot() else SolidDot(MiuixTheme.colorScheme.primary)
                    Spacer(Modifier.width(6.dp))
                    Text(
                        if (recording) formatTime(recTimeSec) else stringResource(Res.string.rec_busy),
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }
}

/** The record badge's dot, breathing. */
@Composable
private fun PulsingDot() {
    val pulse = rememberInfiniteTransition(label = "rec")
    val alpha by pulse.animateFloat(
        initialValue = 0.35f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(680), RepeatMode.Reverse),
        label = "dot",
    )
    SolidDot(MiuixTheme.colorScheme.error.copy(alpha = alpha))
}

@Composable
private fun SolidDot(color: Color) {
    Box(Modifier.size(8.dp).clip(CircleShape).background(color))
}

/**
 * The preview, rotated by the phone's own attitude without touching the app's layout.
 *
 * Rotating the video layer alone is not enough: a 16:9 stream measured into the tall
 * 9:16 box the rotated frame now needs would be squashed first and turned second. So
 * the child is measured with its width and height swapped, then rotated in place —
 * which is also why [PreviewHeader] flips its own box at the same moment.
 */
@Composable
private fun CameraPreviewFrame(url: String?, modifier: Modifier, degrees: Float, swap: Boolean) {
    Box(modifier.fillMaxSize().background(Color.Black), contentAlignment = Alignment.Center) {
        CameraPreviewView(
            url,
            Modifier
                .fillMaxSize()
                .layout { measurable, constraints ->
                    val w = constraints.maxWidth
                    val h = constraints.maxHeight
                    val child = if (swap && w > 0 && h > 0) Constraints.fixed(h, w) else constraints
                    val placeable = measurable.measure(child)
                    layout(w, h) {
                        placeable.placeRelative((w - placeable.width) / 2, (h - placeable.height) / 2)
                    }
                }
                .rotate(degrees),
        )
    }
}

/**
 * The floating shutter.
 *
 * One control for 录像 / 停止 / 拍照 / 停止连拍, told apart by shape rather than by the
 * word on it: a disc with a ring to start, a small square to stop. That is the iOS
 * Camera convention this app is already styled after, and it survives the panel
 * scrolling under the button — a label that had to be read every frame would not.
 *
 * The morph is animated so the change is *seen*: a shutter that silently swaps disc for
 * square reads as the press having done nothing at all.
 */
@Composable
private fun ShutterButton(
    stop: Boolean,
    videoLike: Boolean,
    enabled: Boolean,
    busy: Boolean,
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val scheme = MiuixTheme.colorScheme
    val haptics = LocalHapticFeedback.current
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val press by animateFloatAsState(if (pressed) 0.93f else 1f, tween(110), label = "press")
    // A single-shot photo gets a squeeze of its own on top of the press: the camera
    // answers with nothing but a card write, and 「它到底拍没拍」 is the one question a
    // shutter has to answer. The white flash on the picture confirms the file; this
    // confirms the press.
    val shot = remember { Animatable(1f) }
    val animating = rememberCoroutineScope()
    val innerSize by animateDpAsState(if (stop) 26.dp else 46.dp, tween(200), label = "inner")
    val innerRadius by animateDpAsState(if (stop) 7.dp else 23.dp, tween(200), label = "radius")
    // Colour is chosen, not tweened: `animateColorAsState` is not on this app's compile
    // classpath (it ships outside `animation.core`), and the morph that has to be *seen*
    // is the disc becoming a square — which the two sizes above already carry. Colour
    // only ever changes with the mode, one screen away from being noticed.
    val innerColor = when {
        !enabled -> scheme.disabledOnSurface
        stop || videoLike -> scheme.error
        else -> scheme.primary
    }

    Box(
        modifier
            .size(74.dp)
            .shadow(8.dp, CircleShape)
            .clip(CircleShape)
            .background(scheme.surfaceVariant)
            .border(1.dp, scheme.outline, CircleShape)
            .graphicsLayer {
                scaleX = press
                scaleY = press
                alpha = if (enabled) 1f else 0.72f
            }
            .clickable(
                interactionSource = interaction,
                indication = null,
                enabled = enabled,
                onClickLabel = label,
            ) {
                // A shutter is the one press in the app with weight behind it, so it gets
                // the heavy haptic rather than the ordinary tap — and it fires before the
                // command goes out, so the phone answers even when the camera is slow.
                haptics.longPress()
                if (!stop && !videoLike) {
                    animating.launch {
                        shot.animateTo(0.78f, tween(80))
                        shot.animateTo(1f, tween(220))
                    }
                }
                onClick()
            },
        contentAlignment = Alignment.Center,
    ) {
        if (busy) {
            InfiniteProgressIndicator(
                color = scheme.onSurfaceVariantSummary,
                size = 26.dp,
                strokeWidth = 2.5.dp,
                orbitingDotSize = 3.dp,
            )
        } else {
            Box(
                Modifier
                    .size(innerSize)
                    .graphicsLayer { scaleX = shot.value; scaleY = shot.value }
                    .clip(RoundedCornerShape(innerRadius))
                    .background(innerColor),
            )
        }
    }
}

/**
 * One draggable quick-adjust slider for one ordered camera setting — the control the
 * 2026-09-22 report asked for (「曝光这些设置项，可以在实时页面底部新增一个横向 slider」)
 * and the 2026-09-23 one asked to be made *proper* (「能使用体面的方式吗？比如说滑块，
 * 进度条可拖动的」). It is the library's own `Slider` now, not a row of clickable blocks,
 * snapped to the firmware's steps.
 *
 * Two rules make this safe to put next to a live view:
 *
 * **One write per gesture.** The camera serves one request at a time and answers a
 * `setcurparameter` in tens of milliseconds while the same link carries RTSP; a slider
 * that wrote on every pixel of a drag would be a self-inflicted denial of service on
 * the preview — the 7.6 s stall in the 2026-09-23 log is what that link looks like when
 * it is merely busy. The drag moves a local draft; the value goes out on release.
 *
 * **Lowest on the left, highest on the right.** See [orderedAdjustOptions]: the
 * firmware's own order is descending for `Exposure`, which no one reading a slider
 * would guess.
 */
@Composable
private fun QuickAdjustBar(
    setting: CameraSetting,
    enabled: Boolean,
    onCommit: (String) -> Unit,
) {
    val options = orderedAdjustOptions(setting)
    if (options.size < 2) return
    val lastIndex = options.lastIndex
    val currentIndex = options.indexOfFirst { it.value == setting.value }.coerceIn(0, lastIndex)
    var draft by remember(setting.value, options) { mutableStateOf(currentIndex) }
    val haptics = LocalHapticFeedback.current

    // The library's own stepped-slider row: it puts the label on the title edge and the
    // current stop on the same end edge a switch would occupy, which is the alignment a
    // hand-built label + slider + value `Row` could not hold when a label wrapped.
    SliderPreference(
        value = draft.toFloat(),
        onValueChange = { draft = it.roundToInt().coerceIn(0, lastIndex) },
        title = MenuCatalog.titleOf(setting.id, setting.title, false),
        valueText = MenuCatalog.valueShortLabel(setting.id, options[draft].value),
        valueRange = 0f..lastIndex.toFloat(),
        // `steps` counts the stops *between* the two ends, one fewer than the number of
        // gaps: this puts a tick exactly under each firmware value.
        steps = (lastIndex - 1).coerceAtLeast(0),
        // A tick under every firmware档 (2026-09-23 「每档一个刻度点」): keyPoints lists one
        // float per option so the dots line up with the values the slider snaps to, rather
        // than the evenly-spaced defaults `steps` alone would draw.
        showKeyPoints = true,
        keyPoints = remember(lastIndex) { (0..lastIndex).map { it.toFloat() } },
        enabled = enabled,
        onValueChangeFinished = {
            // Only on a real move: the slider reports "finished" for a tap that did not
            // change the stop too, and buzzing then would confirm a write that never left.
            if (draft != currentIndex) {
                haptics.tick()
                onCommit(options[draft].value)
            }
        },
    )
}

/**
 * One short menu item as a row of tappable chips — 防抖、测光、白平衡 and the rest of
 * [quickChoiceIds], none of which is a scale and so has no business on a bar.
 *
 * The chips are the firmware's own option list, one write per tap, for the same reason
 * the sliders above commit on release: this link also carries the preview.
 */
@Composable
private fun QuickChoiceRow(
    setting: CameraSetting,
    enabled: Boolean,
    onCommit: (String) -> Unit,
) {
    val options = orderedAdjustOptions(setting)
    if (options.size < 2) return
    val haptics = LocalHapticFeedback.current
    Row(
        Modifier
            .fillMaxWidth()
            .heightIn(min = 42.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AdjustLabel(setting, Modifier.width(64.dp))
        Spacer(Modifier.width(10.dp))
        LazyRow(
            Modifier.weight(1f).graphicsLayer { alpha = if (enabled) 1f else 0.45f },
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(options, key = { it.value }) { option ->
                Chip(
                    label = MenuCatalog.valueShortLabel(setting.id, option.value),
                    selected = option.value == setting.value,
                    enabled = enabled,
                    small = true,
                    onClick = {
                        // A chip that is already the current stop writes nothing, so it
                        // does not buzz either — the same rule the bars follow.
                        if (option.value != setting.value) {
                            haptics.tick()
                            onCommit(option.value)
                        }
                    },
                )
            }
        }
    }
}

/** The setting's Chinese name, in the fixed-width column both quick-adjust rows share. */
@Composable
private fun AdjustLabel(setting: CameraSetting, modifier: Modifier = Modifier) {
    Text(
        text = MenuCatalog.titleOf(setting.id, setting.title),
        fontSize = 12.sp,
        color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier,
    )
}

/**
 * The firmware's option list, ordered the way a control reads: lowest on the left,
 * highest on the right (2026-09-23 「其他值按照从低到高的顺序排，最高的在右边」).
 *
 * `Exposure` answers `+2,+1.5,+1,+0.5,0,-0.5,-1,-1.5,-2` — **descending**, because that
 * is the order the CGI happens to list them in, not an order anyone reading a slider
 * would guess. Only the display order changes; the value sent back is still the
 * firmware's own string.
 *
 * Two cases are left alone on purpose:
 *
 *  - A leading non-numeric option — `Auto` on ISO and 快门速度 — is a *mode*, not a
 *    magnitude, so it stays at the far left where the firmware put it instead of
 *    sorting into the middle of the scale.
 *  - A list with no numbers at all (`High,Medium,Low`) keeps the firmware's order.
 *    There is nothing here to rank it by, and guessing that `High` is the big end is a
 *    different bug waiting for the next firmware.
 */
private fun orderedAdjustOptions(setting: CameraSetting): List<CameraSetting.Option> {
    val options = setting.options
    if (options.size < 3) return options
    val leading = options.takeWhile { parseAdjustValue(it.value) == null }
    val rest = options.drop(leading.size)
    if (rest.size < 2 || rest.any { parseAdjustValue(it.value) == null }) return options
    return leading + rest.sortedBy { parseAdjustValue(it.value) }
}

/**
 * The magnitude behind one firmware option string, or null when it names a mode rather
 * than a quantity. Understands the `+` the exposure steps carry and the `1/1000` form a
 * shutter list uses.
 */
private fun parseAdjustValue(raw: String): Double? {
    val text = raw.trim().removePrefix("+")
    if (text.isEmpty()) return null
    val slash = text.indexOf('/')
    if (slash > 0) {
        val numerator = text.substring(0, slash).toDoubleOrNull() ?: return null
        val denominator = text.substring(slash + 1).toDoubleOrNull() ?: return null
        return if (denominator == 0.0) null else numerator / denominator
    }
    return text.toDoubleOrNull()
}

/**
 * How much of a scroll the picture is allowed to spend its height on.
 *
 * The shrink is driven by the list's own offset, so it needs a distance to divide by:
 * [LiveScreen] maps 0…this many pixels of scroll onto a 0…1 factor that [PreviewHeader]
 * turns into height. One short flick is enough to get there, and the reverse gesture
 * gives the height straight back, so the picture never gets stuck small.
 */
private val PreviewShrinkDistance = 120.dp

/**
 * The ordered shooting settings worth a bar on the live page, in the order they are
 * worth reaching for while framing: exposure first, then the two things that trade
 * brightness against noise and motion blur, then the picture-style trio.
 *
 * Only ids the camera actually sent get a row (see [LiveScreen]), so a mode with no
 * `Shutter` simply shows one bar fewer. A firmware that answers these as a plain
 * ON/OFF pair is filtered out by the `isToggle` check at the call site rather than
 * being rendered as a one-step slider.
 */
private val quickBarIds = listOf(
    "Exposure",
    "ISO",
    "Shutter",
    "brightness",
    "Contrast",
    "Saturation",
    "Sharpness",
)

/**
 * The short categorical settings worth a chip row.
 *
 * `Resolution` and `Segment` are deliberately absent: their option strings are long,
 * and changing them is a decision rather than a nudge — that is the settings page.
 * `Filter` is here because it is burned into the file, so it has to be chosen before
 * the shot, not after.
 */
private val quickChoiceIds = listOf(
    "Gyro EIS",
    "Meter Mode",
    "AWB",
    "Image Quality",
    "Filter",
)

/**
 * Video / photo tabs plus the mode chips under the selected one.
 *
 * Two levels because a flat list of 15 modes does not fit a phone: the family tab is
 * the coarse switch the firmware understands even when it hides its mode table, and
 * the chips are the modes themselves. When the camera reports no modes, the family tab
 * is the whole control — which is exactly what this screen offered before.
 */
@Composable
private fun ModeStrip(
    modes: List<com.rovecamlink.app.core.model.CameraMode>,
    selected: String?,
    locked: Boolean,
    videoLabel: String,
    photoLabel: String,
    onSelect: (com.rovecamlink.app.core.model.CameraMode) -> Unit,
    onSelectFamily: (WorkMode) -> Unit,
    modifier: Modifier = Modifier,
) {
    val selectedFamily = modes.firstOrNull { it.name == selected }?.family
    var tab by remember(selectedFamily) {
        mutableStateOf(if (selectedFamily == ModeFamily.PHOTO) 1 else 0)
    }
    val haptics = LocalHapticFeedback.current
    fun chipsOf(family: ModeFamily) = modes.filter { it.family == family }
    Column(modifier) {
        // The contour variant, because this one lives *inside* a card: the standard
        // `TabRow` is a sibling of the card in the demo and sizes its segments from
        // different min/max widths than the in-card shape does.
        TabRowWithContour(
            tabs = listOf(videoLabel, photoLabel),
            selectedTabIndex = tab,
            onTabSelected = { index ->
                // A locked camera refuses the family switch the same way the chips below
                // do: without a mode table this tab *is* the control that writes workmode.
                if (locked) return@TabRowWithContour
                val switching = index != tab
                if (switching) haptics.tick()
                tab = index
                // The chip row under the tab is a different family now, so the tab has to
                // move the *mode* into it as well — selecting the family's first mode.
                // Merely filtering the rows left the camera on the old mode until a second
                // tap, which read as "the switch did nothing" (2026-09-24 report).
                val family = if (index == 0) ModeFamily.VIDEO else ModeFamily.PHOTO
                val familyChips = chipsOf(family)
                if (familyChips.isEmpty()) {
                    onSelectFamily(if (index == 0) WorkMode.VIDEO else WorkMode.PHOTO)
                } else if (switching) {
                    val first = familyChips.first()
                    if (first.name != selected) onSelect(first)
                }
            },
            modifier = Modifier.fillMaxWidth(),
        )
        val chips = chipsOf(if (tab == 0) ModeFamily.VIDEO else ModeFamily.PHOTO)
        if (chips.isEmpty()) return@Column
        Spacer(Modifier.height(10.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(chips, key = { it.name }) { mode ->
                Chip(
                    label = ModeCatalog.titleOf(mode.name),
                    selected = mode.name == selected,
                    enabled = !locked,
                    onClick = {
                        if (mode.name != selected) {
                            haptics.tick()
                            onSelect(mode)
                        }
                    },
                )
            }
        }
        Spacer(Modifier.height(6.dp))
    }
}

/**
 * A rounded label that reads as a choice.
 *
 * [small] is the quick-adjust density: same shape, one step tighter, because those rows
 * carry five or six of them next to a 64.dp title and the mode strip carries four wide
 * ones with the whole width to itself.
 */
@Composable
private fun Chip(
    label: String,
    selected: Boolean,
    enabled: Boolean,
    small: Boolean = false,
    onClick: () -> Unit,
) {
    val scheme = MiuixTheme.colorScheme
    val background = if (selected) scheme.primary else scheme.surfaceVariant
    val content = if (selected) scheme.onPrimary else scheme.onSurface
    Box(
        Modifier
            .heightIn(min = if (small) 28.dp else 34.dp)
            .clip(RoundedCornerShape(if (small) 14.dp else 17.dp))
            .background(background)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(
                horizontal = if (small) 10.dp else 14.dp,
                vertical = if (small) 3.dp else 6.dp,
            ),
        // Without this the box defaults to TopStart and the `heightIn` slack all lands
        // under the label, which is why the quick-adjust rows read as riding high
        // (2026-09-24 「部分文字没有上下居中」).
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            fontSize = if (small) 12.sp else 13.sp,
            color = if (enabled) content else scheme.disabledOnSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
        )
    }
}

private fun WorkMode.workModeFamily(): ModeFamily =
    if (this == WorkMode.VIDEO) ModeFamily.VIDEO else ModeFamily.PHOTO

private fun formatTime(sec: Int): String {
    val m = sec / 60
    val s = sec % 60
    return "${if (m < 10) "0$m" else "$m"}:${if (s < 10) "0$s" else "$s"}"
}
