# 自研开源相机连接 App —— KMP 架构与开发计划

> 技术基线：**Kotlin Multiplatform (KMP)** + **Compose Multiplatform** + **Compose Cupertino**（iOS 风格 UI）
> 核心诉求：**可扩展**（未来新相机/新品牌可直接接入）、WiFi 直连 + RTSP 实时图传 + 文件传输、多机型配对。
> 配套阅读：`01-APK逆向分析报告.md`

## 0. 最新决策（2026-09-20，已与用户确认方向）
1. **平台优先级：Android 优先并先可用**；**iOS 仅同步搭壳**（保留 `iosApp` 模块 + `expect/actual` 占位与编译通过），用户**无 iOS 设备、不测 iOS**，故 iOS 不做功能验证，只保证不破坏共享代码编译。
2. **首个落地品牌/机型：XTU**，首插件走 **Hisilicon CGI（`/cgi-bin/hi3510/`）**。理由：XTU GO 启动页即 `hisilicon.dv.ui.WelcomeActivity`（海思是 XTU 主平台），且 CGI 是 HTTP 协议、在 KMP 里最易实现（Ktor），命令集已大量提取。
3. **关于「XTU X7 Pro」**：XTU GO v8.4.3 的型号表与公开资料均**查无 X7 Pro**（内置型号为 S2/S3/S3Pro/S5K/S6/S6Pro/S7/**S7Pro/S7ProMax**/X1/X2/X3/R1/Max2/Max3/MaxPro/Mini1/Mini2Pro）。推测用户设备实为 **S7 Pro** 或 X 系列，或为更新型号。**对策：不写死型号**——框架内置**运行时平台自动探测**（依次探 Hisilicon CGI / Ambarella socket / SigmaStar，并从 `getdeviceattr`/`getproductinfo` 读真实型号），由设备自报身份。待用户提供相机 **WiFi SSID + 机身型号** 后锁定首个 Profile。
4. 其余技术细节由我（助手）决定并推进。

---

## 1. 目标与设计原则

1. **协议即插件**：相机协议（HTTP REST / HTTP CGI / JSON-over-TCP / 二进制帧 / RTSP）全部抽象为可插拔实现，新增品牌/机型 = 新增一个插件模块或一份声明式档案，**不改核心、不改 UI**。
2. **共享一切可共享的，下沉一切必须下沉的**：业务/协议/UI 放 commonMain；WiFi 连接、视频渲染、权限、蓝牙/QR 等强平台相关能力用 `expect/actual` 下沉。
3. **设备自描述优先**：尽量让相机下发能力/菜单（如 TUWIN 的 menu XML、param 列表），App 按能力开关功能，减少硬编码。
4. **精简、不卡顿**：不堆重型 SDK；命令并发窗口 + 优先级 + 乐观 UI；Compose 单 Activity 声明式导航；预览走平台原生播放器 + 合理缓冲。
5. **干净室与开源合规**：仅利用逆向得到的**协议接口知识**做互操作重实现，**不复制官方代码**；协议档案可社区贡献。

---

## 2. 技术选型（全部支持 KMP）

| 关注点 | 选型 | 说明 |
|---|---|---|
| UI | **Compose Multiplatform** + **Compose Cupertino** | Cupertino 提供 iOS 风格组件（导航栏/列表/开关/弹窗/分段控件等）与 adaptive 主题，支持 Android/iOS/Desktop。坐标 `io.github.alexzhirkevich:cupertino*`（落地前核对最新版本） |
| 导航/生命周期/组件 | **Decompose**（推荐）或 Voyager | 单 Activity，组件化 + 状态驱动；Decompose 与 Compose Multiplatform 契合度高 |
| 状态管理 | 协程 **Flow** + ViewModel（JetBrains `androidx.lifecycle:lifecycle-viewmodel-compose` 已多平台，或 Decompose 自带） | MVI 单向数据流 |
| DI | **Koin**（多平台） | 协议插件注册、按品牌注入 |
| HTTP | **Ktor Client**（Android: OkHttp/CIO；iOS: Darwin；Desktop: CIO） | 统一 API；Android 可定制 SocketFactory 绑定网卡 |
| 原生 TCP | **ktor-network**（`aSocket`，JVM + Native/iOS 可用） | Ambarella/M3/SigmaStar 的 socket 协议、定界帧解码可在 commonMain 实现 |
| 序列化 | **kotlinx.serialization** | JSON 命令/DTO；XML 菜单用轻量解析（自写或 `xmlutil`） |
| 文件 IO | **okio** | 多平台文件/流，下载续传 |
| 本地存储 | **multiplatform-settings**（键值）+ 可选 **SQLDelight**（下载记录/设备列表） | |
| 时间 | **kotlinx-datetime** | 相机时间同步 |
| 日志 | **Kermit** | 多平台日志 |
| 预览播放 | **expect/actual**：Android = Media3/ExoPlayer（或 ijkplayer）；iOS = **AVPlayer**；Desktop = 调试用 | Compose 无内置视频；低延迟需调缓冲/传输 |
| 二维码/蓝牙（可选） | expect/actual：Android ZXing/BT；iOS AVFoundation/CoreBluetooth | 作为配网扩展，非首期必需 |
| 测试 | kotlin.test + **Desktop(JVM) 目标** + **相机模拟器** | 协议逻辑可在桌面端对模拟器联调，无需真机 |

