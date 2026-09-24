package com.rovecamlink.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items as gridItems
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.DownloadItem
import com.rovecamlink.app.FileLayout
import com.rovecamlink.app.Op
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_app_settings
import com.rovecamlink.app.action_cancel_short
import com.rovecamlink.app.action_cancelled
import com.rovecamlink.app.action_clear_finished
import com.rovecamlink.app.action_delete_file
import com.rovecamlink.app.action_diagnostics
import com.rovecamlink.app.action_dismiss
import com.rovecamlink.app.action_download
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
import com.rovecamlink.app.files_view_gallery
import com.rovecamlink.app.files_view_line
import com.rovecamlink.app.files_view_list
import com.rovecamlink.app.firmware_unsupported
import com.rovecamlink.app.menu_filter
import com.rovecamlink.app.menu_sort
import com.rovecamlink.app.hint_batch_delete_many
import com.rovecamlink.app.hint_locked_adjust
import com.rovecamlink.app.hint_locked_capture
import com.rovecamlink.app.hint_locked_mode
import com.rovecamlink.app.hint_new_password
import com.rovecamlink.app.hint_new_ssid
import com.rovecamlink.app.hint_photo_needs_photo_mode
import com.rovecamlink.app.hint_quick_adjust
import com.rovecamlink.app.hint_rotate_picture
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
import com.rovecamlink.app.label_model
import com.rovecamlink.app.label_name
import com.rovecamlink.app.label_note
import com.rovecamlink.app.label_region
import com.rovecamlink.app.label_sd_state
import com.rovecamlink.app.label_select_all
import com.rovecamlink.app.label_selected_count
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
import com.rovecamlink.app.filter_type_all
import com.rovecamlink.app.filter_type_video
import com.rovecamlink.app.filter_type_photo
import com.rovecamlink.app.sort_by_name
import com.rovecamlink.app.sort_by_size
import com.rovecamlink.app.sort_ascending
import com.rovecamlink.app.sort_descending
import com.rovecamlink.app.files_filter_line
import com.rovecamlink.app.action_delete_all
import com.rovecamlink.app.title_delete_all_files
import com.rovecamlink.app.message_delete_all_files
import com.rovecamlink.app.download_eta
import com.rovecamlink.app.permission_title
import com.rovecamlink.app.action_load_more
import com.rovecamlink.app.action_read_channel
import com.rovecamlink.app.label_wifi_channel
import com.rovecamlink.app.section_camera_capabilities
import com.rovecamlink.app.action_read_capabilities
import com.rovecamlink.app.label_standby_support
import com.rovecamlink.app.status_standby_supported
import com.rovecamlink.app.status_standby_unsupported
import com.rovecamlink.app.status_capabilities_unknown
import com.rovecamlink.app.label_capability_tokens
import com.rovecamlink.app.status_capabilities_empty
import com.rovecamlink.app.action_sleep_camera
import com.rovecamlink.app.title_sleep_camera
import com.rovecamlink.app.message_sleep_camera
import com.rovecamlink.app.confirm_sleep
import com.rovecamlink.app.sd_format_age
import com.rovecamlink.app.sd_format_overdue
import com.rovecamlink.app.sd_format_never
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.DayGroup
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.SdCardState
import com.rovecamlink.app.core.model.groupFilesByDay
import com.rovecamlink.app.core.ota.OtaState
import kotlin.math.roundToInt
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.Switch
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.TabRow
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Close
import top.yukonga.miuix.kmp.icon.extended.Delete
import top.yukonga.miuix.kmp.icon.extended.Download
import top.yukonga.miuix.kmp.icon.extended.Filter
import top.yukonga.miuix.kmp.icon.extended.Image
import top.yukonga.miuix.kmp.icon.extended.Ok
import top.yukonga.miuix.kmp.icon.extended.Play
import top.yukonga.miuix.kmp.icon.extended.Refresh
import top.yukonga.miuix.kmp.icon.extended.SelectAll
import top.yukonga.miuix.kmp.icon.extended.Sort
import top.yukonga.miuix.kmp.overlay.OverlayDialog
import top.yukonga.miuix.kmp.preference.ArrowPreference
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
    var pendingDeleteAll by remember { mutableStateOf(false) }
    var selectMode by remember { mutableStateOf(false) }
    val selected = remember { mutableStateListOf<String>() }

    // The list style lives in AppState: a pushed page replaces this screen while it is
    // open, so a `remember`ed style came back as 列表 after every visit to the log. It
    // also picks the thumbnail cache depth, which is read outside the composition.
    val layout = state.fileLayout

    // Filter + sort are the two bar buttons. `typeFilter` == null means 全部; sorting is a
    // key + direction pair.
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
    // 全选 is the visible list's, not the camera's: with a type filter on, a 全选 that also
    // ticked the filtered-out files would hand a batch delete rows the user cannot see.
    val allSelected = visibleFiles.isNotEmpty() && visibleFiles.all { selected.contains(it.name) }

    val refreshLabel = stringResource(Res.string.action_refresh_files)
    val downloadsTitle = stringResource(Res.string.section_downloads)
    val onCameraTitle = stringResource(Res.string.section_on_camera, state.files.size)
    val filesNone = stringResource(Res.string.files_none_refresh)
    val deleteTitle = stringResource(Res.string.title_delete_file)
    val cancelLabel = stringResource(Res.string.cancel)
    val deleteLabel = stringResource(Res.string.delete)
    val deleteAllLbl = stringResource(Res.string.action_delete_all)
    val downloadLbl = stringResource(Res.string.action_download)
    val loadMoreLbl = stringResource(Res.string.action_load_more)
    val doneLabel = stringResource(Res.string.download_done)
    val failedLabel = stringResource(Res.string.download_failed)
    val videoLbl = stringResource(Res.string.file_type_video)
    val photoLbl = stringResource(Res.string.file_type_photo)
    val selectAllLbl = stringResource(
        if (allSelected) Res.string.label_clear_selection else Res.string.label_select_all,
    )
    val diagnosticsLbl = stringResource(Res.string.action_diagnostics)
    val hintDeleteMany = stringResource(Res.string.hint_batch_delete_many)
    val filesLbl = stringResource(Res.string.label_files)
    val clearFinishedLbl = stringResource(Res.string.action_clear_finished)
    val retryFailedLbl = stringResource(Res.string.action_retry_failed)
    val unknownDateLbl = stringResource(Res.string.label_unknown_date)
    val filterLbl = stringResource(Res.string.menu_filter)
    val sortLbl = stringResource(Res.string.menu_sort)
    val galleryLbl = stringResource(Res.string.files_view_gallery)
    val listLbl = stringResource(Res.string.files_view_list)
    val filterAllLbl = stringResource(Res.string.filter_type_all)
    val filterVideoLbl = stringResource(Res.string.filter_type_video)
    val filterPhotoLbl = stringResource(Res.string.filter_type_photo)
    val sortByNameLbl = stringResource(Res.string.sort_by_name)
    val sortBySizeLbl = stringResource(Res.string.sort_by_size)
    val sortAscLbl = stringResource(Res.string.sort_ascending)
    val sortDescLbl = stringResource(Res.string.sort_descending)
    // The one-line current-condition summary, shown only when something is non-default:
    // 「画廊 · 视频 · 大小 降序」. The default (列表/全部/名称/升序) shows nothing, so the
    // 正文 stays free of controls and the bar's own checked states carry the rest.
    val viewLine = stringResource(
        Res.string.files_view_line,
        if (layout == FileLayout.Gallery) galleryLbl else listLbl,
        stringResource(
            Res.string.files_filter_line,
            when (typeFilter) {
                FileType.VIDEO -> filterVideoLbl
                FileType.PHOTO -> filterPhotoLbl
                else -> filterAllLbl
            },
            if (sortBySize) sortBySizeLbl else sortByNameLbl,
            if (sortDescending) sortDescLbl else sortAscLbl,
        ),
    )
    val viewLineVisible = filterActive || layout != FileLayout.List

    val mediaArgs = MediaArgs(
        videoLabel = videoLbl,
        photoLabel = photoLbl,
        selectMode = selectMode,
        selected = selected,
        onToggle = { name ->
            if (selected.contains(name)) selected.remove(name) else selected.add(name)
        },
        // A long press is the way *into* selection: it is what a list of media does
        // everywhere else on the phone, and it costs the bar a control it used to need.
        // Once selecting, it does what a tap does — one more way to tick a row.
        onLongPress = { name ->
            selectMode = true
            if (!selected.contains(name)) selected.add(name)
        },
        onDelete = { pendingDelete = it },
        onOpen = { state.openViewer(it, state.files) },
        emptyTitle = onCameraTitle,
        emptyFilesLabel = filesLbl,
        emptyNote = filesNone,
    )
    val chromeArgs = ChromeArgs(
        viewLineVisible = viewLineVisible,
        viewLine = viewLine,
        downloadsTitle = downloadsTitle,
        clearFinishedLabel = clearFinishedLbl,
        retryFailedLabel = retryFailedLbl,
        doneLabel = doneLabel,
        failedLabel = failedLabel,
        loadMoreLabel = loadMoreLbl,
    )

    MiuixPage(
        title = stringResource(Res.string.tab_files),
        outerPadding = outerPadding,
        state = state,
        // While selecting, the bar's second line counts what is selected instead of naming the
        // connection: it is the one reading the user needs at that moment, and it is where the
        // count lives now that the toolbar is four icons (2026-09-24 「FloatingToolbar 只要图标
        // 不要文字」).
        subtitle = if (selectMode) stringResource(Res.string.label_selected_count, selectedCount) else null,
        // Two bar buttons lead, each opening its own dropdown: 筛选 picks a facet, 排序 picks a
        // key and a direction. The dropdown marks the active choice, so it doubles as that
        // control's state readout — which is why the summary line below the bar only has to
        // name what is *not* the default.
        //
        // They are on the *left* because they describe the list rather than act on it: the
        // whole page is this list, and its two readings belong where the bar starts, next to
        // the title (2026-09-24 「左边是筛选和排序」).
        leadingIcons = if (state.session == null) emptyList() else listOf(
            AppBarIcon(
                icon = MiuixIcons.Filter,
                contentDescription = filterLbl,
                checked = typeFilter != null,
                dropdown = DropdownSpec(
                    groups = listOf(
                        DropdownGroup(
                            items = listOf(filterAllLbl, filterVideoLbl, filterPhotoLbl),
                            selected = when (typeFilter) {
                                FileType.VIDEO -> 1
                                FileType.PHOTO -> 2
                                else -> 0
                            },
                        ) { index ->
                            typeFilter = when (index) {
                                1 -> FileType.VIDEO
                                2 -> FileType.PHOTO
                                else -> null
                            }
                        },
                    ),
                ),
            ),
            AppBarIcon(
                icon = MiuixIcons.Sort,
                contentDescription = sortLbl,
                checked = sortBySize || !sortDescending,
                dropdown = DropdownSpec(
                    // Two groups, not four rows: the key and the direction are independent
                    // choices, and a flat list of four would read as four alternatives to one
                    // question. The divider says "two questions", and because they are answered
                    // independently the menu stays up so both ticks can be set in one visit.
                    groups = listOf(
                        DropdownGroup(
                            items = listOf(sortByNameLbl, sortBySizeLbl),
                            selected = if (sortBySize) 1 else 0,
                        ) { index -> sortBySize = index == 1 },
                        DropdownGroup(
                            items = listOf(sortAscLbl, sortDescLbl),
                            selected = if (sortDescending) 1 else 0,
                        ) { index -> sortDescending = index == 1 },
                    ),
                    stayOpen = true,
                ),
            ),
        ),
        // The log takes the bar's left edge only while nothing else wants it. With a session
        // that edge belongs to 筛选 and 排序, and the log moves into this page's ⋯ instead —
        // where the row is written out below, so the placement is visible here rather than
        // decided behind the page's back. Without a session the bar has no other control at
        // all, and a page with an empty bar would be the one page the log could not be
        // reached from.
        showDiagnostics = state.session == null,
        // 刷新 trails, because it acts on the list rather than describing it, and it is the
        // one action here whose effect is invisible until it lands — hence `busy`, which is
        // what the big 刷新文件列表 button used to say with a spinner.
        appBarIcons = if (state.session == null) emptyList() else listOf(
            AppBarIcon(
                icon = MiuixIcons.Refresh,
                contentDescription = refreshLabel,
                busy = state.isBusy(Op.Refresh),
            ) { state.refreshFiles() },
        ),
        menuItems = if (state.session == null) emptyList() else listOf(
            AppBarMenuItem(label = galleryLbl, checked = layout == FileLayout.Gallery) {
                state.fileLayout = FileLayout.Gallery
            },
            AppBarMenuItem(label = listLbl, checked = layout == FileLayout.List) {
                state.fileLayout = FileLayout.List
            },
            AppBarMenuItem(label = diagnosticsLbl) { state.openDiagnostics() },
            // The one irreversible action here, so it sits last and apart: in the menu
            // rather than on the bar, where a stray tap would cost the whole card. The
            // divider is what makes 「apart」 visible — everything above it is a way of
            // looking at the card, everything below it acts on the card.
            AppBarMenuItem(
                label = deleteAllLbl,
                enabled = state.files.isNotEmpty(),
                dividerAbove = true,
            ) {
                pendingDeleteAll = true
            },
        ),
        // The batch actions float over the list instead of occupying a row above it: the
        // four of them used to be a whole card — a title, three equal buttons — that pushed
        // the media down while in use, and the two buttons that *entered* them were a second
        // card on top of that (2026-09-24 「删掉两个巨大的按钮」). The bar is miuix's own
        // `FloatingToolbar` in the `Scaffold`'s bottom-end slot, so it clears the shell's
        // navigation bar without either page knowing about the other.
        floatingToolbar = if (selectMode) {
            {
                SelectToolbar(
                    selectAllLabel = selectAllLbl,
                    cancelLabel = cancelLabel,
                    downloadLabel = downloadLbl,
                    deleteLabel = deleteLabel,
                    selectedCount = selectedCount,
                    deleteBusy = state.isBusy(Op.Delete),
                    onSelectAll = {
                        if (allSelected) {
                            selected.clear()
                        } else {
                            visibleFiles.forEach { f ->
                                if (!selected.contains(f.name)) selected.add(f.name)
                            }
                        }
                    },
                    onDownloadSelected = {
                        state.files.filter { selected.contains(it.name) }
                            .forEach { state.download(it) }
                    },
                    onRequestBatchDelete = { pendingBatchDelete = true },
                    onCancel = {
                        selectMode = false
                        selected.clear()
                    },
                )
            }
        } else {
            null
        },
        // The gallery needs a grid container, which a LazyListScope cannot express — a list
        // scope has no cross-axis span. So when the gallery is on the whole content area is
        // handed over here, and 文件页 lays its remaining chrome (the transfers, 加载更多)
        // out in grid items instead of sections. Both paths go through the same two
        // composables below, so a style switch moves nothing but the media itself.
        gridCells = if (state.session != null && layout == FileLayout.Gallery) {
            {
                filesChrome(state = state, chrome = chromeArgs)
                filesGrid(
                    state = state,
                    groups = groups,
                    media = mediaArgs,
                    unknownDateLbl = unknownDateLbl,
                )
                filesTail(state = state, chrome = chromeArgs, media = mediaArgs)
            }
        } else {
            null
        },
    ) {
        if (state.session == null) {
            notConnectedItem()
        } else {
            filesChrome(state = state, chrome = chromeArgs)
            if (layout == FileLayout.List) {
                filesList(
                    state = state,
                    groups = groups,
                    media = mediaArgs,
                    unknownDateLbl = unknownDateLbl,
                )
            }
            filesTail(state = state, chrome = chromeArgs, media = mediaArgs)
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

    if (pendingDeleteAll) {
        // The device takes no confirmation of its own — the official app treats a bare
        // 200 as success — so the count in the message is the user's only sight of what
        // this costs before it is gone.
        ConfirmDialog(
            title = stringResource(Res.string.title_delete_all_files, state.files.size),
            message = stringResource(Res.string.message_delete_all_files, state.files.size),
            confirmLabel = deleteLabel,
            cancelLabel = cancelLabel,
            onConfirm = {
                state.deleteAllFiles()
                selected.clear()
                selectMode = false
                pendingDeleteAll = false
            },
            onDismiss = { pendingDeleteAll = false },
        )
    }
}

/**
 * The strings and callbacks the files page's media area needs, in both layouts.
 *
 * A parameter object rather than eleven positional arguments: the list and the grid draw
 * the same files with the same behaviour, and threading that through two functions whose
 * signatures have to stay in step is how the two drift apart. The labels are resolved
 * once in [FilesScreen] and shared.
 */
private class MediaArgs(
    val videoLabel: String,
    val photoLabel: String,
    val selectMode: Boolean,
    val selected: List<String>,
    val onToggle: (String) -> Unit,
    val onLongPress: (String) -> Unit,
    val onDelete: (RemoteFile) -> Unit,
    val onOpen: (RemoteFile) -> Unit,
    val emptyTitle: String,
    val emptyFilesLabel: String,
    val emptyNote: String,
)

/** The strings and callbacks for the chrome that sits above the media, in both layouts. */
private class ChromeArgs(
    val viewLineVisible: Boolean,
    val viewLine: String,
    val downloadsTitle: String,
    val clearFinishedLabel: String,
    val retryFailedLabel: String,
    val doneLabel: String,
    val failedLabel: String,
    val loadMoreLabel: String,
)

/** `"2026-09-23 · 12"`, or the unknown-date heading. One spelling for both layouts. */
private fun dayHeading(g: DayGroup, unknownDateLabel: String) =
    (g.key?.toString() ?: unknownDateLabel) + " · " + g.files.size

/**
 * The current-condition line and the transfer queue.
 *
 * Shared by both layouts so that switching style changes only the media below: a user who
 * has just selected twelve clips and then taps 列表 must not see the selection or the
 * queue move. `LazyListScope` and `LazyGridScope` have no common supertype, so this exists as
 * two thin adapters over one body rather than one function taking either.
 *
 * There is no longer a row of buttons at the top of this: 刷新 and 选择 were two full-width
 * buttons that took a card's worth of height on every visit to the page, and 刷新 is a bar
 * icon while selection is a long press (2026-09-24 「删掉两个巨大的按钮」).
 */
private fun LazyListScope.filesChrome(state: AppState, chrome: ChromeArgs) {
    if (chrome.viewLineVisible) item { ViewLine(chrome.viewLine) }
    if (state.downloads.isNotEmpty()) item { TransferCard(state, chrome) }
}

private fun LazyGridScope.filesChrome(state: AppState, chrome: ChromeArgs) {
    if (chrome.viewLineVisible) item(span = { GridItemSpan(maxLineSpan) }) { ViewLine(chrome.viewLine) }
    if (state.downloads.isNotEmpty()) item(span = { GridItemSpan(maxLineSpan) }) { TransferCard(state, chrome) }
}

/** One muted line naming what is off its default — the body carries no controls itself. */
@Composable
private fun ViewLine(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp, vertical = 4.dp),
    )
}

