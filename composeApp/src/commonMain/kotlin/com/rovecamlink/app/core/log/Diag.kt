package com.rovecamlink.app.core.log

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import okio.BufferedSink
import okio.FileSystem
import okio.Path
import okio.buffer
import okio.use
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

/**
 * Carries the current operation id down every nested suspend call, so the HTTP
 * layer can stamp `op=17:capture` on a request it knows nothing about.
 */
class OpContext(val id: String) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<OpContext>
}

/**
 * The app-wide diagnostic logger — the single source of the TXT files a user
 * submits for analysis.
 *
 * **Threading.** Producers ([at], [i], [w], [fail], …) run on any thread (Ktor's
 * CIO workers, the UI frame thread, Wi-Fi callbacks). They build one [LogRecord]
 * and `trySend` it into an unlimited [inbox]: never blocking, never throwing. One
 * consumer coroutine on a single-permit dispatcher owns the ring buffer, sequence
 * numbers, [LogStats], the sampling state and the file sink, so none of that needs
 * locks. Reads ([tail], [exportBundle]) travel through the same queue, which is
 * what makes [awaitDrained] a real barrier for tests and for "flush, then export".
 *
 * **Steady state.** A 1.5 s status poll is five CGI GETs, so a raw five-minute
 * session is ~20k lines. Repeatable exchanges ([LogRecord.sampleKey]) therefore
 * keep their first occurrence plus every [SAMPLE_EVERY]-th one, annotated with the
 * run's count/avg/max; the hidden members stay in the ring at TRACE, so switching
 * the preview to TRACE reveals them retroactively. Any status change, non-2xx or
 * failure breaks the run and is written in full. That keeps the summary honest
 * while making the anomalies — the only part worth reading — impossible to miss.
 */
object Diag {

    /** Grammar id written into every export. */
    const val FORMAT_ID: String = "rovdiag/1"

    /** One line of every N identical exchanges is kept at full level. */
    const val SAMPLE_EVERY: Int = 20

    val config = LogConfig()

    private val tz: TimeZone = TimeZone.currentSystemDefault()
    private val startWallMillis: Long = Clock.System.now().toEpochMilliseconds()
    private val startMono: Long = monotonicMillis()

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private val workerCtx = Dispatchers.Default.limitedParallelism(1)
    private val inbox = Channel<Msg>(Channel.UNLIMITED)
    private val idMutex = Mutex()

    /** Device/session lines for the export header; wired by AppGraph → AppState. */
    var envProvider: (() -> List<Pair<String, String>>)? = null

    private sealed interface Msg {
        class Add(val record: LogRecord, val stats: ((LogStats) -> Unit)?) : Msg
        class Tail(val n: Int, val level: LogLevel?, val query: String?, val reply: CompletableDeferred<List<LogRecord>>) : Msg
        class Bundle(val reply: CompletableDeferred<String>) : Msg
        class FullBundle(val reply: CompletableDeferred<String>) : Msg
        class Count(val reply: CompletableDeferred<Int>) : Msg
        class SessionFile(val reply: CompletableDeferred<String?>) : Msg
        class Clear(val reply: CompletableDeferred<Unit>) : Msg
        class Drain(val reply: CompletableDeferred<Unit>) : Msg
    }

    /** Consecutive occurrences of one repeatable exchange. Owned by the writer. */
    private class Run {
        var count = 0
        var totalMs = 0L
        var maxMs = 0L
        var sinceElapsed = 0L
        var lastStatus = 0
    }

    /** State owned exclusively by the consumer coroutine. */
    private class Writer {
        val ring = ArrayDeque<LogRecord>()
        val stats = LogStats()
        val runs = HashMap<String, Run>()
        var seq = 0
        var sinceFlush = 0
        var file: BufferedSink? = null
        var filePath: Path? = null
        var fileError: String? = null

        fun ensureFile(dir: Path?) {
            if (filePath != null || !config.fileSink) return
            if (dir == null) {
                if (fileError == null) fileError = "no log directory available"
                return
            }
            val target = dir / "rovcamlink-${fileNameStamp(startWallMillis)}.txt"
            runCatching {
                FileSystem.SYSTEM.createDirectories(dir)
                pruneOld(dir)
                file = FileSystem.SYSTEM.appendingSink(target).buffer()
                filePath = target
                fileError = null
            }.onFailure { fileError = it.message }
        }

        private fun pruneOld(dir: Path) {
            runCatching {
                FileSystem.SYSTEM.list(dir)
                    // `rovcamlink-log-*` are user exports (Save TXT writes into the same
                    // directory); only the rolling session files may be pruned.
                    .filter { isSessionFile(it.name) }
                    .sortedByDescending { it.name }
                    .drop(KEEP_FILES)
                    .forEach { old -> runCatching { FileSystem.SYSTEM.delete(old) } }
            }
        }

        fun write(text: String) {
            if (!config.fileSink) return
            val f = file ?: return
            runCatching { f.writeUtf8(text).writeUtf8("\n") }
        }

        fun flush() {
            runCatching { file?.flush() }
            sinceFlush = 0
        }
    }

    private val w = Writer()

