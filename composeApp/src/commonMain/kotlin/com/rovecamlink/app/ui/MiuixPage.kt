package com.rovecamlink.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.LocalizedString
import com.rovecamlink.app.Phase
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_diagnostics
import com.rovecamlink.app.not_connected_note
import com.rovecamlink.app.not_connected_title
import com.rovecamlink.app.pill_busy
import com.rovecamlink.app.pill_connected
import com.rovecamlink.app.pill_error
import com.rovecamlink.app.pill_offline
import com.rovecamlink.app.resolve
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.BasicComponent
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.MiuixScrollBehavior
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.TextField
import top.yukonga.miuix.kmp.basic.TextButton
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.basic.VerticalScrollBar
import top.yukonga.miuix.kmp.basic.rememberScrollBarAdapter
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.ListView
import top.yukonga.miuix.kmp.icon.extended.Report
import top.yukonga.miuix.kmp.icon.extended.ScreenMirroring
import top.yukonga.miuix.kmp.overlay.OverlayDialog
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.utils.overScrollVertical

/** Horizontal inset of a section's card from the page edge. */
private val CardInset = 12.dp

/** The gap one section leaves before the next; the demo puts it under the card, never above. */
private val SectionGap = 12.dp

/**
 * One page of the app.
 *
 * The upstream demo gives every page its own `Scaffold` and collapsible `TopAppBar`, so
 * the bar carries the *page's* name and scrolling the list collapses it. The shell in
 * `App` keeps only the bottom navigation bar, which is the other half of that split: one
 * list holding every page's rows was the arrangement the 2026-09-22 field report asked
 * to be broken up.
 *
 * [outerPadding] is the shell's padding — its bottom is the navigation bar's height. The
 * page's own bar looks after the top inset.
 */
@Composable
fun MiuixPage(
    title: String,
    outerPadding: PaddingValues,
    state: AppState,
    subtitle: String? = null,
    subtitleColor: Color? = null,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = { AppBarActions(state) },
    bottomContent: @Composable () -> Unit = {},
    header: (@Composable () -> Unit)? = null,
    floating: @Composable BoxScope.() -> Unit = {},
    listBottomInset: Dp = 0.dp,
    listState: LazyListState = rememberLazyListState(),
    content: LazyListScope.() -> Unit,
) {
    // A pinned [header] sits *above* the list rather than over it, so the list is laid out
    // below it and nothing scrolls through the band it occupies — content under a pinned
    // block is content nobody can tap. The bar stops collapsing in that arrangement: a bar
    // that shrank from under a fixed header would walk the header up the screen a few dp
    // per gesture, and the live page's header is a video surface that would have to be
    // measured again each time.
    val scrollBehavior = if (header == null) MiuixScrollBehavior() else null
    // The bar has exactly one documented slot for a textual status — `subtitle` — and
    // `actions` is for icons, so the connection state reads as the bar's second line
    // instead of as a chip bolted on beside the menu button.
    val (statusLabel, statusColor) = connectionStatus(state)
    Scaffold(
        topBar = {
            TopAppBar(
                title = title,
                subtitle = subtitle ?: statusLabel,
                subtitleColor = subtitleColor
                    ?: if (subtitle == null) statusColor else MiuixTheme.colorScheme.onSurfaceVariantSummary,
                scrollBehavior = scrollBehavior,
                navigationIcon = navigationIcon,
                actions = actions,
                bottomContent = bottomContent,
            )
        },
    ) { innerPadding ->
        val barHeight = innerPadding.calculateTopPadding()
        val room = outerPadding.calculateBottomPadding() + listBottomInset
        val contentPadding = PaddingValues(
            top = if (header == null) barHeight else 0.dp,
            bottom = room,
        )
        val listModifier = Modifier
            .overScrollVertical()
            .then(
                if (scrollBehavior == null) {
                    Modifier
                } else {
                    Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
                },
            )
            .fillMaxHeight()
        val list: @Composable () -> Unit = {
            Box(Modifier.fillMaxSize()) {
                LazyColumn(
                    state = listState,
                    contentPadding = contentPadding,
                    modifier = listModifier,
                ) {
                    content()
                }
                VerticalScrollBar(
                    adapter = rememberScrollBarAdapter(listState),
                    modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                    trackPadding = contentPadding,
                )
            }
        }
        Box(Modifier.fillMaxSize()) {
            if (header == null) {
                list()
            } else {
                Column(Modifier.fillMaxSize()) {
                    Box(Modifier.padding(top = barHeight)) { header() }
                    Box(Modifier.weight(1f)) { list() }
                }
            }
            floating()
        }
    }
}

