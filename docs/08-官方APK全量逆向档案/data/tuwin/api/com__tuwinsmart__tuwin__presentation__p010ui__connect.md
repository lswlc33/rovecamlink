# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.presentation.p010ui.connect

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 16 个文件 / 37 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.ConnectFlowLifecycleGate`
L10 · [class] public final ConnectFlowLifecycleGate · `com/tuwinsmart/tuwin/presentation/p010ui/connect/ConnectFlowLifecycleGate.java`
注解：

字段/常量（2）：
- `long DEFAULT_DURATION_MS = 120000`  L11
- `long suppressUntilMs`  L13

方法（6）：
- `private ConnectFlowLifecycleGate()`  L15
- `void begin$default(ConnectFlowLifecycleGate connectFlowLifecycleGate, long j, long j2, int i, Object obj)`  L18
- `void begin(long nowMs, long durationMs)`  L28
- `void clear()`  L32
- `boolean shouldSuppressAutoActions$default(ConnectFlowLifecycleGate connectFlowLifecycleGate, long j, int i, Object obj)`  L36
- `boolean shouldSuppressAutoActions(long nowMs)`  L43
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.ConnectHelperActivity`
L38 · [class] public final ConnectHelperActivity · extends `ToolBarActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/ConnectHelperActivity.java`
注解：

字段/常量（33）：
- `String EXTRA_DEVICE_TYPE = "extra_device_type"`  L42
- `ActivityConnectHelperBinding binding`  L43
- `DeviceType deviceType`  L44
- `HelperItem helperItem`  L45
- `ActivityConnectHelperBinding activityConnectHelperBinding = this.binding`  L116
- `ActivityConnectHelperBinding activityConnectHelperBinding2 = null`  L117
- `ActivityConnectHelperBinding activityConnectHelperBinding3 = this.binding`  L123
- `ActivityConnectHelperBinding activityConnectHelperBinding4 = this.binding`  L134
- `DeviceConfig.Companion companion = DeviceConfig.INSTANCE`  L152
- `DeviceType deviceType = this.deviceType`  L153
- `ActivityConnectHelperBinding activityConnectHelperBinding = null`  L154
- `ActivityConnectHelperBinding activityConnectHelperBinding2 = this.binding`  L160
- `HelperItem helperItem = this.helperItem`  L166
- `ActivityConnectHelperBinding activityConnectHelperBinding3 = this.binding`  L172
- `ActivityConnectHelperBinding activityConnectHelperBinding4 = this.binding`  L178
- `TextView textView = activityConnectHelperBinding4.tvMsg`  L183
- `HelperItem helperItem2 = this.helperItem`  L184
- `ActivityConnectHelperBinding activityConnectHelperBinding5 = this.binding`  L190
- `ActivityConnectHelperBinding activityConnectHelperBinding6 = this.binding`  L196
- `ActivityConnectHelperBinding activityConnectHelperBinding7 = this.binding`  L202
- `BLTextView bLTextView = activityConnectHelperBinding7.btnAction`  L207
- `HelperItem helperItem3 = this.helperItem`  L208
- `ActivityConnectHelperBinding activityConnectHelperBinding8 = this.binding`  L214
- `HelperItem helperItem = this$0.helperItem`  L231
- `DeviceType deviceType = this.deviceType`  L240
- `DeviceType deviceType2 = null`  L241
- `DeviceType deviceType3 = this.deviceType`  L248
- `DeviceType deviceType4 = this.deviceType`  L262
- `int i = C1870R.drawable.wifi_alert_device`  L272
- `int i`  L297
- `int i2`  L298
- `int i3 = C1870R.drawable.wifi_1_ride3pro_gif`  L299
- `int i = C1870R.drawable.wifi_1_m3_gif`  L334

方法（22）：
- `View getContentRoot()`  L75 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L89 @Override
- `void onClick(View view)`  L101 @Override
- `void onCreate$lambda$0(ConnectHelperActivity this$0, View view)`  L109
    - 体内字面量："this$0"
- `void applyNavigationBarInsets()`  L115
- `WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat)`  L130 @Override
- `WindowInsetsCompat applyNavigationBarInsets$lambda$1(int i, View view, WindowInsetsCompat insets)`  L144
    - 体内字面量："view" · "insets"
- `void bindHelperItem()`  L151
- `void onClick(View view)`  L222 @Override
- `void bindHelperItem$lambda$2(ConnectHelperActivity this$0, View view)`  L229
    - 体内字面量："this$0"
