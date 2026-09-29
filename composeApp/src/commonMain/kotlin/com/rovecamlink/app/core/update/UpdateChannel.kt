package com.rovecamlink.app.core.update

/**
 * Which release channel the in-app updater looks at.
 *
 * [Alpha] is the fast lane — every push to main produces a signed build whose tag is
 * `alpha-<timestamp>` (or `nightly-<timestamp>` before the rename, which this channel
 * keeps reading so history stays reachable). [Stable] is the tagged `vX.Y.Z` line.
 * The two are not a version ladder but a choice of *question*: alpha answers "what did
 * main just produce", stable answers "what is the newest tagged release".
 */
enum class UpdateChannel(val id: String) {
    Alpha("alpha"),
    Stable("stable");

    companion object {
        /** Parses a stored id; anything unreadable falls back to [Alpha], the default. */
        fun fromId(id: String?): UpdateChannel = entries.firstOrNull { it.id == id } ?: Alpha
    }
}

/**
 * Persists the channel choice. Android keeps it in SharedPreferences via [AppPrefs]
 * (`createAppPrefs`); the expect factory below keeps this file free of platform code,
 * and the memory fallback means desktop/iOS simply forget the choice per launch until
 * those platforms grow a persistence backend of their own.
 */
interface UpdateChannelStore {
    fun channel(): UpdateChannel
    fun setChannel(channel: UpdateChannel)
}

/** expect factory; Android persists, the others keep memory only. */
expect fun createUpdateChannelStore(): UpdateChannelStore
