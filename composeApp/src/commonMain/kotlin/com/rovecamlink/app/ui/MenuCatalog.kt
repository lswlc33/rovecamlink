package com.rovecamlink.app.ui

/**
 * How the settings screen groups the camera's own menu items.
 *
 * The item list is not ours to choose: `getprimarymenuitem.cgi` returns whatever
 * the firmware exposes for the current work mode, and which items exist is a
 * property of that mode. So the grouping below is applied to whatever comes back,
 * and anything unrecognised lands in [Other] rather than being hidden.
 */
enum class SettingGroup(val zhTitle: String) {
    Quality("画质与编码"),
    Stabilization("防抖与稳定"),
    Capture("录制方式"),
    Exposure("曝光"),
    Colour("色彩"),
    Other("其他"),
}

/**
 * Presentation for one firmware menu item: the Chinese name, an explanation of what
 * changing it does, its group, and translations for the values it can hold.
 */
data class SettingMeta(
    val zhTitle: String,
    val zhHelp: String,
    val group: SettingGroup,
    val zhValues: Map<String, String> = emptyMap(),
)

/**
 * The XTU / Hisilicon CGI menu vocabulary, as this app presents it.
 *
 * The names and allowed values are **the camera's own**: every entry here was read
 * off an XTU S7PRO (Hi3519DV500, firmware 20.8.6.1.20260710) through
 * `getprimarymenuitem`/`getsecondmenuitem` in the 2026-09-21 field session.
 *
 * Where the official XTU GO app has a Chinese label for an item, its wording is
 * reused rather than retranslating — the strings below marked *(官方)* come from
 * `_work/xtu_res/resources/res/values-zh-rCN/strings.xml`. That covers about half
 * the menu: `Resolution`, `Audio`, `Meter Mode`, `Exposure`, `ISO`, `AWB`,
 * `Sharpness`, `Image Quality`, `Filter`, `brightness`, `Contrast`, `Saturation`.
 * For `Gyro EIS`, `LDC`, `VideoEncode`, `Pre-Recording`, `Shutter`, `Scene Mode`
 * and `EIS Anti-Blur` the APK has **no Chinese at all** — it does not translate
 * those names itself either. It fetches `language.xml` from the camera over port
 * 8080 and renders `<lanstr en="…" zh="…"/>` at runtime
 * (`hisilicon/dv/ui/data/connect/ConnectDevice.java:51`,
 * `hisilicon/dv/ui/data/FileUtils.java:126`), so the authoritative Chinese for the
 * remaining items lives on the device, not in the APK. Until that is fetched, the
 * unmarked labels below are ours and are guessable-but-unverified wording — they
 * must never gate behaviour, only describe it.
 *
 * Keep this a pure lookup: it must never decide whether an item exists. A camera
 * that gains or drops a menu entry has to render correctly with no change here.
 */
object MenuCatalog {

    /** Values that repeat across items, translated once. */
    private val shared: Map<String, String> = mapOf(
        "ON" to "开",
        "OFF" to "关",
        "Auto" to "自动",
        "High" to "高",
        "Normal" to "标准",
        "Low" to "低",
        "Middle" to "中",
        "1Min" to "1 分钟",
        "3Min" to "3 分钟",
        "5Min" to "5 分钟",
        "Average" to "平均测光",
        "Center" to "中央重点测光",
        "Spot" to "点测光",
        "Daylight" to "日光",
        "Cloudy" to "阴天",
        "Incandescent" to "白炽灯",
        "Fluorescent" to "荧光灯",
        "Shade" to "阴影",
    )

