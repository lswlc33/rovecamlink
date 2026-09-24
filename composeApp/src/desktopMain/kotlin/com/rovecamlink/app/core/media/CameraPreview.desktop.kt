package com.rovecamlink.app.core.media

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rovecamlink.app.Res
import com.rovecamlink.app.preview_no_decoder_desktop
import com.rovecamlink.app.preview_none
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * Desktop has no bundled RTSP decoder, so we name the stream the camera offered and
 * leave the frame to the page's own background. The desktop build exists to exercise
 * the CGI protocol against the simulator; live preview is an Android feature.
 */
@Composable
actual fun CameraPreviewView(rtspUrl: String?, modifier: Modifier, onAspect: ((Float) -> Unit)?) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = rtspUrl?.let { stringResource(Res.string.preview_no_decoder_desktop, it) }
                ?: stringResource(Res.string.preview_none),
            fontSize = 12.sp,
            color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
        )
    }
}
