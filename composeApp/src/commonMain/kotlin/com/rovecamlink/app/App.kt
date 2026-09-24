package com.rovecamlink.app

import androidx.compose.animation.AnimatedContent
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.zIndex
import com.rovecamlink.app.ui.AboutScreen
import com.rovecamlink.app.ui.ConfirmDialog
import com.rovecamlink.app.ui.ConnectScreen
import com.rovecamlink.app.ui.ErrorBanner
import com.rovecamlink.app.ui.FilesScreen
import com.rovecamlink.app.ui.LiveScreen
import com.rovecamlink.app.ui.LogScreen
import com.rovecamlink.app.ui.LogSettingsScreen
import com.rovecamlink.app.ui.MediaViewer
import com.rovecamlink.app.ui.NavMotion
import com.rovecamlink.app.ui.PermissionsScreen
import com.rovecamlink.app.ui.PlatformBackHandler
import com.rovecamlink.app.ui.SettingsScreen
import com.rovecamlink.app.ui.glass.IosLiquidGlassNavigationBar
import com.rovecamlink.app.ui.rememberBarBackdrop
import com.rovecamlink.app.ui.rememberPagerNavState
import com.rovecamlink.app.ui.sampleBackdrop
import com.rovecamlink.app.ui.tick
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
 * What the transition animates on: the page on top **and** how deep it is.
 *
 * A page alone cannot say which way a move went — pushing 日志设置 from 日志 and popping back
 * are both "from one non-null page to another" — so the depth rides along and the transition
 * reads its direction from the difference.
 */
private data class NavKey(val page: Page?, val depth: Int)

/**
 * The shell: a bottom navigation bar and nothing else.
 *
 * The bar at the top of the window belongs to the page under it — see `MiuixPage` — so
 * that it can name the page rather than the app and collapse as that page's list moves.
 * The window title still names the app.
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

    // The system back gesture is the other way out of a pushed page, and the arrow in its
    // bar is the first: both land on the same `popPage`, so a pushed page behaves like the
    // sub-page it looks like. With nothing pushed this stays out of the way and back keeps
    // its platform meaning (leave the app).
    PlatformBackHandler(enabled = state.topPage != null) { state.popPage() }
    // The full-screen picture is the other thing back has to be able to leave, and it is
    // the only control it has: the bar that would carry a 退出 button is hidden by design.
    PlatformBackHandler(enabled = state.topPage == null && state.previewFullscreen) {
        state.setFullscreenPreview(false)
    }
    // The media viewer sits above even that: it covers the window, so back has to close it
    // before anything else can claim the gesture.
    PlatformBackHandler(enabled = state.viewer != null) { state.closeViewer() }
    // With nothing pushed, back walks the pager home instead of closing the app — the demo's
    // own behaviour, and the Android convention for a bottom bar: 设置 → 返回 lands on 设备,
    // a second 返回 leaves. The two handlers are mutually exclusive by their conditions.
    PlatformBackHandler(
        enabled = state.topPage == null && !state.previewFullscreen &&
            state.viewer == null && pager.selectedPage != 0,
    ) {
        pager.animateToPage(0)
    }

    // A pushed page is a full-screen sub-page: 日志, 日志设置, 关于 and 权限说明 all carry their
    // own back arrow, and leaving the four tabs lit under them made the app look like it had
    // more tabs than the arrow implied (2026-09-24 「部分二级页面…应该是全屏的，底栏应该隐藏
    // 掉」). The full-screen picture hides it too. The gesture-bar inset the bar used to
    // consume is handed back to the page instead of being dropped with it, so the last row of
    // a log still clears the system bar.
    val fullScreen = state.topPage != null || state.previewFullscreen || state.viewer != null
    val navInset = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
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
            if (!fullScreen) {
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
        val outerPadding = if (fullScreen) PaddingValues(bottom = navInset) else padding
        Box(Modifier.fillMaxSize().sampleBackdrop(backdrop)) {
            // The pushed layer wins over the tab underneath: the log, its settings and the
            // about page each get the whole window and their own back arrow, rather than
            // being painted over one tab's content. The key carries the stack *depth* as well
            // as the page, because that is what tells a push from a pop — 日志 → 日志设置 and
            // the way back are both "two non-null pages".
            AnimatedContent(
                targetState = NavKey(state.topPage, state.pageDepth),
                transitionSpec = { NavMotion.stackTransition(push = targetState.depth > initialState.depth) },
                label = "page",
            ) { key ->
                // Deeper pages draw above shallower ones — on a push the arriving page is on
                // top, and on a pop the page *leaving* is. Without this, `AnimatedContent`
                // paints its target above its initial content, so going back drew the
                // revealed page over the one sliding away and the two read as a cross-fade
                // instead of a stack moving (caught in the 2026-09-24 emulator capture).
                Box(Modifier.zIndex(key.depth.toFloat())) {
                    when (key.page) {
                        Page.Log -> LogScreen(state, outerPadding = outerPadding, onClose = { state.popPage() })
                        Page.LogSettings -> LogSettingsScreen(state, outerPadding = outerPadding, onClose = { state.popPage() })
                        Page.About -> AboutScreen(state, outerPadding = outerPadding, onClose = { state.popPage() })
                        Page.Permissions -> PermissionsScreen(state, outerPadding = outerPadding, onClose = { state.popPage() })
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
                                Tab.Devices -> ConnectScreen(state, outerPadding = outerPadding)
                                Tab.Live -> LiveScreen(state, outerPadding = outerPadding)
                                Tab.Files -> FilesScreen(state, outerPadding = outerPadding)
                                Tab.Settings -> SettingsScreen(state, outerPadding = outerPadding)
                            }
                        }
                    }
                }
            }
            state.errorMessage?.let { msg ->
                ErrorBanner(msg) { state.errorMessage = null }
            }
            // Last in the Box, so the viewer covers the error banner too: it is the one
            // surface that owns the whole window while it is up.
            if (state.viewer != null) MediaViewer(state)
        }
    }

    // The connect-time VPN question, hosted here rather than on the connection tab
    // because the attempt can start from anywhere — an auto-connect fires the moment
    // a camera hotspot the user joined in Settings appears, and a dialog that only
    // exists on one tab would leave the attempt waiting behind another.
    if (state.vpnPromptOpen) VpnPromptDialog(state)
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
