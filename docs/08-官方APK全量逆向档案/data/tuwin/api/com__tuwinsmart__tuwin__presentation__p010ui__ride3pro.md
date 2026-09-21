# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.presentation.p010ui.ride3pro

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 10 个文件 / 11 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProBackgroundRecordingAction`
L12 · [class] public final Ride3ProBackgroundRecordingAction · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProBackgroundRecordingAction.java`
注解：

方法（3）：
- `boolean shouldRunFromGenericAppBackground(boolean isPlaybackPage)`  L15
- `private Ride3ProBackgroundRecordingAction()`  L19
- `void run(boolean isPlaybackPage, Function0<Unit> startRecording, Function0<Unit> stopPlaybackThenStartRecording)`  L22
    - 体内字面量："startRecording" · "stopPlaybackThenStartRecording"
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProFileBrowsingRecordingLifecycle`
L12 · [class] public final Ride3ProFileBrowsingRecordingLifecycle · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProFileBrowsingRecordingLifecycle.java`
注解：

字段/常量（2）：
- `Ride3ProFileBrowsingRecordingScope pendingScope`  L13
- `Ride3ProFileBrowsingRecordingScope ride3ProFileBrowsingRecordingScope = this.pendingScope`  L26

方法（2）：
- `void onFileBrowsingPageEnteredBackground(Ride3ProFileBrowsingRecordingScope scope, Function1<? super Ride3ProFileBrowsingRecordingScope, Unit> startRecording)`  L15
    - 体内字面量："startRecording"
- `void onAppEnteredForeground(boolean isFileBrowsingPage, Ride3ProFileBrowsingRecordingScope currentScope, Function1<? super Ride3ProFileBrowsingRecordingScope, Unit> stopRecording)`  L24
    - 体内字面量："stopRecording"
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProFileBrowsingRecordingScope`
L10 · [class] public final Ride3ProFileBrowsingRecordingScope · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProFileBrowsingRecordingScope.java`
注解：

字段/常量（2）：
- `long routeRevision`  L11
- `String sessionId`  L12

方法（10）：
- `Ride3ProFileBrowsingRecordingScope copy$default(Ride3ProFileBrowsingRecordingScope ride3ProFileBrowsingRecordingScope, String str, long j, int i, Object obj)`  L14
- `String getSessionId()`  L25
- `long getRouteRevision()`  L30
- `Ride3ProFileBrowsingRecordingScope copy(String sessionId, long routeRevision)`  L34
    - 体内字面量："sessionId"
- `boolean equals(Object other)`  L39
- `int hashCode()`  L50
- `String toString()`  L54
    - 体内字面量："Ride3ProFileBrowsingRecordingScope(sessionId=" · ", routeRevision=" · ")"
- `public Ride3ProFileBrowsingRecordingScope(String sessionId, long j)`  L58
    - 体内字面量："sessionId"
- `String getSessionId()`  L64
- `long getRouteRevision()`  L68
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProHeartbeatAppVisibilityController`
L14 · [class] public final Ride3ProHeartbeatAppVisibilityController · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatAppVisibilityController.java`
注解：

字段/常量（6）：
- `boolean backgroundPending`  L15
- `boolean inForeground`  L16
- `Function0<Unit> onEnterBackground`  L17
- `Function0<Unit> onEnterForeground`  L18
- `Function0<Unit> onForegroundActivityStarted`  L19
- `int startedActivityCount`  L20

方法（7）：
- `public Ride3ProHeartbeatAppVisibilityController(Function0<Unit> onEnterForeground, Function0<Unit> onEnterBackground, Function0<Unit> onForegroundActivityStarted)`  L22
    - 体内字面量："onEnterForeground" · "onEnterBackground" · "onForegroundActivityStarted"
