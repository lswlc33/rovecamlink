# TUWIN — 类与成员明细：com.tuwinsmart.tuwin

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 15 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.Ride3ProDisconnectCleanupPolicy`
L11 · [class] public final Ride3ProDisconnectCleanupPolicy · `com/tuwinsmart/tuwin/Ride3ProDisconnectCleanupPolicy.java`
注解：

方法（3）：
- `private Ride3ProDisconnectCleanupPolicy()`  L14
- `boolean shouldClearPreviewHandshakeCache(DeviceType disconnectedDeviceType)`  L17
- `boolean clearPreviewHandshakeCacheIfNeeded(DeviceType disconnectedDeviceType)`  L21
### `com.tuwinsmart.tuwin.Ride3ProPreviewHandshakeBackgroundController`
L15 · [class] public final Ride3ProPreviewHandshakeBackgroundController · `com/tuwinsmart/tuwin/Ride3ProPreviewHandshakeBackgroundController.java`
注解：

字段/常量（3）：
- `long BACKGROUND_CACHE_CLEAR_DELAY_MS = 5000`  L18 @Deprecated
- `Runnable clearCacheRunnable`  L20
- `Handler handler`  L21

方法（8）：
- `public Ride3ProPreviewHandshakeBackgroundController()`  L24
- `public Ride3ProPreviewHandshakeBackgroundController(Handler handler)`  L28
    - 体内字面量："handler"
- `void run()`  L33 @Override
- ` Ride3ProPreviewHandshakeBackgroundController(Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker)`  L39
- `void clearCacheRunnable$lambda$0()`  L44
    - 体内字面量："App è¿ç»­å¤äºåå° 5 ç§ï¼æ¸é¤ Ride3Pro é¢è§æ¡æç¼å­"
- `void onEnterBackground()`  L49
- `void onEnterForeground()`  L54
- `void cancelPendingClear()`  L58
    - 体内字面量："Lcom/tuwinsmart/tuwin/Ride3ProPreviewHandshakeBackgroundController$Companion;" · "()V" · "BACKGROUND_CACHE_CLEAR_DELAY_MS" · "app_release_64"
### `com.tuwinsmart.tuwin.Ride3ProPreviewHandshakeBackgroundController$Companion`
L64 · [class] private static final Companion · `com/tuwinsmart/tuwin/Ride3ProPreviewHandshakeBackgroundController.java`
注解：

方法（2）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L65
- `private Companion()`  L69
### `com.tuwinsmart.tuwin.TuwinApplication`
L141 · [class] public final TuwinApplication · extends `MultiDexApplication` · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（75）：
- `String INTERNET_WEBVIEW_DATA_DIRECTORY_SUFFIX = "internet"`  L145
- `String RELEASE_CHANNEL = "stable"`  L146
- `String SERVER_ENVIRONMENT = "production"`  L147
- `String UMENG_APP_KEY = "6781b8f38f232a05f1f56ef5"`  L148
- `String UMENG_CHANNEL = "Umeng"`  L149
- `TuwinApplication instance`  L150
- `int activityReferences`  L151
- `Handler backgroundCheckHandler`  L152
- `Runnable backgroundCheckRunnable`  L153
- `boolean hasRegisteredAppBackgroundCallbacks`  L154
- `boolean isActivityChangingConfigurations`  L155
- `NetworkManager networkManager`  L156
- `CheckUpdateBean pendingAppUpdateBean`  L157
- `Set<String> presentedAppUpdateKeys`  L158
- `Ride3ProFileBrowsingRecordingLifecycle ride3ProFileBrowsingRecordingLifecycle`  L159
- `Ride3ProHeartbeatManager ride3ProHeartbeatManager`  L160
- `Ride3ProHeartbeatAppVisibilityController ride3ProHeartbeatVisibilityController`  L161
- `Ride3ProPreviewHandshakeBackgroundController ride3ProPreviewHandshakeBackgroundController`  L162
- `String ride5FileManagementBackgroundRecordingSession`  L163
- `String ride5FileManagementForegroundSession`  L164
- `Object[] objArr = 0 == true ? 1 : 0`  L202
- `Object[] objArr2 = 0 == true ? 1 : 0`  L203
- `TuwinApplication tuwinApplication = this`  L260
- `TuwinApplication tuwinApplication = this`  L313
- `Object objM3074constructorimpl`  L388
- `Result.Companion companion = Result.INSTANCE`  L390
- `TuwinApplication tuwinApplication = this`  L391
- `Result.Companion companion2 = Result.INSTANCE`  L394
- `BaseActivity baseActivity = baseActivityCurrentActivity`  L475
- `CheckUpdateBean checkUpdateBean = this.pendingAppUpdateBean`  L487
- `BaseActivity baseActivity = baseActivityCurrentActivity`  L492
- `CheckUpdateBean.AppInfo appInfo = bean.appInfo`  L511
- `String str = appInfo.version`  L515
- `String str2 = appInfo.downloadUrl`  L520
- `CheckUpdateBean.AppInfo appInfo = bean.appInfo`  L525
- `String strSubstringBefore$default`  L554
- `HttpUrl.Companion companion = HttpUrl.INSTANCE`  L557
- `String downloadUrl = appInfo.downloadUrl`  L558
- `String downloadUrl2 = appInfo.downloadUrl`  L564
- `String downloadUrl3 = appInfo.downloadUrl`  L569
- `Object objM3074constructorimpl`  L579
- `String string`  L580
- `Result.Companion companion = Result.INSTANCE`  L598
- `TuwinApplication tuwinApplication = this`  L599
- `Result.Companion companion2 = Result.INSTANCE`  L602
- `NetworkIntent.Internet internet2 = internet`  L609
- `NetworkManager networkManager = this.networkManager`  L699
- `Runnable runnable = this.backgroundCheckRunnable`  L707
- `Object objM3074constructorimpl`  L1272
- `DeviceType deviceTypeResolve`  L1273
- `DeviceSessionManager deviceSessionManager`  L1274
- `DeviceSessionSnapshot deviceSessionSnapshotSnapshot`  L1275
- `String string`  L1276
- `String string2`  L1277
- `Ride5SessionPortHandle ride5SessionPortHandleRequire = null`  L1279
- `Result.Companion companion = Result.INSTANCE`  L1292
- `TuwinApplication tuwinApplication = this`  L1293
- `Result.Companion companion2 = Result.INSTANCE`  L1297
- `Ride3ProRecordRepositoryImpl ride3ProRecordRepositoryImpl`  L1568
- `String string`  L1569
- `Throwable thM3077exceptionOrNullimpl`  L1777
- `String stringExtra`  L1928
- `Object objM3074constructorimpl`  L1929
- `DeviceSessionManager deviceSessionManager`  L1930
- `DeviceSessionSnapshot deviceSessionSnapshotSnapshot`  L1931
- `Result.Companion companion = Result.INSTANCE`  L1942
- `TuwinApplication tuwinApplication = this`  L1943
- `Result.Companion companion2 = Result.INSTANCE`  L1947
- `Object objM3074constructorimpl`  L1969
- `Result.Companion companion = Result.INSTANCE`  L1971
- `TuwinApplication tuwinApplication = this`  L1972
- `Result.Companion companion2 = Result.INSTANCE`  L1975
- `String currentSSID`  L2004
- `String currentSSID2`  L2005
- `int i = C1870R.string.wifi_disconnected_check`  L2051

方法（65）：
- `TuwinApplication getInstance()`  L196
- `public TuwinApplication()`  L201
- `Ride3ProRequestExecutor invoke(String sessionId)`  L210 @Override
    - 体内字面量："sessionId"
- `Unit invoke()`  L222 @Override
- `void invoke2()`  L228
- `Unit invoke()`  L237 @Override
- `void invoke2()`  L243
- `Ride3ProSessionRegistry getRide3ProSessionRegistry()`  L253
- `void onCreate()`  L258 @Override
- `void initKoin()`  L276
- `Unit invoke(KoinApplication koinApplication)`  L283 @Override
- `void invoke2(KoinApplication startKoin)`  L289
    - 体内字面量："$this$startKoin"
- `void startPreConsentNetworkRuntime()`  L298
- `void initThirdLibs()`  L305
    - 体内字面量："app_session_started" · "app_version" · "version_code" · "android_version"
- `Unit invoke(String str, Long l)`  L318 @Override
- `void invoke2(String sessionId, Long l)`  L324
    - 体内字面量："sessionId"
- `Unit invoke(RouteSnapshot routeSnapshot)`  L336 @Override
- `void invoke2(RouteSnapshot route)`  L342
    - 体内字面量："route"
- `Network getCloudNetwork()`  L362
- `InternetCloudGateway getInternetCloudGateway()`  L370
- `boolean isNetworkRuntimeReady()`  L378
- `boolean isInternetRouteReady()`  L382
- `NetworkRuntime networkRuntimeOrNull()`  L387
- `void checkUpdate()`  L459
- `void showAppUpdatePromptOrDefer(CheckUpdateBean bean)`  L468
    - 体内字面量："App update prompt suppressed: already presented"
- `void tryShowPendingAppUpdatePrompt()`  L486
- `boolean canShowAppUpdatePrompt(Activity activity)`  L500
- `String appUpdatePromptKey(CheckUpdateBean bean)`  L510
- `void showAppUpdatePrompt(final Activity activity, CheckUpdateBean bean)`  L524
- `void onClick(View view)`  L541 @Override
    - 体内字面量："App update prompt failed to show"
- `void showAppUpdatePrompt$lambda$3(CheckUpdateBean.AppInfo appInfo, TuwinApplication this$0, Activity activity, View view)`  L553
- `void downloadAndInstallAppUpdate(Activity activity, String rawUrl)`  L578
- `void installDownloadedApk(Activity activity, File file)`  L679
    - 体内字面量：".fileProvider" · "android.intent.action.VIEW" · "application/vnd.android.package-archive"
- `void checkUpdateApi()`  L688
- `void requestInternetRouteUpgradeCheck()`  L692
- `void onTerminate()`  L697 @Override
- `void registerAppBackground()`  L715
    - 体内字面量："com/tuwinsmart/tuwin/TuwinApplication$registerAppBackground$1" · "Landroid/app/Application$ActivityLifecycleCallbacks;" · "onActivityCreated" · "activity" · "Landroid/app/Activity;" · "savedInstanceState" · "Landroid/os/Bundle;" · "onActivityDestroyed" · "onActivityPaused" · "onActivityResumed" · "onActivitySaveInstanceState" · "outState" · "onActivityStarted" · "onActivityStopped" · "app_release_64"
- `boolean isAppBackground()`  L1258
- `boolean isAppDefinitelyBackground()`  L1262
- `void handleRecord$default(TuwinApplication tuwinApplication, boolean z, String str, boolean z2, boolean z3, boolean z4, String str2, boolean z5, Function1 function1, int i, Object obj)`  L1267
- `void handleRecord(boolean start, String msg, boolean needLoading, boolean needToast, boolean delay, String deviceSessionId, boolean ensureStopped, Function1<? super Boolean, Unit> callback)`  L1271
- `void handleRide3ProRecord(boolean start, String msg, boolean needLoading, boolean needToast, boolean delay, String deviceSessionId, Function1<? super Boolean, Unit> callback)`  L1567
- `Ride3ProApiService invoke()`  L1590 @Override
- `Ride3ProRequestExecutor invoke()`  L1600 @Override
    - 体内字面量："getString(...)" · "Ride3Pro å½åæ§å¶å è½½æç¤ºæ¾ç¤ºå¤±è´¥" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.TuwinApplication$handleRide3ProRecord$1" · "TuwinApplication.kt" · "invokeSuspend"
- `void resumeDeviceRecordingForBackground$default(TuwinApplication tuwinApplication, boolean z, int i, Object obj)`  L1730
- `void resumeDeviceRecordingForBackground(boolean isRide3ProPlaybackPage)`  L1738
    - 体内字面量："åå°æ¢å¤å½åè·³è¿ï¼æ²¡æå·²ç¡®è®¤çè®¾å¤" · "Ride3Pro æ®éé¡µé¢è¿å¥åå°ï¼ä¸èªå¨åéå½åå½ä»¤" · "M3 ä¸éè¦åå°æ¢å¤å½åï¼è·³è¿"
- `void resumeRide3ProRecordingForBackground(final boolean isPlaybackPage)`  L1765
- `void run()`  L1768 @Override
- `void resumeRide3ProRecordingForBackground$lambda$12(boolean z, final TuwinApplication this$0)`  L1776
- `Unit invoke()`  L1787 @Override
    - 体内字面量："<anonymous>" · "Lkotlin/Result;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.TuwinApplication$resumeRide3ProRecordingForBackground$1$1$1" · "TuwinApplication.kt" · "invokeSuspend"
- `void invoke2()`  L1846
- `Unit invoke()`  L1856 @Override
    - 体内字面量："<anonymous>" · "Lkotlin/Result;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.TuwinApplication$resumeRide3ProRecordingForBackground$1$2$1" · "TuwinApplication.kt" · "invokeSuspend"
- `void invoke2()`  L1915
    - 体内字面量："Ride3Proï¼åå°æ¢å¤å½åå¤±è´¥"
- `String ride5FileManagementSession(Activity activity)`  L1927
- `boolean isRide3ProFileBrowsingActivity(Activity activity)`  L1960
- `Ride3ProFileBrowsingRecordingScope currentRide3ProFileBrowsingRecordingScope()`  L1968
- `DeviceType resolveCurrentDeviceType$default(TuwinApplication tuwinApplication, boolean z, int i, Object obj)`  L1992
- `DeviceType resolveCurrentDeviceType(boolean allowRuntimeSsidRead)`  L1999
- `void goToMainAndDisconnect()`  L2003
- `void run()`  L2035 @Override
    - 体内字面量："è®¾å¤æ­è¿æ¶å°¾å®æï¼åå¤æ¸ç©ºå¨å±è¿æ¥æï¼ssid=" · ", deviceType="
- `void goToMainAndDisconnect$lambda$18(TuwinApplication this$0, String str)`  L2049
    - 体内字面量："this$0"
- `List<ConnectedDevice> getHeartbeatCachedDevices()`  L2126
- `void syncRide3ProHeartbeat()`  L2131
- `Boolean invoke()`  L2144 @Override
- `void refreshRide3ProHeartbeat()`  L2151
### `com.tuwinsmart.tuwin.TuwinApplication$C18721`
L404 · [class] static final C18721 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（5）：
- `NetworkRuntime $runtime`  L405
- `int label`  L406
- `TuwinApplication this$0`  L407
- `int i = this.label`  L429
- `boolean z = appUpdateCheckResult instanceof AppUpdateCheckResult.NoUpdate`  L453

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L417 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L422 @Override
- `Object invokeSuspend(Object obj)`  L427 @Override
- `throw new IllegalStateException( 123 )`  L439
    - 体内字面量："App update check failed" · "App update check cancelled: " · "App update check skipped: internet route is not ready"
### `com.tuwinsmart.tuwin.TuwinApplication$C18731`
L617 · [class] static final C18731 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（7）：
- `Activity $activity`  L618
- `File $destination`  L619
- `TransferRequest $request`  L620
- `NetworkRuntime $runtime`  L621
- `int label`  L622
- `TuwinApplication this$0`  L623
- `int i = this.label`  L648

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L636 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L641 @Override
- `Object invokeSuspend(Object obj)`  L646 @Override
- `throw new IllegalStateException( 164 )`  L658
    - 体内字面量："App update download failed" · "App update download cancelled: "
### `com.tuwinsmart.tuwin.TuwinApplication$C18742`
L2062 · [class] static final C18742 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（3）：
- `NetworkRuntime $networkRuntime`  L2063
- `int label`  L2064
- `int i = this.label`  L2085

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L2073 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L2078 @Override
- `Object invokeSuspend(Object obj)`  L2083 @Override
- `throw new IllegalStateException( 309 )`  L2094
### `com.tuwinsmart.tuwin.TuwinApplication$C18751`
L1369 · [class] static final C18751 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（20）：
- `Function1<Boolean, Unit> $callback`  L1370
- `boolean $delay`  L1371
- `boolean $ensureStopped`  L1372
- `Ride5SessionPortHandle $handle`  L1373
- `boolean $needLoading`  L1374
- `boolean $needToast`  L1375
- `Ride5SessionPortProvider $provider`  L1376
- `boolean $start`  L1377
- `int label`  L1378
- `TuwinApplication this$0`  L1379
- `Function1<Boolean, Unit> function1`  L1416
- `BaseActivity baseActivityCurrentActivity`  L1417
- `int i`  L1418
- `int i2 = this.label`  L1420
- `TuwinApplication tuwinApplication = this.this$0`  L1437
- `String str = this.$start ? C3077cm.f1942r : "stop"`  L1470
- `TuwinApplication tuwinApplication2 = this.this$0`  L1485
- `TuwinApplication tuwinApplication3 = this.this$0`  L1506
- `Function1<Boolean, Unit> function2 = this.$callback`  L1528
- `Function1<Boolean, Unit> function3 = this.$callback`  L1545

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1397 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1402 @Override
- `Object invokeSuspend(Object obj)`  L1415 @Override
- `throw new IllegalStateException( 237 )`  L1429
    - 体内字面量："RIDE5 recording result belongs to a stale route"
### `com.tuwinsmart.tuwin.TuwinApplication$C18761`
L1628 · [class] static final C18761 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（16）：
- `Function1<Boolean, Unit> $callback`  L1629
- `boolean $delay`  L1630
- `boolean $needLoading`  L1631
- `boolean $needToast`  L1632
- `Ride3ProRecordRepositoryImpl $recordRepository`  L1633
- `boolean $start`  L1634
- `int label`  L1635
- `TuwinApplication this$0`  L1636
- `int i = this.label`  L1664
- `boolean z = this.$start`  L1689
- `boolean z2 = this.$needToast`  L1690
- `TuwinApplication tuwinApplication = this.this$0`  L1691
- `boolean z3 = this.$delay`  L1692
- `Function1<Boolean, Unit> function1 = this.$callback`  L1693
- `boolean z4 = this.$start`  L1710
- `Function1<Boolean, Unit> function2 = this.$callback`  L1711

方法（6）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1652 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1657 @Override
- `Object invokeSuspend(Object obj)`  L1662 @Override
- `throw new IllegalStateException( 261 )`  L1674
    - 体内字面量："Ride3Pro å½åæ§å¶å è½½æç¤ºå³é­å¤±è´¥"
- `void run()`  L1702 @Override
- `void invokeSuspend$lambda$1$lambda$0(Function1 function1)`  L1723
### `com.tuwinsmart.tuwin.TuwinApplication$C18811`
L729 · [class] public static final C18811 · implements `Application.ActivityLifecycleCallbacks` · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（18）：
- `int i`  L1030
- `boolean z`  L1031
- `NetworkManager networkManager`  L1032
- `Ride3ProFileBrowsingRecordingLifecycle ride3ProFileBrowsingRecordingLifecycle = TuwinApplication.this.ride3ProFileBrowsingRecordingLifecycle`  L1043
- `TuwinApplication tuwinApplication = TuwinApplication.this`  L1045
- `Runnable runnable = TuwinApplication.this.backgroundCheckRunnable`  L1074
- `TuwinApplication tuwinApplication2 = TuwinApplication.this`  L1076
- `Object obj = TuwinApplication.this.networkManager`  L1081
- `boolean z`  L1120
- `DeviceType deviceType`  L1121
- `Intent intent`  L1122
- `boolean z2 = activity instanceof DownloadListActivity`  L1127
- `String stringExtra2 = null`  L1138
- `DeviceType deviceType2 = deviceType`  L1148
- `boolean z3 = activity instanceof Ride3ProDailyDetailActivity`  L1149
- `TuwinApplication tuwinApplication = TuwinApplication.this`  L1158
- `Handler handler = TuwinApplication.this.backgroundCheckHandler`  L1165
- `Runnable runnable = TuwinApplication.this.backgroundCheckRunnable`  L1166

方法（17）：
- `void onActivitySaveInstanceState(Activity activity, Bundle outState)`  L731 @Override
    - 体内字面量："activity" · "outState"
- `void onActivityCreated(Activity activity, Bundle savedInstanceState)`  L740 @Override
    - 体内字面量："activity" · " created"
- `void onActivityStarted(Activity activity)`  L1029 @Override
- `Unit invoke(Ride3ProFileBrowsingRecordingScope ride3ProFileBrowsingRecordingScope)`  L1052 @Override
- `void invoke2(Ride3ProFileBrowsingRecordingScope scope)`  L1058
    - 体内字面量："scope" · "Ride3Pro æä»¶æµè§é¡µè¿ååå°ï¼åæ­¢åå°æ¢å¤çå½å" · "Ride5 æä»¶ç®¡çé¡µè¿ååå°ï¼åæ­¢åå°æ¢å¤çå½å"
- `void onActivityResumed(Activity activity)`  L1106 @Override
    - 体内字面量："activity" · " resumed"
- `void onActivityPaused(Activity activity)`  L1112 @Override
    - 体内字面量："activity" · " paused"
- `void onActivityStopped(Activity activity)`  L1119 @Override
- `void run()`  L1161 @Override
- `void onActivityStopped$lambda$2(final TuwinApplication this$0, boolean z, boolean z2, String str, boolean z3, final DeviceType stoppedRide3ProDownloadDeviceType)`  L1174
    - 体内字面量："this$0" · "$stoppedRide3ProDownloadDeviceType" · "Background check cancelled: activityReferences=" · ", isChangingConfigurations=" · "appè¿å¥åå°" · "Ride3Pro ä¸è½½é¡µè¿å¥åå°ï¼ä¸­æ­æ´»å¨ä»»å¡å¹¶ä¿çå¤±è´¥è®°å½åæ¢å¤å½å"
- `Unit invoke()`  L1191 @Override
- `void invoke2()`  L1197
- `Unit invoke()`  L1206 @Override
- `void invoke2()`  L1212
    - 体内字面量："è¿æ¥éç½æµç¨ä¸­ï¼è·³è¿åå°èªå¨å½åå¤ç" · "Ride3Pro åæ¾åé¨è¿åä¸­ï¼è·³è¿åå°èªå¨æ¢å¤å½å"
- `Unit invoke(Ride3ProFileBrowsingRecordingScope ride3ProFileBrowsingRecordingScope)`  L1227 @Override
- `void invoke2(Ride3ProFileBrowsingRecordingScope scope)`  L1233
    - 体内字面量："scope" · "Ride3Pro æä»¶æµè§é¡µè¿å¥åå°ï¼æ¢å¤å½å" · "Ride5 æä»¶ç®¡çé¡µè¿å¥åå°ï¼æ¢å¤å½å" · "å½åæ¯tuwinçWIFIï¼æ¢å¤å½å"
- `void onActivityDestroyed(Activity activity)`  L1252 @Override
    - 体内字面量："activity" · " destroyed"
### `com.tuwinsmart.tuwin.TuwinApplication$C18831`
L1796 · [class] static final C18831 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（4）：
- `int label`  L1797
- `TuwinApplication this$0`  L1798
- `Object objM2864startRecordingIoAF18A`  L1823
- `int i = this.label`  L1825

方法（5）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1807 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation)`  L1812 @Override
- `Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation)`  L1817
- `Object invokeSuspend(Object obj)`  L1822 @Override
- `throw new IllegalStateException( 278 )`  L1835
### `com.tuwinsmart.tuwin.TuwinApplication$C18841`
L1865 · [class] static final C18841 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（4）：
- `int label`  L1866
- `TuwinApplication this$0`  L1867
- `Object objM2865startRecordingInPreviewModeIoAF18A`  L1892
- `int i = this.label`  L1894