    /** A persisted session file staged for the full export (records + span filled by [analyze]). */
    private class RunFile(val name: String, val path: Path, val bytes: Long) {
        var content: String = ""
        var records = 0
        var firstWall = ""
        var lastWall = ""
        /** Set when a run too big for the budget was sliced to its most recent tail. */
        var contentTruncated = false
    }

    init {
        scope.launch(workerCtx) {
            for (m in inbox) {
                // One bad message must never retire the logger: a dead consumer would
                // silently keep `at()` accepting records into an inbox nobody reads,
                // and would leave every reader waiting on a reply that never comes.
                try {
                    when (m) {
                        is Msg.Add -> handle(m)
                        is Msg.Tail -> m.reply.complete(readTail(m.n, m.level, m.query))
                        is Msg.Bundle -> {
                            w.flush()
                            m.reply.complete(bundle())
                        }

                        is Msg.FullBundle -> {
                            // Flush first so the current run's trailing lines are on disk
                            // and the file replay below sees them too.
                            w.flush()
                            m.reply.complete(fullBundle())
                        }

                        is Msg.Count -> m.reply.complete(w.ring.size)
                        is Msg.SessionFile -> m.reply.complete(w.filePath?.toString())
                        is Msg.Clear -> {
                            // "Clear" means start over, so the summary has to match the
                            // records that are still there. Sequence numbers stay monotonic:
                            // an id already printed must never describe a different line.
                            w.ring.clear()
                            w.runs.clear()
                            m.reply.complete(Unit)
                        }

                        is Msg.Drain -> {
                            w.flush()
                            m.reply.complete(Unit)
                        }
                    }
                } catch (t: Throwable) {
                    failQuietly(m, t)
                }
            }
        }
        // Heartbeat flush: a crash must not cost more than ~2s of trailing lines.
        scope.launch(workerCtx) {
            while (true) {
                delay(FLUSH_HEARTBEAT_MS)
                w.flush()
            }
        }
    }

    /** Report a writer failure, then let the waiting reader go with what it can have. */
    private fun failQuietly(m: Msg, t: Throwable) {
        val now = Clock.System.now().toEpochMilliseconds()
        val rec = LogRecord(
            LogLevel.ERROR, LogTag.LOG, null,
            "writer failed on ${m::class.simpleName}: ${LogFormat.field(causeChain(t))}",
            now, monotonicMillis() - startMono,
        )
        // The writer owns this state, so it can still record without going through the queue.
        rec.seq = ++w.seq
        w.ring.addLast(rec)
        w.stats.observe(rec)
        runCatching {
            w.write(LogFormat.line(rec, tz))
            w.flush()
        }
        when (m) {
            is Msg.Tail -> m.reply.complete(w.ring.toList())
            is Msg.Bundle -> m.reply.complete("(log bundle failed: ${LogFormat.field(t.message)})")
            is Msg.FullBundle -> m.reply.complete("(log bundle failed: ${LogFormat.field(t.message)})")
            is Msg.Count -> m.reply.complete(w.ring.size)
            is Msg.SessionFile -> m.reply.complete(w.filePath?.toString())
            is Msg.Clear -> m.reply.complete(Unit)
            is Msg.Drain -> m.reply.complete(Unit)
            is Msg.Add -> Unit
        }
    }

    // ======================= writing =======================

    fun enabled(level: LogLevel): Boolean = level.atLeast(config.minLevel)

    /** Milliseconds since the process started, from the monotonic clock. */
    fun uptimeMillis(): Long = monotonicMillis() - startMono

    /** Wall clock of the process start, for "when did this session happen". */
    fun startedAtMillis(): Long = startWallMillis

    /** Device time zone, so a renderer can print the same stamps the file carries. */
    fun timeZone(): TimeZone = tz

    /**
     * Context-free entry point (UI handlers, OS callbacks). [bypassLevel] is used
     * by the HTTP helpers: a sampled-away line is still produced so the writer can
     * count it, and only then demoted to TRACE.
     */
    fun at(
        level: LogLevel,
        tag: LogTag,
        text: String,
        op: String? = null,
        statsOp: ((LogStats) -> Unit)? = null,
        bypassLevel: Boolean = false,
    ) {
        // `paused` is the master switch behind the one-tap toggle: while it is set
        // nothing is accepted at all — not the ring, not the file — so a "logging off"
        // tap genuinely quiets the capture instead of just the disk copy.
        if (config.paused) return
        if (!bypassLevel && !enabled(level)) return
        inbox.trySend(
            Msg.Add(
                LogRecord(
                    level = level,
                    tag = tag,
                    op = op,
                    text = text,
                    epochMillis = Clock.System.now().toEpochMilliseconds(),
                    // Monotonic, so a clock jump when the phone joins the camera hotspot
                    // cannot make the timeline run backwards or stand still.
                    elapsedMillis = monotonicMillis() - startMono,
                ),
                statsOp,
            ),
        )
    }

    /** Non-suspend one-liners for UI handlers and OS callbacks, where there is no ambient op id. */
    fun trace(tag: LogTag, text: String, op: String? = null) = at(LogLevel.TRACE, tag, text, op)
    fun debug(tag: LogTag, text: String, op: String? = null) = at(LogLevel.DEBUG, tag, text, op)
    fun info(tag: LogTag, text: String, op: String? = null) = at(LogLevel.INFO, tag, text, op)
    fun warn(tag: LogTag, text: String, op: String? = null) = at(LogLevel.WARN, tag, text, op)
    fun error(tag: LogTag, text: String, op: String? = null) = at(LogLevel.ERROR, tag, text, op, bypassLevel = true)

