@file:OptIn(com.robinpcrd.cupertino.ExperimentalCupertinoApi::class)

package com.rovecamlink.app.ui

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.robinpcrd.cupertino.CupertinoActivityIndicator
import com.robinpcrd.cupertino.CupertinoAlertDialog
import com.robinpcrd.cupertino.cancel
import com.robinpcrd.cupertino.CupertinoButton
import com.robinpcrd.cupertino.CupertinoButtonDefaults
import com.robinpcrd.cupertino.CupertinoButtonSize
import com.robinpcrd.cupertino.CupertinoSegmentedControl
import com.robinpcrd.cupertino.CupertinoSegmentedControlTab
import com.robinpcrd.cupertino.CupertinoSwitch
import com.robinpcrd.cupertino.CupertinoText
import com.robinpcrd.cupertino.CupertinoTextField
import com.robinpcrd.cupertino.theme.CupertinoColors
import com.robinpcrd.cupertino.theme.CupertinoTheme
import com.robinpcrd.cupertino.theme.systemOrange
import com.robinpcrd.cupertino.theme.systemRed
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.log_action_save
import com.rovecamlink.app.log_action_save_current
import com.rovecamlink.app.log_action_share
import com.rovecamlink.app.log_action_share_current
import com.rovecamlink.app.log_action_snapshot
import com.rovecamlink.app.log_busy_preparing
import com.rovecamlink.app.log_busy_saving
import com.rovecamlink.app.log_close
import com.rovecamlink.app.log_empty
import com.rovecamlink.app.log_export_hint
import com.rovecamlink.app.log_filter_all
import com.rovecamlink.app.log_filter_error
import com.rovecamlink.app.log_filter_info
import com.rovecamlink.app.log_filter_placeholder
import com.rovecamlink.app.log_filter_warn
import com.rovecamlink.app.log_follow
import com.rovecamlink.app.log_hide
import com.rovecamlink.app.log_level_hint
import com.rovecamlink.app.log_no_match
import com.rovecamlink.app.log_note_export_failed
import com.rovecamlink.app.log_note_save_failed
import com.rovecamlink.app.log_note_saved
import com.rovecamlink.app.log_note_share_unavailable
import com.rovecamlink.app.log_note_shared
import com.rovecamlink.app.log_records_summary
import com.rovecamlink.app.log_session_file_line
import com.rovecamlink.app.log_session_opening
import com.rovecamlink.app.log_settings_title
import com.rovecamlink.app.log_show
import com.rovecamlink.app.log_switch_bodies
import com.rovecamlink.app.log_switch_filesink
import com.rovecamlink.app.log_switch_sampling
import com.rovecamlink.app.log_switch_secrets
import com.rovecamlink.app.log_title
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogRecord
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.createLogStore
// Every generated top-level extension lives in `com.rovecamlink.app` and MUST be
// imported by name — that, not any real resource-lookup bug, is what made earlier
// attempts here fail to resolve. (docs/06 and the old note in Screens.kt blamed the
// resolver; ConnectScreen proves ~40 of these resolve fine once imported.)
import kotlinx.coroutines.delay
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource

/**
 * Live diagnostic log: the in-app preview of what [Diag] is recording, plus the
 * exits a support request needs.
 *
 * The primary Share/Save action exports *every* persisted run ([Diag.exportFullBundle],
 * replayed off disk), because that is what survives a crash — the previous runs are
 * the reason a user files a report. A secondary, clearly labelled pair exports only
 * the current session ([Diag.exportBundle], the in-memory ring).
 *
 * Labels are localised through [Res.string]; the *records themselves* stay as the
 * on-disk `rovdiag/1` grammar — they are a developer artifact and are grepped.
 */
