# 附录 A · idGoLive PTP 设备属性表全量

> 返回 [主档案](03-idGoLive-档案.md)
> 证据根目录：`_work/idgo_live_src/sources/`（jadx 反编译），行号即该目录内文件行号。
> native 符号证据：`_work/re/idgolive/natives-symbols.tsv`、`_work/re/idgolive/natives-strings.tsv`。

---

## 0. 这张表是怎么来的（三层结构）

| 层 | 位置 | 作用 |
|---|---|---|
| 常量层（Java） | `com/icatch/golive/data/PropertyId/PropertyId.java:4-55`（51 个 `static final int`）+ `com/icatchtek/control/customer/type/ICatchCamProperty.java:5-23`（19 个能力常量） | App 层与 SDK 层各存一份 ID，值完全重叠 |
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
