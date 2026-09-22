@file:OptIn(com.robinpcrd.cupertino.ExperimentalCupertinoApi::class)

package com.rovecamlink.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robinpcrd.cupertino.CupertinoActivityIndicator
import com.robinpcrd.cupertino.CupertinoButton
import com.robinpcrd.cupertino.CupertinoButtonDefaults
import com.robinpcrd.cupertino.CupertinoButtonSize
import com.robinpcrd.cupertino.CupertinoText
import com.robinpcrd.cupertino.section.LazySectionScope
import com.robinpcrd.cupertino.section.link
import com.robinpcrd.cupertino.section.section
import com.robinpcrd.cupertino.section.sectionTitle
import com.robinpcrd.cupertino.section.textField
import com.robinpcrd.cupertino.theme.CupertinoColors
import com.robinpcrd.cupertino.theme.CupertinoTheme
import com.robinpcrd.cupertino.theme.systemRed
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Phase
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_connect
import com.rovecamlink.app.action_connect_to_ip
import com.rovecamlink.app.action_disconnect
import com.rovecamlink.app.action_join_connect
import com.rovecamlink.app.action_refresh
import com.rovecamlink.app.action_scan_qr
import com.rovecamlink.app.cancel
import com.rovecamlink.app.err_bluetooth_unsupported
import com.rovecamlink.app.hint_ble_wake
import com.rovecamlink.app.hint_connect_choice
import com.rovecamlink.app.hint_last_refresh
import com.rovecamlink.app.label_bluetooth_cameras
import com.rovecamlink.app.label_bluetooth_count
import com.rovecamlink.app.label_current_camera_wifi_short
import com.rovecamlink.app.label_hint
import com.rovecamlink.app.label_nearby_none
import com.rovecamlink.app.label_no_bluetooth_cameras
import com.rovecamlink.app.label_no_wifi_cameras
import com.rovecamlink.app.label_other_ways
import com.rovecamlink.app.label_password
import com.rovecamlink.app.label_phase
import com.rovecamlink.app.label_saved
import com.rovecamlink.app.label_wifi_cameras
import com.rovecamlink.app.label_wifi_count
import com.rovecamlink.app.not_connected_title
import com.rovecamlink.app.notice_vpn_active
import com.rovecamlink.app.phase_connected
import com.rovecamlink.app.phase_connecting
import com.rovecamlink.app.phase_detecting_device
import com.rovecamlink.app.phase_error
import com.rovecamlink.app.phase_idle
import com.rovecamlink.app.phase_joining_wifi
import com.rovecamlink.app.phase_scanning_bluetooth
import com.rovecamlink.app.phase_scanning_wifi
import com.rovecamlink.app.phase_waking_camera
import com.rovecamlink.app.placeholder_ip
import com.rovecamlink.app.section_status
import com.rovecamlink.app.wifi_open
import com.rovecamlink.app.wifi_secured
import com.rovecamlink.app.resolve
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.qr.QrScanScreen
import kotlinx.coroutines.awaitCancellation
import org.jetbrains.compose.resources.stringResource
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
 *
 * Section bodies are not composable scope functions in this UI kit, so every label is
 * resolved once, up front. Inside a section, rows pad with the section's own
 * `PaddingValues` — the manual 16.dp padding that used to sit on top of it is what
 * made the lists look inset twice.
 */
