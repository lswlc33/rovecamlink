package com.rovecamlink.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Page
import com.rovecamlink.app.Phase
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_connect
import com.rovecamlink.app.action_disconnect
import com.rovecamlink.app.action_live_preview
import com.rovecamlink.app.action_live_settings
import com.rovecamlink.app.action_open_wifi_settings
import com.rovecamlink.app.action_join_connect
import com.rovecamlink.app.action_refresh
import com.rovecamlink.app.action_scan_qr
import com.rovecamlink.app.device_catalog_entry
import com.rovecamlink.app.device_catalog_entry_hint
import com.rovecamlink.app.device_catalog_title
import com.rovecamlink.app.err_live_unsupported
import com.rovecamlink.app.message_forget_camera
import com.rovecamlink.app.section_live
import com.rovecamlink.app.title_connected_camera
import com.rovecamlink.app.cancel
import com.rovecamlink.app.err_bluetooth_unsupported
import com.rovecamlink.app.err_open_wifi_settings
import com.rovecamlink.app.hint_ble_wake
import com.rovecamlink.app.hint_connect_choice
import com.rovecamlink.app.hint_last_refresh
import com.rovecamlink.app.label_ble_rssi
import com.rovecamlink.app.label_bluetooth_cameras
import com.rovecamlink.app.label_bluetooth_count
import com.rovecamlink.app.label_current_camera_wifi_short
import com.rovecamlink.app.label_remedy
import com.rovecamlink.app.label_known_camera
import com.rovecamlink.app.action_rename_camera
import com.rovecamlink.app.action_forget_camera
import com.rovecamlink.app.hint_camera_alias
import com.rovecamlink.app.save
import com.rovecamlink.app.label_nearby_none
import com.rovecamlink.app.label_no_bluetooth_cameras
import com.rovecamlink.app.label_no_wifi_cameras
import com.rovecamlink.app.label_other_ways
import com.rovecamlink.app.label_password
import com.rovecamlink.app.label_saved
import com.rovecamlink.app.label_wifi_cameras
import com.rovecamlink.app.label_wifi_count
import com.rovecamlink.app.not_connected_title
import com.rovecamlink.app.phase_connected
import com.rovecamlink.app.phase_connecting
import com.rovecamlink.app.phase_detecting_device
import com.rovecamlink.app.phase_error
import com.rovecamlink.app.phase_idle
import com.rovecamlink.app.phase_joining_wifi
import com.rovecamlink.app.phase_scanning_bluetooth
import com.rovecamlink.app.phase_scanning_wifi
import com.rovecamlink.app.phase_waking_camera
import com.rovecamlink.app.resolve
import com.rovecamlink.app.section_status
import com.rovecamlink.app.tab_devices
import com.rovecamlink.app.wifi_open
import com.rovecamlink.app.wifi_secured
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.qr.QrScanScreen
import kotlinx.coroutines.awaitCancellation
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.BasicComponent
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.TextButton
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Ok
import top.yukonga.miuix.kmp.overlay.OverlayDialog
import top.yukonga.miuix.kmp.preference.ArrowPreference
import top.yukonga.miuix.kmp.theme.LocalContentColor
import top.yukonga.miuix.kmp.theme.MiuixTheme
import kotlin.math.roundToInt

/**
 * The device tab: find a camera, connect, get out of the way.
 *
 * Two controls, per the field report that asked for them — 刷新 re-reads both radios
 * now, 连接 reaches the best camera in range — and both lists also refresh on their
 * own while this screen is open, so neither "I have to press a button every time" nor
 * "nothing moves until I press it" is true any more. The lists stay tappable for the
 * cases the automatic choice gets wrong: a second camera in range, a hotspot that
 * needs a passphrase, a camera whose Bluetooth name is not the network you want.
 *
 * Route order is the order that actually works on the S7PRO: a hotspot the phone is
 * already joined to is adopted without asking Bluetooth for anything (re-requesting a
 * network we are on is what made a manual join look broken, and what let a VPN keep
 * the route); otherwise Bluetooth, because it is the only route that also *opens* the
 * camera's hotspot and brings the passphrase back with it; then the Wi-Fi list.
 */