- `HelperItem createHelperItem()`  L239
- `throw new NoWhenBranchMatchedException()`  L260
- `HelperItem getRide5HelperItem(final DeviceType targetDeviceType)`  L271
- `Unit invoke()`  L284 @Override
- `void invoke2()`  L290
- `HelperItem getRideHttpHelperItem(final DeviceType targetDeviceType)`  L296
- `Unit invoke()`  L321 @Override
- `void invoke2()`  L327
- `HelperItem getM3HelperItem()`  L333
- `Unit invoke()`  L345 @Override
- `void invoke2()`  L351
- `void showConnectDialog(DeviceType targetDeviceType)`  L358
    - 体内字面量："ConnectDialog2" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/ConnectHelperActivity$Companion;" · "()V" · "EXTRA_DEVICE_TYPE" · "launchActivity" · "baseActivity" · "Lcom/tuwinsmart/tuwin/presentation/ui/base/BaseActivity;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.ConnectHelperActivity$Companion`
L366 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/p010ui/connect/ConnectHelperActivity.java`
注解：

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L367
- `private Companion()`  L371
- `void launchActivity$default(Companion companion, BaseActivity baseActivity, DeviceType deviceType, int i, Object obj)`  L374
- `void launchActivity(BaseActivity baseActivity, DeviceType deviceType)`  L381
    - 体内字面量："baseActivity" · "deviceType"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.ConnectHelperActivity$WhenMappings`
L49 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/connect/ConnectHelperActivity.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L50
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.ConnectHelperDetailActivity`
L15 · [class] public final ConnectHelperDetailActivity · extends `ToolBarActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/ConnectHelperDetailActivity.java`
注解：

字段/常量（1）：
- `ActivityConnectHelperDetailBinding binding`  L16

