package com.rovecamlink.app.core.qr

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rovecamlink.app.Res
import com.rovecamlink.app.cancel
import com.rovecamlink.app.qr_unavailable_ios
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.Text
import org.jetbrains.compose.resources.stringResource

/**
 * iOS QR scanning is not wired up yet (AVFoundation + Vision pipeline). The iOS
 * build is a scaffold, so this keeps the shared UI compiling.
 */
@Composable
actual fun QrScanScreen(
    outerPadding: PaddingValues,
    onResult: (QrWifiCredentials?) -> Unit,
    onClose: () -> Unit,
) {
    // Same contract as the Android scanner: the notice is centred, but the way out clears
    // the shell's bar rather than sitting under it.
    Box(
        Modifier.fillMaxSize().padding(outerPadding),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(stringResource(Res.string.qr_unavailable_ios))
            Spacer(Modifier.height(16.dp))
            Button(onClick = onClose) { Text(stringResource(Res.string.cancel)) }
        }
    }
}
