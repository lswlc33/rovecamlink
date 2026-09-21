# 03 · idGoLive 1.3.6 穷尽式逆向档案

> 包名 `com.id221.golive` / Java 命名空间 `com.icatch.golive` / iCatchTek 公版白标 App。
> APK：`相机 app/idGoLive_1.3.6.apk`；反编译源码：`_work/idgo_live_src/sources/`（10685 个 .java）；机器提取附录：`_work/re/idgolive/`。
> 本档案是「操作能力复现」的依据，不是官方代码的复制。
>
> **拆分出去的附录**（长表都放这里，主文档只留导航与结论）：
> · [附录 A · PTP 设备属性表全量](03-idGoLive-档案-附录-PTP属性表.md)
> · [附录 B · HTTP / TCP 命令目录全量](03-idGoLive-档案-附录-HTTP与TCP命令.md)
> · [附录 C · 原生层 63 个 .so、JNI 全表、PTP-IP 线上格式](03-idGoLive-档案-附录-原生层与PTPIP.md)
> · [附录 D · UI 面、云端端点判定、native 字符串真伪](03-idGoLive-档案-附录-UI与端点判定.md)

---

## 0. 本文覆盖度

| 维度 | 已分析 | 未覆盖 / 原因 |
|---|---|---|
| 类型 | 厂商包全部：`com/icatch/golive/**` 314 个 .java（60380 行）、`com/icatchtek/**` 389 个 .java、`com/id221/golive/**`、`com/tinyai/libmediacomponent/**`、`com/icatch/bluetooth/sdk/**`；机器提取共 `_work/re/idgolive/classes-all.tsv`（3.0 MB）与 `api/*.md` 62 个包文件（2.35 MB，逐类声明+字面量） | 三方库（okhttp3 / retrofit / scribejava / facebook-sdk / google-api-client / androidx / kotlin）只做端点真伪判定（附录 D §3），不逐类展开——它们不含相机协议 |
| 常量 | `own-constants.tsv`（3.69 MB）中 OWN 部分全部读；重点手工核对 `PropertyId`(51)、`ICatchCamProperty`(19)、`ICatchCamMode`(12)、`ICatchCamEventID`(41)、`ICatchCamListFileFilter`(13)、`ICatchCam{ImageSize,VideoSize,WhiteBalance,LightFrequency,DateStamp,BurstNumber,CaptureDelay,TimeLapse*,PreviewMode,WifiMode,LogLevel,LogType}`、`RequestInfo`(67)、`M1RequestInfo`(42)、`LyWyzRequestInfo`(44)、`AppInfo`(46)、`NativeValueTag`(7)、`ICatchCameraConfigImpl`/`ICatchCameraAssistImpl` 的 transportType | 无 |
| 字面量 | `own-literals.tsv`（1.17 MB）按信号切出 `signals-{cgiCmd,fullUrls,hosts,ips,queryStrings,httpPaths,keyLike,actions,wifiSsid,crypto,hexMagic,fsPaths,mime,exts,uaSdk}.tsv` 全部逐条判定（附录 B/D） | 非信号型（日志文案、异常消息）只抽样，因为对复现无价值 |
| 符号 | `natives-symbols.tsv` 55052 条中：`Java_*` 343 条全部反解（附录 C §2）、`libcontrol.so` 2081 导出中的 160 条按类聚合、`ptp*`/`icatch_*` 关键符号逐个定位；另对 `apk-files/lib/arm64-v8a/libcontrol.so` 做**二次全量 strings（3948 条）+ ELF section + AArch64 MOVZ 立即数扫描** | **native 内部的「语义方法 → 属性 ID」与 PTP/IP 端口常量：静态无解**（方法与证据见附录 C §3.5、§3.6） |
| 资源 | `manifest.md`（51 组件 / 35 权限）、`res-strings-default.md`、`res-strings-zh.md`、`res-locales.md`、`layouts.md`（344 个 XML）、`res/xml/*.xml` 实值、`assets-index.md`、`assets-content.md` | drawable/mipmap 位图未逐个看内容（与操作能力无关） |
| 行为 | 连接、预览、拍照/录像/模式、参数、回放、格式化、改 WiFi、固件升级、直播 9 类操作的**请求序列**（§6） | 每类操作的「成功判据」中依赖固件返回值的部分标为待真机确认（§8） |

---

## 1. 身份与清单

### 1.1 包与版本（`_work/re/idgolive/manifest.md:12-24`）

| 字段 | 值 |
|---|---|
| package | `com.id221.golive` |
| versionCode / versionName | `75` / `1.3.6` |
| minSdk / targetSdk / platformBuildVersion | `28` / `35` / `35 (Android 15)` |
| installLocation | `default` |
| Java 包名 / application 类 | `com.icatch.golive` / `com.icatch.golive.Application.PanoramaApp` |
| **App 内自称版本** | `AppInfo.APP_VERSION = "V1.4.3"`（`data/AppInfo/AppInfo.java:16`），**与 versionName 1.3.6 不一致** |
| **SDK 版本** | `AppInfo.SDK_VERSION = "V3.6.0.39"`（`:27`），EULA `:21` = `"1.3"` |
| native 构建号 | `5345600`（`libcontrol.so` .rodata）；工具链 `Android (5058415 based on r339409) clang 8.0.2` |

`APP_VERSION` 会作为 `netconfig.properties` 的第一条配置键写进 `/idGoLive/Resoure/netconfig.properties`（`data/AppInfo/ConfigureInfo.java:20` 的 `cfgTopic[0] = "AppVersion=V1.4.3"`），也就是说**版本自检走的是 V1.4.3 这条线**，复现时要区分「市场版本号」与「协议版本号」。

### 1.2 `<application>` 属性（`manifest.md:28-40`）及后果

| 属性 | 值 | 复现含义 |
|---|---|---|
| theme | `@style/FullScreenTheme` | 全屏无 ActionBar |
| allowBackup | `true` | 可 `adb backup` 拖出 `netconfig.properties` 与 SP（含改过的 `inputIp`、`default_pwd`） |
| hardwareAccelerated | `true` | — |
| supportsRtl | `true` | — |
| extractNativeLibs | `true` | .so 解到 `/data/app/.../lib/`，**允许 `adb shell` 直接读 libcontrol.so**（本次深挖即得益于此） |
| networkSecurityConfig | `@xml/network_security_config` | 实值（`_work/idgo_live_src/resources/res/xml/network_security_config.xml`）：`<base-config cleartextTrafficPermitted="true"/>` —— **全域允许明文**，等价于 `usesCleartextTraffic=true` 的更宽版本 |
| requestLegacyExternalStorage | `true` | Android 10 上仍走分区存储前的路径，配合 `maxSdkVersion=32` 的 READ/WRITE_EXTERNAL_STORAGE |
| appComponentFactory | `androidx.core.app.CoreComponentFactory` | — |
| 无 `android:usesCleartextTraffic` | — | 明文完全由 networkSecurityConfig 放行 |

`res/xml/jz_network_security_config.xml` 内容与上面完全相同（`com.yanzhenjie.album` 自带），未挂到 `application`。
`res/xml/ad_services_config.xml`：`<attribution allowAllToAccess="true"/><custom-audiences allowAllToAccess="true"/><topics allowAllToAccess="true"/>` —— 为 4 条 `ACCESS_ADSERVICES_*` 权限配套，但包内**无广告 SDK**，属死配置。

### 1.3 35 条 uses-permission 逐条用途

`file:line` 指 `_work/re/idgolive/manifest.md` 的清单行；用途证据指源码行。

