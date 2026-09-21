# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.presentation.p010ui.mine

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 47 个文件 / 94 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.AboutActivity`
L19 · [class] public final AboutActivity · extends `ToolBarActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/AboutActivity.java`
注解：

字段/常量（7）：
- `ActivityAboutBinding binding`  L20
- `ActivityAboutBinding activityAboutBinding = this.binding`  L57
- `ActivityAboutBinding activityAboutBinding2 = null`  L58
- `ActivityAboutBinding activityAboutBinding3 = this.binding`  L64
- `ActivityAboutBinding activityAboutBinding4 = this.binding`  L70
- `ActivityAboutBinding activityAboutBinding5 = this.binding`  L76
- `ActivityAboutBinding activityAboutBinding = this$0.binding`  L94

方法（6）：
- `Unit invoke()`  L27 @Override
- `void invoke2()`  L33
- `View getContentRoot()`  L40 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L54 @Override
- `void onClick(View view)`  L84 @Override
- `void onCreate$lambda$0(AboutActivity this$0, View view)`  L91
    - 体内字面量："this$0"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.AboutBuildRevealPolicy`
L13 · [class] public final AboutBuildRevealPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/AboutBuildRevealPolicy.java`
注解：

字段/常量（5）：
- `Function0<Unit> onRevealed`  L14
- `int requiredTapCount`  L15
- `boolean revealed`  L16
- `int tapCount`  L17
- `int i = this.tapCount + 1`  L48

方法（6）：
- `public AboutBuildRevealPolicy()`  L20
- `public AboutBuildRevealPolicy(int i, Function0<Unit> onRevealed)`  L24
    - 体内字面量："onRevealed"
- ` AboutBuildRevealPolicy(int i, C27691 c27691, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L30
- `void invoke2()`  L33
- `Unit invoke()`  L37 @Override
- `boolean onVersionTapped()`  L44
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackActivity`
L73 · [class] public final FeedbackActivity · extends `ToolBarActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackActivity.java`
注解：

字段/常量（178）：
- `String KEY_FEEDBACK_CONTACT = "feedback_contact_cache"`  L74
- `String KEY_FEEDBACK_CONTENT = "feedback_content_cache"`  L75
- `ActivityFeedbackBinding binding`  L76
- `boolean changingSelectionProgrammatically`  L77
- `TextWatcher contactWatcher`  L78
- `TextWatcher contentWatcher`  L79
- `Lazy feedbackGateway`  L82
- `FeedbackDeviceSelection selectedDevice`  L83
- `Qualifier qualifier = null`  L116
- `FeedbackActivity feedbackActivity = this`  L117
- `LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED`  L118
- `Object[] objArr = 0 == true ? 1 : 0`  L119
- `ComponentCallbacks componentCallbacks = feedbackActivity`  L124
- `ActivityFeedbackBinding activityFeedbackBinding = this.binding`  L133
- `FeedbackDeviceSelection feedbackDeviceSelection = this$0.selectedDevice`  L253
- `FeedbackActivity feedbackActivity = this.this$0`  L271
- `int iCoerceAtLeast`  L295
- `FeedbackDeviceSelection feedbackDeviceSelection = this.selectedDevice`  L299
- `int i = 0`  L302
- `FeedbackActivity feedbackActivity = FeedbackActivity.this`  L355
- `List<FeedbackDeviceSpinnerItem> list = listBuild`  L356
- `int i2 = 0`  L360
- `DeviceType deviceType`  L397
- `DeviceType deviceType2`  L398
- `Object obj = null`  L399
- `Object obj = null`  L418
- `C27741 c27741`  L533
- `long jCurrentTimeMillis`  L534
- `String str3`  L535
- `FeedbackActivity feedbackActivity`  L536
- `Object next`  L537
- `String str4`  L538
- `String str5`  L539
- `DeviceType deviceType`  L540
- `FeedbackActivity feedbackActivity2`  L541
- `long j`  L542
- `String str6`  L543
- `String str7`  L544
- `String str8`  L545
- `String strJoinToString$default`  L546
- `String str9`  L547
- `String str10`  L548
- `String str11`  L549
- `String str12`  L550
- `Object objUploadLogFile`  L551
- `String str13`  L552
- `String str14`  L553
- `long j2`  L554
- `DeviceType deviceType2`  L555
- `String str15`  L556
- `FeedbackLogUploadResult feedbackLogUploadResult`  L557
- `String diagnosticId`  L558
- `String str16`  L559
- `ConnectedDevice connectedDeviceFindSelectedConnectedDevice`  L560
- `String deviceLogUrl`  L561
- `String str17`  L562
- `String appLogUrl`  L563
- `String str18`  L564
- `String version`  L565
- `String str19`  L566
- `long j3`  L567
- `String str20`  L568
- `String versionName`  L569
- `String str21`  L570
- `String str22`  L571
- `String deviceName`  L572
- `FeedbackActivity feedbackActivity3`  L573
- `String diagnosticId2`  L574
- `String str23`  L575
- `String strName`  L576
- `boolean z`  L577
- `boolean z2`  L578
- `Object objSubmit`  L579
- `FeedbackLogUploadResult feedbackLogUploadResult2`  L580
- `String str24`  L581
- `String boardversion`  L582
- `UpgradeBean upgradeBean`  L583
- `Object objDownloadLogFile = c27741.result`  L594
- `int i = c27741.label`  L596
- `String str25 = "duration_ms"`  L597
- `LogHelper logHelper = LogHelper.INSTANCE`  L605
- `LogHelper logHelper2 = LogHelper.INSTANCE`  L678
- `long j4 = jCurrentTimeMillis`  L692
- `String str26 = str4`  L697
- `Pair[] pairArr = new Pair[12]`  L747
- `DiagnosticLog diagnosticLog = DiagnosticLog.INSTANCE`  L772
- `Pair<String, ? extends Object>[] pairArr2 = new Pair[4]`  L773
- `LinkedHashMap linkedHashMap = linkedHashMapLinkedMapOf`  L795
- `C27741 c27742 = c27741`  L796
- `DiagnosticLog diagnosticLog2 = DiagnosticLog.INSTANCE`  L820
- `Pair<String, ? extends Object>[] pairArr3 = new Pair[3]`  L821
- `Pair[] pairArr4 = new Pair[12]`  L862
- `DiagnosticLog diagnosticLog3 = DiagnosticLog.INSTANCE`  L887
- `Pair<String, ? extends Object>[] pairArr5 = new Pair[4]`  L888
- `LinkedHashMap linkedHashMap2 = linkedHashMapLinkedMapOf2`  L910
- `C27741 c27743 = c27741`  L911
- `DiagnosticLog diagnosticLog4 = DiagnosticLog.INSTANCE`  L935
- `Pair<String, ? extends Object>[] pairArr6 = new Pair[3]`  L936
- `Pair[] pairArr7 = new Pair[12]`  L991
- `DiagnosticLog diagnosticLog5 = DiagnosticLog.INSTANCE`  L1016
- `Pair<String, ? extends Object>[] pairArr8 = new Pair[4]`  L1017
- `LinkedHashMap linkedHashMap3 = linkedHashMapLinkedMapOf3`  L1039
- `C27741 c27744 = c27741`  L1040
- `DiagnosticLog diagnosticLog6 = DiagnosticLog.INSTANCE`  L1064
- `Pair<String, ? extends Object>[] pairArr9 = new Pair[3]`  L1065
- `Pair[] pairArr10 = new Pair[12]`  L1106
- `DiagnosticLog diagnosticLog7 = DiagnosticLog.INSTANCE`  L1131
- `Pair<String, ? extends Object>[] pairArr11 = new Pair[4]`  L1132
- `LinkedHashMap linkedHashMap4 = linkedHashMapLinkedMapOf4`  L1154
- `C27741 c27745 = c27741`  L1155
- `DiagnosticLog diagnosticLog8 = DiagnosticLog.INSTANCE`  L1179
- `Pair<String, ? extends Object>[] pairArr12 = new Pair[3]`  L1180
- `LogHelper logHelper3 = LogHelper.INSTANCE`  L1251
- `long j5 = jCurrentTimeMillis`  L1265
- `String str28 = str4`  L1270
- `Pair[] pairArr13 = new Pair[12]`  L1320
- `DiagnosticLog diagnosticLog9 = DiagnosticLog.INSTANCE`  L1345
- `Pair<String, ? extends Object>[] pairArr14 = new Pair[4]`  L1346
- `LinkedHashMap linkedHashMap5 = linkedHashMapLinkedMapOf5`  L1368
- `C27741 c27746 = c27741`  L1369
- `DiagnosticLog diagnosticLog10 = DiagnosticLog.INSTANCE`  L1393
- `Pair<String, ? extends Object>[] pairArr15 = new Pair[3]`  L1394
- `Pair[] pairArr16 = new Pair[12]`  L1435
- `DiagnosticLog diagnosticLog11 = DiagnosticLog.INSTANCE`  L1460
- `Pair<String, ? extends Object>[] pairArr17 = new Pair[4]`  L1461
- `LinkedHashMap linkedHashMap6 = linkedHashMapLinkedMapOf6`  L1483
- `C27741 c27747 = c27741`  L1484
- `DiagnosticLog diagnosticLog12 = DiagnosticLog.INSTANCE`  L1508
- `Pair<String, ? extends Object>[] pairArr18 = new Pair[3]`  L1509
- `Pair[] pairArr19 = new Pair[12]`  L1564
- `DiagnosticLog diagnosticLog13 = DiagnosticLog.INSTANCE`  L1589
- `Pair<String, ? extends Object>[] pairArr110 = new Pair[4]`  L1590
- `LinkedHashMap linkedHashMap7 = linkedHashMapLinkedMapOf7`  L1612
- `C27741 c27748 = c27741`  L1613
- `DiagnosticLog diagnosticLog14 = DiagnosticLog.INSTANCE`  L1637
- `Pair<String, ? extends Object>[] pairArr111 = new Pair[3]`  L1638
- `Pair[] pairArr112 = new Pair[12]`  L1679
- `DiagnosticLog diagnosticLog15 = DiagnosticLog.INSTANCE`  L1704
- `Pair<String, ? extends Object>[] pairArr113 = new Pair[4]`  L1705
- `LinkedHashMap linkedHashMap8 = linkedHashMapLinkedMapOf8`  L1727
- `C27741 c27749 = c27741`  L1728
- `DiagnosticLog diagnosticLog16 = DiagnosticLog.INSTANCE`  L1752
- `Pair<String, ? extends Object>[] pairArr114 = new Pair[3]`  L1753
- `long j6 = j2`  L1843
- `Pair[] pairArr115 = new Pair[12]`  L1875
- `DiagnosticLog diagnosticLog17 = DiagnosticLog.INSTANCE`  L1916
- `Pair<String, ? extends Object>[] pairArr116 = new Pair[4]`  L1917
- `LinkedHashMap linkedHashMap9 = linkedHashMapLinkedMapOf9`  L1939
- `C27741 c277410 = c27741`  L1940
- `DiagnosticLog diagnosticLog18 = DiagnosticLog.INSTANCE`  L1966
- `Pair<String, ? extends Object>[] pairArr117 = new Pair[3]`  L1967
- `Pair[] pairArr118 = new Pair[12]`  L2055
- `DiagnosticLog diagnosticLog19 = DiagnosticLog.INSTANCE`  L2080
- `Pair<String, ? extends Object>[] pairArr119 = new Pair[4]`  L2081
- `LinkedHashMap linkedHashMap10 = linkedHashMapLinkedMapOf10`  L2103
- `C27741 c277411 = c27741`  L2104
- `DiagnosticLog diagnosticLog110 = DiagnosticLog.INSTANCE`  L2128
- `Pair<String, ? extends Object>[] pairArr1110 = new Pair[3]`  L2129
- `Pair[] pairArr1111 = new Pair[12]`  L2191
- `DiagnosticLog diagnosticLog111 = DiagnosticLog.INSTANCE`  L2216
- `Pair<String, ? extends Object>[] pairArr1112 = new Pair[4]`  L2217
- `LinkedHashMap linkedHashMap11 = linkedHashMapLinkedMapOf11`  L2239
- `C27741 c277412 = c27741`  L2240
- `DiagnosticLog diagnosticLog112 = DiagnosticLog.INSTANCE`  L2264
- `Pair<String, ? extends Object>[] pairArr1113 = new Pair[3]`  L2265
- `Pair[] pairArr1114 = new Pair[12]`  L2306
- `DiagnosticLog diagnosticLog113 = DiagnosticLog.INSTANCE`  L2331
- `Pair<String, ? extends Object>[] pairArr1115 = new Pair[4]`  L2332
- `LinkedHashMap linkedHashMap12 = linkedHashMapLinkedMapOf12`  L2354
- `C27741 c277413 = c27741`  L2355
- `DiagnosticLog diagnosticLog114 = DiagnosticLog.INSTANCE`  L2379
- `Pair<String, ? extends Object>[] pairArr1116 = new Pair[3]`  L2380
- `DiagnosticLog diagnosticLog115 = DiagnosticLog.INSTANCE`  L2432
- `Pair<String, ? extends Object>[] pairArr1117 = new Pair[3]`  L2433
- `String str2 = str`  L2489
- `String str4 = str3`  L2496
- `String string`  L2515
- `String str = key`  L2517

方法（31）：
- `public FeedbackActivity()`  L115
- `FeedbackGateway invoke()`  L123 @Override
- `ActivityFeedbackBinding getBinding()`  L132
- `void setBinding(ActivityFeedbackBinding activityFeedbackBinding)`  L141
    - 体内字面量："<set-?>"
- `FeedbackGateway getFeedbackGateway()`  L146
- `View getContentRoot()`  L151 @Override
    - 体内字面量："inflate(...)" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L161 @Override
    - 体内字面量："btnSubmit"
- `void onClick(View view)`  L176 @Override
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.FeedbackActivity$onCreate$1" · "FeedbackActivity.kt" · "invokeSuspend"
- `void onCreate$lambda$0(final FeedbackActivity this$0, View view)`  L240
    - 体内字面量："this$0" · "ç¹å»åé¦æé®"
- `Unit invoke()`  L264 @Override
- `void invoke2()`  L270
- `Unit invoke()`  L281 @Override
- `void invoke2()`  L287
- `void setupDeviceSelector()`  L294
- `void onClick(View view)`  L330 @Override
- `void onNothingSelected(AdapterView<?> parent)`  L336 @Override
- `void onItemSelected(AdapterView<?> parent, View view, int position, long id)`  L340 @Override
- `void setupDeviceSelector$lambda$3(FeedbackDeviceSpinnerSelectionGate selectionGate, FeedbackActivity this$0, View view)`  L383
    - 体内字面量："$selectionGate" · "this$0"
- `FeedbackDeviceLogState getDeviceLogState()`  L391
- `DeviceType resolveConnectedDeviceType(FeedbackDeviceSelection selection)`  L396
- `ConnectedDevice findSelectedConnectedDevice(DeviceType selectedType)`  L417
- `void setSelectionSafely(Spinner spinner, int i)`  L433
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.FeedbackActivity$submitFeedback$1" · "FeedbackActivity.kt" · "invokeSuspend"
- `void submitFeedback(String content, String contact)`  L487
- `Object submitFeedbackOnCurrentRoute(String str, String str2, Continuation<? super Unit> continuation)`  L532
- `throw new IllegalStateException( 372 )`  L2419
    - 体内字面量："duration_ms"
- `void restoreCachedInput()`  L2486
- `TextWatcher createFeedbackCacheWatcher(final String key)`  L2503
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L2506 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L2510 @Override
- `void afterTextChanged(Editable s)`  L2514 @Override
- `void clearFeedbackCache()`  L2526
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackActivity$C27711`
L186 · [class] static final C27711 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackActivity.java`
注解：

字段/常量（5）：
- `FeedbackDeviceSelection $defaultSelection`  L187
- `int label`  L188
- `Object next`  L208
- `int i = this.label`  L210
- `LogHelper logHelper = LogHelper.INSTANCE`  L213

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L197 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L202 @Override
- `Object invokeSuspend(Object obj)`  L207 @Override
- `throw new IllegalStateException( 105 )`  L231
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackActivity$C27731`
L444 · [class] static final C27731 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackActivity.java`
注解：

字段/常量（4）：
- `String $contact`  L445
- `String $content`  L446
- `int label`  L447
- `int i = this.label`  L469

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L457 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L462 @Override
- `Object invokeSuspend(Object obj)`  L467 @Override
- `throw new IllegalStateException( 121 )`  L478
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackActivity$C27741`
L90 · [class] static final C27741 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackActivity.java`
注解：

字段/常量（10）：
- `long J$0`  L91
- `Object L$0`  L92
- `Object L$1`  L93
- `Object L$2`  L94
- `Object L$3`  L95
- `Object L$4`  L96
- `Object L$5`  L97
- `Object L$6`  L98
- `int label`  L99
- `Object result`  L100

方法（1）：
- `Object invokeSuspend(Object obj)`  L107 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackActivityKt`
L13 · [class] public final FeedbackActivityKt · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackActivityKt.java`
注解：

方法（5）：
- `String displayName(FeedbackDeviceSelection feedbackDeviceSelection)`  L39
    - 体内字面量："Ride3 Pro" · "Ride5/Ride5 Pro"
- `throw new NoWhenBranchMatchedException()`  L50
- `DeviceType toDeviceType(FeedbackDeviceSelection feedbackDeviceSelection)`  L54
- `throw new NoWhenBranchMatchedException()`  L65
- `boolean hasContent(File file)`  L68
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackActivityKt$WhenMappings`
L17 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackActivityKt.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L18
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceLogState`
L9 · [class] public final FeedbackDeviceLogState · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceLogState.java`
注解：

字段/常量（2）：
- `boolean hasRide3ProLog`  L10
- `boolean hasRide5SeriesLog`  L11

方法（10）：
- `FeedbackDeviceLogState copy$default(FeedbackDeviceLogState feedbackDeviceLogState, boolean z, boolean z2, int i, Object obj)`  L13
- `boolean getHasRide3ProLog()`  L24
- `boolean getHasRide5SeriesLog()`  L29
- `FeedbackDeviceLogState copy(boolean hasRide3ProLog, boolean hasRide5SeriesLog)`  L33
- `boolean equals(Object other)`  L37
- `int hashCode()`  L48
- `String toString()`  L52
    - 体内字面量："FeedbackDeviceLogState(hasRide3ProLog=" · ", hasRide5SeriesLog=" · ")"
- `public FeedbackDeviceLogState(boolean z, boolean z2)`  L56
- `boolean getHasRide3ProLog()`  L61
- `boolean getHasRide5SeriesLog()`  L65
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceOption`
L10 · [class] public final FeedbackDeviceOption · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceOption.java`
注解：

字段/常量（2）：
- `boolean enabled`  L11
- `FeedbackDeviceSelection selection`  L12

方法（10）：
- `FeedbackDeviceOption copy$default(FeedbackDeviceOption feedbackDeviceOption, FeedbackDeviceSelection feedbackDeviceSelection, boolean z, int i, Object obj)`  L14
- `FeedbackDeviceSelection getSelection()`  L25
- `boolean getEnabled()`  L30
- `FeedbackDeviceOption copy(FeedbackDeviceSelection selection, boolean enabled)`  L34
    - 体内字面量："selection"
- `boolean equals(Object other)`  L39
- `int hashCode()`  L50
- `String toString()`  L54
    - 体内字面量："FeedbackDeviceOption(selection=" · ", enabled=" · ")"
- `public FeedbackDeviceOption(FeedbackDeviceSelection selection, boolean z)`  L58
    - 体内字面量："selection"
- `FeedbackDeviceSelection getSelection()`  L64
- `boolean getEnabled()`  L68
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceSelection`
L12 · [enum] public FeedbackDeviceSelection · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceSelection.java`
注解：

枚举常量（3）：
- `RIDE3_PRO()`  L13
- `RIDE5_SERIES()`  L14
- `M3()`  L15

方法（1）：
- `EnumEntries<FeedbackDeviceSelection> getEntries()`  L19
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceSelectionAdapter`
L19 · [class] final FeedbackDeviceSelectionAdapter · extends `BaseAdapter` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceSelectionAdapter.java`
注解：

字段/常量（5）：
- `LayoutInflater inflater`  L20
- `List<FeedbackDeviceSpinnerItem> items`  L21
- `String placeholderText`  L22
- `String strDisplayName`  L65
- `int i`  L66

方法（7）：
- `long getItemId(int position)`  L25 @Override
- `public FeedbackDeviceSelectionAdapter(LayoutInflater inflater, List<FeedbackDeviceSpinnerItem> items, String placeholderText)`  L29
    - 体内字面量："inflater" · "items" · "placeholderText"
- `int getCount()`  L39 @Override
- `FeedbackDeviceSpinnerItem getItem(int position)`  L44 @Override
- `View getView(int position, View convertView, ViewGroup parent)`  L49 @Override
- `View getDropDownView(int position, View convertView, ViewGroup parent)`  L54 @Override
- `View bindView(int position, View convertView, ViewGroup parent, boolean dropDown)`  L64
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceSelectionPolicy`
L17 · [class] public final FeedbackDeviceSelectionPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceSelectionPolicy.java`
注解：

字段/常量（2）：
- `List<FeedbackDeviceSelection> list = options`  L79
- `Object next`  L88

方法（8）：
- `boolean canSubmit(FeedbackDeviceSelection selection, FeedbackDeviceLogState logState)`  L48
    - 体内字面量："selection" · "logState"
- `boolean canSubmit(FeedbackDeviceSelection selection, boolean hasDeviceLog)`  L54
    - 体内字面量："selection"
- `private FeedbackDeviceSelectionPolicy()`  L59
- `List<FeedbackDeviceSelection> getOptions()`  L62
- `FeedbackSelectionAttempt resolveSelectionAttempt(FeedbackDeviceSelection current, FeedbackDeviceSelection requested, FeedbackDeviceLogState logState)`  L66
    - 体内字面量："logState"
- `List<FeedbackDeviceOption> resolveOptions(FeedbackDeviceLogState logState)`  L77
    - 体内字面量："logState"
- `FeedbackDeviceSelection resolveDefaultSelection(List<ConnectedDevice> devices)`  L87
- `throw new NoWhenBranchMatchedException()`  L113
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceSelectionPolicy$WhenMappings`
L23 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceSelectionPolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L24
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceSpinnerItem`
L9 · [class] public final FeedbackDeviceSpinnerItem · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceSpinnerItem.java`
注解：

字段/常量（4）：
- `boolean enabled`  L10
- `FeedbackDeviceSelection selection`  L11
- `boolean showInDropdown`  L12
- `FeedbackDeviceSelection feedbackDeviceSelection = this.selection`  L58

方法（12）：
- `FeedbackDeviceSpinnerItem copy$default(FeedbackDeviceSpinnerItem feedbackDeviceSpinnerItem, FeedbackDeviceSelection feedbackDeviceSelection, boolean z, boolean z2, int i, Object obj)`  L14
- `FeedbackDeviceSelection getSelection()`  L28
- `boolean getEnabled()`  L33
- `boolean getShowInDropdown()`  L38
- `FeedbackDeviceSpinnerItem copy(FeedbackDeviceSelection selection, boolean enabled, boolean showInDropdown)`  L42
- `boolean equals(Object other)`  L46
- `int hashCode()`  L57
- `String toString()`  L62
    - 体内字面量："FeedbackDeviceSpinnerItem(selection=" · ", enabled=" · ", showInDropdown=" · ")"
- `public FeedbackDeviceSpinnerItem(FeedbackDeviceSelection feedbackDeviceSelection, boolean z, boolean z2)`  L66
- `FeedbackDeviceSelection getSelection()`  L72
- `boolean getEnabled()`  L76
- `boolean getShowInDropdown()`  L80
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceSpinnerItems`
L14 · [class] public final FeedbackDeviceSpinnerItems · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceSpinnerItems.java`
注解：

字段/常量（2）：
- `List<FeedbackDeviceOption> list = options`  L22
- `ArrayList arrayList2 = arrayList`  L27

方法（2）：
- `private FeedbackDeviceSpinnerItems()`  L17
- `List<FeedbackDeviceSpinnerItem> build(List<FeedbackDeviceOption> options, FeedbackDeviceSelection selectedDevice)`  L20
    - 体内字面量："options"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceSpinnerRowView`
L16 · [class] public final FeedbackDeviceSpinnerRowView · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceSpinnerRowView.java`
注解：

方法（2）：
- `private FeedbackDeviceSpinnerRowView()`  L19
- `View resolve(LayoutInflater inflater, View convertView, ViewGroup parent)`  L22
    - 体内字面量："inflater" · "inflate(...)"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceSpinnerSelectionGate`
L9 · [class] public final FeedbackDeviceSpinnerSelectionGate · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackDeviceSpinnerSelectionGate.java`
注解：

字段/常量（1）：
- `boolean shouldIgnoreInitialSelection`  L10

方法（3）：
- `public FeedbackDeviceSpinnerSelectionGate(boolean z)`  L12
- `void onUserOpenSelector()`  L16
- `boolean shouldIgnoreSelectionEvent()`  L20
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackSelectionAttempt`
L9 · [class] public final FeedbackSelectionAttempt · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackSelectionAttempt.java`
注解：

字段/常量（3）：
- `boolean allowed`  L10
- `FeedbackDeviceSelection selection`  L11
- `FeedbackDeviceSelection feedbackDeviceSelection = this.selection`  L49

方法（10）：
- `FeedbackSelectionAttempt copy$default(FeedbackSelectionAttempt feedbackSelectionAttempt, FeedbackDeviceSelection feedbackDeviceSelection, boolean z, int i, Object obj)`  L13
- `FeedbackDeviceSelection getSelection()`  L24
- `boolean getAllowed()`  L29
- `FeedbackSelectionAttempt copy(FeedbackDeviceSelection selection, boolean allowed)`  L33
- `boolean equals(Object other)`  L37
- `int hashCode()`  L48
- `String toString()`  L53
    - 体内字面量："FeedbackSelectionAttempt(selection=" · ", allowed=" · ")"
- `public FeedbackSelectionAttempt(FeedbackDeviceSelection feedbackDeviceSelection, boolean z)`  L57
- `FeedbackDeviceSelection getSelection()`  L62
- `boolean getAllowed()`  L66
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackSubmissionScheduler`
L11 · [interface] public FeedbackSubmissionScheduler · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackSubmissionScheduler.java`
注解：

方法（1）：
- `void postDelayed(long delayMs, Function0<Unit> action)`  L12
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackSubmitFlow`
L14 · [class] public final FeedbackSubmitFlow · `com/tuwinsmart/tuwin/presentation/p010ui/mine/FeedbackSubmitFlow.java`
注解：

字段/常量（2）：
- `long SUBMIT_START_DELAY_MS = 100`  L15
- `FeedbackSubmissionScheduler scheduler`  L16

方法（4）：
- `public FeedbackSubmitFlow()`  L19
- `public FeedbackSubmitFlow(FeedbackSubmissionScheduler scheduler)`  L23
    - 体内字面量："scheduler"
- ` FeedbackSubmitFlow(MainThreadFeedbackSubmissionScheduler mainThreadFeedbackSubmissionScheduler, int i, DefaultConstructorMarker defaultConstructorMarker)`  L28
- `void start(Function0<Unit> showSubmitting, Function0<Unit> submit)`  L32
    - 体内字面量："showSubmitting" · "submit"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.fragment.MineFragment`
L41 · [class] public final MineFragment · extends `BaseMainFragment` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/fragment/MineFragment.java`
注解：

字段/常量（18）：
- `int SYSTEM_LANGUAGE_POSITION = 0`  L42
- `FragmentHelperBinding binding`  L43
- `FragmentHelperBinding fragmentHelperBinding = this.binding`  L68
- `FragmentHelperBinding fragmentHelperBinding2 = null`  L69
- `FrameLayout btnLanguage = fragmentHelperBinding.btnLanguage`  L74
- `FragmentHelperBinding fragmentHelperBinding3 = this.binding`  L82
- `BLLinearLayout btnRide5Helper = fragmentHelperBinding3.btnRide5Helper`  L87
- `FragmentHelperBinding fragmentHelperBinding4 = this.binding`  L95
- `TextView btnPrivacy = fragmentHelperBinding4.btnPrivacy`  L100
- `FragmentHelperBinding fragmentHelperBinding5 = this.binding`  L108
- `TextView btnFeedback = fragmentHelperBinding5.btnFeedback`  L113
- `FragmentHelperBinding fragmentHelperBinding6 = this.binding`  L121
- `TextView btnAboutUs = fragmentHelperBinding2.btnAboutUs`  L127
- `ExternalWebActivity.Companion companion = ExternalWebActivity.INSTANCE`  L147
- `FragmentHelperBinding fragmentHelperBinding = this.binding`  L185
- `RecyclerView recyclerView = dialogSettingSelectionBindingInflate.rvOptions`  L200
- `LocaleListCompat localeListCompatForLanguageTags`  L215
- `int i = 0`  L249

方法（22）：
- `void lazyInitData()`  L47 @Override
- `View getLayoutRoot(LayoutInflater inflater, ViewGroup container)`  L51 @Override
    - 体内字面量："inflater" · "inflate(...)" · "binding" · "getRoot(...)"
- `void initFragment()`  L66 @Override
- `void onClick(View view)`  L78 @Override
- `void onClick(View view)`  L91 @Override
- `void onClick(View view)`  L104 @Override
- `void onClick(View view)`  L117 @Override
- `void onClick(View view)`  L131 @Override
- `void initFragment$lambda$0(MineFragment this$0, View view)`  L138
    - 体内字面量："this$0"
- `void initFragment$lambda$1(MineFragment this$0, View view)`  L144
    - 体内字面量："this$0" · "ç¹å»Ride5"
- `void initFragment$lambda$2(MineFragment this$0, View view)`  L154
    - 体内字面量："this$0" · "ç¹å»éç§"
- `void initFragment$lambda$3(MineFragment this$0, View view)`  L161
    - 体内字面量："this$0" · "ç¹å»åé¦"
- `void initFragment$lambda$4(MineFragment this$0, View view)`  L168
    - 体内字面量："this$0" · "ç¹å»å³äº"
- `void fragmentShow()`  L175 @Override
    - 体内字面量："fragmentShow "
- `void fragmentHide()`  L180 @Override
    - 体内字面量："fragmentHide "
- `void refreshLanguageValue()`  L184
- `void showLanguageSelectionDialog()`  L193
    - 体内字面量："inflate(...)"
- `Unit invoke(Integer num)`  L209 @Override
- `void invoke(int i)`  L214
- `void onClick(View view)`  L232 @Override
- `void showLanguageSelectionDialog$lambda$6(BottomSheetDialog dialog, View view)`  L240
    - 体内字面量："$dialog"
- `int currentLanguagePosition()`  L245
    - 体内字面量："toLanguageTags(...)"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.fragment.MineFragment$LanguageOption`
L273 · [class] static final LanguageOption · `com/tuwinsmart/tuwin/presentation/p010ui/mine/fragment/MineFragment.java`
注解：

字段/常量（2）：
- `String languageTag`  L274
- `int nameResId`  L275

方法（10）：
- `LanguageOption copy$default(LanguageOption languageOption, String str, int i, int i2, Object obj)`  L277
- `String getLanguageTag()`  L288
- `int getNameResId()`  L293
- `LanguageOption copy(String languageTag, int nameResId)`  L297
    - 体内字面量："languageTag"
- `boolean equals(Object other)`  L302
- `int hashCode()`  L313
- `String toString()`  L317
    - 体内字面量："LanguageOption(languageTag=" · ", nameResId=" · ")"
- `public LanguageOption(String languageTag, int i)`  L321
    - 体内字面量："languageTag"
- `String getLanguageTag()`  L327
- `int getNameResId()`  L331
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.fragment.MineFragment$LanguageOptionsAdapter`
L339 · [class] static final LanguageOptionsAdapter · extends `RecyclerView.Adapter<OptionViewHolder>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/fragment/MineFragment.java`
注解：

字段/常量（3）：
- `int currentPosition`  L340
- `Function1<Integer, Unit> onItemClick`  L341
- `List<LanguageOption> options`  L342

方法（6）：
- `public LanguageOptionsAdapter(List<LanguageOption> options, int i, Function1<? super Integer, Unit> onItemClick)`  L345
    - 体内字面量："options" · "onItemClick"
- `OptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L354 @Override
    - 体内字面量："parent"
- `void onBindViewHolder(OptionViewHolder holder, final int position)`  L362 @Override
    - 体内字面量："holder"
- `void onClick(View view)`  L368 @Override
- `void onBindViewHolder$lambda$0(LanguageOptionsAdapter this$0, int i, View view)`  L375
    - 体内字面量："this$0"
- `int getItemCount()`  L381 @Override
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/mine/fragment/MineFragment$LanguageOptionsAdapter$OptionViewHolder;" · "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;" · "view" · "Landroid/view/View;" · "(Landroid/view/View;)V" · "textView" · "Landroid/widget/TextView;" · "getTextView" · "()Landroid/widget/TextView;" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.fragment.MineFragment$LanguageOptionsAdapter$OptionViewHolder`
L387 · [class] public static final OptionViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/fragment/MineFragment.java`
注解：

字段/常量（1）：
- `TextView textView`  L388

方法（2）：
- `public OptionViewHolder(View view)`  L391
    - 体内字面量："view" · "findViewById(...)"
- `TextView getTextView()`  L399
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MainThreadFeedbackSubmissionScheduler`
L14 · [class] public final MainThreadFeedbackSubmissionScheduler · implements `FeedbackSubmissionScheduler` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MainThreadFeedbackSubmissionScheduler.java`
注解：

方法（4）：
- `private MainThreadFeedbackSubmissionScheduler()`  L18
- `void postDelayed$lambda$0(Function0 tmp0)`  L22
    - 体内字面量："$tmp0"
- `void postDelayed(long delayMs, final Function0<Unit> action)`  L28 @Override
    - 体内字面量："action"
- `void run()`  L32 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity`
L81 · [class] public final MoreSettingsActivity · extends `ToolBarActivity implements View.OnClickListener` · implements `View.OnClickListener` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（141）：
- `String EXTRA_DEVICE_TYPE_CODE = "extra_device_type_code"`  L82
- `String EXTRA_IDENTITY_SESSION_ID = "device_identity_session_id"`  L83
- `String EXTRA_RESULT_MEDIA_MODE = "extra_result_media_mode"`  L84
- `String EXTRA_SESSION_ID = "device_session_id"`  L85
- `String NORMAL_RECORD_MODE = "NORM_REC"`  L86
- `String WIFI_DEFAULT_STATE = "WIFI_DEAULT_STATE"`  L87
- `ActivityMoreSettingsBinding binding`  L88
- `int currentRequestIndex`  L89
- `String currentWifiMode`  L90
- `String[] recordList`  L91
- `String[] videoSizeList`  L92
- `List<String> wifiModeOptions`  L93
- `List<String> windNoiseCapability`  L94
- `boolean isInitializingUrgentLevel = true`  L95
- `boolean isInitializingParkingLevel = true`  L96
- `boolean isInitializingShangxia = true`  L97
- `boolean isInitializingZuoyou = true`  L98
- `boolean isInitializingRecordVoice = true`  L99
- `boolean isInitializingWindNoise = true`  L100
- `String string`  L146
- `String str`  L403
- `String version`  L404
- `String string`  L405
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this.binding`  L414
- `ActivityMoreSettingsBinding activityMoreSettingsBinding2 = null`  L415
- `FrameLayout btnCircleRecordDuration = activityMoreSettingsBinding.btnCircleRecordDuration`  L420
- `MoreSettingsActivity moreSettingsActivity = this`  L422
- `ActivityMoreSettingsBinding activityMoreSettingsBinding3 = this.binding`  L424
- `TextView btnSyncTime = activityMoreSettingsBinding3.btnSyncTime`  L429
- `ActivityMoreSettingsBinding activityMoreSettingsBinding4 = this.binding`  L432
- `FrameLayout btnDpiSetting = activityMoreSettingsBinding4.btnDpiSetting`  L437
- `ActivityMoreSettingsBinding activityMoreSettingsBinding5 = this.binding`  L440
- `FrameLayout btnDeviceName = activityMoreSettingsBinding5.btnDeviceName`  L445
- `ActivityMoreSettingsBinding activityMoreSettingsBinding6 = this.binding`  L448
- `TextView btnStorageSetting = activityMoreSettingsBinding6.btnStorageSetting`  L453
- `ActivityMoreSettingsBinding activityMoreSettingsBinding7 = this.binding`  L456
- `TextView btnSoftwareUpdate = activityMoreSettingsBinding7.btnSoftwareUpdate`  L461
- `ActivityMoreSettingsBinding activityMoreSettingsBinding8 = this.binding`  L464
- `TextView btnResetDevice = activityMoreSettingsBinding8.btnResetDevice`  L469
- `ActivityMoreSettingsBinding activityMoreSettingsBinding9 = this.binding`  L472
- `TextView btnWifiSetting = activityMoreSettingsBinding9.btnWifiSetting`  L477
- `ActivityMoreSettingsBinding activityMoreSettingsBinding10 = this.binding`  L480
- `FrameLayout btnWifiMode = activityMoreSettingsBinding10.btnWifiMode`  L485
- `ActivityMoreSettingsBinding activityMoreSettingsBinding11 = this.binding`  L493
- `LinearLayout btnUrgentLevel = activityMoreSettingsBinding11.btnUrgentLevel`  L498
- `ActivityMoreSettingsBinding activityMoreSettingsBinding12 = this.binding`  L501
- `LinearLayout btnParkingLevel = activityMoreSettingsBinding12.btnParkingLevel`  L506
- `ActivityMoreSettingsBinding activityMoreSettingsBinding13 = this.binding`  L510
- `TextView textView = activityMoreSettingsBinding13.tvSoftVersion`  L515
- `ActivityMoreSettingsBinding activityMoreSettingsBinding14 = this.binding`  L528
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this.binding`  L552
- `ActivityMoreSettingsBinding activityMoreSettingsBinding2 = this.binding`  L560
- `ActivityMoreSettingsBinding activityMoreSettingsBinding3 = this.binding`  L568
- `ActivityMoreSettingsBinding activityMoreSettingsBinding4 = this.binding`  L576
- `Switch switchShangxia = activityMoreSettingsBinding4.switchShangxia`  L581
- `ActivityMoreSettingsBinding activityMoreSettingsBinding5 = this.binding`  L586
- `Switch switchZuoyou = activityMoreSettingsBinding5.switchZuoyou`  L591
- `ActivityMoreSettingsBinding activityMoreSettingsBinding6 = this.binding`  L596
- `ActivityMoreSettingsBinding activityMoreSettingsBinding7 = this.binding`  L604
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this.binding`  L711
- `List<String> list = this.wifiModeOptions`  L722
- `List<String> list2 = list`  L723
- `List<String> list3 = list`  L743
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this.binding`  L943
- `TextView textView = activityMoreSettingsBinding.tvWifiModeDesc`  L948
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this.binding`  L962
- `ActivityMoreSettingsBinding activityMoreSettingsBinding2 = null`  L963
- `ActivityMoreSettingsBinding activityMoreSettingsBinding3 = this.binding`  L974
- `ActivityMoreSettingsBinding activityMoreSettingsBinding4 = this.binding`  L985
- `ActivityMoreSettingsBinding activityMoreSettingsBinding5 = this.binding`  L996
- `ActivityMoreSettingsBinding activityMoreSettingsBinding6 = this.binding`  L1007
- `ActivityMoreSettingsBinding activityMoreSettingsBinding7 = this.binding`  L1018
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this$0.binding`  L1041
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this$0.binding`  L1068
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this$0.binding`  L1087
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this$0.binding`  L1114
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this$0.binding`  L1163
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this$0.binding`  L1190
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this.binding`  L1203
- `ActivityMoreSettingsBinding activityMoreSettingsBinding2 = null`  L1204
- `Unit unit = null`  L1205
- `Unit unit2 = null`  L1206
- `ActivityMoreSettingsBinding activityMoreSettingsBinding3 = null`  L1207
- `ActivityMoreSettingsBinding activityMoreSettingsBinding4 = this.binding`  L1225
- `ActivityMoreSettingsBinding activityMoreSettingsBinding5 = this.binding`  L1235
- `ActivityMoreSettingsBinding activityMoreSettingsBinding6 = this.binding`  L1253
- `ActivityMoreSettingsBinding activityMoreSettingsBinding7 = this.binding`  L1261
- `ActivityMoreSettingsBinding activityMoreSettingsBinding8 = this.binding`  L1275
- `MoreSettingsActivity moreSettingsActivity = MoreSettingsActivity.this`  L1299
- `String str = currentSSID`  L1300
- `String str2 = currentBSSID`  L1301
- `ActivityMoreSettingsBinding activityMoreSettingsBinding9 = this.binding`  L1314
- `ActivityMoreSettingsBinding activityMoreSettingsBinding10 = this.binding`  L1324
- `ActivityMoreSettingsBinding activityMoreSettingsBinding11 = this.binding`  L1343
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this$0.binding`  L1367
- `int iIndexOf`  L1403
- `String[] strArr = this.recordList`  L1405
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this.binding`  L1407
- `String[] strArr = this$0.recordList`  L1427
- `int iIndexOf`  L1432
- `String[] strArr = this.videoSizeList`  L1434
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = this.binding`  L1436
- `String[] strArr = this$0.videoSizeList`  L1456
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = null`  L1829
- `ActivityMoreSettingsBinding activityMoreSettingsBinding2 = this.binding`  L1831
- `ActivityMoreSettingsBinding activityMoreSettingsBinding3 = this.binding`  L1841
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = null`  L1856
- `ActivityMoreSettingsBinding activityMoreSettingsBinding2 = this.binding`  L1861
- `Switch r6 = activityMoreSettingsBinding2.switchParkingLevel`  L1866
- `ActivityMoreSettingsBinding activityMoreSettingsBinding3 = this.binding`  L1867
- `ActivityMoreSettingsBinding activityMoreSettingsBinding4 = this.binding`  L1881
- `Switch r7 = activityMoreSettingsBinding4.switchZuoyou`  L1886
- `ActivityMoreSettingsBinding activityMoreSettingsBinding5 = this.binding`  L1887
- `ActivityMoreSettingsBinding activityMoreSettingsBinding6 = this.binding`  L1900
- `Switch r8 = activityMoreSettingsBinding6.switchShangxia`  L1905
- `ActivityMoreSettingsBinding activityMoreSettingsBinding7 = this.binding`  L1906
- `ActivityMoreSettingsBinding activityMoreSettingsBinding8 = this.binding`  L1920
- `Switch r9 = activityMoreSettingsBinding8.switchRecordVoice`  L1925
- `ActivityMoreSettingsBinding activityMoreSettingsBinding9 = this.binding`  L1926
- `ActivityMoreSettingsBinding activityMoreSettingsBinding10 = this.binding`  L1940
- `Switch r10 = activityMoreSettingsBinding10.switchUrgentLevel`  L1945
- `ActivityMoreSettingsBinding activityMoreSettingsBinding11 = this.binding`  L1946
- `ActivityMoreSettingsBinding activityMoreSettingsBinding12 = this.binding`  L1960
- `Switch r11 = activityMoreSettingsBinding12.switchWindNoise`  L1965
- `ActivityMoreSettingsBinding activityMoreSettingsBinding13 = this.binding`  L1966
- `String[] strArrDefaultRecordDurations`  L2078
- `List listSplit$default`  L2079
- `String[] strArr`  L2080
- `List listSplit$default2`  L2081
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = null`  L2083
- `ActivityMoreSettingsBinding activityMoreSettingsBinding2 = null`  L2084
- `String strReplace$default = null`  L2085
- `ActivityMoreSettingsBinding activityMoreSettingsBinding3 = null`  L2086
- `ActivityMoreSettingsBinding activityMoreSettingsBinding4 = null`  L2087
- `ActivityMoreSettingsBinding activityMoreSettingsBinding5 = this.binding`  L2092
- `ActivityMoreSettingsBinding activityMoreSettingsBinding6 = this.binding`  L2106
- `ActivityMoreSettingsBinding activityMoreSettingsBinding7 = this.binding`  L2120
- `ActivityMoreSettingsBinding activityMoreSettingsBinding8 = this.binding`  L2134
- `TextView textView = activityMoreSettingsBinding8.tvCircleRecordDuration`  L2139
- `List<String> list = listSplit$default`  L2152
- `ActivityMoreSettingsBinding activityMoreSettingsBinding9 = this.binding`  L2173

方法（91）：
- `DeviceType invoke()`  L111 @Override
    - 体内字面量："extra_device_type_code"
- `String invoke()`  L132 @Override
    - 体内字面量："device_session_id"
- `String invoke()`  L145 @Override
- `DeviceSessionBinding invoke()`  L168 @Override
- `String invoke()`  L180 @Override
- `ConnectedDevice invoke()`  L195 @Override
- `SessionBoundOtaIdentity invoke()`  L212 @Override
- `MoreSettingsCapabilityConfig invoke()`  L225 @Override
- `Ride5SessionPortProvider invoke()`  L234 @Override
- `LinkedHashMap<String, String> invoke()`  L246 @Override
    - 体内字面量："OFF" · "ON" · "ALWAYSON"
- `void setupSwitchListeners$lambda$10$lambda$9(View view)`  L252
- `void setupSwitchListeners$lambda$16$lambda$15(View view)`  L256
- `void setupSwitchListeners$lambda$7$lambda$6(View view)`  L260
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/mine/MoreSettingsActivity$RequestItem;" · "type" · "pType" · "isCommParam" · "(Ljava/lang/String;IZ)V" · "()Z" · "getPType" · "()I" · "getType" · "()Ljava/lang/String;" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
- `DeviceType getCurrentDeviceType()`  L347
- `String getRequestedOperationSessionId()`  L352
- `String getIdentitySessionId()`  L357
- `DeviceSessionBinding getSessionBinding()`  L362
- `String getDeviceSessionId()`  L366
- `ConnectedDevice getCurrentSessionDevice()`  L370
- `SessionBoundOtaIdentity getCurrentOtaIdentity()`  L374
- `MoreSettingsCapabilityConfig getCapabilityConfig()`  L378
- `Ride5SessionPortProvider getRide5SessionPortProvider()`  L382
- `View getContentRoot()`  L387 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L402 @Override
- `void onClick(View view)`  L489 @Override
- `void onCreate$lambda$0(MoreSettingsActivity this$0, View view)`  L545
    - 体内字面量："this$0"
- `void applyCapabilityVisibility()`  L550
- `void hideSwitchRow(View switchView)`  L618
- `void initRequestQueue()`  L627
- `void executeNextRequest()`  L636
    - 体内字面量："ææè®¾ç½®è¯·æ±å·²å®æ" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity$refreshWifiModeState$1" · "MoreSettingsActivity.kt" · "invokeSuspend"
- `void refreshWifiModeState()`  L710
- `void showWifiModeSelector()`  L721
- `Unit invoke()`  L731 @Override
- `void invoke2()`  L737
- `void onItemClick(View view, int i)`  L759 @Override
- `void showWifiModeSelector$lambda$4(List list, MoreSettingsActivity this$0, View view, int i)`  L766
    - 体内字面量："this$0" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity$fetchWifiModeOptions$1" · "MoreSettingsActivity.kt" · "invokeSuspend"
- `void fetchWifiModeOptions(Function0<Unit> onReady)`  L872
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity$setWifiMode$1" · "MoreSettingsActivity.kt" · "invokeSuspend"
- `void setWifiMode(String value)`  L936
- `void updateWifiModeDesc(String value)`  L942
- `LinkedHashMap<String, String> getWifiModeDescriptions()`  L957
- `void setupSwitchListeners()`  L961
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L970 @Override
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L981 @Override
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L992 @Override
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L1003 @Override
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L1014 @Override
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L1026 @Override
- `void setupSwitchListeners$lambda$7(final MoreSettingsActivity this$0, CompoundButton buttonView, boolean z)`  L1033
    - 体内字面量："this$0" · "buttonView"
- `void onClick(View view)`  L1050 @Override
- `void onClick(View view)`  L1055 @Override
    - 体内字面量："GSR_SENSITIVITY" · "OFF"
- `void setupSwitchListeners$lambda$7$lambda$5(MoreSettingsActivity this$0, View view)`  L1065
    - 体内字面量："this$0"
- `void setupSwitchListeners$lambda$10(final MoreSettingsActivity this$0, CompoundButton buttonView, boolean z)`  L1079
    - 体内字面量："this$0" · "buttonView"
- `void onClick(View view)`  L1096 @Override
- `void onClick(View view)`  L1101 @Override
    - 体内字面量："GSR_PARKING" · "OFF"
- `void setupSwitchListeners$lambda$10$lambda$8(MoreSettingsActivity this$0, View view)`  L1111
    - 体内字面量："this$0"
- `void setupSwitchListeners$lambda$11(MoreSettingsActivity this$0, CompoundButton buttonView, boolean z)`  L1125
    - 体内字面量："this$0" · "buttonView" · "FLIP" · "ON" · "OFF"
- `void setupSwitchListeners$lambda$12(MoreSettingsActivity this$0, CompoundButton buttonView, boolean z)`  L1135
    - 体内字面量："this$0" · "buttonView" · "MIRROR" · "ON" · "OFF"
- `void setupSwitchListeners$lambda$13(MoreSettingsActivity this$0, CompoundButton buttonView, boolean z)`  L1145
    - 体内字面量："this$0" · "buttonView" · "AUDIO" · "0"
- `void setupSwitchListeners$lambda$16(final MoreSettingsActivity this$0, CompoundButton compoundButton, boolean z)`  L1155
    - 体内字面量："this$0" · "<anonymous parameter 0>"
- `void onClick(View view)`  L1172 @Override
- `void onClick(View view)`  L1177 @Override
    - 体内字面量："VCAPVQE" · "OFF"
- `void setupSwitchListeners$lambda$16$lambda$14(MoreSettingsActivity this$0, View view)`  L1187
    - 体内字面量："this$0"
- `void onClick(View view)`  L1201 @Override
- `boolean onInput(String str, String str2)`  L1269 @Override
- `boolean onInput(String input, String input2)`  L1290 @Override
- `void onClick(View view2)`  L1356 @Override
- `boolean onClick$lambda$21(MoreSettingsActivity this$0, String str, String str2)`  L1365
    - 体内字面量："this$0"
- `void onClick$lambda$23(MoreSettingsActivity this$0, View view)`  L1381
    - 体内字面量："this$0"
- `boolean isValidWifiName(String wifiName)`  L1386
    - 体内字面量："^[a-zA-Z0-9_-]{8,32}$"
- `boolean isValidWifiPwd(String wifiPwd)`  L1394
    - 体内字面量："^[a-zA-Z0-9_-]{8,20}$"
- `void showRecord()`  L1402
- `void onItemClick(View view, int i)`  L1418 @Override
- `void showRecord$lambda$24(MoreSettingsActivity this$0, View view, int i)`  L1425
    - 体内字面量："this$0"
- `void showVideoSize()`  L1431
- `void onItemClick(View view, int i)`  L1447 @Override
- `void showVideoSize$lambda$25(MoreSettingsActivity this$0, View view, int i)`  L1454
    - 体内字面量："this$0"
- `void setSettings(String type, String value, int pType)`  L1460
    - 体内字面量："è®¾ç½®è®¾å¤åæ°: type=%s pType=%d" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity$setSettings$1" · "MoreSettingsActivity.kt" · "invokeSuspend" · "recordingStopped" · "restartAttempted" · "recordingStopped" · "restartAttempted" · "recordingStopped" · "restartAttempted" · "recordingStopped" · "restartAttempted" · "L$0" · "I$0" · "I$1" · "L$0" · "I$0" · "I$1" · "L$0" · "I$0" · "I$1" · "L$0" · "I$0" · "I$1"
- `void onSetSettingSuccess(String type, String value)`  L1828
- `void onSetSettingFailure(String type)`  L1854
- `void getSettings(String type, int pType)`  L2069
    - 体内字面量："è¯»åè®¾å¤åæ°: type=%s pType=%d"
- `void renderSetting(String type, int pType, Ride5CgiPayload payload)`  L2077
- `void renderSettingFailure(String type, int pType)`  L2195
    - 体内字面量："Rec_Split_Time" · "MEDIAMODE" · "1080P+1080P"
- `String[] defaultRecordDurations()`  L2208
    - 体内字面量："getString(...)" · "getString(...)" · "getString(...)" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity$getCommParam$1" · "MoreSettingsActivity.kt" · "invokeSuspend"
- `void getCommParam(String type)`  L2449
    - 体内字面量："è¯»åè®¾å¤éç¨åæ°: type=%s"
- `void setWifi(String ssidHint, String bssidHint, String wifiName, String wifiPwd)`  L2455
    - 体内字面量："è®¾å¤ Wi-Fi æ¬å°éåæ´æ°è·³è¿: oldLength=%d newLength=%d" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity$setWifi$1" · "MoreSettingsActivity.kt" · "invokeSuspend" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity$loadWindNoiseCapability$1" · "MoreSettingsActivity.kt" · "invokeSuspend"
- `void loadWindNoiseCapability()`  L2604
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity$syncTime$1" · "MoreSettingsActivity.kt" · "invokeSuspend"
- `void syncTime()`  L2659
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity$resetDevice$1" · "MoreSettingsActivity.kt" · "invokeSuspend"
- `void resetDevice()`  L2727
- `Ride5SessionPort ride5Port()`  L2733
- `void logRide5Failure(String operation, Exception error)`  L2738
    - 体内字面量："RIDE5 è®¾ç½®æä½å¤±è´¥: operation=%s session=%s"
- `String safeFailureCode(Throwable th)`  L2743
    - 体内字面量："DeviceOperationFailed"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27751`
L775 · [class] static final C27751 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（10）：
- `Function0<Unit> $onReady`  L776
- `int label`  L777
- `ArrayList arrayList`  L798
- `List list`  L799
- `List listSplit$default`  L800
- `int i = this.label`  L802
- `List list2 = listSplit$default`  L823
- `MoreSettingsActivity moreSettingsActivity = MoreSettingsActivity.this`  L829
- `MoreSettingsActivity moreSettingsActivity2 = MoreSettingsActivity.this`  L838
- `MoreSettingsActivity moreSettingsActivity3 = MoreSettingsActivity.this`  L857

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L786 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L791 @Override
- `Object invokeSuspend(Object obj)`  L797 @Override
- `throw new IllegalStateException( 238 )`  L815
    - 体内字面量："capability" · ","
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27761`
L2222 · [class] static final C27761 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（11）：
- `String $type`  L2223
- `int label`  L2224
- `Object objCommonParameter`  L2256
- `ActivityMoreSettingsBinding activityMoreSettingsBinding`  L2257
- `ActivityMoreSettingsBinding activityMoreSettingsBinding2`  L2258
- `ActivityMoreSettingsBinding activityMoreSettingsBinding3`  L2259
- `ActivityMoreSettingsBinding activityMoreSettingsBinding4`  L2260
- `int i = this.label`  L2262
- `String str = this.$type`  L2280
- `ActivityMoreSettingsBinding activityMoreSettingsBinding5 = null`  L2282
- `ActivityMoreSettingsBinding activityMoreSettingsBinding6 = MoreSettingsActivity.this.binding`  L2288

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L2233 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L2238 @Override
- `Object invokeSuspend(Object obj)`  L2255 @Override
- `throw new IllegalStateException( 454 )`  L2274
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27771`
L1984 · [class] static final C27771 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（6）：
- `int $pType`  L1985
- `String $type`  L1986
- `int label`  L1987
- `Ride5CgiPayload ride5CgiPayload`  L2008
- `int i = this.label`  L2010
- `int i2 = this.$pType`  L2016

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1997 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L2002 @Override
- `Object invokeSuspend(Object obj)`  L2007 @Override
- `throw new IllegalStateException( 412 )`  L2047
    - 体内字面量："read_"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27781`
L2532 · [class] static final C27781 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（8）：
- `Object L$0`  L2533
- `int label`  L2534
- `MoreSettingsActivity moreSettingsActivity`  L2552
- `ArrayList arrayList`  L2553
- `List listSplit$default`  L2554
- `int i = this.label`  L2556
- `MoreSettingsActivity moreSettingsActivity2 = MoreSettingsActivity.this`  L2560
- `List list = listSplit$default`  L2580

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L2541 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L2546 @Override
- `Object invokeSuspend(Object obj)`  L2551 @Override
- `throw new IllegalStateException( 502 )`  L2571
    - 体内字面量："capability" · ","
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27801`
L654 · [class] static final C27801 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（3）：
- `int label`  L655
- `int i = this.label`  L674
- `ActivityMoreSettingsBinding activityMoreSettingsBinding = MoreSettingsActivity.this.binding`  L699

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L662 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L667 @Override
- `Object invokeSuspend(Object obj)`  L672 @Override
- `throw new IllegalStateException( 224 )`  L685
    - 体内字面量："value" · "read_wifi_mode"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27811`
L2667 · [class] static final C27811 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（2）：
- `int label`  L2668
- `int i = this.label`  L2687

方法（6）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L2675 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L2680 @Override
- `Object invokeSuspend(Object obj)`  L2685 @Override
- `throw new IllegalStateException( 522 )`  L2698
- `void onClick(View view)`  L2704 @Override
- `void invokeSuspend$lambda$0(View view)`  L2722
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27821`
L1470 · [class] static final C27821 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（24）：
- `int $pType`  L1471
- `String $type`  L1472
- `String $value`  L1473
- `int I$0`  L1474
- `int I$1`  L1475
- `Object L$0`  L1476
- `int label`  L1477
- `Ride5SessionPort ride5SessionPort`  L1510
- `int i`  L1511
- `Ride5SessionPort ride5SessionPort2`  L1512
- `int i2`  L1513
- `String str`  L1514
- `String str2`  L1515
- `String strReplace$default`  L1516
- `int i3`  L1517
- `int i4`  L1518
- `Ride5SessionPort ride5SessionPort3`  L1519
- `int i5`  L1520
- `int i6 = this.label`  L1522
- `int i7 = 0`  L1523
- `int i8 = 1`  L1524
- `int i9 = this.I$0`  L1627
- `Ride5SessionPort ride5SessionPort4 = ride5SessionPort3`  L1753
- `int i10 = this.I$0`  L1770

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1488 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1493 @Override
- `Object invokeSuspend(Object obj)`  L1509 @Override
- `throw new IllegalStateException( 380 )`  L1795
    - 体内字面量："write_" · "restore_recording_after_"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27831`
L2472 · [class] static final C27831 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（4）：
- `String $wifiName`  L2473
- `String $wifiPwd`  L2474
- `int label`  L2475
- `int i = this.label`  L2497

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L2485 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L2490 @Override
- `Object invokeSuspend(Object obj)`  L2495 @Override
- `throw new IllegalStateException( 493 )`  L2508
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27841`
L881 · [class] static final C27841 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（3）：
- `String $value`  L882
- `int label`  L883
- `int i = this.label`  L904

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L892 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L897 @Override
- `Object invokeSuspend(Object obj)`  L902 @Override
- `throw new IllegalStateException( 252 )`  L915
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$C27861`
L2612 · [class] static final C27861 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（2）：
- `int label`  L2613
- `int i = this.label`  L2632

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L2620 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L2625 @Override
- `Object invokeSuspend(Object obj)`  L2630 @Override
- `throw new IllegalStateException( 514 )`  L2645
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity$RequestItem`
L265 · [class] private static final RequestItem · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsActivity.java`
注解：

字段/常量（3）：
- `boolean isCommParam`  L266
- `int pType`  L267
- `String type`  L268

方法（13）：
- `RequestItem copy$default(RequestItem requestItem, String str, int i, boolean z, int i2, Object obj)`  L270
- `String getType()`  L284
- `int getPType()`  L289
- `boolean getIsCommParam()`  L294
- `RequestItem copy(String type, int pType, boolean isCommParam)`  L298
    - 体内字面量："type"
- `boolean equals(Object other)`  L303
- `int hashCode()`  L314
- `String toString()`  L318
    - 体内字面量："RequestItem(type=" · ", pType=" · ", isCommParam=" · ")"
- `public RequestItem(String type, int i, boolean z)`  L322
    - 体内字面量："type"
- ` RequestItem(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L329
- `String getType()`  L333
- `int getPType()`  L337
- `boolean isCommParam()`  L341
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsCapabilityConfig`
L12 · [class] public final MoreSettingsCapabilityConfig · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsCapabilityConfig.java`
注解：

字段/常量（4）：
- `Set<MoreSettingsUiItem> hiddenItems`  L13
- `List<MoreSettingsRequestSpec> requestQueue`  L14
- `boolean supportsWifiMode`  L15
- `boolean supportsWindNoiseCapabilityRequest`  L16

方法（14）：
- `MoreSettingsCapabilityConfig copy$default(MoreSettingsCapabilityConfig moreSettingsCapabilityConfig, Set set, List list, boolean z, boolean z2, int i, Object obj)`  L19
- `Set<MoreSettingsUiItem> component1()`  L35
- `List<MoreSettingsRequestSpec> component2()`  L39
- `boolean getSupportsWifiMode()`  L44
- `boolean getSupportsWindNoiseCapabilityRequest()`  L49
- `MoreSettingsCapabilityConfig copy(Set<? extends MoreSettingsUiItem> hiddenItems, List<MoreSettingsRequestSpec> requestQueue, boolean supportsWifiMode, boolean supportsWindNoiseCapabilityRequest)`  L53
    - 体内字面量："hiddenItems" · "requestQueue"
- `boolean equals(Object other)`  L59
- `int hashCode()`  L70
- `String toString()`  L74
    - 体内字面量："MoreSettingsCapabilityConfig(hiddenItems=" · ", requestQueue=" · ", supportsWifiMode=" · ", supportsWindNoiseCapabilityRequest=" · ")"
- `public MoreSettingsCapabilityConfig(Set<? extends MoreSettingsUiItem> hiddenItems, List<MoreSettingsRequestSpec> requestQueue, boolean z, boolean z2)`  L79
    - 体内字面量："hiddenItems" · "requestQueue"
- `Set<MoreSettingsUiItem> getHiddenItems()`  L88
- `List<MoreSettingsRequestSpec> getRequestQueue()`  L92
- `boolean getSupportsWifiMode()`  L96
- `boolean getSupportsWindNoiseCapabilityRequest()`  L100
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsCapabilityPolicy`
L16 · [class] public final MoreSettingsCapabilityPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsCapabilityPolicy.java`
注解：

字段/常量（2）：
- `Set<MoreSettingsUiItem> set = ride3ProHiddenItems`  L28
- `List<MoreSettingsRequestSpec> list = fullRequestQueue`  L29

方法（2）：
- `private MoreSettingsCapabilityPolicy()`  L23
- `MoreSettingsCapabilityConfig resolve(DeviceType deviceType)`  L26
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsRequestSpec`
L11 · [class] public final MoreSettingsRequestSpec · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsRequestSpec.java`
注解：

字段/常量（3）：
- `boolean isCommParam`  L12
- `int pType`  L13
- `String type`  L14

方法（13）：
- `MoreSettingsRequestSpec copy$default(MoreSettingsRequestSpec moreSettingsRequestSpec, String str, int i, boolean z, int i2, Object obj)`  L16
- `String getType()`  L30
- `int getPType()`  L35
- `boolean getIsCommParam()`  L40
- `MoreSettingsRequestSpec copy(String type, int pType, boolean isCommParam)`  L44
    - 体内字面量："type"
- `boolean equals(Object other)`  L49
- `int hashCode()`  L60
- `String toString()`  L64
    - 体内字面量："MoreSettingsRequestSpec(type=" · ", pType=" · ", isCommParam=" · ")"
- `public MoreSettingsRequestSpec(String type, int i, boolean z)`  L68
    - 体内字面量："type"
- ` MoreSettingsRequestSpec(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L75
- `String getType()`  L79
- `int getPType()`  L83
- `boolean isCommParam()`  L87
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsUiItem`
L11 · [enum] public MoreSettingsUiItem · `com/tuwinsmart/tuwin/presentation/p010ui/mine/MoreSettingsUiItem.java`
注解：

枚举常量（7）：
- `EMERGENCY_RECORDING()`  L12
- `PARKING_MONITOR()`  L13
- `WIND_NOISE_REDUCTION()`  L14
- `FLIP_VERTICAL()`  L15
- `FLIP_HORIZONTAL()`  L16
- `WIFI_MODE()`  L17
- `FIRMWARE_UPDATE()`  L18

方法（1）：
- `EnumEntries<MoreSettingsUiItem> getEntries()`  L22
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaCompletionSignal`
L11 · [enum] public OtaCompletionSignal · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaCompletionSignal.java`
注解：

枚举常量（2）：
- `UploadAccepted()`  L12
- `InstallationCompleted()`  L13

方法（1）：
- `EnumEntries<OtaCompletionSignal> getEntries()`  L17
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaDeviceExperienceProfile`
L10 · [class] public final OtaDeviceExperienceProfile · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaDeviceExperienceProfile.java`
注解：

字段/常量（3）：
- `OtaDeviceProfile core`  L11
- `int installMessageResId`  L12
- `int installSubtitleResId`  L13

方法（12）：
- `OtaDeviceExperienceProfile copy$default(OtaDeviceExperienceProfile otaDeviceExperienceProfile, OtaDeviceProfile otaDeviceProfile, int i, int i2, int i3, Object obj)`  L15
- `OtaDeviceProfile getCore()`  L29
- `int getInstallMessageResId()`  L34
- `int getInstallSubtitleResId()`  L39
- `OtaDeviceExperienceProfile copy(OtaDeviceProfile core, int installMessageResId, int installSubtitleResId)`  L43
    - 体内字面量："core"
- `boolean equals(Object other)`  L48
- `int hashCode()`  L59
- `String toString()`  L63
    - 体内字面量："OtaDeviceExperienceProfile(core=" · ", installMessageResId=" · ", installSubtitleResId=" · ")"
- `public OtaDeviceExperienceProfile(OtaDeviceProfile core, int i, int i2)`  L67
    - 体内字面量："core"
- `OtaDeviceProfile getCore()`  L74
- `int getInstallMessageResId()`  L78
- `int getInstallSubtitleResId()`  L82
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaDeviceProfile`
L11 · [class] public final OtaDeviceProfile · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaDeviceProfile.java`
注解：

字段/常量（3）：
- `OtaCompletionSignal completionSignal`  L12
- `OtaPreparation preparation`  L13
- `OtaTransportKind transport`  L14

方法（12）：
- `OtaDeviceProfile copy$default(OtaDeviceProfile otaDeviceProfile, OtaTransportKind otaTransportKind, OtaPreparation otaPreparation, OtaCompletionSignal otaCompletionSignal, int i, Object obj)`  L16
- `OtaTransportKind getTransport()`  L30
- `OtaPreparation getPreparation()`  L35
- `OtaCompletionSignal getCompletionSignal()`  L40
- `OtaDeviceProfile copy(OtaTransportKind transport, OtaPreparation preparation, OtaCompletionSignal completionSignal)`  L44
    - 体内字面量："transport" · "preparation" · "completionSignal"
- `boolean equals(Object other)`  L51
- `int hashCode()`  L62
- `String toString()`  L66
    - 体内字面量："OtaDeviceProfile(transport=" · ", preparation=" · ", completionSignal=" · ")"
- `public OtaDeviceProfile(OtaTransportKind transport, OtaPreparation preparation, OtaCompletionSignal completionSignal)`  L70
    - 体内字面量："transport" · "preparation" · "completionSignal"
- `OtaTransportKind getTransport()`  L79
- `OtaPreparation getPreparation()`  L83
- `OtaCompletionSignal getCompletionSignal()`  L87
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaDeviceProfilePolicy`
L13 · [class] public final OtaDeviceProfilePolicy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaDeviceProfilePolicy.java`
注解：

方法（3）：
- `private OtaDeviceProfilePolicy()`  L43
- `OtaDeviceExperienceProfile resolve(DeviceType deviceType)`  L46
- `throw new NoWhenBranchMatchedException()`  L60
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaDeviceProfilePolicy$WhenMappings`
L18 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaDeviceProfilePolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L19
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaFailurePolicy`
L16 · [class] public final OtaFailurePolicy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaFailurePolicy.java`
注解：

字段/常量（3）：
- `String CONNECTION_RESET = "connection reset"`  L17
- `String EXTERNAL_POWER_ERROR_CODE = "result=-10"`  L18
- `String message`  L50

方法（6）：
- `private OtaFailurePolicy()`  L21
- `OtaFailurePrompt resolve$default(OtaFailurePolicy otaFailurePolicy, DeviceType deviceType, Throwable th, boolean z, int i, Object obj)`  L24
- `OtaFailurePrompt resolve(DeviceType deviceType, Throwable error, boolean installationAwaitingResult)`  L31
    - 体内字面量："error"
- `boolean isConnectionReset(Throwable th)`  L49
- `boolean isExternalPowerErrorCode(Throwable th)`  L58
- `boolean isTimeout(Throwable th)`  L67
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaFailurePrompt`
L11 · [enum] public OtaFailurePrompt · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaFailurePrompt.java`
注解：

枚举常量（5）：
- `ExternalPowerCheck()`  L12
- `M3SdCardRemoved()`  L13
- `M3SdCardNotFormatted()`  L14
- `M3InstallationTimeout()`  L15
- `GenericInstallFailed()`  L16

方法（1）：
- `EnumEntries<OtaFailurePrompt> getEntries()`  L20
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaPreparation`
L11 · [enum] public OtaPreparation · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaPreparation.java`
注解：

枚举常量（3）：
- `StopRecordingBeforeUpload()`  L12
- `StopRecordingOnPageEntry()`  L13
- `None()`  L14

方法（1）：
- `EnumEntries<OtaPreparation> getEntries()`  L18
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaTransportKind`
L11 · [enum] public OtaTransportKind · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaTransportKind.java`
注解：

枚举常量（3）：
- `LegacyChunked()`  L12
- `Ride3ProDirect()`  L13
- `M3Direct()`  L14

方法（1）：
- `EnumEntries<OtaTransportKind> getEntries()`  L18
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeFlow`
L13 · [class] public final OtaUpgradeFlow · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeFlow.java`
注解：

字段/常量（3）：
- `OtaUpgradeState state = OtaUpgradeState.Idle.INSTANCE`  L14
- `OtaUpgradeState otaUpgradeState = this.state`  L40
- `OtaUpgradeState.Uploading uploading`  L70

方法（15）：
- `OtaUpgradeState getState()`  L35
- `boolean getBlocksNavigation()`  L39
- `throw new NoWhenBranchMatchedException()`  L47
- `void reset()`  L50
- `void beginPreparing()`  L54
- `void beginUpload(int initialPercent)`  L58
- `OtaUpgradeState onUploadProgress$default(OtaUpgradeFlow otaUpgradeFlow, long j, long j2, OtaCompletionSignal otaCompletionSignal, int i, Object obj)`  L62
- `OtaUpgradeState onUploadProgress(long total, long progress, OtaCompletionSignal completionSignal)`  L69
- `throw new NoWhenBranchMatchedException()`  L79
- `void onDeviceAccepted(int countdownSeconds)`  L90
- `void onInstallationCompleted()`  L94
- `void updateInstallationCountdown(int remainingSeconds)`  L98
- `void onInstallationConfirmationReady()`  L102
- `void onUserConfirmed()`  L106
- `void fail(OtaFailurePrompt prompt)`  L110
    - 体内字面量："prompt"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeFlow$WhenMappings`
L18 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeFlow.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L19
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState`
L11 · [class] public abstract OtaUpgradeState · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

方法（2）：
- ` OtaUpgradeState(DefaultConstructorMarker defaultConstructorMarker)`  L12
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$Idle;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "()V" · "app_release_64"
- `private OtaUpgradeState()`  L26
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$Preparing;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$Uploading;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "percent" · "(I)V" · "getPercent" · "()I" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$AwaitingDeviceAcknowledgement;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$InstallingAwaitingDeviceResult;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$InstallationSucceeded;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$InstallingSafetyWindow;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "remainingSeconds" · "(I)V" · "getRemainingSeconds" · "()I" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$AwaitingUserConfirmation;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$AwaitingReconnectVerification;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState$Failed;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaUpgradeState;" · "prompt" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaFailurePrompt;" · "(Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaFailurePrompt;)V" · "getPrompt" · "()Lcom/tuwinsmart/tuwin/presentation/ui/mine/OtaFailurePrompt;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$AwaitingDeviceAcknowledgement`
L87 · [class] public static final AwaitingDeviceAcknowledgement · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

方法（1）：
- `private AwaitingDeviceAcknowledgement()`  L90
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$AwaitingReconnectVerification`
L173 · [class] public static final AwaitingReconnectVerification · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

方法（1）：
- `private AwaitingReconnectVerification()`  L176
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$AwaitingUserConfirmation`
L163 · [class] public static final AwaitingUserConfirmation · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

方法（1）：
- `private AwaitingUserConfirmation()`  L166
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$Failed`
L183 · [class] public static final Failed · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

字段/常量（1）：
- `OtaFailurePrompt prompt`  L184

方法（8）：
- `Failed copy$default(Failed failed, OtaFailurePrompt otaFailurePrompt, int i, Object obj)`  L186
- `OtaFailurePrompt getPrompt()`  L194
- `Failed copy(OtaFailurePrompt prompt)`  L198
    - 体内字面量："prompt"
- `boolean equals(Object other)`  L203
- `int hashCode()`  L210
- `String toString()`  L214
    - 体内字面量："Failed(prompt=" · ")"
- `public Failed(OtaFailurePrompt prompt)`  L219
    - 体内字面量："prompt"
- `OtaFailurePrompt getPrompt()`  L225
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$Idle`
L18 · [class] public static final Idle · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

方法（1）：
- `private Idle()`  L21
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$InstallationSucceeded`
L107 · [class] public static final InstallationSucceeded · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

方法（1）：
- `private InstallationSucceeded()`  L110
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$InstallingAwaitingDeviceResult`
L97 · [class] public static final InstallingAwaitingDeviceResult · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

方法（1）：
- `private InstallingAwaitingDeviceResult()`  L100
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$InstallingSafetyWindow`
L117 · [class] public static final InstallingSafetyWindow · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

字段/常量（1）：
- `int remainingSeconds`  L118

方法（8）：
- `InstallingSafetyWindow copy$default(InstallingSafetyWindow installingSafetyWindow, int i, int i2, Object obj)`  L120
- `int getRemainingSeconds()`  L128
- `InstallingSafetyWindow copy(int remainingSeconds)`  L132
- `boolean equals(Object other)`  L136
- `int hashCode()`  L143
- `String toString()`  L147
    - 体内字面量："InstallingSafetyWindow(remainingSeconds=" · ")"
- `public InstallingSafetyWindow(int i)`  L151
- `int getRemainingSeconds()`  L156
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$Preparing`
L31 · [class] public static final Preparing · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

方法（1）：
- `private Preparing()`  L34
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaUpgradeState$Uploading`
L41 · [class] public static final Uploading · extends `OtaUpgradeState` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/OtaUpgradeState.java`
注解：

字段/常量（1）：
- `int percent`  L42

方法（8）：
- `Uploading copy$default(Uploading uploading, int i, int i2, Object obj)`  L44
- `int getPercent()`  L52
- `Uploading copy(int percent)`  L56
- `boolean equals(Object other)`  L60
- `int hashCode()`  L67
- `String toString()`  L71
    - 体内字面量："Uploading(percent=" · ")"
- `public Uploading(int i)`  L75
- `int getPercent()`  L80
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.PrivacyActivity`
L19 · [class] public final PrivacyActivity · extends `ToolBarActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/PrivacyActivity.java`
注解：

字段/常量（2）：
- `ActivityPrivacyBinding binding`  L20
- `PrivacyActivity privacyActivity = this`  L40

方法（2）：
- `View getContentRoot()`  L23 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L37 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.Ride3ProUpgradeSuccessPolicy`
L10 · [class] public final Ride3ProUpgradeSuccessPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/Ride3ProUpgradeSuccessPolicy.java`
注解：

方法（2）：
- `boolean clearUploadedFirmware(String filePath)`  L13
- `private Ride3ProUpgradeSuccessPolicy()`  L17
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity`
L95 · [class] public final UpgradeActivity · extends `ToolBarActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（93）：
- `int COUNTDOWN_SECONDS = 30`  L96
- `String EXTRA_DEVICE_TYPE_CODE = "device_type_code"`  L97
- `String EXTRA_IDENTITY_SESSION_ID = "device_identity_session_id"`  L98
- `String EXTRA_SESSION_ID = "device_session_id"`  L99
- `long M3_RESULT_DISPLAY_MILLIS = 1500`  L100
- `boolean isFirmwareInstalling`  L101
- `ActivityUpgradeBinding binding`  L102
- `LocalUpgradeBean currentBean`  L103
- `String currentBoardVersion`  L104
- `DeviceType currentDeviceType`  L105
- `String currentVersion`  L106
- `UpgradeBean downloadBean`  L107
- `FirmwareUploadDialog firmwareUploadDialog`  L108
- `int lastUploadPercent`  L109
- `Long lastUploadTotalBytes`  L110
- `Long lastUploadedBytes`  L111
- `Lazy<M3DeviceRepository> m3DeviceRepositoryDelegate`  L112
- `Lazy m3SessionRepositoryFactory`  L115
- `Lazy networkRuntime`  L118
- `String operationSessionId`  L119
- `OtaUpgradeFlow otaFlow`  L120
- `Lazy ride3ProFirmwareUploadRepository`  L123
- `Lazy ride3ProRecordRepository`  L126
- `Lazy ride5SessionPortProvider`  L129
- `UpgradeDevice upgradeDevice`  L130
- `String upgradeModel`  L131
- `boolean uploadFailureHandled`  L132
- `UpgradeActivity upgradeActivity = this`  L213
- `LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED`  L214
- `Qualifier qualifier = null`  L215
- `Object[] objArr = 0 == true ? 1 : 0`  L216
- `ComponentCallbacks componentCallbacks = upgradeActivity`  L221
- `String str = this.this$0.operationSessionId`  L234
- `LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED`  L242
- `Object[] objArr2 = 0 == true ? 1 : 0`  L243
- `Object[] objArr3 = 0 == true ? 1 : 0`  L244
- `ComponentCallbacks componentCallbacks = upgradeActivity`  L249
- `LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED`  L253
- `Object[] objArr4 = 0 == true ? 1 : 0`  L254
- `Object[] objArr5 = 0 == true ? 1 : 0`  L255
- `ComponentCallbacks componentCallbacks = upgradeActivity`  L260
- `UpgradeActivity upgradeActivity2 = this.this$0`  L314
- `String str = upgradeActivity2.operationSessionId`  L324
- `ActivityUpgradeBinding activityUpgradeBinding = this.binding`  L369
- `String str = this.currentVersion`  L383
- `DeviceType deviceType`  L409
- `String string`  L410
- `int length = deviceTypeArrValues.length`  L419
- `int i = 0`  L420
- `UpgradeDevice upgradeDevice = this.upgradeDevice`  L480
- `UpgradeHelper upgradeHelper = UpgradeHelper.INSTANCE`  L645
- `String str = this.currentBoardVersion`  L647
- `Unit unit = null`  L648
- `DeviceType deviceType = this.currentDeviceType`  L653
- `String str2 = this.upgradeModel`  L654
- `LocalUpgradeBean localUpgradeBean = this.currentBean`  L672
- `UpgradeHelper upgradeHelper = UpgradeHelper.INSTANCE`  L674
- `LocalUpgradeBean localUpgradeBean2 = this.currentBean`  L675
- `LocalUpgradeBean localUpgradeBean3 = this.currentBean`  L677
- `String str = this.operationSessionId`  L703
- `LocalUpgradeBean localUpgradeBean = this.currentBean`  L937
- `Unit unit`  L952
- `LocalUpgradeBean localUpgradeBean = this.currentBean`  L953
- `int i = C1870R.string.latest_version_format`  L978
- `FirmwareUploadDialog firmwareUploadDialog = this.firmwareUploadDialog`  L1018
- `String str = this.operationSessionId`  L1413
- `String str`  L1498
- `String str2`  L1499
- `Object objM3074constructorimpl`  L1593
- `Network network`  L1594
- `String str = this.operationSessionId`  L1598
- `String str2 = str`  L1603
- `Result.Companion companion = Result.INSTANCE`  L1608
- `UpgradeActivity upgradeActivity = this`  L1609
- `Result.Companion companion2 = Result.INSTANCE`  L1627
- `String str = this.operationSessionId`  L1635
- `String str2 = null`  L1636
- `String str3 = this.operationSessionId`  L1643
- `Object objM3074constructorimpl`  L1669
- `UpgradeDevice upgradeDevice`  L1670
- `Result.Companion companion = Result.INSTANCE`  L1676
- `UpgradeActivity upgradeActivity = this`  L1677
- `Unit unit = null`  L1679
- `Result.Companion companion2 = Result.INSTANCE`  L1687
- `FirmwareUploadDialog firmwareUploadDialog = this.firmwareUploadDialog`  L1711
- `FirmwareUploadDialog firmwareUploadDialog = this.firmwareUploadDialog`  L1740
- `String newVersion`  L1761
- `LocalUpgradeBean localUpgradeBean = this.currentBean`  L1762
- `String str = null`  L1766
- `OtaQueryPolicy otaQueryPolicy = OtaQueryPolicy.INSTANCE`  L1773
- `String str2 = this.currentBoardVersion`  L1775
- `DeviceType deviceType = this.currentDeviceType`  L1780
- `String str3 = this.upgradeModel`  L1781

方法（74）：
- `public UpgradeActivity()`  L212
- `M3SessionRepositoryFactory invoke()`  L220 @Override
- `M3DeviceRepository invoke()`  L232 @Override
- `Ride5SessionPortProvider invoke()`  L248 @Override
- `NetworkRuntime invoke()`  L259 @Override
- `Ride3ProFirmwareUploadRepository invoke()`  L286 @Override
- `Ride3ProRecordRepositoryImpl invoke()`  L312 @Override
- `Ride3ProRequestExecutor invoke()`  L322 @Override
- `M3SessionRepositoryFactory getM3SessionRepositoryFactory()`  L339
- `M3DeviceRepository getM3DeviceRepository()`  L344
- `Ride5SessionPortProvider getRide5SessionPortProvider()`  L349
- `NetworkRuntime getNetworkRuntime()`  L354
- `Ride3ProFirmwareUploadRepository getRide3ProFirmwareUploadRepository()`  L359
- `Ride3ProRecordRepositoryImpl getRide3ProRecordRepository()`  L364
- `ActivityUpgradeBinding getBinding()`  L368
- `void setBinding(ActivityUpgradeBinding activityUpgradeBinding)`  L377
    - 体内字面量："<set-?>"
- `String getCurrentVersion()`  L382
- `void setCurrentVersion(String str)`  L391
    - 体内字面量："<set-?>"
- `View getContentRoot()`  L397 @Override
    - 体内字面量："inflate(...)" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L408 @Override
- `void onClick(View view)`  L466 @Override
- `boolean handleMessage(Message message)`  L475 @Override
- `void onCreate$lambda$5(final UpgradeActivity this$0, View view)`  L488
    - 体内字面量："this$0"
- `void onClick(View view2)`  L495 @Override
- `void onCreate$lambda$5$lambda$4(UpgradeActivity this$0, View view)`  L502
    - 体内字面量："this$0"
- `boolean onCreate$lambda$6(UpgradeActivity this$0, Message message)`  L511
    - 体内字面量："this$0" · "<anonymous parameter 0>" · "com/tuwinsmart/tuwin/presentation/ui/mine/UpgradeActivity$onCreate$4" · "Lcom/tuwinsmart/tuwin/core/util/UpgradeDevice$UploadListener;" · "onUploadFailed" · "onUploadSuccess" · "onUploading" · "total" · "progress" · "app_release_64"
- `void prepareUpgradePage()`  L578
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.UpgradeActivity$prepareUpgradePage$1" · "UpgradeActivity.kt" · "invokeSuspend"
- `void loadUpgradeInfo()`  L644
- `void startUpgrade()`  L671
- `void startLegacyUpgrade(final File upgradeFile)`  L699
- `Unit invoke(Boolean bool)`  L715 @Override
- `void invoke(boolean z)`  L720
- `void startRide3ProUpgrade(File file)`  L733
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.UpgradeActivity$startRide3ProUpgrade$1" · "UpgradeActivity.kt" · "invokeSuspend"
- `OtaFailurePrompt showUploadFailurePrompt(Throwable error)`  L837
    - 体内字面量："getString(...)"
- `void showExternalPowerCheckCard()`  L858
- `void startM3Upgrade(File file)`  L864
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.UpgradeActivity$startM3Upgrade$1" · "UpgradeActivity.kt" · "invokeSuspend"
- `Ride3ProFirmwareMeta resolveRide3ProFirmwareMeta(File file)`  L936
- `void restoreUpgradeReadyState()`  L951
- `void showNoUpdate()`  L965
- `void showNewUpdate(String newVersion, String versionLog)`  L972
- `void showUploadingProgress(long total, long progress)`  L992
- `void showUploadPercent(int percent, long progress, long total)`  L1005
- `void showUploadStarting()`  L1025
    - 体内字面量："0"
- `void showRide3ProUploadFailed()`  L1041
- `void showDownloadFailed()`  L1059
    - 体内字面量："0"
- `void showInstalling()`  L1077
- `void showAwaitingDeviceAcknowledgement()`  L1089
    - 体内字面量："100"
- `void showM3Installing()`  L1102
- `void showM3InstallationSuccess()`  L1108
- `void run()`  L1113 @Override
- `void showM3InstallationSuccess$lambda$12(UpgradeActivity this$0)`  L1120
    - 体内字面量："this$0"
- `void showM3InstallationTimeout()`  L1126
- `void run()`  L1130 @Override
- `void showM3InstallationTimeout$lambda$13(UpgradeActivity this$0)`  L1137
    - 体内字面量："this$0"
- `void showM3InstallationFailedState()`  L1142
- `void showInstallationSafetyDialog()`  L1157
- `void onClick(View view)`  L1168 @Override
- `void showInstallationSafetyDialog$lambda$14(UpgradeActivity this$0, View view)`  L1182
    - 体内字面量："this$0" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.mine.UpgradeActivity$showInstallationSafetyDialog$1" · "UpgradeActivity.kt" · "invokeSuspend"
- `void showInstallConfirmReadyCopy(TextView titleView, TextView messageView, UpgradeInstallConfirmButtonPolicy.ReadyCopy readyCopy)`  L1302
- `java.lang.Object runInstallConfirmButtonCountdown(android.widget.Button r8, java.lang.Integer r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11)`  L1327
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
- `throw new UnsupportedOperationException( 237 )`  L1408
- `void checkUpgradePktInfo(File file)`  L1412
- `void uploadFile(File file, String offset, String unitsize)`  L1497
- `UpgradeDevice createRide5UpgradeDevice()`  L1592
- `Ride3ProSessionApiService ride3ProSessionService()`  L1633
- `void handleUploadFailed()`  L1655
- `void onDestroy()`  L1668 @Override
- `void onBackPressed()`  L1703 @Override
- `FirmwareUploadDialog getOrCreateFirmwareUploadDialog()`  L1710
- `Unit invoke()`  L1723 @Override
- `void invoke2()`  L1729
- `void hideFirmwareUploadDialog()`  L1739
- `void completeUpgradeAndReturnHome()`  L1747
- `void suppressRepeatDownloadPrompt()`  L1760
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27871`
L1431 · [class] static final C27871 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（7）：
- `File $file`  L1432
- `String $sessionId`  L1433
- `int label`  L1434
- `String str`  L1455
- `int i = this.label`  L1457
- `String str4 = str2`  L1475
- `UpgradeActivity upgradeActivity = UpgradeActivity.this`  L1479

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1444 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1449 @Override
- `Object invokeSuspend(Object obj)`  L1454 @Override
- `throw new IllegalStateException( 247 )`  L1468
    - 体内字面量："offset" · "unitsize"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27884`
L521 · [class] public static final C27884 · implements `UpgradeDevice.UploadListener` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（3）：
- `UpgradeActivity upgradeActivity = UpgradeActivity.this`  L527
- `UpgradeActivity upgradeActivity = UpgradeActivity.this`  L544
- `UpgradeActivity upgradeActivity = UpgradeActivity.this`  L568

方法（9）：
- `void onUploading(final int total, final int progress)`  L526 @Override
- `void run()`  L530 @Override
- `void onUploading$lambda$0(UpgradeActivity this$0, int i, int i2)`  L537
    - 体内字面量："this$0"
- `void onUploadSuccess()`  L543 @Override
- `void run()`  L547 @Override
- `void onUploadSuccess$lambda$1(UpgradeActivity this$0)`  L554
    - 体内字面量："this$0"
- `void onUploadFailed$lambda$2(UpgradeActivity this$0)`  L561
    - 体内字面量："this$0"
- `void onUploadFailed()`  L567 @Override
- `void run()`  L571 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27891`
L592 · [class] static final C27891 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（4）：
- `int label`  L593
- `int i = this.label`  L612
- `UpgradeActivity upgradeActivity = UpgradeActivity.this`  L628
- `UpgradeActivity upgradeActivity2 = UpgradeActivity.this`  L633

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L600 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L605 @Override
- `Object invokeSuspend(Object obj)`  L610 @Override
- `throw new IllegalStateException( 200 )`  L622
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27901`
L272 · [class] C27901 · extends `FunctionReferenceImpl implements Function0<Ride3ProSessionApiService>` · implements `Function0<Ride3ProSessionApiService>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

方法（1）：
- `Ride3ProSessionApiService invoke()`  L279 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27911`
L298 · [class] C27911 · extends `FunctionReferenceImpl implements Function0<Ride3ProSessionApiService>` · implements `Function0<Ride3ProSessionApiService>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

方法（1）：
- `Ride3ProSessionApiService invoke()`  L305 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27931`
L191 · [class] static final C27931 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（6）：
- `int I$0`  L192
- `int I$1`  L193
- `Object L$0`  L194
- `Object L$1`  L195
- `int label`  L196
- `Object result`  L197

方法（1）：
- `Object invokeSuspend(Object obj)`  L204 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27941`
L1191 · [class] static final C27941 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（19）：
- `Button $btnPos`  L1192
- `TextView $messageView`  L1193
- `TextView $titleView`  L1194
- `Object L$0`  L1195
- `Object L$1`  L1196
- `Object L$2`  L1197
- `Object L$3`  L1198
- `Object L$4`  L1199
- `int label`  L1200
- `TextView textView`  L1242
- `UpgradeActivity upgradeActivity`  L1243
- `Iterator it`  L1244
- `Button button`  L1245
- `TextView textView2`  L1246
- `int i = this.label`  L1248
- `UpgradeActivity upgradeActivity2 = UpgradeActivity.this`  L1252
- `Button button2 = this.$btnPos`  L1253
- `TextView textView3 = this.$messageView`  L1255
- `int i3 = C1870R.string.upgrade_installing_upgrading_countdown`  L1276

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1231 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1236 @Override
- `Object invokeSuspend(Object obj)`  L1241 @Override
- `throw new IllegalStateException( 236 )`  L1262
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27941$WhenMappings`
L1205 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L1206
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27961`
L875 · [class] static final C27961 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（6）：
- `File $file`  L876
- `int label`  L877
- `Object objMo2802uploadFirmwareBWLJW6A`  L897
- `int i = this.label`  L899
- `UpgradeActivity upgradeActivity = UpgradeActivity.this`  L917
- `UpgradeActivity upgradeActivity2 = UpgradeActivity.this`  L922

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L886 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L891 @Override
- `Object invokeSuspend(Object obj)`  L896 @Override
- `throw new IllegalStateException( 221 )`  L912
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C27981`
L743 · [class] static final C27981 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（8）：
- `File $file`  L744
- `int label`  L745
- `Object objM2819uploadFirmwareBWLJW6A`  L767
- `UpgradeActivity upgradeActivity`  L768
- `File file`  L769
- `UpgradeActivity upgradeActivity2`  L770
- `Throwable thM3077exceptionOrNullimpl`  L771
- `int i = this.label`  L773

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L754 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L759 @Override
- `Object invokeSuspend(Object obj)`  L766 @Override
- `throw new IllegalStateException( 211 )`  L786
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$C28001`
L1511 · [class] static final C28001 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（10）：
- `File $file`  L1512
- `String $offset`  L1513
- `String $unitsize`  L1514
- `Object L$0`  L1515
- `int label`  L1516
- `boolean zBooleanValue`  L1538
- `UpgradeDevice upgradeDevice`  L1539
- `CancellationException e`  L1540
- `int i = this.label`  L1542
- `UpgradeDevice upgradeDeviceCreateRide5UpgradeDevice = UpgradeActivity.this.upgradeDevice`  L1546

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1527 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1532 @Override
- `Object invokeSuspend(Object obj)`  L1537 @Override
- `throw new IllegalStateException( 262 )`  L1568
    - 体内字面量："RIDE5 OTA upload failed"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$checkUpgradePktInfo$1$response$1`
L23 · [class] final UpgradeActivity$checkUpgradePktInfo$1$response$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Ride5CgiPayload>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Ride5CgiPayload>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$checkUpgradePktInfo$1$response$1.java`
注解：

字段/常量（7）：
- `File $file`  L24
- `String $sessionId`  L25
- `int label`  L26
- `UpgradeActivity this$0`  L27
- `int i = this.label`  L50
- `String str = this.this$0.upgradeModel`  L54
- `LocalUpgradeBean localUpgradeBean = this.this$0.currentBean`  L59

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L38 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Ride5CgiPayload> continuation)`  L43 @Override
- `Object invokeSuspend(Object obj)`  L48 @Override
- `throw new IllegalStateException( 8 )`  L68
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$getOrCreateFirmwareUploadDialog$1$1`
L12 · [class] UpgradeActivity$getOrCreateFirmwareUploadDialog$1$1 · extends `FunctionReferenceImpl implements Function0<Unit>` · implements `Function0<Unit>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$getOrCreateFirmwareUploadDialog$1$1.java`
注解：

方法（2）：
- `Unit invoke()`  L18 @Override
- `void invoke2()`  L24
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$prepareUpgradePage$1$result$1`
L19 · [class] final UpgradeActivity$prepareUpgradePage$1$result$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$prepareUpgradePage$1$result$1.java`
注解：

字段/常量（4）：
- `int label`  L20
- `UpgradeActivity this$0`  L21
- `Object objM2866stopRecordingIoAF18A`  L46
- `int i = this.label`  L48

方法（5）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L30 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation)`  L35 @Override
- `Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation)`  L40
- `Object invokeSuspend(Object obj)`  L45 @Override
- `throw new IllegalStateException( 8 )`  L58
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$startM3Upgrade$1$result$1`
L14 · [class] final UpgradeActivity$startM3Upgrade$1$result$1 · extends `Lambda implements Function2<Long, Long, Unit>` · implements `Function2<Long, Long, Unit>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$startM3Upgrade$1$result$1.java`
注解：

