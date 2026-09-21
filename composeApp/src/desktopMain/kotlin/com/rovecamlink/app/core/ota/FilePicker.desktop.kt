package com.rovecamlink.app.core.ota

import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.File
import javax.swing.JFileChooser
import javax.swing.SwingUtilities
import javax.swing.filechooser.FileNameExtensionFilter
import kotlin.coroutines.resume

actual suspend fun pickCameraFirmwarePackage(): OtaPackage? = suspendCancellableCoroutine { cont ->
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
                if (cont.isActive) cont.resume(OtaPackage(version, file.name, file.readBytes()))
            }
        } catch (t: Throwable) {
            if (cont.isActive) cont.resume(null)
        }
    }
}