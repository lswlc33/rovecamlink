package com.rovecamlink.app.core.log

/**
 * Severity of a [LogRecord].
 *
 * The letters are what appears in the exported file (see [LogFormat]), so they
 * are part of the on-disk grammar: `V D I W E`.
 */
enum class LogLevel(val letter: String) {
    /** Wire-level detail: full bodies, per-poll raw maps, sampled-away repeats. Off by default. */
    TRACE("V"),

    /** Decision detail: why a probe/parse/mapping went the way it did. */
    DEBUG("D"),

    /** Lifecycle: phases, operations, transfers, command results. */
    INFO("I"),

    /** Degraded but handled: retries, non-2xx, truncated bodies, dropped state. */
    WARN("W"),

    /** Something the user can see as a failure: unreachable camera, failed command. */
    ERROR("E"),
    ;

    fun atLeast(other: LogLevel): Boolean = ordinal >= other.ordinal
}

/**
 * Subsystem that produced a record. A fixed vocabulary so a submitted log file can
 * be filtered mechanically (`grep " HTTP "`) instead of guessed at.
 */
enum class LogTag(val id: String) {
    /** App lifecycle: phases, UI actions, connection orchestration. */
    APP("APP"),

    /** Runtime permission requests (location / nearby-Wi-Fi / storage). */
    PERM("PERM"),

    /** Joining the camera hotspot and binding sockets to it. */
    WIFI("WIFI"),

    /** Host + protocol discovery (which IP answered, which plugin won). */
    NET("NET"),

    /** Every HTTP exchange with the camera: request, response, failure. */
    HTTP("HTTP"),

    /** Protocol-plugin decisions (probe verdicts, endpoint choice, params). */
    PROTO("PROTO"),

    /** Body -> model parsing (var/JSON parsers, mode + SD-state mapping). */
    PARSE("PARSE"),

    /** Polled device state, and the transitions of each field. */
    STATE("STATE"),

    /** Remote file listing / delete / naming. */
    FILE("FILE"),

    /** Media transfer queue + byte-level progress. */
    DL("DL"),

    /** Firmware update state machine. */
    OTA("OTA"),

    /** RTSP live preview pipeline. */
    PREV("PREV"),

    /** Environment snapshot (device, OS, network, build). */
    DEV("DEV"),

    /** The logging subsystem itself (export, file sink, drops, config). */
    LOG("LOG"),
    ;
}

/**
 * One log entry.
 *
 * Everything except the six constructor arguments is filled in by the writer
 * coroutine ([Diag]), which is the sole owner of a record once it is queued —
 * that is why [level] can be downgraded for sampled traffic without any locking.
 */
class LogRecord(
    var level: LogLevel,
    val tag: LogTag,
    val op: String?,
    val text: String,
    val epochMillis: Long,
    val elapsedMillis: Long,
) {
    /** Monotonic per-process ordinal; assigned by the writer. */
    var seq: Int = 0

    /**
     * Non-null on repeatable exchanges (HTTP). [Diag] counts consecutive
     * occurrences per key and keeps only the first one of a run plus every
     * [Diag.SAMPLE_EVERY]-th, so a five-minute poll loop stays readable.
     */
    var sampleKey: String? = null

    /** Duration this exchange took, for the sampled-run statistics. */
    var sampleMs: Long = -1L

    /** Status code, when the record is an HTTP reply — a change breaks the run. */
    var sampleStatus: Int = 0

    /** Set by the writer on the line that closes a sampled run. */
    var annotation: String? = null
}

/**
 * Runtime switches, all reachable from the in-app diagnostics screen.
 *
 * Written from the UI thread and read from arbitrary producer threads; every
 * field is a single value whose staleness for one record is harmless, and the
 * writer never mutates them, so no lock is taken.
 */
class LogConfig {
    /** Records below this level are dropped before their message is built. */
    var minLevel: LogLevel = LogLevel.DEBUG

    /** Capture request/response bodies (capped by [bodyPreviewChars]). */
    var captureBodies: Boolean = true

    /**
     * Keep query params whose name looks secret (passwords, tokens, seeds).
     * Off by default because exported files leave the phone via share sheets.
     */
    var captureSecrets: Boolean = false

    /** Append records to the rolling session file on disk. */
    var fileSink: Boolean = true

    /**
     * Master record switch. When paused, [Diag.at] drops every record before it
     * reaches the ring or the file — the whole capture goes quiet, not just the
     * disk copy. Used by the one-tap toggle so "logging off" means off.
     */
    var paused: Boolean = false

    /** Collapse steady, repeating HTTP exchanges into sampled lines (see [LogRecord.sampleKey]). */
    var sampleSteadyTraffic: Boolean = true

    /** Max characters of a body kept inline before a truncation marker. */
    var bodyPreviewChars: Int = 1_024

    /** Records held in memory for preview + export. */
    var ringCapacity: Int = 12_000
}
