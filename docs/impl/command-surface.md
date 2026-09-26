# 我们已实现的命令面与操作面（RoveCamLink 自研侧盘点）

> **doc-id** `impl/command-surface` · **层** 实现（我们侧台账）· **状态** 2026-09-22 快照，§0 有 2026-09-26 复核；与代码冲突时以代码为准 · **建档** 2026-09-22 · **修订** 2026-09-26
> 文档系统 [`docs/README.md`](../README.md) · 旧名 `附录A-我们已实现的命令面.md`

> 本文只盘点**我们自己仓库里已经实现的东西**：协议接口每个方法、每条实际发出的请求（精确到字符串）、设置项 id 全集、UI 操作入口、已知不实现的部分。
> 官方 APK 发了什么不在本文范围，见 `docs/evidence/tuwin` / `docs/evidence/xtugo` / `docs/evidence/idgolive` 三份档案；两侧的差距与落地顺序在 [三家操作对照](../evidence/operations-matrix.md)。
> 盘点基准：本文写作时的 `main` 工作区代码；全部行号已用 Read 核对。
> 建档日期：2026-09-22。

---

## 0. 覆盖度小结

> ⚠️ **2026-09-26 时效说明**：本文 §1–§6 的逐条记录是 **2026-09-22 的快照**；此后落地的 iCatch 双 profile 插件与 XTU RTMP 直播推流**没有逐行回写**。本次复核能就地改正的已改（§0.1 插件表、§0.2 第 1/8 条、§0.3 接口成员数），其余行以**代码**与 `docs/evidence/operations-matrix` 为准，看到可疑处就地改。

### 0.1 已注册 / 未注册的插件

| 插件 | 平台 | 注册处 | 状态 |
|---|---|---|---|
| `HisiliconProtocol`（XTU Hi35xx CGI） | `DevicePlatform.HISILICON` | `composeApp/src/commonMain/kotlin/com/rovecamlink/app/AppGraph.kt:27` | **主力实现**，唯一有 OTA 通道的平台（`AppState.kt:926-927`） |
| `TuwinRestProtocol`（TUWIN REST） | `DevicePlatform.TUWIN_REST` | `AppGraph.kt:28` | 已实现，但**无 OTA 传输**、无逐事件推送 |
| （BLE 配网）`XtuBleProfile` | — | `AppGraph.kt:53`（`bleProfiles` 列表只有 XTU 一家） | 已实现 R003/R001/R002 握手 |
| `IcatchHttpProtocol`（idGoLive 系行车记录仪） | `DevicePlatform.ICATCH` | `AppGraph.kt:48` | **2026-09-25 起已注册**：Novatek `.254` + Qz `.169.1` 双 HTTP profile；设计见 `docs/design/specs/2026-09-25-icatch-http-profiles` |
| AMBARELLA / SIGMASTAR / TUWIN_M3 | 枚举存在于 `core/model/Models.kt:19-39` | 未注册 | **无协议实现**：`probe` 永远不会命中，`protocolFor()` 返回 null（`core/protocol/CameraProtocol.kt:146`） |

### 0.2 与三家官方 App 操作面的对照（依据仅来自我们代码）

**我们已经覆盖的操作**（官方三家共同的核心操作集）：

- 连接建立：Wi-Fi 列表连接 / 二维码 / 手输 IP / 固定网关探测（`core/net/DeviceDiscovery.kt:26-35,70-90`；`AppState.kt:416-558`）；
- 蓝牙配网（XTU：`core/ble/XtuBleProfile.kt:206-208`）；
- 实时状态轮询（电量/SD/录制态/工作模式/录制时长，1.5 s 一轮，`AppState.kt:628-675,1135`）；
- 录像开始/停止（`record`）、拍照（`capture`）、视频/照片模式切换（`setMode`）；
- 回放文件列表、缩略图、下载（断点续传）、单删/批删；
- 设置菜单读取（NewAPP 全量动态菜单 + legacy 11 项）、单项写入 + 单条回读（`readBack`）；
- SD 格式化、恢复出厂、对时（连接时自动执行，`AppState.kt:537-541`）、改相机 Wi-Fi 名称/密码、远程重启（仅 TUWIN REST）、设备静态信息、OTA（仅海思：上传 + 触发 + 版本确认闭环，`core/ota/Ota.kt:89-142`）；
- 实时预览 URL 构建（RTSP）。

**明显缺失 / 不做的部分**：

1. ~~**idGoLive / iCatch PTP 平台完全没有插件**~~ **已过时（2026-09-25）**：`IcatchHttpProtocol` 已注册，覆盖 idGoLive 系的 Novatek `.254` 与 Qz `.169.1` 两条 HTTP profile（XTU Mini1 与 idGoLive 上榜机型因此由「未适配」翻成「已适配」）。仍未覆盖的是该平台的 **PTP / 原生 TCP 通道**与库里其它 `ICATCH` 机型；
2. **XTU 的 Ambarella 机型（S7 / S7Pro Max）与 TUWIN M3/R5 平台**：`HisiliconProtocol.kt:56-63` 明确只认领 `XTUCam_` 前缀、`TuwinRestProtocol.kt:58` 只认领 `TUWIN_R3P_` / `TUWIN_R6_`，其余名字不固定网关、探测也不一定有人应；
3. **海思没有重启命令**：`reboot` 直接返回 Failure（`HisiliconProtocol.kt:668-669`），UI 仅在 TUWIN REST 平台显示重启入口（`ui/Screens.kt:1327-1333`）；
4. **海思没有 APP 可控的回放工作模式**：`setMode(PLAYBACK)` 固定拒绝（`HisiliconProtocol.kt:367-372`），UI 的分段控件也只提供 VIDEO/PHOTO 两档（`Screens.kt:699`）；
5. **OTA 只有海思一条通道**：`AppState.kt:922-927` 的 `firmwareUpdateSupported()` 只认 HISILICON，其他平台按钮显示「不支持」；
6. **接口上挂默认实现、没有任何插件覆写的**：`readBack` 在 Tuwin/legacy 海思下为 null（`CameraProtocol.kt:67`）、`onSessionClosed` 只有海思覆写（`HisiliconProtocol.kt:200-205`）——见 §6；
7. **无 GPS/轨迹、无相机固件侧的 language.xml 拉取**（`ui/MenuCatalog.kt:43-51` 说明官方中文词条来自相机 8080 端口，我们尚未取），菜单中文是我们自备的；
8. ~~直播推流~~ **已过时（2026-09-25）**：`supportsLive` / `startLive` 已进 `CameraProtocol`，海思机型由 `brand/xtu/XtuRtmpPush.kt` 走 TCP 8080 的 `RECV_RTMP` 帧下发参数（`ui/LivePushScreens.kt` 提供设置与本地预览，`live_type` 恒 `tiktokCN`，这条通道**没有停止命令**）。协议接口上仍未定义、因而整体不做的是：相机侧相册编辑、多相机、云账号（全文见 §1）。

### 0.3 数量统计