| # | 权限 | manifest 行 | 用途（谁在用） | 判定 |
|---|---|---|---|---|
| 1 | `INTERNET` | :48 | 所有 OkHttp/Socket（`net/ApiCaller.java:96`） | 必需 |
| 2 | `ACCESS_NETWORK_STATE` | :49 | `baseutil/network/NetWorkUtils.java` 判网 | 必需 |
| 3 | `ACCESS_WIFI_STATE` | :50 | `utils/WifiAPUtil.getLocalIPAddressFromWifiInfo()`（`MyCamera/MyCamera.java:149`）、`CoreMulticast.createMulticastLock`（`control/core/CoreMulticast.java:21`）、`data/SystemInfo/{HotSpot,MWifiManager}.java` | 必需 |
| 4 | `READ_EXTERNAL_STORAGE`（maxSdk 32） | :51 | 读相机下载的 MP4/JPG、`utils/fileutils/FileUtil.java` | 必需（≤12L） |
| 5 | `WRITE_EXTERNAL_STORAGE`（maxSdk 32） | :52 | 写 `/DCIM/idGoLive/{photo,video}`（`_work/idgo_live_src/sources/com/icatch/golive/data/AppInfo/AppInfo.java:17-20`）、SDK 日志目录（`:26`） | 必需（≤12L） |
| 6 | `READ_MEDIA_VISUAL_USER_SELECTED` | :53 | Android 14 部分照片授权，配合 `com.yanzhenjie.album` 选图分享 | 用 |
| 7 | `SYSTEM_ALERT_WINDOW` | :54 | `basecomponent/prompt/{MyToast,AppDialog}` 悬浮进度；未见 `TYPE_APPLICATION_OVERLAY` 硬编码 | 声明用 |
| 8 | `KILL_BACKGROUND_PROCESSES` | :55 | `data/GlobalApp/ExitApp.java` 退进程 | 用 |
| 9 | `WAKE_LOCK` | :56 | 预览/下载保亮屏（配合 `DISABLE_KEYGUARD`） | 用 |
| 10 | `CHANGE_NETWORK_STATE` | :57 | `utils/WifiNetworkSpecifierUtil.java`（Android 10+ 用 `WifiNetworkSpecifier` 直连相机 AP，`Presenter/LaunchPresenter.java:249-266`） | **关键** |
| 11 | `CHANGE_WIFI_STATE` | :58 | 同上 + `MWifiManager`；`net/ConnectDeviceManager` 不直接改 | **关键** |
| 12 | `ACCESS_NETWORK_STATE`（重复声明） | :59 | 与 #2 完全重复，合并无害 | 冗余 |
| 13 | `ACCESS_WIFI_STATE`（重复声明） | :60 | 与 #3 重复 | 冗余 |
| 14 | `READ_PHONE_STATE` | :61 | 设备标识/`getDeviceId`（旧埋点），未见稳定调用 | 大概率冗余 |
| 15 | `RECEIVE_BOOT_COMPLETED` | :62 | **包内只有 3 个 receiver**（`manifest.md:189-199`：2 个 Facebook token + `ProfileInstallReceiver`），**无 `BOOT_COMPLETED` 接收器** | **声明未用** |
| 16 | `VIBRATE` | :63 | 快门/触碰反馈 | 用 |
| 17 | `ACCESS_DOWNLOAD_MANAGER` | :64 | 系统级权限，普通 App 拿不到；下载实走 `net/OkHttpDownUtil.java` | **无效声明** |
| 18 | `DOWNLOAD_WITHOUT_NOTIFICATION` | :65 | 同上，`DownloadManager` 未使用 | **声明未用** |
| 19 | `DISABLE_KEYGUARD` | :66 | 预览时不锁屏（与 `WAKE_LOCK` 成套） | 用/兼容 |
| 20 | `MODIFY_AUDIO_SETTINGS` | :67 | 直播推流音频、`baseutil/AudioFocusUtil.java`、`ICatchCamWifiMode` 无关 | 用 |
| 21 | `BLUETOOTH` | :68 | `com/icatch/bluetooth/sdk/**` + `com/icatchtek/bluetooth/**` + `Presenter/BTPairBeginPresenter.java`(444 行) | **不足**（见下） |
| 22 | `BLUETOOTH_ADMIN` | :69 | 同上（`startDiscovery`/`cancelDiscovery`） | **不足** |
| 23 | `CHANGE_WIFI_MULTICAST_STAT` | :70 | **拼错**（正字 `..._MULTICAST_CAST`）；组播靠 `MulticastLock` 仍可工作 | 见附录 D §5 |
| 24 | `CHANGE_WIFI_STATE`（第三次声明） | :71 | 与 #11 重复 | 冗余 |
| 25 | `CHANGE_WIMAX_STATE` | :72 | WiMAX 早在 Android 5 移除 | **死权限** |
| 26 | `ACCESS_COARSE_LOCATION` | :73 | Android 6-9 上 `getScanResults()`/SSID 读取的前置条件（`WifiAPUtil`） | 用（历史） |
| 27 | `ACCESS_FINE_LOCATION` | :74 | 同上 | 用（历史） |
| 28 | `CAMERA` | :75 | 不是自拍，而是 **USB 相机流程的前置**：`_work/idgo_live_src/sources/com/icatch/golive/Presenter/LaunchPresenter.java:371-380` 里 `PermissionTools.checkCameraSelfPermission` / `requestCameraPermissions` 与 `request_camera_permission_warn_info` 弹窗 | 用 |
| 29 | `RECORD_AUDIO` | :76 | 直播/录像音频、`AudioFocusUtil` | 用 |
| 30 | `ACCESS_ADSERVICES_ATTRIBUTION` | :77 | 为 `ad_services_config.xml`；无广告 SDK | **死权限** |
| 31 | `ACCESS_ADSERVICES_AD_ID` | :78 | 同上（`AdvertisingIdClient`） | **死权限** |
| 32 | `ACCESS_ADSERVICES_CUSTOM_AUDIENCE` | :79 | 同上 | **死权限** |
| 33 | `ACCESS_ADSERVICES_TOPICS` | :80 | 同上 | **死权限** |
| 34 | `com.id221.golive.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` | :81 | androidx.core 在 targetSdk≥34 自动加，配套 `:88` 的 signature 级自定义权限 | 库自动 |
| 35 | `com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE` | :82 | `com.android.installreferrer` 库（渠道归因，id221/idalbum 渠道识别） | 库带入，实际未用 |

**新发现（重要）：蓝牙权限在 Android 12+ 上是坏的。**
清单只声明 `BLUETOOTH` + `BLUETOOTH_ADMIN`（legacy，API ≤30），**没有** `BLUETOOTH_SCAN` / `BLUETOOTH_CONNECT` / `BLUETOOTH_ADVERTISE`，而 `targetSdk = 35`。
⇒ `BTPairBeginPresenter` 的 `startDiscovery()` / GATT 连接（`com/icatchtek/bluetooth/core/client/bt/ICatchCoreBluetoothClient.java`、`btle/ICatchCoreBluetoothLeClient.java`）在 Android 12+ 设备上会抛 `SecurityException`。
复现时应正确声明 `BLUETOOTH_CONNECT`/`BLUETOOTH_SCAN`（`neverForLocation` 可选）而不是照抄。

自定义权限（`manifest.md:88`）：`com.id221.golive.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`，`protectionLevel=signature`。
uses-feature（`:94`）：`android.hardware.usb.host` **required**（默认 true）⇒ **无 USB Host 的设备在 Play 上被过滤掉**。
uses-library：无。queries：只有 `package:com.facebook.katana`（`:104`）。

### 1.4 51 个组件职责（`manifest.md:119-218`；activity 43 / service 1 / receiver 3 / provider 4）

**入口与主流程（10）**

| 组件 | 属性要点 | 职责 |
|---|---|---|
| `ui.activity.StartPageActivity` | `exported=true`，MAIN+LAUNCHER | 冷启动、隐私协议门槛（URL 见附录 D §3） |
| `ui.activity.LaunchActivity` | `exported=true`，`sensorPortrait`，`USB_DEVICE_ATTACHED` + `meta-data @xml/device_filter` | 机位槽主页 + USB 插入自动拉起 |
| `ui.activity.PreviewActivity` | `label=@string/title_activity_preview`，portrait，configChanges=screenSize\|orientation\|keyboardHidden | PTP 机预览主界面（1225 行 + `PreviewPresenter` 2507 行） |
| `ui.activity.USBPreviewActivity` | — | UVC USB 机预览（608 行 + `USBPreviewPresenter` 1450 行） |
| `ui.activity.LYLiveVideoActivity` | label 同上 | 白牌机（HTTP/RTSP）直播页（780 行） |
| `ui.activity.LdeviceSettingActivity` | — | **L**yIC（192.168.1.254 Novatek）设置页（1034 行） |
| `ui.activity.YdeviceSettingActivity` | — | **Y**zIC（192.168.169.1 /api+/app JSON）设置页（780 行） |
| `ui.activity.LYRemoteFileActivity` | — | 白牌机回放列表 |
| `ui.activity.LYDownloadFileActivity` | — | 白牌机下载管理 |
| `ui.activity.LYVideoPlayerActivity` / `RtspPlayerActivity` | portrait | 白牌机录像回放 / 纯 RTSP 播放 |

**PTP 机回放与本地相册（13）**
`RemoteMultiPbActivity`（FullScreen 主题，singleTask）、`RemoteMultiPbActivity2`、`PhotoPbActivity`、`VideoPbActivity`（label `title_activity_panorama_video_pb` ⇒ 全景视频）、`LocalMultiPbActivity`、`LocalPhotoPbActivity`、`LocalVideoPbActivity`、`CommonVideoPlayerActivity`、`LocalVideoPlayerActivity`、`activity_exo_test`（ExoPlayer 试验页）、`PvParamSettingActivity`（预览参数）、`WifiApActivity`（手机热点）、`ConnectCourseActivity`（连接教程）。

**账号/分享/杂项（12）**
`LoginFacebookActivity`、`LoginGoogleActivity`、`FeedbackActivity`、`AboutAppActivity`、`DownloadFirmwareActivity`、`ChangeLanguageActivity`、`WebActivity`、`LaunchHelpActivity`（label `@string/help`）、`LicenseAgreementActivity`（label `@string/title_privacy_policy`）、`androidx`/`album` 的 `AlbumActivity`/`GalleryActivity`/`NullActivity`/`gallery.GalleryActivity`/`gallery.GalleryAlbumActivity`/`camera.CameraActivity`（相册选图，`com.yanzhenjie.album`）。

