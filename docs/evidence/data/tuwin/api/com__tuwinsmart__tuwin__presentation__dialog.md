# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.presentation.dialog

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 20 个文件 / 55 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.presentation.dialog.CommonDialog`
L27 · [class] public final CommonDialog · extends `BaseDialogFragment` · `com/tuwinsmart/tuwin/presentation/dialog/CommonDialog.java`
注解：

字段/常量（34）：
- `DialogCommonBinding binding`  L31
- `Function0<Unit> primaryClickListener`  L32
- `Function0<Unit> secondClickListener`  L33
- `DialogCommonBinding dialogCommonBinding = null`  L56
- `DialogCommonBinding dialogCommonBinding2 = this.binding`  L62
- `DialogCommonBinding dialogCommonBinding3 = this.binding`  L68
- `DialogCommonBinding dialogCommonBinding4 = this.binding`  L74
- `DialogCommonBinding dialogCommonBinding5 = this.binding`  L80
- `DialogCommonBinding dialogCommonBinding6 = this.binding`  L86
- `Window window`  L99
- `Unit unit`  L111
- `Unit unit2`  L112
- `Unit unit3`  L113
- `String string`  L114
- `String string2`  L115
- `String string3`  L116
- `DialogCommonBinding dialogCommonBinding = this.binding`  L117
- `DialogCommonBinding dialogCommonBinding2 = null`  L118
- `TextView textView = dialogCommonBinding.tvTitle`  L123
- `DialogCommonBinding dialogCommonBinding3 = this.binding`  L130
- `DialogCommonBinding dialogCommonBinding4 = this.binding`  L136
- `DialogCommonBinding dialogCommonBinding5 = this.binding`  L145
- `DialogCommonBinding dialogCommonBinding6 = this.binding`  L156
- `DialogCommonBinding dialogCommonBinding7 = this.binding`  L162
- `DialogCommonBinding dialogCommonBinding8 = this.binding`  L168
- `BLTextView btnPrimary = dialogCommonBinding8.btnPrimary`  L173
- `DialogCommonBinding dialogCommonBinding9 = this.binding`  L184
- `DialogCommonBinding dialogCommonBinding10 = this.binding`  L195
- `DialogCommonBinding dialogCommonBinding11 = this.binding`  L201
- `DialogCommonBinding dialogCommonBinding12 = this.binding`  L207
- `BLTextView btnSecond = dialogCommonBinding12.btnSecond`  L212
- `DialogCommonBinding dialogCommonBinding13 = this.binding`  L223
- `Function0<Unit> function0 = this$0.primaryClickListener`  L244
- `Function0<Unit> function0 = this$0.secondClickListener`  L254

方法（12）：
- `Function0<Unit> getPrimaryClickListener()`  L35
- `void setPrimaryClickListener(Function0<Unit> function0)`  L39
- `Function0<Unit> getSecondClickListener()`  L43
- `void setSecondClickListener(Function0<Unit> function0)`  L47
- `View getContentRoot()`  L52 @Override
    - 体内字面量："inflate(...)"
- `void onStart()`  L98 @Override
- `void initView()`  L110 @Override
- `void onClick(View view)`  L177 @Override
- `void onClick(View view)`  L216 @Override
- `void initView$lambda$4$lambda$3(CommonDialog this$0, View view)`  L242
    - 体内字面量："this$0"
- `void initView$lambda$7$lambda$6(CommonDialog this$0, View view)`  L252
    - 体内字面量："this$0"
- `void onDestroyView()`  L262 @Override
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/dialog/CommonDialog$Companion;" · "()V" · "showDialog" · "fragmentManager" · "Landroidx/fragment/app/FragmentManager;" · "title" · "content" · "primaryText" · "primaryClickListener" · "Lkotlin/Function0;" · "secondText" · "secondClickListener" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.dialog.CommonDialog$Companion`
L268 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/dialog/CommonDialog.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L269
- `private Companion()`  L273
- `void showDialog(FragmentManager fragmentManager, String title, String content, String primaryText, Function0<Unit> primaryClickListener, String secondText, Function0<Unit> secondClickListener)`  L276
    - 体内字面量："fragmentManager" · "title" · "title" · "content" · "primaryText" · "secondText" · "CommonDialog"
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2`
L106 · [class] public final ConnectDialog2 · extends `BaseDialogFragment` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（122）：
- `String ARG_DEVICE_TYPE = "arg_device_type"`  L107
- `String ARG_WIFI_BSSID = "arg_wifi_bssid"`  L108
- `String ARG_WIFI_PWD = "arg_wifi_pwd"`  L109
- `String ARG_WIFI_SSID = "arg_wifi_ssid"`  L110
- `String CONNECTION_PROGRESS_TAG = "ConnectionProgressDialog"`  L111
- `String DEVICE_WIFI_SCAN_TAG = "DeviceWifiScanDialog"`  L115
- `long RECONNECT_CONNECTION_FLOW_TIMEOUT_MS = 8000`  L116
- `float WIFI_DISABLED_GUIDE_PANEL_RATIO = 0.44f`  L117
- `float WIFI_DISABLED_PANEL_SCREEN_RATIO = 0.5f`  L118
- `int WIFI_GUIDE_SOURCE_HEIGHT = 696`  L119
- `int WIFI_GUIDE_SOURCE_WIDTH = 674`  L120
- `DialogConnect2Binding binding`  L121
- `ConnectionProgressDialog connectionProgressDialog`  L122
- `DeviceConfig deviceConfig`  L123
- `Lazy deviceRepository`  L126
- `DeviceWifiScanDialog deviceWifiScanDialog`  L127
- `boolean pendingOpenWifiSettingsAfterLocationEnabled`  L128
- `String selectedBssid`  L129
- `String selectedSsid`  L130
- `Lazy viewModel`  L133
- `ActivityResultLauncher<String[]> wifiPermissionLauncher`  L134
- `ActivityResultLauncher<Intent> wifiSettingsLauncher`  L135
- `ConnectDialog2 connectDialog2 = this`  L246
- `Qualifier qualifier = null`  L254
- `Function0 function1 = null`  L255
- `Function0 function2 = null`  L256
- `CreationExtras defaultViewModelCreationExtras`  L262
- `Fragment fragment = connectDialog2`  L263
- `Qualifier qualifier2 = qualifier`  L264
- `Function0 function3 = function0`  L265
- `Function0 function4 = function1`  L266
- `Function0 function5 = function2`  L267
- `ConnectDialog2 connectDialog3 = this`  L276
- `LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED`  L277
- `Qualifier qualifier2 = null`  L278
- `Object[] objArr = 0 == true ? 1 : 0`  L279
- `ComponentCallbacks componentCallbacks = connectDialog3`  L284
- `DeviceConfig deviceConfig = null`  L376
- `String str = string`  L378
- `DeviceConfig deviceConfig2 = this.deviceConfig`  L382
- `DeviceConfig deviceConfig = null`  L393
- `String str = string`  L395
- `DeviceConfig deviceConfig2 = this.deviceConfig`  L399
- `Window window`  L437
- `float f`  L438
- `DialogConnect2Binding dialogConnect2Binding = this.binding`  L445
- `ConnectUtil connectUtil = ConnectUtil.INSTANCE`  L463
- `DialogConnect2Binding dialogConnect2Binding = this.binding`  L477
- `DialogConnect2Binding dialogConnect2Binding2 = null`  L478
- `DialogConnect2Binding dialogConnect2Binding3 = this.binding`  L485
- `ImageView imageView = dialogConnect2Binding3.wifiDisabledIllustration`  L490
- `DialogConnect2Binding dialogConnect2Binding4 = this.binding`  L491
- `DialogConnect2Binding dialogConnect2Binding = this.binding`  L505
- `DialogConnect2Binding dialogConnect2Binding2 = null`  L506
- `DialogConnect2Binding dialogConnect2Binding3 = this.binding`  L512
- `DialogConnect2Binding dialogConnect2Binding = this.binding`  L536
- `DialogConnect2Binding dialogConnect2Binding = this.binding`  L560
- `ConnectUtil connectUtil = ConnectUtil.INSTANCE`  L567
- `DeviceConfig deviceConfig = this$0.deviceConfig`  L887
- `String string`  L928
- `C23981 c23981`  L1132
- `Object value`  L1133
- `ConnectDialog2 connectDialog2`  L1134
- `M3DeviceAttr m3DeviceAttr`  L1135
- `Object obj = c23981.result`  L1146
- `int i = c23981.label`  L1148
- `FragmentActivity fragmentActivity = activity`  L1222
- `Bundle arguments`  L1264
- `String str`  L1265
- `DeviceConfig deviceConfig`  L1266
- `ConnectUtil connectUtil`  L1267
- `DeviceConfig deviceConfig2`  L1268
- `DeviceConfig deviceConfig3 = null`  L1270
- `String wifiNamePattern = this.selectedSsid`  L1274
- `DeviceConfig deviceConfig = this.deviceConfig`  L1381
- `int i`  L1392
- `DeviceConfig deviceConfig = this.deviceConfig`  L1393
- `String string`  L1418
- `String strResolveWifiPwd`  L1419
- `DeviceConfig deviceConfig`  L1420
- `String str`  L1421
- `String str5 = str4 != null ? str4 : "<binary/metadata>"`  L1428
- `DeviceConfig deviceConfig2 = this.deviceConfig`  L1433
- `DeviceConfig deviceConfig3 = this.deviceConfig`  L1463
- `ConnectUtil connectUtil = ConnectUtil.INSTANCE`  L1476
- `ConnectUtil connectUtil = ConnectUtil.INSTANCE`  L1488
- `ConnectUtil connectUtil2 = ConnectUtil.INSTANCE`  L1496
- `DeviceConfig deviceConfig = this.deviceConfig`  L1498
- `Window window`  L1515
- `DialogConnect2Binding dialogConnect2Binding = this.binding`  L1516
- `Window window`  L1530
- `DialogConnect2Binding dialogConnect2Binding = this.binding`  L1531
- `ConnectUtil connectUtil = ConnectUtil.INSTANCE`  L1560
- `ArrayList arrayList2 = arrayList`  L1575
- `DeviceConfig deviceConfig = null`  L1584
- `DeviceConfig deviceConfig2 = this.deviceConfig`  L1588
- `String str = ssid`  L1622
- `DeviceConfig deviceConfig = null`  L1623
- `DeviceConfig deviceConfig2 = this.deviceConfig`  L1627
- `DeviceConfig deviceConfig3 = this.deviceConfig`  L1639
- `DeviceConfig deviceConfig4 = this.deviceConfig`  L1649
- `DeviceConfig deviceConfig = null`  L1660
- `DeviceConfig deviceConfig2 = this.deviceConfig`  L1663
- `DeviceConfig deviceConfig3 = this.deviceConfig`  L1673
- `ConnectUtil connectUtil = ConnectUtil.INSTANCE`  L1684
- `int iResolveRideConnectionStringRes`  L1729
- `int iResolveRideConnectionStringRes`  L1779
- `DeviceConfig deviceConfig = this.deviceConfig`  L1829
- `ConnectionProgressDialog connectionProgressDialog = this.connectionProgressDialog`  L1866
- `ConnectionProgressDialog connectionProgressDialog = this.connectionProgressDialog`  L1883
- `DeviceWifiScanDialog deviceWifiScanDialog = this.deviceWifiScanDialog`  L1891
- `DeviceWifiScanDialog deviceWifiScanDialog = this.deviceWifiScanDialog`  L1907
- `String str = currentSsid`  L1925
- `ConnectUtil connectUtil = ConnectUtil.INSTANCE`  L1934
- `DeviceConfig deviceConfig = this.deviceConfig`  L1936
- `String str`  L1954
- `String str2`  L1955
- `String string = this.selectedSsid`  L1963
- `DeviceConfig deviceConfig = null`  L1964
- `String string2 = this.selectedBssid`  L1976
- `ConnectUtil connectUtil = ConnectUtil.INSTANCE`  L1988
- `DeviceConfig deviceConfig2 = this.deviceConfig`  L1989

方法（78）：
- `void showConnectionFailureDialog$lambda$7(View view)`  L241
- `public ConnectDialog2()`  L245
- `Fragment invoke()`  L250 @Override
- `ConnectDialogViewModel invoke()`  L261 @Override
- `DeviceRepository invoke()`  L283 @Override
- `void onActivityResult(Object obj)`  L290 @Override
    - 体内字面量："registerForActivityResult(...)"
- `void onActivityResult(Object obj)`  L298 @Override
    - 体内字面量："registerForActivityResult(...)"
- `ConnectDialogViewModel getViewModel()`  L307
- `DeviceRepository getDeviceRepository()`  L311
- `void wifiSettingsLauncher$lambda$0(ConnectDialog2 this$0, ActivityResult it)`  L316
    - 体内字面量："this$0" · "it"
- `void wifiPermissionLauncher$lambda$1(ConnectDialog2 this$0, Map it)`  L323
    - 体内字面量："this$0" · "it" · "Lcom/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2$Companion;" · "()V" · "ARG_DEVICE_TYPE" · "ARG_WIFI_BSSID" · "ARG_WIFI_PWD" · "ARG_WIFI_SSID" · "CONNECTION_PROGRESS_TAG" · "DEVICE_WIFI_SCAN_TAG" · "RECONNECT_CONNECTION_FLOW_TIMEOUT_MS" · "WIFI_DISABLED_GUIDE_PANEL_RATIO" · "WIFI_DISABLED_PANEL_SCREEN_RATIO" · "WIFI_GUIDE_SOURCE_HEIGHT" · "WIFI_GUIDE_SOURCE_WIDTH" · "newInstance" · "Lcom/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "pwd" · "app_release_64"
- `String resolveWifiSsid()`  L374
- `String resolveWifiPwd()`  L391
- `void onCreate(Bundle savedInstanceState)`  L409 @Override
- `View getContentRoot()`  L421 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onStart()`  L436 @Override
- `void updateWifiDisabledLayoutSize()`  L472
- `void initView()`  L504 @Override
- `void setupButtons()`  L535
- `void onClick(View view)`  L543 @Override
- `void setupButtons$lambda$4(ConnectDialog2 this$0, View view)`  L550
    - 体内字面量："this$0"
