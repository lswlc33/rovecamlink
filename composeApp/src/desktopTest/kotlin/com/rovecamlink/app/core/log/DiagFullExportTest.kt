package com.rovecamlink.app.core.log

import java.io.File
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking

/**
 * The full export (issue 8): it has to read the persisted session files back off
 * disk — the only thing that survives a crash — oldest first, and must never treat a
 * previous *export* as if it were a run.
 *
 * Runs on desktop where [createLogStore] gives a real directory. To stay isolated from
 * the other suites that log into the same `logs/` dir, each test first prunes every
 * session file except the one this process is writing, then adds its own synthetic
 * runs and removes them again. All helpers are suspend so they compose with the
 * enclosing `runBlocking` instead of nesting another one.
 */
class DiagFullExportTest {

    private fun logsDir(): File = File(createLogStore().logsDir()!!.toString())

    /** A valid `rovdiag/1` file body: two records, the first with a continuation line. */
    private fun runBody(marker: String): String = buildString {
        append("000001 2020-01-01T00:00:00.000+00:00 +0.000s I APP  op=- $marker start\n")
        append("${LogFormat.CONT}$marker continuation\n") // must NOT count as a record
        append("000002 2020-01-01T00:00:01.000+00:00 +1.000s W HTTP op=- $marker end\n")
    }

    /** The stamp a rolling session file is named with, for the given start time. */
    private fun sessionName(millis: Long) = "rovcamlink-${Diag.fileNameStamp(millis)}.txt"

    /** Delete every session file except the one the live process is currently writing. */
    private suspend fun isolateToCurrentRun() {
        Diag.config.fileSink = true
        Diag.config.paused = false
        Diag.info(LogTag.LOG, "warmup") // force ensureFile so sessionFile() is non-null
        Diag.awaitDrained()
        val keep = Diag.sessionFile()?.let { File(it).name }
        logsDir().listFiles()?.forEach { f ->
            val n = f.name
            val isSession = n.startsWith("rovcamlink-") && n.endsWith(".txt") && !n.startsWith("rovcamlink-log-")
            if (isSession && n != keep) runCatching { f.delete() }
        }
    }

    private fun writeSession(name: String, content: String) = File(logsDir(), name).writeText(content)

    private suspend fun deleteSession(name: String) {
        Diag.awaitDrained()
        runCatching { File(logsDir(), name).delete() }
    }

    @AfterTest
    fun restore() {
        Diag.config.fileSink = true
        Diag.config.paused = false
        Diag.config.minLevel = LogLevel.DEBUG
    }

    @Test
    fun exportReplaysAllPersistedRunsOldestFirstAndSkipsPriorExports() = runBlocking {
        isolateToCurrentRun()

        val older = sessionName(1_500_000_000_000L) // 2017
        val newer = sessionName(1_700_000_000_000L) // 2023
        val priorExport = "rovcamlink-log-EXCLUSIONTEST.txt"
        writeSession(older, runBody("ZZ_OLD_RUN"))
        writeSession(newer, runBody("ZZ_NEW_RUN"))
        writeSession(priorExport, runBody("ZZ_PRIOR_EXPORT")) // must be excluded from replay

        try {
            Diag.info(LogTag.APP, "ZZ_CURRENT_RUN marker")
            Diag.awaitDrained()
            val out = Diag.exportFullBundle()

            // ---- structure ----
            assertTrue(out.contains("==== ROVECAMLINK DIAGNOSTIC LOG - FULL ===="), out.take(400))
            assertTrue(out.contains("format=${Diag.FORMAT_ID}"), "grammar id still declared")
            assertTrue(out.contains("==== INDEX ====") && out.contains("==== END INDEX ===="), "index present")
            assertTrue(Regex("""source=disk file=$older""").containsMatchIn(out), "older run indexed from disk")
            assertTrue(Regex("""source=disk file=$newer""").containsMatchIn(out), "newer run indexed from disk")

            // ---- disk records replayed verbatim, continuation included, count honest ----
            assertTrue(out.contains("ZZ_OLD_RUN start") && out.contains("ZZ_OLD_RUN continuation"), "old body intact")
            assertTrue(out.contains("RECORDS (2 read from disk)"), "continuation must not inflate the count: " +
                out.lines().filter { "RECORDS" in it })

            // ---- the current run is labelled honestly as memory, not disk ----
            assertTrue(out.contains("in memory"), "the live block must say it came from the ring")
            assertTrue(out.contains("ZZ_CURRENT_RUN marker"))

            // ---- chronological order: oldest disk run, newest disk run, then current ----
            val iOld = out.indexOf("ZZ_OLD_RUN start")
            val iNew = out.indexOf("ZZ_NEW_RUN start")
            val iCur = out.indexOf("ZZ_CURRENT_RUN marker")
            assertTrue(iOld in 0 until iNew && iNew < iCur, "expected old<new<current but got $iOld,$iNew,$iCur")

            // ---- a prior export is NEVER replayed as a run (shares the rovcamlink-log- prefix) ----
            assertTrue(!out.contains("ZZ_PRIOR_EXPORT"), "a prior export must never be replayed as a run")
            assertTrue(out.endsWith("==== END ====\n"), "document ends with a single top-level END")
        } finally {
            deleteSession(older); deleteSession(newer); deleteSession(priorExport)
        }
    }

