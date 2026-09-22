# 07 · 蓝牙发现 → 唤醒相机 WiFi → 自动连网，以及与 VPN 代理共存：研究报告

> 调研时间：2026-09-21。语料：`_work/xtu_src`（XTU GO 8.4.3）、`_work/tuwin_src`（TUWIN 1.6.4）、`_work/idgo_live_src`（idGoLive 1.3.6）反编译源码 + Android/Apple 官方文档 + 厂商公开说明。
> 本文只做研究，不含实现。每节末尾标注「本文新增」还是「docs/01~06 已有」，避免重复劳动。

---

## 0. 结论速览

1. **用户说的功能真实存在，而且 XTU 做得比想象中完整**：BLE 扫描发现 → GATT 握手（手机自己生成 4 位码写给相机，被拒就自动换码，**用户全程零输入**）→ 相机在 BLE 通知里**主动上报自己的 SSID 和密码** → App 调系统 API 自动入网。全链路代码在 `_work/xtu_src/.../sigmastar/newUi/deviceAdd/`。
2. **「蓝牙唤醒 WiFi」唤醒的是相机的热点，不是手机的 WiFi 开关**。Android 10 起三方 App 调 `setWifiEnabled()` 是空操作——这一点 XTU 代码本身就是证据：手机 WiFi 没开时，Android 9 以下它自己开，Android 10 以上它只能跳系统设置页让用户手开（§3.1）。
3. **用户的两个痛点其实是同一个根因**：手动在系统设置里连上相机热点后，我们的代码走的是"跳过 join"分支，因此**从来没有绑定过 socket**，于是所有相机流量都落在"默认网络"上——而 VPN 一开，默认网络就是隧道。所以"必须手动连"和"开代理就断"是一件事的两面，把自动入网这条路补上，VPN 问题同时缓解一大半（§4）。
4. **三家横向**：XTU 的 BLE 闭环最完整；idGoLive 的 BLE 命令设计最教科书（`{"mode":"wifi","action":"enable"}` / `action":"info"` 直接要 SSID/PWD/IP）；TUWIN 完全没有蓝牙，**但它的网络层是解决 VPN 问题最好的蓝本**——`NetworkPlane {INTERNET, DEVICE}` 双平面 + 每 socket 绑定 + 进程绑定降级为租约（§2、§4.4）。
5. **行业上这是标准打法**：IoT 侧有成熟的 BLE 配网范式（讯飞/巴法/乐鑫文档一致），影像设备侧 GoPro/Insta360/DJI 都是"蓝牙先行、远程开 WiFi、手机自动加入"。更值得注意的反证：**Insta360 安卓 App 自带一个"代理模式"（本质是 App 内 VpnService）**来解决"连了相机热点后手机没网"——说明"用 VPN 机制治理相机链路的流量"在竞品里已经是成熟产品化能力（§2.3）。
6. **前瞻风险**：Android 17（targetSdk 37）起 **`ACCESS_LOCAL_NETWORK` 运行时权限成为强制**，届时 TCP 连局域网 IP、UDP 广播/组播、mDNS 全部要授权。我们现在靠 `INTERNET` 隐式通行，但这条迟早要接线，且它反而给了系统介导的选择器（picker）一条免权限的捷径（§3.4）。

---

## 1. XTU 官方到底怎么做的（逐行取证）

### 1.1 蓝牙形态：真 BLE GATT，没有经典蓝牙，也没有 Wi-Fi Direct

清单权限（`_work/xtu_res/resources/AndroidManifest.xml:26-35`）：

```xml
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT"/>
<uses-permission android:name="android.permission.BLUETOOTH_SCAN"/>
<uses-permission android:name="android.permission.BLUETOOTH" android:maxSdkVersion="30"/>
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" android:maxSdkVersion="30"/>
<uses-permission android:name="android.permission.BLUETOOTH_ADVERTISE"/>
```

- 扫描：`BLEManager.java:52-64`，`BluetoothLeScanner.startScan(null, ScanSettings(LE_SCAN_MODE_LOW_LATENCY), cb)`，**没有 ScanFilter**，过滤在业务层做。
- 连接：`BLEConnectUtils.java:466` `device.connectGatt(ctx, false, cb, 2)` —— 最后的 `2` 是 `TRANSPORT_LE`，且只对名字 `startsWith("XTU_")` 的设备走这条（`isBLE_Device()`，`:471-474`）。
- 服务/特征值选择**不匹配 service UUID**，而是遍历找 CCCD：`BLEConnectUtils.java:541` 判 `00002902-…` 或 `00008888-…`，随后 `setCharacteristicNotification(true)` + `requestMtu(512)` + 300ms 后写 `ENABLE_NOTIFICATION_VALUE`。这是白牌固件 UUID 不统一的典型妥协。
- 全仓 `createRfcommSocket|BluetoothSocket` 在 `com/gku/` 零命中 ⇒ **无 SPP/RFCOMM**；`startAdvertising` 零命中。
- **修正旧结论**：记忆里那条"XTU 的『蓝牙心跳』其实是 Ambarella TCP 报文 268435492"仍然成立，但它和这条 BLE 通道**互不相干**，是两回事。

