package com.rovecamlink.app.core.qr

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rovecamlink.app.Res
import com.rovecamlink.app.qr_unavailable_ios
import top.yukonga.miuix.kmp.basic.Text
import org.jetbrains.compose.resources.stringResource

/**
 * iOS QR scanning is not wired up yet (AVFoundation + Vision pipeline). The iOS
 * build is a scaffold, so this keeps the shared UI compiling.
 */
@Composable
actual fun QrScanScreen(onResult: (QrWifiCredentials?) -> Unit, onClose: () -> Unit) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(stringResource(Res.string.qr_unavailable_ios))
    }
}