@Composable
fun ConnectScreen(state: AppState) {
    var manualIp by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showQr by remember { mutableStateOf(false) }
    val nearby = state.nearby
    var tick by remember { mutableStateOf(0L) }
    val isConnected = state.phase == Phase.Connected

    // Search while this screen is on screen; stop when it is not, so a backgrounded
    // tab does not keep the LE scanner busy. Keyed on the connection state as well:
    // a successful connect stops the loop (the radios have nothing left to find), and
    // without re-launching on the way back the lists would sit frozen at whatever they
    // last showed — tappable, and pointing at a camera that has since gone.
    LaunchedEffect(isConnected) {
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

    if (showQr) {
        QrScanScreen(
            onResult = { creds ->
                showQr = false
                if (creds != null) state.connect(creds.ssid, creds.password)
            },
            onClose = { showQr = false },
        )
        return
    }

    val connected = state.phase == Phase.Connected
    val joined = state.joinedCameraNetwork
    val statusTitle = stringResource(Res.string.section_status).sectionTitle()
    val phaseNow = phaseText(state.phase)
    val statusNow = state.statusMessage?.resolve().orEmpty()
    val noticeNow = nearby.notice?.resolve()
        ?: state.provisioning.notice?.resolve()
        ?: state.errorMessage?.resolve()
    val vpnNote = stringResource(Res.string.notice_vpn_active)
    val phaseLbl = stringResource(Res.string.label_phase)
    val refreshLbl = stringResource(Res.string.action_refresh)
    val connectLbl = stringResource(Res.string.action_connect)
    val disconnectLbl = stringResource(Res.string.action_disconnect)
    val choiceHint = stringResource(Res.string.hint_connect_choice)
    val cameraLbl = stringResource(Res.string.not_connected_title)
    val bleTitle = stringResource(Res.string.label_bluetooth_cameras).sectionTitle()
    val bleHint = stringResource(Res.string.hint_ble_wake)
    val bleNone = stringResource(Res.string.label_no_bluetooth_cameras)
    val bleUnsupported = stringResource(Res.string.err_bluetooth_unsupported)
    val wifiTitle = stringResource(Res.string.label_wifi_cameras).sectionTitle()
    val wifiNone = stringResource(Res.string.label_no_wifi_cameras)
    val securedLbl = stringResource(Res.string.wifi_secured)
    val openLbl = stringResource(Res.string.wifi_open)
    val savedLbl = stringResource(Res.string.label_saved)
    val otherTitle = stringResource(Res.string.label_other_ways).sectionTitle()
    val qrLbl = stringResource(Res.string.action_scan_qr)
    val ipLbl = stringResource(Res.string.action_connect_to_ip)
    val ipHint = stringResource(Res.string.placeholder_ip)
    val passwordLbl = stringResource(Res.string.label_password)
    val cancelLbl = stringResource(Res.string.cancel)
    val hintLbl = stringResource(Res.string.label_hint)
    val joinLbl = stringResource(Res.string.action_join_connect)
    val noneLbl = stringResource(Res.string.label_nearby_none)
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

    LazyColumn(Modifier.fillMaxSize()) {
        item {
            ConnectHero(
                connected = connected,
                title = if (connected) summary else cameraLbl,
                subtitle = if (connected) {
                    state.session?.let { "${it.host}:${it.port}" } ?: ""
                } else {
                    nearbyCountLine(
                        ble = nearby.bluetooth.size,
                        wifi = nearby.networks.size,
                        joined = joined != null,
                        searching = nearby.searching,
                        none = noneLbl,
                    )
                },
                refreshLabel = refreshLbl,
                connectLabel = connectLbl,
                disconnectLabel = disconnectLbl,
                scanning = nearby.searching,
                busy = busy,
                canConnect = canConnect,
                footnote = when {
                    connected -> ""
                    ageSeconds < 0 -> choiceHint
                    canConnect -> stringResource(Res.string.hint_last_refresh, ageSeconds)
                    else -> choiceHint
                },
                onRefresh = { state.refreshNearby() },
                onConnect = { state.connectNearby() },
                onDisconnect = { state.disconnect() },
            )
        }

        section(title = { CupertinoText(statusTitle) }) {
            infoRow(phaseLbl, phaseNow)
            if (statusNow.isNotEmpty()) infoRow(hintLbl, statusNow)
            if (noticeNow != null) infoRow("!", noticeNow)
            if (state.vpnActive) infoRow("VPN", vpnNote)
        }

        /*
         * Both scanner lists exist to *find* something to connect to. Once a camera is
         * connected they answer 「这台设备没有蓝牙」 and 「附近没有相机热点」 to the person who
         * came here looking for the way out, and the session card has to be scrolled past
         * for them. They come back the moment the session drops.
         */
        if (!connected) {
            section(title = { CupertinoText(bleTitle) }) {
                when {
                    !state.provisioning.supported() -> infoRow(hintLbl, bleUnsupported)
                    nearby.bluetooth.isEmpty() -> infoRow(hintLbl, if (nearby.searching) "…" else bleNone)
                }
                nearby.bluetooth.forEach { cam ->
                    val paired = state.provisioning.isPaired(cam)
                    link(
                        onClick = { if (!busy) state.provisioning.connect(cam) },
                        title = {
                            CupertinoText(cam.name, maxLines = 1, overflow = TextOverflow.Ellipsis)
                        },
                        caption = {
                            CupertinoText(
                                "蓝牙 ${cam.rssi} dBm" + if (paired) " · $savedLbl" else "",
                                fontSize = 12.sp,
                            )
                        },
                        trailingIcon = {},
                    )
                }
                if (nearby.bluetooth.isNotEmpty()) {
                    item {
                        Column(Modifier.fillMaxWidth().padding(it)) {
                            CupertinoText(bleHint, fontSize = 11.sp, color = CupertinoTheme.colorScheme.tertiaryLabel)
                        }
                    }
                }
            }

        }

        /* Same rule as the Bluetooth section above. */
        if (!connected) {
            section(title = { CupertinoText(wifiTitle) }) {
                if (nearby.networks.isEmpty()) {
                    infoRow(hintLbl, if (nearby.searching) "…" else wifiNone)
                }
                nearby.networks.forEach { network ->
                    val isJoined = joined.equals(network.ssid, ignoreCase = true)
                    link(
                        onClick = { if (!busy) state.pickNetwork(network) },
                        title = {
                            CupertinoText(
                                network.ssid + if (isJoined) " ✓" else "",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        },
                        caption = {
                            val credential = if (isJoined || state.hasSavedPassword(network.ssid)) savedLbl else null
                            CupertinoText(
                                listOfNotNull(
                                    if (network.secured) securedLbl else openLbl,
                                    "${network.rssi} dBm",
                                    credential,
                                ).joinToString(" · "),
                                fontSize = 12.sp,
                            )
                        },
                        trailingIcon = {},
                    )
                }
            }

        }

        state.askPasswordFor?.let { network ->
            section(title = { CupertinoText(network.ssid.sectionTitle()) }) {
                item {
                    Column(Modifier.fillMaxWidth().padding(it)) {
                        textField(
                            value = password,
                            onValueChange = { password = it },
                            placeholder = { CupertinoText(passwordLbl) },
                            singleLine = true,
                        )
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth().padding(it),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        AccentButton(
                            label = joinLbl,
                            modifier = Modifier.weight(1f),
                            busy = state.phase == Phase.ConnectingWifi,
                            // A WPA2 hotspot with an empty passphrase is a join that is
                            // already known to fail: Android answers `onUnavailable`
                            // after 1.7 s and the user reads it as "the camera is broken".
                            enabled = password.isNotBlank(),
                        ) {
                            state.connectToNetwork(network, password.ifBlank { null })
                            password = ""
                        }
                        CupertinoButton(
                            onClick = { state.askPasswordFor = null },
                            colors = CupertinoButtonDefaults.grayButtonColors(),
                        ) { CupertinoText(cancelLbl) }
                    }
                }
            }
        }

        section(title = { CupertinoText(otherTitle) }) {
            actionRow(qrLbl) { showQr = true }
            item {
                Column(Modifier.fillMaxWidth().padding(it)) {
                    textField(
                        value = manualIp,
                        onValueChange = { manualIp = it },
                        placeholder = { CupertinoText(ipHint) },
                        singleLine = true,
                    )
                }
            }
            actionRow(ipLbl, busy = state.phase == Phase.IdentifyingDevice) {
                val ip = manualIp.trim()
                if (ip.isNotEmpty()) state.connect(manualHost = ip)
            }
        }
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
 * The card on top of the device tab: what was found and the two buttons that matter.
 * Everything below it is a fallback for when that choice is the wrong one.
 */
@Composable
private fun ConnectHero(
    connected: Boolean,
    title: String,
    subtitle: String,
    refreshLabel: String,
    connectLabel: String,
    disconnectLabel: String,
    scanning: Boolean,
    busy: Boolean,
    canConnect: Boolean,
    footnote: String,
    onRefresh: () -> Unit,
    onConnect: () -> Unit,
    onDisconnect: () -> Unit,
) {
    val scheme = CupertinoTheme.colorScheme
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(scheme.secondarySystemBackground)
            .padding(16.dp),
    ) {
        CupertinoText(
            title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 17.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        if (subtitle.isNotEmpty()) {
            Spacer(Modifier.height(4.dp))
            CupertinoText(subtitle, fontSize = 13.sp, color = scheme.secondaryLabel)
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            if (connected) {
                AccentButton(
                    label = disconnectLabel,
                    modifier = Modifier.weight(1f),
                    container = CupertinoColors.systemRed,
                    onClick = onDisconnect,
                )
            } else {
                CupertinoButton(
                    onClick = onRefresh,
                    modifier = Modifier.heightIn(min = 44.dp),
                    size = CupertinoButtonSize.Large,
                    colors = CupertinoButtonDefaults.grayButtonColors(),
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (scanning) {
                            CupertinoActivityIndicator(size = 14.dp)
                            Spacer(Modifier.width(6.dp))
                        }
                        CupertinoText(refreshLabel, fontWeight = FontWeight.Medium)
                    }
                }
                AccentButton(
                    label = connectLabel,
                    modifier = Modifier.weight(1f),
                    busy = busy,
                    // Disabled with a reason beside it: a greyed 连接 next to "nothing
                    // found" reads as a broken button, so the footnote says what to do.
                    enabled = canConnect && !busy,
                    onClick = onConnect,
                )
            }
        }
        if (footnote.isNotEmpty()) {
            Spacer(Modifier.height(8.dp))
            CupertinoText(footnote, fontSize = 11.sp, color = scheme.tertiaryLabel)
        }
    }
}

/** Big accent button with an inline spinner, so a busy control still explains itself. */
@Composable
internal fun AccentButton(
    label: String,
    modifier: Modifier = Modifier,
    busy: Boolean = false,
    enabled: Boolean = true,
    container: Color = CupertinoTheme.colorScheme.accent,
    onClick: () -> Unit,
) {
    CupertinoButton(
        onClick = onClick,
        modifier = modifier.heightIn(min = 44.dp),
        size = CupertinoButtonSize.Large,
        enabled = enabled && !busy,
        colors = CupertinoButtonDefaults.filledButtonColors(containerColor = container),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (busy) {
                CupertinoActivityIndicator(size = 15.dp, color = Color.White)
                Spacer(Modifier.width(8.dp))
            }
            CupertinoText(text = label, color = Color.White, fontWeight = FontWeight.Medium)
        }
    }
}

/** Label above value, so a long message wraps instead of clipping. */
internal fun LazySectionScope.infoRow(title: String, value: String) {
    item {
        Column(Modifier.fillMaxWidth().padding(it)) {
            CupertinoText(title, fontSize = 12.sp, color = CupertinoTheme.colorScheme.secondaryLabel)
            CupertinoText(value)
        }
    }
}

/** Centred tappable row, mirroring the action rows elsewhere in the app. */
internal fun LazySectionScope.actionRow(
    label: String,
    busy: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    item {
        val accent = CupertinoTheme.colorScheme.accent
        Box(
            Modifier
                .fillMaxWidth()
                .heightIn(min = 44.dp)
                .clickable(enabled = enabled && !busy, onClick = onClick),
            contentAlignment = Alignment.Center,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (busy) {
                    CupertinoActivityIndicator(size = 15.dp, color = accent)
                    Spacer(Modifier.width(8.dp))
                }
                CupertinoText(text = label, color = accent, fontWeight = FontWeight.Medium)
            }
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