> 桌面(JVM)目标的价值：把「相机」做成一个本地模拟器（HTTP/CGI/Socket/RTSP 桩），协议插件、传输引擎、UI 都能在桌面跑通，极大加速开发与 CI。

---

## 3. 平台策略（expect/actual 边界）

**必须下沉到平台的能力：**
- `WifiConnector`：发现/连接相机 AP、绑定路由。
  - Android：`WifiNetworkSpecifier + requestNetwork + bindProcessToNetwork + Network.bindSocket`（API29+）；旧版 `WifiManager.addNetwork`；权限 `NEARBY_WIFI_DEVICES` + 定位。
  - iOS：`NEHotspotConfigurationManager.apply(...)` 加入 AP；无 bindProcessToNetwork，依赖 IP 子网路由；保互联网用 `URLSessionConfiguration.waitsForConnectivity / allowsConstrainedNetworkAccess`。**iOS 最高风险点**。
  - Desktop：桩实现（直连 IP，便于模拟器联调）。
- `PreviewSurface` / `VideoPlayerController`：RTSP 渲染（Android Media3 / iOS AVPlayer）。
- `PermissionController`：运行时权限。
- 可选 `BluetoothController` / `QrScanner`。

**留在 commonMain 的：** 协议插件、命令编解码、传输/下载引擎、设备档案与注册表、状态机、全部 UI、领域用例。

---

## 4. 可扩展架构设计（核心）

### 4.1 分层
```
UI(Compose+Cupertino) → ViewModel/Component(Decompose) → Domain(UseCase)
        → Data(Repository) → [CameraProtocol 插件] → [Transport: HTTP/Socket/RTSP]
                                   ↑ CameraProfile(声明式档案) + Registry(按设备身份路由)
        → 平台 expect/actual(WifiConnector/VideoPlayer/Permission)
```

### 4.2 关键抽象（commonMain，代码草图）
```kotlin
// 设备身份（来自扫描 SSID/探测响应/用户选择）
data class DeviceIdentity(val brand: String, val model: String, val raw: String)

// 声明式设备档案：可内置，也可从 JSON/资产/远程加载 → 简单相机免编译扩展
data class CameraProfile(
    val id: String,
    val match: MatchRule,                 // SSID 正则 / 型号 / 探测端点响应
    val control: ControlTransport,        // Http(baseUrl, port, pathPrefix, allowlist) | Socket(host, port, framing)
    val media: MediaTransport,            // Rtsp(port, pathTemplate, transport=AUTO/TCP/UDP)
    val auth: AuthScheme,                 // None | Seed(path) | Token | Custom
    val capabilities: Set<String>,        // 设备自描述能力
    val commandSet: String,               // 引用的命令集（内置或数据驱动）
)

// 协议插件：每品牌/芯片实现一份；UI/领域只依赖此接口
interface CameraProtocol {
    val profileId: String
    suspend fun connect(t: BoundTransport): Session
    suspend fun authenticate(s: Session): AuthResult
    suspend fun getStatus(s: Session): DeviceStatus
    suspend fun setParam(s: Session, id: String, value: String): CmdResult
    suspend fun setMode(s: Session, mode: Mode): CmdResult
    suspend fun capture(s: Session): CmdResult
    suspend fun record(s: Session, start: Boolean): CmdResult
    suspend fun listFiles(s: Session, page: Page): FileList
    fun previewUrl(s: Session): String           // RTSP URL
    suspend fun download(s: Session, f: RemoteFile, sink: Path, onProgress: (Float)->Unit): Result
    val events: Flow<DeviceEvent>                // socket 实时推送（录制状态/电量等）
}

// 路由绑定传输（Android 绑相机网卡；iOS/Desktop 默认路由）
interface BoundTransport { fun http(): HttpClient; fun socket(): Socket }

// 注册表：身份 + 档案 → 协议实例
interface CameraProtocolRegistry {
    fun register(factory: (CameraProfile) -> CameraProtocol)
    fun resolve(id: DeviceIdentity, p: CameraProfile): CameraProtocol
}
```

