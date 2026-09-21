# 附录 C · idGoLive 原生层：63 个 .so、JNI 全表、PTP-IP 线上格式

> 返回 [主档案](03-idGoLive-档案.md)。
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
