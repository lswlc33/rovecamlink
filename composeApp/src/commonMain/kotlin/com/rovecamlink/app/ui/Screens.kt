package com.rovecamlink.app.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.rovecamlink.app.hint_locked_adjust
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
import com.rovecamlink.app.rec_recording
import com.rovecamlink.app.save
import com.rovecamlink.app.sd_error
import com.rovecamlink.app.sd_missing
import com.rovecamlink.app.sd_ok
import com.rovecamlink.app.sd_unknown
import com.rovecamlink.app.section_about
import com.rovecamlink.app.section_camera_wifi
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
import com.rovecamlink.app.section_appearance
import com.rovecamlink.app.appearance_system
import com.rovecamlink.app.appearance_dark
import com.rovecamlink.app.appearance_light
import com.rovecamlink.app.action_view_log
import com.rovecamlink.app.action_log_settings
import com.rovecamlink.app.action_about
import com.rovecamlink.app.action_ui_test_mode
import com.rovecamlink.app.hint_ui_test_mode
import com.rovecamlink.app.ui.theme.AppearanceState
import com.rovecamlink.app.ui.theme.ThemeMode
import com.rovecamlink.app.title_delete_count
import com.rovecamlink.app.title_delete_file
import com.rovecamlink.app.title_factory_reset
import com.rovecamlink.app.title_format_sd
import com.rovecamlink.app.title_reboot
import com.rovecamlink.app.workmode_photo
import com.rovecamlink.app.workmode_video
import com.rovecamlink.app.resolve
import com.rovecamlink.app.action_check_update
import com.rovecamlink.app.action_download_update
import com.rovecamlink.app.action_hide_password
import com.rovecamlink.app.action_install_now
import com.rovecamlink.app.action_read_camera_wifi
import com.rovecamlink.app.action_recheck_update
import com.rovecamlink.app.action_show_password
import com.rovecamlink.app.action_use_read_values
import com.rovecamlink.app.confirm_install_firmware
import com.rovecamlink.app.firmware_update_forced
import com.rovecamlink.app.hint_wifi_read_unsupported
import com.rovecamlink.app.label_newest_version
import com.rovecamlink.app.label_package_size
import com.rovecamlink.app.label_release_notes
import com.rovecamlink.app.label_wifi_password
import com.rovecamlink.app.msg_install_firmware
import com.rovecamlink.app.note_download_needs_internet
import com.rovecamlink.app.note_release_notes_unavailable
import com.rovecamlink.app.ota_note_lang
import com.rovecamlink.app.status_downloading
import com.rovecamlink.app.status_package_ready
import com.rovecamlink.app.status_wifi_not_read
import com.rovecamlink.app.tab_files
import com.rovecamlink.app.tab_settings
import com.rovecamlink.app.title_install_firmware
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
import kotlin.math.roundToInt
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.Switch
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.TabRow
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Delete
import top.yukonga.miuix.kmp.icon.extended.Download
import top.yukonga.miuix.kmp.icon.extended.Image
import top.yukonga.miuix.kmp.icon.extended.Ok
import top.yukonga.miuix.kmp.icon.extended.Play
import top.yukonga.miuix.kmp.icon.extended.Refresh
import top.yukonga.miuix.kmp.overlay.OverlayDialog
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.preference.SwitchPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme


internal fun humanBytes(b: Long): String = when {
    b <= 0 -> "—"
    b < 1024 -> "$b B"
    b < 1024 * 1024 -> "${b / 1024} KB"
    b < 1024L * 1024 * 1024 -> "${b / (1024 * 1024)} MB"
    else -> "${b / (1024L * 1024 * 1024)} GB"
}


/**
 * Firmware OTA state → the one-line status the settings page shows.
 *
 * Raw strings on purpose, and Chinese ones: this is a developer-visible status, and the
 * `docs/06` rule that the exported log has to be readable by the person in the field
 * applies to the screen that mirrors it. States that carry real content — an offer with a
 * version and a size, a download with byte counts — render as their own rows instead, and
 * return "" here rather than repeating themselves.
 */
private fun OtaState.otaLabel(): String = when (this) {
    OtaState.Idle -> ""
    OtaState.Checking -> "正在检查更新…"
    is OtaState.UpToDate -> "已是最新固件"
    is OtaState.NoEntry -> "厂商没有公布这个型号的固件包"
    is OtaState.Available -> "发现新固件 ${offer.version}"
    is OtaState.Downloading -> ""
    is OtaState.ReadyToInstall -> ""
    OtaState.WaitingForDevice -> "等待相机…"
    OtaState.Uploading -> "上传中…"
    OtaState.Installing -> "安装中…"
    OtaState.WaitingForReboot -> "相机重启中…"
    OtaState.Reconnecting -> "重新连接中…"
    is OtaState.ConfirmingVersion -> "核对版本（$expected）…"
    OtaState.Completed -> "已更新"
    OtaState.Cancelled -> "已取消"
    is OtaState.Failed -> message
}

// ============================ Files ============================

