# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.core.device.ride5

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 47 个文件 / 106 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.core.device.ride5.C2033xce3d7520`
L14 · [class] final C2033xce3d7520 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/C2033xce3d7520.java`
注解：

字段/常量（4）：
- `Object L$0`  L15
- `int label`  L16
- `Object result`  L17
- `Ride5SessionPortProvider.CatalogRecordingRide5SessionPort this$0`  L18

方法（1）：
- `Object invokeSuspend(Object obj)`  L27 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.JavaRide5CallbackServerSocket`
L18 · [class] final JavaRide5CallbackServerSocket · implements `Ride5CallbackServerSocket` · `com/tuwinsmart/tuwin/core/device/ride5/JavaRide5CallbackServerSocket.java`
注解：

字段/常量（1）：
- `ServerSocket delegate`  L22

方法（4）：
- `public JavaRide5CallbackServerSocket(ServerSocket delegate)`  L24
    - 体内字面量："delegate"
- `int getLocalPort()`  L30 @Override
- `Ride5CallbackSocket accept()`  L35 @Override
    - 体内字面量："accept(...)"
- `void close()`  L42 @Override
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/device/ride5/JavaRide5CallbackServerSocket$Companion;" · "()V" · "open" · "Lcom/tuwinsmart/tuwin/core/device/ride5/JavaRide5CallbackServerSocket;" · "bindAddress" · "app_release_64"
### `com.tuwinsmart.tuwin.core.device.ride5.JavaRide5CallbackServerSocket$Companion`
L48 · [class] public static final Companion · `com/tuwinsmart/tuwin/core/device/ride5/JavaRide5CallbackServerSocket.java`
注解：

字段/常量（2）：
- `InetSocketAddress inetSocketAddress`  L64
- `String str = bindAddress`  L67

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L49
- `private Companion()`  L53
- `JavaRide5CallbackServerSocket open$default(Companion companion, int i, String str, int i2, Object obj)`  L56
- `JavaRide5CallbackServerSocket open(int port, String bindAddress)`  L63
### `com.tuwinsmart.tuwin.core.device.ride5.JavaRide5CallbackSocket`
L15 · [class] final JavaRide5CallbackSocket · implements `Ride5CallbackSocket` · `com/tuwinsmart/tuwin/core/device/ride5/JavaRide5CallbackSocket.java`
注解：

字段/常量（1）：
- `Socket delegate`  L16

方法（5）：
- `public JavaRide5CallbackSocket(Socket delegate)`  L18
    - 体内字面量："delegate"
- `String getRemoteHost()`  L24 @Override
- `InputStream getInput()`  L30 @Override
    - 体内字面量："getInputStream(...)"
- `void setReadTimeout(int timeoutMillis)`  L37 @Override
- `void close()`  L42 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.RecordingEventRide5SessionPort`
L38 · [class] public final RecordingEventRide5SessionPort · implements `Ride5SessionPort` · `com/tuwinsmart/tuwin/core/device/ride5/RecordingEventRide5SessionPort.java`
注解：

字段/常量（25）：
- `Ride5SessionPort delegate`  L39
- `Function1<Continuation<? super RecordingControlDevice>, Object> deviceProvider`  L40
- `Function0<Long> now`  L41
- `RecordingControlEventRepository repository`  L42
- `C19751 c19751`  L231
- `RecordingControlAction recordingControlAction`  L232
- `RecordingControlAction recordingControlAction2`  L233
- `RecordingEventRide5SessionPort recordingEventRide5SessionPort`  L234
- `RecordingControlDevice recordingControlDevice`  L235
- `Ride5CgiPayload ride5CgiPayload`  L236
- `RecordingControlDevice recordingControlDevice2`  L237
- `RecordingControlAction recordingControlAction3`  L238
- `Ride5CgiPayload ride5CgiPayload2`  L239
- `String str2 = str`  L240
- `Object objInvoke = c19751.result`  L251
- `int i = c19751.label`  L253
- `RecordingControlDevice recordingControlDevice3 = null`  L254
- `Function1<Continuation<? super RecordingControlDevice>, Object> function1 = this.deviceProvider`  L270
- `Ride5SessionPort ride5SessionPort = recordingEventRide5SessionPort.delegate`  L285
- `Ride5SessionPort ride5SessionPort2 = recordingEventRide5SessionPort.delegate`  L303
- `Function1<Continuation<? super RecordingControlDevice>, Object> function2 = this.deviceProvider`  L325
- `Ride5SessionPort ride5SessionPort3 = recordingEventRide5SessionPort.delegate`  L337
- `Ride5SessionPort ride5SessionPort4 = recordingEventRide5SessionPort.delegate`  L373
- `Ride5SessionPort ride5SessionPort5 = recordingEventRide5SessionPort.delegate`  L390
- `NonCancellable nonCancellable = NonCancellable.INSTANCE`  L419

