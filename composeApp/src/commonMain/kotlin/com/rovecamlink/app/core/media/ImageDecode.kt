package com.rovecamlink.app.core.media

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize

/**
 * Decode [bytes] into an image whose long edge is at most [maxDimensionPx].
 *
 * The camera's own `.THM` previews are small and any decoder can hold one, which is why
 * the thumbnail path needed nothing but `decodeToImageBitmap` until photos turned out to
 * have no `.THM` at all (see `HisiliconProtocol.thumbnail`). The fallback for a photo is
 * the photo itself — 12-48 MP on this hardware — and decoding that at full size to draw a
 * 100 dp grid cell is exactly the crash `CameraFiles.thumbnailPath` documents. So the
 * fallback needs a decoder that is told the size it is being decoded *for*, and on
 * Android that instruction has to reach the codec (see `ImageDecode.android.kt`); where no
 * such hook exists the decode happens first and the shrink follows, which is what
 * [scaledToFit] is for.
 *
 * [maxDimensionPx] is a ceiling on the long edge, not an exact size — an image already
 * smaller than the request is returned as-is rather than blown up. Null means the bytes
 * are not an image this platform can read, which the caller treats exactly like "no
 * preview": a placeholder now, and a retry on a later visit.
 */
expect fun decodeScaledImage(bytes: ByteArray, maxDimensionPx: Int): ImageBitmap?

/**
 * [this] redrawn to fit inside [maxDimensionPx] along its long edge, or [this] itself when
 * it already does. The aspect ratio is preserved and `Medium` filtering is used, because a
 * downscale read at a glance is where nearest-neighbour's aliasing is most visible.
 *
 * This is the fallback half of [decodeScaledImage] for the platforms whose decoder cannot
 * be asked for a size up front: it bounds what the *cache* retains, not what the decode
 * momentarily allocates. That is the right trade where a full-size decode is affordable
 * (a desktop heap), and the wrong one on Android, which is why Android does not use it.
 */
fun ImageBitmap.scaledToFit(maxDimensionPx: Int): ImageBitmap {
    val longest = maxOf(width, height)
    if (maxDimensionPx <= 0 || longest <= maxDimensionPx) return this
    val ratio = maxDimensionPx.toFloat() / longest
    val targetWidth = (width * ratio).toInt().coerceAtLeast(1)
    val targetHeight = (height * ratio).toInt().coerceAtLeast(1)
    val output = ImageBitmap(targetWidth, targetHeight)
    Canvas(output).drawImageRect(
        image = this,
        dstOffset = IntOffset.Zero,
        dstSize = IntSize(targetWidth, targetHeight),
        paint = Paint().apply { filterQuality = FilterQuality.Medium },
    )
    return output
}
