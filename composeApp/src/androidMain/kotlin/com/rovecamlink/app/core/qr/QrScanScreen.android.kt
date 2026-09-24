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
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.rovecamlink.app.action_scan_qr
import com.rovecamlink.app.cancel
import com.rovecamlink.app.qr_camera_failed
import com.rovecamlink.app.qr_hint_camera_permission
import com.rovecamlink.app.qr_hint_no_wifi
import com.rovecamlink.app.qr_hint_point
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Close
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.stringResource
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.min

@Composable
actual fun QrScanScreen(
    outerPadding: PaddingValues,
    onResult: (QrWifiCredentials?) -> Unit,
    onClose: () -> Unit,
) {
    val context = LocalContext.current
    val lifecycleOwner = context as? LifecycleOwner

    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED,
        )
    }
    // pending 只在解析出 creds 前短暂承载结果;解析失败时把文案挪到独立的 parseFailed,
    // 否则清空 pending 会让「二维码里没有 Wi-Fi 信息」提示在下一帧立即消失。
    // hint 是派生文本,在 Composable 主体中按当前 locale 解析,避免在 LaunchedEffect
    // 协程里调用 stringResource。
    var pending by remember { mutableStateOf<Pair<String, QrWifiCredentials?>?>(null) }
    var parseFailed by remember { mutableStateOf<String?>(null) }
    // 相机拿不到时置位(没有摄像头、模拟器未映射摄像头、被别的应用占用)。没有它这页就是
    // 一整块黑,用户分不清「还在启动」和「永远不会好」。
    var cameraFailed by remember { mutableStateOf(false) }

    LaunchedEffect(hasCameraPermission) {
        if (!hasCameraPermission) {
            hasCameraPermission = PermissionBridge.request(arrayOf(Manifest.permission.CAMERA))
        }
    }

    // 扫到内容后:creds 解析出就直接回调出去;为 null 则记下文案,提示由 parseFailed 派生。
    LaunchedEffect(pending) {
        val pair = pending ?: return@LaunchedEffect
        val creds = pair.second
        if (creds == null) {
            parseFailed = pair.first
            pending = null
        } else {
            onResult(creds)
        }
    }

    val hintPoint = stringResource(Res.string.qr_hint_point)
    val hintCameraPermission = stringResource(Res.string.qr_hint_camera_permission)
    val cancelLabel = stringResource(Res.string.cancel)
    val titleLabel = stringResource(Res.string.action_scan_qr)
    val cameraFailedLabel = stringResource(Res.string.qr_camera_failed)

    // 派生 hint:相机打不开或二维码解析失败时说明原因,否则按权限状态展示默认引导。
    // 把 parseFailed 取到 local val 才能 smart cast 到非空类型。
    val failedLabel = parseFailed
    val hint = when {
        cameraFailed -> cameraFailedLabel
        failedLabel != null -> stringResource(Res.string.qr_hint_no_wifi, failedLabel)
        !hasCameraPermission -> hintCameraPermission
        else -> hintPoint
    }

    BoxWithConstraints(Modifier.fillMaxSize().background(Color.Black)) {
        // 正方形取景框,按较短边取尺寸,横竖屏都不会超出屏幕。它只负责给用户定位;
        // 识别仍是整帧交给 zxing,不做裁剪。
        val frameSide = minOf(maxWidth, maxHeight) * 0.68f

        if (hasCameraPermission && lifecycleOwner != null && !cameraFailed) {
            CameraQrScanner(
                lifecycleOwner = lifecycleOwner,
                onText = { text ->
                    pending = text.take(24) to parseWifiQr(text)
                },
                onFailed = { cameraFailed = true },
            )
        }

        // 预览铺满整屏,控件单独退到安全区内。退让是必需的:外壳的底栏是画在内容之上的,
        // 原来贴底边放的「取消」正好被它盖住,读起来就是「这页没有退出的地方」。
        // outerPadding 由 Scaffold 量出,已含底栏高度与手势条;顶部再避开状态栏。
        Box(
            Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(bottom = outerPadding.calculateBottomPadding()),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = onClose,
                    backgroundColor = Color.Black.copy(alpha = 0.35f),
                ) {
                    Icon(
                        MiuixIcons.Close,
                        contentDescription = cancelLabel,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp),
                    )
                }
                Text(
                    text = titleLabel,
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f),
                )
                // 与关闭按钮等宽,标题才是光学居中的。
                Spacer(Modifier.size(40.dp))
            }

            Column(
                Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    Modifier
                        .size(frameSide)
                        .border(2.dp, Color.White.copy(alpha = 0.85f), RoundedCornerShape(18.dp)),
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = hint,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .background(Color(0xB3000000), RoundedCornerShape(10.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                )
            }

            Button(
                onClick = onClose,
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 24.dp),
            ) { Text(cancelLabel) }
        }
    }
}

@Composable
private fun CameraQrScanner(
    lifecycleOwner: LifecycleOwner,
    onText: (String) -> Unit,
    onFailed: () -> Unit,
) {
    val context = LocalContext.current
    val previewView = remember {
        PreviewView(context).apply { scaleType = PreviewView.ScaleType.FILL_CENTER }
    }
    val analyzerExecutor = remember { Executors.newSingleThreadExecutor() }
    val consumed = remember { AtomicBoolean(false) }

    DisposableEffect(Unit) {
        onDispose {
            // 先解绑再关闭分析线程池:线程池先 shutdown 而相机仍在投递帧时,
            // ImageAnalysis 会往已关闭的 executor 提交而抛 RejectedExecutionException。
            // 用 addListener 回调取 provider,不在主线程用 get() 阻塞等待。
            ProcessCameraProvider.getInstance(context).addListener(
                {
                    runCatching { ProcessCameraProvider.getInstance(context).get().unbindAll() }
                    analyzerExecutor.shutdown()
                },
                ContextCompat.getMainExecutor(context),
            )
        }
    }

    AndroidView(factory = { previewView }, modifier = Modifier.fillMaxSize())

    LaunchedEffect(previewView) {
        val provider = runCatching {
            withContext(Dispatchers.IO) { ProcessCameraProvider.getInstance(context).get() }
        }.getOrNull()
        // 相机服务起不来:报出去让页面说明原因,而不是停在一整块黑上。
        if (provider == null) {
            onFailed()
            return@LaunchedEffect
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
        val bound = runCatching {
            provider.unbindAll()
            provider.bindToLifecycle(
                lifecycleOwner,
                CameraSelector.DEFAULT_BACK_CAMERA,
                preview,
                analysis,
            )
        }
        // 没有后置摄像头,或摄像头已被别处占用:说清楚,别让页面一直黑着。
        if (bound.isFailure) onFailed()
    }
}

/**
 * Copies the Y (luminance) plane out of a YUV_420_888 frame and un-rotates it so
 * zxing sees an upright image. Row stride usually exceeds width, so rows are
 * copied individually.
 */
private fun ImageProxy.toLuminanceSource(): PlanarYUVLuminanceSource? {
    val plane = planes.firstOrNull() ?: return null
    val buffer = plane.buffer
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
