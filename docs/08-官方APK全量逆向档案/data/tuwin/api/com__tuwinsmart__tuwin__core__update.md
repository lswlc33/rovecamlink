# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.core.update

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 13 个文件 / 29 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.core.update.AppUpdateCheckKey`
L10 · [class] public final AppUpdateCheckKey · `com/tuwinsmart/tuwin/core/update/AppUpdateCheckKey.java`
注解：

字段/常量（3）：
- `String releaseChannel`  L11
- `String serverEnvironment`  L12
- `int versionCode`  L13

方法（12）：
- `AppUpdateCheckKey copy$default(AppUpdateCheckKey appUpdateCheckKey, int i, String str, String str2, int i2, Object obj)`  L15
- `int getVersionCode()`  L29
- `String getReleaseChannel()`  L34
- `String getServerEnvironment()`  L39
- `AppUpdateCheckKey copy(int versionCode, String releaseChannel, String serverEnvironment)`  L43
    - 体内字面量："releaseChannel" · "serverEnvironment"
- `boolean equals(Object other)`  L49
- `int hashCode()`  L60
- `String toString()`  L64
    - 体内字面量："AppUpdateCheckKey(versionCode=" · ", releaseChannel=" · ", serverEnvironment=" · ")"
- `public AppUpdateCheckKey(int i, String releaseChannel, String serverEnvironment)`  L68
    - 体内字面量："releaseChannel" · "serverEnvironment"
- `int getVersionCode()`  L76
- `String getReleaseChannel()`  L80
- `String getServerEnvironment()`  L84
### `com.tuwinsmart.tuwin.core.update.AppUpdateCheckResult`
L12 · [interface] public AppUpdateCheckResult · `com/tuwinsmart/tuwin/core/update/AppUpdateCheckResult.java`
注解：

方法（1）：
- `AppUpdateCheckKey getKey()`  L13
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult$WaitingForInternetRoute;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "(Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;)V" · "getKey" · "()Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult$NoUpdate;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "response" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/CheckUpdateBean;" · "(Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;Lcom/tuwinsmart/tuwin/data/source/remote/dto/CheckUpdateBean;)V" · "getKey" · "()Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "getResponse" · "()Lcom/tuwinsmart/tuwin/data/source/remote/dto/CheckUpdateBean;" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult$UpdateAvailable;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "response" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/CheckUpdateBean;" · "routeRevision" · "(Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;Lcom/tuwinsmart/tuwin/data/source/remote/dto/CheckUpdateBean;J)V" · "getKey" · "()Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "getResponse" · "()Lcom/tuwinsmart/tuwin/data/source/remote/dto/CheckUpdateBean;" · "getRouteRevision" · "()J" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult$Failed;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "error" · "(Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;Ljava/lang/Throwable;)V" · "getError" · "()Ljava/lang/Throwable;" · "getKey" · "()Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult$Cancelled;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckResult;" · "Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "reason" · "(Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;Ljava/lang/String;)V" · "getKey" · "()Lcom/tuwinsmart/tuwin/core/update/AppUpdateCheckKey;" · "getReason" · "()Ljava/lang/String;" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.core.update.AppUpdateCheckResult$Cancelled`
L283 · [class] public static final Cancelled · implements `AppUpdateCheckResult` · `com/tuwinsmart/tuwin/core/update/AppUpdateCheckResult.java`
注解：

字段/常量（2）：
- `AppUpdateCheckKey key`  L284
- `String reason`  L285

方法（10）：
- `Cancelled copy$default(Cancelled cancelled, AppUpdateCheckKey appUpdateCheckKey, String str, int i, Object obj)`  L287
- `AppUpdateCheckKey getKey()`  L298
- `String getReason()`  L303
- `Cancelled copy(AppUpdateCheckKey key, String reason)`  L307
    - 体内字面量："key" · "reason"
- `boolean equals(Object other)`  L313
- `int hashCode()`  L324
- `String toString()`  L328
    - 体内字面量："Cancelled(key=" · ", reason=" · ")"
- `public Cancelled(AppUpdateCheckKey key, String reason)`  L332
    - 体内字面量："key" · "reason"
