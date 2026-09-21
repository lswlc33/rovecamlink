# TUWIN 官方 APK 逆向档案 · 附录 B — 传输 / OTA / 联网

> 证据基线：`_work/tuwin_src/sources/com/tuwinsmart/**`（jadx 反编译，APK 版本见 `_work/re/tuwin/manifest.md`）。
> 表格来源：`_work/re/tuwin/api/*.md`、`catalog-consts.md`、`catalog-ports.md`、`catalog-http.md`、`catalog-templates.md`、`manifest.md`、`natives.md`、`natives-jni.md`、`signals-*.tsv`。
> 引用格式：`_work/tuwin_src/sources/com/tuwinsmart/.../Foo.java:123`。核不上行号的只给文件路径。

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

`object` 单例（`DeviceWifiNetworkRequestFactory.java:22` `public static final DeviceWifiNetworkRequestFactory INSTANCE`），私有构造 `:51`。全部逻辑在 `build(DeviceWifiConnectRequest)`（`DeviceWifiNetworkRequestFactory.java:54`）：

前置校验（`:57-59`）：`request.passphrase` 必须非空白，否则 `IllegalArgumentException("Device Wi-Fi passphrase is required")`。**没有开放网络（无密码）分支**。

两条 SSID 路径（`:61-78`）：

| 条件 | 设置内容 | 行号 |
|---|---|---|
| `request.isExact() == true` | `builder.setSsid(trimmedExpectedSsid)` + `builder.setBssid(MacAddress)` | `:64-75` |
| `request.isExact() == false` | `builder.setSsidPattern(ssidPattern(deviceType))`，**不填 BSSID** | `:77` |

- **exact 模式一定用 BSSID**：`expectedBssid` 解析失败为 null 时直接 `IllegalArgumentException("Exact device Wi-Fi BSSID is required")`（`:70-73`），即 exact 模式是 SSID+BSSID 双锁定，防止同 SSID 伪造 AP。
- exact 模式的 SSID 也是可选的：若 `expectedSsid` trim 后为空 → `IllegalArgumentException("Exact device Wi-Fi SSID is required")`（`:67-69`）。也就是说 exact 模式下两者都必填。
- 密码只走 WPA2：`builder.setWpa2Passphrase(request.getPassphrase())`（`:79`），无 `setWepKeys` / 无 open 变体。

**SSID 匹配模式（`PatternMatcher`，type=3 = `PATTERN_ADVANCED_GLOB`）** — `ssidPattern(DeviceType)`（`DeviceWifiNetworkRequestFactory.java:87-104`），逐条原样抄：

| DeviceType | 正则（原样） | 行号 |
|---|---|---|
| `RIDE5` | `TUWIN_[A-Za-z0-9]{6,}` | `:91-92` |
| `RIDE3PRO` | `TUWIN_R3P_[A-Za-z0-9]+` | `:93-94` |
| `RIDE6` | `TUWIN_R6_[A-Za-z0-9]+` | `:95-96` |
| `M3` | `TUWIN[-_]M3_[A-Za-z0-9]+` | `:97-101` |
| 其它 | `throw new NoWhenBranchMatchedException()` | `:98-99` |

注意 RIDE5 的 `TUWIN_` 前缀是**最宽**的（只要求 6 位以上字母数字），会同时吃掉 `TUWIN_R3P_xxx` / `TUWIN_R6_xxx`；RIDE3Pro/RIDE6/M3 才各自收窄。M3 的模式允许 `TUWIN-M3_` 与 `TUWIN_M3_` 两种分隔符。

`parseBssid(String raw)`（`DeviceWifiNetworkRequestFactory.java:106-128`）：`trim()` → `replace('-', ':')` → 空白判空 → `MacAddress.fromString()`，包在 `runCatching` 里（`:119-127`），任何异常返回 null。即**接受 `AA-BB-CC-DD-EE-FF` 与 `AA:BB:CC:DD:EE:FF` 两种分隔**。

### 1.2 `NetworkRequest` 的能力位增删

`DeviceWifiNetworkRequestFactory.java:82` 原样：

```java
new NetworkRequest.Builder()
    .addTransportType(1)      // NetworkCapabilities.TRANSPORT_WIFI
    .removeCapability(12)     // NetworkCapabilities.NET_CAPABILITY_PORTAL
    .setNetworkSpecifier(wifiNetworkSpecifier)
    .build();
```

只 **加 transport**、只 **删 capability**；没有 `addCapability`、没有 `setUnderlyingNetworks`、没有 `addLanTransportType`。删掉 `NET_CAPABILITY_PORTAL(12)` 的含义是：要求的网络**不能处于 captive-portal 状态**，Android 只对通过探测的网络清掉 PORTAL 位，因此这相当于把「Portal 未通过」的 AP 排除在自动连接之外。

对照 `NetworkTopologyMonitor.start()` 的监听请求（`NetworkTopologyMonitor.java:130`）：

```java
new NetworkRequest.Builder().addTransportType(1).addTransportType(0).build()  // WIFI + CELLULAR
```

这是 `registerNetworkCallback`（被动监听），不是 `requestNetwork`（不产生网络）。

其它能力位判定：`connectivityManager.hasTransport(1)` = WIFI（`DeviceNetworkController.java:168`、`NetworkTopologyMonitor.java:138`、`:207`）。

### 1.3 `DeviceNetworkController`：调用顺序与时机

构造（`DeviceNetworkController.java:122-150`）：`(context, enabled, replacementTeardownTimeoutMs, replacementTeardownPollMs)`；`NetworkRuntime` 用 `(appContext, true, 0L, 0L, flags=12, null)`（`NetworkRuntime.java:133`），合成构造（`:152-154`）把两个 long 换成默认值。常量（`:61-64`）：

| 常量 | 值 | 行号 |
|---|---|---|
| `DEFAULT_REPLACEMENT_TEARDOWN_TIMEOUT_MS` | `3000` | `:62` |
| `DEFAULT_REPLACEMENT_TEARDOWN_POLL_MS` | `50` | `:61` |
| `REDACTED_BSSID` | `"02:00:00:00:00:00"` | `:63` |
| `UNKNOWN_SSID` | `"<unknown ssid>"` | `:64` |

`request(DeviceWifiConnectRequest): DeviceWifiCandidate`（挂起，`DeviceNetworkController.java:247`）严格顺序：

1. `enabled == false` → `DeviceWifiRequestException(DISABLED)`（`:269-271`）
2. `Build.VERSION.SDK_INT < 29` → `DeviceWifiRequestException(UNSUPPORTED_ANDROID_VERSION)`（`:272-274`）——`WifiNetworkSpecifier` 需要 Android 10
3. `DeviceWifiNetworkRequestFactory.INSTANCE.build(request)`；`IllegalArgumentException` 被翻译成 `DeviceWifiRequestException(INVALID_REQUEST, e)`（`:276`、`:288-290`）
4. `requestMutex.lock()`（`MutexKt.Mutex$default(false,1,null)` 非公平锁，`:146`、`:282`）——**同一时刻只允许一个直连请求**
5. `releaseLiveLeasesBeforeReplacement()`（`:330`）
6. `requestCandidate(networkRequest)`（`:337`）
7. 无论成功/异常路径都 `requestMutex.unlock(null)`（`:322`、`:343`、`:346-347`）

