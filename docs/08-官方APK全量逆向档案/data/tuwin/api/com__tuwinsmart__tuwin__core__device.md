# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.core.device

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 28 个文件 / 39 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.core.device.C1887x48647739`
L14 · [class] final C1887x48647739 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/C1887x48647739.java`
注解：

字段/常量（6）：
- `Object L$0`  L15
- `Object L$1`  L16
- `Object L$2`  L17
- `int label`  L18
- `Object result`  L19
- `DeviceSessionManager.ManagedDeviceSession this$0`  L20

方法（1）：
- `Object invokeSuspend(Object obj)`  L29 @Override
### `com.tuwinsmart.tuwin.core.device.C1888xb9b59eeb`
L16 · [class] final C1888xb9b59eeb · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/C1888xb9b59eeb.java`
注解：

字段/常量（8）：
- `long J$0`  L17
- `Object L$0`  L18
- `Object L$1`  L19
- `Object L$2`  L20
- `Object L$3`  L21
- `int label`  L22
- `Object result`  L23
- `DeviceSessionManager.ManagedDeviceSession this$0`  L24

方法（1）：
- `Object invokeSuspend(Object obj)`  L33 @Override
### `com.tuwinsmart.tuwin.core.device.DeviceAdapter`
L12 · [interface] public DeviceAdapter · `com/tuwinsmart/tuwin/core/device/DeviceAdapter.java`
注解：

方法（2）：
- `DeviceAdapterSession createSession(DeviceSessionSnapshot session)`  L13
- `DeviceType getDeviceType()`  L15
### `com.tuwinsmart.tuwin.core.device.DeviceAdapterEvent`
L10 · [interface] public DeviceAdapterEvent · `com/tuwinsmart/tuwin/core/device/DeviceAdapterEvent.java`
注解：

字面量："Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterEvent$RouteSuperseded;" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterEvent;" · "routeRevision" · "(J)V" · "getRouteRevision" · "()J" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterEvent$ControlChannelFailed;" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterEvent;" · "cause" · "(Ljava/lang/Throwable;)V" · "getCause" · "()Ljava/lang/Throwable;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterEvent$CapabilityLoaded;" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterEvent;" · "capabilities" · "Lcom/tuwinsmart/tuwin/core/device/DeviceCapabilities;" · "(Lcom/tuwinsmart/tuwin/core/device/DeviceCapabilities;)V" · "getCapabilities" · "()Lcom/tuwinsmart/tuwin/core/device/DeviceCapabilities;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterEvent$ProtocolMessage;" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterEvent;" · "payload" · "(Ljava/lang/Object;)V" · "getPayload" · "()Ljava/lang/Object;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.core.device.DeviceAdapterEvent$CapabilityLoaded`
L106 · [class] public static final CapabilityLoaded · implements `DeviceAdapterEvent` · `com/tuwinsmart/tuwin/core/device/DeviceAdapterEvent.java`
注解：

字段/常量（1）：
- `DeviceCapabilities capabilities`  L107

方法（8）：
- `CapabilityLoaded copy$default(CapabilityLoaded capabilityLoaded, DeviceCapabilities deviceCapabilities, int i, Object obj)`  L109
- `DeviceCapabilities getCapabilities()`  L117
- `CapabilityLoaded copy(DeviceCapabilities capabilities)`  L121
    - 体内字面量："capabilities"
- `boolean equals(Object other)`  L126
- `int hashCode()`  L133
- `String toString()`  L137
    - 体内字面量："CapabilityLoaded(capabilities=" · ")"
- `public CapabilityLoaded(DeviceCapabilities capabilities)`  L141
    - 体内字面量："capabilities"
- `DeviceCapabilities getCapabilities()`  L146
### `com.tuwinsmart.tuwin.core.device.DeviceAdapterEvent$ControlChannelFailed`
L59 · [class] public static final ControlChannelFailed · implements `DeviceAdapterEvent` · `com/tuwinsmart/tuwin/core/device/DeviceAdapterEvent.java`
注解：

字段/常量（1）：
- `Throwable cause`  L60

方法（8）：
- `ControlChannelFailed copy$default(ControlChannelFailed controlChannelFailed, Throwable th, int i, Object obj)`  L62
- `Throwable getCause()`  L70
- `ControlChannelFailed copy(Throwable cause)`  L74
    - 体内字面量："cause"
- `boolean equals(Object other)`  L79
- `int hashCode()`  L86
- `String toString()`  L90
    - 体内字面量："ControlChannelFailed(cause=" · ")"
- `public ControlChannelFailed(Throwable cause)`  L94
    - 体内字面量："cause"
- `Throwable getCause()`  L99
### `com.tuwinsmart.tuwin.core.device.DeviceAdapterEvent$ProtocolMessage`
L153 · [class] public static final ProtocolMessage · implements `DeviceAdapterEvent` · `com/tuwinsmart/tuwin/core/device/DeviceAdapterEvent.java`
注解：

字段/常量（1）：
- `Object payload`  L154

方法（8）：
- `ProtocolMessage copy$default(ProtocolMessage protocolMessage, Object obj, int i, Object obj2)`  L156
- `Object getPayload()`  L164
- `ProtocolMessage copy(Object payload)`  L168
    - 体内字面量："payload"
- `boolean equals(Object other)`  L173
- `int hashCode()`  L180
- `String toString()`  L184
    - 体内字面量："ProtocolMessage(payload=" · ")"
- `public ProtocolMessage(Object payload)`  L188
    - 体内字面量："payload"
- `Object getPayload()`  L193
### `com.tuwinsmart.tuwin.core.device.DeviceAdapterEvent$RouteSuperseded`
L14 · [class] public static final RouteSuperseded · implements `DeviceAdapterEvent` · `com/tuwinsmart/tuwin/core/device/DeviceAdapterEvent.java`
注解：

字段/常量（1）：
- `long routeRevision`  L15

方法（8）：
- `RouteSuperseded copy$default(RouteSuperseded routeSuperseded, long j, int i, Object obj)`  L17
- `long getRouteRevision()`  L25
- `RouteSuperseded copy(long routeRevision)`  L29
- `boolean equals(Object other)`  L33
- `int hashCode()`  L40
- `String toString()`  L44
    - 体内字面量："RouteSuperseded(routeRevision=" · ")"
