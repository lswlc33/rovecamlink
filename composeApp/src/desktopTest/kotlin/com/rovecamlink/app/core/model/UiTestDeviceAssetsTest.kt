package com.rovecamlink.app.core.model

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Guards the byte counts in [UiTestDevice.files] against the tree `tools/fakecam/generate.py`
 * writes.
 *
 * That tree is generated and gitignored, so nothing else would catch the two drifting apart —
 * and `download()` fails any transfer whose written length differs from the declared
 * `sizeBytes`, which would make every file in UI test mode un-openable. Skips when the tree has
 * not been generated on this machine, which is the case on CI.
 */
class UiTestDeviceAssetsTest {

    @Test
    fun declaredSizesMatchTheGeneratedTree() {
        val dcim = File(repoRoot(), "tools/fakecam/DCIM").takeIf { it.isDirectory } ?: return
        UiTestDevice.files().forEach { f ->
            val onDisk = File(File(dcim, f.name.take(14)), f.name)
            assertTrue(onDisk.isFile, "${f.name} is not in ${dcim.path}")
            assertEquals(
                onDisk.length(),
                f.sizeBytes,
                "${f.name} size drifted from the generated tree — rerun generate.py and paste " +
                    "the new numbers into UiTestDevice.files()",
            )
        }
    }

    private fun repoRoot(): File {
        val start = File(System.getProperty("user.dir"))
        var dir: File? = start
        while (dir != null && !File(dir, "settings.gradle.kts").isFile) dir = dir.parentFile
        return dir ?: error("settings.gradle.kts not found above $start")
    }
}