- ` Ride3ProHeartbeatAppVisibilityController(Function0 function0, Function0 function1, C28011 c28011, int i, DefaultConstructorMarker defaultConstructorMarker)`  L31
- `void invoke2()`  L34
- `Unit invoke()`  L38 @Override
- `void onActivityStarted()`  L45
- `void onActivityStopped(boolean isChangingConfigurations)`  L56
- `void confirmBackground()`  L62
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProHeartbeatManager`
L35 · [class] public final Ride3ProHeartbeatManager · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java`
注解：

字段/常量（16）：
- `long HEARTBEAT_INTERVAL_MS = 30000`  L36
- `int MAX_RETRY_COUNT = 3`  L37
- `long RETRY_DELAY_MS = 500`  L38
- `Long activeRouteRevision`  L39
- `String activeSessionId`  L40
- `Ride3ProDeviceRepository deviceRepository`  L41
- `CoroutineDispatcher dispatcher`  L42
- `Job heartbeatJob`  L43
- `long intervalMs`  L44
- `Function1<String, Ride3ProRequestExecutor> sessionExecutorProvider`  L45
- `Function0<Boolean> shouldSuppressHeartbeat`  L46
- `Job job = this.heartbeatJob`  L120
- `Job job = this.heartbeatJob`  L275
- `Long l = this.activeRouteRevision`  L277
- `Ride3ProRequestExecutor ride3ProRequestExecutor2 = ride3ProRequestExecutorInvoke`  L300
- `Job job = this.heartbeatJob`  L379

方法（20）：
- `public Ride3ProHeartbeatManager()`  L48
- `public Ride3ProHeartbeatManager(Ride3ProDeviceRepository deviceRepository)`  L53
    - 体内字面量："deviceRepository"
- `public Ride3ProHeartbeatManager(Ride3ProDeviceRepository deviceRepository, long j)`  L59
    - 体内字面量："deviceRepository"
- `public Ride3ProHeartbeatManager(Ride3ProDeviceRepository deviceRepository, long j, CoroutineDispatcher dispatcher)`  L65
    - 体内字面量："deviceRepository" · "dispatcher"
- `public Ride3ProHeartbeatManager(Ride3ProDeviceRepository deviceRepository, long j, CoroutineDispatcher dispatcher, Function0<Boolean> shouldSuppressHeartbeat)`  L72
    - 体内字面量："deviceRepository" · "dispatcher" · "shouldSuppressHeartbeat"
- `public Ride3ProHeartbeatManager(Ride3ProDeviceRepository deviceRepository, long j, CoroutineDispatcher dispatcher, Function0<Boolean> shouldSuppressHeartbeat, Function1<? super String, ? extends Ride3ProRequestExecutor> sessionExecutorProvider)`  L80
    - 体内字面量："deviceRepository" · "dispatcher" · "shouldSuppressHeartbeat" · "sessionExecutorProvider"
- ` Ride3ProHeartbeatManager(Ride3ProDeviceRepositoryImpl ride3ProDeviceRepositoryImpl, long j, CoroutineDispatcher coroutineDispatcher, C28021 c28021, C28032 c28032, int i, DefaultConstructorMarker defaultConstructorMarker)`  L93
- `Boolean invoke()`  L97 @Override
- `Void invoke(String it)`  L102 @Override
    - 体内字面量："it"
- `void start(CoroutineScope scope, String currentSsid, String globalSsid, List<ConnectedDevice> cachedDevices)`  L109
    - 体内字面量："scope" · "cachedDevices" · "è¿æ¥éç½æµç¨ä¸­ï¼è·³è¿ Ride3Pro å¿è·³å¯å¨"
- `void startForSession$default(Ride3ProHeartbeatManager ride3ProHeartbeatManager, CoroutineScope coroutineScope, String str, Function0 function0, int i, Object obj)`  L248
- `Boolean invoke()`  L257 @Override
- `void startForSession(CoroutineScope scope, final String sessionId, Function0<Boolean> lifecycleAllowed)`  L265
    - 体内字面量："scope" · "sessionId" · "lifecycleAllowed" · "Ride3Pro: session å°æªå°±ç»ªï¼è·³è¿å¿è·³å¯å¨ session="