- `public RouteSuperseded(long j)`  L48
- `long getRouteRevision()`  L52
### `com.tuwinsmart.tuwin.core.device.DeviceAdapterOpenResult`
L16 · [class] public final DeviceAdapterOpenResult · `com/tuwinsmart/tuwin/core/device/DeviceAdapterOpenResult.java`
注解：

字段/常量（15）：
- `DeviceCapabilities capabilities`  L17
- `boolean controlChannelReady`  L18
- `EndpointGrant controlEndpointGrant`  L19
- `Flow<DeviceAdapterEvent> events`  L20
- `DeviceIdentity identity`  L21
- `EndpointGrant mediaEndpointGrant`  L22
- `EndpointGrant socketEndpointGrant`  L23
- `EndpointGrant endpointGrant4 = endpointGrant`  L33
- `EndpointGrant endpointGrant5 = endpointGrant2`  L37
- `EndpointGrant endpointGrant6 = endpointGrant3`  L41
- `DeviceCapabilities deviceCapabilities2 = deviceCapabilities`  L45
- `boolean z2 = z`  L49
- `EndpointGrant endpointGrant = this.mediaEndpointGrant`  L110
- `EndpointGrant endpointGrant2 = this.socketEndpointGrant`  L112
- `DeviceCapabilities deviceCapabilities = this.capabilities`  L114

方法（21）：
- `DeviceAdapterOpenResult copy$default(DeviceAdapterOpenResult deviceAdapterOpenResult, DeviceIdentity deviceIdentity, EndpointGrant endpointGrant, EndpointGrant endpointGrant2, EndpointGrant endpointGrant3, DeviceCapabilities deviceCapabilities, boolean z, Flow flow, int i, Object obj)`  L26
- `DeviceIdentity getIdentity()`  L57
- `EndpointGrant getControlEndpointGrant()`  L62
- `EndpointGrant getMediaEndpointGrant()`  L67
- `EndpointGrant getSocketEndpointGrant()`  L72
- `DeviceCapabilities getCapabilities()`  L77
- `boolean getControlChannelReady()`  L82
- `Flow<DeviceAdapterEvent> component7()`  L86
- `DeviceAdapterOpenResult copy(DeviceIdentity identity, EndpointGrant controlEndpointGrant, EndpointGrant mediaEndpointGrant, EndpointGrant socketEndpointGrant, DeviceCapabilities capabilities, boolean controlChannelReady, Flow<? extends DeviceAdapterEvent> events)`  L90
    - 体内字面量："identity" · "controlEndpointGrant" · "events"
- `boolean equals(Object other)`  L97
- `int hashCode()`  L108
- `String toString()`  L118
    - 体内字面量："DeviceAdapterOpenResult(identity=" · ", controlEndpointGrant=" · ", mediaEndpointGrant=" · ", socketEndpointGrant=" · ", capabilities=" · ", controlChannelReady=" · ", events=" · ")"
- `public DeviceAdapterOpenResult(DeviceIdentity identity, EndpointGrant controlEndpointGrant, EndpointGrant endpointGrant, EndpointGrant endpointGrant2, DeviceCapabilities deviceCapabilities, boolean z, Flow<? extends DeviceAdapterEvent> events)`  L123
    - 体内字面量："identity" · "controlEndpointGrant" · "events"
- `DeviceIdentity getIdentity()`  L136
- `EndpointGrant getControlEndpointGrant()`  L140
- `EndpointGrant getMediaEndpointGrant()`  L144
- `EndpointGrant getSocketEndpointGrant()`  L148
- `DeviceCapabilities getCapabilities()`  L152
- `boolean getControlChannelReady()`  L156
- ` DeviceAdapterOpenResult(DeviceIdentity deviceIdentity, EndpointGrant endpointGrant, EndpointGrant endpointGrant2, EndpointGrant endpointGrant3, DeviceCapabilities deviceCapabilities, boolean z, Flow flow, int i, DefaultConstructorMarker defaultConstructorMarker)`  L160
- `Flow<DeviceAdapterEvent> getEvents()`  L164
### `com.tuwinsmart.tuwin.core.device.DeviceAdapterRegistry`
L18 · [class] public final DeviceAdapterRegistry · `com/tuwinsmart/tuwin/core/device/DeviceAdapterRegistry.java`
注解：

字段/常量（3）：
- `LinkedHashMap<DeviceType, DeviceAdapter> byType`  L19
- `DeviceAdapter deviceAdapter`  L47
- `Set<DeviceType> setKeySet`  L57

方法（7）：
- `public DeviceAdapterRegistry()`  L22
- `public DeviceAdapterRegistry(List<? extends DeviceAdapter> adapters)`  L26
    - 体内字面量："adapters"
- ` DeviceAdapterRegistry(List list, int i, DefaultConstructorMarker defaultConstructorMarker)`  L35
- `void register(DeviceAdapter adapter)`  L39
    - 体内字面量："adapter" · "Adapter already registered for "
- `DeviceAdapter adapterFor(DeviceType deviceType)`  L46
- `throw new IllegalStateException( 22  + deviceType)`  L51
- `Set<DeviceType> registeredTypes()`  L56
### `com.tuwinsmart.tuwin.core.device.DeviceAdapterSession`
L13 · [interface] public DeviceAdapterSession · `com/tuwinsmart/tuwin/core/device/DeviceAdapterSession.java`
注解：