| 计数 | 数量 |
|---|---|
| 海思 CGI/媒体请求模板（§3.A 编号） | **39** 条（H-01~H-39；含 legacy 各 11 条 getter/setter 模板、OTA 3 条；其中 H-15/H-34 为「无请求、本地即拒」占位） |
| TUWIN REST 请求模板（§3.B 编号） | **23** 条（T-01~T-23；`setparameter` 被 4 个用途复用，H/T 媒体下载与缩略图为 URL 模板非独立命令） |
| BLE 写帧命令（§3.C） | **3** 条（R003_ / R001_ / R002_ + 4 位自造码；B-04 为重试节奏说明） |
| 合计逐条盘点记录（§3） | **65** 条编号 |
| 我们认识的设置项 id | NewAPP 菜单 **20** + legacy **11** + TUWIN **6** |
| CameraProtocol 接口成员 | ~~20 个方法 + 4 个属性~~ **2026-09-26 复核：37 个方法 + 11 个属性**（§1 的逐成员表仍是 09-22 快照，未回写） |

---

## 1. CameraProtocol 接口逐成员盘点

文件：`composeApp/src/commonMain/kotlin/com/rovecamlink/app/core/protocol/CameraProtocol.kt`

| 成员 | 签名 | 语义（按注释） | HisiliconProtocol | TuwinRestProtocol |
|---|---|---|---|---|
| `platform` | `val platform: DevicePlatform`（:21） | 一个实现对应一个平台，插件按此键注册 | 覆写 :54 = `HISILICON` | 覆写 :50 = `TUWIN_REST` |
| `wifiSsidPrefixes` | `val: List<String>`，默认 `emptyList()`（:29） | 该家族热点的 SSID 前缀，供连接页判定品牌/固定地址 | 覆写 :63 = `["XTUCam_"]` | 覆写 :58 = `["TUWIN_R3P_","TUWIN_R6_"]` |
| `fixedHost` | `val: String?`，默认 `null`（:39） | 相机 AP 固定应答地址；null=要遍历候选 | 覆写 :66 = `"192.168.0.1"` | 覆写 :61 = `"192.168.25.1"` |
| `defaultWifiPassword` | `val: String?`，默认 `null`（:46） | 出厂固定热点密码，仅在蓝牙与已存凭据都拿不到时兜底 | 覆写 :69 = `"12345678"` | 覆写 :64 = `"12345678"` |
| `probe` | `suspend (host,port): Boolean`（:52） | 廉价探测：设备是否说本协议；自动识别选插件 | 覆写 :80-88 | 覆写 :70-75 |
| `connect` | `suspend (host,port): CameraSession`（:55） | 建立会话（需要的协议在此鉴权） | 覆写 :90-116 | 覆写 :77-96 |
| `getStatus` | `suspend (session): DeviceStatus`（:57） | 轮询实时状态 | 覆写 :223-267 | 覆写 :98-116 |
| `getSettings` | `suspend (session): List<CameraSetting>`（:58） | 拉取设置菜单 | 覆写 :444-491 | 覆写 :118-126 |
| `setSetting` | `suspend (session,id,value): CmdResult`（:59） | 写单项设置 | 覆写 :496-530 | 覆写 :128-131 |
| `readBack` | `suspend (session,id): CameraSetting?`，**默认 null**（:67） | 写入后单条廉价回读；null=「没有廉价回读，本地更新」 | **覆写** :539-547（仅 newApp 生效，legacy 返回 null :540） | **未覆写 = 默认 null** |
| `setMode` | `suspend (session,WorkMode): CmdResult`（:69） | 切工作模式 | 覆写 :365-403 | 覆写 :133-136 |
| `capture` | `suspend (session): CmdResult`（:70） | 拍照 | 覆写 :320-348 | 覆写 :138-141 |
| `record` | `suspend (session,start: Boolean): CmdResult`（:71） | 录像起停 | 覆写 :350-363 | 覆写 :143-147 |
| `listFiles` | `suspend (session,start,end): List<RemoteFile>`（:73） | 分页列文件 | 覆写 :552-588 | 覆写 :149-176 |
| `deleteFile` | `suspend (session,RemoteFile): CmdResult`（:74） | 删文件 | 覆写 :624-627 | 覆写 :178-181 |
| `thumbnail` | `suspend (session,RemoteFile): ByteArray?`（:75） | 取缩略图字节 | 覆写 :629-630 | 覆写 :183-184 |
| `download` | `suspend (session,file,dest,alreadyHaveBytes,onProgress): Long`（:82-88） | 流式下载到本地，支持断点续传；-1=失败/截断 | 覆写 :632-638 | 覆写 :186-192 |
| `previewUrl` | `fun (session): String`（:91） | 实时预览的 RTSP 地址 | 覆写 :640-641 | 覆写 :194-195 |
| `getDeviceInfo` | `suspend (session): DeviceInfo?`（:94） | About 页静态身份信息 | 覆写 :645-656 | 覆写 :199-211 |
| `formatSd` | `suspend (session): CmdResult`（:97） | 格式化 SD（破坏性，UI 须二次确认） | 覆写 :658-661 | 覆写 :213-216 |
| `factoryReset` | `suspend (session): CmdResult`（:100） | 恢复出厂 | 覆写 :663-666 | 覆写 :218-223 |
| `reboot` | `suspend (session): CmdResult`（:103） | 远程重启；无重启命令的相机返回 Failure | 覆写 :668-669（**恒 Failure**） | 覆写 :225-228 |
| `syncTime` | `suspend (session): CmdResult`（:106） | 把相机时钟置为手机本地时间 | 覆写 :671-678 | 覆写 :230-237 |
| `setWifi` | `suspend (session,ssid,password): CmdResult`（:109） | 改相机自己的热点名/密码 | 覆写 :680-685 | 覆写 :239-250 |
| `onSessionClosed` | `fun (session)`，**默认空体**（:116） | 会话结束时丢弃按 host 缓存的固件事实 | **覆写** :200-205 | 未覆写（其无缓存，可接受） |
| `events` | `val Flow<DeviceEvent>`（:119） | 可选事件流 | 覆写 :73（仅 `RecordingChanged`，由 `record` :357 发出） | 覆写 :68（仅 `RecordingChanged`，由 `record` :145 发出） |

**默认实现 = 不支持，当前无人覆写的只有 `readBack` 的 Tuwin 路径与 `onSessionClosed` 的 Tuwin 路径。** `DeviceEvent.BatteryChanged` / `Disconnected` 两个事件（`core/model/Models.kt:196-201`）没有任何协议代码发射，UI 的 `collectEvents` 消费分支（`AppState.kt:566-589`）目前只能被 `RecordingChanged` 和 Wi-Fi 断链路径触发。

注册器 `CameraProtocolRegistry`（`CameraProtocol.kt:137-162`）：`protocolFor` 按平台取插件；`forSsid` 按 SSID 前缀（长前缀优先，:141-144）；`fixedHostFor` / `defaultPasswordFor` 据此给出固定地址与出厂密码。

---

## 2. 成功判据的统一规则

