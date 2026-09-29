package com.rovecamlink.app.core.update

import com.rovecamlink.app.core.prefs.AppPrefs
import com.rovecamlink.app.core.prefs.MemoryAppPrefs

/**
 * In memory only, matching the iOS prefs actual: no persisted bookkeeping exists on this
 * platform yet (see `AppPrefs.ios.kt`). The key matches the Android actual so a future
 * persisted backend reads the same field.
 */
private class MemoryUpdateChannelStore(private val prefs: AppPrefs) : UpdateChannelStore {
    override fun channel(): UpdateChannel = UpdateChannel.fromId(prefs.getString(KEY))
    override fun setChannel(channel: UpdateChannel) {
        prefs.putString(KEY, channel.id)
    }

    companion object {
        private const val KEY = "update_channel"
    }
}

actual fun createUpdateChannelStore(): UpdateChannelStore = MemoryUpdateChannelStore(MemoryAppPrefs())