第 5 步细节（`DeviceNetworkController.java:391-488`）：
- 先 `liveLeases.toList()` 快照，非空时打日志 `"Device Wi-Fi request is replacing " + N + " live lease(s)"` 并逐个 `close()`（`:414-422`）
- 再取 `retiringNetworks` 快照；为空直接返回（`:423-428`）
- `replacementTeardownTimeoutMs <= 0` 时**不等待**，只单次检查（`:430-443`）
- 否则 `withTimeoutOrNull(3000ms) { do { 全部网络都 getNetworkCapabilities()!=null ? 返回 true : delay(max(pollMs,1)) } }`（`:445-456` + 轮询体 `C2051x8dc3a708.java:57-69`，`delay` 值 = `RangesKt.coerceAtLeast(replacementTeardownPollMs, 1L)` = **50ms**）
- 超时/未完成：日志 `"Timed out waiting 3000ms for replaced device Wi-Fi to disconnect"` + 抛 `DeviceWifiRequestException(UNAVAILABLE)`（`:463-464`、`:486-487`）
- 成功：`retiringNetworks.removeAll(toSet(networks))`（`:459`）

第 6 步 `requestCandidate`（`DeviceNetworkController.java:630-838`）用 `suspendCancellableCoroutine`：
- **SDK>=31 用 `ConnectivityManager.NetworkCallback(1)`（即 `FLAG_AVAILABILITY_CALLBACKS_CARDED`，保证 onAvailable/onLost 成对投递）**，`<31` 用无参构造（`:651-709`）。两个回调都只覆写 `onAvailable / onCapabilitiesChanged / onUnavailable / onLost` 四个。
- `onAvailable`：先 `updateWifiIdentity()` 抓 SSID/BSSID，然后 CAS 只放行第一次，构造 `DeviceWifiNetworkLease`、`registerLease()`，若已取消则 `lease.close()`，否则 `resume(DeviceWifiCandidate(lease, lease.termination))`（`:558-571`）
- `onCapabilitiesChanged` → `requestCandidate$lambda$20$updateWifiIdentity`：从 `NetworkCapabilities.getTransportInfo()` 里取 `WifiInfo`，写 `ssidRef`/`bssidRef`（规范化后非空才覆盖）（`:540-555`）
- `onUnavailable` → CAS + 反注册回调 + `resume` 失败 `DeviceWifiRequestException(UNAVAILABLE)`（`:574-580`）
- `invokeOnCancellation`：置 CAS 标志、关闭已建立的 lease，否则反注册（`:711-738`）
- `connectivityManager.requestNetwork(req, cb)` 抛 `SecurityException` → `PERMISSION_DENIED`（`:802-808`）；抛 `RuntimeException` → `INVALID_REQUEST`（`:809-816`）
- 反注册统一走 `requestCandidate$lambda$20$unregisterPendingCallback`，用 `runCatching` 吞异常（`:508-537`）

`DeviceWifiNetworkLease`（`DeviceWifiNetworkLease.java:22-75`）：持有 `network` + 两个 `AtomicReference<String>`（ssid/bssid）+ `CompletableDeferred<Unit> unavailableSignal`（`:44`）；`close()` 用 CAS，先 `unavailableSignal.complete(Unit)`，再 `releaseCallback()`，再 `onClosed(this)`（`:68-74`）。`termination` 就是调用方 `await()` 该 Deferred 来感知网络消失。

归一化函数（`DeviceNetworkController$Companion`，`DeviceNetworkController.java:610-624`）：
- `normalizeSsid`：`removePrefix("\"")` → `removeSuffix("\"")` → 空白或等于 `<unknown ssid>` 返回 null
- `normalizeBssid`：空白或 `equals("02:00:00:00:00:00", ignoreCase=true)` 返回 null

`bssidFor(Network)`（`DeviceNetworkController.java:160-237`）四级回退：① 活跃 lease 记录的 bssid；② SDK>=29 时 `NetworkCapabilities.getTransportInfo() as WifiInfo` 的 `getBSSID()`；③ `WifiManager.connectionInfo.ipAddress` 拆成 `a.b.c.d` 与该 Network 的 `LinkProperties.linkAddresses` 逐地址比对，命中才取 `connectionInfo.getBSSID()`；④ null。整体 catch `SecurityException` → null。

会话侧 API：`adopt(sessionId, lease): Boolean`（`:351-365`，要求 lease 活跃且仍在 `liveLeases` 中；同 sessionId 覆盖时 `close()` 旧 lease）、`releaseSession(sessionId)`（`:367-373`）、`clear()`（`:375-384`）。

上层调用时机（`DeviceWifiConnectionCoordinator.java`，`connect-hUnOzRk`）：
1. 生成 `sessionId = deviceType.name().lowercase(ROOT) + "-connect-" + UUID.randomUUID()`（约 `:186-190` 区段）
2. `deviceSessionManager.closeAll(DEVICE_WIFI_REPLACEMENT_REASON)`，常量 `DEVICE_WIFI_REPLACEMENT_REASON = "device Wi-Fi request replacement"`（`DeviceWifiConnectionCoordinator.java:39`）
3. `deviceNetworkController.request(...)` 拿 `DeviceWifiCandidate`
4. `probeWhileCandidateAvailable(candidate)` 在 lease 存活期间做协议探测（`:436-466`，内部 `coroutineScope{}`）
5. 探测成功后回填 `ConnectedDevice.ssid / apBssid / pwd / sessionId`（`:391-405`）
6. 非 RIDE5 且 `boardversion` 空白 → `close(sessionId, "RIDE5 attributes are incomplete")` + `lease.close()` + 失败 `IllegalStateException("Device attributes are incomplete")`（`:407` 前后，逻辑见 `:289-300`）
7. `deviceNetworkController.adopt(sessionId, lease)` 成功返回设备；失败 `lease.close()` + `DeviceWifiRequestException(UNAVAILABLE)`（`:409-415`）
8. 任何 `CancellationException` / `Throwable` 路径都会 `lease.close()`（`:253-262`、`:416-421`）

配套扫描器 `DeviceWifiScanner`：`DEFAULT_SCAN_TIMEOUT_MS = 8000`（`DeviceWifiScanner.java:42`），`withTimeoutOrNull` 等扫描结果（`:120`），`wifiManager.startScan()`（`:280`）与 `getScanResults()`（`:200`）都包 `runCatching`。

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

**与 `RoutedOkHttpProvider` 的分工**：`bindProcessToNetwork` 是「整个进程的默认网络切换」，粗粒度、会互相冲突；`RoutedOkHttpProvider` 是「按 socket 绑定」，两者在 `NetworkRuntime` 里同时存在（`NetworkRuntime.java:147` 建 `ProcessBindingController`，`:141` 建 `RoutedOkHttpProvider`），会话连接器（`M3SessionConnector` / `Ride3ProSessionConnector` / `Ride5SessionConnector`）拿 `processBindingController` 作为构造参数（`NetworkRuntime.java:329`、`:331`、`:332`、`:333`）。

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

`NetworkRuntime` 的订阅（`NetworkRuntime.java:372-377` 注册 → `:501-518` 处理）：

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
| `RouteLease(route, network, intent, profile, endpointGrantId, onClosed)` | `RouteLease.java:30-54` | 一次「持有路由」的凭证，可 `Closeable` |
| `RouteProvider.acquire(intent, profile, endpointGrantId=null): RouteLease` | `RouteProvider.java` | 唯一入口接口 |
| `RoutePermission` | `PROBE_ONLY` / `DEVICE_OPERATION`（`RoutePermission.java`） | 探测许可等级 |

`RouteId` 生成规则（`RouteRevisionManager.java:170-172`）：`plane.name().lowercase(Locale.ROOT) + "-" + networkHandle + "-" + generation`，例如 `device-12345@0x...-3`、`internet-42-1`。`unavailable(plane)` 造的是 `plane.lowercase + "-unavailable"`（`:238-240`）。