### 1.2 端到端时序（新 UI 状态机版）

```
手机                                     相机（SigmaStar / 海思平台）
 │  BLE 扫描，名字含 XTU/GKU              │  BLE 常广播（即使 AP 关着）
 ├─ connectGatt(TRANSPORT_LE) ──────────▶│
 ├─ 发现服务，挑带 CCCD 的特征，开通知 ───▶│
 ├─ MTU 512 ────────────────────────────▶│
 ├─ R003_<pin>  配对 ────────────────────▶│  notify: Status / Pin / KEY:1
 ├─ (1s 后) 收到 notify ─────────────────▶│
 │        ◀── notify: SSID=XTU_xxx, PWD=<明文> ──┤   ★ 凭据从蓝牙回来，不用猜也不用手输
 ├─ R002_<pin>  开热点/确认 ─────────────▶│   状态 Opening → Waiting
 │        ◀── notify: WiFi_Status:1 ────────────┤   AP 真的起来了
 ├─ addNetworkSuggestions + requestNetwork ────▶│   手机入网
 ├─ onAvailable → 读 LinkProperties 默认路由网关 │
 │   网关 == 192.168.0.1 ? → 进相机主页          │
```

关键代码（`BLEConnectUtils.java:717-726` 收到凭据、`:735-748` 等 AP 就绪）：

```java
if (mapDivideString2.containsKey("SSID") && mapDivideString2.containsKey("PWD")) {
    deviceAddKeyItem.setSsid(...); deviceAddKeyItem.setPwd(...);
    characteristic.setValue("R002_" + deviceAddKeyItem.getCode());
    gatt.writeCharacteristic(characteristic);
    curStatus = ConnectStatus.Waiting;
}
...
if (mapDivideString.containsKey("WiFi_Status") && "1".equals(...get("WiFi_Status"))) {
    arrayList.add(ssid); arrayList.add(pwd);
    mConnectView.connectWifi(deviceAddKeyItem.getDeviceName(), arrayList);  // → connectWi_fi()
}
```

`R001~R009` 命令表、分包规范（`CHUNK_SIZE=100`、`pin:<code>;`、MD5 签名）docs/01 已有，不重复。

### 1.3 入网 API 分层：三条路并存，且 XTU 自己写得不一致

| 分支 | 代码 | 做法 |
|---|---|---|
| API ≥ 29（BLE 路径） | `sigmastar/bluetooth/utils/WIFIUtils.java:42-58` | `addNetworkSuggestions()` 返回 0 才 `requestNetwork()`，specifier 用 `setSsidPattern(PatternMatcher(ssid, PREFIX))`，`.addCapability(13).addCapability(14)` |
| API ≥ 29（扫描路径） | `base/device/NetworkDeviceUtils.java:403-411` | `requestNetwork(addTransportType(1).removeCapability(12).setNetworkSpecifier(setSsid(ssid).setWpa2Passphrase(pwd)))` |
| API < 29 | `sigmastar/wifi/beforeQ/WifiConnector.java` + `WifiManagerProxy.java` | 真·老 API：`addNetwork` / `enableNetwork` / `getConfiguredNetworks` / `setWifiEnabled(true)`，无反射、无系统权限 |

常量真值从 SDK jar 里核过（`javap -constants android.net.NetworkCapabilities`，`E:/Android/Sdk/platforms/android-35/android.jar`），**`addCapability` 传的是位索引不是掩码**：`1=TRANSPORT_WIFI`、`11=NOT_METERED`、`12=INTERNET`、`13=NOT_RESTRICTED`、`14=TRUSTED`、`15=NOT_VPN`、`16=VALIDATED`。所以 BLE 那条路径要求的是 **NOT_RESTRICTED + TRUSTED**，`removeCapability(12)` 才是"去掉 INTERNET"——两条路径都能连无外网的相机热点，**不存在"要求互联网"的低级 bug**（子代理把它标成 NOT_VPN/VALIDATED 是猜的，已纠正）。

真坑在别处：`addNetworkSuggestions(...) == 0` 这个门。用户拒绝建议（或系统直接不给建议）时，**`requestNetwork` 根本不会被调用**，表现为点了没反应的静默失败。

### 1.4 "连上了没有"的判据：网关 IP，不是 SSID

`NetworkDeviceUtils.java:332-346` 用 `LinkProperties` 默认路由的网关判断，兜底 `DhcpInfo.serverAddress`：

```java
public String getIpDevice() {
    for (RouteInfo r : cm.getLinkProperties(networkDevice).getRoutes())
        if (r.isDefaultRoute()) { hostAddress = r.getGateway().getHostAddress(); break; }
    return !isValidIp(hostAddress) ? getWiFiServerIp(ctx) : hostAddress;
}
```

`DeviceAddNewActivity.java:184-189`：`onAvailable` 里判 `ipDevice.equals("192.168.0.1")` 才继续，否则 `resetBT()`。⇒ **XTU 相机固定 IP = `192.168.0.1`**（`DV.java:66-67`）。我们的 `WifiController.gatewayInternal()` 已经是同一思路（读默认路由网关），判据可以照抄这个"网关等于期望 IP 才算连上相机"的严格性。