**库注册（5）**：`com.facebook.FacebookActivity`、`CustomTabMainActivity`、`CustomTabActivity`（`exported=true`，`fbconnect://cct.com.id221.golive`）、`gms.auth...SignInHubActivity`、`gms.common.api.GoogleApiActivity`。

**service（1）**：只有 `gms...RevocationBoundService`（`permission=REVOCATION_NOTIFICATION`，exported）。⇒ **App 没有自己的前台/后台 Service**；预览、下载、心跳全在 Activity/Handler 里，退到后台即断。这是复现时值得改进的结构性差异。

**receiver（3）**：`facebook.CurrentAccessTokenExpirationBroadcastReceiver`、`facebook.AuthenticationTokenManager.CurrentAuthenticationTokenChangedBroadcastReceiver`、`androidx.profileinstaller.ProfileInstallReceiver`（`permission=DUMP`，4 个 action）。⇒ 厂商**没有任何** `BOOT_COMPLETED` / `WIFI_STATE_CHANGED` 接收器（那些 action 只在代码里 `IntentFilter` 动态注册，见 `baseutil/InnerRecevier.java`）。

**provider（4）**：`album.provider.CameraFileProvider`（authority `com.id221.golive.app.file.provider`，`@xml/album_camera_provider`）、`facebook.internal.FacebookInitProvider`（authority `com.id221.golive.FacebookInitProvider`）、`androidx.core.content.FileProvider`（authority `com.id221.golive.provider`，`@xml/file_provider_path`）、`androidx.startup.InitializationProvider`（authority `com.id221.golive.androidx-startup`）。

`file_provider_path.xml` 实值（`resources/res/xml/file_provider_path.xml`）值得照抄的只有一条：
`<external-path name="local_video_photo_path" path="DCIM/idGoLive"/>` —— 与 `AppInfo.DOWNLOAD_PATH="/DCIM/idGoLive/"` 对齐；其余 6 条（external `.`、external_files `.`、cache `.`、external_cache `.`、files `.`、**`<root-path name="sdcard1" path="."/>`**）里 root-path 挂整个文件系统，属过度授权。
`device_filter.xml` 实值：两个 USB 设备 —— `vendor-id=10925 product-id=25859`（`0x2AAD:0x6503`）、`vendor-id=16716 product-id=25971`（`0x414C:0x6573`）。**这是包内唯一的「机型注册表」**，只覆盖 USB 通路；WiFi 侧确实无型号表（见 §2）。

---

## 2. 「无型号注册表、靠 ping 选 handler」的准确表述

复现前必须建立的四条事实：

1. **没有「机型 → 能力」注册表，但有一条 33 项的「机型 → 禁用某功能」黑名单。**
   `CameraType`（`MyCamera/CameraType.java`）只有 `UNDEFIND_CAMERA=0`、`USB_CAMERA=1`、`WIFI_CAMERA=2`、`OLD_WIFI_CAMERA=3`；`CameraAddType`（`CameraAddType.java`）只有 `DEFAULT=0`、`WIFI_CONNECTION_AUTO=1`、`WIFI_CONNECTION_MANUAL=2`、`USB_CONNECTION=3`、`BT_CONNECTION=4`。**没有任何品牌/芯片枚举。**
   唯一按机型分叉的代码是 `SdkApi/CameraProperties.java:1476` 的 `Arrays.asList(...)`，
   命中即让 `setCameraDateTimeZone()` **直接 `return false`，不写 `0xD83E`**（判据是 `CameraFixedInfo.getCameraName()` 与列表**全等**，`:1478`）。见 §2.1。
   ⇒ 正确表述：**「能力靠探测（PTP 属性/事件 + HTTP capability），例外靠一张写死的相机名黑名单」**。

### 2.1 相机名黑名单全量（`_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:1476`，33 项（`Arrays.asList` 实参逐个点数），顺序原样）

```
A86, A87, GA200, GA300, GA320, GA400, GA420, SF430, SF530, CT9300, DV19, AC9000,
DiCam880, DiCam870, DiCam80C, X7.2-LMXX72, X9.2-LMXX92, DC790, K10,
Victure/AC920, Victure/AC940, Crosstour/CT9900, Niceboy, Model : YDOL3,
Action Cam, Action Cam - 078, Action Cam - 258, Action Cam - 278,
Action Cam - 317, Action Cam - 386, Action Cam - 458, Action Camera, V40
```
读法与结论：
- `A86/A87/GA2xx-4xx/SF430/SF530/CT9300/DV19/AC9000/AC920/AC940` = Generic/Ambarella 与 iCatch 参考板型号。
- `Victure/AC920`、`Victure/AC940`、`Crosstour/CT9900`、`Niceboy`、`Model : YDOL3` = **贴牌机名直接出现在本 APK 源码里**，
  这就是白标证据链：同一份 App 通过 PTP `0xD831 CAMERA_NAME` 读回来的字符串识别贴牌客户，
  ⇒ 修正旧说法「贴牌名不在本 APK 内」。
- `Action Cam`、`Action Cam - <3位数字>`、`Action Camera` = 通用无名固件。
- 语义：**这些固件不接受 `0xD83E`（时区）写入**（写了会失败/挂死），所以 App 跳过。复现时应保留同名黑名单，
  并把「跳过写时区」作为固件兼容策略；`Nikon`/`Sony` 之类品牌未出现。
- 该列表是 `contains()` 全等匹配，**不是前缀匹配** ⇒ `Action Cam - 079` 不会命中，会继续尝试写时区。


### 2.2 探测与回退

`ConnectDeviceManager.initDevice()`（`net/ConnectDeviceManager.java:46-77`）并行 `ping -c 3 -w 3 192.168.1.254` 与 `ping -c 3 -w 3 192.168.169.1`（命令串在 `:266`），
`.254` 应答 → `try2connectLyIC()`（`:89-110`）；`.169.1` 应答 → `try2connectYzIC()`（`:136-153`）；两边都用 `getSSID()` 是否返回非 null 作最终判据。
**注意：PTP 机（`192.168.1.1`）不在这个探测里** —— 它是更前面一步 `MyCamera.connect(true)` 的结果，见 §6.1。

### 2.3 共享失败计数器 bug

两个 ping 回调对同一个 `failure_connect_count` 做 `access$008()` 自增（`:33-37/57/71`），任一 ping 失败两次即 `handler.sendEmptyMessage(404)` 提前放弃，两路不是独立的。


⇒ 建议复现时的表述：idGoLive 的「机型识别」= `PTP 会话成败` + `ICMP 探活（应答者 IP 决定 LyIC / QzIC）` + `getSSID 成败（决定 handler 生效）` + `相机名黑名单（决定个别属性是否下发）`，四层，**没有「机型 → 能力」静态表，但有「机型名 → 跳过某功能」静态表（§2.1）**。

---

## 3. 传输通道清单（**11 条**，旧文档的 8 条不完整）

