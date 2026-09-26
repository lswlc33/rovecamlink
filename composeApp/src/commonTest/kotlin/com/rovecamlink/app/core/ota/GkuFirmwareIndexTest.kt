package com.rovecamlink.app.core.ota

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * The vendor firmware index, pinned down against the body the endpoint actually
 * returned on 2026-09-23 for `firm_ware_model=XTUS7PRO`.
 *
 * The JSON below is that response with the release-note prose shortened. Every key the
 * parser depends on is intact, including `size`, `create_time` and `is_scattered` — the
 * first two are the fields the official app's DTO does not even declare
 * (`docs/analysis/ota-and-gaps §5.2`), and the third is one of the unknowns `ignoreUnknownKeys` has to
 * survive.
 */
class GkuFirmwareIndexTest {

    private val liveS7ProBody = """
        {"code":0,"msg":"OK","data":{"list":[{
          "create_time":1789884343,
          "file_url":"http://vidvault-asia.oss-cn-hangzhou.aliyuncs.com/system/XTUS7PRO_20.8.6.1.20260910.G.zip",
          "firm_ware_model":"XTUS7PRO",
          "force":false,
          "hardware_version":"V1.0",
          "is_scattered":false,
          "region":"G",
          "release_note":"",
          "release_notes":[
            {"content":"<p>S7PRO 0910正式固件发布：</p><p>1.修复回放加载缓慢。</p>","lang":"zh"},
            {"content":"<p>S7PRO Official Firmware 0910 Released:</p><p>1. Playback loads faster.</p>","lang":"en"},
            {"content":"<p>0910 版公開</p>","lang":"ja"}
          ],
          "size":54490165,
          "target_rules":null,
          "version":"XTUS7PRO_20.8.6.1.20260910.G"
        }]}}
    """.trimIndent()

    @Test
    fun cameraNameBecomesTheModelIndexTheSameWayTheVendorDoes() {
        // The vendor's only transformation is removing whitespace
        // (DeviceVersionManager.java:175). `XTU S7PRO` is one of the two XTU model names
        // that contains a space at all, and `XTUS7PRO` is the string the index knows.
        assertEquals("XTUS7PRO", GkuFirmwareIndex.firmwareModelOf("XTU S7PRO"))
        assertEquals("XTUMINI2Pro", GkuFirmwareIndex.firmwareModelOf("XTU MINI2Pro"))
        // A name the app carries with a device suffix must not become part of the key.
        assertEquals("XTUS7PRO", GkuFirmwareIndex.firmwareModelOf("XTU S7PRO-f9e5e2"))
        assertNull(GkuFirmwareIndex.firmwareModelOf(null))
        assertNull(GkuFirmwareIndex.firmwareModelOf("   "))
    }

    @Test
    fun requestUrlEscapesTheCameraSuppliedModel() {
        val url = GkuFirmwareIndex.requestUrl("XTUS7PRO", "G", "V1.0")
        assertTrue(url.startsWith("https://server4.gkuvision.com/v1/push/api/getNewestVersion?"), url)
        assertTrue(url.contains("firm_ware_model=XTUS7PRO"), url)
        assertTrue(url.contains("region=G&"), url)
        assertTrue(url.endsWith("hardware_version=V1.0"), url)
        // The model comes from the camera, which is untrusted input: a name that tries to
        // add a parameter, or a second entry to the vendor's comma-joined list, has to
        // come out as one opaque value.
        val hostile = GkuFirmwareIndex.requestUrl("A&region=X,B", "G", "V1.0")
        assertTrue(hostile.contains("firm_ware_model=A%26region%3DX%2CB"), hostile)
    }

    @Test
    fun liveResponseParsesIntoOneOfferWithTheSizeTheServerAdvertised() {
        val offers = GkuFirmwareIndex.parse(liveS7ProBody, wantModel = "XTUS7PRO")
        assertEquals(1, offers.size)
        val offer = offers.single()
        assertEquals("XTUS7PRO_20.8.6.1.20260910.G", offer.version)
        assertEquals("20260910", offer.normalized)
        assertEquals(54_490_165L, offer.sizeBytes)
        assertEquals("XTUS7PRO_20.8.6.1.20260910.G.zip", offer.fileName)
        assertEquals(false, offer.forced)
        assertEquals("G", offer.region)
        assertEquals("V1.0", offer.hardwareVersion)
    }

    @Test
    fun downloadUrlIsForcedOntoTls() {
        val offer = GkuFirmwareIndex.parse(liveS7ProBody, wantModel = "XTUS7PRO").single()
        // The server sends http:// for a binary that is about to become an OS.
        assertTrue(offer.downloadUrl.startsWith("https://vidvault-asia.oss-cn-hangzhou.aliyuncs.com/"), offer.downloadUrl)
    }

    @Test
    fun nonHttpUrlsAreDroppedRatherThanFetched() {
        assertNull(GkuFirmwareIndex.secureDownloadUrl("file:///etc/passwd"))
        assertNull(GkuFirmwareIndex.secureDownloadUrl("ftp://example/x.zip"))
        assertNull(GkuFirmwareIndex.secureDownloadUrl(""))
        assertNull(GkuFirmwareIndex.secureDownloadUrl(null))
        assertEquals(
            "https://h/a.zip",
            GkuFirmwareIndex.secureDownloadUrl("https://h/a.zip"),
        )
    }