- `void onResume()`  L558 @Override
- `void observeConnectState()`  L657
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$observeWifiScanState$1" · "ConnectDialog2.kt" · "invokeSuspend"
- `void observeWifiScanState()`  L741
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$observeWifiScanEvents$1" · "ConnectDialog2.kt" · "invokeSuspend"
- `void observeWifiScanEvents()`  L843
- `void listenDeviceWifiScanResults()`  L847
- `void onFragmentResult(String str, Bundle bundle)`  L850 @Override
- `void listenDeviceWifiScanResults$lambda$5(ConnectDialog2 this$0, String str, Bundle bundle)`  L858
    - 体内字面量："this$0" · "<anonymous parameter 0>" · "bundle" · "action"
- `void handleWifiScanState(DeviceWifiScanState state)`  L908
- `void handleConnectState(ConnectState state)`  L927
- `void handleConnectionSuccess(HashMap<String, String> deviceInfo)`  L1071
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$handleM3ConnectionSuccess$1" · "ConnectDialog2.kt" · "invokeSuspend"
- `void handleM3ConnectionSuccess(M3ConnectionResult result)`  L1125
- `Object saveM3DeviceInfo(M3ConnectionResult m3ConnectionResult, Continuation<? super Unit> continuation)`  L1131
- `void handleConnectionFailed()`  L1200
- `void handleConnectionError()`  L1205
- `void showConnectionFailureDialog()`  L1209
- `Unit invoke()`  L1232 @Override
- `void invoke2()`  L1238
- `void onClick(View view)`  L1246 @Override
- `SpannableString buildConnectionFailureMessage(final Context context, final Function0<Unit> onHelpClick)`  L1263
- `void onClick(View widget)`  L1365 @Override
    - 体内字面量："widget"
- `void updateDrawState(TextPaint ds)`  L1371 @Override
    - 体内字面量："ds"
- `String resolveHelpUrl(Context context)`  L1380
- `String resolveHelpTitle(Context context)`  L1391
- `Object saveDeviceInfo(HashMap<String, String> map, Continuation<? super Unit> continuation)`  L1417
- `void beginConnectionFlow()`  L1475
- `void connectWhenLocationReady()`  L1487
- `void showWifiDisabledPrompt()`  L1514
- `void hideWifiDisabledPrompt()`  L1529
- `void startWifiSpecifierWhenPermissionsReady()`  L1555
- `void proceedToScanOrExactConnect()`  L1583
- `boolean isAddDeviceFlow()`  L1603
- `void startWifiSpecifierConnection$default(ConnectDialog2 connectDialog2, String str, String str2, int i, Object obj)`  L1609
- `void startWifiSpecifierConnection(String ssid, String bssid)`  L1621
- `void detectConnectionForCurrentFlow()`  L1658
- `void handleWifiSpecifierFailure()`  L1682
- `void fallbackToSystemWifiSettings()`  L1698
- `boolean hasWifiSpecifierPermissions()`  L1705
- `List<String> requiredWifiSpecifierPermissions()`  L1719
    - 体内字面量："android.permission.NEARBY_WIFI_DEVICES"
- `String getConnectionProgressText(ConnectionProgress progress)`  L1728
- `String getConnectionStepName(ConnectionProgress progress)`  L1778
- `int resolveRideConnectionStringRes(int ride3ProResId, int ride6ResId)`  L1828
- `void showConnectionRunning(String message)`  L1837
    - 体内字面量："getString(...)"
- `void showConnectionFailed(String message)`  L1844
    - 体内字面量："getString(...)"
- `void showConnectionRetrying(String message)`  L1851
    - 体内字面量："getString(...)"
- `void showConnectionWarning(String message)`  L1858
    - 体内字面量："getString(...)"
- `ConnectionProgressDialog getOrCreateConnectionProgressDialog()`  L1865
- `void hideConnectionProgress()`  L1882
- `DeviceWifiScanDialog getOrCreateWifiScanDialog()`  L1890
- `void hideWifiScanDialog()`  L1906
- `boolean shouldDetectCurrentConnection(String currentSsid)`  L1919
- `void openSystemWifiSettings()`  L1948
    - 体内字面量："android.settings.WIFI_SETTINGS"