### 2.1 海思 CGI：`Cgi.verdict`（`brand/xtu/CgiReply.kt:36-46`）

HTTP 200 在本协议上没有意义（thttpd 拒绝命令也回 200，`CgiReply.kt:5-13`）。真判据在响应体：

| 响应体 | 判定 |
|---|---|
| 空 / 完全无应答 | `NoAnswer`（:37-39）→ `CmdResult.Failure` |
| 含 `SvrFuncResult="<code>"` | `Rejected(code)`（:40-41）；十六进制补码先归一为十进制（`normaliseCode` :56-62，`0xFFFFF752` ≡ `-2222`） |
| 含 `sd is not ready` / `sd is full`（不分大小写） | `Rejected`（:42-44，:48-49） |
| 其它任何非空体（惯例是含 `Success`，:30） | `Accepted`（:45） |

错误文案表：`Cgi.explain`（:88-93）——`-2222`＝「参数/名称在当前模式下无效」；两条 SD 文案原样。参数值百分号编码：`Cgi.param`（:72-79），未保留字符之外的字节全部转 `%XX`（支持 `Normal Video`、`360° Horizon Correction` 这类含空格/非 ASCII 值，:65-70）。

`var k="v";` 解析器：`brand/xtu/HiVarParser.kt:24-63` —— 语句不保证一行一条（`getprimarymenuitem` 两变量同一行，:12-19），因此扫描任意位置的 `var k="v"`，不依赖行边界与结尾分号。

### 2.2 海思部分 GET：`body != null` 即 Ok

`deleteFile`（`HisiliconProtocol.kt:626`）、`formatSd`（:660）、`factoryReset`（:665）、`syncTime`（:677）、`setWifi`（:684）、`listFiles` 判空（:557-587）：只看「相机有没有回 2xx 且非空」，**不做 `SvrFuncResult` 判定** —— 见 §6 已知弱点。

### 2.3 TUWIN REST：`body != null` 即 Ok

所有写命令统一 `if (r != null) CmdResult.Ok else CmdResult.Failure(...)`（`brand/tuwin/TuwinRestProtocol.kt:129-131` 等）。**没有任何一处解析 JSON 里的错误字段。** 工作模式枚举：`VIDEO(code=0)/PHOTO(1)/PLAYBACK(2)`（`core/model/Models.kt:53-57`）。

### 2.4 海思 work state 前置门槛（发请求之前就会拒绝）

| 码值 | 常量 | 含义与用途 |
|---|---|---|
| 20 | `STATE_WORKING`（`HisiliconProtocol.kt:140`） | 忙：录像中或正在出图。`capture` 非 21 即拒（:323-328）；`setMode` 为 20 即拒（:374-376） |
| 21 | `STATE_STANDBY`（:143） | 空闲，接受控制命令 |

状态来源 `peekWorkState`（:312-318，单发一次 `getcurallinfo`）；模式族判定 `isVideoModeName`（:269-280）先查 `getallworkmode` 表、查不到时按名字兜底（含 video/car/loop/slow/rec → 视频族）。`pasttime` 单位＝秒（`PASTTIME_TICKS_PER_SECOND = 1`，:145-158 有 S7PRO 实测推导）。整数模式映射：20..26→VIDEO、0..12→PHOTO（:287-288）。

---

## 3. 逐条请求盘点

海思 CGI 基址：`private fun cgi(host, port) = "http://$host:$port/cgi-bin/hi3510"`（`HisiliconProtocol.kt:75`）；媒体基址 `http://$host:$port`（:76）。下文 H-02 起省略前缀时即为该 cgi 基址；`{H}`=host、`{P}`=port（会话默认 80，`AppState.kt:445`）。
TUWIN 基址：`session.baseUrl = "http://$host:$port"`（`core/model/Models.kt:78`）。
调用频率列：**轮询** = 状态轮询每 1.5 s（`AppState.kt:628-675` + `POLL_INTERVAL_MS=1500` :1135）；**每次写后** = `runOperation` 收尾额外拉一次 getStatus（`AppState.kt:1107`）。

### 3.A XTU 海思 CGI（`brand/xtu/HisiliconProtocol.kt` + `HisiliconOtaTransport.kt`，39 条编号记录）