@Composable
fun FilesScreen(state: AppState, outerPadding: PaddingValues) {
    // Deleting is irreversible on the camera, so it goes through a confirm dialog.
    var pendingDelete by remember { mutableStateOf<RemoteFile?>(null) }
    var pendingBatchDelete by remember { mutableStateOf(false) }
    var selectMode by remember { mutableStateOf(false) }
    val selected = remember { mutableStateListOf<String>() }

    // Filter + sort live behind the top-bar 「更多」 menu (2026-09-23 「筛选/排序移入顶栏
    // 更多」). `typeFilter` == null means 全部; sorting is a key + direction pair.
    var typeFilter by remember { mutableStateOf<FileType?>(null) }
    var sortBySize by remember { mutableStateOf(false) }
    var sortDescending by remember { mutableStateOf(true) }

    // The list the page actually shows: the camera's files, filtered by type then sorted.
    // Grouping by day still happens after, so a name/size sort orders *within* each day.
    val visibleFiles = remember(state.files, typeFilter, sortBySize, sortDescending) {
        state.files
            .filter { typeFilter == null || it.type == typeFilter }
            .sortedWith(
                if (sortBySize) compareBy { it.sizeBytes } else compareBy { it.name },
            )
            .let { if (sortDescending) it.reversed() else it }
    }
    val groups = remember(visibleFiles) { groupFilesByDay(visibleFiles) }
    val filterActive = typeFilter != null || sortBySize || !sortDescending
    val selectedCount = state.files.count { selected.contains(it.name) }
    val allSelected = state.files.isNotEmpty() && state.files.all { selected.contains(it.name) }

    val refreshLabel = stringResource(Res.string.action_refresh_files)
    val downloadsTitle = stringResource(Res.string.section_downloads)
    val onCameraTitle = stringResource(Res.string.section_on_camera, state.files.size)
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
    val batchTitle = stringResource(Res.string.label_batch)
    val hintDeleteMany = stringResource(Res.string.hint_batch_delete_many)
    val filesLbl = stringResource(Res.string.label_files)
    val clearFinishedLbl = stringResource(Res.string.action_clear_finished)
    val retryFailedLbl = stringResource(Res.string.action_retry_failed)
    val unknownDateLbl = stringResource(Res.string.label_unknown_date)
    val filterSortLbl = stringResource(Res.string.menu_filter_sort)
    val filterAllLbl = stringResource(Res.string.filter_type_all)
    val filterVideoLbl = stringResource(Res.string.filter_type_video)
    val filterPhotoLbl = stringResource(Res.string.filter_type_photo)
    val sortByNameLbl = stringResource(Res.string.sort_by_name)
    val sortBySizeLbl = stringResource(Res.string.sort_by_size)
    val sortAscLbl = stringResource(Res.string.sort_ascending)
    val sortDescLbl = stringResource(Res.string.sort_descending)
    // The one-line current-condition summary, shown only when a filter or sort is active:
    // "视频 · 大小 降序". The default (全部/名称/升序) shows nothing (正文不塞控件).
    val filterLine = stringResource(
        Res.string.files_filter_line,
        when (typeFilter) {
            FileType.VIDEO -> filterVideoLbl
            FileType.PHOTO -> filterPhotoLbl
            else -> filterAllLbl
        },
        if (sortBySize) sortBySizeLbl else sortByNameLbl,
        if (sortDescending) sortDescLbl else sortAscLbl,
    )

    MiuixPage(
        title = stringResource(Res.string.tab_files),
        outerPadding = outerPadding,
        state = state,
        // Filter/sort each toggle one facet; the check mark shows the active choice, so the
        // menu doubles as the state readout. Tapping never closes over the file list — the
        // recomputation above keys off these flags.
        menuItems = if (state.session == null) emptyList() else listOf(
            AppBarMenuItem(label = "$filterSortLbl · $filterAllLbl", checked = typeFilter == null) { typeFilter = null },
            AppBarMenuItem(label = filterVideoLbl, checked = typeFilter == FileType.VIDEO) { typeFilter = FileType.VIDEO },
            AppBarMenuItem(label = filterPhotoLbl, checked = typeFilter == FileType.PHOTO) { typeFilter = FileType.PHOTO },
            AppBarMenuItem(label = sortByNameLbl, checked = !sortBySize) { sortBySize = false },
            AppBarMenuItem(label = sortBySizeLbl, checked = sortBySize) { sortBySize = true },
            AppBarMenuItem(label = sortDescLbl, checked = sortDescending) { sortDescending = true },
            AppBarMenuItem(label = sortAscLbl, checked = !sortDescending) { sortDescending = false },
        ),
    ) {
        if (state.session == null) {
            notConnectedItem()
        } else {
            // Two actions, side by side, outside a card: the demo lays a button pair out
            // in a Row inset by the card's own 12dp rather than stacking two full-width
            // buttons inside one.
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    actionButton(
                        refreshLabel,
                        busy = state.isBusy(Op.Refresh),
                        primary = true,
                        onClick = { state.refreshFiles() },
                    )
                    actionButton(selectLbl, onClick = {
                        selectMode = !selectMode
                        if (!selectMode) selected.clear()
                    })
                }
            }

            // Only when a filter or sort is in effect: one muted line naming the current
            // condition, so the body carries no controls of its own.
            if (filterActive) {
                item {
                    Text(
                        text = filterLine,
                        fontSize = 13.sp,
                        color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 28.dp, vertical = 4.dp),
                    )
                }
            }

            if (selectMode) {
                item {
                    SmallTitle(text = batchTitle)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
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

            if (state.downloads.isNotEmpty()) {
                section(title = downloadsTitle) {
                    if (state.downloads.any { it.state == DownloadItem.State.Done }) {
                        actionRow(clearFinishedLbl) { state.clearFinishedDownloads() }
                    }
                    if (state.downloads.any { it.state == DownloadItem.State.Failed }) {
                        actionRow(retryFailedLbl) { state.retryFailedDownloads() }
                    }
                    state.downloads.forEach { d -> downloadItem(d, doneLabel, failedLabel) }
                }
            }

            groups.forEach { g ->
                val heading = (g.key?.toString() ?: unknownDateLbl) + " · " + g.files.size
                section(title = heading) {
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
                section(title = onCameraTitle) {
                    valueItem(filesLbl, filesNone)
                }
            }
        }
    }

    val target = pendingDelete
    if (target != null) {
        ConfirmDialog(
            title = deleteTitle,
            message = stringResource(Res.string.message_delete_file, target.name.substringAfterLast('/')),
            confirmLabel = deleteLabel,
            cancelLabel = cancelLabel,
            onConfirm = {
                state.deleteFile(target)
                pendingDelete = null
            },
            onDismiss = { pendingDelete = null },
        )
    }

    if (pendingBatchDelete) {
        val targets = state.files.filter { selected.contains(it.name) }
        ConfirmDialog(
            title = stringResource(Res.string.title_delete_count, targets.size),
            message = hintDeleteMany,
            confirmLabel = deleteLabel,
            cancelLabel = cancelLabel,
            onConfirm = {
                state.deleteFiles(targets)
                selected.clear()
                selectMode = false
                pendingBatchDelete = false
            },
            onDismiss = { pendingBatchDelete = false },
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
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        minHeight = 34.dp,
        insideMargin = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
        colors = if (destructive) {
            ButtonDefaults.buttonColors(
                color = MiuixTheme.colorScheme.error,
                contentColor = MiuixTheme.colorScheme.onError,
            )
        } else {
            ButtonDefaults.buttonColors()
        },
    ) {
        Text(label, fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}

@Composable
private fun ColumnScope.downloadItem(d: DownloadItem, doneLabel: String, failedLabel: String) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = d.file.name.substringAfterLast('/'),
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MiuixTheme.colorScheme.onBackground,
                fontSize = 16.sp,
            )
            when (d.state) {
                DownloadItem.State.Running, DownloadItem.State.Queued ->
                    InfiniteProgressIndicator(size = 16.dp, strokeWidth = 2.dp)
                DownloadItem.State.Done ->
                    Text(doneLabel, color = MiuixTheme.colorScheme.primary, fontSize = 13.sp)
                DownloadItem.State.Failed ->
                    Text(failedLabel, color = MiuixTheme.colorScheme.error, fontSize = 13.sp)
            }
        }
        if (d.state == DownloadItem.State.Running || d.state == DownloadItem.State.Queued) {
            Spacer(Modifier.size(6.dp))
            ProgressLine(d.progress)
        }
    }
}

