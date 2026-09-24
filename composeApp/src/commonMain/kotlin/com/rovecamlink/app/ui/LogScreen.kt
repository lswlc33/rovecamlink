package com.rovecamlink.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_back
import com.rovecamlink.app.action_cancel_short
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogRecord
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.createLogStore
import com.rovecamlink.app.log_action_clear
import com.rovecamlink.app.log_action_save
import com.rovecamlink.app.log_action_share
import com.rovecamlink.app.log_action_snapshot
import com.rovecamlink.app.log_busy_preparing
import com.rovecamlink.app.log_busy_saving
import com.rovecamlink.app.log_clear_confirm
import com.rovecamlink.app.log_close
import com.rovecamlink.app.log_empty
import com.rovecamlink.app.log_export_hint
import com.rovecamlink.app.log_filter_all
import com.rovecamlink.app.log_filter_error
import com.rovecamlink.app.log_filter_info
import com.rovecamlink.app.log_filter_warn
import com.rovecamlink.app.log_no_match
import com.rovecamlink.app.label_note
import com.rovecamlink.app.log_note_export_failed
import com.rovecamlink.app.log_note_save_failed
import com.rovecamlink.app.log_note_saved
import com.rovecamlink.app.log_note_share_unavailable
import com.rovecamlink.app.log_note_shared
import com.rovecamlink.app.log_records_summary
import com.rovecamlink.app.log_title
import com.rovecamlink.app.menu_log_settings
// Every generated top-level extension lives in `com.rovecamlink.app` and MUST be
// imported by name — that, not any real resource-lookup bug, is what made earlier
// attempts here fail to resolve. (docs/06 and the old note in Screens.kt blamed the
// resolver; ConnectScreen proves ~40 of these resolve fine once imported.)
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.BasicComponent
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.HorizontalDivider
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.TabRow
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.overlay.OverlayDialog
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * Live diagnostic log: the in-app preview of what [Diag] is recording, plus the exits a
 * support request needs.
 *
 * This is one of the app's pushed pages — its own bar carries a 返回 arrow (not the
 * connection chip a tab carries) and a 「更多」 overflow whose one entry opens the
 * separate [LogSettingsScreen]. The 2026-09-23 redesign stripped three things off this
 * page: the free-text search box, and the two 仅本次 export buttons. What is left is the
 * level filter, the two whole-history export buttons, an environment snapshot, and the
 * record tail — the page is here to be read and exported, and the knobs that shape *what*
 * gets recorded moved to their own page so they stop competing with the log for the
 * screen.
 *
 * The primary Share/Save export *every* persisted run ([Diag.exportFullBundle], replayed
 * off disk), because that is what survives a crash — the previous runs are the reason a
 * user files a report.
 *
 * Labels are localised through [Res.string]; the *records themselves* stay as the on-disk
 * `rovdiag/1` grammar — they are a developer artifact and are grepped.
 */