- `AppUpdateCheckKey getKey()`  L340 @Override
- `String getReason()`  L344
### `com.tuwinsmart.tuwin.core.update.AppUpdateCheckResult$Failed`
L215 · [class] public static final Failed · implements `AppUpdateCheckResult` · `com/tuwinsmart/tuwin/core/update/AppUpdateCheckResult.java`
注解：

字段/常量（2）：
- `Throwable error`  L216
- `AppUpdateCheckKey key`  L217

方法（10）：
- `Failed copy$default(Failed failed, AppUpdateCheckKey appUpdateCheckKey, Throwable th, int i, Object obj)`  L219
- `AppUpdateCheckKey getKey()`  L230
- `Throwable getError()`  L235
- `Failed copy(AppUpdateCheckKey key, Throwable error)`  L239
    - 体内字面量："key" · "error"
- `boolean equals(Object other)`  L245
- `int hashCode()`  L256
- `String toString()`  L260
    - 体内字面量："Failed(key=" · ", error=" · ")"
- `public Failed(AppUpdateCheckKey key, Throwable error)`  L264
    - 体内字面量："key" · "error"
- `AppUpdateCheckKey getKey()`  L272 @Override
- `Throwable getError()`  L276
### `com.tuwinsmart.tuwin.core.update.AppUpdateCheckResult$NoUpdate`
L65 · [class] public static final NoUpdate · implements `AppUpdateCheckResult` · `com/tuwinsmart/tuwin/core/update/AppUpdateCheckResult.java`
注解：

字段/常量（2）：
- `AppUpdateCheckKey key`  L66
- `CheckUpdateBean response`  L67

方法（10）：
- `NoUpdate copy$default(NoUpdate noUpdate, AppUpdateCheckKey appUpdateCheckKey, CheckUpdateBean checkUpdateBean, int i, Object obj)`  L69
- `AppUpdateCheckKey getKey()`  L80
- `CheckUpdateBean getResponse()`  L85
- `NoUpdate copy(AppUpdateCheckKey key, CheckUpdateBean response)`  L89
    - 体内字面量："key" · "response"
- `boolean equals(Object other)`  L95
- `int hashCode()`  L106
- `String toString()`  L110
    - 体内字面量："NoUpdate(key=" · ", response=" · ")"
- `public NoUpdate(AppUpdateCheckKey key, CheckUpdateBean response)`  L114
    - 体内字面量："key" · "response"
- `AppUpdateCheckKey getKey()`  L122 @Override
- `CheckUpdateBean getResponse()`  L126
### `com.tuwinsmart.tuwin.core.update.AppUpdateCheckResult$UpdateAvailable`
L133 · [class] public static final UpdateAvailable · implements `AppUpdateCheckResult` · `com/tuwinsmart/tuwin/core/update/AppUpdateCheckResult.java`
注解：

字段/常量（3）：
- `AppUpdateCheckKey key`  L134
- `CheckUpdateBean response`  L135
- `long routeRevision`  L136

方法（12）：
- `UpdateAvailable copy$default(UpdateAvailable updateAvailable, AppUpdateCheckKey appUpdateCheckKey, CheckUpdateBean checkUpdateBean, long j, int i, Object obj)`  L138
- `AppUpdateCheckKey getKey()`  L152
- `CheckUpdateBean getResponse()`  L157
- `long getRouteRevision()`  L162
- `UpdateAvailable copy(AppUpdateCheckKey key, CheckUpdateBean response, long routeRevision)`  L166
    - 体内字面量："key" · "response"
- `boolean equals(Object other)`  L172
- `int hashCode()`  L183
- `String toString()`  L187
    - 体内字面量："UpdateAvailable(key=" · ", response=" · ", routeRevision=" · ")"
- `public UpdateAvailable(AppUpdateCheckKey key, CheckUpdateBean response, long j)`  L191
    - 体内字面量："key" · "response"
- `AppUpdateCheckKey getKey()`  L200 @Override
- `CheckUpdateBean getResponse()`  L204
- `long getRouteRevision()`  L208
### `com.tuwinsmart.tuwin.core.update.AppUpdateCheckResult$WaitingForInternetRoute`
L17 · [class] public static final WaitingForInternetRoute · implements `AppUpdateCheckResult` · `com/tuwinsmart/tuwin/core/update/AppUpdateCheckResult.java`
注解：

字段/常量（1）：
- `AppUpdateCheckKey key`  L18

