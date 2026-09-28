# SJCAM（山狗）SJCAM Zone 6.7.3.15 官方 App 档案

> **doc-id** `evidence/sjcam` · **层** 证据 · **状态** 权威：与结论层冲突时以本档案为准并回写 · **建档** 2026-09-28 · **修订** 2026-09-28
> 文档系统 [`docs/README.md`](../README.md) · 语料：`_work/sjcam_src/sources/`（jadx 1.5.6，16,811 个 `.java`）

> 包名 `org.jght.sjcam.zone`，版本 6.7.3.15（versionCode 10061），APKPure XAPK 分发。
> **语料是部分 APK**：5 个 `classes*.dex`（含全部 `org/jght/sjcam/zone/**` 业务代码）、`resources.arsc`、`res/**`、`assets/**` 完整且逐条 CRC32 校验通过；缺失的是 `lib/**` 原生库（`libVECoreFFmpeg.so` 等媒体编解码器，协议无关）。取证方法与部分包的边界见 §1。
> 官方 App 名称即中文品牌名「山狗运动相机」（Google Play 曾用名），本文一律写 SJCAM。

SJCAM 是**多 SoC 品牌**：一个 App 里并排实现了 5 套互不相同的相机通道（Ambarella / Novatek / 海思 hisnet / 全志 / iCatch PTP），按**网关 IP + 相机自报型号串**分派。本文回答四件事：**有哪些机型 / 怎么识别 / 怎么连 / 怎么通讯**，末尾给出我们侧的纳入与舍弃。长表在下面各小节，机型词表在 §2.1。

---

## 1. 取证对象与方法（本层入口的补充）

| 项 | 值 |
|---|---|
| 包名 / 版本 | `org.jght.sjcam.zone` / 6.7.3.15 (10061) |
| 分发 | APKPure XAPK（`SJCAM+Zone_6.7.3.15_APKPure.xapk`，整包 208,721,066 B） |
| 我们持有的部分 | 95,189,680 B 下载流 + 抢救出的条目 → 重建出 `_work/sjcam_partial.apk`（131,769,334 B，sha256 前 32 位 `0e119026d057e0d01b7a6f3b264a826e`） |
| 反编译 | `java -cp _work/jadx/lib/jadx-1.5.6-all.jar jadx.cli.JadxCLI -j 6 --no-res --show-bad-code -d _work/sjcam_src _work/sjcam_partial.apk`（16,811 个 `.java`，126 个类反编译失败，属 jadx 常规噪声） |
| 资源值 | `aapt2 dump resources _work/sjcam_partial.apk`（`E:/Android/Sdk/build-tools/36.0.0/aapt2.exe`） |
| 清单 | `AndroidManifest.xml`（二进制 XML，字符串池无混淆） |

**两条取证方法上的坑，写在这里省下一次重蹈：**

1. **`java -jar jadx-1.5.6-all.jar` 会进 GUI 入口**（`META-INF/MANIFEST.MF` 的 `Main-Class` 是 `jadx.gui.JadxGUI`），GUI 路径会实例化 `jadx.gui.cache.code.disk.DiskCodeCache` 并在 `Resetting disk code cache` 处停死（本机实测：本仓库自己的 debug APK 也在同一位置停死 200s+）。官方启动脚本 `_work/jadx/bin/jadx.bat` 用的是 `-cp <jar> jadx.cli.JadxCLI`，**必须照抄这一条**；切换后同一份输入在数分钟内产出全部源码。
2. **APKPure 的 XAPK 对本 App 就是一个 APK 外壳**：外层 zip 的第一个条目是零字节的 `org.jght.sjcam.zone.apk` 目录项，其后直接是 APK 的条目流。因此**断点续传拿到前 ~80 MB 就等于拿到了全部 dex 与资源**（`classes.dex`…`classes5.dex`、`resources.arsc`、`res/`、`assets/` 都排在 `lib/` 之前）；截断点落在 `lib/arm64-v8a/libVECoreFFmpeg.so` 之中。按 `PK\x03\x04` 顺序解析 local header、逐条 CRC32 校验后重建 zip，即得可反编译的 `_work/sjcam_partial.apk`。

## 2. 机型与家族

