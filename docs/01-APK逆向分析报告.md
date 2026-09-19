# 运动相机官方 APK 逆向分析报告

> 分析对象：`TUWIN.apk`、`XTU GO_8.4.3_243.apk`（均未加密/未加固）
> 工具：jadx 1.5.6 反编译 + aapt 解析清单 + dex 字符串挖掘
> 目的：为自研开源 KMP 相机连接 App 提供协议与架构依据
> 日期：2026-09-20

---

## 0. 总览对比

| 项目 | TUWIN | XTU GO |
|---|---|---|
| 包名 | `com.tuwinsmart.tuwin` | `com.gku.xtugo` |
| 版本 | 1.6.4 (250) | 8.4.3 (243) |
| 体积 | 23.8 MB | 153 MB |
| minSdk / targetSdk | 24 / **36** (Android 16) | 23 / 35 (Android 15) |
| ABI | 仅 arm64-v8a | arm64-v8a + armeabi-v7a |
| 语言/架构 | Kotlin + **Clean Architecture** | Java/Kotlin 混合 + **厂商 SDK (gku.actioncam)** |
| 设备维度 | 按**机型**分（M3 / Ride3Pro / Ride5 / Ride6） | 按**芯片平台**分（Ambarella / Hisilicon / SigmaStar） |
| 连接方式 | WiFi 直连（WifiNetworkSpecifier） | WiFi 直连 + **二维码配网** + **蓝牙** |
| 实时图传 | **RTSP** + 自研 FFmpeg/GSY(ijkplayer) 渲染 | **RTSP** + ijkplayer |
| 控制协议 | HTTP REST + 原生 TCP Socket + CGI | JSON-over-Socket + HTTP CGI + Socket |
| 特色 | 路由级网络绑定、断点续传、菜单 XML | 抖音直播、互联网远程观看、全景 VR、高德 GPS、滤镜 |
| 统计/崩溃 | 友盟 Umeng + ucrash | Bugly + APM Insight + Umeng |
| 代码混淆 | 几乎不混淆（类名完整） | App 层重度混淆，SDK 层 (`com.gku.*`) 不混淆 |

**核心结论**：两个 App 都印证了同一行业现实——**运动相机没有统一协议**。同一品牌内不同机型/芯片用的协议、端口、路径都不同。因此自研 App 的第一性设计目标必须是**协议可插拔**，而不是写死某一种相机。

---

## 1. TUWIN（com.tuwinsmart.tuwin）

### 1.1 技术栈
- **语言**：Kotlin（含协程 + Flow），少量 RxJava 遗留。
- **架构**：标准 Clean Architecture，分层清晰：
  - `core/`：network、device、media、transfer、util、internet、update、event、process
  - `data/`：source(remote/local) + repository
  - `domain/`：model + 用例
  - `presentation/`：ui（Activity/Fragment + DataBinding/ViewBinding）
- **网络**：OkHttp + Retrofit（`RoutedOkHttpProvider` / `RoutedRetrofitProvider`）。
- **媒体**：ijkplayer（`libijkffmpeg/libijkplayer/libijksdl`）+ 自研 `FFmpegTexturePlayerView`（OpenGL 纹理低延迟渲染）+ GSYVideoPlayer。
- **存储**：DataStore Preferences；图片：Glide。
- **原生库**：`libffmpeg.so`(15MB)、ijkplayer 全套、友盟 `libumeng-spy/libumonitor`、`libucrash`。

### 1.2 可扩展架构（重点，值得自研直接借鉴）
TUWIN 已经实现了一套「按机型插拔」的适配器体系：

- `DeviceAdapter`（接口）
  ```kotlin
  interface DeviceAdapter {
      val deviceType: DeviceType
      fun createSession(session: DeviceSessionSnapshot): DeviceAdapterSession
  }
  ```
- `DeviceAdapterRegistry`：`LinkedHashMap<DeviceType, DeviceAdapter>`，`register()` / `adapterFor(type)`，重复注册抛异常。新增机型 = 新增一个 Adapter 并注册。
- `DeviceCapabilities`：`Set<String> names` + `loadedAtRouteRevision`——**能力由相机动态上报**（字符串集合），App 按能力开关功能，而非按机型硬编码。
- `DeviceProtocolProfile`（每机型一份**安全白名单**）：
  - `expectedModels`（可接受型号）
  - `bootstrapEndpoints`（探测端点：protocol+port+path）
  - `allowedControlPorts` / `allowedMediaPorts` / `allowedPathPrefixes`
  - `dynamicMediaHostPolicy`（媒体 host 是否必须等于控制 host）
  - 方法：`acceptsModel()` / `acceptsProbeEndpoint()` / `acceptsDynamicMediaHost()`
  - 作用：连接前/中校验发现的端点是否在白名单内，**防止连到错误或恶意端点**。