方法（8）：
- `WaitingForInternetRoute copy$default(WaitingForInternetRoute waitingForInternetRoute, AppUpdateCheckKey appUpdateCheckKey, int i, Object obj)`  L20
- `AppUpdateCheckKey getKey()`  L28
- `WaitingForInternetRoute copy(AppUpdateCheckKey key)`  L32
    - 体内字面量："key"
- `boolean equals(Object other)`  L37
- `int hashCode()`  L44
- `String toString()`  L48
    - 体内字面量："WaitingForInternetRoute(key=" · ")"
- `public WaitingForInternetRoute(AppUpdateCheckKey key)`  L52
    - 体内字面量："key"
- `AppUpdateCheckKey getKey()`  L58 @Override
### `com.tuwinsmart.tuwin.core.update.AppUpdateCheckState`
L11 · [enum] public AppUpdateCheckState · `com/tuwinsmart/tuwin/core/update/AppUpdateCheckState.java`
注解：

枚举常量（7）：
- `IDLE()`  L12
- `WAITING_FOR_INTERNET_ROUTE()`  L13
- `CHECKING()`  L14
- `NO_UPDATE()`  L15
- `UPDATE_AVAILABLE()`  L16
- `CHECK_FAILED()`  L17
- `CHECK_CANCELLED()`  L18

方法（1）：
- `EnumEntries<AppUpdateCheckState> getEntries()`  L22
### `com.tuwinsmart.tuwin.core.update.AppUpdateCoordinator`
L40 · [class] public final AppUpdateCoordinator · `com/tuwinsmart/tuwin/core/update/AppUpdateCoordinator.java`
注解：

字段/常量（50）：
- `MutableStateFlow<AppUpdateCheckState> _state`  L41
- `Function0<String> appVersion`  L42
- `LinkedHashMap<AppUpdateCheckKey, AppUpdateCheckResult> completed`  L43
- `AppUpdateGateway gateway`  L44
- `LinkedHashMap<AppUpdateCheckKey, CompletableDeferred<AppUpdateCheckResult>> inFlight`  L45
- `Function1<String, Boolean> isValidDownloadUrl`  L46
- `Mutex mutex`  L47
- `RouteProvider routeProvider`  L48
- `StateFlow<AppUpdateCheckState> state`  L49
- `C21081 c21081`  L171
- `Ref.ObjectRef objectRef`  L172
- `Ref.BooleanRef booleanRef`  L173
- `Mutex mutex`  L174
- `AppUpdateCoordinator appUpdateCoordinator`  L175
- `Ref.ObjectRef objectRef2`  L176
- `AppUpdateCoordinator appUpdateCoordinator2`  L177
- `AppUpdateCheckResult appUpdateCheckResult`  L178
- `Mutex mutex2`  L179
- `AppUpdateCheckKey appUpdateCheckKey2`  L180
- `AppUpdateCheckResult appUpdateCheckResult2`  L181
- `AppUpdateCoordinator appUpdateCoordinator3`  L182
- `Mutex mutex3`  L183
- `Object objRunCheck = c21081.result`  L194
- `int i = c21081.label`  L196
- `Unit unit = Unit.INSTANCE`  L256
- `Unit unit2 = Unit.INSTANCE`  L286
- `Unit unit3 = Unit.INSTANCE`  L332
- `C21091 c21091`  L348
- `AppUpdateCoordinator appUpdateCoordinator`  L349
- `Mutex mutex`  L350
- `Object obj = c21091.result`  L361
- `int i = c21091.label`  L363
- `Mutex mutex2 = this.mutex`  L366
- `Unit unit = Unit.INSTANCE`  L385
- `C21101 c21101`  L416
- `Throwable th`  L417
- `?? r12`  L418
- `AppUpdateCoordinator appUpdateCoordinator`  L419
- `AppUpdateCoordinator appUpdateCoordinator2`  L420
- `AppUpdateCheckKey appUpdateCheckKey2`  L421
- `?? r13`  L422
- `AppUpdateCoordinator appUpdateCoordinator3`  L423
- `?? r14`  L424
- `AppUpdateCheckResult.Failed failed`  L425
- `?? r15`  L426
- `?? r16`  L427
- `String str`  L428
- `CheckUpdateBean checkUpdateBean`  L429
- `Object obj = c21101.result`  L440
- `int i = c21101.label`  L442

