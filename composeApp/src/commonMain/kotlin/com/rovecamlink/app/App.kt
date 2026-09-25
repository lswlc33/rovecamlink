package com.rovecamlink.app

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.zIndex
import com.rovecamlink.app.ui.AboutScreen
import com.rovecamlink.app.ui.ConfirmDialog
import com.rovecamlink.app.ui.ConnectScreen
import com.rovecamlink.app.ui.ErrorBanner
import com.rovecamlink.app.ui.FilesScreen
import com.rovecamlink.app.ui.LivePreviewScreen
import com.rovecamlink.app.ui.LiveScreen
import com.rovecamlink.app.ui.LiveSettingsScreen
import com.rovecamlink.app.ui.LogScreen
import com.rovecamlink.app.ui.LogSettingsScreen
import com.rovecamlink.app.ui.MediaViewer
import com.rovecamlink.app.ui.NavKey
import com.rovecamlink.app.ui.NavMotion
import com.rovecamlink.app.ui.NavStackState
import com.rovecamlink.app.ui.PermissionsScreen
import com.rovecamlink.app.ui.PlatformBackHandler
import com.rovecamlink.app.ui.PlatformPredictiveBackHandler
import com.rovecamlink.app.ui.SettingsScreen
import com.rovecamlink.app.ui.SupportedDevicesScreen
import com.rovecamlink.app.ui.blockPointerInput
import com.rovecamlink.app.ui.glass.IosLiquidGlassNavigationBar
import com.rovecamlink.app.ui.rememberBarBackdrop
import com.rovecamlink.app.ui.rememberNavStack
import com.rovecamlink.app.ui.rememberPagerNavState
import com.rovecamlink.app.ui.sampleBackdrop
import com.rovecamlink.app.ui.tick
import kotlin.math.roundToInt
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.NavigationItem
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Folder
import top.yukonga.miuix.kmp.icon.extended.ScreenMirroring
import top.yukonga.miuix.kmp.icon.extended.SearchDevice
import top.yukonga.miuix.kmp.icon.extended.Settings
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.utils.PagerNavigationSpringSpec

enum class Tab(val labelRes: StringResource, val icon: ImageVector) {
    Devices(Res.string.tab_devices, MiuixIcons.SearchDevice),
    Live(Res.string.tab_live, MiuixIcons.ScreenMirroring),
    Files(Res.string.tab_files, MiuixIcons.Folder),
    Settings(Res.string.tab_settings, MiuixIcons.Settings),
}

/**
 * How small the bottom bar gets on its way out. It shrinks toward its own bottom edge and slides
 * off, which reads as the bar folding down under the page rather than blinking out of existence.
 */
private const val BAR_MIN_SCALE = 0.82f

/**
 * How far into a page transition the bar sits still before it starts folding.
 *
 * The bar used to be handed the transition's own curve, `1f - NavProgrammaticEasing(progress)`,
 * and that curve is an underdamped spring's step response: it is 48% collapsed at 60 ms and
 * effectively finished by 150 ms of a 300 ms move (2026-09-25 report 「底栏收起动画太快了 导致没法
 * 欣赏到」). Two things were wrong with borrowing it. The page is not a spring — it is a sheet
 * sliding at a fixed speed, and the bar was leaving three times faster than the thing causing it
 * to leave. And a spring curve front-loads *on purpose*: it is meant to be the tail of a motion
 * the finger already started, which is exactly what an arrow tap does not provide.
 *
 * So the bar gets its own timing. [BAR_FOLD_HEAD] is the beat before it responds at all: the page
 * has visibly begun to arrive, and only then does the bar fold — cause first, effect after. The
 * rest is [barFold]'s smoothstep, which is half-collapsed at the halfway point instead of
 * nine-tenths, so the collapse is something the eye can follow all the way down.
 */
private const val BAR_FOLD_HEAD = 0.15f

/**
 * The bar's own collapse fraction for a transition that has played [progress] of its way.
 *
 * Monotone, and pinned at both ends: `barFold(0) == 0` and `barFold(1) == 1`, so the settled
 * states — the ones the bar spends all its time in — are untouched, and only the ride between
 * them changed. Smoothstep (`3t² - 2t³`) rather than a linear ramp because both ends of a bar
 * sliding off should have no velocity: it leaves and arrives rather than snapping into motion.
 * This is also what makes a pop read as the same motion backwards, since the same function is
 * read from 1 down to 0 there.
 */