    /** Suspend helpers pick up the ambient operation id, so prefer them in coroutines. */
    suspend fun v(tag: LogTag = LogTag.APP, op: String? = null, msg: () -> String) = emitAt(LogLevel.TRACE, tag, op, msg)
    suspend fun d(tag: LogTag = LogTag.APP, op: String? = null, msg: () -> String) = emitAt(LogLevel.DEBUG, tag, op, msg)
    suspend fun i(tag: LogTag = LogTag.APP, op: String? = null, msg: () -> String) = emitAt(LogLevel.INFO, tag, op, msg)
    suspend fun w(tag: LogTag = LogTag.APP, op: String? = null, msg: () -> String) = emitAt(LogLevel.WARN, tag, op, msg)
    suspend fun e(tag: LogTag = LogTag.APP, op: String? = null, msg: () -> String) = emitAt(LogLevel.ERROR, tag, op, msg)

    suspend fun emitAt(level: LogLevel, tag: LogTag, op: String?, msg: () -> String) {
        if (!enabled(level)) return
        at(level, tag, msg(), op ?: currentOp())
    }

    /** ERROR with the cause chain inline, plus the stack as continuation lines at TRACE. */
    suspend fun fail(tag: LogTag, t: Throwable, op: String? = null, msg: () -> String) {
        val text = buildString {
            append(msg())
            append("  throw=").append(LogFormat.field(causeChain(t), config.captureSecrets))
            append(stackSuffix(t))
        }
        at(LogLevel.ERROR, tag, text, op ?: currentOp(), { it.noteThrowable(t) }, bypassLevel = true)
    }

    // ======================= operations =======================

    /**
     * Run [block] as a named operation: allocates the id every nested `op=` column
     * shows, and records BEGIN / END with the outcome and duration.
     */
    suspend fun <T> inOp(name: String, detail: String = "", block: suspend () -> T): T {
        val op = "${nextId()}:$name"
        val t0 = monotonicMillis()
        at(LogLevel.INFO, LogTag.APP, "BEGIN $name" + if (detail.isEmpty()) "" else " $detail", op)
        return try {
            val r = withContext(OpContext(op)) { block() }
            at(
                LogLevel.INFO, LogTag.APP, "END $name ok ${monotonicMillis() - t0}ms", op,
                statsOp = { it.noteOperation(name, true) },
            )
            r
        } catch (t: CancellationException) {
            at(LogLevel.WARN, LogTag.APP, "END $name cancelled ${monotonicMillis() - t0}ms", op)
            throw t
        } catch (t: Throwable) {
            at(
                LogLevel.ERROR, LogTag.APP,
                "END $name FAIL ${monotonicMillis() - t0}ms throw=${LogFormat.safe(causeChain(t))}" +
                    stackSuffix(t), op,
                statsOp = { it.noteOperation(name, false) },
                bypassLevel = true,
            )
            throw t
        }
    }

    /** Record a named operation's outcome when the work isn't wrapped in [inOp]. */
    fun opOutcome(name: String, ok: Boolean, detail: String = "", op: String? = null) {
        at(
            if (ok) LogLevel.INFO else LogLevel.ERROR, LogTag.APP,
            "RESULT $name " + (if (ok) "ok" else "FAIL") + if (detail.isEmpty()) "" else " $detail", op,
            statsOp = { it.noteOperation(name, ok) },
            bypassLevel = !ok,
        )
    }

    /** The ambient operation id, or null outside one. */
    suspend fun currentOp(): String? = coroutineContext[OpContext]?.id

    /** A process-unique id, shared by operations (`op=`) and HTTP exchanges (`#`). */
    suspend fun nextId(): Int = idMutex.withLock { ++localId }

    // ======================= HTTP-shaped logging =======================

