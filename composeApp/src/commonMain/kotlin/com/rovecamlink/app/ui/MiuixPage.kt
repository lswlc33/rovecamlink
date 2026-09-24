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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalHapticFeedback
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
import com.rovecamlink.app.action_more
import com.rovecamlink.app.not_connected_note
import com.rovecamlink.app.not_connected_title
import com.rovecamlink.app.pill_busy
import com.rovecamlink.app.pill_connected
import com.rovecamlink.app.pill_error
import com.rovecamlink.app.pill_offline
import com.rovecamlink.app.resolve
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.blur.BlendColorEntry
import top.yukonga.miuix.kmp.blur.BlurDefaults
import top.yukonga.miuix.kmp.blur.LayerBackdrop
import top.yukonga.miuix.kmp.blur.isRuntimeShaderSupported
import top.yukonga.miuix.kmp.blur.layerBackdrop
import top.yukonga.miuix.kmp.blur.rememberLayerBackdrop
import top.yukonga.miuix.kmp.blur.textureBlur
import top.yukonga.miuix.kmp.basic.BasicComponent
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.DropdownEntry
import top.yukonga.miuix.kmp.basic.DropdownImpl
import top.yukonga.miuix.kmp.basic.DropdownItem
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.InfiniteProgressIndicator
import top.yukonga.miuix.kmp.basic.ListPopupColumn
import top.yukonga.miuix.kmp.basic.MiuixScrollBehavior
import top.yukonga.miuix.kmp.basic.PopupPositionProvider
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
import top.yukonga.miuix.kmp.icon.extended.More
import top.yukonga.miuix.kmp.icon.extended.Report
import top.yukonga.miuix.kmp.icon.extended.ScreenMirroring
import top.yukonga.miuix.kmp.menu.OverlayIconDropdownMenu
import top.yukonga.miuix.kmp.overlay.OverlayDialog
import top.yukonga.miuix.kmp.overlay.OverlayListPopup
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.utils.overScrollVertical

/**
 * One entry in a page's top-bar 「更多」 menu.
 *
 * The bar has room for exactly one trailing icon, so every per-page action — 自动跟随 on
 * the live page, 筛选/排序 on the files page, 日志设置 on settings — rides inside a single
 * dropdown behind the ⋯ button rather than fighting for space in the bar itself. The
 * app-wide 「查看日志」 is prepended by [AppBarActions], so a page only lists what is its
 * own.
 *
 * [checked] draws the selected indicator; leave it false for a plain action row.
 */
data class AppBarMenuItem(
    val label: String,
    val checked: Boolean = false,
    val enabled: Boolean = true,
    val onClick: () -> Unit,
)

/**
 * One icon in a page's top bar, next to the ⋯ button.
 *
 * The bar used to give every per-page action exactly one home — the overflow — on the
 * reading that it "has room for exactly one trailing icon". The 2026-09-24 files-page
 * request showed that reading was too strict: 筛选 and 排序 are not occasional commands
 * but the two controls a card of hundreds of clips is *read through*, and burying each
 * behind a tap into a menu that also holds 删除全部 made the common path the long one.
 *
 * [checked] tints the icon so a bar icon doubles as its own state readout, the way the
 * menu rows already do. Icons still have to be few — past three the title runs out of
 * room on a 360dp phone — and any action that is a *verb on data* rather than a way of
 * looking at it still belongs in the overflow.
 *
 * [dropdown] is the choice list this icon opens, if it opens one. When present the icon is
 * not a button at all: it is the anchor of a miuix [OverlayIconDropdownMenu], which owns the
 * open state and closes itself on a pick. Both halves of the files page's bar work this way,
 * so neither needs a flag in the screen — and the icon can never be left showing "open" after
 * the menu has closed. An icon with neither [dropdown] nor [onClick] is inert.
 */
data class AppBarIcon(
    val icon: ImageVector,
    val contentDescription: String,
    val checked: Boolean = false,
    val dropdown: DropdownSpec? = null,
    val onClick: (() -> Unit)? = null,
)

