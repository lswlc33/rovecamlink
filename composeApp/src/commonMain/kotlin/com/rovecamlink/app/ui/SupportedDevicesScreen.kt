package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalHapticFeedback
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_back
import com.rovecamlink.app.device_catalog_adapted
import com.rovecamlink.app.device_catalog_chip
import com.rovecamlink.app.device_catalog_chip_unknown
import com.rovecamlink.app.device_catalog_not_adapted
import com.rovecamlink.app.device_catalog_protocol
import com.rovecamlink.app.device_catalog_title
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * The supported-devices page: this app's cameras, by brand, with the protocol and
 * SoC each one needs.
 *
 * Reached from the device tab's bottom entry; a pure reader — it navigates nowhere,
 * acts on nothing, and is safe to open with no camera connected, which is exactly
 * when someone consults it (their camera is not connecting and they want to know
 * whether it is supposed to).
 *
 * The 已适配 chip is the page's whole point and it is deliberately sourced from the
 * protocol registry, not from this catalogue: [DeviceCatalog] documents what the
 * cameras are, the registry decides what this build can drive. The two can
 * legitimately disagree (the archive documents the iCatch platform this build has
 * no plugin for), and when they do the page says 未适配 rather than overclaiming.
 */
@Composable
fun SupportedDevicesScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val title = stringResource(Res.string.device_catalog_title)
    val adaptedLbl = stringResource(Res.string.device_catalog_adapted)
    val notAdaptedLbl = stringResource(Res.string.device_catalog_not_adapted)
    val protocolLbl = stringResource(Res.string.device_catalog_protocol)
    val chipLbl = stringResource(Res.string.device_catalog_chip)
    val chipUnknownLbl = stringResource(Res.string.device_catalog_chip_unknown)
    val haptics = LocalHapticFeedback.current

    MiuixPage(
        title = title,
        outerPadding = outerPadding,
        state = state,
        // Pushed page: the bar carries 返回 and nothing else.
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
        DeviceCatalog.brands.forEach { brand ->
            val adapted = DeviceCatalog.isAdapted(brand) { state.protocolFor(it) != null }
            section(title = "${brand.name} · ${if (adapted) adaptedLbl else notAdaptedLbl}") {
                brand.models.forEach { m ->
                    valueItem(
                        title = m.model,
                        value = listOfNotNull(
                            m.chip ?: chipUnknownLbl,
                            m.platform.displayName,
                        ).joinToString(" · "),
                    )
                    m.note.takeIf { it.isNotEmpty() }?.let { hintLine("$protocolLbl · $it") }
                }
            }
        }
    }
}