### 2.1 型号词表（相机自报的 `model` 串，三个词表并存）

**该品牌没有统一的「型号 → 协议」注册表**——分派键是「网关 IP」（§3.2）加相机自报的 model 串，而三套词表的写法互不相同（Ambarella 系 `SJCAM*`、Novatek 系 `<芯片号>-<型号>`、hisnet/全志是两个裸串）。

**(a) Ambarella 系（`SJCAM*`）**（`camera/AmbaCamera.java:63-68`、`model/CameraModelList.java:20,35-46`）：

`SJCAMSJ8PRO` · `SJCAMSJ8ProDualSCR` · `SJCAMSJ9PRO`（SJ9 Strike）· `SJCAMSJ10PRO` · `SJCAMSJ10ProDualSCR` · `SJCAMSJ8KPRO` · `SJCAMSJ7STAR`（含 `SJCAMSJ7Korean/Poland/Spain/Turkey` 四个地区串）

**(b) Novatek 系（`<芯片号>-<型号>`）**（`camera/LYCamera.java:58-95`、`model/CameraModelList.java:9-44`）：

| 芯片前缀 | 型号串 |
|---|---|
| `655-` | `655-SJ4000WIFI`(+`_SQ`) · `655-SJ5000WIFI` · `655-M10WIFI` · `655-SJ4KPRO_565` |
| `658-` | `658-SJ8AIR` · `658-M20Air` · `658-SJA40` · `658-A10` |
| `660-` | `660-SJ6_A/B/C/_SHX` · `660-SJ6_206V01/V02_IPS` · `660-SJ6_60M_IPS/_60M_206V01_IPS` · `660-SJ10` · `660-SJ10X`(+`_335_V01`) · `660-SJ4000X` · `660-SJ4000+` · `660-SJ5000X` · `660-SJ360` · `660-C200` · `660-P500-NOVATEK` · `660-SJA20` · `660-M10+` · `660-M20` |
| `670-` | `670-A50` / `670-A50_NOGPS` |
| `672-` | `672-C100` / `672-C100_4653` |
| `675-` | `675-C100+`(+`_4653`) · `675-C110` · `675-SJ10_DualScreen` · `675-SJ8_DualScreen` |
| `580-` | `580-C110+`(+`_AIC`) · `580-C200Pro` · `580-C300` · `580-SJ20_580` · `580-SJ10_580`（SJ11） · `580-SJ6Pro_580` · `580-SJ6Ultra` |
| `683-` | `683-SJ8+`（SJ8 Plus） · `683-SJ9`（SJ9 Max） |
| `568-` | `568-C400` |

⚠️ 两个易错点：**同名的两代机在同一品牌内分属不同家族**——SJ9 有 `683-SJ9`（Novatek）与 `SJCAMSJ9PRO`（Ambarella）两个串，SJ8 Pro 与 SJ8 Plus 也分属 Amba 与 LY；**`a10` 是小写裸串**（`camera/LYCamera.java:74`）。

**(c) hisnet / 全志 / iCatch（裸串）**：

| 家族 | 型号串 | 证据 |
|---|---|---|
| 海思 hisnet | `Hi3559V200-DV-IMX458`（常量名 `HisCamera.SJ10_MAX`，即 SJ10 MAX） | `camera/hicam/HisCamera.java:55` |
| 全志 | `V536-CDR`（常量名 `AllWinnerCameraHttp.SJ10_A`） | `camera/allwinner/AllWinnerCameraHttp.java:61` |
| iCatch | `"ICatch"`（字符串常量，无型号细分） | `ui/fragment/home/ConnectCameraFragment.java:1096-1100` |

### 2.2 官方型号选择表（App 自报支持面）

`ui/activity/NewCameraListActivity.java:88` 的 26 项帮助列表即官方支持的机型：C400、SJ20 Dual Lens、C110/C110+、C300、C200 PRO、C200、C100/C100+、SJ11 ACTIVE、SJ10 PRO DUAL SCREEN、SJ10 PRO、SJ8 Dual Screen、SJ10X、SJ8 PRO、SJ8 PLUS、SJ8 AIR、SJ6 PRO、SJ6 Legend、SJ4000 AIR、SJ4000 DUAL SCREEN、SJ4000 WiFi、SJ4K、SJ5000X ELITE、A10、A20、A30、A50。
另有连机引导视频表给出的 22 个名字（`constant/CameraConnectConstants.java:30`）：`C100 C110 C200 C200Pro C300 SJ20 SJ4K SJ4000 SJ4000WIFI SJ4000Air SJ11 SJ8ProDual A10 A20 A30 A50 C400 C400Pocket SJ6 SJ8Pro SJ10ProDualSCR SJ10Pro`。

