package com.rovecamlink.app.core.log

import okio.Path
import okio.Path.Companion.toPath
import java.io.File

actual fun monotonicMillis(): Long = System.nanoTime() / 1_000_000L

actual fun platformDiagnostics(): List<Pair<String, String>> {
    val p = System.getProperties()
    return listOf(
        "app.version" to "dev",
        "app.build" to "desktop",
        "platform" to "desktop",
        "os.name" to (p.getProperty("os.name") ?: "?"),
        "os.version" to (p.getProperty("os.version") ?: "?"),
        "os.arch" to (p.getProperty("os.arch") ?: "?"),
        "vm" to "${p.getProperty("java.vendor") ?: "?"} ${p.getProperty("java.version") ?: "?"}",
        "app.cwd" to File("").absolutePath,
        "app.locale" to java.util.Locale.getDefault().toString(),
        "app.timezone" to java.util.TimeZone.getDefault().id,
        "cpu.cores" to (Runtime.getRuntime().availableProcessors().toString()),
        "mem.max_mb" to (Runtime.getRuntime().maxMemory() / (1024 * 1024)).toString(),
    )
}

/** Desktop keeps logs next to the working directory; "share" opens the file. */
private class DesktopLogStore : LogStore {

    private fun dir(): File = File("logs").also { if (!it.exists()) it.mkdirs() }

    override fun logsDir(): Path = dir().absolutePath.toPath()

    override fun save(fileName: String, content: String): String? {
        val f = File(dir(), File(fileName).name)
        return runCatching { f.writeText(content); f.absolutePath }.getOrNull()
    }

    override fun share(fileName: String, content: String): Boolean {
        val path = save(fileName, content) ?: return false
        return runCatching {
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop.getDesktop().open(File(path))
                true
            } else {
                false
            }
        }.getOrDefault(false)
    }
}

actual fun createLogStore(): LogStore = DesktopLogStore()