| # | 通道 | 默认主机 | 端口 | 协议 | 健康检查 | 建立顺序 / 失败回退 | 关键实参（数值） | 代码 |
|---|---|---|---|---|---|---|---|---|
| 1 | **PTP / PTP-IP** | `AppInfo.inputIp = "192.168.1.1"`（`data/AppInfo/AppInfo.java:51`，SP 可覆盖，`_work/idgo_live_src/sources/com/icatch/golive/Presenter/LaunchPresenter.java:620` 默认值同样是 `"192.168.1.1"`） | **静态无解**（附录 C §3.5；规范默认 15740） | PTP container over TCP（cmd/data/event 三 socket） | `JCameraSession.checkConnection_Jni` → `ICatchCameraSession.checkConnection()`（`customer/ICatchCameraSession.java:46-49`）；native `ptp disconnected, check result: %s.` | **最先试**：`MyCamera.connect(true)` → `CommandSession.prepareSession(transport, true)` → `enablePTPIP()`（`MyCamera/CommandSession.java:99-124`）。失败 → 回退到 #5/#6 | `enablePTPIP` 前调 `setConnectionCheckParam(times=4, interval=4, 0)`（`_work/idgo_live_src/sources/com/icatch/golive/MyCamera/CommandSession.java:120`；`_work/idgo_live_src/sources/com/icatch/golive/data/AppInfo/AppInfo.java:57-58`），native `enablePtpReconnect(true/false)` 由 `AppInfo.isNeedReconnect=true`（`:53`）驱动；断线重连次数 `disconnectRetry=10`（`_work/idgo_live_src/sources/com/icatch/golive/data/AppInfo/ConfigureInfo.java:20`） | `MyCamera/MyCamera.java:130-185` |
| 2 | **PTP over USB（UVC BULK）** | — | USB 端点 | UVC bulk | `USBMonitor.hasPermission` | `connect(false)` → `prepareSessionUVC(session, **true, -1, -1, -1**)`（`_work/idgo_live_src/sources/com/icatchtek/control/customer/ICatchCameraSession.java:94-97`） | vendor 见 device_filter | `_work/idgo_live_src/sources/com/icatch/golive/MyCamera/MyCamera.java:135-146` |
| 3 | **PTP over USB（UVC ISO）** | — | — | UVC isoc | — | `prepareSession_Jni(sid, **false**, vid, pid, fd)`（`:98-102`） | `ICatchUVCIsoTransport.prepareTransport()` → `JUsbTransportCore.initUvc_Jni(vid,pid,"",fd)` | `reliant/customer/transport/ICatchUVCIsoTransport.java:54` |
| 4 | **PTP over USB（MSC / SCSI）** | — | — | Bulk-Only + SCSI | `getCurrentMode()`/`switchToPreview`/`switchToPlayback` | 同一 `prepareSession_Jni(true,-1,-1,-1)`（`:103-106`） | `USB_TRANSPORT_ERROR_TRY_AGAIN = -200` → `IchTryAgainException` | `_work/idgo_live_src/sources/com/icatchtek/reliant/customer/transport/ICatchUsbScsiTransport.java:14-64` |
| 5 | **HTTP CGI（Novatek 风格）** | `http://192.168.1.254/`（`RequestInfo.urlHOST:34`） | TCP 80（URL 未写端口） | HTTP GET/POST，XML 响应 | `ping -c 3 -w 3`；再 `cmd=3029` 取 SSID | PTP 失败后 `ConnectDeviceManager.getSSID(...)`（`_work/idgo_live_src/sources/com/icatch/golive/Presenter/LaunchPresenter.java:298`） | 心跳 `cmd=8888` 每 **10000 ms**；备选 `cmd=3016` | `net/LyIC.java`（427 行） |
| 6 | **HTTP `/app/`+`/api/` JSON** | `http://192.168.169.1/`（`M1RequestInfo.urlHOST:23`）；`LyCmdWithYzIC` 用 `http://192.168.1.254/`（`LyWyzRequestInfo.urlHOST:25`） | TCP 80，文件 URL 带显式 `:80` | HTTP，JSON `{result,info}` | 同上（`cmd=/app/getdeviceattr` → `info.ssid`） | `ping .169.1` 应答 → `QzIC` | 心跳 `/app/getparamvalue?param=rec` 每 **4000 ms**；分页 `start/end` 步长 **101**（首屏 `0..99`） | `net/QzIC.java`（518 行）/ `net/LyCmdWithYzIC.java`（482 行，**死代码**） |
| 7 | **XML-over-TCP（相机主动推）** | `192.168.1.254` | **3333** | 裸 TCP，UTF-8 XML，`</Function>` 分帧 | 无独立探活（随 #5 建立） | #5 `getSSID` 成功即 `initSocket()` | 连接超时 **5000 ms**，读缓冲 **1024 B**，标签 `Cmd`/`Status`，`Status` 缺省 `"0"` | `net/LySocketClient.java:44-138`、`net/LyIC.java:289` |
| 8 | **RTSP（副机/第二镜头）** | `rtsp://192.168.1.254`、`rtsp://192.168.169.1`、`rtsp://192.168.1.1` | 554（由 ijkplayer 决定） | RTSP + IjkPlayer | 播放器 `isPlaying` | **先 `cmd=2015&par=1` 开流**，再切模式/起录 | 关闭 `cmd=2015&par=0` | `_work/idgo_live_src/sources/com/icatch/golive/net/RequestInfo.java:44-45`；`LyIC.ready2CamLive` `:332-344` |
| 9 | **UDP 组播发现 / 配网** | 组 `234.168.168.168` | **5002** | Java：只收；native：`simpleconfig` 收+发（AES-CBC-128） | `MulticastSocket.setSoTimeout(**200**)`，轮询 sleep **50 ms**，总超时 **180 s** | 独立于连接流程；`ICatchCameraAssistImpl.simpleConfig` 触发 | 默认 key `21 7E 1A 16 28 DE CE A9 AB E7 85 88 09 CA 80 3C`；包 `byte[256]` | `control/core/CoreMulticast.java:15-16/21-30/53-60`；`_work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraAssistImpl.java:17/51/64-77/222-263` |
| 10 | **蓝牙 / BLE 配对** | — | SPP / GATT | 文本帧（`BluetoothTextTransfer`、`ICatchCoreBluetoothLeTextTransfer`） | bond 状态广播 | `AddNewCamFragment` 的 `bt_pair` → `BTPairBeginPresenter` | `AppInfo.curBtDevice`、`isBLE`、`isReleaseBTClient`（`_work/idgo_live_src/sources/com/icatch/golive/data/AppInfo/AppInfo.java:32/46/47`） | `com/icatch/bluetooth/sdk/**`、`com/icatchtek/bluetooth/**` |
| 11 | **RTMP 推流（直播上行）** | YouTube `a.rtmp.youtube.com`；泛化推流由 `JStreamPublish` | 1935 | RTMP + H.264/AAC，token 走 HTTPS Google API | — | 全景机 `libpanorama_vr.so` 内部 | API 端点全表见附录 D §3 | `Function/live/**`、`pancam/core/feature/stream/ICatchStreamPublish.java` |

**未启用但存在**：`enableSocketIO()` / `disableSocketIO()`（`_work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraConfigImpl.java:49-66`）在厂商包内**没有任何调用点** ⇒ iCatch 的另一套「socketIO 私有二进制通道」被 SDK 提供但 App 未接。

### 3.1 缓冲区与超时数值汇总（复现直接可用）

| 项 | 值 | 位置 |
|---|---|---|
| ICMP ping | `-c 3 -w 3`（3 包、3 s 壁钟） | `net/ConnectDeviceManager.java:266` |
| ping 失败阈值 | 计数达 **2** → 404 | `:58/72` |
| TCP:3333 连接超时 | 5000 ms | `_work/idgo_live_src/sources/com/icatch/golive/net/LySocketClient.java:125` |
| TCP:3333 读缓冲 | 1024 B | `:49` |
| 组播 socket 超时 | 200 ms | `_work/idgo_live_src/sources/com/icatchtek/control/core/CoreMulticast.java:30` |
| 组播收包缓冲 | 256 B | `:43` |
| 组播轮询 | sleep 50 ms | `_work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraAssistImpl.java:74` |
| simpleConfig 超时 | 180 s | `:223` |
| PTP 连接检查 | times 4 / interval 4（单位由 native 决定，getter 名为 `...InSecs` ⇒ 秒） | `_work/idgo_live_src/sources/com/icatch/golive/data/AppInfo/AppInfo.java:57-58` + `_work/idgo_live_src/sources/com/icatch/golive/MyCamera/CommandSession.java:120` |
| 断线重连次数 | 10（`disconnectRetry`，可被 `netconfig.properties` 覆盖） | `_work/idgo_live_src/sources/com/icatch/golive/data/AppInfo/ConfigureInfo.java:20` |
| 心跳周期 | LyIC 10000 / QzIC 4000 / LyCmdWithYzIC 4000 / 无 IC 30000 ms | `_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:225`、`_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:239`、`_work/idgo_live_src/sources/com/icatch/golive/net/LyCmdWithYzIC.java:188`、`_work/idgo_live_src/sources/com/icatch/golive/net/ConnectDeviceManager.java:205` |
| 格式化超时 | 「timeout is 15s」（日志原文，实际等待在 native） | `SdkApi/CameraAction.java:152` 体内字面量 |
| HTTP 上传超时 | connect 30 s / read 60 s / write 60 s | `_work/idgo_live_src/sources/com/icatch/golive/net/ApiCaller.java:148` |
| HTTP 常规请求 | **无超时设置**（OkHttp 默认 connect 10 s / read 10 s / write 10 s） | `_work/idgo_live_src/sources/com/icatch/golive/net/ApiCaller.java:96/118` |
| native 返回错误兜底 | `-11111`（err）、`-1`（int）、`-1L`、`-1.0d`、`null` | `NativeValueUtil.java:25/33/41/17/49` |
| 下载并发 | 文案硬编码「下载(最多5个)」 | `res-strings-zh.md: download` |
| 断点续传 | 标准 `RANGE: bytes=<alreadyDownLength>-` | `net/OkHttpDownUtil.java:119`（GET）、`:242`（**同一 header 用在 POST 上**，可疑） |
| 预览裸流落盘 | `%s/stream_dump_vid_%ld_%ld.raw`、`..._aud_...` | `libcontrol.so` .rodata |

---

## 4. PTP 属性表 / HTTP 命令目录 / PTP-IP 帧格式（三张长表的入口）