方法（4）：
- `Object close(Continuation<? super Unit> continuation)`  L22
- `DeviceSessionSnapshot getSession()`  L24
- `void invalidateForRoute(long newRouteRevision)`  L26
- `Object open(Continuation<? super DeviceAdapterOpenResult> continuation)`  L28
### `com.tuwinsmart.tuwin.core.device.DeviceAdapterSession$DefaultImpls`
L17 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/core/device/DeviceAdapterSession.java`
注解：

方法（1）：
- `void invalidateForRoute(DeviceAdapterSession deviceAdapterSession, long j)`  L18
### `com.tuwinsmart.tuwin.core.device.DeviceCapabilities`
L13 · [class] public final DeviceCapabilities · `com/tuwinsmart/tuwin/core/device/DeviceCapabilities.java`
注解：

字段/常量（2）：
- `long loadedAtRouteRevision`  L14
- `Set<String> names`  L15

方法（11）：
- `DeviceCapabilities copy$default(DeviceCapabilities deviceCapabilities, Set set, long j, int i, Object obj)`  L18
- `Set<String> component1()`  L28
- `long getLoadedAtRouteRevision()`  L33
- `DeviceCapabilities copy(Set<String> names, long loadedAtRouteRevision)`  L37
    - 体内字面量："names"
- `boolean equals(Object other)`  L42
- `int hashCode()`  L53
- `String toString()`  L57
    - 体内字面量："DeviceCapabilities(names=" · ", loadedAtRouteRevision=" · ")"
- `public DeviceCapabilities(Set<String> names, long j)`  L61
    - 体内字面量："names"
- ` DeviceCapabilities(Set set, long j, int i, DefaultConstructorMarker defaultConstructorMarker)`  L67
- `Set<String> getNames()`  L71
- `long getLoadedAtRouteRevision()`  L75
### `com.tuwinsmart.tuwin.core.device.DeviceControlChannelRecoveryResult`
L12 · [class] public final DeviceControlChannelRecoveryResult · `com/tuwinsmart/tuwin/core/device/DeviceControlChannelRecoveryResult.java`
注解：

字段/常量（2）：
- `DeviceCapabilities capabilities`  L13
- `Flow<DeviceAdapterEvent> events`  L14

方法（10）：
- `DeviceControlChannelRecoveryResult copy$default(DeviceControlChannelRecoveryResult deviceControlChannelRecoveryResult, DeviceCapabilities deviceCapabilities, Flow flow, int i, Object obj)`  L17
- `DeviceCapabilities getCapabilities()`  L28
- `Flow<DeviceAdapterEvent> component2()`  L32
- `DeviceControlChannelRecoveryResult copy(DeviceCapabilities capabilities, Flow<? extends DeviceAdapterEvent> events)`  L36
    - 体内字面量："capabilities" · "events"
- `boolean equals(Object other)`  L42
- `int hashCode()`  L53
- `String toString()`  L57
    - 体内字面量："DeviceControlChannelRecoveryResult(capabilities=" · ", events=" · ")"
- `public DeviceControlChannelRecoveryResult(DeviceCapabilities capabilities, Flow<? extends DeviceAdapterEvent> events)`  L62
    - 体内字面量："capabilities" · "events"
- `DeviceCapabilities getCapabilities()`  L69
- `Flow<DeviceAdapterEvent> getEvents()`  L73
### `com.tuwinsmart.tuwin.core.device.DeviceHostPolicy`
L13 · [class] public final DeviceHostPolicy · `com/tuwinsmart/tuwin/core/device/DeviceHostPolicy.java`
注解：

方法（3）：
- `private DeviceHostPolicy()`  L43
- `String hostFor(DeviceType deviceType)`  L46
    - 体内字面量："deviceType" · "192.168.169.1" · "192.168.25.1" · "192.168.0.1"
- `throw new NoWhenBranchMatchedException()`  L58
### `com.tuwinsmart.tuwin.core.device.DeviceHostPolicy$WhenMappings`
L18 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/device/DeviceHostPolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L19
### `com.tuwinsmart.tuwin.core.device.DeviceSessionBinding`
L11 · [class] public final DeviceSessionBinding · `com/tuwinsmart/tuwin/core/device/DeviceSessionBinding.java`
注解：

字段/常量（3）：
- `ConnectedDevice device`  L12
- `String identitySessionId`  L13
- `String operationSessionId`  L14

方法（12）：
- `DeviceSessionBinding copy$default(DeviceSessionBinding deviceSessionBinding, String str, String str2, ConnectedDevice connectedDevice, int i, Object obj)`  L16
- `String getIdentitySessionId()`  L30
- `String getOperationSessionId()`  L35
- `ConnectedDevice getDevice()`  L40
- `DeviceSessionBinding copy(String identitySessionId, String operationSessionId, ConnectedDevice device)`  L44
    - 体内字面量："identitySessionId" · "operationSessionId" · "device"
- `boolean equals(Object other)`  L51
- `int hashCode()`  L62
- `String toString()`  L66
    - 体内字面量："DeviceSessionBinding(identitySessionId=" · ", operationSessionId=" · ", device=" · ")"
- `public DeviceSessionBinding(String identitySessionId, String operationSessionId, ConnectedDevice device)`  L70
    - 体内字面量："identitySessionId" · "operationSessionId" · "device"
- `String getIdentitySessionId()`  L79
- `String getOperationSessionId()`  L83
- `ConnectedDevice getDevice()`  L87
### `com.tuwinsmart.tuwin.core.device.DeviceSessionBindingResolver`
L25 · [class] public final DeviceSessionBindingResolver · `com/tuwinsmart/tuwin/core/device/DeviceSessionBindingResolver.java`
注解：

字段/常量（8）：
- `Object objM3074constructorimpl`  L39
- `Result.Companion companion = Result.INSTANCE`  L48
- `Result.Companion companion2 = Result.INSTANCE`  L51
- `ConnectedDevice connectedDeviceResolve`  L73
- `String string`  L74
- `List<DeviceSessionSnapshot> list = activeSessions`  L90
- `DeviceSessionBindingResolver deviceSessionBindingResolver = INSTANCE`  L118
- `String string`  L155

方法（8）：
- `private DeviceSessionBindingResolver()`  L28
- `DeviceSessionBinding resolve$default(DeviceSessionBindingResolver deviceSessionBindingResolver, String str, String str2, DeviceType deviceType, List list, DeviceSessionManager deviceSessionManager, int i, Object obj)`  L31
- `DeviceSessionBinding resolve(String identitySessionId, String operationSessionId, DeviceType expectedDeviceType, List<ConnectedDevice> devices, DeviceSessionManager sessionManager)`  L38
- `DeviceSessionBinding resolve$default(DeviceSessionBindingResolver deviceSessionBindingResolver, String str, String str2, DeviceType deviceType, List list, List list2, int i, Object obj)`  L65
- `DeviceSessionBinding resolve(String identitySessionId, String operationSessionId, DeviceType expectedDeviceType, List<ConnectedDevice> devices, List<DeviceSessionSnapshot> activeSessions)`  L72
- `boolean isOperationReady(DeviceSessionSnapshot session, DeviceType expectedDeviceType)`  L133
- `boolean matchesDeviceIdentity(ConnectedDevice device, DeviceSessionSnapshot session, boolean allowExactSessionWithoutSerial)`  L137
- `String normalizedIdentityValue(String str)`  L154
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager`
L69 · [class] public final DeviceSessionManager · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager.java`
注解：

字段/常量（29）：
- `DeviceAdapterRegistry adapters`  L70
- `DeviceEndpointAuthority endpointAuthority`  L71
- `DeviceRouteRegistry routes`  L72
- `CoroutineScope scope`  L73
- `LinkedHashSet<Function2<String, Long, Unit>> sessionClosedListeners`  L74
- `LinkedHashMap<String, ManagedDeviceSession> sessions`  L75
- `ManagedDeviceSession managedDeviceSession`  L163
- `DeviceSessionState deviceSessionState`  L164
- `DeviceSessionManager$open$1 deviceSessionManager$open$1`  L217
- `ManagedDeviceSession managedDeviceSessionFind`  L218
- `Object obj = deviceSessionManager$open$1.result`  L229
- `int i = deviceSessionManager$open$1.label`  L231
- `DeviceSessionManager$recoverControlChannel$1 deviceSessionManager$recoverControlChannel$1`  L252
- `ManagedDeviceSession managedDeviceSessionFind`  L253
- `Object obj = deviceSessionManager$recoverControlChannel$1.result`  L264
- `int i = deviceSessionManager$recoverControlChannel$1.label`  L266
- `C18901 c18901`  L292
- `Long lBoxLong`  L293
- `DeviceSessionManager deviceSessionManager`  L294
- `List list`  L295
- `Object obj = c18901.result`  L306
- `int i = c18901.label`  L308
- `Set<String> setKeySet`  L373
- `C18911 c18911`  L393
- `DeviceSessionManager deviceSessionManager`  L394
- `String str2`  L395
- `Iterator it`  L396
- `Object obj = c18911.result`  L407
- `int i = c18911.label`  L409

方法（21）：
- `public DeviceSessionManager(DeviceRouteRegistry routes, DeviceEndpointAuthority endpointAuthority, DeviceAdapterRegistry adapters, CoroutineScope scope)`  L123
    - 体内字面量："routes" · "endpointAuthority" · "adapters" · "scope"
- ` DeviceSessionManager(DeviceRouteRegistry deviceRouteRegistry, DeviceEndpointAuthority deviceEndpointAuthority, DeviceAdapterRegistry deviceAdapterRegistry, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker)`  L137
- `StateFlow<DeviceSessionSnapshot> create(String sessionId, DeviceType deviceType, RouteSnapshot route, DeviceIdentity identity, EndpointGrant controlEndpointGrant, String callbackIp)`  L162
- `DeviceSessionSnapshot snapshot(String sessionId)`  L199
    - 体内字面量："sessionId"
- `StateFlow<DeviceSessionSnapshot> state(String sessionId)`  L204
    - 体内字面量："sessionId"
- `SharedFlow<DeviceAdapterEvent> events(String sessionId)`  L209
    - 体内字面量："sessionId"
- `Object m2715opengIAlus(String str, Continuation<? super Result<DeviceSessionSnapshot>> continuation)`  L216
- `throw new IllegalStateException( 91 )`  L234
- `Object m2716recoverControlChannelgIAlus(String str, Continuation<? super Result<DeviceSessionSnapshot>> continuation)`  L251
- `throw new IllegalStateException( 92 )`  L269
- `Object close$default(DeviceSessionManager deviceSessionManager, String str, String str2, Continuation continuation, int i, Object obj)`  L283
    - 体内字面量："requested"
- `Object close(String str, String str2, Continuation<? super Unit> continuation)`  L291
- `throw new IllegalStateException( 95 )`  L330
- `void routeRevisionChanged(DeviceRouteChange change)`  L353
    - 体内字面量："change"
- `Set<String> activeSessionIds()`  L372
- `void addSessionClosedListener(Function2<? super String, ? super Long, Unit> listener)`  L379
    - 体内字面量："listener"
- `Object closeAll$default(DeviceSessionManager deviceSessionManager, String str, Continuation continuation, int i, Object obj)`  L384
    - 体内字面量："runtime stopped"
- `Object closeAll(String str, Continuation<? super Unit> continuation)`  L392
- `throw new IllegalStateException( 100 )`  L417
- `ManagedDeviceSession find(String sessionId)`  L438
- `throw new DeviceSessionNotFoundException( 101  + sessionId)`  L443
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/device/DeviceSessionManager$ManagedDeviceSession;" · "id" · "initial" · "Lcom/tuwinsmart/tuwin/core/device/DeviceSessionSnapshot;" · "(Lcom/tuwinsmart/tuwin/core/device/DeviceSessionManager;Ljava/lang/String;Lcom/tuwinsmart/tuwin/core/device/DeviceSessionSnapshot;)V" · "_events" · "Lkotlinx/coroutines/flow/MutableSharedFlow;" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterEvent;" · "_state" · "Lkotlinx/coroutines/flow/MutableStateFlow;" · "activeAdapter" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterSession;" · "closed" · "Ljava/util/concurrent/atomic/AtomicBoolean;" · "eventJob" · "Lkotlinx/coroutines/Job;" · "Lkotlinx/coroutines/flow/SharedFlow;" · "getEvents" · "()Lkotlinx/coroutines/flow/SharedFlow;" · "getId" · "()Ljava/lang/String;" · "job" · "Lkotlinx/coroutines/CompletableJob;" · "openMutex" · "Lkotlinx/coroutines/sync/Mutex;" · "sessionScope" · "Lkotlinx/coroutines/CoroutineScope;" · "Lkotlinx/coroutines/flow/StateFlow;" · "getState" · "()Lkotlinx/coroutines/flow/StateFlow;" · "cancelForRoute" · "cause" · "reason" · "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "closeAdapterPreserving" · "adapter" · "primary" · "(Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterSession;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "invalidateForRoute" · "route" · "Lcom/tuwinsmart/tuwin/core/network/RouteSnapshot;" · "open" · "Lkotlin/Result;" · "open-gIAlu-s" · "(Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "openInternal" · "openInternal-gIAlu-s" · "recoverControlChannel" · "recoverControlChannel-IoAF18A" · "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "startEventCollection" · "Lkotlinx/coroutines/flow/Flow;" · "validateOpenResult" · "result" · "Lcom/tuwinsmart/tuwin/core/device/DeviceAdapterOpenResult;" · "app_release_64"
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$C18861`
L144 · [class] C18861 · extends `FunctionReferenceImpl implements Function1<DeviceRouteChange, Unit>` · implements `Function1<DeviceRouteChange, Unit>` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager.java`
注解：

方法（2）：
- `Unit invoke(DeviceRouteChange deviceRouteChange)`  L150 @Override
- `void invoke2(DeviceRouteChange p0)`  L156
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$C18901`
L81 · [class] static final C18901 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager.java`
注解：

字段/常量（5）：
- `Object L$0`  L82
- `Object L$1`  L83
- `Object L$2`  L84
- `int label`  L85
- `Object result`  L86

方法（1）：
- `Object invokeSuspend(Object obj)`  L93 @Override
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$C18911`
L104 · [class] static final C18911 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager.java`
注解：

字段/常量（5）：
- `Object L$0`  L105
- `Object L$1`  L106
- `Object L$2`  L107
- `int label`  L108
- `Object result`  L109

方法（1）：
- `Object invokeSuspend(Object obj)`  L116 @Override
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$ManagedDeviceSession`
L449 · [class] final ManagedDeviceSession · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager.java`
注解：

字段/常量（162）：
- `MutableSharedFlow<DeviceAdapterEvent> _events`  L450
- `MutableStateFlow<DeviceSessionSnapshot> _state`  L451
- `DeviceAdapterSession activeAdapter`  L452
- `AtomicBoolean closed`  L453
- `Job eventJob`  L454
- `SharedFlow<DeviceAdapterEvent> events`  L455
- `String id`  L456
- `CompletableJob job`  L457
- `Mutex openMutex`  L458
- `CoroutineScope sessionScope`  L459
- `StateFlow<DeviceSessionSnapshot> state`  L460
- `DeviceSessionManager this$0`  L461
- `DeviceSessionManager$ManagedDeviceSession$open$1 deviceSessionManager$ManagedDeviceSession$open$1`  L496
- `Mutex mutex`  L497
- `ManagedDeviceSession managedDeviceSession`  L498
- `Throwable th`  L499
- `Mutex mutex2`  L500
- `Object value`  L501
- `Object obj = deviceSessionManager$ManagedDeviceSession$open$1.result`  L512
- `int i = deviceSessionManager$ManagedDeviceSession$open$1.label`  L514
- `Mutex mutex4 = mutex`  L559
- `Mutex mutex5 = mutex`  L565
- `C1888xb9b59eeb c1888xb9b59eeb`  L592
- `Object obj`  L593
- `Object obj2`  L594
- `?? r10`  L595
- `DeviceSessionManager deviceSessionManager`  L596
- `ManagedDeviceSession managedDeviceSession`  L597
- `Object objM3074constructorimpl`  L598
- `Object obj3`  L599
- `RecoverableDeviceControlChannel recoverableDeviceControlChannel`  L600
- `long revision`  L601
- `Object obj4`  L602
- `Object obj5`  L603
- `Object obj6`  L604
- `ManagedDeviceSession managedDeviceSession2`  L605
- `ManagedDeviceSession managedDeviceSession3`  L606
- `long j`  L607
- `Object obj7`  L608
- `DeviceControlChannelRecoveryResult deviceControlChannelRecoveryResult`  L609
- `RouteSnapshot routeSnapshotRouteFor`  L610
- `RouteSupersededException routeSupersededException`  L611
- `RouteSupersededException routeSupersededException2`  L612
- `Object obj8`  L613
- `?? r11`  L614
- `Object obj9`  L615
- `Job job`  L616
- `RouteSnapshot route`  L617
- `Job job2`  L618
- `RouteSnapshot route2`  L619
- `Mutex mutex`  L620
- `Object objRecoverControlChannel = c1888xb9b59eeb.result`  L631
- `int i = c1888xb9b59eeb.label`  L633
- `boolean z = false`  L634
- `long j2 = c1888xb9b59eeb.J$0`  L640
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow = managedDeviceSession._state`  L675
- `Result.Companion companion = Result.INSTANCE`  L679
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow2 = managedDeviceSession3._state`  L704
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow3 = managedDeviceSession3._state`  L718
- `Result.Companion companion2 = Result.INSTANCE`  L722
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow4 = managedDeviceSession3._state`  L737
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow5 = managedDeviceSession3._state`  L751
- `Result.Companion companion3 = Result.INSTANCE`  L755
- `long j3 = c1888xb9b59eeb.J$0`  L760
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow6 = managedDeviceSession._state`  L781
- `Result.Companion companion4 = Result.INSTANCE`  L785
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow7 = managedDeviceSession3._state`  L810
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow8 = managedDeviceSession3._state`  L824
- `Result.Companion companion5 = Result.INSTANCE`  L828
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow9 = managedDeviceSession3._state`  L848
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow10 = managedDeviceSession3._state`  L859
- `Result.Companion companion6 = Result.INSTANCE`  L863
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow11 = managedDeviceSession3._state`  L889
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow12 = managedDeviceSession3._state`  L900
- `Result.Companion companion7 = Result.INSTANCE`  L904
- `Mutex mutex5 = this.openMutex`  L914
- `Result.Companion companion8 = Result.INSTANCE`  L927
- `Result.Companion companion9 = Result.INSTANCE`  L942
- `DeviceAdapterSession deviceAdapterSession = managedDeviceSession.activeAdapter`  L946
- `Result.Companion companion10 = Result.INSTANCE`  L949
- `Job job3 = managedDeviceSession.eventJob`  L956
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow13 = managedDeviceSession._state`  L995
- `Result.Companion companion11 = Result.INSTANCE`  L999
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow14 = managedDeviceSession3._state`  L1025
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow15 = managedDeviceSession3._state`  L1039
- `Result.Companion companion12 = Result.INSTANCE`  L1043
- `C1887x48647739 c1887x48647739`  L1080
- `ManagedDeviceSession managedDeviceSession`  L1081
- `Object obj = c1887x48647739.result`  L1092
- `int i = c1887x48647739.label`  L1094
- `DeviceSessionManager$ManagedDeviceSession$openInternal$1 deviceSessionManager$ManagedDeviceSession$openInternal$1`  L1216
- `Throwable th`  L1217
- `?? r9`  L1218
- `?? r14`  L1219
- `?? r7`  L1220
- `?? r3`  L1221
- `?? r10`  L1222
- `?? r8`  L1223
- `?? r5`  L1224
- `?? r4`  L1225
- `DeviceSessionSnapshot value`  L1226
- `long revision`  L1227
- `DeviceAdapterSession deviceAdapterSession2`  L1228
- `ManagedDeviceSession managedDeviceSession`  L1229
- `Unit unit`  L1230
- `DeviceAdapterSession deviceAdapterSession3`  L1231
- `long j`  L1232
- `DeviceSessionSnapshot deviceSessionSnapshot`  L1233
- `?? r6`  L1234
- `?? r11`  L1235
- `DeviceAdapterOpenResult deviceAdapterOpenResult`  L1236
- `RouteSnapshot routeSnapshotRouteFor`  L1237
- `Object objClose`  L1238
- `DeviceSessionState deviceSessionState`  L1239
- `DeviceSessionSnapshot deviceSessionSnapshotCopy`  L1240
- `Object objOpen = deviceSessionManager$ManagedDeviceSession$openInternal$1.result`  L1251
- `?? r12 = deviceSessionManager$ManagedDeviceSession$openInternal$1.label`  L1253
- `?? r13 = 3`  L1254
- `boolean z = false`  L1257
- `Result.Companion companion = Result.INSTANCE`  L1264
- `Result.Companion companion2 = Result.INSTANCE`  L1270
- `DeviceAdapterSession deviceAdapterSession4 = this.activeAdapter`  L1275
- `Job job = this.eventJob`  L1277
- `Result.Companion companion3 = Result.INSTANCE`  L1283
- `ManagedDeviceSession managedDeviceSession2 = this`  L1284
- `Result.Companion companion4 = Result.INSTANCE`  L1302
- `Result.Companion companion5 = Result.INSTANCE`  L1357
- `Result.Companion companion6 = Result.INSTANCE`  L1360
- `Result.Companion companion7 = Result.INSTANCE`  L1390
- `Result.Companion companion8 = Result.INSTANCE`  L1423
- `Result.Companion companion9 = Result.INSTANCE`  L1428
- `Result.Companion companion10 = Result.INSTANCE`  L1466
- `Result.Companion companion11 = Result.INSTANCE`  L1469
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow = r7._state`  L1495
- `Result.Companion companion12 = Result.INSTANCE`  L1499
- `Result.Companion companion13 = Result.INSTANCE`  L1511
- `Result.Companion companion14 = Result.INSTANCE`  L1516
- `Result.Companion companion15 = Result.INSTANCE`  L1560
- `Result.Companion companion16 = Result.INSTANCE`  L1563
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow2 = r7._state`  L1590
- `Result.Companion companion17 = Result.INSTANCE`  L1593
- `Result.Companion companion18 = Result.INSTANCE`  L1605
- `Result.Companion companion19 = Result.INSTANCE`  L1612
- `Job job = this.eventJob`  L1628
- `DeviceSessionManager$ManagedDeviceSession$close$1 deviceSessionManager$ManagedDeviceSession$close$1`  L1657
- `ManagedDeviceSession managedDeviceSession`  L1658
- `Unit unit`  L1659
- `Object obj = deviceSessionManager$ManagedDeviceSession$close$1.result`  L1670
- `int i = deviceSessionManager$ManagedDeviceSession$close$1.label`  L1672
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow = this._state`  L1678
- `Job job = this.eventJob`  L1682
- `Result.Companion companion = Result.INSTANCE`  L1688
- `ManagedDeviceSession managedDeviceSession2 = this`  L1689
- `DeviceAdapterSession deviceAdapterSession = this.activeAdapter`  L1690
- `Result.Companion companion2 = Result.INSTANCE`  L1706
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow2 = managedDeviceSession._state`  L1711
- `Result.Companion companion3 = Result.INSTANCE`  L1724
- `MutableStateFlow<DeviceSessionSnapshot> mutableStateFlow3 = managedDeviceSession._state`  L1731
- `DeviceAdapterSession deviceAdapterSession = this.activeAdapter`  L1739
- `Job job = this.eventJob`  L1745
- `Job job = this.eventJob`  L1759
- `DeviceAdapterSession deviceAdapterSession = this.activeAdapter`  L1764

