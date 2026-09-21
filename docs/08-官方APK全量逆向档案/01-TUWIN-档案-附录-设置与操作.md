# TUWIN 档案 · 附录：设置与操作

> 数据来源：反编译产物 `_work/tuwin_src/sources/com/tuwinsmart/**`（jadx），以及机器提取表 `_work/re/tuwin/**`。
> 引用格式：`_work/tuwin_src/sources/com/tuwinsmart/.../Foo.java:123`，行号取自 jadx 输出（与 `api/*.md`、`catalog-*.md` 中的行号一致）。

## 本附录覆盖范围

1. **设置项全表** —— Ride3Pro / Ride6（设备下发 XML 菜单 + App 侧写死的 id 映射）、M3（显式参数名表 + `getparamitems`）、Ride5（CGI 通道）、以及 App 本地设置（`MoreSettingsActivity`、WiFi、存储、固件、重置、重启）。
2. **拍摄模式常量表** —— M3 `ShootingMode` 全部 10 个模式常量；Ride3Pro/Ride5 模式来源与切换时发出的报文。
3. **页面与入口** —— 从 `layouts.md` + Activity/Fragment 还原主页、预览、设置、回放、传输列表、弹窗；每页控件文案与点击去向。
4. **操作复现表** —— 连接、录像、拍照/连拍/延时/慢动作、切模式、回放、缩略图、下载、删除、格式化、恢复出厂、改 WiFi、对时、重启、固件升级、预览起流。逐条给出：前置状态 → 请求序列（含参数值）→ 成功判据 → 失败分支与提示文案资源 ID。
5. **状态与轮询** —— 轮询端点、间隔毫秒、状态字段取值、UI 置灰规则。
6. **对 `docs/03` §1.5 的纠正**。

## 未覆盖（由「附录：协议面/机型/HTTP 语义」负责）

- 各机型 HTTP/TCP/RTSP 端点矩阵、鉴权与 `Authorization` 头生成、端口分配、`DeviceProtocolProfile` 探测语义。
- 云/互联网侧 API（`INTERNET_API` 命名空间）、反馈与诊断上传、埋点。
- 固件包本体格式与 `OtaPackageGroupPolicy` 的解析规则（本附录只写用户在升级流程中看到的文案与按钮）。
- `core/network`、`core/transfer` 的底层管道实现；本附录只在「点了发生什么」的粒度引用。
- idGoLive / XTU GO 两品牌（另见 `03-idGoLive-档案-*`）。

---

## 1. 设置项全表

> Ride3Pro / Ride6 的设置页是**运行时从相机拉 XML 菜单**（`GET /api/menu/xml`），APK 内不承载完整参数表。
> 但 APK 内**写死了三张映射表**：静态兜底菜单（含每项的 `0x…` id 与 type）、英文项名→中文资源 id、英文选项值→中文资源 id。三张全抄在下面。

### 1.1 Ride3Pro / Ride6：设备下发 XML 菜单

拉取与解析：`Ride6SettingsProtocolClient.load()` → `Ride3ProApiService.getMenuXml()` → `Ride3ProMenuXmlParser.parse()`。

- 端点：`GET /api/menu/xml`，返回 `ResponseBody`（流式）。声明见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:36-38`（`@Streaming @GET("/api/menu/xml")`）。
- 菜单通道专用超时：`MENU_CONNECT_TIMEOUT_MILLIS = 5000`、`MENU_READ_TIMEOUT_MILLIS = 30000`、`MENU_READ_BUFFER_SIZE = 8192`、`MENU_MAX_RESPONSE_BYTES = 524288`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:66-75`）。
- 解析器硬拒 `<!DOCTYPE`（大小写不敏感）：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuXmlParser.java:33-35`，异常文本 `"WIFI_MENU.xml must not contain a document type declaration"`。
- 空 categories 亦硬失败：`Ride6SettingsProtocolClient.java:193-195`，异常文本 `"R6 WIFI_MENU.xml does not contain any categories"`。
- Schema（全部按**直接子元素**取值，无属性）：
  - `<Category>` — 文档中任意深度都会被 `getElementsByTagName("Category")` 抓到（`Ride3ProMenuXmlParser.java:41`）
    - `<Name>` → 分区显示名（`Ride3ProMenuXmlParser.java:50`）
    - `<Setting>` — **仅 Category 的直接子元素**（`Ride3ProSettingsRuntimeMapperKt.childElements`，`Ride3ProSettingsRuntimeMapperKt.java:59-76`）
      - `<Name>` → 项显示名（:58）
      - `<ID>` → 项 id，形如 `0x0000000`（:60）
      - `<Type>` → 类型码（:62）
      - `<Default>` → 默认值（:64）
      - `<Value>`* → 仅 Setting 的直接子元素（:65）
        - `<Name>` → 选项显示名（:71）
        - `<ID>` → 选项值（:74）
  - 缺元素的兜底：全部 `""`；`values` 缺省为 `emptyList`（`Ride3ProMenuSetting` 构造掩码 32，`Ride3ProMenuXmlParser.java:81`）。
- `<Type>` 语义（`ride3ProSettingTypeCode` = 十六进制/十进制宽容解析，`Ride3ProSettingsRuntimeMapperKt.java:17-35`）：

  | Type 数值 | 显示逻辑（`Ride3ProSettingsRuntimeMapper.java:53-94`） | 是否发 `getparameter` |
  |---|---|---|
  | `0` | 用 `<Value>` 列表按选中项反查 `<Name>` 显示（:58-69） | 否（走 `getparameter?id=all` 批量） |
  | `1` | 显示 `actionLabel`，默认 `"Execute"`（:79-81，`toDisplaySections$default` :22-27） | 是（单独 `getparameter?id=<requestId>`，:361） |
  | `2` | 直接显示原始字符串值（:70-77） | 否 |
  | `3` | 同 `0`，按 `<Value>` 反查显示（:58） | 否 |
  | `4` | 显示 `actionLabel`（:82-84） | 是（同 `1`） |
  | 其它/无法解析 | 原值 → `<Default>` → `""`（:85-93） | 否 |

  `1` 与 `4` 被显式列为「需要单独查询」的两类：`SetsKt.setOf(Integer 1, Integer 4)`（`Ride6SettingsProtocolClient.java:361`、`:390`、`:449`）。

**值域约束（静态可确定的）**：`WIFI_PASSWORD` 项固定 8 字符，`Ride3ProWifiSettingsPolicy.isValidPassword` 用 `codePointCount(...) == 8`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProWifiSettingsPolicy.java:12`（`WIFI_PASSWORD_LENGTH = 8`）、`:22-24`）。

