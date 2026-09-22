# 03 · idGoLive 1.3.6 穷尽式逆向档案

> 包名 `com.id221.golive` / Java 命名空间 `com.icatch.golive` / iCatchTek 公版白标 App。
> APK：`相机 app/idGoLive_1.3.6.apk`；反编译源码：`_work/idgo_live_src/sources/`（10685 个 .java）；机器提取附录：`_work/re/idgolive/`。
> 本档案是「操作能力复现」的依据，不是官方代码的复制。
>
> **拆分出去的附录**（长表都放这里，主文档只留导航与结论）：
> · 附录 A · PTP 设备属性表全量（本文附录）
> · 附录 B · HTTP / TCP 命令目录全量（本文附录）
> · 附录 C · 原生层 63 个 .so、JNI 全表、PTP-IP 线上格式（本文附录）
> · 附录 D · UI 面、云端端点判定、native 字符串真伪（本文附录）

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
| PTP 设备属性 ID | 附录 A（本文附录） | **57 个码点分布在 5 组**：`0x50xx`(10)、`0xD6xx`(6)、`0xD7xx`(28)、`0xD8xx`(10)、高位 `0xE604`/`0xEE00`/`0xFFFF`(3)。一个 ID 多重载的是 **`0xD7FB`(55291) 三重载** 与 **`0xD834`/`0xD835` 双重载**，**不是 `0xD7DB`**（该值不存在） |
| `cmd=NNNN` 命令目录 | 附录 B §2（本文附录） | Novatek 风格 59 条常量、38 个不同 cmd 编号，逐条给出编号/参数/响应标签/解析函数/调用点 |
| `/app/`、`/api/` JSON 端点 | 附录 B §3（本文附录） | 42 + 44 条，两条主机同一模板 |
| XML-over-TCP:3333 | 附录 B §4（本文附录） | 报文结构、标签、编码、超时、分帧、无心跳 |
| PTP-IP 帧与操作码 | 附录 C §3（本文附录） | 14 字节 container 头 + PTP/IP 的 `[2B opType]` 前缀；阶段名由 native 日志串 `ptpip/init_cmd`…`ptpip/oprequest` 直接证实；端口静态无解 |
| 63 个 .so / 343 条 JNI | 附录 C §1-§2（本文附录） | ARM-only 的相机 SDK；`libcontrol.so` 是 libptp+libptp2 双份混编 |
| UI 面与文案 | 附录 D §1-§2（本文附录） | 316 layout、英/中双文案、入口映射表 |
| 云端端点与遥测 | 附录 D §3（本文附录） | 逐个「真在用/声明未用/死重量」判定 |

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

---

<!-- 以下整段合并自原 03-idGoLive-档案-附录-PTP属性表.md（2026-09-22 文档归并，内容未改） -->
# 附录 A · idGoLive PTP 设备属性表全量

> 返回 主档案（本文附录）
> 证据根目录：`_work/idgo_live_src/sources/`（jadx 反编译），行号即该目录内文件行号。
> native 符号证据：`_work/re/idgolive/natives-symbols.tsv`、`_work/re/idgolive/natives-strings.tsv`。

---

## 0. 这张表是怎么来的（三层结构）

| 层 | 位置 | 作用 |
|---|---|---|
| 常量层（Java） | `com/icatch/golive/data/PropertyId/PropertyId.java:5-55`（51 个 `static final int`）+ `com/icatchtek/control/customer/type/ICatchCamProperty.java:5-23`（19 个能力常量） | App 层与 SDK 层各存一份 ID，值完全重叠 |
| 语义层（Java→JNI） | `com/icatchtek/control/core/feature/ICatchCameraPropertyImpl.java:24-326` → `com/icatchtek/control/core/jni/JCameraProperty.java` | `getCurrentImageSize()` 这类语义方法**不传 ID**，ID 硬编码在 `libcontrol.so` 内 |
| 线上层（native） | `lib/arm64-v8a/libcontrol.so` 导出 `icatch_get_dev_prop_value` / `icatch_set_dev_prop_value` / `icatch_get_dev_prop_desc` / `ptp_getdevicepropvalue` / `ptp_setdevicepropvalue` / `ptp_getdevicepropdesc` / `ptp_getdeviceallpropdescs`（见 natives-symbols.tsv 行 6915/7022/7073 等） | 真正拼 PTP container 并发包 |

关键推论：**属性 ID 的权威表在固件侧**，App 只做 `GetDevicePropDesc` 拿回 supported-value 列表再画 UI（`getSupportedPropertyValues(int)`，`_work/idgo_live_src/sources/com/icatchtek/control/customer/ICatchCameraProperty.java:75-77`）。因此「取值范围」列写的是 App 认识的枚举，不等于固件实际支持集合；「默认值」静态不可得（见 §4）。

JNI 返回值协议（跨所有 `JCamera*` 类通用）：native 返回一个字符串 `RET_<TAG>::<value>`，Java 用 `split("::")` 解tag。定义在
`com/icatchtek/control/core/jni/extractor/NativeValueTag.java:5-11`：
`RET_BOOL` / `RET_DOUBLE` / `RET_ERR` / `RET_INT` / `RET_LONG` / `RET_STRING`，分隔符 `"::"`。
解析与兜底值在 `NativeValueUtil.java:7-50`：`getErrValue` 解析失败返回 **-11111**，`getIntValue` 失败返回 **-1**，`getLongValue`/-1，`getDoubleValue`/-1.0。

---

## 1. `0xD7xx` 厂商段（iCatch vendor property）全表

排序按 ID 升序。「Java 常量」= `PropertyId.java` 内名称（值见括号）；「读写」来自实际调用点。

