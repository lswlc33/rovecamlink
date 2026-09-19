package com.rovecamlink.app.core.media

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Renders a live RTSP preview. Android uses Media3 ExoPlayer with the RTSP
 * extractor inside an AndroidView; desktop/iOS show a placeholder (the real
 * device target is Android).
 */
@Composable
expect fun CameraPreviewView(rtspUrl: String?, modifier: Modifier)
