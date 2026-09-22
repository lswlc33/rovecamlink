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
 * How the settings screen groups the camera's **own** device menu — the pseudo work
 * mode `-workmode=System`, which is not about shooting but about the box: its
 * hotspot, its tones, its standby, its card.
 *
 * A separate axis from [SettingGroup] on purpose. The two menus are fetched and
 * written through different calls (see `AppState.loadSettings` and
 * `AppState.loadDeviceSettings`), they share no item names, and filing the device
 * page under 「画质与编码」 would be wrong for every row on it.
 */
enum class DeviceGroup(val zhTitle: String) {
    Network("网络"),
    Power("电源"),
    Sound("声音"),
    Display("显示与水印"),
    General("通用"),
    Maintenance("存储与维护"),
    Other("其他"),
}

/** Presentation for one item of the device (`System`) menu. Mirrors [SettingMeta]. */
data class DeviceMeta(
    val zhTitle: String,
    val zhHelp: String,
    val group: DeviceGroup,
    val zhValues: Map<String, String> = emptyMap(),
)

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
        // The device menu's own words: `Auto Dormant` answers `60Sec`, and several of
        // its rows list `Default` as an option beside the explicit ones.
        "60Sec" to "60 秒",
        "30Sec" to "30 秒",
        "Default" to "默认",
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

    /**
     * The device (`System`) menu, item for item as the camera lists it.
     *
     * Same rule as [items]: this only *labels*, and an item the camera stops
     * sending, or sends with a new name, still renders. The names and current values
     * below are verbatim from the XTU S7PRO's `getprimarymenuitem.cgi?-workmode=System`
     * in the 2026-09-22 field log —
     * `WiFi Frequency,Wi-Fi,Auto Dormant,Auto Power Off,Language,Video Format,Frequency,
     * Voice Volume,SubScreen Display,LEDs,Date Stamp,Stamp,Power Tone,Key Tone,Cap Tone,
     * Grid,Quick-Start Switch,Voice Control,SD Format,Factory Reset,Information`
     * with `cur` = `5G,,60Sec,3Min,简体中文,NTSC,50Hz,Default,Default,ON,ON,OFF,OFF,OFF,
     * OFF,ON,ON,OFF,,,`.
     *
     * Where a help line says 未确证, the wording is ours and the behaviour has not
     * been checked against the camera — the official app translates these from a
     * `language.xml` it fetches off the device over port 8080, which this app does not
     * implement. A label may be imprecise; it must never be load-bearing.
     */
    private val deviceItems: Map<String, DeviceMeta> = mapOf(
        // ---- 网络 ----
        "WiFi Frequency" to DeviceMeta(
            zhTitle = "Wi-Fi 频段",
            zhHelp = "相机热点用 5G 还是 2.4G。5G 更干净但穿墙差，旧手机、部分笔记本和车机直接搜不到 5G 热点；「蓝牙已唤醒但手机连不上」时先把这里切到 2.4G 再试一次。改动会让热点重启。",
            group = DeviceGroup.Network,
            zhValues = mapOf("5G" to "5 GHz", "2.4G" to "2.4 GHz"),
        ),
        "Wi-Fi" to DeviceMeta(
            zhTitle = "Wi-Fi 名称",
            zhHelp = "相机热点广播的名字。这台相机在这一行没有给出可显示的取值，改名会重启热点、需要重新连接；本页「相机 Wi-Fi」分组里有同样的入口。",
            group = DeviceGroup.Network,
        ),
        // ---- 电源 ----
        "Auto Dormant" to DeviceMeta(
            zhTitle = "自动休眠",
            zhHelp = "没有操作多久后进入待机：不断电，唤醒快，靠按键或蓝牙都能叫醒。长时间值守建议调长，频繁休眠会让每次连接都多等几秒。",
            group = DeviceGroup.Power,
        ),
        "Auto Power Off" to DeviceMeta(
            zhTitle = "自动关机",
            zhHelp = "待机后再过多久彻底关机。设得短省电，但彻底关机后只能按机身按键开机；上面「自动休眠」那档的待机才是本 App 能用蓝牙叫醒的状态（断电后蓝牙是否还供电尚未在真机上确证）。",
            group = DeviceGroup.Power,
        ),
        // ---- 声音 ----
        "Voice Volume" to DeviceMeta(
            zhTitle = "语音音量",
            zhHelp = "相机外放提示语音（开机提示、操作反馈）的响度，和下面三个提示音开关各自独立。",
            group = DeviceGroup.Sound,
        ),
        "Power Tone" to DeviceMeta(
            zhTitle = "开关机提示音",
            zhHelp = "开机、关机时是否发声。和「自动关机」一起用：待机到点自动关机时也会响一声，夜里值守可以关掉。",
            group = DeviceGroup.Sound,
        ),
        "Key Tone" to DeviceMeta(
            zhTitle = "按键音",
            zhHelp = "按下机身按键时的「滴」声，只反馈按键，不代表开始或停止录制。",
            group = DeviceGroup.Sound,
        ),
        "Cap Tone" to DeviceMeta(
            zhTitle = "拍照提示音",
            zhHelp = "拍照/录制起止时的提示音。部分市场要求这个声音不能关闭；关掉后只能靠指示灯和画面判断是否已经拍下。",
            group = DeviceGroup.Sound,
        ),
        "Voice Control" to DeviceMeta(
            zhTitle = "语音控制",
            zhHelp = "用口令开始/停止录制。手持、骑行风噪大的场合识别率有限，默认关闭。",
            group = DeviceGroup.Sound,
        ),
        // ---- 显示与水印 ----
        "SubScreen Display" to DeviceMeta(
            zhTitle = "副屏显示",
            zhHelp = "机身小屏（如果有）显示的内容档位。未确证：这台相机把它和主屏设置并列，取值只给出 Default。",
            group = DeviceGroup.Display,
        ),
        "LEDs" to DeviceMeta(
            zhTitle = "指示灯",
            zhHelp = "机身工作指示灯。夜间拍摄或放在稳定器上时关掉可以避免反光和干扰。",
            group = DeviceGroup.Display,
        ),
        "Date Stamp" to DeviceMeta(
            zhTitle = "日期水印",
            zhHelp = "把拍摄日期烧进画面。烧进去的无法在后期去掉，素材还要调色或剪辑时建议关掉。",
            group = DeviceGroup.Display,
        ),
        "Stamp" to DeviceMeta(
            zhTitle = "水印",
            zhHelp = "与「日期水印」并列的另一档水印开关，按相机自带样式在画面角上叠加信息。未确证两者关系（谁包含谁），先各自试再定档。",
            group = DeviceGroup.Display,
        ),
        "Grid" to DeviceMeta(
            zhTitle = "参考网格",
            zhHelp = "取景构图用的参考线，只影响取景画面，不会记录进成片。",
            group = DeviceGroup.Display,
        ),
        // ---- 通用 ----
        "Language" to DeviceMeta(
            zhTitle = "相机语言",
            zhHelp = "相机屏幕菜单与提示音使用的语言，改这里不影响本 App 的界面语言。",
            group = DeviceGroup.General,
        ),
        "Video Format" to DeviceMeta(
            zhTitle = "视频制式",
            zhHelp = "NTSC / PAL，决定可用帧率的基准（NTSC 走 30/60，PAL 走 25/50）。与国内电视、投影仪不一致时可能在回放里出现闪烁，成片本身不受影响。",
            group = DeviceGroup.General,
        ),
        "Frequency" to DeviceMeta(
            zhTitle = "电源频率",
            zhHelp = "抗频闪档位，与国内 50Hz 电网对应。选错会在灯光下录像出现滚条，和上面的「视频制式」是两件事。",
            group = DeviceGroup.General,
            zhValues = mapOf("50Hz" to "50 Hz", "60Hz" to "60 Hz"),
        ),
        "Quick-Start Switch" to DeviceMeta(
            zhTitle = "快速启动",
            zhHelp = "关机/待机状态下一键进入录制的那套流程。未确证：官方把它放在设备菜单里，具体是长按开录还是短按唤醒需要现场对比。",
            group = DeviceGroup.General,
        ),
        // ---- 存储与维护 ----
        "SD Format" to DeviceMeta(
            zhTitle = "存储卡格式化",
            zhHelp = "清空卡上全部文件，包括还没有下载的视频，删掉的文件无法恢复。本页「存储卡」分组里有同样的按钮。",
            group = DeviceGroup.Maintenance,
        ),
        "Factory Reset" to DeviceMeta(
            zhTitle = "恢复出厂设置",
            zhHelp = "把相机菜单恢复到出厂状态，包括热点名称和密码——重置后本 App 里保存的连接记录会失效，需要重新连接。",
            group = DeviceGroup.Maintenance,
        ),
        "Information" to DeviceMeta(
            zhTitle = "相机信息",
            zhHelp = "只读条目，固件用它把版本信息排在菜单末尾；本页「关于」分组已经列出同样的内容。",
            group = DeviceGroup.Maintenance,
        ),
    )

    /** Every item name this catalogue claims to know — kept public so a test can diff it against a real camera listing. */
    val knownItems: Set<String> get() = items.keys

    /** Every device (`System`) menu name this catalogue claims to know. */
    val knownDeviceItems: Set<String> get() = deviceItems.keys

    /** Presentation for a firmware item name, or null when we have no entry for it. */
    fun of(itemId: String): SettingMeta? = items[itemId.trim()]

    /** Presentation for one device-menu item, or null when we have no entry for it. */
    fun deviceOf(itemId: String): DeviceMeta? = deviceItems[itemId.trim()]

    fun groupOf(itemId: String): SettingGroup = of(itemId)?.group ?: SettingGroup.Other

    fun deviceGroupOf(itemId: String): DeviceGroup = deviceOf(itemId)?.group ?: DeviceGroup.Other

    /**
     * The label to show for item [itemId]: our Chinese name when known, otherwise the
     * firmware's own string. Unknown items stay visible on purpose — a camera that
     * gains a menu entry must not silently lose it in this app.
     *
     * [device] picks the menu, not just the wording: `System` and a work mode share no
     * names, and the row that writes the value goes to a different CGI depending on it.
     */
    fun titleOf(itemId: String, firmwareTitle: String, device: Boolean = false): String =
        (if (device) deviceOf(itemId)?.zhTitle else of(itemId)?.zhTitle) ?: firmwareTitle

    fun helpOf(itemId: String, device: Boolean = false): String? =
        if (device) deviceOf(itemId)?.zhHelp else of(itemId)?.zhHelp

    /** Translate one option value if we know it; resolution-style strings stay as-is. */
    fun valueLabel(itemId: String, value: String, device: Boolean = false): String {
        val zh = (if (device) deviceOf(itemId)?.zhValues else of(itemId)?.zhValues)?.get(value) ?: shared[value]
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

    /** Group order for the device page, same rule as [groupOrder]. */
    val deviceGroupOrder: List<DeviceGroup> = listOf(
        DeviceGroup.Network,
        DeviceGroup.Power,
        DeviceGroup.Sound,
        DeviceGroup.Display,
        DeviceGroup.General,
        DeviceGroup.Maintenance,
        DeviceGroup.Other,
    )
}