    private val items: Map<String, SettingMeta> = mapOf(
        // ---- 画质与编码 ----
        "Resolution" to SettingMeta(
            // 官方按上下文分作「视频分辨率」(pref_res_video_size) 与「照片分辨率」
            // (pref_res_image_size)；同一条目名在两种模式下共用，所以这里取不带上下文的
            // 「分辨率」，把上下文交给说明讲清楚。
            zhTitle = "分辨率",
            zhHelp = "决定画面大小和每秒张数。帧率越高动作越顺滑、文件越大；4K 与高帧率互斥，选不了就是当前模式不支持。分辨率也限定可用的防抖档位。",
            group = SettingGroup.Quality,
        ),
        "VideoEncode" to SettingMeta(
            zhTitle = "编码格式",
            zhHelp = "H.265 同画质更省卡、但部分电脑和剪辑软件解码吃力；H.264 兼容性最好、文件更大。",
            group = SettingGroup.Quality,
        ),
        "Image Quality" to SettingMeta(
            zhTitle = "画质",
            zhHelp = "机内决定的码率档位，越高越清晰、体积越大。和分辨率叠在一起影响最终文件大小。",
            group = SettingGroup.Quality,
        ),
        // ---- 防抖与稳定 ----
        "Gyro EIS" to SettingMeta(
            zhTitle = "陀螺仪防抖",
            zhHelp = "用机身陀螺仪数据补偿抖动，档位越高裁边越多、视角越窄。「超级增强/水平线锁定」适合行走和骑行；固定在三脚架时应关掉，否则画面会被反向拖动。",
            zhValues = mapOf(
                "Super" to "超级",
                "Super Enhance" to "超级增强",
                "Gyro Flow" to "陀螺仪跟随",
                "Tilt Correction" to "俯仰矫正",
                "Horizon Stabilization" to "水平线锁定",
                "360° Horizon Correction" to "360° 全向水平线矫正",
            ),
            group = SettingGroup.Stabilization,
        ),
        "LDC" to SettingMeta(
            zhTitle = "镜头畸变校正",
            zhHelp = "把广角的鱼眼边缘拉直，代价是裁掉一圈画面。拍 Vlog 人脸靠前时明显；需要超广角视野时关掉。",
            group = SettingGroup.Stabilization,
        ),
        "EIS Anti-Blur" to SettingMeta(
            zhTitle = "防抖抗模糊",
            zhHelp = "相机把它和防抖放在同一组里，未公开细节；按命名是防抖开启时抑制运动模糊的开关。不清楚就保持默认，它只影响画面观感，不影响能否录制。",
            group = SettingGroup.Stabilization,
        ),
        // ---- 录制方式 ----
        "Segment" to SettingMeta(
            // 官方叫「视频文件长度」(setting_title_video_file_length)，同一个 APK 里
            // pref_res_video_file_length 又译作「循环录影」——两名一实，容易和「录满覆盖」
            // 的循环录像混淆，所以取不带歧义的那个。
            zhTitle = "视频文件长度",
            zhHelp = "把一段长录像切成固定时长的多个文件，防止单个文件过大导致读卡或剪辑出问题。「自动」由相机决定切分点。这不是循环录像：录满不会回头覆盖。",
            group = SettingGroup.Capture,
        ),
        "Audio" to SettingMeta(
            zhTitle = "录影音频",
            zhHelp = "关掉了视频就没有环境声；风噪大的场合可以先关，后期再配乐。",
            group = SettingGroup.Capture,
        ),
        "Pre-Recording" to SettingMeta(
            zhTitle = "预录制",
            zhHelp = "按下快门前先缓存若干秒画面，避免错过动作开头，代价是更耗电、更占卡。部分高分辨率下相机不允许与防抖同时开启。",
            group = SettingGroup.Capture,
        ),
        // ---- 曝光 ----
        "Meter Mode" to SettingMeta(
            zhTitle = "测光模式",
            zhHelp = "相机以哪块区域判断亮度。平均测光最稳；拍逆光人像或需要保住主体亮度时改用点测光。",
            group = SettingGroup.Exposure,
        ),
        "Exposure" to SettingMeta(
            zhTitle = "曝光补偿",
            zhHelp = "在相机自动判定的亮度上加减：往正数画面更亮、往负数更暗。自动档下雪景偏暗、夜景偏亮时用它微调最直接。",
            group = SettingGroup.Exposure,
        ),
        "Shutter" to SettingMeta(
            zhTitle = "快门速度",
            zhHelp = "越快越能冻结动作、运动画面越清晰，但进光变少会起噪点；夜间或室内保持自动。",
            group = SettingGroup.Exposure,
        ),
        "ISO" to SettingMeta(
            zhTitle = "感光度",
            zhHelp = "越高越亮也越有噪点。光线充足时保持自动，只在需要锁定亮度时手动压低。",
            group = SettingGroup.Exposure,
        ),
        // ---- 色彩 ----
        "AWB" to SettingMeta(
            zhTitle = "白平衡",
            zhHelp = "决定「白色」被还原成什么色温。自动会在场景切换时变色，固定一项可以避免一段素材里忽黄忽蓝。",
            zhValues = mapOf("Auto" to "自动"),
            group = SettingGroup.Colour,
        ),
        "Scene Mode" to SettingMeta(
            zhTitle = "场景模式",
            zhHelp = "相机预设的一组曝光与色彩组合。没有匹配的场合时保持自动。",
            group = SettingGroup.Colour,
        ),
        "Sharpness" to SettingMeta(
            zhTitle = "锐度",
            zhHelp = "边缘的清晰程度。调高看着利落但会放大噪点，后期还要调色建议调低。",
            group = SettingGroup.Colour,
        ),
        "Filter" to SettingMeta(
            zhTitle = "滤镜",
            zhHelp = "机内色彩滤镜，直接烧进画面、后期无法还原成原始色彩，拿不准就选标准。",
            group = SettingGroup.Colour,
        ),
        "brightness" to SettingMeta(
            // 官方就叫「亮度」。注意它是色彩风格那组里的画面亮度，不是屏幕亮度
            // (老海思的屏幕亮度是另一条 getscreenbrightness.cgi)。
            zhTitle = "亮度",
            zhHelp = "与「对比度」「饱和度」同属机内画面风格的一组调整，改的是成像曲线，和上面的曝光补偿不是一回事，也不影响屏幕亮度。",
            group = SettingGroup.Colour,
        ),
        "Contrast" to SettingMeta(
            zhTitle = "对比度",
            zhHelp = "明暗之间的反差。调高更通透但暗部容易死黑。",
            group = SettingGroup.Colour,
        ),
        "Saturation" to SettingMeta(
            zhTitle = "饱和度",
            zhHelp = "色彩的浓淡。调高鲜艳但天空、肤色容易溢出。",
            group = SettingGroup.Colour,
        ),
    )

