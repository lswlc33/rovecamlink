@file:OptIn(com.robinpcrd.cupertino.ExperimentalCupertinoApi::class)

package com.rovecamlink.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robinpcrd.cupertino.CupertinoActivityIndicator
import com.robinpcrd.cupertino.CupertinoAlertDialog
import com.robinpcrd.cupertino.CupertinoButton
import com.robinpcrd.cupertino.CupertinoButtonDefaults
import com.robinpcrd.cupertino.CupertinoButtonSize
import com.robinpcrd.cupertino.CupertinoIcon
import com.robinpcrd.cupertino.CupertinoIconButton
import com.robinpcrd.cupertino.CupertinoSegmentedControl
import com.robinpcrd.cupertino.CupertinoSegmentedControlTab
import com.robinpcrd.cupertino.CupertinoSwitch
import com.robinpcrd.cupertino.CupertinoText
import com.robinpcrd.cupertino.CupertinoTextField
import com.robinpcrd.cupertino.MenuPickerAction
import com.robinpcrd.cupertino.cancel
import com.robinpcrd.cupertino.destructive
import com.robinpcrd.cupertino.icons.CupertinoIcons
import com.robinpcrd.cupertino.icons.filled.Bolt
import com.robinpcrd.cupertino.icons.filled.CheckmarkSquare
import com.robinpcrd.cupertino.icons.filled.Externaldrive
import com.robinpcrd.cupertino.icons.filled.Film
import com.robinpcrd.cupertino.icons.filled.Photo
import com.robinpcrd.cupertino.icons.filled.RecordCircle
import com.robinpcrd.cupertino.icons.filled.StopCircle
import com.robinpcrd.cupertino.icons.filled.Terminal
import com.robinpcrd.cupertino.icons.filled.TrashSlash
import com.robinpcrd.cupertino.icons.filled.TrayAndArrowDown
import com.robinpcrd.cupertino.icons.filled.Video
import com.robinpcrd.cupertino.section.CupertinoLinkIcon
import com.robinpcrd.cupertino.section.LazySectionScope
import com.robinpcrd.cupertino.section.dropdownMenu
import com.robinpcrd.cupertino.section.link
import com.robinpcrd.cupertino.section.section
import com.robinpcrd.cupertino.section.sectionTitle
import com.robinpcrd.cupertino.section.switch
import com.robinpcrd.cupertino.section.textField
import com.robinpcrd.cupertino.theme.CupertinoColors
import com.robinpcrd.cupertino.theme.CupertinoTheme
import com.robinpcrd.cupertino.theme.systemGreen
import com.robinpcrd.cupertino.theme.systemOrange
import com.robinpcrd.cupertino.theme.systemRed
import com.rovecamlink.app.AppState
import com.rovecamlink.app.DownloadItem
import com.rovecamlink.app.Op
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_app_settings
import com.rovecamlink.app.action_cancel_short
import com.rovecamlink.app.action_cancelled
import com.rovecamlink.app.action_clear_finished
import com.rovecamlink.app.action_delete_count
import com.rovecamlink.app.action_delete_file
import com.rovecamlink.app.action_diagnostics
import com.rovecamlink.app.action_dismiss
import com.rovecamlink.app.action_done
import com.rovecamlink.app.action_download_count
import com.rovecamlink.app.action_download_file
import com.rovecamlink.app.action_factory_reset
import com.rovecamlink.app.action_format_sd
import com.rovecamlink.app.action_logging
import com.rovecamlink.app.action_photo
import com.rovecamlink.app.action_raise_access_point
import com.rovecamlink.app.action_reboot_camera
import com.rovecamlink.app.action_record
import com.rovecamlink.app.action_refresh_device_info
import com.rovecamlink.app.action_refresh_files
import com.rovecamlink.app.action_reload_settings
import com.rovecamlink.app.action_retry_failed
import com.rovecamlink.app.action_retry_file
import com.rovecamlink.app.action_select
import com.rovecamlink.app.action_select_firmware
import com.rovecamlink.app.action_start_lapse
import com.rovecamlink.app.action_stop
import com.rovecamlink.app.action_stop_lapse
import com.rovecamlink.app.action_sync_camera_time
import com.rovecamlink.app.cancel
import com.rovecamlink.app.confirm_format
import com.rovecamlink.app.confirm_reboot
import com.rovecamlink.app.confirm_reset
import com.rovecamlink.app.delete
import com.rovecamlink.app.download_done
import com.rovecamlink.app.download_failed
import com.rovecamlink.app.file_type_photo
import com.rovecamlink.app.file_type_video
import com.rovecamlink.app.files_none_refresh
import com.rovecamlink.app.firmware_unsupported
import com.rovecamlink.app.hint_batch_delete_many
import com.rovecamlink.app.hint_locked_capture
import com.rovecamlink.app.hint_locked_mode
import com.rovecamlink.app.hint_new_password
import com.rovecamlink.app.hint_new_ssid
import com.rovecamlink.app.hint_photo_needs_photo_mode
import com.rovecamlink.app.hint_quick_adjust
import com.rovecamlink.app.hint_rotate_picture
import com.rovecamlink.app.label_batch
import com.rovecamlink.app.label_battery
import com.rovecamlink.app.label_camera_settings
import com.rovecamlink.app.label_clear_selection
import com.rovecamlink.app.label_device_settings
import com.rovecamlink.app.label_files
import com.rovecamlink.app.label_firmware
import com.rovecamlink.app.label_free
import com.rovecamlink.app.label_hardware
import com.rovecamlink.app.label_hint
import com.rovecamlink.app.label_host
import com.rovecamlink.app.label_installed
import com.rovecamlink.app.label_locked
import com.rovecamlink.app.label_mac
import com.rovecamlink.app.label_mode
import com.rovecamlink.app.label_model
import com.rovecamlink.app.label_name
import com.rovecamlink.app.label_note
import com.rovecamlink.app.label_photo_count
import com.rovecamlink.app.label_rec
import com.rovecamlink.app.label_region
import com.rovecamlink.app.label_sd_free
import com.rovecamlink.app.label_sd_state
import com.rovecamlink.app.label_select_all
import com.rovecamlink.app.label_serial
import com.rovecamlink.app.label_settings
import com.rovecamlink.app.label_status
import com.rovecamlink.app.label_total
import com.rovecamlink.app.label_unknown_date
import com.rovecamlink.app.label_wifi_name
import com.rovecamlink.app.message_delete_file
import com.rovecamlink.app.msg_factory_reset
import com.rovecamlink.app.msg_format_sd
import com.rovecamlink.app.msg_reboot
import com.rovecamlink.app.not_connected_note
import com.rovecamlink.app.not_connected_title
import com.rovecamlink.app.note_wifi_restarts
import com.rovecamlink.app.rec_busy
import com.rovecamlink.app.rec_idle
import com.rovecamlink.app.save
import com.rovecamlink.app.sd_error
import com.rovecamlink.app.sd_missing
import com.rovecamlink.app.sd_ok
import com.rovecamlink.app.sd_unknown
import com.rovecamlink.app.section_about
import com.rovecamlink.app.section_camera_wifi
import com.rovecamlink.app.section_capture
import com.rovecamlink.app.section_capture_mode
import com.rovecamlink.app.section_danger
import com.rovecamlink.app.section_downloads
import com.rovecamlink.app.section_firmware_update
import com.rovecamlink.app.section_on_camera
import com.rovecamlink.app.section_quick_adjust
import com.rovecamlink.app.section_sd_card
import com.rovecamlink.app.section_status
import com.rovecamlink.app.settings_none_reload
import com.rovecamlink.app.status_update_applied
import com.rovecamlink.app.tab_camera
import com.rovecamlink.app.tab_device
import com.rovecamlink.app.tab_software
import com.rovecamlink.app.title_delete_count
import com.rovecamlink.app.title_delete_file
import com.rovecamlink.app.title_factory_reset
import com.rovecamlink.app.title_format_sd
import com.rovecamlink.app.title_reboot
import com.rovecamlink.app.workmode_photo
import com.rovecamlink.app.workmode_video
import com.rovecamlink.app.resolve
import com.rovecamlink.app.core.media.CameraPreviewView
import com.rovecamlink.app.core.media.OrientationMode
import com.rovecamlink.app.core.media.rememberDeviceOrientation
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.ModeFamily
import com.rovecamlink.app.core.model.ModeTrigger
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.SdCardState
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.model.groupFilesByDay
import com.rovecamlink.app.core.ota.OtaState
import org.jetbrains.compose.resources.stringResource

