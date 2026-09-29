package com.rovecamlink.app.core.update

import java.awt.Desktop
import java.net.URI

/** `Desktop.browse` — the desktop window has no in-app browser to hand to. */
private class DesktopUrlOpener : UrlOpener {
    override fun open(url: String): Boolean = runCatching {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(URI(url))
            true
        } else {
            false
        }
    }.getOrDefault(false)
}

actual fun createUrlOpener(): UrlOpener = DesktopUrlOpener()
