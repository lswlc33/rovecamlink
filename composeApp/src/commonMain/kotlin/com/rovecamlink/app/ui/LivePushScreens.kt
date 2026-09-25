package com.rovecamlink.app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.rovecamlink.app.AppState
import com.rovecamlink.app.Op
import com.rovecamlink.app.Res
import com.rovecamlink.app.action_back
import com.rovecamlink.app.action_live_play
import com.rovecamlink.app.action_live_stop
import com.rovecamlink.app.action_start_live
import com.rovecamlink.app.cancel
import com.rovecamlink.app.confirm_start_live
import com.rovecamlink.app.core.media.CameraPreviewView
import com.rovecamlink.app.core.model.LiveBitrate
import com.rovecamlink.app.core.model.LiveFps
import com.rovecamlink.app.core.model.LiveResolution
import com.rovecamlink.app.hint_live_host
import com.rovecamlink.app.hint_live_no_stop
import com.rovecamlink.app.hint_live_preview_stopped
import com.rovecamlink.app.hint_live_url
import com.rovecamlink.app.hint_live_wifi
import com.rovecamlink.app.label_live_host
import com.rovecamlink.app.label_live_password
import com.rovecamlink.app.label_live_ssid
import com.rovecamlink.app.label_live_url
import com.rovecamlink.app.live_title_preview
import com.rovecamlink.app.live_title_settings
import com.rovecamlink.app.message_start_live
import com.rovecamlink.app.section_live_encoder
import com.rovecamlink.app.section_live_url
import com.rovecamlink.app.section_live_wifi
import com.rovecamlink.app.title_live_bitrate
import com.rovecamlink.app.title_live_fps
import com.rovecamlink.app.title_live_resolution
import com.rovecamlink.app.title_start_live
import com.rovecamlink.app.value_live_stream_url
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back
import top.yukonga.miuix.kmp.icon.extended.Hide
import top.yukonga.miuix.kmp.icon.extended.Show
import top.yukonga.miuix.kmp.preference.OverlayDropdownPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * 直播设置 — the form that decides what the *camera* is told before it pushes.
 *
 * Nothing here streams anything: the camera is the RTMP client (see
 * [com.rovecamlink.app.core.model.LiveConfig]), so this page is the whole of "how do I go
 * live" — a network to join, a URL to push to, and the three encoder parameters the
 * firmware takes. The payload those become is one line on the port-8080 socket
 * ([com.rovecamlink.app.brand.xtu.XtuRtmpPush]).
 *
 * The form writes straight into [AppState.liveConfig] rather than into local drafts: the
 * device page's 直播设置 row shows the same URL as its summary, and a form the user filled
 * in that the row behind it still calls 未填写 would be a second, wrong answer to the same
 * question.
 */
@Composable
fun LiveSettingsScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val haptics = LocalHapticFeedback.current
    val config = state.liveConfig

    // The one credential on this page, masked the way the camera's own hotspot passphrase
    // is on the device page — and unmasked by an eye that belongs to the field it unmasks.
    var showPass by remember { mutableStateOf(false) }
    var confirmStart by remember { mutableStateOf(false) }

    val wifiTitle = stringResource(Res.string.section_live_wifi)
    val urlTitle = stringResource(Res.string.section_live_url)
    val encoderTitle = stringResource(Res.string.section_live_encoder)
    val ssidLbl = stringResource(Res.string.label_live_ssid)
    val passLbl = stringResource(Res.string.label_live_password)
    val urlLbl = stringResource(Res.string.label_live_url)
    val urlHint = stringResource(Res.string.hint_live_url)
    val resLbl = stringResource(Res.string.title_live_resolution)
    val fpsLbl = stringResource(Res.string.title_live_fps)
    val bitrateLbl = stringResource(Res.string.title_live_bitrate)
    val startLbl = stringResource(Res.string.action_start_live)

    MiuixPage(
        title = stringResource(Res.string.live_title_settings),
        outerPadding = outerPadding,
        state = state,
        // A pushed page: the bar carries 返回, not a second way into the log.
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
        section(title = wifiTitle) {
            // Said before the fields rather than after: the common mistake is to type the
            // phone's own hotspot here, and the camera would then join the phone and push
            // from a network with no route to the internet.
            hintLine(stringResource(Res.string.hint_live_wifi))
            MiuixField(
                value = config.ssid,
                onValueChange = { v -> state.updateLiveConfig { it.copy(ssid = v) } },
                placeholder = ssidLbl,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp),
            )
            MiuixField(
                value = config.password,
                onValueChange = { v -> state.updateLiveConfig { it.copy(password = v) } },
                placeholder = passLbl,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp),
                visualTransformation = if (showPass) VisualTransformation.None
                    else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { haptics.tap(); showPass = !showPass }) {
                        Icon(
                            imageVector = if (showPass) MiuixIcons.Hide else MiuixIcons.Show,
                            contentDescription = null,
                            tint = MiuixTheme.colorScheme.onSurfaceVariantSummary,
                        )
                    }
                },
            )
        }

        section(title = urlTitle) {
            MiuixField(
                value = config.rtmpUrl,
                onValueChange = { v -> state.updateLiveConfig { it.copy(rtmpUrl = v) } },
                placeholder = if (config.rtmpUrl.isBlank()) urlHint else urlLbl,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp),
            )
        }

        // The vendor's own three choices, and the only ones the payload's envelope carries:
        // 720/1080, 25/30, and a bitrate that is a 0/1 preference rather than a number of
        // kbps. Rendered as the library's dropdown rows because each is "pick one of a few"
        // — the same shape the camera's settings page uses for its own `options` rows.
        section(title = encoderTitle) {
            OverlayDropdownPreference(
                items = LiveResolution.entries.map { stringResource(it.displayNameRes) },
                selectedIndex = LiveResolution.entries.indexOf(config.resolution),
                title = resLbl,
                onSelectedIndexChange = { i ->
                    LiveResolution.entries.getOrNull(i)?.let { picked ->
                        state.updateLiveConfig { it.copy(resolution = picked) }
                    }
                },
            )
            OverlayDropdownPreference(
                items = LiveFps.entries.map { stringResource(it.displayNameRes) },
                selectedIndex = LiveFps.entries.indexOf(config.fps),
                title = fpsLbl,
                onSelectedIndexChange = { i ->
                    LiveFps.entries.getOrNull(i)?.let { picked ->
                        state.updateLiveConfig { it.copy(fps = picked) }
                    }
                },
            )
            OverlayDropdownPreference(
                items = LiveBitrate.entries.map { stringResource(it.displayNameRes) },
                selectedIndex = LiveBitrate.entries.indexOf(config.bitrate),
                title = bitrateLbl,
                onSelectedIndexChange = { i ->
                    LiveBitrate.entries.getOrNull(i)?.let { picked ->
                        state.updateLiveConfig { it.copy(bitrate = picked) }
                    }
                },
            )
        }

        // 开始直播 sits outside the card and is the page's one filled button, the way the
        // camera Wi-Fi page lays out 读取 / 保存 (2026-09-24). It is *not* greyed on an
        // incomplete form: a greyed control has to say why, and the reason here is already
        // written above it — the row instead refuses out loud, which is what [AppState.startLive]
        // does with the same blocker.
        section(card = false) {
            config.blocker?.let { hintLine(stringResource(it.reasonRes)) }
            actionRow(startLbl, busy = state.isBusy(Op.Live)) {
                if (config.isSendable) confirmStart = true else state.startLive()
            }
            // The stop that is not here. Stated rather than left as an absence: a user who
            // cannot find 关播 has to know it is the firmware's missing command and not a
            // button this page forgot.
            hintLine(stringResource(Res.string.hint_live_no_stop))
        }
    }

    if (confirmStart) {
        ConfirmDialog(
            title = stringResource(Res.string.title_start_live),
            message = stringResource(Res.string.message_start_live),
            confirmLabel = stringResource(Res.string.confirm_start_live),
            cancelLabel = stringResource(Res.string.cancel),
            // Not destructive: the camera joins a network and pushes. It is reversible
            // from the camera, and the red pair is reserved for what cannot be undone.
            destructive = false,
            onConfirm = {
                confirmStart = false
                state.startLive()
            },
            onDismiss = { confirmStart = false },
        )
    }
}