方法（2）：
- `View getContentRoot()`  L19 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L33 @Override
    - 体内字面量："Ride5"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment`
L99 · [class] public final ConnectFragment · extends `BaseMainFragment` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（55）：
- `String BANNER_CACHE_KEY = "BANNER_CACHE_KEY"`  L100
- `long FIRMWARE_RECONNECT_TIMEOUT_MILLIS = 120000`  L101
- `long RECONNECT_POLL_INTERVAL_MILLIS = 1000`  L102
- `long RECONNECT_RETRY_DELAY_MILLIS = 2000`  L103
- `Job bannerLoadJob`  L104
- `FragmentConnectBinding binding`  L105
- `Lazy connectViewModel`  L108
- `Job firmwareReconnectJob`  L109
- `HomeListAdapter mAdapter`  L110
- `boolean showChineseOnlyContent = true`  L112
- `ConnectFragment connectFragment = this`  L142
- `Qualifier qualifier = null`  L150
- `Function0 function1 = null`  L151
- `Function0 function2 = null`  L152
- `CreationExtras defaultViewModelCreationExtras`  L158
- `Fragment fragment = connectFragment`  L159
- `Qualifier qualifier2 = qualifier`  L160
- `Function0 function3 = function0`  L161
- `Function0 function4 = function1`  L162
- `Function0 function5 = function2`  L163
- `FragmentConnectBinding fragmentConnectBinding = null`  L197
- `FragmentConnectBinding fragmentConnectBinding2 = this.binding`  L202
- `FragmentConnectBinding fragmentConnectBinding3 = this.binding`  L214
- `FragmentConnectBinding fragmentConnectBinding4 = this.binding`  L238
- `HomeListAdapter homeListAdapter = this.mAdapter`  L369
- `ConnectFragment connectFragment = this`  L468
- `FragmentConnectBinding fragmentConnectBinding = null`  L564
- `FragmentConnectBinding fragmentConnectBinding2 = this.binding`  L566
- `FragmentConnectBinding fragmentConnectBinding3 = this.binding`  L576
- `FragmentConnectBinding fragmentConnectBinding4 = this.binding`  L586
- `FragmentConnectBinding fragmentConnectBinding5 = this.binding`  L602
- `FragmentConnectBinding fragmentConnectBinding6 = this.binding`  L614
- `Job job = this.firmwareReconnectJob`  L635
- `Object next`  L795
- `String string`  L796
- `FragmentConnectBinding fragmentConnectBinding = null`  L798
- `FragmentConnectBinding fragmentConnectBinding2 = this.binding`  L801
- `FragmentConnectBinding fragmentConnectBinding3 = this.binding`  L814
- `HomeListAdapter homeListAdapter = this.mAdapter`  L841
- `HomeListAdapter homeListAdapter = this.mAdapter`  L869
- `HomeListAdapter homeListAdapter2 = this.mAdapter`  L873
- `Job job = this.firmwareReconnectJob`  L957
- `HomeListAdapter homeListAdapter = this.mAdapter`  L962
- `HomeListAdapter homeListAdapter2 = this.mAdapter`  L967
- `Job job2 = this.bannerLoadJob`  L974
- `Object objM3074constructorimpl`  L982
- `Result.Companion companion = Result.INSTANCE`  L985
- `ConnectFragment connectFragment = this`  L986
- `Result.Companion companion2 = Result.INSTANCE`  L989
- `Job job = this.bannerLoadJob`  L999
- `String str = link`  L1093
- `HomeListAdapter homeListAdapter = this.mAdapter`  L1147
- `String model`  L1160
- `String model2`  L1161
- `String model3`  L1162

方法（30）：
- `void lazyInitData()`  L138 @Override
- `public ConnectFragment()`  L141
- `Fragment invoke()`  L146 @Override
- `ConnectViewModel invoke()`  L157 @Override
- `ConnectViewModel getConnectViewModel()`  L175
- `View getLayoutRoot(LayoutInflater inflater, ViewGroup container)`  L180 @Override
    - 体内字面量："inflater" · "inflate(...)" · "binding" · "getRoot(...)"
- `void initFragment()`  L195 @Override
- `void onRefresh()`  L209 @Override
- `Unit invoke(BannerItem bannerItem)`  L227 @Override
- `void invoke2(BannerItem banner)`  L233
    - 体内字面量："banner"
- `void initFragment$lambda$0(ConnectFragment this$0)`  L250
    - 体内字面量："this$0" · "com/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectFragment$initFragment$2" · "Lcom/tuwinsmart/tuwin/presentation/ui/home/adapter/OnItemClickListener;" · "onItemClick" · "item" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectedDevice;" · "actionId" · "app_release_64"
- `void fragmentShow()`  L367 @Override
    - 体内字面量："fragmentShow "
- `void observeViewModelState()`  L467
- `void handleConnectionStatus(ConnectViewModel.ConnectionStatus status)`  L563
- `void scheduleFirmwareReconnectRefresh$default(ConnectFragment connectFragment, long j, int i, Object obj)`  L626
- `void scheduleFirmwareReconnectRefresh(long initialDelayMillis)`  L633
- `void refreshDevice$default(ConnectFragment connectFragment, ConnectRefreshSource connectRefreshSource, int i, Object obj)`  L786
- `void refreshDevice(ConnectRefreshSource refreshSource)`  L794
- `void onNetworkChanged(SoftVersionUpdateCompleteEvent event)`  L838 @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    - 体内字面量："event"
- `void onNetworkChanged(NetworkChangeEvent event)`  L848 @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    - 体内字面量："event" · "åºä»¶åçº§å¾éè¿æé´æ¶å°ç½ç»ååï¼networkCount="
- `void onDeviceAdded(DeviceAddedEvent event)`  L861 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："event"
- `void fragmentHide()`  L867 @Override
    - 体内字面量："fragmentHide "
- `HomeActivity getHomeActivity()`  L880
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.connect.fragment.ConnectFragment$downloadRide3ProLogIfNeeded$1" · "ConnectFragment.kt" · "invokeSuspend"
- `void downloadRide3ProLogIfNeeded(DeviceType deviceType)`  L947
    - 体内字面量："getViewLifecycleOwner(...)"
- `void onDestroyView()`  L956 @Override
- `void loadBanners()`  L981
- `void handleBannerClick(BannerItem banner)`  L1091
- `void cacheBanners(List<BannerItem> banners)`  L1110
    - 体内字面量："cache banners failed"
- `boolean loadCachedBanners()`  L1121
    - 体内字面量："fromJson(...)" · "banner cache read count=" · ", ids=" · ","
- `DeviceType resolveAddDeviceType(ConnectedDevice item)`  L1159
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$C25751`
L892 · [class] static final C25751 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（7）：
- `DeviceType $deviceType`  L893
- `int label`  L894
- `ConnectFragment this$0`  L895
- `Object next`  L916
- `int i = this.label`  L918
- `LogHelper logHelper = LogHelper.INSTANCE`  L921
- `DeviceType deviceType = this.$deviceType`  L922

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L905 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L910 @Override
- `Object invokeSuspend(Object obj)`  L915 @Override
- `throw new IllegalStateException( 177 )`  L939
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$C25762`
L258 · [class] public static final C25762 · implements `OnItemClickListener` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（12）：
- `List<ConnectedDevice> deviceList`  L264
- `HomeListAdapter homeListAdapter = this$0.mAdapter`  L268
- `HomeListAdapter homeListAdapter2 = this$0.mAdapter`  L273
- `Object objM3074constructorimpl`  L282
- `HomeActivity homeActivity`  L283
- `boolean z = true`  L284
- `ConnectHelperDialog.Companion companion = ConnectHelperDialog.INSTANCE`  L292
- `BaseActivity baseActivity = ConnectFragment.this.activity`  L306
- `ConnectFragment connectFragment = ConnectFragment.this`  L326
- `Result.Companion companion2 = Result.INSTANCE`  L337
- `C25762 c25762 = this`  L338
- `Result.Companion companion3 = Result.INSTANCE`  L344

方法（3）：
- `void onItemClick$lambda$4(ConnectedDevice connectedDevice, ConnectFragment this$0, View view)`  L263
- `void onItemClick(int position, final ConnectedDevice item, int actionId)`  L281 @Override
- `void onClick(View view)`  L329 @Override
    - 体内字面量："ç¹å»deeplink"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$C25781`
