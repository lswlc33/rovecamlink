# TUWIN 官方 APK 逆向档案 · 附录 B — 传输 / OTA / 联网

> 证据基线：`_work/tuwin_src/sources/com/tuwinsmart/**`（jadx 反编译，APK 版本见 `_work/re/tuwin/manifest.md`）。
> 表格来源：`_work/re/tuwin/api/*.md`、`catalog-consts.md`、`catalog-ports.md`、`catalog-http.md`、`catalog-templates.md`、`manifest.md`、`natives.md`、`natives-jni.md`、`signals-*.tsv`。
> 引用格式：`_work/tuwin_src/sources/com/tuwinsmart/…/<类名>.java:<行号>`。核不上行号的只给文件路径。

## 本附录覆盖范围

1. WiFi 直连与路由绑定（`core/network` 的 `WifiNetworkSpecifier` / `NetworkRequest` / 路由租约 / socket 绑定）
2. 文件下载与断点续传（`?offset=`、并发、缓冲、`getfilelist`/`getmediainfo` 字段）
3. 相机固件 OTA（`DeviceOtaOperations`、14 态状态机、上传分块、本地固件校验）与 App 自更新（分开说明）
4. 预览与播放（RTSP 播放器初始化参数逐项、`RtspTransport` 选择、Surface 生命周期、失败重试）
5. 事件与状态推送（`core/event`、`core/process` 消息类型、Flow 共享策略、断线恢复）
6. 遥测与三方 SDK（友盟 / ucrash / Glide / DataStore / WifiUtils 初始化参数与 AppKey）+ 全量域名逐条判定
7. 原生库（9 个 `.so` 用途 + `Java_*` 符号到 `external fun` 的映射）
8. 对既有文档 `docs/03` §1.3/1.4/1.6、`docs/04`、`docs/05` 的纠正

## 本附录未覆盖（由其它附录负责）

- 机型识别 / 型号矩阵 / 能力协商 → 附录 A（机型与设置）
- HTTP 端点逐条语义与命令参数 → 附录 A（HTTP 端点）
- 设置项键值与 UI 操作流程 → 附录 A（设置与 UI）
- 我们自研侧的实现进度与差距矩阵 → `docs/02`、附录「我们已实现的命令面」
- 蓝牙发现 / SPP / BLE 配网细节 → `docs/07`

---

## 1. WiFi 直连与路由绑定

### 1.1 `DeviceWifiNetworkRequestFactory`：`WifiNetworkSpecifier` 的构造

`object` 单例（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:22` `public static final DeviceWifiNetworkRequestFactory INSTANCE`），私有构造 `:51`。全部逻辑在 `build(DeviceWifiConnectRequest)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:54`）：

前置校验（`:57-59`）：`request.passphrase` 必须非空白，否则 `IllegalArgumentException("Device Wi-Fi passphrase is required")`。**没有开放网络（无密码）分支**。

两条 SSID 路径（`:61-78`）：

| 条件 | 设置内容 | 行号 |
|---|---|---|
| `request.isExact() == true` | `builder.setSsid(trimmedExpectedSsid)` + `builder.setBssid(MacAddress)` | `:64-75` |
| `request.isExact() == false` | `builder.setSsidPattern(ssidPattern(deviceType))`，**不填 BSSID** | `:77` |

- **exact 模式一定用 BSSID**：`expectedBssid` 解析失败为 null 时直接 `IllegalArgumentException("Exact device Wi-Fi BSSID is required")`（`:70-73`），即 exact 模式是 SSID+BSSID 双锁定，防止同 SSID 伪造 AP。
- exact 模式的 SSID 也是可选的：若 `expectedSsid` trim 后为空 → `IllegalArgumentException("Exact device Wi-Fi SSID is required")`（`:67-69`）。也就是说 exact 模式下两者都必填。
- 密码只走 WPA2：`builder.setWpa2Passphrase(request.getPassphrase())`（`:79`），无 `setWepKeys` / 无 open 变体。

**SSID 匹配模式（`PatternMatcher`，type=3 = `PATTERN_ADVANCED_GLOB`）** — `ssidPattern(DeviceType)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:87-104`），逐条原样抄：

| DeviceType | 正则（原样） | 行号 |
|---|---|---|
| `RIDE5` | `TUWIN_[A-Za-z0-9]{6,}` | `:91-92` |
| `RIDE3PRO` | `TUWIN_R3P_[A-Za-z0-9]+` | `:93-94` |
| `RIDE6` | `TUWIN_R6_[A-Za-z0-9]+` | `:95-96` |
| `M3` | `TUWIN[-_]M3_[A-Za-z0-9]+` | `:97-101` |
| 其它 | `throw new NoWhenBranchMatchedException()` | `:98-99` |

注意 RIDE5 的 `TUWIN_` 前缀是**最宽**的（只要求 6 位以上字母数字），会同时吃掉 `TUWIN_R3P_xxx` / `TUWIN_R6_xxx`；RIDE3Pro/RIDE6/M3 才各自收窄。M3 的模式允许 `TUWIN-M3_` 与 `TUWIN_M3_` 两种分隔符。

`parseBssid(String raw)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:106-128`）：`trim()` → `replace('-', ':')` → 空白判空 → `MacAddress.fromString()`，包在 `runCatching` 里（`:119-127`），任何异常返回 null。即**接受 `AA-BB-CC-DD-EE-FF` 与 `AA:BB:CC:DD:EE:FF` 两种分隔**。

### 1.2 `NetworkRequest` 的能力位增删

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkRequestFactory.java:82` 原样：

```java
new NetworkRequest.Builder()
    .addTransportType(1)      // NetworkCapabilities.TRANSPORT_WIFI
    .removeCapability(12)     // NetworkCapabilities.NET_CAPABILITY_PORTAL
    .setNetworkSpecifier(wifiNetworkSpecifier)
    .build();
```

只 **加 transport**、只 **删 capability**；没有 `addCapability`、没有 `setUnderlyingNetworks`、没有 `addLanTransportType`。删掉 `NET_CAPABILITY_PORTAL(12)` 的含义是：要求的网络**不能处于 captive-portal 状态**，Android 只对通过探测的网络清掉 PORTAL 位，因此这相当于把「Portal 未通过」的 AP 排除在自动连接之外。

对照 `NetworkTopologyMonitor.start()` 的监听请求（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkTopologyMonitor.java:130`）：

```java
new NetworkRequest.Builder().addTransportType(1).addTransportType(0).build()  // WIFI + CELLULAR
```

这是 `registerNetworkCallback`（被动监听），不是 `requestNetwork`（不产生网络）。

其它能力位判定：`connectivityManager.hasTransport(1)` = WIFI（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:168`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkTopologyMonitor.java:138`、`:207`）。

### 1.3 `DeviceNetworkController`：调用顺序与时机

构造（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:122-150`）：`(context, enabled, replacementTeardownTimeoutMs, replacementTeardownPollMs)`；`NetworkRuntime` 用 `(appContext, true, 0L, 0L, flags=12, null)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:133`），合成构造（`:152-154`）把两个 long 换成默认值。常量（`:61-64`）：

| 常量 | 值 | 行号 |
|---|---|---|
| `DEFAULT_REPLACEMENT_TEARDOWN_TIMEOUT_MS` | `3000` | `:62` |
| `DEFAULT_REPLACEMENT_TEARDOWN_POLL_MS` | `50` | `:61` |
| `REDACTED_BSSID` | `"02:00:00:00:00:00"` | `:63` |
| `UNKNOWN_SSID` | `"<unknown ssid>"` | `:64` |

`request(DeviceWifiConnectRequest): DeviceWifiCandidate`（挂起，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:247`）严格顺序：

1. `enabled == false` → `DeviceWifiRequestException(DISABLED)`（`:269-271`）
2. `Build.VERSION.SDK_INT < 29` → `DeviceWifiRequestException(UNSUPPORTED_ANDROID_VERSION)`（`:272-274`）——`WifiNetworkSpecifier` 需要 Android 10
3. `DeviceWifiNetworkRequestFactory.INSTANCE.build(request)`；`IllegalArgumentException` 被翻译成 `DeviceWifiRequestException(INVALID_REQUEST, e)`（`:276`、`:288-290`）
4. `requestMutex.lock()`（`MutexKt.Mutex$default(false,1,null)` 非公平锁，`:146`、`:282`）——**同一时刻只允许一个直连请求**
5. `releaseLiveLeasesBeforeReplacement()`（`:330`）
6. `requestCandidate(networkRequest)`（`:337`）
7. 无论成功/异常路径都 `requestMutex.unlock(null)`（`:322`、`:343`、`:346-347`）

第 5 步细节（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:391-488`）：
- 先 `liveLeases.toList()` 快照，非空时打日志 `"Device Wi-Fi request is replacing " + N + " live lease(s)"` 并逐个 `close()`（`:414-422`）
- 再取 `retiringNetworks` 快照；为空直接返回（`:423-428`）
- `replacementTeardownTimeoutMs <= 0` 时**不等待**，只单次检查（`:430-443`）
- 否则 `withTimeoutOrNull(3000ms) { do { 全部网络都 getNetworkCapabilities()!=null ? 返回 true : delay(max(pollMs,1)) } }`（`:445-456` + 轮询体 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/C2051x8dc3a708.java:57-69`，`delay` 值 = `RangesKt.coerceAtLeast(replacementTeardownPollMs, 1L)` = **50ms**）
- 超时/未完成：日志 `"Timed out waiting 3000ms for replaced device Wi-Fi to disconnect"` + 抛 `DeviceWifiRequestException(UNAVAILABLE)`（`:463-464`、`:486-487`）
- 成功：`retiringNetworks.removeAll(toSet(networks))`（`:459`）

第 6 步 `requestCandidate`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:630-838`）用 `suspendCancellableCoroutine`：
- **SDK>=31 用 `ConnectivityManager.NetworkCallback(1)`（即 `FLAG_AVAILABILITY_CALLBACKS_CARDED`，保证 onAvailable/onLost 成对投递）**，`<31` 用无参构造（`:651-709`）。两个回调都只覆写 `onAvailable / onCapabilitiesChanged / onUnavailable / onLost` 四个。
- `onAvailable`：先 `updateWifiIdentity()` 抓 SSID/BSSID，然后 CAS 只放行第一次，构造 `DeviceWifiNetworkLease`、`registerLease()`，若已取消则 `lease.close()`，否则 `resume(DeviceWifiCandidate(lease, lease.termination))`（`:558-571`）
- `onCapabilitiesChanged` → `requestCandidate$lambda$20$updateWifiIdentity`：从 `NetworkCapabilities.getTransportInfo()` 里取 `WifiInfo`，写 `ssidRef`/`bssidRef`（规范化后非空才覆盖）（`:540-555`）
- `onUnavailable` → CAS + 反注册回调 + `resume` 失败 `DeviceWifiRequestException(UNAVAILABLE)`（`:574-580`）
- `invokeOnCancellation`：置 CAS 标志、关闭已建立的 lease，否则反注册（`:711-738`）
- `connectivityManager.requestNetwork(req, cb)` 抛 `SecurityException` → `PERMISSION_DENIED`（`:802-808`）；抛 `RuntimeException` → `INVALID_REQUEST`（`:809-816`）
- 反注册统一走 `requestCandidate$lambda$20$unregisterPendingCallback`，用 `runCatching` 吞异常（`:508-537`）

`DeviceWifiNetworkLease`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiNetworkLease.java:22-75`）：持有 `network` + 两个 `AtomicReference<String>`（ssid/bssid）+ `CompletableDeferred<Unit> unavailableSignal`（`:44`）；`close()` 用 CAS，先 `unavailableSignal.complete(Unit)`，再 `releaseCallback()`，再 `onClosed(this)`（`:68-74`）。`termination` 就是调用方 `await()` 该 Deferred 来感知网络消失。

归一化函数（`DeviceNetworkController$Companion`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:610-624`）：
- `normalizeSsid`：`removePrefix("\"")` → `removeSuffix("\"")` → 空白或等于 `<unknown ssid>` 返回 null
- `normalizeBssid`：空白或 `equals("02:00:00:00:00:00", ignoreCase=true)` 返回 null

`bssidFor(Network)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:160-237`）四级回退：① 活跃 lease 记录的 bssid；② SDK>=29 时 `NetworkCapabilities.getTransportInfo() as WifiInfo` 的 `getBSSID()`；③ `WifiManager.connectionInfo.ipAddress` 拆成 `a.b.c.d` 与该 Network 的 `LinkProperties.linkAddresses` 逐地址比对，命中才取 `connectionInfo.getBSSID()`；④ null。整体 catch `SecurityException` → null。

会话侧 API：`adopt(sessionId, lease): Boolean`（`:351-365`，要求 lease 活跃且仍在 `liveLeases` 中；同 sessionId 覆盖时 `close()` 旧 lease）、`releaseSession(sessionId)`（`:367-373`）、`clear()`（`:375-384`）。

上层调用时机（`DeviceWifiConnectionCoordinator.java`，`connect-hUnOzRk`）：
1. 生成 `sessionId = deviceType.name().lowercase(ROOT) + "-connect-" + UUID.randomUUID()`（约 `:186-190` 区段）
2. `deviceSessionManager.closeAll(DEVICE_WIFI_REPLACEMENT_REASON)`，常量 `DEVICE_WIFI_REPLACEMENT_REASON = "device Wi-Fi request replacement"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiConnectionCoordinator.java:39`）
3. `deviceNetworkController.request(...)` 拿 `DeviceWifiCandidate`
4. `probeWhileCandidateAvailable(candidate)` 在 lease 存活期间做协议探测（`:436-466`，内部 `coroutineScope{}`）
5. 探测成功后回填 `ConnectedDevice.ssid / apBssid / pwd / sessionId`（`:391-405`）
6. 非 RIDE5 且 `boardversion` 空白 → `close(sessionId, "RIDE5 attributes are incomplete")` + `lease.close()` + 失败 `IllegalStateException("Device attributes are incomplete")`（`:407` 前后，逻辑见 `:289-300`）
7. `deviceNetworkController.adopt(sessionId, lease)` 成功返回设备；失败 `lease.close()` + `DeviceWifiRequestException(UNAVAILABLE)`（`:409-415`）
8. 任何 `CancellationException` / `Throwable` 路径都会 `lease.close()`（`:253-262`、`:416-421`）

配套扫描器 `DeviceWifiScanner`：`DEFAULT_SCAN_TIMEOUT_MS = 8000`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiScanner.java:42`），`withTimeoutOrNull` 等扫描结果（`:120`），`wifiManager.startScan()`（`:280`）与 `getScanResults()`（`:200`）都包 `runCatching`。

### 1.4 `ProcessBindingController`：进程级绑定

`ProcessBindingController.java`，构造 `(ConnectivityManager, clockMillis: () -> Long = System::currentTimeMillis)`（`:49-65`）。

`acquire(owner: BindingOwner, network: Network): ProcessBindingLease`（`:67-99`）判定顺序：
1. `leases[owner.id]` 已存在且 `(network, owner)` 都相同 → **幂等返回旧 lease**（`:71-75`）
2. 已存在但不同 → `ProcessBindingConflictException("Binding owner already exists: " + owner.id)`（`:76`）
3. 已有任何 lease 绑到**别的** Network → `ProcessBindingConflictException("Process is already bound by " + otherOwner.id + " to another Network")`（`:78-91`）——即全进程同时只允许一个 Network 被 bind
4. 只有 `boundNetwork != network` 时才真正 `connectivityManager.bindProcessToNetwork(network)`（`:92-95`）
5. `new ProcessBindingLease(owner, network, clockMillis(), onRelease = ::release)` 放入 `leases`（`:96-98`）

`release(lease)`（`:122-132`）：仅当登记的实例就是该 lease 才移除；**leases 空且 boundNetwork!=null 时 `bindProcessToNetwork(null)` 解绑**。`releaseOwner(ownerId)`（`:134-140`）→ `lease.close()`。`currentNetwork()`（`:149-151`）返回当前 `boundNetwork`。

`invalidate(route: RouteSnapshot)`（`:153-172`）关闭满足以下**三条同时成立**的 lease：
- `owner.routeRevision <= route.revision`
- `ownerBelongsTo(owner, route)`（`:181-194`）：`route.plane == INTERNET` ⇔ `owner.type == INTERNET_PROCESS`；`route.plane == DEVICE` → 排除 `INTERNET_PROCESS`（即 `TEMPORARY_PROBE / VERIFIED_DEVICE_SESSION / MEDIA_SESSION / CALLBACK_SESSION` 全算设备面）
- `route.networkHandle < 0`（通配）**或** `networkHandleOf(lease.network) == route.networkHandle`

`clear()`（`:174-179`）关掉所有活跃 lease。

`ProcessBindingType` 全集（`ProcessBindingType.java`）：`TEMPORARY_PROBE`、`VERIFIED_DEVICE_SESSION`、`MEDIA_SESSION`、`CALLBACK_SESSION`、`INTERNET_PROCESS`。
`BindingOwner(id: String, type: ProcessBindingType, sessionId: String, routeRevision: Long)`（`BindingOwner.java`）。
`ProcessBindingLease(owner, network, acquiredAtMillis, onRelease)` + `released: AtomicBoolean`，`close()` CAS 后回调 `onRelease`（`ProcessBindingLease.java`）。

**与 `RoutedOkHttpProvider` 的分工**：`bindProcessToNetwork` 是「整个进程的默认网络切换」，粗粒度、会互相冲突；`RoutedOkHttpProvider` 是「按 socket 绑定」，两者在 `NetworkRuntime` 里同时存在（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:147` 建 `ProcessBindingController`，`:141` 建 `RoutedOkHttpProvider`），会话连接器（`M3SessionConnector` / `Ride3ProSessionConnector` / `Ride5SessionConnector`）拿 `processBindingController` 作为构造参数（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:329`、`:331`、`:332`、`:333`）。

### 1.5 `NetworkTopologyMonitor`：注册的回调

`NetworkTopologyMonitor.java`。字段（`:37-46`）：`MutableStateFlow<TopologyChange> _changes`、`MutableStateFlow<Map<Long, ObservedNetwork>> _networks`、`ConnectivityManager`、`CopyOnWriteArraySet<Listener> listeners`、`LinkedHashMap<Long, ObservedNetwork> observations`（key = networkHandle）、`AtomicLong sequence`（初值 0，`:60`）、`boolean registered`。对外暴露 `asStateFlow` 的 `networks` / `changes`（`:67-68`）。

`start()`（`:126-145`）：
- `if (registered) return`（幂等）
- `registerNetworkCallback(addTransportType(1=WIFI).addTransportType(0=CELLULAR).build(), networkCallback)`（`:130`）
- `registered = true`，随后遍历 `getAllNetworks()`，对 `hasTransport(1) || hasTransport(0)` 的每一个主动 `publish(AVAILABLE, network, capabilities, linkProperties)` 补一次初始状态（`:132-144`）

注册的 `NetworkCallback`（`:69-101`）覆写 4 个：

| 回调 | 动作 | 行号 |
|---|---|---|
| `onAvailable` | `publish(AVAILABLE, network, null caps, null link)` | `:71-74` |
| `onCapabilitiesChanged` | `publish(CAPABILITIES_CHANGED, network, caps, null link)` | `:77-81` |
| `onLinkPropertiesChanged` | `publish(LINK_PROPERTIES_CHANGED, network, null caps, link)` | `:84-88` |
| `onLost` | `synchronized`：取旧观测（没有就造一个 `available=false` 的），`copy(available=false, sequence=++seq)` 写回，`publishSnapshot()`，`publishChange(LOST)` | `:91-100` |

`publish(...)`（`:230-258`）在 caps/link 为 null 时回退查 `connectivityManager.getNetworkCapabilities/getLinkProperties`，再回退到旧观测的值；`observe()`（`:269-279`）每次 `sequence.incrementAndGet()`。
`publishChange`（`:261-267`）先 `_changes.setValue(change)`，再逐个调 `Listener.onTopologyChanged(change)` —— **StateFlow 与命令式监听双通道**。
`stop()`（`:147-162`）：`runCatching { unregisterNetworkCallback }` → `registered=false` → `observations.clear()` → `publishSnapshot()`。
`currentWifiNetwork()`（`:168-198`）：在 `available && isWifi` 的观测里挑 `sequence` 最大的。
`ensureObserved(network)`（`:200-220`）：caps 非空且 (WIFI|CELLULAR) 才 `publish(AVAILABLE,...)` 并返回匹配观测，否则 null。
`TopologyChangeKind`（`TopologyChangeKind.java`）：`AVAILABLE`、`CAPABILITIES_CHANGED`、`LINK_PROPERTIES_CHANGED`、`LOST`。
`TopologyChange(kind, current, previous)`（`TopologyChange.java`）。
`networkHandleCompat(network)`（`NetworkTopologyMonitorKt.java`）：`Network.getNetworkHandle()`，异常时退化为 `System.identityHashCode(network)`；`networkHandleOf` 是它的转发别名。

`NetworkRuntime` 的订阅（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:372-377` 注册 → `:501-518` 处理）：

```kotlin
if (change.kind == LOST || !change.current.available ||
    (change.kind == CAPABILITIES_CHANGED && !change.current.isWifi())) {
    deviceRoutes.invalidateNetwork(
        handle, state = if (change.kind == LOST) RouteState.LOST else RouteState.UNAVAILABLE,
        networkLost = change.kind == LOST)
}
internetRoutes.onTopologyChanged(change)
publishInternetRoute(previousInternetRoute, internetRoutes.route.value)
```

`NetworkRuntime.start()`（`:533-539`）只做 `topology.start()`。

### 1.6 `RouteProvider / RouteSnapshot / RouteLease / RouteId` 语义与 `routeRevision` 失效重建

**类型语义**

| 类型 | 定义 | 语义 |
|---|---|---|
| `NetworkPlane` | `INTERNET` / `DEVICE`（`NetworkPlane.java`） | 网络平面：外网 vs 相机直连 |
| `RouteState` | `UNAVAILABLE, CANDIDATE, PROBING, VERIFIED, READY, LOST, REJECTED`（`RouteState.java`） | 路由生命周期状态 |
| `RouteId(value: String)` | `RouteId.java` | 字符串标识，由 `RouteRevisionManager` 生成 |
| `RouteSnapshot(routeId, networkHandle, revision, plane, state)` | `RouteSnapshot.java` | 某一刻的路由不可变快照，`revision` 是代次号 |
| `RouteLease(route, network, intent, profile, endpointGrantId, onClosed)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteLease.java:30-54` | 一次「持有路由」的凭证，可 `Closeable` |
| `RouteProvider.acquire(intent, profile, endpointGrantId=null): RouteLease` | `RouteProvider.java` | 唯一入口接口 |
| `RoutePermission` | `PROBE_ONLY` / `DEVICE_OPERATION`（`RoutePermission.java`） | 探测许可等级 |

