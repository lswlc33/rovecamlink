package com.rovecamlink.app.brand.xtu

import com.rovecamlink.app.brand.icatch.IcatchHttpProtocol
import com.rovecamlink.app.brand.tuwin.TuwinRestProtocol
import com.rovecamlink.app.core.transport.CameraHttp
import com.rovecamlink.app.core.transport.createCameraTcp
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * The capability flags the UI gates its buttons on, pinned against the plugins that ship.
 *
 * These used to be brand comparisons inside `AppState` (`platform == HISILICON`), which had
 * two failure modes this test covers: a family that *has* the command gets no button, and —
 * the quieter one — a family that does not have it gets the button anyway, because the branch
 * was written for a different family. Now the answer is the plugin's own declaration, so what
 * needs guarding is that the declaration matches what the plugin can actually do.
 *
 * Note what is asserted per family: XTU is the one that has all of these, so its flags are
 * asserted **true** (a typo there silently removes the primary camera's buttons), and the
 * other two are asserted **false** so that "no command" keeps meaning "no button" rather
 * than "we forgot to implement it".
 */
class PluginCapabilitiesTest {

    private fun xtu() = HisiliconProtocol(CameraHttp(), createCameraTcp())

    @Test
    fun `the hi3510 family offers every capability its plugin implements`() {
        val proto = xtu()
        assertTrue(proto.supportsCameraWifiRead, "getwifi.cgi exists — 读取热点 must be offered")
        assertTrue(proto.supportsAccessPoint, "raiseap.cgi exists — 恢复热点 must be offered")
        assertTrue(proto.otaTransport != null, "no transport means 固件更新 vanishes for the primary camera")
        assertTrue(proto.supportsLive, "the RTMP hand-off is implemented for this family")
    }

    @Test
    fun `the hi3510 family still declares the capabilities it lacks`() {
        // Both facts were established the hard way and each one gates a button: the archive
        // found no reboot endpoint among 22,620 string literals (docs/08 02-XTUGO §8.4).
        val proto = xtu()
        assertFalse(proto.supportsReboot, "存在重启按钮会让相机忽略它，用户以为已经重启")
    }

    @Test
    fun `a family without the command offers no button`() {
        // TUWIN and iCatch have no hotspot read, no access-point command and no firmware
        // channel wired up in this build. Each has to say so itself, or the UI would offer
        // a control that cannot work.
        val others = listOf(TuwinRestProtocol(CameraHttp()), IcatchHttpProtocol(CameraHttp()))
        others.forEach { proto ->
            val name = proto.platform.displayName
            assertFalse(proto.supportsCameraWifiRead, "$name must not offer 读取热点")
            assertFalse(proto.supportsAccessPoint, "$name must not offer 恢复热点")
            assertFalse(proto.otaTransport != null, "$name must not offer 固件更新")
        }
    }

    @Test
    fun `a family that cannot read the recording state says so`() {
        // The flag that keeps a poll from undoing the record button. TUWIN's status reply
        // has no recording field at all (docs/08 01-TUWIN-档案.md §5.3), so every poll would
        // answer `false` and flip the button back to 录像 a second after it was pressed.
        assertFalse(
            TuwinRestProtocol(CameraHttp()).reportsRecordingState,
            "TUWIN cannot report recording; claiming it can makes the button undo itself",
        )
        // The families whose status reply does carry the state keep the default, so their
        // polls stay authoritative.
        assertTrue(xtu().reportsRecordingState)
        assertTrue(IcatchHttpProtocol(CameraHttp()).reportsRecordingState)
    }

    @Test
    fun `the transport is built once and reused`() {
        // The state machine asks for this on every install and the OTA section asks for it on
        // every recomposition, so a `get()` that rebuilt the chain would hand the coordinator
        // a different object than the one the check ran against — and reopen the socket
        // transport each time.
        val proto = xtu()
        assertTrue(proto.otaTransport === proto.otaTransport, "otaTransport must be a single instance")
    }
}