L1013 · [class] static final C25781 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（7）：
- `NetworkRuntime $runtime`  L1014
- `Object L$0`  L1015
- `int label`  L1016
- `ConnectFragment this$0`  L1017
- `CoroutineScope coroutineScope`  L1040
- `int i = this.label`  L1042
- `HomeListAdapter homeListAdapter = this.this$0.mAdapter`  L1074

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1027 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1034 @Override
- `Object invokeSuspend(Object obj)`  L1039 @Override
- `throw new IllegalStateException( 189 )`  L1057
    - 体内字面量："banner fetch success count=" · ", ids=" · ","
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$C25791`
L391 · [class] static final C25791 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（2）：
- `int label`  L392
- `int i = this.label`  L450

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L399 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L404 @Override
    - 体内字面量："<anonymous>" · "status" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus;" · "com.tuwinsmart.tuwin.presentation.ui.connect.fragment.ConnectFragment$observeViewModelState$1$1" · "ConnectFragment.kt" · "invokeSuspend"
- `Object invokeSuspend(Object obj)`  L448 @Override
- `throw new IllegalStateException( 120 )`  L459
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$C25791$AnonymousClass1`
L412 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<ConnectViewModel.ConnectionStatus, Continuation<? super Unit>, Object>` · implements `Function2<ConnectViewModel.ConnectionStatus, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（3）：
- `Object L$0`  L413
- `int label`  L414
- `ConnectFragment this$0`  L415

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L424 @Override
- `Object invoke(ConnectViewModel.ConnectionStatus connectionStatus, Continuation<? super Unit> continuation)`  L431 @Override
- `Object invokeSuspend(Object obj)`  L436 @Override
- `throw new IllegalStateException( 119 )`  L443
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$C25802`
L477 · [class] static final C25802 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（2）：
- `int label`  L478
- `int i = this.label`  L545

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L485 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L490 @Override
    - 体内字面量："<anonymous>" · "devices" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectedDevice;" · "com.tuwinsmart.tuwin.presentation.ui.connect.fragment.ConnectFragment$observeViewModelState$2$1" · "ConnectFragment.kt" · "invokeSuspend"
- `Object invokeSuspend(Object obj)`  L543 @Override
- `throw new IllegalStateException( 138 )`  L554
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$C25802$AnonymousClass1`
L498 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<List<? extends ConnectedDevice>, Continuation<? super Unit>, Object>` · implements `Function2<List<? extends ConnectedDevice>, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（4）：
- `Object L$0`  L499
- `int label`  L500
- `ConnectFragment this$0`  L501
- `HomeListAdapter homeListAdapter = this.this$0.mAdapter`  L532