## 3. 识别与连接

### 3.1 SSID

官方只有一处 SSID 判定（`view/WifiBottomPopup.java:252-254`，方法名 `isSjWifi`）：

```
uppercase(ssid).startsWith("SJ") || startsWith("C100") || startsWith("C200") || startsWith("A10")
  || startsWith("A20") || startsWith("A30") || startsWith("M20")
```

即 **`SJ*`（覆盖全部 SJ 系）、`C100*`、`C200*`、`A10*`、`A20*`、`A30*`、`M20*`**。注意 C110/C300/C400 不在这条表里，它们靠网关 IP 识别（§3.2）；`SJ` 前缀会与「SJCAM Zone 自己的热点」等无关网络重叠，官方也只在相机连接向导里用它做提示。

### 3.2 网关 IP 分派（连接前唯一可靠的路由键）

`factory/JFCamera.java:205-224`（`isConnection()`）与 `utils/NetUtils.java:209-215`（`isCameraConnection()`）逐字：

| 网关 | 分派 | `JFCamera.Type` |
|---|---|---|
| `192.168.42.1` | Ambarella | `AMB = 1` |
| `192.168.1.254` | Novatek（Ly） | `LY = 2` |
| `192.168.100.1` | 全志（老） | `ALLWINNER = 4` |
| 其它 | 非相机 | `NOT = 3` |

`factory/JFCamera.java:199-203` 另有 SJ6/C200 的特例：网关 `192.168.1.1` 或 `192.168.101.1` **且** SSID 含 `SJ6`/`C200` 时也按 Ly 处理（这两代机的 AP 网关不在 `.254`）。
`camera/SCamera.java:20-39` 是第二套编号（`1=LY, 2=Amba, 5=AllWinnerHttp, 11=M20CD`），与 `JFCamera.Type` **数值不同名同义**，读代码时别混。

### 3.3 官方连接机制

`ConnectCameraFragment`：Wi-Fi 直连（`WifiHelper`）→ 连上后按网关 IP 与 `cameraInfoModel.getCameraModel()` 进不同的控制页（`:1096-1113`）：`"ICatch"` → iCatch PTP 页；`Hi3559V200-DV-IMX458` → hisnet 页；`V536-CDR` → 全志页；其余按 model 串与固件版本进 LY / SJ8 Pro / 通用页。全志家族的出厂密码是 `12345`（`camera/allwinner/AllwinnerCamera.java:52`），其余家族未在本 APK 里发现写死的热点口令。

## 4. 四套传输的协议面

### 4.1 Ly / Novatek —— `?custom=1&cmd=NNNN` HTTP + TCP 3333 事件

- **控制基址** `http://192.168.1.254/?custom=1`，命令按 `&cmd=<id>[&par=<v>][&str=<v>]` 追加（`camera/LYCamera.java:73,481-483`；`Command` 用 `TreeMap` 保序，故线上顺序恒为 `cmd`→`par`→`str`，`:1850-1887`）。
- **命令字全表**（`camera/LYCamera.java:140-164`）：
  `CAPTURE=1001` · `FREE_PICTURE=1003` · `RECORD=2001` · `FREE_RECORD_TIME=2009` · `LIVE_VIEW=2015` · `RECORD_TIME=2016` · `MODE_CHANGE=3001` · `SET_DATA=3005` · `SET_DATA_TIME=3006` · `SHUTDOWN=3007` · `GET_TV_MODE=3009` · `FORMATSDCARD=3010` · `GET_VERSION=3012` · `GET_ALLSETTING_VALUE=3014` · `GET_CAMERA_MEDIA_FILES=3015` · `GET_MODEL=3016` · `GET_DISK_SPACE=3017` · `GET_BATTERY=3019` · `DELETE_FILE=4003` · `ZOOM_IN_OUT=9030` · `CHANGE_CAMERA=9041` · `GET_GPS=9041` · `CREATE_OTA=9080`；复位用裸串 `"3011"&par=1`（`:1163`）。
