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

6 条正则全部定义在 `tuwin/core/util/ConnectUtil.java:33-38`，判定函数 `inferDeviceTypeFromSsid(String)` 在 `ConnectUtil.java:128-147`。
先对入参做 `normalizeSsid()`（trim + 去成对双引号 + 空串归 null，`ConnectUtil.java:212-219`），**归一化后**才送进正则；归一化返回 null 直接判为无法识别（`:130-132`）。

匹配顺序（源码自上而下，第一个命中即返回，后面的正则不再执行）：

| 优先级 | 常量名 | 正则（原样） | 命中后返回 | 源码位置 |
|---|---|---|---|---|
| 1 | `M3_SSID_REGEX` | `^TUWIN[-_]M3_[A-Za-z0-9]+$` | `DeviceType.M3` | `ConnectUtil.java:33`、判定 `:134` |
| 2 | `RIDE3PRO_SSID_REGEX` | `^TUWIN_R3P_[A-Za-z0-9]+$` | `DeviceType.RIDE3PRO` | `ConnectUtil.java:37`、判定 `:137` |
| 3 | `RIDE6_SSID_REGEX` | `^TUWIN_R6_[A-Za-z0-9]+$` | `DeviceType.RIDE6` | `ConnectUtil.java:38`、判定 `:140` |
| 4 | `RIDE5_PRO_SSID_REGEX` | `^TUWIN_R5P_[A-Za-z0-9]+$` | `DeviceType.RIDE5` | `ConnectUtil.java:35`、判定 `:143` |
| 5 | `RIDE5_SSID_REGEX` | `^TUWIN_R5_[A-Za-z0-9]+$` | `DeviceType.RIDE5` | `ConnectUtil.java:34`、判定 `:143` |
| 6 | `RIDE5_COMMON_SSID_REGEX` | `^TUWIN_[A-Za-z0-9]{6,}$` | `DeviceType.RIDE5` | `ConnectUtil.java:36`、判定 `:143` |

顺序即优先级的两个关键点：

1. **M3 的正则排在第一位且是唯一允许 `-` 或 `_` 分隔符的**（`TUWIN-M3_xxx` 与 `TUWIN_M3_xxx` 都收）。因为它在最前面，所以形如 `TUWIN_M3_ABC123` 的名字永远不可能落到第 6 条的兜底正则上。
2. **第 6 条 `^TUWIN_[A-Za-z0-9]{6,}$` 是 RIDE5 的兜底「万能桶」**：任何 `TUWIN_` 开头、后缀为 ≥6 位字母数字的名字都会被判成 RIDE5。这意味着一台命名异常的 RIDE3Pro（例如 `TUWIN_ABCDEF12`）会被误识别为 RIDE5。因此优先级 2/3/4/5 必须先跑完。第 4 条 `TUWIN_R5P_` 必须在第 5 条 `TUWIN_R5_` 之前——注意 `^TUWIN_R5_[A-Za-z0-9]+$` 无法匹配 `TUWIN_R5P_XXX`（`_` 与 `P` 位置不同），所以这里的顺序实际不产生错误，但 RIDE5 三个正则是**短路 or**（`RIDE5_PRO || RIDE5 || RIDE5_COMMON`，`ConnectUtil.java:143`），三者命中同一个返回值 `DeviceType.RIDE5`。
3. 四条都不命中 → 返回 `null`（`ConnectUtil.java:146`），调用方走「非 TUWIN 网络」分支。

派生判定：
- `isExpectedDeviceWifiSsid(current, expectedType, expectedSsid)`（`ConnectUtil.java:156-167`）：先要求 `inferDeviceTypeFromSsid(current) == expectedType`，不等直接 false；再要求若给了 `expectedSsid` 则必须逐字符相等（区分大小写，`Intrinsics.areEqual`）。
- `isExpectedDeviceWifi(...)`（`ConnectUtil.java:169-176`）：**若 `expectedBssid` 非空，则只比 BSSID，完全跳过 SSID 正则链**；BSSID 归一化把 `-` 换成 `:`、转小写、并把 Android 伪装 MAC `02:00:00:00:00:00` 归 null（`ConnectUtil.java:221-233`）。
- `resolveDeviceType(cachedSsid, allowRuntimeSsidRead)`（`ConnectUtil.java:185-194`）：先用缓存 SSID，未命中且允许运行时读取时才去查系统当前 SSID。
- `isConnectedTUWIN()`（`ConnectUtil.java:113-126`）**不用正则**：先要求隐私协议已同意（`PreferenceHelper.isAgreePrivacy()`），再只看 `currentSSID.startsWith("TUWIN")` 或当前 SSID 在缓存列表 `getCacheSSID()` 里。这是一条与正则链不一致的宽松判据。

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
- `DynamicEndpointHostPolicy`：只有 `SAME_AS_CONTROL_HOST` 一个值（`tuwin/core/network/DynamicEndpointHostPolicy.java:11-13`）——意味着该字段目前是「形参化的单选项」，没有第二条策略可言；`acceptsDynamicMediaHost` 的 `when` 若取到其它值直接抛 `NoWhenBranchMatchedException`（`DeviceProtocolProfile.java:212-215`）。

`DeviceProbeEndpoint` 的 4 参构造器 `(protocol, port, path, purpose)`，`purpose` 默认 `EndpointPurpose.PROBE`（合成构造器 `i2 & 8` 分支，`tuwin/core/network/DeviceProbeEndpoint.java:102-104`）。注册表里 4 条端点全部用 `null, 8, null` 走这个默认，所以 purpose 全是 `PROBE`。

`profileFor(deviceType)` 未命中时抛 `IllegalStateException("No device protocol profile for " + deviceType)`（`DefaultDeviceProtocolProfileRegistry.java:38-45`）——注意 map 里已覆盖全部 4 个枚举值，所以这条异常路径实际不可达。

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
证据：`DefaultDeviceProtocolProfileRegistry.java:34` 的 RIDE5 条目传 `SetsKt.emptySet()`；`DeviceProtocolProfile.java:206` 空集分支 `return true`；`tuwin/core/device/ride5/Ride5IdentityPolicy.java:47` 用正则 `[0-9A-F]{12}` 校验并排除 `020000000000` / `000000000000` / `FFFFFFFFFFFF` 三个广播/伪装地址。

#### `acceptsProbeEndpoint(endpoint)` —— 2 个调用点

| 调用点 | 上下文 | 拒绝时走的分支 | 用户可见 |
|---|---|---|---|
| `tuwin/core/network/DeviceProbePlan.java:67`（`accepts()` 薄封装，被 `DeviceIdentityVerifier.java:153` 调） | 身份比对通过后，再要求探测结果里的 endpoint 本身是 profile 声明过的 bootstrap 端点 | `DeviceIdentityVerifier.java:154` `routes.reject$default(...)` → `:155` 抛 `DeviceProbeRejectedException("Probe endpoint is not declared by the <type> profile")` | 连接失败并提示探测被拒；日志/诊断里是该英文串 |
| `tuwin/core/network/DeviceEndpointAuthority.java:106`（`issueVerifiedControlGrant`） | 把探测证据换成 CONTROL 授权前，要求该 endpoint 是「已声明的 probe 端点」 | `:103` 若 `endpoint.protocol != HTTP` 先抛 `IllegalArgumentException("Device control endpoint must use HTTP")`；`:106-108` 不接受则抛 `IllegalArgumentException("Control endpoint is not backed by a declared probe endpoint")`；`:110-112` 若 host 与所选 probe host 归一化后不等则抛 `EndpointNotAuthorizedException("Verified endpoint does not match the selected probe host")`；只有全通过才 `:113` `issue(...)` 出 `EndpointPurpose.CONTROL` + `EndpointGrantSource.DEVICE_PROBE_RESPONSE` 的 grant，端口集取 `profile.allowedControlPorts`、路径前缀集取 `profile.allowedPathPrefixes` | 后续所有设备 HTTP 请求都要经 `authorizeUrl`（`DeviceEndpointAuthority.java:116+`）拿 grant 校验，拿不到 grant 就抛 `EndpointNotAuthorizedException`，表现为「设备无响应/连接失败」 |

另外 `DeviceProbePlan` 自身的构造器就会拒绝「没有 bootstrapEndpoints 的 profile」：`tuwin/core/network/DeviceProbePlan.java:52-54` 若 `bootstrapEndpoints.isEmpty()` 抛 `IllegalArgumentException("Device profile must declare at least one probe endpoint")`。因为 4 个 profile 各声明 1 条，这条不可达。

#### `acceptsDynamicMediaHost(controlHost, candidateHost)` —— **零调用点，死代码**