方法（5）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L510 @Override
- `Object invoke(List<? extends ConnectedDevice> list, Continuation<? super Unit> continuation)`  L517 @Override
- `Object invoke2(List<ConnectedDevice> list, Continuation<? super Unit> continuation)`  L522
- `Object invokeSuspend(Object obj)`  L527 @Override
- `throw new IllegalStateException( 137 )`  L538
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$C25811`
L648 · [class] static final C25811 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（4）：
- `long $initialDelayMillis`  L649
- `long J$0`  L650
- `int label`  L651
- `ConnectFragment this$0`  L652

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L662 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L667 @Override
- `java.lang.Object invokeSuspend(java.lang.Object r10)`  L682 @Override
- `throw new UnsupportedOperationException( 160 )`  L782
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$initFragment$2$onItemClick$1`
L29 · [class] final ConnectFragment$initFragment$2$onItemClick$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment$initFragment$2$onItemClick$1.java`
注解：

字段/常量（20）：
- `ConnectedDevice $item`  L30
- `Object L$0`  L31
- `int label`  L32
- `ConnectFragment this$0`  L33
- `Ref.IntRef intRef`  L96
- `Ref.IntRef intRef2`  L97
- `Exception e`  L98
- `ConnectedDevice connectedDevice`  L99
- `DeviceType deviceType`  L100
- `int i`  L101
- `Intent intent`  L102
- `ConnectedDevice connectedDevice2`  L103
- `String code`  L104
- `String sessionId`  L105
- `DeviceType deviceType2`  L106
- `BaseActivity baseActivity`  L107
- `int i2 = this.label`  L109
- `ConnectedDevice connectedDevice3 = this.$item`  L114
- `ConnectedDevice connectedDevice4 = this.$item`  L161
- `ConnectedDevice connectedDevice5 = this.$item`  L236

方法（6）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L70 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L75 @Override
- `Object invokeSuspend(Object obj)`  L95 @Override
- `throw new NoWhenBranchMatchedException()`  L166
    - 体内字面量："extra_device_type_code" · "device_session_id" · "device_id"
- `throw new IllegalStateException( 18 )`  L191
    - 体内字面量："Failed to get gravity direction" · "extra_device_type_code" · "device_session_id" · "device_id"
- `throw new NoWhenBranchMatchedException()`  L241
    - 体内字面量："extra_device_type_code" · "device_session_id" · "device_id"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$initFragment$2$onItemClick$1$response$1`
L19 · [class] final ConnectFragment$initFragment$2$onItemClick$1$response$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Integer>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment$initFragment$2$onItemClick$1$response$1.java`
注解：

字段/常量（5）：
- `ConnectedDevice $item`  L20
- `int label`  L21
- `ConnectFragment this$0`  L22
- `int i = this.label`  L44
- `ConnectedDevice connectedDevice = this.$item`  L48

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L32 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation)`  L37 @Override
- `Object invokeSuspend(Object obj)`  L42 @Override
- `throw new IllegalStateException( 7 )`  L57
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$initFragment$2$onItemClick$1$WhenMappings`
L37 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment$initFragment$2$onItemClick$1.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L38
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment$WhenMappings`
L116 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragment.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L117
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragmentShowRefreshAction`
L11 · [enum] public ConnectFragmentShowRefreshAction · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragmentShowRefreshAction.java`
注解：

枚举常量（3）：
- `CACHE_ONLY()`  L12
- `FULL()`  L13
- `NONE()`  L14

方法（1）：
- `EnumEntries<ConnectFragmentShowRefreshAction> getEntries()`  L18
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragmentShowRefreshPolicy`
L9 · [class] public final ConnectFragmentShowRefreshPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectFragmentShowRefreshPolicy.java`
注解：

方法（3）：
- `private ConnectFragmentShowRefreshPolicy()`  L12
- `ConnectFragmentShowRefreshAction resolve$default(ConnectFragmentShowRefreshPolicy connectFragmentShowRefreshPolicy, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj)`  L15
- `ConnectFragmentShowRefreshAction resolve(boolean firmwareReconnectPending, boolean connectFlowActive, boolean ride5WifiRenamePending, boolean isVivo)`  L22
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectRefreshSource`
L11 · [enum] public ConnectRefreshSource · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectRefreshSource.java`
注解：

枚举常量（3）：
- `AUTO()`  L12
- `MANUAL()`  L13
- `FIRMWARE_RECONNECT()`  L14

