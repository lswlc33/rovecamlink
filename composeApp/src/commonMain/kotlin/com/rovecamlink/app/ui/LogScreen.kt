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
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogLevel
import com.rovecamlink.app.core.log.LogRecord
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.createLogStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch

/**
 * Live diagnostic log: the in-app preview of what [Diag] is recording, plus the
 * two exits a support request needs (share a TXT / save a TXT).
 *
 * TODO(i18n): strings are hardcoded English on purpose — this is a developer tool
 * whose output is a log file, and new resource keys still do not resolve from this
 * package (see docs and the note in Screens.kt).
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

    fun export(share: Boolean) {
        if (busy != null) return
        scope.launch(NonCancellable) {
            // NonCancellable: this coroutine belongs to the screen, and closing the
            // preview mid-export would otherwise discard the bundle it just built.
            busy = if (share) "Preparing…" else "Saving…"
            try {
                Diag.awaitDrained()
                val text = Diag.exportBundle()
                val name = Diag.exportName()
                val outcome = if (share) {
                    if (store.share(name, text)) "shared $name (${LogFormat.size(text.length.toLong())})"
                    else "share sheet unavailable — use Save TXT"
                } else {
                    store.save(name, text)?.let { "saved to $it" } ?: "save failed (no writable location)"
                }
                note = outcome
                Diag.info(LogTag.LOG, "export ${if (share) "shared" else "saved"}: $outcome")
            } catch (t: Throwable) {
                note = "export failed: ${t.message}"
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
            ) { CupertinoText("Close") }
            Spacer(Modifier.width(10.dp))
            Column(Modifier.weight(1f)) {
                CupertinoText("Diagnostics", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                CupertinoText(
                    text = "$total records · ${records.size} shown",
                    color = CupertinoTheme.colorScheme.secondaryLabel,
                    fontSize = 11.sp,
                )
            }
            if (busy != null) CupertinoActivityIndicator(size = 16.dp)
        }

        // ---------- actions ----------
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
        ) {
            CupertinoButton(
                onClick = { export(share = true) },
                modifier = Modifier.weight(1f),
                enabled = busy == null,
            ) { CupertinoText("Share TXT") }
            CupertinoButton(
                onClick = { export(share = false) },
                modifier = Modifier.weight(1f),
                enabled = busy == null,
                colors = CupertinoButtonDefaults.grayButtonColors(),
            ) { CupertinoText("Save TXT") }
            CupertinoButton(
                onClick = {
                    state.refreshDiagnosticsEnv()
                    Diag.info(LogTag.LOG, "environment snapshot requested")
                    runCatching { Diag.envProvider?.invoke() }
                        .getOrNull()
                        ?.forEach { (k, v) -> Diag.info(LogTag.DEV, "env $k=$LogFormat.field(v, Diag.config.captureSecrets)") }
                },
                enabled = busy == null,
                colors = CupertinoButtonDefaults.grayButtonColors(),
            ) { CupertinoText("Snapshot") }
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
            CupertinoSegmentedControl(
                selectedTabIndex = listOf<LogLevel?>(null, LogLevel.INFO, LogLevel.WARN, LogLevel.ERROR)
                    .indexOf(viewLevel).coerceAtLeast(0),
                modifier = Modifier.weight(1f),
                paddingValues = PaddingValues(0.dp),
            ) {
                listOf<Pair<String, LogLevel?>>(
                    "All" to null, "Info+" to LogLevel.INFO, "Warn+" to LogLevel.WARN, "Error" to LogLevel.ERROR,
                ).forEach { (label, level) ->
                    CupertinoSegmentedControlTab(
                        onClick = { viewLevel = level },
                        isSelected = viewLevel == level,
                    ) { CupertinoText(label, fontSize = 12.sp) }
                }
            }
            Spacer(Modifier.width(8.dp))
            CupertinoSwitch(checked = follow, onCheckedChange = { follow = it })
            Spacer(Modifier.width(4.dp))
            CupertinoText("Follow", fontSize = 12.sp)
        }
        CupertinoTextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { CupertinoText("filter by text, tag or op…", fontSize = 13.sp) },
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
                "Logging settings",
                color = CupertinoTheme.colorScheme.accent,
                fontSize = 13.sp,
                modifier = Modifier.weight(1f),
            )
            CupertinoText(if (showConfig) "Hide" else "Show", fontSize = 11.sp)
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
                    "Recorded level (what the writer keeps at full detail)",
                    color = CupertinoTheme.colorScheme.secondaryLabel,
                    fontSize = 11.sp,
                )
                CupertinoSegmentedControl(
                    selectedTabIndex = LogLevel.entries.indexOf(minLevel),
                    modifier = Modifier.fillMaxWidth(),
                    paddingValues = PaddingValues(0.dp),
                ) {
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
                LogSwitch("Capture request/response bodies", captureBodies) {
                    captureBodies = it
                    Diag.config.captureBodies = it
                    Diag.info(LogTag.LOG, "config bodies=$it")
                }
                LogSwitch("Keep passwords/tokens verbatim", captureSecrets) {
                    captureSecrets = it
                    Diag.config.captureSecrets = it
                    Diag.warn(
                        LogTag.LOG,
                        "config secrets=$it — exported files may contain the camera Wi-Fi password",
                    )
                }
                LogSwitch("Collapse identical repeated exchanges", sampling) {
                    sampling = it
                    Diag.config.sampleSteadyTraffic = it
                    Diag.info(LogTag.LOG, "config sampling=$it")
                }
                LogSwitch("Write the rolling session file", fileSink) {
                    fileSink = it
                    Diag.config.fileSink = it
                    Diag.info(LogTag.LOG, "config file_sink=$it")
                }
                CupertinoText(
                    text = "session file: ${sessionPath ?: Diag.fileSinkError() ?: "opening…"}",
                    color = CupertinoTheme.colorScheme.tertiaryLabel,
                    fontSize = 10.sp,
                    maxLines = 3,
                )
            }
        }

        // ---------- records ----------
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxWidth().weight(1f).background(CupertinoTheme.colorScheme.secondarySystemBackground),
        ) {
            itemsIndexed(records) { _, rec ->
                LogLine(rec) { detail = rec }
            }
            if (records.isEmpty()) {
                item {
                    CupertinoText(
                        text = if (query.isBlank() && viewLevel == null) "No records yet." else "Nothing matches this filter.",
                        color = CupertinoTheme.colorScheme.tertiaryLabel,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }
        }
    }

    detail?.let { rec ->
        CupertinoAlertDialog(
            onDismissRequest = { detail = null },
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
                    title = { CupertinoText("Close") },
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
            .padding(horizontal = 8.dp, vertical = 2.dp),
    ) {
        BasicText(
            text = LogFormat.line(rec, Diag.timeZone()),
            style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 10.sp, color = color),
            maxLines = 4,
        )
    }
}