### 4.3 扩展方式（满足「未来直接扩展」）
- **新增品牌/芯片**：新建 `:brand-xxx` 模块，实现 `CameraProtocol`（复用 `core-protocol-http` / `core-protocol-socket` 基类），在 Koin 注册 + 提供 `CameraProfile`。核心与 UI 零改动。
- **新增同协议族机型**：仅加一份 `CameraProfile`（甚至 JSON 数据驱动，免编译），由通用 HTTP/CGI/Socket 协议基类驱动。
- **安全白名单**：沿用 TUWIN 的 `allowedControlPorts/allowedMediaPorts/allowedPathPrefixes/expectedModels`，连接前校验探测端点，防误连/恶意端点。
- **能力协商**：`capabilities` 决定 UI 是否显示某功能（如直播/全景/滤镜），新能力无需改 UI 框架。

### 4.4 已识别的协议族 → 复用基类
| 基类 | 覆盖 | 说明 |
|---|---|---|
| `HttpRestProtocol` | TUWIN Ride3Pro/Ride6(`/api`)、M3(`/app`) | Retrofit 风格端点表 + 串行队列 + 请求 ID |
| `HttpCgiProtocol` | TUWIN Ride5(`/cgi-bin/hisnet`)、XTU Hisilicon(`/cgi-bin/hi3510`) | `get/set*.cgi?param=value` 泛化命令 |
| `JsonSocketProtocol` | XTU Ambarella(`msg_id/rval`)、TUWIN M3 事件、XTU SigmaStar | ktor-network TCP + 定界帧/JSON 编解码 |
| `RtspPreview` | 全部 | URL 模板 + seed 握手 + 传输配置，渲染走平台 |

---

## 5. 模块划分（Gradle KMP）
```
:composeApp        共享 UI(Compose+Cupertino)+导航+ViewModel
:design-system     Cupertino 主题/通用组件封装
:core-model        纯模型/枚举(DeviceStatus/Mode/FileItem/Event…)
:core-protocol     CameraProtocol/Profile/Registry/Transport/白名单 抽象
:core-protocol-http  HTTP REST/CGI 协议基类(Ktor)
:core-protocol-socket TCP/JSON/定界帧 协议基类(ktor-network)
:core-rtsp         RTSP URL/握手/传输配置
:core-transfer     下载/上传引擎(队列/断点续传/进度, okio+Ktor)
:core-wifi         WiFi 发现/连接/路由绑定 (expect/actual)
:core-media        预览播放器 (expect/actual: Media3/AVPlayer)
:core-persistence  设置/设备列表/下载记录 (multiplatform-settings/SQLDelight)
:domain            用例(ConnectDevice/StartPreview/DownloadFile…)
:data              Repository 实现(组合 protocol+transfer+wifi)
:brand-tuwin       TUWIN 插件(Ride3Pro/Ride6/Ride5/M3)
:brand-xtu         XTU 插件(Ambarella/Hisilicon/SigmaStar)
:app-android       Android 壳
:app-ios           iOS 壳(Xcode)
:app-desktop       桌面调试壳 + 相机模拟器(可选但强烈建议)
```

---

## 6. 关键难点与方案