/**
 * The batch actions, as a floating bar over the list's bottom corner.
 *
 * Four icons in one capsule: 全选 / 下载 / 删除 / 取消, the destructive one in the error hue.
 * They replace a card that sat *above* the media — a title, three equal buttons, and the two
 * buttons that got you into selection in the first place — so the list is never pushed down by
 * its own controls, and the actions sit under a thumb while the user looks at what is selected.
 *
 * Icons rather than words, which is also what makes the row unbreakable: four labelled buttons
 * are wider than a phone once the counts are in them (「下载（12）」 beside 删除（12） beside
 * 取消), and in English they overflow further still. Four [IconButton]s are ~170dp in every
 * locale. Each carries its label as a `contentDescription`, so nothing is lost to a screen
 * reader, and the *count* is not lost at all — it is the bar's second line while selecting
 * ([FilesScreen] hands it over).
 *
 * 取消 is here rather than implied by a 完成 in the bar: with the entry point moved to a long
 * press, the way out has to be findable inside the mode, not only at its edge.
 */
@Composable
private fun SelectToolbar(
    selectAllLabel: String,
    cancelLabel: String,
    downloadLabel: String,
    deleteLabel: String,
    selectedCount: Int,
    deleteBusy: Boolean,
    onSelectAll: () -> Unit,
    onDownloadSelected: () -> Unit,
    onRequestBatchDelete: () -> Unit,
    onCancel: () -> Unit,
) {
    Row(
        Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SelectToolbarIcon(icon = MiuixIcons.SelectAll, label = selectAllLabel, onClick = onSelectAll)
        SelectToolbarIcon(
            icon = MiuixIcons.Download,
            label = downloadLabel,
            enabled = selectedCount > 0,
            onClick = onDownloadSelected,
        )
        SelectToolbarIcon(
            icon = MiuixIcons.Delete,
            label = deleteLabel,
            enabled = selectedCount > 0 && !deleteBusy,
            tint = MiuixTheme.colorScheme.error,
            onClick = onRequestBatchDelete,
        )
        SelectToolbarIcon(icon = MiuixIcons.Close, label = cancelLabel, onClick = onCancel)
    }
}