/** Section rows follow the library's own minimum row height. */
private val RowMinHeight = 45.dp

private fun humanBytes(b: Long): String = when {
    b <= 0 -> "—"
    b < 1024 -> "$b B"
    b < 1024 * 1024 -> "${b / 1024} KB"
    b < 1024L * 1024 * 1024 -> "${b / (1024 * 1024)} MB"
    else -> "${b / (1024L * 1024 * 1024)} GB"
}

private fun formatTime(sec: Int): String {
    val m = sec / 60
    val s = sec % 60
    return "${if (m < 10) "0$m" else "$m"}:${if (s < 10) "0$s" else "$s"}"
}

/** Firmware OTA state → words. Raw on purpose: this is a developer-visible status. */
private fun otaLabel(s: OtaState): String = when (s) {
    OtaState.Idle -> ""
    OtaState.WaitingForDevice -> "等待相机…"
    OtaState.Uploading -> "上传中…"
    OtaState.Installing -> "安装中…"
    OtaState.WaitingForReboot -> "相机重启中…"
    OtaState.Reconnecting -> "重新连接中…"
    is OtaState.ConfirmingVersion -> "核对版本（${s.expected}）…"
    OtaState.Completed -> "已更新"
    OtaState.Cancelled -> "已取消"
    is OtaState.Failed -> s.message
}

// ============================ shared widgets ============================

@Composable
private fun NotConnected(note: String = stringResource(Res.string.not_connected_note)) {
    Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            CupertinoIcon(
                CupertinoIcons.Filled.Video,
                contentDescription = null,
                tint = CupertinoTheme.colorScheme.tertiaryLabel,
                modifier = Modifier.size(40.dp),
            )
            CupertinoText(
                text = stringResource(Res.string.not_connected_title),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            CupertinoText(note, color = CupertinoTheme.colorScheme.secondaryLabel, fontSize = 13.sp)
        }
    }
}

/** Thin progress line used by the download rows. */
@Composable
private fun ProgressLine(progress: Float) {
    Box(
        Modifier
            .fillMaxWidth()
            .heightIn(min = 4.dp)
            .background(CupertinoTheme.colorScheme.quaternarySystemFill),
    ) {
        Box(
            Modifier
                .fillMaxWidth(progress.coerceIn(0f, 1f))
                .heightIn(min = 4.dp)
                .background(CupertinoTheme.colorScheme.accent),
        )
    }
}

private fun LazySectionScope.valueItem(title: String, value: String) {
    item {
        Row(
            Modifier.fillMaxWidth().heightIn(min = RowMinHeight).padding(it),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(Modifier.weight(1f)) { CupertinoText(title) }
            CupertinoText(value, color = CupertinoTheme.colorScheme.secondaryLabel)
        }
    }
}

/** A section header used between two `section { }` blocks in the same list. */
private fun LazySectionScope.groupHeader(text: String) {
    item {
        Column(Modifier.fillMaxWidth().padding(it).padding(top = 10.dp, bottom = 2.dp)) {
            CupertinoText(
                text,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = CupertinoTheme.colorScheme.accent,
            )
        }
    }
}

// ============================ Live ============================

/**
 * The live view, the shooting-mode strip and the shutter.
 *
 * The preview picture rotates with how the phone is held (item 10) — the picture
 * only: the app's own layout stays put, and the frame swaps 16:9 / 9:16 so a rotated
 * view fills its box instead of turning into a letterbox inside a letterbox.
 *
 * Modes come from the camera, not from a list in this app: `getallworkmode.cgi` (or
 * the modes whose menu the firmware will answer for) is what decides whether 长曝光 or
 * 延时拍照 appears at all.
 */