### 6.1 WiFi 直连 + 同时保互联网（Android）
- 用 `WifiNetworkSpecifier`（SSID 正则 + 可选 BSSID）+ `requestNetwork`，`removeCapability(NET_CAPABILITY_INTERNET)` 避免抢占蜂窝。
- `bindProcessToNetwork(network)` 让 HTTP/RTSP/Socket 全走相机网卡；Ktor(OkHttp 引擎) 注入绑定该 Network 的 SocketFactory；ktor-network 的 socket 用 `network.bindSocket()`。
- 拓扑监控（WiFi/蜂窝 NetworkCallback），断连触发会话恢复（参考 TUWIN `RecoverableDeviceControlChannel`）。

### 6.2 WiFi 直连（iOS，最高风险）
- `NEHotspotConfigurationManager.applyConfiguration` 加入相机 AP（系统弹窗授权）。
- 无进程级路由绑定；访问相机 IP 走 WiFi 子网路由，互联网由 iOS 自动回蜂窝。需设 `waitsForConnectivity`、`allowsConstrainedNetworkAccess=true`、`allowsExpensiveNetworkAccess=true`。
- 进阶（如需稳定保活/后台）：评估 `NEHotspotHelper`（需 Apple 特批 entitlement）。**建议早做 iOS 真机连通性验证（M2 并行）**。

### 6.3 RTSP 低延迟图传
- 统一 `previewUrl(session)` 由协议插件给出（含 seed 握手后的授权）。
- Android：Media3/ExoPlayer（RTSP 支持）或 ijkplayer；调小缓冲、优先 TCP、丢帧追帧。
- iOS：AVPlayer（原生 RTSP）；`automaticallyWaitsToMinimizeStalling=false` 降延迟。
- 渲染嵌入 Compose：AndroidView / UIKitView 包装平台播放器；统一 `VideoPlayerController`(play/stop/snapshot/aspect)。

### 6.4 命令并发与延迟
- 每会话一个**串行调度器** + 命令优先级（控制命令 > 状态轮询 > 缩略图）+ 超时重试 + 乐观 UI（先更新本地态再确认）。

### 6.5 文件传输
- `core-transfer`：Ktor 流式下载 + okio 落盘 + `Range` 断点续传 + 校验和 + 队列 + 进度 Flow（对标 TUWIN `StreamingTransferEngine`）。

---

## 7. UI 设计（Compose Cupertino）

**屏幕清单（首期）：**
1. 设备列表/已配对设备（含连接状态、电量、型号）
2. 添加设备：扫描中的相机 AP 列表（按 SSID 规则识别品牌/机型）+ 手动输入 SSID/密码（+ 可选 QR/蓝牙）
3. 连接中/握手态（每操作独立进度，灰态给原因——参考用户偏好）
4. 实时预览页（RTSP 画面 + 拍摄/录像/模式切换/设置入口；横屏）
5. 设置页（设备自描述菜单/参数动态渲染）
6. 文件浏览（相机 SD：列表/网格 + 缩略图 + 日期分组）
7. 下载管理（队列/进度/续传/完成；行内操作走对话框）
8. 设备详情/固件 OTA/时间同步/格式化

**风格**：Cupertino 组件（`CupertinoNavigationBar`、`CupertinoListSection`、`CupertinoSwitch`、`CupertinoAlertDialog`、`CupertinoSegmentedControl`、`CupertinoActivityIndicator`）。adaptive 主题保证 Android 上也协调。交互遵循用户既有偏好：行→对话框操作、超过一天显示完整日期、灰态控件要给原因、每操作独立 busy 态。

---

## 8. 协议文档化工作流（Phase 1）
1. 静态逆向（jadx 已就绪）：补全 `01-报告.md` 第 4 节列出的 7 项未知（seed 关系、M3 帧分隔符、Ambarella msg_id 表、Hisilicon set 参数、SigmaStar 报文、SSID 规则、下载 URL 构造）。
2. 真机抓包：手机连相机 AP，用 mitmproxy/Wireshark/路由器镜像验证 HTTP/CGI/Socket/RTSP 实际报文。
3. 编写每机型 **Protocol Spec**（端点/命令/字段/时序/错误码）入库 `docs/protocols/`。
4. 据 Spec 做干净室重实现（不复制官方代码）。

---

## 9. 开发路线图

