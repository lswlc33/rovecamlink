# XTU GO 8.4.3（`com.gku.xtugo`）穷尽式逆向档案

> 样本：`相机 app/XTU GO_8.4.3_243_2026-08-19-17-05-43.apk`
> 反编译源码：`_work/xtu_src/sources/`（18195 个 `.java`）；jadx 失败方法体：`_work/xtu_bad/sources/`
> 机器提取附录：`_work/re/xtugo/`（`api/*.md`、`own-constants.tsv`、`own-literals.tsv`、`signals-*.tsv`、`classes-all.tsv`、`packages.md`、`manifest.md`、`res-strings-*.md`、`assets-*.md`、`natives*.md/tsv`）
> 所有行号均为 jadx 输出文件内的真实行号，写前已用 Read 核对。

---

## 0. 本文覆盖度

| 维度 | 已分析量 | 说明 |
|---|---|---|
| DEX 类型总数 | 28522（`classes-all.tsv` 28522 行）| 含 AndroidX / 三方库 / 平台桩 |
| 厂商自有（OWN）类型 | 2885 个类型 / 301 个包（`packages.md` §OWN） | 逐类展开在 `_work/re/xtugo/api/*.md`（114 个分类文件） |
| 混淆残留（UNKNOWN） | 4 个类型 / 3 个包：`com.my`、`com.sherlockshi.widget`、`com.vladium.emma.rt` | 全部读源码确认，非厂商逻辑（`com.vladium.emma.rt` 是 EMMA 覆盖率桩） |
| 自有方法 | 23288（`own-methods.tsv`） | |
| 自有字段字面值 | 40029（`own-constants.tsv`） | 本文设置项/常量表全部来自此文件 + 源码复核 |
| 自有字符串字面量 | 22620（`signals-summary.md`，`own-literals.tsv`） | 分桶：httpPaths 127 / fullUrls 140 / hosts 501 / ips 36 / fsPaths 67 / cgiCmd 138 / queryStrings 3 / keyLike 536 / actions 91 / mime 374 / exts 79 / uaSdk 6 / hexMagic 125 / wifiSsid 401 / crypto 176 |
| 清单 | 38 条 uses-permission、4 类自定义/库权限、219 个组件（188 activity / 15 service / 14 provider / 2 receiver）、15 条 `queries`、7 条 uses-feature/uses-library、application 属性 12 项 | 见 §1 与 `附录-权限组件与域名` |
| 资源 | 2463 条 string/array/plurals（`res-strings-default.md`）、154 个语言配置（`res-locales.md`）、`res-strings-zh.md` 中文差异 | 本文抄录与设置相关的全部 `R.array.*` 与文案 |
| assets | 194 个（22 文本内联 + 172 二进制，`assets-index.md`） | 协议/数据相关的全部解读（§8） |
| native | 31 个 `.so`、467 个 `Java_*` 导出（`natives-jni.md`）、约 3.07MB 符号表 | 见 §9 |
| **未覆盖** | ① `com.icatchtek.**` / `cn.rxt.qscase.**` / `com.example.icatchplayerlibrary.**` 内部实现只做接口级解读（它们是随 APK 打进来的 iCatch 公版 SDK，非 XTU 私有协议，且其控制面在 `libcontrol.so` 内为 PTP，不属运动相机三条协议栈）② 127 个 jadx 失败文件中仅 `SocketAmbaCmd$1.run()` 等协议关键方法在 `_work/xtu_bad/` 补齐，其余为 UI/混淆类未逐个补齐 ③ `res-files.tsv` 里 4000+ 图片/mipmap 未逐个查看 ④ `lib/armeabi-v7a/*.so` 只清点不解析（32 位无符号表） | 原因：与「复现官方操作能力」目标无关或证据不可得 |

---

## 1. 清单与身份

### 1.1 包与版本

| 字段 | 值 | 出处 |
|---|---|---|
| package | `com.gku.xtugo` | `_work/re/xtugo/manifest.md:16` |
| versionName（全串） | `8.4.3_243_2026-08-19-17-05-43` | `manifest.md:20`；`_work/xtu_src/sources/com/gku/xtugo/BuildConfig.java:11` |
| versionCode | `243` | `BuildConfig.java:9` |
| minSdk / targetSdk / compileSdk | 23 / 35 / 34（platformBuildVersion `34/14`） | `manifest.md:18-25` |
| FLAVOR / BUILD_TYPE | `XTUGO` / `release` | `BuildConfig.java:8,7` |
| `CURRENT_APP_TYPE` | `0`（= `APP_XTU`） | `BuildConfig.java:6`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:19,25` |
| installLocation | `default` | `manifest.md:21` |
| Bugly App ID | `0324406337` | `BuildConfig.java:5`，用于 `com/gku/crashhandle/CrashReportManager.java:38` 的 `CrashReport.initCrashReport(ctx, BuildConfig.BuglyId, isDebuggable, strategy)` |

**这套代码是「一码多牌」的产物**：`CameraParameters` 里有 10 个 `APP_*` 常量（`APP_XTU=0`、`APP_YUTU=1`、`APP_LAMAX=2`、`APP_X9=3`、`APP_SUPERMO=4`、`APP_CADDX=5`、`APP_KBX=6`、`APP_UVEX=7`、`APP_YINGYAN=8`、`APP_CUTECAM=9`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:12-21`），XTU GO 只是 flavor=XTUGO 的那份。`SSExchangeWorkMode.workModeToResId()`（`com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:68-74`）按 `CURRENT_APP_TYPE` 走两套资源命名规则；`Common.java:170-176` 的下载目录用 `BuildConfig.APPLICATION_ID.split("\\.")[2]` 反推品牌段（XTU 下 = `xtugo`）。复现时**不要**把这些分支当 XTU 私有逻辑，但要知道 `APP_CADDX` 分支会改写工作模式名（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:90-113`）。

### 1.2 `<application>` 属性与实际后果

| 属性 | 值 | 后果（本 App 语境） |
|---|---|---|
| `name` | `com.gku.BaseApplication` | `@HiltAndroidApp`；`onCreate` 顺序：`LogSaveUtils.open` → `x.Ext.init` → `NetworkDeviceUtils.init` → `CrashHandler.catchException(.../logs)` → `NetworkApi.init` → `AppDatabase.getInstance()` → `LitePal.initialize` → `MediaStorage.init` → `LogEx.initLog("XUYGO", true, false)`。见 `com/gku/BaseApplication.java:41-57`。`XUYGO` 是日志 tag（另一品牌的残留） |
| `usesCleartextTraffic` | `true` | 相机侧全部是 `http://192.168.0.1/...`，必须允许明文；同时**放开**了 `http://121.40.107.215:8041/firmware/`、`http://www.gkuvision.com:8882/...`、`http://api.shhc-yh.com/...` 等全部明文 HTTP（见 `附录-权限组件与域名`） |
| `networkSecurityConfig` | `@xml/network_security_config` | 实际内容只有一行：`<base-config cleartextTrafficPermitted="true"/>`（`_work/xtu_res/resources/res/xml/network_security_config.xml`）。**没有任何 domain-config / certificate-transparency / pin 配置**，等价于「全局允许明文」。另有 `res/xml/network_config_base.xml` 未被 manifest 引用 |
| `allowBackup` | `true` | SharedPreferences + LitePal 库 + `/data/data/com.gku.xtugo` 可被 `adb backup` 导出，含 `bt_pin<设备名>` 这类配对码（§11） |
| `requestLegacyExternalStorage` | `true` | Android 10 上退回旧存储模型，因此 `Common.ACTION_CAM_DOWNLOAD_PATH_*`（`Common.java:170-172`）这种 `/DCIM/xtugo/...` 绝对路径写法仍能用；Android 11+ 由 `MANAGE_MEDIA`/`READ_MEDIA_*` + MediaStore 兜 |
| `hardwareAccelerated` / `supportsRtl` | true / true | RTL 生效，`res-*.xml` 里有 `drawable-ldrtl-*` 目录 |
| `extractNativeLibs` | `false` | `.so` 以 `embedded` 方式留在 APK 内（影响不了协议） |
| `allowNativeHeapPointerTagging` | `false` | 兼容 iCatch/高德 native 堆指针标记 |
| `theme` / `label` / `icon` | `@style/AppTheme` / `XTU GO` / `@mipmap/icon`(+`icon_round`) | `manifest.md:29-31` |
| `appComponentFactory` | `androidx.core.app.CoreComponentFactory` | — |

`queries` 声明了 4 个包 + intent（`manifest.md` 「包可见性声明」）：`com.tencent.mm`、`com.tencent.qq`、`com.gku.xtugo`、`com.gku.yutupro`。前两个给分享/拉起，`com.gku.yutupro` 用于「去另一个品牌的 App」跳转（`HttpProxy`/`UpgradeViewManager` 里有 `play.google.com/store/apps/details?id=com.gku.yutupro` 字符串，见 `_work/re/xtugo/signals-fullUrls.tsv`）。

### 1.3 38 条权限逐条用途

运行时**真正申请**的只有 `PermissionActivity` 的三套数组（`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31-33`）：

- API ≤ 29：`READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE, CHANGE_WIFI_STATE, ACCESS_NETWORK_STATE, CALL_PHONE, BLUETOOTH, CHANGE_NETWORK_STATE`
- API 30–32：同上，但去掉 `WRITE_EXTERNAL_STORAGE`/`BLUETOOTH`，换成 `BLUETOOTH_SCAN, BLUETOOTH_CONNECT, BLUETOOTH_ADVERTISE`
- API ≥ 33：`READ_MEDIA_VIDEO, READ_MEDIA_IMAGES, READ_MEDIA_AUDIO` + 定位 + WiFi + 网络 + `CALL_PHONE` + 三个蓝牙权限

全量 38 条的用途与代码位置：