/** One icon of [SelectToolbar]. */
@Composable
private fun SelectToolbarIcon(
    icon: ImageVector,
    label: String,
    enabled: Boolean = true,
    tint: Color? = null,
    onClick: () -> Unit,
) {
    val haptics = LocalHapticFeedback.current
    IconButton(
        onClick = {
            haptics.tap()
            onClick()
        },
        enabled = enabled,
        backgroundColor = Color.Transparent,
    ) {
        Icon(
            icon,
            contentDescription = label,
            tint = tint ?: MiuixTheme.colorScheme.onSurface,
            modifier = Modifier.size(22.dp),
        )
    }
}

/** The download queue: one quiet ETA line, then the rows, then the two queue-wide actions. */
@Composable
private fun TransferCard(state: AppState, chrome: ChromeArgs) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(bottom = 12.dp),
    ) {
        SmallTitle(chrome.downloadsTitle)
        // One quiet line instead of a bar per row: what a queue in flight owes the user is
        // the number no single row can give — the whole wait.
        state.downloadEtaSeconds()?.let { eta ->
            Text(
                text = stringResource(Res.string.download_eta, eta),
                fontSize = 13.sp,
                color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
            )
        }
        if (state.downloads.any { it.state == DownloadItem.State.Done }) {
            actionRow(chrome.clearFinishedLabel) { state.clearFinishedDownloads() }
        }
        if (state.downloads.any { it.state == DownloadItem.State.Failed }) {
            actionRow(chrome.retryFailedLabel) { state.retryFailedDownloads() }
        }
        state.downloads.forEach { d -> downloadItem(d, chrome.doneLabel, chrome.failedLabel) }
    }
}

