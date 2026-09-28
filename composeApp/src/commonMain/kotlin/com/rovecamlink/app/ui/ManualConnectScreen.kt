package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_back
import com.rovecamlink.app.action_connect
import com.rovecamlink.app.core.net.parseManualAddress
import com.rovecamlink.app.hint_manual_connect
import com.rovecamlink.app.hint_manual_connect_example
import com.rovecamlink.app.manual_connect_title
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * The manual-connect page: drive a camera at an address the user types.
 *
 * This is the entry the no-camera workflow has always relied on — the desktop simulator
 * answers on a host:port that no hotspot scan will ever produce — and which the README
 * documented as 「手动连接」 before any such screen existed in this build. It is also the
 * only path that reaches a camera through a port forward (an SSH tunnel to a camera on
 * another network, a desktop host from an emulator), because every other entry point
 * starts from a Wi-Fi hotspot or a QR code.
 *
 * The typed string is parsed by [parseManualAddress] — the same function
 * `AppState.connectBlocking` uses — so the page cannot accept an address the connection
 * state machine would read differently. The camera's own AP must still be reachable from
 * this device; this page chooses *where* to connect, it does not join a network.
 */
@Composable
fun ManualConnectScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val title = stringResource(Res.string.manual_connect_title)
    val hint = stringResource(Res.string.hint_manual_connect)
    val example = stringResource(Res.string.hint_manual_connect_example)
    val connectLbl = stringResource(Res.string.action_connect)
    val haptics = LocalHapticFeedback.current
    var address by remember { mutableStateOf("") }
    val parsed = parseManualAddress(address)

    MiuixPage(
        title = title,
        outerPadding = outerPadding,
        state = state,
        // Pushed page: the bar carries 返回 and nothing else.
        showDiagnostics = false,
        navigationIcon = {
            IconButton(
                onClick = {
                    haptics.tap()
                    onClose()
                },
            ) {
                Icon(
                    MiuixIcons.Back,
                    contentDescription = stringResource(Res.string.action_back),
                    tint = scheme.onSurface,
                )
            }
        },
    ) {
        section {
            MiuixField(
                value = address,
                onValueChange = { address = it },
                placeholder = hint,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp),
            )
            Spacer(Modifier.size(6.dp))
            // Say what the typed address resolved to before anything is dialled — the line
            // doubles as the validation message for a malformed entry.
            hintLine(if (parsed != null) "→ ${parsed.first}:${parsed.second}" else example)
            actionRow(
                label = connectLbl,
                enabled = parsed != null,
                onClick = {
                    state.connect(manualHost = address.trim())
                    onClose()
                },
            )
        }
    }
}