结论：该方法在整份反编译源码里**没有任何调用方**。
证据（穷举检索）：`grep -rn "acceptsDynamicMediaHost" _work/tuwin_src/sources/com/tuwinsmart` 只命中两处，均为声明本身——`DeviceProtocolProfile.java:18`（Kotlin `@Metadata` 里的方法名编码）与 `DeviceProtocolProfile.java:209`（方法定义）。无任何 `.acceptsDynamicMediaHost(` 形式的调用。
含义：`dynamicMediaHostPolicy` 字段与 `DynamicEndpointHostPolicy` 枚举目前是**预留但未接线**的抽象；实际「媒体 host 必须等于控制 host」的约束由别处实现——Ride3Pro 走 `EndpointGrant` 的 host 派生（`Ride3ProDeviceAdapterSession.java:382/506/656` 用 `endpointGrant3.getHost()` 作为 RTSP host），M3 走 `M3DynamicEndpointPolicy.parse()` 里直接 `new M3DynamicEndpoint(controlHost, port, path)`（`tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java` 的 parse 末尾，两个端点的 host 都写死为入参 `controlHost`，即设备响应里的 RTSP host 被**丢弃**）。复现时不需要实现这条策略，但需要实现「忽略设备自报的媒体 host」这一行为。

#### 探测端点白名单的实际生效路径（谁产生 `DeviceEndpointEvidence`）

| 机型 | 探测实现 | 产生的 evidence | 源码 |
|---|---|---|---|
| M3 | `M3SessionConnector$connectUserInitiated$verified$1.probe()` 先发 `PROBE` grant（host=`hostFor(M3)`、端口集 `{80}`、路径前缀集 = bootstrapEndpoints 的 path 集合），再 `executeProbe()` | `new DeviceEndpointEvidence(HTTP, host, 80, "/app/getproductinfo")`，model 取 `M3DeviceInfo.getModel()`，serial/firmware/boardVersion/features 全为 null | `tuwin/core/device/p005m3/M3SessionConnector$connectUserInitiated$verified$1.java:88`、`M3SessionConnector.java:1941`（`new DeviceProbeResult(DeviceType.M3, model, null,null,null, evidence, null,null, 208, null)`） |
| Ride3Pro / Ride6 | `Ride3ProSessionConnector$connectUserInitiated$verified$1.probe()` → `executeProbe()` 连打两次：`/api/device/status` 然后 `/api/device/info` | `new DeviceEndpointEvidence(HTTP, host, 80, "/api/device/status")`，带 `uuid`/`swver`/`hwver`/`ssid`/`normalizedFeatures` | `tuwin/core/device/ride3pro/Ride3ProSessionConnector$connectUserInitiated$verified$1.java:73`、`Ride3ProSessionConnector.java:1913` |
| Ride5 | `Ride5SessionConnector$connectUserInitiated$verified$1` | 对应 `/cgi-bin/hisnet/getdeviceattr.cgi` | `tuwin/core/device/ride5/Ride5SessionConnector$connectUserInitiated$verified$1.java:88`、`:153` |

两处值得注意的差异：
1. Ride3Pro 的 PROBE grant 路径前缀**不是**从 bootstrapEndpoints 推出来的，而是硬编码 `SetsKt.setOf("/api/device/")`（`Ride3ProSessionConnector$connectUserInitiated$verified$1.java:73`）；M3 才是 `CollectionsKt.toSet(bootstrapEndpoints.map{it.path})`（`M3SessionConnector$connectUserInitiated$verified$1.java:81-88`）。这意味着 Ride3Pro 探测阶段允许 `/api/device/` 下的任意子路径（正是 status + info 两条），而 M3 探测阶段只允许 `/app/getproductinfo` 一条。
2. Ride3Pro 探测要求 `hwver` 仅在 `targetDeviceType == DeviceType.RIDE6` 时才写入 `boardVersion`，RIDE3PRO 时传 null（`Ride3ProSessionConnector.java:1908-1913`）——即 RIDE6 用 hwver 作板本标识，Ride3Pro 不用。
3. Ride3Pro 探测额外要求 `/api/device/info` 的 `info` 非空：`if (ride3ProDeviceInfo == null) throw IllegalStateException("RIDE3PRO device info is missing")`（`Ride3ProSessionConnector.java:1902-1904`）。M3 对应的是 `"M3 probe response has no product info"`（`M3SessionConnector.java:1939`，JADX 把 `== null` 显示成了 `!= null`，语义按错误消息取反理解）。
4. 成功判据统一走 `requireSuccessful(response, endpoint)`：`result != 0` 即抛 `IllegalStateException("RIDE3PRO probe failed: <endpoint>, result=<result>")`（`Ride3ProSessionConnector.java:2024-2029`）。HTTP base 由 `httpBaseUrl(host, port)` 拼：IPv6 host 会补方括号，格式 `http://<host>:<port>/`（`:2031-2036`）。

---

## 2. HTTP 面全表

### 2.1 Ride3Pro / Ride6：`/api/*`

Ride3Pro 与 Ride6 **共用同一套 `/api/*` 端点**（`DefaultDeviceProtocolProfileRegistry` 给两者配了几乎相同的 profile，差异只在 `expectedModels` = `{"R3Pro"}` vs `{"R6"}` 和探测时是否把 `hwver` 当 boardVersion）。
唯一声明类型：`tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java`（Retrofit 接口，24 个方法，`:21-101`）。
统一响应包：`Ride3ProApiResponse<T> = {"result": Int, "info": T}`，`isSuccess() == (result == 0)`（`Ride3ProApiResponse.java:13-19, 82-84`）；`getErrorMessage()` 在 `info` 是 String 时给 `"result=<n>, info=<str>"`，否则 `"result=<n>"`（`:86-95`）。
所有请求默认走 `http://<host>:80/`（`Ride3ProSessionConnector.httpBaseUrl`，`:2031-2036`）。
下面「成功判据」列里 `result==0` 指 `Ride3ProApiResponse.isSuccess()`。