`RouteId` 生成规则（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteRevisionManager.java:170-172`）：`plane.name().lowercase(Locale.ROOT) + "-" + networkHandle + "-" + generation`，例如 `device-12345@0x...-3`、`internet-42-1`。`unavailable(plane)` 造的是 `plane.lowercase + "-unavailable"`（`:238-240`）。

**`revision` 何时递增（= 失效点）** — `RouteRevisionManager.java`，全局 `nextRevision` 单调 `++`（`:247-251`），表按 `Key(networkHandle, plane)` 分桶：
- `upsert(handle, plane, available, state)`（`:162-184`）：该 key 首次出现或 `!present` → `generation+1`、新 `RouteId`、`revision = nextRevision()`；已存在且 **`available` 或 `state` 变了** → `revision = nextRevision()`；两者都没变 → **revision 不变**（稳定复用）
- `markLost(handle, plane)`（`:186-199`）：`present=false`、`available=false`、`revision++`、`state=LOST`
- `invalidate(handle, plane, state)`（`:208-219`）：`available=false`、`revision++`、`state=state`（默认 `UNAVAILABLE`，`:201-206`）
- `unavailable(plane)`（`:221-241`）：把该 plane 里所有 `present||available` 的条目全部 `present=false, available=false, revision++, state=UNAVAILABLE`，返回 `RouteSnapshot(RouteId("<plane>-unavailable"), -1L, this.nextRevision, plane, UNAVAILABLE)`
- `clear()`（`:243-245`）：清空 entries（**注意：不重置 `nextRevision`**）

**DEVICE 面的状态推进**（`DeviceRouteRegistry.java`）：
`markCandidate(sessionId, handle)` → `upsert(DEVICE, available=true, CANDIDATE)`（`:75-84`）→ `markProbing` → `PROBING`（`:86-95`）→ `verify(sessionId, handle, DeviceIdentity)` → `upsert(..., VERIFIED)`（`:97-116`）。`reject(sessionId, state=REJECTED)`（`:125-144`）、`closeSession(sessionId)` → `invalidate(..., LOST)`（`:150-185`）、`invalidateNetwork(handle, state, networkLost)` → 命中该 handle 的所有 session 逐个 `markLost`（`networkLost=true`）或 `invalidate`（`:267-308`）。
**`RouteState.READY` 只用于 INTERNET 面**：唯一写入点是 `InternetRouteController.refresh()` 的 `upsert(handle, INTERNET, true, READY)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/InternetRouteController.java:127`）；设备面代码里出现的 `READY` 只是 `setOf(VERIFIED, READY)` 这种**防御性兼容判定**（例如 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3SessionReadiness.java:40`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java:1745-1747`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:682`）。

`InternetRouteController.refresh()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/InternetRouteController.java:83-127`）选路条件：`available` ∧ (`isWifi() || isCellular()`) ∧ `hasInternet && validated` ∧ `!isDeviceNetwork(observed)`（后者由 `NetworkRuntime` 注入为 `deviceRoutes.isReservedNetwork(handle)`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:185-195`）；排序 `compareByDescending(isCellular)` 再 `thenBy(networkHandle)`（`:104-118`），即**优先蜂窝、其次 handle 小的**。若当前 route 的 handle 与选出的不同 → 先 `invalidate` 旧 handle 再 upsert。

**`acquire` 的门禁（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/SnapshotRouteProvider.java:136-187`）** —— 逐条：
1. `intent` 是 `NetworkIntent.Internet` → `internetRouteProvider()`；是 `NetworkIntent.Device` → `deviceRouteProvider(sessionId)`，null 则 `RouteUnavailableException("No device route for session " + sessionId)`（`:141-153`）
2. 状态门禁（`:156-166`）：
   - INTERNET：`plane == INTERNET && state == READY`
   - DEVICE + `profile != DEVICE_PROBE`：`plane == DEVICE && state ∈ {VERIFIED, READY}`
   - DEVICE + `profile == DEVICE_PROBE`：`plane == DEVICE && state ∈ {CANDIDATE, PROBING, VERIFIED, READY}`
3. DEVICE 且 `profile != DEVICE_PROBE` 且 `endpointGrantId` 空白 → `EndpointGrantRequiredException("Device operation requires EndpointGrant: session=...")`（`:167-170`）——**除探测外，任何设备操作都必须先拿到 EndpointGrant**
4. 门禁不过 或 `networkHandle < 0` → `RouteUnavailableException("Route is not ready for <IntentSimpleName>: <routeId>@<revision>")`（`:171-173`）
5. `endpointGrantValidator(sessionId, grantId, revision, purpose)` 返回 false → `EndpointGrantRequiredException("EndpointGrant is not valid for <purpose> session <id>@<revision>")`（`:174-179`）——**grant 是按 revision 绑定的，路由换代后 grant 自动失效**
6. `networkProvider(networkHandle)` 为 null → `RouteUnavailableException("Android Network is unavailable for <routeId>@<revision>")`（`:180-183`）；该 provider 在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:223-239` 实现为 `topology.observation(handle)?.network`
7. `new RouteLease(...)` + `leaseRegistry.register(lease)`（`:184-185`）

`profile → EndpointPurpose` 映射（`SnapshotRouteProvider.endpointPurpose`，`:198-237`）：`DEVICE_PROBE→PROBE`、`DEVICE_FILE→FILE`、`DEVICE_IMAGE→IMAGE`、`DEVICE_MENU→MENU`、`DEVICE_DIAGNOSTIC→DIAGNOSTIC`、`DEVICE_UPLOAD→OTA`、`DEVICE_LONG_OPERATION→OTA`、`DEVICE_CONTROL→CONTROL`；未命中（即 INTERNET_* profile）回落到 `intent.operation`：`PROBE→PROBE, CONTROL→CONTROL, FILE→FILE, IMAGE→IMAGE, MEDIA→MEDIA, CALLBACK→CALLBACK, OTA→OTA, DIAGNOSTIC→DIAGNOSTIC`。
`HttpClientProfile` 全集 11 个（`HttpClientProfile.java`）：`INTERNET_API, INTERNET_DOWNLOAD, INTERNET_UPLOAD, DEVICE_PROBE, DEVICE_CONTROL, DEVICE_DIAGNOSTIC, DEVICE_LONG_OPERATION, DEVICE_FILE, DEVICE_MENU, DEVICE_UPLOAD, DEVICE_IMAGE`。
`DeviceOperationKind` 8 个（`DeviceOperationKind.java`）：`PROBE, CONTROL, FILE, IMAGE, MEDIA, CALLBACK, OTA, DIAGNOSTIC`。

**`RouteLease` 生命周期**（`RouteLease.java`）：内部 `cancellation = SupervisorJob()`（`:53`）、`closed = AtomicBoolean(false)`（`:52`）；`isActive() = !closed && cancellation.isActive()`（`:80-82`）；`requireActive()` 抛 `RouteSupersededException("Route lease is no longer active: <routeId>@<revision>")`（`:84-89`）；`invalidate(RouteSupersededException)` CAS 后 `cancellation.cancel(cause)` 并回调 `onClosed`（`:171-177`）；`close()` CAS 后 `cancellation.cancel()` + `onClosed`（`:180-185`）；`withCancellation(block)` 在 `coroutineScope{}` 里以 `CoroutineStart.UNDISPATCHED` 起一个 `routeWatcher` 协程，等待 lease 失效即抛（`:145-169`）。`onClosed` 在 `SnapshotRouteProvider$acquire$lease$1` 里就是 `leaseRegistry.unregister(lease)`。

**失效重建链路**（一次换代做了什么）：
`DeviceRouteRegistry` 的 `onRouteChanged` 回调（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:163-168`）依次调用
`leaseRegistry.invalidate(route)` → `clientRegistry.invalidate(route)` → `processBindingController.invalidate(route)`；
`SnapshotRouteProvider.invalidate(route)` 也转发到 `leaseRegistry.invalidate`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/SnapshotRouteProvider.java:189-192`）。
被 `invalidate` 的 lease 抛 `RouteSupersededException` 取消其 `SupervisorJob`，所有挂在 `withCancellation` 里的请求当场失败；`RouteScopedClientRegistry` 在 `registerLeaseKey` 时对 lease 的 `cancellation.invokeOnCompletion { close(lease) }`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:342-359`），于是 OkHttp client / Retrofit service / ConnectionPool 一起被回收。
`RouteScopedClientRegistry.invalidate(route)`（`:144-208`）的删除条件（三张表一致）：`key.plane == route.plane` ∧ (`route.networkHandle < 0` ∨ `key.networkHandle == route.networkHandle`) ∧ **`key.routeRevision <= route.revision`**。清理动作在名为 `TuwinRouteCleanup` 的单线程 daemon executor 上执行（`:559-574`）：`dispatcher().cancelAll()` → `executorService().shutdown()` → 私有 `ConnectionPool.evictAll()` → `cache()?.close()`（`:385-403`）。
重建：上层连接器捕获 `RouteSupersededException` 后用新 `sessionId`/新 `EndpointGrant` 重新 `acquire`（例如 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackChannel.java:403`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProSessionTransport.java:179`、`:375` 都显式比对 `route.revision != getRouteRevision()` 来决定重连）。

### 1.7 `RoutedOkHttpProvider` / `RoutedRetrofitProvider`：socket 如何绑到 Network

`RoutedOkHttpProvider.client(lease, profile = lease.profile, endpointGrantId = lease.endpointGrantId, configure = {}): OkHttpClient`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:68-110`），工厂 lambda 内部：
- `lease.requireActive()` 先跑（`:72`），工厂内还会被 registry 再跑两次（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:101`、`:104`、`:113`）
- 缓存键：`RouteClientKey(plane, networkHandle, routeRevision = route.revision, endpointGrantId, profile)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:102`）——**revision 进 key，所以换代必然新 client**
- `Network network = lease.getNetwork()`，null → `RouteUnavailableException("No Network object for <plane>@<handle>")`（`:83-84`、`:107`）
- **绑 socket 的两处**：`.socketFactory(network.getSocketFactory())`（`:97-100` 与 `:103-105` 各取一次，后者覆盖前者）
- **绑 DNS**：自定义 `Dns` 调 `network.getAllByName(hostname)`（`:87-95`），绕开系统默认网络解析
- 超时：`connectTimeout / readTimeout / writeTimeout`，单位 `TimeUnit.SECONDS`，值取自 `timeoutSeconds(profile)`（`:96`）
- `retryOnConnectionFailure(false)`（`:96`、`:105`）、`followRedirects(false)`、`followSslRedirects(false)`（`:100`、`:105`）
- `connectionPool(registry.getOrCreateConnectionPool(lease, profile))`（`:102`），池 key = `RouteConnectionPoolKey(plane, networkHandle, revision, profile)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:73`），值是 `new ConnectionPool()`（默认参数，未自定义 keepAlive/maxIdle）（`:78`）

**`timeoutSeconds(profile)` 全表**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:68-92`，`(connect, read, write)` 秒）：

| HttpClientProfile | connect | read | write | 行号 |
|---|---|---|---|---|
| `INTERNET_API` | 10 | 30 | 30 | `:70-71` |
| `INTERNET_DOWNLOAD` | 10 | 60 | 60 | `:72-73` |
| `INTERNET_UPLOAD` | 10 | 120 | 120 | `:74-75` |
| `DEVICE_PROBE` | 3 | 5 | 5 | `:76-77` |
| `DEVICE_CONTROL` | 5 | 15 | 15 | `:78-79` |
| `DEVICE_DIAGNOSTIC` | 5 | 5 | 5 | `:80-81` |
| `DEVICE_LONG_OPERATION` | 10 | 120 | 120 | `:82-84` |
| `DEVICE_UPLOAD` | 10 | 120 | 120 | `:82-84` |
| `DEVICE_FILE` | 5 | 30 | 30 | `:85-88` |
| `DEVICE_MENU` | 5 | 30 | 30 | `:85-88` |
| `DEVICE_IMAGE` | 5 | 30 | 30 | `:85-88` |

`RoutedRetrofitProvider.create(lease, baseUrl, serviceClass, profile = ?, endpointGrantId = ?, configureClient = {}, configureRetrofit = {})`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedRetrofitProvider.java:30-56`）：先 `okHttpProvider.client(...)`，再 `normalizeBaseUrl`（trim；空 → `IllegalArgumentException("Retrofit base URL cannot be empty")`；不以 `/` 结尾则补 `/`，`:58-64`），最后把 `Retrofit.Builder().baseUrl(...).client(...)` + `configureRetrofit` + `.build().create(serviceClass)` 塞进 service 缓存 `RouteServiceKey(clientKey, baseUrl, serviceClass.getName())`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:118-142`）。`close(lease)` 只是转发 `okHttpProvider.close`（`:25-28`）。

### 1.8 超时与重试数值汇总（联网层）

| 项 | 值 | 位置 |
|---|---|---|
| 直连替换旧 lease 的等待上限 | `3000 ms` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:62` |
| 直连替换轮询间隔 | `50 ms`（`coerceAtLeast(pollMs,1)`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:61` + `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/C2051x8dc3a708.java:69` |
| Wi-Fi 扫描等待 | `8000 ms` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiScanner.java:42` |
| Android 最低版本（WifiNetworkSpecifier） | `29` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:272` |
| 回调 carded flag 生效版本 | `31` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:651` |
| OkHttp `retryOnConnectionFailure` | `false`（所有 profile） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:96`、`:105` |
| OkHttp 重定向 | `followRedirects=false`、`followSslRedirects=false` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:100`、`:105` |
| 11 个 profile 的 connect/read/write | 见 1.7 表 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:68-92` |
| 连接释放线程名 | `TuwinRouteCleanup`（daemon，单线程） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:571` |

---

## 2. 文件下载与断点续传

存在**两套**下载实现，同时活着：
- **A. 新传输层**：`core/transfer/*`（`StreamingTransferEngine` + `TransferQueue` + `ResumePolicy`），走 EndpointGrant/RouteLease，支持 checkpoint 续传。
- **B. 旧 `DownloadUtil` 路径**：`core/util/download/DownloadFileExecution`，直接用 `OkHttpClient.newCall(...).enqueue(...)`，靠 `?offset=` 自己重试。
两者共用同一个版本门限策略 `Ride3ProPlaybackDownloadResumePolicy`。

### 2.1 URL 构造与 `?offset=` 语义

**设备 URL 的唯一出口**是 `DeviceUrlBuilder.buildAuthorizedHttpUrl(authority, grantId, sessionId, routeRevision, purpose, relativePath)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:183-215`）：
- `authority.grantFor(grantId)`，`grant.protocol != HTTP` → `IllegalArgumentException("Device HTTP URL requires an HTTP EndpointGrant")`（`:191-193`）
- `grant.allowedPorts` 必须**恰好一个端口**，否则 `IllegalArgumentException("Device HTTP EndpointGrant must contain one port")`（`:194-197`）
- host 含 `:` 且不以 `[` 开头 → 加方括号包成 IPv6 字面量（`:199-203`）
- relativePath trim 后为空 → `IllegalArgumentException("Device relative path is empty")`；含 `"://"` → `IllegalArgumentException("Device URL builder accepts relative paths only")`（`:204-213`）
- 最终：`authority.authorizeUrl(grantId, sessionId, routeRevision, purpose, "http://" + host + ":" + port + "/" + removePrefix(path,"/")).getUrl()`（`:214`）——**注意是 `http://`，全程明文，无 TLS**
- 若 grant 拿不到，各 `buildXxxUrl` 走 `unavailable(kind)`：打日志 `"DeviceUrlBuilder: <kind> skipped because EndpointGrant is unavailable"` 并返回**空串**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:252-255`）
- 遗留的 5 个 `buildM3DownloadUrl / buildM3ThumbnailUrl / buildRide5ThumbnailUrl / buildRide3ProThumbnailUrl / buildRide3ProRawDataUrl / buildRide5DownloadUrl`（`:61-93`）现在**全部直接返回 unavailable**，只有 `buildM3ThumbnailUrl` 例外——它返回本地 `M3ThumbnailCache` 文件绝对路径（`:66-75`）

**`?offset=` 的注入点**：`Ride3ProPlaybackDownloadResumePolicy.withOffset(url, offset)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java:233-239`）

```java
if (offset < 0) throw new IllegalArgumentException("resume offset must not be negative");
return HttpUrl.get(url).newBuilder()
        .setQueryParameter("offset", String.valueOf(offset))
        .build().getUrl();
```

`setQueryParameter` 是**替换**语义（同名参数只留一个），所以重试时 offset 一定被刷新为当前文件长度。
语义 = 「请从第 offset 字节开始给我剩下的内容」，**十进制无单位**，是设备私有 CGI 参数，不是标准 HTTP。

调用点：`DownloadFileExecution.executeAttempt`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:115-123`）——`if (resumeDecision.enabled) url = withOffset(sourceUrl, offset) else url = sourceUrl`，然后 `client.newCall(new Request.Builder().url(url).build())`（`:123`），**该 Request 不带任何 header**。

新传输层里 offset 策略被抽象为 `ResumePolicy`（`ResumePolicy.java`），4 个实现：

| 策略 | 载体 | 语义 |
|---|---|---|
| `Disabled` | — | 不续传，永远从头 |
| `HttpRange` | `Range: bytes=N-` | **仅允许 `AuthorizedTransferSource.Internet` 使用** |
| `DeviceOffset(headerName)` | 请求头，头名由参数给 | 设备侧 header 式续传 |
| `DeviceQueryOffset(parameterName)` | 查询参数，参数名由参数给 | 设备侧 query 式续传；实际用的名字是 **`"offset"`** |

`DeviceQueryOffset("offset")` 的唯一实例化点：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1370`（`startRoutedDeviceDownload` 内，条件 `z = (deviceType==RIDE3PRO || deviceType==RIDE6) && decision.enabled`，`:1365`）；不满足时是 `ResumePolicy.Disabled.INSTANCE`（`:1372`）。

`TransferRequest` 构造期校验（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/TransferRequest.java:133-179`）：
- 设备 intent 但 source 不是 Device → `IllegalArgumentException("Device transfer requires an explicit device offset policy")`（`:163-165`）
- `HttpRange` 且 source 不是 Internet → `"HTTP Range resume requires an internet source"`（`:172-174`）
- `DeviceOffset/DeviceQueryOffset` 且 source 不是 Device → `"Device offset resume requires a device source"`（`:169-171`）
- `ResumeFromCheckpoint` 但 `resumePolicy == Disabled` → `"Checkpoint retry requires an enabled resume policy"`（`:176-178`）
- intent 的 grantId 必须等于 source 的 grant id（`:140-142`），diagnostics 的 routeRevision 必须等于 grant 的 routeRevision（`:146-159`）

### 2.2 固件版本门限与版本号比较

全部在 `Ride3ProPlaybackDownloadResumePolicy.java`：

| 常量 | 值 | 行号 |
|---|---|---|
| `MINIMUM_FIRMWARE_VERSION` | `"v1.20260708.101448"` | `:24` |
| `MAX_RETRY_COUNT` | `5` | `:23` |
| `RAW_DATA_PATH` | `"/api/playback/rawdata"`（private） | `:25` |
| `versionPattern` | `^[vV]?(\d+)\.(\d{8})\.(\d+)$` | `:51` |

`evaluate(url, firmwareVersion): Decision(enabled, reason, firmwareVersion)`（`:203-225`），判定顺序：
1. `isRawDataUrl(url)`：`HttpUrl.parse(url).encodedPath() == "/api/playback/rawdata"`（`:227-231`）→ 否则 `Decision(false, NOT_RAW_DATA, fv)`
2. `firmwareVersion` trim 后为 null/空 → `Decision(false, VERSION_UNAVAILABLE, null)`
3. `parseVersion` 返回 null（不匹配正则，或任一段不能 `toLongOrNull`）→ `Decision(false, VERSION_INVALID, trimmed)`
4. `compareVersions(version, minimumVersion) >= 0` → `Decision(true, SUPPORTED, trimmed)`
5. 否则 → `Decision(false, LEGACY_FIRMWARE, trimmed)`

**版本号怎么比**（`:264-291`）：正则 3 个捕获组 → `List<Long> [major, yyyymmdd, build]`；`compareVersions` 用 `left.size()` 作循环上限、逐位 `Intrinsics.compare`，**第一位不同即决定大小，全等返回 0**。因为中间段固定 8 位日期、末段是 `HHmmss` 派生的整数，所以字典序 = 时间序，等价于「构建时间戳比较」。`minimumVersion` 在 static 初始化时对 `MINIMUM_FIRMWARE_VERSION` 解析，解析不出来直接 `throw IllegalArgumentException("Required value was null.")`（`:52-56`）。

`Reason` 枚举 5 值：`SUPPORTED, NOT_RAW_DATA, VERSION_UNAVAILABLE, VERSION_INVALID, LEGACY_FIRMWARE`（`:31-36`）。

固件版本从哪里取（两条路）：
- 旧路径：`DownloadUtil.resolveRide3ProFirmwareVersion(url)` → `DeviceUrlBuilder.getConnectedDeviceVersion(deviceType)`，从 `PreferenceHelper.getCacheDevices()` 里找第一个 `isConnected() && deviceType` 匹配的 `ConnectedDevice.getVersion()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1566-1575`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:230-250`）
- 新路径：`resolveRouteFirmwareVersion(networkRoute)` → `deviceSessionManager.snapshot(sessionId).identity.firmwareVersion`，包 `runCatching`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1578-1591`）
- `startRoutedDeviceDownload` 走的是后者（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1354-1363`）

日志（`logRide3ProResumeDecision`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1602-1610`），三条原样：
- `"Ride3Pro rawdata resume enabled firmware=" + fv + " max_retries=5"`
- `"Ride3Pro rawdata resume disabled reason=legacy_firmware firmware=" + fv + " minimum=v1.20260708.101448"`
- `"Ride3Pro rawdata resume disabled reason=" + reason.lowercase() + " firmware=" + fv`

### 2.3 是否禁用 HTTP `Range`：在哪禁、为什么

**结论：对相机侧下载完全不用 `Range` 头。** 三条硬证据：

1. **全仓库搜索 `Range` 头写入点**：`grep '"Range"'` 在 `com/tuwinsmart/**` 里**只有一个命中**，且是**日志脱敏白名单**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/DiagnosticHttpLogPolicy.java:134` 的日志保留头列表 `{"Content-Type","Content-Length","Content-Range","Range","Retry-After","X-Ride3Pro-Request-Id","Request-Id"}`）。真正会写 `Range` 的只有三方库：`com/lzy/okserver/download/DownloadTask.java:201`、`com/danikula/videocache/HttpUrlSource.java:220-223`、阿里云 OSS —— **TUWIN 自身代码没有任何调用路径进入这些库的下载器**。
2. **请求构造处**：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:123` 是 `new Request.Builder().url(strWithOffset).build()`，一个 header 都不加；`StreamingTransferEngine` 里唯一的另一处构造是上传（`:412`），也只有 `.method(str, progressRequestBody)`。
3. **策略层的显式禁止**：`TransferRequest` 校验里，**设备传输若使用 `ResumePolicy.HttpRange` 会直接抛异常**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/TransferRequest.java:163-165`，消息 `"Device transfer requires an explicit device offset policy"`）；反向地，`HttpRange` 只允许 `AuthorizedTransferSource.Internet`（`:172-174`）。也就是说**「Range 走外网、offset 查询参数走设备」是被类型系统锁死的**。

**为什么**：`acceptedResponseOffset(policy, requestedOffset, responseCode)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:804-817`）说明了设备侧不能信 Range 的原因——
- `HttpRange`：必须 `requestedOffset > 0 && responseCode == 206` 才承认续传成功，否则返回 0（当作从头开始，会把已写数据覆盖掉）
- `DeviceOffset` / `DeviceQueryOffset`：**直接 `return requestedOffset`，完全不看 responseCode**（`:807-808`）
即固件对 `?offset=` 的响应通常仍是 `200`（不是 `206`），若客户端按 Range 语义去校验状态码就会误判。同时 `DownloadFileExecution.writeResponseBody`（`:198-248`）用 `FileOutputStream(destination, append = offset > 0)` 落盘，`StreamingTransferEngine.copyResponse` 用 `RandomAccessFile` + `offset==0 ? setLength(0) : seek(offset)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:898-913`）——**由客户端自己负责截断/定位**，不依赖服务端 206 语义。

`Content-Range` 仍被读，但只用于估算总大小：`contentRangeTotal(headers, offset, contentLength)`（`:1016-1028`）取 `Content-Range` → `substringAfter('-')` → `substringBefore('/')` → `toLongOrNull`，若 `>= offset` 则返回 `该值 + 1`；否则回退 `offset + contentLength`；再不行返回 null。

### 2.4 并发度、缓冲区与队列

| 项 | 值 | 位置 |
|---|---|---|
| 读缓冲（旧路径） | `byte[8192]` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:216` |
| 读缓冲（新路径 `copyResponse`） | `byte[8192]` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:917` |
| 落盘方式（旧） | `FileOutputStream(dest, append = offset>0)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:210-213` |
| 落盘方式（新） | `RandomAccessFile(dest,"rw")`；`offset==0` → `setLength(0)`，否则 `seek(offset)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:882`、`:898-913` |
| 写盘调度 | `withContext(Dispatchers.IO)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:1011` |
| 每轮读后检查 | `ensureActive()`（协程取消即刻中断） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:919` |
| 下载 scope | `CoroutineScope(SupervisorJob() + Dispatchers.IO)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:130` |
| 传输 scope（NetworkRuntime） | `CoroutineScope(SupervisorJob() + Dispatchers.IO)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/NetworkRuntime.java:280` |
| 设备 HTTP 超时（旧常量） | `DEVICE_HTTP_TIMEOUT_SECONDS = 5` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:122` |
| `DEVICE_FILE` profile 超时 | connect 5s / read 30s / write 30s | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:85-88` |
| `INTERNET_DOWNLOAD` profile 超时 | connect 10s / read 60s / write 60s | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:72-73` |
| OkHttp 自动重试 | `retryOnConnectionFailure(false)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:96`、`:105` |
| 重定向 | `followRedirects(false)` + `followSslRedirects(false)`；下载 client 再 `newBuilder()` 显式关一次 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProvider.java:100`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:695` |
| 每个 lease 独立连接池 | `new ConnectionPool()`（OkHttp 默认 5 idle / 5 min keep-alive），key 含 revision | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RouteScopedClientRegistry.java:73-83` |