字段/常量（2）：
- `UpgradeActivity this$0`  L15
- `UpgradeActivity upgradeActivity = this.this$0`  L30

方法（4）：
- `Unit invoke(Long l, Long l2)`  L24 @Override
- `void invoke(final long j, final long j2)`  L29
- `void run()`  L33 @Override
- `void invoke$lambda$0(long j, long j2, UpgradeActivity this$0)`  L40
    - 体内字面量："this$0"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$startRide3ProUpgrade$1$result$1`
L14 · [class] final UpgradeActivity$startRide3ProUpgrade$1$result$1 · extends `Lambda implements Function2<Long, Long, Unit>` · implements `Function2<Long, Long, Unit>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$startRide3ProUpgrade$1$result$1.java`
注解：

字段/常量（2）：
- `UpgradeActivity this$0`  L15
- `UpgradeActivity upgradeActivity = this.this$0`  L30

方法（4）：
- `Unit invoke(Long l, Long l2)`  L24 @Override
- `void invoke(final long j, final long j2)`  L29
- `void run()`  L33 @Override
- `void invoke$lambda$0(long j, long j2, UpgradeActivity this$0)`  L40
    - 体内字面量："this$0"
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$startRide3ProUpgrade$1$stopResult$1`
L19 · [class] final UpgradeActivity$startRide3ProUpgrade$1$stopResult$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$startRide3ProUpgrade$1$stopResult$1.java`
注解：

字段/常量（4）：
- `int label`  L20
- `UpgradeActivity this$0`  L21
- `Object objM2866stopRecordingIoAF18A`  L46
- `int i = this.label`  L48

方法（5）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L30 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation)`  L35 @Override
- `Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation)`  L40
- `Object invokeSuspend(Object obj)`  L45 @Override
- `throw new IllegalStateException( 8 )`  L58
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$uploadFile$1$completed$1`
L21 · [class] final UpgradeActivity$uploadFile$1$completed$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Boolean>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity$uploadFile$1$completed$1.java`
注解：