- `void handleSystemWifiSettingsReturn()`  L1953
- `void showEnableLocationServiceDialog()`  L2005
- `void onClick(View view)`  L2017 @Override
- `void showEnableLocationServiceDialog$lambda$20(ConnectDialog2 this$0, View view)`  L2024
    - 体内字面量："this$0" · "android.settings.LOCATION_SOURCE_SETTINGS"
- `void copyToClipboard(String text)`  L2035
    - 体内字面量："clipboard" · "null cannot be cast to non-null type android.content.ClipboardManager"
- `void onDestroyView()`  L2043 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23931`
L1017 · [class] static final C23931 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（3）：
- `HashMap<String, String> $deviceInfo`  L1018
- `int label`  L1019
- `int i = this.label`  L1040

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1028 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1033 @Override
- `Object invokeSuspend(Object obj)`  L1038 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23941`
L1079 · [class] static final C23941 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（3）：
- `M3ConnectionResult $result`  L1080
- `int label`  L1081
- `int i = this.label`  L1102

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1090 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1095 @Override
- `Object invokeSuspend(Object obj)`  L1100 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23951`
L581 · [class] static final C23951 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（2）：
- `int label`  L582
- `int i = this.label`  L640

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L589 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L594 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$observeConnectState$1$1" · "ConnectDialog2.kt" · "invokeSuspend"
- `Object invokeSuspend(Object obj)`  L638 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23951$AnonymousClass1`
L602 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<ConnectState, Continuation<? super Unit>, Object>` · implements `Function2<ConnectState, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（3）：
- `Object L$0`  L603
- `int label`  L604
- `ConnectDialog2 this$0`  L605

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L614 @Override
- `Object invoke(ConnectState connectState, Continuation<? super Unit> continuation)`  L621 @Override
- `Object invokeSuspend(Object obj)`  L626 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23961`
L749 · [class] static final C23961 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（2）：
- `int label`  L750
- `int i = this.label`  L826

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L757 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L762 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel$WifiScanUiEvent;" · "com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$observeWifiScanEvents$1$1" · "ConnectDialog2.kt" · "invokeSuspend"
- `Object invokeSuspend(Object obj)`  L824 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23961$AnonymousClass1`
L770 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<ConnectDialogViewModel.WifiScanUiEvent, Continuation<? super Unit>, Object>` · implements `Function2<ConnectDialogViewModel.WifiScanUiEvent, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（3）：
- `Object L$0`  L771
- `int label`  L772
- `ConnectDialog2 this$0`  L773

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L798 @Override
- `Object invoke(ConnectDialogViewModel.WifiScanUiEvent wifiScanUiEvent, Continuation<? super Unit> continuation)`  L805 @Override
- `Object invokeSuspend(Object obj)`  L810 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23961$AnonymousClass1$WhenMappings`
L778 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L779
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23971`
L665 · [class] static final C23971 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（2）：
- `int label`  L666
- `int i = this.label`  L724

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L673 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L678 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState;" · "com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$observeWifiScanState$1$1" · "ConnectDialog2.kt" · "invokeSuspend"
- `Object invokeSuspend(Object obj)`  L722 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23971$AnonymousClass1`
L686 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<DeviceWifiScanState, Continuation<? super Unit>, Object>` · implements `Function2<DeviceWifiScanState, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（3）：
- `Object L$0`  L687
- `int label`  L688
- `ConnectDialog2 this$0`  L689

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L698 @Override
- `Object invoke(DeviceWifiScanState deviceWifiScanState, Continuation<? super Unit> continuation)`  L705 @Override
- `Object invokeSuspend(Object obj)`  L710 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$C23981`
L223 · [class] static final C23981 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（3）：
- `Object L$0`  L224
- `int label`  L225
- `Object result`  L226

方法（1）：
- `Object invokeSuspend(Object obj)`  L233 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$Companion`
L337 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L338
- `private Companion()`  L342
- `ConnectDialog2 newInstance$default(Companion companion, DeviceType deviceType, String str, String str2, String str3, int i, Object obj)`  L345
- `ConnectDialog2 newInstance(DeviceType deviceType, String ssid, String pwd, String bssid)`  L361
    - 体内字面量："deviceType"
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2$WhenMappings`
L139 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialog2.java`
注解：

字段/常量（2）：
- `int[] $EnumSwitchMapping$0`  L140
- `int[] $EnumSwitchMapping$1`  L141
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogDeviceInfoMapper`
L13 · [class] public final ConnectDialogDeviceInfoMapper · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogDeviceInfoMapper.java`
注解：

方法（2）：
- `private ConnectDialogDeviceInfoMapper()`  L16
- `HashMap<String, String> map(ConnectedDevice device)`  L19
    - 体内字面量："device" · "devid" · "softversion" · "boardversion" · "model" · "product" · "apBssid" · "pwd" · "pwd" · "sessionId"
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel`
L63 · [class] public final ConnectDialogViewModel · extends `ViewModel` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

字段/常量（85）：
- `long DEFAULT_CONNECTION_FLOW_TIMEOUT_MS = 30000`  L64
- `long FAILURE_NOTICE_MS = 500`  L65
- `long RETRY_NOTICE_MS = 500`  L66
- `int RIDE3PRO_MAX_ATTEMPTS = 3`  L67
- `MutableStateFlow<ConnectState> _connectState`  L68
- `MutableSharedFlow<WifiScanUiEvent> _wifiScanEvents`  L69
- `MutableStateFlow<DeviceWifiScanState> _wifiScanState`  L70
- `StateFlow<ConnectState> connectState`  L71
- `long connectionFlowTimeoutMs`  L72
- `Job connectionJob`  L73
- `DeviceRepository deviceRepository`  L74
- `DeviceWifiScanner deviceWifiScanner`  L75
- `RefreshConnectionUseCase refreshConnectionUseCase`  L76
- `Job scanJob`  L77
- `boolean userInitiatedConnection`  L78
- `DeviceWifiConnectionCoordinator wifiConnectionCoordinator`  L79
- `SharedFlow<WifiScanUiEvent> wifiScanEvents`  L80
- `StateFlow<DeviceWifiScanState> wifiScanState`  L81
- `Job job = this.scanJob`  L201
- `Job job = this.scanJob`  L284
- `Job job = this.connectionJob`  L382
- `ConnectDialogViewModel$retryDetectRide3Pro$1 connectDialogViewModel$retryDetectRide3Pro$1`  L596
- `ConnectDialogViewModel connectDialogViewModel`  L597
- `ConnectDialogViewModel$retryDetectRide3Pro$1 connectDialogViewModel$retryDetectRide3Pro$2`  L598
- `ConnectDialogViewModel connectDialogViewModel2`  L599
- `Ref.ObjectRef objectRef`  L600
- `int i`  L601
- `int i2`  L602
- `Ref.ObjectRef objectRef2`  L603
- `ConnectedDevice connectedDevice2`  L604
- `ConnectedDevice connectedDevice3`  L605
- `Ref.ObjectRef objectRef3`  L606
- `Ref.ObjectRef objectRef4`  L607
- `int i3`  L608
- `int i4`  L609
- `int i5`  L610
- `ConnectDialogViewModel connectDialogViewModel3`  L611
- `boolean z`  L612
- `int i6`  L613
- `?? r4`  L614
- `boolean z2`  L615
- `Exception exc`  L616
- `int i7`  L617
- `int i8`  L618
- `Object value`  L619
- `Throwable th`  L620
- `?? r0`  L621
- `CharSequence charSequence`  L622
- `?? r5`  L623
- `int i9`  L624
- `ConnectState value2`  L625
- `ConnectState.StepFailed stepFailed`  L626
- `ConnectionProgress connectionProgress`  L627
- `String message`  L628
- `Exception exc2`  L629
- `ConnectDialogViewModel connectDialogViewModel4`  L630
- `int i10`  L631
- `Ref.ObjectRef objectRef5`  L632
- `Object objM2881invokehUnOzRk`  L633
- `int i11`  L634
- `Object obj = connectDialogViewModel$retryDetectRide3Pro$1.result`  L648
- `int i12 = connectDialogViewModel$retryDetectRide3Pro$1.label`  L650
- `Continuation continuation2 = null`  L651
- `int i13 = 1`  L652
- `?? r9 = 1`  L653
- `RefreshConnectionUseCase refreshConnectionUseCase = connectDialogViewModel2.refreshConnectionUseCase`  L667
- `Result.Companion companion = Result.INSTANCE`  L768
- `Result.Companion companion2 = Result.INSTANCE`  L775
- `int i14 = connectDialogViewModel$retryDetectRide3Pro$1.I$2`  L783
- `int i15 = connectDialogViewModel$retryDetectRide3Pro$1.I$1`  L784
- `int i16 = connectDialogViewModel$retryDetectRide3Pro$1.I$0`  L785
- `Result.Companion companion3 = Result.INSTANCE`  L859
- `Result.Companion companion4 = Result.INSTANCE`  L888
- `int i17 = connectDialogViewModel$retryDetectRide3Pro$1.I$0`  L918
- `int i18 = i7 + i8`  L932
- `Ref.ObjectRef objectRef12 = objectRef3`  L935
- `RefreshConnectionUseCase refreshConnectionUseCase2 = connectDialogViewModel2.refreshConnectionUseCase`  L939
- `Result.Companion companion5 = Result.INSTANCE`  L1040
- `Result.Companion companion6 = Result.INSTANCE`  L1047
- `Job job = this.connectionJob`  L1158
- `Object objM3074constructorimpl`  L1277
- `Result.Companion companion = Result.INSTANCE`  L1279
- `ConnectDialogViewModel connectDialogViewModel = this`  L1280
- `Result.Companion companion2 = Result.INSTANCE`  L1284
- `Job job = this.connectionJob`  L1299