| # | 权限 | maxSdk | 用在哪（file:line） | 判定 |
|---|---|---|---|---|
| 1 | `ACCESS_NETWORK_STATE` | — | 申请于 `PermissionActivity.java:31-33`；读取实现在 `com/gku/base/utils/NetWorkInfoUtils.java`、`com/gku/loginmodule/utils/NetworkUtils.java:23` | 使用中 |
| 2 | `INTERNET` | — | OkHttp/AndroidHttpClient 全量；`com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:67` | 使用中 |
| 3 | `READ_PRIVILEGED_PHONE_STATE` | — | 全树 grep 无任何 Java/XML 引用（`grep -rl 'android.permission.READ_PRIVILEGED_PHONE_STATE"'` → 0） | **死声明**（系统级权限，普通 App 拿不到，也不影响功能） |
| 4 | `READ_EXTERNAL_STORAGE` | — | `com/gku/actioncam/sigmastar/data/SSFileUtils.java:24`（权限判断）、`FileUtils.java:41`；申请于 `PermissionActivity.java:31-32` | 使用中 |
| 5 | `WRITE_EXTERNAL_STORAGE` | 29 | `PermissionActivity.java:31`；`FileUtils.java:41`；`DownLoadFileUtils`/`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:33-36` | 使用中（≤29） |
| 6 | `MANAGE_MEDIA` | — | 全树 grep = 0 引用 | **死声明**（Android 13 媒体编辑授权未实现，改用 `MANAGE_MEDIA` 未落地） |
| 7 | `ACCESS_MEDIA_LOCATION` | — | 仅 `com/bumptech/glide/load/model/stream/QMediaStoreUriLoader.java:159`（Glide 内部检查） | 库携带；厂商代码不主动申请 |
| 8 | `ACCESS_WIFI_STATE` | — | `com/gku/actioncam/hisilicon/dv/biz/HiWifiManager.java`、`com/gku/base/utils/WifiUtils.java`（`getWiFiPhoneIp` 用于 Ambarella `msg_id=261` 的 `param`，见 `com/gku/actioncam/amba/model/AmbaCmdModel.java:279`） | 使用中 |
| 9 | `CHANGE_WIFI_STATE` | — | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/HiWifiManager.java:271` 一带；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java:493-500` 主动 `disconnectWifi()` 后再连相机 AP | 使用中 |
| 10 | `CHANGE_NETWORK_STATE` | — | `NetworkDeviceUtils` 的 `bindProcessToNetwork` 路径；`PermissionActivity.java:31-33` 三条数组都带 | 使用中 |
| 11 | `READ_PHONE_STATE` | — | 2 处引用：`com/gku/...`（IMEI/deviceId 采集类）+ Bugly/友盟系库；未见厂商功能依赖 | 弱使用（崩溃上报标识） |
| 12 | `ACCESS_COARSE_LOCATION` | — | `com/gku/base/utils/LocationUtil.java`（`getLastLocation`）、`PermissionActivity.java:31-33` | 使用中（GPS 轨迹 + 高德坐标转换） |
| 13 | `ACCESS_FINE_LOCATION` | — | `com/gku/loginmodule/utils/PermissionUtils.java`（`PermissionUtils.LOCATION` 常量），随粗定位一起申请 | 使用中 |
| 14 | `GET_ACCOUNTS` | — | 全树 grep = 0 | **死声明** |
| 15 | `FOREGROUND_SERVICE` | — | `MessageService.onCreate()` 调 `startForeground(10121, ...)`：`com/gku/actioncam/hisilicon/dv/net/MessageService.java:56-60`；`KeepAliveService` 同理 | 使用中 |
| 16 | `WAKE_LOCK` | — | `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java:43` `PowerManager.WakeLock mWakeLock`；`setScreenOnWhilePlaying(true)`（`:192,238-239`）。代码用 `FLAG_KEEP_SCREEN_ON` 为主，WakeLock 字段存在但未见 `acquire` | 弱使用 |
| 17 | `BLUETOOTH_CONNECT` | — | `BLEConnectUtils.checkBlePermission()`（`com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:910-918`）；所有 `writeCharacteristic` 前都走它 | 使用中 |
| 18 | `BLUETOOTH_SCAN` | — | 同上 `:912`；扫描回调过滤在 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/DeviceAddActivity.java:125` | 使用中 |
| 19 | `BLUETOOTH` | 30 | `PermissionActivity.java:31`；`BluetoothAdapter` 老 API | 使用中（≤30） |
| 20 | `BLUETOOTH_ADMIN` | 30 | 仅 1 处引用（`startDiscovery()`/`cancelDiscovery()` 需要的旧权限） | 使用中（≤30） |
| 21 | `BLUETOOTH_ADVERTISE` | — | `PermissionActivity.java:32-33`；SPP/配对场景申请，实际未见 `startAdvertising` | 申请了但未用 |
| 22 | `READ_MEDIA_IMAGES` | — | `PermissionActivity.java:33`（`PermissionConfig.READ_MEDIA_IMAGES`）；相册/文件选择 | 使用中（≥33） |
| 23 | `READ_MEDIA_AUDIO` | — | 同上 | 使用中（≥33，实际只放视频配音用） |
| 24 | `READ_MEDIA_VIDEO` | — | 同上 | 使用中（≥33） |
| 25 | `WRITE_MEDIA_STORAGE` | — | 全树 grep = 0（系统签名权限） | **死声明** |
| 26 | `WRITE_SETTINGS` | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:1215-1222`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:1226-1233` 用 `Settings.System.canWrite()` + `putInt("accelerometer_rotation", …)`；`com/gku/base/permission/PermissionActivity.java:120` | 使用中（预览页「自动旋转」开关） |
| 27 | `MODIFY_AUDIO_SETTINGS` | — | 全树 grep = 0 | **死声明**（GSYPlayer/ijk 库带入） |
| 28 | `RECORD_AUDIO` | — | `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`（语音反馈）、`com/gku/actioncam/sigmastar/videoedit/AudioCollectActivity.java`（视频编辑配音） | 使用中 |
| 29 | `CAMERA` | — | `com/gku/loginmodule/utils/PermissionUtils.java`；**注意**：预览画面是相机 RTSP 流，不是本机摄像头；本机相机只用于扫码/拍照反馈 | 弱使用（zxing 扫码） |
| 30 | `VIBRATE` | — | `com/gku/base/utils/VibratorUtils.java:9-16`（`vibrate(50L)`） | 使用中（按键/扫码反馈） |
| 31 | `CALL_PHONE` | — | 三套数组都带（`PermissionActivity.java:31-33`），但全树未见 `ACTION_CALL`/`tel:` 拨号（只有 `ACTION_DIAL` 级别的跳拨号盘） | **申请了但未真正拨号**（`CALL_PHONE` 可直接拨出，实际不需要）——见「未解之谜」 |
| 32 | `CHANGE_CONFIGURATION` | — | 全树 grep = 0 | **死声明** |
| 33 | `READ_LOGS` | — | 全树 grep = 0（Android 4.1+ 也只能读自己） | **死声明** |
| 34 | `SYSTEM_ALERT_WINDOW` | — | 全树 grep = 0；无 `TYPE_APPLICATION_OVERLAY` 窗口 | **死声明** |
| 35 | `GET_TASKS` | — | 全树 grep = 0（Android 5.0+ 已失效） | **死声明** |
| 36 | `FLASHLIGHT` | — | 全树 grep 无 `PackageManager.FEATURE_FLASHLIGHT`/`setTorchMode` | **死声明** |
| 37 | `com.gku.xtugo.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`（自签，`signature`） | — | AndroidX `ContextCompat.registerReceiver` 自动生成，`androidx.core` 携带 | 框架自带 |
| 38 | `com.asus.msa.SupplementaryDID.ACCESS` | — | MSA（移动安全联盟）OAID SDK 的 vendor 权限，只在华硕机型生效；对应 `com/bun/miitmdid/**` 依赖 | 库携带 |

自定义 permission 只有 1 条（#37，`protectionLevel=signature`）。
`uses-feature`：`camera`(required=false)、`camera.autofocus`(true)、`camera.flash`(false)、OpenGL ES `0x20000`（=GLES2，required=true）。`uses-library`：`org.apache.http.legacy`(false，因 `HttpProxy` 用 `AndroidHttpClient`/`org.apache.http`)、`androidx.window.extensions`、`androidx.window.sidecar`。

### 1.4 组件：厂商自有部分

219 个组件中 `com.gku.*` 占 **107 个**（100 activity + 6 service + 1 provider）；把内置的 iCatch/`cn.rxt`/`com.example.icatch*`/`m.mifan` 界面一起算进「厂商侧」则 117 个。逐个职责见 `附录-权限组件与域名` §2；此处只列主干：

| 组件 | 类型 | 关键属性 | 职责 |
|---|---|---|---|
| `com.gku.actioncam.hisilicon.dv.ui.WelcomeActivity` | activity | **exported=true**，`LAUNCHER`，`portrait`，`theme=@style/welcomeTheme_XTU` | 唯一启动器入口（`manifest.md` activity 表） |
| `com.gku.HomeActivity` | activity | `singleTask`，`portrait`，`CustomActionBar` | 连接编排 + 网络回调 + 三条协议栈分派（`com/gku/HomeActivity.java:537-596`、`:1604-1632`、`:1707-1783`） |
| `com.gku.actioncam.hisilicon.dv.net.MessageService` | service | `exported=false` | 监听 **5678** 回拨 `ServerSocket`，把相机推送转成广播 `com.gku.xtugo.MESSAGE_ACTION`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:18-19,32-38,92-149`） |
| `com.gku.actioncam.hisilicon.dv.net.KeepAliveService` | service | `exported=false` | 2000ms（快）/5000ms（慢）心跳轮询，最多 5 次；广播 `com.gku.xtugo.DV_ISALIVE_ACTION`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java:19-24`） |
| `com.gku.actioncam.hisilicon.dv.LogService` | service | `exported=false` | 日志落盘/上传 |
| `com.gku.actioncam.sigmastar.OldUi.playback.model.service.DownloadIntentService` | service | `exported=false` | 回放下载队列（`…/playback/model/service/DownloadIntentService.java:125-137`） |
| `com.gku.CameraSocketService` | service | 无属性 | **清单幽灵**：`xtu_src` 与 `xtu_bad` 两棵树（各 18195 文件）都找不到该类的任何引用（`find -iname "*CameraSocketService*"` → 空） |
| `com.gku.actioncam.sigmastar.SSMessageService` | service | `enabled=true; exported=false` | **同上，清单幽灵** |
| `com.gku.base.BaseFileProvider` | provider | `authorities=com.gku.xtugo.FileProvider`，`grantUriPermissions=true`，`meta-data=android.support.FILE_PROVIDER_PATHS=@xml/paths_base` | 对外分享/安装 APK 的 content URI |
| `com.gku.SendSoftActivity` | activity | `singleTop`，`exported=false` | 通过 `FwUpload`/`RegisterDeviceToServer` 把**手机侧下载到的固件包**推给相机（`com/hisi/hisiFW/FwUpload.java`） |
| `com.gku.actioncam.amba.ui.stream.StreamingActivity` / `StreamConfigActivity` | activity | `exported=false` | 抖音/RTMP 直播（`_work/xtu_src/sources/com/gku/actioncam/amba/ui/stream/DouyinStreamController.java:158` 的 `SdkInitConfig`） |
| `com.gku.actioncam.sigmastar.newUi.deviceAdd.Activity.DeviceAddNewActivity` / `DeviceAddActivity` | activity | `portrait` | BLE 扫描 → 配对 → WiFi 配网（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/DeviceAddActivity.java:125`） |
| `cn.rxt.qscase.MainActivity` / `ControlActivity` / `AlbumActivity` / `PreferencesActivity` / `AgreementPermissionActivity` / `Main2Activity`、`com.example.icatchplayerlibrary.VideoPbActivity`、`m.mifan.acase.icatch.IcatchVideoPlayerActivity`、`cn.rxt.caeuicore.album.page.preview.VideoPlayerActivity` | activity | 全部 `exported=false`，`IcatchAppTheme` | **XTU Mini1 行车记录仪**（iCatch PTP over USB/HTTP）那套界面，不服务运动相机 |

> `GKUCamPlayer`（`com.gku.gkucamplayer.GKUCamPlayer`）**exported=true** 且 `screenOrientation=fullSensor` —— 这是全 App 除启动器外唯一被导出的厂商组件，外部 App 可直接拉起它（安全风险点，见 §12 之外的安全评估在 `docs/05`）。

---

## 2. 型号与平台判定

### 2.1 全部型号字符串（18 个）

两份清单，互为补充：

**A. 反馈页下拉列表（17 项，顺序即 UI 顺序）** —— `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java:211-227`：

`"S7PRO MAX"` `:211` · `"S7PRO"` `:212` · `"S7"` `:213` · `"MINI2PRO"` `:214` · `"X3"` `:215` · `"R1"` `:216` · `"S6PRO"` `:217` · `"S6"` `:218` · `"Mini1"` `:219` · `"MAX3"` `:220` · `"MAX2"` `:221` · `"MAXPRO"` `:222` · `"S3PRO"` `:223` · `"S5K"` `:224` · `"S2"` `:225` · `"X2"` `:226` · `"X1"` `:227`

**B. 设备图标/型号名解析（18 项，含 S3）** —— `com/gku/loginmodule/utils/CameraInfoUtils.java:7-111`。`getCameraImageByModel(name)` 与 `getCameraModelByName(name)` 两张表：

| 型号 token（严格照抄，含大小写与空格） | 备用 token（同义匹配） | 图标资源 | 代码行 |
|---|---|---|---|
| `XTUS2` | `S2`（**用 `contains` 而非 `equals`**） | `R.mipmap.s2` | `:11-13` / `:70` |
| `XTUS5k` | `S5K` | `R.mipmap.s5k` | `:14-16` |
| `XTUX1` | `X1` | `R.mipmap.x1` | `:17-19` |
| `XTUX2` | — | `R.mipmap.x2` | `:20-22` |
| `XTUMax2` | `MAX2` | `R.mipmap.max_2` | `:23-25` |
| `XTUMaxPro` | `MAXPRO` | `R.mipmap.max_pro` | `:26-28` |
| `XTUS3Pro` | `S3PRO` | `R.mipmap.s3_pro` | `:29-31` |
| `XTUS3` | `S3` | `R.drawable.picture_camera_nor`（通用机） | `:32-34` |
| `XTUMAX3` | `MAX3` | `R.mipmap.max3_1` | `:35-37` |
| `XTUS6` | `S6` | `R.mipmap.s6_1` | `:38-40` |
| `XTUX3` | `X3` | `R.mipmap.x3_1` | `:41-43` |
| `XTUS6Pro` | `S6PRO` | `R.mipmap.s6_pro2` | `:44-46` |
| `XTUR1` | — | `R.mipmap.s6_pro2`（与 S6Pro 同一张图） | `:47-49` |
| `XTUS7` | `S7` | `R.mipmap.s7` | `:50-52` |
| `XTU S7PRO` | `S7PRO`（**带空格**） | `R.mipmap.s7_pro` | `:53-55` |
| `XTU S7PRO MAX` | `S7PRO MAX`（**带空格**） | `R.mipmap.s7_promax` | `:56-58` |
| `XTUMINI2PRO` | `MINI2PRO` | `R.mipmap.mini2pro` | `:59-61` |
| （兜底） | 空串 → `"XTU GO"` | `R.drawable.picture_camera_nor` | `:9`,`:62`,`:66-68` |

BLE 扫描列表的图标规则**另有一套**，且**有已知 bug**：`com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/ScanAddRecycleAdapter.java:73-131`。规则是「去掉所有 `_` → 若长度 >6 则截掉末尾 6 字符（MAC 后缀）→ 忽略大小写比字面量」：

| 比较值 | 图标 | 行 |
|---|---|---|
| `XTUX1` | `R.mipmap.x1` | `:81` |
| `XTUX2` | `R.mipmap.x2` | `:84` |
| `XTUX2`（**第二次，永远不可达**） | `R.mipmap.s2` | `:87` |
| `XTUS5K` | `R.mipmap.s5k` | `:90` |
| `XTUs3pro` | `R.mipmap.s3_pro` | `:93` |
| `XTUmaxpro` | `R.mipmap.max_pro` | `:96` |
| `XTUmax2` | `R.mipmap.max_2` | `:99` |
| `XTUmax3` | `R.mipmap.max3` | `:102` |
| `XTUs6` | `R.mipmap.s6` | `:105` |
| `XTUx3` | `R.mipmap.x3` | `:108` |
| `XTUmini1` | `R.mipmap.f05_mini_1` | `:111` |
| `XTUs6pro` | `R.mipmap.s6_pro` | `:114` |
| `XTUr1` | `R.mipmap.s6_pro` | `:117` |
| `XTUs7` | `R.mipmap.s7` | `:120` |
| `XTUs7pro` | `R.mipmap.s7_pro` | `:123` |
| `XTUs7promax` | `R.mipmap.s7_promax` | `:126` |
| 其它 | `R.mipmap.x1`（兜底） | `:128` |

> **结论**：S2 在 BLE 列表里画不出来（`:87` 分支被 `:84` 吃掉）；`ScanAddRecycleAdapter` 用「去尾 6 字符」把 `XTU_S7PRO_MAX_f9be5a` 归一为 `XTUS7PROMAX`，而 `CameraInfoUtils` 用的是带空格的全名 —— 两套命名不能互换。

### 2.2 `type` 字段分派表（唯一的平台判定键）

芯片常量的**全部字符串值**在 `com/gku/actioncam/sigmastar/SSConstant.java`：

| 常量 | 值 | 行 |
|---|---|---|
| `AMBA` | `"H75N"` | `:5` |
| `CHIP` | `"SSC8838"` | `:6` |
| `CHIP_26` | `"SSC8826"` | `:7` |
| `CHIP_38c` | `"SSC8838C"` | `:8` |
| `HAISI` | `"Hi"`（前缀匹配用 `contains`） | `:9` |
| `SSEnable` | `true` | `:12` |
| `SS_IP` | `"192.168.0.1"` | `:13` |
| `LOCAL_DOWNLOAD_DIR` | `"/mnt/sdcard/DCIM/ActionCam/"` | `:10` |
| `LOCAL_THUMB_CACHE_DIR` | `"/mnt/sdcard/Android/data/com.gku.xtugo/cache/"` | `:11` |
| `SSFileFormat`（枚举） | `mp4`, `jpg`, `dng` | `:15-19` |

另有裸字面量 `"CV75"`（无常量，硬编码 11 处）与 `Common.SENSOR_117="117"`、`SENSOR_34220="34220"`（`com/gku/actioncam/hisilicon/dv/biz/Common.java:144-145`）。

四个 `*ModelManage` 工厂 + 一处 UI 判定，构成分派表：

| 工厂 / 调用点 | file:line | SigmaStar 分支 | Ambarella 分支 | 海思分支 |
|---|---|---|---|---|
| `PreviewModelManage` | `…/OldUi/preview/model/PreviewModelManage.java:20-28` | `type ∈ {SSC8838, SSC8826, SSC8838C}` → `SigmastartPreviewModel` | `type ∈ {H75N, "CV75"}` → `AmbaPreviewModel` | 其余 → `HaisiPreviewModel`（`:23`） |
| `SettingModelManage` | `…/OldUi/setting/model/SettingModelManage.java:16-23` | 同上 → `SigmastartSettingModel` | 同上 → `AmbaSettingModel` | else → `HaisiSettingModel` |
| `PlaybackModelManage` | `…/OldUi/playback/model/PlaybackModelManage.java:22-28` | → `SigmastartPlaybackModel` | → `AmbaPlaybackModel` | → `HisiPlaybackModel` |
| `FastSettingModelManage` | `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingModelManage.java:14-21` | `SSC8838/SSC8826`（**注意 `CHIP_38c` 的比较结果被丢弃，`:20` 是空语句**）→ 实际不装 model | `H75N`/`CV75` → `AmbaFastSettingModel` | 无（model 为 null → 返回 no-op 匿名实现） |
| `SSVideoView` RTSP 传输选择 | `com/gku/actioncam/sigmastar/widget/SSVideoView.java:603-607` | 非 AMBA → `rtsp_flags=prefer_tcp` | `H75N`/`CV75` → `rtsp_transport=udp` | — |
| `BTHeartbeatManage`（蓝牙心跳开关） | `…/newUi/common/model/BTHeartbeatManage.java:18` | — | `type ∈ {H75N, "CV75"} && name.toUpperCase().endsWith("S7")` → 启动心跳 | — |
| `SSFileInfoBean` 缩略图/远程路径 | `com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:84,122,157,163` | `http://192.168.0.1/thumb<path>` | 直接用 `originPath`（走 8787） | `http://192.168.0.1/<path>`，扩展名换成 `.LRV`（回放）或 `+.THM`（缩略图，`HiDefine.FILE_SUFFIX_THM`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/HiDefine.java:26`） |
| `SSFileUtils.changeStr` 语言表分派 | `com/gku/actioncam/sigmastar/data/SSFileUtils.java:47-70` | JSON 表（`getReplaceValueForJson`） | `AmbaLangHolder.getStr` | `type.contains("Hi")` → XML 表；否则原样返回 |

**「其它 → 海思」这个 else 很重要**：真机 S7PRO 报 `type=Hi3519DV500`（不在上面任何枚举里），因此落到 `Haisi*Model`，但**走的是 NewAPP 分支**（见 §2.3），即海思 CGI 的「新方言」。老方言只在 `hardversion != "NewAPP"` 时使用。

### 2.3 探测顺序：HTTP CGI 优先、Ambarella socket 兜底（真实代码路径）

```
WiFi/网络 onAvailable
  └ HomeActivity.networkCallback.onAvailable                 _work/xtu_src/sources/com/gku/HomeActivity.java:558-576
      ip = guessDeviceIP()                                   _work/xtu_src/sources/com/gku/HomeActivity.java:1853-1857
           └ NetworkDeviceUtils.getIpDevice()                 _work/xtu_src/sources/com/gku/base/device/NetworkDeviceUtils.java:332-345
               先取 LinkProperties 里 isDefaultRoute() 的 gateway；
               非法则回落到 WifiManager.getDhcpInfo().serverAddress（==0 时用 gateway）
      白名单：ip ∈ {"192.168.0.1", IcatchCaseKt.API_HOST_ICATCH(="192.168.1.1")}   _work/xtu_src/sources/com/gku/HomeActivity.java:562
        ├ 命中 192.168.1.1 → resetBT()                                              :563-565
        ├ CameraParameters.baseIp = ip                                              :566
        ├ checkConnectionDevice(true, ip)                                           :567 → 定义在 :1604
        │    ├ ip == 192.168.1.1 → connectDashCamera2(...)（iCatch，非运动相机）      :1624-1626
        │    └ 否则 connectActionCamera(ip)                                          :1629 → 定义在 :1707
        │        GET http://<ip>/cgi-bin/hi3510/getdeviceattr.cgi   （HttpRequest，OkHttp，5s 超时）
        │            Url 拼接：HttpRequest.java:52 + :98            BaseUrl 生成：_work/xtu_src/sources/com/gku/HomeActivity.java:1708
        │        解析：getMap()（要求 `var K="V";\r\n`）HttpRequest.java:354-407
        │        ├ 解析成功（!=null）→ 海思/SigmaStar 路径（见下）
        │        └ 解析失败/异常 → **回退 Ambarella socket 会话**
        │              AmbaConnector.startSession(this, callbackSession)   :1776-1781
        └ 未命中白名单 → notifyConnectFailed + checkConnectionDevice(false, ip)      :570-575
```

**海思/SigmaStar 成功分支的副作用**（`_work/xtu_src/sources/com/gku/HomeActivity.java:1740-1773`）：
1. `getHisiWifiName(cameraInfors)` `:1716`
2. 若 `name ∈ {"XTU S7PRO","XTU S7PRO MAX"}` → `getactivateinfo.cgi` 读激活状态，`status==0` 时弹激活框；提供 `setactivateinfo.cgi` / `settrial.cgi` 两条出口 `:1714-1739`
3. `CameraParameters.IsAmbaDevice = false`；`VersionNo = softversion` `:1743-1744`
4. **`IsNewAPP = hardversion.equals("NewAPP")`** `:1746-1750` ← 方言开关
5. `type ∈ {SSC8838,SSC8826,SSC8838C}` → `SSFileUtils.getLanguageJson()`（8080 拉 `/tmp/FL0/language.json`）；否则 `FileUtils.getLanguageXml()`（8080 拉 `/mnt/language.xml`）`:1751-1755`
6. `CameraParameters.BaseUrl = "http://" + ip + "/cgi-bin/hi3510/"` `:1756`
7. `HisiApiUtils.setDevice_name/setDevice_type` `:1761-1762`
8. `edit.putString("modelName", name.split("-")[0])`、`putString("softVersion", …)`、`putBoolean("isAmba", false)` `:1765-1771`

**Ambarella 成功分支的副作用**（`_work/xtu_src/sources/com/gku/HomeActivity.java:690-780`）：`startSession` 成功后 `sendCmdQueue(msg_id=11, CameraInfoResponseBean)` → 组 `CameraInfors`（软版本去掉 `.G`/`.H` 尾段，`:717-721`）→ `IsNewAPP = true`、`IsAmbaDevice = true` `:756-757` → `AmbaLangHolder.downloadJson(ctx, 3, …)`（重试 3 次）`:758` → 立刻 `getSecondMenuItem("System","FLIP")` 预热 `:765-774` → `isAmba=true` 写 SP `:747-751`。

> **关键判定顺序**（复现时必须照抄）：**HTTP `getdeviceattr.cgi` 先跑**；只有它失败才建 7878 socket。S7PRO（Hi3519DV500）因此**不会**去碰 7878。

### 2.4 SSID / BLE 名规则（不存在正则）

| 用途 | 规则 | file:line |
|---|---|---|
| 「这是相机 AP」的唯一启发式 | `ssid != null && ssid.contains("XTU")`（**无正则、无 `SSID_PREFIX` 常量**） | `…/sigmastar/bluetooth/ui/PopupDialogActivity.java:199`；`…/newUi/deviceAdd/Fragment/connect/DeviceAddDeviceListFragment.java:315`；`…/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java:493` |
| BLE 扫描名过滤 | `name.contains("XTU") \|\| name.contains("GKU")`；名为空时从 `ScanRecord` 字节 `parseDeviceName(bytes)` 兜 | `…/newUi/deviceAdd/Activity/DeviceAddActivity.java:125`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java:418` |
| 「这台是 BLE 配网设备」 | `device.getName().toUpperCase().startsWith("XTU_")` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:473` |
| BLE 名样例（来自日志字面量） | `XTU_S7Pro_Max_f9be5a` | `com/gku/module_camera/bluetooth/BluetoothLive.java:70` |
| 已连 WiFi 的 SSID 归一（用于比对） | `WifiUtils.getConnectWifiName()` / `WIFIUtils.getWIFISSID()`，两侧都去引号后 `equals` 才跳过重连 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bluetooth/ui/PopupDialogActivity.java:197`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java:491` |
| AP 默认密码（**仅 iCatch 记录仪**） | `DEFAULT_AP_PASSWORD = "12345678"` | `com/gku/dashcam/icatch/utils/WifiAPUtil.java:20` |
| BLE 配网写死热点（直播场景） | `sendWifi(..., "gkuvision-5G", "gku88888", …)` | `_work/xtu_src/sources/com/gku/module_camera/bluetooth/BluetoothLive.java:92` |
| 型号文件名解析 | 固件文件末段按 `_` 切、再按 `.` 切取版本号；`\d{8}` 提日期 | `…/upgrade/firm/Presenter/UpgradePresenter.java:150-156`；`com/gku/loginmodule/manage/DeviceVersionManager.java:688` |
| 媒体文件时间戳 | `Pattern.compile("(\\d{8}[_-]\\d{6})")` | `…/newUi/album/Ui/Fragment/CommonFragment.java:408` |

真机一致性：`XTUCam_*` 满足 `contains("XTU")` ✓。

### 2.5 默认 IP / 端口 / URL 常量全表

| 常量 | 值 | file:line |
|---|---|---|
| `CameraParameters.baseIp` | `"192.168.0.1"` | `…/dv/ui/config/CameraParameters.java:37`（孪生类 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParmeras.java:37` 同值） |
| `SSConstant.SS_IP` | `"192.168.0.1"` | `…/sigmastar/SSConstant.java:13` |
| `DV.defaultIP` | `"192.168.0.1"` | `…/dv/biz/DV.java:66` |
| `Common.CGI_PATH` | `"/cgi-bin/hi3510"` | `…/dv/biz/Common.java:11` |
| `Common.ICGI_PATH` | `"/cgi-bin"` | `Common.java:61` |
| `SSCommandUtil.SS_BASE_PATH` | `"/cgi-bin/hi3510/"` | `…/sigmastar/SSCommandUtil.java:9` |
| HTTP 端口 | `80`（`Socket(str2, 80)`） | `…/dv/biz/Setting.java:387`；thttpd/2.29 真机一致 |
| RTSP | `:554/livestream/12`（小码流）/`11`（大码流） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:50`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:50`、`…/dv/biz/DV.java:320-330`、`…/amba/ui/preview/AmbaPreviewActivity.java:972` |
| HTTP 预览 | `http://<ip>:80/12?trans=tcp&action=play&media=video_data` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:332-341` |
| 二进制文件口 | `8080` | `…/sigmastar/data/connect/SSConnectDevice.java:57`、`…/data/connect/DownLoadFileUtils.java:32`、`…/data/connect/FirmwareClientThread.java:64`、`com/hisi/hisiFW/FwUpload.java:17`、`…/dv/ui/data/connect/ConnectDevice.java:44`、`com/gku/module_camera/hisi/HisiDownloader.java:75` |
| Ambarella 命令口 | `7878`（`AMBA_CMD_PORT`） | `…/amba/AmbaConstant.java:5` |
| Ambarella 数据口 | `8787`（`AMBA_DATA_PORT`） | `_work/xtu_src/sources/com/gku/actioncam/amba/AmbaConstant.java:6`；`com/gku/module_camera/amba/ConstantsAmba.java:5` |
| 相机回拨 App 口 | `5678`（`SERVER_PORT`） | `…/dv/net/MessageService.java:19`；`com/gku/module_camera/hisi/HisiSocketServer.java:19,73` |
| Wake-on-LAN | UDP `9` 到 `<ip 前三段>.255`，102 字节 magic packet，发 5 次 | `Setting.wakeupDevice()` `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:483-511` |
| 本地代理 | `127.0.0.1`（videocache / GSY / ProxyCacheManager） | `com/gku/videocache/HttpProxyCacheServer.java:32`、`com/gku/ffm/zqvideo/cache/ProxyCacheManager.java:56` |
| iCatch 记录仪 | `192.168.1.1`（`IcatchCaseKt.API_HOST_ICATCH`） | `m/mifan/acase/icatch/IcatchCaseKt.java:9` |
| `ENABLE_AMBA` | `true` | `_work/xtu_src/sources/com/gku/actioncam/amba/AmbaConstant.java:7` |

---

## 3. 三条协议栈

### 3.1 海思 CGI

分两套方言，由 `CameraParameters.IsNewAPP`（= `hardversion=="NewAPP"`）二选一。共用底座：

| 组件 | 作用 | file:line |
|---|---|---|
| `HttpProxy.doHttpGetForContent(url)` | `AndroidHttpClient.newInstance("HiCamera")`，`CONNECTION_TIMEOUT=20000`；**发请求前把 URL 里的空格全部删掉**（`url.replaceAll(" ", "")`），所以任何带空格的值必须自己先编成 `%20` | `…/dv/net/HttpProxy.java:44-46,59-87` |
| `doForSuccess(url)` | **只看 `statusCode==200` 就返回 0** —— 与真机结论一致：200 不代表成功 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:89-92` |
| `doForBoolean(url)` | 读键 `enable`，值 `"1"`→TRUE、`"0"`→FALSE，其它→null | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:94-107` |
| `doForMap` / `doForIntByKey` / `doForStringByKey` | 要求 200 且解析出 ≥1 个 KV；`doForIntByKey` 把负数一律折成 `-1` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:109-140` |
| `StringParser.getKeyValueMap/getMap` | 要求行尾是 `";\r\n` | `…/dv/net/StringParser.java:55-89` |
| `StringParser.getMap2` | **只要求 `";`** —— 所以 `getprimarymenuitem` 把 `item` 和 `cur` 写在同一行时只有最后一个键能读到；真机证据与之吻合 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/StringParser.java:91-108` |
| `SSResponseParse.parseMessageToMap/2` | sigmastar 侧的同款解析，另带 `cur` 的空位补齐技巧 | `…/sigmastar/data/SSResponseParse.java:532-560` |

完整命令表（两套方言、每个 CGI 路径/参数名/取值/单位/响应字段/解析行）见 **`02-XTUGO-档案-附录-海思CGI全表.md`**。要点摘录：

- 老方言（`Setting.java` / `RemoteFileManager.java` / `Command.java`）里存在**字面带前导 `-` 的查询键**：`&-cmd=`、`&-type=`、`&-resolution=`、`&-fps=`、`&-fov=`、`&-enable=`、`&-time=`、`&-count=`、`&-action=`、`&-videonorm=`、`&-brightness=`、`&-uimode=`、`&-bitrate=`、`&-wifichannel=`、`&-workmode=`、`&-value=`、`&-name=`、`&-start=`、`&-end=`、`&-partition=`、`&-status=`、`&-wifissid=`、`&-wifikey=`、`&-ssid=`、`&-key=`、`&-version=`。它们必须**原样带 `-` 发**（`docs/05` 已记录，本次逐条到行确认）。
- `getcurallinfo.cgi` 响应字段：`mode`(String) / `state`(int) / `event`(long) / `pasttime`(int)（`SSResponseParse.parseGetAllInfo` `…/sigmastar/data/SSResponseParse.java:487-530`）。`state` 语义：**20=WORKING、21=STANDBY**，常量在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:23-24`（`CAMERA_STATE_WORKING_STR=20`、`CAMERA_STATE_WORKING_END=21`）与孪生 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParmeras.java:23-24`；用法见 `…/OldUi/preview/model/HaisiPreviewModel.java:344-366` 与 `…/AmbaPreviewModel.java:366-422`。
- `pasttime` 单位：`AmbaPreviewModel` 与海思路径都**直接把整数塞进 `SSystemWorkState.pasttime`**，不做单位换算（`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:570`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:490`），显示层按秒格式化 → 与真机「Ambarella 半秒、该机型约 1 拍/秒」的现象一致（App 侧没有补偿代码）。
- `getcamerastatus.cgi` 解析要求同时出现 `count=` 与 `status=`，缺一返回 `null`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:142-169`）→ 真机回 200 空 body 即被判为「无状态」。
- NewAPP 方言工作模式串**必须带空格**（`"Normal Video"`/`"Normal Photo"`…，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:11-25`），`setcurworkmode.cgi?-workmode=` 走 `Uri`/`%20` 编码；无空格写法被固件回 `SvrFuncResult=0xFFFFF752(-2222)` —— 代码里对 `-2222` 的**唯一**处理是 `SSResponseParse.parseGetAllInfo(String)` 里 `if (message.contains("-222")) return null;`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:511-513`），也就是「当作没有状态」，不报错、不提示。
- **不存在 `getthumbnail.cgi`**：缩略图是 `GET http://<ip>/thumb<path>`（SigmaStar）或 `GET http://<ip>/<path 去扩展名>+".THM"`（海思）（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:83,87` + `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/HiDefine.java:26`）。

### 3.2 Ambarella（`H75N` / `CV75`）

全表见 **`02-XTUGO-档案-附录-Ambarella报文全表.md`**。结构性结论：

- **报文不是二进制，就是一段 UTF-8 JSON**。`SocketAmbaCmd` 直接把 `Gson.toJson(bean)` 的字节 `outputStream.write(str.getBytes())` 写出去，**没有任何魔术字、长度前缀、校验和、字节序处理**（`_work/xtu_bad/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:142`）。
- 请求体字段全集（Gson 按字段名序列化）：`msg_id`(int)、`token`(int，会话号)、`param`(String 或 int)、`type`、`workmode`、`name`、`value`、`start`、`end`、`path`、`size`、`offset`、`fetch_size`、`md5sum`、`sent_size`、`ssid`、`pwd`。基类见 `com/gku/module_camera/amba/bean/CmdRequestBean.java`。
- **分帧规则 = 累积到能被 Gson 解析**：`sb.append(new String(buf,0,n))`，每读一次就 `GsonUtils.isValidJson(sb.toString())` 试解析（`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:176,191`；`com/gku/base/utils/GsonUtils.java:7-17` 用 `JsonParser.parseString` 不抛异常即为「完整」）。收到但 `msg_id` 不匹配的、或当前无待发命令（`z==false`，此时 `setSoTimeout(10)` 做 10ms 轮询）的，走 `onPushMsgReceive` 推送回调并 `sb.delete(0,sb.length())`（`:225`）。
- 会话：连上后必须先 `msg_id=257 start_session`（`token=0`）→ 响应 `param` = sessionId → 再 `msg_id=261 set_clnt_info {type:"TCP", param:<手机在相机网段里的 IP>}`；两者都成功才算 `onSuccess`（`com/gku/module_camera/amba/connector/AmbaConnector.java:142-208`）。任何非 257 命令在 `sessionId<=0` 时本地直接失败 `-107`（`:240-246`）。`stopSession` 发 258，且发送后**主动关 socket**（`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:144`）。
- `msg_id=268435492 = MSG_ID_BLUETOOTH_HEARTBEAT`（「蓝牙心跳」）：**空 body 心跳**，由 `AmbaCmdModel.updateBTheartbeat()` 发（`com/gku/actioncam/amba/model/AmbaCmdModel.java:381-383`），触发条件在 `…/sigmastar/newUi/common/model/BTHeartbeatManage.java:18`：`type∈{H75N,"CV75"} && name.toUpperCase().endsWith("S7")`。
- 数据口 8787 是**裸字节管道**：`getFile` 先走命令口 1285（`{msg_id:1285,param:<path>,offset:0,fetch_size:0}`，响应给 `path`+`size`），再从 8787 连一次 socket 读 `size` 字节落盘，**无帧头**；65536 缓冲、`available()==0` 时睡 100ms、连续 30 次（3s）无数据判失败、进度每 +1% 回调（`com/gku/actioncam/amba/socket/DataChannel.java:146-239`、`…/connector/SocketAmbaDownload.java:72-104`）。
- 响应 `rval` 特判：`-444 LINK_REFUSE`→事件 137、`-4`→129、`-1`→136、`-34/-33/-18/-17`→135（`-17` 额外 Toast `R.string.sd_no_more_space`）；`"Read timed out"` 字符串→事件 128（`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:390-451`）。

### 3.3 SigmaStar / 海思共用二进制口 8080

全表见 **`02-XTUGO-档案-附录-SigmaStar8080与播放层.md`**。骨架：

- 上行 72 字节定长头：`[0..3] int32 LE cmd` + `[4..7] int32 LE 数据长度/路径长度` + `[8..71] 64 字节 UTF-8 路径`（`ByteBuffer.order(LITTLE_ENDIAN)` 的现代写法在 `com/gku/module_camera/hisi/SocketHisiFile.java` 的 `start()` 内；老写法是 `com.hisi.hisiFW.RegisterDeviceToServer(int,int,String)` 的 `toLH()` 手摆，`com/hisi/hisiFW/RegisterDeviceToServer.java:12-23,40-46`）
- 上行 200 字节（带 MD5）：72B 头之后 `[72..199]` 放 128 字节 MD5（`RegisterDeviceToServer.java:25-38`），用于固件推送（cmd=2）
- 下行 72 字节：`[0..3] cmd` + `[4..7] uint32 contentLength` + `[8..71] 64B 文件名`；随后是裸文件字节流
- **端序坑**：`DownLoadFileUtils.bytesToInt()` 是小端读法（`src[o] | src[o+1]<<8 | src[o+2]<<16 | src[o+3]<<24`，`…/sigmastar/data/connect/DownLoadFileUtils.java:214`），但老代码对负数长度做了 `((i>>>1)<<1)|1` 的怪异修正（`:183-192`）
- `SSVideoView` 的 17 条 ijk 播放参数（键=值全部列出）见同附录 §3

### 3.4 海思 App 侧回拨 ServerSocket 5678

| 维度 | 事实 | 证据 |
|---|---|---|
| 方向 | **相机 → 手机**（App 是 listen 端） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:32` `new ServerSocket(5678)`；`_work/xtu_src/sources/com/gku/module_camera/hisi/HisiSocketServer.java:73` `bind(new InetSocketAddress(5678))` |
| 触发 | App 起 `MessageService`（前台通知 id `10121`）后无条件 accept；`KeepAliveService` 另外跑 2000ms/5000ms 心跳 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:56-60`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java:19-24` |
| 报文 | 无格式约束：读满 ≤512 字节的流，直到 `read()<0`，整段按平台默认字符集转 String | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:93,104-123`（`RecvThread`，`soTimeout=3000`）；`HisiSocketServer` 版 `soTimeout=5000`（`:74`） |
| 转发 | 广播 `com.gku.xtugo.MESSAGE_ACTION`，extra 键 `"data"`；字符串本身是 `{"mode":"…";"state":"…";"event":"…";"pasttime":"…"}` 这种**手工拼的伪 JSON**（分隔符是 `;` 不是 `,`） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:18,124-127`；拼装处 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:313-316` |
| 生命周期 | 每条连接单独起 `RecvThread`；`onDestroy` 关 socket + `interrupt` 线程 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:34-45,75-90` |

---

## 4. 设置项全表

### 4.1 决定性事实：设置项是设备自描述的

XTU GO **没有**静态设置项表。运行时的项名、当前值、可选项**全部来自三条读命令**，UI 只做类型推断：

| 步骤 | 命令 | 解析 | file:line |
|---|---|---|---|
| 列出当前模式的一级菜单 | `GET /cgi-bin/hi3510/getprimarymenuitem.cgi?-workmode=<当前模式串>` | `getMap2` 取 `item` / `cur`，按 `,` 切成等长数组 | `…/dv/ui/data/SetDataUtils.java:41-59` |
| 列出系统级菜单 | `GET …/getprimarymenuitem.cgi?-workmode=System` | 同上，且 `cur` 末尾**人为追加 `",test"`** 占位 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:92-112` |
| 取某项的可选值 | `GET …/getsecondmenuitem.cgi?-workmode=<模式>&-name=<项名>` | 取 `item`（逗号切分）与 `cur`/`value` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:169-189,262-292,294-316` |
| 写 | `GET …/setcurparameter.cgi?-workmode=<模式>&-name=<项>&-value=<值>`（空格→`%20`） | 判据只看 200 | `…/dv/net/HttpProxy.java:241-256` |
| 系统项写 | `…setcurparameter.cgi?-workmode=System&-name=<项>&-value=<值>`（空格走 `Uri.encode(x,"utf-8")`） | 同上 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:258-272` |
| 读当前模式某项 | `GET …/getcurworkmode.cgi` → `getMap2` → 取 `workmode`/`value` | 值缺失时按模式名映射到固定项名 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:197-212` |

**UI 类型推断规则**（三种，`SettingItemModel` 的 type 字段）：

| type | 含义 | 判据 | file:line |
|---|---|---|---|
| 1 | 纯点击（无值） | `value=="" \|\| value==null` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:151-155` |
| 2 | 弹窗选择 | 值非空且非 ON/OFF；或值虽为 ON/OFF 但 `getsecondmenuitem` 回来 >2 个选项；或项名是 `"AV Out"`/`"Auto Dormant"`（强制）；或 `"Resolution"` 且当前值 ∈ {`720P100`,`720P200`,`1080P100`,`1080P200`,`720P120`,`720P240`,`1080P120`,`1080P240`}（关掉 `ImageStabilize` 联动） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:72-79,123-150` |
| 3 | 开关 | 值 ∈ {`ON`,`OFF`} 且 `getDeviceSupportParms(项).length <= 2`；或项名 ∈ {`Time Set`,`Auto Sync Time`}（值由本地 SP 决定，不是设备值） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:128-133,140-144` |

SigmaStar 侧另有一套（更严谨）：`SSResponseParse.parseGetPrimaryMenuItem(String)`，把 `cur` 的 `,,` 换成 `,-,`、首尾空位补 `-`，然后 `ON/OFF`→SWITCH、非空非 `-`→SELECT、其余→CLICK，并要求 `item.length == cur.length`（不等则整表返回 null，`String[]` 重载版本会**自动补 `,‑`**，`Response` 重载不会）（`…/sigmastar/data/SSResponseParse.java:384-465`）。

### 4.2 项名→资源/文案

**设备回的项名是英文（`en` 列），中文文案不在 APK 里，在相机的语言表里**：
- 海思/Amba 老机型：`/mnt/language.xml`（8080 拉取，存为 `<localAppDataPath>/<softversion>.txt`），DOM 节点 `<lanstr en="…" zh="…" zh_HK="…" …/>`，按 `Locale.getDefault().getLanguage()`（`HK` 时后缀 `_HK`）换列（`…/dv/ui/data/FileUtils.java:74-160`、`…/sigmastar/data/SSLanguageParse.java:9-33`、`…/dv/ui/data/connect/ConnectDevice.java:50-53,78-83`）
- SigmaStar：`/tmp/FL0/language.json`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:62-66`）
- Ambarella：`GET /tmp/FL0/language.json` via msg 1285+8787，Gson 解析成 `List<LangBean>`，以 `en` 建 map（`com/gku/module_camera/amba/connector/AmbaLangHolder.java:13,38-40,64-84`）

因此「菜单项文本资源 ID + 中文文案」这一项在 XTU 上**不成立**——它只有 `<softversion>.txt` 这份运行期文件。APK 内静态资源里能查到的只有以下**硬编码英文项名 + 它们触发的中文语义**：

| 硬编码项名（照抄） | 用途 | file:line |
|---|---|---|
| `"Resolution"` | 取当前模式分辨率表；触发 8 个特殊帧率值的防抖 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:72,279` |
| `"ImageStabilize"` | 唯一会改变 UI 状态的项（防抖） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:73,75` |
| `"AV Out"`、`"Auto Dormant"` | 强制走「选择」样式 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:123` |
| `"Time Set"`、`"Auto Sync Time"` | 强制走本地开关（不读设备值） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:128` |
| `"FLIP"` | 预览镜像；Amba 侧连上就预热读一次 | `_work/xtu_src/sources/com/gku/HomeActivity.java:765`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/ui/activity/SSDeviceSettingActivity.java:298`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:286` |
| `"Time Zone"` | Amba 同步时区，值 = `String.format("%+d", rawOffset/3600000)` | `_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:307,310-312` |
| `"Self-Timer"` | `TimerPhoto`/`Timing Photo` 模式的快设项 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:242`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:47-48` |
| `"Burst Number"` | `Burst` 模式的项名 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:245` |
| `"Number"` | `Lapse Burst` 模式；`Burst Photo` 的快设项 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:257`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:52-53` |
| `"TimeLapse"` | `PhotoLapse`/`VideoLapse` 的项名 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:248` |
| `"Time Lapse"` | 上两者的快设项名 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:49-51` |
| `"Duration"` / `"Video Duration"` | `Quick Stories` 按机型分：名含 `x2` → `Video Duration`，否则 `Duration` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:250-255`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:54-55` |
| `"Factory Reset"`、`"SD Format"`、`"Time Set"`、`"Wi-Fi"`、`"Information"` | 系统页固定 5 项 | `…/dv/ui/data/SetDataUIUtils.java`（项名字面量） |
| `System` | 系统级 workmode 名 | `…/amba/ui/setting/device_setting/AmbaDeviceSettingPresenter.java:30` |

### 4.3 老方言的设置项（这一套才是 APK 里有静态表的）

`res/xml/preferences.xml` 定义 PreferenceScreen 骨架，`Common.java` 定义每个 key，`Setting.java` 定义读写命令。key ↔ 标题 ↔ 写命令 ↔ 读命令 ↔ 选项数组：

| 键（`Common.KEY_*`，全串） | 标题资源 | 中文/默认文案 | 读命令 | 写命令 | 选项 entries / values | 默认值 |
|---|---|---|---|---|---|---|
| `key_master_mode_video_group` | `@string/master_mode_video` | — | — | — | — | 分组 |
| `key_master_mode_photo_group` | `@string/master_mode_photo` | — | — | — | — | 分组 |
| `key_master_mode_multi_group` | `@string/master_mode_multi` | — | — | — | — | 分组 |
| `key_mode_video_normal_group` / `…_photo_group` / `…_timelapse_group` / `…_slow_group` / `…_loop_group` / `…_multi_burst_group` / `…_multi_continuous_group` / `…_multi_timelapse_group` / `…_photo_single_group` / `…_photo_timer_group` / `…_photo_raw_group` | `setting_video_*` / `setting_multi_*` / `setting_mode_photo` | — | — | — | — | 分组（`Common.java:77-114`） |
| `key_mode_video_normal_resolution` | `@string/video_resolution` | Video Resolution | `getcapability.cgi?&-workmode=20&-type=0` | `setparameter.cgi?&-workmode=20&-type=0&-value=%s` | 设备返回 | — |
| `key_mode_video_loop_resolution` / `key_mode_video_timelapse_resolution` / `key_mode_video_slow_resolution` / `key_mode_video_loop_type` / `key_mode_video_timelapse_interval` | `video_resolution` / `loop_type`(="Loop Time") / `interval` | — | `getcapability`/`getparameter`，workmode 21/22/24，type 见 `Common.java:19-26` | `setparameter.cgi?&-workmode=%d&-type=%d&-value=%s` | 设备返回 | — |
| `key_mode_photo_single_resolution` / `key_mode_photo_timer_resolution` | `@string/photo_resolution` | Photo Resolution | `getparameter.cgi?&-workmode=0\|1&-type=0` | `setparameter.cgi…` | 设备返回 | — |
| `key_mode_photo_timer_time` | `@string/time` | Time | type=1 | 同上 | 设备返回 | — |
| `key_mode_photo_single_scene` | — | Scene | type=2 | 同上 | 设备返回 | — |
| `key_mode_multi_burst_resolution` / `key_mode_multi_burst_rate` | `photo_resolution` / `@string/rate` | — | workmode 10，type 0 / 1 | `setparameter` | 设备返回 | — |
| `key_mode_multi_timelapse_resolution` / `key_mode_multi_timelapse_interval` | 同上 / `interval` | — | workmode 11，type 0 / 2 | `setparameter` | 设备返回 | — |
| `key_mode_video_photo_*`（5 个） | — | Video+Photo 模式内 5 组 | workmode 23，type 2/3/4/5/6（`Common.java:20-24`） | `setparameter` | 设备返回 | — |
| `video_resolution` | `@string/video_resolution` | Video Resolution | `getvideoinfo.cgi?` → 键 `resolution`/`fps` | `setvideoinfo.cgi?&-resolution=%s&-fps=%d` | **`@array/video_resolution_entries_ntsc`** = `720P/30fps`, `720P/60fps`, `720P/240fps`, `1080P/30fps`, `1080P/60fps`, `1080P/120fps`, `4K2K/30fps` ／ **`@array/video_resolution_values_ntsc`** = `720P_30`, `720P_60`, `720P_240`, `1080P_30`, `1080P_60`, `1080P_120`, `4K2K_30`；PAL 版 entries = `720P/25fps`,`720P/50fps`,`720P/240fps`,`1080P/25fps`,`1080P/50fps`,`1080P/120fps`,`4K2K/25fps` ／ values = `720P_25`,`720P_50`,`720P_240`,`1080P_25`,`1080P_50`,`1080P_120`,`4K2K_25`（`res-strings-default.md:35-38`） | 无（`persistent="false"`） |
| `video_mode` | `@string/video_mode` | Video Mode（NTSC/PAL） | `getvideonorm.cgi?` → 键 `videonorm` | `setvideonorm.cgi?&-videonorm=%s` | `@array/video_mode_entries` = `NTSC`,`PAL` ／ `@array/video_mode_values` = `NTSC`,`PAL`（`:33-34`） | 未知 |
| `audio_codec` | `@string/audio_codec` | Audio（CheckBox） | `getaudioencode.cgi?`（`enable=1/0`） | `setaudioencode.cgi?&-enable=%d` | — | false |
| `image_upsidedown` | `@string/image_upsidedown` | 画面翻转 | `getflip.cgi?` | `setflip.cgi?&-enable=%d` | — | false |
| `time_tag` | `@string/time_tag` | 时间水印 | `gettimeosd.cgi?` | `settimeosd.cgi?&-enable=%d` | — | false |
| `boot_action` | `@string/boot_action` | 开机动作 | `getbootaction.cgi?` → 键 `action` | `setbootaction.cgi?&-action=%s` | **`@array/boot_action_entries`** = `Idle`, `Record`, `Timelapse Record`, `Loop Record`, `Slow Motion` ／ **`@array/boot_action_values`** = `idle`, `record`, `recordlapse`, `recordloop`, `recordslow`（`:14-15`）。注意 `Common.java:8-10` 只定义 3 个常量 `idle`/`record`/`timelapse`，与数组的 `recordlapse`/`recordloop`/`recordslow` **不自洽** | — |
| `screen_auto_sleep` | `@string/screen_auto_sleep` | 自动息屏 | `getscreenautosleep.cgi?` → 键 `time` | `setscreenautosleep.cgi?&-time=%d` | **`@array/screen_auto_sleep_entries`** = `OFF`,`1min`,`3min`,`5min` ／ **`@array/screen_auto_sleep_values`** = `0`,`1`,`3`,`5`（`:25-26`） | — |
| `set_datetime` | `@string/set_datetime` | 设置时间（点击型） | — | `setsystime.cgi?&-time=%04d%02d%02d%02d%02d%02d`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:248-253`）；NewAPP 版 `setsystime.cgi?-time=yyyyMMddHHmmss`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:277`） | — | — |
| `restore_settings` | `@string/restore_settings` | 恢复出厂（点击型） | — | `reset.cgi?`（**走 socket 直发、不等响应**，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:291-293,375-398`） | — | — |
| `sdcard_total` | `@string/setting_sdcard_total` | 卡总量 | `getsdstate.cgi?` → `sdstate`/`total`/`used`（`total`/`used` 去掉 `" MB"` 再 parseInt，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:107-115`） | — | — | — |
| `sdcard_left` | `@string/setting_sdcard_left` | 卡余量 | 同上 `used` | — | — | — |
| `delete_all_files` | `@string/delete_all_files` | 删除全部 | — | `deleteallfiles.cgi?` | — | — |
| `format_sd_card` | `@string/format_sd_card` | 格式化 | — | `sdcommand.cgi?-format&-partition=1` | — | — |
| `modify_dv_name` | `@string/modify_wifi_info` | 改 WiFi | `getwifi.cgi` | `/setwifi.cgi?&-wifissid=%s&-wifikey=%s`（socket 直发不等响应）；intent → `com.gku.actioncam.hisilicon.dv.ui.ModifyWifiActivity` | — | — |
| `about_camera` | `@string/about_camera` | 关于相机 | `getdeviceattr.cgi`（`name`,`serialnum`,`softVersion`,`hardVersion`,`type`） | — | intent → `AboutCameraActivity`，action `android.intent.action.tipactivity.aboutcamera` | — |
| `clear_cache` | `@string/clear_cache` | 清缓存 | — | 本地 | — | — |
| `download_video` / `file_download_save_path` / `preview_video` / `rec_setting` / `field_of_view` / `frame_rate` / `burst_rate` / `timelapse_interval` / `timer_count_down` / `spot_metering` / `led_flicker` / `buzzer_prompt` / `auto_shutdown` / `poweron_ui_mode` / `wifi_password` / `wifi_ssid` / `update_version` / `about_camera` | `Common.java:62-135` 全部 74 个 key | — | 见 §3.1 附录 | 见 §3.1 附录 | — | — |

`res/xml/settingpreferences.xml`（App 侧「设置」页，`SettingPreferActivity`）4 项：`about_app`(`@string/about_app`)、`setting_user_agreement`(`@string/text_title_user_agreement`)、`setting_privacy`(`@string/radio_text_4`)、`update_version`(`@string/update_version`)。

Ambarella/SigmaStar 机型的对应「项」不是 Preference，而是 §4.1 的动态菜单；但代码里存在 12 个 `CONFIG_MULTI_*` / `CONFIG_*` 索引常量（`Common.java:12-26`）作为 `getcapability/getparameter/getworkmode/setworkmode` 的 `type` 参数枚举 —— 全部值：`CONFIG_MULTI_RESOLUTION=0`、`CONFIG_MULTI_TIMELAPSE_INTERVAL=2`、`CONFIG_MULTI_BURST_RATE=1`、`CONFIG_MULTI_CONTINUOUS_RATE=3`；`CONFIG_PHOTO_RESOLUTION=0`、`CONFIG_PHOTO_TIMER=1`、`CONFIG_PHOTO_SCENE=2`；`CONFIG_VIDEO_VIDEO_RESOLUTION=0`、`CONFIG_VIDEO_TIMELAPSE_INTERVAL=1`、`CONFIG_VIDEO_PHOTO_SNAP_MODE=2`、`CONFIG_VIDEO_PHOTO_SNAP_INTERVAL=3`、`CONFIG_VIDEO_PHOTO_PHOTO_RESOLUTION=4`、`CONFIG_VIDEO_PHOTO_VIDEO_RESOLUTION=5`、`CONFIG_VIDEO_PHOTO_MODE=6`、`CONFIG_VIDEO_LOOP_TYPE=7`。

**工作模式枚举值（老方言 `WORK_MODE_*`）** —— `Common.java:149-162`：`WORK_MODE_PHOTO_SINGLE=0`、`WORK_MODE_PHOTO_TIMER=1`、`WORK_MODE_PHOTO_RAW=2`、`WORK_MODE_MULTI_BURST=10`、`WORK_MODE_MULTI_TIMELAPSE=11`、`WORK_MODE_MULTI_CONTINUOUS=12`、`WORK_MODE_VIDEO_NORMAL=20`、`WORK_MODE_VIDEO_LOOP=21`、`WORK_MODE_VIDEO_TIMELAPSE=22`、`WORK_MODE_VIDEO_PHOTO=23`、`WORK_MODE_VIDEO_SLOW=24`、`WORK_MODE_VIDEO_QUICK=25`、`WORK_MODE_VIDEO_LAPSE_BURST=26`；`WORK_MODE_NOMAL_VIDEO="NormalVideo"`（拼写就是 `NOMAL`）。`MASTER_MODE_PHOTO=0 / MULTI=1 / VIDEO=2 / PLAY=3`（`:136-139`）。

---

## 5. 操作复现表

见 **`02-XTUGO-档案-附录-操作复现表.md`**（逐操作：连接、预览起流、录像/拍照/连拍/延时/慢动作、切模式、回放列表/缩略图/下载/删除、格式化、改 WiFi 名与密码、二维码配网、蓝牙扫描与配网、GPS 叠加、滤镜、抖音直播、远程观看、固件升级、重启；每项含「按顺序发什么/参数值/成功判据/失败提示资源 ID + file:line」）。

---

## 6. assets 里的协议数据

| 路径 | 字节 | 内容 | 谁在用 |
|---|---|---|---|
| `assets/menu/LZXCAM` | 10471 | **JSON（CRLF 换行）**，一台 `devicename="LZX"` / `company="goodcam"` / `support="http://www.goodcam.net"` / `chip":2` / `firmware":"V0.0.0"` 的**猎trail/记录仪相机**菜单描述。顶层键：`modify_on,firmware,devicename,version,support,company,logo,download,chip,International`。`International` 是 `[{Language, section_array:[{orderNo,row_array:[{isQuickSettings,orderNo,title,cmd,paramValue,type,list}]}]}]` 的嵌套，`cmd` 是 **4 位十进制字符串**（如 `9001` 监控工作模式、`1002` 拍照分辨率、`9007` 拍照张数、`2002` 录像分辨率），`title` 是中文 | **没有任何代码引用**。全树 `grep "LZXCAM\|menu/"` → 0；`getAssets().open` 只有 4 处（`…/dv/ui/data/CopyFileUtils.java:124`、`com/gku/base/utils/FileUtils.java:127,462`、`…/base/utils/IOUtils.java:380`、`com/gku/ffm/zqvideo/utils/RawDataSourceProvider.java:74`），且都由参数传路径，参数里没有 `menu/…` | **死数据**（从 `m.mifan` 的 goodcam 方案模板里带过来的），不属于 XTU 运动相机协议 |
| `assets/menu/ly_menu.json` | 2790 | JSON，顶层 `preferences:[{note,name_trn,cmd,ui,…}]`。`cmd` 同样是 4 位数字，`ui ∈ {UIList,UITimePicker,UITimerRecord,UICustom,UISwitch,UIInput,UIWifiSet,UISDFormat,UIReSet}`；`note` 是中文（`模式/拍照分辨率/拍照张数/录像分辨率/录像长度/PIR间隔/PIR灵敏度/IRLED/定时拍摄/监控时段/录影音频/时间格式/日期标签/相机名称/设置WiFI/自动关闭WIFI/格式化/默认设置/剩余空间`），`name_trn` 是 `cam_setting_*` 翻译键，相机名称项还带 `digits`(字母表) 与 `maxLength":"12"` | 同上，**0 引用**，死数据 |
| `assets/litepal.xml` | 1759 | `dbname=video_cut`，`version=1`，`<list><mapping class="com.gku.actioncam.sigmastar.videoedit.AudioDbBean"/></list>`，未写 `<storage>`（=internal） | `LitePal.initialize(this)`（`com/gku/BaseApplication.java:55`）；表结构见 §11 |
| `assets/angle.ms` / `corner.ms` / `detect.ms` | 125968 / 380592 / 679056 | 二进制 ML 模型 | **用途确定**：华为 **ScanKit**（文档扫描）的三个模型 —— `com/huawei/hms/scankit/p/m1.java:39-41` 分别 `y4.c(ctx,"detect.ms")`、`y4.a(ctx,"angle.ms")`、`y4.b(ctx,"corner.ms")`。与相机无关 |
| `assets/ae/GNaviConfig.xml`、`ae/res.ck`、`ae/res.zip`、`map_assets/*`、`icons_assets/*`、`arrow/*`、`cross/*`、`amap_sdk_shaders/*.glsl`、`amap_resource1_0_0.png`、`eagle_eye_*.png`、`AZURE/BLUE/CYAN/GREEN/MAGENTA….png`、`grs_sp.bks`、`hmsincas.bks`、`hmsrootcas.bks` | — | 高德地图 SDK v10.0.600 的资源 + 华为 HMS 根证书 | 高德仅被 `TrackActivity`（GPS 轨迹页）使用（§10） |
| `assets/ap.data` / `ap1.data` | 1653 / 1652 | 二进制 | 字节码加密/插件清单类资源（volcengine zeus / 高德），无协议意义 |
| `assets/activate.html`、`title_condition(_en).html`、`xtugo_privacy_(cn\|en).html`、`xtugo_useragreement_(cn\|en).html`、`normalize.css`、`style.css`、`cncity.txt` | 14274… | 本地兜底 HTML（激活页、条款、隐私、用户协议）与城市拼音对照 | 隐私/协议 URL 的离线兜底（在线版 `https://device.gkuvision.com/static/xtugo_privacy_cn.html` 等，`com/gku/module_my/ConstantsMy.java:10-16`） |
| `assets/dexopt/baseline.prof` / `.profm` | 5546/354 | ART baseline profile | 无关 |

---

## 7. native 层

### 7.1 库清单与角色（31 个 `.so`，`natives.md:11-41`）

| 库 | 角色 | 谁加载 | 是否参与相机协议 |
|---|---|---|---|
| `libijkplayer/ijkffmpeg/ijksdl.so` | ijkplayer（RTSP/HLS 预览与回放） | `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:956`、`…/playback/remote/video/AmbaRemoteVideoActivity.java:180` 显式 `System.loadLibrary`/日志 | **是**（`SSVideoView`/`VideoView` 的全部 setOption 最终落在这里） |
| `libAMapSDK_MAP_v10_0_600.so` | 高德地图（155 个 `Java_com_autonavi_base_ae_gmap_*` 导出） | `TrackActivity`（`import com.amap.api.maps.AMap/MapView/CoordinateConverter`，`…/dv/localimage/TrackActivity.java:23-32`） | 否（只画 GPS 轨迹） |
| `libgpuimage-library.so` | GPUImage 滤镜（2 个 `Java_jp_co_cyberagent_android_gpuimage_GPUImageNativeLibrary`） | 图片编辑（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditEffectActivity.java:150-246` 的 FilterType 分派） | 否（后期编辑） |
| `libcontrol.so`（160 JNI）、`libpanorama_vr.so`（105）、`libreliant.so`、`libusb_transport.so`（31）、`libdepth_net_transport.so`（5） | **iCatch SDK**：`com_icatchtek_control_core_jni_JCamera{Property,Control,Assist,Config,Info,Log,Playback,Session,State,Util}`、`com_icatchtek_pancam_core_jni_J{Pancam,Stream,Surface}*`、`com_icatchtek_reliant_core_jni_JUsbTransport*` | `com/gku/dashcam/icatch/**` 与 `m/mifan/acase/icatch/**` | **只服务 XTU Mini1 记录仪**（PTP over USB / WiFi）；运动相机三条栈不碰它 |
| `libscannative.so`（9 JNI，含 `com.huawei.hms.scankit.util.OpencvJNI`） | 华为 ScanKit 文档扫描 | 华为 ML Kit | 否 |
| `libBugly_Native.so`、`libEncryptorP.so`、`libapminsighta.so`、`libapminsightb.so`、`libmmkv.so`、`libzeus_direct_dex.so`、`libzeusflipped.so`、`libc++_shared.so` | 崩溃上报 / 加密 / APM Insight / MMKV / volcengine zeus 插件 / C++ 运行时 | 各 SDK | 否 |

`Java_*` 反解后与 Java 声明的对应：全部 467 个导出中，非高德的 312 个**没有一个**声明在 `com.gku.*` 里 —— 厂商 Java 侧的 `native` 方法只出现在 ijkplayer（`tv.danmaku.ijk.media.player.IjkMediaPlayer`）与 GPUImage，其余 `Java_com_icatchtek_*` 对应 `com/icatchtek/**`（公版 SDK）。**结论：XTU 的相机控制面 100% 在 Java（HTTP/TCP），没有任何私有 native 协议**。

### 7.2 `.so` 内嵌协议字符串逐条判定（`natives.md` §库内协议相关字符串 + `natives-strings.tsv`）

| 字符串 | 所在库 | 判定 |
|---|---|---|
| `rtsp://` | `libijkffmpeg.so`、`libpanorama_vr.so` | **真在用**（Java 侧拼 `rtsp://<ip>:554/livestream/12` 交给它） |
| `127.0.0.1` | `libcontrol.so`、`libpanorama_vr.so`、`libreliant.so` | **死字符串 / 仅本地代理与日志**，不是相机地址（相机是 `192.168.0.1`） |
| `234.168.168.168` | `libcontrol.so` | iCatch 设备发现组播（与 `com/icatchtek/control/core/CoreMulticast.java:15` 一致）；**只服务 Mini1** |
| `224.2.127.254`、`228.67.43.91` | `libpanorama_vr.so` | iCatch 全景相机组播/默认值，XTU 未用（无全景机型） |
| `1.1.1.1`、`3.8.11.1` | `libAMapSDK_MAP…so` | 高德内部 DNS/版本号，与相机无关 |
| `4.1.9.3` | `libBugly_Native.so` | Bugly 版本号 |
| `?authmod=%s&user=%s[&challenge=…&nonce=…&cnonce=…&nc=…]`、`?reason=needauth|authfailed|nosuchuser`、`?connect=1`、`?localport=%d`、`?ttl=%d`、`?timeout=%d` | `libijkffmpeg.so` / `libpanorama_vr.so` | **RTSP/HTTP 内建能力，未启用** —— Java 侧拼的 URL 不带任何 auth/参数（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:49-51`），相机也从不要求 |
| `http://m5.amap.com/`、`mpsapi.amap.com/ws/mps/{vmap,rtt,smap,lyrdata/ugc}`、`maps.testing.amap.com/…` | 高德库 | 高德真实在用（TrackActivity 出图时会走）；`maps.testing.*` 是 SDK 内置测试域名 → **死字符串** |
| `https://www.googleapis.com/oauth2/v4/token`、`/youtube/v3/liveBroadcasts…`、`/liveStreams…` | `libpanorama_vr.so` | iCatch 全景 App 的 YouTube 直播模块，XTU 里 **完全死代码**（Java 无引用） |
| `[%s, %d][AES KEYS]Invalid AES Encrytion key(16bits), using default key` | `libcontrol.so` | iCatch PTP 层的 AES key 检查 —— 只影响 Mini1；XTU 运动相机链路**零加密** |
| `setsockopt/socket/accept/connect/recvfrom/sendto/inet_pton/getsockname/listen` | 各库 | libc 导入，非协议常量 |

---

## 8. 第三方 SDK 面

全部初始化常量、上报域名与「真在用/死字符串」判定见 **`02-XTUGO-档案-附录-权限组件与域名.md` §3**。摘要：

| SDK | 常量 | 判定 |
|---|---|---|
| 腾讯 Bugly | `BuildConfig.BuglyId="0324406337"`（`com/gku/xtugo/BuildConfig.java:5`）；`CrashReport.initCrashReport` 在 **WelcomeActivity 才调**（`…/dv/ui/WelcomeActivity.java:93,104,156,175-176` → `com/gku/crashhandle/CrashReportManager.java:14-45`）；`UserStrategy` 读 `Settings.Secure "android_id"` 同时当 `userId` 与 `deviceID`，`appChannel` 读 `meta-data "UMENG_CHANNEL"` | **真在用**（native 侧 `libBugly_Native.so` 4.1.9.3）。但 manifest 里 **没有任何 meta-data**，`UMENG_CHANNEL` 必然抛异常 → `NameNotFoundException` 被包成 RuntimeException（潜在崩溃点） |
| 阿里 OSS（`com.alibaba.sdk.android.oss` + `com.aliyun.oss`） | 无硬编码 endpoint/bucket；STS 由服务端下发 | **真在用**：`_work/xtu_src/sources/com/gku/HomeActivity.java:859` `new OSSClient(this, data.getEndpoint(), new OSSStsTokenCredentialProvider(data.getAccess_key(), data.getAccess_secret(), data.getSecurity_token()))`；token 从 `com.gku.rxt.net.AppService` 拿。`com.aliyun.oss.internal.OSSConstants.PROTOCOL_HTTP`（="http://"）被厂商代码**当成字符串常量到处拼 URL**（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:311`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:143,181`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:332`），只是巧合复用 |
| 友盟 | **不存在**。只在 `_work/xtu_src/sources/com/gku/crashhandle/CrashReportManager.java:32` 读了一个 `UMENG_CHANNEL` meta-data | **死代码**（清单里无 meta-data、无 umeng 类） |
| APM Insight（`libapminsighta/b.so`） | 无 Java 侧配置 | 华为/第三方性能探针，随包携带，**未见 Java 初始化** |
| 字节 volcengine / zeus（`libzeus_direct_dex.so`、`libzeusflipped.so`） | 清单注册了 `com.volcengine.zeus.provider.MainProcessProviderProxy`、`FileProvider`，`com.byted.live.lite.ServerManager_bytelive`/`_push`、`com.byted.broadcast.lite.ServerManager_{bytelive,push,downloader}`、`com.bytedance.android.openliveplugin.process.server.LiveServerManager`，跨 `:bytelive` / `:push` / `:downloader` 三个进程 | **真在用**（抖音直播插件进程） |
| 抖音 OpenLive（`com.bytedance.android.openlive.broadcast`） | `DouYinSDK.getInstance().init(new SdkInitConfig.Builder(app, "780679", "XTU GO", BuildConfig.VERSION_NAME, 243L).isDebug(true) …)` | **真在用**，仅 Ambarella 机型可用：`com/gku/actioncam/amba/ui/stream/DouyinStreamController.java:158`。`isDebug(true)` 在 release 包里 |
| 高德地图 | 无 `com.amap.api.v2.apikey` meta-data；资源 `amap_*`/`map_assets/`/`ae/` 齐备 | **半死**：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:23-32` 用 `AMap/MapView/CoordinateConverter`，但**清单没给 key** → 线上取图会鉴权失败。另 `LocationUtil` 实际用 **Google Play Services** `FusedLocationProviderClient`（`com/gku/base/utils/LocationUtil.java`），与高德并存 |
| HMS / ML Kit / ScanKit / AGConnect | `grs_sdk_server_config.json`(`grs_base_url`: `https://grs.dbankcloud.com`,…)、`grs_sdk_global_route_config_mlkit.json`、`hmsrootcas.bks` | 清单注册 `com.huawei.hms.mlsdk.common.provider.MLInitializerProvider`、`com.huawei.agconnect.core.provider.AGConnectInitializeProvider`。**仅文档扫描（`*.ms` 模型）**，相机功能不依赖 |
| ExoPlayer / IJK / GSY(`com/gku/ffm/zqvideo`) / videocache / MMKV / xUtils / EventBus / Hilt / ARouter / OkHttp / Retrofit / Gson / Glide / LuckPicker / AndroidVideoCache / commons-{lang3,text} / ini4j / Apache HTTP | — | 均为实现依赖；`com.alibaba.android.arouter.utils.Consts.DOT`、`org.ini4j.Registry.LINE_SEPARATOR`、`com.google.android.exoplayer2.*` 常量被厂商代码**当字符串常量复用**（`HttpRequest.java:113`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:395`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:100-103`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:514` 用 `IjkMediaMeta.IJKM_KEY_BITRATE`="bitrate" 作 CGI 键名）—— 这是**必须照抄**的隐式依赖 |

**后端域名清单**（全表 + 判定在同附录 §3）：`https://server4.gkuvision.com`（App/固件版本与账号后端，`com/gku/module_base_xtugo/BuildConfig.java:8`、`com/gku/loginmodule/network/NetworkApi.java:44`、`…/upgrade/app/UpgradeViewManager.java:648`、`…/firm/Presenter/UpgradePresenter.java:165`）、`http://121.40.107.215:8041/firmware/[info.json]`（**裸 IP + 明文 HTTP**，`…/sigmastar/upgrade/app/UpgradeTaskManager.java:35,843` 与 `…/dv/updateapp/UpgradeManager.java:35,843`）、`http://www.gkuvision.com:8882/upload/update.xml` + `http://api.shhc-yh.com[/api/]` + `http://api.dashcamplayer.net/api/aliyun/uptoken`（`com/gku/rxt/net/AppService.java:22-24,97`）、`https://device.gkuvision.com/static/…`（`_work/xtu_src/sources/com/gku/module_my/ConstantsMy.java:10-16`）、`support@xtucam.com` / `yangzihe@xtucam.com` / `techsupport@gkuvision.com`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/userCenter/ui/activity/QuestionDescription.java:177-230`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/setting/AboutClientActivity.java:147-149`）。

---

## 9. 数据存储

### 9.1 LitePal（唯一的「建表」声明）

`assets/litepal.xml`：`dbname="video_cut"`、`version="1"`、`<mapping class="com.gku.actioncam.sigmastar.videoedit.AudioDbBean"/>`，未声明 `<storage>`（默认 internal，即 `/data/data/com.gku.xtugo/databases/video_cut.db`）。初始化在 `BaseApplication.java:55`。用途：**视频编辑的配乐素材库**（`AudioDbBean` 被 `com/gku/actioncam/sigmastar/videoedit/AudioCollectActivity.java` / `VideoEditActivity` 使用）。全库**只有这一张 LitePal 表** —— 相机/固件/文件信息不进数据库。

### 9.2 Room（`AppDatabase`）

`BaseApplication.java:53-54`：`NetworkApi.init(new NetworkRequiredInfo(this)); db = AppDatabase.getInstance();`（`com/gku/loginmodule/db/AppDatabase`）。用途是**账号/反馈/公告/收藏**这类 App 业务，与相机协议无关。另有 SQLite 直用：`…/newUi/album/Utils/FavoriteDatabaseHelper.java`（收藏表）、`com/gku/base/utils/…` 与 `com/gku/module_base_xtugo/sqlite/*`。

### 9.3 SharedPreferences

**没有自定义文件名的 SP**（除两处例外），全部落在 `getSharedPreferences(context.getPackageName(), MODE_PRIVATE)` → `com.gku.xtugo.xml`：

| 文件 / 键 | 值 | 出处 |
|---|---|---|
| 文件 `"File"` | 设备管理页本地状态 | `…/dv/devicemanage/DeviceManageActivity.java:177` |
| 文件 `"SaveSsidAndPwd"` | `StringSet`，按 name 存 SSID/密码 | `…/dv/ui/data/SharedPreferencesUtils.java:26,33` |
| `HasUpdate`(bool,默认 true) / `NeitherShow`(false) / `OnCreateHasRun`(true) | 升级弹窗抑制 | `SharedPreferencesUtils.java:52,57,62` |
| `LastWIFIRefreshed`(long,-1) / `LastWIFIList`(String,"") | WiFi 列表缓存 | `:74,86` |
| `RTMPBean`(JSON String) | 直播参数快照（`ssid/pwd/live_type/res/fps/bitrate/rtmp_url/roomId`） | `:105`；`…/amba/ui/stream/BroadcastDouyinFragment2.java:947` |
| `LiveStatus`(String,"") | 直播状态机 | `:114` |
| `isAutoUpdateDevice`(bool,true) | 自动升级开关 | `:126` |
| `modelName`(String) / `softVersion`(String) / `isAmba`(bool) | 上次连接的设备；Amba 上报名会 `split("-")[0]` 再存 | `_work/xtu_src/sources/com/gku/HomeActivity.java:748-751, 1765-1771` |
| `bt_pin<蓝牙设备名>` | BLE 配对码（**明文**，配合 `allowBackup=true` 可被导出） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:906,909` |
| 语言表缓存 | 不是 SP，是文件：`<localAppDataPath>/<softversion>.txt`（海思 XML / SigmaStar JSON 都写这个名）；Ambarella 写 `<externalCacheDir>/language.json` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ConnectDevice.java:78-83`、`SSConnectDevice.java`（`initData`）、`_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaLangHolder.java:44` |
| 其它缓存目录 | `/mnt/sdcard/Android/data/com.gku.xtugo/cache/`（`SSConstant.LOCAL_THUMB_CACHE_DIR`）、`/mnt/sdcard/DCIM/ActionCam/`（`SSConstant.LOCAL_DOWNLOAD_DIR`）、`/sdcard/JKHardVersion/`、`/mnt/sdcard/xtu_exception.txt` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:10-11`；`signals-fsPaths.tsv` |
| 下载落地路径 | `/DCIM/xtugo/photo/ActionCam/`、`/DCIM/xtugo/video/ActionCam/`、`…/video/ActionCam/sd/`、`/DCIM/xtugo/{photo,video}/DashCam/`、`/DCIM/xtugo/{photo,video}/` —— 由 `BuildConfig.APPLICATION_ID.split(".")[2]` 动态得 `xtugo` | `Common.java:170-176` |

从 `signals-keyLike.tsv`（536 条）与代码双查后，**排除掉 JSON 字段名与 CGI 键名**，剩下的配置键全集就是上表；`keyLike` 里其余条目分属：CGI 响应键（`mode/state/event/pasttime/item/cur/workmode/value/capacity/charge/ac/sdstate/total/used/fov/count/time/brightness/uimode/videonorm/bitrate/wifichannel/devcapabilities/action/param/rotation/filelist/fileinfolist/ssid/pwd/BluetoothDevOne/BluetoothDevTwo/path/size/duration/resolution/media_type/thumb_file/startdate/runtimes/model/timeout/networkstatus/bluetoothrxversion/bluetoothtxoneversion/bluetoothtxtwoversion/region/pcbrevision/serialnum/softversion/hardversion/type/name`）、Amba JSON 报文键（`msg_id/token/rval`）、SP 键（上表）、iCatch/volc 内部键。

---

## 10. 未解之谜

| # | 问题 | 为什么静态定不来 | 补证手段 |
|---|---|---|---|
| 1 | 每个 CGI 家族机型的**具体芯片**（X1/X2/X3/S2/S3/S3PRO/S5K/MAX2/MAX3/MAXPRO/S6/R1 到底报 `SSC88xx` 还是 `Hi3519DV500` 还是别的） | 分派键是设备自报的 `type`，APK 里根本没有型号→芯片表（§2.2） | 逐台连上 `GET /cgi-bin/hi3510/getdeviceattr.cgi`，抄 `type` + `hardversion` |
| 2 | NewAPP 机型 `getprimarymenuitem.cgi` 的**完整项名清单**与每项的合法值 | 项名/可选值全部由设备返回，语言表也在设备上（§4.2） | 在 S7PRO 上逐模式 `getprimarymenuitem.cgi?-workmode=<每个模式>` + `getsecondmenuitem.cgi`，把 `item`/`cur`/`<softversion>.txt` 全量导出 |
| 3 | `pasttime` 的**每机型单位** | App 侧零换算（§3.1），无法从代码判定 | 同一动作分别计时：`getcurallinfo.cgi` 轮询 vs 秒表；至少覆盖 Ambarella 机型与 Hi3519DV500 |
| 4 | `SvrFuncResult` 的**完整错误码表** | 代码里只出现 `-2222`(0xFFFFF752)、`"sd is not ready"`、`"sd is full"` 三种处理（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:40-48`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:511`），其余全走 `Integer.parseInt` 后原样返回，无文案映射 | 逐命令制造失败（拔卡/满卡/忙/非法值），抓 `SvrFuncResult` 全量；再对照 `Common.java:28-39` 的 11 个 `ERR_*` 负数码 |
| 5 | `Common.ERR_*` 的 11 个魔数（`-1560182774…-1560182784`、`-1610579967`）到底谁回 | 它们是海思 SDK 的错误码，**当前 CGI 路径里没有任何一处生成它们**（`Command.executeCommand` 只做 `Integer.parseInt`） | 老机型（非 NewAPP）上执行非法命令，看 `SvrFuncResult` 是否就是这些数 |
| 6 | 5678 回拨的**报文生成方** | App 只 accept + 广播（§3.4），无发送方代码 | 手机侧抓包（`tcpdump`/mitm 于相机 AP 网关），让相机录像 30s 看是否推 `pasttime`；同时看是否只有 `getCameraCurrentInfor` 那条主动轮询路径被实际使用 |
| 7 | `getactivateinfo.cgi` / `setactivateinfo.cgi` / `settrial.cgi` 的字段语义（`status/number(默认 5)/macaddr/version`） | 只 S7PRO/S7PRO MAX 会调（`_work/xtu_src/sources/com/gku/HomeActivity.java:1714-1739`、`HttpRequest.java:52-55,242-329`），其它机型不触发 | 连未激活的 S7PRO，依次 `getactivateinfo` → `settrial` → `setactivateinfo?-status=1&-version=<v>` 看返回 |
| 8 | `CameraSocketService`、`SSMessageService` 为何在清单里 | 两棵树 18195 文件 + 全树 grep 均 0 命中 → 类不存在 | 反编译 `AndroidManifest` 比对 `classes*.dex` 的类名表（`dexdump`/`apkanalyzer dex packages`）即可坐实「R8 删类未删清单」 |
| 9 | `CALL_PHONE` / `BLUETOOTH_ADVERTISE` 的实际入口 | 申请了但未见 `ACTION_CALL`/`startAdvertising` | 走一遍 UI（反馈页/客服页/蓝牙 TX 页 `SSBluetoothTXActivity`）看是否触发权限弹窗 |
| 10 | 高德轨迹页在**无 API key** 下是否能出图 | 清单无 `com.amap.api.v2.apikey`（`manifest.md` §7 meta-data 表为空） | 装机后打开「轨迹」页看日志鉴权错误；或从 `res/raw`/`assets` 找隐藏 key |
| 11 | `assets/menu/{LZXCAM, ly_menu.json}` 的 4 位 `cmd` 协议是否被任何分支用到 | Java 0 引用（§6） | 拉 `m/mifan/acase/core/HttpProtocol` + `cn.rxt.qscase` 全链复核，或抓 iCatch 记录仪侧报文 |
| 12 | 127 个 jadx 失败类里是否还有协议关键类 | 只补了 `SocketAmbaCmd$1.run()` | `_work/xtu_bad/` 已含同 APK 的 show-bad-code 版；按 `xtu_jadx.log` 的错误清单逐个交叉核对 |

---

## 11. 对既有文档的纠正

| 原说法（文档:位置） | 现有证据 | 建议改法 |
|---|---|---|
| `docs/03 §2` 「SSID 前缀正则」 | 全树无 `Pattern.compile` 用于 SSID；判定只有 `contains("XTU")`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bluetooth/ui/PopupDialogActivity.java:199`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/DeviceAddDeviceListFragment.java:315`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java:493`）；BLE 侧才是 `toUpperCase().startsWith("XTU_")`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:473`） | 保留 `docs/03:316` 的 NOT FOUND 结论；把「SSID 前缀正则」的措辞改成「子串包含 `XTU`」，并明确 BLE 名与 WiFi SSID 是两套规则 |
| `docs/03 §2 型号表` 第 12 行 XTU R1「未知平台，仅共用图标」 | 补充证据：`_work/xtu_src/sources/com/gku/loginmodule/utils/CameraInfoUtils.java:47-49` 与 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/ScanAddRecycleAdapter.java:117` 都把 `XTUR1` 画成 S6Pro 的图；两处都**不做平台判定**（平台只看 `type`） | 结论不变（未知），但注明「图标同源 ≠ 平台同源」这条推理已经复查过、仍是唯一证据 |
| `docs/03:806` 「XTU 的 Ambarella 也是 7878 命令 + 8787 数据双 socket，海思还有 8080 二进制帧与 5678 回拨」 | 全部证实，并补细节：8080 帧头 72B/200B、小端、64B 路径槽（`SocketHisiFile`、`RegisterDeviceToServer.java:12-38`）；5678 是 App listen、≤512B、无格式（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:19,104`） | 在 `docs/03` 里把 72B/200B 头字段偏移与 cmd 枚举（0=取文件，2=推固件）补进去 |
| `docs/03:821` 「XTU 官方 18 型号清单」 | 两份清单：反馈页 17 项（`_work/xtu_src/sources/com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java:211-227`，无 S3）+ 图标解析 18 项（`CameraInfoUtils.java`，含 S3） | 明确「18」来自 `CameraInfoUtils`（含 `XTUS3`），反馈页只有 17；两表 token 大小写不同（`XTUMax2` vs `XTUMAX3` vs `XTUS5k`） |
| 任务书/既有文档假设存在 `getthumbnail.cgi` | 不存在。缩略图是 `http://<ip>/thumb<path>`（SigmaStar，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:83`）或 `http://<ip>/<去扩展名>+".THM"`（海思，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:87` + `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/HiDefine.java:26`）；Ambarella 不走 HTTP 而走 msg 1025 + 8787（`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:352-363`） | 删掉 `getthumbnail.cgi`，按机型写三种缩略图取法 |
| `docs/03 §2` 「探测顺序：HTTP CGI 优先、Ambarella socket 兜底」 | 证实，且拿到精确行号：`_work/xtu_src/sources/com/gku/HomeActivity.java:1707-1783`（CGI）与 `:1776-1781`（回退 `AmbaConnector.startSession`） | 补上「先 `getdeviceattr.cgi`，失败才 startSession」的函数名与行号，并补 `guessDeviceIP()` 的 IP 取值链（`_work/xtu_src/sources/com/gku/HomeActivity.java:1853`；`_work/xtu_src/sources/com/gku/base/device/NetworkDeviceUtils.java:332-358`） |
| 「相机默认地址常量」只写了 `192.168.0.1` | 实际有 **6 个** 独立常量位（`CameraParameters.baseIp`、`CameraParmeras.baseIp`、`SSConstant.SS_IP`、`DV.defaultIP`、`FwUpload.HOST`、`IcatchCaseKt.API_HOST_ICATCH=192.168.1.1`） | 在 `docs/03` 的默认常量表里补齐，并强调 SigmaStar/海思代码路径**硬编码** `192.168.0.1` 而非读 `baseIp`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:57`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ConnectDevice.java:44`、`DownLoadFileUtils.java:31-32`、`FirmwareClientThread.java:64`、`HisiCameraAbout` 等）→ 换 IP 的机型在这几处会失效 |
| 「Ambarella 报文有长度前缀/字节序」 | **没有任何前缀**：请求就是 `Gson.toJson(bean).getBytes()`；响应靠「累积到能被 Gson 解析」判帧（`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:142,176,191`） | 把「分帧规则 = valid-JSON-accumulation」写成唯一规则，删去任何「长度前缀」暗示 |
| `docs/03 §2` 「`pasttime` 单位半秒」 | 代码零换算（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:490,505,525`、`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:570`）；单位差异只体现在真机 | 改成「App 把 `pasttime` 原样当秒显示，Ambarella 上会差 2 倍」，并列入未解之谜 #3 |
| 设置项「APK 内有参数表」 | 没有。参数表是 **设备自描述 + 运行期语言表**；APK 里唯一静态表是老方言的 `res/xml/preferences.xml` + 6 个 `R.array`（§4.3） | 把 §4.3 这张「老方言静态表」补进 `docs/03/04`，并注明 `boot_action_values` 与 `Common.BOOT_ACTION_*` 不自洽（数组有 `recordlapse/recordloop/recordslow`，常量只有 `idle/record/timelapse`） |
| 「预览起流」统一写 `rtsp://ip:554/livestream/12` | 还有 HTTP 版 `http://ip:80/12?trans=tcp&action=play&media=video_data`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:332-341`），且 **12 会切成 11**（`isPreviewBigBitRate()`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:119`）；RTSP 传输按 `type` 选 udp/prefer_tcp（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java:603-607`） | 在 `docs/05` 的预览条目里补两条 URL + 码流开关 + 传输选择规则 |
| 「友盟 SDK」在第三方清单里 | 全树无友盟 SDK 类，只有 `_work/xtu_src/sources/com/gku/crashhandle/CrashReportManager.java:32` 读了一个不存在的 `UMENG_CHANNEL` meta-data | 从第三方 SDK 面里删除「友盟」，改为「Bugly（在用）；友盟仅剩一个 meta-data 读取残留」 |
| 「219 个组件里厂商自有组件」 | 精确拆分：`com.gku.*` = 107（100 activity + 6 service + 1 provider）；含 iCatch/`cn.rxt`/`com.example`/`m.mifan` = 117；**其中 2 个 service 是清单幽灵**（`CameraSocketService`、`SSMessageService`）；唯一导出的厂商组件是 `GKUCamPlayer`（`exported=true`）与启动器 `WelcomeActivity` | 按此数字与幽灵结论更新 `docs/01`/`docs/03` 的组件统计 |
| 38 条权限「逐条有用途」 | 12 条**完全没有代码引用**：`READ_PRIVILEGED_PHONE_STATE`、`MANAGE_MEDIA`、`GET_ACCOUNTS`、`WRITE_MEDIA_STORAGE`、`MODIFY_AUDIO_SETTINGS`、`CHANGE_CONFIGURATION`、`READ_LOGS`、`SYSTEM_ALERT_WINDOW`、`GET_TASKS`、`FLASHLIGHT`（+ `ACCESS_MEDIA_LOCATION` 只由 Glide 检查、`BLUETOOTH_ADVERTISE`/`CALL_PHONE` 申请但未用） | 在 `docs/01`/`docs/05` 的权限表里加「死声明」标记，避免我们照着申请 |

---

## 目录

- [附录 A · 海思 CGI 全表](02-XTUGO-档案-附录-海思CGI全表.md)
- [附录 B · Ambarella 报文全表](02-XTUGO-档案-附录-Ambarella报文全表.md)
- [附录 C · SigmaStar 8080 帧与播放层](02-XTUGO-档案-附录-SigmaStar8080与播放层.md)
- [附录 D · 操作复现表](02-XTUGO-档案-附录-操作复现表.md)
- [附录 E · 权限、组件与域名](02-XTUGO-档案-附录-权限组件与域名.md)