**并发度**：**同一 session 内串行**。
- `ScopedTransferQueue.submit(namespace, id, block)`（`ScopedTransferQueue.java`）以 `(namespace, TransferId)` 为 `QueueKey` 去重：`results.putIfAbsent` 已有就直接返回同一个 `CompletableDeferred`，即**同一任务重复 submit 得到同一结果**（不是并发跑两份）。Job 用 `CoroutineStart.LAZY` 启动。
- `DeviceTransferQueue.submit(request)` 的 namespace = `namespace(sessionId)`（`DeviceTransferQueue.java`），即**按设备会话分桶**；`InternetTransferQueue` 同理按外网命名空间。
- 真正的串行化由 `Ride3ProRequestScheduler` 完成：`PriorityQueue<Pending> queue` + `Channel<Unit> wakeup`（`Channel$default(-1, null, null, 6, null)` = **CONFLATED**，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProRequestScheduler.java:173`）+ 单个 `worker` Job + 单个 `activeJob` 字段 → **一次只跑一个请求**，按 `Ride3ProRequestPriority` 出队。
- `requiresIsolatedRide3ProConnection(request)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:766-778`）：`(RIDE3PRO || RIDE6) && grant.purpose == FILE && url.encodedPath == "/api/playback/rawdata"` 时要求独占连接。
- `MAX_REDIRECTS = 3`、`REDIRECT_CODES = {300,301,302,303,307,308}`（`StreamingTransferEngine.java` Companion，`catalog-ports.md:181`）标了 `@Deprecated`，因为 client 已彻底关掉重定向。

### 2.5 失败重试与截断判定

**旧路径 `DownloadFileExecution` 的重试环**（`DownloadFileExecution.java`）：
- 每个 task 一个 `taskId = DiagnosticLog.nextId("download")`（`:66`）
- `start()`：`initialOffset < 0` → `IllegalArgumentException("initial download offset must not be negative")`（`:75-76`）；有效起点 `j = resumeDecision.enabled ? initialOffset : 0`（`:78`）
- **截断/不一致判定 1**：`j > 0 && destinationFile.length() != j` → `IOException("Initial resume offset does not match file length: expected=<j> actual=<len>")`，直接终态，不重试（`:80-90`）
- **重置判定**：`resumeDecision.enabled && j == 0 && file.exists() && file.length() > 0` → 用 `FileOutputStream(f, false)` 打开再关闭来**清零文件**；失败 → `"Unable to reset destination file: " + e.getMessage()`（`:91-111`）
- `executeAttempt(completedRetries, offset)`（`:115-195`）失败分类：
  - `call.isCanceled()` → `publishPaused()`（`progress.status = 3`），**不重试**
  - `!response.isSuccessful()` → `handleAttemptFailure("Server returned error: <code>", IOException("HTTP <code>"))`
  - `response.body() == null` → `IOException("Empty response body")`
  - 写盘 `IOException` → `handleAttemptFailure("Error writing file: " + msg, e)`
  - `onFailure` → `handleAttemptFailure("Download failed: " + msg, e)`
- **截断/不一致判定 2**：`writeResponseBody` 开头 `offset > 0 && destinationFile.length() != offset` → `IOException("Resume offset changed before write: expected=<offset> actual=<len>")`（`:199-201`）
- `handleAttemptFailure`（`:251-268`）：`retryPlan = resumeDecision.enabled ? nextRetry(completedRetries, destinationFile.length()) : null`；`nextRetry` 在 `completedRetries >= 5` 时返回 **null**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java:248-250`）→ 终态。
  - 有 plan：日志 `download_retry_scheduled` 带 `retry / max_retries=5 / offset / error_type`，`publishWaitingForRetry(offset)`（`progress.status = 1`、`speed = 0`）后 **立即 `executeAttempt(retryCount, offset)` 递归**（无退避延时）
  - 无 plan：日志 `"Ride3Pro rawdata resume exhausted retries=<n> offset=<len>"` → `publishTerminalError`（`progress.status = 4`）+ `onError(message)`
- 进度里程碑：每 25% 记一次 `download_progress`（`(coerceIn(percent,0,100)/25)*25 >= 25 && > lastLoggedMilestone`，`:291`）
- 完成：`publishFinished` → `progress.status = 5`、`currentSize = file.length()`、`fraction = 1.0f`，可选 `addFileToMediaStore`、EventBus `TaskDownloadFinishEvent`，最后 `onSuccess(absolutePath)`（`:368-390`）

**新路径 `StreamingTransferEngine` 的重试**：`TransferRetryPolicy.ResumeFromCheckpoint(maxRetries)`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java:1376` 传的是 **`ResumeFromCheckpoint(5)`**，与旧路径同一个 5 次上限。续传点由 `ResumePolicyRegistry.resumeOffset(policy, checkpoint, localPart, source, route)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/ResumePolicyRegistry.java:16-58`）裁决，**任一条件不满足就返回 0（从头下）**：
- `checkpoint == null` → 0
- `localPart` 不是文件 → 视为 null → 0
- `checkpoint.offset <= 0` → 0；`checkpoint.offset != localPart.length()` → 0（**本地分片被截/被改则放弃续传**）
- `checkpoint.sourceFingerprint != source.fingerprint` → 0（**换了源文件即作废**）
- `policy == Disabled` → 0
- `HttpRange`：source 必须是 Internet；且 `entityTag` 与 `lastModified` **至少一个非空白**，否则 0（弱校验器缺失就不敢续传）
- `DeviceOffset` / `DeviceQueryOffset`：source 必须是 Device，且 `checkpoint.routeRevision == route.revision` 且 `checkpoint.endpointGrantId == grant.id` → 才续传（**路由换代或 grant 换代即作废**）

传输层 EOF 特判：`isResponseHeaderEof(error)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:780-801`）= message 以常量 `UNEXPECTED_END_OF_STREAM_PREFIX = "unexpected end of stream on "` 开头 **且** cause 链上存在 `EOFException`。
租约失效：`withLeaseCancellation` 用 `IllegalStateException("Transfer route lease was closed")`（`api` 表 `:1082` 体内字面量）中断；`upload` 里 `CancellationException` 分类为 `"RouteSuperseded"` 或 `"Cancelled"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:329`、`:445-462`）。
`replaceTarget(partFile, destination)` 失败 → `IllegalStateException("Unable to finalize transfer destination")`（`:1172`）。
`validateDeviceLease`（`:665-685`）：grant 与 routeRevision 不匹配 → `IllegalArgumentException("Device transfer EndpointGrant does not match route revision")`；route 状态不在 `{VERIFIED, READY}` → `IllegalArgumentException`。

### 2.6 `getmediainfo` / `getfilelist` 字段

只有 **M3** 机型有这两个端点（`data/source/remote/api/p006m3/M3ApiService.java`）：

```java
@GET("/app/getfilelist")   Object getFileList(Continuation<? super M3FileListResponse>);      // 无参
@GET("/app/getmediainfo")  Object getMediaInfo(Continuation<? super M3MediaInfoResponse>);    // 无参
@GET("/app/deletefile")    Object deleteFile(@Query("file") String, ...);
@GET("/app/getthumbnail")  @Streaming Object getThumbnail(@Query("file") String, ... ResponseBody);
@GET                       @Streaming Object downloadFile(@Url String, ... ResponseBody);
```

`M3FileListResponse`（`dto/p007m3/M3FileListResponse.java`）：

| JSON key | 类型 | 说明 |
|---|---|---|
| `result` | `int` | 状态码，0/非 0 判定 |
| `info` | `List<M3FolderInfo>` | 文件夹数组 |

`M3FolderInfo`：`folder: String`（`@SerializedName(Progress.FOLDER)`，即 key = `"folder"`）、`count: int`、`files: List<M3FileItem>`。
`M3FileItem`：`name: String`（`@SerializedName(SerializableCookie.NAME)` = `"name"`）、`size: long`、`createtime: long`、`duration: int`、`type: int`。

`M3MediaInfoResponse`：`result: int`、**`info: com.google.gson.JsonElement`（不是具体类型）**——服务端这个字段可能是对象也可能是数组，所以刻意留松。解析后才落到 `M3MediaInfo`：`rtsp: String`、`transport: String`、`port: int`（`dto/p007m3/M3MediaInfo.java`）。这三项是 §4 RTSP 选路的输入。

RIDE3PRO/RIDE5 的文件列表不走这两个端点（走 `/api/playback/*` 与 `getmediafilelist` 系列，由 `VerifiedDeviceFileCatalog` 白名单化，见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/VerifiedDeviceFileCatalog.java:1011` 的 `"Ride3Pro file_index is outside the confirmed range"`），细节归机型附录。

---

## 3. OTA：相机固件升级

**必须先分清：仓库里有两套并存的相机 OTA 实现。**

| | 新架构（本文 §3.1–§3.6） | 线上实际跑的 |
|---|---|---|
| 入口 | `core/update/DeviceOtaCoordinator.execute(DeviceOtaPlan)` | `presentation/p010ui/mine/UpgradeActivity` |
| 状态 | `DeviceOtaState` **14 个枚举值** | `OtaUpgradeState` sealed class，**10 个子类** |
| 上传 | `HttpClientProfile.DEVICE_UPLOAD` 走 `StreamingTransferEngine.upload` | 三条机型专用通道：Ride3Pro Retrofit / M3 Retrofit / Ride5 裸 socket |
| 是否被真实调用 | **否**：`DeviceOtaOperations` 只有接口和调用者，APK 内**找不到任何实现类**（对 `queryUpdate / installUploadedPackage / readVersion / reconnect / waitForDeviceReady / waitForReboot` 六个方法名的全仓 grep 只命中 `core/update/DeviceOtaCoordinator.java` 与 `core/update/DeviceOtaOperations.java` 两个文件；`DeviceOtaCoordinator` 仅出现在 `core/update/` 与 `p009di/AppModuleKt.java`，即只被 Koin 注册为 Singleton 而无人 `get`） | 是 |

复现建议：14 态机是「应该长什么样」的参考答案，线上路径是「现在真的能跑」的兼容实现。下面分别抄清。

### 3.1 `DeviceOtaOperations` 全部方法签名与语义

`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaOperations.java`，`interface`，**恰好 6 个方法，全部 suspend、全部无参**（返回类型即 `Continuation<? super T>` 的 T）：

| 签名（Kotlin 视角） | 语义 | 被谁调 |
|---|---|---|
| `suspend fun queryUpdate(): Boolean` | 问设备「你需不需要这个包」；`false` 表示无需升级，**直接回 IDLE 而非失败** | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java:201`、`:325` |
| `suspend fun waitForDeviceReady(): Unit` | 等设备进入可接收固件的状态（通常在 VERIFYING 之后） | `:246`、`:366` |
| `suspend fun installUploadedPackage(): Unit` | 让设备开始装机（上传已完成之后） | `:276`、`:396` |
| `suspend fun waitForReboot(): Unit` | 等设备重启掉线 | `:284`、`:404` |
| `suspend fun reconnect(): Unit` | 重新建立直连路由/会话 | `:292`、`:412` |
| `suspend fun readVersion(): Unit`→`String` | 回读装机后的固件版本 | `:300`、`:420` |

配套类型：
- `DeviceOtaPlan(expectedVersion, packageFile, upload, operations, packageDownload, packageIntegrity, diagnostics)`（`DeviceOtaPlan.java`）；`packageDownload: TransferRequest?` **可为 null**（包已在本地时跳过下载）
- `DeviceOtaProgress(state, transferredBytes: Long?, totalBytes: Long?, routeRevision: Long?, error: Throwable?)`
- `DeviceOtaResult` 4 个子类：`Completed(version: String, routeRevision: Long)` / `UpdateUnavailable`(object) / `Cancelled`(object) / `Failed(error: Throwable)`
- 进度流：`val progress: StateFlow<DeviceOtaProgress>`，初值 `DeviceOtaProgress(IDLE, null, null, null, null)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java:70`）

### 3.2 请求字段来源：`md5sum` / `model` / `hw` / `sw`

**只有 Ride3Pro/RIDE6 通道用这四个 query 参数。** 端点声明（`data/source/remote/api/ride3pro/Ride3ProApiService.java:99-101`）原样：

```java
@Headers({"Content-Type: application/octet-stream", "Content-Encoding: identity", "Connection: close"})
@POST("/api/firmware/upload")
Object uploadFirmware(@Query("md5sum") String, @Query("model") String,
                      @Query("hw") String, @Query("sw") String,
                      @Body RequestBody, Continuation<? super Ride3ProApiResponse<Object>>);
```

| 字段 | 来源 | 证据 |
|---|---|---|
| `md5sum` | **App 侧对本地固件文件算 MD5**，`MessageDigest.getInstance("MD5")`，8192 字节流式读，逐字节 `String.format("%02x")` 拼接 → **32 位小写十六进制** | `data/repository/Ride3ProFirmwareUploadRepository$_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:135-157` |
| `model` | `Ride3ProFirmwareMeta.getModel()` | 同上 `:164` |
| `hw` | `Ride3ProFirmwareMeta.getHwVersion()` | 同上 |
| `sw` | `Ride3ProFirmwareMeta.getSoftwareVersion()` | 同上 |

`meta` 的三级取值（`presentation/p010ui/mine/UpgradeActivity.java:936-947`，`resolveRide3ProFirmwareMeta(File)`）：
1. 若 `LocalUpgradeBean != null` → `Ride3ProFirmwareMeta.create(bean.getRide3ProFirmwareModel(), bean.getRide3ProFirmwareHw(), bean.getRide3ProFirmwareSw())`
2. 上一步为 null → `Ride3ProFirmwareMeta.fromNewOta(bean.getBoardversion(), bean.getNewVersion())`
3. 都不行 → **从文件名解析**：`Ride3ProFirmwareMetaParser.parse(file.getName())`

文件名解析（`core/util/Ride3ProFirmwareMetaParser.java`）：
- 预处理：`trim()` → `substringBefore("?")` → `substringAfterLast("/")` → `substringAfterLast("\\")` → `URLDecoder.decode(..., Key.STRING_CHARSET_NAME)`（UTF-8），decode 失败保留原值（`:33-55`）
- 正则：`^(.+?)_cardvr_HW(.+?)_SW(.+?)_upgrade\.bin$`，`RegexOption.IGNORE_CASE`（`:19`）——即形如 `TUMODEL_cardvr_HW1_20_SW1_2_3_upgrade.bin`
- 版本 token 归一：`trim()` 后 `_` → `.`（`normalizeVersionToken`，`:62-64`），所以 `HW1_20` → `1.20`
- 解析不出来 → `IllegalStateException(getString(R.string.firmware_info_parse_failed_format, fileName))`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:160-162`）
- 文件不存在 → `Result.failure(IllegalArgumentException(getString(R.string.firmware_file_not_exist)))`（`:79-82`）

**M3 通道没有 md5/model/hw/sw**（`data/source/remote/api/p006m3/M3ApiService.java:134-135`）：

```java
@Streaming @POST("/upload/{savepath}/{filesize}")
Object uploadFirmware(@Path(encoded = true, value = "savepath") String,
                      @Path("filesize") long, @Body RequestBody, ...);
```
调用点 `savepath` **硬编码 `"mnt/sdcard"`**，`filesize = file.length()`（`data/repository/M3DeviceRepositoryImpl$_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl$uploadFirmware$2.java:171`）。响应 `M3UploadResponse{result:int, info:String}`；结果分类见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl$uploadFirmware$2.java:152-180`（JADX 把 `when(result)` 反成 `if (result != 0)` 链，分支方向不可全信；可确定的是 **`result == 0` 为成功**，`2`、`3` 各有专属失败消息，其它值走 `R.string.upload_failed_format` 带 `result`）。

**Ride5 通道的两个 query 是设备给的、不是 App 算的**：`Ride5CgiApi.checkUpgradePacketInfo(@Query("-model"), @Query("-softversion"), @Query("-pktlen"))`（`core/device/ride5/Ride5CgiApi.java:20`）→ 响应解析出 `offset` 与 `unitsize` 两个字段（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java:1473-1478`，缺任一个就 `IllegalArgumentException("RIDE5 OTA packet check did not return offset and unitsize")`）。

### 3.3 上传分块大小与超时

| 通道 | 分块 | 超时 | 证据 |
|---|---|---|---|
| 新架构（`StreamingTransferEngine.upload`） | 单请求整体流式，`ProgressRequestBody` 内部逐块写；profile 固定 `HttpClientProfile.DEVICE_UPLOAD` | connect `10s` / read `120s` / write `120s` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:334`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/RoutedOkHttpProviderKt.java:82-84` |
| Ride3Pro Retrofit | `RequestBody.writeTo` 每次 `read` **8192 字节** → `sink.write` → `sink.flush()` → 回调 `onProgress(已传, 总长)` | `contentLength = file.length()`；MediaType = `OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE`（`application/octet-stream`）；service provider = `Ride3ProSessionExecutorResolver.longOperationServiceOrLegacy()`（长操作 client） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:86-131`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository.java:41-47` |
| M3 Retrofit | 同上，**8192 字节/块**，每块后 `sink.flush()` + 进度回调 | 走 `M3HttpClientCompatibilityKt`：connect `5s` / read `120s` / write `120s` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/M3DeviceRepositoryImpl$uploadFirmware$2.java:104-135`、`catalog-ports.md:85-87` |
| Ride5 裸 socket | **块大小 = 设备返回的 `unitsize`**（`Integer.parseInt(unitsize)`），`offset = Long.parseLong(offset)` 作为续传游标；每个 `unitsize` 块**单独开一条 socket、单独发一个 multipart POST**；块内再按 **1024 字节** 写 | `socket.setSoTimeout(Ride3ProSessionTransport.MENU_CONNECT_TIMEOUT_MILLIS)` = **5000 ms** | `core/util/UpgradeDevice.java:712-801`（分块/续传）、`:151-199`（socket 与报文） |

Ride5 的报文是**手写的 HTTP/1.1**（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java:173-188`），逐字抄：
- 固定 boundary：`--------------------------0f063f014f74bfea`（26 个 `-` + `0f063f014f74bfea`）
- 请求行/头：`POST /sd HTTP/1.1\r\nHost: <grant.host>\r\nUser-Agent: curl/7.50.3\r\nAccept: */*\r\nContent-Length: <bodyPart + sb.length>\r\nExpect: 100-continue\r\nContent-Type: multipart/form-data; boundary=------------------------0f063f014f74bfea\r\n\r\n`
- part 头：`--------------------------0f063f014f74bfea\r\nContent-Disposition: form-data; name="filename"; filename="<file.getName()>"\r\nContent-Type: application/octet-stream\r\n\r\n`
- part 尾：`\r\n--------------------------0f063f014f74bfea--\r\n`
- 字符集：`Charset.defaultCharset()`
- 端口：`grant.allowedPorts.size() == 1 ? first() : -1`；发之前 `endpointAuthority.authorizeSocket(endpointGrantId, sessionId, routeRevision, EndpointPurpose.OTA, host, port)`；socket 用 `deviceNetwork.getSocketFactory().createSocket(host, port)`（即绑到设备 Network）

新架构侧的校验：`upload` 前依次 `sourceFile.isFile()` 否则 `IllegalArgumentException("Transfer source file does not exist")`、`IntegrityVerifier.verify(sourceFile, integrityPolicy)`、`lease.route.revision == upload.target.grant.routeRevision` 否则 `IllegalArgumentException("Upload EndpointGrant does not match route revision")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/StreamingTransferEngine.java:379-385`）。非 2xx 抛 `TransferHttpException(code, "Transfer upload failed: HTTP " + code)`（`:429`，注意 jadx 把 `isSuccessful()` 的条件反转了，语义是「不成功才抛」）。

### 3.4 14 态状态机：状态名、迁移条件、失败落点

`DeviceOtaState` 全部 14 个值（`core/update/DeviceOtaState.java`，按声明序）：
`IDLE, QUERYING, UPDATE_AVAILABLE, DOWNLOADING_PACKAGE, VERIFYING_PACKAGE, WAITING_FOR_DEVICE, UPLOADING_TO_DEVICE, INSTALLING, WAITING_FOR_REBOOT, RECONNECTING, CONFIRMING_VERSION, COMPLETED, FAILED, CANCELLED`

迁移驱动：`transition(state, plan)` 只写 `DeviceOtaProgress(state, null, null, plan.upload.target.grant.routeRevision, null)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java:782-784`）；`failed(t)` 写 `FAILED` + error（`:792-795`）；`cancelled()` 写 `CANCELLED`（保留原 error，`:786-789`）。

| # | 进入状态 | 触发/前置 | 成功后 | 失败落点 | 行号 |
|---|---|---|---|---|---|
| 1 | `IDLE` | 构造初值 | — | — | `:70` |
| 2 | `QUERYING` | `execute(plan)` 起手 | `queryUpdate()` 返回 true | 返回 **false** → `transition(IDLE)` + `UpdateUnavailable`（**不是 FAILED**）；抛异常 → `FAILED` | `:196-209` |
| 3 | `UPDATE_AVAILABLE` | `queryUpdate()==true` | — | 后续任一异常 → `FAILED` | `:210` |
| 4 | `DOWNLOADING_PACKAGE` | 仅当 `plan.packageDownload != null`（null 则跳过 4） | `TransferResult.Downloaded` 且落盘路径 == `plan.packageFile.absoluteFile` | `Downloaded` 但文件不对 → `FAILED(IllegalStateException("OTA package was written to an unexpected file"))`；`Cancelled` → `CANCELLED`；`Failed` → `FAILED(err)`；`Uploaded` → `FAILED(IllegalStateException("OTA package download returned upload result"))` | `:211-237` |
| 5 | `VERIFYING_PACKAGE` | 上一步过 | `IntegrityVerifier.verify` 不抛 | 抛 `IntegrityMismatchException` 等 → `FAILED` | `:239-240` |
| 6 | `WAITING_FOR_DEVICE` | 校验过 | `waitForDeviceReady()` 返回 | 抛/取消 → `FAILED` / `CANCELLED` | `:241-248` |
| 7 | `UPLOADING_TO_DEVICE` | 设备就绪 | 结果必须是 `TransferResult.Uploaded` | `Cancelled`→`CANCELLED`；`Failed`→`FAILED(err)`；`Downloaded`→`FAILED(IllegalStateException("OTA upload returned download result"))` | `:249-270` |
| 8 | `INSTALLING` | 上传成功 | `installUploadedPackage()` 返回 | → `FAILED` | `:271-278` |
| 9 | `WAITING_FOR_REBOOT` | 装机指令已下发 | `waitForReboot()` 返回 | → `FAILED` | `:279-286` |
| 10 | `RECONNECTING` | 设备重启完 | `reconnect()` 返回 | → `FAILED` | `:287-294` |
| 11 | `CONFIRMING_VERSION` | 路由重建 | `readVersion()` 非 null | `null` → `FAILED(IllegalStateException("OTA version confirmation returned no version"))`；`!= plan.expectedVersion` → `FAILED(IllegalStateException("OTA version mismatch: expected=..., actual=..."))` | `:295-311` |
| 12 | `COMPLETED` | 版本一致 | 返回 `Completed(version, plan.upload.target.grant.routeRevision)` | — | `:312-313` |
| 13 | `FAILED` | 任意 `Throwable` | — | 终态 | `:317-320`、`:792-795` |
| 14 | `CANCELLED` | 任意 `CancellationException` | — | 终态 | `:314-316`、`:786-789` |

关键点：**整条链上没有任何重试**（一次失败即 `FAILED` 返回），重试策略在上一层 UI/调用方；`plan.packageDownload == null` 是唯一合法分支跳过。

线上 `OtaUpgradeState` 的 10 个状态与迁移（`presentation/p010ui/mine/OtaUpgradeState.java` + `OtaUpgradeFlow.java`）：
`Idle`、`Preparing`、`Uploading(percent)`、`AwaitingDeviceAcknowledgement`、`InstallingAwaitingDeviceResult`、`InstallationSucceeded`、`InstallingSafetyWindow(remainingSeconds)`、`AwaitingUserConfirmation`、`AwaitingReconnectVerification`、`Failed(prompt)`。
迁移：`beginPreparing()`→`Preparing`；`beginUpload(p)`→`Uploading(coerceIn(p,0,99))`；`onUploadProgress(total,progress,signal)`→`percent = total>0 ? coerceIn((progress*100)/total,0,100) : 0`，`percent >= 100` 时按 `OtaCompletionSignal` 分叉：`UploadAccepted`→`AwaitingDeviceAcknowledgement`、`InstallationCompleted`→`InstallingAwaitingDeviceResult`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeFlow.java:66-84`）；`enterInstallingSafetyWindow(s)`→`InstallingSafetyWindow(coerceAtLeast(s,0))`；`installationSucceeded()`→`InstallationSucceeded`；`tickSafetyWindow(remaining)`→`InstallingSafetyWindow(coerceAtLeast(remaining,0))`；`awaitUserConfirmation()`→`AwaitingUserConfirmation`；`awaitReconnectVerification()`→`AwaitingReconnectVerification`；`fail(prompt)`→`Failed(prompt)`；`reset()`→`Idle`（`:87-112`）。
`getBlocksNavigation()` 为 true 的状态：`Preparing / Uploading / AwaitingDeviceAcknowledgement / InstallingAwaitingDeviceResult / InstallationSucceeded / InstallingSafetyWindow / AwaitingUserConfirmation`；为 false：`Idle / AwaitingReconnectVerification / Failed`（`:41-46`）——**装机安全窗与用户确认期禁止返回**。

