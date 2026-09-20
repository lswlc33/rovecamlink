package com.rovecamlink.app.core.qr

import androidx.compose.runtime.Composable

/**
 * Full-screen QR scanner. [onResult] fires once with the parsed credentials (or
 * null if the scanned code carried nothing usable) and [onClose] when the user
 * backs out. Only Android has a real implementation; other platforms render an
 * unsupported notice.
 */
@Composable
expect fun QrScanScreen(onResult: (QrWifiCredentials?) -> Unit, onClose: () -> Unit)