    /**
     * A finished HTTP exchange, one line: what we asked for and what came back.
     * [bodyPreview] may be multi-line and is sanitized here.
     */
    suspend fun httpExchange(
        method: String,
        url: String,
        status: Int,
        ms: Long,
        bodyChars: Int,
        contentType: String?,
        headers: String?,
        bodyPreview: String?,
        error: Throwable? = null,
        reqId: Int = -1,
        note: String = "",
    ) {
        // httpExchange posts straight to the inbox, so it has to honour the master
        // switch itself — otherwise a paused toggle would keep capturing every CGI call.
        if (config.paused) return
        val id = if (reqId > 0) reqId else nextId()
        val endpoint = LogFormat.endpointKey(url)
        val safeUrl = LogFormat.redactUrl(url, config.captureSecrets)
        val ok = error == null && status in 200..299
        val level = when {
            error != null -> LogLevel.ERROR
            ok -> LogLevel.INFO
            else -> LogLevel.WARN
        }
        val head = buildString {
            append(method).append(' ').append(safeUrl).append("  -> ")
            if (error != null) {
                append("FAIL ").append(ms).append("ms throw=").append(LogFormat.safe(causeChain(error)))
            } else {
                append(status).append(' ').append(ms).append("ms ").append(bodyChars).append("ch")
                if (!contentType.isNullOrEmpty()) append(" ct=").append(LogFormat.field(contentType))
                if (!headers.isNullOrEmpty()) append(" h=").append(LogFormat.field(headers))
            }
            if (note.isNotEmpty()) append(' ').append(note)
        }
        val body = if (config.captureBodies && bodyPreview != null) {
            LogFormat.bodyBlock(bodyPreview, config.bodyPreviewChars, config.captureSecrets)
                .let { if (it.isEmpty()) "" else "\n$it" }
        } else {
            ""
        }
        val trace = error?.let { stackSuffix(it) } ?: ""
        val now = Clock.System.now().toEpochMilliseconds()
        val rec = LogRecord(
            level, LogTag.HTTP, currentOp(),
            "#$id " + head + body + trace,
            now,
            monotonicMillis() - startMono,
        ).apply {
            // Keyed by endpoint alone: a status change has to break the steady run
            // (see sample()). Media and per-file commands are deliberately NOT keyed,
            // because each one names a different file and "which file failed" is the
            // fact worth keeping.
            sampleKey = if (endpoint.startsWith("media:") || endpoint.startsWith("other:")) null else endpoint
            sampleMs = ms
            sampleStatus = status
        }
        inbox.trySend(
            Msg.Add(rec) { stats ->
                stats.noteRequest(endpoint)
                if (error != null) stats.noteFailure(endpoint, error, ms) else stats.noteResponse(endpoint, status, ms)
            },
        )
    }

    /**
     * A request that is still outstanding after [waitedMs] — logged immediately,
     * because a hung request is the one thing an exchange line cannot tell us.
     */
    suspend fun httpPending(method: String, url: String, waitedMs: Long) {
        val endpoint = LogFormat.endpointKey(url)
        at(
            LogLevel.WARN, LogTag.HTTP,
            "PENDING $method ${LogFormat.redactUrl(url, config.captureSecrets)} waited=${waitedMs}ms endpoint=$endpoint",
            currentOp(),
            bypassLevel = true,
        )
    }

    // ======================= reading / exporting =======================

    /** Newest [n] records after filtering; what the in-app preview renders. */
    suspend fun tail(n: Int = 2_000, level: LogLevel? = null, query: String? = null): List<LogRecord> {
        val reply = CompletableDeferred<List<LogRecord>>()
        inbox.trySend(Msg.Tail(n, level, query, reply))
        return runCatching { reply.await() }.getOrDefault(emptyList())
    }

    suspend fun count(): Int {
        val reply = CompletableDeferred<Int>()
        inbox.trySend(Msg.Count(reply))
        return runCatching { reply.await() }.getOrDefault(0)
    }

    /** Path of the rolling session file, or null when the file sink is off/failed. */
    suspend fun sessionFile(): String? {
        val reply = CompletableDeferred<String?>()
        inbox.trySend(Msg.SessionFile(reply))
        return runCatching { reply.await() }.getOrNull()
    }

    /** Why the file sink isn't writing (null when it is). */
    fun fileSinkError(): String? = if (!config.fileSink) "disabled by config" else w.fileError

    /** Block until every earlier record is stored and the file is flushed. */
    suspend fun awaitDrained() {
        val reply = CompletableDeferred<Unit>()
        inbox.trySend(Msg.Drain(reply))
        runCatching { reply.await() }
    }

    suspend fun clear() {
        val reply = CompletableDeferred<Unit>()
        inbox.trySend(Msg.Clear(reply))
        runCatching { reply.await() }
    }

    /** The TXT a user submits: environment header, records, summary. */
    suspend fun exportBundle(): String {
        val reply = CompletableDeferred<String>()
        inbox.trySend(Msg.Bundle(reply))
        return runCatching { reply.await() }.getOrElse { "export failed: ${it.message}" }
    }

    /** File name for an export of the current session. */
    fun exportName(): String = "rovecamlink-log-${fileNameStamp(startWallMillis)}.txt"

    /**
     * The default export: every persisted session file read back off disk, oldest
     * first, one delimited block per run, plus a top-level index. This is the one
     * that survives a crash — the previous runs are exactly what a dropout report
     * needs and the ring alone cannot show them. Falls back to the current run when
     * the log directory is missing or unreadable.
     */
    suspend fun exportFullBundle(): String {
        val reply = CompletableDeferred<String>()
        inbox.trySend(Msg.FullBundle(reply))
        return runCatching { reply.await() }.getOrElse { "export failed: " + it.message }
    }

    /**
     * File name for the full export. Also `rovcamlink-log-` prefixed — the same
     * invariant that keeps pruneOld from deleting user exports and keeps [fullBundle]
     * from re-importing an earlier export as if it were a run.
     */
    fun exportFullName(): String = "rovcamlink-log-full-" + fileNameStamp(startWallMillis) + ".txt"

    // ======================= one-tap toggle =======================