### 1.2 Ride3Pro / Ride6：App 写死的映射表

#### 1.2.1 静态兜底菜单（`Ride3ProSettingsMenuPolicy.buildSections()`）

来源：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsMenuPolicy.java:18-20`。整段是一个 `listOf(...)`，`Ride3ProSettingsItem(name, id, type, displayValue="", rawValue="", values=[], ...)`，共 **4 个分区 / 31 项**。中文列查 `Ride6SettingsLocalizer.settingNameMap`（1.2.3）。

| 分区（英文 → 中文资源） | 项名（英文） | 项 id | Type | 默认显示值 | 中文文案（`values-zh`） |
|---|---|---|---|---|---|
| `Record` → `ride6_section_record`「录像」 | Resolution | `0x0000000` | `0x00` | `0x00` | 分辨率（`ride6_setting_resolution`） |
| | Exposure | `0x0000001` | `0x00` | `0x00` | 曝光 |
| | Motion Detection | `0x0000002` | `0x00` | `0x00` | 移动侦测 |
| | Loop Recording | `0x0000003` | `0x00` | `0x00` | 循环录像 |
| | WDR | `0x0000004` | `0x00` | `0x00` | 宽动态 |
| | Record Audio | `0x0000005` | `0x00` | `0x00` | 录音 |
| | Date Stamp | `0x0000006` | `0x00` | `0x00` | 日期水印 |
| `Capture` → `ride6_section_capture`「拍照」 | Resolution | `0x00000100` | `0x00` | `0x00` | 分辨率 |
| | Exposure | `0x0000101` | `0x00` | `0x00` | 曝光（注意：id 少一位，源码原文如此） |
| | Quality | `0x00000102` | `0x00` | `0x00` | 画质 |
| | Sequence | `0x00000103` | `0x00` | `0x00` | 连拍 |
| | Sharpness | `0x00000104` | `0x00` | `0x00` | 锐度 |
| | ISO | `0x00000105` | `0x00` | `0x00` | ISO（中文差异表未覆盖，显示英文 `ISO`） |
| | Anti-Shaking | `0x00000106` | `0x00` | `0x00` | 防抖 |
| | Date/Time | `0x00000107` | `0x00` | `0x00` | 日期/时间 |
| | White Balance | `0x00000108` | `0x00` | `0x00` | 白平衡 |
| `System` → `ride6_section_system`「系统」 | Frequency | `0x00000200` | `0x00` | `0x00` | 频率 |
| | Screen Saver | `0x00000201` | `0x00` | `0x00` | 屏保 |
| | Auto Power Off | `0x00000202` | `0x00` | `0x00` | 自动关机 |
| | Language | `0x00000203` | `0x00` | `0x00` | 语言 |
| | Beep Sound | `0x00000204` | `0x00` | `0x00` | 按键音 |
| | Date/Time | `0x00000205` | `0x00` | `0x00` | 日期/时间 |
| | Clear Buffer | `0x00000206` | `0x04` | `0x04` | 清除缓存 |
| | Format | `0x00000207` | `0x01` | `0x01` | 格式化 |
| | Default Setting | `0x00000208` | `0x01` | `0x01` | 恢复默认 |
| | Version | `0x00000209` | `0x03` | `0x03` | 版本 |
| `Wifi` → `ride6_section_wifi`「网络」 | WifiName | `0x00000300` | `0x02` | `0x02` | WiFi 名称 |
| | Password | `0x00000301` | `0x02` | `0x02` | 密码 |

注意：这份兜底表**没有** `<Value>` 列表（`values = emptyList`），所以静态无法确定每一项的取值集合；取值集合只在设备真实下发的 XML 里。`Type` 语义见 1.1 表。

`Ride6SettingsCompatibilityPolicy` 用 `0x` id 做兼容判定（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsCompatibilityPolicy.java`）：
- `FACTORY_RESET_ID = "0x0000208"`（:17）—— 与兜底表的 `Default Setting` id `0x00000208` **位数不同**，靠 `parameterIdsEqual`（`Ride6SettingsProtocolClientKt`）做数值化比较。
- `WIFI_PASSWORD_ID = "0x0000301"`（:19）—— 同理对 `Password`。
- `isFactoryReset(item)` = `requestId == "factory_reset"`（忽略大小写）OR id 数值等于 `0x208`（:41-44）。
- `isWifiPassword(item)` = `requestId == "wifi_passwd"` OR `name == "Password"` OR id 数值等于 `0x301`（:36-39）。
- 命中 `factory_reset` 成功后，把缓存的 WiFi 密码重置回 `ConnectedDevice.DEFAULT_WIFI_PASSWORD`（:46-56）。

#### 1.2.2 线上传输 id（`Ride6ParameterRequestIds`）—— 全 9 个 + 归一化推导规则

