# XTU GO 8.4.3（`com.gku.xtugo`）穷尽式逆向档案

> **doc-id** `evidence/xtugo` · **层** 证据 · **状态** 权威：与结论层冲突时以本档案为准并回写 · **建档** 2026-09-22 · **修订** 2026-09-26
> 文档系统 [`docs/README.md`](../README.md) · 长表在本文下半部的「附录 A-E」

> 样本：`相机 app/XTU GO_8.4.3_243_2026-08-19-17-05-43.apk`
> 反编译源码：`_work/xtu_src/sources/`（18195 个 `.java`）；jadx 失败方法体：`_work/xtu_bad/sources/`
> 机器提取表：`data/xtugo/`（入库副本，目录说明见 `docs/evidence/method` §4）+ `_work/re/xtugo/`（原始大表，gitignore；重跑见 `tools/re/README.md`）（`api/*.md`、`own-constants.tsv`、`own-literals.tsv`、`signals-*.tsv`、`classes-all.tsv`、`packages.md`、`manifest.md`、`res-strings-*.md`、`assets-*.md`、`natives*.md/tsv`）
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

**这套代码是「一码多牌」的产物**：`CameraParameters` 里有 10 个 `APP_*` 常量（`APP_XTU=0`、`APP_YUTU=1`、`APP_LAMAX=2`、`APP_X9=3`、`APP_SUPERMO=4`、`APP_CADDX=5`、`APP_KBX=6`、`APP_UVEX=7`、`APP_YINGYAN=8`、`APP_CUTECAM=9`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:12-21`），XTU GO 只是 flavor=XTUGO 的那份。`SSExchangeWorkMode.workModeToResId()`（`com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:68-74`）按 `CURRENT_APP_TYPE` 走两套资源命名规则；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:170-176` 的下载目录用 `BuildConfig.APPLICATION_ID.split("\\.")[2]` 反推品牌段（XTU 下 = `xtugo`）。复现时**不要**把这些分支当 XTU 私有逻辑，但要知道 `APP_CADDX` 分支会改写工作模式名（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:90-113`）。

### 1.2 `<application>` 属性与实际后果

| 属性 | 值 | 后果（本 App 语境） |
|---|---|---|
| `name` | `com.gku.BaseApplication` | `@HiltAndroidApp`；`onCreate` 顺序：`LogSaveUtils.open` → `x.Ext.init` → `NetworkDeviceUtils.init` → `CrashHandler.catchException(.../logs)` → `NetworkApi.init` → `AppDatabase.getInstance()` → `LitePal.initialize` → `MediaStorage.init` → `LogEx.initLog("XUYGO", true, false)`。见 `com/gku/BaseApplication.java:41-57`。`XUYGO` 是日志 tag（另一品牌的残留） |
| `usesCleartextTraffic` | `true` | 相机侧全部是 `http://192.168.0.1/...`，必须允许明文；同时**放开**了 `http://121.40.107.215:8041/firmware/`、`http://www.gkuvision.com:8882/...`、`http://api.shhc-yh.com/...` 等全部明文 HTTP（见 `附录-权限组件与域名`） |
| `networkSecurityConfig` | `@xml/network_security_config` | 实际内容只有一行：`<base-config cleartextTrafficPermitted="true"/>`（`_work/xtu_res/resources/res/xml/network_security_config.xml`）。**没有任何 domain-config / certificate-transparency / pin 配置**，等价于「全局允许明文」。另有 `res/xml/network_config_base.xml` 未被 manifest 引用 |
| `allowBackup` | `true` | SharedPreferences + LitePal 库 + `/data/data/com.gku.xtugo` 可被 `adb backup` 导出，含 `bt_pin<设备名>` 这类配对码（§11） |
| `requestLegacyExternalStorage` | `true` | Android 10 上退回旧存储模型，因此 `Common.ACTION_CAM_DOWNLOAD_PATH_*`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:170-172`）这种 `/DCIM/xtugo/...` 绝对路径写法仍能用；Android 11+ 由 `MANAGE_MEDIA`/`READ_MEDIA_*` + MediaStore 兜 |
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

> `GKUCamPlayer`（`com.gku.gkucamplayer.GKUCamPlayer`）**exported=true** 且 `screenOrientation=fullSensor` —— 这是全 App 除启动器外唯一被导出的厂商组件，外部 App 可直接拉起它（安全风险点，见 §12 之外的安全评估在 `docs/analysis/network-api`）。

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
        │            Url 拼接：_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpRequest.java:52 + :98            BaseUrl 生成：_work/xtu_src/sources/com/gku/HomeActivity.java:1708
        │        解析：getMap()（要求 `var K="V";\r\n`）_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpRequest.java:354-407
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
| `Common.ICGI_PATH` | `"/cgi-bin"` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:61` |
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

完整命令表（两套方言、每个 CGI 路径/参数名/取值/单位/响应字段/解析行）见 **`docs/evidence/xtugo 附录A（海思 CGI 全表）`**。要点摘录：

- 老方言（`Setting.java` / `RemoteFileManager.java` / `Command.java`）里存在**字面带前导 `-` 的查询键**：`&-cmd=`、`&-type=`、`&-resolution=`、`&-fps=`、`&-fov=`、`&-enable=`、`&-time=`、`&-count=`、`&-action=`、`&-videonorm=`、`&-brightness=`、`&-uimode=`、`&-bitrate=`、`&-wifichannel=`、`&-workmode=`、`&-value=`、`&-name=`、`&-start=`、`&-end=`、`&-partition=`、`&-status=`、`&-wifissid=`、`&-wifikey=`、`&-ssid=`、`&-key=`、`&-version=`。它们必须**原样带 `-` 发**（`docs/analysis/network-api` 已记录，本次逐条到行确认）。
- `getcurallinfo.cgi` 响应字段：`mode`(String) / `state`(int) / `event`(long) / `pasttime`(int)（`SSResponseParse.parseGetAllInfo` `…/sigmastar/data/SSResponseParse.java:487-530`）。`state` 语义：**20=WORKING、21=STANDBY**，常量在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:23-24`（`CAMERA_STATE_WORKING_STR=20`、`CAMERA_STATE_WORKING_END=21`）与孪生 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParmeras.java:23-24`；用法见 `…/OldUi/preview/model/HaisiPreviewModel.java:344-366` 与 `…/AmbaPreviewModel.java:366-422`。
- `pasttime` 单位：`AmbaPreviewModel` 与海思路径都**直接把整数塞进 `SSystemWorkState.pasttime`**，不做单位换算（`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:570`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:490`），显示层按秒格式化 → 与真机「Ambarella 半秒、该机型约 1 拍/秒」的现象一致（App 侧没有补偿代码）。
- `getcamerastatus.cgi` 解析要求同时出现 `count=` 与 `status=`，缺一返回 `null`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:142-169`）→ 真机回 200 空 body 即被判为「无状态」。
- NewAPP 方言工作模式串**必须带空格**（`"Normal Video"`/`"Normal Photo"`…，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:11-25`），`setcurworkmode.cgi?-workmode=` 走 `Uri`/`%20` 编码；无空格写法被固件回 `SvrFuncResult=0xFFFFF752(-2222)` —— 代码里对 `-2222` 的**唯一**处理是 `SSResponseParse.parseGetAllInfo(String)` 里 `if (message.contains("-222")) return null;`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:511-513`），也就是「当作没有状态」，不报错、不提示。
- **不存在 `getthumbnail.cgi`**：缩略图是 `GET http://<ip>/thumb<path>`（SigmaStar）或 `GET http://<ip>/<path 去扩展名>+".THM"`（海思）（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:83,87` + `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/HiDefine.java:26`）。

### 3.2 Ambarella（`H75N` / `CV75`）

全表见 **`docs/evidence/xtugo 附录B（Ambarella 报文全表）`**。结构性结论：

- **报文不是二进制，就是一段 UTF-8 JSON**。`SocketAmbaCmd` 直接把 `Gson.toJson(bean)` 的字节 `outputStream.write(str.getBytes())` 写出去，**没有任何魔术字、长度前缀、校验和、字节序处理**（`_work/xtu_bad/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:142`）。
- 请求体字段全集（Gson 按字段名序列化）：`msg_id`(int)、`token`(int，会话号)、`param`(String 或 int)、`type`、`workmode`、`name`、`value`、`start`、`end`、`path`、`size`、`offset`、`fetch_size`、`md5sum`、`sent_size`、`ssid`、`pwd`。基类见 `com/gku/module_camera/amba/bean/CmdRequestBean.java`。
- **分帧规则 = 累积到能被 Gson 解析**：`sb.append(new String(buf,0,n))`，每读一次就 `GsonUtils.isValidJson(sb.toString())` 试解析（`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:176,191`；`com/gku/base/utils/GsonUtils.java:7-17` 用 `JsonParser.parseString` 不抛异常即为「完整」）。收到但 `msg_id` 不匹配的、或当前无待发命令（`z==false`，此时 `setSoTimeout(10)` 做 10ms 轮询）的，走 `onPushMsgReceive` 推送回调并 `sb.delete(0,sb.length())`（`:225`）。
- 会话：连上后必须先 `msg_id=257 start_session`（`token=0`）→ 响应 `param` = sessionId → 再 `msg_id=261 set_clnt_info {type:"TCP", param:<手机在相机网段里的 IP>}`；两者都成功才算 `onSuccess`（`com/gku/module_camera/amba/connector/AmbaConnector.java:142-208`）。任何非 257 命令在 `sessionId<=0` 时本地直接失败 `-107`（`:240-246`）。`stopSession` 发 258，且发送后**主动关 socket**（`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:144`）。
- `msg_id=268435492 = MSG_ID_BLUETOOTH_HEARTBEAT`（「蓝牙心跳」）：**空 body 心跳**，由 `AmbaCmdModel.updateBTheartbeat()` 发（`com/gku/actioncam/amba/model/AmbaCmdModel.java:381-383`），触发条件在 `…/sigmastar/newUi/common/model/BTHeartbeatManage.java:18`：`type∈{H75N,"CV75"} && name.toUpperCase().endsWith("S7")`。
- 数据口 8787 是**裸字节管道**：`getFile` 先走命令口 1285（`{msg_id:1285,param:<path>,offset:0,fetch_size:0}`，响应给 `path`+`size`），再从 8787 连一次 socket 读 `size` 字节落盘，**无帧头**；65536 缓冲、`available()==0` 时睡 100ms、连续 30 次（3s）无数据判失败、进度每 +1% 回调（`com/gku/actioncam/amba/socket/DataChannel.java:146-239`、`…/connector/SocketAmbaDownload.java:72-104`）。
- 响应 `rval` 特判：`-444 LINK_REFUSE`→事件 137、`-4`→129、`-1`→136、`-34/-33/-18/-17`→135（`-17` 额外 Toast `R.string.sd_no_more_space`）；`"Read timed out"` 字符串→事件 128（`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:390-451`）。

### 3.3 SigmaStar / 海思共用二进制口 8080

全表见 **`docs/evidence/xtugo 附录C（SigmaStar 与播放层）`**。骨架：

- 上行 72 字节定长头：`[0..3] int32 LE cmd` + `[4..7] int32 LE 数据长度/路径长度` + `[8..71] 64 字节 UTF-8 路径`（`ByteBuffer.order(LITTLE_ENDIAN)` 的现代写法在 `com/gku/module_camera/hisi/SocketHisiFile.java` 的 `start()` 内；老写法是 `com.hisi.hisiFW.RegisterDeviceToServer(int,int,String)` 的 `toLH()` 手摆，`com/hisi/hisiFW/RegisterDeviceToServer.java:12-23,40-46`）
- 上行 200 字节（带 MD5）：72B 头之后 `[72..199]` 放 128 字节 MD5（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/model/RegisterDeviceToServer.java:25-38`），用于固件推送（cmd=2）
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
| `key_mode_video_normal_group` / `…_photo_group` / `…_timelapse_group` / `…_slow_group` / `…_loop_group` / `…_multi_burst_group` / `…_multi_continuous_group` / `…_multi_timelapse_group` / `…_photo_single_group` / `…_photo_timer_group` / `…_photo_raw_group` | `setting_video_*` / `setting_multi_*` / `setting_mode_photo` | — | — | — | — | 分组（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:77-114`） |
| `key_mode_video_normal_resolution` | `@string/video_resolution` | Video Resolution | `getcapability.cgi?&-workmode=20&-type=0` | `setparameter.cgi?&-workmode=20&-type=0&-value=%s` | 设备返回 | — |
| `key_mode_video_loop_resolution` / `key_mode_video_timelapse_resolution` / `key_mode_video_slow_resolution` / `key_mode_video_loop_type` / `key_mode_video_timelapse_interval` | `video_resolution` / `loop_type`(="Loop Time") / `interval` | — | `getcapability`/`getparameter`，workmode 21/22/24，type 见 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:19-26` | `setparameter.cgi?&-workmode=%d&-type=%d&-value=%s` | 设备返回 | — |
| `key_mode_photo_single_resolution` / `key_mode_photo_timer_resolution` | `@string/photo_resolution` | Photo Resolution | `getparameter.cgi?&-workmode=0\|1&-type=0` | `setparameter.cgi…` | 设备返回 | — |
| `key_mode_photo_timer_time` | `@string/time` | Time | type=1 | 同上 | 设备返回 | — |
| `key_mode_photo_single_scene` | — | Scene | type=2 | 同上 | 设备返回 | — |
| `key_mode_multi_burst_resolution` / `key_mode_multi_burst_rate` | `photo_resolution` / `@string/rate` | — | workmode 10，type 0 / 1 | `setparameter` | 设备返回 | — |
| `key_mode_multi_timelapse_resolution` / `key_mode_multi_timelapse_interval` | 同上 / `interval` | — | workmode 11，type 0 / 2 | `setparameter` | 设备返回 | — |
| `key_mode_video_photo_*`（5 个） | — | Video+Photo 模式内 5 组 | workmode 23，type 2/3/4/5/6（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:20-24`） | `setparameter` | 设备返回 | — |
| `video_resolution` | `@string/video_resolution` | Video Resolution | `getvideoinfo.cgi?` → 键 `resolution`/`fps` | `setvideoinfo.cgi?&-resolution=%s&-fps=%d` | **`@array/video_resolution_entries_ntsc`** = `720P/30fps`, `720P/60fps`, `720P/240fps`, `1080P/30fps`, `1080P/60fps`, `1080P/120fps`, `4K2K/30fps` ／ **`@array/video_resolution_values_ntsc`** = `720P_30`, `720P_60`, `720P_240`, `1080P_30`, `1080P_60`, `1080P_120`, `4K2K_30`；PAL 版 entries = `720P/25fps`,`720P/50fps`,`720P/240fps`,`1080P/25fps`,`1080P/50fps`,`1080P/120fps`,`4K2K/25fps` ／ values = `720P_25`,`720P_50`,`720P_240`,`1080P_25`,`1080P_50`,`1080P_120`,`4K2K_25`（`res-strings-default.md:35-38`） | 无（`persistent="false"`） |
| `video_mode` | `@string/video_mode` | Video Mode（NTSC/PAL） | `getvideonorm.cgi?` → 键 `videonorm` | `setvideonorm.cgi?&-videonorm=%s` | `@array/video_mode_entries` = `NTSC`,`PAL` ／ `@array/video_mode_values` = `NTSC`,`PAL`（`:33-34`） | 未知 |
| `audio_codec` | `@string/audio_codec` | Audio（CheckBox） | `getaudioencode.cgi?`（`enable=1/0`） | `setaudioencode.cgi?&-enable=%d` | — | false |
| `image_upsidedown` | `@string/image_upsidedown` | 画面翻转 | `getflip.cgi?` | `setflip.cgi?&-enable=%d` | — | false |
| `time_tag` | `@string/time_tag` | 时间水印 | `gettimeosd.cgi?` | `settimeosd.cgi?&-enable=%d` | — | false |
| `boot_action` | `@string/boot_action` | 开机动作 | `getbootaction.cgi?` → 键 `action` | `setbootaction.cgi?&-action=%s` | **`@array/boot_action_entries`** = `Idle`, `Record`, `Timelapse Record`, `Loop Record`, `Slow Motion` ／ **`@array/boot_action_values`** = `idle`, `record`, `recordlapse`, `recordloop`, `recordslow`（`:14-15`）。注意 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:8-10` 只定义 3 个常量 `idle`/`record`/`timelapse`，与数组的 `recordlapse`/`recordloop`/`recordslow` **不自洽** | — |
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
| `download_video` / `file_download_save_path` / `preview_video` / `rec_setting` / `field_of_view` / `frame_rate` / `burst_rate` / `timelapse_interval` / `timer_count_down` / `spot_metering` / `led_flicker` / `buzzer_prompt` / `auto_shutdown` / `poweron_ui_mode` / `wifi_password` / `wifi_ssid` / `update_version` / `about_camera` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:62-135` 全部 74 个 key | — | 见 §3.1 附录 | 见 §3.1 附录 | — | — |

`res/xml/settingpreferences.xml`（App 侧「设置」页，`SettingPreferActivity`）4 项：`about_app`(`@string/about_app`)、`setting_user_agreement`(`@string/text_title_user_agreement`)、`setting_privacy`(`@string/radio_text_4`)、`update_version`(`@string/update_version`)。

Ambarella/SigmaStar 机型的对应「项」不是 Preference，而是 §4.1 的动态菜单；但代码里存在 12 个 `CONFIG_MULTI_*` / `CONFIG_*` 索引常量（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:12-26`）作为 `getcapability/getparameter/getworkmode/setworkmode` 的 `type` 参数枚举 —— 全部值：`CONFIG_MULTI_RESOLUTION=0`、`CONFIG_MULTI_TIMELAPSE_INTERVAL=2`、`CONFIG_MULTI_BURST_RATE=1`、`CONFIG_MULTI_CONTINUOUS_RATE=3`；`CONFIG_PHOTO_RESOLUTION=0`、`CONFIG_PHOTO_TIMER=1`、`CONFIG_PHOTO_SCENE=2`；`CONFIG_VIDEO_VIDEO_RESOLUTION=0`、`CONFIG_VIDEO_TIMELAPSE_INTERVAL=1`、`CONFIG_VIDEO_PHOTO_SNAP_MODE=2`、`CONFIG_VIDEO_PHOTO_SNAP_INTERVAL=3`、`CONFIG_VIDEO_PHOTO_PHOTO_RESOLUTION=4`、`CONFIG_VIDEO_PHOTO_VIDEO_RESOLUTION=5`、`CONFIG_VIDEO_PHOTO_MODE=6`、`CONFIG_VIDEO_LOOP_TYPE=7`。

**工作模式枚举值（老方言 `WORK_MODE_*`）** —— `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:149-162`：`WORK_MODE_PHOTO_SINGLE=0`、`WORK_MODE_PHOTO_TIMER=1`、`WORK_MODE_PHOTO_RAW=2`、`WORK_MODE_MULTI_BURST=10`、`WORK_MODE_MULTI_TIMELAPSE=11`、`WORK_MODE_MULTI_CONTINUOUS=12`、`WORK_MODE_VIDEO_NORMAL=20`、`WORK_MODE_VIDEO_LOOP=21`、`WORK_MODE_VIDEO_TIMELAPSE=22`、`WORK_MODE_VIDEO_PHOTO=23`、`WORK_MODE_VIDEO_SLOW=24`、`WORK_MODE_VIDEO_QUICK=25`、`WORK_MODE_VIDEO_LAPSE_BURST=26`；`WORK_MODE_NOMAL_VIDEO="NormalVideo"`（拼写就是 `NOMAL`）。`MASTER_MODE_PHOTO=0 / MULTI=1 / VIDEO=2 / PLAY=3`（`:136-139`）。

---

## 5. 操作复现表

见 **`docs/evidence/xtugo 附录D（操作复现表）`**（逐操作：连接、预览起流、录像/拍照/连拍/延时/慢动作、切模式、回放列表/缩略图/下载/删除、格式化、改 WiFi 名与密码、二维码配网、蓝牙扫描与配网、GPS 叠加、滤镜、抖音直播、远程观看、固件升级、重启；每项含「按顺序发什么/参数值/成功判据/失败提示资源 ID + file:line」）。

---

## 6. assets 里的协议数据

| 路径 | 字节 | 内容 | 谁在用 |
|---|---|---|---|
| `assets/menu/LZXCAM` | 10471 | **JSON（CRLF 换行）**，一台 `devicename="LZX"` / `company="goodcam"` / `support="http://www.goodcam.net"` / `chip":2` / `firmware":"V0.0.0"` 的**猎trail/记录仪相机**菜单描述。顶层键：`modify_on,firmware,devicename,version,support,company,logo,download,chip,International`。`International` 是 `[{Language, section_array:[{orderNo,row_array:[{isQuickSettings,orderNo,title,cmd,paramValue,type,list}]}]}]` 的嵌套，`cmd` 是 **4 位十进制字符串**（如 `9001` 监控工作模式、`1002` 拍照分辨率、`9007` 拍照张数、`2002` 录像分辨率），`title` 是中文 | **没有任何代码引用**。全树 `grep "LZXCAM\|menu/"` → 0；`getAssets().open` 只有 4 处（`…/dv/ui/data/CopyFileUtils.java:124`、`com/gku/base/utils/FileUtils.java:127,462`、`…/base/utils/IOUtils.java:380`、`com/gku/ffm/zqvideo/utils/RawDataSourceProvider.java:74`），且都由参数传路径，参数里没有 `menu/…`；**死数据**（从 `m.mifan` 的 goodcam 方案模板里带过来的），不属于 XTU 运动相机协议 |
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
| `?authmod=%s&user=%s[&challenge=…&nonce=…&cnonce=…&nc=…]`、`?reason=needauth\|authfailed\|nosuchuser`、`?connect=1`、`?localport=%d`、`?ttl=%d`、`?timeout=%d` | `libijkffmpeg.so` / `libpanorama_vr.so` | **RTSP/HTTP 内建能力，未启用** —— Java 侧拼的 URL 不带任何 auth/参数（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:49-51`），相机也从不要求 |
| `http://m5.amap.com/`、`mpsapi.amap.com/ws/mps/{vmap,rtt,smap,lyrdata/ugc}`、`maps.testing.amap.com/…` | 高德库 | 高德真实在用（TrackActivity 出图时会走）；`maps.testing.*` 是 SDK 内置测试域名 → **死字符串** |
| `https://www.googleapis.com/oauth2/v4/token`、`/youtube/v3/liveBroadcasts…`、`/liveStreams…` | `libpanorama_vr.so` | iCatch 全景 App 的 YouTube 直播模块，XTU 里 **完全死代码**（Java 无引用） |
| `[%s, %d][AES KEYS]Invalid AES Encrytion key(16bits), using default key` | `libcontrol.so` | iCatch PTP 层的 AES key 检查 —— 只影响 Mini1；XTU 运动相机链路**零加密** |
| `setsockopt/socket/accept/connect/recvfrom/sendto/inet_pton/getsockname/listen` | 各库 | libc 导入，非协议常量 |

---

## 8. 第三方 SDK 面

全部初始化常量、上报域名与「真在用/死字符串」判定见 **`docs/evidence/xtugo 附录E（权限·组件·域名）` §3**。摘要：

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
| ExoPlayer / IJK / GSY(`com/gku/ffm/zqvideo`) / videocache / MMKV / xUtils / EventBus / Hilt / ARouter / OkHttp / Retrofit / Gson / Glide / LuckPicker / AndroidVideoCache / commons-{lang3,text} / ini4j / Apache HTTP | — | 均为实现依赖；`com.alibaba.android.arouter.utils.Consts.DOT`、`org.ini4j.Registry.LINE_SEPARATOR`、`com.google.android.exoplayer2.*` 常量被厂商代码**当字符串常量复用**（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpRequest.java:113`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:395`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:100-103`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:514` 用 `IjkMediaMeta.IJKM_KEY_BITRATE`="bitrate" 作 CGI 键名）—— 这是**必须照抄**的隐式依赖 |

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
| `HasUpdate`(bool,默认 true) / `NeitherShow`(false) / `OnCreateHasRun`(true) | 升级弹窗抑制 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SharedPreferencesUtils.java:52,57,62` |
| `LastWIFIRefreshed`(long,-1) / `LastWIFIList`(String,"") | WiFi 列表缓存 | `:74,86` |
| `RTMPBean`(JSON String) | 直播参数快照（`ssid/pwd/live_type/res/fps/bitrate/rtmp_url/roomId`） | `:105`；`…/amba/ui/stream/BroadcastDouyinFragment2.java:947` |
| `LiveStatus`(String,"") | 直播状态机 | `:114` |
| `isAutoUpdateDevice`(bool,true) | 自动升级开关 | `:126` |
| `modelName`(String) / `softVersion`(String) / `isAmba`(bool) | 上次连接的设备；Amba 上报名会 `split("-")[0]` 再存 | `_work/xtu_src/sources/com/gku/HomeActivity.java:748-751, 1765-1771` |
| `bt_pin<蓝牙设备名>` | BLE 配对码（**明文**，配合 `allowBackup=true` 可被导出） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:906,909` |
| 语言表缓存 | 不是 SP，是文件：`<localAppDataPath>/<softversion>.txt`（海思 XML / SigmaStar JSON 都写这个名）；Ambarella 写 `<externalCacheDir>/language.json` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ConnectDevice.java:78-83`、`SSConnectDevice.java`（`initData`）、`_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaLangHolder.java:44` |
| 其它缓存目录 | `/mnt/sdcard/Android/data/com.gku.xtugo/cache/`（`SSConstant.LOCAL_THUMB_CACHE_DIR`）、`/mnt/sdcard/DCIM/ActionCam/`（`SSConstant.LOCAL_DOWNLOAD_DIR`）、`/sdcard/JKHardVersion/`、`/mnt/sdcard/xtu_exception.txt` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:10-11`；`signals-fsPaths.tsv` |
| 下载落地路径 | `/DCIM/xtugo/photo/ActionCam/`、`/DCIM/xtugo/video/ActionCam/`、`…/video/ActionCam/sd/`、`/DCIM/xtugo/{photo,video}/DashCam/`、`/DCIM/xtugo/{photo,video}/` —— 由 `BuildConfig.APPLICATION_ID.split(".")[2]` 动态得 `xtugo` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:170-176` |

从 `signals-keyLike.tsv`（536 条）与代码双查后，**排除掉 JSON 字段名与 CGI 键名**，剩下的配置键全集就是上表；`keyLike` 里其余条目分属：CGI 响应键（`mode/state/event/pasttime/item/cur/workmode/value/capacity/charge/ac/sdstate/total/used/fov/count/time/brightness/uimode/videonorm/bitrate/wifichannel/devcapabilities/action/param/rotation/filelist/fileinfolist/ssid/pwd/BluetoothDevOne/BluetoothDevTwo/path/size/duration/resolution/media_type/thumb_file/startdate/runtimes/model/timeout/networkstatus/bluetoothrxversion/bluetoothtxoneversion/bluetoothtxtwoversion/region/pcbrevision/serialnum/softversion/hardversion/type/name`）、Amba JSON 报文键（`msg_id/token/rval`）、SP 键（上表）、iCatch/volc 内部键。

---

## 10. 未解之谜

| # | 问题 | 为什么静态定不来 | 补证手段 |
|---|---|---|---|
| 1 | 每个 CGI 家族机型的**具体芯片**（X1/X2/X3/S2/S3/S3PRO/S5K/MAX2/MAX3/MAXPRO/S6/R1 到底报 `SSC88xx` 还是 `Hi3519DV500` 还是别的） | 分派键是设备自报的 `type`，APK 里根本没有型号→芯片表（§2.2） | 逐台连上 `GET /cgi-bin/hi3510/getdeviceattr.cgi`，抄 `type` + `hardversion` |
| 2 | NewAPP 机型 `getprimarymenuitem.cgi` 的**完整项名清单**与每项的合法值 | 项名/可选值全部由设备返回，语言表也在设备上（§4.2） | 在 S7PRO 上逐模式 `getprimarymenuitem.cgi?-workmode=<每个模式>` + `getsecondmenuitem.cgi`，把 `item`/`cur`/`<softversion>.txt` 全量导出 |
| 3 | `pasttime` 的**每机型单位** | App 侧零换算（§3.1），无法从代码判定 | 同一动作分别计时：`getcurallinfo.cgi` 轮询 vs 秒表；至少覆盖 Ambarella 机型与 Hi3519DV500 |
| 4 | `SvrFuncResult` 的**完整错误码表** | 代码里只出现 `-2222`(0xFFFFF752)、`"sd is not ready"`、`"sd is full"` 三种处理（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:40-48`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:511`），其余全走 `Integer.parseInt` 后原样返回，无文案映射 | 逐命令制造失败（拔卡/满卡/忙/非法值），抓 `SvrFuncResult` 全量；再对照 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:28-39` 的 11 个 `ERR_*` 负数码 |
| 5 | `Common.ERR_*` 的 11 个魔数（`-1560182774…-1560182784`、`-1610579967`）到底谁回 | 它们是海思 SDK 的错误码，**当前 CGI 路径里没有任何一处生成它们**（`Command.executeCommand` 只做 `Integer.parseInt`） | 老机型（非 NewAPP）上执行非法命令，看 `SvrFuncResult` 是否就是这些数 |
| 6 | 5678 回拨的**报文生成方** | App 只 accept + 广播（§3.4），无发送方代码 | 手机侧抓包（`tcpdump`/mitm 于相机 AP 网关），让相机录像 30s 看是否推 `pasttime`；同时看是否只有 `getCameraCurrentInfor` 那条主动轮询路径被实际使用 |
| 7 | `getactivateinfo.cgi` / `setactivateinfo.cgi` / `settrial.cgi` 的字段语义（`status/number(默认 5)/macaddr/version`） | 只 S7PRO/S7PRO MAX 会调（`_work/xtu_src/sources/com/gku/HomeActivity.java:1714-1739`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpRequest.java:52-55,242-329`），其它机型不触发 | 连未激活的 S7PRO，依次 `getactivateinfo` → `settrial` → `setactivateinfo?-status=1&-version=<v>` 看返回 |
| 8 | `CameraSocketService`、`SSMessageService` 为何在清单里 | 两棵树 18195 文件 + 全树 grep 均 0 命中 → 类不存在 | 反编译 `AndroidManifest` 比对 `classes*.dex` 的类名表（`dexdump`/`apkanalyzer dex packages`）即可坐实「R8 删类未删清单」 |
| 9 | `CALL_PHONE` / `BLUETOOTH_ADVERTISE` 的实际入口 | 申请了但未见 `ACTION_CALL`/`startAdvertising` | 走一遍 UI（反馈页/客服页/蓝牙 TX 页 `SSBluetoothTXActivity`）看是否触发权限弹窗 |
| 10 | 高德轨迹页在**无 API key** 下是否能出图 | 清单无 `com.amap.api.v2.apikey`（`manifest.md` §7 meta-data 表为空） | 装机后打开「轨迹」页看日志鉴权错误；或从 `res/raw`/`assets` 找隐藏 key |
| 11 | `assets/menu/{LZXCAM, ly_menu.json}` 的 4 位 `cmd` 协议是否被任何分支用到 | Java 0 引用（§6） | 拉 `m/mifan/acase/core/HttpProtocol` + `cn.rxt.qscase` 全链复核，或抓 iCatch 记录仪侧报文 |
| 12 | 127 个 jadx 失败类里是否还有协议关键类 | 只补了 `SocketAmbaCmd$1.run()` | `_work/xtu_bad/` 已含同 APK 的 show-bad-code 版；按 `xtu_jadx.log` 的错误清单逐个交叉核对 |

---

## 11. 对既有文档的纠正

| 原说法（文档:位置） | 现有证据 | 建议改法 |
|---|---|---|
| `docs/analysis/protocol-matrix §2` 「SSID 前缀正则」 | 全树无 `Pattern.compile` 用于 SSID；判定只有 `contains("XTU")`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bluetooth/ui/PopupDialogActivity.java:199`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/DeviceAddDeviceListFragment.java:315`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java:493`）；BLE 侧才是 `toUpperCase().startsWith("XTU_")`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:473`） | 保留 `docs/analysis/protocol-matrix:316` 的 NOT FOUND 结论；把「SSID 前缀正则」的措辞改成「子串包含 `XTU`」，并明确 BLE 名与 WiFi SSID 是两套规则 |
| `docs/analysis/protocol-matrix §2 型号表` 第 12 行 XTU R1「未知平台，仅共用图标」 | 补充证据：`_work/xtu_src/sources/com/gku/loginmodule/utils/CameraInfoUtils.java:47-49` 与 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/ScanAddRecycleAdapter.java:117` 都把 `XTUR1` 画成 S6Pro 的图；两处都**不做平台判定**（平台只看 `type`） | 结论不变（未知），但注明「图标同源 ≠ 平台同源」这条推理已经复查过、仍是唯一证据 |
| `docs/analysis/protocol-matrix:806` 「XTU 的 Ambarella 也是 7878 命令 + 8787 数据双 socket，海思还有 8080 二进制帧与 5678 回拨」 | 全部证实，并补细节：8080 帧头 72B/200B、小端、64B 路径槽（`SocketHisiFile`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/model/RegisterDeviceToServer.java:12-38`）；5678 是 App listen、≤512B、无格式（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:19,104`） | 在 `docs/analysis/protocol-matrix` 里把 72B/200B 头字段偏移与 cmd 枚举（0=取文件，2=推固件）补进去 |
| `docs/analysis/protocol-matrix:821` 「XTU 官方 18 型号清单」 | 两份清单：反馈页 17 项（`_work/xtu_src/sources/com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java:211-227`，无 S3）+ 图标解析 18 项（`CameraInfoUtils.java`，含 S3） | 明确「18」来自 `CameraInfoUtils`（含 `XTUS3`），反馈页只有 17；两表 token 大小写不同（`XTUMax2` vs `XTUMAX3` vs `XTUS5k`） |
| 任务书/既有文档假设存在 `getthumbnail.cgi` | 不存在。缩略图是 `http://<ip>/thumb<path>`（SigmaStar，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:83`）或 `http://<ip>/<去扩展名>+".THM"`（海思，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:87` + `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/HiDefine.java:26`）；Ambarella 不走 HTTP 而走 msg 1025 + 8787（`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:352-363`） | 删掉 `getthumbnail.cgi`，按机型写三种缩略图取法 |
| `docs/analysis/protocol-matrix §2` 「探测顺序：HTTP CGI 优先、Ambarella socket 兜底」 | 证实，且拿到精确行号：`_work/xtu_src/sources/com/gku/HomeActivity.java:1707-1783`（CGI）与 `:1776-1781`（回退 `AmbaConnector.startSession`） | 补上「先 `getdeviceattr.cgi`，失败才 startSession」的函数名与行号，并补 `guessDeviceIP()` 的 IP 取值链（`_work/xtu_src/sources/com/gku/HomeActivity.java:1853`；`_work/xtu_src/sources/com/gku/base/device/NetworkDeviceUtils.java:332-358`） |
| 「相机默认地址常量」只写了 `192.168.0.1` | 实际有 **6 个** 独立常量位（`CameraParameters.baseIp`、`CameraParmeras.baseIp`、`SSConstant.SS_IP`、`DV.defaultIP`、`FwUpload.HOST`、`IcatchCaseKt.API_HOST_ICATCH=192.168.1.1`） | 在 `docs/analysis/protocol-matrix` 的默认常量表里补齐，并强调 SigmaStar/海思代码路径**硬编码** `192.168.0.1` 而非读 `baseIp`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:57`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ConnectDevice.java:44`、`DownLoadFileUtils.java:31-32`、`FirmwareClientThread.java:64`、`HisiCameraAbout` 等）→ 换 IP 的机型在这几处会失效 |
| 「Ambarella 报文有长度前缀/字节序」 | **没有任何前缀**：请求就是 `Gson.toJson(bean).getBytes()`；响应靠「累积到能被 Gson 解析」判帧（`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:142,176,191`） | 把「分帧规则 = valid-JSON-accumulation」写成唯一规则，删去任何「长度前缀」暗示 |
| `docs/analysis/protocol-matrix §2` 「`pasttime` 单位半秒」 | 代码零换算（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:490,505,525`、`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:570`）；单位差异只体现在真机 | 改成「App 把 `pasttime` 原样当秒显示，Ambarella 上会差 2 倍」，并列入未解之谜 #3 |
| 设置项「APK 内有参数表」 | 没有。参数表是 **设备自描述 + 运行期语言表**；APK 里唯一静态表是老方言的 `res/xml/preferences.xml` + 4 对共 8 个 `@array` 引用（`boot_action`、`screen_auto_sleep`、`video_mode`、`video_resolution_entries_ntsc` 各带一份 `_values`）（§4.3） | 把 §4.3 这张「老方言静态表」补进 `docs/analysis/protocol-matrix` §4，并注明 `boot_action_values` 与 `Common.BOOT_ACTION_*` 不自洽（数组有 `recordlapse/recordloop/recordslow`，常量只有 `idle/record/timelapse`） |
| 「预览起流」统一写 `rtsp://ip:554/livestream/12` | 还有 HTTP 版 `http://ip:80/12?trans=tcp&action=play&media=video_data`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:332-341`），且 **12 会切成 11**（`isPreviewBigBitRate()`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:119`）；RTSP 传输按 `type` 选 udp/prefer_tcp（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java:603-607`） | 在 `docs/analysis/network-api` 的预览条目里补两条 URL + 码流开关 + 传输选择规则 |
| 「友盟 SDK」在第三方清单里 | 全树无友盟 SDK 类，只有 `_work/xtu_src/sources/com/gku/crashhandle/CrashReportManager.java:32` 读了一个不存在的 `UMENG_CHANNEL` meta-data | 从第三方 SDK 面里删除「友盟」，改为「Bugly（在用）；友盟仅剩一个 meta-data 读取残留」 |
| 「219 个组件里厂商自有组件」 | 精确拆分：`com.gku.*` = 107（100 activity + 6 service + 1 provider）；含 iCatch/`cn.rxt`/`com.example`/`m.mifan` = 117；**其中 2 个 service 是清单幽灵**（`CameraSocketService`、`SSMessageService`）；唯一导出的厂商组件是 `GKUCamPlayer`（`exported=true`）与启动器 `WelcomeActivity` | 按此数字与幽灵结论更新 `docs/analysis/apk-overview`/`docs/analysis/protocol-matrix` 的组件统计 |
| 38 条权限「逐条有用途」 | 12 条**完全没有代码引用**：`READ_PRIVILEGED_PHONE_STATE`、`MANAGE_MEDIA`、`GET_ACCOUNTS`、`WRITE_MEDIA_STORAGE`、`MODIFY_AUDIO_SETTINGS`、`CHANGE_CONFIGURATION`、`READ_LOGS`、`SYSTEM_ALERT_WINDOW`、`GET_TASKS`、`FLASHLIGHT`（+ `ACCESS_MEDIA_LOCATION` 只由 Glide 检查、`BLUETOOTH_ADVERTISE`/`CALL_PHONE` 申请但未用） | 在 `docs/analysis/apk-overview`/`docs/analysis/network-api` 的权限表里加「死声明」标记，避免我们照着申请 |

---

## 目录

- 附录 A · 海思 CGI 全表（本文下半部，标题 `# 附录 A · 海思 CGI 全表`）
- 附录 B · Ambarella 报文全表
- 附录 C · SigmaStar 8080 帧与播放层
- 附录 D · 操作复现表
- 附录 E · 权限、组件与域名

---

<!-- 以下整段合并自原 02-XTUGO-档案-附录-海思CGI全表.md（2026-09-22 文档归并，内容未改） -->
# 附录 A · 海思 CGI 全表（XTU GO 8.4.3）

> 主文档：[XTU GO 档案](xtugo.md)
> 本附录穷尽 XTU GO 里**所有**走 `/cgi-bin/hi3510/` 的命令：路径、每个 query 参数名（含字面带前导 `-` 的键）、取值枚举、单位、响应字段、解析代码位置。
> 三套实现并存，逐套列出：
> - **A. 老方言** = `com.gku.actioncam.hisilicon.dv.biz.{Command,Setting,RemoteFileManager}` + `com.gku.actioncam.hisilicon.dv.net.HttpProxy`，服务 `hardversion != "NewAPP"` 的老海思机
> - **B. NewAPP 方言** = `com.gku.actioncam.hisilicon.dv.net.HttpProxy`（NewAPP 段）+ `…dv.ui.data.SetDataUtils` + `com.gku.actioncam.sigmastar.{SSCommandUtil,HaisiCommandUtil}`，服务 `hardversion == "NewAPP"`（真机 S7PRO/Hi3519DV500 走这套）
> - **C. 最新 App 层** = `com.gku.hisi.Hisi_Camera{Record,Pic}Fragment` + `com.gku.module_camera.hisi.*` + `com.gku.module_base_xtugo.HisiApiUtils`

---

## 0. 底座与响应解析

| 项 | 值/规则 | file:line |
|---|---|---|
| HTTP 栈（A/B） | `AndroidHttpClient.newInstance("HiCamera")`，User-Agent 即 `"HiCamera"`；`CONNECTION_TIMEOUT=20000ms`；`CoreConnectionPNames` | `com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:44-46` |
| 直连 socket 版（不等响应） | `GET /cgi-bin/hi3510<url> HTTP/1.1\r\nHost:<ip>\r\nConnection: Keep-Alive\r\nUser-Agent: HiCamera\r\n\r\n`，`soTimeout=6000`，端口 80，写完即 close | `…/dv/biz/Setting.java:375-398` |
| HTTP 栈（B 部分/C） | OkHttp：`connectTimeout/writeTimeout/readTimeout = 5s`，`retryOnConnectionFailure` 在 `getDeviceAttrMap` 里为 `true`、其余 `false`；`socketFactory` 取自 `NetworkDeviceUtils.getNetworkDevice()`（VPN/多网络共存关键） | `…/dv/net/HttpRequest.java:48-61,331-352` |
| 通用键值解析 `getKeyValueMap`/`getMap` | 匹配 `var <K>="<V>";\r\n`（`HEAD_VAR="var "`、`MID_EQUAL_MARK="=\""`、`TAIL_SEMICOLON="\";\r\n"`），两端 trim | `…/dv/net/StringParser.java:17-19,55-89`；`…/sigmastar/data/SSResponseParse.java:39-43,532-545` |
| 宽松解析 `getMap2`/`parseMessageToMap2` | 结束符只要求 `";` → **能读到同一行的多个 var** | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/StringParser.java:91-108`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:547-560` |
| 正则解析 `getVarValue` | `Pattern.compile(key + "=\"(.*?)\"")`，找不到返回 `null` | `com/gku/module_base_xtugo/HisiApiUtils.java:33-39` |
| JSON 数组响应 | `getMediaList()`：`JSONArray` → 每项取 `path`/`create`/`time`/`size` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/StringParser.java:41-53` |
| 通用失败 Toast | `R.string.fail`（默认文案 `Fail`，`res-strings-default.md:684`），由 `HttpProxy` 的静态 Handler `what==1` 触发 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:47-56` |

**成功判据（重要）**：`doForSuccess()` 只判 `statusCode == 200`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:89-92`）；`Command.executeCommand()` 才看 body（下 §1.1）。真机结论「`record.cgi`/`setcurworkmode.cgi` 的 200 不代表成功」在代码里得到印证 —— **凡是走 `doForSuccess`/`doForBoolean`/`doForIntByKey` 的命令都无法区分「200 且业务失败」**，只有 `Command.executeCommand`（A 套）与 `SSResponseParse.parseGetAllInfo` 里的 `-222` 嗅探（B 套）例外。

---

## 1. A 套 · 老方言全表

### 1.1 拍摄命令 `Command.cgiFilesParams[]`（索引即 `ACTION_*`）

`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:9-31`；URL 拼装 = `http://<ip>` + `Common.CGI_PATH`(`/cgi-bin/hi3510`) + 表项（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:36`）。

| `ACTION_*` | 值 | CGI 串（照抄） |
|---|---|---|
| `ACTION_RECORD_START` | 0 | `/record.cgi?&-cmd=start` |
| `ACTION_RECORD_STOP` | 1 | `/record.cgi?&-cmd=stop` |
| `ACTION_PHOTO` | 2 | `/photo.cgi?&-type=photo` |
| `ACTION_BURST` | 3 | `/photo.cgi?&-type=photoburst` |
| `ACTION_TIMELAPSE_START` | 4 | `/photo.cgi?&-type=phototimelapse&-cmd=start` |
| `ACTION_TIMELAPSE_STOP` | 5 | `/photo.cgi?&-type=phototimelapse&-cmd=stop` |
| `ACTION_TIMER_START` | 6 | `/photo.cgi?&-type=phototimer&-cmd=start` |
| `ACTION_TIMER_STOP` | 7 | `/photo.cgi?&-type=phototimer&-cmd=stop` |
| `ACTION_CONTINUOUS_START` | 8 | `/photo.cgi?&-type=continuous&-cmd=start` |
| `ACTION_CONTINUOUS_STOP` | 9 | `/photo.cgi?&-type=continuous&-cmd=stop` |
| `ACTION_VIDEO_QUICK_EXIT` | 10 | `/exitquickrec.cgi` |
| `ACTION_VIDEO_COMMON_START` | 11 | `/record2.cgi?&-type=common&-cmd=start` |
| `ACTION_VIDEO_COMMON_STOP` | 12 | `/record2.cgi?&-type=common&-cmd=stop` |
| `ACTION_VIDEO_LOOP_START` | 13 | `/record2.cgi?&-type=loop&-cmd=start` |
| `ACTION_VIDEO_LOOP_STOP` | 14 | `/record2.cgi?&-type=loop&-cmd=stop` |
| `ACTION_VIDEO_TIMELAPSE_START` | 15 | `/record2.cgi?&-type=timelapse&-cmd=start` |
| `ACTION_VIDEO_TIMELAPSE_STOP` | 16 | `/record2.cgi?&-type=timelapse&-cmd=stop` |
| `ACTION_VIDEO_SNAP_START` | 17 | `/record2.cgi?&-type=recsnap&-cmd=start` |
| `ACTION_VIDEO_SNAP_STOP` | 18 | `/record2.cgi?&-type=recsnap&-cmd=stop` |
| `ACTION_VIDEO_SLOW_START` | 19 | `/record2.cgi?&-type=slow&-cmd=start` |
| `ACTION_VIDEO_SLOW_STOP` | 20 | `/record2.cgi?&-type=slow&-cmd=stop` |
| `ACTION_BUTT` | 21 | 越界哨兵（`executeCommand` 里 `cmd < 21` 才执行，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:35`） |

**响应解析与错误判定（`Command.executeCommand`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:33-64`）**：
1. body 含 `SvrFuncResult` → 取 `content.substring(15, content.lastIndexOf("\""))`（**硬编码偏移 15**，即假定前缀是 `var SvrFuncResult="`）
2. 值 `"sd is not ready"` → `Common.ERR_SD_ERROR`（`-1560182782`）
3. 值 `"sd is full"` → `Common.ERR_SD_FULL`（`-1560182783`）
4. 否则 `Integer.parseInt(值)` → `result.errorCode`（例：`0xFFFFF752` 这种 16 进制串会 parseInt 失败 → `errorCode=-1`）
5. body 不含 `SvrFuncResult`：200 → `returnCode=0,errorCode=0`；非 200 → `returnCode=-1`
6. 异常 → `errorCode=-1`；`cmd` 越界 → 返回初始值 `returnCode=-1, errorCode=-1`

`Common.Result` 初始 `returnCode=-1, errorCode=-1`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:187-190`）。

NewAPP 下 `DV.executeCommand` 会把命令索引折叠：`IsNewAPP && cmd>=10 && cmd!=10` → `cmd = cmd%2==0 ? 1 : 0`（即 start/stop 归一到 `/record.cgi?&-cmd=start|stop`）；`cmd==10`（退出快录）保持（`…/dv/biz/DV.java:347-355`；同款在 `…/sigmastar/HaisiCommandUtil.java:53-58`）。

### 1.2 设备/状态/参数（`Setting.java` 全量，552 行逐条）

URL 模板固定为 `http://%s%s/<cmd>`，第 2 个 `%s` = `Common.CGI_PATH`；下表只写 cmd+参数。

| 方法 | CGI + query（照抄） | 参数取值/单位 | 响应字段与解析 | file:line |
|---|---|---|---|---|
| `getWorkState(ip)` | `getallinfo.cgi??`（**注意是两个 `?`**） | — | `doForMap` 进 map，返回值即 workState（int） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:29-31` |
| `getVideoInfo(ip,map)` | `getvideoinfo.cgi?` | — | `doForMap` | `:33-35` |
| `setVideoInfo(ip,res,fps)` | `setvideoinfo.cgi?&-resolution=%s&-fps=%d` | `resolution` ∈ `@array/video_resolution_values_{ntsc,pal}`（见主文档 §4.3）；`fps` int | `doForSuccess`（只看 200） | `:37-39` |
| `getBatteryInfo(ip)` | `getbatterycapacity.cgi?` | — | 键 `capacity`（int，**>100 才当有效**，≤100 归 0）、`charge`（`"1"`→充电中）、`ac`（`"1"`→外接电源）；`charge==null` 时走另一分支 | `:43-85` |
| `getSdState(ip)` | `getsdstate.cgi?` | — | `sdstate` ∈ {`SDOK`→0,`SDFULL`→1,`SDNONE`→2,`SDERROR`→3}（对应 `SD_STATE_OK/FULL/NONE/ERROR`）；`total`/`used` 去掉 `" MB"` 后 parseInt，缺失=-1 | `:87-119`；枚举 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:140-143` |
| `getViewField(ip)` | `getviewfield.cgi?` | — | 键 `fov`，**只接受 150 或 170**，否则 -1 | `:121-127` |
| `setViewField(ip,fov)` | `setviewfield.cgi?&-fov=%d` | `fov ∈ {150,170}`（其它本地直接返回 -1） | `doForSuccess` | `:129-134` |
| `getLoopRecord` / `setLoopRecord` | `getlooprecord.cgi?` / `setlooprecord.cgi?&-enable=%d` | `enable ∈ {0,1}` | `doForBoolean`（键 `enable`） | `:136-142` |
| `getFlip` / `setFlip` | `getflip.cgi?` / `setflip.cgi?&-enable=%d` | 同上 | 同上 | `:144-150` |
| `getBurstInfo(ip,map)` | `getburstinfo.cgi?` | — | `getKeyValueMap` 取 `time`(秒) 与 `count`(张)，任一缺失/非数字 → -1 | `:152-176` |
| `setBurstInfo(ip,time,count)` | `setburstinfo.cgi?&-time=%d&-count=%d` | **本地校验 `time∈[0,30]`、`count∈[0,30]`**，越界直接返回 -1 | `doForSuccess` | `:178-184` |
| `getTimelapseInfo` / `setTimelapseInfo` | `gettimelapseinfo.cgi?` / `settimelapseinfo.cgi?&-time=%d` | `time` 秒 | `doForIntByKey(键 "time")` | `:186-192` |
| `getTimerInfo` / `setTimerInfo` | `gettimerinfo.cgi?` / `settimerinfo.cgi?&-time=%d` | `time` 秒 | 同上 | `:194-200` |
| `getRecordTimelapseInfo` / `set…` | `getrecordtimelapse.cgi?` / `setrecordtimelapse.cgi?&-time=%d` | 秒 | 同上 | `:202-208` |
| `getBootAction` / `setBootAction` | `getbootaction.cgi?` / `setbootaction.cgi?&-action=%s` | `action ∈ {idle, record, timelapse}`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:8-10`）；数组另有 `recordlapse/recordloop/recordslow` | `doForStringByKey(键 "action")` | `:210-216` |
| `getAudioEncode` / `setAudioEncode` | `getaudioencode.cgi?` / `setaudioencode.cgi?&-enable=%d` | 0/1 | `doForBoolean` | `:218-224` |
| `getVideoMode` / `setVideoMode` | `getvideonorm.cgi?` / `setvideonorm.cgi?&-videonorm=%s` | `videonorm ∈ {NTSC, PAL}`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:147-148`）；读时**非此二值即返回 null** | `doForStringByKey(键 "videonorm")` | `:226-239` |
| `getDeviceAttr(ip,map)` | `getdeviceattr.cgi`（**无 `?`**） | — | `doForMap` 进 map（键见 §1.4） | `:241-246` |
| `setSystemTime(ip,calendar)` | `setsystime.cgi?&-time=%04d%02d%02d%02d%02d%02d` | `yyyy MM dd HH mm ss`，**月是 `Calendar.MONTH+1`** | `doForSuccess` | `:248-253` |
| `getSpotMeter` / `setSpotMeter` | `getspotmeter.cgi?` / `setspotmeter.cgi?&-enable=%d` | 0/1 | `doForBoolean` | `:255-261` |
| `getTimeOsd` / `setTimeOsd` | `gettimeosd.cgi?` / `settimeosd.cgi?&-enable=%d` | 0/1 | 同上 | `:263-269` |
| `getLedState` / `setLedState` | `getledstate.cgi?` / `setledstate.cgi?&-enable=%d` | 0/1；**读时若 `CameraParameters.IsNewDevice` 为真则直接返回 `true` 不发请求** | 同上 | `:271-281` |
| `getBuzzerState` / `setBuzzerState` | `getbuzzer.cgi?` / `setbuzzer.cgi?&-enable=%d` | 0/1 | 同上 | `:283-289` |
| `restoreFactorySettings(ip)` | `/reset.cgi?` | — | **socket 直发、不读响应** | `:291-293` → `:375-398` |
| `setWifi(ip,ssid,pwd)` | `/setwifi.cgi?` + 可选 `&-wifissid=%s` + `&-wifikey=%s`（null 参数则**整段不拼**） | 任意字符串，空格会先被 `HttpProxy` 删掉 | **socket 直发、不读响应** | `:295-308` |
| `setWifiToSta(ip,ssid,pwd)` | `http://<ip>/cgi-bin/setwifista.cgi?&-ssid=%s&-key=%s`（**注意是 `/cgi-bin`，不是 `/cgi-bin/hi3510`**） | 目标路由器的 SSID/密码 | `doForSuccess` | `:310-323`；`ICGI_PATH` 常量 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:61` |
| `setWifiToAp(ip)` | `http://<ip>/cgi-bin/setwifista.cgi?`（无参数） | — | `doForSuccess` | `:325-327` |
| `getAutoShutdown` / `set…` | `getautoshutdown.cgi?` / `setautoshutdown.cgi?&-time=%d` | 分钟（UI 由数组决定） | `doForIntByKey("time")` | `:329-335` |
| `getScreenAutoSleep` / `set…` | `getscreenautosleep.cgi?` / `setscreenautosleep.cgi?&-time=%d` | `time ∈ {0,1,3,5}`（`@array/screen_auto_sleep_values`） | 同上 | `:337-343` |
| `getScreenBrightness` / `set…` | `getscreenbrightness.cgi?` / `setscreenbrightness.cgi?&-brightness=%d` | 键 `brightness` | `doForIntByKey("brightness")` | `:345-351` |
| `getPowerOnUiMode` / `set…` | `getpoweronuimode.cgi?` / `setpoweronuimode.cgi?&-uimode=%d` | 键 `uimode`；`DV` 侧限定 **0..4**（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:308-312`） | `doForIntByKey("uimode")` | `:353-359` |
| `sleep(ip)` | `wifisleep.cgi?` | — | `doForSuccess` | `:463-465` |
| `macAddres2ByteArray(mac)` | 本地 | 要求长度 17 且含 `:`，按 6 段 16 进制 | — | `:467-481` |
| `wakeupDevice(ip,mac)` | 本地 UDP | magic packet：6×`0xFF` + 16×MAC，102 字节，发到 `<ip 去末段>.255:9`，连发 5 次 | — | `:483-511` |
| `getBitRate` / `setBitRate` | `getbitrate.cgi?` / `setbitrate.cgi?&-bitrate=%d` | 键名取自 `IjkMediaMeta.IJKM_KEY_BITRATE` = `"bitrate"` | `doForIntByKey("bitrate")` | `:513-519` |
| `getWifiChannel` / `set…` | `getwifichannel.cgi?` / `setwifichannel.cgi?&-wifichannel=%d` | 键 `wifichannel` | `doForIntByKey("wifichannel")` | `:521-527` |
| `getDevCapabilities(ip)` | `getdevcapabilities.cgi?` | — | `doForStringByKey("devcapabilities")` | `:529-531` |
| `getWorkMode(ip,map)` / `setWorkMode(ip,mode)` | `getworkmode.cgi?` / `setworkmode.cgi?&-workmode=%d?`（**末尾多一个 `?`，是 bug**） | `workmode` = §4 枚举 | `doForMap`/`doForSuccess` | `:533-539` |
| `getCapability(ip,mode,type)` | `getcapability.cgi?&-workmode=%d&-type=%d` | `mode` ∈ `WORK_MODE_*`；`type` ∈ `CONFIG_*`（主文档 §4.3） | `doForStringByKey("capability")` | `:541-543` |
| `getParameter(ip,mode,type)` | `getparameter.cgi?&-workmode=%d&-type=%d` | 同上 | `doForStringByKey("value")` | `:545-547` |
| `setParameter(ip,mode,type,value)` | `setparameter.cgi?&-workmode=%d&-type=%d&-value=%s` | 同上 | `doForSuccess` | `:549-551` |

### 1.3 文件与卡（`RemoteFileManager.java`，全量）

| 方法 | CGI + query | 响应解析 | file:line |
|---|---|---|---|
| `getFileCount(ip)` | `getfilecount.cgi?` | `doForIntByKey(键 "count")` | `…/dv/biz/RemoteFileManager.java:13-17` |
| `getFileList(ip,start,end,list)` | `getfilelistinfoios.cgi?&-start=%d&-end=%d` | body 当 **JSON 数组**：每项 `path`/`create`/`time`(int)/`size`(long) → `MediaModel`；返回条数 | `:19-30`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/StringParser.java:41-53` |
| `getFileNameList(ip,start,end,list)` | `getfilelist.cgi?&-start=%d&-end=%d` | 按 `;` 切行，只保留小写结尾 ∈ {`mp4`,`lrv`,`dng`,`png`,`jpg`} | `:32-43` |
| `getFileInfo(ip,file,map)` | `getfileinfo.cgi?&-name=%s` | `doForMap` | `:45-47` |
| `deleteFile(ip,file)` | `deletefile.cgi?&-name=%s` | `doForSuccess` | `:49-51` |
| `deleteAllFiles(ip)` | `deleteallfiles.cgi?` | `doForSuccess` | `:53-55` |
| `formatSdCard(ip,map)` | `sdcommand.cgi?-format&-partition=1`（**`-format` 是裸标志位，`-partition=1` 固定**） | `doForMap`（把返回塞 map） | `:57-59` |
| `upgrade(ip)` | `upgrade.cgi` | `doForSuccess` | `:61-63` |
| `FileListManager` | 列表分页/排序/缩略图管理（1160 行） | — | `…/dv/biz/FileListManager.java` |

### 1.4 `getdeviceattr.cgi` 响应字段全集（真机 S7PRO 实测吻合）

| 键 | 类型 | 处理 | file:line |
|---|---|---|---|
| `name` | String | 型号名；`.split("-")[0]` 后写 SP | `…/dv/net/HttpRequest.java:118-121`、`_work/xtu_src/sources/com/gku/HomeActivity.java:1765` |
| `region` | String | 缺省 `"G"`（`e.e` 是混淆的 `"H"`） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpRequest.java:112,122-125` |
| `pcbrevision` | String | 缺省 `"V1.0"` | `:126-129` |
| `serialnum` | int（`Integer.parseInt`，缺失→0） | | `:130` |
| `type` | String | 平台分派键（`SSC8838`/`SSC8826`/`SSC8838C`/`H75N`/`CV75`/`Hi3519DV500`/`Hi3518EV300`…）；缺省 `""`；`DeviceAttr` 的默认值是 `"117"`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:144,203`） | `:131-134` |
| `networkstatus` | int，缺失→0；**若该键不存在走另一分支**（`:135-189` vs `:190-233`，两条分支的兜底逻辑不同且其中一条引用了未初始化变量） | | `:135-189` |
| `softversion` | String | **若含 `H`/`G` 且含 `.`，截断到最后一个 `.`**（`20.8.6.1.20260710` 这类会被削成 `20.8.6.1`） | `:107-117` |
| `hardversion` | String，缺失→`""`；**`"NewAPP"` 决定方言** | | `:141-146`；`_work/xtu_src/sources/com/gku/HomeActivity.java:1746-1750` |
| `bluetoothrxversion` / `bluetoothtxoneversion` / `bluetoothtxtwoversion` | String，缺失→`""` | | `:147-164` |
| `startdate` | String，缺失→`""` | | `:165-170` |
| `runtimes` | long，缺失→0 | | `:171-174` |
| `model` | int | | `:175-179` |
| `timeout` | int | | `:180-182` |

组装成 `CameraInfors(name, region, pcbrevision, serialnum, type, networkstatus, softversion, hardversion, btRx, btTxOne, btTxTwo, startdate, runtimes, model, timeout)`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpRequest.java:183`）。

### 1.5 激活/试用（仅 `name ∈ {"XTU S7PRO","XTU S7PRO MAX"}` 触发）

| 命令 | CGI（相对 BaseUrl `http://<ip>/cgi-bin/hi3510/`） | 参数 | 响应 | file:line |
|---|---|---|---|---|
| 读激活状态 | `getactivateinfo.cgi` | — | `status`(int，缺省 `"0"`)、`version`(String)、`number`(int，**缺省 5** = 试用次数)、`macaddr`(String，缺省 `""`) | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpRequest.java:53,242-279` |
| 写激活 | `setactivateinfo.cgi?-status=%d&-version=%s` | `status` 恒传 **1**，`version` 取上一步的 `version` | 只记日志，返回 true | `:54,281-305` |
| 进入试用 | `settrial.cgi?-status=%d&-version=%s` | `status` 取设备返回值 | 只记日志 | `:55,307-329` |

### 1.6 固件上传（老 App 侧）

`POST /cgi-bin/hi3510/fileupload.cgi HTTP/1.1 Charset: utf-8 connection: keep-alive`（手工拼 HTTP 头）—— `…/dv/updateapp/UpgradeManager.java:191`；sigmastar 侧逐字重复一份 `…/sigmastar/upgrade/app/UpgradeTaskManager.java:191`。

---

## 2. B 套 · NewAPP 方言全表

`CameraParameters.BaseUrl` = `"http://" + ip + "/cgi-bin/hi3510/"`（`_work/xtu_src/sources/com/gku/HomeActivity.java:1708`），下表全部是 `BaseUrl + <串>`。

### 2.1 模式与参数

| 用途 | CGI + query（照抄） | 取值 | 解析 | file:line |
|---|---|---|---|---|
| 列全部工作模式 | `getallworkmode.cgi` | — | `getMap2` → 键 `photo` / `video`，按 `,` split 成 `CameraParameters.PhotoModel/VideoModel`；异常静默吞掉 | `…/dv/net/HttpProxy.java:197-211` |
| 当前模式 | `getcurworkmode.cgi` | — | `getMap` → 键 `workmode`；`getMap2` → 另读 `value` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:213-221`；`…/dv/ui/data/SetDataUtils.java:197-212` |
| 切模式 | `setcurworkmode.cgi?-workmode=<模式串>` | **带空格模式串**，先整体把空格替成 `%20`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:226-228`）；成功副作用 `DV.Strmode = 模式串` | `doForSuccess`（200 即真）+ Handler `what=0` 隐藏进度、`what=1` Toast `R.string.fail` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:223-239` |
| 写模式内参数 | `setcurparameter.cgi?-workmode=<模式>&-name=<项>&-value=<值>` | 空格→`%20`；`TYPE==0` 用当前模式，否则用 `"System"` | `doForSuccess` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:241-256` |
| 写系统参数 | `setcurparameter.cgi?-workmode=System&-name=<项>&-value=<值>` | `name`/`value` 各含空格时用 `Uri.encode(x,"utf-8")`（**与上条的 `%20` 不一致**） | `doForSuccess` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:258-272` |
| 一级菜单（模式内） | `getprimarymenuitem.cgi?-workmode=<模式>` | 空格→`%20` | `getMap2` → `item`,`cur`，各按 `,` split 后配对；`item` 空则整表 null | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:41-59` |
| 一级菜单（系统） | `getprimarymenuitem.cgi?-workmode=System` | — | `getMap2`；`cur` 非空时**人为追加 `",test"`**；`getItem2` 里 `value[i]` 越界会 NPE（被 catch 不了） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:92-158` |
| 二级菜单（可选项） | `getsecondmenuitem.cgi?-workmode=<模式>&-name=<项>` | `name` 先 `Uri.encode(...,"UTF-8")` 再把空格→`%20`（**双重编码，含空格项名可能出错**） | `getMap2` → 键 `item`（逗号切分）、`value`/`cur` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:169-189,262-292,294-316` |
| 定时拍照秒数 | `settimerinfo.cgi?&-time=<n>` | 秒 | 只判 `statusCode==200` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:291-297` |
| 延时参数 | `settimelapseinfo.cgi?-time=<n>`（**注意只有单个 `?`，与 A 套的 `?&-time=` 不同**） | 秒 | 同上 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:299-303` |
| 校时 | `setsystime.cgi?-time=yyyyMMddHHmmss` | 本地 `System.currentTimeMillis()` 格式化 | `doForSuccess` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:274-288`（type=1） |
| 恢复出厂 | `reset.cgi` | — | 同上（type=2）；另有 `SetDataUtils.resetCamera()` 版本，失败 Toast `R.string.reset_fail` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:279`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:191-195` |
| 格式化 | `sdcommand.cgi?-format&-partition=1` | — | `doForSuccess`（type=3） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:283` |
| 慢动作/快动作直控 | `record.cgi?-cmd=<DV.Strmode>` | 模式串直接当 cmd（含空格→`%20`） | 只判 200 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:232-238` |
| 相机状态（读） | `/cgi-bin/hi3510/getcamerastatus.cgi` | — | 按 `[;\n]\|Var` 切，找 `count=` / `status=`；**任一缺失返回 null**（真机 200 空 body ⇒ null） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:142-169` |
| 相机状态（写） | `/cgi-bin/hi3510/setcamerastatus.cgi?-status=<int>`（**`?` 而非 `?&-`**） | — | 200 且 body 含 `SSResponseParse.SS_SUCCESS`(=`"Success"`) 才算成功，成功后再读一次 status | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:171-195`；`…/sigmastar/data/SSResponseParse.java:41` |
| 当前全量状态 | `getcurallinfo.cgi`（`VERSION==1`）或 `getallinfo.cgi`（`VERSION==2`） | — | `getMap` → `mode`,`state`,`event`,`pasttime`；`VERSION==2` 时 `mode` 是数字要经 `replaceMode()` 映射；最后拼成**伪 JSON 广播** `{"mode":"X";"state":"Y";"event":"Z";"pasttime":"W"}` 发 `com.gku.xtugo.MESSAGE_ACTION` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:305-317` |
| WiFi 信息 | `getwifi.cgi` | — | `getMap2` → 回调 `getWifiIsFinish(treeMap)`；键集合由设备决定 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:318-332` |

`replaceMode(int)` 的完整映射（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:319-346`）：`0→NormalPhoto("NormalPhoto")`、`1→TimerPhoto`、`10→Burst`、`11→TimerPhoto`（**与 1 重复，11 在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:151` 是 `WORK_MODE_MULTI_TIMELAPSE`，映射到 TimerPhoto 是老代码错误**）、`20→NormalVideo("NormalVideo")`、`21→CarMode`、`22→VideoLapse`、`23→VideoPhoto`、`24→SlowRec`、其余→`""`。

### 2.2 `SSCommandUtil`（SigmaStar 机型的规范路径，`/cgi-bin/hi3510/<cmd>.cgi`）

`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java`，34 个方法（`:49-184`），命令名片段常量见 `:9-43`。与 A 套不同处：

| 命令 | SSCommandUtil 串 | 差异 | 行 |
|---|---|---|---|
| 预览 | `rtsp://192.168.0.1:554/livestream/12` | 只用 `SSConstant.SS_IP`，**不跟随实际网关** | `:49-51` |
| 文件计数 | `getfiletypecount.cgi` | A 套用 `getfilecount.cgi` | `:22,57-59` |
| 文件列表 | `getfilelist.cgi?-start=&-end=&-type=(Photo\|Video)` | 多了 `-type`；`type==0→"Photo"`，非 0→`"Video"` | `:65-71` |
| 列表带信息 | `getfilelistinfoios.cgi?-start=&-end=` | 参数前缀是 `?`（A 套是 `?&-`） | `:73-75` |
| 目录 | `getdirname.cgi` → 解析 `value` 逗号切分 | **A 套没有这个命令** | `:21,61-63`；解析 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:54-66` |
| 当前参数 | `getcurparameter.cgi?-workmode=&-name=` | `HaisiCommandUtil` 同名方法却指向 `getsecondmenuitem`（`:20`）—— 两套常量有一处不一致 | `:18,113-115` |
| 写参数 | `setcurparameter.cgi?-workmode=&-name=&-value=` | — | `:117-119` |
| 旋转 | `getcurrotation.cgi` | **A 套没有** | `:27,173-175` |
| 拍照 | `photo.cgi?-type=<type>&-cmd=start\|stop` | 参数顺序 `type` 在前、无前置 `&` | `:149-155` |
| 录像 | `record.cgi?-cmd=start\|stop` | — | `:141-147` |
| 快录退出 | `exitquickrec.cgi` | — | `:157-159` |
| WiFi 改名 | `setwifi.cgi?&-wifissid=<ssid>&-wifikey=<key>` | 与 A 套一致但**同步 HTTP 走**（不是 socket 直发） | `:125-127` |
| 格式化 | `sdcommand.cgi?-format&-partition=1` | — | `:129-131` |
| 恢复出厂 | `reset.cgi` | — | `:133-135` |
| QuickStories 加时长 | `record.cgi?-cmd=<"Storie" \| "Quick Stories">` | **按机型名改写字面量**：`name.endsWith("S7PRO") \|\| name.endsWith("S7PRO MAX")` → `Storie`（少了结尾 `s`，是固件侧的真实拼写），否则 `Quick Stories` | `:177-184` |

`HaisiCommandUtil`（`com/gku/actioncam/sigmastar/HaisiCommandUtil.java`）是同一份的**海思变体**，3 处差异：`SS_GET_CUR_PARAM = "getsecondmenuitem"`（`:20`）、`SS_GET_FILE_COUNT = "getfilecount"`（`:23`，无 `-type`）、`SS_LIVE_STREAM_PORT` 是 `int 554`（`:32`）；另有 `getexecuteCommand(int cmd)`（`:60-69`）把 A 套 `Command.cgiFilesParams` 索引直接拼成 `<CGI_PATH><表项>`，以及 `quickStoriesAddTime()` 固定 `record.cgi?-cmd=Quick Stories`（`:192-194`，不做机型改写）。

### 2.3 拍摄命令索引（B 套的「模式→索引→A 套串」三层映射）

`HaisiPreviewModel.commandOperation(allWorkMode, curWorkMode, workState)`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/HaisiPreviewModel.java:340-394`）产出索引 `i`，交给 `HaisiCommandUtil.getexecuteCommand(i)`（内部再按 `IsNewAPP` 折叠，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:53-58`）：

| 当前模式串（`curWorkMode`） | `type=="34220"` 且 state≠20 | state==20 (WORKING) | state≠20 (STANDBY) | 最终 CGI |
|---|---|---|---|---|
| `NormalVideo`、`Normal Video`、`Quick Stories`、`Under Water`、`Time Stretch`、`Manual Recsnap` | → `0`（不发送/发索引 0） | 12 | 11 | `/record2.cgi?&-type=common&-cmd=stop` / `start` |
| `Loop Video`、`CarMode`、`Car Looping` | — | 14 | 13 | `/record2.cgi?&-type=loop&-cmd=stop` / `start` |
| `VideoLapse`、`Timelapse Video` | — | 16 | 15 | `/record2.cgi?&-type=timelapse&-cmd=stop` / `start` |
| `VideoPhoto`、`Video and Photo` | — | 18 | 17 | `/record2.cgi?&-type=recsnap&-cmd=stop` / `start` |
| `SlowRec`、`Slow Motion` | — | 20 | 19 | `/record2.cgi?&-type=slow&-cmd=stop` / `start` |
| `NormalPhoto`、`Normal Photo`、`Night Photo`、`Raw Photo`、`Long Exposure` | — | — | — | 恒 2 → `/photo.cgi?&-type=photo` |
| `TimerPhoto`、`Timing Photo` | — | 7 | 6 | `/photo.cgi?&-type=phototimer&-cmd=stop` / `start` |
| `Lapse Burst` | — | — | — | 恒 2（`workState.getState()` 结果被丢弃，`:364-366`） |
| `Burst`、`Burst Photo` | — | — | — | 恒 3 → `/photo.cgi?&-type=photoburst` |
| `PhotoLapse`、`Timelapse Photo`、`Night Timelapse Photo`、`Night Scene` | — | 5 | 4 | `/photo.cgi?&-type=phototimelapse&-cmd=stop` / `start` |
| `Quick Video` | 同上 `34220` 特判 | 12 | 11 | `/record2.cgi?&-type=common…` |
| 其它 | — | — | — | **-1**（越界，`getexecuteCommand` 捕获后返回 `""` → 请求 `http://<ip>/cgi-bin/hi3510` 裸路径） |

**这是「录像/拍照/连拍/延时/慢动作」的完整可复现状态机**，`state==20` 表示正在录制（对应 `CAMERA_STATE_WORKING_STR`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:23`）。

### 2.4 C 套（最新 App 层）的文件浏览

| 命令 | 海思分支（`HisiApiUtils.isHisi()==true`） | SigmaStar/3518 分支 | file:line |
|---|---|---|---|
| 计数 | `/cgi-bin/hi3510/getfilecount.cgi`，键 `count` | `/cgi-bin/hi3510/getfiletypecount.cgi`，键 `videocount`（视频页）/ `imagecount`（照片页）/ `eventcount`（事件） | `com/gku/hisi/Hisi_CameraRecordFragment.java:322-330`；`…/Hisi_CameraPicFragment.java:322-330`；键集合 `…/sigmastar/data/SSResponseParse.java:68-115` |
| 列表 | `/cgi-bin/hi3510/getfilelistinfoios.cgi` + `-start`,`-end` | `/cgi-bin/hi3510/getfilelist.cgi` + `-start`,`-end`,`-type=Video\|Photo` | `_work/xtu_src/sources/com/gku/hisi/Hisi_CameraRecordFragment.java:361-364`；`_work/xtu_src/sources/com/gku/hisi/Hisi_CameraPicFragment.java:361-363` |
| 分页 | `PAGE_SIZE=50`，`end = start+50-1`，递归 `start+PAGE_SIZE` 直到取满 count | 同 | `_work/xtu_src/sources/com/gku/hisi/Hisi_CameraRecordFragment.java:56,352-405`；`_work/xtu_src/sources/com/gku/hisi/Hisi_CameraPicFragment.java:53` |
| 缩略图 | `http://<ip>/<path 去扩展名>.THM` | `http://<ip>/thumb/<path 去扩展名>.jpg` | `_work/xtu_src/sources/com/gku/hisi/Hisi_CameraPicFragment.java:150-154`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:83,87` |
| 旋转角 | `rotation` 字段，只有匹配 `0\|90\|180\|270` 才用于 Glide 旋转 | 同 | `_work/xtu_src/sources/com/gku/hisi/Hisi_CameraPicFragment.java:156` |
| 删除 | `/cgi-bin/hi3510/deletefile.cgi` + `-name=<path>`（逐条，倒序） | 同 | `com/gku/module_camera/hisi/dialog/DialogHisiSDMediaDelete.java:106` |
| 下载 | 8080 socket（`SocketHisiFile`，见附录 C） | 同 | `com/gku/module_camera/hisi/HisiDownloader.java:75,341` |
| DCIM 落位 | `<外置>/DCIM/<DCIM\|DCIM/Camera>/<video\|photo>/<displayName>`，Android 9 以下走 `_9_down` 分支 | 同 | `_work/xtu_src/sources/com/gku/module_camera/hisi/HisiDownloader.java:103-131` |

**判定函数（第 4 个平台分派点）**：`HisiApiUtils.isHisi()` = `!("Hi3518EV300".equals(device_name) || device_type=="SSC8838" || device_type=="SSC8826")`（`com/gku/module_base_xtugo/HisiApiUtils.java:25-27`）。注意：① 用 `name` 而非 `type` 去比 `Hi3518EV300`（该串其实是芯片名被塞进了 name）；② **不含 `SSC8838C`**，所以 8838C 机型会被判成「海思」；③ `device_name/device_type` 由 `_work/xtu_src/sources/com/gku/HomeActivity.java:1761-1762` 在连接成功时写入，未连接时是空串 → `isHisi()==true`。

---

## 3. CGI 路径与 query 键的完整清单（去重）

### 3.1 路径（127 条 httpPaths 里的 CGI 部分 + `SSCommandUtil`/`HaisiCommandUtil` 组装出的全部命令）

```
/cgi-bin/hi3510/getdeviceattr.cgi        /cgi-bin/hi3510/getactivateinfo.cgi
/cgi-bin/hi3510/setactivateinfo.cgi      /cgi-bin/hi3510/settrial.cgi
/cgi-bin/hi3510/getallinfo.cgi           /cgi-bin/hi3510/getcurallinfo.cgi
/cgi-bin/hi3510/getallworkmode.cgi       /cgi-bin/hi3510/getcurworkmode.cgi
/cgi-bin/hi3510/setcurworkmode.cgi       /cgi-bin/hi3510/getprimarymenuitem.cgi
/cgi-bin/hi3510/getsecondmenuitem.cgi    /cgi-bin/hi3510/getcurparameter.cgi
/cgi-bin/hi3510/setcurparameter.cgi      /cgi-bin/hi3510/getworkmode.cgi
/cgi-bin/hi3510/setworkmode.cgi          /cgi-bin/hi3510/getcapability.cgi
/cgi-bin/hi3510/getparameter.cgi         /cgi-bin/hi3510/setparameter.cgi
/cgi-bin/hi3510/record.cgi               /cgi-bin/hi3510/record2.cgi
/cgi-bin/hi3510/photo.cgi                /cgi-bin/hi3510/exitquickrec.cgi
/cgi-bin/hi3510/getvideoinfo.cgi         /cgi-bin/hi3510/setvideoinfo.cgi
/cgi-bin/hi3510/getbatterycapacity.cgi   /cgi-bin/hi3510/getsdstate.cgi
/cgi-bin/hi3510/getviewfield.cgi         /cgi-bin/hi3510/setviewfield.cgi
/cgi-bin/hi3510/getlooprecord.cgi        /cgi-bin/hi3510/setlooprecord.cgi
/cgi-bin/hi3510/getflip.cgi              /cgi-bin/hi3510/setflip.cgi
/cgi-bin/hi3510/getburstinfo.cgi         /cgi-bin/hi3510/setburstinfo.cgi
/cgi-bin/hi3510/gettimelapseinfo.cgi     /cgi-bin/hi3510/settimelapseinfo.cgi
/cgi-bin/hi3510/gettimerinfo.cgi         /cgi-bin/hi3510/settimerinfo.cgi
/cgi-bin/hi3510/getrecordtimelapse.cgi   /cgi-bin/hi3510/setrecordtimelapse.cgi
/cgi-bin/hi3510/getbootaction.cgi        /cgi-bin/hi3510/setbootaction.cgi
/cgi-bin/hi3510/getaudioencode.cgi       /cgi-bin/hi3510/setaudioencode.cgi
/cgi-bin/hi3510/getvideonorm.cgi         /cgi-bin/hi3510/setvideonorm.cgi
/cgi-bin/hi3510/setsystime.cgi           /cgi-bin/hi3510/getspotmeter.cgi
/cgi-bin/hi3510/setspotmeter.cgi         /cgi-bin/hi3510/gettimeosd.cgi
/cgi-bin/hi3510/settimeosd.cgi           /cgi-bin/hi3510/getledstate.cgi
/cgi-bin/hi3510/setledstate.cgi          /cgi-bin/hi3510/getbuzzer.cgi
/cgi-bin/hi3510/setbuzzer.cgi            /cgi-bin/hi3510/getautoshutdown.cgi
/cgi-bin/hi3510/setautoshutdown.cgi      /cgi-bin/hi3510/getscreenautosleep.cgi
/cgi-bin/hi3510/setscreenautosleep.cgi   /cgi-bin/hi3510/getscreenbrightness.cgi
/cgi-bin/hi3510/setscreenbrightness.cgi  /cgi-bin/hi3510/getpoweronuimode.cgi
/cgi-bin/hi3510/setpoweronuimode.cgi     /cgi-bin/hi3510/getbitrate.cgi
/cgi-bin/hi3510/setbitrate.cgi           /cgi-bin/hi3510/getwifichannel.cgi
/cgi-bin/hi3510/setwifichannel.cgi       /cgi-bin/hi3510/getdevcapabilities.cgi
/cgi-bin/hi3510/wifisleep.cgi            /cgi-bin/hi3510/upgrade.cgi
/cgi-bin/hi3510/sdcommand.cgi            /cgi-bin/hi3510/reset.cgi
/cgi-bin/hi3510/setwifi.cgi              /cgi-bin/setwifista.cgi
/cgi-bin/hi3510/getwifi.cgi              /cgi-bin/hi3510/getfilecount.cgi
/cgi-bin/hi3510/getfiletypecount.cgi     /cgi-bin/hi3510/getfilelist.cgi
/cgi-bin/hi3510/getfilelistinfoios.cgi   /cgi-bin/hi3510/getfileinfo.cgi
/cgi-bin/hi3510/deletefile.cgi           /cgi-bin/hi3510/deleteallfiles.cgi
/cgi-bin/hi3510/getcamerastatus.cgi      /cgi-bin/hi3510/setcamerastatus.cgi
/cgi-bin/hi3510/getcurrotation.cgi       /cgi-bin/hi3510/getdirname.cgi
/cgi-bin/hi3510/fileupload.cgi           /thumb<path>（非 .cgi）
```

**统计**：共 **63** 条 `.cgi` 端点（含 1 条 `/cgi-bin/` 根下的 `setwifista.cgi`）+ 1 条非 CGI 的 `fileupload.cgi`（属 CGI）→ 63 条。

### 3.2 query 键全集（含前导 `-`，逐条）

`-cmd` · `-type` · `-resolution` · `-fps` · `-fov` · `-enable` · `-time` · `-count` · `-action` · `-videonorm` · `-brightness` · `-uimode` · `-bitrate` · `-wifichannel` · `-workmode` · `-name` · `-value` · `-start` · `-end` · `-partition` · `-format`（裸标志） · `-status` · `-version` · `-ssid` · `-key` · `-wifissid` · `-wifikey`

共 **27** 个键。拼接形态有 3 种，必须原样区分（固件按字面解析）：
1. `?&-k=v`（如 `record.cgi?&-cmd=start`、`setvideoinfo.cgi?&-resolution=…`）
2. `?-k=v`（如 `sdcommand.cgi?-format&-partition=1`、`setcamerastatus.cgi?-status=`、`setcurworkmode.cgi?-workmode=`、`setsystime.cgi?-time=`、`settimelapseinfo.cgi?-time=`）
3. `?` / `??` 结尾无参（如 `getallinfo.cgi??` 有**两个问号**）

---

<!-- 以下整段合并自原 02-XTUGO-档案-附录-Ambarella报文全表.md（2026-09-22 文档归并，内容未改） -->
# 附录 B · Ambarella 报文全表（XTU GO 8.4.3）

> 主文档：[XTU GO 档案](xtugo.md)
> 适用机型：`type ∈ {"H75N", "CV75"}`（`com/gku/actioncam/sigmastar/SSConstant.java:5` + 裸字面量 `"CV75"`）。真机分派入口见主文档 §2.3。
> 双 socket：**7878 命令口**（`AmbaConstant.AMBA_CMD_PORT`）+ **8787 数据口**（`AMBA_DATA_PORT`），均为 TCP，主机 = 网关 IP（通常 `192.168.0.1`）。
> `_work/xtu_src/sources/com/gku/actioncam/amba/AmbaConstant.java:5-7`

---

## 1. 报文结构

### 1.1 命令口 7878：**没有二进制头**

| 维度 | 事实 | 证据 |
|---|---|---|
| 魔术字 | 无 | `_work/xtu_bad/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:142` 仅 `outputStream.write(str.getBytes())` |
| 长度前缀 | 无 | 同上，整条发送 |
| 校验和/CRC | 无 | 全类无 |
| 字节序 | 不适用（纯文本 JSON） | — |
| 编码 | UTF-8（`String.getBytes()` 用平台默认，Android 即 UTF-8）；Gson `disableHtmlEscaping()` | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:59`（`new GsonBuilder().disableHtmlEmplacing… disableHtmlEscaping().create()`） |
| 分隔 | 无；靠「累积到能被 Gson 解析」判定一条完整（§1.3） | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:191` |
| 读缓冲 | `byte[65536]`，单线程 `ExecutorService`（`newSingleThreadExecutor`） | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:56-58`（src 版同 `:53-57`） |
| 连接超时 | `5000ms` 硬编码（`connect(...,5000)`），`soTimeout` 由调用方给（`startSession` 传 5000） | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:101-105`；`_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:146` |
| 空闲轮询 | 无待发出命令时 `setSoTimeout(10)`（10ms 轮询），有命令时 `setSoTimeout(soTimeout)` | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:175` |
| 网络绑定 | `NetworkDeviceUtils.getNetworkDevice().getSocketFactory().createSocket()` —— VPN/多网络共存关键 | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:100`；`_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:146` |
| 收满即断 | 收到 `read() < 0` → `callbackCmd.onFail(SocketErrorCode.EOF)` | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:177-189`（`lambda$run$0`） |

### 1.2 请求体字段全集（Gson 按字段名直接序列化，无 `@SerializedName`）

| 字段 | 类型 | 出现的 bean | 语义 |
|---|---|---|---|
| `msg_id` | int | `CmdRequestBean`（基类，`bean/CmdRequestBean.java`） | 命令号（§2 全表） |
| `token` | int | `CmdRequestBean` | 会话号；由 `AmbaConnector.sendCmd` 统一 `setToken(sessionId)` 注入（`connector/AmbaConnector.java:248,287`），初始 `-1000`（`:112`） |
| `param` | String | `StringParamRequestBean` | 通用字符串参 |
| `param` | int | `IntParamRequestBean` | 通用整型参（同一 JSON 名，类型不同） |
| `type` | String | `SetClntInfoRequestBean`、`GetThumbRequestBean` | 客户端类型 `"TCP"` / 缩略图类型 |
| `workmode` | String | `GetPrimaryMenuItem`、`GetSecondMenuItemRequestBean`、`SetCurParameterRequestBean` | 工作模式 |
| `name` | String | `GetSecondMenuItemRequestBean`、`SetCurParameterRequestBean` | 菜单项名 |
| `value` | String | `SetCurParameterRequestBean` | 菜单项值 |
| `start` / `end` | int | `GetFileInfoListRequestBean`、`GetFilePathListRequestBean` | 列表分页区间（**闭区间**，`end` 由调用方给） |
| `path` | String | `GetFileRequestBean`（+`offset`/`fetch_size`） | 文件绝对路径 |
| `offset` | long / int | `GetFileRequestBean`、`PutFileRequestBean` | 续传偏移，代码恒传 `0` |
| `fetch_size` | long | `GetFileRequestBean` | 取多少字节，恒传 `0`（=全部） |
| `size` | long | `PutFileRequestBean` | 待写文件字节数 |
| `md5sum` | String | `PutFileRequestBean` | 文件 MD5（`FileUtils.getFileMD5`） |
| `sent_size` | int | `CancelPutFileRequestBean` | 取消上传时已发字节数 |
| `ssid` / `pwd` | String | `SetWifiRequestBean` | 改相机 AP |

### 1.3 分帧规则（唯一一种）

```
读 n 字节 → sb.append(new String(buf,0,n))            _work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:176,186
   ↓
GsonUtils.isValidJson(sb.toString()) ?                _work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:191
   ├ 否 → 继续读、继续 append（累积）
   └ 是 → fromJson 成 CmdResponseBean
          ├ 解析对象为 null → onFail(-103) 并 break     :194-204
          ├ 有请求在等 (z==true) 且 resp.msg_id == req.msg_id
          │     ├ req.msg_id==257 → 清空待发表          :207-209
          │     └ onSuccess(sb.toString())  并 break    :210-220
          └ 否则 → onPushMsgReceive(sb.toString())      :221-228
                   sb.delete(0, sb.length())            :226
                   若 !z → break（回到外层等下一条命令）
```

`GsonUtils.isValidJson(String)` = `JsonParser.parseString(str)` 不抛异常即 true（`com/gku/base/utils/GsonUtils.java:7-17`）。
含义：**任何能被 Gson 当作合法 JSON 前缀解析的碎片都可能被误判为完整报文**（`JsonParser` 宽松），这是官方实现的脆弱点，复现时应改成显式 `}`-配平或大括号计数。

响应匹配只看 `msg_id`，不看 `token`、不看请求内容（`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:206`）；因此并发命令会串扰 —— 官方用「同一时刻只有一条待发命令」规避：`mapMsgQueue` 取第一条就发（`:119-131`），且发送前 `cancelCmd(自己)`（`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:141` src 版）。

### 1.4 会话生命周期

| 步 | 动作 | file:line |
|---|---|---|
| 1 | `AmbaConnector.startSession(ctx, cb)` → 先 `stopSession()`（若上次 sessionId>0 则置 `shouldCallStartSessionOnAppStart=true`） | `connector/AmbaConnector.java:142-146,210-219` |
| 2 | `SocketAmbaCmd.start(network, ip, 7878, 5000, cb)` | `:146` |
| 3 | 连上 → 清空待发队列 → `onSocketConnect()` 回调 | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:106-115` |
| 4 | 发 `{msg_id:257, token:0}`（`start_session`），拿响应 `param`(int) 当 sessionId | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:161-167` |
| 5 | 立刻发 `{msg_id:261, type:"TCP", param:<手机IP>, token:sessionId}`（`set_clnt_info`） | `:168`；手机 IP 来自 `WifiUtils.getWiFiPhoneIp(appCtx)` |
| 6 | 两步都成功 → `CallbackSession.onSuccess()`；任一步失败 → `stopSession()` + `onFail(code)` | `:169-180` |
| 7 | App 进后台 → `AmbaConnector.stopSession()`（发 `{msg_id:258, token:sessionId}` 并关 socket）；进前台且 `isShouldCallStartSessionOnAppStart()` → 重新 startSession | `com/gku/HomeActivity.java:549-556`；`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:144-146` |
| 8 | 任意命令在 `sessionId<=0` 且 `msg_id!=257` 时**本地直接失败** `-107` | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:240-246,278-280` |

超时重试：`sendCmdQueueTimesIfTimeOut(..., times)` → 只有 `onFail(-102)`（读超时）会重试，重试次数 `times-1` 递减，耗尽回调 `CODE_ERROR_AMBA_NO_RETRY_TIMES=-109`；重试前用 Gson 把请求 bean 深拷贝一份（`_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:277-318`）。实际用到重试的命令：`setCurWorkMode(3)`、`record_stop(3)`、`getSystemWorkState(3)`、`getPrimaryMenuItem(3)`、`getSecondMenuItem(3)`、`setClientInfo(3)`、`setCurParameter(3)`、`putFile(3)`、`uploadStreamData(3)`（`com/gku/actioncam/amba/model/AmbaCmdModel.java:224,240,244,252,315,279,329,337,386`）。

---

## 2. `msg_id` 全表（穷尽，含语义）

来源：`com/gku/module_camera/amba/connector/AmbaConnector.java:35-77`（`MSG_ID_*`，公开权威表）+ `com/gku/actioncam/amba/model/AmbaCmdModel.java:46-130`（`AMBA_*` 私有镜像表）。两表**完全一致**，除 `AmbaCmdModel` 额外有 `AMBA_GET_APP_CONNECT_STATE`、`AMBA_GET_GPS_STATE`、`AMBA_HEART_BEAT`、`AMBA_POWER_MANAGE`、`AMBA_QUERY_SESSION_HOLDER`、`AMBA_RESETVF`、`AMBA_SET_ATTRIBUTE`、`AMBA_SET_BITRATE`、`AMBA_ZOOM*`、`AMBA_CD/LS/DEL/PWD/PUT/GET/CANCLE_XFER`、`AMBA_GET_OPTIONS/GET_SETTING/SET_SETTING/GET_SPACE/GET_NUM_FILES/NOTIFICATION/FORMAT_SD/GET_ALL/GET_DEVICE_INFO/BURN_FW/BATTERY_LEVEL` 等旧 PTP 风格号（`2..16`、`1281..1287`、`1537..1542`、`1793`）—— 这些**只有 257/258/259/260/261/769/770/1025/1026/1027/1285/1286/1287/1538/1539 被 `AmbaCmdModel` 真正调用过**，其余是历史包袱（在 `handleResponse` 里有分支但无发送方）。

### 2.1 会话/系统

| msg_id | 名称 | 请求体 | 响应字段 → 事件 | 调用方 |
|---|---|---|---|---|
| `257` | `MSG_ID_START_SESSION` / `AMBA_START_SESSION` | `{msg_id:257, token:0}` | `param`(int)=sessionId → 事件 `13 CONNECTED`（隐含） | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:161` |
| `258` | `MSG_ID_STOP_SESSION` | `{msg_id:258, token:<sid>}` | 发送后**立即 stop()** | `:215-217`；`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:144` |
| `261` | `MSG_ID_SET_CLINT_INFO` | `{msg_id:261, type:"TCP", param:"<手机IP>", token:<sid>}` | 无字段消费（只判成功） | `:168`；`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:278-280`。**必须先于任何取文件/缩略图**（`getThumb()` 内部先调 `setClientInfo`，`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:352-363`） |
| `259` | `AMBA_RESETVF`（`@Deprecated resetVF`） | `{msg_id:259, param:"none_force"}` | 事件 `9 RESETVF` | `_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:319-321` |
| `260` | `AMBA_STOP_VF`（`@Deprecated stopVF`） | `{msg_id:260}` | 事件 `22 STOP_VF` | `:324-326` |
| `268435467` | `MSG_ID_HEART_BEAT` | `{msg_id:…}` | 未在 `handleResponse` 中出现 | 声明但**无发送方** → 死号 |
| `268435469` | `AMBA_GET_APP_CONNECT_STATE` | — | 同上，死号 | |
| `268435468` | `AMBA_GET_GPS_STATE` | — | 同上，死号（GPS 叠加不走这里，见附录 D §11） | |
| **`268435492`** | **`MSG_ID_BLUETOOTH_HEARTBEAT`「蓝牙心跳」** | `{msg_id:268435492, token:<sid>}`，**无参** | 不进 `handleResponse` 分支（落入 default 的无匹配） | `AmbaCmdModel.updateBTheartbeat()` `:381-383`；触发条件 `…/newUi/common/model/BTHeartbeatManage.java:18`：`type∈{H75N,"CV75"} && name.toUpperCase().endsWith("S7")` |
| `268435490` | `MSG_ID_SET_STREAM_DATA` | `{msg_id:…, param:<串>}` | 只判成功，重试 3 次 | `_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:385-387`（直播推流数据上报） |
| `268435505` / `268435506` | `MSG_ID_GET_ACTIVATE` / `MSG_ID_SET_ACTIVATE` | GET 无参；SET `{status:"<String>"}` | `status/version/number/macaddr` → `GetActivateStatusResposeBean` | `bean/GetActivateStatusResposeBean.java`、`SetActivateStatusRequestBean.java`；调用点 `_work/xtu_src/sources/com/gku/HomeActivity.java:690-712` |

### 2.2 模式与菜单

| msg_id | 名称 | 请求 | 响应字段 | 事件号 | file:line |
|---|---|---|---|---|---|
| `268435457` | `GET_ALL_WORKMODE` | 无参 | `var photo`(JSONArray)、`var video`(JSONArray) → `getJSONArray(...).toString()` | 48 | `_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:215-217,729-738` |
| `268435458` | `GET_CUR_WORKMODE` | 无参 | `var workmode`(String) | 49 | `:219-221,739-745` |
| `268435459` | `SET_CUR_WORKMODE` | `param=<模式串>` | `param`(String) | 50 | `:223-225,746-751` |
| `268435460` | `GET_PRIMARY_MENU_ITEM` | `workmode=<模式>` | `var item`(String, 逗号分隔)、`var cur`(String) | 58 | `:251-253,752-761` |
| `268435461` | `GET_SECOND_MENU_ITEM` | `workmode=<模式>&name=<项>` | `var item`(逗号切分成数组)、`var cur` | 64 | `:314-316,762-768` |
| `268435463` | `SET_CUR_PARAMETER` / `GET_CUR_PARAMETER` | `{workmode, name, value}`；空 bean 形式即「读」 | `param`(项名)、`value`(当前值) | 65 | `:306-307,328-330,558-564` |
| `268435489` | `GET_ROTATE` | `{}`（`StringParamRequestBean` 但 param 不设 → JSON 里无 `param`） | `var rotation` | 70 | `:290-292,652-657` |
| `268435466` | `GET_SYSTEM_WORK_STATE` | 无参 | `var mode`(String)、`var state`(int)、`var event`(long)、`var pasttime`(int) | 55；`event==268632077`→1027（拍照开始）、`event==268632078`→1028（拍照结束） | `:243-245,565-586` |
| `268435488` | `QS_ADD_TIME`（QuickStories 加时长） | `param = 5`（**int，固定 5 秒**） | `param` | 67 | `:377-379,646-651` |

### 2.3 拍摄

| msg_id | 名称 | 请求 | 响应 | 事件 |
|---|---|---|---|---|
| `513` | `RECORD_START` | 无参 | 无字段 | 53 |
| `514` | `RECORD_STOP` | 无参（**重试 3 次**） | `param`（录制时长字符串） | 54 → `onChannelEvent(54,"",param)` |
| `515` | `AMBA_RECORD_TIME` | — | `param` | 21 |
| `516` | `AMBA_FORCE_SPLIT` | — | — | 声明未用 |
| `769` | `TAKE_PHOTO` | 无参 | `param` | 51 → `onChannelEvent(51,"",param)` |
| `770` | `STOP_PHOTO` | 无参 | — | 52 |
| `268632077` | `AMBA_TAKE_PHOTO_START` | — | 出现在 268435466 的 `event` 里 | 1027 |
| `268632078` | `AMBA_TAKE_PHOTO_END` | 同上 | | 1028 |

`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:95-97,110-117,227-245,483-487,545-550,684-699`

### 2.4 存储与文件

| msg_id | 名称 | 请求 | 响应字段 | 事件 | file:line |
|---|---|---|---|---|---|
| `268435475` | `GET_SD_STATE` | 无参 | `sdstatus`(int)、`sdfreespace`(int)、`sdtotalspace`(int) | 57 | `:247-249,777-784` |
| `268435476` / `4` | `SD_FORMAT` / `MSG_ID_FORMAT_SD` | `{msg_id:4, param:"C:"}`（**盘符固定 `"C:"`**） | — | 18 | `:332-334,467-473` |
| `268435477` | `RESET_FACTORY` | 无参 | — | 66 | `:340-342,587-591` |
| `268435474` | `SYNC_SYSTEM_TIME` | `param=<时间串>` | — | 61 | `:302-304,771-776` |
| `268435480` | `GET_BTATERY_INFO`（原拼写） | 无参 | **`var capacity=`**（键名自带尾随 `=`！）、`var charge`、`var ac` | 56 | `:344-346,592-599` |
| `268435482` | `GET_FILE_COUNT` | 无参 | `var count`(int) | 59 | `:255-257,600-605` |
| `268435483` | `GET_FILE_LIST` | `{start,end}` | `filelist`(String) → 按 `,` split | 68 | `:266-268,606-611` |
| `268435484` | `GET_FILE_INFO` | `{param:<path>}` | `param` | 69 | `:270-272,612-617` |
| `268435485` | `GET_FILELIST_INFO_IOS` | `{start,end}` | `fileinfolist`：按 `,` 切条目，每条按 `;` 切 4 段 → `fileName,fileCreateTime,fileTimeLong,fileSize` | 60（重建 `JSONArray`） | `:259-264,618-633` |
| `268435486` | `DELETE_FILE` | `{param:<path>}` | `rval` | 62 | `:282-284,634-639` |
| `268435487` | `DELETE_ALL_FILE` | `{param:<fileType int>}` | `rval` | 63 | `:286-288,640-645` |
| `1025` | `GET_THUMB` | `{param:<path>, type:<类型>}`；**前置必须 `setClientInfo(261)`** | `path`(String)、`size`(int) | 37 | `:348-363,702-709` |
| `1026` | `AMBA_GET_MEDIAINFO` | — | `thumb_file`(可缺)、`duration`、`resolution`、`size`、`date`、`media_type` 拼成一个字符串 | 8 | `:710-721` |
| `1027` | `AMBA_SET_ATTRIBUTE` | — | `rval` | 36 | `:722-726` |
| `1285` | `GET_FILE` | `{param:<path>, offset:0, fetch_size:0}` | `path`、`size` | 7（`onChannelEvent(7,null,path,size)`）→ 之后再连 8787 拉裸数据 | `:274-276,516-526` |
| `1286` | `PUT_FILE` | `{param:<"/tmp/SD0/"+文件名>, size:<bytes>, md5sum:<md5>, offset:0}` | — | 19 | `:336-338,527-533`；路径拼装 `_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:366` |
| `1287` | `CANCLE_XFER`（原拼写） | `{param:<path>, sent_size:<int>}` | — | — | `:373-375`；`_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:328-351` |
| `1281`/`1282`/`1283`/`1284` | `DEL`/`LS`/`CD`/`PWD` | — | `1282` 回整对象→事件 5；`1281`→事件 6 | 5,6 | `:502-515`（**无发送方**，历史 PTP 残留） |

### 2.5 WiFi/蓝牙/其它

| msg_id | 名称 | 请求 | 响应 | 事件 | file:line |
|---|---|---|---|---|---|
| `1538` | `SET_WIFI_SETTING` | `{ssid:<新名>, pwd:<新密码>}` | — | — | `:369-371` |
| `1539` | `GET_WIFI_SETTING` | 无参 | `ssid`、`pwd`（**明文回传当前 AP 密码**） | 41 → `onChannelEvent(41,null,ssid,pwd)` | `:365-367,551-557`；`_work/xtu_src/sources/com/gku/HomeActivity.java:1787-1800` |
| `1537`/`1540`/`1541`/`1542` | `WIFI_RESTART`/`WIFI_STOP`/`WIFI_START`/`WIFI_STATUS` | — | — | — | 仅常量（`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:85-86,118-120`），**无发送方** |
| `268435507` | `GET_BLUETOOTH_TX` | `{}`（`StringParamRequestBean`） | `BluetoothDevOne`、`BluetoothDevTwo`（缺省 `""`） | 71 | `:294-296,658-664` |
| `268435508` | `MSG_ID_PAIR_AND_GET_BLUETOOTH_TX` | `{}` | 同上（复用） | 71（假定） | `:298-300`；`_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:59` |
| `1793` | `AMBA_QUERY_SESSION_HOLDER` | — | — | 40 | `_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:94`（无发送方） |
| `11` | `GET_CAMERA_INFO` / `AMBA_GET_DEVINFO` | 无参 | 全字段映射成 `CameraInfoBean`/`CameraInfors`（主文档 §2.3） | 17 | `:211-213,540-544`；`_work/xtu_src/sources/com/gku/HomeActivity.java:586` |
| `13`/`14`/`15`/`16` | `BATTERY_LEVEL`/`ZOOM`/`ZOOM_INFO`/`SET_BITRATE` | — | `param` | 20（带前缀 `"Battery Level: "`）、38、39 | `:667-681`（**无发送方**） |
| `9`/`1`/`2`/`3`/`5`/`6`/`7`/`8`/`10`/`12` | `GET_OPTIONS`/`GET_SETTING`/`SET_SETTING`/`GET_ALL`/`GET_SPACE`/`GET_NUM_FILES`/`NOTIFICATION`/`BURN_FW`/… | — | `2`→事件12、`3`→事件10、`5`→事件15(`param`)、`6`→事件16(`param`) | — | `:453-487`（**无发送方**，PTP 时代残留） |

---

## 3. 数据口 8787

| 维度 | 事实 | file:line |
|---|---|---|
| 建立 | `socketFactory.createSocket(ip, 8787)`（**没有帧头、没有 hello**）；`connect(...,5000)` | `com/gku/module_camera/amba/connector/SocketAmbaDownload.java:72-74`；`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaUpload.java:56-57` |
| 下行（取文件/缩略图） | 循环 `inputStream.read(byte[65536])` → `FileOutputStream.write`；累计到 `size` 为止 | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaDownload.java:100-104`；`com/gku/actioncam/amba/socket/DataChannel.java:164-234` |
| 上行（推文件） | `FileInputStream.read(byte[65536])` → `outputStream.write` | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaUpload.java:101-105`；`DataChannel.txStream` 用 1024 块（`:102-124`） |
| 流控 | 无 `available()` 时 `Thread.sleep(100)`，连续 30 次（≈3s）判失败；异常累计 4 次判失败 | `_work/xtu_src/sources/com/gku/actioncam/amba/socket/DataChannel.java:169-183,202-214` |
| 进度 | 每 +1%（`PROGRESS_MIN_STEP=1`）回调一次 | `_work/xtu_src/sources/com/gku/actioncam/amba/socket/DataChannel.java:15,116-123,190-197`；事件 `512 开始 / 513 进度 / 514 完成` |
| 完成校验 | `new File(dstPath).length() == 已收字节数` 才 `onResult(true)` | `_work/xtu_src/sources/com/gku/actioncam/amba/socket/DataChannel.java:228-230` |
| 取消 | `cancelGetFile()` 把 `mContinueTxMap` 全部置 false | `:75-80` |
| 落地临时位置 | `context.getExternalCacheDir() + "/language.json"` 等，再 `copyFileToDCIM` | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaLangHolder.java:44` |

老 `com.gku.actioncam.amba.socket` 与新 `com.gku.module_camera.amba.connector` 是**同一协议的两代实现**，共存；`DataChannelWIFI.java` 只是给 `DataChannel` 加了 WiFi 状态回调的空壳（1747 字节）。

---

## 4. 事件号与错误码

### 4.1 `IChannelListener` 事件（`com/gku/actioncam/amba/socket/IChannelListener.java:4-…`）

| 事件 | 名 | 事件 | 名 | 事件 | 名 |
|---|---|---|---|---|---|
| 1 | `CMD_CHANNEL_EVENT_INIT` | 32 | `START_CONNECT` | 61 | `SYNC_SYSTEM_TIME` |
| 2 | `SHUTDOWN` | 33 | `START_LS` | 62 | `DELETE_FILE` |
| 3 | `LOG` | 34 | `WAKEUP_START` | 63 | `DELETE_ALL_TYPE_FILE` |
| 4 | `SHOW_ALERT` | 35 | `WAKEUP_OK` | 64 | `GET_SECOND_MENU_ITEM` |
| 5 | `LS` | 36 | `SET_ATTRIBUTE` | 65 | `SET_CUR_PARAMETER` |
| 6 | `DEL` | 37 | `GET_THUMB` | 66 | `RESET_FACTORY` |
| 7 | `GET_FILE` | 38 | `SET_ZOOM` | 67 | `QS_ADD_TIME` |
| 8 | `GET_INFO` | 39 | `GET_ZOOM_INFO` | 68 | `GET_FILE_LIST` |
| 9 | `RESETVF` | 40 | `QUERY_SESSION_HOLDER` | 69 | `GET_FILE_INFO` |
| 10 | `GET_ALL_SETTINGS` | 41 | `GET_WIFI_SETTING` | 70 | `GET_ROTATE` |
| 11 | `GET_OPTIONS` | 12 | `SET_SETTING` | 71 | `GET_BLUETOOTH_TX` |
| 13 | `CONNECTED` | 15 | `GET_SPACE` | 128 | `ERROR_TIMEOUT` |
| 16 | `GET_NUM_FILES` | 17 | `GET_DEVINFO` | 129 | `ERROR_INVALID_TOKEN` |
| 18 | `FORMAT_SD` | 19 | `PUT_FILE` | 130 | `ERROR_BLE_INVALID_ADDR` |
| 20 | `BATTERY_LEVEL` | 21 | `RECORD_TIME` | 131 | `ERROR_BLE_DISABLED` |
| 22 | `STOP_VF` | 23 | `START_SESSION` | 132 | `ERROR_BROKEN_CHANNEL` |
| 24 | `STOP_SESSION` | 48 | `GET_ALL_WORK_MODE` | 133 | `ERROR_WAKEUP` |
| 36 | `SET_ATTRIBUTE` | 49 | `GET_CUR_WORK_MODE` | 134 | `ERROR_CONNECT` |
| 50 | `SET_CUR_WORK_MODE` | 51 | `TAKE_PHOTO` | 135 | `ERROR_CONTENT` |
| 52 | `STOP_PHOTO` | 53 | `START_RECORD` | 136 | `ERROR_UNKNOW` |
| 54 | `STOP_RECORD` | 55 | `GET_SYSTEM_WORK_STATE` | 137 | `ERROR_LINK_REFUSE` |
| 56 | `GET_BATTERY_INFO` | 57 | `GET_SD_STATE` | 512/513/514 | `DATA_CHANNEL_EVENT_GET_START/PROGRESS/FINISH` |
| 58 | `GET_PRIMARY_MENU_ITEM` | 59 | `GET_FILE_COUNT` | | |
| 60 | `GET_FILE_LIST_INFO_IOS` | | | | |

### 4.2 应用层错误码

| 码 | 名 | 含义 | file:line |
|---|---|---|---|
| `-1` | `ERROR_UNKNOW` | 未知/解析失败 | `_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:125` |
| `-4` | `ERR_INVALID_TOKEN` | token 不合法 → 事件 129 | `:126,409-415` |
| `-17` | `NO_MORE_SPACE` | 卡满 → **额外 Toast `R.string.sd_no_more_space`（"The memory card is full."）** | `:129,444-451`；文案 `res-strings-default.md:1947` |
| `-18` | `CARD_PROTECTED` | 卡写保护 | `:123,437-443` |
| `-33` | `NO_SD_CARD` | 无卡 | `:130,430-436` |
| `-34` | `ERROR_NO_SUPPORT_PARAM` | 参数不支持 | `:124,423-429` |
| `-444` | `LINK_REFUSE` | 连接被拒 | `:128,402-408` |
| `-101`/`-102` | `CODE_ERROR_AMBA_WRITE` / `_READ` | socket 写/读失败（`-102` 是唯一会触发重试的） | `com/gku/module_camera/amba/ConstantsAmba.java:19,12` |
| `-103` | `CODE_ERROR_AMBA_JSON_PARSE` | Gson 解析失败/结果为 null | `_work/xtu_src/sources/com/gku/module_camera/amba/ConstantsAmba.java:10`；`_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:256,263` |
| `-104` | `CODE_ERROR_AMBA_CONNECT` | 连不上 | `_work/xtu_src/sources/com/gku/module_camera/amba/ConstantsAmba.java:6`；`_work/xtu_src/sources/com/gku/module_camera/amba/connector/SocketAmbaCmd.java:268`（bad 版行号） |
| `-105`/`-106` | `FILE_OUTPUT_STREAM_CREATE` / `DOWNLOAD_CONTENTLENGTH_NOT_EQUALS` | 下载侧 | `_work/xtu_src/sources/com/gku/module_camera/amba/ConstantsAmba.java:9,8` |
| `-107` | `SESSIONID_INVALID` | 未 startSession 就发命令 | `_work/xtu_src/sources/com/gku/module_camera/amba/ConstantsAmba.java:17` |
| `-108`/`-109` | `RVAL_NOT_0` / `NO_RETRY_TIMES` | 业务失败 / 重试耗尽 | `_work/xtu_src/sources/com/gku/module_camera/amba/ConstantsAmba.java:16,14` |
| `-111` | `COPYFILETODCIM_9_NO_PERMISSION` | Android 9 以下拷 DCIM 无权限 | `_work/xtu_src/sources/com/gku/module_camera/amba/ConstantsAmba.java:7` |
| `-112`/`-113`/`-114` | `UPLOAD_CONTENTLENGTH_NOT_EQUALS` / `UPLOAD_INPUT_STREAM_CREATE` / `MSG_ID_PUT_FILE_FAIL` | 上传侧 | `:18,20,13` |
| `-115`/`-116`/`-117` | `MSG_CANCELED` / `MSG_CLEARED` / `TEMP_RENAME` | 命令被取消/被清/临时文件改名失败 | `:11,15,19` |
| `"dfdfew3434gf"` | `CALLBACK_AMBA_GET_INFOED` | 路由回调 key（拿到相机信息） | `_work/xtu_src/sources/com/gku/module_camera/amba/ConstantsAmba.java:4`；`_work/xtu_src/sources/com/gku/HomeActivity.java:762` |
| 任意非 0 `rval` | — | `AmbaConnector` 直接把它当 `onFail(rval)` 抛出，**不映射文案** | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:257-259,297-299` |

---

## 5. 复现要点（照抄即可）

1. `connect(gateway, 7878)` → 发 `{"msg_id":257,"token":0}` → 读回 `{"rval":0,"msg_id":257,"param":<sid>}`，记下 `<sid>`。
2. 发 `{"msg_id":261,"type":"TCP","param":"<手机在 AP 网段的 IP>","token":<sid>}`。**不做这步，1025/1285 之后设备不会往 8787 推数据。**
3. 之后每条命令都必须带 `"token":<sid>`；判据 = `rval==0` 且 `msg_id` 与请求一致。
4. 缩略图：`261` → `{"msg_id":1025,"param":"<path>","type":"<type>","token":<sid>}` → 拿 `path`+`size` → `connect(ip,8787)` 读 `size` 字节。
5. 下载/删除列表：`268435482`（count）→ `268435485 {start,end}`（`fileinfolist`，条目 `,` 分隔、字段 `;` 分隔、固定 4 段）→ `1285` → 8787。
6. 切模式必须带**空格版**模式串并把空格编码成 `%20`（JSON 里则不需要，因为是字符串字段）。
7. 心跳：`{"msg_id":268435492,"token":<sid>}` 定时空发（仅 S7 系）；退出/后台发 `258` 并关 socket。

---

<!-- 以下整段合并自原 02-XTUGO-档案-附录-SigmaStar8080与播放层.md（2026-09-22 文档归并，内容未改） -->
# 附录 C · SigmaStar 8080 帧与播放层

> 归属：`docs/evidence/xtugo` 附录 C。样本 APK `com.gku.xtugo` 8.4.3_243。
> 取证基线：`_work/re/xtugo/api/*.md`（逐类明细）、`_work/re/xtugo/catalog-*.md`、`_work/xtu_src/sources/**`（jadx 反编译）、`_work/xtu_bad/sources/**`（jadx 失败补齐）。
> 本文所有行号均为对应 `.java` 文件内的真实行号，写前已用 Read 核对。

## 目录

- C.1 SigmaStar 平台归属判定
- C.2 控制面：HTTP CGI 与 `ClientThread` 空壳
- C.3 8080 二进制帧：字段逐位
- C.4 事件 / 推送通道与 5678 的归属
- C.5 播放层：`SSVideoView` 全参数与预览 URL
- C.6 回放与文件：列表 / 缩略图 / 下载
- C.7 设置项在 SigmaStar 侧的落地（自描述菜单 + `SSResponseParse` 字段映射）
- C.8 未解之谜
- C.9 对主文档的补充与纠正

---

## C.1 SigmaStar 平台归属判定

### C.1.1 `type` 的全部取值（严格照抄）

判定键只有设备自报的 `type`（来自 `GET /cgi-bin/hi3510/getdeviceattr.cgi`，见主文档 §2.3）。芯片常量全在 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java`：

| 常量 | 值（完整字面量） | 行 | 归属平台 |
|---|---|---|---|
| `CHIP` | `"SSC8838"` | `:6` | SigmaStar |
| `CHIP_26` | `"SSC8826"` | `:7` | SigmaStar |
| `CHIP_38c` | `"SSC8838C"` | `:8` | SigmaStar |
| `AMBA` | `"H75N"` | `:5` | Ambarella |
| （无常量） | `"CV75"` | 裸字面量，散见各分派点 | Ambarella |
| `HAISI` | `"Hi"`（只被 `contains` 用） | `:9` | 海思 |
| `SSEnable` | `true`（全库无读取点） | `:12` | — |
| `SS_IP` | `"192.168.0.1"`（**非 final，`public static String`**） | `:13` | SigmaStar/海思共用 |
| `LOCAL_DOWNLOAD_DIR` | `"/mnt/sdcard/DCIM/ActionCam/"` | `:10` | — |
| `LOCAL_THUMB_CACHE_DIR` | `"/mnt/sdcard/Android/data/com.gku.xtugo/cache/"` | `:11` | — |
| `SSFileFormat` | `mp4` / `jpg` / `dng` | `:15-19` | 回放过滤用 |

**走 SigmaStar 的 `type` 值集合恒等于 {`SSC8838`, `SSC8826`, `SSC8838C`}** —— 三值全等（`String.equals`，非 `contains`、非前缀、非大小写不敏感）。除此之外的任何非 AMBA 值（含真机 `Hi3519DV500`）都落海思分支。

### C.1.2 判定发生点（逐处，含真实行号与代码形状）

| # | 判定点 | file:line | SigmaStar 条件 | 命中后 |
|---|---|---|---|---|
| 1 | 语言表选择（最早的一次分派） | `_work/xtu_src/sources/com/gku/HomeActivity.java:1751` | `type.equals(CHIP) \|\| equals(CHIP_26) \|\| equals(CHIP_38c)` | `SSFileUtils.getLanguageJson()` → 8080 拉 `/tmp/FL0/language.json`；否则 `FileUtils.getLanguageXml()`（8080 拉 `/mnt/language.xml`） |
| 2 | 预览 model 工厂 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/PreviewModelManage.java:20` | **反写**：`if (!equals(CHIP) && !equals(CHIP_26) && !equals(CHIP_38c))` → 内层再判 AMBA/`"CV75"`（`:21`）→ `HaisiPreviewModel`（`:22`）/ `AmbaPreviewModel`（`:25`）；三值命中才 `SigmastartPreviewModel`（`:28`） | 整段被 `try/catch(Exception)` 包住，`cameraInfors` 为 null 时静默失败并打日志 `"获取相机参数失败"`（`:29-31`） |
| 3 | 设置 model 工厂 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SettingModelManage.java:17` | 三值或判定 | `SigmastartSettingModel`（`:18`）；AMBA/`"CV75"` → `AmbaSettingModel`（`:19-20`）；else → `HaisiSettingModel`（`:22`） |
| 4 | 回放 model 工厂 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/PlaybackModelManage.java:23` | 三值或判定 | `SigmastartPlaybackModel`（`:24`）/ `AmbaPlaybackModel`（`:26`）/ `HisiPlaybackModel`（`:28`） |
| 5 | 快设 model 工厂 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingModelManage.java:19` | **只判 `CHIP`/`CHIP_26`**（无 `CHIP_38c`） | `:20` 是裸 `return;`；`:22` 写了 `cameraInfors.getType().equals(SSConstant.CHIP_38c);` **结果被丢弃、无任何副作用** → SSC8838C 与非 SS/AMBA 机型一样保持 `isFastSettingModel=null`，`getModel()`（`:27-42`）返回匿名 no-op |
| 6 | 蓝牙心跳开关 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/common/model/BTHeartbeatManage.java:16` | 三值或判定 | `isBTHeartbeatModel = null`（`:17`）—— **SigmaStar 无 BLE 心跳**；AMBA/`"CV75"` 且 `name.toUpperCase().endsWith("S7")` 才装 `AmbaBTHeartbeatModel`（`:18-19`） |
| 7 | 缩略图 URL | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:82` | 三值或判定 | `http://192.168.0.1/thumb<path>`（`:83`） |
| 8 | 下载远程 URL | `…/bean/SSFileInfoBean.java:114` | 三值或判定 | `http://192.168.0.1<path>`，小码流把 `.MP4`→`-s.MP4`、`.mp4`→`-s.mp4`（`:116-121`） |
| 9 | 在线播放 URL | `…/bean/SSFileInfoBean.java:154` | 三值或判定 | `http://192.168.0.1<path>` 并把扩展名换成 `-s.MP4`/`-s.mp4`（`:155`） |
| 10 | 语言表分派（二次兜底） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:86`（`cameraInfors!=null`）与 `:100`（缓存 `lastCamerInfoType` 兜底） | 三值或判定 | `getReplaceValueForJson()`；AMBA → `AmbaLangHolder.getStr()`（`:90,97-98`）；`type.contains("Hi")` → `getReplaceValueForXml()`（`:91-95`）；**都不match → 原样返回 `value`**（`:92`） |
| 11 | 快设「加时长按钮」UI 抑制 | `…/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:1152` 与 `…/AmbaActionCameraPreviewActivity.java:1144` | 三值或判定 | SigmaStar 机型在 `Quick Stories` 模式下 `return`（不弹长按 UI） |
| 12 | 预览 presenter 分支 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:514` | **反写**三值与判定 | 非 SigmaStar 才走那段逻辑 |
| 13 | SSC8838 专属设置修正 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:119` | **只判 `CHIP`（= `"SSC8838"`）** | 唯一一处「只认 SSC8838」的设置逻辑（对 `sSettingItemBeans` 做处理） |
| 14 | 老海思机型能力位 | `_work/xtu_src/sources/com/gku/module_base_xtugo/HisiApiUtils.java:30` | `SSConstant.CHIP.equals(device_type) \|\| SSConstant.CHIP_26.equals(device_type)`（**无 `CHIP_38c`**） | 与 `"Hi3518EV300".equals(device_name)` 一起决定「不是老机型」→ 返回 true |

> 结论：**`SSC8838C` 在 5 处判定里被系统性漏掉**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingModelManage.java:19`、`_work/xtu_src/sources/com/gku/module_base_xtugo/HisiApiUtils.java:30`，以及 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:119` 只认 `SSC8838`）。复现时应按「三值等价」实现，不要照抄这些漏项。

### C.1.3 与海思 / Ambarella 探测顺序的衔接

不重复推导（见主文档 §2.3）。与本平台相关的三点硬事实：

1. **SigmaStar 与海思走同一个入口**：`GET http://<ip>/cgi-bin/hi3510/getdeviceattr.cgi`（`_work/xtu_src/sources/com/gku/HomeActivity.java:1707-1773`）。SigmaStar 的固件把 CGI 目录也叫 `hi3510`，因此**探测阶段无法区分二者**，只有解析出的 `type` 字段能区分。
2. `type` 读出后立刻决定语言表通道（`_work/xtu_src/sources/com/gku/HomeActivity.java:1751`），两条通道**都走 8080 二进制帧**（§C.3），只有路径不同。
3. Ambarella 只在 `getdeviceattr.cgi` 解析失败时才被建链（7878 socket），因此 **SigmaStar 机型永远不会碰 7878/8787**。

## C.2 控制面

### C.2.1 SigmaStar 是不是纯 HTTP CGI？—— 是（命令面），但语言表例外

**结论**：SigmaStar 的**命令面 100% 是 HTTP GET CGI**，端口 80、无鉴权、无自定义 header；`ClientThread` 是空壳。唯一的非 CGI 通道是**拉语言表**（8080 二进制帧，§C.3）。

**证据链**：

1. `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:9` `SS_BASE_PATH = "/cgi-bin/hi3510/"`，`:10` `SS_CGI = ".cgi"`，`:45-47` `UNIVERSAL_PART(command) = SS_BASE_PATH + command + SS_CGI` —— 该类 **33 个 `public static synchronized String` 方法**里除 `previewLiveStream()`（`:49-51`，RTSP）外全部返回相对 CGI 路径，没有一条 socket。（孪生类 `HaisiCommandUtil.java` 是 32 个。）
2. 发命令的类全部只用 HTTP：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:28,43,58,73,88,103,152,169` 八处 `DeviceHttpUtils.get(SSCommandUtil.xxx()).enqueueLifecycle(...)`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/SigmastartPreviewModel.java:179`（`getCurAllInfo` 轮询）、`:273`（`setCurWorkMode`）同款。`DeviceHttpUtils.get(str)` 就是 `"http://" + NetworkDeviceUtils.getInstance().getIpDevice() + str` 的 xUtils GET（`_work/xtu_src/sources/com/gku/base/device/DeviceHttpUtils.java:14-15`）→ **SigmaStar 的 CGI 用的是探测到的网关 IP，而 `SSCommandUtil.previewLiveStream()` 与 `SSFileInfoBean` 用的是硬编码 `SSConstant.SS_IP`**（两处不同源，见 §C.9 纠正项）。

### C.2.2 `ClientThread.java` 是空壳：结论与证据

**结论：是空壳，且两份（SigmaStar 版 / 海思版）都是。** `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/ClientThread.java` 全文 17 行：

| 行 | 内容 | 判定 |
|---|---|---|
| `:8` | `public class ClientThread implements Runnable` | 只实现 `Runnable` |
| `:9` | `private static final String TAG = "lzy"` | 无任何日志调用使用它 |
| `:10-12` | 字段 `BufferedReader br` / `OutputStream os` / `Socket socket` | 三者**只声明、从不赋值、从不读取** |
| `:14-16` | `public void run() { }` | **方法体为空** |

持有者 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:31` 声明了 `private ClientThread clientThread;`，但**同文件内没有任何 `new ClientThread(...)`、`.run()`、`.start()`**；真正建立 8080 连接的是 `connect()` 里的内联匿名 `Runnable`（`:52-102`）。海思孪生类在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ClientThread.java`（同构空壳）。→ **`ClientThread` 不参与任何协议，删掉它不影响行为。**

### C.2.3 CGI 路径 / 参数名与海思方言的差异（成对）

APK 里其实有**三套**方言，两套并列在 `sigmastar` 包内（同名孪生类），第三套是老海思：

- **A · SigmaStar 方言** = `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java`（`Sigmastart*Model` 用）
- **B · 海思新 UI 方言** = `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java`（`Haisi*Model` / `HisiPlaybackModel` 用）
- **C · 海思老方言** = `com/gku/actioncam/hisilicon/dv/net/HttpProxy.java` + `com/gku/actioncam/hisilicon/dv/biz/Command.java`（`IsNewAPP==false`）

| 语义 | A · SigmaStar（file:line，完整路径） | B · 海思（file:line，完整路径） | 差异 |
|---|---|---|---|
| 设备属性 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:53-55` → `/cgi-bin/hi3510/getdeviceattr.cgi` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:71-73` → 同串 | 无 |
| **文件数** | `:57-59` → `/cgi-bin/hi3510/getfiletypecount.cgi`（常量 `SS_GET_FILE_COUNT`，`:22`） | `:75-77` → `/cgi-bin/hi3510/getfilecount.cgi`（`:23`） | **CGI 名不同**；响应键 A 侧读 `imagecount`/`videocount`/`eventcount`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:72,83-90`） |
| **文件列表** | `:65-71` → `…/getfilelist.cgi?-start=<i>&-end=<i>&-type=Photo\|Video`（`type==0?"Photo":"Video"`） | `:79-81` → `…/getfilelist.cgi?-start=<i>&-end=<i>`（**无 `-type`**） | 参数个数不同 |
| 列表+信息（iOS 版） | `:73-75` → `…/getfilelistinfoios.cgi?-start=&-end=`（常量 `SS_GET_FILE_LIST_IOS`，`:25`） | `:83-85` → 同串 | 无 |
| 单文件信息 | `:81-83` → `…/getfileinfo.cgi?-name=<path>` | `:91-93` → 同串 | 无 |
| 删除 | `:77-79` → `…/deletefile.cgi?-name=<path>` | `:87-89` → 同串 | 无 |
| 目录名 | `:61-63` → `…/getdirname.cgi`（常量 `SS_GET_DIRNAME`，`:21`） | **无此方法** | B 侧缺失 |
| 全部工作模式 | `:85-87` → `…/getallworkmode.cgi` | `:95-97` → 同串 | 无 |
| 当前工作模式 | `:89-91` → `…/getcurworkmode.cgi` | `:99-105` → 同串（**同一方法写了两个名字** `getCurworkmode()` 与 `getCurWorkMode()`） | B 有冗余 API |
| 切模式 | `:93-95` → `…/setcurworkmode.cgi?-workmode=<mode>`（**不做空格编码**） | `:107-109` → 同串（同样不编码） | 两边都不编码；编码在 C 方言里 |
| 一级菜单 | `:105-107` → `…/getprimarymenuitem.cgi?-workmode=<mode>` | `:119-121` → 同串 | 无 |
| 二级菜单 | `:109-111` → `…/getsecondmenuitem.cgi?-workmode=&-name=` | `:123-125` → 同串（此处直接写字面量 `"getsecondmenuitem"` 而不用常量） | 无 |
| **读某项当前值** | `:113-115` → `…/getcurparameter.cgi?-workmode=&-name=`（常量 `SS_GET_CUR_PARAM="getcurparameter"`，`:18`） | `:127-134` → **`…/getsecondmenuitem.cgi?-workmode=&-name=`**（`:20` 把 `SS_GET_CUR_PARAM` 重定义成 `getsecondmenuitem`），且**含空格则 `replaceAll(" ", "%20")`**（`:130-132`） | **同语义不同 CGI + 不同转义策略** |
| 写某项 | `:117-119` → `…/setcurparameter.cgi?-workmode=&-name=&-value=` | `:136-138` → 同串（**不编码空格**） | 转义差异 |
| WiFi 读/写 | `:121-127` → `…/getwifi.cgi`、`…/setwifi.cgi?&-wifissid=<s>&-wifikey=<k>`（**注意 `?&` 双符**） | `:140-146` → 同串（同样 `?&`） | 无 |
| 格式化 SD | `:129-131` → `…/sdcommand.cgi?-format&-partition=1`（`-format` 是**无值裸键**） | `:148-150` → 同串 | 无 |
| 恢复出厂 | `:133-135` → `…/reset.cgi` | `:152-154` → 同串 | 无 |
| 对时 | `:137-139` → `…/setsystime.cgi?-time=<t>` | `:156-158` → 同串 | 无 |
| 开始/停止录像 | `:141-147` → `…/record.cgi?-cmd=start` / `?‑cmd=stop`（`Common.BOOT_ACTION_RECORD`） | `:160-166` → 同串 | 无 |
| 拍照 | `:149-155` → `…/photo.cgi?-type=<type>&-cmd=start\|stop` | `:168-174` → 同串 | 无 |
| 退出快录 | `:157-159` → `…/exitquickrec.cgi` | `:176-178` → 同串 | 无 |
| 相机状态 | `:161-167` → `…/getcamerastatus.cgi`、`…/setcamerastatus.cgi?-status=<s>` | `:180-186` → 同串 | 无 |
| 全量状态 | `:169-171` → `…/getcurallinfo.cgi` | `:188-190` → 同串 | 无（C 方言按 `VERSION` 在 `getcurallinfo.cgi`/`getallinfo.cgi` 间切换，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:306`） |
| **当前旋转** | `:173-175` → `…/getcurrotation.cgi`（常量 `SS_GET_ROTATE`，`:27`） | **无此方法** | A 独有 |
| **快设加时长** | `:177-184` → `…/record.cgi?-cmd=` 后接 `DV.cameraInfors.getName()` 以 `"S7PRO"`/`"S7PRO MAX"` 结尾时为 `"Storie"`，否则为 `SSExchangeWorkMode.SS_QUICK_STORIES`（=`"Quick Stories"`） | `:192-194` → 固定 `…/record.cgi?-cmd=Quick Stories`（**含空格、未编码**） | A 有按机型的 `"Storie"` 特例 |
| **老方言命令号→路径** | **无** | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:53-69`：`getexecuteCommand(int cmd)` 先过 `executeCommand()`（NewAPP 且 `cmd>=10 && cmd!=10` 时 `cmd%2==0?1:0`，`:54-57`）再取 `Common.CGI_PATH + Command.cgiFilesParams[cmd]` | B 独有；A 侧无命令号概念 |
| 老方言（C）命令号表 | — | `com/gku/actioncam/hisilicon/dv/biz/Command.java:31` 21 条：`/record.cgi?&-cmd=start`、`/record.cgi?&-cmd=stop`、`/photo.cgi?&-type=photo`、`/photo.cgi?&-type=photoburst`、`/photo.cgi?&-type=phototimelapse&-cmd=start`、`/photo.cgi?&-type=phototimelapse&-cmd=stop`、`/photo.cgi?&-type=phototimer&-cmd=start`、`/photo.cgi?&-type=phototimer&-cmd=stop`、`/photo.cgi?&-type=continuous&-cmd=start`、`/photo.cgi?&-type=continuous&-cmd=stop`、`/exitquickrec.cgi`、`/record2.cgi?&-type=common&-cmd=start`、`/record2.cgi?&-type=common&-cmd=stop`、`/record2.cgi?&-type=loop&-cmd=start`、`/record2.cgi?&-type=loop&-cmd=stop`、`/record2.cgi?&-type=timelapse&-cmd=start`、`/record2.cgi?&-type=timelapse&-cmd=stop`、`/record2.cgi?&-type=recsnap&-cmd=start`、`/record2.cgi?&-type=recsnap&-cmd=stop`、`/record2.cgi?&-type=slow&-cmd=start`、`/record2.cgi?&-type=slow&-cmd=stop` | C 用 `?&-`（问号后紧跟 and），A/B 用 `?-` |

### C.2.4 新固件方言（`NewAPP` / `"Normal Video"`）在代码里的体现

| 体现 | 事实 | file:line |
|---|---|---|
| 方言开关 | `CameraParameters.IsNewAPP = hardversion.equals("NewAPP")`；开关位本身声明在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:29`，赋值在 `_work/xtu_src/sources/com/gku/HomeActivity.java:1746-1750`（主文档 §2.3 第 4 步） | 同上 |
| 带空格模式名（15 条，全抄） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:11-25`：`SS_BURST_PHOTO="Burst Photo"`、`SS_CAR_LOOPING="Car Looping"`、`SS_LAPSE_PHOTO="Lapse Photo"`、`SS_LAPSE_PHOTO_OLD="Timelapse Photo"`、`SS_LAPSE_VIDEO="Timelapse Video"`、`SS_LONG_EXPOSURE="Long Exposure"`、`SS_NORMAL_PHOTO="Normal Photo"`、`SS_NORMAL_VIDEO="Normal Video"`、`SS_QUICK_STORIES="Quick Stories"`、`SS_QUICK_VIDEO="Quick Video"`、`SS_RAW_PHOTO="Raw Photo"`、`SS_SLOW_MOTION="Slow Motion"`、`SS_TIMING_PHOTO="Timing Photo"`、`SS_UNDER_WATER="Under Water"`、`SS_VIDEO_PHOTO="Video and Photo"` | 同上 |
| 海思侧别名表（19 条，含 5 条 SSExchangeWorkMode 里没有的） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:57-74`：`NewNormalPhoto`、`NewTimerPhoto`、`NewPhotoLapse`(=`"Timelapse Photo"`)、`NewBurst`、`NewNightPhoto="Night Photo"`、`NewNightTimeLapsePhoto="Night Timelapse Photo"`、`NewRawPhoto`、`NewNormalVideo`(=`"Normal Video"`)、`NewTimeLapseVideo`、`NewSlowMotion`、`NewCarLooping`、`NewVideoAndPhoto`、`NewQuickStories`、`NewUnderWater`、`NewTimeStretch="Time Stretch"`、`NewQuickVideo`、`NewManualRecsnap="Manual Recsnap"`、`NewLapseBurst="Lapse Burst"`；孪生类 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParmeras.java:63` 同值 | 同上 |
| 空格→`%20` 的唯一发生处 | 方言 B：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:130-132`；方言 C：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:226-228`（`setcurworkmode`）、`:251-253`（`setcurparameter`）；系统项用 `Uri.encode(x,"utf-8")`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:259-264`）。**方言 A（SigmaStar）完全不做转义**：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:94`、`:118` 直接拼 | 同上 |
| 为什么 C 必须自己转 `%20` | `HttpProxy.doHttpGetForContent()` 在发请求前把 URL 里的空格**全删**（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:60-61` `url.replaceAll(StringUtils.SPACE, "")`），所以 `"Normal Video"` 若不成 `%20` 会变成 `"NormalVideo"` → 固件不识别 | 同上 |
| 无空格写法的后果 | 代码里对 `-2222` 的**唯一**处理仍是 `SSResponseParse.parseGetAllInfo(String)` 的 `if (message.contains("-222")) return null;`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:511-513`）→ 「当作没有状态」，不报错 | 同主文档 §3.1 |
| 品牌改写 | `APP_CADDX` 分支把 `"Normal Video"` 改写成 `"Normal Video_caddx"`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:90-93`）；XTU（`CURRENT_APP_TYPE==0`）不触发 | 同上 |

## C.3 8080 二进制帧

### C.3.1 结论

**静态证据支持主文档 §3.3 的 72B/200B 小端定长头说法，且 SigmaStar 机型确实会收到它。** 两处直接落到 SigmaStar 链路：

| 用途 | 触发条件 | 发起代码 | 帧 |
|---|---|---|---|
| 拉语言表 `/tmp/FL0/language.json` | 仅当 `type ∈ {SSC8838,SSC8826,SSC8838C}`（`_work/xtu_src/sources/com/gku/HomeActivity.java:1751` → `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:65`） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:57`（`socket.connect(new InetSocketAddress("192.168.0.1", 8080), 10000)`）、`:62-66`（`CMD=0`、`DATA="/tmp/FL0/language.json"`、`DATA_LENTH=DATA.length()`）、`:66`（`new RegisterDeviceToServer(CMD,LEN,DATA).getBuf()` → `outputStream.write`） | 上行 **72B**（§C.3.2） |
| 下载 ≥2 GiB 的相机文件 | SigmaStar 与海思共用（`SSDownloadUtil` 判大小） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:85-87` → `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:34-35`（`IP="192.168.0.1"`、`port=8080`）、`:67`（`new Socket(IP, port)`）、`:73-77`（`CMD=0`、`DATA=<去掉 `http://192.168.0.1/` 前缀后的路径>`、`DATA_LENTH=DATA.length()`、`write(RegisterDeviceToServer(...).getBuf())`） | 上行 **72B** + 下行 **72B 头** + 裸文件流（§C.3.3） |
| 固件推送 | 老机型升级页 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/FirmwareClientThread.java:64`（`192.168.0.1:8080`）、`:76-82`（`CMD=2`、`DATA=file.getName()`、`DATA_LENTH=FileLength`、`MD5=getFileMD5(file)` → 200B 版构造器） | 上行 **200B** |
| 海思语言表 `/mnt/language.xml` | `type.contains("Hi")` 且非 SS | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ConnectDevice.java:44,50-53` | 上行 **72B** |
| 通用取文件（新 UI） | `com/gku/hisi/**` 文件页 | `_work/xtu_src/sources/com/gku/module_camera/hisi/HisiDownloader.java:341`（`start(networkDevice, ipDevice, 8080, 5000, path, savePath, cb)`）→ `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:111-119` | 上行 **72B**（`ByteBuffer` 写法） |

### C.3.2 上行头：72 字节（无 MD5 版）

`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/model/RegisterDeviceToServer.java:12-23`：

| 偏移 | 长度 | 字节序 / 类型 | 含义 | 出处 |
|---|---|---|---|---|
| `[0..3]` | 4 | `int32` **小端** | `cmd_type`：`0`=取文件（把路径当参数交给相机），`2`=推固件 | `:17-18` `System.arraycopy(toLH(cmd_type),0,buf,0,4)`；`toLH` 定义 `:44-46`（`n&255, n>>8, n>>16, n>>24`）；取值见 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:63`、`DownLoadFileUtils.java:71`、`FirmwareClientThread.java:76` |
| `[4..7]` | 4 | `int32` **小端** | `length` = **后面那个字符串的字符数**（Java `String.length()`，非 UTF-8 字节数） | `:19-20`；赋值点 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:65` `DATA_LENTH = DATA.length()`、`DownLoadFileUtils.java:73` 同款；固件路径下这里是**文件字节数**（`FirmwareClientThread.java:78` `= FileLength`） |
| `[8..71]` | 64 | UTF-8（实为 `str.getBytes()`，**平台默认字符集**） | 文件路径 / 文件名，**零填充与否取决于字符串长度**：不足 64 字节时尾部是 Java 新数组的 `0x00`；`StringtoLH` 只是 `str.getBytes()`（`:48-50`） | `:21-22` `System.arraycopy(StringtoLH(data),0,buf,8,len)`；`buf = new byte[72]`（`:13`） |
| — | — | — | **无魔术字、无版本、无校验和、无结束符** | 全类只有 4 个字段（`:7-10`） |

> 隐患（复现时要防）：`:22` 的 `System.arraycopy` 不做截断，路径 ≥65 字节直接 `ArrayIndexOutOfBoundsException`；`_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:117` 的现代写法用 `Math.min(bytes.length, 64)` 截断，两者行为不一致。

`ByteBuffer` 等价写法（`_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:111-119`）：

```
ByteBuffer.allocate(72) → order(LITTLE_ENDIAN) → putInt(0)            // cmd=0
                        → putInt(path.getBytes("UTF-8").length)      // 长度 = UTF-8 字节数
                        → put(拷 64B，Math.min(len,64))              // 路径
                        → outputStream.write(buffer.array())
```
注意：这条路径的 `[4..7]` 是 **UTF-8 字节数**，而 `RegisterDeviceToServer` 是 **字符数** —— 同一段 4 字节在两个实现里语义不同（ASCII 路径下二者相等）。

### C.3.3 上行头：200 字节（带 MD5，固件推送）

`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/model/RegisterDeviceToServer.java:25-38`，`buf = new byte[200]`（`:29`）：

| 偏移 | 长度 | 内容 | 出处 |
|---|---|---|---|
| `[0..3]` | 4 | `cmd_type` int32 LE，固件推送恒为 `2` | `:30-31`；值来自 `FirmwareClientThread.java:76` |
| `[4..7]` | 4 | `length` int32 LE = **固件文件字节数** | `:32-33`；值来自 `FirmwareClientThread.java:78` |
| `[8..71]` | 64 | 固件文件名（`file.getName()`） | `:34-35`；`FirmwareClientThread.java:77` |
| `[72..199]` | 128 | MD5 字符串 | `:36-37` `System.arraycopy(StringtoLH(md5),0,buf,72,len)`；MD5 由 `FirmwareClientThread.java:183-204` `getFileMD5()` 算，实现是 `new BigInteger(1, digest).toString(16)` → **前导 0 会被吃掉、长度可能不是 32** |
| 握手 | — | 发完 200B 后，App **等相机回一行以文件名开头的数据**（256B 缓冲 `read` + `startsWith(file.getName())`）才开始 `sendFile()` 以 10240B 分块写文件，写完 `socket.shutdownOutput()` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/FirmwareClientThread.java:100-118`、`:121-171` |

### C.3.4 下行头：72 字节 + 裸文件流

`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:308-351`（`getDataFromSer()`）逐段 `read`：4B（`:315-316`）→ 4B（`:317-318`）→ 64B（`:319-320`）（SigmaStar 包内孪生实现 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:167-209` 同构，读段在 `:172-179`）。

| 偏移 | 长度 | 解析 | 含义 |
|---|---|---|---|
| `[0..3]` | 4 | `bytesToInt(bArr,0)`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:338`） | `CMD`（回显 0） |
| `[4..7]` | 4 | `bytesToInt(bArr2,0)`（`:324`）再过「负数修正」（`:326-330`） | **文件字节数**；小端读法 `(src[o]&255)\|(src[o+1]<<8)\|(src[o+2]<<16)\|((src[o+3]&255)<<24)`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:360-362`；孪生 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:218-220`）→ 与 `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:131` 的 `getInt() & 4294967295L` 一致（按无符号 32 位读） |
| `[8..71]` | 64 | `new String(bytes).trim()`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:353-358`；孪生 `…/sigmastar/data/connect/DownLoadFileUtils.java:211-216`） | 文件名/路径回显 |
| `[72…]` | = 上面的长度 | 循环 `socketReader.read(buf)` 追加写盘 | 裸文件字节流，**无分帧、无 CRC** |

> **`((i>>>1)<<1)|1` 修正的真实形状**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:184-194`，海思版同构于 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:326-336`）：`if (i < 0) { j = ((i>>>1)<<1); if (i%2 != 0) j++; }` —— 把负数长度**向 0 方向取偶**（等价于清掉最低位；奇数再 +1），结果是**仍然是负数**的偶数值，随后 `if (i >= 0) j = i;` 不会覆盖它。也就是说：长度 >2 GiB 时这个「修正」得不到正确的无符号值；只有新写的 `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:131` 读对了。**复现时按 `[4..7]` = uint32 LE 文件长度实现，不要照抄这段修正。**

### C.3.5 一个关键差异：语言表响应用「文本行」读，不用 72B 头

`SSConnectDevice` 发出 72B 头后，读回调用的是 `BufferedReader.readLine()` 循环拼串（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:59`、`:70-97`），再用 `subStr(context, "[", "]")` 截取 JSON 数组（`:113`、`:155-162`），落盘为 `<localAppDataPath>/<VersionNo>.txt`（`:107-113`）。即：**相机在 8080 上对 cmd=0 的响应格式并不统一** —— 语言表请求是「头 + 文本」，文件下载是「72B 二进制头 + 裸流」。同一份代码里两种读法并存，`ClientThread`（本该承担统一读帧逻辑）是空壳（§C.2.2）。

## C.4 事件 / 推送通道

### C.4.1 SigmaStar 侧有没有 socket 推送？—— 有，但不是 SigmaStar 专属，且与 CGI 无关

| 通道 | 方向 | 端口 | 是否对 SigmaStar 生效 | 证据 |
|---|---|---|---|---|
| **`HisiSocketServer`（App 侧 `ServerSocket`，回拨）** | 相机 → 手机 | **5678** | **是**。它由「非 Amba 设备共用的预览页」在 `onCreate` 里**无条件**启动，而该页就是 SigmaStar 的预览页 | `_work/xtu_src/sources/com/gku/module_camera/hisi/HisiSocketServer.java:19`（`SERVER_PORT = 5678`）、`:70-73`（`new ServerSocket()` + `setReuseAddress(true)` + `bind(new InetSocketAddress(5678))`）、`:75-77`（`while(isRunning) accept()`，`setSoTimeout(5000)`）、`:87-97`（65536B 缓冲读到 `-1`）、`:109`（`new String(baos.toByteArray())`，平台默认字符集）、`:117-121`（`runOnUIThread(callback.onReceiveMsg(str))`）；启动点 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:307-312`，回调落到 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:150-156`（`SSResponseParse.parseGetAllInfo(msg)` → `preview.updateOperateCommandUI()`） |
| **`MessageService`（老海思 UI 的 `ServerSocket`）** | 相机 → 手机 | **5678** | 与 SigmaStar 无关，而且**本 APK 里从不启动**（见 §C.4.2 纠正） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:19`、`:32`、`:59` |
| 8080 取文件 / 取语言表 | 手机 → 相机（App 主动 `connect`） | 8080 | 是 | §C.3.1 |
| RTSP 554 | 手机 → 相机 | 554 | 是 | §C.5.3 |
| 蓝牙心跳 | 手机 → 相机 | — | **否**，`type ∈ {SSC8838,SSC8826,SSC8838C}` 时 `isBTHeartbeatModel = null` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/common/model/BTHeartbeatManage.java:16-17` |

**报文格式**：5678 上**没有任何帧结构**，读满整条连接后把整段当字符串交给 `SSResponseParse.parseGetAllInfo(String)`。该函数对推送内容做**三态判定**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:497-530`）：

1. 含 `"var"` → 按海思 `var K="V";\r\n` 方言解析（`:502-509`）；
2. 含 `"-222"` → **直接 `return null`**（`:511-513`，即「无状态」，不报错）；
3. 否则按 **真 JSON** `{"mode":…,"state":…,"event":…,"pasttime":…}` 用 `JSONTokener` 解析（`:516-525`），`event` 不是数字时兜 `0` 并打日志 `"event 不是有效的数字: …"`（`:521-523`）。

→ **SigmaStar 的推送体是 JSON**（第 3 态），海思老方言是伪 JSON `var`（第 1 态）。`mode` 是 String、`state`/`event`/`pasttime` 是 int（`SSystemWorkState` 构造，`:525`）。

### C.4.2 5678 到底属于海思还是 SigmaStar？—— 代码在「hisi」包里，行为对两者都开

- 名字/包名归属：两个 5678 实现都在海思命名空间下（`com.gku.module_camera.hisi.HisiSocketServer`、`com.gku.actioncam.hisilicon.dv.net.MessageService`），`sigmastar` 包内**没有**自己的 5678 实现。
- 运行期归属：**SigmaStar 也开**。`HisiActionCameraPreviewActivity` 是 `CameraParameters.IsAmbaDevice == false` 时唯一的预览页（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:265-266`），SigmaStar 机型的 `IsAmbaDevice` 在连接成功时被置 false（主文档 §2.3 副作用 3），因此 `:307` 的 `HisiSocketServer.getInstance().start(this, …)` 对 SigmaStar 必然执行；生命周期绑定在 Activity 的 `ON_DESTROY`（`_work/xtu_src/sources/com/gku/module_camera/hisi/HisiSocketServer.java:48-57`）。
- **`MessageService` 是死服务**：全 18195 个反编译文件里 `MessageService.class` 与 `KeepAliveService.class` **零引用**（只有同包 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:314` 广播它的 action 字符串、以及 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/filebrowser/Hi3518PriviewImageActivity.java:576-578` / `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java:632-634` 注册 `MESSAGE_ACTION` 接收器），厂商代码里唯一的 `startService(...)` 在 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/service/DownloadIntentService.java:87`。清单确实注册了这两个 service（`_work/re/xtugo/components.tsv:194-195`），但没有任何代码启动它们 → **5678 的真实监听者是 `HisiSocketServer`，不是 `MessageService`**（见 §C.9）。

### C.4.3 主动轮询与自愈（SigmaStar 预览页）

| 机制 | 周期 / 阈值 | 做什么 | file:line |
|---|---|---|---|
| 旋转轮询 | **500 ms** | `presenter.subscribeScreenRotate()` → `GET …/getcurrotation.cgi`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:173-175`） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:142-150`（`handler.postDelayed(this, 500L)`）；起停 `:252-258`/`:260-263`，`onResume` 启、`onPause` 停（`:332`、`:338`） |
| 卡流自愈 | 每 **1200 ms** 检查一次，`lastStreamTime` 超过 **1500 ms** 未更新即重连 | 重新 `initIjkVideoView(400)`；首次还会 Toast `R.string.text_please_near_device` | `…_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:176-197`、`:849`；`lastStreamTime` 由 ijk `onInfo(what==0 && extra==0)` 刷新（`:792-794`） |
| ijk 内部重连 | `reconnect=5` | 播放器层重连（非 HTTP 层） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java:611` |
| 预览重开 | `Math.max(time, 300)` ms 延时 | `initIjkVideoView(0)`（`onResume`）/ `(400)`（自愈）/ 由 `taskRunnable` 触发 | `…_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:152-158`、`:691-692`、`:844` |
| 设备存活探测 | 2000 ms / 5000 ms 两档 tick，连续 >5 次失败广播 `com.gku.xtugo.DV_ISALIVE_ACTION`（extra `networkpast`=true） | **HTTP 探测**（`Utility.isDeviceAvailable`），不是 socket 心跳；服务未被启动 → 实际不运行 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java:12-16,28-33,43-59` |
| 电池 / SD 卡轮询（基类） | — | `ActionCameraPreviewPresenter` 的 `registerMessageReceiver()`、`startBatteryPolling()`、`startSDCardPolling()`、`stopBatteryPolling()`、`stopSDCardPolling()` **五个方法体全空**；对应 what 常量 `WHAT_BATTERY_POLLING=211059`、`WHAT_SD_POLLING=211058` 已无人使用 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:47-48,80-93` |
| 状态获取 | 事件驱动 | `SigmastartPreviewModel` 只在被调用时发一次 `getcurallinfo.cgi`（无自建定时器） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/SigmastartPreviewModel.java:179` |
| SigmaStar 专属 socket 工具 | — | `SSHttpClientUtil.SOCKET_WRITE` / `SOCKET_READ` / `SOCKET_DOWNLOAD` **全库零调用**（`SOCKET_READ` 用 `Okio` 逐行读文本；`SOCKET_DOWNLOAD` 用 `available()` 估总量、以 `read()==1` 判结束，逻辑本身不可用） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSHttpClientUtil.java:214-253`、`:256-308`、`:324-425` |

### C.4.4 状态语义（推送与轮询共用）

`state`：**20 = 工作中（`CAMERA_STATE_WORKING_STR`），21 = 待机/结束（`CAMERA_STATE_WORKING_END`）**，常量在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:23-24`；SigmaStar 预览页的实际用法：录像开始判定 `state==20`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:1143`）、保存结束判定 `state==21`（`:1160`）。`event` 侧在这两处出现的魔数全集：`11800001`（操作成功，`:1140-1141`）、`1`、`268763137`（开始录像，`:1143`）、`11700002`、`273420290`、`273420291`、`273420315`、`272642051`、`2`、`268763138`（结束/保存，`:1160`）。**其中 `268763137`/`268763138` 是 Amba 风格的事件号出现在共用判定里 —— 说明这套 `event` 值在两条链路上混用**（复现时按机型实测，见 §C.8）。

## C.5 播放层

### C.5.1 `SSVideoView.openVideo()` 的播放器初始化参数（全抄，逐条带类目）

文件：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java`，方法 `openVideo()` 定义于 `:578`，参数段 `:591-613`。类目号语义取自 `_work/xtu_src/sources/tv/danmaku/ijk/media/player/IjkMediaPlayer.java:89-92`（`OPT_CATEGORY_FORMAT=1`、`OPT_CATEGORY_CODEC=2`、`OPT_CATEGORY_SWS=3`、`OPT_CATEGORY_PLAYER=4`）。

| # | 行 | category | key | value | 类型 | 作用 |
|---|---|---|---|---|---|---|
| 1 | `:592` | 2 (CODEC) | `skip_loop_filter` | `48` | long | 跳过环路滤波（`48` = `AVDiscard` 序列里的非标准值，用于降延迟） |
| 2 | `:593` | 1 (FORMAT) | `analyzemaxduration` | `100` | long | 探测最长 100 ms |
| 3 | `:594` | 1 (FORMAT) | `probesize` | `100` | long | 探测只读 100 字节（极小 → 起流快） |
| 4 | `:595` | 1 (FORMAT) | `flush_packets` | `1` | long | 输出包立即 flush |
| 5 | `:596` | 4 (PLAYER) | `packet-buffering` | `0` | long | **关缓冲 = 低延迟核心开关** |
| 6 | `:597` | 4 (PLAYER) | `framedrop` | `12` | long | 落后 12 ms 起丢帧 |
| 7 | `:598` | 4 (PLAYER) | `mediacodec-handle-resolution-change` | `0` | long | 关硬解动态分辨率切换 |
| 8 | `:599` | 1 (FORMAT) | `max-buffer-size` | `1024` | long | 格式层缓冲 1 KB |
| 9 | `:600` | 4 (PLAYER) | `find_stream_info` | `0` | long | **不做流信息探测** |
| 10 | `:601` | 4 (PLAYER) | `render-wait-start` | `1` | long | 等 start 再渲染 |
| 11 | `:604` **或** `:606` | 1 (FORMAT) | `rtsp_transport` = `udp`（AMBA 分支）**/** `rtsp_flags` = `prefer_tcp`（其它分支） | 见 §C.5.2 | String | RTSP 传输选择 |
| 12 | `:611` | 4 (PLAYER) | `reconnect` | `5` | long | ijk 内部重连次数 |
| 13 | `:612` | 4 (PLAYER) | `mediacodec` | `0` | long | **强制软解**（AMMediaCodec 关闭） |
| 14 | `:613` | 1 (FORMAT) | `dns_cache_clear` | `1` | long | 每次清 DNS 缓存 |

**计数结论：`SSVideoView` 的 `setOption` 调用点共 15 处（14 条无条件 + 1 条二选一分支）**，一次实际播放只会执行 **15 条**中的 15 个 setter 调用（分支只落一个键）。

其它同方法事实：`new IjkMediaPlayer()`（`:591`）；`setDataSource(mUri.toString())`（`:627`）；`setDisplay(mSurfaceHolder)`（`:629`）；`setScreenOnWhilePlaying(true)`（`:630`）；`prepareAsync()`（`:631`）；状态置 `MP_STATE_PREPARED=1`（`:632`）。方法开头还会发一次音乐暂停广播 `Intent("com.android.music.musicservicecommand")` + extra `command="pause"`（`:583-585`）。`setUserAgent(String)`（`:562-564`）写入字段 `mUserAgent`（`:73`）后**从未被读取** → UA 设置是死的。整个 `openVideo()` 里 **没有任何 `rtsp_flags`/`rtsp_transport` 以外的 URL 参数拼接**。

### C.5.2 按 `type` 选 UDP / prefer_tcp 的完整分支

`_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java:602-610`：

```
try {
    if (DV.getInstance().cameraInfors.getType().equals(SSConstant.AMBA)
        || DV.getInstance().cameraInfors.getType().equals("CV75")) {   // :603
        ijkMediaPlayer.setOption(1, "rtsp_transport", "udp");           // :604
    } else {
        ijkMediaPlayer.setOption(1, "rtsp_flags", "prefer_tcp");        // :606
    }
} catch (Exception e) { Log.e(TAG, "openVideo: " + e.toString()); }     // :608-610
```

- **只有两个取值**：`H75N` 与 `"CV75"` → `rtsp_transport=udp`；**其余全部（含 `SSC8838`/`SSC8826`/`SSC8838C` 与所有 `Hi*`）→ `rtsp_flags=prefer_tcp`**。
- 判据是 `DV.getInstance().cameraInfors`，**`cameraInfors` 为 null 或未连接时抛 NPE，被 `:608` 的 `catch (Exception)` 吞掉** → 此时两个键**都不会被设置**（ijk 用默认 `prefer_tcp` 前的 udp 优先行为）。这是「偶发预览只有画面无流」的静态解释候选。
- 注意键不同：AMBA 设的是 `rtsp_transport`（强制），SS/海思设的是 `rtsp_flags=prefer_tcp`（偏好，仍可回落）。

### C.5.3 预览 URL 的构造代码：`/12` 与 `/11`

| 平台 | 构造代码 | 结果串 | 是否有 `/11` |
|---|---|---|---|
| SigmaStar（与海思新 UI 共用） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:49-51` `return SS_PROTOCOL_RTSP + SSConstant.SS_IP + ":554/livestream/12";`；常量 `:31 SS_LIVE_STREAM_PATH="/livestream/12"`、`:32 SS_LIVE_STREAM_PORT="554"`、`:34 SS_PROTOCOL_HTTP="http://"`、`:35 SS_PROTOCOL_RTSP="rtsp://"` | `rtsp://192.168.0.1:554/livestream/12`（IP 是 `SSConstant.SS_IP`，**非 `CameraParameters.baseIp`**，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:13` 该字段还**不是 final**） | **否**，`/12` 是字面量硬编码，`SS_LIVE_STREAM_PATH` 常量本身在全库无人引用（`catalog-http.md:170-171` 只登记了两处定义） |
| 海思新 UI 孪生类 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:49-51` 完全同串（`:31`、`:32 SS_LIVE_STREAM_PORT=554`（**这里是 `int`**）） | 同上 | 否 |
| **海思老 UI（唯一有 `/11` 的地方）** | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:319-329` `new StringBuilder("rtsp://") + ip + ":554/livestream/" + (isPreviewBigBitRate() ? "11" : "12")` | `rtsp://<ip>:554/livestream/11` 或 `/12` | **是**，开关 `isPreviewBigBitRate()`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:119`） |
| 海思老 UI 的 HTTP 预览 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:331-342` `http://<ip>:80/` + (`11?`/`12?`) + `trans=tcp&action=play&media=video_data` | `http://<ip>:80/12?trans=tcp&action=play&media=video_data` | 是（同一开关） |
| Ambarella 预览页 | `String.format("rtsp://%s:554/livestream/12", ip==null?"192.168.0.1":ip)`（`_work/xtu_src/sources/com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:972`） | `rtsp://<ip>:554/livestream/12` | 否 |

**SigmaStar 的取流调用点**（`SSCommandUtil.previewLiveStream()` 的两个调用方）：
`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:767`（SigmaStar 机型走这里）与 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:752`。

### C.5.4 SigmaStar 预览**实际用的不是 `SSVideoView`**

- `HisiActionCameraPreviewActivity` 自建 `this.preview_texture_video_view = new VideoTextureView(this)` 并塞进 `preview_container`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:757-760`，字段声明 `:109`，import `:59`）。
- `VideoTextureView` 的实现体在 `_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java`，`openVideo(boolean isAmba)` 定义于 `:606`，参数段 `:617-646`。
- `SSVideoView` 的**唯一**引用是布局 `activity_s_s_video_remote_play.xml`（`_work/re/xtugo/layouts.tsv:93`，节点 `@+id/video_remote_play_video`）与其 DataBinding 类 `_work/xtu_src/sources/com/gku/xtugo/databinding/ActivitySSVideoRemotePlayBinding.java:35`；**全树没有任何 Activity/Fragment 使用该 Binding**（`RemotePlay` 相关 Binding 只有 `ActivitySSVideoRemotePlayBinding`、`ActivitySSPhotoRemotePlayBinding` 两个类文件，二者都无调用方）→ `SSVideoView` 在当前 8.4.3 包里是**可执行但不可达**的旧播放层。

`VideoTextureView` 的参数全集（21 条无条件 + 分支 2 条，逐条，`_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java`）：

| 行 | cat | key | value | | 行 | cat | key | value |
|---|---|---|---|---|---|---|---|---|
| `:619` | 4 | `mediacodec-hevc` | `1` | | `:629` | 2 | `flags` | `"low_delay"`（String） |
| `:620` | 1 | `analyzeduration` | `1` | | `:630` | 1 | `dns_cache_clear` | `1` |
| `:621` | 1 | `fflags` | `"nobuffer"`（String） | | `:631` | 4 | `mediacodec` | `0` |
| `:622` | 1 | `analyzemaxduration` | `5000` | | `:632` | 4 | `mediacodec-auto-rotate` | `0` |
| `:623` | 1 | `flush_packets` | `1` | | `:633` | 4 | `mediacodec-handle-resolution-change` | `0` |
| `:624` | 1 | `probesize` | `4096` | | `:634` | 2 | `skip_loop_filter` | `0` |
| `:625` | 4 | `start-on-prepared` | `1` | | `:635` | 1 | `http-detect-range-support` | `0` |
| `:626` | 4 | `packet-buffering` | `0` | | `:636` | 4 | `max-buffer-size` | `1024` |
| `:627` | 4 | `infbuf` | `1` | | `:637` | 4 | `min-frames` | `2` |
| `:628` | 4 | `no_delay` | `1` | | `:638` | 4 | `max_cached_duration` | `300` |

分支（**判据是入参 `isAmba`，不再是 `type` 字符串**）`:639-646`：`!isAmba` → `setOption(1,"rtsp_transport","tcp")` + `setOption(4,"framedrop",5)`（并打日志 `"当前设置的丢帧数为5"`）；`isAmba` → `setOption(1,"rtsp_transport","udp")` + `setOption(4,"framedrop",100)`。

`isAmba` 的来源（完整分支）`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:817-838`：`cameraInfors == null` → 先发 Amba 命令 `msg_id=11`（`AmbaConnector.sendCmdQueue(..., 11, CameraInfoResponseBean.class, ...)`，`:820`）并在成功回调里以 `isAmba=true` 起播（`:828`）；`cameraInfors != null` 且 `type.equals("H75N") || type.equals("CV75")` → `isAmba=true`（`:833-834`）；**否则（含全部 SigmaStar 三值与 `Hi*`）→ `isAmba=false` → `rtsp_transport=tcp` + `framedrop=5`**（`:836`）。`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:812-815` 同构。签名：`setVideoPath(String path, boolean isAmba, String flipValue)`（`_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java:423-426`）→ `setVideoURI(Uri, boolean)`（`:429-432`）→ `openVideo(isAmba)`。

**因此对 SigmaStar 真机而言：走的是 `rtsp_transport=tcp`（不是 `SSVideoView` 的 `rtsp_flags=prefer_tcp`）。** 镜像/翻转由 `flipValue` 字符串（`"0°"`/`"90°"`/`"180°"`/`"270°"`）在 View 层做矩阵处理（`_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java:746-754`），初值 `"0°"`（`:99`、`:270`），预览页传入 `previewFlipValue`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:828/834/836`）。

### C.5.5 ijkplayer 与 ExoPlayer 各自用在哪

| 播放器 | 用在哪 | 证据 |
|---|---|---|
| **ijkplayer（`IjkMediaPlayer`，`libijkplayer.so`/`libijkffmpeg.so`/`libijksdl.so`）** | ① SigmaStar/海思预览实际链路：`VideoTextureView.openVideo()` `:617`；② 旧播放层 `SSVideoView.openVideo()` `:591`；③ `com/gku/actioncam/widget/VideoView.java:596-624`（Amba 预览页与远程回放页 `AmbaRemoteVideoActivity`、轨迹页 `TrackActivity` 用）与 `:666-687`（第二个 `openVideo` 变体）；④ 预览页显式加载：`IjkMediaPlayer.loadLibrariesOnce(null)` + `native_profileBegin("libijkplayer.so")`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:770-771`） | 行号如左 |
| **ExoPlayer（`com.google.android.exoplayer2`）** | **只有一处**：`GKUCamPlayer`（清单里 `exported=true` 的对外播放页）在 `onCreate` 里 `PlayerFactory.setPlayManager(Exo2PlayerManager.class)` 把 GSY（`com.gku.ffm.zqvideo`）的后端整体切到 Exo2（`_work/xtu_src/sources/com/gku/gkucamplayer/GKUCamPlayer.java:35`），播放器视图是 `LandLayoutVideo`（`:42`），输入来自 intent extra `"kPlayFilePath"` / `"kPlayFileName"`（`:38-39`）。真正 `new ExoPlayer.Builder(...)` 的位置在 `_work/xtu_src/sources/com/gku/mediacodec/exo2/IjkExo2MediaPlayer.java:897`（由 `Exo2PlayerManager` 持有，`_work/xtu_src/sources/com/gku/mediacodec/exo2/Exo2PlayerManager.java:18`） | 行号如左 |
| GSY（`com.gku.ffm.zqvideo`） | 只被 `GKUCamPlayer` 使用（`import com.gku.ffm.zqvideo.video.base.GSYVideoPlayer`，`_work/xtu_src/sources/com/gku/gkucamplayer/GKUCamPlayer.java:15-18`）；`com.gku.actioncam.**` 下**零引用** | `grep GSYVideoManager com/gku/actioncam/` 无命中 |

> `com/gku/**` 里其余 30+ 个 `import com.google.android.exoplayer2.*` 的文件**全是把 Exo 常量当字符串常量大用**（如 `SessionDescription.SUPPORTED_SDP_VERSION=="0"`、`IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE=="1"`、`IjkMediaMeta.AV_CH_WIDE_LEFT==2147483648`），不是真的在用 ExoPlayer —— 例：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:17,77,85`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:124`。

### C.5.6 在线回放的 URL（与预览不同源）

SigmaStar 文件在线播放走 **HTTP 而非 RTSP**：`http://192.168.0.1<originPath>` 且把 `.MP4`→`-s.MP4`、`.mp4`→`-s.mp4`（小码流），见 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:154-155`。同一函数另两分支：AMBA/`"CV75"` 用 `http://192.168.0.1<path 去 "/tmp/SD0">` 且 `.MP4`→`.LRV`（`:157-158`）；其它（海思）用 `http://192.168.0.1/<path>`（**多一个斜杠**）且 `.MP4`→`.LRV`（`:160`）。

## C.6 回放与文件

### C.6.1 取列表（SigmaStar = `SigmastartPlaybackModel`）

| 步骤 | 请求（完整串） | 解析 | 分页 | file:line |
|---|---|---|---|---|
| 1. 取总数 | `GET http://<探测IP>/cgi-bin/hi3510/getfiletypecount.cgi` | `SSResponseParse.parseGetFileCount(body, type)`：`type=="Video"\|\|"Normal"` → `videocount`；`"Emr"` → `eventcount`；`"Photo"` → `imagecount`；其它 → `0`；解析异常返回 `0` | — | 请求 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/SigmastartPlaybackModel.java:68`（`DeviceHttpUtils.get(SSCommandUtil.getFileCount())`），路径 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:57-59`，解析 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:79-95` |
| 2. 取一页 | `GET …/cgi-bin/hi3510/getfilelist.cgi?-start=<curIndex>&-end=<curIndex+49 或 count-1>&-type=<Photo\|Video>` | `SSResponseParse.parseGetFileListAndInfo(body, type)` | **每页 50 条**，`-end = curIndex+49 > count ? count-1 : curIndex+49`；本页返回 ≥50 条则 `curIndex += size` 递归续拉（`:228-231`），否则 `loadDataFinish()` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/SigmastartPlaybackModel.java:202-241`（分页算式 `:205`），URL `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:69-71` |
| 3. 列表体解析 | — | **响应是 JSON 数组**（不是 `var` 方言）：逐元素取 `path` / `time` / `size` / `create`；若首元素的 `create` 含 `-` 则把**所有元素**的 `create` 里 `-` 全换成 `/`；按扩展名分派 `type`：`"Normal"`/`"Video"` 直收，`"Event"` 只收 `.mp4`，`"Photo"` 只收 `.jpg` 或 `.dng`（`SSConstant.SSFileFormat`）；同时用 `isFileLocalExists(localPath)`（视频额外看 `localPathLRV`）标记已下载 | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:132-173`（键名来自被复用的三方常量：`ClientCookie.PATH_ATTR=="path"` `org/apache/http/cookie/ClientCookie.java:11`、`RequestParameters.COMP_CREATE=="create"` `com/aliyun/oss/internal/RequestParameters.java:7`、`CrashHianalyticsData.TIME=="time"`、`"size"` 字面量） |
| 4. 目录名（可选） | `GET …/cgi-bin/hi3510/getdirname.cgi` | `parseDirname()` → `parseMessageToMap(...).get("value")` 按 `,` 切 | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:61-63`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:54-66` |
| 5. 删除 | `GET …/cgi-bin/hi3510/deletefile.cgi?-name=<originPath>`（**逐个文件一次请求，无批量 CGI**） | 只看回调成功/失败 | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/SigmastartPlaybackModel.java:184-199`（`for` 循环逐个发），`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:77-79` |
| 6. 单文件信息 | `GET …/cgi-bin/hi3510/getfileinfo.cgi?-name=<originPath>` | `parseGetFileInfo()` → `path`/`size`/`create`/`time` | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:81-83`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:117-130` |

本地落盘路径（`SSFileInfoBean`）：`getLocalPath()` = `G.localDCIMActionCamVideoDataPath`（文件名以 `.mp4` 结尾时）或 `G.localDCIMActionCamPhotoDataPath`，再 `+ "/" + fileSize + "_" + fileName`（**用文件大小做前缀做去重/断点判据**，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:187-197`）；小码流本地路径 `getLocalPathLRV()` = `FileUtils.getMediaPath() + "/" + fileName` 把 `.MP4→s.MP4`、`.mp4→s.mp4`（`:199-201`）；`fileName = SSFileUtil.pathShortName(originPath)`（`:53`）。

### C.6.2 缩略图

| 维度 | SigmaStar | 海思（对照） | Ambarella（对照） |
|---|---|---|---|
| URL 生成 | `String.format("http://%s/thumb%s", SSConstant.SS_IP, originPath)` → `http://192.168.0.1/thumb/tmp/SD0/DCIM/…` | `http://192.168.0.1/<originPath>` 且扩展名换成 `.THM`（`HiDefine.FILE_SUFFIX_THM`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/HiDefine.java:30`） | 直接用 `originPath`（走 msg 1285 + 8787） |
| 代码 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:82-83` | `…/bean/SSFileInfoBean.java:87-92` | `…/bean/SSFileInfoBean.java:84-85` |
| 取回方式 | **HTTP GET（OkHttp，非 8080）**：`SSDownloadUtil.singleSyncDownload(thumbPath, 本地缓存路径, cb)` → `SSHttpClientUtil.SYNC(SSHttpClientUtil.GET(url))` → `HTTP_DOWNLOAD` | 同一函数（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/HisiPlaybackModel.java:157`） | `AmbaPlaybackModel` 走 socket |
| 调用点 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/SigmastartPlaybackModel.java:89-135`（`loadThumb`），本地缓存路径由 `AmbaPlaybackUtil.remotePathExchangeLocalCache_dcf(thumbPath)` 换算（`:96`），成功回调 `loadThumbSuccess`（`:103,132`），失败 `downloadTaskFailure`（`:115`）；另有 `loadThumbRetry(thumbPath)`（`:45`） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/HisiPlaybackModel.java:136-181` | — |
| 缓存目录 | `FileUtils.getExternalCacheDirectory() + "/" + fileName` 把 `.MP4`/`.JPG`/`.mp4`/`.jpg` 一律换成 `.THM`（`getCachePath()`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:203-207`）；另有常量 `SSConstant.LOCAL_THUMB_CACHE_DIR = "/mnt/sdcard/Android/data/com.gku.xtugo/cache/"`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:11`） | 同 | 同 |
| 缩略图 CGI | **不存在**（无 `getthumbnail.cgi`；`catalog-http.md` 405 条里也无） | 不存在 | 不存在 |

### C.6.3 下载原文件与「续传」

| 环节 | 事实 | file:line |
|---|---|---|
| 入口 | `SSPlaybackNewPresenter` → `SSDownloadUtil.getInstance().multipleSyncDownload(list, isAmba = model instanceof AmbaPlaybackModel, cb)` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/presenter/SSPlaybackNewPresenter.java:268` |
| 空间预检 | `StatFs(externalStorage).availableBlocks * blockSize < fileSize` → 回调 `notEnoughSpace()` 并直接返回 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:77-81`、`:231-234` |
| 队列持久化 | 下载前把整个 `ArrayList<SSFileInfoBean>` 用 Gson 写进 SP 文件 `"download_file_list"` 的键 `"file_list"`；队列被清空时从那里回灌 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:83`、`:236-250` |
| **≥2 GiB 分支** | `fileSize >= IjkMediaMeta.AV_CH_WIDE_LEFT(=2147483648L，`_work/xtu_src/sources/tv/danmaku/ijk/media/player/IjkMediaMeta.java:60`)` 且 remotePath 不含 `.LRV` → 走 **8080 二进制** `DownLoadFileUtils.getInstance(app).createConnection(remotePath, savePath)` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:85-88`；实现见 §C.3 |
| **<2 GiB 分支** | 纯 HTTP：`SSHttpClientUtil.GET(remotePath)` + `SYNC(...)` + `HTTP_DOWNLOAD(response, savePath, cb)` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:152-159` |
| **续传方式（HTTP）** | **没有 Range/断点续传**。`HTTP_DOWNLOAD` 先删掉临时文件 `savePath + ".MP4"`，整份重写到临时文件，按 `getContentLength()` 算进度（≥300 ms 才回调一次），完成后 `renameTo(savePath)`；改名失败回调 `"临时文件替换失败！警告：此时源文件已丢失！！"` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSHttpClientUtil.java:138-197`（删除 `:147-150`、节流 `:166-170`、改名 `:173-181`） |
| **续传方式（8080）** | 以 **append 模式**打开目标文件（`new FileOutputStream(file, true)`）后从流头开始追加，**不查询已落盘字节数、不发 offset** → 同一文件重复下载会产生重复内容；唯一「已下过」判据是上层用 `localPath` 里带的 `fileSize` 前缀做存在性检查 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:213-219`（`downloadFile2`）；存在性判定 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:158-164` |
| 取消 | HTTP：`currentDownloadCall.cancel()` + `isSyncMultipleDownloadTaskCancel=true`；8080：`DownLoadFileUtils.disConnect()` 把 `Tag=false`，下一轮循环回调 `onItemClick(-1.0f, null)` 并**删除已落盘文件** | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:61-69`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/presenter/SSPlaybackNewPresenter.java:279-281`；`DownLoadFileUtils.java:107-113`（hisi 版 `disConnect()` 置 `Tag=false`）；失败删文件 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:133-136` |
| 完成后入库 | `Build.VERSION.SDK_INT >= 29` → `SSPlaybackNewPresenter.downloadToDcimNoLessThan29(ctx, savePath, Common.DATA_DIRECTORY_NAME)`，否则 `downloadToDcimNoMoreThan28(...)`；8080 路径下进度到 `100.0f` 才触发 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:99-103`、`:160-164` |
| 后台服务版 | `DownloadIntentService`（OldUi）也调 `SSDownloadUtil.multipleSyncDownload(fileList, false, …)`，即服务路径同样按 2 GiB 分流 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/service/DownloadIntentService.java:178` |

### C.6.4 与海思的结构性差异（回放面）

| 维度 | SigmaStar（`SigmastartPlaybackModel`） | 海思新 UI（`HisiPlaybackModel`） |
|---|---|---|
| HTTP 客户端 | `DeviceHttpUtils.get(...)`（xUtils，URL 绝对化用**探测到的网关 IP**，`_work/xtu_src/sources/com/gku/base/device/DeviceHttpUtils.java:14-15`） | `HttpRequestUtils.getInstance().doRequest(相对 CGI 路径, cb)`（OkHttpUtils，60 s 三超时，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/HttpRequestUtils.java:60-64`；调用点 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/HisiPlaybackModel.java:83,188,203,235,281`） |
| 列表命令 | `getfilelist.cgi?-start=&-end=&-type=`（带 `-type`） | `getfilelistinfoios.cgi?-start=&-end=`（分页 50，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/HisiPlaybackModel.java:281` 用 `i+50 > count ? count : i+50`，**边界与 SS 的 `count-1` 不同**） |
| 计数命令 | `getfiletypecount.cgi` | `getfilecount.cgi`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:75-77`） |
| 缩略图 | `http://ip/thumb<path>` | `http://ip/<path 换 .THM>` |
| 小码流文件 | `-s.MP4` / `-s.mp4` | `.LRV` |
| 命令工具类 | `SSCommandUtil` | `HaisiCommandUtil`（含 `getexecuteCommand(int)` 命令号方言，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:53-69`） |

## C.7 设置项在 SigmaStar 侧的落地

### C.7.1 自描述菜单 → UI 的完整链路

```
SSDeviceSettingActivity / SSFastSettingPopupWindow
  └ SettingModelManage.getModel() → SigmastartSettingModel
      ├ getPrimaryMenuItem(curMode, itemName)                       _work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:151
      │    GET http://<探测IP>/cgi-bin/hi3510/getprimarymenuitem.cgi?-workmode=<curMode>   （_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:105-107）
      │    → SSResponseParse.parseGetPrimaryMenuItem(body)          _work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:155
      │    → recombinationData(list, itemName)   ← SSC8838 专属修正  :156 / 定义 :117-148
      │    → callback.getPrimaryMenuItemSuccess(list)               :157
      ├ getSecondMenuItem(curMode, name)                            :87
      │    GET …/getsecondmenuitem.cgi?-workmode=&-name=           （_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:109-111）
      │    → SSResponseParse.parseGetSecondItem(body) → SSecondItemBean(itemList, curValue)  :91
      └ setCurParam(curMode, name, value)                           :102
           GET …/setcurparameter.cgi?-workmode=&-name=&-value=     （_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:117-119）
           → callback.setCurParamSuccess(body, name, value)        :106   ← 只看 HTTP 成功，不校验响应体
```

`parseGetPrimaryMenuItem(String)` 的类型推断（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:423-465`）：

| 步 | 规则 | 行 |
|---|---|---|
| 1 | 用 `parseMessageToMap2`（只要求 `";` 收尾，**不要求 `\r\n`**）取 `item` 与 `cur` | `:426` |
| 2 | `cur.replace(",,", ",-,")` —— 空位补占位符 `-` | `:428` |
| 3 | 若 `cur` 以 `,` 开头 → 前面补 `-`；以 `,` 结尾 → 后面补 `-` | `:429-434` |
| 4 | `item.split(",")`；若 `cur` 段数少于 `item` 段数，尾部按差额逐个追加 `",-"`（**`String` 重载独有；`Response` 重载 `:384-421` 不补**） | `:435-441` |
| 5 | 段数仍不等 → **整表返回 `null`**（UI 空白） | `:442-444` |
| 6 | 逐项定型：值 `=="ON"` 或 `=="OFF"` → `SWITCH`；值非空且 `!="-"` → `SELECT`；否则 → `CLICK` | `:446-453` |
| 7 | `CLICK` 项**不写 `itemValue`**（保持 null） | `:454-457` |

UI 侧只有 3 种 viewType，按 `SettingItemType.ordinal()`（声明顺序 `SELECT=0, SWITCH=1, CLICK=2`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/ui/adapter/SettingRecycleAdapter.java:27-31`）分派：`SELECT` 分支 `:63`、`SWITCH` 分支 `:66`；点击回调仅对 `CLICK` 生效（`:105`）、选择弹窗仅对 `SELECT`（`:113`）、开关回调要求 `compoundButton.isPressed() && type==SWITCH`（`:121`）。承载数据的是 `SSettingItemBean{type, itemName, itemValue}`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSettingItemBean.java:7-9`）与 `SSecondItemBean{itemList, curValue}`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSecondItemBean.java:8-9`）。

**SSC8838 专属的菜单裁剪 `recombinationData()`**（`cameraInfors.getType().equals(SSConstant.CHIP)` 为假即整体 return，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:119`）：

| 条件 | 动作 | 行 |
|---|---|---|
| 任一项 `itemValue` 含 `"P120"` | 从列表删除 `itemName` 含 `"EIS"` 的项 | `:123-130` |
| `itemName` 含 `"EIS"` 且 `itemValue.equals("ON")` | 删除 `itemName` 含 `"LDC"` 的项 | `:131-138` |
| `itemName` 含 `"LDC"` 且 `itemValue.equals("ON")` | 删除 `itemName` 含 `"EIS"` 的项 | `:139-146` |

（对比：老海思方言同类规则靠 `"Resolution"` 的 8 个高帧率值 + `"ImageStabilize"` 判定，见主文档 §4.1 的 type=2 行。）

### C.7.2 `SSResponseParse` 字段映射表（字段名 → 语义 → 单位）

解析底座：`HEAD_VAR="var "`、`MID_EQUAL_MARK="=\""`、`TAIL_SEMICOLON="\";\r\n"`、`SS_SUCCESS="Success"`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:39-43`）。两个解析器：`parseMessageToMap` 要求行尾 `";\r\n`（`:532-545`）、`parseMessageToMap2` 只要求 `";`（`:547-560`）；两者在 `indexOf` 顺序不合法时 **break 并返回已解析部分**（不抛错）。

| CGI | 响应键 | 目标字段 / 返回 | 语义 | 单位与取值 | 行 |
|---|---|---|---|---|---|
| `getdeviceattr.cgi`（**不在此类**，走 `HttpRequest.getMap()`） | `type` / `name` / `softversion` / `hardversion` | `CameraInfors` | 平台判定键 / 机型名 / 软版 / 硬版（`=="NewAPP"` 决定方言） | String | 主文档 §2.3 |
| `getdirname.cgi` | `value` | `String[]` | 目录名列表 | 逗号分隔 | `:54-66` |
| `getfiletypecount.cgi` | `imagecount` | int | 照片数 | 张；解析失败 = `0` | `:68-95` |
| 同上 | `videocount` | int | 视频数（`type=="Video"\|\|"Normal"`） | 条 | `:68-95` |
| 同上 | `eventcount` | int | 事件/紧急录像数（`type=="Emr"`） | 条 | `:81-84` |
| 同上（无 type 重载） | 三键求和 | int | 文件总数 | 个 | `:97-115` |
| `getfileinfo.cgi` | `path` / `size` / `create` / `time` | `SSRemoteFileInfo.path/size/createTime/time` | 路径 / 大小 / 创建时间 / 时长 | `size` 字节(String)；`create` `yyyy-MM-dd HH:mm:ss` 或 `yyyy/MM/dd HH:mm:ss`；`time` 秒(String) | `:117-130` |
| `getfilelist.cgi`（**JSON 数组**，非 `var` 方言） | `path` | `SSFileInfoBean.originPath` | SD 卡绝对路径，形如 `/tmp/SD0/DCIM/…/xxx.MP4` | String | `:132-173` |
| 同上 | `create` | `createTime` | 拍摄时间；**首元素含 `-` 时全表 `-`→`/`** | String | `:140,151-155` |
| 同上 | `time` | `videoTime` | 视频时长 | 秒（String） | `:148,156` |
| 同上 | `size` | `fileSize` | 字节数；也参与本地文件名前缀 | 字节（String，消费方 `Long.parseLong`） | `:149,157` |
| 同上 | （扩展名） | 是否入列表 | `Photo` 只收 `.jpg`/`.dng`；`Normal`/`Video` 全收；`Event` 只收 `.mp4` | — | `:159-166` |
| `getfilelistinfoios.cgi`（重载 `parseGetFileInfo(Response,String)`） | `path`/`create`/`time`/`size` | 追加进 `PlaybackModelManage.imageThumbList` / `videoThumbList` | 同上；差异：**不修正 `create` 的 `-`**，直接塞静态表 | — | `:175-201` |
| `getallworkmode.cgi` | `video` / `photo` | `HashMap<String,ArrayList<String>>` | 两类工作模式名（**值带空格**，如 `Normal Video`） | 逗号分隔 | `:203-216`；消费 `SSExchangeWorkMode.isVideoMode/isPhotoMode`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:27-35`） |
| `getcurworkmode.cgi` | `workmode` | String | 当前模式 | 带空格串 | `:218-234` |
| 同上 | 整表 | `HashMap<String,String>`（`parseGetCurWorkModeForMap`） | 当前响应全部键值 | — | `:236-243` |
| `getbatterycapacity.cgi` | `capacity` | `SSBatteryInfo.capacity` | 电量百分比；**`>100` 或 `<0` 一律折成 `0`** | `%`（int） | `:245-279`（钳位 `:253,271`） |
| 同上 | `capacity`（二次消费） | `SSBatteryInfo.bCharging` | 「是否充电中」= **`capacity` 字符串恰好 `=="1"`** | 布尔；语义可疑（§C.8 #4） | `:250,268`；构造 `SSBatteryInfo(int capacity, boolean bCharging, boolean bAC)`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSBatteryInfo.java:30`） |
| 同上 | `ac` | `SSBatteryInfo.bAC` | 是否接外接电源 | `"1"`=是 | `:251,269` |
| `getsdstate.cgi` | `sdstatus` | `SSTFCardInfo.sdState` | 卡状态 | `"1"`→`NORMAL`；`"3"`→`FULL`；`"0"` 或 `"2"`→`NONE`；其它→`ERROR`；`sdtotalspace==0` 时（**仅 String 重载**）强制 `NONE` | `:281-323`；枚举 `SSTFCardInfo.TFCardState{NORMAL,FULL,NONE,ERROR}`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSTFCardInfo.java:25-30`） |
| 同上 | `sdtotalspace` | `SSTFCardInfo.total` | 卡总容量 | **MB**；设备回 `"xxxx MB"`，代码 `replace(" MB","")` 后 `parseInt`；缺键 → `-1` | `:294,314` |
| 同上 | `sdfreespace` | `SSTFCardInfo.used`（**算出来的**） | 已用 = `total - free` | MB；缺键 → `-1` | `:295,315` |
| `getcurparameter.cgi` / `getsecondmenuitem.cgi` | `value` | String（`parseGetResolution`、`parseGetFastSetting`） | 当前值 | 原样 | `:325-341`、`:366-382` |
| `getsecondmenuitem.cgi` | `item` | `SSecondItemBean.itemList` | 可选值列表 | 逗号分隔 | `:343-364` |
| 同上 | `value` | `SSecondItemBean.curValue` | 当前值 | String | `:348,359` |
| `getprimarymenuitem.cgi` | `item` | `SSettingItemBean.itemName` 序列 | 一级菜单项名（**英文原词**） | 逗号分隔 | `:384-465` |
| 同上 | `cur` | `SSettingItemBean.itemValue` + 决定 type | 当前值序列；空位写作 `,,`，缺位用 `-` 补 | 逗号分隔 | 同上 |
| `setwifi.cgi` / `getwifi.cgi` | `wifissid` / `wifikey` | `SSWiFiInfo` | 热点名 / 密码 | String | `:467-485` |
| `getcurallinfo.cgi`（+ 5678 推送） | `mode` / `state` / `event` / `pasttime` | `SSystemWorkState` | 当前模式 / 状态 / 事件号 / 已录时长 | `mode` String；`state` int（20=WORKING、21=STANDBY）；`event` int/long 魔数；`pasttime` **原样 int，无单位换算** | `:487-530` |
| 任意写命令 | 响应体 `Success` | — | 唯一被认的「成功」字面量，但**各调用点并不校验** | String | 常量 `:41` |

### C.7.3 菜单文案的翻译（设备自描述的第二层）

`SSFileUtils.changeStr(value)`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:77-113`）：取 `Locale.getDefault().getLanguage()`，国家码 `HK` 时后缀 `_HK`（`:80-82`）→ SigmaStar 走 `getReplaceValueForJson(en, lang)`：读 **`<localAppDataPath>/<CameraParameters.VersionNo>.txt`**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:141-158`，与海思 XML 共用同一文件名，`getReplaceValueForXml` 在 `:160-183`），`JSONArray` 逐元素 `getString("en")` 精确等于原文才返回 `getString(<lang>)`，否则原样返回英文。语言表来源见 §C.3（8080 拉 `/tmp/FL0/language.json`，落盘 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:107-113`，并只截取首个 `[` 到末个 `]` 之间的内容，`:113`+`:155-162`）。海思 XML 表节点是 `<lanstr en="…" zh="…" …/>` 且需先 `escapeXml`（`:169-182`、`:185-190`）。**结论与主文档 §4.2 一致：SigmaStar 的中文文案不在 APK 里。**

## C.8 未解之谜（SigmaStar 专属，不含主文档 §10 已列的通用项）

| # | 问题 | 静态为何定不来 | 补证手段 |
|---|---|---|---|
| 1 | 量产 SigmaStar 机型的真实 `type` 到底是三个值中的哪一个（甚至是否还有第四值，如 `SSC86xx`） | 分派键由设备自报（§C.1.1），APK 内无型号→芯片表 | 逐台 `GET /cgi-bin/hi3510/getdeviceattr.cgi` 抄 `type`/`hardversion` |
| 2 | `SSC8838C` 是否真的在跑 | 三处判定漏掉它（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingModelManage.java:19`、`_work/xtu_src/sources/com/gku/module_base_xtugo/HisiApiUtils.java:30`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:119` 只认 `SSC8838`），若某机型报 `SSC8838C`，快设/能力位/EIS-LDC 裁剪会静默失效 | 拿到该机型后专门验这三处行为 |
| 3 | 5678 上相机实际推的是 JSON 还是海思 `var` 方言 | `parseGetAllInfo(String)` 同时支持三态（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:497-530`），静态无法判定固件用哪一态 | 在预览页起 `tcpdump`/相机侧抓包，录一段像看推送体 |
| 4 | `getbatterycapacity.cgi` 的 `bCharging` 键位是否错位 | 代码用 `capacity.equals("1")` 判「充电中」（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:250,268`），而 `ac` 才像充电位（`:251,269`）；两种实现都能自圆其说 | 插/拔充电线各读一次 `getbatterycapacity.cgi`，抄原始 `var` 行 |
| 5 | `sdstatus` 的 `"2"`、`"3"` 与 `sdtotalspace` 是否总带 `" MB"` 后缀 | 只有 `replace(" MB","")` 的容错（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:294,314`），无枚举表 | 无卡 / 满卡 / 正常卡三态各读一次 `getsdstate.cgi` |
| 6 | `language.json` 的完整语言列集合（`en` 之外有哪些键）与 `zh_HK` 命名 | 只按 `Locale.getLanguage()`（+`_HK`）取值，缺列即回落英文（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:141-158`） | 拉一次 `/tmp/FL0/language.json` 全量导出 |
| 7 | `-222` 判据的误伤面 | `message.contains("-222")` 会同时吞掉 `0xFFFFF752(-2222)` 与任何含 `-222` 的正常文本（如时长 `pasttime=-2220` 或模式串） | 制造 `-2222` 与含 `-222` 的正常响应各一次，比对 UI 表现 |
| 8 | 8080 对 `cmd=0` 的响应头是否**总是** 72B 二进制 | 语言表请求（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:59,70-97`）用 `readLine()` 按文本读，文件下载（`DownLoadFileUtils`）按 4+4+64 二进制读 —— 同一命令两种读法，说明相机行为可能是「先发头再发文本」而 App 只是不校验 | 抓 8080 原始字节流，比对 `[0..3]` 是否恒为 `00 00 00 00` |
| 9 | 固件推送的 MD5 是否被相机校验 | App 侧 `getFileMD5()` 用 `new BigInteger(1,digest).toString(16)`（`FirmwareClientThread.java:197`），**前导 0 会被截掉** → 长度可能 <32；相机是否校验未知 | 故意改坏固件包再推，看是否被拒 |
| 10 | `getfiletypecount.cgi` 的 `eventcount` / `-type=Emr` 在 SigmaStar 上是否存在 | `SSCommandUtil.getFileList(int,int,int)` 只会发 `Photo`/`Video`（`:66`），`Emr` 只出现在计数侧（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:81-84`） | 触发一次紧急录像后读计数并列目录 |
| 11 | SS 预览是否真的需要 `getcurrotation.cgi` 500 ms 轮询（对相机负载的影响） | 只有代码节奏（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:142-150`），无实测 | 抓包计频 + 观察预览延迟 |

## C.9 对主文档的补充与纠正

| # | 原文（位置 + 说法） | 证据 | 应改为 |
|---|---|---|---|
| 1 | §3.3 「`SSVideoView` 的 **17 条** ijk 播放参数（键=值全部列出）见同附录 §3」 | `SSVideoView.java` 内 `setOption` 调用点**只有 15 处**（`:592,593,594,595,596,597,598,599,600,601,604,606,611,612,613`；其中 `:604` 与 `:606` 互斥），已逐条核对本附录 §C.5.1 | 改「15 个 `setOption` 调用点 = 14 条无条件 + 1 条二选一分支」；真正的**在用**播放层参数是 `_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java:619-646` 的 21+2 条（§C.5.4） |
| 2 | §2.2 表 `SSFileInfoBean` 行的行号 `:84,122,157,163` | SigmaStar 分支实际在 `:82`（thumb）、`:114`（remote）、`:154`（play）；`:84`、`:122`、`:157` 是 **AMBA 分支**；`:163` 是 `getCreateTime()` 与平台无关 | 行号改为 `:82 / :114 / :154`（并保留 AMBA 的 `:84 / :122 / :157`） |
| 3 | §3.4 标题「海思 App 侧回拨 ServerSocket 5678」+ 表内「触发：App 起 `MessageService`（前台通知 id `10121`）后无条件 accept」 | 全树唯一的 `startService(...)` 在 `OldUi/playback/model/service/DownloadIntentService.java:87`；`MessageService.class` / `KeepAliveService.class` **零引用**（仅清单注册，`_work/re/xtugo/components.tsv:194-195`）。真正在听 5678 的是 `HisiSocketServer`，且由 **SigmaStar 与海思共用的预览页** 无条件启动（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:307-312`，该页选择逻辑 `:265-266`） | 标题改「App 侧回拨 ServerSocket 5678（`HisiSocketServer`，海思与 SigmaStar 共用）」；`MessageService`/`KeepAliveService` 标注为「清单幽灵：代码不启动」，与 §10 #8 的 `SSMessageService` 同类处理 |
| 4 | §3.3 「上行 72 字节定长头：`[0..3] int32 LE cmd` + `[4..7] int32 LE 数据长度/路径长度` + `[8..71] **64 字节 UTF-8 路径**」 | `RegisterDeviceToServer.StringtoLH()` 是 `str.getBytes()`（**不带字符集参数**，`:48-50`），`[4..7]` 写的是 `String.length()`（**字符数**，见 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:65`、`DownLoadFileUtils.java:75`）；只有 `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:114-115` 才 `getBytes("UTF-8")` 且写**字节数** | 改为「路径槽 = `str.getBytes()`（平台默认字符集，Android 上即 UTF-8）；`[4..7]` 在老实现里是字符数、在新实现里是 UTF-8 字节数（ASCII 路径下等价）」 |
| 5 | §3.3 「老写法是 `com.hisi.hisiFW.RegisterDeviceToServer(int,int,String)` 的 `toLH()` 手摆，`_work/xtu_src/sources/com/hisi/hisiFW/RegisterDeviceToServer.java:12-23,40-46`」 | SigmaStar/海思预览与下载链路用的是**同名不同包**的 `com.gku.actioncam.hisilicon.dv.ui.data.model.RegisterDeviceToServer`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:13` 的 import、`DownLoadFileUtils.java:9`、`FirmwareClientThread.java:9`）；`com.hisi.hisiFW` 那份只服务 `FwUpload`（8080 上传，`_work/re/xtugo/catalog-ports.md:289`） | 补一句「有两份同名 `RegisterDeviceToServer`，字段布局相同但只有 `hisiFW` 版被 `FwUpload` 用；SigmaStar 用的是 `dv.ui.data.model` 版」 |
| 6 | §2.2 表末 `SSVideoView` RTSP 传输选择行（`…/widget/SSVideoView.java:603-607`，「非 AMBA → `rtsp_flags=prefer_tcp`」） | 代码无误，但 `SSVideoView` 在本包内**不可达**：唯一引用是 `activity_s_s_video_remote_play.xml`（`_work/re/xtugo/layouts.tsv:93`）与其 Binding（`_work/xtu_src/sources/com/gku/xtugo/databinding/ActivitySSVideoRemotePlayBinding.java:35`），无任何 Activity 使用；SigmaStar 真机预览走 `VideoTextureView` → `rtsp_transport=tcp` + `framedrop=5`（`_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java:639-641`，`isAmba=false` 来自 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:817-838`） | 该行加「（仅存在于死代码）」，并把「SigmaStar 预览实际用 `rtsp_transport=tcp`」写进正文 |
| 7 | §2.5 RTSP 行「`:554/livestream/12`（小码流）/`11`（大码流）｜`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:50`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:50`、`…/dv/biz/DV.java:320-330`、`…/AmbaPreviewActivity.java:972`」 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:50` 与 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:50` 是**字面量 `/livestream/12`**，无 `/11` 分支；`/11` 只在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:319-329`（RTSP）与 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:331-342`（HTTP）；`_work/xtu_src/sources/com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:972` 也只有 `/12` | 把「/11」的来源限定为 `DV.isPreviewBigBitRate()` 一处，并注明 SigmaStar/Ambarella 路径**永远只有 /12** |
| 8 | §11 「相机默认地址常量」行：「SigmaStar/海思代码路径**硬编码** `192.168.0.1` 而非读 `baseIp`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:57`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ConnectDevice.java:44`、`DownLoadFileUtils.java:31-32`、`FirmwareClientThread.java:64`、`HisiCameraAbout` 等）」 | 精确化：**SigmaStar 的 CGI 面不硬编码** —— `DeviceHttpUtils.get()` 用 `NetworkDeviceUtils.getIpDevice()` 拼绝对 URL（`_work/xtu_src/sources/com/gku/base/device/DeviceHttpUtils.java:14-15`）；硬编码只出现在 8080（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:57`、`DownLoadFileUtils.java:34-35`、`FirmwareClientThread.java:64`）与 RTSP/缩略图/下载 URL（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:50`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:83,115,155,158,160` 用 `SSConstant.SS_IP`）。另 `SSConstant.SS_IP` **不是 final**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:13`）→ 存在被改写的可能 | 拆成「CGI 用探测 IP / RTSP+缩略图+下载+8080 用硬编码 `SSConstant.SS_IP`」两条，并注明 `SS_IP` 非 final |
| 9 | §3.3 「端序坑：`DownLoadFileUtils.bytesToInt()` 是小端读法…但老代码对负数长度做了 `((i>>>1)<<1)\|1` 的怪异修正（`:183-192`）」 | 代码形状是 `if (i<0) { j = ((long)(i>>>1))<<1; if (i%2!=0) j++; }`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:184-191`；海思版 `:326-336`），**结果仍是负数**（等价于把最低位清零），>2 GiB 时拿不到正确的无符号长度；新实现 `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:131` 用 `getInt() & 4294967295L` 才正确 | 把「怪异修正」写成明确结论：「该修正不解决符号问题，是 bug；复现按 uint32 LE 读」 |
| 10 | §3.1 表最后一行「`SSResponseParse.parseMessageToMap/2`：sigmastar 侧的同款解析，另带 `cur` 的空位补齐技巧（`…/SSResponseParse.java:532-560`）」 | 补齐逻辑不在 `parseMessageToMap*`（那两者只是切 `var` 对），而在 `parseGetPrimaryMenuItem`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:389-395`（Response 重载，不补差额）与 `:428-441`（String 重载，补 `",- "` 差额）） | 行号改为 `:389-395` + `:428-441`，并明确「两个重载行为不同：`Response` 版段数不等即整表 null，`String` 版会补齐」 |
| 11 | 主文档未提及（补充） | ① SigmaStar 与海思的差异不止 CGI 名：HTTP 客户端也不同（`DeviceHttpUtils`/xUtils vs `HttpRequestUtils`/OkHttpUtils）；② `SSDownloadUtil` 用 **2 GiB** 做 HTTP/8080 分流（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:85`，阈值常量 `IjkMediaMeta.AV_CH_WIDE_LEFT=2147483648L`）；③ 8080 下载**无 Range、无 offset**，是 append 续写；④ 预览轮询 500 ms 只轮 `getcurrotation.cgi`；⑤ SSC8838 有 EIS/LDC/P120 互斥裁剪 | 建议把 ①②③④⑤ 分别并入主文档 §3.1 / §3.3 / §4.1 |

---

<!-- 以下整段合并自原 02-XTUGO-档案-附录-操作复现表.md（2026-09-22 文档归并，内容未改） -->
# 附录 D · 操作复现表（XTU GO 8.4.3）

> 主文档：[XTU GO 档案](xtugo.md)（本附录兑现其 §5 的承诺）
> 其他附录：[A · 海思 CGI 全表](xtugo.md)、[B · Ambarella 报文全表](xtugo.md)、[C · SigmaStar 8080 帧与播放层](xtugo.md)
> 目标：**每个用户操作可以照抄成一次可重放的请求序列**。每节格式固定为「前置状态 → 按顺序发出的请求/报文（精确到参数值）→ 成功判据 → 失败分支与提示文案」。
> 真机基准机型：S7PRO（`type=Hi3519DV500`、`hardversion=NewAPP`、`192.168.0.1:80` thttpd/2.29）。凡静态与真机冲突，**以真机为准并显式标注**。

## 记号约定

| 记号 | 含义 |
|---|---|
| `<ip>` | 相机网关 IP，运行时由 `guessDeviceIP()` 得到，白名单只允许 `192.168.0.1` 与 `192.168.1.1`（`_work/xtu_src/sources/com/gku/HomeActivity.java:562`） |
| `BASE` | `CameraParameters.BaseUrl` = `"http://" + <ip> + "/cgi-bin/hi3510/"`（`_work/xtu_src/sources/com/gku/HomeActivity.java:1756`） |
| 方言 A/B/C | A = 老海思（`hardversion != "NewAPP"`，`Setting.java`/`Command.java`/`RemoteFileManager.java`）；B = NewAPP（`HttpProxy.java` NewAPP 段 + `SetDataUtils.java` + `SSCommandUtil`/`HaisiCommandUtil`）；C = 最新 App 层（`com.gku.hisi.Hisi_Camera*Fragment` + `com.gku.module_camera.hisi.*` + `HisiApiUtils`）。真机 S7PRO 走 B（+C 的界面）。 |
| 「判据只看 200」 | 走 `HttpProxy.doForSuccess()`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:89-92`）→ **HTTP 200 即返回 0，不看 body**，与真机「`record.cgi`/`setcurworkmode.cgi` 的 200 不代表成功」完全一致 |
| 「判据看 body」 | 走 `Command.executeCommand()`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:33-64`，读 `SvrFuncResult`）或 `SSResponseParse.parseGetAllInfo()` |

## 目录

- [1. 首次进入与连接](#1-首次进入与连接)
- [2. 实时预览](#2-实时预览)
- [3. 录像 / 停止录像](#3-录像--停止录像)
- [4. 拍照：单张 / 连拍 / 延时 / 慢动作](#4-拍照单张--连拍--延时--慢动作)
- [5. 切工作模式](#5-切工作模式)
- [6. 参数设置](#6-参数设置)
- [7. 回放](#7-回放)
- [8. WiFi 名称/密码、对时、恢复出厂、重启](#8-wifi-名称密码对时恢复出厂重启)
- [9. 固件升级与 App 自身更新](#9-固件升级与-app-自身更新)
- [10. 附加功能](#10-附加功能)
- [11. 状态轮询](#11-状态轮询)
- [12. 静态定不来的操作](#12-静态定不来的操作)

---

## 1. 首次进入与连接

### 1.1 冷启动到主页

| 步 | 动作 | 细节 | 出处 |
|---|---|---|---|
| 1 | 启动器 → `WelcomeActivity` | 唯一 `LAUNCHER`，`exported=true`，`theme=@style/welcomeTheme_XTU` | 主文档 §1.4 |
| 2 | 权限页 `PermissionActivity` | 按 API 分三套数组申请（≤29 / 30–32 / ≥33），全串见主文档 §1.3 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31-33` |
| 3 | `HomeActivity.onCreate` 起编排 | 底部 4 tab：`camera` / `photos` / `xtu_plus` / `user_center`；未连相机时把 tab1 换成 `FragmentDisConnectCamera` | `_work/xtu_src/sources/com/gku/HomeActivity.java:510-521`、`:1586-1600` |
| 4 | `DeviceVersionManager.checkDeviceVersion(true)` | App 启动即查一次固件版本（§9） | `_work/xtu_src/sources/com/gku/HomeActivity.java:597` |
| 5 | `MessageService` / `KeepAliveService` | 前台通知 id `10121`，起 5678 回拨 `ServerSocket`；心跳 2000ms/5000ms | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:56-60`、`…/KeepAliveService.java:12-16` |

### 1.2 WiFi 连接方式（三条并存，XTU 自己写得不一致）

| 路径 | 触发场景 | 实际 API | 判据 | 出处 |
|---|---|---|---|---|
| 系统设置手连（引导 UI） | 未连相机时 `layout_disconnect_camera_1`（`@string/no_connect_camera` = 「还没有设备，赶紧连接吧」，按钮 `@string/next_step`） | 无 API，纯文案引导 | 网关 IP | `_work/re/xtugo/layouts.md:333` |
| BLE 拿到凭据后自动入网（API ≥ 29） | `connectWifi()` → `connectWi_fi()` | `WifiManager.addNetworkSuggestions()`，返回 `0` 才继续 `ConnectivityManager.requestNetwork()`；`NetworkSpecifier.setSsidPattern(new PatternMatcher(ssid, PatternMatcher.RULE_PREFIX))` + `addCapability(13)`（NOT_RESTRICTED）+ `addCapability(14)`（TRUSTED） | `onAvailable` 且 `getIpDevice()=="192.168.0.1"` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bluetooth/utils/WIFIUtils.java:42-58`；`docs/analysis/ble-and-vpn §1.3` |
| 扫码/列表路径（API ≥ 29） | `DeviceAddDeviceListFragment` / 首页扫码 | `requestNetwork(…addTransportType(1).removeCapability(12).setNetworkSpecifier(new NetworkSpecifier().setSsid(ssid).setWpa2Passphrase(pwd)))` | 同上 | `_work/xtu_src/sources/com/gku/base/device/NetworkDeviceUtils.java:403-411` |
| API < 29 老 API | `sigmastar/wifi/beforeQ/WifiConnector.java` + `WifiConnector` 代理 | `addNetwork` / `enableNetwork` / `getConfiguredNetworks` / `setWifiEnabled(true)`；另有 `HomeActivity.connectByConfig()` 手写 `WifiConfiguration`（`SSID="\"%s\""`、`preSharedKey="\"%s\""`、cipher 固定 `WIFI_CIPHER_WPA`） | `enableNetwork(...)` 返回值 | `_work/xtu_src/sources/com/gku/HomeActivity.java:1083-1137`、`:1139-1145` |
| 换相机前先踢旧 AP | 当前 SSID `contains("XTU")` 且不等于目标 | `disconnectWifi()` 后再连 | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/DeviceAddDeviceListFragment.java:288-323` |

> 与 `docs/analysis/ble-and-vpn` 一致，无冲突。补充一点 `docs/analysis/ble-and-vpn` 未展开的：**入网进度条文案是 `R.string.connecting`（「连接中…」）**，扫码返回后立刻 `progressDialog.show()`（`_work/xtu_src/sources/com/gku/HomeActivity.java:1078-1080`、`:1148`）。

### 1.3 二维码配网（扫码 → 连热点）

**前置**：Android 10+ 时该路径只能「填表 + 跳系统设置」，`addNetwork`/`enableNetwork` 在 API ≥ 29 已被系统忽略 —— 代码仍保留了这条老实现（`HomeActivity.connectByConfig`），**这是静态与真实行为冲突点之一**：静态看像能直连，实测在 Android 10+ 只能走 `NetworkSpecifier`/建议网络。

| 步 | 动作 | 精确内容 | 出处 |
|---|---|---|---|
| 1 | 入口 | 首页 / 添加设备页的 `@+id/it_scan`（文案 `@string/scan_add_device` = 「扫码配网」）→ `SingleInstanceRouter` 回调 `CALLBACK_SCANWIFI_RESULT` → `startActivityForResult(new Intent(ctx, HWScaningActivity.class), 321)` | `_work/xtu_src/sources/com/gku/HomeActivity.java:172`（`CODE_SCAN_WIFI = 321`）、`:528-534`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/DeviceAddNewActivity.java:114`；`_work/re/xtugo/layouts.md:65` |
| 2 | 扫码引擎 | 华为 **ScanKit** `RemoteView.Builder().setFormat(HmsScanBase.ALL_SCAN_TYPE)`，取景框边长 `density*300/2` 像素 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/HWScaningActivity.java:44-55` |
| 3 | 二维码格式 | 必须是**标准 WIFI 配置码**：串里要同时含 `WIFI:`、`S:`、`P:`；解析 = 自定义 `subString(src,"S:",";")` 取 SSID、`subString(src,"P:",";")` 取密码。`originalValue.split(";")` 的返回值**被丢弃**（`:67` 是空语句），所以含 `;` 的密码会被截断 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/HWScaningActivity.java:66-71` |
| 4 | 成功判据 | `ssid` 与 `password` 均非空 **且** 密码匹配 `\A\p{ASCII}*\z`（纯 ASCII） → `setResult(123, Intent.putExtra("ssid",…).putExtra("password",…))`，1000ms 后 `finish()` | `…/HWScaningActivity.java:74-86` |
| 5 | 失败分支 | 密码含非 ASCII → `remoteView.onPause()` + Toast `R.string.scan_retry`（默认 `Recognition error, please try again`／中文「识别错误，请重试」） | `…/HWScaningActivity.java:87-95` |
| 6 | 回到 HomeActivity | `onActivityResult(requestCode==321)` → 两个 extra 都非空 → `resumeFromScan=true`、`progressDialog.show()`、`NetworkDeviceUtils.setWifiScanListener(this, ssid, password)` | `_work/xtu_src/sources/com/gku/HomeActivity.java:1063-1081` |

**注意**：二维码里**不含相机 IP**；IP 靠 §1.5 的网关猜测。

### 1.4 蓝牙扫描 / GATT 握手 / BLE 配网

与 `docs/analysis/ble-and-vpn §1.1-1.2` 一致，本处只补「按顺序发什么、参数值」：

| 步 | 方向 | 精确报文 | 出处 |
|---|---|---|---|
| 1 | 扫描 | `BluetoothLeScanner.startScan(null, ScanSettings(SCAN_MODE_LOW_LATENCY), cb)`，**无 ScanFilter**；业务层过滤 `name.contains("XTU") \|\| name.contains("GKU")`；名字为 null 时手工解析广播 AD type 9 | `docs/analysis/ble-and-vpn §1.1`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/DeviceAddActivity.java:125` |
| 2 | 判定 BLE 配网机 | `device.getName().toUpperCase().startsWith("XTU_")` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:473` |
| 3 | 连接 | `device.connectGatt(ctx, false, cb, 2 /*TRANSPORT_LE*/)` | `…/BLEConnectUtils.java:466` |
| 4 | 选特征 | **不匹配 service UUID**：遍历 `getServices()`→`getCharacteristics()`，取带 CCCD `00002902-0000-1000-8000-00805f9b34fb` 或 UUID 等于 `00008888-0000-1000-8000-00805f9b34fb` 的那个 → `setCharacteristicNotification(true)` → `writeDescriptor(CCCD, ENABLE_NOTIFICATION_VALUE)` → `requestMtu(512)`，300ms 后再写 | `…/BLEConnectUtils.java:536-562` |
| 5 | 配对（只有第一次） | **本地已存过该设备的码就跳过本步**：`onServicesDiscovered` 里 `mListView.onServicesDiscovered(getDevicePin(name))` 若 `isFoundInLocal()` 为真，直接 `startConnect()`（→ 步 6 的 `R001_`），**不写 `R003_`**；只有没存过才写 `R003_<code>`。码由手机生成：`String.format("%04d", System.currentTimeMillis() % 10000)`。**相机要在自己的屏幕上由人确认这个码**——同时弹出的 `DeviceAddSetKeyFragment` 显示这 4 位数字，文案 `match_code = "请在设备上核对验证码"`，只有相机答了（`onKeySetted()`）才关。 | `…/BLEConnectUtils.java:859-880`；`…/deviceAdd/Fragment/DeviceAddDeviceListFragment.java:456-468`；`…/deviceAdd/Fragment/DeviceAddSetKeyFragment.java:64-85`；`res-strings-zh.md:1312` |
| 6 | 开热点 | 写 `R001_<code>` → notify 回 `SSID=…,PWD=…,KEY=1`；`KEY=0`/`Status=0` 则换一个新码重发 `R003_`（`:692-701`，弹窗不关） | `…/BLEConnectUtils.java:184`、`:646-649`、`:702-708` |
| 7 | 确认/等待 AP | 写 `R002_<code>`；收到 notify `WiFi_Status=1` 才算 AP 起来；**每 1s 无限重写 `R002`，无最大次数、无总超时** | `…/BLEConnectUtils.java:192,722,752-758` |
| 8 | 存码 | notify 里 `SSID=…;PWD=…`（**明文**）→ `saveDeviceWithPin` 存 `SP: "bt_pin"+设备名`（存的是相机 `Pin=` 回显的那个码）→ 下次进这台设备直接走步 6 | `…/BLEConnectUtils.java:649`、`:717-726`、`:900-906` |
| 9 | 反向配网（相机去连手机热点，直播用） | `sendPacket(gatt, ch, String.format("ssid:%s;pwd:%s;", ssid, pwd), "R006")`；`BluetoothLive` 里写死 `sendWifi(…, "gkuvision-5G", "gku88888", …, "R006")` | `…/BLEConnectUtils.java:278`；`_work/xtu_src/sources/com/gku/module_camera/bluetooth/BluetoothLive.java:92,188` |
| 10 | 直播参数下发 | `String.format("live_type:%s;res:%d;fps:%d;bitrate:%d;rtmp_url:%s;", …)` 标号 `R007` | `…/BLEConnectUtils.java:285` |
| 11 | 其它命令 | `R004`（`:376`）、`R008_<code>`（`:295`）、`R009`（`:212`，回包前缀 `R009_cap:` → 能力位，`:783`） | 同文件 |
| 12 | 分包 | `CHUNK_SIZE = 100`；单次 `writeCharacteristic` 超时 `TIMEOUT_MS = 1000` | `…/BLEConnectUtils.java:43-45` |
| 13 | 权限门 | 每次 `writeCharacteristic` 前过 `BLEConnectUtils.checkBlePermission()` | `…/BLEConnectUtils.java:910-918` |

> **冲突提示（与 `docs/analysis/ble-and-vpn` 无冲突，与主文档 §2.4 有补充）**：`docs/analysis/ble-and-vpn §1.6 坑3` 说首页自动弹窗硬编码只放行 `xtu_s7pro`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BaseBTPopupActivity.java:93`）——本附录确认：**BLE 链路只对 S7Pro 系列验证过**，不是所有 XTU 机型都有 BLE 配网。

### 1.5 探测顺序与识别成功后的信息拉取

**探测顺序（必须照抄；HTTP CGI 优先，Ambarella socket 兜底）** —— 与主文档 §2.3 一致：

| 序 | 请求/动作 | 精确值 | 成功→ | 失败→ | 出处 |
|---|---|---|---|---|---|
| 1 | `NetworkDeviceUtils.Callback.onAvailable` | — | 猜 IP | — | `_work/xtu_src/sources/com/gku/HomeActivity.java:558-576` |
| 2 | `guessDeviceIP()` | LinkProperties 默认路由网关 → 回落 `DhcpInfo.serverAddress` | — | — | `…/HomeActivity.java:1853-1857`；`_work/xtu_src/sources/com/gku/base/device/NetworkDeviceUtils.java:332-345` |
| 3 | 白名单 | `ip.equals("192.168.0.1")` \|\| `ip.equals(IcatchCaseKt.API_HOST_ICATCH /*"192.168.1.1"*/)` | 继续 | `notifyConnectFailed()` + `checkConnectionDevice(false, ip)` + `SSFileUtil.clearCache()` + `resetBT()` | `…/HomeActivity.java:562-575` |
| 4 | `GET http://<ip>/cgi-bin/hi3510/getdeviceattr.cgi` | OkHttp，`connectTimeout=writeTimeout=readTimeout=5s`，`retryOnConnectionFailure=false`，`socketFactory` 取自 `NetworkDeviceUtils.getNetworkDevice()`（VPN 共存关键）；要求 body 能按 `var K="V";\r\n` 解出 ≥1 个 KV | 海思/SigmaStar 分支（步 5） | `runOnUiThread → AmbaConnector.startSession(activity, callbackSession)` ← **只有这里才建 7878** | `_work/xtu_src/sources/com/gku/HomeActivity.java:1604-1629`、`:1707-1712`、`:1774-1781`；`…/dv/net/HttpRequest.java:48-61,96-106` |
| 5 | 解析 `getdeviceattr.cgi` 字段 | `softversion`（含 `H`/`G` 且有 `.` 时**截掉最后一段**）、`name`、`region`（缺省 `"G"`）、`pcbversion`/`pcbrevision`（缺省 `"V1.0"`）、`serialnum`(int)、`type`、`networkstatus`(int)、`hardversion`、`bluetoothrxversion`、`bluetoothtxoneversion`、`bluetoothtxtwoversion`、`startdate`、`runtimes`(long)、`model`(int)、`timeout`(int) | — | **无 `networkstatus` 键时整段字段解析走 else 分支，且该分支里 `map.containsKey("runtimes")` 用了未赋值的 `str13` → 抛 NPE 被外层 catch → 返回 `null` → 直接落到 Ambarella 兜底**（jadx 输出 `:222-224`，这是真实缺陷，不是反编译噪音） | `…/dv/net/HttpRequest.java:107-233` |
| 6 | 激活检查（仅 S7PRO 系列） | `name ∈ {"XTU S7PRO","XTU S7PRO MAX"}` → `GET BASE + "getactivateinfo.cgi"`，读 `status`/`version`；`status==0` → 弹激活框 | 出口 A：`GET BASE + "settrial.cgi?-status=%d&-version=%s"`（用回读到的 status/version 填充）；出口 B：`GET BASE + "setactivateinfo.cgi?-status=%d&-version=%s"` | — | `…/HomeActivity.java:1714-1739`；`…/dv/net/HttpRequest.java:53-55,242-330` |
| 7 | 方言开关 | `IsNewAPP = hardversion.equals("NewAPP")`；`CameraParameters.BaseUrl = "http://<ip>/cgi-bin/hi3510/"` | — | — | `…/HomeActivity.java:1746-1750,1756` |
| 8 | 语言表 | `type ∈ {"SSC8838","SSC8826","SSC8838C"}` → `SSFileUtils.getLanguageJson()`（8080 拉 `/tmp/FL0/language.json`）；否则 `FileUtils.getLanguageXml()`（8080 拉 `/mnt/language.xml`） | — | — | `…/HomeActivity.java:1751-1755` |
| 9 | 落 SP | `edit.putString("modelName", name.split("-")[0])`、`putString("softVersion", softversion)`、`putBoolean("isAmba", false)`、`commit()` | — | — | `…/HomeActivity.java:1765-1773` |
| 10 | 进预览页后首批 | `getAllWorkMode()` → `getBattery()` → `getTFCard()` → `setSystemTime()`（**连上就无条件对时**，见 §8.2） | 见 §11 | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/HaisiPreviewModel.java:62-68`（`requestPreviewParams`） |

**首批之后还会拉**：`getcurallinfo.cgi`（§11）、`getcurworkmode.cgi`、`getsecondmenuitem.cgi?-workmode=<模式>&-name=Resolution`（快设条）、`getcurrotation.cgi`（`SSCommandUtil.getRotate()`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:173`）、蓝牙收发器名（`getdeviceattr` 的 `bluetoothtxoneversion`/`bluetoothtxtwoversion` 字段驱动 `loadBluetoothTXSuccess`）。

**Ambarella 兜底分支的报文序列**（`type ∈ {"H75N","CV75"}`，详见附录 B）：

| 序 | msg_id | body | 出处 |
|---|---|---|---|
| 1 | `257` | `{"msg_id":257,"token":0}` → 响应 `param` = sessionId | `_work/xtu_src/sources/com/gku/module_camera/amba/connector/AmbaConnector.java:142-208` |
| 2 | `261` | `{"msg_id":261,"token":<sid>,"type":"TCP","param":"<手机在相机网段的 IP>"}` | `…/AmbaConnector.java`；IP 取自 `WifiUtils.getWiFiPhoneIp()`（`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:279`） |
| 3 | `11` | 设备信息 → 组 `CameraInfors`（软版本去 `.G`/`.H` 尾段），`IsNewAPP=true`、`IsAmbaDevice=true` | `_work/xtu_src/sources/com/gku/HomeActivity.java:690-780` |
| 4 | `1285`+8787 | `AmbaLangHolder.downloadJson(ctx, 3, …)`（重试 3 次拉 `/tmp/FL0/language.json`） | `…/HomeActivity.java:758` |
| 5 | 菜单预热 | `getSecondMenuItem("System","FLIP")` | `…/HomeActivity.java:765-774` |
| 6 | `1539` | `getAmbaWifiName()` 读相机 SSID（JSON 键 `ssid`） | `…/HomeActivity.java:1787-1805` |

**连接失败的用户可见文案**

| 场景 | 资源 ID | 默认英文 | 中文 | 触发处 |
|---|---|---|---|---|
| 相机连不上 | `com.gku.module_base_xtugo.R.string.connect_error_hint` | `You can try to reconnect the camera if it fails` | 相机连接失败，您可以尝试重新连接 | `_work/xtu_src/sources/com/gku/HomeActivity.java:2127` |
| 相机已被别的客户端占用（Ambarella `rval` 特判） | `R.string.amba_device_occupied` | `Connection failed, the device is connecting to other clients` | 连接失败，设备正在连接其他客户端 | `…/HomeActivity.java:1184` |
| 未连相机热点 | `R.string.no_connect_camera` | `Not connected to the camera's Wi-Fi \n please connect to camera's Wi-Fi by following steps` | 还没有设备，赶紧连接吧 | `…/re/xtugo/layouts.md:333` |
| 通用 CGI 失败 Toast | `R.string.fail` | `Fail` | — | `HttpProxy` 静态 Handler `what==1`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:47-56` |
| 预览参数请求抛异常 | 硬编码中文（无资源 ID） | — | `请在系统wifi重新连接相机` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:373-379` |

---

## 2. 实时预览

### 2.1 前置状态

| 条件 | 值 | 出处 |
|---|---|---|
| 已连接且 `CameraParameters.BaseUrl` 已设 | `http://<ip>/cgi-bin/hi3510/` | `_work/xtu_src/sources/com/gku/HomeActivity.java:1756` |
| `DV.cameraInfors != null` | 否则首帧前会补发 Ambarella `msg_id=11`（对海思机是空操作） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:816-828` |
| `IsConnectCamera == true` | `NewDV.getInstance().setConnectStatus(true)` | `…/HomeActivity.java:1738` |
| 预览页 | `HisiActionCameraPreviewActivity`（B 套 UI）/ `AmbaActionCameraPreviewActivity`（Ambarella）/ `ActivityNewPreview`（C 套） | 分派见主文档 §2.2 `PreviewModelManage` |

### 2.2 起流 URL 选择（三套实现，值逐个抄）

| 分支 | URL 模板 | 变量真实值 | 出处 |
|---|---|---|---|
| **B 套（真机 S7PRO 走这条）** | `rtsp://192.168.0.1:554/livestream/12` | 常量硬编码：**主机固定为 `SSConstant.SS_IP="192.168.0.1"`（不是运行时 IP）**、端口 `554`、路径 `/livestream/12`、**永远是小码流 12，不受 `preview_video` 开关影响** | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:31-32,49-51`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:31-32,49-51`；调用点 `…/HisiActionCameraPreviewActivity.java:767`、`…/AmbaActionCameraPreviewActivity.java:752` |
| **A 套 RTSP** | `rtsp://<ip>:554/livestream/{11\|12}` | `11` = `isPreviewBigBitRate()` 为 true，否则 `12` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:319-329` |
| **A 套 HTTP** | `http://<ip>:80/{11\|12}?trans=tcp&action=play&media=video_data` | 同上，`11`/`12` 后紧跟 `?` | `…/dv/biz/DV.java:331-341` |
| A 套 RTSP 唯一消费者 | `TelevisionActivity`（回放投电视）用 `getVideoRtspURL()` | — | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java:297` |

> **冲突点（静态 vs 实现）**：主文档 §11 说「12 会切成 11（`isPreviewBigBitRate()`）」只对 **A 套 `DV.getVideoRtspURL()`/`getVideoHttpURL()`** 成立。真机 S7PRO 走的 B 套 `SSCommandUtil.previewLiveStream()` **不查这个开关、也不查运行时 IP**，因此 **NewAPP 机型上「码流大小」切换不改预览 URL**。

### 2.3 播放器参数

**不在此重复**：ijk 的 17 条 `setOption` 键值全表与 RTSP 传输选择规则见 [附录 C · SigmaStar 8080 帧与播放层](xtugo.md) §3；结论摘要（值抄自 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java:592-613`）：`skip_loop_filter=48`(category 2)、`analyzemaxduration=100`、`probesize=100`、`flush_packets=1`、`max-buffer-size=1024`、`dns_cache_clear=1`（category 1）、`packet-buffering=0`、`framedrop=12`、`mediacodec-handle-resolution-change=0`、`find_stream_info=0`、`render-wait-start=1`、`reconnect=5`、`mediacodec=0`（category 4）；`type ∈ {H75N,"CV75"}` → `rtsp_transport=udp`，否则 `rtsp_flags=prefer_tcp`（`:603-607`）。

### 2.4 按顺序发什么（B 套完整序列）

| 序 | 请求 | 精确参数 | 判据 | 出处 |
|---|---|---|---|---|
| 1 | `GET BASE + "record.cgi"` 系？ **否** | 预览**不需要**任何 CGI 起流命令，相机常驻推流 | — | `SSCommandUtil` 无 start stream 方法 |
| 1' | 首批参数（连上后自动，见 §1.5 步 10） | `getallworkmode.cgi` / `getbatterycapacity.cgi` / `getsdstate.cgi` / `setsystime.cgi?-time=yyyyMMddHHmmss` | body 首行 `Success`（`SSResponseParse.SS_SUCCESS="Success"`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:41`） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/HaisiPreviewModel.java:62-68,221` |
| 2 | 遮罩图 + 翻转预处理 | `getsecondmenuitem.cgi?-workmode=<mode>&-name=FLIP` 的值决定 `preview_cover` 旋转，取值 `"90°"`/`"180°"`/`"270°"`（**带度数符号与引号**，`TextUtils.equals` 精确比） | 非空 | `…/HisiActionCameraPreviewActivity.java:720-753` |
| 3 | 延迟 `time` ms 后建流 | `initIjkVideoView(0)`（`event<=0`）或 `initIjkVideoView(1000)`（`event==268632078`） | — | `…/ActionCameraPreviewPresenter.java:731-739` |
| 4 | `IjkMediaPlayer.loadLibrariesOnce(null)` + `native_profileBegin("libijkplayer.so")` | 抛 `UnsatisfiedLinkError` 则 `isInitIjkPlayer=false`，**继续走 setVideoPath**（静默降级） | — | `…/HisiActionCameraPreviewActivity.java:769-774` |
| 5 | `preview_texture_video_view.setVideoPath("rtsp://192.168.0.1:554/livestream/12", <isAmba>, flipValue)` | 随后 `requestFocus()` + `start()` + `hasStartPlay=true`；整个起流块被 `postDelayed(..., Math.max(time, 300))` 包住 → **最小延迟 300ms** | `onInfo(what==3)`（`MEDIA_INFO_VIDEO_RENDERING_START`） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:828,833-837,839-841,843`；`…/HisiActionCameraPreviewActivity.java:784` |

### 2.5 失败重试（两条独立看门狗，数值照抄）

| 机制 | 触发 | 动作 | 参数 | 出处 |
|---|---|---|---|---|
| **错误重试** | `OnErrorListener.onError(what,extra)` | `initIjkVideoView2(1000)` → 销毁重建 `VideoTextureView` 后延迟 1000ms 重新起流 | 延迟 `1000L` | `…/HisiActionCameraPreviewActivity.java:800-806`、`:705-708` |
| **完成重试** | `OnCompletionListener.onCompletion`（RTSP 被相机单方面断流） | 仅当 `curActivityIsVis` 为真时 `initIjkVideoView2(500)` | 延迟 `500L` | `…/HisiActionCameraPreviewActivity.java:809-816` |
| **卡流看门狗** | `checkRunnable`，`handler.postDelayed(checkRunnable, 1200L)` 自递归 | 若 `videoRenderingStart && lastStreamTime>0 && now-lastStreamTime>1500 && curActivityIsVis` → 判定断流 → `removeCallbacks(taskRunnable)` 后重建 | 探测周期 `1200L` ms、停滞阈值 `1500` ms | `…/HisiActionCameraPreviewActivity.java:176-197,784-794,848-850` |
| **遮罩超时** | `mainUIUpdateHandler.postDelayed(taskRunnable, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)`（ExoPlayer 常量真值 = **3000 ms**，`_work/xtu_src/sources/com/google/android/exoplayer2/C.java:84`） | 到点仍未渲染 → `initIjkVideoView(0)` 重建 | `3000` ms | `…/HisiActionCameraPreviewActivity.java:152-158,690-693` |
| **4K 复读重播**（仅 Ambarella） | `runRefView()` → `postDelayed(runRefViewRunnable, SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US)`；常量真值 **150000**（`_work/xtu_src/sources/com/google/android/exoplayer2/audio/SilenceSkippingAudioProcessor.java:9`），而 `postDelayed` 单位是 **ms** → 实际周期 **150 秒** | 当 `resolutionString ∈ {"4K60","4K30"}` 且 Activity 可见 → `initIjkVideoView(0)` 重起流，然后自我续期 | `150000` ms | `…/HisiActionCameraPreviewActivity.java:159-169,681-688`；仅 `type ∈ {H75N,"CV75"}` 才启动（`…/HisiActionCameraPreviewActivity.java:631-636`，`cameraInfors != null` 分支里才 `runRefView()`） |
| **卡流提示** | `checkRunnable` 判到卡流时 `showCenterToast(R.string.text_please_near_device)`，`needTips=false`（一次） | — | — | `…/HisiActionCameraPreviewActivity.java:181-190` |
| **状态驱动重连** | `getcurallinfo.cgi` 的 `event` | `event<=0` → `initIjkVideoView(0)`；`event==268632078`（0x1003000E）→ `initIjkVideoView(1000)` | — | `…/ActionCameraPreviewPresenter.java:731-739` |
| **Ambarella 侧** | `rval` 特判 | `-444`→事件 137、`-4`→129、`-1`→136、`-34/-33/-18/-17`→135（`-17` 额外 Toast `R.string.sd_no_more_space`「The memory card is full.」/「存储卡已满」）、body 含 `"Read timed out"`→事件 128 | — | `_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:390-451` |

### 2.6 码流大小切换

| 项 | 值 | 出处 |
|---|---|---|
| SP key | `Common.KEY_PREVIEW_VIDEO = "preview_video"` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:118` |
| 取值枚举 | `"Big"` / `"Small"`，默认 `"Small"`；非法值一律改写为 `"Small"` | `…/dv/biz/Prefer.java:32`；`…/dv/biz/DV.java:119-132`、`:138` |
| 写入点 | 设置页 `PreferenceScreen`（A 套老方言），`persistent="false"` | 主文档 §4.3 `preview_video` 行 |
| 生效方式 | 仅当 `isPreviewBigBitRate()` 被调用（A 套 URL）→ **B/C 套不读，切了也没有报文变化** | `…/dv/biz/DV.java:319-341` |
| 下载码流是另一个开关 | `Common.KEY_DOWNLOAD_VIDEO = "download_video"`，同样 `Big`/`Small`，默认 `Small`（`DV.isDownloadBigVideo()`，`…/dv/biz/DV.java:104-118`） | 见 §7.4 |

### 2.7 预览页其它动作

| 动作 | 报文 | 出处 |
|---|---|---|
| 画面旋转 | `GET BASE + "getcurrotation.cgi"` → 解析键 `rotation`（`Key.ROTATION`）；解析失败返回 `0` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:27,173-175`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/HaisiPreviewModel.java:249-261,279` |
| 镜像 | 快设项 `FLIP`（`getsecondmenuitem`/`setcurparameter`） | 主文档 §4.2 |
| 退出快录（Quick Video） | `GET BASE + "exitquickrec.cgi"`（**无 query**） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:12,157-159`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/HaisiPreviewModel.java:295` |
| 快故事加时长 | `GET BASE + "record.cgi?-cmd=Storie"`（名字以 `S7PRO`/`S7PRO MAX` 结尾）否则 `?-cmd=Quick Stories` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:177-184` |
| 自动旋转开关（手机侧） | `Settings.System.canWrite()` + `putInt("accelerometer_rotation", …)`，**与相机无关** | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:1215-1222`；`…/HisiActionCameraPreviewActivity.java:1226-1233` |
| 预览失败提示（`event==10700000`） | Toast `R.string.ss_sd_out` = 默认 `SD card not detected`／中文「未检测到SD卡」 + `hideSdCardUI()` | `…/HisiActionCameraPreviewActivity.java:1122-1133` |
| 插卡提示（`event==11700006`） | Toast `R.string.ss_sd_in` = 默认 `SD card detected`／中文「检测到SD卡」 | 同上 |

---

## 3. 录像 / 停止录像

### 3.1 B 套（NewAPP，真机 S7PRO）

**前置状态**：`getcurallinfo.cgi` 回 `state != 20`（即 `CAMERA_STATE_WORKING_END=21` STANDBY 或空闲）；当前模式是视频类（`SSExchangeWorkMode.isVideoMode(allWorkMode, curWorkMode)`，判据是 `allWorkMode.get("video")` 列表 `contains(curWorkMode)`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:27-30`）。

| 序 | 报文 | 精确值 | 判据 | 出处 |
|---|---|---|---|---|
| 1 | `GET BASE + "record.cgi?-cmd=start"` | 由 `SSCommandUtil.startRecord()` 拼：`UNIVERSAL_PART(Common.BOOT_ACTION_RECORD)` = `"/cgi-bin/hi3510/" + "record" + ".cgi"`，再 `+ "?-cmd=start"`。`BOOT_ACTION_RECORD` 的值是 `"record"`（与开机动作复用同一常量） | **`SSResponseParse.SS_SUCCESS`**：App 判的是 body `trim()` 后 `equals("Success")`；失败**不 Toast**，仅回调 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:141-143`；调用点 `…/OldUi/preview/model/SigmastartPreviewModel.java:194-206` |
| 1' | 同上的海思变体 | `HaisiCommandUtil.startRecord()` 完全同串，但海思预览页**不直接调它**，而是走 `commandOperation()` 算出索引后调 `HaisiCommandUtil.getexecuteCommand(i)` → `Common.CGI_PATH + Command.cgiFilesParams[i]`（A 套表，见 §3.2） | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:160-166,60-69`；`…/HaisiPreviewModel.java:383` |
| 2 | 确认起录 | 靠 §11 的 `getcurallinfo.cgi` 回 `state=20`；UI 播 `sv_message.showNormalMessage(R.string.ss_event_start_record, 1500)`（默认「Start recording」/中文「开始录像」，显示 1500ms），并 `startRecordCountDown(pasttime)` | 状态字段 | `…/HisiActionCameraPreviewActivity.java:1135-1152` |
| 3 | `GET BASE + "record.cgi?-cmd=stop"` | `SSCommandUtil.stopRecord()`（`:145-147`） | body `=="Success"` | `…/SigmastartPreviewModel.java:207-219` |
| 4 | 确认停录 | `state=21` 且 `event ∈ {11700002, 273420290, 273420291, 273420315, 272642051}` → `showFinishMessage(R.string.ss_event_save, 1500)`（默认「Saved」/「已保存」） + `finishRecordCountDown()` | 状态字段 | `…/HisiActionCameraPreviewActivity.java:1160-1163` |

**失败分支**

| 情况 | App 行为 | 文案 | 出处 |
|---|---|---|---|
| HTTP 非 200 | `onFail(code, msg)` → `mCallback.httpRequestError(...)` | `R.string.gku_operation_failed` = 默认 `Operation failed`／中文「操作失败」，**并追加 `":" + code`** | `…/ActionCameraPreviewPresenter.java:310-315` |
| 200 但 body 不是 `Success` | **静默**（无提示），只 `dismissProgress()` | — | `…/HaisiPreviewModel.java:383-393`（`commandOperation` 的回调只写日志 `"commandOperation ASSADASFSA"`） |
| 录像中再点录像 | 按钮已被 §5 的客户端禁用逻辑吃掉；若绕过则固件回 `SvrFuncResult` | — | §3.2 |
| 通用失败 | `HttpProxy` Handler `what==1` | `R.string.fail` = `Fail` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:47-56` |

### 3.2 A 套（老海思，`hardversion != "NewAPP"`）：命令索引表

`Command.executeCommand(ip, cmd)` → `String.format("http://%s%s%s", ip, "/cgi-bin/hi3510", Command.cgiFilesParams[cmd])`，`cmd` 合法区间 `[0,21)`，越界直接返回 `errorCode=0/returnCode=0` 的**空 Result**（等于假成功）。
出处：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:31,33-36`。

| `cmd` | 常量（`Command.*`） | URL 尾串（逐字照抄） |
|---|---|---|
| 0 | `ACTION_RECORD_START` | `/record.cgi?&-cmd=start` |
| 1 | `ACTION_RECORD_STOP` | `/record.cgi?&-cmd=stop` |
| 2 | `ACTION_PHOTO` | `/photo.cgi?&-type=photo` |
| 3 | `ACTION_BURST` | `/photo.cgi?&-type=photoburst` |
| 4 | `ACTION_TIMELAPSE_START` | `/photo.cgi?&-type=phototimelapse&-cmd=start` |
| 5 | `ACTION_TIMELAPSE_STOP` | `/photo.cgi?&-type=phototimelapse&-cmd=stop` |
| 6 | `ACTION_TIMER_START` | `/photo.cgi?&-type=phototimer&-cmd=start` |
| 7 | `ACTION_TIMER_STOP` | `/photo.cgi?&-type=phototimer&-cmd=stop` |
| 8 | `ACTION_CONTINUOUS_START` | `/photo.cgi?&-type=continuous&-cmd=start` |
| 9 | `ACTION_CONTINUOUS_STOP` | `/photo.cgi?&-type=continuous&-cmd=stop` |
| 10 | `ACTION_VIDEO_QUICK_EXIT` | `/exitquickrec.cgi` |
| 11 | `ACTION_VIDEO_COMMON_START` | `/record2.cgi?&-type=common&-cmd=start` |
| 12 | `ACTION_VIDEO_COMMON_STOP` | `/record2.cgi?&-type=common&-cmd=stop` |
| 13 | `ACTION_VIDEO_LOOP_START` | `/record2.cgi?&-type=loop&-cmd=start` |
| 14 | `ACTION_VIDEO_LOOP_STOP` | `/record2.cgi?&-type=loop&-cmd=stop` |
| 15 | `ACTION_VIDEO_TIMELAPSE_START` | `/record2.cgi?&-type=timelapse&-cmd=start` |
| 16 | `ACTION_VIDEO_TIMELAPSE_STOP` | `/record2.cgi?&-type=timelapse&-cmd=stop` |
| 17 | `ACTION_VIDEO_SNAP_START` | `/record2.cgi?&-type=recsnap&-cmd=start` |
| 18 | `ACTION_VIDEO_SNAP_STOP` | `/record2.cgi?&-type=recsnap&-cmd=stop` |
| 19 | `ACTION_VIDEO_SLOW_START` | `/record2.cgi?&-type=slow&-cmd=start` |
| 20 | `ACTION_VIDEO_SLOW_STOP` | `/record2.cgi?&-type=slow&-cmd=stop` |
| 21 | `ACTION_BUTT` | （哨兵，数组无此项，`cmd<21` 已排除） |

**A 套是唯一「判据看 body」的实现**（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:37-52`）：
- body 含 `SvrFuncResult` → 取 `substring(15, lastIndexOf("\""))`；该子串等于 `"sd is not ready"` → `Common.ERR_SD_ERROR`；等于 `"sd is full"` → `Common.ERR_SD_FULL`；否则 `parseInt` 当错误码（**这就是真机上 `0xFFFFF752` 那类值的来源，注意它按十进制 parse 会抛 `NumberFormatException` → `errorCode=-1`**）。
- body 不含 `SvrFuncResult` 且 `statusCode==200` → `returnCode=0, errorCode=0`。
- 非 200 → `returnCode=-1`。
- `substring(15,…)` 是**按 `"var SvrFuncResult="` 长度硬数出来的**（15 字符），任何前缀变化都会切错。

**B 套复用 A 套表时的 `executeCommand` 变形**（重要，容易漏）：`HaisiCommandUtil.executeCommand(cmd)` 在 `CameraParameters.IsNewAPP && cmd >= 10 && cmd != 10` 时把 `cmd` 折成 `cmd % 2 == 0 ? 1 : 0` —— 也就是说 **NewAPP 下第 11/12（common 启停）、13/14（loop）、15/16（timelapse）、17/18（recsnap）、19/20（slow）全部退化成 `1`（start）或 `0`（stop）**，落到 `/record.cgi?&-cmd=start` / `/record.cgi?&-cmd=stop`。
出处：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:53-58`；同样的折叠逻辑在 `…/dv/biz/DV.java:348-355`（`executeCommand(int)`）。
例外：`cmd == 10` 保持原义（`exitquickrec.cgi`）。
另有机型例外：`type == Common.SENSOR_34220`（`"34220"`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:145`）时 `Normal Video` 等 6 个模式的 `commandOperation` **恒返回索引 0**（即永远只发 start），见 `…/HaisiPreviewModel.java:342-351`。

---

## 4. 拍照（单张 / 连拍 / 延时 / 慢动作）

### 4.1 B 套 `photo.cgi`

| 动作 | 报文 | 由谁决定 type | 出处 |
|---|---|---|---|
| 拍照（起） | `GET BASE + "photo.cgi?-type=photo&-cmd=start"` | `SSExchangeWorkMode.getPhotoType()` **写死返回 `"photo"`** —— 也就是说 B 套所有拍照模式发的都是同一个 type，连拍/延时的差异**全靠先切 `workmode`**，不靠 type | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:149-151`；`…/util/SSExchangeWorkMode.java:37-39`；调用点 `…/OldUi/preview/model/SigmastartPreviewModel.java:220` |
| 拍照（停） | `GET BASE + "photo.cgi?-type=photo&-cmd=stop"` | 同上 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:153-155`；`…/SigmastartPreviewModel.java:233` |
| 海思预览页实际路径 | 经 `commandOperation()` → `getexecuteCommand(i)` → **A 套 `photo.cgi?&-type=…`**（带 `&`，与 B 套 `?` 起手的写法不同） | `i ∈ {2,3,4,5,6,7}` | `…/HaisiPreviewModel.java:360-371`、`:383` |

> **静态冲突点**：同一 APK 内 `photo.cgi` 有两套拼法 —— B 套 `SSCommandUtil.startPhoto()` 是 `photo.cgi?-type=photo&-cmd=start`，A 套表是 `photo.cgi?&-type=photoburst`（`&` 起手的空首参 + 不同 type 串）。海思 NewAPP 机型走的是 **A 套表**（因为 `HaisiPreviewModel.commandOperation` → `getexecuteCommand`），所以 §3.2 的 type 枚举才是实际会出现在网络上的：`photo`、`photoburst`、`phototimelapse`、`phototimer`、`continuous`。

### 4.2 各拍照模式的模式串与索引映射（`commandOperation` 全枚举）

`HaisiPreviewModel.commandOperation(allWorkMode, curWorkMode, workState)`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/HaisiPreviewModel.java:340-394`）：

| `curWorkMode` 匹配（`CameraParameters.*` 常量值，逐字） | state==20 → cmd | state!=20 → cmd | 落到 URL |
|---|---|---|---|
| `NormalVideo`(`"NormalVideo"`)、`"Normal Video"`、`"Quick Stories"`、`"Under Water"`、`"Time Stretch"`、`"Manual Recsnap"` | 12 | 11 | `type=34220` 传感器：恒 0（`/record.cgi?&-cmd=start`）；否则 `?` 12=`/record2.cgi?&-type=common&-cmd=stop` / 11=start —— 但 NewAPP 折叠后 = `/record.cgi?&-cmd=stop` / `start` |
| `"Loop Video"`、`"CarMode"`、`"Car Looping"` | 14 | 13 | loop stop / loop start |
| `"VideoLapse"`、`"Timelapse Video"` | 16 | 15 | timelapse stop / start |
| `"VideoPhoto"`、`"Video and Photo"` | 18 | 17 | recsnap stop / start |
| `"SlowRec"`、`"Slow Motion"` | 20 | 19 | slow stop / slow start |
| `"NormalPhoto"`、`"Normal Photo"`、`"Night Photo"`、`"Raw Photo"`、`"Long Exposure"` | 2 | 2 | `/photo.cgi?&-type=photo`（**与 state 无关**） |
| `"TimerPhoto"`、`"Timing Photo"` | 7 | 6 | `phototimer` stop / start |
| `"Lapse Burst"` | 2（`workState.getState()` 结果被丢弃，`:365`） | 2 | `/photo.cgi?&-type=photo` |
| `"Burst"`、`"Burst Photo"` | 3 | 3 | `/photo.cgi?&-type=photoburst`（**与 state 无关**） |
| `"PhotoLapse"`、`"Timelapse Photo"`、`"Night Timelapse Photo"`、`"Night Scene"` | 5 | 4 | `phototimelapse` stop / start |
| `"Quick Video"` | 12 / 0（同 `NormalVideo` 规则） | 11 / 0 | 同第一行 |
| 其它 | -1 | -1 | `getexecuteCommand(-1)` → 数组越界被 catch → **返回空串 `""`** → `DeviceHttpUtils.get("")`（静默失败） |

模式常量定义：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:46-74`（`NormalPhoto="NormalPhoto"`、`TimerPhoto="TimerPhoto"`、`Burst="Burst"`、`PhotoLapse="PhotoLapse"`、`NormalVideo=Common.WORK_MODE_NOMAL_VIDEO="NormalVideo"`（**拼写就是 `NOMAL`**，`…/dv/biz/Common.java:152`）、`CarMode="CarMode"`、`VideoLapse="VideoLapse"`、`VideoPhoto="VideoPhoto"`、`VideoLoop="Loop Video"`、`SlowRec="SlowRec"` + `New*` 系列等于 `SSExchangeWorkMode.SS_*`）。
`SSExchangeWorkMode` 15 个串逐字（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:11-25`）：`"Burst Photo"`、`"Car Looping"`、`"Lapse Photo"`、`"Timelapse Photo"`、`"Timelapse Video"`、`"Long Exposure"`、`"Normal Photo"`、`"Normal Video"`、`"Quick Stories"`、`"Quick Video"`、`"Raw Photo"`、`"Slow Motion"`、`"Timing Photo"`、`"Under Water"`、`"Video and Photo"`。

### 4.3 慢动作 / 延时的「参数」而非「命令」

慢动作与延时的差异不体现在启停报文上（都是 `record2.cgi?&-type=slow|timelapse`），而是靠 §6 的 `setcurparameter` 写 `Resolution` / `Time Lapse` / `Duration`。App 侧另有两条专用写命令：

| 动作 | 报文 | 判据 | 出处 |
|---|---|---|---|
| 设定时拍倒计时 | `GET BASE + "settimerinfo.cgi?&-time=" + <秒>` | **只看 statusCode==200**（`doHttpGetForContent(...).statusCode == 200`，连 `doForSuccess` 都不是） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:291-297` |
| 设延时间隔 | `GET BASE + "settimelapseinfo.cgi?-time=" + <秒>`（注意这里分隔符是 `?` 不是 `?&`） | 同上，只看 200 | `…/HttpProxy.java:299-303` |
| A 套等价 | `setburstinfo.cgi?&-time=%d&-count=%d`、`settimelapseinfo.cgi?&-time=%d`、`settimerinfo.cgi?&-time=%d`、`setrecordtimelapse.cgi?&-time=%d` | 走 `doForSuccess` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:183,191,199,207` |

### 4.4 拍照的 UI 反馈（成功/失败判据在状态里，不在响应里）

| 事件 | 表现 | 文案（资源 ID + 默认英文 + 中文） | 出处 |
|---|---|---|---|
| `state==20` 且是拍照模式，或 `event ∈ {3, 268632077}` | 显示拍照中；`Timing Photo` 会把快门图标换成 `R.mipmap.recordorcamera_stop_cutecam`（APP_XTU 分支）或 `R.mipmap.recording_yutupro` | — | `…/HisiActionCameraPreviewActivity.java:1186-1200` |
| `Burst Photo` | `sv_message.showLoadingMessage(getString(R.string.ss_event_start_photo))` | `Start taking pictures` / 开始拍照 | `:1204-1206` |
| `Lapse Photo` / `Timelapse Photo` | `showLoadingMessage(getString(R.string.mode_photo_timer) + "...")` | `mode_photo_timer` 中文见 §6 | `:1201-1203` |
| 单张 | `showNormalMessage(R.string.ss_event_start_photo, 1500)` | `Start taking pictures` / 开始拍照 | `:1207-1209` |
| 落盘完成 `state==21 && event ∈ {11700002,273420290,273420315,272642051}` 或 `event ∈ {4, 268632078}` | `showFinishMessage(R.string.ss_event_save, 1500)` | `Saved` / 已保存 | `:1212-1216` |
| 快门防抖 | `iv_capture.setEnabled(false)` + `postDelayed(..., C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS /*3000 ms*/)` 后恢复 | — | `…/HisiActionCameraPreviewActivity.java:1101-1110` |
| 长按曝光（`Long Exposure` 且 `state==20`） | 单独分支 | — | `…/AmbaActionCameraPreviewActivity.java:333-336` |

---

## 5. 切工作模式

### 5.1 报文

| 序 | 报文 | 精确值 | 出处 |
|---|---|---|---|
| 1 | `GET BASE + "setcurworkmode.cgi?-workmode=<模式串>"` | `<模式串>` 是 §4.2 的带空格全名；URL 里空格用 `replaceAll(" ", "%20")` 手工替换（**不是 `Uri.encode`**，所以 `+`、`&` 之类不会被转义） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:223-239`；B 套另有 `SSCommandUtil.setCurWorkMode()`（`:93-95`）/ `HaisiCommandUtil.setCurWorkMode()`（`:107-109`）同串但**不做空格替换** |
| 2 | 读当前模式 | `GET BASE + "getcurworkmode.cgi"` → `StringParser.getMap` 取 `workmode`（严格 `";\r\n` 结尾） | `…/HttpProxy.java:213-221` |
| 3 | 读全模式表 | `GET BASE + "getallworkmode.cgi"` → `getMap2` 取 `photo` / `video` 两键，按 `,` 切成 `CameraParameters.PhotoModel` / `VideoModel` | `…/HttpProxy.java:197-211` |
| 4 | 切完刷新 | `getSysWorkstate()`（即 `getcurallinfo.cgi`） | `…/ActionCameraPreviewPresenter.java:299` |

### 5.2 成功判据（三层，层层不同，别混）

| 层 | 判据 | 后果 | 出处 |
|---|---|---|---|
| `HttpProxy.setCurrentWorkModel()` | `doForSuccess(url) == 0`，**只看 200** | `DV.Strmode = SelectModel`（**本地状态被改写，即使固件拒绝**）+ `handler.sendEmptyMessage(0/1)` | `…/HttpProxy.java:230-238` |
| B 套预览页 `setCurMode` 回调 | `result.trim().trim() == "Success"`（**两次 trim，代码笔误**） | 才 `dismiss` 弹窗、改 `curWorkMode`、刷 UI、`getSysWorkstate()` | `…/ActionCameraPreviewPresenter.java:291-300` |
| 状态回读 | `getcurallinfo.cgi` 的 `mode` 字段 | 真值 | `…/HaisiPreviewModel.java:240-246` |

> **与真机互证**：真机「无空格写法被固件回 `SvrFuncResult=0xFFFFF752`(-2222)」在代码里只有一处痕迹 —— `SSResponseParse.parseGetAllInfo(String)` 里 `if (message.contains("-222")) return null;`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:511-513`），即「当作没有状态」，**不报错、不提示**。切模式失败在 B 套预览页的表现是「转圈消失但模式没变」，在 A 套是「本地 `DV.Strmode` 已经变了但下一次 `getcurallinfo` 又被打回」。

### 5.3 录像中切模式 / 改参数：客户端直接禁止（来龙去脉）

| 环节 | 实现 | 出处 |
|---|---|---|
| 状态读取 | `getcurallinfo.cgi` → `SSystemWorkState(mode,state,event,pasttime)`，`state` 常量 `CAMERA_STATE_WORKING_STR=20` / `CAMERA_STATE_WORKING_END=21` | `…/HaisiPreviewModel.java:240-246`；`…/dv/ui/config/CameraParameters.java:23-24` |
| 按状态算命令 | `commandOperation()`：视频类模式在 `state==20` 时给出的是 **stop** 索引（12/14/16/18/20），非 20 才是 start | `…/HaisiPreviewModel.java:340-382` |
| 快门/录像按钮重绘 | `updateCommandUI(SSystemWorkState)` 每个分支首行都带 `&& sSystemWorkState.getState() == 20`/`== 21` 条件；`enableActionButton(true)` 只在 `updateOperateCommandUI` 末尾统一放开 | `…/HisiActionCameraPreviewActivity.java:1122-1133`、`:1135-1230` |
| 模式弹层 | `SSModeSelectPopupWindow` 只在 `curWorkMode != null && allWorkMode != null` 时才允许弹出；弹出后选中项要等 `Success` 才 dismiss（`:280-284`）。**真正的「禁止」是：`showModeSelectPopupWindow` 前 UI 已根据 `workState.getState()==20` 把入口按钮置灰/不可点**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:484`、`:150-186` 的 `updateOperateCommandUI` 驱动） | `…/ActionCameraPreviewPresenter.java:274-326`；`…/AmbaActionCameraPreviewActivity.java:484` |
| 设置页 | 快设/参数写也是同一条 `setcurparameter.cgi`，App 侧**没有**再读 `state` 做门控 → 录像中改参数是「客户端不拦、固件拒」。真机结论「官方是客户端直接禁止」**只对「切模式」成立**，对「改参数」不成立（静态无门控代码），冲突点见 §12 | `…/HttpProxy.java:241-256` |
| 定时拍进行中 | `mPhotoing` / `mTimingPhotoStopped` 两个 Activity 字段参与判断 | `…/HisiActionCameraPreviewActivity.java:1136-1137`、`:1188-1191` |

---

## 6. 参数设置

两条路径**互不相通**，必须分开复现：

| 路径 | 适用 | 项从哪来 | 静态表在哪 |
|---|---|---|---|
| **B. 动态菜单（NewAPP，真机 S7PRO）** | `hardversion=="NewAPP"` | 设备自描述：`getprimarymenuitem` + `getsecondmenuitem` | **无**（APK 里没有项名表，只有 12 个硬编码项名，见主文档 §4.2） |
| **A. 老方言 `preferences.xml`** | `hardversion!="NewAPP"` 的老海思机 | APK 静态 PreferenceScreen | `res/xml/preferences.xml` + `Common.java` 的 74 个 key + `Setting.java` 的读写命令 |

### 6.1 B 路径：列出 → 取值 → 写入（三个命令 + 一个系统页）

| 步 | 报文（逐字） | 解析 | 失败 | 出处 |
|---|---|---|---|---|
| 1 列当前模式一级菜单 | `GET BASE + "getprimarymenuitem.cgi?-workmode=" + <模式串>`，空格→`%20` | `StringParser.getMap2` → 取 `item`、`cur`；两者各按 `,` split 成等长数组喂 `getItem()`；`item` 为空串则**整个返回 null** | `statusCode != 200` → 返回 null | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:41-59` |
| 1' 列系统级菜单 | `GET BASE + "getprimarymenuitem.cgi?-workmode=System"`（**不替换空格，无空格**） | 同上，但 `cur` **末尾人为拼 `",test"`** 占位（喂给第 5 个固定项 `Information`） | 同上 | `…/SetDataUtils.java:92-112` |
| 2 取某项可选值（模式内） | `GET BASE + "getsecondmenuitem.cgi?-workmode=" + <模式串> + "&-name=" + <项名>`；项名含空格时先 `Uri.encode(ItemName,"UTF-8")`，再对整串 `replaceAll(" ","%20")`（**双重编码风险**） | 取 `item` 按 `,` 切成 `String[]`；`item` 空串→null | `!=200`→null | `…/SetDataUtils.java:169-189` |
| 2' 取某项可选值（系统） | `GET BASE + "getsecondmenuitem.cgi?-workmode=System&-name=" + <项名>`；`:301` 的 `str.replaceAll(...)` **返回值被丢弃**（笔误，实际未编码） | 同上 | 同上 | `…/SetDataUtils.java:294-316` |
| 2'' 取分辨率表 | `GET BASE + "getsecondmenuitem.cgi?-workmode=" + <模式串> + "&-name=Resolution"` | 返回整个 `TreeMap` | — | `…/SetDataUtils.java:278-292` |
| 2''' 读当前模式某项 | `GET BASE + "getcurworkmode.cgi"` → `getMap2` → `workmode`（按 `,` 切）+ `value` | `value` 缺失/空时改走 `exchangeValue(模式名)` 映射到固定项名再读 | — | `…/SetDataUtils.java:197-212,240-260` |
| 3 写（模式内） | `GET BASE + "setcurparameter.cgi?-workmode=" + (TYPE==0 ? DV.Strmode : "System") + "&-name=" + <项> + "&-value=" + <值>`，整串空格→`%20` | **判据只看 200**（`doForSuccess()==0`） | `handler.sendEmptyMessage(1)` | `…/dv/net/HttpProxy.java:241-256` |
| 3' 写（系统项） | `GET BASE + "setcurparameter.cgi?-workmode=System&-name=" + <项> + "&-value=" + <值>`；项名与值**各自** `Uri.encode(x,"utf-8")` | 只看 200 | 同上 | `…/HttpProxy.java:258-272` |
| 4 写成功后 | `EventBus.post(MessageEventModel(TYPE==0?3:4))` + `setPosition(position)` + `setSelectValue(value)` → 列表局部刷新；**不回读设备** | — | — | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUIUtils.java:186-204` |
| 5 快设条（预览页浮层） | `getsecondmenuitem.cgi?-workmode=<模式>&-name=<快设项>` → `SSResponseParse.parseGetSecondItem` | 快设项按模式定：`Timing Photo`→`Self-Timer`、`Timelapse Photo`/`Timelapse Video`→`Time Lapse`、`Burst Photo`→`Number`、`Quick Stories`→`Duration`；其余无快设 | `dismissFastSetting()` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:41-59,61-66`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/HaisiPreviewModel.java:71-83` |

**UI 类型推断（决定渲染成开关还是弹窗）** —— 逐条：

| type | 渲染 | 判据（`getItem2` 顺序即优先级） | 出处 |
|---|---|---|---|
| 1 | 纯点击行 | `value=="" \|\| value==null` | `…/SetDataUtils.java:151-155` |
| 3 | 开关 `WeChatSwitchButton` | `value ∈ {"ON","OFF"}` 且 `getDeviceSupportParms(项).length <= 2`；**或**项名 `Time Set`/`Auto Sync Time`（值来自本地 SP，不读设备） | `…/SetDataUtils.java:128-133,140-144` |
| 2 | 弹窗选择 | 值非空且非 ON/OFF；**或** ON/OFF 但可选值 > 2；**或**项名 `AV Out`/`Auto Dormant`（强制）；**或** `Resolution` 且当前值 ∈ {`720P100`,`720P200`,`1080P100`,`1080P200`,`720P120`,`720P240`,`1080P120`,`1080P240`} → 关掉 `ImageStabilize` 联动位 | `…/SetDataUtils.java:72-79,123-127,134-139,145-150` |

**系统页 5 个固定项**（`itemMode.getType()==1` 的 CMDStr 分派，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUIUtils.java:295-337`）：

| CMDStr | 动作 | 落到 |
|---|---|---|
| `"Wi-Fi"` | 异步 `SetDataUtils.getWifiInfor()` → `getwifi.cgi`，回调后 `postDelayed(500L)` 弹 `dialog_modify_wifi` | §8.1 |
| `"Time Set"` | `showDeviceDialog(1, …)` → 确认文案 `R.string.set_datetime`（`Set Phone Time to Camera`／「将手机时间同步到相机」）→ `setDevicePamarsStrNoValue(1)` | §8.2 |
| `"Factory Reset"` | `showDeviceDialog(2, …)` → `R.string.restore_tip`（`Factory Reset?`／「确定恢复出厂设置?」）→ `setDevicePamarsStrNoValue(2)` | §8.3 |
| `"SD Format"` | `showDeviceDialog(3, …)` → `R.string.format_tip`（`Are You Sure To Format SD Card?`／「确定要格式化SD卡?」），置 `isFormatSd=true` → `setDevicePamarsStrNoValue(3)` | §7.6 |
| `"Information"` | `startActivity(AboutCameraActivity)` | §8.4 |

**B 路径的失败提示**：`setDevicePamarsStrNoValue` 返回 false → `handler.sendEmptyMessage(1)` → 只有当 `isFormatSd==true` 才 Toast `R.string.format_sd_failure`（`Format Failed`／「格式化失败」）；**其它项写失败静默无提示**（`…/SetDataUIUtils.java:53-77`）。

### 6.2 值本地化（为什么 APK 里查不到中文项名）

`getItem()` / `getItem2()` 把 `cur`（值）过一遍 `FileUtils.getInstance().changeStr(value, Locale.getDefault().getLanguage())`；**项名 `item` 不过**，所以界面上左侧英文/中文取决于运行期语言表，右侧值也走同一张表（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:61-66,114-119`）。表来源见主文档 §4.2（`/mnt/language.xml` 或 `/tmp/FL0/language.json`，8080 口）。

### 6.3 A 路径：`preferences.xml` 逐条（读命令 / 写命令 / 枚举）

全部读命令走 `Setting.java` 里的 `String.format("http://%s%s/<cgi>", ip, Common.CGI_PATH)`，全部写命令同前缀；解析用 `HttpProxy.doForIntByKey` / `doForBoolean` / `doForMap`。

| 项（标题资源 → 中文） | 读命令 → 读键 | 写命令（参数逐字） | 取值枚举 | 出处 |
|---|---|---|---|---|
| Video Resolution（`video_resolution`） | `getvideoinfo.cgi?` → `resolution`,`fps` | `setvideoinfo.cgi?&-resolution=%s&-fps=%d` | NTSC：`720P_30`,`720P_60`,`720P_240`,`1080P_30`,`1080P_60`,`1080P_120`,`4K2K_30`（显示 `720P/30fps`…`4K2K/30fps`）；PAL：`720P_25`,`720P_50`,`720P_240`,`1080P_25`,`1080P_50`,`1080P_120`,`4K2K_25` | `…/dv/biz/Setting.java:34,38`；`res-strings-default.md:35-38` |
| Video Mode（`video_mode`） | `getvideonorm.cgi?` → `videonorm` | `setvideonorm.cgi?&-videonorm=%s` | `NTSC` / `PAL` | `…/Setting.java:227,238` |
| Audio（`audio_codec`，CheckBox） | `getaudioencode.cgi?` → `enable`（`"1"`→true/`"0"`→false/其它→null） | `setaudioencode.cgi?&-enable=%d` | 1 / 0 | `…/Setting.java:219,223`；`…/dv/net/HttpProxy.java:94-107` |
| 画面翻转（`image_upsidedown`） | `getflip.cgi?` → `enable` | `setflip.cgi?&-enable=%d` | 1 / 0 | `…/Setting.java:145,149` |
| 时间水印（`time_tag`） | `gettimeosd.cgi?` → `enable` | `settimeosd.cgi?&-enable=%d` | 1 / 0 | `…/Setting.java:264,268` |
| 开机动作（`boot_action`） | `getbootaction.cgi?` → `action` | `setbootaction.cgi?&-action=%s` | entries `Idle`,`Record`,`Timelapse Record`,`Loop Record`,`Slow Motion` ／ values `idle`,`record`,`recordlapse`,`recordloop`,`recordslow`（**`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:8-10` 只定义 `idle`/`record`/`timelapse` 三个常量，与数组不自洽**） | `…/Setting.java:211,215`；`res-strings-default.md:14-15` |
| 自动息屏（`screen_auto_sleep`） | `getscreenautosleep.cgi?` → `time` | `setscreenautosleep.cgi?&-time=%d` | entries `OFF`,`1min`,`3min`,`5min` ／ values `0`,`1`,`3`,`5` | `…/Setting.java:338,342`；`res-strings-default.md:25-26` |
| 亮度（`screen_brightness`） | `getscreenbrightness.cgi?` → `brightness` | `setscreenbrightness.cgi?&-brightness=%d` | int | `…/Setting.java:346,350` |
| 自动关机（`auto_shutdown`） | `getautoshutdown.cgi?` → `time` | `setautoshutdown.cgi?&-time=%d` | int 秒 | `…/Setting.java:330,334` |
| 蜂鸣（`buzzer_prompt`） | `getbuzzer.cgi?` → `enable` | `setbuzzer.cgi?&-enable=%d` | 1 / 0 | `…/Setting.java:284,288` |
| LED（`led_state`） | `getledstate.cgi?` → `enable` | `setledstate.cgi?&-enable=%d` | 1 / 0 | `…/Setting.java:276,280` |
| 循环录（`loop_record`） | `getlooprecord.cgi?` → `enable` | `setlooprecord.cgi?&-enable=%d` | 1 / 0 | `…/Setting.java:137,141` |
| 视角（`field_of_view`） | `getviewfield.cgi?` → `fov` | `setviewfield.cgi?&-fov=%d` | int | `…/Setting.java:122,131` |
| 点测光（`spot_metering`） | `getspotmeter.cgi?` → `enable` | `setspotmeter.cgi?&-enable=%d` | 1 / 0 | `…/Setting.java:256,260` |
| 连拍（`burst_rate`/张数） | `getburstinfo.cgi?` → `time`,`count` | `setburstinfo.cgi?&-time=%d&-count=%d` | int | `…/Setting.java:153,183` |
| 延时间隔（`timelapse_interval`） | `gettimelapseinfo.cgi?` → `time` | `settimelapseinfo.cgi?&-time=%d` | int | `…/Setting.java:187,191` |
| 定时拍倒数（`timer_count_down`） | `gettimerinfo.cgi?` → `time` | `settimerinfo.cgi?&-time=%d` | int | `…/Setting.java:195,199` |
| 录像延帧（`record_timelapse`） | `getrecordtimelapse.cgi?` → `time` | `setrecordtimelapse.cgi?&-time=%d` | int | `…/Setting.java:203,207` |
| 码率 | `getbitrate.cgi?` → `bitrate` | `setbitrate.cgi?&-bitrate=%d` | int | `…/Setting.java:514,518` |
| WiFi 信道 | `getwifichannel.cgi?` → `wifichannel` | `setwifichannel.cgi?&-wifichannel=%d` | int | `…/Setting.java:522,526` |
| 开机 UI 模式 | `getpoweronuimode.cgi?` → `uimode` | `setpoweronuimode.cgi?&-uimode=%d` | `0..4`（`DV.getPowerOnUiMode()` 越界即丢弃，`…/dv/biz/DV.java:307-310`） | `…/Setting.java:354,358` |
| 工作模式（数字） | `getworkmode.cgi?` | `setworkmode.cgi?&-workmode=%d?`（**尾部多一个 `?`，是真实笔误**） | `WORK_MODE_*`：`0`单拍、`1`定时、`2`RAW、`10`连拍、`11`延时拍、`12`连拍录像、`20`普通录像、`21`循环、`22`延时录、`23`录像+拍照、`24`慢动作、`25`快故事、`26`延时连拍 | `…/Setting.java:534,538`；`…/dv/biz/Common.java:149-162` |
| 能力查询（按模式+类型） | `getcapability.cgi?&-workmode=%d&-type=%d`、`getparameter.cgi?&-workmode=%d&-type=%d` | `setparameter.cgi?&-workmode=%d&-type=%d&-value=%s` | `type` 枚举 = `CONFIG_*`：分辨率 0、间隔/定时/连拍率 1、场景/快照模式 2、快照间隔 3、照片分辨率 4、录像分辨率 5、模式 6、循环类型 7（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Common.java:12-26`） | `…/Setting.java:542,546,550` |
| 设备能力 | `getdevcapabilities.cgi?` | — | 返回串里含 `"standby"` 才允许 WoL（§8.5） | `…/Setting.java:530` |
| 电量 | `getbatterycapacity.cgi?` → `capacity`,`charge`,`ac` | — | int / 1 / 0/1 | `…/Setting.java:45` |
| 卡状态 | `getsdstate.cgi?` → `sdstate`,`total`,`used` | — | `sdstate ∈ {"SDOK","SDFULL","SDNONE","SDERROR"}`；`total`/`used` 去掉 `" MB"` 后 parseInt | `…/Setting.java:89,107-115`；`…/HaisiPreviewModel.java:205-238` 同解析 |
| 关于 | `getdeviceattr.cgi` → `name`,`serialnum`,`softVersion`,`hardVersion`,`type` | — | — | `…/Setting.java:245` |
| 设置时间 | — | `setsystime.cgi?&-time=%04d%02d%02d%02d%02d%02d` | 年月日时分秒 | `…/Setting.java:248-253` |
| 恢复出厂 | — | `reset.cgi?`，**socket 直发不等响应** | — | `…/Setting.java:291-293,375-398` |
| 删除全部 | — | `deleteallfiles.cgi?` | — | `…/dv/biz/RemoteFileManager.java:54` |
| 格式化 | — | `sdcommand.cgi?-format&-partition=1` | `partition` 固定 `1` | `…/RemoteFileManager.java:58` |
| 改 WiFi | `getwifi.cgi` | `/setwifi.cgi?&-wifissid=%s&-wifikey=%s`（**socket 直发不等响应，且路径前缀是 `Common.ICGI_PATH="/cgi-bin"` 不是 `/cgi-bin/hi3510`**） | — | `…/Setting.java:296,375-398` |
| 清缓存 | — | 本地，无报文 | — | `Common.java` key `clear_cache` |

**A 路径的判据**：`get*` 一律 `doForMap`/`doForIntByKey`/`doForBoolean`（要求 200 **且**解析出 ≥1 KV；`doForIntByKey` 把任何负数折成 `-1`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:109-140`）；`set*` 一律 `doForSuccess`（只看 200）。

---

## 7. 回放

回放有**两套完全不同的东西**，别混：

| 套 | 界面 | 数据源 | 命令 |
|---|---|---|---|
| **相机侧回放（B/C）** | `SSPlaybackNewActivity` / `Hisi_CameraRecordFragment` / `Hisi_CameraPicFragment` | 相机 SD 卡 | `getfilecount`/`getfiletypecount` + `getfilelistinfoios`/`getfilelist` + `deletefile` |
| **手机本地相册** | `FragmentNewNormalAlbum` / `FragmentFavorites` | 手机已下载文件（MediaStore + 扫盘） | **无网络报文**，靠文件名正则分组 |

### 7.1 计数

| 套 | 报文 | 读键 | 出处 |
|---|---|---|---|
| B（SigmaStar 语义） | `GET /cgi-bin/hi3510/getfiletypecount.cgi` | `imagecount`（Photo/`type=0`）、`videocount`（Video/Normal）、`eventcount`（`Emr`）；解析失败一律返回 `0` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:22,57-59`；`…/data/SSResponseParse.java:68-115` |
| B（海思语义） | `GET /cgi-bin/hi3510/getfilecount.cgi` | `count`（`StringParser.getKeyValueMap` 后 parseInt；`0` 则直接 `loadDataFinish()`） | `…/HaisiCommandUtil.java:23,75-77`；`…/OldUi/playback/model/HisiPlaybackModel.java:83-96` |
| C | `GET /cgi-bin/hi3510/getfilecount.cgi`（`HisiApiUtils.isHisi()==true`）或 `/cgi-bin/hi3510/getfiletypecount.cgi`（false） | 前者读 `count`，后者读 `videocount`（视频页）/ `imagecount`（照片页）；正则 `getVarValue` = `<key>="(.*?)"` | `…/com/gku/hisi/Hisi_CameraRecordFragment.java:322-335`；`…/Hisi_CameraPicFragment.java:322-335`；`_work/xtu_src/sources/com/gku/module_base_xtugo/HisiApiUtils.java:29-39` |
| A | `GET http://<ip>/cgi-bin/hi3510/getfilecount.cgi?` → `doForIntByKey(...,"count")` | `count`，负数折成 `-1` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/RemoteFileManager.java:12-17` |

> **C 套的 `isHisi()` 判定要抄准**：`!("Hi3518EV300".equals(device_name) || "SSC8838".equals(device_type) || "SSC8826".equals(device_type))`。真机 S7PRO 的 `device_type=Hi3519DV500` → `isHisi()==true` → 用 `getfilecount.cgi` + `getfilelistinfoios.cgi`。注意它比的是 **`device_name`（型号名）等于芯片串**，不是 type，这条判断本身可疑（见 §12）。

### 7.2 列表翻页（分页窗口 = 50）

| 步 | 报文 | 精确值 | 出处 |
|---|---|---|---|
| 1 | `GET BASE + "getfilelistinfoios.cgi?&-start=%d&-end=%d"` | `start = curIndex`（初始 `0`）；`end = (start + 50 > count) ? count : start + 50` | `…/HisiPlaybackModel.java:281`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/RemoteFileManager.java:20` |
| 1' | B 套 SigmaStar：`GET /cgi-bin/hi3510/getfilelist.cgi?-start=<s>&-end=<e>&-type=<Photo\|Video>` | `type` 由 int 映射：`0→"Photo"`，非 0 →`"Video"`；也可传字符串 `type` | `…/SSCommandUtil.java:65-71`；`…/SigmastartPlaybackModel.java:219` |
| 1'' | C 套：`GET /cgi-bin/hi3510/getfilelistinfoios.cgi` + query `-start=<page_start>`、`-end=<page_start+PAGE_SIZE-1>`；**非海思时**改用 `getfilelist.cgi` 并额外 `&-type=Video`（照片页 `Photo`） | `PAGE_SIZE = 50`；非海思时每页重算 `PAGE_SIZE = min(countTotal - 已取数, 50)` | `…/Hisi_CameraRecordFragment.java:56,356-363`；`…/Hisi_CameraPicFragment.java:56,356-363` |
| 2 | 递归翻页 | **B 套：本页返回条数 `>= 50` 就 `curIndex += 条数` 后继续请求下一页，直到 `< 50`** → 首屏是「一次性把所有页拉完」而不是懒加载 | `…/HisiPlaybackModel.java:281-305` |
| 2' | C 套递归 | `page_start + PAGE_SIZE >= countTotal` 停止；否则 `loadList(countTotal, mode=2, page_start + PAGE_SIZE, listAll)`（`mode==2` 表示追加，不清 `listAll`） | `…/Hisi_CameraRecordFragment.java:383-405` |
| 3 | 过滤 | `getfilelistinfoios` 返回 **JSON 数组**，每项键：`path`、`create`、`time`、`size`（`StringParser.getMediaList`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/StringParser.java:41-53`）；B 套 `parseGetFileListAndInfo(response, type)` 按 `type ∈ {"Normal","Video","Event","Photo"}` 用扩展名过滤：视频收 `.mp4`（还会同时认 `.LRV`），照片收 `.jpg`/`.dng`（`SSConstant.SSFileFormat = {mp4, jpg, dng}`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:15-19`） | `…/SSResponseParse.java:132-173` |
| 3' | `create` 字段归一 | 若**第一条**的 `create` 含 `-`，则所有条目的 `create` 做 `replace("-","/")` | `…/SSResponseParse.java:141-143,158-160` |
| 4 | A 套另一路 | `getfilelist.cgi?&-start=%d&-end=%d` → 按 `;` split，只留后缀 `mp4/lrv/dng/png/jpg` | `…/RemoteFileManager.java:27-41` |

### 7.3 按日期分组

| 套 | 分组键 | 实现 | 出处 |
|---|---|---|---|
| 本地相册（`newUi/album`） | 文件名里的时间戳 | `Pattern.compile("(\\d{8}[_-]\\d{6})")` 提取 → `SJCamTools.formatDateForYMD(createTime)` 作为 section 标题；排序 `o1.getCreateTime() - o2.getCreateTime()` 降序 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/album/Ui/Fragment/CommonFragment.java:407-409`；`…/Ui/Adapter/SubNewAdapter.java:55`；`…/FragmentNewNormalAlbum.java:255,268-272` |
| 相机侧（B 套） | 服务端 `create` 字段 | section 适配器同上（`SectionNewAdapter.sectionHeaderLayoutId() = R.layout.view_newitem_header`，标题 id `R.id.header_new`） | `…/Ui/Adapter/SubNewAdapter.java:39-45` |
| 目录枚举 | `GET BASE + "getdirname.cgi"` → 读 `value`，按 `,` 切成 `String[]` | **只有 `SSCommandUtil.getDirname()` 与 `SSResponseParse.parseDirname()` 定义了它，全仓找不到调用点 → 死命令**（见 §12） | `…/SSCommandUtil.java:21,61-63`；`…/SSResponseParse.java:54-66` |

### 7.4 缩略图（**不存在 `getthumbnail.cgi`**）

| 机型 `type` | 缩略图 URL | 回放/播放 URL（小码流） | 出处 |
|---|---|---|---|
| `SSC8838`/`SSC8826`/`SSC8838C` | `http://192.168.0.1/thumb<originPath>` | `http://192.168.0.1<originPath>`，`.MP4`→`-s.MP4`、`.mp4`→`-s.mp4` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:78-83,120-127,152-155` |
| `H75N`/`CV75` | 直接用 `originPath`（走命令口 1285 + 数据口 8787） | `http://192.168.0.1<originPath 去掉 "/tmp/SD0">`，扩展名换 `.LRV`；`fileSize < 256`（`IjkMediaMeta.AV_CH_WIDE_LEFT`）时把 `/tmp/SD0` 去掉 | `…/SSFileInfoBean.java:84-85,128-146,156-160` |
| 其余（含 **真机 `Hi3519DV500`**） | `http://192.168.0.1/<originPath>` 再把末 4 字符换成 `HiDefine.FILE_SUFFIX_THM = ".THM"` | `http://192.168.0.1/<originPath>`，`.MP4`/`.mp4` → `HiDefine.FILE_SUFIX_LRV = ".LRV"` | `…/SSFileInfoBean.java:86-94,147-151,161-165`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/HiDefine.java:30,32,33` |
| C 套 | — | 同上：`String.format("http://%s/%s", SS_IP, path).replace(".MP4", ".LRV").replace("mp4",".LRV")`（海思），非海思直接原路径 | `…/Hisi_CameraRecordFragment.java:191` |

下载/取缩略图的实现：`SSDownloadUtil.singleSyncDownload(thumbPath, savePath, cb)` → `SSHttpClientUtil.GET` + `SYNC`（OkHttp，同步线程池）。缩略图下载失败**静默**（B 套海思 `loadThumbRetry`/`startLoadThumb`/`stopLoadThumb` 三个方法是**空实现**）。
出处：`…/HisiPlaybackModel.java:150-190`、`:60-75`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:47-60`。

### 7.5 下载（原片/小码流）与「续传」方式

| 步 | 动作 | 精确内容 | 出处 |
|---|---|---|---|
| 1 | 选码流弹窗 | `showVideoQualityDialog(ArrayList<SSFileInfoBean>)`，仅当 `playback.getType() ∈ {"Video","Normal","Emr"}` 时弹；`"Photo"` 走另一支 | `…/SSPlaybackNewPresenter.java:896-948,976-978` |
| 2 | 提示文案 | `String.format(R.string.downloadToLocal_hint, <目标目录>)`：默认「Don't turn off the screen manually during the download process… The downloaded files will be automatically saved to the album and saved in the %1$s directory」／中文「下载过程中不要手动熄屏不要远离相机，不然下载可能会断开，下载的文件会自动保存到相册，文件保存在 %1$s 目录下」；目录三选一：`G.localDCIMActionCamPhotoDataPath`（无 time 字段时）/`G.localDCIMActionCamSDVideoDataPath`（`isDownloadNormalVideo`）/`G.localDCIMActionCamVideoDataPath` | `…/SSPlaybackNewPresenter.java:254-259` |
| 3 | 单文件 HTTP 下载 | OkHttp `GET <remotePath>`（§7.4 表），流式写盘；**先写 `savePath + ".MP4"` 临时文件**（`HiDefine.FILE_SUFIX_MP4`），若已存在先 `delete()`；边写边算 `file.length()/contentLength*100`，**节流 300ms** 才回调一次进度（`now-last>300 \|\| file.length()==contentLength`）；收尾 `new File(savePath).delete()` 后 `renameTo` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSHttpClientUtil.java:138-195` |
| 4 | **续传方式** | **没有 HTTP `Range` / `Content-Range` 请求头，全仓 `SSHttpClientUtil`/`DownLoadFileUtils`/`SSDownloadUtil` 零命中**。真正的「断点」实现只有两条：① 上一步的 `.MP4` 临时文件 + rename（**失败即 `file.delete()`，等于不续传**）；② **8080 二进制口**：`DownLoadFileUtils.createConnection(cServerPath, savePath)` 先 `cServerPath.replace("http://192.168.0.1/","")` 得到相对路径，连 `192.168.0.1:8080`，发 72 字节头（`CMD=0` + 路径长度 + 64 字节 UTF-8 路径，`ByteBuffer.order(LITTLE_ENDIAN)`），`setReceiveBufferSize(1048576)`，然后读 4+4+64 字节应答（`bytesToInt` 小端；负数长度做 `((i>>>1)<<1)\|1` 修正）→ 再读裸字节 | `…/sigmastar/data/connect/DownLoadFileUtils.java:31-32,55-70,170-208,214-219` |
| 5 | 8080 口批量下载（C 套） | `HisiDownloader.PORT = 8080`，走 `SocketHisiFile.getInstance()`：`putInt(0)`（cmd=0）→ `putInt(bytes.length)` → 64B 路径；进度按 `last_percent + 1` 才回调；取消 `SocketHisiFile.getInstance().stop()` | `_work/xtu_src/sources/com/gku/module_camera/hisi/HisiDownloader.java:75,134-145`；`…/SocketHisiFile.java:112-165` |
| 6 | Ambarella 下载 | 命令口 `msg_id=1285` `{param:<path>,offset:0,fetch_size:0}` → 响应给 `path`+`size`；再连 8787 读 `size` 字节；65536 缓冲、`available()==0` 睡 100ms、连续 30 次（3s）无数据判失败、进度每 +1% 回调 | 附录 B §下载；`_work/xtu_src/sources/com/gku/actioncam/amba/socket/DataChannel.java:146-239` |
| 7 | 完成 | `downloadFinish(savePath)` → 队列里下一条；全部完成 `allTaskFinish()`；空间不足回调 `notEnoughSpace()` | `…/SSHttpClientUtil.java:33-51`；`…/SSDownloadUtil.java:71-155` |

### 7.6 删除 / 批量删除 / 格式化 SD

| 动作 | 报文（逐字） | 判据 | 失败提示 | 出处 |
|---|---|---|---|---|
| 删单个（B 套 SigmaStar） | `GET /cgi-bin/hi3510/deletefile.cgi?-name=<originPath>` | HTTP 层 `delFileSuccess` | `delFileError` → 上层 Toast | `…/SSCommandUtil.java:77-79`；`…/SigmastartPlaybackModel.java:155,170,187` |
| 删单个（B 套海思） | 同上（`HaisiCommandUtil.deleteFile`） | `HttpRequestUtils.doRequest` 成功回调 | — | `…/HaisiCommandUtil.java:87-89`；`…/HisiPlaybackModel.java:203,235` |
| 删单个（C 套，逐个递归、**倒序** `i = size-1 → 0`） | `GET /cgi-bin/hi3510/deletefile.cgi` + query `-name=<path>` | **body `trim()` 必须 `equals("Success")`**（`SSResponseParse.SS_SUCCESS`）；否则 `onFailOne(CODE_ERROR_HISI_NOT_SUCCESS)` | `R.string.delete_fail` + `":" + i2`；默认 `Deletion failed.`／中文「删除失败」 | `_work/xtu_src/sources/com/gku/module_camera/hisi/dialog/DialogHisiSDMediaDelete.java:90-125` |
| 批量删（B 套） | `for (Integer num : fileMap.keySet())` 逐个发 `deletefile.cgi?-name=…`（**无序、并发**） | 每条目独立回调 | — | `…/HisiPlaybackModel.java:230-247` |
| 全删（A 套） | `GET http://<ip>/cgi-bin/hi3510/deleteallfiles.cgi?` | `doForSuccess` → **只看 200** | — | `…/RemoteFileManager.java:53-55` |
| 删除进度 UI | `DlgForDeleteProcessActivity`：标题 `R.string.deletefile_tip`（`Delete File`/「删除文件」），正文 `String.format(R.string.deletefile_msg2, 序号, 总数)`（`Deleteing The %1$d/%2$d Files…`/「当前第%1$d/%2$d个文件正在删除…」） | — | 完成 Toast `R.string.deletefile_success`（`Delete File Success`/「删除文件成功」） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/dlg/DlgForDeleteProcessActivity.java:83,193`；`…/filebrowser/PreviewImageActivity.java:908,975` |
| 格式化 | `GET BASE + "sdcommand.cgi?-format&-partition=1"`（**`partition` 恒为 `1`，且 `-format` 是无值的裸标志位**） | B/C 套：`doForSuccess`（只看 200）→ `handler.sendEmptyMessage(0/1)`；A 套 `RemoteFileManager.formatSdCard()` 用 `doForMap`（要求解析出 ≥1 KV） | 成功 Toast `R.string.format_sd_success`（`Format Success`/「格式化成功」）；失败 Toast `R.string.format_sd_failure`（`Format Failed`/「格式化失败」）；确认框正文 `R.string.format_tip`（`Are You Sure To Format SD Card?`/「确定要格式化SD卡?」） | `…/SSCommandUtil.java:129-131`；`…/HaisiCommandUtil.java:148-150`；`…/HttpProxy.java:280-288`；`…/RemoteFileManager.java:57-59`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUIUtils.java:53-77,413-425` |
| 空列表提示 | — | — | `R.string.device_no_video`（`Your device has no videos.`/「您的设备没有视频」）；异常码后缀 `\n-1013` | `…/Hisi_CameraRecordFragment.java:333-339` |
| 加载失败 | — | `onFail(code, msg)` | `R.string.loding_fail_lick_try`（`Failed to load\nCheck network\nTap to retry.`/「加载失败\n检查网络\n点击重试」）+ `\n<code>` | `…/Hisi_CameraRecordFragment.java:343-346` |

---

## 8. WiFi 名称/密码、对时、恢复出厂、重启

### 8.1 改 WiFi 名 / 密码

| 套 | 步 | 报文（逐字） | 判据 | 失败提示 | 出处 |
|---|---|---|---|---|---|
| B/C（NewAPP 动态菜单） | 1 读 | `GET BASE + "getwifi.cgi"`（含空格会 `Uri.encode`，但 `…/SetDataUtils.java:320-322` 的 `replaceAll` 返回值被丢弃＝无效） | `statusCode==200`；解析键 `wifissid`、`wifikey`（`SSResponseParse.parseGetWiFi` → `new SSWiFiInfo(map.get("wifissid"), map.get("wifikey"))`） | 非 200 只写日志 | `…/SetDataUtils.java:318-330`；`…/SSResponseParse.java:467-485` |
| | 2 弹窗 | `postDelayed(500L)` 后弹 `R.layout.dialog_modify_wifi`：`etSSID`（去前缀后的名）、`etPassword`、`btnDialogApply`、`btnDialogCancel` | — | — | `…/SetDataUIUtils.java:293-315,361-384` |
| | 3 长度校验 | 新名长度 **必须等于**原长度、新密码长度 **必须等于**原长度，否则不发送 | `editText.length() == SSID_TITLE_Length` | Toast：`R.string.wifi_ssid_tips_1 + <原长度> + R.string.wifi_ssid_tips_2`（`Wi-Fi name must be ` + N + ` bits long`／中文「WIFI名长度必须为」+N+「位」）；密码同理 `wifi_psd_tips_1`/`wifi_psd_tips_2`（`PassWord name must be ` + N + ` bits long`／「WIFI密码长度必须为」+N+「位」） | `…/SetDataUIUtils.java:382-392` |
| | 4 写（系统项） | `GET BASE + "setcurparameter.cgi?-workmode=System&-name=<项名>&-value=<值>"`（名与值各自 `Uri.encode(x,"utf-8")`）；`doForSuccess` → **只看 200** | 200 | `handler.sendEmptyMessage(1)` → **无 Toast**（`isFormatSd==false`） | `…/HttpProxy.java:258-272`；`…/SetDataUIUtils.java:270-287` |
| | 4' 另一条写（走 `DV`） | `GET BASE + "setwifi.cgi?&-wifissid=<ssid>&-wifikey=<key>"`（`SSCommandUtil.setWiFi`/`HaisiCommandUtil.setWiFi`，注意 `?` 后紧跟 `&`） | 200 | — | `…/SSCommandUtil.java:125-127`；`…/HaisiCommandUtil.java:144-146`；`…/OldUi/setting/model/HaisiSettingModel.java:42`、`…/SigmastartSettingModel.java:43` |
| A（老海思） | 写 | `DV.setWifiSsidPassword(ssid,pwd)` → `Setting.setWifi(ip,ssid,password)` → **`setSocketNoReply("/setwifi.cgi?&-wifissid=<ssid>&-wifikey=<pwd>", ip)`**：`new Socket(ip, 80)`、`setSoTimeout(6000)`，手写 `GET /cgi-bin/hi3510/setwifi.cgi?&-wifissid=…&-wifikey=… HTTP/1.1\r\nHost:<ip>\r\nConnection: Keep-Alive\r\nUser-Agent: HiCamera\r\n\r\n`，**写完即 close，完全不读响应** | **无判据**（socket 发出去就算完） | 无 | `…/dv/biz/DV.java:647-649`；`…/dv/biz/Setting.java:295-307,375-398` |
| A | 入口 | `Common.KEY_MODIFY_DV_NAME` → intent → `ModifyWifiActivity`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/ModifyWifiActivity.java:36` 调 `setWifiSsidPassword`） | — | — | 主文档 §4.3 |
| | 手机侧热点模式切换 | STA：`GET http://<ip>/cgi-bin/setwifista.cgi?&-ssid=<ssid>&-key=<pwd>`（**前缀 `/cgi-bin`，不是 `/cgi-bin/hi3510`**）；AP：`GET http://<ip>/cgi-bin/setwifista.cgi?`（**同一路径、零参数**） | `doForSuccess` → 200 | 无 | `…/Setting.java:308-327`；调用点 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/weight/HiWifiScrollView.java:147` |
| | 休眠 WiFi | `GET http://<ip>/cgi-bin/hi3510/wifisleep.cgi?` | `doForSuccess` | 无 | `…/Setting.java:463-465` |

### 8.2 对时

| 套 | 报文 | 值来源 | 判据 | 提示 | 出处 |
|---|---|---|---|---|---|
| B/C | `GET BASE + "setsystime.cgi?-time=yyyyMMddHHmmss"` | `new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())`（**手机本地时间，无时区偏移**） | body `trim().equals("Success")` | 成功 Toast `R.string.ss_set_system_time`（`The phone time has been synced to the device`／「已同步手机时间到设备」） | `…/SSCommandUtil.java:137-139`；`…/SigmastartPreviewModel.java:160`；`…/HaisiPreviewModel.java:221-232`；`…/ActionCameraPreviewPresenter.java:690-695` |
| B（无值型系统项） | `GET BASE + "setsystime.cgi?-time=" + <同上>`（`setDevicePamarsStrNoValue(1)`） | 同上 | `doForSuccess` → 200 | 成功 `handler.sendEmptyMessage(3)` → Toast `R.string.synec_time`（`Synchronize mobile phone time to camera`／「已同步手机时间到相机」）；确认框 `R.string.set_datetime`（`Set Phone Time to Camera`／「将手机时间同步到相机」） | `…/HttpProxy.java:274-288`；`…/SetDataUIUtils.java:68-72,409-425,441-458` |
| A | `GET http://<ip>/cgi-bin/hi3510/setsystime.cgi?&-time=%04d%02d%02d%02d%02d%02d` | `GregorianCalendar`：年、月+1、日、时、分、秒 | `doForSuccess` | 无 | `…/Setting.java:248-253` |
| Ambarella | 走 `setcurparameter` 风格，项名 `"Time Zone"`，值 = `String.format("%+d", rawOffset/3600000)` | 时区偏移小时数，带 `+`/`-` | — | — | `_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:307,310-312` |
| **自动触发** | 连上相机进预览页时 `requestPreviewParams()` 的第 4 步就是 `setSystemTime()` —— **每次进预览都会无条件对时一次** | — | — | — | `…/HaisiPreviewModel.java:62-68` |
| 「Auto Sync Time」 | 项名硬编码：值**不读设备**，来自本地 SP（`SPUtils.getInstance().getData(ctx)`），`true→"ON"`、`false→"OFF"`；开关 type=3 | 本地 | — | — | `…/SetDataUtils.java:128-133` |

### 8.3 恢复出厂

| 套 | 报文 | 判据 | 提示 | 出处 |
|---|---|---|---|---|
| B/C | `GET BASE + "reset.cgi"`（`setDevicePamarsStrNoValue(2)`，**无参数**）；另一实现 `SSCommandUtil.reset()`/`HaisiCommandUtil.reset()` = `"/cgi-bin/hi3510/reset.cgi"` 同串 | `doForSuccess` → **只看 200** | 确认框 `R.string.restore_tip`（`Factory Reset?`／「确定恢复出厂设置?」），按钮 `R.string.ok`（`OK`/「确定」）+ `R.string.cancel`（`Cancel`/「取消」） | `…/HttpProxy.java:274-288`；`…/SSCommandUtil.java:133-135`；`…/HaisiCommandUtil.java:152-154`；`…/SetDataUIUtils.java:323-325,413-415` |
| B/C（另一入口） | `GET BASE + "reset.cgi"`；**只有非 200 才提示** | `statusCode != 200` | Toast `R.string.reset_fail` —— **默认英文 `Reset Fail`，中文却写「重启失败」** | `…/SetDataUtils.java:191-195` |
| A | `Setting.restoreFactorySettings(ip)` → **`setSocketNoReply("/reset.cgi?", ip)`**：socket 直发、不等响应 | 无判据 | 无 | `…/Setting.java:291-293` |
| SigmaStar/Hisi 设置页 | `SigmastartSettingModel.reset()` / `HaisiSettingModel.reset()` → 同上 | 200 | — | `…/SigmastartSettingModel.java:73`；`…/HaisiSettingModel.java:74` |

> **语义冲突（要标注）**：同一条 `reset.cgi` 在英文资源里叫 `Reset Fail`（含糊）、中文资源里叫「重启失败」、而 UI 入口项名是 `"Factory Reset"`、确认框是「确定恢复出厂设置?」。**代码里没有任何 `reboot.cgi`/`restart.cgi`**（全仓 `own-literals.tsv` 零命中，见 §8.4），因此「reset.cgi 到底是恢复出厂还是重启」静态定不下来，需真机抓包/对照（§12）。

### 8.4 重启 / 关机：**没有对应命令**

穷尽检索结论：

| 检索面 | 结果 |
|---|---|
| CGI 串（`own-literals.tsv` 22620 条 + `catalog-http.md` 405 条） | 无 `reboot.cgi`、无 `restart.cgi`、无 `poweroff.cgi`、无 `shutdown.cgi`。最接近的是 `getautoshutdown.cgi`/`setautoshutdown.cgi?&-time=%d`（**自动关机时长**，非立即关机，`…/Setting.java:330,334`）、`wifisleep.cgi?`（`…/Setting.java:463-465`）、`setscreenautosleep.cgi?&-time=%d`（`…/Setting.java:342`） |
| 预览页电源位 UI | 布局 `main_frag_port.xml` / `main_frag_land.xml` 里有 `@+id/ivPower`（`R.java:16099` = `0x7f0a0316`）与 `@+id/viewCoverOnPowerOff`（`R.java:16830` = `0x7f0a0800+0x…`）。**全仓除 `R.java` 常量与 databinding 生成类外，无任何 `findViewById`/`setOnClickListener` 引用 → 死控件** |
| 动态系统菜单 | 靠 `getprimarymenuitem.cgi?-workmode=System` 自描述；若固件在 `item` 里回了 `Reboot`/`Power Off`，App 会照抄显示，且因为 `cur` 为空被判为 type=1（纯点击）→ 走 `setcurparameter.cgi?-workmode=System&-name=<项>&-value=`（空值）。**App 侧不存在这种硬编码，故静态不可证** |
| Ambarella | 只有常量、**无发送方**：`1537 WIFI_RESTART`、`1540 WIFI_STOP`、`1541 WIFI_START`、`1542 WIFI_STATUS`、`12 AMBA_POWER_MANAGE`、`259 AMBA_RESETVF`、`1793 AMBA_QUERY_SESSION_HOLDER`（`_work/xtu_src/sources/com/gku/actioncam/amba/model/AmbaCmdModel.java:85-86,90,94,98,118-120`；对照 `附录 B` §命令表：「仅常量，无发送方」） |
| 唯一能「重启/唤醒」的实操 | ① `reset.cgi`（见 §8.3 的语义冲突）② **Wake-on-LAN 唤醒**：`Setting.wakeupDevice(ip, mac)` 手搓 102 字节 magic packet（`6×0xFF` + `MAC×16`）UDP **端口 9** 发到 `<ip 前三段>.255`，**连发 5 次**；门控 `DV.supportWakeSleep()` = `capability` 含 `"standby"` 或 `deviceAttr.type == "117"`（`Common.SENSOR_117`） | 
| WoL 的 MAC 从哪来 | `Setting.macAddres2ByteArray(mac)`：要求长度 `17` 且含 `:`，按 `:` 切 6 段 16 进制转 byte；非法返回 `null` → `wakeupDevice` 直接 return；`…/Setting.java:467-481,483-512`；`…/dv/biz/DV.java:736-742` |

### 8.5 关于相机（版本回读）

| 项 | 值 | 出处 |
|---|---|---|
| 入口 | 系统页 `Information` 项 → `startActivity(AboutCameraActivity)`；老方言 `about_camera`（action `android.intent.action.tipactivity.aboutcamera`） | `…/SetDataUIUtils.java:330-332`；主文档 §4.3 |
| 报文 | `GET BASE + "getdeviceattr.cgi"`（B/C）或 `GET http://<ip>/cgi-bin/hi3510/getdeviceattr.cgi`（A，`doForMap`） | `…/SSCommandUtil.java:53-55`；`…/Setting.java:245` |
| 读键 | `name`、`type`、`softversion`、`hardversion`、`serialnum`、`pcbrevision`、`region`、`networkstatus`、`bluetoothrxversion`、`bluetoothtxoneversion`、`bluetoothtxtwoversion`、`startdate`、`runtimes`、`model`、`timeout` | `…/dv/net/HttpRequest.java:107-183` |
| 另有 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/ui/activity/SSCameraAboutActivity.java:207` 用字面量 `"/cgi-bin/hi3510/getdeviceattr.cgi"` | `…/catalog-http.md:133` |

---

## 9. 固件升级与 App 自身更新

### 9.1 检查更新（云端）

两条实现，**URL 不一致**（真实冲突）：

| 实现 | 请求 | 参数 | 出处 |
|---|---|---|---|
| Retrofit（主用，`DeviceVersionManager`） | `GET https://server4.gkuvision.com/v1/push/api/getNewestVersion` | query：`firm_ware_model`（**下划线**）、`region`、`hardware_version` | `_work/xtu_src/sources/com/gku/loginmodule/api/ApiService.java:45-46`；base 与超时：`…/loginmodule/network/NetworkApi.java:40-46`（`type==6` 才设 base）、`:50-53`（`connectTimeout=6s`，拦截器 `RequestInterceptor`/`ResponseInterceptor`/`AuthInterceptor`/`TokenInterceptor`） |
| OkHttp 直拼（`UpgradePresenter`，SigmaStar 升级页） | `GET https://server4.gkuvision.com/push/api/getNewestVersion?firmWareModel=<型号去空格>` | query：`firmWareModel`（**驼峰**）；`mModelName.replaceAll(" ","")`；`dns=TimeoutDns(3000)`、`connectTimeout=readTimeout=writeTimeout=5s` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/upgrade/firm/Presenter/UpgradePresenter.java:165-169` |
| 老 HTTP 服务器（`UpgradeManager`） | `GET http://121.40.107.215:8041/firmware/info.json` | 无；200 才返回 body，否则 `null` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/updateapp/UpgradeManager.java:842-848`；`SERVER_BASE_URL = "http://121.40.107.215:8041/firmware/"`（`:35`） |

**比对逻辑**：
- 版本串归一：`getLocalVersionInfo(v)` 用正则从 `version` 提数字段；`getRemoteVersionInfo(v)` 按分隔符 split 取 `[1]`（`_work/xtu_src/sources/com/gku/loginmodule/manage/DeviceVersionManager.java:686-707`）。
- 判新：`localVersionInfo.compareTo(getLocalVersionInfo(version)) < 0` 且 `file_url.length() != 0` → 记 `newVersion` + `downloadUrl`（`…/DeviceVersionManager.java:347-354`）。
- 本地缓存键：`getMapKey(DeviceVersionInfo)` / `getServiceKey(...)`（`:218-230`、`:265-266` 用 `hardware_version`）。
- 落盘目录：`getCacheDir()/version/<region>/<hardware>/<model>/<version>/<url 末段文件名>`（`…/DeviceVersionManager.java:644-661`）。
- 机型名解析：固件文件名末段按 `_` 切、再按 `.` 切取版本号，`\d{8}` 提日期（`…/upgrade/firm/Presenter/UpgradePresenter.java:150-156`）。
- 触发时机：`HomeActivity` 建 `DeviceVersionManager.INSTANCE.getInstance().checkDeviceVersion(true)`（`_work/xtu_src/sources/com/gku/HomeActivity.java:597`）；红点回调 `onNeedUpdateMsg(needUpdate)` → `layoutRed.setVisibility(0/8)`（`…/HomeActivity.java:1130-1137`）。

### 9.2 检查更新（本地）

| 步 | 动作 | 出处 |
|---|---|---|
| 1 | 本地固件目录扫描：`getUpgradePath(ctx) = Utility.getLocalAppDataPath(ctx).getAbsolutePath() + "/upgrade/"`（不存在则 `mkdirs()`） | `…/updateapp/UpgradeManager.java:86-93` |
| 2 | 选包规则：`softVersion.startsWith("HiCam")` → `getLocalFirmwareByChip(ctx, softVersion.substring(5,9))`（取 4 位芯片号）；否则 `name.startsWith(HiDefine.DV_NETWORK_PREFIX2)` → `getLocalFirmwareByPrefix(ctx, deviceAttr.name + "_")`；否则 `getLocalAllFirmware(ctx)`；结果 `Arrays.sort()` | `…/UpgradeManager.java:117-128` |
| 3 | 用户挑包后判存：`exists(ctx, filename)` | `…/UpgradeManager.java:95-97`；`…/dv/updateapp/DownloadActivity.java:184`（扩展名判 `.sw`） |

### 9.3 下载

| 实现 | 手法 | 细节 | 出处 |
|---|---|---|---|
| `UpgradeManager.download(ctx, filename)` | **系统 `DownloadManager`** | `Uri = SERVER_BASE_URL + filename`；目标 `getUpgradePath+filename`，已存在先 `delete()`；进度 `getDownloadProgress(ctx, downloadId)` 用 `ContentResolver.query(CONTENT_ALL_URLS)` 取 `COLUMN_BYTES_DOWNLOADED_SO_FAR`/`COLUMN_TOTAL_SIZE_BYTES`；取消 `remove(downloadId)` | `…/UpgradeManager.java:869-880,886-919,918-920` |
| `DeviceVersionManager.startDownload(url, model)` | xUtils | `x.http().get(RequestParams(url))` + `Callback.ProgressCallback<File>`，可 `cancelable`；并发 `maxConcurrent` | `…/loginmodule/manage/DeviceVersionManager.java:427-460` |
| `UpgradePresenter.download(url)` | `DownloadUtil.get().download(url, getlocalAppDataPath()+"/"+mModelName, listener)` | OkHttp 流式写盘，文件名 `url.substring(lastIndexOf("/")+1)`；下载中持 `PowerManager.WakeLock(SCREEN_BRIGHT_WAKE_LOCK\|ACQUIRE_CAUSES_WAKEUP\|ON_AFTER_RELEASE = 268435466)`，成功后 500ms 释放 | `…/upgrade/firm/Presenter/UpgradePresenter.java:300-322`；`…/upgrade/firm/Utils/DownloadUtil.java:40-63,163-165` |

**下载阶段提示**（`UpgradePresenter` 的 Handler `what` → Toast）：

| 场景 | 资源 ID | 中文 | 出处 |
|---|---|---|---|
| 取消 | `R.string.download_cancel` | 已取消下载 | `…/UpgradePresenter.java:93` |
| 成功 | `R.string.DownloadSuccessfully` | 下载成功 | `:96` |
| 需先连相机再切网下载 | `R.string.ConnectCameraThenConnectAvailableInternet` | 请先连接相机，然后断开相机连接可用网络去下载固件更新 | `:100` |
| 无可用网络 | `R.string.wifi_toast` | 请连接Internet可用网络，否则无法下载固件！ | `:104` |
| 已最新 | `R.string.CurrentIsLatest` | 当前固件已是最新固件 | `:107` |
| 无网络下载 | `R.string.PleaseAvailableInternet` | 请连接可用网络下载固件 | `:110` |
| 未连相机 | `R.string.PleaseConnectCameraWifi` | 请先去连接相机WIFI后更新固件 | `:113` |
| 取服务器信息失败 | `R.string.get_server_info_fail_check_network` | 获取服务器信息失败，请检测网络连接 | `:117` |
| 取版本异常 | `R.string.getver_failure` | 获取版本失败. | `:246` |

### 9.4 推送到相机（三种实现，同一条 8080 口）

**（a）`com.hisi.hisiFW.FwUpload`（老，`SendSoftActivity` 之外的路径）**

| 步 | 报文/动作 | 精确值 | 出处 |
|---|---|---|---|
| 1 | `new FwInfo(ctx, assetsFile)` | 计算 `md5`（`MessageDigest.getInstance("MD5")` → `new BigInteger(1, digest).toString(16)`，**会丢前导零，长度不固定**）、`size`、`name` | `_work/xtu_src/sources/com/hisi/hisiFW/FwInfo.java:24-57` |
| 2 | `socket.connect(new InetSocketAddress("192.168.0.1", 8080), 5000)` | `HOST="192.168.0.1"`、`PORT=8080`、`TIME_OUT=5000` | `…/FwUpload.java:15-17,43-53` |
| 3 | 写 200 字节头 | `new RegisterDeviceToServer(2, size, name, md5).getBuf()`：`[0..3]` LE int `cmd_type=2`、`[4..7]` LE int `length`、`[8..71]` 64B 文件名、`[72..199]` 128B MD5 | `…/RegisterDeviceToServer.java:12-38`；`toLH()` `:40-46` |
| 4 | 读 ≤256B 准备应答 | `read(bArr)` 返回 `<=0` → `IllegalStateException("固件>>>读准备状态失败")`；空串 → `"固件>>>解析准备信息失败"` | `…/FwUpload.java:57-96` |
| 5 | 校验应答前缀 | `strTrim.startsWith(fwInfo.getName())` 才继续上传 | `…/FwUpload.java:99-101` |
| 6 | 裸字节流上传 | `byte[5120]` 分块 `outputStream.write`；进度 `已发/available` 浮点回调 `progressBack.progress(f)`；完成 `finish()` | `…/FwUpload.java:102-141` |
| 7 | 收尾 | `shutdownInput()`/`shutdownOutput()`/`finishCall(exception)` | `…/FwUpload.java:60-77,116-160` |

**（b）`FirmwareClientThread`（海思 NewAPP 侧）**：`socket.connect(new InetSocketAddress("192.168.0.1", 8080), 10000)`（**10s**）、`setSendBufferSize(CacheDataSink.DEFAULT_BUFFER_SIZE)`；先起 `getMessage()` 线程轮读 256B，直到 `new String(bArr,"utf-8").trim().startsWith(file.getName())` 才 `sendFile()`；头由 `revHandler` 发 `RegisterDeviceToServer(2, FileLength, file.getName(), getFileMD5(file))`（**同一个 cmd=2**）；数据 `byte[10240]` 循环写。
出处：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/FirmwareClientThread.java:28-130`。

**（c）`SendSoftActivity`（当前主用，`exported=false`，从 `HomeActivity` 拉起）**：

| 步 | 报文 | 精确值 | 失败码 | 出处 |
|---|---|---|---|---|
| 1 | `NetworkDeviceUtils.getNetworkDevice().getSocketFactory().createSocket(getIpDevice(), 8080)`，`setSoTimeout(5000)` | **走运行时网关 IP（不是写死的 192.168.0.1）**，且绑网络 | `-100001` | `_work/xtu_src/sources/com/gku/SendSoftActivity.java:108-109` |
| 2 | 写 72B 头 `TCP_MSG_S.toBytes()` | `ByteBuffer.allocate(72).order(nativeOrder())`；`putInt(s32Cmd = MSG_TYPE.RECV_FILE.ordinal() = 2)`、`putInt(s32DataLen = file.length())`、`put(szData[64])`，文件名 `getBytes(UTF_8)` 拷 `min(len, 63)` 字节 | — | `…/SendSoftActivity.java:110-118`；`_work/xtu_src/sources/com/gku/loginmodule/ui/activity/TCP_MSG_S.java:11-35`；`…/loginmodule/ui/activity/MSG_TYPE.java:4-10`（`GET_FILE=0,GET_FAILED=1,RECV_FILE=2,RECV_FAILED=3,RECV_RTMP=4`） |
| 3 | 读 72B 回包（**按 `i += read(bArr,i,72-i)` 补齐循环**） | 判 `tcp_msg_s2.s32Cmd == 2` | `-100006`（读异常）/`-100004`（cmd 不符） | `…/SendSoftActivity.java:120-129` |
| 4 | 写 MD5 串 | `outputStream.write(FileUtils.getFileMD5(file).getBytes(US_ASCII))` + flush | `-100009` | `…/SendSoftActivity.java:130-136` |
| 5 | 裸文件流 | `byte[65536]`；进度 `(已发/总长)*100`，**每 +1% 或到达末尾才刷 UI**；日志打印首 10 / 末 10 字节 hex | `-100007`（写异常）/`-100008`（FileInputStream 异常） | `…/SendSoftActivity.java:136-193` |
| 6 | 完成 | `outputStream.close()` → `closeSocket(0)` → `dealSuccess()`；UI 文案 `R.string.setting_updatefw_closeAppInfo`（`FW update has completed, please restart your application`／「固件更新已完成，请重新启动应用程序」） | — | `…/SendSoftActivity.java:195-203,242` |
| 7 | 失败统一提示 | `getString(R.string.send_soft_fail_hint, code, modelName)` → 默认 `Send failed: %d\nPlease check if connected to %s Wi-Fi and try again.`／中文「发送失败:%d\n检查是否连上%s的WIFI后重试」 | — | `…/SendSoftActivity.java:219-225` |
| 8 | 发送中提示 | `R.string.firm_sending + "\n" + percent + "%"`（`Firmware is being sent...\nPlease be as close as possible to the device…`／「固件正在发送中…\n请尽量靠近需要升级的设备，以确保升级成功」） | — | `…/SendSoftActivity.java:84,175` |

**（d）HTTP 上传（另一套，`UpgradeManager`/`UpgradeTaskManager` 手写 socket）**：

```
POST /cgi-bin/hi3510/fileupload.cgi HTTP/1.1
Charset: utf-8
connection: keep-alive
Content-Type: multipart/form-data;boundary=<UUID.randomUUID()>
User-Agent: <Build.MODEL>
Host: <DV.getIp()>
Accept-Encoding: gzip
Content-Length:<fileLen + len(partHead) + len(partTail)>

--<boundary>
name="sd"; filename="<file.getName()>"
<文件字节，1024 一块>
--<boundary>--
```
`new Socket(deviceIP, 80)`、`setSoTimeout(6000)`、`bCancelUpload` 可中断、进度 `onUploading(total, sent)`。
出处：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/updateapp/UpgradeManager.java:180-215`；孪生实现 `…/sigmastar/upgrade/app/UpgradeTaskManager.java:191`。

**（e）A 套 CGI 触发装机**：`GET http://<ip>/cgi-bin/hi3510/upgrade.cgi`（**无参数，`doForSuccess` 只看 200**）。
出处：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/RemoteFileManager.java:61-63`。

### 9.5 装机后版本回读

| 步 | 报文 | 判据 | 出处 |
|---|---|---|---|
| 1 | 相机重启后网络 `onLost` → `onAvailable`，走 §1.5 全流程 | — | `…/HomeActivity.java:558-596` |
| 2 | `GET BASE + "getdeviceattr.cgi"` → 读 `softversion`（含 `H`/`G` 且有 `.` 则截掉末段） | 解出 ≥1 KV | `…/dv/net/HttpRequest.java:98-117` |
| 3 | `CameraParameters.VersionNo = softversion` + SP `softVersion` | — | `…/HomeActivity.java:1743-1744,1766-1767` |
| 4 | 预览页 `loadCameraInfo(requestMethod)` → 再发一次 `getdeviceattr.cgi`，成功才回调 `loadCameraSuccess` | 200 | `…/HaisiPreviewModel.java:397-409` |
| 5 | 「关于」页展示 | `AboutCameraActivity` / `SSCameraAboutActivity` 用 `getPackageInfo().versionName`（App 版本）+ `getdeviceattr`（相机版本） | `…/dv/setting/AboutCameraActivity.java:118,140`；`…/SSCameraAboutActivity.java:336` |

### 9.6 App 自身更新

| 步 | 内容 | 出处 |
|---|---|---|
| 1 入口 | App 侧「设置」页 `res/xml/settingpreferences.xml` 的 `update_version`（`R.string.update_version` = `Camera System Update`／「相机系统更新」）；另有 `about_app`、`setting_user_agreement`、`setting_privacy` | 主文档 §4.3 |
| 2 列表 | `DownloadActivity` 拉 `http://121.40.107.215:8041/firmware/info.json` → `parseServerFileList()` 取每项的 `name` | `…/dv/updateapp/UpgradeManager.java:842-863`；`…/dv/updateapp/DownloadActivity.java:89` |
| 3 判新 | `serverHaveLatestAPK(ctx, serverApkName)`：取本机 `versionName` 的**后 8 位**当 `yyyyMMdd`（`versionName` 无 `-` 时取空串）与 `ApkInfo.getApkInfoFromName(name).buildDate` 比 `after()`；**任何异常 → `return true`（永远提示有新版）** | `…/UpgradeManager.java:99-113`；`…/updateapp/ApkInfo.java:15`（`apkName.replace(".apk","")`） |
| 4 只列 `.apk` | `str.endsWith(".apk")` 才走 App 分支；`.sw` 走固件分支 | `…/dv/updateapp/DownloadActivity.java:179-184` |
| 5 下载 | 系统 `DownloadManager`（同上） | `…/DownloadActivity.java:54,128` |
| 6 安装 | `installAPK(ctx, uri)`：`ACTION_VIEW` + `application/vnd.android.package-archive` + `FLAG_ACTIVITY_NEW_TASK(268435456)`；`ActivityNotFoundException` 静默 | `…/UpgradeManager.java:922-933` |
| 7 分流孪生 | SigmaStar 侧同一套复制在 `com.gku.actioncam.sigmastar.upgrade.app.{DownloadActivity,UpgradeTaskManager}`，行号一一对应（`:43,54,89,100,128`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/upgrade/app/UpgradeTaskManager.java:102,191`） | — |
| 8 跳商店 | `AboutClientActivity.jumpToAppStore("https://play.google.com/store/apps/details?id=com.gku.yutupro")`（**跳的是另一个品牌，不是自己**）；`MarketUtils` 另有 `market://details?id=<pkg>` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/setting/AboutClientActivity.java:164`；`_work/xtu_src/sources/com/gku/base/utils/MarketUtils.java:54` |

---

## 10. 附加功能

### 10.1 GPS / 高德叠加（轨迹页）

| 维度 | 事实 | 出处 |
|---|---|---|
| 入口 | 本地相册/回放预览页 → `startActivity(TrackActivity)`，**只带一个 extra：`"LocalVideoPath"`**（视频本地绝对路径） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/localimage/AlbumPreviewActivity.java:215-220`；`…/sigmastar/newUi/album/Ui/Activity/ActivityNewPreview.java:350` |
| 页面 | `TrackActivity`（`exported=false`，`portrait`，`theme=@style/CustomActionBar`），两套布局 `activity_track` / `activity_track_land`（按 `getRequestedOrientation()==0` 选） | `_work/re/xtugo/manifest.md:242`；`…/localimage/TrackActivity.java:112-119` |
| 地图 | 高德 `AMap`（`com.amap.api.maps.AMap`、`MapView`、`MovingPointOverlay`）与 Google `MapView` 双实现，`isGaodeMap` 二选一 | `…/TrackActivity.java:23,56,66,386,507` |
| 坐标转换 | `GPSConversion.gps84_To_Gcj02(lat,lon)`；常数 `a=6378245.0`、`ee=0.006693421622965943`、`pi=3.141592653589793`、`x_pi=52.35987755982988`；`outOfChina(lon<72.004 \|\| lon>137.8347 \|\| lat<0.8293 \|\| lat>55.8271)`；`exchangeUnit()` 度分秒→十进制 | `_work/xtu_src/sources/com/gku/gps/GPSConversion.java:6-19,21-27,42-48` |
| 数据格式 | `GPSInfoBean{message, List<GpsBean{latitude,longitude,status,EW,NS,…}}`，`message` 必须等于常量 `"Get GPS Info"`（`GpsInfo.GET_GPS_INFO`/`ICatchGpsInfo.GET_GPS_INFO`）才做 `supplement()` 空洞填补（用上一个 `A` 状态点覆盖下一个 `V` 点，正反向各扫一遍） | `…/gps/GpsInfo.java:5`；`…/gps/ICatchGpsInfo.java:5`；`…/gps/GPSConversion.java:30-40` |
| **发什么报文** | **什么都不发**。GPS 点来自**已下载到本地的视频文件旁路数据**（不是相机 CGI）；`TrackActivity` 只把本地路径给 `VideoView.setVideoPath()` | `…/TrackActivity.java:120,128` |
| **硬缺陷（静态可判）** | `TrackActivity.gpsInfoBean` 声明为 `private GPSInfoBean gpsInfoBean = null;`（`:79`），**全文件无任何赋值**，而 `onCreate` 第 164 行无条件 `this.gpsInfoBean.getGps().get(0)` → **进入该页必 NPE**；且 `com.gku.gps.GPSInfoBean` 在整个 `com/gku/` 树里除 `TrackActivity`/`CutActivity`/`VideoEditActivity` 外无生产者 → **GPS 叠加功能在 XTU GO 8.4.3 里是半截（iCatch 记录仪搬过来的）** | `…/TrackActivity.java:79,164,175,235,467-503`；`grep -rn "GPSInfoBean" _work/xtu_src/sources/` 结果 |
| 视频侧烧录 | `ffmpeg -i <视频> -framerate <gpsFrameRate> -i <saveGpsImagePath>/img%3d.png -filter_complex [0][1]overlay=60:main_h-overlay_h-30 -y -q:v 1 -max_muxing_queue_size 1080 -vcodec libx264 -acodec copy -crf 35 -preset ultrafast -r 15 -qp 20 -threads 10 <out>`（**手机侧合成，与相机无关**） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/videoedit/CutActivity.java:538`；`…/videoedit/VideoEditActivity.java:542` |

### 10.2 滤镜 / 特效

| 维度 | 事实 | 出处 |
|---|---|---|
| 入口 | 本地图片预览 → `ImageEditActivity`，顶栏 tab `@string/image_edit_tools`/`@string/image_edit_filter`(`Filters`)/`@string/image_edit_effect`(`Effects`) | `_work/re/xtugo/layouts.md:77`；`_work/re/xtugo/res-strings-default.md:1287-1288` |
| 实现 | **纯手机侧 GPUImage**：`jp.co.cyberagent.android.gpuimage.GPUImageView`（`activity_image_edit_effect.xml` 的 `@+id/iv_cover`）；`ColorFilterPreviewTask` + `ImageEdit.setColorFilter(..., float[] …)` | `_work/re/xtugo/layouts.md:79`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditEffectActivity.java:21,30,56`；`…/ImageEditActivity.java:34,43-44,135-136,278-281` |
| 特效枚举 | `R.string.spec_effect_blur`=「Blue」、`spec_effect_emboss`=「Emboss」、`spec_effect_sketch`=「Sketch」、`spec_effect_toon`=「Toom」（原文如此，笔误）、`spec_effect_white_balance`=「WhiteBalan」 | `_work/re/xtugo/res-strings-default.md:2070-2074` |
| 保存 | `R.menu.menu_save`（本地写文件） | `…/ImageEditActivity.java:141` |
| **发什么报文** | **无**。相机不参与；相机侧若另有「滤镜」项，它只会以 §6.1 动态菜单里 `getsecondmenuitem` 回的一个项名出现，APK 里查不到 | — |
| 文件筛选（另一处叫「筛选」的 UI，勿混） | `file_filter.xml`：`筛选文件/时间段/到/摄像头类型/重置/确定`，`@+id/min_time_edt`、`@+id/max_time_edt`、`@+id/sensors_type_txv` —— 属 **iCatch 记录仪** `com.gku.dashcam.icatch.ui.fragment.DialogFragmentFromBottom` | `_work/re/xtugo/layouts.md:241`；`_work/xtu_src/sources/com/gku/dashcam/icatch/ui/fragment/DialogFragmentFromBottom.java:100-101` |

### 10.3 全景 VR

| 维度 | 事实 | 出处 |
|---|---|---|
| 归属 | **iCatch 全景记录仪（`com.gku.dashcam.icatch`），不是运动相机**。渲染枚举 `RenderType.PANORAMA_RENDER`；会话 `PanoramaSession`；SDK 封装 `PanoramaControl(ICatchPancamSession)`，只有 `addEventListener(int, ICatchIPancamListener)` / `removeEventListener(...)` | `_work/xtu_src/sources/com/gku/dashcam/icatch/streaming/RenderType.java:6`；`…/icatch/PanoramaSession.java:14`；`…/icatch/sdkapi/PanoramaControl.java:11-33` |
| UI | 三个 Activity 的切换按钮 `@+id/panorama_type_btn`：`PreviewActivity`（预览）、`PhotoPbActivity`（照片回放）、`VideoPb2Activity`（视频回放，点击切 2D/全景） | `…/icatch/ui/activity/PreviewActivity.java:64,276-281,677,682`；`…/PhotoPbActivity.java:52`；`…/VideoPb2Activity.java:38,73,110,317`；布局 `content_panorama_video_pb.xml`（含 `eisSwitch`、`SurfaceView`） |
| 底层 SDK | `com.icatchtek.pancam.core/customer`（iCatch 公版全景 SDK，PTP over USB/HTTP）；主文档 §0 已声明该族只做接口级解读 | `_work/re/xtugo/api/com__icatchtek__pancam__core.md`、`…__customer.md` |
| **发什么报文** | 走 iCatch PTP（`libcontrol.so`），**不属于运动相机三条协议栈**，本附录不展开 | — |

### 10.4 抖音直播（`DouyinStreamController`）

| 步 | 动作 | 精确值 | 出处 |
|---|---|---|---|
| 1 | 入口 | `StreamConfigActivity` → `BroadcastDouyinFragment2`（tab），UI：`rg_resolution` / `rg_fps`（`rbs_25`/`rbs_30`，默认 `rbs_30`）/ `rg_bs`（`rbs_flu`/`rbs_high` = bitrate 0 / 非0）、隐私勾选 `imgCheck` | `_work/xtu_src/sources/com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment2.java:600-626` |
| 2 | SDK 初始化 | `DouYinSDK.getInstance().init(new SdkInitConfig.Builder(app, "780679", "XTU GO", BuildConfig.VERSION_NAME, 243L).isDebug(true).initializeListener(...))` —— **直播开放平台 AppID = `"780679"`，appName = `"XTU GO"`，versionCode = `243`，`isDebug=true`（正式版仍开 debug）** | `_work/xtu_src/sources/com/gku/actioncam/amba/ui/stream/DouyinStreamController.java:158-160` |
| 3 | 授权 | `DouyinBroadcastApi.isBroadcastInited()` → `login()` → `DouyinBroadcastApi.login(activity, AccountAuthCallback)`；成功 `BroadcastStatus.ATH`；失败 Toast `R.string.auth_fail`（`Authorization failed`/「授权失败」）+ `":"+p0` | `…/DouyinStreamController.java:141,192-207` |
| 4 | 开播 | `DouyinBroadcastApi.startBroadcast(LiveAngle, CamType)`（`getBroadcastType()` 返回 `Pair<CamType,LiveAngle>`）→ `StartLiveResp`（含 `pushUrl`/`roomId`）；`getRoomId()` 取房间号 | `…/DouyinStreamController.java:269-300`；`…/DouyinStreamController$Companion`（`turnOffBroadcast(roomId)` → `DouyinBroadcastApi.turnOffBroadcast(roomId) != null`，`:110-126`） |
| 5 | 错误码 | `CODE_ERROR_DOUYIN_UNINIT` / `CODE_ERROR_DOUYIN_UNAUTH` / `CODE_ERROR_DOUYIN_STARTBROADCAST_RETURN_NULL` / `CODE_ERROR_DOUYIN_RTMPPUSHURL_ERROR`；`uninit` 文案 = `R.string.uninit`（`Uninitialized`/「未初始化」） | `…/DouyinStreamController.java:99-126`；`_work/re/xtugo/res-strings-default.md` |
| 6 | **把 RTMP 地址交给相机** | `startNewLive(msg=rtmpUrl, fbl=res, fps, bitrate)` → 存 `RTMPBean` + `SharedPreferencesUtils.saveRTMPBean()` → **BLE 下行 `R007`**：`String.format("live_type:%s;res:%d;fps:%d;bitrate:%d;rtmp_url:%s;", liveType, res, fps, bitrate, rtmpUrl)`；同调用链 `BLEConnectUtils.startLive("tiktokCN", fbl, fps, bitrate, msg)` | `…/BroadcastDouyinFragment2.java:938-953`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:285` |
| 7 | 先让相机连上手机能上网的热点 | **BLE `R006`**：`String.format("ssid:%s;pwd:%s;", ssid, pwd)`；`BluetoothLive` 里硬编码 `sendWifi(…, "gkuvision-5G", "gku88888", …, "R006")` | `…/BLEConnectUtils.java:278`；`_work/xtu_src/sources/com/gku/module_camera/bluetooth/BluetoothLive.java:92,188` |
| 8 | 推流页 | `StreamingActivity`（`exported=false`，从 `HomeActivity.INTENT_RTMP_TASK` 取 `RTMPBean`），只有计时 UI + `closeLive()` 确认框；**App 侧不推流**，RTMP 由相机自己推 | `_work/xtu_src/sources/com/gku/actioncam/amba/ui/stream/StreamingActivity.java:42,136-140`；`_work/re/xtugo/api/com__gku__actioncam__amba.md`（`sendBufWithRTMP`） |

### 10.5 扫码直播 / 自定义 RTMP（「互联网远程观看」在本 APK 里的真实形态）

| 步 | 动作 | 精确值 | 出处 |
|---|---|---|---|
| 1 | 平台选择页 | `SelectLiveActivity`（`R.string.rl_selete_plaform` = `Choose live platform`／「选择直播平台」），`GridView @+id/select_live_grid` 用 `IMAGE_ID[]` 铺图标，任何一项点击**都只进同一个 `CustomLiveActivity`** | `_work/xtu_src/sources/com/gku/actioncam/remote_live/SelectLiveActivity.java:40-65` |
| 2 | 自定义页 | `CustomLiveActivity`，标题 `R.string.rl_custom_setting`；三块：`@+id/custom_live_wifi_scan`（选 WiFi，`R.string.rl_live_wifi`+`rl_selete_wifi`）、`@+id/custom_live_rtmp_edit`（`R.string.rl_input_rtmp`）、`@+id/start_live_button` | `_work/re/xtugo/layouts.md:62`；`…/remote_live/custom/CustomLiveActivity.java:43-82` |
| 3 | 选 WiFi | `startActivityForResult(new Intent(this, ScanWifiActivity.class), 718)`；`ScanWifiActivity` 注册 `android.net.wifi.SCAN_RESULTS` 收 AP 列表，选中后可再弹 `layout_wifi_dialog`（`@string/ssid`/`@string/password`/`rl_wifi_cancel`/`rl_wifi_confirm`） | `…/CustomLiveActivity.java:97`；`_work/xtu_src/sources/com/gku/actioncam/remote_live/ScanWifiActivity.java:285,314`；`_work/re/xtugo/layouts.md:373` |
| 4 | 起流前置门 | `isLivePrepared()`：`url != null && url.startsWith("rtmp")`，否则按钮变灰（`live_platform_view_white` + `rl_start_live_black` + `setTextColor(MEASURED_STATE_MASK)`） | `…/CustomLiveActivity.java:105-121` |
| 5 | 出二维码 | `startActivity(QRShowActivity)` 带三个 extra：`"ssid"`、`"pwd"`、`"url"`；`url` 为空则直接 `finish()` | `…/CustomLiveActivity.java:99-104`；`_work/xtu_src/sources/com/gku/actioncam/remote_live/QRShowActivity.java:24-38` |
| 6 | 二维码内容（逐字格式） | `QRContentBean.toString()` = `"[SSID:" + ssid + ",PWD:" + pwd + ",URL:" + url + "]"` —— **方括号 + 逗号分隔的自定义文本，不是标准 WIFI: 码**；用 `QRCodeUtil.zxingQRBitmap(w,w,…)` 画，边长 = 屏宽 × 0.8 | `_work/xtu_src/sources/com/gku/actioncam/remote_live/QRContentBean.java:18-23`；`…/QRShowActivity.java:31-37` |
| 7 | 谁扫 | **相机扫**（页标题 `R.string.rl_scan_code_live` = `Scan code live`／「扫码直播」，正文 `R.string.rl_camera_scan_qr` = `Camera scan QR code`／「相机扫描二维码」，布局 `activity_q_r_show.xml`）→ 相机自己拿到 SSID/密码/RTMP 后连云端推流 | `_work/re/xtugo/res-strings-default.md:1899-1911`；`_work/re/xtugo/layouts.md:95` |
| 8 | 另有云端服务（**不是这条链路的报文**） | `com.gku.rxt.net.AppService`：`API_SERVICE_HOST_IP="http://api.shhc-yh.com/"`、`API_FW_SERVICE_HOST_IP="http://api.shhc-yh.com/api/"`、`API_APP_SERVICE_HOST_IP="http://www.gkuvision.com:8882/upload/update.xml"`；方法 `ossPost(mid)`、`getVersionInfo()`；底层 `m.mifan.acase.core.HttpProtocol` | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:22-24,31` |

### 10.6 `m.mifan.acase.**` 这套协议库是给谁用的

| 维度 | 结论 | 证据 |
|---|---|---|
| 服务对象 | **XTU Mini1 行车记录仪（iCatch 方案）**，不是运动相机 | 配套 Activity 全在 manifest 且 `theme=IcatchAppTheme`：`cn.rxt.qscase.{MainActivity,ControlActivity,AlbumActivity,PreferencesActivity,AgreementPermissionActivity,Main2Activity}`、`com.example.icatchplayerlibrary.VideoPbActivity`、`m.mifan.acase.icatch.IcatchVideoPlayerActivity`、`cn.rxt.caeuicore.album.page.preview.VideoPlayerActivity`（主文档 §1.4 末行） |
| 核心类型 | `m.mifan.acase.icatch.IcatchCase`（`extends Case implements IcathEventHandler.Callback`，135 个字段/常量，持 `IcathEventHandler eventHandler`、`Case.FwCallback`、`int workMode=-1`、`boolean hasSdcard`、`boolean isCollecting`） | `_work/re/xtugo/api/m__mifan__acase__icatch.md:12-45` |
| 传输 | `m.mifan.acase.core.HttpProtocol`（Kotlin，`new HttpProtocol(false, 1, null)`）+ `ApiResult`；命令号是 **4 位十进制字符串**（`9001` 监控工作模式、`1002` 拍照分辨率、`9007` 拍照张数、`2002` 录像分辨率），定义在 assets 的模板里 | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:31`；主文档 §6（`assets/menu/LZXCAM`、`assets/menu/ly_menu.json`，`cmd` 4 位数字，`ui ∈ {UIList,UITimePicker,UITimerRecord,UICustom,UISwitch,UIInput,UIWifiSet,UISDFormat,UIReSet}`） |
| 设备地址 | `192.168.1.1`（`IcatchCaseKt.API_HOST_ICATCH`），AP 默认密码 `"12345678"`（`WifiAPUtil.DEFAULT_AP_PASSWORD`） | 主文档 §2.5 |
| 连接分派 | `HomeActivity.checkConnectionDevice()` 里 `ip=="192.168.1.1"` → `connectDashCamera2(...)`（与运动相机完全分流），并会先 `resetBT()` | `_work/xtu_src/sources/com/gku/HomeActivity.java:562-565,1624-1626` |
| 判定 | **XTU 运动相机的任何操作都不需要经过 `m.mifan.acase`**；复现运动相机时把它当独立子产品 | — |

---

## 11. 状态轮询

### 11.1 结论先行

**B 套（真机 S7PRO）预览页没有周期性的状态轮询**，状态是「推送 + 事件驱动」。三个原本该轮询的方法是**空实现**：

| 方法 | 实现 | 出处 |
|---|---|---|
| `ActionCameraPreviewPresenter.registerMessageReceiver()` | `{}` 空 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:80-81` |
| `startBatteryPolling()` / `stopBatteryPolling()` | `{}` 空 | `:83-84,89-90` |
| `startSDCardPolling()` / `stopSDCardPolling()` | `{}` 空 | `:86-87,92-93` |

（调用方仍在 `onStart` 里调 `presenter.registerMessageReceiver()`，`…/HisiActionCameraPreviewActivity.java:315-320`，即调了个空函数。）

### 11.2 真正的状态来源：相机 → App 的 5678 回拨推送

| 维度 | 值 | 出处 |
|---|---|---|
| 服务端 | `HisiSocketServer.getInstance().start(activity, callback)`，`bind(new InetSocketAddress(5678))`，`soTimeout=5000` | `_work/xtu_src/sources/com/gku/module_camera/hisi/HisiSocketServer.java:19,73-74`；启动点 `…/HisiActionCameraPreviewActivity.java:307-312` |
| 另一路 | `MessageService` `new ServerSocket(5678)`，`soTimeout=3000`，读满 ≤512B，广播 `com.gku.xtugo.MESSAGE_ACTION`，extra 键 `"data"` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:18-19,32,92-127` |
| 推送体格式 | 伪 JSON：`{"mode":"<模式串>";"state":"<int>";"event":"<long>";"pasttime":"<int>"}`（分隔符是 **`;` 不是 `,`**），键前带 `var ` → 解析时读 `jSONObject.optString("var mode")`/`optInt("var state")`/`optLong("var event")`/`optInt("var pasttime")` | `…/dv/net/HttpProxy.java:313-316`；`…/ActionCameraPreviewPresenter.java:110-118` |
| 回调链 | `onReceiveMsg(msg)` → `presenter.onReceive(msg)` → `SSResponseParse.parseGetAllInfo(msg)` → `preview.updateOperateCommandUI(state)` | `…/HisiActionCameraPreviewActivity.java:309-311`；`…/ActionCameraPreviewPresenter.java:150-156` |
| Ambarella 推送 | `msg_id` 判别：`268435466`(0x1000000A) = 工作状态、`268435489`(0x10000021) = 旋转（读 `"var rotation"` → `loadRotateSuccess`）、`268435507`(0x10000033) = 蓝牙收发器（读 `"BluetoothDevOne"`/`"BluetoothDevTwo"` → `loadBluetoothTXSuccess`） | `…/ActionCameraPreviewPresenter.java:108-128` |

### 11.3 有周期的东西（数值逐个抄）

| 循环 | 周期（ms） | 端点/动作 | 驱动什么 | 出处 |
|---|---|---|---|---|
| **`KeepAliveService` 心跳** | 失败态 `Thread.sleep(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS)` = **2000**；正常态 `Thread.sleep(5000L)` = **5000**；连续失败计数 `> 5`（`MAX_TICK_COUNT=5`）才广播 `com.gku.xtugo.DV_ISALIVE_ACTION`，extra `"networkpast"=false`；恢复时立刻广播 `true` | **不发任何网络请求**：`Utility.isDeviceAvailable(ctx)` 的真实实现是 `((WifiManager) ctx.getSystemService("wifi")).isWifiEnabled()` —— **只查本机 WiFi 开关** | 断连提示 / `BaseActivity`、`IjkBaseActivity`、`PreviewImageActivity`、`SwitchImageActivity`、`WifiDisconnectReceiver` 的收流方 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java:12-16,43-84`；`…/dv/biz/Utility.java:19-26`；接收方 `…/dv/ui/BaseActivity.java:34`、`…/amba/base/IjkBaseActivity.java:47`、`…/dv/wifi/WifiDisconnectReceiver.java:125` |
| **`requestCurWorkModeParams` 节流门** | `if (System.currentTimeMillis() - lastRequest > 1000)` → 每 **1000ms 最多一次** | `getsecondmenuitem.cgi?-workmode=<模式>&-name=Resolution` + `getcurworkmode.cgi` | 预览页分辨率文字、快设条 | `…/ActionCameraPreviewPresenter.java:365-371` |
| **录像计时器** | `CountDownTimer(Long.MAX_VALUE, 1000L)` → **1000ms** 一跳 | 本地，无报文 | 录像时长文字；`Timing Photo` 递减、`Quick Stories` 用 `(quickStoriesRecordTime + quickStoriesAddTime) - currentTime` 递增 | `…/ActionCameraPreviewPresenter.java:239-266` |
| **卡流看门狗** | `postDelayed(checkRunnable, 1200L)`，阈值 `now - lastStreamTime > 1500` | 无请求，只重建播放器 | 断流自动重连 + Toast `R.string.text_please_near_device`（`Please keep your phone near the device for stable signal`／「请将手机靠近设备以保持信号稳定」） | `…/HisiActionCameraPreviewActivity.java:176-197,848-850` |
| **遮罩重试** | `3000`（`C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS`） | `initIjkVideoView(0)` | 首帧遮罩 | `…/HisiActionCameraPreviewActivity.java:152-158,690-693` |
| **Ambarella 4K 复读** | `150000`（把 µs 常数当 ms 用，实为 150s） | `initIjkVideoView(0)`，条件 `resolutionString ∈ {"4K60","4K30"}` | 4K 预览保活 | `…/HisiActionCameraPreviewActivity.java:159-169,682-684` |
| **屏幕旋转拉取** | `handler.postDelayed(this, 500L)`（`isPulling` 为真时自递归） | `presenter.subscribeScreenRotate()`（**该方法在 presenter 里是空壳**，`…/ActionCameraPreviewPresenter.java:333-335` 转调 `previewModelManage.getModel().subscribeScreenRotate()`） | 预览画面方向 | `…/HisiActionCameraPreviewActivity.java:143-149` |
| **WiFi 信号** | **事件驱动**，`android.net.wifi.RSSI_CHANGED` + `android.net.wifi.STATE_CHANGE` | 无报文（`WifiManager`） | 预览页信号格 `updateWiFiRssiUI` | `…/ActionCameraPreviewPresenter.java:158-187` |
| **回放返回** | `postDelayed(…, 1500L)` | 无报文，`EventBus.post(MessageEvent(backFromPlayback=true))` | 回放页退出动画 | `…/OldUi/playback/presenter/SSPlaybackNewPresenter.java:983-999` |
| **App 升级页下载进度** | `sendEmptyMessageDelayed(2003, 1000L)` → **1000ms** | 查 `DownloadManager` 进度 | 进度条 | `…/dv/updateapp/DownloadActivity.java:103`；孪生 `…/sigmastar/upgrade/app/DownloadActivity.java:103` |
| **抖音直播页** | `sendEmptyMessageDelayed(100, 1000L)` / `sendEmptyMessageDelayed(101, 2000L)` | 本地计时 | 直播时长/状态 | `…/amba/ui/stream/BroadcastDouyinFragment4.java:71,99` |
| **BLE 等 AP 就绪** | `WiFi_Status != 1` 时每秒重写 `R002`（**无上限**） | BLE，非 HTTP | 配网进度 | `…/BLEConnectUtils.java:752-758`（`docs/analysis/ble-and-vpn §1.6 坑1`） |
| **A 套主动查状态** | `HttpProxy.getCameraCurrentInfor(ctx, VERSION)`：`VERSION==1` → `getcurallinfo.cgi`，否则 `getallinfo.cgi`（`VERSION==2` 时 `mode` 是数字，走 `replaceMode(int)` 映射成模式名）→ 拼伪 JSON → **自己广播 `MESSAGE_ACTION`** | 上面两个 CGI | 与推送同一套 UI 通道 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:305-317,319-360` |

### 11.4 各字段驱动哪些 UI（`getcurallinfo.cgi` / 推送共用）

| 字段 | 值 | 驱动 | 出处 |
|---|---|---|---|
| `state` | `20` WORKING | ① 录像中：快门换 stop 图标、`commandOperation` 出 stop 索引、禁切模式入口；② `Quick Video` → `showExitQuickVideoOperateUI()`；③ 视频模式 + `state==20` → `showNormalMessage(R.string.ss_event_start_record,1500)` + `startRecordCountDown(pasttime)`；④ `AmbaActionCameraPreviewActivity` 里 `Long Exposure` + `state==20` 单独分支 | `…/CameraParameters.java:23-24`；`…/HisiActionCameraPreviewActivity.java:1135-1210`；`…/AmbaActionCameraPreviewActivity.java:333-336` |
| `state` | `21` STANDBY | 停录/落盘：`showFinishMessage(R.string.ss_event_save,1500)` + `finishRecordCountDown()`；`Video and Photo` 模式下 `state==21` 会 `hideMainUI(false)` | `…/HisiActionCameraPreviewActivity.java:1160-1185` |
| `event` | `10700000` | Toast `R.string.ss_sd_out`（「未检测到SD卡」）+ `hideSdCardUI()` | `…/HisiActionCameraPreviewActivity.java:1126-1129` |
| `event` | `11700006` | Toast `R.string.ss_sd_in`（「检测到SD卡」） | `:1131-1132` |
| `event` | `11800001` | Toast `R.string.operation_success`（`Operation Success`/「操作成功」） | `:1140-1142` |
| `event` | `1` / `268763137` | 视为开始录像（与 `state==20` 同分支） | `:1143-1145` |
| `event` | `2` / `268763138` | 视为停止录像 | `:1160` |
| `event` | `3` / `268632077` | 视为开始拍照 | `:1186-1188` |
| `event` | `4` / `268632078` | 视为拍照完成；**同时触发 `initIjkVideoView(1000)` 重起流** | `:1212-1216`；`…/ActionCameraPreviewPresenter.java:736-738` |
| `event` | `11700002` / `273420290` / `273420291` / `273420315` / `272642051` | 与 `state==21` 组合判「已保存」 | `:1160-1163`、`:1212-1214` |
| `event` | `4026597633` | 结束录像倒计时 `finishRecordCountDown()`（UI 线程） | `…/ActionCameraPreviewPresenter.java:703-712` |
| `event` | `<= 0` | `initIjkVideoView(0)` 重起流 | `…/ActionCameraPreviewPresenter.java:731-735` |
| `event` | 任意非 0 | 录像/停录按钮重新 `enableActionButton(true)`（`updateOperateCommandUI` 末尾无条件） | `…/HisiActionCameraPreviewActivity.java:1133` |
| `pasttime` | int，**不换算** | 直接进 `SSystemWorkState.pasttime` 当秒显示；Ambarella 机型除 2 补偿：`type ∈ {H75N,"CV75"}` 且**非** `Timing Photo` → `startRecordCountDown(pasttime/2)`，`Timing Photo` → `startRecordCountDown(pasttime)` | `…/SSResponseParse.java:490,505,525`；`…/amba/model/AmbaCmdModel.java:570`；补偿逻辑 `…/ActionCameraPreviewPresenter.java:718-727` |
| `mode` | 模式串 | `curWorkMode = sSystemWorkState.getWorkMode()` → 模式图标 `SSExchangeWorkMode.workModeToResId()`（XTU 下 = `getIdentifier("ic_image_" + 归一小写名, "drawable", pkg)`） | `…/ActionCameraPreviewPresenter.java:700-702`、`:652-658`；`…/SSExchangeWorkMode.java:68-74,86-132` |
| `state` 的 A 套版 | `getcamerastatus.cgi` 要求同时出现 `count=` 与 `status=`，缺一返回 `null`；分隔 `;\|\n\|Var` | 真机回 200 空 body ⇒ 判「无状态」 | `…/dv/net/HttpProxy.java:142-169` |
| 电量 | `getbatterycapacity.cgi` → `capacity`(int)、`charge`(`"1"`→bCharging)、`ac`(`"1"`→bAC) | 仅在 `bAC` 或 `bCharging` **变化时**才 `showBatteryState()`（相同则 return，不重复刷 UI） | `…/SSResponseParse.java:245-279`；`…/ActionCameraPreviewPresenter.java:674-687` |
| SD | `getsdstate.cgi` → `sdstate ∈ {SDOK,SDFULL,SDNONE,SDERROR}`、`total`、`used`（去 `" MB"` 后 parseInt，缺则 `-1`） | `showSdCardState()`、容量条 | `…/HaisiPreviewModel.java:205-238`（解析）；`…/ActionCameraPreviewPresenter.java:661-672` |

---

## 12. 静态定不来的操作

下表每一项都**至少缺一个字段**（报文存在性、参数域顺序、固件响应体、或成功判据），并给出补证手段。

| # | 悬而未决 | 为什么静态定不来 | 需要什么手段补证 |
|---|---|---|---|
| 1 | **`reset.cgi` 到底是「恢复出厂」还是「重启」** | 同一条命令：入口项名 `"Factory Reset"`、确认框 `R.string.restore_tip`=「确定恢复出厂设置?」，但失败 Toast 资源 `R.string.reset_fail` 的中文是「重启失败」；`Command`/`HttpProxy` 两层都不看 body | 真机各发一次并观察：① 相机是否重启（`getdeviceattr.cgi` 断连→重连）② 用户数据是否被清（`getfilecount.cgi` 是否归零）。若两问皆否，则中文文案是错标 |
| 2 | **相机侧是否存在「重启 / 关机」命令** | 全 APK 无 `reboot.cgi`/`restart.cgi`/`poweroff.cgi`；预览页布局里的 `@+id/ivPower`、`@+id/viewCoverOnPowerOff` 在 Java 侧零引用（只有 `R.java` 常量与 databinding 字段）；Ambarella 侧 `1537 WIFI_RESTART`/`1540 WIFI_STOP`/`1541 WIFI_START`/`1542 WIFI_STATUS`/`12 AMBA_POWER_MANAGE`/`259 AMBA_RESETVF` **全是无发送方的常量** | ① 真机抓 `getprimarymenuitem.cgi?-workmode=System` 的 `item` 全串（若回 `Reboot`/`Power Off` 且 `cur` 为空，则 App 会自动生成一行点击型菜单并走 `setcurparameter.cgi?-workmode=System&-name=Reboot&-value=`，空值是否被接受要实测）② 对 Ambarella 机型主动发 `{msg_id:1537/1540/1541}` 看是否响应 |
| 3 | **录像中「改参数」是否被客户端禁止** | 主文档/真机说「录像中切模式/改参数被拒，官方是客户端直接禁止」。静态只找到**切模式**的 UI 门控（§5.3）；`setcurparameter.cgi` 的三条写路径（`HttpProxy.setModelPamarsStr`/`setDevicePamarsStr`/`SSCommandUtil.setCurParam`）**均未读 `workState.state`**，也没有 `isEnabled` 判断 | 真机：`state==20` 时手动点设置项，抓包确认「按钮是否可点」+「是否仍发请求」。若仍发请求 → 「客户端禁止」这条结论要收窄成「只禁切模式」 |
| 4 | **NewAPP 机型上 `getcurallinfo.cgi` 的推送方向** | App 同时监听 5678 与 8080 无关联；`HttpProxy.getCameraCurrentInfor()` 会**自己造一条假推送广播**，与真推送走同一通道，静态无法区分相机是否真的主动推 | 真机 tcpdump/`ss -tlnp`：确认相机是否主动连 5678；以及 `getcurallinfo.cgi` 的请求频率是 App 发的还是相机推触发的 |
| 5 | **`pasttime` 的真实单位** | 代码零换算，显示层当秒；真机 S7PRO 约 1 拍/秒、Ambarella 半秒 → App 对海思「碰巧对」，对 Ambarella 会差 2 倍（且已写死 `pasttime/2` 补偿） | 长录一次，同步秒表比对；`Hi3519DV500` 与 `CV75` 各一台 |
| 6 | **`getprimarymenuitem.cgi` 同响应行内 `item`/`cur` 的完整字段集** | 解析用 `getMap2`（只要求 `";`），真机把 item 与 cur 写同一行时只有最后一个键能读到；系统页还人为拼 `",test"` 占位 | 真机原始响应体（`curl` 落原始字节，含 `\r\n`）→ 判定该 CGI 是否可被宽松解析替代 |
| 7 | **NewAPP 方言的**全部**可选值枚举**（分辨率/帧率/延时间隔/连拍张数/白平衡/曝光补偿…） | 值全部由 `getsecondmenuitem.cgi` 在运行期返回，APK 内只有 12 个硬编码项名与 8 个特殊帧率串（`720P100/720P200/1080P100/1080P200/720P120/720P240/1080P120/1080P240`） | 逐模式真机拉 `getprimarymenuitem` + 每项 `getsecondmenuitem`，导出成表；同时拉 `/mnt/language.xml` 或 `/tmp/FL0/language.json` 才能拿到中文项名 |
| 8 | **各工作模式的完整清单** | `getallworkmode.cgi` 的 `photo`/`video` 两项是设备给的；静态只有 15 个已知串 + `NewTimeStretch`/`NewManualRecsnap`/`NewLapseBurst`/`"Night Photo"`/`"Night Scene"`/`"Loop Video"`/`"Video+Photo"`/`"Lapse Video"`/`"Timelapse Video"` 等别名 | 真机 `curl BASE'getallworkmode.cgi'` 全型 × 全固件版本 |
| 9 | **预览大码流（11）在 NewAPP 上是否根本不可用** | `SSCommandUtil.previewLiveStream()`/`HaisiCommandUtil.previewLiveStream()` 写死 `rtsp://192.168.0.1:554/livestream/12`，不读 `preview_video` 开关；只有 A 套 `DV.getVideoRtspURL()/getVideoHttpURL()` 会出 `11` | 真机手动试 `rtsp://<ip>:554/livestream/11` 与 `http://<ip>:80/11?trans=tcp&action=play&media=video_data`，看能否起流 |
| 10 | **预览主机 IP 是否恒为 `192.168.0.1`** | 上述常量路径用 `SSConstant.SS_IP`，而 `DV.getVideoRtspURL()` 用运行时 `this.ip`；若相机 IP 被用户改过，B 套预览必挂 | 真机改 IP 后复现；决定我们是否照抄这个常量 |
| 11 | **下载是否有续传** | 三套下载（HTTP 临时文件+rename、8080 定长头、Ambarella 8787 裸管道）均**无 `Range`/`offset` 复用**（Ambarella 的 `offset`/`fetch_size` 在 `getFile` 里恒为 `0`） | 真机下载中途断 WiFi，再点下载，看是否从头开始 |
| 12 | **`getfilelistinfoios.cgi` 与 `getfilelist.cgi` 的响应字段完整集** | 静态只读 `path`/`create`/`time`/`size`；`-type` 只有 `Photo`/`Video` 两个串（`SSCommandUtil.getFileList(int,int,int)`），而 `SSPlaybackNewPresenter` 侧出现 `Normal`/`Video`/`Event`/`Emr`/`Photo` 五种 type 语义 | 真机原始响应；对每种 `-type` 值各发一次记录返回码与体 |
| 13 | **`getdirname.cgi` 到底给谁用** | 只有 `SSCommandUtil.getDirname()` + `SSResponseParse.parseDirname()` 两个定义，**全树零调用** | 真机手动 `curl` 看返回，判断是否用于日期分组（若返回 `YYYYMMDD` 列表则我们的回放分组可以改成服务端分组） |
| 14 | **二维码配网码的真实格式** | 解析器只硬要求串里含 `WIFI:`、`S:`、`P:`，并只从 `S:`/`P:` 到下一个 `;` 取值；`split(";")` 结果被丢弃 → 含 `;`、`\`、`:` 的密码会被截断；`T:`（企业型）、`H:`（隐藏）完全不支持 | 拿官方相机机身/包装上的二维码实物解码，确认字段全集与转义规则 |
| 15 | **BLE `R001`~`R009` 的语义与回包** | 本附录只能列「写了什么」，**通知回包字段**（`Status`/`Pin`/`KEY:1`/`SSID`/`PWD`/`WiFi_Status`/`R009_cap:`）的取值域、以及 4 位配对码的生成与拒绝重试规则在 `BLEConnectUtils.onCharacteristicChanged` 的混淆分支里；`docs/analysis/ble-and-vpn §1.2` 也是行为级描述 | ① nRF Connect 手工连一台相机逐条发 `R001`~`R009` 记回包 ② 对 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:660-900` 做逐行精读 + 运行时日志（tag `xs, `、`onServicesDiscovered:`） |
| 16 | **`m.mifan.acase` / iCatch 命令面** | 属另一个产品（XTU Mini1），命令号是 4 位十进制串，模板在 `assets/menu/*` 但**零引用**；`libcontrol.so` 内是 PTP | 单独建档（USB/HTTP 抓包 + `com.icatchtek.**` 精读）；本附录不覆盖 |
| 17 | **相机端 HTTPS / 鉴权** | 全部相机请求**零鉴权、零 TLS**（`usesCleartextTraffic=true` + `network_security_config.xml` 只有 `cleartextTrafficPermitted="true"`）；无法从静态判断固件是否支持 | 真机试 https 端口与带 `Authorization` 头的请求 |
| 18 | **`SvrFuncResult` 错误码全集** | 只有 `Command.executeCommand()` 会读它，且用 `substring(15, lastIndexOf("\""))` + `parseInt`（十六进制串会抛异常→ `errorCode=-1`）；`-2222` 仅在 `SSResponseParse` 里被 `contains("-222")` 吞掉 | 逐条构造非法参数抓返回，建一张错误码表（含 `0xFFFFF752` 这类有符号值的正确解法：`int` 直接按补码读） |
| 19 | **`TrackActivity`（GPS/高德轨迹页）是否可用** | `gpsInfoBean` 声明后从未赋值，`onCreate` 无条件 `getGps().get(0)` → 静态判定必 NPE；`com.gku.gps.*` 的生产者（`"Get GPS Info"` 的应答解析）不在 `com/gku/` 树里 | 真机点进该页看是否闪退；若不闪退说明有未被 jadx 还原的注入路径（`_work/xtu_bad/sources/com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java` 同路径的 smali 伪码需再核） |
| 20 | **App 自身更新在 XTU GO 上是否真的可达** | `UpgradeManager.serverHaveLatestAPK()` 依赖 `versionName` 末 8 位是 `yyyyMMdd` 且文件名带日期，异常即 `return true`；入口在 `settingpreferences.xml` 的 `update_version`，但该项文案是 `Camera System Update`／「相机系统更新」→ 很可能用户看到的是固件页而非 App 页 | 真机走「我的-设置-相机系统更新」，看列表是否含 `.apk` 项、能否触发安装 |
| 21 | **抖音直播 `startBroadcast` 的返回体与推流失败码** | 关键逻辑在字节跳动 `com.bytedance.android.openlive.broadcast.**` 三方 SDK 内，非厂商代码；本 APK 只给了 4 个错误码常量与 `R.string` 文案 | 真机实测一遍开播（含未授权/无网/RTMP 非法）记 `StartLiveResp` 字段与相机侧行为 |
| 22 | **`getactivateinfo`/`settrial`/`setactivateinfo` 的 `status`/`version` 语义** | 只知 `status==0` 触发激活弹窗、`settrial`/`setactivateinfo` 用 `%d`+`%s` 回填原值；试用次数上限（协议文案说 3 次）在固件侧 | 真机连做 3 次试用观察 `status` 变化；且仅 S7PRO/S7PRO MAX 有这条链 |

### 12.1 与主文档 / 其他文档的冲突点汇总（本附录已就地标注）

| # | 冲突 | 本附录的立场 | 位置 |
|---|---|---|---|
| C1 | 主文档 §11 称「预览 12 会切成 11（`isPreviewBigBitRate()`）」 | **只对 A 套成立**；B/C 套 `previewLiveStream()` 写死 `12` 且写死 `192.168.0.1` | §2.2 |
| C2 | 主文档 §1.4/§3.4 称 `KeepAliveService` 是「2000ms/5000ms 心跳**轮询**」 | 周期数值正确，但**探测的不是相机**：`Utility.isDeviceAvailable()` 只查本机 `WifiManager.isWifiEnabled()`，一个报文都不发 | §11.3 |
| C3 | 主文档 §5 承诺「改参数也被客户端禁止」 | 静态只见「切模式」有 UI 门控，三条写参数路径都无 `state` 判断 | §5.3、§12 #3 |
| C4 | `reset.cgi` 的中文失败文案是「重启失败」，入口却是「恢复出厂设置」 | 记为待真机裁定，不擅自统一 | §8.3、§12 #1 |
| C5 | `photo.cgi` 两套拼法（`?-type=photo&-cmd=start` vs `?&-type=photoburst`） | 海思 NewAPP 实走 A 套表（带 `&`、type 五值），B 套 `SSCommandUtil.startPhoto` 恒为 `"photo"` | §4.1 |
| C6 | 云端固件版本接口两条 URL 参数名不同（`firm_ware_model` vs `firmWareModel`，路径 `v1/push/` vs `push/`） | 两者都在代码里，按调用方分别复现 | §9.1 |
| C7 | `getdeviceattr.cgi` 解析在无 `networkstatus` 键时走 else 分支，使用未赋值变量 → NPE → 整次识别失败并**误入 Ambarella socket 兜底** | 按代码事实陈述，并提示这是真机可复现的行为 | §1.5 步 5 |
| C8 | 主文档 §4.1 的 `getcurallinfo` 事件/状态语义 | 补全 `event` 数值 → UI 全表，并新增 `4026597633`、`11800001`、`10700000`、`11700006`、`268763137/138`、`268632077/078`、`1/2/3/4` 与 `268632078` 触发重起流 | §11.4 |
| C9 | `docs/analysis/ble-and-vpn` 与 BLE 结论 | 无冲突；本附录补充：BLE 链路实际只对 S7Pro 系列验证过（`docs/analysis/ble-and-vpn §1.6 坑3`），以及 `R006`/`R007` 的**逐字段模板串** | §1.4 |

---

<!-- 以下整段合并自原 02-XTUGO-档案-附录-权限组件与域名.md（2026-09-22 文档归并，内容未改） -->
# 附录 E · 权限、组件与域名

> 对象：`com.gku.xtugo` 8.4.3_243（`相机 app/XTU GO_8.4.3_243_2026-08-19-17-05-43.apk`）
> 本附录是 `docs/evidence/xtugo` §1.2/§1.3/§1.4、§8 的展开件。主文档给结论，这里给**逐条到行**的证据。
> 取证底座：`_work/re/xtugo/manifest.md`（清单）、`_work/re/xtugo/components.tsv`（219 组件机器可读）、
> `_work/re/xtugo/classes-all.tsv`（dex 类表，OWN 2885 类）、`_work/re/xtugo/own-literals.tsv`（厂商自有字符串 22623 条）、
> `_work/re/xtugo/signals-{fullUrls,hosts,ips,actions,crypto}.tsv`、`_work/re/xtugo/natives-strings.tsv`、`_work/re/xtugo/assets-index.md`。
> 引用一律写**全路径**；行号均已用 Read/sed 复核（复核方法：`_work/xtu_src/sources/<包名转目录>.java:行`）。
> `xtu_src` 与 `xtu_bad` 存在同名文件，本附录**所有源码引用均出自 `_work/xtu_src/`**，无一例外。

---

## 目录

1. [权限逐条表（38 + 1 自定义 + uses-feature + maxSdkVersion）](#1-权限逐条表)
2. [组件全量表](#2-组件全量表)
3. [`<application>` 属性与实际后果（含 network_security_config 全文）](#3-application-属性与实际后果)
4. [域名与端点判定表](#4-域名与端点判定表)
5. [Intent action / 自定义广播 / DeepLink / scheme](#5-intent-action--自定义广播--deeplink--scheme)
6. [FileProvider / authorities / 共享路径](#6-fileprovider--authorities--共享路径)
7. [native 与 assets 里的域名、证书](#7-native-与-assets-里的域名与证书)
8. [对主文档 §1/§8 的补充与纠正](#8-对主文档-1-8-的补充与纠正)
9. [本附录未确认的点](#9-本附录未确认的点)

---

## 1. 权限逐条表

清单出处：`_work/re/xtugo/manifest.md:45-88`（38 条 `uses-permission`）、`:90-94`（1 条自定义 `permission`）、`:96-112`（uses-feature / uses-library）。

### 1.0 判定方法与「谁在申请」

判定三档：

- **在用** = 厂商代码里既能找到权限字符串（`"android.permission.X"` / `Manifest.permission.X`），又能找到**只有该权限才放行**的 API 调用。
- **只被库检查** = 权限字符串只出现在第三方库里，厂商代码零引用。
- **死声明** = 字符串和受保护 API **两头都为 0**（双查见下表「字符串命中」「API 命中」两列，检索式在 §1.5）。

⚠️ 运行期申请权限的地方**不是只有主文档 §1.3 说的那一处**，实测有 **4 处独立数组**：

| 申请点 | 文件:行 | 说明 |
|---|---|---|
| A. 首启授权页 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31`（≤29）<br>`:32`（30–32）<br>`:33`（≥33） | 主文档 §1.3 引用的就是这里 |
| B. 启动页 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/WelcomeActivity.java:53`（≤29）、`:54`、`:55` | 与 A 不同：**不含 `CALL_PHONE`**，其余同 A |
| C. 设备列表底部弹窗 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:67`（定位）、`:73`/`:84`（`BLUETOOTH`）、`:76`/`:78`（三个 BT 新权限）、`:83`（WiFi/网络四件套） | 按需单独补申请 |
| D. 配网页 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BasePermissionActivity.java:18` | `btPermissionList = {"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"}` |

### 1.1 38 条逐条

| # | 权限 | maxSdk | 字符串引用（类:行，全路径省略前缀 `_work/xtu_src/sources/`） | 受保护 API 的真实调用点 | 运行在哪一步 | 判定 |
|---|---|---|---|---|---|---|
| 1 | `ACCESS_NETWORK_STATE` | — | `com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31,32,33`；`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:83`；`com/gku/actioncam/hisilicon/dv/ui/WelcomeActivity.java:53` | `NetWorkInfoUtils` / `NetworkUtils` 读 `ConnectivityManager` | 启动检查、配网前判断是否已联网 | **在用** |
| 2 | `INTERNET` | — | 0（正常：无需字符串） | 全量 socket/OkHttp；`com/gku/actioncam/hisilicon/dv/net/HttpProxy.java`、`com/gku/HomeActivity.java:859`（OSS） | 所有网络访问 | **在用**（安装即授） |
| 3 | `READ_PRIVILEGED_PHONE_STATE` | — | **0** | `getImei/getDeviceId` 在 `com/gku/base/utils/DeviceInfoUtils.java:86,90,93` 与 `com/gku/actioncam/sigmastar/util/SystemUtil.java:49`，但这些只需 `READ_PHONE_STATE` | 无 | **死声明**（`signature\|privileged`，普通应用永远拿不到） |
| 4 | `READ_EXTERNAL_STORAGE` | — | `com/gku/actioncam/hisilicon/dv/localimage/LocalAlbumActivity.java:32,33`；`com/gku/actioncam/hisilicon/dv/ui/fragment/FragmentConnectedCamera.java:192,255`；`com/gku/loginmodule/utils/PermissionUtils.java:22`；申请点 A/B/C | 相册读取 | 打开本机相册 / 下载前后 | **在用** |
| 5 | `WRITE_EXTERNAL_STORAGE` | **29** | `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java:221,222`；`com/gku/actioncam/hisilicon/dv/ui/data/FileUtils.java:42,47`；`com/gku/actioncam/hisilicon/dv/ui/fragment/FragmentConnectedCamera.java:192,255` | 直写 `/DCIM/...` 绝对路径 | 固件/媒体下载落盘 | **在用（≤29）**，清单已用 `maxSdkVersion=29` 收口 |
| 6 | `MANAGE_MEDIA` | — | 0 字符串；但有 4 处跳授权入口：`com/gku/HomeActivity.java:1049`、`com/gku/actioncam/hisilicon/dv/ui/WelcomeActivity.java:195`、`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:312`、`com/gku/loginmodule/utils/PermissionUtils.java:118`（`Intent("android.settings.REQUEST_MANAGE_MEDIA")`） | **0**：全树没有任何受 `MANAGE_MEDIA` 保护的 `MediaStore` 批量写/删调用 | 只把用户送到「允许管理所有文件」设置页 | **半死**：入口在、消费者无（见 §8 C-02） |
| 7 | `ACCESS_MEDIA_LOCATION` | — | 唯一命中在库：`com/bumptech/glide/load/model/stream/QMediaStoreUriLoader.java:159`（`checkSelfPermission`） | 厂商侧 0 | Glide 加载带 GPS 的媒体 URI 时自检 | **只被库检查** |
| 8 | `ACCESS_WIFI_STATE` | — | 申请点 A/B/C（`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31-33`、`com/gku/actioncam/hisilicon/dv/ui/WelcomeActivity.java:53`、`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:83`） | `HiWifiManager`、`com/gku/base/utils/WifiUtils.java`；Ambarella `msg_id=261` 取本机 IP 用（`com/gku/actioncam/amba/model/AmbaCmdModel.java:279`） | 连接前取手机 IP、扫/切 AP | **在用** |
| 9 | `CHANGE_WIFI_STATE` | — | 同上申请点 | `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java:493-500` 主动 `disconnectWifi()` 再连相机 AP | 配网切 AP | **在用** |
| 10 | `CHANGE_NETWORK_STATE` | — | 同上申请点 | `com/gku/base/device/NetworkDeviceUtils.java:332-358`（`bindProcessToNetwork` 路径） | 把进程绑到相机网卡 | **在用** |
| 11 | `READ_PHONE_STATE` | — | `com/gku/base/utils/DeviceInfoUtils.java:80,112`；`com/gku/HomeActivity.java:950`（`shouldShowRequestPermissionRationale`） | `telephonyManager.getImei()/getDeviceId()`：`com/gku/base/utils/DeviceInfoUtils.java:86,90,93`、`com/gku/actioncam/sigmastar/util/SystemUtil.java:49` | 取设备标识（崩溃上报/反馈） | **在用（弱）**：仅设备标识，功能不依赖 |
| 12 | `ACCESS_COARSE_LOCATION` | — | 申请点 A/B/C（`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31-33`、`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:67`） | `com/gku/base/utils/LocationUtil.java`（`FusedLocationProviderClient`）；高德坐标转换 `com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:23-32` | GPS 轨迹水印/轨迹页 | **在用** |
| 13 | `ACCESS_FINE_LOCATION` | — | `com/gku/loginmodule/utils/PermissionUtils.java:21`（常量 `LOCATION`）、`:129`；被 A/B/C 三处数组引用 | 同上 | 同上 | **在用** |
| 14 | `GET_ACCOUNTS` | — | **0**（厂商侧）。`AccountManager` 只出现在库：`androidx/core/content/ContextCompat.java`、`ca/da/ca/ha/a.java`、`ca/da/ca/ha/b.java`、`ca/da/ca/ia/a.java`、`com/apm/applog/AppLog.java` | 厂商 0 | 无 | **死声明**（见 §8 C-01） |
| 15 | `FOREGROUND_SERVICE` | — | 字符串仅库命中：`com/amap/api/col/p0003l/d.java:1873`（高德反射 `checkSelfPermission`） | **厂商实调**：`com/gku/actioncam/hisilicon/dv/net/MessageService.java:59` `startForeground(10121, …)`；`com/gku/actioncam/sigmastar/OldUi/playback/model/service/DownloadIntentService.java:46` | 5678 回拨常驻监听、回放下载通知 | **在用**（无需字符串，API 即触发） |
| 16 | `WAKE_LOCK` | — | 0 字符串 | `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java:391` `mWakeLock.acquire()`；`com/gku/actioncam/hisilicon/dv/LogService.java:84` `newWakeLock(1,…)` + `:135` `acquire()`；`com/gku/actioncam/sigmastar/upgrade/firm/Presenter/UpgradePresenter.java:301-302` `newWakeLock(268435466,…)`+`acquire()` | 播放器保屏、日志落盘、固件传输 | **在用** |
| 17 | `BLUETOOTH_CONNECT` | — | 申请点 A/B/C（`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:32,33`、`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:76,78`） | `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:910-918`（`checkBlePermission`，所有 `writeCharacteristic` 前） | BLE 连接/GATT 读写 | **在用** |
| 18 | `BLUETOOTH_SCAN` | — | 同上 | `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:912`；扫描过滤 `com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/DeviceAddActivity.java:125` | 配网扫描 | **在用** |
| 19 | `BLUETOOTH` | **30** | 申请点 A（`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31`）、B、D（`com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BasePermissionActivity.java:18`）、`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:73,84` | 旧版 `BluetoothAdapter` 路径 | ≤30 的蓝牙 | **在用（≤30）** |
| 20 | `BLUETOOTH_ADMIN` | **30** | 唯一命中 `com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BasePermissionActivity.java:18` | 厂商树内**未见** `startDiscovery()`/`cancelDiscovery()`（grep 0 命中） | 声明在配网页权限数组里，实际走 BLE 而非经典 discovery | **在用（名义）**：仅被申请，无 ADMIN 专属 API（见 §8 C-04） |
| 21 | `BLUETOOTH_ADVERTISE` | — | 申请点 A/B/C（`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:32,33`、`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:76,78`） | **0**：全树无 `startAdvertising`/`BluetoothLeAdvertiser` | 只是被一起弹窗申请 | **申请了但未用** |
| 22 | `READ_MEDIA_IMAGES` | — | 常量 `com/luck/picture/lib/permissions/PermissionConfig.java:12`，被厂商数组引用：`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:33` | 相册选择 | ≥33 首启 | **在用（≥33）** |
| 23 | `READ_MEDIA_AUDIO` | — | `com/luck/picture/lib/permissions/PermissionConfig.java:11`；`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:33` | 视频编辑选配乐 | ≥33 | **在用（≥33）** |
| 24 | `READ_MEDIA_VIDEO` | — | `com/luck/picture/lib/permissions/PermissionConfig.java:13`；`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:33` | 本机相册回放/剪辑 | ≥33 | **在用（≥33）** |
| 25 | `WRITE_MEDIA_STORAGE` | — | **0** | **0** | 无 | **死声明**（`signature`，OS 分区权限） |
| 26 | `WRITE_SETTINGS` | — | 0 字符串 | `com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:1215`（`Settings.System.canWrite`）+ `:1222`（`putInt("accelerometer_rotation", …)`）；`com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:1226,1233`；`com/gku/base/permission/PermissionUtils.java:183`、`com/gku/base/permission/PermissionActivity.java:60,120` | 预览页「自动旋转」开关 | **在用**（特殊权限，走 `MANAGE_WRITE_SETTINGS` 设置页） |
| 27 | `MODIFY_AUDIO_SETTINGS` | — | 0 字符串 | `com/gku/actioncam/sigmastar/widget/controller/SSMediaController.java:124,167,214,257` 与 `com/gku/actioncam/widget/MediaController.java:123`（`AudioManager.setStreamMute(3,…)`）；`com/gku/actioncam/hisilicon/dv/player/HiDVRemoteFilePlayer.java:217`、`com/gku/ffm/zqvideo/video/base/GSYVideoControlView.java:863`（`setStreamVolume`） | 回放播放器静音/音量手势 | **在用**（正常权限，装即授；见 §8 C-01） |
| 28 | `RECORD_AUDIO` | — | `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java:788,854,859,899` | 语音反馈录制、视频编辑配音 `com/gku/actioncam/sigmastar/videoedit/AudioCollectActivity.java` | 反馈页录音 | **在用** |
| 29 | `CAMERA` | — | `com/gku/loginmodule/utils/PermissionUtils.java:20,134` | 扫码/拍照反馈（预览画面是相机流，不用本机相机） | 扫一扫配网 | **在用（弱）** |
| 30 | `VIBRATE` | — | 0 字符串 | `com/gku/base/utils/VibratorUtils.java:11` `vibrator.vibrate(50L)` | 按键/扫码反馈 | **在用** |
| 31 | `CALL_PHONE` | — | `com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31,32,33`（三套数组都带）；`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java` 与 `com/gku/actioncam/hisilicon/dv/ui/WelcomeActivity.java:53` **均不含** | **0**：`com/gku` 树内无 `ACTION_CALL`、无 `"tel:` | 只在首启授权页弹窗里出现 | **申请了但未用**（危险权限，白要） |
| 32 | `CHANGE_CONFIGURATION` | — | **0** | `com/gku/base/utils/LanguageUtils.java:101` 是 `Resources.updateConfiguration`（**不需要该权限**）；全树无 `ActivityManager.updateConfiguration` | 无 | **死声明**（签名权限） |
| 33 | `READ_LOGS` | — | 0 字符串 | **有真实消费者**：`com/gku/actioncam/hisilicon/dv/LogService.java:152,277`（`logcat` 子进程）、`com/gku/base/utils/LogSwitchUtils.java:31,32`（`logcat -c`、`logcat --pid=<myPid> -v time -f <file>`） | 诊断日志落盘/上传 | **名义在用**：Android 4.1+ 读**自己进程**的日志不需要此权限，故声明是冗余（见 §8 C-01） |
| 34 | `SYSTEM_ALERT_WINDOW` | — | **0** | **0**：全树无 `TYPE_APPLICATION_OVERLAY`/`canDrawOverlays` | 无 | **死声明** |
| 35 | `GET_TASKS` | — | **0**（厂商）；`getRunningTasks(1)` 只在库：`com/apm/insight/l/a.java:207`、`com/volcengine/zeus/download/h.java:59` | 厂商侧仅 `getRunningAppProcesses`（`com/gku/dashcam/icatch/appinfo/AppInfo.java:52`，不需要此权限） | 无（厂商功能） | **只被库检查**；且该权限 Android 5.0 起已失效 |
| 36 | `FLASHLIGHT` | — | **0** | **0**：全树无 `FEATURE_FLASHLIGHT`、无 `setTorchMode`；`res/` 里也无 | 无 | **死声明** |
| 37 | `com.gku.xtugo.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION`（**自定义**，`protectionLevel=signature`） | — | `androidx/core/content/ContextCompat.java:86`（后缀常量）、`:278`（`packageName + 后缀`） | 由 `ContextCompat.registerReceiver(...)` 在 API 33+ 自动 `sendBroadcast(..., 该权限)` | 与 §5.3(a) 的 `registerReceiver(r, f, 2)` 是同一套机制 | **框架自带**（AndroidX 生成，厂商未手写） |
| 38 | `com.asus.msa.SupplementaryDID.ACCESS` | — | `ca/da/da/a.java:13,25,45`、`ca/da/da/ca/c.java:33` | 绑 `com.asus.msa.SupplementaryDID/.SupplementaryDIDService` 取 OAID（AIDL token 同文件 `:45`） | 隐私/崩溃上报取广告标识，仅华硕机型 | **只被库检查** |

（表内 #1–#36 为 36 条 `android.permission.*`，#37/#38 为两条非 `android.permission.*` 的 `uses-permission` → 合计 **38 条**，与 `_work/re/xtugo/manifest.md:49-86` 的 38 行逐一对应。）

### 1.2 自定义 permission（1 条）

| 权限 | protectionLevel | 出处 | 谁生成 |
|---|---|---|---|
| `com.gku.xtugo.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION` | `signature` | `_work/re/xtugo/manifest.md:90-94` | AndroidX：`androidx/core/content/ContextCompat.java:86`（常量 `DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION"`）、`:278`（`context.getPackageName() + 后缀`） |

厂商代码里没有第二条自定义权限，**也就没有任何「用权限保护自己的导出组件」**——这直接放大了 §5 的外露面。

### 1.3 uses-feature / uses-library / queries

| 条目 | required | 出处 | 后果 |
|---|---|---|---|
| `android.hardware.camera` | false | `_work/re/xtugo/manifest.md:96-105` | 无相机也能装（扫码是可选功能） |
| `android.hardware.camera.autofocus` | **true(默认)** | 同上 | **唯一强制项**：无 AF 的设备直接不可安装 |
| `android.hardware.camera.flash` | false | 同上 | 与 `FLASHLIGHT` 死声明呼应 |
| OpenGL ES `0x20000`(=GLES2) | true | 同上 | 高德/渲染依赖 |
| `uses-library org.apache.http.legacy` | false | `_work/re/xtugo/manifest.md:107-111` | `HttpProxy` 的 `AndroidHttpClient` 需要 |
| `androidx.window.extensions` / `androidx.window.sidecar` | false | 同上 | Jetpack WindowManager |
| `queries`：`com.tencent.mm`、`com.tencent.qq`、`com.gku.xtugo`、`com.gku.yutupro` | — | `_work/re/xtugo/manifest.md:113-120` | 分享/拉起/跳竞品品牌包 |

### 1.4 死声明汇总（**我们不要照着申请**）

| 权限 | 死因 | 我们怎么办 |
|---|---|---|
| `READ_PRIVILEGED_PHONE_STATE` | 字符串 0 + 签名级不可得 | 不申请 |
| `GET_ACCOUNTS` | 厂商 0 引用（仅库） | 不申请 |
| `WRITE_MEDIA_STORAGE` | 字符串 0 + API 0 | 不申请 |
| `CHANGE_CONFIGURATION` | 字符串 0；`Resources.updateConfiguration` 不需要它 | 不申请 |
| `SYSTEM_ALERT_WINDOW` | 字符串 0 + 无悬浮窗 | 不申请 |
| `FLASHLIGHT` | 字符串 0 + 无 torch API | 不申请 |
| `MANAGE_MEDIA` | 只跳设置页，无消费者 | 不申请、也不放入口 |
| `READ_LOGS` | 有 logcat 消费者但权限冗余（4.1+ 读自身不需权限） | 不申请 |
| `BLUETOOTH_ADVERTISE` | 申请了、无 `startAdvertising` | 不申请 |
| `CALL_PHONE` | 申请了、无 `ACTION_CALL`/`tel:` | **绝对不申请**（危险权限，白弹窗） |
| `ACCESS_MEDIA_LOCATION` | 只被 Glide 检查 | 不申请（我们不用 Glide 读媒体 URI） |
| `GET_TASKS` | 只被 apm/zeus 库检查，且 API 已失效 | 不申请 |

→ **12 条**与主文档 §11 的「12 条死权限」数量一致，但**成员不同**：主文档把 `MODIFY_AUDIO_SETTINGS` 算进死声明、把 `READ_LOGS`/`MANAGE_MEDIA` 算成「完全无代码引用」，实测三者都有厂商侧消费者或入口，真正的第 12 席是 `BLUETOOTH_ADVERTISE`/`CALL_PHONE`/`ACCESS_MEDIA_LOCATION`/`GET_TASKS` 这一档。详见 §8 C-01。

### 1.5 复核用检索式

```sh
# 字符串轴
grep -rIn --include=*.java -E '"android\.permission\.<NAME>"|Manifest\.permission\.<NAME>\b' _work/xtu_src/sources/
# API 轴（逐个权限手写的正则见 §1.1 第五列），例如：
grep -rIn --include=*.java -E 'TYPE_APPLICATION_OVERLAY|canDrawOverlays' _work/xtu_src/sources/     # SYSTEM_ALERT_WINDOW → 0
grep -rIn --include=*.java -E 'FEATURE_FLASHLIGHT|setTorchMode'        _work/xtu_src/sources/     # FLASHLIGHT → 0
grep -rIn --include=*.java -E 'startAdvertising|BluetoothLeAdvertiser' _work/xtu_src/sources/     # BLUETOOTH_ADVERTISE → 0
grep -rIn --include=*.java -E 'ACTION_CALL|"tel:'                     _work/xtu_src/sources/com/gku  # CALL_PHONE → 0
```

---

## 2. 组件全量表

### 2.0 精确拆分（`_work/re/xtugo/components.tsv` 全 219 行统计）

| 桶 | activity | service | receiver | provider | 合计 |
|---|---|---|---|---|---|
| `com.gku.*`（厂商主代码） | **100** | **6** | 0 | **1** | **107** |
| 厂商内置 iCatch 面：`cn.rxt.*`(8) + `com.example.icatchplayerlibrary`(1) + `m.mifan.acase.icatch`(1) | 10 | 0 | 0 | 0 | **10** |
| 小计「厂商侧」= 主文档口径 | 110 | 6 | 0 | 1 | **117** |
| `com.my.AppSettingActivity`（独立包，iCatch 记录仪设置页；不在上面 117 的口径里） | 1 | 0 | 0 | 0 | 1 |
| **厂商侧实际全量（含 com.my）** | 111 | 6 | 0 | 1 | **118** |
| 第三方/库 | 77 | 9 | 2 | 13 | **101** |
| **总计** | **188** | **15** | **2** | **14** | **219** |

校验方式（可重跑）：

```sh
awk -F'\t' 'NR>1 && $2 ~ /^com\.gku\./{print $1}' _work/re/xtugo/components.tsv | sort | uniq -c   # 100 activity / 6 service / 1 provider
```

### 2.1 清单幽灵组件：**10 个**（不是主文档说的 2 个）

判定方法：组件全限定名在 **dex 类表**（`_work/re/xtugo/classes-all.tsv` 第 3 列，OWN 2885 类）里查不到，**且** `_work/xtu_src/sources/` 下无同名 `.java`。

```sh
awk -F'\t' 'NR>1 && $2 ~ /^(com\.gku|cn\.rxt|com\.example|m\.mifan|com\.my)\./{print $2}' \
  _work/re/xtugo/components.tsv | while read c; do grep -qP "\t$c\t" _work/re/xtugo/classes-all.tsv || echo "$c"; done
```

| # | 清单声明 | 类型 | 清单属性 | dex 有？ | 源码有？ | 后果 |
|---|---|---|---|---|---|---|
| G1 | `com.gku.CameraSocketService` | service | （无任何属性 → 隐式 exported=false） | **无** | **无** | 永远不会被拉起；`startService()` 会抛 `NotFound` |
| G2 | `com.gku.actioncam.sigmastar.SSMessageService` | service | `enabled=true; exported=false` | **无** | **无** | 同上；SigmaStar 侧推送链路实际由 G3 承载 |
| G3 | `com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSPlaybackActivity` | activity | `theme=@style/CustomActionBar; screenOrientation=portrait` | **无** | **无**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/ui/activity/` 目录里只剩 `SSDownloadStateDialogActivity.java`） | 点「回放」若跳它会崩；实际走新 UI |
| G4 | `com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSPhotoRemotePlayActivity` | activity | `theme=@style/CustomActionBar; screenOrientation=portrait` | **无** | **无** | 同 G3 |
| G5 | `com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSVideoRemotePlayActivity` | activity | `theme=@style/CustomActionBar; screenOrientation=portrait` | **无** | **无** | 同 G3 |
| G6 | `com.gku.actioncam.hisilicon.dv.live.MainActivity` | activity | `theme=@style/Theme.Design.NoActionBar; configChanges=screenSize\|orientation\|keyboardHidden\|keyboard` | **无** | **无**（`…/dv/live/` 下只有 `TelevisionActivity.java` 等） | 老预览主页已删 |
| G7 | `com.gku.actioncam.hisilicon.dv.setting.SettingPreferActivity` | activity | `theme=@style/Theme.AppCompat.Light.NoActionBar` | **无** | **无** | 老方言 PreferenceActivity（配套 `res/xml/preferences.xml` 静态设置表）在 dex 里已不存在 |
| G8 | `com.gku.actioncam.hisilicon.dv.setting.PreferActivity` | activity | `theme=@style/preference_set_activity; label=@string/settings; parentActivityName=com.gku.actioncam.hisilicon.dv.setting.SettingPreferActivity` | **无** | **无** | 同 G7，且 `parentActivityName` 指向另一个幽灵 → **双重悬挂** |
| G9 | `com.gku.actioncam.hisilicon.dv.ui.PreferModelActivityStr` | activity | `theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait` | **无** | **无** | 同 G7 |
| G10 | `com.gku.actioncam.hisilicon.dv.ui.PreferDeviceActivityStr` | activity | `theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait` | **无** | **无** | 同 G7 |

**结论**：这是「R8/ProGuard 删类不删清单」的系统性结果，**10 个幽灵全是老 UI（OldUi / dv.setting / dv.live）遗留**，与 §4.3「老方言静态设置表」相互印证：代码删了，`res/xml/preferences.xml` 与清单条目还在。互操作侧**不要**尝试启动任何一个。

### 2.2 厂商 service（6 条，全部展开）

| 类 | exported / 属性 | intent-filter | 真身 | 职责（读代码） |
|---|---|---|---|---|
| `com.gku.actioncam.hisilicon.dv.net.MessageService` | `enabled=true; exported=false` | 无 | ✅ dex + 源码 | 在 **5678** 端口 accept 相机回拨，把收到的报文转成广播 `com.gku.xtugo.MESSAGE_ACTION`；`startForeground(10121,…)` 见 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:59` |
| `com.gku.actioncam.hisilicon.dv.net.KeepAliveService` | `enabled=true; exported=false` | 无 | ✅ | 心跳轮询（快/慢两档），失败上限后广播 `com.gku.xtugo.DV_ISALIVE_ACTION`；文件头见 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java:19-24` |
| `com.gku.actioncam.hisilicon.dv.LogService` | `enabled=true; exported=false` | 无 | ✅ | 诊断日志：`WakeLock`（`…/dv/LogService.java:84,135`）、`logcat` 子进程抓日志（`:152,277`）、SD 卡插拔广播监听（`:91,92` 注册 `MEDIA_MOUNTED`/`MEDIA_UNMOUNTED`，receiver 在 `:588`） |
| `com.gku.actioncam.sigmastar.OldUi.playback.model.service.DownloadIntentService` | `exported=false` | 无 | ✅ | 回放下载队列（IntentService）；`startForeground` 通知 `…/OldUi/playback/model/service/DownloadIntentService.java:46`；自定义 action 见 §5 |
| `com.gku.CameraSocketService` | 无属性 | 无 | ❌ **幽灵 G1** | — |
| `com.gku.actioncam.sigmastar.SSMessageService` | `enabled=true; exported=false` | 无 | ❌ **幽灵 G2** | — |

### 2.3 厂商 provider（1 条）

| 类 | 属性 | meta-data | 用途 |
|---|---|---|---|
| `com.gku.base.BaseFileProvider` | `exported=false; authorities=com.gku.xtugo.FileProvider; grantUriPermissions=true` | `android.support.FILE_PROVIDER_PATHS=@xml/paths_base` | 分享照片/视频、以及**安装下载的 APK**（`UpgradeViewManager` 发 `INSTALL_PACKAGE`/`VIEW`）时给外部 App 一个 content URI；详见 §6 |

### 2.4 activity 逐个一行（111 行 = 100 个 `com.gku.*` + `com.my` 1 + `cn.rxt` 8 + `com.example` 1 + `m.mifan` 1）

`exported` 全为 `false`（**未写 = false**，见 §2.6 说明），除 `WelcomeActivity`（LAUNCHER）与 `GKUCamPlayer`。以下「属性」列从 `_work/re/xtugo/components.tsv` 第 4 列原样摘（去掉 `theme=@style/` 前缀）。

| 类名（全限定，省略 `com.gku.`） | 类型 | 清单属性（原样） | dex/源码 | 职责（一句话，读代码得出） |
|---|---|---|---|---|
| `SendSoftActivity` | activity | Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait | ✅ | 把手机侧下载到的固件包经 `FwUpload`/`RegisterDeviceToServer` 推到 8080 二进制口 |
| `actioncam.hisilicon.dv.ui.WelcomeActivity` | activity | welcomeTheme_XTU; **exported=true**; screenOrientation=portrait | ✅ | 唯一 LAUNCHER 入口 + 隐私弹窗 + Bugly 初始化（`com/gku/crashhandle/CrashReportManager.java:14-45`）+ 首启权限申请（`:53-55`） |
| `HomeActivity` | activity | CustomActionBar; launchMode=singleTask; screenOrientation=portrait | ✅ | 连接编排中枢：CGI 探测→平台分派（`com/gku/HomeActivity.java:1707-1783`）、OSS STS 上传（`:859`） |
| `gkucamplayer.GKUCamPlayer` | activity | **exported=true**; screenOrientation=fullSensor | ✅ | 全 App 除启动器外**唯一被导出的厂商组件**；GSY/ExoPlayer 通用播放页，**`onCreate` 直接读外部 `kPlayFilePath` 并 `setUrl` 播放**（`_work/xtu_src/sources/com/gku/gkucamplayer/GKUCamPlayer.java:38,47`）→ 可注入 URL，详见 §5.4 |
| `amba.AmbaPicPreviewActivity` | activity | Theme.AppCompat.Light.NoActionBar; exported=false; singleTop; portrait | ✅ | Ambarella 拍照结果预览 |
| `amba.AmbaCameraFileActivity` | activity | 同上 | ✅ | Ambarella 相机端文件选择，回调 `CALLBACK_CHOOSE_CLICK` |
| `hisi.Hisi_PicPreviewActivity` | activity | 同上 | ✅ | 海思侧拍照结果预览 |
| `hisi.Hisi_CameraFileActivity` | activity | 同上 | ✅ | 海思侧相机端文件选择 |
| `actioncam.amba.ui.stream.SelectLiveWifiActivity` | activity | 同上 | ✅ | 直播前选 WiFi |
| `actioncam.amba.ui.stream.SelectLiveDeviceActivity` | activity | 同上 | ✅ | 直播前选设备 |
| `loginmodule.ui.activity.DeviceUpgradeActivity` | activity | 同上 | ✅ | 账号体系下的设备升级页 |
| `loginmodule.ui.activity.DeviceManagerActivity` | activity | 同上 | ✅ | 账号体系下的设备管理页 |
| `actioncam.hisilicon.dv.ui.ExceptionActivity` | activity | Theme.Design.NoActionBar | ✅ | 全局异常落地页（配 `CrashHandler`） |
| `actioncam.hisilicon.dv.ui.PermissionActivity` | activity | Theme.AppCompat.Light.NoActionBar; portrait | ✅ | 首启授权页，三套权限数组 `:31-33` |
| `actioncam.hisilicon.dv.ui.UserCenterWebView` | activity | Theme.Design.NoActionBar; portrait | ✅ | 内嵌 WebView 用户中心（默认 `http://www.google.com/`，`com/gku/actioncam/hisilicon/dv/ui/UserCenterWebView.java:37`） |
| `actioncam.hisilicon.dv.ui.PreferModelActivityStr` | activity | Theme.Design.NoActionBar; portrait | ❌ **G9** | — |
| `actioncam.hisilicon.dv.ui.PreferDeviceActivityStr` | activity | Theme.Design.NoActionBar; portrait | ❌ **G10** | — |
| `actioncam.hisilicon.dv.ui.data.connect.HWScaningActivity` | activity | CustomActionBar; portrait | ✅ | 海思连接前的热点/设备扫描页 |
| `actioncam.hisilicon.dv.filebrowser.Hi3518PriviewImageActivity` | activity | （无属性） | ✅ | Hi3518 老机型文件浏览+预览 |
| `actioncam.hisilicon.dv.filebrowser.PreviewImageActivity` | activity | （无属性） | ✅ | 通用预览页（含 `ACTION_VIEW` 外跳，`…/PreviewImageActivity.java:1188`） |
| `actioncam.hisilicon.dv.wifi.WifiDeviceActivity` | activity | （无属性） | ✅ | 相机端 WiFi 列表/改信道，监听 `android.net.wifi.STATE_CHANGE`（`:49,129`） |
| `actioncam.hisilicon.dv.setting.SettingPreferActivity` | activity | Theme.AppCompat.Light.NoActionBar | ❌ **G7** | — |
| `actioncam.hisilicon.dv.setting.PreferActivity` | activity | preference_set_activity; label=@string/settings; configChanges=screenSize\|orientation\|keyboardHidden | ❌ **G8** | — |
| `actioncam.hisilicon.dv.setting.PrivacyAgreementActivity` | activity | Theme.AppCompat.NoActionBar; portrait | ✅ | 隐私政策页 |
| `actioncam.hisilicon.dv.setting.PhoneSpaceActivity` | activity | CustomActionBar; portrait | ✅ | 手机剩余空间/清理 |
| `actioncam.hisilicon.dv.setting.BitRateActivity` | activity | （无属性） | ✅ | 码率设置页 |
| `actioncam.hisilicon.dv.setting.WifiChannelActivity` | activity | portrait; configChanges=screenSize\|orientation\|keyboardHidden\|keyboard | ✅ | WiFi 信道页 |
| `actioncam.hisilicon.dv.setting.AboutClientActivity` | activity | CustomActionBar; label=@string/about_app; portrait; parentActivityName=…SettingPreferActivity | ✅ | 关于 App / 检查更新（父页是**幽灵 G7**）；`:164` 跳 `https://play.google.com/store/apps/details?id=com.gku.yutupro`；`:147-149` 邮箱 |
| `actioncam.hisilicon.dv.setting.AboutCameraActivity` | activity | label=@string/about_camera; portrait; parentActivityName=…PreferActivity | ✅ | 关于相机（父页是**幽灵 G8**） |
| `actioncam.hisilicon.dv.imagelookover.SwitchImageActivity` | activity | configChanges=screenSize\|orientation\|keyboardHidden\|keyboard | ✅ | 图片左右翻页查看器 |
| `actioncam.hisilicon.dv.dlg.FileInfoActivity` | activity | Dialog | ✅ | 文件信息弹窗（伪装成 Activity 的对话框） |
| `actioncam.hisilicon.dv.ui.ModifyWifiActivity` | activity | Dialog; configChanges=… | ✅ | 改相机 AP 名/密码 |
| `actioncam.hisilicon.dv.dlg.PopupWinforPreviewActivity` | activity | Dialog | ✅ | 预览页弹菜单 |
| `actioncam.hisilicon.dv.dlg.ConfirmForActivity` | activity | Dialog | ✅ | 通用确认框 |
| `actioncam.hisilicon.dv.dlg.DlgForProcessActivity` | activity | Dialog; configChanges=screenSize\|orientation\|keyboardHidden | ✅ | 进度框（下载中，`…/dlg/DlgForProcessActivity.java:521` 发 `MEDIA_SCANNER_SCAN_FILE`） |
| `actioncam.hisilicon.dv.dlg.DlgForDeleteProcessActivity` | activity | Dialog; 同上 | ✅ | 删除进度框（`:842`） |
| `actioncam.hisilicon.dv.localimage.weight.DlgForDeleteLocalProcessActivity` | activity | Dialog; 同上 | ✅ | 本机删除进度框 |
| `actioncam.hisilicon.dv.dlg.DownloadExceptionActivity` | activity | Dialog | ✅ | 下载失败弹窗 |
| `actioncam.hisilicon.dv.player.VideoControlActivity` | activity | `@android:style/Theme.NoTitleBar.Fullscreen`; configChanges=… | ✅ | 全屏回放播放器（`AudioManager.setStreamVolume` 见 `…/player/HiDVRemoteFilePlayer.java:217`） |
| `actioncam.hisilicon.dv.devicemanage.DeviceManageActivity` | activity | label=@string/device_manage; **exported=false**; portrait | ✅ | 已配对设备管理（`SP 文件 "File"`，`:177`；`WRITE_EXTERNAL_STORAGE` 申请 `:221-222`） |
| `actioncam.hisilicon.dv.live.MainActivity` | activity | Theme.Design.NoActionBar; configChanges=… | ❌ **G6** | — |
| `actioncam.hisilicon.dv.live.TelevisionActivity` | activity | **screenOrientation=landscape** | ✅ | 直播预览（横屏）；内置 `file:///storage/emulated/0/DCIM/ActionCam/download/{a_aba,b_longji,c_mabuer,d_dive}.mp4` 演示视频与 `com.gku.actioncam.hisilicon.android.videoplayer` 外跳（`:367-369`） |
| `actioncam.hisilicon.dv.localimage.AlbumPreviewActivity` | activity | HomeAppTheme; portrait | ✅ | 本机相册预览（`ACTION_SEND` 分享，`:192`） |
| `actioncam.hisilicon.dv.localimage.LocalAlbumActivity` | activity | HomeAppTheme; portrait | ✅ | 本机相册主页（`READ_EXTERNAL_STORAGE` 申请 `:32-33`） |
| `actioncam.hisilicon.dv.localimage.TrackActivity` | activity | CustomActionBar; exported=false; portrait | ✅ | **高德轨迹页**（`AMap/MapView/CoordinateConverter`，`com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:23-32`；清单**无 apikey** → §4 判定半死） |
| `actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditActivity` | activity | CustomActionBar; portrait | ✅ | 图片编辑主页 |
| `actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditClipActivity` | activity | CustomActionBar; portrait | ✅ | 裁剪（`MEDIA_SCANNER_SCAN_FILE`，`:109`） |
| `actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditEffectActivity` | activity | CustomActionBar | ✅ | 滤镜 |
| `actioncam.sigmastar.OldUi.playback.ui.activity.SSDownloadStateDialogActivity` | activity | SSActivityDialog | ✅ | SigmaStar 下载状态弹层 |
| `actioncam.sigmastar.OldUi.playback.ui.activity.SSPlaybackActivity` | activity | CustomActionBar; portrait | ❌ **G3** | — |
| `actioncam.sigmastar.OldUi.playback.ui.activity.SSPhotoRemotePlayActivity` | activity | CustomActionBar; portrait | ❌ **G4** | — |
| `actioncam.sigmastar.OldUi.playback.ui.activity.SSVideoRemotePlayActivity` | activity | CustomActionBar; portrait | ❌ **G5** | — |
| `actioncam.sigmastar.OldUi.playback.model.player.OnlineAndOfflinePlayer` | activity | CustomActionBar; portrait; configChanges=smallestScreenSize\|screenSize\|uiMode\|screenLayout\|orientation\|keyboardHidden\|keyboard | ✅ | 在线/离线统一播放入口（AndroidVideoCache 代理播放） |
| `actioncam.sigmastar.OldUi.preview.ui.activity.HisiActionCameraPreviewActivity` | activity | Theme.Design.NoActionBar; singleTop; configChanges=screenSize\|orientation\|keyboardHidden | ✅ | 老 UI 海思预览；`WRITE_SETTINGS` 消费者 `:1226,1233` |
| `actioncam.sigmastar.OldUi.preview.ui.activity.AmbaActionCameraPreviewActivity` | activity | 同上 | ✅ | 老 UI Ambarella 预览；`WRITE_SETTINGS` `:1215,1222`；`libijkplayer.so` 判断 `:756` |
| `actioncam.sigmastar.OldUi.setting.ui.activity.SSDeviceSettingActivity` | activity | CustomActionBar; portrait | ✅ | 老 UI 设备设置 |
| `actioncam.sigmastar.OldUi.setting.ui.activity.SSModeSettingActivity` | activity | Theme.AppCompat.NoActionBar; singleTop; portrait | ✅ | 老 UI 模式设置 |
| `actioncam.sigmastar.OldUi.setting.ui.activity.SSCameraAboutActivity` | activity | CustomActionBar; portrait | ✅ | 老 UI 关于相机 |
| `actioncam.sigmastar.OldUi.setting.ui.activity.SSBluetoothTXActivity` | activity | CustomActionBar; portrait | ✅ | 蓝牙遥控 TX 配对页（§1.1 #21 的怀疑对象，未见 `startAdvertising`） |
| `actioncam.amba.ui.playback.AmbaDlgOrDeleteActivity` | activity | Dialog; configChanges=screenSize\|orientation\|keyboardHidden | ✅ | Ambarella 回放删除确认 |
| `actioncam.amba.ui.playback.remote.photo.AmbaRemotePhotoActivity` | activity | Theme.Design.NoActionBar | ✅ | 相机端照片远程浏览 |
| `actioncam.amba.ui.playback.remote.video.AmbaRemoteVideoActivity` | activity | Theme.Design.NoActionBar; portrait | ✅ | 相机端视频远程浏览（`http://%s%s`，`:178`） |
| `actioncam.amba.ui.playback.AmbaPlaybackActivity` | activity | Theme.AppCompat.Light.NoActionBar; portrait | ✅ | Ambarella 回放主页（`http://%s%s`，`:275`） |
| `actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingActivity` | activity | Theme.Design.NoActionBar; portrait | ✅ | Ambarella 设备设置 |
| `actioncam.amba.ui.setting.mode_setting.AmbaWorkSettingActivity` | activity | Theme.Design.NoActionBar; portrait | ✅ | Ambarella 工作模式设置 |
| `actioncam.amba.ui.preview.AmbaPreviewActivity` | activity | （无属性） | ✅ | Ambarella 预览主页；RTSP 起流 `rtsp://%s:554/livestream/12`（`:972`）、快门音 `:371,375,379` |
| `actioncam.remote_live.QRShowActivity` | activity | CustomActionBar; portrait | ✅ | 生成分享二维码 |
| `actioncam.remote_live.ScanWifiActivity` | activity | Theme.AppCompat.Light.NoActionBar; portrait | ✅ | 扫码配网（用本机相机，对应 `CAMERA` 权限） |
| `actioncam.remote_live.SelectLiveActivity` | activity | CustomActionBar; **exported=false**; portrait | ✅ | 远程直播入口选择 |
| `actioncam.remote_live.custom.CustomLiveActivity` | activity | CustomActionBar; **exported=false** | ✅ | 自定义 RTMP 直播 |
| `actioncam.amba.ui.stream.StreamConfigActivity` | activity | CustomActionBar; exported=false; portrait | ✅ | 直播参数（分辨率/帧率/码率/RTMP URL）配置，落 `RTMPBean` |
| `actioncam.amba.ui.stream.StreamingActivity` | activity | CustomActionBar; exported=false; portrait | ✅ | 直播推流页（抖音/RTMP） |
| `actioncam.amba.ui.stream.wifi.WIFITypeinActivity` | activity | CustomActionBar; exported=false; portrait | ✅ | 手输直播用 WiFi |
| `actioncam.amba.ui.stream.wifi.WIFIListActivity` | activity | CustomActionBar; exported=false; portrait | ✅ | 直播用 WiFi 列表 |
| `actioncam.sigmastar.upgrade.app.DownloadActivity` | activity | label=@string/action_download; portrait; parentActivityName=…setting.AboutClientActivity | ✅ | App 自升级下载（`UpgradeTaskManager`） |
| `actioncam.sigmastar.upgrade.firm.Ui.UpgradeVersionReadyActivity` | activity | Theme.Design.NoActionBar; portrait | ✅ | 固件升级就绪页（WakeLock `…/firm/Presenter/UpgradePresenter.java:301-302`） |
| `actioncam.sigmastar.upgrade.firm.Ui.UpgradeSendFirmActivity` | activity | Theme.Design.NoActionBar; portrait | ✅ | 固件推送页 |
| `actioncam.sigmastar.videoedit.VideoEditActivity` | activity | CustomActionBar | ✅ | 视频剪辑主页 |
| `actioncam.sigmastar.videoedit.CutActivity` | activity | CustomActionBar; portrait | ✅ | 剪辑（`file://` 拼接 `com/gku/actioncam/sigmastar/videoedit/CutActivity.java:455`） |
| `actioncam.sigmastar.videoedit.AudioCollectActivity` | activity | CustomActionBar; portrait | ✅ | 配乐采集（`RECORD_AUDIO` + LitePal 表 `AudioDbBean`） |
| `actioncam.sigmastar.videoedit.CameraVideoActivity` | activity | CustomActionBar; portrait | ✅ | 剪辑时调本机相机录制 |
| `actioncam.sigmastar.videoedit.VideoShareActivity` | activity | CustomActionBar; portrait | ✅ | 成片分享（`ACTION_SEND`，`:87`） |
| `actioncam.sigmastar.bluetooth.ui.PopupDialogActivity` | activity | popupDialogStyle | ✅ | 蓝牙遥控弹窗；`contains("XTU")` 判定在 `com/gku/actioncam/sigmastar/bluetooth/ui/PopupDialogActivity.java:199` |
| `actioncam.sigmastar.newUi.deviceAdd.Activity.DeviceAddActivity` | activity | CustomActionBar; portrait | ✅ | 配网（BLE 扫描→配对→切 AP），扫描过滤 `:125` |
| `actioncam.sigmastar.newUi.deviceAdd.Activity.DeviceAddNewActivity` | activity | CustomActionBar; portrait | ✅ | 新版配网（`192.168.0.1` 硬编码 `:187`） |
| `actioncam.sigmastar.newUi.deviceAdd.Activity.UserGuideActivity` | activity | CustomActionBar | ✅ | 使用引导（内置 `192.168.0.1` 文案 `:162`） |
| `actioncam.sigmastar.newUi.album.Ui.Activity.ActivityNewPreview` | activity | CustomActionBar; singleTop; portrait | ✅ | 新相册预览（`ACTION_SEND` `:327`） |
| `actioncam.sigmastar.newUi.userCenter.ui.activity.QuestionSelect` | activity | CustomActionBar | ✅ | 常见问题选择 |
| `actioncam.sigmastar.newUi.userCenter.ui.activity.QuestionDescription` | activity | CustomActionBar; portrait | ✅ | 问题详情+反馈（`ACTION_SEND` `:170`；客服邮箱 `:177-230`） |
| `dashcam.icatch.ui.activity.PreviewActivity` | activity | CustomActionBar; portrait | ✅ | **iCatch 行车记录仪**预览 |
| `dashcam.icatch.ui.activity.RemoteMultiPbActivity` | activity | CustomActionBar; portrait | ✅ | 记录仪多路回放 |
| `dashcam.icatch.ui.activity.VideoPb2Activity` | activity | CustomActionBar; portrait | ✅ | 记录仪视频回放 2 |
| `dashcam.icatch.ui.activity.PhotoPbActivity` | activity | CustomActionBar; portrait | ✅ | 记录仪照片回放 |
| `loginmodule.ui.activity.Login_Register_Activity` | activity | CustomActionBar; exported=false; portrait | ✅ | 账号登录/注册（后端 `https://server4.gkuvision.com`） |
| `loginmodule.ui.activity.Report_Feedback_Activity` | activity | CustomActionBar; exported=false; portrait | ✅ | 反馈页（型号 17 项清单，`…/ui/fragment/ReportFeedbackFragment.java:211-227`） |
| `loginmodule.ui.activity.UserInfoActivity` | activity | CustomActionBar; exported=false; portrait | ✅ | 用户资料 |
| `loginmodule.ui.activity.AnnouncementLatestActivity` | activity | CustomActionBar; exported=false; portrait | ✅ | 公告列表（Room `AnnouncementDao`） |
| `loginmodule.ui.activity.WebViewActivity` | activity | CustomActionBar; exported=false; portrait | ✅ | 通用 WebView（协议/活动页） |
| `base.permission.PermissionActivity` | activity | PermissionNiubility_TranslucentTheme; **launchMode=singleInstance** | ✅ | 权限框架的中转页（Yanzhenjie Permission 的 shadow activity）；`ACTION_MANAGE_WRITE_SETTINGS` 分支 `com/gku/base/permission/PermissionActivity.java:60,120` |
| `base.webview.WebViewActivity` | activity | ThemeNoActionBar; exported=false; singleTop; portrait | ✅ | xWebView 容器（`file:///android_asset/` 前缀 `com/gku/base/webview/WebViewUtils.java:201`） |
| `com.my.AppSettingActivity`（包 `com.my`，非 `com.gku`） | activity | ThemeNoActionBar; exported=false; singleTop; portrait | ✅ | iCatch 记录仪侧的设置页（独立包，不在主文档 117 口径内） |
| `cn.rxt.qscase.MainActivity` | activity | IcatchAppTheme; exported=false; portrait | ✅ | XTU Mini1 记录仪主页（iCatch PTP） |
| `cn.rxt.qscase.Main2Activity` | activity | （无属性） | ✅ | 记录仪备用入口 |
| `cn.rxt.qscase.ControlActivity`（全名 `cn.rxt.qscase.ui.camera.ControlActivity`） | activity | IcatchAppTheme; exported=false; portrait; configChanges=screenSize\|orientation\|keyboardHidden | ✅ | 记录仪实时控制页 |
| `cn.rxt.qscase.ui.camera.album.CameraAlbumActivity` | activity | IcatchAppTheme; exported=false; configChanges=… | ✅ | 记录仪端相册 |
| `cn.rxt.qscase.ui.album.AlbumActivity` | activity | 同上 | ✅ | 手机侧相册 |
| `cn.rxt.qscase.ui.camera.preferences.PreferencesActivity` | activity | IcatchAppTheme; exported=false; label=@string/text_settings; configChanges=… | ✅ | 记录仪设置 |
| `cn.rxt.qscase.ui.home.AgreementPermissionActivity` | activity | IcatchAppTheme; exported=false; configChanges=… | ✅ | 记录仪隐私/权限页 |
| `cn.rxt.caeuicore.album.page.preview.VideoPlayerActivity` | activity | ThemeNoActionBar; launchMode=singleTop | ✅ | caeuicore 相册内视频播放 |
| `com.example.icatchplayerlibrary.VideoPbActivity` | activity | IcatchAppTheme; exported=false; configChanges=… | ✅ | iCatch 回放库播放页 |
| `m.mifan.acase.icatch.IcatchVideoPlayerActivity` | activity | （无属性） | ✅ | m.mifan 的 iCatch 播放器 Activity（`IcatchCaseKt.API_HOST_ICATCH = "192.168.1.1"`，`_work/xtu_src/sources/m/mifan/acase/icatch/IcatchCaseKt.java:9`） |

> ✅ = 在 dex 类表与源码树里都能定位；❌ = 幽灵（§2.1 编号）。

### 2.5 第三方/库注册组件：按库分组统计（不逐个展开）

| 库家族 | 组件数 | 类型分布 | 精确构成（`_work/re/xtugo/components.tsv` 逐条计数） | 进程 | 备注 |
|---|---|---|---|---|---|
| 抖音 OpenLive / bytedance | **43** | 42 activity + 1 provider | `com.bytedance.android.dy.sdk.stub.*` 27、`com.bytedance.android.openliveplugin.stub.activity.*` 7、`com.bytedance.android.openlive.broadcast.stub.activity.*` 7、`com.bytedance.android.openliveplugin.process.server.LiveServerManager` 1 provider、`com.bytedance.bdinstall.migrate.*` 1 | 主 + `:bytelive` | 绝大多数是**插件化占位坑位**（stub），不可按业务语义理解；但其中 **3 个是 exported 的抖音授权回调页**（见 §2.6） |
| 字节 lite（live/broadcast） | **35** | 30 activity + 5 provider | `com.byted.live.lite.*` 26 activity + 2 provider、`com.byted.broadcast.lite.*` 4 activity + 3 provider | `:bytelive`/`:push`/`:downloader` | provider 的 authority 命名见 §6.1 |
| 字节 zeus（volcengine） | **3** | 3 provider | `com.volcengine.zeus.servermanager.MainServerManager`、`com.volcengine.zeus.provider.MainProcessProviderProxy`、`com.volcengine.zeus.FileProvider` | 主 | zeus 插件框架的跨进程通道（配置端点见 §4.2） |
| 字节 socialbase downloader | **5** | 5 service | `…downloader.downloader.{IndependentProcessDownloadService,DownloadService,SqlDownloadCacheService}` 3、`…impls.DownloadHandleService` 1、`…notification.DownloadNotificationService` 1 | 主 + `:downloader` | 唯一带 intent-filter 的 service：action `com.ss.android.socialbase.downloader.remote`（`exported=false`） |
| LuckPicture | **4** | 2 activity + 1 service + 1 provider | `com.luck.picture.lib.basic.*` 2 activity、`…basic.PictureFileProvider`、`…service.ForegroundService` | 主 | `ForegroundService` 声明 `foregroundServiceType=location` → 也是 `FOREGROUND_SERVICE` 的一个使用点 |
| Huawei | **4** | 1 activity + 1 service + 2 provider | `com.huawei.hms.hmsscankit.*` 1 activity、`com.huawei.agconnect.core.ServiceDiscovery`、`MLInitializerProvider`、`AGConnectInitializeProvider` | 主 | 与 §3.3 M13–M19 的 scanplus 版本 meta-data 配套 |
| AndroidX | **6** | 1 activity + 2 service + 2 receiver + 1 provider | `androidx.car.app.*` 1 activity、`androidx.camera.core.impl.MetadataHolderService`、`androidx.room.MultiInstanceInvalidationService`、`androidx.car.app.notification.CarAppNotificationBroadcastReceiver`、`androidx.profileinstaller.ProfileInstallReceiver`、`androidx.startup.InitializationProvider` | 主 | `ProfileInstallReceiver` 是**唯一带 `permission` 的导出组件**（`android.permission.DUMP`） |
| Google Play services | **1** | 1 activity | `com.google.android.gms.common.api.*`（授权中转坑位） | 主 | 配合 §3.3 M2 的 Google Maps ke |
| `com.my` | **1** | 1 activity | `com.my.AppSettingActivity` | 主 | **实际是应用自己的页面**，只是包名不在 `com.gku.*` 下：被 `_work/xtu_src/sources/com/gku/HomeActivity.java:136,819` import 并按类名判定栈顶。所以「117 个厂商组件」是下限，按代码归属算应为 118 |

合计 **102**（43+35+3+5+4+4+6+1+1）= 219 总组件 − 117 厂商侧组件（`com.gku.*` 107 + `cn.rxt.*`/`com.example.*`/`m.mifan.*` 10）。分桶规则：按清单里的类名前缀归族，`com.bytedance.*` 与 `com.byted.*` 分列（前者是 OpenLive 插件桩，后者是 live/broadcast lite 宿主桩）。y 与 M12 的 `com.google.android.gms.version` |

合计 **101**（43+35+3+5+4+4+6+1），与 §2.0 表格一致。

### 2.6 exported 组件：**7 个**（不是 3 个）

对 `_work/re/xtugo/components.tsv` 第 4 列 grep `exported=true`，命中 **7 行**：

| # | 组件 | 类型 | 归属 | intent-filter | 权限保护 | 外部可否触发 |
|---|---|---|---|---|---|---|
| E1 | `com.gku.actioncam.hisilicon.dv.ui.WelcomeActivity` | activity | **厂商** | `MAIN` + `LAUNCHER` | 无 | ✅ |
| E2 | `com.gku.gkucamplayer.GKUCamPlayer` | activity | **厂商** | **无** | 无 | ✅（显式组件名） |
| E3 | `com.bytedance.android.dy.sdk.stub.VideoAuthorizeActivityProxy` | activity | 抖音 | **无** | 无 | ✅（显式组件名） |
| E4 | `com.bytedance.android.openliveplugin.stub.activity.DouyinAuthorizeActivityProxy` | activity | 抖音 | **无** | 无 | ✅ |
| E5 | `com.bytedance.android.openliveplugin.stub.activity.DouyinAuthorizeActivityLiveProcessProxy`（`process=:bytelive`） | activity | 抖音 | **无** | 无 | ✅ |
| E6 | `com.bytedance.android.openlive.broadcast.stub.activity.DouyinAuthorizeActivityProxy` | activity | 抖音 | **无** | 无 | ✅ |
| E7 | `androidx.profileinstaller.ProfileInstallReceiver` | receiver | AndroidX | 4 个 `androidx.profileinstaller.action.*` | **`android.permission.DUMP`** | ❌ |

→ 3 个结论：
1. **厂商导出的确实只有 2 个**（E1 启动器、E2 播放器）——主文档 §1.4 的说法在**厂商范围内正确**。
2. 但「全 App exported=true 只有 3 个」**错**：还有 4 个**抖音 OAuth 授权回调页**（E3–E6）也是导出的、且**无权限保护** —— 这是抖音登录回跳必需的，属于设计如此。
3. **未写 `android:exported` 的组件**（`GKUCamPlayer` 之外的所有无 filter activity/service，含幽灵 G1 `com.gku.CameraSocketService`）在 targetSdk=35 下默认 **false**（Android 12 起若真有 filter 而未声明 exported 会安装失败，本包能装说明清单是自洽的）。

---

## 3. `<application>` 属性与实际后果

清单属性原样：`_work/re/xtugo/manifest.md:26-43`（14 条，全部列出）。

### 3.1 逐属性

| 属性 | 值 | 在这个 App 里的**实际**后果（含证据行） |
|---|---|---|
| `name` | `com.gku.BaseApplication` | `@HiltAndroidApp`；`onCreate` 顺序见 `_work/xtu_src/sources/com/gku/BaseApplication.java:41-57`。任何互操作实现**不需要**复刻它，但它决定 `LogEx`/`CrashHandler` 等副作用存在 |
| `usesCleartextTraffic` | `true` | 相机侧全 `http://192.168.0.1/...`（`com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:57`、`com/gku/actioncam/hisilicon/dv/ui/data/connect/ConnectDevice.java:44`）必须明文；**同时无差别放开**了 `http://121.40.107.215:8041/firmware/`、`http://www.gkuvision.com:8882/...`、`http://api.shhc-yh.com/...`、`http://api.dashcamplayer.net/...` 四个公网明文口 |
| `networkSecurityConfig` | `@xml/network_security_config` | **实际内容与 `usesCleartextTraffic` 完全重复**，全文见 §3.2 → 没有任何 domain 白名单、没有 pin、没有 debug 覆盖 |
| `allowBackup` | `true` | `adb backup` 可导出 `/data/data/com.gku.xtugo`：含 `com.gku.xtugo.xml`（**明文 `bt_pin<设备名>` BLE 配对码**，`com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:906,909`）、`SaveSsidAndPwd`（相机 WiFi 凭据 StringSet，`com/gku/actioncam/hisilicon/dv/ui/data/SharedPreferencesUtils.java:26,33`）、`RTMPBean`（含 `pwd` 与推流地址） |
| `fullBackupOnly` / `dataExtractionRules` | **未声明** | targetSdk=35 却只有 `allowBackup=true` → 走旧的 `adb backup` 全量语义 |
| `requestLegacyExternalStorage` | `true` | Android 10 退回旧存储，`/DCIM/xtugo/…` 绝对路径写法仍可用（`com/gku/base/utils/Common.java:170-176`）；Android 11+ 由 `MANAGE_MEDIA`/`READ_MEDIA_*` 兜（但 `MANAGE_MEDIA` 无消费者，见 §1.1 #6） |
| `hardwareAccelerated` | `true` | 与 `uses-feature GLES2 required=true` 一致 |
| `supportsRtl` | `true` | `res` 里有 `drawable-ldrtl-*` |
| `extractNativeLibs` | `false` | `.so` 以 embedded 留在 APK 内（`_work/re/xtugo/natives.md` 的 31 个库）；对协议无影响，但**直接 `dlopen` APK 内路径**是官方行为，我们只读不解包 |
| `allowNativeHeapPointerTagging` | `false` | 关掉 MTE 式堆指针标记，兼容 iCatch/高德的 native |
| `theme` / `label` / `icon` / `roundIcon` | `@style/AppTheme` / `XTU GO` / `@mipmap/icon` / `@mipmap/icon_round` | `manifest.md:29-31` |
| `appComponentFactory` | `androidx.core.app.CoreComponentFactory` | Hilt 依赖 |
| `testOnly` | **未声明**（=false） | 这是**release 签名包**，可直接装机复现 |

`installLocation=default`（`manifest.md:21`）；`minSdk/targetSdk = 23/35`、`platformBuildVersion 34/14`（`manifest.md:18-25`）。清单里**没有** `android:maxSdkVersion` 于 `<uses-sdk>`，`maxSdkVersion` 只出现在**权限级**（3 条：`WRITE_EXTERNAL_STORAGE`=29、`BLUETOOTH`=30、`BLUETOOTH_ADMIN`=30，见 `_work/re/xtugo/manifest.md:50,64,65`）。

### 3.2 `res/xml/network_security_config.xml` 全文（逐条）

`_work/xtu_res/resources/res/xml/network_security_config.xml`（共 4 行）：

```xml
<network-security-config>
    <base-config cleartextTrafficPermitted="true"/>
</network-security-config>
```

| 维度 | 内容 | 判定 |
|---|---|---|
| 域名条目（`<domain>` / `<domain-config>`） | **无（0 条）** | 没有任何域名被单独收口 |
| cleartext | `base-config cleartextTrafficPermitted="true"` → **全局明文放行** | 与 `usesCleartextTraffic=true` 冗余 |
| 证书固定（`<pin>` / `certificate-transparency`） | **无（0 条）** | 全 App 无 pin，公网四域名可被中间人 |
| trust-anchors | **未声明** → 系统默认（user + system CA 的 system 部分） | 用户 CA 默认**不放行**（release 包） |
| debug-overrides | **无** | — |

旁边还有一个**未被清单引用**的 `network_config_base.xml`（`_work/xtu_res/resources/res/xml/network_config_base.xml`，共 9 行）：

```xml
<network-security-config>
    <base-config cleartextTrafficPermitted="true"/>
    <debug-overrides>
        <trust-anchors><certificates src="user"/></trust-anchors>
    </debug-overrides>
</network-security-config>
```

→ 说明厂商**写过**带 debug 用户 CA 的版本（可配合 mitmproxy 抓包），但最终 manifest 指向的是**没有** `debug-overrides` 的那份。抓包侧因此必须在 release 上装用户 CA 才行不通，需 frida 绕过 —— 这是 §4 判定只能靠静态的原因。

### 3.3 `<application>` 级 meta-data：**19 条（主文档与 manifest.md 都记成「没有」）**

⚠️ **取证工具缺陷**：`_work/re/xtugo/manifest.md:418-428` 的「全应用 meta-data」表只收了 **7 条组件级**（CameraX、两个 FileProvider 的 `FILE_PROVIDER_PATHS`、4 条 `androidx.startup`），**把全部 19 条 `<application>` 直接子 `<meta-data>` 漏掉了**（原始文件 `_work/xtu_res/resources/AndroidManifest.xml`，8 空格缩进项）。表观现象就是主文档 §8 写下「manifest 里没有任何 meta-data」。**下表按原始 XML 行号逐条列出**：

| # | name | value（原样） | 行号（`_work/xtu_res/resources/AndroidManifest.xml`） | 判定 |
|---|---|---|---|---|
| M1 | `UMENG_CHANNEL` | `product_GooglePlay` | `:123` | **在用的渠道号**：`_work/xtu_src/sources/com/gku/crashhandle/CrashReportManager.java:40` 读它并 `setAppChannel(...)`（`:45`）→ 主文档「必然抛 NameNotFoundException」**不成立**，见 §8 C-09 |
| M2 | `com.google.android.geo.API_KEY` | `AIzaSyAu4dYAjvpBVwWJtUKB19MEnQ5MsKn2bPE` | `:272` | **Google Maps key 明文存在**。与 `com/gku/base/utils/LocationUtil.java` 用 Play Services `FusedLocationProviderClient` 相配；**它不是高德 key**（`com.amap.api.v2.apikey` 确实 0 命中） |
| M3 | `m.mifan.acase.GlideExModule` | `GlideModule` | `:599` | iCatch 侧的 Glide 模块注册 |
| M4 | `ZEUS_PLUGIN_VIDEO` | `{apiVersionCode:310, packageName:com.byted.saas.video, minPluginVersion:20006, maxPluginVersion:99999, appKey:'14adbdb906c0a8c1601ecb546737bc80', appSecretKey:'a337bb0a0445d2b6cb75c0c86427ab2a', isSupportLibIsolate:true, dependentPackage:com.byted.ttm.player, signature:'MIIDSTCCAjGg…(2048-bit 证书 DER 的 base64)'}` | `:646` | **字节 zeus 插件描述符（含 appKey + appSecretKey 明文）** |
| M5 | `VIDEO_API_VERSION_CODE` | `310` | `:649` | 与 M4 配对 |
| M6 | `ZEUS_PLUGIN_COMMON_TTM_PLAYER` | `{apiVersionCode:310, packageName:com.byted.ttm.player, minPluginVersion:10000, maxPluginVersion:10099, appKey:'b759a5c22d90020d40d5450cf6abee55', appSecretKey:'3298eca929aa69b7104aac236f54abde', isSupportLibIsolate:true, internalVersionCode:1, signature:'同上'}` | `:785` | 同上 |
| M7 | `ZEUS_PLUGIN_LIVE` | `{apiVersionCode:3100, packageName:com.byted.live.lite, minPluginVersion:211400, maxPluginVersion:999999, isSupportLibIsolate:true, appKey:'edc32eaa174b15a7a3771c37b451c080', appSecretKey:'2f906bdb2f32468a63c2fed4afd1e82e', signature:'同上'}` | `:788` | **直播插件**（§2.5 的 `:bytelive` 进程） |
| M8 | `LIVE_API_VERSION_CODE` | `3100` | `:791` | 与 M7 配对 |
| M9 | `ZEUS_PLUGIN_BROADCAST` | `{apiVersionCode:310, packageName:com.byted.broadcast.lite, minPluginVersion:30000, maxPluginVersion:99999, isSupportLibIsolate:true, appKey:'63fed49bd0bad946b0886802de2fe8a4', appSecretKey:'50011b4cf949a84aa9c6d3e11093a6aa', signature:'同上'}` | `:1010` | **推流插件**；抖音 AppKey `"780679"`（§4.5）与这四个 zeus appKey 是**两套不同的标识** |
| M10 | `BROADCAST_API_VERSION_CODE` | `310` | `:1013` | 与 M9 配对 |
| M11 | `com.bumptech.glide.integration.okhttp3.OkHttpGlideModule` | `GlideModule` | `:1116` | Glide-OkHttp 桥 |
| M12 | `com.google.android.gms.version` | `@integer/google_play_services_version` | `:1123` | Play Services 版本协商（配合 M2） |
| M13 | `huawei_module_scankit_local` | `21200301` | `:1184` | HMS ScanKit 本地版本 |
| M14 | `huawei_module_scankit_sdk_version` | `scanplus:2.12.0.301` | `:1187` | 同上 |
| M15 | `com.huawei.hms.client.service.name:scanplus` | `scanplus:2.12.0.301` | `:1190` | GMS/HMS 服务名注册（**这解释了 §4.2 判定 B：HMS 只有 scanplus，没有 appId**） |
| M16 | `com.huawei.hms.min_api_level:scanplus:huawei_module_scankit` | `1` | `:1193` | 同上 |
| M17 | `com.huawei.hms.min_api_level:scanplus:hmscore` | `1` | `:1196` | 同上 |
| M18 | `com.huawei.hms.client.service.name:dynamic-api` | `dynamic-api:1.0.24.300` | `:1203` | HMS 动态加载 |
| M19 | `com.huawei.hms.min_api_level:dynamic-api:huawei_module_dynamicloader` | `10` | `:1206` | 同上 |

**关键负面事实（这些才是主文档结论的正确部分）**：清单里**确实没有** `com.amap.api.v2.apikey`（高德）、**没有** `com.huawei.hms.client.appid`（HMS 应用 ID）、**没有** 任何 QQ/微信 AppID、**没有** Bugly 以外的上报配置。
四个 `ZEUS_PLUGIN_*` 的 `signature` 值完全相同（同一张 2048-bit RSA 证书，主体字段全是占位的 `1111`），是**插件签名校验材料**，不是厂商自己的签名。

### 3.4 组件级 meta-data（7 条，`_work/re/xtugo/manifest.md:418-428` 唯一记全的部分）

| 挂载点 | name | value |
|---|---|---|
| `service:androidx.camera.core.impl.MetadataHolderService` | `…MetadataHolderService.DEFAULT_CONFIG_PROVIDER` | `androidx.camera.camera2.Camera2Config$DefaultProvider` |
| `provider:com.gku.base.BaseFileProvider` | `android.support.FILE_PROVIDER_PATHS` | `@xml/paths_base` |
| `provider:com.luck.picture.lib.basic.PictureFileProvider` | `android.support.FILE_PROVIDER_PATHS` | `@xml/ps_file_paths` |
| `provider:androidx.startup.InitializationProvider` | `androidx.emoji2.text.EmojiCompatInitializer` | `androidx.startup` |
| 同上 | `androidx.lifecycle.ProcessLifecycleInitializer` | `androidx.startup` |
| 同上 | `androidx.profileinstaller.ProfileInstallerInitializer` | `androidx.startup` |
| 同上 | `com.king.logx.initialize.LogXInitializer` | `androidx.startup` |

另有 7 条 `<activity>`/`<service>` 级 meta-data 在原文件 `:611, :630, :1105, :1130, :1133, :1136, :1139`（12 空格缩进，属组件级），内容为 `parentActivityName`/`android.support.PARENT_ACTIVITY` 与字节插件的进程参数 —— 与 §2.4 表里的 `parentActivityName` 一致。

### 3.5 `res/xml/` 全量（7 个文件）

其余 `res/xml/`：`paths_base.xml`（FileProvider，见 §6）、`ps_file_paths.xml`（LuckPicture）、`file_paths.xml`（**未被清单引用**）、`preferences.xml` + `settingpreferences.xml`（主文档 §4.3 的**老方言静态设置表**，其宿主 `SettingPreferActivity`/`PreferActivity` 已成幽灵 G7/G8 —— 资源还在，代码没了）。清单目录见 `_work/xtu_res/resources/res/xml/`（7 个文件，已全数列出于此）。

---

## 4. 域名与端点判定表

### 4.0 判定方法与口径

素材：`_work/re/xtugo/signals-fullUrls.tsv`（141 行，含表头 → 140 条）+ `_work/re/xtugo/signals-hosts.tsv`（501 条）+ `_work/re/xtugo/own-literals.tsv`（厂商全量字符串）+ 库源码里 `"http…"` 字面量 + `_work/re/xtugo/natives-strings.tsv` 的 `url` 类。去重后 **URL 26 条 + 主机/IP 14 条 + SDK 端点 40 条**。

> ⚠️ `signals-hosts.tsv` 里**没有任何公网域名**（`grep gkuvision|amap|aliyuncs|bugly|douyin|volc` 全 0 命中，实测见 §9 U3）。它的 501 条其实是「点号分隔的标识符」：`xxx.db`、`xxx.kt`、`cgi` 文件名、`com.android.*` 包名、`BuildConfig` 的包名。**不要把它当域名表用**。

判定四档：

| 档 | 依据 |
|---|---|
| **A 运行时会访问** | 有厂商代码调用点（不只是常量），且调用者在可达路径上 |
| **B 库会访问（条件触发）** | 只有第三方库调用；触发条件写清（机型/页面/插件进程） |
| **C 库里死字符串** | 只作为常量/日志文案存在，全树无消费者 |
| **D 死常量（厂商侧）** | 厂商 `static final` 常量存在，但 grep 无任何使用点 |

### 4.1 厂商自有后端与页面（逐条）

| URL / 主机 | 出现在（全路径:行） | 归属 | 判定与依据 |
|---|---|---|---|
| `https://server4.gkuvision.com` | `_work/xtu_src/sources/com/gku/module_base_xtugo/BuildConfig.java:8`（`URL_SERVER`）；`com/gku/module_base_xtugo/api/ApiUtils.java:12`；`com/gku/loginmodule/network/NetworkApi.java:44` | 厂商主后端 | **A**：`NetworkApi` 在 `com/gku/BaseApplication.java:53` 的 `NetworkApi.init(new NetworkRequiredInfo(this))` 链上，Retrofit base url |
| `https://server4.gkuvision.com/push/api/getNewestVersion?firmWareModel=XTUGO_Android` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/upgrade/app/UpgradeViewManager.java:648` | 厂商 App 升级 | **A**：升级弹窗路径，`ACTION_VIEW`(`:639`)/`INSTALL_PACKAGE`(`:634`) 紧随其后 |
| `https://server4.gkuvision.com/push/api/getNewestVersion?firmWareModel=` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/upgrade/firm/Presenter/UpgradePresenter.java:165` | 厂商**固件**版本查询 | **A**：`UpgradePresenter` 由 `…/firm/Ui/*` 页面驱动 |
| `http://121.40.107.215:8041/firmware/` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/upgrade/app/UpgradeTaskManager.java:35`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/updateapp/UpgradeManager.java:35` | 厂商固件目录（**裸 IP + 明文**） | **A**：两处都是 `getMatchedFirmware`/`serverHaveLatestAPK` 的基址（调用者 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/setting/AboutCameraActivity.java:41`、`…/dv/updateapp/DownloadActivity.java:89,128,180,184`） |
| `http://121.40.107.215:8041/firmware/info.json` | `com/gku/actioncam/sigmastar/upgrade/app/UpgradeTaskManager.java:843`；`…/dv/updateapp/UpgradeManager.java:843` | 固件清单 | **A**：`com/gku/actioncam/hisilicon/dv/updateapp/DownloadActivity.java:89` 把返回串交给 `UpgradeManager.parseServerFileList(string)` |
| `http://www.gkuvision.com:8882/upload/update.xml` | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:22`（`API_APP_SERVICE_HOST_IP`）；消费者 `com/gku/rxt/net/AppService.java:101` | iCatch/记录仪线的 App 更新 | **A（条件）**：仅 `com.gku.rxt`（iCatch 记录仪）流程；协议是明文 XML |
| `http://api.shhc-yh.com/api/` | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:23`（`API_FW_SERVICE_HOST_IP`） | 第三方托管（上海环创？） | **D 死常量**：除 `com/gku/rxt/net/AppService.java:40` 的 Kotlin `@Metadata` 反射元数据外，**全树零消费者**（`grep -rn API_FW_SERVICE_HOST_IP` 只有声明行） |
| `http://api.shhc-yh.com/` | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:24`（`API_SERVICE_HOST_IP`） | 同上 | **D 死常量**：同上，无消费者 |
| `http://api.dashcamplayer.net/api/aliyun/uptoken` | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:97`（`postJson`） | **阿里云 STS 下发口** | **A**：`ossPost` 的唯一调用者是 `_work/xtu_src/sources/com/gku/HomeActivity.java:843` `AppService.INSTANCE.getInstance().ossPost(...)`，回调 `:859` 建 `OSSClient` |
| `https://device.gkuvision.com/static/xtugo_privacy_cn.html` | `_work/xtu_src/sources/com/gku/module_my/ConstantsMy.java:10` | 隐私政策 | **A**：`com/gku/actioncam/hisilicon/dv/setting/PrivacyAgreementActivity.java:58`、`com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment2.java:675` |
| `https://device.gkuvision.com/static/xtugo_privacy_en.html` | `com/gku/module_my/ConstantsMy.java:12` | 同上（英文） | **A**：`com/gku/actioncam/hisilicon/dv/setting/PrivacyAgreementActivity.java:63`、`com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment2.java:677` |
| `https://device.gkuvision.com/static/xtugo_useragreement_cn.html` | `com/gku/module_my/ConstantsMy.java:14` | 用户协议 | **A**：`com/gku/actioncam/hisilicon/dv/setting/PrivacyAgreementActivity.java:56` |
| `https://device.gkuvision.com/static/xtugo_useragreement_en.html` | `com/gku/module_my/ConstantsMy.java:16` | 同上 | **A**：`com/gku/actioncam/hisilicon/dv/setting/PrivacyAgreementActivity.java:61` |
| `https://play.google.com/store/apps/details?id=com.gku.yutupro` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/setting/AboutClientActivity.java:164` | 跳**另一品牌** App | **A**：与 `queries{com.gku.yutupro}`（`_work/re/xtugo/manifest.md:113-120`）配套 |
| `http://www.xtucam.com/index.php?r=article/Category/index&class_id=19` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:212` | 官网（**明文 HTTP**） | **A**：用户中心列表项，点击走 WebView |
| `https://www.xtucam.com/index.php?r=article/Category/index&class_id=19` | `com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:224` | 官网（社交区？HTTPS 版） | **A**：同列表另一项 |
| `https://m.weibo.cn/p/1005055290451249` | `com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:208` | 微博主页 | **A（仅外链）** |
| `https://www.facebook.com/` | `com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:219`；`_work/xtu_src/sources/com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java:203` | 社媒 | **A（仅外链）**，无具体账号 |
| `https://www.youtube.com/` | `com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:221`；`com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java:204` | 社媒 | **A（仅外链）** |
| `https://shop183741064.m.taobao.com` | `com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:204` | 淘宝店 | **A（仅外链）** |
| `https://xtucp.tmall.com/?spm=a1z10.3-b-s.w20166435-22198852064.1.35dc182aeGhCvE&scene=taobao_shop` | `com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:205`；`com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java:198` | 天猫店 | **A（仅外链）** |
| `https://h5.m.jd.com/dev/RLVegkgjdNJoM4Y1WsvAnKLD7Qw/index.html?appurl=https%3A%2F%2Fshop.m.jd.com%3FshopId%3D807701%26utm_source%3Dpdappwakeupup_20170002` | `com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:206`；`com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java:199` | 京东店（shopId 807701） | **A（仅外链）** |
| `https://z.douyin.com/p53t?scheme=snssdk1128%3A%2F%2Fgoods%2Fstore%3Fsec_shop_id%3DQMnJSSw%26entrance_location%3Ddou_shop_ad_101_2%26tab_id%3D16%26url_maker%3Dshop_sdk` | `com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java:200` | 抖音店（`sec_shop_id=QMnJSSw`）；含 **`snssdk1128://` 深链** | **A（仅外链）** |
| `http://mobile.yangkeduo.com/mall_page.html?mall_id=640975089 ` | `com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java:201` | 拼多多店（**注意原串尾部有一个空格**） | **A（仅外链）** |
| `https://www.baidu.com` | `_work/xtu_src/sources/com/gku/HomeActivity.java:2077` | 兜底外链 | **A**：WebView 兜底 |
| `http://www.google.com/` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/UserCenterWebView.java:37` | 默认首页 | **A（国内不可达）**：作为该 WebView 的初始 url 常量 |
| `http://i2.hdslb.com/bfs/archive/1808cdd9100aebc15b3c889d71755072dc475bdf.jpg` | `_work/xtu_src/sources/m/mifan/acase/core/EmptyCase.java:103` | B 站图床 | **C**：出现在 `EmptyCase`（空实现占位类）里，非业务图 |
| `https://github.com/danikula/AndroidVideoCache/issues/{43,88,134}` | `_work/xtu_src/sources/com/gku/videocache/HttpUrlSource.java:108,111`；`com/gku/videocache/Pinger.java:54` | 开源库报错文案 | **C 死字符串**：纯 log 文案 |
| `http://schemas.android.com/apk/res/android` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/TabLayout/SegmentTabLayout.java:104` | Android 命名空间 | **C**：`obtainAttributes` 用，不发网络 |

**厂商自有域名去重结果**：`gkuvision.com`（server4 / device / www:8882 三个子域）、`xtucam.com`、`shhc-yh.com`（死）、`dashcamplayer.net`、`xtucam.com`（邮箱域）、以及电商/社媒外链 9 条。

### 4.2 第三方 SDK 端点（逐条归类）

**腾讯 Bugly** —— **A（真在用）**：初始化在 `_work/xtu_src/sources/com/gku/crashhandle/CrashReportManager.java:14-45`，AppId 来自 `_work/xtu_src/sources/com/gku/xtugo/BuildConfig.java:7`。native 侧 `libBugly_Native.so`（`_work/re/xtugo/natives.md`）。

| 端点 | 出现处 | 判定 |
|---|---|---|
| `https://android.bugly.qq.com/rqd/async` | Bugly SDK 内（`com/qq/e/bugly/**`） | **A**：崩溃/ANR 上报主通道 |
| `https://h.trace.qq.com/kv` | Bugly SDK 内 | **B**：Trace 子模块，需显式开启 |

**阿里云 OSS / STS** —— **A（真在用，但端点是运行期下发的）**：`_work/xtu_src/sources/com/gku/HomeActivity.java:859`
`new OSSClient(this, data.getEndpoint(), new OSSStsTokenCredentialProvider(data.getAccess_key(), data.getAccess_secret(), data.getSecurity_token()))`
→ **APK 里没有任何硬编码 endpoint / bucket / AK / SK**；三元组由 `api.dashcamplayer.net/api/aliyun/uptoken` 下发（§4.1）。

| 常量 | 出现处 | 判定 |
|---|---|---|
| `"location-readonly.aliyuncs.com"` | `com/aliyun/oss/**` | **B**：STS 走 `assumeRole` 时才查区域列表 |
| `"location-inner.aliyuncs.com"` | `com/aliyun/oss/**` | **C**：内网域，海外构建不可达 |
| `"oss-cn-beijing"` / `-hangzhou` / `-hongkong` / `-qingdao` / `-shenzhen` | `com/alibaba/sdk/android/oss/**` 区域表 | **B**：仅当服务端返回这些 region 才拼出 `bucket.oss-cn-xxx.aliyuncs.com` |
| `com.aliyun.oss.internal.OSSConstants.PROTOCOL_HTTP`（值 `"http://"`） | 被厂商**当字符串常量到处拼相机 URL**，实测 4 处：`_work/xtu_src/sources/com/gku/rxt/net/CheckAppVersionUtils.java:324`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:311`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:143,181`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:332` | **C（巧合复用，无任何 OSS 网络含义）**：⚠️ 互操作时**不要**把它当 OSS 依赖，只是 `http://` 的别名常量 |

**高德 AMap（地图 v10.0.600）** —— **B（会发请求，但因无 key 必然鉴权失败）**：
Java 侧真实使用 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:389,497,667`（`addMarker`/`animateCamera`/`addPolyline`）；
`ServiceSettings`/`MapsInitializer.setApiKey` **全树 0 命中**，19 条 `<application>` 级 meta-data 全表（§3.3）里**无 `com.amap.api.v2.apikey`** → 鉴权必失败。

| 端点 | 出现处（包） | 判定 |
|---|---|---|
| `https://restsdk.amap.com/v3/iasdkauth` | `com/amap/api/**` | **A（一定发）**：SDK 启动即鉴权，失败即无图 |
| `https://restapi.amap.com/rest/aaid/get`、`http://restapi.amap.com/rest/aaid/get` | `com/amap/**` | **B**：广告标识 |
| `http://restsdk.amap.com/sdk/compliance/params`、`https://restsdk.amap.com/sdk/compliance/params` | `com/amap/**` | **B**：合规配置 |
| `http://restsdk.amap.com`、`/v3/geocode/regeo`、`/v3/config/district?`、`/v3/place/around?`、`/v3/place/text?`、`/v4`、`/v4/grasproad/driving?`、`/v4/gridmap?`、`/rest/lbs/dem/data?z=%d&x=%d&y=%d&type=2` | `com/amap/api/**` | **B/C**：导航与搜索子功能，本 App 只用 `CoordinateConverter`+画线 → 多数不会发 |
| `https://restapi.amap.com/rest/lbs/geohub/3d/tiles?z=%d&x=%d&y=%d&id=` | `com/amap/**` | **C** |
| `http://apilocate.amap.com/mobile/binary`、`http://dualstack-a.apilocate.amap.com/mobile/binary`、`http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&` | `com/amap/**`、`com/autonavi/aps/**` | **B**：定位 SDK 的采集口（`com/autonavi/aps/amapapi/restruct/e.java:200,241` 会 `checkSelfPermission(READ_PHONE_STATE)`） |
| `http://adiu.amap.com/ws/device/adius` | `com/amap/**` | **B**：设备唯一标识 |
| `http://m5.amap.com/`、`http://mpsapi.amap.com/`、`http://mst01.is.autonavi.com/appmaptile?z=%d&x=%d&y=%d&lang=zh_cn&size=1&scale=1&style=6`、`http://wprd0%d.is.autonavi.com/appmaptile?`、`http://wap.amap.com/` | `com/amap/api/**` + native（见 §7.1） | **B**：栅格瓦片；无 key 时被鉴权拦 |
| `https://dualstack-arestapi.amap.com/v3/iasdkauth`、`http://dualstack-arestapi.amap.com/v3/geocode/regeo` | `com/amap/**` | **B**：IPv6 双栈回退 |

**字节系（抖音 OpenLive / zeus / volcengine / APMPlus）** —— **B（仅 `:bytelive` / `:push` / `:downloader` 三个插件进程）**：
抖音 AppKey 与初始化：`_work/xtu_src/sources/com/gku/actioncam/amba/ui/stream/DouyinStreamController.java:158`
`DouYinSDK.getInstance().init(new SdkInitConfig.Builder(app, "780679", "XTU GO", BuildConfig.VERSION_NAME, 243L).isDebug(true) …)`
→ 只有 **Ambarella 机型**的直播页可达（`StreamingActivity`/`StreamConfigActivity`，§2.4）。

| 端点 | 出现处 | 判定 |
|---|---|---|
| `https://apmplus.volces.com/settings/get`、`https://apmplus.volces.com/monitor/collect/c/performance/`、`http://apmplus.volces.com/apm/device_register`、`http://apmplus.volces.com/monitor/collect/c/session` | `com/volcengine/zeus/**` | **B**：zeus 配置+性能上报，随直播插件进程启动 |
| `https://dispatch-api-online.vemarsdev.com/settings/get`、`https://dispatch-api-online.vemarsdev.com/monitor/collect/c/performance/`、`https://zeus-api.vemarsdev.com/zeus/client/v2/query` | `com/volcengine/zeus/**` | **B（备用域，海外构建）** |
| `snssdk1128://goods/store?sec_shop_id=QMnJSSw&…` | `com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java:200`（URL 编码在 https 短链里） | **A（外链）**：拉起抖音 App |

**APM Insight（`libapminsighta.so`/`libapminsightb.so`）** —— **B（条件）**：Java 侧只有文件路径自举，`_work/xtu_src/sources/com/apm/insight/h/b.java:16,20,76,96`（`filesDir/apminsight/selflib/lib<name>.so`）、`com/apm/insight/c/a.java:10`、`c/b.java:26`（`apminsight/crashCommand`）、`com/apm/insight/k/o.java:30,92`（`apminsight/configCrash/configFile`）、`com/apm/insight/l/a.java:207`（`getRunningTasks(1)` 判前台）。
→ **厂商代码里没有任何 `ApmInsight.init`**（grep 0 命中），因此它只有在抖音/zeus 插件被拉起时才可能由 dex 自举加载；**主进程单独使用相机功能时不会访问**。这与主文档 §8「未见 Java 初始化」一致，可判定为 **C（本 App 场景下）**。

**华为 HMS / ML Kit / AGConnect（GRS）** —— **B（仅文档扫描）**：清单只有两个 provider（`MLInitializerProvider`、`AGConnectInitializeProvider`，`_work/re/xtugo/manifest.md` provider 表），无 `com.huawei.hms.client.appid` 之类 meta-data → **无 appId，GRS 路由拿不到服务**。

| 端点 | 出现处 | 判定 |
|---|---|---|
| `https://grs.dbankcloud.com` / `.cn` / `.asia` / `.eu`、`https://grs.platform.dbankcloud.ru`，查询模板 `/grs/1.0/%1$s/router`、`/grs/2.0/router`，`grs_query_timeout=2` | `_work/xtu_assets/assets/grs_sdk_server_config.json`（19 行，全文见 §7.2） | **B**：无 appId → 一定返回空路由 |

**Google Play Services（Ads ID）** —— **B**：`_work/xtu_src/sources/com/gku/base/utils/AdvertisingIdClient.java:40,43`、`com/gku/base/utils/GoogleAdvertisingIdUtils.java:21,24` 绑定 `com.google.android.gms/.ads.identifier.service.ADVERTISINGIDSTARTSERVICE` 类 intent；无网络直连。

**抖音/优酷/京东等电商外链**：见 §4.1 的 6 行，全部 **A（仅外链，不发 API）**。

**MSA / OAID（`ca.da.da.*`、`com/bun/miitmdid`）** —— **B（仅华硕机型）**：`_work/xtu_src/sources/ca/da/da/a.java:13,25,45` 绑 `com.asus.msa.SupplementaryDID`；对应权限 `com.asus.msa.SupplementaryDID.ACCESS`（§1.1 #38）。无域名（Binder 跨进程）。

### 4.3 相机侧（本地）URL 模板：全部 scheme 常量

`_work/re/xtugo/signals-fullUrls.tsv` 里 `http://%s…` 共 66 条，逐条语义已在 `docs/evidence/xtugo 附录A（海思 CGI 全表）`；此处只登记**模板与出处**，并按前缀归类：

| 模板 | 出处（全路径:行） | 用途 |
|---|---|---|
| `http://%s%s%s` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:36`、`…/dv/biz/RemoteFileManager.java:14` | 海思 CGI 总模板（ip + `/cgi-bin/hi3510/` + cmd） |
| `http://%s%s/<cgi>?` ×39 | `com/gku/actioncam/hisilicon/dv/biz/Setting.java:30,34,38,45,89,122,131,137,141,145,149,153,183,187,191,195,199,203,207,211,215,219,223,227,238,245,252,256,260,264,268,276,280,284,288,326,330,334,338,342,346,350,354,358,464,514,518,522,526,530,534,538,542,546,550`、`…/biz/RemoteFileManager.java:20,33,46,50,54,58,62` | 全部海思/ SigmaStar CGI（见 CGI 全表） |
| `http://%s%s` | `com/gku/actioncam/amba/ui/playback/AmbaPlaybackActivity.java:275`、`…/amba/ui/playback/remote/video/AmbaRemoteVideoActivity.java:178`、`com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:115`、`_work/xtu_src/sources/com/gku/amba/AmbaCameraRecordFragment.java:220`、`_work/xtu_src/sources/com/gku/hisi/Hisi_CameraRecordFragment.java:189` | 文件下载/在线播放直链（RecordFragment 两处取自 `getPlayPath`，MP4→LRV 预览流） |
| `http://%s/%s` | `com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:87`、`_work/xtu_src/sources/com/gku/amba/AmbaCameraRecordFragment.java:222`、`_work/xtu_src/sources/com/gku/hisi/Hisi_CameraRecordFragment.java:191`、`com/gku/module_camera/hisi/HisiDownloader.java:200` | 海思「去扩展名 + `.THM`」缩略图/文件；RecordFragment 两处在 `getPlayPath` 中把 MP4→LRV 预览播放 |
| `http://%s/thumb%s` | `com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:83` | SigmaStar 缩略图 |
| `http://%s/` | `com/gku/actioncam/hisilicon/dv/biz/DV.java:556` | 根 |
| `http://192.168.0.1/` | `com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:61`、`com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:58` | **硬编码基址**（主文档 §11 已列） |
| `http://` | `com/gku/actioncam/sigmastar/HaisiCommandUtil.java:34`、`com/gku/actioncam/sigmastar/SSCommandUtil.java:34`、`com/gku/base/device/DeviceHttpUtils.java:12`、`com/gku/module_base_xtugo/HisiApiUtils.java:9` | 前缀常量 |
| `rtsp://%s:554/livestream/12` | `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:972` | Ambarella 预览取流 |
| `rtsp://` | `com/gku/actioncam/hisilicon/dv/biz/DV.java:320`、`com/gku/actioncam/sigmastar/HaisiCommandUtil.java:35`、`com/gku/actioncam/sigmastar/SSCommandUtil.java:35` | 前缀常量 |
| `http://%s:%d/%s` | `com/gku/videocache/HttpProxyCacheServer.java:140`、`com/gku/videocache/Pinger.java:97` | 本地代理回环 |
| `file:///storage/emulated/0/DCIM/ActionCam/download/{a_aba,b_longji,c_mabuer,d_dive}.mp4` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java:367` | 4 条硬编码 `file://` 演示视频路径（缩略图点击→VIEW 跳外部播放器，非内置于 APK） |
| `file:///android_asset/` | `com/gku/base/webview/WebViewUtils.java:201` | 本地 H5 |
| `file:///system/media/audio/ui/{camera_click,VideoRecord,VideoRecordEnd}.ogg` | `com/gku/actioncam/amba/ui/preview/AmbaPreviewPresenter.java:371,375,379`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Utility.java:56` | 系统快门音 |
| `file://` | `com/gku/actioncam/sigmastar/videoedit/CutActivity.java:455`、`com/gku/dashcam/icatch/utils/imageloader/ImageLoaderUtil.java:58`、`com/icatchtek/reliant/customer/type/ICatchFileStreamParam.java:47` | 前缀 |
| `file:///storage/…` 之外的 `http://schemas.android.com/apk/res/android` | 见 §4.1 | 非网络 |

### 4.4 IP / 组播 / 回环（`_work/re/xtugo/signals-ips.tsv` 全 36 行归并）

| 字面量 | 出现处 | 判定 |
|---|---|---|
| `192.168.0.1` | `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:972`、`…/amba/ui/stream/TCPClient.java:63`、`com/gku/actioncam/hisilicon/dv/biz/DV.java:66`、`…/dv/ui/config/CameraParameters.java:37`、`…/dv/ui/config/CameraParmeras.java:37`、`…/dv/ui/data/connect/ConnectDevice.java:44`、`…/dv/ui/data/connect/DownLoadFileUtils.java:34`、`…/dv/ui/data/connect/FirmwareClientThread.java:64`、`com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:31`、`…/sigmastar/data/connect/FirmwareClientThread.java:64`、`…/sigmastar/data/connect/SSConnectDevice.java:57`、`com/gku/actioncam/sigmastar/SSConstant.java:13`、`…/sigmastar/newUi/deviceAdd/Activity/DeviceAddNewActivity.java:187`、`…/newUi/deviceAdd/Activity/UserGuideActivity.java:162`、`…/newUi/deviceAdd/Fragment/connect/DeviceAddConnectFragment.java:151`、`…/sigmastar/upgrade/firm/Presenter/UpgradePresenter.java:228`、`…/upgrade/firm/Ui/UpgradeVersionReadyActivity.java:71`、`com/gku/HomeActivity.java:562`、`com/gku/rxt/FwUpload2.java:18`、`com/hisi/hisiFW/FwUpload.java:16` | **A（本地）**：相机默认地址，6 个独立常量位（主文档 §11 已纠正） |
| `192.168.1.1` | `_work/xtu_src/sources/m/mifan/acase/icatch/IcatchCaseKt.java:9`（`API_HOST_ICATCH`） | **A（本地）**：iCatch 记录仪不同网段 |
| `234.168.168.168` | `_work/xtu_src/sources/com/icatchtek/control/core/CoreMulticast.java:15`（`MULTI_CAST_ADDR`）；标签串 `multicast.test`（`:21`）、`multicast.receive`（`_work/xtu_src/sources/com/icatchtek/control/core/feature/ICatchCameraAssistImpl.java:320`） | **B（iCatch 设备发现）**：D 类组播，需 `CHANGE_WIFI_STATE` + 组播锁 |
| `127.0.0.1` | `com/gku/videocache/HttpProxyCacheServer.java:32`（`PROXY_HOST`）、`com/gku/ffm/zqvideo/cache/ProxyCacheManager.java:56`、`com/gku/ffm/zqvideo/video/base/GSYVideoView.java:721` | **A（本地）**：AndroidVideoCache 代理 |
| `8.8.8.8` | `com/gku/loginmodule/utils/NetworkUtils.java:23`：`Runtime.getRuntime().exec("/system/bin/ping -c 1 8.8.8.8")` | **A（真会发包）**：网络连通性判定的**唯一外网探测点**，国内网络下常超时 → 该判定实际不可靠（值得我们在 §10 记录） |
| `172.18.1.19` | `com/gku/base/utils/NetWorkInfoUtils.java:83` | **C 死字符串**：作者内网调试地址残留 |
| `0.0.0.0` | `com/gku/actioncam/hisilicon/dv/wifi/HiWifiScrollView.java:541` | **A（本地）**：无效地址哨兵 |

### 4.5 厂商配置常量原样抄录（这些是**厂商侧事实**，不是我们的密钥）

| 常量 | 值 | 出处（全路径:行） |
|---|---|---|
| `BuglyId` | `0324406337` | `_work/xtu_src/sources/com/gku/xtugo/BuildConfig.java:7` |
| `APPLICATION_ID` / `FLAVOR` / `CURRENT_APP_TYPE` / `VERSION_CODE` / `VERSION_NAME` / `isDebuggable` | `com.gku.xtugo` / `XTUGO` / `0` / `243` / `8.4.3_243_2026-08-19-17-05-43` / `false` | 同文件 `:5,10,8,11,12,13` |
| `URL_SERVER` | `https://server4.gkuvision.com` | `_work/xtu_src/sources/com/gku/module_base_xtugo/BuildConfig.java:8` |
| 抖音 OpenLive AppKey | `"780679"`（第 2 参），第 3 参 `"XTU GO"`，第 5 参 `243L`，且 `isDebug(true)` | `_work/xtu_src/sources/com/gku/actioncam/amba/ui/stream/DouyinStreamController.java:158` |
| `gkucamplayer` 模块 BuildConfig | `BUILD_TYPE="debug"`、`DEBUG=true`、`LIBRARY_VERSION=". Version: 8.1.2"` | `_work/xtu_src/sources/com/gku/gkucamplayer/BuildConfig.java:5,6,8` → **release 包里嵌了 debug 构建的子模块** |
| iCatch 三个 SDK 模块 BuildConfig | `BUILD_TYPE="debug"`、`DEBUG=true`、`VERSION_CODE=1`、`VERSION_NAME="1.0"` | `_work/xtu_src/sources/com/icatchtek/control/BuildConfig.java:5-9`、`com/icatchtek/pancam/BuildConfig.java:5-9`、`com/icatchtek/reliant/BuildConfig.java:5-9` |
| `API_HOST_ICATCH` | `192.168.1.1` | `_work/xtu_src/sources/m/mifan/acase/icatch/IcatchCaseKt.java:9` |
| 固件目录基址 | `http://121.40.107.215:8041/firmware/` | `com/gku/actioncam/sigmastar/upgrade/app/UpgradeTaskManager.java:35`、`…/dv/updateapp/UpgradeManager.java:35` |
| 更新 XML | `http://www.gkuvision.com:8882/upload/update.xml` | `com/gku/rxt/net/AppService.java:22` |
| STS 口 | `http://api.dashcamplayer.net/api/aliyun/uptoken` | `com/gku/rxt/net/AppService.java:97` |
| OSS 三元组 | **无硬编码**：`data.getEndpoint()` / `getAccess_key()` / `getAccess_secret()` / `getSecurity_token()` 全部运行期下发 | `_work/xtu_src/sources/com/gku/HomeActivity.java:859` |
| 渠道号 `UMENG_CHANNEL` | `product_GooglePlay` | `_work/xtu_res/resources/AndroidManifest.xml:123`（清单级 meta-data），读取方 `_work/xtu_src/sources/com/gku/crashhandle/CrashReportManager.java:40` → `:45 setAppChannel(...)` |
| **Google Maps API key** | `AIzaSyAu4dYAjvpBVwWJtUKB19MEnQ5MsKn2bPE` | `_work/xtu_res/resources/AndroidManifest.xml:272`（`com.google.android.geo.API_KEY`）；配合 `:1123` 的 `com.google.android.gms.version` |
| 字节 zeus 插件 appKey/appSecretKey（**4 组，清单里明文**） | video（`com.byted.saas.video`）：`14adbdb906c0a8c1601ecb546737bc80` / `a337bb0a0445d2b6cb75c0c86427ab2a`<br>ttm.player：`b759a5c22d90020d40d5450cf6abee55` / `3298eca929aa69b7104aac236f54abde`<br>live.lite：`edc32eaa174b15a7a3771c37b451c080` / `2f906bdb2f32468a63c2fed4afd1e82e`<br>broadcast.lite：`63fed49bd0bad946b0886802de2fe8a4` / `50011b4cf949a84aa9c6d3e11093a6aa` | `_work/xtu_res/resources/AndroidManifest.xml:646, 785, 788, 1010`（详见 §3.3 M4/M6/M7/M9，含版本码 `:649, :791, :1013`） |
| 高德 key | **不存在**（无 `com.amap.api.v2.apikey`，全树无 `setApiKey`）→ 与上面的 Google key 是**两回事** | `_work/xtu_res/resources/AndroidManifest.xml`：19 条 `<application>` 级 meta-data 全列于 §3.3，其中无 amap（`_work/re/xtugo/manifest.md:418-428` 把这一整段漏采了，只留 7 条组件级） |
| 华为 appId | **不存在**（只有 `com.huawei.hms.client.service.name:scanplus` 等服务名，`:1190`） | 同上 |
| 相机 WiFi 口令 | **无硬编码**：运行期由 CGI 取（键名 `wifi_password` @ `com/gku/actioncam/hisilicon/dv/biz/Common.java:134`，取法 `…/dv/biz/HiWifiManager.java:127,152,154`、`…/dv/wifi/WifiUtils.java:138,163,165`、`com/gku/actioncam/sigmastar/bean/SSWiFiInfo.java:22`） | §7.4 |
| Bugly `setUserId` | `Settings.Secure "android_id"` 同时当 `userId` 与 `deviceID` | `_work/xtu_src/sources/com/gku/crashhandle/CrashReportManager.java:27,28,29`；真正的 `CrashReport.initCrashReport(context, BuildConfig.BuglyId, isDebuggable, userStrategy)` 在 **`:48`** |

### 4.6 判定汇总

| 档 | 条数 | 明细所在（可复核） |
|---|---|---|
| **A 运行时会访问（厂商后端 / 外链 / 本地）** | **29** | §4.1 的 29 行里 **24 行判 A**（其余 3 行 C、2 行 D）+ §4.4 的 **5 项**（`192.168.0.1`、`192.168.1.1`、`127.0.0.1`、`8.8.8.8`、`0.0.0.0`） |
| **B 库会访问（条件触发）** | **10 族 / 约 35 个端点** | §4.2：高德（6 族端点）、Bugly（`android.bugly.qq.com`、`h.trace.qq.com`）、阿里 OSS region（`*.aliyuncs.com` 5 个 region + 2 个 location 域）、字节 zeus/APMPlus（`apmplus.volces.com`、`*.vemarsdev.com` ×2）、HMS GRS（5 域）+ hicloud metrics（4 域，§7.2）、MSA-OAID（Binder 无域名）、iCatch 组播（`234.168.168.168`，§4.4）、native 高德/YouTube（§7.1） |
| **C 库里死字符串 / 本场景不触发** | **6** | AndroidVideoCache 报错文案（3 处）、`schemas.android.com`、B 站图床 `i2.hdslb.com`、`location-inner.aliyuncs.com`、高德搜索/导航类端点、APM Insight（判定理由见 §4.2 末段） |
| **D 厂商死常量** | **3** | `http://api.shhc-yh.com/api/`、`http://api.shhc-yh.com/`（均只声明于 `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:23,24`，全树无消费者）、`172.18.1.19`（`_work/xtu_src/sources/com/gku/base/utils/NetWorkInfoUtils.java:83`） |

**复核式**（在本附录内可直接跑）：

```sh
awk '/^### 4.1/,/^### 4.2/' <本文件> | grep '^| `' | grep -c '\*\*A'   # 24
awk '/^### 4.4/,/^### 4.5/' <本文件> | grep -c '^| `'                   # 7（5A/1B/1D→C）
```

→ **真正需要我们在网络侧对齐的只有 A 类**；A 类里跟相机协议无关的全是商店/客服/协议链接，跟协议有关的全是 §4.3/§4.4 的本地地址。

---

## 5. Intent action / 自定义广播 / DeepLink / scheme

### 5.1 清单里的 intent-filter：**全 App 只有 3 个组件带 filter**

对 `_work/re/xtugo/components.tsv` 第 5 列（`filters`）做非空筛选，全 219 行只命中 3 行：

| 组件 | 类型 | exported | action | categories / data | flags | 权限保护 |
|---|---|---|---|---|---|---|
| `com.gku.actioncam.hisilicon.dv.ui.WelcomeActivity` | activity | **true** | `android.intent.action.MAIN` | cat `android.intent.category.LAUNCHER`；data **无** | 无 | **无** |
| `com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService` | service | false | `com.ss.android.socialbase.downloader.remote` | 无 | 无 | 无（但 `exported=false`） |
| `androidx.profileinstaller.ProfileInstallReceiver` | receiver | **true** | `androidx.profileinstaller.action.{INSTALL_PROFILE,SKIP_FILE,SAVE_PROFILE,BENCHMARK_OPERATION}` | 无 | 无 | **`android.permission.DUMP`** |

`receiver` 另一条 `androidx.car.app.notification.CarAppNotificationBroadcastReceiver` 是 `exported=false` 且**无 filter**。

### 5.2 DeepLink / 自定义 scheme：**0 条**

- 3 个 filter 里 `data` 全为空 → **清单里没有 `<data android:scheme=…>`**。
- 全 APK 唯一的自定义 scheme 出现在**字符串常量**里：`snssdk1128://goods/store?sec_shop_id=QMnJSSw&entrance_location=dou_shop_ad_101_2&tab_id=16&url_maker=shop_sdk`，且是被 URL 编码塞进 `https://z.douyin.com/p53t?scheme=…` 里由**抖音 App**解释的（`_work/xtu_src/sources/com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java:200`）→ **不是本 App 注册的 scheme**。
- 其它 scheme 型常量：`file://`、`http://`、`https://`、`rtsp://`、`android.resource://`（`com/gku/ffm/zqvideo/player/IjkPlayerManager.java:74`、`com/gku/mediacodec/exo2/ExoSourceManager.java:81`、`com/gku/ffm/zqvideo/video/base/GSYVideoControlView.java:1207`）、`content://`（FileProvider，§6）。

→ **结论**：外部无法用 DeepLink 进入本 App 的任何一个业务页。这对我们是好消息（不必实现 scheme 兼容），也是坏消息（**想互操作只能自己起 Activity**，见 §5.4）。

### 5.3 自定义 action / 广播（`_work/re/xtugo/signals-actions.tsv` 全 90 条归并）

#### (a) 厂商自定义广播：**只有 2 条真广播**

| action 串 | 常量定义 | 发送点 | 接收点 | 携带内容 |
|---|---|---|---|---|
| `com.gku.xtugo.MESSAGE_ACTION` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:18` | `com/gku/actioncam/hisilicon/dv/net/MessageService.java:127`（5678 收到相机报文后）、`com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:314-316` | `com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java:631-634`、`…/filebrowser/Hi3518PriviewImageActivity.java:575-578`（SD 卡状态刷新） | 相机推送的状态原文 |
| `com.gku.xtugo.DV_ISALIVE_ACTION` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java:14` | `com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java:58,73` | `com/gku/actioncam/amba/base/IjkBaseActivity.java:47`、`com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java:1006`、`…/Hi3518PriviewImageActivity.java:916`、`…/dv/imagelookover/SwitchImageActivity.java:475` | 心跳成功/失败 |

**关键实现细节（值得照抄）**：注册一律走「≥33 显式 `RECEIVER_NOT_EXPORTED(=2)`、<33 走老 API」的双分支，例如
`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java:631-635`：

```java
if (Build.VERSION.SDK_INT >= 33) { registerReceiver(r, new IntentFilter(MessageService.MESSAGE_ACTION), 2); }
else { registerReceiver(r, new IntentFilter(MessageService.MESSAGE_ACTION)); }
```

`sendBroadcast(intent)` **不带 receiverPermission** → Android 13+ 因接收侧是 `NOT_EXPORTED` 而安全；**Android ≤32 时该广播是全局可收/可伪造的**。

#### (b) 回放下载队列的 3 条（**内部 Intent extra 键，不是广播**）

| 串 | 出处 | 性质 |
|---|---|---|
| `com.gku.actioncam.sigmastar.OldUi.playback.path` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/service/DownloadIntentService.java:25` | `private static final String DOWNLOAD_PATH`（extra key） |
| `…OldUi.playback.state` | 同上 `:26` | `DOWNLOAD_STATE`（extra key） |
| `…OldUi.playback.action.DOWNLOAD_TASK` | 同上 `:27` | **`startService` 的 action**；该 service `exported=false` → 外部不可触发 |

#### (c) 伪 action（TAG / 类名字符串，`signals-actions.tsv` 的噪声，须排除）

`com.gku.actioncam.sigmastar.widget.SSVideoView`（`…/sigmastar/widget/SSVideoView.java:38` = `TAG`）、
`com.gku.actioncam.widget.VideoView`（`…/actioncam/widget/VideoView.java:37` = `TAG`）、
`com.gku.actioncam.sigmastar.upgrade.firm.Utils.DownloadUtil`（`…/upgrade/firm/Utils/DownloadUtil.java:17` = `TAG`）。

#### (d) 厂商**发给系统/别的 App** 的 action

| action | 出处（全路径:行） | 说明 |
|---|---|---|
| `android.intent.action.MEDIA_SCANNER_SCAN_FILE` | `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java:326`、`…/dv/dlg/DlgForProcessActivity.java:521`、`…/dv/dlg/DlgForDeleteProcessActivity.java:842`、`…/dv/localimage/ImageEditLib/ImageEditClipActivity.java:109`、`…/dv/ui/data/connect/ConnectDevice.java:167`、`…/dv/ui/data/connect/DownLoadFileUtils.java:201,302`、`…/dv/ui/data/CopyFileUtils.java:254`、`…/sigmastar/data/connect/DownLoadFileUtils.java:161`、`…/sigmastar/data/connect/SSConnectDevice.java:178`、`…/sigmastar/newUi/album/Utils/FileNewUtils.java:85`、`…/sigmastar/util/FileUtils.java:67`、`…/sigmastar/videoedit/FilePathUtils.java:140`、`com/gku/dashcam/icatch/utils/MediaRefresh.java:183`、`com/gku/dashcam/icatch/data/IcatchConnectDevice.java:146` | **15 处**。Android 10+ 该广播已无效（须用 MediaStore API），是**必须注意的历史包袱**：官方 App 的媒体入库在某些机型上其实靠不住 |
| `android.intent.action.MEDIA_SCANNER_SCAN_DIR` | `com/gku/dashcam/icatch/utils/MediaRefresh.java:22` | 同上（iCatch 线） |
| `android.intent.action.SEND` / `SEND_MULTIPLE` / `SENDTO` | `com/gku/base/utils/ShareUtils.java:17,45,49`、`…/dv/biz/HiShareFile.java:15,36`、`…/dv/localimage/AlbumPreviewActivity.java:192`、`…/newUi/album/Ui/Activity/ActivityNewPreview.java:327`、`…/newUi/album/Ui/Fragment/CommonFragment.java:291,308`、`…/newUi/userCenter/ui/activity/QuestionDescription.java:170`、`…/sigmastar/videoedit/VideoShareActivity.java:87` | 分享出站到微信/QQ（`queries{com.tencent.mm,com.tencent.qq}`） |
| `android.intent.action.VIEW` | `com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java:1188`、`…/Hi3518PriviewImageActivity.java:1098`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java:368`、`…/dv/setting/AboutClientActivity.java:172`、`…/dv/updateapp/UpgradeManager.java:924`、`com/gku/actioncam/sigmastar/upgrade/app/UpgradeTaskManager.java:924`、`…/upgrade/app/UpgradeViewManager.java:639`、`com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:168`、`…/loginmodule/ui/fragment/UserCenterNewFragment.java:261`、`com/gku/base/utils/FileIntentUtils.java:15`、`com/gku/base/utils/MarketUtils.java:38`、`com/gku/base/webview/WebViewUtils.java:61`、`com/gku/rxt/net/CheckAppVersionUtils.java:327` | 13 处外跳（浏览器/应用市场/拨号盘/安装） |
| `android.intent.action.INSTALL_PACKAGE` | `com/gku/actioncam/sigmastar/upgrade/app/UpgradeViewManager.java:634` | App 自升级安装（配合 §6 的 FileProvider URI） |
| `android.intent.action.MAIN`（手工构造，非 launcher） | `com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:339`、`com/gku/loginmodule/utils/OtherUtils.java:37` | 用 `getLaunchIntentForPackage` 拉起别的 App |
| `android.settings.action.MANAGE_WRITE_SETTINGS` | `com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:1216`、`…/HisiActionCameraPreviewActivity.java:1227`、`com/gku/base/permission/PermissionActivity.java:61` | 跳「修改系统设置」授权页（对应 `WRITE_SETTINGS`） |
| `android.settings.REQUEST_MANAGE_MEDIA` | `com/gku/HomeActivity.java:1049`、`…/dv/ui/WelcomeActivity.java:195`、`…/dv/ui/weight/MyBottomSheetDialog.java:312`、`com/gku/loginmodule/utils/PermissionUtils.java:118` | 跳「允许管理所有文件」（对应 §1.1 #6 的半死判定） |
| `miui.intent.action.APP_PERM_EDITOR` + `setClassName("com.android.settings","com.miui.securitycenter.permission.AppPermissionsEditor")` | `com/gku/actioncam/sigmastar/bluetooth/utils/IntentUtils.java:26,27` | MIUI 判定/跳权限页；用 `queryIntentActivities` 探测（`:31-32`，即 `isIntentAvailable`） |
| `android.intent.action.{SCREEN_ON,SCREEN_OFF,USER_PRESENT}` | `com/gku/dashcam/icatch/listener/ScreenListener.java:40,42,44,77,78,79` | iCatch 线的息屏监听 |
| `android.net.wifi.STATE_CHANGE` / `android.net.wifi.supplicant.STATE_CHANGE` / `android.net.conn.CONNECTIVITY_CHANGE` | 22 处：`…/dv/ui/BaseActivity.java:33`、`com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java:353,354,469,483,518`、`…/dv/filebrowser/{com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java:1005,com/gku/actioncam/hisilicon/dv/filebrowser/Hi3518PriviewImageActivity.java:915}`、`…/dv/imagelookover/SwitchImageActivity.java:474`、`…/dv/live/TelevisionActivity.java:239,384`、`…/dv/wifi/WifiDeviceActivity.java:49,129`、`…/dv/wifi/WifiDisconnectReceiver.java:83`、`…/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:177`、`…/amba/base/IjkBaseActivity.java:46`、`…/amba/ui/preview/AmbaPreviewActivity.java:1230`、`com/gku/dashcam/icatch/utils/WifiAPUtil.java:18,56` | **断连检测主力**。这是我们要复刻的核心信号（谁掉了 AP 就判定断开） |
| `com.android.music.musicservicecommand` | `com/gku/actioncam/sigmastar/widget/SSVideoView.java:583`、`com/gku/actioncam/widget/VideoView.java:588` | 耳机线控/第三方音乐广播的**接收**（锁屏播放控制），系统广播 |
| `EVENT_TIME_LAPSE_STOP`、`CAMERA_CONNECT_CHANGE` | `_work/xtu_src/sources/m/mifan/acase/icatch/IcatchCase.java:586`、`m/mifan/acase/icatch/PropertyIdKt.java:7` | iCatch PTP 内部事件名，**不是 Android intent**（`signals-actions.tsv` 的误分桶） |
| `CALLBACK_CHOOSE_CLICK` | `com/gku/amba/AmbaCameraFileActivity.java:35`、`…/amba/AmbaCameraPicFragment.java:317`、`…/amba/AmbaCameraRecordFragment.java:340`、`com/gku/hisi/Hisi_CameraFileActivity.java:22`、`…/hisi/Hisi_CameraPicFragment.java:286`、`…/hisi/Hisi_CameraRecordFragment.java:298` | `setResult` 用的 **extras key**，非 action |
| `multicast.test` / `multicast.receive` | `com/icatchtek/control/core/CoreMulticast.java:21`、`_work/xtu_src/sources/com/icatchtek/control/core/feature/ICatchCameraAssistImpl.java:320` | iCatch 组播内的标签串（配合 `234.168.168.168`，§4.4） |

#### (e) 一条**指向不存在 App** 的外跳（重要）

`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java:369`：

```java
intent.setClassName("com.gku.actioncam.hisilicon.android.videoplayer",
                   "com.gku.actioncam.hisilicon.android.videoplayer.activity.VideoActivity");
```

该包**既不在本 APK 的 219 个组件里，也不在 `queries`（只有 `com.tencent.mm`、`com.tencent.qq`、`com.gku.xtugo`、`com.gku.yutupro`）里** → 在 Android 11+ 必然解析失败。属海思 DV 老播放器残留，**我们不要照抄**。

### 5.4 外部可触发面矩阵

| 入口 | exported | 权限 | 无权限就能触发？ | 影响 |
|---|---|---|---|---|
| `com.gku.actioncam.hisilicon.dv.ui.WelcomeActivity` | true | 无 | ✅ 是 | 只能把 App 拉到前台，无参数注入点 |
| `com.gku.gkucamplayer.GKUCamPlayer` | **true** | **无** | ✅ 是（显式组件名） | **唯一可被任意 App 拉起、且会吃外部参数的厂商 Activity**。`_work/xtu_src/sources/com/gku/gkucamplayer/GKUCamPlayer.java:38` 取 `intent.getStringExtra("kPlayFilePath")`、`:39` 取 `kPlayFileName`，然后 **`:47` 原样塞进 `GSYVideoOptionBuilder.setUrl(this.url)`** 播放（`:139` 重播时同样）。配合 §3.1 的 `usesCleartextTraffic=true` 与 §3.2 的无 pin，**外部 App 可以让它播放任意 `http://` / `file://` / `rtsp://` 地址**（含 `:46` `PlayerFactory.setPlayManager(Exo2PlayerManager.class)`）。这是全清单里**实际意义最大的一个暴露面**（安全评估归 `docs/analysis/network-api`） |
| `androidx.profileinstaller.ProfileInstallReceiver` | true | `android.permission.DUMP` | ❌ 否 | 系统/adb 专用 |
| `com.bytedance.**.DouyinAuthorizeActivityProxy` ×3 + `…dy.sdk.stub.VideoAuthorizeActivityProxy` | **true** | **无** | ✅ 是（显式组件名，无 filter） | 抖音 OAuth 授权回跳页（§2.6 E3–E6）；与相机协议无关，但接收授权结果数据 |
| `com.gku.base.BaseFileProvider`（`com.gku.xtugo.FileProvider`） | false + `grantUriPermissions=true` | — | ❌ 否（需本 App 主动授权） | 见 §6.2 的宽路径风险 |
| 13 个 zeus/`servermanager` provider | false | — | ❌ 否 | 同 App 跨进程 |
| 其余 212 个组件 | false / 未写(=false) | 无 | ❌ 否 | — |
| `com.gku.xtugo.MESSAGE_ACTION` / `DV_ISALIVE_ACTION` 广播 | — | 无 | ⚠️ **可被任意 App 监听**（`sendBroadcast` 不带 receiverPermission）；Android ≤32 也可被**伪造注入**（接收侧老 API 注册） | 泄露内容：相机推送的状态字符串（含录制计时/SD 卡状态） |

**一句话结论**：厂商侧对外暴露只有 `GKUCamPlayer`（E2，**可注入任意播放 URL**）与启动器（E1，无参数）；另有 4 个抖音授权回调页导出且无权限，但属直播 SDK 设计所需。**内部广播是唯一的运行期信息泄露渠道**；全 App 无任何 DeepLink/scheme（§5.2）。

### 5.5 对我们互操作的影响

| 事实 | 影响 |
|---|---|
| 0 DeepLink / 0 scheme | 我们**不需要**注册任何 scheme 来做「被官方 App 拉起/被拉起」的兼容；跨 App 集成只能靠 `com.gku.xtugo.FileProvider` 的 content URI（而我们本来就不需要） |
| 只有 `MAIN/LAUNCHER` 一个真 filter | 我们无法用 intent 把参数喂进官方 App 的某个页面；反向（官方 App 拉我们）也不存在 |
| 2 条内部广播 | **不要**把它当协议通道（§3.4 的 5678 回拨才是真正的通道，广播只是它的 UI 副作用） |
| 15 处 `MEDIA_SCANNER_SCAN_FILE` | 官方下载后靠它入库 → 我们用 MediaStore 插入是**更可靠**的等价实现，不算行为差异 |
| 22 处 WiFi 状态广播 | 我们必须同样监听 `STATE_CHANGE` + `supplicant.STATE_CHANGE` 才能对齐「断连即掉线」的观感 |

---

## 6. FileProvider / authorities / 共享路径

### 6.1 全部 authorities（14 个 provider → 14 个 authority 串）

来自 `_work/re/xtugo/components.tsv` provider 行的原样值：

| authority | provider 类 | exported | grantUriPermissions | process | 归属 |
|---|---|---|---|---|---|
| `com.gku.xtugo.FileProvider` | `com.gku.base.BaseFileProvider` | **false** | **true** | 主 | 厂商 |
| `com.gku.xtugo.luckProvider` | `com.luck.picture.lib.basic.PictureFileProvider` | false | true | 主 | LuckPicture |
| `com.gku.xtugo.zeus.fileprovider` | `com.volcengine.zeus.FileProvider` | （未写→false） | true | 主 | 字节 zeus |
| `com.gku.xtugo.zeus.provider.proxy.main` | `com.volcengine.zeus.provider.MainProcessProviderProxy` | false | — | 主 | 字节 zeus |
| `com.gku.xtugo.zeus.servermanager.main` | `com.volcengine.zeus.servermanager.MainServerManager` | false | — | 主 | 字节 zeus |
| `com.gku.xtugo.bytedance.android.openliveplugin.process.server.LiveServerManager` | 同名类 | false | — | `:bytelive` | 抖音直播插件 |
| `com.gku.xtugo.zeus.servermanager.bytelive.com.byted.live.lite` | `com.byted.live.lite.ServerManager_bytelive` | false | — | `:bytelive` | 字节 |
| `com.gku.xtugo.zeus.servermanager.push.com.byted.live.lite` | `com.byted.live.lite.ServerManager_push` | false | — | `:push` | 字节 |
| `com.gku.xtugo.zeus.servermanager.bytelive.com.byted.broadcast.lite` | `com.byted.broadcast.lite.ServerManager_bytelive` | false | — | `:bytelive` | 字节 |
| `com.gku.xtugo.zeus.servermanager.push.com.byted.broadcast.lite` | `com.byted.broadcast.lite.ServerManager_push` | false | — | `:push` | 字节 |
| `com.gku.xtugo.zeus.servermanager.downloader.com.byted.broadcast.lite` | `com.byted.broadcast.lite.ServerManager_downloader` | false | — | `:downloader` | 字节 |
| `com.gku.xtugo.androidx-startup` | `androidx.startup.InitializationProvider` | false | — | 主 | AndroidX |
| `com.gku.xtugo.MLInitializerProvider` | `com.huawei.hms.mlsdk.common.provider.MLInitializerProvider` | false | — | 主 | HMS |
| `com.gku.xtugo.AGCInitializeProvider` | `com.huawei.agconnect.core.provider.AGConnectInitializeProvider` | false | — | 主 | AGConnect |

**要点**：厂商自己只有 **1 个** authority —— `com.gku.xtugo.FileProvider`。其余 13 个全是库。
跨进程通道由字节 zeus 的 `servermanager.*` provider 承担（`:bytelive` / `:push` / `:downloader` 三个子进程），**这就是抖音直播插件 IPC 的全部入口**，与相机协议无关，互操作不需要。

### 6.2 `paths_base.xml` 全文（`android.support.FILE_PROVIDER_PATHS` 指向的文件）

`_work/xtu_res/resources/res/xml/paths_base.xml`（6 条 path，全部 `path="."`）：

| 元素 | name 段 | path | → 实际暴露的根 |
|---|---|---|---|
| `<files-path>` | `files` | `.` | `/data/data/com.gku.xtugo/files/**` |
| `<cache-path>` | `cache` | `.` | `/data/data/com.gku.xtugo/cache/**` |
| `<external-files-path>` | `external_files` | `.` | `/storage/emulated/0/Android/data/com.gku.xtugo/files/**` |
| `<external-cache-path>` | `external_cache` | `.` | `/storage/emulated/0/Android/data/com.gku.xtugo/cache/**` |
| `<external-path>` | `external_root` | `.` | `/storage/emulated/0/**`（**整张外置卡**） |
| `<external-path>` | `external` | `.` | 同上，重复声明一份别名 |

即：**URI 形如 `content://com.gku.xtugo.FileProvider/external_root/DCIM/xtugo/video/…`，可寻址整张外置存储**。
因为 `exported=false` + `grantUriPermissions=true`，外部 App 拿不到 URI 除非本 App 主动 `grantUriPermission` / 发 `EXTRA_STREAM`。实际分享/安装路径：

- 分享：`com/gku/base/utils/ShareUtils.java:17,45,49`（`SEND`/`SENDTO`/`SEND_MULTIPLE`）
- 媒体分享：`com/gku/actioncam/hisilicon/dv/biz/HiShareFile.java:15,36`
- 安装升级包：`com/gku/actioncam/sigmastar/upgrade/app/UpgradeViewManager.java:634`（`android.intent.action.INSTALL_PACKAGE`）、`:639`（`ACTION_VIEW`）
- 相册分享：`com/gku/actioncam/sigmastar/newUi/album/Ui/Activity/ActivityNewPreview.java:327`、`com/gku/actioncam/sigmastar/newUi/album/Ui/Fragment/CommonFragment.java:291,308`、`…/dv/localimage/AlbumPreviewActivity.java:192`

### 6.3 库侧的 file_paths（对比）

`_work/xtu_res/resources/res/xml/ps_file_paths.xml`（LuckPicture，meta-data `android.support.FILE_PROVIDER_PATHS=@xml/ps_file_paths`）：`<external-path name="camera_photos" path=""/>` + `<root-path name="camera_photos" path=""/>` —— **`root-path` 即整个文件系统根**（`/`），比厂商自己的 `paths_base` 更宽。
另存在 `_work/xtu_res/resources/res/xml/file_paths.xml`，但清单里**没有任何 provider 引用它**（Glide/旧库遗留）。

### 6.4 共享出来的具体路径

由 `com/gku/actioncam/hisilicon/dv/biz/Common.java:170-176`（品牌段来自 `BuildConfig.APPLICATION_ID.split("\\.")[2]` = `xtugo`）与 §9.3 的缓存目录：

| 路径 | 内容 |
|---|---|
| `/DCIM/xtugo/photo/ActionCam/`、`/DCIM/xtugo/video/ActionCam/`、`/DCIM/xtugo/video/ActionCam/sd/` | 相机下载的照片/视频/缩码流 |
| `/DCIM/xtugo/{photo,video}/DashCam/` | iCatch 记录仪下载 |
| `/mnt/sdcard/DCIM/ActionCam/`（`SSConstant.LOCAL_DOWNLOAD_DIR`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:10`） | 老 SigmaStar 下载根（**字面量就是 `/mnt/sdcard/` 前缀**，与 §6.2 `paths_base.xml` 的 `external-path` 同分区不同别名） |
| `/mnt/sdcard/Android/data/com.gku.xtugo/cache/`（`SSConstant.LOCAL_THUMB_CACHE_DIR`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:11`） | 缩略图缓存 |
| `/storage/emulated/0/DCIM/ActionCam/download/{a_aba,b_longji,c_mabuer,d_dive}.mp4` | 直播预览用的演示视频（`onClick` 里 4 条硬编码 `file://` 路径，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java:367`；非 APK 内置，是预期已下载到该目录） |
| `/mnt/sdcard/xtu_exception.txt`、`/mnt/sdcard/JKHardVersion/` | 崩溃/固件残留（`_work/re/xtugo/signals-fsPaths.tsv`） |

---

## 7. native 与 assets 里的域名与证书

素材：`_work/re/xtugo/natives-strings.tsv`（按 `lib / category / string` 三列）、`_work/re/xtugo/natives.md`（31 个 `.so` 与依赖）、`_work/re/xtugo/assets-index.md`（194 个 asset，文本 22 个）、`_work/re/xtugo/assets-content.md`（文本内联）、`_work/re/xtugo/apk-entries.md`。

### 7.1 `.so` 内嵌端点（逐条判定）

全量扫描 `_work/re/xtugo/natives-strings.tsv` 的 `url` 类，**只有 4 个 `.so` 带完整 URL**，其余 27 个库一个都没有。

| `.so` | 内嵌端点/串 | 谁 `loadLibrary` | 判定与依据 |
|---|---|---|---|
| `lib/arm64-v8a/libAMapSDK_MAP_v10_0_600.so`（及 `armeabi-v7a` 同名） | `http://m5.amap.com`、`https://m5.amap.com/`、`http://m5.amap.com/ws/transfer/auth/map/indoor_maps`、`http://mpsapi.amap.com/`、`http://mpsapi.amap.com/ws/mps/vmap/`、`/ws/mps/rtt/`、`/ws/mps/smap`、`/ws/mps/lyrdata/ugc/`、`http://maps.testing.amap.com/ws/mps/vmap`、`/ws/mps/rtt` | 高德 Java SDK 自动（`com/amap/api/**`） | **B → 实际不成立**：轨迹页 `com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:389,497,667` 会加载地图，但清单无 apikey（§4.2）→ 瓦片请求在鉴权前就被拒。`maps.testing.amap.com` 是**测试域残留（C 死字符串）** |
| `lib/arm64-v8a/libpanorama_vr.so`（16 MB，iCatch 全景 VR） | `https://www.googleapis.com/oauth2/v4/token`；`https://www.googleapis.com/youtube/v3/liveBroadcasts?part=id,snippet,status,contentDetails`、`…liveBroadcasts?id=%s`、`…liveBroadcasts?part=id,status&id=%s`、`…liveBroadcasts/bind?part=id,contentDetails&id=%s&streamId=%s`、`…liveBroadcasts/transition?broadcastStatus=%s&id=%s&part=id,snippet,contentDetails,status`、`…liveStreams?part=snippet,cdn`、`…liveStreams?part=id,status&id=%s`、`…liveStreams?part=id,snippet,status,cdn&id=%s`、`https://www.youtube.com/channel/`、`https://www.youtube.com/watch?v=`；另有 `com::icatch::live::Authenticator::{setUsernameAndPassword,assignUsernameAndPassword,resetUsernameAndPassword}`、`-----BEGIN PUBLIC KEY-----`、`#EXT-X-KEY:METHOD=AES-128,URI="%s"` | `_work/xtu_src/sources/com/icatchtek/pancam/core/jni/NativeLibraryLoader.java:31` | **B（仅 iCatch 记录仪 + 用户主动用 YouTube 直播时）**：Java 侧对偶物是 `_work/xtu_src/sources/com/gku/dashcam/icatch/sdkapi/PanoramaPhotoPlayback.java`、`…/sdkapi/PanoramaPreviewPlayback.java`、`…/dashcam/icatch/PanoramaSession.java:45`。XTU GO 运动相机路径**永不触发**；这是「官方 App 支持 YouTube 直播」的唯一证据，且**凭据由 native `Authenticator` 持有、APK 内无 OAuth client_id** |
| `lib/arm64-v8a/libijkffmpeg.so` | 只有裸前缀 `http://`、`https://` 与 HLS/RTSP 查询模板（`?reason=authfailed`、`?reason=nosuchuser`、`?reason=needauth`、`?authmod=%s&user=%s`、`?authmod=%s&user=%s&challenge=%s&response=%s`、`?authmod=%s&user=%s&nonce=%s&cnonce=%s&nc=%s&response=%s`、`?localport=%d&ttl=%d&connect=%d&write_to_source=%d`、`?connect=1`、`?ttl=%d`、`?timeout=%d`） | 播放器（`com/gku/ffm/zqvideo/**`、`com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:956` 的 `libijkplayer.so` 判断） | **A（本地）**：这些是 RTSP digest 认证的 URL 拼接模板 → 对应主文档 §3 的 `rtsp://…:554/livestream/12` 起流；**无公网域名** |
| `lib/arm64-v8a/libusb_transport.so` | `http://libusb.info` | `_work/xtu_src/sources/com/icatchtek/control/core/jni/util/NativeLibraryLoader.java:30`、`com/icatchtek/pancam/core/jni/NativeLibraryLoader.java:28`、`com/icatchtek/reliant/core/jni/JUsbTransportBulk.java:20` | **C 死字符串**：libusb 版权文案 |
| `lib/arm64-v8a/libmmkv.so` | 只有 OpenSSL 符号名（`openssl_aes_arm_{set_encrypt_key,set_decrypt_key,encrypt,decrypt}`） | MMKV 自用 | **无网络含义** |
| 其余 26 个 `.so`（含 `libBugly_Native.so`、`libzeus_direct_dex.so`、`libzeusflipped.so`、`libreliant.so`、`libdepth_net_transport.so`、`libijkplayer.so`、`libmp3lame.so` 等） | **0 条 URL** | — | Bugly/字节的域名在 **Java/dex 侧**（§4.2），native 只有实现 |

`loadLibrary` 全量清单（厂商 + iCatch 侧，实测）：`c++_shared`、`usb_transport`、`depth_net_transport`、`reliant`、`panorama_vr`（出处即上表三个 `NativeLibraryLoader`）；`extractNativeLibs=false`（§3.1）意味着它们从 APK 内直接 mmap。

### 7.2 assets 里的端点（逐条）

22 个文本 asset 里，**8 个含 URL**：

| asset | 端点/内容 | 加载方 | 判定 |
|---|---|---|---|
| `assets/grs_sdk_server_config.json`（370 B） | `grs_base_url`: `https://grs.dbankcloud.com`、`.cn`、`.asia`、`https://grs.platform.dbankcloud.ru`、`.eu`；`grs_query_endpoint_1.0` = `/grs/1.0/%1$s/router`；`grs_query_endpoint_2.0` = `/grs/2.0/router`；`grs_query_timeout` = `2` | HMS GRS（`com/huawei/hms/framework/common/**`） | **B**：无 appId → 路由必然空（§4.2） |
| `assets/grs_sdk_global_route_config_mlkit.json`（9,809 B） | `com.huawei.cloud.mlkithianalytics` 服务；区域 `China` / `Asia-African-Latin American` / `Europe` / `Russa`（原文拼写错误）→ `ROOT`: `https://metrics1.data.hicloud.com:6447`、`https://metrics-dra.dt.hicloud.com:6447`、`https://metrics5.data.hicloud.com:6447`、`https://metrics.dt.dbankcloud.ru` | HMS ML Kit 分析 | **B**：`mlkit` 只被文档扫描用（主文档 §8），端口 **6447** 是非标 HTTPS |
| `assets/activate.html`（14,274 B） | 首行 `<!-- saved from url=(0166)https://sulu.cdkm.com/convert/file/st39hayqz35sf0ufmaxx0urxxe38dn9f/XTU%E7%9B%B8%E6%9C%BA%E8%AE%BE%E5%A4%87%E6%BF%80%E6%B4%BB%E7%94%A8%E6%88%B7%E5%8D%8F%E8%AE%AE.html -->` | **无 Java 引用**（`grep -rn "activate.html" com/gku` → 0） | **C 死资源**：⚠️ 但它泄露了一条事实——**XTU 的「设备激活用户协议」托管在第三方转换服务 `sulu.cdkm.com` 上，且文件 ID 是硬编码的 `st39hayqz35sf0ufmaxx0urxxe38dn9f`**。与主文档 §3.1 的 `getactivateinfo.cgi`/`setactivateinfo.cgi`（未解之谜 #7）同一业务 |
| `assets/xtugo_privacy_cn.html`（25,282 B） | 第六节「第三方SDK收集和使用说明」表内 5 条外部链接：`https://lbs.amap.com/pages/privacy/`、`https://terms.aliyun.com/legal-agreement/terms/suit_bu1_ali_cloud/suit_bu1_ali_cloud202111292014_72878.html`、`https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides/sdk-data-security-0000001050043971`、`https://privacy.qq.com/document/preview/fc748b3d96224fdb825ea79e132c1a56`、`https://developer.open-douyin.com/docs/resource/zh-CN/dop/operation-standard/service-protocol/douyin-sdk-privacy-policy` | `_work/xtu_src/sources/com/gku/module_my/ConstantsMy.java:11`（`XTUGO_PRIVACY_CN_ASSETS`）→ `WebViewUtils.loadUrlAndAssets(...)`，见 `com/gku/module_my/ConstantsMy.java:19-22` 与 `_work/xtu_src/sources/com/gku/base/webview/WebViewUtils.java:201` | **A（网络优先、离线兜底）**：`ConstantsMy` 每个协议都成对给出 `https://device.gkuvision.com/static/*.html` + 同名 asset（`:10-17`）→ **断网也能弹协议**，这是我们做合规弹窗该照抄的模式 |
| `assets/xtugo_privacy_en.html`（21,497 B） | `saved from url=(0055)https://www.gkuvision.com/special/xtugo_privacy_en.html` | `com/gku/module_my/ConstantsMy.java:13` | **A**；⚠️ **注释泄露真实线上地址**是 `www.gkuvision.com/special/…`，而代码常量指向 `device.gkuvision.com/static/…` → 两个路径**不同**（见 §8 C-08） |
| `assets/xtugo_useragreement_cn.html`（11,411 B） | `saved from url=(0061)https://www.gkuvision.com/special/xtugo_useragreement_cn.html` | `com/gku/module_my/ConstantsMy.java:15` | **A** |
| `assets/xtugo_useragreement_en.html`（14,326 B） | `saved from url=(0061)https://www.gkuvision.com/special/xtugo_useragreement_en.html` | `com/gku/module_my/ConstantsMy.java:17` | **A** |
| `assets/menu/ly_menu.json.json`（2,790 B，**文件名有重复 `.json.json`**） | 无 URL；结构 `{preferences:[{note:"模式", name_trn:"cam_setting_mode", cmd:"9001", ui:"UIList…"}]}` | 主文档 §6 已判定 **Java 0 引用** | **C 死资源**（4 位 `cmd` 协议仍未解，主文档未解之谜 #11） |

其余 14 个文本 asset 与端点无关但值得记录：`ae/GNaviConfig.xml`（高德导航目录：`<data>./data_v6/</data>`）、`ae/res.ck`（33 B，内容是一个 **md5 串 `6a99be7e3b71ecdfbba3067b4547be1f`** → 高德资源包校验码）、`amap_sdk_shaders/*.glsl`（5 个）、`cncity.txt`（1,728 B 城市拼音对照）、`map_assets/styleiconslist.data`（1,662 B，56 个图标的索引清单）、`normalize.css`/`style.css`（协议页样式）、`litepal.xml`、`title_condition.html`（16,742 B 中文服务条款）与 `title_condition_en.html`（23,400 B 英文版）。
`title_condition*.html` 与 `activate.html` **同样没有任何 Java 引用**（`grep -rn "title_condition" com/gku` → 0）→ **C 死资源**。
`dexopt/baseline.prof` + `baseline.profm` 是 Baseline Profile（配合 `ProfileInstallReceiver`，§5.1）。
`*.ms`（`angle.ms` 125,968 B、`corner.ms` 380,592 B、`detect.ms` 679,056 B）是 **HMS ML Kit 文档扫描模型**（主文档 §8 判定「仅文档扫描」的资源侧证据）。
`ap.data`(1,653 B) / `ap1.data`(1,652 B) 与 `map_assets/*.data`、`icons_assets/*.data` 全是高德渲染资源，**不含端点**。

### 7.3 assets 里的证书容器（3 个，全部是 Android BKS）

`_work/re/xtugo/apk-entries.md` 与 `assets-index.md:46-48`：

| 文件 | 解压后 | crc32 | 归属 | 判定 |
|---|---|---|---|---|
| `assets/grs_sp.bks` | 1,470 B | `e7e7c28f` | HMS GRS 的 **自签/固定证书**（`sp` = server public pin 类） | **B**：随 `grs_sdk_server_config.json` 一起用，构成 GRS 通道的**隐式证书固定**；无 appId 时不会被读 |
| `assets/hmsincas.bks` | 3,670 B | `5ce20c7c` | HMS **内部 CA**（inc = incremental/internal） | **B** |
| `assets/hmsrootcas.bks` | 34,118 B | `4e65104e` | HMS **根 CA 集合** | **B** |

→ **这是全 APK 唯一成体系的证书固定材料，且完全属于华为 ML Kit，与相机协议无关。**
反向结论（重要）：**除了这 3 个 BKS，App 对相机侧、也对自己 4 个公网后端侧都没有任何固定** —— `res/xml/network_security_config.xml` 无 `<pin>`（§3.2），OkHttp 侧无 `CertificatePinner`。相机侧因此**天然可中间人**，我们的实现不必也不应加 pin。

### 7.4 native/assets 侧的加密材料

| 项 | 证据 | 判定 |
|---|---|---|
| `libpanorama_vr.so` 内 `-----BEGIN PUBLIC KEY-----` / `-----BEGIN %s-----` / `#EXT-X-KEY:METHOD=AES-128,URI="%s"` | `_work/re/xtugo/natives.md:154-158` | **格式模板，非内嵌公钥**（`%s` 占位证明是运行时填充）→ **C** |
| `com/gku/base/utils/AESUtils.java:9-23` | `AES/CBC/PKCS5Padding`，`encrypt(String str, String str2)` | **密钥是入参**（`str2`），**类内无默认密钥常量** → 无硬编码 key |
| `com/icatchtek/pancam/core/util/VrLogger.java:18` 的 `peng.tan`、`com/gku/actioncam/hisilicon/dv/LogService.java:60` 的 `Log.log`、`com/gku/rxt/net/AppService.java:91` 的 `Tag.log` | `_work/re/xtugo/signals-hosts.tsv` | 日志 tag，**非端点**（`signals-hosts.tsv` 误分桶） |
| `_work/re/xtugo/signals-crypto.tsv`（176 条）逐条核 | 主要是 `md5/sha1/checksum` 与被 jadx 展开的 `onDestroy`/`Descriptor` 噪声；真实凭据相关只有 `com/gku/actioncam/hisilicon/dv/biz/Common.java:134`(`wifi_password`)、`…/dv/biz/HiWifiManager.java:127,152,154`、`…/dv/wifi/WifiUtils.java:138,163,165`（`getDevicePassword`）、`com/gku/actioncam/sigmastar/bean/SSWiFiInfo.java:22` | 全部是 **CGI 键名/日志前缀**；**没有任何硬编码 WiFi 口令或 API 密钥** |

### 7.5 汇总

| 来源 | 端点数 | 真会访问 | 条件触发 | 死字符串/死资源 |
|---|---|---|---|---|
| native（4 个 `.so`） | 21 | 0（公网） | 14（高德 10 + iCatch/YouTube 6 归 B） | 7（测试域、libusb.info、裸前缀） |
| assets（8 个文本 asset） | 13 | 5（4 个协议 HTML 的兜底链 + GRS 基址） | 5（GRS 5 域 / hicloud metrics 4 域属 B） | 3（`activate.html`、两个 `title_condition*.html`、`ly_menu.json.json`） |
| 证书容器 | 3 | 0 | 3（HMS） | 0 |

---

## 8. 对主文档 §1/§8 的补充与纠正

格式：**原文 → 证据（全路径:行号）→ 应改为**。

### C-01 主文档 §1.3 表 #14/#27/#33 与 §11「12 条死权限」的成员

> 原文（§11 末行）：「12 条**完全没有代码引用**：`READ_PRIVILEGED_PHONE_STATE`、`MANAGE_MEDIA`、`GET_ACCOUNTS`、`WRITE_MEDIA_STORAGE`、`MODIFY_AUDIO_SETTINGS`、`CHANGE_CONFIGURATION`、`READ_LOGS`、`SYSTEM_ALERT_WINDOW`、`GET_TASKS`、`FLASHLIGHT`（+ `ACCESS_MEDIA_LOCATION` 只由 Glide 检查、`BLUETOOTH_ADVERTISE`/`CALL_PHONE` 申请但未用）」

- `MODIFY_AUDIO_SETTINGS` **有厂商消费者**：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/controller/SSMediaController.java:124,167,214,257`、`_work/xtu_src/sources/com/gku/actioncam/widget/MediaController.java:123`（`AudioManager.setStreamMute(3,…)`）、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/player/HiDVRemoteFilePlayer.java:217`（`setStreamVolume`）。
- `READ_LOGS` **有厂商消费者**（虽然权限冗余）：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/LogService.java:152,277`、`_work/xtu_src/sources/com/gku/base/utils/LogSwitchUtils.java:31,32`。
- `MANAGE_MEDIA` **有 4 处入口**：`_work/xtu_src/sources/com/gku/HomeActivity.java:1049`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/WelcomeActivity.java:195`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:312`、`_work/xtu_src/sources/com/gku/loginmodule/utils/PermissionUtils.java:118`。
- `GET_ACCOUNTS` 并非「0 引用」而是「0 **厂商**引用」：库侧 `_work/xtu_src/sources/ca/da/ca/ha/a.java`、`_work/xtu_src/sources/ca/da/ca/ia/a.java`、`_work/xtu_src/sources/com/apm/applog/AppLog.java`、`_work/xtu_src/sources/androidx/core/content/ContextCompat.java` 有 `AccountManager`。
- `GET_TASKS` 同理：库侧 `_work/xtu_src/sources/com/apm/insight/l/a.java:207`、`_work/xtu_src/sources/com/volcengine/zeus/download/h.java:59` 调 `getRunningTasks(1)`。

**应改为**：区分两轴后写成「**6 条真·死声明**（`READ_PRIVILEGED_PHONE_STATE`、`WRITE_MEDIA_STORAGE`、`CHANGE_CONFIGURATION`、`SYSTEM_ALERT_WINDOW`、`FLASHLIGHT`、`GET_ACCOUNTS`）+ **4 条申请了但无对应功能**（`CALL_PHONE`、`BLUETOOTH_ADVERTISE`、`BLUETOOTH_ADMIN`、`MANAGE_MEDIA`）+ **2 条只被库检查**（`ACCESS_MEDIA_LOCATION`、`GET_TASKS`）= 12 条不可照抄」。总数 12 不变，成员按 §1.4 重列。

### C-02 主文档 §1.3 开头：申请权限的点只有一处

> 原文：「运行时**真正申请**的只有 `PermissionActivity` 的三套数组（`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31-33`）」

证据：另有 3 处独立数组 —— `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/WelcomeActivity.java:53-55`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:67,73,76,78,83,84`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BasePermissionActivity.java:18`。且 WelcomeActivity 那套**不含 `CALL_PHONE`**（同权限三处不同）。

**应改为**：「4 处申请点、彼此权限集不完全相同；`CALL_PHONE` 只在 `dv/ui/PermissionActivity.java:31-33` 出现」。详见 §1.0。

### C-03 主文档 §1.4 与 §11：幽灵组件是 2 个

> 原文（§1.4 表 + §11 倒数第 3 行）：「**其中 2 个 service 是清单幽灵**（`CameraSocketService`、`SSMessageService`）」；§10 未解之谜 #8 亦同。

证据：用 `_work/re/xtugo/components.tsv` 第 2 列对 `_work/re/xtugo/classes-all.tsv` 第 3 列做集合差，**118 个厂商组件里有 10 个不在 dex**，且 `_work/xtu_src/sources/` 无对应 `.java`：G1–G10 全清单见 §2.1（新增的 8 个是老 UI：`SSPlaybackActivity`、`SSPhotoRemotePlayActivity`、`SSVideoRemotePlayActivity`、`dv.live.MainActivity`、`SettingPreferActivity`、`PreferActivity`、`PreferModelActivityStr`、`PreferDeviceActivityStr`）。

**应改为**：「清单幽灵 **10 个**（2 service + 8 activity），全部属老 UI；`PreferActivity.parentActivityName` 还指向同为幽灵的 `SettingPreferActivity`」。这同时**坐实** §10 未解之谜 #8（R8 删类未删清单），可关闭。

### C-04 主文档 §1.4 首段计数

> 原文：「219 个组件中 `com.gku.*` 占 107 个（100 activity + 6 service + 1 provider）；把内置的 iCatch/`cn.rxt`/`com.example.icatch*`/`m.mifan` 一起算进『厂商侧』则 117 个」

核实：107 与 117 均**正确**（复核式见 §2.0）。补两处：① 117 的 10 个非 `com.gku` 组件是 `cn.rxt.*` 8 个 + `com.example.icatchplayerlibrary.VideoPbActivity` + `m.mifan.acase.icatch.IcatchVideoPlayerActivity`（`icatch.*`/`com.icatchtek.*` 包在清单里**注册数为 0**）；② 还有第 118 个 `com.my.AppSettingActivity` 不属于任何口径，需要显式归入「厂商侧」。

**应改为**：「…则 117 个；再加独立包的 `com.my.AppSettingActivity` 为 **118**；第三方/库 101」。

### C-05 主文档 §1.2：`networkSecurityConfig` 只写了「等价于全局允许明文」

证据：`_work/xtu_res/resources/res/xml/network_security_config.xml` 全文 4 行、0 个 `<domain>`、0 个 `<pin>`、未声明 `<trust-anchors>`；且存在未被引用的 `_work/xtu_res/resources/res/xml/network_config_base.xml`（多一段 `debug-overrides/trust-anchors src="user"`）。
**应改为**：补「厂商曾备过带用户 CA 的 debug 版本但没接上；最终生效版本无任何域名收口 → 公网 4 个后端与全部相机 HTTP 均可中间人」。

### C-06 主文档 §1.2 / §1.4：导出组件口径（厂商范围内对，全 App 范围错）

> 原文（§1.4 末注）：「`GKUCamPlayer`（`com.gku.gkucamplayer.GKUCamPlayer`）**exported=true** 且 `screenOrientation=fullSensor` —— 这是全 App 除启动器外唯一被导出的厂商组件，外部 App 可直接拉起它」

核实（`_work/re/xtugo/components.tsv` 第 4 列 grep `exported=true` → **7 行**）：
- **厂商范围内正确**：219 个组件里 `com.gku.*` 导出的确实只有 2 个 —— `com.gku.actioncam.hisilicon.dv.ui.WelcomeActivity` 与 `com.gku.gkucamplayer.GKUCamPlayer`。
- **全 App 范围内不完整**：另有 **4 个抖音 OAuth 授权回调页**也是 `exported=true` 且**无任何权限保护**（`com.bytedance.android.dy.sdk.stub.VideoAuthorizeActivityProxy`、`com.bytedance.android.openliveplugin.stub.activity.DouyinAuthorizeActivityProxy`、`…DouyinAuthorizeActivityLiveProcessProxy`（`process=:bytelive`）、`com.bytedance.android.openlive.broadcast.stub.activity.DouyinAuthorizeActivityProxy`），以及受 `android.permission.DUMP` 保护的 `androidx.profileinstaller.ProfileInstallReceiver`。逐条见 §2.6 E1–E7。
- **更要紧的新证据**：`GKUCamPlayer` 不止「可被拉起」，它还**吃外部参数**——`_work/xtu_src/sources/com/gku/gkucamplayer/GKUCamPlayer.java:38-39` 读 `kPlayFilePath`/`kPlayFileName`，`:47` 与 `:139` 直接 `GSYVideoOptionBuilder.setUrl(this.url)` 交给 ExoPlayer（`:36` `PlayerFactory.setPlayManager(Exo2PlayerManager.class)`）播放 → 任意 App 可让它拉任意 `http://`/`file://`/`rtsp://`。§5.4 已按此改写。

**应改为**：「唯一被导出的**厂商**组件（全 App 共 7 个导出：2 厂商 + 4 抖音授权回跳 + 1 `ProfileInstallReceiver`）；且 `GKUCamPlayer` 会把 `getStringExtra("kPlayFilePath")` 原样交给播放器 → 属**可注入 URL 的导出 Activity**，不是单纯的界面劫持」。

### C-07 主文档 §8 高德行：「清单没给 key」——**结论对，但论据是错的**

> 原文（§8 高德行 + §10 #10）：「无 `com.amap.api.v2.apikey` meta-data；`manifest.md` §7 meta-data 表为空」

实测：① 高德确实无 key（`grep com.amap.api.v2.apikey` 于原始清单 → 0 命中，全树亦无 `setApiKey`）→ **结论成立**。
② 但「manifest 里没有任何 meta-data」**是取证工具的漏采**：`_work/re/xtugo/manifest.md:418-428` 的「全应用 meta-data」表只收了 7 条**组件级**，**漏掉了 19 条 `<application>` 级**（`_work/xtu_res/resources/AndroidManifest.xml:123, 272, 599, 646, 649, 785, 788, 791, 1010, 1013, 1116, 1123, 1184, 1187, 1190, 1193, 1196, 1203, 1206`）。全表见本附录 §3.3。
③ 漏采里最要紧的两条：`UMENG_CHANNEL=product_GooglePlay`（→ 直接推翻 §8 的「必然抛异常」，见 C-08）与 `com.google.android.geo.API_KEY=AIzaSyAu4dYAjvpBVwWJtUKB19MEnQ5MsKn2bPE`（→ 说明这码原本接的是 **Google 地图**，与 `LocationUtil` 用 Play Services 一致；后来才叠了高德，两套并存）。
④ 另有 4 组**明文 zeus 插件 appKey/appSecretKey**（§3.3 M4/M6/M7/M9）。

**应改为**：把「manifest 里没有任何 meta-data」改成「manifest 的 `<application>` 级 meta-data 有 19 条（清单工具漏采），但**其中没有高德 key、没有 HMS appId、没有 QQ/微信 AppID**」；§8 高德行补「原生 SDK 侧还有 `m5.amap.com`/`mpsapi.amap.com` 瓦片口（§7.1），Java 侧真实调用在 `com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:389,497,667`」。

### C-08 主文档 §8/§11：`UMENG_CHANNEL`「必然抛异常」

> 原文（§8 友盟行）：「但 manifest 里 **没有任何 meta-data**，`UMENG_CHANNEL` 必然抛异常 → `NameNotFoundException` 被包成 RuntimeException（潜在崩溃点）」；§11 倒数第 2 行同引 `com/gku/crashhandle/CrashReportManager.java:32`

实测（文件全文 59 行，`_work/xtu_src/sources/com/gku/crashhandle/CrashReportManager.java`）：
- `:24` `initCrashReport(Context)`；`:26` `new CrashReport.UserStrategy(context)`；`:27-29` `android_id` 同当 userId/deviceID；`:30` `setDeviceModel`；`:31-32` `setAppPackageName`；
- `:33` 进 `try`，`:34` `getPackageInfo(packageName, 0).versionName`；`:38` `getApplicationInfo(packageName, 128)`（`GET_META_DATA`）；**`:40` `applicationInfo.metaData.getString("UMENG_CHANNEL")`**；`:41-43` **null → 空串**；`:44-45` `setAppVersion`/`setAppChannel`；**`:48` `CrashReport.initCrashReport(context, BuildConfig.BuglyId, isDebuggable.booleanValue(), userStrategy)`**；`:49-51` `catch (PackageManager.NameNotFoundException e) { throw new RuntimeException(e); }`。
- 而 `_work/xtu_res/resources/AndroidManifest.xml:123` 明确声明了 `UMENG_CHANNEL=product_GooglePlay`。

**应改为**：行号 `:32` → **`:40`**（`initCrashReport` 在 `:48`，不是 `:38`）；删除「必然抛异常 / 潜在崩溃点」——该 meta-data **存在且被正常读到**；`catch(NameNotFoundException)` 只覆盖 `:34` 的 `getPackageInfo`，实际不会触发。**唯一真实的残余风险**是「若某构建把 `<application>` 级 meta-data 全清空，则 `applicationInfo.metaData` 为 `null` → `:40` 抛 **NPE 且不被 `:49` 捕获**」，这与本包无关。§11 的「友盟仅剩一个 meta-data 读取残留」结论**仍成立**（读的是自己清单里的一条渠道号，跟友盟 SDK 无关）。

### C-09 主文档 §8 后端域名行：`device.gkuvision.com/static/…` 是**唯一**隐私页地址

> 原文（§8 末段）：「`https://device.gkuvision.com/static/…`（`_work/xtu_src/sources/com/gku/module_my/ConstantsMy.java:10-16`）」

证据：assets 里的协议 HTML 顶部注释暴露了**第二套**线上地址 `https://www.gkuvision.com/special/{xtugo_privacy_en,xtugo_useragreement_cn,xtugo_useragreement_en}.html`（`_work/re/xtugo/assets-content.md:1957`、`:2078`、`:2136`），与代码常量 `device.gkuvision.com/static/…`（`_work/xtu_src/sources/com/gku/module_my/ConstantsMy.java:10,12,14,16`）**子域和路径都不同**。并且 `com/gku/module_my/ConstantsMy.java:11,13,15,17` 为每个协议都配了一个 asset 文件名，走 `_work/xtu_src/sources/com/gku/base/webview/WebViewUtils.java:201` 的 `file:///android_asset/<name>` 兜底（调用者 `com/gku/module_my/ConstantsMy.java:19-27` 的 `loadPrivacy`/`loadUserAgreement`）。
**应改为**：补「协议页有 3 个地址位：`www.gkuvision.com/special/…`（真实线上，仅出现在 asset 注释）、`device.gkuvision.com/static/…`（代码常量）、`assets/xtugo_*.html`（离线兜底，**网络优先**）」。

### C-10 主文档 §1.3 表 #33 与 §1.4：`READ_LOGS` 判「死声明」与 `LogService` 职责自相矛盾

> 原文（§1.3 #33）：「`READ_LOGS` | 全树 grep = 0（Android 4.1+ 也只能读自己） | **死声明**」；
> 原文（§1.4 表）：「`com.gku.actioncam.hisilicon.dv.LogService` | service | `exported=false` | 日志落盘/上传」

证据：`LogService` 的真实职责比「落盘/上传」多三件事，且它就是 `READ_LOGS` 的消费者：
`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/LogService.java:84`（`newWakeLock(1, TAG)`）+ `:135`（`acquire()`）+ `:152,277`（把 `logcat` 放进命令列表起子进程）+ `:196`（按 `processInfo.name=="logcat" && user==appUser` 找自己那条 logcat 进程）+ `:91,92`（`MEDIA_MOUNTED`/`MEDIA_UNMOUNTED` 注册，receiver 在 `:588`）+ `:60`（`Log.log` 文件名）。
另有第二个抓取点 `_work/xtu_src/sources/com/gku/base/utils/LogSwitchUtils.java:31,32`（`logcat -c`、`logcat --pid=<myPid> -v time -f <file>`）。

**应改为**：§1.3 #33 的判定从「死声明」改成「**声明冗余**：有真实 `logcat` 消费者，但 Android 4.1+ 读自身进程日志不需要该权限（普通 App 申请后系统也不给）→ 对我们仍是『不要照着申请』」；§1.4 的 `LogService` 职责补成「WakeLock + logcat 子进程抓取 + SD 卡插拔监听 + 落盘上传」。同时 §11 的「12 条完全没有代码引用」成员按 C-01 重列。

### C-11 主文档 §1.4：组件表遗漏 6 个厂商 activity

主文档 §1.4 的表列了 13 行「主干」。实数：`com.gku.*` **100 个 activity**。§2.4 给出全 100 + 11 个内置 iCatch 面 activity 的逐个表，其中新增被漏掉且值得点名的有：
`com/gku/actioncam/amba/ui/stream/wifi/WIFITypeinActivity`、`…/wifi/WIFIListActivity`（直播选网）、`com/gku/actioncam/remote_live/{QRShowActivity,ScanWifiActivity,SelectLiveActivity,custom/CustomLiveActivity}`（**远程直播四件套**，主文档 §1.4 完全没提 `remote_live` 包）、`com/gku/amba/{AmbaPicPreviewActivity,AmbaCameraFileActivity}` 与 `com/gku/hisi/{Hisi_PicPreviewActivity,Hisi_CameraFileActivity}`（`CALLBACK_CHOOSE_CLICK` 文件选择对偶）、`com/gku/base/permission/PermissionActivity`（`launchMode=singleInstance` 的权限中转页，与 §1.0 的 4 个申请点之一）。

### C-12 主文档 §8「高德」行的证据可加强

> 原文：「`com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:23-32` 用 `AMap/MapView/CoordinateConverter`」

补充到「真会发请求」级别：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:389`（`gaodeAMap.addMarker`）、`:497`（`animateCamera`）、`:667`（`addPolyline`）；且 native `libAMapSDK_MAP_v10_0_600.so` 内嵌 `m5.amap.com`/`mpsapi.amap.com` 瓦片口（§7.1）。`_work/re/xtugo/manifest.md:418-428` 的 meta-data 表 7 行全属库，确认无 key。

---

## 9. 本附录未确认的点

| # | 未确认 | 缺什么 |
|---|---|---|
| U1 | 10 个幽灵是 R8 删的还是源码里就注释掉了 | 需要 `classes*.dex` 的原始 `dexdump` 比对（本附录用 `classes-all.tsv` 已足以判定「不在 dex」） |
| U2 | `com.my.AppSettingActivity` 究竟属于哪个 SDK | 该类无 meta-data、无 filter，包名独立；需继续读 `com/my/**` 源码链 |
| U3 | `signals-hosts.tsv` 的生成规则 | 它的 501 条**不含任何公网域名**（`grep gkuvision\|amap\|aliyuncs\|bugly\|douyin\|volc` 全 0），实为「点号标识符」桶。因此 §4 的域名是从 `own-literals.tsv` + 库源码 `"http…"` 字面量 + `natives-strings.tsv` 重建的，**与主文档引用的 hosts.tsv 不同源**，需要在 `tools/re/` 里补一个真正的域名抽取器 |
| U4 | `applicationInfo.metaData` 是否可能为 `null` → `com/gku/crashhandle/CrashReportManager.java:40` 抛 **NPE**（不被 `:49` 的 `catch(NameNotFoundException)` 捕获） | 本包 `_work/xtu_res/resources/AndroidManifest.xml:123` 声明了 `UMENG_CHANNEL`，故当前不会；需在「去掉全部 app 级 meta-data」的重打包上验证 |
| U5 | 高德无 key 时到底是「白屏」还是「崩溃」 | 装机复现（主文档未解之谜 #10 同一件事，本附录只提供端点与调用行） |
| U6 | `libpanorama_vr.so` 的 YouTube OAuth `client_id` 在哪 | 库内只有 `Authenticator::setUsernameAndPassword` 与 URL 模板（§7.1）；Java 侧未见传参 → 可能在 iCatch 固件侧或未编译进本 App 的调用路径 |