方法（6）：
- `public AppUpdateCoordinator(RouteProvider routeProvider, AppUpdateGateway gateway, Function0<String> appVersion, Function1<? super String, Boolean> isValidDownloadUrl)`  L122
    - 体内字面量："routeProvider" · "gateway" · "appVersion" · "isValidDownloadUrl"
- ` AppUpdateCoordinator(RouteProvider routeProvider, AppUpdateGateway appUpdateGateway, Function0 function0, C21071 c21071, int i, DefaultConstructorMarker defaultConstructorMarker)`  L156
- `StateFlow<AppUpdateCheckState> getState()`  L160
- `Object check(AppUpdateCheckKey appUpdateCheckKey, Continuation<? super AppUpdateCheckResult> continuation)`  L170
- `Object clearCompleted(Continuation<? super Unit> continuation)`  L347
- `Object runCheck(AppUpdateCheckKey appUpdateCheckKey, Continuation<? super AppUpdateCheckResult> continuation)`  L415
### `com.tuwinsmart.tuwin.core.update.AppUpdateCoordinator$C21071`
L143 · [class] public C21071 · extends `FunctionReferenceImpl implements Function1<String, Boolean>` · implements `Function1<String, Boolean>` · `com/tuwinsmart/tuwin/core/update/AppUpdateCoordinator.java`
注解：

方法（1）：
- `Boolean invoke(String str)`  L151 @Override
### `com.tuwinsmart.tuwin.core.update.AppUpdateCoordinator$C21081`
L55 · [class] static final C21081 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/update/AppUpdateCoordinator.java`
注解：

字段/常量（7）：
- `Object L$0`  L56
- `Object L$1`  L57
- `Object L$2`  L58
- `Object L$3`  L59
- `Object L$4`  L60
- `int label`  L61
- `Object result`  L62

方法（1）：
- `Object invokeSuspend(Object obj)`  L69 @Override
### `com.tuwinsmart.tuwin.core.update.AppUpdateCoordinator$C21091`
L80 · [class] static final C21091 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/update/AppUpdateCoordinator.java`
注解：

字段/常量（4）：
- `Object L$0`  L81
- `Object L$1`  L82
- `int label`  L83
- `Object result`  L84

方法（1）：
- `Object invokeSuspend(Object obj)`  L91 @Override
### `com.tuwinsmart.tuwin.core.update.AppUpdateCoordinator$C21101`
L102 · [class] static final C21101 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/update/AppUpdateCoordinator.java`
注解：

字段/常量（5）：
- `Object L$0`  L103
- `Object L$1`  L104
- `Object L$2`  L105
- `int label`  L106
- `Object result`  L107

方法（1）：
- `Object invokeSuspend(Object obj)`  L114 @Override
### `com.tuwinsmart.tuwin.core.update.AppUpdateCoordinator$runCheck$response$1`
L23 · [class] final AppUpdateCoordinator$runCheck$response$1 · extends `SuspendLambda implements Function1<Continuation<? super CheckUpdateBean>, Object>` · implements `Function1<Continuation<? super CheckUpdateBean>, Object>` · `com/tuwinsmart/tuwin/core/update/AppUpdateCoordinator$runCheck$response$1.java`
注解：

字段/常量（4）：
- `RouteLease $lease`  L24
- `int label`  L25
- `AppUpdateCoordinator this$0`  L26
- `int i = this.label`  L95

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L36 @Override
- `Object invoke(Continuation<? super CheckUpdateBean> continuation)`  L41 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/CheckUpdateBean;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.core.update.AppUpdateCoordinator$runCheck$response$1$1" · "AppUpdateCoordinator.kt" · "invokeSuspend"
- `Object invokeSuspend(Object obj)`  L93 @Override
### `com.tuwinsmart.tuwin.core.update.AppUpdateCoordinator$runCheck$response$1$C21111`
L49 · [class] static final C21111 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super CheckUpdateBean>, Object>` · implements `Function2<CoroutineScope, Continuation<? super CheckUpdateBean>, Object>` · `com/tuwinsmart/tuwin/core/update/AppUpdateCoordinator$runCheck$response$1.java`
注解：