| # | 调用方法 | 精确模板 | 参数取值 | 期望响应字段 | 成功判据 | 代码位置 | 频率 |
|---|---|---|---|---|---|---|---|
| H-01 | `probe` | `GET …/getdeviceattr.cgi`（无 query） | — | 文本含 `var ` 或 `name=` 或 `"name"` 之一 | 三条件之一成立即 true | :80-88 | 识别每个候选 host 一次（`DeviceDiscovery.kt:37-57`） |
| H-02 | `connect` | `GET …/getdeviceattr.cgi` | — | `name`（空则退 `model`，再空则 `"XTU Hi35xx"`）、`hardversion`（`=="NewAPP"` → newApp）、`softversion`、`type`（缺省 `"117"`） | 解析成功；解析失败 → `error("getdeviceattr.cgi gave no answer…")` 抛异常 | :90-116（字段 :92-115） | 每次连接 |
| H-03 | `connect`（仅 newApp） | `GET …/getcurworkmode.cgi` | — | `workmode`（退 `value`），取 CSV 第一段为当前模式串 | 有值即记录；空则维持 `"NormalVideo"` | :99-102 | 每次连接 |
| H-04 | `currentStrMode(refresh)` | `GET …/getcurworkmode.cgi` | — | 同 H-03 | 同 H-03；结果按 host 缓存（:127-135） | :129-135 | 每次 `getSettings` 全量刷新（:449）；写参数时读缓存（:506） |
| H-05 | `workModeNames` | `GET …/getallworkmode.cgi` | — | `video`、`photo` 两组名字（CSV 切分 :213-214） | 非空即缓存；**空则记入 `workModeUnsupported` 不再重试**（:193-196） | :182-197 | 首用后按 host 缓存；会话结束清除（:200-205） |
| H-06 | `getStatus` | `GET …/getcurallinfo.cgi` | — | `state`（20/21）、`mode`、`pasttime` | 解析为 null 时退 H-07 | :225-226 | **轮询** |
| H-07 | `getStatus`（H-06 后备） | `GET …/getallinfo.cgi` | — | 同 H-06 | 同上 | :226 | 轮询（仅 H-06 无应答时） |
| H-08 | `getStatus` | `GET …/getbatterycapacity.cgi?`（**保留裸 `?`**） | — | `capacity`（钳 0..100，:252）、`charge` 退 `ac`（:253） | 解析（可缺） | :228 | 轮询 |
| H-09 | `getStatus` | `GET …/getsdstate.cgi?` | — | `total`/`used`（`mb()` 单位换算：`"59882 MB"`→59882，`HiVarParser.kt:75-90`）、`sdstate`（:263 → `SdCardState.fromRaw`，`Models.kt:86-96`）；free=total-used（:249） | 解析（可缺） | :229 | 轮询 |
| H-10 | `getStatus` | `GET …/getfilecount.cgi?` | — | `count`（:264） | 解析（可缺） | :230 | 轮询 |
| H-11 | `getStatus`（仅 `state` 缺失时） | `GET …/getcamerastatus.cgi` | — | `status`（:243,258）、`pasttime`（:259） | 解析（可缺）；注释：S7PRO 上此 CGI 回 200 空体，故不作首选（:232-234） | :236-240 | 轮询（条件） |
| H-12 | `peekWorkState` | `GET …/getcurallinfo.cgi` →退 `…/getallinfo.cgi` | — | `state`、`mode` | 解析（可缺，缺=放行） | :312-318 | 每次 `capture` / `setMode` 前置检查 |
| H-13 | `capture` | `GET …/photo.cgi?-type=photo&-cmd=start`（newApp）；`GET …/photo.cgi?&-type=photo`（legacy） | 两种方言（:335-338） | 命令体 | §2.1 `verdict`；前置：`state!=21` 直接 Failure（:323-328）；视频模式下拍照直接拒（:329-334） | :320-348（URL :338-339） | 每次拍照 |
| H-14 | `record` | `GET …/record.cgi?&-cmd=start` / `…?&-cmd=stop` | `start`/`stop` | 命令体 | `verdict`；Accepted 后 `_events.tryEmit(RecordingChanged(start))`（:357） | :350-363 | 每次录像键 |
| H-15 | `setMode(PLAYBACK)` | —— 不发请求 | — | — | 恒 `CmdResult.Failure("This camera has no app-controlled playback mode…")` | :367-372 | — |
| H-16 | `setMode`（newApp） | `GET …/setcurworkmode.cgi?-workmode=<Cgi.param(名称)>` | 名称取自 H-05 表，回退串 `"Normal Video"` / `"Normal Photo"`（:161-162,379）；**当前模式与目标同名时跳过请求直接 Ok**（:382-385） | 命令体 | `verdict`；Ok 后 `invalidateModeCache`（:397, 208-211） | :377-403（URL :386） | 每次切模式 |
| H-17 | `setMode`（legacy） | `GET …/setworkmode.cgi?&-workmode=<int>` | VIDEO→`20`、其他→`0`（:388） | 命令体 | `verdict` | :388-390 | 每次切模式 |
| H-18 | `getSettings`（newApp） | `GET …/getprimarymenuitem.cgi?-workmode=<param(当前模式)>` | 模式串 | `item`、`cur` 两变量（同体多变量，`HiMenu.kt:23-28`） | 非空即用；空则退 legacy（:478） | :449-456 | 每次设置页加载/模式切换 |
| H-19 | `getSettings`（newApp，逐条） | `GET …/getsecondmenuitem.cgi?-workmode=<param(模式)>&-name=<param(条目名)>` | — | `item`=选项 CSV、`value` 退 `cur`=当前值（`HiMenu.kt:34-46`） | 含 `SvrFuncResult` → 该条**整条丢弃**（:462-467） | :457-476 | 每条目一次（N 条 = N 请求，:536-537 注释记录了代价） |
| H-20 | `setSetting`（newApp） | `GET …/setcurparameter.cgi?-workmode=<param(模式)>&-name=<param(id)>&-value=<param(值)>` | id/值＝相机自己的菜单字符串 | 命令体 | `verdict`；前置：id 不在 H-18 缓存菜单内 → 本地直接 Failure「"$id" is not a setting of the current mode」（:501-505） | :498-517（URL :506-507） | 每次改设置 |
| H-21 | `readBack`（仅 newApp） | `GET …/getsecondmenuitem.cgi?-workmode=<param(模式)>&-name=<param(id)>` | — | 同 H-19 | 返回该条 `CameraSetting`；被拒 → null（:545） | :539-547 | 每次 `setSetting` 成功后一条（`AppState.kt:742`） |
| H-22 | `getSettings`（legacy） | `GET …/{getter}?` ×11（模板见 §4.2） | — | 各自的 getKey（如 `resolution`/`enable`/`time`） | 该 key 有值才把该项放进列表；无应答=跳过（:481-488） | :430-442, 481-488 | 每次 legacy 设置加载，11 请求 |
| H-23 | `setSetting`（legacy） | `GET …/{setter}`（`%s` 代入值，模板见 §4.2） | 布尔项 `1`/`0`（选项表 :484-486） | 命令体 | `verdict`；未知 id → `Failure("Unknown setting $id")`（:518-519） | :518-530 | 每次改设置 |
| H-24 | `listFiles` | `GET …/getfilelistinfoios.cgi?&-start={start}&-end={end}` | **UI 固定发 `0..999`**（`AppState.kt:767`） | JSON 数组：`path`（必填）、`size`、`create`（`yyyyMMddHHmmss`，:608-622） | 能 parse 成数组即成功；非数组仅记 WARN 后退 H-25（:559-565） | :552-578 | 每次刷新列表 |
| H-25 | `listFiles`（后备） | `GET …/getfilelist.cgi?&-start={start}&-end={end}` | 同上 | 分号分隔的文件名（无大小/日期） | 非空即成功；两路全空 → 空列表（:582-585） | :579-587 | 列表刷新 |
| H-26 | 文件类型判定/下载 URL | `downloadUrl = "http://{H}:{P}/<path>"`；`.mp4/.lrv/.mov`→VIDEO，`.jpg/.jpeg/.dng/.png`→PHOTO，其余 UNKNOWN | :590-606 | — | — | :592-603 | 列文件时 |
| H-27 | `deleteFile` | `GET …/deletefile.cgi?&-name={name}` | `name`＝列表返回的完整路径（如 `video/20260921120000.mp4`），**原样拼接、不做编码**（:625） | 命令体 | **`body != null` 即 Ok**（不判 `verdict`） | :624-627 | 每次删除（批删=循环逐条，`AppState.kt:850-863`） |
| H-28 | `thumbnail` | `GET {file.thumbnailUrl}`；视频＝扩展名替换为 `.THM` 的旁路文件（:597），未知退 `downloadUrl` | — | 图片字节 | 2xx 字节非空即可（解码失败只是本地不缓存，`AppState.kt:796-821`） | :629-630 | 每个可见文件行一次（`Screens.kt:834`） |
| H-29 | `download` | `GET {file.downloadUrl}`（流式） | `Range: bytes={have}-`（仅 `have>0` 时，`core/transport/CameraHttp.kt:178`） | 响应体=文件本体 | **206** 才认可续传（:185-187：200 会忽略 Range 并从 0 重写）；`written == expectedTotal` 才算完成，截断记 -1（:230-237）；上层再比对 `sizeBytes`（`AppState.kt:1026-1033`） | :632-638 | 每次下载 |
| H-30 | `previewUrl` | 不请求：`rtsp://{H}:554/livestream/12` | 官方 App 唯一路径；`/11=高码率` 属讹传（:47-50） | — | — | :640-641 | UI 渲染时（`Screens.kt:553`） |
| H-31 | `getDeviceInfo` | `GET …/getdeviceattr.cgi` | — | `name`、`model`、`serialnum`、`softversion`、`hardversion`、`region`（:648-653）+ raw 全量 | 解析非 null；UI 对 `model="0"`/`serialnum="1"` 这类占位值做防假显示（`Screens.kt:1215-1228`） | :645-656 | 连接后 + 手动刷新 |
| H-32 | `formatSd` | `GET …/sdcommand.cgi?-format&-partition=1` | `partition=1` | 命令体（不判 `verdict`） | **`body != null` 即 Ok** | :658-661 | 手动；成功后重列 + 重读状态（`AppState.kt:885-898`） |
| H-33 | `factoryReset` | `GET …/reset.cgi` | — | 命令体 | `body != null` 即 Ok | :663-666 | 手动 |
| H-34 | `reboot` | —— 无请求 | — | — | **恒 Failure("Reboot is not supported on this camera")** | :668-669 | UI 不显示（`Screens.kt:1327`） |
| H-35 | `syncTime` | `GET …/setsystime.cgi?-time=<yyyyMMddHHmmss>` | 手机当前本地时间（:672-674，`zeroPad` 来自 `core/ota/FirmwareVersion.kt`） | 命令体 | `body != null` 即 Ok | :671-678 | **连接成功后自动**、best-effort（`AppState.kt:537-541`） |
| H-36 | `setWifi` | `GET …/setwifi.cgi?&-wifissid=<enc(ssid)>&-wifikey=<enc(pwd)>` | 本地弱编码：仅空格→`%20`、`&`、`=`、`+`（:687-688），**非完整百分号编码** | 命令体 | `body != null` 即 Ok；日志不记密码（:682） | :680-685 | 手动保存 |
| H-37 | OTA 版本读 | `GET …/getdeviceattr.cgi` | — | `softversion`（`\d{8}` 日期戳，`brand/xtu/HisiliconOtaTransport.kt:29-32`） | 非空字符串 | HisiliconOtaTransport.kt:30 | OTA 前/重启确认轮询（2 s 一次，`core/ota/Ota.kt:149-162`） |
| H-38 | OTA 上传 | `POST …/fileupload.cgi` | `multipart/form-data`，boundary=`"RoveCamLinkFW-"+Random.nextLong().toString(16)`；唯一部件 `Content-Disposition: form-data; name="sd"; filename="<包名>"` + `Content-Type: application/octet-stream`（:59-74） | 响应文本 | `post` 返回非 null（HTTP 成功，`CameraHttp.kt:128-155`）；否则 `Failure("fileupload.cgi did not accept the package")` | HisiliconOtaTransport.kt:40-49 | 每次 OTA |
| H-39 | OTA 触发 | `GET …/upgrade.cgi`（无参数） | — | 响应文本 | 非 null 即 `CmdResult.Ok`（:55） | HisiliconOtaTransport.kt:53-56 | 上传成功后 |