### 1.5 除了 BLE，XTU 还有两条"唤醒"通道（本文新增）

- **HTTP 把相机切回 AP 模式**：`Setting.java:325-327`
  ```java
  public static int setWifiToAp(String ip) {   // 注意：裸 setwifista.cgi，无参数，且前缀是 /cgi-bin 而非 /cgi-bin/hi3510
      return HttpProxy.doForSuccess(String.format("http://%s%s/setwifista.cgi?", ip, Common.ICGI_PATH));
  }
  ```
  调用点在 WiFi 断开事件里（`HiWifiScrollView.java:147`）。同类还有 `wifisleep.cgi`（`:463`）。
- **Wake-on-LAN 才是真正的"唤醒休眠相机"**：`Setting.java:486-510` 手搓 102 字节 magic packet（`6×FF` + `MAC×16`），向 `<net>.255:9` **连发 5 次**；门控 `DV.supportWakeSleep()` = `getdevcapabilities` 含 `"standby"` 或 sensor id `117`。前提：**手机已经在同一个局域网里**，所以 WoL 解决的是"相机休眠"，BLE 解决的是"AP 没开/不知道凭据"，两者互补。

### 1.6 照抄之前要改掉的 6 个坑

1. `WiFi_Status != 1` 时**每 1s 无限重写 `R002`，没有最大重试次数也没有总超时**（`BLEConnectUtils.java:752-758`）——我们要加硬超时（建议 15~20s）+ 诊断日志。
2. `addNetworkSuggestions()==0` 才 request ⇒ 静默失败；应当把两者解耦（建议只是"以后自动连"，当下这次连接不依赖它）。
3. 首页自动弹窗的过滤器**硬编码只放行 `xtu_s7pro`**（`BaseBTPopupActivity.java:93`）——说明这条链路实际上只对 SigmaStar 的 S7Pro 系列验证过；我们做插件化时 BLE 元数据要挂在 profile 上，不是硬编码。
4. `device.getName()` 在 Android 12+ 无 `BLUETOOTH_CONNECT` 时返回 null，XTU 会**手工解析广播包 AD type 9（Complete Local Name）**兜底（`BaseBTPopupActivity.java:49-73`）——这个 fallback 值得照抄，否则大量机型扫不到设备。
5. 先踢掉别的相机 AP：`connectWi_fi` 决策树里 `if (当前SSID.contains("XTU") && 不等于目标) disconnectWifi()`（`DeviceAddDeviceListFragment.java:288-323`）——多相机现场的必要处理。
6. 相机 AP 密码走 BLE 明文上报 ⇒ 我们导出诊断日志时**必须把 PWD 字段脱敏**（Diag 已有 masking 机制，接上即可）。

---

## 2. 三家横向 + 行业范式

### 2.1 发现手段矩阵

| 手段 | XTU | TUWIN | idGoLive |
|---|---|---|---|
| BLE 扫描 + GATT 唤醒/取凭据 | ✅（S7Pro 系列） | ❌ 零蓝牙代码 | ✅（BLE 或 SPP，由 `AppInfo.isBLE` 决定） |
| 经典蓝牙 RFCOMM `00001101` | ❌ | ❌ | ✅（`ICatchCoreBluetoothClient.java:20,33`） |
| `getScanResults` + SSID 前缀 | ✅ | ✅ | ✅ |
| 固定 IP / 网关探测 | ✅ | ✅ | ✅（3 个候选 IP ping） |
| UDP 广播 | 仅 WoL :9 | ❌ | ❌ |
| UDP 组播 | ❌ | ❌ | ✅ `234.168.168.168:5002` |
| mDNS / DNS-SD | ❌ | ❌ | ❌（只有第三方库里的死代码） |
| Wi-Fi Direct / P2P | ❌ | ❌ | ❌ |

三家**都没有 Wi-Fi Direct**（`WifiP2pManager` 仅出现在 `ContextCompat` 的框架字符串表里）。⇒ 说明这个品类的行业选择仍然是 SoftAP 直连，不要为了"高级"去上 P2P：P2P 一样没有互联网，且相机侧固件不支持。

### 2.2 idGoLive 的 BLE 命令设计更干净（值得当作我们协议抽象的参考）

`idgo_live_src/.../bluetooth/core/client/command/ICatchCoreBluetoothCommand.java:34-38`：

```java
BT_CMD_WIFI_REQ_ENABLE   = "{\"mode\": \"wifi\", \"action\": \"enable\", \"type\": \"ap\"}";
BT_CMD_WIFI_REQ_DISABLE  = "{\"mode\": \"wifi\", \"action\": \"disable\"}";
BT_CMD_WIFI_REQ_INFORM_ESSID_PWD_IP = "{\"mode\": \"wifi\", \"action\": \"info\", \"essid\":\"\", \"pwd\":\"\", \"ipaddr\":\"\"}";
BT_CMD_SYSTEM_POWER_HIBER = ...
```

JSON over BLE，语义自描述；对比 XTU 的 `R002_<pin>` 短码 + `key:value,key:value` 通知。我们的 `CameraProtocol` 抽象应能同时容纳两种（BLE 命令表放 profile，编解码放插件）。

