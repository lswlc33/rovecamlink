package com.rovecamlink.app.core.qr

import android.Manifest
import android.content.pm.PackageManager
import android.util.Size
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.zxing.BinaryBitmap
import com.google.zxing.DecodeHintType
import com.google.zxing.PlanarYUVLuminanceSource
import com.google.zxing.common.HybridBinarizer
import com.google.zxing.qrcode.QRCodeReader
import com.rovecamlink.app.PermissionBridge
import com.rovecamlink.app.Res
import com.rovecamlink.app.cancel
import com.rovecamlink.app.qr_hint_camera_permission
import com.rovecamlink.app.qr_hint_no_wifi
import com.rovecamlink.app.qr_hint_point
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Text
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.stringResource
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.min

@Composable
actual fun QrScanScreen(onResult: (QrWifiCredentials?) -> Unit, onClose: () -> Unit) {
    val context = LocalContext.current
    val lifecycleOwner = context as? LifecycleOwner

    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED,
        )
    }
    // pending == null ⇒ 还未扫到;非 null 但 second == null ⇒ 扫到了但无法解析出 Wi-Fi。
    // hint 是这两个状态的派生文本,在 Composable 主体中按当前 locale 解析,避免在
    // LaunchedEffect 协程里调用 stringResource。
    var pending by remember { mutableStateOf<Pair<String, QrWifiCredentials?>?>(null) }

    LaunchedEffect(hasCameraPermission) {
        if (!hasCameraPermission) {
            hasCameraPermission = PermissionBridge.request(arrayOf(Manifest.permission.CAMERA))
        }
    }

    // 扫到内容后:creds 解析出就直接回调出去;为 null 则清掉 pending 回到默认态,
    // 派生 hint 会自动重算为「二维码里没有 Wi-Fi 信息」。
    LaunchedEffect(pending) {
        val pair = pending ?: return@LaunchedEffect
        val creds = pair.second
        if (creds == null) {
            pending = null
        } else {
            onResult(creds)
        }
    }

    val hintPoint = stringResource(Res.string.qr_hint_point)
    val hintCameraPermission = stringResource(Res.string.qr_hint_camera_permission)
    val cancelLabel = stringResource(Res.string.cancel)

    // 派生 hint:扫码解析失败时显示带 label 的提示;否则按权限状态展示默认引导。
    // 把 pending 取到 local val 才能 smart cast 到非空类型。
    val pendingSnapshot = pending
    val hint = when {
        pendingSnapshot != null && pendingSnapshot.second == null ->
            stringResource(Res.string.qr_hint_no_wifi, pendingSnapshot.first)
        !hasCameraPermission -> hintCameraPermission
        else -> hintPoint
    }

    Box(Modifier.fillMaxSize().background(Color.Black)) {
        if (hasCameraPermission && lifecycleOwner != null) {
            CameraQrScanner(
                lifecycleOwner = lifecycleOwner,
                onText = { text ->
                    pending = text.take(24) to parseWifiQr(text)
                },
            )
        }

        Column(
            Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = hint,
                color = Color.White,
                modifier = Modifier
                    .background(Color(0xB3000000), RoundedCornerShape(10.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp),
            )
            Button(
                onClick = onClose,
                colors = ButtonDefaults.buttonColors(),
            ) { Text(cancelLabel) }
        }
    }
}

@Composable
private fun CameraQrScanner(lifecycleOwner: LifecycleOwner, onText: (String) -> Unit) {
    val context = LocalContext.current
    val previewView = remember {
        PreviewView(context).apply { scaleType = PreviewView.ScaleType.FILL_CENTER }
    }
    val analyzerExecutor = remember { Executors.newSingleThreadExecutor() }
    val consumed = remember { AtomicBoolean(false) }

    DisposableEffect(Unit) {
        onDispose {
            analyzerExecutor.shutdown()
            runCatching { ProcessCameraProvider.getInstance(context).get().unbindAll() }
        }
    }

    AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())

    LaunchedEffect(previewView) {
        val provider = withContext(Dispatchers.IO) {
            ProcessCameraProvider.getInstance(context).get()
        }
        val reader = QRCodeReader()
        val hints = mapOf(DecodeHintType.TRY_HARDER to true)

        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(previewView.surfaceProvider)
        }
        val analysis = ImageAnalysis.Builder()
            .setTargetResolution(Size(640, 480))
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()
            .also {
                it.setAnalyzer(analyzerExecutor) { proxy ->
                    if (consumed.get()) {
                        proxy.close()
                        return@setAnalyzer
                    }
                    try {
                        val source = proxy.toLuminanceSource()
                        if (source != null) {
                            val text = runCatching {
                                reader.decode(BinaryBitmap(HybridBinarizer(source)), hints).text
                            }.getOrNull()
                            if (!text.isNullOrBlank()) {
                                consumed.set(true)
                                onText(text)
                            }
                        }
                    } finally {
                        proxy.close()
                    }
                }
            }
        runCatching {
            provider.unbindAll()
            provider.bindToLifecycle(
                lifecycleOwner,
                CameraSelector.DEFAULT_BACK_CAMERA,
                preview,
                analysis,
            )
        }
    }
}

/**
 * Copies the Y (luminance) plane out of a YUV_420_888 frame and un-rotates it so
 * zxing sees an upright image. Row stride usually exceeds width, so rows are
 * copied individually.
 */
private fun ImageProxy.toLuminanceSource(): PlanarYUVLuminanceSource? {
    val plane = planes.firstOrNull() ?: return null
    val buffer = plane.buffer ?: return null
    val w = width
    val h = height
    if (w <= 0 || h <= 0) return null
    val rowStride = plane.rowStride

    val gray = ByteArray(w * h)
    buffer.rewind()
    if (rowStride == w) {
        buffer.get(gray, 0, min(buffer.remaining(), gray.size))
    } else {
        val row = ByteArray(rowStride)
        var y = 0
        while (y < h && buffer.hasRemaining()) {
            val toRead = min(rowStride, buffer.remaining())
            buffer.get(row, 0, toRead)
            System.arraycopy(row, 0, gray, y * w, min(w, toRead))
            y++
        }
    }

    val rotated = when (imageInfo.rotationDegrees) {
        90 -> rotate90CW(gray, w, h)
        270 -> rotate270CW(gray, w, h)
        180 -> Triple(rotate180(gray, w, h), w, h)
        else -> Triple(gray, w, h)
    }
    val (pixels, rw, rh) = rotated
    return PlanarYUVLuminanceSource(pixels, rw, rh, 0, 0, rw, rh, false)
}

private fun rotate90CW(src: ByteArray, w: Int, h: Int): Triple<ByteArray, Int, Int> {
    val nw = h
    val nh = w
    val dst = ByteArray(nw * nh)
    for (y in 0 until h) {
        for (x in 0 until w) {
            dst[x * nw + (h - 1 - y)] = src[y * w + x]
        }
    }
    return Triple(dst, nw, nh)
}

private fun rotate270CW(src: ByteArray, w: Int, h: Int): Triple<ByteArray, Int, Int> {
    val nw = h
    val nh = w
    val dst = ByteArray(nw * nh)
    for (y in 0 until h) {
        for (x in 0 until w) {
            dst[(w - 1 - x) * nw + y] = src[y * w + x]
        }
    }
    return Triple(dst, nw, nh)
}

private fun rotate180(src: ByteArray, w: Int, h: Int): ByteArray {
    val dst = ByteArray(w * h)
    for (y in 0 until h) {
        for (x in 0 until w) {
            dst[(h - 1 - y) * w + (w - 1 - x)] = src[y * w + x]
        }
    }
    return dst
}
