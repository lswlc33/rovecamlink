@file:OptIn(com.robinpcrd.cupertino.ExperimentalCupertinoApi::class)

package com.rovecamlink.app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robinpcrd.cupertino.CupertinoAlertDialog
import com.robinpcrd.cupertino.CupertinoText
import com.robinpcrd.cupertino.cancel
import com.robinpcrd.cupertino.default
import com.robinpcrd.cupertino.theme.CupertinoTheme
import com.rovecamlink.app.ui.ConnectScreen
import com.rovecamlink.app.ui.FilesScreen
import com.rovecamlink.app.ui.LiveScreen
import com.rovecamlink.app.ui.LogScreen
import com.rovecamlink.app.ui.SettingsScreen
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.NavigationBar
import top.yukonga.miuix.kmp.basic.NavigationBarItem
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Folder
import top.yukonga.miuix.kmp.icon.extended.ListView
import top.yukonga.miuix.kmp.icon.extended.Report
import top.yukonga.miuix.kmp.icon.extended.ScreenMirroring
import top.yukonga.miuix.kmp.icon.extended.SearchDevice
import top.yukonga.miuix.kmp.icon.extended.Settings
import top.yukonga.miuix.kmp.theme.MiuixTheme

enum class Tab(val labelRes: StringResource, val icon: ImageVector) {
    Devices(Res.string.tab_devices, MiuixIcons.SearchDevice),
    Live(Res.string.tab_live, MiuixIcons.ScreenMirroring),
    Files(Res.string.tab_files, MiuixIcons.Folder),
    Settings(Res.string.tab_settings, MiuixIcons.Settings),
}

@Composable
fun App(graph: AppGraph = remember { AppGraph() }) {
    val scope = rememberCoroutineScope()
    val state = remember { AppState(graph, scope) }

    CupertinoTheme {
        var tab by remember { mutableStateOf(Tab.Devices) }

        Scaffold(
            containerColor = MiuixTheme.colorScheme.background,
            topBar = {
                TopAppBar(
                    title = stringResource(Res.string.app_name),
                    actions = {
                        ConnectionPill(state)
                        // Diagnostics must be one tap away from any tab: that is where the
                        // failure you want to report just happened. One tap also puts it away
                        // again — the same button is the close control, so the page never has
                        // to be re-found after it was dismissed by a screen change.
                        IconButton(
                            onClick = {
                                if (state.diagnosticsOpen) state.closeDiagnostics() else state.openDiagnostics()
                            },
                        ) {
                            Icon(
                                MiuixIcons.ListView,
                                contentDescription = stringResource(Res.string.action_diagnostics),
                                tint = if (state.diagnosticsOpen) {
                                    MiuixTheme.colorScheme.primary
                                } else {
                                    MiuixTheme.colorScheme.onSurface
                                },
                            )
                        }
                    },
                )
            },
            bottomBar = {
                NavigationBar {
                    Tab.entries.forEach { t ->
                        NavigationBarItem(
                            selected = t == tab,
                            onClick = { tab = t },
                            icon = t.icon,
                            label = stringResource(t.labelRes),
                        )
                    }
                }
            },
        ) { padding ->
            Box(Modifier.fillMaxSize().padding(padding)) {
                if (state.diagnosticsOpen) {
                    LogScreen(state, onClose = { state.closeDiagnostics() })
                } else {
                    when (tab) {
                        Tab.Devices -> ConnectScreen(state)
                        Tab.Live -> LiveScreen(state)
                        Tab.Files -> FilesScreen(state)
                        Tab.Settings -> SettingsScreen(state)
                    }
                }
                state.errorMessage?.let { msg ->
                    ErrorBanner(msg) { state.errorMessage = null }
                }
            }
        }

        // The connect-time VPN question, hosted here rather than on the connection tab
        // because the attempt can start from anywhere — an auto-connect fires the moment
        // a camera hotspot the user joined in Settings appears, and a dialog that only
        // exists on one tab would leave the attempt waiting behind another.
        if (state.vpnPromptOpen) VpnPromptDialog(state)
    }
}

/**
 * "A proxy is running; the camera will not answer while it owns the route." Two
 * buttons and a dismissal: 继续连接 lets the attempt run, 去关闭代理 abandons it and
 * opens the system VPN panel, tapping away ignores the warning and lets it run. This
 * is the only place in the app that mentions VPN — everywhere else the fix would have
 * to be understood from a failed connection, which is how it read when the notice sat
 * on the connection tab permanently.
 */
@Composable
private fun VpnPromptDialog(state: AppState) {
    CupertinoAlertDialog(
        onDismissRequest = { state.answerVpnPrompt(VpnChoice.Proceed) },
        title = { CupertinoText(stringResource(Res.string.vpn_dialog_title)) },
        message = { CupertinoText(stringResource(Res.string.vpn_dialog_message)) },
        buttons = {
            cancel(onClick = { state.answerVpnPrompt(VpnChoice.Proceed) }) {
                CupertinoText(stringResource(Res.string.vpn_dialog_continue))
            }
            default(onClick = { state.answerVpnPrompt(VpnChoice.CloseProxy) }) {
                CupertinoText(stringResource(Res.string.vpn_dialog_close))
            }
        },
    )
}

/** Compact connection-state chip shown in the navigation bar. */
@Composable
private fun ConnectionPill(state: AppState) {
    val scheme = MiuixTheme.colorScheme
    val busy = state.phase != Phase.Connected &&
        state.phase != Phase.Idle &&
        state.phase != Phase.Error
    // Connected and busy share the accent: the chip carries one hue for "the app is
    // doing the right thing" and the spinner is what separates the two. Four hues read
    // as a legend the user has to learn; the spinner reads without being learnt.
    val tint = when (state.phase) {
        Phase.Connected -> scheme.primary
        Phase.Error -> scheme.error
        Phase.Idle -> scheme.onSurfaceVariantSummary
        else -> scheme.primary
    }
    val label = stringResource(
        when (state.phase) {
            Phase.Connected -> Res.string.pill_connected
            Phase.Error -> Res.string.pill_error
            Phase.Idle -> Res.string.pill_offline
            else -> Res.string.pill_busy
        },
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(scheme.surfaceVariant)
            .padding(horizontal = 8.dp, vertical = 3.dp),
    ) {
        if (busy) {
            InfiniteProgressIndicator(
                color = tint,
                size = 12.dp,
                strokeWidth = 1.5.dp,
                orbitingDotSize = 2.dp,
            )
            Spacer(Modifier.width(4.dp))
        }
        Text(
            text = label,
            color = tint,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

/** Dismissible error toast pinned to the bottom of the content area. */
@Composable
private fun ErrorBanner(msg: LocalizedString, onDismiss: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    Box(
        Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(scheme.error)
                .clickable(onClick = onDismiss)
                .padding(horizontal = 14.dp, vertical = 12.dp),
        ) {
            Icon(
                MiuixIcons.Report,
                contentDescription = null,
                tint = scheme.onError,
                modifier = Modifier.size(18.dp),
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = msg.resolve(),
                color = scheme.onError,
                fontSize = 13.sp,
                modifier = Modifier.weight(1f),
            )
        }
    }
}