字段/常量（4）：
- `RouteLease $lease`  L50
- `int label`  L51
- `AppUpdateCoordinator this$0`  L52
- `int i = this.label`  L74

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L62 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super CheckUpdateBean> continuation)`  L67 @Override
- `Object invokeSuspend(Object obj)`  L72 @Override
### `com.tuwinsmart.tuwin.core.update.AppUpdateCoordinatorKt`
L12 · [class] public final AppUpdateCoordinatorKt · `com/tuwinsmart/tuwin/core/update/AppUpdateCoordinatorKt.java`
注解：

字段/常量（1）：
- `HttpUrl httpUrl`  L15

方法（1）：
- `boolean isNetworkDownloadUrl(String str)`  L14
### `com.tuwinsmart.tuwin.core.update.AppUpdateGateway`
L12 · [interface] public AppUpdateGateway · `com/tuwinsmart/tuwin/core/update/AppUpdateGateway.java`
注解：

方法（1）：
- `Object check(RouteLease routeLease, String str, Continuation<? super CheckUpdateBean> continuation)`  L13
### `com.tuwinsmart.tuwin.core.update.DeviceOtaCoordinator`
L33 · [class] public final DeviceOtaCoordinator · `com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java`
注解：

字段/常量（27）：
- `MutableStateFlow<DeviceOtaProgress> _progress`  L34
- `Function2<TransferRequest, Continuation<? super TransferResult>, Object> download`  L35
- `StateFlow<DeviceOtaProgress> progress`  L36
- `Function2<TransferUploadRequest, Continuation<? super TransferResult>, Object> upload`  L37
- `DeviceOtaUploadQueue uploadQueue`  L38
- `C21131 c21131`  L166
- `DeviceOtaCoordinator deviceOtaCoordinator`  L167
- `DeviceOtaCoordinator deviceOtaCoordinator2`  L168
- `TransferRequest packageDownload`  L169
- `DeviceOtaOperations operations`  L170
- `TransferResult transferResult`  L171
- `TransferResult transferResult2`  L172
- `DeviceOtaOperations operations2`  L173
- `DeviceOtaOperations operations3`  L174
- `DeviceOtaOperations operations4`  L175
- `DeviceOtaCoordinator deviceOtaCoordinator3`  L176
- `String str`  L177
- `Object objQueryUpdate = c21131.result`  L188
- `?? r3 = c21131.label`  L190
- `Function2<TransferRequest, Continuation<? super TransferResult>, Object> function2 = deviceOtaCoordinator2.download`  L214
- `Function2<TransferUploadRequest, Continuation<? super TransferResult>, Object> function3 = deviceOtaCoordinator2.upload`  L250
- `Function2<TransferRequest, Continuation<? super TransferResult>, Object> function4 = deviceOtaCoordinator2.download`  L334
- `Function2<TransferUploadRequest, Continuation<? super TransferResult>, Object> function5 = deviceOtaCoordinator2.upload`  L370
- `Function2<TransferUploadRequest, Continuation<? super TransferResult>, Object> function6 = deviceOtaCoordinator2.upload`  L465
- `Function2<TransferUploadRequest, Continuation<? super TransferResult>, Object> function7 = deviceOtaCoordinator2.upload`  L534
- `MutableStateFlow<DeviceOtaProgress> mutableStateFlow = this._progress`  L787
- `MutableStateFlow<DeviceOtaProgress> mutableStateFlow = this._progress`  L793

方法（7）：
- `public DeviceOtaCoordinator(DeviceOtaUploadQueue uploadQueue, Function2<? super TransferRequest, ? super Continuation<? super TransferResult>, ? extends Object> download, Function2<? super TransferUploadRequest, ? super Continuation<? super TransferResult>, ? extends Object> upload)`  L63
    - 体内字面量："uploadQueue" · "download" · "upload" · "<anonymous>" · "Lcom/tuwinsmart/tuwin/core/transfer/TransferResult;" · "Lcom/tuwinsmart/tuwin/core/transfer/TransferUploadRequest;" · "com.tuwinsmart.tuwin.core.update.DeviceOtaCoordinator$1" · "DeviceOtaCoordinator.kt" · "invokeSuspend"
- ` DeviceOtaCoordinator(DeviceOtaUploadQueue deviceOtaUploadQueue, Function2 function2, C21121 c21121, int i, DefaultConstructorMarker defaultConstructorMarker)`  L125
- `StateFlow<DeviceOtaProgress> getProgress()`  L129
- `Object execute(DeviceOtaPlan deviceOtaPlan, Continuation<? super DeviceOtaResult> continuation)`  L165
- `void transition(DeviceOtaState state, DeviceOtaPlan plan)`  L782
- `DeviceOtaResult.Cancelled cancelled()`  L786
- `DeviceOtaResult.Failed failed(Throwable error)`  L792
### `com.tuwinsmart.tuwin.core.update.DeviceOtaCoordinator$C21121`
L80 · [class] public static final C21121 · extends `SuspendLambda implements Function2<TransferUploadRequest, Continuation<? super TransferResult>, Object>` · implements `Function2<TransferUploadRequest, Continuation<? super TransferResult>, Object>` · `com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java`
注解：

字段/常量（4）：
- `DeviceOtaUploadQueue $uploadQueue`  L81
- `Object L$0`  L82
- `int label`  L83
- `int i = this.label`  L106

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L92 @Override
- `Object invoke(TransferUploadRequest transferUploadRequest, Continuation<? super TransferResult> continuation)`  L99 @Override
- `Object invokeSuspend(Object obj)`  L104 @Override
### `com.tuwinsmart.tuwin.core.update.DeviceOtaCoordinator$C21131`
L44 · [class] static final C21131 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/update/DeviceOtaCoordinator.java`
注解：