| 主题 | 全量位置 | 一句话结论 |
|---|---|---|
| PTP 设备属性 ID | [附录 A](03-idGoLive-档案-附录-PTP属性表.md) | **57 个码点分布在 5 组**：`0x50xx`(10)、`0xD6xx`(6)、`0xD7xx`(28)、`0xD8xx`(10)、高位 `0xE604`/`0xEE00`/`0xFFFF`(3)。一个 ID 多重载的是 **`0xD7FB`(55291) 三重载** 与 **`0xD834`/`0xD835` 双重载**，**不是 `0xD7DB`**（该值不存在） |
| `cmd=NNNN` 命令目录 | [附录 B §2](03-idGoLive-档案-附录-HTTP与TCP命令.md) | Novatek 风格 59 条常量、38 个不同 cmd 编号，逐条给出编号/参数/响应标签/解析函数/调用点 |
| `/app/`、`/api/` JSON 端点 | [附录 B §3](03-idGoLive-档案-附录-HTTP与TCP命令.md) | 42 + 44 条，两条主机同一模板 |
| XML-over-TCP:3333 | [附录 B §4](03-idGoLive-档案-附录-HTTP与TCP命令.md) | 报文结构、标签、编码、超时、分帧、无心跳 |
| PTP-IP 帧与操作码 | [附录 C §3](03-idGoLive-档案-附录-原生层与PTPIP.md) | 14 字节 container 头 + PTP/IP 的 `[2B opType]` 前缀；阶段名由 native 日志串 `ptpip/init_cmd`…`ptpip/oprequest` 直接证实；端口静态无解 |
| 63 个 .so / 343 条 JNI | [附录 C §1-§2](03-idGoLive-档案-附录-原生层与PTPIP.md) | ARM-only 的相机 SDK；`libcontrol.so` 是 libptp+libptp2 双份混编 |
| UI 面与文案 | [附录 D §1-§2](03-idGoLive-档案-附录-UI与端点判定.md) | 316 layout、英/中双文案、入口映射表 |
| 云端端点与遥测 | [附录 D §3](03-idGoLive-档案-附录-UI与端点判定.md) | 逐个「真在用/声明未用/死重量」判定 |

---

## 5. 设置项的真相：三种不同的「参数设置」实现

同一份用户可见设置，在三类设备上走三套机制：

| 机型族 | 机制 | 参数落点 | 提交时机 |
|---|---|---|---|
| PTP 机（iCatch 方案） | 每个设置项一个 `PropertyTypeInteger/String` 对象，包着 `getCurrentPropertyValue(id)` / `getSupportedPropertyValues(id)` / `setPropertyValue(id,v)` | PTP `0x50xx/0xD6xx/0xD7xx/0xD8xx/0xEE00`（附录 A §1-2） | 选中即写；`Function/Setting/OptionSetting.java` 的 31 个 `showXxxDialog`（`:465-1356`）是 UI 层 |
| LyIC（`.254`） | 每条设置一个固定 URL | `cmd=NNNN&par=K` / `str=`（附录 B §2） | **累积后统一 `cmd=3021`（`urlSaveMenuSettings`）提交** |
| QzIC/YzIC | `param` 键值 | `/app/setparamvalue?param=<p>&value=<v>`、`/api/setdeviceinfo/?custom=1&cmd=…&par=…` | 逐个即时写 |

设置项列表由固件决定：PTP 机走 `getSupportedProperties()`（`_work/idgo_live_src/sources/com/icatchtek/control/customer/ICatchCameraProperty.java:73`）；
LyIC 走 `cmd=3031&str=all` 拿 `Cmd/Index/Id` 三元组，App 按 **`Cmd`** 值分流（`XmlParseUtil.java:39-52` 里 `strNextText` 读的是 `<Cmd>`，不是 `<Id>`）：`Cmd=2003` 收 `Index→Id` 映射，`2011/8010/8011` 各收一组 `Id`（`_work/idgo_live_src/sources/com/icatch/golive/utils/XmlParseUtil.java:41-52`），**其它 `Cmd` 的条目直接丢弃** ⇒ 新固件加设置项不会自动出现在 UI。

**EV（曝光补偿）解码规则**（此前没读出来过）：
`utils/ConvertTools.getExposureCompensation(int)`（`:60-67`）
- bit31（`Integer.MIN_VALUE`）= 符号 → 前缀 `"EV -"`
- **bit30（`0x40000000`）= 「数值要除以 10」标志**；置位则 `value/10.0`，否则 `value/1.0`
- 有效数值 = `i & 0x00FFFFFF`
⇒ 复现 `0xD723` 时必须实现这条位标志，否则 EV 会差 10 倍。
`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:149` 的 `iIntValue % 1000` 是另一处（录像时长/秒）归一。

---

## 6. 操作复现表

每行 = 一个用户操作，给出请求序列、参数值、成功判据、失败提示资源 id。

### 6.1 连接（PTP 机）

```
1) LaunchPresenter.autoConnectDeviceWifi(pos, name, ssid, pwd)   // SDK_INT>=29 才走系统弹窗直连
     WifiNetworkSpecifierUtil.connectWifi(ctx, ssid, pwd, cb)   // Presenter/LaunchPresenter.java:248-266
     SSID 合法正则：[\u4E00-\u9FA5a-zA-z0-9@_-]+.*              // :269
2) beginConnectCamera(pos, ip, ssid, addType, pwd)              // :287-316
     a. CameraManager.createCamera(WIFI_CAMERA=2, ssid, ip, pos, 1, addType, pwd)
     b. MyCamera.connect(enablePTPIP = true)                    // _work/idgo_live_src/sources/com/icatch/golive/MyCamera/MyCamera.java:130
          transport = new ICatchINETTransport(ip, WifiAPUtil.getLocalIPAddressFromWifiInfo(ctx))
          transport.prepareTransport()                         // NET 实现为空操作直接 true
          CommandSession.prepareSession(transport, true)
              ICatchCameraSession.getCameraConfig(transport).enablePTPIP()   // JNI: (1, ip, -1,-1,-1)
              setConnectionCheckParam(4, 4, 0)
              ICatchCameraSession.createSession()  // 构造即 createJniSession_Jni()
              session.prepareSession(transport)    // JNI: prepareSessionNET(sid, ip, "", "")
          PanoramaSession.prepareSession(transport)             // 全景第二会话（libpanorama_vr）
     c. cameraAction = new CameraAction(controlClient, ICatchCameraSession.getCameraAssist(transport))
     d. initCamera(): CameraFixedInfo / CameraProperties / CameraState / FileOperation
                     + Panorama{Photo,Preview,Video}Playback + PanoramaControl   // :109-127
3) 成功后立刻（顺序固定）：
     if (hasFuction(0xD83E)) setCameraDateTimeZone();           // :302-304
     if (hasFuction(0x5011)) setCameraDate();                   // :305-307
4) CameraSlotSQLite.update(new CameraSlot(pos,true,ssid,2,null,true,addType,pwd))  // 写两次（:308-309 重复）
```
**成功判据**：`connect()` 返回 true（= `prepareSession` 的 JNI 返回 `RET_INT >= 0`）+ `checkConnection()` 为 true。
**失败回退**：`ConnectDeviceManager.getInstance().clearIC(); getSSID(new AnonymousClass18(...))`（`:297-299`）→ 进入 §3 通道 #5/#6 的 ping 探测。
**失败提示**：`R.string.dialog_connect_failed`（「连接失败，请重试.」）、进度框 `R.string.dialog_connecting_to_cam`（「连接相机...」）、密码错 `R.string.action_device_pwd_error`（`_work/idgo_live_src/sources/com/icatch/golive/Presenter/LaunchPresenter.java:277`）。
**USB 机**：`beginConnectUSBCamera` → `connect(**false**)` ⇒ `disablePTPIP()`（`:345`）。

### 6.2 预览起流（PTP 原生，不是 RTSP）

```
1) 能力判定：cameraProperties.isSupportPreview()  // GetPropValue 0xD7FF   (_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:1379)
2) 参数选择：getSupportedStreamingInfos() -> List<ICatchVideoFormat>  // 串形如 "<codec>?W=&H=&BR=[&FPS=]"
             getCurrentStreamingInfo()
3) 起流：setStreamingInfo(ICatchVideoFormat)      // SetPropValue，参数串即 §附录B§7 那条
   显示：StreamProvider.getNextVideoFrame(ICatchFrameBuffer) → H264DecoderThread(MediaCodec) → Surface
   音频：containsAudioStream()/getAudioFormat()/getNextAudioFrame()
4) 模式对齐：changePreviewMode(ICatchCamPreviewMode.*)   // 1=STILL 2=VIDEO 3=TL_STILL 4=TL_VIDEO
   状态：isStreaming() / isMovieRecording() / isCameraBusy()
```
**成功判据**：`isStreaming()==true` 且第一帧回调（`H264DecoderThread` 里 `videoShowtime = System.currentTimeMillis()` 打点，`:104`）。
**降帧规则（App 自己改的）**：`ConvertTools.resolutionConvert`：`H==720`→`FPS=15`、`H==1080`→`FPS=10`（`:80-95`）；无 `FPS` 字段时 `StreamInfoConvert` 兜底 **fps=30**（`:31`）。
**失败提示**：`R.string.dialog_preview`（预览数据加载中…超时）、`R.string.alert_is_capturing_or_recording`。

### 6.3 拍照 / 录像 / 模式切换

