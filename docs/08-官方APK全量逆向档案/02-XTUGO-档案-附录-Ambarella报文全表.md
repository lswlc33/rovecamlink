# 附录 B · Ambarella 报文全表（XTU GO 8.4.3）

> 主文档：[02-XTUGO-档案.md](02-XTUGO-档案.md)
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
