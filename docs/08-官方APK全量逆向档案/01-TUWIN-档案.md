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
| 机型/SSID 正则/默认 IP 端口/协议 Profile 白名单/HTTP 面全表/鉴权/M3 TCP/菜单 XML/队列串行化 | [附录 · 协议面](01-TUWIN-档案-附录-协议面.md) |
| 设置项全表（键+枚举值+中文文案）/拍摄模式常量/页面与入口/操作复现表/状态轮询 | [附录 · 设置与操作](01-TUWIN-档案-附录-设置与操作.md) |
| WiFi 直连与路由绑定/下载续传/相机 OTA/播放器参数/事件推送/遥测域名/原生库 | [附录 · 传输OTA与联网](01-TUWIN-档案-附录-传输OTA与联网.md) |
| 每一条路径、常量、枚举、布局、字符串资源的原始表 | `data/tuwin/`（`catalog-http.md`、`catalog-consts.md`、`catalog-enums.md`、`layouts.md`、`res-strings-default.md`、`api/*.md` 等） |

## 2. 清单事实（`data/tuwin/manifest.md`）

组件 42 个：activity 33 / service 3 / receiver 1 / provider 5；权限 20 条；无 `uses-feature`、无 `queries`。

`<application>` 里对我们有直接影响的两条：`usesCleartextTraffic=true`（相机 HTTP 全明文，不需要例外配置）、
`allowBackup=false`、`requestLegacyExternalStorage=true`、`networkSecurityConfig=@0x7f140003`（实际内容见
[传输OTA与联网附录](01-TUWIN-档案-附录-传输OTA与联网.md)清单小节）。

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

对照基准是 [附录A · 我们已实现的命令面](附录A-我们已实现的命令面.md)（TUWIN 侧 23 条编号请求）。
本次全量比对得到的机械结论（`comm` 对比 `data/tuwin/catalog-http.md` 与 `composeApp/` 源码）：

- 官方 TUWIN 静态可见 59 条路径，我们用到 24 条；**我们用的都在官方目录里存在**（没有凭空发明的路径）。
- 两个需要修的点：① 我们的 `GET /api/playback/download?file=<名字>` 在官方目录里**不存在**，官方下载走 `/api/playback/rawdata`（配 `StreamingTransferEngine` + `Ride3ProPlaybackDownloadResumePolicy`）；② 官方回放/缩略图/删除用 `file_index=`（按索引），我们按文件名传 `file=`。真机验证前不要把这条当既成事实改掉，但它属于「照官方复现就必须改」的一类。
- 完全没有实现的机型族：M3（`/app/*` + TCP）、Ride5（`/cgi-bin/hisnet/`），以及 `GET /api/menu/xml` 整套动态菜单（我们现在只查 9 个写死 id）。

## 6. 未解与需抓包项

见协议面 §2.8「未确认的取值域」与 §8、设置与操作 §4/§6、传输OTA §8。汇总成一句话：M3 的 TCP 报文取值域、Ride3Pro 菜单 XML 的完整 id 空间、以及各家固件版本门限（续传/特性开关）需要 TUWIN 真机确认；我们手上只有 XTU S7PRO 的设备。