- `DeviceSessionManager` + `RecoverableDeviceControlChannel`：会话生命周期、控制通道断线恢复、按路由版本失效重建。

> 这套「Adapter + Registry + Profile + Capabilities + SessionManager」正是自研 App 可扩展性的范本。

### 1.3 各机型协议族（来自 `DefaultDeviceProtocolProfileRegistry`）

| 机型 DeviceType | 型号标识 | 控制协议 | 控制端口/路径 | 探测端点 | 媒体 |
|---|---|---|---|---|---|
| **RIDE3PRO** | `R3Pro` | HTTP REST (Retrofit) | 80 `/api/` | `GET /api/device/status` | **RTSP :8080** `/?action=stream` |
| **RIDE6** | `R6` | HTTP REST | 80 `/api/` | `GET /api/device/status` | RTSP :8080 |
| **RIDE5** | 任意 | HTTP CGI（海思风格 hisnet） | 80 `/cgi-bin/hisnet/` | `GET /cgi-bin/hisnet/getdeviceattr.cgi` | RTSP `/livestream/1` |
| **M3** | `v57_sport_cam_ezgui` 等 | HTTP REST(`/app/`) **+ 原生 TCP Socket** | 80 `/app/` | `GET /app/getproductinfo` | RTSP（动态授权端点） |

`DeviceEndpointProtocol` 枚举 = **HTTP / RTSP / TCP**（三类传输）。

#### 1.3.1 Ride3Pro / Ride6 —— REST API（完整端点）
鉴权/设备：`GET /api/authdevice?seed={long}`、`GET /api/device/info`、`GET /api/device/status`、`GET /api/rtspstatus?seed={long}`、`GET /api/reboot`、`GET /api/vendor/send-time?year&month&day&hour&minute&second`
拍摄：`GET /api/capture`、`GET /api/record/start`、`GET /api/record/stop`、`GET /api/setmode?mode={int}`
设置（菜单驱动）：`GET /api/menu/xml`（返回 **XML 菜单定义**，由 `Ride3ProMenuXmlParser` 解析）、`GET /api/menu/getparameter?id=`、`GET /api/menu/setparameter?id=&value=`
存储/回放：`GET /api/sd/info`、`GET /api/system/formatsd`、`GET /api/playback/dayinfo?date=`、`/api/playback/filecount`、`/api/playback/filelist?mode=&file_index=`、`/api/playback/thumbnail?file_index=`（返回图片）、`/api/playback/delete?file_index=`、`/api/playback/start?file_index=`、`/pause?file_type=`、`/stop`、`/setspeed?`、`/settime?second=`
固件：`POST /api/firmware/upload?md5sum=&model=&hw=&sw=`（body）
工程细节：`Ride3ProHttpRequestQueue` + `Ride3ProHttpSerialDispatcher`（**串行队列**，相机不接受并发命令）、`Ride3ProRequestIdInterceptor`（请求 ID 注入）、`Ride3ProFormatTimeoutInterceptor`（格式化长超时）。

#### 1.3.2 M3 —— REST(`/app/`) + TCP Socket 双通道
HTTP（80，`/app/` 前缀，**泛化 param 协议**）：
`getproductinfo`、`getdeviceattr`、`getbatteryinfo`、`getcurmode`、`getfilelist`、`getmediainfo`、`getsdinfo`、`getrecduration`、`getgravitydirection`、`getparamitems?param=`、`getparamvalue?param=`、`setparamvalue?param=&value=`、`setting?param=`、`mode?param={int}`、`playback?param=`、`getthumbnail?file=`、`deletefile?file=`、`setsystime?date=`、`settimezone?`、`setwifi?wifissid=&wifipwd=`、`sdformat`、`reset`、`POST /upload/{savepath}/{filesize}`（固件）。
TCP Socket（`DefaultM3SocketConnector` + `DelimitedFrameDecoder`）：
- `connect(network: Network, host, port, frameDecoder)` → `socket.connect(InetSocketAddress(host,port))`，**绑定到指定 Android `Network`**（关键：WiFi 直连下强制走相机 AP 网卡）。
- `SessionSocket` 暴露 `messages: Flow<M3SocketMessage>` + `failures: Flow<Throwable>`——**相机实时事件推送通道**（状态/录制变化等）。
- 帧格式：**分隔符定界**（delimiter），单帧上限 64KB，缓冲上限 256KB。