@Composable
fun LogScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val store = remember { createLogStore() }
    val scope = rememberCoroutineScope()

    var records by remember { mutableStateOf<List<LogRecord>>(emptyList()) }
    var total by remember { mutableStateOf(0) }
    var viewLevel by remember { mutableStateOf<LogLevel?>(null) }
    var follow by remember { mutableStateOf(true) }
    var detail by remember { mutableStateOf<LogRecord?>(null) }
    var busy by remember { mutableStateOf<String?>(null) }
    var note by remember { mutableStateOf<String?>(null) }
    var clearRequested by remember { mutableStateOf(false) }

    // Polling (rather than a flow) keeps the preview honest about records that were
    // demoted to TRACE by sampling: every tick re-reads the writer's buffer.
    LaunchedEffect(viewLevel) {
        while (true) {
            records = Diag.tail(1_200, viewLevel, null)
            total = Diag.count()
            delay(400)
        }
    }

    val listState = rememberLazyListState()
    // Keyed on the newest sequence number, not on `records.size`: the tail is capped,
    // so the size stops changing after a couple of minutes of polling while the
    // content keeps moving.
    LaunchedEffect(follow, records.lastOrNull()?.seq) {
        val last = listState.layoutInfo.totalItemsCount - 1
        if (follow && last >= 0) listState.scrollToItem(last)
    }

    // Whole-history export only now — the 仅本次 pair is gone.
    fun export(share: Boolean) {
        if (busy != null) return
        scope.launch {
            withContext(Dispatchers.Default + NonCancellable) {
                // NonCancellable: this coroutine belongs to the screen, and closing the
                // preview mid-export would otherwise discard the bundle it just built.
                busy = getString(if (share) Res.string.log_busy_preparing else Res.string.log_busy_saving)
                try {
                    Diag.awaitDrained()
                    val text = Diag.exportFullBundle()
                    val name = Diag.exportFullName()
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
    }

    val scheme = MiuixTheme.colorScheme
    val haptics = LocalHapticFeedback.current
    val exportable = busy == null
    val levelTabs = listOf(
        stringResource(Res.string.log_filter_all) to null,
        stringResource(Res.string.log_filter_info) to LogLevel.INFO,
        stringResource(Res.string.log_filter_warn) to LogLevel.WARN,
        stringResource(Res.string.log_filter_error) to LogLevel.ERROR,
    )
    val logSettingsLbl = stringResource(Res.string.menu_log_settings)

    MiuixPage(
        title = stringResource(Res.string.log_title),
        subtitle = stringResource(Res.string.log_records_summary, total, records.size),
        outerPadding = outerPadding,
        state = state,
        // No diagnostics switch: this *is* the log. The switch used to sit here reading as
        // "already on" — its state is "is a pushed page showing", and on this page one is.
        showDiagnostics = false,
        // A pushed page: the leading control goes back to whatever pushed this page.
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
        // The overflow carries the page-level actions: save this history to a file (the
        // same action the button row below offers, reachable without scrolling), clear all
        // records, and 日志设置, which opens the separate page.
        menuItems = listOf(
            AppBarMenuItem(label = stringResource(Res.string.log_action_save)) { export(share = false) },
            AppBarMenuItem(label = stringResource(Res.string.log_action_clear)) { clearRequested = true },
            AppBarMenuItem(label = logSettingsLbl) { state.pushPage(com.rovecamlink.app.Page.LogSettings) },
        ),
        header = {
            Column(Modifier.fillMaxWidth().padding(horizontal = 12.dp)) {
                // A standard `TabRow` is a sibling of the card, not a child of it: it
                // sizes itself from its own min/max tab widths and scrolls.
                TabRow(
                    tabs = levelTabs.map { it.first },
                    selectedTabIndex = levelTabs.map { it.second }.indexOf(viewLevel).coerceAtLeast(0),
                    onTabSelected = {
                        if (levelTabs[it].second != viewLevel) haptics.tick()
                        viewLevel = levelTabs[it].second
                    },
                    modifier = Modifier.padding(top = 4.dp, bottom = 8.dp),
                )
            }
        },
        listState = listState,
    ) {
        // A button row sits where a card would, inset by the same 12dp — the demo never
        // wraps one in a card. The two whole-history actions are buttons with one primary
        // among them.
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                LogButton(stringResource(Res.string.log_action_share), enabled = exportable, primary = true) {
                    export(share = true)
                }
                LogButton(stringResource(Res.string.log_action_save), enabled = exportable) {
                    export(share = false)
                }
                LogButton(stringResource(Res.string.log_action_snapshot), enabled = exportable) {
                    state.refreshDiagnosticsEnv()
                    Diag.info(LogTag.LOG, "environment snapshot requested")
                    runCatching { Diag.envProvider?.invoke() }
                        .getOrNull()
                        ?.forEach { (k, v) ->
                            Diag.info(
                                LogTag.DEV,
                                "env $k=${LogFormat.field(v, Diag.config.captureSecrets)}",
                            )
                        }
                }
            }
        }
        item {
            Text(
                text = stringResource(Res.string.log_export_hint),
                fontSize = 13.sp,
                color = scheme.onSurfaceVariantSummary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp, vertical = 10.dp),
            )
        }
        if (busy != null || note != null) {
            section {
                if (busy != null) {
                    BasicComponent {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            InfiniteProgressIndicator(
                                color = scheme.primary,
                                size = 15.dp,
                                strokeWidth = 2.dp,
                                orbitingDotSize = 2.5.dp,
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(busy!!, fontSize = 12.sp, color = scheme.onSurfaceVariantSummary)
                        }
                    }
                }
                note?.let { infoRow(stringResource(Res.string.label_note), it) }
            }
        }

        // The records are the library's other documented list shape — rows outside a
        // card, separated by `HorizontalDivider` — because the tail can be 1 200 lines
        // long and one card holding them all would compose every one of them. Inset by
        // the card's own 12dp so the block lines up with the sections above it.
        // Keyed by the record's own sequence number: the tail is re-read as it grows, and
        // index keys would let a new line steal the previous row's state and force every
        // row below it to recompose.
        itemsIndexed(records, key = { _, rec -> rec.seq }) { index, rec ->
            Column(Modifier.fillMaxWidth().padding(horizontal = 12.dp)) {
                if (index > 0) HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                LogLine(rec) { detail = rec }
            }
        }
        if (records.isEmpty()) {
            item {
                Text(
                    text = stringResource(
                        if (viewLevel == null) Res.string.log_empty else Res.string.log_no_match,
                    ),
                    color = scheme.onSurfaceVariantSummary,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                )
            }
        }
    }

    detail?.let { rec ->
        OverlayDialog(
            show = true,
            // The dialog title is the record's own identifiers (seq/level/tag) — part of
            // the log grammar, deliberately not translated.
            title = "#${rec.seq} ${rec.level.name} ${rec.tag.id}",
            summary = LogFormat.line(rec, Diag.timeZone()),
            summaryColor = scheme.onSurfaceVariantSummary,
            onDismissRequest = { detail = null },
        ) {
            Box(Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                Button(
                    onClick = { detail = null },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColorsPrimary(),
                ) {
                    Text(stringResource(Res.string.log_close))
                }
            }
        }
    }

    if (clearRequested) {
        OverlayDialog(
            show = true,
            title = stringResource(Res.string.log_action_clear),
            summary = stringResource(Res.string.log_clear_confirm),
            onDismissRequest = { clearRequested = false },
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Button(onClick = { clearRequested = false }, modifier = Modifier.weight(1f)) {
                    Text(stringResource(Res.string.action_cancel_short))
                }
                // Red, like the settings page's other irreversible actions: this drops the
                // records a support request would otherwise have been built from.
                Button(
                    onClick = {
                        clearRequested = false
                        scope.launch { Diag.clear() }
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        color = MiuixTheme.colorScheme.error,
                        contentColor = MiuixTheme.colorScheme.onError,
                    ),
                ) {
                    Text(stringResource(Res.string.log_action_clear))
                }
            }
        }
    }
}