| 操作 | PTP 机 | LyIC（`.254`） | QzIC（`.169.1`） | 成功判据 | 失败提示 |
|---|---|---|---|---|---|
| 拍照 | `cameraAction.capturePhoto()`（`_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraAction.java:87`，JNI `capturePhotoA`）；`triggerCapturePhoto()`（`:299`，`0xD7B6` 分支） | GET `cmd=2017`（`urlTriggerRAWencode`）；备选 `cmd=1001` / `cmd=1002&par=` 定尺寸 | POST `/app/snapshot` | 事件 `ICatchCamEventID=35 CAPTURE_COMPLETE`（`Function/SDKEvent.java` 注册） | `alert_is_capturing_or_recording` |
| 开始录像 | `startMovieRecord()`（`:221`） | GET `cmd=2001&par=1`（`urlMovieRecordStart`），**且必须**先发 `cmd=2015&par=1` + `cmd=3001&par=1`（`LyIC.ready2CamLive` `:332-344`） | POST `/app/setparamvalue?param=rec&value=1`（且先 `/app/enterrecorder`） | 事件 `33 VIDEO_ON`；轮询 `0xD7FD`(55293) 计时 | 同上 |
| 停止录像 | `stopVideoCapture()`（`:278`，JNI `stopMovieRecord1/2`） | GET `cmd=2001&par=0` → 再 `cmd=2015&par=0`（`stopMovieRecord→stopMovieLive` `:129-140`） | POST `param=rec&value=0` → `/app/setting?param=enter` | 事件 `34 VIDEO_OFF` | — |
| 切模式 | `changePreviewMode(int)`（`:101`） | `cmd=3001&par=0/1/2` | POST `/app/enterrecorder` `/app/playback?param=enter` `/app/setting?param=enter`（+ `cmd=exit` 对应） | `getCurrentCameraMode()` 返回期望值（`1/2/3/7/8/17/42/43`，见附录 A §3） | `current_setting_need_reconnect` |
| 切镜头 | `setPropertyValue(0xD733, 0/1)`；快捷 `0xD7B6` | `cmd=3001` 无此项 → 用 `/app/setparamvalue?param=switchcam&value=0/1`（`LyWyzRequestInfo:45/44`） | 同左 | `UP_SIDE(0xD7B0)`/事件 `49` | — |
| 变焦 | `zoomIn()` / `zoomOut()`（`:363/385`），`0x5016` 读倍率 | 无 | 无 | `getCurrentZoomRatio()` ≤ `getMaxZoomRatio()` | — |
| 休眠/唤醒 | `toStandbyMode()`；`cameraAssist.wakeUpCamera(String)` | — | — | `checkConnection()` | — |
| 全景平移 | `pan(i,i2)` / `panReset()`；`previewMove` / `resetPreviewMove`（`:187/194`） | — | — | — | — |

### 6.4 参数设置
见 §5；每条设置的具体写点：`Function/Setting/OptionSetting.java` 的 31 个方法（`showBurstOptionDialog:465`、`showDateStampOptionDialog:569`、`showDelayTimeOptionDialog:594/619`、`showElectricityFrequencyOptionDialog:644`、`showFormatConfirmDialog:669`、`showMicRecodingOptionDialog:681`、`showOptionDialog:710`、`showResetDeviceConfirmDialog:717`、`showSlowMotionDialog:736`、`showTimeLapseDurationDialog:761`、`showTimeLapseIntervalDialog:786`、`showTimeLapseModeDialog:814`、`showUpdateFWDialog:843`、`showUpsideDialog:856`、`showVideoSizeOptionDialog:881`、`showWhiteBalanceOptionDialog:923`、`showAutoPowerOffDialog:1005`、`showEnableWifihotspotDialog:1030`、`showExposureCompensationDialog:1061`、`showFastMotionMovieDialog:1086`、`showGSensorDialog:1111`、`showImageSizeOptionDialog:1120`、`showScreenSaverDialog:1145`、`showSetDownloadSizeLimitDialog:1170`、`showSettingDialog:1196`、`showStorageLocationDialog:1328`、`showUSBImageSizeOptionDialog:1348`、`showVideoFileLengthDialog:1356`、`sdCardIsNotReadyAlert:451`、`showCameraConfigurationDialog:491`）。

### 6.5 回放：列表 → 缩略图 → 下载 → 删除

| 步 | PTP 机 | LyIC | QzIC |
|---|---|---|---|
| 进入回放 | `changePreviewMode` + `setFileListAttribute(filterType[, sensorsType])`（`_work/idgo_live_src/sources/com/icatch/golive/SdkApi/FileOperation.java:325/339`，值取 `ICatchCamListFileFilter`） | GET `cmd=3001&par=2` | POST `/app/playback?param=enter`（先 `param=rec&value=0` 停录，`_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:452`） |
| 取列表 | `getFileCount()`（`:148`）→ `getFileList(int filterType)`（`:162`）或 `getFileList(filter, sort, sensor)`（`:193`）；分页能力由 `checkCameraCapabilities(2)` + `0xD83F` 上限决定 | GET `cmd=3015` → XML `ALLFile{NAME,FPATH,SIZE,TIMECODE,TIME,ATTR}`（`_work/idgo_live_src/sources/com/icatch/golive/utils/XmlParseUtil.java:110-146`），按 `FPATH` 含 `/Movie/`、`/SOS/`、`/Photo/` 分流（`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:205-211`） | GET `/app/getfilelist?folder=loop&start=0&end=99`；`{result:0, info:[{folder, files:[{name,duration,size,createtime,createtimestr,type}]}]}`（`_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:204-224`），倒序按名字排（`:68-73`） |
| 缩略图 | `getThumbnail(ICatchFile)` / `getThumbnail(String)`（`:259/288`）、`getQuickview()`（`:223`，日志 `buffer size =`）；native `ptp_getthumb` / `ptp_mtp_getobjectquickview` | `furl + "?custom=1&cmd=4002"`（`entity/FileInfo.java:55`），URL 前缀 `http://192.168.1.254/Novatek/<dir>/<file>` | `http://192.168.169.1:80/app/getthumbnail?file=<path>`（`_work/idgo_live_src/sources/com/icatch/golive/entity/FileInfo.java:27`） |
| 下载 | `downloadFile(ICatchFile)` 到内存（`:85`）或到路径（`:118`）；`cancelDownload()`（`:26`）；事件 `103 FILE_DOWNLOAD` | HTTP GET `furl` + `RANGE: bytes=N-` 续传（`net/OkHttpDownUtil.java:119`） | 同左，基址带 `:80` |
| 删除 | `deleteFile(ICatchFile)`（`:56`，native `ptp_deleteobject`） | GET `cmd=4003&str=<path>`；全删 `cmd=4004` | `/app/deletefile?file=<path>` |
| 退出回放 | — | GET `cmd=3001&par=1` → `cmd=2016` → `cmd=2001&par=1`（`LyIC.leaveRemoteFile:294-314` 三连） | POST `/app/exitrecorder` + `/app/playback?param=exit`（`_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:398-401`） |

**成功判据**：PTP 机看返回 `List<ICatchFile>` 非空 + 事件 `1 FILE_ADDED`/`2 FILE_REMOVED`；HTTP 看 `result==0` / `status==0`。
**失败提示**：`dialog_delete_failed_single`、`delete_done`、`dialog_cancel_downloading_failed/succeeded`、`download_complete_result`（`完成下载，成功:$1$个, 失败:$2$个`）、`gallery_cannot_download_video`、`dialog_card_removed_and_back_photo_pb`、`no_content`。

### 6.6 格式化 / 恢复出厂 / 重置 WiFi

| 操作 | PTP | LyIC | QzIC | 提示 |
|---|---|---|---|---|
| 格式化 | `formatStorage()`（`_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraAction.java:152`，日志 `begin formatSD timeout is 15s`；JNI `formatStorage1/2`，native `ptp_formatstore ret = 0x%x`） | GET `cmd=3010&par=1` | GET `/app/sdformat` | `formatting_sd_card` / `format_success` / `sdCardIsNotReadyAlert` |
| 恢复出厂 | `setPropertyValue(0xD7B1, …)` | GET `cmd=3011` | GET `/app/reset` | `reset_device` 确认框（`_work/idgo_live_src/sources/com/icatch/golive/Function/Setting/OptionSetting.java:717`） |
| 改 WiFi（相机 AP） | `setCameraSsid(0xD83C)` / `setCameraPassword(0xD83D)`；STA 侧 `setCameraEssidName(0xD834)` / `setCameraEssidPassword(0xD835)`；服务侧 `setServiceEssid(0xD836)` / `setServicePassword(0xD837)`；AP→STA 靠 `0xD7FB` | GET `cmd=3003&str=<ssid>`、`cmd=3004&str=<pwd>`，之后 `cmd=3018`（`urlReconnectWiFi`） | `/app/setwifi?`（`_work/idgo_live_src/sources/com/icatch/golive/net/M1RequestInfo.java:41`）+ `/app/wifireboot` | `camera_wifi_password`、`alert_not_same_password`、`current_setting_need_reconnect` |
| 手机开热点给相机连 | — | — | — | `WifiApActivity`（`activity_wifi_ap.xml`：SSID 默认 `test01`、密码默认 `1234567890`、加密三态 no/wpa/wpa2）；`OptionSetting.showEnableWifihotspotDialog()`（`:1030`） |

**默认密码 `1234567890`（10 位）在 3 处**：`_work/idgo_live_src/sources/com/icatch/golive/data/AppInfo/AppInfo.java:52`（字段初值）、`_work/idgo_live_src/sources/com/icatch/golive/Presenter/LaunchPresenter.java:621`（SP 读取默认值）、`activity_wifi_ap.xml:78`（布局字面量）。SP key = `AppSharedPreferences.OBJECT_NAME_DEFAULT_PWD = "default_pwd"`（`:9`），`inputIp` key = `"inputIp"`（`:10`）。