/**
 * How this app labels the camera's shooting modes.
 *
 * The list of modes is the firmware's (`getallworkmode.cgi`, or the names the camera
 * answers a menu request for). This table only labels them, and says what the shutter
 * has to do in each, so a firmware that adds a mode still shows up — under its own
 * English name, never hidden.
 *
 * The Chinese here is ours, not the official app's: XTU GO ships no Chinese for mode
 * names at all. It downloads `language.xml` from the camera over raw TCP on port 8080
 * and renders `<lanstr en="Normal Video" zh="…"/>` at runtime
 * (`_work/xtu_src/.../sigmastar/data/connect/ConnectDevice.java:44-56`,
 * `hisilicon/dv/ui/data/FileUtils.java:126`), which this app cannot reach without a
 * socket transport it does not have. Where an official Chinese string *does* exist in
 * the APK it is reused, and marked *(官方)*.
 */
object ModeCatalog {

    /** Firmware mode name → Chinese label + one-line description of what it captures. */
    private data class ModeMeta(val zhTitle: String, val zhHelp: String)

    private val items: Map<String, ModeMeta> = mapOf(
        "Normal Video" to ModeMeta("普通录像", "最常用的录像档：正常速度、正常声音。"),
        "Slow Motion" to ModeMeta("慢动作", "高帧率拍摄、正常速度回放，画面被放慢。分辨率决定能慢多少倍。"),
        "Timelapse Video" to ModeMeta("延时录像", "按固定间隔取帧并合成短视频，适合云走、日照变化等缓慢场景。"),
        "Car Looping" to ModeMeta("循环录像", "写满存储卡后从最旧一段开始覆盖，行车或长时间值守用。"),
        "Loop Video" to ModeMeta("循环录像", "写满存储卡后从最旧一段开始覆盖。"),
        "Quick Stories" to ModeMeta("快拍短片", "按下即录一段固定时长的短片，录满自动停止。"),
        "Quick Video" to ModeMeta("快录", "从待机直接开录，跳过开机流程。"),
        "Under Water" to ModeMeta("水下模式", "偏蓝的水下场景下校正色彩与曝光。"),
        "Video and Photo" to ModeMeta("录像中拍照", "一边录像一边抓静态照片，不必停下来切换。"),
        "Time Stretch" to ModeMeta("变速录像", "同一段素材里改变播放速度。"),
        "Manual Recsnap" to ModeMeta("手动录像快照", "录像中由你按下的瞬间存一张照片。"),
        "Normal Photo" to ModeMeta("拍照", "按一下拍一张。"),
        "Raw Photo" to ModeMeta("Raw 拍照", "*(官方)* 保存未处理的原始画面，后期空间最大、文件最大。"),
        "Burst Photo" to ModeMeta("连拍", "*(官方)* 一次按下拍出连续多张，张数由设置里的张数项决定。"),
        "Timing Photo" to ModeMeta("定时拍照", "*(官方)* 按设定的间隔持续拍一张又一张，需要再按一次才停。"),
        "Timelapse Photo" to ModeMeta("延时拍照", "*(官方)* 按间隔拍照并可用于合成延时画面，需要再按一次才停。"),
        "Lapse Photo" to ModeMeta("延时拍照", "同上，另一版固件的写法。"),
        "Night Timelapse Photo" to ModeMeta("夜景延时", "*(官方)* 夜间长曝光连拍。"),
        "Night Photo" to ModeMeta("夜景拍照", "夜间单张，曝光时间更长。"),
        "Night Scene" to ModeMeta("夜景模式", "夜间场景预设。"),
        "Long Exposure" to ModeMeta("长曝光拍照", "*(官方)* 快门长时间打开，拍车灯轨迹、星轨。需要把相机固定住。"),
        "Lapse Burst" to ModeMeta("延时连拍", "每个间隔连拍一组。"),
    )

    /** The firmware's own name when we have no label for it — never hide a mode. */
    fun titleOf(name: String): String = items[name.trim()]?.zhTitle ?: name

    fun helpOf(name: String): String? = items[name.trim()]?.zhHelp

    /** Every mode name this catalogue knows, so a test can diff it against a real listing. */
    val knownModes: Set<String> get() = items.keys
}
