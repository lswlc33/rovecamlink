# 附录 E · 权限、组件与域名

> 对象：`com.gku.xtugo` 8.4.3_243（`相机 app/XTU GO_8.4.3_243_2026-08-19-17-05-43.apk`）
> 本附录是 `02-XTUGO-档案.md` §1.2/§1.3/§1.4、§8 的展开件。主文档给结论，这里给**逐条到行**的证据。
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
| 5 | `WRITE_EXTERNAL_STORAGE` | **29** | `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java:221,222`；`com/gku/actioncam/hisilicon/dv/ui/data/FileUtils.java:42,47`；`FragmentConnectedCamera.java:192,255` | 直写 `/DCIM/...` 绝对路径 | 固件/媒体下载落盘 | **在用（≤29）**，清单已用 `maxSdkVersion=29` 收口 |
| 6 | `MANAGE_MEDIA` | — | 0 字符串；但有 4 处跳授权入口：`com/gku/HomeActivity.java:1049`、`com/gku/actioncam/hisilicon/dv/ui/WelcomeActivity.java:195`、`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java:312`、`com/gku/loginmodule/utils/PermissionUtils.java:118`（`Intent("android.settings.REQUEST_MANAGE_MEDIA")`） | **0**：全树没有任何受 `MANAGE_MEDIA` 保护的 `MediaStore` 批量写/删调用 | 只把用户送到「允许管理所有文件」设置页 | **半死**：入口在、消费者无（见 §8 C-02） |
| 7 | `ACCESS_MEDIA_LOCATION` | — | 唯一命中在库：`com/bumptech/glide/load/model/stream/QMediaStoreUriLoader.java:159`（`checkSelfPermission`） | 厂商侧 0 | Glide 加载带 GPS 的媒体 URI 时自检 | **只被库检查** |
| 8 | `ACCESS_WIFI_STATE` | — | 申请点 A/B/C（`PermissionActivity.java:31-33`、`WelcomeActivity.java:53`、`MyBottomSheetDialog.java:83`） | `HiWifiManager`、`com/gku/base/utils/WifiUtils.java`；Ambarella `msg_id=261` 取本机 IP 用（`com/gku/actioncam/amba/model/AmbaCmdModel.java:279`） | 连接前取手机 IP、扫/切 AP | **在用** |
| 9 | `CHANGE_WIFI_STATE` | — | 同上申请点 | `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java:493-500` 主动 `disconnectWifi()` 再连相机 AP | 配网切 AP | **在用** |
| 10 | `CHANGE_NETWORK_STATE` | — | 同上申请点 | `com/gku/base/device/NetworkDeviceUtils.java:332-358`（`bindProcessToNetwork` 路径） | 把进程绑到相机网卡 | **在用** |
| 11 | `READ_PHONE_STATE` | — | `com/gku/base/utils/DeviceInfoUtils.java:80,112`；`com/gku/HomeActivity.java:950`（`shouldShowRequestPermissionRationale`） | `telephonyManager.getImei()/getDeviceId()`：`DeviceInfoUtils.java:86,90,93`、`com/gku/actioncam/sigmastar/util/SystemUtil.java:49` | 取设备标识（崩溃上报/反馈） | **在用（弱）**：仅设备标识，功能不依赖 |
| 12 | `ACCESS_COARSE_LOCATION` | — | 申请点 A/B/C（`PermissionActivity.java:31-33`、`MyBottomSheetDialog.java:67`） | `com/gku/base/utils/LocationUtil.java`（`FusedLocationProviderClient`）；高德坐标转换 `com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:23-32` | GPS 轨迹水印/轨迹页 | **在用** |
| 13 | `ACCESS_FINE_LOCATION` | — | `com/gku/loginmodule/utils/PermissionUtils.java:21`（常量 `LOCATION`）、`:129`；被 A/B/C 三处数组引用 | 同上 | 同上 | **在用** |
| 14 | `GET_ACCOUNTS` | — | **0**（厂商侧）。`AccountManager` 只出现在库：`androidx/core/content/ContextCompat.java`、`ca/da/ca/ha/a.java`、`ca/da/ca/ha/b.java`、`ca/da/ca/ia/a.java`、`com/apm/applog/AppLog.java` | 厂商 0 | 无 | **死声明**（见 §8 C-01） |
| 15 | `FOREGROUND_SERVICE` | — | 字符串仅库命中：`com/amap/api/col/p0003l/d.java:1873`（高德反射 `checkSelfPermission`） | **厂商实调**：`com/gku/actioncam/hisilicon/dv/net/MessageService.java:59` `startForeground(10121, …)`；`com/gku/actioncam/sigmastar/OldUi/playback/model/service/DownloadIntentService.java:46` | 5678 回拨常驻监听、回放下载通知 | **在用**（无需字符串，API 即触发） |
| 16 | `WAKE_LOCK` | — | 0 字符串 | `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java:391` `mWakeLock.acquire()`；`com/gku/actioncam/hisilicon/dv/LogService.java:84` `newWakeLock(1,…)` + `:135` `acquire()`；`com/gku/actioncam/sigmastar/upgrade/firm/Presenter/UpgradePresenter.java:301-302` `newWakeLock(268435466,…)`+`acquire()` | 播放器保屏、日志落盘、固件传输 | **在用** |
| 17 | `BLUETOOTH_CONNECT` | — | 申请点 A/B/C（`PermissionActivity.java:32,33`、`MyBottomSheetDialog.java:76,78`） | `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:910-918`（`checkBlePermission`，所有 `writeCharacteristic` 前） | BLE 连接/GATT 读写 | **在用** |
| 18 | `BLUETOOTH_SCAN` | — | 同上 | `BLEConnectUtils.java:912`；扫描过滤 `com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/DeviceAddActivity.java:125` | 配网扫描 | **在用** |
| 19 | `BLUETOOTH` | **30** | 申请点 A（`PermissionActivity.java:31`）、B、D（`BasePermissionActivity.java:18`）、`MyBottomSheetDialog.java:73,84` | 旧版 `BluetoothAdapter` 路径 | ≤30 的蓝牙 | **在用（≤30）** |
| 20 | `BLUETOOTH_ADMIN` | **30** | 唯一命中 `com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BasePermissionActivity.java:18` | 厂商树内**未见** `startDiscovery()`/`cancelDiscovery()`（grep 0 命中） | 声明在配网页权限数组里，实际走 BLE 而非经典 discovery | **在用（名义）**：仅被申请，无 ADMIN 专属 API（见 §8 C-04） |
| 21 | `BLUETOOTH_ADVERTISE` | — | 申请点 A/B/C（`PermissionActivity.java:32,33`、`MyBottomSheetDialog.java:76,78`） | **0**：全树无 `startAdvertising`/`BluetoothLeAdvertiser` | 只是被一起弹窗申请 | **申请了但未用** |
| 22 | `READ_MEDIA_IMAGES` | — | 常量 `com/luck/picture/lib/permissions/PermissionConfig.java:12`，被厂商数组引用：`com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:33` | 相册选择 | ≥33 首启 | **在用（≥33）** |
| 23 | `READ_MEDIA_AUDIO` | — | `PermissionConfig.java:11`；`PermissionActivity.java:33` | 视频编辑选配乐 | ≥33 | **在用（≥33）** |
| 24 | `READ_MEDIA_VIDEO` | — | `PermissionConfig.java:13`；`PermissionActivity.java:33` | 本机相册回放/剪辑 | ≥33 | **在用（≥33）** |
| 25 | `WRITE_MEDIA_STORAGE` | — | **0** | **0** | 无 | **死声明**（`signature`，OS 分区权限） |
| 26 | `WRITE_SETTINGS` | — | 0 字符串 | `com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:1215`（`Settings.System.canWrite`）+ `:1222`（`putInt("accelerometer_rotation", …)`）；`HisiActionCameraPreviewActivity.java:1226,1233`；`com/gku/base/permission/PermissionUtils.java:183`、`com/gku/base/permission/PermissionActivity.java:60,120` | 预览页「自动旋转」开关 | **在用**（特殊权限，走 `MANAGE_WRITE_SETTINGS` 设置页） |
| 27 | `MODIFY_AUDIO_SETTINGS` | — | 0 字符串 | `com/gku/actioncam/sigmastar/widget/controller/SSMediaController.java:124,167,214,257` 与 `com/gku/actioncam/widget/MediaController.java:123`（`AudioManager.setStreamMute(3,…)`）；`com/gku/actioncam/hisilicon/dv/player/HiDVRemoteFilePlayer.java:217`、`com/gku/ffm/zqvideo/video/base/GSYVideoControlView.java:863`（`setStreamVolume`） | 回放播放器静音/音量手势 | **在用**（正常权限，装即授；见 §8 C-01） |
| 28 | `RECORD_AUDIO` | — | `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java:788,854,859,899` | 语音反馈录制、视频编辑配音 `com/gku/actioncam/sigmastar/videoedit/AudioCollectActivity.java` | 反馈页录音 | **在用** |
| 29 | `CAMERA` | — | `com/gku/loginmodule/utils/PermissionUtils.java:20,134` | 扫码/拍照反馈（预览画面是相机流，不用本机相机） | 扫一扫配网 | **在用（弱）** |
| 30 | `VIBRATE` | — | 0 字符串 | `com/gku/base/utils/VibratorUtils.java:11` `vibrator.vibrate(50L)` | 按键/扫码反馈 | **在用** |
| 31 | `CALL_PHONE` | — | `com/gku/actioncam/hisilicon/dv/ui/PermissionActivity.java:31,32,33`（三套数组都带）；`com/gku/actioncam/hisilicon/dv/ui/weight/MyBottomSheetDialog.java` 与 `WelcomeActivity.java:53` **均不含** | **0**：`com/gku` 树内无 `ACTION_CALL`、无 `"tel:` | 只在首启授权页弹窗里出现 | **申请了但未用**（危险权限，白要） |
| 32 | `CHANGE_CONFIGURATION` | — | **0** | `com/gku/base/utils/LanguageUtils.java:101` 是 `Resources.updateConfiguration`（**不需要该权限**）；全树无 `ActivityManager.updateConfiguration` | 无 | **死声明**（签名权限） |
| 33 | `READ_LOGS` | — | 0 字符串 | **有真实消费者**：`com/gku/actioncam/hisilicon/dv/LogService.java:152,277`（`logcat` 子进程）、`com/gku/base/utils/LogSwitchUtils.java:31,32`（`logcat -c`、`logcat --pid=<myPid> -v time -f <file>`） | 诊断日志落盘/上传 | **名义在用**：Android 4.1+ 读**自己进程**的日志不需要此权限，故声明是冗余（见 §8 C-01） |
| 34 | `SYSTEM_ALERT_WINDOW` | — | **0** | **0**：全树无 `TYPE_APPLICATION_OVERLAY`/`canDrawOverlays` | 无 | **死声明** |
| 35 | `GET_TASKS` | — | **0**（厂商）；`getRunningTasks(1)` 只在库：`com/apm/insight/l/a.java:207`、`com/volcengine/zeus/download/h.java:59` | 厂商侧仅 `getRunningAppProcesses`（`com/gku/dashcam/icatch/appinfo/AppInfo.java:52`，不需要此权限） | 无（厂商功能） | **只被库检查**；且该权限 Android 5.0 起已失效 |
| 36 | `FLASHLIGHT` | — | **0** | **0**：全树无 `FEATURE_FLASHLIGHT`、无 `setTorchMode` | 无 | **死声明** |
| 37 | `com.asus.msa.SupplementaryDID.ACCESS` | — | 由 MSA/OAID SDK 使用：`ca/da/da/a.java:13,25,45`（`ComponentName("com.asus.msa.SupplementaryDID", …SupplementaryDIDService")`、AIDL token `"com.asus.msa.SupplementaryDID.IDidAidlInterface"`）、`ca/da/da/ca/c.java:33` | 华硕机型上跨进程取 OAID | 隐私/崩溃上报取广告标识 | **只被库检查**（非华硕机型无效果） |

