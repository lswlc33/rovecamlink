package com.rovecamlink.app.core.model

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * One day's worth of camera files for the Files tab.
 *
 * Carries the [LocalDate] rather than a display string: the label is UI text and
 * has to come from the string resources, so this stays language-neutral.
 */
data class DayGroup(
    val key: LocalDate?,
    val files: List<RemoteFile>,
)

/**
 * Groups [files] by local calendar day (A12 — "相册按日分组"). Files without a
 * parseable [RemoteFile.dateMillis] fall into a trailing "unknown date" group;
 * dated groups are ordered newest first, the unknown group last, and files keep
 * the order the camera listed them in.
 */
fun groupFilesByDay(
    files: List<RemoteFile>,
    zone: TimeZone = TimeZone.currentSystemDefault(),
): List<DayGroup> {
    if (files.isEmpty()) return emptyList()

    val dated = mutableMapOf<LocalDate, MutableList<RemoteFile>>()
    val unknown = mutableListOf<RemoteFile>()
    for (f in files) {
        val date = f.dateMillis?.let { ms ->
            runCatching { Instant.fromEpochMilliseconds(ms).toLocalDateTime(zone).date }.getOrNull()
        }
        if (date == null) unknown.add(f) else dated.getOrPut(date) { mutableListOf() }.add(f)
    }

    val groups = dated.entries
        .sortedByDescending { it.key }
        .map { (date, list) -> DayGroup(date, list) }
        .toMutableList()
    if (unknown.isNotEmpty()) groups += DayGroup(null, unknown)
    return groups
}
