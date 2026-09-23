package com.rovecamlink.app.core.qr

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rovecamlink.app.Res
import com.rovecamlink.app.qr_unavailable_desktop
import top.yukonga.miuix.kmp.basic.Text
import org.jetbrains.compose.resources.stringResource

/** QR scanning needs a camera pipeline; the desktop build connects by IP instead. */
@Composable
actual fun QrScanScreen(onResult: (QrWifiCredentials?) -> Unit, onClose: () -> Unit) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(stringResource(Res.string.qr_unavailable_desktop))
    }
}
