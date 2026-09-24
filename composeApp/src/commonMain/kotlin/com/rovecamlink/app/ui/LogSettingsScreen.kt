package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.log_close
import com.rovecamlink.app.log_level_hint
import com.rovecamlink.app.log_session_file_line
import com.rovecamlink.app.log_session_opening
import com.rovecamlink.app.log_settings_title
import com.rovecamlink.app.log_switch_bodies
import com.rovecamlink.app.log_switch_recording
import com.rovecamlink.app.log_switch_filesink
import com.rovecamlink.app.log_switch_sampling
import com.rovecamlink.app.log_switch_secrets
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.TabRow
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.preference.SwitchPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * The knobs that shape *what* [Diag] records — split off from [LogScreen] by the
 * 2026-09-23 redesign so the log page can be about reading the log, not configuring it.
 *
 * This is a pushed page in its own right (the log page opens it, and 返回 lands back on
 * the log). It carries the recorded-level picker, the four capture switches, and the
 * session-file line — the same controls that used to hide behind a 「展开」 toggle at the
 * bottom of the log.
 */
@Composable
fun LogSettingsScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    var minLevel by remember { mutableStateOf(Diag.config.minLevel) }
    // The master switch has been implemented and tested in Diag since the start
    // (`setRecording`/`toggleRecording`, `LogConfig.paused`) with a note saying "wire this
    // to one tap" — only the tap was missing. Everything below this row is inert while it
    // is off, so it is read back from the config rather than assumed on.
    var recording by remember { mutableStateOf(!Diag.config.paused) }
    var captureBodies by remember { mutableStateOf(Diag.config.captureBodies) }
    var captureSecrets by remember { mutableStateOf(Diag.config.captureSecrets) }
    var fileSink by remember { mutableStateOf(Diag.config.fileSink) }
    var sampling by remember { mutableStateOf(Diag.config.sampleSteadyTraffic) }
    var sessionPath by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        while (true) {
            sessionPath = Diag.sessionFile()
            delay(600)
        }
    }

    val scheme = MiuixTheme.colorScheme
    val haptics = LocalHapticFeedback.current
    val sessionValue = sessionPath ?: Diag.fileSinkError() ?: stringResource(Res.string.log_session_opening)

    MiuixPage(
        title = stringResource(Res.string.log_settings_title),
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
                    contentDescription = stringResource(Res.string.log_close),
                    tint = scheme.onSurface,
                )
            }
        },
    ) {
        item {
            Text(
                text = stringResource(Res.string.log_level_hint),
                fontSize = 13.sp,
                color = scheme.onSurfaceVariantSummary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp, vertical = 4.dp),
            )
        }
        item {
            TabRow(
                // The segment labels are the level tokens themselves — the file is keyed
                // on `V D I W E`, so translating them here would break the preview's
                // correspondence to the exported log.
                tabs = LogLevel.entries.map { it.name.lowercase().take(4) },
                selectedTabIndex = LogLevel.entries.indexOf(minLevel),
                onTabSelected = { index ->
                    val l = LogLevel.entries[index]
                    if (l != minLevel) haptics.tick()
                    minLevel = l
                    Diag.config.minLevel = l
                    Diag.info(LogTag.LOG, "config minLevel=${l.name}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
            )
        }
        section {
            SwitchPreference(
                title = stringResource(Res.string.log_switch_recording),
                checked = recording,
                onCheckedChange = {
                    haptics.toggle()
                    recording = it
                    Diag.setRecording(it)
                },
            )
            SwitchPreference(
                title = stringResource(Res.string.log_switch_bodies),
                checked = captureBodies,
                onCheckedChange = {
                    haptics.toggle()
                    captureBodies = it
                    Diag.config.captureBodies = it
                    Diag.info(LogTag.LOG, "config bodies=$it")
                },
            )
            SwitchPreference(
                title = stringResource(Res.string.log_switch_secrets),
                checked = captureSecrets,
                onCheckedChange = {
                    haptics.toggle()
                    captureSecrets = it
                    Diag.config.captureSecrets = it
                    Diag.warn(
                        LogTag.LOG,
                        "config secrets=$it — exported files may contain the camera Wi-Fi password",
                    )
                },
            )
            SwitchPreference(
                title = stringResource(Res.string.log_switch_sampling),
                checked = sampling,
                onCheckedChange = {
                    haptics.toggle()
                    sampling = it
                    Diag.config.sampleSteadyTraffic = it
                    Diag.info(LogTag.LOG, "config sampling=$it")
                },
            )
            SwitchPreference(
                title = stringResource(Res.string.log_switch_filesink),
                checked = fileSink,
                onCheckedChange = {
                    haptics.toggle()
                    fileSink = it
                    Diag.setFileLogging(it)
                },
            )
            hintLine(stringResource(Res.string.log_session_file_line, sessionValue))
        }
    }
}