@Composable
private fun ColumnScope.fileItem(
    state: AppState,
    f: RemoteFile,
    videoLabel: String,
    photoLabel: String,
    selectMode: Boolean,
    selected: Boolean,
    onToggle: () -> Unit,
    onDelete: () -> Unit,
) {
    val isVideo = f.type == FileType.VIDEO
    // Ask for the preview from *inside* the row, not while the list is being built: a
    // section body is materialised eagerly, so the old call site fetched a thumbnail per
    // file on the card — dozens of megabyte JPEGs at once against one hotspot, which is
    // what crashed the tab.
    LaunchedEffect(f.name) { state.loadThumbnail(f) }
    Row(
        Modifier
            .fillMaxWidth()
            .then(if (selectMode) Modifier.clickable(onClick = onToggle) else Modifier)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (selectMode) {
            if (selected) {
                Icon(
                    MiuixIcons.Ok,
                    contentDescription = null,
                    tint = MiuixTheme.colorScheme.primary,
                    modifier = Modifier.size(22.dp),
                )
            } else {
                Box(
                    Modifier
                        .size(22.dp)
                        .border(1.5.dp, MiuixTheme.colorScheme.outline, RoundedCornerShape(6.dp)),
                )
            }
            Spacer(Modifier.width(10.dp))
        }
        FileThumbnail(state.thumbnails[f.name], isVideo)
        Spacer(Modifier.width(10.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = f.name.substringAfterLast('/'),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MiuixTheme.colorScheme.onBackground,
                fontSize = 16.sp,
            )
            val failure = state.downloadError(f.name)
            if (failure != null) {
                Text(
                    text = failure.resolve(),
                    color = MiuixTheme.colorScheme.error,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            } else {
                val meta = listOfNotNull(
                    if (isVideo) videoLabel else photoLabel,
                    humanBytes(f.sizeBytes).takeIf { f.sizeBytes > 0 },
                )
                Text(
                    text = meta.joinToString(" · "),
                    color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
                    fontSize = 12.sp,
                )
            }
        }
        // In select mode the row toggles instead of acting, so its trailing buttons are
        // hidden rather than left there to mis-fire.
        if (!selectMode) {
            Spacer(Modifier.width(6.dp))
            val transfer = state.downloadState(f.name)
            if (transfer == DownloadItem.State.Running || transfer == DownloadItem.State.Queued) {
                InfiniteProgressIndicator(size = 20.dp, strokeWidth = 2.5.dp)
                Spacer(Modifier.width(12.dp))
            } else {
                val retry = transfer == DownloadItem.State.Failed
                IconButton(
                    onClick = { state.download(f) },
                    backgroundColor = Color.Transparent,
                ) {
                    Icon(
                        if (retry) MiuixIcons.Refresh else MiuixIcons.Download,
                        contentDescription = stringResource(
                            if (retry) Res.string.action_retry_file else Res.string.action_download_file,
                            f.name,
                        ),
                        tint = if (retry) MiuixTheme.colorScheme.error else MiuixTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp),
                    )
                }
            }
            IconButton(
                onClick = onDelete,
                enabled = !state.isBusy(Op.Delete),
                backgroundColor = Color.Transparent,
            ) {
                Icon(
                    MiuixIcons.Delete,
                    contentDescription = stringResource(Res.string.action_delete_file, f.name),
                    tint = MiuixTheme.colorScheme.error,
                    modifier = Modifier.size(20.dp),
                )
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
                .clip(RoundedCornerShape(8.dp)),
        )
    } else {
        Box(
            Modifier
                .size(size)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    if (isVideo) MiuixTheme.colorScheme.primary else MiuixTheme.colorScheme.secondary,
                ),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = if (isVideo) MiuixIcons.Play else MiuixIcons.Image,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.dp),
            )
        }
    }
}