    /** Every item name this catalogue claims to know — kept public so a test can diff it against a real camera listing. */
    val knownItems: Set<String> get() = items.keys

    /** Presentation for a firmware item name, or null when we have no entry for it. */
    fun of(itemId: String): SettingMeta? = items[itemId.trim()]

    fun groupOf(itemId: String): SettingGroup = of(itemId)?.group ?: SettingGroup.Other

    /**
     * The label to show for item [itemId]: our Chinese name when known, otherwise the
     * firmware's own string. Unknown items stay visible on purpose — a camera that
     * gains a menu entry must not silently lose it in this app.
     */
    fun titleOf(itemId: String, firmwareTitle: String): String = of(itemId)?.zhTitle ?: firmwareTitle

    fun helpOf(itemId: String): String? = of(itemId)?.zhHelp

    /** Translate one option value if we know it; resolution-style strings stay as-is. */
    fun valueLabel(itemId: String, value: String): String {
        val zh = of(itemId)?.zhValues?.get(value) ?: shared[value]
        return if (zh == null) value else "$zh（$value）"
    }

    /** Group order for the screen; an empty group is skipped entirely. */
    val groupOrder: List<SettingGroup> = listOf(
        SettingGroup.Quality,
        SettingGroup.Stabilization,
        SettingGroup.Capture,
        SettingGroup.Exposure,
        SettingGroup.Colour,
        SettingGroup.Other,
    )
}