注意 idGoLive 清单里**只有 legacy `BLUETOOTH`/`BLUETOOTH_ADMIN`，没有 `BLUETOOTH_SCAN`/`BLUETOOTH_CONNECT`** ⇒ 它的蓝牙配网在 Android 12+ 上其实已经废了。这是白牌 App 的典型现状，也是我们做替代品的机会点。

### 2.3 行业范式与竞品行为

- **IoT BLE 配网范式**（讯飞 `doc.iflyos.cn/device/network/ble.html`、巴法 `cloud.bemfa.com/docs/src/wifi/ble.html`、乐鑫 `wifi_provisioning`）：设备广播带标识 → App 连接 → 在约定 GATT 特征上写 SSID/密码/鉴权 → 设备回状态码 → 设备入网。方向是"手机把家里 WiFi 交给设备"。
- **运动相机是反方向**：设备已经有自己的 AP，手机要去连它 ⇒ 于是 BLE 的职责退化成三件：**认设备（谁在我旁边）、开热点（唤醒 AP）、报凭据（SSID/PWD）**。XTU/idGoLive 正是这三件事。XTU 另有反向通道 `R006 ssid:…;pwd:…`（相机去连手机热点，用于直播，硬编码 `gkuvision-5G/gku88888`）。
- **GoPro / Insta360 / DJI**：产品行为都是"蓝牙先行配对，App 可远程打开相机 WiFi 并自动加入"（帮助文档口径一致，本次未能抓取正文取证，社区页面是 JS 壳）。
- **Insta360 安卓版"代理模式"**（官方说明原文，`insta360.com/cn/support/supportcourse?post_id=20465`）：
  > "若您发现手机连接相机后，除 Insta360 app 之外的 app 无法接入互联网……此时您可以通过 Insta360 app 设置中的'代理模式'开关。" 且"断开相机连接时 VPN 会自动断开"。

  这就是 **App 自建 VpnService + 本地转发**：连了无外网的相机热点后，把全机流量从移动数据放出去。对我们的启示有两面：(a) 用 VPN 机制治理相机链路的流量是成熟做法，我们若走这条路有先例可引；(b) Android 同一时刻只能有一个 VpnService ⇒ **自带 VPN 会把用户现有的代理/VPN 挤掉**，必须显式 opt-in，绝不能默认开。

---

## 3. 平台能力边界：我们能做到哪一步

### 3.1 手机侧硬限制（先认清不能做的）

| 想做的事 | 能不能 | 依据 |
|---|---|---|
| 打开/关闭**手机自己的** WiFi 开关 | **Android 10+ 不能**（`setWifiEnabled` 对三方 App 空操作） | XTU 代码即证据：`SDK<29 ? openWifi() : startActivity(Intent("android.settings.WIFI_SETTINGS"))` |
| 让**相机**打开自己的热点 | 能（BLE `R002` / JSON `enable` / `setwifista.cgi` / WoL） | §1.5 |
| 不经用户同意静默改系统 WiFi 列表 | 不能（suggestion 有系统弹窗/通知；specifier 有系统确认框，首次之后记住） | Android 官方文档 |
| 读当前 WiFi 的 SSID | 能，但 Android 12+ 要 `NEARBY_WIFI_DEVICES`/定位，且 `<unknown ssid>` 常见 | 我们 `currentCameraSsid()` 已处理该哨兵值 |
| 让手机同时"连相机 + 上网" | 能 —— specifier 网络天生不是默认网络，移动数据照常上网 | Android 文档："该 API 不为设备提供互联网连接" |

### 3.2 三条自动入网路线（决定产品形态的关键对比）

| | ① legacy `addNetwork/enableNetwork` | ② `WifiNetworkSuggestion` | ③ `WifiNetworkSpecifier` + `requestNetwork`（我们现在用的） |
|---|---|---|---|
| 版本 | 仅 < Android 10 | 29+ | 29+ |
| 需要 | `CHANGE_WIFI_STATE`(+定位) | `CHANGE_WIFI_STATE`；`isAppInteractionRequired` 才要定位 | **不需要位置权限**（系统代为匹配），需要 `CHANGE_NETWORK_STATE` |
| 用户交互 | 无 | 首次通知/弹窗（Android 11+ 前台弹框）；**拒绝会直接吊销本 App 的 `CHANGE_WIFI_STATE`** | 首次系统确认框，之后同一 AP 免确认（"忘记网络"会清掉） |
| 是否变成系统默认网络 | 是 | **是** | **否**（只本 App 可见可用，移动数据继续上网） |
| App 退出/进程死亡后 | 连接保留，且写进了系统配置（脏） | 连接保留、可后台/重启自动重连 | **连接立即失效**（必须保持 `NetworkCallback` 注册） |
| 后台长时间保活 | OK | OK | 差：需要前台服务维持请求 |
| 对 VPN 抢流量的抵抗力 | 无（走默认网络） | 无（走默认网络，VPN 一并抢走） | **强**：socket 绑到这张明确的 Network，隧道抓不到 |
| 适合我们的场景 | Android 7/8 兜底（minSdk 24 需要） | "以后自动连"的体验增强 | ✅ 主路径 |