@Composable
fun LiveScreen(state: AppState) {
    val session = state.session
    if (session == null) {
        NotConnected()
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

    // The official client syncs the clock every time the preview screen is built
    // (`HaisiPreviewModel.requestPreviewParams`), not just once at connect: a camera
    // that has been sitting switched-off for a week otherwise stamps every clip with
    // the wrong hour. Best-effort, and silent.
    LaunchedEffect(session.host) { state.syncTime() }

    val family = current?.family ?: st?.mode?.workModeFamily() ?: ModeFamily.VIDEO
    val videoLike = family == ModeFamily.VIDEO
    val toggle = current?.trigger == ModeTrigger.TOGGLE
    val working = recording || busy
    // One reason, whichever it is, for the shutter being unavailable — a greyed-out
    // control with no explanation reads as a broken app rather than a busy camera.
    val captureHint = when {
        recording -> stringResource(Res.string.hint_locked_capture)
        busy && !toggle -> stringResource(Res.string.rec_busy)
        !videoLike && modes.isEmpty() -> stringResource(Res.string.hint_photo_needs_photo_mode)
        else -> null
    }

    val statusTitle = stringResource(Res.string.section_status).sectionTitle()
    val modeTitle = stringResource(Res.string.section_capture_mode).sectionTitle()
    val captureTitle = stringResource(Res.string.section_capture).sectionTitle()
    val batteryLbl = stringResource(Res.string.label_battery)
    val modeLbl = stringResource(Res.string.label_mode)
    val recLbl = stringResource(Res.string.label_rec)
    val sdFreeLbl = stringResource(Res.string.label_sd_free)
    val photoCountLbl = stringResource(Res.string.label_photo_count)
    val hintLbl = stringResource(Res.string.label_hint)
    val lockedLbl = stringResource(Res.string.label_locked)
    val rotateLbl = stringResource(Res.string.hint_rotate_picture)
    val lockedModeMsg = stringResource(Res.string.hint_locked_mode)
    val photoModeHint = stringResource(Res.string.hint_photo_needs_photo_mode)
    val recBusyLbl = stringResource(Res.string.rec_busy)
    val startLapseLbl = stringResource(Res.string.action_start_lapse)
    val stopLapseLbl = stringResource(Res.string.action_stop_lapse)
    val quickAdjustTitle = stringResource(Res.string.section_quick_adjust).sectionTitle()
    val quickAdjustHint = stringResource(Res.string.hint_quick_adjust)

    LazyColumn(Modifier.fillMaxSize()) {
        item {
            // 12.dp of the outer padding is the only margin here: the video box used
            // to sit inside a full-width Box that added its own inset, which is the
            // "异常边距" the report called out.
            Column(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp)) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(if (orientation.isLandscapeFrame) 9f / 16f else 16f / 9f)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.Black),
                    contentAlignment = Alignment.Center,
                ) {
                    CameraPreviewFrame(
                        previewUrl,
                        Modifier.fillMaxSize(),
                        orientation.degrees,
                        swap = orientation.isLandscapeFrame,
                    )
                }
                Row(
                    Modifier.fillMaxWidth().padding(top = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    CupertinoSwitch(checked = rotating.value, onCheckedChange = { rotating.value = it })
                    Spacer(Modifier.width(8.dp))
                    CupertinoText(rotateLbl, fontSize = 12.sp, color = CupertinoTheme.colorScheme.secondaryLabel)
                }
            }
        }

        section(title = { CupertinoText(statusTitle) }) {
            item {
                Row(
                    Modifier.fillMaxWidth().padding(it).padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    StatTile(
                        CupertinoIcons.Filled.Bolt,
                        batteryLbl,
                        st?.battery?.let { "$it%" } ?: "—",
                        CupertinoColors.systemGreen,
                    )
                    StatTile(
                        CupertinoIcons.Filled.RecordCircle,
                        recLbl,
                        when {
                            recording -> formatTime(st?.videoTimeSec ?: 0)
                            busy -> recBusyLbl
                            else -> stringResource(Res.string.rec_idle)
                        },
                        when {
                            recording -> CupertinoColors.systemRed
                            busy -> CupertinoColors.systemOrange
                            else -> CupertinoTheme.colorScheme.tertiaryLabel
                        },
                    )
                    StatTile(
                        CupertinoIcons.Filled.Photo,
                        photoCountLbl,
                        st?.photoCount?.toString() ?: "—",
                        CupertinoTheme.colorScheme.secondaryLabel,
                    )
                    StatTile(
                        CupertinoIcons.Filled.Externaldrive,
                        sdFreeLbl,
                        st?.sdFreeMb?.let { humanBytes(it * 1024 * 1024) } ?: "—",
                        CupertinoTheme.colorScheme.secondaryLabel,
                    )
                }
            }
            infoRow(modeLbl, current?.let { ModeCatalog.titleOf(it.name) } ?: "—")
        }

        section(title = { CupertinoText(modeTitle) }) {
            item {
                ModeStrip(
                    modes = modes,
                    selected = current?.name,
                    locked = working,
                    videoLabel = stringResource(Res.string.workmode_video),
                    photoLabel = stringResource(Res.string.workmode_photo),
                    onSelect = { state.selectMode(it) },
                    onSelectFamily = { state.setMode(it) },
                )
            }
            val help = current?.let { ModeCatalog.helpOf(it.name) }
            if (help != null) {
                item {
                    Column(Modifier.fillMaxWidth().padding(it)) {
                        CupertinoText(help, fontSize = 11.sp, color = CupertinoTheme.colorScheme.tertiaryLabel)
                    }
                }
            }
            if (working) valueItem(lockedLbl, lockedModeMsg)
        }

        // The quick-adjust bars, straight from the current mode's own menu: whatever
        // `Exposure` the camera offers is what the bar can write back.
        val quickAdjust = quickAdjustIds.mapNotNull { id -> state.settings.firstOrNull { it.id == id } }
        if (quickAdjust.isNotEmpty() && !working) {
            section(title = { CupertinoText(quickAdjustTitle) }) {
                quickAdjust.forEach { s ->
                    item {
                        QuickAdjustBar(
                            setting = s,
                            enabled = !state.isBusy(Op.Settings),
                            onCommit = { value -> state.setSetting(s.id, value) },
                        )
                    }
                }
                valueItem(hintLbl, quickAdjustHint)
            }
        }

        section(title = { CupertinoText(captureTitle) }) {
            item {
                Row(
                    Modifier.fillMaxWidth().padding(it).padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    AccentButton(
                        label = if (videoLike) {
                            stringResource(if (recording) Res.string.action_stop else Res.string.action_record)
                        } else if (toggle) {
                            stringResource(
                                if (state.captureRunning) Res.string.action_stop_lapse else Res.string.action_start_lapse,
                            )
                        } else {
                            stringResource(Res.string.action_photo)
                        },
                        modifier = Modifier.weight(1f),
                        busy = state.isBusy(Op.Capture) || state.isBusy(Op.Record),
                        enabled = !busy && (videoLike || !state.needsPhotoModeForShutter()),
                        container = if (videoLike) CupertinoColors.systemRed else CupertinoTheme.colorScheme.accent,
                        onClick = {
                            if (videoLike) {
                                state.record(!recording)
                            } else if (toggle && state.captureRunning) {
                                state.stopCapture()
                            } else {
                                state.capture()
                            }
                        },
                    )
                }
            }
            captureHint?.let { valueItem(hintLbl, it) }
        }
    }
}

/**
 * The preview, rotated by the phone's own attitude without touching the app's layout.
 *
 * Rotating the video layer alone is not enough: a 16:9 stream measured into the tall
 * 9:16 box the rotated frame now needs would be squashed first and turned second. So
 * the child is measured with its width and height swapped, then rotated in place —
 * which is also why [Box] above flips its own aspect ratio at the same moment.
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
 * A horizontal quick-adjust bar for one ordered camera setting — the shutter-speed
 * style control the 2026-09-22 report asked for (「曝光这些设置项，可以在实时页面底部新增
 * 一个横向 slider」).
 *
 * Two rules make this safe to put next to a live view:
 *
 * **One write per gesture.** The camera serves one request at a time and answers a
 * `setcurparameter` in tens of milliseconds while the same link carries RTSP; a
 * slider that wrote on every pixel of a drag would be a self-inflicted denial of
 * service on the preview. The drag moves a local draft, and the value goes out on
 * release (or immediately on a tap, which *is* one gesture).
 *
 * **The firmware's own option list, in its own order.** `Exposure` answers
 * `+2,+1.5,+1,+0.5,0,-0.5,-1,-1.5,-2` — descending, so index 0 is the *brightest*
 * end. Sorting or re-deriving these would put the handle on the wrong side of the
 * bar, so the bar is literally the list, left to right.
 */
@Composable
private fun QuickAdjustBar(
    setting: CameraSetting,
    enabled: Boolean,
    onCommit: (String) -> Unit,
) {
    val options = setting.options
    if (options.size < 2) return
    val currentIndex = options.indexOfFirst { it.value == setting.value }.coerceAtLeast(0)
    var draft by remember(setting.value, options) { mutableStateOf(currentIndex) }
    val selectedColor = CupertinoTheme.colorScheme.accent
    val trackColor = CupertinoTheme.colorScheme.tertiaryLabel

    Column(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp)) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            CupertinoText(
                MenuCatalog.titleOf(setting.id, setting.title),
                fontSize = 13.sp,
                color = CupertinoTheme.colorScheme.secondaryLabel,
            )
            Spacer(Modifier.weight(1f))
            CupertinoText(
                MenuCatalog.valueLabel(setting.id, options[draft].value),
                fontSize = 13.sp,
                color = CupertinoTheme.colorScheme.label,
            )
        }
        Spacer(Modifier.height(6.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .height(26.dp)
                .clip(RoundedCornerShape(6.dp))
                .pointerInput(options) {
                    detectHorizontalDragGestures(
                        onDragStart = { offset -> draft = segmentAt(offset.x, size.width, options.size) },
                        onHorizontalDrag = { change, _ ->
                            draft = segmentAt(change.position.x, size.width, options.size)
                        },
                        // The whole point of the draft: this is the only place a drag
                        // reaches the camera — and not even then if the handle ended up
                        // back on the value it started from.
                        onDragEnd = { if (draft != currentIndex) onCommit(options[draft].value) },
                        onDragCancel = { draft = currentIndex },
                    )
                },
            horizontalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            options.forEachIndexed { index, option ->
                // Each segment is a real target too: a tap is one gesture, so it writes
                // straight away instead of waiting for a release that never comes.
                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(4.dp))
                        .background(if (index == draft) selectedColor else trackColor.copy(alpha = 0.28f))
                        .clickable(enabled = enabled && index != currentIndex) { onCommit(option.value) },
                    contentAlignment = Alignment.Center,
                ) {
                    if (option.value == setting.value) {
                        Box(Modifier.size(5.dp).clip(CircleShape).background(Color.White))
                    }
                }
            }
        }
    }
}