/**
 * A titled block of rows: the demo's `SmallTitle` + `Card` pairing, with the card inset
 * so the title sits further in than the card it names.
 *
 * Replaces the two heading levels this app used to have — a section title *and* a
 * coloured group header inside it. Two headings over one list of settings was one
 * heading too many, and the library only has the one.
 */
fun LazyListScope.section(title: String? = null, content: @Composable ColumnScope.() -> Unit) {
    item {
        if (title != null) SmallTitle(title)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = CardInset)
                .padding(bottom = SectionGap),
        ) {
            content()
        }
    }
}

/**
 * One row of a card.
 *
 * miuix measures the trailing slot first and hands what is left to the label, which is
 * the column break the 2026-09-23 capture wanted: laying the row out here rather than in
 * a bare `Row` is what stops a value reading as the last word of the help text.
 */
@Composable
fun BasicRow(
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    end: (@Composable RowScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    BasicComponent(
        enabled = enabled,
        onClick = onClick,
        endActions = end,
        content = content,
    )
}

/** A label on the left and a read-only value on the right. */
@Composable
fun ColumnScope.valueItem(title: String, value: String, valueColor: Color? = null) {
    BasicRow(
        end = {
            Text(
                text = value,
                color = valueColor ?: MiuixTheme.colorScheme.onSurfaceVariantSummary,
                fontSize = 15.sp,
            )
        },
    ) {
        Text(title, color = MiuixTheme.colorScheme.onBackground, fontSize = 16.sp)
    }
}

/** A muted line of prose inside a card — the library's own rows are title/value pairs. */
@Composable
fun ColumnScope.hintLine(text: String) {
    BasicComponent {
        Text(text, fontSize = 13.sp, color = MiuixTheme.colorScheme.onSurfaceVariantSummary)
    }
}

/** Label above value, so a long message wraps instead of clipping. */
@Composable
fun ColumnScope.infoRow(title: String, value: String) {
    BasicRow {
        Text(
            text = title,
            fontSize = 12.sp,
            color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
        )
        Spacer(Modifier.size(2.dp))
        Text(value, fontSize = 15.sp, color = MiuixTheme.colorScheme.onBackground)
    }
}

/**
 * A value too long for one row: the vendor's release notes arrive as several lines of
 * prose, and [valueItem] right-aligns its value, which turns three sentences into a
 * ragged column against the trailing edge of the screen.
 */
@Composable
fun ColumnScope.textBlockItem(title: String, body: String) {
    BasicRow {
        Text(
            text = title,
            color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
            fontSize = 12.sp,
        )
        Spacer(Modifier.size(4.dp))
        body.split("\n").forEach { line ->
            Text(line, fontSize = 13.sp, color = MiuixTheme.colorScheme.onBackground)
        }
    }
}

/** A row that does something. Spins in place while the work it started is running. */
@Composable
fun ColumnScope.actionRow(
    label: String,
    busy: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = enabled && !busy,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        if (busy) {
            InfiniteProgressIndicator(size = 15.dp, strokeWidth = 2.dp, orbitingDotSize = 2.5.dp)
            Spacer(Modifier.width(8.dp))
        }
        Text(label, fontSize = 16.sp)
    }
}

/**
 * A row of actions, laid out the way the demo lays a button pair out: equal weight, 12dp
 * apart, inset by the card's own 12dp, and *not* inside a card. One of them may carry the
 * primary colour — the row is allowed exactly one.
 */
@Composable
fun RowScope.actionButton(
    label: String,
    busy: Boolean = false,
    enabled: Boolean = true,
    primary: Boolean = false,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = enabled && !busy,
        modifier = Modifier.weight(1f),
        colors = if (primary) ButtonDefaults.buttonColorsPrimary() else ButtonDefaults.buttonColors(),
    ) {
        if (busy) {
            InfiniteProgressIndicator(size = 15.dp, strokeWidth = 2.dp, orbitingDotSize = 2.5.dp)
            Spacer(Modifier.width(8.dp))
        }
        Text(label, fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}

/**
 * A single-line input wearing the library's own field.
 *
 * The wrapper exists so a page can keep its `String` state: [TextField] draws the label
 * as the placeholder when the box is empty, which is what every one of these fields
 * wants, and it brings the fill, the corner radius and the focus ring that a hand-built
 * box did not — a `surfaceVariant` plate is invisible on a card of the same colour.
 */
@Composable
fun MiuixField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = placeholder,
        useLabelAsPlaceholder = placeholder.isNotEmpty(),
        enabled = enabled,
        singleLine = true,
    )
}

