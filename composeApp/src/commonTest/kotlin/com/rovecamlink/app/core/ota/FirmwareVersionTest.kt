package com.rovecamlink.app.core.ota

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class FirmwareVersionTest {

    @Test fun `extracts yyyyMMdd anywhere in the string`() {
        assertEquals("20240315", FirmwareVersion.from("XTU_20240315_v12"))
        assertEquals("20240315", FirmwareVersion.from("  GK1000_20240315_v12 "))
        assertEquals("20240315", FirmwareVersion.from("20240315"))
        assertNull(FirmwareVersion.from("v1.2.3"))     // no date stamp
        assertNull(FirmwareVersion.from("   "))
        assertNull(FirmwareVersion.from(null))
    }

    @Test fun `picks the first of several date stamps`() {
        assertEquals("20240101", FirmwareVersion.from("prefix20240101suffix20250105"))
    }

    @Test fun `converts Mon DD YYYY build stamp to yyyyMMdd`() {
        assertEquals("20250615", FirmwareVersion.from("Jun 15 2025"))
        assertEquals("20250301", FirmwareVersion.from("Mar 1 2025"))
        assertEquals("20251225", FirmwareVersion.from("Dec 25 2025"))
        // Feb 29 only valid on a leap year.
        assertEquals("20240229", FirmwareVersion.from("Feb 29 2024"))
        assertNull(FirmwareVersion.from("Feb 29 2025"))
        // Invalid day (Jun has 30) has no date to extract → null, not a crash.
        assertNull(FirmwareVersion.from("Jun 31 2025"))
    }

    @Test fun `comparison is chronological and null-safe`() {
        assertTrue(FirmwareVersion.isNewer("20240315", "20240101"))
        assertFalse(FirmwareVersion.isNewer("20240101", "20240315"))
        assertFalse(FirmwareVersion.isNewer("20240315", "20240315")) // equal → not newer
        assertFalse(FirmwareVersion.isNewer(null, "20240101"))
        assertFalse(FirmwareVersion.isNewer("20240101", null))
        assertFalse(FirmwareVersion.isNewer(null, null))
    }
}