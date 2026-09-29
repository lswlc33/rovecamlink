package com.rovecamlink.app.core.update

import com.rovecamlink.app.core.prefs.AppPrefs
import com.rovecamlink.app.core.prefs.MemoryAppPrefs

/**
 * Desktop has no persistence backend yet (the prefs actual is the memory map), so the
 * channel choice lives for one launch — the same honesty every other memory-backed
 * setting here has. The key matches the Android actual so a future persisted desktop
 * backend reads the same field.
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
