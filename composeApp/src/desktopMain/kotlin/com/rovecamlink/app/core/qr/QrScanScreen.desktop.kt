package com.rovecamlink.app.core.qr

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.robinpcrd.cupertino.CupertinoText

/** QR scanning needs a camera pipeline; the desktop build connects by IP instead. */
@Composable
actual fun QrScanScreen(onResult: (QrWifiCredentials?) -> Unit, onClose: () -> Unit) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CupertinoText("QR scanning is not available on desktop — use Manual connect.")
    }
}