- `Ride3ProRequestExecutor invoke()`  L297 @Override
- `Unit invoke(Ride3ProStatusPollResult ride3ProStatusPollResult)`  L313 @Override
- `void invoke2(Ride3ProStatusPollResult result)`  L319
    - 体内字面量："result" · "Ride3Pro: ä¸¢å¼æ§ route revision å¿è·³ç»æ session=" · "Ride3Pro: Skipped(NotReady), session=" · "Ride3Pro: session å¿è·³å¤±è´¥"
- `void updateStatusStore(String sessionId, long routeRevision, Ride3ProConnectionSnapshot snapshot)`  L345
- `java.lang.Object m3017requestHeartbeatWithRetryIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<com.tuwinsmart.tuwin.domain.repository.Ride3ProConnectionSnapshot>> r14)`  L370
- `throw new UnsupportedOperationException( 79 )`  L375
- `void stop()`  L378
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProHeartbeatManager$C28041`
L131 · [class] static final C28041 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager.java`
注解：

字段/常量（2）：
- `Object L$0`  L132
- `int label`  L133

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L140 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L147 @Override
- `java.lang.Object invokeSuspend(java.lang.Object r17)`  L164 @Override
- `throw new UnsupportedOperationException( 70 )`  L243
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProHeartbeatManager$requestHeartbeatWithRetry$1`
L15 · [class] final Ride3ProHeartbeatManager$requestHeartbeatWithRetry$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatManager$requestHeartbeatWithRetry$1.java`
注解：

字段/常量（10）：
- `int I$0`  L16
- `int I$1`  L17
- `int I$2`  L18
- `Object L$0`  L19
- `Object L$1`  L20
- `Object L$2`  L21
- `Object L$3`  L22
- `int label`  L23
- `Object result`  L24
- `Ride3ProHeartbeatManager this$0`  L25

方法（1）：
- `Object invokeSuspend(Object obj)`  L34 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProHeartbeatPolicy`
L17 · [class] public final Ride3ProHeartbeatPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProHeartbeatPolicy.java`
注解：

字段/常量（1）：
- `Object next`  L29

方法（3）：
- `private Ride3ProHeartbeatPolicy()`  L20
- `boolean shouldStart(String currentSsid, String globalSsid, List<ConnectedDevice> cachedDevices)`  L23
    - 体内字面量："cachedDevices"
- `DeviceType resolveDeviceType(String currentSsid, String globalSsid, List<ConnectedDevice> cachedDevices)`  L28
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProPreviewDiagnosticToastGate`
L13 · [class] public final Ride3ProPreviewDiagnosticToastGate · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProPreviewDiagnosticToastGate.java`
注解：

字段/常量（1）：
- `boolean enabled`  L15

方法（5）：
- `private Ride3ProPreviewDiagnosticToastGate()`  L17
- `boolean isEnabled()`  L20
- `void enable()`  L24
- `void runIfEnabled(Function0<Unit> action)`  L28
    - 体内字面量："action"
- `void reset$app_release_64()`  L35
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProStatusSnapshot`
L11 · [class] public final Ride3ProStatusSnapshot · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProStatusSnapshot.java`
注解：

字段/常量（16）：
- `Integer adapterStatus`  L12
- `Integer batteryPercent`  L13
- `Integer exceptionFlags`  L14
- `Integer hdrChkCnt`  L15
- `Long routeRevision`  L16
- `String sessionId`  L17
- `Long l2 = l`  L26
- `Integer num5 = num`  L30
- `Integer num6 = num2`  L34
- `Integer num7 = num3`  L38
- `String str = this.sessionId`  L91
- `Long l = this.routeRevision`  L93
- `Integer num = this.batteryPercent`  L95
- `Integer num2 = this.adapterStatus`  L97
- `Integer num3 = this.exceptionFlags`  L99
- `Integer num4 = this.hdrChkCnt`  L101

