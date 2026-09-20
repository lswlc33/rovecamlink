@file:OptIn(com.robinpcrd.cupertino.ExperimentalCupertinoApi::class)

package com.rovecamlink.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
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
import com.robinpcrd.cupertino.CupertinoText
import com.robinpcrd.cupertino.CupertinoTextField
import com.robinpcrd.cupertino.MenuPickerAction
import com.robinpcrd.cupertino.cancel
import com.robinpcrd.cupertino.destructive
import com.robinpcrd.cupertino.icons.CupertinoIcons
import com.robinpcrd.cupertino.icons.filled.Bolt
import com.robinpcrd.cupertino.icons.filled.Camera
import com.robinpcrd.cupertino.icons.filled.Externaldrive
import com.robinpcrd.cupertino.icons.filled.Film
import com.robinpcrd.cupertino.icons.filled.Photo
import com.robinpcrd.cupertino.icons.filled.RecordCircle
import com.robinpcrd.cupertino.icons.filled.StopCircle
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
import com.rovecamlink.app.Phase
import com.rovecamlink.app.Res
import com.rovecamlink.app.core.media.CameraPreviewView
import com.rovecamlink.app.core.model.CameraSetting
import com.rovecamlink.app.core.model.FileType
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import com.rovecamlink.app.core.qr.QrScanScreen
import com.rovecamlink.app.core.wifi.CameraNetwork
import com.rovecamlink.app.action_connect_to_ip
import com.rovecamlink.app.action_delete_file
import com.rovecamlink.app.action_disconnect
import com.rovecamlink.app.action_download_file
import com.rovecamlink.app.action_join_connect
import com.rovecamlink.app.action_photo
import com.rovecamlink.app.action_record
import com.rovecamlink.app.action_refresh_files
import com.rovecamlink.app.action_reload_settings
import com.rovecamlink.app.action_retry_file
import com.rovecamlink.app.action_scan_cameras
import com.rovecamlink.app.action_scan_qr
import com.rovecamlink.app.action_stop
import com.rovecamlink.app.cancel
import com.rovecamlink.app.delete
import com.rovecamlink.app.download_done
import com.rovecamlink.app.download_failed
import com.rovecamlink.app.file_type_photo
import com.rovecamlink.app.file_type_video
import com.rovecamlink.app.files_none_refresh
import com.rovecamlink.app.label_battery
import com.rovecamlink.app.label_files
import com.rovecamlink.app.label_host
import com.rovecamlink.app.label_info
import com.rovecamlink.app.label_mode
import com.rovecamlink.app.label_model
import com.rovecamlink.app.label_nearby_cameras
import com.rovecamlink.app.label_password
import com.rovecamlink.app.label_phase
import com.rovecamlink.app.label_platform
import com.rovecamlink.app.label_rec
import com.rovecamlink.app.label_sd_free
import com.rovecamlink.app.label_settings
import com.rovecamlink.app.message_delete_file
import com.rovecamlink.app.nearby_cameras_none
import com.rovecamlink.app.not_connected_note
import com.rovecamlink.app.not_connected_title
import com.rovecamlink.app.phase_connected
import com.rovecamlink.app.phase_connecting
import com.rovecamlink.app.phase_detecting_device
import com.rovecamlink.app.phase_error
import com.rovecamlink.app.phase_idle
import com.rovecamlink.app.phase_joining_wifi
import com.rovecamlink.app.phase_scanning_wifi
import com.rovecamlink.app.placeholder_ip
import com.rovecamlink.app.rec_idle
import com.rovecamlink.app.save
import com.rovecamlink.app.section_camera_settings
import com.rovecamlink.app.section_camera_wifi
import com.rovecamlink.app.section_capture
import com.rovecamlink.app.section_downloads
import com.rovecamlink.app.section_manual_connect
import com.rovecamlink.app.section_mode
import com.rovecamlink.app.section_on_camera
import com.rovecamlink.app.section_status
import com.rovecamlink.app.settings_none_reload
import com.rovecamlink.app.title_delete_file
import com.rovecamlink.app.wifi_open
import com.rovecamlink.app.wifi_secured
import com.rovecamlink.app.resolve
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