| ID | 十进制 | Java 常量 | SDK 语义 API | 类型 | 取值 / 枚举 | 读写 | 调用点（file:line） |
|---|---|---|---|---|---|---|---|
| `0xD605` | 54789 | `VIDEO_SIZE` | `getCurrentVideoSize()` / `setCurrentVideoSize(String)` / `getSupportedVideoSizes()` | String（分辨率串） | 见 §2 视频规格串 | R+W | `Function/BaseProrertys.java:68`（`new PropertyTypeString(...,54789,...)`）；`SdkApi/CameraProperties.java:1273` `getVideoSizeFlow()` |
| `0xD606` | 54790 | `LIGHT_FREQUENCY` | `getCurrentLightFrequency()` / `setLightFrequency(int)` / `getSupportedLightFrequencies()` | enum int | 0=50Hz、1=60Hz（`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:102-103`）；SDK 另给 2=AUTO、255=UNDEFINED（`_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamLightFrequency.java:5-8`） | R+W | `Function/BaseProrertys.java:66`（`new PropertyTypeInteger(...,54790,...)`） |
| `0xD607` | 54791 | `DATE_STAMP` | `getCurrentDateStamp()` / `setDateStamp(int)` / `getSupportedDateStamps()` | enum int | 1=Off、2=日期、3=日期+时间（`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:96-98`）；SDK 另 255=UNDEFINED（`_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamDateStamp.java:5-8`） | R+W | `Function/BaseProrertys.java:55` |
| `0xD611` | 54801 | — | `ICH_CAM_CAP_TIMELAPSE_VIDEO`（能力位） | capability | 见 §3 | 能力探测 | `com/icatchtek/control/customer/type/ICatchCamProperty.java:19` |
| `0xD614` | 54804 | — | `ICH_CAM_CAP_UPSIDE_DOWN` | capability | 见 §3 | 能力探测 | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:21` |
| `0xD615` | 54805 | `SLOW_MOTION` | `getCurrentSlowMotion()` / `setSlowMotion(int)` | enum int | 0=Off、1=On（`data/type/SlowMotion.java`，`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:64-65`） | R+W | `Function/BaseProrertys.java:56` |
| `0xD720` | 55072 | `SCREEN_SAVER` | `getCurrentPropertyValue(55072)` / `setPropertyValue(55072,v)` | enum int（动态列表） | 列表来自 `getSupportedPropertyValues(55072)`（`data/Hash/PropertyHashMapDynamic.java:124` `getScreenSaverMap`） | R+W | `Function/BaseProrertys.java:76`；`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:237` |
| `0xD721` | 55073 | `AUTO_POWER_OFF` | 同上 | enum int（动态） | `getAutoPowerOffMap()`：`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:24`，值 = `getSupportedPropertyValues` 返回集，UI 文案按秒/分换算 | R+W | `Function/BaseProrertys.java:77`；`Function/Setting/UIDisplaySource.java:99` |
| `0xD722` | 55074 | `POWER_ON_AUTO_RECORD` | `setPropertyValue` | enum int 0/1 | On/Off | R+W | `Function/Setting/UIDisplaySource.java:99`；`ui/adapter/SettingListAdapter.java:68` |
| `0xD723` | 55075 | `EXPOSURE_COMPENSATION` | `getCurrentPropertyValue(55075)` / `setPropertyValue(55075,v)` | 有符号 int（EV，步进由固件给） | `_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:47` `getExposureCompensationMap`：对列表值做 `value/1000` 与符号处理（源码内有 `temp=` 日志、`% 1000` 取余） | R+W | `Function/BaseProrertys.java:74`；`_work/idgo_live_src/sources/com/icatch/golive/Function/Setting/UIDisplaySource.java:34/99/135` |
| `0xD724` | 55076 | `IMAGE_STABILIZATION` | 同上 | enum int | On/Off（EIS） | R+W | `_work/idgo_live_src/sources/com/icatch/golive/Function/Setting/UIDisplaySource.java:34`；`_work/idgo_live_src/sources/com/icatch/golive/ui/adapter/SettingListAdapter.java:68` |
| `0xD725` | 55077 | `VIDEO_FILE_LENGTH` | 同上 | enum int（动态） | `_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:136` `getVideoFileLengthMap`；显示时按 `i%1000` 分支（同文件 L149） | R+W | `Function/BaseProrertys.java:75` |
| `0xD726` | 55078 | `FAST_MOTION_MOVIE` | 同上 | enum int（动态） | `_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:59` `getFastMotionMovieMap`，显示串加 `"x"` 前缀（倍速） | R+W | `Function/BaseProrertys.java:78` |
| `0xD727` | 55079 | `WIND_NOISE_REDUCTION` | 同上 | enum int | On/Off | R+W | `_work/idgo_live_src/sources/com/icatch/golive/Function/Setting/UIDisplaySource.java:34`；`_work/idgo_live_src/sources/com/icatch/golive/ui/adapter/SettingListAdapter.java:68` |
| `0xD729` | 55081 | `MULTIPLE_CAMERA_SENSOR` | `getNumberOfSensors()` | int | 传感器个数；SDK 另有能力位 `ICH_CAM_CAP_GET_NUMBER_OF_SENSORS = 55083` | R | `PropertyId.java` 声明；SDK `_work/idgo_live_src/sources/com/icatchtek/control/customer/ICatchCameraProperty.java:57` |
| `0xD72A` | 55082 | `CAPTURE_IN_VIDEO_RECORD` | `setPropertyValue` | enum int | 录像中抓拍开关 | R+W | 仅常量声明（`_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:21`），UI 无绑定 → 该机型通道未接 |
| `0xD72B` | 55083 | — | `ICH_CAM_CAP_GET_NUMBER_OF_SENSORS` | capability | §3 | 探测 | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:12` |
| `0xD72C` | 55084 | `DEFALUT_TO_PREVIEW`（原文拼写错误，少一个 T） | `ICH_CAM_CAP_GET_CAMERA_CAPABILITIES` | capability/enum | 0/1；App 侧当能力位用 | R+W | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:11`；`_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:23` |
| `0xD733` | 55091 | `CAMERA_SWITCH` | `getCurrentPropertyValue(55091)` / `setPropertyValue(55091,v)` | enum int | 0=前置、1=后置（`data/type/CameraSwitch.java`，`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:54-55`） | R+W | `_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:18` |
| `0xD7A1` | 55201 | `CAMERA_CONNECT_CHANGE` | `setCurrentPropertyValue(55201, v)` | int 命令 | 通知固件「连接状态变化」 | W only | `SdkApi/CameraProperties.java:1393` `notifyCameraConnectChnage(int)`（方法名原文拼写 Chnage） |
| `0xD7B0` | 55216 | `UP_SIDE` | `getCurrentUpsideDown()` / `setUpsideDown(int)` | enum int | 0=Off、1=On（`data/type/Upside.java`，`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:80-81`） | R+W | `Function/BaseProrertys.java:57`；`data/entity/PropertyTypeInteger.java:75/103/198/288` |
| `0xD7B1` | 55217 | `RESET_DEVICE` | `setPropertyValue(55217, …)` | int 命令 | 恢复出厂，写触发 | W only | `Function/BaseProrertys.java:58`；`Function/Setting/OptionSetting.java:717` `showResetDeviceConfirmDialog` |
| `0xD7B2` | 55218 | `SD_SPACE` | `getCurrentPropertyValue` | int | 卡总容量（不定单位，UI 直接拼 MB） | R | `Function/BaseProrertys.java:59`；`_work/idgo_live_src/sources/com/icatch/golive/Function/Setting/UIDisplaySource.java:34/135` |
| `0xD7B3` | 55219 | `SD_SPACE_REMAIN` | 同上 | int | 剩余容量 | R | `Function/BaseProrertys.java:60` |
| `0xD7B4` | 55220 | `MICROPHONE_RECEPTION` | 同上 | enum int | 0=耳机麦、1=机身麦（`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:59-60`） | R+W | `Function/BaseProrertys.java:61` |
| `0xD7B5` | 55221 | `BLUETOOTH_AUDIO_RECORDING` | 同上 | enum int | 0=Off、1=On（`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:44-45`） | R+W | `Function/BaseProrertys.java:62` |
| `0xD7B6` | 55222 | `CAMERA_IMAGE_SWITCHING` | 同上 | enum int | 0=Off、1=On（`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:49-50`）；预览页「快门/切镜头」按钮也写它 | R+W | `Function/BaseProrertys.java:63`；`Presenter/PreviewPresenter.java:1343` `getShotCut()`、`:1363` `hasShotCut()`、`:1638` `onShotCut()` |
| `0xD7B8` | 55224 | `VIDEO_WARNING_QUERY` | 同上 | enum int | 紧急录像（SOS）状态查询 | R | `Function/BaseProrertys.java:64`；`Presenter/RemoteDeviceFilesFragmentPresenter.java:158` `queryNotVideoWarning()` |
| `0xD7BC` | 55228 | `G_SENSOR` | 同上 | enum int（动态） | `_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:71` `getGSensorMap`（写死 5 档，见下） | R+W | `Function/BaseProrertys.java:65`；`_work/idgo_live_src/sources/com/icatch/golive/Function/Setting/OptionSetting.java:1111` `showGSensorDialog`；`_work/idgo_live_src/sources/com/icatch/golive/Function/Setting/OptionSetting.java:976` `handleFirmwareUpdate` 里也读它 |
| `0xD7F0` | 55280 | `CAPTURE_DELAY_MODE` | `setCaptureDelayMode(int)` | enum int | 延时摄影模式（秒拍/秒录切换） | W | `SdkApi/CameraProperties.java:1682`；`Presenter/PreviewPresenter.java:1367` |
| `0xD7FB` | **55291** | **一个 ID 三重载**：`NOTIFY_FW_TO_SHARE_MODE` = `TIMELAPSE_VIDEO_SIZE_LIST_MASK` = `AP_MODE_TO_STA_MODE` | `notifyFwToShareMode(int)` / 动态列表 | 多态 | ①通知固件切 Share 模式；②获取缩时录影视频规格掩码；③AP→STA 模式切换。三者语义冲突，靠调用点区分 | R+W | `_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:5/34/47`；`SdkApi/CameraProperties.java:1419` |
| `0xD7FC` | 55292 | `VIDEO_SIZE_FLOW` | `getVideoSizeFlow()` | String | 当前录像帧率流信息串 | R | `SdkApi/CameraProperties.java:1273` |
| `0xD7FD` | 55293 | `VIDEO_RECORDING_TIME` | `getVideoRecordingTime()` | int（秒） | 已录时长，计时器轮询 | R | `SdkApi/CameraProperties.java:1259`；`Presenter/PreviewPresenter.java:714` `startRecordingLapseTimeTimer(int)` |
| `0xD7FF` | 55295 | `SUPPORT_PREVIEW` | `isSupportPreview()` | bool | 是否支持预览流 | R | `SdkApi/CameraProperties.java:1379` |
| `0xD831` | 55345 | `CAMERA_NAME` | `getCurrentStringPropertyValue` / `setCameraName(String)` | String | 设备名 | R+W | `SdkApi/CameraProperties.java:156`（无参）、`:182`（传 property）、`:1554` set |
| `0xD832` | 55346 | `CAMERA_PASSWORD_NEW` | 同上 | String | 新 WiFi 密码（写用） | R+W | `_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:234`、`:1606` |
| `0xD834` | 55348 | `ESSID_NAME` = `STA_MODE_SSID` | `getCameraEssidName()` / `setCameraEssidName(String)` | String | STA 模式 SSID | R+W | `_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:97`、`:1502` |
| `0xD835` | 55349 | `ESSID_PASSWORD` = `STA_MODE_PASSWORD` | `getCameraEssidPassword()` / `setCameraEssidPassword(String)` | String | STA 模式密码 | R+W | `_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:123`、`:1528` |
| `0xD836` | 55350 | `SERVICE_ESSID` | `setServiceEssid(String)` | String | AP 模式 SSID（写） | W | `_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:1833` |
| `0xD837` | 55351 | `SERVICE_PASSWORD` | `setServicePassword(String)` | String | AP 模式密码（写） | W | `_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:1859` |
| `0xD83C` | 55356 | `CAMERA_ESSID` | `getCameraSsid()` / `setCameraSsid(String)` | String | 当前生效 SSID | R+W | `_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:260`、`:1632` |
| `0xD83D` | 55357 | `CAMERA_PASSWORD` | `getCameraPassword()` / `setCameraPassword(String)` | String | 当前生效密码 | R+W | `_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:208`、`:1580` |
| `0xD83E` | 55358 | `CAMERA_DATE_TIMEZONE` | `setCameraDateTimeZone()` | String/int | 时区，连上后与 `0x5011` 一起下发 | R+W | `_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:1472`；`Presenter/LaunchPresenter.java:288`（WiFi 连接流程）、`:319`（USB 连接流程） |
| `0xD83F` | 55359 | `CAMERA_PB_LIMIT_NUMBER` | `getCurrentPropertyValue` / 能力判定 | int | 回放列表一次取多少条 | R | `ui/RemoteFileHelper.java:200/218`；`ui/RemoteFileHelper2.java:199/217` |

**G-Sensor `0xD7BC` 的 5 档**（HTTP 通道用同一语义，见附录 B）：
`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:71` 的 `getGSensorMap` 直接读固件 supported 列表；HTTP 侧写死为
`par=0` Off / `par=1` Low / `par=2` Med / `par=3` High / `par=4` Max
（`com/icatch/golive/net/RequestInfo.java:19-23`）。

`0xD7DB` 这个值 **不存在**（55259）；被文档写成「`0xD7DB` 一个 ID 三重载」的其实是 **`0xD7FB` = 55291**。

---

## 2. `0x50xx` 标准段 + 其它高位段

| ID | 十进制 | Java 常量 | SDK 语义 API | PTP 1.1 标准含义（同值） | iCatch 实际用法 | 读写 | 调用点 |
|---|---|---|---|---|---|---|---|
| `0x5001` | 20481 | `ICH_CAM_CAP_BATTERY_LEVEL` | `ICatchCameraControl.getCurrentBatteryLevel()` | FunctionalMode | 电量档位；预览页注册事件时用 | R + 事件 | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:5`；`Presenter/PreviewPresenter.java:1054` `addEvent()`、`:1233` `delEvent()`、`:1533` `initStatus()` |
| `0x5003` | 20483 | `IMAGE_SIZE` | `getCurrentImageSize()` / `setCurrentImageSize(String)` / `getSupportedImageSizes()` | CompressionSetting | 拍照分辨率**字符串**（非枚举），如 `"3840x2160"`；SDK 另有 int 枚举 `ICatchCamImageSize`：0=VGA,2=2M,3=3M,5=5M,6=6M,8=8M,10=10M,255=UNDEFINED | R+W | `_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:29`；`Function/BaseProrertys.java:69`（`new PropertyTypeString(...,20483,...)`）；`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:93` `getImageSizeMap` |
| `0x5005` | 20485 | `WHITE_BALANCE` | `getCurrentWhiteBalance()` / `setWhiteBalance(int)` / `getSupportedWhiteBalances()` | RGBGain | 白平衡：1=Auto、2=Daylight、3=Cloudy、4=Fluorescent、5=Tungsten（`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:124-128`）；SDK `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamWhiteBalance.java:5-10` 同值并加 65471=UNDEFINED | R+W | `_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:54`；`Function/BaseProrertys.java:53` |
| `0x5011` | 20497 | `CAMERA_DATE` | `setCameraDate()` | DateTime | 连上后同步手机日期，格式 `yyyy-MM-dd`（与 `0x5012`/`0x5013` 一并写） | R+W | `_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:10`；`_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:1445`；`SdkApi/mobileapi/PanoramaSession.java:219`；`_work/idgo_live_src/sources/com/icatch/golive/Presenter/LaunchPresenter.java:288/319` |
| `0x5012` | 20498 | `CAPTURE_DELAY` | `getCurrentCaptureDelay()` / `setCaptureDelay(int)` / `getSupportedCaptureDelays()` | CaptureDelay | 自拍延时，单位毫秒：0=No、2000=2S、10000=10S，65535=UNDEFINED（`_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamCaptureDelay.java:5-8`） | R+W | `_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:19`；`Function/BaseProrertys.java:67`；`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapDynamic.java:36` |
| `0x5016` | 20502 | `ICH_CAM_CAP_DIGITAL_ZOOM` | `getCurrentZoomRatio()` / `getMaxZoomRatio()` | ExposureBracketMode | 数码变焦当前/最大倍率 | R | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:9` |
| `0x5018` | 20504 | `BURST_NUMBER` | `getCurrentBurstNumber()` / `setBurstNumber(int)` / `getSupportedBurstNumbers()` | — | 连拍：0=HS(高速连拍)、1=Off、2=3张、3=5张、4=10张、5=7张、6=15张、7=30张（`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:85-92`；SDK `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamBurstNumber.java:5-13` 同值 + 65535=UNDEFINED）。**注意 4→10 张、5→7 张 顺序倒挂**，UI 图标分别为 `continuous_shot_3` / `continuous_shot_7` | R+W | `_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:8`；`Function/BaseProrertys.java:54`(burst) |
| `0x501B` | 20507 | `ICH_CAM_CAP_TIMELAPSE_STILL` | `getCurrentTimeLapseInterval()` / `setTimeLapseInterval(int)` / `getSupportedTimeLapseIntervals()` | — | 缩时拍照间隔枚举：1=Off,2=1S,3=5S,4=10S,5=20S,6=30S,7=1M,8=5M,9=10M,10=30M,11=1HR（`_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamTimeLapseInterval.java:5-16`）。App 的 `TimeLapseInterval` 另用「秒」数值域：0=OFF、-2 特殊、按 `h/m/s` 换算（`data/type/TimeLapseInterval.java`） | R+W | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:18` |
| `0x501E` | 20510 | `ICH_CAM_CAP_PRODUCT_NAME` | `ICatchCameraInfo.getCameraProductName()` | — | 产品名；native 侧 `getCameraProductName` 符号存在 | R | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:16`；`natives-symbols.tsv` `getCameraProductName` |
| `0x501F` | 20511 | `ICH_CAM_CAP_FW_VERSION` | `ICatchCameraInfo.getCameraFWVersion()` | — | 固件版本，设置页「关于」显示 | R | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:10`；`Function/Setting/UIDisplaySource.java:34/99/135`；native `getCameraFWVersion` |
| `0xE604` | 58884 | `ICH_CAM_CAP_MOVIE_REC` | 能力位 | — | 录像能力探测 | 探测 | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:15` |
| `0xEE00` | 60928 | `TIMELAPSE_MODE` | `getCurrentPropertyValue(60928)` | — | 缩时模式：0=拍照(Still)、1=录像(Video)（`_work/idgo_live_src/sources/com/icatch/golive/data/Hash/PropertyHashMapStatic.java:39-40`；`data/type/TimeLapseMode.java`） | R+W | `_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:46`；`Function/BaseProrertys.java:73` |
| `0xFFFF` | 65535 | `ICH_CAM_CAP_UNDEFINED` | 哨兵 | — | — | — | `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamProperty.java:20` |

未在调用点出现、仅存常量的：`0xD72A CAPTURE_IN_VIDEO_RECORD`、`0xD729 MULTIPLE_CAMERA_SENSOR`（走 `getNumberOfSensors()`）、`0xD733 CAMERA_SWITCH`。

---

## 3. 模式 / 事件 / 能力枚举（属性表的配套字典）

### 相机模式 `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamMode.java:5-16`
`1=VIDEO_OFF`、`2=SHARED`、`3=CAMERA`、`4=IDLE`、`7=TIMELAPSE_STILL`、`8=TIMELAPSE_VIDEO`、`9=TIMELAPSE_STILL_OFF`、`10=TIMELAPSE_VIDEO_OFF`、`17=VIDEO_ON`、`42=VIDEO`、`43=TIMELAPSE`、`65471=UNDEFINED(0xFFBF)`。
预览模式 `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamPreviewMode.java:5-8`：`1=STILL`、`2=VIDEO`、`3=TIMELAPSE_STILL`、`4=TIMELAPSE_VIDEO`。

### 事件 `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamEventID.java:5-47`（全量）
`1=FILE_ADDED`、`2=FILE_REMOVED`、`3=FILE_INFO_CHANGED`、`17=SDCARD_FULL`、`18=SDCARD_ERROR`、`19=SDCARD_REMOVED`、`20=SDCARD_IN`、`21=SDCARD_INFO_CHANGED`、`33=VIDEO_ON`、`34=VIDEO_OFF`、`35=CAPTURE_COMPLETE`、`36=BATTERY_LEVEL_CHANGED`、`49=DEVICE_INFO_CHANGED`、`50=WHITE_BALANCE_PROP_CHANGED`、`51=CAPTURE_DELAY_PROP_CHANGED`、`52=IMAGE_SIZE_PROP_CHANGED`、`53=VIDEO_SIZE_PROP_CHANGED`、`54=LIGHT_FREQUENCY_PROP_CHANGED`、`55=BURST_NUMBER_PROP_CHANGED`、`74=CONNECTION_DISCONNECTED`、`75=CONNECTION_INITIALIZE_SUCCEED`、`76=CONNECTION_INITIALIZE_FAILED`、`81=TIMELAPSE_STOP`、`82=CAPTURE_START`、`85=DEVICE_SCAN_ADD`、`96=FW_UPDATE_CHECK`、`97=FW_UPDATE_COMPLETED`、`98=FW_UPDATE_POWEROFF`、`99=FW_UPDATE_CHKSUMERR`、`100=FW_UPDATE_NG`、`101=VIDREC_TIME_CHANGE`、`103=FILE_DOWNLOAD`、`104=VIDEO_THUMB_READY`、`105=VIDEO_THUMB_DONE`、`106=VIDEO_TRIM_DONE`、`128=SD_CARD_OUT`、`129=SD_CARD_IN`、`130=SD_CARD_ERR`、`131=SD_CARD_LOCKED`、`132=SD_CARD_MEMORY_FULL`、`133=INSUFFICIENT_DISK_SPACE`、`134=SD_CARD_SPEED_TOO_SLOW`、`255=UNDEFINED`。
（SD 卡有两套码：17-21 老码 与 128-134 新码，App 两套都监听。）

### 能力位 `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamFeatureID.java:5-7`
`1=APP_DEFAULT_TO_PLAYBACK`、`2=NEW_PAGINATION_GET_FILE`、`4=TIMELAPSE_USING_MS_VALUE`。
探测接口 `ICatchCameraProperty.checkCameraCapabilities(int)` → JNI `checkCameraCapabilities(sessionID, featureID)`（`_work/idgo_live_src/sources/com/icatchtek/control/core/jni/JCameraProperty.java:19-36`）。
调用点：`ui/RemoteFileHelper.java:218` / `_work/idgo_live_src/sources/com/icatch/golive/ui/RemoteFileHelper2.java:217` `initSupportCapabilities()`（用 `2` 判断是否走分页取文件 + `CAMERA_PB_LIMIT_NUMBER` 决定批量），`Presenter/LaunchPresenter.java:771` `redirectToAnotherActivity`、`Presenter/RemoteMultiPbPresenter.java:215`、`_work/idgo_live_src/sources/com/icatch/golive/Presenter/RemoteMultiPbPresenter2.java:170`（用 `1`）。

### 回放文件过滤 `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamListFileFilter.java:5-17`
OFC 类型：`17=VIDEO`、`18=IMAGE`、`19=MEDIA`、`33=EMERGENCY_VIDEO`、`34=EMERGENCY_IMAGE`、`35=EMERGENCY_MEDIA`、`255=ALL_MEDIA`。
排序：`1=DESCENDING`、`2=ASCENDING`。传感器：`0=ALL`、`1=FRONT`、`2=BACK`；合成 `3=COMPOSITE`。

---

## 4. 静态拿不到的东西（明确标注）

| 缺口 | 为什么拿不到 | 补证手段 |
|---|---|---|
| 每个属性的**默认值 / 固件真实取值集合** | App 从 `GetDevicePropDesc` 动态拉，源码里无数组 | 真机连一次，调 `getSupportedProperties()` + 对每个 ID 调 `getSupportedPropertyValues(id)` 打印 |
| native 侧「语义 API → 属性 ID」硬编码映射 | `ICatchCameraPropertyImpl` 不传 ID，ID 在 `libcontrol.so` .text 里；本仓库实测：`.text`（off=0x48b20，size=0x70b74）内 `MOVZ Wd,#imm16` 只有 30 个不同立即数、**0 个落在 0x5000-0xFFFF**，说明常量是 ADRP+LDR 从 .data/.rodata 载入，不是内联立即数 | IDA/Ghidra 反编译 `icatch_get_dev_prop_value` 与 `Java_..._getCurrentImageSize` 的调用链 |
| `0xD7FB` 三重载的运行时消歧 | 三个 Java 名字同值 55291 | 抓包看同一 ID 的 GetPropValue / SetPropValue 载荷差异 |
| 属性写入的字节序/宽度 | Java 只有 `byte[]` + length（`setProperty(int id, byte[], int)`，`_work/idgo_live_src/sources/com/icatchtek/control/customer/ICatchCameraProperty.java:107`），宽度判定在 native | 抓 PTP 包，对照 PTP 1.1 §5.2 的 datatype 编码 |

---

## 5. 与既有文档的差异（预告，详见主档案「纠正」章）

- `0xD7DB` → 实际是 `0xD7FB`（55291）。
- 「设置项 = `0xD7xx` + `0x50xx`」不完整：还存在 **`0xD6xx` 段**（`0xD605/0xD606/0xD607/0xD611/0xD614/0xD615`）与 **`0xEE00`、`0xE604`**。
- `IMAGE_SIZE=0x5003` / `WHITE_BALANCE=0x5005` / `DIGITAL_ZOOM=0x5016` 与 PTP 1.1 标准表**同码不同名**（标准里 0x5002=ImageSize、0x5004=WhiteBalance）；而 `CAMERA_DATE=0x5011`、`CAPTURE_DELAY=0x5012` 与标准**完全一致**。这说明 iCatch 固件只在「图像尺寸/白平衡/变焦」三项上占用了别的码，不能简单说「全部偏移一位」。

---

<!-- 以下整段合并自原 03-idGoLive-档案-附录-HTTP与TCP命令.md（2026-09-22 文档归并，内容未改） -->
# 附录 B · idGoLive HTTP / TCP 命令目录全量

> 返回 主档案（本文附录）。证据根：`_work/idgo_live_src/sources/`。
> 本章覆盖 **非 PTP 的全部 IP 通道**：Novatek 风格 `?custom=1&cmd=NNNN`、`/app/*` JSON、`/api/*deviceinfo*`、XML-over-TCP:3333、RTSP、HTTP 缩略图/下载、UDP 组播发现。

---

## 1. `?custom=1` 的语义

