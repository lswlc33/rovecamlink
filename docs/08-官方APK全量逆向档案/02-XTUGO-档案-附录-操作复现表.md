# 附录 D · 操作复现表（XTU GO 8.4.3）

> 主文档：[02-XTUGO-档案.md](02-XTUGO-档案.md)（本附录兑现其 §5 的承诺）
> 其他附录：[A · 海思 CGI 全表](02-XTUGO-档案-附录-海思CGI全表.md)、[B · Ambarella 报文全表](02-XTUGO-档案-附录-Ambarella报文全表.md)、[C · SigmaStar 8080 帧与播放层](02-XTUGO-档案-附录-SigmaStar8080与播放层.md)
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
| BLE 拿到凭据后自动入网（API ≥ 29） | `connectWifi()` → `connectWi_fi()` | `WifiManager.addNetworkSuggestions()`，返回 `0` 才继续 `ConnectivityManager.requestNetwork()`；`NetworkSpecifier.setSsidPattern(new PatternMatcher(ssid, PatternMatcher.RULE_PREFIX))` + `addCapability(13)`（NOT_RESTRICTED）+ `addCapability(14)`（TRUSTED） | `onAvailable` 且 `getIpDevice()=="192.168.0.1"` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bluetooth/utils/WIFIUtils.java:42-58`；`docs/07 §1.3` |
| 扫码/列表路径（API ≥ 29） | `DeviceAddDeviceListFragment` / 首页扫码 | `requestNetwork(…addTransportType(1).removeCapability(12).setNetworkSpecifier(new NetworkSpecifier().setSsid(ssid).setWpa2Passphrase(pwd)))` | 同上 | `_work/xtu_src/sources/com/gku/base/device/NetworkDeviceUtils.java:403-411` |
| API < 29 老 API | `sigmastar/wifi/beforeQ/WifiConnector.java` + `WifiConnector` 代理 | `addNetwork` / `enableNetwork` / `getConfiguredNetworks` / `setWifiEnabled(true)`；另有 `HomeActivity.connectByConfig()` 手写 `WifiConfiguration`（`SSID="\"%s\""`、`preSharedKey="\"%s\""`、cipher 固定 `WIFI_CIPHER_WPA`） | `enableNetwork(...)` 返回值 | `_work/xtu_src/sources/com/gku/HomeActivity.java:1083-1137`、`:1139-1145` |
| 换相机前先踢旧 AP | 当前 SSID `contains("XTU")` 且不等于目标 | `disconnectWifi()` 后再连 | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/DeviceAddDeviceListFragment.java:288-323` |

> 与 `docs/07` 一致，无冲突。补充一点 `docs/07` 未展开的：**入网进度条文案是 `R.string.connecting`（「连接中…」）**，扫码返回后立刻 `progressDialog.show()`（`_work/xtu_src/sources/com/gku/HomeActivity.java:1078-1080`、`:1148`）。

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

与 `docs/07 §1.1-1.2` 一致，本处只补「按顺序发什么、参数值」：