private fun barFold(progress: Float): Float {
    val local = ((progress - BAR_FOLD_HEAD) / (1f - BAR_FOLD_HEAD)).coerceIn(0f, 1f)
    return local * local * (3f - 2f * local)
}

/**
 * How long the bar takes to fold away for the QR scanner, which is not a page transition and so
 * has no progress of its own to follow.
 *
 * Longer than [NavMotion.DURATION_MS] on purpose: nothing else is moving at that moment. The
 * scanner is a black viewfinder that is simply *there* the instant the entry is tapped, and this
 * fold is the only thing on screen telling the user the bar is getting out of the way — the
 * 2026-09-25 report asked for exactly that animation, so it is worth the extra beat.
 */
private const val BAR_QR_FOLD_MS = 360

/**
 * The shell: a bottom navigation bar and the page stack over four tabs.
 *
 * The bar at the top of the window belongs to the page under it — see `MiuixPage` — so that it can
 * name the page rather than the app and collapse as that page's list moves. The window title still
 * names the app.
 *
 * The stack itself is [NavStackState]: one fraction that both the pages and the bar read. That is
 * what makes a return follow the hand instead of jumping — see the file, and `NavMotion` for where
 * the geometry comes from.
 */
@Composable
fun App(graph: AppGraph = remember { AppGraph() }) {
    val scope = rememberCoroutineScope()
    val state = remember { AppState(graph, scope) }

    // The four pages are a pager, not a `when`: the bar and a left/right swipe both move
    // between them, and `pager` is what keeps those two writers from disagreeing. Hoisted
    // here rather than inside the pager's content so it survives a trip through a pushed
    // page — otherwise coming back from 关于 would land on the first tab again.
    val tabs = Tab.entries
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val pager = rememberPagerNavState(pagerState)
    val haptics = LocalHapticFeedback.current

    // A swipe is the pager's own doing, so the bar has to be told about it; the tap direction
    // goes the other way, through `animateToPage`. Leaving the live tab also drops the
    // full-screen preview: it is that page's own state, and a picture with no bar over a
    // settings list would leave the user with no way back to the tabs.
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            pager.syncPage()
            if (tabs[page] != Tab.Live) state.setFullscreenPreview(false)
        }
    }

    val navInset = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    val nav = rememberNavStack(NavKey(state.topPage, state.pageDepth))
    val navProgress = nav.progress.value
    // What a back gesture previews: the page one level down. The stack is untouched until the
    // gesture commits, so the page being left is still the live one and the revealed layer is the
    // warm one the shell keeps composed beneath it.
    val popTarget = NavKey(state.pageBelowTop, state.pageDepth - 1)

    // --- Going back --------------------------------------------------------------------------
    // Three things can be left by a back gesture, and they are declared in the order they must be
    // offered: the media viewer covers everything, the full-screen picture covers the live page,
    // and a pushed page covers a tab. Android's dispatcher asks the last one that is enabled, and
    // each of the three gets both halves of a back — the fingers-on-screen preview and the plain
    // press (`PredictiveBackHandler` ends in one commit on versions with no progress to report).
    val viewerShown = state.viewer != null
    val viewerReveal = remember { Animatable(1f) }
    // Opened afresh starts whole; only a gesture leaves it part way.
    LaunchedEffect(state.viewer) { if (viewerShown) viewerReveal.snapTo(1f) }
    PlatformPredictiveBackHandler(
        enabled = viewerShown,
        onProgress = { events -> events.collect { viewerReveal.snapTo(it) } },
        onCommit = {
            viewerReveal.animateTo(0f, NavStackState.GESTURE_SETTLE)
            state.closeViewer()
        },
        onCancel = { viewerReveal.animateTo(1f, NavStackState.GESTURE_SETTLE) },
    )

    val previewShown = state.topPage == null && state.previewFullscreen
    // The preview's own fraction is mirrored into `AppState`, because the live page is what draws
    // it and the live page is not where the gesture arrives.
    val previewReveal = remember { Animatable(1f) }
    LaunchedEffect(state.previewFullscreen) {
        if (state.previewFullscreen) {
            previewReveal.snapTo(1f)
            state.previewReveal = 1f
        }
    }
    PlatformPredictiveBackHandler(
        enabled = previewShown,
        onProgress = { events ->
            events.collect { fraction ->
                previewReveal.snapTo(fraction)
                state.previewReveal = fraction
            }
        },
        onCommit = {
            previewReveal.animateTo(0f, NavStackState.GESTURE_SETTLE) { state.previewReveal = value }
            state.setFullscreenPreview(false)
        },
        onCancel = {
            previewReveal.animateTo(1f, NavStackState.GESTURE_SETTLE) { state.previewReveal = value }
        },
    )

    val pageStackShown = state.topPage != null
    PlatformPredictiveBackHandler(
        enabled = pageStackShown,
        onProgress = { events ->
            nav.beginGesture(popTarget)
            events.collect { nav.driveGesture(it) }
        },
        onCommit = {
            state.popPage()
            nav.commitGesture(popTarget)
        },
        onCancel = { nav.cancelGesture() },
    )

    // With nothing pushed, back walks the pager home instead of closing the app — the demo's own
    // behaviour, and the Android convention for a bottom bar: 设置 → 返回 lands on 设备, a second
    // 返回 leaves. There is no overlay to preview here, so this one stays a plain press.
    PlatformBackHandler(
        enabled = !pageStackShown && !previewShown && !viewerShown && pager.selectedPage != 0,
    ) {
        pager.animateToPage(0)
    }

    // How much of the bar is showing: 1 over the tabs, 0 once a pushed page owns the window. A move
    // in flight hands the bar the same fraction the pages are on, so a return brings it back under
    // the finger rather than snapping it in half way through.
    //
    // Read off the nav *frame* and never off `state.topPage`. The stack changes first and the
    // transition starts an effect later, so for one frame the two disagree — and asking the stack
    // there made the bar jump to 0, then back to 1 when the slide actually began, then collapse:
    // the blink the 2026-09-24 report saw on the way into a page (「底栏会闪烁一下，再进行收起」).
    // The frame is what is on screen, so it is what the bar is derived from.
    // The QR scanner is not a page and has no transition of its own, so its fold is a plain
    // animation between two settled values. It has to be a real animation rather than a branch on
    // `state.qrScanOpen` for the *closing* half as much as the opening one: the scanner is gone the
    // frame the flag clears, and a bar that reappeared at full size in that frame would be the
    // same blink this page's other reports are about. See [BAR_QR_FOLD_MS].
    val barQrShown by animateFloatAsState(
        targetValue = if (state.qrScanOpen) 0f else 1f,
        animationSpec = tween(BAR_QR_FOLD_MS, easing = LinearOutSlowInEasing),
        label = "barQrFold",
    )
    val barShown = when {
        // The bar is drawn *over* the page (miuix's Scaffold places the bottom bar after the body),
        // so a collapse animated here would paint it across the very surface it is making room for.
        // The viewer and the preview take the window outright and the bar steps aside at once.
        viewerShown || state.previewFullscreen -> 0f
        // The scanner is checked before the frame branches: it is a mode of the tab underneath it,
        // so a transition can only be starting *below* it, and that transition's progress would
        // otherwise bring the bar back up over a live viewfinder.
        state.qrScanOpen || barQrShown < 1f -> barQrShown
        !nav.frame.moving -> if (nav.frame.to.depth == 0) 1f else 0f
        // The bar keeps the page's direction but not its curve: it is the effect, not the cause.
        nav.frame.forward -> 1f - barFold(navProgress)
        else -> barFold(navProgress)
    }

    // The bar floats over the page — miuix's `Scaffold` places the body at the window origin and
    // the bar on top of it — so what scrolls under it is what the blur reads. On a device with
    // no runtime shader [backdrop] is null and the bar keeps its solid surface.
    val backdrop = rememberBarBackdrop()
    // The bar takes the library's own `NavigationItem` — the same label and icon pair the
    // old `NavigationBarItem` was handed, in the same order.
    val navItems = tabs.map { NavigationItem(label = stringResource(it.labelRes), icon = it.icon) }

    Scaffold(
        containerColor = MiuixTheme.colorScheme.background,
        bottomBar = {
            // Composed even at 0, which is the point: the Scaffold measures this slot to size the
            // content padding every page reads, and a bar that came and went would move every
            // layer's bottom inset in the middle of a transition — the ~90dp jump a list used to
            // take on the frame a page was pushed. `graphicsLayer` moves and shrinks without
            // touching layout, and at 0 the bar sits entirely below the window: unseen, unhittable.
            Box(
                Modifier.graphicsLayer {
                    val shown = barShown
                    val scale = BAR_MIN_SCALE + (1f - BAR_MIN_SCALE) * shown
                    scaleX = scale
                    scaleY = scale
                    // Shrunk toward its own bottom edge and then dropped clear of the window, which
                    // is the 向下缩小收起 the field report asked for.
                    transformOrigin = TransformOrigin(0.5f, 1f)
                    translationY = (1f - shown) * size.height
                    alpha = shown
                },
            ) {
                // The iOS-style glass bar from the miuix demo (vendored under `ui/glass`).
                // It blurs the page behind it itself — that is what `backdrop` is, and why
                // the content above carries `sampleBackdrop` — so it takes no `barBlur`
                // modifier of its own: handing it one would blur the blur. Without the
                // runtime shader `backdrop` is null and it draws the flat capsule the demo
                // falls back to, so a device below API 33 keeps a readable bar.
                IosLiquidGlassNavigationBar(
                    items = navItems,
                    selectedIndex = pager.selectedPage,
                    onItemClick = { index ->
                        if (index != pager.selectedPage || state.topPage != null) haptics.tick()
                        // A pushed page is drawn over the tabs, so without this the
                        // highlight moved and nothing else did — the page stayed.
                        state.popToTabs()
                        pager.animateToPage(index)
                    },
                    backdrop = backdrop,
                    isBlurActive = backdrop != null,
                )
            }
        },
    ) { padding ->
        // A pushed page owns the whole window, so it gets the gesture-bar inset back rather than
        // the bar's measured height — and it keeps it for the whole transition, because the bar no
        // longer changes size when a page arrives. The log is the one that used to show this as a
        // jump: it follows its own tail, so ~90dp of bottom padding appearing at the start of a
        // return moved the line the user was reading.
        val pagePadding = PaddingValues(bottom = navInset)
        Box(Modifier.fillMaxSize().sampleBackdrop(backdrop)) {
            // Every layer the stack is holding. The page under the top one stays composed: that is
            // what makes a return a slide over a page that already exists instead of the first
            // frame of one being built. Upstream keeps every presented entry composed, and its
            // visible window — `-1 < d <= opaqueDepth` — is exactly this: two layers deep.
            val layers = if (nav.frame.moving) {
                listOf(nav.frame.from, nav.frame.to)
            } else {
                buildList {
                    add(nav.frame.to)
                    if (nav.frame.to.depth >= 1) add(NavKey(state.pageBelowTop, nav.frame.to.depth - 1))
                }
            }
            layers.forEach { layer ->
                // Keyed by the layer itself, not by position: a push turns [tab, page] into [page]
                // and a pop the other way round, and without the key the two slots would swap
                // contents instead of keeping theirs.
                key(layer) {
                    val placement = NavMotion.layerPlacement(layer.depth, nav.frame, navProgress)
                    Box(
                        Modifier
                            .fillMaxSize()
                            // Deeper pages draw above shallower ones. On a push that puts the
                            // arriving page on top; on a pop it puts the *leaving* one there, which
                            // is what makes the two read as a stack moving rather than a cross-fade
                            // (caught in the 2026-09-24 emulator capture).
                            .zIndex(layer.depth.toFloat())
                            .graphicsLayer {
                                // Read the width off the layer instead of being handed it, so the
                                // placement only ever has to deal in fractions.
                                val px = placement.fractionX * size.width
                                translationX = if (placement.snapToPixels) {
                                    px.roundToInt().toFloat()
                                } else {
                                    px
                                }
                                alpha = placement.alpha
                            }
                            // A layer that is not the one being arrived at is composed but must not
                            // be reachable: the tab under a pushed page, and the page being left
                            // behind, would otherwise answer taps through whatever covers them.
                            //
                            // "Not the arrival" rather than "covered": during a return the page
                            // being revealed is the one below, and it becomes live the moment it
                            // is on screen — waiting for the animation to finish before it accepts
                            // a touch is what made a back feel like it had to be waited out
                            // (2026-09-24 「动画时要等很久才能操作下个触控动作」).
                            .then(
                                if (layer != nav.frame.to) {
                                    Modifier.blockPointerInput()
                                } else {
                                    Modifier
                                },
                            ),
                    ) {
                        val outer = if (layer.page == null) padding else pagePadding
                        when (layer.page) {
                            Page.Log -> LogScreen(state, outerPadding = outer, onClose = { state.popPage() })
                            Page.LogSettings -> LogSettingsScreen(state, outerPadding = outer, onClose = { state.popPage() })
                            Page.About -> AboutScreen(state, outerPadding = outer, onClose = { state.popPage() })
                            Page.Permissions -> PermissionsScreen(state, outerPadding = outer, onClose = { state.popPage() })
                            Page.SupportedDevices -> SupportedDevicesScreen(state, outerPadding = outer, onClose = { state.popPage() })
                            Page.LiveSettings -> LiveSettingsScreen(state, outerPadding = outer, onClose = { state.popPage() })
                            Page.LivePreview -> LivePreviewScreen(state, outerPadding = outer, onClose = { state.popPage() })
                            null -> HorizontalPager(
                                state = pagerState,
                                // miuix's own snap spring, so a swipe settles with the same feel the
                                // bar's tap does (`springAnimateToPage` uses it too).
                                flingBehavior = PagerDefaults.flingBehavior(
                                    state = pagerState,
                                    snapAnimationSpec = PagerNavigationSpringSpec,
                                ),
                                verticalAlignment = Alignment.Top,
                                key = { tabs[it] },
                            ) { page ->
                                when (tabs[page]) {
                                    // The scanner takes the window while it is up, so the tab hands it
                                    // the same [pagePadding] a pushed page gets: the bar's own height is
                                    // no longer on screen to be avoided (it is folding away as this
                                    // becomes true), and leaving ~90dp of it reserved put the frame and
                                    // the 取消 button in a band above the bottom of the screen.
                                    Tab.Devices -> ConnectScreen(
                                        state,
                                        outerPadding = if (state.qrScanOpen) pagePadding else outer,
                                    )
                                    Tab.Live -> LiveScreen(state, outerPadding = outer)
                                    Tab.Files -> FilesScreen(state, outerPadding = outer)
                                    Tab.Settings -> SettingsScreen(state, outerPadding = outer)
                                }
                            }
                        }
                    }
                }
            }
            state.errorMessage?.let { msg ->
                // Raised by the bar's own height, which is what it was missing: this draws inside
                // the body and the bar is placed after it, so at the window's bottom edge the
                // message was underneath the bar rather than above it.
                ErrorBanner(
                    msg = msg,
                    bottomInset = padding.calculateBottomPadding(),
                ) { state.errorMessage = null }
            }
            // Last in the Box, so the viewer covers the error banner too: it is the one
            // surface that owns the whole window while it is up. The fraction is the gesture's,
            // so a back that is half let go leaves it half raised.
            if (viewerShown) {
                Box(
                    Modifier.fillMaxSize().graphicsLayer {
                        val reveal = viewerReveal.value
                        alpha = reveal
                        val scale = 0.92f + 0.08f * reveal
                        scaleX = scale
                        scaleY = scale
                    },
                ) {
                    MediaViewer(state)
                }
            }

            // Inside the shell's own Box, and last so it sits above the viewer too: the
            // connect attempt is blocked on this answer, so it has to be the topmost thing
            // on screen. It used to be emitted *after* the theme, as a sibling of the whole
            // shell — and in that position it never appeared at all: the 2026-09-24 log says
            // "vpn prompt shown, waiting up to 60000ms" while the screen stayed empty and the
            // connect sat for 36s until the app was restarted.
            if (state.vpnPromptOpen) VpnPromptDialog(state)
        }
    }
}

/**
 * "A proxy is running; the camera will not answer while it owns the route." Two
 * buttons and a dismissal: 继续连接 lets the attempt run, 去关闭代理 abandons it and
 * opens the system VPN panel, tapping away ignores the warning and lets it run. This
 * is the only place in the app that mentions VPN — everywhere else the fix would have
 * to be understood from a failed connection, which is how it read when the notice sat
 * on the connection tab permanently.
 *
 * The dialog leads with the safe choice: [ConfirmDialog] puts confirm on the right, and
 * here that slot is 去关闭代理 — the action that stops the doomed attempt — while the
 * left slot keeps it running.
 */
@Composable
private fun VpnPromptDialog(state: AppState) {
    ConfirmDialog(
        title = stringResource(Res.string.vpn_dialog_title),
        message = stringResource(Res.string.vpn_dialog_message),
        confirmLabel = stringResource(Res.string.vpn_dialog_close),
        cancelLabel = stringResource(Res.string.vpn_dialog_continue),
        onConfirm = { state.answerVpnPrompt(VpnChoice.CloseProxy) },
        onDismiss = { state.answerVpnPrompt(VpnChoice.Proceed) },
        destructive = false,
    )
}