### 3.B TUWIN REST（`brand/tuwin/TuwinRestProtocol.kt`，23 条编号记录）

| # | 调用方法 | 精确模板 | 参数取值 | 期望响应字段 | 成功判据 | 代码位置 | 频率 |
|---|---|---|---|---|---|---|---|
| T-01 | `probe` | `GET http://{H}:{P}/api/device/status` | — | 文本含 `status`（不分大小写）或以 `{` 开头 | 二选一成立即 true | :70-75 | 识别时 |
| T-02 | `connect` | `GET /api/authdevice?seed={seed}` | `seed = Random.nextLong(Long.MAX_VALUE).toString()`（:79） | `token`（可缺） | 有应答即继续；token 缺则**用 seed 当 authToken**（:94） | :81-84 | 每次连接 |
| T-03 | `connect` | `GET /api/rtspstatus?seed={seed}` | 同 seed | 忽略 | 返回值不参与判定（纯发一次） | :84 | 每次连接 |
| T-04 | `connect` | `GET /api/device/info` | — | `model`（缺 → `"TUWIN"`） | 解析成功；异常退 null | :85-87 | 每次连接 |
| T-05 | `getStatus` | `GET /api/device/status` | — | `battery`/`batterylevel`、`record`/`recording`（**==1 才算录像**）、`mode`（int→`WorkMode.fromCode`）、`recordtime`/`videotime` | 解析（可缺） | :100,104-108 | 轮询 |
| T-06 | `getStatus` | `GET /api/sd/info` | — | `total`/`totalspace`、`free`/`freespace`/`available`、`status`（→`SdCardState.fromRaw`）、`photocount`、`videocount` | 解析（可缺） | :101,109-113 | 轮询 |
| T-07 | `getSettings` | `GET /api/menu/getparameter?id={id}` ×6 | id ∈ 固定表：`resolution, bitrate, exposure, whitebalance, wdr, audio`（:120） | JSON `value`；不是 JSON 时整段文本当值（:122-123） | 非 null 即成一项；无应答=跳过 | :118-126 | 每次设置加载（6 请求） |
| T-08 | `setSetting` | `GET /api/menu/setparameter?id={id}&value={value}` | **id 与 value 不做任何 URL 编码**（:129） | 任意非空 | `body != null` 即 Ok | :128-131 | 每次改设置 |
| T-09 | `factoryReset` | `GET /api/menu/setparameter?id=factory_reset&value=1` | 固定 | 任意非空 | `body != null` 即 Ok | :218-223 | 手动 |
| T-10 | `setWifi` | `GET /api/menu/setparameter?id=wifi_name&value={enc(ssid)}` 然后 `id=wifi_passwd&value={enc(pwd)}` | 两条按序各一发；空格→`%20`、`&`、`=`（:252-253） | 任意非空 | **两条都非 null 才 Ok** | :239-250 | 手动保存 |
| T-11 | `setMode` | `GET /api/setmode?mode={code}` | `mode.code`：VIDEO=0 / PHOTO=1 / PLAYBACK=2（`Models.kt:53-57`） | 任意非空 | `body != null` 即 Ok（**PLAYBACK 可发送**，与海思不同） | :133-136 | 每次切模式 |
| T-12 | `capture` | `GET /api/capture` | — | 任意非空 | `body != null` 即 Ok；无 busy/模式前置检查 | :138-141 | 每次拍照 |
| T-13 | `record` | `GET /api/record/start` / `GET /api/record/stop` | 路径段 | 任意非空 | `body != null` 即 Ok；**无论成败都发 `RecordingChanged(start)`**（:145） | :143-147 | 每次录像键 |
| T-14 | `listFiles` | `GET /api/playback/filelist?start={start}&end={end}` | UI 固定 `0..999`（`AppState.kt:767`） | `{files:[…]}` 或裸数组；每项 `name`/`filename`、`type`、`size`、`url`、`time`/`date` | 数组解析成功；形状不对 → 空列表（:152-158） | :149-176 | 每次刷新 |
| T-15 | 下载/缩略图 URL 构造 | `downloadUrl` = `url` 字段绝对化（`absolute`，:256-257）或 `GET /api/playback/download?file={name}`；`thumbnailUrl` = `GET /api/playback/thumbnail?file={name}` | :168-170 | — | — | :159-173 | 列文件时 |
| T-16 | `deleteFile` | `GET /api/playback/delete?file={name}` | — | 任意非空 | `body != null` 即 Ok | :178-181 | 每次删除（批删=循环逐条，`AppState.kt:850-863`） |
| T-17 | `thumbnail` | `GET {thumbnailUrl}`（缺则回退 `/api/playback/thumbnail?file={name}`） | — | 图片字节 | 2xx 字节 | :183-184 | 每可见文件行 |
| T-18 | `download` | `GET {downloadUrl}`（流式，复用 `CameraHttp.download`，Range/截断规则同 H-29） | — | — | 同 H-29 | :186-192 | 每次下载 |
| T-19 | `getDeviceInfo` | `GET /api/device/info` | — | `model`、`swver`、`hwver`、`uuid`、`mac`、`ssid`、`soc`（:202-209） | 解析非 null | :199-211 | 连接后 + 手动刷新 |
| T-20 | `formatSd` | `GET /api/system/formatsd` | — | 任意非空 | `body != null` 即 Ok | :213-216 | 手动 |
| T-21 | `reboot` | `GET /api/reboot` | — | 任意非空 | `body != null` 即 Ok（**唯一有重启的平台**） | :225-228 | 手动（UI 仅 TUWIN_REST 显示，`Screens.kt:1327-1333`） |
| T-22 | `syncTime` | `GET /api/vendor/send-time?year={y}&month={M}&day={d}&hour={h}&minute={m}&second={s}` | 手机本地时间，**month/day 不补零**（:231-234） | 任意非空 | `body != null` 即 Ok | :230-237 | 连接后自动 |
| T-23 | `previewUrl` | 不请求：`rtsp://{H}:8080/?action=stream` | — | — | — | :194-195 | UI 渲染 |