**`revision` 何时递增（= 失效点）** — `RouteRevisionManager.java`，全局 `nextRevision` 单调 `++`（`:247-251`），表按 `Key(networkHandle, plane)` 分桶：
- `upsert(handle, plane, available, state)`（`:162-184`）：该 key 首次出现或 `!present` → `generation+1`、新 `RouteId`、`revision = nextRevision()`；已存在且 **`available` 或 `state` 变了** → `revision = nextRevision()`；两者都没变 → **revision 不变**（稳定复用）
- `markLost(handle, plane)`（`:186-199`）：`present=false`、`available=false`、`revision++`、`state=LOST`
- `invalidate(handle, plane, state)`（`:208-219`）：`available=false`、`revision++`、`state=state`（默认 `UNAVAILABLE`，`:201-206`）
- `unavailable(plane)`（`:221-241`）：把该 plane 里所有 `present||available` 的条目全部 `present=false, available=false, revision++, state=UNAVAILABLE`，返回 `RouteSnapshot(RouteId("<plane>-unavailable"), -1L, this.nextRevision, plane, UNAVAILABLE)`
- `clear()`（`:243-245`）：清空 entries（**注意：不重置 `nextRevision`**）

**DEVICE 面的状态推进**（`DeviceRouteRegistry.java`）：
`markCandidate(sessionId, handle)` → `upsert(DEVICE, available=true, CANDIDATE)`（`:75-84`）→ `markProbing` → `PROBING`（`:86-95`）→ `verify(sessionId, handle, DeviceIdentity)` → `upsert(..., VERIFIED)`（`:97-116`）。`reject(sessionId, state=REJECTED)`（`:125-144`）、`closeSession(sessionId)` → `invalidate(..., LOST)`（`:150-185`）、`invalidateNetwork(handle, state, networkLost)` → 命中该 handle 的所有 session 逐个 `markLost`（`networkLost=true`）或 `invalidate`（`:267-308`）。
**`RouteState.READY` 只用于 INTERNET 面**：唯一写入点是 `InternetRouteController.refresh()` 的 `upsert(handle, INTERNET, true, READY)`（`InternetRouteController.java:127`）；设备面代码里出现的 `READY` 只是 `setOf(VERIFIED, READY)` 这种**防御性兼容判定**（例如 `M3SessionReadiness.java:40`、`Ride5CgiGateway.java:1745-1747`、`StreamingTransferEngine.java:682`）。

`InternetRouteController.refresh()`（`InternetRouteController.java:83-127`）选路条件：`available` ∧ (`isWifi() || isCellular()`) ∧ `hasInternet && validated` ∧ `!isDeviceNetwork(observed)`（后者由 `NetworkRuntime` 注入为 `deviceRoutes.isReservedNetwork(handle)`，`NetworkRuntime.java:185-195`）；排序 `compareByDescending(isCellular)` 再 `thenBy(networkHandle)`（`:104-118`），即**优先蜂窝、其次 handle 小的**。若当前 route 的 handle 与选出的不同 → 先 `invalidate` 旧 handle 再 upsert。

**`acquire` 的门禁（`SnapshotRouteProvider.java:136-187`）** —— 逐条：
1. `intent` 是 `NetworkIntent.Internet` → `internetRouteProvider()`；是 `NetworkIntent.Device` → `deviceRouteProvider(sessionId)`，null 则 `RouteUnavailableException("No device route for session " + sessionId)`（`:141-153`）
2. 状态门禁（`:156-166`）：
   - INTERNET：`plane == INTERNET && state == READY`
   - DEVICE + `profile != DEVICE_PROBE`：`plane == DEVICE && state ∈ {VERIFIED, READY}`
   - DEVICE + `profile == DEVICE_PROBE`：`plane == DEVICE && state ∈ {CANDIDATE, PROBING, VERIFIED, READY}`
3. DEVICE 且 `profile != DEVICE_PROBE` 且 `endpointGrantId` 空白 → `EndpointGrantRequiredException("Device operation requires EndpointGrant: session=...")`（`:167-170`）——**除探测外，任何设备操作都必须先拿到 EndpointGrant**
4. 门禁不过 或 `networkHandle < 0` → `RouteUnavailableException("Route is not ready for <IntentSimpleName>: <routeId>@<revision>")`（`:171-173`）
5. `endpointGrantValidator(sessionId, grantId, revision, purpose)` 返回 false → `EndpointGrantRequiredException("EndpointGrant is not valid for <purpose> session <id>@<revision>")`（`:174-179`）——**grant 是按 revision 绑定的，路由换代后 grant 自动失效**
6. `networkProvider(networkHandle)` 为 null → `RouteUnavailableException("Android Network is unavailable for <routeId>@<revision>")`（`:180-183`）；该 provider 在 `NetworkRuntime.java:223-239` 实现为 `topology.observation(handle)?.network`
7. `new RouteLease(...)` + `leaseRegistry.register(lease)`（`:184-185`）

`profile → EndpointPurpose` 映射（`SnapshotRouteProvider.endpointPurpose`，`:198-237`）：`DEVICE_PROBE→PROBE`、`DEVICE_FILE→FILE`、`DEVICE_IMAGE→IMAGE`、`DEVICE_MENU→MENU`、`DEVICE_DIAGNOSTIC→DIAGNOSTIC`、`DEVICE_UPLOAD→OTA`、`DEVICE_LONG_OPERATION→OTA`、`DEVICE_CONTROL→CONTROL`；未命中（即 INTERNET_* profile）回落到 `intent.operation`：`PROBE→PROBE, CONTROL→CONTROL, FILE→FILE, IMAGE→IMAGE, MEDIA→MEDIA, CALLBACK→CALLBACK, OTA→OTA, DIAGNOSTIC→DIAGNOSTIC`。
`HttpClientProfile` 全集 11 个（`HttpClientProfile.java`）：`INTERNET_API, INTERNET_DOWNLOAD, INTERNET_UPLOAD, DEVICE_PROBE, DEVICE_CONTROL, DEVICE_DIAGNOSTIC, DEVICE_LONG_OPERATION, DEVICE_FILE, DEVICE_MENU, DEVICE_UPLOAD, DEVICE_IMAGE`。
`DeviceOperationKind` 8 个（`DeviceOperationKind.java`）：`PROBE, CONTROL, FILE, IMAGE, MEDIA, CALLBACK, OTA, DIAGNOSTIC`。

**`RouteLease` 生命周期**（`RouteLease.java`）：内部 `cancellation = SupervisorJob()`（`:53`）、`closed = AtomicBoolean(false)`（`:52`）；`isActive() = !closed && cancellation.isActive()`（`:80-82`）；`requireActive()` 抛 `RouteSupersededException("Route lease is no longer active: <routeId>@<revision>")`（`:84-89`）；`invalidate(RouteSupersededException)` CAS 后 `cancellation.cancel(cause)` 并回调 `onClosed`（`:171-177`）；`close()` CAS 后 `cancellation.cancel()` + `onClosed`（`:180-185`）；`withCancellation(block)` 在 `coroutineScope{}` 里以 `CoroutineStart.UNDISPATCHED` 起一个 `routeWatcher` 协程，等待 lease 失效即抛（`:145-169`）。`onClosed` 在 `SnapshotRouteProvider$acquire$lease$1` 里就是 `leaseRegistry.unregister(lease)`。

**失效重建链路**（一次换代做了什么）：
`DeviceRouteRegistry` 的 `onRouteChanged` 回调（`NetworkRuntime.java:163-168`）依次调用
`leaseRegistry.invalidate(route)` → `clientRegistry.invalidate(route)` → `processBindingController.invalidate(route)`；
`SnapshotRouteProvider.invalidate(route)` 也转发到 `leaseRegistry.invalidate`（`SnapshotRouteProvider.java:189-192`）。
被 `invalidate` 的 lease 抛 `RouteSupersededException` 取消其 `SupervisorJob`，所有挂在 `withCancellation` 里的请求当场失败；`RouteScopedClientRegistry` 在 `registerLeaseKey` 时对 lease 的 `cancellation.invokeOnCompletion { close(lease) }`（`RouteScopedClientRegistry.java:342-359`），于是 OkHttp client / Retrofit service / ConnectionPool 一起被回收。
`RouteScopedClientRegistry.invalidate(route)`（`:144-208`）的删除条件（三张表一致）：`key.plane == route.plane` ∧ (`route.networkHandle < 0` ∨ `key.networkHandle == route.networkHandle`) ∧ **`key.routeRevision <= route.revision`**。清理动作在名为 `TuwinRouteCleanup` 的单线程 daemon executor 上执行（`:559-574`）：`dispatcher().cancelAll()` → `executorService().shutdown()` → 私有 `ConnectionPool.evictAll()` → `cache()?.close()`（`:385-403`）。
重建：上层连接器捕获 `RouteSupersededException` 后用新 `sessionId`/新 `EndpointGrant` 重新 `acquire`（例如 `Ride5CallbackChannel.java:403`、`Ride3ProSessionTransport.java:179`、`:375` 都显式比对 `route.revision != getRouteRevision()` 来决定重连）。