/** 加载更多, and the empty state — the two rows below the media in both layouts. */
private fun LazyListScope.filesTail(state: AppState, chrome: ChromeArgs, media: MediaArgs) {
    // A card holding more than one page stops at the cut; this is the only way to ask for
    // the rest. Hidden once the listing is exhausted, so an ordinary card never shows a
    // button that would do nothing.
    if (!state.filesExhausted && state.files.isNotEmpty()) {
        section(card = false) {
            actionRow(chrome.loadMoreLabel, busy = state.isBusy(Op.Refresh)) { state.loadMoreFiles() }
        }
    }
    if (state.files.isEmpty()) {
        section(title = media.emptyTitle) {
            valueItem(media.emptyFilesLabel, media.emptyNote)
        }
    }
}

private fun LazyGridScope.filesTail(state: AppState, chrome: ChromeArgs, media: MediaArgs) {
    if (!state.filesExhausted && state.files.isNotEmpty()) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            // `actionRow` is a ColumnScope extension; the grid item is not a Column, so one
            // is wrapped explicitly. Same for the empty-state card below.
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
            ) {
                actionRow(chrome.loadMoreLabel, busy = state.isBusy(Op.Refresh)) {
                    state.loadMoreFiles()
                }
            }
        }
    }
    if (state.files.isEmpty()) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
            ) {
                Column {
                    SmallTitle(media.emptyTitle)
                    valueItem(media.emptyFilesLabel, media.emptyNote)
                }
            }
        }
    }
}