> 表中的行：38 条 `uses-permission` 全部列出（第 37/38 行分别是 AndroidX 自签权限与华硕 MSA 权限，自签权限见 §1.2）。

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

### 2.4 厂商 activity（100 条，逐个一行）

`exported` 全为 `false`（**未写 = false**，见 §2.6 说明），除 `WelcomeActivity`（LAUNCHER）与 `GKUCamPlayer`。以下「属性」列从 `_work/re/xtugo/components.tsv` 第 4 列原样摘（去掉 `theme=@style/` 前缀）。

| 类名（全限定，省略 `com.gku.`） | 类型 | 清单属性（原样） | dex/源码 | 职责（一句话，读代码得出） |
|---|---|---|---|---|
| `SendSoftActivity` | activity | Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait | ✅ | 把手机侧下载到的固件包经 `FwUpload`/`RegisterDeviceToServer` 推到 8080 二进制口 |
| `actioncam.hisilicon.dv.ui.WelcomeActivity` | activity | welcomeTheme_XTU; **exported=true**; screenOrientation=portrait | ✅ | 唯一 LAUNCHER 入口 + 隐私弹窗 + Bugly 初始化（`com/gku/crashhandle/CrashReportManager.java:14-45`）+ 首启权限申请（`:53-55`） |
| `HomeActivity` | activity | CustomActionBar; launchMode=singleTask; screenOrientation=portrait | ✅ | 连接编排中枢：CGI 探测→平台分派（`com/gku/HomeActivity.java:1707-1783`）、OSS STS 上传（`:859`） |
| `gkucamplayer.GKUCamPlayer` | activity | **exported=true**; screenOrientation=fullSensor | ✅ | 全 App 除启动器外**唯一被导出的厂商组件**；相机流播放器，无 intent-filter（只能显式组件名拉起） |
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
| `actioncam.sigmastar.OldUi.preview.ui.activity.*`（已在上） | — | — | — | — |
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
| `actioncam.hisilicon.dv.ui.data.connect.HWScaningActivity`（已在上） | — | — | — | — |
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