字面量在 App 里是**硬编码前缀**，不是协商结果：`com/icatch/golive/net/RequestInfo.java:8-66` 全部 59 条常量都带 `custom=1`。
唯一例外是 `urlQueryStatus = "http://192.168.1.254/?custom=1&cmd="`（`_work/idgo_live_src/sources/com/icatch/golive/net/RequestInfo.java:52`），拼上编号后使用。
Novatek NoVI 2.x 的 HTTP CGI 约定：`custom=1` = 「使用厂商自定义 CGI 解析器」，`cmd` = 16 进制语义的十进制编号，参数走 `par=`（数值/枚举）或 `str=`（字符串/路径）。App 侧从不校验 `custom`，它只是固定串。响应为 **XML**（`<?xml version="1.0"?>…`），由 `com/icatch/golive/utils/XmlParseUtil.java` 用 `XmlPullParser` 解析。

---

## 2. Novatek 风格命令表（主机 `192.168.1.254`，`http://192.168.1.254/?custom=1&cmd=…`）

来源文件：`com/icatch/golive/net/RequestInfo.java`（行号即常量行）。
响应解析器：`com/icatch/golive/utils/XmlParseUtil.java`；调用者：`com/icatch/golive/net/LyIC.java`。

| cmd | 常量名（file:line） | 完整请求 | 参数 | 响应标签 / 解析函数 | 调用点 |
|---|---|---|---|---|---|
| 1001 | `urPhtotCapture` (`_work/idgo_live_src/sources/com/icatch/golive/net/RequestInfo.java:8`) | `?custom=1&cmd=1001` | — | 无解析（仅发送） | 拍照（Ly 通道未接，见 `LyIC.takePicture` 用 2017） |
| 1002 | `urPhtotCaptureSize12M`(`:10`) `…10M`(`:9`) `…8M`(`:12`) `…5M`(`:11`) | `?custom=1&cmd=1002&par=N` | par=0→12M、1→10M、2→8M、3→5M | — | 拍照尺寸 |
| 2001 | `urlMovieRecordStart`(`:47`) / `urlMovieRecordStop`(`:48`) / `clickLive` | `?custom=1&cmd=2001&par=1` / `&par=0` | par=1 开始、0 停止 | 无 | `_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:69/99/153` |
| 2002 | `urlMovieRecordSizeCustom`(`:46`) | `?custom=1&cmd=2002&par=` | par=分辨率枚举 | `<Item Index>` 列表 / `parseXMLToVideoItemWithPull`（`_work/idgo_live_src/sources/com/icatch/golive/utils/XmlParseUtil.java:93`） | `LyIC.getItemsRecResolution` (`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:26`) |
| 2003 | `urlCyclicRecordCustom`(`:14`) | `?custom=1&cmd=2003&par=` | par=循环时长 | 菜单项解析，`Id==2003` → key `Cmd2003`（`_work/idgo_live_src/sources/com/icatch/golive/utils/XmlParseUtil.java:16/41`） | 设置页 |
| 2004 | `urlWDROn`(`:66`) / `urlWDROff`(`:65`) | `?custom=1&cmd=2004&par=1` / `0` | 宽动态 | `Cmd2004` | 设置页 |
| 2008 | `urlTimeImprintOn`(`:63`) / `…Off`(`:62`) | `?custom=1&cmd=2008&par=1` / `0` | 时间水印 | — | 设置页 |
| 2011 | `urlGSensorOff/Low/Med/High/IdMax`(`:19-23`) | `?custom=1&cmd=2011&par=0..4` | 0=Off,1=Low,2=Med,3=High,4=Max | `Id==2011` → `Cmd2011`（`_work/idgo_live_src/sources/com/icatch/golive/utils/XmlParseUtil.java:44`） | G-Sensor 菜单 |
| 2015 | `urlMovieLiveStart`(`:44`) / `urlMovieLiveStop`(`:45`) | `?custom=1&cmd=2015&par=1` / `&par=0` | **打开/关闭 RTSP 副机预览** | 无 | `LyIC.startMovieLive`(`:84`)、`rtStartMovieLive`(`:54`) |
| 2016 | `urlMovieRecordingTime`(`:49`) | `?custom=1&cmd=2016` | — | `<Value>` / `parseXMLWithPull(obj,["Value"])` | `LyIC.getRecDuration`(`:234`) |
| 2017 | `urlTriggerRAWencode`(`:64`) | `?custom=1&cmd=2017` | — | 无 | `LyIC.takePicture`(`:420`) |
| 2018 | `urlGetRAWencodeJPEG`(`:31`) | `?custom=1&cmd=2018` | — | — | 取抓拍 JPEG |
| 3001 | `urlModeChangePhoto/Movie/Playback`(`:42/41/43`) | `?custom=1&cmd=3001&par=0\|1\|2` | 0=拍照、1=录像、2=回放 | 无 | `LyIC.ready2CamLive`(`:333`)、`quit2RemoteFile`(`:318`)、`leaveRemoteFile`(`:299`) |
| 3003 | `urlSetSSID`(`:59`) | `?custom=1&cmd=3003&str=<ssid>` | str=新 SSID | 无 | 改 WiFi |
| 3004 | `urlSetPassphrase`(`:58`) | `?custom=1&cmd=3004&str=<pwd>` | str=新密码 | 无 | 改 WiFi 密码 |
| 3005 | `urlSetDate`(`:57`)；`LyIC.syncLocalTime`(`:392`) 直接内联完整串 | `?custom=1&cmd=3005&str=yyyy-MM-dd` | 日期 | 无 | 时间同步（与 3006 各发一次，两个独立请求） |
| 3006 | `urlSetTime`(`:60`)；`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:393` 内联 | `?custom=1&cmd=3006&str=HH:mm:ss` | 时间 | 无 | 同上 |
| 3010 | `urlFormat`(`:18`) | `?custom=1&cmd=3010&par=1` | par=1 确认格式化 | 无 | 格式化 SD |
| 3011 | `urlSystemReset`(`:61`) | `?custom=1&cmd=3011` | — | 无 | 恢复出厂 |
| 3012 | `urlGetVersion`(`:33`) | `?custom=1&cmd=3012` | — | 固件版本 | 关于页 |
| 3014 | `urlQueryCurrentStatus`(`:50`) | `?custom=1&cmd=3014` | — | 任意标签，按传入 list 取；`LyIC.getRecResolution` 只取 `"2002"`（`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:251` 局部常量 `str="2002"`） | 查当前模式/当前值 |
| 3015 | `urlFileList`(`:17`) | `?custom=1&cmd=3015` | — | `ALLFile` 下每条 `NAME / FPATH / SIZE / TIMECODE / TIME / ATTR`，由 `XmlParseUtil.parseXMLWithPull(String)`（`:110-146`）产出 `FileInfo` 列表 | `LyIC.getFileList`(`:195`)，按 `furl` 含 `/Movie/`、`/SOS/`、`/Photo/` 分流 |
| 3016 | `urlHeartbeatPackage2`(`:36`) | `?custom=1&cmd=3016` | — | 无 | 心跳备选 |
| 3017 | `urlGetFreeSpace`(`:27`) | `?custom=1&cmd=3017` | — | `<Value>` | 剩余空间 |
| 3018 | `urlReconnectWiFi`(`:53`) | `?custom=1&cmd=3018` | — | 无 | 让相机重连 WiFi |
| 3021 | `urlSaveMenuSettings`(`:56`) | `?custom=1&cmd=3021` | — | 无 | 提交菜单设置 |
| 3024 | `urlGetCardStatus`(`:25`) | `?custom=1&cmd=3024` | — | `<Value>` | 卡状态 |
| 3029 | `urlGetSSID`(`:32`) | `?custom=1&cmd=3029` | — | `<SSID>` + `<PASSPHRASE>`（`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:275`） | 连接握手；成功后立刻 `initSocket()` 开 TCP:3333（`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:280/285-291`） |
| 3030 | `urlGetMoveSizeCapacity`(`:30`) | `?custom=1&cmd=3030` | — | `<Item Index>` 索引列表 | 录像规格能力表 |
| 3031 | `urlQueryMenuItem`(`:51`) | `?custom=1&cmd=3031&str=all` | str=all | `Cmd` / `Index` / `Id`，`Id` ∈ {2003,2011,8010,8011} → key `CmdNNNN`（`_work/idgo_live_src/sources/com/icatch/golive/utils/XmlParseUtil.java:16-19,35-52`） | 动态菜单：固件决定显示哪些项 |
| 3044 | `urlLensRotationOn`(`:38`) / `…Off`(`:37`) | `?custom=1&cmd=3044&par=1\|0` | 镜头旋转 | — | 设置页 |
| 4002 | （`entity/FileInfo.java:55` 内联） | `<视频URL>?custom=1&cmd=4002` | 视频文件路径后挂 cmd | 二进制 JPEG 缩略图 | 回放墙缩略图 |
| 4003 | `urlDeleteOneFile`(`:16`) | `?custom=1&cmd=4003&str=<path>` | str=文件路径 | 无 | 删除单文件 |
| 4004 | `urlDeleteAll`(`:15`) | `?custom=1&cmd=4004` | — | 无 | 删除全部 |
| 8010 | `urlMicrophoneModeNoumenon/Headphone`(`:39/40`) | `?custom=1&cmd=8010&par=0\|1` | 0=机身麦、1=耳机麦 | `Cmd8010` | 录音源 |
| 8011 | `urlRecordAudioOn/Off`(`:55/54`) | `?custom=1&cmd=8011&par=1\|0` | 录音开关 | `Cmd8011` | 设置页 |
| 8012 | `urlGetHeadphoneState`(`:28`) | `?custom=1&cmd=8012` | — | `<Value>` | 耳机插入状态 |
| 8013 | `urlGetBatteryState`(`:24`) | `?custom=1&cmd=8013` | — | `<Value>`（`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:181`） | 电量 |
| 8888 | `urlHeartbeatPackage`(`:35`) | `?custom=1&cmd=8888` | — | 无 | **心跳主用**，周期 10000 ms（`LyIC.getHeartbeatPeriod()` `_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:225`） |

Novatek 文件服务器路径前缀：`http://192.168.1.254/Novatek/<父目录>/<文件名>`，缩略图 = 该 URL + `?custom=1&cmd=4002`（`entity/FileInfo.java:53-55`）。文件大小按 `size/1024/1024` 显示为 MB，仅当 URL 含 `Novatek` 时（`FileInfo.getSizeKeep2()`，`_work/idgo_live_src/sources/com/icatch/golive/entity/FileInfo.java:75-84`）——否则按 KB 直显，是原样保留的厂商兼容分支。

---

## 3. `/app/*` + `/api/*deviceinfo*` JSON 通道

两个主机共享同一套路径模板，只是 IP 不同：

| 主机 | 常量类 | 备注 |
|---|---|---|
| `192.168.169.1` | `com/icatch/golive/net/M1RequestInfo.java:5-46`（42 条） | 由 `QzIC` 使用（`net/QzIC.java`） |
| `192.168.1.254` | `com/icatch/golive/net/LyWyzRequestInfo.java:5-48`（44 条） | 由 `LyCmdWithYzIC` 使用；**混合** Novatek `?custom=1` 与 `/app/*` |

### 3.1 `/app/` 端点全表（以 `192.168.169.1` 为例；`M1RequestInfo.java` 行号）

| 路径 | 方法 | 常量:行 | 用途 / 响应 |
|---|---|---|---|
| `/app/getdeviceattr` | GET | `:21` | `info.ssid`（`QzIC.getSSID` `_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:389`） |
| `/app/getproductinfo?` | GET | `:17` | 产品信息 |
| `/app/getmediainfo` | GET | `:14` | 媒体信息（`_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:363` 仅打日志，不消费） |
| `/app/getsdinfo` | GET | `:19` | `info.status`（0=正常）→ 再请 `/app/getrecduration`（`QzIC.handleDeviceSdStatus` `:29-58`） |
| `/app/getrecduration` | POST | `:18` | `result==0` + `info.duration` |
| `/app/getcapability` | GET | `:11` | 能力 |
| `/app/getparamvalue?param=all` | GET | `:16` | 全部参数值 |
| `/app/getparamvalue?param=rec_resolution` | POST | `:22` | `info.value` = 索引整数 |
| `/app/getparamvalue?param=rec` | POST | `:24` | **心跳**（`QzIC.getHeartbeatPeriod()` = **4000 ms**，`_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:239`） |
| `/app/getparamitems?param=all` | POST | `:15` | `info[]`，每项 `{name, items[], index[]}`；`name=="rec_resolution"` 时 items/index 平行查表（`QzIC.getItemsRecResolution` `:242-280`） |
| `/app/getparamitems?param=rec_resolution` | POST | `:13` | 单项 |
| `/app/setparamvalue?param=<p>&value=<v>` | POST | `:42/33/34/43/44` | 通用写；`param=rec&value=1/0` 起停录；`param=switchcam&value=0/1` 前后镜头 |
| `/app/getfilelist?folder=loop&start=0&end=99` | GET | `:8` + 动态拼 | 分页；首屏 `start=0&end=99`，`getMoreFileList` 每次 `start=prev_end+1`、`end=prev_end+101`（**步长 101 而非 100**，`_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:283-287`）；失败时 `load_end_index -= 101` 回滚（`:292`） |
| `/app/getfilelist?folder=event&start=0&end=99999` | GET | `:9` | 照片列表 |
| `/app/getfilelist?folder=emr&start=0&end=99999` | GET | `:7` | 紧急（SOS）列表 |
| `/app/getthumbnail?file=<path>` | GET | `entity/FileInfo.java:27` | 缩略图 |
| `/app/deletefile?file=<path>` | GET | `:6` | 删除 |
| `/app/sdformat` | GET | `:10` | 格式化 |
| `/app/reset` | GET | `:45` | 恢复出厂 |
| `/app/wifireboot` | GET | `:36` | WiFi 重连 |
| `/app/enterrecorder` / `/app/exitrecorder` | POST | `:29/30` | 进入/退出录像模式 |
| `/app/playback?param=enter` / `?param=exit` | POST | `:27/28` | 进入/退出回放 |
| `/app/setting?param=enter` / `?param=exit` | POST | `:31/32` | 进入/退出设置 |
| `/app/setwifi?` | GET | `:41` | 改 WiFi 基址 |
| `/app/snapshot` | POST | `:46` | 拍照 |
| `/api/setdeviceinfo/?custom=1&cmd=1100&par=0` | GET | `:5` | 拍照（cmd 走 api 前缀） |
| `/api/setdeviceinfo/?custom=1&cmd=3033&par=1` | GET | `:26` | 模式切换其它 |
| `/api/setdeviceinfo/?custom=1&cmd=4016&par=1` | GET | `:25` | 心跳启动 |
| `/api/setdeviceinfo/?custom=1&cmd=1008&par=0\|1` | GET | `:38/39` | 相机 OSD 语言：0=中文、1=英文 |
| `/api/setdeviceinfo/?custom=1&cmd=3005&str=` | GET | `:37` | 日期（`/api` 版） |
| `/api/getdeviceinfo/?custom=1&cmd=2002` | GET | `:12` | 当前录像分辨率 |
| `/api/getdeviceinfo/?custom=1&cmd=2004` | GET | `:20` | 卡状态 |
| `/api/getdeviceinfo/?custom=1&cmd=3031` | GET | `:35` | 菜单项 |
| `/app/setsystime?date=yyyyMMddHHmmss` | GET | `:40`；拼法见 `_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:496`（`getYearMonthDay().replace("-","") + getHourMinuteSecond().replace(":","")`） | 时间同步 |

JSON 信封统一为 `{"result":<int 0=成功>, "info":…}`；`LyCmdWithYzIC` 的 `getFileList` 例外，用 `{"status":0, "list":{"REC":[{name,fpath,cover,size}]}}`（`_work/idgo_live_src/sources/com/icatch/golive/net/LyCmdWithYzIC.java:48-59`）。
文件 URL 基址硬编码为 `"http://192.168.169.1:80"`（`_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:66`）/ `"http://192.168.1.254:80"`（`_work/idgo_live_src/sources/com/icatch/golive/net/LyCmdWithYzIC.java:80`）——**带显式 `:80`**。
`LyCmdWithYzIC` 另有一条批量命令：`/?custom=1&cmd=2001,8010,3001&str=0,0,10`（`_work/idgo_live_src/sources/com/icatch/golive/net/LyWyzRequestInfo.java:6`），即 `cmd` 与 `str` 用逗号做**平行数组批处理**（停录 + 关耳机麦 + 切模式 10）。
`_work/idgo_live_src/sources/com/icatch/golive/ui/activity/YdeviceSettingActivity.java:530/585` 直接内联 `http://192.168.169.1/app/setparamvalue?param=`（含 `param=encodec&value=0`，`encodec` 是原文拼写，非 `encoder`）。

