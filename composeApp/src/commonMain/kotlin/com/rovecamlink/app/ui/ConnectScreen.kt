package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Phase
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_connect
import com.rovecamlink.app.action_connect_to_ip
import com.rovecamlink.app.action_disconnect
import com.rovecamlink.app.action_join_connect
import com.rovecamlink.app.action_refresh
import com.rovecamlink.app.action_scan_qr
import com.rovecamlink.app.action_wake_camera
import com.rovecamlink.app.hint_wake_needs_bssid
import com.rovecamlink.app.cancel
import com.rovecamlink.app.err_bluetooth_unsupported
import com.rovecamlink.app.hint_ble_wake
import com.rovecamlink.app.hint_connect_choice
import com.rovecamlink.app.hint_last_refresh
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
import com.rovecamlink.app.placeholder_ip
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
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.Text
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
    var manualIp by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showQr by remember { mutableStateOf(false) }
    // Which remembered camera is being renamed, and the text being typed (A6).
    var renameFor by remember { mutableStateOf<String?>(null) }
    var renameText by remember { mutableStateOf("") }
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
    val ipLbl = stringResource(Res.string.action_connect_to_ip)
    val ipHint = stringResource(Res.string.placeholder_ip)
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
    val wakeLbl = stringResource(Res.string.action_wake_camera)
    val wakeNeedsBssidLbl = stringResource(Res.string.hint_wake_needs_bssid)
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
        section {
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
        val pinned = joined
        if (connected && pinned != null) {
            section(title = knownLbl) {
                if (renameFor == pinned) {
                    MiuixField(
                        value = renameText,
                        onValueChange = { renameText = it },
                        placeholder = aliasHint,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                    )
                    Row(
                        Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Button(
                            onClick = {
                                state.setCameraAlias(pinned, renameText.ifBlank { null })
                                renameFor = null
                                renameText = ""
                            },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColorsPrimary(),
                        ) { Text(saveLbl) }
                        Button(
                            onClick = { renameFor = null; renameText = "" },
                            modifier = Modifier.weight(1f),
                        ) { Text(cancelLbl) }
                    }
                } else {
                    actionRow(renameLbl) {
                        renameFor = pinned
                        renameText = state.cameraAlias(pinned).orEmpty()
                    }
                    actionRow(forgetLbl) { state.forgetCamera(pinned) }
                }
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
                        summary = "蓝牙 ${cam.rssi} dBm" + if (paired) " · $savedLbl" else "",
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

        state.askPasswordFor?.let { network ->
            section(title = network.ssid) {
                MiuixField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = passwordLbl,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                )
                Row(
                    Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    val joining = state.phase == Phase.ConnectingWifi
                    Button(
                        onClick = {
                            state.connectToNetwork(network, password.ifBlank { null })
                            password = ""
                        },
                        modifier = Modifier.weight(1f),
                        // A WPA2 hotspot with an empty passphrase is a join that is
                        // already known to fail: Android answers `onUnavailable`
                        // after 1.7 s and the user reads it as "the camera is broken".
                        enabled = password.isNotBlank() && !joining,
                        colors = ButtonDefaults.buttonColorsPrimary(),
                    ) {
                        if (joining) {
                            InfiniteProgressIndicator(
                                color = LocalContentColor.current,
                                size = 15.dp,
                                strokeWidth = 2.dp,
                                orbitingDotSize = 2.5.dp,
                            )
                            Spacer(Modifier.width(8.dp))
                        }
                        Text(joinLbl)
                    }
                    Button(
                        onClick = { state.askPasswordFor = null },
                        colors = ButtonDefaults.buttonColors(),
                    ) {
                        Text(cancelLbl)
                    }
                }
            }
        }

        section(title = otherTitle) {
            actionRow(qrLbl) { showQr = true }
            // B10: the way back from standby. It belongs here rather than with the other
            // power actions because a sleeping camera has no session — the device page is
            // showing "not connected" by the time anyone needs this.
            val canWake = state.canWakeCamera()
            actionRow(wakeLbl, enabled = canWake) { state.wakeCamera() }
            if (!canWake) hintLine(wakeNeedsBssidLbl)
            MiuixField(
                value = manualIp,
                onValueChange = { manualIp = it },
                placeholder = ipHint,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
            )
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
 *
 * It is a [ColumnScope] extension rather than its own list item because the demo puts
 * the top of a page inside the same card every other block uses; a hero floating on the
 * page background was the old toolkit's shape.
 */
@Composable
private fun ColumnScope.ConnectHero(
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
            if (connected) {
                Button(
                    onClick = onDisconnect,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        color = scheme.error,
                        contentColor = scheme.onError,
                    ),
                ) {
                    Text(disconnectLabel)
                }
            } else {
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
                    // Disabled with a reason beside it: a greyed 连接 next to "nothing
                    // found" reads as a broken button, so the footnote says what to do.
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