方法（22）：
- `public ManagedDeviceSession(DeviceSessionManager deviceSessionManager, String id, DeviceSessionSnapshot initial)`  L463
    - 体内字面量："id" · "initial"
- `String getId()`  L481
- `StateFlow<DeviceSessionSnapshot> getState()`  L485
- `SharedFlow<DeviceAdapterEvent> getEvents()`  L489
- `Object m2719opengIAlus(DeviceAdapterSession deviceAdapterSession, Continuation<? super Result<DeviceSessionSnapshot>> continuation)`  L495
- `throw new IllegalStateException( 166 )`  L530
- `Object m2720recoverControlChannelIoAF18A(Continuation<? super Result<DeviceSessionSnapshot>> continuation)`  L591
- `throw new IllegalStateException( 173 )`  L834
- `Object closeAdapterPreserving(DeviceAdapterSession deviceAdapterSession, Throwable th, Continuation<? super Unit> continuation)`  L1079
- `throw new IllegalStateException( 181 )`  L1118
- `Object m2718openInternalgIAlus(DeviceAdapterSession deviceAdapterSession, Continuation<? super Result<DeviceSessionSnapshot>> continuation)`  L1215
- `throw new RouteSupersededException( 184  + r14.id)`  L1377
- `throw new RouteSupersededException( 185  + r14.id)`  L1409
- `throw new IllegalStateException( 186 )`  L1412
- `throw new RouteSupersededException( 187  + r14.id)`  L1486
- `throw new RouteSupersededException( 188  + r14.id)`  L1580
- `void startEventCollection(Flow<? extends DeviceAdapterEvent> events, long revision)`  L1627
- `void validateOpenResult(DeviceAdapterOpenResult result, long revision)`  L1635
    - 体内字面量："Adapter identity does not match session device type: " · "Adapter returned an invalid control EndpointGrant: " · "@" · "Adapter EndpointGrant does not match session revision: " · "@" · "Adapter capabilities do not match session revision: " · "@"
