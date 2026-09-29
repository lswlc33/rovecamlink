package com.rovecamlink.app.core.update

/**
 * Hands a URL to the platform's browser. The update page needs exactly this one gesture
 * — open the release it found — and nothing else: the APK is *not* downloaded by the app
 * (Android's installer, not this process, owns side-loading), so there is no second
 * consumer to generalise for.
 */
interface UrlOpener {
    /** True when the platform took the URL. False means the UI must show it for a long-press copy. */
    fun open(url: String): Boolean
}

expect fun createUrlOpener(): UrlOpener