### 3.C BLE 配网线（`core/ble/XtuBleProfile.kt`，3 条写帧；无 HTTP）

GATT：命令特征 `00008888-0000-1000-8000-00805f9b34fb`、CCCD `00002902-…`（`androidMain/…/BleCentral.android.kt:459-460`；优选顺序 `:358-368`）。广播名匹配前缀 `XTU`（`XtuBleProfile.kt:38`）。配对码＝手机自造的 4 位十进制（`newPairingKey`，:55-57），**相机不向用户要码**。

| # | 阶段 | 写入帧（精确） | 期望通知字段 | 推进条件 | 代码位置 |
|---|---|---|---|---|---|
| B-01 | Pairing | `R003_<码>` | `Status`、`KEY`、`Pin`（键名大小写敏感：`BleReply.kt:80-91`） | `Status=1` 或 `KEY=1` → 记住 `Pin`（缺则自留）并发 B-02；`=0` → 换新码重发，最多 3 次（`MAX_ROTATIONS` :224,116-130） | :85, 116-135（常量 :206） |
| B-02 | OpeningAp | `R001_<码>` | `SSID`、`PWD`（可空=开放热点，`BleReply.kt:33-34`） | `SSID` 非空 → 存凭据发 B-03 | :138-145（常量 :207） |
| B-03 | ConfirmingAp | `R002_<码>` | `WiFi_Status`、可再带 `SSID/PWD` | `WiFi_Status=1` → `Offered(ssid, pwd)`；SSID 始终缺失时退广播名（:161-163） | :155-166（常量 :208） |
| B-04 | 重试节奏 | 各阶段原帧 | — | 非确认期 1500 ms 重发、上限 8 次（:211, 221, 168-177）；AP 等待期 **1000 ms 无限重发**，总超时 25 s 由 `BleCentral.DEFAULT_HANDSHAKE_MS` 兜底（:218；`BleModels.kt:183`） | :168-177 |

通知解析容错：`=` 分隔，兼容 `:` 方言；值内逗号并回前字段（`core/ble/BleReply.kt:25-74`）；载荷 UTF-8 解码后剥 NUL 与首尾空白（:97-98）。

### 3.D 发现阶段的候选地址（不是相机命令，但决定请求发向）

`core/net/DeviceDiscovery.kt:26-35` 候选 host 顺序：`192.168.0.1`、`192.168.1.1`、`192.168.42.1`、`192.168.16.1`、`192.168.169.1`、`192.168.1.254`、`192.168.25.1`、`10.0.0.1`；优先试品牌固定地址（`fixedHostFor`，`AppState.kt:454-499`）。首候选 12 s 预算、其余 2.5 s（:104-105）；`identify` 按注册顺序问每个插件的 `probe`（:37-57）。

---

## 4. 设置项：id 全集与取值集合

### 4.1 NewAPP 动态菜单（权威来源 = 相机）

- id 全集**不写死在代码里**：`getprimarymenuitem`/`getsecondmenuitem` 返回什么就有什么（`HisiliconProtocol.kt:444-476`）；`CameraSetting.id` 必须保持固件原字符串不变，因为写参数时按它作 `-name=`（`core/model/Models.kt:143-151` 注释）。
- 本 App **认识**（有中文名/说明/分组/取值翻译）的 id 枚举在 **`ui/MenuCatalog.kt:80-203`**，共 20 个：`Resolution`、`VideoEncode`、`Image Quality`、`Gyro EIS`、`LDC`、`EIS Anti-Blur`、`Segment`、`Audio`、`Pre-Recording`、`Meter Mode`、`Exposure`、`Shutter`、`ISO`、`AWB`、`Scene Mode`、`Sharpness`、`Filter`、`brightness`、`Contrast`、`Saturation`；`knownItems` 对外暴露（:206），注释声明这些值取自 XTU S7PRO（Hi3519DV500，固件 20.8.6.1.20260710）实机菜单（:33-41）。
- 取值集合＝该条 `getsecondmenuitem` 的 `item` CSV 原样成 `CameraSetting.Option(value=label=固件字符串)`（`HiMenu.kt:41-45`）；`setSetting` 时原样作为 `-value=` 参数（`HisiliconProtocol.kt:506-507`）。
- 跨条共享的取值中文翻译（`MenuCatalog.kt:59-78`）：`ON/OFF/Auto/High/Normal/Low/Middle/1Min/3Min/5Min/Average/Center/Spot/Daylight/Cloudy/Incandescent/Fluorescent/Shade`；`Gyro EIS` 专有值：`Super/Super Enhance/Gyro Flow/Tilt Correction/Horizon Stabilization/360° Horizon Correction`（:104-111）。
- 开关判定：恰为两选项且值集 ∈ {`0`,`1`} 或 {`ON`,`OFF`} 才渲染为开关（`Models.kt:159-177`）；写值时取语义为「开」的那个原值（`toggleValue` :168-172）。

### 4.2 legacy（NewAPP 菜单为空时的回退）——`HisiliconProtocol.kt:430-442`