| # | 方法 | 路径（原样） | Query 参数 | 参数取值 | 期望响应字段 | 成功/失败判据 | 声明 / 主要调用点 |
|---|---|---|---|---|---|---|---|
| 1 | GET | `/api/authdevice` | `seed` | `Long`，来自 `kotlin.random.Random.nextLong(Long.MAX_VALUE)`（即 `0..9223372036854775806`），**端侧随机数，不参与签名** | 只用 `result`，`info` 被声明为 `Any?` 且不解析 | `result==0` 成功；否则 `Ride3ProConnectionException.httpFailed("/api/authdevice", errorMessage)` | 声明 `Ride3ProApiService.java:22-23`；预览调用 `tuwin/data/repository/Ride3ProStreamRepositoryImpl.java:238-247`；回放调用 `tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1094` |
| 2 | GET | `/api/capture` | 无 | — | `result` | `result==0` | `Ride3ProApiService.java:25-26`（拍照，被 `Ride3ProRecordRepositoryImpl` 使用） |
| 3 | GET | `/api/device/info` | 无 | — | `info`: `model` / `uuid` / `soc` / `ssid` / `pwd` / `mac` / `swver` / `hwver` / `features`(String 数组) | `result==0` 且 `info != null`，否则 `IllegalStateException("RIDE3PRO device info is missing")` | 声明 `:31-32`；模型类 `Ride3ProDeviceInfo.java`（`@SerializedName` 全量）；探测调用 `Ride3ProSessionConnector.java:1886-1904` |
| 4 | GET | `/api/device/status` | 无 | — | `info`: `adapter_status` / `battery_percent`（**别名 `battery_level`**，`@SerializedName(alternate={"battery_level"}, value="battery_percent")`） / `current_mode` / `exception_flags` / `hdr_chk_cnt` / `mode_active` / `recording_time`；全部是 `Integer?`（缺字段= null，不报错） | `result==0` | 声明 `:34-35`；模型 `Ride3ProDeviceStatusInfo.java`；轮询 `Ride3ProPollingStatusChannel.java:443`；探测 `Ride3ProSessionConnector.java:1886`；连接检测 `Ride3ProDeviceRepositoryImpl$detectConnection$2.java:133`、`detectConnectionLightweight$2.java:69`、`getDeviceStatus$2.java:72` |
| 5 | GET | `/api/menu/xml` | 无 | — | **不是 JSON**，`@Streaming` + 返回 `ResponseBody`（XML 文本，见 §5） | 无 `result` 概念，按 XML 解析结果判定 | `:37-39` |
| 6 | GET | `/api/menu/getparameter` | `id` | 菜单项 id 字符串（见 §5.3 推导） | `result` + `info` | `result==0` | `:41-42` |
| 7 | GET | `/api/menu/setparameter` | `id`, `value` | `id` 见 §5.3；`value` **可空**（`DefaultImpls.setParameter$default` 在 `i & 2` 时传 `null`，即可以只带 `id=` 不带 `value=`） | `result` | `result==0` | `:96-97`、`:106-114`；恢复出厂 `Ride3ProDeviceRepositoryImpl$factoryReset$2.java:71`；改 WiFi 密码 `setWifiPassword$2.java:75` |
| 8 | GET | `/api/reboot` | 无 | — | `result` | `result==0` | `:81-82`；`Ride3ProDeviceRepositoryImpl$reboot$2.java:70` |
| 9 | GET | `/api/record/start` | 无 | — | `result` | `result==0` | `:84-85`；`Ride3ProRecordRepositoryImpl.java:237`；`TuwinApplication.java:1570` 也持有该字面量 |
| 10 | GET | `/api/record/stop` | 无 | — | `result` | `result==0` | `:87-88`；`Ride3ProRecordRepositoryImpl.java:433` |
| 11 | GET | `/api/setmode` | `mode` | **`0` = 预览/录像模式**（`Ride3ProStreamRepositoryImpl.MODE_PREVIEW = 0`，`Ride3ProStreamRepositoryImpl.java:38`）；**`2` = 回放模式**（3 处各自定义 `MODE_PLAYBACK = 2`：`Ride3ProPlaybackRepositoryImpl.java:54`、`tuwin/presentation/p010ui/storage/ride3pro/Ride3ProIndexedPlaybackModeAction.java:25`、`Ride3ProStorageCapabilityProbe.java:32`）。`1` 在反编译源码中**没有任何常量定义或使用点**（见 §2.8） | `result` | `result==0`，否则 `Ride3ProConnectionException.httpFailed("/api/setmode", errorMessage)` | `:93-94`；`Ride3ProStreamRepositoryImpl.java:267`、`Ride3ProPlaybackRepositoryImpl.java:193`、`Ride3ProSessionApiService.java:98`（`setMode(0)`）、`C2216x9d51f82a.java:47`（`setMode(0)`）、`Ride3ProIndexedPlaybackModeAction.java:69`（`setMode(2)`）、`Ride3ProStorageCapabilityProbe.java:160`（`setMode(2)`） |
| 12 | GET | `/api/sd/info` | 无 | — | `info`: `status` / `total` / `free`（均 `Integer?`） | `result==0` | `:60-61`；模型 `Ride3ProSdInfo.java`；`Ride3ProDeviceRepositoryImpl$getSDInfo$2.java:73` |
| 13 | GET | `/api/system/formatsd` | 无 | — | `result` | `result==0`；**该路径单独享有 60 秒超时**（见 §6） | `:28-29`；`Ride3ProDeviceRepositoryImpl.java:353`；常量 `Ride3ProHttpRequestQueueKt.java:14`；超时拦截器 `Ride3ProFormatTimeoutInterceptor.java:17` |
| 14 | GET | `/api/vendor/send-time` | `year`, `month`, `day`, `hour`, `minute`, `second` | 6 个 `Int`，本地时钟拆分（无时区参数） | `result` | `result==0` | `:90-91`；`Ride3ProStreamRepositoryImpl.java:392` |
| 15 | GET | `/api/rtspstatus` | `seed` | `Long`，与 §3 的 authdevice seed 同一随机数体系（`Ride3ProSessionApiService` 透传 `$seed`） | `result`（`info` 不解析） | `result==0` | `:57-58`；`Ride3ProSessionApiService.java:688, 703` |
| 16 | GET | `/api/playback/dayinfo` | `date` | `Int`，**YYYYMMDD 整数**（不是字符串）。合法域校验：`MIN_YYYYMMDD = 10000000`、`MAX_YYYYMMDD = 99999999`、`YEAR_DIVISOR = 10000`、`MONTH_DIVISOR = 100`、`MONTH_MODULUS = 100`、`DAY_MODULUS = 100`、`MAX_HOUR = 23`、`MIN_HOUR = 0`、`MAX_FILE_INDEX = 9999`、`MIN_FILE_INDEX = 0`（`Ride3ProPlaybackIndexValidator.java:16-27`） | `info`: `date` / `file_count` / `hour_count` / `hour_list[]`，`hour_list[i]` = `hour` / `file_count` / `last_file_index` | `result==0`；字段缺失由 validator 抛（`requireField`） | `:44-45`；模型 `Ride3ProPlaybackDayDetail.java`、`Ride3ProPlaybackHourInfo.java`；`Ride3ProIndexedPlaybackRepositoryImpl.java:34`、`loadDayHours$2.java:69` |
| 17 | GET | `/api/playback/filecount` | 无 | — | `info`: `day_count` / `total_file_count` / `next_file_index` / `day_list[]`，`day_list[i]` = `date` / `file_count` / `last_file_index` | `result==0` | `:47-48`（注解写的是常量 `Ride3ProStorageCapabilityProbe.FILE_COUNT_ENDPOINT`）；常量值 `"/api/playback/filecount"`；模型 `Ride3ProPlaybackFileCountInfo.java`、`Ride3ProPlaybackDayInfo.java`；`Ride3ProIndexedPlaybackRepositoryImpl.java:36`、`Ride3ProStorageCapabilityProbe.java:29` |
| 18 | GET | `/api/playback/filelist` | `mode`, `file_index` | `mode` 同上（实际传 `2`=回放）；`file_index` = `Int` 起始索引，页大小 `PAGE_SIZE = 16`（`Ride3ProPlaybackRepositoryImpl.java` 的 `PAGE_SIZE`、`Ride3ProHourScanCursor.PAGE_SIZE = 16`、`StorageSdcardItemFragment.RIDE3PRO_PAGE_SIZE = 16`） | `info`: `file_count`(Int) / `file_list[]`；`file_list[i]` = `file_index` / `file_name` / `name` / `path` / `size`(Long) / `type`(String) / `time`(String) / `total_time`(Int) | `result==0`；`file_list[i].file_index` 必须存在且在 `0..9999`，否则 `IllegalArgumentException("file_list[i].file_index must be in 0..9999 for pagination: <v>")` | `:50-51`；模型 `Ride3ProPlaybackFileListInfo.java`、`Ride3ProPlaybackFileEntry.java`；分页逻辑 `Ride3ProHourFilesLoader.java:335-383`；映射校验 `Ride3ProPlaybackFileMapper.java:48-50` |
| 19 | GET | `/api/playback/thumbnail` | `file_index` | `Int` `0..9999` | **`@Streaming` `ResponseBody`（图片字节流，非 JSON）** | HTTP 层判定；带重试拦截器 | `:53-55`；`VerifiedDeviceFileCatalog.java:538`（用 `encodedPath("/api/playback/thumbnail").addQueryParameter("file_index", …)` 重建）、`Ride3ProGlideThumbnailPolicy.java:20`、`Ride3ProHttpRequestQueueKt.java:18` |
| 20 | GET | `/api/playback/rawdata` | `file_index` | `Int` `0..9999` | **`ResponseBody` 原始文件字节流**，支持 `Range` 续传 | HTTP 层；`Ride3ProPlaybackDownloadResumePolicy` 按固件版本决定是否续传，`MAX_RETRY_COUNT = 5` | **不在 `Ride3ProApiService` 里**，由 OkHttp 直接构造：`VerifiedDeviceFileCatalog.java:497` → `authorizeRide3Pro(..., StreamingTransferEngine.RIDE3PRO_RAWDATA_PATH, ...)` → `:717` 拼 URL；常量 `Ride3ProHttpRequestQueueKt.java:16`、`StreamingTransferEngine.java:79`（标 `@Deprecated`，仅作路径判定）、`Ride3ProPlaybackDownloadResumePolicy.java:25, 230` |
| 21 | GET | `/api/playback/start` | `file_index` | `Int` `0..9999` | `result` | `result==0` | `:75-76`；`Ride3ProPlaybackRepositoryImpl.java:1202` |
| 22 | GET | `/api/playback/pause` | `file_type` | `Int`（**不是** `Ride3ProPlaybackFileEntry.fileType` 那个 String；类型枚举见 §2.8） | `result` | `result==0` | `:66-67`；`Ride3ProPlaybackRepositoryImpl.java:1525` |
| 23 | GET | `/api/playback/setspeed` | `index` | `Int` 倍速索引 | `result` | `result==0` | `:69-70`；`Ride3ProPlaybackRepositoryImpl.java:1757` |
| 24 | GET | `/api/playback/settime` | `second` | `Int` 秒（0 起） | `result` | `result==0` | `:72-73`；`Ride3ProPlaybackRepositoryImpl.java:1709` |
| 25 | GET | `/api/playback/stop` | 无 | — | `result` | `result==0` | `:78-79`；`Ride3ProPlaybackRepositoryImpl.java:1573`、`Ride3ProRecordRepositoryImpl.java:299` |
| 26 | GET | `/api/playback/delete` | `file_index` | `Int` `0..9999` | `result` | `result==0` | `:63-64`；`Ride3ProIndexedPlaybackRepositoryImpl.java:35`、`Ride3ProPlaybackRepositoryImpl.java:1627` |
| 27 | POST | `/api/firmware/upload` | `md5sum`, `model`, `hw`, `sw` | 4 个 String；Header 固定 `Content-Type: application/octet-stream`、`Content-Encoding: identity`、`Connection: close`；Body 为 `RequestBody` 原始字节 | `result` | `result==0` | `:99-101`。**语义属 OTA 附录**，本文只登记端点 |

协议特性协商（`/api/device/info` 的 `features` 数组，归一化后参与判定）：
- `Ride3ProProtocolFeatures.NV = "nv"`、`Ride3ProProtocolFeatures.REBOOT = "reboot"`（`tuwin/data/source/remote/api/ride3pro/Ride3ProProtocolFeatures.java:14-16`）。
- `normalize()`：逐项 trim → `toLowerCase(Locale.ROOT)` → 丢弃空串 → `toSet()`（`:19-36`）。**大小写不敏感、顺序无关**。
- 语义：含 `"reboot"` 才允许 `/api/reboot`；含 `"nv"` 走 nv 相关行为（属功能面，本文不展开）。