常量声明：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:18-27`。
`normalize()` = trim → `toLowerCase(Locale.ROOT)` → 只保留字母数字（:163-184）。
`forSetting(sectionName, settingName)` 的**完整分支**（:40-161；已按 jadx 的 `case` hashCode 反查字符串还原，hashCode 逐个核对过）：

| 归一化后的项名 | 归一化后的分区名条件 | 返回的线上 id |
|---|---|---|
| `defaultsetting` | `""` 或 `system` | `factory_reset` |
| `factoryreset` | 非空（任意） | `factory_reset` |
| `exposure` | `""` 或 `record` | `record_exposure` |
| `recordexposure` | 无（任意） | `record_exposure` |
| `looprecording` | `""` 或 `record` | `record_loop_recording` |
| `recordlooprecording` | 无（任意） | `record_loop_recording` |
| `resolution` | `""` 或 `record` | `record_resolution` |
| `recordresolution` | 无（任意） | `record_resolution` |
| `frequency` | `""` 或 `system` | `system_frequency` |
| `systemfrequency` | 无（任意） | `system_frequency` |
| `version` | `""` 或 `system` | `system_version` |
| `systemversion` | 无（任意） | `system_version` |
| `wifiname` | `""` 或 `wifi` | `wifi_name` |
| `ssid` | 非空（任意） | `wifi_name` |
| `wifipasswd` | `""` 或 `wifi` | `wifi_passwd` |
| `password` | 非空（任意） | `wifi_passwd` |
| 其它 | — | `null` |

`ALL = "all"`（:18）不参与 `forSetting`，是批量读专用 id。

线上 id 的用武之地：
- 读：`GET /api/menu/getparameter?id=<id>`；批量 `id=all`（`Ride6SettingsProtocolClient.java:410`）→ `Ride3ProApiService.java:33-34`（`@GET("/api/menu/getparameter")`）。
- 写：`GET /api/menu/setparameter?id=<id>&value=<v>`（`Ride3ProApiService.java:60-61`；调用点 `Ride6SettingsProtocolClient.java:254`）。
- `Format` 项特殊：**不走 setparameter**，直接 `GET /api/system/formatsd`（`Ride6SettingsProtocolClient.java:239-242` + `Companion.isFormatSetting` :521-523，判定条件是 `item.name` 忽略大小写等于 `"Format"`，用的是**本地化名之前的英文名**）。
- `requestId == null` 时 `update()` 会先按项名重算一次；仍为 null 则抛 `IllegalStateException("R6 setting does not have a protocol request ID: " + name)`（`Ride6SettingsProtocolClient.java:248-251`）。
- 失败抛 `IllegalStateException("R6 setting update failed: id=" + (requestId ?: name) + ", " + errorMessage)`（:272-278）。
- 批量读失败仅打 warn：`"R6 GetParameter(all) failed: %s"`（:417）、`"R6 GetParameter failed: id=%s, %s"`（:357、:386）。

#### 1.2.3 英文 → 中文本地化映射（`Ride6SettingsLocalizer`）

来源：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsLocalizer.java:29-31`。三张表都是 `trim().toLowerCase(Locale.ROOT)` 后查，未命中就原样显示（:64-89）。中文文本取自 `docs/../res-strings-zh.md` 的 `values-zh`。

分区名表 `sectionNameMap`（4 条）：

| 英文（归一化） | 资源 | 中文 | 英文默认 |
|---|---|---|---|
| `record` | `ride6_section_record` | 录像 | Recording |
| `capture` | `ride6_section_capture` | 拍照 | Capture |
| `system` | `ride6_section_system` | 系统 | System |
| `wifi` | `ride6_section_wifi` | 网络 | Wi-Fi |

项名表 `settingNameMap`（25 条）：

| 英文（归一化） | 资源 | 中文 |
|---|---|---|
| `resolution` | `ride6_setting_resolution` | 分辨率 |
| `exposure` | `ride6_setting_exposure` | 曝光 |
| `motion detection` | `ride6_setting_motion_detection` | 移动侦测 |
| `loop recording` | `ride6_setting_loop_recording` | 循环录像 |
| `wdr` | `ride6_setting_wdr` | 宽动态 |
| `record audio` | `ride6_setting_record_audio` | 录音 |
| `date stamp` | `ride6_setting_date_stamp` | 日期水印 |
| `quality` | `ride6_setting_quality` | 画质 |
| `sequence` | `ride6_setting_sequence` | 连拍 |
| `sharpness` | `ride6_setting_sharpness` | 锐度 |
| `iso` | `ride6_setting_iso` | （中文表无覆盖 → 显示英文 `ISO`） |
| `anti-shaking` | `ride6_setting_anti_shaking` | 防抖 |
| `date/time` | `ride6_setting_date_time` | 日期/时间 |
| `white balance` | `ride6_setting_white_balance` | 白平衡 |
| `frequency` | `ride6_setting_frequency` | 频率 |
| `screen saver` | `ride6_setting_screen_saver` | 屏保 |
| `auto power off` | `ride6_setting_auto_power_off` | 自动关机 |
| `language` | `ride6_setting_language` | 语言 |
| `beep sound` | `ride6_setting_beep_sound` | 按键音 |
| `clear buffer` | `ride6_setting_clear_buffer` | 清除缓存 |
| `format` | `ride6_setting_format` | 格式化 |
| `default setting` | `ride6_setting_default_setting` | 恢复默认 |
| `version` | `ride6_setting_version` | 版本 |
| `wifiname` | `ride6_setting_wifi_name` | WiFi 名称 |
| `password` | `ride6_setting_password` | 密码 |

选项值表 `valueMap`（22 条）：

| 英文（归一化） | 资源 | 中文 | 英文默认 |
|---|---|---|---|
| `off` | `ride6_value_off` | 关 | Off |
| `on` | `ride6_value_on` | 开 | On |
| `auto` | `ride6_value_auto` | 自动 | Auto |
| `english` | `ride6_value_english` | 英文 | English |
| `traditional chinese` | `ride6_value_traditional_chinese` | 繁体中文 | Traditional Chinese |
| `simplified chinese` | `ride6_value_simplified_chinese` | 简体中文 | Simplified Chinese |
| `date` | `ride6_value_date` | 日期 | Date |
| `date/time` | `ride6_value_date_time` | 日期/时间 | Date/Time |
| `1 minute` | `ride6_value_one_minute` | 1 分钟 | 1 minute |
| `2 minutes` | `ride6_value_two_minutes` | 2 分钟 | 2 minutes |
| `3 minutes` | `ride6_value_three_minutes` | 3 分钟 | 3 minutes |
| `5 minutes` | `ride6_value_five_minutes` | 5 分钟 | 5 minutes |
| `10 minutes` | `ride6_value_ten_minutes` | 10 分钟 | 10 minutes |
| `fine` | `ride6_value_fine` | 精细 | Fine |
| `normal` | `ride6_value_normal` | 普通 | Normal |
| `economical` | `ride6_value_economical` | 经济 | Economical |
| `strong` | `ride6_value_strong` | 强 | Strong |
| `soft` | `ride6_value_soft` | 柔和 | Soft |
| `daylight` | `ride6_value_daylight` | 日光 | Daylight |
| `cloudy` | `ride6_value_cloudy` | 阴天 | Cloudy |
| `tungsten` | `ride6_value_tungsten` | 钨丝灯 | Tungsten |
| `fluorescent` | `ride6_value_fluorescent` | 荧光灯 | Fluorescent |

**没有**分辨率档位（如 `1080p30`）、无 `240/480fps`、无 `HDR` 的映射 —— 这类值在中文环境按原文直出（`localizeValueName` 未命中返回 `raw`）。

#### 1.2.4 Ride3Pro 通用（非菜单）设置项 —— 固定 7 行卡片