- **响应**：`<Function><Cmd>…</Cmd><Status>…</Status><Value>…</Value><Total>…</Total><Free>…</Free><String>…</String>…</Function>` 的伪 XML，用「找标签」取值（`LyDataPack`，`:1888-1988`）；`cmd=3014` 的响应是**一串 `<Cmd>`/`<Status>` 对**，等价于「当前设置项 → 当前值」字典（`parseParamsValue`，`:1814-1840`）。**写设置就是再发一次同 id**：`cmd=<设置项id>&par=<新值>`。
- **关键操作**：拍照 `cmd=1001`；录像 `cmd=2001&par=1|0`（`take()`，`:1011-1026`）；电池 `3019`→`<Value>` 百分比（`:221-250`）；存储卡 `3017`→`Status/Total/Free`（`:1200-1214`）；当前模式 `3016`→`<Status>` 数码（0/4/6 拍照族、1/3/8/9/10/11 录像族，`:615,868`）；对时 `3005&str=yyyy-MM-dd` + `3006&str=HH:mm:ss`（`:1477-1483`）；格式化 `3010&par=1`（`:1187`）；关机 `3007&par=4|6`（C400/SJ6Ultra 用 6，`:884`）。
- **文件浏览是抓 HTML 目录页**，不是命令：`http://192.168.1.254/DCIM/<MOVIE|PHOTO|EVENT>/`（M20Air 用 `/M20/<类型>/`，`660-P500-NOVATEK` 用 `/DCIM/NORMAL/<类型>/`；音频目录名是先抓 `/DCIM/` 找含 `VOICE` 的目录名再列，`camera/LYCameraFileList.java:46-84`）。列表行由 Jsoup 解析 `tr/td`，取 `a[href]`、名字、大小、时间；下载 URL = `http://192.168.1.254` + href（`:30,86-136`）。**跳过 `.wav` 与 `raw` 文件**。
- **实时画面**：录像族 `rtsp://192.168.1.254:554/xxx.mp4`，拍照族 `http://192.168.1.254:8192`（MJPEG/HTTP 流），按型号与模式切换（`URL_VIDEO`/`URL_PHOTO`，`camera/LYCamera.java:97-98,615,810,868`；20 余个型号的实测归属表在 `getVideoPlayUrl()`，`:1280-1300`）。
- **事件通道**：TCP `192.168.1.254:3333`（超时 20 s，`camera/LYCamera.java:485-486`）；`<Cmd>3020`/`<Cmd>2020` 开头的推送按 `</Function>` 聚包后整包回调，其它消息按读取块原样转发（`protocol/camera/SocketHelper.java:272-303`）。协议内容（电量/录像时长/事件）在 `LYCamera` 的 `onReadData` 分支里。

### 4.2 hisnet（SJ10 MAX）—— `/cgi-bin/hisnet/*.cgi` + 相机回连 TCP 9000

