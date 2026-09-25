package com.rovecamlink.app.core.media

import androidx.compose.ui.graphics.ImageBitmap
import org.jetbrains.compose.resources.decodeToImageBitmap

/**
 * [decodeScaledImage] on iOS: decode, then shrink.
 *
 * Skia can be asked to decode at a reduced scale, but only through the codec, and reaching
 * it from a byte array means holding an `org.jetbrains.skia.Image` here in the iOS source
 * set — one more platform API in a file whose only job is to keep the fallback from
 * filling the thumbnail cache with full-size frames. [scaledToFit] does that job with
 * common code.
 */
actual fun decodeScaledImage(bytes: ByteArray, maxDimensionPx: Int): ImageBitmap? =
    runCatching { bytes.decodeToImageBitmap() }.getOrNull()?.scaledToFit(maxDimensionPx)