@Composable
private fun phaseLabel(p: Phase): String = stringResource(
    when (p) {
        Phase.Idle -> Res.string.phase_idle
        Phase.ScanningWifi -> Res.string.phase_scanning_wifi
        Phase.ConnectingWifi -> Res.string.phase_joining_wifi
        Phase.IdentifyingDevice -> Res.string.phase_detecting_device
        Phase.ConnectingProtocol -> Res.string.phase_connecting
        Phase.Connected -> Res.string.phase_connected
        Phase.Error -> Res.string.phase_error
    },
)

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
            CupertinoText(
                note,
                color = CupertinoTheme.colorScheme.secondaryLabel,
                fontSize = 13.sp,
            )
        }
    }
}

/** Filled, full-width button used for the primary action of a screen. */
@Composable
private fun FilledButton(
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    enabled: Boolean = true,
    busy: Boolean = false,
    containerColor: Color = CupertinoTheme.colorScheme.accent,
    onClick: () -> Unit,
) {
    CupertinoButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !busy,
        colors = CupertinoButtonDefaults.filledButtonColors(containerColor = containerColor),
    ) {
        if (busy) {
            CupertinoActivityIndicator(size = 14.dp, color = Color.White)
            Spacer(Modifier.width(8.dp))
        } else if (leadingIcon != null) {
            CupertinoIcon(leadingIcon, contentDescription = null, modifier = Modifier.size(17.dp))
            Spacer(Modifier.width(8.dp))
        }
        CupertinoText(label, fontWeight = FontWeight.Medium)
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

/**
 * The section row primitives (`item`, `link`, `switch`, ...) are only reachable from inside
 * `section { }`, so the shared rows below are written as extensions on its scope.
 */
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

/** Centred, tappable action row; shows a spinner while the action runs. */
private fun LazySectionScope.actionItem(
    title: String,
    busy: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    item {
        val accent = CupertinoTheme.colorScheme.accent
        Box(
            Modifier
                .fillMaxWidth()
                .heightIn(min = RowMinHeight)
                .clickable(enabled = enabled && !busy, onClick = onClick)
                .padding(it),
            contentAlignment = Alignment.Center,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (busy) {
                    CupertinoActivityIndicator(size = 15.dp, color = accent)
                    Spacer(Modifier.width(8.dp))
                }
                CupertinoText(
                    text = title,
                    color = if (enabled) accent else CupertinoTheme.colorScheme.tertiaryLabel,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}

// ============================ Devices ============================

@Composable
fun DevicesScreen(state: AppState) {
    var manualIp by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf<CameraNetwork?>(null) }
    var password by remember { mutableStateOf("") }
    var scanning by remember { mutableStateOf(false) }

    if (scanning) {
        QrScanScreen(
            onResult = { creds ->
                scanning = false
                if (creds != null) state.connect(creds.ssid, creds.password)
            },
            onClose = { scanning = false },
        )
        return
    }

    // Composable 上下文里一次性解析所有静态文案;section 的 body 非 Composable,
    // 故不能在 valueItem/actionItem 调用点直接 stringResource(...)。
    val statusTitle = stringResource(Res.string.section_status)
    val phaseLbl = stringResource(Res.string.label_phase)
    val infoLbl = stringResource(Res.string.label_info)
    val modelLbl = stringResource(Res.string.label_model)
    val platformLbl = stringResource(Res.string.label_platform)
    val hostLbl = stringResource(Res.string.label_host)
    val phaseLabelStr = phaseLabel(state.phase)
    val statusMsg = state.statusMessage?.resolve() ?: ""
    val disconnectLabel = stringResource(Res.string.action_disconnect)
    val cameraWifiTitle = stringResource(Res.string.section_camera_wifi)
    val scanQrLabel = stringResource(Res.string.action_scan_qr)
    val scanCamerasLabel = stringResource(Res.string.action_scan_cameras)
    val nearbyLabel = stringResource(Res.string.label_nearby_cameras)
    val nearbyNone = stringResource(Res.string.nearby_cameras_none)
    val securedLabel = stringResource(Res.string.wifi_secured)
    val openLabel = stringResource(Res.string.wifi_open)
    val passwordLabel = stringResource(Res.string.label_password)
    val joinConnectLabel = stringResource(Res.string.action_join_connect)
    val cancelLabel = stringResource(Res.string.cancel)
    val manualConnectTitle = stringResource(Res.string.section_manual_connect)
    val ipPlaceholder = stringResource(Res.string.placeholder_ip)
    val connectToIpLabel = stringResource(Res.string.action_connect_to_ip)

    LazyColumn(Modifier.fillMaxSize()) {
        section(title = { CupertinoText(statusTitle.sectionTitle()) }) {
            valueItem(phaseLbl, phaseLabelStr)
            if (statusMsg.isNotEmpty()) valueItem(infoLbl, statusMsg)
            state.session?.let { s ->
                valueItem(modelLbl, s.model)
                valueItem(platformLbl, s.platform.displayName)
                valueItem(hostLbl, "${s.host}:${s.port}")
            }
        }

        if (state.phase == Phase.Connected) {
            section {
                item {
                    Row(Modifier.fillMaxWidth().padding(it)) {
                        FilledButton(
                            label = disconnectLabel,
                            modifier = Modifier.weight(1f),
                            containerColor = CupertinoColors.systemRed,
                            onClick = { state.disconnect() },
                        )
                    }
                }
            }
        } else {
            section(title = { CupertinoText(cameraWifiTitle.sectionTitle()) }) {
                actionItem(
                    title = scanQrLabel,
                    onClick = { scanning = true },
                )
                actionItem(
                    title = scanCamerasLabel,
                    busy = state.phase == Phase.ScanningWifi,
                    onClick = { state.scanWifi() },
                )
                if (state.networks.isEmpty() && state.phase != Phase.ScanningWifi) {
                    valueItem(nearbyLabel, nearbyNone)
                }
                state.networks.forEach { n ->
                    link(
                        onClick = {
                            if (n.secured) {
                                selected = n
                                password = ""
                            } else {
                                state.connect(n.ssid, null)
                            }
                        },
                        title = { CupertinoText(n.ssid) },
                        caption = {
                            CupertinoText(
                                "${
                                    if (n.secured) securedLabel else openLabel
                                } · ${n.rssi} dBm",
                            )
                        },
                        trailingIcon = {},
                    )
                }
            }

            selected?.let { n ->
                section(title = { CupertinoText(n.ssid.sectionTitle()) }) {
                    textField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { CupertinoText(passwordLabel) },
                        singleLine = true,
                    )
                    item {
                        Row(
                            Modifier.fillMaxWidth().padding(it),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            FilledButton(
                                label = joinConnectLabel,
                                modifier = Modifier.weight(1f),
                                busy = state.phase == Phase.ConnectingWifi,
                                onClick = {
                                    state.connect(n.ssid, password.ifBlank { null })
                                    selected = null
                                },
                            )
                            CupertinoButton(
                                onClick = { selected = null },
                                colors = CupertinoButtonDefaults.grayButtonColors(),
                            ) { CupertinoText(cancelLabel) }
                        }
                    }
                }
            }

            section(title = { CupertinoText(manualConnectTitle.sectionTitle()) }) {
                textField(
                    value = manualIp,
                    onValueChange = { manualIp = it },
                    placeholder = { CupertinoText(ipPlaceholder) },
                    singleLine = true,
                )
                item {
                    Row(Modifier.fillMaxWidth().padding(it)) {
                        FilledButton(
                            label = connectToIpLabel,
                            modifier = Modifier.weight(1f),
                            busy = state.phase == Phase.IdentifyingDevice ||
                                state.phase == Phase.ConnectingProtocol,
                            onClick = {
                                val ip = manualIp.trim()
                                if (ip.isNotEmpty()) state.connect(manualHost = ip)
                            },
                        )
                    }
                }
            }
        }
    }
}

// ============================ Live ============================

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
    val mode = st?.mode ?: WorkMode.VIDEO

    // 一次性解析,section body 非 Composable,故不能在调用点直接 stringResource。
    val statusTitle = stringResource(Res.string.section_status)
    val batteryLbl = stringResource(Res.string.label_battery)
    val modeLbl = stringResource(Res.string.label_mode)
    val recLbl = stringResource(Res.string.label_rec)
    val recIdleLbl = stringResource(Res.string.rec_idle)
    val sdFreeLbl = stringResource(Res.string.label_sd_free)
    val modeTitle = stringResource(Res.string.section_mode)
    val captureTitle = stringResource(Res.string.section_capture)
    val photoLbl = stringResource(Res.string.action_photo)
    val recordLbl = stringResource(Res.string.action_record)
    val stopLbl = stringResource(Res.string.action_stop)

    LazyColumn(Modifier.fillMaxSize()) {
        item {
            Box(
                Modifier.fillMaxWidth().aspectRatio(16f / 9f).background(Color.Black),
                contentAlignment = Alignment.Center,
            ) {
                CameraPreviewView(previewUrl, Modifier.fillMaxSize())
            }
        }

        section(title = { CupertinoText(statusTitle.sectionTitle()) }) {
            item {
                Row(
                    Modifier.fillMaxWidth().padding(it),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    StatTile(
                        CupertinoIcons.Filled.Bolt,
                        batteryLbl,
                        st?.battery?.let { "$it%" } ?: "—",
                        CupertinoColors.systemGreen,
                    )
                    StatTile(
                        CupertinoIcons.Filled.Video,
                        modeLbl,
                        stringResource(mode.displayNameRes),
                        CupertinoTheme.colorScheme.accent,
                    )
                    StatTile(
                        CupertinoIcons.Filled.RecordCircle,
                        recLbl,
                        if (recording) formatTime(st?.videoTimeSec ?: 0) else recIdleLbl,
                        if (recording) CupertinoColors.systemRed else CupertinoTheme.colorScheme.tertiaryLabel,
                    )
                    StatTile(
                        CupertinoIcons.Filled.Externaldrive,
                        sdFreeLbl,
                        st?.sdFreeMb?.let { humanBytes(it * 1024 * 1024) } ?: "—",
                        CupertinoTheme.colorScheme.secondaryLabel,
                    )
                }
            }
        }

        section(title = { CupertinoText(modeTitle.sectionTitle()) }) {
            item {
                CupertinoSegmentedControl(
                    selectedTabIndex = WorkMode.entries.indexOf(mode).coerceAtLeast(0),
                    modifier = Modifier.fillMaxWidth().padding(it),
                    paddingValues = PaddingValues(0.dp),
                ) {
                    WorkMode.entries.forEach { m ->
                        CupertinoSegmentedControlTab(
                            onClick = { state.setMode(m) },
                            isSelected = m == mode,
                        ) { CupertinoText(stringResource(m.displayNameRes)) }
                    }
                }
            }
        }

        section(title = { CupertinoText(captureTitle.sectionTitle()) }) {
            item {
                Row(
                    Modifier.fillMaxWidth().padding(it),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    FilledButton(
                        label = photoLbl,
                        leadingIcon = CupertinoIcons.Filled.Camera,
                        modifier = Modifier.weight(1f),
                        busy = state.isBusy(Op.Capture),
                        onClick = { state.capture() },
                    )
                    FilledButton(
                        label = if (recording) stopLbl else recordLbl,
                        leadingIcon = if (recording) {
                            CupertinoIcons.Filled.StopCircle
                        } else {
                            CupertinoIcons.Filled.RecordCircle
                        },
                        modifier = Modifier.weight(1f),
                        busy = state.isBusy(Op.Record),
                        containerColor = CupertinoColors.systemRed,
                        onClick = { state.record(!recording) },
                    )
                }
            }
        }
    }
}