    /** Master on/off for the whole capture: drives [LogConfig.paused] (see [at]). */
    fun setRecording(on: Boolean) {
        if (config.paused == !on) return // already in the requested state
        if (on) {
            config.paused = false
            at(LogLevel.INFO, LogTag.LOG, "logging resumed", bypassLevel = true)
        } else {
            // Emit the boundary while the capture is still live, THEN go quiet — an
            // at() after paused=true would be dropped and the log would just stop dead.
            at(LogLevel.INFO, LogTag.LOG, "logging paused", bypassLevel = true)
            config.paused = true
        }
    }

    /** Flip the master switch; returns the new enabled state. Wire this to one tap. */
    fun toggleRecording(): Boolean {
        setRecording(config.paused)
        return !config.paused
    }

    /**
     * On/off for the rolling session file only. Unlike [setRecording] the ring keeps
     * filling, so a current-run export still works while the file sink is off.
     */
    fun setFileLogging(on: Boolean) {
        val changed = config.fileSink != on
        config.fileSink = on
        if (changed) at(LogLevel.INFO, LogTag.LOG, "file sink " + if (on) "on" else "off", bypassLevel = true)
    }

    /** Flip the file sink; returns the new state. */
    fun toggleFileLogging(): Boolean {
        setFileLogging(!config.fileSink)
        return config.fileSink
    }

    // ======================= writer =======================

    private fun handle(m: Msg.Add) {
        val r = m.record
        r.seq = ++w.seq
        m.stats?.invoke(w.stats)
        w.stats.observe(r)
        sample(r)

        w.ring.addLast(r)
        while (w.ring.size > config.ringCapacity) {
            w.ring.removeFirst()
            w.stats.ringEvictions++
        }
        if (enabled(r.level)) {
            // Resolving the log directory is a syscall (and on iOS a `mkdir`), so it is
            // only asked for while the session file is still closed.
            if (w.filePath == null) w.ensureFile(runCatching { store.logsDir() }.getOrNull())
            w.write(LogFormat.line(r, tz))
            when {
                r.level.atLeast(LogLevel.WARN) -> w.flush()
                ++w.sinceFlush >= FLUSH_EVERY -> w.flush()
            }
        }
    }

    /**
     * Decide whether this record is "just another identical exchange". Hidden
     * members are demoted to TRACE (still kept, so the preview can reveal them);
     * kept members carry the stats of the run they close.
     *
     * Steady means *identical*, not healthy: a CGI that answers 404 the same way
     * every poll is background noise too, so replies at WARN join the run with
     * their level intact. Anything that produced no reply at all (ERROR) is never
     * demoted, and any change of status restarts the run — so the moment things
     * stop being identical, the next line is written in full.
     */
    private fun sample(r: LogRecord) {
        val key = r.sampleKey ?: return
        if (!config.sampleSteadyTraffic) return
        if (w.runs.size > MAX_RUNS) w.runs.clear()
        val run = w.runs.getOrPut(key) { Run() }

        if (r.level == LogLevel.ERROR) {
            // No reply at all: never demoted, and it ends the steady run. The first
            // replies *after* an outage then have to be visible again, which is the
            // single most useful fact in a dropout report.
            w.runs.remove(key)
            return
        }
        if (run.lastStatus != r.sampleStatus) {
            run.count = 0
            run.totalMs = 0
            run.maxMs = 0
        }
        run.lastStatus = r.sampleStatus

        run.count++
        if (run.count == 1) run.sinceElapsed = r.elapsedMillis
        run.totalMs += r.sampleMs.coerceAtLeast(0)
        run.maxMs = maxOf(run.maxMs, r.sampleMs)
        // The first reply of a kind is always shown, and so is one every
        // SAMPLE_EVERY repeats; everything in between only appears at TRACE.
        val shown = run.count == 1 || (run.count - 1) % SAMPLE_EVERY == 0
        if (!shown) {
            r.level = LogLevel.TRACE
            r.annotation = "(same x${run.count - 1} since +${LogFormat.seconds(run.sinceElapsed)}s" +
                " avg=${run.totalMs / run.count}ms max=${run.maxMs}ms)"
            return
        }
        if (run.count > 1) {
            r.annotation = "run=${run.count} since +${LogFormat.seconds(run.sinceElapsed)}s" +
                " avg=${run.totalMs / run.count}ms max=${run.maxMs}ms"
            // This line is the baseline of the next run, so the window it describes
            // restarts here.
            run.count = 1
            run.totalMs = r.sampleMs.coerceAtLeast(0)
            run.maxMs = r.sampleMs
            run.sinceElapsed = r.elapsedMillis
        }
    }

    private fun readTail(n: Int, level: LogLevel?, query: String?): List<LogRecord> {
        val q = query?.trim()?.lowercase()?.takeIf { it.isNotEmpty() }
        val matches = w.ring.asReversed().asSequence().filter { rec ->
            (level == null || rec.level.atLeast(level)) &&
                (q == null || rec.text.lowercase().contains(q) || rec.tag.id.lowercase().contains(q) ||
                    rec.op?.lowercase()?.contains(q) == true)
        }.take(n).toList()
        return matches.reversed()
    }