| 库家族 | 组件数 | 类型分布 | 进程 | 备注 |
|---|---|---|---|---|
| 抖音 OpenLive / bytedance（`com.bytedance.android.dy.sdk.stub.*`、`com.bytedance.android.openlive.broadcast.stub.activity.*`、`com.bytedance.android.openliveplugin.stub.activity.*`、`com.bytedance.bdinstall.migrate`） | **68** | 全 activity | `:bytelive` | 大量 stub 是插件化占位坑位，**不可被业务语义理解** |
| 字节 zeus/broadcast-lite（`com.byted.live.lite.*`、`com.byted.broadcast.lite.*`、`com.volcengine.zeus.*`） | **22** | 18 activity + 4 provider | `:bytelive`/`:push`/`:downloader` | 见 §3.2 的 authorities 命名 |
| 字节 socialbase downloader（`com.ss.android.socialbase.downloader.*`） | **6** | 5 service + 1 activity | `:downloader` | 唯一带 intent-filter 的 service：action `com.ss.android.socialbase.downloader.remote`（`_work/re/xtugo/components.tsv` service 行，`exported=false`） |
| LuckPicture（`com.luck.picture.lib.*`） | **5** | 2 activity + 1 service + 1 provider + 1 | — | `PictureFileProvider`，`foregroundServiceType=location` |
| Huawei（HMS ScanKit / MLKit / AGConnect） | **4** | 1 activity + 1 service + 2 provider | — | `MLInitializerProvider`、`AGConnectInitializeProvider`、`ServiceDiscovery` |
| AndroidX（startup / room / camera / car / profileinstaller / car.app） | **8** | 3 activity + 2 service + 2 receiver + 1 provider | — | `ProfileInstallReceiver` 是**全 App 唯一 exported=true 的库组件**，但受 `android.permission.DUMP` 保护 |
| Google Play services（`com.google.android.gms.common.api.*`） | **1** | activity | — | 授权中转坑位 |

合计 101，与 §2.0 表格一致。

### 2.6 关于「exported 未写」的口径

manifest 里**未写 `android:exported` 的组件**：所有 `<activity>` 除 `WelcomeActivity`、`GKUCamPlayer` 外都没有 intent-filter，按 Android 12+（targetSdk=35）**默认 false**。`com.gku.CameraSocketService`（G1）无任何属性 → 同样默认 false。
→ **全 219 个组件里 exported=true 的只有 3 个**：`com.gku.actioncam.hisilicon.dv.ui.WelcomeActivity`、`com.gku.gkucamplayer.GKUCamPlayer`、`androidx.profileinstaller.ProfileInstallReceiver`（后者有 `DUMP` 权限保护）。

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

旁边还有一个**未被清单引用**的 `network_config_base.xml`（`_work/xtu_res/resources/res/xml/network_config_base.xml`，6 行）：

```xml
<network-security-config>
    <base-config cleartextTrafficPermitted="true"/>
    <debug-overrides>
        <trust-anchors><certificates src="user"/></trust-anchors>
    </debug-overrides>
</network-security-config>
```

→ 说明厂商**写过**带 debug 用户 CA 的版本（可配合 mitmproxy 抓包），但最终 manifest 指向的是**没有** `debug-overrides` 的那份。抓包侧因此必须在 release 上装用户 CA 才行不通，需 frida 绕过 —— 这是 §4 判定只能靠静态的原因。

