package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalHapticFeedback
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.about_feedback
import com.rovecamlink.app.about_feedback_action
import com.rovecamlink.app.about_feedback_body
import com.rovecamlink.app.about_license_body
import com.rovecamlink.app.about_licenses
import com.rovecamlink.app.about_protocols
import com.rovecamlink.app.about_title
import com.rovecamlink.app.about_version
import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogFormat
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.createLogStore
import com.rovecamlink.app.label_note
import com.rovecamlink.app.log_close
import com.rovecamlink.app.log_note_export_failed
import com.rovecamlink.app.log_note_saved
import com.rovecamlink.app.log_note_share_unavailable
import com.rovecamlink.app.log_note_shared
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * The about page: version, the camera families this build can talk to, the report
 * package, and the open-source notice.
 *
 * A real page rather than an empty entry (2026-09-23 「外观、关于按真做处理，不放只有
 * 入口的空页」). The 已支持的相机 list comes from [AppState.supportedPlatforms] — the same
 * registry the connection flow uses — so a new protocol plugin shows up here for free.
 *
 * 反馈 lives here rather than on the log page because that is where someone reaches for
 * it, and because the bundle it hands out is not only the log: it is the log *plus* the
 * identity facts nobody should have to be asked for twice — see [report].
 */
@Composable
fun AboutScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val store = remember { createLogStore() }
    val scope = rememberCoroutineScope()
    var busy by remember { mutableStateOf(false) }
    var note by remember { mutableStateOf<String?>(null) }

    /**
     * Hand the user one file that answers the questions a bug report otherwise costs a
     * round trip each: this phone (model/OS/ABI, from `platformDiagnostics()`), this app
     * (version), this camera (model/firmware/hardware/serial + the clock this app last
     * set), the live session, and every persisted log run.
     *
     * The bundle is the same `rovdiag/1` export the log page produces — a report that
     * carried a *second*, differently-shaped summary would be one more thing to keep
     * correct — with a save fallback, because a report with nowhere to land is worse
     * than one that lands in a file the user can attach later.
     */
    fun report() {
        if (busy) return
        scope.launch {
            busy = true
            try {
                // The header has to describe the session as it is now: the snapshot is
                // otherwise only refreshed while the log page is open.
                state.refreshDiagnosticsEnv()
                Diag.awaitDrained()
                val text = Diag.exportFullBundle()
                val name = Diag.exportFullName()
                val size = LogFormat.size(text.length.toLong())
                val outcome = if (store.share(name, text)) {
                    getString(Res.string.log_note_shared, name, size)
                } else {
                    store.save(name, text)?.let { getString(Res.string.log_note_saved, it) }
                        ?: getString(Res.string.log_note_share_unavailable)
                }
                note = outcome
                Diag.info(LogTag.LOG, "report bundle: $outcome")
            } catch (t: Throwable) {
                note = getString(Res.string.log_note_export_failed, t.message ?: "?")
                Diag.error(LogTag.LOG, "report bundle failed ${Diag.causeChain(t)}")
            } finally {
                busy = false
            }
        }
    }

    val versionLbl = stringResource(Res.string.about_version)
    val protocolsLbl = stringResource(Res.string.about_protocols)
    val feedbackLbl = stringResource(Res.string.about_feedback)
    val feedbackBody = stringResource(Res.string.about_feedback_body)
    val feedbackActionLbl = stringResource(Res.string.about_feedback_action)
    val licensesLbl = stringResource(Res.string.about_licenses)
    val licenseBody = stringResource(Res.string.about_license_body)
    val platforms = state.supportedPlatforms().joinToString(" · ") { it.displayName }
    val haptics = LocalHapticFeedback.current

    MiuixPage(
        title = stringResource(Res.string.about_title),
        outerPadding = outerPadding,
        state = state,
        navigationIcon = {
            IconButton(
                onClick = {
                    haptics.tap()
                    onClose()
                },
            ) {
                Icon(
                    MiuixIcons.Back,
                    contentDescription = stringResource(Res.string.log_close),
                    tint = scheme.onSurface,
                )
            }
        },
    ) {
        section {
            valueItem(versionLbl, AppInfo.version)
        }
        section(title = protocolsLbl) {
            hintLine(platforms)
        }
        // The page states what the bundle carries before offering it: a report button
        // that quietly collects device details is the kind of thing users are right to
        // be suspicious of, and this one has nothing to hide.
        section(title = feedbackLbl) {
            hintLine(feedbackBody)
            actionRow(feedbackActionLbl, busy = busy) { report() }
            note?.let { infoRow(stringResource(Res.string.label_note), it) }
        }
        section(title = licensesLbl) {
            hintLine(licenseBody)
        }
    }
}

/**
 * The app's own version string, in one place so the about page and any future
 * crash-report header read the same value.
 *
 * A constant rather than a build-config lookup: the version is edited here on release,
 * and threading a `BuildKonfig` field through the three platform targets for one string
 * is more surface than a hand-set constant is worth at this stage.
 *
 * ⚠️ **It has to be bumped with `composeApp/build.gradle.kts`'s `versionName`** — that is
 * the number CI puts in the package name and checks the release tag against, and this is
 * the number the user reads back to us in a bug report. They drifted: the 2026-09-24
 * emulator pass found the about page claiming `0.1.0-dev` on a 0.1.3 build, which is a
 * report we would have chased in the wrong direction.
 */
object AppInfo {
    const val version: String = "0.1.3"
}
