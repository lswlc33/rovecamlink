package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.about_license_body
import com.rovecamlink.app.about_licenses
import com.rovecamlink.app.about_protocols
import com.rovecamlink.app.about_title
import com.rovecamlink.app.about_version
import com.rovecamlink.app.log_close
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * The about page: version, the camera families this build can talk to, and the
 * open-source notice.
 *
 * A real page rather than an empty entry (2026-09-23 「外观、关于按真做处理，不放只有
 * 入口的空页」). The 已支持的相机 list comes from [AppState.supportedPlatforms] — the same
 * registry the connection flow uses — so a new protocol plugin shows up here for free.
 */
@Composable
fun AboutScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val versionLbl = stringResource(Res.string.about_version)
    val protocolsLbl = stringResource(Res.string.about_protocols)
    val licensesLbl = stringResource(Res.string.about_licenses)
    val licenseBody = stringResource(Res.string.about_license_body)
    val platforms = state.supportedPlatforms().joinToString(" · ") { it.displayName }

    MiuixPage(
        title = stringResource(Res.string.about_title),
        outerPadding = outerPadding,
        state = state,
        navigationIcon = {
            IconButton(onClick = onClose) {
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
 */
object AppInfo {
    const val version: String = "0.1.0-dev"
}
