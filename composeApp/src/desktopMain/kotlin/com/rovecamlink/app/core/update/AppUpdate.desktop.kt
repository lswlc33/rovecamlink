package com.rovecamlink.app.core.update

import com.rovecamlink.app.core.transport.CameraHttp
import java.awt.Desktop
import java.net.URI

actual suspend fun applyAppUpdate(info: AppUpdateInfo, http: CameraHttp): String? {
    return runCatching {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(URI(info.releaseUrl))
            "Opening release page for v${info.version}"
        } else {
            "Version v${info.version} available — install the release manually"
        }
    }.getOrNull()
}