`Ride3ProSimpleSettingsMenuPolicy.build(deviceName, features)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSimpleSettingsMenuPolicy.java:31-49`）；`features` 来自 `GET /api/device/info` 的 `features` 字段（`Ride3ProDeviceInfo.java` 的 `List<String> features`），先经 `Ride3ProProtocolFeatures.normalize`（trim + lowercase ROOT + 去空，`Ride3ProProtocolFeatures.java:24-40`）。

| 顺序 | 类型（`Ride3ProSimpleSettingsItemType`） | 资源 id | 中文 | 显示值 | 出现条件 | 点击行为 |
|---|---|---|---|---|---|---|
| 1 | `DEVICE_NAME` | `device_name_label` | 设备名称 | 设备名（`resolveDeviceName()`） | 恒有 | 弹 `Alert.Type.INPUT`，标题 `modify_device_name`「修改设备名称」→ 见 §4 |
| 2 | `WIFI` | `wifi_password_settings` | WiFi密码设置 | — | `features` 含 `nv` | 弹输入框改密码 |
| 3 | `STORAGE` | `storage_management` | 存储管理 | — | 恒有 | 跳存储页 |
| 4 | `FIRMWARE` | `firmware_upgrade` | 固件升级 | — | 恒有 | 跳升级页 |
| 5 | `FACTORY_RESET` | `factory_reset` | 恢复出厂设置 | — | `features` 含 `nv` | 确认弹窗 → `setparameter?id=factory_reset` |
| 6 | `REBOOT` | `reboot_device` | 重启设备 | — | `features` 含 `reboot` | 确认弹窗 → `GET /api/reboot` |

`Ride3ProProtocolFeatures` 两个 feature 字面量：`NV = "nv"`、`REBOOT = "reboot"`（`Ride3ProProtocolFeatures.java:20-21`）。
枚举本身 6 个常量：`DEVICE_NAME / WIFI / STORAGE / FIRMWARE / FACTORY_RESET / REBOOT`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSimpleSettingsItemType.java:12-17`）。
`Ride6SettingsCompatibilityPolicy.supplementalMenuFeatures()` 只从扩展菜单里透传 `reboot` 一个 feature（`Ride6SettingsCompatibilityPolicy.java:24-34`）。

### 1.4 M3：显式参数名表（22 个）与取值来源

M3 的参数名 → 中文标题映射在 `M3SettingNameMapper.nameToStringIdMap`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/M3SettingNameMapper.java:17`），**共 22 条，逐个列全**：

| 参数名（线上 `param`） | 资源 id | 中文（`values-zh`） | 英文默认 | 读写接口 |
|---|---|---|---|---|
| `rec_resolution` | `m3_setting_rec_resolution` | 分辨率 | Resolution | 读 `GET /app/getparamitems?param=all_<modeId>`；写 `GET /app/setparamvalue?param=rec_resolution&value=<index>` |
| `anti_shake` | `m3_setting_anti_shake` | 防抖 | Anti-Shake | 同上 |
| `ev` | `m3_setting_ev` | 曝光补偿 | Exposure Compensation | 同上 |
| `wb` | `m3_setting_wb` | 白平衡 | White Balance | 同上 |
| `light_fre` | `m3_setting_light_fre` | 光频率 | Light Frequency | 同上 |
| `denoise` | `m3_setting_denoise` | 降风噪 | Wind Noise Reduction | 同上 |
| `audio_switch` | `m3_setting_audio_switch` | 录音 | Recording | 同上 |
| `external_mic` | `m3_setting_external_mic` | 外接麦克风 | External Mic | **UI 隐藏**（`hiddenSettingNames`） |
| `auto_poweroff` | `m3_setting_auto_poweroff` | 自动关机 | Auto Power Off | 「通用设置」分组 |
| `screen_standby` | `m3_setting_screen_standby` | 屏幕休眠 | Screen Standby | 「通用设置」分组 |
| `osd` | `m3_setting_osd` | 水印显示 | OSD Display | 「通用设置」分组 |
| `image_size` | `m3_setting_image_size` | 图像尺寸 | Image Size | 功能设置分组 |
| `image_quality` | `m3_setting_image_quality` | 图像质量 | Image Quality | 功能设置分组 |
| `continue_shot` | `m3_setting_continue_shot` | 连拍 | Continuous Shot | 功能设置分组 |
| `shot_timelapse_time` | `m3_setting_shot_timelapse_time` | 照片延时拍摄时长 | Photo Timelapse Duration | 功能设置分组 |
| `shot_timelapse_rate` | `m3_setting_shot_timelapse_rate` | 照片延时拍摄间隔 | Photo Timelapse Interval | 功能设置分组 |
| `delay_shot` | `m3_setting_delay_shot` | 延时拍摄 | Delayed Shot | 功能设置分组 |
| `shutter` | `m3_setting_exposure_time` | 曝光时间 | Exposure Time | 功能设置分组；**注意资源名与参数名不同名** |
| `rec_split_duration` | `m3_setting_rec_split_duration` | 视频分段时长 | Video Split Duration | 功能设置分组 |
| `timelapse_rate` | `m3_setting_timelapse_rate` | 视频延时拍摄间隔 | Video Timelapse Interval | 功能设置分组 |
| `timelapse_time` | `m3_setting_timelapse_time` | 视频延时拍摄时长 | Video Timelapse Duration | 功能设置分组 |
| `multiple` | `m3_setting_multiple` | 慢动作倍数 | Slow Motion Multiple | 功能设置分组 |

未在表内的参数名（如设备下发的 `logo`）→ `getStringResourceId` 返回 `null` → **标题直接用英文原文显示**（`M3SettingsAdapter.java:394-400`）。