方法（1）：
- `EnumEntries<ConnectRefreshSource> getEntries()`  L18
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel`
L45 · [class] public final ConnectViewModel · extends `ViewModel` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

字段/常量（25）：
- `MutableStateFlow<ConnectionStatus> _connectionStatus`  L46
- `MutableStateFlow<List<ConnectedDevice>> _deviceList`  L47
- `StateFlow<ConnectionStatus> connectionStatus`  L48
- `StateFlow<List<ConnectedDevice>> deviceList`  L49
- `DeviceRepository deviceRepository`  L50
- `M3SessionRepositoryFactory m3SessionRepositoryFactory`  L51
- `OtaDeviceLifecycle otaDeviceLifecycle`  L52
- `RefreshConnectionUseCase refreshConnectionUseCase`  L53
- `C25821 c25821`  L156
- `M3SessionResourceOwner m3SessionResourceOwner`  L157
- `M3DeviceRepository m3DeviceRepository`  L158
- `Object objMo2787getGravityDirectionIoAF18A`  L159
- `Object objM3074constructorimpl`  L160
- `Object obj = c25821.result`  L171
- `int i = c25821.label`  L173
- `Result.Companion companion = Result.INSTANCE`  L182
- `ConnectViewModel connectViewModel = this`  L183
- `M3SessionRepositoryFactory m3SessionRepositoryFactory = this.m3SessionRepositoryFactory`  L184
- `Result.Companion companion2 = Result.INSTANCE`  L187
- `C25841 c25841`  L328
- `ConnectViewModel connectViewModel`  L329
- `ConnectedDevice connectedDevice2`  L330
- `Object objSaveDevice = c25841.result`  L341
- `int i = c25841.label`  L343
- `DeviceRepository deviceRepository = this.deviceRepository`  L346

方法（13）：
- ` ConnectViewModel(DeviceRepository deviceRepository, RefreshConnectionUseCase refreshConnectionUseCase, OtaDeviceLifecycle otaDeviceLifecycle, M3SessionRepositoryFactory m3SessionRepositoryFactory, int i, DefaultConstructorMarker defaultConstructorMarker)`  L99
- `public ConnectViewModel(DeviceRepository deviceRepository, RefreshConnectionUseCase refreshConnectionUseCase, OtaDeviceLifecycle otaDeviceLifecycle, M3SessionRepositoryFactory m3SessionRepositoryFactory)`  L103
    - 体内字面量："deviceRepository" · "refreshConnectionUseCase" · "otaDeviceLifecycle"
- `StateFlow<List<ConnectedDevice>> getDeviceList()`  L119
- `StateFlow<ConnectionStatus> getConnectionStatus()`  L123
- `void refreshDeviceListFromCache()`  L127
- `List<ConnectedDevice> removeDevice(ConnectedDevice device)`  L131
    - 体内字面量："device"
- `Object getM3GravityDirection$default(ConnectViewModel connectViewModel, String str, Continuation continuation, int i, Object obj)`  L139
- `Object getM3GravityDirection(String str, Continuation<? super Integer> continuation)`  L155
- `throw new IllegalStateException( 60 )`  L207
- `void refreshDeviceConnection$default(ConnectViewModel connectViewModel, Network network, ConnectRefreshSource connectRefreshSource, int i, Object obj)`  L234
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.connect.fragment.ConnectViewModel$refreshDeviceConnection$1" · "ConnectViewModel.kt" · "invokeSuspend" · "$this$launch" · "currentSSID" · "currentBSSID" · "$this$launch" · "currentSSID" · "currentBSSID" · "device" · "checkMode" · "$this$launch" · "$this$launch" · "currentSSID" · "currentBSSID" · "L$0" · "L$1" · "L$2" · "L$0" · "L$1" · "L$2" · "L$4" · "L$5" · "L$0" · "L$1" · "L$0" · "L$1" · "L$2"
- `void refreshDeviceConnection(Network network, ConnectRefreshSource refreshSource)`  L320
    - 体内字面量："refreshSource"
- `Object updateDevice(ConnectedDevice connectedDevice, Continuation<? super Unit> continuation)`  L327
- `throw new IllegalStateException( 95 )`  L359
    - 体内字面量："Device saved: " · ", type: " · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus;" · "()V" · "Checking" · "Connected" · "Failed" · "Idle" · "NotConnected" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$Checking;" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$Connected;" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$Failed;" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$Idle;" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$NotConnected;" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel$C25821`
L59 · [class] static final C25821 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

字段/常量（3）：
- `Object L$0`  L60
- `int label`  L61
- `Object result`  L62