### 2.2 M3：`/app/*`

唯一声明类型：`tuwin/data/source/remote/api/p006m3/M3ApiService.java`（Retrofit 接口，27 个方法，`:46-138`）。
统一响应包：`{"result": Int, "info": …}`，`isSuccess() == (result == 0)`。`info` 的类型**按端点不同**：有的强类型对象，有的 `List`，有的是裸 `String`（错误消息），`getProductInfo` 是 `Object`、`getMediaInfo` 是 `JsonElement`。
特殊：多数「设置类」端点判据写成 `if (response.getResult() != 0) → Exception("…: " + response.getInfo())`（如 `M3DeviceRepositoryImpl.java:515-517`），即直接把 `info` 当错误文本用。
Base URL：`httpBaseUrl(grant)` = `http://<host>:<port>/`；探测阶段固定 80（`M3SessionConnector.java:1886` 传 `httpBaseUrl(str2, 80)`）。
HTTP 客户端兼容性覆盖：`M3HttpClientCompatibilityKt` 设 `M3_CONNECT_TIMEOUT_SECONDS = 5`、`M3_READ_TIMEOUT_SECONDS = 120`、`M3_WRITE_TIMEOUT_SECONDS = 120`（`catalog-ports.md:85-87`），并给 Retrofit 加 `GsonBuilder().setLenient()`（`M3SessionConnector.java:1915`）——**宽松模式 Gson**，容忍设备返回的非规范 JSON。

| # | 方法 | 路径 | Query 参数 | 参数取值 | 期望响应字段（`info`） | 成功/失败判据 | 声明 / 调用点 |
|---|---|---|---|---|---|---|---|
| 1 | GET | `/app/getproductinfo` | 无 | — | `info` 按 `Map` 手工取 4 个键：`model`、`company`、`soc`、`sp`（缺键 → 空串 `""`；整体异常 → null） | `result==0` 且 `parseDeviceInfo()` 非 null；否则 `IllegalStateException("M3 probe failed: <errorMessage>")` / `"M3 probe response has no product info"`；`errorMessage` 取 `getErrorMessage()`，为 null 时用字面量 `"device rejected request"` | 声明 `M3ApiService.java:87`；**唯一探测端点**（`DefaultDeviceProtocolProfileRegistry.java:34`）；解析 `M3ProductInfoResponse.java:82-111`；调用 `M3SessionConnector.java:1926-1941` |
| 2 | GET | `/app/getdeviceattr` | 无 | — | `info`: `bssid` / `ssid` / `uuid` / `hwver` / `softver` / `otaver` / `camnum`(int) / `curcamid`(int) / `wifireboot`(int) | `result==0` | 声明 `:66`；`M3DeviceRepositoryImpl.java:427`；模型 `M3DeviceAttrInfo.java:16-40` |
| 3 | GET | `/app/getbatteryinfo` | 无 | — | `info`: `capacity`(int) / `charge`(int) | `result==0` | 声明 `:60`；`M3DeviceRepositoryImpl.java:277` |
| 4 | GET | `/app/getcurmode` | 无 | — | `info` 是**数组**，元素 = `name`(String) / `value`(Integer?) | `result==0` | 声明 `:63`；`M3DeviceRepositoryImpl.java`；模型 `M3CurModeResponse.java` + `M3CurModeInfo.java` |
| 5 | GET | `/app/getsdinfo` | 无 | — | `info`: `status`(int) / `total`(int) / `free`(int) | `result==0` | 声明 `:93`；`M3DeviceRepositoryImpl.java:216`；模型 `M3SDInfo.java:14-20` |
| 6 | GET | `/app/getmediainfo` | 无 | — | **手工解析 `JsonObject`**，3 个键：`rtsp`(String，缺→`""`)、`transport`(String，缺→`""`)、`port`(Int，缺→`0`)；解析异常 → null | `result==0` 且 `getMediaInfo()` 非 null；否则 `getErrorMessage()` 给 `"Media info request failed with code <result>"` 或 `"Unknown error"` | 声明 `:75`；`M3DeviceRepositoryImpl.java:348, 354`；解析 `M3MediaInfoResponse.java:80-96`。**这是 M3 RTSP 端点的唯一来源**（§7） |
| 7 | GET | `/app/getfilelist` | 无 | — | `info` = 数组，元素 = `folder`(String) / `count`(int) / `files[]`；`files[i]` = `name` / `size`(long) / `createtime`(long) / `duration`(int) / `type`(int) | `result==0` | 声明 `:69`；`M3DeviceRepositoryImpl.java`（`onFileListVerified` 回调在校验后触发，`:89`）；模型 `M3FileListResponse.java`、`M3FolderInfo.java`、`M3FileItem.java:25-37` |
| 8 | GET | `/app/getthumbnail` | `file` | 文件名（`String`，`@Streaming` 返回 `ResponseBody` 图片字节） | 二进制，不走 `result` | HTTP 层 | 声明 `:97`；`M3DeviceRepositoryImpl$getThumbnail$bitmap$1.java:75` |
| 9 | GET | `/app/getparamitems` | `param` | 参数名；`"all"` = 全量（`Ride6ParameterRequestIds.ALL = "all"`，`tuwin/presentation/p010ui/device/settings/Ride6ParameterRequestIds.java:18`） | `info` = 数组（`getParamItemsByMode`）或单对象（`getParamItem`），元素 = `name` / `items`(String[]) / `items_disable`(String[]) / `index`(Integer[]) / `cur_index`(Integer?) / `enable`(Integer?) | `result==0` | 声明 `:54`（`getAllParamItems`）、`:90`（`getParamItem`）、`:87`? 修正：`getParamItemsByMode` 在 `:72`? —— 三方法共用同一 `@GET("/app/getparamitems")`；模型 `M3ParamItem.java:18-33`。**同一端点被 3 个不同签名的方法重复声明** |
| 10 | GET | `/app/getparamvalue` | `param` | 同上，`"all"` 取全量 | `info` = 数组（`getAllParamValues`）或单对象（`getParamValue`），元素 = `name` / `value` | `result==0` | 声明 `:57`、`:93`；模型 `M3ParamValue.java:17-20` |
| 11 | GET | `/app/setparamvalue` | `param`, `value` | `param` = 参数名；`value` = 字符串化的取值。**同一个端点被 3 个方法复用**：`setParamValue(String,String)`、`setRecording(String,int)`、`takeSnapshot(String,int)` | `info` = `String` | `result==0` | 声明 `:112`、`:118`、`:130`；`M3DeviceRepositoryImpl.java:2683`（setParamValue）、`:1026`（setRecording，默认 `param="rec"`）、`:1095`（takeSnapshot，默认 `param="snapshot"`）；默认值见 `M3ApiService.java:153-171` |
| 12 | GET | `/app/mode` | `param` | **`Int` 拍摄模式号**，取值集合：`16`=PHOTO_SINGLE、`17`=PHOTO_BURST、`18`=PHOTO_TIMELAPSE、`19`=PHOTO_TIMER、`20`=PHOTO_LONG_EXPOSURE、`21`=VIDEO_NORMAL、`22`=VIDEO_LOOP、`23`=VIDEO_TIMELAPSE、`24`=VIDEO_SLOW_MOTION、`25`=VIDEO_FAST_MOTION（`tuwin/core/constants/M3Constants.java` 内 `ShootingMode` 的 10 个常量，另 `MODE_NAME_RES_BY_ID` 一一同名映射到 string 资源） | `info` = `String` | `result==0` | 声明 `:109`；`M3DeviceRepositoryImpl.java:1162` |
| 13 | GET | `/app/setting` | `param` | 菜单项名（`setMenuMode`） | `info` = `String` | `result==0` | 声明 `:106` |
| 14 | GET | `/app/playback` | `param` | 回放控制串 | `info` = `String` | `result==0` | 声明 `:115` |
| 15 | GET | `/app/setsystime` | `date` | `String`，格式 **`yyyyMMddHHmmss`**，用设备时区格式化：`SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())` + `setTimeZone(timeZoneProvider())`（`tuwin/domain/strategy/M3ConnectionStrategy.java:1341-1343`） | `info` = `String` | `result != 0` → `Exception("Failed to sync M3 device time: " + info)` | 声明 `:121`；`M3DeviceRepositoryImpl.java:545` |
| 16 | GET | `/app/settimezone` | `tz` | `Int`，**小时数**的 UTC 偏移：`timeZone.getRawOffset() / MILLIS_PER_HOUR`（`M3ConnectionStrategy.java:1345`）。⚠ 参数名不是字面量而是常量引用 `C3059bv.f1692M`，判定为 `"tz"`，理由见本节末「常量还原说明」 | `info` = `String` | `result != 0` → `Exception("Failed to sync M3 device timezone: " + info)` | 声明 `:125`；`M3DeviceRepositoryImpl.java:506, 514, 568` |
| 17 | GET | `/app/setwifi` | `wifissid`, `wifipwd` | 两个都**可空**（`DefaultImpls.setWifi$default` 按 bit 1/2 分别置 null，`M3ApiService.java:140-151`） | `info` = `String` | `result==0` | 声明 `:127` |
| 18 | GET | `/app/sdformat` | 无 | — | `info` = `String` | `result==0` | 声明 `:103` |
| 19 | GET | `/app/reset` | 无 | — | `info` = `String` | `result==0` | 声明 `:100` |
| 20 | GET | `/app/deletefile` | `file` | 文件名 | `info` = `String` | `result==0` | 声明 `:47` |
| 21 | GET | （动态 `@Url`） | — | `fileUrl` 由上层拼装的完整 URL | `@Streaming ResponseBody` | HTTP 层 | 声明 `:49-51` `downloadFile(@Url String)`。**在整份源码里没有任何调用方**（见 §2.7） |
| 22 | POST | `/upload/{savepath}/{filesize}` | 无（值走 Path） | `@Path(encoded=true) savepath` = `"mnt/sdcard"`（**硬编码，且 `encoded=true` 所以不含 scheme/host**）、`@Path filesize` = `Long` 文件字节数；Body = `RequestBody` | `info` = `String` | `result==0` | 声明 `:133-135`；`M3DeviceRepositoryImpl$uploadFirmware$2.java:171`。语义属 OTA 附录，本文只登记 |