    private fun bundle(memoryReason: String? = null): String = buildString(1 shl 16) {
        val lastElapsed = w.ring.lastOrNull()?.elapsedMillis ?: 0L
        append("==== ROVECAMLINK DIAGNOSTIC LOG ====\n")
        append("format=").append(FORMAT_ID).append('\n')
        append(
            "grammar=seq wall(local ISO-8601) +elapsed level tag op=<id>:<name> message. " +
                "A line starting with \"${LogFormat.CONT.trim()}\" belongs to the entry above it. " +
                "run=N since=.. avg=..ms max=..ms means N identical exchanges were sampled into this one. " +
                "Full guide: docs/06-诊断日志系统.md\n",
        )
        append("legend=levels V=trace D=decision I=lifecycle W=degraded E=failure; " +
            "tags ${LogTag.entries.joinToString(",") { it.id }}; " +
            "grep hints \"  -> \" for exchanges, \"BEGIN \"/\"END \" for operations\n")
        append("app.start=").append(LogFormat.wall(startWallMillis, tz)).append('\n')
        append("app.span=+0.000s..+").append(LogFormat.seconds(lastElapsed)).append("s\n")
        append("device.tz=").append(offsetText()).append(" (wall column is device-local)\n")
        append("config: level=").append(config.minLevel.name)
        append(" bodies=").append(if (config.captureBodies) "on" else "off")
        append(" secrets=").append(if (config.captureSecrets) "VERBATIM" else "redacted")
        append(" file=").append(if (config.fileSink) "on" else "off")
        append(" sampling=").append(if (config.sampleSteadyTraffic) "on" else "off")
        append('\n')
        // Platform facts can touch thread-affine APIs (UIDevice on iOS), so a failure
        // here must cost the header line, not the whole bundle.
        runCatching { platformDiagnostics() }.getOrDefault(emptyList())
            .forEach { (k, v) -> append(kvLine(k, v)) }
        runCatching { envProvider?.invoke() }
            .onFailure { append("session_env_unavailable=${LogFormat.safe(it.message)}\n") }
            .getOrNull()
            ?.forEach { (k, v) -> append(kvLine(k, v)) }
        append("session_file=").append(w.filePath?.toString() ?: "(not writing)").append('\n')
        w.fileError?.let { append("session_file_error=").append(LogFormat.safe(it)).append('\n') }
        if (memoryReason != null) {
            // Set only by the full-export fallback: says why earlier runs could not be
            // replayed from disk, so a reader never mistakes this for the whole history.
            append("current_run_only=").append(LogFormat.safe(memoryReason)).append('\n')
        }
        append("==== RECORDS (").append(w.ring.size).append(" in memory")
        if (w.stats.ringEvictions > 0) append(", ").append(w.stats.ringEvictions).append(" evicted")
        append(") ====\n")
        // Same visibility rule as the file sink: sampled-away members are TRACE, so a
        // DEBUG-level export stays compact while `run=` says how many were folded in.
        // Switch the level to TRACE before reproducing to capture every single line.
        append("-- seq numbers skip where a line was sampled away; set level=TRACE for all of them --\n")
        var shown = 0
        w.ring.forEach {
            if (enabled(it.level)) {
                shown++
                append(LogFormat.line(it, tz)).append('\n')
            }
        }
        append("==== (").append(shown).append(" of ").append(w.ring.size)
            .append(" records were at or above the recorded level) ====\n")
        append("==== SUMMARY ====\n")
        append(w.stats.summary(0L, lastElapsed))
        append("==== END ====\n")
    }

