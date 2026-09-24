package com.rovecamlink.app.core.qr

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable

/**
 * Full-screen QR scanner. [onResult] fires once with the parsed credentials (or
 * null if the scanned code carried nothing usable) and [onClose] when the user
 * backs out. Only Android has a real implementation; other platforms render an
 * unsupported notice.
 *
 * [outerPadding] is the shell's own content inset. The bottom bar is drawn *over* the
 * body, so a scanner that ignored this would put its controls underneath that bar —
 * which read as 「这页没有退出的地方」 on the device page's 扫描相机二维码 entry.
 */
@Composable
expect fun QrScanScreen(
    outerPadding: PaddingValues,
    onResult: (QrWifiCredentials?) -> Unit,
    onClose: () -> Unit,
)
