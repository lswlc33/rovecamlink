# 附录 B · idGoLive HTTP / TCP 命令目录全量

> 返回 [主档案](03-idGoLive-档案.md)。证据根：`_work/idgo_live_src/sources/`。
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
| 3001 | `urlModeChangePhoto/Movie/Playback`(`:42/41/43`) | `?custom=1&cmd=3001&par=0|1|2` | 0=拍照、1=录像、2=回放 | 无 | `LyIC.ready2CamLive`(`:333`)、`quit2RemoteFile`(`:318`)、`leaveRemoteFile`(`:299`) |
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
| 3044 | `urlLensRotationOn`(`:38`) / `…Off`(`:37`) | `?custom=1&cmd=3044&par=1|0` | 镜头旋转 | — | 设置页 |
| 4002 | （`entity/FileInfo.java:55` 内联） | `<视频URL>?custom=1&cmd=4002` | 视频文件路径后挂 cmd | 二进制 JPEG 缩略图 | 回放墙缩略图 |
| 4003 | `urlDeleteOneFile`(`:16`) | `?custom=1&cmd=4003&str=<path>` | str=文件路径 | 无 | 删除单文件 |
| 4004 | `urlDeleteAll`(`:15`) | `?custom=1&cmd=4004` | — | 无 | 删除全部 |
| 8010 | `urlMicrophoneModeNoumenon/Headphone`(`:39/40`) | `?custom=1&cmd=8010&par=0|1` | 0=机身麦、1=耳机麦 | `Cmd8010` | 录音源 |
| 8011 | `urlRecordAudioOn/Off`(`:55/54`) | `?custom=1&cmd=8011&par=1|0` | 录音开关 | `Cmd8011` | 设置页 |
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
| `/api/setdeviceinfo/?custom=1&cmd=1008&par=0|1` | GET | `:38/39` | 相机 OSD 语言：0=中文、1=英文 |
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

