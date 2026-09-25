package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_back
import com.rovecamlink.app.device_catalog_adapted
import com.rovecamlink.app.device_catalog_chip_unknown
import com.rovecamlink.app.device_catalog_not_adapted
import com.rovecamlink.app.device_catalog_title
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * The supported-devices page: this app's cameras, by brand, with the SoC each one needs.
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
 *
 * **One row a camera, not two.** This page used to give each model a `valueItem` and then
 * a `hintLine`, which is two `BasicComponent`s and therefore 64 dp of the library's own
 * inside padding per model before a single word is drawn — the "why is there so much empty
 * space" of the 2026-09-25 report. The wrap made it worse: the SoC string is the longest
 * one on the page, it is right-aligned, and on the left of its second line sat nothing at
 * all. The three facts a model has — its name, which SoC it uses, which platform and
 * protocol that means — now share one row: the name leads, the SoC is the trailing value
 * where a right-aligned short string belongs, and the platform and note drop to a muted
 * second line under the name. Half the height, and the eye has one column to follow
 * instead of two fighting ones.
 */
@Composable
fun SupportedDevicesScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val title = stringResource(Res.string.device_catalog_title)
    val adaptedLbl = stringResource(Res.string.device_catalog_adapted)
    val notAdaptedLbl = stringResource(Res.string.device_catalog_not_adapted)
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
                    modelRow(
                        model = m.model,
                        chip = m.chip ?: chipUnknownLbl,
                        detail = listOfNotNull(m.platform.displayName, m.note).joinToString(" · "),
                    )
                }
            }
        }
    }
}

/**
 * One camera: name and trailing SoC on the first line, platform and note muted under the
 * name. See the page comment for why this is one row and not two.
 */
@Composable
private fun ColumnScope.modelRow(model: String, chip: String, detail: String) {
    BasicRow(
        end = {
            Text(
                text = chip,
                fontSize = 13.sp,
                color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
                textAlign = TextAlign.End,
            )
        },
    ) {
        Text(model, fontSize = 16.sp, color = MiuixTheme.colorScheme.onBackground)
        if (detail.isNotEmpty()) {
            Spacer(Modifier.size(2.dp))
            Text(
                text = detail,
                fontSize = 12.sp,
                color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
            )
        }
    }
}