| id | 标题 | GET 模板 | 读字段 | SET 模板（`%s`=值） | 取值 |
|---|---|---|---|---|---|
| `videoinfo` | Video resolution | `getvideoinfo.cgi?` | `resolution` | `setvideoinfo.cgi?&-resolution=%s&-fps=30` | **fps 写死 30**（:431） |
| `bitrate` | Bitrate | `getbitrate.cgi?` | `bitrate` | `setbitrate.cgi?&-bitrate=%s` | 原样透传 |
| `fov` | Field of view | `getviewfield.cgi?` | `fov` | `setviewfield.cgi?&-fov=%s` | 原样透传 |
| `looprecord` | Loop record | `getlooprecord.cgi?` | `enable` | `setlooprecord.cgi?&-enable=%s` | 1/0 |
| `flip` | Flip | `getflip.cgi?` | `enable` | `setflip.cgi?&-enable=%s` | 1/0 |
| `audio` | Audio | `getaudioencode.cgi?` | `enable` | `setaudioencode.cgi?&-enable=%s` | 1/0 |
| `buzzer` | Buzzer | `getbuzzer.cgi?` | `enable` | `setbuzzer.cgi?&-enable=%s` | 1/0 |
| `led` | LED | `getledstate.cgi?` | `enable` | `setledstate.cgi?&-enable=%s` | 1/0 |
| `videonorm` | Video standard | `getvideonorm.cgi?` | `videonorm` | `setvideonorm.cgi?&-videonorm=%s` | 原样透传 |
| `autoshutdown` | Auto shutdown | `getautoshutdown.cgi?` | `time` | `setautoshutdown.cgi?&-time=%s` | 原样透传 |
| `brightness` | Screen brightness | `getscreenbrightness.cgi?` | `brightness` | `setscreenbrightness.cgi?&-brightness=%s` | 原样透传 |

注意 **id 撞名**：legacy 的 `brightness` 是「屏幕亮度」（`setscreenbrightness.cgi`），NewAPP 菜单的 `brightness` 是「画面亮度」（色彩组）——`MenuCatalog.kt:186-188` 已注明；两者按平台路径不同（`newApp` 标志，`HisiliconProtocol.kt:96`）各自解析，不会混发。

### 4.3 TUWIN REST

写死的探测集 6 个 id（`TuwinRestProtocol.kt:120`）：`resolution`、`bitrate`、`exposure`、`whitebalance`、`wdr`、`audio`，读 `/api/menu/getparameter?id=…`、写 `/api/menu/setparameter?id=…&value=…`（:128-131）。**取值集合代码中无任何枚举**——值以相机应答文本为准，选项列表恒为空。另外两个协议级魔法 id：`factory_reset`（值 `1`，:221）、`wifi_name`/`wifi_passwd`（:243,245）。

---

## 5. UI 操作入口 → 协议方法映射

屏幕层：`ui/ConnectScreen.kt`、`ui/Screens.kt`（Devices/Live/Files/Settings 四屏）；编排层：`AppState.kt`；连接生命周期：`AppState.kt:416-558`（`connectBlocking`）。

| UI 入口（精确位置） | AppState 方法 | 协议调用 | 最终请求编号 |
|---|---|---|---|
| 自动连接大按钮（`ConnectScreen.kt:190-199`；配对过→直接握手，否则先扫） | `ProvisioningController.connect/scan` + `connectNearby`（`AppState.kt:319-353`） | B-01~04 握手 → `connect(ssid,pwd)` | B-01~04 → H/T 连接序列 |
| 蓝牙相机行点击（`ConnectScreen.kt:221-229`） | `ProvisioningController.connect`（:61-69） | `ble.wakeAndFetch` | B-01~04 |
| 已连热点「使用此网络」（`ConnectScreen.kt:234-256`） | `connect()`（无参，`AppState.kt:416`） | 绑定现网→`identify`→`connect` | H-01/H-02 或 T-01~04 |
| Wi-Fi 网络行 + 密码 →「连接并加入」（`ConnectScreen.kt:258-312`） | `connect(ssid, password)` | 同上 | 同上 |
| 扫描相机（`ConnectScreen.kt:276`；旧 Devices 屏 `Screens.kt:455-459`） | `scanWifi()`（`AppState.kt:367-400`） | 无相机 HTTP | 平台 Wi-Fi 扫描 |
| 刷新（`ConnectScreen` 循环 2 s：`NearbyController.kt:105-123,177`；Devices 屏 `refreshNearby`） | `refreshNearby()`（`AppState.kt:356-359`） | 无相机 HTTP | BLE/Wi-Fi 重扫 |
| 扫码连网（`ConnectScreen.kt:110-119,316`） | `connect(creds.ssid, creds.password)`（`AppState.kt:416`）；解析器 `core/qr/QrWifiCredentials.kt` | 同 join 路径 | 同上 |
| 手输 IP 连接（`ConnectScreen.kt:317-330`；`ip:port` 解析 `AppState.kt:446-451`） | `connect(manualHost=ip)` | discovery→probe→connect | H-01/T-01… |
| 断开（`ConnectScreen.kt:168-180`；`Screens.kt:436-448`） | `disconnect()`（`AppState.kt:591-626`） | `onSessionClosed`（不发请求） | — |
| 预览画面（`Screens.kt:586-594`） | `protocolOrNull()?.previewUrl(session)`（:553） | `previewUrl` | H-30 / T-23 |
| 录像/停止按钮（`Screens.kt:678-690`） | `record(start)`（`AppState.kt:714`，`Op.Record`） | `record` | H-14 / T-13（+写后 `getStatus` 一次：`AppState.kt:1107`，前置 `peekWorkState` 仅海思 capture/mode） |
| 拍照按钮（`Screens.kt:668-677`；仅 PHOTO 模式且空闲可点 :671-675） | `capture()`（`AppState.kt:712`） | `capture` | H-12→H-13 / T-12 |
| 模式分段 Video\|Photo（`Screens.kt:638-660`；PLAYBACK 故意缺席 :641-644） | `setMode`（`AppState.kt:721-725`）；Ok 后重读菜单（:757-764） | `setMode`+`getSettings` | H-12→H-16/H-17/H-15 + H-05/H-18/H-19 / T-11+T-07 |
| 刷新文件列表（`Screens.kt:754-758`） | `refreshFiles()`（`AppState.kt:766-781`） | `listFiles(0,999)` | H-24/H-25 / T-14 |
| 单文件下载 / 重下（`Screens.kt:1049-1067`） | `download(file)`（`AppState.kt:981-1055`） | `download`（断点续传、尺寸核验 :1011,1026） | H-29 / T-18 |
| 批量选择→Download/「Retry failed」/「Clear finished」（`Screens.kt:768-825,1072-1076`） | 循环 `download(it)` | 同上 | 同上 |
| 缩略图加载（`Screens.kt:832-834`） | `loadThumbnail`（`AppState.kt:788-826`） | `thumbnail` | H-28 / T-17 |
| 删除（确认框 `Screens.kt:861-884`）/ 批删（:886-907） | `deleteFile` / `deleteFiles`（`AppState.kt:834-863`） | `deleteFile` ×N | H-27 / T-16 |
| 设置行开关 / 下拉选项 / 文本框 Save（`Screens.kt:1396-1470`） | `setSetting(id, value)`（`AppState.kt:733-754`）；Ok 后本地更新 + `readBack`（:742-749） | `setSetting`+`readBack` | H-20+H-21（legacy：H-23，无回读）/ T-08（无回读） |
| 重新加载设置（`Screens.kt:1205-1209`） | `loadSettings()`（`AppState.kt:727-731`） | `getSettings` | H-18+H-19 ×N / H-22 ×11 / T-07 ×6 |
| 刷新设备信息（`Screens.kt:1232-1236`） | `loadDeviceInfo()`（`AppState.kt:867-883`） | `getDeviceInfo` | H-31 / T-19 |
| 格式化 SD（确认框 `Screens.kt:1276-1280,1342-1383`） | `formatSd()`（`AppState.kt:885-898`）；Ok 后重列+重读状态 | `formatSd`(+`listFiles`,`getStatus`) | H-32 / T-20 |
| 恢复出厂（`Screens.kt:1334-1338`） | `factoryReset()`（`AppState.kt:900-905`） | `factoryReset` | H-33 / T-09 |
| 重启相机（仅 `platform == TUWIN_REST`，`Screens.kt:1326-1333`） | `reboot()`（`AppState.kt:907-912`） | `reboot` | T-21（海思=H-34 恒失败且 UI 不给入口） |
| 相机 Wi-Fi 改名/改密（`Screens.kt:1285-1322`） | `setCameraWifi`（`AppState.kt:916-918`） | `setWifi` | H-36 / T-10 |
| 选择固件→安装（`Screens.kt:1241-1269`） | `installFirmwareUpdate()`（`AppState.kt:929-969`）→ `OtaCoordinator.run`（`core/ota/Ota.kt:89-142`） | `OtaTransport.readVersion`/`install` + `connect` | H-37→H-38→H-39→（H-02 重连）→H-37 |
| OTA 取消（`Screens.kt:1263-1266`） | `cancelFirmwareUpdate()`（`AppState.kt:971-974`） | 协程取消，**不发相机请求** | — |
| 对时 | **无独立按钮**：`Phase.SyncingTime` 内 best-effort（`AppState.kt:537-541`；`syncTime()` 存在但无调用方，:914） | `syncTime` | H-35 / T-22 |
| 日志/诊断页 | `openDiagnostics`（`AppState.kt:104-108`；`ui/LogScreen.kt`） | 无相机请求 | — |