| 步 | 方向 | 精确报文 | 出处 |
|---|---|---|---|
| 1 | 扫描 | `BluetoothLeScanner.startScan(null, ScanSettings(SCAN_MODE_LOW_LATENCY), cb)`，**无 ScanFilter**；业务层过滤 `name.contains("XTU") \|\| name.contains("GKU")`；名字为 null 时手工解析广播 AD type 9 | `docs/07 §1.1`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/DeviceAddActivity.java:125` |
| 2 | 判定 BLE 配网机 | `device.getName().toUpperCase().startsWith("XTU_")` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:473` |
| 3 | 连接 | `device.connectGatt(ctx, false, cb, 2 /*TRANSPORT_LE*/)` | `…/BLEConnectUtils.java:466` |
| 4 | 选特征 | **不匹配 service UUID**：遍历 `getServices()`→`getCharacteristics()`，取带 CCCD `00002902-0000-1000-8000-00805f9b34fb` 或 UUID 等于 `00008888-0000-1000-8000-00805f9b34fb` 的那个 → `setCharacteristicNotification(true)` → `writeDescriptor(CCCD, ENABLE_NOTIFICATION_VALUE)` → `requestMtu(512)`，300ms 后再写 | `…/BLEConnectUtils.java:536-562` |
| 5 | 配对 | 写 `R001_<code>`；被拒则换码重发（App 自生成 4 位码，用户零输入）；`R001` 裸写是「查已配列表」变体 | `…/BLEConnectUtils.java:184`、`:886`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java:312` |
| 6 | 确认/重试 | 写 `R003_<code>`（配对确认）→ 未回则 `postDelayed(…, 300L)` + `sendEmptyDelayed(4096, 300L)` 重试链 | `…/BLEConnectUtils.java:177,268,696,880` |
| 7 | 开热点 | 写 `R002_<code>`；收到 notify `WiFi_Status=1` 才算 AP 起来；**每 1s 无限重写 `R002`，无最大次数、无总超时** | `…/BLEConnectUtils.java:192,722,752-758` |
| 8 | 取凭据 | notify 里 `SSID=…;PWD=…`（**明文**）→ App 存 `SP: "bt_pin"+设备名` → 写 `R002_<code>` 进 `Waiting` | `…/BLEConnectUtils.java:717-726`、`:902` |
| 9 | 反向配网（相机去连手机热点，直播用） | `sendPacket(gatt, ch, String.format("ssid:%s;pwd:%s;", ssid, pwd), "R006")`；`BluetoothLive` 里写死 `sendWifi(…, "gkuvision-5G", "gku88888", …, "R006")` | `…/BLEConnectUtils.java:278`；`_work/xtu_src/sources/com/gku/module_camera/bluetooth/BluetoothLive.java:92,188` |
| 10 | 直播参数下发 | `String.format("live_type:%s;res:%d;fps:%d;bitrate:%d;rtmp_url:%s;", …)` 标号 `R007` | `…/BLEConnectUtils.java:285` |
| 11 | 其它命令 | `R004`（`:376`）、`R008_<code>`（`:295`）、`R009`（`:212`，回包前缀 `R009_cap:` → 能力位，`:783`） | 同文件 |
| 12 | 分包 | `CHUNK_SIZE = 100`；单次 `writeCharacteristic` 超时 `TIMEOUT_MS = 1000` | `…/BLEConnectUtils.java:43-45` |
| 13 | 权限门 | 每次 `writeCharacteristic` 前过 `BLEConnectUtils.checkBlePermission()` | `…/BLEConnectUtils.java:910-918` |

> **冲突提示（与 `docs/07` 无冲突，与主文档 §2.4 有补充）**：`docs/07 §1.6 坑3` 说首页自动弹窗硬编码只放行 `xtu_s7pro`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BaseBTPopupActivity.java:93`）——本附录确认：**BLE 链路只对 S7Pro 系列验证过**，不是所有 XTU 机型都有 BLE 配网。

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

**不在此重复**：ijk 的 17 条 `setOption` 键值全表与 RTSP 传输选择规则见 [附录 C · SigmaStar 8080 帧与播放层](02-XTUGO-档案-附录-SigmaStar8080与播放层.md) §3；结论摘要（值抄自 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java:592-613`）：`skip_loop_filter=48`(category 2)、`analyzemaxduration=100`、`probesize=100`、`flush_packets=1`、`max-buffer-size=1024`、`dns_cache_clear=1`（category 1）、`packet-buffering=0`、`framedrop=12`、`mediacodec-handle-resolution-change=0`、`find_stream_info=0`、`render-wait-start=1`、`reconnect=5`、`mediacodec=0`（category 4）；`type ∈ {H75N,"CV75"}` → `rtsp_transport=udp`，否则 `rtsp_flags=prefer_tcp`（`:603-607`）。

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
| **BLE 等 AP 就绪** | `WiFi_Status != 1` 时每秒重写 `R002`（**无上限**） | BLE，非 HTTP | 配网进度 | `…/BLEConnectUtils.java:752-758`（`docs/07 §1.6 坑1`） |
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
| 15 | **BLE `R001`~`R009` 的语义与回包** | 本附录只能列「写了什么」，**通知回包字段**（`Status`/`Pin`/`KEY:1`/`SSID`/`PWD`/`WiFi_Status`/`R009_cap:`）的取值域、以及 4 位配对码的生成与拒绝重试规则在 `BLEConnectUtils.onCharacteristicChanged` 的混淆分支里；`docs/07 §1.2` 也是行为级描述 | ① nRF Connect 手工连一台相机逐条发 `R001`~`R009` 记回包 ② 对 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java:660-900` 做逐行精读 + 运行时日志（tag `xs, `、`onServicesDiscovered:`） |
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
| C9 | `docs/07` 与 BLE 结论 | 无冲突；本附录补充：BLE 链路实际只对 S7Pro 系列验证过（`docs/07 §1.6 坑3`），以及 `R006`/`R007` 的**逐字段模板串** | §1.4 |