/**
 * The choice list behind an [AppBarIcon], as one or more groups.
 *
 * Groups are drawn with a divider between them, which is how a menu states that it asks two
 * questions — 排序 picks a key *and* a direction, and one flat list of four would read as four
 * alternatives to one question. A single-group dropdown is the common case.
 *
 * [DropdownGroup.selected] is the index of the ticked row within that group. [stayOpen] leaves
 * the menu up after a pick, for a menu whose groups are answered independently; otherwise it
 * closes, which is what a one-question menu should do.
 */
data class DropdownSpec(
    val groups: List<DropdownGroup>,
    val stayOpen: Boolean = false,
)

/** One group of choices inside a [DropdownSpec]. */
data class DropdownGroup(
    val items: List<String>,
    val selected: Int,
    val onSelected: (Int) -> Unit,
)

/** Horizontal inset of a section's card from the page edge. */
private val CardInset = 12.dp

/**
 * Columns in a gallery grid.
 *
 * Three is the album convention and the count that keeps a thumbnail big enough to
 * recognise: on a 360dp phone each cell is ~112dp, so a 4:3 photo cover-cropped to a
 * square still reads as the shot it is. Four would fit a third more clips per screen and
 * make every one of them a stamp.
 */
internal const val GalleryColumns = 3

/** The gap one section leaves before the next; the demo puts it under the card, never above. */
private val SectionGap = 12.dp

/** The blur radius the miuix demo blurs its bars with. */
private const val BarBlurRadius = 25f

/**
 * The layer a bar samples, or null on a device that cannot blur at all.
 *
 * `textureBlur` is a `RuntimeShader` (API 33), which is why miuix-blur's Android artifact
 * declares minSdk 32 while this app ships to 24 — see the `uses-sdk` override in
 * androidMain/AndroidManifest.xml. The library exposes this gate for exactly that case, and
 * the miuix demo uses it the same way: no shader, no blur, and the bars keep the flat colour
 * they have always had.
 *
 * The surface colour is painted under the recorded content so the blur samples the bar's own
 * tint wherever the page behind it is transparent, which is the demo's own recipe.
 */
@Composable
fun rememberBarBackdrop(): LayerBackdrop? {
    if (!isRuntimeShaderSupported()) return null
    val surface = MiuixTheme.colorScheme.surface
    return rememberLayerBackdrop {
        drawRect(surface)
        drawContent()
    }
}

/**
 * Puts [backdrop] on the content a bar samples. Both bars sit *over* the content — miuix's
 * `Scaffold` places the body at the window origin and the bars on top of it — so the rows that
 * scroll under them are exactly what the blur reads.
 */
fun Modifier.sampleBackdrop(backdrop: LayerBackdrop?): Modifier =
    if (backdrop == null) this else layerBackdrop(backdrop)

/**
 * Makes a bar translucent enough to see the content behind it, blurred. A null [backdrop] — an
 * old device — returns the modifier untouched, so the bar stays a solid plate.
 */
@Composable
fun Modifier.barBlur(backdrop: LayerBackdrop?): Modifier {
    if (backdrop == null) return this
    val surface = MiuixTheme.colorScheme.surface
    return textureBlur(
        backdrop = backdrop,
        shape = RectangleShape,
        blurRadius = BarBlurRadius,
        colors = BlurDefaults.blurColors(
            blendColors = listOf(BlendColorEntry(surface.copy(alpha = 0.8f))),
        ),
    )
}