@Composable
private fun StatTile(icon: ImageVector, label: String, value: String, tint: Color) {
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

    // Composable 上下文一次性解析,section body 非 Composable。
    val refreshLabel = stringResource(Res.string.action_refresh_files)
    val downloadsTitle = stringResource(Res.string.section_downloads)
    val onCameraTitle = stringResource(Res.string.section_on_camera, state.files.size)
    val filesLabel = stringResource(Res.string.label_files)
    val filesNone = stringResource(Res.string.files_none_refresh)
    val deleteTitle = stringResource(Res.string.title_delete_file)
    val cancelLabel = stringResource(Res.string.cancel)
    val deleteLabel = stringResource(Res.string.delete)
    val doneLabel = stringResource(Res.string.download_done)
    val failedLabel = stringResource(Res.string.download_failed)
    val videoLbl = stringResource(Res.string.file_type_video)
    val photoLbl = stringResource(Res.string.file_type_photo)

    LazyColumn(Modifier.fillMaxSize()) {
        section {
            actionItem(
                title = refreshLabel,
                busy = state.isBusy(Op.Refresh),
                onClick = { state.refreshFiles() },
            )
        }

        if (state.downloads.isNotEmpty()) {
            section(title = { CupertinoText(downloadsTitle.sectionTitle()) }) {
                state.downloads.forEach { d -> downloadItem(d, doneLabel, failedLabel) }
            }
        }

        section(title = { CupertinoText(onCameraTitle.sectionTitle()) }) {
            if (state.files.isEmpty()) {
                valueItem(filesLabel, filesNone)
            }
            state.files.forEach { f ->
                val thumb = state.thumbnails[f.name]
                // Ask for the preview once we're actually showing the row.
                if (!state.thumbnails.containsKey(f.name)) state.loadThumbnail(f)
                fileItem(state, f, thumb, videoLbl, photoLbl, { pendingDelete = f })
            }
        }
    }

    pendingDelete?.let { target ->
        CupertinoAlertDialog(
            onDismissRequest = { pendingDelete = null },
            title = { CupertinoText(deleteTitle) },
            message = {
                CupertinoText(
                    stringResource(
                        Res.string.message_delete_file,
                        target.name.substringAfterLast('/'),
                    ),
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
}

/** File row icon: the decoded camera thumbnail when we have one, else a type glyph. */
@Composable
private fun FileThumbnail(bitmap: ImageBitmap?, isVideo: Boolean) {
    val size = 32.dp
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

private fun LazySectionScope.downloadItem(
    d: DownloadItem,
    doneLabel: String,
    failedLabel: String,
) {
    item {
        Column(Modifier.fillMaxWidth().padding(it)) {
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
                Spacer(Modifier.size(8.dp))
                ProgressLine(d.progress)
            }
        }
    }
}

private fun LazySectionScope.fileItem(
    state: AppState,
    f: RemoteFile,
    thumbnail: ImageBitmap?,
    videoLabel: String,
    photoLabel: String,
    onDelete: () -> Unit,
) {
    item {
        val isVideo = f.type == FileType.VIDEO
        Row(
            Modifier.fillMaxWidth().heightIn(min = RowMinHeight).padding(it),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FileThumbnail(thumbnail, isVideo)
            Spacer(Modifier.width(12.dp))
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
                    CupertinoText(
                        text = "${if (isVideo) videoLabel else photoLabel} · ${humanBytes(f.sizeBytes)}",
                        color = CupertinoTheme.colorScheme.secondaryLabel,
                        fontSize = 12.sp,
                    )
                }
            }
            Spacer(Modifier.width(8.dp))
            // Per-file progress: one transfer running must not grey out the other rows.
            val transfer = state.downloadState(f.name)
            if (transfer == DownloadItem.State.Running || transfer == DownloadItem.State.Queued) {
                CupertinoActivityIndicator(size = 20.dp)
                Spacer(Modifier.width(16.dp))
            } else {
                val cd = if (transfer == DownloadItem.State.Failed) {
                    stringResource(Res.string.action_retry_file, f.name)
                } else {
                    stringResource(Res.string.action_download_file, f.name)
                }
                CupertinoIconButton(
                    onClick = { state.download(f) },
                    colors = if (transfer == DownloadItem.State.Failed) {
                        CupertinoButtonDefaults.plainButtonColors(contentColor = CupertinoColors.systemRed)
                    } else {
                        CupertinoButtonDefaults.plainButtonColors()
                    },
                ) {
                    CupertinoIcon(
                        CupertinoIcons.Filled.TrayAndArrowDown,
                        contentDescription = cd,
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

// ============================ Settings ============================

@Composable
fun SettingsScreen(state: AppState) {
    if (state.session == null) {
        NotConnected()
        return
    }
    // Hoisted so the dropdown rows can be declared inside the lazy section builder.
    var expandedId by remember { mutableStateOf<String?>(null) }

    val reloadLabel = stringResource(Res.string.action_reload_settings)
    val cameraSettingsTitle = stringResource(Res.string.section_camera_settings)
    val settingsLabel = stringResource(Res.string.label_settings)
    val settingsNone = stringResource(Res.string.settings_none_reload)
    val saveLabel = stringResource(Res.string.save)

    LazyColumn(Modifier.fillMaxSize()) {
        section {
            actionItem(
                title = reloadLabel,
                busy = state.isBusy(Op.Settings),
                onClick = { state.loadSettings() },
            )
        }

        section(title = { CupertinoText(cameraSettingsTitle.sectionTitle()) }) {
            if (state.settings.isEmpty()) {
                valueItem(settingsLabel, settingsNone)
            }
            state.settings.forEach { s ->
                settingRow(
                    state = state,
                    s = s,
                    expanded = expandedId == s.id,
                    onOpen = { expandedId = s.id },
                    onClose = { if (expandedId == s.id) expandedId = null },
                    saveLabel = saveLabel,
                )
            }
        }
    }
}

private fun LazySectionScope.settingRow(
    state: AppState,
    s: CameraSetting,
    expanded: Boolean,
    onOpen: () -> Unit,
    onClose: () -> Unit,
    saveLabel: String,
) {
    val options = s.options
    val isBool = options.size == 2 && options.map { it.value }.toSet() == setOf("0", "1")
    val enabled = !state.isBusy(Op.Settings)

    when {
        isBool -> switch(
            checked = s.value == "1",
            onCheckedChange = { state.setSetting(s.id, if (it) "1" else "0") },
            enabled = enabled,
            title = { CupertinoText(s.title) },
        )

        options.isNotEmpty() -> dropdownMenu(
            expanded = expanded,
            onDismissRequest = onClose,
            onClick = if (expanded) onClose else onOpen,
            enabled = enabled,
            selectedLabel = {
                CupertinoText(options.firstOrNull { it.value == s.value }?.label ?: s.value)
            },
            title = { CupertinoText(s.title) },
        ) {
            options.forEach { o ->
                MenuPickerAction(
                    isSelected = o.value == s.value,
                    onClick = {
                        onClose()
                        state.setSetting(s.id, o.value)
                    },
                    title = { CupertinoText(o.label) },
                )
            }
        }

        else -> item {
            var draft by remember(s.value) { mutableStateOf(s.value) }
            Column(Modifier.fillMaxWidth().padding(it)) {
                CupertinoText(s.title)
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
                        onClick = { state.setSetting(s.id, draft) },
                        enabled = enabled && draft != s.value,
                        size = CupertinoButtonSize.Small,
                    ) { CupertinoText(saveLabel) }
                }
            }
        }
    }
}
