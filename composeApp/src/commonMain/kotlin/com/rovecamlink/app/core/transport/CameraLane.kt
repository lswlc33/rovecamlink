package com.rovecamlink.app.core.transport

import com.rovecamlink.app.core.log.Diag
import com.rovecamlink.app.core.log.LogTag
import com.rovecamlink.app.core.log.monotonicMillis
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * How a request competes for the camera's single command slot.
 *
 * Ordered so the two things the user feels — pressing the shutter, opening a screen —
 * never wait behind bookkeeping:
 *
 *  - [Command]: user intent (record, capture, mode switch, write a setting, delete).
 *  - [Status]: the keep-alive poll that decides whether the camera is still there.
 *  - [Enumerate]: menu walks, file listings, thumbnails — resumable and effectively
 *    unbounded in number, which is exactly why it must never outrun the two above.
 */
enum class CameraRequestClass { Command, Status, Enumerate }

/**
 * Carries the caller's [CameraRequestClass] into the transport, so protocol code that
 * just says `http.getText(url)` inherits the class of the operation it was called
 * from instead of every call site restating it.
 */
class CameraRequest(val clazz: CameraRequestClass) :
    AbstractCoroutineContextElement(CameraRequest) {
    companion object Key : CoroutineContext.Key<CameraRequest>
}

/** Run [block] with every camera request inside it tagged [clazz]. */
suspend fun <T> withCameraRequest(clazz: CameraRequestClass, block: suspend () -> T): T =
    withContext(CameraRequest(clazz)) { block() }

/** The class for requests in this coroutine; user intent when nobody tagged it. */
suspend fun currentCameraRequest(): CameraRequestClass =
    currentCoroutineContext()[CameraRequest]?.clazz ?: CameraRequestClass.Command

/**
 * One camera request at a time, best class first, with a cooldown while the camera is
 * refusing.
 *
 * These cameras are not web servers. `192.168.0.1` answers as `thttpd/2.29 23May2018`
 * on a Hi3519, and the 2026-09-22 field log pins down what that means in practice: a
 * lone CGI reply takes ~200 ms; two overlapping streams push each other to ~1.3 s; the
 * third concurrent client truncates a response (`EOFException`); and from request #30
 * on **every** connection was refused for the next two minutes — `record.cgi`,
 * `setcurparameter.cgi` and `setsystime.cgi` included, which is what made a perfectly
 * healthy camera look "uninitialized". The parameters were never the problem: in the
 * second before the server stopped accepting sockets, `setsystime.cgi` answered
 * `Success` and `getfilelistinfoios.cgi` returned five clips.
 *
 * The request runs in the *caller's* coroutine — the lane only hands over a slot — so
 * cancellation stays honest: a disconnect that cancels an enumeration releases the
 * slot rather than leaving a worker to finish a request nobody wants any more.
 *
 * The one invariant everything here rests on: **the slot is handed over in a single
 * critical section**, so a null `holder` always means an empty queue and never merely a
 * holder mid-hand-off. Two callers must never hold it at once — the camera answers the
 * overlap by truncating responses and then refusing everything ([CameraLane]'s class
 * comment is the field evidence).
 */
internal class CameraLane(private val key: String) {

    /** Waiters in arrival order; the head by class ordinal gets the next slot. */
    private val waiting = ArrayDeque<Waiter>()
    private val lock = Mutex()
    private var holder: Waiter? = null

    /**
     * How many requests are queued right now.
     *
     * Exists for `CameraLaneTest`: a test that wants to cancel a *queued* request has to
     * know it is queued, and the only alternative is sleeping and hoping — which is how
     * `cancelledWaiterNeverStrandsTheLane` became a coin toss under load (it failed once in
     * the 2026-09-24 verification run and passed on the next, with no code change).
     */
    internal suspend fun waitingCount(): Int = lock.withLock { waiting.size }

    /** Refusal streak → cooldown. Guarded by [lock], like everything above. */
    private var failures = 0
    private var refusedUntil = 0L
    private var lastCooldownLoggedAt = 0L

