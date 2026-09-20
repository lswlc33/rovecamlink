package com.rovecamlink.app.core.storage

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class SanitizeFileNameTest {

    @Test
    fun keepsNormalCameraNames() {
        assertEquals("VID_20260920_113045.mp4", sanitizeFileName("VID_20260920_113045.mp4"))
        assertEquals("IMG_0001.JPG", sanitizeFileName("IMG_0001.JPG"))
    }

    @Test
    fun stripsDirectoryComponents() {
        assertEquals("evil.mp4", sanitizeFileName("/../../external/evil.mp4"))
        assertEquals("evil.mp4", sanitizeFileName("C:\\windows\\evil.mp4"))
    }

    @Test
    fun neutralisesParentTraversal() {
        val out = sanitizeFileName("../../etc/passwd")
        assertFalse(out.contains(".."))
        assertFalse(out.contains("/"))
    }

    @Test
    fun replacesFileSystemHostileCharacters() {
        assertEquals("x_y", sanitizeFileName("x|y"))
        assertEquals("a_b", sanitizeFileName("a:b"))
        assertEquals("a_b_c", sanitizeFileName("a?b*c"))
        // A separator wins: only the trailing basename survives.
        assertEquals("c", sanitizeFileName("a:b/c"))
    }

    @Test
    fun neverReturnsEmpty() {
        assertEquals("download", sanitizeFileName("   "))
        assertEquals("download", sanitizeFileName("///"))
    }

    @Test
    fun capsPathologicalLengths() {
        assertEquals(120, sanitizeFileName("a".repeat(500)).length)
    }
}
