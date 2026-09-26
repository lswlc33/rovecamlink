package com.rovecamlink.app.ui

import com.rovecamlink.app.core.model.DevicePlatform

/**
 * One camera model in the supported-devices list: what it is, what is inside it,
 * and what this app has to speak to drive it.
 *
 * Every field is a fact from `docs/analysis/protocol-matrix.md` (the reverse-engineering
 * archive), carried here verbatim rather than paraphrased — the strings are the ones a
 * user matches against the name printed on the box or the hotspot list.
 */
data class DeviceCatalogEntry(
    /** The model name as the user reads it, e.g. 「XTU S7PRO」. */
    val model: String,
    /** The SoC family the camera runs, e.g. 「Hi3519DV500」. Unknown where the archive does not say. */
    val chip: String?,
    /** The platform (protocol plugin) this model belongs to. */
    val platform: DevicePlatform,
    /** One short line saying what kind of camera this is. */
    val note: String,
)

/**
 * One brand block of the supported-devices list.
 *
 * [wired] says whether **any** protocol for this brand is compiled into this build —
 * it is filled in at render time from the protocol registry ([AppState.protocolFor]),
 * because a catalog entry documents a camera and a registry entry proves the app can
 * drive one. The two are kept apart on purpose: the catalog may list models whose
 * platform has no plugin yet, and the page shows those as 未适配 rather than hiding
 * them.
 */
data class DeviceCatalogBrand(
    /** Brand display name, e.g. 「XTU」. */
    val name: String,
    /** The models under this brand, in the order the page shows them. */
    val models: List<DeviceCatalogEntry>,
    /** The platforms a plugin would have to cover to drive everything in [models]. */
    val platforms: Set<DevicePlatform>,
)

/**
 * The supported-devices catalogue: which cameras this app is built for, by brand,
 * with the protocol and SoC each one needs.
 *
 * The facts come from the archive, not from a camera:
 *  - TUWIN's four models are the official app's own `DeviceType` enum
 *    (`docs/analysis/protocol-matrix §1.1`), the only brand that maps model → protocol explicitly.
 *  - XTU's 18 models are the union of the official app's four device lists
 *    (`docs/analysis/protocol-matrix §2.1`); the chip column marks only what the archive CONFIRMED —
 *    "CGI 家族" means "this family answers the Hi35xx CGI, SoC unconfirmed",
 *    because the official app dispatches on the camera's self-reported `type`,
 *    not on a model table.
 *  - idGoLive's iCatch platform is documented in
 *    `docs/impl/command-surface.md` §0.1 and **is** driven
 *    in this build (`IcatchHttpProtocol`), so XTU's Mini1 and the idGoLive rows read 已适配.
 *
 * What a brand can drive is not decided here: the page asks the registry, so a plugin
 * arriving later flips a row from 未适配 to 已适配 with no edit to this file. Adding a model
 * to the lists below is a **documentation** change, and the row it adds stays 未适配 until
 * something in `brand/` can speak to it.
 *
 * Pure data: the page owns presentation, this owns nothing but the facts.
 */
object DeviceCatalog {

    val brands: List<DeviceCatalogBrand> = listOf(
        DeviceCatalogBrand(
            name = "XTU",
            models = listOf(
                DeviceCatalogEntry("XTU S7PRO", "Hi3519DV500（海思）", DevicePlatform.HISILICON, "运动相机 · 本 App 的主力适配机型"),
                DeviceCatalogEntry("XTU S7PRO MAX", "Hi3519DV500（海思）", DevicePlatform.HISILICON, "运动相机"),
                DeviceCatalogEntry("XTU S6PRO", null, DevicePlatform.AMBARELLA, "运动相机 · Ambarella 平台"),
                DeviceCatalogEntry("XTU S7", null, DevicePlatform.AMBARELLA, "运动相机 · Ambarella 平台"),
                DeviceCatalogEntry("XTU MINI2PRO", null, DevicePlatform.AMBARELLA, "运动相机 · Ambarella 平台"),
                DeviceCatalogEntry("XTU R1", null, DevicePlatform.AMBARELLA, "运动相机 · 芯片待确认"),
                DeviceCatalogEntry("XTU X1", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU X2", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU X3", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU S2", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU S3", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU S3PRO", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU S5K", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU S6", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU MAXPRO", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU MAX2", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU MAX3", null, DevicePlatform.HISILICON, "运动相机 · CGI 家族"),
                DeviceCatalogEntry("XTU Mini1", null, DevicePlatform.ICATCH, "行车记录仪 · iCatch PTP 平台"),
            ),
            platforms = setOf(DevicePlatform.HISILICON, DevicePlatform.AMBARELLA, DevicePlatform.ICATCH),
        ),
        DeviceCatalogBrand(
            name = "TUWIN",
            models = listOf(
                DeviceCatalogEntry("TUWIN Ride3 Pro", null, DevicePlatform.TUWIN_REST, "骑行记录仪 · REST /api + RTSP :8080"),
                DeviceCatalogEntry("TUWIN Ride6", null, DevicePlatform.TUWIN_REST, "骑行记录仪 · REST /api + RTSP :8080"),
                DeviceCatalogEntry("TUWIN Ride5", "Hi3516CV610（海思）", DevicePlatform.HISILICON, "骑行记录仪 · hi3510 CGI 方言"),
                DeviceCatalogEntry("TUWIN M3", "v57 平台（ezgui 固件线）", DevicePlatform.TUWIN_M3, "运动相机 · /app HTTP + TCP 推送"),
            ),
            platforms = setOf(DevicePlatform.TUWIN_REST, DevicePlatform.HISILICON, DevicePlatform.TUWIN_M3),
        ),
    )

    /**
     * True when every platform [brand] names has a registered protocol plugin — the
     * brand's models are all *adapted*, not merely documented. A brand with one
     * unregistered platform (XTU's iCatch Mini1, TUWIN's M3) is partially adapted;
     * the page marks the brand by its weakest member, and the model row by its own.
     */
    fun isAdapted(brand: DeviceCatalogBrand, hasProtocol: (DevicePlatform) -> Boolean): Boolean =
        brand.platforms.all(hasProtocol)
}