/** One of the export actions: equal width, one line each. */
@Composable
private fun RowScope.LogButton(
    label: String,
    enabled: Boolean = true,
    primary: Boolean = false,
    onClick: () -> Unit,
) {
    val haptics = LocalHapticFeedback.current
    Button(
        onClick = {
            haptics.tap()
            onClick()
        },
        modifier = Modifier.weight(1f),
        enabled = enabled,
        colors = if (primary) ButtonDefaults.buttonColorsPrimary() else ButtonDefaults.buttonColors(),
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

/** One record: the fixed columns in accent colour, then the message. */
@Composable
private fun LogLine(rec: LogRecord, onClick: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val haptics = LocalHapticFeedback.current
    val color = when (rec.level) {
        LogLevel.ERROR -> scheme.error
        // The library has no warning tone; the tertiary container is the one hue left
        // that is neither "the app working" nor "the app broken", and a WARN line has
        // to be distinguishable from both.
        LogLevel.WARN -> scheme.tertiaryContainer
        LogLevel.TRACE -> scheme.disabledOnSurface
        LogLevel.DEBUG -> scheme.onSurfaceVariantSummary
        // INFO has to name its colour: `Color.Unspecified` in a `TextStyle` handed to
        // `BasicText` resolves to black, which is invisible on this dark page.
        LogLevel.INFO -> scheme.onSurface
    }
    Column(
        Modifier
            .fillMaxWidth()
            .background(scheme.surface)
            .clickable {
                haptics.tap()
                onClick()
            }
            .padding(horizontal = 14.dp, vertical = 2.dp),
    ) {
        BasicText(
            text = LogFormat.line(rec, Diag.timeZone()),
            style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 10.sp, color = color),
            maxLines = 4,
        )
    }
}
