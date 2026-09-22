# 01 · TUWIN 1.6.4 档案（主文档 / 导航与已确认事实）

> 包名 `com.tuwinsmart.tuwin`，版本 1.6.4 (250)，minSdk 24 / targetSdk **36**，仅 `arm64-v8a`，APK 22.7 MiB（sha256 `fa7958cf5fa0d811…`）。
> 反编译源码：`_work/tuwin_src/sources/`（6501 个 `.java`，其中厂商代码 `com/tuwinsmart/**` 1418 个文件、展开 3072 个类型）；
> 机器提取附录：`data/tuwin/`（重跑方式见 `tools/re/README.md`）。
> **清单与资源值走 aapt2 通道**（jadx 的资源阶段在 TUWIN 上会卡死，见 `docs/08/00 §2`），其余与另两家同构。

本档案的长表全部拆在下面三份附录里，本文只放：① 身份与清单事实、② 机型与协议族速查、③ 架构要点、④ 阅读顺序。

---

## 1. 附录与数据文件

| 要看什么 | 去哪 |
|---|---|
| 机型/SSID 正则/默认 IP 端口/协议 Profile 白名单/HTTP 面全表/鉴权/M3 TCP/菜单 XML/队列串行化 | 附录 · 协议面（本文附录） |
| 设置项全表（键+枚举值+中文文案）/拍摄模式常量/页面与入口/操作复现表/状态轮询 | 附录 · 设置与操作（本文附录） |
| WiFi 直连与路由绑定/下载续传/相机 OTA/播放器参数/事件推送/遥测域名/原生库 | 附录 · 传输OTA与联网（本文附录） |
| 每一条路径、常量、枚举、布局、字符串资源的原始表 | `data/tuwin/`（`catalog-http.md`、`catalog-consts.md`、`catalog-enums.md`、`layouts.md`、`res-strings-default.md`、`api/*.md` 等） |

## 2. 清单事实（`data/tuwin/manifest.md`）

组件 42 个：activity 33 / service 3 / receiver 1 / provider 5；权限 20 条；无 `uses-feature`、无 `queries`。

`<application>` 里对我们有直接影响的两条：`usesCleartextTraffic=true`（相机 HTTP 全明文，不需要例外配置）、
`allowBackup=false`、`requestLegacyExternalStorage=true`、`networkSecurityConfig=@0x7f140003`（实际内容见
传输OTA与联网附录（本文附录）清单小节）。

权限逐条用途（谁引用、是否死声明）在协议面/传输附录里逐条给；值得先记住的三条：

| 权限 | 用途 | 我们要不要 |
|---|---|---|
| `CHANGE_WIFI_STATE` + `ACCESS_WIFI_STATE` + `NEARBY_WIFI_DEVICES` | 扫描相机热点与 `WifiNetworkSpecifier` 直连 | 要（我们走 specifier 路径，见 `core/wifi`） |
| `REQUEST_INSTALL_PACKAGES` + `MOUNT_UNMOUNT_FILESYSTEMS` + `freemme.permission.msa` + `AD_ID` | App 自更新与厂商 SDK 归因残留 | **不要**（已决定不做 App 自更新，见 `docs/04`） |
| `POST_NOTIFICATIONS` + `FOREGROUND_SERVICE(_REMOTE_MESSAGING)` | 下载/传输前台服务 | 按我们是否有长时任务决定 |

## 3. 机型与协议族速查（细节以协议面附录为准）

`DeviceType` 四个值，识别靠 SSID 正则，**匹配顺序即优先级**，兜底式必须放最后
（证据：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/...`，逐条行号见协议面附录 §1.2）：

| 机型 | SSID 正则 | 默认 IP | 控制面 | 媒体 |
|---|---|---|---|---|
| RIDE3PRO | `^TUWIN_R3P_[A-Za-z0-9]+$` | `192.168.25.1` | HTTP REST `:80/api/` | RTSP `:8080/?action=stream` |
| RIDE6 | `^TUWIN_R6_[A-Za-z0-9]+$` | `192.168.25.1` | HTTP REST `:80/api/` | RTSP `:8080` |
| RIDE5（含 R5 Pro） | `^TUWIN_R5_[A-Za-z0-9]+$` / `^TUWIN_R5P_[A-Za-z0-9]+$` | `192.168.0.1` | 海思风格 CGI `/cgi-bin/hisnet/*.cgi` | RTSP `/livestream/1` |
| M3 | `^TUWIN[-_]M3_[A-Za-z0-9]+$` | `192.168.169.1` | HTTP `/app/*` + 原生 TCP | RTSP（动态授权端点） |
| 兜底 | `^TUWIN_[A-Za-z0-9]{6,}$` | — | 按探测结果选 | — |

三条反直觉的线上事实（都已在协议面附录落行号）：

1. **M3 的 TCP 没有帧分隔符**：线上按「一次 read 到一个完整 JSON」处理，`DelimitedFrameDecoder` 那套分隔符实现不是活跃路径（结论与证据见协议面 §4）。
2. **Ride3Pro 的 `setparameter?id=` 不是菜单 XML 里的 `<ID>`**，而是「分区名+项名」normalize 后查表推导；推导算法与被写死的那些 id 全部列在协议面 §5。
3. **M3 拍摄模式常量是硬编码的**（`M3Constants$ShootingMode`）：`PHOTO_SINGLE=16`、`PHOTO_BURST=17`、`PHOTO_TIMELAPSE=18`、`PHOTO_TIMER=19`、`PHOTO_LONG_EXPOSURE=20`、`VIDEO_NORMAL=21`、`VIDEO_LOOP=22`、`VIDEO_TIMELAPSE=23`、`VIDEO_SLOW_MOTION=24`、`VIDEO_FAST_MOTION=25`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/constants/M3Constants.java:24-33`）。

## 4. 架构要点（为什么它是「可扩展」的范本）

TUWIN 是三家唯一把「机型 → 协议」写成代码的品牌，分层值得照抄结构（不抄代码）：

- `DeviceAdapter` + `DeviceAdapterRegistry`：新机型 = 新 Adapter + 注册，重复注册抛异常。
- `DeviceProtocolProfile`：每个机型一份**安全白名单**（可接受型号、bootstrap 探测端点、允许的控制/媒体端口、允许路径前缀、动态媒体 host 策略），连接前与连接中逐次校验。
- `DeviceCapabilities`：能力是相机**动态上报的字符串集合**，UI 按能力开关，而不是按机型写死。
- `RouteProvider/RouteSnapshot/RouteLease/RouteId` + `RoutedOkHttpProvider/RoutedRetrofitProvider`：每条到相机的连接显式绑到那条 Network 路由，进程级绑定另有 `ProcessBindingController`；这是「连着相机 AP 同时还能用蜂窝上网」的正解，也是 `docs/07` 里 VPN 共存问题的根因侧写。
- `Ride3ProHttpRequestQueue` + `Ride3ProHttpSerialDispatcher`：相机不接受并发命令，全部串行化；format 类请求单独放宽超时。

## 5. 我们现在离它多远

对照基准是 [附录A · 我们已实现的命令面](05-我们已实现的命令面.md)（TUWIN 侧 23 条编号请求）。
本次全量比对得到的机械结论（`comm` 对比 `data/tuwin/catalog-http.md` 与 `composeApp/` 源码）：

- 官方 TUWIN 静态可见 59 条路径，我们用到 24 条；**我们用的都在官方目录里存在**（没有凭空发明的路径）。
- 两个需要修的点：① 我们的 `GET /api/playback/download?file=<名字>` 在官方目录里**不存在**，官方下载走 `/api/playback/rawdata`（配 `StreamingTransferEngine` + `Ride3ProPlaybackDownloadResumePolicy`）；② 官方回放/缩略图/删除用 `file_index=`（按索引），我们按文件名传 `file=`。真机验证前不要把这条当既成事实改掉，但它属于「照官方复现就必须改」的一类。
- 完全没有实现的机型族：M3（`/app/*` + TCP）、Ride5（`/cgi-bin/hisnet/`），以及 `GET /api/menu/xml` 整套动态菜单（我们现在只查 9 个写死 id）。

## 6. 未解与需抓包项

见协议面 §2.8「未确认的取值域」与 §8、设置与操作 §4/§6、传输OTA §8。汇总成一句话：M3 的 TCP 报文取值域、Ride3Pro 菜单 XML 的完整 id 空间、以及各家固件版本门限（续传/特性开关）需要 TUWIN 真机确认；我们手上只有 XTU S7PRO 的设备。

---

<!-- 以下整段合并自原 01-TUWIN-档案-附录-协议面.md（2026-09-22 文档归并，内容未改） -->
# 01 · TUWIN 档案 · 附录：协议面

> 本文是 `01-TUWIN-档案.md` 的协议面附录，覆盖机型识别、HTTP/CGI 全量端点、鉴权握手、M3 TCP 通道、Ride3Pro 菜单 XML 协议、请求队列与串行化、RTSP 端点。
> 证据来源：`_work/re/tuwin/api/*.md`（逐类明细）、`_work/re/tuwin/catalog-*.md`（机器提取表）、`_work/tuwin_src/sources/com/tuwinsmart/**`（反编译源码，实际扩展名为 `.java`）。
> 引用格式：`相对路径:行号`，行号以 `_work/tuwin_src/sources/` 下的反编译文件为准。

## 本附录覆盖范围 / 未覆盖

**覆盖（本文）**
1. 机型与识别：`DeviceType` 枚举、型号标识串、SSID 正则优先级链、默认 IP/端口、`DeviceProtocolProfile` 全字段白名单及其校验入口。
2. HTTP 面全表：Ride3Pro `/api/*`、M3 `/app/*`、Ride5 `cgi-bin/hisnet/*` 逐条端点语义。
3. 鉴权与握手：`/api/authdevice?seed=`、M3 鉴权、RTSP 授权端点。
4. M3 TCP 通道：连接参数、帧读写、消息类型/opcode、事件解析。
5. Ride3Pro 菜单 XML 协议：`/api/menu/xml` 结构、解析规则、`setparameter?id=` 推导算法。
6. 请求队列与串行化：`Ride3ProHttpRequestQueue` / `SerialDispatcher` / `RequestIdInterceptor` / `FormatTimeoutInterceptor`。
7. RTSP 端点：地址模板、端口、`RtspTransport` 选择逻辑（仅端点侧）。
8. 对既有文档（`docs/03` §1、`docs/01` §1）的纠正清单。

**未覆盖（交给其他附录）**
- UI 流程、页面/控件、设置项的展示与本地化（`-附录-UI` 系列）。
- OTA / 固件升级包解析与校验（`Ride3ProFirmwareMetaParser`、`UpgradeHelper`、`OtaPackageGroupPolicy` 的升级业务语义）。
- 播放器/解码参数、`libVLC`/ExoPlayer 侧配置（本文只写 RTSP URL 端点侧）。
- 相册下载、传输任务调度、文件校验（`VerifiedDeviceFileCatalog`、`StreamingTransferEngine` 的下载策略，本文只写其请求端点）。
- 云服务/反馈/隐私等外网域名（`FeedbackApiEndpoint`、`PrivacyPolicySource`、`HomeTipsWebsiteCachePolicy`），本文仅在 §2.9 归类说明。
- 蓝牙/BLE 面。

---

## 1. 机型与识别

### 1.1 DeviceType 枚举全量值

`DeviceType` 是 Kotlin 枚举，4 个值，构造参数为 `(code: String, categoryResId: Int, nameResId: Int, iconResId: Int)`。
证据：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/domain/model/DeviceType.java:14-18`（声明）、`:37`（`getCode()`）。

| 枚举值（ordinal） | `code`（型号标识串） | categoryResId → 实际文案 | nameResId → 实际文案 | iconResId |
|---|---|---|---|---|
| `RIDE5`（0） | `"RIDE5"` | `R.string.riding_recorder` = "Riding Recorder" | `R.string.ride5` = "Ride5" | `R.drawable.img_ride5` |
| `RIDE3PRO`（1） | `"RIDE3PRO"` | `R.string.riding_recorder` = "Riding Recorder" | `R.string.ride3pro` = "Ride3 Pro" | `R.drawable.img_ride3pro` |
| `M3`（2） | `M3OtaVersionPolicy.BOARD_VERSION`，字面值 `"M3"`（`tuwin/core/util/M3OtaVersionPolicy.java:19`） | `R.string.thumb_camera` = "Action Camera" | `R.string.device_m3` = "M3" | `R.drawable.img_m3` |
| `RIDE6`（3） | `"RIDE6"` | `R.string.riding_recorder` = "Riding Recorder" | `R.string.ride6` = "Ride6" | `R.drawable.img_ride6` |

注意：`code` 是「协议/机型码」，与设备上报的 model 字符串（`expectedModels`，见 §1.4）不是同一层。`code` 用于 `DeviceType` 自身标识与 OTA boardVersion 比对；`expectedModels` 用于校验设备 `getdeviceattr`/`getproductinfo`/`device/info` 回来的 model 字段。

字符串资源值取自 `_work/re/tuwin/res-strings-default.md`（`device_m3`=176 行、`ride3pro`=686 行、`ride5`=797 行、`ride6`=828 行、`riding_recorder`=898 行、`thumb_camera`=977 行）。

### 1.2 SSID 正则（匹配顺序即优先级）

6 条正则全部定义在 `tuwin/core/util/ConnectUtil.java:33-38`，判定函数 `inferDeviceTypeFromSsid(String)` 在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:128-147`。
先对入参做 `normalizeSsid()`（trim + 去成对双引号 + 空串归 null，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:212-219`），**归一化后**才送进正则；归一化返回 null 直接判为无法识别（`:130-132`）。

匹配顺序（源码自上而下，第一个命中即返回，后面的正则不再执行）：

| 优先级 | 常量名 | 正则（原样） | 命中后返回 | 源码位置 |
|---|---|---|---|---|
| 1 | `M3_SSID_REGEX` | `^TUWIN[-_]M3_[A-Za-z0-9]+$` | `DeviceType.M3` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:33`、判定 `:134` |
| 2 | `RIDE3PRO_SSID_REGEX` | `^TUWIN_R3P_[A-Za-z0-9]+$` | `DeviceType.RIDE3PRO` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:37`、判定 `:137` |
| 3 | `RIDE6_SSID_REGEX` | `^TUWIN_R6_[A-Za-z0-9]+$` | `DeviceType.RIDE6` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:38`、判定 `:140` |
| 4 | `RIDE5_PRO_SSID_REGEX` | `^TUWIN_R5P_[A-Za-z0-9]+$` | `DeviceType.RIDE5` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:35`、判定 `:143` |
| 5 | `RIDE5_SSID_REGEX` | `^TUWIN_R5_[A-Za-z0-9]+$` | `DeviceType.RIDE5` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:34`、判定 `:143` |
| 6 | `RIDE5_COMMON_SSID_REGEX` | `^TUWIN_[A-Za-z0-9]{6,}$` | `DeviceType.RIDE5` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:36`、判定 `:143` |

顺序即优先级的两个关键点：

1. **M3 的正则排在第一位且是唯一允许 `-` 或 `_` 分隔符的**（`TUWIN-M3_xxx` 与 `TUWIN_M3_xxx` 都收）。因为它在最前面，所以形如 `TUWIN_M3_ABC123` 的名字永远不可能落到第 6 条的兜底正则上。
2. **第 6 条 `^TUWIN_[A-Za-z0-9]{6,}$` 是 RIDE5 的兜底「万能桶」**：任何 `TUWIN_` 开头、后缀为 ≥6 位字母数字的名字都会被判成 RIDE5。这意味着一台命名异常的 RIDE3Pro（例如 `TUWIN_ABCDEF12`）会被误识别为 RIDE5。因此优先级 2/3/4/5 必须先跑完。第 4 条 `TUWIN_R5P_` 必须在第 5 条 `TUWIN_R5_` 之前——注意 `^TUWIN_R5_[A-Za-z0-9]+$` 无法匹配 `TUWIN_R5P_XXX`（`_` 与 `P` 位置不同），所以这里的顺序实际不产生错误，但 RIDE5 三个正则是**短路 or**（`RIDE5_PRO || RIDE5 || RIDE5_COMMON`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:143`），三者命中同一个返回值 `DeviceType.RIDE5`。
3. 四条都不命中 → 返回 `null`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:146`），调用方走「非 TUWIN 网络」分支。

派生判定：
- `isExpectedDeviceWifiSsid(current, expectedType, expectedSsid)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:156-167`）：先要求 `inferDeviceTypeFromSsid(current) == expectedType`，不等直接 false；再要求若给了 `expectedSsid` 则必须逐字符相等（区分大小写，`Intrinsics.areEqual`）。
- `isExpectedDeviceWifi(...)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:169-176`）：**若 `expectedBssid` 非空，则只比 BSSID，完全跳过 SSID 正则链**；BSSID 归一化把 `-` 换成 `:`、转小写、并把 Android 伪装 MAC `02:00:00:00:00:00` 归 null（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:221-233`）。
- `resolveDeviceType(cachedSsid, allowRuntimeSsidRead)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:185-194`）：先用缓存 SSID，未命中且允许运行时读取时才去查系统当前 SSID。
- `isConnectedTUWIN()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:113-126`）**不用正则**：先要求隐私协议已同意（`PreferenceHelper.isAgreePrivacy()`），再只看 `currentSSID.startsWith("TUWIN")` 或当前 SSID 在缓存列表 `getCacheSSID()` 里。这是一条与正则链不一致的宽松判据。

### 1.3 默认 IP / 端口常量

控制面默认主机地址由 `DeviceHostPolicy.hostFor(DeviceType)` 单点决定（`tuwin/core/device/DeviceHostPolicy.java:46-59`）：

| DeviceType | 默认 host | 分支条件（when 映射） |
|---|---|---|
| `M3` | `192.168.169.1` | `i == 1` |
| `RIDE3PRO` | `192.168.25.1` | `i == 2` |
| `RIDE6` | `192.168.25.1`（与 RIDE3PRO 共用同一分支） | `i == 3` |
| `RIDE5` | `192.168.0.1` | `i == 4` |
| 其它 | 抛 `kotlin.NoWhenBranchMatchedException` | `:58` |

端口常量（取自 `_work/re/tuwin/catalog-ports.md`，逐条回源码核对）：

| 常量 | 值 | 含义 | 源码位置 |
|---|---|---|---|
| `M3ConnectionStrategy.M3_CONTROL_PORT` | `80` | M3 HTTP 控制端口 | `tuwin/core/device/p005m3/M3ConnectionStrategy.java` |
| `Ride3ProDeviceAdapterSession.RTSP_PREVIEW_PORT` | `8080` | Ride3Pro/Ride6 RTSP 预览端口，同时是 profile 的 `allowedMediaPorts` 元素 | `tuwin/core/device/ride3pro/Ride3ProDeviceAdapterSession.java:62`（声明），使用于 `:382`、`:506`、`:656` |
| `M3DynamicEndpointPolicy.RTSP_DEFAULT_PORT` | `554` | M3 RTSP 默认端口 | `tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java` |
| `Ride5DeviceAdapterSession.RTSP_LIVE_PORT` | `554` | Ride5 RTSP 直播端口 | `tuwin/core/device/ride5/Ride5DeviceAdapterSession.java` |
| `Ride5DeviceAdapterSession.CALLBACK_PORT` | `9002` | Ride5 设备回调端口 | 同上 |
| `RoutedDeviceLogGateway.DEVICE_HTTP_PORT` | `80` | 诊断日志上传走的设备 HTTP 端口 | `tuwin/data/source/remote/gateway/RoutedDeviceLogGateway.java` |
| `ExternalResourceAllowlist.MEDIA_PORT` | `1369` | 外链/H5 媒体端口（非设备控制面） | `tuwin/core/internet/ExternalResourceAllowlist.java` |
| `ExternalResourceAllowlist.ANDROID_DOWNLOAD_PORT` | `1371` | Android 下载服务端口 | 同上 |
| `ExternalResourceAllowlist.ASSET_CDN_PORT` | `443` | 资产 CDN 端口 | 同上 |

`DeviceEndpointEvidence` 构造时强制端口合法：`port < 1 || port >= 65536` 抛 `IllegalArgumentException("Device endpoint evidence port is invalid")`；host 空白抛 `"Device endpoint evidence host is required"`；path 不以 `/` 开头抛 `"Device endpoint evidence path must be absolute"`（`tuwin/core/network/DeviceEndpointEvidence.java:89-97`）。

### 1.4 DeviceProtocolProfile 字段全取值

`DeviceProtocolProfile` 有 7 个字段（`tuwin/core/network/DeviceProtocolProfile.java:19-26`），全部非空；`dynamicMediaHostPolicy` 有默认值 `DynamicEndpointHostPolicy.SAME_AS_CONTROL_HOST`（`:179-181` 的合成构造器，`i & 64` 时取默认）。
唯一的生产者是 `DefaultDeviceProtocolProfileRegistry` 构造器（`tuwin/core/network/DefaultDeviceProtocolProfileRegistry.java:24-35`），是一张 `Map<DeviceType, DeviceProtocolProfile>`，4 个机型各一条。

| 字段 | M3 | RIDE3PRO | RIDE6 | RIDE5 |
|---|---|---|---|---|
| `expectedModels` (Set\<String\>) | `{"M3", "v57_sport_cam_ezgui"}` | `{"R3Pro"}` | `{"R6"}` | `emptySet()` |
| `bootstrapEndpoints` (List\<DeviceProbeEndpoint\>) | 1 条：`HTTP` / `80` / `/app/getproductinfo` / `PROBE` | 1 条：`HTTP` / `80` / `/api/device/status` / `PROBE` | 1 条：`HTTP` / `80` / `/api/device/status` / `PROBE` | 1 条：`HTTP` / `80` / `/cgi-bin/hisnet/getdeviceattr.cgi` / `PROBE` |
| `allowedControlPorts` (Set\<Int\>) | `{80}` | `{80}` | `{80}` | `{80}` |
| `allowedMediaPorts` (Set\<Int\>) | `emptySet()` | `{8080}` | `{8080}` | `emptySet()` |
| `allowedPathPrefixes` (Set\<String\>) | `{"/app/"}` | `{"/api/"}` | `{"/api/"}` | `{"/cgi-bin/hisnet/"}` |
| `dynamicMediaHostPolicy` | `SAME_AS_CONTROL_HOST`（默认） | `SAME_AS_CONTROL_HOST`（默认） | `SAME_AS_CONTROL_HOST`（默认） | `SAME_AS_CONTROL_HOST`（默认） |

支撑枚举（各只有一份取值，全部无参）：
- `DeviceEndpointProtocol`：`HTTP`、`RTSP`、`TCP`（`tuwin/core/network/DeviceEndpointProtocol.java:11-15`）
- `EndpointPurpose`：`PROBE`、`CONTROL`、`FILE`、`IMAGE`、`MEDIA`、`CALLBACK`、`MENU`、`OTA`、`DIAGNOSTIC`（`tuwin/core/network/EndpointPurpose.java:11-21`，共 9 个）
- `EndpointGrantSource`：`PROFILE_BOOTSTRAP`、`DEVICE_PROBE_RESPONSE`、`DEVICE_MEDIA_RESPONSE`、`DEVICE_FILE_LIST`、`USER_SELECTED_ENDPOINT`（`tuwin/core/network/EndpointGrantSource.java:11-17`）
- `DynamicEndpointHostPolicy`：只有 `SAME_AS_CONTROL_HOST` 一个值（`tuwin/core/network/DynamicEndpointHostPolicy.java:11-13`）——意味着该字段目前是「形参化的单选项」，没有第二条策略可言；`acceptsDynamicMediaHost` 的 `when` 若取到其它值直接抛 `NoWhenBranchMatchedException`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceProtocolProfile.java:212-215`）。

`DeviceProbeEndpoint` 的 4 参构造器 `(protocol, port, path, purpose)`，`purpose` 默认 `EndpointPurpose.PROBE`（合成构造器 `i2 & 8` 分支，`tuwin/core/network/DeviceProbeEndpoint.java:102-104`）。注册表里 4 条端点全部用 `null, 8, null` 走这个默认，所以 purpose 全是 `PROBE`。

`profileFor(deviceType)` 未命中时抛 `IllegalStateException("No device protocol profile for " + deviceType)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DefaultDeviceProtocolProfileRegistry.java:38-45`）——注意 map 里已覆盖全部 4 个枚举值，所以这条异常路径实际不可达。

三个白名单方法的**精确语义**（`DeviceProtocolProfile.java`）：

| 方法 | 语义 | 源码 |
|---|---|---|
| `acceptsModel(String model)` | `model` 为 null / trim 后空 / trim 后长度为 0 → `false`。`expectedModels` 为空集 → **`true`（放行任意型号）**，这正是 RIDE5 的行为。否则遍历 `expectedModels`，与 trim 后的 model 做 **忽略大小写** 相等比较，任一相等 → `true`；全部不等 → `false` | `:183-207` |
| `acceptsProbeEndpoint(DeviceEndpointEvidence?)` | `endpoint` 为 null → `false`。否则遍历 `bootstrapEndpoints`，要求 **protocol 相同（枚举 ==）且 port 相同（整数 ==）且 normalizePath(path) 相同（区分大小写）**。三者任一不同即继续下一个，全不匹配 → `false` | `:218-230` |
| `acceptsDynamicMediaHost(controlHost, candidateHost)` | 两个参数都 `checkNotNullParameter`。仅当 `dynamicMediaHostPolicy == SAME_AS_CONTROL_HOST` 时返回 `controlHost.equals(candidateHost)` **忽略大小写**；其它枚举值（当前不存在）抛 `NoWhenBranchMatchedException` | `:209-216` |

`normalizePath(path)`：`path.length() > 1` 时去掉结尾的 `/`，否则整体返回 `"/"`（`:232-234`）。所以 `/app/getproductinfo` 与 `/app/getproductinfo/` 视为同一个端点，但 `/` 与 `""` 都归一到 `/`。

### 1.5 白名单方法的调用点、拒绝分支与用户可见结果

#### `acceptsModel(model)` —— 2 个调用点

| 调用点 | 上下文 | 拒绝时走的分支 | 用户可见 |
|---|---|---|---|
| `tuwin/core/network/DeviceIdentityVerifier.java:149` | `verify(ProbePermit, Network, DeviceProbeExecutor)` 拿到 `DeviceProbeResult` 后，先比 `deviceType` 再比 model：`if (result.getDeviceType() != permit.getExpectedDeviceType() \|\| !profile.acceptsModel(result.getModel()))` | `:150` 先 `DeviceRouteRegistry.reject$default(routes, sessionId, …)` 把路由标记为 rejected（撤销 probing 状态），再 `:151` 抛 `DeviceIdentityMismatchException("Unexpected device identity: expected=<type>, actual=<type>, model=<model>")` | 走连接流程失败：异常消息里带真实上报的 model 串（连了一台不同型号的设备时，模型名会直接出现在诊断/日志里） |
| `tuwin/core/device/p005m3/M3DeviceAdapter.java:231` | `M3AdapterSession.open()` 中，已经拿到 verified route + CONTROL `EndpointGrant` + 会话 `DeviceIdentity` 之后再做一次「二次校验」：`if (identity.getDeviceType() != DeviceType.M3 \|\| !profile.acceptsModel(identity.getModel()))` | `:232` 抛 `IllegalArgumentException("M3 model mismatch: " + identity.getModel())`，该异常在 `open()` 的 try 内，导致 adapter session 打不开 | M3 详情页/预览打不开（adapter open 失败），诊断日志出现 `M3 model mismatch: <model>` |

关键结论：**RIDE5 的 `expectedModels` 是空集，因此 `acceptsModel` 对 Ride5 恒为 true（除非 model 为 null/空白）**——Ride5 的型号校验完全依赖 `Ride5IdentityPolicy`（BSSID 派生 deviceId），不依赖 model 串。
证据：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DefaultDeviceProtocolProfileRegistry.java:34` 的 RIDE5 条目传 `SetsKt.emptySet()`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceProtocolProfile.java:206` 空集分支 `return true`；`tuwin/core/device/ride5/Ride5IdentityPolicy.java:47` 用正则 `[0-9A-F]{12}` 校验并排除 `020000000000` / `000000000000` / `FFFFFFFFFFFF` 三个广播/伪装地址。

#### `acceptsProbeEndpoint(endpoint)` —— 2 个调用点

| 调用点 | 上下文 | 拒绝时走的分支 | 用户可见 |
|---|---|---|---|
| `tuwin/core/network/DeviceProbePlan.java:67`（`accepts()` 薄封装，被 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceIdentityVerifier.java:153` 调） | 身份比对通过后，再要求探测结果里的 endpoint 本身是 profile 声明过的 bootstrap 端点 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceIdentityVerifier.java:154` `routes.reject$default(...)` → `:155` 抛 `DeviceProbeRejectedException("Probe endpoint is not declared by the <type> profile")` | 连接失败并提示探测被拒；日志/诊断里是该英文串 |
| `tuwin/core/network/DeviceEndpointAuthority.java:106`（`issueVerifiedControlGrant`） | 把探测证据换成 CONTROL 授权前，要求该 endpoint 是「已声明的 probe 端点」 | `:103` 若 `endpoint.protocol != HTTP` 先抛 `IllegalArgumentException("Device control endpoint must use HTTP")`；`:106-108` 不接受则抛 `IllegalArgumentException("Control endpoint is not backed by a declared probe endpoint")`；`:110-112` 若 host 与所选 probe host 归一化后不等则抛 `EndpointNotAuthorizedException("Verified endpoint does not match the selected probe host")`；只有全通过才 `:113` `issue(...)` 出 `EndpointPurpose.CONTROL` + `EndpointGrantSource.DEVICE_PROBE_RESPONSE` 的 grant，端口集取 `profile.allowedControlPorts`、路径前缀集取 `profile.allowedPathPrefixes` | 后续所有设备 HTTP 请求都要经 `authorizeUrl`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceEndpointAuthority.java:116+`）拿 grant 校验，拿不到 grant 就抛 `EndpointNotAuthorizedException`，表现为「设备无响应/连接失败」 |

另外 `DeviceProbePlan` 自身的构造器就会拒绝「没有 bootstrapEndpoints 的 profile」：`tuwin/core/network/DeviceProbePlan.java:52-54` 若 `bootstrapEndpoints.isEmpty()` 抛 `IllegalArgumentException("Device profile must declare at least one probe endpoint")`。因为 4 个 profile 各声明 1 条，这条不可达。

#### `acceptsDynamicMediaHost(controlHost, candidateHost)` —— **零调用点，死代码**

结论：该方法在整份反编译源码里**没有任何调用方**。
证据（穷举检索）：`grep -rn "acceptsDynamicMediaHost" _work/tuwin_src/sources/com/tuwinsmart` 只命中两处，均为声明本身——`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceProtocolProfile.java:18`（Kotlin `@Metadata` 里的方法名编码）与 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceProtocolProfile.java:209`（方法定义）。无任何 `.acceptsDynamicMediaHost(` 形式的调用。
含义：`dynamicMediaHostPolicy` 字段与 `DynamicEndpointHostPolicy` 枚举目前是**预留但未接线**的抽象；实际「媒体 host 必须等于控制 host」的约束由别处实现——Ride3Pro 走 `EndpointGrant` 的 host 派生（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProDeviceAdapterSession.java:382/506/656` 用 `endpointGrant3.getHost()` 作为 RTSP host），M3 走 `M3DynamicEndpointPolicy.parse()` 里直接 `new M3DynamicEndpoint(controlHost, port, path)`（`tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java` 的 parse 末尾，两个端点的 host 都写死为入参 `controlHost`，即设备响应里的 RTSP host 被**丢弃**）。复现时不需要实现这条策略，但需要实现「忽略设备自报的媒体 host」这一行为。

#### 探测端点白名单的实际生效路径（谁产生 `DeviceEndpointEvidence`）

| 机型 | 探测实现 | 产生的 evidence | 源码 |
|---|---|---|---|
| M3 | `M3SessionConnector$connectUserInitiated$verified$1.probe()` 先发 `PROBE` grant（host=`hostFor(M3)`、端口集 `{80}`、路径前缀集 = bootstrapEndpoints 的 path 集合），再 `executeProbe()` | `new DeviceEndpointEvidence(HTTP, host, 80, "/app/getproductinfo")`，model 取 `M3DeviceInfo.getModel()`，serial/firmware/boardVersion/features 全为 null | `tuwin/core/device/p005m3/M3SessionConnector$connectUserInitiated$verified$1.java:88`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java:1941`（`new DeviceProbeResult(DeviceType.M3, model, null,null,null, evidence, null,null, 208, null)`） |
| Ride3Pro / Ride6 | `Ride3ProSessionConnector$connectUserInitiated$verified$1.probe()` → `executeProbe()` 连打两次：`/api/device/status` 然后 `/api/device/info` | `new DeviceEndpointEvidence(HTTP, host, 80, "/api/device/status")`，带 `uuid`/`swver`/`hwver`/`ssid`/`normalizedFeatures` | `tuwin/core/device/ride3pro/Ride3ProSessionConnector$connectUserInitiated$verified$1.java:73`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionConnector.java:1913` |
| Ride5 | `Ride5SessionConnector$connectUserInitiated$verified$1` | 对应 `/cgi-bin/hisnet/getdeviceattr.cgi` | `tuwin/core/device/ride5/Ride5SessionConnector$connectUserInitiated$verified$1.java:88`、`:153` |

两处值得注意的差异：
1. Ride3Pro 的 PROBE grant 路径前缀**不是**从 bootstrapEndpoints 推出来的，而是硬编码 `SetsKt.setOf("/api/device/")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionConnector$connectUserInitiated$verified$1.java:73`）；M3 才是 `CollectionsKt.toSet(bootstrapEndpoints.map{it.path})`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector$connectUserInitiated$verified$1.java:81-88`）。这意味着 Ride3Pro 探测阶段允许 `/api/device/` 下的任意子路径（正是 status + info 两条），而 M3 探测阶段只允许 `/app/getproductinfo` 一条。
2. Ride3Pro 探测要求 `hwver` 仅在 `targetDeviceType == DeviceType.RIDE6` 时才写入 `boardVersion`，RIDE3PRO 时传 null（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionConnector.java:1908-1913`）——即 RIDE6 用 hwver 作板本标识，Ride3Pro 不用。
3. Ride3Pro 探测额外要求 `/api/device/info` 的 `info` 非空：`if (ride3ProDeviceInfo == null) throw IllegalStateException("RIDE3PRO device info is missing")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionConnector.java:1902-1904`）。M3 对应的是 `"M3 probe response has no product info"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java:1939`，JADX 把 `== null` 显示成了 `!= null`，语义按错误消息取反理解）。
4. 成功判据统一走 `requireSuccessful(response, endpoint)`：`result != 0` 即抛 `IllegalStateException("RIDE3PRO probe failed: <endpoint>, result=<result>")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionConnector.java:2024-2029`）。HTTP base 由 `httpBaseUrl(host, port)` 拼：IPv6 host 会补方括号，格式 `http://<host>:<port>/`（`:2031-2036`）。

---

## 2. HTTP 面全表

### 2.1 Ride3Pro / Ride6：`/api/*`

Ride3Pro 与 Ride6 **共用同一套 `/api/*` 端点**（`DefaultDeviceProtocolProfileRegistry` 给两者配了几乎相同的 profile，差异只在 `expectedModels` = `{"R3Pro"}` vs `{"R6"}` 和探测时是否把 `hwver` 当 boardVersion）。
唯一声明类型：`tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java`（Retrofit 接口，24 个方法，`:21-101`）。
统一响应包：`Ride3ProApiResponse<T> = {"result": Int, "info": T}`，`isSuccess() == (result == 0)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse.java:13-19, 82-84`）；`getErrorMessage()` 在 `info` 是 String 时给 `"result=<n>, info=<str>"`，否则 `"result=<n>"`（`:86-95`）。
所有请求默认走 `http://<host>:80/`（`Ride3ProSessionConnector.httpBaseUrl`，`:2031-2036`）。
下面「成功判据」列里 `result==0` 指 `Ride3ProApiResponse.isSuccess()`。

| # | 方法 | 路径（原样） | Query 参数 | 参数取值 | 期望响应字段 | 成功/失败判据 | 声明 / 主要调用点 |
|---|---|---|---|---|---|---|---|
| 1 | GET | `/api/authdevice` | `seed` | `Long`，来自 `kotlin.random.Random.nextLong(Long.MAX_VALUE)`（即 `0..9223372036854775806`），**端侧随机数，不参与签名** | 只用 `result`，`info` 被声明为 `Any?` 且不解析 | `result==0` 成功；否则 `Ride3ProConnectionException.httpFailed("/api/authdevice", errorMessage)` | 声明 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:22-23`；预览调用 `tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:238-247`；回放调用 `tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1094` |
| 2 | GET | `/api/capture` | 无 | — | `result` | `result==0` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:25-26`（拍照，被 `Ride3ProRecordRepositoryImpl` 使用） |
| 3 | GET | `/api/device/info` | 无 | — | `info`: `model` / `uuid` / `soc` / `ssid` / `pwd` / `mac` / `swver` / `hwver` / `features`(String 数组) | `result==0` 且 `info != null`，否则 `IllegalStateException("RIDE3PRO device info is missing")` | 声明 `:31-32`；模型类 `Ride3ProDeviceInfo.java`（`@SerializedName` 全量）；探测调用 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionConnector.java:1886-1904` |
| 4 | GET | `/api/device/status` | 无 | — | `info`: `adapter_status` / `battery_percent`（**别名 `battery_level`**，`@SerializedName(alternate={"battery_level"}, value="battery_percent")`） / `current_mode` / `exception_flags` / `hdr_chk_cnt` / `mode_active` / `recording_time`；全部是 `Integer?`（缺字段= null，不报错） | `result==0` | 声明 `:34-35`；模型 `Ride3ProDeviceStatusInfo.java`；轮询 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java:443`；探测 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionConnector.java:1886`；连接检测 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$detectConnection$2.java:133`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$detectConnectionLightweight$2.java:69`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$getDeviceStatus$2.java:72` |
| 5 | GET | `/api/menu/xml` | 无 | — | **不是 JSON**，`@Streaming` + 返回 `ResponseBody`（XML 文本，见 §5） | 无 `result` 概念，按 XML 解析结果判定 | `:37-39` |
| 6 | GET | `/api/menu/getparameter` | `id` | 菜单项 id 字符串（见 §5.3 推导） | `result` + `info` | `result==0` | `:41-42` |
| 7 | GET | `/api/menu/setparameter` | `id`, `value` | `id` 见 §5.3；`value` **可空**（`DefaultImpls.setParameter$default` 在 `i & 2` 时传 `null`，即可以只带 `id=` 不带 `value=`） | `result` | `result==0` | `:96-97`、`:106-114`；恢复出厂 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$factoryReset$2.java:71`；改 WiFi 密码 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$setWifiPassword$2.java:75` |
| 8 | GET | `/api/reboot` | 无 | — | `result` | `result==0` | `:81-82`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$reboot$2.java:70` |
| 9 | GET | `/api/record/start` | 无 | — | `result` | `result==0` | `:84-85`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProRecordRepositoryImpl.java:237`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:1570` 也持有该字面量 |
| 10 | GET | `/api/record/stop` | 无 | — | `result` | `result==0` | `:87-88`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProRecordRepositoryImpl.java:433` |
| 11 | GET | `/api/setmode` | `mode` | **`0` = 预览/录像模式**（`Ride3ProStreamRepositoryImpl.MODE_PREVIEW = 0`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:38`）；**`2` = 回放模式**（3 处各自定义 `MODE_PLAYBACK = 2`：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:54`、`tuwin/presentation/p010ui/storage/ride3pro/Ride3ProIndexedPlaybackModeAction.java:25`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProStorageCapabilityProbe.java:32`）。`1` 在反编译源码中**没有任何常量定义或使用点**（见 §2.8） | `result` | `result==0`，否则 `Ride3ProConnectionException.httpFailed("/api/setmode", errorMessage)` | `:93-94`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:267`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:193`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:98`（`setMode(0)`）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/C2216x9d51f82a.java:47`（`setMode(0)`）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProIndexedPlaybackModeAction.java:69`（`setMode(2)`）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProStorageCapabilityProbe.java:160`（`setMode(2)`） |
| 12 | GET | `/api/sd/info` | 无 | — | `info`: `status` / `total` / `free`（均 `Integer?`） | `result==0` | `:60-61`；模型 `Ride3ProSdInfo.java`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$getSDInfo$2.java:73` |
| 13 | GET | `/api/system/formatsd` | 无 | — | `result` | `result==0`；**该路径单独享有 60 秒超时**（见 §6） | `:28-29`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl.java:353`；常量 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueueKt.java:14`；超时拦截器 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProFormatTimeoutInterceptor.java:17` |
| 14 | GET | `/api/vendor/send-time` | `year`, `month`, `day`, `hour`, `minute`, `second` | 6 个 `Int`，本地时钟拆分（无时区参数） | `result` | `result==0` | `:90-91`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:392` |
| 15 | GET | `/api/rtspstatus` | `seed` | `Long`，与 §3 的 authdevice seed 同一随机数体系（`Ride3ProSessionApiService` 透传 `$seed`） | `result`（`info` 不解析） | `result==0` | `:57-58`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:688, 703` |
| 16 | GET | `/api/playback/dayinfo` | `date` | `Int`，**YYYYMMDD 整数**（不是字符串）。合法域校验：`MIN_YYYYMMDD = 10000000`、`MAX_YYYYMMDD = 99999999`、`YEAR_DIVISOR = 10000`、`MONTH_DIVISOR = 100`、`MONTH_MODULUS = 100`、`DAY_MODULUS = 100`、`MAX_HOUR = 23`、`MIN_HOUR = 0`、`MAX_FILE_INDEX = 9999`、`MIN_FILE_INDEX = 0`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackIndexValidator.java:16-27`） | `info`: `date` / `file_count` / `hour_count` / `hour_list[]`，`hour_list[i]` = `hour` / `file_count` / `last_file_index` | `result==0`；字段缺失由 validator 抛（`requireField`） | `:44-45`；模型 `Ride3ProPlaybackDayDetail.java`、`Ride3ProPlaybackHourInfo.java`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProIndexedPlaybackRepositoryImpl.java:34`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProIndexedPlaybackRepositoryImpl$loadDayHours$2.java:69` |
| 17 | GET | `/api/playback/filecount` | 无 | — | `info`: `day_count` / `total_file_count` / `next_file_index` / `day_list[]`，`day_list[i]` = `date` / `file_count` / `last_file_index` | `result==0` | `:47-48`（注解写的是常量 `Ride3ProStorageCapabilityProbe.FILE_COUNT_ENDPOINT`）；常量值 `"/api/playback/filecount"`；模型 `Ride3ProPlaybackFileCountInfo.java`、`Ride3ProPlaybackDayInfo.java`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProIndexedPlaybackRepositoryImpl.java:36`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProStorageCapabilityProbe.java:29` |
| 18 | GET | `/api/playback/filelist` | `mode`, `file_index` | `mode` 同上（实际传 `2`=回放）；`file_index` = `Int` 起始索引，页大小 `PAGE_SIZE = 16`（`Ride3ProPlaybackRepositoryImpl.java` 的 `PAGE_SIZE`、`Ride3ProHourScanCursor.PAGE_SIZE = 16`、`StorageSdcardItemFragment.RIDE3PRO_PAGE_SIZE = 16`） | `info`: `file_count`(Int) / `file_list[]`；`file_list[i]` = `file_index` / `file_name` / `name` / `path` / `size`(Long) / `type`(String) / `time`(String) / `total_time`(Int) | `result==0`；`file_list[i].file_index` 必须存在且在 `0..9999`，否则 `IllegalArgumentException("file_list[i].file_index must be in 0..9999 for pagination: <v>")` | `:50-51`；模型 `Ride3ProPlaybackFileListInfo.java`、`Ride3ProPlaybackFileEntry.java`；分页逻辑 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProHourFilesLoader.java:335-383`；映射校验 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackFileMapper.java:48-50` |
| 19 | GET | `/api/playback/thumbnail` | `file_index` | `Int` `0..9999` | **`@Streaming` `ResponseBody`（图片字节流，非 JSON）** | HTTP 层判定；带重试拦截器 | `:53-55`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/VerifiedDeviceFileCatalog.java:538`（用 `encodedPath("/api/playback/thumbnail").addQueryParameter("file_index", …)` 重建）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProGlideThumbnailPolicy.java:20`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueueKt.java:18` |
| 20 | GET | `/api/playback/rawdata` | `file_index` | `Int` `0..9999` | **`ResponseBody` 原始文件字节流**，支持 `Range` 续传 | HTTP 层；`Ride3ProPlaybackDownloadResumePolicy` 按固件版本决定是否续传，`MAX_RETRY_COUNT = 5` | **不在 `Ride3ProApiService` 里**，由 OkHttp 直接构造：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/VerifiedDeviceFileCatalog.java:497` → `authorizeRide3Pro(..., StreamingTransferEngine.RIDE3PRO_RAWDATA_PATH, ...)` → `:717` 拼 URL；常量 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueueKt.java:16`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:79`（标 `@Deprecated`，仅作路径判定）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java:25, 230` |
| 21 | GET | `/api/playback/start` | `file_index` | `Int` `0..9999` | `result` | `result==0` | `:75-76`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1202` |
| 22 | GET | `/api/playback/pause` | `file_type` | `Int`（**不是** `Ride3ProPlaybackFileEntry.fileType` 那个 String；类型枚举见 §2.8） | `result` | `result==0` | `:66-67`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1525` |
| 23 | GET | `/api/playback/setspeed` | `index` | `Int` 倍速索引 | `result` | `result==0` | `:69-70`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1757` |
| 24 | GET | `/api/playback/settime` | `second` | `Int` 秒（0 起） | `result` | `result==0` | `:72-73`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1709` |
| 25 | GET | `/api/playback/stop` | 无 | — | `result` | `result==0` | `:78-79`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1573`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProRecordRepositoryImpl.java:299` |
| 26 | GET | `/api/playback/delete` | `file_index` | `Int` `0..9999` | `result` | `result==0` | `:63-64`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProIndexedPlaybackRepositoryImpl.java:35`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1627` |
| 27 | POST | `/api/firmware/upload` | `md5sum`, `model`, `hw`, `sw` | 4 个 String；Header 固定 `Content-Type: application/octet-stream`、`Content-Encoding: identity`、`Connection: close`；Body 为 `RequestBody` 原始字节 | `result` | `result==0` | `:99-101`。**语义属 OTA 附录**，本文只登记端点 |

协议特性协商（`/api/device/info` 的 `features` 数组，归一化后参与判定）：
- `Ride3ProProtocolFeatures.NV = "nv"`、`Ride3ProProtocolFeatures.REBOOT = "reboot"`（`tuwin/data/source/remote/api/ride3pro/Ride3ProProtocolFeatures.java:14-16`）。
- `normalize()`：逐项 trim → `toLowerCase(Locale.ROOT)` → 丢弃空串 → `toSet()`（`:19-36`）。**大小写不敏感、顺序无关**。
- 语义：含 `"reboot"` 才允许 `/api/reboot`；含 `"nv"` 走 nv 相关行为（属功能面，本文不展开）。

### 2.2 M3：`/app/*`

唯一声明类型：`tuwin/data/source/remote/api/p006m3/M3ApiService.java`（Retrofit 接口，27 个方法，`:46-138`）。
统一响应包：`{"result": Int, "info": …}`，`isSuccess() == (result == 0)`。`info` 的类型**按端点不同**：有的强类型对象，有的 `List`，有的是裸 `String`（错误消息），`getProductInfo` 是 `Object`、`getMediaInfo` 是 `JsonElement`。
特殊：多数「设置类」端点判据写成 `if (response.getResult() != 0) → Exception("…: " + response.getInfo())`（如 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:515-517`），即直接把 `info` 当错误文本用。
Base URL：`httpBaseUrl(grant)` = `http://<host>:<port>/`；探测阶段固定 80（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java:1886` 传 `httpBaseUrl(str2, 80)`）。
HTTP 客户端兼容性覆盖：`M3HttpClientCompatibilityKt` 设 `M3_CONNECT_TIMEOUT_SECONDS = 5`、`M3_READ_TIMEOUT_SECONDS = 120`、`M3_WRITE_TIMEOUT_SECONDS = 120`（`catalog-ports.md:85-87`），并给 Retrofit 加 `GsonBuilder().setLenient()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java:1915`）——**宽松模式 Gson**，容忍设备返回的非规范 JSON。

| # | 方法 | 路径 | Query 参数 | 参数取值 | 期望响应字段（`info`） | 成功/失败判据 | 声明 / 调用点 |
|---|---|---|---|---|---|---|---|
| 1 | GET | `/app/getproductinfo` | 无 | — | `info` 按 `Map` 手工取 4 个键：`model`、`company`、`soc`、`sp`（缺键 → 空串 `""`；整体异常 → null） | `result==0` 且 `parseDeviceInfo()` 非 null；否则 `IllegalStateException("M3 probe failed: <errorMessage>")` / `"M3 probe response has no product info"`；`errorMessage` 取 `getErrorMessage()`，为 null 时用字面量 `"device rejected request"` | 声明 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:87`；**唯一探测端点**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DefaultDeviceProtocolProfileRegistry.java:34`）；解析 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ProductInfoResponse.java:82-111`；调用 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java:1926-1941` |
| 2 | GET | `/app/getdeviceattr` | 无 | — | `info`: `bssid` / `ssid` / `uuid` / `hwver` / `softver` / `otaver` / `camnum`(int) / `curcamid`(int) / `wifireboot`(int) | `result==0` | 声明 `:66`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:427`；模型 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3DeviceAttrInfo.java:16-40` |
| 3 | GET | `/app/getbatteryinfo` | 无 | — | `info`: `capacity`(int) / `charge`(int) | `result==0` | 声明 `:60`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:277` |
| 4 | GET | `/app/getcurmode` | 无 | — | `info` 是**数组**，元素 = `name`(String) / `value`(Integer?) | `result==0` | 声明 `:63`；`M3DeviceRepositoryImpl.java`；模型 `M3CurModeResponse.java` + `M3CurModeInfo.java` |
| 5 | GET | `/app/getsdinfo` | 无 | — | `info`: `status`(int) / `total`(int) / `free`(int) | `result==0` | 声明 `:93`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:216`；模型 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SDInfo.java:14-20` |
| 6 | GET | `/app/getmediainfo` | 无 | — | **手工解析 `JsonObject`**，3 个键：`rtsp`(String，缺→`""`)、`transport`(String，缺→`""`)、`port`(Int，缺→`0`)；解析异常 → null | `result==0` 且 `getMediaInfo()` 非 null；否则 `getErrorMessage()` 给 `"Media info request failed with code <result>"` 或 `"Unknown error"` | 声明 `:75`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:348, 354`；解析 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3MediaInfoResponse.java:80-96`。**这是 M3 RTSP 端点的唯一来源**（§7） |
| 7 | GET | `/app/getfilelist` | 无 | — | `info` = 数组，元素 = `folder`(String) / `count`(int) / `files[]`；`files[i]` = `name` / `size`(long) / `createtime`(long) / `duration`(int) / `type`(int) | `result==0` | 声明 `:69`；`M3DeviceRepositoryImpl.java`（`onFileListVerified` 回调在校验后触发，`:89`）；模型 `M3FileListResponse.java`、`M3FolderInfo.java`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3FileItem.java:25-37` |
| 8 | GET | `/app/getthumbnail` | `file` | 文件名（`String`，`@Streaming` 返回 `ResponseBody` 图片字节） | 二进制，不走 `result` | HTTP 层 | 声明 `:97`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl$getThumbnail$bitmap$1.java:75` |
| 9 | GET | `/app/getparamitems` | `param` | 参数名；`"all"` = 全量（`Ride6ParameterRequestIds.ALL = "all"`，`tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:18`） | `info` = 数组（`getParamItemsByMode`）或单对象（`getParamItem`），元素 = `name` / `items`(String[]) / `items_disable`(String[]) / `index`(Integer[]) / `cur_index`(Integer?) / `enable`(Integer?) | `result==0` | 声明 `:54`（`getAllParamItems`）、`:90`（`getParamItem`）、`:87`? 修正：`getParamItemsByMode` 在 `:72`? —— 三方法共用同一 `@GET("/app/getparamitems")`；模型 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamItem.java:18-33`。**同一端点被 3 个不同签名的方法重复声明** |
| 10 | GET | `/app/getparamvalue` | `param` | 同上，`"all"` 取全量 | `info` = 数组（`getAllParamValues`）或单对象（`getParamValue`），元素 = `name` / `value` | `result==0` | 声明 `:57`、`:93`；模型 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamValue.java:17-20` |
| 11 | GET | `/app/setparamvalue` | `param`, `value` | `param` = 参数名；`value` = 字符串化的取值。**同一个端点被 3 个方法复用**：`setParamValue(String,String)`、`setRecording(String,int)`、`takeSnapshot(String,int)` | `info` = `String` | `result==0` | 声明 `:112`、`:118`、`:130`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:2683`（setParamValue）、`:1026`（setRecording，默认 `param="rec"`）、`:1095`（takeSnapshot，默认 `param="snapshot"`）；默认值见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:153-171` |
| 12 | GET | `/app/mode` | `param` | **`Int` 拍摄模式号**，取值集合：`16`=PHOTO_SINGLE、`17`=PHOTO_BURST、`18`=PHOTO_TIMELAPSE、`19`=PHOTO_TIMER、`20`=PHOTO_LONG_EXPOSURE、`21`=VIDEO_NORMAL、`22`=VIDEO_LOOP、`23`=VIDEO_TIMELAPSE、`24`=VIDEO_SLOW_MOTION、`25`=VIDEO_FAST_MOTION（`tuwin/core/constants/M3Constants.java` 内 `ShootingMode` 的 10 个常量，另 `MODE_NAME_RES_BY_ID` 一一同名映射到 string 资源） | `info` = `String` | `result==0` | 声明 `:109`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:1162` |
| 13 | GET | `/app/setting` | `param` | 菜单项名（`setMenuMode`） | `info` = `String` | `result==0` | 声明 `:106` |
| 14 | GET | `/app/playback` | `param` | 回放控制串 | `info` = `String` | `result==0` | 声明 `:115` |
| 15 | GET | `/app/setsystime` | `date` | `String`，格式 **`yyyyMMddHHmmss`**，用设备时区格式化：`SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())` + `setTimeZone(timeZoneProvider())`（`tuwin/domain/strategy/M3ConnectionStrategy.java:1341-1343`） | `info` = `String` | `result != 0` → `Exception("Failed to sync M3 device time: " + info)` | 声明 `:121`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:545` |
| 16 | GET | `/app/settimezone` | `tz` | `Int`，**小时数**的 UTC 偏移：`timeZone.getRawOffset() / MILLIS_PER_HOUR`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java:1345`）。⚠ 参数名不是字面量而是常量引用 `C3059bv.f1692M`，判定为 `"tz"`，理由见本节末「常量还原说明」 | `info` = `String` | `result != 0` → `Exception("Failed to sync M3 device timezone: " + info)` | 声明 `:125`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:506, 514, 568` |
| 17 | GET | `/app/setwifi` | `wifissid`, `wifipwd` | 两个都**可空**（`DefaultImpls.setWifi$default` 按 bit 1/2 分别置 null，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:140-151`） | `info` = `String` | `result==0` | 声明 `:127` |
| 18 | GET | `/app/sdformat` | 无 | — | `info` = `String` | `result==0` | 声明 `:103` |
| 19 | GET | `/app/reset` | 无 | — | `info` = `String` | `result==0` | 声明 `:100` |
| 20 | GET | `/app/deletefile` | `file` | 文件名 | `info` = `String` | `result==0` | 声明 `:47` |
| 21 | GET | （动态 `@Url`） | — | `fileUrl` 由上层拼装的完整 URL | `@Streaming ResponseBody` | HTTP 层 | 声明 `:49-51` `downloadFile(@Url String)`。**在整份源码里没有任何调用方**（见 §2.7） |
| 22 | POST | `/upload/{savepath}/{filesize}` | 无（值走 Path） | `@Path(encoded=true) savepath` = `"mnt/sdcard"`（**硬编码，且 `encoded=true` 所以不含 scheme/host**）、`@Path filesize` = `Long` 文件字节数；Body = `RequestBody` | `info` = `String` | `result==0` | 声明 `:133-135`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl$uploadFirmware$2.java:171`。语义属 OTA 附录，本文只登记 |

**M3 的 3 个死端点（声明了但全仓无调用方）**：`getAllParamItems`（`/app/getparamitems`）、`getAllParamValues`（`/app/getparamvalue`）、`getParamValue`（`/app/getparamvalue`）。
证据：`grep -rln "\bgetAllParamItems\b" _work/tuwin_src/sources/com/tuwinsmart` 只命中 `M3ApiService.java` 一个文件；`getAllParamValues`、`getParamValue` 同样。
含义：官方 App 的 M3 设置页只走「按模式取 items」`getParamItemsByMode` + 「单值取」`getParamItem` + `setParamValue`，**没有使用「一次拉全部参数值」的能力**。复现时若照抄 `getAllParamValues` 属于过度实现。

**常量还原说明（3 个被 JADX 折叠成 umeng 常量的字面量）**：

| 引用点 | 常量 | 还原值 | 依据 |
|---|---|---|---|
| `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:125` `@Query(C3059bv.f1692M)` | `com.umeng.bv.M` | `"tz"` | `com/umeng/commonsdk/statistics/C3243b.java:121` 在「逻辑键 → 缩写键」映射表里写 `f3189j.put(C3059bv.f1692M, "#tz")`，同表的逻辑键全是明文（`"device_model"`、`"app_version"`、`"version_code"`、`"st"`、`"analytics"`），故该逻辑键为时区的两字母缩写 `tz`。**标记为推断**，未在该 APK 里找到 `f1692M` 的声明体 |
| `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:70` `@Query(C3174a.f2698H)` | `com.umeng.ccg.a.H` | `"index"` | 三处独立交叉验证：`androidx/collection/LongSparseArrayKt.java:108` 的 Kotlin `@Metadata.d2` 里，该常量出现在 `getIndex`/`setIndex` 之间的**属性名**槽位；`androidx/core/view/MenuKt.java:67` 同理；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamItem.java:24` 的 `@SerializedName(C3174a.f2698H)` 对应字段名正是 `List<Integer> index` |
| `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamItem.java:21` `@SerializedName(C3077cm.f1941q)` | `com.umeng.analytics.pro.cm.q` | `"enable"` | 同文件字段声明顺序与 `@SerializedName` 顺序一一对应：`cur_index`→`curIndex`、`<f1941q>`→`enable`、`<f2698H>`→`index`、`items`→`items`、`items_disable`→`itemsDisable`、`name`→`name` |

### 2.3 Ride5：`cgi-bin/hisnet/*.cgi`

唯一声明类型：`tuwin/core/device/ride5/Ride5CgiApi.java`（Retrofit 接口，25 个方法，`:15-93`）。
**全部是 GET**，无 POST/Body。
路径**不以 `/` 开头**（除 `formatSdCard` 外）→ Retrofit 按相对路径解析到 baseUrl 的当前目录，即 `http://192.168.0.1/cgi-bin/hisnet/xxx.cgi`（baseUrl 由 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGatewayKt.java:31` 的 `"http://"` 前缀拼装）。
**参数名全部带前导 `-`**（`-ip`、`-workmode`、`-type`、`-dir`、`-start`、`-end`、`-name`、`-cmd`、`-value`、`-time`、`-wifissid`、`-wifikey`、`-camid`、`-model`、`-softversion`、`-pktlen`、`-operation`），这是海思网络 CGI 的传统写法。
返回**不是 JSON**，是 JS 片段文本，由 `Ride5CgiParser` 解析。

**响应解析规则（`tuwin/core/device/ride5/Ride5CgiParser.java:12-46`）**——这是 Ride5 全部端点的共同判据，先讲清再列表：
1. `trim(body) == "Success"`（区分大小写，字面量）→ 返回 `{success: "true"}`，字节数 = body.length。
2. 否则整串匹配 `businessError` 正则 `^SvrFuncResult\s*=\s*"(-?\d+)"\s*;?$` → 抛 `Ride5CgiException.BusinessError(<捕获的负数或正数>)`。**这是业务失败的唯一致命通道**，捕获组就是错误码（允许前导 `-`）。
3. 否则循环用 `assignment` 正则 `^\s*var\s+([A-Za-z_][A-Za-z0-9_]*)\s*=\s*"((?:\\.|[^"\\])*)"\s*;?` 逐段吃：键 = 组1，值 = 组2 经 `unescape`（反斜杠转义还原），然后把游标推到本次匹配末尾 +1。
4. 结束条件：串变空 或 找不到下一个匹配。
5. 最终判定：`若 (map 为空) 或 (剩余游标串 trim 后仍非空) → 抛 Ride5CgiException.ProtocolError("Unrecognized RIDE5 CGI response (length=N)")`。**即要求整个响应被 `var k="v";` 序列完整覆盖，不允许有游离文本**。
6. 成功时往 map 里额外塞 `success = "true"`。

`parseFileList`（`:63-95`）是特例：按 `;` 切分并 trim、丢空；每条必须通过 `isConfirmedFileListPath`，否则 `ProtocolError("Unrecognized RIDE5 file list response (length=N)")`；成功返回 `{success:"true", files: <原始 trim 后的串>}`（键名 `OSSHeaders.ORIGIN` → `"files"`）。空串或 `"Success"` 都当「零文件」成功。
`parseReset`（`:53-61`）：空响应直接算成功（`{success:"true"}`），否则退回 `parse`。

| # | 方法 | 路径（原样） | Query 参数 | 参数取值 | 解析后字段 | 成功/失败判据 | 声明 / 调用点 |
|---|---|---|---|---|---|---|---|
| 1 | GET | `cgi-bin/hisnet/getdeviceattr.cgi` | 无 | — | 若干 `var` 键值 | 通用规则 | 声明 `:46`；**Ride5 唯一探测端点**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DefaultDeviceProtocolProfileRegistry.java:34`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionConnector$connectUserInitiated$verified$1.java:153`） |
| 2 | GET | `cgi-bin/hisnet/checkconnect.cgi` | `-ip` | 回调 IP（`Ride5SessionConnector` 的 `callbackIp` 形参，由上层从网络 lease 取得） | — | 通用规则 | 声明 `:16`；`Ride5CgiGateway.java` |
| 3 | GET | `cgi-bin/hisnet/client.cgi` | `-operation`, `-ip` | `-operation` 只有两个字面值：**`"register"`** 与 **`"unregister"`**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:305` 与 `:357` 各传一个）；`-ip` = 手机侧回调 IP | — | 通用规则 | 声明 `:70`。这是**设备反向连接手机的注册握手**，回调端口 `Ride5DeviceAdapterSession.CALLBACK_PORT = 9002` |
| 4 | GET | `cgi-bin/hisnet/getworkstate.cgi` | 无 | — | 含 `running` 键（值 `"true"`/`"false"`，见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/EmptyControlVideo.java:591` 的 `fields.get("running")` 与 `Intrinsics.areEqual(..., "true")`） | 通用规则 | 声明 `:67`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5GatewaySessionPort.java:20` |
| 5 | GET | `cgi-bin/hisnet/workmodecmd.cgi` | `-cmd` | 观测到的字面值只有 2 个：**`"stop"`**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionPort.java:49` 的默认实现 `ensureRecordingStopped`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/SerializedRide5RecordingSessionPort.java:371, 411`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:1539`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/StorageManagerActivityKt.java:60`）、**`"trigger"`**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:1164`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/EmptyControlVideo.java:907`，用于拍照/录像触发）。形参是 `String`，无枚举约束，其他取值未出现在反编译代码中 | — | 通用规则 | 声明 `:91`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:611, 625` |
| 6 | GET | `cgi-bin/hisnet/getcamchnl.cgi` | `-camid` | 摄像头 id（字符串化 Int；来自 UI，无枚举约束） | — | 通用规则 | 声明 `:88`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:1204` |
| 7 | GET | `cgi-bin/hisnet/getcamnum.cgi` | 无 | — | 摄像头数量 | 通用规则 | 声明 `:31` |
| 8 | GET | `cgi-bin/hisnet/getcamparam.cgi` | `-workmode`, `-type` | 两个都是 String，`-workmode` = 工作模式名，`-type` = 参数类型名；由设备侧 `getdircapability`/上层设置页动态下发，源码中**无固定字面值集合** | — | 通用规则 | 声明 `:34`；`Ride5GatewaySessionPort.cameraParameter(...)` |
| 9 | GET | `cgi-bin/hisnet/getcamparamcapability.cgi` | `-workmode`, `-type` | 同上 | — | 通用规则 | 声明 `:37` |
| 10 | GET | `cgi-bin/hisnet/setcamparam.cgi` | `-workmode`, `-type`, `-value` | 前两个同上；`-value` 为字符串化取值 | — | 通用规则 | 声明 `:76` |
| 11 | GET | `cgi-bin/hisnet/getcommparam.cgi` | `-type` | 参数类型名（String） | — | 通用规则 | 声明 `:40` |
| 12 | GET | `cgi-bin/hisnet/getcommparamcapability.cgi` | `-type` | 同上 | — | 通用规则 | 声明 `:43` |
| 13 | GET | `cgi-bin/hisnet/setcommparam.cgi` | `-type`, `-value` | 同上 | — | 通用规则 | 声明 `:79` |
| 14 | GET | `cgi-bin/hisnet/getdircapability.cgi` | 无 | — | 目录能力清单 | 通用规则 | 声明 `:49`；`Ride5GatewaySessionPort.directoryCapability()` |
| 15 | GET | `cgi-bin/hisnet/getdirfilecount.cgi` | `-dir` | 目录名（String，来自 `getdircapability` 结果） | 文件数 | 通用规则 | 声明 `:52`；`Ride5GatewaySessionPort.fileCount(dir)` |
| 16 | GET | `cgi-bin/hisnet/getdirfilelist.cgi` | `-dir`, `-start`, `-end` | `-start`/`-end` 为**字符串化的索引区间**（分页游标） | 走 `parseFileList` → `files` 键（`;` 分隔的路径串） | `parseFileList` 专属规则（每段必须过 `isConfirmedFileListPath`） | 声明 `:55`；`Ride5GatewaySessionPort.fileList(dir, start, end)` |
| 17 | GET | `cgi-bin/hisnet/getfileinfo.cgi` | `-name` | 文件名 | — | 通用规则 | 声明 `:58` |
| 18 | GET | `cgi-bin/hisnet/deletefile.cgi` | `-name` | 文件名 | — | 通用规则 | 声明 `:22` |
| 19 | GET | `cgi-bin/hisnet/sdcommand.cgi?&-format` | 无 | **无 `@Query`，格式串本身就是完整 URL**：`…/cgi-bin/hisnet/sdcommand.cgi?&-format`——`?` 后紧跟一个空的 `&`，`-format` 是**无值开关参数**（复现时必须逐字节一致） | — | 通用规则 | 声明 `:25`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:1039, 1053`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/RecordingEventRide5SessionPort.java:139` |
| 20 | GET | `cgi-bin/hisnet/getsdstatus.cgi` | 无 | — | SD 卡状态 | 通用规则 | 声明 `:61` |
| 21 | GET | `cgi-bin/hisnet/getbatterycapacity.cgi` | 无 | — | 电量 | 通用规则 | 声明 `:28` |
| 22 | GET | `cgi-bin/hisnet/getwifi.cgi` | 无 | — | WiFi 配置 | 通用规则 | 声明 `:64`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:1225` |
| 23 | GET | `cgi-bin/hisnet/setwifi.cgi` | `-wifissid`, `-wifikey` | 注意参数名是 `-wifikey` 而**不是** `-wifipwd`（与 M3 的 `wifipwd` 不一致） | — | 通用规则 | 声明 `:85-86`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:1274` |
| 24 | GET | `cgi-bin/hisnet/setsystime.cgi` | `-time` | `String`，格式 `yyyyMMddHHmmss`。常量 `Ride5ConnectionStrategy.RIDE5_TIME_PATTERN = "yyyyMMddHHmmss"`（`_work/re/tuwin/catalog-consts.md:704`；同族的 M3 常量是 `M3ConnectionStrategy.M3_TIME_PATTERN = "yyyyMMddHHmmss"`，`tuwin/domain/strategy/M3ConnectionStrategy.java:79`），三处一致 | — | 通用规则 | 声明 `:82` |
| 25 | GET | `cgi-bin/hisnet/reset.cgi` | 无 | — | 走 `parseReset`：**空响应即成功** | `parseReset` 专属规则 | 声明 `:73` |
| 26 | GET | `cgi-bin/hisnet/checkupgradepktinfo.cgi` | `-model`, `-softversion`, `-pktlen` | 三个 String；`-model`/`-softversion` 来自设备属性，`-pktlen` 为分包长度 | — | 通用规则 | 声明 `:19`；`Ride5GatewaySessionPort.checkPacket(...)`。语义属 OTA 附录 |

### 2.4 媒体与流端点

| 机型 | 用途 | 端点 | 端口 | 来源 / 证据 |
|---|---|---|---|---|
| Ride3Pro / Ride6 | RTSP 预览 | `rtsp://<mediaGrant.host>:<port>/?action=stream`（**路径为空、query 直接跟在 `/?` 后**） | `8080` | `tuwin/core/device/ride3pro/DocumentedRide3ProMediaEndpointResolver.java:26-31`；端口常量 `Ride3ProDeviceAdapterSession.RTSP_PREVIEW_PORT = 8080`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProDeviceAdapterSession.java:62`）；`allowedMediaPorts = {8080}` |
| Ride3Pro / Ride6 | 缩略图 | `/api/playback/thumbnail?file_index=<n>` | 80 | 见 §2.1 第 19 行 |
| Ride3Pro / Ride6 | 原文件下载 | `/api/playback/rawdata?file_index=<n>` | 80 | 见 §2.1 第 20 行 |
| Ride5 | RTSP 直播 | `rtsp://<mediaGrant.host>:<port>/livestream/1`（**路径写死为 `/livestream/1`**，而授权 grant 的 `allowedPathPrefixes` 是 `{"/livestream"}`，即允许前缀比实际用的路径更宽） | `554`（`Ride5DeviceAdapterSession.RTSP_LIVE_PORT`） | `tuwin/core/device/ride5/Ride5DeviceMediaPort.java:110`；grant 签发 `tuwin/core/device/ride5/Ride5DeviceAdapterSession.java:251` |
| Ride5 | 设备反向回调（**TCP 服务端在手机上**） | `DeviceEndpointProtocol.TCP` + `EndpointPurpose.CALLBACK` + `allowedPorts = {9002}` + `allowedPathPrefixes = {"/"}` | `9002`（`Ride5DeviceAdapterSession.CALLBACK_PORT`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java:250`；实现 `tuwin/core/device/ride5/JavaRide5CallbackServerSocket.java`、`Ride5CallbackChannel` |
| M3 | RTSP 预览 | `rtsp://<controlHost>:<port><rawPath>`，其中 `port`/`rawPath` **取自设备 `/app/getmediainfo` 响应**，但 **host 强制替换为控制 host**（设备自报的 RTSP host 被丢弃） | 响应里的 `port`；无 port 时用 `554`（`M3DynamicEndpointPolicy.RTSP_DEFAULT_PORT`，标 `@Deprecated`） | `tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java` 的 `parse()`；`tuwin/core/device/p005m3/M3EndpointHostPolicy.java` 的 `fixedRtspUrl(rawUrl, host, declaredPort)` |
| M3 | 回放文件（走 RTSP 而不是 HTTP） | `rtsp://<mediaGrant.host>:<port>/<mediaGrantPath>/<fileName>`（`fileName` 去掉前导 `/`，含 `..` 或空白直接拒绝：`IllegalArgumentException("M3 media file path is invalid")`） | 媒体 grant 的唯一端口（`singleOrNull`，多个则 `RouteUnavailableException("M3 media grant port is ambiguous")`） | `tuwin/core/device/p005m3/M3SessionRepositoryFactory.java`（`authorizeRtspUrl` 前的路径拼装，见 `:135-156` 区段） |

M3 RTSP 校验的完整拒绝链（`M3EndpointHostPolicy.fixedRtspUrl`，逐条）：
1. `URI(trim(rawUrl))` 解析失败 → `IllegalArgumentException("M3 RTSP URL is invalid")`
2. scheme 忽略大小写不等于 `rtsp` → `"M3 RTSP URL must use rtsp scheme"`
3. `rawUserInfo` 非空 → `"M3 RTSP URL cannot contain credentials"`（**URL 里带 user:pass 一律拒绝**）
4. URL 端口不在 `1..65535` 且 `declaredPort` 也不在 → `"M3 RTSP URL has no valid port"`
5. URL 端口与响应声明端口同时存在但不等 → `"M3 RTSP port differs from response port"`
6. host trim + 去方括号后为空白 → `"M3 fixed device host is required"`；含 `:` 时重新包方括号（IPv6）

`M3DynamicEndpointPolicy.parse(controlHost, media)` 的独立拒绝链：`"M3 media response has invalid RTSP URL"` → `"M3 media response must use rtsp scheme"` → `"M3 media response cannot contain RTSP credentials"` → `"M3 media response has no RTSP host"` → `"M3 media response has invalid socket port"`（`media.port` 不在 `1..65535`）→ `"M3 media response has invalid RTSP port"` → `"M3 RTSP port is outside the device profile"`（当 `allowedMediaPorts` 非空且不含该端口；**M3 的 `allowedMediaPorts` 是空集，所以这条检查对 M3 恒不触发**，见 §1.4）。

Ride3Pro 的**操作级 grant 表**（`tuwin/core/device/ride3pro/Ride3ProDeviceAdapterSession.java:818-823`，`issueOperationGrants`）——这是 `/api/` 白名单在运行时真正被细分的地方，5 条一次性签发，全部 `EndpointGrantSource.DEVICE_PROBE_RESPONSE`、端口沿用控制 grant 的 `{80}`：

| HttpClientProfile | EndpointPurpose | allowedPathPrefixes |
|---|---|---|
| `DEVICE_FILE` | `FILE` | `{"/api/playback/"}` |
| `DEVICE_MENU` | `MENU` | `{"/api/menu/"}` |
| `DEVICE_IMAGE` | `IMAGE` | `{"/api/playback/thumbnail"}` |
| `DEVICE_UPLOAD` | `OTA` | `{"/api/firmware/"}` |
| `DEVICE_LONG_OPERATION` | `OTA` | `{"/api/"}` |

同一文件 `:826-830` 还有一份私有 `requireSuccessful`，失败消息是 `"Ride3Pro request failed: <endpoint>, result=<result>"`（与探测用的 `"RIDE3PRO probe failed: …"` 是两条不同字面量，注意大小写差异：probe 用全大写 `RIDE3PRO`，业务用驼峰 `Ride3Pro`）。

设备日志下载（属诊断日志面，此处只登记端点）：`tuwin/data/source/remote/gateway/DeviceLogEndpointPolicy.java:12-27`
- `date` 必须匹配正则 `\d{8}`（YYYYMMDD），否则 `IllegalStateException("Failed requirement.")`。
- Ride3Pro / Ride6 → `http://192.168.25.1:80/api/log/get`
- M3 / Ride5 → `http://<hostFor(type)>:80/sd/LOG<date>.txt`
- URL 用 `HttpUrl.Builder().scheme("http").host(DeviceHostPolicy.hostFor(type)).port(80).encodedPath(path)` 直接拼，**不走 EndpointGrant**（唯一绕开授权面的设备请求）。

### 2.5 catalog 中出现但未归入上表的路径

`_work/re/tuwin/catalog-http.md` 共 269 行。逐条给出去向，**未归入 §2.1–§2.4 的每条都说明原因**：

| 字面量（组） | 出现处 | 为什么不在端点表里 |
|---|---|---|
| `/`（约 55 行，含 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:921`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceProtocolProfile.java:233`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:612` 等） | 遍布各层 | **不是端点，是字符串运算的分隔符**。`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceProtocolProfile.java:233` 的 `/` 是 `normalizePath` 的兜底返回值；其余是 `split("/")` / `trimEnd('/')` / 路径拼接的分隔符。目录工具按「含 `/` 的字面量」粗筛命中，全是误报 |
| `//`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionRepositoryFactory.java:151`） | 同文件 `:151` | 是 `StringsKt.replace$default(..., "//", "/", ...)` 的**被替换串**，用于把拼出来的双斜杠压成单斜杠，不是端点 |
| `http://`、`https://`、`rtsp://`、`content://`（各 2-10 行） | 连接器与策略类 | **scheme 前缀片段**，用于 `startsWith` 判定或 `StringBuilder("rtsp://")` 拼接。真正的完整端点已在 §2.1–§2.4 逐条列出 |
| `/api/`、`/app/`、`/api/firmware/`、`/api/menu/`、`/api/playback/`、`/api/playback/thumbnail`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProDeviceAdapterSession.java:823`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DefaultDeviceProtocolProfileRegistry.java:34`） | 授权面 | **是 `allowedPathPrefixes` 白名单条目，不是可请求的 URL**。已在 §1.4（profile 字段表）与 §2.4（Ride3Pro 操作级 grant 表）中列出，重复进端点表会造成「这几个路径也能 GET」的误解 |
| `/api/device/`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionConnector$connectUserInitiated$verified$1.java:73`） | 探测 | 同上，是 PROBE grant 的路径前缀，见 §1.5 差异点 1 |
| `/cgi-bin/hisnet/`、`/cgi-bin/hisnet/getdeviceattr.cgi`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionConnector$connectUserInitiated$verified$1.java:88, 153`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DefaultDeviceProtocolProfileRegistry.java:34`） | 探测 | 同上，Ride5 的前缀与 bootstrap 端点，已在 §1.4/§2.3 |
| `/upload`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionRepositoryFactory.java:79`） | OTA | 常量 `M3_OTA_PATH_PREFIX = "/upload"` 且**标了 `@Deprecated`**；M3 真实上传路径是 `/upload/{savepath}/{filesize}`（§2.2 第 22 行）。旧常量仅作历史兼容判定 |
| `/api/log/get`、`/sd/LOG`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/gateway/DeviceLogEndpointPolicy.java:29, 31`） | 诊断日志 | 已在 §2.4 末尾单列（属诊断面，不是设备控制协议） |
| `/CLOG`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/WriteRuntimeLogTree.java:47`）、`/LOG`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/wifi/LogHelper.java:124`）、`/TUWIN`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:2752`） | 日志/下载 | **Android 外部存储目录名**，不是 HTTP 路径 |
| `.json`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackCatalogPersistentCacheStore.java:290`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackPersistentCacheStore.java:207`）、`manifest.json`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/RuntimeLogSnapshot.java:65`）、`/koin.properties`（`KoinApplicationExtKt.java:17`，归属 `UNKNOWN`） | 本地缓存/DI | **本地文件名** |
| `/img/shadow-blue.png` 等 6 条（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/internet/ExternalResourceAllowlist.java:30`） | H5 | 内嵌 WebView 的**外链资源白名单**（相对 `http://tuwinwifihelp.tuwinsmart.com` 之类的外网基址），不属设备协议面 |
| `/pcn_manager/download_static_file`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/internet/ExternalResourceAllowlist.java:19`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/internet/ExternalWebCompatibilityPolicy.java:203`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/internet/ExternalWebResourcePolicy.java:15`） | H5 | 外网（腾讯 PCN 静态资源）路径，属网络层共存面 |
| `/privacy.html`、`https://yomu.atlasmeta.one`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/PrivacyPolicySource.java:16, 33`） | 隐私 | 外网站点，属合规面 |
| `/m/8acYvvtd8S4`、`/s/S-odmnyu7jctrZZlzBwGMA`、`/s/wXxedWNrYloV9v7t4f5Qtw`、`/twoBbgH2l4Y`、`/app/id6740312738`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/internet/ExternalWebCompatibilityPolicy.java:25, 28, 31, 50`） | H5 | 微信/帮助站的**具体文章 ID 路径**，写在 URL 兼容白名单里，非设备协议 |
| `http://tuwinwifihelp.tuwinsmart.com/…`（10 行）、`http://ride5helpnew.tuwinsmart.com/#/`、`http://ali.tuwinsmart.com/`、`http://ali.tuwinsmart.com/feedback`、`https://tuwin.tmall.com`、`tbopen://…`、`tmall://page.tm/shop?shopId=255736524`、`https://work.weixin.qq.com/kfid/kfc5097d1b6381f03e7` | 帮助/反馈/电商 | **云端与第三方 App 唤起面**，属其他附录（帮助与反馈、OTA 云端） |
| `http://schemas.android.com/apk/res/android`（3 行，归属 `UNKNOWN`） | flyco tablayout | Android 自定义 View 的 **XML namespace 常量**，误报 |
| `content://com.meizu.flyme.openidsdk/`（`_work/tuwin_src/sources/org/repackage/com/meizu/flyme/openidsdk/C4010b.java:120`，`UNKNOWN`） | 魅族推送 | 第三方推送 SDK 的 ContentProvider URI，误报 |
| `, action=`、`, elevationFraction=`、`, translationXFraction=`、`, translationYFraction=`、`onTouch surface_container action=`、`ParamSetting(param=`、`PlayListGesture multi-pointer ignored, pointerCount=%d, action=%d` | UI/事件类 | **日志与 `toString()` 的格式串**，含 `action=` 被 `=` 规则误命中 |
| `Ride protocol recording event persistence failed: action=%s session=%s`、`RIDE5 recording event persistence failed: action=%s session=%s` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProRecordRepositoryImpl.java:706`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/RecordingEventRide5SessionPort.java:434` | **录像事件落库失败的日志模板**，不是 HTTP 模板；两者的机型前缀不同（`Ride protocol` vs `RIDE5`） |
| `/`（`/api/authdevice` 等已归类） | — | 无 |

**结论：`catalog-http.md` 的 269 行里，真正的设备侧 HTTP/CGI/RTSP 端点共 74 条**（Ride3Pro 27 + M3 22 + Ride5 26 = 75，其中 `/api/playback/thumbnail` 与 `/api/playback/rawdata` 在 §2.1 已作为端点行、在 §2.4 又各占一行，去重后 74）。其余 195 行为分隔符、scheme 片段、白名单前缀、本地文件名、外网/H5/第三方 SDK 与日志格式串。

### 2.6 跨机型的公共约定

1. **鉴权方式：全部机型都是「无鉴权明文 HTTP」**。没有任何 `Authorization`、`Cookie`、签名、时间戳头的注入逻辑；唯一的「握手」是 Ride3Pro 的 `seed`（§3）和 Ride5 的 `-ip` 回调注册（§2.3 第 3 行）。设备访问控制完全依赖「手机连到了设备自己的 AP」。
2. **成功判据两族**：JSON 族统一 `result == 0`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse.java:82-84`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ProductInfoResponse.java:78-80` 及各 M3 响应类的 `getResult() != 0` 判定）；CGI 族是「全文被 `var k="v";` 覆盖 + 无 `SvrFuncResult="<n>"`」。
3. **错误信息一律把 `info` 当人类可读文本用**（M3 的 `info` 是 `String`；Ride3Pro 的 `getErrorMessage()` 拼 `result=` + `info`），意味着设备可以在 `info` 里放任意文案，客户端不做白名单。
4. **Ride3Pro 每个请求都过 `EndpointAuthority.authorizeUrl`**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceEndpointAuthority.java:116+`），由 `Interceptor` 在 OkHttp 层拦截并可能抛 `EndpointNotAuthorizedException`；拦截器生成见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:905-914`（`endpointInterceptor`，M3 同理，`purpose` 传 `CONTROL`）。
5. **Gson 一律 `setLenient()`**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java:1915`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionConnector.java:1870`），对设备返回的非规范 JSON 宽容。

### 2.7 声明了但没有任何调用方的端点（复现时应跳过）

| 端点 | 声明处 | 证据 |
|---|---|---|
| M3 `/app/getparamitems` 的 `getAllParamItems(String param)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:54` | `grep -rln "\bgetAllParamItems\b" _work/tuwin_src/sources/com/tuwinsmart` 只命中 `M3ApiService.java` |
| M3 `/app/getparamvalue` 的 `getAllParamValues(String param)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:57` | 同上，只命中声明文件 |
| M3 `/app/getparamvalue` 的 `getParamValue(String param)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:93` 附近 | 同上 |
| M3 `downloadFile(@Url String)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:49-51` | 全仓对 `M3ApiService` 的 `downloadFile` 无调用（`DownloadUtil.downloadFile` 是同名不同类的业务方法，已在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1140` 排除） |
| Ride3Pro `/api/setmode` 的 `mode = 1` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:93-94` | 全仓只出现 `setMode(0)` 与 `setMode(2)` 两个字面实参（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:98`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/C2216x9d51f82a.java:47`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:193`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProIndexedPlaybackModeAction.java:69`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProStorageCapabilityProbe.java:160`），`1` 无任何出现，形参是裸 `int` |
| `DeviceProtocolProfile.acceptsDynamicMediaHost` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceProtocolProfile.java:209` | 见 §1.5 |

注意：`getAllParamItems` / `getAllParamValues` **有**默认参数生成器（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:173-195`，默认 `param = "all"`），也就是说官方代码「写好但忘了接」的可能性极高——复现时如果要一次性拉全量参数，可以照这两个端点做，但要清楚官方 App 当前没走这条路。

### 2.8 未确认的取值域（明确记录，不猜测）

| 项 | 已知 | 未知 |
|---|---|---|
| Ride3Pro `/api/setmode` | `0` = 预览/录像（`MODE_PREVIEW`）、`2` = 回放（`MODE_PLAYBACK`） | `1` 的语义。设备侧很可能存在但未在客户端出现 |
| Ride3Pro `/api/playback/pause?file_type=` | 参数是 `Int` | 取值集合。设备响应里的 `file_type` 是 **String**（`Ride3ProPlaybackFileEntry.java`），两者不同型，无法互相映射；仓库里未发现 Int 常量表 |
| Ride3Pro `/api/playback/setspeed?index=` | 参数是 `Int` 索引 | 索引到倍速的映射表在 UI 层（属播放器面） |
| Ride5 `workmodecmd.cgi?-cmd=` | 实际出现的字面值只有 `"stop"` 与 `"trigger"` | 该 CGI 支持的完整命令集（设备侧能力，客户端未穷举） |
| M3 `/app/playback?param=` | 参数是 String | 具体取值由设置页动态下发（属设置面） |
| `Ride3ProProtocolFeatures` 的 `"nv"` | 是一个 feature 开关名 | 其控制的具体行为属功能面，本文不展开 |

---

## 3. 鉴权与握手

### 3.0 总结论

四个机型**全部没有真正的鉴权**：没有账号/token/签名/加密挑战，没有任何 `Authorization`/`Cookie` 头被注入（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java` 与 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java` 的注解集合里只有 `@GET/@Query/@Body/@Headers/@Streaming/@POST`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:9-16` 的 import 可穷举证明）。访问控制完全靠「手机必须连在设备自己的 AP 上」。存在的最接近握手的东西有三个，按机型分：

| 机型 | 握手物 | 是不是安全机制 | 结论 |
|---|---|---|---|
| Ride3Pro / Ride6 | `GET /api/authdevice?seed=<随机 long>` | 否 | 无状态随机数，响应内容不解析，`result==-2` 被豁免 → 更像「让设备把这台 client 标为已连接 + 刷一次流许可」的通知型调用 |
| M3 | 无 | — | `/app/getproductinfo` 零参数，后续 `/app/getmediainfo` 也零参数 |
| Ride5 | `client.cgi?-operation=register&-ip=<手机 IP>` | 否，是**反向通道注册** | 让设备主动连手机的 9002 端口；不带任何凭据 |

### 3.1 Ride3Pro / Ride6：`/api/authdevice?seed=`

#### seed 从哪来：端侧随机数，不是时间戳、不是常量

| 生成点 | 代码 | 取值域 |
|---|---|---|
| 预览握手 | `kotlin.random.Random.INSTANCE.nextLong(Long.MAX_VALUE)`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:239` | `0 .. 9223372036854775806`（`nextLong(until)` 上界排他，`Long.MAX_VALUE` 取不到） |
| 回放握手 | 同一表达式，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1049` | 同上 |

- 每次进入握手流程**重新生成一个新的 seed**；没有任何地方把它存进 `PreferenceHelper`/字段，也没有和 `System.currentTimeMillis()`、MAC、uuid 做过异或或拼接（全仓 `grep -rn "seed"` 在业务层只命中这两个生成点与 Retrofit 形参透传）。
- 传输形态：`@Query("seed") long`，Retrofit 以十进制无符号字符串拼接（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:22-23`）。所以设备侧能看到的只有 0..2^63-1 的十进制数。
- 结论：**seed 不构成鉴权凭据**，它的作用只能是「让每次 auth 请求 URL 唯一（绕过 HTTP 缓存/代理复用）+ 让设备端有理由回一次新鲜状态」。复现时随便填一个 `[0, 2^63)` 的整数即可，但**必须每次不同**。

#### 请求顺序（预览路径，完整链）

`prepareRtspStream` → `prepareRtspStreamInternal`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:202-392`）：

1. `Ride3ProSessionExecutorResolver.INSTANCE.refreshLegacyBindingIfNeeded()`（`:235`）。
2. 取握手缓存 key（`:237`）；`handshakeKeyProvider.invoke()` 返回 null，或缓存未命中 → 走第 3 步；命中 → 打日志 `"Ride3Pro：当前预览会话已有握手缓存，跳过重复 auth/send-time"`（`:256`）直接跳到第 5 步。
3. `GET /api/authdevice?seed=<随机>`（`:239-247`，经 `runPreviewStep("/api/authdevice", 步骤名"设备认证", …)`）。步骤名走 `previewStepName(R.string.ride3pro_preview_step_device_auth, "设备认证")`（`:240`），即 UI 进度文案，第二个参数是中文兜底。
4. `GET /api/vendor/send-time?year&month&day&hour&minute&second`（`:384-392`），6 个整数取自 `Calendar.getInstance()`：年=`get(1)`、月=`get(2)+1`、日=`get(5)`、时=`get(11)`、分=`get(12)`、秒=`get(13)`（回放路径的逐字段展开见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1097-1103`）。**没有时区参数、没有 UTC 换算**——设备被写成本机本地时间。此步失败只 `Timber.w` + 发一个 `Ride3ProPreviewPrepareWarning.SEND_TIME_FAILED` 警告（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:307-315`），**不阻断预览**。
5. 握手缓存 `markReady(key)`（`:319-321`；回放 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1081-1083`）——注意：**send-time 失败也照样 markReady**，缓存的是「auth 已过」而不是「auth+时间同步都成功」。
6. `GET /api/setmode?mode=0`（`:260-267`），失败**硬抛** `Ride3ProConnectionException.httpFailed("/api/setmode", errorMessage)`（`:273-275`、`:336-338`、`:352-354`）。
7. 启动录像（`recordRepository.startRecording()`，`:276-289`），失败仅 `Timber.w("Ride3Pro：预览准备时启动录像失败，继续尝试预览")` + `Ride3ProPreviewPrepareWarning.RECORDING_START_FAILED`。
8. 之后才由上层拿 `rtsp://…:8080/?action=stream`（§7）去起播。

回放路径（`m2855preparePlaybackRtspStreamIoAF18A`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1020-1136`）只做第 1~5 步的 auth + send-time（**不打 setmode，mode=2 由回放入口另发**），日志文案是 `"Ride3Pro：当前回放会话已有握手缓存，跳过重复 auth/send-time"`（`:1060`）。

#### 响应字段怎么被用：只用 `result`，`info` 完全丢弃

- 响应模型 `Ride3ProApiResponse<T>`，`@SerializedName("result") int` + `@SerializedName("info") T`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse.java:15-19`）。
- `authDevice` 的 `T` 声明为 `Any?`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:23`），调用点只读 `isSuccess()` / `getResult()` / `getErrorMessage()`，**不碰 `getInfo()`**——所以设备在 auth 响应里回什么都行，客户端不解析、不使用（不存在「设备下发一个 key/端口」这类行为）。

#### 失败分支（逐条）

| 条件 | 行为 | 证据 |
|---|---|---|
| `result == 0` | 通过 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse.java:83-85`（`isSuccess()` 定义为 `result == 0`） |
| `result != 0` 但 `result == -2` | **同样通过**（唯一被显式豁免的错误码，语义上是「已认证/重复认证」幂等） | 预览 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:380`（`if (!resp.isSuccess() && resp.getResult() != -2) throw …`）；回放 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1092` |
| `result` 为其它非 0 值 | 预览：抛 `Ride3ProConnectionException.httpFailed("/api/authdevice", getErrorMessage())`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:381`）；回放：不抛，返回 `Result.failure(同样的异常)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1093-1094`） | 同左 |
| HTTP 层异常（连接失败/超时/非 2xx/JSON 解析炸） | 预览：`send-time` 段用 try/catch 吞成警告；auth 段的异常冒泡到 `prepareRtspStream` 的 `catch (Exception)`，被包成 `Ride3ProConnectionException.fetchFailed("Failed to prepare Ride3Pro RTSP stream", e)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:184-187`）；回放对应文案 `"Failed to prepare Ride3Pro playback RTSP stream"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1132-1134`） | 同左 |
| `CancellationException` | 原样重抛，不包装（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:182-183`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1127-1129`） | 同左 |
| `errorMessage` | `getErrorMessage()`：`info` 是 String 时 `"result=<n>, info=<str>"`，否则 `"result=<n>"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse.java:87-95`） | 同左 |

#### 握手缓存：10 分钟内不重复 auth

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPreviewHandshakeCache.java`：

| 项 | 值 / 语义 | 行号 |
|---|---|---|
| `VALIDITY_DURATION_MS` | `600000`（= 10 分钟） | `:18` |
| `NANOSECONDS_PER_MILLISECOND` | `1000000`；时钟是 `System.nanoTime() / 1000000`，**单调时钟，不受系统改时间影响** | `:17`、`:242-243` |
| 容器 | 进程级 `static LinkedHashMap<Key, Entry>`，所有方法 `synchronized`，**无容量上限、不落盘、不跨进程** | `:20`、`:187-239` |
| `Key` | `(deviceIdentity: String, sessionId: String, routeRevision: Long)`；三个字段各自校验：identity/session 非空白、`routeRevision >= 0`，违反抛 `IllegalArgumentException("deviceIdentity is required")` / `"sessionId is required"` / `"routeRevision is required"` | `:24-97` |
| `consume(key, now)` | 命中且 `now - readyAt < 600000` → `true`（**不删除条目**，所以名字是 consume 但语义是 peek：同一次握手的预览+回放可以各自命中）；过期 → `remove` 后 `false` | `:199-211` |
| `markReady(key, now)` | `put`，同一个 key 重复 mark 会刷新时间戳 | `:187-190` |
| `clearSession(sessionId, routeRevision?)` | 按 sessionId（可选再限定 routeRevision）批量摘除 | `:220-236` |
| `clear()` | 全清 | `:238-240` |
| key 的来源 | `Ride3ProSessionExecutorResolver.INSTANCE.current()` 的 `deviceIdentity` / `sessionId` / `routeRevision`；**executor 为 null 或 `deviceIdentity` 为 null 时返回 null key**，于是每次握手都走完整 auth（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:127-134`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:144-151`） | 同左 |

### 3.2 `/api/rtspstatus?seed=`：形参与 auth 一致，但**没有任何业务调用点**

- 声明：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:57-58`，`@GET("/api/rtspstatus") getRtspStatus(@Query("seed") long, Continuation<? super Ride3ProApiResponse<Object>>)`——**与 authDevice 同构**：一个 `long seed`、`info` 不解析。它的作用只可能是「查询设备当前是否允许起 RTSP 流 / 刷一流权限」，具体语义在设备侧，客户端代码里没有任何线索。
- 包装层：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:654-704`（`$seed` 透传给 `Ride3ProApiService.getRtspStatus`，调用点 `:688`）与 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java:397-447`（调用点 `:431`）。
- **全量检索结果**：`grep -rn "getRtspStatus" _work/tuwin_src/sources/com/tuwinsmart` 只命中 5 处，即接口声明（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:58`）+ 两个包装类的协程体和 override（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:688,703`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java:431,446`）。两个 override 是 `implements Ride3ProApiService` 的**实现方**，不是调用方。
- 结论：官方 App 在预览/回放起流前**不发** `/api/rtspstatus`；起流失败的重试靠重跑 §3.1 的 prepare 流程。复现时可以不实现它。（注意 §2.1 第 15 行把「调用点」记成了这两个包装类，见 §8 纠正项 C-1。）

### 3.3 M3：`/app/getproductinfo` 之后拿什么

M3 没有鉴权，探测与会话建立是两段：

1. **探测段**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java`）
   - `executeProbe` 用 PROBE grant 打 `GET /app/getproductinfo`（无 query），基址 `httpBaseUrl(host, 80)`（`:1883-1926`）。
   - OkHttp 构建时叠加 `endpointInterceptor(grant, revision)` 与 `M3HttpClientCompatibilityKt.applyM3HttpCompatibility`（`:1901-1902`），Retrofit 加 `GsonConverterFactory.create(new GsonBuilder().setLenient().create())`（`:1914`）。
   - **重试**：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector$executeProbe$response$1.java:54` 调 `M3SessionConnectorKt.retryM3ProductInfoProbe(maxAttempts, retryDelayMillis, retryDelay, requireRouteActive, request)`；两个参数是 connector 的构造字段 `productInfoProbeMaxAttempts` / `productInfoProbeRetryDelayMillis`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java:81-83`、`:117-135`），默认常量 `M3_PRODUCT_INFO_PROBE_MAX_ATTEMPTS = 5`、`M3_PRODUCT_INFO_PROBE_RETRY_DELAY_MILLIS = 2000`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnectorKt.java:45-46`），`retryM3ProductInfoProbe$default` 的 bit1 直接写死 `i = 5`（`:185-193`）。默认延迟动作是 `DelayKt.delay(ms)`（内部类 `C19062.invokeSuspend`，`:166-181`）。connector 构造器还有两条前置校验：`maxAttempts <= 0` → `IllegalArgumentException("M3 product-info probe requires at least one attempt")`，`retryDelayMillis < 0` → `"M3 product-info probe retry delay cannot be negative"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java:140-145`）。重试主体 `retryM3ProductInfoProbe` **JADX 反编译失败**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnectorKt.java:129-135`，"Method dump skipped, instruction units count: 265"），所以「哪些异常参与重试」静态无解；从形参 `requireRouteActive: Function0<Unit>` 与 `DebugMetadata` 的局部名 `{delayBeforeRetry, requireRouteActive, request, maxAttempts, retryDelayMillis, attempt}`（`:54`）可确定它「每次重试前检查路由仍活跃 + 先 delay 再 request」，但**判定条件需要重跑反编译（`jadx --show-bad-code` 或 baksmali）才能逐条确认**。
   - 失败分支：`result != 0` → `IllegalStateException("M3 probe failed: " + errorMessage)`，`errorMessage` 为 null 时用字面量 `"device rejected request"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java:1931-1936`）；`result == 0` 但 `parseDeviceInfo()` 为 null → `IllegalStateException("M3 probe response has no product info")`（`:1938-1941`；JADX 把 `== null` 渲染成了 `!= null`，语义按错误消息取反，与 §1.5 差异点 3 同一处）。
   - 探测产出的 `DeviceProbeResult` 只带 `model`，serial/firmware/boardVersion/features **全 null**（`:1942`）。
2. **会话段**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java` 的 `M3AdapterSession.open()`，`:169-440`），拿到 verified route 之后按序做：
   - 校验链（任一失败直接抛，不重试）：`deviceType != M3` → `IllegalArgumentException("M3 adapter cannot open <type>")`（`:206-208`）；无 route → `IllegalStateException("M3 session has no verified route")`（`:210-212`）；route 状态不在 `{VERIFIED, READY}` → `IllegalArgumentException("M3 route is not verified: <routeId>@<revision>")`（`:213-215`）；control grant 缺失或与 session/purpose/protocol/revision 不符 → `IllegalStateException("M3 session has no control EndpointGrant")` / `IllegalArgumentException("M3 control EndpointGrant does not match session route")`（`:216-222`）；identity 缺失 → `IllegalStateException("M3 session has no verified identity")`；model 不匹配 → `IllegalArgumentException("M3 model mismatch: <model>")`（`:227-233`，即 §1.5 的二次校验）。
   - **`getproductinfo` 之后拿的是 `/app/getmediainfo`**（协程 `M3DeviceAdapter$M3AdapterSession$open$mediaResponse$1`，`:234-241`），不是任何 auth 请求。响应 `result != 0` → `IllegalStateException("M3 media info request failed: <errorMessage>")`（`:356-358`）；`mediaInfo == null` → `IllegalStateException("M3 media response is not a valid success payload")`（`:360-362`）。
   - 由 `M3DynamicEndpointPolicy.parse(controlHost, media)` 一次算出两个端点：RTSP 媒体端点 + **TCP 事件端点**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java:78`），随后 `issueMediaGrant`（RTSP）+ `issueSocketGrant`（TCP）（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:363-367`、`:916-922`），最后 `authorizeSocket` + `socketConnector.connect(network, grant.host, single(grant.allowedPorts), frameDecoderFactory())`（`:368-385`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter$_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter$M3AdapterSession$open$socket$1.java:55`）。TCP 细节见 §4。

### 3.4 Ride5：无鉴权，但有一段「反向回调注册」握手

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java` 的 `open()`：

1. control grant 校验（`:224-229`，两处 `IllegalArgumentException("Failed requirement.")`）。
2. `callbackIp = getSession().getCallbackIp()`，`trim` 后为空 → **`IllegalStateException("RIDE5 session requires an explicit callback IP")`（`:230-233`、`:363`）**，即 Ride5 没有可用回调 IP 时整个会话直接失败。
3. 签两张 grant：TCP grant（`allowedPorts = {9002}`、前缀 `{"/"}`）与 RTSP grant（`allowedPorts = {554}`、前缀 `{"/livestream"}`），`:250-251`。
4. `Ride5CallbackChannel.start()`——**先在手机上开 9002 服务端**（`:259`）。
5. `registerCallback(callbackIp)` → `client.cgi?-operation=register&-ip=<手机IP>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:305` 传字面量 `"register"`，封装在 `:319-321`）。
6. `checkSocketConnect(callbackIp)` → `checkconnect.cgi?-ip=<手机IP>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:409`、封装 `:423`）。
7. `getDeviceAttributes()` → `getdeviceattr.cgi`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java:304`）。
8. 关闭时 `unregisterCallback(callbackIp)` → `client.cgi?-operation=unregister`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:357`、`:371`；调用点 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java:767-779`）。
9. 失败分支：第 4~7 步任一步抛（含 `Ride5CgiException.BusinessError/ProtocolError`）→ `close()` 整个 session 后重抛（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java:308-360`）。

### 3.5 复现要点

1. Ride3Pro：`authdevice` 与 `send-time` 都要发，但**只有 auth 的失败会阻断**；auth 的 `-2` 必须当成功处理，否则首次连接会概率性失败。
2. Ride3Pro：10 分钟内同一 `(deviceIdentity, sessionId, routeRevision)` 可跳过 auth（等价实现：连接级缓存 auth 状态 10 分钟，用单调时钟计时）。
3. M3：`getmediainfo` 的 `port` 字段同时是**TCP 事件通道端口**（§4），所以 RTSP 端口和事件端口是设备分别给的，不能写死。
4. Ride5：不提供手机侧回调 IP 就不要尝试建会话；`register` 必须在本地 9002 监听起来之后发。

---

## 4. M3 TCP 通道

### 4.1 通道定位：设备 → 手机的**单向事件推送**，没有任何写路径

`M3SessionSocket` 接口只有 4 个成员：`getFailures(): Flow<Throwable>`、`getMessages(): Flow<M3SocketMessage>`、`isOpen(): boolean`、继承 `Closeable`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionSocket.java:12-18`）。
**证据（穷举）**：`grep -rn "getOutputStream\|outputStream" _work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ _work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/socket/` **零命中**；全 `tuwin/` 包里 `getOutputStream` 只在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java` 出现（OTA 文件写，与 socket 无关）。
含义：M3 的所有控制命令仍走 HTTP `/app/*`（§2.2），TCP 只用来接收设备主动推的状态事件。复现时**不需要**实现请求-响应式的 TCP 协议。

### 4.2 连接参数

| 项 | 取值 | 来源 / 证据 |
|---|---|---|
| host | **等于 HTTP 控制 host**，即 `192.168.169.1`（`DeviceHostPolicy.hostFor(M3)`，§1.3）；设备在 `/app/getmediainfo` 里自报的 RTSP host 被丢弃 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java:78`：`new M3DynamicEndpoints(new M3DynamicEndpoint(controlHost, port3, str), new M3DynamicEndpoint(controlHost, media.getPort(), "/"))`，两个端点的 host 都写死为形参 `controlHost` |
| port | **动态**，= `M3MediaInfo.port`（`/app/getmediainfo` 响应的 `port` 字段），不是常量；校验 `1 <= port < 65536`，否则 `IllegalArgumentException("M3 media response has invalid socket port")` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java:59-62`；端口取值链见 §2.2 第 6 行；grant 侧 `((Number) CollectionsKt.single(grant.getAllowedPorts())).intValue()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter$_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter$M3AdapterSession$open$socket$1.java:55`） |
| port 有没有默认值 | **没有**。RTSP 端点在 URI 不带端口时回落 `554`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java:66`，用 `M3DynamicEndpointPolicy.RTSP_DEFAULT_PORT`，该常量标 `@Deprecated`，`:20-21`），但 TCP 端点**只用** `media.getPort()`，`M3MediaInfo.port` 缺失时按解析规则给 `0`（§2.2 第 6 行），`0` 立刻被 `1 <= port` 判掉 → 整个 open 失败 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java:59-62`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3MediaInfo.java`（`port` 缺省 0） |
| EndpointGrant | `protocol = TCP`、`allowedPorts = {port}`、`allowedPathPrefixes = {"/"}`、`purpose = MEDIA`、`source = DEVICE_MEDIA_RESPONSE` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:920-922`（`issueSocketGrant`） |
| 授权动作 | `endpointAuthority.authorizeSocket(grantId, sessionId, revision, EndpointPurpose.MEDIA, host, port)`，随后才 connect | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:372`、`:375-385` |
| 绑到哪个 `Network` | `routeLease.getNetwork()`；为 null → `IllegalStateException("M3 route has no Android Network")`。socket 由该 Network 的 SocketFactory 创建，因此流量被钉死在设备 AP 对应的网络上 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:368-371`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:138`（`network.getSocketFactory().createSocket()`） |
| 连接超时 | `connectTimeoutMillis`，生产用默认值 **15000 ms** | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:85-87`（合成构造器 `(i3 & 1) != 0 ? C3065ca.f1878b : i`）；`_work/tuwin_src/sources/com/umeng/analytics/pro/C3065ca.java:20` `f1878b = 15000`（JADX 把同值字面量折叠成了 umeng 常量字段）；生产实例化点 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:97-104`（`new DefaultM3SocketConnector(0, 0, 3, null)`，即两个参数全走默认） |
| 单次读缓冲 | `maxReadBytes = 4096` 字节 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:86`（`(i3 & 2) != 0 ? 4096 : i2`），传给 `SessionSocket`：`:333` |
| connect 调用 | `socket.connect(new InetSocketAddress(host, port), connectTimeoutMillis)`，在 `withContext(Dispatchers.IO)` 里执行；协程被取消时 `invokeOnCancellation` 里 `socket.close()` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:141-147`、`:442`、`:416-440` |
| 其它 socket 选项 | **完全没有**：无 `setSoTimeout`、`setTcpNoDelay`、`setKeepAlive`、`setSendBufferSize`（`grep -rn` 在 `tuwin/core/device/p005m3/` 下零命中）→ 读是阻塞读，靠对端关连接或协程取消退出 | 同上（检索范围为整个 `p005m3` 目录） |
| 失败/取消的清理 | `connect` 抛任何 `Throwable` → 若已产出 SessionSocket 先 `close()`，否则 `socket.close()`，再原样重抛；`CancellationException` 分支同构 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:153-206`、`:311-322` |

### 4.3 SessionSocket（接收侧容器）

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:343-409`：

| 成员 | 取值 / 语义 | 行号 |
|---|---|---|
| `scope` | `CoroutineScope(SupervisorJob() + Dispatchers.IO)`，子协程失败不连坐 | `:361` |
| `_messages` | `MutableSharedFlow(replay = 0, extraBufferCapacity = 64)`，`MutableSharedFlow$default(0, 64, null, 5, null)` → `onBufferOverflow = SUSPEND`（默认）；**无 replay**，即没订阅者时事件直接丢 | `:362`、`:367` |
| `_failures` | `MutableSharedFlow(replay = 1, extraBufferCapacity = 1)` → **回放最后 1 个异常** | `:364`、`:368` |
| `isOpen` | `@Volatile boolean`，构造时 true，`close()` 先置 false | `:366`、`:392-393` |
| `start()` | `scope.launch { 收包循环 }`，句柄存 `receiveJob` | `:387-389` |
| `close()` | `isOpen = false` → cancel `receiveJob` → cancel `scope` → `runCatching { socket.close() }` | `:391-408` |

### 4.4 帧到底有没有分隔符：**没有。`DelimitedFrameDecoder` 是死代码**

生产 decoder 链（自下而上逐跳，全链路可静态确定）：

1. `M3DeviceAdapter` 的 `frameDecoderFactory` 默认 = `M3FrameDecoderKt::createDefaultM3FrameDecoder`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:103` 的 `i & 32` 分支取 `C18941.INSTANCE`；`C18941` 的 `FunctionReferenceImpl` 签名与 `invoke()` 见 `:110-121`）。
2. `createDefaultM3FrameDecoder()` 返回 `new LegacyReadChunkFrameDecoder()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3FrameDecoderKt.java:10-12`）。
3. `LegacyReadChunkFrameDecoder.decode(bytes)` = 「空数组 → 空列表；否则 **整段原样当一帧**」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/LegacyReadChunkFrameDecoder.java:18-21`），`reset()` 是空实现（`:13-15`）。

`DelimitedFrameDecoder` **从未被实例化**：
`grep -rn "DelimitedFrameDecoder" _work/tuwin_src/sources/com/tuwinsmart` 全量命中仅 3 行，全在声明文件自身——`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DelimitedFrameDecoder.java:15`（类声明）、`:20`（主构造器）、`:30`（合成构造器）。**没有 `new DelimitedFrameDecoder(`、没有方法引用、没有 `@Metadata` 外的间接引用**。
连带死代码：`M3FrameDecoderKt.indexOf(byte[], byte[])` 是 `private static`、唯一调用方就是 `DelimitedFrameDecoder.decode`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3FrameDecoderKt.java:14-15`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DelimitedFrameDecoder.java:41`）；`UnconfiguredFrameDecoder`（永远返回空列表）同样零引用——`grep -rn "UnconfiguredFrameDecoder"` 只命中其声明 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/UnconfiguredFrameDecoder.java:12`。

如果哪天有人启用 `DelimitedFrameDecoder`，它的参数与语义是（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DelimitedFrameDecoder.java:15-61`）：

| 项 | 值 | 行号 |
|---|---|---|
| 分隔符 | 构造参数 `byte[] delimiter`，**非空断言** `delimiter.length != 0`，否则 `IllegalArgumentException("Failed requirement.")`；仓库里没有任何分隔符字面值（既无 `\n` 也无 `\0`） | `:20-27` |
| `maxFrameBytes` 默认 | **65536** | `:31`（`(i3 & 2) != 0 ? 65536 : i`） |
| `ByteAccumulator.maxBytes` 默认 | **262144**，同名常量 `ByteAccumulator.DEFAULT_MAX_BYTES = 262144` | `:31`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/ByteAccumulator.java:14`、`:27-28` |
| 溢出行为 | 累积缓冲 `buffer.size + bytes.length > maxBytes` → `FrameTooLargeException("Socket frame buffer exceeds <maxBytes> bytes")`；未找到分隔符且 `snapshot.length > maxFrameBytes`、或分隔符位置 `> maxFrameBytes` → `FrameTooLargeException("Delimited frame exceeds <maxFrameBytes> bytes")`；`FrameTooLargeException extends IllegalStateException` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/ByteAccumulator.java:31-37`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DelimitedFrameDecoder.java:43-50`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/FrameTooLargeException.java:10-15` |
| 切帧方式 | 循环：`indexOf(snapshot, delimiter)` → 取 `[0, idx)` 为一帧 → 把 `[idx + delimiter.length, end)` 回灌缓冲（`clear()` + `append()`）→ 直到找不到分隔符。**分隔符本身被丢弃**，且没有长度前缀 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DelimitedFrameDecoder.java:37-55` |

**实际生效的字节上限只有一个**：单次 `read()` 最多取 4096 字节（`maxReadBytes`）。`ByteAccumulator` 的 262144 与 `maxFrameBytes` 65536 在默认配置下**永不参与**（因为唯一使用它们的是死代码路径）。

### 4.5 读循环本体：JADX 反编译失败，结构由调试元数据还原

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector$_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector$SessionSocket$start$1.java:49-82`——JADX 在 `RegionMakerVisitor` 抛 `JadxRuntimeException: Not found exit edge by exit block: B:27:0x0080`（`:49-51`），方法体被替换成 `throw new UnsupportedOperationException("Method not decompiled: …")`（`:81`），原方法 488 条指令单位（`:78`）。
可静态确定的部分：
- `@DebugMetadata` 的局部名表 `m2468n = {"$this$launch", "$this$launch", "input", "buffer", "decoder", "$this$launch", "$this$launch"}`、槽位表 `{"L$0","L$0","L$1","L$2","L$3","L$0","L$0"}`、行号 `{119, 124, 130, 133}`（`:15`）→ 循环体内有 `input`（`InputStream`）、`buffer`（`ByteArray(maxReadBytes)`）、`decoder`（`FrameDecoder`）三个局部，源码行 119/124/130/133 各挂一个可挂断点位置。
- 结合 `SessionSocket` 的字段（`socket`/`frameDecoder`/`maxReadBytes`/`_messages`/`_failures`/`isOpen`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:344-353`）与 `FrameDecoder.decode(byte[]): List<byte[]>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/FrameDecoder.java:10-14`）可确定形状：`while (isOpen) { read → decode → 对每帧做 JSON 解析 → _messages.emit(msg) }`，异常进 `_failures`。
- 无法静态确定的三点，**统一标记为静态无解**：(a) `read()` 返回 `-1` / `0` 时是 break、 continue 还是抛；(b) 是否 `buffer.copyOfRead(n)` 截断（若截断则每帧前缀干净，若不截断则 4096 定长缓冲的尾垃圾会进 JSON 解析——但 `M3JsonMessageDecoder` 会 trim 并 catch 一切异常，见 §4.6，所以两种写法行为差别只在偶发丢事件）；(c) `decoder.reset()` 在退出/异常时是否被调。补法：对 `classes2.dex` 里 `Lcom/tuwinsmart/tuwin/core/device/m3/DefaultM3SocketConnector$SessionSocket$start$1;->invokeSuspend` 跑 baksmali 或 `jadx --show-bad-code`。

### 4.6 帧 → 消息：JSON 结构与 `msgid` 全表

解码器 `M3JsonMessageDecoder implements JsonMessageDecoder<M3SocketMessage>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3JsonMessageDecoder.java:21-28`；接口 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/JsonMessageDecoder.java:11-13`）。
逐帧处理顺序（`:33-37`）：`new String(frame, UTF_8)` → `trim()` → **空串直接 `return null`（该帧被丢掉，不产生消息、不算错误）** → `JsonParser.parseString(...).getAsJsonObject()`。

字段读取规则：
- `msgid`：必须是 JSON 原始类型才取（`isJsonPrimitive` 判定），否则按缺省 `""`（`:42-58`）→ 落到 `Unknown`。
- `info`：必须是 JSON 对象才取，否则 null（`:59-68`）；null 时所有子字段按缺省值取（见下表的 `decode$lambda$8$intValue`）。
- 顶层时间戳字段：键名在反编译里被折叠成 `DeepLinkPresetEvent.UMEventParamTime`（`:75` 等 7 处）。**静态无解**：`_work/tuwin_src/sources/com/umeng/commonsdk/deeplink/` 目录里只有 `UMCommonDeepLink.java` 与 `C3208a`~`C3214g`，没有 `DeepLinkPresetEvent`，`_work/re/tuwin/classes-all.tsv` 也检索不到该类，故字面量不可证；按 Umeng 埋点惯例疑为 `"time"`（标记为推断）。取法 `getAsLong()`，缺失/非原始类型/异常都归 `0L`（`:168-191`）。
- 整对象：`info` 里的整型缺省为 0，**唯一例外是 `sd.status` 缺省 99**（`:89` 调的是不带 `$default` 的 `decode$lambda$8$intValue(jsonObject, this, "status", 99)`）。
- 解析期任何异常（含非 JSON、缺 `msgid`、`getAsJsonObject` 失败）→ `catch (Throwable)` → **返回 `Unknown(原始串)`，不抛**（`:125-131`）。

`msgid` → 消息类型全表（`switch` 的 7 个 hash 分支，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3JsonMessageDecoder.java:70-123`）：

| `msgid` 字面值 | 类 | 取的字段 | 语义化后 | 行号 |
|---|---|---|---|---|
| `"battery"` | `M3SocketMessage.BatteryUpdate` | `info.capacity`(Int,0)、`info.charge`(Int,0)、顶层 time | 电量 + 充电状态 | `:78-84` |
| `"rec"` | `RecordingUpdate` | `info.value`(Int,0) `== 1` → `isRecording: Boolean`、time | 录像中/停止 | `:106-112` |
| `"rec_time"` | `RecordingTimeUpdate` | `info.recConsumTime`(Int,0)、`info.recFileTime`(Int,0)、time | 本次已录时长 / 文件总时长 | `:71-77` |
| `"sd"` | `SDCardUpdate` | `info.status`(Int,**99**)、time | SD 卡状态码 | `:85-91` |
| `"cap"` | `CaptureUpdate` | `info.value`(Int,0)、time | 拍照/抓拍事件（`value == 0` 有专门语义，见 §4.7） | `:92-98` |
| `"mic"` | `MicUpdate` | `info.value`(Int,0) `== 1` → `isMicOn`、time | 麦克风开关 | `:99-105` |
| `"countdown_time"` | `CountdownTimeUpdate` | `info.value`(Int,0)、time | 倒计时秒数 | `:113-119` |
| 其它 / `msgid` 缺失 / 解析异常 | `Unknown(rawMessage: String)` | 保留 trim 后的原始串（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java:488-489`） | 不上抛、不产生状态 | `:73`、`:80`、`:87`、`:94`、`:101`、`:108`、`:115`、`:121`、`:130` |

消息基类与 8 个子类定义：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java:13`（`abstract class M3SocketMessage`），子类行号 `BatteryUpdate:23`、`RecordingUpdate:90`、`RecordingTimeUpdate:154`、`MicUpdate:232`、`SDCardUpdate:296`、`CaptureUpdate:360`、`CountdownTimeUpdate:424`、`Unknown:488`；字段见 §4.6 表（如 `RecordingTimeUpdate` = `recConsumTime:int` + `recFileTime:int` + `time:long`，`:155-157`）。

### 4.7 事件如何落到状态字段

1. `SessionSocket.messages` 的每条 `M3SocketMessage` → `DeviceAdapterEvent.ProtocolMessage(payload)`；`SessionSocket.failures` 的每个 `Throwable` → `DeviceAdapterEvent.ControlChannelFailed(throwable)`；两股流 `Flow.merge` 成一条。证据：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:753`（merge 的入口）、`:795-825`（第一个流 `map` 成 `ProtocolMessage`）、`:826-899`（第二个流 `map` 成 `ControlChannelFailed`，构造点 `:879`）。
2. `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionRepositoryFactory.java:316`、`:391-398`：只有 `payload instanceof M3SocketMessage` 才继续下发，否则静默丢弃。
3. 消费侧全在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java`，6 条 `filterIsInstance` 型 Flow：

| Flow | 订阅定义 | 过滤/解包点 | 落到 |
|---|---|---|---|
| `observeBatteryUpdates(): Flow<M3BatteryInfo>` | `:667` | `instanceof BatteryUpdate` `:723` → `getInfo()` `:798` | 电池信息对象（capacity/charge）整体转发 |
| `observeSDCardUpdates(): Flow<Integer>` | `:822` | `instanceof SDCardUpdate` `:878` → `Boxing.boxInt(getStatus())` `:953` | SD 状态码（缺省 99 会原样冒到 UI） |
| `observeRecordingUpdates(): Flow<Boolean>` | `:1283` | `instanceof RecordingUpdate` `:1339` → `Boxing.boxBoolean(isRecording())` `:1414` | 录像中布尔 |
| `observeCaptureUpdates(): Flow<Unit>` | `:1438` | `instanceof CaptureUpdate` `:1494`；`getValue() == 0` 才继续 `:1570` | 「抓拍完成」脉冲信号（`value != 0` 被忽略） |
| `observeRecordingTimeUpdates(): Flow<M3RecordingTimeUpdate>` | `:1669` | `instanceof RecordingTimeUpdate` `:1725` | 录像时长对（recConsumTime/recFileTime） |
| `observeCountdownTimeUpdates(): Flow<Integer>` | `:1825` | `instanceof CountdownTimeUpdate` | 倒计时 |

**`MicUpdate` 没有任何消费方**：`grep -rn "MicUpdate" _work/tuwin_src/sources/com/tuwinsmart` 只命中解码器构造点（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3JsonMessageDecoder.java:103`）与 `M3SocketMessage.java` 自身（`:232-287`），无 `instanceof M3SocketMessage.MicUpdate`。即麦克风事件被解析后被丢弃。
`Unknown` 同样没有任何消费方（`grep` 结果里无业务判断），所以**分隔符缺失导致 JSON 被拆断时，官方 App 的表现就是这条事件静默消失**（不会崩、不会提示）。

### 4.8 通道断开后的行为

- TCP 事件流被并入 adapter 事件流后，`ControlChannelFailed` 触发控制通道恢复；恢复结果里**强制声明三个能力**：`M3_HTTP_CONTROL`、`M3_MEDIA_ENDPOINT`、`M3_SOCKET_EVENTS`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:546`），能力名常量 `M3_HTTP_CONTROL_CAPABILITY = "M3_HTTP_CONTROL"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnectorKt.java:44`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionRecoveryController.java:42`）。
- 首次 open 时能力集是**按 socket 是否真的连上动态组装**的：`{M3_HTTP_CONTROL, M3_MEDIA_ENDPOINT}` + 条件加入 `M3_SOCKET_EVENTS`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:332-338`、`:404-409`）。JADX 在这里把条件渲染成了 `if (m3SessionSocket == null && m3SessionSocket.getIsOpen())`（`:327`）与两个都赋 `false` 的分支（`:399-403`），属反编译产物；按 `catch (Exception e3) → m3SessionSocket = null`（`:315-322`）的控制流，真实语义是 `socket != null && socket.isOpen`。
- **TCP 连接失败不影响会话可用**：`connect` 抛普通 `Exception` 时只 `closeSocketPreserving(socket, e)` 并把 socket 置 null，会话继续以「无事件推送」的形态打开（`:311-322`）；`CancellationException` 才原样上抛并 `closeSocketPreserving`（`:311-314`）。
- 会话复用判定要求能力集含 `M3_HTTP_CONTROL` 且 grant 端口集含 `80`、host 等于 `hostFor(M3)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnectorKt.java:249-256`）——**不要求 `M3_SOCKET_EVENTS`**，所以断过 TCP 的会话仍可被复用。

---

## 5. Ride3Pro 菜单 XML 协议

### 5.1 传输：两条读取路径，**活的是裸 socket，不是 HTTP**

| 路径 | 入口 | 实际发什么 | 证据 |
|---|---|---|---|
| A（Retrofit HTTP） | `Ride3ProApiService.getMenuXml()`，`@Streaming @GET("/api/menu/xml")` → `ResponseBody` | `GET http://<host>:80/api/menu/xml` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:37-39`；队列包装 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java:1239-1270` |
| B（会话级，**覆盖了 A**） | `Ride3ProSessionApiService.getMenuXml()` 不走 Retrofit，直接 `ride3ProRequestExecutor.getMenuXmlRaw(...)` | 裸 TCP + 手写请求 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:1498-1520` |

B 的下游链：`Ride3ProRequestExecutor.getMenuXmlRaw`（接口 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestExecutor.java:39`）→ `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProDeviceAdapterSession.java:741-750` → `Ride3ProSessionTransport.getMenuXmlRaw`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:373-496`）→ `readMenuXmlRaw(lease, grant)`。

`getMenuXmlRaw` 可静态确定的部分：
1. grant 优先取**操作级 MENU grant**（`routeState.getOperationGrants().get(HttpClientProfile.DEVICE_MENU)`，即 §2.4 表里前缀 `/api/menu/` 那张），取不到才退回 `controlGrant`（`:410-413`）。
2. `routeProvider.acquire(NetworkIntent.Device(sessionId, deviceType, …, grantId))` + `lease.withCancellation { readMenuXmlRaw(lease, grant) }`，`finally` 里 `lease.close()`（`:414-445`）。

`readMenuXmlRaw` **本体 JADX 反编译失败**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:516-544`，`JadxRuntimeException: Not found exit edge by exit block: B:35:0x014d`，方法体 517 指令单位）。可确定的只有骨架：
- 局部名表 `{"this", "grant", "socket", "cancellationHandle"}`（`:90` 的 `@DebugMetadata`），源码行 249 —— **确实新建了 `java.net.Socket`**（import 见 `:31-32`，`InetSocketAddress` 同）。
- 私有 `connectCancellable(Socket, host, port, …)` 用 `socket.connect(new InetSocketAddress(host, port), MENU_CONNECT_TIMEOUT_MILLIS)`，取消时 `socket.close()`（`:627-673`，连接调用 `:657`）。
- 四个菜单专用常量，**全部标了 `@Deprecated`**：`MENU_CONNECT_TIMEOUT_MILLIS = 5000`、`MENU_MAX_RESPONSE_BYTES = 524288`、`MENU_READ_BUFFER_SIZE = 8192`、`MENU_READ_TIMEOUT_MILLIS = 30000`（`:65-75`）。其中只有 `MENU_CONNECT_TIMEOUT_MILLIS` 出现在可反编译的代码里（`:657`）。
- 静态无解项：连的端口是不是 80、写出去的请求行是不是 `GET /api/menu/xml HTTP/1.1`、`MENU_MAX_RESPONSE_BYTES`/`MENU_READ_TIMEOUT_MILLIS`/`MENU_READ_BUFFER_SIZE` 是否真被使用（它们可能在未反编译的方法体内被引用，也可能随 `@Deprecated` 一起失去引用）。补法：baksmali `classes2.dex` 里 `Lcom/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport;->readMenuXmlRaw`，或 `jadx --show-bad-code`。

另一个关键结论：`Ride3ProRawMenuXmlResponseParser`（负责「从带垃圾前缀的响应里切出 XML + 判完整性」）**零调用点，是死代码**：
`grep -rn "Ride3ProRawMenuXmlResponseParser" _work/tuwin_src/sources/com/tuwinsmart` 只命中声明文件自身（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRawMenuXmlResponseParser.java:12`、`:15`、`:16`、`:18`）。
但它把「设备响应可能的样子」写得非常清楚，值得作为**设备行为**记录（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRawMenuXmlResponseParser.java:21-47`）：
- `isComplete(resp)` = `resp.contains("</Menu>", ignoreCase = true)`（`:21-24`）→ **根元素是 `<Menu>`，闭合标记是 `</Menu>`**。
- `extract(resp)`：`trimStart(resp, '\uFEFF', ' ', '\t', '\r', '\n')`（去 BOM 与空白）→ 在 `<?xml`、`<Menu`、`</Menu`（三者的 `indexOf`，忽略大小写；见 `:30` 的 `CollectionsKt.listOf` 与字面量表 `_work/re/tuwin/own-literals.tsv` 中该类持有的 `<?xml`/`<Menu`/`</Menu>`）里取**最小非负下标**，全部为 -1 → `IOException("Ride3Pro menu response does not contain XML")`；从该下标截取并 trim；若不含 `</Menu>` → `IOException("Ride3Pro menu XML is incomplete")`。
- 含义：设备会**在 XML 前面吐非 XML 内容**（BOM / 空白 / 前导字节），而且可能**截断返回**，所以历史上需要「先判完整再切头」。复现服务端时要么别吐前导垃圾，要么就照这个契约吐。

### 5.2 XML 结构与 `Ride3ProMenuXmlParser` 解析规则

解析器：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuXmlParser.java`（`object` 单例，`:24-25`，`private` 构造器 `:27-28`）。

**结构（节点名一律区分大小写，全部是子元素，代码完全不读任何 XML attribute）**：

```
<Menu>                                  ← 根；闭合标记 </Menu>（见 §5.1）
  <Category>                            ← 分区，可任意个
    <Name>分区名</Name>                 ← 用于 §5.3 的 section 归一化
    <Setting> 项，可任意个，可嵌在任意层级
      <Name>项名</Name>
      <ID>十六进制或十进制 id</ID>
      <Type>类型码</Type>
      <Default>默认值</Default>
      <Value>                           ← 选项，可任意个
        <Name>选项显示名</Name>
        <ID>选项值</ID>
      </Value>
    </Setting>
  </Category>
</Menu>
```

逐条规则：

| # | 规则 | 源码 |
|---|---|---|
| 1 | **禁 DTD**：`xml.contains("<!DOCTYPE", ignoreCase = true)` 为真直接 `IllegalStateException("WIFI_MENU.xml must not contain a document type declaration")`。⚠ 条件是 `if (!(!(contains)))` 形式的 JADX 渲染，按异常语义取「含 DOCTYPE 即抛」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuXmlParser.java:33-35` |
| 2 | 解析器：`DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xml)))` —— **默认配置，没有显式关 XXE**（因为第 1 条已把 DOCTYPE 挡在门外），也没有 namespace 感知 | `:36` |
| 3 | 取 `documentElement` 后 `normalize()`（合并相邻文本节点） | `:37-40` |
| 4 | 分区集合 = `getElementsByTagName("Category")`，**全文档搜索、不限深度、按文档顺序**；`item(i) == null` 的槽位整个跳过 | `:41-46`、`:47-48` |
| 5 | 每个 Category：`Name` 取子文本（null → `""`）；`Setting` 集合 = `childElements(category, "Setting")` | `:50-54`、`:86` |
| 6 | 每个 Setting：`Name`/`ID`/`Type` 各取子文本，**null 一律转 `""`**；`Default` **保留 null**（第三个 null 允许项） | `:58-64`、`:81` |
| 7 | 选项集合 = `childElements(setting, "Value")`，每项取 `Name`（null→`""`）与 `ID`（null→`""`）→ `Ride3ProMenuValue(name, id)` | `:65-80` |
| 8 | 装配：`Ride3ProMenuSetting(name, id, type, defaultValue, values, requestId = null)` —— **解析阶段 requestId 恒为 null**，由调用方后补（`:81` 传 `null, 32, null`，bit 32 = 第 6 参取默认） | `:81`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuSetting.java:108` |
| 9 | **没有任何字段是必填**：`Name`/`ID`/`Type` 缺失都得到 `""`，不会抛；空文档得到空列表（是否允许空由调用方判，见 §5.4） | `:50-64` |
| 10 | `parse` 声明抛 `SAXException` / `IOException`（XML 语法错、DOCTYPE 之外的解析失败都从这里冒出），`IllegalStateException` 用于 DOCTYPE | `:30` |

**`childElements` / `childText` 的实现细节（决定了「层级无关」这一条）**，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsRuntimeMapperKt.java:49-76`：
- `childElements(node, name)`：遍历 `childNodes`，`nodeType == 1`（ELEMENT_NODE）且 `nodeName` **精确相等**（`Intrinsics.areEqual`，区分大小写）才收；**并且对每个子节点递归再收一遍**（`:72`）→ 结果是「该节点下、任意深度、所有同名元素」，顺序 = 先直接命中、后递归展开（前序）。
- `childText(node, name)`：`childElements(node, name).firstOrNull()?.textContent?.trim()`（`:51-55`）→ 因为 `childElements` 的第一个元素就是直接子元素，所以**语义等价于「取第一个同名直接子元素的文本，trim」**；`Value/Name` 之类的深层节点只有在你直接对 `Value` 节点调用时才影响。
- 因此 `<Menu><Category><Name>` 和 `<Category><Group><Name>` 都会被当成 Category 的名字（层级不敏感）。

模型类（字段顺序即构造顺序）：
`Ride3ProMenuSection(name: String, settings: List<Ride3ProMenuSetting>)`（`_work/.../Ride3ProMenuSection.java:13-14`、`:61`）、`Ride3ProMenuSetting(name, id, type, defaultValue, values, requestId)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuSetting.java:14-19`、`:108`）、`Ride3ProMenuValue(name, id)`（`_work/.../Ride3ProMenuValue.java:12-13`、`:60`），均在 `com.tuwinsmart.tuwin.presentation.p010ui.device.settings` 包下。

### 5.3 `setparameter?id=` 的 id 是**怎么算出来的**（不是 XML 的 `<ID>`）

核心结论：**下发用的 `id` 不是 `<ID>` 节点的值**，而是由「分区名 + 项名」经归一化后查一张硬编码表得到的 `requestId`；`<ID>` 只在「回填值」和「兼容性判定」里当键用。

#### 归一化算法 `normalize(value)`

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:163-184`：

1. `null` → `""`（`:164-166`）。
2. `trim()`（Kotlin `String.trim()`，去 ≤ U+0020 的字符，`:167`）。
3. `toLowerCase(Locale.ROOT)`（**ROOT，不走设备区域**，土耳其语 I 之类不会翻车，`:168-171`）。
4. 逐字符过滤，**只保留 `Character.isLetterOrDigit(c)`**（`:173-181`）→ 空格、`_`、`-`、`/`、`.`、`:`、括号、中文等全被删掉；注意 `isLetterOrDigit` 对 CJK 为 true，所以中文名字是「保留汉字、删掉标点与空白」。
5. 结果拼回字符串（`:181-183`）。

即 `normalize("Loop Recording") == normalize("loop_recording") == normalize("LOOP\nrecording") == "looprecording"`。

#### 查表 `forSetting(sectionName, settingName)`

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:40-161`。`settingName` 是 `checkNotNullParameter`（null 直接抛），`sectionName` 可为 null（normalize 成 `""`）。
对 `normalize(setting)` 做 `hashCode()` switch，命中后再 `equals` 精校验，然后按 `normalize(section)` 的约束决定返回值。全部 16 个分支（case 常量值 = Java `String.hashCode`，已逐个用哈希反查核实，见本节末）：

| `normalize(Setting/Name)` | 对 `normalize(Category/Name)` 的要求 | 返回的 `requestId` | 行号 |
|---|---|---|---|
| `defaultsetting` | `""` **或** `system` | `factory_reset` | `:44-52` |
| `factoryreset` | **必须非空**（`length == 0` → null） | `factory_reset` | `:61-68` |
| `exposure` | `""` **或** `record` | `record_exposure` | `:53-60` |
| `recordexposure` | 无条件 | `record_exposure` | `:148-152` |
| `looprecording` | `""` **或** `record` | `record_loop_recording` | `:69-76` |
| `recordlooprecording` | 无条件 | `record_loop_recording` | `:114-118` |
| `resolution` | `""` **或** `record` | `record_resolution` | `:77-84` |
| `recordresolution` | 无条件 | `record_resolution` | `:93-97` |
| `wifiname` | `""` **或** `wifi` | `wifi_name` | `:85-92` |
| `ssid` | **必须非空** | `wifi_name` | `:106-113` |
| `wifipasswd` | `""` **或** `wifi` | `wifi_passwd` | `:132-139` |
| `password` | **必须非空** | `wifi_passwd` | `:140-147` |
| `frequency` | `""` **或** `system` | `system_frequency` | `:98-105` |
| `systemfrequency` | 无条件 | `system_frequency` | `:153-157` |
| `version` | `""` **或** `system` | `system_version` | `:119-126` |
| `systemversion` | 无条件 | `system_version` | `:127-131` |
| 其它任何值 / 上述分支的 section 约束不满足 | — | **`null`**（表示「没有协议 id」） | `:46-47`、`:158-159` |

**代码里能静态确定的全部 id 值**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:18-27` 的 9 个公开常量 + 1 个非 id 常量）：

| 常量 | 字面值（= 实际发到 `?id=` 的串） | 行号 |
|---|---|---|
| `ALL` | `"all"` | `:18` |
| `FACTORY_RESET` | `"factory_reset"` | `:19` |
| `RECORD_EXPOSURE` | `"record_exposure"` | `:21` |
| `RECORD_LOOP_RECORDING` | `"record_loop_recording"` | `:22` |
| `RECORD_RESOLUTION` | `"record_resolution"` | `:23` |
| `SYSTEM_FREQUENCY` | `"system_frequency"` | `:24` |
| `SYSTEM_VERSION` | `"system_version"` | `:25` |
| `WIFI_NAME` | `"wifi_name"` | `:26` |
| `WIFI_PASSWD` | `"wifi_passwd"` | `:27` |
| XML 侧的十六进制 id（不是 `?id=` 的取值，只用于兼容性比对） | `FACTORY_RESET_ID = "0x0000208"`、`WIFI_PASSWORD_ID = "0x0000301"` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsCompatibilityPolicy.java:17`、`:19` |

除这 9 个之外，`setparameter?id=` 不可能出现别的取值——表是封闭的（default 分支返回 null）。**静态无解的部分**：设备真实菜单里还有哪些 `Name` 能命中（例如 `record_*` 之外的第三/第四分区），这取决于 `WIFI_MENU.xml` 的内容，APK 里没有内置该文件；要补齐需要真机抓一次 `/api/menu/xml` 响应。

case 常量的反查（PowerShell 逐个算 Java `String.hashCode` 校验）：`resolution → -1600030548`、`version → 351608024`、`ssid → 3539835`、`wifi → 3649301`，与 `:78`（`C3059bv.f1801z`）、`:120`（`C3077cm.f1938n`）、`:107`（`DeviceWifiScanDialog.RESULT_SSID = "ssid"`，声明于 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog.java:43`）完全吻合；`:89`/`:136` 的 `NetworkUtil.NETWORK_TYPE_WIFI = "wifi"`（`_work/tuwin_src/sources/com/efs/sdk/base/core/util/NetworkUtil.java:18`）。所以前两个被 JADX 折叠成 umeng 字段的常量，还原值为 `"resolution"` 与 `"version"`（**由哈希反查确定，非猜测**）。

#### id 在运行时的三次使用点

| 使用点 | 逻辑 | 源码 |
|---|---|---|
| 菜单加载后补写 requestId | `Ride3ProMenuSetting.copy(requestId = forSetting(section.getName(), setting.getName()))`，逐 Category×Setting 双层循环 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:183-191`（copy 调用在 `:187`） |
| 写：`update(item, value)` | 先判 `isFormatSetting(item)`（`item.name` 忽略大小写等于 **`"Format"`** → 改打 `/api/system/formatsd`，**不带 id**，见 §6）；否则 `requestId = item.requestId ?: forSetting(null, item.name)`，仍为 null → `IllegalStateException("R6 setting does not have a protocol request ID: <name>")`；否则 `setParameter(requestId, value)`；响应 `!isSuccess()` → `IllegalStateException("R6 setting update failed: id=<requestId ?: name>, <errorMessage>")` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:239-259`（格式判定 `:239-246`、id 解析 `:248-251`、请求 `:254`）、错误 `:272-278`；`isFormatSetting` 定义 `:520-523` |
| 读：`loadParameterValues` | ① 先 `getParameter("all")` 一次拉全量，把返回的 `info` 当 `Map<String,Object>`，逐个 key 用「`requestId` 忽略大小写相等」**或** `parameterIdsEqual(key, setting.id)` 找归属，命中就以 **`setting.getId()` 为 map 键**存值；② 再对 `ride3ProSettingTypeCode(type) ∈ {1,4}` 的项**逐条** `getParameter(requestId)` 补读，`findParameterValue(info, requestId)` 找不到就退化成 `info` 本身（`info` 是 Map 时视为无值），仍非 null 才 `put(setting.getId(), v)`；失败只 `Timber.w("R6 GetParameter failed: id=%s, %s")`，**不抛** | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:292-452`（all 拉取 `:410`、归属匹配 `:419-441`、逐条补读 `:447-451` 与 `:360-392`、失败日志 `:357`/`:386`）；⚠ 该协程里 `if (!isSuccess()) {…} else { Timber.w("… failed …") }` 的分支是 JADX 渲染反了，按日志文案取正常语义（与 §1.5 差异点 3 同类） |
| 直接调用点（绕过表） | 恢复出厂：`setParameter$default(FACTORY_RESET, null, …)`，即 **`?id=factory_reset` 且完全不带 `value` 参数**（bit 2 → `value = null`）；改 WiFi 密码：`setParameter(WIFI_PASSWD, password)` → `?id=wifi_passwd&value=<pwd>`；Ride3Pro 独立入口：`Ride3ProWifiSettingsPolicy` 造 `Ride3ProWifiParameterRequest(WIFI_PASSWD, password)` 交给 `Ride3ProWifiSettingsAction.setParameter(request.id, request.value)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$factoryReset$2.java:55`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProDeviceRepositoryImpl$setWifiPassword$2.java:59`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProWifiSettingsPolicy.java:19`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProWifiSettingsAction.java:21` |

`parameterIdsEqual(left, right)`（id 相等判定，用于把设备回的 `<ID>` 和表里的 id 对上）：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClientKt.java:12-18`——`left` 为 null → false；否则「忽略大小写直接相等」**或**「两边按 `toFlexibleParameterId` 转 Long 后相等」。`toFlexibleParameterId` = trim → 以 `0x` 开头（忽略大小写）则按 16 进制解析（去掉 `0x`），否则按 10 进制解析，都不是 → null（`:20-28`）。
所以 `<ID>0x0000208</ID>` 与 `"520"`、`"0X208"` 判等；`Ride6SettingsCompatibilityPolicy.isFactoryReset/isWifiPassword` 就是同时看 `requestId`、`name`（`"Password"` 忽略大小写）和 `<ID>` 三路（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsCompatibilityPolicy.java:36-44`）。

### 5.4 `getparameter` 的响应字段

- 形状仍是 §2.1 的公共包：`{"result": Int, "info": …}`（`Ride3ProApiResponse`）。
- **`info` 的类型不作契约**：客户端先试 `info is Map`（Gson 反成 `LinkedTreeMap<String,Object>`）→ `toParameterMap()` 把每个 key `toString()`（key 为 null 的条目丢掉），value 原样保留（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:455-471`）。
- 三种可用回法，客户端都吃：
  1. `info = {"<id 或 <ID>>": <值>, …}` —— 按 key 匹配（`getParameter("all")` 期望这种）。
  2. `info = {"<被请求的那个 id>": <值>}` —— `findParameterValue(info, requestId)`（`:473-490`，用 `parameterIdsEqual`，所以 key 写 `0x0000208` 而请求 `factory_reset` 是**匹配不上**的：`parameterIdsEqual` 的数字退化只在两边都能转 Long 时成立）。
  3. `info = <标量>`（String/Number）—— 前两种都没有时，直接把 `info` 当值用（`:347-352`：`info is Map` 时置 null 表示无值）。
- 值的解释（`Ride3ProSettingsRuntimeMapper`）：
  - 先按 `setting.id` 从 map 取值：`findValueBySettingId` = `map.get(id)` → 命中即返回；否则 `toFlexibleLong(id)` 并遍历，key 忽略大小写相等 **或** key 的数字值相等（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsRuntimeMapper.java:110-135`）。
  - 取不到值时回落 `<Default>`，再取不到用 `""`（`:43-45`）。
  - `Type` 语义（`ride3ProSettingTypeCode` 把 `<Type>` 文本按 `0x…`/十进制转 Integer，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsRuntimeMapperKt.java:17-35`）：

| `Type` | 语义 | 显示值取法 | 行号 |
|---|---|---|---|
| `0`、`3` | 枚举选择型 | 用当前值在 `values` 里找 `Value/ID` 数字相等的项，显示其 `Value/Name`；找不到退回按 `<Default>` 找；再找不到显示 `value.toString()`，最后 `""` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsRuntimeMapper.java:58-69`、`:96-108` |
| `2` | 只读文本/数值 | `value.toString()`，null 退 `<Default>` | `:70-77` |
| `1`、`4` | **动作型按钮**（不显示值，显示传入的 `actionLabel`）；也正是 §5.3 里被逐条 `getParameter` 补读的两种 | `actionLabel`（`toDisplaySections` 的第 3 参） | `:79-84`、逐条补读条件 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:449` |
| 其它 / `<Type>` 缺失（转不出 Integer） | — | 兜底：`value.toString()` → `<Default>` → `""` | `:85-93` |
- 空菜单判据：`load()` 里解析出的 `List<Ride3ProMenuSection>` 为空 → `IllegalStateException("R6 WIFI_MENU.xml does not contain any categories")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:193-195`）→ **文件在设备上就叫 `WIFI_MENU.xml`**（同 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuXmlParser.java:34` 的异常文案）。

### 5.5 复现要点

1. 服务端：菜单必须是一份根元素为 `<Menu>`、无 DOCTYPE、`Category/Setting/Value` 三层名字齐全（层级可乱但名字必须精确大小写）的 XML；`Name`/`ID`/`Type` 缺失不致命（转 `""`），但 `Type` 缺失会让该项退化成「显示原始值」的兜底分支。
2. 客户端：`setparameter?id=` 的取值域是那 9 个字符串，且要先做「trim → ROOT 小写 → 只留字母数字」的名称归一化再查表；命中不了就**不应发** `setparameter`（官方行为是抛 `IllegalStateException`）。
3. `Format` 这一项是**名字特判**（不看 id）改打 `/api/system/formatsd`，因此带 60 秒超时（§6）。
4. `factory_reset` 的请求形态是 `?id=factory_reset`，**没有 `value=`**，复现时不要补空值参数。

---

## 6. 请求队列与串行化

Ride3Pro/Ride6 的串行化是**三层**的，三层各自独立、互相之间没有共享状态；引用最频繁的那个类（`Ride3ProHttpRequestQueue`）其实只管第三条路。

| 层 | 实现 | 覆盖哪条路 | 串行强度 |
|---|---|---|---|
| L1 会话调度器 | `Ride3ProRequestScheduler`（优先级队列 + 单 worker 协程） | 会话内所有设备请求（`Ride3ProSessionTransport` / `Ride3ProSessionApiService` / 轮询通道） | **同时只有 1 个在途** |
| L2 Mutex 队列 | `Ride3ProHttpRequestQueue`（`kotlinx.coroutines.sync.Mutex`） | `QueuedRide3ProApiService`（无会话 executor 时的兜底 Retrofit 包装） | **同时只有 1 个在途** |
| L3 OkHttp 调度器 | `Ride3ProHttpSerialDispatcher`（单线程 + `maxRequests=1`） | 只给 Glide 缩略图/原文件加载用 | **同时只有 1 个在途** |

### 6.1 L1：`Ride3ProRequestScheduler`（真正的主队列）

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler.java`（713 行）。

字段（`:44-54`）：`activeJob`、`activePending`、`volatile boolean closed`、`Object lock`、`PriorityQueue<Pending> queue`、`volatile long routeRevision`、`CoroutineScope schedulerScope`、`AtomicLong sequence`、`String sessionId`、`Channel<Unit> wakeup`、`Job worker`。

**容量：无上限。** `queue` 是 `new PriorityQueue<>(comparator)`（`:167-172`），未传 initialCapacity、未设界；`Pending` 持有 `CompletableDeferred`（`:190`、`:284-286`）。唯一可观测的排队长度是 `pendingRequestCount()` = `queue.size()`（`:415-421`）。**没有「队列满则拒绝」的分支**——拒绝只来自关闭态和 revision 过期（见 §6.1.3）。

worker：构造器里 `schedulerScope = parentScope + SupervisorJob(...)`，并 `launch { worker() }`（`:174-177`；默认 parentScope = `CoroutineScope(SupervisorJob() + Dispatchers.IO)`，`:180-182`）。`wakeup = Channel(Unit)` 默认 **RENDEZVOUS**（`ChannelKt.Channel$default(-1, null, null, 6, null)`，`:173`）。`runWorker`（`:462-468`，`JadxOverflowException: Regions stack size limit reached`，517 指令单位）与 `nextPending`（`:700`，反编译失败）**方法体静态不可读**；`nextPending` 的 smali 残片可读（`:660-699`），可确定其行为是：持 `lock` 时优先 `queue.poll()`，队空且 `!closed` 则 `wakeup.receiveCatching()` 挂起等待，被 `trySend(Unit)`（`:339`、`:388`）唤醒，通道关闭则结束。

**是否单线程串行：是。** 判据：① 只有一个 `worker` Job（`:54`、`:177`）；② 队列里一次只取出一个 `Pending` 并赋给 `activePending`/`activeJob`（`:44-45`、`hasActiveRequest()` 只检查一个 `activeJob`，`:423-433`）；③ `submit` 只是入队 + `await`（`:329-353`）。

出队顺序（comparator，`:149-165`）：
1. `EXCLUSIVE` 优先于其它一切（一方是 EXCLUSIVE、另一方不是 → EXCLUSIVE 排前；两边都是 EXCLUSIVE 才继续往下比）。
2. 否则 `Intrinsics.compare(p2.priority.rank, p1.priority.rank)` → **rank 大的排前**。
3. rank 相同 → `Intrinsics.compare(p1.sequence, p2.sequence)` → **先来先到**。

`Ride3ProRequestPriority` 的 rank（`_work/.../Ride3ProRequestPriority.java:11-16`）：`CRITICAL=5`、`HIGH=4`、`NORMAL=3`、`LOW=2`、`EXCLUSIVE=1`。
注意这个反直觉的点：**`EXCLUSIVE` 的 rank 最小（1），它靠 comparator 的第 1 条特判插队，而不是靠 rank**。观测到的用法：`EXCLUSIVE` 用在「独占型长操作」——固件上传（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:1646`，profile `DEVICE_UPLOAD`）、OTA 长操作（`:1080`，profile `DEVICE_LONG_OPERATION`）、恢复出厂/重启等 `control(EXCLUSIVE, …)`（`:598`、`:1178`、`:1281`、`:1334`、`:1641`）；`LOW` 用在缩略图（`:1445`，`DEVICE_IMAGE`）与菜单 XML 读取（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:378`，`DEVICE_MENU`）。

#### 6.1.1 `submit` 的完整语义

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler.java:296-353`：
1. `result = CompletableDeferred()`（`:329`）。
2. `Pending(priority, sequence = this.sequence.incrementAndGet(), routeRevision, retryPolicy, block, result)`（`:330`）——序列号是**每个 scheduler 一份**（字段 `:51`），从 1 开始，跨会话不共享。
3. 持 `lock`：`ensureOpen()`；`if (this.routeRevision != 提交的 revision) throw superseded(...)`；`queue.add(pending)`（`:331-338`）。
4. `wakeup.trySend(Unit)`（`:339`）。
5. `result.await()`；`CancellationException` → `cancelPending(pending, e)` 后重抛（`:340-351`）。
6. `submit$default` 的默认 `retryPolicy = NO_RETRY`（`:355-360`）。

#### 6.1.2 重试：`executeWithRetry`

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler.java:470-620`（JADX 退化成 smali 风格 dump，但控制流可读）：
- `attempt` 初值 **1**（`:562-564` 的 `L4a: r12 = 1`）。
- 执行 `pending.getBlock()`（`:566-572`）；正常返回即完成。
- `catch (Throwable)` → `attempt >= retryPolicy.maxAttempts` 时 **`throw`（原样上抛，不包装）**（`:582-584`、`:602-603`）；否则 `attempt + 1`，且**仅当 `retryDelayMs > 0` 才 `DelayKt.delay(retryDelayMs)`**（`:585-598`），然后回到执行块（`:599-601`）。
- `catch (CancellationException)` 走独立出口（`:554`、`:559-561`、`:597` 的 `L97`），不参与重试。

`Ride3ProRetryPolicy`（`_work/.../Ride3ProRetryPolicy.java:10-100`）：`(idempotent: Boolean, maxAttempts: Int, retryDelayMs: Long)`，构造校验：`maxAttempts < 1` → `IllegalArgumentException("Failed requirement.")`；`retryDelayMs < 0` → 同上；**`!idempotent && maxAttempts != 1` → `IllegalArgumentException("Non-idempotent Ride3Pro operations cannot be retried")`**（`:75-83`）。
两个预置（`:17-18`，经合成构造器的 bit 掩码还原后）：
- `NO_RETRY = (idempotent = false, maxAttempts = 1, retryDelayMs = 0)` —— `new Ride3ProRetryPolicy(false, 0, 0, 6, null)` 的 bit `6` 让第 2/3 参被默认值 `1`/`0L` 顶替（`:86-88`）。
- `IDEMPOTENT_ONCE = (idempotent = true, maxAttempts = 1, retryDelayMs = 0)`。

**结论（重要，且反直觉）**：两个预置的 `maxAttempts` **都是 1**，而 `executeWithRetry` 的判据是 `attempt(=1) >= maxAttempts` → **官方 App 在调度器层一次都不重试**；`IDEMPOTENT_ONCE` 这个名字具有误导性，它相对 `NO_RETRY` 的实际差别只有 `idempotent` 标志位。全仓 `new Ride3ProRetryPolicy(` 只出现在这两个静态字段的初始化里（`:17-18`），没有任何调用方构造 `maxAttempts > 1` 的策略 → 「带延时的重试」是写好但没用上的能力。补法（若要确认）：baksmali `Ride3ProRequestScheduler.executeWithRetry` 的跳转表。

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java:424` 与 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProDeviceAdapterSession.java:294/323/596`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:1707` 用的都是 `IDEMPOTENT_ONCE`（=单次），其余 `NO_RETRY`。

#### 6.1.3 并发被拒 / 请求被撤销的逐条证据

| 触发 | 抛出 | 源码 |
|---|---|---|
| scheduler 已关闭还提交 | `IllegalStateException("Ride3Pro session scheduler is closed: <sessionId>")` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler.java:703-708`，由 `submit` 的 `ensureOpen()`（`:332`）触发 |
| 提交的 revision 与当前 `routeRevision` 不等（路由已换代） | `RouteSupersededException("Ride3Pro session <id> request revision <r> is stale; current revision=<cur>")` | `:333-334`、`:710-712` |
| `invalidate(newRevision, reason)`（默认 reason = `"route revision changed"`） | 更新 `routeRevision`，**把队列整个清空**并给每个 `Pending.result` 注 `RouteSupersededException("Ride3Pro session <id> <reason>: <old>-><new>")`，再 `activeJob.cancel(同一个异常)`，最后 `wakeup.trySend` | `:362-389`；调用方 `Ride3ProSessionTransport.invalidate(routeRevision)` → `:504-505` |
| `close()` | `Ride3ProSchedulerClosedException("Ride3Pro session scheduler closed: <sessionId>")`；幂等（已 closed 直接 return）；清队 + cancel active + `wakeup.close()` + `cancel(schedulerScope)` | `:391-413`；调用方 `Ride3ProSessionTransport.close()` → `:508-510` |
| executor 被要求「独占执行」 | `executeExclusive` = `submit(EXCLUSIVE, revision, NO_RETRY, block)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:499-501` |

### 6.2 L2：`Ride3ProHttpRequestQueue`（Mutex，无容量概念）

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueue.java:28-236`：

| 项 | 值 | 行号 |
|---|---|---|
| 互斥体 | `Mutex(locked = false)`（`MutexKt.Mutex$default(false, 1, null)`）——**kotlinx 非公平锁**（挂起等待，无容量上限） | `:29` |
| 在途集合 | `LinkedHashSet<Job> requestJobs` + `Object requestJobsLock` 做 `synchronized` | `:30-31` |
| `execute(block)` | ① 从上下文取 `Job`，**取不到就 `IllegalArgumentException("Ride3Pro HTTP request must run in a coroutine Job")`**；② 登记 job；③ `mutex.lock()`；④ `block.invoke(this)`；⑤ `mutex.unlock()`；⑥ 摘除 job（成功与异常路径都是这个顺序，异常路径 unlock 在 `catch (Throwable)` 里，`:203-209`） | `:74-223`（Job 校验 `:101-104`，lock `:117`，执行 `:126`，unlock `:135`/`:197`） |
| `clear()` | 快照 `requestJobs` → 清空 → 逐个 `job.cancel(CancellationException("Ride3Pro HTTP request queue cleared"))` | `:225-235` |
| 使用者 | `QueuedRide3ProApiService(delegate, requestQueue)` 的每个方法都走 `queue.execute { … }`（源文件 `Ride3ProHttpRequestQueue.kt`，行号 209/214/217… 见各 `@DebugMetadata`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java:26-28`、`:37-147` |

L2 与 L1 的区别：L2 不排队（Mutex 的等待顺序不保证 FIFO 优先级）、不记 revision、不重试，纯粹「一次只放一个 HTTP 调用过去」。

### 6.3 L3：`Ride3ProHttpSerialDispatcher`（进程级单线程 + Glide 用）

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpSerialDispatcher.java:14-44`：

- `sharedExecutor = NonClosingExecutorService(Executors.newSingleThreadExecutor(threadFactory))`（`:21-30`）——**`newDispatcher()` 每次造的 Dispatcher 共用同一个线程**，所以 Glide 的多个 client 之间也是串行的。
- 线程名 `"Ride3ProHttpSerial"`，`setDaemon(true)`（`:33-37`）。
- `newDispatcher()`：`new Dispatcher(sharedExecutor)` + `setMaxRequests(1)` + `setMaxRequestsPerHost(1)`（`:39-43`）。
- `NonClosingExecutorService`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/NonClosingExecutorService.java`，同文件 `Ride3ProHttpRequestQueue.kt`）包装的目的是：**OkHttp client 被 GC/关闭时不许把这个共享线程池 shutdown**。
- 调用点只有两处，都在图片面：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/glide/AuthorizedDeviceResourceLoader.java:270-272`（serial dispatcher + `Ride3ProThumbnailRetryInterceptor(500L 默认)` + requestId 拦截器）与 `_work/.../tuwin/core/glide/GlideNetworkModule.java:124-131`。
- **设备 Retrofit client 不用它**：`RoutedOkHttpProvider.client(...)` 的 builder 里没有 `dispatcher(...)` 调用（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:96-105` 全量可见），设备侧的串行性完全由 L1 保证。

`GlideNetworkModule$DynamicNetworkCallFactory`（`_work/.../tuwin/core/glide/GlideNetworkModule.java:105-135`）的二选一策略：
- `Ride3ProGlideThumbnailPolicy.shouldSerialize(url)` 为真（**`encodedPath == "/api/playback/thumbnail"` 精确相等**；两个重载 `HttpUrl`/`String(URI.getPath)`，`_work/.../ride3pro/Ride3ProGlideThumbnailPolicy.java:18-26`）→ 用 L3 serial dispatcher，超时 `ride3ProTimeoutSeconds = 5L` 秒（connect/read/write 三件，`:114`、`:128`），并加 requestId + 文件日志拦截器（`:130-131`）。
- 否则 → 用普通 dispatcher（`maxRequests = 16`、`maxRequestsPerHost = 2`，`:110-112`），超时 **8 秒**（`:128` 的 else 分支）。
- 两条都挂 `RejectingSocketFactory.INSTANCE`（`:133`，同文件 `:140` 起的内部类：非设备网络时拒绝建 socket）。
- 连接池：`ConnectionPool(5, 5, TimeUnit.MINUTES)`（`:105`）。

### 6.4 每个 interceptor 做了什么

OkHttp **application 链**的顺序（`Ride3ProSessionTransport.createService` 的 configure lambda，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:561-568`，按 add 顺序执行）：

| # | 拦截器 | 行为 | 源码 |
|---|---|---|---|
| 1 | `Ride3ProRequestIdInterceptor` | `request.newBuilder().header("X-Request-Id", String.valueOf(nextRequestId()))` → `chain.proceed(newRequest)`。**无条件注入**（不看路径），用 `header()` 不是 `addHeader()` → 已有同名头会被覆盖 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProRequestIdInterceptor.java:47-51`；挂载点 `Ride3ProHttpRequestQueueKt.addRide3ProRequestIdInterceptor` 的 `builder.addInterceptor(new Ride3ProRequestIdInterceptor(null, 1, …))`（`_work/.../Ride3ProHttpRequestQueueKt.java:22-25`） |
| 2 | `Ride3ProFormatTimeoutInterceptor` | `if (request.url().encodedPath() != "/api/system/formatsd") → proceed`；否则 `chain.withConnectTimeout(60, SECONDS).withReadTimeout(60, SECONDS).withWriteTimeout(60, SECONDS).proceed(request)` | `_work/.../Ride3ProFormatTimeoutInterceptor.java:14-21`（判定 `:17`，改写 `:20`） |
| 3 | `Ride3ProHttpFileLoggingInterceptor` | 先断言 `request.header("X-Request-Id") != null`，否则 **`IllegalStateException("Ride3Pro request is missing X-Request-Id")`**；再委托 `DiagnosticHttpLoggingInterceptor("ride3pro")` 落诊断日志文件 | `_work/.../Ride3ProHttpFileLoggingInterceptor.java:13-23`（断言 `:19-21`） |
| 4 | `fullHttpLoggingInterceptor("ride3pro_api")` | 明文 HTTP 日志（tag 与 #3 不同） | 挂载 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:566` |
| 5 | `endpointInterceptor(grant, revision, requestedPurpose)` | `endpointAuthority.authorizeUrl(grantId, sessionId, revision, requestedPurpose, url)` 后再 `proceed`；不通过则抛 `EndpointNotAuthorizedException`（§1.5） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:585-595`（授权调用 `:591`） |

`Ride3ProThumbnailRetryInterceptor`（只挂在 Glide 侧，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/glide/AuthorizedDeviceResourceLoader.java:271`）：
`_work/.../Ride3ProThumbnailRetryInterceptor.java:18-88`：
- 仅当 `request.method == "GET"` **且** `Ride3ProGlideThumbnailPolicy.shouldSerialize(url)`（即 `/api/playback/thumbnail`）才进入重试逻辑，否则直接 `proceed`（`:58-60`）。
- 首次 `proceed`；`catch (IOException)`：若 `chain.call().isCanceled()` 或 **异常因果链里没有 `EOFException`** → 原样抛（`:63-66`、`hasEofCause` 遍历 `cause` 链 `:80-87`）。
- 否则 `waitBeforeRetry(retryDelayMillis)`（默认实现是 **`Thread.sleep(500)`**，即阻塞式；`:41-51`），再查一次取消，然后 **只再 `proceed` 一次**（`:67-72`）；`InterruptedException` → 复位中断标志并抛原始 IOException（`:73-76`）。
- 常量 `RETRY_DELAY_MILLIS = 500`（`@Deprecated`，`:21-22`），实例默认 `retryDelayMillis = 500L`（`:41`）。
- 这是全 Ride3Pro 链路里**唯一真正会重发一次请求**的地方，且只针对缩略图的 EOF 半程断连。

### 6.5 requestId 的生成与「路径白名单」的真实状态

| 项 | 值 | 源码 |
|---|---|---|
| 头名 | `RIDE3_PRO_REQUEST_ID_HEADER = "X-Request-Id"`（public） | `_work/.../Ride3ProHttpRequestQueueKt.java:17` |
| 生成 | `private static final AtomicLong sequence = new AtomicLong(0)`；`next() = sequence.incrementAndGet()` → **首个值是 `1`**，进程级单调递增、全局共享（不按 session/host 分桶）、重启归零 | `_work/.../Ride3ProHttpRequestIds.java:11-19` |
| 默认注入器 | `Ride3ProRequestIdInterceptor` 的合成构造器把 `nextRequestId` 默认成 `Ride3ProHttpRequestIds::next`（方法引用 `C22831`） | `_work/.../Ride3ProRequestIdInterceptor.java:26-45` |
| 路径白名单 | `RIDE3_PRO_REQUEST_ID_PATHS = {"/api/playback/thumbnail", "/api/playback/rawdata"}`（private），唯一读者是 `Ride3ProRequestIdAttachmentPolicy.shouldAttachTo(HttpUrl/String)`（`_work/.../Ride3ProRequestIdAttachmentPolicy.java:18-29`），而 **`Ride3ProRequestIdAttachmentPolicy` 在全仓没有任何调用方**（`grep -rn "Ride3ProRequestIdAttachmentPolicy"` 除自身文件外零命中） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueueKt.java:14-19` |

→ 结论：**头是「每个请求都带」**，那个「只对 2 条路径附加 requestId」的策略类是死代码；复现时按「无条件带 `X-Request-Id: <单调整数>`」实现即可，但要注意 §6.4 #3 的断言——只要用了文件日志拦截器，漏加这个头就会在请求发出前直接抛异常。

### 6.6 format 类请求的超时具体值

| 阶段 | connect | read | write | 证据 |
|---|---|---|---|---|
| profile 基线（`formatsd` 走 `DEVICE_CONTROL`） | 5 s | 15 s | 15 s | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:78-79`（`case 5 → TimeoutSeconds(5, 15, 15)`）；单位 `TimeUnit.SECONDS` 见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:96` |
| 被 interceptor 改写（`/api/system/formatsd`） | **60 s** | **60 s** | **60 s** | `_work/.../Ride3ProFormatTimeoutInterceptor.java:20`；路径常量 `_work/.../Ride3ProHttpRequestQueueKt.java:14-15`（`RIDE3_PRO_FORMAT_SD_PATH`、`RIDE3_PRO_FORMAT_SD_TIMEOUT_SECONDS = 60`） |
| 生效范围 | 只有 `encodedPath` **逐字符等于** `/api/system/formatsd` 的请求；`/api/system/formatsd/`（带尾斜杠）不匹配 | 同左 | 同左 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProFormatTimeoutInterceptor.java:17` |

其它 profile 的基线（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:68-92`，全部单位 = 秒，顺序 connect/read/write）：
`INTERNET_API 10/30/30`、`INTERNET_DOWNLOAD 10/60/60`、`INTERNET_UPLOAD 10/120/120`、`DEVICE_PROBE 3/5/5`、`DEVICE_CONTROL 5/15/15`、`DEVICE_DIAGNOSTIC 5/5/5`、`DEVICE_LONG_OPERATION` 与 `DEVICE_UPLOAD` 共用 `10/120/120`、`DEVICE_FILE`/`DEVICE_MENU`/`DEVICE_IMAGE` 共用 `5/30/30`；未匹配的枚举 → `NoWhenBranchMatchedException`（`:89-90`）。

### 6.7 超时之后的行为（全链路）

1. OkHttp 超时 → `SocketTimeoutException`（`IOException`）从 `chain.proceed` 抛出；`retryOnConnectionFailure(false)` 在 client 上被设了两次（构建时与 `build()` 前），所以 OkHttp 自身的连接失败重试被关闭：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:96`、`:105`。
2. 调度器层：`executeWithRetry` 因 `attempt(1) >= maxAttempts(1)` **直接重抛**（§6.2.2）。
3. `submit` 的 `CompletableDeferred` 以该异常结束，调用方 `await()` 处抛出；`CancellationException` 例外（走 `cancelPending`）。
4. 再往上的包装因路径不同：预览/回放统一被 `Ride3ProConnectionException.fetchFailed("Failed to prepare Ride3Pro RTSP stream" / "…playback RTSP stream", e)` 包（§3.1）；探测被 `IllegalStateException("RIDE3PRO probe failed: …")` 包（§1.5）；M3 探测有独立重试（§3.3），**Ride3Pro 探测没有重试循环**。
5. 唯一「换一条超时继续重试」的语义出现在 Glide 缩略图（§6.4 末），且只针对 EOF。

### 6.8 静态无解清单（本节）

| 项 | 缺什么 | 补法 |
|---|---|---|
| `runWorker` / `nextPending` 的完整循环（EXCLUSIVE 是否真的「等到其它全部排空」才开始、`activePending` 何时置空、worker 处理完是否立即取下一个） | 两个方法均 JADX 反编译失败（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler.java:456-468`、`:700`） | baksmali `Lcom/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler;->runWorker` / `->nextPending` |
| `Ride3ProSessionTransport.readMenuXmlRaw` 的读循环与超时用法 | `:516-544` 反编译失败 | 同上（§5.1 同源问题） |

---

## 7. RTSP 端点

> 只写端点侧（URL 怎么拼、端口哪来、transport 怎么选）。播放器参数（VLC/ExoPlayer/FFmpeg 侧的 rtsp_tcp、buffer、timeout 等）在 `-附录-传输OTA与联网` 与 UI 附录，本节不重复。

### 7.1 端点模板与端口常量

| 机型 | URL 模板（原样拼接结果） | 端口 | 拼串代码 |
|---|---|---|---|
| Ride3Pro / Ride6 | `rtsp://<grant.host>:<grant 的唯一端口>/?action=stream` —— **路径段为空，query 直接挂在 `/?` 后**（不是 `/stream`、也不是 `/?action=stream` 前置路径） | `8080`（常量 `Ride3ProDeviceAdapterSession.RTSP_PREVIEW_PORT`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProDeviceAdapterSession.java:62`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/DocumentedRide3ProMediaEndpointResolver.java:26-31`（`resolve()` 不挂起，直接返回） |
| Ride5 | `rtsp://<grant.host>:<grant 的唯一端口>/livestream/1` —— **路径写死 `/livestream/1`**（`1` 是通道号字面量，代码里没有第二通道写法） | `554`（`Ride5DeviceAdapterSession.RTSP_LIVE_PORT`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java:57`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceMediaPort.java:105-110` |
| M3（预览） | `rtsp://<固定 host>:<port><rawPath>[?rawQuery][#rawFragment]`，host 强制换成控制 host | **设备给的**：`/app/getmediainfo` 的 `port` 或 rtsp URL 里的端口；URI 无端口时回落 `554`（`M3DynamicEndpointPolicy.RTSP_DEFAULT_PORT`，标 `@Deprecated`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java:20-21`、`:66`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3EndpointHostPolicy.java:29-100`（`rtsp://` 前缀在 `:74`） |
| M3（回放文件） | `rtsp://<grant.host>:<port>/<trim 后的 allowedPathPrefixes 唯一项>/<文件名>`，随后把 `"//"` 压成 `"/"` 一次 | grant 的唯一端口（= 媒体响应里 rtsp URL 的端口） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionRepositoryFactory.java:127-157`（拼接 `:151`、`"rtsp://"` 组装 `:156`） |

端口常量汇总（含 §1.3 已有项，此处只留 RTSP 相关）：

| 常量 | 值 | 单位/含义 | 源码 |
|---|---|---|---|
| `Ride3ProDeviceAdapterSession.RTSP_PREVIEW_PORT` | `8080` | Ride3Pro/Ride6 预览 RTSP 端口，同时是 profile 的 `allowedMediaPorts` 唯一元素（§1.4） | `_work/.../ride3pro/Ride3ProDeviceAdapterSession.java:62` |
| `Ride5DeviceAdapterSession.RTSP_LIVE_PORT` | `554` | Ride5 直播 RTSP 端口 | `_work/.../ride5/Ride5DeviceAdapterSession.java:57` |
| `Ride5DeviceAdapterSession.CALLBACK_PORT` | `9002` | Ride5 反向回调 **TCP**（不是 RTSP） | 同上 `:53`；grant 签发 `:250` |
| `M3DynamicEndpointPolicy.RTSP_DEFAULT_PORT` | `554` | M3 仅在 rtsp URI 不带端口时用；**已 `@Deprecated`** | `_work/.../p005m3/M3DynamicEndpointPolicy.java:20-21` |
| `M3ConnectionStrategy.M3_CONTROL_PORT` | `80` | M3 HTTP 控制端口（RTSP 端口与它无关，纯动态） | §1.3 |

媒体 grant 的签发（三机型各自的位置，全部 `purpose = MEDIA`、host = 控制 grant 的 host）：

| 机型 | 签发点 | 关键参数 |
|---|---|---|
| Ride3Pro / Ride6 | `DeviceEndpointAuthority.issue$default(..., DeviceEndpointProtocol.RTSP, controlGrant.getHost(), setOf(RTSP_PREVIEW_PORT), setOf("/"), MEDIA, **`EndpointGrantSource.PROFILE_BOOTSTRAP`**, …)`，3 处（会话打开的不同分支） | `_work/.../ride3pro/Ride3ProDeviceAdapterSession.java:382`、`:506`、`:656` |
| Ride5 | 同形态，端口 `{554}`、前缀 `{"/livestream"}`（`§2.4`） | `_work/.../ride5/Ride5DeviceAdapterSession.java:251` |
| M3 | `issueMediaGrant(session, revision, M3DynamicEndpoint)` → 端口 `{endpoint.port}`、前缀 `{endpoint.path}`、source **`DEVICE_MEDIA_RESPONSE`** | `_work/.../p005m3/M3DeviceAdapter.java:916-918`（endpoint 来自 `M3DynamicEndpointPolicy.parse`，`:78`） |

### 7.2 `RtspTransport` 的全部取值与选择逻辑

枚举定义：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/RtspTransport.java:11-14`，**3 个值且无参**：`AUTO`、`TCP`、`UDP`（编译产物里没有 rank/字段）。

唯一的结构性约束（不是选择逻辑，是校验）：`DeviceMediaEndpoint` 构造器要求 **`protocol == HTTP` 时 `transport` 必须是 `AUTO`**，否则抛（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/DeviceMediaEndpoint.java:130`，`if (protocol == MediaEndpointProtocol.HTTP && transport != RtspTransport.AUTO) throw`）。也就是说 HTTP 型媒体端点（如 Ride5 的文件下载端点，`_work/.../ride5/Ride5DeviceMediaPort.java:64` 传 `MediaEndpointProtocol.HTTP` + `AUTO`）不许带传输偏好。

`MediaSessionRequest` 的默认值：合成构造器 `(i & 64) != 0 → RtspTransport.AUTO`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/MediaSessionRequest.java:165`）——即「不显式传就是 AUTO」。

选择逻辑（端点侧能静态确定的全部规则，按调用点逐条）：

| 判定者 | 规则 | 源码 |
|---|---|---|
| 详情页预览 `DeviceDetailRtspTransportPolicy.forDevice(DeviceType)` | `RIDE6 → AUTO`；**其它（`RIDE5`/`RIDE3PRO`/`M3`）→ UDP**。`WhenMappings` 里只为 `RIDE6` 写了 case 1（`_work/.../device/detail/DeviceDetailRtspTransportPolicy.java:18-29`），所以「Ride3Pro 在详情页是 UDP」是这张表推导出来的，不是猜的 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailRtspTransportPolicy.java:34-40` |
| 回放页 `RidePlaybackRtspTransportPolicy.forDevice(DeviceType)` | 只接受 `RIDE3PRO`/`RIDE6` → `AUTO`；其它机型抛 `IllegalArgumentException("Ride RTSP playback does not support <deviceType.getCode>")` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/RidePlaybackRtspTransportPolicy.java:19-25` |
| Ride3Pro 端点解析器 | **硬编码 `AUTO`**（`DocumentedRide3ProMediaEndpointResolver.resolve` 的第 3 个返回值），随后被 `Ride3ProDeviceMediaPort` 原样塞进 `DeviceMediaEndpoint` | `_work/.../ride3pro/DocumentedRide3ProMediaEndpointResolver.java:31`、`_work/.../ride3pro/Ride3ProDeviceMediaPort.java:135` |
| Ride5 直播端点 | 硬编码 `AUTO` | `_work/.../ride5/Ride5DeviceMediaPort.java:110` |
| 首页卡片预览（Ride5） | 直接构造 `MediaSessionRequest(..., RtspTransport.UDP, ...)`，字面量实参 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListAdapter.java:998` |
| M3 实时预览 / M3 文件回放 | 均 `AUTO`（构造 `MediaSessionRequest` 时传字面量 `RtspTransport.AUTO`） | `_work/.../p010ui/device/detail/M3DeviceDetailActivity.java:2798`、`_work/.../p010ui/storage/p001m3/M3VideoPlayActivity.java:677` |
| Ride5 按小时回放 | `AUTO` | `_work/.../p010ui/album/ride5/Ride5HourlyPlaybackActivity.java:1702` |
| Ride5 回放控制器 | `if (rtspTransport != RtspTransport.AUTO) {…}` 的分支存在（对非 AUTO 做额外处理） | `_work/.../p010ui/album/Ride5HourlyPlaybackController.java:106` |

**要点：`/app/getmediainfo` 响应里的 `transport` 字段（String，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3MediaInfo.java:13-15`，三字段 `port`/`rtsp`/`transport`）被解析、被 §2.2 记录，但从未被转换成 `RtspTransport`。** 证据：`grep -rn "getTransport()" _work/tuwin_src/sources/com/tuwinsmart/tuwin/` 的全部命中里，`M3MediaInfo.getTransport()` 与 `M3ConnectionResult.getTransport()` 只有 getter 自身，没有任何读取方（`_work/.../dto/p007m3/M3MediaInfo.java:36`、`:82`、`_work/.../domain/model/M3ConnectionResult.java:59`）；M3 的两个 `MediaSessionRequest` 构造点传的都是字面量 `AUTO`。复现时不必把设备的 `transport` 建议接进播放器。

### 7.3 端点解析链上的失败分支（Ride3Pro / Ride5）

| 条件 | 抛出 | 源码 |
|---|---|---|
| Ride3Pro 媒体 grant 的 `allowedPorts` 不是恰好 1 个 | `RouteUnavailableException("RIDE3PRO media port is ambiguous")` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/DocumentedRide3ProMediaEndpointResolver.java:26-29` |
| Ride3Pro 会话的媒体 grant 缺失/协议不是 RTSP/purpose 不是 MEDIA/revision 不匹配 | `RouteSupersededException` / `RouteUnavailableException`（`Ride3ProDeviceMediaPort` 的 grant 校验块） | `_work/.../ride3pro/Ride3ProDeviceMediaPort.java:113` |
| Ride5 控制 grant 过期 | `RouteSupersededException("RIDE5 live preview control grant is stale")` | `_work/.../ride5/Ride5DeviceMediaPort.java:96` |
| Ride5 无媒体 grant | `RouteUnavailableException("RIDE5 live preview EndpointGrant is unavailable")` | `:99-100` |
| Ride5 grant 与会话/revision/协议不匹配 | `RouteSupersededException("RIDE5 live preview EndpointGrant is stale")` | `:102-103` |
| Ride5 端口不唯一 | `RouteUnavailableException("RIDE5 live preview port is ambiguous")` | `:105-108` |

### 7.4 M3 的动态授权端点怎么拼

M3 是唯一「RTSP 地址由设备给」的机型，链路有 4 跳：

1. **取候选**：`GET /app/getmediainfo` → `M3MediaInfo(rtsp: String, transport: String, port: int)`（§2.2 第 6 行；解析 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3MediaInfoResponse.java:80-96`）。
2. **规范化**：`M3DynamicEndpointPolicy.parse(controlHost, media)` → `M3DynamicEndpoints(media, socket)`，其中 media = `M3DynamicEndpoint(controlHost, URI(rtsp).port ?: 554, rawPath ?: "/")`（`_work/.../p005m3/M3DynamicEndpointPolicy.java:29-82`，装配点 `:78`；`rawPath` 为空白时归 `"/"`，`:70-77`）。**设备自报的 host 被丢弃**（两个端点都写 `controlHost`）。拒绝链 6 条见 §2.4 末尾。
3. **签发 grant**：`issueMediaGrant(...)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:916-918`），`protocol = RTSP`、`allowedPorts = {port}`、`allowedPathPrefixes = {path}`、`purpose = MEDIA`、`source = DEVICE_MEDIA_RESPONSE`。
4. **拼最终 URL 并授权**：
   - 回放文件走 `M3SessionRepositoryFactory.authorizedRtspUrl(sessionId, fileName)`（`_work/.../p005m3/M3SessionRepositoryFactory.java:127-157`）：
     `fileName` → `trim` + `removePrefix("/")`（`:142`）；空白或含 `".."` → `IllegalArgumentException("M3 media file path is invalid")`（`:144-145`）；`allowedPathPrefixes.singleOrNull()` 为 null → `RouteUnavailableException("M3 media grant path is ambiguous")`（`:147-150`）；拼 `"/" + prefix.trim('/') + "/" + fileName`，再 `replace("//", "/")`（`:151`，即 `//` → `/` 只替换一次）；`allowedPorts.singleOrNull()` 为 null → `RouteUnavailableException("M3 media grant port is ambiguous")`（`:152-155`）；最后 `authorizeRtspUrl(sessionId, "rtsp://" + grant.host + ":" + port + path)`（`:156`）。
     前置校验：无 route → `RouteUnavailableException("M3 session has no media route: <sessionId>")`（`:132-134`）；无 grant → `"…has no media grant: …"`（`:136-138`）；grant 的 sessionId/routeRevision 不匹配 → `IllegalArgumentException("M3 media grant does not match session route: <sessionId>@<revision>")`（`:139-141`）。
   - 同一文件的 `authorizeRtspUrl(sessionId, rawUrl)`（`:159-177`）先做一遍同样的 route/grant/port 校验，再 `M3EndpointHostPolicy.fixedRtspUrl(rawUrl, grant.host, declaredPort)` 定住 host，最后交给 `endpointAuthority.authorizeRtspUrl(grantId, sessionId, revision, MEDIA, 定住后的 URL, declaredPort)`。
   - 预览侧的 `M3EndpointHostPolicy.fixedRtspUrl` 的拼法（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3EndpointHostPolicy.java:29-100`）：`"rtsp://" + (含 `:` 的 host 重新包方括号，否则原样；trim + 去方括号见 `:66-73`) + ":" + 端口 + rawPath(空白→`/`) + 可选 `?rawQuery` + 可选 `#rawFragment`（`:74-96`）→ **query 与 fragment 会被原样保留**，这是 Ride3Pro 模板（`/?action=stream`）之外的第二条「设备可自带 query」通道。
5. **授权校验（跨机型共用）**：`DeviceEndpointAuthority.authorizeRtspUrl(grantId, sessionId, routeRevision, requestedPurpose, rawUrl, declaredPort)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceEndpointAuthority.java:160-235`），逐条：
   - grant 不是 RTSP 协议 / sessionId 不符 / routeRevision 不符 → `EndpointNotAuthorizedException("RTSP EndpointGrant does not match session or route revision")`（`:171-174`）
   - `requestedPurpose != grant.purpose` → `"RTSP purpose is outside EndpointGrant <id>"`（`:175-177`）
   - `URI(trim(rawUrl))` 解析失败（异常吞成 null） → `"Invalid RTSP endpoint URL"`（`:178-192`）
   - scheme 忽略大小写不是 `rtsp`、或带 userInfo、或 host 为 null/空白 → `"RTSP URL is not an authorized absolute endpoint"`（`:193-195`）
   - 端口不在 `1..65535` 且 `declaredPort` 也不在 → `"RTSP endpoint has no explicit authorized port"`（`:196-204`）
   - `grant.matchesSocket(host, port, purpose)` 为假 → `"RTSP host or port is outside EndpointGrant <id>"`（`:205-209`）
   - 路径（空白→`/`）必须命中 `allowedPathPrefixes` 之一：前缀补前导 `/`；前缀等于 `/` 时只要求路径以 `/` 开头；否则要求 `路径 == 前缀去尾斜杠` 或 `路径以「补了尾斜杠的前缀」开头`（`:210-235`）
   - 通过后返回 `AuthorizedRtspEndpoint(grantId, host, port, URI)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/AuthorizedRtspEndpoint.java:14-17`，4 字段）

Ride3Pro 的 `?action=stream` 之所以能过第 5 步：它的媒体 grant 前缀集是 `{"/"}`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProDeviceAdapterSession.java:382/506/656` 的第 7 参 `SetsKt.setOf("/")`），命中「前缀等于 `/`」这条宽松规则；**Ride5 的前缀是 `{"/livestream"}`**，所以 `/livestream/1` 走的是「补尾斜杠后 startsWith」这条。

### 7.5 静态无解项

| 项 | 现状 | 补法 |
|---|---|---|
| M3 实时预览最终交给播放器的那个 RTSP URL 的完整拼法 | `M3DeviceMediaPort.requestMediaEndpoint(...)` 反编译失败（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceMediaPort.java:100-111`，`ArgType.getObject()` 内部异常 + 575 指令单位）。仅能确定局部名 `{"this","lease","sessionId","snapshot","grant","repository","repository"}`（`:29`）→ 它取会话快照 + 媒体 grant + `M3SessionRepositoryFactory`，几乎必然是转调 §7.4 的 `authorizedRtspUrl`/`authorizeRtspUrl` 之一，但**无法确认是否附带文件名** | baksmali `Lcom/tuwinsmart/tuwin/core/device/m3/M3DeviceMediaPort;->requestMediaEndpoint` |
| 播放器拿到 URL 后是否再改写（例如追加 `?action=stream`） | 属播放器面，本文按题设不展开 | 见 `-附录-设置与操作` / 传输附录 |

---

## 8. 对既有文档的纠正

对照对象：`docs/03-品牌型号与协议矩阵.md` §1.2–§1.4（该文件现名，§1.2 起于第 52 行、§1.4 止于第 162 行）与 `docs/01-APK逆向分析报告.md` §1.3（起于第 69 行）。
下表「原说法」后括号里给的是该说法在既有文档里的行号，便于逐条回改。证据列一律 `_work/` 全路径。

### 8.1 对 `docs/03-品牌型号与协议矩阵.md` §1.2–§1.4

| 编号 | 原说法 | 证据（全路径:行号） | 应改为 |
|---|---|---|---|
| C-1 | §1.4「Ride3Pro/Ride6 端点」把 `鉴权 GET /api/authdevice?seed=`、`/api/rtspstatus?seed=` 并列成两条鉴权调用（第 128 行） | 全量检索 `getRtspStatus` 在 `_work/tuwin_src/sources/com/tuwinsmart` 只命中 5 处，均为声明/实现：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:58`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:688,703`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java:431,446`；后两处是 `implements Ride3ProApiService` 的 override，不是调用点 | 删掉「rtspstatus 是鉴权步骤」的定位：`/api/rtspstatus` **在官方 App 里没有任何业务调用点**（只被两个包装类实现着），实际起流前不发它；真正的握手只有 `authdevice` + `send-time` + `setmode` 三刀（本文 §3.2、§3.1） |
| C-2 | §1.4「UI 步骤名给出顺序：设备认证 → 切换预览模式 → rtspstatus → 连 RTSP」（第 156 行） | 预览链的实际顺序见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:239-267`、`:380-392`（auth → send-time → setmode）；UI 可用的步骤串只有 3 个：`ride3pro_preview_step_device_auth`、`ride3pro_preview_step_switch_mode`、`ride3pro_preview_step_sync_time`（`_work/re/tuwin/res-strings-default.md:729-731`），**不存在 rtspstatus 步骤** | 顺序改为「设备认证（authdevice）→ 同步设备时间（vendor/send-time）→ 切换预览模式（setmode?mode=0）→（启动录像，失败仅告警）→ 连 RTSP」，并删去 rtspstatus |
| C-3 | §1.4「握手缓存 `Ride3ProPreviewHandshakeCache` … 且 `consume()` **一次性**——每次起预览都要重新 authdevice」（第 156 行） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPreviewHandshakeCache.java:199-211`：`consume` 命中且未过期时 `return true` **不 remove**，只有过期分支（`:209`）才 `remove`；有效期常量 `VALIDITY_DURATION_MS = 600000`（`:18`），时钟是 `System.nanoTime()/1000000`（`:17`、`:242-243`） | 改为「`consume()` 是只读探测（peek）：同一 `(deviceIdentity, sessionId, routeRevision)` 在 **10 分钟**内可被反复命中，预览与回放各自都能复用同一次握手；过期时才删除」。复现成「一次性」会让每次起流都多打一次 auth+send-time |
| C-4 | §1.3 表格 M3 行「推送 socket 端口从 `info.sp` 取」（第 109 行） | TCP 端点端口来自 **`/app/getmediainfo` 的 `port`**：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java:59-62`（`media.getPort()` 校验 `1..65535`）、`:78`（`new M3DynamicEndpoint(controlHost, media.getPort(), "/")`）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:920-922`；`sp` 是 `getproductinfo` 的键（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ProductInfoResponse.java:103`），且 `getSp()` 在 `tuwin/` 里**零消费者**（`grep -rn "getSp()" _work/tuwin_src/sources/com/tuwinsmart/tuwin/` 只命中 DTO 自身 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3DeviceInfo.java:50`、`:100`） | 改为「推送 socket 端口 = `/app/getmediainfo` 响应的 `port`（无默认值，非法即整个 open 失败）；`getproductinfo` 的 `sp` 客户端解析了但没用」 |
| C-5 | §1.3 表格 RIDE5 行「媒体 socket 端口**未找到常量**」（第 110 行） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java:57` `RTSP_LIVE_PORT = 554`、`:53` `CALLBACK_PORT = 9002`；两处 grant 签发 `:250`（TCP/9002/CALLBACK）、`:251`（RTSP/554/MEDIA） | 补上两个常量：Ride5 直播 RTSP 端口常量 `554`、反向回调 TCP 端口常量 `9002`（`allowedMediaPorts` 为空是 profile 字段层面的事实，两者不矛盾，见本文 §7.1） |
| C-6 | §1.4「RTSP 预览」段「Ride5 = `rtsp://<host>/livestream/1`，**端口从设备属性 `RTSP_LIVE_PORT` 读**」（第 154 行） | `RTSP_LIVE_PORT` 是客户端 `companion object` 常量（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java:57`），用它签发媒体 grant（`:251`），再由 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceMediaPort.java:105-110` 从 grant 里 `singleOrNull(allowedPorts)` 取出拼 URL；Ride5 的设备属性 CGI 里没有任何端口字段 | 改为「端口来自客户端常量（554）→ 写进 `EndpointGrant` → 起流时从 grant 读；设备不参与协商」 |
| C-7 | §1.4 表格 RIDE3PRO/RIDE6 行「**命令必须串行**（`Ride3ProHttpRequestQueue` + `HttpSerialDispatcher`）」（第 124 行） | 会话内所有设备请求的排队由 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler.java`（`PriorityQueue<Pending>` `:48`、单 worker `:54`/`:177`、`submit` `:296-353`）负责；`Ride3ProHttpRequestQueue` 只是 `QueuedRide3ProApiService` 的 Mutex 兜底（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueue.java:29`、`_work/.../QueuedRide3ProApiService.java:26-28`）；而 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpSerialDispatcher.java:39-44` 全仓只有两个 Glide 调用点（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/glide/AuthorizedDeviceResourceLoader.java:270`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/glide/GlideNetworkModule.java:124`），设备 Retrofit client 根本没设 dispatcher（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:96-105` 内无 `dispatcher(`） | 改为「三层串行：L1 `Ride3ProRequestScheduler`（优先级队列 + 单 worker，主路径）→ L2 `Ride3ProHttpRequestQueue`（Mutex，无会话 executor 时的兜底）→ L3 `Ride3ProHttpSerialDispatcher`（单线程 `maxRequests=1`，仅 Glide 图片）。详见本文 §6.0–§6.3」 |
| C-8 | §1.4「推送报文…信封 = 顶层 `msgid`(string) + 顶层 `info`(object) + **顶层 `time`(long)**」（第 138 行） | 键名字面量被 JADX 折叠成 umeng 常量：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3JsonMessageDecoder.java:75`、`:82`、`:89`、`:96`、`:103`、`:110`、`:117` 的第三实参都是 `DeepLinkPresetEvent.UMEventParamTime`；该类不在反编译产物里（`_work/tuwin_src/sources/com/umeng/commonsdk/deeplink/` 只有 `UMCommonDeepLink.java` 与 a–g 六个类，`_work/re/tuwin/classes-all.tsv` 检索不到 `DeepLinkPresetEvent`），`_work/re/tuwin/own-literals.tsv` 里该类也只登记了 `msgid`、`info` 两个字面量 | 把 `time` 标注为**推断**（按 Umeng 埋点惯例疑为 `"time"`），或改写为「顶层第三个键的字面量静态不可证（需 baksmali 解 `Lcom/umeng/commonsdk/deeplink/DeepLinkPresetEvent;` 常量池）」。目前写法会让复现方以为已 CONFIRMED |
| C-9 | §1.4 报文表（第 140–149 行）只给了 `msgid → 字段` 映射 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3JsonMessageDecoder.java:33-37`：帧 `trim` 后长度为 0 → **`return null`**（该帧既不产消息也不报错）；`:125-131`：解析期任何 `Throwable` → `Unknown(原始串)` | 表格上方补两行边界：「空帧 → 直接丢弃」「非法/半截 JSON → `Unknown`，不上抛」。这解释了 §8.1-C-12 那种「一 read 一帧」实现下偶发丢事件为什么无声 |
| C-10 | §1.4 报文表把 `mic` 当成可用事件（第 147 行） | `grep -rn "MicUpdate" _work/tuwin_src/sources/com/tuwinsmart` 只命中构造点 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3JsonMessageDecoder.java:103` 与数据类 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java:232-287`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java` 的 6 个 observer（`:667`/`:822`/`:1283`/`:1438`/`:1669`/`:1825`）里没有它 | 标注「`mic` 被解码但**无消费方**，麦克风状态实际靠 HTTP」；同时补上第 6 个 observer 对应的 `Unknown` 亦无消费方 |
| C-11 | §1.4 M3 TCP 事实 3 的证据行号「`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:342-359` 只有读侧 Flow」（第 136 行） | `SessionSocket` 实际跨 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:343-409`；读侧-only 的硬证据是接口 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionSocket.java:12-18`（只有 `getFailures`/`getMessages`/`isOpen`/`close`）+ 设备层 `grep getOutputStream` 零命中（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java` 是唯一的同名出现处，与 socket 无关） | 行号改 `:343-409`，并把「无写路径」的证据换成 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionSocket.java:12-18` + 全 `core/device/`、`data/source/socket/` 目录 `getOutputStream` 零命中（本文 §4.1） |
| C-12 | §1.4 M3 TCP 事实 1「没有帧分隔符…`DelimitedFrameDecoder` 是死代码」（第 134 行） | 一致，可加强：活的 decoder 由 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:103`（默认实参）→ `:110-121`（方法引用）→ `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3FrameDecoderKt.java:10-12`（返回 `LegacyReadChunkFrameDecoder`）确定；`grep -rn "DelimitedFrameDecoder" _work/tuwin_src/sources/com/tuwinsmart` 仅命中声明文件 `:15`、`:20`、`:30` | 无需改结论；建议补两点数值：单次读上限是 `maxReadBytes = 4096`（`_work/.../DefaultM3SocketConnector.java:86`），以及 `UnconfiguredFrameDecoder` 同样是零引用死类（`_work/.../UnconfiguredFrameDecoder.java:12`） |

### 8.2 对 `docs/01-APK逆向分析报告.md` §1.3

| 编号 | 原说法 | 证据（全路径:行号） | 应改为 |
|---|---|---|---|
| D-1 | §1.3.2 标题「TCP Socket（`DefaultM3SocketConnector` + **`DelimitedFrameDecoder`**）」（第 91 行） | 同 C-12：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3FrameDecoderKt.java:10-12` + `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:103` | 类名改为 `LegacyReadChunkFrameDecoder`（工厂 `M3FrameDecoderKt.createDefaultM3FrameDecoder()`），并括注「`DelimitedFrameDecoder`/`UnconfiguredFrameDecoder` 均为死代码」 |
| D-2 | §1.3.2「**帧格式：分隔符定界（delimiter），单帧上限 64KB，缓冲上限 256KB**」（第 94 行） | 实际生效规则：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/LegacyReadChunkFrameDecoder.java:18-21`（非空 chunk 即整段一帧）+ `reset()` 空实现（`:13-15`）；64KB/256KB 只存在于未被实例化的 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DelimitedFrameDecoder.java:31`（默认 `maxFrameBytes=65536`、`accumulator maxBytes=262144`）与其 `:43-50` 的抛错分支 | 改为「**帧 = 一次 `read()` 拿到的字节块，没有分隔符、没有长度前缀；单次读缓冲 4096 字节；64KB/256KB 是死代码里的默认值，运行时不生效**。副作用：跨 read 的长 JSON 会被切成两帧，第二帧进 `Unknown`（`_work/.../M3JsonMessageDecoder.java:125-131`）」 |
| D-3 | §1.3.1「鉴权/设备：`GET /api/authdevice?seed={long}`、…、`GET /api/rtspstatus?seed={long}`」（第 81 行，与 C-1 同源） | 同 C-1 | 在 `rtspstatus` 后标「（声明但无调用点）」，不要计入鉴权链 |
| D-4 | §1.3.1 工程细节「`Ride3ProHttpRequestQueue` + `Ride3ProHttpSerialDispatcher`（串行队列，**相机不接受并发命令**）」（第 86 行） | 「同时只发一条」是客户端自设：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler.java:54`/`:177`（单 worker）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueue.java:29`（Mutex）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpSerialDispatcher.java:41-42`（`maxRequests=1`/`maxRequestsPerHost=1`）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:96`/`:105`（`retryOnConnectionFailure(false)`）。APK 里没有任何「设备返回并发错误」的证据（全仓无相关错误码常量或分支） | 把「相机不接受并发命令」降级为「**官方 App 单方面把所有设备命令串成 1 并发、且关掉 OkHttp 重试**，设备侧是否真的不接受并发静态不可证」 |
| D-5 | §1.3.1「`Ride3ProRequestIdInterceptor`（请求 ID 注入）、`Ride3ProFormatTimeoutInterceptor`（格式化长超时）」（第 86 行） | 头名 `X-Request-Id`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueueKt.java:17`）、值 = 进程级 `AtomicLong(0).incrementAndGet()`（`_work/.../Ride3ProHttpRequestIds.java:12`、`:17-18`）、**无条件加**（`_work/.../Ride3ProRequestIdInterceptor.java:47-51`）；那个「只对 thumbnail/rawdata 附加」的策略类 `Ride3ProRequestIdAttachmentPolicy` 零调用（`_work/.../Ride3ProRequestIdAttachmentPolicy.java:18-29` 是其唯一命中）；format 超时是 **60 秒 × connect/read/write**，把基线 `DEVICE_CONTROL = 5/15/15` 抬上去（`_work/.../Ride3ProFormatTimeoutInterceptor.java:17-20`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:78-79`） | 给两个拦截器补上具体数值与作用域（见本文 §6.4、§6.5、§6.6），避免「长超时」被实现成任意值 |
| D-6 | §1.3.2「`connect(network: Network, host, port, frameDecoder)` → `socket.connect(InetSocketAddress(host,port))`，绑定到指定 Android `Network`」（第 92 行） | 签名与绑定方式一致（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/DefaultM3SocketConnector.java:107`、`:138`、`:442`），但原句漏了超时参数与默认值：`socket.connect(addr, connectTimeoutMillis)`，`connectTimeoutMillis` 生产默认 **15000 ms**（`:85-87`，值取自 `_work/tuwin_src/sources/com/umeng/analytics/pro/C3065ca.java:20` 的同值常量 15000），`maxReadBytes` 默认 4096 | 补「带 15 秒连接超时；协程取消时 `invokeOnCancellation` 里 `socket.close()`（`:416-440`）；`connect` 跑在 `withContext(Dispatchers.IO)`（`:141-147`）」 |
| D-7 | §1.3.2「`SessionSocket` 暴露 `messages: Flow<M3SocketMessage>` + `failures: Flow<Throwable>`——相机实时事件推送通道（状态/录制变化等）」（第 93 行） | 成立，但两个 Flow 的缓冲语义需要写清：`messages` = `MutableSharedFlow(replay = 0, extraBufferCapacity = 64)`（`_work/.../DefaultM3SocketConnector.java:362`）→ **无订阅者时事件直接丢，不回放**；`failures` = `replay = 1, extraBufferCapacity = 1`（`:364`）→ 最后一个异常会被新订阅者收到 | 在句中补「`messages` 无 replay（错过即失），`failures` 回放最后 1 个异常」 |
| D-8 | §1.3 表格 M3 行「控制协议 = HTTP REST(`/app/`) **+ 原生 TCP Socket**」（第 76 行） | 成立，但方向性未写：该 socket 是**单向接收**，全链路无写路径（`_work/.../M3SessionSocket.java:12-18` + 设备层 `getOutputStream` 零命中），且连不上时不阻断会话（`_work/.../M3DeviceAdapter.java:311-322`） | 改为「+ 原生 TCP Socket（**只读事件通道**；连接失败只降级为“无事件推送”，不影响会话建立）」 |
| D-9 | §1.3 表格各行（型号标识 `R3Pro`/`R6`/任意/`v57_sport_cam_ezgui` 等、控制端口 80、路径前缀、探测端点、RTSP :8080 `/?action=stream`、`/livestream/1`、M3 动态授权端点）（第 71–76 行） | 见本文 §1.4（profile 全取值）、§2.1、§2.4、§7.1 | **无冲突**（本条为确认，不需改动） |

### 8.3 同一事实链在 `docs/01` §1.5 / §1.7 的重复出现（超出 §1.3 指派范围，但与上面同源，一并列）

| 编号 | 原说法 | 证据（全路径:行号） | 应改为 |
|---|---|---|---|
| E-1 | §1.5「鉴权握手（seed）：开流前 1. `seed = Random.nextLong(Long.MAX_VALUE)` 2. `GET /api/authdevice?seed=` → `GET /api/rtspstatus?seed=` 3. 成功后 `markReady(key)`」（第 122–125 行） | 第 2 步错（见 C-1/C-2），第 3 步的顺序也错：`markReady` 是在 **send-time 之后**、`setmode` 之前（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:317-321`），且 send-time 失败也照样 markReady（`:307-315` 只 `Timber.w`） | 改写为「authdevice（`result` 非 0 且非 `-2` 才算失败）→ vendor/send-time（失败仅告警）→ `markReady` → setmode?mode=0（失败硬抛）→ 起播」，删掉 rtspstatus |
| E-2 | §1.5「seed 用于让相机 RTSP 服务端授权本次连接」「`seed` 是随机长整型**挑战值**」（第 123、126 行） | 客户端侧没有任何把 seed 交给 RTSP/播放器的通路：seed 只出现在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:239`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1049` 两处，且 auth 响应的 `info` 声明为 `Any?` 且不解析（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse.java:15-19`；调用点只读 `result`：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:380`）；RTSP URL 里也不含 seed（`_work/.../ride3pro/DocumentedRide3ProMediaEndpointResolver.java:31`） | 把「授权本次 RTSP 连接」降级为**推断**，并注明「『挑战值』是拟人化表述：seed 由端侧随机数生成器产生、不参与任何计算、不校验回显，因此不构成挑战-应答」 |
| E-3 | §1.7「读写：`getparameter?id=` / `setparameter?id=&value=`（**id 为参数键，如 resolution/exposure/wb/fps/loop/hdr 等**）」（第 140 行） | id 的取值域是一张封闭硬编码表，9 个字面量：`all`、`factory_reset`、`record_exposure`、`record_loop_recording`、`record_resolution`、`system_frequency`、`system_version`、`wifi_name`、`wifi_passwd`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:18-27`）；`resolution`/`exposure` 是**归一化后的菜单名**，不是发出去的 id（查表 `:40-161`）；`wb`/`fps`/`hdr` 在表里**根本不存在**（default 分支 `:158-159` 返回 null → `_work/.../Ride6SettingsProtocolClient.java:248-251` 抛 `IllegalStateException("R6 setting does not have a protocol request ID: …")`） | 改为「id 由 `forSetting(分区名, 项名)` 查表得出，取值域封闭为上述 9 个串；表命中不了就不发 `setparameter`；XML 的 `<ID>`（如 `0x0000208`、`0x0000301`，`_work/.../Ride6SettingsCompatibilityPolicy.java:17-19`）只做值回填与兼容性判等的键，不作为 `?id=` 发出。详见本文 §5.3」 |
| E-4 | §1.7「相机通过 `GET /api/menu/xml` 下发菜单 XML（**项/可选值/当前值**）」（第 139 行） | 解析器只读 6 个名字：`Category/Name`、`Setting/{Name,ID,Type,Default}`、`Value/{Name,ID}`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuXmlParser.java:50-81`），**没有「当前值」这一项**；当前值来自 `getparameter`（`_work/.../Ride6SettingsProtocolClient.java:292-452`） | 把「当前值」改为「默认值 `<Default>`」，并注明当前值是随后用 `getparameter?id=all` + 对 `Type ∈ {1,4}` 的项逐条补读得到的 |
| E-5 | §1.7 通篇把菜单读取当成 HTTP `GET /api/menu/xml`（第 83、139 行，`docs/03:128` 同样写法） | 会话路径上 `Ride3ProSessionApiService.getMenuXml` 被改写成裸 socket：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:1498-1520` → `_work/.../ride3pro/Ride3ProSessionTransport.java:373-496` → `readMenuXmlRaw`（`:516-544` 反编译失败，但局部名含 `socket`：`:90`；私有 `connectCancellable` 用 `MENU_CONNECT_TIMEOUT_MILLIS` 建连：`:627-673`）；Ride6/Ride3Pro 设置页拿的是这个包装（`_work/.../Ride6SettingsProtocolClient.java:149-155`） | 至少在端点表旁注明「**HTTP `/api/menu/xml` 是接口声明与兜底路径；有会话 executor 时官方走裸 socket 读同一份菜单**（四个 `MENU_*` 常量均 `@Deprecated`：5000 / 524288 / 8192 / 30000，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:65-75`）；socket 上具体写什么静态无解（本文 §5.1） |

### 8.4 我们自己的文档/实现里与此冲突之处（不在指派范围内，但属同一事实，必须处理）

| 编号 | 原说法 | 证据 | 应改为 |
|---|---|---|---|
| F-1 | `docs/02-功能-设备连接流程.md:16`「帧协议已 **1:1 还原**：分隔符定帧 + 64KB 上限 + 缓冲区保护，全部与官方一致」 | 与 D-1/D-2 冲突：官方是 `LegacyReadChunkFrameDecoder`（chunk 即帧，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/LegacyReadChunkFrameDecoder.java:18-21`），`DelimitedFrameDecoder` 零构造点 | 把「与官方一致」删掉；若要严格对齐官方行为，应实现「一次 read 到多少字节就当几帧 + 每帧独立 UTF-8 JSON 解析 + 解析失败归 `Unknown`」 |
| F-2 | `docs/01-APK逆向分析报告.md:94`「帧格式：**分隔符定界**（delimiter），单帧上限 64KB，缓冲上限 256KB」 | 官方活路径是 `LegacyReadChunkFrameDecoder`（一次 read 即一帧，上限 4096B），`DelimitedFrameDecoder` 无任何构造点 → 64KB/256KB 属于死代码里的常量；另外当前工作树里**我们并没有 M3 事件通道的任何实现**：`grep -rln "Tuwin" --include=*.kt composeApp/src` 只命中 2 个文件（`composeApp/src/commonMain/kotlin/com/rovecamlink/app/brand/tuwin/TuwinRestProtocol.kt` 与 `composeApp/src/commonMain/kotlin/com/rovecamlink/app/AppGraph.kt`，均无 socket 代码）（`composeApp/src/commonMain/kotlin/com/rovecamlink/app/AppGraph.kt`、`composeApp/src/commonMain/kotlin/com/rovecamlink/app/brand/tuwin/TuwinRestProtocol.kt`，后者 279 行且不含 `msgid`/`frame`/`delimiter` 任何一字样；`grep -rn "rec_time\|countdown_time\|M3_SOCKET_EVENTS" --include=*.kt composeApp/src` 除一条无关日志外零命中），`docs/06` 引用的 `TuwinRawSocketClient.kt`/`TuwinProtocol.kt` 路径在本树中不存在 | 这条「已完成」状态已经失效，需要重写：先明确按 §4.4 的无分隔符契约实现，再按 §4.6 的 7 个 `msgid` + 2 个边界（空帧丢弃、坏帧归 Unknown）做解码，最后按 §4.7 决定实现 6 个有消费方的事件（`mic`/`Unknown` 官方未用） |

### 8.5 明确无冲突的条目（逐条核对过，无需改动）

1. `docs/03` §1.2(a) 的 6 条 SSID 正则与「M3 → RIDE3PRO → RIDE6 → RIDE5」优先级、`normalizeSsid` 预处理、`isConnectedTUWIN()` 的宽松判据 —— 与本文 §1.2 一致（含 `RIDE5_COMMON` 兜底吞名这个坑）。
2. `docs/03` §1.2(b)/(c)/(d) 的 model 键位、`acceptsModel` 三条语义、RIDE5 空集放行、BSSID 优先、`Ride5IdentityPolicy` 的 `[0-9A-F]{12}` + 三个黑名单地址、M3/RIDE3PRO/RIDE5 三个 bootstrap 探测端点 —— 与本文 §1.4/§1.5 一致。
3. `docs/03` §1.4 M3 TCP 三个反直觉事实的**结论**（无分隔符 / 端口动态且 host 强制同控制端 / 单向）—— 本文 §4.4、§4.2、§4.1 全部复核成立（仅证据行号与数值需按 C-11/C-12 补强）。
4. `docs/03` §1.4 的 `msgid → info 字段` 表内容与 `sd.status` 默认 99、`rec`/`mic` 用 `value == 1`、`Unknown` 不抛 —— 与本文 §4.6 一致。
5. `docs/03` §1.4 能力集 M3 三项 `M3_HTTP_CONTROL` / `M3_MEDIA_ENDPOINT` / `M3_SOCKET_EVENTS` —— 与本文 §4.8 一致（并补：首开时第三项是按 socket 是否连上动态加的，恢复路径则三项硬凑，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:332-338`、`:546`）。
6. `docs/03` §1.4「Ride5 CGI 的 query key 字面带前导 `-`」、`docs/01` §1.3 表格的 `DeviceEndpointProtocol` = HTTP/RTSP/TCP —— 与本文 §2.3、§1.4 一致。
7. `docs/01` §1.5「端点授权：`DeviceEndpointAuthority.issue(...)` 颁发 `EndpointGrant`（RTSP / 8080 / `/` / MEDIA / PROFILE_BOOTSTRAP），`AuthorizedRtspEndpoint` 校验后才允许连」—— 与本文 §7.1、§7.4 第 5 步逐字相符（校验分支全表见 §7.4）。

### 8.6 本文内部（§2 已由他人写完，此处只记录不一致，不做修改）

| 编号 | 本文位置 | 与实际证据的偏差 | 正确说法（见本节/§3.2） |
|---|---|---|---|
| G-1 | §2.1 表格第 15 行（`/api/rtspstatus`）的「声明 / 主要调用点」列写成 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:57-58`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:688, 703` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:703` 与 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java:446` 是 **override**（`implements Ride3ProApiService`），`:688`/`:431` 只是各自协程体里对 delegate 的透传；全仓没有业务调用点 | 应归入 §2.7「声明了但没有任何调用方的端点」；§2.1 第 15 行「与 §3 的 authdevice seed 同一随机数体系」也应改为「形参同为 `seed: Long`，但 §3 的两处 `Random.nextLong` 不会喂给它（因为没有喂它的代码）」 |

---

<!-- 以下整段合并自原 01-TUWIN-档案-附录-设置与操作.md（2026-09-22 文档归并，内容未改） -->
# TUWIN 档案 · 附录：设置与操作

> 数据来源：反编译产物 `_work/tuwin_src/sources/com/tuwinsmart/**`（jadx），以及机器提取表 `_work/re/tuwin/**`。
> 引用格式：`_work/tuwin_src/sources/com/tuwinsmart/…/<类名>.java:<行号>`，行号取自 jadx 输出（与 `api/*.md`、`catalog-*.md` 中的行号一致）。

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
- 空 categories 亦硬失败：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:193-195`，异常文本 `"R6 WIFI_MENU.xml does not contain any categories"`。
- Schema（全部按**直接子元素**取值，无属性）：
  - `<Category>` — 文档中任意深度都会被 `getElementsByTagName("Category")` 抓到（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuXmlParser.java:41`）
    - `<Name>` → 分区显示名（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuXmlParser.java:50`）
    - `<Setting>` — **仅 Category 的直接子元素**（`Ride3ProSettingsRuntimeMapperKt.childElements`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsRuntimeMapperKt.java:59-76`）
      - `<Name>` → 项显示名（:58）
      - `<ID>` → 项 id，形如 `0x0000000`（:60）
      - `<Type>` → 类型码（:62）
      - `<Default>` → 默认值（:64）
      - `<Value>`* → 仅 Setting 的直接子元素（:65）
        - `<Name>` → 选项显示名（:71）
        - `<ID>` → 选项值（:74）
  - 缺元素的兜底：全部 `""`；`values` 缺省为 `emptyList`（`Ride3ProMenuSetting` 构造掩码 32，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProMenuXmlParser.java:81`）。
- `<Type>` 语义（`ride3ProSettingTypeCode` = 十六进制/十进制宽容解析，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsRuntimeMapperKt.java:17-35`）：

  | Type 数值 | 显示逻辑（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsRuntimeMapper.java:53-94`） | 是否发 `getparameter` |
  |---|---|---|
  | `0` | 用 `<Value>` 列表按选中项反查 `<Name>` 显示（:58-69） | 否（走 `getparameter?id=all` 批量） |
  | `1` | 显示 `actionLabel`，默认 `"Execute"`（:79-81，`toDisplaySections$default` :22-27） | 是（单独 `getparameter?id=<requestId>`，:361） |
  | `2` | 直接显示原始字符串值（:70-77） | 否 |
  | `3` | 同 `0`，按 `<Value>` 反查显示（:58） | 否 |
  | `4` | 显示 `actionLabel`（:82-84） | 是（同 `1`） |
  | 其它/无法解析 | 原值 → `<Default>` → `""`（:85-93） | 否 |

  `1` 与 `4` 被显式列为「需要单独查询」的两类：`SetsKt.setOf(Integer 1, Integer 4)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:361`、`:390`、`:449`）。

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
- 读：`GET /api/menu/getparameter?id=<id>`；批量 `id=all`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:410`）→ `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:33-34`（`@GET("/api/menu/getparameter")`）。
- 写：`GET /api/menu/setparameter?id=<id>&value=<v>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:60-61`；调用点 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:254`）。
- `Format` 项特殊：**不走 setparameter**，直接 `GET /api/system/formatsd`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:239-242` + `Companion.isFormatSetting` :521-523，判定条件是 `item.name` 忽略大小写等于 `"Format"`，用的是**本地化名之前的英文名**）。
- `requestId == null` 时 `update()` 会先按项名重算一次；仍为 null 则抛 `IllegalStateException("R6 setting does not have a protocol request ID: " + name)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:248-251`）。
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

`Ride3ProSimpleSettingsMenuPolicy.build(deviceName, features)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSimpleSettingsMenuPolicy.java:31-49`）；`features` 来自 `GET /api/device/info` 的 `features` 字段（`Ride3ProDeviceInfo.java` 的 `List<String> features`），先经 `Ride3ProProtocolFeatures.normalize`（trim + lowercase ROOT + 去空，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProProtocolFeatures.java:24-40`）。

| 顺序 | 类型（`Ride3ProSimpleSettingsItemType`） | 资源 id | 中文 | 显示值 | 出现条件 | 点击行为 |
|---|---|---|---|---|---|---|
| 1 | `DEVICE_NAME` | `device_name_label` | 设备名称 | 设备名（`resolveDeviceName()`） | 恒有 | 弹 `Alert.Type.INPUT`，标题 `modify_device_name`「修改设备名称」→ 见 §4 |
| 2 | `WIFI` | `wifi_password_settings` | WiFi密码设置 | — | `features` 含 `nv` | 弹输入框改密码 |
| 3 | `STORAGE` | `storage_management` | 存储管理 | — | 恒有 | 跳存储页 |
| 4 | `FIRMWARE` | `firmware_upgrade` | 固件升级 | — | 恒有 | 跳升级页 |
| 5 | `FACTORY_RESET` | `factory_reset` | 恢复出厂设置 | — | `features` 含 `nv` | 确认弹窗 → `setparameter?id=factory_reset` |
| 6 | `REBOOT` | `reboot_device` | 重启设备 | — | `features` 含 `reboot` | 确认弹窗 → `GET /api/reboot` |

`Ride3ProProtocolFeatures` 两个 feature 字面量：`NV = "nv"`、`REBOOT = "reboot"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProProtocolFeatures.java:20-21`）。
枚举本身 6 个常量：`DEVICE_NAME / WIFI / STORAGE / FIRMWARE / FACTORY_RESET / REBOOT`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSimpleSettingsItemType.java:12-17`）。
`Ride6SettingsCompatibilityPolicy.supplementalMenuFeatures()` 只从扩展菜单里透传 `reboot` 一个 feature（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsCompatibilityPolicy.java:24-34`）。

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

未在表内的参数名（如设备下发的 `logo`）→ `getStringResourceId` 返回 `null` → **标题直接用英文原文显示**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:394-400`）。

取值域**静态不可枚举**，全部来自设备响应 `GET /app/getparamitems?param=all_<modeId>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:2406`：`getParamItemsByMode("all_" + i, …)`；`i` = `getCurrentMode` 返回的模式整数）。
响应 DTO `M3ParamItem`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamItem.java:19-34`）字段：

| 字段 | 含义 | 用法 |
|---|---|---|
| `name` | 参数名 | 查标题、写回 `param` |
| `items` | 选项**显示文本**列表 | 与 `index` 一一对应 |
| `index` | 选项**线上取值**列表（整数） | 写入 `value` |
| `curIndex` | 当前生效的线上取值（不是下标！） | UI 用 `index.indexOf(curIndex)` 反查下标（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:482-490`） |
| `itemsDisable` | 被禁用的选项文本列表 | 弹窗中该选项 alpha=0.5（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:653`、`:675`） |
| `enable` | `1`=可用；缺省按 `1` 处理 | 否则整行 alpha=0.5 + `setEnabled(false)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:391-392`、`:403-404`） |

写值：`GET /app/setparamvalue?param=<name>&value=<index[i]>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:112-113`；调用点 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3DeviceSettingsViewModel.java:119-160`）。
成功判据：响应 `result == 0`。
特例：写成功后若 `paramName == "rec_resolution"`，立刻用同一 `currentModeId` 重新拉一次全表（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3DeviceSettingsViewModel.java:166-169`）—— 因为分辨率是模式相关的。

**开关型判定**（`M3SettingsAdapter.isToggleSetting`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:412-418`）：`items.size() == 2` 且集合等于 `{"off","on"}` 或 `{"0","1"}` → 渲染 `Switch`；拨动时按 `items.indexOf(on?"on":"off")` 找下标，再取 `index[下标]` 写回（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:450-466`）。否则渲染「值 + 箭头 → 底部选择弹窗」（`:468-499`、`:514-592`），弹窗标题 = 该行标题（`dialog_setting_selection` 布局，标题文本 `tvDialogTitle`）。
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

正则形态（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/M3SettingValueMapper.java:26-31`，命中即模板化）：

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
- 注意：**M3 设置页列表里没有 WiFi 设置项**，但 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3DeviceSettingsActivity.java:229` 仍保留了 `wifi_settings` 分支（点击进入 `M3WifiSettingsActivity`）—— 属于可达但菜单未挂的死分支。

### 1.5 M3：设备 / WiFi / 存储 / 恢复出厂 页

| 页 | 标题资源/中文 | 入口 | 项 | 接口 |
|---|---|---|---|---|
| `M3DeviceSettingsActivity` | `title_m3_device_settings`「设备设置」 | 设置页 `firmware_upgrade` 之外无直连；由 `activity_m3_device_settings` 布局承载，正文上方有 `loading_config`「加载配置中…」 | 见 1.4 | `getcurmode` → `getparamitems?param=all_<mode>` |
| `M3WifiSettingsActivity` | `wifi_settings`「WIFI设置」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3WifiSettingsActivity.java:122`） | 上述死分支 / `activity_m3_wifi_settings` 两行 | ①`wifi_name_label`「WIFI名称」，值取 `ConnectUtil.getCurrentSSID()`（`:130-135`）②`change_wifi_password`「修改WIFI密码」（`:202`） | ①`GET /app/setwifi?wifissid=<新名>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:2707+`，走 `setWifi$default(api, ssid, null, mask=2)`）②`GET /app/setwifi?wifipwd=<新密码>`（`:2776+`，`mask=1`） |
| `M3StorageSettingsActivity` | `storage_settings`「存储设置」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3StorageSettingsActivity.java:111`） | 设置页 `storage_settings` 项 | 单行 `format_memory_card`「格式化内存卡」（`:135`），确认文案 `dialog_confirm_format_memory_card`「确定要格式化存储卡？」 | `GET /app/sdformat` |
| `M3FactoryResetActivity` | `factory_reset`「恢复出厂设置」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3FactoryResetActivity.java:111`） | 设置页 `factory_reset` 项 | 确认文案 `confirm_factory_reset` | `GET /app/reset` |

M3 WiFi 输入校验：**只校验非空**，不做字符集/长度校验（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3WifiSettingsActivity.java:186-199`（SSID）、`:211-224`（密码）：trim 后 `length == 0` 直接 `return false` 不关弹窗）。这与 Ride 系用 `wifi_name_invalid`/`wifi_password_invalid` 强校验不同。
成功文案：改 SSID → `modify_success`「修改成功」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3WifiSettingsActivity$showEditWifiSsidDialog$1$1.java:73`）；改密码 → `wifi_settings_take_effect_after_restart`「新的设置将在WIFI重启后生效」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3WifiSettingsActivity$showEditWifiPasswordDialog$1$1.java:71`）；失败 → `modify_failed_with_code`「修改失败：%s」。

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
| `AUDIO` | 3 | 否（camparam） | 录音开关 | `audio_switch`「录音开关」 | 读回 `value == "1"` → 开；写 `"1"` / `"0"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:1151`、`:2120-2131`） |
| `FLIP` | 3 | 否 | 上下翻转（仅前摄） | `flip_up_down_front_only` | `value == "ON"` → 开；写 `"ON"` / `"OFF"`（`:1131`、`:2110-2118`） |
| `MIRROR` | 3 | 否 | 左右翻转（仅前摄） | `flip_left_right_front_only` | `value == "ON"` → 开；写 `"ON"` / `"OFF"`（`:1141`、`:2090-2100`） |
| `MEDIAMODE` | 3 | 否 | 分辨率设置 | `resolution_settings`「分辨率设置」 | 当前值原样显示（`:2182`）；能力集来自 `pType != 3` 时读回的 `capability` 字段，逗号分隔（`:2174-2181`），兜底数组 `{"1080P+1080P"}`（`:2203`）；弹窗标题 `select_recording_resolution`「请选择录制分辨率」+ 副标题 `recommended_resolution_tip`「推荐：1080P+1080P，更稳、更省电、更耐用」；选中项**原文**作为 `-value`（`:1457`） |
| `Rec_Split_Time` | 3 | 否 | 录像时长 | `recording_duration`「录像时长」 | 当前值：原文把 `MIN` 替换成 `minute_unit_suffix`「分钟」显示（`:2136-2144`）；能力集同样来自 `capability` 逗号分隔并做同一替换（`:2150-2164`）；兜底 `defaultRecordDurations()` = `{one_minute_unit「1分钟」, three_minutes_unit「3分钟」, five_minutes_unit「5分钟」}`（`:2200`、`:2207-2215`）；弹窗标题 `select_recording_duration`「请选择循环录制时间」；写值时把中文「分钟」反向替换回 `MIN`（`:1578-1588`、`:1644-1654`） |
| `GSR_SENSITIVITY` | 0 | 是（commparam） | 紧急录像 | `emergency_recording`「紧急录像」 | 写 `"OFF"`（关）/ `"MIDDLE"`（开=中灵敏度）（`:1061`、`:1075`）；读回 `value` ∈ {`HIGH`,`OFF`,其它} → `HIGH` 时开关为开（`:2297-2330`）；开启前弹 `tips`「小贴士」+ `emergency_recording_explanation`「开启后，骑行中如果设备因颠簸或摔车发生晃动，将自动录像 45 秒，并保存到紧急录像文件夹，而不是普通录像。」（`:1048`） |
| `GSR_PARKING` | 0 | 是 | 哨兵模式 | `sentinel_mode`「哨兵模式」 | 写 `"OFF"` / `"HIGH"`（`:1107`、`:1121`）；开启前弹 `tips` + `parking_mode_explanation`「开启后，设备关机但电池有电时，如遇外力碰撞或晃动，将自动录像 45 秒，并保存到紧急录像文件夹，不会存入普通录像。」（`:1094`） |
| `VCAPVQE` | 0 | 是 | 智能降风噪 | `wind_noise_reduction`「智能降风噪」 | 写 `"OFF"` / `"ON"`（`:1183`、`:1197`）；读回忽略大小写比较 `"ON"`（`:2285-2294`）；开启前弹 `wind_noise_notice_title`「开启降风噪提示」+ `wind_noise_notice_message`「开启后麦克风会主动滤除低频风噪，可能会轻微降低环境音量并增加处理延迟，请确保当前场景需要降风噪再开启。」（`:1170`） |

`pType` 的语义（由代码分支反推）：`0` = 仅用于 commparam 占位（`isCommParam=true` 时不使用）；`1` = 请求**能力集**（`cameraParameterCapability`，失败时走 `renderSettingFailure` 兜底，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:2194-2198`）；`2` = 走 `setcommparam`（`setSettings` 内 `pType == 2` 分支，`:1566-1571`）；`3` = 请求/写回**当前值**（`cameraParameter`，`:2033`）。

另有第 9 个 type 不走队列、单独读写：`WIFI_DEFAULT_STATE = "WIFI_DEAULT_STATE"`（**源码原文拼写错误，少了个 F**，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:87`）—— WiFi 模式三态：
- 读值：`GET cgi-bin/hisnet/getcommparam.cgi?-type=WIFI_DEAULT_STATE`（`:679`）
- 读能力：`getcommparamcapability.cgi?-type=WIFI_DEAULT_STATE`（`:809`）
- 写：`setcommparam.cgi?-type=WIFI_DEAULT_STATE&-value=<OFF|ON|ALWAYSON>`（`:910`）
- 三态文案（`wifiModeDescriptions`，`:247`）：`OFF` → `wifi_mode_off_desc`「禁用自动开启（开机需手动打开）」；`ON` → `wifi_mode_on_desc`「自动开启（3 分钟未连接自动关）」；`ALWAYSON` → `wifi_mode_always_on_desc`「始终开启（开机后保持打开）」；未知值 → `wifi_mode_unknown`「未知模式」（`:951`）。弹窗 `wifi_mode_dialog_title`「设置 WiFi 模式」+ 副标题 `wifi_mode_alert_subtitle`「注意：禁用自动开启后需要开机后按 M 键手动开启 WiFi」（`:757`）；加载中 `wifi_mode_loading`「加载中...」；失败 `wifi_mode_load_failed`「加载失败」。

**按机型的可见性裁剪**（`MoreSettingsCapabilityPolicy.resolve`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsCapabilityPolicy.java:26-42`）：

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
| 修改 WiFi 名+密码（Ride 系） | `MoreSettingsActivity` 的 `WIFI设置` 行 | `modify_wifi_name_password`「修改WiFi名称和密码」，`Alert.Type.TWO_INPUT` 双输入 | 校验：`wifi_name_invalid`「WIFI名称只能包含字母和数字，字符_或-，且长度为8~32个字符」、「WIFI密码只能包含字母和数字，字符_或-，且长度为8~20个字符」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:1288-1297`） | 先写本地镜像 `updateDeviceWifiInfo`，失败提示 `modify_failed`；成功再发相机请求 |

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
**未知 modeId 的兜底显示名** = `m3_mode_video_normal`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailActivity.java:1762-1763`）。

切模式发送的请求（**唯一一条**）：`GET /app/mode?param=<modeId>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:109-110`；调用点 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel$startModeSwitch$1.java:57`）。
成功判据：`M3SetModeResponse.result == 0`；随后 `_appliedMode = modeId`，**1000 ms** 后（`DelayKt.delay(1000L)`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel$startModeSwitch$1$1$1.java:57`）解除 `_isSwitchingMode` 并执行 `applyPendingModeIfNeeded()` / `verifyFinalModeAfterQueueDrained()`。
失败（`result != 0` 或异常）：`_currentMode` 回滚为 `_appliedMode`，触发 `_modeSwitchFailedEvent`，同样起一个 1000 ms 的收尾协程（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel$startModeSwitch$1$2$1.java:50`）。
模式切换 loading 超时：`MODE_SWITCH_LOADING_TIMEOUT_MS = 10000`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailActivity.java:131`）。

与模式相关的前置拦截（`M3DeviceDetailViewModel.onModeSelected`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel.java:2288-2310`）：
1. 正在录像 → 发 `_modeSwitchBlockedByRecordingEvent`，UI Toast `m3_wait_stop_recording`「请先停止录像」，**不发请求**。
2. 正在拍照 → 发 `_modeSwitchBlockedEvent`，Toast `m3_wait_photo_finish`「请等待拍照结束」。
3. 正在切换中 → 记为 `pendingModeId` 排队（不立即发）。
4. 目标 == 已生效 → 跳过（"Mode already applied, skipping API call"）。
5. 频率限制 → `mode_switch_too_frequent`「切换模式太频繁」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailActivity.java:2625`）。

`/app/setting?param=<str>`（`setMenuMode`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:106-107`）与 `/app/playback?param=<str>`（`setPlaybackMode`，`:115-116`）是另外两条**菜单/回放态切换**通道，与模式切换不同：回放入口 `M3DeviceDetailViewModel.onGalleryClicked()` / 预览页 `playback`「回看」按钮，具体 `param` 词表在 APK 内是变量（未静态确定，见 §6 纠正项）。

### 2.2 Ride3Pro / Ride6

Ride 系**没有** App 侧的模式常量表，只有一个二元开关：

| mode 值 | 语义 | 出现处 |
|---|---|---|
| `0` | 相机/拍摄态 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:98`（`setMode(0, …)`，录像控制前的复位）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/C2216x9d51f82a.java:47`（`setMode(0, …)`） |
| `2` | 回放态 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:193`（`setPlaybackMode` → `setMode(2, …)`）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProIndexedPlaybackModeAction.java:69`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProStorageCapabilityProbe.java:160`（能力探测前先 `setMode(2)`） |

请求：`GET /api/setmode?mode=<int>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:57-58`）。成功判据 `result == 0`。
具体的拍摄参数（分辨率、循环、曝光…）不在 mode 里，全走 §1.1/§1.2 的菜单通道。
状态回报：`GET /api/device/status` 的 `current_mode` / `mode_active` 字段（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProDeviceStatusInfo.java:15-33`），以及回调事件串 `"\"eventid\":\"STATEMNG_SWITCH_WORKMODE\""`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackMessagePolicy.java:16`）。

### 2.3 Ride5

Ride5 无整数模式常量，模式以**字符串 workmode** 表达。APK 内静态出现的只有一个：`"NORM_REC"`（普通录像），用作 `getcamparam.cgi?-workmode=NORM_REC` 与回调匹配串 `"arg2":"NORM_REC"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:86`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackMessagePolicy.java:15`）。
模式命令走 `GET cgi-bin/hisnet/workmodecmd.cgi?-cmd=<str>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi.java:91-92`），`-cmd` 词表在 APK 内**全部是变量**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:611/625` → `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5GatewayMediaPort.java:26`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5GatewaySessionPort.java:35`），静态无法枚举。
摄像头切换：`GET cgi-bin/hisnet/getcamchnl.cgi?-camid=<str>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi.java:88-89`）。

## 3. 页面与入口

> 本节的「中文」列一律抄 `_work/re/tuwin/res-strings-zh.md`（优先 `values-zh-rCN`，其次 `values-zh`）；该表未覆盖的条目标 **（无中文）**，此时界面直接显示 `_work/re/tuwin/res-strings-default.md` 的英文原文。
> 布局列抄 `_work/re/tuwin/layouts.tsv`（249 个 layout + 4 个 xml，共 253 条）。

### 3.0 先说清楚：TUWIN 没有 Android 菜单 XML

`_work/re/tuwin/layouts.tsv` 的 `type` 列只有两个取值：`layout`（249 条）与 `xml`（4 条）。**零条 `menu`** —— 全 APK 不存在 `res/menu/*.xml`。那 4 个 `xml` 是 `app_update_file`、`file_paths`、`locales_config`、`network_config`（`_work/re/tuwin/layouts.md` 「xml（4 个）」节），与菜单无关。

因此「菜单 XML 动态渲染」在 TUWIN 里**只有一处**：Ride3Pro/Ride6 设置页的下半区，数据源是相机 HTTP 下发的 `WIFI_MENU.xml`（`GET /api/menu/xml`，Schema 见 §1.1），渲染容器是 `activity_ride3_pro_settings` 的 `rv_settings`，兜底数据是 §1.2.1 的静态表。其余全部页面都是**静态布局 + 代码里手写点击**，顶栏统一用自定义控件 `com.tuwinsmart.tuwin.presentation.widget.ToolBar`（`_work/re/tuwin/layouts.tsv` 的 `layout_actionbar` 行：`BLLinearLayout RelativeLayout ImageView TextView LinearLayout ImageButton`，id `iv_back`/`tv_title`/`iv_right`/`btn_right`）。

| 渲染方式 | 页面 | 依据 |
|---|---|---|
| **设备 XML 动态渲染** | `Ride3ProSettingsActivity` 下半区（`ride6_dynamic_container` + `rv_settings`，条目布局 `item_ride3_pro_settings_section` / `item_ride3_pro_settings_item`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsActivity.java:122`（`new Ride3ProSettingsAdapter(C1870R.string.ride6_setting_meta)`） |
| **设备参数列表动态渲染（非 XML）** | `M3DeviceSettingsActivity`（`rv_settings` 之外的 `RecyclerView`，布局 `activity_m3_device_settings` id `recycler_view`），数据来自 `getparamitems` | §1.4 |
| 静态布局 + 运行时按机型裁剪可见行 | `MoreSettingsActivity`（Ride5/Ride3Pro 通用页） | §1.6 的 `MoreSettingsCapabilityPolicy.resolve` 表 |
| 纯静态布局 | 其余所有页（下表） | `_work/re/tuwin/layouts.tsv` |

### 3.1 主页容器：`HomeActivity`（`activity_home`）

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java`。3 个 Tab 对应 3 个 Fragment，用 `switchFragment(index)` 做 add/hide/show（`:190`），挂载容器 id `fl_content`（`:203`）。

| 控件（中文） | 资源 id | 布局 id | 代码位置 | 点击后的动作 |
|---|---|---|---|---|
| 首页 | `home` | `btn_connect`（含 `iv_home`/`tv_home`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java:135`、`:175` | `switchFragment(0)` → `ConnectFragment`（tag `connect`，`:84-88`） |
| 已下载 | `album`（英文默认 `Downloaded`） | `btn_album`（`iv_album`/`tv_album`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java:148`、`:181` | `switchFragment(1)` → `AlbumFragment`（tag `album`，`:90-94`） |
| 帮助 | `help` | `btn_helper`（`iv_helper`/`tv_helper`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java:162`、`:187` | `switchFragment(2)` → `MineFragment`（tag `helper`，`:96-100`） |
| — | `permission_view_stub` | `permission_view_stub` | `activity_home` 布局根 | 权限遮罩层，`getPermissionView()`（`:55`） |

首次进入且未同意隐私时弹全屏隐私框（`:127-129` → `showPrivacyDialog()` `:293`）：标题 `privacy_policy_title`，正文走 `HomePrivacyPolicyContentLoader`，按钮 `privacy_policy_agree` / `privacy_policy_disagree`。

### 3.2 首页列表：`ConnectFragment`（`fragment_connect`）

布局 id：`cl_logo`、`iv_logo`、`refresh_layout`（下拉刷新）、`recycler_view`。列表由 `HomeListAdapter` 渲染，行型布局 6 种（`_work/re/tuwin/layouts.tsv`）：`item_home_list_device_title`、`item_home_list_device`、`item_home_list_add_device`、`item_home_list_brand`、`item_home_list_service_card`、`item_home_list_weather`。

| 控件（中文） | 资源 id / 布局 | 代码位置 | 点击后的动作 |
|---|---|---|---|
| 添加设备 | `add_device` → `item_home_list_add_device`（id `tv_add`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:292-302` | 先 `ConnectHelperDialog.INSTANCE.show(...)`（权限引导），确认后再 `ConnectDialog2.newInstance(deviceType, ssid, pwd, apBssid)`（`fragmentTransaction.add(..., "ConnectDialog2")`） |
| 设备卡片 | `item_home_list_device`（`iv_device_preview`/`pb_device_loading`/`tv_device_name`/`iv_connected`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment$_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment$initFragment$2$onItemClick$1.java:115-186` | M3：先 `withTimeoutOrNull(5000L)` 取重力方向（`:119`），再进 `M3DeviceDetailActivity`（`:160-163`，extra `gravityDirection`+`device_session_id`）；Ride3Pro/Ride6/Ride5/未知：进 `DeviceDetailActivity`（`:144-158`、`:168-182`，extra `extra_device_type_code`/`device_session_id`/`device_id`）。动画 `launchByRightToLeftAnim` |
| 设备卡片·长按/删除 | `confirm_delete_device`「确认删除此设备吗？」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:324-332` | `Alert` 标题=该文案，正按钮 `confirm`「确认」/负按钮 `cancel`「取消」→ 从 `preferenceHelper.cacheDevices` 移除 |
| 服务卡片 | `item_home_list_service_card`（`tv_service_1`/`tv_service_2`/`tv_service_3`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:355-360` | 电商跳转：`tbopen://m.taobao.com/tbopen/index.html?...tuwin.tmall.com`；失败兜底 `tmall://page.tm/shop?shopId=255736524`，再兜底 `https://tuwin.tmall.com` |
| 刷新 | `refresh_layout` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:633`（`scheduleFirmwareReconnectRefresh(long)`）、`ConnectFragmentShowRefreshPolicy` | 触发重连探测（§5） |
| — | — | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:351` | 无网络时 Toast `network_error_check_network`「网络连接异常，请检查网络」 |
| 设备管理入口 | — | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:308` | `launchByRightToLeftAnim(DeviceListActivity)`，布局 `activity_device_list`（单 `RecyclerView` `rv_device_list`，无文案） |

### 3.3 设备添加与连接向导

链路：`ConnectDialog2` →（`DeviceWifiScanDialog` 选热点）→ `ConnectionProgressDialog` → 成功回首页/预览；失败 → `ConnectHelperActivity` / `ConnectHelperDetailActivity`。

| 步 | 页/弹窗 | 布局 | 控件（中文） | 资源 id | 动作 |
|---|---|---|---|---|---|
| 0 | 权限引导弹窗 | `dialog_connect_helper` | TUWIN将为您提供以下服务 / 请「开启」相应权限 / 定位权限 / 存储权限 / 去开启 / 先不开启 | `tuwin_service_title`、`please_enable_permissions`、`location_permission`、`location_permission_desc`、`storage_permission`、`storage_permission_desc`、`enable_permissions`、`not_open_now`（id `btn_submit`/`btn_reject`） | 跳系统权限页；`ConnectHelperDialog` 与机型无关 |
| 1 | Wi-Fi 未开提示 | `dialog_connect2` | Wi-Fi 未开启 / 请打开手机 Wi-Fi / 开启 Wi-Fi 后，返回 App 继续连接设备 / 好的 | `wifi_disabled_dialog_title`、`wifi_disabled_dialog_message`、`wifi_disabled_dialog_hint`、`wifi_disabled_confirm_action`（id `btn_submit`） | 打开系统 Wi-Fi 面板 |
| 2 | 选设备热点 | `dialog_device_wifi_scan`（行 `item_device_wifi`） | 选择设备 Wi-Fi / 附近设备 / 正在扫描附近的设备 Wi-Fi… / 取消 / 重新扫描 / 找不到设备 Wi-Fi？ / 前往系统设置连接 | `select_device_wifi`、`nearby_device_wifi`、`scanning_device_wifi`、`cancel`、`retry_scan`、`device_wifi_not_found_question`、`connect_via_system_wifi`（id `btn_device_wifi_cancel`/`btn_device_wifi_retry`/`btn_device_wifi_fallback`/`rv_device_wifi`） | 选中项 → `ConnectDialogViewModel` 建连；`retry_scan` 重扫；`fallback` 跳系统 WLAN 设置页 |
| 3 | 连接进度 | `dialog_connection_progress` | 请保持设备 Wi-Fi 连接，完成前不要退出应用 | `connection_dialog_hint`（id `progress_connection`/`tv_connection_title`/`tv_connection_detail`/`status_container`） | 标题/详情两行文本由 `ConnectionProgressDialog` 按探测阶段改写 |
| 4a | 帮助列表 | `activity_connect_helper`（`fragment_connect` 侧入口 `ConnectHelperActivity`） | 无静态文案；动态填 `tv_default_wifi_name`、`tv_default_wifi_password`、`btn_action` | — | 展示机型默认 SSID/密码；`btn_action` → `ConnectHelperDetailActivity` |
| 4b | 帮助详情 | `activity_connect_helper_detail` | 连接方法 / 搜索不到设备 / 连接超时/连接失败 / 重置连接方案，正文长文 `connection_basic_steps`、`device_not_found_solutions`、`connection_timeout_solutions` | `connection_method`、`device_not_found`、`connection_timeout_failed`、`reset_connection_method` | 「重置连接方案」清 SSID 绑定；文案里的机型名是原文（如「1. 确保 Ride5 设备开机」） |

### 3.4 预览页（Ride 系）：`DeviceDetailActivity`（`activity_device_detail`）

顶栏标题由 `DeviceDetailTitlePolicy` 决定；电池条 `battery_view`（`layout_battery`，`BatteryView.setSsid(...)` 见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:700-704`，仅 `BatteryViewVisibilityPolicy.shouldShow(type)` 为真时可见，`:722`）。

| 控件（中文） | 资源 id | 布局 id | 代码位置 | 动作 |
|---|---|---|---|---|
| 低清预览 | `low_quality_preview` | `btn_low_quality` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:686` → `:845-852` | 弹 `Alert`：标题 `what_is_low_quality_preview`「什么是低清预览」，正文 `power_saving_preview_explanation`，按钮 `i_know`；**不发请求** |
| 回看 | `playback` | `btn_review`（`iv_review_icon`/`tv_review_title`/`tv_review_description`） | `activity_device_detail` 内 `ll_action_buttons` | 跳回放页，路由见 §3.7（`DeviceDetailStorageEntryRoutePolicy`） |
| 存储管理 | `storage_management` | `sv_device_actions` 的 `cl_storage`（`iv_storage_icon`/`tv_storage_title`/`tv_storage_description`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:634` → `:812-815`（`goStorage()`）→ `:974` `openStoragePage()` | Ride3Pro/Ride6 → 能力探测后路由（`:976-979`）；其它机型 → `StorageTabActivity` |
| 内存卡异常卡 | `memory_card_error`「内存卡异常」+ `ride3pro_memory_card_abnormal_format_hint`「无法正常录像，点击去格式化」 | `cl_sd_abnormal`（`iv_sd_abnormal_icon`/`tv_sd_abnormal_title`/`tv_sd_abnormal_description`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:647` → `:819-822` | `StorageManagerActivity.createIntent(this, deviceSessionId)`（格式化/推出内存卡页） |
| 录像写入异常卡 | `ride3pro_recording_write_error_title`「录像写入异常」+ `ride3pro_recording_write_error_hint`「发现 %d 个异常录像文件，请检查SD卡」 | `cl_recording_write_error` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:660` → `:825-832` | `showRide3ProExceptionDialog(title, msg)`（`:3265`，单按钮 `i_know`） |
| 摄像头异常卡 | `ride3pro_camera_abnormal_title`「摄像头异常」+ `ride3pro_camera_not_detected_hint`「未检测到CMOS传感器，请检查设备」 | `cl_camera_abnormal`（`frame_88`/`tv_camera_abnormal_*`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:673` → `:835-841` | 同上异常弹窗 |
| 前后摄切换 | — | `btn_steam_type`（图标 `ic_steam_front`/`ic_steam_back`，`:741`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:764` → `:868-872` | `checkCamNumAndSwitchSteamType(!isFront)`；`camnum==1` 或 Ride3Pro/Ride6 时整按钮 `View.GONE`（`DeviceDetailSteamTypeVisibilityPolicy.resolve`，`:17-29`）；不支持时 Toast `steam_type_switch_not_supported`（`:1493`） |
| 截图 | — | `btn_screenshot` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:777` → `:875-878`（`takePhoto()`） | 见 §4 拍照 |
| 全屏 | — | `btn_fullscreen` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:730` → `:856-864` | `videoView.toggleFullscreen()`，纯本地 |
| 小贴士 | `tips`「小贴士」+ `master_ride5_fully` / `master_ride3pro_fully` | `btn_tip`（`iv_tips_icon`/`tv_tips_title`/`tv_tips_description`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:791` → `:881-885` | `ExternalWebActivity.launch(..., HomeTipsWebsiteCachePolicy.TIPS_URL, getString(tips))` |
| 设置 | `title_more_settings`「更多」 | 顶栏右侧 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:1084`（`goSettings()`）→ `:1097`/`:1104`/`:1114` | 按 `DeviceDetailSettingsEntryRoutePolicy.resolve(type)`：M3 → `M3DeviceSettingsActivity`；Ride3Pro/Ride6 → `Ride3ProSettingsActivity`；其它 → `MoreSettingsActivity` |
| 版本行 | `device_version_info_format` | `tv_device_version_info` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:2928` | 显示 `BuildConfig.VERSION_NAME` + 设备版本 |

### 3.5 预览页（M3）：`M3DeviceDetailActivity`（`activity_m3_device_detail`）

静态文案：占位 `m3_device_detail_placeholder`「M3 设备详情（开发中）」、假数据 `4K30FPS`、`9.8G/28.8G`、`sd_card_abnormal`「SD异常」、`low_quality_preview`「低清预览」、`fullscreen_toggle`「切换全屏」、`100`。

| 控件（中文） | 布局 id | 代码位置 | 动作 |
|---|---|---|---|
| 回放入口 | `ivGallery` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailActivity.java:390` → `:2159` | `new Intent(this, M3StorageActivity.class)`；VM 侧事件 `navigationToGalleryEvent`（`onGalleryClicked`） |
| 设置入口 | `ivSettings` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailActivity.java:401` → `:2239` | `new Intent(this, M3DeviceSettingsActivity.class)`；事件 `navigationToSettingsEvent`（`onSettingsClicked`） |
| 低清预览说明 | `llLowQualityPreview` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailActivity.java:423` | 弹本地说明框，不发请求 |
| 模式网格开关 | `ivModeMenu` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailActivity.java:436` | 切换侧边条 `rvModeSelector` / 网格 `modeGridItems`（§2.1）；条目布局 `dialog_m3_mode_selector` + `item_m3_mode_option`，标题 `shooting_mode`「拍摄模式」 |
| 录像键 | `btnRecord`（`fragment_normal_record_mode`，配 `llRecordingStatus`/`ivRecordingIndicator`/`tvRecordingStatus`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/fragment/NormalRecordModeFragment.java:76-93` | 切换中 → Toast `m3_wait_mode_switch_finish`「请等待模式切换完成」；否则 `viewModel.onRecordClicked()` |
| 拍照键 | `btnPhoto`（`fragment_normal_photo_mode`，配 `llPhotoStatus`/`tvPhotoStatus`） | `fragment/TimedPhotoModeFragment.java`、`fragment/NormalPhotoModeFragment.java` 同构 | `viewModel.takePhoto()` |
| 缩时拍照键 | `btnTimelapsePhoto`（`fragment_timelapse_photo_mode`，多一行 `tvTimelapseCountdown`） | 同上 | `viewModel.onTimelapsePhotoShutterClicked()` |
| 电量 | `llBatteryContainer`/`ivBattery`/`tvBatteryLevel`/`ivCharging` | 由 `M3DeviceDetailViewModel.observeBatteryUpdates` 驱动 | §5 |
| 加载/遮罩 | `pbPlayerLoading`、`vFlashOverlay`、`vCenterIndicator` | — | 首帧门与拍照白闪 |

模式 → Fragment 由 `ModeStrategy` 提供，`getModeId()` 返回 §2.1 的整数（例：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/fragment/NormalRecordModeStrategy.java:12-14` 返回 `21` → `NormalRecordModeFragment`）。

### 3.6 设置页族

**`Ride3ProSettingsActivity`（`activity_ride3_pro_settings`）** —— 顶栏标题 `title_more_settings`「更多」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsActivity.java:230`）。上半区固定 7 行卡片（`legacy_settings_container`），下半区动态。

| 控件（中文） | 布局 id | 代码位置 | 动作 |
|---|---|---|---|
| 通用设置 | `tv_ride6_settings_header` 上方分组标题 `general_settings` | 布局静态文案 | 仅分区标题 |
| 设备名称 | `btn_device_name`/`tv_device_name`（`device_name_label`） | `:345` → `:422` | `Alert(INPUT)`，标题 `modify_device_name`「修改设备名称」 |
| WiFi密码设置 | `btn_wifi_setting`（`wifi_password_settings`） | `:358`、`:945` | `Alert(INPUT)`，标题 `wifi_password_settings`，hint `input_new_wifi_password_hint`「请输入新的wifi密码」；校验失败 Toast `ride3pro_wifi_password_invalid`「WIFI密码必须为任意8个字符」（`:814`/`:957`） |
| 存储管理 | `btn_storage_setting`（`storage_management`） | `:371` | 跳存储页 |
| 固件升级 | `btn_firmware_upgrade` + `tv_firmware_version`（`firmware_upgrade`） | `:384`、`:937` | `new Intent(this, UpgradeActivity.class)` |
| 恢复出厂设置 | `btn_factory_reset`（`factory_reset`） | `:397` → `:1039-1056` | 确认框 `CommonDialog`（标题 `factory_reset`，正文 `confirm_factory_reset`，按钮 `confirm`/`cancel`）→ `doFactoryReset()` |
| 重启设备 | `btn_reboot`（`reboot_device`） | `:411` → `:1128-1145` | 确认框 → `rebootDevice()` |
| Ride6 扩展设置（动态区） | `ride6_settings_section_title`「Ride6 扩展设置」/ `rv_settings` / `tv_settings_error` | `:122`、`:515` | 每条 item 点击 → `onRide6SettingClicked`（`:529`）：Type 0/3 → 选项弹窗；Type 1/4 → 直接执行；Type 2 → 输入框。错误行文案 `ride6_settings_load_failed_retry`「设置加载失败，点击重试」 |

**`M3DeviceSettingsActivity`（`activity_m3_device_settings`）** —— 单 `RecyclerView`，加载中文案 `loading_config`「加载配置中…」。行渲染与点击全在 `M3SettingsAdapter`（§1.4）：开关行用 `Switch`，多值行点击 → `dialog_setting_selection`（标题 `tvDialogTitle` = 行标题，条目 `item_setting_option`）；`GeneralMenuItem` 三行分别跳 `M3StorageSettingsActivity`、`UpgradeActivity`、`M3FactoryResetActivity`。

**`MoreSettingsActivity`（`activity_more_settings`）** —— 静态 14 行，机型裁剪见 §1.6。

| 控件（中文） | 布局 id | 代码位置 | 动作 |
|---|---|---|---|
| 功能设置 / 通用设置 | 两个分组标题 `function_settings`、`general_settings` | 静态 | — |
| 录像时长（默认值 `1分钟`） | `btn_circle_record_duration`/`tv_circle_record_duration` | §1.6 `Rec_Split_Time` 行 | 弹 `select_recording_duration`「请选择循环录制时间」 |
| 同步时间 | `btn_sync_time` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:429-431` → `:1230-1232` | `syncTime()`（`:2659`），见 §4 |
| 分辨率设置（默认值 `1080P+1080P`，**该条无中文**） | `btn_dpi_setting`/`tv_dpi_setting` | §1.6 `MEDIAMODE` 行 | 弹 `select_recording_resolution`「请选择录制分辨率」 |
| 紧急录像 | `btn_urgent_level`/`switch_urgent_level` | §1.6 `GSR_SENSITIVITY` | 开 precede 弹说明框 |
| 哨兵模式 | `btn_parking_level`/`switch_parking_level` | §1.6 `GSR_PARKING` | 同上 |
| 智能降风噪 | `btn_wind_noise`/`switch_wind_noise` | §1.6 `VCAPVQE` | 同上 |
| 录音开关 | `switch_record_voice` | §1.6 `AUDIO` | 直接写值 |
| 上下翻转（仅前摄）/ 左右翻转（仅前摄） | `switch_shangxia` / `switch_zuoyou` | §1.6 `FLIP` / `MIRROR` | 直接写值 |
| WiFi 模式（初值 `加载中...`） | `btn_wifi_mode`/`tv_wifi_mode_desc` | §1.6 `WIFI_DEAULT_STATE` | 弹 `wifi_mode_dialog_title`「设置 WiFi 模式」三选一 |
| 设备备注 / WIFI设置 / 存储设置 / 固件升级 / 恢复出厂设置 | `btn_device_name`+`tv_device_name` / `btn_wifi_setting` / `btn_storage_setting` / `btn_software_update`+`tv_soft_version` / `btn_reset_device` | `:1336`（升级）等 | `device_note`、`wifi_settings`、`storage_settings`、`firmware_upgrade`、`factory_reset`；升级 → `new Intent(this, UpgradeActivity.class)` |

**四个 M3 子页**（`M3WifiSettingsActivity` / `M3StorageSettingsActivity` / `M3FactoryResetActivity` / `M3DeviceSettingsActivity`）文案与接口见 §1.5，入口即上表 `GeneralMenuItem`。

### 3.7 回放页族（按机型分三条链路）

| 机型 | 页 | 布局 | 入口 | 下一步 |
|---|---|---|---|---|
| Ride3Pro/Ride6 | `Ride3ProStorageActivity` | `activity_ride3pro_storage` | 预览页 `cl_storage` → `DeviceDetailStorageEntryRoutePolicy`（`CAPABILITY_ENTRY`） | 日期 Tab（`tab_layout`/`view_pager`，行 `item_storage_list_video_date_title`）→ `Ride3ProHourDetailActivity` |
| Ride3Pro/Ride6（索引式） | `Ride3ProIndexedStorageActivity` + `Ride3ProIndexedStorageFragment` | `activity_ride3pro_indexed_storage`、`fragment_ride3pro_indexed_storage` | 能力探测判定（`Ride3ProStorageCapabilityProbe`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProIndexedStorageActivity.java:473` → `Ride3ProHourDetailActivity` |
| Ride3Pro/Ride6 | `Ride3ProHourDetailActivity` | `activity_ride3pro_hour_detail` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProHourDetailActivity.java:1654` | `:1609` `playbackLauncher.launch(Ride3ProDailyDetailActivity.createIntent(...))` |
| Ride3Pro/Ride6 | `Ride3ProDailyDetailActivity` | `activity_ride3_pro_daily_detail` | 上一条 | 播放器 `FFmpegPlayerView`；下载 → 下载列表；删除回传 extra `EXTRA_DELETED_FILE_INDEX`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/Ride3ProDailyDetailActivity.java:786`） |
| Ride5 | `StorageTabActivity` / `StorageManagerActivity` | `activity_storage_tab` / `activity_storage_manager` | 预览页 `cl_storage`（`LEGACY_STORAGE_TAB`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/fragment/StorageLocalItemFragment.java:205` → `DailyDetailActivity` |
| Ride5 | `DailyDetailActivity` | `activity_daily_detail` | 上一条 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/DailyDetailActivity.java:686` → `ShowPicsActivity`（照片）；`:732` → `Ride5HourlyPlaybackActivity`（视频） |
| Ride5 | `Ride5HourlyPlaybackActivity` → `Ride5HourDetailActivity` | `activity_ride5_hour_detail`（小时卡片 `item_ride5_hour_recording`、已选片 `item_ride5_selected_video`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackActivity.java:435` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourDetailActivity.java:988` 回到小时页 |
| M3 | `M3StorageActivity` | `activity_m3_storage` | 预览页 `ivGallery` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/p011m3/M3StorageFileFragment.java:261` → `M3VideoPlayActivity`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/p011m3/M3VideoPlayActivity.java:1010`） |
| 通用 | `VideoPlayActivity` | `activity_play_video` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/VideoPlayActivity.java:846`；下载完成后由 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity.java:561` 拉起 | 分享/转码 |

回放页公共控件（`activity_m3_storage` 与 `activity_ride3pro_storage` 同名 id）：

| 控件（中文） | 布局 id | 动作 |
|---|---|---|
| 内存卡 | `tv_title`（`title_memory_card`） | 页标题 |
| 已选0项 / 全选 | `tv_select_count`（`selected_items`）/ `btn_select_all`+`tv_select_all`（`select_all`） | 进入多选态，显示 `fl_select_toolbar`（`btn_close_select`） |
| 无文件 | `tv_empty_state`（`empty_folder`） | 空态占位 |
| 下载 | `btn_download`/`tv_download`（`download_button`） | 提交下载任务（§4） |
| 删除 | `btn_delete`/`tv_delete`（`delete`） | 批量删除（§4） |
| 下载中角标 | `fl_downloading`/`btn_downloading`/`tv_downloading_number` | 跳 `DownloadListActivity` |
| 上拉加载更多 | `tv_load_more_hint`（`ride3pro_storage_pull_to_load_more_hint`，中文表未覆盖，实为「继续上拉加载更多」） | `fragment_ride3pro_storage_list` |

### 3.8 下载 / 传输列表

| 页 | 布局 | 控件（中文） | 资源 id | 动作 |
|---|---|---|---|---|
| 任务列表 | `activity_download_list`（`refresh_layout`/`recycler_view`/`tv_state`） | 暂无任何下载任务 | `no_download_tasks` | 空态文本；行型 `item_download_list_title`、`item_download_list_video_date_title`、`item_download_list_video_item`、`item_download_list_item`；点击 → `DownloadListActivity` 的 `onTaskClick`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity.java:324`），完成后 → `ShowPicsActivity`（`:550`）或 `VideoPlayActivity`（`:561`） |
| 已下载 Tab | `fragment_album` | 已下载 / 已选0项 / 全选 / 您还没有授予文件管理权限 / 去授予 / 删除 | `downloaded`、`selected_items`、`select_all`、`no_file_permission`、`go_authorize`、`delete`（id `btn_request_permission`、`btn_delete`） | `btn_downloading`/`tv_downloading_number` → `DownloadListActivity`；`btn_request_permission` → 系统授权页 |
| 本地分页 | `fragment_local_download_list` | 同 `fragment_album` 底部动作区 | — | `LocalDownloadListFragment` |
| 存储管理 | `activity_storage_manager` | 存储卡状态良好 / 剩余容量：N/A / 距离上一次格式化 SD 卡已 %d 天 / 格式化内存卡 / 推出内存卡 / 存储卡须知 | `storage_card_status_good`、`remaining_capacity_na`、`sd_card_format_elapsed_days`、`format_memory_card`、`eject_memory_card`、`storage_card_notice`（id `tv_storage_status`、`tv_storage_remains`、`tv_storage_total`、`tv_sd_format_reminder`、`btn_restore_sdcard`、`btn_remove_sdcard`） | `btn_restore_sdcard` → 格式化确认框（`StorageManagerActivity$showFormatConfirmDialog$1$1`）；`btn_remove_sdcard` → 退出/断开 |

### 3.9 弹窗清单（自有，非库内 `abc_*`/`mtrl_*`）

| 弹窗类 | 布局 | 用途 |
|---|---|---|
| `CommonDialog` | `dialog_common`（`tv_title`/`tv_sub_title`/`btn_primary`/`btn_second`） | 通用二次确认（格式化、恢复出厂、重启都用它） |
| `ConnectDialog2` | `dialog_connect2` | Wi-Fi 未开提示 + 连接入口 |
| `ConnectHelperDialog` | `dialog_connect_helper` | 定位/存储权限引导 |
| `ConnectionProgressDialog` | `dialog_connection_progress` | 连接进度两行文案 |
| `DeviceWifiScanDialog` | `dialog_device_wifi_scan` + `item_device_wifi` | 附近设备热点列表 |
| `FirmwareDownloadDialog` | `dialog_firmware_download` | App 侧固件包下载进度 |
| `FirmwareUploadDialog` | `dialog_firmware_upload`（含自定义 `FirmwareUploadRingView`） | 固件包上传到相机 |
| `FirmwareUpdateBottomSheet` | `dialog_firmware_update` | 升级说明 + 确认 |
| `ProgressDialog` | `dialog_progress`（`ProgressBar` + `tv_msg`，id `tv_progress_msg`） | 「修改中…」「恢复出厂设置中…」 |
| `Ride3ProStorageLoadingDialog` | `dialog_ride3pro_storage_loading`（`Ride3ProLoadingCardView`） | 回放首屏骨架 |
| `Ride3ProDeleteConfirmDialog` | 复用 `dialog_common` | 删除确认 |
| `Alert`（`com.release.alert`） | `item_alert_view_bottom` 等 | INPUT / TWO_INPUT / 普通三态，设置页大量使用 |
| `M3SettingsAdapter` 选择弹层 | `dialog_setting_selection` + `item_setting_option` | M3 参数取值选择 |

## 4. 操作复现表

> 约定：端点语义/参数域见 `docs/08-官方APK全量逆向档案/01-TUWIN-档案.md 附录一（协议面）`（下称**协议面**），本节只写「哪个 UI 操作按什么顺序发哪些请求」。
> `成功判据` 里：Ride3Pro/Ride6 与 M3 统一为响应 `result == 0`（协议面 §2.1、§2.2）；Ride5 为响应体被 `Ride5CgiParser` 完整吃掉（协议面 §2.3「响应解析规则」）。
> 表内路径均为完整模板；`<…>` 为运行时值。

### 4.1 连接相机（首次添加 / 重连）

**前置状态**：手机已连到设备热点（或准备连）；App 有定位权限（Android 13+ 另需 `NEARBY_WIFI_DEVICES`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java:1719-1726`）。

| 步 | 动作 | 请求 / 调用 | 判据与失败分支 |
|---|---|---|---|
| 1 | 未开 Wi-Fi 时弹 `dialog_connect2` | 本地，无请求 | 文案 `wifi_disabled_dialog_title`「Wi-Fi 未开启」/`wifi_disabled_dialog_message`「请打开手机 Wi-Fi」/`wifi_disabled_confirm_action`「好的」 |
| 2 | 扫描设备热点 | `DeviceWifiScanner`（系统 scanResults，走 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog.java`） | 太快重点 → Toast `device_wifi_scan_too_frequent`「扫描频繁，请稍后重试」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java:817`） |
| 3 | 机型判定 | 用 SSID 正则匹配（协议面 §1.2），无请求 | 匹配不到 → 失败框（步 6） |
| 4a | Ride3Pro/Ride6 建会话 | 探测 `GET /api/device/info`（协议面 §2.1 #3）→ 预览起流 4 步见 4.15；进度文案序列 `ride3pro_connecting_device`「正在连接 Ride3 Pro 设备网络…」→ `ride3pro_authenticating_device`「正在进行 Ride3 Pro 设备认证…」→ `ride3pro_syncing_device_time`「正在同步 Ride3 Pro 设备时间…」→ `ride3pro_fetching_device_info`「正在获取 Ride3 Pro 设备信息…」 | 整体超时 `DEFAULT_CONNECTION_FLOW_TIMEOUT_MS = 30000`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java:64`）；重连场景用 `RECONNECT_CONNECTION_FLOW_TIMEOUT_MS = 8000`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java:116`）；Ride3Pro 单步最多 `RIDE3PRO_MAX_ATTEMPTS = 3` 次（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java:67`），每步失败/重试各停 `FAILURE_NOTICE_MS = 500` / `RETRY_NOTICE_MS = 500`（`:65-66`） |
| 4b | Ride5 建会话 | 探测 `GET cgi-bin/hisnet/getdeviceattr.cgi` → `checkconnect.cgi?-ip=` → `client.cgi?-operation=register&-ip=`（设备反连手机 `9002`）→ `getdeviceattr.cgi`；文案 `ride5_identifying_network`「正在识别 Ride5 / Ride5 Pro 设备网络…」→`ride5_registering_device`「正在注册 Ride5 / Ride5 Pro 设备…」→`ride5_verifying_online`「正在确认 Ride5 / Ride5 Pro 设备在线…」→`ride5_fetching_device_info`「正在获取 Ride5 / Ride5 Pro 设备信息…」 | 同上 30000 ms 总超时 |
| 4c | M3 建会话 | 探测 `GET /app/getproductinfo` → `GET /app/getmediainfo`（拿 RTSP `port`/`rawPath`）→ 建 TCP 控制通道 → `GET /app/getdeviceattr`；文案 `m3_detecting_http`「正在检测 M3 设备接口…」→`m3_validating_device`「正在验证 M3 设备型号…」→`m3_fetching_media_info`「正在获取 M3 媒体配置…」→`m3_connecting_control`「正在建立 M3 控制通道…」→`m3_fetching_device_info`「正在获取 M3 设备信息…」 | 中间态另有 `m3_device_validated`「M3 设备验证成功，正在建立连接...」与 `m3_socket_connecting`「正在建立 Socket 连接...」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java:990`、`:996`） |
| 5 | 成功 | 写 `preferenceHelper.cacheDevices`；`ConnectViewModel.updateDevice` | Toast `connection_success`「连接成功」（Ride 系，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java:1057`）/ `m3_connection_success`「M3 设备连接成功」（`:1118`） |
| 6 | 失败 | — | `Alert` 标题 `dialog_wifi_connection_failed`「连接失败」，正文 = `connection_failure_message` + 空行 + `connection_failure_help_prompt`「仍然无法连接？」+ `connection_help_action`「连接帮助」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java:1225`、`:1349-1359`，`SpannableString(string + "\n\n" + string2 + " " + string3)`）。⚠️ **`values-zh` 的该条文案不含 `%1$s`/`%2$s` 占位符**（中文原文：「无法与设备通信。请重启设备，待 Wi‑Fi 指示灯闪烁后，再次尝试连接。」），但代码仍按两个实参调用 `getString(id, wifiNamePattern, currentSSID)`（`:1353`）；英文默认值才带 `“%1$s”`。中文环境下 SSID 与「未连接」（`connection_wifi_not_connected`）会被丢弃。帮助框标题按机型取 `ride3pro_connection_help_title`「Ride3 Pro-连接帮助」/`ride5_connection_help_title`「Ride5-连接帮助」/`ride6_connection_help_title`/`m3_connection_help_title`「M3-连接帮助」（`:1400-1409`）→ `ConnectHelperActivity` |

**单步进度文案模板**（`ConnectionProgressDialog` 四态 `RUNNING/FAILED/RETRYING/WARNING`）：`connection_step_failed_format`「%1$s失败（%2$d/%3$d）」、`connection_step_failed_simple_format`「%1$s失败」、`connection_retrying_format`「正在重试%1$s（%2$d/%3$d）」、`connection_step_warning_format`「%1$s失败，将使用兼容模式继续」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java:964-980`）。步骤名取 `connection_step_ride3pro_connecting`「连接 Ride3 Pro 设备网络」等（`:1778+`）。检测中态文案 `detecting_connection`「检测连接中…」（`:933`）。

### 4.2 预览起流（Ride3Pro / Ride6）

**前置状态**：会话已建立、已进入 `DeviceDetailActivity`、`Ride3ProPreviewHandshakeCache` 未命中。

| 序 | 请求 | 参数值 | 判据 / 失败分支 |
|---|---|---|---|
| 0 | 本地 | `Ride3ProSessionExecutorResolver.refreshLegacyBindingIfNeeded()` | — |
| 1 | `GET /api/authdevice?seed=<long>` | `seed = kotlin.random.Random.nextLong(Long.MAX_VALUE)`，仅端侧随机数（协议面 §2.1 #1） | `result==0` **或 `result == -2`** 都算过；否则 `Ride3ProConnectionException.httpFailed("/api/authdevice", errorMessage)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:379-382`）。步骤名 `ride3pro_preview_step_device_auth`「设备认证」（`:240`） |
| 2 | `GET /api/vendor/send-time?year=&month=&day=&hour=&minute=&second=` | `Calendar.getInstance()` 本地时钟拆 6 个 Int（`:384-392`） | 失败**不抛**：`Timber.w("Ride3Pro：同步时间失败：" + errorMessage)`（`:400-402`），异常 → `Ride3ProPreviewPrepareWarning.SEND_TIME_FAILED`（`:446-449`）；步骤名 `ride3pro_preview_step_sync_time`「同步设备时间」（`:385`）。通过后 `Ride3ProPreviewHandshakeCache.markReady(key)`（`:406`）——同会话内再次起流会**跳过 1/2 两步**（日志 `Ride3Pro：当前预览会话已有握手缓存，跳过重复 auth/send-time`，`:256`） |
| 3 | `GET /api/setmode?mode=0` | `MODE_PREVIEW = 0`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:38`） | `result!=0` → `httpFailed("/api/setmode", …)`（`:421-424`）；步骤名 `ride3pro_preview_step_switch_mode`「切换预览模式」（`:409`） |
| 4 | `GET /api/record/start` | 无 | 失败**不阻断预览**：`Timber.w("Ride3Pro：预览准备时启动录像失败，继续尝试预览")` + `Ride3ProPreviewPrepareWarning.RECORDING_START_FAILED`（`:371-377`） |
| 5 | `rtsp://<host>:8080/?action=stream` | 端口 `RTSP_PREVIEW_PORT = 8080`（协议面 §2.4） | 起流失败 → Toast `ride3pro_preview_play_failed`「视频预览播放失败：%1$s」/`ride3pro_preview_prepare_failed`「视频预览启动失败：%1$s」，`%1$s` 兜底为 `operation_failed`「操作失败」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:1620-1623`、`:1697`、`:1780-1783`）。诊断 Toast 由 `Ride3ProPreviewDiagnosticToastGate.runIfEnabled` 控制（`DeviceDetailActivity$playRide3ProSteam$1$prepareResult$1.java`） |

**前置拦截**：`DeviceDetailRide3ProSnapshotPolicy` / `clearRide3ProPreviewRequestsIfPreparing()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:979`）在起流未完成前会丢弃排队请求。步 4 的 `startRecordingInPreviewMode` 内部实际先发 `GET /api/playback/stop`（无参）再发 `GET /api/record/start`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProRecordRepositoryImpl.java:299`、`:315`）。

### 4.3 开始录像 / 停止录像

| 机型 | 前置状态 | UI 入口 | 请求序列 | 成功判据 | 失败分支与文案 |
|---|---|---|---|---|---|
| Ride3Pro / Ride6 | 预览已起（模式 0） | **无独立录像键**：步 4.2 第 4 步自动起录；停录只在升级前触发 | 起：`/api/playback/stop` → `/api/record/start`；停：`GET /api/record/stop`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProRecordRepositoryImpl.java:433`） | `result==0`，随后本地记一条 `RecordingControlAction.STARTED/STOPPED` + `now()` 毫秒（`:315-334`） | `httpFailed("/api/record/start", errorMessage)` / `"/api/record/stop"`；异常文本 `Failed to start Ride3Pro recording` / `Failed to stop Ride3Pro recording`（`:237`、`:433`） |
| M3 | 已 `onPageResumed`、非切换模式中、存储可用 | `btnRecord`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/fragment/NormalRecordModeFragment.java:76-93`） | `GET /app/setparamvalue?param=rec&value=1`（起）/`value=0`（停）；`param` 名来自 `M3ApiService.DefaultImpls.setRecording$default` 的默认值 `"rec"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:153-161`） | `M3RecordResponse.result == 0`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl.java:1010-1036`），失败异常文本 `API returned error: <result>`；VM 侧 `_isRecording = (value==1)` 并 `startRecordingTimer()` / `stopRecordingTimer()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel.java:1535-1543`） | 切换中 → Toast `m3_wait_mode_switch_finish`「请等待模式切换完成」；等待回包中 → 直接忽略（日志 `onRecordClicked ignored (waiting for recording response)`，`:1523`）；存储不可用 → **不发请求**，走 `emitStorageBlockedPrompt` → `m3_storage_full_message` / `m3_storage_unavailable_message`（`:498`、`:505`）；请求中状态文本 `m3_recording_starting` / `m3_recording_stopping`（`:512`、`:519`） |
| Ride5 | 预览已起 | 无录像键（设备侧常录）；停录用于格式化/升级前 | `GET cgi-bin/hisnet/workmodecmd.cgi?-cmd=stop`（`Ride5SessionPort.command("stop", …)`，默认实现 `ensureRecordingStopped`） | 响应可被 `Ride5CgiParser` 完整解析 | `Ride5CgiException.BusinessError(<码>)` / `ProtocolError("Unrecognized RIDE5 CGI response (length=N)")` |

### 4.4 拍照（含连拍 / 缩时 / 定时 / 长曝 / 慢动作）

| 场景 | 机型 | 请求序列 | 成功判据 | 失败与文案 |
|---|---|---|---|---|
| 普通拍照 | M3（模式 16） | 先弹进度 `taking_photo`「拍照中...」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel.java:1597`）→ `GET /app/setparamvalue?param=snapshot&value=0`（`mo2801takePhotogIAlus` 默认 0，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:163-171`） | `result==0`；**HTTP 成功不等于拍成**，日志 `Take photo API called successfully, waiting for Socket confirmation...`（`:1623`）——真正完成靠 M3 TCP 通道回报，之后 `_isTakingPhoto=false` 并触发白闪 `photoFlashEvent` | 已有拍照在跑 → 忽略（`takePhoto ignored (already in progress)`，`:1611`）；存储不可用 → 不发请求，`emitStorageBlockedPrompt`；Socket 超时 → `startPhotoSocketTimeout` / `handlePhotoSocketTimeout`（`PhotoSocketTimeoutType`），文案由 `formatTimeoutLabel(timeoutMs)` 生成 |
| 连拍 | M3（模式 17） | 同普通拍照一条请求：`/app/setparamvalue?param=snapshot&value=0`；差异全在设备侧按 `continue_shot` 连拍（§1.4）。App 侧在回包后按 `currentMode == 17` 走多张等待分支（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel.java:1624`） | 同上 | 同上 |
| 缩时拍照·开始 | M3（模式 18） | `btnTimelapsePhoto` → `onTimelapsePhotoShutterClicked()`（`:2018-2024`，再点一次即停止）→ 状态文本 `starting_timelapse_photo` → `GET /app/setparamvalue?param=snapshot&value=1`（`:2063`+ 调用点） | `result==0` | 等待回包中重复点击 → 忽略（`onTimelapsePhotoShutterClicked ignored (waiting for response)`，`:2020`）；存储不可用 → 不发请求 |
| 缩时拍照·停止 | M3（模式 18） | 状态文本 `stopping_timelapse_photo` → `GET /app/setparamvalue?param=snapshot&value=0`（`:2139`、`:2143`） | `result==0` | 同上；退出页时 `stopTimelapsePhotoForExit()` |
| 定时拍照 | M3（模式 19） | `onTimedPhotoShutterClicked()`（`:2178-2185`）→ 文本 `starting_timed_photo`（`:2224`）→ `GET /app/setparamvalue?param=snapshot&value=1`；倒计时 `_timedCountdownSeconds` 走 `observeTimedCountdownUpdates`，`delay(500L)` 节拍（`:2973`、`:3165`） | `result==0` | 等待回包中 → 忽略；`_isWaitingTimedPhotoResponse` 门 |
| 长曝拍照 | M3（模式 20） | `onLongExposurePhotoShutterClicked()`（`:1646`）→ 文本 `taking_photo` → 同一条 `param=snapshot&value=1`，随后 `parseExposureDurationMs(...)` 解析 `shutter` 参数（§1.4 的 `1/100s` 形态）→ `startLongExposureCountdown(durationMs)`（`:1755`、`:1856`） | `result==0` 且倒计时走完 | 已在跑 → 忽略（`:1648`） |
| 慢动作 / 倍速 / 缩时录像 | M3（模式 24/25/23） | 先 `GET /app/mode?param=<24\|25\|23>`（§2.1），再走 4.3 的 `param=rec`；倍数与间隔用 `setparamvalue?param=multiple\|timelapse_rate\|timelapse_time&value=<index>`（§1.4） | 同 4.3 | 同 4.3 |
| 拍照 | Ride3Pro / Ride6 | **不发 HTTP**：`btn_screenshot` → `takePhoto()` → `takeRide3ProSnapshot()` → `videoView.saveSnapshot(file)`（RTSP 流上截帧，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:1202-1240`） | 截帧文件写盘成功 → Toast `photo_success`「拍照成功」；文件路径由 `DeviceDetailRide3ProSnapshotPolicy.buildSnapshotFile(0L)` | 无存储权限 → `DownloadUtil.showAskPermissionDialog`；永久拒绝 → `showNeverAskDialog`；否则 Toast `photo_failed`「拍照失败」（`:1213-1218`）。⚠️ `GET /api/capture` 在整份反编译源码中**没有任何 UI/仓储调用方**（协议面 §2.1 #2 登记的「被 `Ride3ProRecordRepositoryImpl` 使用」不成立，见 §6 纠正项） |
| 拍照 | Ride5 | 进度 `taking_photo` → `GET cgi-bin/hisnet/workmodecmd.cgi?-cmd=trigger`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:1164`） | CGI 解析通过即算成功；再按 `mediaMode`（小写后含 `2k`）追加分辨率说明，Toast `photo_success` + `photo_resolution_2k_mode`「（2K模式下拍照分辨率为 480P）」或 `photo_resolution_current_mode`「（当前模式下拍照分辨率为 1080P）」（`:1173-1186`） | 异常 → 日志 `RIDE5 photo command failed: session=%s` + Toast `photo_failed`（`:1190-1191`） |

### 4.5 切换工作模式

| 机型 | 前置 | 请求 | 判据 | 失败 |
|---|---|---|---|---|
| M3 | `onModeSelected(modeId)` 5 道前置拦截（§2.1 第 422-427 行区间） | `GET /app/mode?param=<modeId>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:109-110`，`modeId` ∈ §2.1 的 10 个常量） | `M3SetModeResponse.result == 0` → `_appliedMode = modeId`，再 `delay(1000L)` 收尾（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel$startModeSwitch$1$1$1.java:57`）；收尾里 `applyPendingModeIfNeeded()` + `verifyFinalModeAfterQueueDrained()` | 回滚 `_currentMode = _appliedMode` + `_modeSwitchFailedEvent`，同样 `delay(1000L)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel$startModeSwitch$1$2$1.java:50`）；loading 超时 `MODE_SWITCH_LOADING_TIMEOUT_MS = 10000`；Toast `m3_wait_stop_recording`「请先停止录像」/`m3_wait_photo_finish`「请等待拍照结束」/`mode_switch_too_frequent`「切换模式太频繁」 |
| Ride3Pro / Ride6 | 进入预览或回放前各切一次 | `GET /api/setmode?mode=0`（预览/录像）、`mode=2`（回放） | `result==0` | `httpFailed("/api/setmode", errorMessage)`；Ride5 无整数 mode，见 §2.3 |
| Ride5 | — | `GET cgi-bin/hisnet/workmodecmd.cgi?-cmd=<str>`（词表静态不可枚举，§2.3） | CGI 解析 | `BusinessError` / `ProtocolError` |

### 4.6 回放：按日期浏览与翻页（Ride3Pro / Ride6）

**前置状态**：已连接、会话有效。入口点击后**先发 2 条**决定走哪条链路：

| 序 | 请求 | 参数 | 用途 |
|---|---|---|---|
| 1 | `GET /api/setmode?mode=2` | `MODE_PLAYBACK = 2`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProStorageCapabilityProbe.java:32`） | 切回放态（`:160`） |
| 2 | `GET /api/playback/filecount` | 无；常量 `FILE_COUNT_ENDPOINT = "/api/playback/filecount"`（`:29`） | 取 `day_count` / `total_file_count` / `next_file_index` / `day_list[]` |
| 3 | 路由判定 | `Ride3ProStorageCapabilityRouteResolver.resolve(dayCount)`：**`day_count == null` → `LEGACY`，否则 `INDEXED`**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProStorageCapabilityRouteResolver.java:16-19`） | LEGACY → `Ride3ProStorageActivity`；INDEXED → `Ride3ProIndexedStorageActivity`（`:95-150`、`:139-147`） |
| — | 设备串扰保护 | 步 2 前后各取一次 deviceKey，不等则失败：`Ride3Pro device changed during capability probe: expected=…, current=…`（`:135-138`）；`info == null` → `Ride3Pro FileCount response info is missing`（`:130-132`） | — |
| — | 失败 | 两条各独占一次 `httpFailed(endpoint, errorMessage)`（`:127`、`:185`），页面上表现为错误行/Toast `loading_failed`「加载失败」 | — |

**索引式日期/小时/文件三级**：

| 层级 | 请求 | 参数 | 翻页 |
|---|---|---|---|
| 日期目录 | `GET /api/playback/dayinfo?date=<YYYYMMDD>` | 整数日期，合法域 `10000000..99999999`（`Ride3ProPlaybackIndexValidator`，协议面 §2.1 #16） | 一次性返回 `hour_count` / `hour_list[]`（每项 `hour`/`file_count`/`last_file_index`） |
| 小时文件 | `GET /api/playback/filelist?mode=2&file_index=<start>` | `mode` 传 `2`；`file_index` 为**起始索引**，页大小 `PAGE_SIZE = 16`（`Ride3ProHourScanCursor.PAGE_SIZE`、`StorageSdcardItemFragment.RIDE3PRO_PAGE_SIZE`） | `Ride3ProHourFilesLoader.load(hourKey, lastFileIndex)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProHourFilesLoader.java:93`）循环翻页直到收满 `file_count`；`MAX_FILE_INDEX = 9999`（`:45`）。返回项缺 `file_index` 或越界 → `IllegalArgumentException("file_list[i].file_index must be in 0..9999 for pagination: <v>")` |
| 上拉加载 | 同上，`file_index` 递增 16 | — | UI 提示 `ride3pro_storage_pull_up_to_load_more`（中文表未覆盖，默认文案即中文「继续上拉加载更多」，`fragment_ride3pro_storage_list`） |

**旧式（LEGACY）链路**：`Ride3ProStorageViewModel.loadFiles(forceRefresh, preserveExistingFiles)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProStorageViewModel.java:208`）+ `loadNextPage`（`Ride3ProStorageViewModel$loadNextPage$1.java`），同样 `filelist?mode=2&file_index=`。

**回放态恢复**：`Ride3ProIndexedPlaybackModeAction`（`setMode(2)` 封装）与 `Ride3ProIndexedPlaybackModeRecoveryController`；退出回放页时 `Ride3ProStorageResumePlaybackModePolicy` 决定复不回回放态。

### 4.7 回放（M3 / Ride5）

| 机型 | 请求序列 | 判据 | 说明 |
|---|---|---|---|
| M3 | `GET /app/getfilelist`（无参，一次返回全部 `folder[]/files[]`，**无分页**）→ 逐条 `GET /app/getthumbnail?file=<name>` → 播放用 `rtsp://<控制 host>:<getmediainfo 的 port>/<path>/<file>` | 两条均 `result==0` | 缩略图命中本地缓存 `M3ThumbnailCache` 时直接用文件路径，不命中**不请求**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:66-75`，未命中即 `unavailable("M3 thumbnail")` → 返回空串并打 warn `DeviceUrlBuilder: M3 thumbnail skipped because EndpointGrant is unavailable`，`:252-255`）。RTSP 的 host 被强制替换为控制 host（协议面 §2.4） |
| Ride5 | `GET cgi-bin/hisnet/getdircapability.cgi` → `getdirfilecount.cgi?-dir=<目录>` → `getdirfilelist.cgi?-dir=<目录>&-start=<i>&-end=<j>` → 播放/下载按 `relativePath` | `getdirfilelist` 走 `parseFileList`：每段必须过 `isConfirmedFileListPath`，否则 `ProtocolError("Unrecognized RIDE5 file list response (length=N)")`；空串或 `Success` 视为「零文件」成功 | 小时卡片 `item_ride5_hour_recording`；`Ride5HourlyPlaybackController` 驱动。**Ride5 无缩略图端点**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:77-80` → `unavailable("RIDE5 thumbnail")`） |

### 4.8 下载（含续传参数）

| 机型 | 序列 | 参数与门限 |
|---|---|---|
| Ride3Pro / Ride6 | 勾选 → 提交任务（列表见 `activity_download_list`） → `GET /api/playback/rawdata?file_index=<n>`（**流式，非 Retrofit 声明**，由 OkHttp 直拼，协议面 §2.1 #20） | 续传用 **query 参数 `offset=<已下字节>`** 而不是 HTTP `Range`：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java:233-238`；固件门限低于 `v1.20260708.101448` 直接拒绝并记 `reason=legacy_firmware`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1602-1606`）；重试上限 `MAX_RETRY_COUNT = 5`；断点校验 `checkpoint.offset > 0 && == 本地文件长度 && sourceFingerprint 匹配`（详见 `docs/03` §1.6 与传输附录） |
| M3 | 回放页下载 → `GET /app/getfilelist` 已在手，走媒体 grant 的 RTSP/HTTP 通道 | `DeviceUrlBuilder.buildM3DownloadUrl(fileName)` 在 `EndpointGrant` 不可用时返回空串（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:61-64`），任务不入队 |
| 通用（UI 侧） | 未选 → Toast `please_select_videos_to_download`「请选中要下载的视频」；无权限 → `no_file_management_permission_download`「未授予文件管理权限，无法下载」/`no_download_permission`「没有下载权限」；入队后 → `files_added_to_download_list`「%d个文件已加入下载列表」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProHourDetailActivity.java`，字符串常量取自 `C1870R.string.*`） | 传输中角标 `fl_downloading`/`tv_downloading_number` |

### 4.9 删除与批量删除

| 机型 | 序列 | 判据 | 文案 |
|---|---|---|---|
| Ride3Pro / Ride6 | 确认框 → **逐个** `GET /api/playback/delete?file_index=<n>`（`Ride3ProHourDetailViewModel.deleteFiles(List)`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/ride3pro/Ride3ProHourDetailViewModel.java:173-186`） | 每条 `result==0` | 确认框标题 `dialog_confirm_delete_videos`「确定删除这 %d 个视频吗？」+ 正按钮 `confirm` / 负按钮 `cancel`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/Ride3ProDeleteConfirmDialog.java:29-34`）；删除中遮罩 `ride3pro_hour_delete_loading_title`「正在删除」+ `ride3pro_hour_delete_loading_message`「请稍后，请不要离开页面」；结果 `delete_success`「删除成功」/`delete_failed`「删除失败」；未选 → `please_select_videos_to_delete`「请选中要删除的视频」；空/异常 → `operation_failed`；全选态文案 `selected_count_format`「已选%d项」/`select_all`「全选」/`cancel_select_all`「取消全选」 |
| Ride3Pro 删除能力门 | `Ride3ProPlaybackDeleteCapabilityResolver.resolve(...)`：能力未知时抛 `IllegalArgumentException("unknown Ride3Pro playback delete capability: <v>")`；`LEGACY_SUPPORTED` 表示旧固件可删（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/Ride3ProPlaybackDeleteCapabilityResolver.java:20-34`） | — | 不可删时删除按钮隐藏（`Ride3ProPlaybackDeleteSelectionGate`） |
| M3 | `GET /app/deletefile?file=<文件名>`（`M3VideoPlayActivity.deleteFile()`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/p011m3/M3VideoPlayActivity.java:895-908`） | `result==0` | 文件名为空 → **Toast 裸英文串 `"File name is empty"`（非资源）**（`:899`）；请求期间 `btnDelete.setEnabled(false)` |
| Ride5 | `GET cgi-bin/hisnet/deletefile.cgi?-name=<文件名>`，批量=逐条 | CGI 解析 | 失败按 `BusinessError` 码提示 |

### 4.10 格式化 SD 卡

| 机型 | 前置 | 序列 | 判据 | 成功/失败文案 |
|---|---|---|---|---|
| Ride3Pro / Ride6（存储管理页） | 已进 `StorageManagerActivity`（`activity_storage_manager`） | 确认框 `dialog_confirm_format_memory_card`「确定要格式化存储卡？」→ 先 `captureRide3ProFormatScope()` 锁设备键 → `GET /api/system/formatsd`（**该路径独享 60 s 超时**，协议面 §2.1 #13 / §6）→ 成功后 `SdCardFormatReminderUseCase.recordFormatSuccess(device)` + `PlaybackCacheClearCoordinator.clearDevice(deviceKey)` → 再 `getSDStatus()`（即 `GET /api/sd/info`）刷新 | `result==0` 且设备键未变；变了 → `IllegalStateException("Ride3Pro device changed during SD card format: expected=…, current=…")` | Toast `format_success`「格式化成功」，`setResult(-1, extra FORMAT_SUCCESS=true)`；失败 → `showRide3ProFormatFailure(exception)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/StorageManagerActivity.java:315-364`） |
| Ride3Pro / Ride6（Ride6 菜单里的 `Format` 项） | 设置页动态区 | **不走 setparameter**，直接 `GET /api/system/formatsd`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:239-242`；判定 `isFormatSetting` 用英文名 `"Format"`） | `result==0` | 失败 → `IllegalStateException("R6 setting update failed: id=…, …")`（`:272-278`） |
| M3 | `M3StorageSettingsActivity` 单行 | `GET /app/sdformat`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3StorageSettingsActivity.java:156`+`formatSdCard()`；确认文案 `dialog_confirm_format_memory_card`） | `result==0` | `format_success` / `format_failed`「格式化失败」 |
| Ride5 | `StorageManagerActivity`（旧链路） | `GET cgi-bin/hisnet/workmodecmd.cgi?-cmd=stop` → `GET cgi-bin/hisnet/sdcommand.cgi?&-format`（**URL 逐字节**：`?` 后紧跟 `&`，`-format` 为无值开关，协议面 §2.3 #19） | 两步都要 CGI 解析通过 | 任一失败抛 `BusinessError`/`ProtocolError`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/StorageManagerActivityKt.java:41-81`） |

### 4.11 恢复出厂设置

| 机型 | 序列 | 判据 | 文案 |
|---|---|---|---|
| Ride3Pro / Ride6 | 确认框（`CommonDialog`，标题 `factory_reset`，正文 `confirm_factory_reset`，按钮 `confirm`/`cancel`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsActivity.java:1039-1056`）→ 进度框 `factory_resetting`「恢复出厂设置中…」→ `GET /api/menu/setparameter?id=factory_reset`（**无 `value`**；id 推导见 §1.2.2，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:254`） | `result==0`；成功后把缓存 WiFi 密码复位为 `ConnectedDevice.DEFAULT_WIFI_PASSWORD`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsCompatibilityPolicy.java:46-56`） | 成功 `factory_reset_success_restart`「恢复出厂设置成功，等待设备重启成功后重新连接WIFI」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsActivity.java:881`、`:1102`）；失败 `factory_reset_failed_with_code`「恢复出厂设置失败：%s」（`:1107`） |
| M3 | `M3FactoryResetActivity`（确认文案 `confirm_factory_reset`）→ `GET /app/reset` | `result==0` | 同 Ride 系文案 |
| Ride5 | `MoreSettingsActivity.resetDevice()`：进度 `factory_resetting` → `GET cgi-bin/hisnet/reset.cgi` | **`parseReset`：空响应即成功**（协议面 §2.3 `parseReset` 规则） | 成功弹 `Alert`：标题 `factory_reset_success_restart`，按钮 `i_understand`「我知道了」→ 点击后 `ActivityStack.popAllActivityExceptOne(HomeActivity.class)`；失败 Toast `factory_reset_failed_with_code`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:2685-2730`） |

### 4.12 改 WiFi 名称 / 密码

| 机型 | 前置 | 序列 | 判据 | 文案与校验 |
|---|---|---|---|---|
| Ride3Pro / Ride6（只改密码） | 设置页 `WIFI` 行或动态区 `Password` | 输入框（`Alert.INPUT`，hint `input_new_wifi_password_hint`「请输入新的wifi密码」）→ 进度 `modifying`「修改中…」→ `GET /api/menu/setparameter?id=wifi_passwd&value=<新密码>` | `result==0` | 校验：`codePointCount == 8`（§1.1 `Ride3ProWifiSettingsPolicy`）→ 不满足 Toast `ride3pro_wifi_password_invalid`「WIFI密码必须为任意8个字符」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsActivity.java:814`、`:957`）；成功 `modify_success`「修改成功」+ 二次提示框（`wifi_password_settings` 标题）；失败 `modify_failed_with_code`「修改失败：%s」（`:891`、`:1018`） |
| Ride 系（名+密码一起改，`MoreSettingsActivity`） | 点 `WIFI设置` 行 | `Alert.Type.TWO_INPUT` 标题 `modify_wifi_name_password`「修改WiFi名称和密码」→ **先**写本地镜像 `preferenceHelper.updateDeviceWifiInfo(oldSsid, newName, newPwd, oldBssid)`，失败即 Toast `modify_failed`「修改失败」并**不发请求** → `Ride5WifiRenameRefreshGate.markPending()` → `GET cgi-bin/hisnet/setwifi.cgi?-wifissid=<名>&-wifikey=<密码>` | CGI 解析通过 | 名称校验 `wifi_name_invalid`「WIFI名称只能包含字母和数字，字符_或-，且长度为8~32个字符」；密码校验 `wifi_password_invalid`「WIFI密码只能包含字母和数字，字符_或-，且长度为8~20个字符」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:1280-1310`、`2455-2518`）；成功 `modify_success`；失败 `modify_failed_with_code` |
| M3 | `M3WifiSettingsActivity` 两行分别改 | 改 SSID：`GET /app/setwifi?wifissid=<新名>`（`wifipwd` 传 `null`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:140-151`）；改密码：`GET /app/setwifi?wifipwd=<新密码>`（`wifissid` 传 `null`） | `result==0` | 校验**只判非空**（§1.5）；改 SSID 成功 `modify_success`；改密码成功 `wifi_settings_take_effect_after_restart`「新的设置将在WIFI重启后生效」；失败 `modify_failed_with_code` |
| Ride6 菜单里的 `WifiName` 项 | 动态区 | `GET /api/menu/setparameter?id=wifi_name&value=<新名>`（§1.2.2） | `result==0` | 同上；注意 `wifi_name`/`wifi_passwd` 由**分区名 + 项名**推导，不读 XML 的 `<ID>` |

### 4.13 对时（同步时间）

| 机型 | 请求 | 参数值 | 判据 | 文案 |
|---|---|---|---|---|
| Ride3Pro / Ride6 | `GET /api/vendor/send-time?year=&month=&day=&hour=&minute=&second=` | `Calendar.getInstance()` 的 6 个本地字段，**无时区参数** | 预览起流路径里失败只打 warn（4.2 步 2）；设置路径失败 → `httpFailed` | 无独立提示（静默） |
| M3 | 两条：`GET /app/setsystime?date=<yyyyMMddHHmmss>` + `GET /app/settimezone?tz=<整数小时>` | 日期串用**设备时区**格式化（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java:1341-1343`，`M3_TIME_PATTERN = "yyyyMMddHHmmss"`）；`tz = TimeZone.getRawOffset() / 3600000`（`:1345`） | `result != 0` → `Exception("Failed to sync M3 device time: " + info)` / `"Failed to sync M3 device timezone: " + info` | — |
| Ride5 | `GET cgi-bin/hisnet/setsystime.cgi?-time=<yyyyMMddHHmmss>` | `new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date())`（**`Locale.US`，与 M3 不同**，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:2636`） | CGI 解析 | 成功 Toast `sync_success`「同步成功」；失败 `sync_failed_with_code`「同步失败：%s」（`:2649`、`:2653`）；入口 `btn_sync_time`（文案 `sync_time`「同步时间」，`:429-431`） |

### 4.14 重启设备

| 机型 | 序列 | 判据 | 文案 |
|---|---|---|---|
| Ride3Pro / Ride6 | 仅当 `/api/device/info` 的 `features` 含 `"reboot"` 才出现该行（§1.2.4）→ 确认框（标题 `reboot_device`，正文 `confirm_reboot_device`… 走 `CommonDialog`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsActivity.java:1128-1145`）→ `GET /api/reboot` | `result==0` | 成功 Toast `reboot_device_success`「重启命令已发送，请等待设备启动后重新连接 Wi-Fi。」（`:1190`）；失败 `modify_failed_with_code`（`:1195`）；进度框 `modifying` |
| M3 / Ride5 | 无独立重启端点声明；改 WiFi 密码后的生效提示即引导用户自行重启（`wifi_settings_take_effect_after_restart`） | — | — |

### 4.15 固件升级（用户可见流程）

**前置状态**：`UpgradeActivity` 已 `setDefaultBar(getString(title_firmware_upgrade))`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java:412`），页面先显 `checking_update`（`:461`）。

| 序 | 机型 | 请求 / 动作 | 判据与文案 |
|---|---|---|---|
| 1 | 通用 | 选包（本地文件）+ 校验包名 | 包不合法 → Toast `loading_failed`「加载失败」（`:453`） |
| 2 | Ride5 | `GET cgi-bin/hisnet/checkupgradepktinfo.cgi?-model=<upgradeModel>&-softversion=<newVersion>&-pktlen=<file.length()>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$checkUpgradePktInfo$1$response$1.java:53-62`；`newVersion` 取自 `currentBean.getNewVersion()`，`-pktlen` 是**文件字节数字符串**） | CGI 解析；失败按 `BusinessError` 码提示 |
| 3 | 通用 | 点击升级 → `Alert`：标题 `tips`「小贴士」，正文 `upgrade_firmware_warning`，正按钮确认 / 负按钮 `cancel`（`:493-498`）→ 30 秒倒计时 `COUNTDOWN_SECONDS = 30`（`:96`） | 用户可在倒计时内取消 |
| 4 | Ride3Pro / Ride6 | **先停录**：`GET /api/record/stop` → 失败 Toast `pause_recording_failed`（`:636`、`:726`、`:808`）；再 `POST /api/firmware/upload?md5sum=&model=&hw=&sw=`（Header `Content-Type: application/octet-stream`、`Content-Encoding: identity`、`Connection: close`；Body 为原始字节，协议面 §2.1 #27） | `result==0`；上传过程 `FirmwareUploadDialog`（`dialog_firmware_upload` + `FirmwareUploadRingView`）；`UpgradeDevice.UploadListener.onUploading/onUploadSuccess/onUploadFailed`（`:521-561`） |
| 5 | M3 | `POST /upload/{savepath}/{filesize}`，`savepath` 固定 `"mnt/sdcard"`（`@Path(encoded=true)`）、`filesize` = 文件字节数 | `result==0`；结果态展示 `M3_RESULT_DISPLAY_MILLIS = 1500` ms 后动作（`:100`） |
| 6 | 通用 | 升级进度对话框 `showProgressDialog(getString(loading_ellipsis))`（`:584`）；成功/失败文案与 `OtaFailurePolicy`、`UpgradeInstallCopyPolicy` 相关，语义归 OTA 附录 | — |

## 5. 状态与轮询

### 5.1 被轮询的端点与间隔（全部为源码里的字面常量）

| 机型 | 端点 | 轮询者 | 间隔 / 重试 | 起停时机 |
|---|---|---|---|---|
| Ride3Pro / Ride6 | `GET /api/device/status` | `Ride3ProPollingStatusChannel`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java`） | `DEFAULT_INTERVAL_MS = 30000`、`DEFAULT_MAX_RETRY_COUNT = 3`、`DEFAULT_RETRY_DELAY_MS = 500`（`:37`、`:40`、`:43`，三者均标 `@Deprecated`；实际值由构造参数 `intervalMs`/`maxRetryCount`/`retryDelayMs` 注入，`:46`、`:48`、`:51`） | 会话激活后由 `Ride3ProDeviceAdapterSession` 驱动（`:316`、`:573`）；失败重试日志 `Ride3Pro: session 心跳失败，准备重试 <n+1>/<maxRetryCount>, session=…, routeRevision=…`（`:257`） |
| Ride3Pro / Ride6 | `GET /api/device/status`（轻量检测） | `Ride3ProHeartbeatManager` → `Ride3ProDeviceRepository.detectConnectionLightweight(Network)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/domain/repository/Ride3ProDeviceRepository.java:34`） | `HEARTBEAT_INTERVAL_MS = 30000`、`MAX_RETRY_COUNT = 3`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:36-37`） | `startForSession(scope, currentSsid, globalSsid, cachedDevices)`；**只对 Ride3Pro/Ride6 启动**：`Ride3ProHeartbeatPolicy.shouldStart(...)` 判定机型 ∈ `{RIDE3PRO, RIDE6}`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatPolicy.java:23-25`），机型解析顺序 `ConnectUtil.getCurrentSSID()` → `GlobalData.getCurrentSSID()` → `cachedDevices` 遍历（`:28-49`）。前后台由 `Ride3ProHeartbeatAppVisibilityController.onActivityStarted()` / `onActivityStopped(isChangingConfigurations)` / `confirmBackground()` 控制（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatAppVisibilityController.java:45`、`:56`、`:62`）→ **退到后台即停心跳** |
| Ride3Pro / Ride6 | `GET /api/rtspstatus?seed=<long>` | `Ride3ProSessionApiService`（协议面 §2.1 #15） | 与起流同节拍，非独立定时器 | 预览存活期间 |
| M3 | `GET /app/getbatteryinfo`、`/app/getsdinfo`、`/app/getcurmode` | **主要不是轮询**：`M3DeviceDetailViewModel` 的 `observeBatteryUpdates` / `observeSDCardUpdates` / `observeRecordingTimeUpdates` / `observeCaptureUpdates` 订阅 TCP 控制通道推送（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel.java`，方法名见同文件 `@Metadata.d2`） | 事件到达后 `delay(500L)` 去抖/节拍（`:2973`、`:3165`） | 页面 `onPageResumed` / `onPagePaused` |
| M3 | `GET /app/getsdinfo`（HTTP 兜底轮询） | `M3DeviceDetailViewModel.startSDCardPolling()`（`:1310-1313`）→ 内部 `while(isActive)` 调 `mo2791getSDInfoIoAF18A` | **`delay(5000L)`**（循环体 jadx 反编译失败退回 smali 形态，常量在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel.java:1449` 的 `r6 = 5000(0x1388, …)`，`:1450` 即 `DelayKt.delay(r6, r11)`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailActivity.java:2909` 进页面时 `startSDCardPolling()`；`stopSDCardPolling()` 离场 |
| Ride5 | `GET cgi-bin/hisnet/getbatterycapacity.cgi` | `BatteryView` 自带循环 `refreshRide5Battery()` | `delay(60000L)`**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/BatteryView.java:398`，smali 形态 `r4 = 60000(0xea60, …)`，`:399` 即 `DelayKt.delay(r4, r7)`） | View attach / `deviceSessionId` 有效期间 |
| Ride5 | 状态**推送**（非轮询） | 设备反向回调 `9002`（协议面 §2.4），App 侧仅识别 2 条串：`"\"arg2\":\"NORM_REC\""`、`"\"eventid\":\"STATEMNG_SWITCH_WORKMODE\""` | 无间隔 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackMessagePolicy.java:15-16` |
| 全机型（首页） | 无 HTTP（系统网络回调驱动） | `ConnectFragment.scheduleFirmwareReconnectRefresh(initialDelayMillis)` | `RECONNECT_POLL_INTERVAL_MILLIS = 1000`、`RECONNECT_RETRY_DELAY_MILLIS = 2000`、`FIRMWARE_RECONNECT_TIMEOUT_MILLIS = 120000`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:101-103`、`:633`） | 固件重启后等待设备热点回来，最长 120 s |
| M3（控制通道重连） | — | `M3DeviceDetailViewModel.startSocketReconnectIfNeeded` | `delay(300L)` 一轮（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel$_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel$startSocketReconnectIfNeeded$job$1.java:172`、`:254`） | 见 §5.4 |
| 播放器（关流确认） | RTSP | `FFmpegPlayerView.stopAndAwaitRtspClosed` | `RTSP_CLOSE_POLL_INTERVAL_MS = 20`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:51`） | 停流时 |
| 转码进度 | — | `Ride3ProLocalVideoTranscoder` | `PROGRESS_POLL_INTERVAL_MILLIS = 50`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/Ride3ProLocalVideoTranscoder.java:43`） | 分享转码时 |

### 5.2 状态字段取值 → UI 变化

#### 5.2.1 Ride3Pro / Ride6：`/api/device/status` 的 7 个字段只有 4 个真正驱动 UI

响应字段（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProDeviceStatusInfo.java:14-33`，全部 `Integer?`，缺字段= null 不报错）：`adapter_status`、`battery_percent`（别名 `battery_level`）、`current_mode`、`exception_flags`、`hdr_chk_cnt`、`mode_active`、`recording_time`。

链路：轮询/心跳 → `Ride3ProStatusStore.update(sessionId, routeRevision, batteryPercent, adapterStatus, exceptionFlags, hdrChkCnt)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProStatusStore.java:56`、`updateIfAvailable :81`、`updateFromStatus :147`）→ `StateFlow<Ride3ProStatusSnapshot>`（同文件 `:33`）→ `DeviceDetailActivity.renderRide3ProStatusSnapshot(snapshot)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:2849`）。

`Ride3ProStatusSnapshot` 只有 6 个成员：`sessionId`、`routeRevision`、`batteryPercent`、`adapterStatus`、`exceptionFlags`、`hdrChkCnt`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProStatusSnapshot.java:12-17`）。反向构造回 `Ride3ProDeviceStatusInfo` 时 **`current_mode`、`mode_active`、`recording_time` 一律填 null**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivityKt.java:14`，形参位 `(currentMode=null, modeActive=null, batteryLevel=bp, adapterStatus=as, recordingTime=null, exceptionFlags=ef, hdrChkCnt=hc)`）。

> **结论（可据以裁剪实现）**：`current_mode` / `mode_active` / `recording_time` 三个字段在官方 App 里被解析但**不驱动任何 UI**。

| 字段 | 取值 | UI 变化 | 代码 |
|---|---|---|---|
| `battery_percent` | `0..100`（缺字段=null → 不刷新） | `BatteryView` 电量填充 + `layout_battery` 的 `tv_battery`（默认文案 `99`）；M3 预览页 `tvBatteryLevel` + `_batteryColor` + `ivCharging`（充电态） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:699-722`（含 `setSsid`、`setDeviceType`、`setDeviceSessionId`、可见性门）；`BatteryViewVisibilityPolicy.shouldShow(type)` |
| `adapter_status` | 整数；**App 只透传，不解释**（未见任何 `== n` 分支） | 无直接 UI；仅随快照存 `Ride3ProStatusStore` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProStatusSnapshot.java:13` |
| `exception_flags` **bit0** | `(flags & 1) != 0` | 显示 `cl_camera_abnormal`（标题 `ride3pro_camera_abnormal_title`「摄像头异常」/描述 `ride3pro_camera_not_detected_hint`「未检测到CMOS传感器，请检查设备」），点击弹异常框 | 常量 `SENSOR_BAD_MASK = 1`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailRide3ProExceptionPolicy.java:15`）、判定 `:29` |
| `exception_flags` **bit1** | `(flags & 2) != 0` | 存储异常优先级最高 → `DeviceDetailStorageException.STORAGE_FULL` → SD 卡卡片类型 `STORAGE_FULL`，标题 `ride3pro_storage_full_title`、描述 `ride3pro_storage_full_hint` | `SD_FULL_MASK = 2`（同文件 `:14`）、`:30-32`；文案选择 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:3141`、`:3190` |
| `exception_flags` **bit2** 或 `hdr_chk_cnt > 0` | `(flags & 4) != 0 \|\| hdrChkCnt > 0` | `cl_recording_write_error` 卡片（`ride3pro_recording_write_error_title`「录像写入异常」/ `ride3pro_recording_write_error_hint`「发现 %d 个异常录像文件，请检查SD卡」，`%d` = `abnormalRecordingCount`） | `RECORDING_WRITE_ERROR_MASK = 4`（`:13`）、`:28`；渲染 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:3253`、`:3260` |
| `hdr_chk_cnt` | 整数，`coerceAtLeast(0)` 后既参与写异常判定，也当作 `abnormalRecordingCount` 展示 | 同上 | `:26-28` |

#### 5.2.2 SD 卡状态（三套语义，**数值不通用**）

来源端点：Ride3Pro/Ride6 `GET /api/sd/info`（`info.status/total/free`）、M3 `GET /app/getsdinfo`、Ride5 `getsdstatus.cgi`（旧链路把字段放在 map 里：`sdstatus`、`sdfreespace`、`sdtotalspace`）。归一化到 `StorageSdInfoUiModel(uiStatus, freeGb, totalGb)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/StorageSdInfoPolicy.java`）：

| 机型 | 线上 `status` | → `uiStatus` | 卡片类型 | UI 文案 |
|---|---|---|---|---|
| Ride3Pro/Ride6 | `0` | **`1`（正常）** | `NORMAL` | `preview_storage_card_title` + `preview_storage_used_available_total_format`（三个 `%s` 依次 = 已用 GB、可用 GB、总 GB，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:3193`） |
| Ride3Pro/Ride6 | `2` | **`0`（无卡）** | `NO_CARD` | `memory_card_error`「内存卡异常」+ `ride3pro_memory_card_missing_hint`（`:3148`、`:3199`） |
| Ride3Pro/Ride6 | 其它 / `status` 缺字段 | **`-1`（需格式化）**；缺 `status` 时按容量推断：`coerceAtLeast(total,0) > 0 → 0`，否则 `-1` | `FORMAT_REQUIRED` | `memory_card_error` + `ride3pro_memory_card_abnormal_format_hint`「无法正常录像，点击去格式化」（`:3197`） |
| Ride3Pro/Ride6（正常但久未格式化） | `0` 且 `formatReminder != null` | `1` | `FORMAT_REMINDER` | `sd_card_format_elapsed_days`「距离上一次格式化 SD 卡已 %d 天」（`StorageManagerActivity` 的 `tv_sd_format_reminder`） |
| Ride5 / 旧链路 | `1` | `1`（正常），容量 MB→GB `/1024.0f` | — | 同正常卡 |
| Ride5 / 旧链路 | `0` | `0`（无卡） | — | `memory_card_error` |
| Ride5 / 旧链路 | 其它 / `sdstatus` 缺字段（默认 `-1`） | `-1` | — | 需格式化 |
| M3 | `M3SDInfo.status`（int） | 由 `resolveSdStatusDescription(status)` 出文案，`_sdStatus`/`_sdCardError`/`storageInfo` 三个 StateFlow 驱动 `llSDError`/`tvSDError` | — | `activity_m3_device_detail` 静态文案即 `sd_card_abnormal`「SD异常」 |

单位坑（复现必须注意）：`toGb(value, unitIsMb=true)` 一律 `/1024.0f`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/StorageSdInfoPolicy.java:69-71`）——即 **Ride3Pro/Ride6 的 `/api/sd/info` 的 `total`/`free` 单位是 MB**，旧链路 `sdtotalspace`/`sdfreespace` 同样按 MB 处理。

#### 5.2.3 禁用 / 置灰规则汇总

| 触发条件 | 被禁的控件 | 表现 | 代码 |
|---|---|---|---|
| M3 `M3ParamItem.enable != 1`（缺省按 1） | 设置页整行 | `alpha = 0.5f` + `setEnabled(false)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:391-392`、`:403-404` |
| M3 `itemsDisable` 含某选项文本 | 选择弹窗内该选项 | `alpha = 0.5f` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:653`、`:675` |
| M3 存储不可用（`getRecordingStartAvailability` / `getPhotoStartAvailability`） | 录像键、拍照键、缩时键、定时键 | **不发请求**，`emitStorageBlockedPrompt` → `m3_storage_full_message`「存储卡已满」/`m3_storage_unavailable_message`「存储卡不可用」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel.java:498`、`:505`、`:1501-1506`、`:1593-1608` |
| M3 正在切模式 | 所有拍摄键 | Toast `m3_wait_mode_switch_finish`「请等待模式切换完成」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/fragment/NormalRecordModeFragment.java:87-88` |
| M3 正在录像 / 正在拍照 | 模式选择 | Toast `m3_wait_stop_recording`「请先停止录像」/`m3_wait_photo_finish`「请等待拍照结束」（§2.1） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel.java:2288-2310` |
| `features` 不含 `"reboot"` | 设置页 `REBOOT` 行 | 整行不渲染 | §1.2.4（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSimpleSettingsMenuPolicy.java:31-49`） |
| `features` 不含 `"nv"` | `WIFI` / `FACTORY_RESET` 行 | 整行不渲染 | 同上 |
| `camnum == 1` 或机型为 Ride3Pro/Ride6 | 预览页 `btn_steam_type` | `View.GONE`；`camnum` 非法则保持原可见性并 warn `DeviceDetailActivity: Invalid camnum=…, keeping current visibility` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailSteamTypeVisibilityPolicy.java:17-29`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:943-968` |
| 无文件管理权限 | 下载动作 | Toast `no_file_management_permission_download`「未授予文件管理权限，无法下载」/`no_download_permission`「没有下载权限」；已下载 Tab 显示 `no_file_permission` + `go_authorize` | §3.7、§3.8 |
| 删除能力不可用（旧固件） | 回放页删除键 | 隐藏删除入口 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/Ride3ProPlaybackDeleteCapabilityResolver.java:20-34`、`Ride3ProPlaybackDeleteSelectionGate` |
| `DeviceType` ∈ {RIDE3PRO, RIDE6} | `MoreSettingsActivity` 的 7 行 + 5 个 CGI type | 隐藏/不发请求 | §1.6 表 |

### 5.3 录制时长 / 录制态的 UI 表达

| 机型 | 录制计时来源 | 展示位置 |
|---|---|---|
| Ride3Pro / Ride6 | **不用 `recording_time` 字段**，由 `record(RecordingControlDevice, RecordingControlAction.STARTED/STOPPED, now())` 本地记事件（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProRecordRepositoryImpl.java:315-334`、`:433`），`RecordingControlEventRepositoryImpl` 存盘、`RecordingControlEventsView` 展示 | 预览页无计时器 |
| M3 | 本地 `startRecordingTimer()` 自增 `_recordingDuration`，`formatRecordingTime(seconds)` 出串 | `fragment_normal_record_mode` 的 `tvRecordingStatus` + `ivRecordingIndicator` |
| Ride5 | 回调/`getworkstate.cgi` 的 `running` 键（`"true"`/`"false"`） | `EmptyControlVideo.setRecording(...)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/EmptyControlVideo.java:591`，判定 `Intrinsics.areEqual(fields.get("running"), "true")`） |

### 5.4 断线判定与会话重建

| 机型 | 谁判定掉线 | 判定依据 | 会话重建 |
|---|---|---|---|
| Ride3Pro / Ride6 | `Ride3ProPollingStatusChannel`（单次轮询产 `Ride3ProStatusPollResult.Failed`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java:443`）+ `Ride3ProHeartbeatManager.requestHeartbeatWithRetry`（`MAX_RETRY_COUNT = 3`，重试用尽后 `stop()`） | 一次完整重试序列内 `GET /api/device/status` 全部失败 → `Ride3ProConnectionException.httpFailed("/api/device/status", errorMessage)`；另有 `activeSessionId` / `activeRouteRevision` 两个字段用于识别「换了路由/换了会话」（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:18-19` 字段、`startForSession` 形参） | 重建走协议面 §3 的 `Ride3ProSessionConnector`（`httpBaseUrl` `:2031-2036`、探测 `:1886-1904`），并按 `Ride3ProSessionExecutorResolver.refreshLegacyBindingIfNeeded()` 重新绑定 executor；`Ride3ProStatusStore.clearSession(sessionId, routeRevision)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProStatusStore.java:161`）与 `clear()`（`:173`）清快照 |
| M3 | `M3SessionRecovery` + `M3ControlChannelState`（4 态：`READY`、`RECOVERING`、`RECOVERABLE`、`UNAVAILABLE`，`_work/re/tuwin/catalog-enums.md` 「M3ControlChannelState」节）；VM 侧 `observeControlChannelState` 订阅 | TCP 控制通道断开 → 状态转 `RECOVERABLE`/`RECOVERING` | `M3DeviceDetailViewModel.startSocketReconnectIfNeeded(trigger, recovery)` 起协程，**每 300 ms 重试一次**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/M3DeviceDetailViewModel$startSocketReconnectIfNeeded$job$1.java:172`、`:254`），`stopSocketReconnect(reason)` 停；HTTP 侧会话由 `M3SessionRepositoryFactory` 重新签发（协议面 §2.2、§2.4） |
| Ride5 | 回调 socket 断（`JavaRide5CallbackServerSocket` / `Ride5CallbackChannel`，端口 `9002`）+ `Ride5CgiException.BusinessError`/`ProtocolError` | 回调长时间无消息；或任一 CGI 响应无法被 `Ride5CgiParser` 完整覆盖 | 重新 `client.cgi?-operation=register&-ip=<新IP>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:305`）；`Ride5SessionPortProvider` 按 `deviceSessionId` 重新 `require(...)` |
| 全机型（首页侧） | `ConnectViewModel.refreshDeviceConnection(Network, ConnectRefreshSource)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java:320`） | 系统 `Network` 回调 + `ConnectFragmentShowRefreshPolicy`；固件重启场景由 `scheduleFirmwareReconnectRefresh` 每 1000 ms 轮询、最多 120 s | `RefreshConnectionUseCase`（协议面 §1.5 的探测链）重跑；`ConnectFlowLifecycleGate` 抑制并发；`Ride3ProAutoRefreshGate` / `Ride5WifiRenameRefreshGate` 按机型限流（改 WiFi 名后 `markPending()` 再刷新，§4.12） |
| 预览播放器 | `FFmpegFirstFrameMonitor` / `FFmpegFirstFrameGate`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/`） | 起流后在超时窗口内没等到首帧 | 走 4.2 的失败分支文案（`ride3pro_preview_prepare_failed` / `ride3pro_preview_play_failed`），并重跑 4.2 全流程（首帧前 `DeviceDetailVideoLoadingVisibilityPolicy` 保持 loading） |

## 6. 对 `docs/03-品牌型号与协议矩阵.md` §1.5 的纠正

> 逐条比对 `docs/03-品牌型号与协议矩阵.md` 的 §1.5（行号取该文件当前版本，区间 `:163-231`）。
> 证据列写 `_work/tuwin_src/...`（jadx 源码，行号已核对）与 `docs/03` 自身行号。

| # | 原说法（`docs/03-品牌型号与协议矩阵.md`） | 证据（全路径:行号） | 应改为 |
|---|---|---|---|
| 1 | `:175` Schema 里 `<Type>` 是「**自由字符串**」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsRuntimeMapperKt.java:17-35`（`ride3ProSettingTypeCode` 按十六进制/十进制宽容解析成整数）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsRuntimeMapper.java:53-94`（`0/1/2/3/4` 五分支显示逻辑） | `<Type>` 原文是自由字符串，但**客户端把它按整数解析**并驱动 5 种渲染分支：`0`/`3`=按 `<Value>` 反查、`1`/`4`=动作项（label `Execute`，且**单独发 `getparameter?id=<requestId>`**）、`2`=原值直显；无法解析时退回 `原值 → <Default> → ""`。`1` 与 `4` 被显式列为「需单独查询」：`SetsKt.setOf(Integer 1, Integer 4)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:361`、`:390`、`:449`） |
| 2 | `:174` `<ID>`「存在但客户端不用作请求 id」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsCompatibilityPolicy.java:17`（`FACTORY_RESET_ID = "0x0000208"`）、`:19`（`WIFI_PASSWORD_ID = "0x0000301"`）、`:41-44`、`:36-39` | 前半句对（不作请求 id），但**不能读成「客户端完全不用 `<ID>`」**：兼容策略类把 `<ID>` 做**数值化比较**来识别「恢复出厂」与「WiFi 密码」两项（`isFactoryReset` = `requestId=="factory_reset"` OR id 数值 == `0x208`；`isWifiPassword` = `requestId=="wifi_passwd"` OR `name=="Password"` OR id 数值 == `0x301`），并在 `factory_reset` 成功后把缓存 WiFi 密码复位（`:46-56`） |
| 3 | `:184` `normalize()`「（**大写 ROOT**、小写、只留字母数字）」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:163-184` | 只有**一次**小写化：`trim()` → `toLowerCase(Locale.ROOT)` → 逐字符 `Character.isLetterOrDigit` 过滤。没有「大写 ROOT」这一步（原文疑似笔误，会让复现方多做一个 `uppercase`，从而对 `Motion Detection`→`motiondetection` 这类键产生偏差） |
| 4 | `:186-196` 的 9 个 id 触发条件表：`record_resolution` 只给了 `recordresolution`←`record`；`system_version` 只给 `systemversion`←`system`；`wifi_name` 写成 `wifiname`←**`system`**；`wifi_passwd` 写成 `wifipasswd`/`password`←**`system`**；`looprecording`←**`record`**；`systemfrequency`/`frequency` 合并成 ←`system`；`recordexposure`←`record`；**完全漏掉 `ssid` 与 `password` 的「非空任意分区」分支** | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:44-161`（逐 `case` 核对；折叠常量 `C3059bv.f1801z`=`"resolution"`、`C3077cm.f1938n`=`"version"`、`DeviceWifiScanDialog.RESULT_SSID`=`"ssid"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog.java:43`）、`NetworkUtil.NETWORK_TYPE_WIFI`=`"wifi"`（`_work/tuwin_src/sources/com/efs/sdk/base/core/util/NetworkUtil.java:18`）） | 用本附录 §1.2.2 的完整 17 行表替换。关键改错：`wifi_name` 条件是 `wifiname`←(`""`/`wifi`) + `ssid`←非空任意（**不是** `system` 分区）；`wifi_passwd` 是 `wifipasswd`←(`""`/`wifi`) + `password`←非空任意（**不是** `system`）；`looprecording`←(`""`/`record`)；`frequency`←(`""`/`system`) 而 `systemfrequency` **无条件**；`exposure`←(`""`/`record`) 而 `recordexposure` **无条件**；`resolution`←(`""`/`record`)；`version`←(`""`/`system`) 而 `systemversion` **无条件**；`recordlooprecording`/`recordresolution` 亦**无条件** |
| 5 | `:198`「**除这 9 个之外，R3Pro/R6 没有别的 id**」 | 结论成立：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:18-27`（9 个常量 + `ALL`）、`:158-159`（`default: return null`） | **保留**，但补一句：`ALL = "all"`（`:18`）不参与 `forSetting`，只用于批量读 `GET /api/menu/getparameter?id=all`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6SettingsProtocolClient.java:410`）；且当项名推不出 id 时 `update()` 会抛 `IllegalStateException("R6 setting does not have a protocol request ID: " + name)`（`:248-251`）——即**设备下发的 XML 里任何推不出 id 的项（白平衡、连拍、锐度、ISO、防抖、屏保、语言、按键音、清除缓存…）在 App 里既读不到也写不了**，这正是 §1.2.1 静态兜底表 31 项里只有 9 项可上线的原因 |
| 6 | `:203`「读值 `getparamvalue?param=<name>`」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java:57`、`:93`（`getAllParamValues`/`getParamValue` 声明）、协议面 §2.2「M3 的 3 个死端点」 | 端点存在但**官方 App 一处都没调用**（`getAllParamItems`/`getAllParamValues`/`getParamValue` 三个方法全仓零调用方）。实际读值来自 `GET /app/getparamitems?param=all_<modeId>` 响应里的 `cur_index`，UI 用 `index.indexOf(curIndex)` 反查下标（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsAdapter.java:482-490`）。把 `getparamvalue` 当既有实现复现属**过度实现** |
| 7 | `:208`「**(c) Ride5** … **`-type`/`-workmode` 的取值词表未找到**（调用点全是变量）」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsCapabilityPolicy.java:18`（8 条 `MoreSettingsRequestSpec(type, pType, isCommParam)`）、`:26-42`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:86`（`NORMAL_RECORD_MODE = "NORM_REC"`）、`:87`（`WIFI_DEFAULT_STATE = "WIFI_DEAULT_STATE"`）、`:679`、`:809`、`:910`、`:1061`、`:1075`、`:1107`、`:1121`、`:1183`、`:1197` | **本条已被推翻。**`-workmode` 在该页写死为 `"NORM_REC"`；`-type` 静态可确定 **9 个**：`AUDIO`、`FLIP`、`MIRROR`、`MEDIAMODE`、`Rec_Split_Time`（以上走 `getcamparam`/`setcamparam`）+ `GSR_SENSITIVITY`、`GSR_PARKING`、`VCAPVQE`、`WIFI_DEAULT_STATE`（走 `getcommparam`/`setcommparam`，注意末者源码原文拼写少一个 `F`）。取值成对如下：`AUDIO` `"1"`/`"0"`、`FLIP`/`MIRROR` `"ON"`/`"OFF"`、`GSR_SENSITIVITY` `"MIDDLE"`/`"OFF"`、`GSR_PARKING` `"HIGH"`/`"OFF"`、`VCAPVQE` `"ON"`/`"OFF"`、`WIFI_DEAULT_STATE` `"OFF"`/`"ON"`/`"ALWAYSON"`、`MEDIAMODE`/`Rec_Split_Time` 取能力集逗号分隔项原文。全表见本附录 §1.6。仍**未知**的只有 `workmodecmd.cgi?-cmd=` 的词表（观测到的字面量只有 `"stop"` 与 `"trigger"`） |
| 8 | `:214` (d) 表「分辨率 / RIDE5」= `-type`（词表未知）；`:215`「循环/分段 / RIDE5」= `—` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsCapabilityPolicy.java:18`（`MEDIAMODE`、`Rec_Split_Time`）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:2174-2181`、`:2203`（分辨率能力集逗号分隔，兜底 `{"1080P+1080P"}`）、`:2136-2144`、`:2200`、`:2207-2215`（录像时长 `MIN`↔「分钟」互转，兜底 `{1分钟,3分钟,5分钟}`） | 分辨率 → `-type=MEDIAMODE`；循环/分段 → `-type=Rec_Split_Time`（写值时把中文「分钟」反替换回 `MIN` 后缀）。两项的**能力集**走 `getcamparamcapability.cgi`（`pType != 3` 分支，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:2150-2164`、`:2194-2198`） |
| 9 | `:220` (d) 表「音频/外接麦 / RIDE3PRO/RIDE6」= 仅菜单 XML | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsCapabilityPolicy.java:26-42`：`RIDE3PRO`/`RIDE6` 的 `requestQueue` = 8 条中剔除 `ride3ProUnsupportedRequestTypes = {FLIP, MIRROR, GSR_SENSITIVITY, GSR_PARKING, VCAPVQE}` → 剩 `{AUDIO, MEDIAMODE, Rec_Split_Time}`；但 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailSettingsEntryRoutePolicy.java:44-57` + `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:1088-1118` 表明 **RIDE3PRO/RIDE6 恒返回 `DEDICATED_RIDE3PRO`，永远进不了 `MoreSettingsActivity`**（全仓仅 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailActivity.java:1114` 一处入口） | 表述要分两层：**可达 UI 层**结论不变（Ride3Pro/Ride6 的设置页不含 CGI 通道，`AUDIO`/`MEDIAMODE`/`Rec_Split_Time` 走不到）；但**代码层**存在一个从预览页不可达的 Ride3Pro/Ride6 分支（它保留这 3 条 CGI 队列并隐藏其余 7 行）。复现时若照「Ride3Pro/Ride6 有 CGI 音频」实现会做出官方 App 到不了的功能 |
| 10 | `:217` (d) 表「白平衡 / RIDE3PRO/RIDE6」= 仅菜单 XML；`:222`「防抖」同；`:225`「快门/连拍/延迟/降噪/变焦」同 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:44-161`（无 `whitebalance`/`antishaking`/`sequence`/`sharpness`/`iso`/`screensaver`/`language`/`beepsound`/`clearbuffer` 分支） | 结论成立，但**原因要写清**：不是「没有这一项」，而是静态兜底菜单里**确实有**这些项（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsMenuPolicy.java:18-20` 的 31 项，含 `White Balance`=`0x00000108`、`Sequence`=`0x00000103`、`Anti-Shaking`=`0x00000106`…），只是 `forSetting` 推不出线上 id ⇒ 写操作必然抛 `IllegalStateException`（§1.2.2 末段）。互操作时这些项应视为**只读显示** |
| 11 | `:218` (d) 表「HDR / RIDE3PRO/RIDE6」= **无 id**、M3 = **无 name** | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:18-27`（确无 HDR 常量）；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/M3SettingNameMapper.java:17`（22 键无 HDR）；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProDeviceStatusInfo.java:26-27`（`hdr_chk_cnt`） | 成立，但补一句避免混淆：Ride3Pro/Ride6 的 `hdr_chk_cnt` 是 **`/api/device/status` 的状态回报字段**（`>0` 参与「录像写入异常」判定，见 §5.2.1），**不是**可写的 HDR 设置项；两者不可互相推断 |
| 12 | §1.5 全节（`:163-231`）**没有**「Ride5/Ride6 独有的一批概念」：紧急录像、哨兵模式、智能降风噪、WiFi 模式三态、上下/左右翻转、同步时间、格式化、恢复出厂、固件 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsCapabilityPolicy.java:18`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java:1048`、`:1061`、`:1075`、`:1094`、`:1107`、`:1121`、`:1170`、`:1183`、`:1197`、`:247`、`:951`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackMessagePolicy.java:15-16` | 在 (d) 表补 8 行（本附录 §1.6 已给全部成对取值与中文提示文案），并注明两项：① `WIFI_DEAULT_STATE` 的**源码拼写错误**必须原样复刻；② 该页只对 RIDE5/RIDE5 Pro 与 M3 开放（`hiddenItems` 表见 §1.6） |
| 13 | `:230` (d) 表「固件 / RIDE5」= `checkupgradepktinfo.cgi` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi.java:19`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$checkUpgradePktInfo$1$response$1.java:53-62` | 精确到参数：`GET cgi-bin/hisnet/checkupgradepktinfo.cgi?-model=<upgradeModel>&-softversion=<currentBean.newVersion>&-pktlen=<本地固件文件字节数字符串>`。且它是**分包检查**步骤，不等于上传通道本身（上传语义见 OTA 附录） |
| 14 | `:165`「结构结论：完整参数表不在 APK 里，必须运行时向设备取」 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSettingsMenuPolicy.java:18-20`（31 项兜底表，但 `values = emptyList`）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/Ride3ProSimpleSettingsMenuPolicy.java:31-49`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/settings/M3SettingsMenuPolicy.java:21-22`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsCapabilityPolicy.java:18` | 结论成立但要限定**范围**：Ride3Pro/Ride6 的**取值集合**（`<Value>` 列表）确实只在设备 XML 里；但「**哪些项存在**、**哪些项可写**、**分区顺序**、**英文→中文映射**」三张表 APK 里是**写死可枚举**的（本附录 §1.2.1 / §1.2.2 / §1.2.3 全量抄出）。M3、Ride5 的参数名/类型词表更是完全静态（§1.4、§1.6），不受该结论约束 |

与本附录 §2 相关但**不在 §1.5 范围内**的一条（记在这里以免丢失）：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:25-26` 声明的 `GET /api/capture`，在整份反编译源码中**没有任何调用方**（`grep -rln "\.capture(" _work/tuwin_src/sources/com/tuwinsmart` 只命中 `Ride3ProSessionApiService.java`、`UpgradeHelper.java`、`QueuedRide3ProApiService.java` 三个转发/声明文件）。Ride3Pro/Ride6 的「拍照」实际是播放器截 RTSP 帧（§4.4），复现时不需要 `/api/capture`。

---

<!-- 以下整段合并自原 01-TUWIN-档案-附录-传输OTA与联网.md（2026-09-22 文档归并，内容未改） -->
# TUWIN 官方 APK 逆向档案 · 附录 B — 传输 / OTA / 联网

> 证据基线：`_work/tuwin_src/sources/com/tuwinsmart/**`（jadx 反编译，APK 版本见 `_work/re/tuwin/manifest.md`）。
> 表格来源：`_work/re/tuwin/api/*.md`、`catalog-consts.md`、`catalog-ports.md`、`catalog-http.md`、`catalog-templates.md`、`manifest.md`、`natives.md`、`natives-jni.md`、`signals-*.tsv`。
> 引用格式：`_work/tuwin_src/sources/com/tuwinsmart/…/<类名>.java:<行号>`。核不上行号的只给文件路径。

## 本附录覆盖范围

1. WiFi 直连与路由绑定（`core/network` 的 `WifiNetworkSpecifier` / `NetworkRequest` / 路由租约 / socket 绑定）
2. 文件下载与断点续传（`?offset=`、并发、缓冲、`getfilelist`/`getmediainfo` 字段）
3. 相机固件 OTA（`DeviceOtaOperations`、14 态状态机、上传分块、本地固件校验）与 App 自更新（分开说明）
4. 预览与播放（RTSP 播放器初始化参数逐项、`RtspTransport` 选择、Surface 生命周期、失败重试）
5. 事件与状态推送（`core/event`、`core/process` 消息类型、Flow 共享策略、断线恢复）
6. 遥测与三方 SDK（友盟 / ucrash / Glide / DataStore / WifiUtils 初始化参数与 AppKey）+ 全量域名逐条判定
7. 原生库（9 个 `.so` 用途 + `Java_*` 符号到 `external fun` 的映射）
8. 对既有文档 `docs/03` §1.3/1.4/1.6、`docs/04`、`docs/05` 的纠正

## 本附录未覆盖（由其它附录负责）

- 机型识别 / 型号矩阵 / 能力协商 → 附录 A（机型与设置）
- HTTP 端点逐条语义与命令参数 → 附录 A（HTTP 端点）
- 设置项键值与 UI 操作流程 → 附录 A（设置与 UI）
- 我们自研侧的实现进度与差距矩阵 → `docs/02`、附录「我们已实现的命令面」
- 蓝牙发现 / SPP / BLE 配网细节 → `docs/07`

---

## 1. WiFi 直连与路由绑定

### 1.1 `DeviceWifiNetworkRequestFactory`：`WifiNetworkSpecifier` 的构造

`object` 单例（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:22` `public static final DeviceWifiNetworkRequestFactory INSTANCE`），私有构造 `:51`。全部逻辑在 `build(DeviceWifiConnectRequest)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:54`）：

前置校验（`:57-59`）：`request.passphrase` 必须非空白，否则 `IllegalArgumentException("Device Wi-Fi passphrase is required")`。**没有开放网络（无密码）分支**。

两条 SSID 路径（`:61-78`）：

| 条件 | 设置内容 | 行号 |
|---|---|---|
| `request.isExact() == true` | `builder.setSsid(trimmedExpectedSsid)` + `builder.setBssid(MacAddress)` | `:64-75` |
| `request.isExact() == false` | `builder.setSsidPattern(ssidPattern(deviceType))`，**不填 BSSID** | `:77` |

- **exact 模式一定用 BSSID**：`expectedBssid` 解析失败为 null 时直接 `IllegalArgumentException("Exact device Wi-Fi BSSID is required")`（`:70-73`），即 exact 模式是 SSID+BSSID 双锁定，防止同 SSID 伪造 AP。
- exact 模式的 SSID 也是可选的：若 `expectedSsid` trim 后为空 → `IllegalArgumentException("Exact device Wi-Fi SSID is required")`（`:67-69`）。也就是说 exact 模式下两者都必填。
- 密码只走 WPA2：`builder.setWpa2Passphrase(request.getPassphrase())`（`:79`），无 `setWepKeys` / 无 open 变体。

**SSID 匹配模式（`PatternMatcher`，type=3 = `PATTERN_ADVANCED_GLOB`）** — `ssidPattern(DeviceType)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:87-104`），逐条原样抄：

| DeviceType | 正则（原样） | 行号 |
|---|---|---|
| `RIDE5` | `TUWIN_[A-Za-z0-9]{6,}` | `:91-92` |
| `RIDE3PRO` | `TUWIN_R3P_[A-Za-z0-9]+` | `:93-94` |
| `RIDE6` | `TUWIN_R6_[A-Za-z0-9]+` | `:95-96` |
| `M3` | `TUWIN[-_]M3_[A-Za-z0-9]+` | `:97-101` |
| 其它 | `throw new NoWhenBranchMatchedException()` | `:98-99` |

注意 RIDE5 的 `TUWIN_` 前缀是**最宽**的（只要求 6 位以上字母数字），会同时吃掉 `TUWIN_R3P_xxx` / `TUWIN_R6_xxx`；RIDE3Pro/RIDE6/M3 才各自收窄。M3 的模式允许 `TUWIN-M3_` 与 `TUWIN_M3_` 两种分隔符。

`parseBssid(String raw)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:106-128`）：`trim()` → `replace('-', ':')` → 空白判空 → `MacAddress.fromString()`，包在 `runCatching` 里（`:119-127`），任何异常返回 null。即**接受 `AA-BB-CC-DD-EE-FF` 与 `AA:BB:CC:DD:EE:FF` 两种分隔**。

### 1.2 `NetworkRequest` 的能力位增删

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:82` 原样：

```java
new NetworkRequest.Builder()
    .addTransportType(1)      // NetworkCapabilities.TRANSPORT_WIFI
    .removeCapability(12)     // NetworkCapabilities.NET_CAPABILITY_PORTAL
    .setNetworkSpecifier(wifiNetworkSpecifier)
    .build();
```

只 **加 transport**、只 **删 capability**；没有 `addCapability`、没有 `setUnderlyingNetworks`、没有 `addLanTransportType`。删掉 `NET_CAPABILITY_PORTAL(12)` 的含义是：要求的网络**不能处于 captive-portal 状态**，Android 只对通过探测的网络清掉 PORTAL 位，因此这相当于把「Portal 未通过」的 AP 排除在自动连接之外。

对照 `NetworkTopologyMonitor.start()` 的监听请求（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkTopologyMonitor.java:130`）：

```java
new NetworkRequest.Builder().addTransportType(1).addTransportType(0).build()  // WIFI + CELLULAR
```

这是 `registerNetworkCallback`（被动监听），不是 `requestNetwork`（不产生网络）。

其它能力位判定：`connectivityManager.hasTransport(1)` = WIFI（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:168`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkTopologyMonitor.java:138`、`:207`）。

### 1.3 `DeviceNetworkController`：调用顺序与时机

构造（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:122-150`）：`(context, enabled, replacementTeardownTimeoutMs, replacementTeardownPollMs)`；`NetworkRuntime` 用 `(appContext, true, 0L, 0L, flags=12, null)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:133`），合成构造（`:152-154`）把两个 long 换成默认值。常量（`:61-64`）：

| 常量 | 值 | 行号 |
|---|---|---|
| `DEFAULT_REPLACEMENT_TEARDOWN_TIMEOUT_MS` | `3000` | `:62` |
| `DEFAULT_REPLACEMENT_TEARDOWN_POLL_MS` | `50` | `:61` |
| `REDACTED_BSSID` | `"02:00:00:00:00:00"` | `:63` |
| `UNKNOWN_SSID` | `"<unknown ssid>"` | `:64` |

`request(DeviceWifiConnectRequest): DeviceWifiCandidate`（挂起，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:247`）严格顺序：

1. `enabled == false` → `DeviceWifiRequestException(DISABLED)`（`:269-271`）
2. `Build.VERSION.SDK_INT < 29` → `DeviceWifiRequestException(UNSUPPORTED_ANDROID_VERSION)`（`:272-274`）——`WifiNetworkSpecifier` 需要 Android 10
3. `DeviceWifiNetworkRequestFactory.INSTANCE.build(request)`；`IllegalArgumentException` 被翻译成 `DeviceWifiRequestException(INVALID_REQUEST, e)`（`:276`、`:288-290`）
4. `requestMutex.lock()`（`MutexKt.Mutex$default(false,1,null)` 非公平锁，`:146`、`:282`）——**同一时刻只允许一个直连请求**
5. `releaseLiveLeasesBeforeReplacement()`（`:330`）
6. `requestCandidate(networkRequest)`（`:337`）
7. 无论成功/异常路径都 `requestMutex.unlock(null)`（`:322`、`:343`、`:346-347`）

第 5 步细节（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:391-488`）：
- 先 `liveLeases.toList()` 快照，非空时打日志 `"Device Wi-Fi request is replacing " + N + " live lease(s)"` 并逐个 `close()`（`:414-422`）
- 再取 `retiringNetworks` 快照；为空直接返回（`:423-428`）
- `replacementTeardownTimeoutMs <= 0` 时**不等待**，只单次检查（`:430-443`）
- 否则 `withTimeoutOrNull(3000ms) { do { 全部网络都 getNetworkCapabilities()!=null ? 返回 true : delay(max(pollMs,1)) } }`（`:445-456` + 轮询体 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/C2051x8dc3a708.java:57-69`，`delay` 值 = `RangesKt.coerceAtLeast(replacementTeardownPollMs, 1L)` = **50ms**）
- 超时/未完成：日志 `"Timed out waiting 3000ms for replaced device Wi-Fi to disconnect"` + 抛 `DeviceWifiRequestException(UNAVAILABLE)`（`:463-464`、`:486-487`）
- 成功：`retiringNetworks.removeAll(toSet(networks))`（`:459`）

第 6 步 `requestCandidate`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:630-838`）用 `suspendCancellableCoroutine`：
- **SDK>=31 用 `ConnectivityManager.NetworkCallback(1)`（即 `FLAG_AVAILABILITY_CALLBACKS_CARDED`，保证 onAvailable/onLost 成对投递）**，`<31` 用无参构造（`:651-709`）。两个回调都只覆写 `onAvailable / onCapabilitiesChanged / onUnavailable / onLost` 四个。
- `onAvailable`：先 `updateWifiIdentity()` 抓 SSID/BSSID，然后 CAS 只放行第一次，构造 `DeviceWifiNetworkLease`、`registerLease()`，若已取消则 `lease.close()`，否则 `resume(DeviceWifiCandidate(lease, lease.termination))`（`:558-571`）
- `onCapabilitiesChanged` → `requestCandidate$lambda$20$updateWifiIdentity`：从 `NetworkCapabilities.getTransportInfo()` 里取 `WifiInfo`，写 `ssidRef`/`bssidRef`（规范化后非空才覆盖）（`:540-555`）
- `onUnavailable` → CAS + 反注册回调 + `resume` 失败 `DeviceWifiRequestException(UNAVAILABLE)`（`:574-580`）
- `invokeOnCancellation`：置 CAS 标志、关闭已建立的 lease，否则反注册（`:711-738`）
- `connectivityManager.requestNetwork(req, cb)` 抛 `SecurityException` → `PERMISSION_DENIED`（`:802-808`）；抛 `RuntimeException` → `INVALID_REQUEST`（`:809-816`）
- 反注册统一走 `requestCandidate$lambda$20$unregisterPendingCallback`，用 `runCatching` 吞异常（`:508-537`）

`DeviceWifiNetworkLease`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkLease.java:22-75`）：持有 `network` + 两个 `AtomicReference<String>`（ssid/bssid）+ `CompletableDeferred<Unit> unavailableSignal`（`:44`）；`close()` 用 CAS，先 `unavailableSignal.complete(Unit)`，再 `releaseCallback()`，再 `onClosed(this)`（`:68-74`）。`termination` 就是调用方 `await()` 该 Deferred 来感知网络消失。

归一化函数（`DeviceNetworkController$Companion`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:610-624`）：
- `normalizeSsid`：`removePrefix("\"")` → `removeSuffix("\"")` → 空白或等于 `<unknown ssid>` 返回 null
- `normalizeBssid`：空白或 `equals("02:00:00:00:00:00", ignoreCase=true)` 返回 null

`bssidFor(Network)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:160-237`）四级回退：① 活跃 lease 记录的 bssid；② SDK>=29 时 `NetworkCapabilities.getTransportInfo() as WifiInfo` 的 `getBSSID()`；③ `WifiManager.connectionInfo.ipAddress` 拆成 `a.b.c.d` 与该 Network 的 `LinkProperties.linkAddresses` 逐地址比对，命中才取 `connectionInfo.getBSSID()`；④ null。整体 catch `SecurityException` → null。

会话侧 API：`adopt(sessionId, lease): Boolean`（`:351-365`，要求 lease 活跃且仍在 `liveLeases` 中；同 sessionId 覆盖时 `close()` 旧 lease）、`releaseSession(sessionId)`（`:367-373`）、`clear()`（`:375-384`）。

上层调用时机（`DeviceWifiConnectionCoordinator.java`，`connect-hUnOzRk`）：
1. 生成 `sessionId = deviceType.name().lowercase(ROOT) + "-connect-" + UUID.randomUUID()`（约 `:186-190` 区段）
2. `deviceSessionManager.closeAll(DEVICE_WIFI_REPLACEMENT_REASON)`，常量 `DEVICE_WIFI_REPLACEMENT_REASON = "device Wi-Fi request replacement"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiConnectionCoordinator.java:39`）
3. `deviceNetworkController.request(...)` 拿 `DeviceWifiCandidate`
4. `probeWhileCandidateAvailable(candidate)` 在 lease 存活期间做协议探测（`:436-466`，内部 `coroutineScope{}`）
5. 探测成功后回填 `ConnectedDevice.ssid / apBssid / pwd / sessionId`（`:391-405`）
6. 非 RIDE5 且 `boardversion` 空白 → `close(sessionId, "RIDE5 attributes are incomplete")` + `lease.close()` + 失败 `IllegalStateException("Device attributes are incomplete")`（`:407` 前后，逻辑见 `:289-300`）
7. `deviceNetworkController.adopt(sessionId, lease)` 成功返回设备；失败 `lease.close()` + `DeviceWifiRequestException(UNAVAILABLE)`（`:409-415`）
8. 任何 `CancellationException` / `Throwable` 路径都会 `lease.close()`（`:253-262`、`:416-421`）

配套扫描器 `DeviceWifiScanner`：`DEFAULT_SCAN_TIMEOUT_MS = 8000`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiScanner.java:42`），`withTimeoutOrNull` 等扫描结果（`:120`），`wifiManager.startScan()`（`:280`）与 `getScanResults()`（`:200`）都包 `runCatching`。

### 1.4 `ProcessBindingController`：进程级绑定

`ProcessBindingController.java`，构造 `(ConnectivityManager, clockMillis: () -> Long = System::currentTimeMillis)`（`:49-65`）。

`acquire(owner: BindingOwner, network: Network): ProcessBindingLease`（`:67-99`）判定顺序：
1. `leases[owner.id]` 已存在且 `(network, owner)` 都相同 → **幂等返回旧 lease**（`:71-75`）
2. 已存在但不同 → `ProcessBindingConflictException("Binding owner already exists: " + owner.id)`（`:76`）
3. 已有任何 lease 绑到**别的** Network → `ProcessBindingConflictException("Process is already bound by " + otherOwner.id + " to another Network")`（`:78-91`）——即全进程同时只允许一个 Network 被 bind
4. 只有 `boundNetwork != network` 时才真正 `connectivityManager.bindProcessToNetwork(network)`（`:92-95`）
5. `new ProcessBindingLease(owner, network, clockMillis(), onRelease = ::release)` 放入 `leases`（`:96-98`）

`release(lease)`（`:122-132`）：仅当登记的实例就是该 lease 才移除；**leases 空且 boundNetwork!=null 时 `bindProcessToNetwork(null)` 解绑**。`releaseOwner(ownerId)`（`:134-140`）→ `lease.close()`。`currentNetwork()`（`:149-151`）返回当前 `boundNetwork`。

`invalidate(route: RouteSnapshot)`（`:153-172`）关闭满足以下**三条同时成立**的 lease：
- `owner.routeRevision <= route.revision`
- `ownerBelongsTo(owner, route)`（`:181-194`）：`route.plane == INTERNET` ⇔ `owner.type == INTERNET_PROCESS`；`route.plane == DEVICE` → 排除 `INTERNET_PROCESS`（即 `TEMPORARY_PROBE / VERIFIED_DEVICE_SESSION / MEDIA_SESSION / CALLBACK_SESSION` 全算设备面）
- `route.networkHandle < 0`（通配）**或** `networkHandleOf(lease.network) == route.networkHandle`

`clear()`（`:174-179`）关掉所有活跃 lease。

`ProcessBindingType` 全集（`ProcessBindingType.java`）：`TEMPORARY_PROBE`、`VERIFIED_DEVICE_SESSION`、`MEDIA_SESSION`、`CALLBACK_SESSION`、`INTERNET_PROCESS`。
`BindingOwner(id: String, type: ProcessBindingType, sessionId: String, routeRevision: Long)`（`BindingOwner.java`）。
`ProcessBindingLease(owner, network, acquiredAtMillis, onRelease)` + `released: AtomicBoolean`，`close()` CAS 后回调 `onRelease`（`ProcessBindingLease.java`）。

**与 `RoutedOkHttpProvider` 的分工**：`bindProcessToNetwork` 是「整个进程的默认网络切换」，粗粒度、会互相冲突；`RoutedOkHttpProvider` 是「按 socket 绑定」，两者在 `NetworkRuntime` 里同时存在（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:147` 建 `ProcessBindingController`，`:141` 建 `RoutedOkHttpProvider`），会话连接器（`M3SessionConnector` / `Ride3ProSessionConnector` / `Ride5SessionConnector`）拿 `processBindingController` 作为构造参数（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:329`、`:331`、`:332`、`:333`）。

### 1.5 `NetworkTopologyMonitor`：注册的回调

`NetworkTopologyMonitor.java`。字段（`:37-46`）：`MutableStateFlow<TopologyChange> _changes`、`MutableStateFlow<Map<Long, ObservedNetwork>> _networks`、`ConnectivityManager`、`CopyOnWriteArraySet<Listener> listeners`、`LinkedHashMap<Long, ObservedNetwork> observations`（key = networkHandle）、`AtomicLong sequence`（初值 0，`:60`）、`boolean registered`。对外暴露 `asStateFlow` 的 `networks` / `changes`（`:67-68`）。

`start()`（`:126-145`）：
- `if (registered) return`（幂等）
- `registerNetworkCallback(addTransportType(1=WIFI).addTransportType(0=CELLULAR).build(), networkCallback)`（`:130`）
- `registered = true`，随后遍历 `getAllNetworks()`，对 `hasTransport(1) || hasTransport(0)` 的每一个主动 `publish(AVAILABLE, network, capabilities, linkProperties)` 补一次初始状态（`:132-144`）

注册的 `NetworkCallback`（`:69-101`）覆写 4 个：

| 回调 | 动作 | 行号 |
|---|---|---|
| `onAvailable` | `publish(AVAILABLE, network, null caps, null link)` | `:71-74` |
| `onCapabilitiesChanged` | `publish(CAPABILITIES_CHANGED, network, caps, null link)` | `:77-81` |
| `onLinkPropertiesChanged` | `publish(LINK_PROPERTIES_CHANGED, network, null caps, link)` | `:84-88` |
| `onLost` | `synchronized`：取旧观测（没有就造一个 `available=false` 的），`copy(available=false, sequence=++seq)` 写回，`publishSnapshot()`，`publishChange(LOST)` | `:91-100` |

`publish(...)`（`:230-258`）在 caps/link 为 null 时回退查 `connectivityManager.getNetworkCapabilities/getLinkProperties`，再回退到旧观测的值；`observe()`（`:269-279`）每次 `sequence.incrementAndGet()`。
`publishChange`（`:261-267`）先 `_changes.setValue(change)`，再逐个调 `Listener.onTopologyChanged(change)` —— **StateFlow 与命令式监听双通道**。
`stop()`（`:147-162`）：`runCatching { unregisterNetworkCallback }` → `registered=false` → `observations.clear()` → `publishSnapshot()`。
`currentWifiNetwork()`（`:168-198`）：在 `available && isWifi` 的观测里挑 `sequence` 最大的。
`ensureObserved(network)`（`:200-220`）：caps 非空且 (WIFI|CELLULAR) 才 `publish(AVAILABLE,...)` 并返回匹配观测，否则 null。
`TopologyChangeKind`（`TopologyChangeKind.java`）：`AVAILABLE`、`CAPABILITIES_CHANGED`、`LINK_PROPERTIES_CHANGED`、`LOST`。
`TopologyChange(kind, current, previous)`（`TopologyChange.java`）。
`networkHandleCompat(network)`（`NetworkTopologyMonitorKt.java`）：`Network.getNetworkHandle()`，异常时退化为 `System.identityHashCode(network)`；`networkHandleOf` 是它的转发别名。

`NetworkRuntime` 的订阅（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:372-377` 注册 → `:501-518` 处理）：

```kotlin
if (change.kind == LOST || !change.current.available ||
    (change.kind == CAPABILITIES_CHANGED && !change.current.isWifi())) {
    deviceRoutes.invalidateNetwork(
        handle, state = if (change.kind == LOST) RouteState.LOST else RouteState.UNAVAILABLE,
        networkLost = change.kind == LOST)
}
internetRoutes.onTopologyChanged(change)
publishInternetRoute(previousInternetRoute, internetRoutes.route.value)
```

`NetworkRuntime.start()`（`:533-539`）只做 `topology.start()`。

### 1.6 `RouteProvider / RouteSnapshot / RouteLease / RouteId` 语义与 `routeRevision` 失效重建

**类型语义**

| 类型 | 定义 | 语义 |
|---|---|---|
| `NetworkPlane` | `INTERNET` / `DEVICE`（`NetworkPlane.java`） | 网络平面：外网 vs 相机直连 |
| `RouteState` | `UNAVAILABLE, CANDIDATE, PROBING, VERIFIED, READY, LOST, REJECTED`（`RouteState.java`） | 路由生命周期状态 |
| `RouteId(value: String)` | `RouteId.java` | 字符串标识，由 `RouteRevisionManager` 生成 |
| `RouteSnapshot(routeId, networkHandle, revision, plane, state)` | `RouteSnapshot.java` | 某一刻的路由不可变快照，`revision` 是代次号 |
| `RouteLease(route, network, intent, profile, endpointGrantId, onClosed)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteLease.java:30-54` | 一次「持有路由」的凭证，可 `Closeable` |
| `RouteProvider.acquire(intent, profile, endpointGrantId=null): RouteLease` | `RouteProvider.java` | 唯一入口接口 |
| `RoutePermission` | `PROBE_ONLY` / `DEVICE_OPERATION`（`RoutePermission.java`） | 探测许可等级 |

`RouteId` 生成规则（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteRevisionManager.java:170-172`）：`plane.name().lowercase(Locale.ROOT) + "-" + networkHandle + "-" + generation`，例如 `device-12345@0x...-3`、`internet-42-1`。`unavailable(plane)` 造的是 `plane.lowercase + "-unavailable"`（`:238-240`）。

**`revision` 何时递增（= 失效点）** — `RouteRevisionManager.java`，全局 `nextRevision` 单调 `++`（`:247-251`），表按 `Key(networkHandle, plane)` 分桶：
- `upsert(handle, plane, available, state)`（`:162-184`）：该 key 首次出现或 `!present` → `generation+1`、新 `RouteId`、`revision = nextRevision()`；已存在且 **`available` 或 `state` 变了** → `revision = nextRevision()`；两者都没变 → **revision 不变**（稳定复用）
- `markLost(handle, plane)`（`:186-199`）：`present=false`、`available=false`、`revision++`、`state=LOST`
- `invalidate(handle, plane, state)`（`:208-219`）：`available=false`、`revision++`、`state=state`（默认 `UNAVAILABLE`，`:201-206`）
- `unavailable(plane)`（`:221-241`）：把该 plane 里所有 `present||available` 的条目全部 `present=false, available=false, revision++, state=UNAVAILABLE`，返回 `RouteSnapshot(RouteId("<plane>-unavailable"), -1L, this.nextRevision, plane, UNAVAILABLE)`
- `clear()`（`:243-245`）：清空 entries（**注意：不重置 `nextRevision`**）

**DEVICE 面的状态推进**（`DeviceRouteRegistry.java`）：
`markCandidate(sessionId, handle)` → `upsert(DEVICE, available=true, CANDIDATE)`（`:75-84`）→ `markProbing` → `PROBING`（`:86-95`）→ `verify(sessionId, handle, DeviceIdentity)` → `upsert(..., VERIFIED)`（`:97-116`）。`reject(sessionId, state=REJECTED)`（`:125-144`）、`closeSession(sessionId)` → `invalidate(..., LOST)`（`:150-185`）、`invalidateNetwork(handle, state, networkLost)` → 命中该 handle 的所有 session 逐个 `markLost`（`networkLost=true`）或 `invalidate`（`:267-308`）。
**`RouteState.READY` 只用于 INTERNET 面**：唯一写入点是 `InternetRouteController.refresh()` 的 `upsert(handle, INTERNET, true, READY)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/InternetRouteController.java:127`）；设备面代码里出现的 `READY` 只是 `setOf(VERIFIED, READY)` 这种**防御性兼容判定**（例如 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionReadiness.java:40`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:1745-1747`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:682`）。

`InternetRouteController.refresh()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/InternetRouteController.java:83-127`）选路条件：`available` ∧ (`isWifi() || isCellular()`) ∧ `hasInternet && validated` ∧ `!isDeviceNetwork(observed)`（后者由 `NetworkRuntime` 注入为 `deviceRoutes.isReservedNetwork(handle)`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:185-195`）；排序 `compareByDescending(isCellular)` 再 `thenBy(networkHandle)`（`:104-118`），即**优先蜂窝、其次 handle 小的**。若当前 route 的 handle 与选出的不同 → 先 `invalidate` 旧 handle 再 upsert。

**`acquire` 的门禁（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/SnapshotRouteProvider.java:136-187`）** —— 逐条：
1. `intent` 是 `NetworkIntent.Internet` → `internetRouteProvider()`；是 `NetworkIntent.Device` → `deviceRouteProvider(sessionId)`，null 则 `RouteUnavailableException("No device route for session " + sessionId)`（`:141-153`）
2. 状态门禁（`:156-166`）：
   - INTERNET：`plane == INTERNET && state == READY`
   - DEVICE + `profile != DEVICE_PROBE`：`plane == DEVICE && state ∈ {VERIFIED, READY}`
   - DEVICE + `profile == DEVICE_PROBE`：`plane == DEVICE && state ∈ {CANDIDATE, PROBING, VERIFIED, READY}`
3. DEVICE 且 `profile != DEVICE_PROBE` 且 `endpointGrantId` 空白 → `EndpointGrantRequiredException("Device operation requires EndpointGrant: session=...")`（`:167-170`）——**除探测外，任何设备操作都必须先拿到 EndpointGrant**
4. 门禁不过 或 `networkHandle < 0` → `RouteUnavailableException("Route is not ready for <IntentSimpleName>: <routeId>@<revision>")`（`:171-173`）
5. `endpointGrantValidator(sessionId, grantId, revision, purpose)` 返回 false → `EndpointGrantRequiredException("EndpointGrant is not valid for <purpose> session <id>@<revision>")`（`:174-179`）——**grant 是按 revision 绑定的，路由换代后 grant 自动失效**
6. `networkProvider(networkHandle)` 为 null → `RouteUnavailableException("Android Network is unavailable for <routeId>@<revision>")`（`:180-183`）；该 provider 在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:223-239` 实现为 `topology.observation(handle)?.network`
7. `new RouteLease(...)` + `leaseRegistry.register(lease)`（`:184-185`）

`profile → EndpointPurpose` 映射（`SnapshotRouteProvider.endpointPurpose`，`:198-237`）：`DEVICE_PROBE→PROBE`、`DEVICE_FILE→FILE`、`DEVICE_IMAGE→IMAGE`、`DEVICE_MENU→MENU`、`DEVICE_DIAGNOSTIC→DIAGNOSTIC`、`DEVICE_UPLOAD→OTA`、`DEVICE_LONG_OPERATION→OTA`、`DEVICE_CONTROL→CONTROL`；未命中（即 INTERNET_* profile）回落到 `intent.operation`：`PROBE→PROBE, CONTROL→CONTROL, FILE→FILE, IMAGE→IMAGE, MEDIA→MEDIA, CALLBACK→CALLBACK, OTA→OTA, DIAGNOSTIC→DIAGNOSTIC`。
`HttpClientProfile` 全集 11 个（`HttpClientProfile.java`）：`INTERNET_API, INTERNET_DOWNLOAD, INTERNET_UPLOAD, DEVICE_PROBE, DEVICE_CONTROL, DEVICE_DIAGNOSTIC, DEVICE_LONG_OPERATION, DEVICE_FILE, DEVICE_MENU, DEVICE_UPLOAD, DEVICE_IMAGE`。
`DeviceOperationKind` 8 个（`DeviceOperationKind.java`）：`PROBE, CONTROL, FILE, IMAGE, MEDIA, CALLBACK, OTA, DIAGNOSTIC`。

**`RouteLease` 生命周期**（`RouteLease.java`）：内部 `cancellation = SupervisorJob()`（`:53`）、`closed = AtomicBoolean(false)`（`:52`）；`isActive() = !closed && cancellation.isActive()`（`:80-82`）；`requireActive()` 抛 `RouteSupersededException("Route lease is no longer active: <routeId>@<revision>")`（`:84-89`）；`invalidate(RouteSupersededException)` CAS 后 `cancellation.cancel(cause)` 并回调 `onClosed`（`:171-177`）；`close()` CAS 后 `cancellation.cancel()` + `onClosed`（`:180-185`）；`withCancellation(block)` 在 `coroutineScope{}` 里以 `CoroutineStart.UNDISPATCHED` 起一个 `routeWatcher` 协程，等待 lease 失效即抛（`:145-169`）。`onClosed` 在 `SnapshotRouteProvider$acquire$lease$1` 里就是 `leaseRegistry.unregister(lease)`。

**失效重建链路**（一次换代做了什么）：
`DeviceRouteRegistry` 的 `onRouteChanged` 回调（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:163-168`）依次调用
`leaseRegistry.invalidate(route)` → `clientRegistry.invalidate(route)` → `processBindingController.invalidate(route)`；
`SnapshotRouteProvider.invalidate(route)` 也转发到 `leaseRegistry.invalidate`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/SnapshotRouteProvider.java:189-192`）。
被 `invalidate` 的 lease 抛 `RouteSupersededException` 取消其 `SupervisorJob`，所有挂在 `withCancellation` 里的请求当场失败；`RouteScopedClientRegistry` 在 `registerLeaseKey` 时对 lease 的 `cancellation.invokeOnCompletion { close(lease) }`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:342-359`），于是 OkHttp client / Retrofit service / ConnectionPool 一起被回收。
`RouteScopedClientRegistry.invalidate(route)`（`:144-208`）的删除条件（三张表一致）：`key.plane == route.plane` ∧ (`route.networkHandle < 0` ∨ `key.networkHandle == route.networkHandle`) ∧ **`key.routeRevision <= route.revision`**。清理动作在名为 `TuwinRouteCleanup` 的单线程 daemon executor 上执行（`:559-574`）：`dispatcher().cancelAll()` → `executorService().shutdown()` → 私有 `ConnectionPool.evictAll()` → `cache()?.close()`（`:385-403`）。
重建：上层连接器捕获 `RouteSupersededException` 后用新 `sessionId`/新 `EndpointGrant` 重新 `acquire`（例如 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackChannel.java:403`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:179`、`:375` 都显式比对 `route.revision != getRouteRevision()` 来决定重连）。

### 1.7 `RoutedOkHttpProvider` / `RoutedRetrofitProvider`：socket 如何绑到 Network

`RoutedOkHttpProvider.client(lease, profile = lease.profile, endpointGrantId = lease.endpointGrantId, configure = {}): OkHttpClient`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:68-110`），工厂 lambda 内部：
- `lease.requireActive()` 先跑（`:72`），工厂内还会被 registry 再跑两次（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:101`、`:104`、`:113`）
- 缓存键：`RouteClientKey(plane, networkHandle, routeRevision = route.revision, endpointGrantId, profile)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:102`）——**revision 进 key，所以换代必然新 client**
- `Network network = lease.getNetwork()`，null → `RouteUnavailableException("No Network object for <plane>@<handle>")`（`:83-84`、`:107`）
- **绑 socket 的两处**：`.socketFactory(network.getSocketFactory())`（`:97-100` 与 `:103-105` 各取一次，后者覆盖前者）
- **绑 DNS**：自定义 `Dns` 调 `network.getAllByName(hostname)`（`:87-95`），绕开系统默认网络解析
- 超时：`connectTimeout / readTimeout / writeTimeout`，单位 `TimeUnit.SECONDS`，值取自 `timeoutSeconds(profile)`（`:96`）
- `retryOnConnectionFailure(false)`（`:96`、`:105`）、`followRedirects(false)`、`followSslRedirects(false)`（`:100`、`:105`）
- `connectionPool(registry.getOrCreateConnectionPool(lease, profile))`（`:102`），池 key = `RouteConnectionPoolKey(plane, networkHandle, revision, profile)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:73`），值是 `new ConnectionPool()`（默认参数，未自定义 keepAlive/maxIdle）（`:78`）

**`timeoutSeconds(profile)` 全表**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:68-92`，`(connect, read, write)` 秒）：

| HttpClientProfile | connect | read | write | 行号 |
|---|---|---|---|---|
| `INTERNET_API` | 10 | 30 | 30 | `:70-71` |
| `INTERNET_DOWNLOAD` | 10 | 60 | 60 | `:72-73` |
| `INTERNET_UPLOAD` | 10 | 120 | 120 | `:74-75` |
| `DEVICE_PROBE` | 3 | 5 | 5 | `:76-77` |
| `DEVICE_CONTROL` | 5 | 15 | 15 | `:78-79` |
| `DEVICE_DIAGNOSTIC` | 5 | 5 | 5 | `:80-81` |
| `DEVICE_LONG_OPERATION` | 10 | 120 | 120 | `:82-84` |
| `DEVICE_UPLOAD` | 10 | 120 | 120 | `:82-84` |
| `DEVICE_FILE` | 5 | 30 | 30 | `:85-88` |
| `DEVICE_MENU` | 5 | 30 | 30 | `:85-88` |
| `DEVICE_IMAGE` | 5 | 30 | 30 | `:85-88` |

`RoutedRetrofitProvider.create(lease, baseUrl, serviceClass, profile = ?, endpointGrantId = ?, configureClient = {}, configureRetrofit = {})`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedRetrofitProvider.java:30-56`）：先 `okHttpProvider.client(...)`，再 `normalizeBaseUrl`（trim；空 → `IllegalArgumentException("Retrofit base URL cannot be empty")`；不以 `/` 结尾则补 `/`，`:58-64`），最后把 `Retrofit.Builder().baseUrl(...).client(...)` + `configureRetrofit` + `.build().create(serviceClass)` 塞进 service 缓存 `RouteServiceKey(clientKey, baseUrl, serviceClass.getName())`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:118-142`）。`close(lease)` 只是转发 `okHttpProvider.close`（`:25-28`）。

### 1.8 超时与重试数值汇总（联网层）

| 项 | 值 | 位置 |
|---|---|---|
| 直连替换旧 lease 的等待上限 | `3000 ms` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:62` |
| 直连替换轮询间隔 | `50 ms`（`coerceAtLeast(pollMs,1)`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:61` + `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/C2051x8dc3a708.java:69` |
| Wi-Fi 扫描等待 | `8000 ms` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiScanner.java:42` |
| Android 最低版本（WifiNetworkSpecifier） | `29` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:272` |
| 回调 carded flag 生效版本 | `31` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:651` |
| OkHttp `retryOnConnectionFailure` | `false`（所有 profile） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:96`、`:105` |
| OkHttp 重定向 | `followRedirects=false`、`followSslRedirects=false` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:100`、`:105` |
| 11 个 profile 的 connect/read/write | 见 1.7 表 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:68-92` |
| 连接释放线程名 | `TuwinRouteCleanup`（daemon，单线程） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:571` |

---

## 2. 文件下载与断点续传

存在**两套**下载实现，同时活着：
- **A. 新传输层**：`core/transfer/*`（`StreamingTransferEngine` + `TransferQueue` + `ResumePolicy`），走 EndpointGrant/RouteLease，支持 checkpoint 续传。
- **B. 旧 `DownloadUtil` 路径**：`core/util/download/DownloadFileExecution`，直接用 `OkHttpClient.newCall(...).enqueue(...)`，靠 `?offset=` 自己重试。
两者共用同一个版本门限策略 `Ride3ProPlaybackDownloadResumePolicy`。

### 2.1 URL 构造与 `?offset=` 语义

**设备 URL 的唯一出口**是 `DeviceUrlBuilder.buildAuthorizedHttpUrl(authority, grantId, sessionId, routeRevision, purpose, relativePath)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:183-215`）：
- `authority.grantFor(grantId)`，`grant.protocol != HTTP` → `IllegalArgumentException("Device HTTP URL requires an HTTP EndpointGrant")`（`:191-193`）
- `grant.allowedPorts` 必须**恰好一个端口**，否则 `IllegalArgumentException("Device HTTP EndpointGrant must contain one port")`（`:194-197`）
- host 含 `:` 且不以 `[` 开头 → 加方括号包成 IPv6 字面量（`:199-203`）
- relativePath trim 后为空 → `IllegalArgumentException("Device relative path is empty")`；含 `"://"` → `IllegalArgumentException("Device URL builder accepts relative paths only")`（`:204-213`）
- 最终：`authority.authorizeUrl(grantId, sessionId, routeRevision, purpose, "http://" + host + ":" + port + "/" + removePrefix(path,"/")).getUrl()`（`:214`）——**注意是 `http://`，全程明文，无 TLS**
- 若 grant 拿不到，各 `buildXxxUrl` 走 `unavailable(kind)`：打日志 `"DeviceUrlBuilder: <kind> skipped because EndpointGrant is unavailable"` 并返回**空串**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:252-255`）
- 遗留的 5 个 `buildM3DownloadUrl / buildM3ThumbnailUrl / buildRide5ThumbnailUrl / buildRide3ProThumbnailUrl / buildRide3ProRawDataUrl / buildRide5DownloadUrl`（`:61-93`）现在**全部直接返回 unavailable**，只有 `buildM3ThumbnailUrl` 例外——它返回本地 `M3ThumbnailCache` 文件绝对路径（`:66-75`）

**`?offset=` 的注入点**：`Ride3ProPlaybackDownloadResumePolicy.withOffset(url, offset)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java:233-239`）

```java
if (offset < 0) throw new IllegalArgumentException("resume offset must not be negative");
return HttpUrl.get(url).newBuilder()
        .setQueryParameter("offset", String.valueOf(offset))
        .build().getUrl();
```

`setQueryParameter` 是**替换**语义（同名参数只留一个），所以重试时 offset 一定被刷新为当前文件长度。
语义 = 「请从第 offset 字节开始给我剩下的内容」，**十进制无单位**，是设备私有 CGI 参数，不是标准 HTTP。

调用点：`DownloadFileExecution.executeAttempt`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:115-123`）——`if (resumeDecision.enabled) url = withOffset(sourceUrl, offset) else url = sourceUrl`，然后 `client.newCall(new Request.Builder().url(url).build())`（`:123`），**该 Request 不带任何 header**。

新传输层里 offset 策略被抽象为 `ResumePolicy`（`ResumePolicy.java`），4 个实现：

| 策略 | 载体 | 语义 |
|---|---|---|
| `Disabled` | — | 不续传，永远从头 |
| `HttpRange` | `Range: bytes=N-` | **仅允许 `AuthorizedTransferSource.Internet` 使用** |
| `DeviceOffset(headerName)` | 请求头，头名由参数给 | 设备侧 header 式续传 |
| `DeviceQueryOffset(parameterName)` | 查询参数，参数名由参数给 | 设备侧 query 式续传；实际用的名字是 **`"offset"`** |

`DeviceQueryOffset("offset")` 的唯一实例化点：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1370`（`startRoutedDeviceDownload` 内，条件 `z = (deviceType==RIDE3PRO || deviceType==RIDE6) && decision.enabled`，`:1365`）；不满足时是 `ResumePolicy.Disabled.INSTANCE`（`:1372`）。

`TransferRequest` 构造期校验（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/TransferRequest.java:133-179`）：
- 设备 intent 但 source 不是 Device → `IllegalArgumentException("Device transfer requires an explicit device offset policy")`（`:163-165`）
- `HttpRange` 且 source 不是 Internet → `"HTTP Range resume requires an internet source"`（`:172-174`）
- `DeviceOffset/DeviceQueryOffset` 且 source 不是 Device → `"Device offset resume requires a device source"`（`:169-171`）
- `ResumeFromCheckpoint` 但 `resumePolicy == Disabled` → `"Checkpoint retry requires an enabled resume policy"`（`:176-178`）
- intent 的 grantId 必须等于 source 的 grant id（`:140-142`），diagnostics 的 routeRevision 必须等于 grant 的 routeRevision（`:146-159`）

### 2.2 固件版本门限与版本号比较

全部在 `Ride3ProPlaybackDownloadResumePolicy.java`：

| 常量 | 值 | 行号 |
|---|---|---|
| `MINIMUM_FIRMWARE_VERSION` | `"v1.20260708.101448"` | `:24` |
| `MAX_RETRY_COUNT` | `5` | `:23` |
| `RAW_DATA_PATH` | `"/api/playback/rawdata"`（private） | `:25` |
| `versionPattern` | `^[vV]?(\d+)\.(\d{8})\.(\d+)$` | `:51` |

`evaluate(url, firmwareVersion): Decision(enabled, reason, firmwareVersion)`（`:203-225`），判定顺序：
1. `isRawDataUrl(url)`：`HttpUrl.parse(url).encodedPath() == "/api/playback/rawdata"`（`:227-231`）→ 否则 `Decision(false, NOT_RAW_DATA, fv)`
2. `firmwareVersion` trim 后为 null/空 → `Decision(false, VERSION_UNAVAILABLE, null)`
3. `parseVersion` 返回 null（不匹配正则，或任一段不能 `toLongOrNull`）→ `Decision(false, VERSION_INVALID, trimmed)`
4. `compareVersions(version, minimumVersion) >= 0` → `Decision(true, SUPPORTED, trimmed)`
5. 否则 → `Decision(false, LEGACY_FIRMWARE, trimmed)`

**版本号怎么比**（`:264-291`）：正则 3 个捕获组 → `List<Long> [major, yyyymmdd, build]`；`compareVersions` 用 `left.size()` 作循环上限、逐位 `Intrinsics.compare`，**第一位不同即决定大小，全等返回 0**。因为中间段固定 8 位日期、末段是 `HHmmss` 派生的整数，所以字典序 = 时间序，等价于「构建时间戳比较」。`minimumVersion` 在 static 初始化时对 `MINIMUM_FIRMWARE_VERSION` 解析，解析不出来直接 `throw IllegalArgumentException("Required value was null.")`（`:52-56`）。

`Reason` 枚举 5 值：`SUPPORTED, NOT_RAW_DATA, VERSION_UNAVAILABLE, VERSION_INVALID, LEGACY_FIRMWARE`（`:31-36`）。

固件版本从哪里取（两条路）：
- 旧路径：`DownloadUtil.resolveRide3ProFirmwareVersion(url)` → `DeviceUrlBuilder.getConnectedDeviceVersion(deviceType)`，从 `PreferenceHelper.getCacheDevices()` 里找第一个 `isConnected() && deviceType` 匹配的 `ConnectedDevice.getVersion()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1566-1575`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:230-250`）
- 新路径：`resolveRouteFirmwareVersion(networkRoute)` → `deviceSessionManager.snapshot(sessionId).identity.firmwareVersion`，包 `runCatching`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1578-1591`）
- `startRoutedDeviceDownload` 走的是后者（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1354-1363`）

日志（`logRide3ProResumeDecision`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1602-1610`），三条原样：
- `"Ride3Pro rawdata resume enabled firmware=" + fv + " max_retries=5"`
- `"Ride3Pro rawdata resume disabled reason=legacy_firmware firmware=" + fv + " minimum=v1.20260708.101448"`
- `"Ride3Pro rawdata resume disabled reason=" + reason.lowercase() + " firmware=" + fv`

### 2.3 是否禁用 HTTP `Range`：在哪禁、为什么

**结论：对相机侧下载完全不用 `Range` 头。** 三条硬证据：

1. **全仓库搜索 `Range` 头写入点**：`grep '"Range"'` 在 `com/tuwinsmart/**` 里**只有一个命中**，且是**日志脱敏白名单**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/DiagnosticHttpLogPolicy.java:134` 的日志保留头列表 `{"Content-Type","Content-Length","Content-Range","Range","Retry-After","X-Ride3Pro-Request-Id","Request-Id"}`）。真正会写 `Range` 的只有三方库：`com/lzy/okserver/download/DownloadTask.java:201`、`com/danikula/videocache/HttpUrlSource.java:220-223`、阿里云 OSS —— **TUWIN 自身代码没有任何调用路径进入这些库的下载器**。
2. **请求构造处**：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:123` 是 `new Request.Builder().url(strWithOffset).build()`，一个 header 都不加；`StreamingTransferEngine` 里唯一的另一处构造是上传（`:412`），也只有 `.method(str, progressRequestBody)`。
3. **策略层的显式禁止**：`TransferRequest` 校验里，**设备传输若使用 `ResumePolicy.HttpRange` 会直接抛异常**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/TransferRequest.java:163-165`，消息 `"Device transfer requires an explicit device offset policy"`）；反向地，`HttpRange` 只允许 `AuthorizedTransferSource.Internet`（`:172-174`）。也就是说**「Range 走外网、offset 查询参数走设备」是被类型系统锁死的**。

**为什么**：`acceptedResponseOffset(policy, requestedOffset, responseCode)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:804-817`）说明了设备侧不能信 Range 的原因——
- `HttpRange`：必须 `requestedOffset > 0 && responseCode == 206` 才承认续传成功，否则返回 0（当作从头开始，会把已写数据覆盖掉）
- `DeviceOffset` / `DeviceQueryOffset`：**直接 `return requestedOffset`，完全不看 responseCode**（`:807-808`）
即固件对 `?offset=` 的响应通常仍是 `200`（不是 `206`），若客户端按 Range 语义去校验状态码就会误判。同时 `DownloadFileExecution.writeResponseBody`（`:198-248`）用 `FileOutputStream(destination, append = offset > 0)` 落盘，`StreamingTransferEngine.copyResponse` 用 `RandomAccessFile` + `offset==0 ? setLength(0) : seek(offset)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:898-913`）——**由客户端自己负责截断/定位**，不依赖服务端 206 语义。

`Content-Range` 仍被读，但只用于估算总大小：`contentRangeTotal(headers, offset, contentLength)`（`:1016-1028`）取 `Content-Range` → `substringAfter('-')` → `substringBefore('/')` → `toLongOrNull`，若 `>= offset` 则返回 `该值 + 1`；否则回退 `offset + contentLength`；再不行返回 null。

### 2.4 并发度、缓冲区与队列

| 项 | 值 | 位置 |
|---|---|---|
| 读缓冲（旧路径） | `byte[8192]` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:216` |
| 读缓冲（新路径 `copyResponse`） | `byte[8192]` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:917` |
| 落盘方式（旧） | `FileOutputStream(dest, append = offset>0)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:210-213` |
| 落盘方式（新） | `RandomAccessFile(dest,"rw")`；`offset==0` → `setLength(0)`，否则 `seek(offset)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:882`、`:898-913` |
| 写盘调度 | `withContext(Dispatchers.IO)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:1011` |
| 每轮读后检查 | `ensureActive()`（协程取消即刻中断） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:919` |
| 下载 scope | `CoroutineScope(SupervisorJob() + Dispatchers.IO)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:130` |
| 传输 scope（NetworkRuntime） | `CoroutineScope(SupervisorJob() + Dispatchers.IO)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:280` |
| 设备 HTTP 超时（旧常量） | `DEVICE_HTTP_TIMEOUT_SECONDS = 5` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:122` |
| `DEVICE_FILE` profile 超时 | connect 5s / read 30s / write 30s | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:85-88` |
| `INTERNET_DOWNLOAD` profile 超时 | connect 10s / read 60s / write 60s | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:72-73` |
| OkHttp 自动重试 | `retryOnConnectionFailure(false)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:96`、`:105` |
| 重定向 | `followRedirects(false)` + `followSslRedirects(false)`；下载 client 再 `newBuilder()` 显式关一次 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:100`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:695` |
| 每个 lease 独立连接池 | `new ConnectionPool()`（OkHttp 默认 5 idle / 5 min keep-alive），key 含 revision | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:73-83` |

**并发度**：**同一 session 内串行**。
- `ScopedTransferQueue.submit(namespace, id, block)`（`ScopedTransferQueue.java`）以 `(namespace, TransferId)` 为 `QueueKey` 去重：`results.putIfAbsent` 已有就直接返回同一个 `CompletableDeferred`，即**同一任务重复 submit 得到同一结果**（不是并发跑两份）。Job 用 `CoroutineStart.LAZY` 启动。
- `DeviceTransferQueue.submit(request)` 的 namespace = `namespace(sessionId)`（`DeviceTransferQueue.java`），即**按设备会话分桶**；`InternetTransferQueue` 同理按外网命名空间。
- 真正的串行化由 `Ride3ProRequestScheduler` 完成：`PriorityQueue<Pending> queue` + `Channel<Unit> wakeup`（`Channel$default(-1, null, null, 6, null)` = **CONFLATED**，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler.java:173`）+ 单个 `worker` Job + 单个 `activeJob` 字段 → **一次只跑一个请求**，按 `Ride3ProRequestPriority` 出队。
- `requiresIsolatedRide3ProConnection(request)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:766-778`）：`(RIDE3PRO || RIDE6) && grant.purpose == FILE && url.encodedPath == "/api/playback/rawdata"` 时要求独占连接。
- `MAX_REDIRECTS = 3`、`REDIRECT_CODES = {300,301,302,303,307,308}`（`StreamingTransferEngine.java` Companion，`catalog-ports.md:181`）标了 `@Deprecated`，因为 client 已彻底关掉重定向。

### 2.5 失败重试与截断判定

**旧路径 `DownloadFileExecution` 的重试环**（`DownloadFileExecution.java`）：
- 每个 task 一个 `taskId = DiagnosticLog.nextId("download")`（`:66`）
- `start()`：`initialOffset < 0` → `IllegalArgumentException("initial download offset must not be negative")`（`:75-76`）；有效起点 `j = resumeDecision.enabled ? initialOffset : 0`（`:78`）
- **截断/不一致判定 1**：`j > 0 && destinationFile.length() != j` → `IOException("Initial resume offset does not match file length: expected=<j> actual=<len>")`，直接终态，不重试（`:80-90`）
- **重置判定**：`resumeDecision.enabled && j == 0 && file.exists() && file.length() > 0` → 用 `FileOutputStream(f, false)` 打开再关闭来**清零文件**；失败 → `"Unable to reset destination file: " + e.getMessage()`（`:91-111`）
- `executeAttempt(completedRetries, offset)`（`:115-195`）失败分类：
  - `call.isCanceled()` → `publishPaused()`（`progress.status = 3`），**不重试**
  - `!response.isSuccessful()` → `handleAttemptFailure("Server returned error: <code>", IOException("HTTP <code>"))`
  - `response.body() == null` → `IOException("Empty response body")`
  - 写盘 `IOException` → `handleAttemptFailure("Error writing file: " + msg, e)`
  - `onFailure` → `handleAttemptFailure("Download failed: " + msg, e)`
- **截断/不一致判定 2**：`writeResponseBody` 开头 `offset > 0 && destinationFile.length() != offset` → `IOException("Resume offset changed before write: expected=<offset> actual=<len>")`（`:199-201`）
- `handleAttemptFailure`（`:251-268`）：`retryPlan = resumeDecision.enabled ? nextRetry(completedRetries, destinationFile.length()) : null`；`nextRetry` 在 `completedRetries >= 5` 时返回 **null**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java:248-250`）→ 终态。
  - 有 plan：日志 `download_retry_scheduled` 带 `retry / max_retries=5 / offset / error_type`，`publishWaitingForRetry(offset)`（`progress.status = 1`、`speed = 0`）后 **立即 `executeAttempt(retryCount, offset)` 递归**（无退避延时）
  - 无 plan：日志 `"Ride3Pro rawdata resume exhausted retries=<n> offset=<len>"` → `publishTerminalError`（`progress.status = 4`）+ `onError(message)`
- 进度里程碑：每 25% 记一次 `download_progress`（`(coerceIn(percent,0,100)/25)*25 >= 25 && > lastLoggedMilestone`，`:291`）
- 完成：`publishFinished` → `progress.status = 5`、`currentSize = file.length()`、`fraction = 1.0f`，可选 `addFileToMediaStore`、EventBus `TaskDownloadFinishEvent`，最后 `onSuccess(absolutePath)`（`:368-390`）

**新路径 `StreamingTransferEngine` 的重试**：`TransferRetryPolicy.ResumeFromCheckpoint(maxRetries)`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1376` 传的是 **`ResumeFromCheckpoint(5)`**，与旧路径同一个 5 次上限。续传点由 `ResumePolicyRegistry.resumeOffset(policy, checkpoint, localPart, source, route)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/ResumePolicyRegistry.java:16-58`）裁决，**任一条件不满足就返回 0（从头下）**：
- `checkpoint == null` → 0
- `localPart` 不是文件 → 视为 null → 0
- `checkpoint.offset <= 0` → 0；`checkpoint.offset != localPart.length()` → 0（**本地分片被截/被改则放弃续传**）
- `checkpoint.sourceFingerprint != source.fingerprint` → 0（**换了源文件即作废**）
- `policy == Disabled` → 0
- `HttpRange`：source 必须是 Internet；且 `entityTag` 与 `lastModified` **至少一个非空白**，否则 0（弱校验器缺失就不敢续传）
- `DeviceOffset` / `DeviceQueryOffset`：source 必须是 Device，且 `checkpoint.routeRevision == route.revision` 且 `checkpoint.endpointGrantId == grant.id` → 才续传（**路由换代或 grant 换代即作废**）

传输层 EOF 特判：`isResponseHeaderEof(error)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:780-801`）= message 以常量 `UNEXPECTED_END_OF_STREAM_PREFIX = "unexpected end of stream on "` 开头 **且** cause 链上存在 `EOFException`。
租约失效：`withLeaseCancellation` 用 `IllegalStateException("Transfer route lease was closed")`（`api` 表 `:1082` 体内字面量）中断；`upload` 里 `CancellationException` 分类为 `"RouteSuperseded"` 或 `"Cancelled"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:329`、`:445-462`）。
`replaceTarget(partFile, destination)` 失败 → `IllegalStateException("Unable to finalize transfer destination")`（`:1172`）。
`validateDeviceLease`（`:665-685`）：grant 与 routeRevision 不匹配 → `IllegalArgumentException("Device transfer EndpointGrant does not match route revision")`；route 状态不在 `{VERIFIED, READY}` → `IllegalArgumentException`。

### 2.6 `getmediainfo` / `getfilelist` 字段

只有 **M3** 机型有这两个端点（`data/source/remote/api/p006m3/M3ApiService.java`）：

```java
@GET("/app/getfilelist")   Object getFileList(Continuation<? super M3FileListResponse>);      // 无参
@GET("/app/getmediainfo")  Object getMediaInfo(Continuation<? super M3MediaInfoResponse>);    // 无参
@GET("/app/deletefile")    Object deleteFile(@Query("file") String, ...);
@GET("/app/getthumbnail")  @Streaming Object getThumbnail(@Query("file") String, ... ResponseBody);
@GET                       @Streaming Object downloadFile(@Url String, ... ResponseBody);
```

`M3FileListResponse`（`dto/p007m3/M3FileListResponse.java`）：

| JSON key | 类型 | 说明 |
|---|---|---|
| `result` | `int` | 状态码，0/非 0 判定 |
| `info` | `List<M3FolderInfo>` | 文件夹数组 |

`M3FolderInfo`：`folder: String`（`@SerializedName(Progress.FOLDER)`，即 key = `"folder"`）、`count: int`、`files: List<M3FileItem>`。
`M3FileItem`：`name: String`（`@SerializedName(SerializableCookie.NAME)` = `"name"`）、`size: long`、`createtime: long`、`duration: int`、`type: int`。

`M3MediaInfoResponse`：`result: int`、**`info: com.google.gson.JsonElement`（不是具体类型）**——服务端这个字段可能是对象也可能是数组，所以刻意留松。解析后才落到 `M3MediaInfo`：`rtsp: String`、`transport: String`、`port: int`（`dto/p007m3/M3MediaInfo.java`）。这三项是 §4 RTSP 选路的输入。

RIDE3PRO/RIDE5 的文件列表不走这两个端点（走 `/api/playback/*` 与 `getmediafilelist` 系列，由 `VerifiedDeviceFileCatalog` 白名单化，见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/VerifiedDeviceFileCatalog.java:1011` 的 `"Ride3Pro file_index is outside the confirmed range"`），细节归机型附录。

---

## 3. OTA：相机固件升级

**必须先分清：仓库里有两套并存的相机 OTA 实现。**

| | 新架构（本文 §3.1–§3.6） | 线上实际跑的 |
|---|---|---|
| 入口 | `core/update/DeviceOtaCoordinator.execute(DeviceOtaPlan)` | `presentation/p010ui/mine/UpgradeActivity` |
| 状态 | `DeviceOtaState` **14 个枚举值** | `OtaUpgradeState` sealed class，**10 个子类** |
| 上传 | `HttpClientProfile.DEVICE_UPLOAD` 走 `StreamingTransferEngine.upload` | 三条机型专用通道：Ride3Pro Retrofit / M3 Retrofit / Ride5 裸 socket |
| 是否被真实调用 | **否**：`DeviceOtaOperations` 只有接口和调用者，APK 内**找不到任何实现类**（对 `queryUpdate / installUploadedPackage / readVersion / reconnect / waitForDeviceReady / waitForReboot` 六个方法名的全仓 grep 只命中 `core/update/DeviceOtaCoordinator.java` 与 `core/update/DeviceOtaOperations.java` 两个文件；`DeviceOtaCoordinator` 仅出现在 `core/update/` 与 `p009di/AppModuleKt.java`，即只被 Koin 注册为 Singleton 而无人 `get`） | 是 |

复现建议：14 态机是「应该长什么样」的参考答案，线上路径是「现在真的能跑」的兼容实现。下面分别抄清。

### 3.1 `DeviceOtaOperations` 全部方法签名与语义

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaOperations.java`，`interface`，**恰好 6 个方法，全部 suspend、全部无参**（返回类型即 `Continuation<? super T>` 的 T）：

| 签名（Kotlin 视角） | 语义 | 被谁调 |
|---|---|---|
| `suspend fun queryUpdate(): Boolean` | 问设备「你需不需要这个包」；`false` 表示无需升级，**直接回 IDLE 而非失败** | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java:201`、`:325` |
| `suspend fun waitForDeviceReady(): Unit` | 等设备进入可接收固件的状态（通常在 VERIFYING 之后） | `:246`、`:366` |
| `suspend fun installUploadedPackage(): Unit` | 让设备开始装机（上传已完成之后） | `:276`、`:396` |
| `suspend fun waitForReboot(): Unit` | 等设备重启掉线 | `:284`、`:404` |
| `suspend fun reconnect(): Unit` | 重新建立直连路由/会话 | `:292`、`:412` |
| `suspend fun readVersion(): Unit`→`String` | 回读装机后的固件版本 | `:300`、`:420` |

配套类型：
- `DeviceOtaPlan(expectedVersion, packageFile, upload, operations, packageDownload, packageIntegrity, diagnostics)`（`DeviceOtaPlan.java`）；`packageDownload: TransferRequest?` **可为 null**（包已在本地时跳过下载）
- `DeviceOtaProgress(state, transferredBytes: Long?, totalBytes: Long?, routeRevision: Long?, error: Throwable?)`
- `DeviceOtaResult` 4 个子类：`Completed(version: String, routeRevision: Long)` / `UpdateUnavailable`(object) / `Cancelled`(object) / `Failed(error: Throwable)`
- 进度流：`val progress: StateFlow<DeviceOtaProgress>`，初值 `DeviceOtaProgress(IDLE, null, null, null, null)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java:70`）

### 3.2 请求字段来源：`md5sum` / `model` / `hw` / `sw`

**只有 Ride3Pro/RIDE6 通道用这四个 query 参数。** 端点声明（`data/source/remote/api/ride3pro/Ride3ProApiService.java:99-101`）原样：

```java
@Headers({"Content-Type: application/octet-stream", "Content-Encoding: identity", "Connection: close"})
@POST("/api/firmware/upload")
Object uploadFirmware(@Query("md5sum") String, @Query("model") String,
                      @Query("hw") String, @Query("sw") String,
                      @Body RequestBody, Continuation<? super Ride3ProApiResponse<Object>>);
```

| 字段 | 来源 | 证据 |
|---|---|---|
| `md5sum` | **App 侧对本地固件文件算 MD5**，`MessageDigest.getInstance("MD5")`，8192 字节流式读，逐字节 `String.format("%02x")` 拼接 → **32 位小写十六进制** | `data/repository/Ride3ProFirmwareUploadRepository$_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:135-157` |
| `model` | `Ride3ProFirmwareMeta.getModel()` | 同上 `:164` |
| `hw` | `Ride3ProFirmwareMeta.getHwVersion()` | 同上 |
| `sw` | `Ride3ProFirmwareMeta.getSoftwareVersion()` | 同上 |

`meta` 的三级取值（`presentation/p010ui/mine/UpgradeActivity.java:936-947`，`resolveRide3ProFirmwareMeta(File)`）：
1. 若 `LocalUpgradeBean != null` → `Ride3ProFirmwareMeta.create(bean.getRide3ProFirmwareModel(), bean.getRide3ProFirmwareHw(), bean.getRide3ProFirmwareSw())`
2. 上一步为 null → `Ride3ProFirmwareMeta.fromNewOta(bean.getBoardversion(), bean.getNewVersion())`
3. 都不行 → **从文件名解析**：`Ride3ProFirmwareMetaParser.parse(file.getName())`

文件名解析（`core/util/Ride3ProFirmwareMetaParser.java`）：
- 预处理：`trim()` → `substringBefore("?")` → `substringAfterLast("/")` → `substringAfterLast("\\")` → `URLDecoder.decode(..., Key.STRING_CHARSET_NAME)`（UTF-8），decode 失败保留原值（`:33-55`）
- 正则：`^(.+?)_cardvr_HW(.+?)_SW(.+?)_upgrade\.bin$`，`RegexOption.IGNORE_CASE`（`:19`）——即形如 `TUMODEL_cardvr_HW1_20_SW1_2_3_upgrade.bin`
- 版本 token 归一：`trim()` 后 `_` → `.`（`normalizeVersionToken`，`:62-64`），所以 `HW1_20` → `1.20`
- 解析不出来 → `IllegalStateException(getString(R.string.firmware_info_parse_failed_format, fileName))`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:160-162`）
- 文件不存在 → `Result.failure(IllegalArgumentException(getString(R.string.firmware_file_not_exist)))`（`:79-82`）

**M3 通道没有 md5/model/hw/sw**（`data/source/remote/api/p006m3/M3ApiService.java:134-135`）：

```java
@Streaming @POST("/upload/{savepath}/{filesize}")
Object uploadFirmware(@Path(encoded = true, value = "savepath") String,
                      @Path("filesize") long, @Body RequestBody, ...);
```
调用点 `savepath` **硬编码 `"mnt/sdcard"`**，`filesize = file.length()`（`data/repository/M3DeviceRepositoryImpl$_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl$uploadFirmware$2.java:171`）。响应 `M3UploadResponse{result:int, info:String}`；结果分类见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl$uploadFirmware$2.java:152-180`（JADX 把 `when(result)` 反成 `if (result != 0)` 链，分支方向不可全信；可确定的是 **`result == 0` 为成功**，`2`、`3` 各有专属失败消息，其它值走 `R.string.upload_failed_format` 带 `result`）。

**Ride5 通道的两个 query 是设备给的、不是 App 算的**：`Ride5CgiApi.checkUpgradePacketInfo(@Query("-model"), @Query("-softversion"), @Query("-pktlen"))`（`core/device/ride5/Ride5CgiApi.java:20`）→ 响应解析出 `offset` 与 `unitsize` 两个字段（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java:1473-1478`，缺任一个就 `IllegalArgumentException("RIDE5 OTA packet check did not return offset and unitsize")`）。

### 3.3 上传分块大小与超时

| 通道 | 分块 | 超时 | 证据 |
|---|---|---|---|
| 新架构（`StreamingTransferEngine.upload`） | 单请求整体流式，`ProgressRequestBody` 内部逐块写；profile 固定 `HttpClientProfile.DEVICE_UPLOAD` | connect `10s` / read `120s` / write `120s` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:334`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:82-84` |
| Ride3Pro Retrofit | `RequestBody.writeTo` 每次 `read` **8192 字节** → `sink.write` → `sink.flush()` → 回调 `onProgress(已传, 总长)` | `contentLength = file.length()`；MediaType = `OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE`（`application/octet-stream`）；service provider = `Ride3ProSessionExecutorResolver.longOperationServiceOrLegacy()`（长操作 client） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:86-131`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository.java:41-47` |
| M3 Retrofit | 同上，**8192 字节/块**，每块后 `sink.flush()` + 进度回调 | 走 `M3HttpClientCompatibilityKt`：connect `5s` / read `120s` / write `120s` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl$uploadFirmware$2.java:104-135`、`catalog-ports.md:85-87` |
| Ride5 裸 socket | **块大小 = 设备返回的 `unitsize`**（`Integer.parseInt(unitsize)`），`offset = Long.parseLong(offset)` 作为续传游标；每个 `unitsize` 块**单独开一条 socket、单独发一个 multipart POST**；块内再按 **1024 字节** 写 | `socket.setSoTimeout(Ride3ProSessionTransport.MENU_CONNECT_TIMEOUT_MILLIS)` = **5000 ms** | `core/util/UpgradeDevice.java:712-801`（分块/续传）、`:151-199`（socket 与报文） |

Ride5 的报文是**手写的 HTTP/1.1**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java:173-188`），逐字抄：
- 固定 boundary：`--------------------------0f063f014f74bfea`（26 个 `-` + `0f063f014f74bfea`）
- 请求行/头：`POST /sd HTTP/1.1\r\nHost: <grant.host>\r\nUser-Agent: curl/7.50.3\r\nAccept: */*\r\nContent-Length: <bodyPart + sb.length>\r\nExpect: 100-continue\r\nContent-Type: multipart/form-data; boundary=------------------------0f063f014f74bfea\r\n\r\n`
- part 头：`--------------------------0f063f014f74bfea\r\nContent-Disposition: form-data; name="filename"; filename="<file.getName()>"\r\nContent-Type: application/octet-stream\r\n\r\n`
- part 尾：`\r\n--------------------------0f063f014f74bfea--\r\n`
- 字符集：`Charset.defaultCharset()`
- 端口：`grant.allowedPorts.size() == 1 ? first() : -1`；发之前 `endpointAuthority.authorizeSocket(endpointGrantId, sessionId, routeRevision, EndpointPurpose.OTA, host, port)`；socket 用 `deviceNetwork.getSocketFactory().createSocket(host, port)`（即绑到设备 Network）

新架构侧的校验：`upload` 前依次 `sourceFile.isFile()` 否则 `IllegalArgumentException("Transfer source file does not exist")`、`IntegrityVerifier.verify(sourceFile, integrityPolicy)`、`lease.route.revision == upload.target.grant.routeRevision` 否则 `IllegalArgumentException("Upload EndpointGrant does not match route revision")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:379-385`）。非 2xx 抛 `TransferHttpException(code, "Transfer upload failed: HTTP " + code)`（`:429`，注意 jadx 把 `isSuccessful()` 的条件反转了，语义是「不成功才抛」）。

### 3.4 14 态状态机：状态名、迁移条件、失败落点

`DeviceOtaState` 全部 14 个值（`core/update/DeviceOtaState.java`，按声明序）：
`IDLE, QUERYING, UPDATE_AVAILABLE, DOWNLOADING_PACKAGE, VERIFYING_PACKAGE, WAITING_FOR_DEVICE, UPLOADING_TO_DEVICE, INSTALLING, WAITING_FOR_REBOOT, RECONNECTING, CONFIRMING_VERSION, COMPLETED, FAILED, CANCELLED`

迁移驱动：`transition(state, plan)` 只写 `DeviceOtaProgress(state, null, null, plan.upload.target.grant.routeRevision, null)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java:782-784`）；`failed(t)` 写 `FAILED` + error（`:792-795`）；`cancelled()` 写 `CANCELLED`（保留原 error，`:786-789`）。

| # | 进入状态 | 触发/前置 | 成功后 | 失败落点 | 行号 |
|---|---|---|---|---|---|
| 1 | `IDLE` | 构造初值 | — | — | `:70` |
| 2 | `QUERYING` | `execute(plan)` 起手 | `queryUpdate()` 返回 true | 返回 **false** → `transition(IDLE)` + `UpdateUnavailable`（**不是 FAILED**）；抛异常 → `FAILED` | `:196-209` |
| 3 | `UPDATE_AVAILABLE` | `queryUpdate()==true` | — | 后续任一异常 → `FAILED` | `:210` |
| 4 | `DOWNLOADING_PACKAGE` | 仅当 `plan.packageDownload != null`（null 则跳过 4） | `TransferResult.Downloaded` 且落盘路径 == `plan.packageFile.absoluteFile` | `Downloaded` 但文件不对 → `FAILED(IllegalStateException("OTA package was written to an unexpected file"))`；`Cancelled` → `CANCELLED`；`Failed` → `FAILED(err)`；`Uploaded` → `FAILED(IllegalStateException("OTA package download returned upload result"))` | `:211-237` |
| 5 | `VERIFYING_PACKAGE` | 上一步过 | `IntegrityVerifier.verify` 不抛 | 抛 `IntegrityMismatchException` 等 → `FAILED` | `:239-240` |
| 6 | `WAITING_FOR_DEVICE` | 校验过 | `waitForDeviceReady()` 返回 | 抛/取消 → `FAILED` / `CANCELLED` | `:241-248` |
| 7 | `UPLOADING_TO_DEVICE` | 设备就绪 | 结果必须是 `TransferResult.Uploaded` | `Cancelled`→`CANCELLED`；`Failed`→`FAILED(err)`；`Downloaded`→`FAILED(IllegalStateException("OTA upload returned download result"))` | `:249-270` |
| 8 | `INSTALLING` | 上传成功 | `installUploadedPackage()` 返回 | → `FAILED` | `:271-278` |
| 9 | `WAITING_FOR_REBOOT` | 装机指令已下发 | `waitForReboot()` 返回 | → `FAILED` | `:279-286` |
| 10 | `RECONNECTING` | 设备重启完 | `reconnect()` 返回 | → `FAILED` | `:287-294` |
| 11 | `CONFIRMING_VERSION` | 路由重建 | `readVersion()` 非 null | `null` → `FAILED(IllegalStateException("OTA version confirmation returned no version"))`；`!= plan.expectedVersion` → `FAILED(IllegalStateException("OTA version mismatch: expected=..., actual=..."))` | `:295-311` |
| 12 | `COMPLETED` | 版本一致 | 返回 `Completed(version, plan.upload.target.grant.routeRevision)` | — | `:312-313` |
| 13 | `FAILED` | 任意 `Throwable` | — | 终态 | `:317-320`、`:792-795` |
| 14 | `CANCELLED` | 任意 `CancellationException` | — | 终态 | `:314-316`、`:786-789` |

关键点：**整条链上没有任何重试**（一次失败即 `FAILED` 返回），重试策略在上一层 UI/调用方；`plan.packageDownload == null` 是唯一合法分支跳过。

线上 `OtaUpgradeState` 的 10 个状态与迁移（`presentation/p010ui/mine/OtaUpgradeState.java` + `OtaUpgradeFlow.java`）：
`Idle`、`Preparing`、`Uploading(percent)`、`AwaitingDeviceAcknowledgement`、`InstallingAwaitingDeviceResult`、`InstallationSucceeded`、`InstallingSafetyWindow(remainingSeconds)`、`AwaitingUserConfirmation`、`AwaitingReconnectVerification`、`Failed(prompt)`。
迁移：`beginPreparing()`→`Preparing`；`beginUpload(p)`→`Uploading(coerceIn(p,0,99))`；`onUploadProgress(total,progress,signal)`→`percent = total>0 ? coerceIn((progress*100)/total,0,100) : 0`，`percent >= 100` 时按 `OtaCompletionSignal` 分叉：`UploadAccepted`→`AwaitingDeviceAcknowledgement`、`InstallationCompleted`→`InstallingAwaitingDeviceResult`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeFlow.java:66-84`）；`enterInstallingSafetyWindow(s)`→`InstallingSafetyWindow(coerceAtLeast(s,0))`；`installationSucceeded()`→`InstallationSucceeded`；`tickSafetyWindow(remaining)`→`InstallingSafetyWindow(coerceAtLeast(remaining,0))`；`awaitUserConfirmation()`→`AwaitingUserConfirmation`；`awaitReconnectVerification()`→`AwaitingReconnectVerification`；`fail(prompt)`→`Failed(prompt)`；`reset()`→`Idle`（`:87-112`）。
`getBlocksNavigation()` 为 true 的状态：`Preparing / Uploading / AwaitingDeviceAcknowledgement / InstallingAwaitingDeviceResult / InstallationSucceeded / InstallingSafetyWindow / AwaitingUserConfirmation`；为 false：`Idle / AwaitingReconnectVerification / Failed`（`:41-46`）——**装机安全窗与用户确认期禁止返回**。

### 3.5 装机后回读版本的代码路径

新架构：`CONFIRMING_VERSION` 里 `plan.operations.readVersion()` 与 `plan.expectedVersion` 严格 `Intrinsics.areEqual`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java:295-311`）。但**该接口无实现，故线上不会走到**。

线上实际（`UpgradeActivity`）：
1. `onCreate` 阶段先取**装机前**版本作为基线：`SessionBoundOtaIdentityPolicy.resolve(...)` → `setCurrentVersion(bean.getVersion())`、`currentBoardVersion`、`upgradeModel`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java:450-460`）。若解析不到同身份会话，直接 `Timber.w("固件升级拒绝未绑定同一设备身份的会话: identity=%s operation=%s type=%s")` + Toast `loading_failed` + `finish()`（`:451-456`）——**OTA 页强要求会话与设备身份绑定**。
2. 上传成功回调 → `onUploadSuccess()` → `suppressRepeatDownloadPrompt()` + `showInstallationSafetyDialog()`（`:543-558`）。安全窗常量 `COUNTDOWN_SECONDS = 30`（`:96`），`runInstallConfirmButtonCountdown(...)`（该方法 jadx 未能反出，`:1408`）。
3. 重启后靠 `FirmwareUpgradeReconnectGate` 判定「回连的是不是原来那台」（`core/util/FirmwareUpgradeReconnectGate.java`）：`markPending(ssid)` → `pending = true`、`pendingSsid = normalizeSsid(ssid)`（trim + `removeSurrounding("\"")`，空→null）；`isPending()` / `matches(ssid)`（**`pendingSsid == null` 时匹配任意 SSID**）；`completeIfMatches(ssid)` 命中才清 pending；`reset$app_release_64()` 全清。它是 `volatile` 静态单例，跨 Activity 生效。
4. 版本回读最终来源仍是会话 identity（重连后 `DeviceSessionManager` 重新探测出的 `identity.firmwareVersion`），并回填 `PreferenceHelper.getCacheDevices()` 里的 `ConnectedDevice.version`；`UpgradeActivity` 自己不再直连查版本。
5. 上传成功后清理本地包：`Ride3ProUpgradeSuccessPolicy.clearUploadedFirmware(file.getAbsolutePath())`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java:795`、`:823`）。

Ride5 的「装完」判定不是回读版本，而是**分块计数**：`getChunck(0, file)` 返回已推进的块号，`chunck >= chuncks` 才算 `onUploadSuccess()`，否则 `notifyUploadFailed()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java:727-743`）；`notifyUploadFailed()` 无 listener 时 `mHandler.sendEmptyMessage(MSG_UPLOAD_FAILED)`，`MSG_UPLOAD_FAILED = 10003`（`:803-813`、`catalog-ports.md:188`）。

### 3.6 本地固件文件选择与校验

- 目录：`UpgradeHelper.UPGRADE_DIRECTORY_NAME = "upgrade"`（`core/util/UpgradeHelper.java:73`），`upgradeBaseDirectory()`（`:634`）
- 文件后缀：**`.appsw`**（Ride5/M3 老包）——`getMatchedFirmware()` = `list(name.endsWith(".appsw"))` 再 `Arrays.sort`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java:96-135`）；Ride3Pro 新包后缀是 **`.bin`**（正则 `_upgrade\.bin$`）
- 校验和：`hasUsableCachedPackage(filePath, expectedFileName, expectedFileSize)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeHelper.java:440`）——**只比文件名与字节大小，不比对包内容做哈希**
- **MD5**：只在 Ride3Pro 上传前算一次，用作 `md5sum` query 参数交给设备侧校验（算法 `MD5`，编码 `%02x` 小写 hex，无分隔符，32 字符；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:135-157`）。**App 侧不拿它跟服务端下发的值比对。**
- **SHA-256**：新传输层的通用完整性策略 `IntegrityPolicy`，4 个子类 `None / ExpectedSize(bytes) / Sha256(hex) / ExpectedSizeAndSha256(bytes,hex)`（`core/transfer/IntegrityPolicy.java`）。`IntegrityVerifier.verify(file, policy)`（`core/transfer/IntegrityVerifier.java`）：`None` 直接 return；`ExpectedSize` → `requireSize`（`!file.isFile() || length != expected` → `IntegrityMismatchException("Transfer size does not match expected value")`）；`Sha256` → 比较；`ExpectedSizeAndSha256` → 先 size 再 sha256。
  - 算法：`MessageDigest.getInstance("SHA-256")`，`byte[8192]` 流式读；hex 同样 `%02x` 小写、无分隔
  - **比较用 `String.equals(..., ignoreCase = true)`**（`StringsKt.equals(sha256(file), policy.hex, true)`），所以期望值大小写都行
  - 不等 → `IntegrityMismatchException("Transfer SHA-256 does not match expected value")`
- 云端 OTA 元数据：`GET newota?version=&boardversion=` → `UpgradeBean`；`hasUsableCachedPackage` 决定复用还是重下（`UpgradeHelper.processAvailableUpdate`，`:490`）；串行下载队列 `OtaSerialTaskQueue<OtaPackageIdentity, OtaDownloadTask>`（`:86`），完成后停留展示 `DOWNLOAD_COMPLETE_DISPLAY_MILLIS = 2000`（`:72`）
- 下载走 `DownloadUtil` + `DownloadNetworkRoute.Internet` → profile `INTERNET_DOWNLOAD`（connect 10 / read 60 / write 60 秒），见 §2

### 3.7 App 自更新（与相机 OTA 完全两套）

`core/update/AppUpdateCoordinator` + `TuwinApplication`，**跟相机固件无关**：不占 `RouteState` 设备面、不需要 EndpointGrant，只用 `NetworkPlane.INTERNET` 的 `READY` 路由。

- 状态枚举 `AppUpdateCheckState` 7 个：`IDLE, WAITING_FOR_INTERNET_ROUTE, CHECKING, NO_UPDATE, UPDATE_AVAILABLE, CHECK_FAILED, CHECK_CANCELLED`（`core/update/AppUpdateCoordinator` 同名文件）
- 结果 `AppUpdateCheckResult` 5 个：`WaitingForInternetRoute / NoUpdate / UpdateAvailable(key, response, routeRevision) / Failed(key, error) / Cancelled(key, reason)`
- 去重键 `AppUpdateCheckKey(versionCode, releaseChannel, serverEnvironment)`；调用实参：`AppUpdateCheckKey(250, "stable", "production")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:433`、`:146-147`）
- 端点：`@GET("appupdatecheker") @Query("version") String, @Query("platform") String`（`data/source/remote/api/TuwinSuspendApi.java`，注意拼写 `cheker`），`platform` 恒为 `"android"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedAppUpdateGateway.java:51`）；baseUrl = `FeedbackApiEndpoint.BASE_URL = "http://ali.tuwinsmart.com/"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/gateway/FeedbackApiEndpoint.java:10`）→ **明文 HTTP**；profile `HttpClientProfile.INTERNET_API`（connect 10 / read 30 / write 30）
- URL 合法性：`isNetworkDownloadUrl(s)` = `HttpUrl.parse(s)` 非空 && scheme ∈ {http,https} && `username` 空 && `password` 空 && `host` 非空（`AppUpdateCoordinatorKt.java`）
- 判定：`hasNewVersion == false` → `NO_UPDATE`；否则要求 `appInfo != null` 且 `isNetworkDownloadUrl(appInfo.downloadUrl)`，不满足 → `CHECK_FAILED` + `IllegalStateException("Invalid app update response")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/AppUpdateCoordinator.java:514-522`；`:517` 的 `appInfo != null ||` 是 jadx 反转产物，原义为 `appInfo == null || !valid`）
- 路由不可用：捕获 `RouteUnavailableException` → `WAITING_FOR_INTERNET_ROUTE` + `WaitingForInternetRoute(key)`（`:498-500`），由 `NetworkRuntime.addInternetRouteListener` 在拿到 READY 路由后重新触发（`TuwinApplication.requestInternetRouteUpgradeCheck()` → `checkUpdateApi()` → `checkUpdate()`，`:688-694`）
- lease 存活检查：响应回来后先 `lease.requireActive()`（`:513`），`CancellationException` 中 `RouteSupersededException` 记 reason `"RouteSuperseded"`，其余 `"Cancelled"`（`:530-536`）
- 弹窗抑制：`appUpdatePromptKey(bean) = trim(version) + "|" + trim(downloadUrl)`，`presentedAppUpdateKeys` 集合去重；不在 `HomeActivity` 可展示时挂到 `pendingAppUpdateBean`，回 Home 后 `tryShowPendingAppUpdatePrompt()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:468-498`、`:500-537`）
- 下载安装：落盘 `filesDir/app-updates/tuwin_smart_<System.currentTimeMillis()>.apk`，intent 走 `NetworkIntent.Internet("app_update_download")`，`ResumePolicy.Disabled` + `IntegrityPolicy.None`（**不校验 APK 哈希**），源经 `AuthorizedTransferSource.Internet.authorize(url, setOf(host))` 过 host 白名单策略；然后 `FileProvider.getUriForFile(activity, packageName + ".fileProvider", file)` + `Intent.ACTION_VIEW` + `application/vnd.android.package-archive` + flags `1`(FLAG_ACTIVITY_NEW_TASK) | `268435456`(FLAG_GRANT_READ_URI_PERMISSION)（`:578-611`、`:679-686`）
- 诊断事件名：`app_update_download_requested`，字段 `target_version / source(host+脱敏) / forced`（`:573`）

---

## 4. 预览与播放

### 4.1 ijkplayer / `IjkMediaPlayer` 初始化参数（key=value 逐项）

App 层**从不直接 new `IjkMediaPlayer`**：全部 ijk 参数都以 GSY 的 `VideoOptionModel(category, name, value)` 列表形式下发，由 `IjkPlayerManager` 在 prepare 阶段逐条 `ijkMediaPlayer.setOption(...)` 落地——`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:94`（`initIJKOption(mediaPlayer, list)`）→ `:320-331`（`valueType == 0` 走 int 重载，否则走 String 重载）。类别常量：`OPT_CATEGORY_FORMAT = 1`、`OPT_CATEGORY_CODEC = 2`、`OPT_CATEGORY_SWS = 3`、`OPT_CATEGORY_PLAYER = 4`（`_work/tuwin_src/sources/tv/danmaku/ijk/media/player/IjkMediaPlayer.java:85-88`）；`SDL_FCC_RV32 = 842225234`（同文件 `:92`）。

> 注意：`IjkMediaPlayer` 的 `import` 在几十条与播放无关的文件里出现（`core/device/p005m3/*`、`core/network/*`、`data/repository/*` 等），那只是 jadx 把 `IjkMediaPlayer.OnNativeInvokeListener.ARG_*` 一类**内联常量**引用渲染成 import，不代表真的用了播放器。

**唯一配置入口**是 object `VideoUtil`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:21-22`）。两套列表**整体互相替换**（`GSYVideoManager.instance().setOptionModelList(...)`，同文件 `:83`、`:94`），不是叠加。

**A. 实时预览 `VideoUtil.initLive(transport)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:57-84`，共 18 项）**；`initLive$default` 缺省参数是 `RtspTransport.TCP`（`:50-55`）：

| # | cat | key | value | 位置（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java`） |
|---|---|---|---|---|
| 1 | 1 FORMAT | `rtsp_transport` | `"tcp"` / `"udp"`（`transport.name().toLowerCase(Locale.ROOT)`）；**AUTO 时此项完全不写** | `:60-65` |
| 2 | 1 | `fflags` | `"nobuffer"` | `:66` |
| 3 | 1 | `flags` | `"low_delay"` | `:67` |
| 4 | 1 | `avioflags` | `"direct"` | `:68` |
| 5 | 1 | `flush_packets` | `1` | `:69` |
| 6 | 1 | *（键名来自混淆常量 `com.umeng.ccg.C3174a.f2695E`）* | `0` | `:70` |
| 7 | 1 | `probesize` | `32768` | `:71` |
| 8 | 1 | `analyzeduration` | `0` | `:72` |
| 9 | 1 | `reorder_queue_size` | `0` | `:73` |
| 10 | 4 PLAYER | `packet-buffering` | `0` | `:74` |
| 11 | 4 | `framedrop` | `1` | `:75` |
| 12 | 4 | `min-frames` | `1` | `:76` |
| 13 | 4 | `infbuf` | `0` | `:77` |
| 14 | 4 | `max_cached_duration` | `50` | `:78` |
| 15 | 4 | `max-buffer-size` | `262144`（256 KiB） | `:79` |
| 16 | 2 CODEC | `skip_loop_filter` | `48` | `:80` |
| 17 | 4 | `an` | `1` | `:81` |
| 18 | — | `IjkPlayerManager.setLogLevel(8)`（随后 `IjkMediaPlayer.native_setLogLevel`，`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:93`） | `8` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:82` |

**第 6 项键名静态无解**：`com.umeng.ccg.C3174a` 的 `.java` 与类清单条目在归档里都不存在（`_work/re/tuwin/classes-all.tsv` 里 `com.umeng.ccg` 只有 `C3177d`/`CcgAgent`，`_work/tuwin_src/sources/com/umeng/ccg/` 下只有这两个文件），而 `_work/re/tuwin/apk-entries.tsv:9` 显示还有 `classes3.dex`（压缩后 1,229,312 B）没被喂给本次 jadx。**补证手段**：单独对 `classes3.dex` 跑 jadx 读 `C3174a` 的 `static {}` 初始化（同类的缺证项还有 `com.generalplus.ffmpegLib.ffmpegWrapper`，见 §7.2）。

**B. 录像回放 `VideoUtil.normalPlaybackOptions$app_release_64(enableSoundTouch)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:97-103`，`initNormal(z)` 见 `:93-95`，缺省 `false`）**，26 项 + 条件 1 项：

| # | cat | key | value | 位置（同文件） |
|---|---|---|---|---|
| 1 | 1 | `dns_cache_clear` | `1` | `:98` |
| 2 | 4 | `mediacodec` | `0`（硬解关） | `:98` |
| 3 | 4 | `opensles` | `0` | `:98` |
| 4 | 4 | `overlay-format` | `IjkMediaPlayer.SDL_FCC_RV32` = 842225234 | `:98` |
| 5 | 1 | `http-detect-range-support` | `0` | `:98` |
| 6 | 4 | `mediacodec-hevc` | `1` | `:98` |
| 7 | 1 | `analyzeduration` | `1` | `:98` |
| 8 | 1 | `rtsp_transport` | `"tcp"`（写死，与 A 套的动态取值不同） | `:98` |
| 9 | 1 | `analyzemaxduration` | `100` | `:98` |
| 10 | 1 | `flush_packets` | `1` | `:98` |
| 11 | 4 | `start-on-prepared` | `1` | `:98` |
| 12 | 4 | `fast` | `1` | `:98` |
| 13 | 4 | `mediacodec-auto-rotate` | `0` | `:98` |
| 14 | 4 | `mediacodec-handle-resolution-change` | `0` | `:98` |
| 15 | 4 | `packet-buffering` | `1`（回放开缓冲，与预览相反） | `:98` |
| 16 | 4 | `max-buffer-size` | `15728640`（15 MiB，预览的 60 倍） | `:98` |
| 17 | 4 | `min-frames` | `100` | `:98` |
| 18 | 1 | `probesize` | `10485760`（10 MiB，预览的 320 倍） | `:98` |
| 19 | 4 | `infbuf` | `0` | `:98` |
| 20 | 4 | `reconnect` | `5` | `:98` |
| 21 | 1 | `http-detect-range-support` | `0`（**重复项**，与第 5 项同键同值） | `:98` |
| 22 | 2 | `skip_loop_filter` | `-16`（预览是 `48`） | `:98` |
| 23 | 2 | `skip_frame` | `0` | `:98` |
| 24 | 4 | `framedrop` | `5` | `:98` |
| 25 | 4 | `fps` | `20` | `:98` |
| 26 | 4 | `dropframe_when_poor_network` | `0` | `:98` |
| 27 | 4 | `soundtouch` | `1`，仅当 `enableSoundTouch == true` | `:99-101` |

调用点：`initNormal(false)` → `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/DailyDetailActivity.java:735`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/VideoPlayActivity.java:250`；`initNormal(true)`（倍速需要 soundtouch）→ `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackController.java:99`；`initLive(transport)` 以方法引用形式作为 `preparePlayer` 回调注入 GSY 适配器 → `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/p011m3/M3VideoPlayActivity.java:266-281`（`FunctionReferenceImpl(..., VideoUtil.class, "initLive", ...)`，`invoke2` 在 `:280`）。

另有 GSY 库自带的 3 条：`GSYVideoType.isMediaCodec()` 为真时 `setOption(4,"mediacodec",1)`、`(4,"mediacodec-auto-rotate",1)`、`(4,"mediacodec-handle-resolution-change",1)`（`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:63-67`）——与 B 套里的 `mediacodec=0` 冲突时以 `initIJKOption`（`:94`，在其之后执行）为准，即 **App 列表覆盖库默认**。

### 4.2 `FFmpegTexturePlayerView` / `FFmpegRtspOptions` 参数

自研链路**没有 setOption 那种键值 API**，整条 native 播放只有一个入口：`ffmpegWrapper.naInitAndPlay(rtspUrl, options)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:295`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:248`），`options` 是**分号分隔的 `k=v` 串**，由 `FFmpegRtspOptions.compose()` 统一整形。

**`FFmpegRtspOptions`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegRtspOptions.java`）**
- 常量：`DEFAULT_PROBE_SIZE_BYTES = 32768`（`:19`）、`DEFAULT_ANALYZE_DURATION_US = 1000000`（`:20`）。
- `compose(options, forceUdpTransport)`（`:26-75`）算法：按 `;` 拆分 + `trim` + 丢空串（`:28-40`）→ 若 `forceUdpTransport` 则**删掉所有键名为 `rtsp_transport` 的项并在首位插入 `rtsp_transport=udp`**（`:41-50`）→ 若不存在 `probesize` 则追加 **`probesize=32768`**（`:52-63`）→ 若不存在 `analyzeduration` 则追加 **`analyzeduration=1000000`**（`:64-73`）→ 用 `;` 重新拼接（`:74`）。
- 键名比较：`optionName(s)` = `substringBefore('=').trim().toLowerCase(Locale.ROOT)`（`:78-82`），所以大小写不敏感。
- 上游唯一注入的 `options` 实参是 `FFmpegNativePlayerAdapter.Companion.transportOptions(transport)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegNativePlayerAdapter.java:366-376`）：`TCP → "rtsp_transport=tcp"`（`:371`）、`UDP → ""`（`:373`，靠 `forceUdpTransport=true` 让 compose 补 udp）、`AUTO → ""`（`:373`）。
- 因此自研路最终串只有三种形态：`rtsp_transport=tcp;probesize=32768;analyzeduration=1000000`、`rtsp_transport=udp;probesize=32768;analyzeduration=1000000`、`probesize=32768;analyzeduration=1000000`。
- 预览的低延迟**不在** options 串里，而是 ffmpeg 侧默认 + `naSetStreaming(true)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:290`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:243`）这条「流模式」开关；native 内部还暴露了 `naSetBufferingTime` / `naSetDecodeOptions` / `naSetCovertDecodeFrameFormat` 等符号但 Java 侧无调用（见 §7.2）。

**视图侧其它渲染参数**
- `FFmpegTexturePlayerView`（TextureView）：`FRAME_DELAY_MS = 16`、`MAX_RETRY_COUNT = 5`、`RETRY_DELAY_MS = 500`、`TAG = "FFmpegTexturePlayerView"`（`:51-54`），`setKeepScreenOn(true)`（`:170`），`setSurfaceTextureListener(this)`（`:169`），`ffmpegWrapper.getInstance().SetViewHandler(statusHandler)`（`:171`）。
- `FFmpegPlayerView`（GLSurfaceView，横屏/全屏路）：`MAX_RETRY_COUNT = 5`、`RETRY_DELAY_MS = 500`、`RTSP_CLOSE_POLL_INTERVAL_MS = 20`、`RTSP_CLOSE_TIMEOUT_MS = 5000`、`SNAPSHOT_TIMEOUT_MS = 3000`、`STATUS_PLAYING = 0`、`STATUS_STOPPED = 1`、`STATUS_BUFFERING = 4`（`:49-56`）；`setEGLContextClientVersion(2)`（`:193`）+ `setRenderer(ffmpegWrapper.getInstance())`（`:194`）。
- 状态回调协议：native 往 `Handler` 发消息，`what` 语义 = `0` 流已打开（仅进入「等首帧」，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:152-163` / `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:131-142`）、`1` 停止（触发 `scheduleRetry`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:165-176` / `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:144-164`）、`2` 截图完成（仅 GL 版，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:178-181`）、`4` buffering（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:182-189` / `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:145-154`）。**没有 `what == 3` 的分支**，也没有独立的 error 消息——错误只能靠 `naInitAndPlay` 返回码与首帧超时体现。
- 首帧判定：`FFmpegFirstFrameMonitor`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegFirstFrameMonitor.java`）默认 `timeoutMs = 15000`、`pollIntervalMs = 50`（`:47` 的合成构造器里 `(i & 16) != 0 ? 15000L`、`(i & 32) != 0 ? 50L`；两个视图都用 `0L, 0L, 48, null` 走默认，见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:124`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:145`）；帧计数来自 `ffmpegWrapper.naGetFrameCnt()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView$firstFrameMonitor$1.java:22`）；读失败按 `-1` 处理（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegFirstFrameMonitor.java:146-149`）。判据在 `FFmpegFirstFrameGate`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegFirstFrameGate.java`）：`reset(coerceAtLeast(frameCount,0))`（`:15-19`）、`markNativePlaying()` 幂等（`:21-27`）、`observe()` 要求「已 native playing && 未收到首帧 && count ≥ 0 && (count > baseline || (count < baseline && count > 0))」——即**计数器回绕也算新帧**（`:29-41`）。超时回调 → `handleFirstFrameTimeout()` → `stopInternal()` + `scheduleRetry("Preview first frame timed out")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:548-554`）。
- 端点/URL 模板（`rtsp://host:port/livestream/1`、`/?action=stream` 等）**归属协议面附录 §7**，本节只列播放器如何消费（见 §4.4 末表）。

### 4.3 GSY 播放器参数

GSY 只做「ijk 的宿主」，App 侧配置面很小：

| 项 | 值 / 行为 | 位置 |
|---|---|---|
| 播放内核 | `PlayerFactory.setPlayManager(IjkPlayerManager.class)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:355` |
| 原始资源播放 | `GSYVideoManager.instance().enableRawPlay(app)`，实现只是保存 application context（`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/GSYVideoBaseManager.java:617-619`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:356` |
| 参数注入 | `GSYVideoManager.instance().setOptionModelList(list)`（存字段，`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/GSYVideoBaseManager.java:625-627`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:83`、`:94` |
| 日志级别 | `IjkPlayerManager.setLogLevel(8)`（仅 `initLive` 设置） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:82` |
| 静音 | `GSYVideoManager.instance().setNeedMute(true)` → `ijk.setVolume(0f,0f)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/DailyDetailActivity.java:764`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/VideoPlayActivity.java:284`；`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:142-149` |
| 倍速 | `videoView.setSpeedPlaying(speed, true)` → 追加 `cat4 soundtouch=1` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackController.java:216-221`、`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:117-139` |
| 数据源 | `setUpLazy(url, cache=false, cachePath=null, mapHeadData=null, title)` → 仅记字段、`mUrl="waiting"`、`mCurrentState=0`；同一 listener 在 2000 ms 内重复 set 会 `return false` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/GsyNativePlayerAdapter.java:92`、`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/video/base/GSYVideoControlView.java:1207-1221` |
| 起播 / 释放 | `startPlayLogic()` / `release()` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/GsyNativePlayerAdapter.java:124`、`:130` |
| 错误映射 | `onPlayError` → `IllegalStateException("GSY media playback failed")` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/GsyNativePlayerAdapter.java:115-119` |
| 库内置缓冲超时 | `BUFFER_TIME_OUT_ERROR = -192` | `_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/GSYVideoBaseManager.java:30`、`:59` |
| 页面生命周期 | `GSYVideoManager.onResume()` / `onPause()` / `releaseAllVideos()` / `backFromWindowFull()` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java:359`、`:442`、`:448`、`:453` |

播放器包装：`GsyNativePlayerAdapter`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/GsyNativePlayerAdapter.java`，实现 `core/media/NativePlayerAdapter`）在 `start()` 里先 `requestStop()`、再新建 `CompletableDeferred` 关闭信号、再调 `preparePlayer(transport)`（即 `VideoUtil.initLive`）、最后 `setUpLazy + startPlayLogic`（`:86-124`）；`awaitClosed()` 就是 `closeSignal.await()`（`:136-139`）。Ride5 小时回放另有一个自实现 `NativePlayerAdapter`，它对 transport 有硬校验：`rtspTransport != RtspTransport.AUTO → IllegalArgumentException("RIDE5 HTTP playback does not support RTSP transport options")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackController.java:105-108`）。

### 4.4 `RtspTransport` 取值与选择逻辑

枚举只有 3 个值，**顺序即 ordinal**：`AUTO = 0`、`TCP = 1`、`UDP = 2`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/RtspTransport.java:11-14`，同 `catalog-enums.md:93`）。它**没有** `lowerOrdinal` / 数值码，各处靠 `WhenMappings` 做 switch 映射（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegNativePlayerAdapter.java:340-356`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:26-45`，两份映射内容一致：TCP=1、UDP=2、AUTO=3）。

选择方（生产 `MediaSessionRequest.requestedTransport` 的地方）：

| 场景 | 选择逻辑 | 结果 | 位置（`_work/tuwin_src/sources/...`） |
|---|---|---|---|
| 详情页实时预览 | `DeviceDetailRtspTransportPolicy.forDevice()`：只有 `RIDE6 → AUTO`，其余全部 `UDP` | RIDE6=AUTO；M3/RIDE5/RIDE3PRO=UDP | `com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailRtspTransportPolicy.java:31-37`（WhenMappings 只登记 RIDE6，`:15-26`），调用 `device/detail/DeviceDetailActivity.java:1942` |
| Ride3Pro/Ride6 回放 | `RidePlaybackRtspTransportPolicy.forDevice()`：`RIDE3PRO`/`RIDE6 → AUTO`，其它设备抛 `IllegalArgumentException("Ride RTSP playback does not support " + deviceType.getCode())` | AUTO | `com/tuwinsmart/tuwin/presentation/p010ui/album/RidePlaybackRtspTransportPolicy.java:17-22`，调用 `album/Ride3ProDailyDetailActivity.java:2705` |
| M3 文件回放 | 写死 `RtspTransport.AUTO` | AUTO | `com/tuwinsmart/tuwin/presentation/p010ui/storage/p011m3/M3VideoPlayActivity.java:677` |
| Ride5 小时回放 | 写死 `RtspTransport.AUTO`（且适配器拒绝非 AUTO） | AUTO（走 HTTP 文件而非 RTSP） | `com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackActivity.java:1702` |
| Home 卡片小窗预览 | 写死 `RtspTransport.UDP` | UDP | `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListAdapter.java:998` |
| 未显式传参 | `MediaSessionRequest` 合成构造器默认 `RtspTransport.AUTO` | AUTO | `com/tuwinsmart/tuwin/core/media/MediaSessionRequest.java:165` |

消费方（transport → 播放器实参）：

| 适配器 | 转换 | 位置 |
|---|---|---|
| FFmpeg（自研 native） | `transportOptions(t)`：TCP→`"rtsp_transport=tcp"`，UDP/AUTO→`""`；第二个实参 `forceUdpTransport = (t == UDP)` 交给 `FFmpegRtspOptions.compose` | `com/tuwinsmart/tuwin/presentation/widget/video/FFmpegNativePlayerAdapter.java:366-376`、`:105`、`:149` |
| GSY（ijk） | `initLive(t)`：`t ∈ {TCP, UDP}` 才写 `rtsp_transport = t.name().toLowerCase(ROOT)`；AUTO 不写（用 ijk 默认） | `com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:60-65` |
| Ride5 HTTP | 非 AUTO 直接抛异常 | `com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackController.java:106-108` |

endpoint 侧还有一条约束：`DeviceMediaEndpoint` 构造里 `protocol == HTTP && transport != RtspTransport.AUTO` → `IllegalArgumentException("HTTP media must not declare an RTSP transport")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/DeviceMediaEndpoint.java:130`）。设备侧给出的 RTSP 端点统一是 `RtspTransport.AUTO`（`core/device/ride5/Ride5DeviceMediaPort.java:110`、`core/device/ride3pro/DocumentedRide3ProMediaEndpointResolver.java:31`）。

### 4.5 纹理渲染与 Surface 生命周期

**谁持有 Surface**：两条自研路各自持有，互不共享，且 native 侧是**单实例渲染器**。

`FFmpegTexturePlayerView`（TextureView + 自管 EGL，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java`）：
- 视图自身实现 `TextureView.SurfaceTextureListener`（`:47`），构造里 `setSurfaceTextureListener(this)`（`:169`）。
- `onSurfaceTextureAvailable(surface,w,h)`（`:566-572`）→ 记 `surfaceWidth/Height` → `startRenderThread(surface,w,h)` → `updateTransform()`。
- `startRenderThread`（`:613-635`）：**全局互斥**——`static FFmpegTexturePlayerView activeRenderer`（`:55`），`synchronized(FFmpegTexturePlayerView.class)` 内若已有别的实例在渲染就打日志 `"Another renderer is active, skip starting"` 并**直接返回**（`:615-619`）；同实例且线程活着则只 `updateSize(w,h)`（`:622-628`）。
- `RenderThread`（`:659-835`，线程名 `FFmpegTextureRenderThread`，`:674`）：`run()` 先 `initEgl()`，成功后 `ffmpegWrapper.getInstance().onSurfaceCreated(null,null)`（`:709`，异常只记日志不致命），再 `applySurfaceSizeIfNeeded(true)`，然后循环 `onDrawFrame(null)` + `EGL14.eglSwapBuffers` + `Thread.sleep(16)`（`:714-730`）；`eglSwapBuffers` 失败或 display/surface 为 null 则 break 并 `cleanupEgl()`。
- EGL 参数：`eglGetDisplay(EGL_DEFAULT_DISPLAY)`、`eglInitialize`；`eglChooseConfig` 属性表 `{EGL_RECORDABLE_ANDROID(0x3142)=1? -> 12352=0x3040 EGL_BUFFER_SIZE,4, 12324=0x3024 EGL_BLUE_SIZE,8, 12323=0x3023 EGL_GREEN_SIZE,8, 12322=0x3022 EGL_RED_SIZE,8, 12321=0x3021 EGL_ALPHA_SIZE,8, 12325=0x3025 EGL_DEPTH_SIZE,0, 12326=0x3026 EGL_STENCIL_SIZE,0, 12344=0x3038 EGL_NONE}`（`:776`）；`eglCreateContext` 用 `{12440=0x3058 EGL_CONTEXT_CLIENT_VERSION, 2, 12344}` 即 **GLES 2.0**（`:785`）；`eglCreateWindowSurface` 用 `new Surface(surfaceTexture)`（`:790-791`），失败路径会 `surface.release()`（`:793`、`:799`）。
- 尺寸变化：`onSurfaceTextureSizeChanged`（`:575-584`）→ `renderThread.updateSize(w,h)`（只置 `pendingWidth/Height + sizeChanged`，`synchronized(lock)`，`:693-700`），由渲染线程下一帧 `applySurfaceSizeIfNeeded` 消费后调 `onSurfaceChanged(null,w,h)`（`:738-762`）。
- 销毁：`onSurfaceTextureDestroyed`（`:587-591`）→ `stopRenderThread()`（**不**调 `surfaceTexture.release()`，返回 `true` 让系统释放）→ `requestStop()` + `join(1500ms)` + 置空 + 清 `activeRenderer`（`:637-655`）；`cleanupEgl()` 顺序为 `eglMakeCurrent(NO_SURFACE,NO_SURFACE,NO_CONTEXT)` → `eglDestroySurface` → `eglDestroyContext` → `eglTerminate` → `windowSurface.release()` 并把 5 个 EGL 字段置 null（`:811-834`）。
- `release()`（`:556-563`）：`cancelRetry()` → `stop()` → `stopRenderThread()` → `callback = null` → `nativePlayingListener = null`。
- **错误重建路径**：native 报 `what == 1`（停止）或首帧超时，都走 `scheduleRetry()`，重试只是重新 `startPlayback(currentUrl, ...)`（`:514-522`），**不重建 Surface**；EGL 侧的重建只发生在 `initEgl()` 失败时（直接 `cleanupEgl()` 退出线程，`:704-707`），要恢复必须等 `onSurfaceTextureAvailable` 再来一次。
- 画面变换：`buildContentTransform(viewW,viewH,videoW,videoH,rotationDegrees)`（`:186-206`）——`min(scale)` 后**乘 1.78 的固定系数**（`:198-199`，两处 `* 1.78f`，与画面比例硬耦合）；`resolveVideoSize()` 拿 `naGetVideoRes()`，取不到就退回 **16:9**（`:593-611`）；`updateTransform()` 强制主线程（非主线程 `post`，`:226-240`）。

`FFmpegPlayerView`（GLSurfaceView，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java`）：把渲染完全交给 `GLSurfaceView` + `ffmpegWrapper.getInstance()` 作为 `Renderer`（`:193-194`），三个回调 `onSurfaceCreated → naInitDrawFrame()`（`:679-681`）、`onSurfaceChanged(w,h) → naSetup(w,h)`（`:685-687`）、`onDrawFrame → naDrawFrame()`（`:691-693`）；`onDetachedFromWindow()` 只 `cancelRetry()`（`:673-675`），**不 release native**——真正清理靠 `release()`/`stop()`；`bindStatusHandler()` 会在 `play/pause/resume/saveSnapshot` 前重新把 `statusHandler` 绑给 native（`:196`、`:213`、`:347`、`:354`、`:480`、`:702-705`），用于对抗 native 单实例只记最后一个 handler 的问题。

GSY 路的 Surface 由 `IjkPlayerManager.showDisplay(Message)` 管：`message.obj == null` 时 `mediaPlayer.setSurface(null)`，否则 `setSurface((Surface) msg.obj)` 且要求 `surface.isValid()`（`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:102-114`）。

### 4.6 失败重试与超时

| 项 | 值 | 位置 |
|---|---|---|
| 自研播放器最大重试次数 | `5`（`MAX_RETRY_COUNT`，`retryCount >= 5` 即放弃） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:52`、`:470-483`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:49`、`:389-404` |
| 重试间隔 | 固定 `500 ms`（`Handler.postDelayed`，非指数退避） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:53`、`:510`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:50` |
| 重试前回调 | `callback.onRetrying(retryCount, 5)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:496-499`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:415` |
| 放弃时的错误 | 无 callback → 只打日志；有 callback → `onError(lastError ?: getString(R.string.connection_failed_max_retry))` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:473-481` |
| 首帧超时 | `15000 ms`，轮询 `50 ms` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegFirstFrameMonitor.java:47` |
| 手动重连延时 | `300 ms` 后 `play(currentUrl, ...)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:439-453`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:359-374` |
| 等 RTSP 真正关闭 | `stopAndAwaitRtspClosed(timeoutMs = 5000)`，轮询 `naStatus() != E_PlayerStatus_Stoped` 每 `20 ms`；`timeoutMs <= 0` → `IllegalArgumentException("timeoutMs must be greater than 0")` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:318-323`、`:343-345`、`:396-407`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:270-327`（超时会打 `"Timed out waiting for RTSP session close after N ms"`，`:323`） |
| 截图超时 | `SNAPSHOT_TIMEOUT_MS = 3000`（`naSaveSnapshot` 返回非 0 立即失败 `"save snapshot failed: <code>"`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:53`、`:488-494` |
| 渲染线程 join | `1500 ms` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:644` |
| GSY/ijk 缓冲超时 | `BUFFER_TIME_OUT_ERROR = -192`（库内定时器上报） | `_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/GSYVideoBaseManager.java:30`、`:59` |
| ijk 回放自动重连 | option `reconnect = 5` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:98` |
| 会话层收尾 | `MediaSessionCoordinator.cleanup()` 在 `NonCancellable` 上下文里跑：置 `STOPPING` → dispose 路由监听 → `player.requestStop()`（异常吞掉）→ `awaitClosed()` → `player.release()`（异常吞掉）→ `bindingLease.close()` → `routeLease.close()` → 终态 `CLOSED`（无 failure）或 `FAILED`（有 failure） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/MediaSessionCoordinator.java:580-655`、`:659-662` |
| native 失败 | `onError` → 记 `session.failure`、写 `MediaState.FAILED`（带当前 `route.revision`）、`monitorJob.cancel(CancellationException("Native player failed", error))`、`startJob.cancel(同)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/MediaSessionCoordinator.java:510-528` |

**编排层不做自动重连**：`MediaSessionCoordinator` 里没有任何 retry/delay，重试全在 View 层（上表前 5 行）；一旦 View 放弃并回调 `onError`，会话直接进 `FAILED` 并释放路由，需要用户重新点播放。路由变更（`routeRevision` 变了）由 `start()` 里注册的监听触发 `cleanup`，属于「换路由即重建」，不是重试。

---

## 5. 事件与状态推送

包里有**两套并行的事件机制**：老的 greenrobot EventBus（`core/event/*` 的 5 个类，给 UI 页面间广播用）和新的 Flow 状态层（`DeviceSessionManager` / `MediaStateStore` / `core/network/*`，给设备会话与播放状态用）。二者不互通：没有任何 `core/event` 类被 Flow 侧引用，也没有任何 Flow 被 post 进 EventBus。

### 5.1 `core/event` 消息类型枚举与取值

**先说结论：这一包里没有枚举、也没有任何数值码**，5 个文件就是 5 个 EventBus 事件标签类（`_work/re/tuwin/api/com__tuwinsmart__tuwin__core__event.md` 全量 5 类型；`_work/re/tuwin/catalog-consts.md` 里 `com.tuwinsmart.tuwin.core.event.*` 零条目；`_work/re/tuwin/own-constants.tsv` 里整包只有 1 条 `MSG_` 常量且不属于本包）。逐个抄：

| 事件类 | 载荷 | 位置 | 生产者（post） | 消费者（@Subscribe） |
|---|---|---|---|---|
| `DeviceAddedEvent` | 无字段（空类） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/DeviceAddedEvent.java:9` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java:1058`、`:1119`；`presentation/p010ui/device/list/DeviceListActivity.java:342`；`presentation/p010ui/mine/MoreSettingsActivity.java:2463` | `presentation/p010ui/connect/fragment/ConnectFragment.java:860`（`@Subscribe(threadMode = MAIN)`） |
| `NetworkChangeEvent` | `List<Network> networks`（可空） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/NetworkChangeEvent.java:11-19` | `core/util/network/NetworkManager.java:64`、`:101`、`:104`（`postSticky`；`:101` 传的是 `null`） | `presentation/p010ui/connect/fragment/ConnectFragment.java:837`、`:847`（`@Subscribe(sticky = true, threadMode = MAIN)`，收完 `removeStickyEvent`） |
| `SoftVersionUpdateCompleteEvent` | 无字段 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/SoftVersionUpdateCompleteEvent.java:9` | `core/util/UpgradeHelper.java:137`、`:354`（`postSticky`） | `presentation/p010ui/connect/fragment/ConnectFragment.java:847` 同族 sticky 订阅 |
| `TaskDownloadFinishEvent` | 无字段 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/TaskDownloadFinishEvent.java:9` | `core/util/download/DownloadFileExecution.java:384`；`core/util/download/DownloadUtil.java:1524`、`:2558` | `presentation/p010ui/album/fragment/AlbumFragment.java:620`（`@Subscribe(threadMode = MAIN)`） |
| `TaskFinishInsertEvent` | `DownloadTask task`（`com.lzy.okserver.download.DownloadTask`，data class） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/TaskFinishInsertEvent.java:11-46` | `presentation/p010ui/download/adapter/DownloadItemViewHolder.java:125` | `presentation/p010ui/download/fragment/LocalDownloadListFragment.java:124` |

EventBus 注册点只有 3 个页面：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/fragment/AlbumFragment.java:91-92`（注册）/`:665-666`（注销）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:199-200`/`:971-972`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/download/fragment/LocalDownloadListFragment.java:99-102`/`:136-137`。另有非 `core/event` 的 sticky 事件 `EnterBean`（`presentation/p010ui/album/ShowPicsActivity.java:325`、`:331`、`:337` post，`:86` `removeStickyEvent` 取回）——说明 sticky 总线被复用来传相册上下文。

**真正「带取值的消息类型」在 socket 层**：M3 设备推送消息 `M3SocketMessage`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`）是 8 个分支的 sealed 家族，判别键是 JSON 里的**字符串** `msgid`（不是数字）：

| `msgid` | 消息类 | 载荷字段 | 解码位置（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3JsonMessageDecoder.java`） |
|---|---|---|---|
| `rec_time` | `M3SocketMessage.RecordingTimeUpdate` | `int recConsumTime`、`int recFileTime`、`long time` | `:71-76`（字段默认 `recConsumTime=0`） |
| `battery` | `BatteryUpdate` | `M3BatteryInfo info`（含 `capacity`）、`long time` | `:78-83` |
| `sd` | `SDCardUpdate` | `int status`（**缺省 99**）、`long time` | `:85-90` |
| `cap` | `CaptureUpdate` | `int value`、`long time` | `:92-97` |
| `mic` | `MicUpdate` | `boolean isMicOn`（`value == 1`）、`long time` | `:99-104` |
| `rec` | `RecordingUpdate` | `boolean isRecording`（`value == 1`）、`long time` | `:106-111` |
| `countdown_time` | `CountdownTimeUpdate` | `int value`、`long time` | `:113-118` |
| 其它 / JSON 解析失败 / 空帧 | `Unknown(rawMessage)`（整帧原文） | `String rawMessage` | `:121`、`:130`；空串直接 `return null`（`:33-35`） |

字段取法：`decode()` 先 `trim` 再 `JsonParser.parseString`，读 `msgid`（非 primitive 视为 `""`）与 `info`（非 object 视为 `null`），`switch` 按 `hashCode` 分派（`:40-68`）。

### 5.2 `core/process` 消息类型枚举与取值

`core/process` **只有一个类**，没有任何消息/事件枚举（`_work/re/tuwin/api/com__tuwinsmart__tuwin__core__process.md` 全文 1 类型 / 2 方法）：

- `AppProcessRole`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/process/AppProcessRole.java`）
  - 唯一常量：`public static final String INTERNET_PROCESS_SUFFIX = ":internet"`（`:19`）——**没有数值型码表**。
  - `isInternetProcess(context)`（`:26-56`）：`Build.VERSION.SDK_INT >= 28` → `Application.getProcessName()`（`:30`）；否则 `getSystemService("activity")` → `ActivityManager.getRunningAppProcesses()` 线性找 `pid == Process.myPid()` 取 `processName`（`:34-53`）；返回 `processName == context.packageName + ":internet"`（`:55`）。
- 进程分工由 manifest + `TuwinApplication` 决定，不是消息路由：
  - `com.tuwinsmart.tuwin.presentation.ui.internet.ExternalWebActivity` 声明 `process=:internet`（`_work/re/tuwin/manifest.md:131`）；友盟 `com.efs.sdk.memleaksdk.monitor.UMonitorService` 声明 `process=:u_heap`（`:150`）。
  - 跨进程只共享一个 `ContentProvider`：`com.tuwinsmart.tuwin.core.internet.InternetRouteRevisionProvider`，`authorities=com.tuwinsmart.tuwin.internetRouteRevision`（`_work/re/tuwin/manifest.md:177`）；另有 `com.noober.background.BackgroundContentProvider`（`multiprocess=true`，`:179`）。
  - `TuwinApplication.onCreate()`：`:261` 先装 `AppCrashHandler`，`:263` 判进程；**`:internet` 分支只做 `WebView.setDataDirectorySuffix("internet")`（且要求 SDK ≥ 28，`:264-265`）**；主进程分支才跑 `Gloading.initDefault`（`:268`）、`UmengSdkBridge.preInit(app, UMENG_APP_KEY, UMENG_CHANNEL)`（`:269`）、`initKoin()`（`:270`）、`startPreConsentNetworkRuntime()`（`:271`）、`initThirdLibs()`（`:272`）。**即 `:internet` 子进程里没有 Koin、没有 NetworkRuntime、没有设备会话**，联网设备面全部在主进程。

数值化的「消息」实际散在别处，与 TUWIN 相关的三张码表（供交叉引用）：

| 类 | 常量 = 值 | 位置 |
|---|---|---|
| `FFmpegPlayerView` | `STATUS_PLAYING = 0`、`STATUS_STOPPED = 1`、`STATUS_BUFFERING = 4`（native → View 的 `Message.what`；`2` 是截图完成，无常量名） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:54-56`、`:178-181` |
| `UpgradeDevice` | `MSG_UPLOAD_FAILED = 10003`（`private static final int`，全库唯一 `MSG_` 常量） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java:38`（`own-constants.tsv` 同行记录）、分发见 §3.5 |
| `M3ControlChannelState` | `READY / RECOVERING / RECOVERABLE / UNAVAILABLE`（无 ordinal 码） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3ControlChannelState.java:11-15` |

### 5.3 Flow 共享策略（回放 / 缓冲 / 并发）

**整个 `com.tuwinsmart` 里没有任何 `shareIn` / `stateIn`**（对 `_work/tuwin_src/sources/com/tuwinsmart/**` 全文 grep `shareIn`、`stateIn(` 只命中 6 处同名字段 `Ride5HourlyPlaybackActivity.shareInProgress`，是个「正在分享」布尔位，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackActivity.java:175`）。所有热流都是**手写单实例 `MutableStateFlow` / `MutableSharedFlow` + `asStateFlow` / `asSharedFlow` 只读投影**，没有引用计数、没有 `SharingStarted`。

**SharedFlow 参数逐条**（`SharedFlowKt.MutableSharedFlow$default(replay, extraBufferCapacity, onBufferOverflow, mask, null)`，形参序为 `replay, extraBufferCapacity, onBufferOverflow`，见 `_work/tuwin_src/sources/kotlinx/coroutines/flow/SharedFlowKt.java:32`；mask 低位含 4 ⇒ `onBufferOverflow` 用默认 `BufferOverflow.SUSPEND`）：

| 流 | replay | extraBufferCapacity | onBufferOverflow | 暴露方式 | 位置（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/`） |
|---|---|---|---|---|---|
| 设备会话事件 `_events` | `0` | `64` | SUSPEND（mask 4） | `asSharedFlow` → `events(sessionId)` | `core/device/DeviceSessionManager.java:474`、`:478`、`:209` |
| M3 socket 消息 `_messages` | `0` | `64` | SUSPEND（mask 5 ⇒ replay 也取默认 0） | `asSharedFlow` → `getMessages()` | `core/device/p005m3/DefaultM3SocketConnector.java:362-363`、`:367`、`:378` |
| M3 socket 故障 `_failures` | **`1`** | `1` | SUSPEND（mask 4） | `asSharedFlow` → `getFailures()` | `core/device/p005m3/DefaultM3SocketConnector.java:364-365`、`:368` |
| Ride5 回调事件 `_events` | `0` | `64` | SUSPEND（mask 5） | `asSharedFlow` → `events` | `core/device/ride5/Ride5CallbackChannel.java:138-140` |
| Wi-Fi 扫描 UI 事件 `_wifiScanEvents` | `0` | `1` | SUSPEND（mask 5） | `asSharedFlow` | `presentation/dialog/ConnectDialogViewModel.java:142-144` |

即：**只有 M3 的故障流带 1 帧回放**（保证稍后开始采集的恢复逻辑仍能看见最近一次断连原因），其余事件流全部不回放、靠 64 深度缓冲吸收突发。

**StateFlow 清单（都是 `MutableStateFlow(initial)` + `asStateFlow`）**：

| 流 | 初值 | 位置 |
|---|---|---|
| 会话快照 `_state` | 调用方传入的 `initial` | `core/device/DeviceSessionManager.java:472`、`:477`；查询 `state(sessionId)` `:204` |
| 播放状态 | 按 `(sessionId, mediaSessionId)` 惰性建 key，初值 `MediaStateSnapshot(..., IDLE, null, null)`，容器是 `ConcurrentHashMap` | `core/media/MediaStateStore.java:93`、`:101-115` |
| 联网路由 | `revisions.unavailable(NetworkPlane.INTERNET)` | `core/network/InternetRouteController.java:64`、`:66` |
| 网络拓扑 | `emptyMap()`；变更流初值 **`null`** | `core/network/NetworkTopologyMonitor.java:63`、`:65`、`:67-68` |
| 传输任务状态 | `TransferState.Queued`（`putIfAbsent` 建键） | `core/transfer/ScopedTransferQueue.java:164`、`:223-227`、`:247` |
| App 自更新状态 | `AppUpdateCheckState.IDLE` | `core/update/AppUpdateCoordinator.java:134`、`:136` |
| 相机 OTA 进度 | `DeviceOtaProgress(DeviceOtaState.IDLE, null, null, …)` | `core/update/DeviceOtaCoordinator.java:70`、`:72` |
| 固件版本列表刷新位 | `0L` | `core/util/UpgradeHelper.java:100`、`:102` |
| 连接对话框 | `ConnectState.Idle` / `DeviceWifiScanState.Idle` | `presentation/dialog/ConnectDialogViewModel.java:136-141` |
| 连接页 | `emptyList()` / `ConnectionStatus.Idle` | `presentation/p010ui/connect/fragment/ConnectViewModel.java:111-116` |
| 回放互斥闸门 | `false`（**static**，进程级单例） | `presentation/p010ui/album/Ride3ProPlaybackConflictGate.java:28` |

**并发与异常处理策略**（这些流没有 `retry*`，一律「把异常变成数据」或「取消即终点」）：
- 采集循环：`DeviceSessionManager.ManagedDeviceSession.startEventCollection(events, revision)` 先 `cancel` 旧 `eventJob` 再 `launch(sessionScope)` 一个新的 `collect`（`core/device/DeviceSessionManager.java:1627-1633`）。collector 里三道过滤：`closed.get()`、`route == null`、`route.revision != revision` → 直接丢弃（`core/device/DeviceSessionManager$_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/DeviceSessionManager$ManagedDeviceSession$startEventCollection$1.java:66`）；随后 `ControlChannelFailed`/`RouteSuperseded` 且当前态不在 `{CLOSING, CLOSED}` → 写 `DeviceSessionState.DEGRADED`（同文件 `:69-72`）；最后原样 `_events.emit(event)`（同文件 `:74`，**挂起式 emit，背压回 socket**）。
- M3 事件源：`socketEvents(socket) = merge(messages.map { ProtocolMessage(it) }, failures.map { ControlChannelFailed(it) })`（`core/device/p005m3/M3DeviceAdapter.java:750-753`、`:806`、`:826`）；Ride5 是 `when` 映射：`Frame → ProtocolMessage(frame.value)`、`SourceRejected → ProtocolMessage(event)`、`Failed → ControlChannelFailed(cause)`（`core/device/ride5/Ride5DeviceAdapterSession.java:642-650`）。
- 下游只按类型过滤而不 catch：`M3SessionRepositoryFactory` 用 `filterIsInstance<ProtocolMessage>` + `mapNotNull { payload as? M3SocketMessage }` 把事件流转成仓库内消费的消息流（`core/device/p005m3/M3SessionRepositoryFactory.java:316`、`:391`）；`Ride5DeviceDetailViewModel` 同样只挑 `ProtocolMessage`（`presentation/p010ui/device/detail/Ride5DeviceDetailViewModel.java:105`）。
- 轮询侧把异常包成结果对象：`requestOnce` 的 `catch (CancellationException) { throw e }` + `catch (Throwable) { Failed(sessionId, th) }`（`core/device/ride3pro/Ride3ProPollingStatusChannel.java:444-447`），HTTP 业务失败也转 `Failed`（`:443`）。
- 唯一显式 `catch` 操作符在相册事件仓库：`distinctUntilChanged(catch { ... })`（`data/repository/RecordingControlEventRepositoryImpl.java:193`），配合 `RecordingControlEventsView` 的 `flowOn(...)`（`presentation/widget/RecordingControlEventsView.java:262`）。
- 派生状态流用 `distinctUntilChanged`：`M3SessionRecoveryController.states(sessionId)` = `sessions.state(sessionId).map{…}.distinctUntilChanged()`，会话不可用时退化为 `flowOf(UNAVAILABLE)`（`core/device/p005m3/M3SessionRecoveryController.java:51`、`:63`、`:66-69`）。
- Ride5 回调通道混用两种发射：背压敏感的错误用挂起 `emit`（`core/device/ride5/Ride5CallbackChannel.java:392`、`:455`、`:647`、`:663`），高频拒绝帧用 `tryEmit`（`:423`、`:441`、`:618`）——**`tryEmit` 在缓冲满时静默丢事件**。

### 5.4 推送断线后的恢复策略

**M3 靠 socket 推送驱动**：`BatteryUpdate / SDCardUpdate / RecordingUpdate / RecordingTimeUpdate / MicUpdate / CaptureUpdate / CountdownTimeUpdate` 经 `ProtocolMessage` 进会话事件总线，再由 `M3SessionRepositoryFactory` 造的仓库消费，最终落到设备详情页状态（`presentation/p010ui/device/detail/M3DeviceDetailActivity.java` / `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/Ride5DeviceDetailViewModel.java:105`）；`failures` 流则只驱动「控制面坏了」这一件事。**M3 不做周期轮询**（`DefaultM3SocketConnector.java` 里 `reconnect|retry|delay` 关键字 0 命中）。

**Ride3Pro 靠 HTTP 轮询驱动**：`Ride3ProHeartbeatManager` 用 `Ride3ProPollingStatusChannel` 拉 `/api/device/status`。
- 常量：`HEARTBEAT_INTERVAL_MS = 30000`、`MAX_RETRY_COUNT = 3`、`RETRY_DELAY_MS = 500`（`_work/re/tuwin/catalog-consts.md:1340-1342`，源码 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:36-38`；通道侧同名默认 `DEFAULT_INTERVAL_MS = 30000`、`DEFAULT_MAX_RETRY_COUNT = 3`、`DEFAULT_RETRY_DELAY_MS = 500` 且已 `@Deprecated`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java:37`、`:40`、`:43`）。
- 结构不变式：`intervalMs / maxRetryCount / retryDelayMs` 任一为负即 `IllegalArgumentException("Failed requirement.")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java:113-121`）。
- 一轮 `pollOnce` 内失败最多重投 `maxRetryCount` 次，每次 `delay(retryDelayMs)`，日志 `"Ride3Pro: session 心跳失败，准备重试 N/3, session=…"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java:241-268`）；executor 为 null、会话不存在或 `sessionId` 不符 → `SkippedNotReady`（`:204-221`、`:280-283`、`:344-348`）。
- 驱动的状态：`Updated(sessionId, routeRevision, snapshot)` → `updateStatusStore(...)` → `Ride3ProStatusStore.activateSession(...)` + `Ride3ProConnectionSnapshot`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:284-289`、`:320-330`；快照字段映射 `currentMode / batteryPercent / adapterStatus / exceptionFlags / hdrChkCnt`，`core/device/ride3pro/Ride3ProPollingStatusChannelKt.java:11-14`）。心跳结果带旧 `routeRevision` 会被丢弃并打日志 `"Ride3Pro: 丢弃旧 route revision 心跳结果 session="`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:325-330`）。
- 生命周期闸门：`lifecycleAllowed` 由 `!shouldSuppressHeartbeat()` 提供（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:255-262`），页面不可见即停发；`startForSession` 在 sessionId + routeRevision 都未变时直接复用旧 job（`:276-282`），否则 `stop()` 重建（`:283-289`）。

**断线后谁负责重建（按层）**：
1. **路由层**（唯一的自动重建者）：`DeviceSessionManager.routeRevisionChanged(change)`（`core/device/DeviceSessionManager.java:352-369`）——非 `NetworkPlane.DEVICE` 直接忽略（`:354-356`）；`RouteState ∈ {LOST, UNAVAILABLE, REJECTED}` 时 `invalidateForRoute` **并额外 launch 一个重建 job**（`:357-363`）；其它状态只 `invalidateForRoute`（`:364-368`）。注意它本身**不重新 open 会话**，重建由被 launch 的 `…$routeRevisionChanged$1$1` 完成。
2. **会话层**：`invalidateForRoute(route)`（`core/device/DeviceSessionManager.java:1737-1756`）丢弃 `activeAdapter`、`cancel` 主 job 与 `eventJob`、把非终态快照写 `DeviceSessionState.DEGRADED`（`:1751-1753`）、再 launch 重建；`cancelForRoute(cause)`（`:1758-1766`）用 `CancellationException(cause.message, cause)` 取消整条会话。
3. **控制面层（M3）**：`M3ControlChannelState` 由会话态映射（`core/device/p005m3/M3SessionRecoveryController.java:126-134`）：无有效端点 → `UNAVAILABLE`；`READY` → `READY`；`OPENING_CONTROL_CHANNEL` → `RECOVERING`；`DEGRADED` → `RECOVERABLE`；其余 → `UNAVAILABLE`。`recover(sessionId)`（`:160` 起，`Result<Unit>` 返回）在能力位 `M3_HTTP_CONTROL`（`:39`）校验通过后转 `M3AdapterSession.recoverControlChannel()`（`core/device/p005m3/M3DeviceAdapter.java:442`），后者在**新 `RouteLease` 的 `withCancellation` 作用域**里重开 socket 并把新路由塞回结果（`:491-497`）。**socket 自身不会重连**，只有这条路径会。
4. **播放层**：native 播放器在 View 内部自愈（`5 × 500 ms`，见 §4.6）；`MediaSessionCoordinator` 只会 `requestStop → awaitClosed → release → close leases` 后进 `CLOSED/FAILED`（`core/media/MediaSessionCoordinator.java:580-655`），`onError` 直接把 `monitorJob`/`startJob` 取消（`:510-528`），**不做重连**，需上层重新 `start()`。
5. **UI 层**：EventBus 的 `NetworkChangeEvent` 是 sticky 的，页面重新注册即可拿到最后一次拓扑变化（`core/util/network/NetworkManager.java:64`、`:101`、`:104` + `presentation/p010ui/connect/fragment/ConnectFragment.java:837-847`），这是「断线后 UI 能自洽」的机制，不是重连机制。

**静态无解 + 补证手段**：`DeviceSessionManager.routeRevisionChanged` 里 launch 的 `…$routeRevisionChanged$1$1` 具体是否重新 `open()` 会话（还是只标脏），本次只确认了 job 存在与调用点（`core/device/DeviceSessionManager.java:361`），其 `invokeSuspend` 主体未逐行核对；补证手段是把该类跑一遍 `jadx --show-bad-code` 或在真机上按 §1.3 的时序断言：断开设备 AP 后观察是否出现第二次 `Adapter open` 日志。

---

## 6. 遥测与三方 SDK

> 扫描口径先交代：`_work/re/tuwin/signals-summary.md` 第 5 行写明 `signals-*.tsv` 只覆盖**厂商自有代码**（`com/tuwinsmart/**` 字面量 55,917 条）——友盟/efs/OSS 等内嵌库自己拼的遥测 URL **不在** `signals-fullUrls.tsv`/`signals-hosts.tsv` 里。所以本节把表拆成 A（signals 内，厂商侧）与 B（signals 外，库侧补测），B 才是"反编译包里出现域名 ≠ 它在用"的重灾区。
> 一句话结论：**全 APK 只有一套统计+崩溃上报 = 友盟 U-App + U-APM（`com.efs`）**，且被隐私同意闸门挡住；没有 Bugly / Sentry / Firebase / Countly / 自建埋点（`com/` 顶层目录无这些包；`com/tuwinsmart/**` 对 `MobclickAgent` 零命中）。厂商自有的"上报"只有两件事：崩溃写本地文件（`AppCrashHandler`，无网络）与反馈/日志上云（`http://ali.tuwinsmart.com/feedback` + 阿里 OSS，见 6.2/6.3）。

### 6.1 统计与崩溃 SDK：友盟 / com.efs / libucrash / libumonitor / libumeng-spy

**接入方式是反射桥**，TUWIN 编译期不依赖友盟：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java:19` 定义 `UM_CONFIGURE_CLASS_NAME = "com.umeng.commonsdk.UMConfigure"`，`:198-212 resolveClass` 用 `Class.forName`，类不存在时全部静默返回 `false`。本 APK 里该类真实存在（`_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java`），所以反射**必然命中**。

| 常量 | 值（原样） | 位置 |
|---|---|---|
| `UMENG_APP_KEY` | `6781b8f38f232a05f1f56ef5` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:148` |
| `UMENG_CHANNEL` | `Umeng` | 同上 `:149` |
| `RELEASE_CHANNEL` | `stable` | 同上 `:146`（App 自更新去重键用，§3.7） |
| `SERVER_ENVIRONMENT` | `production` | 同上 `:147` |
| `INTERNET_WEBVIEW_DATA_DIRECTORY_SUFFIX` | `internet` | 同上 `:145` |

manifest 里**没有任何友盟 appkey meta-data**（全应用 meta-data 共 6 条，均 androidx/azhon，`_work/re/tuwin/manifest.md:195-202`）——key 只在运行时经反射注入，静态清单不可见。efs 侧唯一注册组件是 `com.efs.sdk.memleaksdk.monitor.UMonitorService`（`process=:u_heap`，`_work/re/tuwin/manifest.md:150`）。

**Application 路径调用链（两级闸门）**：

1. `TuwinApplication.onCreate`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:258`）→ `:261` `AppCrashHandler.install` → `:263` 判进程（`:internet` 子进程只设 WebView 数据目录后缀，**不碰友盟**）→ 主进程 `:269` `UmengSdkBridge.preInit$default(..., UMENG_APP_KEY, UMENG_CHANNEL, ...)`。preInit 在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java:89` 反射调 `UMConfigure.preInit(context, appKey, channel)`——**发生在隐私同意之前**，但按友盟契约 preInit 不落网不上报。
2. `initThirdLibs()`（`:305`）整体被 `:306` `PreferenceHelper.isAgreePrivacy()` 门住；调用点两个：`onCreate :272`（未同意则空转）与首页 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java:331`（同意后补跑）。同意后顺序：`:308-310` `WriteRuntimeLogTree.init()+Timber.plant`（自有日志树）→ `:352` `UmengSdkBridge.init$default(..., UMENG_APP_KEY, UMENG_CHANNEL, ...)` → `:353` **再装一次** `AppCrashHandler.install`。
   `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java:125-150 init` 先反射读 `UMConfigure.DEVICE_TYPE_PHONE` 静态字段（`:185`；字段存在且 =1，`com/umeng/commonsdk/UMConfigure.java:61`），再在 `:140` 反射调 `UMConfigure.init(ctx, appKey, channel, 1, null)`（第 5 参 pushSecret = null）。因为第 3 步安装顺序在 `:352` 之后，`AppCrashHandler` 的 `DelegatingHandler` 会**包住友盟的 handler**：崩溃先写本地文件，再委托友盟上报（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/AppCrashHandler.java:102-104`）。

**init 之后 SDK 内部真实发生的链**（决定 6.2-B 表里"真会访问"那批域名）：

- `_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java:353`：`getClass("com.umeng.umzid.ZIDManager") == null` 判空——类存在，通过；`:542-551`：反射 `com.umeng.umcrash.UMCrash` 并调 `UMCrash.init(applicationContext, sAppkey, sChannel)`（sAppkey 即上面那个 key）。
- `_work/tuwin_src/sources/com/umeng/umcrash/UMCrash.java:700` `init` → `:981` 起 `PAFactory`/`EfsReporter`；`:864-942` 注册 ActivityLifecycle 驱动 `PowerManager`（启动/卡顿）、`PageManger`、`ULogManager`、`MemLeakManager`（`com/umeng/umcrash/custominfo/UAPMCustomInfo.java:28`）——即 **U-APM 全家桶（崩溃+内存+页面+启动）随 init 激活**。
- efs 上报端点选择：`_work/tuwin_src/sources/com/efs/sdk/base/core/controller/ControllerCenter.java:110-115`——`isIntl()` 为 false 走 **`https://errnewlog.umeng.com/api/crashsdk/logcollect`（license 常量 `28ef1713347d`）**，true 走 `errnewlogos`（`4ea4e41a3993`）；默认值同 CN（`com/efs/sdk/base/internal/C1040z0.java:10`）。
- 云配置触发器：`_work/tuwin_src/sources/com/umeng/commonsdk/internal/C3221c.java:613`、`:796` 在 init 流程里 `UMWorkDispatch.sendEvent(..., CLOUD_CONFIG_TRIGGER, 延时5000ms)` → `:699-719` 收到后 `CcgAgent.init(context)` 并注册配置回调 → ccg worker `com/umeng/ccg/C3177d.java:831/:861/:973/:1292/:1336/:1385` 把 `cnlogs.umeng.com/*`、`ucc.umeng.com`、`aspect-upush.umeng.com` 的 Runnable 排进调度器执行上报。
- zid：`com/umeng/umzid/ZIDManager.java:135/:318/:387` 使用 `https://utoken.umeng.com`；`_work/tuwin_src/sources/com/umeng/commonsdk/internal/C3221c.java:124` 反射取用。

**四个原生库**（均只有 arm64-v8a，尺寸见 `_work/re/tuwin/natives.md:17-20`）：

| 库 | 谁加载 | 判定 |
|---|---|---|
| `libucrash.so`（+`libucrash-core.so`） | `_work/tuwin_src/sources/com/umeng/crash/C3291c.java:99`、`:147`、`:195` `System.loadLibrary("ucrash")`，由 UCrash init 链驱动 | **随同意后的 init 激活**，负责 native crash/ANR 捕获，落盘后经 `errnewlog` 上报 |
| `libumonitor.so` | `com.efs.sdk.memleaksdk.*`（堆内存泄漏监控，含 `UMonitorService` `:u_heap` 进程，manifest.md:150）；**反编译树内找不到 `loadLibrary("umonitor")`** | 库在用（Service 已在 manifest 注册），loader 在未喂给 jadx 的 `classes3.dex`（同 §4.1 的缺证面）；补证手段：单独反编译 `classes3.dex` 或在 `:u_heap` 进程存活时看 `adb shell ps` |
| `libumeng-spy.so`（398 KB，最大的一颗） | 反编译树内**零引用**（`umeng-spy`/`umeng_spy` 全库 grep 无 `loadLibrary`）；友盟安全/反调试组件，惯例由 commonsdk 服务在 `classes3.dex` 里加载 | 同上，缺证于 `classes3.dex`；它的 `natives.md` 导入表含 `connect`，具备联网能力，但本包静态无法证明被调用 |
| （对照）`libdatastore_shared_counter.so` | androidx DataStore 自带 | 与遥测无关，§6.3 |

**TUWIN 自己的上报面逐个确认**：
- 崩溃：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/AppCrashHandler.java:32-41`——`install` 把 `DelegatingHandler(processName, File(cacheDir,"CLOG"), previous)` 设为默认 handler；`uncaughtException`（`:92-110`）用 `CrashLogStore.write` 把堆栈+元数据（`:112-123`：`session_id/app_version_code=250/device/android_sdk` 等 8 键）写本地文件，**全程零网络**。
- Bugly：**无**（`com/bugly` 包不存在）。Sentry / Firebase Analytics / Countly / GrowingIO / SensorsData：**均无**（`com/` 顶层清单只有 alibaba, azhon, bskim, bumptech, danikula, efs, flyco, github, google, hjq, ihsanbal, jakewharton, lzy, noober, release, shuyu, thanosfisherman, tuwinsmart, umeng, xuliwen + `io/reactivex`、`org/greenrobot`、`org/koin`、`org/repackage`、`ren/yale`、`tv/danmaku`）。
- 自建埋点：**无**——厂商代码对 `MobclickAgent` 零调用（不报自定义事件/页面），对 `com.efs` 的 import 全是 jadx 内联 `NetworkUtil.NETWORK_TYPE_WIFI` 常量的假象（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:11` 是 `NetworkUtil` 的 import，真正的假象在 `:45`——`getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)` 引用的只是 efs 里的 int 常量「1」，jadx 把常量来源渲染成了 import）；上云通道只有 §3.7 更新检查、`feedback` 提交与 OSS 日志上传（6.2/6.3），均为功能行为不是统计。
- 清单残留：友盟 OAID 需求往 manifest 里塞了 `com.google.android.gms.permission.AD_ID`（`_work/re/tuwin/manifest.md:68`）与 `freemme.permission.msa`（`:69`），OAID SDK 以 `org.repackage.*` 打进 analytics（6.2-A 表倒数几行）。

### 6.2 域名逐条判定：真调用 vs 死字符串

判定只有三档：**运行时真会访问**（给到把 URL 交给 HTTP 客户端/WebView 的那一行）／**库自带但本 App 未触发**／**死字符串/资源**。路径缩写 `SRC = _work/tuwin_src/sources/`。

#### 6.2-A 厂商侧（`signals-fullUrls.tsv` 全 37 行 + `signals-hosts.tsv` 去重增量）

`signals-hosts.tsv` 共 1,088 行，其中 **95% 是正则误报**：`.kt` 源文件名（`M3DeviceDetailActivity.kt`）、全限定类名（`com.tuwinsmart.tuwin.core.device.DeviceSessionManager`）、系统属性/资源键（`ro.product.model`、`line.separator`、`koin.properties`）、`android.intent.*` 等，不是主机字面量（复核命令：`cut -f4 signals-hosts.tsv | sort -u` 后按点分尾缀过滤）。下表只收真实主机/URL，另把 `signals-ips.tsv` 全 5 行（3 条相机网关 + `111.179.38.202` 两行去重 1 条）一并落表。

| 字面量 | 出现在（类:行） | 归属 | 判定 |
|---|---|---|---|
| `http://schemas.android.com/apk/res/android` | `SRC com/flyco/tablayout/CommonTabLayout.java:128`、`_work/tuwin_src/sources/com/flyco/tablayout/SegmentTabLayout.java:110`、`_work/tuwin_src/sources/com/flyco/tablayout/SlidingTabLayout.java:119` | 其它库（flyco） | **死字符串/资源**：XML 属性命名空间 URI，`obtainStyledAttributes` 消费，零网络语义 |
| `http://`（设备 URL 拼接片段） | `SRC com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:939`、`…/p005m3/M3SessionConnector.java:2162`（`"http://"+host+":"+port+"/"`）、`…/p005m3/M3SessionRepositoryFactory.java:673`、`…/ride3pro/Ride3ProSessionConnector.java:2035`、`…/ride3pro/Ride3ProSessionTransport.java:612`、`…/ride5/Ride5CgiGatewayKt.java:31` | 厂商自有 | **运行时真会访问（设备本地）**：相机 AP 局域网 HTTP 端点拼接，host 恒为 §1 的 192.168 网关；非外网域名 |
| `http://`（续传/目录拼接片段） | `SRC com/tuwinsmart/tuwin/core/transfer/VerifiedDeviceFileCatalog.java:844`、`SRC com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:214` | 厂商自有 | **运行时真会访问（设备本地）**：§2.1 `buildAuthorizedHttpUrl` 唯一出口即 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:214` 的 `"http://" + host + ":" + port + "/"` |
| `rtsp://`（端点拼接片段） | `SRC com/tuwinsmart/tuwin/core/device/p005m3/M3EndpointHostPolicy.java:74`、`…/p005m3/M3SessionRepositoryFactory.java:156`、`…/ride3pro/DocumentedRide3ProMediaEndpointResolver.java:31`、`…/ride5/Ride5DeviceMediaPort.java:110` | 厂商自有 | **运行时真会访问（设备本地）**：RTSP 播放端点前缀，§4.4 交给 ijk/FFmpeg 直连相机 |
| `https://` + `http://`（OSS 公网 URL 拼装） | `SRC com/tuwinsmart/tuwin/data/source/remote/gateway/LegacyDirectCloudConfig.java:151`（`publicOssUrl`：`"https://" + bucket + "." + trimEnd(removePrefix(endpoint,"https://"),"http://") + "/" + key`） | 厂商自有（host 来自 BuildConfig） | **运行时真会访问（条件）**：6.3 OSS 日志上传链的产物 URL；endpoint 实值在未导出的 `BuildConfig.TUWIN_OSS_*`，缺证 |
| `https://`（反馈日志公网 URL 拼装） | `SRC com/tuwinsmart/tuwin/core/util/wifi/FeedbackLogUploadPolicy.java:22` | 厂商自有 | 同上：`uploaded==true` 才拼 `"https://"+bucket+"."+endpoint+"/"+key`，属产物不是请求目标 |
| `http://ali.tuwinsmart.com/` | `SRC com/tuwinsmart/tuwin/data/source/remote/gateway/FeedbackApiEndpoint.java:10`（`BASE_URL`） | 厂商自有 | **运行时真会访问**：`SRC …/gateway/RoutedInternetCloudGateway.java:96` 把它设为默认 baseUrl，`:323` `retrofitProvider.create(lease, baseUrl, TuwinSuspendApi…)`；端点 `@GET appupdatecheker/banner/newota` = `SRC …/remote/api/TuwinSuspendApi.java:17/:20/:23`（链路 §3.6/§3.7）。**明文 HTTP** |
| `http://ali.tuwinsmart.com/feedback` | 同上 `:12`（`URL`） | 厂商自有 | **运行时真会访问**：`SRC …/gateway/RoutedLegacyFeedbackGateway.java:85` `NetworkIntent.Internet("feedback_submit")` → `:186` Retrofit 以 `FeedbackApiEndpoint.BASE_URL` 建 `FeedbackApi`，`@POST("feedback")`（`SRC …/gateway/FeedbackApi.java:16`）；反馈页入口 `SRC …/presentation/p010ui/mine/FeedbackActivity.java` |
| `https://work.weixin.qq.com/kfid/kfc5097d1b6381f03e7` | `SRC com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:318` | 厂商自有（腾讯微信客服 SaaS） | **运行时真会访问（用户点击触发）**：整串字面量直接交给 `ExternalWebActivity…launch(...)`——`:internet` 子进程 WebView 加载 |
| `https://tuwin.tmall.com` | `SRC …/connect/fragment/ConnectFragment.java:360` | 厂商自有（天猫店） | **运行时真会访问（用户点击，三级回退）**：`:355` 先 `tbopen://m.taobao.com/…h5Url=…%2F%2Ftuwin.tmall.com` 拉起淘宝 → `:358` `tmall://page.tm/shop?shopId=255736524` → `:360` ACTION_VIEW https 兜底 |
| `http://tuwinwifihelp.tuwinsmart.com/#/` | `SRC …/presentation/p010ui/home/HomeTipsWebsiteCachePolicy.java:17`（`TIPS_URL`） | 厂商自有 | **运行时真会访问**：`SRC …/device/detail/DeviceDetailActivity.java:884` 直接把该常量交给 `ExternalWebActivity.launch`（帮助站；`#/` 是 fragment 不发给服务器；**明文 HTTP**） |
| `http://tuwinwifihelp.tuwinsmart.com/#/pages/detail/detail` | `SRC …/home/HomeTipsWebsiteCachePolicy.java:28`（缓存清单第 2 项） | 厂商自有 | **死字符串/资源**：仅存在于预热清单，见下行判定 |
| `http://tuwinwifihelp.tuwinsmart.com/assets/` | 同上 `:13`（`ASSET_BASE_URL`，**未被任何代码引用**） | 厂商自有 | **死字符串/资源**：常量声明后无人拼接 |
| `…/assets/uni.92962d95.css`、`index-QBOHzVR1.js`、`index-yksqsBZR.css`、`pages-index-index.Db_F_afS.js`、`_plugin-vue_export-helper.BCo6x5W8.js`、`index-25iIq76Q.css`、`pages-detail-detail.BNTkq3Bp.js`、`detail-CIO5uBGQ.css`（8 条，均 `…/assets/` 前缀） | `SRC …/home/HomeTipsWebsiteCachePolicy.java:28`（`TIPS_URLS_TO_CACHE` 静态数组，同一次声明） | 厂商自有 | **死字符串/资源**：唯一消费方 `SRC …/home/HomeTipsWebsiteCacheCoordinator.java:35-69 cacheIfNeeded` **在全 APK 内零构造、零调用**（`CACHE_MARK_KEY="HOME_TIPS_WEBSITE_CACHE_URL"`（Policy:14）也无任何读写点；配套预加载库 `ren.yale` 零引用，见 6.3）——预热功能整体已死。帮助站资源实际由 WebView 打开 `#/` 后按 HTML 相对引用加载，不需要这些字面量。文件名里的 hash 停在旧版本，也是功能废弃的旁证 |
| `https://yomu.atlasmeta.one`、`https://yomu.atlasmeta.one/` | `SRC …/presentation/p010ui/home/PrivacyPolicySource.java:16`（`baseUrl`）、`:33`（`url()` 拼 `"<base>/" + 语言目录 + "/privacy.html"`，th/zh-Hant-HK/zh-Hant-TW/zh-Hans/en 六路） | 厂商自有（外部静态站） | **运行时真会访问**：`SRC …/home/HomePrivacyPolicyContentLoader.java:235` 把 `PrivacyPolicySource.INSTANCE.url(context)` 交给 `fetchWhenInternetRouteReady` → `SRC …/home/C2757x4614b080.java:84-88`（jadx 未反净，smali 行可见）`RoutedInternetTextFetcher.fetch(url, setOf("yomu.atlasmeta.one"))` → `SRC …/core/internet/RoutedInternetTextFetcher.java:88` `ExternalUrlPolicy authorize`（`:89` acquire `INTERNET_API` lease）→ `:91` OkHttp `newCall(GET)`。隐私政策弹窗正文从这里拉 |
| `http://ride5helpnew.tuwinsmart.com/#/` | `SRC …/presentation/p010ui/mine/fragment/MineFragment.java:150` | 厂商自有 | **运行时真会访问（用户点击触发）**：`ExternalWebActivity…launch(activity, "http://ride5helpnew.tuwinsmart.com/#/", "Ride5")`；**明文 HTTP** |
| `appdownload.tuwinsmart.com` | `SRC …/core/internet/ExternalUrlPolicy.java:23`（6 host 白名单成员）、`SRC …/core/internet/ExternalWebCompatibilityPolicy.java:47`（`DEFAULT_BANNER_HOSTS`） | 厂商自有 | **运行时真会访问（条件，服务器内容驱动）**：banner 接口下发的 `link` 必须先过 `SRC …/gateway/RoutedInternetCloudGateway.java:564` `bannerPagePolicy.authorize(link)`；点击后经 `SRC …/presentation/p010ui/internet/ExternalWebActivity.java:119-123`（初始 URL authorize）→`:371`（导航放行）加载。客户端从不自行拼接该 host |
| `tuwinwifihelp.tuwinsmart.com`、`ride5helpnew.tuwinsmart.com`、`yomu.atlasmeta.one`、`tuwin.tmall.com`、`work.weixin.qq.com`（增量行） | `SRC …/core/internet/ExternalUrlPolicy.java:23`（`DEFAULT_ALLOWED_HOSTS = {6 host}`；`authorize` 强制 http/https、禁 userinfo、host 精确小写匹配，`:31-52`） | 厂商自有 | **死字符串/资源（作为白名单本身）**：这 5 个 host 的真实访问判定见上方各自的字面量行；出现在策略类里只是白名单常量 |
| `intelligentassistant.tuwinsmart.com` | `SRC …/core/internet/ExternalWebCompatibilityPolicy.java:26`（常量）+ `:211`（`isAllowlistedExternalTarget`：仅 `http://intelligentassistant.tuwinsmart.com/`（port 80、path `/`）整体匹配） | 厂商自有（自家"智能助理"页） | **运行时真会访问（条件）**：不是客户端发起——帮助/客服页里用户点该链接时，`SRC …/internet/ExternalWebActivity.java:450` `shouldLaunchExternalApp`/`:371` 判定放行跳转。消费链在 `:139-167`（源页 host 必须在 help/assistant/banner 三组内） |
| `v.douyin.com`（`/twoBbgH2l4Y`） | `SRC …/ExternalWebCompatibilityPolicy.java:27`（HOST）/`:28`（PATH）+ `:209` | 其它（抖音推广短链） | **运行时真会访问（条件，白名单判定项）**：帮助页点抖音条目时外跳宿主 App；TUWIN 自身不请求。docs/04 C 组"平台专属推广"明令不做 |
| `xhslink.com`（`/m/8acYvvtd8S4`） | 同上 `:30` + `:205` | 其它（小红书推广短链） | 同上：白名单判定项，仅用户点击外跳 |
| `mp.weixin.qq.com`（`/s/S-odmnyu7jctrZZlzBwGMA`、`/s/wXxedWNrYloV9v7t4f5Qtw` 两篇文章） | 同上 `:29` + `:207`（paths 集合声明 `:50`） | 其它（公众号文章） | 同上：白名单判定项，仅用户点击外跳 |
| `apps.apple.com/app/id6740312738` | `SRC …/ExternalWebCompatibilityPolicy.java:24` + `:201`（https:443 + 该 path 精确匹配） | 其它（App Store） | **库自带但本 App 未触发（近似死字符串）**：安卓 APK 里内嵌 iOS 商店链接，只可能是帮助页共用营销配置的产物；`:201` 判定分支在安卓上永远不会因用户行为命中（无 iOS 设备场景），但严格说点击帮助页该链接仍会被放行到浏览器——保守记为"白名单判定项，实际不会发生" |
| `2005.sunwingroup.com.cn`（`https://…:1371/pcn_manager/download_static_file`） | `SRC …/core/internet/ExternalResourceAllowlist.java:18-21`（`ANDROID_DOWNLOAD_HOST/PATH/PORT/SCHEME`）；另见 `SRC …/ExternalWebCompatibilityPolicy.java:23` + `:203` | 其它（第三方安卓应用商店/静态分发，疑似某厂商市场） | **运行时真会访问（条件）**：帮助页（uni-app）里的安卓下载入口/资源，由 `SRC …/internet/ExternalWebActivity.java:325/:344` `shouldInterceptRequest → ExternalWebResourcePolicy.authorize`（即 `authorizeCrossOriginWebResource`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/internet/ExternalResourceAllowlist.java:44`；banner 图另一入口 `authorizeBannerImage` `:35`，允许 media/1371 下载/CDN 三类）放行给 WebView 拉取；宿主 App 本身不请求 |
| `cdn.dcloud.net.cn`（`https:443`，限 6 个 `/img/shadow-*.png`，`allowedCdnAssetPaths` 声明于 `:30`） | `SRC …/core/internet/ExternalResourceAllowlist.java:22-23`（HOST/PORT） | 其它（DCloud/uni-app 前端 CDN） | **运行时真会访问（条件）**：同上，帮助页跨域子资源白名单，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/internet/ExternalWebActivity.java:325/:344` 消费；只有清单内 6 张阴影图可过 |
| `111.179.38.202`（`http://…:1369/pcn_manager/download_static_file`） | `SRC …/core/internet/ExternalResourceAllowlist.java:25-28`（`MEDIA_*`）；`SRC …/core/internet/ExternalWebResourcePolicy.java:14`（同值常量） | 厂商自有（裸 IP 静态/图片服务器） | **运行时真会访问（条件）**：banner 图链路——`SRC …/gateway/RoutedInternetCloudGateway.java:577` `isAllowedBannerImage(item.getImageUrl())` 过滤后，`SRC …/core/glide/RoutedInternetImage.java:83` `authorizeBannerImage` 授权，Glide 经 §6.3 的 lease client 下载 |
| `192.168.169.1`、`192.168.25.1`、`192.168.0.1` | `SRC …/core/device/DeviceHostPolicy.java:50/:53/:56` | 厂商自有 | **运行时真会访问（设备本地）**：相机 AP 网关/主机校验（§1），与遥测无关；列此仅为覆盖 `signals-ips.tsv` 全 5 行 |
| `com.heytap.openid`、`com.heytap.openid.IdentifyService`、`action.com.heytap.openid.OPEN_ID_SERVICE`、`com.meizu.flyme.openidsdk`（含 `…ACTION_OPEN_ID_CHANGE`/`…permission.OPEN_ID_CHANGE`） | `SRC org/repackage/p018a/p019a/p020a/p021a/C4008c.java:54/:108/:109`、`SRC org/repackage/com/meizu/flyme/openidsdk/C4010b.java:240/:243/:273`（signals-hosts 里的行） | 友盟（捆绑的 OPPO/魅族 OAID SDK，包名被 repackage） | **运行时真会访问（进程内 IPC，非 HTTP）**：被 `_work/tuwin_src/sources/com/umeng/analytics/pro/C3053bp.java:4`（heytap OpenIDSDK）、`…/pro/C3051bn.java:4`（meizu OpenIdHelper）引用，属 §6.1 init 后 analytics 的 OAID 采集面；对应 manifest 的 `AD_ID`/`freemme.permission.msa` 权限（`_work/re/tuwin/manifest.md:68-69`） |
| `com.umeng.commonsdk.UMConfigure` | `SRC …/core/util/UmengSdkBridge.java:19` | 类名串（误报为"像域名"） | **运行时真会访问（反射目标）**：见 6.1；不是主机 |

#### 6.2-B 库侧补测（signals 不扫的 `com/umeng/**`、`com/efs/**`、`com/alibaba/**` 等，逐条）

| 字面量 | 出现在（类:行） | 归属 | 判定 |
|---|---|---|---|
| `https://errnewlog.umeng.com/api/crashsdk/logcollect` | `SRC com/efs/sdk/base/core/controller/ControllerCenter.java:114`（license `28ef1713347d` `:115`）；默认同值 `SRC com/efs/sdk/base/internal/C1040z0.java:10` | 友盟（efs/U-APM） | **运行时真会访问**：6.1 链 `_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java:548-551` → `_work/tuwin_src/sources/com/umeng/umcrash/UMCrash.java:700` → `ControllerCenter`（CN 线路）；崩溃/ANR/日志上报主通道 |
| `https://errnewlogos.umeng.com/api/crashsdk/logcollect` | `SRC com/efs/sdk/base/core/controller/ControllerCenter.java:111`（`4ea4e41a3993` `:112`） | 友盟 | **库自带但本 App 未触发**：`isIntl()` 国际分支（`:110`）才写入；本工程走 `useIntlServices` 需 `SdkVersion.SDK_TYPE==1`（`_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java:544-546`），CN 包 key 场景不命中 |
| `ulogs.umeng.com`（主数据上报域名，`"ulogs"→"cnlogs"` 字符串替换逻辑） | `SRC com/umeng/commonsdk/stateless/C3240c.java:70-71`（含 `preulogs` 特判） | 友盟（U-App 会话/设备 envelope） | **运行时真会访问**：stateless sender 在 init 后自动上报启动/会话；**完整 URL 常量在 `com.umeng.commonsdk.statistics.UMServerURL`——该类在未喂 jadx 的 `classes3.dex`（类清单见 `_work/tuwin_src/sources/com/umeng/commonsdk/debug/SelfChecker.java:10` 的 FILELIST，反编译树无文件）**，与 §4.1 `C3174a` 同源缺证；补证手段：单跑 `classes3.dex` 或抓包 |
| `preulogs.umeng.com` | `SRC com/umeng/commonsdk/stateless/C3240c.java:70` | 友盟（内测试探） | **库自带但本 App 未触发**：仅当已存 URL 含 `preulogs`（内测开关/灰度配置）时保留 |
| `cnlogs.umeng.com/ext_event`、`/uapp_ekverr_logs`、`/common_inout_logs` | `SRC com/umeng/analytics/pro/RunnableC3028ar.java:15/:18/:21` | 友盟 | **运行时真会访问（随 SDK 自动流）**：调度点 `_work/tuwin_src/sources/com/umeng/ccg/C3177d.java:831/:861/:1336/:1385`（cloud-config worker，由 6.1 `_work/tuwin_src/sources/com/umeng/commonsdk/internal/C3221c.java:613/:796→:719` 链路激活） |
| `aspect-upush.umeng.com/occa/v1/event/report` | `SRC com/umeng/analytics/pro/RunnableC3028ar.java:12` | 友盟（推送辅助归因） | **运行时真会访问（弱依据，条件）**：同在 `_work/tuwin_src/sources/com/umeng/ccg/C3177d.java:1292/:1302/:1312` 被调度；是否实际发包受远端 `actionInfo` 开关控制（`com/umeng/ccg/C3177d.java` 内多处 `getActionInfo` 判断）。本包无推送组件但归因事件由 analytics 侧独立触发——需抓包定证 |
| `ucc.umeng.com/v2/inn/fetch` | `SRC com/umeng/analytics/pro/RunnableC3029as.java:14` | 友盟（U-CC 内容/云配置拉取） | **运行时真会访问（随 SDK 自动流）**：调度点 `SRC com/umeng/ccg/C3177d.java:973` |
| `ulogs.umeng.com/push_cloud_activation`、`htls.umeng.com/push_cloud_activation` | `SRC com/umeng/analytics/pro/RunnableC3090cz.java:13/:19` | 友盟（push 云激活） | **库自带但本 App 未触发**：属推送激活链路；`com.umeng.message.PushAgent` 类在本包不存在（`_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java:369` 的 push 检查因此空转），引用方仅 `…/analytics/pro/C3079co.java` |
| `resolve.umeng.com/resolve`、`/resolve?htls=1` | `SRC com/umeng/analytics/pro/C3065ca.java:65/:67` | 友盟（域名解析兜底） | **运行时真会访问（兜底路径）**：引用方含 envelope 发送框架 `com/umeng/commonsdk/framework/C3218a.java` 与 analytics `C3027aq/C3067cc`——主上报域失败时才打；正常网络不命中 |
| `https://one.umops.com/api/attributionResult`、`/api/deferredLink` | `SRC com/umeng/commonsdk/deeplink/C3209b.java:41/:55`、`SRC com/umeng/commonsdk/deeplink/C3213f.java:43/:53`（`HttpsURLConnection.openConnection` 即调用点） | 友盟（DDL 归因/深度链接） | **库自带但本 App 未触发**：唯一入口 `UMCommonDeepLink`，`com/tuwinsmart/**` 对其零调用（grep 无命中），且 `_work/tuwin_src/sources/com/umeng/commonsdk/internal/C3221c.java:721-730` 的 DDL 消息 case 依赖业务侧显式发事件 |
| `https://203.107.1.1/181345/d?host=`（阿里云 HTTPDNS mini） | `SRC com/alibaba/sdk/android/oss/common/utils/HttpdnsMini.java:27/:130` | 阿里（OSS SDK 内嵌） | **库自带但本 App 未触发**：全 APK 唯一 OSSClient 构造点显式关闭：`SRC com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyDiagnosticUploadGateway.java:298` `clientConfiguration.setHttpDnsEnable(false)` |
| `http://oss-cn-****.aliyuncs.com`、`http://image.cnamedomain.com` | `SRC com/alibaba/sdk/android/oss/internal/InternalRequestOperation.java:178`、`SRC com/alibaba/sdk/android/oss/OSSImpl.java:128` | 阿里 | **死字符串/资源**：endpoint 格式报错文案里的示例值 |
| OSS 真实 bucket/endpoint（`<bucket>.<endpoint>` 形态） | 运行期拼装 `SRC …/gateway/LegacyDirectCloudConfig.java:151`；来源 `BuildConfig.TUWIN_OSS_ENDPOINT/REGION/BUCKET/ACCESS_KEY_ID/ACCESS_KEY_SECRET`（`SRC …/gateway/LegacyDirectCloudConfig.java:165`） | 厂商自有 | **运行时真会访问（条件）**：`isOssConfigured()`（`:136-145`）为 true 才上传；**BuildConfig.java 不在反编译产物里，五元组实值缺证**（缺证手段：baksmali 抽 `com/tuwinsmart/tuwin/BuildConfig`，或真机走"反馈-上传日志"看 `feedback_log_upload_unavailable reason=local_oss_config_missing` 事件是否出现，见 §6.3 链与 docs/06 日志读法） |
| github.com（39 处）、gist.github.com（12 处）、code.google.com（21 处）、issuetracker.google.com（8 处）、cs.android.com（4 处）、android.googlesource.com（4 处）、dev.to（2 处） | 各库源码注释/异常描述，例 `SRC com/efs/sdk/memleaksdk/monitor/internal/EnumC1093e.java:460`（泄漏参考文档串） | 各库 | **死字符串/资源**：Javadoc/注释/错误描述链接，无代码引用，不可能被请求 |

**汇总**：A 表 29 行（fullUrls 37 行全部落判定）+ B 表 14 行 = **43 个判定单元**；其中厂商自有"运行时真会访问"的外网域名共 **6 个**：`ali.tuwinsmart.com`（功能面）+ `yomu.atlasmeta.one`、`tuwinwifihelp.tuwinsmart.com`、`ride5helpnew.tuwinsmart.com`、`work.weixin.qq.com`、`tuwin.tmall.com`（内容/客服面），外加 2 个条件面 host（`appdownload`、`111.179.38.202`，服务器内容驱动）；友盟/efs 真访问 7 域（errnewlog、ulogs/cnlogs 主链、ucc、utoken、resolve 兜底、aspect-upush 弱证），死重 4 域（errnewlogos、preulogs、one.umops、htls，共 6 条端点 path）。教训复述：**包里有 ≠ 在用**——`one.umops.com`、`aspect-upush`、`203.107.1.1`、整个 `ren.yale` 预加载面、8 条 assets 文件名，全是"看见就抄"会翻车的死重量。

### 6.3 图片 / 存储 / 其它三方

每个库一句话 + 初始化位置 + 值得抄的配置常量。路径缩写 `SRC = _work/tuwin_src/sources/`。

| 库 | TUWIN 用它做什么 / 初始化在哪 | 值得抄的配置常量 |
|---|---|---|
| **Glide**（`com/bumptech`） | 全部图片装载（设备缩略图、banner、相册），定制模块 `SRC com/tuwinsmart/tuwin/core/glide/GlideNetworkModule.java:48`（`AppGlideModule`）。`isManifestParsingEnabled()==false`（`:50-51`）；`registerComponents`（`:55`）三件事：`:60` 用自定义 `DynamicNetworkCallFactory` **替换** `GlideUrl→InputStream` 默认 loader，`:61` 注册 `RoutedInternetImage`（外网图，须过 §6.2 白名单，`SRC …/core/glide/RoutedInternetImage.java:83`）、`:69` 注册 `AuthorizedDeviceResource`（设备缩略图，走 RouteLease/EndpointGrant） | `applyOptions`（`:95`，实现 `:99`）：`DiskLruCacheFactory(cacheDir + "/diskCache", 52428800L)` = **50 MiB**；`DynamicNetworkCallFactory`（`:104-134`）：`ConnectionPool(5, 5, MINUTES)`、`Dispatcher(maxRequests=16, perHost=2)`、常规超时 8s / Ride3Pro 缩略图串行路 5s（`Ride3ProGlideThumbnailPolicy.shouldSerialize`，复用 §2.4 调度器 + `addRide3ProRequestIdInterceptor`）；**关键设计**：`:133` 给该 client 装 `RejectingSocketFactory`（`:140-155`，任何 socket 创建抛 `IOException("Glide route is unavailable")`，`:146`）——裸 GlideUrl 永远连不出去，所有网络图必须改走 lease 路由。这就是"库自带下载器但 App 把它阉了"的典型 |
| **DataStore**（`androidx.datastore`） | 新设置存储，替代 SharedPreferences。`SRC com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepositoryKt.java:29-35` 顶层委托属性 `dataStore` | `DATASTORE_NAME = "user_preferences"`（`:28`）、`LEGACY_PREFERENCES_NAME = "TUWIN"`（`:26`）→ `SharedPreferencesMigration("TUWIN")`（`:33`）一次性搬迁；默认值 `DEFAULT_CONNECTED_DEVICES_JSON/…_EVENTS_JSON = "[]"`（`:24-25`）。消费者 `SRC …/data/source/local/preferences/UserPreferencesRepository.java:102`。注：旧的 `PreferenceHelper`（Gson 存 JSON 串）仍与它并存（§2.2 固件版本回读就走它） |
| **OkHttp 日志拦截器**（`com/ihsanbal` Logging） | 把**完整 HTTP 交换**写进自家日志系统（不是遥测！）。工厂 `SRC com/tuwinsmart/tuwin/core/util/logging/FullHttpLoggingInterceptorKt.java`：`LoggingInterceptor.Builder().setLevel(Level.BASIC).request("HTTP_FULL\|<client>\|REQUEST").response(…RESPONSE).logger(AppHttpLogger)`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/AppHttpLogger.java:30-41` 把 `HTTP_FULL\|client\|DIR` 标签重排成 `[HTTP_FULL][client][DIR] msg` 交 `Timber.isWriteFile(true)`（落到 §5 提到的 `WriteRuntimeLogTree`）。挂载点仅两处：`SRC …/core/device/ride3pro/Ride3ProSessionTransport.java:566`（`"ride3pro_api"`）、`SRC …/core/device/ride5/Ride5CgiGateway.java:248`（`"ride5_cgi"`） | §1.7 的 `RoutedOkHttpProvider` 通用链路**不挂**日志拦截器（该文件 `addInterceptor` 零命中）——只有两机型手写 client 全量落日志。`isWriteFile(true)` 开关常量、tag 格式值得对齐 docs/06 的 `op=`/交换行语法 |
| **RxJava**（`io.reactivex`） | 遗留数据层：`SRC …/core/util/network/NetworkUtil.java`、`SRC …/data/repository/DeviceRepositoryImpl.java` + retrofit rx 适配器/变换（`data/source/remote/transform/HttpResultFunc.java` 等），共 16 个厂商文件引用。与遥测无关，属"新 Flow 层旁边立着的旧 Rx 栈" | 无值得抄的常量（新代码一律 Flow，§5.3） |
| **WifiUtils**（`com/thanosfisherman`） | 只用了一个判断：`WifiUtils.withContext(ctx).isWifiConnected()` 四例——`SRC …/domain/strategy/M3ConnectionStrategy.java:212`、`SRC …/domain/strategy/Ride3ProConnectionStrategy.java:145`、`SRC …/domain/strategy/Ride5ConnectionStrategy.java:253`、`:377`。**没有**用它连网/`enableLogger` | 无。另：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:314` `ConnectUtil.init` 是厂商自写的 Wi-Fi 工具（`SRC …/core/util/ConnectUtil.java:43`，存 `WifiManager`+SSID 正则表，tag `"fingdo"` 暴露了抄来血统），不是三方 |
| **com.azhon AppUpdater** | **未用**。App 自更新是自己实现的（§3.7 `AppUpdateCoordinator`）；azhon 的 `AppUpdater` manager 全 APK 零构造，厂商唯一沾它的一处是把常量 `Constant.APK_SUFFIX` 内联进 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:591`（`…_smart_<ts>.apk`）。库自带但本 App 未触发。注：它的 `AppUpdateFileProvider` 仍注册在 manifest（`_work/re/tuwin/manifest.md:178`），authority `…fileProvider` 恰被 §3.7 的安装 Intent 复用——删库时会踩到的坑 | 无 |
| **com.noober background** | 不是 BackgoundHttp，是 **BL\* 背景属性 View 库**（圆角/描边 XML 属性），只出现在 databinding 生成的 View 类型里（`databinding/Activity*Binding.java` 大量 `BLTextView/BLImageView/BLEditText`）。其 `BackgroundContentProvider`（`multiprocess=true`，`_work/re/tuwin/manifest.md:179`）随进程自动初始化，无业务配置 | 无 |
| **com.lzy okgo/okserver** | 仅借数据类：`Progress`（进度字段名）、`HttpHeaders`、`SerializableCookie`（`@SerializedName` 键名）、`DownloadTask`（`TaskFinishInsertEvent` 载荷与旧下载列表页，§5.1）。**无 `OkGo.init`/`ODUtils` 调用点**，下载器不跑动——§2.3 已证 Range 下载路径进不去 | 无（教训：包体里躺着完整 lzy 栈但功能是死的） |
| **com.shuyu GSYVideoPlayer + tv.danmaku ijkplayer** | 播放宿主 + ijk 内核，全部参数、生命周期、重试已逐项抄清 → **§4.1/§4.3**。初始化 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:355-356`（`PlayerFactory.setPlayManager(IjkPlayerManager.class)` + `enableRawPlay`） | 见 §4（`setLogLevel(8)`、option 表） |
| **danikula videocache** | GSY 的缓存代理（`com/shuyu/gsyvideoplayer/cache/ProxyCacheManager.java` 唯一引用方）；App 侧 `setUpLazy(cache=false)`（§4.3）→ **未触发** | 无 |
| **阿里 OSS SDK**（`com/alibaba/sdk/android/oss`） | 厂商**自建诊断日志上云**：`LogHelper.uploadLogFile`（`SRC …/core/util/wifi/LogHelper.java:293-301`，取 `DiagnosticUploadGateway`）→ `SRC …/gateway/RoutedLegacyDiagnosticUploadGateway.java`：`:195-197` `isOssConfigured()` 不满足则记 `feedback_log_upload_unavailable reason=local_oss_config_missing` 返回 UNAVAILABLE；满足则 `:200` `NetworkIntent.Internet("feedback_log_upload")` + `INTERNET_UPLOAD` profile lease → `:295-300` `ClientConfiguration{SignVersion.V4, maxErrorRetry=0, httpDns=off, redirects=off, okHttpClient=路由后client}` → `:301` `new OSSClient(ctx, endpoint, OSSPlainTextAKSKCredentialProvider(ak, sk), cfg)` → `PutObject(bucket, key, file, metadata)`（`:467`）。触发者：`SRC …/presentation/p010ui/mine/FeedbackActivity.java:688/:1261`（**用户在反馈页点"上传日志"**才传）。gzip 文本、`publicOssUrl` 回填给反馈单（§6.2 `FeedbackLogUploadPolicy:22`） | AKSK 编译期进 BuildConfig 即视为泄露面（明文打进 APK）；V4 签名、重试 0 次、复用 route lease 的"三方 SDK 塞 OkHttp 实例"手法（`:300` `setOkHttpClient`）值得借鉴——**但云上传本身我们不做**，见 6.4 |
| **ren.yale CacheWebView** | 库完整在包（`ren/yale/android/cachewebviewlib/`），`com/tuwinsmart/**` 对 `ren.yale` **零引用**——本应是 §6.2 那 8 条 assets 预热的配套，随 Coordinator 一起成死重 | 无 |
| **Koin**（`org/koin`） | DI 容器。`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:276-296 initKoin`：`androidContext` + `androidLogger(Level.ERROR)`（`:292`）+ 单模块 `AppModuleKt.getAppModule()`（`:293`）。全 app 经 `KoinJavaComponent.get$default` 取单例 | 无 app 级配置常量 |
| **其余小库一句话** | greenrobot EventBus（§5.1）；google gson（全 JSON 序列化）；jakewharton Timber（§5/6.1 日志树宿主）；toasty `es.dmoral`——`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:354` `Toasty.Config.getInstance().tintIcon(true).allowQueue(true).setGravity(17, 0, dp(30)).supportDarkTheme(false).setRTL(false)`（唯一一处配置常量）；`com.release.alert`（对话框，§5.1 见过）；hjq permissions（权限申请）；flyco tablayout / bskim maxheightscrollview / xuliwen zoom / chrisbanes photoview / danikula（UI 装饰）；multidex（`MultiDexApplication`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:141`，佐证 classes*.dex ≥2） | — |

### 6.4 我们自己要不要跟

**明确不做**（对齐 `docs/04-固件更新与功能差距.md:787-795` C 组"明确不做"口径）：
1. **友盟全家桶整体不跟**：U-App 自动会话上报、U-APM（崩溃/ANR/内存泄漏/启动/页面/远程日志）、ccg 云配置、`utoken` zid 设备指纹、OAID 采集（连带 `AD_ID`、`freemme.permission.msa` 两个权限也不进我们 manifest）。TUWIN 虽然把它们挡在隐私同意之后，本质仍是"装机即备好的追踪面"。
2. **推广/外链不跟**：`v.douyin.com`、`xhslink.com`、`mp.weixin.qq.com` 文章、`tuwin.tmall.com` 商城、banner 运营位（`ali.tuwinsmart.com/banner` + `111.179.38.202` 图床）——正对应 C 组"平台专属推广/广告面"。
3. **日志/反馈上云不跟**：OSS 直传（AKSK 进 APK）与 `POST http://ali.tuwinsmart.com/feedback` 的"云端收日志"模式不复制；`yomu.atlasmeta.one` 在线隐私政策也建议本地化打包（离线可读、可审计）。

**要模仿的行为**：
1. **崩溃先落盘再谈别的**：抄 `AppCrashHandler` 的形态（§6.1）——delegating handler、写 `cacheDir/CLOG`、带 `session_id/app_version/android_sdk/device` 元数据、不抢链（`previousHandler` 必调）。对我们这就是把 docs/06 rovdiag 的 buffer 在崩溃时**强制 flush 成导出文件**，让用户"下次连不上"也能带崩溃上下文回来。
2. **HTTP 全量交换进同一日志通道**：`FullHttpLoggingInterceptorKt` 的 `LOG_SOURCE="HTTP_FULL"` + `[HTTP_FULL][client][REQUEST/RESPONSE]` tag 设计与"只在手写设备上开、通用路由层不开"的克制，正是 docs/06 交换行该长成的样子（脱敏默认开是他们的短板——`DiagnosticHttpLogPolicy` 白名单可抄，见 §2.3）。
3. **网络图必须走受控通道**：Glide 装 `RejectingSocketFactory` 逼所有图片过路由 lease + host 白名单（§6.3 首行），这个"库默认出口直接焊死"的思路值得原样搬——我们的图片加载器同样不该保留"随便 fetch 一个 URL"的旁路。
4. 同意闸门（`isAgreePrivacy` 前后两套初始化，§6.1）作为行为模式保留：我们无上报可挡，但"首启未同意前零外联、同意动作触发 `initThirdLibs` 等价物"的时序值得对齐。

---

## 7. 原生库

数据源：`data/tuwin/natives.md`（ELF 头 + .dynsym 全量）、`natives-jni.md`（`Java_*` 导出）、`natives-strings.tsv`。9 个 `.so` 全在 `lib/arm64-v8a/`，**没有 x86 / armeabi 版本**（模拟器上跑不了 TUWIN 的播放与崩溃栈，与我们只出 arm64 设备包的决定一致）。

### 7.1 9 个 `.so` 的用途

| 库 | 字节 | DT_NEEDED（前几个） | 导出 | 导入 | `Java_*` | 判定 |
|---|---|---|---|---|---|---|
| `libffmpeg.so` | 15,561,312 | liblog · libandroid · libOpenSLES · libEGL · libGLESv2 · libjnigraphics · libz · libc | 6541 | 258 | **36** | 自研播放器/转码核心，真在用（见 7.2） |
| `libijkffmpeg.so` | 6,440,880 | libm · libz · libdl · libc | 8809 | 200 | 0 | ijkplayer 带的 FFmpeg 分支，只被 `libijkplayer.so` 依赖 |
| `libijkplayer.so` | 545,896 | **libijkffmpeg** · **libijksdl** · liblog · libandroid | 826 | 364 | 0 | 预览播放；**无 `Java_*` 导出但导出 `JNI_OnLoad` → `RegisterNatives` 动态注册** |
| `libijksdl.so` | 362,832 | libijkffmpeg · liblog · libandroid · libOpenSLES · libEGL · libGLESv2 | — | — | 0 | 同上，动态注册 |
| `libucrash.so` / `libucrash-core.so` | 51,288 / 101,376 | liblog · libdl · libm · libc | 1 / 0 | 97 / 66 | 0 | 友盟 U-Crash 原生栈，`JNI_OnLoad` 动态注册 |
| `libumonitor.so` | 250,968 | liblog · libm · libdl · libc | 1 | 88 | 0 | 友盟内存/性能监控（`com.efs.sdk.memleaksdk.*`，含 `:u_heap` 进程的 `UMonitorService`，`data/tuwin/manifest.md:150`） |
| `libumeng-spy.so` | 398,472 | liblog · libm · libdl · libc | 381 | 61 | **3** | 友盟 UMID/设备标识：`Java_com_umeng_umzid_Spy_getNativeTag`、`getNativeLibraryVersion`、`getNativeID` |
| `libdatastore_shared_counter.so` | 7,112 | libm · libdl · libc | 9 | 10 | 4 | androidx DataStore 多进程计数，与相机无关 |

**给提取层的教训**：按 `Java_*` 名字抽 JNI 会**系统性漏掉 ijkplayer / ucrash / umonitor** —— 这 5 个库
（`libffmpeg`、`libijkplayer`、`libijksdl`、`libucrash`、`libumonitor`）都导出 `JNI_OnLoad`，
方法靠 `env->RegisterNatives` 绑定，符号表里不出现 `Java_` 前缀。判断某 `.so` 是否真被 Java 用到，
要同时看 `JNI_OnLoad` 与 `natives-strings.tsv` 里的类签名串。

### 7.2 `Java_*` 符号 → `external fun` 声明与调用点

`libffmpeg.so` 的 36 个导出全是 `Java_com_generalplus_ffmpegLib_ffmpegWrapper_na*`，按语义分四类：

| 类别 | 符号 |
|---|---|
| 播放控制 | `naSetup` · `naInitAndPlay` · `naPlay` · `naStop` · `naPause` · `naResume` · `naSeek` · `naStatus` · `naGetPosition` · `naGetDuration` |
| 解码/渲染 | `naGetDecodeFrame` · `naInitDrawFrame` · `naDrawFrame` · `naGetFrameCnt` · `naGetRevSizeCnt` · `naSetCovertDecodeFrameFormat` · `naSetDecodeOptions` · `naSetScaleMode` · `naSetZoomInRatio` |
| 转码/抽帧 | `naTranscodeAviToMp4` · `naCancelTranscode` · `naSetTransCodeOptions` · `naSetEncodeByLocalTime` · `naSetForceToTranscode` · `naGetTranscodeProgress` · `naExtractFrame` · `naSaveVideo` · `naStopSaveVideo` |
| 流与信息 | `naSetStreaming` · `naGetStreamCodecID` · `naGetVideoRes` · `naGetVideoInfo` · `naSetBufferingTime` · `naSetRepeat` · `naSetDebugMessage` · `napshot`（符号名照抄，`na` 与 `pshot` 之间没有下划线） |

调用侧证据：8 个厂商文件 `import com.generalplus.ffmpegLib.ffmpegWrapper`，其中
`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/Ride3ProLocalVideoTranscoder.java:6`。

**但那个 wrapper 类不在 jadx 输出里**：`_work/tuwin_src/sources/com/` 下没有 `generalplus/` 目录，全树也搜不到 `class ffmpegWrapper`。
即 Java 侧声明确实被 dex 引用，只是 jadx 没为它落文件。要拿它的 `external fun` 原型需要
`jadx --single-class com.generalplus.ffmpegLib.ffmpegWrapper`，而这条路在本 APK 上会撞上本文开头说的资源/缓存阶段卡死 —— 记为**已知工具限制**，不影响本节按符号名归类。

---

## 8. 对既有文档的纠正

### 8.1 `docs/04-固件更新与功能差距.md`

| 现文档说法 | 证据 | 应改为 |
|---|---|---|
| 「App 自更新与相机 OTA 是两套东西，别混」 | 成立。App 侧：`core/update/AppUpdateCoordinator`，`AppUpdateCheckState` 7 态（`IDLE / WAITING_FOR_INTERNET_ROUTE / CHECKING / NO_UPDATE / UPDATE_AVAILABLE / CHECK_FAILED / CHECK_CANCELLED`），去重键实参 `AppUpdateCheckKey(250, "stable", "production")`；相机侧是本附录 §3 的 14 态机 | 结论保留，**补这组实值**；并记官方端点拼写为 `@GET("appupdatecheker")`（`data/source/remote/api/TuwinSuspendApi.java`，少一个 `c`）。我们已决定不做 App 自更新，不必复刻该拼写 |
| OTA 小节只写「上传 + 触发」 | §3.2–§3.6 给出 `md5sum`/`model`/`hw`/`sw` 四字段的取值来源、分块大小、超时、装机后回读版本的路径 | 把 §3 的字段来源与状态机并进 `docs/04`，别停在两步 |

### 8.2 `docs/05-网络API清单与安全评估.md`

| 现文档做法 | 证据 | 应改为 |
|---|---|---|
| 按 APK 里出现过的域名列清单 | §6.2 判定 43 条：**运行时真访问 15 条**（厂商自有 6 个 + 条件性 2 个 + 友盟侧 7 个：`errnewlog`/`ulogs`/`cnlogs`/`ucc`/`utoken`/`resolve`/`aspect-upush`），其余 28 条为库自带未触发或死字符串 | 域名清单一律带「真访问 / 未触发 / 死字符串」三档与依据行号；厂商侧真实外网域名只有 6 个，更新检查域是 `ali.tuwinsmart.com` |
| 「统计/崩溃：友盟 Umeng + ucrash」一句带过 | 友盟**确实在用**：隐私同意后反射 `UMConfigure.init(...)`，AppKey 常量 `6781b8f38f232a05f1f56ef5`（§6.1）；`libumeng-spy` 提供 UMID 原生取值（§7.1） | 写出「同意后初始化 + AppKey + 3 个 `Java_*`」，作为我们做隐私对照的具体靶子（我们不上报＝不实现这一层） |
| — | §6.2 顺带修正了提取层自身：`signals-hosts.tsv` 1088 行里约 **95% 是正则误报**（`.kt` 文件名、全限定类名被当成主机名） | 在方法小节注明「`signals-hosts` 只能当线索，不能当清单」；这条同样记进 `tools/re/README.md` |

### 8.3 `docs/03-品牌型号与协议矩阵.md` §1.3 / §1.4 / §1.6

| 现文档说法 | 证据 | 应改为 |
|---|---|---|
| §1.4 描述路由绑定但无数值 | §1.8：lease 替换等待 `3000 ms`、替换轮询 `50 ms`、Wi-Fi 扫描等待 `8000 ms`、`WifiNetworkSpecifier` 要求 `SDK ≥ 29`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:61,62,272`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiScanner.java:42`） | 四个数值进矩阵，它们就是我们超时/重试默认值的参照 |
| §1.6「设备源下载禁用 HTTP Range，续传是 `?offset=`」 | 结论对但此前无硬证据：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/TransferRequest.java:163-165` 对设备传输使用 `ResumePolicy.HttpRange` **直接抛异常**；全树 `Range` 头写入点只有 1 处且属日志脱敏白名单；构造处 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:123` 不加任何 header | 补三条出处，并写明原因：相机不接受 Range 语义，续传靠 `?offset=` 且受固件版本门限（§2.1–§2.2） |
| §1.1 技术栈「`libffmpeg.so`(15MB)、ijkplayer 全套」 | §7.1 精确到 9 个 `.so` 及依赖；`libijkplayer` 无 `Java_*` 导出，靠 `JNI_OnLoad` 动态注册 | 概括保留，细节指向本附录 §7，并记「按 `Java_*` 统计 JNI 面会漏 ijk/ucrash/umonitor」 |