#### 1.3.3 Ride5 —— 海思 hisnet CGI
路径前缀 `/cgi-bin/hisnet/`，探测 `getdeviceattr.cgi`，媒体 `rtsp://{host}/livestream/1`。属海思 IPC/DV SDK 的 CGI 风格。

### 1.4 WiFi 直连方式（现代 Android 正解）
`DeviceWifiNetworkRequestFactory.build()`：
```kotlin
val spec = WifiNetworkSpecifier.Builder()
    .setSsidPattern(PatternMatcher(ssidPattern, ...))   // 按机型 SSID 前缀匹配
    .setBssid(MacAddress.fromString(bssid))             // 可选锁定 BSSID
    .build()
val request = NetworkRequest.Builder()
    .addTransportType(TRANSPORT_WIFI)
    .removeCapability(NET_CAPABILITY_INTERNET)          // 相机 AP 无互联网，避免抢占蜂窝数据
    .setNetworkSpecifier(spec)
    .build()
```
- `DeviceNetworkController` → `connectivityManager.requestNetwork(request, callback)`（Android 10+ 弹系统连接框）。
- `ProcessBindingController` → `connectivityManager.bindProcessToNetwork(network)`（**整进程路由绑定到相机 WiFi**），断开时 `bindProcessToNetwork(null)`。
- `NetworkTopologyMonitor` 注册 WiFi+蜂窝 NetworkCallback 监控拓扑变化。
- `DeviceWifiScanner`（WifiManager 扫描）+ `DeviceWifiScanMapper`（按机型 SSID 规则映射候选）。
- 兼容旧版/扫描：引入 `thanosfisherman/WifiUtils`。
- **路由抽象**：`RouteProvider/RouteSnapshot/RouteLease/RouteId` + `RoutedOkHttpProvider`（OkHttp 的 SocketFactory 绑定到该 Network）+ `RoutedRetrofitProvider`。即「每条到相机的连接都绑定到正确的网卡路由」，这是 WiFi 直连 + 同时保蜂窝上网的核心工程。

### 1.5 实时图传（RTSP）
- 传输：RTSP，`RtspTransport` 枚举（AUTO/TCP/UDP）。
- URL：Ride3Pro/Ride6 = `rtsp://{host}:8080/?action=stream`；Ride5 = `rtsp://{host}/livestream/1`；M3 = 动态授权端点。
- **鉴权握手（seed）**：开流前
  1. `seed = Random.nextLong(Long.MAX_VALUE)`（随机长整型挑战值）
  2. `GET /api/authdevice?seed=` → `GET /api/rtspstatus?seed=`
  3. 成功后 `Ride3ProPreviewHandshakeCache.markReady(key)`，key = (deviceIdentity, sessionId, routeRevision)，避免重复鉴权。
  - seed 用于让相机 RTSP 服务端授权本次连接。
- 端点授权：`DeviceEndpointAuthority.issue(...)` 颁发 `EndpointGrant`（RTSP/8080/`/`/MEDIA/PROFILE_BOOTSTRAP），`AuthorizedRtspEndpoint` 校验后才允许连。
- 渲染：自研 `FFmpegTexturePlayerView`/`FFmpegPlayerView`（FFmpeg 解码 → OpenGL 纹理，低延迟）+ `GsyNativePlayerAdapter`(GSYVideoPlayer/ijkplayer) 作为备选；`MediaSessionController` + `startLivePreviewMediaSession` 管理播放会话。

### 1.6 文件传输
`StreamingTransferEngine`（core/transfer）：
- 基于 `RoutedOkHttpProvider`（绑定路由的 OkHttp）做 HTTP 下载/上传。
- `TransferRequest`/`TransferUploadRequest`/`TransferId`/`TransferState`(Queued/…) + `onStateChanged` 回调（Flow 化进度）。
- **断点续传**：`ResumePolicyRegistry` + `Ride3ProPlaybackDownloadResumePolicy` + `TransferCheckpoint`；处理 "unexpected end of stream"（重试/续传）。
- 队列：`DeviceTransferQueue`/`ScopedTransferQueue`/`InternetTransferQueue`（区分局域网/互联网来源）。
- 缩略图：`Ride3ProAviThumbnailCache` + Glide。

