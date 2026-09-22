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
| 统计/崩溃 | 友盟 Umeng + ucrash | Bugly（在用）+ APM Insight + 火山 zeus；**全树无友盟 SDK**，只剩一处读自己清单里 `UMENG_CHANNEL` 渠道号的残留 |
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
| **M3** | `v57_sport_cam_ezgui` 等 | HTTP REST(`/app/`) **+ 原生 TCP Socket（只读事件通道）** | 80 `/app/` | `GET /app/getproductinfo` | RTSP（动态授权端点） |

`DeviceEndpointProtocol` 枚举 = **HTTP / RTSP / TCP**（三类传输）。

#### 1.3.1 Ride3Pro / Ride6 —— REST API（完整端点）
鉴权/设备：`GET /api/authdevice?seed={long}`、`GET /api/device/info`、`GET /api/device/status`、`GET /api/rtspstatus?seed={long}`（**只声明、无任何业务调用点**，不计入鉴权链）、`GET /api/reboot`、`GET /api/vendor/send-time?year&month&day&hour&minute&second`
拍摄：`GET /api/capture`（**声明但无调用点**，官方 Ride3Pro/Ride6 的「拍照」是播放器截 RTSP 帧）、`GET /api/record/start`、`GET /api/record/stop`、`GET /api/setmode?mode={int}`
设置（菜单驱动）：`GET /api/menu/xml`（返回 **XML 菜单定义**，由 `Ride3ProMenuXmlParser` 解析）、`GET /api/menu/getparameter?id=`、`GET /api/menu/setparameter?id=&value=`
存储/回放：`GET /api/sd/info`、`GET /api/system/formatsd`、`GET /api/playback/dayinfo?date=`、`/api/playback/filecount`、`/api/playback/filelist?mode=&file_index=`、`/api/playback/thumbnail?file_index=`（返回图片）、`/api/playback/delete?file_index=`、`/api/playback/start?file_index=`、`/pause?file_type=`、`/stop`、`/setspeed?`、`/settime?second=`
固件：`POST /api/firmware/upload?md5sum=&model=&hw=&sw=`（body）
工程细节：**串行是官方 App 单方面的自设，不是设备契约**——三层串成 1 并发：L1 `Ride3ProRequestScheduler`（优先级队列 + 单 worker，主路径）→ L2 `Ride3ProHttpRequestQueue`（Mutex，无会话 executor 时兜底）→ L3 `Ride3ProHttpSerialDispatcher`（`maxRequests=1`，**只被 Glide 两个调用点用**，设备 Retrofit client 根本没设 dispatcher）；同时 `retryOnConnectionFailure(false)`。APK 内**没有**任何「设备返回并发错误」的证据，故「相机不接受并发命令」静态不可证。`Ride3ProRequestIdInterceptor` 无条件给每个请求加头 `X-Request-Id`，值 = 进程级 `AtomicLong(0).incrementAndGet()`（那个「只对 thumbnail/rawdata 附加」的策略类零调用）。`Ride3ProFormatTimeoutInterceptor` 只对 `/api/system/formatsd` 把超时抬到 **60 s × connect/read/write**（基线 `DEVICE_CONTROL` 是 5/15/15 s）。

