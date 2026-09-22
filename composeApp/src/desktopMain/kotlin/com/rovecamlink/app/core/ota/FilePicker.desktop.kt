package com.rovecamlink.app.core.ota

import kotlinx.coroutines.suspendCancellableCoroutine
import okio.FileSystem
import okio.Path.Companion.toPath
import java.io.File
import javax.swing.JFileChooser
import javax.swing.SwingUtilities
import javax.swing.filechooser.FileNameExtensionFilter
import kotlin.coroutines.resume

/**
 * Desktop's 选择本地固件. The only platform where a file dialog is worth wiring, and
 * the reason the manual path survives at all: it is how this flow is exercised against
 * `simulator/` without a vendor cloud in the loop.
 *
 * Returns a [FirmwarePackage] — a path and a length — rather than the file's bytes,
 * unlike the version this replaced, which called `file.readBytes()` on a 50 MB image.
 */
actual suspend fun pickCameraFirmwarePackage(): FirmwarePackage? = suspendCancellableCoroutine { cont ->
    SwingUtilities.invokeLater {
        val chooser = JFileChooser()
        chooser.dialogTitle = "Select camera firmware (*.bin)"
        chooser.fileFilter = FileNameExtensionFilter("Camera firmware (*.bin)", "bin")
        try {
            if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
                if (cont.isActive) cont.resume(null)
                return@invokeLater
            }
            val file: File = chooser.selectedFile
            val version = FirmwareVersion.from(file.name)
            if (version == null) {
                javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "The file name must embed an 8-digit yyyyMMdd version token (e.g. fw_20250615.bin).",
                    "RoveCamLink",
                    javax.swing.JOptionPane.WARNING_MESSAGE,
                )
                if (cont.isActive) cont.resume(null)
            } else {
                // `File.length()` rather than an okio metadata round-trip: the chooser
                // already handed us a java.io.File, and okio's own filesystem API is not
                // what this file is otherwise doing.
                val size = file.length()
                if (size <= 0L) {
                    if (cont.isActive) cont.resume(null)
                    return@invokeLater
                }
                if (cont.isActive) {
                    cont.resume(
                        FirmwarePackage(
                            path = file.absolutePath.toPath(),
                            sizeBytes = size,
                            fileName = file.name,
                            version = version,
                        ),
                    )
                }
            }
        } catch (t: Throwable) {
            if (cont.isActive) cont.resume(null)
        }
    }
}
