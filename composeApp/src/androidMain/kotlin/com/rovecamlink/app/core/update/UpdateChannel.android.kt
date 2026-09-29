package com.rovecamlink.app.core.update

import com.rovecamlink.app.core.prefs.AppPrefs

/**
 * SharedPreferences-backed channel store. A separate key namespace in the bookkeeping
 * prefs rather than its own file: this is one string, and the prefs' reason to exist is
 * exactly "facts that must survive a restart".
 */
private class PrefsUpdateChannelStore(private val prefs: AppPrefs) : UpdateChannelStore {
    override fun channel(): UpdateChannel = UpdateChannel.fromId(prefs.getString(KEY))

    override fun setChannel(channel: UpdateChannel) {
        prefs.putString(KEY, channel.id)
    }

    companion object {
        private const val KEY = "update_channel"
    }
}

actual fun createUpdateChannelStore(): UpdateChannelStore =
    PrefsUpdateChannelStore(com.rovecamlink.app.core.prefs.createAppPrefs())
