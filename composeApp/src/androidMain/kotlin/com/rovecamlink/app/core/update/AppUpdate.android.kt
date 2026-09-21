package com.rovecamlink.app.core.update

import android.content.Intent
import androidx.core.content.FileProvider
import com.rovecamlink.app.RoveCamApp
import com.rovecamlink.app.core.transport.CameraHttp
import java.io.File

actual suspend fun applyAppUpdate(info: AppUpdateInfo, http: CameraHttp): String? {
    val apkUrl = info.apkUrl ?: return "No Android package attached to this release"
    val bytes = http.getBytes(apkUrl) ?: return "Download failed"
    val dir = File(RoveCamApp.appContext.cacheDir, "app-update").apply { mkdirs() }
    val apk = File(dir, "rovecamlink-${info.version}.apk")
    apk.writeBytes(bytes)
    val authority = "${RoveCamApp.appContext.packageName}.fileprovider"
    val uri = FileProvider.getUriForFile(RoveCamApp.appContext, authority, apk)
    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(uri, "application/vnd.android.package-archive")
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }
    RoveCamApp.appContext.startActivity(intent)
    return "Installing v${info.version}…"
}