---

## 4. XML-over-TCP `192.168.1.254:3333`（相机 → App 主动推送）

| 项 | 值 | 证据 |
|---|---|---|
| 建立时机 | `LyIC.getSSID()` 成功（cmd=3209…实际 3029）后**立即** `initSocket()` | `net/LyIC.java:280` → `:285-291` |
| 地址/端口 | `connectAndReceive("192.168.1.254", 3333)` | `net/LyIC.java:289` |
| 连接超时 | `Socket.connect(new InetSocketAddress(host,port), **5000**)` | `net/LySocketClient.java:125` |
| 读缓冲 | `byte[1024]`，UTF-8 解码 | `_work/idgo_live_src/sources/com/icatch/golive/net/LySocketClient.java:49/51` |
| 分帧 | 累积到 buffer 里出现 **`</Function>`** 即认为一条完整报文，清空重来 | `_work/idgo_live_src/sources/com/icatch/golive/net/LySocketClient.java:52-61` |
| 解析标签 | 只取 `<Cmd>` 与 `<Status>`（`Arrays.asList("Cmd","Status")`） | `_work/idgo_live_src/sources/com/icatch/golive/net/LySocketClient.java:32` |
| 缺省值 | `Status` 为 null 时置 `"0"`（`AppEventsConstants.EVENT_PARAM_VALUE_NO`），再 `Integer.parseInt` | `_work/idgo_live_src/sources/com/icatch/golive/net/LySocketClient.java:37-40` |
| 分发 | 转成 `LocalBroadcast`，action = `"ReceivedLySocketMsg"`，extra `"Cmd"`(String) / `"Status"`(int) | `_work/idgo_live_src/sources/com/icatch/golive/net/LySocketClient.java:35-41`；常量 `LyIC.kReceivedLySocketMsg`，`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:21` |
| 线程模型 | 单线程 `ExecutorService` + 主线程 `Handler`；`receiveMessages()` 是**只读**长循环（本通道不下行发数据） | `_work/idgo_live_src/sources/com/icatch/golive/net/LySocketClient.java:27/44-81` |
| 心跳 | 本 TCP 通道**无**心跳；心跳走 HTTP cmd=8888，周期 10000 ms | `_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:225/363` |
| 关闭 | `disconnect()` 置 `isConnected=false` 并关流与 socket | `_work/idgo_live_src/sources/com/icatch/golive/net/LySocketClient.java:93-109` |

报文示例（由解析器反推的唯一合法形状）：
`<Function><Cmd>2001</Cmd><Status>1</Status></Function>`。
注意：`XmlParseUtil.parseXMLWithPull(String, List)` 只匹配**事件类型 2（START_TAG）**后紧跟文本，因此报文内层必须是 `<Cmd>`/`<Status>` 的直接文本节点。

---

## 5. 发现与健康检查

### 5.1 UDP 组播（双实现：Java 侧 + native 侧）

| 项 | 值 | 证据 |
|---|---|---|
| 组地址 / 端口 | `234.168.168.168` : `5002` | `com/icatchtek/control/core/CoreMulticast.java:15-16`；native 同址 `libcontrol.so` 字符串 `234.168.168.168`（`natives-strings.tsv` category=ip, lib=lib/arm64-v8a/libcontrol.so） |
| Java 侧 | `MulticastSocket(5002)` + `joinGroup` + `setSoTimeout(**200**)`，收包缓冲 `byte[256]`，`MulticastLock("multicast.test").acquire()` | `_work/idgo_live_src/sources/com/icatchtek/control/core/CoreMulticast.java:21-30/53-60` |
| 唯一持有者 | `ICatchCameraAssistImpl` 的内部类字段 `private CoreMulticast multicast = new CoreMulticast();` | `com/icatchtek/control/core/feature/ICatchCameraAssistImpl.java:50` |
| 日志 tag | `"__multi_cast_recv__"`，打印 `address:` 与 `content:` | `_work/idgo_live_src/sources/com/icatchtek/control/core/CoreMulticast.java:59-60` |
| native 侧 | `multic_server_func` / `multicast_receive` / `checkpattern succeed, copy_response_data done, quit` / `Fail to sendto ssid or passwd length` / `sendto` / `recvfrom` / `bind()` / `socket() failed` | `libcontrol.so` .rodata（`/tmp` 全量 strings 提取，行 3855-3870） |
| 权限 | `android.permission.CHANGE_WIFI_MULTICAST_STAT`（**清单里写错，正字为 `…_MULTICAST_CAST`**） | `_work/re/idgolive/manifest.md:70` |

**新发现（此前未记录）**：native 的 `simpleconfig_main` + `<AP Infor FIle>` + `[16 bits AES Key]` + `AES_cbc_encrypt/decrypt_sdk` + `Send crypt error` + `[%s,%d][AES KEYS]Using the default AES Encrytion keys` 构成一条 **AES-CBC 加密的 UDP 组播配网（airlink/smartconfig 风格）通道**，且带 `Usage:` 提示，说明 `libcontrol.so` 内嵌了一个可独立运行的配网小程序。这与「idGoLive 无配网能力」的旧结论冲突，详见主档案「纠正」章。

### 5.2 ICMP ping 选 handler

```
Runtime.getRuntime().exec("ping -c 3 -w 3 " + host)   // com/icatch/golive/net/ConnectDeviceManager.java:266
waitFor()==0 -> handler.sendEmptyMessage(200 /*pingSuccess*/)
        else -> handler.sendEmptyMessage(100 /*pingFailed*/)
```
`initDevice()`（`_work/idgo_live_src/sources/com/icatch/golive/net/ConnectDeviceManager.java:46-77`）并行起两个 ping 线程：

| 探活目标 | 成功后的候选 | 失败处理 |
|---|---|---|
| `192.168.1.254` | `try2connectLyIC()` → `new LyIC()` → `getSSID()`（HTTP 3029） | `failure_connect_count++`；累计到 **2** → `handler.sendEmptyMessage(404)` |
| `192.168.169.1` | `try2connectYzIC()` → `new QzIC()` → `getSSID()` | 同上，**共用同一个 `failure_connect_count` 计数器**（两路 ping 竞争自增） |

`try2connectLyIC` 内：`SSID == null` → `sendFailureMessage`；非 null → 记住 `device_ssid` 并把 `this.ic = lyIC`。
`try2connectLywyzIC()`（`_work/idgo_live_src/sources/com/icatch/golive/net/ConnectDeviceManager.java:112-133`）存在且逻辑完整（先试 `LyCmdWithYzIC`，SSID 空则回退 `try2connectLyIC`），**但 `initDevice()` 里没有调用它**——`grep` 全仓 `try2connectLywyzIC` 只有定义处与 `access$008` 之类合成方法，无调用点 ⇒ **死代码路径**（`LyWyzRequestInfo` + `LyCmdWithYzIC` 整体处于「编译进包但不会被选中」状态）。

handler 表：

| 类 | `getCurrentICName()` | 心跳周期 | RTSP 基址 | 备注 |
|---|---|---|---|---|
| `LyIC` (`net/LyIC.java:190`) | `"LyIntegratedCircuit"`（TAG，`:20`） | **10000 ms**（`:225`） | `rtsp://192.168.1.254`（`:168/220`） | 唯一带 TCP:3333 |
| `QzIC` (`net/QzIC.java:174`) | `"QzIntegratedCircuit"`（TAG `:24` = `"QzIntegratedCircuit"`） | **4000 ms**（`:239`） | `rtsp://192.168.169.1`（`:165/234`） | 全 JSON |
| `LyCmdWithYzIC` (`net/LyCmdWithYzIC.java:173`) | 也返回 `"QzIntegratedCircuit"`（**复制粘贴 bug**：`TAG` 与 `getCurrentICName()` 都写成 Qz） | **4000 ms**（`:188`） | `rtsp://192.168.1.254`（`:164/183`） | 死代码 |
| 未选中时的兜底 | — | **30000 ms**（`_work/idgo_live_src/sources/com/icatch/golive/net/ConnectDeviceManager.java:205`） | `rtsp://192.168.1.254`（`:173/199`） | `ic==null` 分支 |

`sendFailureMessage` / `sendSuccessMessage` 用 `Handler.obtainMessage(404)` / `(200[, obj])`（`net/IntegratedCircuit.java:39-51`）。

### 5.3 ARP 表读取（两处）

| 位置 | 用途 |
|---|---|
| `com/icatch/golive/data/SystemInfo/HotSpot.java:26` | `new FileReader("/proc/net/arp")` — 找热点下挂设备 |
| `com/icatchtek/control/core/feature/ICatchCameraControlImpl.java:45-89` `getMatchedLineFromArpCache(String)` | SDK 侧按 IP 子串扫 `/proc/net/arp` 取 MAC 行（`getCameraMacAddress()` 的实现基础） |

### 5.4 HTTP 客户端参数

`com/icatch/golive/net/ApiCaller.java:95-137`：
- 每个请求 `new OkHttpClient()`（**无连接池复用**），若 `PanoramaApp.getContext().getWifiNetwork() != null` 则挂 `wifiNetwork.getSocketFactory()` —— 这是**把 HTTP 强制绑到 WiFi 网卡**的关键，也是 App 在多网络并存时仍能打到 192.168.1.x 的原因。
- GET/POST 无鉴权头、无 Cookie；POST 体固定为空串，`MediaType "application/json; charset=utf-8"`（`:118`）。
- 成功回调把 `response.body().string()` 原样放进 `Message.obj`，`what` = 调用方传入的 requestCode（`200` 或 `20001`，`_work/idgo_live_src/sources/com/icatch/golive/net/RequestInfo.java:5-7`）。
- 失败一律 `what = 404`（`_work/idgo_live_src/sources/com/icatch/golive/net/ApiCaller.java:100-101`）—— **404 是「本地错误码」，与 HTTP 状态无关**。
- 上传：`http://192.168.1.254/upload`，multipart，part 名 `"file"`（`ShareInternalUtility.STAGING_PARAM`），另加 `description=文件描述`；超时 `connect 30s / read 60s / write 60s`（`_work/idgo_live_src/sources/com/icatch/golive/net/ApiCaller.java:148`）。

---

## 6. RTSP（副机 / 第二镜头）

- 三个 IC 的 `getFrontCamLiveURL()` / `getBackCamLiveURL()` 只返回**裸主机**（`rtsp://192.168.1.254`、`rtsp://192.168.169.1`），路径由播放器补。
- `AppInfo.inputIp = "192.168.1.1"`（`data/AppInfo/AppInfo.java:51`）配套出现过 `rtsp://192.168.1.1` 字面量（`_work/re/idgolive/signals-fullUrls.tsv`），由 `RtspPlayerActivity` / `LYLiveVideoActivity` 消费。
- **副机必须先开流**：`?custom=1&cmd=2015&par=1`（`_work/idgo_live_src/sources/com/icatch/golive/net/RequestInfo.java:44`）；关流 `par=0`（`:45`）。`LyIC.ready2CamLive()` 的顺序是 `3001&par=1`（切录像模式）→ `2015&par=1` → `2001&par=1`（`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:333/84/99`）。
- 播放器栈：`libijkplayer.so` + `libijkffmpeg.so`（IjkPlayer）与 `libav*` / `libffmpeg.so`（FFmpegKit）双份，`com.arthenica.ffmpegkit.*` 在 `QzIC`/`LyCmdWithYzIC` 中被 import 只为取 `MediaInformation.KEY_SIZE`（="size"）与 `StreamInformation.KEY_INDEX`（="index"）两个字面量（`_work/idgo_live_src/sources/com/icatch/golive/net/QzIC.java:66/268`）。

---

## 7. 预览参数串 `H264?W=&H=&BR=&FPS=`（PTP 通道，非 HTTP）

这条串**不来自任何 Java 常量、也不来自任何 .so 的 .rodata**（实测：`grep 'H264?' _work/re/idgolive/apk-files/lib/arm64-v8a/*.so` 无命中），它是 `getSupportedStreamingInfos()` / `getCurrentStreamingInfo()`（`_work/idgo_live_src/sources/com/icatchtek/control/customer/ICatchCameraProperty.java:37/81`）从**固件**读回来的字符串，App 只解析：

| 解析器 | 行为 | 位置 |
|---|---|---|
| `DataConvert/StreamInfoConvert.convertToStreamInfoBean(String)` | `split("\\?\|&")` → `[0]`=codec 名、`[1]`去 `W=`、`[2]`去 `H=`、`[3]`去 `BR=`、`[4]`去 `FPS=`；若串中无 `FPS` 则 **fps 兜底 30** | `com/icatch/golive/DataConvert/StreamInfoConvert.java:8-34` |
| `utils/ConvertTools.resolutionConvert(String)` | 重排成 `<codec>?W=&H=&BR=`，并**按高度降帧**：`H==720` → 追加 `&FPS=15&`；`H==1080` → 追加 `&FPS=10&` | `com/icatch/golive/utils/ConvertTools.java:80-95` |
| native 输出格式串 | `mediumName=%s;codec=%d;videoW=%d;videoH=%d;bitrate=%d;durationUs=%d;maxInputSize=%d;fps=%d` | `libcontrol.so` .rodata（第 2617 条） |

## 8. 白牌机（LyIC）设置项的 index ↔ 文案对照表

这些是 `cmd=NNNN&par=K` 里 `K` 的**权威取值表**，全部从源码数组字面量抄出。

### 8.1 录像分辨率：`cmd=2002&par=<index>`，能力查询 `cmd=3030`

| 文案（用户可见） | 固件 index | `cmd=2002&par=` |
|---|---|---|
| `2160p@30fps` | `1` | `par=1` |
| `1440p@30fps` | `6` | `par=6` |
| `1080p@60fps` | `10` | `par=10` |
| `1080p@30fps` | `11` | `par=11` |
| `720p@60fps` | `14` | `par=14` |
| `720p@30fps` | `15` | `par=15` |

两处独立但完全一致的表：
`com/icatch/golive/net/LyIC.java:41-42`（`handleList3030`，用于按 `cmd=3030` 返回的 Index 集合过滤出可选项）与
`com/icatch/golive/ui/activity/LdeviceSettingActivity.java:59-60`（`video_definition_arr` / `video_definition_index_arr`，UI 列表源）。
注意 `handleList3030` 里 `list.contains(str)` 为假时会 `IndexOutOfBounds`（`_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:49` 用 `list.indexOf(str)` 直接索引 `arrayList`），是已知脆弱点。

### 8.2 拍照尺寸：`cmd=1002&par=<K>`

| 文案 | par | 常量 |
|---|---|---|
| `12M` | **0** | `RequestInfo.urPhtotCaptureSize12M:10`；`LdeviceSettingActivity:65` `photo_definition_arr={"12M","10M","8M","5M"}` |
| `10M` | **1** | `:9` |
| `8M` | **2** | `:12` |
| `5M` | **3** | `:11` |
⇒ `par` 与「像素数」反相关，且 `photo_definition_arr` 的下标顺序 **不等于** par 顺序（数组是 12/10/8/5，par 是 0/1/2/3 恰好同序，但 SDK 的 `ICatchCamImageSize` 用的是另一套 Mpx 序号 2/3/5/6/8/10）。三套序号不要混用。

### 8.3 循环录像时长：`cmd=2003&par=<index>`

| 文案 | index |
|---|---|
| `OFF` | `0` |
| `1 MIN` | `1` |
| `3 MIN` | `2` |
| `5 MIN` | `3` |
来源 `_work/idgo_live_src/sources/com/icatch/golive/ui/activity/LdeviceSettingActivity.java:66-67`（`duration_index_arr` / `duration_arr`）；能力回包解析在 `LdeviceSettingActivity.handleMap2003()`（声明 `:507`，调用点 `:444`；键名取自字段 `cmd2003status`，`:69`），把 `XmlParseUtil` 返回的 `Cmd2003` map 的 keySet/values 直接当作 index/文案数组**覆盖**硬编码表（`:513-517`）⇒ 固件可用 `cmd=3031` 重定义档位。

### 8.4 其它 `par` 值一览（同一台 `.254`）

