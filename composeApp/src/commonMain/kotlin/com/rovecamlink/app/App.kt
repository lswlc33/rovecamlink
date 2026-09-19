package com.rovecamlink.app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.alexzhirkevich.cupertino.CupertinoActivityIndicator
import io.github.alexzhirkevich.cupertino.CupertinoButton
import io.github.alexzhirkevich.cupertino.CupertinoScaffold
import io.github.alexzhirkevich.cupertino.CupertinoText
import io.github.alexzhirkevich.cupertino.CupertinoTopAppBar
import io.github.alexzhirkevich.cupertino.theme.CupertinoTheme
import com.rovecamlink.app.ui.DevicesScreen
import com.rovecamlink.app.ui.FilesScreen
import com.rovecamlink.app.ui.LiveScreen
import com.rovecamlink.app.ui.SettingsScreen

enum class Tab(val label: String) {
    Devices("Devices"),
    Live("Live"),
    Files("Files"),
    Settings("Settings"),
}

@Composable
fun App(graph: AppGraph = remember { AppGraph() }) {
    val scope = rememberCoroutineScope()
    val state = remember { AppState(graph, scope) }

    CupertinoTheme {
        var tab by remember { mutableStateOf(Tab.Devices) }
        // Auto-jump to Live once connected the first time.
        val connected = state.phase == Phase.Connected
        if (connected && tab == Tab.Devices) {
            // keep user in control; do not force-switch
        }

        CupertinoScaffold(
            topBar = {
                CupertinoTopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            CupertinoText(
                                text = "RoveCamLink",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 17.sp,
                            )
                            Spacer(Modifier.width(8.dp))
                            ConnectionPill(state)
                        }
                    },
                )
            },
            bottomBar = { BottomTabs(tab) { tab = it } },
        ) { padding ->
            Box(Modifier.fillMaxSize().padding(padding)) {
                when (tab) {
                    Tab.Devices -> DevicesScreen(state)
                    Tab.Live -> LiveScreen(state)
                    Tab.Files -> FilesScreen(state)
                    Tab.Settings -> SettingsScreen(state)
                }
                state.errorMessage?.let { msg ->
                    ErrorBanner(msg) { state.errorMessage = null }
                }
            }
        }
    }
}

@Composable
private fun ConnectionPill(state: AppState) {
    val (bg, text) = when (state.phase) {
        Phase.Connected -> Color(0xFF34C759) to "Connected"
        Phase.Error -> Color(0xFFFF3B30) to "Error"
        Phase.Idle -> Color(0xFF8E8E93) to "Offline"
        else -> Color(0xFFFF9500) to "Busy"
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clip(RoundedCornerShape(50)).background(bg.copy(alpha = 0.18f))
            .padding(horizontal = 8.dp, vertical = 2.dp),
    ) {
        if (state.phase != Phase.Connected && state.phase != Phase.Idle && state.phase != Phase.Error) {
            CupertinoActivityIndicator(Modifier.height(10.dp))
            Spacer(Modifier.width(4.dp))
        }
        CupertinoText(text, color = bg, fontSize = 11.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
private fun BottomTabs(selected: Tab, onSelect: (Tab) -> Unit) {
    Row(
        Modifier.fillMaxWidth().background(Color(0xFFF7F7F7)).padding(top = 6.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Tab.entries.forEach { t ->
            val active = t == selected
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clip(RoundedCornerShape(8.dp)).clickable { onSelect(t) }
                    .padding(horizontal = 14.dp, vertical = 4.dp),
            ) {
                CupertinoText(
                    text = t.label,
                    color = if (active) Color(0xFF007AFF) else Color(0xFF8E8E93),
                    fontSize = 12.sp,
                    fontWeight = if (active) FontWeight.SemiBold else FontWeight.Normal,
                )
            }
        }
    }
}

@Composable
private fun ErrorBanner(msg: String, onDismiss: () -> Unit) {
    Box(Modifier.fillMaxWidth().padding(12.dp), contentAlignment = Alignment.BottomCenter) {
        Row(
            Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(Color(0xFFFF3B30))
                .clickable { onDismiss() }.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CupertinoText(msg, color = Color.White, fontSize = 13.sp, modifier = Modifier.weight(1f))
        }
    }
}

// ---------- small shared widgets ----------

@Composable
fun SectionCard(title: String? = null, content: ColumnScopeContent) {
    Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
        if (title != null) {
            CupertinoText(
                title.uppercase(), color = Color(0xFF8E8E93), fontSize = 12.sp,
                fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 6.dp, start = 4.dp),
            )
        }
        Column(
            Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(Color.White),
        ) { content() }
    }
}

typealias ColumnScopeContent = @Composable androidx.compose.foundation.layout.ColumnScope.() -> Unit

@Composable
fun LabeledRow(label: String, value: String? = null, trailing: (@Composable () -> Unit)? = null, onClick: (() -> Unit)? = null) {
    Row(
        Modifier.fillMaxWidth().then(if (onClick != null) Modifier.clickable { onClick() } else Modifier)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CupertinoText(label, fontSize = 15.sp, modifier = Modifier.weight(1f))
        if (value != null) CupertinoText(value, fontSize = 15.sp, color = Color(0xFF8E8E93))
        if (trailing != null) trailing()
    }
}

@Composable
fun PrimaryButton(label: String, enabled: Boolean = true, busy: Boolean = false, onClick: () -> Unit) {
    CupertinoButton(onClick = onClick, enabled = enabled && !busy, modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            if (busy) {
                CupertinoActivityIndicator(Modifier.height(14.dp), color = Color.White)
                Spacer(Modifier.width(8.dp))
            }
            CupertinoText(label, color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Medium)
        }
    }
}
