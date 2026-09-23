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
import com.rovecamlink.app.preview_no_decoder_ios
import com.rovecamlink.app.preview_none
import org.jetbrains.compose.resources.stringResource
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.theme.MiuixTheme

/**
 * iOS preview scaffold. A real implementation would wrap AVPlayer in a
 * UIViewController via UIKitView; until then this names the stream rather than
 * painting a grey box over the page's own background.
 */
@Composable
actual fun CameraPreviewView(rtspUrl: String?, modifier: Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = rtspUrl?.let { stringResource(Res.string.preview_no_decoder_ios, it) }
                ?: stringResource(Res.string.preview_none),
            fontSize = 12.sp,
            color = MiuixTheme.colorScheme.onSurfaceVariantSummary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
        )
    }
}