### 6.7 固件升级

```
A. 发现（云）
   GET https://www.id221.com/api/app/firmware/area_check   // _work/idgo_live_src/sources/com/icatch/golive/net/ConnectDeviceManager.java:362
     -> {code:200, data:{area_support:"<区域串>"}}  存 SP（:376-381）
   GET https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json  // _work/idgo_live_src/sources/com/icatch/golive/ui/activity/DownloadFirmwareActivity.java:220
     -> 每条 {product, name, region, version, download}   // :173
   下载 download 字段指向的文件，落地文件名固定 SPHOST.BRN（_work/idgo_live_src/sources/com/icatch/golive/data/AppInfo/AppInfo.java:23）
B. 推送（PTP）
   cameraAction.updateFW(path)   // SdkApi/CameraAction.java:325
     -> ICatchCameraAssist.updateFw(session, path)   // _work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraAssistImpl.java:347
     -> JNI Java_...JCameraAssist_updateFw(transportType, ip, vid, pid, fd, sessionID, path)
   UI: OptionSetting.showUpdateFWDialog(ctx, str)  // :843
C. 进度（事件驱动，不是轮询）
   addEventListener(96 FW_UPDATE_CHECK)     // Function/SDKEvent.java:475
   addEventListener(97 FW_UPDATE_COMPLETED) // :454
   addEventListener(98 FW_UPDATE_POWEROFF)  // :458
   addEventListener(99 FW_UPDATE_CHKSUMERR) // :480
   addEventListener(100 FW_UPDATE_NG)       // :485
D. 副作用：升级前会读 0xD7BC(G_SENSOR) 做兼容判断（_work/idgo_live_src/sources/com/icatch/golive/Function/Setting/OptionSetting.java:976 handleFirmwareUpdate）
```
**成功判据**：收到事件 97；失败为 99（校验和）或 100（NG）；98 = 相机断电。
**提示文案**：`download_firmware`、`dialog_reconnect_failed`。

### 6.8 直播
`Function/live/{Facebook,google}/**` + `pancam` 推流；YouTube 侧 API 全在 `libpanorama_vr.so`（附录 D §3）。
Google 授权 scope：`youtube`（+ 已废弃 `plus.login`、`user.birthday.read`）；`GOOGLE_REDIRECT_URI = "http://localhost:8080"`（`_work/idgo_live_src/sources/com/icatch/golive/Function/live/google/Credentials.java:10`）。
Facebook：`CustomTabActivity` + `fbconnect://cct.com.id221.golive`（`manifest.md:163`），`queries: com.facebook.katana`。
App 级开关：`AppInfo.enableLive`（`:34`，由 `netconfig.properties` 覆盖，`_work/idgo_live_src/sources/com/icatch/golive/data/AppInfo/ConfigureInfo.java:20`）。

---

## 7. 白标与渠道

- 服务端域名分三组，说明同一 APK 服务多个渠道：`id221.com` / `www.id221.com`（品牌主站 + area_check）、`idalbum.com` / `api.idalbum.com` / `api.idstore.idalbum.com` / `idcam.idalbum.com.cn`（"ID Album" 云平台）、`icatchtek.com`（原厂，仅 push 域名，死）。
- `device_name_pwd` 布局里的占位字符串是 `id221_Device_model_one`（`layouts.md:46`）⇒ 设备名默认前缀 `id221_`，**这是白标贴牌机型命名模板**。
- 贴牌机名**出现在本 APK 源码里**：`SdkApi/CameraProperties.java:1476` 的相机名黑名单含
  `Victure/AC920`、`Victure/AC940`、`Crosstour/CT9900`、`Niceboy`、`Model : YDOL3`（见 §2.1）。
  ⇒ 白标证据是**通过 PTP `0xD831 CAMERA_NAME` 读回的设备名字符串**做的运行时识别，
  而不是编译期的品牌分支；本 APK 的渠道变量 = 「云域名组 + 协议版本号(`V1.4.3`) + 相机自报名字」。
  注意拼写是 **`Crosstour`**，不是资料里常见的 `Croslyour`。

---

## 8. 未解之谜（静态定不来，附补证手段）

| # | 未解 | 已排除的可能 | 补证手段 |
|---|---|---|---|
| 1 | **PTP/IP 端口**（cmd / data / event 三个） | Java 无端口字段；`libcontrol.so` .rodata 无端口串；`.text` 的 30 个 MOVZ 立即数无一像端口 | `adb shell netstat -tnp`（最快）／frida hook `connect()` 打 `sin_port`／IDA 从 `ptp_ptpip_connect` 往下 |
| 2 | **native 内「语义方法→属性 ID」映射**（如 `getCurrentImageSize` 到底查 0x5003 还是 0x5002） | 同上，常量非内联立即数 | IDA 反编译 `icatch_get_dev_prop_value`；或真机 `getSupportedProperties()` 打印后与 Java 常量对齐 |
| 3 | **iCatch 自定义 op 码**（`ptp_icatch_set_customer_operation`） | — | 抓包看非常规 opcode；或 IDA 看调用点的常量 |
| 4 | **PTP 响应码表是否存在于包内** | `ptp_strerror`/`ptp_perror` 只有函数名，名字串未出现在兴趣字符串里 | 全量 .rodata 表遍历（IDA strings window） |
| 5 | **`0xD7FB` 三重载的运行时消歧** | — | 同一 ID 的 Get/Set 载荷抓包对比 |
| 6 | **socketIO 通道（`enableSocketIO`）的帧格式与端口** | App 从未调用 ⇒ 只能算「SDK 能力」 | 反编译 `Java_..._enableSocketIO`；或在 SDK 其它 App 里找调用点 |
| 7 | **`simpleConfig` 组播报文格式（除 AES key 之外）**：字段顺序、`checkpattern` 内容、端口是否 5002 | key/超时/AES-CBC 已确认 | 用另一台设备在 5002 抓组播 + 反编译 `simpleconfig_main` |
| 8 | **各属性默认值 / 固件真实取值集合** | — | 真机连一次逐属性 dump |
| 9 | **`LyCmdWithYzIC` 对应的真实固件** | 该类被编译进包但 `initDevice()` 不选它 | 找渠道机型验证；或把 `try2connectLywyzIC` 接回探测链做 A/B |
| 10 | **全景（`libpanorama_vr.so` / `com.icatchtek.pancam`）的线上协议**：105 条 JNI、16 MB 库、`libdepth_net_transport.so` | 本轮聚焦 221 相机主通道 | 单独立项：`JPancamSession`/`JStreamControl`/`JStreamProvider` 三件套 + GL 侧 `ICatchPancamGL` |
| 11 | **`RtspPlayerActivity` 的确切 URL 拼接**（IC 只返回裸 `rtsp://ip`） | — | 追 `LYLiveVideoActivity` 的 setVideoPath 调用点 |
| 12 | **`/app/getparamvalue?param=all` 的完整 param 键集合** | App 只显式用 `rec`、`rec_resolution`、`switchcam`、`encodec` | 真机 GET 一次并记录全量键 |

---

## 9. 对既有文档的纠正