方法（1）：
- `Object invokeSuspend(Object obj)`  L69 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel$C25831`
L248 · [class] static final C25831 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

字段/常量（9）：
- `Network $network`  L249
- `ConnectRefreshSource $refreshSource`  L250
- `Object L$0`  L251
- `Object L$1`  L252
- `Object L$2`  L253
- `Object L$3`  L254
- `Object L$4`  L255
- `Object L$5`  L256
- `int label`  L257

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L267 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L274 @Override
- `java.lang.Object invokeSuspend(java.lang.Object r23)`  L311 @Override
- `throw new UnsupportedOperationException( 93 )`  L316
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel$C25841`
L80 · [class] static final C25841 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

字段/常量（5）：
- `Object L$0`  L81
- `Object L$1`  L82
- `Object L$2`  L83
- `int label`  L84
- `Object result`  L85

方法（1）：
- `Object invokeSuspend(Object obj)`  L92 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel$ConnectionStatus`
L374 · [class] public static abstract ConnectionStatus · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

方法（2）：
- ` ConnectionStatus(DefaultConstructorMarker defaultConstructorMarker)`  L375
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$Idle;" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus;" · "()V" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
- `private ConnectionStatus()`  L407
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$Checking;" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus;" · "()V" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$Connected;" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus;" · "result" · "Lcom/tuwinsmart/tuwin/domain/strategy/ConnectionResult$Success;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "refreshSource" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectRefreshSource;" · "(Lcom/tuwinsmart/tuwin/domain/strategy/ConnectionResult$Success;Lcom/tuwinsmart/tuwin/domain/model/DeviceType;Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectRefreshSource;)V" · "getDeviceType" · "()Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "getRefreshSource" · "()Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectRefreshSource;" · "getResult" · "()Lcom/tuwinsmart/tuwin/domain/strategy/ConnectionResult$Success;" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$Failed;" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus;" · "reason" · "(Ljava/lang/String;)V" · "getReason" · "()Ljava/lang/String;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus$NotConnected;" · "Lcom/tuwinsmart/tuwin/presentation/ui/connect/fragment/ConnectViewModel$ConnectionStatus;" · "()V" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel$ConnectionStatus$Checking`
L412 · [class] public static final Checking · extends `ConnectionStatus` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

方法（4）：
- `boolean equals(Object other)`  L415
- `int hashCode()`  L425
- `String toString()`  L429
    - 体内字面量："Checking"
- `private Checking()`  L433
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel$ConnectionStatus$Connected`
L440 · [class] public static final Connected · extends `ConnectionStatus` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

字段/常量（3）：
- `DeviceType deviceType`  L441
- `ConnectRefreshSource refreshSource`  L442
- `ConnectionResult.Success result`  L443

方法（12）：
- `Connected copy$default(Connected connected, ConnectionResult.Success success, DeviceType deviceType, ConnectRefreshSource connectRefreshSource, int i, Object obj)`  L445
- `ConnectionResult.Success getResult()`  L459
- `DeviceType getDeviceType()`  L464
- `ConnectRefreshSource getRefreshSource()`  L469
- `Connected copy(ConnectionResult.Success result, DeviceType deviceType, ConnectRefreshSource refreshSource)`  L473
    - 体内字面量："result" · "deviceType" · "refreshSource"
- `boolean equals(Object other)`  L480
- `int hashCode()`  L491
- `String toString()`  L495
    - 体内字面量："Connected(result=" · ", deviceType=" · ", refreshSource=" · ")"
- `ConnectionResult.Success getResult()`  L499
- `DeviceType getDeviceType()`  L503
- `ConnectRefreshSource getRefreshSource()`  L507
- `public Connected(ConnectionResult.Success result, DeviceType deviceType, ConnectRefreshSource refreshSource)`  L512
    - 体内字面量："result" · "deviceType" · "refreshSource"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel$ConnectionStatus$Failed`
L525 · [class] public static final Failed · extends `ConnectionStatus` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

字段/常量（1）：
- `String reason`  L526

方法（8）：
- `Failed copy$default(Failed failed, String str, int i, Object obj)`  L528
- `String getReason()`  L536
- `Failed copy(String reason)`  L540
    - 体内字面量："reason"
- `boolean equals(Object other)`  L545
- `int hashCode()`  L552
- `String toString()`  L556
    - 体内字面量："Failed(reason=" · ")"
- `public Failed(String reason)`  L561
    - 体内字面量："reason"