#### 1.3.2 M3 —— REST(`/app/`) + TCP Socket 双通道
HTTP（80，`/app/` 前缀，**泛化 param 协议**）：
`getproductinfo`、`getdeviceattr`、`getbatteryinfo`、`getcurmode`、`getfilelist`、`getmediainfo`、`getsdinfo`、`getrecduration`、`getgravitydirection`、`getparamitems?param=`、`getparamvalue?param=`、`setparamvalue?param=&value=`、`setting?param=`、`mode?param={int}`、`playback?param=`、`getthumbnail?file=`、`deletefile?file=`、`setsystime?date=`、`settimezone?`、`setwifi?wifissid=&wifipwd=`、`sdformat`、`reset`、`POST /upload/{savepath}/{filesize}`（固件）。
TCP Socket（`DefaultM3SocketConnector` + **`LegacyReadChunkFrameDecoder`**，工厂 `M3FrameDecoderKt.createDefaultM3FrameDecoder()`；`DelimitedFrameDecoder`/`UnconfiguredFrameDecoder` 均为**死代码**，零构造点）：
- `connect(network: Network, host, port, frameDecoder)` → `socket.connect(InetSocketAddress(host,port), 15000)`，**绑定到指定 Android `Network`**（关键：WiFi 直连下强制走相机 AP 网卡）。连接超时默认 **15000 ms**、单次读缓冲 `maxReadBytes` 默认 **4096 B**；`connect` 跑在 `Dispatchers.IO`，协程取消时在 `invokeOnCancellation` 里 `socket.close()`。
- `SessionSocket` 暴露 `messages: Flow<M3SocketMessage>` + `failures: Flow<Throwable>`——**相机实时事件推送通道**（状态/录制变化等）。`messages` 是 `MutableSharedFlow(replay=0, extraBufferCapacity=64)` → **无订阅者即丢，不回放**；`failures` 是 `replay=1, extraBufferCapacity=1` → 新订阅者能收到最后一个异常。
- **帧 = 一次 `read()` 拿到的字节块**：非空 chunk 整段就是一帧（`reset()` 是空实现），**没有分隔符、没有长度前缀**。「单帧上限 64KB、缓冲上限 256KB」是死代码 `DelimitedFrameDecoder` 的默认参数（65536/262144），运行时不生效。副作用：跨 read 的长 JSON 会被切成两帧，第二帧进 `Unknown`。
- **单向只读**：`M3SessionSocket` 接口只有 `getFailures`/`getMessages`/`isOpen`/`close`，全 `core/device/` 与 `data/source/socket/` 目录 `getOutputStream` 零命中；socket 连不上时只把 `M3_SOCKET_EVENTS` 从能力集里去掉，**不阻断会话**。

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
- **预览准备序列（实测顺序，与 UI 步骤名一致）**：
  1. `seed = Random.nextLong(Long.MAX_VALUE)`（端侧随机数；**不参与任何计算、不校验回显，因此不构成挑战-应答**）
  2. `GET /api/authdevice?seed=`——`result` 非 0 **且非 -2** 才算失败
  3. `GET /api/vendor/send-time?…`——失败**只告警**（`Ride3Pro：同步时间失败`），照样往下走
  4. `Ride3ProPreviewHandshakeCache.markReady(key)`，key = (deviceIdentity, sessionId, routeRevision)
  5. `GET /api/setmode?mode=0`——失败硬抛；随后起播
  - **`/api/rtspstatus` 不在这条链上**（声明了但没人调）。UI 可用的步骤串只有三个：设备认证 / 同步设备时间 / 切换预览模式。
  - 握手缓存 `consume()` 是**只读探测（peek）**：同一 key 在 **10 分钟**（`VALIDITY_DURATION_MS = 600000`，单调时钟 `System.nanoTime()/1e6`）内可反复命中，预览与回放各自复用同一次握手；**只有过期时才删除**。把它实现成「一次性」会让每次起流多打一次 auth + send-time。
  - ⚠️ 「seed 用于让相机 RTSP 服务端授权本次连接」属**推断**：客户端没有任何把 seed 交给 RTSP/播放器的通路，RTSP URL 里也不含 seed，auth 响应的 `info` 被声明成 `Any?` 且不解析（调用点只读 `result`）。
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
- 相机通过 `GET /api/menu/xml` 下发**菜单 XML**（项 / 可选值 / **默认值 `<Default>`**），App 用 `Ride3ProMenuXmlParser` 解析后动态渲染设置页（`Ride3ProSettingsRuntimeMapper`、`Ride3ProSettingsItem`）。解析器只读 6 个名字：`Category/Name`、`Setting/{Name,ID,Type,Default}`、`Value/{Name,ID}`——**没有「当前值」这一项**；当前值是随后用 `getparameter?id=all` + 对 `Type ∈ {1,4}` 的项逐条补读得到的。
- ⚠️ 会话路径上官方**不走 HTTP**：有会话 executor 时 `Ride3ProSessionApiService.getMenuXml` 被改写成裸 socket（`Ride3ProSessionTransport.getMenuXmlRaw`/`readMenuXmlRaw`，四个 `MENU_*` 常量 5000 / 524288 / 8192 / 30000 均已 `@Deprecated`）；HTTP `/api/menu/xml` 只是接口声明与兜底路径。
- 读写：`getparameter?id=` / `setparameter?id=&value=`。**id 不是任意参数键**：取值域是一张封闭硬编码表，`forSetting(分区名, 项名)` 归一化后查表，只有 9 个线上串——`all`、`factory_reset`、`record_exposure`、`record_loop_recording`、`record_resolution`、`system_frequency`、`system_version`、`wifi_name`、`wifi_passwd`。表命中不了就不发 `setparameter`（抛 `IllegalStateException`）。`resolution`/`exposure` 是归一化后的菜单名、不是发出去的 id；`wb`/`fps`/`hdr` 在表里**根本不存在**。XML 的 `<ID>`（如 `0x0000208`、`0x0000301`）只做值回填与兼容性判等的键，不作为 `?id=` 发出。
- 好处：**新增/变更设置项无需改 App**，由相机固件下发——自研 App 应保留这种「设备自描述」思路。⚠️ 但官方 App 自己也没真正做到：静态兜底菜单里的 31 项只有 9 项能上线，白平衡/连拍/锐度/ISO/防抖/屏保/语言/按键音/清除缓存等**既读不到也写不了**。

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
| **Hisilicon** | `hisilicon/{dv,camplayer}` | 183 | HTTP | **CGI `/cgi-bin/hi3510/get\|set*.cgi`**（`-param=value` 风格） | RTSP `:554 /livestream/12` |
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
- 不止一条 URL。老海思/`DV` 侧有**两种等价起流**（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:319-329` RTSP、`:331-342` HTTP）：
  - `rtsp://{ip}:554/livestream/12`（小码流）或 `/11`（大码流）
  - `http://{ip}:80/12?trans=tcp&action=play&media=video_data`（同样按码流在 `11`/`12` 间切）
  - 切 `11` 还是 `12` 由 `DV.isPreviewBigBitRate()`（`DV.java:119`，读 `prefer.previewVideo`，默认 `"Small"` → `12`）决定；SigmaStar 与 Ambarella 的代码路径**永远只有 `/12`**（`SSCommandUtil.java:50`、`HaisiCommandUtil.java:50`、`AmbaPreviewActivity.java:972` 都是字面量）。
