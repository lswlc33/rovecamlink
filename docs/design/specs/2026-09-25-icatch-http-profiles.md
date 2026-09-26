# idGoLive（iCatch 系）适配设计 · 第一阶段 HTTP 双 profile 插件

> **doc-id** `design/specs/2026-09-25-icatch-http-profiles` · **层** 计划与设计 · **状态** 已批准、已落地（`brand/icatch/IcatchHttpProtocol.kt`）· **建档** 2026-09-25
> 文档系统 [`docs/README.md`](../../README.md) · 证据层 `docs/evidence/idgolive`（附录 A-D）与 `docs/evidence/data/idgolive/*`

## 0. 背景

- idGoLive（`com.id221.golive`，Java 命名空间 `com.icatch.golive`）是 iCatchTek 白标公版 App，
  服务 id221/idalbum 渠道下的一批 ODM 贴牌设备（含优达尔行车记录仪、Victure、Crosstour 等）。
- 仓库中 `DevicePlatform.ICATCH` 枚举已存在，但没有任何插件注册：iCatch 系设备目前止步于
  「没有插件认领」。
- idGoLive 实际是 **三条并行通道**：
  1. **PTP / PTP-IP**（主相机，`192.168.1.1`）—— 整条栈在 `libcontrol.so`，端口静态无解
     （档案 §3.5：15740 仅为规范默认值，3195/3196 零证据），**必须有真机才能定端口**；
  2. **LyIC**（Novatek 风格 HTTP，`192.168.1.254/?custom=1&cmd=`，XML 应答；
     另有 TCP:3333 单向 XML 推送）；
  3. **QzIC / YzIC**（`192.168.169.1` 或 `.254` 的 `/app/*` + `/api/*` JSON）。

## 1. 范围

**做（第一阶段）**：LyIC + QzIC 两条纯 HTTP 通道，注册为 `DevicePlatform.ICATCH`
平台插件；模拟器加对应 profile 做端到端离线验证；命令面逐条对应档案附录 B，
每条可验收。

**不做（留档待真机）**：
- PTP/IP 主通道 —— 真机到手后按档案 §3.5 的 4 步验证法（netstat → 抓包 → frida → IDA）
  定端口后再立项；
- TCP:3333 事件推送 —— `CameraTcp.readFully` 语义不适配 `</Function>` 分帧；
  且状态轮询已覆盖 UI 需求；第二阶段加 `readSome` 原语后再接；
- 直播推流 / 组播配网 / USB / 蓝牙 —— 对照清单 §4 已判「不做」。

## 2. 架构

```
composeApp/src/commonMain/kotlin/com/rovecamlink/app/brand/icatch/
  IcatchHttpProtocol.kt    唯一 CameraProtocol 实现，platform = ICATCH
  LyXml.kt                 Novatek XML 解析（标签抽取；「不依赖行边界」经验同 HiVarParser）
  QzJson.kt                {result,info} 信封解析（判据同 Tuwin accepted() 风格）
  IcatchSettings.kt        Ly 固定 8 项设置表（档案 §8 取值表照抄）+ 3031 动态档位
```

- **一个插件、两个 profile**：`CameraSession.extras["profile"] = "ly" | "qz"` 分派。
  理由：两族共享 ICATCH 平台，且 `CameraProtocolRegistry.associateBy(platform)`
  不允许同平台两个插件；探测时才知道是哪族。
- **路由（纯探测，无 SSID 前缀）**：档案 §3.2 实证 idGoLive **不存在 SSID 白名单**，
  故 `wifiSsidPrefixes = emptyList()`、`fixedHost = null`。发现走 `DeviceDiscovery`
  候选表（已含 `192.168.169.1` / `192.168.1.254`）+ probe 认领 —— 即 docs/analysis/protocol-matrix 第 12 条
  要求的「无型号、纯探测兜底路由」。
- **probe 判据**（先 Ly 后 Qz，与官方 `.254` 上 Novatek 优先的裁定一致）：
  - Ly：`GET /?custom=1&cmd=3029` → 响应含 `<SSID` → 认领；
  - Qz：`GET /app/getdeviceattr` → JSON 含 `result` 与 `ssid` → 认领。
- **Brand 枚举**增加 `ICATCH("iCatch")`。优达尔等贴牌统一归 iCatch 家族；贴牌名
  真机后可从 SSID / 产品信息细分（官方用 PTP 0xD831 读名，HTTP 侧载体未确认，
  见 §5 风险）。

## 3. 方法映射（验收清单）

