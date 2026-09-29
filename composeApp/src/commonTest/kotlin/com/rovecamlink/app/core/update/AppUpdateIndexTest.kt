package com.rovecamlink.app.core.update

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * The in-app updater's parsing and comparing, without a network.
 *
 * The page above these functions has exactly two jobs that can be wrong in the dark:
 * calling a release "newest" when it is not, and calling a failure "up to date". These
 * tests pin the parsing against real API shapes (captured from this repository's own
 * releases on 2026-09-29) and the version comparison that decides the stable verdict.
 */
class AppUpdateIndexTest {

    // ---------- stable: /releases/latest ----------

    @Test
    fun `stable parses the latest release`() {
        val body = """
            {
              "url": "https://api.github.com/repos/lswlc33/rovecamlink/releases/1",
              "tag_name": "v0.1.3",
              "name": "v0.1.3",
              "prerelease": false,
              "published_at": "2026-09-20T12:00:00Z",
              "body": "notes",
              "assets": [
                {
                  "name": "RoveCamLink-0.1.3.apk",
                  "browser_download_url": "https://github.com/lswlc33/rovecamlink/releases/download/v0.1.3/RoveCamLink-0.1.3.apk",
                  "size": 3899872
                }
              ]
            }
        """.trimIndent()
        val release = AppUpdateIndex.parseStable(body)
        assertEquals("v0.1.3", release?.tagName)
        assertEquals(false, release?.prerelease)
        assertEquals(3_899_872L, release?.apkSizeBytes)
        assertEquals(
            "https://github.com/lswlc33/rovecamlink/releases/download/v0.1.3/RoveCamLink-0.1.3.apk",
            release?.apkUrl,
        )
    }

    /**
     * `releases/latest` answers 404 while every release is a prerelease — GitHub's own
     * semantics. The API error body is what `getText` hands back as the 404's body, and
     * "no stable published" must not be read as "the server is down" or as a verdict.
     */
    @Test
    fun `stable treats an error body as no answer, never as up to date`() {
        assertNull(AppUpdateIndex.parseStable(null))
        assertNull(AppUpdateIndex.parseStable(""))
        assertNull(AppUpdateIndex.parseStable("""{"message":"Not Found","documentation_url":"…"}"""))
        assertNull(AppUpdateIndex.parseStable("not json at all"))
    }

    @Test
    fun `stable falls back to the release page when assets are not a single apk`() {
        val twoApks = """
            {
              "tag_name": "v0.2.0",
              "prerelease": false,
              "assets": [
                {"name": "a.apk", "browser_download_url": "https://x/a.apk", "size": 1},
                {"name": "b.apk", "browser_download_url": "https://x/b.apk", "size": 2}
              ]
            }
        """.trimIndent()
        val release = AppUpdateIndex.parseStable(twoApks)
        // Two APKs mean the release page is hand-edited or a workflow changed shape;
        // picking one blind is not this app's call, so the direct link is dropped and
        // openUrl falls back to the tag page.
        assertNull(release?.apkUrl)
        assertEquals("https://github.com/lswlc33/rovecamlink/releases/tag/v0.2.0", release?.openUrl)
    }

    // ---------- alpha: /releases list ----------

    @Test
    fun `alpha picks the newest timestamped tag across both spellings`() {
        val body = """
            [
              {"tag_name": "v0.1.2", "prerelease": false, "assets": []},
              {"tag_name": "alpha-20260929-140311", "prerelease": true, "published_at": "2026-09-29T14:03:15Z",
               "assets": [{"name": "RoveCamLink-0.1.3-alpha-20260929-140311.apk",
                           "browser_download_url": "https://github.com/lswlc33/rovecamlink/releases/download/alpha-20260929-140311/RoveCamLink-0.1.3-alpha-20260929-140311.apk",
                           "size": 3899872}]},
              {"tag_name": "nightly-20260928-022831", "prerelease": true, "published_at": "2026-09-28T02:28:33Z", "assets": []}
            ]
        """.trimIndent()
        val release = AppUpdateIndex.parseAlpha(body)
        // The stable tag is not an alpha; the choice between the two timestamped ones is
        // by tag string, whose UTC timestamps sort as times — so the 09-29 build wins
        // even though the API listed v0.1.2 first.
        assertEquals("alpha-20260929-140311", release?.tagName)
        assertTrue(release?.prerelease == true)
    }

    /**
     * The order comes from the stamp, never from the whole tag: comparing whole strings
     * puts every `nightly-…` above every `alpha-…` (`"n" > "a"`), which flips the
     * verdict the day after the rename — the first test caught exactly that.
     */
    @Test
    fun `alpha ordering ignores the nightly and alpha prefixes`() {
        val body = """
            [
              {"tag_name": "nightly-20260928-230000", "prerelease": true, "assets": []},
              {"tag_name": "alpha-20260929-140311", "prerelease": true, "assets": []}
            ]
        """.trimIndent()
        // The later stamp wins even though its prefix sorts lower: the prefixes are one
        // channel, and only the stamp is a time.
        assertEquals("alpha-20260929-140311", AppUpdateIndex.parseAlpha(body)?.tagName)
    }

    @Test
    fun `alpha returns nothing when the page carries no timestamped build`() {
        assertNull(AppUpdateIndex.parseAlpha(null))
        assertNull(AppUpdateIndex.parseAlpha("[]"))
        assertNull(AppUpdateIndex.parseAlpha("""[{"tag_name": "v0.1.2", "prerelease": false}]"""))
    }

    @Test
    fun `alpha tag pattern matches both spellings and nothing else`() {
        assertTrue(AppUpdateIndex.alphaTagPattern.matches("alpha-20260929-140311"))
        assertTrue(AppUpdateIndex.alphaTagPattern.matches("nightly-20260928-022831"))
        // Not alpha tags: the stable line, a truncated stamp, a name with junk after it.
        assertEquals(false, AppUpdateIndex.alphaTagPattern.matches("v0.1.3"))
        assertEquals(false, AppUpdateIndex.alphaTagPattern.matches("alpha-20260929"))
        assertEquals(false, AppUpdateIndex.alphaTagPattern.matches("alpha-20260929-140311-x"))
    }

    // ---------- version comparison (stable verdict) ----------

    @Test
    fun `semver orders numerically not lexicographically`() {
        assertEquals(true, AppVersion.parse("0.1.10")!! > AppVersion.parse("0.1.9")!!)
        assertEquals(true, AppVersion.parse("0.2.0")!! > AppVersion.parse("0.1.99")!!)
        assertEquals(true, AppVersion.parse("1.0.0")!! > AppVersion.parse("0.9.9")!!)
        assertEquals(0, AppVersion.parse("0.1.3")!!.compareTo(AppVersion.parse("0.1.3")!!))
    }

    @Test
    fun `semver strips a v prefix caller-side and refuses junk`() {
        // The caller removes the tag's v; the parser itself is strict about what remains.
        assertNull(AppVersion.parse("v0.1.3"))
        assertEquals(AppVersion(0, 1, 3), AppVersion.parse("0.1.3"))
        assertEquals(AppVersion(0, 1, 3), AppVersion.parse(" 0.1.3 "))
        // A suffix this repo does not use yet must not turn "0.1.3-rc1" into 0.1.3's
        // equal — the caller sees null and shows the release instead of a verdict.
        assertNull(AppVersion.parse("0.1"))
        assertNull(AppVersion.parse("alpha"))
        assertNull(AppVersion.parse(null))
    }
}