### 1.7 `RoutedOkHttpProvider` / `RoutedRetrofitProvider`：socket 如何绑到 Network

`RoutedOkHttpProvider.client(lease, profile = lease.profile, endpointGrantId = lease.endpointGrantId, configure = {}): OkHttpClient`（`RoutedOkHttpProvider.java:68-110`），工厂 lambda 内部：
- `lease.requireActive()` 先跑（`:72`），工厂内还会被 registry 再跑两次（`RouteScopedClientRegistry.java:101`、`:104`、`:113`）
- 缓存键：`RouteClientKey(plane, networkHandle, routeRevision = route.revision, endpointGrantId, profile)`（`RouteScopedClientRegistry.java:102`）——**revision 进 key，所以换代必然新 client**
- `Network network = lease.getNetwork()`，null → `RouteUnavailableException("No Network object for <plane>@<handle>")`（`:83-84`、`:107`）
- **绑 socket 的两处**：`.socketFactory(network.getSocketFactory())`（`:97-100` 与 `:103-105` 各取一次，后者覆盖前者）
- **绑 DNS**：自定义 `Dns` 调 `network.getAllByName(hostname)`（`:87-95`），绕开系统默认网络解析
- 超时：`connectTimeout / readTimeout / writeTimeout`，单位 `TimeUnit.SECONDS`，值取自 `timeoutSeconds(profile)`（`:96`）
- `retryOnConnectionFailure(false)`（`:96`、`:105`）、`followRedirects(false)`、`followSslRedirects(false)`（`:100`、`:105`）
- `connectionPool(registry.getOrCreateConnectionPool(lease, profile))`（`:102`），池 key = `RouteConnectionPoolKey(plane, networkHandle, revision, profile)`（`RouteScopedClientRegistry.java:73`），值是 `new ConnectionPool()`（默认参数，未自定义 keepAlive/maxIdle）（`:78`）

**`timeoutSeconds(profile)` 全表**（`RoutedOkHttpProviderKt.java:68-92`，`(connect, read, write)` 秒）：

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

`RoutedRetrofitProvider.create(lease, baseUrl, serviceClass, profile = ?, endpointGrantId = ?, configureClient = {}, configureRetrofit = {})`（`RoutedRetrofitProvider.java:30-56`）：先 `okHttpProvider.client(...)`，再 `normalizeBaseUrl`（trim；空 → `IllegalArgumentException("Retrofit base URL cannot be empty")`；不以 `/` 结尾则补 `/`，`:58-64`），最后把 `Retrofit.Builder().baseUrl(...).client(...)` + `configureRetrofit` + `.build().create(serviceClass)` 塞进 service 缓存 `RouteServiceKey(clientKey, baseUrl, serviceClass.getName())`（`RouteScopedClientRegistry.java:118-142`）。`close(lease)` 只是转发 `okHttpProvider.close`（`:25-28`）。

### 1.8 超时与重试数值汇总（联网层）

| 项 | 值 | 位置 |
|---|---|---|
| 直连替换旧 lease 的等待上限 | `3000 ms` | `DeviceNetworkController.java:62` |
| 直连替换轮询间隔 | `50 ms`（`coerceAtLeast(pollMs,1)`） | `DeviceNetworkController.java:61` + `C2051x8dc3a708.java:69` |
| Wi-Fi 扫描等待 | `8000 ms` | `DeviceWifiScanner.java:42` |
| Android 最低版本（WifiNetworkSpecifier） | `29` | `DeviceNetworkController.java:272` |
| 回调 carded flag 生效版本 | `31` | `DeviceNetworkController.java:651` |
| OkHttp `retryOnConnectionFailure` | `false`（所有 profile） | `RoutedOkHttpProvider.java:96`、`:105` |
| OkHttp 重定向 | `followRedirects=false`、`followSslRedirects=false` | `RoutedOkHttpProvider.java:100`、`:105` |
| 11 个 profile 的 connect/read/write | 见 1.7 表 | `RoutedOkHttpProviderKt.java:68-92` |
| 连接释放线程名 | `TuwinRouteCleanup`（daemon，单线程） | `RouteScopedClientRegistry.java:571` |

---

## 2. 文件下载与断点续传

存在**两套**下载实现，同时活着：
- **A. 新传输层**：`core/transfer/*`（`StreamingTransferEngine` + `TransferQueue` + `ResumePolicy`），走 EndpointGrant/RouteLease，支持 checkpoint 续传。
- **B. 旧 `DownloadUtil` 路径**：`core/util/download/DownloadFileExecution`，直接用 `OkHttpClient.newCall(...).enqueue(...)`，靠 `?offset=` 自己重试。
两者共用同一个版本门限策略 `Ride3ProPlaybackDownloadResumePolicy`。

### 2.1 URL 构造与 `?offset=` 语义

**设备 URL 的唯一出口**是 `DeviceUrlBuilder.buildAuthorizedHttpUrl(authority, grantId, sessionId, routeRevision, purpose, relativePath)`（`DeviceUrlBuilder.java:183-215`）：
- `authority.grantFor(grantId)`，`grant.protocol != HTTP` → `IllegalArgumentException("Device HTTP URL requires an HTTP EndpointGrant")`（`:191-193`）
- `grant.allowedPorts` 必须**恰好一个端口**，否则 `IllegalArgumentException("Device HTTP EndpointGrant must contain one port")`（`:194-197`）
- host 含 `:` 且不以 `[` 开头 → 加方括号包成 IPv6 字面量（`:199-203`）
- relativePath trim 后为空 → `IllegalArgumentException("Device relative path is empty")`；含 `"://"` → `IllegalArgumentException("Device URL builder accepts relative paths only")`（`:204-213`）
- 最终：`authority.authorizeUrl(grantId, sessionId, routeRevision, purpose, "http://" + host + ":" + port + "/" + removePrefix(path,"/")).getUrl()`（`:214`）——**注意是 `http://`，全程明文，无 TLS**
- 若 grant 拿不到，各 `buildXxxUrl` 走 `unavailable(kind)`：打日志 `"DeviceUrlBuilder: <kind> skipped because EndpointGrant is unavailable"` 并返回**空串**（`DeviceUrlBuilder.java:252-255`）
- 遗留的 5 个 `buildM3DownloadUrl / buildM3ThumbnailUrl / buildRide5ThumbnailUrl / buildRide3ProThumbnailUrl / buildRide3ProRawDataUrl / buildRide5DownloadUrl`（`:61-93`）现在**全部直接返回 unavailable**，只有 `buildM3ThumbnailUrl` 例外——它返回本地 `M3ThumbnailCache` 文件绝对路径（`:66-75`）

**`?offset=` 的注入点**：`Ride3ProPlaybackDownloadResumePolicy.withOffset(url, offset)`（`Ride3ProPlaybackDownloadResumePolicy.java:233-239`）

```java
if (offset < 0) throw new IllegalArgumentException("resume offset must not be negative");
return HttpUrl.get(url).newBuilder()
        .setQueryParameter("offset", String.valueOf(offset))
        .build().getUrl();
```