字段/常量（5）：
- `File $file`  L22
- `String $offset`  L23
- `String $unitsize`  L24
- `UpgradeDevice $uploader`  L25
- `int label`  L26

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L38 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation)`  L43 @Override
- `Object invokeSuspend(Object obj)`  L48 @Override
- `throw new IllegalStateException( 7 )`  L51
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity$WhenMappings`
L136 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeActivity.java`
注解：

字段/常量（3）：
- `int[] $EnumSwitchMapping$0`  L137
- `int[] $EnumSwitchMapping$1`  L138
- `int[] $EnumSwitchMapping$2`  L139
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeInstallConfirmButtonPolicy`
L18 · [class] public final UpgradeInstallConfirmButtonPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeInstallConfirmButtonPolicy.java`
注解：

方法（3）：
- `private UpgradeInstallConfirmButtonPolicy()`  L34
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ReadyCopy;" · "titleResId" · "messageResId" · "(II)V" · "getMessageResId" · "()I" · "getTitleResId" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ButtonStep;" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ButtonPhase;" · "seconds" · "readyCopy" · "Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ReadyCopy;" · "(Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ButtonPhase;Ljava/lang/Integer;Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ReadyCopy;)V" · "getPhase" · "()Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ButtonPhase;" · "getReadyCopy" · "()Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ReadyCopy;" · "getSeconds" · "()Ljava/lang/Integer;" · "Ljava/lang/Integer;" · "component1" · "component2" · "component3" · "copy" · "(Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ButtonPhase;Ljava/lang/Integer;Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ReadyCopy;)Lcom/tuwinsmart/tuwin/presentation/ui/mine/UpgradeInstallConfirmButtonPolicy$ButtonStep;" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
- `List resolveSteps$default(UpgradeInstallConfirmButtonPolicy upgradeInstallConfirmButtonPolicy, DeviceType deviceType, int i, int i2, Object obj)`  L183
- `List<ButtonStep> resolveSteps(DeviceType deviceType, int countdownSeconds)`  L190
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeInstallConfirmButtonPolicy$ButtonPhase`
L23 · [enum] public ButtonPhase · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeInstallConfirmButtonPolicy.java`
注解：

枚举常量（2）：
- `UpgradingCountdown()`  L24
- `ConfirmReady()`  L25

方法（1）：
- `EnumEntries<ButtonPhase> getEntries()`  L29
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeInstallConfirmButtonPolicy$ButtonStep`
L102 · [class] public static final ButtonStep · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeInstallConfirmButtonPolicy.java`
注解：

字段/常量（5）：
- `ButtonPhase phase`  L103
- `ReadyCopy readyCopy`  L104
- `Integer seconds`  L105
- `Integer num = this.seconds`  L153
- `ReadyCopy readyCopy = this.readyCopy`  L155

方法（12）：
- `ButtonStep copy$default(ButtonStep buttonStep, ButtonPhase buttonPhase, Integer num, ReadyCopy readyCopy, int i, Object obj)`  L107
- `ButtonPhase getPhase()`  L121
- `Integer getSeconds()`  L126
- `ReadyCopy getReadyCopy()`  L131
- `ButtonStep copy(ButtonPhase phase, Integer seconds, ReadyCopy readyCopy)`  L135
    - 体内字面量："phase"
- `boolean equals(Object other)`  L140
- `int hashCode()`  L151
- `String toString()`  L159
    - 体内字面量："ButtonStep(phase=" · ", seconds=" · ", readyCopy=" · ")"
- `public ButtonStep(ButtonPhase phase, Integer num, ReadyCopy readyCopy)`  L163
    - 体内字面量："phase"
- `ButtonPhase getPhase()`  L170
- `Integer getSeconds()`  L174
- `ReadyCopy getReadyCopy()`  L178
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeInstallConfirmButtonPolicy$ReadyCopy`
L39 · [class] public static final ReadyCopy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeInstallConfirmButtonPolicy.java`
注解：

字段/常量（2）：
- `int messageResId`  L40
- `int titleResId`  L41

方法（10）：
- `ReadyCopy copy$default(ReadyCopy readyCopy, int i, int i2, int i3, Object obj)`  L43
- `int getTitleResId()`  L54
- `int getMessageResId()`  L59
- `ReadyCopy copy(int titleResId, int messageResId)`  L63
- `boolean equals(Object other)`  L67
- `int hashCode()`  L78
- `String toString()`  L82
    - 体内字面量："ReadyCopy(titleResId=" · ", messageResId=" · ")"
- `public ReadyCopy(int i, int i2)`  L86
- `int getTitleResId()`  L91
- `int getMessageResId()`  L95
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeInstallCopyPolicy`
L11 · [class] public final UpgradeInstallCopyPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeInstallCopyPolicy.java`
注解：

方法（2）：
- `private UpgradeInstallCopyPolicy()`  L14
- `UpgradeInstallCopyResIds resolve(DeviceType deviceType)`  L17
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeInstallCopyResIds`
L9 · [class] public final UpgradeInstallCopyResIds · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeInstallCopyResIds.java`
注解：

字段/常量（2）：
- `int firmwareSubtitleResId`  L10
- `int messageResId`  L11

方法（10）：
- `UpgradeInstallCopyResIds copy$default(UpgradeInstallCopyResIds upgradeInstallCopyResIds, int i, int i2, int i3, Object obj)`  L13
- `int getMessageResId()`  L24
- `int getFirmwareSubtitleResId()`  L29
- `UpgradeInstallCopyResIds copy(int messageResId, int firmwareSubtitleResId)`  L33
- `boolean equals(Object other)`  L37
- `int hashCode()`  L48
- `String toString()`  L52
    - 体内字面量："UpgradeInstallCopyResIds(messageResId=" · ", firmwareSubtitleResId=" · ")"
- `public UpgradeInstallCopyResIds(int i, int i2)`  L56
- `int getMessageResId()`  L61
- `int getFirmwareSubtitleResId()`  L65
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeSuccessActionPolicy`
L11 · [class] public final UpgradeSuccessActionPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeSuccessActionPolicy.java`
注解：

方法（2）：
- `private UpgradeSuccessActionPolicy()`  L26
- `ConfirmAction afterConfirm()`  L29
### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeSuccessActionPolicy$ConfirmAction`
L16 · [enum] public ConfirmAction · `com/tuwinsmart/tuwin/presentation/p010ui/mine/UpgradeSuccessActionPolicy.java`
注解：

枚举常量（1）：
- `ReturnToHomeDeviceList()`  L17

方法（1）：
- `EnumEntries<ConfirmAction> getEntries()`  L21