/** Thin progress line used by the download rows. */
@Composable
fun ProgressLine(progress: Float) {
    Box(
        Modifier
            .fillMaxWidth()
            .heightIn(min = 4.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(MiuixTheme.colorScheme.surfaceVariant),
    ) {
        Box(
            Modifier
                .fillMaxWidth(progress.coerceIn(0f, 1f))
                .heightIn(min = 4.dp)
                .background(MiuixTheme.colorScheme.primary),
        )
    }
}

/** The app's empty state: nothing is wrong, there is just no camera on the other end. */
fun LazyListScope.notConnectedItem() {
    item {
        Box(
            Modifier.fillParentMaxHeight().padding(24.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Icon(
                    MiuixIcons.ScreenMirroring,
                    contentDescription = null,
                    tint = MiuixTheme.colorScheme.onSurfaceVariantSummary,
                    modifier = Modifier.size(40.dp),
                )
                Text(
                    text = stringResource(Res.string.not_connected_title),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    color = MiuixTheme.colorScheme.onBackground,
                )
                Text(
                    text = stringResource(Res.string.not_connected_note),
                    color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
                    fontSize = 13.sp,
                )
            }
        }
    }
}

/**
 * The diagnostics switch, which every page's bar carries.
 *
 * Diagnostics has to be one tap away from wherever you are: that is where the failure
 * you want to report just happened. One tap also puts it away again — the same button is
 * the close control, so the page never has to be re-found after a screen change.
 *
 * `actions` is the library's icon slot and nothing else, so the connection state is not
 * a chip here — it is the bar's second line. See [connectionStatus].
 */
@Composable
fun RowScope.AppBarActions(state: AppState) {
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
                MiuixTheme.colorScheme.onBackground
            },
        )
    }
}

/**
 * The bar's `subtitle`: what the connection is doing, in the two hues a status line gets.
 *
 * The accent for "connected, or getting there" and the error tone for "it broke", with
 * the summary grey for the idle case. Connected and busy deliberately share a hue — the
 * words differ, and a fourth colour would be a legend to learn.
 */
@Composable
fun connectionStatus(state: AppState): Pair<String, Color> {
    val scheme = MiuixTheme.colorScheme
    val label = stringResource(
        when (state.phase) {
            Phase.Connected -> Res.string.pill_connected
            Phase.Error -> Res.string.pill_error
            Phase.Idle -> Res.string.pill_offline
            else -> Res.string.pill_busy
        },
    )
    val color = when (state.phase) {
        Phase.Connected -> scheme.primary
        Phase.Error -> scheme.error
        Phase.Idle -> scheme.onSurfaceVariantSummary
        else -> scheme.primary
    }
    return label to color
}

/**
 * The app's confirmation box: a title, an explanation, and a cancel/confirm pair.
 *
 * Every irreversible action — formatting a card, flashing firmware, deleting a file —
 * goes through this one, so they read the same and the button that does the damage is
 * always in the same corner.
 */
@Composable
fun ConfirmDialog(
    title: String,
    message: String,
    confirmLabel: String,
    cancelLabel: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    destructive: Boolean = true,
) {
    val scheme = MiuixTheme.colorScheme
    OverlayDialog(
        show = true,
        title = title,
        summary = message,
        onDismissRequest = onDismiss,
    ) {
        // A dialog has no button slot in this library — the documented shape is a pair of
        // `TextButton`s in a SpaceBetween row, the affirmative one carrying the primary
        // text-button colours.
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            TextButton(
                text = cancelLabel,
                onClick = onDismiss,
                modifier = Modifier.weight(1f),
            )
            Spacer(Modifier.width(20.dp))
            TextButton(
                text = confirmLabel,
                onClick = onConfirm,
                modifier = Modifier.weight(1f),
                // Red for the button that deletes something: the library has no
                // destructive pair, and a primary-tinted 「格式化存储卡」 reads as the
                // safe choice.
                colors = if (destructive) {
                    ButtonDefaults.textButtonColors(color = scheme.error, textColor = scheme.onError)
                } else {
                    ButtonDefaults.textButtonColorsPrimary()
                },
            )
        }
    }
}

/** Dismissible error toast pinned to the bottom of the content area. */
@Composable
fun ErrorBanner(msg: LocalizedString, onDismiss: () -> Unit) {
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