其余 `res/xml/`：`paths_base.xml`（FileProvider，见 §6）、`ps_file_paths.xml`（LuckPicture）、`file_paths.xml`（未被清单引用）、`preferences.xml` + `settingpreferences.xml`（主文档 §4.3 的**老方言静态设置表**，其宿主 `SettingPreferActivity`/`PreferActivity` 已成幽灵 G7/G8 —— 资源还在，代码没了）。

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
| `https://server4.gkuvision.com` | `_work/xtu_src/sources/com/gku/module_base_xtugo/BuildConfig.java:8`（`URL_SERVER`）；`com/gku/module_base_xtugo/api/ApiUtils.java:12`；`com/gku/loginmodule/network/NetworkApi.java:44` | 厂商主后端 | **A**：`NetworkApi` 在 `BaseApplication.java:53` 的 `NetworkApi.init(new NetworkRequiredInfo(this))` 链上，Retrofit base url |
| `https://server4.gkuvision.com/push/api/getNewestVersion?firmWareModel=XTUGO_Android` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/upgrade/app/UpgradeViewManager.java:648` | 厂商 App 升级 | **A**：升级弹窗路径，`ACTION_VIEW`(`:639`)/`INSTALL_PACKAGE`(`:634`) 紧随其后 |
| `https://server4.gkuvision.com/push/api/getNewestVersion?firmWareModel=` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/upgrade/firm/Presenter/UpgradePresenter.java:165` | 厂商**固件**版本查询 | **A**：`UpgradePresenter` 由 `…/firm/Ui/*` 页面驱动 |
| `http://121.40.107.215:8041/firmware/` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/upgrade/app/UpgradeTaskManager.java:35`；`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/updateapp/UpgradeManager.java:35` | 厂商固件目录（**裸 IP + 明文**） | **A**：两处都是 `getMatchedFirmware`/`serverHaveLatestAPK` 的基址（调用者 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/setting/AboutCameraActivity.java:41`、`…/dv/updateapp/DownloadActivity.java:89,128,180,184`） |
| `http://121.40.107.215:8041/firmware/info.json` | `…/sigmastar/upgrade/app/UpgradeTaskManager.java:843`；`…/dv/updateapp/UpgradeManager.java:843` | 固件清单 | **A**：`DownloadActivity.java:89` 把返回串交给 `UpgradeManager.parseServerFileList(string)` |
| `http://www.gkuvision.com:8882/upload/update.xml` | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:22`（`API_APP_SERVICE_HOST_IP`）；消费者 `AppService.java:101` | iCatch/记录仪线的 App 更新 | **A（条件）**：仅 `com.gku.rxt`（iCatch 记录仪）流程；协议是明文 XML |
| `http://api.shhc-yh.com/api/` | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:23`（`API_FW_SERVICE_HOST_IP`） | 第三方托管（上海环创？） | **D 死常量**：除 `AppService.java:40` 的 Kotlin `@Metadata` 反射元数据外，**全树零消费者**（`grep -rn API_FW_SERVICE_HOST_IP` 只有声明行） |
| `http://api.shhc-yh.com/` | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:24`（`API_SERVICE_HOST_IP`） | 同上 | **D 死常量**：同上，无消费者 |
| `http://api.dashcamplayer.net/api/aliyun/uptoken` | `_work/xtu_src/sources/com/gku/rxt/net/AppService.java:97`（`postJson`） | **阿里云 STS 下发口** | **A**：`ossPost` 的唯一调用者是 `_work/xtu_src/sources/com/gku/HomeActivity.java:843` `AppService.INSTANCE.getInstance().ossPost(...)`，回调 `:859` 建 `OSSClient` |
| `https://device.gkuvision.com/static/xtugo_privacy_cn.html` | `_work/xtu_src/sources/com/gku/module_my/ConstantsMy.java:10` | 隐私政策 | **A**：`com/gku/actioncam/hisilicon/dv/setting/PrivacyAgreementActivity.java:58`、`com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment2.java:675` |
| `https://device.gkuvision.com/static/xtugo_privacy_en.html` | `ConstantsMy.java:12` | 同上（英文） | **A**：`PrivacyAgreementActivity.java:63`、`BroadcastDouyinFragment2.java:677` |
| `https://device.gkuvision.com/static/xtugo_useragreement_cn.html` | `ConstantsMy.java:14` | 用户协议 | **A**：`PrivacyAgreementActivity.java:56` |
| `https://device.gkuvision.com/static/xtugo_useragreement_en.html` | `ConstantsMy.java:16` | 同上 | **A**：`PrivacyAgreementActivity.java:61` |
| `https://play.google.com/store/apps/details?id=com.gku.yutupro` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/setting/AboutClientActivity.java:164` | 跳**另一品牌** App | **A**：与 `queries{com.gku.yutupro}`（`_work/re/xtugo/manifest.md:113-120`）配套 |
| `http://www.xtucam.com/index.php?r=article/Category/index&class_id=19` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:212` | 官网（**明文 HTTP**） | **A**：用户中心列表项，点击走 WebView |
| `https://www.xtucam.com/index.php?r=article/Category/index&class_id=19` | `…/UserCenter.java:224` | 官网（社交区？HTTPS 版） | **A**：同列表另一项 |
| `https://m.weibo.cn/p/1005055290451249` | `…/UserCenter.java:208` | 微博主页 | **A（仅外链）** |
| `https://www.facebook.com/` | `…/UserCenter.java:219`；`_work/xtu_src/sources/com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java:203` | 社媒 | **A（仅外链）**，无具体账号 |
| `https://www.youtube.com/` | `…/UserCenter.java:221`；`UserCenterNewFragment.java:204` | 社媒 | **A（仅外链）** |
| `https://shop183741064.m.taobao.com` | `…/UserCenter.java:204` | 淘宝店 | **A（仅外链）** |
| `https://xtucp.tmall.com/?spm=a1z10.3-b-s.w20166435-22198852064.1.35dc182aeGhCvE&scene=taobao_shop` | `…/UserCenter.java:205`；`UserCenterNewFragment.java:198` | 天猫店 | **A（仅外链）** |
| `https://h5.m.jd.com/dev/RLVegkgjdNJoM4Y1WsvAnKLD7Qw/index.html?appurl=https%3A%2F%2Fshop.m.jd.com%3FshopId%3D807701%26utm_source%3Dpdappwakeupup_20170002` | `…/UserCenter.java:206`；`UserCenterNewFragment.java:199` | 京东店（shopId 807701） | **A（仅外链）** |
| `https://z.douyin.com/p53t?scheme=snssdk1128%3A%2F%2Fgoods%2Fstore%3Fsec_shop_id%3DQMnJSSw%26entrance_location%3Ddou_shop_ad_101_2%26tab_id%3D16%26url_maker%3Dshop_sdk` | `UserCenterNewFragment.java:200` | 抖音店（`sec_shop_id=QMnJSSw`）；含 **`snssdk1128://` 深链** | **A（仅外链）** |
| `http://mobile.yangkeduo.com/mall_page.html?mall_id=640975089 ` | `UserCenterNewFragment.java:201` | 拼多多店（**注意原串尾部有一个空格**） | **A（仅外链）** |
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
| `com.aliyun.oss.internal.OSSConstants.PROTOCOL_HTTP`（值 `"http://"`） | 被厂商**当字符串常量到处拼 URL**：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/CheckAppVersionUtils 风格` 见 `com/gku/rxt/net/CheckAppVersionUtils.java:324`、`com/gku/actioncam/hisilicon/dv/biz/Setting.java:311`、`…/dv/net/HttpProxy.java:143,181`、`…/dv/biz/DV.java:332` | **C（巧合复用，无网络含义）**：⚠️ 互操作时**不要**把它当 OSS 依赖 |

**高德 AMap（地图 v10.0.600）** —— **B（会发请求，但因无 key 必然鉴权失败）**：
Java 侧真实使用 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java:389,497,667`（`addMarker`/`animateCamera`/`addPolyline`）；
`ServiceSettings`/`MapsInitializer.setApiKey` **全树 0 命中**，清单 meta-data 表（`_work/re/xtugo/manifest.md:418-425`）**无 `com.amap.api.v2.apikey`** → 鉴权必失败。

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
| `snssdk1128://goods/store?sec_shop_id=QMnJSSw&…` | `UserCenterNewFragment.java:200`（URL 编码在 https 短链里） | **A（外链）**：拉起抖音 App |

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