    /**
     * The full export. Past runs are replayed from their persisted session files —
     * the only thing a crash-and-relaunch leaves behind — oldest first, one delimited
     * block per run. The current run is embedded verbatim from [bundle], so its env
     * header and statistics are the real ones rather than a guess; the on-disk blocks
     * carry `source=disk` and a file-derived summary instead. Falls back to the live
     * ring when the log directory is missing or unreadable.
     */
    private fun fullBundle(): String {
        val now = Clock.System.now().toEpochMilliseconds()
        val dir = runCatching { store.logsDir() }.getOrNull()
            ?: return bundle("no log directory is configured, so only this run can be exported")
        val listed = runCatching { scanSessionFiles(dir) }
        if (listed.isFailure) {
            return bundle("cannot read the log directory: ${listed.exceptionOrNull()?.message}")
        }
        val currentName = w.filePath?.name
        val history = listed.getOrThrow().filter { it.name != currentName }.sortedBy { it.name }

        // Spend the size budget from the newest history backwards. A dropout report
        // needs the run that just died, so it is the *oldest* files that get dropped,
        // and the current run (bounded by the ring, not the budget) is always included.
        val kept = ArrayList<RunFile>()
        var budget = EXPORT_MAX_BYTES
        var i = history.size - 1
        while (i >= 0) {
            val f = history[i]
            if (f.bytes <= budget) {
                f.content = readText(f.path); analyze(f); kept.add(0, f); budget -= f.bytes
            } else if (kept.isEmpty()) {
                // Even the newest run alone blows the budget: slice it to its most
                // recent tail so a huge session still yields a usable, size-bounded file
                // instead of either dropping everything or emitting an enormous export.
                f.content = trimToTail(readText(f.path), budget)
                f.contentTruncated = true
                analyze(f)
                kept.add(0, f)
                budget = 0
                break
            } else {
                break // whole-file fits ran out; everything older is omitted
            }
            i--
        }
        val dropped = history.filterNot { it in kept }
        val totalRuns = kept.size + 1

        return buildString(1 shl 18) {
            append("==== ROVECAMLINK DIAGNOSTIC LOG - FULL ====\n")
            append("format=").append(FORMAT_ID).append('\n')
            append("export.scope=full (all persisted runs oldest-first + the current run)\n")
            append("app.export=").append(LogFormat.wall(now, tz)).append('\n')
            append("log_dir=").append(LogFormat.field(dir.toString(), config.captureSecrets)).append('\n')
            append("history_budget=").append(LogFormat.size(EXPORT_MAX_BYTES)).append('\n')
            append("legend=every run sits between \"==== RUN n ====\" and \"==== END RUN n ====\"; ")
                .append("source=disk = replayed from a file, source=memory = this live run. ")
                .append("Per-run grammar is unchanged (see the current-run block's own legend).\n")

            append("==== INDEX ====\n")
            append("runs=").append(totalRuns)
                .append(" from_disk=").append(kept.size)
                .append(" current_run=memory\n")
            var totalRecords = 0
            var runNo = 1
            kept.forEach {
                append("run=").append(runNo).append('/').append(totalRuns)
                    .append(" source=disk file=").append(it.name)
                    .append(" bytes=").append(LogFormat.size(it.bytes))
                    .append(" records=").append(it.records)
                    .append(" span=").append(it.firstWall).append("..").append(it.lastWall).append('\n')
                totalRecords += it.records
                runNo++
            }
            append("run=").append(runNo).append('/').append(totalRuns)
                .append(" source=memory file=").append(currentName ?: "(no session file yet)")
                .append(" records=").append(w.ring.size)
                .append(" span=").append(LogFormat.wall(startWallMillis, tz)).append("..").append(LogFormat.wall(now, tz))
                .append('\n')
            totalRecords += visibleRingCount()
            append("total_records=").append(totalRecords).append('\n')
            if (dropped.isNotEmpty()) {
                append("TRUNCATED_OLDER_RUNS=").append(dropped.size)
                    .append(" omitted to stay under ").append(LogFormat.size(EXPORT_MAX_BYTES))
                    .append(": ").append(dropped.joinToString(" ") { it.name }).append('\n')
                append("note=oldest runs dropped first; lower the level or shorten the session to keep all of them\n")
            }
            append("==== END INDEX ====\n\n")

            runNo = 1
            kept.forEach {
                append("==== RUN ").append(runNo).append('/').append(totalRuns)
                    .append(" source=disk file=").append(it.name)
                    .append(" records=").append(it.records)
                    .append(" span=").append(it.firstWall).append("..").append(it.lastWall)
                    .append(" ====\n")
                append("format=").append(FORMAT_ID).append('\n')
                append("==== RECORDS (").append(it.records).append(" read from disk) ====\n")
                append(it.content)
                if (!it.content.endsWith("\n")) append('\n')
                append("==== SUMMARY (from file) ====\n")
                append("records=").append(it.records)
                    .append(" bytes=").append(it.bytes)
                    .append(" span=").append(it.firstWall).append("..").append(it.lastWall).append('\n')
                if (it.contentTruncated) {
                    append("truncated=run exceeded the ")
                        .append(LogFormat.size(EXPORT_MAX_BYTES))
                        .append(" budget; only its most recent records are shown, older lines omitted\n")
                }
                append("note=endpoint tables and first/last error need the live process; this run has ended\n")
                append("==== END RUN ").append(runNo).append(" ====\n\n")
                runNo++
            }
            // Current run: embed the real bundle so its env header + stats survive intact.
            append("==== RUN ").append(runNo).append('/').append(totalRuns)
                .append(" source=memory (this run, still live) ====\n")
            append(bundle())
            append("==== END RUN ").append(runNo).append(" ====\n")
            append("==== END ====\n")
        }
    }

    /** Records in the ring that a DEBUG-level export would actually print. */
    private fun visibleRingCount(): Int {
        var n = 0
        w.ring.forEach { if (enabled(it.level)) n++ }
        return n
    }

    /** Rolling session files only — never user exports (`rovcamlink-log-*`). */
    private fun scanSessionFiles(dir: Path): List<RunFile> {
        val out = ArrayList<RunFile>()
        FileSystem.SYSTEM.list(dir).forEach { p ->
            if (!isSessionFile(p.name)) return@forEach
            val size = runCatching { FileSystem.SYSTEM.metadata(p).size }.getOrNull() ?: return@forEach
            out.add(RunFile(p.name, p, size))
        }
        return out
    }

    /** One pass over a replayed file: count records and take the first/last wall column. */
    private fun analyze(f: RunFile) {
        f.content.lineSequence().forEach { line ->
            if (line.isEmpty() || line.startsWith(LogFormat.CONT)) return@forEach
            f.records++
            val wall = line.split(' ').getOrNull(1) ?: return@forEach
            if (f.firstWall.isEmpty()) f.firstWall = wall
            f.lastWall = wall
        }
    }

    private fun readText(path: Path): String = runCatching {
        FileSystem.SYSTEM.source(path).buffer().use { it.readUtf8() }
    }.getOrDefault("")