- `String getReason()`  L567
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel$ConnectionStatus$Idle`
L381 · [class] public static final Idle · extends `ConnectionStatus` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

方法（4）：
- `boolean equals(Object other)`  L384
- `int hashCode()`  L394
- `String toString()`  L398
    - 体内字面量："Idle"
- `private Idle()`  L402
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectViewModel$ConnectionStatus$NotConnected`
L574 · [class] public static final NotConnected · extends `ConnectionStatus` · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/ConnectViewModel.java`
注解：

方法（4）：
- `boolean equals(Object other)`  L577
- `int hashCode()`  L587
- `String toString()`  L591
    - 体内字面量："NotConnected"
- `private NotConnected()`  L595
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.DeviceReconnectWifiPolicy`
L13 · [class] public final DeviceReconnectWifiPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/DeviceReconnectWifiPolicy.java`
注解：

字段/常量（1）：
- `String strNormalizeBssid`  L20

方法（2）：
- `private DeviceReconnectWifiPolicy()`  L16
- `boolean matches(ConnectedDevice device, String currentSsid, String currentBssid)`  L19
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.M3RefreshProbePolicy`
L13 · [class] public final M3RefreshProbePolicy · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/M3RefreshProbePolicy.java`
注解：

方法（2）：
- `private M3RefreshProbePolicy()`  L16
- `boolean allowCandidateProbe(DeviceType deviceType, ConnectRefreshSource refreshSource)`  L19
    - 体内字面量："refreshSource"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.Ride3ProRefreshPreviewHandshakePolicy`
L13 · [class] public final Ride3ProRefreshPreviewHandshakePolicy · `com/tuwinsmart/tuwin/presentation/p010ui/connect/fragment/Ride3ProRefreshPreviewHandshakePolicy.java`
注解：

方法（2）：
- `private Ride3ProRefreshPreviewHandshakePolicy()`  L16
- `boolean shouldKeepHandshakeCache(DeviceType deviceType, ConnectionCheckMode checkMode, ConnectRefreshSource refreshSource)`  L19
    - 体内字面量："checkMode" · "refreshSource"
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.HelperItem`
L12 · [class] public final HelperItem · `com/tuwinsmart/tuwin/presentation/p010ui/connect/HelperItem.java`
注解：

字段/常量（4）：
- `Function0<Unit> action`  L13
- `String btnText`  L14
- `int imgId`  L15
- `String msg`  L16

方法（14）：
- `HelperItem copy$default(HelperItem helperItem, int i, String str, String str2, Function0 function0, int i2, Object obj)`  L19
- `int getImgId()`  L36
- `String getMsg()`  L41
- `String getBtnText()`  L46
- `Function0<Unit> component4()`  L50
- `HelperItem copy(int imgId, String msg, String btnText, Function0<Unit> action)`  L54
    - 体内字面量："msg" · "btnText" · "action"
- `boolean equals(Object other)`  L61
- `int hashCode()`  L72
- `String toString()`  L76
    - 体内字面量："HelperItem(imgId=" · ", msg=" · ", btnText=" · ", action=" · ")"
- `public HelperItem(int i, String msg, String btnText, Function0<Unit> action)`  L80
    - 体内字面量："msg" · "btnText" · "action"
- `int getImgId()`  L90
- `String getMsg()`  L94
- `String getBtnText()`  L98
- `Function0<Unit> getAction()`  L102
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.Ride3ProAutoRefreshGate`
L12 · [class] public final Ride3ProAutoRefreshGate · `com/tuwinsmart/tuwin/presentation/p010ui/connect/Ride3ProAutoRefreshGate.java`
注解：

字段/常量（3）：
- `String pendingSkipSsid`  L14
- `String str = null`  L20
- `String str = pendingSkipSsid`  L42

方法（4）：
- `private Ride3ProAutoRefreshGate()`  L16
- `void markSkipOnce(String ssid)`  L19
- `boolean consumeSkip(String currentSsid)`  L34
- `void clear()`  L57
### `com.tuwinsmart.tuwin.presentation.p010ui.connect.Ride5WifiRenameRefreshGate`
L10 · [class] public final Ride5WifiRenameRefreshGate · `com/tuwinsmart/tuwin/presentation/p010ui/connect/Ride5WifiRenameRefreshGate.java`
注解：

方法（4）：
- `private Ride5WifiRenameRefreshGate()`  L14
- `void markPending()`  L17
- `boolean consume()`  L21
- `void clear$app_release_64()`  L25