`setQueryParameter` 是**替换**语义（同名参数只留一个），所以重试时 offset 一定被刷新为当前文件长度。
语义 = 「请从第 offset 字节开始给我剩下的内容」，**十进制无单位**，是设备私有 CGI 参数，不是标准 HTTP。

调用点：`DownloadFileExecution.executeAttempt`（`DownloadFileExecution.java:115-123`）——`if (resumeDecision.enabled) url = withOffset(sourceUrl, offset) else url = sourceUrl`，然后 `client.newCall(new Request.Builder().url(url).build())`（`:123`），**该 Request 不带任何 header**。

新传输层里 offset 策略被抽象为 `ResumePolicy`（`ResumePolicy.java`），4 个实现：

| 策略 | 载体 | 语义 |
|---|---|---|
| `Disabled` | — | 不续传，永远从头 |
| `HttpRange` | `Range: bytes=N-` | **仅允许 `AuthorizedTransferSource.Internet` 使用** |
| `DeviceOffset(headerName)` | 请求头，头名由参数给 | 设备侧 header 式续传 |
| `DeviceQueryOffset(parameterName)` | 查询参数，参数名由参数给 | 设备侧 query 式续传；实际用的名字是 **`"offset"`** |

`DeviceQueryOffset("offset")` 的唯一实例化点：`DownloadUtil.java:1370`（`startRoutedDeviceDownload` 内，条件 `z = (deviceType==RIDE3PRO || deviceType==RIDE6) && decision.enabled`，`:1365`）；不满足时是 `ResumePolicy.Disabled.INSTANCE`（`:1372`）。

`TransferRequest` 构造期校验（`TransferRequest.java:133-179`）：
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
- 旧路径：`DownloadUtil.resolveRide3ProFirmwareVersion(url)` → `DeviceUrlBuilder.getConnectedDeviceVersion(deviceType)`，从 `PreferenceHelper.getCacheDevices()` 里找第一个 `isConnected() && deviceType` 匹配的 `ConnectedDevice.getVersion()`（`DownloadUtil.java:1566-1575`、`DeviceUrlBuilder.java:230-250`）
- 新路径：`resolveRouteFirmwareVersion(networkRoute)` → `deviceSessionManager.snapshot(sessionId).identity.firmwareVersion`，包 `runCatching`（`DownloadUtil.java:1578-1591`）
- `startRoutedDeviceDownload` 走的是后者（`DownloadUtil.java:1354-1363`）

日志（`logRide3ProResumeDecision`，`DownloadUtil.java:1602-1610`），三条原样：
- `"Ride3Pro rawdata resume enabled firmware=" + fv + " max_retries=5"`
- `"Ride3Pro rawdata resume disabled reason=legacy_firmware firmware=" + fv + " minimum=v1.20260708.101448"`
- `"Ride3Pro rawdata resume disabled reason=" + reason.lowercase() + " firmware=" + fv`

### 2.3 是否禁用 HTTP `Range`：在哪禁、为什么

**结论：对相机侧下载完全不用 `Range` 头。** 三条硬证据：

1. **全仓库搜索 `Range` 头写入点**：`grep '"Range"'` 在 `com/tuwinsmart/**` 里**只有一个命中**，且是**日志脱敏白名单**（`DiagnosticHttpLogPolicy.java:134` 的日志保留头列表 `{"Content-Type","Content-Length","Content-Range","Range","Retry-After","X-Ride3Pro-Request-Id","Request-Id"}`）。真正会写 `Range` 的只有三方库：`com/lzy/okserver/download/DownloadTask.java:201`、`com/danikula/videocache/HttpUrlSource.java:220-223`、阿里云 OSS —— **TUWIN 自身代码没有任何调用路径进入这些库的下载器**。
2. **请求构造处**：`DownloadFileExecution.java:123` 是 `new Request.Builder().url(strWithOffset).build()`，一个 header 都不加；`StreamingTransferEngine` 里唯一的另一处构造是上传（`:412`），也只有 `.method(str, progressRequestBody)`。
3. **策略层的显式禁止**：`TransferRequest` 校验里，**设备传输若使用 `ResumePolicy.HttpRange` 会直接抛异常**（`TransferRequest.java:163-165`，消息 `"Device transfer requires an explicit device offset policy"`）；反向地，`HttpRange` 只允许 `AuthorizedTransferSource.Internet`（`:172-174`）。也就是说**「Range 走外网、offset 查询参数走设备」是被类型系统锁死的**。

**为什么**：`acceptedResponseOffset(policy, requestedOffset, responseCode)`（`StreamingTransferEngine.java:804-817`）说明了设备侧不能信 Range 的原因——
- `HttpRange`：必须 `requestedOffset > 0 && responseCode == 206` 才承认续传成功，否则返回 0（当作从头开始，会把已写数据覆盖掉）
- `DeviceOffset` / `DeviceQueryOffset`：**直接 `return requestedOffset`，完全不看 responseCode**（`:807-808`）
即固件对 `?offset=` 的响应通常仍是 `200`（不是 `206`），若客户端按 Range 语义去校验状态码就会误判。同时 `DownloadFileExecution.writeResponseBody`（`:198-248`）用 `FileOutputStream(destination, append = offset > 0)` 落盘，`StreamingTransferEngine.copyResponse` 用 `RandomAccessFile` + `offset==0 ? setLength(0) : seek(offset)`（`StreamingTransferEngine.java:898-913`）——**由客户端自己负责截断/定位**，不依赖服务端 206 语义。

`Content-Range` 仍被读，但只用于估算总大小：`contentRangeTotal(headers, offset, contentLength)`（`:1016-1028`）取 `Content-Range` → `substringAfter('-')` → `substringBefore('/')` → `toLongOrNull`，若 `>= offset` 则返回 `该值 + 1`；否则回退 `offset + contentLength`；再不行返回 null。

### 2.4 并发度、缓冲区与队列

| 项 | 值 | 位置 |
|---|---|---|
| 读缓冲（旧路径） | `byte[8192]` | `DownloadFileExecution.java:216` |
| 读缓冲（新路径 `copyResponse`） | `byte[8192]` | `StreamingTransferEngine.java:917` |
| 落盘方式（旧） | `FileOutputStream(dest, append = offset>0)` | `DownloadFileExecution.java:210-213` |
| 落盘方式（新） | `RandomAccessFile(dest,"rw")`；`offset==0` → `setLength(0)`，否则 `seek(offset)` | `StreamingTransferEngine.java:882`、`:898-913` |
| 写盘调度 | `withContext(Dispatchers.IO)` | `StreamingTransferEngine.java:1011` |
| 每轮读后检查 | `ensureActive()`（协程取消即刻中断） | `StreamingTransferEngine.java:919` |
| 下载 scope | `CoroutineScope(SupervisorJob() + Dispatchers.IO)` | `DownloadUtil.java:130` |
| 传输 scope（NetworkRuntime） | `CoroutineScope(SupervisorJob() + Dispatchers.IO)` | `NetworkRuntime.java:280` |
| 设备 HTTP 超时（旧常量） | `DEVICE_HTTP_TIMEOUT_SECONDS = 5` | `DownloadUtil.java:122` |
| `DEVICE_FILE` profile 超时 | connect 5s / read 30s / write 30s | `RoutedOkHttpProviderKt.java:85-88` |
| `INTERNET_DOWNLOAD` profile 超时 | connect 10s / read 60s / write 60s | `RoutedOkHttpProviderKt.java:72-73` |
| OkHttp 自动重试 | `retryOnConnectionFailure(false)` | `RoutedOkHttpProvider.java:96`、`:105` |
| 重定向 | `followRedirects(false)` + `followSslRedirects(false)`；下载 client 再 `newBuilder()` 显式关一次 | `RoutedOkHttpProvider.java:100`、`StreamingTransferEngine.java:695` |
| 每个 lease 独立连接池 | `new ConnectionPool()`（OkHttp 默认 5 idle / 5 min keep-alive），key 含 revision | `RouteScopedClientRegistry.java:73-83` |