- **基址** `http://192.168.0.1/cgi-bin/hisnet/`（`camera/hicam/HisCamera.java:90-133`）。
- **端点全表**：`getdeviceattr.cgi`（身份：`var model`/`var softversion`）· `getworkmode.cgi` · `setworkmode.cgi?&-workmode=%s` · `getworkstate.cgi` · `getbatterystate.cgi`（`var capacity`/`var charge`）· `getsdstatus.cgi` · `getfilecount.cgi` · `getfilelist.cgi?&-start=%s&-end=%s`（重复 `var path`/`var size`/`var create` 三组平行数组）· `getfileinfo.cgi?&-name=%s` · `deletefile.cgi?&-name=%s` · `deleteallfiles.cgi` · `sdcommand.cgi?&-format` · `getsetting.cgi`（设备设置，`var item`/`var value`）· `setsetting.cgi?&-option=%s&-values=%s` · `getmedia.cgi`/`setmedia.cgi?&-option=&-values=`（拍摄设置）· `getresource.cgi`/`setresource.cgi?&-resource=`（分辨率）· `getitem.cgi?&-type=&-item=`（某设置的可选项）· `getallmode.cgi?&-type=%s` · `getlang.cgi`/`setlang.cgi&-lang=%s` · `getsystime.cgi`/`setsystime.cgi?[&-time=%s][&-timeformat=0][&-timezone=0]` · `client.cgi?&-operation=register|unregister&-ip=%s` · `sendclickkey.cgi?&-type=%s`（快门/按键，App 只发 `KEY_MENU`）· `reset.cgi` · `poweroff.cgi`。
- **响应**是 `var key = "value";` 文本（`HisDataPack` 按 `var ` 前缀解析；与海思 hi3510 同风格，但路径与命令集不同族，见 §5）。
- **工作模式名**（`setworkmode.cgi&-workmode=` 的取值，`camera/hicam/HisCamera.java:136-147`）：`Normal` `Photo` `Burst` `Lapse` `RecLpse` `Slow` `Car Looping` `RecSnap` `Filelist`。
- **事件通道**：**相机回连手机的 TCP 9000**（App 起 `ServerSocket(9000)`），且要先 `client.cgi?&-operation=register&-ip=<手机IP>` 把自己的地址告诉相机；消息是 JSON（Gson），经 `HisCamera.Message` 的 `eventid` 分派（`START/STOP/SETTING/SWITCH_WORKMODE`），并把本地广播给 UI（`camera/hicam/MessageService.java:31`、`camera/hicam/HisCamera.java:245-345,1182-1204`）。
- **实时画面** `rtsp://192.168.0.1:554/livestream/12`。

### 4.3 Ambarella —— JSON-over-TCP `7878`

- **通道**：`SocketHelper.init("192.168.42.1", 7878, 5000)`，请求是**裸 JSON 文本**（无长度前缀、无分隔符），响应按「累积到能解析」分帧（`protocol/camera/AmbProtocol.java:292-296,340-343`、`SocketHelper` 原样转发分支）。
- **会话**：先 `{"msg_id":257,"token":0}`（`startSession`），相机回带 `token`，之后每条命令都带该 token；会话未建时命令入队（`:317-343`）。
- **msg_id 表**（`protocol/camera/AmbProtocol.java:87-143`）：`1 GET_SETTING` · `2 SET` · `3 GET_ALL_CURRENT_SETTINGS` · `4 FORMAT` · `9 GET_CURRENT_SETTINGS`（带 `Options` 数组） · `7 NOTIFICATION` · `11 GET_DEVICEINFO` · `12 SHUTDOWN`(`param="cam_off"`) · `13 GET_BATTERY` · `257/258 START/STOP_SESSION` · `259/260 START/STOP_RTSP`(`param="none_force"`) · `513/514 START/STOP_RECORD` · `515 GET_RECORD_TIME` · `769 TAKE_PHOTO` · `1281 DELETE_FILE` · `1286 UPLOAD_FW` · `2049 MEDIA_FILE`；另有 `rval` 错误码表（`-1…-26`，`:96-112`）。
- **模式串**（设备回报的 `mode` 值，`camera/AmbaCamera.java:299-347`）：`normal_capture` `burst_capture` `video_capture` `timelapse_photo` `car_mode` `live` `normal_record` `timelapse_video` `slow_video`；事件名同表（`start_normal_record`/`stop_normal_record` 等，`:43-58`）。
- **媒体面**：`http://192.168.42.1/SD/DCIM/100MEDIA/`（静态文件）与 `rtsp://192.168.42.1/live`（`camera/AmbaCamera.java:40-41,62`）；删除路径根 `/tmp/fuse_d`（`:42`）。

### 4.4 全志（SJ10_A / `V536-CDR`）—— `:8082` JSON API

- **基址**：读 `http://192.168.10.1:8082/api/getdeviceinfo/?custom=1&cmd=<id>`、写 `…/api/setdeviceinfo/?custom=1&cmd=<id>`（`camera/allwinner/AllWinnerCameraHttp.java:56-58`），响应为 JSON（`workmode`、`RecodStatus`〔原文如此，拼写缺一个 `r`〕、`Value`、`Menu` 数组）。
- **命令表**（`:73-79`）：`RECORD=1100` · `CAPTURE=1101` · `MODE_CHANGE=1110` · `GET_VERSION=2001` · `RECORD_STATE=2005` · `GET_MODEL=3030` · `GET_MODEL_LIST=3031`。
- **实时画面** `rtsp://192.168.10.1:8554/ch01`；出厂密码 `12345`（`camera/allwinner/AllwinnerCamera.java:52`）；老一代网关 `192.168.100.1` 另有缩略图路径 `/mnt/extsd/video/.thumb/%s.bmp`。