    @Test
    fun oversizedHistoryIsTruncatedFromTheOldestWithAnExplicitNote() = runBlocking {
        isolateToCurrentRun()

        // Budget is 6 MiB (Diag's private cap). Two files: the newest alone blows the
        // budget, so it is sliced to its most recent tail and the older one dropped.
        val big = buildString {
            val line = "999999 2020-01-01T00:00:00.000+00:00 +0.000s I APP  op=- " +
                "ZZ_BIG_RUN padding padding padding padding padding padding\n"
            while (length < 7 * 1024 * 1024) append(line) // ~7 MB, over the cap
        }
        val dropped = sessionName(1_600_000_000_000L)
        val keptBig = sessionName(1_800_000_000_000L)
        writeSession(dropped, runBody("ZZ_OLDER_DROPPED"))
        writeSession(keptBig, big)

        try {
            val out = Diag.exportFullBundle()
            assertTrue(out.contains("ZZ_BIG_RUN"), "newest oversized run is still exported (its tail)")
            assertTrue(out.contains("truncated=run exceeded the"), "the slice must be announced: " +
                out.lines().filter { "truncated=" in it })
            assertTrue(out.contains("TRUNCATED_OLDER_RUNS="), "omission of the older run must be announced: " +
                out.lines().filter { "TRUNCATED_OLDER_RUNS=" in it })
            assertTrue(out.contains(dropped), "the note should name the dropped file")
            assertTrue(!out.contains("ZZ_OLDER_DROPPED start"), "dropped file's records must be absent")
        } finally {
            deleteSession(dropped); deleteSession(keptBig)
        }
    }

    @Test
    fun pausingDropsRecordsAndTheToggleFlipsThem() = runBlocking {
        isolateToCurrentRun()
        Diag.clear()

        // Off: `at()` must drop the record entirely (the pause boundary line itself is
        // still written, but nothing after it).
        Diag.setRecording(false)
        assertTrue(Diag.config.paused)
        val dropped = "ZZ_DROPPED_WHILE_PAUSED"
        Diag.info(LogTag.APP, dropped)
        Diag.awaitDrained()
        assertTrue(Diag.tail(200).none { it.text.contains(dropped) }, "paused at() must drop records")

        // One tap brings it back and capture resumes.
        val on = Diag.toggleRecording()
        assertTrue(on && !Diag.config.paused, "toggleRecording returns the new enabled state")
        val kept = "ZZ_RECORDED_AFTER_RESUME"
        Diag.info(LogTag.APP, kept)
        Diag.awaitDrained()
        assertTrue(Diag.tail(200).any { it.text.contains(kept) }, "resumed capture records again")
    }
}