/** The list layout's media: one card per day, one row per file. */
private fun LazyListScope.filesList(
    state: AppState,
    groups: List<DayGroup>,
    media: MediaArgs,
    unknownDateLbl: String,
) {
    groups.forEach { g ->
        section(title = dayHeading(g, unknownDateLbl)) {
            g.files.forEach { f ->
                fileItem(
                    state = state,
                    f = f,
                    videoLabel = media.videoLabel,
                    photoLabel = media.photoLabel,
                    selectMode = media.selectMode,
                    selected = media.selected.contains(f.name),
                    onToggle = { media.onToggle(f.name) },
                    onLongPress = { media.onLongPress(f.name) },
                    onOpen = { media.onOpen(f) },
                    onDelete = { media.onDelete(f) },
                )
            }
        }
    }
}

/**
 * The gallery: the same day headings as full-width rows, each followed by that day's
 * cells. The heading spans the whole line ([GridItemSpan]) so a date never gets split
 * across a row break — which is what makes this read as an album rather than a wall.
 */
private fun LazyGridScope.filesGrid(
    state: AppState,
    groups: List<DayGroup>,
    media: MediaArgs,
    unknownDateLbl: String,
) {
    groups.forEach { g ->
        item(span = { GridItemSpan(maxLineSpan) }) {
            SmallTitle(dayHeading(g, unknownDateLbl))
        }
        gridItems(g.files, key = { it.name }) { f ->
            MediaTile(
                state = state,
                f = f,
                selectMode = media.selectMode,
                selected = media.selected.contains(f.name),
                onToggle = { media.onToggle(f.name) },
                onLongPress = { media.onLongPress(f.name) },
                onOpen = { media.onOpen(f) },
            )
        }
    }
}

