package com.rovecamlink.app.ui

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import com.rovecamlink.app.action_auto_connect
import com.rovecamlink.app.action_connect_to_ip
import com.rovecamlink.app.action_disconnect
import com.rovecamlink.app.action_join_connect
import com.rovecamlink.app.action_scan_cameras
import com.rovecamlink.app.action_scan_qr
import com.rovecamlink.app.action_use_this_network
import com.rovecamlink.app.cancel
import com.rovecamlink.app.hint_auto_connect
import com.rovecamlink.app.label_bluetooth_cameras
import com.rovecamlink.app.label_bluetooth_idle
import com.rovecamlink.app.label_bluetooth_none
import com.rovecamlink.app.label_current_camera_wifi
import com.rovecamlink.app.label_host
import com.rovecamlink.app.label_info
import com.rovecamlink.app.label_model
import com.rovecamlink.app.label_nearby_cameras
import com.rovecamlink.app.label_other_ways
import com.rovecamlink.app.label_password
import com.rovecamlink.app.label_phase
import com.rovecamlink.app.label_wifi_cameras
import com.rovecamlink.app.nearby_cameras_none
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
import com.rovecamlink.app.resolve
import com.rovecamlink.app.section_status
import com.rovecamlink.app.wifi_open
import com.rovecamlink.app.wifi_secured
import com.rovecamlink.app.Res
import com.rovecamlink.app.core.qr.QrScanScreen
import com.rovecamlink.app.core.wifi.CameraNetwork
import com.rovecamlink.app.core.wifi.DEFAULT_PREFIXES
import org.jetbrains.compose.resources.stringResource

/**
 * The connection screen: one obvious action at the top, everything else beneath it
 * in the order a person actually tries things.
 *
 * 1. Bluetooth — nothing to type, and it wakes the camera's hotspot for you.
 * 2. The hotspot the phone is already joined to — adopt it, never rejoin it.
 * 3. A camera hotspot from the Wi-Fi list.
 * 4. QR code / literal IP, for the firmware that will not cooperate.
 *
 * Every failure names itself ("Bluetooth is off on this phone") instead of leaving
 * an empty list to interpret, and the VPN case is explained rather than hidden —
 * that combination is what made the official app feel broken on this project.
 *
 * Strings are resolved up front because a section body is not a composable scope.
 */