字段/常量（4）：
- `Object L$0`  L45
- `Object L$1`  L46
- `int label`  L47
- `Object result`  L48

方法（1）：
- `Object invokeSuspend(Object obj)`  L55 @Override
### `com.tuwinsmart.tuwin.core.update.DeviceOtaOperations`
L11 · [interface] public DeviceOtaOperations · `com/tuwinsmart/tuwin/core/update/DeviceOtaOperations.java`
注解：

方法（6）：
- `Object installUploadedPackage(Continuation<? super Unit> continuation)`  L12
- `Object queryUpdate(Continuation<? super Boolean> continuation)`  L14
- `Object readVersion(Continuation<? super String> continuation)`  L16
- `Object reconnect(Continuation<? super Unit> continuation)`  L18
- `Object waitForDeviceReady(Continuation<? super Unit> continuation)`  L20
- `Object waitForReboot(Continuation<? super Unit> continuation)`  L22
### `com.tuwinsmart.tuwin.core.update.DeviceOtaPlan`
L17 · [class] public final DeviceOtaPlan · `com/tuwinsmart/tuwin/core/update/DeviceOtaPlan.java`
注解：

字段/常量（13）：
- `DiagnosticContext diagnostics`  L18
- `String expectedVersion`  L19
- `DeviceOtaOperations operations`  L20
- `TransferRequest packageDownload`  L21
- `File packageFile`  L22
- `IntegrityPolicy packageIntegrity`  L23
- `TransferUploadRequest upload`  L24
- `File file2 = file`  L33
- `TransferUploadRequest transferUploadRequest2 = transferUploadRequest`  L37
- `DeviceOtaOperations deviceOtaOperations2 = deviceOtaOperations`  L41
- `TransferRequest transferRequest2 = transferRequest`  L45
- `IntegrityPolicy integrityPolicy2 = integrityPolicy`  L49
- `TransferRequest transferRequest = this.packageDownload`  L114

方法（21）：
- `DeviceOtaPlan copy$default(DeviceOtaPlan deviceOtaPlan, String str, File file, TransferUploadRequest transferUploadRequest, DeviceOtaOperations deviceOtaOperations, TransferRequest transferRequest, IntegrityPolicy integrityPolicy, DiagnosticContext diagnosticContext, int i, Object obj)`  L26
- `String getExpectedVersion()`  L57
- `File getPackageFile()`  L62
- `TransferUploadRequest getUpload()`  L67
- `DeviceOtaOperations getOperations()`  L72
- `TransferRequest getPackageDownload()`  L77
- `IntegrityPolicy getPackageIntegrity()`  L82
- `DiagnosticContext getDiagnostics()`  L87
- `DeviceOtaPlan copy(String expectedVersion, File packageFile, TransferUploadRequest upload, DeviceOtaOperations operations, TransferRequest packageDownload, IntegrityPolicy packageIntegrity, DiagnosticContext diagnostics)`  L91
    - 体内字面量："expectedVersion" · "packageFile" · "upload" · "operations" · "packageIntegrity" · "diagnostics"