    /**
     * Keep at most [maxBytes] of the newest content from [text], starting on a record
     * boundary (never mid-line, never on an orphan `|  ` continuation), so a tail slice
     * is still valid `rovdiag/1`. The whole file is already in memory here — we only
     * reached this path because that one run alone exceeds the export budget.
     */
    private fun trimToTail(text: String, maxBytes: Long): String {
        val max = maxBytes.toInt().coerceIn(0, text.length)
        if (max >= text.length) return text
        var start = text.length - max
        val nl = text.indexOf('\n', start)
        start = if (nl < 0) text.length else nl + 1 // advance to the next whole line
        while (start < text.length) {
            val end = text.indexOf('\n', start).let { if (it < 0) text.length else it }
            val line = text.substring(start, end)
            if (line.startsWith(LogFormat.CONT) || line.isEmpty()) {
                start = end + 1
            } else break
        }
        return text.substring(start.coerceAtMost(text.length))
    }

    private fun kvLine(key: String, value: String): String = "$key=${LogFormat.field(value, config.captureSecrets)}\n"

    private fun offsetText(): String {
        val min = LogFormat.utcOffsetMinutes(Clock.System.now().toEpochMilliseconds(), tz)
        val sign = if (min < 0) '-' else '+'
        val abs = kotlin.math.abs(min)
        return "$sign${(abs / 60).toString().padStart(2, '0')}:${(abs % 60).toString().padStart(2, '0')}"
    }

    // ======================= shared text helpers =======================

    /** `SocketTimeoutException: Read timed out <- IOException: …` (outermost first). */
    fun causeChain(t: Throwable): String {
        val sb = StringBuilder()
        var cur: Throwable? = t
        var guard = 0
        while (cur != null && guard++ < 6) {
            if (sb.isNotEmpty()) sb.append(" <- ")
            sb.append(cur::class.simpleName ?: "Throwable")
            // Ktor echoes the request URL into its timeout messages, which is where a
            // passphrase would otherwise re-enter the log past the URL masking.
            cur.message?.let { sb.append(": ").append(LogFormat.field(it, config.captureSecrets)) }
            if (cur.cause === cur) break
            cur = cur.cause
        }
        return sb.toString()
    }

    /** A continuation-line stack trace, or "" — so callers never leave a dangling blank line. */
    fun stackSuffix(t: Throwable): String = stackBlock(t).let { if (it.isEmpty()) "" else "\n$it" }

    /** Stack trace as continuation lines — TRACE only, elsewhere it is noise. */
    fun stackBlock(t: Throwable, maxLines: Int = 14): String {
        if (config.minLevel != LogLevel.TRACE) return ""
        val lines = runCatching { t.stackTraceToString().lines() }.getOrDefault(emptyList())
            .filter { it.isNotBlank() }
        return lines.take(maxLines).joinToString("\n") { LogFormat.CONT + LogFormat.field(it, config.captureSecrets) }
    }

    /** `yyyyMMdd-HHmmss` in device-local time, for file names. */
    fun fileNameStamp(epochMillis: Long): String {
        val ldt: LocalDateTime = Instant.fromEpochMilliseconds(epochMillis).toLocalDateTime(tz)
        fun p(v: Int, width: Int = 2) = v.toString().padStart(width, '0')
        return "${p(ldt.year, 4)}${p(ldt.monthNumber)}${p(ldt.dayOfMonth)}-${p(ldt.hour)}${p(ldt.minute)}${p(ldt.second)}"
    }

    private val store: LogStore by lazy { createLogStore() }

    private var localId = 0

    private const val KEEP_FILES = 10
    private const val FLUSH_EVERY = 25
    private const val FLUSH_HEARTBEAT_MS = 2_000L
    private const val MAX_RUNS = 256

    /**
     * Size budget for the *historical* part of a full export (KEEP_FILES can together
     * be tens of MB, far more than a share sheet or a Downloads hand-off should carry).
     * ~6 MiB is roughly sixty thousand lines — comfortably mailable — and when it is
     * exceeded the oldest runs are omitted with an explicit TRUNCATED_OLDER_RUNS note,
     * never silently. The current run sits outside the budget because the ring caps it.
     */
    private const val EXPORT_MAX_BYTES = 6L * 1024 * 1024
}

/**
 * Rolling session files (`rovcamlink-<stamp>.txt`) are the only things the writer
 * prunes and the only things a full export replays. User exports — both the
 * current-run `rovcamlink-log-<stamp>.txt` and the full `rovcamlink-log-full-<stamp>.txt`
 * — share the `rovcamlink-log-` prefix, which keeps them out of pruning AND out of the
 * replay set, so an export can never be deleted by pruning or re-imported as a run.
 * These prefixes must stay in sync with Diag.exportName() / Diag.exportFullName().
 */
private const val SESSION_PREFIX = "rovcamlink-"
private const val EXPORT_PREFIX = "rovcamlink-log-"

private fun isUserExport(name: String): Boolean = name.startsWith(EXPORT_PREFIX)

private fun isSessionFile(name: String): Boolean =
    name.startsWith(SESSION_PREFIX) && name.endsWith(".txt") && !isUserExport(name)