`_work/re/xtugo/signals-fullUrls.tsv` 里 `http://%s…` 共 66 条，逐条语义已在 `02-XTUGO-档案-附录-海思CGI全表.md`；此处只登记**模板与出处**，并按前缀归类：

| 模板 | 出处（全路径:行） | 用途 |
|---|---|---|
| `http://%s%s%s` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Command.java:36`、`…/dv/biz/RemoteFileManager.java:14` | 海思 CGI 总模板（ip + `/cgi-bin/hi3510/` + cmd） |
| `http://%s%s/<cgi>?` ×39 | `com/gku/actioncam/hisilicon/dv/biz/Setting.java:30,34,38,45,89,122,131,137,141,145,149,153,183,187,191,195,199,203,207,211,215,219,223,227,238,245,252,256,260,264,268,276,280,284,288,326,330,334,338,342,346,350,354,358,464,514,518,522,526,530,534,538,542,546,550`、`…/biz/RemoteFileManager.java:20,33,46,50,54,58,62` | 全部海思/ SigmaStar CGI（见 CGI 全表） |
| `http://%s%s` | `com/gku/actioncam/amba/ui/playback/AmbaPlaybackActivity.java:275`、`…/amba/ui/playback/remote/video/AmbaRemoteVideoActivity.java:178`、`com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:115`、`com/gku/amba/AmbaCameraRecordFragment$AnonymousClass1.java:220`、`com/gku/hisi/Hisi_CameraRecordFragment$AnonymousClass1.java:189` | 文件下载直链 |
| `http://%s/%s` | `com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:87`、`com/gku/amba/AmbaCameraRecordFragment$AnonymousClass1.java:222`、`com/gku/hisi/Hisi_CameraFileActivity 系列同文件:191`、`com/gku/module_camera/hisi/HisiDownloader.java:200` | 海思「去扩展名 + `.THM`」缩略图/文件 |
| `http://%s/thumb%s` | `com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:83` | SigmaStar 缩略图 |
| `http://%s/` | `com/gku/actioncam/hisilicon/dv/biz/DV.java:556` | 根 |
| `http://192.168.0.1/` | `com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:61`、`com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:58` | **硬编码基址**（主文档 §11 已列） |
| `http://` | `com/gku/actioncam/sigmastar/HaisiCommandUtil.java:34`、`com/gku/actioncam/sigmastar/SSCommandUtil.java:34`、`com/gku/base/device/DeviceHttpUtils.java:12`、`com/gku/module_base_xtugo/HisiApiUtils.java:9` | 前缀常量 |
| `rtsp://%s:554/livestream/12` | `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:972` | Ambarella 预览取流 |
| `rtsp://` | `com/gku/actioncam/hisilicon/dv/biz/DV.java:320`、`com/gku/actioncam/sigmastar/HaisiCommandUtil.java:35`、`SSCommandUtil.java:35` | 前缀常量 |
| `http://%s:%d/%s` | `com/gku/videocache/HttpProxyCacheServer.java:140`、`com/gku/videocache/Pinger.java:97` | 本地代理回环 |
| `file:///storage/emulated/0/DCIM/ActionCam/download/{a_aba,b_longji,c_mabuer,d_dive}.mp4` | `com/gku/actioncam/hisilicon/dv/live/TelevisionActivity$ThumbClickListener.java:367` | 内置演示视频（4 条硬编码） |
| `file:///android_asset/` | `com/gku/base/webview/WebViewUtils.java:201` | 本地 H5 |
| `file:///system/media/audio/ui/{camera_click,VideoRecord,VideoRecordEnd}.ogg` | `com/gku/actioncam/amba/ui/preview/AmbaPreviewPresenter.java:371,375,379`、`com/gku/actioncam/hisilicon/dv/biz/Utility$AnonymousClass1.java:56` | 系统快门音 |
| `file://` | `com/gku/actioncam/sigmastar/videoedit/CutActivity.java:455`、`com/gku/dashcam/icatch/utils/imageloader/ImageLoaderUtil.java:58`、`com/icatchtek/reliant/customer/type/ICatchFileStreamParam.java:47` | 前缀 |
| `file:///storage/…` 之外的 `http://schemas.android.com/apk/res/android` | 见 §4.1 | 非网络 |

### 4.4 IP / 组播 / 回环（`_work/re/xtugo/signals-ips.tsv` 全 36 行归并）

