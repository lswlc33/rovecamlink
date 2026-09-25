package com.rovecamlink.app.core.media

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import kotlin.math.max
import kotlin.math.roundToInt

/**
 * [decodeScaledImage] on Android: `BitmapFactory` with `inSampleSize`, then one exact
 * resize on the already-shrunk bitmap.
 *
 * The two-pass shape is the point. `inJustDecodeBounds` reads the JPEG header and returns
 * no pixels, so the size is known before any allocation; `inSampleSize` is then the
 * *coarse* cut — a power of two, and the codec decodes straight to that reduced grid
 * (`inSampleSize = 4` on a 4000 px photo is a 1000 px decode, one sixteenth of the
 * memory). A single-pass `decodeByteArray` + `Bitmap.createScaledBitmap` would allocate
 * the 48 MP frame first and a second copy of it after, which is two full-size bitmaps for
 * one grid cell on a heap class this app has measured at 256 MB.
 *
 * [inSampleSize] is coarse by construction — it only divides by powers of two, so it
 * always lands *above* the requested ceiling — and stopping there is what makes a small
 * photo expensive: a 700 px JPEG has no sample size below 1 and would be cached at 700 px
 * (~2 MB), so sixty of them is the gallery's whole budget spent on thumbnails. The exact
 * resize afterwards is therefore not redundant, it is what makes the ceiling real — and it
 * is affordable precisely because it runs on the already-sampled bitmap, whose long edge
 * the loop below bounds at under twice the request (~2.4 MB worst case, ~0.6 MB retained).
 *
 * Null on a decode failure (`decodeByteArray` answers null for bytes that are not an
 * image) and on a header that reports no size — an empty or truncated download, which must
 * not be cached as a blank thumbnail.
 */
actual fun decodeScaledImage(bytes: ByteArray, maxDimensionPx: Int): ImageBitmap? {
    if (bytes.isEmpty() || maxDimensionPx <= 0) return null
    val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
    BitmapFactory.decodeByteArray(bytes, 0, bytes.size, bounds)
    if (bounds.outWidth <= 0 || bounds.outHeight <= 0) return null
    val options = BitmapFactory.Options().apply {
        inSampleSize = sampleSizeFor(bounds.outWidth, bounds.outHeight, maxDimensionPx)
    }
    val sampled = BitmapFactory.decodeByteArray(bytes, 0, bytes.size, options) ?: return null
    val longest = max(sampled.width, sampled.height)
    if (longest <= maxDimensionPx) return sampled.asImageBitmap()
    val ratio = maxDimensionPx.toFloat() / longest
    val scaled = Bitmap.createScaledBitmap(
        sampled,
        (sampled.width * ratio).roundToInt().coerceAtLeast(1),
        (sampled.height * ratio).roundToInt().coerceAtLeast(1),
        true,
    )
    if (scaled !== sampled) sampled.recycle()
    return scaled.asImageBitmap()
}

/**
 * The largest power of two that still leaves the long edge at or above [maxDimensionPx] —
 * i.e. the smallest sampled image that is not under the ceiling. Recomputed per call
 * rather than cached: it depends only on the header this call just read.
 */
internal fun sampleSizeFor(width: Int, height: Int, maxDimensionPx: Int): Int {
    var sample = 1
    var longest = max(width, height)
    while (longest / 2 >= maxDimensionPx) {
        longest /= 2
        sample *= 2
    }
    return sample
}