取值域**静态不可枚举**，全部来自设备响应 `GET /app/getparamitems?param=all_<modeId>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:2406`：`getParamItemsByMode("all_" + i, …)`；`i` = `getCurrentMode` 返回的模式整数）。
响应 DTO `M3ParamItem`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamItem.java:19-34`）字段：

| 字段 | 含义 | 用法 |
|---|---|---|
| `name` | 参数名 | 查标题、写回 `param` |
| `items` | 选项**显示文本**列表 | 与 `index` 一一对应 |
| `index` | 选项**线上取值**列表（整数） | 写入 `value` |
| `curIndex` | 当前生效的线上取值（不是下标！） | UI 用 `index.indexOf(curIndex)` 反查下标（`M3SettingsAdapter.java:482-490`） |
| `itemsDisable` | 被禁用的选项文本列表 | 弹窗中该选项 alpha=0.5（`M3SettingsAdapter.java:653`、`:675`） |
| `enable` | `1`=可用；缺省按 `1` 处理 | 否则整行 alpha=0.5 + `setEnabled(false)`（`M3SettingsAdapter.java:391-392`、`:403-404`） |

写值：`GET /app/setparamvalue?param=<name>&value=<index[i]>`（`M3ApiService.java:112-113`；调用点 `M3DeviceSettingsViewModel.java:119-160`）。
成功判据：响应 `result == 0`。
特例：写成功后若 `paramName == "rec_resolution"`，立刻用同一 `currentModeId` 重新拉一次全表（`M3DeviceSettingsViewModel.java:166-169`）—— 因为分辨率是模式相关的。

**开关型判定**（`M3SettingsAdapter.isToggleSetting`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:412-418`）：`items.size() == 2` 且集合等于 `{"off","on"}` 或 `{"0","1"}` → 渲染 `Switch`；拨动时按 `items.indexOf(on?"on":"off")` 找下标，再取 `index[下标]` 写回（`M3SettingsAdapter.java:450-466`）。否则渲染「值 + 箭头 → 底部选择弹窗」（`:468-499`、`:514-592`），弹窗标题 = 该行标题（`dialog_setting_selection` 布局，标题文本 `tvDialogTitle`）。
无当前值可显示时显示字面量 `"N/A"`（`:489`）。

**值本身的中文本地化**（`M3SettingValueMapper`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/M3SettingValueMapper.java:25-31`）：
`valueToStringIdMap` 20 条（键大小写敏感，逐个列）：

| 设备原文 | 资源 | 中文 |
|---|---|---|
| `on` / `On` | `m3_value_on` | 开 |
| `off` / `Off` | `m3_value_off` | 关 |
| `auto` | `m3_value_auto` | 自动 |
| `standard` | `m3_value_standard` | 标准 |
| `daylight` | `m3_value_daylight` | 日光 |
| `cloudy` | `m3_value_cloudy` | 阴天 |
| `tungsten` | `m3_value_tungsten` | 钨丝灯 |
| `fluorescent` | `m3_value_fluorescent` | 荧光灯 |
| `High` | `m3_value_high` | 高 |
| `Medium` | `m3_value_medium` | 中 |
| `Low` | `m3_value_low` | 低 |
| `Date` | `m3_value_date` | 日期 |
| `Date&Time` | `m3_value_date_time` | 日期与时间 |
| `Unlimited` / `unlimited` / `Unimited`（设备侧拼写错误也兼容） | `m3_value_unlimited` | 不限 |
| `h-hold` | `m3_value_h_hold` | 地平线防抖 |

正则形态（`M3SettingValueMapper.java:26-31`，命中即模板化）：

| 正则 | 输出资源 | 中文模板 |
|---|---|---|
| `^(\d+)min$` (IGNORE_CASE) | `m3_value_minutes_format` | `%d分钟` |
| `^(\d+)(s\|sec)$` (IGNORE_CASE) | `m3_value_seconds_format` | `%d秒` |
| `^(\d+)P$` （区分大小写） | `m3_value_photos_format` | `%d张` |
| `^(\d+(?:\.\d+)?)k(\d+)$` (IGNORE_CASE) | `m3_value_k_fps_format` | 中文表未覆盖 → 显示 `%1$sK %2$dFPS` |
| `^(\d+)p(\d+)$` (IGNORE_CASE) | `m3_value_p_fps_format` | 中文表未覆盖 → 显示 `%1$sP %2$dFPS` |

`shutter` 专用（`M3SettingValueMapper.getSettingSpecificDisplayValue`，`:105-115`）：正则 `^((?:\d+(?:\.\d+)?)|(?:\d+/\d+))\s*(?:s|sec)?$`，命中后输出 `<捕获组>s`（`C3059bv.f1708aB` = `"s"`）—— 即 `1/100` 显示成 `1/100s`。

UI 分组与可见性（`M3SettingsMenuPolicy`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsMenuPolicy.java:21-22`、`:27-64`）：
- `hiddenSettingNames = {external_mic, logo}` —— 完全剔除。
- `generalSettingNames = {auto_poweroff, screen_standby, osd}` —— 归「通用设置」。
- 渲染顺序（`:48-63`）：`Header(function_settings)`「功能设置」→ 非 general 项 → `Header(general_settings)`「通用设置」→ `GeneralMenuItem(device_name_label, deviceNote)` → general 三项 → `GeneralMenuItem(storage_settings)`「存储设置」→ `GeneralMenuItem(firmware_upgrade, otaVersion)`「固件升级」→ `GeneralMenuItem(factory_reset)`「恢复出厂设置」。
- 注意：**M3 设置页列表里没有 WiFi 设置项**，但 `M3DeviceSettingsActivity.java:229` 仍保留了 `wifi_settings` 分支（点击进入 `M3WifiSettingsActivity`）—— 属于可达但菜单未挂的死分支。

### 1.5 M3：设备 / WiFi / 存储 / 恢复出厂 页

| 页 | 标题资源/中文 | 入口 | 项 | 接口 |
|---|---|---|---|---|
| `M3DeviceSettingsActivity` | `title_m3_device_settings`「设备设置」 | 设置页 `firmware_upgrade` 之外无直连；由 `activity_m3_device_settings` 布局承载，正文上方有 `loading_config`「加载配置中…」 | 见 1.4 | `getcurmode` → `getparamitems?param=all_<mode>` |
| `M3WifiSettingsActivity` | `wifi_settings`「WIFI设置」（`M3WifiSettingsActivity.java:122`） | 上述死分支 / `activity_m3_wifi_settings` 两行 | ①`wifi_name_label`「WIFI名称」，值取 `ConnectUtil.getCurrentSSID()`（`:130-135`）②`change_wifi_password`「修改WIFI密码」（`:202`） | ①`GET /app/setwifi?wifissid=<新名>`（`M3DeviceRepositoryImpl.java:2707+`，走 `setWifi$default(api, ssid, null, mask=2)`）②`GET /app/setwifi?wifipwd=<新密码>`（`:2776+`，`mask=1`） |
| `M3StorageSettingsActivity` | `storage_settings`「存储设置」（`M3StorageSettingsActivity.java:111`） | 设置页 `storage_settings` 项 | 单行 `format_memory_card`「格式化内存卡」（`:135`），确认文案 `dialog_confirm_format_memory_card`「确定要格式化存储卡？」 | `GET /app/sdformat` |
| `M3FactoryResetActivity` | `factory_reset`「恢复出厂设置」（`M3FactoryResetActivity.java:111`） | 设置页 `factory_reset` 项 | 确认文案 `confirm_factory_reset` | `GET /app/reset` |