- ijkplayer 渲染，但**在用**的视图是 `com/gku/actioncam/widget/VideoTextureView.java:619-646`（20 条无条件 `setOption` + 按 `isAmba` 二选一各 2 条：非 AMBA → `rtsp_transport=tcp` + `framedrop=5`；AMBA → `udp` + `framedrop=100`）。`sigmastar/widget/SSVideoView.java` 的那 15 个 `setOption` 调用点只挂在 `activity_s_s_video_remote_play.xml` 上、无 Activity 使用，**属死代码**，别照抄它的 `rtsp_flags=prefer_tcp`。
- `DouyinStreamController`（**抖音直播**）、`StreamConfigActivity`（推流配置）。

### 2.5 特色功能（TUWIN 没有的）
- 抖音/社交直播推流；互联网远程实时观看。
- 全景/VR 拼接（`libpanorama_vr.so`）。
- 高德地图 GPS 轨迹打标（`libAMapSDK`，运动轨迹叠加）。
- GPUImage 实时滤镜、视频编辑（`sigmastar/videoedit`）。
- 阿里云 OSS 云存储上传。

### 2.6 权限（清单，远多于 TUWIN）
共 **38 条** `uses-permission`。网络/WiFi 全套 + 定位；**蓝牙全套**(BLUETOOTH/ADMIN/CONNECT/SCAN/ADVERTISE)；**CAMERA**(扫码)+RECORD_AUDIO；媒体全套(READ_MEDIA_IMAGES/VIDEO/AUDIO、MANAGE_MEDIA、ACCESS_MEDIA_LOCATION、WRITE_MEDIA_STORAGE)；WAKE_LOCK、FOREGROUND_SERVICE、SYSTEM_ALERT_WINDOW、WRITE_SETTINGS、FLASHLIGHT、VIBRATE、CALL_PHONE、GET_ACCOUNTS、READ_LOGS、GET_TASKS。

⚠️ **其中 12 条我们不要照着申请**，分三类（按「有无厂商消费者」和「有无功能」两轴判）：