- `Object close(String str, Continuation<? super Unit> continuation)`  L1656
- `throw new IllegalStateException( 196 )`  L1717
- `void invalidateForRoute(RouteSnapshot route)`  L1737
    - 体内字面量："route"
- `void cancelForRoute(Throwable cause)`  L1757
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$ManagedDeviceSession$cancelForRoute$1`
L20 · [class] final DeviceSessionManager$ManagedDeviceSession$cancelForRoute$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager$ManagedDeviceSession$cancelForRoute$1.java`
注解：

字段/常量（10）：
- `DeviceAdapterSession $adapter`  L21
- `Object L$0`  L22
- `int label`  L23
- `DeviceSessionManager this$0`  L24
- `DeviceSessionManager.ManagedDeviceSession this$1`  L25
- `Unit unit`  L49
- `int i = this.label`  L51
- `DeviceAdapterSession deviceAdapterSession = this.$adapter`  L55
- `Result.Companion companion = Result.INSTANCE`  L56
- `Result.Companion companion2 = Result.INSTANCE`  L76

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L36 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L43 @Override
- `Object invokeSuspend(Object obj)`  L48 @Override
- `throw new IllegalStateException( 7 )`  L70
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$ManagedDeviceSession$close$1`
L14 · [class] final DeviceSessionManager$ManagedDeviceSession$close$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager$ManagedDeviceSession$close$1.java`
注解：

