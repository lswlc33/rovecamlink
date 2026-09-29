package com.rovecamlink.app.core.update

/**
 * No-op. Opening a URL needs `UIApplication.shared.open` on the main actor, which the
 * shared framework's non-main entry points cannot reach — and iOS has no camera support
 * yet, so the update page is not reachable on this platform anyway. Reporting failure is
 * the honest shape; the UI shows the URL as text instead of pretending a browser opened.
 */
private class IosUrlOpener : UrlOpener {
    override fun open(url: String): Boolean = false
}

actual fun createUrlOpener(): UrlOpener = IosUrlOpener()