方法（5）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1876 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation)`  L1881 @Override
- `Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation)`  L1886
- `Object invokeSuspend(Object obj)`  L1891 @Override
- `throw new IllegalStateException( 287 )`  L1904
### `com.tuwinsmart.tuwin.TuwinApplication$Companion`
L2104 · [class] public static final Companion · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（1）：
- `TuwinApplication tuwinApplication = TuwinApplication.instance`  L2117

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L2105
- `void getInstance$annotations()`  L2110 
- `private Companion()`  L2113
- `TuwinApplication getInstance()`  L2116
### `com.tuwinsmart.tuwin.TuwinApplication$handleRide3ProRecord$1$result$1`
L20 · [class] final TuwinApplication$handleRide3ProRecord$1$result$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · `com/tuwinsmart/tuwin/TuwinApplication$handleRide3ProRecord$1$result$1.java`
注解：

字段/常量（5）：
- `Ride3ProRecordRepositoryImpl $recordRepository`  L21
- `boolean $start`  L22
- `int label`  L23
- `Object objM2866stopRecordingIoAF18A`  L49
- `int i = this.label`  L51

方法（5）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L33 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation)`  L38 @Override
- `Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation)`  L43
- `Object invokeSuspend(Object obj)`  L48 @Override
- `throw new IllegalStateException( 8 )`  L69
### `com.tuwinsmart.tuwin.TuwinApplication$WhenMappings`
L171 · [class] public WhenMappings · `com/tuwinsmart/tuwin/TuwinApplication.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L172