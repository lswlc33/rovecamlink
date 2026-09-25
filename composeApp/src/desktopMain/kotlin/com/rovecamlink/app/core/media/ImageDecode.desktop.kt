package com.rovecamlink.app.core.media

import androidx.compose.ui.graphics.ImageBitmap
import org.jetbrains.compose.resources.decodeToImageBitmap

/**
 * [decodeScaledImage] on the desktop: decode, then shrink.
 *
 * The JVM's image reader has no "decode at this size" hook that a byte array can reach
 * without a stream, and a desktop heap absorbs the full-size frame this is a fallback for,
 * so the split here is honest — the decode is unbounded, the *cache* is not (see
 * [scaledToFit]).
 */
actual fun decodeScaledImage(bytes: ByteArray, maxDimensionPx: Int): ImageBitmap? =
    runCatching { bytes.decodeToImageBitmap() }.getOrNull()?.scaledToFit(maxDimensionPx)