// ============================ Settings ============================

/** Maintenance actions that permanently alter the device, gated by a confirm dialog. */
private enum class DangerOp { FormatSd, FactoryReset, Reboot, InstallFirmware }

/**
 * Three pages in one tab: the camera's shooting menu, the **device's** own menu
 * (`workmode=System` on the XTU CGI family — watermarks, tones, grid, clock, SD
 * format, the things that are not a function of the shooting mode), and this app's
 * settings, which must be reachable with no camera connected at all.
 *
 * The three are a `TabRow` in the top bar's bottom slot, so which menu you are in is
 * part of the page's name rather than the first row of its list. A single list put
 * 「快门速度」 twelve rows away from 「恢复出厂设置」, which is how the 2026-09-22
 * field report ended up asking for exactly this split.
 */
@Composable
fun SettingsScreen(state: AppState, outerPadding: PaddingValues) {
    var pending by remember { mutableStateOf<DangerOp?>(null) }
    var wifiSsid by remember { mutableStateOf("") }
    var wifiPass by remember { mutableStateOf("") }
    var wifiSubmit by remember { mutableStateOf(false) }

    /** Whether the read-back passphrase is shown in clear. Off by default. */
    var showPass by remember { mutableStateOf(false) }
    var logging by remember { mutableStateOf(com.rovecamlink.app.core.log.Diag.config.fileSink) }

    val connected = state.session != null
    val info = state.deviceInfo
    val st = state.deviceStatus

    // Every string the three pages need is resolved here: a `section { }` body and the
    // page's content lambda run outside a composable scope, where `stringResource`
    // cannot be called.
    val appSettingsTitle = stringResource(Res.string.action_app_settings)
    val cameraSettingsTitle = stringResource(Res.string.label_camera_settings)
    val deviceSettingsTitle = stringResource(Res.string.label_device_settings)
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
    val syncTimeLbl = stringResource(Res.string.action_sync_camera_time)
    val raiseApLbl = stringResource(Res.string.action_raise_access_point)
    val settingsLbl = stringResource(Res.string.label_settings)
    val settingsNone = stringResource(Res.string.settings_none_reload)
    val aboutTitle = stringResource(Res.string.section_about)
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
    val firmwareTitle = stringResource(Res.string.section_firmware_update)
    val installedLbl = stringResource(Res.string.label_installed)
    val selectFirmwareLbl = stringResource(Res.string.action_select_firmware)
    val firmwareUnsupportedLbl = stringResource(Res.string.firmware_unsupported)
    val checkLbl = stringResource(Res.string.action_check_update)
    val newestLbl = stringResource(Res.string.label_newest_version)
    val sizeLbl = stringResource(Res.string.label_package_size)
    val notesLbl = stringResource(Res.string.label_release_notes)
    val noNotesLbl = stringResource(Res.string.note_release_notes_unavailable)
    val forcedLbl = stringResource(Res.string.firmware_update_forced)
    val downloadLbl = stringResource(Res.string.action_download_update)
    val installLbl = stringResource(Res.string.action_install_now)
    val recheckLbl = stringResource(Res.string.action_recheck_update)
    val internetNoteLbl = stringResource(Res.string.note_download_needs_internet)
    // Which language of the vendor's release notes to show. The core layer that fetched
    // them cannot see the locale this screen resolved to, so the locale travels in as a
    // resource of its own — `zh` here, `en` in the default bundle.
    val noteLang = stringResource(Res.string.ota_note_lang)
    val updateAppliedLbl = stringResource(Res.string.status_update_applied)
    val dismissLbl = stringResource(Res.string.action_dismiss)
    val cancelledLbl = stringResource(Res.string.action_cancelled)
    val cancelLbl = stringResource(Res.string.cancel)
    val shortCancelLbl = stringResource(Res.string.action_cancel_short)
    val sdCardTitle = stringResource(Res.string.section_sd_card)
    val formatSdLbl = stringResource(Res.string.action_format_sd)
    // The two OTA rows that need formatting are resolved *here*, in the composable part
    // of the screen: everything inside a `section { }` body runs in a plain ColumnScope,
    // where `stringResource` cannot be called.
    val otaNow = state.otaState
    val downloadingText = if (otaNow is OtaState.Downloading) {
        stringResource(
            Res.string.status_downloading,
            "${(otaNow.fraction * 100f).roundToInt().coerceIn(0, 100)}%",
            humanBytes(otaNow.done),
            if (otaNow.total > 0) humanBytes(otaNow.total) else "?",
        )
    } else {
        ""
    }
    val readyText = if (otaNow is OtaState.ReadyToInstall) {
        stringResource(Res.string.status_package_ready, otaNow.offer.fileName, humanBytes(otaNow.bytes))
    } else {
        ""
    }
    val cameraWifiTitle = stringResource(Res.string.section_camera_wifi)
    val newSsidHint = stringResource(Res.string.hint_new_ssid)
    val newPassHint = stringResource(Res.string.hint_new_password)
    val wifiRestartNote = stringResource(Res.string.note_wifi_restarts)
    val wifiPassLbl = stringResource(Res.string.label_wifi_password)
    val readWifiLbl = stringResource(Res.string.action_read_camera_wifi)
    val notReadLbl = stringResource(Res.string.status_wifi_not_read)
    val wifiReadUnsupportedLbl = stringResource(Res.string.hint_wifi_read_unsupported)
    val showPassLbl = stringResource(Res.string.action_show_password)
    val hidePassLbl = stringResource(Res.string.action_hide_password)
    val prefillLbl = stringResource(Res.string.action_use_read_values)
    val dangerTitle = stringResource(Res.string.section_danger)
    val rebootLbl = stringResource(Res.string.action_reboot_camera)
    val factoryResetLbl = stringResource(Res.string.action_factory_reset)
    val appearanceTitle = stringResource(Res.string.section_appearance)
    val appearanceSystemLbl = stringResource(Res.string.appearance_system)
    val appearanceDarkLbl = stringResource(Res.string.appearance_dark)
    val appearanceLightLbl = stringResource(Res.string.appearance_light)
    val viewLogLbl = stringResource(Res.string.action_view_log)
    val logSettingsRowLbl = stringResource(Res.string.action_log_settings)
    val aboutRowLbl = stringResource(Res.string.action_about)
    val uiTestLbl = stringResource(Res.string.action_ui_test_mode)
    val uiTestHint = stringResource(Res.string.hint_ui_test_mode)
    val sdStateLbl = when (st?.sdState) {
        SdCardState.OK -> stringResource(Res.string.sd_ok)
        SdCardState.MISSING -> stringResource(Res.string.sd_missing)
        SdCardState.ERROR -> stringResource(Res.string.sd_error)
        SdCardState.UNKNOWN, null -> stringResource(Res.string.sd_unknown)
    }

    var tab by remember { mutableStateOf(TAB_CAMERA) }

    MiuixPage(
        title = stringResource(Res.string.tab_settings),
        outerPadding = outerPadding,
        state = state,
        bottomContent = {
            TabRow(
                tabs = listOf(cameraTabLbl, deviceTabLbl, appTabLbl),
                selectedTabIndex = tab,
                onTabSelected = { tab = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp),
            )
        },
    ) {
        when (tab) {
            // ---- 相机: the shooting menu of the current mode ----
            TAB_CAMERA -> if (!connected) {
                notConnectedItem()
            } else {
                if (state.deviceStatus?.recording == true) {
                    section { valueItem(noteLbl, recordingNote) }
                }
                if (state.settings.isEmpty()) {
                    section { valueItem(settingsLbl, settingsNone) }
                }
                groupSettingsForDisplay(state.settings).forEach { (group, rows) ->
                    section(title = group.zhTitle) {
                        rows.forEach { s ->
                            settingRow(state = state, s = s, device = false, saveLabel = saveLabel)
                        }
                    }
                }
                section {
                    actionRow(reloadLabel, busy = state.isBusy(Op.Settings)) { state.loadSettings() }
                }
            }

            // ---- 设备: the camera box, its card, its hotspot and its firmware ----
            TAB_DEVICE -> if (!connected) {
                notConnectedItem()
            } else {
                if (state.deviceSettings.isNotEmpty()) {
                    groupDeviceSettingsForDisplay(state.deviceSettings).forEach { (group, rows) ->
                        section(title = group.zhTitle) {
                            rows.forEach { s ->
                                settingRow(state = state, s = s, device = true, saveLabel = saveLabel)
                            }
                        }
                    }
                    section {
                        actionRow(reloadLabel, busy = state.isBusy(Op.Settings)) {
                            state.loadDeviceSettings()
                        }
                    }
                }

                section(title = aboutTitle) {
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
                    // The read-back from `getwifi.cgi` wins over whatever `getdeviceattr`
                    // happened to carry, because it is the only answer that is definitely
                    // about the hotspot rather than about the camera's identity.
                    valueItem(wifiLbl, state.displayedSsid()?.ifBlank { null } ?: "—")
                    valueItem(hostLbl, state.session?.let { "${it.host}:${it.port}" } ?: "—")
                    valueItem(sdStateTitle, if (st?.sdState == null) "—" else sdStateLbl)
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

                section(title = firmwareTitle) {
                    valueItem(installedLbl, info?.softVersion ?: "—")
                    val ota = state.otaState
                    val supported = state.firmwareUpdateSupported()
                    // One status line for every state that has no rows of its own, so a
                    // failure or a "no firmware published" answer is never a silent button.
                    val line = ota.otaLabel()
                    if (line.isNotEmpty() && ota !is OtaState.Available) valueItem(statusLbl, line)
                    if (!supported && ota is OtaState.Idle) {
                        valueItem(noteLbl, firmwareUnsupportedLbl)
                    }
                    when (ota) {
                        OtaState.Idle -> {
                            actionRow(checkLbl, enabled = supported) { state.checkForFirmwareUpdate() }
                            // Desktop keeps the manual route: it is how the whole install
                            // flow is exercised against `simulator/` without a vendor
                            // cloud, and it is the only way to flash a file the index has
                            // nothing for.
                            if (state.supportsLocalFirmwarePackage()) {
                                actionRow(selectFirmwareLbl, enabled = supported) {
                                    state.installChosenFirmwarePackage()
                                }
                            }
                        }

                        is OtaState.Available -> {
                            valueItem(newestLbl, ota.offer.version)
                            if (ota.offer.sizeBytes > 0L) valueItem(sizeLbl, humanBytes(ota.offer.sizeBytes))
                            if (ota.offer.forced) valueItem(noteLbl, forcedLbl)
                            val notes = ota.offer.releaseNoteFor(noteLang)
                            if (notes != null) textBlockItem(notesLbl, notes) else valueItem(notesLbl, noNotesLbl)
                            valueItem(noteLbl, internetNoteLbl)
                            actionRow(downloadLbl) { state.downloadFirmwareUpdate(ota.offer) }
                            actionRow(dismissLbl) { state.resetOtaState() }
                        }

                        is OtaState.Downloading -> {
                            valueItem(statusLbl, downloadingText)
                            // A hand-drawn bar rather than a library progress widget: the
                            // download runs for minutes and the percentage above already
                            // moves, so this is orientation, not measurement.
                            ProgressLine(ota.fraction)
                            actionRow(cancelLbl) { state.cancelFirmwareUpdate() }
                        }

                        is OtaState.ReadyToInstall -> {
                            valueItem(statusLbl, readyText)
                            // Flashing is the one action in this app that can leave the
                            // camera unable to boot, and it cannot be undone from here, so
                            // it goes through the same confirmation the card format does.
                            actionRow(installLbl) { pending = DangerOp.InstallFirmware }
                            actionRow(dismissLbl) { state.resetOtaState() }
                        }

                        OtaState.Completed -> {
                            valueItem(statusLbl, updateAppliedLbl)
                            actionRow(dismissLbl) { state.resetOtaState() }
                        }

                        OtaState.Cancelled -> actionRow(cancelledLbl) { state.resetOtaState() }

                        is OtaState.Failed -> actionRow(recheckLbl) {
                            state.resetOtaState()
                            state.checkForFirmwareUpdate()
                        }

                        else -> {
                            // Checking, and the transfer states: the only useful control
                            // while bytes are moving is the one that stops.
                            if (!ota.isTerminal) actionRow(cancelLbl) { state.cancelFirmwareUpdate() }
                            else actionRow(dismissLbl) { state.resetOtaState() }
                        }
                    }
                }

                section(title = sdCardTitle) {
                    valueItem(totalLbl, st?.sdTotalMb?.let { humanBytes(it * 1024 * 1024) } ?: "—")
                    valueItem(freeLbl, st?.sdFreeMb?.let { humanBytes(it * 1024 * 1024) } ?: "—")
                    actionRow(formatSdLbl, busy = state.isBusy(Op.FormatSd)) { pending = DangerOp.FormatSd }
                }

                section(title = cameraWifiTitle) {
                    // ---- what the camera itself says its hotspot is ----
                    //
                    // The read-back rows come first because they are the answer to the
                    // question this group used to make people guess at: "what is the
                    // password I set two years ago". Masked by default — this is a screen
                    // someone may be holding out to another person — and prefilled into
                    // the rename fields below so a change starts from the truth.
                    val wifi = state.cameraWifi
                    if (wifi == null) {
                        valueItem(
                            wifiLbl,
                            if (state.canReadCameraWifi()) notReadLbl else wifiReadUnsupportedLbl,
                        )
                    } else {
                        valueItem(wifiLbl, wifi.ssid)
                        valueItem(
                            wifiPassLbl,
                            if (showPass) wifi.password ?: "—" else "•".repeat(wifi.password?.length ?: 0).ifEmpty { "—" },
                        )
                        if (!wifi.password.isNullOrEmpty()) {
                            actionRow(if (showPass) hidePassLbl else showPassLbl) { showPass = !showPass }
                        }
                        actionRow(prefillLbl) {
                            wifiSsid = wifi.ssid
                            wifiPass = wifi.password ?: ""
                            wifiSubmit = false
                        }
                    }
                    if (state.canReadCameraWifi()) {
                        actionRow(readWifiLbl, busy = state.isBusy(Op.Wifi)) { state.readCameraWifi() }
                    }
                    BasicRow {
                        MiuixField(
                            value = wifiSsid,
                            onValueChange = { wifiSsid = it; wifiSubmit = false },
                            placeholder = wifi?.ssid?.ifBlank { null } ?: newSsidHint,
                            enabled = true,
                            modifier = Modifier.fillMaxWidth(),
                        )
                        Spacer(Modifier.size(8.dp))
                        MiuixField(
                            value = wifiPass,
                            onValueChange = { wifiPass = it; wifiSubmit = false },
                            placeholder = newPassHint,
                            enabled = true,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                    val wifiBusy = wifiSubmit && state.isBusy(Op.Settings)
                    actionRow(
                        saveLabel,
                        busy = wifiBusy,
                        enabled = wifiSsid.isNotBlank() && wifiPass.isNotBlank() &&
                            !state.isBusy(Op.Settings),
                    ) {
                        wifiSubmit = true
                        state.setCameraWifi(wifiSsid.trim(), wifiPass.trim())
                    }
                    if (wifiSubmit) valueItem(noteLbl, wifiRestartNote)
                    // The other half of "the app cannot open the camera's hotspot": when
                    // the camera is reachable but not broadcasting, this is the one command
                    // that brings the AP back without going through Bluetooth at all.
                    actionRow(
                        raiseApLbl,
                        busy = state.isBusy(Op.AccessPoint),
                        enabled = state.canRaiseAccessPoint(),
                    ) { state.raiseAccessPoint() }
                }

                section(title = dangerTitle) {
                    if (state.session?.platform == DevicePlatform.TUWIN_REST) {
                        actionRow(rebootLbl, busy = state.isBusy(Op.Reboot)) { pending = DangerOp.Reboot }
                    }
                    actionRow(factoryResetLbl, busy = state.isBusy(Op.FactoryReset)) {
                        pending = DangerOp.FactoryReset
                    }
                }
            }

            // ---- 软件: this app ----
            TAB_SOFTWARE -> {
                // 外观: follow-system / dark / light, and it actually flips the window —
                // the picker writes AppearanceState, which RoveMiuixTheme reads at each
                // platform entry point (2026-09-23 「外观…真能切」).
                section(title = appearanceTitle) {
                    OverlayDropdownPreference(
                        items = listOf(appearanceSystemLbl, appearanceDarkLbl, appearanceLightLbl),
                        selectedIndex = when (AppearanceState.mode) {
                            ThemeMode.System -> 0
                            ThemeMode.Dark -> 1
                            ThemeMode.Light -> 2
                        },
                        title = appearanceTitle,
                        onSelectedIndexChange = { index ->
                            AppearanceState.mode = when (index) {
                                1 -> ThemeMode.Dark
                                2 -> ThemeMode.Light
                                else -> ThemeMode.System
                            }
                            com.rovecamlink.app.core.log.Diag.info(
                                com.rovecamlink.app.core.log.LogTag.APP,
                                "appearance=${AppearanceState.mode.name}",
                            )
                        },
                    )
                }
                // 查看日志 / 日志设置 / 关于: each pushes its own page onto the shell's stack.
                section(title = appSettingsTitle) {
                    actionRow(viewLogLbl) { state.pushPage(com.rovecamlink.app.Page.Log) }
                    actionRow(logSettingsRowLbl) { state.pushPage(com.rovecamlink.app.Page.LogSettings) }
                    actionRow(aboutRowLbl) { state.pushPage(com.rovecamlink.app.Page.About) }
                }
                // 写入文件 keeps its inline switch — it is the one logging knob a user
                // reaches for without opening the log at all.
                section {
                    BasicRow(
                        onClick = {
                            logging = !logging
                            com.rovecamlink.app.core.log.Diag.setFileLogging(logging)
                        },
                        end = {
                            Switch(
                                checked = logging,
                                onCheckedChange = {
                                    logging = it
                                    com.rovecamlink.app.core.log.Diag.setFileLogging(it)
                                },
                            )
                        },
                    ) {
                        Text(loggingLbl, fontSize = 16.sp, color = MiuixTheme.colorScheme.onBackground)
                    }
                }
                // UI 测试模式: fills every page with a canned camera so a layout can be
                // walked with nothing connected; writes go nowhere. Off returns the app to
                // the real, unconnected start.
                section {
                    BasicRow(
                        onClick = { state.setUiTestMode(!state.uiTestMode) },
                        end = {
                            Switch(
                                checked = state.uiTestMode,
                                onCheckedChange = { state.setUiTestMode(it) },
                            )
                        },
                    ) {
                        Text(uiTestLbl, fontSize = 16.sp, color = MiuixTheme.colorScheme.onBackground)
                    }
                    hintLine(uiTestHint)
                }
            }
        }
    }

    val op = pending
    if (op != null) {
        val title = stringResource(
            when (op) {
                DangerOp.FormatSd -> Res.string.title_format_sd
                DangerOp.FactoryReset -> Res.string.title_factory_reset
                DangerOp.Reboot -> Res.string.title_reboot
                DangerOp.InstallFirmware -> Res.string.title_install_firmware
            },
        )
        val message = stringResource(
            when (op) {
                DangerOp.FormatSd -> Res.string.msg_format_sd
                DangerOp.FactoryReset -> Res.string.msg_factory_reset
                DangerOp.Reboot -> Res.string.msg_reboot
                DangerOp.InstallFirmware -> Res.string.msg_install_firmware
            },
        )
        val confirmLabel = stringResource(
            when (op) {
                DangerOp.FormatSd -> Res.string.confirm_format
                DangerOp.FactoryReset -> Res.string.confirm_reset
                DangerOp.Reboot -> Res.string.confirm_reboot
                DangerOp.InstallFirmware -> Res.string.confirm_install_firmware
            },
        )
        OverlayDialog(
            show = true,
            title = title,
            summary = message,
            onDismissRequest = { pending = null },
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Button(onClick = { pending = null }, modifier = Modifier.weight(1f)) {
                    Text(shortCancelLbl)
                }
                // Red, because this is the button that formats a card or flashes a
                // camera; the library's own button colours have no destructive pair.
                Button(
                    onClick = {
                        when (op) {
                            DangerOp.FormatSd -> state.formatSd()
                            DangerOp.FactoryReset -> state.factoryReset()
                            DangerOp.Reboot -> state.reboot()
                            DangerOp.InstallFirmware -> state.installPreparedFirmware()
                        }
                        pending = null
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        color = MiuixTheme.colorScheme.error,
                        contentColor = MiuixTheme.colorScheme.onError,
                    ),
                ) {
                    Text(confirmLabel)
                }
            }
        }
    }
}

/**
 * One camera menu item, labelled from [MenuCatalog].
 *
 * The row leads with the Chinese name and carries the firmware's own string beside it:
 * every diagnostic line this app writes names a setting by that firmware string, so
 * keeping it visible is what lets a row be traced back to `logs/`.
 *
 * A miuix row has two text slots, so the firmware name shares the summary with the help
 * text rather than getting a smaller, greyer size of its own — the string is what makes
 * the row findable, and the emphasis is what was given up for it.
 */
@Composable
private fun ColumnScope.settingRow(
    state: AppState,
    s: CameraSetting,
    device: Boolean,
    saveLabel: String,
) {
    val options = s.options
    val enabled = !state.isBusy(Op.Settings) && !state.isBusy(Op.Mode)
    val zhTitle = MenuCatalog.titleOf(s.id, s.title, device)
    val firmwareName = s.title.takeIf { it != zhTitle }
    val help = MenuCatalog.helpOf(s.id, device)
    // A row's summary is one short line — here, the firmware's own spelling, which is
    // also the name every diagnostic line uses. The paragraph of explanation goes into
    // the row's `bottomAction`, the library's slot for text under the title, so the
    // value on the right edge stays level with the title instead of floating in the
    // middle of a wrapped four-line block.
    val summary = firmwareName
    val helpBlock: (@Composable () -> Unit)? = help?.let { body ->
        @Composable {
            Text(
                text = body,
                fontSize = 13.sp,
                color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
                modifier = Modifier.padding(top = 6.dp),
            )
        }
    }
    val write: (String) -> Unit = { value ->
        if (device) state.setDeviceSetting(s.id, value) else state.setSetting(s.id, value)
    }

    when {
        s.isToggle -> {
            val on = s.value.equals("1", true) || s.value.equals("ON", true)
            SwitchPreference(
                checked = on,
                onCheckedChange = { write(s.toggleValue(it)) },
                title = zhTitle,
                summary = summary,
                bottomAction = helpBlock,
                enabled = enabled,
            )
        }

        options.isNotEmpty() -> OverlayDropdownPreference(
            items = options.map { MenuCatalog.valueOptionLabel(s.id, it.value, device) },
            selectedIndex = options.indexOfFirst { it.value == s.value },
            title = zhTitle,
            summary = summary,
            bottomAction = helpBlock,
            enabled = enabled,
            onSelectedIndexChange = { index ->
                options.getOrNull(index)?.let { write(it.value) }
            },
        )

        // An item with no options and no value is one of the firmware's *action* rows
        // (`SD Format`, `Information`, `Time Set`): the official app pads `cur` with
        // `-` precisely to mark "this row has nothing to show". Rendering it as a text
        // field would offer the user a box to type into and a save button that writes
        // a value the camera never asked for, so it reads as what it is.
        s.value.isBlank() || s.value == "-" -> valueItem(zhTitle, "—")

        else -> {
            var draft by remember(s.value) { mutableStateOf(s.value) }
            val textSaveBusy = enabled && state.isBusy(Op.Settings)
            BasicRow {
                SettingLabel(zhTitle, firmwareName, help)
                Spacer(Modifier.size(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    MiuixField(
                        value = draft,
                        onValueChange = { draft = it },
                        placeholder = "",
                        enabled = enabled,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(Modifier.width(10.dp))
                    Button(
                        onClick = { write(draft) },
                        enabled = enabled && !textSaveBusy && draft != s.value,
                    ) {
                        if (textSaveBusy) {
                            InfiniteProgressIndicator(size = 12.dp, strokeWidth = 2.dp)
                            Spacer(Modifier.width(6.dp))
                        }
                        Text(saveLabel)
                    }
                }
            }
        }
    }
}


/**
 * Chinese name, the firmware's own name beside it, and one line of explanation.
 *
 * Only the free-text rows still carry all three: a miuix row has one title and one
 * summary, so everything with a switch or a picker beside it folds the firmware name
 * into the summary instead (see [settingRow]).
 */
@Composable
private fun SettingLabel(zhTitle: String, firmwareName: String?, help: String?) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Text(zhTitle, fontSize = 16.sp, color = MiuixTheme.colorScheme.onBackground)
            if (firmwareName != null) {
                Text(
                    firmwareName,
                    fontSize = 11.sp,
                    color = MiuixTheme.colorScheme.onSurfaceVariantActions,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        if (help != null) {
            Text(
                help,
                fontSize = 11.sp,
                color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
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
