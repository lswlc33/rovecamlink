package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
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
import com.rovecamlink.app.action_back
import com.rovecamlink.app.cancel
import com.rovecamlink.app.core.update.AppRelease
import com.rovecamlink.app.core.update.UpdateChannel
import com.rovecamlink.app.hint_check_app_update
import com.rovecamlink.app.label_package_size
import com.rovecamlink.app.label_release_date
import com.rovecamlink.app.update_channel
import com.rovecamlink.app.update_channel_alpha
import com.rovecamlink.app.update_channel_alpha_summary
import com.rovecamlink.app.update_channel_head
import com.rovecamlink.app.update_channel_stable
import com.rovecamlink.app.update_channel_stable_summary
import com.rovecamlink.app.update_check_now
import com.rovecamlink.app.update_checking
import com.rovecamlink.app.update_error
import com.rovecamlink.app.update_error_body
import com.rovecamlink.app.update_installed
import com.rovecamlink.app.update_none_yet
import com.rovecamlink.app.update_open_page
import com.rovecamlink.app.update_open_page_fallback
import com.rovecamlink.app.update_prerelease
import com.rovecamlink.app.update_title
import com.rovecamlink.app.update_uptodate
import com.rovecamlink.app.update_alpha_head_note
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.TextButton
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.overlay.OverlayDialog
import top.yukonga.miuix.kmp.preference.ArrowPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * The in-app updater: which channel to watch, what the check found, and the one way to
 * act on it — the release page in a browser.
 *
 * The app deliberately stops at "open the page": fetching and installing an APK is the
 * OS installer's job on Android, and a re-implemented downloader would only add a place
 * to disagree with it. Alpha builds are timestamped rather than versioned and an
 * installed package cannot prove when it was built, so the alpha half of the page shows
 * what main produced most recently and says exactly that, instead of a fake "up to date"
 * verdict the app has no evidence for.
 */
@Composable
fun UpdateScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val haptics = LocalHapticFeedback.current
    var copyFallback by remember { mutableStateOf<String?>(null) }

    val title = stringResource(Res.string.update_title)
    val channelLbl = stringResource(Res.string.update_channel)
    val alphaLbl = stringResource(Res.string.update_channel_alpha)
    val alphaSummary = stringResource(Res.string.update_channel_alpha_summary)
    val stableLbl = stringResource(Res.string.update_channel_stable)
    val stableSummary = stringResource(Res.string.update_channel_stable_summary)
    val installedLbl = stringResource(Res.string.update_installed)
    val checkNowLbl = stringResource(Res.string.update_check_now)
    val checkingLbl = stringResource(Res.string.update_checking)
    val headLbl = stringResource(Res.string.update_channel_head)
    val noneYet = stringResource(Res.string.update_none_yet)
    val errorLine = stringResource(Res.string.update_error)
    val errorBody = stringResource(Res.string.update_error_body)
    val openLbl = stringResource(Res.string.update_open_page)
    val fallbackLbl = stringResource(Res.string.update_open_page_fallback)
    val upToDateLbl = stringResource(Res.string.update_uptodate)
    val alphaNote = stringResource(Res.string.update_alpha_head_note)
    val prereleaseLbl = stringResource(Res.string.update_prerelease)
    val publishedLbl = stringResource(Res.string.label_release_date)
    val sizeLbl = stringResource(Res.string.label_package_size)
    val cancelLbl = stringResource(Res.string.cancel)

    MiuixPage(
        title = title,
        outerPadding = outerPadding,
        state = state,
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
                    contentDescription = stringResource(Res.string.action_back),
                    tint = scheme.onSurface,
                )
            }
        },
    ) {
        // 频道：两个单选行。就两个选项、各带一行说明，可点行 + ✓ 是这套设置页里
        // 「从两三个里选一个」的既有画法（与信道那条对话框的取舍同理——摊开一页
        // 读不出当前值的东西才收进对话框，这里当前值就画在行上）。
        section(title = channelLbl) {
            channelRow(alphaLbl, alphaSummary, state.updateChannel == UpdateChannel.Alpha) {
                haptics.tick()
                state.updateChannel = UpdateChannel.Alpha
            }
            channelRow(stableLbl, stableSummary, state.updateChannel == UpdateChannel.Stable) {
                haptics.tick()
                state.updateChannel = UpdateChannel.Stable
            }
            hintLine(stringResource(Res.string.hint_check_app_update))
        }

        section(title = headLbl) {
            valueItem(installedLbl, AppInfo.version)
            val result = state.updateResult
            when {
                state.updateChecking -> hintLine(checkingLbl)
                result is AppState.UpdateResult.UpToDate -> hintLine(upToDateLbl)
                result is AppState.UpdateResult.Available -> releaseRows(
                    release = result.release,
                    headLbl = headLbl,
                    publishedLbl = publishedLbl,
                    sizeLbl = sizeLbl,
                    openLbl = openLbl,
                    prereleaseLbl = prereleaseLbl,
                    alphaNote = if (state.updateChannel == UpdateChannel.Alpha) alphaNote else null,
                    onOpen = {
                        haptics.tick()
                        if (!state.openUpdatePage(result.release)) copyFallback = result.release.openUrl
                    },
                )
                // Not checking, nothing found: either nobody has checked yet or the last
                // check came back empty. The one distinction the page can draw is whether
                // a check has ever run — a first visit reads as an invitation, a failed
                // check as the reason plus the way out.
                !state.everCheckedUpdate -> hintLine(noneYet)
                else -> {
                    hintLine(errorLine)
                    hintLine(errorBody)
                }
            }
            actionRow(checkNowLbl, busy = state.updateChecking) { state.checkAppUpdate() }
        }
    }

    // Only reached when the platform could not open a browser: the URL as selectable
    // text is the honest fallback, not a dead button.
    copyFallback?.let { url ->
        OverlayDialog(
            show = true,
            title = fallbackLbl,
            summary = url,
            onDismissRequest = { copyFallback = null },
        ) {
            TextButton(
                text = cancelLbl,
                onClick = { copyFallback = null },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

/** One channel choice: name, what it means, and ✓ on the live one. */
@Composable
private fun androidx.compose.foundation.layout.ColumnScope.channelRow(
    title: String,
    summary: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    BasicRow(onClick = onClick) {
        Text(title, fontSize = 16.sp, color = MiuixTheme.colorScheme.onBackground)
        if (selected) {
            Spacer(Modifier.width(6.dp))
            Text("✓", fontSize = 16.sp, color = MiuixTheme.colorScheme.primary)
        }
        Spacer(Modifier.width(8.dp))
        Text(summary, fontSize = 13.sp, color = MiuixTheme.colorScheme.onSurfaceVariantSummary)
    }
}

/** What the page shows under a found release, plus the one action that acts on it. */
@Composable
private fun androidx.compose.foundation.layout.ColumnScope.releaseRows(
    release: AppRelease,
    headLbl: String,
    publishedLbl: String,
    sizeLbl: String,
    openLbl: String,
    prereleaseLbl: String,
    alphaNote: String?,
    onOpen: () -> Unit,
) {
    valueItem(headLbl, release.tagName + if (release.prerelease) " · $prereleaseLbl" else "")
    release.publishedAt?.let { valueItem(publishedLbl, it.take(10)) }
    if (release.apkSizeBytes > 0) valueItem(sizeLbl, humanBytes(release.apkSizeBytes))
    alphaNote?.let { hintLine(it) }
    // The library's own arrow row (the same one every pushed-page entry wears), not the
    // file-private entryRow helper — that one belongs to Screens.kt's device menus.
    ArrowPreference(title = openLbl, onClick = onOpen)
}