> 结论：**③ 是我们已经选的，而且选对了**——它同时解决"不用去系统设置手点"和"VPN 抢流量"。它的代价（App 退后台就掉线、期间本 App 没有互联网）必须用前台服务 + 明确的 UI 语义补掉。②可作为"下次自动连"的锦上添花，但不能作为当次连接的前提（§1.6 坑 2）。

另外两条 Android 官方文档层面的细节：
- specifier 支持 `setSsidPattern(PatternMatcher(prefix, PATTERN_PREFIX))`，让**系统**去做扫描匹配，App 不必自己 `startScan()`，可以少依赖定位权限。XTU 的 BLE 路径就是这么写的。
- `NetworkRequest` 上 `removeCapability(NET_CAPABILITY_INTERNET)` 是连"无外网 AP"的必要条件；我们的 `connectModern()` 已经做了（`WifiController.android.kt:81`）。

### 3.3 权限与保活清单（Android 侧，做 BLE 要补的）

- 现在清单里**完全没有蓝牙权限**（`composeApp/src/androidMain/AndroidManifest.xml`）：要加 `BLUETOOTH_SCAN`（API 31+，可带 `neverForLocation`）、`BLUETOOTH_CONNECT`、以及 `BLUETOOTH`/`BLUETOOTH_ADMIN` 带 `maxSdkVersion="30"`。
- Android 6~11 的 BLE 扫描要求定位权限——我们已有 `ACCESS_FINE_LOCATION`；Android 12+ 用 SCAN/CONNECT 后定位不再是必须，但**WiFi 扫描结果**仍然要定位（`AppState.kt:234-249` 的注释是对的，别改）。
- 后台扫描限制：BLE 扫描在息屏/后台会被系统节流；连接后靠 GATT + 前台服务。

### 3.4 前瞻：Android 17 的本地网络权限（本文新增，重要）

官方 `privacy-and-security/local-network-permission`：

| | Android 16 | Android 17 |
|---|---|---|
| 生效条件 | targetSdk ≤ 36，需 `adb` 显式 opt-in | **targetSdk ≥ 37 强制，默认拒绝** |
| 权限 | （临时用 `NEARBY_WIFI_DEVICES`） | `ACCESS_LOCAL_NETWORK`，**运行时权限**，属 NEARBY_DEVICES 组 |
| 被 gate 的流量 | — | 出站 TCP 到局域网 IP、入站 TCP、UDP 单播/组播/广播、`.local` mDNS 解析；"实现深在协议栈里，对所有网络 API 生效" |
| 豁免 | — | 局域网 DNS(53)；Cast output switcher；`NsdManager` + `FLAG_SHOW_PICKER` 由系统弹框选中的那台设备 |

对我们的意义：(1) 我们全部流量都是"TCP 到 192.168.x.1"，**升级 targetSdk 到 37 之前必须接这个权限**；(2) 好消息是 `INTERNET` 目前给了隐式放行，且我们的**流程本来就是"用户在本 App 里显式选定一台相机"**，语义上与系统 picker 同构，弹窗话术很好写；(3) 反过来说，这类权限与蓝牙、`NEARBY_WIFI_DEVICES` 同属 NEARBY 组，**一次授权能覆盖 BLE + 扫描 + 局域网**，UI 上应当合并成一个" nearby 设备"引导，而不是三次弹窗。

### 3.5 iOS（只壳，先把边界写清楚）

- 入网：`NEHotspotConfiguration(ssid:passphrase:isWEP:)` + `NEHotspotProvider.apply(...)`，需要 **Apple 审批的 Hotspot Configuration entitlement**；`joinOnce = true` 时"配置的生命周期受创建它的 App 运行状态限制"（Apple 文档原句：*Restricts the lifetime of a configuration to the operating status of the app that created it*），语义上与 Android specifier 很像；`lifeTimeInDays` 可控过期。支持 `ssidPrefix` 匹配。可用 `removeConfiguration` 清理。
- 读当前网络：`NEHotspotNetwork.fetchCurrent` 需要 `com.apple.developer.networking.wifi-info`，且要求已装 hotspot 配置或定位授权——这是各家相机 App 在 iOS 上做"检测我连没连上相机"的老痛点。
- 本地网络弹窗：iOS 14+ 首次访问局域网会弹"允许查找并连接本地设备"。
- VPN 冲突：iOS 侧如果用户开了带 `includeAllNetworks` 的代理（Surge/Clash 的"全局/包含所有网络"），**局域网流量一定进隧道**，App 侧无法绕过；行业做法是检测 `utun` 接口并提示用户关掉，或让相机侧提供"只路由本网段"的配置模板。我们只能做提示 + 文档，没有能力解决。

---

## 4. "开 VPN 代理后无法和相机通讯"：机理、根因与对策

### 4.1 机理

Android 的 `VpnService` 建立 tun 后，VPN 网络成为**默认网络**，并用 `addRoute("0.0.0.0", 0)` 覆盖全部目的地址（官方文档原句：要接受全部流量就加 `0.0.0.0/0`/`::/0`）。关键点：**"本地子网是否被吞"不是由目的 IP 决定的，而是由 socket 走哪张路由表决定的**。相机热点没有互联网、只有一条 /24 直连路由，一旦默认网络变成 VPN，这条直连路由就不在默认路径上了。