### 4.5 iCatch PTP（`"ICatch"`）

型号串命中 `"ICatch"` 时进 `ICatchControlActivity`，那条栈是 PTP/IP（与 `docs/evidence/idgolive` 记录的同源 SDK），本档案不再展开——它在本 APK 里同样只有 JNI 壳，静态拿不到连线参数。

## 5. 我们侧的纳入与舍弃（2026-09-28 决策）

**纳入**（`composeApp/.../brand/sjcam`，一个插件四个 profile，按探针命中的家族分派）：

| profile | 家族 | 探针依据 | 覆盖机型 |
|---|---|---|---|
| `ly` | Novatek | `?custom=1&cmd=3012` 答出 SJCAM 型号串 | §2.1(b) 全部 |
| `hisnet` | 海思 | `getdeviceattr.cgi` 答出 `Hi3559V200-DV-IMX458` | SJ10 MAX |
| `allwinner` | 全志 | `:8082/api/getdeviceinfo` 答出 `V536-CDR` | SJ10_A |
| `amba` | Ambarella | TCP 7878 `257` 会话成功且 `11` 回报 `SJCAM*` | §2.1(a) 全部 |

**舍弃/降级**（与既有先例一致，都在这里立此存照）：

- **iCatch PTP 通道不做**：与 idGoLive 的取舍同因（协议栈在 native，静态不可连线，需真机）。
- **三条推送通道只用轮询替代**：Ly 的 TCP 3333、hisnet 的回连 9000、Amba 的 `7 NOTIFICATION`。前者需要长连接与自建监听，对「状态页 + 控制」这类交互没有信息增量；官方 App 也是轮询与推送混用（Ly 电量就是 1 s 轮询，`camera/LYCamera.java:79`）。**副作用**：录像状态要谨慎——Ly/hisnet/全志 的读回都能给出录制状态（Ly 用 `2016` 的 `<Value>`，hisnet 用 `getworkstate.cgi`，全志用 `2005 RecodStatus`），所以这三个 profile 声明 `reportsRecordingState = true`；Amba 的 `515 GET_RECORD_TIME` 只在录制中才有意义，取不到时按「无意见」处理（`reportsRecordingState = false`）。
- **M20CD 的 `Util.movie_url/photo_url`**（由 socket 事件下发的流地址）不实现，M20 系机型回落到 LY 的固定流地址；这些机型本身也在 §2.1(b) 词表内。

## 6. 未解与需真机项

1. **无真机**：本档案全部来自静态反编译；所有「线上行为」结论（状态码语义、字段单位）都标注了出处但没有真机复核。我们侧验证走 `simulator/` 自建假相机（`docs/evidence/method` 的方法边界）——四条通道的端到端流程在 `SjcamFlowTest`（`desktopTest`），MuMu 模拟器上的 GUI 验收见 `docs/evidence/operations-matrix` §7。
2. **hisnet 快门语义**：`sendclickkey.cgi&-type=KEY_MENU` 是官方 `take()` 发的唯一按键值，但它更像「按一下相机菜单键」而不是拍照；SJ10 MAX 的真机录像/拍照序列需要抓包确认。
3. **Ly 的 `8192` 端口**：只确认了「拍照族用它当预览地址」，端口内是 MJPEG 还是单帧 HTTP 未静态确认。
4. **固件升级**：Ly 有 `9080 CREATE_OTA`、Amba 有 `1286 UPLOAD_FW`、全志有 `/api/ota` 与 `/otaupload?file=update.img`，但都没有包格式与校验说明；OTA 不在本次纳入范围。
5. **`DELETE_FILE=4003` 的参数形态**：调用点只见到 `setPar(...)` 传路径的构造，未见完整样例，实现里按「`par=<相对路径>`」处理并在诊断日志里留证。