- `boolean equals(Object other)`  L101
- `int hashCode()`  L112
- `String toString()`  L118
    - 体内字面量："DeviceOtaPlan(expectedVersion=" · ", packageFile=" · ", upload=" · ", operations=" · ", packageDownload=" · ", packageIntegrity=" · ", diagnostics=" · ")"
- `public DeviceOtaPlan(String expectedVersion, File packageFile, TransferUploadRequest upload, DeviceOtaOperations operations, TransferRequest transferRequest, IntegrityPolicy packageIntegrity, DiagnosticContext diagnostics)`  L122
    - 体内字面量："expectedVersion" · "packageFile" · "upload" · "operations" · "packageIntegrity" · "diagnostics" · "Failed requirement." · "getPath(...)" · "Failed requirement." · "OTA package file and upload source must be the same file" · "Failed requirement."
- `String getExpectedVersion()`  L152
- `File getPackageFile()`  L156
- `TransferUploadRequest getUpload()`  L160
- `DeviceOtaOperations getOperations()`  L164
- `TransferRequest getPackageDownload()`  L168
- `IntegrityPolicy getPackageIntegrity()`  L172
- ` DeviceOtaPlan(String str, File file, TransferUploadRequest transferUploadRequest, DeviceOtaOperations deviceOtaOperations, TransferRequest transferRequest, IntegrityPolicy integrityPolicy, DiagnosticContext diagnosticContext, int i, DefaultConstructorMarker defaultConstructorMarker)`  L176
- `DiagnosticContext getDiagnostics()`  L180
### `com.tuwinsmart.tuwin.core.update.DeviceOtaProgress`
L12 · [class] public final DeviceOtaProgress · `com/tuwinsmart/tuwin/core/update/DeviceOtaProgress.java`
注解：

字段/常量（12）：
- `Throwable error`  L13
- `Long routeRevision`  L14
- `DeviceOtaState state`  L15
- `Long totalBytes`  L16
- `Long transferredBytes`  L17
- `Long l4 = l`  L26
- `Long l5 = l2`  L30
- `Long l6 = l3`  L34
- `Long l = this.transferredBytes`  L84
- `Long l2 = this.totalBytes`  L86
- `Long l3 = this.routeRevision`  L88
- `Throwable th = this.error`  L90

方法（17）：
- `DeviceOtaProgress copy$default(DeviceOtaProgress deviceOtaProgress, DeviceOtaState deviceOtaState, Long l, Long l2, Long l3, Throwable th, int i, Object obj)`  L19
- `DeviceOtaState getState()`  L42
- `Long getTransferredBytes()`  L47
- `Long getTotalBytes()`  L52
- `Long getRouteRevision()`  L57
- `Throwable getError()`  L62
- `DeviceOtaProgress copy(DeviceOtaState state, Long transferredBytes, Long totalBytes, Long routeRevision, Throwable error)`  L66
    - 体内字面量："state"
- `boolean equals(Object other)`  L71
- `int hashCode()`  L82
- `String toString()`  L94
    - 体内字面量："DeviceOtaProgress(state=" · ", transferredBytes=" · ", totalBytes=" · ", routeRevision=" · ", error=" · ")"
- `public DeviceOtaProgress(DeviceOtaState state, Long l, Long l2, Long l3, Throwable th)`  L98
    - 体内字面量："state"
- ` DeviceOtaProgress(DeviceOtaState deviceOtaState, Long l, Long l2, Long l3, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker)`  L107
- `DeviceOtaState getState()`  L111
- `Long getTransferredBytes()`  L115
- `Long getTotalBytes()`  L119
- `Long getRouteRevision()`  L123
- `Throwable getError()`  L127
### `com.tuwinsmart.tuwin.core.update.DeviceOtaResult`
L11 · [interface] public DeviceOtaResult · `com/tuwinsmart/tuwin/core/update/DeviceOtaResult.java`
注解：

