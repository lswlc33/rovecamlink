package com.rovecamlink.app

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.rovecamlink.app.ui.NavMotion
import com.rovecamlink.app.ui.PermissionsScreen
import com.rovecamlink.app.ui.PlatformBackHandler
import com.rovecamlink.app.ui.SettingsScreen
import com.rovecamlink.app.ui.rememberPagerNavState
import com.rovecamlink.app.ui.tick
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.NavigationBar
import top.yukonga.miuix.kmp.basic.NavigationBarItem
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
    // goes the other way, through `animateToPage`.
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { pager.syncPage() }
    }

    // The system back gesture is the other way out of a pushed page, and the arrow in its
    // bar is the first: both land on the same `popPage`, so a pushed page behaves like the
    // sub-page it looks like. With nothing pushed this stays out of the way and back keeps
    // its platform meaning (leave the app).
    PlatformBackHandler(enabled = state.topPage != null) { state.popPage() }
    // With nothing pushed, back walks the pager home instead of closing the app — the demo's
    // own behaviour, and the Android convention for a bottom bar: 设置 → 返回 lands on 设备,
    // a second 返回 leaves. The two handlers are mutually exclusive by their conditions.
    PlatformBackHandler(enabled = state.topPage == null && pager.selectedPage != 0) {
        pager.animateToPage(0)
    }

    Scaffold(
        containerColor = MiuixTheme.colorScheme.background,
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, t ->
                    NavigationBarItem(
                        selected = index == pager.selectedPage,
                        onClick = {
                            if (index != pager.selectedPage || state.topPage != null) haptics.tick()
                            // A pushed page is drawn over the tabs, so without this the
                            // highlight moved and nothing else did — the page stayed.
                            state.popToTabs()
                            pager.animateToPage(index)
                        },
                        icon = t.icon,
                        label = stringResource(t.labelRes),
                    )
                }
            }
        },
    ) { padding ->
        Box(Modifier.fillMaxSize()) {
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
                        Page.Log -> LogScreen(state, outerPadding = padding, onClose = { state.popPage() })
                        Page.LogSettings -> LogSettingsScreen(state, outerPadding = padding, onClose = { state.popPage() })
                        Page.About -> AboutScreen(state, outerPadding = padding, onClose = { state.popPage() })
                        Page.Permissions -> PermissionsScreen(state, outerPadding = padding, onClose = { state.popPage() })
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
                                Tab.Devices -> ConnectScreen(state, outerPadding = padding)
                                Tab.Live -> LiveScreen(state, outerPadding = padding)
                                Tab.Files -> FilesScreen(state, outerPadding = padding)
                                Tab.Settings -> SettingsScreen(state, outerPadding = padding)
                            }
                        }
                    }
                }
            }
            state.errorMessage?.let { msg ->
                ErrorBanner(msg) { state.errorMessage = null }
            }
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