    @Test
    fun releaseNotesFollowTheRequestedLanguageAndLoseTheHtml() {
        val offer = GkuFirmwareIndex.parse(liveS7ProBody, wantModel = "XTUS7PRO").single()
        val zh = offer.releaseNoteFor("zh")
        assertNotNull(zh)
        assertTrue(zh.contains("修复回放加载缓慢"), zh)
        assertTrue(!zh.contains("<p>"), "html tags must not reach the screen: $zh")
        assertEquals("S7PRO 0910正式固件发布：\n1.修复回放加载缓慢。", zh)
        assertTrue(offer.releaseNoteFor("en")!!.contains("Playback loads faster"))
        // A regional tag the index does not send still has to land on the base language.
        assertTrue(offer.releaseNoteFor("zh-CN")!!.contains("修复"))
        // Unknown language falls back to English rather than showing nothing.
        assertTrue(offer.releaseNoteFor("de")!!.contains("Playback"))
        assertNull(offer.releaseNoteFor(null).takeIf { offer.notes.isEmpty() })
    }

    @Test
    fun newerPublishedBuildIsOfferedAndAnEqualOneIsNot() {
        val offers = GkuFirmwareIndex.parse(liveS7ProBody, wantModel = "XTUS7PRO")
        val available = GkuFirmwareIndex.plan("20.8.6.1.20260710", offers)
        assertTrue(available is UpdatePlan.Available, "expected Available, got $available")
        assertEquals("20.8.6.1.20260710", available.installed)

        // Same date stamp, different spelling: the camera reports `20.8.6.1.20260910`
        // while the index calls the build `XTUS7PRO_20.8.6.1.20260910.G`.
        assertTrue(GkuFirmwareIndex.plan("20.8.6.1.20260910", offers) is UpdatePlan.UpToDate)
        // Already ahead of what is published — the vendor app would happily re-flash it.
        assertTrue(GkuFirmwareIndex.plan("20.8.6.1.20261225", offers) is UpdatePlan.NewerInstalled)
    }

    @Test
    fun noEntryAndNoComparableVersionAreDifferentAnswers() {
        assertTrue(GkuFirmwareIndex.plan("20.8.6.1.20260710", emptyList()) is UpdatePlan.NoEntry)
        // `XTUS7` and `XTUMAX3` really do answer with an empty list, so "nothing published"
        // must never be rendered as "you are up to date".
        val empty = """{"code":0,"msg":"OK","data":{"list":[]}}"""
        assertTrue(GkuFirmwareIndex.parse(empty, wantModel = "XTUS7").isEmpty())
        assertTrue(GkuFirmwareIndex.plan("20.8.6.1.20260710", GkuFirmwareIndex.parse(empty, "XTUS7")) is UpdatePlan.NoEntry)

        val offers = GkuFirmwareIndex.parse(liveS7ProBody, wantModel = "XTUS7PRO")
        assertTrue(GkuFirmwareIndex.plan(null, offers) is UpdatePlan.CannotCompare)
        assertTrue(GkuFirmwareIndex.plan("NewAPP", offers) is UpdatePlan.CannotCompare)
    }

    @Test
    fun malformedOrRejectedBodiesParseAsNoAnswerNotAsUpToDate() {
        val offers = GkuFirmwareIndex.parse("", "XTUS7PRO")
        assertTrue(offers.isEmpty())
        assertTrue(GkuFirmwareIndex.parse("<html>502 Bad Gateway</html>", "XTUS7PRO").isEmpty())
        assertTrue(GkuFirmwareIndex.parse("""{"code":401,"msg":"no"}""", "XTUS7PRO").isEmpty())
        assertTrue(GkuFirmwareIndex.parse(null, "XTUS7PRO").isEmpty())
        // A rejected envelope must not become an UpToDate.
        assertTrue(GkuFirmwareIndex.plan("20.8.6.1.20260710", offers) is UpdatePlan.NoEntry)
    }

    @Test
    fun entriesForOtherModelsInTheSameResponseAreNotMistakenForOurs() {
        // The vendor's endpoint accepts comma-joined lists and answers them all. One
        // request here carries one model, but a response that disagrees is still not
        // permission to flash another camera's build.
        val other = liveS7ProBody
            .replace("\"XTUS7PRO\"", "\"XTUMINI2Pro\"")
            .replace("XTUS7PRO_20.8.6.1.20260910", "XTUMINI2Pro_V1.8.1.9.20260914")
        val ours = liveS7ProBody.substringAfter("\"list\":[").substringBeforeLast("]")
        val theirs = other.substringAfter("\"list\":[").substringBeforeLast("]")
        val both = """{"code":0,"msg":"OK","data":{"list":[$ours,$theirs]}}"""

        val mine = GkuFirmwareIndex.parse(both, wantModel = "XTUS7PRO")
        assertEquals(1, mine.size, "only the requested model may survive")
        assertEquals("XTUS7PRO", mine.single().model)
    }

    @Test
    fun packageNamesCannotEscapeTheCacheDirectory() {
        assertEquals("a.zip", FirmwareUpdater.safePackageName("a.zip"))
        assertEquals("a.zip", FirmwareUpdater.safePackageName("https://h/x/y/a.zip"))
        assertEquals("a.zip", FirmwareUpdater.safePackageName("..\\..\\a.zip"))
        assertEquals("a", FirmwareUpdater.safePackageName("../../a"))
        assertEquals("firmware", FirmwareUpdater.safePackageName(""))
        assertEquals("firmware", FirmwareUpdater.safePackageName("///"))
        // The shared sanitiser replaces a control character and a drive-style colon with "_"
        // rather than dropping them — either way nothing a server sends survives as a separator.
        assertEquals("a__zip", FirmwareUpdater.safePackageName("a\u0000:zip"))
        // A Windows reserved device name cannot be taken as a cache file name either.
        assertEquals("_CON.zip", FirmwareUpdater.safePackageName("CON.zip"))
    }
}
