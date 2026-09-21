# 附录 A · 海思 CGI 全表（XTU GO 8.4.3）

> 主文档：[02-XTUGO-档案.md](02-XTUGO-档案.md)
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

`Common.Result` 初始 `returnCode=-1, errorCode=-1`（`Common.java:187-190`）。

NewAPP 下 `DV.executeCommand` 会把命令索引折叠：`IsNewAPP && cmd>=10 && cmd!=10` → `cmd = cmd%2==0 ? 1 : 0`（即 start/stop 归一到 `/record.cgi?&-cmd=start|stop`）；`cmd==10`（退出快录）保持（`…/dv/biz/DV.java:347-355`；同款在 `…/sigmastar/HaisiCommandUtil.java:53-58`）。

### 1.2 设备/状态/参数（`Setting.java` 全量，552 行逐条）

URL 模板固定为 `http://%s%s/<cmd>`，第 2 个 `%s` = `Common.CGI_PATH`；下表只写 cmd+参数。

| 方法 | CGI + query（照抄） | 参数取值/单位 | 响应字段与解析 | file:line |
|---|---|---|---|---|
| `getWorkState(ip)` | `getallinfo.cgi??`（**注意是两个 `?`**） | — | `doForMap` 进 map，返回值即 workState（int） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/Setting.java:29-31` |
| `getVideoInfo(ip,map)` | `getvideoinfo.cgi?` | — | `doForMap` | `:33-35` |
| `setVideoInfo(ip,res,fps)` | `setvideoinfo.cgi?&-resolution=%s&-fps=%d` | `resolution` ∈ `@array/video_resolution_values_{ntsc,pal}`（见主文档 §4.3）；`fps` int | `doForSuccess`（只看 200） | `:37-39` |
| `getBatteryInfo(ip)` | `getbatterycapacity.cgi?` | — | 键 `capacity`（int，**>100 才当有效**，≤100 归 0）、`charge`（`"1"`→充电中）、`ac`（`"1"`→外接电源）；`charge==null` 时走另一分支 | `:43-85` |
| `getSdState(ip)` | `getsdstate.cgi?` | — | `sdstate` ∈ {`SDOK`→0,`SDFULL`→1,`SDNONE`→2,`SDERROR`→3}（对应 `SD_STATE_OK/FULL/NONE/ERROR`）；`total`/`used` 去掉 `" MB"` 后 parseInt，缺失=-1 | `:87-119`；枚举 `Common.java:140-143` |
| `getViewField(ip)` | `getviewfield.cgi?` | — | 键 `fov`，**只接受 150 或 170**，否则 -1 | `:121-127` |
| `setViewField(ip,fov)` | `setviewfield.cgi?&-fov=%d` | `fov ∈ {150,170}`（其它本地直接返回 -1） | `doForSuccess` | `:129-134` |
| `getLoopRecord` / `setLoopRecord` | `getlooprecord.cgi?` / `setlooprecord.cgi?&-enable=%d` | `enable ∈ {0,1}` | `doForBoolean`（键 `enable`） | `:136-142` |
| `getFlip` / `setFlip` | `getflip.cgi?` / `setflip.cgi?&-enable=%d` | 同上 | 同上 | `:144-150` |
| `getBurstInfo(ip,map)` | `getburstinfo.cgi?` | — | `getKeyValueMap` 取 `time`(秒) 与 `count`(张)，任一缺失/非数字 → -1 | `:152-176` |
| `setBurstInfo(ip,time,count)` | `setburstinfo.cgi?&-time=%d&-count=%d` | **本地校验 `time∈[0,30]`、`count∈[0,30]`**，越界直接返回 -1 | `doForSuccess` | `:178-184` |
| `getTimelapseInfo` / `setTimelapseInfo` | `gettimelapseinfo.cgi?` / `settimelapseinfo.cgi?&-time=%d` | `time` 秒 | `doForIntByKey(键 "time")` | `:186-192` |
| `getTimerInfo` / `setTimerInfo` | `gettimerinfo.cgi?` / `settimerinfo.cgi?&-time=%d` | `time` 秒 | 同上 | `:194-200` |
| `getRecordTimelapseInfo` / `set…` | `getrecordtimelapse.cgi?` / `setrecordtimelapse.cgi?&-time=%d` | 秒 | 同上 | `:202-208` |
| `getBootAction` / `setBootAction` | `getbootaction.cgi?` / `setbootaction.cgi?&-action=%s` | `action ∈ {idle, record, timelapse}`（`Common.java:8-10`）；数组另有 `recordlapse/recordloop/recordslow` | `doForStringByKey(键 "action")` | `:210-216` |
| `getAudioEncode` / `setAudioEncode` | `getaudioencode.cgi?` / `setaudioencode.cgi?&-enable=%d` | 0/1 | `doForBoolean` | `:218-224` |
| `getVideoMode` / `setVideoMode` | `getvideonorm.cgi?` / `setvideonorm.cgi?&-videonorm=%s` | `videonorm ∈ {NTSC, PAL}`（`Common.java:147-148`）；读时**非此二值即返回 null** | `doForStringByKey(键 "videonorm")` | `:226-239` |
| `getDeviceAttr(ip,map)` | `getdeviceattr.cgi`（**无 `?`**） | — | `doForMap` 进 map（键见 §1.4） | `:241-246` |
| `setSystemTime(ip,calendar)` | `setsystime.cgi?&-time=%04d%02d%02d%02d%02d%02d` | `yyyy MM dd HH mm ss`，**月是 `Calendar.MONTH+1`** | `doForSuccess` | `:248-253` |
| `getSpotMeter` / `setSpotMeter` | `getspotmeter.cgi?` / `setspotmeter.cgi?&-enable=%d` | 0/1 | `doForBoolean` | `:255-261` |
| `getTimeOsd` / `setTimeOsd` | `gettimeosd.cgi?` / `settimeosd.cgi?&-enable=%d` | 0/1 | 同上 | `:263-269` |
| `getLedState` / `setLedState` | `getledstate.cgi?` / `setledstate.cgi?&-enable=%d` | 0/1；**读时若 `CameraParameters.IsNewDevice` 为真则直接返回 `true` 不发请求** | 同上 | `:271-281` |
| `getBuzzerState` / `setBuzzerState` | `getbuzzer.cgi?` / `setbuzzer.cgi?&-enable=%d` | 0/1 | 同上 | `:283-289` |
| `restoreFactorySettings(ip)` | `/reset.cgi?` | — | **socket 直发、不读响应** | `:291-293` → `:375-398` |
| `setWifi(ip,ssid,pwd)` | `/setwifi.cgi?` + 可选 `&-wifissid=%s` + `&-wifikey=%s`（null 参数则**整段不拼**） | 任意字符串，空格会先被 `HttpProxy` 删掉 | **socket 直发、不读响应** | `:295-308` |
| `setWifiToSta(ip,ssid,pwd)` | `http://<ip>/cgi-bin/setwifista.cgi?&-ssid=%s&-key=%s`（**注意是 `/cgi-bin`，不是 `/cgi-bin/hi3510`**） | 目标路由器的 SSID/密码 | `doForSuccess` | `:310-323`；`ICGI_PATH` 常量 `Common.java:61` |
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
| `region` | String | 缺省 `"G"`（`e.e` 是混淆的 `"H"`） | `HttpRequest.java:112,122-125` |
| `pcbrevision` | String | 缺省 `"V1.0"` | `:126-129` |
| `serialnum` | int（`Integer.parseInt`，缺失→0） | | `:130` |
| `type` | String | 平台分派键（`SSC8838`/`SSC8826`/`SSC8838C`/`H75N`/`CV75`/`Hi3519DV500`/`Hi3518EV300`…）；缺省 `""`；`DeviceAttr` 的默认值是 `"117"`（`Common.java:144,203`） | `:131-134` |
| `networkstatus` | int，缺失→0；**若该键不存在走另一分支**（`:135-189` vs `:190-233`，两条分支的兜底逻辑不同且其中一条引用了未初始化变量） | | `:135-189` |
| `softversion` | String | **若含 `H`/`G` 且含 `.`，截断到最后一个 `.`**（`20.8.6.1.20260710` 这类会被削成 `20.8.6.1`） | `:107-117` |
| `hardversion` | String，缺失→`""`；**`"NewAPP"` 决定方言** | | `:141-146`；`_work/xtu_src/sources/com/gku/HomeActivity.java:1746-1750` |
| `bluetoothrxversion` / `bluetoothtxoneversion` / `bluetoothtxtwoversion` | String，缺失→`""` | | `:147-164` |
| `startdate` | String，缺失→`""` | | `:165-170` |
| `runtimes` | long，缺失→0 | | `:171-174` |
| `model` | int | | `:175-179` |
| `timeout` | int | | `:180-182` |