**M3 的 3 个死端点（声明了但全仓无调用方）**：`getAllParamItems`（`/app/getparamitems`）、`getAllParamValues`（`/app/getparamvalue`）、`getParamValue`（`/app/getparamvalue`）。
证据：`grep -rln "\bgetAllParamItems\b" _work/tuwin_src/sources/com/tuwinsmart` 只命中 `M3ApiService.java` 一个文件；`getAllParamValues`、`getParamValue` 同样。
含义：官方 App 的 M3 设置页只走「按模式取 items」`getParamItemsByMode` + 「单值取」`getParamItem` + `setParamValue`，**没有使用「一次拉全部参数值」的能力**。复现时若照抄 `getAllParamValues` 属于过度实现。

**常量还原说明（3 个被 JADX 折叠成 umeng 常量的字面量）**：

| 引用点 | 常量 | 还原值 | 依据 |
|---|---|---|---|
| `M3ApiService.java:125` `@Query(C3059bv.f1692M)` | `com.umeng.bv.M` | `"tz"` | `com/umeng/commonsdk/statistics/C3243b.java:121` 在「逻辑键 → 缩写键」映射表里写 `f3189j.put(C3059bv.f1692M, "#tz")`，同表的逻辑键全是明文（`"device_model"`、`"app_version"`、`"version_code"`、`"st"`、`"analytics"`），故该逻辑键为时区的两字母缩写 `tz`。**标记为推断**，未在该 APK 里找到 `f1692M` 的声明体 |
| `Ride3ProApiService.java:70` `@Query(C3174a.f2698H)` | `com.umeng.ccg.a.H` | `"index"` | 三处独立交叉验证：`androidx/collection/LongSparseArrayKt.java:108` 的 Kotlin `@Metadata.d2` 里，该常量出现在 `getIndex`/`setIndex` 之间的**属性名**槽位；`androidx/core/view/MenuKt.java:67` 同理；`M3ParamItem.java:24` 的 `@SerializedName(C3174a.f2698H)` 对应字段名正是 `List<Integer> index` |
| `M3ParamItem.java:21` `@SerializedName(C3077cm.f1941q)` | `com.umeng.analytics.pro.cm.q` | `"enable"` | 同文件字段声明顺序与 `@SerializedName` 顺序一一对应：`cur_index`→`curIndex`、`<f1941q>`→`enable`、`<f2698H>`→`index`、`items`→`items`、`items_disable`→`itemsDisable`、`name`→`name` |

### 2.3 Ride5：`cgi-bin/hisnet/*.cgi`

唯一声明类型：`tuwin/core/device/ride5/Ride5CgiApi.java`（Retrofit 接口，25 个方法，`:15-93`）。
**全部是 GET**，无 POST/Body。
路径**不以 `/` 开头**（除 `formatSdCard` 外）→ Retrofit 按相对路径解析到 baseUrl 的当前目录，即 `http://192.168.0.1/cgi-bin/hisnet/xxx.cgi`（baseUrl 由 `Ride5CgiGatewayKt.java:31` 的 `"http://"` 前缀拼装）。
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
| 1 | GET | `cgi-bin/hisnet/getdeviceattr.cgi` | 无 | — | 若干 `var` 键值 | 通用规则 | 声明 `:46`；**Ride5 唯一探测端点**（`DefaultDeviceProtocolProfileRegistry.java:34`、`Ride5SessionConnector$connectUserInitiated$verified$1.java:153`） |
| 2 | GET | `cgi-bin/hisnet/checkconnect.cgi` | `-ip` | 回调 IP（`Ride5SessionConnector` 的 `callbackIp` 形参，由上层从网络 lease 取得） | — | 通用规则 | 声明 `:16`；`Ride5CgiGateway.java` |
| 3 | GET | `cgi-bin/hisnet/client.cgi` | `-operation`, `-ip` | `-operation` 只有两个字面值：**`"register"`** 与 **`"unregister"`**（`Ride5CgiGateway.java:305` 与 `:357` 各传一个）；`-ip` = 手机侧回调 IP | — | 通用规则 | 声明 `:70`。这是**设备反向连接手机的注册握手**，回调端口 `Ride5DeviceAdapterSession.CALLBACK_PORT = 9002` |
| 4 | GET | `cgi-bin/hisnet/getworkstate.cgi` | 无 | — | 含 `running` 键（值 `"true"`/`"false"`，见 `EmptyControlVideo.java:591` 的 `fields.get("running")` 与 `Intrinsics.areEqual(..., "true")`） | 通用规则 | 声明 `:67`；`Ride5GatewaySessionPort.java:20` |
| 5 | GET | `cgi-bin/hisnet/workmodecmd.cgi` | `-cmd` | 观测到的字面值只有 2 个：**`"stop"`**（`Ride5SessionPort.java:49` 的默认实现 `ensureRecordingStopped`、`SerializedRide5RecordingSessionPort.java:371, 411`、`MoreSettingsActivity.java:1539`、`StorageManagerActivityKt.java:60`）、**`"trigger"`**（`DeviceDetailActivity.java:1164`、`EmptyControlVideo.java:907`，用于拍照/录像触发）。形参是 `String`，无枚举约束，其他取值未出现在反编译代码中 | — | 通用规则 | 声明 `:91`；`Ride5CgiGateway.java:611, 625` |
| 6 | GET | `cgi-bin/hisnet/getcamchnl.cgi` | `-camid` | 摄像头 id（字符串化 Int；来自 UI，无枚举约束） | — | 通用规则 | 声明 `:88`；`Ride5CgiGateway.java:1204` |
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
| 19 | GET | `cgi-bin/hisnet/sdcommand.cgi?&-format` | **无 `@Query`，格式串本身就是完整 URL**：`…/cgi-bin/hisnet/sdcommand.cgi?&-format`——`?` 后紧跟一个空的 `&`，`-format` 是**无值开关参数**（复现时必须逐字节一致） | — | 通用规则 | 声明 `:25`；`Ride5CgiGateway.java:1039, 1053`、`RecordingEventRide5SessionPort.java:139` |
| 20 | GET | `cgi-bin/hisnet/getsdstatus.cgi` | 无 | — | SD 卡状态 | 通用规则 | 声明 `:61` |
| 21 | GET | `cgi-bin/hisnet/getbatterycapacity.cgi` | 无 | — | 电量 | 通用规则 | 声明 `:28` |
| 22 | GET | `cgi-bin/hisnet/getwifi.cgi` | 无 | — | WiFi 配置 | 通用规则 | 声明 `:64`；`Ride5CgiGateway.java:1225` |
| 23 | GET | `cgi-bin/hisnet/setwifi.cgi` | `-wifissid`, `-wifikey` | 注意参数名是 `-wifikey` 而**不是** `-wifipwd`（与 M3 的 `wifipwd` 不一致） | — | 通用规则 | 声明 `:85-86`；`Ride5CgiGateway.java:1274` |
| 24 | GET | `cgi-bin/hisnet/setsystime.cgi` | `-time` | `String`，格式 `yyyyMMddHHmmss`。常量 `Ride5ConnectionStrategy.RIDE5_TIME_PATTERN = "yyyyMMddHHmmss"`（`_work/re/tuwin/catalog-consts.md:704`；同族的 M3 常量是 `M3ConnectionStrategy.M3_TIME_PATTERN = "yyyyMMddHHmmss"`，`tuwin/domain/strategy/M3ConnectionStrategy.java:79`），三处一致 | — | 通用规则 | 声明 `:82` |
| 25 | GET | `cgi-bin/hisnet/reset.cgi` | 无 | — | 走 `parseReset`：**空响应即成功** | `parseReset` 专属规则 | 声明 `:73` |
| 26 | GET | `cgi-bin/hisnet/checkupgradepktinfo.cgi` | `-model`, `-softversion`, `-pktlen` | 三个 String；`-model`/`-softversion` 来自设备属性，`-pktlen` 为分包长度 | — | 通用规则 | 声明 `:19`；`Ride5GatewaySessionPort.checkPacket(...)`。语义属 OTA 附录 |

