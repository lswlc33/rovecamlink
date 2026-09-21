package com.rovecamlink.app.core.media

import androidx.compose.runtime.Composable

/**
 * Desktop has no orientation sensor, and the question "how is the device held?" has no
 * referent for a window on a desk: 0° is not a stub waiting for a driver, it is the
 * correct answer, and it keeps the layout's 16:9 band. [enabled] is ignored for the same
 * reason there is nothing to switch on.
 */
@Composable
actual fun rememberDeviceOrientation(
    mode: OrientationMode,
    enabled: Boolean,
): DeviceOrientation = DeviceOrientation(0f, mode)