### 1.7 设置系统（菜单驱动）
- 相机通过 `GET /api/menu/xml` 下发**菜单 XML**（项/可选值/当前值），App 用 `Ride3ProMenuXmlParser` 解析后动态渲染设置页（`Ride3ProSettingsRuntimeMapper`、`Ride3ProSettingsItem`）。
- 读写：`getparameter?id=` / `setparameter?id=&value=`（id 为参数键，如 resolution/exposure/wb/fps/loop/hdr 等）。
- 好处：**新增/变更设置项无需改 App**，由相机固件下发——自研 App 应保留这种「设备自描述」思路。

### 1.8 权限（清单）
INTERNET、ACCESS/CHANGE_NETWORK_STATE、ACCESS/CHANGE_WIFI_STATE、ACCESS_FINE/COARSE_LOCATION、ACCESS_LOCATION_EXTRA_COMMANDS、**NEARBY_WIFI_DEVICES**(Android13+ 免定位扫描)、FOREGROUND_SERVICE + **FOREGROUND_SERVICE_REMOTE_MESSAGING**(常驻 socket)、POST_NOTIFICATIONS、REQUEST_INSTALL_PACKAGES(OTA)、READ_PHONE_STATE、旧版存储。
uses-feature：wifi、location、faketouch、portrait。**无蓝牙、无 USB、无相机权限**。

---

## 2. XTU GO（com.gku.xtugo）

### 2.1 技术栈与 SDK
- 基于厂商 SDK **`com.gku.actioncam`**（gku = 方案商），App 层（`ca.*`）重度混淆，SDK 层不混淆。
- 原生库揭示能力：`libijkplayer/libijkffmpeg/libijksdl`(图传/播放)、`libcontrol.so`(控制)、`libusb_transport.so`(**USB 有线**)、`libdepth_net_transport.so`、`libpanorama_vr.so`(16MB 全景拼接)、`libAMapSDK_MAP`(20MB 高德地图/GPS 打标)、`libgpuimage-library.so`(滤镜)、`libscannative.so`(扫描/二维码)、`libmmkv.so`(KV 存储)、`libEncryptorP.so`(加密)、`libBugly_Native/libapminsight`(崩溃/APM)、`libzeus*`。
- 网络：Apache HTTP(`org/apache/http`)、OkHttp、阿里云 OSS(`com/aliyun/oss`，云上传)。

### 2.2 多芯片平台架构（重点）
XTU GO 按**相机 SoC 芯片**分包，三套独立协议栈：

| 平台 | 包 | 文件数 | 传输 | 控制协议 | 预览 |
|---|---|---|---|---|---|
| **Ambarella** | `amba/{base,model,socket,ui}` | 57 | TCP Socket(`DataChannelWIFI`) | **JSON `msg_id`/`rval`** 命令（Gson），队列+超时重试 | RTSP |
| **Hisilicon** | `hisilicon/{dv,camplayer}` | 183 | HTTP | **CGI `/cgi-bin/hi3510/get|set*.cgi`**（`-param=value` 风格） | RTSP `:554 /livestream/12` |
| **SigmaStar** | `sigmastar/{Interface,data,wifi,bluetooth,…}` | 253 | Socket(`ClientThread`)+HTTP | 接口/回调模型(`ISSPreview/ISSPlayback/ISSetting`)，**蓝牙心跳** | RTSP |

#### 2.2.1 Ambarella（msg_id JSON 协议）
- `CmdResponseBean { int msg_id; int rval; }`——经典 Ambarella 协议（msg_id=命令号，rval=返回值，配合 `param`/`value`）。
- `AmbaCmdModel`（单例）`sendCmdQueue(CmdRequestBean, callback, listener)`：Gson 序列化 → `AmbaConnector` 发送 → 收 `CmdResponseBean`；`sendCmdQueueTimesIfTimeOut` 超时重发。
- `DataChannelWIFI`：`Socket` 连 (host, port)，`setIP(host,port)`。
- 设备信息 bean：name/serialnum/model/type/region/hardversion/softversion/pcbrevision/bluetooth*version/networkstatus/runtimes/startdate/timeout。
- 命令关键字：`param`、`status`、`wifi`、`sdstatus`、`filelist`、`fileinfolist`、`thumb_file`、`tv_b_status`、`amba_control_video_param`、`amba_control_photo_param`、`amba_setting_page_mode`、`amba_preview_save_date`。