### 2.4 媒体与流端点

| 机型 | 用途 | 端点 | 端口 | 来源 / 证据 |
|---|---|---|---|---|
| Ride3Pro / Ride6 | RTSP 预览 | `rtsp://<mediaGrant.host>:<port>/?action=stream`（**路径为空、query 直接跟在 `/?` 后**） | `8080` | `tuwin/core/device/ride3pro/DocumentedRide3ProMediaEndpointResolver.java:26-31`；端口常量 `Ride3ProDeviceAdapterSession.RTSP_PREVIEW_PORT = 8080`（`Ride3ProDeviceAdapterSession.java:62`）；`allowedMediaPorts = {8080}` |
| Ride3Pro / Ride6 | 缩略图 | `/api/playback/thumbnail?file_index=<n>` | 80 | 见 §2.1 第 19 行 |
| Ride3Pro / Ride6 | 原文件下载 | `/api/playback/rawdata?file_index=<n>` | 80 | 见 §2.1 第 20 行 |
| Ride5 | RTSP 直播 | `rtsp://<mediaGrant.host>:<port>/livestream/1`（**路径写死为 `/livestream/1`**，而授权 grant 的 `allowedPathPrefixes` 是 `{"/livestream"}`，即允许前缀比实际用的路径更宽） | `554`（`Ride5DeviceAdapterSession.RTSP_LIVE_PORT`） | `tuwin/core/device/ride5/Ride5DeviceMediaPort.java:110`；grant 签发 `tuwin/core/device/ride5/Ride5DeviceAdapterSession.java:251` |
| Ride5 | 设备反向回调（**TCP 服务端在手机上**） | `DeviceEndpointProtocol.TCP` + `EndpointPurpose.CALLBACK` + `allowedPorts = {9002}` + `allowedPathPrefixes = {"/"}` | `9002`（`Ride5DeviceAdapterSession.CALLBACK_PORT`） | `Ride5DeviceAdapterSession.java:250`；实现 `tuwin/core/device/ride5/JavaRide5CallbackServerSocket.java`、`Ride5CallbackChannel` |
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
| `/`（约 55 行，含 `M3DeviceAdapter.java:921`、`DeviceProtocolProfile.java:233`、`Ride3ProSessionTransport.java:612` 等） | 遍布各层 | **不是端点，是字符串运算的分隔符**。`DeviceProtocolProfile.java:233` 的 `/` 是 `normalizePath` 的兜底返回值；其余是 `split("/")` / `trimEnd('/')` / 路径拼接的分隔符。目录工具按「含 `/` 的字面量」粗筛命中，全是误报 |
| `//`（`M3SessionRepositoryFactory.java:151`） | 同文件 `:151` | 是 `StringsKt.replace$default(..., "//", "/", ...)` 的**被替换串**，用于把拼出来的双斜杠压成单斜杠，不是端点 |
| `http://`、`https://`、`rtsp://`、`content://`（各 2-10 行） | 连接器与策略类 | **scheme 前缀片段**，用于 `startsWith` 判定或 `StringBuilder("rtsp://")` 拼接。真正的完整端点已在 §2.1–§2.4 逐条列出 |
| `/api/`、`/app/`、`/api/firmware/`、`/api/menu/`、`/api/playback/`、`/api/playback/thumbnail`（`Ride3ProDeviceAdapterSession.java:823`、`DefaultDeviceProtocolProfileRegistry.java:34`） | 授权面 | **是 `allowedPathPrefixes` 白名单条目，不是可请求的 URL**。已在 §1.4（profile 字段表）与 §2.4（Ride3Pro 操作级 grant 表）中列出，重复进端点表会造成「这几个路径也能 GET」的误解 |
| `/api/device/`（`Ride3ProSessionConnector$connectUserInitiated$verified$1.java:73`） | 探测 | 同上，是 PROBE grant 的路径前缀，见 §1.5 差异点 1 |
| `/cgi-bin/hisnet/`、`/cgi-bin/hisnet/getdeviceattr.cgi`（`Ride5SessionConnector$connectUserInitiated$verified$1.java:88, 153`、`DefaultDeviceProtocolProfileRegistry.java:34`） | 探测 | 同上，Ride5 的前缀与 bootstrap 端点，已在 §1.4/§2.3 |
| `/upload`（`M3SessionRepositoryFactory.java:79`） | OTA | 常量 `M3_OTA_PATH_PREFIX = "/upload"` 且**标了 `@Deprecated`**；M3 真实上传路径是 `/upload/{savepath}/{filesize}`（§2.2 第 22 行）。旧常量仅作历史兼容判定 |
| `/api/log/get`、`/sd/LOG`（`DeviceLogEndpointPolicy.java:29, 31`） | 诊断日志 | 已在 §2.4 末尾单列（属诊断面，不是设备控制协议） |
| `/CLOG`（`WriteRuntimeLogTree.java:47`）、`/LOG`（`LogHelper.java:124`）、`/TUWIN`（`DownloadUtil.java:2752`） | 日志/下载 | **Android 外部存储目录名**，不是 HTTP 路径 |
| `.json`（`Ride3ProPlaybackCatalogPersistentCacheStore.java:290`、`Ride3ProPlaybackPersistentCacheStore.java:207`）、`manifest.json`（`RuntimeLogSnapshot.java:65`）、`/koin.properties`（`KoinApplicationExtKt.java:17`，归属 `UNKNOWN`） | 本地缓存/DI | **本地文件名** |
| `/img/shadow-blue.png` 等 6 条（`ExternalResourceAllowlist.java:30`） | H5 | 内嵌 WebView 的**外链资源白名单**（相对 `http://tuwinwifihelp.tuwinsmart.com` 之类的外网基址），不属设备协议面 |
| `/pcn_manager/download_static_file`（`ExternalResourceAllowlist.java:19`、`ExternalWebCompatibilityPolicy.java:203`、`ExternalWebResourcePolicy.java:15`） | H5 | 外网（腾讯 PCN 静态资源）路径，属网络层共存面 |
| `/privacy.html`、`https://yomu.atlasmeta.one`（`PrivacyPolicySource.java:16, 33`） | 隐私 | 外网站点，属合规面 |
| `/m/8acYvvtd8S4`、`/s/S-odmnyu7jctrZZlzBwGMA`、`/s/wXxedWNrYloV9v7t4f5Qtw`、`/twoBbgH2l4Y`、`/app/id6740312738`（`ExternalWebCompatibilityPolicy.java:25, 28, 31, 50`） | H5 | 微信/帮助站的**具体文章 ID 路径**，写在 URL 兼容白名单里，非设备协议 |
| `http://tuwinwifihelp.tuwinsmart.com/…`（10 行）、`http://ride5helpnew.tuwinsmart.com/#/`、`http://ali.tuwinsmart.com/`、`http://ali.tuwinsmart.com/feedback`、`https://tuwin.tmall.com`、`tbopen://…`、`tmall://page.tm/shop?shopId=255736524`、`https://work.weixin.qq.com/kfid/kfc5097d1b6381f03e7` | 帮助/反馈/电商 | **云端与第三方 App 唤起面**，属其他附录（帮助与反馈、OTA 云端） |
| `http://schemas.android.com/apk/res/android`（3 行，归属 `UNKNOWN`） | flyco tablayout | Android 自定义 View 的 **XML namespace 常量**，误报 |
| `content://com.meizu.flyme.openidsdk/`（`C4010b.java:120`，`UNKNOWN`） | 魅族推送 | 第三方推送 SDK 的 ContentProvider URI，误报 |
| `, action=`、`, elevationFraction=`、`, translationXFraction=`、`, translationYFraction=`、`onTouch surface_container action=`、`ParamSetting(param=`、`PlayListGesture multi-pointer ignored, pointerCount=%d, action=%d` | UI/事件类 | **日志与 `toString()` 的格式串**，含 `action=` 被 `=` 规则误命中 |
| `Ride protocol recording event persistence failed: action=%s session=%s`、`RIDE5 recording event persistence failed: action=%s session=%s` | `Ride3ProRecordRepositoryImpl.java:706`、`RecordingEventRide5SessionPort.java:434` | **录像事件落库失败的日志模板**，不是 HTTP 模板；两者的机型前缀不同（`Ride protocol` vs `RIDE5`） |
| `/`（`/api/authdevice` 等已归类） | — | 无 |

**结论：`catalog-http.md` 的 269 行里，真正的设备侧 HTTP/CGI/RTSP 端点共 74 条**（Ride3Pro 27 + M3 22 + Ride5 26 = 75，其中 `/api/playback/thumbnail` 与 `/api/playback/rawdata` 在 §2.1 已作为端点行、在 §2.4 又各占一行，去重后 74）。其余 195 行为分隔符、scheme 片段、白名单前缀、本地文件名、外网/H5/第三方 SDK 与日志格式串。