字面量："Lcom/tuwinsmart/tuwin/core/update/DeviceOtaResult$Completed;" · "Lcom/tuwinsmart/tuwin/core/update/DeviceOtaResult;" · "routeRevision" · "(Ljava/lang/String;J)V" · "getRouteRevision" · "()J" · "getVersion" · "()Ljava/lang/String;" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/update/DeviceOtaResult$UpdateUnavailable;" · "Lcom/tuwinsmart/tuwin/core/update/DeviceOtaResult;" · "()V" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/update/DeviceOtaResult$Cancelled;" · "Lcom/tuwinsmart/tuwin/core/update/DeviceOtaResult;" · "()V" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/update/DeviceOtaResult$Failed;" · "Lcom/tuwinsmart/tuwin/core/update/DeviceOtaResult;" · "error" · "(Ljava/lang/Throwable;)V" · "getError" · "()Ljava/lang/Throwable;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.core.update.DeviceOtaResult$Cancelled`
L107 · [class] public static final Cancelled · implements `DeviceOtaResult` · `com/tuwinsmart/tuwin/core/update/DeviceOtaResult.java`
注解：

方法（4）：
- `boolean equals(Object other)`  L110
- `int hashCode()`  L120
- `String toString()`  L124
    - 体内字面量："Cancelled"
- `private Cancelled()`  L128
### `com.tuwinsmart.tuwin.core.update.DeviceOtaResult$Completed`
L15 · [class] public static final Completed · implements `DeviceOtaResult` · `com/tuwinsmart/tuwin/core/update/DeviceOtaResult.java`
注解：

字段/常量（2）：
- `long routeRevision`  L16
- `String version`  L17

方法（10）：
- `Completed copy$default(Completed completed, String str, long j, int i, Object obj)`  L19
- `String getVersion()`  L30
- `long getRouteRevision()`  L35
- `Completed copy(String version, long routeRevision)`  L39
    - 体内字面量："version"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："Completed(version=" · ", routeRevision=" · ")"
- `public Completed(String version, long j)`  L63
    - 体内字面量："version"
- `long getRouteRevision()`  L69
- `String getVersion()`  L73
### `com.tuwinsmart.tuwin.core.update.DeviceOtaResult$Failed`
L134 · [class] public static final Failed · implements `DeviceOtaResult` · `com/tuwinsmart/tuwin/core/update/DeviceOtaResult.java`
注解：

字段/常量（1）：
- `Throwable error`  L135

方法（8）：
- `Failed copy$default(Failed failed, Throwable th, int i, Object obj)`  L137
- `Throwable getError()`  L145
- `Failed copy(Throwable error)`  L149
    - 体内字面量："error"
- `boolean equals(Object other)`  L154
- `int hashCode()`  L161
- `String toString()`  L165
    - 体内字面量："Failed(error=" · ")"
- `public Failed(Throwable error)`  L169
    - 体内字面量："error"
- `Throwable getError()`  L174
### `com.tuwinsmart.tuwin.core.update.DeviceOtaResult$UpdateUnavailable`
L80 · [class] public static final UpdateUnavailable · implements `DeviceOtaResult` · `com/tuwinsmart/tuwin/core/update/DeviceOtaResult.java`
注解：

方法（4）：
- `boolean equals(Object other)`  L83
- `int hashCode()`  L93
- `String toString()`  L97
    - 体内字面量："UpdateUnavailable"
- `private UpdateUnavailable()`  L101
### `com.tuwinsmart.tuwin.core.update.DeviceOtaState`
L11 · [enum] public DeviceOtaState · `com/tuwinsmart/tuwin/core/update/DeviceOtaState.java`
注解：

枚举常量（14）：
- `IDLE()`  L12
- `QUERYING()`  L13
- `UPDATE_AVAILABLE()`  L14
- `DOWNLOADING_PACKAGE()`  L15
- `VERIFYING_PACKAGE()`  L16
- `WAITING_FOR_DEVICE()`  L17
- `UPLOADING_TO_DEVICE()`  L18
- `INSTALLING()`  L19
- `WAITING_FOR_REBOOT()`  L20
- `RECONNECTING()`  L21
- `CONFIRMING_VERSION()`  L22
- `COMPLETED()`  L23
- `FAILED()`  L24
- `CANCELLED()`  L25

方法（1）：
- `EnumEntries<DeviceOtaState> getEntries()`  L29