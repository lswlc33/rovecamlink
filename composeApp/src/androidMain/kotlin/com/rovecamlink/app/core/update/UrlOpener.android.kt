package com.rovecamlink.app.core.update

import android.content.Intent
import android.net.Uri
import com.rovecamlink.app.androidContext

/** The system browser via `ACTION_VIEW` — the one route a side-loadable APK can be fetched through. */
private class AndroidUrlOpener : UrlOpener {
    override fun open(url: String): Boolean = runCatching {
        androidContext.startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse(url)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
        )
        true
    }.getOrDefault(false)
}

actual fun createUrlOpener(): UrlOpener = AndroidUrlOpener()