| cmd | par=0 | par=1 | par=2 | par=3 | par=4 | par=10 |
|---|---|---|---|---|---|---|
| 2001 | 停止录像 | 开始录像 | — | — | — | — |
| 2011 | G-Sensor Off | Low | Med | High | Max | — |
| 2015 | 关闭 RTSP 副流 | 打开 RTSP 副流 | — | — | — | — |
| 3001 | 拍照模式 | 录像模式 | 回放模式 | — | — | — |
| 3044 | 镜头旋转 Off | On | — | — | — | — |
| 8010 | 机身麦 | 耳机麦 | — | — | — | — |
| 8011 | 关录音 | 开录音 | — | — | — | — |
| 3010 | — | **确认格式化** | — | — | — | — |
| 1002 | 12M | 10M | 8M | 5M | — | — |
| 1008（`/api/`） | 相机语言 中 | 英 | — | — | — | — |
| 3033（`/api/`） | — | 模式切换其它 | — | — | — | — |
| 4016（`/api/`） | — | 启动心跳 | — | — | — | — |
| 3001（`LyCmdWithYzIC` 批处理） | — | — | — | — | — | `cmd=2001,8010,3001&str=0,0,10` ⇒ 停录 + 机身麦 + 切录像模式 |

### 8.5 「响应标签名可被固件改写」机制（易错点）

`_work/idgo_live_src/sources/com/icatch/golive/ui/activity/LdeviceSettingActivity.java:68-75` 声明了 8 个**可变字段**（不是常量）：
`cmd2002status="2002"`、`cmd2003status="2003"`、`cmd2008status="2008"`、`cmd2011status="2011"`、
`cmd3044status="3044"`、`cmd8010status="8010"`、`cmd8011status="8011"`、`cmd8012status="8012"`。

用法（`:367-370`）：先用这 8 个字符串当**要抓取的 XML 标签名列表**去解 `cmd=3014` 的回包
（`XmlParseUtil.parseXMLToStringWithPull(body, Arrays.asList(cmd2002status, …, cmd3044status))`），
然后 **把字段的值改写成读回来的东西**：`cmd2002status = map.get(cmd2002status)`。
⇒ 这些字段初值是「标签名」，一次读回后变成「该设置的当前值」，被后续 UI 直接当值用（`:248` 也有同样覆写）。
复现时**不要**把 `cmdNNNNstatus` 理解成常量键名，否则会读到 null。

对比：`QzIC`/`LyCmdWithYzIC` 侧没有这套机制，参数键名是固定的 `param` 串
（`rec`、`rec_resolution`、`switchcam`、`encodec`）。


---

⇒ **§7 结论**：预览是 **PTP 私有数据通道拉 H.264/MJPEG 裸流**（`ptp_ptpip_getdata` / `openFileTransChannel` / `getThumbnail` / `getQuickview`），帧回调 `getNextVideoFrame(ICatchFrameBuffer)`，由 `MediaCodec` 解（`Function/streaming/H264DecoderThread.java`）。RTSP 只在副机路径出现。

---

<!-- 以下整段合并自原 03-idGoLive-档案-附录-原生层与PTPIP.md（2026-09-22 文档归并，内容未改） -->
# 附录 C · idGoLive 原生层：63 个 .so、JNI 全表、PTP-IP 线上格式

> 返回 主档案（本文附录）。
> 证据：`_work/re/idgolive/natives.md`（库清点）、`natives-symbols.tsv`（55052 条符号）、`natives-jni.md`（343 条 `Java_*`）、`natives-strings.tsv`（4879 条兴趣串），以及我本人对 `_work/re/idgolive/apk-files/lib/arm64-v8a/libcontrol.so` 的二次全量 strings/ELF 提取。

---

## 1. 63 个 .so 逐个说明

按 ABI 分组：**arm64-v8a 20 + armeabi-v7a 20 + x86 13 + x86_64 10 = 63**。

### 1.1 关键结构性结论（新）
**x86 与 x86_64 里完全没有 `libcontrol.so` / `libreliant.so` / `libusb_transport.so` / `libpanorama_vr.so` / `libPhoenix_libCodec.so` / `libffmpeg.so`。**
x86 只有 FFmpeg 家族 + ijkplayer + ffmpegkit + c++_shared；x86_64 更少（连 ijk 都没有，只 av* + ffmpegkit + c++_shared）。
⇒ 相机主通道（PTP/PTP-IP）与全景渲染**只在 ARM 设备可用**；x86/x86_64（模拟器、部分平板）装上后必然连不上 PTP 机，只能走 HTTP/RTSP 副通道。

### 1.2 arm64-v8a（20 个，armeabi-v7a 一一对应，x86 为子集）

| 库 | 大小(B) | DT_NEEDED | 导出 | JNI 导出 | 用途 |
|---|---|---|---|---|---|
| `libcontrol.so` | 919,176 | libusb_transport, liblog, libz, libreliant, libc++_shared, libm, libdl, libc | 2081 | **160** | **相机 SDK 核心**：PTP 协议栈 + PTP-IP 传输 + socketIO + 组播 simpleconfig + AES + 固件升级 + 事件队列 + SDK 日志（plog）。这是复现工作的第一优先库 |
| `libreliant.so` | 337,880 | libusb_transport, libdepth_net_transport, libc++_shared, libm, libdl, libc | 957 | 0 | 传输/会话底座（reliant = 可靠性层）：session 管理、socket 封装、USB 传输胶水。字符串里只有 `127.0.0.1` + `sscanf` ⇒ 无协议明文可挖，纯实现 |
| `libusb_transport.so` | 830,768 | liblog, libandroid, libOpenSLES, libc++_shared, libm, libdl, libc | 1797 | 31 | USB 主机栈（自带 libusb，字符串含 `http://libusb.info`）：bulk/iso/SCSI 三种传输 + OpenSL 音频回调 |
| `libpanorama_vr.so` | 16,016,864 | libusb_transport, libdepth_net_transport, libz, libm, libdl, liblog, libandroid, libGLESv2, libEGL, libreliant, libc++_shared, libc | 17435 | **105** | 全景（双镜头拼接）渲染 + GL + 推流（RTMP/YouTube 字符串在此库）；含 `https://www.googleapis.com/youtube/v3/liveStreams?...`、`https://www.youtube.com/channel/`、`https://www.youtube.com/watch?v=` |
| `libdepth_net_transport.so` | 125,952 | liblog, libandroid, libOpenSLES, libc++_shared, libm, libdl, libc | 281 | 5 | 深度网络传输通道（depth_net = 双目对齐数据流？），`JDepthNetTransportLogger` 为唯一 Java 入口 |
| `libPhoenix_libCodec.so` | 1,047,416 | libffmpeg, libm, libc, libdl | 1348 | 6 | 自研「Phoenix」AV 解复用/解码封装，JNI 挂在 `com.icatchtek.baseutil.mediacodec.PhoenixAVDemuxer`（nativeInit/nativeNewAVDemuxer/nativeDeleteAVDemuxer/nativeGetNextFrame/nativeUnInit/nativeGetStreamInfo）；内含 aac 码表（`aacDataTable`） |
| `libffmpeg.so` | 15,826,848 | libc, libm, libz, libdl, liblog | 6043 | 0 | FFmpegKit 的**全功能合并库**（avcodec+avformat+avutil+…一体） |
| `libavcodec.so` | 12,633,600 | liblog, libandroid, libcamera2ndk, libmediandk, libz, libc++_shared, libswresample, libavutil | 159 | 0 | 独立 FFmpeg 分发（供 ijk/panorama 用） |
| `libavformat.so` | 4,885,952 | 同上 + libavcodec | 155 | 0 | 含 dash/hls/ttml 字符串（`http://dashif.org/guidelines/last-segment-number`、`http://www.w3.org/ns/ttml`）⇒ **通用播放能力，与相机无关** |
| `libavfilter.so` | 4,579,576 | libswscale, libavformat, libavcodec, libswresample | 64 | 0 | 滤镜 |
| `libavutil.so` | 453,928 | — | 589 | 0 | 工具 |
| `libswresample.so` | 196,312 | libavutil | 25 | 0 | 音频重采样 |
| `libswscale.so` | 274,512 | libavutil | 32 | 0 | 图像缩放 |
| `libavdevice.so` | 51,120 | libavfilter, libavformat, libavcodec | 15 | 0 | 设备（几乎不用） |
| `libijkffmpeg.so` | 6,592,360 | libm, libz, libdl, libc | 8937 | 0 | IjkPlayer 内嵌的第二份 FFmpeg（与 libffmpeg.so **重复打包**，APK 体积主因） |
| `libijkplayer.so` | 545,832 | libijkffmpeg, libijksdl, liblog, libandroid | 826 | 0 | RTSP/RTMP 播放器（副机预览用） |
| `libijksdl.so` | 362,832 | libijkffmpeg, libOpenSLES, libEGL, libGLESv2 | 886 | 0 | SDL 抽象 |
| `libffmpegkit.so` | 470,704 | libavfilter, libavformat, libavcodec, libavutil, libswresample, libavdevice, libswscale, libc++_shared, liblog, libz, libandroid | 401 | **14** | FFmpegKit Java 桥（`com.arthenica.ffmpegkit.FFmpegKitConfig` 的 14 个 native 方法 + `AbiDetect` 4 个） |
| `libffmpegkit_abidetect.so` | 30,496 | liblog, libz, libandroid | 37 | 4 | ABI 探测 |
| `libc++_shared.so` | 6,835,688 | libc, libdl | 2239 | 0 | NDK C++ 运行库（clang 8.0.2，NDK r339409 系） |

### 1.3 armeabi-v7a 差异（20 个）
同名，但 FFmpeg 系列带 `_neon` 后缀：`libavcodec_neon.so`、`libavdevice_neon.so`、`libavfilter_neon.so`、`libavformat_neon.so`、`libavutil_neon.so`、`libswresample_neon.so`、`libswscale_neon.so`、`libffmpegkit_armv7a_neon.so`。
`libcontrol.so` 845,428 B、`libreliant.so` 302,808 B、`libusb_transport.so` 781,496 B、`libpanorama_vr.so` 16,322,384 B。
32 位库在 `natives-symbols.tsv` 中 **0 条符号**（未解析，非「无导出」），strings 仍可用（`lib/armeabi-v7a/libcontrol.so` 3836 条兴趣串 vs arm64 3948 条）。

### 1.4 x86（13）/ x86_64（10）
x86：avcodec/avdevice/avfilter/avformat/avutil/c++_shared/ffmpegkit/ffmpegkit_abidetect/ijkffmpeg/ijkplayer/ijksdl/swresample/swscale。
x86_64：avcodec/avdevice/avfilter/avformat/avutil/c++_shared/ffmpegkit/ffmpegkit_abidetect/swresample/swscale（**无 ijk、无 ffmpeg.so**）。

### 1.5 不存在的东西（重要）
包内 **没有** `libopus.so`、`libMNN.so`、`libwebrtc*`、`libx264*`、任何 `.a` 或 `libtt2`。
AI 相关只有 Java 层的 `com/tinyai/libmediacomponent/**`（Baidu tinyAI 的 Java 封装），其 native 依赖指向外部主机 `http://usa.boi.tinyai.top:3006` / `https://api.bpsc.tinyai.top:3026`（见附录 D），**没有配套 .so** ⇒ 该模块在本 App 内基本不可用（详见附录 D 判定）。
音频编码走 `libPhoenix_libCodec.so`（AAC 码表）+ FFmpeg，不是 opus。

---

## 2. `Java_*` → Java 声明 → 调用点

343 条 `Java_*` 导出（`natives-jni.md`）。按库：`libcontrol` 160、`libpanorama_vr` 105、reliant 系（`libreliant`+`libusb_transport`+`libdepth_net_transport`）28、`libPhoenix_libCodec` 6、`libffmpegkit` 14(+4 abidetect)、`libaums`(USB  Mass Storage Java 库) 8。

### 2.1 libcontrol.so 的 160 条，按 Java 类聚合（全量方法名）

| JNI 类（`com.icatchtek.control.core.jni.*`） | 条数 | 方法名（原样） | Java 侧包装 | 上层调用者 |
|---|---|---|---|---|
| `JCameraSession` | 5 | `createJniSession` `deleteJniSession` `prepareSessionNET` `prepareSessionUVC` `checkConnection` `destroySession` | `_work/idgo_live_src/sources/com/icatchtek/control/core/jni/JCameraSession.java:14-86`（`prepareSession_Jni` 两个重载） | `ICatchCameraSession.prepareSession()` `customer/ICatchCameraSession.java:89-117`；NET 分支实参：`prepareSession_Jni(sessionID, ip, "", "")` ⇒ **两个字符串参数恒为空串**，native 里是 user/passwd 或 localIp 占位 |
| `JCameraConfig` | 8 | `enablePTPIP` `disablePTPIP` `enableSocketIO` `disableSocketIO` `enablePtpReconnection` `setConnectionCheckParam` `setConnectionCheckParamA` `getPtpTimeoutCheckCount` `getPtpTimeoutCheckIntervalInSecs` | `core/feature/ICatchCameraConfigImpl.java:44-86` | `MyCamera/CommandSession.java:104/111`（`enablePTPIP`/`disablePTPIP`，由 `connect(boolean enablePTPIP)` 决定）、`:120`（`setConnectionCheckParam(times, interval, 0)`） |
| `JCameraProperty` | 58 | `checkCameraCapabilities` `getCurrent{BurstNumber,CaptureDelay,DateStamp,ImageSize,LightFrequency,Seamless,SlowMotion,StreamingInfo,TimeLapseDuration,TimeLapseInterval,UpsideDown,VideoSize,WhiteBalance,ZoomRatio}` `getCurrentPropertyValue{ByteArray,Numeric1,Numeric2,String1,String2}` `getMaxZoomRatio` `getNumberOfSensors` `getPreviewCacheTime` `getProperty` `getSupported{BurstNumbers,CaptureDelays,DateStamps,ImageSizes,LightFrequencies,Properties,PropertyValuesNumeric1,Numeric2,String1,String2,Seamlesses,StreamingInfos,TimeLapseDurations,TimeLapseIntervals,VideoSizes,WhiteBalances}` `set{BurstNumber,CaptureDelay,DateStamp,ImageSize,LightFrequency,Seamless,SlowMotion,StreamingInfo,TimeLapseDuration,TimeLapseInterval,UpsideDown,VideoSize,WhiteBalance}` `setProperty` `PropertyValue{ByteArray,Numeric1,Numeric2,String1,String2}` | `JCameraProperty.java`（每个 native 都有 `_Jni` 包装 + 4 类异常转译 + 兜底 -1/null/false） | `core/feature/ICatchCameraPropertyImpl.java:24-326` → 接口 `customer/ICatchCameraProperty.java` → App 层 `SdkApi/CameraProperties.java`（2118 行） |
| `JCameraControl` | 37 | `capturePhotoA` `capturePhotoB` `triggerCapturePhoto` `startMovieRecord` `stopMovieRecord1` `stopMovieRecord2` `startTimeLapse` `stopTimeLapse` `changePreviewMode` `getCurrentCameraMode` `getSupportedModes` `getCurrentBatteryLevel` `getFreeSpaceInImages` `getRemainRecordingTime` `getVideoRecordStatus` `isSDCardExist` `formatStorage1` `formatStorage2` `setAudioMute` `setAudioUnMute` `setEventTrigger` `setFileProtection` `setSeamless` `setVideoStreamInterface` `supportedVideoPlayback` `toStandbyMode` `zoomIn` `zoomOut` `addCustomEventListener` `removeCustomEventListener` `addEventListener` `removeEventListener` `extensionUnitGet` `extensionUnitGetLength` `extensionUnitSet` `setExtensionUnitID` `pan` `panReset` | `core/feature/ICatchCameraControlImpl.java` | `SdkApi/CameraAction.java`（406 行）、`Function/CameraAction/*` |
| `JCameraPlayback` | 16 | `listFiles1` `listFiles2` `listFiles3` `downloadFile` `downloadFile1` `downloadFileQuick` `downloadImage` `getFileCount` `getQuickView` `getThumbnail` `deleteFile` `openFileTransChannel` `closeFileTransChannel` `cancelFileDownload` `setFileListAttribute` `uploadFile` `uploadFileQuick` | `core/feature/ICatchCameraPlaybackImpl.java` | `SdkApi/FileOperation.java`（352 行）、`Function/CameraAction/PbDownloadManager.java` |
| `JCameraState` | 6 | `isCameraBusy` `isMoviePlaying` `isMovieRecording` `isStreaming` `isTimeLapseStillOn` `isTimeLapseVideoOn` `supportImageAutoDownload` | `core/feature/ICatchCameraStateImpl.java` | `SdkApi/CameraState.java` |
| `JCameraInfo` | 2(3) | `getCameraFWVersion` `getCameraProductName` `getSDKVersion` | `core/feature/ICatchCameraInfoImpl.java` | `SdkApi/CameraFixedInfo.java` |
| `JCameraAssist` | 11 | `addEventListener` `removeEventListener` `deviceInit` `notifyUpdateFw` `simpleConfig` `simpleConfigCancel` `simpleConfigGet` `startDeviceScan` `stopDeviceScan` `supportLocalPlay` `updateFw` `wakeUpCamera` | `customer/ICatchCameraAssist.java` + `core/feature/ICatchCameraAssistImpl.java` | 见 §2.2 |
| `JCameraLog` | 6 | `setDebugMode` `setFileLogOutput` `setFileLogPath` `setLog` `setLogLevel` `setSystemLogOutput` `writeLog` | `core/feature/*` | `com/icatch/golive/Log/*`，日志文件名模板见 §3.4 |
| `JCameraUtil` | 1(2) | `convertImageSize` `convertVideoSize` | `core/jni/JCameraUtil.java` | 尺寸串 → `ICatchCamFrameSize` |