| 字面量 | 出现处 | 判定 |
|---|---|---|
| `192.168.0.1` | `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:972`、`…/amba/ui/stream/TCPClient.java:63`、`com/gku/actioncam/hisilicon/dv/biz/DV.java:66`、`…/dv/ui/config/CameraParameters.java:37`、`…/dv/ui/config/CameraParmeras.java:37`、`…/dv/ui/data/connect/ConnectDevice.java:44`、`…/dv/ui/data/connect/DownLoadFileUtils.java:34`、`…/dv/ui/data/connect/FirmwareClientThread.java:64`、`com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:31`、`…/sigmastar/data/connect/FirmwareClientThread.java:64`、`…/sigmastar/data/connect/SSConnectDevice.java:57`、`com/gku/actioncam/sigmastar/SSConstant.java:13`、`…/sigmastar/newUi/deviceAdd/Activity/DeviceAddNewActivity.java:187`、`…/newUi/deviceAdd/Activity/UserGuideActivity.java:162`、`…/newUi/deviceAdd/Fragment/connect/DeviceAddConnectFragment.java:151`、`…/sigmastar/upgrade/firm/Presenter/UpgradePresenter.java:228`、`…/upgrade/firm/Ui/UpgradeVersionReadyActivity.java:71`、`com/gku/HomeActivity.java:562`、`com/gku/rxt/FwUpload2.java:18`、`com/hisi/hisiFW/FwUpload.java:16` | **A（本地）**：相机默认地址，6 个独立常量位（主文档 §11 已纠正） |
| `192.168.1.1` | `_work/xtu_src/sources/m/mifan/acase/icatch/IcatchCaseKt.java:9`（`API_HOST_ICATCH`） | **A（本地）**：iCatch 记录仪不同网段 |
| `234.168.168.168` | `_work/xtu_src/sources/com/icatchtek/control/core/CoreMulticast.java:15`（`MULTI_CAST_ADDR`）；组播名 `multicast.test`（`:21`）、`multicast.receive`（`com/icatchtek/control/core/feature/ICatchCameraAssistImpl$MulticastReceiver.java:320`） | **B（iCatch 设备发现）**：D 类组播，需 `CHANGE_WIFI_STATE` + 组播锁 |
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
| 固件目录基址 | `http://121.40.107.215:8041/firmware/` | `…/sigmastar/upgrade/app/UpgradeTaskManager.java:35`、`…/dv/updateapp/UpgradeManager.java:35` |
| 更新 XML | `http://www.gkuvision.com:8882/upload/update.xml` | `…/rxt/net/AppService.java:22` |
| STS 口 | `http://api.dashcamplayer.net/api/aliyun/uptoken` | `…/rxt/net/AppService.java:97` |
| OSS 三元组 | **无硬编码**：`data.getEndpoint()` / `getAccess_key()` / `getAccess_secret()` / `getSecurity_token()` 全部运行期下发 | `…/HomeActivity.java:859` |
| 高德 key | **不存在**（清单 meta-data 无 `com.amap.api.v2.apikey`，全树无 `setApiKey`） | `_work/re/xtugo/manifest.md:418-425` |
| 华为 appId | **不存在**（无 `com.huawei.hms.client.appid` meta-data） | 同上 |
| 渠道号 | `UMENG_CHANNEL` meta-data **不存在**，但代码要读它 → `NameNotFoundException` 路径 | `_work/xtu_src/sources/com/gku/crashhandle/CrashReportManager.java:32` |

### 4.6 判定汇总

| 档 | 条数 | 明细所在 |
|---|---|---|
| **A 运行时会访问（厂商后端/外链/本地）** | **26** | §4.1 的 24 条（去掉 `shhc-yh.com` 两条死常量）+ §4.4 的 `127.0.0.1`/`8.8.8.8`（`192.168.0.1` 等本地地址按族计 1） |
| **B 库会访问（条件触发）** | **9 族 / 约 34 个端点** | §4.2 高德(6 族)、Bugly(1)、OSS region(1)、字节 zeus/APMPlus(3 域)、HMS GRS(5 域)、MSA-OAID(1)、iCatch 组播(1) |
| **C 库里死字符串 / 本场景不触发** | **6** | AndroidVideoCache 文案、`schemas.android.com`、B 站图床、`location-inner.aliyuncs.com`、AMap 搜索/导航端点、APM Insight（`C` 判定见 §4.2） |
| **D 厂商死常量** | **3** | `api.shhc-yh.com/api/`、`api.shhc-yh.com/`、`172.18.1.19` |