/** Which segment of a [QuickAdjustBar] an x position inside it falls on. */
private fun segmentAt(x: Float, widthPx: Int, count: Int): Int {
    if (widthPx <= 0 || count <= 0) return 0
    return ((x / widthPx) * count).toInt().coerceIn(0, count - 1)
}

/**
 * The shooting settings worth a bar on the live page.
 *
 * Deliberately one entry: `Exposure` is the only item that is both ordered, present
 * across modes, and something anyone wants to nudge while framing. `ISO` and `Shutter`
 * are menus, not scales, and putting them here would turn a quick control into the
 * settings page again.
 */
private val quickAdjustIds = listOf("Exposure")

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
) {
    val selectedFamily = modes.firstOrNull { it.name == selected }?.family
    var tab by remember(selectedFamily) {
        mutableStateOf(if (selectedFamily == ModeFamily.PHOTO) 1 else 0)
    }
    fun chipsOf(family: ModeFamily) = modes.filter { it.family == family }
    Column {
        CupertinoSegmentedControl(
            selectedTabIndex = tab,
            modifier = Modifier.fillMaxWidth(),
            paddingValues = PaddingValues(0.dp),
        ) {
            CupertinoSegmentedControlTab(
                onClick = {
                    tab = 0
                    // With a mode table the chip row does the switching, so the tab is
                    // only a filter. Without one it *is* the control, and has to fall
                    // back to the coarse family switch this app used before.
                    if (chipsOf(ModeFamily.VIDEO).isEmpty()) onSelectFamily(WorkMode.VIDEO)
                },
                isSelected = tab == 0,
            ) {
                CupertinoText(videoLabel, fontSize = 13.sp)
            }
            CupertinoSegmentedControlTab(
                onClick = {
                    tab = 1
                    if (chipsOf(ModeFamily.PHOTO).isEmpty()) onSelectFamily(WorkMode.PHOTO)
                },
                isSelected = tab == 1,
            ) {
                CupertinoText(photoLabel, fontSize = 13.sp)
            }
        }
        val chips = chipsOf(if (tab == 0) ModeFamily.VIDEO else ModeFamily.PHOTO)
        if (chips.isEmpty()) return
        Spacer(Modifier.height(8.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(chips, key = { it.name }) { mode ->
                ModeChip(
                    label = ModeCatalog.titleOf(mode.name),
                    selected = mode.name == selected,
                    enabled = !locked,
                    onClick = { onSelect(mode) },
                )
            }
        }
    }
}

@Composable
private fun ModeChip(label: String, selected: Boolean, enabled: Boolean, onClick: () -> Unit) {
    val scheme = CupertinoTheme.colorScheme
    val background = if (selected) scheme.accent else scheme.tertiarySystemFill
    val content = if (selected) Color.White else scheme.label
    Box(
        Modifier
            .heightIn(min = 32.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(background)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 6.dp),
    ) {
        CupertinoText(
            label,
            fontSize = 13.sp,
            color = if (enabled) content else scheme.tertiaryLabel,
            maxLines = 1,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
        )
    }
}

private fun WorkMode.workModeFamily(): ModeFamily =
    if (this == WorkMode.VIDEO) ModeFamily.VIDEO else ModeFamily.PHOTO

@Composable
private fun StatTile(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, value: String, tint: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        CupertinoIcon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(18.dp))
        CupertinoText(value, fontWeight = FontWeight.SemiBold, fontSize = 15.sp, maxLines = 1)
        CupertinoText(
            label,
            color = CupertinoTheme.colorScheme.secondaryLabel,
            fontSize = 11.sp,
            maxLines = 1,
        )
    }
}

// ============================ Files ============================