### 2.2 `JCameraAssist` 六个值得单独记的能力（含实参数值）

| 能力 | Java 实参 | 数值 |
|---|---|---|
| **配网 `simpleConfig`** | `_work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraAssistImpl.java:222-223` 3 参重载委托：`(ctx, str, str2, str3, str4)` → 同参 + **timeout = 180**（秒） | `:227-228` 再委托到带 key 版本，key = 字段 `__default_key` |
| 默认 AES-128 密钥 | `_work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraAssistImpl.java:17` `byte[] __default_key = {33,126,Ascii.SUB,Ascii.SYN,40,-34,-46,-89,-85,-25,-123,-120,9,-54,SignedBytes.MAX_POWER_OF_TWO,60}` | **`21 7E 1A 16 28 DE CE A9 AB E7 85 88 09 CA 80 3C`**（16 字节） |
| 组播接收等待 | 内部类 `MulticastReceiver.run()`：`while (run && now-start < timeout*1000) { receive(); sleep(50ms) }` | 轮询间隔 **50 ms**，总时长 = `timeout*1000`（默认 180 s） `:64-77` |
| `deviceInit(String)` | `:196` `deviceInit_Jni(transportType, str, vid, pid, fd, str)` — 同一 str 传两次 | — |
| `updateFw` | `:348` `updateFw_Jni(transportType, ipAddr, vid, pid, fd, sessionID, path)` | 固件文件路径（App 侧文件名固定 `SPHOST.BRN`，`data/AppInfo/AppInfo.java:23`） |
| `wakeUpCamera(String)` | `:353` | 唤醒包 |
| `startDeviceScan` | `:338`（native 有实现），但 App 层 `MyCamera/CommandSession.java:34-38` 的 `startDeviceScan()` **直接 `return false` 且只打日志** ⇒ App 主动关闭了 SDK 的扫描 | — |

### 2.3 transportType 常量（跨 4 个类重复定义，一致）
`TRANSPORT_TYPE_NET_COMMON = 1`、`TRANSPORT_TYPE_UVC_ISO = 2`、`TRANSPORT_TYPE_UVC_BULK = 3`、`TRANSPORT_TYPE_MSDC_SCSI = 4`
（`_work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraConfigImpl.java:13-16`；`_work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraAssistImpl.java:7-10`）。
每个 JNI 调用都把 `(transportType, ipAddr, vendorID, productID, fileDescriptor)` 五元组当「伪多态」传下去。USB 系 transport 下 ipAddr = null、vid/pid/fd = 实值或 -1。

### 2.4 `libreliant` 侧 28 条
`JUsbTransportCore` / `JUsbTransportBulk` / `JUsbTransportMsdc` / `JUsbTransportLogger` / `JDepthNetTransportLogger`。
Java 入口：`com/icatchtek/reliant/core/jni/*.java`，`_work/idgo_live_src/sources/com/icatchtek/reliant/customer/transport/ICatchUsbScsiTransport.java:34-64` 暴露 `executeScsiCommand`（`USB_TRANSPORT_ERROR_TRY_AGAIN = -200` 时抛 `IchTryAgainException("Wait resource timeout, please try again.")`）、`getCurrentMode`、`switchToPlayback`、`switchToPreview`；`_work/idgo_live_src/sources/com/icatchtek/reliant/customer/transport/ICatchUVCBulkTransport.java:26-28` → `JUsbTransportCore.initUvc_Jni()`；`_work/idgo_live_src/sources/com/icatchtek/reliant/customer/transport/ICatchUVCIsoTransport.java:54` → `initUvc_Jni(vid, pid, "", fd)`。
`com.github.mjdev.libaums` 的 8 条（`UsbMassStorageDevice` 相关 + `ErrNo`）说明 **U 盘式（MSC）直读 SD 卡**也是一条独立路径。

---

## 3. PTP-IP 线上格式（libcontrol.so）

### 3.1 符号 ↔ 阶段 对应

| 符号（`natives-symbols.tsv`，lib=arm64-v8a/libcontrol.so，direction=export） | 阶段 | 由 `.rodata` 日志串定位的实现点 |
|---|---|---|
| `ptp_ptpip_connect` | TCP 建链 | `ptp conn %s`、`ptp client connecting`、`ptp client connect success`、`socket init error`、`socket failed, %d` |
| `ptp_ptpip_sendreq` | 发 Request/Command container | `ptp_ptpip_sendreq() len =%d but ret=%d` |
| `ptp_ptpip_getresp` | 收 Response container | `ptp_transaction code: ret=%d` |
| `ptp_ptpip_getdata` | 收 Data phase | `ptpip/getdata` |
| `ptp_ptpip_senddata` | 发 Data phase（上传/发送对象） | `ptp_ptpip_senddata() len=%d but ret=%d` |
| `ptp_ptpip_event_wait` | 事件阻塞等待 | `ptp_wait_event`、`ptpevtrecv`、`ptpevtrecvthread`、`ptp2/wait_for_event`、`socket evt error` |
| `ptp_ptpip_event_check` | 非阻塞探测事件 | `ptp_check_event`、`ptp_get_one_event`、`ptp_add_event`、`ptp_event_issupported` |
| `ptp_ptpip_close` | 断链 | `ptp disconnected, check result: %s.`、`ptpReconnect` |
| `icatch_get_dev_prop_value` / `icatch_set_dev_prop_value` / `icatch_get_dev_prop_desc` | 属性读写（厂商封装） | `icatch_get_dev_prop_value error`、`icatch_get_dev_prop_desc error: %04x`、`icatch_set_dev_prop_desc error: %d` |
| `ptp_getdevicepropvalue` / `ptp_setdevicepropvalue` / `ptp_getdevicepropdesc` / `ptp_getdeviceallpropdescs` | 标准 PTP 属性 | `ptpClient get properties OK` |
| `ptp_getobject` / `ptp_getobject_to_fd` / `ptp_getobject_to_handler` / `ptp_getpartialobject` / `ptp_getthumb` / `ptp_mtp_getobjectquickview` | 数据下载 | `ptp_getobject_to_handler %d`、`ptpip download file(handle) %s`、`ptp_init_camerafile_handler %d`、`ptp_init_camerafile_handler size: %d` |
| `ptp_getobjecthandles` / `ptp_getobjectproplist*` / `ptp_mtp_getobjectpropdesc` / `ptp_mtp_getobjectpropssupported` / `ptp_mtp_setobjectpropvalue` / `ptp_mtp_sendobjectproplist` / `ptp_mtp_setobjectproplist` / `ptp_mtp_getobjectreferences` / `ptp_mtp_setobjectreferences` | MTP 扩展对象属性 | `ptp2/mtpfast: reading mtp proplist of %08x` |
| `ptp_opensession` / `ptp_generic_no_data` / `ptp_deleteobject` / `ptp_formatstore` / `ptp_getstorageids` / `ptp_getstorageinfo` / `ptp_getnumobjects` / `ptp_getobjectinfo` / `ptp_sendobjectinfo` / `ptp_getfilesystemmanifest` | 会话/存储/删除/格式化 | `ptp_opensession returns %x`、`ptp_formatstore ret = 0x%x`、`ptp_getstorageinfo ret = 0x%x` |
| `ptp_chdk_call` / `ptp_chdk_exec_lua` / `ptp_chdk_get_memory` / `ptp_chdk_get_paramdata` / `ptp_chdk_get_propcase` / `ptp_chdk_get_script_output` / `ptp_chdk_get_video_settings` | **Canon CHDK 通道（本机型不用，来自 libptp2 上游）** | `ptp2/libptp2/library.c`、`ptp2-camera`、`ptp2/camera_init` |
| `ptp_icatch_set_customer_operation` | 厂商自定义 op 下发 | — |
| `ptp_nikon_getptpipguid` | libptp2 上游的 Nikon PTP/IP GUID 查询；iCatch 固件不实现 | `ptp_nikon_getptpipguid` |

代码来源指纹：`.rodata` 里有 `ptp.c`、`ptp2/libptp2/library.c`、`ptp2-camera`、`ptp-camera`、`ptp-debug`（以 `%s` 形式出现的 `ptp_debug`/`ptp_error` 分类日志），⇒ **libcontrol 的 PTP 栈 = libptp（libmtp 内联版）+ libptp2（gphoto2 内联版）双份混编**，再加 iCatch 自己的 `icatch_*` / `ptp_icatch_*` 封装层。复现时**不必**照抄 CHDK/Nikon 分支。

### 3.2 PTP/IP 的三次握手（native 日志字面量给出的阶段名）

`.rodata` 中存在成组标签（同一 printf 前缀风格）：
```
ptpip/connect    ptpip/init_cmd    ptpip/init_cmd_ack
ptpip/init_event ptpip/oprequest   ptpip/senddata
ptpip/getdata    ptpip/event       ptpip/generic_read
ptpip:%s         ptpip:%s          ptpip connected!
```
这 9 个标签正是 PTP-over-IP（IETF `draft-preston-ptp`）的 **operation type**：
`INIT_CMD(1)` → `INIT_CMD_ACK(2)` → 之后每条包外层再套 4 字节 `operation type`：
`OP_REQUEST(5)` / `RESPONSE(3)` / `EVENT(4)` / `INIT_EVENT(6)` 与 `START/LAST PARTIAL_SEND_*` 数据分片类型。

⇒ **PTP/IP 帧 = `[2B operation type (BE)] + [PTP container (LE)]`**，
其中 command 走 **TCP 端口 A（命令通道）**、response+data 走 **另一条 TCP（数据通道）**、event 走 **第三条 TCP（事件通道）**；
`socket cmd error` / `socket evt error` / `socketIO_Enable` 说明 cmd 与 evt 是两个独立 socket 状态机，`enableSocketIO` 是第三种模式。

### 3.3 PTP container 头（14 字节，小端）

| 偏移 | 长度 | 字段 | 证据 |
|---|---|---|---|
| 0 | 4 | `Length`（含头） | `ptp_ptpip_sendreq() len =%d but ret=%d` 的长度校验语义 |
| 4 | 2 | `Type`（`0x0001`=Request/Command，`0x0002`=Response，`0x0003`=Event，`0x0004`=Data） | 标准 PTP 1.1 定义；native 有 `ptp_opc_trans` / `ptp_opcode_trans` / `ptp_ofc_trans` / `ptp_opc_trans` 四张转换表 |
| 6 | 2 | `Code`（opcode / response code） | `ptp_transaction: code=%x, transaction_id=%x, get/set: %x, p1: %x, p2: %x, p3: %x.` |
| 8 | 4 | `TransactionID` | 同上 |
| 12 | 4×4 | `Parameter1..4`（每个 u32；`0xFFFFFFFF` 表示未用） | 同上（日志只打到 p3） |

**注意上面那条日志串里没有 p4** —— iCatch 的 debug 打印只到 `p3`，但 `ptp_free_params` 存在，说明内存里仍有 4 个参数槽。Data container 另多 4 字节 `ObjectHandle`（`ptp_getobject_to_handler` 语义）。

### 3.4 操作码 / 枚举值全表

native 里的名字（`ptp_render_opcode`、`ptp_render_ofc`、`ptp_opcode_trans`、`ptp_opc_trans`、`ptp_render_mtp_propname`、`ptp_render_property_value`、`ptp_render_deviceprops` 缺失）说明**码→名映射以查表实现，表体在 `.rodata`，但被提取器的「兴趣字符串」过滤器按长度/前缀筛掉了**（我在全量 strings 里未找到 `"GetDeviceInfo"` 这类字面量）。因此下表**值来自 PTP/MTP 规范**，`确认方式` 列写明该码是否有本仓库内的直接符号/调用证据。

#### 命令码（PTP 1.1 标准段 0x1000-0x10FF + MTP 扩展 0x1000-0x11FF + 厂商段 0x9xxx/0x200x）

| 码 | 名称 | 本 App 是否用到 | 确认方式 |
|---|---|---|---|
| `0x1001` | GetDeviceInfo | 是 | 符号 `ptp_getdeviceinfo`；`SDK_VERSION="V3.6.0.39"` 走 info 读 |
| `0x1002` | OpenSession | 是 | `ptp_opensession` + 日志 `ptp_opensession returns %x` |
| `0x1003` | CloseSession | 是 | `ptp_ptpip_close` 路径 |
| `0x1004` | GetStorageIDs | 是 | `ptp_getstorageids` |
| `0x1005` | GetStorageInfo | 是 | `ptp_getstorageinfo` + `ret = 0x%x` |
| `0x1006` | GetObjectInfo | 是 | `ptp_getobjectinfo` |
| `0x1007` | GetObject | 是（主下载） | `ptp_getobject` / `ptp_getobject_to_handler` / `ptp_getobject_tofd` |
| `0x1008` | GetPartialObject | 是（断点续传/缩略图） | `ptp_getpartialobject`；Java 侧 `downloadFileQuick`/`getQuickView` |
| `0x1009` | GetThumb | 是 | `ptp_getthumb`；Java `getThumbnail` |
| `0x100A` | GetObjectHandles | 是（回放列表） | `ptp_getobjecthandles` |
| `0x100B` | GetNumObjects | 是 | `ptp_getnumobjects` |
| `0x100C` | DeleteObject | 是 | `ptp_deleteobject`；Java `deleteFile` |
| `0x100D` | GetObjectPropList | 是 | `ptp_getobjectproplist` |
| `0x100F` | GetPropDesc | 是 | `ptp_getdevicepropdesc` / `icatch_get_dev_prop_desc` |
| `0x1010` | GetPropValue | 是（所有设置项读） | `ptp_getdevicepropvalue` / `icatch_get_dev_prop_value`；日志 `ptpClient get properties OK` |
| `0x1011` | SetPropValue | 是（所有设置项写） | `ptp_setdevicepropvalue` / `icatch_set_dev_prop_value` |
| `0x1012` | GetPropertySet | 是 | `ptp_getdeviceallpropdescs` |
| `0x1014` | SendObjectInfo | 是（上传固件/文件） | `ptp_sendobjectinfo` |
| `0x1015` | SendObject | 是 | `ptp_sendobject` / `ptp_sendobject_fromfd` / `ptp_sendobject_from_handler` |
| `0x1016` | FormatStore | 是（格式化） | `ptp_formatstore ret = 0x%x`；Java `formatStorage1/2` |
| `0x1017` | ResetDevice | 是 | 属性 `0xD7B1` + `toStandbyMode` |
| `0x101B` | TerminateSession | 是 | `ptp_ptpip_close` |
| `0x2001-0x2007` | MTP 事件类（未用） | 否 | 无符号 |
| `0x9xxx`（如 `0x9101` GetPartialObject 变体） | 未确认 | ? | `ptp_icatch_set_customer_operation` 存在 ⇒ **iCatch 有自定义 op**，具体码值静态不可得（见 §3.6） |