⇒ 只有两条出路：**(a) VPN 侧自己放过局域网**（`VpnService.Builder.setAllowLocalNetworking()`，API 30+，Clash/sing-box 类"绕过私有地址/Bypass private networks"开关，或 sing-box `tun.route_exclude_address`）；**(b) 我们的 socket 不走默认网络**（`ConnectivityManager.bindProcessToNetwork()` / `Network.bindSocket()` / `network.socketFactory`）。(a) 不是我们能控制的，(b) 才是我们的责任。

### 4.2 我们为什么现在会中招（代码级根因）

`AppState.kt:286-317`：

```kotlin
if (host == null) {
    // Joining a network we're already on is a no-op the OS rejects (or re-prompts for),
    // so skip it when the user joined in system settings.
    val alreadyOnTarget = ssid != null && current.equals(ssid, ignoreCase = true)
    if (ssid != null && !alreadyOnTarget) { ... graph.wifi.connect(ssid, password) ... }   // 只有这里会绑定
```

`WifiController.android.kt:89-96` 的 `onAvailable` 里才 `cm.bindProcessToNetwork(network)`。

⇒ 走"用户手动在系统设置连热点 → App 里点已连接的相机"这条路径时，`alreadyOnTarget == true`（或 `ssid == null`，由 `watchWifiChanges` 自动触发时就是 null），**`wifi.connect()` 被跳过，因此从未 `requestNetwork`、从未绑定**。此后 Ktor CIO、Media3 RTSP、TCP 7878/8787 的 socket 全部落在默认网络上，被 VPN 的 `0.0.0.0/0` 吞进隧道 ⇒ 表现就是"能连 WiFi，但 App 搜不到/连不上相机"，关掉代理就好了。

也就是说：**当前的 VPN 故障不是绑定不够强，而是根本没绑定。** 补上"不依赖用户手点"的自动入网（§1/§3.2 路线③），VPN 问题大部分自然消失。

### 4.3 四种对策与各自的失效条件

| 对策 | 做法 | 覆盖 | 失效条件 |
|---|---|---|---|
| **A. per-socket / per-process 绑定到相机 Network** | `requestNetwork(specifier)` 后 `bindProcessToNetwork` 或 `network.socketFactory` | 绝大多数 VpnService 代理 | ① always-on 且 `BLOCK_STATE_BLOCK_UPSTREAM`/"未连接 VPN 时阻止连接"；② VPN 用**按 UID 的 per-app 规则**（分应用代理）时，mark 逻辑可能先于绑定生效；③ root/iptables 或 sing-box `strict_route` 类内核层拦截 |
| **B. 请求时显式排除 VPN** | `NetworkRequest.addCapability(NET_CAPABILITY_NOT_VPN)`（值 15），让系统只回非 VPN 网络 | 与 A 配合，保证拿到的是真 WiFi | 只是选网正确，不解决路由；单独用无效 |
| **C. 检测 + 提示** | 观测 `activeNetwork` 的 caps 含 `TRANSPORT_VPN`（值 4），在连接页/日志里明确写"检测到代理运行，请在代理 App 中放行局域网/私有地址" | 兜住 A 的失效面 | 需要用户动手，属于体验降级而非解决 |
| **D. 自带 per-app VPN 转发器**（Insta360 代理模式的镜像用法） | 自己起 VpnService，`addAllowedApplication(本应用 uid)` + 只 addRoute 相机网段，本地转发后从 WiFi Network 重新发起连接 | 理论上最强，能穿透 A 失效的多数场景 | **Android 同时只允许一个 VpnService** ⇒ 会挤掉用户正在用的代理，必须显式 opt-in 并在 UI 上写清代价；工程量大（要么本地转发代理，要么用户态 TCP 栈）；iOS 完全做不到 |
| **E. 相机侧配合** | 相机热点开启时把网关/DNS 指向自己、AP 提供"允许被局域网直接访问"，或支持 STA 模式与家里路由同网段 | 让"同网段直连"成立 | 白牌固件不可控；XTU 有 `setwifista.cgi` 可切 STA（风险：切了之后要能切回来，`docs/05` 已记录其为无鉴权写接口，**不做默认能力**） |

推荐组合：**A + B + C**（成本极低、收益直接），D 作为 P2 可选项并默认关闭。

### 4.4 但 `bindProcessToNetwork` 有个我们已经踩下的副作用

现在一旦绑定，**整个进程**（含云端 OTA 版本索引、未来可能的日志上报）都走相机网络，而相机热点没有互联网 ⇒ 会话期间 OTA 检查、任何云端请求必然失败。XTU 也是这么脏的（`NetworkDeviceUtils.bindProcessToNetworkNoNet()` + 所有 socket 用 `network.getSocketFactory()`，混用）。

TUWIN 的做法明显更成熟（`tuwin_src/.../core/network/NetworkPlane.java:11-14`、`RoutedOkHttpProvider.java:83-107`、`ProcessBindingController.java:88-128`）：