**并发度**：**同一 session 内串行**。
- `ScopedTransferQueue.submit(namespace, id, block)`（`ScopedTransferQueue.java`）以 `(namespace, TransferId)` 为 `QueueKey` 去重：`results.putIfAbsent` 已有就直接返回同一个 `CompletableDeferred`，即**同一任务重复 submit 得到同一结果**（不是并发跑两份）。Job 用 `CoroutineStart.LAZY` 启动。
- `DeviceTransferQueue.submit(request)` 的 namespace = `namespace(sessionId)`（`DeviceTransferQueue.java`），即**按设备会话分桶**；`InternetTransferQueue` 同理按外网命名空间。
- 真正的串行化由 `Ride3ProRequestScheduler` 完成：`PriorityQueue<Pending> queue` + `Channel<Unit> wakeup`（`Channel$default(-1, null, null, 6, null)` = **CONFLATED**，`Ride3ProRequestScheduler.java:173`）+ 单个 `worker` Job + 单个 `activeJob` 字段 → **一次只跑一个请求**，按 `Ride3ProRequestPriority` 出队。
- `requiresIsolatedRide3ProConnection(request)`（`StreamingTransferEngine.java:766-778`）：`(RIDE3PRO || RIDE6) && grant.purpose == FILE && url.encodedPath == "/api/playback/rawdata"` 时要求独占连接。
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
- `handleAttemptFailure`（`:251-268`）：`retryPlan = resumeDecision.enabled ? nextRetry(completedRetries, destinationFile.length()) : null`；`nextRetry` 在 `completedRetries >= 5` 时返回 **null**（`Ride3ProPlaybackDownloadResumePolicy.java:248-250`）→ 终态。
  - 有 plan：日志 `download_retry_scheduled` 带 `retry / max_retries=5 / offset / error_type`，`publishWaitingForRetry(offset)`（`progress.status = 1`、`speed = 0`）后 **立即 `executeAttempt(retryCount, offset)` 递归**（无退避延时）
  - 无 plan：日志 `"Ride3Pro rawdata resume exhausted retries=<n> offset=<len>"` → `publishTerminalError`（`progress.status = 4`）+ `onError(message)`
- 进度里程碑：每 25% 记一次 `download_progress`（`(coerceIn(percent,0,100)/25)*25 >= 25 && > lastLoggedMilestone`，`:291`）
- 完成：`publishFinished` → `progress.status = 5`、`currentSize = file.length()`、`fraction = 1.0f`，可选 `addFileToMediaStore`、EventBus `TaskDownloadFinishEvent`，最后 `onSuccess(absolutePath)`（`:368-390`）

**新路径 `StreamingTransferEngine` 的重试**：`TransferRetryPolicy.ResumeFromCheckpoint(maxRetries)`；`DownloadUtil.java:1376` 传的是 **`ResumeFromCheckpoint(5)`**，与旧路径同一个 5 次上限。续传点由 `ResumePolicyRegistry.resumeOffset(policy, checkpoint, localPart, source, route)`（`ResumePolicyRegistry.java:16-58`）裁决，**任一条件不满足就返回 0（从头下）**：
- `checkpoint == null` → 0
- `localPart` 不是文件 → 视为 null → 0
- `checkpoint.offset <= 0` → 0；`checkpoint.offset != localPart.length()` → 0（**本地分片被截/被改则放弃续传**）
- `checkpoint.sourceFingerprint != source.fingerprint` → 0（**换了源文件即作废**）
- `policy == Disabled` → 0
- `HttpRange`：source 必须是 Internet；且 `entityTag` 与 `lastModified` **至少一个非空白**，否则 0（弱校验器缺失就不敢续传）
- `DeviceOffset` / `DeviceQueryOffset`：source 必须是 Device，且 `checkpoint.routeRevision == route.revision` 且 `checkpoint.endpointGrantId == grant.id` → 才续传（**路由换代或 grant 换代即作废**）

传输层 EOF 特判：`isResponseHeaderEof(error)`（`StreamingTransferEngine.java:780-801`）= message 以常量 `UNEXPECTED_END_OF_STREAM_PREFIX = "unexpected end of stream on "` 开头 **且** cause 链上存在 `EOFException`。
租约失效：`withLeaseCancellation` 用 `IllegalStateException("Transfer route lease was closed")`（`api` 表 `:1082` 体内字面量）中断；`upload` 里 `CancellationException` 分类为 `"RouteSuperseded"` 或 `"Cancelled"`（`StreamingTransferEngine.java:329`、`:445-462`）。
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

RIDE3PRO/RIDE5 的文件列表不走这两个端点（走 `/api/playback/*` 与 `getmediafilelist` 系列，由 `VerifiedDeviceFileCatalog` 白名单化，见 `VerifiedDeviceFileCatalog.java:1011` 的 `"Ride3Pro file_index is outside the confirmed range"`），细节归机型附录。

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
| `suspend fun queryUpdate(): Boolean` | 问设备「你需不需要这个包」；`false` 表示无需升级，**直接回 IDLE 而非失败** | `DeviceOtaCoordinator.java:201`、`:325` |
| `suspend fun waitForDeviceReady(): Unit` | 等设备进入可接收固件的状态（通常在 VERIFYING 之后） | `:246`、`:366` |
| `suspend fun installUploadedPackage(): Unit` | 让设备开始装机（上传已完成之后） | `:276`、`:396` |
| `suspend fun waitForReboot(): Unit` | 等设备重启掉线 | `:284`、`:404` |
| `suspend fun reconnect(): Unit` | 重新建立直连路由/会话 | `:292`、`:412` |
| `suspend fun readVersion(): Unit`→`String` | 回读装机后的固件版本 | `:300`、`:420` |

配套类型：
- `DeviceOtaPlan(expectedVersion, packageFile, upload, operations, packageDownload, packageIntegrity, diagnostics)`（`DeviceOtaPlan.java`）；`packageDownload: TransferRequest?` **可为 null**（包已在本地时跳过下载）
- `DeviceOtaProgress(state, transferredBytes: Long?, totalBytes: Long?, routeRevision: Long?, error: Throwable?)`
- `DeviceOtaResult` 4 个子类：`Completed(version: String, routeRevision: Long)` / `UpdateUnavailable`(object) / `Cancelled`(object) / `Failed(error: Throwable)`
- 进度流：`val progress: StateFlow<DeviceOtaProgress>`，初值 `DeviceOtaProgress(IDLE, null, null, null, null)`（`DeviceOtaCoordinator.java:70`）

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
| `md5sum` | **App 侧对本地固件文件算 MD5**，`MessageDigest.getInstance("MD5")`，8192 字节流式读，逐字节 `String.format("%02x")` 拼接 → **32 位小写十六进制** | `data/repository/Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:135-157` |
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
- 解析不出来 → `IllegalStateException(getString(R.string.firmware_info_parse_failed_format, fileName))`（`Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:160-162`）
- 文件不存在 → `Result.failure(IllegalArgumentException(getString(R.string.firmware_file_not_exist)))`（`:79-82`）

**M3 通道没有 md5/model/hw/sw**（`data/source/remote/api/p006m3/M3ApiService.java:134-135`）：

```java
@Streaming @POST("/upload/{savepath}/{filesize}")
Object uploadFirmware(@Path(encoded = true, value = "savepath") String,
                      @Path("filesize") long, @Body RequestBody, ...);
```
调用点 `savepath` **硬编码 `"mnt/sdcard"`**，`filesize = file.length()`（`data/repository/M3DeviceRepositoryImpl$uploadFirmware$2.java:171`）。响应 `M3UploadResponse{result:int, info:String}`；结果分类见 `M3DeviceRepositoryImpl$uploadFirmware$2.java:152-180`（JADX 把 `when(result)` 反成 `if (result != 0)` 链，分支方向不可全信；可确定的是 **`result == 0` 为成功**，`2`、`3` 各有专属失败消息，其它值走 `R.string.upload_failed_format` 带 `result`）。