字段/常量（4）：
- `Object L$0`  L15
- `int label`  L16
- `Object result`  L17
- `DeviceSessionManager.ManagedDeviceSession this$0`  L18

方法（1）：
- `Object invokeSuspend(Object obj)`  L27 @Override
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$ManagedDeviceSession$invalidateForRoute$1`
L20 · [class] final DeviceSessionManager$ManagedDeviceSession$invalidateForRoute$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager$ManagedDeviceSession$invalidateForRoute$1.java`
注解：

字段/常量（10）：
- `DeviceAdapterSession $adapter`  L21
- `Object L$0`  L22
- `int label`  L23
- `DeviceSessionManager this$0`  L24
- `DeviceSessionManager.ManagedDeviceSession this$1`  L25
- `Unit unit`  L49
- `int i = this.label`  L51
- `DeviceAdapterSession deviceAdapterSession = this.$adapter`  L55
- `Result.Companion companion = Result.INSTANCE`  L56
- `Result.Companion companion2 = Result.INSTANCE`  L76

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L36 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L43 @Override
- `Object invokeSuspend(Object obj)`  L48 @Override
- `throw new IllegalStateException( 7 )`  L70
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$ManagedDeviceSession$open$1`
L15 · [class] final DeviceSessionManager$ManagedDeviceSession$open$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager$ManagedDeviceSession$open$1.java`
注解：