### 2.6 跨机型的公共约定

1. **鉴权方式：全部机型都是「无鉴权明文 HTTP」**。没有任何 `Authorization`、`Cookie`、签名、时间戳头的注入逻辑；唯一的「握手」是 Ride3Pro 的 `seed`（§3）和 Ride5 的 `-ip` 回调注册（§2.3 第 3 行）。设备访问控制完全依赖「手机连到了设备自己的 AP」。
2. **成功判据两族**：JSON 族统一 `result == 0`（`Ride3ProApiResponse.java:82-84`、`M3ProductInfoResponse.java:78-80` 及各 M3 响应类的 `getResult() != 0` 判定）；CGI 族是「全文被 `var k="v";` 覆盖 + 无 `SvrFuncResult="<n>"`」。
3. **错误信息一律把 `info` 当人类可读文本用**（M3 的 `info` 是 `String`；Ride3Pro 的 `getErrorMessage()` 拼 `result=` + `info`），意味着设备可以在 `info` 里放任意文案，客户端不做白名单。
4. **Ride3Pro 每个请求都过 `EndpointAuthority.authorizeUrl`**（`DeviceEndpointAuthority.java:116+`），由 `Interceptor` 在 OkHttp 层拦截并可能抛 `EndpointNotAuthorizedException`；拦截器生成见 `M3DeviceAdapter.java:905-914`（`endpointInterceptor`，M3 同理，`purpose` 传 `CONTROL`）。
5. **Gson 一律 `setLenient()`**（`M3SessionConnector.java:1915`、`Ride3ProSessionConnector.java:1870`），对设备返回的非规范 JSON 宽容。

### 2.7 声明了但没有任何调用方的端点（复现时应跳过）

| 端点 | 声明处 | 证据 |
|---|---|---|
| M3 `/app/getparamitems` 的 `getAllParamItems(String param)` | `M3ApiService.java:54` | `grep -rln "\bgetAllParamItems\b" _work/tuwin_src/sources/com/tuwinsmart` 只命中 `M3ApiService.java` |
| M3 `/app/getparamvalue` 的 `getAllParamValues(String param)` | `M3ApiService.java:57` | 同上，只命中声明文件 |
| M3 `/app/getparamvalue` 的 `getParamValue(String param)` | `M3ApiService.java:93` 附近 | 同上 |
| M3 `downloadFile(@Url String)` | `M3ApiService.java:49-51` | 全仓对 `M3ApiService` 的 `downloadFile` 无调用（`DownloadUtil.downloadFile` 是同名不同类的业务方法，已在 `DownloadUtil.java:1140` 排除） |
| Ride3Pro `/api/setmode` 的 `mode = 1` | `Ride3ProApiService.java:93-94` | 全仓只出现 `setMode(0)` 与 `setMode(2)` 两个字面实参（`Ride3ProSessionApiService.java:98`、`C2216x9d51f82a.java:47`、`Ride3ProPlaybackRepositoryImpl.java:193`、`Ride3ProIndexedPlaybackModeAction.java:69`、`Ride3ProStorageCapabilityProbe.java:160`），`1` 无任何出现，形参是裸 `int` |
| `DeviceProtocolProfile.acceptsDynamicMediaHost` | `DeviceProtocolProfile.java:209` | 见 §1.5 |

注意：`getAllParamItems` / `getAllParamValues` **有**默认参数生成器（`M3ApiService.java:173-195`，默认 `param = "all"`），也就是说官方代码「写好但忘了接」的可能性极高——复现时如果要一次性拉全量参数，可以照这两个端点做，但要清楚官方 App 当前没走这条路。

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

四个机型**全部没有真正的鉴权**：没有账号/token/签名/加密挑战，没有任何 `Authorization`/`Cookie` 头被注入（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java` 与 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java` 的注解集合里只有 `@GET/@Query/@Body/@Headers/@Streaming/@POST`，`Ride3ProApiService.java:9-16` 的 import 可穷举证明）。访问控制完全靠「手机必须连在设备自己的 AP 上」。存在的最接近握手的东西有三个，按机型分：

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
4. `GET /api/vendor/send-time?year&month&day&hour&minute&second`（`:384-392`），6 个整数取自 `Calendar.getInstance()`：年=`get(1)`、月=`get(2)+1`、日=`get(5)`、时=`get(11)`、分=`get(12)`、秒=`get(13)`（回放路径的逐字段展开见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1097-1103`）。**没有时区参数、没有 UTC 换算**——设备被写成本机本地时间。此步失败只 `Timber.w` + 发一个 `Ride3ProPreviewPrepareWarning.SEND_TIME_FAILED` 警告（`Ride3ProStreamRepositoryImpl.java:307-315`），**不阻断预览**。
5. 握手缓存 `markReady(key)`（`:319-321`；回放 `Ride3ProPlaybackRepositoryImpl.java:1081-1083`）——注意：**send-time 失败也照样 markReady**，缓存的是「auth 已过」而不是「auth+时间同步都成功」。
6. `GET /api/setmode?mode=0`（`:260-267`），失败**硬抛** `Ride3ProConnectionException.httpFailed("/api/setmode", errorMessage)`（`:273-275`、`:336-338`、`:352-354`）。
7. 启动录像（`recordRepository.startRecording()`，`:276-289`），失败仅 `Timber.w("Ride3Pro：预览准备时启动录像失败，继续尝试预览")` + `Ride3ProPreviewPrepareWarning.RECORDING_START_FAILED`。
8. 之后才由上层拿 `rtsp://…:8080/?action=stream`（§7）去起播。

回放路径（`m2855preparePlaybackRtspStreamIoAF18A`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProPlaybackRepositoryImpl.java:1020-1136`）只做第 1~5 步的 auth + send-time（**不打 setmode，mode=2 由回放入口另发**），日志文案是 `"Ride3Pro：当前回放会话已有握手缓存，跳过重复 auth/send-time"`（`:1060`）。

#### 响应字段怎么被用：只用 `result`，`info` 完全丢弃

- 响应模型 `Ride3ProApiResponse<T>`，`@SerializedName("result") int` + `@SerializedName("info") T`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse.java:15-19`）。
- `authDevice` 的 `T` 声明为 `Any?`（`Ride3ProApiService.java:23`），调用点只读 `isSuccess()` / `getResult()` / `getErrorMessage()`，**不碰 `getInfo()`**——所以设备在 auth 响应里回什么都行，客户端不解析、不使用（不存在「设备下发一个 key/端口」这类行为）。

#### 失败分支（逐条）

| 条件 | 行为 | 证据 |
|---|---|---|
| `result == 0` | 通过 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse.java:83-85`（`isSuccess()` 定义为 `result == 0`） |
| `result != 0` 但 `result == -2` | **同样通过**（唯一被显式豁免的错误码，语义上是「已认证/重复认证」幂等） | 预览 `Ride3ProStreamRepositoryImpl.java:380`（`if (!resp.isSuccess() && resp.getResult() != -2) throw …`）；回放 `Ride3ProPlaybackRepositoryImpl.java:1092` |
| `result` 为其它非 0 值 | 预览：抛 `Ride3ProConnectionException.httpFailed("/api/authdevice", getErrorMessage())`（`Ride3ProStreamRepositoryImpl.java:381`）；回放：不抛，返回 `Result.failure(同样的异常)`（`Ride3ProPlaybackRepositoryImpl.java:1093-1094`） | 同左 |
| HTTP 层异常（连接失败/超时/非 2xx/JSON 解析炸） | 预览：`send-time` 段用 try/catch 吞成警告；auth 段的异常冒泡到 `prepareRtspStream` 的 `catch (Exception)`，被包成 `Ride3ProConnectionException.fetchFailed("Failed to prepare Ride3Pro RTSP stream", e)`（`Ride3ProStreamRepositoryImpl.java:184-187`）；回放对应文案 `"Failed to prepare Ride3Pro playback RTSP stream"`（`Ride3ProPlaybackRepositoryImpl.java:1132-1134`） | 同左 |
| `CancellationException` | 原样重抛，不包装（`Ride3ProStreamRepositoryImpl.java:182-183`、`Ride3ProPlaybackRepositoryImpl.java:1127-1129`） | 同左 |
| `errorMessage` | `getErrorMessage()`：`info` 是 String 时 `"result=<n>, info=<str>"`，否则 `"result=<n>"`（`Ride3ProApiResponse.java:87-95`） | 同左 |

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
| key 的来源 | `Ride3ProSessionExecutorResolver.INSTANCE.current()` 的 `deviceIdentity` / `sessionId` / `routeRevision`；**executor 为 null 或 `deviceIdentity` 为 null 时返回 null key**，于是每次握手都走完整 auth（`Ride3ProStreamRepositoryImpl.java:127-134`、`Ride3ProPlaybackRepositoryImpl.java:144-151`） | 同左 |

### 3.2 `/api/rtspstatus?seed=`：形参与 auth 一致，但**没有任何业务调用点**

- 声明：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java:57-58`，`@GET("/api/rtspstatus") getRtspStatus(@Query("seed") long, Continuation<? super Ride3ProApiResponse<Object>>)`——**与 authDevice 同构**：一个 `long seed`、`info` 不解析。它的作用只可能是「查询设备当前是否允许起 RTSP 流 / 刷一流权限」，具体语义在设备侧，客户端代码里没有任何线索。
- 包装层：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionApiService.java:654-704`（`$seed` 透传给 `Ride3ProApiService.getRtspStatus`，调用点 `:688`）与 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java:397-447`（调用点 `:431`）。
- **全量检索结果**：`grep -rn "getRtspStatus" _work/tuwin_src/sources/com/tuwinsmart` 只命中 5 处，即接口声明（`Ride3ProApiService.java:58`）+ 两个包装类的协程体和 override（`Ride3ProSessionApiService.java:688,703`、`QueuedRide3ProApiService.java:431,446`）。两个 override 是 `implements Ride3ProApiService` 的**实现方**，不是调用方。
- 结论：官方 App 在预览/回放起流前**不发** `/api/rtspstatus`；起流失败的重试靠重跑 §3.1 的 prepare 流程。复现时可以不实现它。（注意 §2.1 第 15 行把「调用点」记成了这两个包装类，见 §8 纠正项 C-1。）