**Ride5 通道的两个 query 是设备给的、不是 App 算的**：`Ride5CgiApi.checkUpgradePacketInfo(@Query("-model"), @Query("-softversion"), @Query("-pktlen"))`（`core/device/ride5/Ride5CgiApi.java:20`）→ 响应解析出 `offset` 与 `unitsize` 两个字段（`UpgradeActivity.java:1473-1478`，缺任一个就 `IllegalArgumentException("RIDE5 OTA packet check did not return offset and unitsize")`）。

### 3.3 上传分块大小与超时

| 通道 | 分块 | 超时 | 证据 |
|---|---|---|---|
| 新架构（`StreamingTransferEngine.upload`） | 单请求整体流式，`ProgressRequestBody` 内部逐块写；profile 固定 `HttpClientProfile.DEVICE_UPLOAD` | connect `10s` / read `120s` / write `120s` | `StreamingTransferEngine.java:334`、`RoutedOkHttpProviderKt.java:82-84` |
| Ride3Pro Retrofit | `RequestBody.writeTo` 每次 `read` **8192 字节** → `sink.write` → `sink.flush()` → 回调 `onProgress(已传, 总长)` | `contentLength = file.length()`；MediaType = `OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE`（`application/octet-stream`）；service provider = `Ride3ProSessionExecutorResolver.longOperationServiceOrLegacy()`（长操作 client） | `Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:86-131`、`Ride3ProFirmwareUploadRepository.java:41-47` |
| M3 Retrofit | 同上，**8192 字节/块**，每块后 `sink.flush()` + 进度回调 | 走 `M3HttpClientCompatibilityKt`：connect `5s` / read `120s` / write `120s` | `M3DeviceRepositoryImpl$uploadFirmware$2.java:104-135`、`catalog-ports.md:85-87` |
| Ride5 裸 socket | **块大小 = 设备返回的 `unitsize`**（`Integer.parseInt(unitsize)`），`offset = Long.parseLong(offset)` 作为续传游标；每个 `unitsize` 块**单独开一条 socket、单独发一个 multipart POST**；块内再按 **1024 字节** 写 | `socket.setSoTimeout(Ride3ProSessionTransport.MENU_CONNECT_TIMEOUT_MILLIS)` = **5000 ms** | `core/util/UpgradeDevice.java:712-801`（分块/续传）、`:151-199`（socket 与报文） |

Ride5 的报文是**手写的 HTTP/1.1**（`UpgradeDevice.java:173-188`），逐字抄：
- 固定 boundary：`--------------------------0f063f014f74bfea`（26 个 `-` + `0f063f014f74bfea`）
- 请求行/头：`POST /sd HTTP/1.1\r\nHost: <grant.host>\r\nUser-Agent: curl/7.50.3\r\nAccept: */*\r\nContent-Length: <bodyPart + sb.length>\r\nExpect: 100-continue\r\nContent-Type: multipart/form-data; boundary=------------------------0f063f014f74bfea\r\n\r\n`
- part 头：`--------------------------0f063f014f74bfea\r\nContent-Disposition: form-data; name="filename"; filename="<file.getName()>"\r\nContent-Type: application/octet-stream\r\n\r\n`
- part 尾：`\r\n--------------------------0f063f014f74bfea--\r\n`
- 字符集：`Charset.defaultCharset()`
- 端口：`grant.allowedPorts.size() == 1 ? first() : -1`；发之前 `endpointAuthority.authorizeSocket(endpointGrantId, sessionId, routeRevision, EndpointPurpose.OTA, host, port)`；socket 用 `deviceNetwork.getSocketFactory().createSocket(host, port)`（即绑到设备 Network）

新架构侧的校验：`upload` 前依次 `sourceFile.isFile()` 否则 `IllegalArgumentException("Transfer source file does not exist")`、`IntegrityVerifier.verify(sourceFile, integrityPolicy)`、`lease.route.revision == upload.target.grant.routeRevision` 否则 `IllegalArgumentException("Upload EndpointGrant does not match route revision")`（`StreamingTransferEngine.java:379-385`）。非 2xx 抛 `TransferHttpException(code, "Transfer upload failed: HTTP " + code)`（`:429`，注意 jadx 把 `isSuccessful()` 的条件反转了，语义是「不成功才抛」）。

### 3.4 14 态状态机：状态名、迁移条件、失败落点

`DeviceOtaState` 全部 14 个值（`core/update/DeviceOtaState.java`，按声明序）：
`IDLE, QUERYING, UPDATE_AVAILABLE, DOWNLOADING_PACKAGE, VERIFYING_PACKAGE, WAITING_FOR_DEVICE, UPLOADING_TO_DEVICE, INSTALLING, WAITING_FOR_REBOOT, RECONNECTING, CONFIRMING_VERSION, COMPLETED, FAILED, CANCELLED`

迁移驱动：`transition(state, plan)` 只写 `DeviceOtaProgress(state, null, null, plan.upload.target.grant.routeRevision, null)`（`DeviceOtaCoordinator.java:782-784`）；`failed(t)` 写 `FAILED` + error（`:792-795`）；`cancelled()` 写 `CANCELLED`（保留原 error，`:786-789`）。

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
迁移：`beginPreparing()`→`Preparing`；`beginUpload(p)`→`Uploading(coerceIn(p,0,99))`；`onUploadProgress(total,progress,signal)`→`percent = total>0 ? coerceIn((progress*100)/total,0,100) : 0`，`percent >= 100` 时按 `OtaCompletionSignal` 分叉：`UploadAccepted`→`AwaitingDeviceAcknowledgement`、`InstallationCompleted`→`InstallingAwaitingDeviceResult`（`OtaUpgradeFlow.java:66-84`）；`enterInstallingSafetyWindow(s)`→`InstallingSafetyWindow(coerceAtLeast(s,0))`；`installationSucceeded()`→`InstallationSucceeded`；`tickSafetyWindow(remaining)`→`InstallingSafetyWindow(coerceAtLeast(remaining,0))`；`awaitUserConfirmation()`→`AwaitingUserConfirmation`；`awaitReconnectVerification()`→`AwaitingReconnectVerification`；`fail(prompt)`→`Failed(prompt)`；`reset()`→`Idle`（`:87-112`）。
`getBlocksNavigation()` 为 true 的状态：`Preparing / Uploading / AwaitingDeviceAcknowledgement / InstallingAwaitingDeviceResult / InstallationSucceeded / InstallingSafetyWindow / AwaitingUserConfirmation`；为 false：`Idle / AwaitingReconnectVerification / Failed`（`:41-46`）——**装机安全窗与用户确认期禁止返回**。

### 3.5 装机后回读版本的代码路径

新架构：`CONFIRMING_VERSION` 里 `plan.operations.readVersion()` 与 `plan.expectedVersion` 严格 `Intrinsics.areEqual`（`DeviceOtaCoordinator.java:295-311`）。但**该接口无实现，故线上不会走到**。