#### 2.2.2 Hisilicon（hi3510 CGI）
- URL 模板：`http://{ip}{path}/{cmd}.cgi?{-param=value}`，IP 常见 `192.168.0.1`/`192.168.1.1`。
- 已提取命令（get/set 成对）：`getcamerastatus`/`setcamerastatus`、`getallinfo`、`getcurallinfo`、`getallworkmode`/`getcurworkmode`、`getdeviceattr`、`getfilecount`、`getfiletypecount`、`getfilelist?&-start=%d&-end=%d`、`getfilelistinfoios?&-start&-end`、`getfileinfo?&-name=%s`、`deletefile?&-name=%s`、`deleteallfiles`、`getaudioencode`、`getautoshutdown`、`getbatterycapacity`、`getbitrate`、`getbootaction`、`getburstinfo`、`getbuzzer`、`getcapability?&-workmode=%d&-type=%d`、`getdevcapabilities`、`getflip`、`getledstate`、`exitquickrec`、`getactivateinfo`…
- 子模块：`dv/{biz,net,wifi,player,live,filebrowser,setting,Event,devicemanage,updateapp(OTA),imagelookover,localimage,ui}`；`camplayer`(预览播放器)。

#### 2.2.3 SigmaStar
- `data/connect/`：`ClientThread`(Socket 客户端线程)、`FirmwareClientThread`(OTA 独立线程)、`DownLoadFileUtils`(文件下载)、`SSConnectDevice`(连接管理)。
- `Interface/`：`ISSPreview/ISSPreviewModel(+Callback)`、`ISSPlayback/ISSPlayback2/ISSPlaybackModel(+Callback)`、`ISSetting/ISSettingModel(+Callback)`、`ISBTHeartbeatModel(+Callback)`、`IStartView`——**接口+回调**抽象。
- `data/`：`SSResponseParse`(响应解析)、`SSLanguageParse`、`SSFileUtils`。
- `wifi/beforeQ/`：**区分 Android Q 前后**的 WiFi 连接实现（旧版 addNetwork，新版 Specifier）。
- `bluetooth/`：蓝牙（配网/唤醒/心跳）。

### 2.3 连接/配网方式（比 TUWIN 更丰富）
1. **WiFi 直连**：`WifiUtils`（hisilicon/sigmastar 各一份），`beforeQ` 兼容旧 Android。
2. **二维码配网**：`remote_live/{QRCodeUtil,QRContentBean,QRShowActivity,ScanWifiActivity}`——相机展示/扫描 QR 获取 WiFi SSID/密码（用 `CAMERA` 权限扫码）。
3. **蓝牙**：`sigmastar/bluetooth` + `ISBTHeartbeatModel`（BT 心跳/唤醒/配网），权限 BLUETOOTH_SCAN/CONNECT/ADVERTISE。
4. **USB 有线**：`libusb_transport.so`（USB 传输通道）。
5. **互联网远程**：`remote_live`（远程观看，可能经云服务器/阿里云 OSS）。

### 2.4 实时图传
- `rtsp://%s:554/livestream/12`（端口 **554**，路径 `/livestream/12`），ijkplayer 渲染。
- `DouyinStreamController`（**抖音直播**）、`StreamConfigActivity`（推流配置）。

### 2.5 特色功能（TUWIN 没有的）
- 抖音/社交直播推流；互联网远程实时观看。
- 全景/VR 拼接（`libpanorama_vr.so`）。
- 高德地图 GPS 轨迹打标（`libAMapSDK`，运动轨迹叠加）。
- GPUImage 实时滤镜、视频编辑（`sigmastar/videoedit`）。
- 阿里云 OSS 云存储上传。

### 2.6 权限（清单，远多于 TUWIN）
网络/WiFi 全套 + 定位；**蓝牙全套**(BLUETOOTH/ADMIN/CONNECT/SCAN/ADVERTISE)；**CAMERA**(扫码)+RECORD_AUDIO；媒体全套(READ_MEDIA_IMAGES/VIDEO/AUDIO、MANAGE_MEDIA、ACCESS_MEDIA_LOCATION、WRITE_MEDIA_STORAGE)；WAKE_LOCK、FOREGROUND_SERVICE、SYSTEM_ALERT_WINDOW、WRITE_SETTINGS、FLASHLIGHT、VIBRATE、CALL_PHONE、GET_ACCOUNTS、READ_LOGS、GET_TASKS。
uses-feature：camera(+autofocus)、bluetooth、location、microphone、landscape+portrait。

