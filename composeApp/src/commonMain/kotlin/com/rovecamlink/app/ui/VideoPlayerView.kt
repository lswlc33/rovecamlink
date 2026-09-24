package com.rovecamlink.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Plays a clip that is already on disk.
 *
 * Android hands this to Media3 ExoPlayer; desktop and iOS have no player here and show a
 * notice instead. It is a separate `expect`/`actual` pair from
 * [com.rovecamlink.app.core.media.CameraPreviewView] because the two have different
 * sources and different jobs: the live view rides an RTSP stream and reconnects on its
 * own, while this one opens a file the user already downloaded and stops at its end.
 *
 * [displayName] is carried for the log line and the accessibility label only — the path
 * is what gets played.
 */
@Composable
expect fun VideoPlayerView(localPath: String, displayName: String, modifier: Modifier)