线上实际（`UpgradeActivity`）：
1. `onCreate` 阶段先取**装机前**版本作为基线：`SessionBoundOtaIdentityPolicy.resolve(...)` → `setCurrentVersion(bean.getVersion())`、`currentBoardVersion`、`upgradeModel`（`UpgradeActivity.java:450-460`）。若解析不到同身份会话，直接 `Timber.w("固件升级拒绝未绑定同一设备身份的会话: identity=%s operation=%s type=%s")` + Toast `loading_failed` + `finish()`（`:451-456`）——**OTA 页强要求会话与设备身份绑定**。
2. 上传成功回调 → `onUploadSuccess()` → `suppressRepeatDownloadPrompt()` + `showInstallationSafetyDialog()`（`:543-558`）。安全窗常量 `COUNTDOWN_SECONDS = 30`（`:96`），`runInstallConfirmButtonCountdown(...)`（该方法 jadx 未能反出，`:1408`）。
3. 重启后靠 `FirmwareUpgradeReconnectGate` 判定「回连的是不是原来那台」（`core/util/FirmwareUpgradeReconnectGate.java`）：`markPending(ssid)` → `pending = true`、`pendingSsid = normalizeSsid(ssid)`（trim + `removeSurrounding("\"")`，空→null）；`isPending()` / `matches(ssid)`（**`pendingSsid == null` 时匹配任意 SSID**）；`completeIfMatches(ssid)` 命中才清 pending；`reset$app_release_64()` 全清。它是 `volatile` 静态单例，跨 Activity 生效。
4. 版本回读最终来源仍是会话 identity（重连后 `DeviceSessionManager` 重新探测出的 `identity.firmwareVersion`），并回填 `PreferenceHelper.getCacheDevices()` 里的 `ConnectedDevice.version`；`UpgradeActivity` 自己不再直连查版本。
5. 上传成功后清理本地包：`Ride3ProUpgradeSuccessPolicy.clearUploadedFirmware(file.getAbsolutePath())`（`UpgradeActivity.java:795`、`:823`）。

Ride5 的「装完」判定不是回读版本，而是**分块计数**：`getChunck(0, file)` 返回已推进的块号，`chunck >= chuncks` 才算 `onUploadSuccess()`，否则 `notifyUploadFailed()`（`UpgradeDevice.java:727-743`）；`notifyUploadFailed()` 无 listener 时 `mHandler.sendEmptyMessage(MSG_UPLOAD_FAILED)`，`MSG_UPLOAD_FAILED = 10003`（`:803-813`、`catalog-ports.md:188`）。

### 3.6 本地固件文件选择与校验

- 目录：`UpgradeHelper.UPGRADE_DIRECTORY_NAME = "upgrade"`（`core/util/UpgradeHelper.java:73`），`upgradeBaseDirectory()`（`:634`）
- 文件后缀：**`.appsw`**（Ride5/M3 老包）——`getMatchedFirmware()` = `list(name.endsWith(".appsw"))` 再 `Arrays.sort`（`UpgradeDevice.java:96-135`）；Ride3Pro 新包后缀是 **`.bin`**（正则 `_upgrade\.bin$`）
- 校验和：`hasUsableCachedPackage(filePath, expectedFileName, expectedFileSize)`（`UpgradeHelper.java:440`）——**只比文件名与字节大小，不比对包内容做哈希**
- **MD5**：只在 Ride3Pro 上传前算一次，用作 `md5sum` query 参数交给设备侧校验（算法 `MD5`，编码 `%02x` 小写 hex，无分隔符，32 字符；`Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:135-157`）。**App 侧不拿它跟服务端下发的值比对。**
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
- 去重键 `AppUpdateCheckKey(versionCode, releaseChannel, serverEnvironment)`；调用实参：`AppUpdateCheckKey(250, "stable", "production")`（`TuwinApplication.java:433`、`:146-147`）
- 端点：`@GET("appupdatecheker") @Query("version") String, @Query("platform") String`（`data/source/remote/api/TuwinSuspendApi.java`，注意拼写 `cheker`），`platform` 恒为 `"android"`（`RoutedAppUpdateGateway.java:51`）；baseUrl = `FeedbackApiEndpoint.BASE_URL = "http://ali.tuwinsmart.com/"`（`FeedbackApiEndpoint.java:10`）→ **明文 HTTP**；profile `HttpClientProfile.INTERNET_API`（connect 10 / read 30 / write 30）
- URL 合法性：`isNetworkDownloadUrl(s)` = `HttpUrl.parse(s)` 非空 && scheme ∈ {http,https} && `username` 空 && `password` 空 && `host` 非空（`AppUpdateCoordinatorKt.java`）
- 判定：`hasNewVersion == false` → `NO_UPDATE`；否则要求 `appInfo != null` 且 `isNetworkDownloadUrl(appInfo.downloadUrl)`，不满足 → `CHECK_FAILED` + `IllegalStateException("Invalid app update response")`（`AppUpdateCoordinator.java:514-522`；`:517` 的 `appInfo != null ||` 是 jadx 反转产物，原义为 `appInfo == null || !valid`）
- 路由不可用：捕获 `RouteUnavailableException` → `WAITING_FOR_INTERNET_ROUTE` + `WaitingForInternetRoute(key)`（`:498-500`），由 `NetworkRuntime.addInternetRouteListener` 在拿到 READY 路由后重新触发（`TuwinApplication.requestInternetRouteUpgradeCheck()` → `checkUpdateApi()` → `checkUpdate()`，`:688-694`）
- lease 存活检查：响应回来后先 `lease.requireActive()`（`:513`），`CancellationException` 中 `RouteSupersededException` 记 reason `"RouteSuperseded"`，其余 `"Cancelled"`（`:530-536`）
- 弹窗抑制：`appUpdatePromptKey(bean) = trim(version) + "|" + trim(downloadUrl)`，`presentedAppUpdateKeys` 集合去重；不在 `HomeActivity` 可展示时挂到 `pendingAppUpdateBean`，回 Home 后 `tryShowPendingAppUpdatePrompt()`（`TuwinApplication.java:468-498`、`:500-537`）
- 下载安装：落盘 `filesDir/app-updates/tuwin_smart_<System.currentTimeMillis()>.apk`，intent 走 `NetworkIntent.Internet("app_update_download")`，`ResumePolicy.Disabled` + `IntegrityPolicy.None`（**不校验 APK 哈希**），源经 `AuthorizedTransferSource.Internet.authorize(url, setOf(host))` 过 host 白名单策略；然后 `FileProvider.getUriForFile(activity, packageName + ".fileProvider", file)` + `Intent.ACTION_VIEW` + `application/vnd.android.package-archive` + flags `1`(FLAG_ACTIVITY_NEW_TASK) | `268435456`(FLAG_GRANT_READ_URI_PERMISSION)（`:578-611`、`:679-686`）
- 诊断事件名：`app_update_download_requested`，字段 `target_version / source(host+脱敏) / forced`（`:573`）

---

## 4. 预览与播放

### 4.1 ijkplayer / `IjkMediaPlayer` 初始化参数（key=value 逐项）

### 4.2 `FFmpegTexturePlayerView` / `FFmpegRtspOptions` 参数

### 4.3 GSY 播放器参数

### 4.4 `RtspTransport` 取值与选择逻辑

### 4.5 纹理渲染与 Surface 生命周期

### 4.6 失败重试与超时

---

## 5. 事件与状态推送

### 5.1 `core/event` 消息类型枚举与取值

### 5.2 `core/process` 消息类型枚举与取值

### 5.3 Flow 共享策略（回放 / 缓冲 / 并发）

### 5.4 推送断线后的恢复策略

---

## 6. 遥测与三方 SDK

### 6.1 友盟（Umeng）+ ucrash 初始化与 AppKey

### 6.2 Glide（含自定义 `core/glide`）

### 6.3 DataStore

### 6.4 WifiUtils 与其它内嵌库

### 6.5 域名逐条判定：真调用 vs 死字符串

---

## 7. 原生库

### 7.1 9 个 `.so` 的用途

### 7.2 `Java_*` 符号 → `external fun` 声明与调用点

---

## 8. 对既有文档的纠正

### 8.1 `docs/04-固件更新与功能差距.md`

### 8.2 `docs/05-网络API清单与安全评估.md`

### 8.3 `docs/03-品牌型号与协议矩阵.md` §1.3 / §1.4 / §1.6