M3 WiFi 输入校验：**只校验非空**，不做字符集/长度校验（`M3WifiSettingsActivity.java:186-199`（SSID）、`:211-224`（密码）：trim 后 `length == 0` 直接 `return false` 不关弹窗）。这与 Ride 系用 `wifi_name_invalid`/`wifi_password_invalid` 强校验不同。
成功文案：改 SSID → `modify_success`「修改成功」（`M3WifiSettingsActivity$showEditWifiSsidDialog$1$1.java:73`）；改密码 → `wifi_settings_take_effect_after_restart`「新的设置将在WIFI重启后生效」（`M3WifiSettingsActivity$showEditWifiPasswordDialog$1$1.java:71`）；失败 → `modify_failed_with_code`「修改失败：%s」。

### 1.6 Ride5（含 Ride5 Pro）：CGI 参数通道

Ride5 的读写只有两条通道（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi.java`）：

| 用途 | 模板 | 行 |
|---|---|---|
| 读相机参数 | `GET cgi-bin/hisnet/getcamparam.cgi?-workmode=<mode>&-type=<type>` | :34-35 |
| 读相机参数能力集 | `GET cgi-bin/hisnet/getcamparamcapability.cgi?-workmode=<mode>&-type=<type>` | :37-38 |
| 写相机参数 | `GET cgi-bin/hisnet/setcamparam.cgi?-workmode=<mode>&-type=<type>&-value=<v>` | :76-77 |
| 读通用参数 | `GET cgi-bin/hisnet/getcommparam.cgi?-type=<type>` | :40-41 |
| 读通用参数能力集 | `GET cgi-bin/hisnet/getcommparamcapability.cgi?-type=<type>` | :43-44 |
| 写通用参数 | `GET cgi-bin/hisnet/setcommparam.cgi?-type=<type>&-value=<v>` | :79-80 |

`-workmode` 在本页写死为一个常量：`NORMAL_RECORD_MODE = "NORM_REC"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:86`）。同名常量还出现在回调报文匹配串 `Ride5CallbackMessagePolicy.NORM_REC_ARG = "\"arg2\":\"NORM_REC\""`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackMessagePolicy.java:15`）。

**`-type` 词表（本附录能静态确定的全部）** —— 来自 `MoreSettingsCapabilityPolicy.fullRequestQueue`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsCapabilityPolicy.java:18`），共 8 条 `MoreSettingsRequestSpec(type, pType, isCommParam)`：

| `-type` | `pType` | 走 commparam？ | 对应 UI 行 | 中文文案 | 取值枚举（写值/读回成对） |
|---|---|---|---|---|---|
| `AUDIO` | 3 | 否（camparam） | 录音开关 | `audio_switch`「录音开关」 | 读回 `value == "1"` → 开；写 `"1"` / `"0"`（`MoreSettingsActivity.java:1151`、`:2120-2131`） |
| `FLIP` | 3 | 否 | 上下翻转（仅前摄） | `flip_up_down_front_only` | `value == "ON"` → 开；写 `"ON"` / `"OFF"`（`:1131`、`:2110-2118`） |
| `MIRROR` | 3 | 否 | 左右翻转（仅前摄） | `flip_left_right_front_only` | `value == "ON"` → 开；写 `"ON"` / `"OFF"`（`:1141`、`:2090-2100`） |
| `MEDIAMODE` | 3 | 否 | 分辨率设置 | `resolution_settings`「分辨率设置」 | 当前值原样显示（`:2182`）；能力集来自 `pType != 3` 时读回的 `capability` 字段，逗号分隔（`:2174-2181`），兜底数组 `{"1080P+1080P"}`（`:2203`）；弹窗标题 `select_recording_resolution`「请选择录制分辨率」+ 副标题 `recommended_resolution_tip`「推荐：1080P+1080P，更稳、更省电、更耐用」；选中项**原文**作为 `-value`（`:1457`） |
| `Rec_Split_Time` | 3 | 否 | 录像时长 | `recording_duration`「录像时长」 | 当前值：原文把 `MIN` 替换成 `minute_unit_suffix`「分钟」显示（`:2136-2144`）；能力集同样来自 `capability` 逗号分隔并做同一替换（`:2150-2164`）；兜底 `defaultRecordDurations()` = `{one_minute_unit「1分钟」, three_minutes_unit「3分钟」, five_minutes_unit「5分钟」}`（`:2200`、`:2207-2215`）；弹窗标题 `select_recording_duration`「请选择循环录制时间」；写值时把中文「分钟」反向替换回 `MIN`（`:1578-1588`、`:1644-1654`） |
| `GSR_SENSITIVITY` | 0 | 是（commparam） | 紧急录像 | `emergency_recording`「紧急录像」 | 写 `"OFF"`（关）/ `"MIDDLE"`（开=中灵敏度）（`:1061`、`:1075`）；读回 `value` ∈ {`HIGH`,`OFF`,其它} → `HIGH` 时开关为开（`:2297-2330`）；开启前弹 `tips`「小贴士」+ `emergency_recording_explanation`「开启后，骑行中如果设备因颠簸或摔车发生晃动，将自动录像 45 秒，并保存到紧急录像文件夹，而不是普通录像。」（`:1048`） |
| `GSR_PARKING` | 0 | 是 | 哨兵模式 | `sentinel_mode`「哨兵模式」 | 写 `"OFF"` / `"HIGH"`（`:1107`、`:1121`）；开启前弹 `tips` + `parking_mode_explanation`「开启后，设备关机但电池有电时，如遇外力碰撞或晃动，将自动录像 45 秒，并保存到紧急录像文件夹，不会存入普通录像。」（`:1094`） |
| `VCAPVQE` | 0 | 是 | 智能降风噪 | `wind_noise_reduction`「智能降风噪」 | 写 `"OFF"` / `"ON"`（`:1183`、`:1197`）；读回忽略大小写比较 `"ON"`（`:2285-2294`）；开启前弹 `wind_noise_notice_title`「开启降风噪提示」+ `wind_noise_notice_message`「开启后麦克风会主动滤除低频风噪，可能会轻微降低环境音量并增加处理延迟，请确保当前场景需要降风噪再开启。」（`:1170`） |

`pType` 的语义（由代码分支反推）：`0` = 仅用于 commparam 占位（`isCommParam=true` 时不使用）；`1` = 请求**能力集**（`cameraParameterCapability`，失败时走 `renderSettingFailure` 兜底，`MoreSettingsActivity.java:2194-2198`）；`2` = 走 `setcommparam`（`setSettings` 内 `pType == 2` 分支，`:1566-1571`）；`3` = 请求/写回**当前值**（`cameraParameter`，`:2033`）。

另有第 9 个 type 不走队列、单独读写：`WIFI_DEFAULT_STATE = "WIFI_DEAULT_STATE"`（**源码原文拼写错误，少了个 F**，`MoreSettingsActivity.java:87`）—— WiFi 模式三态：
- 读值：`GET cgi-bin/hisnet/getcommparam.cgi?-type=WIFI_DEAULT_STATE`（`:679`）
- 读能力：`getcommparamcapability.cgi?-type=WIFI_DEAULT_STATE`（`:809`）
- 写：`setcommparam.cgi?-type=WIFI_DEAULT_STATE&-value=<OFF|ON|ALWAYSON>`（`:910`）
- 三态文案（`wifiModeDescriptions`，`:247`）：`OFF` → `wifi_mode_off_desc`「禁用自动开启（开机需手动打开）」；`ON` → `wifi_mode_on_desc`「自动开启（3 分钟未连接自动关）」；`ALWAYSON` → `wifi_mode_always_on_desc`「始终开启（开机后保持打开）」；未知值 → `wifi_mode_unknown`「未知模式」（`:951`）。弹窗 `wifi_mode_dialog_title`「设置 WiFi 模式」+ 副标题 `wifi_mode_alert_subtitle`「注意：禁用自动开启后需要开机后按 M 键手动开启 WiFi」（`:757`）；加载中 `wifi_mode_loading`「加载中...」；失败 `wifi_mode_load_failed`「加载失败」。

**按机型的可见性裁剪**（`MoreSettingsCapabilityPolicy.resolve`，`MoreSettingsCapabilityPolicy.java:26-42`）：

| DeviceType | hiddenItems（隐藏的行） | requestQueue | 两个附加开关 |
|---|---|---|---|
| `RIDE3PRO` / `RIDE6` | 全部 7 项：`EMERGENCY_RECORDING, PARKING_MONITOR, WIND_NOISE_REDUCTION, FLIP_VERTICAL, FLIP_HORIZONTAL, WIFI_MODE, FIRMWARE_UPDATE` | 从 8 条中剔除 `ride3ProUnsupportedRequestTypes = {FLIP, MIRROR, GSR_SENSITIVITY, GSR_PARKING, VCAPVQE}` → 只剩 `{AUDIO, MEDIAMODE, Rec_Split_Time}` | `(false, false)` |
| `M3` | `m3HiddenItems = emptySet()`（不隐藏任何行） | 全部 8 条 | `(true, true)` |
| 其它（RIDE5 / RIDE5 Pro） | `emptySet()` | 全部 8 条 | `(true, true)` |

`MoreSettingsUiItem` 枚举 7 个常量（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsUiItem.java:12-18`）：`EMERGENCY_RECORDING`、`PARKING_MONITOR`、`WIND_NOISE_REDUCTION`、`FLIP_VERTICAL`、`FLIP_HORIZONTAL`、`WIFI_MODE`、`FIRMWARE_UPDATE`。