    /**
     * Run [block] alone against this camera.
     *
     * [verdict] decides whether the answer proves the camera is alive; the default
     * ("not null, not false, not negative") matches every shape the transport returns.
     */
    suspend fun <T> submit(
        clazz: CameraRequestClass,
        verdict: (T) -> Boolean = ::looksAlive,
        block: suspend () -> T,
    ): T {
        val waiter = Waiter(clazz)
        acquire(waiter)
        val startedAt = monotonicMillis()
        try {
            val outcome = try {
                block()
            } catch (t: Throwable) {
                noteResult(ok = false, cause = t.message ?: t::class.simpleName)
                throw t
            }
            val ms = monotonicMillis() - startedAt
            if (ms > SLOW_MS) {
                Diag.debug(LogTag.HTTP, "$key: $clazz served in ${ms}ms (one request at a time)")
            }
            val alive = verdict(outcome)
            noteResult(ok = alive, cause = if (alive) null else "no usable answer")
            return outcome
        } finally {
            // We own the slot from here on; release() only hands it over if nobody
            // revoked it from under us.
            giveUp(waiter)
        }
    }

    /**
     * Take the slot, or queue behind whoever holds it.
     *
     * A waiter whose caller is cancelled removes itself; if the slot was handed to it
     * in that same instant it releases the slot instead, which is the one race this
     * queue has to close or the camera would stay blocked forever.
     */
    private suspend fun acquire(waiter: Waiter) {
        val cooldownLeft = lock.withLock { (refusedUntil - monotonicMillis()).coerceAtLeast(0L) }
        if (cooldownLeft > 0 && waiter.clazz == CameraRequestClass.Enumerate) {
            // Menu walks and thumbnails are what piled the camera on in the first
            // place; while it is refusing, drop them instead of banking a backlog to
            // fire the moment the cooldown ends.
            Diag.debug(LogTag.HTTP, "$key: Enumerate skipped, camera refusing (${cooldownLeft}ms left)")
            throw CameraRefusing("Enumerate skipped during camera cooldown")
        }
        val queued = lock.withLock {
            // `holder == null` is the whole test for a free slot: [giveUp] hands the slot
            // over inside one critical section, so a null holder also means nothing is
            // waiting, and an arrival either takes a genuinely free slot or queues behind
            // whoever holds it.
            //
            // This used to read `holder == null && waiting.none { outranks(it, waiter) }`,
            // which allowed an arriving Command/Status to take a slot that a queued
            // Enumerate was about to be given — but only while the holder was momentarily
            // published as null during the split hand-off, which is the race [giveUp]
            // describes. Priority is decided when the slot is handed over, not on arrival.
            if (holder == null) {
                holder = waiter
                false
            } else {
                waiting.addLast(waiter)
                true
            }
        }
        if (!queued) return
        try {
            waiter.granted.await()
        } catch (t: Throwable) {
            // Cancelled while queued, or after the slot was handed over in the same
            // instant. Both must not leave the lane blocked.
            giveUp(waiter)
            throw t
        }
    }

    /**
     * Drop this waiter's claim: leave the queue, and hand the slot to whoever is next in
     * the **same** critical section.
     *
     * The hand-off must not be split in two. Releasing the slot and promoting the next
     * waiter separately leaves `holder == null` observable in between — and an arriving
     * Command or Status takes any free slot its queued rivals do not outrank, so it claims
     * the very slot the promotion is about to hand out. Both then run their block and the
     * camera gets two overlapping requests, which is the one thing this class exists to
     * prevent (`CameraLaneTest` caught it as `peak == 2`).
     *
     * Keeping `holder` and the queue consistent inside one lock also gives the invariant
     * [acquire] relies on: **a null holder means nothing is queued**, because no path
     * publishes a free slot while waiters are waiting.
     */
    private suspend fun giveUp(waiter: Waiter) {
        val next = lock.withLock {
            waiting.remove(waiter)
            if (holder !== waiter) return@withLock null
            // minWithOrNull keeps the first minimum in deque order, so equal classes
            // stay FIFO without a sequence number — this is where a queued Command or
            // Status overtakes the Enumerate walk that arrived before it.
            val head = waiting.minWithOrNull(compareBy { it.clazz.ordinal })
            if (head != null) waiting.remove(head)
            holder = head
            head
        }
        // Completed outside the lock: the promoted caller must not need a lock this
        // coroutine still holds, and `holder` already names it.
        next?.granted?.complete(Unit)
    }