| 类别 | 权限 | 依据 |
|---|---|---|
| 真·死声明（全树 0 引用） | `READ_PRIVILEGED_PHONE_STATE`、`WRITE_MEDIA_STORAGE`、`CHANGE_CONFIGURATION`、`SYSTEM_ALERT_WINDOW`、`FLASHLIGHT`、`GET_ACCOUNTS` | 权限串在全树 grep 均 0 命中；`GET_ACCOUNTS` 只有库侧 `AccountManager`（`com/apm/applog/AppLog.java` 等），厂商代码 0 处 |
| 申请了但无对应功能 | `CALL_PHONE`、`BLUETOOTH_ADVERTISE`、`BLUETOOTH_ADMIN`、`MANAGE_MEDIA` | 前三者只出现在运行时申请数组里；`MANAGE_MEDIA` 有 4 处 `Intent("android.settings.REQUEST_MANAGE_MEDIA")` 入口（`HomeActivity.java:1049`、`dv/ui/WelcomeActivity.java:195`、`MyBottomSheetDialog.java:312`、`PermissionUtils.java:118`）但包内无 MediaStore 管理动作 |
| 只被第三方库检查 | `ACCESS_MEDIA_LOCATION`、`GET_TASKS` | 前者仅 Glide `QMediaStoreUriLoader.java:159` 的 `checkSelfPermission`；后者仅 `com/apm/insight/l/a.java:207`、`com/volcengine/zeus/download/h.java:59` 调 `getRunningTasks(1)` |

反例（曾被误判为死声明，**确有厂商消费者**，不要一起删）：`MODIFY_AUDIO_SETTINGS` → `SSMediaController.java:124`、`widget/MediaController.java:123` 的 `AudioManager.setStreamMute`；`READ_LOGS` → `dv/LogService.java:152`、`base/utils/LogSwitchUtils.java:31-32` 起 `logcat` 子进程（但该权限 Android 4.1+ 读自身日志并不需要，普通 App 申请系统也不给 → 对我们仍是「不要申请」）。
另有 **4 处独立运行时申请点**、彼此权限集不完全相同：`dv/ui/PermissionActivity.java:31-33`、`dv/ui/WelcomeActivity.java:53-55`、`dv/ui/weight/MyBottomSheetDialog.java:67-86`、`sigmastar/newUi/deviceAdd/base/BasePermissionActivity.java:18`；其中 `CALL_PHONE` 只在第一处出现。
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
- 重型 SDK（高德 20MB、全景 16MB、Bugly/APM Insight/zeus）拖慢启动 → 自研保持精简、按需加载。
- 预览渲染链路长（FFmpeg→OpenGL）→ 自研优先平台原生播放器 + 合理缓冲。
- 大量 Activity/Fragment 跳转 → 自研用 Compose 单 Activity + 声明式导航，状态驱动。

---

## 4. 待补全的协议细节（自研 Phase 1 需进一步逆向/抓包）
> 本节初稿写于 2026-09-20。2026-09-22 的穷尽式复现档案（`docs/08-官方APK全量逆向档案/`）已把其中 5 条关闭，逐条标注如下。
1. ~~Ride3Pro `seed` 与相机端校验关系~~ → **已关闭为「静态无解且无需再解」**：auth 响应只被读 `result`，`info` 声明成 `Any?` 且不解析，RTSP URL 不含 seed；`/api/rtspstatus` 根本没有调用点，不再属于鉴权链。
2. ~~M3 TCP 帧的**分隔符字节**与 `M3SocketMessage` 字段结构~~ → **问题本身不成立**：官方**没有分隔符**，活路径 `LegacyReadChunkFrameDecoder` 是「一次 read 即一帧」（读缓冲 4096 B）。7 个 `msgid` 与两个边界（空帧丢弃、坏帧归 `Unknown`）已全量抄出。剩下待真机验的是「跨 read 的长 JSON 被切成两帧」的实际发生率。
3. Ambarella `msg_id` 命令号对照表与 `CmdRequestBean` 完整字段 → 已由 `docs/08` 的 Ambarella 报文全表覆盖（本文件 §2.2.1 的字段清单仍是旧版，以 08 为准）。
4. Hisilicon `set*.cgi` 全量参数与取值范围 → 已由 `docs/08` 的海思 CGI 全表覆盖。
5. SigmaStar `ClientThread` 报文格式（是否 JSON/二进制、端口、心跳） → 已关闭：8080 二进制帧，上行 72 B（无 MD5）/200 B（带 MD5，推固件）小端定长头 + 64 B 路径槽，下行 72 B 头 + 裸文件流；语言表响应例外地按文本行读。
6. 各机型 **SSID 命名规则** → TUWIN 侧已有 6 条锚定正则 + 4 条 `PatternMatcher`；XTU 侧结论是**不存在 SSID 正则**，只有 `contains("XTU")` 子串判定，BLE 名才用 `toUpperCase().startsWith("XTU_")`——两套规则。
7. 文件下载 URL 构造（回放 filelist 返回项 → 实际下载/缩略图 URL）→ 已关闭，见 `docs/03 §2` 的缩略图三取法（SigmaStar `http://<ip>/thumb<path>`、海思 `http://<ip>/<去扩展名>.THM`、Ambarella msg 1025 + 8787）。