方法（27）：
- ` ConnectDialogViewModel(RefreshConnectionUseCase refreshConnectionUseCase, DeviceRepository deviceRepository, DeviceWifiConnectionCoordinator deviceWifiConnectionCoordinator, DeviceWifiScanner deviceWifiScanner, long j, int i, DefaultConstructorMarker defaultConstructorMarker)`  L122
- `public ConnectDialogViewModel(RefreshConnectionUseCase refreshConnectionUseCase, DeviceRepository deviceRepository, DeviceWifiConnectionCoordinator wifiConnectionCoordinator, DeviceWifiScanner deviceWifiScanner, long j)`  L126
    - 体内字面量："refreshConnectionUseCase" · "deviceRepository" · "wifiConnectionCoordinator" · "deviceWifiScanner"
- `StateFlow<ConnectState> getConnectState()`  L147
- `StateFlow<DeviceWifiScanState> getWifiScanState()`  L151
- `SharedFlow<WifiScanUiEvent> getWifiScanEvents()`  L155
- `void markUserInitiatedConnection()`  L159
- `boolean getUserInitiatedConnection()`  L164
- `void detectConnection$default(ConnectDialogViewModel connectDialogViewModel, DeviceType deviceType, long j, int i, Object obj)`  L168
- `void detectConnection(DeviceType deviceType, long timeoutMs)`  L175
    - 体内字面量："deviceType"
- `void scanNearbyDeviceWifi(DeviceType deviceType)`  L195
    - 体内字面量："deviceType"
- `void consumeWifiScanState()`  L283
- `void connectWithWifiSpecifier$default(ConnectDialogViewModel connectDialogViewModel, DeviceType deviceType, String str, String str2, String str3, long j, int i, Object obj)`  L292
    - 体内字面量："<anonymous>" · "com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$connectWithWifiSpecifier$1" · "ConnectDialogViewModel.kt" · "invokeSuspend"
- `void connectWithWifiSpecifier(DeviceType deviceType, String expectedSsid, String expectedBssid, String passphrase, long timeoutMs)`  L374
    - 体内字面量："deviceType" · "passphrase"
- `void reportWrongNetwork(String currentSsid, String expectedSsid)`  L380
    - 体内字面量："expectedSsid"
- `void consumeWifiSettingsFallback()`  L388
- `void detectRide5Connection(long timeoutMs)`  L394
    - 体内字面量："<anonymous>" · "com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$detectRideConnection$1" · "ConnectDialogViewModel.kt" · "invokeSuspend"
- `void detectRideConnection(DeviceType tempDeviceType, long timeoutMs)`  L546
- `Object m2887retryDetectRide3ProgIAlus(ConnectedDevice connectedDevice, Continuation<? super Result<ConnectedDevice>> continuation)`  L595
- `void reportProgress(ConnectionProgress progress)`  L1056
- `Object reportStepFailure(ConnectionProgress connectionProgress, int i, int i2, Continuation<? super Unit> continuation)`  L1061
- `Object reportStandardProgress(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L1068
- `Object reportStepWarning(ConnectionProgress connectionProgress, Continuation<? super Unit> continuation)`  L1088
    - 体内字面量："<anonymous>" · "com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$detectM3Connection$1" · "ConnectDialogViewModel.kt" · "invokeSuspend"
- `void detectM3Connection(long timeoutMs)`  L1150
- `void launchConnection(long timeoutMs, Function1<? super Continuation<? super Unit>, ? extends Object> block)`  L1154
    - 体内字面量："Connection flow timeout must be greater than 0"
- `void syncRide3ProHeartbeatAfterConnection()`  L1276
- `boolean isRideHttpDevice(DeviceType deviceType)`  L1294
- `void resetState()`  L1298
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$C24001`
L303 · [class] static final C24001 · extends `SuspendLambda implements Function1<Continuation<? super Unit>, Object>` · implements `Function1<Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

字段/常量（10）：
- `DeviceType $deviceType`  L304
- `String $expectedBssid`  L305
- `String $expectedSsid`  L306
- `String $passphrase`  L307
- `int label`  L308
- `Object objM2736connecthUnOzRk`  L331
- `Object obj2`  L332
- `int i = this.label`  L334
- `MutableStateFlow mutableStateFlow = ConnectDialogViewModel.this._connectState`  L351
- `MutableStateFlow mutableStateFlow2 = ConnectDialogViewModel.this._connectState`  L362

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L320 @Override
- `Object invoke(Continuation<? super Unit> continuation)`  L325 @Override
- `Object invokeSuspend(Object obj)`  L330 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$C24011`
L1098 · [class] static final C24011 · extends `SuspendLambda implements Function1<Continuation<? super Unit>, Object>` · implements `Function1<Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

字段/常量（4）：
- `int label`  L1099
- `Object value`  L1117
- `int i = this.label`  L1119
- `RefreshConnectionUseCase refreshConnectionUseCase = ConnectDialogViewModel.this.refreshConnectionUseCase`  L1124

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L1106 @Override
- `Object invoke(Continuation<? super Unit> continuation)`  L1111 @Override
- `Object invokeSuspend(Object obj)`  L1116 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$C24021`
L402 · [class] static final C24021 · extends `SuspendLambda implements Function1<Continuation<? super Unit>, Object>` · implements `Function1<Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

字段/常量（12）：
- `DeviceType $tempDeviceType`  L403
- `int label`  L404
- `ConnectedDevice connectedDevice`  L456
- `String str`  L457
- `String str2`  L458
- `Object objM2881invokehUnOzRk`  L459
- `Object value`  L460
- `int i = this.label`  L462
- `DeviceType deviceType = this.$tempDeviceType`  L466
- `RefreshConnectionUseCase refreshConnectionUseCase = ConnectDialogViewModel.this.refreshConnectionUseCase`  L485
- `RefreshConnectionUseCase refreshConnectionUseCase2 = ConnectDialogViewModel.this.refreshConnectionUseCase`  L508
- `MutableStateFlow mutableStateFlow = ConnectDialogViewModel.this._connectState`  L525

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L441 @Override
- `Object invoke(Continuation<? super Unit> continuation)`  L446 @Override
- `Object invokeSuspend(Object obj)`  L455 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$C24021$WhenMappings`
L409 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L410
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$C24032`
L1168 · [class] static final C24032 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

字段/常量（7）：
- `Function1<Continuation<? super Unit>, Object> $block`  L1169
- `long $timeoutMs`  L1170
- `int label`  L1171
- `ConnectDialogViewModel this$0`  L1172
- `Object obj2`  L1195
- `int i = this.label`  L1197
- `MutableStateFlow mutableStateFlow = this.this$0._connectState`  L1212

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1184 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1189 @Override
- `Object invokeSuspend(Object obj)`  L1194 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$C24032$AnonymousClass1`
L1232 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

