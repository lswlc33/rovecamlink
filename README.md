# RoveCamLink

**让运动相机在手机上变得好用的开源客户端。**

接上就能用：自动连相机、实时看画面、随手拍照录像、下载和管理素材，一套搞定。官方 App 又大又卡——RoveCamLink 更轻、更快、更顺手。

技术上是 **Kotlin Multiplatform + Compose Multiplatform + miuix**：一套代码跑 Android、桌面与 iOS；协议以插件形式组织，接入新相机无需改动核心与 UI。

> 官方 App 臃肿卡顿。RoveCamLink 的目标是精简、快速、可扩展。

[官网](https://lswlc33.github.io/rovecamlink/) · [文档系统](docs/README.md) · [逆向分析报告](docs/analysis/apk-overview.md) · [架构与开发计划](docs/design/roadmap.md) · [品牌型号与协议矩阵](docs/analysis/protocol-matrix.md) · [官方 APK 全量逆向档案](docs/evidence/method.md) · 其余（固件与 OTA、网络 API 与安全评估、诊断日志系统、蓝牙配网与 VPN）见[文档系统](docs/README.md)

## 软件特色

> 说人话：接上相机就能用。想看技术实现，往下翻「架构」和「构建与运行」。

**相机开机，它自己找上来** —— 不用先研究说明书里的网关地址。打开 App，它会搜到附近的相机、替你连上热点、把密码带回来；第一次连接只要在相机屏幕上点一下确认。想扫二维码、从 Wi-Fi 列表里连、或者干脆手填地址，也都行。

**手机立刻变取景器** —— 实时画面几乎看不到延迟。横着拿、竖着拿，画面都会自动摆正；长按一下进入全屏，取景、摆机位看得清清楚楚。

**想调什么，拖一下就好** —— 电量、剩余空间、已录时长一屏看清。曝光、ISO、快门、防抖、白平衡……想调哪个拖哪个，松手才发给相机，怎么调都不会把画面卡住。

**素材在手机上一次搞定** —— 相机里的照片和视频在线预览，勾一批一起下载，网断了还能接着传；下载完直接进手机相册，不想要的在手机上就能删掉。

**不只是运动相机** —— 多个品牌的运动相机和记录仪都能用，还能自动认出型号；新机型一直在加。

**你的设备都能装** —— Android 手机是主力；桌面端装上就能在电脑上连相机；iOS 版正在做。

**装得下、不添乱** —— 安装包只有几 MB，没有夹带地图、广告之类的重型组件，能省的地方都省了。

**完全开源** —— Apache-2.0 协议，代码全部公开，可以自由使用、修改、二次分发（含商用）。

**出问题也不抓瞎** —— 万一连不上，App 自带诊断日志，一键导出，把这个文件附到反馈里，问题出在哪一目了然。

## 出问题先看这里

顶部栏的 **终端图标**（任何页面都在）打开 **Diagnostics**：实时预览本进程记录的全部相机通讯，`Share TXT` / `Save TXT` 导出一份自描述的诊断文件。每一次 HTTP 交换（URL、状态码、耗时、响应头、响应体原文、异常因果链）、每一次阶段迁移与协议判断都在里面；重复轮询自动折叠成带统计的一行，口令类参数默认脱敏。格式语法与排障读法见 [诊断日志系统](docs/impl/diagnostics-log.md)。

## 每日构建包

[Releases](https://github.com/lswlc33/rovecamlink/releases) 里最新的 `nightly-*` 预发布就是 main 最新提交的产物（推 main、每日定时、手动派发都会发一条，页面只保留最近 3 条）。包名带版本和这一轮的时间戳，形如 `RoveCamLink-0.1.3-nightly-20260922-150000.apk`，下载目录里几个包不会撞名。nightly 构建的就是 release 包（R8 裁剪 + 资源收缩后约 3.6MB；早期不开 R8 的包有 20MB），所以下载很快；代价是它不可调试，排障请用 App 内的 Diagnostics 导出诊断 TXT。nightly 与正式版共用同一把签名密钥，所以新包能直接覆盖升级上一个包；密钥与 `.github/apk-signer-sha256.txt` 登记不一致时 CI 会红，不会发出装了就不能再升级的包（第一次从旧的 nightly 换过来仍需先卸载一次）。

CI 只有两条工作流：`Nightly`（日常构建，装测试就认它）和 `Release`（正式版，只在推 `vX.Y.Z` tag 或手动派发时跑，不会随提交出现）。

## 首个支持的设备

**XTU X7 Pro** —— 海思 Hi35xx（`hi3510`）HTTP CGI 协议。运行时自动探测注册的每个协议来识别设备，不写死型号表（同品牌不同机型的协议/端口/路径各不相同，详见[逆向分析报告](docs/analysis/apk-overview.md)）。

## 架构

```
composeApp/
  commonMain/   共享 UI（miuix）、状态、协议、传输
    core/model      数据模型（会话、状态、设置、文件、事件）
    core/transport  Ktor HTTP 客户端（文本/字节/断点续传下载）
    core/protocol   CameraProtocol 接口 + 注册表（插件点）
    core/net        运行时设备发现 / 识别
    core/wifi       Wi-Fi 控制与扫描（expect/actual）
    core/storage    文件保存与权限（expect/actual）
    core/media      实时预览视图（expect/actual）
    brand/xtu       海思 hi3510 CGI 插件
    brand/tuwin     TUWIN REST 插件
  androidMain/  Wi-Fi 直连、Media3 RTSP 预览、MediaStore 保存
  desktopMain/  桌面端入口（可手动连接模拟器）
  iosMain/      iOS 壳工程（可编译，未做功能验证）
simulator/      Ktor 桌面服务器，模拟海思 CGI 协议
```

**接入新相机：** 实现 `CameraProtocol` 并在 `AppGraph` 中注册即可。发现流程会逐个探测已注册的协议，新设备无需改动 UI。

## 构建与运行

环境要求：JDK 17 以上、Android SDK（compileSdk 37）。在 `local.properties` 中配置 `sdk.dir`。

```bash
# Android 调试 APK
./gradlew :composeApp:assembleDebug
# -> composeApp/build/outputs/apk/debug/composeApp-debug.apk

# 桌面相机模拟器（随后在 App 中通过「手动连接」连到 10.0.2.2:8080（模拟器）或本机局域网 IP）
./gradlew :simulator:run

# 桌面 App
./gradlew :composeApp:run
```

### iOS

iOS 是一个承载共享 Compose UI 的壳工程，可编译但未做功能验证（暂无设备）。用 [XcodeGen](https://github.com/yonaskolb/XcodeGen) 生成 Xcode 工程：

```bash
cd iosApp && xcodegen generate && open RoveCamLink.xcodeproj
```

## 无相机测试

启动模拟器后，在 App 中使用「手动连接」输入模拟器的 `host:port` 即可。模拟器实现了完整的 `hi3510` CGI 面（设备属性、状态、电量、SD 卡、工作模式、拍照/录像、文件列表、缩略图、文件下载），从连接 → 实时状态 → 文件列表 → 下载全流程可端到端工作。

- `SIM_PORT` 环境变量可换端口（默认 8080），旧实例占用端口时更方便（例如 `SIM_PORT=8081`）。
- 缩略图为真实的 JPEG（按文件名着色），App 的解码路径得到真实演练，陈旧缩略图也容易发现。

注意：真机必须授予**位置权限**才能扫描 Wi-Fi——Android 在 API 33+ 声明了 `NEARBY_WIFI_DEVICES` 时仍拒绝无定位权限的 `startScan`。App 会在首次扫描时请求该权限，并提示原因而不是静默显示「未发现相机」。

## 状态

- [x] 可扩展的协议插件架构
- [x] XTU X7 Pro（海思 CGI）+ 运行时自动探测
- [x] Wi-Fi 直连（Android API 24+ / 29+ 两条路径）
- [x] 一键连接（蓝牙发现 + 唤醒相机热点 + 配对码）
- [x] 扫码连接（识别相机屏幕上的 Wi-Fi 二维码，CameraX + zxing）
- [x] 手动连上相机热点后自动发现并连接
- [x] RTSP 实时图传（Media3，Android；方向跟随 + 长按全屏）
- [x] 相机控制（拍摄模式 / 快速调节 / 设备与拍摄设置 / 相机热点管理）
- [x] 固件 OTA 升级（海思平台）
- [x] 文件传输（列表 / 缩略图 / 断点续传下载 / 发布到相册）
- [x] 文件缩略图应用内解码，删除前二次确认
- [x] miuix UI（深色 / 浅色 / 跟随系统）
- [x] 桌面相机模拟器
- [x] 可安装的调试 APK
- [x] 详细诊断日志（应用内实时预览 + TXT 导出/分享，默认脱敏）
- [x] 直播推流（RTMP 上行，XTU 海思：TCP 8080 下发参数 + 本地 RTSP 预览；这条通道没有停止命令）
- [ ] 更多品牌、机型与品类（iCatch 系 HTTP 双 profile 已落；Ambarella / SigmaStar / TUWIN M3、iCatch 的 PTP 与原生 TCP 通道待做）
- [ ] iOS 功能验证（仅壳工程）

## 许可

本项目源码采用 **Apache License 2.0** 授权，全文见 [LICENSE](LICENSE)。你可以自由使用、修改、分发（含商用），前提是保留版权与许可声明、说明你对源码做过的修改，并随分发附上许可证副本；该许可证同时授予专利权。

两点边界说明：

- 本许可证只覆盖 RoveCamLink 自己的源码。各相机厂商的 App、固件、协议实现与商标均归其权利人所有，不在授权范围内。
- `docs/analysis/apk-overview`、`docs/analysis/protocol-matrix`、`docs/analysis/ota-and-gaps`、`docs/analysis/network-api`、`docs/analysis/ble-and-vpn`，以及 `docs/evidence/`（含 `data/` 下由 `tools/re/` 从官方 APK 机器提取的全量清单、字符串表、常量表、类与符号表）都是为与这些设备互操作而做的分析记录，随仓库提供不代表你获得了对应厂商的任何权利。其中 `docs/analysis/network-api` 记录的厂商安全缺陷**只用于指导我们自己的实现不重犯**，不构成对任何人设备或服务的授权。