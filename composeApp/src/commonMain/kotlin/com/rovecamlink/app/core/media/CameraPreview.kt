package com.rovecamlink.app.core.media

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Renders a live RTSP preview. Android uses Media3 ExoPlayer with the RTSP
 * extractor inside an AndroidView; desktop/iOS show a placeholder (the real
 * device target is Android).
 *
 * [onAspect] reports the stream's own width/height ratio as soon as the decoder knows it,
 * so the caller can size the frame to the picture instead of assuming 16:9 and stretching
 * it. It may never be called (platform with no decoder, or a stream that never reports),
 * which is why the caller keeps a fallback.
 */
@Composable
expect fun CameraPreviewView(
    rtspUrl: String?,
    modifier: Modifier,
    onAspect: ((Float) -> Unit)?,
)
