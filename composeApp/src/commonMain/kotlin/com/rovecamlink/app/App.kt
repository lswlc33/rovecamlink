package com.rovecamlink.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.rovecamlink.app.ui.AboutScreen
import com.rovecamlink.app.ui.ConfirmDialog
import com.rovecamlink.app.ui.ConnectScreen
import com.rovecamlink.app.ui.ErrorBanner
import com.rovecamlink.app.ui.FilesScreen
import com.rovecamlink.app.ui.LiveScreen
import com.rovecamlink.app.ui.LogScreen
import com.rovecamlink.app.ui.LogSettingsScreen
import com.rovecamlink.app.ui.PermissionsScreen
import com.rovecamlink.app.ui.SettingsScreen
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.NavigationBar
import top.yukonga.miuix.kmp.basic.NavigationBarItem
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Folder
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

/**
 * The shell: a bottom navigation bar and nothing else.
 *
 * The bar at the top of the window belongs to the page under it — see `MiuixPage` — so
 * that it can name the page rather than the app and collapse as that page's list moves.
 * The window title still names the app.
 */
@Composable
fun App(graph: AppGraph = remember { AppGraph() }) {
    val scope = rememberCoroutineScope()
    val state = remember { AppState(graph, scope) }

    var tab by remember { mutableStateOf(Tab.Devices) }

    Scaffold(
        containerColor = MiuixTheme.colorScheme.background,
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
        Box(Modifier.fillMaxSize()) {
            // The pushed layer wins over the tab underneath: the log, its settings and the
            // about page each get the whole window and their own back arrow, rather than
            // being painted over one tab's content. `topPage` is the stack's head; null
            // means no page is pushed and the selected tab shows through.
            when (state.topPage) {
                Page.Log -> LogScreen(state, outerPadding = padding, onClose = { state.popPage() })
                Page.LogSettings -> LogSettingsScreen(state, outerPadding = padding, onClose = { state.popPage() })
                Page.About -> AboutScreen(state, outerPadding = padding, onClose = { state.popPage() })
                Page.Permissions -> PermissionsScreen(state, outerPadding = padding, onClose = { state.popPage() })
                null -> when (tab) {
                    Tab.Devices -> ConnectScreen(state, outerPadding = padding)
                    Tab.Live -> LiveScreen(state, outerPadding = padding)
                    Tab.Files -> FilesScreen(state, outerPadding = padding)
                    Tab.Settings -> SettingsScreen(state, outerPadding = padding)
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

/**
 * "A proxy is running; the camera will not answer while it owns the route." Two
 * buttons and a dismissal: 继续连接 lets the attempt run, 去关闭代理 abandons it and
 * opens the system VPN panel, tapping away ignores the warning and lets it run. This
 * is the only place in the app that mentions VPN — everywhere else the fix would have
 * to be understood from a failed connection, which is how it read when the notice sat
 * on the connection tab permanently.
 *
 * The dialog leads with the safe choice: [ConfirmDialog] puts confirm on the right, and
 * here that slot is 去关闭代理 — the action that stops the doomed attempt — while the
 * left slot keeps it running.
 */
@Composable
private fun VpnPromptDialog(state: AppState) {
    ConfirmDialog(
        title = stringResource(Res.string.vpn_dialog_title),
        message = stringResource(Res.string.vpn_dialog_message),
        confirmLabel = stringResource(Res.string.vpn_dialog_close),
        cancelLabel = stringResource(Res.string.vpn_dialog_continue),
        onConfirm = { state.answerVpnPrompt(VpnChoice.CloseProxy) },
        onDismiss = { state.answerVpnPrompt(VpnChoice.Proceed) },
        destructive = false,
    )
}
