package com.rovecamlink.app.core.protocol

import com.rovecamlink.app.core.model.CameraSession
import com.rovecamlink.app.core.model.CmdResult
import com.rovecamlink.app.core.model.DeviceEvent
import com.rovecamlink.app.core.model.DeviceInfo
import com.rovecamlink.app.core.model.DevicePlatform
import com.rovecamlink.app.core.model.DeviceStatus
import com.rovecamlink.app.core.model.RemoteFile
import com.rovecamlink.app.core.model.WorkMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import okio.Path
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertSame

/**
 * Guard for the plugin registry — the one place a new camera family plugs into, and the
 * place where a mistake is silent rather than loud.
 *
 * Two rules are load-bearing and were both untested before this:
 *
 *  - **Registration order is detection priority.** [CameraProtocolRegistry] is a list,
 *    and the first plugin whose `probe` answers claims the device. A brand appended at
 *    the end can therefore never steal a camera from one already registered — while a
 *    brand inserted at the front silently can. That is why this is pinned here rather
 *    than left to whoever edits `AppGraph.protocolList`.
 *  - **A duplicate platform is dropped in silence.** The map is built with
 *    `associateBy { it.platform }`, so registering two plugins for one platform leaves
 *    one of them unreachable with no error anywhere. For a plugin writer that failure
 *    looks exactly like a broken probe.
 *
 * The fake below implements only what the registry reads; every camera-facing member is
 * unreachable from here on purpose, so a test can never pass by talking to a device.
 */
class CameraProtocolRegistryTest {

    private class FakeProtocol(
        override val platform: DevicePlatform,
        override val wifiSsidPrefixes: List<String> = emptyList(),
        override val fixedHost: String? = null,
        override val defaultWifiPassword: String? = null,
    ) : CameraProtocol {
        override suspend fun probe(host: String, port: Int): Boolean = false

        override suspend fun connect(host: String, port: Int): CameraSession =
            error("the registry never connects")

        override suspend fun getStatus(session: CameraSession): DeviceStatus =
            error("the registry never reads status")

        override suspend fun getSettings(session: CameraSession) =
            error("the registry never reads settings")

        override suspend fun setSetting(session: CameraSession, id: String, value: String): CmdResult =
            error("the registry never writes settings")

        override suspend fun setMode(session: CameraSession, mode: WorkMode): CmdResult =
            error("the registry never sets modes")

        override suspend fun capture(session: CameraSession): CmdResult =
            error("the registry never captures")

        override suspend fun record(session: CameraSession, start: Boolean): CmdResult =
            error("the registry never records")

        override suspend fun listFiles(session: CameraSession, start: Int, end: Int): List<RemoteFile> =
            error("the registry never lists files")

        override suspend fun deleteFile(session: CameraSession, file: RemoteFile): CmdResult =
            error("the registry never deletes files")

        override suspend fun thumbnail(session: CameraSession, file: RemoteFile): ByteArray? =
            error("the registry never fetches thumbnails")

        override suspend fun download(
            session: CameraSession,
            file: RemoteFile,
            dest: Path,
            alreadyHaveBytes: Long,
            onProgress: (Float) -> Unit,
        ): Long = error("the registry never downloads")

        override fun previewUrl(session: CameraSession): String = ""

        override suspend fun getDeviceInfo(session: CameraSession): DeviceInfo? = null

        override suspend fun formatSd(session: CameraSession): CmdResult =
            error("the registry never formats")

        override suspend fun factoryReset(session: CameraSession): CmdResult =
            error("the registry never resets")

        override suspend fun syncTime(session: CameraSession): CmdResult =
            error("the registry never syncs time")

        override suspend fun setWifi(session: CameraSession, ssid: String, password: String): CmdResult =
            error("the registry never renames a hotspot")

        override val events: Flow<DeviceEvent> = emptyFlow()
    }

    private val xtu = FakeProtocol(
        platform = DevicePlatform.HISILICON,
        wifiSsidPrefixes = listOf("XTUCam_"),
        fixedHost = "192.168.0.1",
        defaultWifiPassword = "12345678",
    )
    private val tuwin = FakeProtocol(DevicePlatform.TUWIN_REST, listOf("TUWIN_R3P_"))

