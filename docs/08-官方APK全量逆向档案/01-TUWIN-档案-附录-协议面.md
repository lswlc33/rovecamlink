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
