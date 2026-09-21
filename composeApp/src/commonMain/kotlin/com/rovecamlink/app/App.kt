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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robinpcrd.cupertino.CupertinoActivityIndicator
import com.robinpcrd.cupertino.CupertinoButtonDefaults
import com.robinpcrd.cupertino.CupertinoIcon
import com.robinpcrd.cupertino.CupertinoIconButton
import com.robinpcrd.cupertino.CupertinoNavigationBar
import com.robinpcrd.cupertino.CupertinoNavigationBarItem
import com.robinpcrd.cupertino.CupertinoScaffold
import com.robinpcrd.cupertino.CupertinoText
import com.robinpcrd.cupertino.CupertinoTopAppBar
import com.robinpcrd.cupertino.icons.CupertinoIcons
import com.robinpcrd.cupertino.icons.filled.ExclamationmarkCircle
import com.robinpcrd.cupertino.icons.filled.Folder
import com.robinpcrd.cupertino.icons.filled.Gearshape2
import com.robinpcrd.cupertino.icons.filled.Terminal
import com.robinpcrd.cupertino.icons.filled.Video
import com.robinpcrd.cupertino.icons.filled.WifiRouter
import com.robinpcrd.cupertino.theme.CupertinoColors
import com.robinpcrd.cupertino.theme.CupertinoTheme
import com.robinpcrd.cupertino.theme.systemGreen
import com.robinpcrd.cupertino.theme.systemOrange
import com.robinpcrd.cupertino.theme.systemRed
import com.rovecamlink.app.ui.DevicesScreen
import com.rovecamlink.app.ui.FilesScreen
import com.rovecamlink.app.ui.LiveScreen
import com.rovecamlink.app.ui.LogScreen
import com.rovecamlink.app.ui.SettingsScreen
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

enum class Tab(val labelRes: StringResource, val icon: ImageVector) {
    Devices(Res.string.tab_devices, CupertinoIcons.Filled.WifiRouter),
    Live(Res.string.tab_live, CupertinoIcons.Filled.Video),
    Files(Res.string.tab_files, CupertinoIcons.Filled.Folder),
    Settings(Res.string.tab_settings, CupertinoIcons.Filled.Gearshape2),
}

@Composable
fun App(graph: AppGraph = remember { AppGraph() }) {
    val scope = rememberCoroutineScope()
    val state = remember { AppState(graph, scope) }

    CupertinoTheme {
        var tab by remember { mutableStateOf(Tab.Devices) }

        CupertinoScaffold(
            containerColor = CupertinoTheme.colorScheme.systemGroupedBackground,
            topBar = {
                CupertinoTopAppBar(
                    title = {
                        CupertinoText(
                            text = stringResource(Res.string.app_name),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 17.sp,
                        )
                    },
                    actions = {
                ConnectionPill(state)
                // Diagnostics must be one tap away from any tab: that is where the
                // failure you want to report just happened.
                CupertinoIconButton(
                    onClick = { state.openDiagnostics() },
                    colors = CupertinoButtonDefaults.plainButtonColors(),
                ) {
                    CupertinoIcon(
                        CupertinoIcons.Filled.Terminal,
                        contentDescription = "Diagnostics",
                        modifier = Modifier.size(20.dp),
                    )
                }
            },
                )
            },
            bottomBar = {
                CupertinoNavigationBar {
                    Tab.entries.forEach { t ->
                        val label = stringResource(t.labelRes)
                        CupertinoNavigationBarItem(
                            selected = t == tab,
                            onClick = { tab = t },
                            icon = {
                                CupertinoIcon(t.icon, contentDescription = label)
                            },
                            label = { CupertinoText(label) },
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
                        Tab.Devices -> DevicesScreen(state)
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
    }
}

/** Compact connection-state chip shown in the navigation bar. */
@Composable
private fun ConnectionPill(state: AppState) {
    val scheme = CupertinoTheme.colorScheme
    val busy = state.phase != Phase.Connected &&
        state.phase != Phase.Idle &&
        state.phase != Phase.Error
    val tint = when (state.phase) {
        Phase.Connected -> CupertinoColors.systemGreen
        Phase.Error -> CupertinoColors.systemRed
        Phase.Idle -> scheme.secondaryLabel
        else -> CupertinoColors.systemOrange
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
            .background(scheme.quaternarySystemFill)
            .padding(horizontal = 8.dp, vertical = 3.dp),
    ) {
        if (busy) {
            CupertinoActivityIndicator(size = 10.dp, color = tint)
            Spacer(Modifier.width(4.dp))
        }
        CupertinoText(
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
    Box(
        Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(CupertinoColors.systemRed)
                .clickable(onClick = onDismiss)
                .padding(horizontal = 14.dp, vertical = 12.dp),
        ) {
            CupertinoIcon(
                CupertinoIcons.Filled.ExclamationmarkCircle,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(18.dp),
            )
            Spacer(Modifier.width(8.dp))
            CupertinoText(
                text = msg.resolve(),
                color = Color.White,
                fontSize = 13.sp,
                modifier = Modifier.weight(1f),
            )
        }
    }
}