方法（27）：
- `Object batteryCapacity(Continuation<? super Ride5CgiPayload> continuation)`  L68 @Override
- `Object cameraNumber(Continuation<? super Ride5CgiPayload> continuation)`  L73 @Override
- `Object cameraParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L78 @Override
- `Object cameraParameterCapability(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L83 @Override
- `Object checkPacket(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L88 @Override
- `Object commonParameter(String str, Continuation<? super Ride5CgiPayload> continuation)`  L93 @Override
- `Object commonParameterCapability(String str, Continuation<? super Ride5CgiPayload> continuation)`  L98 @Override
- `Object deleteFile(String str, Continuation<? super Ride5CgiPayload> continuation)`  L103 @Override
- `Object deviceAttributes(Continuation<? super Ride5CgiPayload> continuation)`  L108 @Override
- `Object directoryCapability(Continuation<? super Ride5CgiPayload> continuation)`  L113 @Override
- `Object ensureRecordingStopped(Continuation<? super Ride5CgiPayload> continuation)`  L118 @Override
- `Object fileCount(String str, Continuation<? super Ride5CgiPayload> continuation)`  L123 @Override
- `Object fileInfo(String str, Continuation<? super Ride5CgiPayload> continuation)`  L128 @Override
- `Object fileList(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L133 @Override
- `Object formatSdCard(Continuation<? super Ride5CgiPayload> continuation)`  L138 @Override
- `Object resetDevice(Continuation<? super Ride5CgiPayload> continuation)`  L143 @Override
- `Object sdStatus(Continuation<? super Ride5CgiPayload> continuation)`  L148 @Override
- `Object setCameraParameter(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L153 @Override
- `Object setCommonParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L158 @Override
- `Object setSystemTime(String str, Continuation<? super Ride5CgiPayload> continuation)`  L163 @Override
- `Object setWifi(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L168 @Override
- `Object switchCamera(String str, Continuation<? super Ride5CgiPayload> continuation)`  L173 @Override
- `Object wifi(Continuation<? super Ride5CgiPayload> continuation)`  L178 @Override
- `Object workState(Continuation<? super Ride5CgiPayload> continuation)`  L183 @Override
- `public RecordingEventRide5SessionPort(Ride5SessionPort delegate, Function1<? super Continuation<? super RecordingControlDevice>, ? extends Object> deviceProvider, RecordingControlEventRepository repository, Function0<Long> now)`  L188
    - 体内字面量："delegate" · "deviceProvider" · "repository" · "now"
- ` RecordingEventRide5SessionPort(Ride5SessionPort ride5SessionPort, Function1 function1, RecordingControlEventRepository recordingControlEventRepository, C19741 c19741, int i, DefaultConstructorMarker defaultConstructorMarker)`  L216
- `Object command(String str, Continuation<? super Ride5CgiPayload> continuation)`  L230 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.RecordingEventRide5SessionPort$C19741`
L202 · [class] C19741 · extends `FunctionReferenceImpl implements Function0<Long>` · implements `Function0<Long>` · `com/tuwinsmart/tuwin/core/device/ride5/RecordingEventRide5SessionPort.java`
注解：

方法（1）：
- `Long invoke()`  L211 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.RecordingEventRide5SessionPort$C19751`
L48 · [class] static final C19751 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/RecordingEventRide5SessionPort.java`
注解：

字段/常量（5）：
- `Object L$0`  L49
- `Object L$1`  L50
- `Object L$2`  L51
- `int label`  L52
- `Object result`  L53

方法（1）：
- `Object invokeSuspend(Object obj)`  L60 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.RecordingEventRide5SessionPort$C19762`
L460 · [class] static final C19762 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/RecordingEventRide5SessionPort.java`
注解：

字段/常量（6）：
- `RecordingControlAction $action`  L461
- `RecordingControlDevice $device`  L462
- `long $occurredAt`  L463
- `int label`  L464
- `Object objMo2803appendgIAlus`  L486
- `int i = this.label`  L488

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L475 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L480 @Override
- `Object invokeSuspend(Object obj)`  L485 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackBufferBudget`
L10 · [class] public final Ride5CallbackBufferBudget · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackBufferBudget.java`
注解：

字段/常量（3）：
- `int maximumBytes`  L12
- `int i`  L19
- `int i2`  L20

方法（4）：
- `public Ride5CallbackBufferBudget(int i)`  L14
- `boolean tryReserve(int bytes)`  L18
- `void release(int bytes)`  L34
    - 体内字面量："Failed requirement."
- `int bytesInUse()`  L41
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackChannel`
L53 · [class] public final Ride5CallbackChannel · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackChannel.java`
注解：

字段/常量（70）：
- `MutableSharedFlow<Ride5CallbackEvent> _events`  L54
- `Job acceptJob`  L55
- `AtomicBoolean active`  L56
- `Ride5CallbackBufferBudget bufferBudget`  L57
- `EndpointGrant callbackGrant`  L58
- `Function0<RouteSnapshot> currentRoute`  L59
- `Ride5CallbackDecoder decoder`  L60
- `DeviceEndpointAuthority endpointAuthority`  L61
- `Flow<Ride5CallbackEvent> events`  L62
- `Ride5CallbackLimits limits`  L63
- `String listenAddress`  L64
- `Set<Ride5CallbackSocket> resources`  L65
- `RouteSnapshot route`  L66
- `CoroutineScope scope`  L67
- `Ride5CallbackServerSocket server`  L68
- `String sessionId`  L69
- `Ride5CallbackServerSocketFactory socketFactory`  L70
- `Unit unit`  L173
- `Result.Companion companion = Result.INSTANCE`  L192
- `Ride5CallbackServerSocket ride5CallbackServerSocket = this.server`  L193
- `Result.Companion companion2 = Result.INSTANCE`  L202
- `List<Ride5CallbackSocket> list`  L255
- `Unit unit`  L256
- `Job job = this.acceptJob`  L260
- `Result.Companion companion = Result.INSTANCE`  L266
- `Ride5CallbackChannel ride5CallbackChannel = this`  L267
- `Ride5CallbackServerSocket ride5CallbackServerSocket = this.server`  L268
- `Result.Companion companion2 = Result.INSTANCE`  L277
- `Set<Ride5CallbackSocket> resources = this.resources`  L281
- `Set<Ride5CallbackSocket> resources2 = this.resources`  L284
- `Result.Companion companion3 = Result.INSTANCE`  L290
- `Ride5CallbackChannel ride5CallbackChannel2 = this`  L291
- `Result.Companion companion4 = Result.INSTANCE`  L295
- `C19781 c19781`  L356
- `Ride5CallbackChannel ride5CallbackChannel`  L357
- `MutableSharedFlow<Ride5CallbackEvent> mutableSharedFlow`  L358
- `Ride5CallbackEvent.Failed failed`  L359
- `Object obj = c19781.result`  L370
- `int i = c19781.label`  L372
- `Result.Companion companion = Result.INSTANCE`  L412
- `Ride5CallbackChannel ride5CallbackChannel2 = this`  L413
- `Result.Companion companion2 = Result.INSTANCE`  L417
- `Result.Companion companion3 = Result.INSTANCE`  L425
- `Ride5CallbackChannel ride5CallbackChannel3 = this`  L426
- `Result.Companion companion4 = Result.INSTANCE`  L430
- `Set<Ride5CallbackSocket> resources = this.resources`  L434
- `Ride5CallbackChannel c19811`  L530
- `Ride5CallbackChannel ride5CallbackChannel`  L531
- `Ride5CallbackChannel ride5CallbackChannel2`  L532
- `Object obj = c19811.result`  L544
- `int i = c19811.label`  L546
- `Result.Companion companion = Result.INSTANCE`  L555
- `Result.Companion companion2 = Result.INSTANCE`  L566
- `Result.Companion companion3 = Result.INSTANCE`  L574
- `Result.Companion companion4 = Result.INSTANCE`  L578
- `RouteSnapshot routeSnapshot`  L597
- `RouteSnapshot routeSnapshot`  L614
- `Result.Companion companion5 = Result.INSTANCE`  L627
- `Ride5CallbackChannel ride5CallbackChannel3 = this`  L628
- `Result.Companion companion6 = Result.INSTANCE`  L635
- `MutableSharedFlow<Ride5CallbackEvent> mutableSharedFlow = this._events`  L642
- `Result.Companion companion7 = Result.INSTANCE`  L653
- `MutableSharedFlow<Ride5CallbackEvent> mutableSharedFlow2 = this._events`  L658
- `Result.Companion companion8 = Result.INSTANCE`  L669
- `Result.Companion companion9 = Result.INSTANCE`  L676
- `Result.Companion companion10 = Result.INSTANCE`  L684
- `Object objM3074constructorimpl`  L691
- `Result.Companion companion = Result.INSTANCE`  L693
- `Ride5CallbackChannel ride5CallbackChannel = this`  L694
- `Result.Companion companion2 = Result.INSTANCE`  L698

方法（14）：
- `public Ride5CallbackChannel(String sessionId, RouteSnapshot route, EndpointGrant callbackGrant, DeviceEndpointAuthority endpointAuthority, Function0<RouteSnapshot> currentRoute, String str, Ride5CallbackServerSocketFactory socketFactory, Ride5CallbackDecoder decoder, Ride5CallbackLimits limits, CoroutineScope parentScope)`  L115
    - 体内字面量："sessionId" · "route" · "callbackGrant" · "endpointAuthority" · "currentRoute" · "socketFactory" · "decoder" · "limits" · "parentScope" · "Failed requirement." · "Failed requirement." · "Failed requirement." · "Failed requirement."
- ` Ride5CallbackChannel(String str, RouteSnapshot routeSnapshot, EndpointGrant endpointGrant, DeviceEndpointAuthority deviceEndpointAuthority, Function0 function0, String str2, Ride5CallbackServerSocketFactory ride5CallbackServerSocketFactory, Ride5CallbackDecoder ride5CallbackDecoder, Ride5CallbackLimits ride5CallbackLimits, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker)`  L155
- `Ride5CallbackServerSocket open(int port, String bindAddress)`  L158 @Override
- `Flow<Ride5CallbackEvent> getEvents()`  L164
- `boolean isRunning()`  L168
- `void start()`  L172
- `Object close(Continuation<? super Unit> continuation)`  L254
- `void invalidateForRoute(long newRouteRevision)`  L345
- `Object acceptLoop(Ride5CallbackServerSocket ride5CallbackServerSocket, Continuation<? super Unit> continuation)`  L355
- `Object receive(final Ride5CallbackSocket ride5CallbackSocket, Continuation<? super Unit> continuation)`  L529
- `Boolean invoke()`  L596 @Override
- `Unit invoke(byte[] bArr)`  L607 @Override
- `void invoke2(byte[] payload)`  L613
- `boolean isAuthorizedSource(String remoteHost)`  L690
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackChannel$C19781`
L76 · [class] static final C19781 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackChannel.java`
注解：

字段/常量（3）：
- `Object L$0`  L77
- `int label`  L78
- `Object result`  L79

方法（1）：
- `Object invokeSuspend(Object obj)`  L86 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackChannel$C19794`
L471 · [class] static final C19794 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackChannel.java`
注解：

字段/常量（3）：
- `Ride5CallbackSocket $socket`  L472
- `int label`  L473
- `int i = this.label`  L494

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L482 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L487 @Override
- `Object invokeSuspend(Object obj)`  L492 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackChannel$C19801`
L308 · [class] static final C19801 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackChannel.java`
注解：

字段/常量（2）：
- `int label`  L309
- `int i = this.label`  L328

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L316 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L321 @Override
- `Object invokeSuspend(Object obj)`  L326 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackChannel$C19811`
L97 · [class] static final C19811 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackChannel.java`
注解：

字段/常量（4）：
- `Object L$0`  L98
- `Object L$1`  L99
- `int label`  L100
- `Object result`  L101

方法（1）：
- `Object invokeSuspend(Object obj)`  L108 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackChannel$C19843`
L214 · [class] static final C19843 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackChannel.java`
注解：

字段/常量（3）：
- `Ride5CallbackServerSocket $opened`  L215
- `int label`  L216
- `int i = this.label`  L237

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L225 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L230 @Override
- `Object invokeSuspend(Object obj)`  L235 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackDecoder`
L12 · [interface] public Ride5CallbackDecoder · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackDecoder.java`
注解：

方法（1）：
- `void decode(Ride5CallbackSocket socket, Ride5CallbackLimits limits, Function0<Boolean> isActive, Ride5CallbackBufferBudget bufferBudget, Function1<? super byte[], Unit> emit)`  L13
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackEvent`
L10 · [interface] public Ride5CallbackEvent · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent.java`
注解：

字面量："Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent$Frame;" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent;" · "value" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackFrame;" · "(Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackFrame;)V" · "getValue" · "()Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackFrame;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent$SourceRejected;" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent;" · "remoteHost" · "(Ljava/lang/String;)V" · "getRemoteHost" · "()Ljava/lang/String;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent$Failed;" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent;" · "cause" · "(Ljava/lang/Throwable;)V" · "getCause" · "()Ljava/lang/Throwable;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackEvent$Failed`
L108 · [class] public static final Failed · implements `Ride5CallbackEvent` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent.java`
注解：

字段/常量（1）：
- `Throwable cause`  L109

方法（8）：
- `Failed copy$default(Failed failed, Throwable th, int i, Object obj)`  L111
- `Throwable getCause()`  L119
- `Failed copy(Throwable cause)`  L123
    - 体内字面量："cause"
- `boolean equals(Object other)`  L128
- `int hashCode()`  L135
- `String toString()`  L139
    - 体内字面量："Failed(cause=" · ")"
- `public Failed(Throwable cause)`  L143
    - 体内字面量："cause"
- `Throwable getCause()`  L148
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackEvent$Frame`
L14 · [class] public static final Frame · implements `Ride5CallbackEvent` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent.java`
注解：

字段/常量（1）：
- `Ride5CallbackFrame value`  L15

方法（8）：
- `Frame copy$default(Frame frame, Ride5CallbackFrame ride5CallbackFrame, int i, Object obj)`  L17
- `Ride5CallbackFrame getValue()`  L25
- `Frame copy(Ride5CallbackFrame value)`  L29
    - 体内字面量："value"
- `boolean equals(Object other)`  L34
- `int hashCode()`  L41
- `String toString()`  L45
    - 体内字面量："Frame(value=" · ")"
- `public Frame(Ride5CallbackFrame value)`  L49
    - 体内字面量："value"
- `Ride5CallbackFrame getValue()`  L54
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackEvent$SourceRejected`
L61 · [class] public static final SourceRejected · implements `Ride5CallbackEvent` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackEvent.java`
注解：

字段/常量（1）：
- `String remoteHost`  L62

方法（8）：
- `SourceRejected copy$default(SourceRejected sourceRejected, String str, int i, Object obj)`  L64
- `String getRemoteHost()`  L72
- `SourceRejected copy(String remoteHost)`  L76
    - 体内字面量："remoteHost"
- `boolean equals(Object other)`  L81
- `int hashCode()`  L88
- `String toString()`  L92
    - 体内字面量："SourceRejected(remoteHost=" · ")"
- `public SourceRejected(String remoteHost)`  L96
    - 体内字面量："remoteHost"
- `String getRemoteHost()`  L101
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackException`
L12 · [class] public final Ride5CallbackException · extends `IOException` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackException.java`
注解：

方法（2）：
- `public Ride5CallbackException(String message, Throwable th)`  L14
    - 体内字面量："message"
- ` Ride5CallbackException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker)`  L19
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackFrame`
L12 · [class] public final Ride5CallbackFrame · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackFrame.java`
注解：

字段/常量（6）：
- `byte[] payload`  L13
- `String remoteHost`  L14
- `long routeRevision`  L15
- `String sessionId`  L16
- `String str3 = str`  L25
- `String str4 = str2`  L29

方法（15）：
- `Ride5CallbackFrame copy$default(Ride5CallbackFrame ride5CallbackFrame, byte[] bArr, String str, String str2, long j, int i, Object obj)`  L18
- `byte[] getPayload()`  L37
- `String getRemoteHost()`  L42
- `String getSessionId()`  L47
- `long getRouteRevision()`  L52
- `Ride5CallbackFrame copy(byte[] payload, String remoteHost, String sessionId, long routeRevision)`  L56
    - 体内字面量："payload" · "remoteHost" · "sessionId"
- `boolean equals(Object other)`  L63
- `int hashCode()`  L74
- `String toString()`  L78
    - 体内字面量："Ride5CallbackFrame(payload=" · ", remoteHost=" · ", sessionId=" · ", routeRevision=" · ")"
- `public Ride5CallbackFrame(byte[] payload, String remoteHost, String sessionId, long j)`  L82
    - 体内字面量："payload" · "remoteHost" · "sessionId"
- `byte[] getPayload()`  L92
- `String getRemoteHost()`  L96
- `String getSessionId()`  L100
- `long getRouteRevision()`  L104
- `String text()`  L108
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackLimits`
L12 · [class] public final Ride5CallbackLimits · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackLimits.java`
注解：

字段/常量（4）：
- `int maxFrameBytes`  L13
- `int maxTotalBufferBytes`  L14
- `int port`  L15
- `int readTimeoutMillis`  L16

方法（16）：
- `public Ride5CallbackLimits()`  L18
- `Ride5CallbackLimits copy$default(Ride5CallbackLimits ride5CallbackLimits, int i, int i2, int i3, int i4, int i5, Object obj)`  L22
- `int getPort()`  L39
- `int getReadTimeoutMillis()`  L44
- `int getMaxFrameBytes()`  L49
- `int getMaxTotalBufferBytes()`  L54
- `Ride5CallbackLimits copy(int port, int readTimeoutMillis, int maxFrameBytes, int maxTotalBufferBytes)`  L58
- `boolean equals(Object other)`  L62
- `int hashCode()`  L73
- `String toString()`  L77
    - 体内字面量："Ride5CallbackLimits(port=" · ", readTimeoutMillis=" · ", maxFrameBytes=" · ", maxTotalBufferBytes=" · ")"
- `public Ride5CallbackLimits(int i, int i2, int i3, int i4)`  L81
    - 体内字面量："Failed requirement." · "Failed requirement." · "Failed requirement." · "Failed requirement."
- ` Ride5CallbackLimits(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker)`  L100
- `int getPort()`  L104
- `int getReadTimeoutMillis()`  L108
- `int getMaxFrameBytes()`  L112
- `int getMaxTotalBufferBytes()`  L116
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackMessagePolicy`
L13 · [class] public final Ride5CallbackMessagePolicy · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackMessagePolicy.java`
注解：

字段/常量（4）：
- `String NORM_REC_ARG = "\"arg2\":\"NORM_REC\""`  L15
- `String SWITCH_WORKMODE_EVENT = "\"eventid\":\"STATEMNG_SWITCH_WORKMODE\""`  L16
- `String str = message`  L23
- `String str2 = string`  L33

方法（2）：
- `private Ride5CallbackMessagePolicy()`  L18
- `boolean shouldRestartPreview(String message)`  L21
    - 体内字面量："message"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackServerSocket`
L10 · [interface] public Ride5CallbackServerSocket · extends `AutoCloseable` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackServerSocket.java`
注解：

方法（3）：
- `Ride5CallbackSocket accept()`  L11
- `void close()`  L14 @Override
- `int getLocalPort()`  L16
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackServerSocketFactory`
L10 · [interface] public Ride5CallbackServerSocketFactory · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackServerSocketFactory.java`
注解：

方法（1）：
- `Ride5CallbackServerSocket open(int port, String bindAddress)`  L11
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackServerSocketFactory$DefaultImpls`
L15 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackServerSocketFactory.java`
注解：

方法（1）：
- `Ride5CallbackServerSocket open$default(Ride5CallbackServerSocketFactory ride5CallbackServerSocketFactory, int i, String str, int i2, Object obj)`  L16
    - 体内字面量："Super calls with default arguments not supported in this target, function: open"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackSocket`
L11 · [interface] public Ride5CallbackSocket · extends `AutoCloseable` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CallbackSocket.java`
注解：

方法（4）：
- `void close()`  L13 @Override
- `InputStream getInput()`  L15
- `String getRemoteHost()`  L17
- `void setReadTimeout(int timeoutMillis)`  L19
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiApi`
L15 · [interface] public Ride5CgiApi · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi.java`
注解：

方法（9）：
- `Object formatSdCard(Continuation<? super String> continuation)`  L26 @GET("cgi-bin/hisnet/sdcommand.cgi?&-format")
    - 体内字面量："cgi-bin/hisnet/getbatterycapacity.cgi"
- `Object getBatteryCapacity(Continuation<? super String> continuation)`  L29 @GET("cgi-bin/hisnet/getbatterycapacity.cgi")
    - 体内字面量："cgi-bin/hisnet/getcamnum.cgi"
- `Object getCameraNumber(Continuation<? super String> continuation)`  L32 @GET("cgi-bin/hisnet/getcamnum.cgi")
    - 体内字面量："cgi-bin/hisnet/getcamparam.cgi" · "-workmode" · "-type" · "cgi-bin/hisnet/getcamparamcapability.cgi" · "-workmode" · "-type" · "cgi-bin/hisnet/getcommparam.cgi" · "-type" · "cgi-bin/hisnet/getcommparamcapability.cgi" · "-type" · "cgi-bin/hisnet/getdeviceattr.cgi"
- `Object getDeviceAttributes(Continuation<? super String> continuation)`  L47 @GET("cgi-bin/hisnet/getdeviceattr.cgi")
    - 体内字面量："cgi-bin/hisnet/getdircapability.cgi"
- `Object getDirectoryCapability(Continuation<? super String> continuation)`  L50 @GET("cgi-bin/hisnet/getdircapability.cgi")
    - 体内字面量："cgi-bin/hisnet/getdirfilecount.cgi" · "-dir" · "cgi-bin/hisnet/getdirfilelist.cgi" · "-dir" · "-start" · "-end" · "cgi-bin/hisnet/getfileinfo.cgi" · "-name" · "cgi-bin/hisnet/getsdstatus.cgi"
- `Object getSdStatus(Continuation<? super String> continuation)`  L62 @GET("cgi-bin/hisnet/getsdstatus.cgi")
    - 体内字面量："cgi-bin/hisnet/getwifi.cgi"
- `Object getWifi(Continuation<? super String> continuation)`  L65 @GET("cgi-bin/hisnet/getwifi.cgi")
    - 体内字面量："cgi-bin/hisnet/getworkstate.cgi"
- `Object getWorkState(Continuation<? super String> continuation)`  L68 @GET("cgi-bin/hisnet/getworkstate.cgi")
    - 体内字面量："cgi-bin/hisnet/client.cgi" · "-operation" · "-ip" · "cgi-bin/hisnet/reset.cgi"
- `Object resetDevice(Continuation<? super String> continuation)`  L74 @GET("cgi-bin/hisnet/reset.cgi")
    - 体内字面量："cgi-bin/hisnet/setcamparam.cgi" · "-workmode" · "-type" · "-value" · "cgi-bin/hisnet/setcommparam.cgi" · "-type" · "-value" · "cgi-bin/hisnet/setsystime.cgi" · "-time" · "cgi-bin/hisnet/setwifi.cgi" · "-wifissid" · "-wifikey" · "cgi-bin/hisnet/getcamchnl.cgi" · "-camid" · "cgi-bin/hisnet/workmodecmd.cgi" · "-cmd"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiException`
L12 · [class] public abstract Ride5CgiException · extends `IllegalStateException` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiException.java`
注解：

方法（2）：
- ` Ride5CgiException(String str, DefaultConstructorMarker defaultConstructorMarker)`  L13
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiException$BusinessError;" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiException;" · "(Ljava/lang/String;)V" · "getCode" · "()Ljava/lang/String;" · "app_release_64"
- `private Ride5CgiException(String str)`  L34
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiException$ProtocolError;" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiException;" · "message" · "(Ljava/lang/String;)V" · "app_release_64"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiException$BusinessError`
L19 · [class] public static final BusinessError · extends `Ride5CgiException` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiException.java`
注解：

字段/常量（1）：
- `String code`  L20

方法（2）：
- `String getCode()`  L22
- `public BusinessError(String code)`  L27
    - 体内字面量："RIDE5 CGI business error: " · "code"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiException$ProtocolError`
L40 · [class] public static final ProtocolError · extends `Ride5CgiException` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiException.java`
注解：

方法（1）：
- `public ProtocolError(String message)`  L42
    - 体内字面量："message"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway`
L64 · [class] public final Ride5CgiGateway · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（39）：
- `Function2<RouteLease, EndpointGrant, Ride5CgiApi> apiFactory`  L65
- `AtomicBoolean closed`  L66
- `Function0<RouteSnapshot> currentRoute`  L67
- `DeviceEndpointAuthority endpointAuthority`  L68
- `EndpointGrant endpointGrant`  L69
- `Function0<String> fallbackDeviceId`  L70
- `DeviceOperationKind operation`  L71
- `Ride5CgiParser parser`  L72
- `HttpClientProfile profile`  L73
- `EndpointPurpose requestedPurpose`  L74
- `RoutedRetrofitProvider retrofitProvider`  L75
- `RouteSnapshot route`  L76
- `RouteProvider routeProvider`  L77
- `String sessionId`  L78
- `Function2 function3`  L189
- `HttpClientProfile httpClientProfile3 = httpClientProfile2`  L212
- `EndpointPurpose endpointPurpose3 = endpointPurpose2`  L213
- `RoutedRetrofitProvider routedRetrofitProvider2 = routedRetrofitProvider`  L224
- `HttpClientProfile httpClientProfile4 = httpClientProfile3`  L226
- `DeviceEndpointAuthority deviceEndpointAuthority2 = deviceEndpointAuthority`  L228
- `String str2 = str`  L229
- `EndpointPurpose endpointPurpose4 = endpointPurpose3`  L230
- `C19981 c19981`  L429
- `Ride5CgiGateway ride5CgiGateway`  L430
- `C19981 c19982 = c19981`  L441
- `Object objRequest$default = c19982.result`  L442
- `int i = c19982.label`  L444
- `C20081 c20081`  L1718
- `Set of`  L1719
- `RouteLease routeLease`  L1720
- `Function1<? super String, Ride5CgiPayload> function3`  L1721
- `Object obj = c20081.result`  L1732
- `int i = c20081.label`  L1734
- `C20181 c20181`  L1802
- `DisposableHandle disposableHandleInvokeOnCompletion`  L1803
- `Throwable th`  L1804
- `CompletableJob completableJob`  L1805
- `Object obj = c20181.result`  L1816
- `int i = c20181.label`  L1818

方法（42）：
- `public Ride5CgiGateway(String sessionId, RouteSnapshot route, EndpointGrant endpointGrant, RouteProvider routeProvider, RoutedRetrofitProvider retrofitProvider, DeviceEndpointAuthority endpointAuthority, HttpClientProfile profile, EndpointPurpose requestedPurpose, DeviceOperationKind operation, Function0<RouteSnapshot> currentRoute, Ride5CgiParser parser, Function0<String> fallbackDeviceId, Function2<? super RouteLease, ? super EndpointGrant, ? extends Ride5CgiApi> apiFactory)`  L146
    - 体内字面量："sessionId" · "route" · "endpointGrant" · "routeProvider" · "retrofitProvider" · "endpointAuthority" · "profile" · "requestedPurpose" · "operation" · "currentRoute" · "parser" · "fallbackDeviceId" · "apiFactory" · "Failed requirement." · "Failed requirement." · "Failed requirement." · "Failed requirement."
- ` Ride5CgiGateway(final String str, final RouteSnapshot routeSnapshot, EndpointGrant endpointGrant, RouteProvider routeProvider, final RoutedRetrofitProvider routedRetrofitProvider, final DeviceEndpointAuthority deviceEndpointAuthority, HttpClientProfile httpClientProfile, EndpointPurpose endpointPurpose, DeviceOperationKind deviceOperationKind, Function0 function0, Ride5CgiParser ride5CgiParser, Function0 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker)`  L188
- `RouteSnapshot invoke()`  L200 @Override
- `Void invoke()`  L207 @Override
- `Ride5CgiApi invoke(final RouteLease lease, final EndpointGrant grant)`  L221 @Override
    - 体内字面量："lease" · "grant"
- `Unit invoke(OkHttpClient.Builder builder)`  L238 @Override
- `void invoke2(OkHttpClient.Builder create)`  L244
    - 体内字面量："$this$create" · "ride5_cgi" · "ride5_cgi"
- `Unit invoke(Retrofit.Builder builder)`  L252 @Override
- `void invoke2(Retrofit.Builder create)`  L258
    - 体内字面量："$this$create" · "<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$registerCallback$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object registerCallback(String str, Continuation<? super Ride5CgiPayload> continuation)`  L319
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$unregisterCallback$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object unregisterCallback(String str, Continuation<? super Ride5CgiPayload> continuation)`  L371
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$checkSocketConnect$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object checkSocketConnect(String str, Continuation<? super Ride5CgiPayload> continuation)`  L423
- `Object getDeviceAttributes(Continuation<? super Ride5CgiPayload> continuation)`  L428
- `Object setSystemTime(String str, Continuation<? super Ride5CgiPayload> continuation)`  L524
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getWorkState$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getWorkState(Continuation<? super Ride5CgiPayload> continuation)`  L573
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$workModeCommand$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object workModeCommand(String str, Continuation<? super Ride5CgiPayload> continuation)`  L625
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getDirectoryCapability$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getDirectoryCapability(Continuation<? super Ride5CgiPayload> continuation)`  L674
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getDirectoryFileCount$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getDirectoryFileCount(String str, Continuation<? super Ride5CgiPayload> continuation)`  L726
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getDirectoryFileList$3" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getDirectoryFileList(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L795
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getFileInfo$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getFileInfo(String str, Continuation<? super Ride5CgiPayload> continuation)`  L847
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$deleteFile$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object deleteFile(String str, Continuation<? super Ride5CgiPayload> continuation)`  L899
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$checkUpgradePacketInfo$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object checkUpgradePacketInfo(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L955
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getSdStatus$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getSdStatus(Continuation<? super Ride5CgiPayload> continuation)`  L1004
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$formatSdCard$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object formatSdCard(Continuation<? super Ride5CgiPayload> continuation)`  L1053
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$resetDevice$3" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object resetDevice(Continuation<? super Ride5CgiPayload> continuation)`  L1117
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getCameraNumber$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getCameraNumber(Continuation<? super Ride5CgiPayload> continuation)`  L1166
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$switchCamera$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object switchCamera(String str, Continuation<? super Ride5CgiPayload> continuation)`  L1218
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getWifi$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getWifi(Continuation<? super Ride5CgiPayload> continuation)`  L1267
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$setWifi$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object setWifi(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L1321
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getCommonParameter$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getCommonParameter(String str, Continuation<? super Ride5CgiPayload> continuation)`  L1373
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getCommonParameterCapability$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getCommonParameterCapability(String str, Continuation<? super Ride5CgiPayload> continuation)`  L1425
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$setCommonParameter$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object setCommonParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L1479
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getCameraParameter$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getCameraParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L1533
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getCameraParameterCapability$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getCameraParameterCapability(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L1587
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$setCameraParameter$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object setCameraParameter(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L1643
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/core/device/ride5/Ride5CgiApi;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getBatteryCapacity$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
- `Object getBatteryCapacity(Continuation<? super Ride5CgiPayload> continuation)`  L1692
- `void invalidate()`  L1696
- `Object request(Function1<? super String, Ride5CgiPayload> function1, Function2<? super Ride5CgiApi, ? super Continuation<? super String>, ? extends Object> function2, Continuation<? super Ride5CgiPayload> continuation)`  L1717
- `Object request$default(Ride5CgiGateway ride5CgiGateway, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj)`  L1792
- `Object withLeaseCancellation(RouteLease routeLease, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation)`  L1801
- `Unit invoke(Throwable th3)`  L1845 @Override
- `void invoke2(Throwable th3)`  L1851
    - 体内字面量："RIDE5 route lease was closed" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$withLeaseCancellation$2" · "Ride5CgiGateway.kt" · "invokeSuspend"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19882`
L379 · [class] static final C19882 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $callbackIp`  L380
- `Object L$0`  L381
- `int label`  L382
- `int i = this.label`  L405

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L391 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L398 @Override
- `Object invokeSuspend(Object obj)`  L403 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19892`
L907 · [class] static final C19892 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（6）：
- `String $model`  L908
- `String $packetLength`  L909
- `String $version`  L910
- `Object L$0`  L911
- `int label`  L912
- `int i = this.label`  L937

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L923 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L930 @Override
- `Object invokeSuspend(Object obj)`  L935 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19902`
L855 · [class] static final C19902 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $name`  L856
- `Object L$0`  L857
- `int label`  L858
- `int i = this.label`  L881

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L867 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L874 @Override
- `Object invokeSuspend(Object obj)`  L879 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19912`
L1012 · [class] static final C19912 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L1013
- `int label`  L1014
- `int i = this.label`  L1035

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1021 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1028 @Override
- `Object invokeSuspend(Object obj)`  L1033 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19922`
L1651 · [class] static final C19922 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L1652
- `int label`  L1653
- `int i = this.label`  L1674

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1660 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1667 @Override
- `Object invokeSuspend(Object obj)`  L1672 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19932`
L1125 · [class] static final C19932 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L1126
- `int label`  L1127
- `int i = this.label`  L1148

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1134 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1141 @Override
- `Object invokeSuspend(Object obj)`  L1146 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19942`
L1487 · [class] static final C19942 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（5）：
- `String $type`  L1488
- `String $workMode`  L1489
- `Object L$0`  L1490
- `int label`  L1491
- `int i = this.label`  L1515

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1501 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1508 @Override
- `Object invokeSuspend(Object obj)`  L1513 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19952`
L1541 · [class] static final C19952 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（5）：
- `String $type`  L1542
- `String $workMode`  L1543
- `Object L$0`  L1544
- `int label`  L1545
- `int i = this.label`  L1569

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1555 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1562 @Override
- `Object invokeSuspend(Object obj)`  L1567 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19962`
L1329 · [class] static final C19962 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $type`  L1330
- `Object L$0`  L1331
- `int label`  L1332
- `int i = this.label`  L1355

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1341 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1348 @Override
- `Object invokeSuspend(Object obj)`  L1353 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19972`
L1381 · [class] static final C19972 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $type`  L1382
- `Object L$0`  L1383
- `int label`  L1384
- `int i = this.label`  L1407

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1393 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1400 @Override
- `Object invokeSuspend(Object obj)`  L1405 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19981`
L84 · [class] static final C19981 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L85
- `int label`  L86
- `Object result`  L87

方法（1）：
- `Object invokeSuspend(Object obj)`  L94 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C19992`
L633 · [class] static final C19992 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L634
- `int label`  L635
- `int i = this.label`  L656

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L642 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L649 @Override
- `Object invokeSuspend(Object obj)`  L654 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20002`
L682 · [class] static final C20002 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $directory`  L683
- `Object L$0`  L684
- `int label`  L685
- `int i = this.label`  L708

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L694 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L701 @Override
- `Object invokeSuspend(Object obj)`  L706 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20012`
L733 · [class] C20012 · extends `FunctionReferenceImpl implements Function1<String, Ride5CgiPayload>` · implements `Function1<String, Ride5CgiPayload>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

方法（1）：
- `Ride5CgiPayload invoke(String p0)`  L739 @Override
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20023`
L749 · [class] static final C20023 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（5）：
- `String $directory`  L750
- `String $end`  L751
- `Object L$0`  L752
- `int label`  L753
- `int i = this.label`  L777

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L763 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L770 @Override
- `Object invokeSuspend(Object obj)`  L775 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20032`
L803 · [class] static final C20032 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $name`  L804
- `Object L$0`  L805
- `int label`  L806
- `int i = this.label`  L829

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L815 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L822 @Override
- `Object invokeSuspend(Object obj)`  L827 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20042`
L963 · [class] static final C20042 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L964
- `int label`  L965
- `int i = this.label`  L986

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L972 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L979 @Override
- `Object invokeSuspend(Object obj)`  L984 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20052`
L1226 · [class] static final C20052 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L1227
- `int label`  L1228
- `int i = this.label`  L1249

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1235 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1242 @Override
- `Object invokeSuspend(Object obj)`  L1247 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20062`
L532 · [class] static final C20062 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L533
- `int label`  L534
- `int i = this.label`  L555

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L541 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L548 @Override
- `Object invokeSuspend(Object obj)`  L553 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20072`
L275 · [class] static final C20072 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $callbackIp`  L276
- `Object L$0`  L277
- `int label`  L278
- `int i = this.label`  L301

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L287 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L294 @Override
- `Object invokeSuspend(Object obj)`  L299 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20081`
L105 · [class] static final C20081 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `Object L$0`  L106
- `Object L$1`  L107
- `int label`  L108
- `Object result`  L109

方法（1）：
- `Object invokeSuspend(Object obj)`  L116 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20092`
L1703 · [class] C20092 · extends `FunctionReferenceImpl implements Function1<String, Ride5CgiPayload>` · implements `Function1<String, Ride5CgiPayload>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

方法（1）：
- `Ride5CgiPayload invoke(String p0)`  L1709 @Override
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20102`
L1060 · [class] C20102 · extends `FunctionReferenceImpl implements Function1<String, Ride5CgiPayload>` · implements `Function1<String, Ride5CgiPayload>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

方法（1）：
- `Ride5CgiPayload invoke(String p0)`  L1066 @Override
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20113`
L1076 · [class] static final C20113 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L1077
- `int label`  L1078
- `int i = this.label`  L1099

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1085 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1092 @Override
- `Object invokeSuspend(Object obj)`  L1097 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20122`
L1595 · [class] static final C20122 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（6）：
- `String $type`  L1596
- `String $value`  L1597
- `String $workMode`  L1598
- `Object L$0`  L1599
- `int label`  L1600
- `int i = this.label`  L1625

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1611 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1618 @Override
- `Object invokeSuspend(Object obj)`  L1623 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20132`
L1433 · [class] static final C20132 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（5）：
- `String $type`  L1434
- `String $value`  L1435
- `Object L$0`  L1436
- `int label`  L1437
- `int i = this.label`  L1461

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1447 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1454 @Override
- `Object invokeSuspend(Object obj)`  L1459 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20142`
L480 · [class] static final C20142 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $value`  L481
- `Object L$0`  L482
- `int label`  L483
- `int i = this.label`  L506

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L492 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L499 @Override
- `Object invokeSuspend(Object obj)`  L504 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20152`
L1275 · [class] static final C20152 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（5）：
- `String $password`  L1276
- `String $ssid`  L1277
- `Object L$0`  L1278
- `int label`  L1279
- `int i = this.label`  L1303

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1289 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1296 @Override
- `Object invokeSuspend(Object obj)`  L1301 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20162`
L1174 · [class] static final C20162 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $cameraId`  L1175
- `Object L$0`  L1176
- `int label`  L1177
- `int i = this.label`  L1200

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1186 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L1193 @Override
- `Object invokeSuspend(Object obj)`  L1198 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20172`
L327 · [class] static final C20172 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $callbackIp`  L328
- `Object L$0`  L329
- `int label`  L330
- `int i = this.label`  L353

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L339 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L346 @Override
- `Object invokeSuspend(Object obj)`  L351 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20181`
L127 · [class] static final C20181 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `Object L$0`  L128
- `Object L$1`  L129
- `int label`  L130
- `Object result`  L131

方法（1）：
- `Object invokeSuspend(Object obj)`  L138 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20192`
L1887 · [class] static final C20192 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object>` · implements `Function2<CoroutineScope, Continuation<? super T>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `Function1<Continuation<? super T>, Object> $block`  L1888
- `int label`  L1889
- `int i = this.label`  L1911
- `Function1<Continuation<? super T>, Object> function1 = this.$block`  L1914

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1899 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation)`  L1904 @Override
- `Object invokeSuspend(Object obj)`  L1909 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$C20202`
L581 · [class] static final C20202 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway.java`
注解：

字段/常量（4）：
- `String $command`  L582
- `Object L$0`  L583
- `int label`  L584
- `int i = this.label`  L607

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L593 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L600 @Override
- `Object invokeSuspend(Object obj)`  L605 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$getDeviceAttributes$payload$1`
L17 · [class] final Ride5CgiGateway$getDeviceAttributes$payload$1 · extends `SuspendLambda implements Function2<Ride5CgiApi, Continuation<? super String>, Object>` · implements `Function2<Ride5CgiApi, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway$getDeviceAttributes$payload$1.java`
注解：

字段/常量（3）：
- `Object L$0`  L18
- `int label`  L19
- `int i = this.label`  L40

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L26 @Override
- `Object invoke(Ride5CgiApi ride5CgiApi, Continuation<? super String> continuation)`  L33 @Override
- `Object invokeSuspend(Object obj)`  L38 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$request$body$1`
L17 · [class] final Ride5CgiGateway$request$body$1 · extends `SuspendLambda implements Function1<Continuation<? super String>, Object>` · implements `Function1<Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGateway$request$body$1.java`
注解：

字段/常量（4）：
- `Function2<Ride5CgiApi, Continuation<? super String>, Object> $call`  L18
- `RouteLease $lease`  L19
- `int label`  L20
- `Ride5CgiGateway this$0`  L21

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L33 @Override
- `Object invoke(Continuation<? super String> continuation)`  L38 @Override
- `java.lang.Object invokeSuspend(java.lang.Object r6)`  L51 @Override
    - 体内字面量："Method not decompiled: com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGateway$request$body$1.invokeSuspend(java.lang.Object):java.lang.Object" · "call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiGatewayKt`
L17 · [class] public final Ride5CgiGatewayKt · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiGatewayKt.java`
注解：

字段/常量（2）：
- `String host`  L20
- `Interceptor.Companion companion = Interceptor.INSTANCE`  L36

方法（3）：
- `String ride5CgiBaseUrl(EndpointGrant endpointGrant)`  L19
- `Interceptor endpointInterceptor(final DeviceEndpointAuthority deviceEndpointAuthority, final EndpointGrant endpointGrant, final String str, final long j, final EndpointPurpose endpointPurpose)`  L35
- `Response intercept(Interceptor.Chain chain)`  L39 @Override
    - 体内字面量："chain"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiParser`
L22 · [class] public final Ride5CgiParser · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiParser.java`
注解：

字段/常量（9）：
- `String str`  L27
- `MatchResult matchResultFind$default`  L28
- `LinkedHashMap linkedHashMap2 = linkedHashMap`  L51
- `String str = string`  L67
- `ArrayList arrayList3 = arrayList2`  L87
- `String str = value`  L101
- `boolean z = false`  L102
- `String str = strRemovePrefix`  L127
- `ArrayList arrayList2 = arrayList`  L157

方法（6）：
- `Ride5CgiPayload parse(String body)`  L26
- `Ride5CgiPayload parseReset(String body)`  L56
    - 体内字面量："body" · "success" · "true"
- `Ride5CgiPayload parseFileList(String body)`  L64
    - 体内字面量："body"
- `String unescape(String value)`  L99
- `boolean isConfirmedFileListPath(String raw)`  L122
    - 体内字面量："/" · "sd//"
- `Ride5CgiPayload requireFields(Ride5CgiPayload payload, String... names)`  L147
    - 体内字面量："payload" · "names"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CgiPayload`
L11 · [class] public final Ride5CgiPayload · `com/tuwinsmart/tuwin/core/device/ride5/Ride5CgiPayload.java`
注解：

字段/常量（2）：
- `int bodyLength`  L12
- `Map<String, String> fields`  L13

方法（10）：
- `Ride5CgiPayload copy$default(Ride5CgiPayload ride5CgiPayload, Map map, int i, int i2, Object obj)`  L16
- `Map<String, String> component1()`  L26
- `int getBodyLength()`  L31
- `Ride5CgiPayload copy(Map<String, String> fields, int bodyLength)`  L35
    - 体内字面量："fields"
- `boolean equals(Object other)`  L40
- `int hashCode()`  L51
- `String toString()`  L55
    - 体内字面量："Ride5CgiPayload(fields=" · ", bodyLength=" · ")"
- `public Ride5CgiPayload(Map<String, String> fields, int i)`  L59
    - 体内字面量："fields"
- `Map<String, String> getFields()`  L65
- `int getBodyLength()`  L69
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5ConnectedSession`
L15 · [class] public final Ride5ConnectedSession · `com/tuwinsmart/tuwin/core/device/ride5/Ride5ConnectedSession.java`
注解：

字段/常量（9）：
- `String apBssid`  L16
- `Map<String, String> attributes`  L17
- `RouteSnapshot route`  L18
- `String sessionId`  L19
- `DeviceSessionSnapshot snapshot`  L20
- `RouteSnapshot routeSnapshot2 = routeSnapshot`  L30
- `DeviceSessionSnapshot deviceSessionSnapshot2 = deviceSessionSnapshot`  L34
- `Map map2 = map`  L38
- `String str = this.apBssid`  L90

方法（17）：
- `Ride5ConnectedSession copy$default(Ride5ConnectedSession ride5ConnectedSession, String str, RouteSnapshot routeSnapshot, DeviceSessionSnapshot deviceSessionSnapshot, Map map, String str2, int i, Object obj)`  L23
- `String getSessionId()`  L46
- `RouteSnapshot getRoute()`  L51
- `DeviceSessionSnapshot getSnapshot()`  L56
- `Map<String, String> component4()`  L60
- `String getApBssid()`  L65
- `Ride5ConnectedSession copy(String sessionId, RouteSnapshot route, DeviceSessionSnapshot snapshot, Map<String, String> attributes, String apBssid)`  L69
    - 体内字面量："sessionId" · "route" · "snapshot" · "attributes"
- `boolean equals(Object other)`  L77
- `int hashCode()`  L88
- `String toString()`  L94
    - 体内字面量："Ride5ConnectedSession(sessionId=" · ", route=" · ", snapshot=" · ", attributes=" · ", apBssid=" · ")"
- `public Ride5ConnectedSession(String sessionId, RouteSnapshot route, DeviceSessionSnapshot snapshot, Map<String, String> attributes, String str)`  L98
    - 体内字面量："sessionId" · "route" · "snapshot" · "attributes"
- `String getSessionId()`  L110
- `RouteSnapshot getRoute()`  L114
- `DeviceSessionSnapshot getSnapshot()`  L118
- ` Ride5ConnectedSession(String str, RouteSnapshot routeSnapshot, DeviceSessionSnapshot deviceSessionSnapshot, Map map, String str2, int i, DefaultConstructorMarker defaultConstructorMarker)`  L122
- `Map<String, String> getAttributes()`  L126
- `String getApBssid()`  L130
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5DeviceAdapter`
L39 · [class] public final Ride5DeviceAdapter · implements `DeviceAdapter` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapter.java`
注解：

字段/常量（12）：
- `Ride5CallbackDecoder callbackDecoder`  L40
- `Ride5CallbackServerSocketFactory callbackSocketFactory`  L41
- `Function1<String, RouteSnapshot> currentRoute`  L42
- `DeviceType deviceType`  L43
- `DeviceEndpointAuthority endpointAuthority`  L44
- `CoroutineScope parentScope`  L45
- `RoutedRetrofitProvider retrofitProvider`  L46
- `RouteProvider routeProvider`  L47
- `Ride5SessionRegistry sessionRegistry`  L48
- `ConcurrentHashMap<String, Ride5DeviceAdapterSession> sessions`  L49
- `InetSocketAddress inetSocketAddress`  L83
- `String str = bindAddress`  L86

方法（17）：
- `public Ride5DeviceAdapter(RouteProvider routeProvider, RoutedRetrofitProvider retrofitProvider, DeviceEndpointAuthority endpointAuthority, Function1<? super String, RouteSnapshot> currentRoute, Ride5CallbackServerSocketFactory callbackSocketFactory, Ride5CallbackDecoder callbackDecoder, Ride5SessionRegistry sessionRegistry, CoroutineScope parentScope)`  L52
    - 体内字面量："routeProvider" · "retrofitProvider" · "endpointAuthority" · "currentRoute" · "callbackSocketFactory" · "callbackDecoder" · "sessionRegistry" · "parentScope"
- ` Ride5DeviceAdapter(RouteProvider routeProvider, RoutedRetrofitProvider routedRetrofitProvider, DeviceEndpointAuthority deviceEndpointAuthority, Function1 function1, Ride5CallbackServerSocketFactory ride5CallbackServerSocketFactory, Ride5CallbackDecoder ride5CallbackDecoder, Ride5SessionRegistry ride5SessionRegistry, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker)`  L73
- `Void invoke(String it)`  L76 @Override
    - 体内字面量："it"
- `Ride5CallbackServerSocket open(int port, String bindAddress)`  L82 @Override
- `int getLocalPort()`  L95 @Override
- `Ride5CallbackSocket accept()`  L100 @Override
- `String getRemoteHost()`  L104 @Override
- `InputStream getInput()`  L110 @Override
    - 体内字面量："getInputStream(...)"
- `void setReadTimeout(int timeoutMillis)`  L117 @Override
- `void close()`  L122 @Override
- `void close()`  L129 @Override
- `DeviceType getDeviceType()`  L138 @Override
- `DeviceAdapterSession createSession(final DeviceSessionSnapshot session)`  L143 @Override
    - 体内字面量："session" · "Failed requirement."
- `RouteSnapshot invoke()`  L156 @Override
- `void invoke2()`  L167
- `Unit invoke()`  L172 @Override
- `Set<String> activeSessionIds()`  L181
    - 体内字面量："<get-keys>(...)"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5DeviceAdapterSession`
L50 · [class] public final Ride5DeviceAdapterSession · implements `DeviceAdapterSession` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java`
注解：

字段/常量（68）：
- `int CALLBACK_PORT = 9002`  L53 @Deprecated
- `int RTSP_LIVE_PORT = 554`  L57 @Deprecated
- `Ride5CallbackChannel callbackChannel`  L58
- `Ride5CallbackDecoder callbackDecoder`  L59
- `EndpointGrant callbackGrant`  L60
- `Ride5CallbackServerSocketFactory callbackSocketFactory`  L61
- `Function0<RouteSnapshot> currentRoute`  L62
- `DeviceEndpointAuthority endpointAuthority`  L63
- `Ride5CgiGateway gateway`  L64
- `EndpointGrant mediaGrant`  L65
- `Function0<Unit> onClosed`  L66
- `CoroutineScope parentScope`  L67
- `RoutedRetrofitProvider retrofitProvider`  L68
- `RouteProvider routeProvider`  L69
- `DeviceSessionSnapshot session`  L70
- `Ride5SessionPort sessionPort`  L71
- `Ride5SessionRegistry sessionRegistry`  L72
- `C20281 c20281`  L175
- `CancellationException cancellationException`  L176
- `Ride5DeviceAdapterSession ride5DeviceAdapterSession`  L177
- `Object obj`  L178
- `Throwable th`  L179
- `RouteSnapshot route`  L180
- `EndpointGrant controlEndpointGrant`  L181
- `String string`  L182
- `EndpointGrant endpointGrantIssue$default`  L183
- `EndpointGrant endpointGrantIssue$default2`  L184
- `Ride5CallbackChannel ride5CallbackChannel`  L185
- `String str`  L186
- `Ride5CgiGateway ride5CgiGateway`  L187
- `Ride5DeviceAdapterSession ride5DeviceAdapterSession2`  L188
- `EndpointGrant endpointGrant`  L189
- `EndpointGrant endpointGrant2`  L190
- `EndpointGrant endpointGrant3`  L191
- `Ride5CgiGateway ride5CgiGateway2`  L192
- `RouteSnapshot routeSnapshot`  L193
- `String str2`  L194
- `String str3`  L195
- `String str4 = "product"`  L196
- `Object deviceAttributes = c20281.result`  L207
- `int i = c20281.label`  L209
- `EndpointGrant endpointGrant4 = controlEndpointGrant`  L289
- `RouteSnapshot routeSnapshot2 = route`  L292
- `EndpointGrant endpointGrant5 = controlEndpointGrant`  L389
- `RouteSnapshot routeSnapshot3 = route`  L392
- `EndpointGrant endpointGrant9 = endpointGrant2`  L529
- `Ride5DeviceAdapterSession ride5DeviceAdapterSession4 = ride5DeviceAdapterSession`  L530
- `EndpointGrant endpointGrant10 = endpointGrant3`  L531
- `String str5 = str4`  L534
- `DeviceType deviceType = DeviceType.RIDE5`  L538
- `Ride5CgiGateway ride5CgiGateway = this.gateway`  L718
- `Ride5CallbackChannel ride5CallbackChannel = this.callbackChannel`  L722
- `C20261 c20261`  L738
- `String string`  L739
- `Ride5DeviceAdapterSession ride5DeviceAdapterSession`  L740
- `Ride5CallbackChannel ride5CallbackChannel`  L741
- `Ride5DeviceAdapterSession ride5DeviceAdapterSession2`  L742
- `Ride5CgiGateway ride5CgiGateway`  L743
- `EndpointGrant endpointGrant`  L744
- `EndpointGrant endpointGrant2`  L745
- `Object objUnregisterCallback = c20261.result`  L756
- `int i = c20261.label`  L758
- `Ride5SessionPort ride5SessionPort = this.sessionPort`  L761
- `Ride5CgiGateway ride5CgiGateway2 = this.gateway`  L766
- `Result.Companion companion = Result.INSTANCE`  L775
- `Ride5DeviceAdapterSession ride5DeviceAdapterSession3 = this`  L776
- `Result.Companion companion2 = Result.INSTANCE`  L787
- `Result.Companion companion3 = Result.INSTANCE`  L826

方法（10）：
- `public Ride5DeviceAdapterSession(DeviceSessionSnapshot session, RouteProvider routeProvider, RoutedRetrofitProvider retrofitProvider, DeviceEndpointAuthority endpointAuthority, Function0<RouteSnapshot> currentRoute, Ride5CallbackServerSocketFactory callbackSocketFactory, Ride5CallbackDecoder callbackDecoder, Ride5SessionRegistry sessionRegistry, CoroutineScope parentScope, Function0<Unit> onClosed)`  L123
    - 体内字面量："session" · "routeProvider" · "retrofitProvider" · "endpointAuthority" · "currentRoute" · "callbackSocketFactory" · "callbackDecoder" · "sessionRegistry" · "parentScope" · "onClosed"
- `DeviceSessionSnapshot getSession()`  L147 @Override
- ` Ride5DeviceAdapterSession(DeviceSessionSnapshot deviceSessionSnapshot, RouteProvider routeProvider, RoutedRetrofitProvider routedRetrofitProvider, DeviceEndpointAuthority deviceEndpointAuthority, Function0 function0, Ride5CallbackServerSocketFactory ride5CallbackServerSocketFactory, Ride5CallbackDecoder ride5CallbackDecoder, Ride5SessionRegistry ride5SessionRegistry, CoroutineScope coroutineScope, Function0 function1, int i, DefaultConstructorMarker defaultConstructorMarker)`  L151
- `void invoke2()`  L154
- `Unit invoke()`  L158 @Override
- `Object open(Continuation<? super DeviceAdapterOpenResult> continuation)`  L174 @Override
- `String invoke()`  L242 @Override
    - 体内字面量："/" · "/livestream"
- `Object collect(FlowCollector<? super DeviceAdapterEvent> flowCollector, Continuation continuation2)`  L667 @Override
- `void invalidateForRoute(long newRouteRevision)`  L715 @Override
- `Object close(Continuation<? super Unit> continuation)`  L737 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5DeviceAdapterSession$C20261`
L78 · [class] static final C20261 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java`
注解：

字段/常量（3）：
- `Object L$0`  L79
- `int label`  L80
- `Object result`  L81

方法（1）：
- `Object invokeSuspend(Object obj)`  L88 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5DeviceAdapterSession$C20272`
L581 · [class] public static final C20272 · implements `FlowCollector` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java`
注解：

字段/常量（6）：
- `FlowCollector $this_unsafeFlow`  L582
- `AnonymousClass1 anonymousClass1`  L623
- `Object obj2`  L624
- `Object obj3 = anonymousClass1.result`  L635
- `int i = anonymousClass1.label`  L637
- `FlowCollector flowCollector = this.$this_unsafeFlow`  L640

方法（2）：
- `public C20272(FlowCollector flowCollector)`  L605
- `Object emit(Object obj, Continuation continuation)`  L622 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5DeviceAdapterSession$C20272$AnonymousClass1`
L588 · [class] public static final AnonymousClass1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java`
注解：

字段/常量（3）：
- `Object L$0`  L589
- `int label`  L590
- `Object result`  L591

方法（2）：
- `public AnonymousClass1(Continuation continuation)`  L593
- `Object invokeSuspend(Object obj)`  L598 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5DeviceAdapterSession$C20281`
L99 · [class] static final C20281 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java`
注解：

字段/常量（10）：
- `Object L$0`  L100
- `Object L$1`  L101
- `Object L$2`  L102
- `Object L$3`  L103
- `Object L$4`  L104
- `Object L$5`  L105
- `Object L$6`  L106
- `Object L$7`  L107
- `int label`  L108
- `Object result`  L109

方法（1）：
- `Object invokeSuspend(Object obj)`  L116 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5DeviceAdapterSession$Companion`
L888 · [class] private static final Companion · `com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceAdapterSession.java`
注解：

方法（2）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L889
- `private Companion()`  L893
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5DeviceMediaPort`
L37 · [class] public final Ride5DeviceMediaPort · implements `DeviceMediaPort` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5DeviceMediaPort.java`
注解：

字段/常量（7）：
- `VerifiedDeviceFileCatalog fileCatalog`  L38
- `DeviceSessionManager sessions`  L39
- `String string`  L50
- `Object objM3074constructorimpl`  L71
- `Result.Companion companion = Result.INSTANCE`  L73
- `Ride5DeviceMediaPort ride5DeviceMediaPort = this`  L74
- `Result.Companion companion2 = Result.INSTANCE`  L77

方法（3）：
- `public Ride5DeviceMediaPort(VerifiedDeviceFileCatalog fileCatalog, DeviceSessionManager sessions)`  L41
    - 体内字面量："fileCatalog" · "sessions"
- `Object requestMediaEndpoint(MediaSessionRequest mediaSessionRequest, RouteLease routeLease, Continuation<? super DeviceMediaEndpoint> continuation)`  L49 @Override
- `DeviceMediaEndpoint livePreviewEndpoint(MediaSessionRequest request, RouteLease lease)`  L70
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5FilePort`
L12 · [interface] public Ride5FilePort · `com/tuwinsmart/tuwin/core/device/ride5/Ride5FilePort.java`
注解：

方法（5）：
- `Object deleteFile(String str, Continuation<? super Ride5CgiPayload> continuation)`  L13
- `Object directoryCapability(Continuation<? super Ride5CgiPayload> continuation)`  L15
- `Object fileCount(String str, Continuation<? super Ride5CgiPayload> continuation)`  L17
- `Object fileInfo(String str, Continuation<? super Ride5CgiPayload> continuation)`  L19
- `Object fileList(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L21
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5GatewayFilePort`
L13 · [class] public final Ride5GatewayFilePort · implements `Ride5FilePort` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5GatewayFilePort.java`
注解：

字段/常量（1）：
- `Ride5CgiGateway gateway`  L14

方法（6）：
- `public Ride5GatewayFilePort(Ride5CgiGateway gateway)`  L16
    - 体内字面量："gateway"
- `Object directoryCapability(Continuation<? super Ride5CgiPayload> continuation)`  L22 @Override
- `Object fileCount(String str, Continuation<? super Ride5CgiPayload> continuation)`  L27 @Override
- `Object fileList(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L32 @Override
- `Object fileInfo(String str, Continuation<? super Ride5CgiPayload> continuation)`  L37 @Override
- `Object deleteFile(String str, Continuation<? super Ride5CgiPayload> continuation)`  L42 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5GatewayMediaPort`
L11 · [class] public final Ride5GatewayMediaPort · implements `Ride5MediaPort` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5GatewayMediaPort.java`
注解：

字段/常量（1）：
- `Ride5CgiGateway gateway`  L12

方法（4）：
- `public Ride5GatewayMediaPort(Ride5CgiGateway gateway)`  L14
    - 体内字面量："gateway"
- `Object workState(Continuation<? super Ride5CgiPayload> continuation)`  L20 @Override
- `Object command(String str, Continuation<? super Ride5CgiPayload> continuation)`  L25 @Override
- `Object switchCamera(String str, Continuation<? super Ride5CgiPayload> continuation)`  L30 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5GatewayOtaUploader`
L12 · [class] public final Ride5GatewayOtaUploader · implements `Ride5OtaUploader` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5GatewayOtaUploader.java`
注解：

字段/常量（1）：
- `Ride5CgiGateway gateway`  L13

方法（2）：
- `public Ride5GatewayOtaUploader(Ride5CgiGateway gateway)`  L15
    - 体内字面量："gateway"
- `Object checkPacket(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L21 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5GatewaySessionPort`
L15 · [class] public final Ride5GatewaySessionPort · implements `Ride5SessionPort` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5GatewaySessionPort.java`
注解：

字段/常量（1）：
- `Ride5CgiGateway gateway`  L16

方法（26）：
- `public Ride5GatewaySessionPort(Ride5CgiGateway gateway)`  L18
    - 体内字面量："gateway"
- `Object ensureRecordingStopped(Continuation<? super Ride5CgiPayload> continuation)`  L24 @Override
- `Object workState(Continuation<? super Ride5CgiPayload> continuation)`  L29 @Override
- `Object command(String str, Continuation<? super Ride5CgiPayload> continuation)`  L34 @Override
- `Object switchCamera(String str, Continuation<? super Ride5CgiPayload> continuation)`  L39 @Override
- `Object directoryCapability(Continuation<? super Ride5CgiPayload> continuation)`  L44 @Override
- `Object fileCount(String str, Continuation<? super Ride5CgiPayload> continuation)`  L49 @Override
- `Object fileList(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L54 @Override
- `Object fileInfo(String str, Continuation<? super Ride5CgiPayload> continuation)`  L59 @Override
- `Object deleteFile(String str, Continuation<? super Ride5CgiPayload> continuation)`  L64 @Override
- `Object checkPacket(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L69 @Override
- `Object deviceAttributes(Continuation<? super Ride5CgiPayload> continuation)`  L74 @Override
- `Object sdStatus(Continuation<? super Ride5CgiPayload> continuation)`  L79 @Override
- `Object formatSdCard(Continuation<? super Ride5CgiPayload> continuation)`  L84 @Override
- `Object setSystemTime(String str, Continuation<? super Ride5CgiPayload> continuation)`  L89 @Override
- `Object cameraNumber(Continuation<? super Ride5CgiPayload> continuation)`  L94 @Override
- `Object batteryCapacity(Continuation<? super Ride5CgiPayload> continuation)`  L99 @Override
- `Object commonParameter(String str, Continuation<? super Ride5CgiPayload> continuation)`  L104 @Override
- `Object commonParameterCapability(String str, Continuation<? super Ride5CgiPayload> continuation)`  L109 @Override
- `Object setCommonParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L114 @Override
- `Object cameraParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L119 @Override
- `Object cameraParameterCapability(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L124 @Override
- `Object setCameraParameter(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L129 @Override
- `Object wifi(Continuation<? super Ride5CgiPayload> continuation)`  L134 @Override
- `Object setWifi(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L139 @Override
- `Object resetDevice(Continuation<? super Ride5CgiPayload> continuation)`  L144 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5IdentityPolicy`
L18 · [class] public final Ride5IdentityPolicy · `com/tuwinsmart/tuwin/core/device/ride5/Ride5IdentityPolicy.java`
注解：

字段/常量（13）：
- `String devid`  L25
- `String strDeviceIdFromBssid`  L26
- `String string`  L37
- `String strReplace$default`  L38
- `String strReplace$default2`  L39
- `Locale US = Locale.US`  L43
- `String upperCase`  L54
- `String upperCase2`  L55
- `String string`  L56
- `String string2`  L57
- `Locale US = Locale.US`  L61
- `Locale US2 = Locale.US`  L69
- `String str2 = str`  L76

方法（4）：
- `private Ride5IdentityPolicy()`  L21
- `boolean canUpgradeDeviceId(ConnectedDevice cached, ConnectedDevice incoming)`  L24
- `String deviceIdFromBssid(String bssid)`  L36
- `boolean accepts(String model, String product)`  L53
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5LegacyIdleDecoder`
L15 · [class] public final Ride5LegacyIdleDecoder · implements `Ride5CallbackDecoder` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5LegacyIdleDecoder.java`
注解：

字段/常量（2）：
- `int i`  L18
- `int i2 = 0`  L26

方法（1）：
- `void decode(Ride5CallbackSocket socket, Ride5CallbackLimits limits, Function0<Boolean> isActive, Ride5CallbackBufferBudget bufferBudget, Function1<? super byte[], Unit> emit)`  L17 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5MediaPort`
L10 · [interface] public Ride5MediaPort · `com/tuwinsmart/tuwin/core/device/ride5/Ride5MediaPort.java`
注解：

方法（3）：
- `Object command(String str, Continuation<? super Ride5CgiPayload> continuation)`  L11
- `Object switchCamera(String str, Continuation<? super Ride5CgiPayload> continuation)`  L13
- `Object workState(Continuation<? super Ride5CgiPayload> continuation)`  L15
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5OtaUploader`
L11 · [interface] public Ride5OtaUploader · `com/tuwinsmart/tuwin/core/device/ride5/Ride5OtaUploader.java`
注解：

方法（1）：
- `Object checkPacket(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L12
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionConnector`
L59 · [class] public final Ride5SessionConnector · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionConnector.java`
注解：

字段/常量（153）：
- `Function1<Network, String> bssidProvider`  L60
- `DeviceEndpointAuthority endpointAuthority`  L61
- `DeviceIdentityVerifier identityVerifier`  L62
- `ProcessBindingController processBindingController`  L63
- `RoutedRetrofitProvider retrofitProvider`  L64
- `RouteProvider routeProvider`  L65
- `DeviceRouteRegistry routes`  L66
- `DeviceSessionManager sessionManager`  L67
- `NetworkTopologyMonitor topology`  L68
- `Ride5SessionConnector$connectUserInitiated$1 ride5SessionConnector$connectUserInitiated$1`  L322
- `?? r10`  L323
- `?? r5`  L324
- `?? r4`  L325
- `?? r6`  L326
- `EndpointGrant endpointGrant`  L327
- `Network networkCurrentWifiNetwork`  L328
- `ObservedNetwork observedNetworkEnsureObserved`  L329
- `LinkProperties linkProperties`  L330
- `String string`  L331
- `String str3`  L332
- `long networkHandle`  L333
- `Lazy lazy`  L334
- `LinkProperties linkProperties2`  L335
- `Lazy lazy2`  L336
- `boolean z2`  L337
- `Ride5SessionConnector ride5SessionConnector`  L338
- `String str4`  L339
- `String str5`  L340
- `long j`  L341
- `ObservedNetwork observedNetwork`  L342
- `String str6`  L343
- `String str7`  L344
- `Ride5SessionConnector ride5SessionConnector2`  L345
- `Ref.ObjectRef objectRef`  L346
- `Ref.ObjectRef objectRef2`  L347
- `Ref.ObjectRef objectRef3`  L348
- `Ride5SessionConnector ride5SessionConnector3`  L349
- `Ref.ObjectRef objectRef4`  L350
- `TemporaryProbeBindingLease temporaryProbeBindingLease`  L351
- `?? r9`  L352
- `ProbePermit probePermit`  L353
- `String str8`  L354
- `Lazy lazy3`  L355
- `Throwable th`  L356
- `?? r7`  L357
- `?? r11`  L358
- `RouteSnapshot routeSnapshotCandidateRouteFor`  L359
- `TemporaryProbeBindingLease temporaryProbeBindingLeaseAcquire`  L360
- `Ref.ObjectRef objectRef5`  L361
- `TemporaryProbeBindingLease temporaryProbeBindingLease2`  L362
- `String str9`  L363
- `TemporaryProbeBindingLease temporaryProbeBindingLease3`  L364
- `LinkProperties linkProperties3`  L365
- `Object objVerify`  L366
- `String str10`  L367
- `LinkProperties linkProperties4`  L368
- `String str11`  L369
- `Lazy lazy4`  L370
- `Ref.ObjectRef objectRef6`  L371
- `?? r8`  L372
- `?? r12`  L373
- `?? r13`  L374
- `Object obj`  L375
- `?? r14`  L376
- `?? r15`  L377
- `?? r16`  L378
- `DeviceProbeResult deviceProbeResult`  L379
- `DeviceEndpointEvidence endpoint`  L380
- `?? r17`  L381
- `Lazy lazy5`  L382
- `Ref.ObjectRef objectRef7`  L383
- `VerifiedDeviceRoute verifiedDeviceRoute`  L384
- `Object value`  L385
- `?? r18`  L386
- `?? r19`  L387
- `?? r3`  L388
- `Throwable thM3077exceptionOrNullimpl`  L389
- `?? r0`  L390
- `Throwable th2`  L391
- `Object objM3074constructorimpl`  L392
- `EndpointGrant endpointGrant2`  L393
- `DeviceEndpointAuthority deviceEndpointAuthority`  L394
- `?? r1`  L395
- `?? r20`  L396
- `?? r21`  L397
- `?? r22`  L398
- `EndpointGrant endpointGrant3`  L399
- `?? r23`  L400
- `?? r24`  L401
- `?? r25`  L402
- `?? r26`  L403
- `Object obj2`  L404
- `Object obj3 = "probe-"`  L405
- `Object obj4 = ride5SessionConnector$connectUserInitiated$1.result`  L416
- `?? r27 = ride5SessionConnector$connectUserInitiated$1.label`  L418
- `?? r28 = 4`  L419
- `?? r29 = 3`  L420
- `Result.Companion companion = Result.INSTANCE`  L427
- `Result.Companion companion2 = Result.INSTANCE`  L435
- `Result.Companion companion3 = Result.INSTANCE`  L439
- `Result.Companion companion4 = Result.INSTANCE`  L444
- `Result.Companion companion5 = Result.INSTANCE`  L479
- `Result.Companion companion6 = Result.INSTANCE`  L489
- `Result.Companion companion7 = Result.INSTANCE`  L496
- `Result.Companion companion8 = Result.INSTANCE`  L574
- `Result.Companion companion9 = Result.INSTANCE`  L600
- `Unit unit = Unit.INSTANCE`  L604
- `DeviceIdentityVerifier deviceIdentityVerifier = ride5SessionConnector.identityVerifier`  L614
- `?? r30 = r13.endpointAuthority`  L653
- `Result.Companion companion10 = Result.INSTANCE`  L702
- `Result.Companion companion11 = Result.INSTANCE`  L728
- `Unit unit2 = Unit.INSTANCE`  L732
- `Unit unit3 = Unit.INSTANCE`  L738
- `Result.Companion companion12 = Result.INSTANCE`  L796
- `Unit unit4 = Unit.INSTANCE`  L800
- `Unit unit5 = Unit.INSTANCE`  L806
- `Result.Companion companion13 = Result.INSTANCE`  L826
- `Unit unit6 = Unit.INSTANCE`  L830
- `Unit unit7 = Unit.INSTANCE`  L835
- `Result.Companion companion14 = Result.INSTANCE`  L849
- `Result.Companion companion15 = Result.INSTANCE`  L875
- `Unit unit8 = Unit.INSTANCE`  L879
- `Unit unit9 = Unit.INSTANCE`  L902
- `Unit unit10 = Unit.INSTANCE`  L907
- `Result.Companion companion16 = Result.INSTANCE`  L946
- `Unit unit11 = Unit.INSTANCE`  L956
- `Unit unit12 = Unit.INSTANCE`  L961
- `Result.Companion companion17 = Result.INSTANCE`  L967
- `Unit unit13 = Unit.INSTANCE`  L971
- `Unit unit14 = Unit.INSTANCE`  L977
- `Result.Companion companion18 = Result.INSTANCE`  L991
- `Unit unit15 = Unit.INSTANCE`  L995
- `Unit unit16 = Unit.INSTANCE`  L1000
- `?? r31 = r13.endpointAuthority`  L1044
- `?? r32 = r13.sessionManager`  L1052
- `Result.Companion companion19 = Result.INSTANCE`  L1079
- `Unit unit17 = Unit.INSTANCE`  L1083
- `Unit unit18 = Unit.INSTANCE`  L1089
- `Result.Companion companion110 = Result.INSTANCE`  L1109
- `Unit unit19 = Unit.INSTANCE`  L1113
- `Unit unit110 = Unit.INSTANCE`  L1118
- `Result.Companion companion111 = Result.INSTANCE`  L1145
- `Result.Companion companion112 = Result.INSTANCE`  L1171
- `Unit unit111 = Unit.INSTANCE`  L1175
- `Unit unit112 = Unit.INSTANCE`  L1181
- `Result.Companion companion113 = Result.INSTANCE`  L1187
- `long j2 = ride5SessionConnector$connectUserInitiated$1.J$0`  L1195
- `Result.Companion companion20 = Result.INSTANCE`  L1209
- `ObservedNetwork observedNetwork2 = observedNetworkEnsureObserved`  L1215
- `long j3 = networkHandle`  L1218
- `DeviceIdentityVerifier deviceIdentityVerifier2 = ride5SessionConnector.identityVerifier`  L1239
- `?? r33 = r13.endpointAuthority`  L1275
- `String str4 = str2`  L1295

方法（12）：
- `public Ride5SessionConnector(NetworkTopologyMonitor topology, DeviceRouteRegistry routes, RouteProvider routeProvider, RoutedRetrofitProvider retrofitProvider, DeviceEndpointAuthority endpointAuthority, DeviceSessionManager sessionManager, ProcessBindingController processBindingController, DeviceIdentityVerifier identityVerifier, Function1<? super Network, String> bssidProvider)`  L96
    - 体内字面量："topology" · "routes" · "routeProvider" · "retrofitProvider" · "endpointAuthority" · "sessionManager" · "processBindingController" · "identityVerifier" · "bssidProvider"
- ` Ride5SessionConnector(NetworkTopologyMonitor networkTopologyMonitor, DeviceRouteRegistry deviceRouteRegistry, RouteProvider routeProvider, RoutedRetrofitProvider routedRetrofitProvider, DeviceEndpointAuthority deviceEndpointAuthority, DeviceSessionManager deviceSessionManager, ProcessBindingController processBindingController, DeviceIdentityVerifier deviceIdentityVerifier, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker)`  L117
- `Void invoke(Network it)`  L120 @Override
    - 体内字面量："it"
- `Object m2727connectUserInitiatedyxL6bBk(Network network, String str, String str2, boolean z, Continuation<? super Result<Ride5ConnectedSession>> continuation)`  L321
- `InetAddress invoke(LinkAddress linkAddress)`  L451 @Override
- `Boolean invoke(Object obj5)`  L457 @Override
    - 体内字面量："null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>"
- `Boolean invoke(Inet4Address it)`  L464 @Override
    - 体内字面量："it"
- `String invoke(Inet4Address it)`  L470 @Override
    - 体内字面量："it"
- `String invoke()`  L507 @Override
    - 体内字面量："probe-" · "RIDE5 candidate route disappeared"
- `Object m2726connectUserInitiatedyxL6bBk$default(Ride5SessionConnector ride5SessionConnector, Network network, String str, String str2, boolean z, Continuation continuation, int i, Object obj)`  L1289
    - 体内字面量："ride5-"
- `String connectUserInitiated_yxL6bBk$lambda$1(Lazy<String> lazy)`  L1303
- `java.lang.Object takeoverSameDeviceSessions(long r10, java.lang.String r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13)`  L1320
    - 体内字面量："Method not decompiled: com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionConnector.takeoverSameDeviceSessions(long, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionConnector$C20311`
L74 · [class] static final C20311 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionConnector.java`
注解：

字段/常量（7）：
- `long J$0`  L75
- `Object L$0`  L76
- `Object L$1`  L77
- `Object L$2`  L78
- `Object L$3`  L79
- `int label`  L80
- `Object result`  L81

方法（1）：
- `Object invokeSuspend(Object obj)`  L88 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionConnector$connectUserInitiated$1`
L15 · [class] final Ride5SessionConnector$connectUserInitiated$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionConnector$connectUserInitiated$1.java`
注解：

字段/常量（15）：
- `long J$0`  L16
- `Object L$0`  L17
- `Object L$1`  L18
- `Object L$2`  L19
- `Object L$3`  L20
- `Object L$4`  L21
- `Object L$5`  L22
- `Object L$6`  L23
- `Object L$7`  L24
- `Object L$8`  L25
- `Object L$9`  L26
- `boolean Z$0`  L27
- `int label`  L28
- `Object result`  L29
- `Ride5SessionConnector this$0`  L30

方法（1）：
- `Object invokeSuspend(Object obj)`  L39 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionConnector$connectUserInitiated$verified$1`
L40 · [class] final Ride5SessionConnector$connectUserInitiated$verified$1 · implements `DeviceProbeExecutor` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionConnector$connectUserInitiated$verified$1.java`
注解：

字段/常量（24）：
- `String $deviceHost`  L41
- `LinkProperties $linkProperties`  L42
- `Ref.ObjectRef<Map<String, String>> $probeAttributes`  L43
- `Ref.ObjectRef<EndpointGrant> $probeGrant`  L44
- `Ref.ObjectRef<DeviceProbeResult> $probeResult`  L45
- `Lazy<String> $selectedBssid$delegate`  L46
- `String $sessionId`  L47
- `Ride5SessionConnector this$0`  L48
- `Ride5SessionConnector$connectUserInitiated$verified$1$probe$1 ride5SessionConnector$connectUserInitiated$verified$1$probe$1`  L67
- `Ride5SessionConnector$connectUserInitiated$verified$1 ride5SessionConnector$connectUserInitiated$verified$1`  L68
- `Object deviceAttributes = ride5SessionConnector$connectUserInitiated$verified$1$probe$1.result`  L79
- `int i = ride5SessionConnector$connectUserInitiated$verified$1$probe$1.label`  L81
- `String str = this.$sessionId`  L90
- `RouteProvider routeProvider = this.this$0.routeProvider`  L91
- `RoutedRetrofitProvider routedRetrofitProvider = this.this$0.retrofitProvider`  L92
- `DeviceEndpointAuthority deviceEndpointAuthority = this.this$0.endpointAuthority`  L93
- `HttpClientProfile httpClientProfile = HttpClientProfile.DEVICE_PROBE`  L94
- `EndpointPurpose endpointPurpose = EndpointPurpose.PROBE`  L95
- `DeviceOperationKind deviceOperationKind = DeviceOperationKind.PROBE`  L96
- `Ride5SessionConnector ride5SessionConnector = this.this$0`  L97
- `String str2 = this.$sessionId`  L98
- `Lazy<String> lazy = this.$selectedBssid$delegate`  L111
- `DeviceType deviceType = DeviceType.RIDE5`  L142
- `String str4 = str3`  L147

方法（3）：
- `Object probe(ProbePermit probePermit, Network network, DeviceProtocolProfile deviceProtocolProfile, Continuation<? super DeviceProbeResult> continuation)`  L66 @Override
- `RouteSnapshot invoke()`  L107 @Override
- `String invoke()`  L119 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine" · "model" · "product" · "RIDE5 identity marker is not recognized"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionConnector$connectUserInitiated$verified$1$probe$1`
L14 · [class] final Ride5SessionConnector$connectUserInitiated$verified$1$probe$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionConnector$connectUserInitiated$verified$1$probe$1.java`
注解：

字段/常量（4）：
- `Object L$0`  L15
- `int label`  L16
- `Object result`  L17
- `Ride5SessionConnector$connectUserInitiated$verified$1 this$0`  L18

方法（1）：
- `Object invokeSuspend(Object obj)`  L27 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionPort`
L12 · [interface] public Ride5SessionPort · extends `Ride5MediaPort, Ride5FilePort, Ride5OtaUploader` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionPort.java`
注解：

方法（16）：
- `Object batteryCapacity(Continuation<? super Ride5CgiPayload> continuation)`  L13
- `Object cameraNumber(Continuation<? super Ride5CgiPayload> continuation)`  L15
- `Object cameraParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L17
- `Object cameraParameterCapability(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L19
- `Object commonParameter(String str, Continuation<? super Ride5CgiPayload> continuation)`  L21
- `Object commonParameterCapability(String str, Continuation<? super Ride5CgiPayload> continuation)`  L23
- `Object deviceAttributes(Continuation<? super Ride5CgiPayload> continuation)`  L25
- `Object ensureRecordingStopped(Continuation<? super Ride5CgiPayload> continuation)`  L27
- `Object formatSdCard(Continuation<? super Ride5CgiPayload> continuation)`  L29
- `Object resetDevice(Continuation<? super Ride5CgiPayload> continuation)`  L31
- `Object sdStatus(Continuation<? super Ride5CgiPayload> continuation)`  L33
- `Object setCameraParameter(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L35
- `Object setCommonParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L37
- `Object setSystemTime(String str, Continuation<? super Ride5CgiPayload> continuation)`  L39
- `Object setWifi(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L41
- `Object wifi(Continuation<? super Ride5CgiPayload> continuation)`  L43
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionPort$DefaultImpls`
L47 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionPort.java`
注解：

方法（1）：
- `Object ensureRecordingStopped(Ride5SessionPort ride5SessionPort, Continuation<? super Ride5CgiPayload> continuation)`  L48
    - 体内字面量："stop"
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionPortHandle`
L14 · [class] public final Ride5SessionPortHandle · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionPortHandle.java`
注解：

字段/常量（6）：
- `Ride5SessionPort port`  L15
- `Mutex recordingCommandMutex`  L16
- `long routeRevision`  L17
- `String sessionId`  L18
- `long j2 = j`  L27
- `Ride5SessionPort ride5SessionPort2 = ride5SessionPort`  L31

方法（15）：
- `Ride5SessionPortHandle copy$default(Ride5SessionPortHandle ride5SessionPortHandle, String str, long j, Ride5SessionPort ride5SessionPort, Mutex mutex, int i, Object obj)`  L20
- `String getSessionId()`  L39
- `long getRouteRevision()`  L44
- `Ride5SessionPort getPort()`  L49
- `Mutex getRecordingCommandMutex()`  L54
- `Ride5SessionPortHandle copy(String sessionId, long routeRevision, Ride5SessionPort port, Mutex recordingCommandMutex)`  L58
    - 体内字面量："sessionId" · "port" · "recordingCommandMutex"
- `boolean equals(Object other)`  L65
- `int hashCode()`  L76
- `String toString()`  L80
    - 体内字面量："Ride5SessionPortHandle(sessionId=" · ", routeRevision=" · ", port=" · ", recordingCommandMutex=" · ")"
- `public Ride5SessionPortHandle(String sessionId, long j, Ride5SessionPort port, Mutex recordingCommandMutex)`  L84
    - 体内字面量："sessionId" · "port" · "recordingCommandMutex"
- `String getSessionId()`  L94
- `long getRouteRevision()`  L98
- `Ride5SessionPort getPort()`  L102
- ` Ride5SessionPortHandle(String str, long j, Ride5SessionPort ride5SessionPort, Mutex mutex, int i, DefaultConstructorMarker defaultConstructorMarker)`  L106
- `Mutex getRecordingCommandMutex()`  L110
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionPortProvider`
L42 · [class] public final Ride5SessionPortProvider · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionPortProvider.java`
注解：

字段/常量（11）：
- `DeviceEndpointAuthority endpointAuthority`  L43
- `VerifiedDeviceFileCatalog fileCatalog`  L44
- `Function0<Long> now`  L45
- `RecordingControlDeviceResolver recordingDeviceResolver`  L46
- `RecordingControlEventRepository recordingEvents`  L47
- `Ride5SessionRegistry registry`  L48
- `DeviceSessionManager sessions`  L49
- `DeviceEndpointAuthority deviceEndpointAuthority = this.endpointAuthority`  L126
- `Ride5SessionPortHandle ride5SessionPortHandle = null`  L142
- `VerifiedDeviceFileCatalog verifiedDeviceFileCatalog = this.fileCatalog`  L166
- `RecordingControlEventRepository recordingControlEventRepository = this.recordingEvents`  L170

方法（6）：
- `public Ride5SessionPortProvider(Ride5SessionRegistry registry, DeviceSessionManager sessions, VerifiedDeviceFileCatalog verifiedDeviceFileCatalog, DeviceEndpointAuthority deviceEndpointAuthority, RecordingControlEventRepository recordingControlEventRepository, Function0<Long> now, RecordingControlDeviceResolver recordingControlDeviceResolver)`  L51
    - 体内字面量："registry" · "sessions" · "now"
- ` Ride5SessionPortProvider(Ride5SessionRegistry ride5SessionRegistry, DeviceSessionManager deviceSessionManager, VerifiedDeviceFileCatalog verifiedDeviceFileCatalog, DeviceEndpointAuthority deviceEndpointAuthority, RecordingControlEventRepository recordingControlEventRepository, Function0 function0, RecordingControlDeviceResolver recordingControlDeviceResolver, int i, DefaultConstructorMarker defaultConstructorMarker)`  L82
- `Ride5SessionPortHandle require(String sessionId)`  L86
    - 体内字面量："sessionId" · "RIDE5 operation requires sessionId" · "RIDE5 session is not ready: " · "RIDE5 session has no route: " · "RIDE5 session port is unavailable: " · "RIDE5 session port revision is stale: "
- `EndpointGrant requireOtaGrant(String sessionId)`  L109
    - 体内字面量："sessionId" · "Check failed." · "Check failed." · "RIDE5 session has no route: " · "RIDE5 session has no verified control grant: "
- `Ride5SessionPortHandle uniqueReadyHandleOrNull()`  L137
- `Ride5SessionPortHandle withSessionDecorators(Ride5SessionPortHandle handle, DeviceSessionSnapshot snapshot)`  L164
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionPortProvider$C20321`
L68 · [class] public C20321 · extends `FunctionReferenceImpl implements Function0<Long>` · implements `Function0<Long>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionPortProvider.java`
注解：

方法（1）：
- `Long invoke()`  L77 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionPortProvider$CatalogRecordingRide5SessionPort`
L180 · [class] static final CatalogRecordingRide5SessionPort · implements `Ride5SessionPort` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionPortProvider.java`
注解：

字段/常量（9）：
- `VerifiedDeviceFileCatalog catalog`  L181
- `Ride5SessionPort delegate`  L182
- `String sessionId`  L183
- `C2033xce3d7520 c2033xce3d7520`  L317
- `CatalogRecordingRide5SessionPort catalogRecordingRide5SessionPort`  L318
- `Object objFileList = c2033xce3d7520.result`  L329
- `int i = c2033xce3d7520.label`  L331
- `Ride5SessionPort ride5SessionPort = this.delegate`  L334
- `ArrayList arrayList3 = arrayList2`  L366

方法（26）：
- `Object batteryCapacity(Continuation<? super Ride5CgiPayload> continuation)`  L186 @Override
- `Object cameraNumber(Continuation<? super Ride5CgiPayload> continuation)`  L191 @Override
- `Object cameraParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L196 @Override
- `Object cameraParameterCapability(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L201 @Override
- `Object checkPacket(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L206 @Override
- `Object command(String str, Continuation<? super Ride5CgiPayload> continuation)`  L211 @Override
- `Object commonParameter(String str, Continuation<? super Ride5CgiPayload> continuation)`  L216 @Override
- `Object commonParameterCapability(String str, Continuation<? super Ride5CgiPayload> continuation)`  L221 @Override
- `Object deleteFile(String str, Continuation<? super Ride5CgiPayload> continuation)`  L226 @Override
- `Object deviceAttributes(Continuation<? super Ride5CgiPayload> continuation)`  L231 @Override
- `Object directoryCapability(Continuation<? super Ride5CgiPayload> continuation)`  L236 @Override
- `Object ensureRecordingStopped(Continuation<? super Ride5CgiPayload> continuation)`  L241 @Override
- `Object fileCount(String str, Continuation<? super Ride5CgiPayload> continuation)`  L246 @Override
- `Object fileInfo(String str, Continuation<? super Ride5CgiPayload> continuation)`  L251 @Override
- `Object formatSdCard(Continuation<? super Ride5CgiPayload> continuation)`  L256 @Override
- `Object resetDevice(Continuation<? super Ride5CgiPayload> continuation)`  L261 @Override
- `Object sdStatus(Continuation<? super Ride5CgiPayload> continuation)`  L266 @Override
- `Object setCameraParameter(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L271 @Override
- `Object setCommonParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L276 @Override
- `Object setSystemTime(String str, Continuation<? super Ride5CgiPayload> continuation)`  L281 @Override
- `Object setWifi(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L286 @Override
- `Object switchCamera(String str, Continuation<? super Ride5CgiPayload> continuation)`  L291 @Override
- `Object wifi(Continuation<? super Ride5CgiPayload> continuation)`  L296 @Override
- `Object workState(Continuation<? super Ride5CgiPayload> continuation)`  L301 @Override
- `public CatalogRecordingRide5SessionPort(Ride5SessionPort delegate, String sessionId, VerifiedDeviceFileCatalog catalog)`  L305
    - 体内字面量："delegate" · "sessionId" · "catalog"
- `Object fileList(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L316 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionPortProvider$withSessionDecorators$2$1`
L22 · [class] final Ride5SessionPortProvider$withSessionDecorators$2$1 · extends `SuspendLambda implements Function1<Continuation<? super RecordingControlDevice>, Object>` · implements `Function1<Continuation<? super RecordingControlDevice>, Object>` · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionPortProvider$withSessionDecorators$2$1.java`
注解：

字段/常量（11）：
- `DeviceSessionSnapshot $snapshot`  L23
- `int label`  L24
- `Ride5SessionPortProvider this$0`  L25
- `DeviceIdentity identity`  L48
- `String serial`  L49
- `int i = this.label`  L51
- `RecordingControlDeviceResolver recordingControlDeviceResolver = this.this$0.recordingDeviceResolver`  L54
- `RecordingControlDevice.Companion companion = RecordingControlDevice.INSTANCE`  L62
- `DeviceType deviceType = DeviceType.RIDE5`  L63
- `RecordingControlDevice.Companion companion2 = RecordingControlDevice.INSTANCE`  L81
- `DeviceType deviceType2 = DeviceType.RIDE5`  L82

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L35 @Override
- `Object invoke(Continuation<? super RecordingControlDevice> continuation)`  L40 @Override
- `Object invokeSuspend(Object obj)`  L47 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.Ride5SessionRegistry`
L17 · [class] public final Ride5SessionRegistry · `com/tuwinsmart/tuwin/core/device/ride5/Ride5SessionRegistry.java`
注解：

字段/常量（1）：
- `ConcurrentHashMap<String, Ride5SessionPortHandle> concurrentHashMap = this.ports`  L47

方法（9）：
- `void register(Ride5SessionPortHandle handle)`  L20
    - 体内字面量："handle" · "Failed requirement." · "Failed requirement." · "RIDE5 session port is already registered: "
- `void unregister$default(Ride5SessionRegistry ride5SessionRegistry, String str, Ride5SessionPort ride5SessionPort, int i, Object obj)`  L34
- `void unregister(String sessionId, final Ride5SessionPort port)`  L41
    - 体内字面量："sessionId"
- `Ride5SessionPortHandle invoke(String str, Ride5SessionPortHandle current)`  L54 @Override
    - 体内字面量："<anonymous parameter 0>" · "current"
- `Object apply(Object obj, Object obj2)`  L65 @Override
- `Ride5SessionPortHandle unregister$lambda$1(Function2 tmp0, Object obj, Object obj2)`  L72
    - 体内字面量："$tmp0"
- `Ride5SessionPortHandle handleFor(String sessionId)`  L77
    - 体内字面量："sessionId"
- `Set<String> activeSessionIds()`  L82
    - 体内字面量："<get-keys>(...)"
- `void clear()`  L88
### `com.tuwinsmart.tuwin.core.device.ride5.SerializedRide5RecordingSessionPort`
L24 · [class] public final SerializedRide5RecordingSessionPort · implements `Ride5SessionPort` · `com/tuwinsmart/tuwin/core/device/ride5/SerializedRide5RecordingSessionPort.java`
注解：

字段/常量（29）：
- `Ride5SessionPort delegate`  L25
- `Mutex mutex`  L26
- `C20351 c20351`  L200
- `Mutex mutex`  L201
- `SerializedRide5RecordingSessionPort serializedRide5RecordingSessionPort`  L202
- `Throwable th`  L203
- `Mutex mutex2`  L204
- `Object objCommand`  L205
- `Object objCommand2 = c20351.result`  L216
- `int i = c20351.label`  L218
- `Ride5SessionPort ride5SessionPort = serializedRide5RecordingSessionPort.delegate`  L234
- `Mutex mutex3 = mutex`  L243
- `Ride5SessionPort ride5SessionPort2 = this.delegate`  L250
- `Ride5SessionPort ride5SessionPort3 = serializedRide5RecordingSessionPort.delegate`  L281
- `Mutex mutex5 = mutex`  L290
- `Mutex mutex6 = mutex`  L297
- `C20361 c20361`  L310
- `Mutex mutex`  L311
- `SerializedRide5RecordingSessionPort serializedRide5RecordingSessionPort`  L312
- `Mutex mutex2`  L313
- `Throwable th`  L314
- `SerializedRide5RecordingSessionPort serializedRide5RecordingSessionPort2`  L315
- `Mutex mutex3`  L316
- `Ride5CgiPayload ride5CgiPayload`  L317
- `Object objCommand = c20361.result`  L328
- `int i = c20361.label`  L330
- `Ride5SessionPort ride5SessionPort = serializedRide5RecordingSessionPort2.delegate`  L367
- `Ride5SessionPort ride5SessionPort2 = serializedRide5RecordingSessionPort.delegate`  L393
- `Ride5SessionPort ride5SessionPort3 = serializedRide5RecordingSessionPort2.delegate`  L407

方法（26）：
- `Object batteryCapacity(Continuation<? super Ride5CgiPayload> continuation)`  L74 @Override
- `Object cameraNumber(Continuation<? super Ride5CgiPayload> continuation)`  L79 @Override
- `Object cameraParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L84 @Override
- `Object cameraParameterCapability(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L89 @Override
- `Object checkPacket(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L94 @Override
- `Object commonParameter(String str, Continuation<? super Ride5CgiPayload> continuation)`  L99 @Override
- `Object commonParameterCapability(String str, Continuation<? super Ride5CgiPayload> continuation)`  L104 @Override
- `Object deleteFile(String str, Continuation<? super Ride5CgiPayload> continuation)`  L109 @Override
- `Object deviceAttributes(Continuation<? super Ride5CgiPayload> continuation)`  L114 @Override
- `Object directoryCapability(Continuation<? super Ride5CgiPayload> continuation)`  L119 @Override
- `Object fileCount(String str, Continuation<? super Ride5CgiPayload> continuation)`  L124 @Override
- `Object fileInfo(String str, Continuation<? super Ride5CgiPayload> continuation)`  L129 @Override
- `Object fileList(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L134 @Override
- `Object formatSdCard(Continuation<? super Ride5CgiPayload> continuation)`  L139 @Override
- `Object resetDevice(Continuation<? super Ride5CgiPayload> continuation)`  L144 @Override
- `Object sdStatus(Continuation<? super Ride5CgiPayload> continuation)`  L149 @Override
- `Object setCameraParameter(String str, String str2, String str3, Continuation<? super Ride5CgiPayload> continuation)`  L154 @Override
- `Object setCommonParameter(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L159 @Override
- `Object setSystemTime(String str, Continuation<? super Ride5CgiPayload> continuation)`  L164 @Override
- `Object setWifi(String str, String str2, Continuation<? super Ride5CgiPayload> continuation)`  L169 @Override
- `Object switchCamera(String str, Continuation<? super Ride5CgiPayload> continuation)`  L174 @Override
- `Object wifi(Continuation<? super Ride5CgiPayload> continuation)`  L179 @Override
- `Object workState(Continuation<? super Ride5CgiPayload> continuation)`  L184 @Override
- `public SerializedRide5RecordingSessionPort(Ride5SessionPort delegate, Mutex mutex)`  L188
    - 体内字面量："delegate" · "mutex"
- `Object command(String str, Continuation<? super Ride5CgiPayload> continuation)`  L199 @Override
- `Object ensureRecordingStopped(Continuation<? super Ride5CgiPayload> continuation)`  L309 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.SerializedRide5RecordingSessionPort$C20351`
L32 · [class] static final C20351 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/SerializedRide5RecordingSessionPort.java`
注解：

字段/常量（5）：
- `Object L$0`  L33
- `Object L$1`  L34
- `Object L$2`  L35
- `int label`  L36
- `Object result`  L37

方法（1）：
- `Object invokeSuspend(Object obj)`  L44 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.SerializedRide5RecordingSessionPort$C20361`
L55 · [class] static final C20361 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/device/ride5/SerializedRide5RecordingSessionPort.java`
注解：

字段/常量（4）：
- `Object L$0`  L56
- `Object L$1`  L57
- `int label`  L58
- `Object result`  L59

方法（1）：
- `Object invokeSuspend(Object obj)`  L66 @Override
### `com.tuwinsmart.tuwin.core.device.ride5.UnconfiguredRide5CallbackDecoder`
L13 · [class] public final UnconfiguredRide5CallbackDecoder · implements `Ride5CallbackDecoder` · `com/tuwinsmart/tuwin/core/device/ride5/UnconfiguredRide5CallbackDecoder.java`
注解：

方法（1）：
- `void decode(Ride5CallbackSocket socket, Ride5CallbackLimits limits, Function0<Boolean> isActive, Ride5CallbackBufferBudget bufferBudget, Function1<? super byte[], Unit> emit)`  L15 @Override
    - 体内字面量："socket" · "limits" · "isActive" · "bufferBudget" · "emit" · "RIDE5 callback frame decoder is not configured; protocol evidence is required"