/**
 * 直播预览 — the camera's *own* RTSP stream, not the RTMP push.
 *
 * Two different pictures live behind the word 直播, and this page is deliberately the
 * second one: the RTMP URL above is where the camera pushes *out*, while this reads the
 * chip's own `/livestream/12` (`CameraProtocol.previewUrl`) back over the LAN. That is
 * exactly what makes it useful as the check on a push that reports nothing — the vendor app
 * shows a timer and calls it live; this shows the picture the camera is actually encoding.
 *
 * [label_live_host] exists because the address changes: go live and the camera leaves its
 * own hotspot for the stream Wi-Fi, where the router hands it a different address, so the
 * session's host stops being the one that answers. The field is pre-filled from the session
 * and the URL is rebuilt from the plugin's own on every keystroke rather than the path
 * being spelled here — `/livestream/12` is a firmware fact, not a UI one.
 */
@Composable
fun LivePreviewScreen(state: AppState, outerPadding: PaddingValues, onClose: () -> Unit) {
    val scheme = MiuixTheme.colorScheme
    val haptics = LocalHapticFeedback.current

    var host by remember { mutableStateOf(state.session?.host.orEmpty()) }
    var playing by remember { mutableStateOf(false) }
    // 16:9 until the decoder says otherwise: a stream that never reports its size still has
    // to occupy something, and an aspect-0 box would take the whole list with it.
    var aspect by remember { mutableStateOf(16f / 9f) }

    val url = state.livePreviewUrl(host)
    val hostLbl = stringResource(Res.string.label_live_host)
    val playLbl = stringResource(Res.string.action_live_play)
    val stopLbl = stringResource(Res.string.action_live_stop)

    MiuixPage(
        title = stringResource(Res.string.live_title_preview),
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
        if (playing) {
            // First in the list because it is the page: the address and the URL are the
            // controls for it, and they belong below the thing they are controlling.
            item {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                ) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .aspectRatio(aspect.coerceAtLeast(0.1f)),
                    ) {
                        CameraPreviewView(
                            rtspUrl = url,
                            modifier = Modifier.fillMaxSize(),
                            onAspect = { if (it > 0f) aspect = it },
                        )
                    }
                }
            }
        }

        section(title = hostLbl) {
            MiuixField(
                value = host,
                onValueChange = { v ->
                    host = v
                    // The URL is built from this field, so a half-typed address must not
                    // keep feeding the player the previous one.
                    playing = false
                },
                placeholder = hostLbl,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 6.dp),
            )
            hintLine(stringResource(Res.string.hint_live_host))
            valueItem(
                stringResource(Res.string.value_live_stream_url),
                url.ifEmpty { "—" },
            )
        }

        if (!playing) {
            section { hintLine(stringResource(Res.string.hint_live_preview_stopped)) }
        }

        // Outside the card, like every other primary action in this app.
        section(card = false) {
            actionRow(
                label = if (playing) stopLbl else playLbl,
                enabled = url.isNotEmpty(),
            ) { playing = !playing }
        }
    }
}