方法（19）：
- `Ride3ProStatusSnapshot copy$default(Ride3ProStatusSnapshot ride3ProStatusSnapshot, String str, Long l, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj)`  L19
- `String getSessionId()`  L46
- `Long getRouteRevision()`  L51
- `Integer getBatteryPercent()`  L56
- `Integer getAdapterStatus()`  L61
- `Integer getExceptionFlags()`  L66
- `Integer getHdrChkCnt()`  L71
- `Ride3ProStatusSnapshot copy(String sessionId, Long routeRevision, Integer batteryPercent, Integer adapterStatus, Integer exceptionFlags, Integer hdrChkCnt)`  L75
- `boolean equals(Object other)`  L79
- `int hashCode()`  L90
- `String toString()`  L105
    - 体内字面量："Ride3ProStatusSnapshot(sessionId=" · ", routeRevision=" · ", batteryPercent=" · ", adapterStatus=" · ", exceptionFlags=" · ", hdrChkCnt=" · ")"
- `public Ride3ProStatusSnapshot(String str, Long l, Integer num, Integer num2, Integer num3, Integer num4)`  L109
- ` Ride3ProStatusSnapshot(String str, Long l, Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker)`  L118
- `String getSessionId()`  L122
- `Long getRouteRevision()`  L126
- `Integer getBatteryPercent()`  L130
- `Integer getAdapterStatus()`  L134
- `Integer getExceptionFlags()`  L138
- `Integer getHdrChkCnt()`  L142
### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProStatusStore`
L17 · [class] public final Ride3ProStatusStore · `com/tuwinsmart/tuwin/presentation/p010ui/ride3pro/Ride3ProStatusStore.java`
注解：

字段/常量（18）：
- `MutableStateFlow<Ride3ProStatusSnapshot> _snapshot`  L19
- `Long activeRouteRevision`  L20
- `String activeSessionId`  L21
- `StateFlow<Ride3ProStatusSnapshot> snapshot`  L22
- `Long l`  L38
- `Unit unit = Unit.INSTANCE`  L52
- `Unit unit = Unit.INSTANCE`  L70
- `String str`  L82
- `Long routeRevision2`  L83
- `Integer batteryPercent2`  L84
- `Integer adapterStatus2`  L85
- `Integer exceptionFlags2`  L86
- `Integer hdrChkCnt2`  L87
- `String sessionId2 = sessionId`  L88
- `MutableStateFlow<Ride3ProStatusSnapshot> mutableStateFlow = _snapshot`  L104
- `Unit unit = Unit.INSTANCE`  L140
- `Unit unit = Unit.INSTANCE`  L169
- `Unit unit = Unit.INSTANCE`  L178

方法（10）：
- `private Ride3ProStatusStore()`  L24
- `StateFlow<Ride3ProStatusSnapshot> getSnapshot()`  L33
- `void activateSession(String sessionId, long routeRevision)`  L37
- `void update(String sessionId, Long routeRevision, Integer batteryPercent, Integer adapterStatus, Integer exceptionFlags, Integer hdrChkCnt)`  L56
    - 体内字面量："sessionId and routeRevision must be supplied together"
- `void updateIfAvailable$default(Ride3ProStatusStore ride3ProStatusStore, String str, Long l, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj)`  L77
- `void updateIfAvailable(String sessionId, Long routeRevision, Integer batteryPercent, Integer adapterStatus, Integer exceptionFlags, Integer hdrChkCnt)`  L81
- `void updateFromStatus(Ride3ProDeviceStatusInfo statusInfo)`  L147
- `void clearSession$default(Ride3ProStatusStore ride3ProStatusStore, String str, Long l, int i, Object obj)`  L154
- `void clearSession(String sessionId, Long routeRevision)`  L161
    - 体内字面量："sessionId"
- `void clear()`  L173