---

## 3. 横向对比与对自研 App 的启示

### 3.1 协议多样性（最大挑战）
仅这两个品牌就出现 **6+ 种协议形态**：
- HTTP REST（TUWIN `/api`、`/app`）
- HTTP CGI（TUWIN `/cgi-bin/hisnet`、XTU `/cgi-bin/hi3510`）
- JSON-over-TCP（XTU Ambarella `msg_id`、TUWIN M3 socket 事件）
- 定界帧二进制 TCP（TUWIN M3）
- Socket 客户端线程（XTU SigmaStar）
- RTSP（全部，但端口/路径各异：8080 `/?action=stream`、554 `/livestream/12`、`/livestream/1`）

→ **自研 App 必须把「协议」做成插件**，传输层（HTTP/TCP/RTSP）与命令层（命令集/编解码）分离，按设备身份（SSID 前缀/型号/探测响应）路由到对应实现。

### 3.2 连接工程（平台强相关）
- Android：`WifiNetworkSpecifier + requestNetwork + bindProcessToNetwork + Network.bindSocket`，并 `removeCapability(INTERNET)` 保蜂窝上网。这是**必须用 expect/actual 下沉到平台**的部分。
- 配网入口多样：WiFi 扫描/手动、QR、蓝牙。自研至少先做 WiFi（扫描+手动），QR/BT 作为可选扩展。

### 3.3 图传（平台强相关）
- 全部用 RTSP，但 Compose Multiplatform **没有内置视频/RTSP 播放器**。需 expect/actual：Android 用 Media3/ExoPlayer 或 ijkplayer，iOS 用 AVPlayer；或统一走 FFmpeg（Android JNI / iOS cinterop）解码 + 平台 Surface 渲染。低延迟需调（TCP 传输、缓冲、丢帧策略）。

### 3.4 值得直接借鉴的设计
- TUWIN 的 **Adapter + Registry + ProtocolProfile(安全白名单) + Capabilities(设备自描述) + SessionManager(断线恢复)**。
- TUWIN 的 **路由级网络绑定** 与 **断点续传传输引擎**。
- 菜单/参数 **设备自描述**（XML/param），减少 App 硬编码。
- XTU 的 **按芯片平台分包** 与 **接口+回调** 抽象、QR/BT 多入口配网。

### 3.5 自研应避免的「卡顿」根因（官方 App 痛点）
- 命令**串行队列**+超时重试若设计不当会放大延迟 → 自研需做命令优先级、并发窗口、乐观 UI。
- 重型 SDK（高德 20MB、全景 16MB、友盟/Bugly）拖慢启动 → 自研保持精简、按需加载。
- 预览渲染链路长（FFmpeg→OpenGL）→ 自研优先平台原生播放器 + 合理缓冲。
- 大量 Activity/Fragment 跳转 → 自研用 Compose 单 Activity + 声明式导航，状态驱动。

---

## 4. 待补全的协议细节（自研 Phase 1 需进一步逆向/抓包）
1. Ride3Pro `seed` 与相机端校验关系（authdevice/rtspstatus 返回体字段）。
2. M3 TCP 帧的**分隔符字节**与 `M3SocketMessage` 字段结构。
3. Ambarella `msg_id` 命令号对照表（各命令对应的整数 ID）与 `CmdRequestBean` 完整字段。
4. Hisilicon `set*.cgi` 全量参数与取值范围（`getcapability`/`getdevcapabilities` 可枚举）。
5. SigmaStar `ClientThread` 报文格式（是否 JSON/二进制、端口、心跳）。
6. 各机型 **SSID 命名规则**（用于扫描匹配与设备识别）。
7. 文件下载 URL 构造（回放 filelist 返回项 → 实际下载/缩略图 URL）。

> 建议方式：静态逆向（jadx 已就绪）+ 真机抓包（Wireshark/mitmproxy 对相机 AP）+ 对照官方 App 行为。所有结论用于**互操作（interoperability）目的下的干净室重实现**，不复制其代码。