字段/常量（6）：
- `Object L$0`  L16
- `Object L$1`  L17
- `Object L$2`  L18
- `int label`  L19
- `Object result`  L20
- `DeviceSessionManager.ManagedDeviceSession this$0`  L21

方法（1）：
- `Object invokeSuspend(Object obj)`  L30 @Override
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$ManagedDeviceSession$openInternal$1`
L15 · [class] final DeviceSessionManager$ManagedDeviceSession$openInternal$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager$ManagedDeviceSession$openInternal$1.java`
注解：

字段/常量（7）：
- `long J$0`  L16
- `Object L$0`  L17
- `Object L$1`  L18
- `Object L$2`  L19
- `int label`  L20
- `Object result`  L21
- `DeviceSessionManager.ManagedDeviceSession this$0`  L22

方法（1）：
- `Object invokeSuspend(Object obj)`  L31 @Override
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$ManagedDeviceSession$startEventCollection$1`
L23 · [class] final DeviceSessionManager$ManagedDeviceSession$startEventCollection$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager$ManagedDeviceSession$startEventCollection$1.java`
注解：

字段/常量（10）：
- `Flow<DeviceAdapterEvent> $events`  L24
- `long $revision`  L25
- `int label`  L26
- `DeviceSessionManager.ManagedDeviceSession this$0`  L27
- `int i = this.label`  L51
- `Flow<DeviceAdapterEvent> flow = this.$events`  L54
- `DeviceSessionManager.ManagedDeviceSession managedDeviceSession = this.this$0`  L55
- `long j = this.$revision`  L56
- `RouteSnapshot route`  L65
- `MutableStateFlow mutableStateFlow = managedDeviceSession._state`  L70

方法（6）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L39 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L44 @Override
- `Object invokeSuspend(Object obj)`  L49 @Override
- `Object emit(Object obj2, Continuation continuation)`  L60 @Override
- `Object emit(DeviceAdapterEvent deviceAdapterEvent, Continuation<? super Unit> continuation)`  L64
- `throw new IllegalStateException( 7 )`  L82
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$open$1`
L16 · [class] final DeviceSessionManager$open$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager$open$1.java`
注解：

字段/常量（3）：
- `int label`  L17
- `Object result`  L18
- `DeviceSessionManager this$0`  L19

方法（1）：
- `Object invokeSuspend(Object obj)`  L28 @Override
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$recoverControlChannel$1`
L15 · [class] final DeviceSessionManager$recoverControlChannel$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager$recoverControlChannel$1.java`
注解：

字段/常量（3）：
- `int label`  L16
- `Object result`  L17
- `DeviceSessionManager this$0`  L18

