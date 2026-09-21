package com.rovecamlink.app.core.log

/**
 * Aggregates kept alongside the records so an exported file starts with the
 * diagnosis instead of ending with it. With a 1.5 s status poll, a five-minute
 * session is thousands of lines; these counters answer "what actually broke"
 * before a single line is read.
 *
 * Only the writer coroutine touches an instance, so the maps need no
 * synchronisation (see [Diag]).
 */
class LogStats {

    class Endpoint {
        var count = 0

        /** Replies that actually arrived — the denominator for [avgMs]; requests never answered would skew it low. */
        var answered = 0
        var failures = 0
        var non2xx = 0
        var totalMs = 0L
        var maxMs = 0L
        var lastStatus = 0
        var lastError: String? = null

        fun avgMs(): Long = if (answered > 0) totalMs / answered else 0
    }

    val levels = LinkedHashMap<LogLevel, Int>()
    val tags = LinkedHashMap<LogTag, Int>()
    val endpoints = LinkedHashMap<String, Endpoint>()
    val exceptions = LinkedHashMap<String, Int>()

    /** operation name -> [successes, failures] */
    val operations = LinkedHashMap<String, IntArray>()

    var recordsSeen = 0
    var ringEvictions = 0
    var httpRequests = 0
    var httpResponses = 0
    var httpFailures = 0
    var firstErrorRef: String? = null
    var lastErrorRef: String? = null

    /** Cap so a camera that names files per-second can't grow the table forever. */
    private val maxEndpoints = 48

    fun observe(r: LogRecord) {
        recordsSeen++
        levels[r.level] = (levels[r.level] ?: 0) + 1
        tags[r.tag] = (tags[r.tag] ?: 0) + 1
        if (r.level == LogLevel.ERROR) {
            val ref = "#${r.seq} ${r.tag.id} ${r.text.take(90)}"
            if (firstErrorRef == null) firstErrorRef = ref
            lastErrorRef = ref
        }
    }

    fun noteRequest(endpoint: String) {
        httpRequests++
        endpoint(endpoint).count++
    }

    fun noteResponse(endpoint: String, status: Int, ms: Long) {
        httpResponses++
        val e = endpoint(endpoint)
        e.answered++
        e.totalMs += ms
        if (ms > e.maxMs) e.maxMs = ms
        e.lastStatus = status
        if (status !in 200..299) {
            e.non2xx++
            httpFailures++
        }
    }

    /**
     * A request that produced nothing usable. It counts against the endpoint and its
     * elapsed time is kept in the total, but it does **not** join the average: mixing
     * "no answer after 20s" into `avg_ms` would hide the healthy latency that is the
     * comparison the reader needs. Timeouts are visible via `fail` and the max column.
     */
    fun noteFailure(endpoint: String, error: Throwable?, ms: Long) {
        httpFailures++
        val e = endpoint(endpoint)
        e.failures++
        e.totalMs += ms
        if (ms > e.maxMs) e.maxMs = ms
        e.lastError = error?.let { rootCause(it)::class.simpleName ?: "Throwable" }
        if (error != null) noteThrowable(error)
    }

    /** Count the root cause class, which is what names the real failure. */
    fun noteThrowable(t: Throwable) {
        val name = rootCause(t)::class.simpleName ?: "Throwable"
        exceptions[name] = (exceptions[name] ?: 0) + 1
    }

    fun noteOperation(name: String, ok: Boolean) {
        val row = operations.getOrPut(name) { IntArray(2) }
        row[if (ok) 0 else 1]++
    }

    private fun endpoint(key: String): Endpoint {
        val existing = endpoints[key]
        if (existing != null) return existing
        if (endpoints.size >= maxEndpoints) {
            return endpoints.getOrPut("<other>") { Endpoint() }
        }
        return endpoints.getOrPut(key) { Endpoint() }
    }

    /** The bottom of a `cause` chain — the class that actually explains a socket failure. */
    fun rootCause(t: Throwable): Throwable {
        var cur = t
        var guard = 0
        while (cur.cause != null && cur.cause !== cur && guard++ < 8) cur = cur.cause!!
        return cur
    }

    /** The `==== SUMMARY ====` block of an export. */
    fun summary(t0: Long, t1: Long): String = buildString {
        appendLine("span=+${LogFormat.seconds(t0)}s..+${LogFormat.seconds(t1)}s")
        appendLine("records=$recordsSeen produced (before sampling) ring_evictions=$ringEvictions")
        append("levels=")
        appendLine(if (levels.isEmpty()) "none" else LogLevel.entries.mapNotNull { l ->
            levels[l]?.let { "$it:${l.name.lowercase()}" }
        }.joinToString(" "))
        append("tags=")
        appendLine(tags.entries.joinToString(" ") { (k, v) -> "$v:${k.id.lowercase()}" }.ifEmpty { "none" })
        appendLine("http: requests=$httpRequests responses=$httpResponses failures=$httpFailures")
        if (exceptions.isNotEmpty()) {
            append("socket_errors=")
            appendLine(exceptions.entries.sortedByDescending { it.value }
                .joinToString(" ") { (k, v) -> "$v*$k" })
        }
        if (operations.isNotEmpty()) {
            append("operations=")
            appendLine(operations.entries.joinToString(" ") { (k, v) ->
                if (v[1] > 0) "$k ${v[0]}ok/${v[1]}FAIL" else "$k ${v[0]}ok"
            })
        }
        appendLine("first_error=${firstErrorRef ?: "none"}")
        appendLine("last_error=${lastErrorRef ?: "none"}")
        if (endpoints.isNotEmpty()) {
            appendLine("endpoint                    n answered fail non2xx  avg_ms  max_ms  last")
            endpoints.entries.sortedByDescending { it.value.count }.forEach { (name, e) ->
                appendLine(
                    name.padEnd(27) +
                        e.count.toString().padStart(4) +
                        e.answered.toString().padStart(9) +
                        e.failures.toString().padStart(5) +
                        e.non2xx.toString().padStart(7) +
                        e.avgMs().toString().padStart(8) +
                        e.maxMs.toString().padStart(9) +
                        "  " + (e.lastStatus.takeIf { it != 0 }?.let { "HTTP $it" } ?: e.lastError ?: "-"),
                )
            }
        }
    }
}