/**
 * One gallery cell: the decoded preview filling a square, cropped to cover.
 *
 * Square and flush against its neighbours — no gutter, no rounded corner. A gutter and a corner
 * radius are what make a grid read as separate cards rather than as one sheet of pictures, which
 * is the arrangement the system gallery uses and what the 2026-09-24 report asked for
 * (「一行 4 个，无间距」). At four across with no gap, a radius would leave a notch at every
 * corner junction, so the cell is a plain rectangle of pixels.
 *
 * The fill is deliberately only asked for from inside the cell — the same reason
 * [fileItem] does it there. In the gallery it matters more: a grid materialises every
 * cell in its visible window at once, and asking for the whole card's previews while the
 * list is being built is what crashed the tab before `loadThumbnail` was capped.
 *
 * A still-unfetched preview is not a blank grey box: it shows the type glyph on the same
 * tinted plate [FileThumbnail] uses, so a camera that serves no `.THM` at all still reads
 * as "photo here, video here" rather than as a rendering failure.
 */
@Composable
private fun MediaTile(
    state: AppState,
    f: RemoteFile,
    selectMode: Boolean,
    selected: Boolean,
    onToggle: () -> Unit,
    onLongPress: () -> Unit,
    onOpen: () -> Unit,
) {
    val isVideo = f.type == FileType.VIDEO
    LaunchedEffect(f.name) { state.loadThumbnail(f) }
    Box(
        Modifier
            .aspectRatio(1f)
            .background(
                if (isVideo) MiuixTheme.colorScheme.primary else MiuixTheme.colorScheme.secondary,
            )
            // Outside select mode a tap opens the media and a long press starts selecting;
            // inside it both tick the cell, which is why the two are alternatives rather than
            // nested handlers.
            .then(
                if (selectMode) {
                    Modifier.combinedClickable(onClick = onToggle, onLongClick = onLongPress)
                } else {
                    Modifier.combinedClickable(onClick = onOpen, onLongClick = onLongPress)
                },
            ),
    ) {
        val bitmap = state.thumbnails[f.name]
        if (bitmap != null) {
            Image(
                bitmap = bitmap,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
        } else {
            Icon(
                imageVector = if (isVideo) MiuixIcons.Play else MiuixIcons.Image,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.align(Alignment.Center).size(28.dp),
            )
        }
        // A video has no other clue that it is one: the cover crop of a clip looks exactly
        // like a photo until something says otherwise, so the glyph stays on top of the
        // frame rather than only standing in for a missing one.
        if (bitmap != null && isVideo) {
            Icon(
                imageVector = MiuixIcons.Play,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(6.dp)
                    .size(18.dp)
                    .shadow(2.dp, CircleShape),
            )
        }
        if (selectMode && selected) {
            Icon(
                MiuixIcons.Ok,
                contentDescription = null,
                tint = MiuixTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(6.dp)
                    .size(22.dp)
                    .background(Color.White, CircleShape),
            )
            // A tick alone is easy to miss against a bright frame; the scrim makes the
            // selected cells legible at a glance. Same tint as the type plate, so the
            // selected and unselected states are two weights of one thing.
            Box(
                Modifier
                    .matchParentSize()
                    .background(MiuixTheme.colorScheme.primary.copy(alpha = 0.18f)),
            )
        }
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

/**
 * The hotspot channel as a strip of the standard numbers (B8).
 *
 * The archive recorded the parameter and its type but never the value set the firmware
 * accepts, so the picker offers the non-overlapping 2.4 GHz channels and the common 5 GHz
 * ones, marks whichever the camera reported with a ✓, and lets the camera refuse the rest.
 */
@Composable
private fun ChannelStrip(current: Int?, enabled: Boolean, onPick: (Int) -> Unit) {
    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items(ChannelChoices, key = { it }) { ch ->
            SmallButton(
                label = if (ch == current) "$ch ✓" else ch.toString(),
                enabled = enabled,
                modifier = Modifier.widthIn(min = 56.dp),
            ) { onPick(ch) }
        }
    }
}

/** 2.4 GHz: the three that never overlap. 5 GHz: the ones most routers default to. */
private val ChannelChoices = listOf(1, 6, 11, 36, 40, 44, 48, 149, 157, 161)

/** B1: past this many days the SD-card hint stops being a fact and becomes a nudge. */
private const val FORMAT_OVERDUE_DAYS = 30

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
    onLongPress: () -> Unit,
    onOpen: () -> Unit,
    onDelete: () -> Unit,
) {
    val isVideo = f.type == FileType.VIDEO
    val haptics = LocalHapticFeedback.current
    // Ask for the preview from *inside* the row, not while the list is being built: a
    // section body is materialised eagerly, so the old call site fetched a thumbnail per
    // file on the card — dozens of megabyte JPEGs at once against one hotspot, which is
    // what crashed the tab.
    LaunchedEffect(f.name) { state.loadThumbnail(f) }
    Row(
        Modifier
            .fillMaxWidth()
            // A row is tappable either way; *what* the tap does is the difference —
            // selection in select mode, opening the media otherwise. The long press is the
            // way into selection, and `combinedClickable` gives it the platform's own
            // long-press haptic without this row having to ask for one.
            .combinedClickable(
                onClick = if (selectMode) onToggle else onOpen,
                onLongClick = onLongPress,
            )
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
private enum class DangerOp { FormatSd, FactoryReset, Reboot, InstallFirmware, Sleep }

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
    // 写入文件 is also switched on the pushed log-settings page, which leaves this screen
    // composed underneath it — so the read above cannot be the only one, or the switch
    // comes back showing what it was when the page was first built. Re-read the config
    // whenever this page is uncovered again.
    val onTop = state.topPage == null
    LaunchedEffect(onTop) {
        if (onTop) logging = com.rovecamlink.app.core.log.Diag.config.fileSink
    }

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
    val readChannelLbl = stringResource(Res.string.action_read_channel)
    val channelLbl = stringResource(Res.string.label_wifi_channel)
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
    // A16: the firmware's own capability tokens, and the standby row they gate (B10).
    val capabilitiesTitle = stringResource(Res.string.section_camera_capabilities)
    val readCapabilitiesLbl = stringResource(Res.string.action_read_capabilities)
    val standbyLbl = stringResource(Res.string.label_standby_support)
    val standbyYesLbl = stringResource(Res.string.status_standby_supported)
    val standbyNoLbl = stringResource(Res.string.status_standby_unsupported)
    val capabilitiesUnknownLbl = stringResource(Res.string.status_capabilities_unknown)
    val capabilityTokensLbl = stringResource(Res.string.label_capability_tokens)
    val capabilitiesEmptyLbl = stringResource(Res.string.status_capabilities_empty)
    val sleepLbl = stringResource(Res.string.action_sleep_camera)
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
    val permissionsRowLbl = stringResource(Res.string.permission_title)
    val uiTestLbl = stringResource(Res.string.action_ui_test_mode)
    val uiTestHint = stringResource(Res.string.hint_ui_test_mode)
    val sdStateLbl = when (st?.sdState) {
        SdCardState.OK -> stringResource(Res.string.sd_ok)
        SdCardState.MISSING -> stringResource(Res.string.sd_missing)
        SdCardState.ERROR -> stringResource(Res.string.sd_error)
        SdCardState.UNKNOWN, null -> stringResource(Res.string.sd_unknown)
    }

    // The sub-tab lives in AppState, not here: a pushed page replaces this screen while it is
    // open, so a `remember`ed index would come back as 相机 every time (see `settingsTab`).
    val tab = state.settingsTab
    val haptics = LocalHapticFeedback.current

    MiuixPage(
        title = stringResource(Res.string.tab_settings),
        outerPadding = outerPadding,
        state = state,
        bottomContent = {
            // Three fixed sub-tabs, one third of the width each. miuix's TabRow is a LazyRow
            // under the hood and sizes its tabs from a min/max dp range (76/98 in 0.9.4), so
            // on a narrow phone the third label slides out of view and the bar scrolls. These
            // three are a fixed set — 相机/设备/软件 always exist — so there is nothing to
            // scroll *to*; pin them by handing in the measured width as both bounds. The
            // spacing and the 12dp inset are subtracted first so the three really do divide
            // the row rather than overflow it.
            BoxWithConstraints(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp)) {
                val spacing = 8.dp
                val tabWidth = (maxWidth - spacing * (SETTINGS_TABS - 1)) / SETTINGS_TABS
                TabRow(
                    tabs = listOf(cameraTabLbl, deviceTabLbl, appTabLbl),
                    selectedTabIndex = tab,
                    onTabSelected = {
                        if (it != tab) haptics.tick()
                        state.settingsTab = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    minWidth = tabWidth,
                    maxWidth = tabWidth,
                    itemSpacing = spacing,
                )
            }
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
                section(card = false) {
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
                    section(card = false) {
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
                        busy = state.isBusy(Op.TimeSync),
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
                            // R5 (`docs/04 §6.1`): the precondition is checked before the
                            // button, and the reason is shown *instead of* a dead button —
                            // a greyed control that does not say why is what this app's own
                            // UI rule forbids.
                            val blocker = state.firmwareInstallBlocker()
                            if (blocker != null) {
                                valueItem(noteLbl, blocker)
                                actionRow(installLbl, enabled = false) {}
                            } else {
                                // Flashing is the one action in this app that can leave the
                                // camera unable to boot, and it cannot be undone from here,
                                // so it goes through the same confirmation the card format
                                // does — which also carries the factory-reset warning (R12).
                                actionRow(installLbl) { pending = DangerOp.InstallFirmware }
                            }
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
                    // B1: how long this card has been in continuous use. A worn card fails
                    // as "card errors" long after the fact, and the one that has run for
                    // months is exactly the one worth reformatting before a trip.
                    val days = state.daysSinceFormat()
                    when {
                        days == null -> hintLine(stringResource(Res.string.sd_format_never))
                        days >= FORMAT_OVERDUE_DAYS -> hintLine(stringResource(Res.string.sd_format_overdue, days))
                        else -> hintLine(stringResource(Res.string.sd_format_age, days))
                    }
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
                    // B8: the hotspot's channel — 2.4G reaches further, 5G is cleaner, and
                    // which one this room wants is a call only the user can make.
                    actionRow(readChannelLbl, busy = state.isBusy(Op.Wifi)) { state.readWifiChannel() }
                    state.cameraWifiChannel?.let { valueItem(channelLbl, it.toString()) }
                    ChannelStrip(
                        current = state.cameraWifiChannel,
                        enabled = !state.isBusy(Op.Wifi),
                        onPick = { state.setWifiChannel(it) },
                    )
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

                section(title = capabilitiesTitle) {
                    // A16. The tokens are the firmware's own words, so they are shown
                    // verbatim rather than mapped into this app's idea of a feature list:
                    // an unknown token is a fact about the camera, not a gap to hide.
                    valueItem(
                        standbyLbl,
                        when {
                            !state.capabilitiesRead -> capabilitiesUnknownLbl
                            state.supportsStandby() -> standbyYesLbl
                            else -> standbyNoLbl
                        },
                    )
                    if (state.capabilitiesRead) {
                        val tokens = state.deviceCapabilities
                        if (tokens.isEmpty()) {
                            valueItem(noteLbl, capabilitiesEmptyLbl)
                        } else {
                            valueItem(capabilityTokensLbl, tokens.sorted().joinToString(", "))
                        }
                    }
                    actionRow(
                        readCapabilitiesLbl,
                        busy = state.isBusy(Op.Capabilities),
                    ) { state.readDeviceCapabilities() }
                    // B10. Offered only where the firmware claimed standby: the endpoint
                    // exists everywhere and does nothing on hardware without it (the
                    // official client gates its own button on the same token), and the
                    // cost of guessing wrong is the user's connection.
                    actionRow(
                        sleepLbl,
                        busy = state.isBusy(Op.Power),
                        enabled = state.supportsStandby(),
                    ) { pending = DangerOp.Sleep }
                }

                section(title = dangerTitle, card = false) {
                    if (state.canRebootCamera()) {
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
                            haptics.tick()
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
                // 查看日志 / 日志设置 / 关于 / 权限说明: each pushes its own page onto the
                // shell's stack. Entries, not buttons — these four navigate somewhere and
                // change nothing here, so they wear the same right-arrow row the device page
                // uses for the same kind of move; a filled button in a settings list reads as
                // an action that does something to the camera (2026-09-24 「应用设置里面几个
                // 为什么是按钮啊？应该是入口啊，右箭头那种」).
                section(title = appSettingsTitle) {
                    ArrowPreference(
                        title = viewLogLbl,
                        onClick = { state.pushPage(com.rovecamlink.app.Page.Log) },
                    )
                    ArrowPreference(
                        title = logSettingsRowLbl,
                        onClick = { state.pushPage(com.rovecamlink.app.Page.LogSettings) },
                    )
                    ArrowPreference(
                        title = aboutRowLbl,
                        onClick = { state.pushPage(com.rovecamlink.app.Page.About) },
                    )
                    ArrowPreference(
                        title = permissionsRowLbl,
                        onClick = { state.pushPage(com.rovecamlink.app.Page.Permissions) },
                    )
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
                                    haptics.toggle()
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
                                onCheckedChange = {
                                    haptics.toggle()
                                    state.setUiTestMode(it)
                                },
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
                DangerOp.Sleep -> Res.string.title_sleep_camera
            },
        )
        val message = stringResource(
            when (op) {
                DangerOp.FormatSd -> Res.string.msg_format_sd
                DangerOp.FactoryReset -> Res.string.msg_factory_reset
                DangerOp.Reboot -> Res.string.msg_reboot
                DangerOp.InstallFirmware -> Res.string.msg_install_firmware
                DangerOp.Sleep -> Res.string.message_sleep_camera
            },
        )
        val confirmLabel = stringResource(
            when (op) {
                DangerOp.FormatSd -> Res.string.confirm_format
                DangerOp.FactoryReset -> Res.string.confirm_reset
                DangerOp.Reboot -> Res.string.confirm_reboot
                DangerOp.InstallFirmware -> Res.string.confirm_install_firmware
                DangerOp.Sleep -> Res.string.confirm_sleep
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
                            DangerOp.Sleep -> state.sleepCamera()
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
                // Two lines is the ceiling: every help string in [MenuCatalog] is written to
                // fit one, and the second is the slack a long firmware name or a narrow phone
                // may take. A row that grows a paragraph pushes the next setting off screen
                // and makes the list unreadable at a glance (2026-09-24 「尽量控制在一行内
                // 最多两行」).
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
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

/** How many sub-tabs that segmented control holds; it divides the row evenly between them. */
private const val SETTINGS_TABS = 3

private fun String?.dashOr(fallback: String?): String = this?.takeIf { it.isNotBlank() } ?: fallback ?: "—"
private fun com.rovecamlink.app.core.model.DeviceInfo?.softVersionDash(): String = this?.softVersion.dashOr(null)
private fun com.rovecamlink.app.core.model.DeviceInfo?.hardVersionDash(): String = this?.hardVersion.dashOr(null)
private fun com.rovecamlink.app.core.model.DeviceInfo?.regionDash(): String = this?.region.dashOr(null)
private fun com.rovecamlink.app.core.model.DeviceInfo?.macDash(): String = this?.mac.dashOr(null)