| CameraProtocol | LyIC（Novatek XML） | QzIC（/app JSON） |
|---|---|---|
| connect | `cmd=3029` 取 SSID/PASSPHRASE；随后 `cmd=2015&par=1` 开 RTSP 副流（best-effort） | `/app/getdeviceattr` + `/app/getproductinfo` |
| getStatus | `cmd=8013` 电量、`cmd=3017` 剩余空间、`cmd=3024` 卡状态、`cmd=2016` 录制秒数（>0 即录像中）、`cmd=3014` 当前值标签表 | `/app/getparamvalue?param=rec`（官方心跳，=1 即录像）、`/app/getsdinfo` |
| setMode | `cmd=3001&par=0/1/2` | `/app/enterrecorder`（VIDEO）、`/app/playback?param=enter`（PLAYBACK）、`/app/setting?param=enter`（PHOTO 档设置态） |
| capture | `cmd=2017` | POST `/app/snapshot` |
| record | `cmd=2001&par=1/0`；起=先 `2015&par=1`、停=后 `2015&par=0`（官方 ready2CamLive/stopMovieRecord 顺序） | `enterrecorder` → `param=rec&value=1`；`rec=0` 后 `/app/setting?param=enter` |
| getSettings | 固定 8 项：`2002` 分辨率（§8.1 表）/`2003` 循环（§8.3）/`2004` WDR/`2008` 水印/`2011` G-Sensor（0..4）/`3044` 镜头旋转/`8010` 麦克风/`8011` 录音；当前值用 `cmd=3014` 标签法（§8.5 机制，不复刻其覆写 bug）；`cmd=3031&str=all` 返回的 Cmd2003/2011/8010/8011 档位动态覆盖硬编码表 | `/app/getparamitems?param=all`（选项）+ `/app/getparamvalue?param=all`（当前值） |
| setSetting | `cmd=NNNN&par=X`，随后追加 `cmd=3021` 提交（官方累积后统一提交；逐次提交等价且更简单） | `/app/setparamvalue?param=<p>&value=<v>` |
| listFiles | `cmd=3015` → `ALLFile{NAME,FPATH,SIZE,TIME,ATTR}`，按 FPATH 含 `/Movie/`、`/SOS/`、`/Photo/` 分流 | `folder=loop`（视频）/`event`（照片）/`emr`（紧急），首屏 `0..99`、**翻页步长 101**（档案实证） |
| thumbnail | `http://host/Novatek/<dir>/<file>?custom=1&cmd=4002` | `/app/getthumbnail?file=<path>` |
| download | 标准 `Range: bytes=N-` 续传（复用 `CameraHttp.download`） | 同左 |
| deleteFile / deleteAllFiles | `cmd=4003&str=` / **`cmd=4004`**（补上 App「全部删除」能力缺口） | `/app/deletefile?file=` / 无 → 默认 Failure 回退批删 |
| formatSd / factoryReset | `cmd=3010&par=1` / `cmd=3011` | `/app/sdformat` / `/app/reset` |
| syncTime | `cmd=3005&str=yyyy-MM-dd` + `cmd=3006&str=HH:mm:ss` 两条 | `/app/setsystime?date=yyyyMMddHHmmss` |
| setWifi | `cmd=3003/3004&str=` + `cmd=3018` 重连 | `/app/setwifi?wifissid=`、`wifipwd=`（YdeviceSettingActivity 实证参数名）+ `/app/wifireboot` |
| previewUrl | `rtsp://{host}:554/`（官方只回裸 `rtsp://ip`；完整路径是未解之谜 #11，真机后校正） | 同左 |
| reboot | 无命令 → 默认 Failure（`supportsReboot = false`） | 同左 |
| getDeviceInfo | `cmd=3012` 固件版本 + `cmd=3029` 的 SSID | `/app/getproductinfo` + `/app/getdeviceattr` |

**成功判据**：
- QzIC：`{result:0}` 信封（同 TUWIN `accepted()`）；非 JSON 应答按传输成功处理
  （流式端点）。
- LyIC 写命令：2xx 且有响应体即 Ok（官方「仅发送不解析」；已知弱点记入插件注释，
  口径同海思 §2.2）。
- LyIC 读命令：必须解出目标标签才算数（解不出 → null / 跳过该字段）。

## 4. 模拟器与测试

- `simulator` 加 `SIM_PROFILE` 环境变量：`hi3510`（默认，现状不变）/ `ly` / `qz`。
  - Ly 档：上表全部 `cmd` + `/Novatek/<dir>/<file>` 媒体路径 + 缩略图 `?custom=1&cmd=4002`。
  - Qz 档：`/app/*` 全端点 + JSON 信封。
  - 连接 → 状态 → 文件 → 缩略图 → 下载 → 删除 → 设置 → 格式化全流程可端到端离线验证。
- 单测（commonTest）：
  - Ly XML：`cmd=3029`（SSID/PASSPHRASE）、`cmd=3015`（ALLFile 列表）、`cmd=3031`（Cmd/Index/Id）；
  - Qz JSON：`{result,info}` 信封、文件列表解析、分页步长 101 的 next-window 计算；
  - URL 拼装：缩略图 / 下载 / setWifi；
  - FPATH 分流（`/Movie/`、`/SOS/`、`/Photo/`）；
  - 设置取值表映射（§8.1 / §8.3 照抄）。
- 验证命令：`gradlew :composeApp:desktopTest` + `gradlew :composeApp:assembleDebug`；
  手测：`SIM_PROFILE=ly gradlew :simulator:run` 后在 App 手动连接 `127.0.0.1:8080`。

## 5. 风险与留白（真机后回填）

- RTSP 预览完整路径（未解之谜 #11）：先回裸 `rtsp://host:554/`，真机抓包后校正。
- Qz `/app/getproductinfo` 承载型号的 JSON key 未确认：best-effort 解析常见键
  （`product`/`model`/`name`）+ `raw` 透传。
- `/app/getparamvalue?param=all` 完整 param 键集（未解之谜 #12）：`raw` 透传，真机 dump 回填。
- `.254` 上并存两套 API：只实现官方会选中的 Novatek 套；probe 若在 `.254` 命中 Qz 形状
  也接受（`LyCmdWithYzIC` 死代码证明该组合存在但罕见）。
- 蓝牙权限教训（清单缺 BLUETOOTH_SCAN/CONNECT）：本阶段无蓝牙面，不涉及。