@Composable
fun ConnectScreen(state: AppState, outerPadding: PaddingValues) {
    var password by remember { mutableStateOf("") }
    var showConnectedDetails by remember { mutableStateOf(false) }
    var wifiSettingsError by remember { mutableStateOf(false) }
    var renameFor by remember { mutableStateOf<String?>(null) }
    var forgetFor by remember { mutableStateOf<String?>(null) }
    var renameText by remember { mutableStateOf("") }
    val nearby = state.nearby
    var tick by remember { mutableStateOf(0L) }
    val isConnected = state.phase == Phase.Connected

    // The scanner is this page's mode, and the page is dropped by the pager when it scrolls
    // out of view — so opening it and then swiping to another tab must not leave the flag set,
    // or the shell would keep the bottom bar folded away on a page that has no scanner on it.
    DisposableEffect(Unit) { onDispose { state.qrScanOpen = false } }

    // Search while this screen is on screen; stop when it is not, so a backgrounded
    // tab does not keep the LE scanner busy. Keyed on the connection state as well:
    // a successful connect stops the loop (the radios have nothing left to find), and
    // without re-launching on the way back the lists would sit frozen at whatever they
    // last showed — tappable, and pointing at a camera that has since gone.
    LaunchedEffect(isConnected) {
        if (!isConnected) {
            showConnectedDetails = false
            renameFor = null
            forgetFor = null
            renameText = ""
        }
        if (isConnected) return@LaunchedEffect
        nearby.start()
        try {
            awaitCancellation()
        } finally {
            nearby.stop()
        }
    }
    // The "n 秒前" stamp needs its own heartbeat; the scan loop has its own cadence.
    LaunchedEffect(Unit) {
        while (true) {
            tick = Diag.uptimeMillis()
            kotlinx.coroutines.delay(TICK_MS)
        }
    }

    if (state.qrScanOpen) {
        QrScanScreen(
            outerPadding = outerPadding,
            onResult = { creds ->
                state.qrScanOpen = false
                if (creds != null) state.connect(creds.ssid, creds.password)
            },
            onClose = { state.qrScanOpen = false },
        )
        return
    }

    val connected = state.phase == Phase.Connected
    val joined = state.joinedCameraNetwork
    val statusTitle = stringResource(Res.string.section_status)
    val phaseNow = phaseText(state.phase)
    val statusNow = state.statusMessage?.resolve().orEmpty()
    val noticeNow: String? = (nearby.notice ?: state.provisioning.notice ?: state.errorMessage)?.resolve()
    val refreshLbl = stringResource(Res.string.action_refresh)
    val connectLbl = stringResource(Res.string.action_connect)
    val disconnectLbl = stringResource(Res.string.action_disconnect)
    val choiceHint = stringResource(Res.string.hint_connect_choice)
    val cameraLbl = stringResource(Res.string.not_connected_title)
    val bleTitle = stringResource(Res.string.label_bluetooth_cameras)
    val bleHint = stringResource(Res.string.hint_ble_wake)
    val bleNone = stringResource(Res.string.label_no_bluetooth_cameras)
    val bleUnsupported = stringResource(Res.string.err_bluetooth_unsupported)
    val wifiTitle = stringResource(Res.string.label_wifi_cameras)
    val wifiNone = stringResource(Res.string.label_no_wifi_cameras)
    val securedLbl = stringResource(Res.string.wifi_secured)
    val openLbl = stringResource(Res.string.wifi_open)
    val savedLbl = stringResource(Res.string.label_saved)
    val otherTitle = stringResource(Res.string.label_other_ways)
    val qrLbl = stringResource(Res.string.action_scan_qr)
    val wifiSettingsLbl = stringResource(Res.string.action_open_wifi_settings)
    val wifiSettingsErrorMessage = stringResource(Res.string.err_open_wifi_settings)
    val connectedCameraTitle = stringResource(Res.string.title_connected_camera)
    val forgetMessage = stringResource(Res.string.message_forget_camera)
    val passwordLbl = stringResource(Res.string.label_password)
    val cancelLbl = stringResource(Res.string.cancel)
    val saveLbl = stringResource(Res.string.save)
    val remedyLbl = stringResource(Res.string.label_remedy)
    val remedyNow = state.connectRemedy()?.resolve()
    val knownLbl = stringResource(Res.string.label_known_camera)
    val renameLbl = stringResource(Res.string.action_rename_camera)
    val forgetLbl = stringResource(Res.string.action_forget_camera)
    val aliasHint = stringResource(Res.string.hint_camera_alias)
    val joinLbl = stringResource(Res.string.action_join_connect)
    val noneLbl = stringResource(Res.string.label_nearby_none)
    // 支持设备列表入口的三条文案：section 的内容 lambda 不在组合上下文里，stringResource
    // 只能在页面的组合部分解析（与设置页把全部文案提前解析是同一条规矩）。
    val catalogTitle = stringResource(Res.string.device_catalog_title)
    val catalogEntryLbl = stringResource(Res.string.device_catalog_entry)
    val catalogEntryHint = stringResource(Res.string.device_catalog_entry_hint)
    val liveTitle = stringResource(Res.string.section_live)
    val liveSettingsLbl = stringResource(Res.string.action_live_settings)
    val livePreviewLbl = stringResource(Res.string.action_live_preview)
    val liveUnsupported = stringResource(Res.string.err_live_unsupported)
    val ageSeconds = if (nearby.lastUpdateAt == 0L) -1 else ((tick - nearby.lastUpdateAt) / 1000f).roundToInt()

    val canConnect = joined != null || nearby.hasCandidate
    val busy = state.provisioning.busy || state.phase.isConnecting()
    val summary = when {
        connected -> state.session?.model.orEmpty()
        joined != null -> joined
        nearby.bluetooth.isNotEmpty() || nearby.networks.isNotEmpty() ->
            (listOfNotNull(
                nearby.bluetooth.firstOrNull()?.name,
                nearby.networks.firstOrNull()?.ssid,
            )).joinToString(" · ").ifBlank { noneLbl }
        else -> noneLbl
    }

    // The bar's second line replaces the bare 已连接 with the same word plus what the
    // connect flow is doing right now, and the 状态/提示 card below keeps only the things
    // that went *wrong* — the two rows it used to spend on the happy path said what the
    // bar already says, and pushing them up is what leaves the page's own content at the
    // top (2026-09-24 「设备页面的状态和提示两行，能不能也放到顶栏中的已连接位置处，代替
    // 原本已连接的位置」).
    val barStatus = listOfNotNull(phaseNow, statusNow.takeIf { it.isNotEmpty() }).joinToString(" · ")

    MiuixPage(
        title = stringResource(Res.string.tab_devices),
        outerPadding = outerPadding,
        state = state,
        subtitle = barStatus,
    ) {
        // The connected camera paints its own surface, so it must not also get `section`'s
        // Card — that would be two backgrounds and a border around a card that already is one.
        section(card = !connected) {
            if (connected) {
                ConnectedCameraCard(
                    title = summary,
                    subtitle = state.session?.platform?.displayName.orEmpty(),
                    tag = connectedCameraTitle,
                    onClick = { showConnectedDetails = true },
                )
            } else {
                ConnectHero(
                    title = cameraLbl,
                    subtitle = nearbyCountLine(
                        ble = nearby.bluetooth.size,
                        wifi = nearby.networks.size,
                        joined = joined != null,
                        searching = nearby.searching,
                        none = noneLbl,
                    ),
                    refreshLabel = refreshLbl,
                    connectLabel = connectLbl,
                    scanning = nearby.searching,
                    busy = busy,
                    canConnect = canConnect,
                    footnote = if (ageSeconds < 0 || !canConnect) {
                        choiceHint
                    } else {
                        stringResource(Res.string.hint_last_refresh, ageSeconds)
                    },
                    onRefresh = { state.refreshNearby() },
                    onConnect = { state.connectNearby() },
                )
            }
        }

        // 直播 (RTMP). The camera is the RTMP client, not this app: these two pages hand it a
        // network and a URL, and then watch what it pushes. Kept shut on a family that cannot
        // be told to go live — two rows that can only ever fail are worse than one line that
        // says why.
        if (connected) {
            section(title = liveTitle) {
                if (state.supportsLive()) {
                    ArrowPreference(
                        title = liveSettingsLbl,
                        summary = state.liveConfig.blocker?.reasonRes?.let { stringResource(it) }
                            ?: state.liveConfig.rtmpUrl,
                        onClick = { state.pushPage(Page.LiveSettings) },
                    )
                    ArrowPreference(
                        title = livePreviewLbl,
                        onClick = { state.pushPage(Page.LivePreview) },
                    )
                } else {
                    hintLine(liveUnsupported)
                }
            }
        }

        if (noticeNow != null || remedyNow != null) {
            section(title = statusTitle) {
                // Every notice this app raises is a failure — the radio is off, the permission
                // was refused, the join timed out — so it carries the error tone rather than
                // sitting in the same grey as ordinary prose.
                if (noticeNow != null) noticeLine(noticeNow)
                // The step it died on, with what to do about it — the one thing a stuck user
                // needs, and what the official app's "solutions" line exists for.
                if (remedyNow != null) infoRow(remedyLbl, remedyNow)
            }
        }

        // The camera we are on: give it a name, or drop everything this phone remembers
        // about it (A6). Shown while connected, because that is when the SSID in hand is
        // unambiguously the one the actions should target.
        //
        // The name goes through `takeIf { isNotBlank() }` rather than `.orEmpty()`: an
        // empty summary is not "no summary" to the library, it is a summary of length zero,
        // and it still claims its line — which is what put a row's worth of blank space
        // between 为相机添加备注 and 忘记这个设备 on every camera that has never been renamed
        // (2026-09-25 report). Null is what makes the row collapse to one line.
        val pinned = joined
        if (connected && pinned != null) {
            section(title = knownLbl) {
                ArrowPreference(
                    title = renameLbl,
                    summary = state.cameraAlias(pinned)?.takeIf { it.isNotBlank() },
                    onClick = {
                        renameFor = pinned
                        renameText = state.cameraAlias(pinned).orEmpty()
                    },
                )
                ArrowPreference(
                    title = forgetLbl,
                    onClick = { forgetFor = pinned },
                )
            }
        }

        /*
         * Both scanner lists exist to *find* something to connect to. Once a camera is
         * connected they answer 「这台设备没有蓝牙」 and 「附近没有相机热点」 to the person who
         * came here looking for the way out, and the session card has to be scrolled past
         * for them. They come back the moment the session drops.
         */
        if (!connected) {
            section(title = bleTitle) {
                when {
                    !state.provisioning.supported() -> hintLine(bleUnsupported)
                    nearby.bluetooth.isEmpty() -> hintLine(if (nearby.searching) "…" else bleNone)
                }
                nearby.bluetooth.forEach { cam ->
                    val paired = state.provisioning.isPaired(cam)
                    ArrowPreference(
                        title = cam.name,
                        summary = stringResource(Res.string.label_ble_rssi, cam.rssi) +
                            if (paired) " · $savedLbl" else "",
                        onClick = { state.provisioning.connect(cam) },
                        enabled = !busy,
                    )
                }
                if (nearby.bluetooth.isNotEmpty()) hintLine(bleHint)
            }
        }

        /* Same rule as the Bluetooth section above. */
        if (!connected) {
            section(title = wifiTitle) {
                if (nearby.networks.isEmpty()) {
                    hintLine(if (nearby.searching) "…" else wifiNone)
                }
                nearby.networks.forEach { network ->
                    val isJoined = joined.equals(network.ssid, ignoreCase = true)
                    val credential = if (isJoined || state.hasSavedPassword(network.ssid)) savedLbl else null
                    val known = state.isKnownCamera(network.ssid)
                    val label = state.cameraLabel(network.ssid)
                    ArrowPreference(
                        // A camera this phone has joined before goes by the name the user
                        // gave it; the raw SSID moves into the summary, because two units
                        // of the same model differ only in that tail — the part nobody reads.
                        title = label + if (isJoined) " ✓" else "",
                        summary = listOfNotNull(
                            if (label != network.ssid) network.ssid else null,
                            if (network.secured) securedLbl else openLbl,
                            "${network.rssi} dBm",
                            credential,
                            if (known) knownLbl else null,
                        ).joinToString(" · "),
                        onClick = { state.pickNetwork(network) },
                        enabled = !busy,
                    )
                }
            }
        }

        section(title = otherTitle) {
            ArrowPreference(
                title = qrLbl,
                onClick = { state.qrScanOpen = true },
            )
            ArrowPreference(
                title = wifiSettingsLbl,
                onClick = { wifiSettingsError = !state.openWifiSettings() },
            )
        }

        // 支持设备列表：页面最下方的常驻入口。不依赖连接状态 —— 问「这个型号到底能不能连」
        // 的人，多半正处于没连上的那一步。
        section(title = catalogTitle) {
            ArrowPreference(
                title = catalogEntryLbl,
                summary = catalogEntryHint,
                onClick = { state.pushPage(com.rovecamlink.app.Page.SupportedDevices) },
            )
        }
    }

    if (wifiSettingsError) {
        OverlayDialog(
            show = true,
            title = wifiSettingsLbl,
            summary = wifiSettingsErrorMessage,
            onDismissRequest = { wifiSettingsError = false },
        ) {
            TextButton(
                text = cancelLbl,
                onClick = { wifiSettingsError = false },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }

    state.askPasswordFor?.let { network ->
        val joining = state.phase == Phase.ConnectingWifi
        OverlayDialog(
            show = true,
            title = network.ssid,
            onDismissRequest = {
                state.askPasswordFor = null
                password = ""
            },
        ) {
            MiuixField(
                value = password,
                onValueChange = { password = it },
                placeholder = passwordLbl,
                modifier = Modifier.fillMaxWidth(),
                enabled = !joining,
            )
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextButton(
                    text = cancelLbl,
                    onClick = {
                        state.askPasswordFor = null
                        password = ""
                    },
                    modifier = Modifier.weight(1f),
                )
                Spacer(Modifier.width(20.dp))
                TextButton(
                    text = joinLbl,
                    onClick = {
                        state.connectToNetwork(network, password.ifBlank { null })
                        password = ""
                    },
                    enabled = password.isNotBlank() && !joining,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.textButtonColorsPrimary(),
                )
            }
        }
    }

    if (showConnectedDetails) {
        OverlayDialog(
            show = true,
            title = connectedCameraTitle,
            summary = listOfNotNull(
                state.session?.model,
                state.session?.platform?.displayName,
            ).joinToString(" · "),
            onDismissRequest = { showConnectedDetails = false },
        ) {
            TextButton(
                text = disconnectLbl,
                onClick = {
                    showConnectedDetails = false
                    state.disconnect()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.textButtonColors(
                    color = MiuixTheme.colorScheme.error,
                    textColor = MiuixTheme.colorScheme.onError,
                ),
            )
        }
    }

    val renaming = renameFor
    if (renaming != null) {
        OverlayDialog(
            show = true,
            title = renameLbl,
            onDismissRequest = {
                renameFor = null
                renameText = ""
            },
        ) {
            MiuixField(
                value = renameText,
                onValueChange = { renameText = it },
                placeholder = aliasHint,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextButton(
                    text = cancelLbl,
                    onClick = {
                        renameFor = null
                        renameText = ""
                    },
                    modifier = Modifier.weight(1f),
                )
                Spacer(Modifier.width(20.dp))
                TextButton(
                    text = saveLbl,
                    onClick = {
                        state.setCameraAlias(renaming, renameText.ifBlank { null })
                        renameFor = null
                        renameText = ""
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.textButtonColorsPrimary(),
                )
            }
        }
    }

    val forgetting = forgetFor
    if (forgetting != null) {
        ConfirmDialog(
            title = forgetLbl,
            message = forgetMessage,
            confirmLabel = forgetLbl,
            cancelLabel = cancelLbl,
            onConfirm = {
                state.forgetCamera(forgetting)
                forgetFor = null
            },
            onDismiss = { forgetFor = null },
        )
    }
}

/** "2 个蓝牙 · 1 个热点" — what the two radios found, in one line. */
@Composable
private fun nearbyCountLine(ble: Int, wifi: Int, joined: Boolean, searching: Boolean, none: String): String {
    val parts = buildList {
        if (joined) add(stringResource(Res.string.label_current_camera_wifi_short))
        if (ble > 0) add(stringResource(Res.string.label_bluetooth_count, ble))
        if (wifi > 0) add(stringResource(Res.string.label_wifi_count, wifi))
    }
    return parts.joinToString(" · ").ifBlank { if (searching) "…" else none }
}

/**
 * The connected camera, as the page's one hero card: a soft gradient surface, the camera's
 * name large, its protocol under it, a small state chip, and an oversized translucent tick
 * bled off the right edge.
 *
 * Modelled on the big status card the 2026-09-24 report pointed at
 * (「学习一下他的风格和实现」) — that card answers "what is this app doing right now" in one
 * glance, which is exactly the question this tab gets asked. It replaces a plain arrow row,
 * which answered it with one grey line. Generous padding on all four sides is deliberate:
 * the row it replaces sat tighter than the cards below it, which is the 「上下边距」 the same
 * report called out.
 */
@Composable
private fun ConnectedCameraCard(
    title: String,
    subtitle: String,
    tag: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scheme = MiuixTheme.colorScheme
    Box(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(scheme.surfaceVariant)
            .background(
                Brush.verticalGradient(
                    listOf(scheme.primary.copy(alpha = 0.30f), scheme.primary.copy(alpha = 0.04f)),
                ),
            )
            .clickable(onClick = onClick),
    ) {
        // Decoration only, and drawn after the clickable: it must never take a touch that
        // belongs to the card. Bled past the edge so the tick reads as a watermark rather
        // than as an icon laid out next to the text.
        Icon(
            imageVector = MiuixIcons.Ok,
            contentDescription = null,
            tint = scheme.primary.copy(alpha = 0.22f),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(132.dp)
                .offset(x = 26.dp),
        )
        Column(Modifier.fillMaxWidth().padding(20.dp)) {
            Text(
                text = title,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = scheme.onSurface,
            )
            if (subtitle.isNotEmpty()) {
                Spacer(Modifier.height(6.dp))
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    color = scheme.onSurfaceVariantSummary,
                )
            }
            Spacer(Modifier.height(18.dp))
            Text(
                text = tag,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = scheme.onSurface,
                modifier = Modifier
                    .clip(RoundedCornerShape(9.dp))
                    .background(scheme.primary.copy(alpha = 0.20f))
                    .padding(horizontal = 10.dp, vertical = 5.dp),
            )
        }
    }
}

/**
 * The card on top of the device tab: what was found and the two buttons that matter.
 * Everything below it is a fallback for when that choice is the wrong one.
 *
 * It is a [ColumnScope] extension rather than its own list item because the demo puts
 * the top of a page inside the same card every other block uses; a hero floating on the
 * page background was the old toolkit's shape.
 */
@Composable
private fun ColumnScope.ConnectHero(
    title: String,
    subtitle: String,
    refreshLabel: String,
    connectLabel: String,
    scanning: Boolean,
    busy: Boolean,
    canConnect: Boolean,
    footnote: String,
    onRefresh: () -> Unit,
    onConnect: () -> Unit,
) {
    val scheme = MiuixTheme.colorScheme
    Column(Modifier.fillMaxWidth().padding(16.dp)) {
        Text(
            text = title,
            color = scheme.onBackground,
            fontWeight = FontWeight.SemiBold,
            fontSize = 17.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        if (subtitle.isNotEmpty()) {
            Spacer(Modifier.height(4.dp))
            Text(subtitle, fontSize = 13.sp, color = scheme.onSurfaceVariantSummary)
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = onRefresh,
                colors = ButtonDefaults.buttonColors(),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (scanning) {
                        InfiniteProgressIndicator(
                            color = LocalContentColor.current,
                            size = 14.dp,
                            strokeWidth = 2.dp,
                            orbitingDotSize = 2.5.dp,
                        )
                        Spacer(Modifier.width(6.dp))
                    }
                    Text(refreshLabel)
                }
            }
            Button(
                onClick = onConnect,
                modifier = Modifier.weight(1f),
                enabled = canConnect && !busy,
                colors = ButtonDefaults.buttonColorsPrimary(),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (busy) {
                        InfiniteProgressIndicator(
                            color = LocalContentColor.current,
                            size = 15.dp,
                            strokeWidth = 2.dp,
                            orbitingDotSize = 2.5.dp,
                        )
                        Spacer(Modifier.width(8.dp))
                    }
                    Text(connectLabel)
                }
            }
        }
        if (footnote.isNotEmpty()) {
            Spacer(Modifier.height(8.dp))
            Text(footnote, fontSize = 11.sp, color = scheme.onSurfaceVariantSummary)
        }
    }
}