→ **真正需要我们在网络侧对齐的只有 A 类**；A 类里跟相机协议无关的全是商店/客服链接。

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
| `com.gku.xtugo.MESSAGE_ACTION` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:18` | `MessageService.java:127`（5678 收到相机报文后）、`com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:314-316` | `com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java:631-634`、`…/filebrowser/Hi3518PriviewImageActivity.java:575-578`（SD 卡状态刷新） | 相机推送的状态原文 |
| `com.gku.xtugo.DV_ISALIVE_ACTION` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java:14` | `KeepAliveService.java:58,73` | `com/gku/actioncam/amba/base/IjkBaseActivity.java:47`、`…/dv/filebrowser/PreviewImageActivity.java:1006`、`…/Hi3518PriviewImageActivity.java:916`、`…/dv/imagelookover/SwitchImageActivity.java:475` | 心跳成功/失败 |

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
| `android.intent.action.MEDIA_SCANNER_SCAN_FILE` | `…/dv/devicemanage/DeviceManageActivity.java:326`、`…/dv/dlg/DlgForProcessActivity.java:521`、`…/dv/dlg/DlgForDeleteProcessActivity.java:842`、`…/dv/localimage/ImageEditLib/ImageEditClipActivity.java:109`、`…/dv/ui/data/connect/ConnectDevice.java:167`、`…/dv/ui/data/connect/DownLoadFileUtils.java:201,302`、`…/dv/ui/data/CopyFileUtils.java:254`、`…/sigmastar/data/connect/DownLoadFileUtils.java:161`、`…/sigmastar/data/connect/SSConnectDevice.java:178`、`…/sigmastar/newUi/album/Utils/FileNewUtils.java:85`、`…/sigmastar/util/FileUtils.java:67`、`…/sigmastar/videoedit/FilePathUtils.java:140`、`…/dashcam/icatch/utils/MediaRefresh.java:183`、`com/gku/dashcam/icatch/data/IcatchConnectDevice.java:146` | **15 处**。Android 10+ 该广播已无效（须用 MediaStore API），是**必须注意的历史包袱**：官方 App 的媒体入库在某些机型上其实靠不住 |
| `android.intent.action.MEDIA_SCANNER_SCAN_DIR` | `…/dashcam/icatch/utils/MediaRefresh.java:22` | 同上（iCatch 线） |
| `android.intent.action.SEND` / `SEND_MULTIPLE` / `SENDTO` | `com/gku/base/utils/ShareUtils.java:17,45,49`、`…/dv/biz/HiShareFile.java:15,36`、`…/dv/localimage/AlbumPreviewActivity.java:192`、`…/newUi/album/Ui/Activity/ActivityNewPreview.java:327`、`…/newUi/album/Ui/Fragment/CommonFragment.java:291,308`、`…/newUi/userCenter/ui/activity/QuestionDescription.java:170`、`…/sigmastar/videoedit/VideoShareActivity.java:87` | 分享出站到微信/QQ（`queries{com.tencent.mm,com.tencent.qq}`） |
| `android.intent.action.VIEW` | `…/dv/filebrowser/PreviewImageActivity.java:1188`、`…/Hi3518PriviewImageActivity.java:1098`、`…/dv/live/TelevisionActivity$ThumbClickListener.java:368`、`…/dv/setting/AboutClientActivity.java:172`、`…/dv/updateapp/UpgradeManager.java:924`、`…/sigmastar/upgrade/app/UpgradeTaskManager.java:924`、`…/upgrade/app/UpgradeViewManager.java:639`、`…/newUi/userCenter/ui/fragment/UserCenter.java:168`、`…/loginmodule/ui/fragment/UserCenterNewFragment.java:261`、`com/gku/base/utils/FileIntentUtils.java:15`、`com/gku/base/utils/MarketUtils.java:38`、`com/gku/base/webview/WebViewUtils.java:61`、`com/gku/rxt/net/CheckAppVersionUtils.java:327` | 13 处外跳（浏览器/应用市场/拨号盘/安装） |
| `android.intent.action.INSTALL_PACKAGE` | `…/sigmastar/upgrade/app/UpgradeViewManager.java:634` | App 自升级安装（配合 §6 的 FileProvider URI） |
| `android.intent.action.MAIN`（手工构造，非 launcher） | `…/newUi/userCenter/ui/fragment/UserCenter.java:339`、`com/gku/loginmodule/utils/OtherUtils.java:37` | 用 `getLaunchIntentForPackage` 拉起别的 App |
| `android.settings.action.MANAGE_WRITE_SETTINGS` | `…/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:1216`、`…/HisiActionCameraPreviewActivity.java:1227`、`com/gku/base/permission/PermissionActivity.java:61` | 跳「修改系统设置」授权页（对应 `WRITE_SETTINGS`） |
| `android.settings.REQUEST_MANAGE_MEDIA` | `com/gku/HomeActivity.java:1049`、`…/dv/ui/WelcomeActivity.java:195`、`…/dv/ui/weight/MyBottomSheetDialog.java:312`、`com/gku/loginmodule/utils/PermissionUtils.java:118` | 跳「允许管理所有文件」（对应 §1.1 #6 的半死判定） |
| `miui.intent.action.APP_PERM_EDITOR` + `setClassName("com.android.settings","com.miui.securitycenter.permission.AppPermissionsEditor")` | `com/gku/actioncam/sigmastar/bluetooth/utils/IntentUtils.java:26,27` | MIUI 判定/跳权限页；用 `queryIntentActivities` 探测（`:33`） |
| `android.intent.action.{SCREEN_ON,SCREEN_OFF,USER_PRESENT}` | `com/gku/dashcam/icatch/listener/ScreenListener.java:40,42,44,77,78,79` | iCatch 线的息屏监听 |
| `android.net.wifi.STATE_CHANGE` / `android.net.wifi.supplicant.STATE_CHANGE` / `android.net.conn.CONNECTIVITY_CHANGE` | 22 处：`…/dv/ui/BaseActivity.java:33`、`…/dv/devicemanage/DeviceManageActivity.java:353,354,469,483,518`、`…/dv/filebrowser/{PreviewImageActivity.java:1005,Hi3518PriviewImageActivity.java:915}`、`…/dv/imagelookover/SwitchImageActivity.java:474`、`…/dv/live/TelevisionActivity.java:239,384`、`…/dv/wifi/WifiDeviceActivity.java:49,129`、`…/dv/wifi/WifiDisconnectReceiver.java:83`、`…/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:177`、`…/amba/base/IjkBaseActivity.java:46`、`…/amba/ui/preview/AmbaPreviewActivity.java:1230`、`com/gku/dashcam/icatch/utils/WifiAPUtil.java:18,56` | **断连检测主力**。这是我们要复刻的核心信号（谁掉了 AP 就判定断开） |
| `com.android.music.musicservicecommand` | `com/gku/actioncam/sigmastar/widget/SSVideoView.java:583`、`com/gku/actioncam/widget/VideoView.java:588` | 耳机线控/第三方音乐广播的**接收**（锁屏播放控制），系统广播 |
| `EVENT_TIME_LAPSE_STOP`、`CAMERA_CONNECT_CHANGE` | `_work/xtu_src/sources/m/mifan/acase/icatch/IcatchCase.java:586`、`m/mifan/acase/icatch/PropertyIdKt.java:7` | iCatch PTP 内部事件名，**不是 Android intent**（`signals-actions.tsv` 的误分桶） |
| `CALLBACK_CHOOSE_CLICK` | `com/gku/amba/AmbaCameraFileActivity.java:35`、`…/amba/AmbaCameraPicFragment.java:317`、`…/amba/AmbaCameraRecordFragment.java:340`、`com/gku/hisi/Hisi_CameraFileActivity.java:22`、`…/hisi/Hisi_CameraPicFragment.java:286`、`…/hisi/Hisi_CameraRecordFragment.java:298` | `setResult` 用的 **extras key**，非 action |
| `multicast.test` / `multicast.receive` | `com/icatchtek/control/core/CoreMulticast.java:21`、`com/icatchtek/control/core/feature/ICatchCameraAssistImpl$MulticastReceiver.java:320` | iCatch 组播内的标签串（配合 `234.168.168.168`，§4.4） |

#### (e) 一条**指向不存在 App** 的外跳（重要）

`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/live/TelevisionActivity$ThumbClickListener.java:369`：

```java
intent.setClassName("com.gku.actioncam.hisilicon.android.videoplayer",
                   "com.gku.actioncam.hisilicon.android.videoplayer.activity.VideoActivity");
```

该包**既不在本 APK 的 219 个组件里，也不在 `queries`（只有 `com.tencent.mm`、`com.tencent.qq`、`com.gku.xtugo`、`com.gku.yutupro`）里** → 在 Android 11+ 必然解析失败。属海思 DV 老播放器残留，**我们不要照抄**。

### 5.4 外部可触发面矩阵