| 阶段 | 目标 | 关键产出 |
|---|---|---|
| **M0 脚手架** | KMP + Compose Multiplatform + Cupertino + Decompose + Koin + CI；**Android 可跑、iOS 模块编译通过（占位）** | 三端工程骨架（iOS 仅壳） |
| **M1 核心抽象** | `core-model/protocol/transport/registry` + 桌面**相机模拟器**（先做 Hisilicon CGI 桩） | 协议框架 + 模拟器联调 |
| **M2 WiFi 直连(Android)** | `core-wifi` Android 实现（WifiNetworkSpecifier+bindProcessToNetwork）+ 设备发现/识别 + **运行时平台自动探测** | Android 真机连上相机 AP 并识别型号 |
| **M3 首个协议落地** | **XTU Hisilicon CGI**（`/cgi-bin/hi3510/`）：连接/`getdeviceattr`/状态/拍摄/录像/工作模式/设置(get·set) | 用户的 XTU 相机可控可拍 |
| **M4 实时图传** | `core-media` Android(Media3/ExoPlayer) + RTSP(`:554 /livestream/12`) + 预览页 | 低延迟实时画面 |
| **M5 文件传输** | `core-transfer` 文件列表/缩略图/下载/断点续传/队列 + 下载管理 UI | 可下载相机文件 |
| **M6 扩展性验证** | 再加一个 XTU 平台插件（Ambarella JSON-socket 或 SigmaStar）+ TUWIN 插件，验证「注册即用」 | 证明插件式扩展 |
| **M7 iOS（仅搭壳）** | `core-wifi`(NEHotspot)/`core-media`(AVPlayer) 的 `actual` 占位 + 编译通过；**不做真机验证**（用户无设备） | iOS 不阻塞共享代码 |
| **M8 打磨/开源发布** | 协议档案数据驱动、贡献指南、文档、签名、GitHub Release/F-Droid | 1.0 开源 |

> 顺序理由：用户只有 Android + 一台 XTU 相机，故全程 **Android 优先**，用「最易实现的 HTTP CGI（Hisilicon）」打通端到端骨架（M2–M5），再用异构协议（Ambarella socket / TUWIN）验证可扩展性（M6）。iOS 全程只保证编译同步（M0/M7），待用户将来有设备再补真机验证。

---

## 10. 风险与对策
| 风险 | 等级 | 对策 |
|---|---|---|
| iOS WiFi AP 连接 + 保互联网不稳定 | 高 | M2 即做 iOS 真机验证；备 NEHotspotHelper 评估；文档说明限制 |
| iOS RTSP 延迟/兼容 | 中 | AVPlayer 调优；必要时 FFmpeg cinterop 自渲染 |
| 协议逆向不完整（seed/二进制帧/msg_id） | 中 | Phase1 静态+抓包补全；先做已明确协议(REST/CGI) |
| 同品牌不同固件协议漂移 | 中 | 能力协商 + 档案版本化 + 探测校验 |
| 设备碎片化（无法逐一真机测） | 中 | 模拟器 + 社区贡献档案 + 抓包众包 |
| 法律/合规 | 中 | 干净室重实现、仅互操作、不复制代码、不内嵌官方固件/资产 |

---

## 11. 下一步（已确认 + 待用户提供 1 项信息）
**已确认**：Android 优先 / iOS 仅搭壳；首品牌 XTU、首插件 Hisilicon CGI；框架内置运行时平台自动探测，不写死型号。

**待用户提供（用于锁定首个 Profile，10 秒即可）**：
1. 相机开机后，手机 WiFi 列表里看到的**相机热点 SSID**（前缀通常直接暴露平台/型号，如 `XTU...`/`X7...`/`S7...`）。
2. 机身/包装上的**确切型号名**（确认是 X7 Pro 还是 S7 Pro / X 系列）。

**我可以立即开始（无需等待）**：
- 搭 **M0 工程脚手架**（KMP + Compose Multiplatform + Compose Cupertino + Decompose + Koin + Android 壳 + iOS 占位 + Desktop 模拟器），并实现 **M1 核心抽象** 与 **Hisilicon CGI 协议插件骨架**（含已提取的 `get/set*.cgi` 命令集）。
- 同步补全 Hisilicon 协议规格到 `docs/protocols/hisilicon-hi3510.md`（含 `getcapability/getdevcapabilities` 可枚举参数）。