@Composable
fun ConnectScreen(state: AppState) {
    val provision = state.provisioning
    var selected by remember { mutableStateOf<CameraNetwork?>(null) }
    var password by remember { mutableStateOf("") }
    var manualIp by remember { mutableStateOf("") }
    var showQr by remember { mutableStateOf(false) }

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

    val statusTitle = stringResource(Res.string.section_status).sectionTitle()
    val phaseLbl = stringResource(Res.string.label_phase)
    val infoLbl = stringResource(Res.string.label_info)
    val modelLbl = stringResource(Res.string.label_model)
    val hostLbl = stringResource(Res.string.label_host)
    val phaseNow = phaseText(state.phase)
    val statusNow = state.statusMessage?.resolve().orEmpty()
    val noticeNow = provision.notice?.resolve() ?: state.errorMessage?.resolve()
    val vpnNote = stringResource(Res.string.notice_vpn_active)
    val disconnectLbl = stringResource(Res.string.action_disconnect)
    val autoLbl = stringResource(Res.string.action_auto_connect)
    val autoHint = stringResource(Res.string.hint_auto_connect)
    val bleTitle = stringResource(Res.string.label_bluetooth_cameras).sectionTitle()
    val nearbyLbl = stringResource(Res.string.label_nearby_cameras)
    val bleNone = stringResource(Res.string.label_bluetooth_none)
    val bleIdle = stringResource(Res.string.label_bluetooth_idle)
    val wifiTitle = stringResource(Res.string.label_wifi_cameras).sectionTitle()
    val wifiNone = stringResource(Res.string.nearby_cameras_none)
    val securedLbl = stringResource(Res.string.wifi_secured)
    val openLbl = stringResource(Res.string.wifi_open)
    val scanWifiLbl = stringResource(Res.string.action_scan_cameras)
    val otherTitle = stringResource(Res.string.label_other_ways).sectionTitle()
    val scanQrLbl = stringResource(Res.string.action_scan_qr)
    val ipHint = stringResource(Res.string.placeholder_ip)
    val connectIpLbl = stringResource(Res.string.action_connect_to_ip)

    val connected = state.phase == Phase.Connected
    val joinedCamera = state.currentWifiSsid?.takeIf { ssid ->
        DEFAULT_PREFIXES.any { ssid.startsWith(it, ignoreCase = true) }
    }
    val connecting = state.phase == Phase.ConnectingWifi ||
        state.phase == Phase.IdentifyingDevice ||
        state.phase == Phase.ConnectingProtocol ||
        state.phase == Phase.SyncingTime

    LazyColumn(Modifier.fillMaxSize()) {
        section(title = { CupertinoText(statusTitle) }) {
            infoRow(phaseLbl, phaseNow)
            if (statusNow.isNotEmpty()) infoRow(infoLbl, statusNow)
            if (!noticeNow.isNullOrEmpty()) infoRow("!", noticeNow)
            if (state.vpnActive) infoRow("VPN", vpnNote)
            state.session?.let { s ->
                infoRow(modelLbl, s.model)
                infoRow(hostLbl, "${s.host}:${s.port}")
            }
        }

        if (connected) {
            section {
                item {
                    Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp)) {
                        PrimaryButton(
                            label = disconnectLbl,
                            container = CupertinoColors.systemRed,
                            modifier = Modifier.fillMaxWidth(),
                            onClick = { state.disconnect() },
                        )
                    }
                }
            }
            return@LazyColumn
        }

        // The one control most people ever touch.
        item {
            Column(
                Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PrimaryButton(
                    label = autoLbl,
                    busy = provision.busy || connecting,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        // A camera we already paired with goes straight to the
                        // handshake; anything else needs a scan first.
                        val paired = provision.cameras.firstOrNull { provision.isPaired(it) }
                        if (paired != null) provision.connect(paired) else provision.scan()
                    },
                )
                Spacer(Modifier.height(6.dp))
                CupertinoText(
                    text = autoHint,
                    fontSize = 12.sp,
                    color = CupertinoTheme.colorScheme.tertiaryLabel,
                    textAlign = TextAlign.Center,
                )
            }
        }

        if (provision.supported()) {
            section(title = { CupertinoText(bleTitle) }) {
                if (provision.cameras.isEmpty()) {
                    val bleLine = when {
                        provision.busy -> "…"
                        !provision.scanned -> bleIdle
                        else -> bleNone
                    }
                    infoRow(nearbyLbl, bleLine)
                }
                provision.cameras.forEach { cam ->
                    val pairedMark = if (provision.isPaired(cam)) " · ✓" else ""
                    link(
                        onClick = { provision.connect(cam) },
                        title = { CupertinoText(cam.name) },
                        caption = { CupertinoText("${cam.rssi} dBm$pairedMark") },
                        trailingIcon = {},
                    )
                }
            }
        }

        // Already joined the hotspot in Settings: adopt it, do not rejoin it.
        joinedCamera?.let { ssid ->
            section {
                item {
                    Row(
                        Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        CupertinoText(
                            text = stringResource(Res.string.label_current_camera_wifi, ssid),
                            modifier = Modifier.weight(1f),
                        )
                        CupertinoButton(
                            onClick = { state.connect() },
                            size = CupertinoButtonSize.Small,
                            colors = CupertinoButtonDefaults.filledButtonColors(),
                        ) {
                            CupertinoText(stringResource(Res.string.action_use_this_network))
                        }
                    }
                }
            }
        }

        section(title = { CupertinoText(wifiTitle) }) {
            if (state.networks.isEmpty()) infoRow(nearbyLbl, wifiNone)
            state.networks.forEach { network ->
                val security = if (network.secured) securedLbl else openLbl
                link(
                    onClick = {
                        if (network.secured) {
                            selected = network
                            password = ""
                        } else {
                            state.connect(network.ssid, null)
                        }
                    },
                    title = { CupertinoText(network.ssid) },
                    caption = { CupertinoText("$security · ${network.rssi} dBm") },
                    trailingIcon = {},
                )
            }
            actionRow(scanWifiLbl, busy = state.phase == Phase.ScanningWifi) { state.scanWifi() }
        }

        selected?.let { network ->
            section(title = { CupertinoText(network.ssid.sectionTitle()) }) {
                item {
                    Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp)) {
                        textField(
                            value = password,
                            onValueChange = { password = it },
                            placeholder = { CupertinoText(stringResource(Res.string.label_password)) },
                            singleLine = true,
                        )
                    }
                }
                item {
                    Row(
                        Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        PrimaryButton(
                            label = stringResource(Res.string.action_join_connect),
                            modifier = Modifier.weight(1f),
                            busy = state.phase == Phase.ConnectingWifi,
                        ) {
                            state.connect(network.ssid, password.ifBlank { null })
                            selected = null
                        }
                        CupertinoButton(
                            onClick = { selected = null },
                            colors = CupertinoButtonDefaults.grayButtonColors(),
                        ) { CupertinoText(stringResource(Res.string.cancel)) }
                    }
                }
            }
        }

        // Kept, but out of the way: the last resort, not the first screen.
        section(title = { CupertinoText(otherTitle) }) {
            actionRow(scanQrLbl) { showQr = true }
            item {
                Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp)) {
                    textField(
                        value = manualIp,
                        onValueChange = { manualIp = it },
                        placeholder = { CupertinoText(ipHint) },
                        singleLine = true,
                    )
                }
            }
            actionRow(connectIpLbl, busy = state.phase == Phase.IdentifyingDevice) {
                val ip = manualIp.trim()
                if (ip.isNotEmpty()) state.connect(manualHost = ip)
            }
        }
    }
}

/** Big accent button with an inline spinner, so a busy control still explains itself. */
@Composable
private fun PrimaryButton(
    label: String,
    modifier: Modifier = Modifier,
    busy: Boolean = false,
    container: Color = CupertinoTheme.colorScheme.accent,
    onClick: () -> Unit,
) {
    CupertinoButton(
        onClick = onClick,
        modifier = modifier.heightIn(min = 44.dp),
        size = CupertinoButtonSize.Large,
        enabled = !busy,
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
private fun LazySectionScope.infoRow(title: String, value: String) {
    item {
        Column(
            Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
        ) {
            CupertinoText(text = title, fontSize = 12.sp, color = CupertinoTheme.colorScheme.secondaryLabel)
            CupertinoText(text = value)
        }
    }
}

/** Centred tappable row, mirroring the action rows elsewhere in the app. */
private fun LazySectionScope.actionRow(
    label: String,
    busy: Boolean = false,
    onClick: () -> Unit,
) {
    item {
        val accent = CupertinoTheme.colorScheme.accent
        Box(
            Modifier
                .fillMaxWidth()
                .heightIn(min = 44.dp)
                .clickable(onClick = onClick),
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

/** Phase → the words a user reads, including the two Bluetooth-only stages. */
@Composable
private fun phaseText(phase: Phase): String = stringResource(
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