方法（1）：
- `Object invokeSuspend(Object obj)`  L27 @Override
### `com.tuwinsmart.tuwin.core.device.DeviceSessionManager$routeRevisionChanged$1$1`
L19 · [class] final DeviceSessionManager$routeRevisionChanged$1$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/device/DeviceSessionManager$routeRevisionChanged$1$1.java`
注解：

字段/常量（4）：
- `DeviceRouteChange $change`  L20
- `int label`  L21
- `DeviceSessionManager this$0`  L22
- `int i = this.label`  L44

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L32 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L37 @Override
- `Object invokeSuspend(Object obj)`  L42 @Override
- `throw new IllegalStateException( 8 )`  L53
### `com.tuwinsmart.tuwin.core.device.DeviceSessionNotFoundException`
L10 · [class] public final DeviceSessionNotFoundException · extends `IllegalStateException` · `com/tuwinsmart/tuwin/core/device/DeviceSessionNotFoundException.java`
注解：

方法（1）：
- `public DeviceSessionNotFoundException(String message)`  L12
    - 体内字面量："message"
### `com.tuwinsmart.tuwin.core.device.DeviceSessionResources`
L14 · [class] public final DeviceSessionResources · `com/tuwinsmart/tuwin/core/device/DeviceSessionResources.java`
注解：

字段/常量（2）：
- `Function1<Continuation<? super Unit>, Object> closeResources`  L15
- `CoroutineScope scope`  L16

方法（3）：
- `public DeviceSessionResources(CoroutineScope scope, Function1<? super Continuation<? super Unit>, ? extends Object> closeResources)`  L19
    - 体内字面量："scope" · "closeResources"
- `CoroutineScope getScope()`  L26
- `Function1<Continuation<? super Unit>, Object> getCloseResources()`  L30
### `com.tuwinsmart.tuwin.core.device.DeviceSessionSnapshot`
L17 · [class] public final DeviceSessionSnapshot · `com/tuwinsmart/tuwin/core/device/DeviceSessionSnapshot.java`
注解：

字段/常量（17）：
- `String callbackIp`  L18
- `DeviceCapabilities capabilities`  L19
- `EndpointGrant controlEndpointGrant`  L20
- `DeviceType deviceType`  L21
- `String id`  L22
- `DeviceIdentity identity`  L23
- `EndpointGrant mediaEndpointGrant`  L24
- `RouteSnapshot route`  L25
- `EndpointGrant socketEndpointGrant`  L26
- `DeviceSessionState state`  L27
- `DeviceIdentity deviceIdentity = this.identity`  L99
- `RouteSnapshot routeSnapshot = this.route`  L101
- `EndpointGrant endpointGrant = this.controlEndpointGrant`  L103
- `EndpointGrant endpointGrant2 = this.mediaEndpointGrant`  L105
- `EndpointGrant endpointGrant3 = this.socketEndpointGrant`  L107
- `DeviceCapabilities deviceCapabilities = this.capabilities`  L109
- `String str = this.callbackIp`  L111

方法（26）：
- `String getId()`  L30
- `String getCallbackIp()`  L35
- `DeviceType getDeviceType()`  L40
- `DeviceIdentity getIdentity()`  L45
- `RouteSnapshot getRoute()`  L50
- `EndpointGrant getControlEndpointGrant()`  L55
- `EndpointGrant getMediaEndpointGrant()`  L60
- `EndpointGrant getSocketEndpointGrant()`  L65
- `DeviceCapabilities getCapabilities()`  L70
- `DeviceSessionState getState()`  L75
- `DeviceSessionSnapshot copy(String id, DeviceType deviceType, DeviceIdentity identity, RouteSnapshot route, EndpointGrant controlEndpointGrant, EndpointGrant mediaEndpointGrant, EndpointGrant socketEndpointGrant, DeviceCapabilities capabilities, DeviceSessionState state, String callbackIp)`  L79
    - 体内字面量："id" · "deviceType" · "state"
- `boolean equals(Object other)`  L86
- `int hashCode()`  L97
- `String toString()`  L115
    - 体内字面量："DeviceSessionSnapshot(id=" · ", deviceType=" · ", identity=" · ", route=" · ", controlEndpointGrant=" · ", mediaEndpointGrant=" · ", socketEndpointGrant=" · ", capabilities=" · ", state=" · ", callbackIp=" · ")"
- `public DeviceSessionSnapshot(String id, DeviceType deviceType, DeviceIdentity deviceIdentity, RouteSnapshot routeSnapshot, EndpointGrant endpointGrant, EndpointGrant endpointGrant2, EndpointGrant endpointGrant3, DeviceCapabilities deviceCapabilities, DeviceSessionState state, String str)`  L119
    - 体内字面量："id" · "deviceType" · "state"
- ` DeviceSessionSnapshot(String str, DeviceType deviceType, DeviceIdentity deviceIdentity, RouteSnapshot routeSnapshot, EndpointGrant endpointGrant, EndpointGrant endpointGrant2, EndpointGrant endpointGrant3, DeviceCapabilities deviceCapabilities, DeviceSessionState deviceSessionState, String str2, int i, DefaultConstructorMarker defaultConstructorMarker)`  L135
- `String getId()`  L139
- `DeviceType getDeviceType()`  L143
- `DeviceIdentity getIdentity()`  L147
- `RouteSnapshot getRoute()`  L151
- `EndpointGrant getControlEndpointGrant()`  L155
- `EndpointGrant getMediaEndpointGrant()`  L159
- `EndpointGrant getSocketEndpointGrant()`  L163
- `DeviceCapabilities getCapabilities()`  L167
- `DeviceSessionState getState()`  L171
- `String getCallbackIp()`  L175
### `com.tuwinsmart.tuwin.core.device.DeviceSessionState`
L11 · [enum] public DeviceSessionState · `com/tuwinsmart/tuwin/core/device/DeviceSessionState.java`
注解：

枚举常量（11）：
- `IDLE()`  L12
- `WAITING_FOR_ROUTE()`  L13
- `PROBING_IDENTITY()`  L14
- `ROUTE_VERIFIED()`  L15
- `OPENING_CONTROL_CHANNEL()`  L16
- `LOADING_CAPABILITIES()`  L17
- `READY()`  L18
- `DEGRADED()`  L19
- `CLOSING()`  L20
- `CLOSED()`  L21
- `FAILED()`  L22

方法（1）：
- `EnumEntries<DeviceSessionState> getEntries()`  L26
### `com.tuwinsmart.tuwin.core.device.DuplicateDeviceAdapterException`
L10 · [class] public final DuplicateDeviceAdapterException · extends `IllegalStateException` · `com/tuwinsmart/tuwin/core/device/DuplicateDeviceAdapterException.java`
注解：

方法（1）：
- `public DuplicateDeviceAdapterException(String message)`  L12
    - 体内字面量："message"
### `com.tuwinsmart.tuwin.core.device.RecoverableDeviceControlChannel`
L10 · [interface] public RecoverableDeviceControlChannel · extends `DeviceAdapterSession` · `com/tuwinsmart/tuwin/core/device/RecoverableDeviceControlChannel.java`
注解：

方法（1）：
- `Object recoverControlChannel(Continuation<? super DeviceControlChannelRecoveryResult> continuation)`  L11
### `com.tuwinsmart.tuwin.core.device.RecoverableDeviceControlChannel$DefaultImpls`
L15 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/core/device/RecoverableDeviceControlChannel.java`
注解：

方法（1）：
- `void invalidateForRoute(RecoverableDeviceControlChannel recoverableDeviceControlChannel, long j)`  L16