@Composable
fun FilesScreen(state: AppState) {
    if (state.session == null) {
        NotConnected()
        return
    }
    // Deleting is irreversible on the camera, so it goes through a confirm dialog.
    var pendingDelete by remember { mutableStateOf<RemoteFile?>(null) }
    var pendingBatchDelete by remember { mutableStateOf(false) }
    var selectMode by remember { mutableStateOf(false) }
    val selected = remember { mutableStateListOf<String>() }

    val groups = remember(state.files) { groupFilesByDay(state.files) }
    val selectedCount = state.files.count { selected.contains(it.name) }
    val allSelected = state.files.isNotEmpty() && state.files.all { selected.contains(it.name) }

    val refreshLabel = stringResource(Res.string.action_refresh_files)
    val downloadsTitle = stringResource(Res.string.section_downloads).sectionTitle()
    val onCameraTitle = stringResource(Res.string.section_on_camera, state.files.size).sectionTitle()
    val filesNone = stringResource(Res.string.files_none_refresh)
    val deleteTitle = stringResource(Res.string.title_delete_file)
    val cancelLabel = stringResource(Res.string.cancel)
    val deleteLabel = stringResource(Res.string.delete)
    val doneLabel = stringResource(Res.string.download_done)
    val failedLabel = stringResource(Res.string.download_failed)
    val videoLbl = stringResource(Res.string.file_type_video)
    val photoLbl = stringResource(Res.string.file_type_photo)
    val selectLbl = stringResource(if (selectMode) Res.string.action_done else Res.string.action_select)
    val selectAllLbl = stringResource(
        if (allSelected) Res.string.label_clear_selection else Res.string.label_select_all,
    )
    val batchTitle = stringResource(Res.string.label_batch).sectionTitle()
    val hintDeleteMany = stringResource(Res.string.hint_batch_delete_many)
    val filesLbl = stringResource(Res.string.label_files)
    val clearFinishedLbl = stringResource(Res.string.action_clear_finished)
    val retryFailedLbl = stringResource(Res.string.action_retry_failed)
    val unknownDateLbl = stringResource(Res.string.label_unknown_date)

    LazyColumn(Modifier.fillMaxSize()) {
        section {
            actionRow(
                refreshLabel,
                busy = state.isBusy(Op.Refresh),
                onClick = { state.refreshFiles() },
            )
            actionRow(selectLbl, onClick = {
                selectMode = !selectMode
                if (!selectMode) selected.clear()
            })
        }

        if (selectMode) {
            section(title = { CupertinoText(batchTitle) }) {
                item {
                    Row(
                        Modifier.fillMaxWidth().padding(it).padding(vertical = 6.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        SmallButton(selectAllLbl, modifier = Modifier.weight(1f)) {
                            if (allSelected) {
                                selected.clear()
                            } else {
                                state.files.forEach { f ->
                                    if (!selected.contains(f.name)) selected.add(f.name)
                                }
                            }
                        }
                        SmallButton(
                            stringResource(Res.string.action_download_count, selectedCount),
                            modifier = Modifier.weight(1f),
                            enabled = selectedCount > 0,
                        ) {
                            state.files.filter { selected.contains(it.name) }.forEach { state.download(it) }
                        }
                        SmallButton(
                            stringResource(Res.string.action_delete_count, selectedCount),
                            modifier = Modifier.weight(1f),
                            enabled = selectedCount > 0 && !state.isBusy(Op.Delete),
                            destructive = true,
                        ) { pendingBatchDelete = true }
                    }
                }
            }
        }

        if (state.downloads.isNotEmpty()) {
            section(title = { CupertinoText(downloadsTitle) }) {
                if (state.downloads.any { it.state == DownloadItem.State.Done }) {
                    actionItem(clearFinishedLbl) { state.clearFinishedDownloads() }
                }
                if (state.downloads.any { it.state == DownloadItem.State.Failed }) {
                    actionItem(retryFailedLbl) { state.retryFailedDownloads() }
                }
                state.downloads.forEach { d -> downloadItem(d, doneLabel, failedLabel) }
            }
        }

        groups.forEach { g ->
            val heading = (g.key?.toString() ?: unknownDateLbl) +
                " · " + g.files.size
            section(title = { CupertinoText(heading.sectionTitle()) }) {
                g.files.forEach { f ->
                    fileItem(
                        state = state,
                        f = f,
                        videoLabel = videoLbl,
                        photoLabel = photoLbl,
                        selectMode = selectMode,
                        selected = selected.contains(f.name),
                        onToggle = {
                            if (selected.contains(f.name)) selected.remove(f.name)
                            else selected.add(f.name)
                        },
                        onDelete = { pendingDelete = f },
                    )
                }
            }
        }

        if (state.files.isEmpty()) {
            section(title = { CupertinoText(onCameraTitle) }) {
                valueItem(filesLbl, filesNone)
            }
        }
    }

    pendingDelete?.let { target ->
        CupertinoAlertDialog(
            onDismissRequest = { pendingDelete = null },
            title = { CupertinoText(deleteTitle) },
            message = {
                CupertinoText(
                    stringResource(Res.string.message_delete_file, target.name.substringAfterLast('/')),
                )
            },
            buttons = {
                cancel(onClick = { pendingDelete = null }) { CupertinoText(cancelLabel) }
                destructive(
                    onClick = {
                        state.deleteFile(target)
                        pendingDelete = null
                    },
                    title = { CupertinoText(deleteLabel) },
                )
            },
        )
    }

    if (pendingBatchDelete) {
        val targets = state.files.filter { selected.contains(it.name) }
        CupertinoAlertDialog(
            onDismissRequest = { pendingBatchDelete = false },
            title = { CupertinoText(stringResource(Res.string.title_delete_count, targets.size)) },
            message = { CupertinoText(hintDeleteMany) },
            buttons = {
                cancel(onClick = { pendingBatchDelete = false }) { CupertinoText(cancelLabel) }
                destructive(
                    onClick = {
                        state.deleteFiles(targets)
                        selected.clear()
                        selectMode = false
                        pendingBatchDelete = false
                    },
                    title = { CupertinoText(deleteLabel) },
                )
            },
        )
    }
}

/** One row of the batch bar; the three actions are equal in weight. */
@Composable
private fun SmallButton(
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    destructive: Boolean = false,
    onClick: () -> Unit,
) {
    CupertinoButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        size = CupertinoButtonSize.Small,
        colors = if (destructive) {
            CupertinoButtonDefaults.filledButtonColors(containerColor = CupertinoColors.systemRed)
        } else {
            CupertinoButtonDefaults.grayButtonColors()
        },
    ) {
        CupertinoText(label, fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}

private fun LazySectionScope.actionItem(title: String, onClick: () -> Unit) =
    actionRow(title, onClick = onClick)

private fun LazySectionScope.downloadItem(d: DownloadItem, doneLabel: String, failedLabel: String) {
    item {
        Column(Modifier.fillMaxWidth().padding(it).padding(vertical = 4.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                CupertinoText(
                    text = d.file.name.substringAfterLast('/'),
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                when (d.state) {
                    DownloadItem.State.Running, DownloadItem.State.Queued ->
                        CupertinoActivityIndicator(size = 16.dp)
                    DownloadItem.State.Done ->
                        CupertinoText(doneLabel, color = CupertinoColors.systemGreen, fontSize = 13.sp)
                    DownloadItem.State.Failed ->
                        CupertinoText(failedLabel, color = CupertinoColors.systemRed, fontSize = 13.sp)
                }
            }
            if (d.state == DownloadItem.State.Running || d.state == DownloadItem.State.Queued) {
                Spacer(Modifier.size(6.dp))
                ProgressLine(d.progress)
            }
        }
    }
}

private fun LazySectionScope.fileItem(
    state: AppState,
    f: RemoteFile,
    videoLabel: String,
    photoLabel: String,
    selectMode: Boolean,
    selected: Boolean,
    onToggle: () -> Unit,
    onDelete: () -> Unit,
) {
    item {
        val isVideo = f.type == FileType.VIDEO
        // Ask for the preview from *inside* the row, not while the list is being
        // built: this UI kit materialises a whole section body eagerly, so the old
        // call site fetched a thumbnail per file on the card — dozens of megabyte
        // JPEGs at once against one hotspot, which is what crashed the tab.
        LaunchedEffect(f.name) { state.loadThumbnail(f) }
        Row(
            Modifier
                .fillMaxWidth()
                .heightIn(min = RowMinHeight)
                .then(if (selectMode) Modifier.clickable(onClick = onToggle) else Modifier)
                .padding(it),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (selectMode) {
                if (selected) {
                    CupertinoIcon(
                        CupertinoIcons.Filled.CheckmarkSquare,
                        contentDescription = null,
                        tint = CupertinoTheme.colorScheme.accent,
                        modifier = Modifier.size(22.dp),
                    )
                } else {
                    Box(
                        Modifier
                            .size(22.dp)
                            .border(
                                1.5.dp,
                                CupertinoTheme.colorScheme.separator,
                                CupertinoTheme.shapes.small,
                            )
                            .clip(CupertinoTheme.shapes.small),
                    )
                }
                Spacer(Modifier.width(10.dp))
            }
            FileThumbnail(state.thumbnails[f.name], isVideo)
            Spacer(Modifier.width(10.dp))
            Column(Modifier.weight(1f)) {
                CupertinoText(
                    text = f.name.substringAfterLast('/'),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                val failure = state.downloadError(f.name)
                if (failure != null) {
                    CupertinoText(
                        text = failure.resolve(),
                        color = CupertinoColors.systemRed,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                } else {
                    val meta = listOfNotNull(
                        if (isVideo) videoLabel else photoLabel,
                        humanBytes(f.sizeBytes).takeIf { f.sizeBytes > 0 },
                    )
                    CupertinoText(
                        text = meta.joinToString(" · "),
                        color = CupertinoTheme.colorScheme.secondaryLabel,
                        fontSize = 12.sp,
                    )
                }
            }
            // In select mode the row toggles instead of acting, so its trailing
            // buttons are hidden rather than left there to mis-fire.
            if (!selectMode) {
                Spacer(Modifier.width(6.dp))
                val transfer = state.downloadState(f.name)
                if (transfer == DownloadItem.State.Running || transfer == DownloadItem.State.Queued) {
                    CupertinoActivityIndicator(size = 20.dp)
                    Spacer(Modifier.width(12.dp))
                } else {
                    val retry = transfer == DownloadItem.State.Failed
                    CupertinoIconButton(
                        onClick = { state.download(f) },
                        colors = if (retry) {
                            CupertinoButtonDefaults.plainButtonColors(contentColor = CupertinoColors.systemRed)
                        } else {
                            CupertinoButtonDefaults.plainButtonColors()
                        },
                    ) {
                        CupertinoIcon(
                            CupertinoIcons.Filled.TrayAndArrowDown,
                            contentDescription = stringResource(
                                if (retry) Res.string.action_retry_file else Res.string.action_download_file,
                                f.name,
                            ),
                            modifier = Modifier.size(20.dp),
                        )
                    }
                }
                CupertinoIconButton(
                    onClick = onDelete,
                    enabled = !state.isBusy(Op.Delete),
                    colors = CupertinoButtonDefaults.plainButtonColors(
                        contentColor = CupertinoColors.systemRed,
                    ),
                ) {
                    CupertinoIcon(
                        CupertinoIcons.Filled.TrashSlash,
                        contentDescription = stringResource(Res.string.action_delete_file, f.name),
                        modifier = Modifier.size(20.dp),
                    )
                }
            }
        }
    }
}

/** File row icon: the decoded camera thumbnail when we have one, else a type glyph. */
@Composable
private fun FileThumbnail(bitmap: ImageBitmap?, isVideo: Boolean) {
    val size = 36.dp
    if (bitmap != null) {
        Image(
            bitmap = bitmap,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(size)
                .clip(CupertinoTheme.shapes.small),
        )
    } else {
        Box(
            Modifier.size(size).clip(CupertinoTheme.shapes.small).background(
                if (isVideo) CupertinoTheme.colorScheme.accent else CupertinoColors.systemOrange,
            ),
            contentAlignment = Alignment.Center,
        ) {
            CupertinoIcon(
                imageVector = if (isVideo) CupertinoIcons.Filled.Film else CupertinoIcons.Filled.Photo,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.dp),
            )
        }
    }
}

// ============================ Settings ============================

/** Maintenance actions that permanently alter the device, gated by a confirm dialog. */
private enum class DangerOp { FormatSd, FactoryReset, Reboot }

/**
 * Three pages in one tab: the camera's shooting menu, the **device's** own menu
 * (`workmode=System` on the XTU CGI family — watermarks, tones, grid, clock, SD
 * format, the things that are not a function of the shooting mode), and this app's
 * settings, which must be reachable with no camera connected at all.
 */
@Composable
fun SettingsScreen(state: AppState) {
    var expandedId by remember { mutableStateOf<String?>(null) }
    var pending by remember { mutableStateOf<DangerOp?>(null) }
    var wifiSsid by remember { mutableStateOf("") }
    var wifiPass by remember { mutableStateOf("") }
    var wifiSubmit by remember { mutableStateOf(false) }
    var logging by remember { mutableStateOf(com.rovecamlink.app.core.log.Diag.config.fileSink) }

    val connected = state.session != null
    val info = state.deviceInfo
    val st = state.deviceStatus

    val appSettingsTitle = stringResource(Res.string.action_app_settings).sectionTitle()
    val cameraSettingsTitle = stringResource(Res.string.label_camera_settings).sectionTitle()
    val deviceSettingsTitle = stringResource(Res.string.label_device_settings).sectionTitle()
    val cameraTabLbl = stringResource(Res.string.tab_camera)
    val deviceTabLbl = stringResource(Res.string.tab_device)
    val appTabLbl = stringResource(Res.string.tab_software)
    val reloadLabel = stringResource(Res.string.action_reload_settings)
    val saveLabel = stringResource(Res.string.save)
    val statusLbl = stringResource(Res.string.label_status)
    val noteLbl = stringResource(Res.string.label_note)
    val totalLbl = stringResource(Res.string.label_total)
    val freeLbl = stringResource(Res.string.label_free)
    val recordingNote = stringResource(Res.string.hint_locked_capture)
    val loggingLbl = stringResource(Res.string.action_logging)
    val diagnosticsLbl = stringResource(Res.string.action_diagnostics)
    val syncTimeLbl = stringResource(Res.string.action_sync_camera_time)
    val raiseApLbl = stringResource(Res.string.action_raise_access_point)
    val notConnectedNote = stringResource(Res.string.not_connected_note)
    val settingsLbl = stringResource(Res.string.label_settings)
    val settingsNone = stringResource(Res.string.settings_none_reload)
    val aboutTitle = stringResource(Res.string.section_about).sectionTitle()
    val nameLbl = stringResource(Res.string.label_name)
    val modelLbl = stringResource(Res.string.label_model)
    val firmwareLbl = stringResource(Res.string.label_firmware)
    val hardwareLbl = stringResource(Res.string.label_hardware)
    val serialLbl = stringResource(Res.string.label_serial)
    val regionLbl = stringResource(Res.string.label_region)
    val macLbl = stringResource(Res.string.label_mac)
    val wifiLbl = stringResource(Res.string.label_wifi_name)
    val hostLbl = stringResource(Res.string.label_host)
    val sdStateTitle = stringResource(Res.string.label_sd_state)
    val refreshInfoLbl = stringResource(Res.string.action_refresh_device_info)
    val firmwareTitle = stringResource(Res.string.section_firmware_update).sectionTitle()
    val installedLbl = stringResource(Res.string.label_installed)
    val selectFirmwareLbl = stringResource(Res.string.action_select_firmware)
    val firmwareUnsupportedLbl = stringResource(Res.string.firmware_unsupported)
    val updateAppliedLbl = stringResource(Res.string.status_update_applied)
    val dismissLbl = stringResource(Res.string.action_dismiss)
    val cancelledLbl = stringResource(Res.string.action_cancelled)
    val cancelLbl = stringResource(Res.string.cancel)
    val shortCancelLbl = stringResource(Res.string.action_cancel_short)
    val sdCardTitle = stringResource(Res.string.section_sd_card).sectionTitle()
    val formatSdLbl = stringResource(Res.string.action_format_sd)
    val cameraWifiTitle = stringResource(Res.string.section_camera_wifi).sectionTitle()
    val newSsidHint = stringResource(Res.string.hint_new_ssid)
    val newPassHint = stringResource(Res.string.hint_new_password)
    val wifiRestartNote = stringResource(Res.string.note_wifi_restarts)
    val dangerTitle = stringResource(Res.string.section_danger).sectionTitle()
    val rebootLbl = stringResource(Res.string.action_reboot_camera)
    val factoryResetLbl = stringResource(Res.string.action_factory_reset)
    val sdStateLbl = when (st?.sdState) {
        SdCardState.OK -> stringResource(Res.string.sd_ok)
        SdCardState.MISSING -> stringResource(Res.string.sd_missing)
        SdCardState.ERROR -> stringResource(Res.string.sd_error)
        SdCardState.UNKNOWN, null -> stringResource(Res.string.sd_unknown)
    }

    /**
     * Which of the three menus the page is showing.
     *
     * Three tabs because the three lists have three different owners and a user
     * looking for one thing has no business scrolling past the other two: 相机 is the
     * shooting menu of the **current mode** (it changes when the mode changes), 设备 is
     * the camera box itself (`-workmode=System`, plus its information, card, hotspot,
     * firmware and the destructive rows), 软件 is this app. A single list put
     * 「快门速度」 twelve rows away from 「恢复出厂设置」, which is how the 2026-09-22
     * field report ended up asking for exactly this split.
     */
    var tab by remember { mutableStateOf(TAB_CAMERA) }

    Column(Modifier.fillMaxSize()) {
        CupertinoSegmentedControl(
            selectedTabIndex = tab,
            modifier = Modifier.fillMaxWidth(),
            paddingValues = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
        ) {
            listOf(cameraTabLbl, deviceTabLbl, appTabLbl).forEachIndexed { index, label ->
                CupertinoSegmentedControlTab(
                    onClick = { tab = index },
                    isSelected = tab == index,
                ) {
                    CupertinoText(label, fontSize = 13.sp)
                }
            }
        }

        when (tab) {
            // ---- 相机: the shooting menu of the current mode ----
            TAB_CAMERA -> LazyColumn(Modifier.weight(1f).fillMaxWidth()) {
                if (!connected) {
                    section {
                        valueItem(noteLbl, notConnectedNote)
                    }
                    return@LazyColumn
                }
                section(title = { CupertinoText(cameraSettingsTitle) }) {
                    if (state.deviceStatus?.recording == true) {
                        valueItem(noteLbl, recordingNote)
                    }
                    if (state.settings.isEmpty()) {
                        valueItem(
                            settingsLbl,
                            settingsNone,
                        )
                    }
                    groupSettingsForDisplay(state.settings).forEach { (group, rows) ->
                        groupHeader(group.zhTitle)
                        rows.forEach { s ->
                            settingRow(
                                state = state,
                                s = s,
                                device = false,
                                expanded = expandedId == s.id,
                                onOpen = { expandedId = s.id },
                                onClose = { if (expandedId == s.id) expandedId = null },
                                saveLabel = saveLabel,
                            )
                        }
                    }
                    actionRow(reloadLabel, busy = state.isBusy(Op.Settings)) { state.loadSettings() }
                }
            }

            // ---- 设备: the camera box, its card, its hotspot and its firmware ----
            TAB_DEVICE -> LazyColumn(Modifier.weight(1f).fillMaxWidth()) {
                if (!connected) {
                    section {
                        valueItem(noteLbl, notConnectedNote)
                    }
                    return@LazyColumn
                }
                if (state.deviceSettings.isNotEmpty()) {
                    section(title = { CupertinoText(deviceSettingsTitle) }) {
                        groupDeviceSettingsForDisplay(state.deviceSettings).forEach { (group, rows) ->
                            groupHeader(group.zhTitle)
                            rows.forEach { s ->
                                settingRow(
                                    state = state,
                                    s = s,
                                    device = true,
                                    expanded = expandedId == "dev:" + s.id,
                                    onOpen = { expandedId = "dev:" + s.id },
                                    onClose = { if (expandedId == "dev:" + s.id) expandedId = null },
                                    saveLabel = saveLabel,
                                )
                            }
                        }
                        actionRow(reloadLabel, busy = state.isBusy(Op.Settings)) { state.loadDeviceSettings() }
                    }
                }

                section(title = { CupertinoText(aboutTitle.sectionTitle()) }) {
                    valueItem(nameLbl, info?.name.dashOr(state.session?.model))
                    valueItem(
                        modelLbl,
                        info?.model?.takeUnless { it.isBlank() || it.all { c -> c.isDigit() } }
                            ?: state.session?.model ?: "—",
                    )
                    valueItem(firmwareLbl, info.softVersionDash())
                    valueItem(hardwareLbl, info.hardVersionDash())
                    valueItem(
                        serialLbl,
                        info?.serialNumber
                            ?.takeUnless { it.isBlank() || (it.all { c -> c.isDigit() } && it.length <= 2) } ?: "—",
                    )
                    valueItem(regionLbl, info.regionDash())
                    valueItem(macLbl, info.macDash())
                    valueItem(wifiLbl, info.ssidDash())
                    valueItem(hostLbl, state.session?.let { "${it.host}:${it.port}" } ?: "—")
                    valueItem(
                        sdStateTitle,
                        if (st?.sdState == null) "—" else sdStateLbl,
                    )
                    actionRow(
                        syncTimeLbl,
                        busy = state.isBusy(Op.Settings),
                        onClick = { state.syncTime() },
                    )
                    actionRow(
                        refreshInfoLbl,
                        busy = state.isBusy(Op.DeviceInfo),
                        onClick = { state.loadDeviceInfo() },
                    )
                }

                section(title = { CupertinoText(firmwareTitle) }) {
                    valueItem(installedLbl, info?.softVersion ?: "—")
                    when (val ota = state.otaState) {
                        OtaState.Idle -> actionRow(
                            label = if (state.firmwareUpdateSupported()) {
                                selectFirmwareLbl
                            } else {
                                firmwareUnsupportedLbl
                            },
                            enabled = state.firmwareUpdateSupported(),
                        ) { state.installFirmwareUpdate() }

                        OtaState.Completed -> {
                            valueItem(statusLbl, updateAppliedLbl)
                            actionRow(dismissLbl) { state.resetOtaState() }
                        }
                        OtaState.Cancelled -> actionRow(cancelledLbl) { state.resetOtaState() }
                        is OtaState.Failed -> {
                            valueItem(statusLbl, ota.message)
                            actionRow(dismissLbl) { state.resetOtaState() }
                        }
                        else -> {
                            valueItem(statusLbl, otaLabel(ota))
                            actionRow(cancelLbl) { state.cancelFirmwareUpdate() }
                        }
                    }
                }

                section(title = { CupertinoText(sdCardTitle.sectionTitle()) }) {
                    valueItem(totalLbl, st?.sdTotalMb?.let { humanBytes(it * 1024 * 1024) } ?: "—")
                    valueItem(freeLbl, st?.sdFreeMb?.let { humanBytes(it * 1024 * 1024) } ?: "—")
                    actionRow(
                        formatSdLbl,
                        busy = state.isBusy(Op.FormatSd),
                    ) { pending = DangerOp.FormatSd }
                }

                section(title = { CupertinoText(cameraWifiTitle.sectionTitle()) }) {
                    textField(
                        value = wifiSsid,
                        onValueChange = { wifiSsid = it; wifiSubmit = false },
                        placeholder = { CupertinoText(info?.ssid?.ifBlank { null } ?: newSsidHint) },
                        singleLine = true,
                    )
                    textField(
                        value = wifiPass,
                        onValueChange = { wifiPass = it; wifiSubmit = false },
                        placeholder = { CupertinoText(newPassHint) },
                        singleLine = true,
                    )
                    item {
                        val wifiBusy = wifiSubmit && state.isBusy(Op.Settings)
                        Row(Modifier.fillMaxWidth().padding(it), horizontalArrangement = Arrangement.End) {
                            CupertinoButton(
                                onClick = {
                                    wifiSubmit = true
                                    state.setCameraWifi(wifiSsid.trim(), wifiPass.trim())
                                },
                                enabled = wifiSsid.isNotBlank() && wifiPass.isNotBlank() && !state.isBusy(Op.Settings),
                                size = CupertinoButtonSize.Small,
                            ) {
                                if (wifiBusy) {
                                    CupertinoActivityIndicator(size = 12.dp, color = Color.White)
                                    Spacer(Modifier.width(6.dp))
                                }
                                CupertinoText(saveLabel)
                            }
                        }
                    }
                    if (wifiSubmit) {
                        valueItem(noteLbl, wifiRestartNote)
                    }
                    // The other half of "the app cannot open the camera's hotspot": when the
                    // camera is reachable but not broadcasting, this is the one command that
                    // brings the AP back without going through Bluetooth at all.
                    actionRow(
                        raiseApLbl,
                        busy = state.isBusy(Op.AccessPoint),
                        enabled = state.canRaiseAccessPoint(),
                    ) { state.raiseAccessPoint() }
                }

                section(title = { CupertinoText(dangerTitle.sectionTitle()) }) {
                    if (state.session?.platform == DevicePlatform.TUWIN_REST) {
                        actionRow(
                            rebootLbl,
                            busy = state.isBusy(Op.Reboot),
                        ) { pending = DangerOp.Reboot }
                    }
                    actionRow(
                        factoryResetLbl,
                        busy = state.isBusy(Op.FactoryReset),
                    ) { pending = DangerOp.FactoryReset }
                }
            }

            // ---- 软件: this app ----
            TAB_SOFTWARE -> LazyColumn(Modifier.weight(1f).fillMaxWidth()) {
                section(title = { CupertinoText(appSettingsTitle) }) {
                    switch(
                        checked = logging,
                        onCheckedChange = {
                            logging = it
                            com.rovecamlink.app.core.log.Diag.setFileLogging(it)
                        },
                        title = { CupertinoText(loggingLbl) },
                    )
                    actionRow(diagnosticsLbl) { state.openDiagnostics() }
                }
            }
        }
    }

    pending?.let { op ->
        val title = stringResource(
            when (op) {
                DangerOp.FormatSd -> Res.string.title_format_sd
                DangerOp.FactoryReset -> Res.string.title_factory_reset
                DangerOp.Reboot -> Res.string.title_reboot
            },
        )
        val message = stringResource(
            when (op) {
                DangerOp.FormatSd -> Res.string.msg_format_sd
                DangerOp.FactoryReset -> Res.string.msg_factory_reset
                DangerOp.Reboot -> Res.string.msg_reboot
            },
        )
        val confirmLabel = stringResource(
            when (op) {
                DangerOp.FormatSd -> Res.string.confirm_format
                DangerOp.FactoryReset -> Res.string.confirm_reset
                DangerOp.Reboot -> Res.string.confirm_reboot
            },
        )
        CupertinoAlertDialog(
            onDismissRequest = { pending = null },
            title = { CupertinoText(title) },
            message = { CupertinoText(message) },
            buttons = {
                cancel(onClick = { pending = null }) {
                    CupertinoText(stringResource(Res.string.action_cancel_short))
                }
                destructive(
                    onClick = {
                        when (op) {
                            DangerOp.FormatSd -> state.formatSd()
                            DangerOp.FactoryReset -> state.factoryReset()
                            DangerOp.Reboot -> state.reboot()
                        }
                        pending = null
                    },
                    title = { CupertinoText(confirmLabel) },
                )
            },
        )
    }
}

/**
 * One camera menu item, labelled from [MenuCatalog].
 *
 * The row leads with the Chinese name and carries the firmware's own string beside
 * it: every diagnostic line this app writes names a setting by that firmware string,
 * so keeping it visible is what lets a row be traced back to `logs/`.
 */
private fun LazySectionScope.settingRow(
    state: AppState,
    s: CameraSetting,
    device: Boolean,
    expanded: Boolean,
    onOpen: () -> Unit,
    onClose: () -> Unit,
    saveLabel: String,
) {
    val options = s.options
    val enabled = !state.isBusy(Op.Settings) && !state.isBusy(Op.Mode)
    val zhTitle = MenuCatalog.titleOf(s.id, s.title, device)
    val firmwareName = s.title.takeIf { it != zhTitle }
    val help = MenuCatalog.helpOf(s.id, device)
    val write: (String) -> Unit = { value -> if (device) state.setDeviceSetting(s.id, value) else state.setSetting(s.id, value) }

    when {
        s.isToggle -> switch(
            checked = s.value.equals("1", true) || s.value.equals("ON", true),
            onCheckedChange = { write(s.toggleValue(it)) },
            enabled = enabled,
            title = { SettingLabel(zhTitle, firmwareName, help) },
        )

        options.isNotEmpty() -> dropdownMenu(
            expanded = expanded,
            onDismissRequest = onClose,
            onClick = if (expanded) onClose else onOpen,
            enabled = enabled,
            selectedLabel = {
                // Bounded on purpose. The trailing slot is measured before the title
                // gets what is left, so an unbounded value — `Gyro EIS` answers
                // 「360° 全向水平线矫正（360° Horizon Correction）」 — starved the title down
                // to one character per line in the 2026-09-22 screenshot.
                CupertinoText(
                    MenuCatalog.valueLabel(s.id, s.value, device),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.widthIn(max = 150.dp),
                )
            },
            title = { SettingLabel(zhTitle, firmwareName, help) },
        ) {
            options.forEach { o ->
                MenuPickerAction(
                    isSelected = o.value == s.value,
                    onClick = {
                        onClose()
                        write(o.value)
                    },
                    title = { CupertinoText(MenuCatalog.valueOptionLabel(s.id, o.value, device)) },
                )
            }
        }

        // An item with no options and no value is one of the firmware's *action* rows
        // (`SD Format`, `Information`, `Time Set`): the official app pads `cur` with
        // `-` precisely to mark "this row has nothing to show". Rendering it as a text
        // field would offer the user a box to type into and a save button that writes
        // a value the camera never asked for, so it reads as what it is. The action
        // itself lives beside it as a real, labelled button.
        s.value.isBlank() || s.value == "-" -> valueItem(zhTitle, "—")

        else -> item {
            var draft by remember(s.value) { mutableStateOf(s.value) }
            val textSaveBusy = enabled && state.isBusy(Op.Settings)
            Column(Modifier.fillMaxWidth().padding(it)) {
                SettingLabel(zhTitle, firmwareName, help)
                Spacer(Modifier.size(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CupertinoTextField(
                        value = draft,
                        onValueChange = { draft = it },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        enabled = enabled,
                    )
                    Spacer(Modifier.width(10.dp))
                    CupertinoButton(
                        onClick = { write(draft) },
                        enabled = enabled && !textSaveBusy && draft != s.value,
                        size = CupertinoButtonSize.Small,
                    ) {
                        if (textSaveBusy) {
                            CupertinoActivityIndicator(size = 12.dp, color = Color.White)
                            Spacer(Modifier.width(6.dp))
                        }
                        CupertinoText(saveLabel)
                    }
                }
            }
        }
    }
}

/** Chinese name, the firmware's own name beside it, and one line of explanation. */
@Composable
private fun SettingLabel(zhTitle: String, firmwareName: String?, help: String?) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            CupertinoText(zhTitle)
            if (firmwareName != null) {
                CupertinoText(
                    firmwareName,
                    fontSize = 11.sp,
                    color = CupertinoTheme.colorScheme.tertiaryLabel,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        if (help != null) {
            CupertinoText(
                help,
                fontSize = 11.sp,
                color = CupertinoTheme.colorScheme.secondaryLabel,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

/**
 * Bucket the camera's menu into display groups, in [MenuCatalog.groupOrder].
 * Items we have never seen land in [SettingGroup.Other] rather than disappearing.
 */
private fun groupSettingsForDisplay(
    settings: List<CameraSetting>,
): List<Pair<SettingGroup, List<CameraSetting>>> =
    MenuCatalog.groupOrder.mapNotNull { group ->
        val rows = settings.filter { MenuCatalog.groupOf(it.id) == group }
        if (rows.isEmpty()) null else group to rows
    }

/**
 * Same for the device (`System`) menu, in [MenuCatalog.deviceGroupOrder].
 *
 * The camera's own order is preserved inside a group: `cur` is positional, so a
 * re-sorted list would label one item's value onto its neighbour.
 */
private fun groupDeviceSettingsForDisplay(
    settings: List<CameraSetting>,
): List<Pair<DeviceGroup, List<CameraSetting>>> =
    MenuCatalog.deviceGroupOrder.mapNotNull { group ->
        val rows = settings.filter { MenuCatalog.deviceGroupOf(it.id) == group }
        if (rows.isEmpty()) null else group to rows
    }

/** Indices of the [SettingsScreen] tabs; keep in step with the segmented control there. */
private const val TAB_CAMERA = 0
private const val TAB_DEVICE = 1
private const val TAB_SOFTWARE = 2

private fun String?.dashOr(fallback: String?): String = this?.takeIf { it.isNotBlank() } ?: fallback ?: "—"
private fun com.rovecamlink.app.core.model.DeviceInfo?.softVersionDash(): String = this?.softVersion.dashOr(null)
private fun com.rovecamlink.app.core.model.DeviceInfo?.hardVersionDash(): String = this?.hardVersion.dashOr(null)
private fun com.rovecamlink.app.core.model.DeviceInfo?.regionDash(): String = this?.region.dashOr(null)
private fun com.rovecamlink.app.core.model.DeviceInfo?.macDash(): String = this?.mac.dashOr(null)
private fun com.rovecamlink.app.core.model.DeviceInfo?.ssidDash(): String = this?.ssid.dashOr(null)