### 3.5 装机后回读版本的代码路径

新架构：`CONFIRMING_VERSION` 里 `plan.operations.readVersion()` 与 `plan.expectedVersion` 严格 `Intrinsics.areEqual`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java:295-311`）。但**该接口无实现，故线上不会走到**。

线上实际（`UpgradeActivity`）：
1. `onCreate` 阶段先取**装机前**版本作为基线：`SessionBoundOtaIdentityPolicy.resolve(...)` → `setCurrentVersion(bean.getVersion())`、`currentBoardVersion`、`upgradeModel`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java:450-460`）。若解析不到同身份会话，直接 `Timber.w("固件升级拒绝未绑定同一设备身份的会话: identity=%s operation=%s type=%s")` + Toast `loading_failed` + `finish()`（`:451-456`）——**OTA 页强要求会话与设备身份绑定**。
2. 上传成功回调 → `onUploadSuccess()` → `suppressRepeatDownloadPrompt()` + `showInstallationSafetyDialog()`（`:543-558`）。安全窗常量 `COUNTDOWN_SECONDS = 30`（`:96`），`runInstallConfirmButtonCountdown(...)`（该方法 jadx 未能反出，`:1408`）。
3. 重启后靠 `FirmwareUpgradeReconnectGate` 判定「回连的是不是原来那台」（`core/util/FirmwareUpgradeReconnectGate.java`）：`markPending(ssid)` → `pending = true`、`pendingSsid = normalizeSsid(ssid)`（trim + `removeSurrounding("\"")`，空→null）；`isPending()` / `matches(ssid)`（**`pendingSsid == null` 时匹配任意 SSID**）；`completeIfMatches(ssid)` 命中才清 pending；`reset$app_release_64()` 全清。它是 `volatile` 静态单例，跨 Activity 生效。
4. 版本回读最终来源仍是会话 identity（重连后 `DeviceSessionManager` 重新探测出的 `identity.firmwareVersion`），并回填 `PreferenceHelper.getCacheDevices()` 里的 `ConnectedDevice.version`；`UpgradeActivity` 自己不再直连查版本。
5. 上传成功后清理本地包：`Ride3ProUpgradeSuccessPolicy.clearUploadedFirmware(file.getAbsolutePath())`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java:795`、`:823`）。

Ride5 的「装完」判定不是回读版本，而是**分块计数**：`getChunck(0, file)` 返回已推进的块号，`chunck >= chuncks` 才算 `onUploadSuccess()`，否则 `notifyUploadFailed()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java:727-743`）；`notifyUploadFailed()` 无 listener 时 `mHandler.sendEmptyMessage(MSG_UPLOAD_FAILED)`，`MSG_UPLOAD_FAILED = 10003`（`:803-813`、`catalog-ports.md:188`）。

### 3.6 本地固件文件选择与校验

- 目录：`UpgradeHelper.UPGRADE_DIRECTORY_NAME = "upgrade"`（`core/util/UpgradeHelper.java:73`），`upgradeBaseDirectory()`（`:634`）
- 文件后缀：**`.appsw`**（Ride5/M3 老包）——`getMatchedFirmware()` = `list(name.endsWith(".appsw"))` 再 `Arrays.sort`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java:96-135`）；Ride3Pro 新包后缀是 **`.bin`**（正则 `_upgrade\.bin$`）
- 校验和：`hasUsableCachedPackage(filePath, expectedFileName, expectedFileSize)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeHelper.java:440`）——**只比文件名与字节大小，不比对包内容做哈希**
- **MD5**：只在 Ride3Pro 上传前算一次，用作 `md5sum` query 参数交给设备侧校验（算法 `MD5`，编码 `%02x` 小写 hex，无分隔符，32 字符；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/repository/Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:135-157`）。**App 侧不拿它跟服务端下发的值比对。**
- **SHA-256**：新传输层的通用完整性策略 `IntegrityPolicy`，4 个子类 `None / ExpectedSize(bytes) / Sha256(hex) / ExpectedSizeAndSha256(bytes,hex)`（`core/transfer/IntegrityPolicy.java`）。`IntegrityVerifier.verify(file, policy)`（`core/transfer/IntegrityVerifier.java`）：`None` 直接 return；`ExpectedSize` → `requireSize`（`!file.isFile() || length != expected` → `IntegrityMismatchException("Transfer size does not match expected value")`）；`Sha256` → 比较；`ExpectedSizeAndSha256` → 先 size 再 sha256。
  - 算法：`MessageDigest.getInstance("SHA-256")`，`byte[8192]` 流式读；hex 同样 `%02x` 小写、无分隔
  - **比较用 `String.equals(..., ignoreCase = true)`**（`StringsKt.equals(sha256(file), policy.hex, true)`），所以期望值大小写都行
  - 不等 → `IntegrityMismatchException("Transfer SHA-256 does not match expected value")`
- 云端 OTA 元数据：`GET newota?version=&boardversion=` → `UpgradeBean`；`hasUsableCachedPackage` 决定复用还是重下（`UpgradeHelper.processAvailableUpdate`，`:490`）；串行下载队列 `OtaSerialTaskQueue<OtaPackageIdentity, OtaDownloadTask>`（`:86`），完成后停留展示 `DOWNLOAD_COMPLETE_DISPLAY_MILLIS = 2000`（`:72`）
- 下载走 `DownloadUtil` + `DownloadNetworkRoute.Internet` → profile `INTERNET_DOWNLOAD`（connect 10 / read 60 / write 60 秒），见 §2

### 3.7 App 自更新（与相机 OTA 完全两套）

`core/update/AppUpdateCoordinator` + `TuwinApplication`，**跟相机固件无关**：不占 `RouteState` 设备面、不需要 EndpointGrant，只用 `NetworkPlane.INTERNET` 的 `READY` 路由。

- 状态枚举 `AppUpdateCheckState` 7 个：`IDLE, WAITING_FOR_INTERNET_ROUTE, CHECKING, NO_UPDATE, UPDATE_AVAILABLE, CHECK_FAILED, CHECK_CANCELLED`（`core/update/AppUpdateCoordinator` 同名文件）
- 结果 `AppUpdateCheckResult` 5 个：`WaitingForInternetRoute / NoUpdate / UpdateAvailable(key, response, routeRevision) / Failed(key, error) / Cancelled(key, reason)`
- 去重键 `AppUpdateCheckKey(versionCode, releaseChannel, serverEnvironment)`；调用实参：`AppUpdateCheckKey(250, "stable", "production")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:433`、`:146-147`）
- 端点：`@GET("appupdatecheker") @Query("version") String, @Query("platform") String`（`data/source/remote/api/TuwinSuspendApi.java`，注意拼写 `cheker`），`platform` 恒为 `"android"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedAppUpdateGateway.java:51`）；baseUrl = `FeedbackApiEndpoint.BASE_URL = "http://ali.tuwinsmart.com/"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/remote/gateway/FeedbackApiEndpoint.java:10`）→ **明文 HTTP**；profile `HttpClientProfile.INTERNET_API`（connect 10 / read 30 / write 30）
- URL 合法性：`isNetworkDownloadUrl(s)` = `HttpUrl.parse(s)` 非空 && scheme ∈ {http,https} && `username` 空 && `password` 空 && `host` 非空（`AppUpdateCoordinatorKt.java`）
- 判定：`hasNewVersion == false` → `NO_UPDATE`；否则要求 `appInfo != null` 且 `isNetworkDownloadUrl(appInfo.downloadUrl)`，不满足 → `CHECK_FAILED` + `IllegalStateException("Invalid app update response")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/update/AppUpdateCoordinator.java:514-522`；`:517` 的 `appInfo != null ||` 是 jadx 反转产物，原义为 `appInfo == null || !valid`）
- 路由不可用：捕获 `RouteUnavailableException` → `WAITING_FOR_INTERNET_ROUTE` + `WaitingForInternetRoute(key)`（`:498-500`），由 `NetworkRuntime.addInternetRouteListener` 在拿到 READY 路由后重新触发（`TuwinApplication.requestInternetRouteUpgradeCheck()` → `checkUpdateApi()` → `checkUpdate()`，`:688-694`）
- lease 存活检查：响应回来后先 `lease.requireActive()`（`:513`），`CancellationException` 中 `RouteSupersededException` 记 reason `"RouteSuperseded"`，其余 `"Cancelled"`（`:530-536`）
- 弹窗抑制：`appUpdatePromptKey(bean) = trim(version) + "|" + trim(downloadUrl)`，`presentedAppUpdateKeys` 集合去重；不在 `HomeActivity` 可展示时挂到 `pendingAppUpdateBean`，回 Home 后 `tryShowPendingAppUpdatePrompt()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:468-498`、`:500-537`）
- 下载安装：落盘 `filesDir/app-updates/tuwin_smart_<System.currentTimeMillis()>.apk`，intent 走 `NetworkIntent.Internet("app_update_download")`，`ResumePolicy.Disabled` + `IntegrityPolicy.None`（**不校验 APK 哈希**），源经 `AuthorizedTransferSource.Internet.authorize(url, setOf(host))` 过 host 白名单策略；然后 `FileProvider.getUriForFile(activity, packageName + ".fileProvider", file)` + `Intent.ACTION_VIEW` + `application/vnd.android.package-archive` + flags `1`(FLAG_ACTIVITY_NEW_TASK) | `268435456`(FLAG_GRANT_READ_URI_PERMISSION)（`:578-611`、`:679-686`）
- 诊断事件名：`app_update_download_requested`，字段 `target_version / source(host+脱敏) / forced`（`:573`）

---

## 4. 预览与播放

### 4.1 ijkplayer / `IjkMediaPlayer` 初始化参数（key=value 逐项）

App 层**从不直接 new `IjkMediaPlayer`**：全部 ijk 参数都以 GSY 的 `VideoOptionModel(category, name, value)` 列表形式下发，由 `IjkPlayerManager` 在 prepare 阶段逐条 `ijkMediaPlayer.setOption(...)` 落地——`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:94`（`initIJKOption(mediaPlayer, list)`）→ `:320-331`（`valueType == 0` 走 int 重载，否则走 String 重载）。类别常量：`OPT_CATEGORY_FORMAT = 1`、`OPT_CATEGORY_CODEC = 2`、`OPT_CATEGORY_SWS = 3`、`OPT_CATEGORY_PLAYER = 4`（`_work/tuwin_src/sources/tv/danmaku/ijk/media/player/IjkMediaPlayer.java:85-88`）；`SDL_FCC_RV32 = 842225234`（同文件 `:92`）。

> 注意：`IjkMediaPlayer` 的 `import` 在几十条与播放无关的文件里出现（`core/device/p005m3/*`、`core/network/*`、`data/repository/*` 等），那只是 jadx 把 `IjkMediaPlayer.OnNativeInvokeListener.ARG_*` 一类**内联常量**引用渲染成 import，不代表真的用了播放器。

**唯一配置入口**是 object `VideoUtil`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:21-22`）。两套列表**整体互相替换**（`GSYVideoManager.instance().setOptionModelList(...)`，同文件 `:83`、`:94`），不是叠加。

**A. 实时预览 `VideoUtil.initLive(transport)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:57-84`，共 18 项）**；`initLive$default` 缺省参数是 `RtspTransport.TCP`（`:50-55`）：

| # | cat | key | value | 位置（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java`） |
|---|---|---|---|---|
| 1 | 1 FORMAT | `rtsp_transport` | `"tcp"` / `"udp"`（`transport.name().toLowerCase(Locale.ROOT)`）；**AUTO 时此项完全不写** | `:60-65` |
| 2 | 1 | `fflags` | `"nobuffer"` | `:66` |
| 3 | 1 | `flags` | `"low_delay"` | `:67` |
| 4 | 1 | `avioflags` | `"direct"` | `:68` |
| 5 | 1 | `flush_packets` | `1` | `:69` |
| 6 | 1 | *（键名来自混淆常量 `com.umeng.ccg.C3174a.f2695E`）* | `0` | `:70` |
| 7 | 1 | `probesize` | `32768` | `:71` |
| 8 | 1 | `analyzeduration` | `0` | `:72` |
| 9 | 1 | `reorder_queue_size` | `0` | `:73` |
| 10 | 4 PLAYER | `packet-buffering` | `0` | `:74` |
| 11 | 4 | `framedrop` | `1` | `:75` |
| 12 | 4 | `min-frames` | `1` | `:76` |
| 13 | 4 | `infbuf` | `0` | `:77` |
| 14 | 4 | `max_cached_duration` | `50` | `:78` |
| 15 | 4 | `max-buffer-size` | `262144`（256 KiB） | `:79` |
| 16 | 2 CODEC | `skip_loop_filter` | `48` | `:80` |
| 17 | 4 | `an` | `1` | `:81` |
| 18 | — | `IjkPlayerManager.setLogLevel(8)`（随后 `IjkMediaPlayer.native_setLogLevel`，`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:93`） | `8` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:82` |

**第 6 项键名静态无解**：`com.umeng.ccg.C3174a` 的 `.java` 与类清单条目在归档里都不存在（`_work/re/tuwin/classes-all.tsv` 里 `com.umeng.ccg` 只有 `C3177d`/`CcgAgent`，`_work/tuwin_src/sources/com/umeng/ccg/` 下只有这两个文件），而 `_work/re/tuwin/apk-entries.tsv:9` 显示还有 `classes3.dex`（压缩后 1,229,312 B）没被喂给本次 jadx。**补证手段**：单独对 `classes3.dex` 跑 jadx 读 `C3174a` 的 `static {}` 初始化（同类的缺证项还有 `com.generalplus.ffmpegLib.ffmpegWrapper`，见 §7.2）。

**B. 录像回放 `VideoUtil.normalPlaybackOptions$app_release_64(enableSoundTouch)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:97-103`，`initNormal(z)` 见 `:93-95`，缺省 `false`）**，26 项 + 条件 1 项：

| # | cat | key | value | 位置（同文件） |
|---|---|---|---|---|
| 1 | 1 | `dns_cache_clear` | `1` | `:98` |
| 2 | 4 | `mediacodec` | `0`（硬解关） | `:98` |
| 3 | 4 | `opensles` | `0` | `:98` |
| 4 | 4 | `overlay-format` | `IjkMediaPlayer.SDL_FCC_RV32` = 842225234 | `:98` |
| 5 | 1 | `http-detect-range-support` | `0` | `:98` |
| 6 | 4 | `mediacodec-hevc` | `1` | `:98` |
| 7 | 1 | `analyzeduration` | `1` | `:98` |
| 8 | 1 | `rtsp_transport` | `"tcp"`（写死，与 A 套的动态取值不同） | `:98` |
| 9 | 1 | `analyzemaxduration` | `100` | `:98` |
| 10 | 1 | `flush_packets` | `1` | `:98` |
| 11 | 4 | `start-on-prepared` | `1` | `:98` |
| 12 | 4 | `fast` | `1` | `:98` |
| 13 | 4 | `mediacodec-auto-rotate` | `0` | `:98` |
| 14 | 4 | `mediacodec-handle-resolution-change` | `0` | `:98` |
| 15 | 4 | `packet-buffering` | `1`（回放开缓冲，与预览相反） | `:98` |
| 16 | 4 | `max-buffer-size` | `15728640`（15 MiB，预览的 60 倍） | `:98` |
| 17 | 4 | `min-frames` | `100` | `:98` |
| 18 | 1 | `probesize` | `10485760`（10 MiB，预览的 320 倍） | `:98` |
| 19 | 4 | `infbuf` | `0` | `:98` |
| 20 | 4 | `reconnect` | `5` | `:98` |
| 21 | 1 | `http-detect-range-support` | `0`（**重复项**，与第 5 项同键同值） | `:98` |
| 22 | 2 | `skip_loop_filter` | `-16`（预览是 `48`） | `:98` |
| 23 | 2 | `skip_frame` | `0` | `:98` |
| 24 | 4 | `framedrop` | `5` | `:98` |
| 25 | 4 | `fps` | `20` | `:98` |
| 26 | 4 | `dropframe_when_poor_network` | `0` | `:98` |
| 27 | 4 | `soundtouch` | `1`，仅当 `enableSoundTouch == true` | `:99-101` |

调用点：`initNormal(false)` → `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/DailyDetailActivity.java:735`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/VideoPlayActivity.java:250`；`initNormal(true)`（倍速需要 soundtouch）→ `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackController.java:99`；`initLive(transport)` 以方法引用形式作为 `preparePlayer` 回调注入 GSY 适配器 → `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/storage/p011m3/M3VideoPlayActivity.java:266-281`（`FunctionReferenceImpl(..., VideoUtil.class, "initLive", ...)`，`invoke2` 在 `:280`）。

另有 GSY 库自带的 3 条：`GSYVideoType.isMediaCodec()` 为真时 `setOption(4,"mediacodec",1)`、`(4,"mediacodec-auto-rotate",1)`、`(4,"mediacodec-handle-resolution-change",1)`（`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:63-67`）——与 B 套里的 `mediacodec=0` 冲突时以 `initIJKOption`（`:94`，在其之后执行）为准，即 **App 列表覆盖库默认**。

### 4.2 `FFmpegTexturePlayerView` / `FFmpegRtspOptions` 参数

自研链路**没有 setOption 那种键值 API**，整条 native 播放只有一个入口：`ffmpegWrapper.naInitAndPlay(rtspUrl, options)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:295`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:248`），`options` 是**分号分隔的 `k=v` 串**，由 `FFmpegRtspOptions.compose()` 统一整形。

**`FFmpegRtspOptions`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegRtspOptions.java`）**
- 常量：`DEFAULT_PROBE_SIZE_BYTES = 32768`（`:19`）、`DEFAULT_ANALYZE_DURATION_US = 1000000`（`:20`）。
- `compose(options, forceUdpTransport)`（`:26-75`）算法：按 `;` 拆分 + `trim` + 丢空串（`:28-40`）→ 若 `forceUdpTransport` 则**删掉所有键名为 `rtsp_transport` 的项并在首位插入 `rtsp_transport=udp`**（`:41-50`）→ 若不存在 `probesize` 则追加 **`probesize=32768`**（`:52-63`）→ 若不存在 `analyzeduration` 则追加 **`analyzeduration=1000000`**（`:64-73`）→ 用 `;` 重新拼接（`:74`）。
- 键名比较：`optionName(s)` = `substringBefore('=').trim().toLowerCase(Locale.ROOT)`（`:78-82`），所以大小写不敏感。
- 上游唯一注入的 `options` 实参是 `FFmpegNativePlayerAdapter.Companion.transportOptions(transport)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegNativePlayerAdapter.java:366-376`）：`TCP → "rtsp_transport=tcp"`（`:371`）、`UDP → ""`（`:373`，靠 `forceUdpTransport=true` 让 compose 补 udp）、`AUTO → ""`（`:373`）。
- 因此自研路最终串只有三种形态：`rtsp_transport=tcp;probesize=32768;analyzeduration=1000000`、`rtsp_transport=udp;probesize=32768;analyzeduration=1000000`、`probesize=32768;analyzeduration=1000000`。
- 预览的低延迟**不在** options 串里，而是 ffmpeg 侧默认 + `naSetStreaming(true)`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:290`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:243`）这条「流模式」开关；native 内部还暴露了 `naSetBufferingTime` / `naSetDecodeOptions` / `naSetCovertDecodeFrameFormat` 等符号但 Java 侧无调用（见 §7.2）。

**视图侧其它渲染参数**
- `FFmpegTexturePlayerView`（TextureView）：`FRAME_DELAY_MS = 16`、`MAX_RETRY_COUNT = 5`、`RETRY_DELAY_MS = 500`、`TAG = "FFmpegTexturePlayerView"`（`:51-54`），`setKeepScreenOn(true)`（`:170`），`setSurfaceTextureListener(this)`（`:169`），`ffmpegWrapper.getInstance().SetViewHandler(statusHandler)`（`:171`）。
- `FFmpegPlayerView`（GLSurfaceView，横屏/全屏路）：`MAX_RETRY_COUNT = 5`、`RETRY_DELAY_MS = 500`、`RTSP_CLOSE_POLL_INTERVAL_MS = 20`、`RTSP_CLOSE_TIMEOUT_MS = 5000`、`SNAPSHOT_TIMEOUT_MS = 3000`、`STATUS_PLAYING = 0`、`STATUS_STOPPED = 1`、`STATUS_BUFFERING = 4`（`:49-56`）；`setEGLContextClientVersion(2)`（`:193`）+ `setRenderer(ffmpegWrapper.getInstance())`（`:194`）。
- 状态回调协议：native 往 `Handler` 发消息，`what` 语义 = `0` 流已打开（仅进入「等首帧」，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:152-163` / `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:131-142`）、`1` 停止（触发 `scheduleRetry`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:165-176` / `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:144-164`）、`2` 截图完成（仅 GL 版，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:178-181`）、`4` buffering（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:182-189` / `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:145-154`）。**没有 `what == 3` 的分支**，也没有独立的 error 消息——错误只能靠 `naInitAndPlay` 返回码与首帧超时体现。
- 首帧判定：`FFmpegFirstFrameMonitor`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegFirstFrameMonitor.java`）默认 `timeoutMs = 15000`、`pollIntervalMs = 50`（`:47` 的合成构造器里 `(i & 16) != 0 ? 15000L`、`(i & 32) != 0 ? 50L`；两个视图都用 `0L, 0L, 48, null` 走默认，见 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:124`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:145`）；帧计数来自 `ffmpegWrapper.naGetFrameCnt()`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView$firstFrameMonitor$1.java:22`）；读失败按 `-1` 处理（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegFirstFrameMonitor.java:146-149`）。判据在 `FFmpegFirstFrameGate`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegFirstFrameGate.java`）：`reset(coerceAtLeast(frameCount,0))`（`:15-19`）、`markNativePlaying()` 幂等（`:21-27`）、`observe()` 要求「已 native playing && 未收到首帧 && count ≥ 0 && (count > baseline || (count < baseline && count > 0))」——即**计数器回绕也算新帧**（`:29-41`）。超时回调 → `handleFirstFrameTimeout()` → `stopInternal()` + `scheduleRetry("Preview first frame timed out")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:548-554`）。
- 端点/URL 模板（`rtsp://host:port/livestream/1`、`/?action=stream` 等）**归属协议面附录 §7**，本节只列播放器如何消费（见 §4.4 末表）。

### 4.3 GSY 播放器参数

GSY 只做「ijk 的宿主」，App 侧配置面很小：

| 项 | 值 / 行为 | 位置 |
|---|---|---|
| 播放内核 | `PlayerFactory.setPlayManager(IjkPlayerManager.class)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:355` |
| 原始资源播放 | `GSYVideoManager.instance().enableRawPlay(app)`，实现只是保存 application context（`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/GSYVideoBaseManager.java:617-619`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:356` |
| 参数注入 | `GSYVideoManager.instance().setOptionModelList(list)`（存字段，`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/GSYVideoBaseManager.java:625-627`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:83`、`:94` |
| 日志级别 | `IjkPlayerManager.setLogLevel(8)`（仅 `initLive` 设置） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:82` |
| 静音 | `GSYVideoManager.instance().setNeedMute(true)` → `ijk.setVolume(0f,0f)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/DailyDetailActivity.java:764`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/VideoPlayActivity.java:284`；`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:142-149` |
| 倍速 | `videoView.setSpeedPlaying(speed, true)` → 追加 `cat4 soundtouch=1` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackController.java:216-221`、`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:117-139` |
| 数据源 | `setUpLazy(url, cache=false, cachePath=null, mapHeadData=null, title)` → 仅记字段、`mUrl="waiting"`、`mCurrentState=0`；同一 listener 在 2000 ms 内重复 set 会 `return false` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/GsyNativePlayerAdapter.java:92`、`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/video/base/GSYVideoControlView.java:1207-1221` |
| 起播 / 释放 | `startPlayLogic()` / `release()` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/GsyNativePlayerAdapter.java:124`、`:130` |
| 错误映射 | `onPlayError` → `IllegalStateException("GSY media playback failed")` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/GsyNativePlayerAdapter.java:115-119` |
| 库内置缓冲超时 | `BUFFER_TIME_OUT_ERROR = -192` | `_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/GSYVideoBaseManager.java:30`、`:59` |
| 页面生命周期 | `GSYVideoManager.onResume()` / `onPause()` / `releaseAllVideos()` / `backFromWindowFull()` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java:359`、`:442`、`:448`、`:453` |

播放器包装：`GsyNativePlayerAdapter`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/GsyNativePlayerAdapter.java`，实现 `core/media/NativePlayerAdapter`）在 `start()` 里先 `requestStop()`、再新建 `CompletableDeferred` 关闭信号、再调 `preparePlayer(transport)`（即 `VideoUtil.initLive`）、最后 `setUpLazy + startPlayLogic`（`:86-124`）；`awaitClosed()` 就是 `closeSignal.await()`（`:136-139`）。Ride5 小时回放另有一个自实现 `NativePlayerAdapter`，它对 transport 有硬校验：`rtspTransport != RtspTransport.AUTO → IllegalArgumentException("RIDE5 HTTP playback does not support RTSP transport options")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackController.java:105-108`）。

### 4.4 `RtspTransport` 取值与选择逻辑

枚举只有 3 个值，**顺序即 ordinal**：`AUTO = 0`、`TCP = 1`、`UDP = 2`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/RtspTransport.java:11-14`，同 `catalog-enums.md:93`）。它**没有** `lowerOrdinal` / 数值码，各处靠 `WhenMappings` 做 switch 映射（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegNativePlayerAdapter.java:340-356`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:26-45`，两份映射内容一致：TCP=1、UDP=2、AUTO=3）。

选择方（生产 `MediaSessionRequest.requestedTransport` 的地方）：

| 场景 | 选择逻辑 | 结果 | 位置（`_work/tuwin_src/sources/...`） |
|---|---|---|---|
| 详情页实时预览 | `DeviceDetailRtspTransportPolicy.forDevice()`：只有 `RIDE6 → AUTO`，其余全部 `UDP` | RIDE6=AUTO；M3/RIDE5/RIDE3PRO=UDP | `com/tuwinsmart/tuwin/presentation/p010ui/device/detail/DeviceDetailRtspTransportPolicy.java:31-37`（WhenMappings 只登记 RIDE6，`:15-26`），调用 `device/detail/DeviceDetailActivity.java:1942` |
| Ride3Pro/Ride6 回放 | `RidePlaybackRtspTransportPolicy.forDevice()`：`RIDE3PRO`/`RIDE6 → AUTO`，其它设备抛 `IllegalArgumentException("Ride RTSP playback does not support " + deviceType.getCode())` | AUTO | `com/tuwinsmart/tuwin/presentation/p010ui/album/RidePlaybackRtspTransportPolicy.java:17-22`，调用 `album/Ride3ProDailyDetailActivity.java:2705` |
| M3 文件回放 | 写死 `RtspTransport.AUTO` | AUTO | `com/tuwinsmart/tuwin/presentation/p010ui/storage/p011m3/M3VideoPlayActivity.java:677` |
| Ride5 小时回放 | 写死 `RtspTransport.AUTO`（且适配器拒绝非 AUTO） | AUTO（走 HTTP 文件而非 RTSP） | `com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackActivity.java:1702` |
| Home 卡片小窗预览 | 写死 `RtspTransport.UDP` | UDP | `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListAdapter.java:998` |
| 未显式传参 | `MediaSessionRequest` 合成构造器默认 `RtspTransport.AUTO` | AUTO | `com/tuwinsmart/tuwin/core/media/MediaSessionRequest.java:165` |

消费方（transport → 播放器实参）：

| 适配器 | 转换 | 位置 |
|---|---|---|
| FFmpeg（自研 native） | `transportOptions(t)`：TCP→`"rtsp_transport=tcp"`，UDP/AUTO→`""`；第二个实参 `forceUdpTransport = (t == UDP)` 交给 `FFmpegRtspOptions.compose` | `com/tuwinsmart/tuwin/presentation/widget/video/FFmpegNativePlayerAdapter.java:366-376`、`:105`、`:149` |
| GSY（ijk） | `initLive(t)`：`t ∈ {TCP, UDP}` 才写 `rtsp_transport = t.name().toLowerCase(ROOT)`；AUTO 不写（用 ijk 默认） | `com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:60-65` |
| Ride5 HTTP | 非 AUTO 直接抛异常 | `com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackController.java:106-108` |

endpoint 侧还有一条约束：`DeviceMediaEndpoint` 构造里 `protocol == HTTP && transport != RtspTransport.AUTO` → `IllegalArgumentException("HTTP media must not declare an RTSP transport")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/DeviceMediaEndpoint.java:130`）。设备侧给出的 RTSP 端点统一是 `RtspTransport.AUTO`（`core/device/ride5/Ride5DeviceMediaPort.java:110`、`core/device/ride3pro/DocumentedRide3ProMediaEndpointResolver.java:31`）。

### 4.5 纹理渲染与 Surface 生命周期

**谁持有 Surface**：两条自研路各自持有，互不共享，且 native 侧是**单实例渲染器**。

`FFmpegTexturePlayerView`（TextureView + 自管 EGL，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java`）：
- 视图自身实现 `TextureView.SurfaceTextureListener`（`:47`），构造里 `setSurfaceTextureListener(this)`（`:169`）。
- `onSurfaceTextureAvailable(surface,w,h)`（`:566-572`）→ 记 `surfaceWidth/Height` → `startRenderThread(surface,w,h)` → `updateTransform()`。
- `startRenderThread`（`:613-635`）：**全局互斥**——`static FFmpegTexturePlayerView activeRenderer`（`:55`），`synchronized(FFmpegTexturePlayerView.class)` 内若已有别的实例在渲染就打日志 `"Another renderer is active, skip starting"` 并**直接返回**（`:615-619`）；同实例且线程活着则只 `updateSize(w,h)`（`:622-628`）。
- `RenderThread`（`:659-835`，线程名 `FFmpegTextureRenderThread`，`:674`）：`run()` 先 `initEgl()`，成功后 `ffmpegWrapper.getInstance().onSurfaceCreated(null,null)`（`:709`，异常只记日志不致命），再 `applySurfaceSizeIfNeeded(true)`，然后循环 `onDrawFrame(null)` + `EGL14.eglSwapBuffers` + `Thread.sleep(16)`（`:714-730`）；`eglSwapBuffers` 失败或 display/surface 为 null 则 break 并 `cleanupEgl()`。
- EGL 参数：`eglGetDisplay(EGL_DEFAULT_DISPLAY)`、`eglInitialize`；`eglChooseConfig` 属性表 `{EGL_RECORDABLE_ANDROID(0x3142)=1? -> 12352=0x3040 EGL_BUFFER_SIZE,4, 12324=0x3024 EGL_BLUE_SIZE,8, 12323=0x3023 EGL_GREEN_SIZE,8, 12322=0x3022 EGL_RED_SIZE,8, 12321=0x3021 EGL_ALPHA_SIZE,8, 12325=0x3025 EGL_DEPTH_SIZE,0, 12326=0x3026 EGL_STENCIL_SIZE,0, 12344=0x3038 EGL_NONE}`（`:776`）；`eglCreateContext` 用 `{12440=0x3058 EGL_CONTEXT_CLIENT_VERSION, 2, 12344}` 即 **GLES 2.0**（`:785`）；`eglCreateWindowSurface` 用 `new Surface(surfaceTexture)`（`:790-791`），失败路径会 `surface.release()`（`:793`、`:799`）。
- 尺寸变化：`onSurfaceTextureSizeChanged`（`:575-584`）→ `renderThread.updateSize(w,h)`（只置 `pendingWidth/Height + sizeChanged`，`synchronized(lock)`，`:693-700`），由渲染线程下一帧 `applySurfaceSizeIfNeeded` 消费后调 `onSurfaceChanged(null,w,h)`（`:738-762`）。
- 销毁：`onSurfaceTextureDestroyed`（`:587-591`）→ `stopRenderThread()`（**不**调 `surfaceTexture.release()`，返回 `true` 让系统释放）→ `requestStop()` + `join(1500ms)` + 置空 + 清 `activeRenderer`（`:637-655`）；`cleanupEgl()` 顺序为 `eglMakeCurrent(NO_SURFACE,NO_SURFACE,NO_CONTEXT)` → `eglDestroySurface` → `eglDestroyContext` → `eglTerminate` → `windowSurface.release()` 并把 5 个 EGL 字段置 null（`:811-834`）。
- `release()`（`:556-563`）：`cancelRetry()` → `stop()` → `stopRenderThread()` → `callback = null` → `nativePlayingListener = null`。
- **错误重建路径**：native 报 `what == 1`（停止）或首帧超时，都走 `scheduleRetry()`，重试只是重新 `startPlayback(currentUrl, ...)`（`:514-522`），**不重建 Surface**；EGL 侧的重建只发生在 `initEgl()` 失败时（直接 `cleanupEgl()` 退出线程，`:704-707`），要恢复必须等 `onSurfaceTextureAvailable` 再来一次。
- 画面变换：`buildContentTransform(viewW,viewH,videoW,videoH,rotationDegrees)`（`:186-206`）——`min(scale)` 后**乘 1.78 的固定系数**（`:198-199`，两处 `* 1.78f`，与画面比例硬耦合）；`resolveVideoSize()` 拿 `naGetVideoRes()`，取不到就退回 **16:9**（`:593-611`）；`updateTransform()` 强制主线程（非主线程 `post`，`:226-240`）。

`FFmpegPlayerView`（GLSurfaceView，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java`）：把渲染完全交给 `GLSurfaceView` + `ffmpegWrapper.getInstance()` 作为 `Renderer`（`:193-194`），三个回调 `onSurfaceCreated → naInitDrawFrame()`（`:679-681`）、`onSurfaceChanged(w,h) → naSetup(w,h)`（`:685-687`）、`onDrawFrame → naDrawFrame()`（`:691-693`）；`onDetachedFromWindow()` 只 `cancelRetry()`（`:673-675`），**不 release native**——真正清理靠 `release()`/`stop()`；`bindStatusHandler()` 会在 `play/pause/resume/saveSnapshot` 前重新把 `statusHandler` 绑给 native（`:196`、`:213`、`:347`、`:354`、`:480`、`:702-705`），用于对抗 native 单实例只记最后一个 handler 的问题。

GSY 路的 Surface 由 `IjkPlayerManager.showDisplay(Message)` 管：`message.obj == null` 时 `mediaPlayer.setSurface(null)`，否则 `setSurface((Surface) msg.obj)` 且要求 `surface.isValid()`（`_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/player/IjkPlayerManager.java:102-114`）。

### 4.6 失败重试与超时

| 项 | 值 | 位置 |
|---|---|---|
| 自研播放器最大重试次数 | `5`（`MAX_RETRY_COUNT`，`retryCount >= 5` 即放弃） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:52`、`:470-483`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:49`、`:389-404` |
| 重试间隔 | 固定 `500 ms`（`Handler.postDelayed`，非指数退避） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:53`、`:510`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:50` |
| 重试前回调 | `callback.onRetrying(retryCount, 5)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:496-499`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:415` |
| 放弃时的错误 | 无 callback → 只打日志；有 callback → `onError(lastError ?: getString(R.string.connection_failed_max_retry))` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:473-481` |
| 首帧超时 | `15000 ms`，轮询 `50 ms` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegFirstFrameMonitor.java:47` |
| 手动重连延时 | `300 ms` 后 `play(currentUrl, ...)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:439-453`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:359-374` |
| 等 RTSP 真正关闭 | `stopAndAwaitRtspClosed(timeoutMs = 5000)`，轮询 `naStatus() != E_PlayerStatus_Stoped` 每 `20 ms`；`timeoutMs <= 0` → `IllegalArgumentException("timeoutMs must be greater than 0")` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:318-323`、`:343-345`、`:396-407`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:270-327`（超时会打 `"Timed out waiting for RTSP session close after N ms"`，`:323`） |
| 截图超时 | `SNAPSHOT_TIMEOUT_MS = 3000`（`naSaveSnapshot` 返回非 0 立即失败 `"save snapshot failed: <code>"`） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:53`、`:488-494` |
| 渲染线程 join | `1500 ms` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegTexturePlayerView.java:644` |
| GSY/ijk 缓冲超时 | `BUFFER_TIME_OUT_ERROR = -192`（库内定时器上报） | `_work/tuwin_src/sources/com/shuyu/gsyvideoplayer/GSYVideoBaseManager.java:30`、`:59` |
| ijk 回放自动重连 | option `reconnect = 5` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/VideoUtil.java:98` |
| 会话层收尾 | `MediaSessionCoordinator.cleanup()` 在 `NonCancellable` 上下文里跑：置 `STOPPING` → dispose 路由监听 → `player.requestStop()`（异常吞掉）→ `awaitClosed()` → `player.release()`（异常吞掉）→ `bindingLease.close()` → `routeLease.close()` → 终态 `CLOSED`（无 failure）或 `FAILED`（有 failure） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/MediaSessionCoordinator.java:580-655`、`:659-662` |
| native 失败 | `onError` → 记 `session.failure`、写 `MediaState.FAILED`（带当前 `route.revision`）、`monitorJob.cancel(CancellationException("Native player failed", error))`、`startJob.cancel(同)` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/media/MediaSessionCoordinator.java:510-528` |

**编排层不做自动重连**：`MediaSessionCoordinator` 里没有任何 retry/delay，重试全在 View 层（上表前 5 行）；一旦 View 放弃并回调 `onError`，会话直接进 `FAILED` 并释放路由，需要用户重新点播放。路由变更（`routeRevision` 变了）由 `start()` 里注册的监听触发 `cleanup`，属于「换路由即重建」，不是重试。

---

## 5. 事件与状态推送

包里有**两套并行的事件机制**：老的 greenrobot EventBus（`core/event/*` 的 5 个类，给 UI 页面间广播用）和新的 Flow 状态层（`DeviceSessionManager` / `MediaStateStore` / `core/network/*`，给设备会话与播放状态用）。二者不互通：没有任何 `core/event` 类被 Flow 侧引用，也没有任何 Flow 被 post 进 EventBus。

### 5.1 `core/event` 消息类型枚举与取值

**先说结论：这一包里没有枚举、也没有任何数值码**，5 个文件就是 5 个 EventBus 事件标签类（`_work/re/tuwin/api/com__tuwinsmart__tuwin__core__event.md` 全量 5 类型；`_work/re/tuwin/catalog-consts.md` 里 `com.tuwinsmart.tuwin.core.event.*` 零条目；`_work/re/tuwin/own-constants.tsv` 里整包只有 1 条 `MSG_` 常量且不属于本包）。逐个抄：

| 事件类 | 载荷 | 位置 | 生产者（post） | 消费者（@Subscribe） |
|---|---|---|---|---|
| `DeviceAddedEvent` | 无字段（空类） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/DeviceAddedEvent.java:9` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java:1058`、`:1119`；`presentation/p010ui/device/list/DeviceListActivity.java:342`；`presentation/p010ui/mine/MoreSettingsActivity.java:2463` | `presentation/p010ui/connect/fragment/ConnectFragment.java:860`（`@Subscribe(threadMode = MAIN)`） |
| `NetworkChangeEvent` | `List<Network> networks`（可空） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/NetworkChangeEvent.java:11-19` | `core/util/network/NetworkManager.java:64`、`:101`、`:104`（`postSticky`；`:101` 传的是 `null`） | `presentation/p010ui/connect/fragment/ConnectFragment.java:837`、`:847`（`@Subscribe(sticky = true, threadMode = MAIN)`，收完 `removeStickyEvent`） |
| `SoftVersionUpdateCompleteEvent` | 无字段 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/SoftVersionUpdateCompleteEvent.java:9` | `core/util/UpgradeHelper.java:137`、`:354`（`postSticky`） | `presentation/p010ui/connect/fragment/ConnectFragment.java:847` 同族 sticky 订阅 |
| `TaskDownloadFinishEvent` | 无字段 | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/TaskDownloadFinishEvent.java:9` | `core/util/download/DownloadFileExecution.java:384`；`core/util/download/DownloadUtil.java:1524`、`:2558` | `presentation/p010ui/album/fragment/AlbumFragment.java:620`（`@Subscribe(threadMode = MAIN)`） |
| `TaskFinishInsertEvent` | `DownloadTask task`（`com.lzy.okserver.download.DownloadTask`，data class） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/event/TaskFinishInsertEvent.java:11-46` | `presentation/p010ui/download/adapter/DownloadItemViewHolder.java:125` | `presentation/p010ui/download/fragment/LocalDownloadListFragment.java:124` |

EventBus 注册点只有 3 个页面：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/fragment/AlbumFragment.java:91-92`（注册）/`:665-666`（注销）、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:199-200`/`:971-972`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/download/fragment/LocalDownloadListFragment.java:99-102`/`:136-137`。另有非 `core/event` 的 sticky 事件 `EnterBean`（`presentation/p010ui/album/ShowPicsActivity.java:325`、`:331`、`:337` post，`:86` `removeStickyEvent` 取回）——说明 sticky 总线被复用来传相册上下文。

**真正「带取值的消息类型」在 socket 层**：M3 设备推送消息 `M3SocketMessage`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`）是 8 个分支的 sealed 家族，判别键是 JSON 里的**字符串** `msgid`（不是数字）：

| `msgid` | 消息类 | 载荷字段 | 解码位置（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3JsonMessageDecoder.java`） |
|---|---|---|---|
| `rec_time` | `M3SocketMessage.RecordingTimeUpdate` | `int recConsumTime`、`int recFileTime`、`long time` | `:71-76`（字段默认 `recConsumTime=0`） |
| `battery` | `BatteryUpdate` | `M3BatteryInfo info`（含 `capacity`）、`long time` | `:78-83` |
| `sd` | `SDCardUpdate` | `int status`（**缺省 99**）、`long time` | `:85-90` |
| `cap` | `CaptureUpdate` | `int value`、`long time` | `:92-97` |
| `mic` | `MicUpdate` | `boolean isMicOn`（`value == 1`）、`long time` | `:99-104` |
| `rec` | `RecordingUpdate` | `boolean isRecording`（`value == 1`）、`long time` | `:106-111` |
| `countdown_time` | `CountdownTimeUpdate` | `int value`、`long time` | `:113-118` |
| 其它 / JSON 解析失败 / 空帧 | `Unknown(rawMessage)`（整帧原文） | `String rawMessage` | `:121`、`:130`；空串直接 `return null`（`:33-35`） |

字段取法：`decode()` 先 `trim` 再 `JsonParser.parseString`，读 `msgid`（非 primitive 视为 `""`）与 `info`（非 object 视为 `null`），`switch` 按 `hashCode` 分派（`:40-68`）。

### 5.2 `core/process` 消息类型枚举与取值

`core/process` **只有一个类**，没有任何消息/事件枚举（`_work/re/tuwin/api/com__tuwinsmart__tuwin__core__process.md` 全文 1 类型 / 2 方法）：

- `AppProcessRole`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/process/AppProcessRole.java`）
  - 唯一常量：`public static final String INTERNET_PROCESS_SUFFIX = ":internet"`（`:19`）——**没有数值型码表**。
  - `isInternetProcess(context)`（`:26-56`）：`Build.VERSION.SDK_INT >= 28` → `Application.getProcessName()`（`:30`）；否则 `getSystemService("activity")` → `ActivityManager.getRunningAppProcesses()` 线性找 `pid == Process.myPid()` 取 `processName`（`:34-53`）；返回 `processName == context.packageName + ":internet"`（`:55`）。
- 进程分工由 manifest + `TuwinApplication` 决定，不是消息路由：
  - `com.tuwinsmart.tuwin.presentation.ui.internet.ExternalWebActivity` 声明 `process=:internet`（`_work/re/tuwin/manifest.md:131`）；友盟 `com.efs.sdk.memleaksdk.monitor.UMonitorService` 声明 `process=:u_heap`（`:150`）。
  - 跨进程只共享一个 `ContentProvider`：`com.tuwinsmart.tuwin.core.internet.InternetRouteRevisionProvider`，`authorities=com.tuwinsmart.tuwin.internetRouteRevision`（`_work/re/tuwin/manifest.md:177`）；另有 `com.noober.background.BackgroundContentProvider`（`multiprocess=true`，`:179`）。
  - `TuwinApplication.onCreate()`：`:261` 先装 `AppCrashHandler`，`:263` 判进程；**`:internet` 分支只做 `WebView.setDataDirectorySuffix("internet")`（且要求 SDK ≥ 28，`:264-265`）**；主进程分支才跑 `Gloading.initDefault`（`:268`）、`UmengSdkBridge.preInit(app, UMENG_APP_KEY, UMENG_CHANNEL)`（`:269`）、`initKoin()`（`:270`）、`startPreConsentNetworkRuntime()`（`:271`）、`initThirdLibs()`（`:272`）。**即 `:internet` 子进程里没有 Koin、没有 NetworkRuntime、没有设备会话**，联网设备面全部在主进程。

数值化的「消息」实际散在别处，与 TUWIN 相关的三张码表（供交叉引用）：

| 类 | 常量 = 值 | 位置 |
|---|---|---|
| `FFmpegPlayerView` | `STATUS_PLAYING = 0`、`STATUS_STOPPED = 1`、`STATUS_BUFFERING = 4`（native → View 的 `Message.what`；`2` 是截图完成，无常量名） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/widget/video/FFmpegPlayerView.java:54-56`、`:178-181` |
| `UpgradeDevice` | `MSG_UPLOAD_FAILED = 10003`（`private static final int`，全库唯一 `MSG_` 常量） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UpgradeDevice.java:38`（`own-constants.tsv` 同行记录）、分发见 §3.5 |
| `M3ControlChannelState` | `READY / RECOVERING / RECOVERABLE / UNAVAILABLE`（无 ordinal 码） | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/p005m3/M3ControlChannelState.java:11-15` |

### 5.3 Flow 共享策略（回放 / 缓冲 / 并发）

**整个 `com.tuwinsmart` 里没有任何 `shareIn` / `stateIn`**（对 `_work/tuwin_src/sources/com/tuwinsmart/**` 全文 grep `shareIn`、`stateIn(` 只命中 6 处同名字段 `Ride5HourlyPlaybackActivity.shareInProgress`，是个「正在分享」布尔位，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/ride5/Ride5HourlyPlaybackActivity.java:175`）。所有热流都是**手写单实例 `MutableStateFlow` / `MutableSharedFlow` + `asStateFlow` / `asSharedFlow` 只读投影**，没有引用计数、没有 `SharingStarted`。

**SharedFlow 参数逐条**（`SharedFlowKt.MutableSharedFlow$default(replay, extraBufferCapacity, onBufferOverflow, mask, null)`，形参序为 `replay, extraBufferCapacity, onBufferOverflow`，见 `_work/tuwin_src/sources/kotlinx/coroutines/flow/SharedFlowKt.java:32`；mask 低位含 4 ⇒ `onBufferOverflow` 用默认 `BufferOverflow.SUSPEND`）：

| 流 | replay | extraBufferCapacity | onBufferOverflow | 暴露方式 | 位置（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/`） |
|---|---|---|---|---|---|
| 设备会话事件 `_events` | `0` | `64` | SUSPEND（mask 4） | `asSharedFlow` → `events(sessionId)` | `core/device/DeviceSessionManager.java:474`、`:478`、`:209` |
| M3 socket 消息 `_messages` | `0` | `64` | SUSPEND（mask 5 ⇒ replay 也取默认 0） | `asSharedFlow` → `getMessages()` | `core/device/p005m3/DefaultM3SocketConnector.java:362-363`、`:367`、`:378` |
| M3 socket 故障 `_failures` | **`1`** | `1` | SUSPEND（mask 4） | `asSharedFlow` → `getFailures()` | `core/device/p005m3/DefaultM3SocketConnector.java:364-365`、`:368` |
| Ride5 回调事件 `_events` | `0` | `64` | SUSPEND（mask 5） | `asSharedFlow` → `events` | `core/device/ride5/Ride5CallbackChannel.java:138-140` |
| Wi-Fi 扫描 UI 事件 `_wifiScanEvents` | `0` | `1` | SUSPEND（mask 5） | `asSharedFlow` | `presentation/dialog/ConnectDialogViewModel.java:142-144` |

即：**只有 M3 的故障流带 1 帧回放**（保证稍后开始采集的恢复逻辑仍能看见最近一次断连原因），其余事件流全部不回放、靠 64 深度缓冲吸收突发。

**StateFlow 清单（都是 `MutableStateFlow(initial)` + `asStateFlow`）**：

| 流 | 初值 | 位置 |
|---|---|---|
| 会话快照 `_state` | 调用方传入的 `initial` | `core/device/DeviceSessionManager.java:472`、`:477`；查询 `state(sessionId)` `:204` |
| 播放状态 | 按 `(sessionId, mediaSessionId)` 惰性建 key，初值 `MediaStateSnapshot(..., IDLE, null, null)`，容器是 `ConcurrentHashMap` | `core/media/MediaStateStore.java:93`、`:101-115` |
| 联网路由 | `revisions.unavailable(NetworkPlane.INTERNET)` | `core/network/InternetRouteController.java:64`、`:66` |
| 网络拓扑 | `emptyMap()`；变更流初值 **`null`** | `core/network/NetworkTopologyMonitor.java:63`、`:65`、`:67-68` |
| 传输任务状态 | `TransferState.Queued`（`putIfAbsent` 建键） | `core/transfer/ScopedTransferQueue.java:164`、`:223-227`、`:247` |
| App 自更新状态 | `AppUpdateCheckState.IDLE` | `core/update/AppUpdateCoordinator.java:134`、`:136` |
| 相机 OTA 进度 | `DeviceOtaProgress(DeviceOtaState.IDLE, null, null, …)` | `core/update/DeviceOtaCoordinator.java:70`、`:72` |
| 固件版本列表刷新位 | `0L` | `core/util/UpgradeHelper.java:100`、`:102` |
| 连接对话框 | `ConnectState.Idle` / `DeviceWifiScanState.Idle` | `presentation/dialog/ConnectDialogViewModel.java:136-141` |
| 连接页 | `emptyList()` / `ConnectionStatus.Idle` | `presentation/p010ui/connect/fragment/ConnectViewModel.java:111-116` |
| 回放互斥闸门 | `false`（**static**，进程级单例） | `presentation/p010ui/album/Ride3ProPlaybackConflictGate.java:28` |

**并发与异常处理策略**（这些流没有 `retry*`，一律「把异常变成数据」或「取消即终点」）：
- 采集循环：`DeviceSessionManager.ManagedDeviceSession.startEventCollection(events, revision)` 先 `cancel` 旧 `eventJob` 再 `launch(sessionScope)` 一个新的 `collect`（`core/device/DeviceSessionManager.java:1627-1633`）。collector 里三道过滤：`closed.get()`、`route == null`、`route.revision != revision` → 直接丢弃（`core/device/DeviceSessionManager$_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/DeviceSessionManager$ManagedDeviceSession$startEventCollection$1.java:66`）；随后 `ControlChannelFailed`/`RouteSuperseded` 且当前态不在 `{CLOSING, CLOSED}` → 写 `DeviceSessionState.DEGRADED`（同文件 `:69-72`）；最后原样 `_events.emit(event)`（同文件 `:74`，**挂起式 emit，背压回 socket**）。
- M3 事件源：`socketEvents(socket) = merge(messages.map { ProtocolMessage(it) }, failures.map { ControlChannelFailed(it) })`（`core/device/p005m3/M3DeviceAdapter.java:750-753`、`:806`、`:826`）；Ride5 是 `when` 映射：`Frame → ProtocolMessage(frame.value)`、`SourceRejected → ProtocolMessage(event)`、`Failed → ControlChannelFailed(cause)`（`core/device/ride5/Ride5DeviceAdapterSession.java:642-650`）。
- 下游只按类型过滤而不 catch：`M3SessionRepositoryFactory` 用 `filterIsInstance<ProtocolMessage>` + `mapNotNull { payload as? M3SocketMessage }` 把事件流转成仓库内消费的消息流（`core/device/p005m3/M3SessionRepositoryFactory.java:316`、`:391`）；`Ride5DeviceDetailViewModel` 同样只挑 `ProtocolMessage`（`presentation/p010ui/device/detail/Ride5DeviceDetailViewModel.java:105`）。
- 轮询侧把异常包成结果对象：`requestOnce` 的 `catch (CancellationException) { throw e }` + `catch (Throwable) { Failed(sessionId, th) }`（`core/device/ride3pro/Ride3ProPollingStatusChannel.java:444-447`），HTTP 业务失败也转 `Failed`（`:443`）。
- 唯一显式 `catch` 操作符在相册事件仓库：`distinctUntilChanged(catch { ... })`（`data/repository/RecordingControlEventRepositoryImpl.java:193`），配合 `RecordingControlEventsView` 的 `flowOn(...)`（`presentation/widget/RecordingControlEventsView.java:262`）。
- 派生状态流用 `distinctUntilChanged`：`M3SessionRecoveryController.states(sessionId)` = `sessions.state(sessionId).map{…}.distinctUntilChanged()`，会话不可用时退化为 `flowOf(UNAVAILABLE)`（`core/device/p005m3/M3SessionRecoveryController.java:51`、`:63`、`:66-69`）。
- Ride5 回调通道混用两种发射：背压敏感的错误用挂起 `emit`（`core/device/ride5/Ride5CallbackChannel.java:392`、`:455`、`:647`、`:663`），高频拒绝帧用 `tryEmit`（`:423`、`:441`、`:618`）——**`tryEmit` 在缓冲满时静默丢事件**。

### 5.4 推送断线后的恢复策略

**M3 靠 socket 推送驱动**：`BatteryUpdate / SDCardUpdate / RecordingUpdate / RecordingTimeUpdate / MicUpdate / CaptureUpdate / CountdownTimeUpdate` 经 `ProtocolMessage` 进会话事件总线，再由 `M3SessionRepositoryFactory` 造的仓库消费，最终落到设备详情页状态（`presentation/p010ui/device/detail/M3DeviceDetailActivity.java` / `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/device/detail/Ride5DeviceDetailViewModel.java:105`）；`failures` 流则只驱动「控制面坏了」这一件事。**M3 不做周期轮询**（`DefaultM3SocketConnector.java` 里 `reconnect|retry|delay` 关键字 0 命中）。

**Ride3Pro 靠 HTTP 轮询驱动**：`Ride3ProHeartbeatManager` 用 `Ride3ProPollingStatusChannel` 拉 `/api/device/status`。
- 常量：`HEARTBEAT_INTERVAL_MS = 30000`、`MAX_RETRY_COUNT = 3`、`RETRY_DELAY_MS = 500`（`_work/re/tuwin/catalog-consts.md:1340-1342`，源码 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:36-38`；通道侧同名默认 `DEFAULT_INTERVAL_MS = 30000`、`DEFAULT_MAX_RETRY_COUNT = 3`、`DEFAULT_RETRY_DELAY_MS = 500` 且已 `@Deprecated`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java:37`、`:40`、`:43`）。
- 结构不变式：`intervalMs / maxRetryCount / retryDelayMs` 任一为负即 `IllegalArgumentException("Failed requirement.")`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java:113-121`）。
- 一轮 `pollOnce` 内失败最多重投 `maxRetryCount` 次，每次 `delay(retryDelayMs)`，日志 `"Ride3Pro: session 心跳失败，准备重试 N/3, session=…"`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/device/ride3pro/Ride3ProPollingStatusChannel.java:241-268`）；executor 为 null、会话不存在或 `sessionId` 不符 → `SkippedNotReady`（`:204-221`、`:280-283`、`:344-348`）。
- 驱动的状态：`Updated(sessionId, routeRevision, snapshot)` → `updateStatusStore(...)` → `Ride3ProStatusStore.activateSession(...)` + `Ride3ProConnectionSnapshot`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:284-289`、`:320-330`；快照字段映射 `currentMode / batteryPercent / adapterStatus / exceptionFlags / hdrChkCnt`，`core/device/ride3pro/Ride3ProPollingStatusChannelKt.java:11-14`）。心跳结果带旧 `routeRevision` 会被丢弃并打日志 `"Ride3Pro: 丢弃旧 route revision 心跳结果 session="`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:325-330`）。
- 生命周期闸门：`lifecycleAllowed` 由 `!shouldSuppressHeartbeat()` 提供（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java:255-262`），页面不可见即停发；`startForSession` 在 sessionId + routeRevision 都未变时直接复用旧 job（`:276-282`），否则 `stop()` 重建（`:283-289`）。

**断线后谁负责重建（按层）**：
1. **路由层**（唯一的自动重建者）：`DeviceSessionManager.routeRevisionChanged(change)`（`core/device/DeviceSessionManager.java:352-369`）——非 `NetworkPlane.DEVICE` 直接忽略（`:354-356`）；`RouteState ∈ {LOST, UNAVAILABLE, REJECTED}` 时 `invalidateForRoute` **并额外 launch 一个重建 job**（`:357-363`）；其它状态只 `invalidateForRoute`（`:364-368`）。注意它本身**不重新 open 会话**，重建由被 launch 的 `…$routeRevisionChanged$1$1` 完成。
2. **会话层**：`invalidateForRoute(route)`（`core/device/DeviceSessionManager.java:1737-1756`）丢弃 `activeAdapter`、`cancel` 主 job 与 `eventJob`、把非终态快照写 `DeviceSessionState.DEGRADED`（`:1751-1753`）、再 launch 重建；`cancelForRoute(cause)`（`:1758-1766`）用 `CancellationException(cause.message, cause)` 取消整条会话。
3. **控制面层（M3）**：`M3ControlChannelState` 由会话态映射（`core/device/p005m3/M3SessionRecoveryController.java:126-134`）：无有效端点 → `UNAVAILABLE`；`READY` → `READY`；`OPENING_CONTROL_CHANNEL` → `RECOVERING`；`DEGRADED` → `RECOVERABLE`；其余 → `UNAVAILABLE`。`recover(sessionId)`（`:160` 起，`Result<Unit>` 返回）在能力位 `M3_HTTP_CONTROL`（`:39`）校验通过后转 `M3AdapterSession.recoverControlChannel()`（`core/device/p005m3/M3DeviceAdapter.java:442`），后者在**新 `RouteLease` 的 `withCancellation` 作用域**里重开 socket 并把新路由塞回结果（`:491-497`）。**socket 自身不会重连**，只有这条路径会。
4. **播放层**：native 播放器在 View 内部自愈（`5 × 500 ms`，见 §4.6）；`MediaSessionCoordinator` 只会 `requestStop → awaitClosed → release → close leases` 后进 `CLOSED/FAILED`（`core/media/MediaSessionCoordinator.java:580-655`），`onError` 直接把 `monitorJob`/`startJob` 取消（`:510-528`），**不做重连**，需上层重新 `start()`。
5. **UI 层**：EventBus 的 `NetworkChangeEvent` 是 sticky 的，页面重新注册即可拿到最后一次拓扑变化（`core/util/network/NetworkManager.java:64`、`:101`、`:104` + `presentation/p010ui/connect/fragment/ConnectFragment.java:837-847`），这是「断线后 UI 能自洽」的机制，不是重连机制。

**静态无解 + 补证手段**：`DeviceSessionManager.routeRevisionChanged` 里 launch 的 `…$routeRevisionChanged$1$1` 具体是否重新 `open()` 会话（还是只标脏），本次只确认了 job 存在与调用点（`core/device/DeviceSessionManager.java:361`），其 `invokeSuspend` 主体未逐行核对；补证手段是把该类跑一遍 `jadx --show-bad-code` 或在真机上按 §1.3 的时序断言：断开设备 AP 后观察是否出现第二次 `Adapter open` 日志。

---

## 6. 遥测与三方 SDK

> 扫描口径先交代：`_work/re/tuwin/signals-summary.md` 第 5 行写明 `signals-*.tsv` 只覆盖**厂商自有代码**（`com/tuwinsmart/**` 字面量 55,917 条）——友盟/efs/OSS 等内嵌库自己拼的遥测 URL **不在** `signals-fullUrls.tsv`/`signals-hosts.tsv` 里。所以本节把表拆成 A（signals 内，厂商侧）与 B（signals 外，库侧补测），B 才是"反编译包里出现域名 ≠ 它在用"的重灾区。
> 一句话结论：**全 APK 只有一套统计+崩溃上报 = 友盟 U-App + U-APM（`com.efs`）**，且被隐私同意闸门挡住；没有 Bugly / Sentry / Firebase / Countly / 自建埋点（`com/` 顶层目录无这些包；`com/tuwinsmart/**` 对 `MobclickAgent` 零命中）。厂商自有的"上报"只有两件事：崩溃写本地文件（`AppCrashHandler`，无网络）与反馈/日志上云（`http://ali.tuwinsmart.com/feedback` + 阿里 OSS，见 6.2/6.3）。

### 6.1 统计与崩溃 SDK：友盟 / com.efs / libucrash / libumonitor / libumeng-spy

**接入方式是反射桥**，TUWIN 编译期不依赖友盟：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java:19` 定义 `UM_CONFIGURE_CLASS_NAME = "com.umeng.commonsdk.UMConfigure"`，`:198-212 resolveClass` 用 `Class.forName`，类不存在时全部静默返回 `false`。本 APK 里该类真实存在（`_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java`），所以反射**必然命中**。

| 常量 | 值（原样） | 位置 |
|---|---|---|
| `UMENG_APP_KEY` | `6781b8f38f232a05f1f56ef5` | `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:148` |
| `UMENG_CHANNEL` | `Umeng` | 同上 `:149` |
| `RELEASE_CHANNEL` | `stable` | 同上 `:146`（App 自更新去重键用，§3.7） |
| `SERVER_ENVIRONMENT` | `production` | 同上 `:147` |
| `INTERNET_WEBVIEW_DATA_DIRECTORY_SUFFIX` | `internet` | 同上 `:145` |

manifest 里**没有任何友盟 appkey meta-data**（全应用 meta-data 共 6 条，均 androidx/azhon，`_work/re/tuwin/manifest.md:195-202`）——key 只在运行时经反射注入，静态清单不可见。efs 侧唯一注册组件是 `com.efs.sdk.memleaksdk.monitor.UMonitorService`（`process=:u_heap`，`_work/re/tuwin/manifest.md:150`）。

**Application 路径调用链（两级闸门）**：

1. `TuwinApplication.onCreate`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:258`）→ `:261` `AppCrashHandler.install` → `:263` 判进程（`:internet` 子进程只设 WebView 数据目录后缀，**不碰友盟**）→ 主进程 `:269` `UmengSdkBridge.preInit$default(..., UMENG_APP_KEY, UMENG_CHANNEL, ...)`。preInit 在 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java:89` 反射调 `UMConfigure.preInit(context, appKey, channel)`——**发生在隐私同意之前**，但按友盟契约 preInit 不落网不上报。
2. `initThirdLibs()`（`:305`）整体被 `:306` `PreferenceHelper.isAgreePrivacy()` 门住；调用点两个：`onCreate :272`（未同意则空转）与首页 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java:331`（同意后补跑）。同意后顺序：`:308-310` `WriteRuntimeLogTree.init()+Timber.plant`（自有日志树）→ `:352` `UmengSdkBridge.init$default(..., UMENG_APP_KEY, UMENG_CHANNEL, ...)` → `:353` **再装一次** `AppCrashHandler.install`。
   `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java:125-150 init` 先反射读 `UMConfigure.DEVICE_TYPE_PHONE` 静态字段（`:185`；字段存在且 =1，`com/umeng/commonsdk/UMConfigure.java:61`），再在 `:140` 反射调 `UMConfigure.init(ctx, appKey, channel, 1, null)`（第 5 参 pushSecret = null）。因为第 3 步安装顺序在 `:352` 之后，`AppCrashHandler` 的 `DelegatingHandler` 会**包住友盟的 handler**：崩溃先写本地文件，再委托友盟上报（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/AppCrashHandler.java:102-104`）。

**init 之后 SDK 内部真实发生的链**（决定 6.2-B 表里"真会访问"那批域名）：

- `_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java:353`：`getClass("com.umeng.umzid.ZIDManager") == null` 判空——类存在，通过；`:542-551`：反射 `com.umeng.umcrash.UMCrash` 并调 `UMCrash.init(applicationContext, sAppkey, sChannel)`（sAppkey 即上面那个 key）。
- `_work/tuwin_src/sources/com/umeng/umcrash/UMCrash.java:700` `init` → `:981` 起 `PAFactory`/`EfsReporter`；`:864-942` 注册 ActivityLifecycle 驱动 `PowerManager`（启动/卡顿）、`PageManger`、`ULogManager`、`MemLeakManager`（`com/umeng/umcrash/custominfo/UAPMCustomInfo.java:28`）——即 **U-APM 全家桶（崩溃+内存+页面+启动）随 init 激活**。
- efs 上报端点选择：`_work/tuwin_src/sources/com/efs/sdk/base/core/controller/ControllerCenter.java:110-115`——`isIntl()` 为 false 走 **`https://errnewlog.umeng.com/api/crashsdk/logcollect`（license 常量 `28ef1713347d`）**，true 走 `errnewlogos`（`4ea4e41a3993`）；默认值同 CN（`com/efs/sdk/base/internal/C1040z0.java:10`）。
- 云配置触发器：`_work/tuwin_src/sources/com/umeng/commonsdk/internal/C3221c.java:613`、`:796` 在 init 流程里 `UMWorkDispatch.sendEvent(..., CLOUD_CONFIG_TRIGGER, 延时5000ms)` → `:699-719` 收到后 `CcgAgent.init(context)` 并注册配置回调 → ccg worker `com/umeng/ccg/C3177d.java:831/:861/:973/:1292/:1336/:1385` 把 `cnlogs.umeng.com/*`、`ucc.umeng.com`、`aspect-upush.umeng.com` 的 Runnable 排进调度器执行上报。
- zid：`com/umeng/umzid/ZIDManager.java:135/:318/:387` 使用 `https://utoken.umeng.com`；`_work/tuwin_src/sources/com/umeng/commonsdk/internal/C3221c.java:124` 反射取用。

**四个原生库**（均只有 arm64-v8a，尺寸见 `_work/re/tuwin/natives.md:17-20`）：

| 库 | 谁加载 | 判定 |
|---|---|---|
| `libucrash.so`（+`libucrash-core.so`） | `_work/tuwin_src/sources/com/umeng/crash/C3291c.java:99`、`:147`、`:195` `System.loadLibrary("ucrash")`，由 UCrash init 链驱动 | **随同意后的 init 激活**，负责 native crash/ANR 捕获，落盘后经 `errnewlog` 上报 |
| `libumonitor.so` | `com.efs.sdk.memleaksdk.*`（堆内存泄漏监控，含 `UMonitorService` `:u_heap` 进程，manifest.md:150）；**反编译树内找不到 `loadLibrary("umonitor")`** | 库在用（Service 已在 manifest 注册），loader 在未喂给 jadx 的 `classes3.dex`（同 §4.1 的缺证面）；补证手段：单独反编译 `classes3.dex` 或在 `:u_heap` 进程存活时看 `adb shell ps` |
| `libumeng-spy.so`（398 KB，最大的一颗） | 反编译树内**零引用**（`umeng-spy`/`umeng_spy` 全库 grep 无 `loadLibrary`）；友盟安全/反调试组件，惯例由 commonsdk 服务在 `classes3.dex` 里加载 | 同上，缺证于 `classes3.dex`；它的 `natives.md` 导入表含 `connect`，具备联网能力，但本包静态无法证明被调用 |
| （对照）`libdatastore_shared_counter.so` | androidx DataStore 自带 | 与遥测无关，§6.3 |

**TUWIN 自己的上报面逐个确认**：
- 崩溃：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/AppCrashHandler.java:32-41`——`install` 把 `DelegatingHandler(processName, File(cacheDir,"CLOG"), previous)` 设为默认 handler；`uncaughtException`（`:92-110`）用 `CrashLogStore.write` 把堆栈+元数据（`:112-123`：`session_id/app_version_code=250/device/android_sdk` 等 8 键）写本地文件，**全程零网络**。
- Bugly：**无**（`com/bugly` 包不存在）。Sentry / Firebase Analytics / Countly / GrowingIO / SensorsData：**均无**（`com/` 顶层清单只有 alibaba, azhon, bskim, bumptech, danikula, efs, flyco, github, google, hjq, ihsanbal, jakewharton, lzy, noober, release, shuyu, thanosfisherman, tuwinsmart, umeng, xuliwen + `io/reactivex`、`org/greenrobot`、`org/koin`、`org/repackage`、`ren/yale`、`tv/danmaku`）。
- 自建埋点：**无**——厂商代码对 `MobclickAgent` 零调用（不报自定义事件/页面），对 `com.efs` 的 import 全是 jadx 内联 `NetworkUtil.NETWORK_TYPE_WIFI` 常量的假象（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/ConnectUtil.java:11` 是 `NetworkUtil` 的 import，真正的假象在 `:45`——`getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)` 引用的只是 efs 里的 int 常量「1」，jadx 把常量来源渲染成了 import）；上云通道只有 §3.7 更新检查、`feedback` 提交与 OSS 日志上传（6.2/6.3），均为功能行为不是统计。
- 清单残留：友盟 OAID 需求往 manifest 里塞了 `com.google.android.gms.permission.AD_ID`（`_work/re/tuwin/manifest.md:68`）与 `freemme.permission.msa`（`:69`），OAID SDK 以 `org.repackage.*` 打进 analytics（6.2-A 表倒数几行）。

### 6.2 域名逐条判定：真调用 vs 死字符串

判定只有三档：**运行时真会访问**（给到把 URL 交给 HTTP 客户端/WebView 的那一行）／**库自带但本 App 未触发**／**死字符串/资源**。路径缩写 `SRC = _work/tuwin_src/sources/`。

#### 6.2-A 厂商侧（`signals-fullUrls.tsv` 全 37 行 + `signals-hosts.tsv` 去重增量）

`signals-hosts.tsv` 共 1,088 行，其中 **95% 是正则误报**：`.kt` 源文件名（`M3DeviceDetailActivity.kt`）、全限定类名（`com.tuwinsmart.tuwin.core.device.DeviceSessionManager`）、系统属性/资源键（`ro.product.model`、`line.separator`、`koin.properties`）、`android.intent.*` 等，不是主机字面量（复核命令：`cut -f4 signals-hosts.tsv | sort -u` 后按点分尾缀过滤）。下表只收真实主机/URL，另把 `signals-ips.tsv` 全 5 行（3 条相机网关 + `111.179.38.202` 两行去重 1 条）一并落表。

| 字面量 | 出现在（类:行） | 归属 | 判定 |
|---|---|---|---|
| `http://schemas.android.com/apk/res/android` | `SRC com/flyco/tablayout/CommonTabLayout.java:128`、`_work/tuwin_src/sources/com/flyco/tablayout/SegmentTabLayout.java:110`、`_work/tuwin_src/sources/com/flyco/tablayout/SlidingTabLayout.java:119` | 其它库（flyco） | **死字符串/资源**：XML 属性命名空间 URI，`obtainStyledAttributes` 消费，零网络语义 |
| `http://`（设备 URL 拼接片段） | `SRC com/tuwinsmart/tuwin/core/device/p005m3/M3DeviceAdapter.java:939`、`…/p005m3/M3SessionConnector.java:2162`（`"http://"+host+":"+port+"/"`）、`…/p005m3/M3SessionRepositoryFactory.java:673`、`…/ride3pro/Ride3ProSessionConnector.java:2035`、`…/ride3pro/Ride3ProSessionTransport.java:612`、`…/ride5/Ride5CgiGatewayKt.java:31` | 厂商自有 | **运行时真会访问（设备本地）**：相机 AP 局域网 HTTP 端点拼接，host 恒为 §1 的 192.168 网关；非外网域名 |
| `http://`（续传/目录拼接片段） | `SRC com/tuwinsmart/tuwin/core/transfer/VerifiedDeviceFileCatalog.java:844`、`SRC com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:214` | 厂商自有 | **运行时真会访问（设备本地）**：§2.1 `buildAuthorizedHttpUrl` 唯一出口即 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java:214` 的 `"http://" + host + ":" + port + "/"` |
| `rtsp://`（端点拼接片段） | `SRC com/tuwinsmart/tuwin/core/device/p005m3/M3EndpointHostPolicy.java:74`、`…/p005m3/M3SessionRepositoryFactory.java:156`、`…/ride3pro/DocumentedRide3ProMediaEndpointResolver.java:31`、`…/ride5/Ride5DeviceMediaPort.java:110` | 厂商自有 | **运行时真会访问（设备本地）**：RTSP 播放端点前缀，§4.4 交给 ijk/FFmpeg 直连相机 |
| `https://` + `http://`（OSS 公网 URL 拼装） | `SRC com/tuwinsmart/tuwin/data/source/remote/gateway/LegacyDirectCloudConfig.java:151`（`publicOssUrl`：`"https://" + bucket + "." + trimEnd(removePrefix(endpoint,"https://"),"http://") + "/" + key`） | 厂商自有（host 来自 BuildConfig） | **运行时真会访问（条件）**：6.3 OSS 日志上传链的产物 URL；endpoint 实值在未导出的 `BuildConfig.TUWIN_OSS_*`，缺证 |
| `https://`（反馈日志公网 URL 拼装） | `SRC com/tuwinsmart/tuwin/core/util/wifi/FeedbackLogUploadPolicy.java:22` | 厂商自有 | 同上：`uploaded==true` 才拼 `"https://"+bucket+"."+endpoint+"/"+key`，属产物不是请求目标 |
| `http://ali.tuwinsmart.com/` | `SRC com/tuwinsmart/tuwin/data/source/remote/gateway/FeedbackApiEndpoint.java:10`（`BASE_URL`） | 厂商自有 | **运行时真会访问**：`SRC …/gateway/RoutedInternetCloudGateway.java:96` 把它设为默认 baseUrl，`:323` `retrofitProvider.create(lease, baseUrl, TuwinSuspendApi…)`；端点 `@GET appupdatecheker/banner/newota` = `SRC …/remote/api/TuwinSuspendApi.java:17/:20/:23`（链路 §3.6/§3.7）。**明文 HTTP** |
| `http://ali.tuwinsmart.com/feedback` | 同上 `:12`（`URL`） | 厂商自有 | **运行时真会访问**：`SRC …/gateway/RoutedLegacyFeedbackGateway.java:85` `NetworkIntent.Internet("feedback_submit")` → `:186` Retrofit 以 `FeedbackApiEndpoint.BASE_URL` 建 `FeedbackApi`，`@POST("feedback")`（`SRC …/gateway/FeedbackApi.java:16`）；反馈页入口 `SRC …/presentation/p010ui/mine/FeedbackActivity.java` |
| `https://work.weixin.qq.com/kfid/kfc5097d1b6381f03e7` | `SRC com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java:318` | 厂商自有（腾讯微信客服 SaaS） | **运行时真会访问（用户点击触发）**：整串字面量直接交给 `ExternalWebActivity…launch(...)`——`:internet` 子进程 WebView 加载 |
| `https://tuwin.tmall.com` | `SRC …/connect/fragment/ConnectFragment.java:360` | 厂商自有（天猫店） | **运行时真会访问（用户点击，三级回退）**：`:355` 先 `tbopen://m.taobao.com/…h5Url=…%2F%2Ftuwin.tmall.com` 拉起淘宝 → `:358` `tmall://page.tm/shop?shopId=255736524` → `:360` ACTION_VIEW https 兜底 |
| `http://tuwinwifihelp.tuwinsmart.com/#/` | `SRC …/presentation/p010ui/home/HomeTipsWebsiteCachePolicy.java:17`（`TIPS_URL`） | 厂商自有 | **运行时真会访问**：`SRC …/device/detail/DeviceDetailActivity.java:884` 直接把该常量交给 `ExternalWebActivity.launch`（帮助站；`#/` 是 fragment 不发给服务器；**明文 HTTP**） |
| `http://tuwinwifihelp.tuwinsmart.com/#/pages/detail/detail` | `SRC …/home/HomeTipsWebsiteCachePolicy.java:28`（缓存清单第 2 项） | 厂商自有 | **死字符串/资源**：仅存在于预热清单，见下行判定 |
| `http://tuwinwifihelp.tuwinsmart.com/assets/` | 同上 `:13`（`ASSET_BASE_URL`，**未被任何代码引用**） | 厂商自有 | **死字符串/资源**：常量声明后无人拼接 |
| `…/assets/uni.92962d95.css`、`index-QBOHzVR1.js`、`index-yksqsBZR.css`、`pages-index-index.Db_F_afS.js`、`_plugin-vue_export-helper.BCo6x5W8.js`、`index-25iIq76Q.css`、`pages-detail-detail.BNTkq3Bp.js`、`detail-CIO5uBGQ.css`（8 条，均 `…/assets/` 前缀） | `SRC …/home/HomeTipsWebsiteCachePolicy.java:28`（`TIPS_URLS_TO_CACHE` 静态数组，同一次声明） | 厂商自有 | **死字符串/资源**：唯一消费方 `SRC …/home/HomeTipsWebsiteCacheCoordinator.java:35-69 cacheIfNeeded` **在全 APK 内零构造、零调用**（`CACHE_MARK_KEY="HOME_TIPS_WEBSITE_CACHE_URL"`（Policy:14）也无任何读写点；配套预加载库 `ren.yale` 零引用，见 6.3）——预热功能整体已死。帮助站资源实际由 WebView 打开 `#/` 后按 HTML 相对引用加载，不需要这些字面量。文件名里的 hash 停在旧版本，也是功能废弃的旁证 |
| `https://yomu.atlasmeta.one`、`https://yomu.atlasmeta.one/` | `SRC …/presentation/p010ui/home/PrivacyPolicySource.java:16`（`baseUrl`）、`:33`（`url()` 拼 `"<base>/" + 语言目录 + "/privacy.html"`，th/zh-Hant-HK/zh-Hant-TW/zh-Hans/en 六路） | 厂商自有（外部静态站） | **运行时真会访问**：`SRC …/home/HomePrivacyPolicyContentLoader.java:235` 把 `PrivacyPolicySource.INSTANCE.url(context)` 交给 `fetchWhenInternetRouteReady` → `SRC …/home/C2757x4614b080.java:84-88`（jadx 未反净，smali 行可见）`RoutedInternetTextFetcher.fetch(url, setOf("yomu.atlasmeta.one"))` → `SRC …/core/internet/RoutedInternetTextFetcher.java:88` `ExternalUrlPolicy authorize`（`:89` acquire `INTERNET_API` lease）→ `:91` OkHttp `newCall(GET)`。隐私政策弹窗正文从这里拉 |
| `http://ride5helpnew.tuwinsmart.com/#/` | `SRC …/presentation/p010ui/mine/fragment/MineFragment.java:150` | 厂商自有 | **运行时真会访问（用户点击触发）**：`ExternalWebActivity…launch(activity, "http://ride5helpnew.tuwinsmart.com/#/", "Ride5")`；**明文 HTTP** |
| `appdownload.tuwinsmart.com` | `SRC …/core/internet/ExternalUrlPolicy.java:23`（6 host 白名单成员）、`SRC …/core/internet/ExternalWebCompatibilityPolicy.java:47`（`DEFAULT_BANNER_HOSTS`） | 厂商自有 | **运行时真会访问（条件，服务器内容驱动）**：banner 接口下发的 `link` 必须先过 `SRC …/gateway/RoutedInternetCloudGateway.java:564` `bannerPagePolicy.authorize(link)`；点击后经 `SRC …/presentation/p010ui/internet/ExternalWebActivity.java:119-123`（初始 URL authorize）→`:371`（导航放行）加载。客户端从不自行拼接该 host |
| `tuwinwifihelp.tuwinsmart.com`、`ride5helpnew.tuwinsmart.com`、`yomu.atlasmeta.one`、`tuwin.tmall.com`、`work.weixin.qq.com`（增量行） | `SRC …/core/internet/ExternalUrlPolicy.java:23`（`DEFAULT_ALLOWED_HOSTS = {6 host}`；`authorize` 强制 http/https、禁 userinfo、host 精确小写匹配，`:31-52`） | 厂商自有 | **死字符串/资源（作为白名单本身）**：这 5 个 host 的真实访问判定见上方各自的字面量行；出现在策略类里只是白名单常量 |
| `intelligentassistant.tuwinsmart.com` | `SRC …/core/internet/ExternalWebCompatibilityPolicy.java:26`（常量）+ `:211`（`isAllowlistedExternalTarget`：仅 `http://intelligentassistant.tuwinsmart.com/`（port 80、path `/`）整体匹配） | 厂商自有（自家"智能助理"页） | **运行时真会访问（条件）**：不是客户端发起——帮助/客服页里用户点该链接时，`SRC …/internet/ExternalWebActivity.java:450` `shouldLaunchExternalApp`/`:371` 判定放行跳转。消费链在 `:139-167`（源页 host 必须在 help/assistant/banner 三组内） |
| `v.douyin.com`（`/twoBbgH2l4Y`） | `SRC …/ExternalWebCompatibilityPolicy.java:27`（HOST）/`:28`（PATH）+ `:209` | 其它（抖音推广短链） | **运行时真会访问（条件，白名单判定项）**：帮助页点抖音条目时外跳宿主 App；TUWIN 自身不请求。docs/04 C 组"平台专属推广"明令不做 |
| `xhslink.com`（`/m/8acYvvtd8S4`） | 同上 `:30` + `:205` | 其它（小红书推广短链） | 同上：白名单判定项，仅用户点击外跳 |
| `mp.weixin.qq.com`（`/s/S-odmnyu7jctrZZlzBwGMA`、`/s/wXxedWNrYloV9v7t4f5Qtw` 两篇文章） | 同上 `:29` + `:207`（paths 集合声明 `:50`） | 其它（公众号文章） | 同上：白名单判定项，仅用户点击外跳 |
| `apps.apple.com/app/id6740312738` | `SRC …/ExternalWebCompatibilityPolicy.java:24` + `:201`（https:443 + 该 path 精确匹配） | 其它（App Store） | **库自带但本 App 未触发（近似死字符串）**：安卓 APK 里内嵌 iOS 商店链接，只可能是帮助页共用营销配置的产物；`:201` 判定分支在安卓上永远不会因用户行为命中（无 iOS 设备场景），但严格说点击帮助页该链接仍会被放行到浏览器——保守记为"白名单判定项，实际不会发生" |
| `2005.sunwingroup.com.cn`（`https://…:1371/pcn_manager/download_static_file`） | `SRC …/core/internet/ExternalResourceAllowlist.java:18-21`（`ANDROID_DOWNLOAD_HOST/PATH/PORT/SCHEME`）；另见 `SRC …/ExternalWebCompatibilityPolicy.java:23` + `:203` | 其它（第三方安卓应用商店/静态分发，疑似某厂商市场） | **运行时真会访问（条件）**：帮助页（uni-app）里的安卓下载入口/资源，由 `SRC …/internet/ExternalWebActivity.java:325/:344` `shouldInterceptRequest → ExternalWebResourcePolicy.authorize`（即 `authorizeCrossOriginWebResource`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/internet/ExternalResourceAllowlist.java:44`；banner 图另一入口 `authorizeBannerImage` `:35`，允许 media/1371 下载/CDN 三类）放行给 WebView 拉取；宿主 App 本身不请求 |
| `cdn.dcloud.net.cn`（`https:443`，限 6 个 `/img/shadow-*.png`，`allowedCdnAssetPaths` 声明于 `:30`） | `SRC …/core/internet/ExternalResourceAllowlist.java:22-23`（HOST/PORT） | 其它（DCloud/uni-app 前端 CDN） | **运行时真会访问（条件）**：同上，帮助页跨域子资源白名单，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/internet/ExternalWebActivity.java:325/:344` 消费；只有清单内 6 张阴影图可过 |
| `111.179.38.202`（`http://…:1369/pcn_manager/download_static_file`） | `SRC …/core/internet/ExternalResourceAllowlist.java:25-28`（`MEDIA_*`）；`SRC …/core/internet/ExternalWebResourcePolicy.java:14`（同值常量） | 厂商自有（裸 IP 静态/图片服务器） | **运行时真会访问（条件）**：banner 图链路——`SRC …/gateway/RoutedInternetCloudGateway.java:577` `isAllowedBannerImage(item.getImageUrl())` 过滤后，`SRC …/core/glide/RoutedInternetImage.java:83` `authorizeBannerImage` 授权，Glide 经 §6.3 的 lease client 下载 |
| `192.168.169.1`、`192.168.25.1`、`192.168.0.1` | `SRC …/core/device/DeviceHostPolicy.java:50/:53/:56` | 厂商自有 | **运行时真会访问（设备本地）**：相机 AP 网关/主机校验（§1），与遥测无关；列此仅为覆盖 `signals-ips.tsv` 全 5 行 |
| `com.heytap.openid`、`com.heytap.openid.IdentifyService`、`action.com.heytap.openid.OPEN_ID_SERVICE`、`com.meizu.flyme.openidsdk`（含 `…ACTION_OPEN_ID_CHANGE`/`…permission.OPEN_ID_CHANGE`） | `SRC org/repackage/p018a/p019a/p020a/p021a/C4008c.java:54/:108/:109`、`SRC org/repackage/com/meizu/flyme/openidsdk/C4010b.java:240/:243/:273`（signals-hosts 里的行） | 友盟（捆绑的 OPPO/魅族 OAID SDK，包名被 repackage） | **运行时真会访问（进程内 IPC，非 HTTP）**：被 `_work/tuwin_src/sources/com/umeng/analytics/pro/C3053bp.java:4`（heytap OpenIDSDK）、`…/pro/C3051bn.java:4`（meizu OpenIdHelper）引用，属 §6.1 init 后 analytics 的 OAID 采集面；对应 manifest 的 `AD_ID`/`freemme.permission.msa` 权限（`_work/re/tuwin/manifest.md:68-69`） |
| `com.umeng.commonsdk.UMConfigure` | `SRC …/core/util/UmengSdkBridge.java:19` | 类名串（误报为"像域名"） | **运行时真会访问（反射目标）**：见 6.1；不是主机 |

#### 6.2-B 库侧补测（signals 不扫的 `com/umeng/**`、`com/efs/**`、`com/alibaba/**` 等，逐条）

| 字面量 | 出现在（类:行） | 归属 | 判定 |
|---|---|---|---|
| `https://errnewlog.umeng.com/api/crashsdk/logcollect` | `SRC com/efs/sdk/base/core/controller/ControllerCenter.java:114`（license `28ef1713347d` `:115`）；默认同值 `SRC com/efs/sdk/base/internal/C1040z0.java:10` | 友盟（efs/U-APM） | **运行时真会访问**：6.1 链 `_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java:548-551` → `_work/tuwin_src/sources/com/umeng/umcrash/UMCrash.java:700` → `ControllerCenter`（CN 线路）；崩溃/ANR/日志上报主通道 |
| `https://errnewlogos.umeng.com/api/crashsdk/logcollect` | `SRC com/efs/sdk/base/core/controller/ControllerCenter.java:111`（`4ea4e41a3993` `:112`） | 友盟 | **库自带但本 App 未触发**：`isIntl()` 国际分支（`:110`）才写入；本工程走 `useIntlServices` 需 `SdkVersion.SDK_TYPE==1`（`_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java:544-546`），CN 包 key 场景不命中 |
| `ulogs.umeng.com`（主数据上报域名，`"ulogs"→"cnlogs"` 字符串替换逻辑） | `SRC com/umeng/commonsdk/stateless/C3240c.java:70-71`（含 `preulogs` 特判） | 友盟（U-App 会话/设备 envelope） | **运行时真会访问**：stateless sender 在 init 后自动上报启动/会话；**完整 URL 常量在 `com.umeng.commonsdk.statistics.UMServerURL`——该类在未喂 jadx 的 `classes3.dex`（类清单见 `_work/tuwin_src/sources/com/umeng/commonsdk/debug/SelfChecker.java:10` 的 FILELIST，反编译树无文件）**，与 §4.1 `C3174a` 同源缺证；补证手段：单跑 `classes3.dex` 或抓包 |
| `preulogs.umeng.com` | `SRC com/umeng/commonsdk/stateless/C3240c.java:70` | 友盟（内测试探） | **库自带但本 App 未触发**：仅当已存 URL 含 `preulogs`（内测开关/灰度配置）时保留 |
| `cnlogs.umeng.com/ext_event`、`/uapp_ekverr_logs`、`/common_inout_logs` | `SRC com/umeng/analytics/pro/RunnableC3028ar.java:15/:18/:21` | 友盟 | **运行时真会访问（随 SDK 自动流）**：调度点 `_work/tuwin_src/sources/com/umeng/ccg/C3177d.java:831/:861/:1336/:1385`（cloud-config worker，由 6.1 `_work/tuwin_src/sources/com/umeng/commonsdk/internal/C3221c.java:613/:796→:719` 链路激活） |
| `aspect-upush.umeng.com/occa/v1/event/report` | `SRC com/umeng/analytics/pro/RunnableC3028ar.java:12` | 友盟（推送辅助归因） | **运行时真会访问（弱依据，条件）**：同在 `_work/tuwin_src/sources/com/umeng/ccg/C3177d.java:1292/:1302/:1312` 被调度；是否实际发包受远端 `actionInfo` 开关控制（`com/umeng/ccg/C3177d.java` 内多处 `getActionInfo` 判断）。本包无推送组件但归因事件由 analytics 侧独立触发——需抓包定证 |
| `ucc.umeng.com/v2/inn/fetch` | `SRC com/umeng/analytics/pro/RunnableC3029as.java:14` | 友盟（U-CC 内容/云配置拉取） | **运行时真会访问（随 SDK 自动流）**：调度点 `SRC com/umeng/ccg/C3177d.java:973` |
| `ulogs.umeng.com/push_cloud_activation`、`htls.umeng.com/push_cloud_activation` | `SRC com/umeng/analytics/pro/RunnableC3090cz.java:13/:19` | 友盟（push 云激活） | **库自带但本 App 未触发**：属推送激活链路；`com.umeng.message.PushAgent` 类在本包不存在（`_work/tuwin_src/sources/com/umeng/commonsdk/UMConfigure.java:369` 的 push 检查因此空转），引用方仅 `…/analytics/pro/C3079co.java` |
| `resolve.umeng.com/resolve`、`/resolve?htls=1` | `SRC com/umeng/analytics/pro/C3065ca.java:65/:67` | 友盟（域名解析兜底） | **运行时真会访问（兜底路径）**：引用方含 envelope 发送框架 `com/umeng/commonsdk/framework/C3218a.java` 与 analytics `C3027aq/C3067cc`——主上报域失败时才打；正常网络不命中 |
| `https://one.umops.com/api/attributionResult`、`/api/deferredLink` | `SRC com/umeng/commonsdk/deeplink/C3209b.java:41/:55`、`SRC com/umeng/commonsdk/deeplink/C3213f.java:43/:53`（`HttpsURLConnection.openConnection` 即调用点） | 友盟（DDL 归因/深度链接） | **库自带但本 App 未触发**：唯一入口 `UMCommonDeepLink`，`com/tuwinsmart/**` 对其零调用（grep 无命中），且 `_work/tuwin_src/sources/com/umeng/commonsdk/internal/C3221c.java:721-730` 的 DDL 消息 case 依赖业务侧显式发事件 |
| `https://203.107.1.1/181345/d?host=`（阿里云 HTTPDNS mini） | `SRC com/alibaba/sdk/android/oss/common/utils/HttpdnsMini.java:27/:130` | 阿里（OSS SDK 内嵌） | **库自带但本 App 未触发**：全 APK 唯一 OSSClient 构造点显式关闭：`SRC com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyDiagnosticUploadGateway.java:298` `clientConfiguration.setHttpDnsEnable(false)` |
| `http://oss-cn-****.aliyuncs.com`、`http://image.cnamedomain.com` | `SRC com/alibaba/sdk/android/oss/internal/InternalRequestOperation.java:178`、`SRC com/alibaba/sdk/android/oss/OSSImpl.java:128` | 阿里 | **死字符串/资源**：endpoint 格式报错文案里的示例值 |
| OSS 真实 bucket/endpoint（`<bucket>.<endpoint>` 形态） | 运行期拼装 `SRC …/gateway/LegacyDirectCloudConfig.java:151`；来源 `BuildConfig.TUWIN_OSS_ENDPOINT/REGION/BUCKET/ACCESS_KEY_ID/ACCESS_KEY_SECRET`（`SRC …/gateway/LegacyDirectCloudConfig.java:165`） | 厂商自有 | **运行时真会访问（条件）**：`isOssConfigured()`（`:136-145`）为 true 才上传；**BuildConfig.java 不在反编译产物里，五元组实值缺证**（缺证手段：baksmali 抽 `com/tuwinsmart/tuwin/BuildConfig`，或真机走"反馈-上传日志"看 `feedback_log_upload_unavailable reason=local_oss_config_missing` 事件是否出现，见 §6.3 链与 docs/06 日志读法） |
| github.com（39 处）、gist.github.com（12 处）、code.google.com（21 处）、issuetracker.google.com（8 处）、cs.android.com（4 处）、android.googlesource.com（4 处）、dev.to（2 处） | 各库源码注释/异常描述，例 `SRC com/efs/sdk/memleaksdk/monitor/internal/EnumC1093e.java:460`（泄漏参考文档串） | 各库 | **死字符串/资源**：Javadoc/注释/错误描述链接，无代码引用，不可能被请求 |

**汇总**：A 表 29 行（fullUrls 37 行全部落判定）+ B 表 14 行 = **43 个判定单元**；其中厂商自有"运行时真会访问"的外网域名共 **6 个**：`ali.tuwinsmart.com`（功能面）+ `yomu.atlasmeta.one`、`tuwinwifihelp.tuwinsmart.com`、`ride5helpnew.tuwinsmart.com`、`work.weixin.qq.com`、`tuwin.tmall.com`（内容/客服面），外加 2 个条件面 host（`appdownload`、`111.179.38.202`，服务器内容驱动）；友盟/efs 真访问 7 域（errnewlog、ulogs/cnlogs 主链、ucc、utoken、resolve 兜底、aspect-upush 弱证），死重 4 域（errnewlogos、preulogs、one.umops、htls，共 6 条端点 path）。教训复述：**包里有 ≠ 在用**——`one.umops.com`、`aspect-upush`、`203.107.1.1`、整个 `ren.yale` 预加载面、8 条 assets 文件名，全是"看见就抄"会翻车的死重量。

### 6.3 图片 / 存储 / 其它三方

每个库一句话 + 初始化位置 + 值得抄的配置常量。路径缩写 `SRC = _work/tuwin_src/sources/`。

| 库 | TUWIN 用它做什么 / 初始化在哪 | 值得抄的配置常量 |
|---|---|---|
| **Glide**（`com/bumptech`） | 全部图片装载（设备缩略图、banner、相册），定制模块 `SRC com/tuwinsmart/tuwin/core/glide/GlideNetworkModule.java:48`（`AppGlideModule`）。`isManifestParsingEnabled()==false`（`:50-51`）；`registerComponents`（`:55`）三件事：`:60` 用自定义 `DynamicNetworkCallFactory` **替换** `GlideUrl→InputStream` 默认 loader，`:61` 注册 `RoutedInternetImage`（外网图，须过 §6.2 白名单，`SRC …/core/glide/RoutedInternetImage.java:83`）、`:69` 注册 `AuthorizedDeviceResource`（设备缩略图，走 RouteLease/EndpointGrant） | `applyOptions`（`:95`，实现 `:99`）：`DiskLruCacheFactory(cacheDir + "/diskCache", 52428800L)` = **50 MiB**；`DynamicNetworkCallFactory`（`:104-134`）：`ConnectionPool(5, 5, MINUTES)`、`Dispatcher(maxRequests=16, perHost=2)`、常规超时 8s / Ride3Pro 缩略图串行路 5s（`Ride3ProGlideThumbnailPolicy.shouldSerialize`，复用 §2.4 调度器 + `addRide3ProRequestIdInterceptor`）；**关键设计**：`:133` 给该 client 装 `RejectingSocketFactory`（`:140-155`，任何 socket 创建抛 `IOException("Glide route is unavailable")`，`:146`）——裸 GlideUrl 永远连不出去，所有网络图必须改走 lease 路由。这就是"库自带下载器但 App 把它阉了"的典型 |
| **DataStore**（`androidx.datastore`） | 新设置存储，替代 SharedPreferences。`SRC com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepositoryKt.java:29-35` 顶层委托属性 `dataStore` | `DATASTORE_NAME = "user_preferences"`（`:28`）、`LEGACY_PREFERENCES_NAME = "TUWIN"`（`:26`）→ `SharedPreferencesMigration("TUWIN")`（`:33`）一次性搬迁；默认值 `DEFAULT_CONNECTED_DEVICES_JSON/…_EVENTS_JSON = "[]"`（`:24-25`）。消费者 `SRC …/data/source/local/preferences/UserPreferencesRepository.java:102`。注：旧的 `PreferenceHelper`（Gson 存 JSON 串）仍与它并存（§2.2 固件版本回读就走它） |
| **OkHttp 日志拦截器**（`com/ihsanbal` Logging） | 把**完整 HTTP 交换**写进自家日志系统（不是遥测！）。工厂 `SRC com/tuwinsmart/tuwin/core/util/logging/FullHttpLoggingInterceptorKt.java`：`LoggingInterceptor.Builder().setLevel(Level.BASIC).request("HTTP_FULL\|<client>\|REQUEST").response(…RESPONSE).logger(AppHttpLogger)`；`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/logging/AppHttpLogger.java:30-41` 把 `HTTP_FULL\|client\|DIR` 标签重排成 `[HTTP_FULL][client][DIR] msg` 交 `Timber.isWriteFile(true)`（落到 §5 提到的 `WriteRuntimeLogTree`）。挂载点仅两处：`SRC …/core/device/ride3pro/Ride3ProSessionTransport.java:566`（`"ride3pro_api"`）、`SRC …/core/device/ride5/Ride5CgiGateway.java:248`（`"ride5_cgi"`） | §1.7 的 `RoutedOkHttpProvider` 通用链路**不挂**日志拦截器（该文件 `addInterceptor` 零命中）——只有两机型手写 client 全量落日志。`isWriteFile(true)` 开关常量、tag 格式值得对齐 docs/06 的 `op=`/交换行语法 |
| **RxJava**（`io.reactivex`） | 遗留数据层：`SRC …/core/util/network/NetworkUtil.java`、`SRC …/data/repository/DeviceRepositoryImpl.java` + retrofit rx 适配器/变换（`data/source/remote/transform/HttpResultFunc.java` 等），共 16 个厂商文件引用。与遥测无关，属"新 Flow 层旁边立着的旧 Rx 栈" | 无值得抄的常量（新代码一律 Flow，§5.3） |
| **WifiUtils**（`com/thanosfisherman`） | 只用了一个判断：`WifiUtils.withContext(ctx).isWifiConnected()` 四例——`SRC …/domain/strategy/M3ConnectionStrategy.java:212`、`SRC …/domain/strategy/Ride3ProConnectionStrategy.java:145`、`SRC …/domain/strategy/Ride5ConnectionStrategy.java:253`、`:377`。**没有**用它连网/`enableLogger` | 无。另：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:314` `ConnectUtil.init` 是厂商自写的 Wi-Fi 工具（`SRC …/core/util/ConnectUtil.java:43`，存 `WifiManager`+SSID 正则表，tag `"fingdo"` 暴露了抄来血统），不是三方 |
| **com.azhon AppUpdater** | **未用**。App 自更新是自己实现的（§3.7 `AppUpdateCoordinator`）；azhon 的 `AppUpdater` manager 全 APK 零构造，厂商唯一沾它的一处是把常量 `Constant.APK_SUFFIX` 内联进 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:591`（`…_smart_<ts>.apk`）。库自带但本 App 未触发。注：它的 `AppUpdateFileProvider` 仍注册在 manifest（`_work/re/tuwin/manifest.md:178`），authority `…fileProvider` 恰被 §3.7 的安装 Intent 复用——删库时会踩到的坑 | 无 |
| **com.noober background** | 不是 BackgoundHttp，是 **BL\* 背景属性 View 库**（圆角/描边 XML 属性），只出现在 databinding 生成的 View 类型里（`databinding/Activity*Binding.java` 大量 `BLTextView/BLImageView/BLEditText`）。其 `BackgroundContentProvider`（`multiprocess=true`，`_work/re/tuwin/manifest.md:179`）随进程自动初始化，无业务配置 | 无 |
| **com.lzy okgo/okserver** | 仅借数据类：`Progress`（进度字段名）、`HttpHeaders`、`SerializableCookie`（`@SerializedName` 键名）、`DownloadTask`（`TaskFinishInsertEvent` 载荷与旧下载列表页，§5.1）。**无 `OkGo.init`/`ODUtils` 调用点**，下载器不跑动——§2.3 已证 Range 下载路径进不去 | 无（教训：包体里躺着完整 lzy 栈但功能是死的） |
| **com.shuyu GSYVideoPlayer + tv.danmaku ijkplayer** | 播放宿主 + ijk 内核，全部参数、生命周期、重试已逐项抄清 → **§4.1/§4.3**。初始化 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:355-356`（`PlayerFactory.setPlayManager(IjkPlayerManager.class)` + `enableRawPlay`） | 见 §4（`setLogLevel(8)`、option 表） |
| **danikula videocache** | GSY 的缓存代理（`com/shuyu/gsyvideoplayer/cache/ProxyCacheManager.java` 唯一引用方）；App 侧 `setUpLazy(cache=false)`（§4.3）→ **未触发** | 无 |
| **阿里 OSS SDK**（`com/alibaba/sdk/android/oss`） | 厂商**自建诊断日志上云**：`LogHelper.uploadLogFile`（`SRC …/core/util/wifi/LogHelper.java:293-301`，取 `DiagnosticUploadGateway`）→ `SRC …/gateway/RoutedLegacyDiagnosticUploadGateway.java`：`:195-197` `isOssConfigured()` 不满足则记 `feedback_log_upload_unavailable reason=local_oss_config_missing` 返回 UNAVAILABLE；满足则 `:200` `NetworkIntent.Internet("feedback_log_upload")` + `INTERNET_UPLOAD` profile lease → `:295-300` `ClientConfiguration{SignVersion.V4, maxErrorRetry=0, httpDns=off, redirects=off, okHttpClient=路由后client}` → `:301` `new OSSClient(ctx, endpoint, OSSPlainTextAKSKCredentialProvider(ak, sk), cfg)` → `PutObject(bucket, key, file, metadata)`（`:467`）。触发者：`SRC …/presentation/p010ui/mine/FeedbackActivity.java:688/:1261`（**用户在反馈页点"上传日志"**才传）。gzip 文本、`publicOssUrl` 回填给反馈单（§6.2 `FeedbackLogUploadPolicy:22`） | AKSK 编译期进 BuildConfig 即视为泄露面（明文打进 APK）；V4 签名、重试 0 次、复用 route lease 的"三方 SDK 塞 OkHttp 实例"手法（`:300` `setOkHttpClient`）值得借鉴——**但云上传本身我们不做**，见 6.4 |
| **ren.yale CacheWebView** | 库完整在包（`ren/yale/android/cachewebviewlib/`），`com/tuwinsmart/**` 对 `ren.yale` **零引用**——本应是 §6.2 那 8 条 assets 预热的配套，随 Coordinator 一起成死重 | 无 |
| **Koin**（`org/koin`） | DI 容器。`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:276-296 initKoin`：`androidContext` + `androidLogger(Level.ERROR)`（`:292`）+ 单模块 `AppModuleKt.getAppModule()`（`:293`）。全 app 经 `KoinJavaComponent.get$default` 取单例 | 无 app 级配置常量 |
| **其余小库一句话** | greenrobot EventBus（§5.1）；google gson（全 JSON 序列化）；jakewharton Timber（§5/6.1 日志树宿主）；toasty `es.dmoral`——`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:354` `Toasty.Config.getInstance().tintIcon(true).allowQueue(true).setGravity(17, 0, dp(30)).supportDarkTheme(false).setRTL(false)`（唯一一处配置常量）；`com.release.alert`（对话框，§5.1 见过）；hjq permissions（权限申请）；flyco tablayout / bskim maxheightscrollview / xuliwen zoom / chrisbanes photoview / danikula（UI 装饰）；multidex（`MultiDexApplication`，`_work/tuwin_src/sources/com/tuwinsmart/tuwin/TuwinApplication.java:141`，佐证 classes*.dex ≥2） | — |

### 6.4 我们自己要不要跟

**明确不做**（对齐 `docs/04-固件更新与功能差距.md:787-795` C 组"明确不做"口径）：
1. **友盟全家桶整体不跟**：U-App 自动会话上报、U-APM（崩溃/ANR/内存泄漏/启动/页面/远程日志）、ccg 云配置、`utoken` zid 设备指纹、OAID 采集（连带 `AD_ID`、`freemme.permission.msa` 两个权限也不进我们 manifest）。TUWIN 虽然把它们挡在隐私同意之后，本质仍是"装机即备好的追踪面"。
2. **推广/外链不跟**：`v.douyin.com`、`xhslink.com`、`mp.weixin.qq.com` 文章、`tuwin.tmall.com` 商城、banner 运营位（`ali.tuwinsmart.com/banner` + `111.179.38.202` 图床）——正对应 C 组"平台专属推广/广告面"。
3. **日志/反馈上云不跟**：OSS 直传（AKSK 进 APK）与 `POST http://ali.tuwinsmart.com/feedback` 的"云端收日志"模式不复制；`yomu.atlasmeta.one` 在线隐私政策也建议本地化打包（离线可读、可审计）。

**要模仿的行为**：
1. **崩溃先落盘再谈别的**：抄 `AppCrashHandler` 的形态（§6.1）——delegating handler、写 `cacheDir/CLOG`、带 `session_id/app_version/android_sdk/device` 元数据、不抢链（`previousHandler` 必调）。对我们这就是把 docs/06 rovdiag 的 buffer 在崩溃时**强制 flush 成导出文件**，让用户"下次连不上"也能带崩溃上下文回来。
2. **HTTP 全量交换进同一日志通道**：`FullHttpLoggingInterceptorKt` 的 `LOG_SOURCE="HTTP_FULL"` + `[HTTP_FULL][client][REQUEST/RESPONSE]` tag 设计与"只在手写设备上开、通用路由层不开"的克制，正是 docs/06 交换行该长成的样子（脱敏默认开是他们的短板——`DiagnosticHttpLogPolicy` 白名单可抄，见 §2.3）。
3. **网络图必须走受控通道**：Glide 装 `RejectingSocketFactory` 逼所有图片过路由 lease + host 白名单（§6.3 首行），这个"库默认出口直接焊死"的思路值得原样搬——我们的图片加载器同样不该保留"随便 fetch 一个 URL"的旁路。
4. 同意闸门（`isAgreePrivacy` 前后两套初始化，§6.1）作为行为模式保留：我们无上报可挡，但"首启未同意前零外联、同意动作触发 `initThirdLibs` 等价物"的时序值得对齐。

---

## 7. 原生库

数据源：`data/tuwin/natives.md`（ELF 头 + .dynsym 全量）、`natives-jni.md`（`Java_*` 导出）、`natives-strings.tsv`。9 个 `.so` 全在 `lib/arm64-v8a/`，**没有 x86 / armeabi 版本**（模拟器上跑不了 TUWIN 的播放与崩溃栈，与我们只出 arm64 设备包的决定一致）。

### 7.1 9 个 `.so` 的用途

| 库 | 字节 | DT_NEEDED（前几个） | 导出 | 导入 | `Java_*` | 判定 |
|---|---|---|---|---|---|---|
| `libffmpeg.so` | 15,561,312 | liblog · libandroid · libOpenSLES · libEGL · libGLESv2 · libjnigraphics · libz · libc | 6541 | 258 | **36** | 自研播放器/转码核心，真在用（见 7.2） |
| `libijkffmpeg.so` | 6,440,880 | libm · libz · libdl · libc | 8809 | 200 | 0 | ijkplayer 带的 FFmpeg 分支，只被 `libijkplayer.so` 依赖 |
| `libijkplayer.so` | 545,896 | **libijkffmpeg** · **libijksdl** · liblog · libandroid | 826 | 364 | 0 | 预览播放；**无 `Java_*` 导出但导出 `JNI_OnLoad` → `RegisterNatives` 动态注册** |
| `libijksdl.so` | 362,832 | libijkffmpeg · liblog · libandroid · libOpenSLES · libEGL · libGLESv2 | — | — | 0 | 同上，动态注册 |
| `libucrash.so` / `libucrash-core.so` | 51,288 / 101,376 | liblog · libdl · libm · libc | 1 / 0 | 97 / 66 | 0 | 友盟 U-Crash 原生栈，`JNI_OnLoad` 动态注册 |
| `libumonitor.so` | 250,968 | liblog · libm · libdl · libc | 1 | 88 | 0 | 友盟内存/性能监控（`com.efs.sdk.memleaksdk.*`，含 `:u_heap` 进程的 `UMonitorService`，`data/tuwin/manifest.md:150`） |
| `libumeng-spy.so` | 398,472 | liblog · libm · libdl · libc | 381 | 61 | **3** | 友盟 UMID/设备标识：`Java_com_umeng_umzid_Spy_getNativeTag`、`getNativeLibraryVersion`、`getNativeID` |
| `libdatastore_shared_counter.so` | 7,112 | libm · libdl · libc | 9 | 10 | 4 | androidx DataStore 多进程计数，与相机无关 |

**给提取层的教训**：按 `Java_*` 名字抽 JNI 会**系统性漏掉 ijkplayer / ucrash / umonitor** —— 这 5 个库
（`libffmpeg`、`libijkplayer`、`libijksdl`、`libucrash`、`libumonitor`）都导出 `JNI_OnLoad`，
方法靠 `env->RegisterNatives` 绑定，符号表里不出现 `Java_` 前缀。判断某 `.so` 是否真被 Java 用到，
要同时看 `JNI_OnLoad` 与 `natives-strings.tsv` 里的类签名串。

### 7.2 `Java_*` 符号 → `external fun` 声明与调用点

`libffmpeg.so` 的 36 个导出全是 `Java_com_generalplus_ffmpegLib_ffmpegWrapper_na*`，按语义分四类：

| 类别 | 符号 |
|---|---|
| 播放控制 | `naSetup` · `naInitAndPlay` · `naPlay` · `naStop` · `naPause` · `naResume` · `naSeek` · `naStatus` · `naGetPosition` · `naGetDuration` |
| 解码/渲染 | `naGetDecodeFrame` · `naInitDrawFrame` · `naDrawFrame` · `naGetFrameCnt` · `naGetRevSizeCnt` · `naSetCovertDecodeFrameFormat` · `naSetDecodeOptions` · `naSetScaleMode` · `naSetZoomInRatio` |
| 转码/抽帧 | `naTranscodeAviToMp4` · `naCancelTranscode` · `naSetTransCodeOptions` · `naSetEncodeByLocalTime` · `naSetForceToTranscode` · `naGetTranscodeProgress` · `naExtractFrame` · `naSaveVideo` · `naStopSaveVideo` |
| 流与信息 | `naSetStreaming` · `naGetStreamCodecID` · `naGetVideoRes` · `naGetVideoInfo` · `naSetBufferingTime` · `naSetRepeat` · `naSetDebugMessage` · `napshot`（符号名照抄，`na` 与 `pshot` 之间没有下划线） |

调用侧证据：8 个厂商文件 `import com.generalplus.ffmpegLib.ffmpegWrapper`，其中
`_work/tuwin_src/sources/com/tuwinsmart/tuwin/presentation/p010ui/album/Ride3ProLocalVideoTranscoder.java:6`。

**但那个 wrapper 类不在 jadx 输出里**：`_work/tuwin_src/sources/com/` 下没有 `generalplus/` 目录，全树也搜不到 `class ffmpegWrapper`。
即 Java 侧声明确实被 dex 引用，只是 jadx 没为它落文件。要拿它的 `external fun` 原型需要
`jadx --single-class com.generalplus.ffmpegLib.ffmpegWrapper`，而这条路在本 APK 上会撞上本文开头说的资源/缓存阶段卡死 —— 记为**已知工具限制**，不影响本节按符号名归类。

---

## 8. 对既有文档的纠正

### 8.1 `docs/04-固件更新与功能差距.md`

| 现文档说法 | 证据 | 应改为 |
|---|---|---|
| 「App 自更新与相机 OTA 是两套东西，别混」 | 成立。App 侧：`core/update/AppUpdateCoordinator`，`AppUpdateCheckState` 7 态（`IDLE / WAITING_FOR_INTERNET_ROUTE / CHECKING / NO_UPDATE / UPDATE_AVAILABLE / CHECK_FAILED / CHECK_CANCELLED`），去重键实参 `AppUpdateCheckKey(250, "stable", "production")`；相机侧是本附录 §3 的 14 态机 | 结论保留，**补这组实值**；并记官方端点拼写为 `@GET("appupdatecheker")`（`data/source/remote/api/TuwinSuspendApi.java`，少一个 `c`）。我们已决定不做 App 自更新，不必复刻该拼写 |
| OTA 小节只写「上传 + 触发」 | §3.2–§3.6 给出 `md5sum`/`model`/`hw`/`sw` 四字段的取值来源、分块大小、超时、装机后回读版本的路径 | 把 §3 的字段来源与状态机并进 `docs/04`，别停在两步 |

### 8.2 `docs/05-网络API清单与安全评估.md`

| 现文档做法 | 证据 | 应改为 |
|---|---|---|
| 按 APK 里出现过的域名列清单 | §6.2 判定 43 条：**运行时真访问 15 条**（厂商自有 6 个 + 条件性 2 个 + 友盟侧 7 个：`errnewlog`/`ulogs`/`cnlogs`/`ucc`/`utoken`/`resolve`/`aspect-upush`），其余 28 条为库自带未触发或死字符串 | 域名清单一律带「真访问 / 未触发 / 死字符串」三档与依据行号；厂商侧真实外网域名只有 6 个，更新检查域是 `ali.tuwinsmart.com` |
| 「统计/崩溃：友盟 Umeng + ucrash」一句带过 | 友盟**确实在用**：隐私同意后反射 `UMConfigure.init(...)`，AppKey 常量 `6781b8f38f232a05f1f56ef5`（§6.1）；`libumeng-spy` 提供 UMID 原生取值（§7.1） | 写出「同意后初始化 + AppKey + 3 个 `Java_*`」，作为我们做隐私对照的具体靶子（我们不上报＝不实现这一层） |
| — | §6.2 顺带修正了提取层自身：`signals-hosts.tsv` 1088 行里约 **95% 是正则误报**（`.kt` 文件名、全限定类名被当成主机名） | 在方法小节注明「`signals-hosts` 只能当线索，不能当清单」；这条同样记进 `tools/re/README.md` |

### 8.3 `docs/03-品牌型号与协议矩阵.md` §1.3 / §1.4 / §1.6

| 现文档说法 | 证据 | 应改为 |
|---|---|---|
| §1.4 描述路由绑定但无数值 | §1.8：lease 替换等待 `3000 ms`、替换轮询 `50 ms`、Wi-Fi 扫描等待 `8000 ms`、`WifiNetworkSpecifier` 要求 `SDK ≥ 29`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceNetworkController.java:61,62,272`、`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceWifiScanner.java:42`） | 四个数值进矩阵，它们就是我们超时/重试默认值的参照 |
| §1.6「设备源下载禁用 HTTP Range，续传是 `?offset=`」 | 结论对但此前无硬证据：`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/transfer/TransferRequest.java:163-165` 对设备传输使用 `ResumePolicy.HttpRange` **直接抛异常**；全树 `Range` 头写入点只有 1 处且属日志脱敏白名单；构造处 `_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java:123` 不加任何 header | 补三条出处，并写明原因：相机不接受 Range 语义，续传靠 `?offset=` 且受固件版本门限（§2.1–§2.2） |
| §1.1 技术栈「`libffmpeg.so`(15MB)、ijkplayer 全套」 | §7.1 精确到 9 个 `.so` 及依赖；`libijkplayer` 无 `Java_*` 导出，靠 `JNI_OnLoad` 动态注册 | 概括保留，细节指向本附录 §7，并记「按 `Java_*` 统计 JNI 面会漏 ijk/ucrash/umonitor」 |