@Composable
fun LogScreen(state: AppState, onClose: () -> Unit) {
    val store = remember { createLogStore() }
    val scope = rememberCoroutineScope()

    var records by remember { mutableStateOf<List<LogRecord>>(emptyList()) }
    var total by remember { mutableStateOf(0) }
    var viewLevel by remember { mutableStateOf<LogLevel?>(null) }
    var query by remember { mutableStateOf("") }
    var follow by remember { mutableStateOf(true) }
    var showConfig by remember { mutableStateOf(false) }
    var detail by remember { mutableStateOf<LogRecord?>(null) }
    var busy by remember { mutableStateOf<String?>(null) }
    var note by remember { mutableStateOf<String?>(null) }
    var minLevel by remember { mutableStateOf(Diag.config.minLevel) }
    var captureBodies by remember { mutableStateOf(Diag.config.captureBodies) }
    var captureSecrets by remember { mutableStateOf(Diag.config.captureSecrets) }
    var fileSink by remember { mutableStateOf(Diag.config.fileSink) }
    var sampling by remember { mutableStateOf(Diag.config.sampleSteadyTraffic) }
    var sessionPath by remember { mutableStateOf<String?>(null) }

    // Polling (rather than a flow) keeps the preview honest about records that were
    // demoted to TRACE by sampling: every tick re-reads the writer's buffer.
    LaunchedEffect(viewLevel, query) {
        while (true) {
            records = Diag.tail(1_200, viewLevel, query)
            total = Diag.count()
            sessionPath = Diag.sessionFile()
            state.refreshDiagnosticsEnv()
            delay(400)
        }
    }

    val listState = rememberLazyListState()
    // Keyed on the newest sequence number, not on `records.size`: the tail is capped,
    // so the size stops changing after a couple of minutes of polling while the
    // content keeps moving.
    LaunchedEffect(follow, records.lastOrNull()?.seq) {
        val last = records.lastIndex
        if (follow && last >= 0) listState.scrollToItem(last)
    }

    // [full] picks between the every-run export and the current-run-only export; both
    // share the same flush + save/share plumbing.
    fun export(share: Boolean, full: Boolean) {
        if (busy != null) return
        scope.launch(NonCancellable) {
            // NonCancellable: this coroutine belongs to the screen, and closing the
            // preview mid-export would otherwise discard the bundle it just built.
            busy = getString(if (share) Res.string.log_busy_preparing else Res.string.log_busy_saving)
            try {
                Diag.awaitDrained()
                val text = if (full) Diag.exportFullBundle() else Diag.exportBundle()
                val name = if (full) Diag.exportFullName() else Diag.exportName()
                val size = LogFormat.size(text.length.toLong())
                val outcome = if (share) {
                    if (store.share(name, text)) {
                        getString(Res.string.log_note_shared, name, size)
                    } else {
                        getString(Res.string.log_note_share_unavailable)
                    }
                } else {
                    val saved = store.save(name, text)
                    if (saved != null) getString(Res.string.log_note_saved, saved)
                    else getString(Res.string.log_note_save_failed)
                }
                note = outcome
                Diag.info(LogTag.LOG, "export ${if (share) "shared" else "saved"}: $outcome")
            } catch (t: Throwable) {
                note = getString(Res.string.log_note_export_failed, t.message ?: "?")
                Diag.error(LogTag.LOG, "export failed ${Diag.causeChain(t)}")
            } finally {
                busy = null
            }
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(CupertinoTheme.colorScheme.systemGroupedBackground),
    ) {
        // ---------- title bar ----------
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
        ) {
            CupertinoButton(
                onClick = onClose,
                colors = CupertinoButtonDefaults.grayButtonColors(),
                size = CupertinoButtonSize.Small,
            ) { CupertinoText(stringResource(Res.string.log_close)) }
            Spacer(Modifier.width(10.dp))
            Column(Modifier.weight(1f)) {
                CupertinoText(stringResource(Res.string.log_title), fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                CupertinoText(
                    text = stringResource(Res.string.log_records_summary, total, records.size),
                    color = CupertinoTheme.colorScheme.secondaryLabel,
                    fontSize = 11.sp,
                )
            }
            if (busy != null) CupertinoActivityIndicator(size = 16.dp)
        }

        // ---------- actions ----------
        // Three equal columns, one line each. Left at their natural size the row wrapped
        // 「导出并分享」and「保存到文件」onto two lines at 420.dp while the third button
        // stayed single-line, so the row read as two different heights.
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
        ) {
            CupertinoButton(
                onClick = { export(share = true, full = true) },
                modifier = Modifier.weight(1f),
                enabled = busy == null,
            ) {
                CupertinoText(
                    stringResource(Res.string.log_action_share),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            CupertinoButton(
                onClick = { export(share = false, full = true) },
                modifier = Modifier.weight(1f),
                enabled = busy == null,
                colors = CupertinoButtonDefaults.grayButtonColors(),
            ) {
                CupertinoText(
                    stringResource(Res.string.log_action_save),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            CupertinoButton(
                onClick = {
                    state.refreshDiagnosticsEnv()
                    Diag.info(LogTag.LOG, "environment snapshot requested")
                    runCatching { Diag.envProvider?.invoke() }
                        .getOrNull()
                        ?.forEach { (k, v) -> Diag.info(LogTag.DEV, "env $k=$LogFormat.field(v, Diag.config.captureSecrets)") }
                },
                modifier = Modifier.weight(1f),
                enabled = busy == null,
                colors = CupertinoButtonDefaults.grayButtonColors(),
            ) {
                CupertinoText(
                    stringResource(Res.string.log_action_snapshot),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        // Secondary, explicitly current-run-only path so the every-run default above is
        // never mistaken for "this session only". The explanation gets its own line: sharing
        // one Row with the two buttons squeezed it into two ragged lines that the buttons
        // then sat in the middle of.
        CupertinoText(
            text = stringResource(Res.string.log_export_hint),
            color = CupertinoTheme.colorScheme.tertiaryLabel,
            fontSize = 10.sp,
            modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp, top = 6.dp),
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp),
        ) {
            CupertinoButton(
                onClick = { export(share = true, full = false) },
                enabled = busy == null,
                size = CupertinoButtonSize.Small,
                colors = CupertinoButtonDefaults.grayButtonColors(),
            ) { CupertinoText(stringResource(Res.string.log_action_share_current), fontSize = 12.sp) }
            CupertinoButton(
                onClick = { export(share = false, full = false) },
                enabled = busy == null,
                size = CupertinoButtonSize.Small,
                colors = CupertinoButtonDefaults.grayButtonColors(),
            ) { CupertinoText(stringResource(Res.string.log_action_save_current), fontSize = 12.sp) }
        }

        note?.let {
            CupertinoText(
                text = it,
                color = CupertinoTheme.colorScheme.secondaryLabel,
                fontSize = 11.sp,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp),
            )
        }

        // ---------- filters ----------
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 6.dp),
        ) {
            val levelTabs = listOf(
                stringResource(Res.string.log_filter_all) to null,
                stringResource(Res.string.log_filter_info) to LogLevel.INFO,
                stringResource(Res.string.log_filter_warn) to LogLevel.WARN,
                stringResource(Res.string.log_filter_error) to LogLevel.ERROR,
            )
            CupertinoSegmentedControl(
                selectedTabIndex = levelTabs.map { it.second }.indexOf(viewLevel).coerceAtLeast(0),
                modifier = Modifier.weight(1f),
                paddingValues = PaddingValues(0.dp),
            ) {
                levelTabs.forEach { (label, level) ->
                    CupertinoSegmentedControlTab(
                        onClick = { viewLevel = level },
                        isSelected = viewLevel == level,
                    ) { CupertinoText(label, fontSize = 12.sp) }
                }
            }
            Spacer(Modifier.width(8.dp))
            CupertinoSwitch(checked = follow, onCheckedChange = { follow = it })
            Spacer(Modifier.width(4.dp))
            CupertinoText(stringResource(Res.string.log_follow), fontSize = 12.sp)
        }
        CupertinoTextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { CupertinoText(stringResource(Res.string.log_filter_placeholder), fontSize = 13.sp) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
        )

        // ---------- settings disclosure ----------
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showConfig = !showConfig }
                .padding(horizontal = 12.dp, vertical = 8.dp),
        ) {
            CupertinoText(
                stringResource(Res.string.log_settings_title),
                color = CupertinoTheme.colorScheme.accent,
                fontSize = 13.sp,
                modifier = Modifier.weight(1f),
            )
            CupertinoText(
                stringResource(if (showConfig) Res.string.log_hide else Res.string.log_show),
                fontSize = 11.sp,
            )
        }
        if (showConfig) {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 8.dp),
            ) {
                CupertinoText(
                    stringResource(Res.string.log_level_hint),
                    color = CupertinoTheme.colorScheme.secondaryLabel,
                    fontSize = 11.sp,
                )
                CupertinoSegmentedControl(
                    selectedTabIndex = LogLevel.entries.indexOf(minLevel),
                    modifier = Modifier.fillMaxWidth(),
                    paddingValues = PaddingValues(0.dp),
                ) {
                    // The segment labels are the level tokens themselves — the file is
                    // keyed on `V D I W E`, so translating them here would break the
                    // preview's correspondence to the exported log.
                    LogLevel.entries.forEach { l ->
                        CupertinoSegmentedControlTab(
                            onClick = {
                                minLevel = l
                                Diag.config.minLevel = l
                                Diag.info(LogTag.LOG, "config minLevel=${l.name}")
                            },
                            isSelected = minLevel == l,
                        ) { CupertinoText(l.name.lowercase().take(4), fontSize = 12.sp) }
                    }
                }
                LogSwitch(stringResource(Res.string.log_switch_bodies), captureBodies) {
                    captureBodies = it
                    Diag.config.captureBodies = it
                    Diag.info(LogTag.LOG, "config bodies=$it")
                }
                LogSwitch(stringResource(Res.string.log_switch_secrets), captureSecrets) {
                    captureSecrets = it
                    Diag.config.captureSecrets = it
                    Diag.warn(
                        LogTag.LOG,
                        "config secrets=$it — exported files may contain the camera Wi-Fi password",
                    )
                }
                LogSwitch(stringResource(Res.string.log_switch_sampling), sampling) {
                    sampling = it
                    Diag.config.sampleSteadyTraffic = it
                    Diag.info(LogTag.LOG, "config sampling=$it")
                }
                LogSwitch(stringResource(Res.string.log_switch_filesink), fileSink) {
                    fileSink = it
                    Diag.config.fileSink = it
                    Diag.info(LogTag.LOG, "config file_sink=$it")
                }
                val sessionValue = sessionPath ?: Diag.fileSinkError() ?: stringResource(Res.string.log_session_opening)
                CupertinoText(
                    text = stringResource(Res.string.log_session_file_line, sessionValue),
                    color = CupertinoTheme.colorScheme.tertiaryLabel,
                    fontSize = 10.sp,
                    maxLines = 3,
                )
            }
        }

        // ---------- records ----------
        LazyColumn(
            state = listState,
            // The body has no other vertical air, so without this the first log line starts
            // level with the 日志设置 disclosure row right above it.
            contentPadding = PaddingValues(vertical = 6.dp),
            modifier = Modifier.fillMaxWidth().weight(1f).background(CupertinoTheme.colorScheme.secondarySystemBackground),
        ) {
            itemsIndexed(records) { _, rec ->
                LogLine(rec) { detail = rec }
            }
            if (records.isEmpty()) {
                item {
                    CupertinoText(
                        text = stringResource(
                            if (query.isBlank() && viewLevel == null) Res.string.log_empty else Res.string.log_no_match,
                        ),
                        color = CupertinoTheme.colorScheme.tertiaryLabel,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp),
                    )
                }
            }
        }
    }

    detail?.let { rec ->
        CupertinoAlertDialog(
            onDismissRequest = { detail = null },
            // The dialog title is the record's own identifiers (seq/level/tag) — part of
            // the log grammar, deliberately not translated.
            title = { CupertinoText("#${rec.seq} ${rec.level.name} ${rec.tag.id}") },
            message = {
                Column(Modifier.heightIn(max = 360.dp)) {
                    BasicText(
                        text = LogFormat.line(rec, Diag.timeZone()),
                        style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 10.sp),
                    )
                }
            },
            buttons = {
                cancel(
                    onClick = { detail = null },
                    title = { CupertinoText(stringResource(Res.string.log_close)) },
                )
            },
        )
    }
}

@Composable
private fun LogSwitch(label: String, checked: Boolean, onChange: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        CupertinoSwitch(checked = checked, onCheckedChange = onChange)
        Spacer(Modifier.width(8.dp))
        CupertinoText(label, fontSize = 13.sp, modifier = Modifier.weight(1f))
    }
}

/** One record: the fixed columns in accent colour, then the message. */
@Composable
private fun LogLine(rec: LogRecord, onClick: () -> Unit) {
    val color = when (rec.level) {
        LogLevel.ERROR -> CupertinoColors.systemRed
        LogLevel.WARN -> CupertinoColors.systemOrange
        LogLevel.TRACE -> CupertinoTheme.colorScheme.tertiaryLabel
        LogLevel.DEBUG -> CupertinoTheme.colorScheme.secondaryLabel
        LogLevel.INFO -> Color.Unspecified
    }
    Column(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 2.dp),
    ) {
        BasicText(
            text = LogFormat.line(rec, Diag.timeZone()),
            style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 10.sp, color = color),
            maxLines = 4,
        )
    }
}