---

## 6. 已知不实现 / 占位 / 默认空实现清单

| 项 | 位置 | 现状证据 |
|---|---|---|
| 海思远程重启 | `HisiliconProtocol.kt:668-669` | 恒 `CmdResult.Failure("Reboot is not supported on this camera")`，UI 同步隐藏入口（`Screens.kt:1327`） |
| 海思 APP 可控回放模式 | `HisiliconProtocol.kt:365-372` | `setMode(PLAYBACK)` 恒拒绝；UI 分段控件不提供该项（`Screens.kt:641-644,699`） |
| `readBack` 默认实现 | `CameraProtocol.kt:67`（默认 null） | `TuwinRestProtocol` 未覆写；`HisiliconProtocol.kt:540` 对 legacy 固件也返回 null → 改设置后只显示本地值 |
| `onSessionClosed` 默认空实现 | `CameraProtocol.kt:116` | 仅海思覆写（:200-205）；TUWIN 无缓存可弃 |
| `probe`/`connect` 的默认实现 | 接口无默认（:52,55） | 但 `wifiSsidPrefixes`/`fixedHost`/`defaultWifiPassword` 默认空/null（:29,39,46）：除两家已注册插件外，其余平台枚举（`Models.kt:23-36` 的 AMBARELLA/SIGMASTAR/TUWIN_M3/ICATCH）**无任何插件**，`AppGraph.kt:26-29` 只注册两个 |
| OTA：仅海思一条通道 | `AppState.kt:922-927`（注释「Only the Hisilicon CGI transport is implemented so far」） | `TuwinRestProtocol` 无 OtaTransport；UI 按钮在非海思上置灰显示不支持（`Screens.kt:1244-1249`） |
| OTA 取消不上报相机 | `core/ota/Ota.kt:81-83` | 只改本地状态机为 `Cancelled` |
| 海思弱判据集合 | `:626, 660, 665, 677, 684` | `deleteFile/formatSd/factoryReset/syncTime/setWifi` 仅「有应答即 Ok」，**不查 `SvrFuncResult`** → 相机拒绝也可能报成功（§2.2） |
| `setwifi` 编码不完整 | `HisiliconProtocol.kt:687-688`（`urlencode` 仅处理 空格/&/=/+） | 非 ASCII 热点名与 `%` 字符会原样拼进 URL（同文件其它参数用的是完整的 `Cgi.param`） |
| TUWIN 写参数未编码 | `TuwinRestProtocol.kt:129` | `id`/`value` 直拼；仅 `setWifi` 路径做了窄编码（:252-253） |
| TUWIN 录像事件先于判定 | `TuwinRestProtocol.kt:144-146` | 无论应答与否都发 `RecordingChanged` |
| TUWIN 无 busy/前置检查 | `TuwinRestProtocol.kt:138-141` | `capture` 不查状态、不查模式 |
| `DeviceEvent.BatteryChanged`/`Disconnected` 无人发射 | `Models.kt:196-201` 定义；两家 `_events` 仅在 `record` 发 `RecordingChanged`（`HisiliconProtocol.kt:357`、`TuwinRestProtocol.kt:145`） | 消费端已接好（`AppState.kt:571-586`），推送源缺失 |
| 协议层 TODO | `TuwinRestProtocol.kt:219-220` | 注释记录「Ride3Pro 官方 App 把该端点标 TODO；Ride6 走菜单参数 `factory_reset`。两家 best-effort」 |
| legacy 分辨率写死帧率 | `HisiliconProtocol.kt:431` | `setvideoinfo.cgi?&-resolution=%s&-fps=30` 恒 30 |
| 相机侧中文词条未拉取 | `ui/MenuCatalog.kt:43-51` | 官方从相机 8080 拉 `language.xml`；我们未做，标注「未标记的中英文标签是我们自备、未经证实的措辞」（:48-51） |
| iCatch / M3 / Ambarella 探测地址 | `DeviceDiscovery.kt:31-32` 有候选 IP，注释点名 | `192.168.169.1`（TUWIN M3 + idGoLive Qz）、`192.168.1.254`（idGoLive Ly/Yz）会进入遍历，但没有任何插件认领这些平台 |
| 桌面/测试端 OTA 文件选择 | `core/ota/FilePicker.kt` + 各平台 actual | UI 入口存在即可达，仅平台实现差异，不影响命令面 |

**其他说明**：`legacySettings` 的 11 项不是死代码——`getSettings` 在 `primary.isEmpty()` 时回退（`HisiliconProtocol.kt:456,478-490`），`setSetting` 非 newApp 走 legacy setter（:518-530）；整条 legacy 分支的触发条件是 `getdeviceattr.cgi` 的 `hardversion != "NewAPP"`（:96）。