#### 对象格式码 OFC（native 有 `ptp_render_ofc`、`ptp_ofc_trans`、`ptp_ofc_mtp_trans`）
SDK Java 侧把常用集合硬编码在 `_work/idgo_live_src/sources/com/icatchtek/control/customer/type/ICatchCamListFileFilter.java:7-12`：
`0x3000=UNDEFINED`（隐含）、`17(0x11)=VIDEO`、`18(0x12)=IMAGE`、`19(0x13)=MEDIA`、`33(0x21)=EMERGENCY_VIDEO`、`34(0x22)=EMERGENCY_IMAGE`、`35(0x23)=EMERGENCY_MEDIA`、`255(0xFF)=ALL_MEDIA`、`3=COMPOSITE_FILE`。
注意这里 **17/18/19/33/34/35 不是标准 PTP OFC 值**（标准是 `0x3000` 系列），它们是 iCatch 在**私有通道上的过滤枚举**；`ptp_render_ofc` 里查的仍是标准 0x30xx 表。两套值不能混用 —— 复现时以真机 `GetObjectHandles(0xFFFFFFFF, StorageID, 0x300A/0x300B)` 的实际返回为准。

#### 响应码
`ptp_strerror` / `ptp_perror` 存在 ⇒ 有码→文表；`ptp_transaction code: ret=%d` 与 `icatch_get_dev_prop_desc error: %04x`（**%04x 说明错误码是 16 位 PTP RC**）。常用值：`0x2001 OK`、`0x2002 GeneralError`、`0x2003 SessionNotOpen`、`0x2005 InvalidTransactionID`、`0x2006 ObjectTypeNotSupported`、`0x2007 HandleNotValid`、`0x2008 DatasetNotAvailable`、`0x2009 SpecificationOfGroupNotSupported`、`0x200A UnknownGroupID`、`0x200B NotSupported`。
**未在本仓库确认**（无字符串表可读）——只能靠抓包。

### 3.5 端口：静态无解，方法与结论如下（重要）

**结论：Java 层不存在任何 PTP/IP 端口常量；`libcontrol.so` 的 `.rodata` 里也不存在端口字符串。**

已穷尽的验证：
1. Java：`_work/idgo_live_src/sources/com/icatchtek/reliant/customer/transport/ICatchINETTransport.java:8-59` 只带 `ipAddress` / `localIpAddress` 两个字段，`toString()`/`fromString()` 也只序列化这两个键（JSON 键名 `"ipAddress"`、`"localIpAddress"`）；`JCameraSession.prepareSessionNET(int,String,String,String)` 的第二参就是裸 IP，**没有端口形参**。全仓 `grep "3195|3196|15740|3333"` 在厂商包内只命中 `_work/idgo_live_src/sources/com/icatch/golive/net/LyIC.java:289` 的 3333（XML 通道）与 `_work/idgo_live_src/sources/com/icatch/golive/Function/live/google/Credentials.java:10` 的 `http://localhost:8080`（Google OAuth 回调，与相机无关）。
2. `.rodata`：`libcontrol.so`（arm64）全量 strings 提取共 3948 条，`ip` 类只有 `127.0.0.1` 与 `234.168.168.168`；`ptpip:%s` 是把端口/地址**当参数打出来**，不是常量。
3. 指令级：对 `libcontrol.so` 的 `.text`（ELF section offset `0x48b20`，size `0x70b74`）扫描所有 `MOVZ Wd,#imm16`（掩码 `0xFFE0001F == 0x52800000`），得 203 条、**30 个不同立即数，且没有一个落在 `0x5000..0xFFFF`**，也没有 `15740/3192/3195/3196/3333/80`（除 6 个 `80` 与 1 个 `1000`，语义上分别是宏/计时值而非端口）。⇒ 端口与属性 ID 一样，是通过 ADRP+LDR 从 `.data/.rodata` 载入的，纯静态字节扫描无法归因。
4. 二进制 grep `u16be(15740)=3D 7C` 在 `libcontrol.so` 只有 1 处命中（文件偏移 `0xaeeb9`），但反汇编上下文为 `11 3d 7c b3` = AArch64 `0xb37c3d11`（`csel` 族指令），**属巧合，不可作证据**。

⇒ 三个候选（`15740` = PTP/IP 规范默认端口；`3192`；`3195/3196`）中，**只有 15740 有规范依据，包内无任何一条支持 3195/3196 的证据**。旧文档写 `3195/3196` 属推测，应降级为「未证实」。

**验证方法（按成本递增）**：
1. 手机连相机 AP 后 `adb shell netstat -tnp | grep golive`，看已建立连接的本地/远端端口（最快，10 秒出结论）。
2. 路由器/AP 侧抓 `arp -a` + `tcpdump port not 80 and not 53`，看 App 进程对外新建 TCP 的目的端口。
3. `frida` hook `connect()`：`interceptor.attach(Module.findExportByName("libc.so","connect"))`，打印 `sockaddr_in->sin_port`（ntohs 后）与 `sin_addr`，可一次拿到 cmd/event/data 三个端口的相对关系（PTP/IP 规范允许「event 端口 = command 端口 + 1」）。
4. IDA：从 `ptp_ptpip_connect` 往下找 `htons`/`mov w1, #imm` 或 `.data` 里的 `sockaddr_in` 模板。

### 3.6 其它静态缺口
- `ptp_icatch_set_customer_operation` 的自定义 op 码：`libcontrol.so` 里只有函数名，无码值。
- `enableSocketIO` / `disableSocketIO` 到底开哪个端口（是否与 `192.168.1.1` 的 socketIO 协议有关）：Java 层 **`CommandSession.prepareSession` 只调 `enablePTPIP`，从不调 `enableSocketIO`**（`_work/idgo_live_src/sources/com/icatch/golive/MyCamera/CommandSession.java:99-124` 全文可见），所以 socketIO 通道在本 App 内**未被启用**。
- `getPtpTimeoutCheckCount` / `getPtpTimeoutCheckIntervalInSecs` 只有 getter，App 不写；App 写的是 `setConnectionCheckParam(AppInfo.connectionCheckTimes=4, AppInfo.connectionCheckInterval=4, 0)`（`_work/idgo_live_src/sources/com/icatch/golive/MyCamera/CommandSession.java:120`），注意第三参 `0` 且 `_work/idgo_live_src/sources/com/icatchtek/control/core/feature/ICatchCameraConfigImpl.java:84-86` 的实现把 `(int times, double interval, int extra)` 转成 JNI 时**把 `i` 传了两遍**（`setConnectionCheckParam_Jni(..., i, d, i)`，第三参 `i2` 被丢弃）——这是 SDK 的一个 bug，`extra` 参数永远丢失。

---

## 4. 事件与日志（native 侧）

| 项 | 值 | 证据 |
|---|---|---|
| 事件分发线程 | `evtHdlThd` | `libcontrol.so` .rodata |
| 事件队列日志 | `queue sdk event, eventID: 0x%x, sessionID: 0x%0x, handler: %p`；`no memory, skip sdk event, …`；`found event, …`；`call listener: event: 0x%x, listener: %p`；`add listener: id: 0x%x, listener: %p, handler: %p`；`%s, event handler for %d not found` | 同上（`Phoenix_libEventHandlerImpl` / `com.icatchtek.control.core.CameraEventListener` / `Phoenix_libEventListener` 三个 RTTI 名同时出现，说明事件层是 Phoenix 库实现、control 层复用） |
| 会话监视 | `Add watched session for: %d` / `Remove watched session for: %d` | 同上 |
| SDK 日志文件 | 模板 `icatch_%s_sdk_%s_%s.log`；目录 `/mnt/sdcard`；SDK 名 `mobile_sdk`；厂商标 `iCatch` / `Android`；构建号 `5345600` | 同上 |
| 日志行格式 | `%ld %06ld -- %03d %03d: %05lu` + ` %s %s  [%s: %s]` | 同上 |
| 裸流落盘 | `%s/stream_dump_vid_%ld_%ld.raw`、`%s/stream_dump_aud_%ld_%ld.raw`、`__video_file_nam/_hdl/_dmp`、`__audio_file_nam/_hdl/_dmp`、`codec: %d outputCodec: %d`、`__codec_settings__`、`setOutputCodec` | ⇒ native 支持把预览流按裸 H.264/AAC 落盘，对应 Java `AppInfo.enableDumpVideo`（`data/AppInfo/AppInfo.java:54`，默认 false）与 `STREAM_OUTPUT_DIRECTORY_PATH="/idGoLive/Resoure/Raw/"` |
| 未支持固件标记 | `fw_not_support` | .rodata |
| 预览线程名 | `ptpevtrecvthread` / `ptpevtrecv` | .rodata |

App 侧对应：`AppInfo.SDK_LOG_DIRECTORY_PATH="/idGoLive/MobileCam_SDK_Log/"`、`APP_LOG_DIRECTORY_PATH="/idGoLive/MobileCam_APP_Log/"`（`data/AppInfo/AppInfo.java:14/26`）。

---

<!-- 以下整段合并自原 03-idGoLive-档案-附录-UI与端点判定.md（2026-09-22 文档归并，内容未改） -->
# 附录 D · idGoLive UI 面、云端端点判定、native 字符串真伪

> 返回 主档案（本文附录）。
> 证据：`_work/re/idgolive/{layouts.md,res-strings-default.md,res-strings-zh.md,res-locales.md,natives-strings.tsv,signals-*.tsv}`、`_work/idgo_live_src/sources/**`。

---

## 1. 语言与本地化面

`_work/re/idgolive/res-locales.md`：仅 **default（英文）+ values-zh（简体中文）** 两套字符串；布局 XML 里出现 `values-sw`（`sw` = 「Swahili 斯瓦希里语」）的 **只有一个尺寸别名 `values-sw600dp` 之类的宽度限定符**（不是语言）。⇒ App 实际只有英/中两种文案，且中文不是靠 `values-zh` 自动切换，而是靠 **`ChangeLanguageActivity` + App 内语言开关**（`R.string.text_change_language`）。
`layouts.md:78`（`activity_wifi_ap.xml`）里 SSID/Password 提示语直接用中文字面量「开启wifi热点 / 关闭wifi热点」写死在布局里 —— 说明该页未走 string 资源，是**开发者调试页遗留**。

---

## 2. 页面清单（316 个 layout，App 自有 ~35 个，其余为 AppCompat/Material/album/exo 三方）

### 2.1 主流程页（名称 = `res/layout/<name>.xml`）

| layout | 可见控件与文案（原样） | 对应 Activity / Presenter | 承担的操作 |
|---|---|---|---|
| `activity_start_page` | 只有一个 `ImageFilterView`（无文案） | `ui.activity.StartPageActivity`（launcher，`manifest.md:124`） | 冷启动 → 隐私协议判定（`:124-128` 三个 URL）→ `LaunchActivity` |
| `activity_launch` | `AppBarLayout` + `Toolbar`（`@+id/appbar`,`@+id/toolbar`），无静态文案 | `ui.activity.LaunchActivity`（`exported=true`，且注册 `USB_DEVICE_ATTACHED`，`manifest.md:138`） | 设备列表主页（4 个机位槽）、加机、BT 配对入口 |
| `activity_preview` | `@string/title_preview` + toolbar + `@+id/tv_title` | `ui.activity.PreviewActivity`（1225 行）+ `Presenter.PreviewPresenter`（2507 行，最大类） | 预览/拍照/录像/设置抽屉 |
| `preview_control_view` `preview_player_view` `video_control_view` `content_panorama_preview` | 被上面的 include | 同上 | 快门、模式切换、变焦、录制时长、电量、SD 图标 |
| `activity_usb_preview` | 仅 toolbar | `ui.activity.USBPreviewActivity`(608) + `Presenter.USBPreviewPresenter`(1450) | USB(UVC) 预览 |
| `activity_remote_files` / `activity_remote_file_ly` | `@string/remote_file`、`@string/all`、`@string/select`、`@string/title_video`、`@string/title_photo`、`@string/title_emergency`；id：`tv_select_all` `tv_selector` `btn_video` `btn_photo` `btn_emergency` `vPager` | `ui.activity.LYRemoteFileActivity` + `ui.Fragment.RemoteDeviceFilesFragment`/`LYRemoteFileFragment` + `Presenter.RemoteDeviceFilesFragmentPresenter` | **Novatek/Qz 白牌机的回放墙**（视频/照片/紧急三 tab + 全选） |
| `activity_device_settings_ly` | `@string/title_setting`、`@string/device_name_pwd`、占位 `id221_Device_model_one`、`********`、`@string/format_device`、`@string/reset_device`；id：`tv_device_name` `tv_device_pwd` `rv_settings` `btn_format` `btn_reset` | `ui.activity.LdeviceSettingActivity`(1034 行) / `YdeviceSettingActivity`(780 行) | 白牌机设置页：**设备名/密码显示 + SD 格式化 + 恢复出厂 + 参数 RecyclerView** |
| `activity_live_video_ly` | `@string/title_preview`、字面量 `4K`、`30fps`、`@string/hd_quality_hint`、字面量 `00:00:00`、`@string/pause_record`、`@string/setting_title_camera_switch`、`@string/remote_file`、`@string/take_pictures`；控件 `com.icatch.golive.video.EmptyControlVideo` | `ui.activity.LYLiveVideoActivity`(780 行) | **白牌机直播页**：RTSP 播放 + 录制计时 + 前后镜头切换 + 拍照 |
| `activity_download_file_ly` / `activity_download_firmware` | `item_firmware_info` | `LYDownloadFileActivity` / `DownloadFirmwareActivity` | 下载管理 / 固件列表 |
| `activity_multi_pb` `activity_multi_pb2` `activity_photo_pb` `activity_video_pb` `activity_local_*_pb` `activity_local_photo_wall` `activity_common_video_player` `activity_pb_local_video` `activity_video_player_ly` `activity_local_files` | — | `MultiPbFragmentPresenter` / `PhotoPbPresenter`(728 行) / `VideoPbPresenter` / `LocalPhotoPbPresenter` / `LocalVideoPbPresenter` / `LocalDeviceFilesFragmentPresenter` / `CommonVideoPlayerActivity` | PTP 机的回放墙、单张/单条详情、本地相册、本地播放器 |
| `fragment_add_new_cam` | `@string/title_activity_add_new_cam`、`text_btpair_done`、`text_btpair_auto_connect_wifi`、`text_auto_connect_tips`、`text_btpair_auto_connect_wifi_btn`、`text_btpair_already_connect_cam`、`text_btpair_connect_wifi`、`text_connect_camera_by_usb`、`text_otg_tips`、`text_add_camaera_usb`（**原文拼写 `camaera`**）、`text_btpair_support_bt`、`text_btpair`；id：`save` `wifi_auto_connect` `wifi_connect_camera` `usb_connect_camera` `bt_pair` | `ui.Fragment.AddNewCamFragment`（`pwd = AppInfo.default_pwd`，`:42`） | **加机页：WiFi 自动连 / WiFi 手动连 / USB(OTG) 连 / 蓝牙配对 四入口** |
| `fragment_btpair_begin` | `text_ready_pair`、`text_btpair_search_camera`、`text_btpair_search_ble`；按钮 `button_bluetooth_search` `button_ble_search` | `Presenter.BTPairBeginPresenter`(444 行) | **经典 BT + BLE 双搜索** |
| `fragment_btpair_setup` | `Ssid` `Password` 输入框 + `text_btpair_skip`、`text_btpair_setup_camwifi`、`text_btpair_setup`；id `bt_wifisetup_camera_ssid` `bt_wifisetup_camera_password` `bt_wifisetup` | `BTPairBeginPresenter` | **通过蓝牙把手机要连的 WiFi SSID/密码写给相机** |
| `fragment_btpair_completed` | `text_btpair_done`、`text_btpair_connect_cam`、`text_btpair_connect_operationsteps` | 同上 | 配对完成提示 |
| `fragment_remote_device_files` | `@string/no_content` + `rv_remote_files` + **`ProgressWheel @+id/pw_load_more`** | `RemoteDeviceFilesFragmentPresenter` | 无限滚动分页取文件 |
| `fragment_local_pb_list` `fragment_multi_pb2` | 控件 `com.tinyai.libmediacomponent.components.filelist.FileListView` | `LocalMultiPbFragmentPresenter` 等 | TinyAI 文件列表控件（该库自带的 UI，`@+id/file_list_view`） |
| `activity_pv_size_setting` | — | `PvParamSettingActivity` | 预览参数（分辨率/帧率/码率）选择 |
| `activity_wifi_ap` | `SSID`/`test01`/`Password`/`1234567890`/`no`/`wpa`/`wpa2`/`开启wifi热点`/`关闭wifi热点` | `WifiApActivity` | **手机开热点让相机连（反向配网）**，加密三态：no/wpa/wpa2 |
| `activity_about_app` `activity_change_language` `activity_feedback` `activity_web` `activity_license` `activity_launch_help` `activity_connect_course` | — | `AboutAppActivity` `ChangeLanguageActivity` `FeedbackActivity` `WebActivity` `LicenseAgreementActivity` `LaunchHelpActivity` `ConnectCourseActivity` | 关于/语言/反馈(→`addIdCamFeedback`)/协议/教程 |
| `activity_login_facebook` `activity_login_google` `exo_test` `activity_video_player` | — | `LoginFacebookActivity` `LoginGoogleActivity` `ExoTestActivity?` | 第三方直播账号登录 |
| `album_*`（22 个）| — | `com.yanzhenjie.album` | 系统相册选图（分享用） |