字段/常量（4）：
- `Function1<Continuation<? super Unit>, Object> $block`  L1233
- `int label`  L1234
- `int i = this.label`  L1256
- `Function1<Continuation<? super Unit>, Object> function1 = this.$block`  L1259

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1244 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1249 @Override
- `Object invokeSuspend(Object obj)`  L1254 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$C24041`
L212 · [class] static final C24041 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

字段/常量（6）：
- `DeviceType $deviceType`  L213
- `DeviceWifiScanState $previousState`  L214
- `int label`  L215
- `DeviceWifiScanState ready`  L236
- `int i = this.label`  L238
- `MutableStateFlow mutableStateFlow = ConnectDialogViewModel.this._wifiScanState`  L260

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L225 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L230 @Override
- `Object invokeSuspend(Object obj)`  L235 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$connectWithWifiSpecifier$1$result$1`
L18 · [class] final ConnectDialogViewModel$connectWithWifiSpecifier$1$result$1 · extends `SuspendLambda implements Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · implements `Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel$connectWithWifiSpecifier$1$result$1.java`
注解：

字段/常量（4）：
- `Object L$0`  L19
- `int label`  L20
- `ConnectDialogViewModel this$0`  L21
- `int i = this.label`  L44

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L30 @Override
- `Object invoke(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L37 @Override
- `Object invokeSuspend(Object obj)`  L42 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$detectM3Connection$1$result$1`
L18 · [class] final ConnectDialogViewModel$detectM3Connection$1$result$1 · extends `SuspendLambda implements Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · implements `Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel$detectM3Connection$1$result$1.java`
注解：

字段/常量（4）：
- `Object L$0`  L19
- `int label`  L20
- `ConnectDialogViewModel this$0`  L21
- `int i = this.label`  L44

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L30 @Override
- `Object invoke(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L37 @Override
- `Object invokeSuspend(Object obj)`  L42 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$detectRideConnection$1$result$1`
L18 · [class] final ConnectDialogViewModel$detectRideConnection$1$result$1 · extends `SuspendLambda implements Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · implements `Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel$detectRideConnection$1$result$1.java`
注解：

字段/常量（4）：
- `Object L$0`  L19
- `int label`  L20
- `ConnectDialogViewModel this$0`  L21
- `int i = this.label`  L44

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L30 @Override
- `Object invoke(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L37 @Override
- `Object invokeSuspend(Object obj)`  L42 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$retryDetectRide3Pro$1`
L15 · [class] final ConnectDialogViewModel$retryDetectRide3Pro$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel$retryDetectRide3Pro$1.java`
注解：

字段/常量（11）：
- `int I$0`  L16
- `int I$1`  L17
- `int I$2`  L18
- `int I$3`  L19
- `Object L$0`  L20
- `Object L$1`  L21
- `Object L$2`  L22
- `Object L$3`  L23
- `int label`  L24
- `Object result`  L25
- `ConnectDialogViewModel this$0`  L26

方法（1）：
- `Object invokeSuspend(Object obj)`  L35 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$retryDetectRide3Pro$2$result$1`
L21 · [class] final ConnectDialogViewModel$retryDetectRide3Pro$2$result$1 · extends `SuspendLambda implements Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · implements `Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel$retryDetectRide3Pro$2$result$1.java`
注解：

字段/常量（6）：
- `int $attempt`  L22
- `Ref.ObjectRef<ConnectionProgress> $currentStep`  L23
- `Object L$0`  L24
- `int label`  L25
- `ConnectDialogViewModel this$0`  L26
- `int i = this.label`  L53

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L37 @Override
- `Object invoke(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L44 @Override
- `Object invokeSuspend(Object obj)`  L51 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$WhenMappings`
L85 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L86
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$WifiScanUiEvent`
L112 · [enum] public WifiScanUiEvent · `com/tuwinsmart/tuwin/presentation/dialog/ConnectDialogViewModel.java`
注解：

枚举常量（1）：
- `TOO_FREQUENT()`  L113

方法（1）：
- `EnumEntries<WifiScanUiEvent> getEntries()`  L117
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectHelperDialog`
L33 · [class] public final ConnectHelperDialog · extends `BaseDialogFragment` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectHelperDialog.java`
注解：

字段/常量（22）：
- `DialogConnectHelperBinding binding`  L37
- `boolean waitingForLocationSettings`  L38
- `Window window`  L63
- `DialogConnectHelperBinding dialogConnectHelperBinding = this.binding`  L76
- `DialogConnectHelperBinding dialogConnectHelperBinding2 = null`  L77
- `DialogConnectHelperBinding dialogConnectHelperBinding3 = this.binding`  L88
- `ConnectUtil connectUtil = ConnectUtil.INSTANCE`  L119
- `DialogConnectHelperBinding dialogConnectHelperBinding = null`  L165
- `DialogConnectHelperBinding dialogConnectHelperBinding2 = this.binding`  L167
- `DialogConnectHelperBinding dialogConnectHelperBinding3 = this.binding`  L173
- `DialogConnectHelperBinding dialogConnectHelperBinding4 = this.binding`  L179
- `DialogConnectHelperBinding dialogConnectHelperBinding5 = this.binding`  L185
- `DialogConnectHelperBinding dialogConnectHelperBinding6 = this.binding`  L192
- `DialogConnectHelperBinding dialogConnectHelperBinding7 = this.binding`  L198
- `DialogConnectHelperBinding dialogConnectHelperBinding8 = this.binding`  L204
- `DialogConnectHelperBinding dialogConnectHelperBinding9 = this.binding`  L210
- `DialogConnectHelperBinding dialogConnectHelperBinding10 = this.binding`  L217
- `DialogConnectHelperBinding dialogConnectHelperBinding11 = this.binding`  L223
- `DialogConnectHelperBinding dialogConnectHelperBinding12 = this.binding`  L231
- `DialogConnectHelperBinding dialogConnectHelperBinding13 = this.binding`  L237
- `DialogConnectHelperBinding dialogConnectHelperBinding14 = this.binding`  L245
- `DialogConnectHelperBinding dialogConnectHelperBinding15 = this.binding`  L251

方法（20）：
- `String[] getStoragePermissions()`  L40
- `View getContentRoot()`  L48 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onStart()`  L62 @Override
- `void initView()`  L74 @Override
- `void onClick(View view)`  L84 @Override
- `void onClick(View view)`  L96 @Override
- `void initView$lambda$1(ConnectHelperDialog this$0, View view)`  L111
    - 体内字面量："this$0" · "requireContext(...)"
- `void initView$lambda$2(ConnectHelperDialog this$0, View view)`  L136
    - 体内字面量："this$0"
- `void onResume()`  L143 @Override
- `void onDestroyView()`  L155 @Override
- `boolean refreshRequirementViews()`  L160
    - 体内字面量："requireContext(...)"
- `boolean hasLocationPermission(Context context)`  L262
- `boolean hasStoragePermission(Context context)`  L266
- `void requestLocationPermission()`  L271
- `void onGranted(List<String> permissions, boolean all)`  L274 @Override
- `void onDenied(List<String> permissions, boolean never)`  L281 @Override
- `void requestStoragePermission()`  L287
- `void onGranted(List<String> permissions, boolean all)`  L294 @Override
- `void onDenied(List<String> permissions, boolean never)`  L301 @Override
- `void openLocationSettings()`  L308
    - 体内字面量："android.settings.LOCATION_SOURCE_SETTINGS" · "Lcom/tuwinsmart/tuwin/presentation/dialog/ConnectHelperDialog$Companion;" · "()V" · "show" · "Landroid/content/Context;" · "fragmentManager" · "Landroidx/fragment/app/FragmentManager;" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectHelperDialog$Companion`
L320 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/dialog/ConnectHelperDialog.java`
注解：

字段/常量（1）：
- `String[] strArr`  L330

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L321
- `private Companion()`  L325
- `boolean show(Context context, FragmentManager fragmentManager)`  L329
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectionProgressDialog`
L26 · [class] public final ConnectionProgressDialog · extends `DialogFragment` · `com/tuwinsmart/tuwin/presentation/dialog/ConnectionProgressDialog.java`
注解：

字段/常量（8）：
- `DialogConnectionProgressBinding binding`  L27
- `String title = "<binary/metadata>"`  L28
- `String detail = "<binary/metadata>"`  L29
- `Mode mode = Mode.RUNNING`  L30
- `Window window`  L94
- `int i`  L138
- `DialogConnectionProgressBinding dialogConnectionProgressBinding = this.binding`  L139
- `ImageView imageView = dialogConnectionProgressBinding.ivConnectionStatus`  L147

方法（10）：
- `void onCreate(Bundle savedInstanceState)`  L75 @Override
- `Dialog onCreateDialog(Bundle savedInstanceState)`  L81 @Override
- `void onStart()`  L93 @Override
- `void showRunning(String title, String detail)`  L106
    - 体内字面量："title" · "detail"
- `void showFailed(String title, String detail)`  L112
    - 体内字面量："title" · "detail"
- `void showRetrying(String title, String detail)`  L118
    - 体内字面量："title" · "detail"
- `void showWarning(String title, String detail)`  L124
    - 体内字面量："title" · "detail"
- `void update(Mode mode, String title, String detail)`  L130
- `void render()`  L137
- `void onDestroyView()`  L165 @Override
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectionProgressDialog$Mode`
L34 · [enum] private Mode · `com/tuwinsmart/tuwin/presentation/dialog/ConnectionProgressDialog.java`
注解：

枚举常量（4）：
- `RUNNING()`  L35
- `FAILED()`  L36
- `RETRYING()`  L37
- `WARNING()`  L38

方法（1）：
- `EnumEntries<Mode> getEntries()`  L42
### `com.tuwinsmart.tuwin.presentation.dialog.ConnectionProgressDialog$WhenMappings`
L49 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/dialog/ConnectionProgressDialog.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L50
### `com.tuwinsmart.tuwin.presentation.dialog.DeviceWifiScanDialog`
L35 · [class] public final DeviceWifiScanDialog · extends `DialogFragment` · `com/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog.java`
注解：

字段/常量（14）：
- `String ACTION_CANCEL = "cancel"`  L36
- `String ACTION_FALLBACK = "fallback"`  L37
- `String ACTION_RETRY = "retry"`  L38
- `String ACTION_SELECT = "select"`  L39
- `String REQUEST_KEY = "device_wifi_scan"`  L40
- `String RESULT_ACTION = "action"`  L41
- `String RESULT_BSSID = "bssid"`  L42
- `String RESULT_SSID = "ssid"`  L43
- `String TAG = "DeviceWifiScanDialog"`  L44
- `DialogDeviceWifiScanBinding binding`  L45
- `Mode mode = Mode.SCANNING`  L46
- `Window window`  L124
- `DialogDeviceWifiScanBinding dialogDeviceWifiScanBinding = this.binding`  L156
- `DialogDeviceWifiScanBinding dialogDeviceWifiScanBinding = this.binding`  L204

方法（17）：
- `Unit invoke(DeviceWifiAccessPoint deviceWifiAccessPoint)`  L54 @Override
- `void invoke2(DeviceWifiAccessPoint accessPoint)`  L60
    - 体内字面量："accessPoint" · "action" · "Lcom/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog$Mode;" · "(Ljava/lang/String;I)V" · "SCANNING" · "READY" · "EMPTY" · "app_release_64"
- `void onCreate(Bundle savedInstanceState)`  L104 @Override
- `Dialog onCreateDialog(Bundle savedInstanceState)`  L110 @Override
- `void onStart()`  L123 @Override
- `void showScanning()`  L136
- `void showAccessPoints(List<DeviceWifiAccessPoint> accessPoints)`  L142
    - 体内字面量："accessPoints"
- `void showEmpty()`  L149
- `void bindActions()`  L155
- `void onClick(View view)`  L165 @Override
- `void onClick(View view)`  L171 @Override
- `void onClick(View view)`  L177 @Override
- `void bindActions$lambda$1(DeviceWifiScanDialog this$0, View view)`  L184
    - 体内字面量："this$0" · "action"
- `void bindActions$lambda$2(DeviceWifiScanDialog this$0, View view)`  L191
    - 体内字面量："this$0" · "action"
- `void bindActions$lambda$3(DeviceWifiScanDialog this$0, View view)`  L197
    - 体内字面量："this$0" · "action"
- `void render()`  L203
- `void onDestroyView()`  L246 @Override
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog$DeviceWifiAccessPointAdapter;" · "Landroidx/recyclerview/widget/RecyclerView$Adapter;" · "Lcom/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog$DeviceWifiAccessPointAdapter$Holder;" · "onClick" · "Lkotlin/Function1;" · "Lcom/tuwinsmart/tuwin/core/network/DeviceWifiAccessPoint;" · "(Lkotlin/jvm/functions/Function1;)V" · "items" · "getItemCount" · "onBindViewHolder" · "holder" · "onCreateViewHolder" · "parent" · "Landroid/view/ViewGroup;" · "viewType" · "submit" · "accessPoints" · "Holder" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.dialog.DeviceWifiScanDialog$DeviceWifiAccessPointAdapter`
L254 · [class] static final DeviceWifiAccessPointAdapter · extends `RecyclerView.Adapter<Holder>` · `com/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog.java`
注解：

字段/常量（2）：
- `List<DeviceWifiAccessPoint> items`  L255
- `Function1<DeviceWifiAccessPoint, Unit> onClick`  L256

方法（7）：
- `public DeviceWifiAccessPointAdapter(Function1<? super DeviceWifiAccessPoint, Unit> onClick)`  L259
    - 体内字面量："onClick"
- `void submit(List<DeviceWifiAccessPoint> accessPoints)`  L265
    - 体内字面量："accessPoints"
- `Holder onCreateViewHolder(ViewGroup parent, int viewType)`  L273 @Override
    - 体内字面量："parent"
- `void onBindViewHolder(Holder holder, int position)`  L281 @Override
    - 体内字面量："holder"
- `void onClick(View view)`  L288 @Override
- `void onBindViewHolder$lambda$0(DeviceWifiAccessPointAdapter this$0, DeviceWifiAccessPoint item, View view)`  L295
    - 体内字面量："this$0" · "$item"
- `int getItemCount()`  L302 @Override
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog$DeviceWifiAccessPointAdapter$Holder;" · "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;" · "itemView" · "Landroid/view/View;" · "(Landroid/view/View;)V" · "Landroid/widget/TextView;" · "getSsid" · "()Landroid/widget/TextView;" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.dialog.DeviceWifiScanDialog$DeviceWifiAccessPointAdapter$Holder`
L308 · [class] public static final Holder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog.java`
注解：

字段/常量（1）：
- `TextView ssid`  L309

方法（2）：
- `public Holder(View itemView)`  L312
    - 体内字面量："itemView" · "findViewById(...)"
- `TextView getSsid()`  L320
### `com.tuwinsmart.tuwin.presentation.dialog.DeviceWifiScanDialog$Mode`
L68 · [enum] private Mode · `com/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog.java`
注解：

枚举常量（3）：
- `SCANNING()`  L69
- `READY()`  L70
- `EMPTY()`  L71

方法（1）：
- `EnumEntries<Mode> getEntries()`  L75
### `com.tuwinsmart.tuwin.presentation.dialog.DeviceWifiScanDialog$WhenMappings`
L82 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/dialog/DeviceWifiScanDialog.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L83
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareDownloadDialog`
L24 · [class] public final FirmwareDownloadDialog · extends `Dialog` · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareDownloadDialog.java`
注解：

字段/常量（36）：
- `float BACKGROUND_DIM_AMOUNT = 0.6f`  L25
- `TextView actionView`  L26
- `FirmwareDownloadUiState currentState`  L27
- `Context hostContext`  L28
- `ImageView iconView`  L29
- `TextView messageView`  L30
- `Function0<Unit> onMoveToBackground`  L31
- `TextView percentView`  L32
- `ProgressBar progressView`  L33
- `View resultBottomSpacer`  L34
- `TextView titleView`  L35
- `Function0<Unit> function0`  L121
- `ProgressBar progressBar = this.progressView`  L148
- `TextView textView = null`  L149
- `TextView textView2 = this.percentView`  L155
- `View view = this.resultBottomSpacer`  L161
- `TextView textView3 = this.actionView`  L167
- `ProgressBar progressBar2 = this.progressView`  L173
- `TextView textView4 = this.percentView`  L179
- `ImageView imageView = this.iconView`  L201
- `TextView textView = null`  L202
- `ImageView imageView2 = this.iconView`  L208
- `TextView textView2 = this.titleView`  L214
- `TextView textView3 = this.messageView`  L220
- `TextView textView4 = this.actionView`  L226
- `ImageView imageView = this.iconView`  L236
- `TextView textView = null`  L237
- `ImageView imageView2 = this.iconView`  L243
- `TextView textView2 = this.titleView`  L249
- `TextView textView3 = this.messageView`  L255
- `ImageView imageView = this.iconView`  L265
- `TextView textView = null`  L266
- `ImageView imageView2 = this.iconView`  L272
- `TextView textView2 = this.titleView`  L278
- `TextView textView3 = this.messageView`  L284
- `TextView textView4 = this.actionView`  L290

方法（12）：
- `Context getHostContext()`  L60
- `public FirmwareDownloadDialog(Context hostContext)`  L65
    - 体内字面量："hostContext"
- `Function0<Unit> getOnMoveToBackground()`  L72
- `void setOnMoveToBackground(Function0<Unit> function0)`  L76
- `void onCreate(Bundle savedInstanceState)`  L81 @Override
    - 体内字面量："findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "actionView"
- `void onClick(View view)`  L113 @Override
- `void onCreate$lambda$0(FirmwareDownloadDialog this$0, View view)`  L120
- `void onStart()`  L130 @Override
- `void render(FirmwareDownloadUiState state)`  L142
    - 体内字面量："state"
- `void renderDownloading()`  L200
- `void renderCompleted()`  L235
- `void renderFailed()`  L264
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareDownloadDialog$WhenMappings`
L39 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareDownloadDialog.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L40
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareDownloadStatus`
L11 · [enum] public FirmwareDownloadStatus · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareDownloadStatus.java`
注解：

枚举常量（3）：
- `DOWNLOADING()`  L12
- `COMPLETED()`  L13
- `FAILED()`  L14

方法（1）：
- `EnumEntries<FirmwareDownloadStatus> getEntries()`  L18
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareDownloadUiState`
L12 · [class] public final FirmwareDownloadUiState · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareDownloadUiState.java`
注解：

字段/常量（12）：
- `int MAX_PROGRESS = 100`  L16
- `int MIN_PROGRESS = 0`  L17
- `boolean autoDismisses`  L18
- `int progress`  L19
- `boolean showsBackgroundAction`  L20
- `boolean showsProgress`  L21
- `boolean showsResultBottomSpacer`  L22
- `FirmwareDownloadStatus status`  L23
- `int i3 = i`  L36
- `boolean z5 = z`  L40
- `boolean z6 = z2`  L44
- `boolean z7 = z3`  L48

方法（19）：
- ` FirmwareDownloadUiState(FirmwareDownloadStatus firmwareDownloadStatus, int i, boolean z, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker)`  L25
- `FirmwareDownloadUiState copy$default(FirmwareDownloadUiState firmwareDownloadUiState, FirmwareDownloadStatus firmwareDownloadStatus, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj)`  L29
- `FirmwareDownloadStatus getStatus()`  L56
- `int getProgress()`  L61
- `boolean getShowsProgress()`  L66
- `boolean getShowsBackgroundAction()`  L71
- `boolean getAutoDismisses()`  L76
- `boolean getShowsResultBottomSpacer()`  L81
- `FirmwareDownloadUiState copy(FirmwareDownloadStatus status, int progress, boolean showsProgress, boolean showsBackgroundAction, boolean autoDismisses, boolean showsResultBottomSpacer)`  L85
    - 体内字面量："status"
- `boolean equals(Object other)`  L90
- `int hashCode()`  L101
- `String toString()`  L105
    - 体内字面量："FirmwareDownloadUiState(status=" · ", progress=" · ", showsProgress=" · ", showsBackgroundAction=" · ", autoDismisses=" · ", showsResultBottomSpacer=" · ")"
- `private FirmwareDownloadUiState(FirmwareDownloadStatus firmwareDownloadStatus, int i, boolean z, boolean z2, boolean z3, boolean z4)`  L109
- `FirmwareDownloadStatus getStatus()`  L118
- `int getProgress()`  L122
- `boolean getShowsProgress()`  L126
- `boolean getShowsBackgroundAction()`  L130
- `boolean getAutoDismisses()`  L134
- `boolean getShowsResultBottomSpacer()`  L138
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/dialog/FirmwareDownloadUiState$Companion;" · "()V" · "MAX_PROGRESS" · "MIN_PROGRESS" · "completed" · "Lcom/tuwinsmart/tuwin/presentation/dialog/FirmwareDownloadUiState;" · "downloading" · "progress" · "failed" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareDownloadUiState$Companion`
L144 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareDownloadUiState.java`
注解：

方法（5）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L145
- `private Companion()`  L149
- `FirmwareDownloadUiState downloading(int progress)`  L152
- `FirmwareDownloadUiState completed()`  L156
- `FirmwareDownloadUiState failed()`  L160
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUpdateBottomSheet`
L31 · [class] public final FirmwareUpdateBottomSheet · extends `BaseDialogFragment` · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareUpdateBottomSheet.java`
注解：

字段/常量（35）：
- `String TAG = "FirmwareUpdateBottomSheet"`  L35
- `View blackBgView`  L36
- `View closeBtn`  L37
- `View contentView`  L38
- `Function0<Unit> didClickClose`  L39
- `Function0<Unit> didClickUpgrade`  L40
- `ImageView iconImageView`  L41
- `String newVersion`  L42
- `TextView titleLabel`  L43
- `String updateLog`  L44
- `TextView updateLogTextView`  L45
- `TextView upgradeBtn`  L46
- `TextView versionLabel`  L47
- `Window window`  L88
- `View view = this.contentView`  L96
- `View view2 = this.contentView`  L99
- `View view3 = this.contentView`  L101
- `View view4 = this.contentView`  L103
- `Unit unit`  L110
- `TextView textView`  L111
- `String str = this.newVersion`  L112
- `TextView textView2 = this.versionLabel`  L114
- `TextView textView3 = this.updateLogTextView`  L125
- `String str2 = this.updateLog`  L127
- `View view = this.closeBtn`  L133
- `TextView textView4 = this.upgradeBtn`  L142
- `View view2 = this.blackBgView`  L151
- `View view = this.blackBgView`  L210
- `View view2 = this.contentView`  L217
- `ObjectAnimator objectAnimatorOfFloat`  L228
- `View view = this.blackBgView`  L229
- `View view2 = this.contentView`  L235
- `Function0<Unit> function0 = this.didClickClose`  L257
- `Function0<Unit> function0 = this.didClickClose`  L268
- `Function0<Unit> function0 = this.didClickUpgrade`  L275

方法（27）：
- `Function0<Unit> getDidClickUpgrade()`  L49
- `void setDidClickUpgrade(Function0<Unit> function0)`  L53
- `Function0<Unit> getDidClickClose()`  L57
- `void setDidClickClose(Function0<Unit> function0)`  L61
- `View getContentRoot()`  L66 @Override
- `void onCreate(Bundle savedInstanceState)`  L81 @Override
- `void onStart()`  L87 @Override
- `void initView()`  L109 @Override
- `void onClick(View view2)`  L137 @Override
- `void onClick(View view2)`  L146 @Override
- `void onClick(View view3)`  L155 @Override
- `void run()`  L164 @Override
- `void initView$lambda$3(FirmwareUpdateBottomSheet this$0, View view)`  L172
    - 体内字面量："this$0"
- `void initView$lambda$4(FirmwareUpdateBottomSheet this$0, View view)`  L178
    - 体内字面量："this$0"
- `void initView$lambda$5(FirmwareUpdateBottomSheet this$0, View view)`  L184
    - 体内字面量："this$0"
- `void initView$lambda$7(final FirmwareUpdateBottomSheet this$0)`  L190
    - 体内字面量："this$0"
- `void run()`  L196 @Override
- `void initView$lambda$7$lambda$6(FirmwareUpdateBottomSheet this$0)`  L204
    - 体内字面量："this$0"
- `void animateShow()`  L209
- `void animateDismiss(final Function0<Unit> callback)`  L227
- `void onAnimationEnd(Animator animation)`  L241 @Override
    - 体内字面量："animation"
- `void closeAction()`  L256
- `void onCancel(DialogInterface dialog)`  L265 @Override
    - 体内字面量："dialog"
- `void upgradeAction()`  L274
- `void dismiss()`  L283 @Override
- `Unit invoke()`  L290 @Override
- `void invoke2()`  L296
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/dialog/FirmwareUpdateBottomSheet$Companion;" · "()V" · "TAG" · "show" · "fragmentManager" · "Landroidx/fragment/app/FragmentManager;" · "updateLog" · "onUpgradeClick" · "Lkotlin/Function0;" · "onCloseClick" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUpdateBottomSheet$Companion`
L304 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareUpdateBottomSheet.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L305
- `private Companion()`  L309
- `boolean show(FragmentManager fragmentManager, String version, String updateLog, Function0<Unit> onUpgradeClick, Function0<Unit> onCloseClick)`  L312
    - 体内字面量："fragmentManager"
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUploadDialog`
L32 · [class] public final FirmwareUploadDialog · extends `Dialog` · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareUploadDialog.java`
注解：

字段/常量（106）：
- `float BACKGROUND_DIM_AMOUNT = 0.55f`  L33
- `String UNAVAILABLE_VALUE = "--"`  L34
- `Function0<Unit> confirmAction`  L35
- `FirmwareUploadUiState currentState`  L36
- `ImageView iconView`  L37
- `TextView percentView`  L38
- `FirmwareUploadRingView progressView`  L39
- `TextView remainingTimeView`  L40
- `Function0<Unit> retryAction`  L41
- `TextView retryView`  L42
- `ProgressBar spinnerView`  L43
- `TextView statusView`  L44
- `TextView titleView`  L45
- `TextView totalSizeView`  L46
- `long uploadStartedAtMillis`  L47
- `TextView uploadedSizeView`  L48
- `TextView warningView`  L49
- `Function0<Unit> function0`  L156
- `Function0<Unit> function1 = this$0.retryAction`  L166
- `FirmwareUploadRingView firmwareUploadRingView = this.progressView`  L205
- `TextView textView = null`  L208
- `TextView textView2 = this.percentView`  L214
- `ProgressBar progressBar = this.spinnerView`  L246
- `TextView textView = null`  L247
- `ImageView imageView = this.iconView`  L253
- `FirmwareUploadRingView firmwareUploadRingView = this.progressView`  L259
- `TextView textView2 = this.titleView`  L265
- `TextView textView3 = this.warningView`  L271
- `TextView textView4 = this.warningView`  L277
- `TextView textView5 = this.percentView`  L283
- `TextView textView6 = this.statusView`  L289
- `FirmwareUploadRingView firmwareUploadRingView2 = this.progressView`  L295
- `TextView textView7 = this.retryView`  L301
- `ProgressBar progressBar = this.spinnerView`  L311
- `TextView textView = null`  L312
- `ImageView imageView = this.iconView`  L318
- `FirmwareUploadRingView firmwareUploadRingView = this.progressView`  L324
- `ImageView imageView2 = this.iconView`  L330
- `ImageView imageView3 = this.iconView`  L336
- `TextView textView2 = this.titleView`  L342
- `TextView textView3 = this.warningView`  L348
- `TextView textView4 = this.warningView`  L354
- `TextView textView5 = this.percentView`  L360
- `TextView textView6 = this.statusView`  L366
- `FirmwareUploadRingView firmwareUploadRingView2 = this.progressView`  L372
- `TextView textView7 = this.retryView`  L378
- `TextView textView8 = this.retryView`  L384
- `ProgressBar progressBar = this.spinnerView`  L394
- `TextView textView = null`  L395
- `ImageView imageView = this.iconView`  L401
- `FirmwareUploadRingView firmwareUploadRingView = this.progressView`  L407
- `ImageView imageView2 = this.iconView`  L413
- `ImageView imageView3 = this.iconView`  L419
- `TextView textView2 = this.titleView`  L425
- `TextView textView3 = this.warningView`  L431
- `TextView textView4 = this.warningView`  L437
- `TextView textView5 = this.percentView`  L443
- `TextView textView6 = this.statusView`  L449
- `FirmwareUploadRingView firmwareUploadRingView2 = this.progressView`  L455
- `TextView textView7 = this.retryView`  L461
- `TextView textView8 = this.retryView`  L467
- `ImageView imageView = this.iconView`  L477
- `TextView textView = null`  L478
- `ProgressBar progressBar = this.spinnerView`  L484
- `FirmwareUploadRingView firmwareUploadRingView = this.progressView`  L490
- `TextView textView2 = this.titleView`  L496
- `TextView textView3 = this.warningView`  L502
- `TextView textView4 = this.warningView`  L508
- `TextView textView5 = this.percentView`  L514
- `TextView textView6 = this.statusView`  L520
- `FirmwareUploadRingView firmwareUploadRingView2 = this.progressView`  L526
- `TextView textView7 = this.retryView`  L532
- `ProgressBar progressBar = this.spinnerView`  L542
- `TextView textView = null`  L543
- `ImageView imageView = this.iconView`  L549
- `FirmwareUploadRingView firmwareUploadRingView = this.progressView`  L555
- `FirmwareUploadRingView firmwareUploadRingView2 = this.progressView`  L561
- `ImageView imageView2 = this.iconView`  L567
- `ImageView imageView3 = this.iconView`  L573
- `TextView textView2 = this.titleView`  L579
- `TextView textView3 = this.warningView`  L585
- `TextView textView4 = this.percentView`  L591
- `TextView textView5 = this.statusView`  L597
- `FirmwareUploadRingView firmwareUploadRingView3 = this.progressView`  L603
- `TextView textView6 = this.retryView`  L609
- `ProgressBar progressBar = this.spinnerView`  L619
- `TextView textView = null`  L620
- `ImageView imageView = this.iconView`  L626
- `FirmwareUploadRingView firmwareUploadRingView = this.progressView`  L632
- `FirmwareUploadRingView firmwareUploadRingView2 = this.progressView`  L638
- `ImageView imageView2 = this.iconView`  L644
- `ImageView imageView3 = this.iconView`  L650
- `TextView textView2 = this.titleView`  L656
- `TextView textView3 = this.warningView`  L662
- `TextView textView4 = this.percentView`  L668
- `TextView textView5 = this.statusView`  L674
- `FirmwareUploadRingView firmwareUploadRingView3 = this.progressView`  L680
- `TextView textView6 = this.retryView`  L686
- `TextView textView = null`  L698
- `TextView textView2 = this.uploadedSizeView`  L700
- `TextView textView3 = this.totalSizeView`  L708
- `TextView textView4 = this.remainingTimeView`  L717
- `TextView textView5 = this.remainingTimeView`  L727
- `TextView textView6 = this.remainingTimeView`  L741
- `TextView textView7 = this.remainingTimeView`  L752
- `TextView textView8 = this.remainingTimeView`  L762

方法（16）：
- `public FirmwareUploadDialog(Context context)`  L95
    - 体内字面量："context"
- `void onCreate(Bundle savedInstanceState)`  L102 @Override
    - 体内字面量："findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "findViewById(...)" · "retryView"
- `void onClick(View view)`  L147 @Override
- `void onCreate$lambda$0(FirmwareUploadDialog this$0, View view)`  L155
- `void onStart()`  L173 @Override
- `void render(FirmwareUploadUiState state)`  L185
    - 体内字面量："state"
- `void setOnRetryAction(Function0<Unit> action)`  L194
    - 体内字面量："action"
- `void setOnConfirmAction(Function0<Unit> action)`  L199
    - 体内字面量："action"
- `void applyState()`  L204
- `void renderUploading()`  L245
- `void renderUploadFailed()`  L310
- `void renderExternalPowerCheck()`  L393
- `void renderInstalling()`  L476
- `void renderInstalled()`  L541
- `void renderInstallationFailed()`  L618
- `void renderUploadMetrics()`  L695
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUploadDialog$WhenMappings`
L57 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareUploadDialog.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L58
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUploadUiState`
L14 · [class] public final FirmwareUploadUiState · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareUploadUiState.java`
注解：

字段/常量（6）：
- `Mode mode`  L18
- `int progress`  L19
- `Long totalBytes`  L20
- `Long uploadedBytes`  L21
- `Long l = this.uploadedBytes`  L99
- `Long l2 = this.totalBytes`  L101

方法（15）：
- ` FirmwareUploadUiState(int i, Mode mode, Long l, Long l2, DefaultConstructorMarker defaultConstructorMarker)`  L41
- `FirmwareUploadUiState copy$default(FirmwareUploadUiState firmwareUploadUiState, int i, Mode mode, Long l, Long l2, int i2, Object obj)`  L45
- `int getProgress()`  L62
- `Mode getMode()`  L67
- `Long getUploadedBytes()`  L72
- `Long getTotalBytes()`  L77
- `FirmwareUploadUiState copy(int progress, Mode mode, Long uploadedBytes, Long totalBytes)`  L81
    - 体内字面量："mode"
- `boolean equals(Object other)`  L86
- `int hashCode()`  L97
- `String toString()`  L105
    - 体内字面量："FirmwareUploadUiState(progress=" · ", mode=" · ", uploadedBytes=" · ", totalBytes=" · ")"
- `private FirmwareUploadUiState(int i, Mode mode, Long l, Long l2)`  L109
- `int getProgress()`  L120
- `Mode getMode()`  L124
- `Long getUploadedBytes()`  L128
- `Long getTotalBytes()`  L132
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/dialog/FirmwareUploadUiState$Companion;" · "()V" · "awaitingDeviceAcknowledgement" · "Lcom/tuwinsmart/tuwin/presentation/dialog/FirmwareUploadUiState;" · "externalPowerCheck" · "progress" · "uploadedBytes" · "totalBytes" · "(ILjava/lang/Long;Ljava/lang/Long;)Lcom/tuwinsmart/tuwin/presentation/dialog/FirmwareUploadUiState;" · "installationFailed" · "installed" · "installing" · "uploadFailed" · "uploading" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUploadUiState$Companion`
L138 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareUploadUiState.java`
注解：

方法（12）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L139
- `private Companion()`  L143
- `FirmwareUploadUiState uploading$default(Companion companion, int i, Long l, Long l2, int i2, Object obj)`  L146
- `FirmwareUploadUiState uploading(int progress, Long uploadedBytes, Long totalBytes)`  L156
- `FirmwareUploadUiState awaitingDeviceAcknowledgement()`  L160
- `FirmwareUploadUiState uploadFailed$default(Companion companion, int i, Long l, Long l2, int i2, Object obj)`  L164
- `FirmwareUploadUiState uploadFailed(int progress, Long uploadedBytes, Long totalBytes)`  L174
- `FirmwareUploadUiState externalPowerCheck$default(Companion companion, int i, Long l, Long l2, int i2, Object obj)`  L178
- `FirmwareUploadUiState externalPowerCheck(int progress, Long uploadedBytes, Long totalBytes)`  L188
- `FirmwareUploadUiState installing()`  L192
- `FirmwareUploadUiState installed()`  L196
- `FirmwareUploadUiState installationFailed()`  L200
### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUploadUiState$Mode`
L25 · [enum] public Mode · `com/tuwinsmart/tuwin/presentation/dialog/FirmwareUploadUiState.java`
注解：

枚举常量（7）：
- `UPLOADING()`  L26
- `AWAITING_ACKNOWLEDGEMENT()`  L27
- `UPLOAD_FAILED()`  L28
- `EXTERNAL_POWER_CHECK()`  L29
- `INSTALLING()`  L30
- `INSTALLED()`  L31
- `INSTALLATION_FAILED()`  L32

方法（1）：
- `EnumEntries<Mode> getEntries()`  L36
### `com.tuwinsmart.tuwin.presentation.dialog.ProgressDialog`
L15 · [class] public ProgressDialog · extends `DialogFragment` · `com/tuwinsmart/tuwin/presentation/dialog/ProgressDialog.java`

字段/常量（6）：
- `boolean detailMonospace = false`  L16
- `Dialog dialog`  L17
- `String mDetail`  L18
- `TextView tvDetail`  L19
- `TextView textView = this.tvDetail`  L43
- `TextView textView = this.tvDetail`  L58

方法（3）：
- `Dialog onCreateDialog(Bundle bundle)`  L22 @Override
- `ProgressDialog setDetail(String str)`  L41
- `ProgressDialog setDetailMonospace(boolean z)`  L56
### `com.tuwinsmart.tuwin.presentation.dialog.Ride3ProDeleteConfirmDialog`
L17 · [class] public final Ride3ProDeleteConfirmDialog · `com/tuwinsmart/tuwin/presentation/dialog/Ride3ProDeleteConfirmDialog.java`
注解：

方法（4）：
- `private Ride3ProDeleteConfirmDialog()`  L20
- `void show(Context context, int fileCount, final Function0<Unit> onConfirm)`  L23
    - 体内字面量："context" · "onConfirm" · "Ride3Pro delete confirmation requires at least one file"
- `void onClick(View view)`  L31 @Override
- `void show$lambda$1(Function0 onConfirm, View view)`  L38
    - 体内字面量："$onConfirm"