    /** Feed the refusal streak from outside the lane (bulk transfers do this). */
    suspend fun noteResult(ok: Boolean, cause: String?) = lock.withLock {
        val now = monotonicMillis()
        if (ok) {
            if (failures >= BACKOFF_AFTER_FAILURES) {
                Diag.info(LogTag.HTTP, "$key: camera answering again after $failures failure(s)")
            }
            failures = 0
            refusedUntil = 0
            return@withLock
        }
        failures++
        if (failures < BACKOFF_AFTER_FAILURES) return@withLock
        val pause = (BACKOFF_BASE_MS shl (failures - BACKOFF_AFTER_FAILURES).coerceAtMost(4))
            .coerceAtMost(BACKOFF_MAX_MS)
        refusedUntil = now + pause
        if (now - lastCooldownLoggedAt >= BACKOFF_BASE_MS) {
            lastCooldownLoggedAt = now
            Diag.warn(
                LogTag.HTTP,
                "$key: $failures camera failure(s) in a row (${cause ?: "no answer"}) — " +
                    "pausing menu/thumbnail traffic ${pause}ms to let it recover",
            )
        }
    }

    /** One queued caller. */
    private class Waiter(val clazz: CameraRequestClass) {
        val granted = CompletableDeferred<Unit>()
    }

    private companion object {
        const val SLOW_MS = 2_000L
        const val BACKOFF_AFTER_FAILURES = 3
        const val BACKOFF_BASE_MS = 1_000L
        const val BACKOFF_MAX_MS = 15_000L

        /** The transport's failure shape: null / false / negative means no answer. */
        fun looksAlive(result: Any?): Boolean = when (result) {
            null -> false
            is Boolean -> result
            is Int -> result >= 0
            is Long -> result >= 0
            else -> true
        }
    }
}

/**
 * Thrown instead of sending a request the camera cannot serve right now.
 *
 * The transport turns it into the same `null`/`-1` it returns for any failed call, so
 * callers keep seeing "no answer" rather than a new failure mode to handle.
 */
internal class CameraRefusing(message: String) : Exception(message)

/**
 * `host:port` of [url] — the unit one camera's single CGI slot is defined by.
 *
 * Camera hosts are always literal IPs, so this is string surgery rather than URI
 * parsing: no ports in the field mean 80, and nothing here ever has user-info or
 * IPv6 literals to trip over.
 */
internal fun targetOf(url: String): String {
    val authority = url.substringAfter("://", url)
        .substringBefore('/')
        .substringBefore('?')
        .substringAfter('@')
    val host = authority.substringBefore(':')
    val port = authority.substringAfter(':', "").ifEmpty { "80" }
    return "$host:$port"
}

/**
 * Lanes keyed by `host:port`, plus the one bulk-transfer slot.
 *
 * Per target on purpose: the collapse this guards against is one camera's limit, and
 * discovery still has to probe several candidate IPs at once. Downloads take the bulk
 * slot rather than the command lane — a 4 GB clip would otherwise starve the shutter
 * for minutes — and only one runs at a time because that is also all the camera can
 * serve. Lanes are tiny and hosts are few, so they are never evicted.
 */
internal class CameraLanes {
    private val lanes = HashMap<String, CameraLane>()
    private val lock = Mutex()
    private val bulk = Mutex()

    suspend fun lane(key: String): CameraLane =
        lock.withLock { lanes.getOrPut(key) { CameraLane(key) } }

    suspend fun <T> withBulk(key: String, block: suspend () -> T): T = bulk.withLock {
        try {
            block()
        } catch (t: Throwable) {
            lane(key).noteResult(ok = false, cause = t.message ?: t::class.simpleName)
            throw t
        }
    }

    /** Test hook: how many distinct targets have been seen. */
    suspend fun laneCount(): Int = lock.withLock { lanes.size }
}