/** The failure line: same row shape as [hintLine], in the tone a failure reads in. */
@Composable
private fun ColumnScope.noticeLine(text: String) {
    BasicComponent {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "!",
                color = MiuixTheme.colorScheme.error,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
            Spacer(Modifier.width(6.dp))
            Text(text, fontSize = 13.sp, color = MiuixTheme.colorScheme.error)
        }
    }
}

/** Phase → the words a user reads, including the Bluetooth-only stages. */
@Composable
internal fun phaseText(phase: Phase): String = stringResource(
    when (phase) {
        Phase.Idle -> Res.string.phase_idle
        Phase.ScanningWifi -> Res.string.phase_scanning_wifi
        Phase.ScanningBle -> Res.string.phase_scanning_bluetooth
        Phase.WakingAp -> Res.string.phase_waking_camera
        Phase.ConnectingWifi -> Res.string.phase_joining_wifi
        Phase.IdentifyingDevice -> Res.string.phase_detecting_device
        Phase.ConnectingProtocol, Phase.SyncingTime -> Res.string.phase_connecting
        Phase.Connected -> Res.string.phase_connected
        Phase.Error -> Res.string.phase_error
    },
)

private fun Phase.isConnecting(): Boolean = this == Phase.ConnectingWifi ||
    this == Phase.IdentifyingDevice ||
    this == Phase.ConnectingProtocol ||
    this == Phase.SyncingTime

/** Cadence of the "n 秒前" stamp; the scan loop keeps its own, faster one. */
private const val TICK_MS = 500L
