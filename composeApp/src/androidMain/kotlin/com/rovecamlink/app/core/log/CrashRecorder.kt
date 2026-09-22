package com.rovecamlink.app.core.log

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Put the exception that kills the process into the diagnostics log before it dies.
 *
 * The 2026-09-22 field session lost four runs to a crash on the live view and the
 * exported log said nothing about any of them: the writer flushes on a ~2 s heartbeat,
 * and an uncaught exception does not wait for it, so the last lines — including the
 * `player start` that named the failing screen — were still in the buffer when the
 * process ended. `first_error=none`, `last_error=none`, and a stack trace that only
 * existed in logcat, which is not something anyone can read off a phone in the field.
 *
 * So the crash itself is now a log record, written and drained synchronously, and the
 * handler then steps aside so the system still shows its own crash dialog and writes
 * its own tombstone.
 */
private const val MAX_FRAMES = 24

/** How long the process is held alive to get the record onto disk. */
private const val DRAIN_TIMEOUT_MS = 2_000L

fun installCrashRecorder() {
    val previous = Thread.getDefaultUncaughtExceptionHandler()
    Thread.setDefaultUncaughtExceptionHandler { thread, error ->
        runCatching {
            Diag.error(
                LogTag.APP,
                "UNCAUGHT on thread '${thread.name}': ${Diag.causeChain(error)}" + frames(error),
            )
            // The writer owns its own thread (Dispatchers.Default), so blocking this one
            // until the queue is empty is safe — and without it the record would very
            // likely never reach the file at all.
            runBlocking { withTimeoutOrNull(DRAIN_TIMEOUT_MS) { Diag.awaitDrained() } }
        }
        runCatching { previous?.uncaughtException(thread, error) }
    }
}

/**
 * The trace as continuation lines.
 *
 * [Diag.stackBlock] is deliberately TRACE-only, and the field default is DEBUG — which
 * is exactly the configuration a crash needs to survive in. A stack is the one payload
 * worth its bytes, so it is formatted here rather than gated behind the level.
 */
private fun frames(error: Throwable): String {
    val lines = runCatching { error.stackTraceToString().lines() }
        .getOrDefault(emptyList())
        .filter { it.isNotBlank() }
        .take(MAX_FRAMES)
    if (lines.isEmpty()) return ""
    return "\n" + lines.joinToString("\n") { LogFormat.CONT + it.trim() }
}