### 1.7 App 本地设置（不改相机）

| 项 | 页/入口 | 资源 | 中文 | 落点 |
|---|---|---|---|---|
| 语言 | `fragment_helper`（帮助页） | `language` | 语言 | 走 `locales_config`；无相机写操作 |
| 关于我们 | 帮助页 | `about_us` | 关于我们 | `AboutActivity` |
| 反馈问题 | 帮助页 | `feedback_problem` | 反馈问题 | `FeedbackActivity`，Spinner 文案 `device_model`「设备型号」/`please_select_device`「请选择设备」，输入提示 `feedback_hint`「请具体描述你的问题，并补充设备名称等必要信息」+ `feedback_contact_hint`「为快速解决问题，请留下联系方式」，按钮 `submit`「提交」 |
| 隐私政策 | 帮助页 | `privacy_policy` | 隐私政策 | `PrivacyActivity` |
| 修改 WiFi 名+密码（Ride 系） | `MoreSettingsActivity` 的 `WIFI设置` 行 | `modify_wifi_name_password`「修改WiFi名称和密码」，`Alert.Type.TWO_INPUT` 双输入 | 校验：`wifi_name_invalid`「WIFI名称只能包含字母和数字，字符_或-，且长度为8~32个字符」、「WIFI密码只能包含字母和数字，字符_或-，且长度为8~20个字符」（`MoreSettingsActivity.java:1288-1297`） | 先写本地镜像 `updateDeviceWifiInfo`，失败提示 `modify_failed`；成功再发相机请求 |

## 2. 拍摄模式常量表

### 2.1 M3（唯一有静态模式常量的机型）

常量定义：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/constants/M3Constants.java:24-33`（`M3Constants$ShootingMode`）。
中文名映射：`M3Constants.MODE_NAME_RES_BY_ID`（同文件 `:15`，`Map<Integer,Integer>`，10 条全覆盖）。
UI 列表：`M3DeviceDetailActivity` 的两份写死数组 —— 侧边条 `modes`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailActivity.java:275`）与网格 `modeGridItems`（`:276`，每项额外带图标资源）。