/** The colour a bar paints when it cannot blur: its own surface, as before. */
@Composable
fun barColor(backdrop: LayerBackdrop?): Color =
    if (backdrop == null) MiuixTheme.colorScheme.surface else Color.Transparent

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
    menuItems: List<AppBarMenuItem> = emptyList(),
    appBarIcons: List<AppBarIcon> = emptyList(),
    actions: @Composable RowScope.() -> Unit = { AppBarActions(state, menuItems, appBarIcons) },
    bottomContent: (@Composable () -> Unit)? = null,
    header: (@Composable () -> Unit)? = null,
    floating: @Composable BoxScope.() -> Unit = {},
    listBottomInset: Dp = 0.dp,
    listState: LazyListState = rememberLazyListState(),
    gridCells: (LazyGridScope.() -> Unit)? = null,
    content: LazyListScope.() -> Unit,
) {
    // The bar always collapses. It used to stop doing so whenever a [header] was pinned,
    // which left the live page's 「实时」 title and its 40dp-plus line of vertical air
    // permanently on screen — the 2026-09-24 report asked for it back. The header below
    // follows the bar up (it is padded by the bar's *current* height) but is laid out
    // outside the list, so it can never scroll away: 收起顶栏可以，图传不能跟着走。
    val scrollBehavior = MiuixScrollBehavior()
    // The bar has exactly one documented slot for a textual status — `subtitle` — and
    // `actions` is for icons, so the connection state reads as the bar's second line
    // instead of as a chip bolted on beside the menu button.
    val (statusLabel, statusColor) = connectionStatus(state)
    // The bar floats over the list rather than pushing it down — miuix's `Scaffold` places the
    // body at the window origin and the bar on top — so the rows scrolling under it are what
    // the blur reads. On a device without the shader [backdrop] is null and the bar goes back
    // to being the solid plate it always was.
    val backdrop = rememberBarBackdrop()
    // Both containers are remembered unconditionally. Creating the one that is not in
    // use costs an empty state object, and it is what lets the files page flip between
    // the list and the gallery without either losing its scroll position — a grid state
    // made inside the `else` branch would be recreated on every style switch.
    val gridState = rememberLazyGridState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = title,
                subtitle = subtitle ?: statusLabel,
                subtitleColor = subtitleColor
                    ?: if (subtitle == null) statusColor else MiuixTheme.colorScheme.onSurfaceVariantSummary,
                color = barColor(backdrop),
                modifier = Modifier.barBlur(backdrop),
                scrollBehavior = scrollBehavior,
                navigationIcon = navigationIcon,
                actions = actions,
                bottomContent = bottomContent ?: {},
            )
        },
    ) { innerPadding ->
        val barHeight = innerPadding.calculateTopPadding()
        val room = outerPadding.calculateBottomPadding() + listBottomInset
        // A page whose bar carries [bottomContent] — the settings tabs are the only one —
        // has that block sitting on the list's first row unless the list starts below it.
        // The bar's own height already covers the block; the gap is the rhythm the rest of
        // the page keeps, so the first card does not read as attached to the tabs.
        val underBar = if (bottomContent == null) 0.dp else SectionGap
        val contentPadding = PaddingValues(
            top = if (header == null) barHeight + underBar else 0.dp,
            bottom = room,
        )
        val listModifier = Modifier
            .overScrollVertical()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxHeight()
            // Width as well as height. A LazyColumn with no width constraint sizes itself to
            // its *widest item*, so a page whose rows all fill the width was fine while a
            // page holding only an empty state was not: the list came out 319px wide on a
            // 500px screen and everything centred inside it landed at x≈158 instead of 250.
            // That is what 「未连接界面没有居中」 turned out to mean (2026-09-24 emulator
            // pass) — the block was centred, in a list that was not full width.
            .fillMaxWidth()
        val list: @Composable () -> Unit = {
            Box(Modifier.fillMaxSize()) {
                // Two containers, one at a time. A grid is not a LazyColumn with wider
                // items — a LazyListScope cannot express a cross-axis span — so the
                // files page hands over a whole LazyGridScope when it wants the album
                // arrangement. Both branches share the padding and the width fix below,
                // so a page's first row sits at the same pixel either way; the scroll
                // bar goes with whichever one is on, since only it knows its extent.
                val cells = gridCells
                if (cells == null) {
                    LazyColumn(
                        state = listState,
                        contentPadding = contentPadding,
                        modifier = listModifier,
                    ) {
                        content()
                    }
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(GalleryColumns),
                        state = gridState,
                        contentPadding = contentPadding,
                        modifier = listModifier,
                    ) {
                        cells()
                    }
                }
                VerticalScrollBar(
                    adapter = if (cells == null) {
                        rememberScrollBarAdapter(listState)
                    } else {
                        rememberScrollBarAdapter(gridState)
                    },
                    modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                    trackPadding = contentPadding,
                )
            }
        }
        Box(Modifier.fillMaxSize().sampleBackdrop(backdrop)) {
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
 *
 * [card] is false only for a block that is a single action. A card is what makes a group of
 * *rows* read as one control surface; wrapped around one lone button it is a border with
 * nothing to group, and the 2026-09-24 report called it out (「只有按钮一个的时候，按钮还包了
 * 一个边」). The un-carded branch keeps the card's own insets, so the button lands on
 * exactly the same pixels it did inside it.
 */
fun LazyListScope.section(
    title: String? = null,
    card: Boolean = true,
    content: @Composable ColumnScope.() -> Unit,
) {
    item {
        if (title != null) SmallTitle(title)
        val modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = CardInset)
            .padding(bottom = SectionGap)
        if (card) {
            Card(modifier) { content() }
        } else {
            Column(modifier) { content() }
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
    val haptics = LocalHapticFeedback.current
    BasicComponent(
        enabled = enabled,
        onClick = onClick?.let { action ->
            {
                haptics.tap()
                action()
            }
        },
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
    val haptics = LocalHapticFeedback.current
    Button(
        onClick = {
            haptics.tap()
            onClick()
        },
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
    val haptics = LocalHapticFeedback.current
    Button(
        onClick = {
            haptics.tap()
            onClick()
        },
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
        // `fillMaxWidth` is what centres this. Without it the box wraps its own content —
        // and a box that is exactly as wide as the icon and the two lines puts their centre
        // at half *that* width, which on a 500px screen landed the whole block at x≈158
        // instead of 250. That was 「未连接界面没有居中」: the block was centred, in a box
        // that was not the width of the screen (2026-09-24 emulator pass).
        Box(
            Modifier.fillMaxWidth().fillParentMaxHeight().padding(24.dp),
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
 * The bar's trailing controls: the app-wide diagnostics switch, any per-page icons the
 * page asked for, and — when it supplies menu rows — a 「更多」 overflow behind a ⋯ button.
 *
 * Diagnostics has to be one tap away from wherever you are: that is where the failure
 * you want to report just happened. On a page with no icons of its own it is the bar's
 * single trailing control, and the same button puts it away again — so the page never has
 * to be re-found after a screen change. A page that *does* carry icons ([appBarIcons],
 * the files page's 筛选/排序/样式) keeps that toggle in its overflow instead, because a
 * row of four icons would push the title off a 360dp bar.
 *
 * The overflow is miuix's own [OverlayListPopup] + [ListPopupColumn] + [DropdownImpl],
 * anchored to the ⋯ button — the same three pieces the library's own
 * `OverlayDropdownPopup` is built from. 0.9.4 ships no one-call `IconDropdownMenu`, so the
 * three are assembled here rather than reached for.
 *
 * `actions` is the library's icon slot and nothing else, so the connection state is not
 * a chip here — it is the bar's second line. See [connectionStatus].
 */
@Composable
fun RowScope.AppBarActions(
    state: AppState,
    menuItems: List<AppBarMenuItem> = emptyList(),
    appBarIcons: List<AppBarIcon> = emptyList(),
) {
    val haptics = LocalHapticFeedback.current
    val diagnosticsIcon = AppBarIcon(
        icon = MiuixIcons.ListView,
        contentDescription = stringResource(Res.string.action_diagnostics),
        checked = state.diagnosticsOpen,
    ) {
        if (state.diagnosticsOpen) state.closeDiagnostics() else state.openDiagnostics()
    }
    // With icons on the bar, diagnostics moves into the overflow so there is room for them;
    // the label is the same row the menu-driven pages already show.
    val icons = if (appBarIcons.isEmpty()) emptyList() else appBarIcons
    val rows = if (appBarIcons.isEmpty()) {
        menuItems
    } else {
        menuItems + AppBarMenuItem(
            label = stringResource(Res.string.action_diagnostics),
            checked = state.diagnosticsOpen,
        ) { state.openDiagnostics() }
    }
    icons.forEach { entry ->
        val dropdown = entry.dropdown
        if (dropdown != null) {
            // The library anchors and toggles the popup itself, so there is no local `expanded`
            // to get out of step with it.
            OverlayIconDropdownMenu(
                entries = dropdown.groups.map { group ->
                    DropdownEntry(
                        items = group.items.mapIndexed { index, label ->
                            DropdownItem(
                                text = label,
                                selected = index == group.selected,
                                onClick = {
                                    haptics.tick()
                                    group.onSelected(index)
                                },
                            )
                        },
                    )
                },
                collapseOnSelection = !dropdown.stayOpen,
            ) {
                Icon(
                    entry.icon,
                    contentDescription = entry.contentDescription,
                    tint = if (entry.checked) {
                        MiuixTheme.colorScheme.primary
                    } else {
                        MiuixTheme.colorScheme.onBackground
                    },
                )
            }
        } else {
            val onClick = entry.onClick ?: return@forEach
            IconButton(
                onClick = {
                    haptics.tap()
                    onClick()
                },
            ) {
                Icon(
                    entry.icon,
                    contentDescription = entry.contentDescription,
                    tint = if (entry.checked) {
                        MiuixTheme.colorScheme.primary
                    } else {
                        MiuixTheme.colorScheme.onBackground
                    },
                )
            }
        }
    }
    if (rows.isNotEmpty()) {
        var expanded by remember { mutableStateOf(false) }
        Box {
            IconButton(
                onClick = {
                    haptics.tap()
                    expanded = true
                },
            ) {
                Icon(
                    MiuixIcons.More,
                    contentDescription = stringResource(Res.string.action_more),
                    tint = MiuixTheme.colorScheme.onBackground,
                )
            }
            OverlayListPopup(
                show = expanded,
                alignment = PopupPositionProvider.Align.End,
                onDismissRequest = { expanded = false },
            ) {
                ListPopupColumn {
                    rows.forEachIndexed { index, entry ->
                        DropdownImpl(
                            item = DropdownItem(text = entry.label, enabled = entry.enabled),
                            optionSize = rows.size,
                            isSelected = entry.checked,
                            index = index,
                            enabled = entry.enabled,
                            onSelectedIndexChange = {
                                haptics.tap()
                                expanded = false
                                entry.onClick()
                            },
                        )
                    }
                }
            }
        }
    } else if (appBarIcons.isEmpty()) {
        // No rows and no icons: diagnostics *is* the bar, and one tap both opens and closes
        // it. Checked above rather than below so the icon's tint reflects [state.diagnosticsOpen].
        diagnosticsIcon.onClick?.let { toggle ->
            IconButton(
                onClick = {
                    haptics.tap()
                    toggle()
                },
            ) {
                Icon(
                    diagnosticsIcon.icon,
                    contentDescription = diagnosticsIcon.contentDescription,
                    tint = if (diagnosticsIcon.checked) {
                        MiuixTheme.colorScheme.primary
                    } else {
                        MiuixTheme.colorScheme.onBackground
                    },
                )
            }
        }
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
    // The two halves of a confirmation are deliberately different to the touch: the one
    // that acts gets [confirm], the way out gets an ordinary tap. A box that buzzes the
    // same either way would be a coin toss you cannot feel.
    val haptics = LocalHapticFeedback.current
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
                onClick = {
                    haptics.tap()
                    onDismiss()
                },
                modifier = Modifier.weight(1f),
            )
            Spacer(Modifier.width(20.dp))
            TextButton(
                text = confirmLabel,
                onClick = {
                    haptics.confirm()
                    onConfirm()
                },
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
    val haptics = LocalHapticFeedback.current
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
                .clickable {
                    haptics.tap()
                    onDismiss()
                }
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