组装成 `CameraInfors(name, region, pcbrevision, serialnum, type, networkstatus, softversion, hardversion, btRx, btTxOne, btTxTwo, startdate, runtimes, model, timeout)`（`HttpRequest.java:183`）。

### 1.5 激活/试用（仅 `name ∈ {"XTU S7PRO","XTU S7PRO MAX"}` 触发）

| 命令 | CGI（相对 BaseUrl `http://<ip>/cgi-bin/hi3510/`） | 参数 | 响应 | file:line |
|---|---|---|---|---|
| 读激活状态 | `getactivateinfo.cgi` | — | `status`(int，缺省 `"0"`)、`version`(String)、`number`(int，**缺省 5** = 试用次数)、`macaddr`(String，缺省 `""`) | `HttpRequest.java:53,242-279` |
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
| 相机状态（读） | `/cgi-bin/hi3510/getcamerastatus.cgi` | — | 按 `[;\n]|Var` 切，找 `count=` / `status=`；**任一缺失返回 null**（真机 200 空 body ⇒ null） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:142-169` |
| 相机状态（写） | `/cgi-bin/hi3510/setcamerastatus.cgi?-status=<int>`（**`?` 而非 `?&-`**） | — | 200 且 body 含 `SSResponseParse.SS_SUCCESS`(=`"Success"`) 才算成功，成功后再读一次 status | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:171-195`；`…/sigmastar/data/SSResponseParse.java:41` |
| 当前全量状态 | `getcurallinfo.cgi`（`VERSION==1`）或 `getallinfo.cgi`（`VERSION==2`） | — | `getMap` → `mode`,`state`,`event`,`pasttime`；`VERSION==2` 时 `mode` 是数字要经 `replaceMode()` 映射；最后拼成**伪 JSON 广播** `{"mode":"X";"state":"Y";"event":"Z";"pasttime":"W"}` 发 `com.gku.xtugo.MESSAGE_ACTION` | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:305-317` |
| WiFi 信息 | `getwifi.cgi` | — | `getMap2` → 回调 `getWifiIsFinish(treeMap)`；键集合由设备决定 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/SetDataUtils.java:318-332` |

`replaceMode(int)` 的完整映射（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:319-346`）：`0→NormalPhoto("NormalPhoto")`、`1→TimerPhoto`、`10→Burst`、`11→TimerPhoto`（**与 1 重复，11 在 `Common.java:151` 是 `WORK_MODE_MULTI_TIMELAPSE`，映射到 TimerPhoto 是老代码错误**）、`20→NormalVideo("NormalVideo")`、`21→CarMode`、`22→VideoLapse`、`23→VideoPhoto`、`24→SlowRec`、其余→`""`。

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
| DCIM 落位 | `<外置>/DCIM/<DCIM|DCIM/Camera>/<video\|photo>/<displayName>`，Android 9 以下走 `_9_down` 分支 | 同 | `_work/xtu_src/sources/com/gku/module_camera/hisi/HisiDownloader.java:103-131` |

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