| 数值 | 常量名 | 资源 id | 中文 | 英文默认 | 网格图标 | 在侧边条中的顺序 |
|---|---|---|---|---|---|---|
| 16 | `PHOTO_SINGLE` | `m3_mode_photo_normal` | 普通拍照 | Normal Photo | `ic_m3_mode_photo_normal` | 6 |
| 17 | `PHOTO_BURST` | `m3_mode_photo_burst` | 连续拍照 | Burst Photo | `ic_m3_mode_photo_burst` | 7 |
| 18 | `PHOTO_TIMELAPSE` | `m3_mode_photo_timelapse` | 缩时拍照 | Time-lapse Photo | `ic_m3_mode_photo_timelapse` | 8 |
| 19 | `PHOTO_TIMER` | `m3_mode_photo_timer` | 定时拍照 | Timer Photo | `ic_m3_mode_photo_timer` | 9 |
| 20 | `PHOTO_LONG_EXPOSURE` | `m3_mode_photo_long_exposure` | 长曝拍照 | Long Exposure Photo | `ic_m3_mode_photo_long_exposure` | 10 |
| 21 | `VIDEO_NORMAL` | `m3_mode_video_normal` | 普通录像 | Normal Video | `ic_m3_mode_video_normal` | 5 |
| 22 | `VIDEO_LOOP` | `m3_mode_video_loop` | 循环录像 | Loop Video | `ic_m3_mode_video_loop` | 4 |
| 23 | `VIDEO_TIMELAPSE` | `m3_mode_video_timelapse` | 缩时录像 | Time-lapse Video | `ic_m3_mode_video_timelapse` | 3 |
| 24 | `VIDEO_SLOW_MOTION` | `m3_mode_video_slow_motion` | 慢速录像 | Slow Motion Video | `ic_m3_mode_video_slow_motion` | 2 |
| 25 | `VIDEO_FAST_MOTION` | `m3_mode_video_fast_motion` | 倍速录像 | Fast Motion Video | `ic_m3_mode_video_fast_motion` | 1 |

UI 入口：预览页左侧的 `RecyclerView`（`dialog_m3_mode_selector` 标题 `shooting_mode`「拍摄模式」；条目布局 `item_m3_mode_option`）。点击 → `M3DeviceDetailViewModel.onModeSelected(modeId)`。
**未知 modeId 的兜底显示名** = `m3_mode_video_normal`（`M3DeviceDetailActivity.java:1762-1763`）。

切模式发送的请求（**唯一一条**）：`GET /app/mode?param=<modeId>`（`M3ApiService.java:109-110`；调用点 `M3DeviceDetailViewModel$startModeSwitch$1.java:57`）。
成功判据：`M3SetModeResponse.result == 0`；随后 `_appliedMode = modeId`，**1000 ms** 后（`DelayKt.delay(1000L)`，`M3DeviceDetailViewModel$startModeSwitch$1$1$1.java:57`）解除 `_isSwitchingMode` 并执行 `applyPendingModeIfNeeded()` / `verifyFinalModeAfterQueueDrained()`。
失败（`result != 0` 或异常）：`_currentMode` 回滚为 `_appliedMode`，触发 `_modeSwitchFailedEvent`，同样起一个 1000 ms 的收尾协程（`M3DeviceDetailViewModel$startModeSwitch$1$2$1.java:50`）。
模式切换 loading 超时：`MODE_SWITCH_LOADING_TIMEOUT_MS = 10000`（`M3DeviceDetailActivity.java:131`）。

与模式相关的前置拦截（`M3DeviceDetailViewModel.onModeSelected`，`M3DeviceDetailViewModel.java:2288-2310`）：
1. 正在录像 → 发 `_modeSwitchBlockedByRecordingEvent`，UI Toast `m3_wait_stop_recording`「请先停止录像」，**不发请求**。
2. 正在拍照 → 发 `_modeSwitchBlockedEvent`，Toast `m3_wait_photo_finish`「请等待拍照结束」。
3. 正在切换中 → 记为 `pendingModeId` 排队（不立即发）。
4. 目标 == 已生效 → 跳过（"Mode already applied, skipping API call"）。
5. 频率限制 → `mode_switch_too_frequent`「切换模式太频繁」（`M3DeviceDetailActivity.java:2625`）。

`/app/setting?param=<str>`（`setMenuMode`，`M3ApiService.java:106-107`）与 `/app/playback?param=<str>`（`setPlaybackMode`，`:115-116`）是另外两条**菜单/回放态切换**通道，与模式切换不同：回放入口 `M3DeviceDetailViewModel.onGalleryClicked()` / 预览页 `playback`「回看」按钮，具体 `param` 词表在 APK 内是变量（未静态确定，见 §6 纠正项）。

### 2.2 Ride3Pro / Ride6

Ride 系**没有** App 侧的模式常量表，只有一个二元开关：

| mode 值 | 语义 | 出现处 |
|---|---|---|
| `0` | 相机/拍摄态 | `Ride3ProSessionApiService.java:98`（`setMode(0, …)`，录像控制前的复位）、`C2216x9d51f82a.java:47`（`setMode(0, …)`） |
| `2` | 回放态 | `Ride3ProPlaybackRepositoryImpl.java:193`（`setPlaybackMode` → `setMode(2, …)`）、`Ride3ProIndexedPlaybackModeAction.java:69`、`Ride3ProStorageCapabilityProbe.java:160`（能力探测前先 `setMode(2)`） |

请求：`GET /api/setmode?mode=<int>`（`Ride3ProApiService.java:57-58`）。成功判据 `result == 0`。
具体的拍摄参数（分辨率、循环、曝光…）不在 mode 里，全走 §1.1/§1.2 的菜单通道。
状态回报：`GET /api/device/status` 的 `current_mode` / `mode_active` 字段（`Ride3ProDeviceStatusInfo.java:15-33`），以及回调事件串 `"\"eventid\":\"STATEMNG_SWITCH_WORKMODE\""`（`Ride5CallbackMessagePolicy.java:16`）。

### 2.3 Ride5

Ride5 无整数模式常量，模式以**字符串 workmode** 表达。APK 内静态出现的只有一个：`"NORM_REC"`（普通录像），用作 `getcamparam.cgi?-workmode=NORM_REC` 与回调匹配串 `"arg2":"NORM_REC"`（`MoreSettingsActivity.java:86`、`Ride5CallbackMessagePolicy.java:15`）。
模式命令走 `GET cgi-bin/hisnet/workmodecmd.cgi?-cmd=<str>`（`Ride5CgiApi.java:91-92`），`-cmd` 词表在 APK 内**全部是变量**（`Ride5CgiGateway.java:611/625` → `Ride5GatewayMediaPort.java:26`、`Ride5GatewaySessionPort.java:35`），静态无法枚举。
摄像头切换：`GET cgi-bin/hisnet/getcamchnl.cgi?-camid=<str>`（`Ride5CgiApi.java:88-89`）。

## 3. 页面与入口

## 4. 操作复现表

## 5. 状态与轮询

## 6. 对 `docs/03-品牌型号与协议矩阵.md` §1.5 的纠正