| 入口 | exported | 权限 | 无权限就能触发？ | 影响 |
|---|---|---|---|---|
| `com.gku.actioncam.hisilicon.dv.ui.WelcomeActivity` | true | 无 | ✅ 是 | 只能把 App 拉到前台，无参数注入点 |
| `com.gku.gkucamplayer.GKUCamPlayer` | **true** | **无** | ✅ 是（显式组件名） | **唯一可被任意 App 拉起的厂商 Activity**；`screenOrientation=fullSensor`、无 filter。它内部会去连相机流 → 可被用来做「拒绝服务/界面劫持」，但**不能注入 IP/URL 参数**（无 `getIntent()` 关键参数解析） |
| `androidx.profileinstaller.ProfileInstallReceiver` | true | `android.permission.DUMP` | ❌ 否 | 系统/adb 专用 |
| `com.gku.base.BaseFileProvider`（`com.gku.xtugo.FileProvider`） | false + `grantUriPermissions=true` | — | ❌ 否（需本 App 主动授权） | 见 §6.2 的宽路径风险 |
| 13 个 zeus/`servermanager` provider | false | — | ❌ 否 | 同 App 跨进程 |
| 其余 200+ 组件 | false / 未写(=false) | 无 | ❌ 否 | — |
| `com.gku.xtugo.MESSAGE_ACTION` / `DV_ISALIVE_ACTION` 广播 | — | 无 | ⚠️ **可被任意 App 监听**（`sendBroadcast` 不带 receiverPermission）；Android ≤32 也可被**伪造注入**（接收侧老 API 注册） | 泄露内容：相机推送的状态字符串（含录制计时/SD 卡状态） |

**一句话结论**：`GKUCamPlayer` 是唯一真正的外部暴露面，其余都靠「无 intent-filter + 未写 exported」默认关闭；**内部广播是唯一的运行期信息泄露渠道**。

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
- 相册分享：`com/gku/actioncam/sigmastar/newUi/album/Ui/Activity/ActivityNewPreview.java:327`、`…/CommonFragment.java:291,308`、`…/dv/localimage/AlbumPreviewActivity.java:192`

### 6.3 库侧的 file_paths（对比）

`_work/xtu_res/resources/res/xml/ps_file_paths.xml`（LuckPicture，meta-data `android.support.FILE_PROVIDER_PATHS=@xml/ps_file_paths`）：`<external-path name="camera_photos" path=""/>` + `<root-path name="camera_photos" path=""/>` —— **`root-path` 即整个文件系统根**（`/`），比厂商自己的 `paths_base` 更宽。
另存在 `_work/xtu_res/resources/res/xml/file_paths.xml`，但清单里**没有任何 provider 引用它**（Glide/旧库遗留）。

### 6.4 共享出来的具体路径

由 `Common.java:170-176`（品牌段来自 `BuildConfig.APPLICATION_ID.split("\\.")[2]` = `xtugo`）与 §9.3 的缓存目录：

| 路径 | 内容 |
|---|---|
| `/DCIM/xtugo/photo/ActionCam/`、`/DCIM/xtugo/video/ActionCam/`、`/DCIM/xtugo/video/ActionCam/sd/` | 相机下载的照片/视频/缩码流 |
| `/DCIM/xtugo/{photo,video}/DashCam/` | iCatch 记录仪下载 |
| `/storage/emulated/0/DCIM/ActionCam/`（`SSConstant.LOCAL_DOWNLOAD_DIR`，`com/gku/actioncam/sigmastar/SSConstant.java:11`） | 老 SigmaStar 下载根 |
| `/storage/emulated/0/Android/data/com.gku.xtugo/cache/`（`SSConstant.LOCAL_THUMB_CACHE_DIR`，`SSConstant.java:10`） | 缩略图缓存 |
| `/storage/emulated/0/DCIM/ActionCam/download/{a_aba,b_longji,c_mabuer,d_dive}.mp4` | 直播预览用的**内置演示视频**（硬编码 `file://`，`com/gku/actioncam/hisilicon/dv/live/TelevisionActivity$ThumbClickListener.java:367`） |
| `/mnt/sdcard/xtu_exception.txt`、`/mnt/sdcard/JKHardVersion/` | 崩溃/固件残留（`_work/re/xtugo/signals-fsPaths.tsv`） |

---

## 7. native 与 assets 里的域名与证书

（待补全。）

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

### C-06 主文档 §1.2 / §1.4：导出的厂商组件口径

> 原文（§1.4 末注）：「`GKUCamPlayer` … 这是全 App 除启动器外唯一被导出的厂商组件」

核实：正确。补充可量化结论：`_work/re/xtugo/components.tsv` 全 219 行里 `exported=true` 只有 3 个（`WelcomeActivity`、`GKUCamPlayer`、`androidx.profileinstaller.ProfileInstallReceiver`），且 **`GKUCamPlayer` 没有任何 intent-filter** → 只能被**显式组件名**拉起；全 App 也**只有 3 个组件带 intent-filter**（`WelcomeActivity` LAUNCHER、`com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService`、`ProfileInstallReceiver`）→ **不存在任何 DeepLink/scheme**（§5）。

### C-07 主文档 §8 高德行：「清单没给 key」

核实：`_work/re/xtugo/manifest.md:418-425` 的 meta-data 表**只有 7 行、全是库的**（CameraX / 两个 FileProvider 路径 / 4 个 androidx-startup + logx），**无 `com.amap.api.v2.apikey`**，也无 `UMENG_CHANNEL`。
补强：高德 native SDK 在包里留下了完整端点集（§4.2），其中鉴权端点 `https://restsdk.amap.com/v3/iasdkauth`、`https://adiu.amap.com/ws/device/adius` 的存在，正好解释「无 key → 鉴权失败」的路径。§8 的「半死」判定成立，可加这些端点作证据。

---

## 9. 本附录未确认的点

| # | 未确认 | 缺什么 |
|---|---|---|
| U1 | 10 个幽灵是 R8 删的还是源码里就注释掉了 | 需要 `classes*.dex` 的原始 `dexdump` 比对（本附录用 `classes-all.tsv` 已足以判定「不在 dex」） |
| U2 | `com.my.AppSettingActivity` 究竟属于哪个 SDK | 该类无 meta-data、无 filter，包名独立；需继续读 `com/my/**` 源码链 |