```java
enum NetworkPlane { INTERNET, DEVICE }        // 每个请求先选平面
// DEVICE 平面：整条连接按 socket 绑到相机 Network，DNS 也从这张网卡解析
new OkHttpClient.Builder()
    .retryOnConnectionFailure(false).followRedirects(false)
    .socketFactory(network.getSocketFactory())
    .dns(hostname -> asList(network.getAllByName(hostname)))
// 进程级绑定被降级为「引用计数的临时租约」，多个 owner 争抢会抛 ProcessBindingConflictException
```

⇒ **建议我们的网络层也改成"平面"模型**：相机链路 per-socket 绑定（Ktor CIO 走 `engine { socketFactory { … bindSocket … } }`，Media3 走自定义 `DataSource.Factory`/`HttpStack`），云端链路显式走"未绑定/移动数据"平面，`bindProcessToNetwork` 只作为"拿不到 socket 工厂的第三方库"的租约式兜底。这既解决 VPN，又解决"会话期间没网导致 OTA 检查失败"。

---

## 5. 落到本项目的建议（分阶段，供决策，未开工）

**P0 · 不依赖蓝牙，先把 VPN 与体验修直（约 1 天）**
1. 手动已连 WiFi 的路径也去绑定：对"当前已在相机 SSID 上"的情况，用 `registerNetworkCallback(addTransportType(WIFI) + removeCapability(INTERNET) + addCapability(NOT_VPN))` 拿到那张 `Network` 并绑定 socket（不请求新网络、不打扰用户）。这一条能立刻消掉用户报的第二个症状。
2. 检测并记录 VPN：`Diag` 环境快照加一行 `net.vpn=active/none`（`AppState.kt:187-217` 已有 `buildDiagnosticsEnv`），UI 上给一句"检测到代理，可能拦截相机通信"的提示。
3. 把 `bindProcessToNetwork` 改成租约式 + 云端走另一平面（§4.4）。

**P1 · BLE 发现 + 唤醒 + 自动入网（XTU S7Pro 系列首发）**
4. 新增 `expect fun createBleCentral(): BleCentral`（对齐 `WifiController.kt:46-47` 的工厂模式），androidMain 用 `BluetoothLeScanner` + `connectGatt(TRANSPORT_LE)`；产出与 `QrWifiCredentials` 同型的 `{ssid, pwd, deviceName, btAddress}`，之后直接复用 `AppState.connect(ssid, password)`，编排几乎不改（`AppState.kt:267`）。
5. BLE 元数据（命令表 `R002/R003/R006`、通知键 `SSID/PWD/WiFi_Status`、名字前缀 `XTU_`、GATT CCCD 兜底规则）挂进现在**已定义但无人使用的 `CameraProfile`**（`CameraProtocol.kt:85-93`），把这块空壳接上电。
6. `Phase` 枚举加 `DiscoveringBle`/`WakingAp`（`AppState.kt:43-52`）；BLE 通道所有报文走 `Diag.inOp` + 密码脱敏。
7. 抄 §1.6 的 6 条改进：硬超时、建议与当次连接解耦、广播包 AD type 9 兜底解析、踢掉别的相机 AP、多机型过滤走 profile 不硬编码。
8. 保留 §3.2 路线①作为 Android 7/8（minSdk 24）兜底，`WifiConnector` 那套我们已有 `connectLegacy()`。

**P2 · 完善**
9. WoL 支持（休眠唤醒）+ `standby` 能力门控；`setwifista.cgi` 不做默认能力（安全）。
10. `WifiNetworkSuggestion` 作为"下次自动连"增强；BLE 配对信息本地持久化（XTU 用 `bt_pin<btName>`，且明文写日志是它的缺陷，我们加密/脱敏）。
11. Android 17 `ACCESS_LOCAL_NETWORK` 预接（清单 + 运行时申请 + targetSdk 升级前完成）。
12. iOS：`NEHotspotConfiguration` 壳 + 蓝牙占位（需 Apple entitlement 审批，先提工单）。

**明确不做**：Wi-Fi Direct（三家固件都不支持）、iOS 自带 VPN 绕过（做不到）、把用户现有 VPN 挤掉的默认 D 方案。

---

## 6. 需要真机 / 用户确认的开放问题