    @Test
    fun `every registered plugin is reachable`() {
        // associateBy keeps the last of two plugins sharing a platform and drops the rest
        // without a word — an unreachable plugin with no error is the worst version of
        // this bug, because it reads as "my probe does not match" at the other end.
        val protocols = listOf(xtu, tuwin)
        val registry = CameraProtocolRegistry(protocols)
        assertEquals(
            protocols.size,
            registry.all().size,
            "a plugin was silently dropped: two plugins declare the same platform",
        )
    }

    @Test
    fun `a plugin is found by its platform`() {
        val registry = CameraProtocolRegistry(listOf(xtu, tuwin))
        assertSame(xtu, registry.protocolFor(DevicePlatform.HISILICON))
        assertSame(tuwin, registry.protocolFor(DevicePlatform.TUWIN_REST))
        assertEquals(setOf(DevicePlatform.HISILICON, DevicePlatform.TUWIN_REST), registry.platforms())
    }

    @Test
    fun `a platform with no plugin reports none rather than guessing`() {
        // The UI reads this to separate 已适配 from merely documented models, so a
        // fallback here would make the supported-devices page lie.
        assertNull(CameraProtocolRegistry(listOf(xtu)).protocolFor(DevicePlatform.ICATCH))
    }

    @Test
    fun `registration order is detection priority`() {
        // identify() walks all() and takes the first plugin whose probe answers. Appending
        // a brand cannot change an existing camera's plugin; prepending can.
        val registry = CameraProtocolRegistry(listOf(xtu, tuwin))
        assertEquals(
            listOf(DevicePlatform.HISILICON, DevicePlatform.TUWIN_REST),
            registry.all().map { it.platform },
            "plugins must be offered in registration order",
        )
    }

    @Test
    fun `the longest matching prefix wins when two brands overlap`() {
        // XTUCam_ must beat a brand that claimed the bare XTU — otherwise the wider claim
        // shadows the narrower one and gives discovery the wrong first address.
        val broad = FakeProtocol(DevicePlatform.AMBARELLA, listOf("XTU"))
        val narrow = FakeProtocol(DevicePlatform.HISILICON, listOf("XTUCam_"))
        val registry = CameraProtocolRegistry(listOf(broad, narrow))
        assertSame(narrow, registry.forSsid("XTUCam_f9e5e2"))
        assertSame(broad, registry.forSsid("XTU_something_else"))
    }

    @Test
    fun `hotspot matching ignores case and rejects nothing at all`() {
        val registry = CameraProtocolRegistry(listOf(xtu))
        assertSame(xtu, registry.forSsid("xtucam_lowercase"))
        assertNull(registry.forSsid(null))
        assertNull(registry.forSsid(""))
        assertNull(registry.forSsid("   "))
        assertNull(registry.forSsid("SomeHomeRouter"))
    }

    @Test
    fun `claimed prefixes list every declared prefix, longest first`() {
        val registry = CameraProtocolRegistry(listOf(xtu, tuwin))
        assertEquals(
            setOf("XTUCam_", "TUWIN_R3P_"),
            registry.claimedSsidPrefixes.toSet(),
            "a declared prefix went missing from the aggregate the scanner reads",
        )
        assertEquals(
            "TUWIN_R3P_",
            registry.claimedSsidPrefixes.first(),
            "the aggregate must stay longest-first so the narrowest claim is reported first",
        )
    }

    @Test
    fun `an unknown hotspot yields no address and no passphrase`() {
        // Null here is what tells discovery to walk the candidate gateways instead of
        // trusting a fixed one, so it must not fall back to some other brand's value.
        val registry = CameraProtocolRegistry(listOf(xtu, tuwin))
        assertNull(registry.fixedHostFor("TP-LINK_5G"))
        assertNull(registry.defaultPasswordFor("TP-LINK_5G"))
        assertNull(registry.fixedHostFor(null))
        assertEquals("192.168.0.1", registry.fixedHostFor("XTUCam_abc"))
        assertEquals("12345678", registry.defaultPasswordFor("XTUCam_abc"))
    }

    @Test
    fun `an empty registry answers nothing instead of throwing`() {
        // A build with no plugins compiled in is a real state (the desktop harness, a
        // trimmed build); every reader has to get "unknown" rather than a crash.
        val empty = CameraProtocolRegistry(emptyList())
        assertEquals(0, empty.all().size)
        assertEquals(emptySet(), empty.platforms())
        assertNull(empty.protocolFor(DevicePlatform.HISILICON))
        assertNull(empty.forSsid("XTUCam_abc"))
        assertEquals(emptyList(), empty.claimedSsidPrefixes)
    }
}