### 3.3 M3：`/app/getproductinfo` 之后拿什么

M3 没有鉴权，探测与会话建立是两段：

1. **探测段**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnector.java`）
   - `executeProbe` 用 PROBE grant 打 `GET /app/getproductinfo`（无 query），基址 `httpBaseUrl(host, 80)`（`:1883-1926`）。
   - OkHttp 构建时叠加 `endpointInterceptor(grant, revision)` 与 `M3HttpClientCompatibilityKt.applyM3HttpCompatibility`（`:1901-1902`），Retrofit 加 `GsonConverterFactory.create(new GsonBuilder().setLenient().create())`（`:1914`）。
   - **重试**：`M3SessionConnector$executeProbe$response$1.java:54` 调 `M3SessionConnectorKt.retryM3ProductInfoProbe(maxAttempts, retryDelayMillis, retryDelay, requireRouteActive, request)`；两个参数是 connector 的构造字段 `productInfoProbeMaxAttempts` / `productInfoProbeRetryDelayMillis`（`M3SessionConnector.java:81-83`、`:117-135`），默认常量 `M3_PRODUCT_INFO_PROBE_MAX_ATTEMPTS = 5`、`M3_PRODUCT_INFO_PROBE_RETRY_DELAY_MILLIS = 2000`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionConnectorKt.java:45-46`），`retryM3ProductInfoProbe$default` 的 bit1 直接写死 `i = 5`（`:185-193`）。默认延迟动作是 `DelayKt.delay(ms)`（内部类 `C19062.invokeSuspend`，`:166-181`）。connector 构造器还有两条前置校验：`maxAttempts <= 0` → `IllegalArgumentException("M3 product-info probe requires at least one attempt")`，`retryDelayMillis < 0` → `"M3 product-info probe retry delay cannot be negative"`（`M3SessionConnector.java:140-145`）。重试主体 `retryM3ProductInfoProbe` **JADX 反编译失败**（`M3SessionConnectorKt.java:129-135`，"Method dump skipped, instruction units count: 265"），所以「哪些异常参与重试」静态无解；从形参 `requireRouteActive: Function0<Unit>` 与 `DebugMetadata` 的局部名 `{delayBeforeRetry, requireRouteActive, request, maxAttempts, retryDelayMillis, attempt}`（`:54`）可确定它「每次重试前检查路由仍活跃 + 先 delay 再 request」，但**判定条件需要重跑反编译（`jadx --show-bad-code` 或 baksmali）才能逐条确认**。
   - 失败分支：`result != 0` → `IllegalStateException("M3 probe failed: " + errorMessage)`，`errorMessage` 为 null 时用字面量 `"device rejected request"`（`M3SessionConnector.java:1931-1936`）；`result == 0` 但 `parseDeviceInfo()` 为 null → `IllegalStateException("M3 probe response has no product info")`（`:1938-1941`；JADX 把 `== null` 渲染成了 `!= null`，语义按错误消息取反，与 §1.5 差异点 3 同一处）。
   - 探测产出的 `DeviceProbeResult` 只带 `model`，serial/firmware/boardVersion/features **全 null**（`:1942`）。
2. **会话段**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java` 的 `M3AdapterSession.open()`，`:169-440`），拿到 verified route 之后按序做：
   - 校验链（任一失败直接抛，不重试）：`deviceType != M3` → `IllegalArgumentException("M3 adapter cannot open <type>")`（`:206-208`）；无 route → `IllegalStateException("M3 session has no verified route")`（`:210-212`）；route 状态不在 `{VERIFIED, READY}` → `IllegalArgumentException("M3 route is not verified: <routeId>@<revision>")`（`:213-215`）；control grant 缺失或与 session/purpose/protocol/revision 不符 → `IllegalStateException("M3 session has no control EndpointGrant")` / `IllegalArgumentException("M3 control EndpointGrant does not match session route")`（`:216-222`）；identity 缺失 → `IllegalStateException("M3 session has no verified identity")`；model 不匹配 → `IllegalArgumentException("M3 model mismatch: <model>")`（`:227-233`，即 §1.5 的二次校验）。
   - **`getproductinfo` 之后拿的是 `/app/getmediainfo`**（协程 `M3DeviceAdapter$M3AdapterSession$open$mediaResponse$1`，`:234-241`），不是任何 auth 请求。响应 `result != 0` → `IllegalStateException("M3 media info request failed: <errorMessage>")`（`:356-358`）；`mediaInfo == null` → `IllegalStateException("M3 media response is not a valid success payload")`（`:360-362`）。
   - 由 `M3DynamicEndpointPolicy.parse(controlHost, media)` 一次算出两个端点：RTSP 媒体端点 + **TCP 事件端点**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DynamicEndpointPolicy.java:78`），随后 `issueMediaGrant`（RTSP）+ `issueSocketGrant`（TCP）（`M3DeviceAdapter.java:363-367`、`:916-922`），最后 `authorizeSocket` + `socketConnector.connect(network, grant.host, single(grant.allowedPorts), frameDecoderFactory())`（`:368-385`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter$M3AdapterSession$open$socket$1.java:55`）。TCP 细节见 §4。

### 3.4 Ride5：无鉴权，但有一段「反向回调注册」握手

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java` 的 `open()`：

1. control grant 校验（`:224-229`，两处 `IllegalArgumentException("Failed requirement.")`）。
2. `callbackIp = getSession().getCallbackIp()`，`trim` 后为空 → **`IllegalStateException("RIDE5 session requires an explicit callback IP")`（`:230-233`、`:363`）**，即 Ride5 没有可用回调 IP 时整个会话直接失败。
3. 签两张 grant：TCP grant（`allowedPorts = {9002}`、前缀 `{"/"}`）与 RTSP grant（`allowedPorts = {554}`、前缀 `{"/livestream"}`），`:250-251`。
4. `Ride5CallbackChannel.start()`——**先在手机上开 9002 服务端**（`:259`）。
5. `registerCallback(callbackIp)` → `client.cgi?-operation=register&-ip=<手机IP>`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:305` 传字面量 `"register"`，封装在 `:319-321`）。
6. `checkSocketConnect(callbackIp)` → `checkconnect.cgi?-ip=<手机IP>`（`Ride5CgiGateway.java:409`、封装 `:423`）。
7. `getDeviceAttributes()` → `getdeviceattr.cgi`（`Ride5DeviceAdapterSession.java:304`）。
8. 关闭时 `unregisterCallback(callbackIp)` → `client.cgi?-operation=unregister`（`Ride5CgiGateway.java:357`、`:371`；调用点 `Ride5DeviceAdapterSession.java:767-779`）。
9. 失败分支：第 4~7 步任一步抛（含 `Ride5CgiException.BusinessError/ProtocolError`）→ `close()` 整个 session 后重抛（`Ride5DeviceAdapterSession.java:308-360`）。

### 3.5 复现要点

1. Ride3Pro：`authdevice` 与 `send-time` 都要发，但**只有 auth 的失败会阻断**；auth 的 `-2` 必须当成功处理，否则首次连接会概率性失败。
2. Ride3Pro：10 分钟内同一 `(deviceIdentity, sessionId, routeRevision)` 可跳过 auth（等价实现：连接级缓存 auth 状态 10 分钟，用单调时钟计时）。
3. M3：`getmediainfo` 的 `port` 字段同时是**TCP 事件通道端口**（§4），所以 RTSP 端口和事件端口是设备分别给的，不能写死。
4. Ride5：不提供手机侧回调 IP 就不要尝试建会话；`register` 必须在本地 9002 监听起来之后发。

---

## 4. M3 TCP 通道

（待填）

---

## 5. Ride3Pro 菜单 XML 协议

（待填）

---

## 6. 请求队列与串行化

（待填）

---

## 7. RTSP 端点

（待填）

---

## 8. 对既有文档的纠正

（待填）