1. **你的相机（XTU "X7 Pro"，实为 S7 Pro 系？）到底有没有 BLE 广播？** 最快验证：手机装 nRF Connect（或 LightBlue），相机开机、AP 关着的状态下扫 `XTU_` 前缀；或把官方 App 的"添加设备"走一遍看是否出现蓝牙配网弹窗。这决定 P1 是"BLE 闭环"还是"只有扫描 + 凭据常量 + 手动开 AP"的降级形态。
2. ~~配对 PIN 的来源~~ **已查清（2026-09-21 晚，二次核对源码）**：4 位码由**手机自己生成并写给相机**（`DeviceAddDeviceListFragment.onServicesDiscovered()` 用 `System.currentTimeMillis() % 10000` 格式化成 `%04d`），相机接受回 `KEY=1` 或 `Status=1,Pin=<码>`，拒绝回 `KEY=0`——此时官方 App **自己换一个新码重发**（`BLEConnectUtils.java:692-700`）。~~全程不需要用户输入~~ **（2026-09-22 三次修订：这半句是错的，而且正是本机「每次连都要在相机上点一下确认」的根因。）** `DeviceAddSetKeyFragment` 就是 R003 这条分支的界面：它把手机生成的 4 位码显示出来，配的文案是 `match_code = "请在设备上核对验证码"`（`res-strings-zh.md:1312`），只有相机答了才由 `onKeySetted()` 关掉（`DeviceAddSetKeyFragment.java:64-85`）——**官方 App 第一次配对同样要在相机屏幕上确认**。它之所以看起来不用确认，是因为第二次起根本不再发 `R003_`：`onServicesDiscovered` 里 `getDevicePin(name)` 有值 → `isFoundInLocal()` → 直接 `startConnect()` 写 `R001_<存下的码>`（`BLEConnectUtils.java:859-878`、`:184`），相机认得就直接回 `SSID/PWD`。存的是相机 `Status=1,Pin=<码>` 里回显的那个码（`saveDeviceWithPin`，`:648-649`）；本机真机日志里它与我们写的码一致（21:48:33 `R003_8310` → `Status=1,Pin=8310`，随后 `R001_8310` 立刻拿到凭据），所以「相机只回自己的随机码、从不回显我们写的码」这条旧推断也一并作废。**本仓库 `XtuBleHandshake.resumeWithStoredKey` 就是这条免确认快速通道**，`R001_` 连发 4 次无回应（`RESUME_PROBE_SENDS`）或被告知 `Status=0` 时自动回落到 `R003_` 重新配对。最多换码 3 次后才提示用户。**（2026-09-22 真机修订：3 次不够。** 同一份日志里第一次握手连回 4 次 `Status=0,Pin=<每次不同的随机码>` 就判失败，隔 5 秒重来则第 3 次回 `Status=1` 并立刻给出 `SSID/PWD`——相机的配对状态机是在这个窗口里慢慢落定的，与「码被拒绝所以换一个」不是一回事。`XtuBleHandshake.MAX_ROTATIONS` 因此提到 12，让结束握手的是 `wakeAndFetch` 的整体超时，而不是换码次数。另注：日志里相机每次回的都是它自己的随机 `Pin`，从未见它回显我们写的码，所以「Status=0 表示码不对」这条推断本身还没被真机证实；`BLE write` 现已入日志，下一次现场日志可以直接对出来。)注意 JADX 把常量还原成了别库的字面量：`Status`/`WiFi_Status` 比的是 `"1"`（`IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE`），`KEY=0` 分支比的是 `"0"`（`SessionDescription.SUPPORTED_SDP_VERSION`）。
3. 相机**关机状态下 BLE 是否供电**（决定能不能真的"隔空唤醒"，还是只能唤醒"待机"）。
4. 你日常用的代理是哪个 App、是否"全局模式"（决定 §4.3 的 A 方案够不够，还是必须上 C/D）。
5. 能否接受 specifier 的产品代价：**App 退到后台或进程被杀，相机连接就断**（这是 Android 设计，不是 bug）；若不可接受，唯一出路是 suggestion（会挤掉系统默认网络、并被 VPN 抢流量）或 D 方案。

---

## 参考来源

- Android 官方：[Wi-Fi 网络建议 (Suggestion)](https://developer.android.com/guide/topics/connectivity/wifi-suggest)、[Wi-Fi bootstrap / Network Request (Specifier)](https://developer.android.com/guide/topics/connectivity/wifi-bootstrap)、[VPN / VpnService](https://developer.android.com/develop/connectivity/vpn)、[本地网络权限 ACCESS_LOCAL_NETWORK](https://developer.android.com/privacy-and-security/local-network-permission)
- Apple 官方：[NEHotspotConfiguration](https://developer.apple.com/documentation/networkextension/nehotspotconfiguration)
- Insta360 官方：[使用代理方式连接相机](https://www.insta360.com/cn/support/supportcourse?post_id=20465)、[GO 系列无法连接 App 排查](https://onlinemanual.insta360.com/go3s/zh-cn/troubleshooting/connect/insta360app)
- GoPro 官方：[Quik 配对相机](https://community.gopro.com/s/article/GoPro-Quik-How-To-Pair-Your-Camera?language=en_US)、[重置相机 WiFi 与连接](https://community.gopro.com/s/article/How-To-Reset-Camera-Wi-Fi-Connections-And-Camera-Name?language=en_US)（本次页面为 JS 壳，未取到正文，结论仅按产品行为描述）
- IoT BLE 配网范式：[讯飞 蓝牙 BLE 配网](https://doc.iflyos.cn/device/network/ble.html)、[巴法 蓝牙配网](https://cloud.bemfa.com/docs/src/wifi/ble.html)、[ESP-IDF Wi-Fi 配网](https://docs.espressif.com/projects/esp-idf/zh_CN/stable/esp32c5/api-reference/provisioning/wifi_provisioning.html)、[WiFi 设备配网流程总概述 / BLE 配网](https://blog.csdn.net/qq_45707027/article/details/145495550)
- 一手代码证据：`_work/xtu_src`、`_work/tuwin_src`、`_work/idgo_live_src`（行号见正文）；`NetworkCapabilities` 常量真值取自 `E:/Android/Sdk/platforms/android-35/android.jar`（`javap -constants`）