> 建议方式：静态逆向（jadx 已就绪）+ 真机抓包（Wireshark/mitmproxy 对相机 AP）+ 对照官方 App 行为。所有结论用于**互操作（interoperability）目的下的干净室重实现**，不复制其代码。

---

## 变更记录（2026-09-22 全量复现档案回写）

| 处 | 改了什么 | 依据（`docs/08-官方APK全量逆向档案/`） |
|---|---|---|
| §0 统计/崩溃行 | XTU GO 的「Umeng」删掉：全树无友盟 SDK，只剩一处读自己清单的 `UMENG_CHANNEL`；崩溃上报是 Bugly | `02-XTUGO-档案.md §11`「友盟 SDK」行 + `02-XTUGO-档案.md 附录E（权限·组件·域名） §8 C-08` |
| §1.3 表格 M3 行 | 「原生 TCP Socket」补「只读事件通道」 | `01-TUWIN-档案.md 附录一（协议面） §8.2 D-8` |
| §1.3.1 端点表 | `rtspstatus` 标为「只声明无调用点」，不计入鉴权链；`capture` 同标（官方拍照是播放器截 RTSP 帧） | `§8.1 C-1`、`§8.2 D-3`；`01-TUWIN-档案.md 附录二（设置与操作） §6` 末段 |
| §1.3.1 工程细节 | 「相机不接受并发命令」降级为客户端自设；补三层串行的真实分工、`X-Request-Id` 无条件注入、format 超时 60 s × 3 与基线 5/15/15 | `§8.1 C-7`、`§8.2 D-4`、`§8.2 D-5` |
| §1.3.2 整节 | 解码器类名改 `LegacyReadChunkFrameDecoder`；帧格式改为「一次 read 即一帧、无分隔符无长度前缀、读缓冲 4096 B」，64KB/256KB 标为死代码；补 15 s 连接超时、两个 Flow 的 replay 语义、socket 单向只读且连不上不阻断会话 | `§8.2 D-1/D-2/D-6/D-7/D-8`、`§8.1 C-12` |
| §1.5 预览鉴权段 | 序列改写为 authdevice → send-time（失败仅告警）→ markReady → setmode；删 rtspstatus；`consume()` 从「一次性」改为「10 分钟内只读探测」；「seed 授权 RTSP」降级为推断 | `§8.1 C-2/C-3`、`§8.3 E-1/E-2` |
| §1.7 设置系统 | 菜单 XML「当前值」改「默认值」并补当前值的真实来源；补「有会话时菜单走裸 socket」；`id` 取值域收窄为封闭 9 串，`wb`/`fps`/`hdr` 明确不存在 | `§8.3 E-3/E-4/E-5` |
| §2.4 实时图传 | 从单一 RTSP URL 改为「RTSP + HTTP 两条 + `11`/`12` 码流开关 + SigmaStar/Ambarella 恒 `/12`」；播放器改为在用的 `VideoTextureView`，`SSVideoView` 标死代码 | `02-XTUGO-档案.md §11` 预览行、`02-XTUGO-档案.md 附录C（SigmaStar 与播放层） §C.9` #1/#6/#7 |
| §2.6 权限 | 38 条里 12 条「不可照抄」按两轴重列（6 真死声明 + 4 申请无功能 + 2 只被库检查）；`MODIFY_AUDIO_SETTINGS`/`READ_LOGS` 反例改判；补 4 处申请点彼此不同、`CALL_PHONE` 只在一处 | `02-XTUGO-档案.md §11` 权限行、`02-XTUGO-档案.md 附录E（权限·组件·域名） §8 C-01/C-02/C-10` |
| §3.5 / §4 | 「友盟」从 XTU 重型 SDK 里去掉；§4 七条待补全逐项标注已关闭/仍开放，其中第 2 条的问题前提（存在分隔符字节）不成立 | 同上，加 `02-XTUGO-档案.md 附录C（SigmaStar 与播放层） §C.3` |
