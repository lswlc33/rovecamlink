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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogRecord
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.createLogStore
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
import com.rovecamlink.app.label_note
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
// Every generated top-level extension lives in `com.rovecamlink.app` and MUST be
// imported by name — that, not any real resource-lookup bug, is what made earlier
// attempts here fail to resolve. (docs/06 and the old note in Screens.kt blamed the
// resolver; ConnectScreen proves ~40 of these resolve fine once imported.)
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.BasicComponent
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.TabRow
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.overlay.OverlayDialog
import top.yukonga.miuix.kmp.preference.SwitchPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme

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
 *
 * This is the app's one pushed page: the bar's leading control is a back arrow rather
 * than the connection chip every tab carries, and the filters stay pinned above the log
 * because they are what you reach for *while* reading it. The export buttons scroll with
 * the records — this page exists to be read, and a 1200-line tail leaves no room for a
 * pinned action block.
 */
@Composable
fun LogScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
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

    val scheme = MiuixTheme.colorScheme
    val exportable = busy == null
    val levelTabs = listOf(
        stringResource(Res.string.log_filter_all) to null,
        stringResource(Res.string.log_filter_info) to LogLevel.INFO,
        stringResource(Res.string.log_filter_warn) to LogLevel.WARN,
        stringResource(Res.string.log_filter_error) to LogLevel.ERROR,
    )
    val sessionValue = sessionPath ?: Diag.fileSinkError() ?: stringResource(Res.string.log_session_opening)

    MiuixPage(
        title = stringResource(Res.string.log_title),
        outerPadding = outerPadding,
        state = state,
        // A pushed page: the leading control goes back, and the record count rides in
        // the bar where it stays visible however far down the tail you are.
        navigationIcon = {
            IconButton(onClick = onClose) {
                Icon(
                    MiuixIcons.Back,
                    contentDescription = stringResource(Res.string.log_close),
                    tint = scheme.onSurface,
                )
            }
        },
        header = {
            Column(Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp)) {
                Card(Modifier.fillMaxWidth()) {
                    TabRow(
                        tabs = levelTabs.map { it.first },
                        selectedTabIndex = levelTabs.map { it.second }.indexOf(viewLevel).coerceAtLeast(0),
                        onTabSelected = { viewLevel = levelTabs[it].second },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                    )
                    MiuixField(
                        value = query,
                        onValueChange = { query = it },
                        placeholder = stringResource(Res.string.log_filter_placeholder),
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp),
                    )
                    SwitchPreference(
                        title = stringResource(Res.string.log_follow),
                        summary = stringResource(Res.string.log_records_summary, total, records.size),
                        checked = follow,
                        onCheckedChange = { follow = it },
                    )
                }
            }
        },
        listState = listState,
    ) {
        section {
            Row(
                Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                LogButton(stringResource(Res.string.log_action_share), enabled = exportable, primary = true) {
                    export(share = true, full = true)
                }
                LogButton(stringResource(Res.string.log_action_save), enabled = exportable) {
                    export(share = false, full = true)
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
            hintLine(stringResource(Res.string.log_export_hint))
            Row(
                Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                LogButton(
                    stringResource(Res.string.log_action_share_current),
                    enabled = exportable,
                    small = true,
                ) { export(share = true, full = false) }
                LogButton(
                    stringResource(Res.string.log_action_save_current),
                    enabled = exportable,
                    small = true,
                ) { export(share = false, full = false) }
            }
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

        // No section heading: the switch below carries the block's name, and a
        // SmallTitle saying the same words above it was one heading too many.
        section {
            SwitchPreference(
                title = stringResource(Res.string.log_settings_title),
                summary = stringResource(if (showConfig) Res.string.log_hide else Res.string.log_show),
                checked = showConfig,
                onCheckedChange = { showConfig = it },
            )
            if (showConfig) {
                hintLine(stringResource(Res.string.log_level_hint))
                TabRow(
                    // The segment labels are the level tokens themselves — the file is
                    // keyed on `V D I W E`, so translating them here would break the
                    // preview's correspondence to the exported log.
                    tabs = LogLevel.entries.map { it.name.lowercase().take(4) },
                    selectedTabIndex = LogLevel.entries.indexOf(minLevel),
                    onTabSelected = { index ->
                        val l = LogLevel.entries[index]
                        minLevel = l
                        Diag.config.minLevel = l
                        Diag.info(LogTag.LOG, "config minLevel=${l.name}")
                    },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                )
                SwitchPreference(
                    title = stringResource(Res.string.log_switch_bodies),
                    checked = captureBodies,
                    onCheckedChange = {
                        captureBodies = it
                        Diag.config.captureBodies = it
                        Diag.info(LogTag.LOG, "config bodies=$it")
                    },
                )
                SwitchPreference(
                    title = stringResource(Res.string.log_switch_secrets),
                    checked = captureSecrets,
                    onCheckedChange = {
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
                        sampling = it
                        Diag.config.sampleSteadyTraffic = it
                        Diag.info(LogTag.LOG, "config sampling=$it")
                    },
                )
                SwitchPreference(
                    title = stringResource(Res.string.log_switch_filesink),
                    checked = fileSink,
                    onCheckedChange = {
                        fileSink = it
                        Diag.config.fileSink = it
                        Diag.info(LogTag.LOG, "config file_sink=$it")
                    },
                )
                hintLine(stringResource(Res.string.log_session_file_line, sessionValue))
            }
        }

        // The records themselves, outside a card: this is dense monospace read line by
        // line, and a card's outer inset would only take width away from it. The count
        // above them lives in the pinned switch's summary, so it is not repeated here.
        itemsIndexed(records) { _, rec ->
            LogLine(rec) { detail = rec }
        }
        if (records.isEmpty()) {
            item {
                Text(
                    text = stringResource(
                        if (query.isBlank() && viewLevel == null) Res.string.log_empty else Res.string.log_no_match,
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
}

/** One of the export actions: equal width, one line each, spinner while it runs. */
@Composable
private fun RowScope.LogButton(
    label: String,
    enabled: Boolean = true,
    primary: Boolean = false,
    small: Boolean = false,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.weight(1f),
        enabled = enabled,
        colors = if (primary) ButtonDefaults.buttonColorsPrimary() else ButtonDefaults.buttonColors(),
        minHeight = if (small) 34.dp else 40.dp,
        insideMargin = PaddingValues(horizontal = 8.dp, vertical = if (small) 7.dp else 11.dp),
    ) {
        Text(
            text = label,
            fontSize = if (small) 12.sp else 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

/** One record: the fixed columns in accent colour, then the message. */
@Composable
private fun LogLine(rec: LogRecord, onClick: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val color = when (rec.level) {
        LogLevel.ERROR -> scheme.error
        // The library has no warning tone; the tertiary container is the one hue left
        // that is neither "the app working" nor "the app broken", and a WARN line has
        // to be distinguishable from both.
        LogLevel.WARN -> scheme.tertiaryContainer
        LogLevel.TRACE -> scheme.disabledOnSurface
        LogLevel.DEBUG -> scheme.onSurfaceVariantSummary
        // INFO has to name its colour: `Color.Unspecified` in a `TextStyle` handed to
        // `BasicText` resolves to black, which is invisible on this dark page — the
        // whole tail read as empty while `共 n 条记录` insisted it was there.
        LogLevel.INFO -> scheme.onSurface
    }
    Column(
        Modifier
            .fillMaxWidth()
            .background(scheme.surface)
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 2.dp),
    ) {
        BasicText(
            text = LogFormat.line(rec, Diag.timeZone()),
            style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 10.sp, color = color),
            maxLines = 4,
        )
    }
}
