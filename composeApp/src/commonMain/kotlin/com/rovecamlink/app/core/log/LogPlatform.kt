package com.rovecamlink.app.core.log

import okio.Path

/**
 * Where a log file goes and how the user gets it off the device.
 *
 * Everything is best-effort and returns a human-readable location (or null):
 * losing an export must never take down a camera session.
 */
interface LogStore {
    /** Directory the rolling session file is written to; null when unavailable. */
    fun logsDir(): Path?

    /**
     * Copy [content] out to a place the user (and their file manager) can reach.
     * Returns a display path, or null if the platform refused.
     */
    fun save(fileName: String, content: String): String?

    /** Hand [content] to the OS share sheet. Returns false when there is none. */
    fun share(fileName: String, content: String): Boolean
}

/** Monotonic milliseconds since boot — never wall time, so NTP/DST jumps can't reorder spans. */
expect fun monotonicMillis(): Long

/** OS/build facts for the export header (model, OS version, app version, ABI…). */
expect fun platformDiagnostics(): List<Pair<String, String>>

expect fun createLogStore(): LogStore
