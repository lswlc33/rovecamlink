# RoveCamLink

开源运动相机连接 App，**Android 优先**。基于 **Kotlin Multiplatform + Compose Multiplatform + Compose Cupertino** 构建，通过 Wi-Fi 直连运动相机，提供 RTSP 实时图传与文件传输；协议层以插件形式组织，接入新相机/新品牌无需改动核心与 UI。

> 官方 App 臃肿卡顿。RoveCamLink 的目标是精简、快速、可扩展。

[官网](https://lswlc33.github.io/rovecamlink/) · [逆向分析报告](docs/01-APK逆向分析报告.md) · [架构与开发计划](docs/02-KMP架构与开发计划.md) · [品牌型号与协议矩阵](docs/03-品牌型号与协议矩阵.md) · [固件更新与功能差距](docs/04-固件更新与功能差距.md) · [网络 API 与安全评估](docs/05-网络API清单与安全评估.md)

## 首个支持的设备

**XTU X7 Pro** —— 海思 Hi35xx（`hi3510`）HTTP CGI 协议。运行时自动探测注册的每个协议来识别设备，不写死型号表（同品牌不同机型的协议/端口/路径各不相同，详见[逆向分析报告](docs/01-APK逆向分析报告.md)）。

## 架构

```
composeApp/
  commonMain/   共享 UI（Compose Cupertino）、状态、协议、传输
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

环境要求：JDK 21、Android SDK（compileSdk 35）。在 `local.properties` 中配置 `sdk.dir`。

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
- [x] 扫码连接（识别相机屏幕上的 Wi-Fi 二维码，CameraX + zxing）
- [x] 手动连上相机热点后自动发现并连接
- [x] RTSP 实时图传（Media3，Android）
- [x] 文件传输（列表 / 缩略图 / 断点续传下载 / 发布到相册）
- [x] 文件缩略图应用内解码，删除前二次确认
- [x] Compose Cupertino UI
- [x] 桌面相机模拟器
- [x] 可安装的调试 APK
- [ ] iOS 功能验证（仅壳工程）

## 许可

本项目源码采用 **Apache License 2.0** 授权，全文见 [LICENSE](LICENSE)。你可以自由使用、修改、分发（含商用），前提是保留版权与许可声明、说明你对源码做过的修改，并随分发附上许可证副本；该许可证同时授予专利权。

两点边界说明：

- 本许可证只覆盖 RoveCamLink 自己的源码。各相机厂商的 App、固件、协议实现与商标均归其权利人所有，不在授权范围内。
- `docs/01-APK逆向分析报告.md`、`docs/04`、`docs/05` 是为与这些设备互操作而做的分析记录，随仓库提供不代表你获得了对应厂商的任何权利。其中 `docs/05` 记录的厂商安全缺陷**只用于指导我们自己的实现不重犯**，不构成对任何人设备或服务的授权。