| 文档/位置 | 原说法 | 现有证据 | 建议改法 |
|---|---|---|---|
| `docs/03-品牌型号与协议矩阵.md` §3 | 「`0xD7DB` 一个 ID 三重载」 | 三重载的常量值是 **55291 = `0xD7FB`**（`_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:5/34/47`：`AP_MODE_TO_STA_MODE`/`NOTIFY_FW_TO_SHARE_MODE`/`TIMELAPSE_VIDEO_SIZE_LIST_MASK`）。`0xD7DB`(55259) 全仓无定义 | 改为 `0xD7FB`；并补记 **`0xD834`、`0xD835` 各有 2 个名字**（`ESSID_NAME/STA_MODE_SSID`、`ESSID_PASSWORD/STA_MODE_PASSWORD`） |
| docs/03 §3 | 「设置项 = `0xD7xx` 厂商段 + `0x50xx` 标准段」 | 还系统性存在 **`0xD6xx` 段**（`0xD605` 视频尺寸、`0xD606` 灯光频率、`0xD607` 日期戳、`0xD611` 缩时录像、`0xD614` 倒置、`0xD615` 慢动作）**与 `0xEE00`(缩时模式)、`0xE604`(MOVIE_REC 能力)、`0xFFFF`(UNDEFINED)** | 把「两段」改成「四段 + 高位能力码」，全量见附录 A |
| docs/03 §3 | 「8 条传输通道」 | 实为 **11 条**：原 8 条之外，`XML-over-TCP:3333` 与 `HTTP CGI` 常被并为一条（应拆，因为 TCP 通道只在 `LyIC` 存在且**单向推送**），且遗漏了 ①蓝牙/BLE 配对通道、②UDP 组播的 **AES-CBC 配网通道（simpleConfig）**、③RTMP 上行 | 按 §3 的 11 行表替换；另注明 `enableSocketIO` 是第 12 条「存在但未启用」 |
| docs/03 §3 / docs/01 | 「白标公版 App…**无型号注册表**」 | **部分不成立**：`SdkApi/CameraProperties.java:1476` 有 **33 项相机名黑名单（「34」是误计，按 `Arrays.asList` 实参点数）**，含 `Victure/AC920`、`Victure/AC940`、`Crosstour/CT9900`、`Niceboy`、`Model : YDOL3`、`A86/A87/GA2xx/GA3xx/GA4xx/SF430/SF530/CT9300/DV19/AC9000/DiCam8xx/X7.2-LMXX72/X9.2-LMXX92/DC790/K10/V40/Action Cam*`；命中即 `setCameraDateTimeZone()` 不写 `0xD83E`（`:1478-1481`） | 改述为「无『机型→能力』注册表，有『机型名→跳过时区写入』黑名单（全量见 §2.1）」；贴牌名**在本 APK 内**，识别方式是 PTP `0xD831` 读名后 `contains()` **全等**匹配（非前缀）；另注意拼写是 `Crosstour` 不是 `Croslyour` |
| docs/03 / docs/05 | 「靠『哪个 IP 应答 ping』选 handler」 | 只对了一半：ping 只区分 `.254`/`.169.1`；**`192.168.1.1` 的 PTP 机不参与 ping 探测**，由 `MyCamera.connect(true)` 的成败决定，且 `connect` 成功后不再走 ping。另外两路 ping **共享同一个失败计数器**（`_work/idgo_live_src/sources/com/icatch/golive/net/ConnectDeviceManager.java:33-37`），达 2 就整体 404 | 改为「四层判定：PTP 会话成败 → ICMP 应答者 → getSSID 成败 → 相机名黑名单」，并保留对共享计数器 bug 的告警 |
| docs/03 §3 | 「`192.168.1.254` 是 Novatek 风格，另有 XML-over-TCP:3333」 | 确认（`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:289`）。**补充**：同一 IP 上还并存**两种完全不同的 API**（`?custom=1&cmd=` XML 与 `/app/` JSON），后者由 `LyWyzRequestInfo`+`LyCmdWithYzIC` 实现，但 **`try2connectLywyzIC` 无调用点 ⇒ 死代码** | 明确「`.254` 有两套 profile，App 只会选中 Novatek 那套」；复现时把 `.254` 的双 profile 都实现并按 `getdeviceattr` 是否回 JSON 分流 |
| docs/03 / docs/01 | 「预览是 PTP 原生拉流，参数串 `H264?W=&H=&FPS=&BR=`」 | 结构确认（`getSupportedStreamingInfos`/`setStreamingInfo`，非 RTSP）。**但字面串不在 APK 里**（对 20 个 arm64 .so 全量搜 `H264?` 零命中；native 侧的格式串是 `mediumName=%s;codec=%d;videoW=%d;videoH=%d;bitrate=%d;durationUs=%d;maxInputSize=%d;fps=%d`），它由**固件**返回；App 解析器 `_work/idgo_live_src/sources/com/icatch/golive/DataConvert/StreamInfoConvert.java:8-34`，且会**按高度降帧**（720→FPS=15、1080→FPS=10，`_work/idgo_live_src/sources/com/icatch/golive/utils/ConvertTools.java:80-95`），无 FPS 字段时兜底 30 | 把「参数串」标为「设备侧产生」；补记 App 的两处改写规则（降帧 + fps 兜底），否则我方预览帧率会偏高 |
| docs/03 | 「副机才用 RTSP，且要先 `cmd=2015&par=1` 打开」 | 确认（`_work/idgo_live_src/sources/com/icatch/golive/net/RequestInfo.java:44-45`，`LyIC.ready2CamLive:332`）。**补充**：`getFront/BackCamLiveURL()` 只返回**裸 `rtsp://ip`**（无路径、无端口），三个 IC 类分别返回 `.254` / `.169.1` / `.254`，`ic==null` 时兜底 `rtsp://192.168.1.254`；另有 `rtsp://192.168.1.1` 字面量存在 | 补记「URL 由播放器补路径」这一未完成事实，列为未解之谜 #11 |
| docs/03 / docs/05 | 「HTTP 通道零鉴权」 | 确认（`_work/idgo_live_src/sources/com/icatch/golive/net/ApiCaller.java:95-137` 无任何鉴权头/Cookie），**且更糟**：`network_security_config` 全域放行明文（`res/xml/network_security_config.xml` 仅一行 `cleartextTrafficPermitted="true"`），`http://api.idstore.idalbum.com/api/getCustomerServiceInfo` 是**明文云端**接口 | 保留并升级措辞：LAN 侧零鉴权 + 全域明文；把 `ApiCaller` 的「绑定到 `WifiNetwork.getSocketFactory()`」一并记为复现要点 |
| docs/03 / 清单 | 「发现靠 UDP 组播 `234.168.168.168:5002`，权限名拼错」 | 均确认（`_work/idgo_live_src/sources/com/icatchtek/control/core/CoreMulticast.java:15-16`；`manifest.md:70`）。**补充**：组播有**两套实现**（Java 只收 + native 收发），native 那套是**带 AES-128-CBC 的配网协议 `simpleconfig`**，默认 key 与超时已提取；`MulticastLock` 不需要该权限，所以拼错的权限对功能无影响 | 在协议矩阵里新增一行「组播配网通道」，并把权限拼错的影响写清（功能无碍，但别照抄） |
| docs/03 | 「PTP/IP 端口号静态找不到，3195/3196 属推测」 | 复核后维持「静态无解」，但**3195/3196 无任何依据**：包内不存在该二值，且扫描证明端口是 .data 载入。`ptpip/init_cmd`+`init_cmd_ack`+`init_event`+`oprequest` 三通道握手存在 | 把「3195/3196」从推测里删掉，改写为「首选 `15740`（PTP-over-IP 规范默认），次选 3195/3196 仅作为待验假设」，并给出 §3.5 的 4 步验证方法 |
| docs/01 / docs/03 | 「无扫码配网、无 Wi-Fi Direct」 | 「无 Wi-Fi Direct」成立（全仓 `WifiP2p` 零命中）。**「无配网」需要收窄**：确实没有 QR 扫描入口（`baseutil/qrcode/{QRCode,SetupQRCode}.java` 存在但未接到配网流程），但有 ①蓝牙把 SSID/密码写给相机（`fragment_btpair_setup`）、②组播 AES `simpleConfig`、③Android `WifiNetworkSpecifier` 直连（`_work/idgo_live_src/sources/com/icatch/golive/Presenter/LaunchPresenter.java:248-266`）、④手机开热点（`WifiApActivity`） | 改述为「无 QR 扫码；有 BT 配网 + 组播配网 + OS 级直连 + 手机热点四条替代路径」 |
| docs/05 | 「续传用标准 `Range: bytes=N-`」 | 确认（`_work/idgo_live_src/sources/com/icatch/golive/net/OkHttpDownUtil.java:119`），但 header 名写的是**大写 `RANGE`**，且 `:242` 把同一 header 用在 **POST** 请求上（服务端多半忽略）；PTP 侧的续传另有 `ptp_getpartialobject` 一条独立机制 | 记为大写 `RANGE` 属实现细节（HTTP 头大小写不敏感，无功能影响）；补记 PTP partial-object 续传 |
| docs/01 | 未提及 | **新发现**：①相机 SDK 全栈 **ARM-only**（x86/x86_64 无 `libcontrol.so`）；②`AppInfo.APP_VERSION="V1.4.3"` ≠ versionName `1.3.6`；③YouTube 直播 API 在 native（`libpanorama_vr.so`）而非 Java；④硬编码 YouTube stream key `3fur-h6bh-as8j-w7wd-d7us`；⑤**蓝牙权限缺 `BLUETOOTH_SCAN`/`BLUETOOTH_CONNECT` 而 targetSdk=35 ⇒ Android 12+ 蓝牙配对坏**；⑥`setConnectionCheckParam` 的第三个参数在 SDK 里被丢弃（`_work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraConfigImpl.java:85`）；⑦`device_filter.xml` 是唯一机型表（`0x2AAD:0x6503`、`0x414C:0x6573`）；⑧EV 值的 bit30 = /10 标志 | 逐条并入 docs/03 §3 与 docs/05；⑤与⑥在我方实现里作为「修正项」标注，不要继承 |
| docs/04 | 固件索引 URL | 确认 `https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json`，字段 `product/name/region/version/download`；**补充**：升级前有 `https://www.id221.com/api/app/firmware/area_check`（`{code,data.area_support}`）做区域门槛，落地文件名固定 `SPHOST.BRN` | 补上 area_check 门槛与文件名 |
| 通用 | 反编译包里的域名字符串 ≠ API 清单 | 复核成立并进一步收敛：`push.smarthome.icatchtek.com`、`api.bpsc.tinyai.top:3026`、`usa.boi.tinyai.top:3006`、`demo.xarx.rocks`、w3c/dashif/smpte 命名空间、`libusb.info`、`169.254.169.254`、scribejava 179 provider **全部为死重量**；真在用的只有 6 个域名（附录 D §3 标「真在用」的行） | 保持「域名清单需逐个判定」的写法，直接引用附录 D §3 的表 |