### 2.2 用户可见文案（中文，原样抄自 `res-strings-zh.md`）
错误/进度类：
`dialog_connecting = 连接中...`｜`dialog_connecting_to_cam = 连接相机...`｜`dialog_connect_failed = 连接失败，请重试.`（**句末是半角点**）｜`dialog_reconnect = 重新连接`｜`dialog_reconnect_failed = 重新连接失败!`｜`dialog_btn_reconnect = 重新连接`｜
`alert_is_capturing_or_recording = 正在拍照或录影，操作失败！`｜`alert_not_same_password = 两次输入的新密码不同！`｜`current_setting_need_reconnect = 当前设置需要重连设备！`｜
`dialog_card_removed_and_back_photo_pb = SD已移除，将退出图片预览`｜`dialog_recording_card_full = 警告： SD卡已满，录像停止。`｜
`formatting_sd_card = 正在格式化SD卡`｜`format_success = 格式化成功`｜`format_device = SD卡格式化`｜
`delete = 删除`｜`delete_done = 删除完成`｜`dialog_delete_all = 全部删除`｜`dialog_delete_failed_single = 删除失败`｜
`dialog_downloading = 下载$1$ / $2$ ...`｜`dialog_downloaded_single = 图片已被下载到 $1$`｜`dialog_downloaded = $2$ $3$图片下载`｜`dialog_downloaded_skipped = $2$图片下载， （下一个$1$视频和$4$下载的图片）`｜`dialog_cancel_downloading_succeeded = 取消下载成功`｜`dialog_cancel_downloading_failed = 取消下载失败`｜`download = 下载(最多5个)`（**并发上限 5**）｜`download_complete_result = 完成下载，成功:$1$个, 失败:$2$个`｜`download_progress = 已完成: $1$个 等待下载: $2$个 失败： $3$个`｜`downloading_quit = 退出会取消当前正在下载任务，确定要退出吗？`｜
`dialog_preview = 预览数据加载中...`｜`first_connect_devices_then_live = 请先连接您的设备，再查看视频！`｜`gallery_cannot_download_video = 无法下载视频`｜`bluetooth_audio_recording = 蓝牙音频录制`｜`camera_wifi_password = 相机无线网络密码`｜`connect_course = 连接教程`｜`device_info_connect = 立即连接`｜`disconnect = 断开`｜`download_firmware = 下载固件`｜`download_manager = 下载管理`｜`downloading_file = 正在下载文件`。

### 2.3 入口 → 操作映射（复现时的导航图）

| 入口 | 目标 | 参数来源 |
|---|---|---|
| `StartPageActivity` → `LaunchActivity` | 机位槽 1..4 列表 | `CameraSlotSQLite`（`db/`）+ `CameraManager` |
| 长按/点击机位槽 → `AddNewCamFragment` | 四选一：`wifi_auto_connect` / `wifi_connect_camera` / `usb_connect_camera` / `bt_pair` | `AppInfo.inputIp`（默认 `192.168.1.1`）、`AppInfo.default_pwd`（`1234567890`），两者都可在 `LaunchPresenter.inputIp()`(`:630`) / 密码输入框(`:843-851`) 改并存 SP |
| `LaunchActivity` → `PreviewActivity` | PTP 机预览 | `MyCamera.connect(true)` |
| `LaunchActivity` → `LYLiveVideoActivity` | 白牌机预览 | `ConnectDeviceManager.getFrontCamLiveURL()` → RTSP |
| `LaunchActivity` → `LdeviceSettingActivity` / `YdeviceSettingActivity` | 白牌机设置（L=LyIC，Y=QzIC） | `AppInfo.isSupportSetting`（`net/QzIC.java:487` 的 `toSettings`） |
| `PreviewActivity` 工具条 → `PvParamSettingActivity` | 预览参数 | `getSupportedStreamingInfos()` |
| `AboutAppActivity` → `DownloadFirmwareActivity` | 固件列表 | `https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json` |

---

## 3. 云端与遥测端点逐个判定

判定方法：**是否在厂商包（`com/icatch/**`、`com/id221/**`、`com/icatchtek/**`、`com/tinyai/**`）里有真实调用点**；有调用点 = 「真在用」；只在常量表里 = 「声明未用」；在三方库里 = 「死重量」。

| 端点 | 出现位置 | 方法/字段 | 判定 |
|---|---|---|---|
| `https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json` | `ui/activity/DownloadFirmwareActivity.java:220`（GET，成功回调日志在 `:93`） | GET | **真在用**。响应字段：顶层数组/对象的 `product`、`name`、`region`、`version`、`download`（`_work/idgo_live_src/sources/com/icatch/golive/ui/activity/DownloadFirmwareActivity.java:173` 构造 `FirmwareInfo`） |
| `https://www.id221.com/api/app/firmware/area_check` | `net/ConnectDeviceManager.java:362` | GET | **真在用**，响应 `{code:int, data:{area_support:String}}`，`code==200` 才存（`:376-381`）→ `SPUtil.saveUserArea()` |
| `https://api.idalbum.com/album.php/api/addIdCamFeedback` | `net/RequestInfo.java:13` | — | **声明未用**：全仓无引用点（反馈页走 `FeedbackActivity`，实际提交地址需在 `FeedbackActivity` 内确认；常量本身没被读取） |
| `https://api.idalbum.com/album.php/api/getIdCamSoftwareVersionInfo` | `net/RequestInfo.java:29` | — | **声明未用**（App 版本检查走 native `FW_UPDATE_CHECK` 事件 + `firmware.json`） |
| `http://api.idstore.idalbum.com/api/getCustomerServiceInfo` | `net/RequestInfo.java:26` | — | **声明未用**，且是 **明文 HTTP**（若被启用即为降级风险） |
| `https://id221.com/` `https://id221.com/idGoLive/privacyPolicy-en.html` `https://idcam.idalbum.com.cn/idGoLive/{UserAgreement,privacyPolicy}-{en,zh_CN}.html` `file:///android_asset/{privacyPolicy,reminder}{-zh_CN,}.html` | `ui/activity/StartPageActivity.java:124-128`、`ui/activity/WebActivity.java:65-67`、`assets-index.md` | WebView | **真在用**。逻辑：`isShowedGlobalContent` 决定 境内(`idcam.idalbum.com.cn`) 还是 境外(`id221.com`)，`zh` 决定后缀 |
| `https://www.baidu.com` / `ping("www.baidu.com")` | `utils/WifiNetworkSpecifierUtil.java:43/285/294` | ICMP ping | **真在用**：作为「连上相机热点后是否真的有外网」的探测（对运动相机热点来说几乎必然失败，是「假成功」判定的来源） |
| `https://push.smarthome.icatchtek.com` | `com/tinyai/libmediacomponent/utils/AppInfo.java:35` | `PUSH_SERVER_ADDRESS` | **死重量**（TinyAI 库自带常量，`com/icatch/**` 无引用） |
| `https://api.bpsc.tinyai.top:3026` / `http://usa.boi.tinyai.top:3006` | `com/tinyai/libmediacomponent/utils/AppInfo.java:5-13` | `ACCOUNT_SERVER_BASE_URL{,_CN,_USA}` | **死重量**（同上；注意 USA 版是明文 http + 非标准端口 3006） |
| `https://www.googleapis.com/auth/plus.login`、`.../user.birthday.read`、`.../youtube` | `Function/live/google/*`、`signals-fullUrls.tsv` | OAuth scope | **真在用**（Google 直播推流授权）；`plus.login`/`birthday.read` 属已废弃 scope，复现时应剔除 |
| `http://localhost:8080` | `Function/live/google/Credentials.java:10` (`GOOGLE_REDIRECT_URI`) | OAuth 回调 | **真但在桌面语义**：手机上无法监听 localhost:8080 ⇒ Google 登录在移动端实际依赖 `AuthActivity` 弹窗，回调 URI 是遗留 |
| `rtmp://a.rtmp.youtube.com/live2`、`rtmp://a.rtmp.youtube.com/live2/3fur-h6bh-as8j-w7wd-d7us` | `signals-fullUrls.tsv`（Java 侧） | RTMP 推流 | **真在用**；后者是**写死的示例 stream key**（厂商测试残留，属信息泄露） |
| YouTube Data API v3：`https://www.googleapis.com/oauth2/v4/token`、`/youtube/v3/liveStreams?part=snippet,cdn`、`/liveStreams?part=id,status&id=%s`、`/liveStreams?part=id,snippet,status,cdn&id=%s`、`/liveBroadcasts?part=id,snippet,status,contentDetails`、`/liveBroadcasts?id=%s`、`/liveBroadcasts?part=id,status&id=%s`、`/liveBroadcasts/bind?...&id=%s&streamId=%s`、`/liveBroadcasts/transition?broadcastStatus=%s&id=%s&...`、`https://www.youtube.com/channel/`、`https://www.youtube.com/watch?v=` | **`lib/arm64-v8a/libpanorama_vr.so` .rodata**（`natives-strings.tsv` category=url） | native 实现 | **真在用，且在 native 层**：整条 YouTube 直播链路（取 token→建 stream→建 broadcast→bind→transition→给出 watch/channel 链接）由 `libpanorama_vr.so` 完成，Java 侧只调 `JStreamPublish`/`ICatchStreamPublish`。**这是本次深挖的最大结构发现** |
| Google OAuth Client ID `168811923581-u0njo0me7v4dd2ihb1n1c5hbkk0d1v9d.apps.googleusercontent.com`、`982555336638-vis3bioouhq71m4logk3qo525dpt3b37.apps.googleusercontent.com` | `signals-hosts.tsv` | 两个 client id | 两个都随包（一个给 Google 直播、一个给旧版登录），属**公开标识符**非密钥 |
| `http://demo.xarx.rocks/` | 三方库 Xarxlib | — | **死重量** |
| `http://www.w3.org/2000/xmlns/`、`.../XML/1998/namespace`、`http://www.w3.org/ns/ttml`、`http://dashif.org/guidelines/last-segment-number`、`http://www.smpte-ra.org/schemas/2067-3/2013#standard-markers` | `libavformat.so` / `libavfilter.so` | 命名空间常量 | **死重量（XML 命名空间，不是网络端点）** |
| `http://libusb.info` | `libusb_transport.so` | 文档链接 | **死重量** |
| `169.254.169.254`（GCE metadata）、scribejava 的 179 个 provider 域名 | `com/github/ferfalkun*/…`、`oauth-service` 库 | — | **死重量**，与相机无关（正是此前踩过的坑，保持原判） |
| Firebase / Crashlytics / GA / Facebook AppEvents | `com/facebook/appevents/**`（有 `FacebookSdk`）、`manifest.md:161-163` 注册 `CustomTabActivity` + `fbconnect://cct.com.id221.golive` | — | **部分在用**：Facebook 分享/登录是真的（`LoginFacebookActivity`、`queries: com.facebook.katana`）；**未发现 Firebase/Crashlytics/GA**，遥测主要落在日志文件与 `addIdCamFeedback` |

---

## 4. `natives-strings.tsv` 4879 条兴趣字符串的真伪判定汇总

分类计数（`natives.md:76-90`）：`cryptoKey` 819 / `protocolSymbol` 1124 / `ip` 41 / `httpPath` 23 / `filesystem` 20 / `socketApi` 10 / `url` 19 / `rtsp` 1 / `mdnsDiscovery` 6 / `jpegExif` 17。

| 判定 | 条目集合 | 依据 |
|---|---|---|
| **真在用** | `libcontrol.so` 的 167 条里全部 `ptp*` / `ptpip*` / `icatch_*` / `socket*` / `multicast` / `AES_*` / `simpleconfig*` / `234.168.168.168` / `stream_dump_*.raw` / `icatch_%s_sdk_%s_%s.log` / `mediumName=%s;codec=%d;…` / `fw_not_support` | 与 `natives-jni.md` 的 `Java_com_icatchtek_control_core_jni_JCamera*` 一一有对应实现；且 `CommandSession`/`ICatchCameraAssistImpl`/`CameraAction`/`FileOperation` 都调到了对应方法 |
| **真在用** | `libpanorama_vr.so` 的 YouTube API 全套 + `libphoenix` aac 码表 | 与 `Java_com_icatchtek_pancam_core_jni_JStream*`（105 条）配对 |
| **库里死字符串** | `libavformat/libavfilter/libffmpeg/libijkffmpeg` 的 `http://`、`https://`、w3c/dashif/smpte 命名空间、`http://libusb.info` | FFmpeg/libusb 上游自带，App 从不调用这些 demuxer |
| **库里死字符串** | `libcontrol.so` 的 `ptp_chdk_*`（7 个符号 + 对应串）、`ptp_nikon_getptpipguid` | 上游 libptp/libptp2 带入；**Java 侧 `JCameraControl`/`JCameraProperty` 无任何 chdk/nikon 方法**，故不可能被触发 |
| **库里死字符串** | `libcontrol.so` 的 `cryptoKey` 类 819 条中的绝大多数 | 该分类是按「像 key/password」的正则筛出来的，真正成体系的只有 `AES_set_key`/`AES_cbc_encrypt_sdk`/`AES_convert_key`/`AES_generateSBox`/`AES_display` + 4 条日志，服务于 §附录 B 5.1 的组播配网；其余是 C++ 符号名噪声 |
| **需真机验证** | `libcontrol.so` 的 `filesystem` 20 条（`/mnt/sdcard` 等）、`ip` 41 条（`127.0.0.1` + `234.168.168.168` + 其余散落在 ffmpeg 里的 0.0.0.0/224.x/239.x 组播地址） | 部分是 ffmpeg 的 RTP/RTSP 多播表，非相机逻辑 |

**清单里唯一一条 mdnsDiscovery** 类别（6 条）全部落在 ffmpeg 家族（`_http._tcp`、`_rtsp._tcp` 类），`libcontrol.so` 内**没有** mDNS/SSD/SSDP ⇒ idGoLive **不做 mDNS 发现**，发现只有 UDP 组播 5002 + ping + 手输 IP 三种。

---

## 5. 清单里拼错的权限名（原样）

`_work/re/idgolive/manifest.md:70`：

```
android.permission.CHANGE_WIFI_MULTICAST_STAT
```

正字应为 `android.permission.CHANGE_WIFI_MULTICAST_CAST`。
后果：Android 只识别已知权限，未知 `CHANGE_WIFI_MULTICAST_STAT` 在安装时被静默忽略（`PackageManager` 不授予、也不报错），
但 **`MulticastLock` 不需要权限**（`_work/idgo_live_src/sources/com/icatchtek/control/core/CoreMulticast.java:21-23` 的 `createMulticastLock("multicast.test").acquire()` 依然能拿到锁），
所以组播接收**看起来是好的** —— 真正需要的 `android.permission.ACCESS_WIFI_STATE`（`:60`，已声明）与 `CHANGE_WIFI_MULTICAST_CAST` 中后者缺失。
影响面：`WifiManager.setMulticastEnabled(true)`（API 29+，App 未用）会被拒；对 idGoLive 当前实现**无功能影响**，复现时**不要**跟着抄这条拼错的权限。

其它原样保留的拼写错误（不是权限，但影响搜索）：
`DEFALUT_TO_PREVIEW`（`_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:23`，应为 DEFAULT）、`notifyCameraConnectChnage`（`_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:1393`）、
`Function/BaseProrertys.java`（类名，应为 BaseProperties）、`fuction` 字段（`_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:29`）、
`AppInfo.PROPERTY_CFG_DIRECTORY_PATH = "/idGoLive/Resoure/"`（`Resoure`，`data/AppInfo/AppInfo.java:24`）、
`text_add_camaera_usb`（layout string）、`param=encodec`（`_work/idgo_live_src/sources/com/icatch/golive/ui/activity/YdeviceSettingActivity.java:585`）、
`mineType`（`ICatchVideoFormat.java` 字段名，应为 mimeType）。
