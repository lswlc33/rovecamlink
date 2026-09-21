package com.rovecamlink.app.core.model

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FileGroupingTest {

    private fun file(name: String, dateMillis: Long? = null) = RemoteFile(
        name = name,
        type = FileType.VIDEO,
        sizeBytes = 0L,
        downloadUrl = "http://cam/$name",
        dateMillis = dateMillis,
    )

    private fun ms(iso: String): Long = Instant.parse(iso).toEpochMilliseconds()

    @Test
    fun sameDayMergesAndKeepsListOrder() {
        val groups = groupFilesByDay(
            listOf(
                file("a.mp4", ms("2026-01-01T12:00:00Z")),
                file("b.mp4", ms("2026-01-01T08:00:00Z")),
                file("c.mp4", ms("2026-01-02T00:00:00Z")),
            ),
            zone = TimeZone.UTC,
        )
        assertEquals(2, groups.size)
        // Newest day first.
        assertEquals(LocalDate(2026, 1, 2), groups[0].key)
        assertEquals(listOf("c.mp4"), groups[0].files.map { it.name })
        // Same-day group preserves listing order.
        assertEquals(listOf("a.mp4", "b.mp4"), groups[1].files.map { it.name })
    }

    @Test
    fun nullDatesGoToTrailingUnknownGroup() {
        val groups = groupFilesByDay(
            listOf(
                file("undated.mp4", null),
                file("b.mp4", ms("2026-01-01T12:00:00Z")),
                file("undated2.mp4", null),
            ),
            zone = TimeZone.UTC,
        )
        assertEquals(2, groups.size)
        assertEquals(null, groups.last().key)
        assertEquals(listOf("undated.mp4", "undated2.mp4"), groups.last().files.map { it.name })
    }

    @Test
    fun emptyInputYieldsEmptyGroups() {
        assertTrue(groupFilesByDay(emptyList()).isEmpty())
    }

    @Test
    fun allUndatedYieldsSingleUnknownGroup() {
        val groups = groupFilesByDay(
            listOf(file("x.mp4", null), file("y.mp4", null)),
            zone = TimeZone.UTC,
        )
        assertEquals(1, groups.size)
        assertEquals(null, groups[0].key)
        assertEquals(listOf("x.mp4", "y.mp4"), groups[0].files.map { it.name })
    }
}
