# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.presentation.p010ui.home

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 19 个文件 / 29 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.AddDeviceViewHolder`
L12 · [class] public final AddDeviceViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/AddDeviceViewHolder.java`
注解：

字段/常量（1）：
- `ItemHomeListAddDeviceBinding binding`  L13

方法（2）：
- `ItemHomeListAddDeviceBinding getBinding()`  L15
- `public AddDeviceViewHolder(ItemHomeListAddDeviceBinding binding)`  L20
    - 体内字面量："binding"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.BannerPagerAdapter`
L26 · [class] public final BannerPagerAdapter · extends `RecyclerView.Adapter<BannerViewHolder>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/BannerPagerAdapter.java`
注解：

字段/常量（2）：
- `List<BannerItem> items`  L27
- `Function1<BannerItem, Unit> onBannerClick`  L28

方法（6）：
- `public BannerPagerAdapter(Function1<? super BannerItem, Unit> onBannerClick)`  L31
    - 体内字面量："onBannerClick"
- `void submit(List<BannerItem> list)`  L37
    - 体内字面量："list"
- `int realCount()`  L44
- `BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L49 @Override
    - 体内字面量："parent" · "inflate(...)"
- `void onBindViewHolder(BannerViewHolder holder, int position)`  L57 @Override
    - 体内字面量："holder"
- `int getItemCount()`  L66 @Override
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/home/adapter/BannerPagerAdapter$BannerViewHolder;" · "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;" · "binding" · "Lcom/tuwinsmart/tuwin/databinding/ItemBannerPageBinding;" · "onBannerClick" · "Lkotlin/Function1;" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/BannerItem;" · "(Lcom/tuwinsmart/tuwin/databinding/ItemBannerPageBinding;Lkotlin/jvm/functions/Function1;)V" · "bind" · "item" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.BannerPagerAdapter$BannerViewHolder`
L73 · [class] public static final BannerViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/BannerPagerAdapter.java`
注解：

字段/常量（3）：
- `ItemBannerPageBinding binding`  L74
- `Function1<BannerItem, Unit> onBannerClick`  L75
- `RoundImageView ivBanner = this.binding.ivBanner`  L90

方法（4）：
- `public BannerViewHolder(ItemBannerPageBinding binding, Function1<? super BannerItem, Unit> onBannerClick)`  L79
    - 体内字面量："binding" · "onBannerClick"
- `void bind(final BannerItem item)`  L87
    - 体内字面量："item"
- `void onClick(View view)`  L94 @Override
- `void bind$lambda$0(BannerViewHolder this$0, BannerItem item, View view)`  L101
    - 体内字面量："this$0" · "$item"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.BannerViewHolder`
L18 · [class] public final BannerViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/BannerViewHolder.java`
注解：

字段/常量（9）：
- `Runnable autoScrollRunnable`  L19
- `BannerPagerAdapter bannerAdapter`  L20
- `ItemHomeListBrandBinding binding`  L21
- `boolean isDragging`  L22
- `Function1<BannerItem, Unit> onBannerClick`  L23
- `BannerViewHolder$pageChangeCallback$1 pageChangeCallback`  L24
- `Function1 function2 = this.this$0.onBannerClick`  L52
- `int i = itemCount / 2`  L113
- `Runnable runnable = this.autoScrollRunnable`  L129

方法（9）：
- `ItemHomeListBrandBinding getBinding()`  L26
- `public BannerViewHolder(ItemHomeListBrandBinding binding, Function1<? super BannerItem, Unit> function1)`  L33
    - 体内字面量："binding"
- `Unit invoke(BannerItem bannerItem)`  L44 @Override
- `void invoke2(BannerItem banner)`  L50
    - 体内字面量："banner"
- `void onPageScrollStateChanged(int state)`  L61 @Override
- `void bind(List<BannerItem> banners)`  L80
    - 体内字面量："banners" · "banner render realCount=" · ", itemCount="
- `void startAutoScroll()`  L103
- `void run()`  L107 @Override
- `void stopAutoScroll()`  L128
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.DeviceItemViewHolder`
L12 · [class] public final DeviceItemViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/DeviceItemViewHolder.java`
注解：

字段/常量（1）：
- `ItemHomeListDeviceBinding binding`  L13

方法（2）：
- `ItemHomeListDeviceBinding getBinding()`  L15
- `public DeviceItemViewHolder(ItemHomeListDeviceBinding binding)`  L20
    - 体内字面量："binding"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.DeviceTitleViewHolder`
L12 · [class] public final DeviceTitleViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/DeviceTitleViewHolder.java`
注解：

字段/常量（1）：
- `ItemHomeListDeviceTitleBinding binding`  L13

方法（2）：
- `ItemHomeListDeviceTitleBinding getBinding()`  L15
- `public DeviceTitleViewHolder(ItemHomeListDeviceTitleBinding binding)`  L20
    - 体内字面量："binding"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListAdapter`
L84 · [class] public final HomeListAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListAdapter.java`
注解：

字段/常量（71）：
- `int ACTION_ADD_DEVICE = 3`  L85
- `int ACTION_ADD_SPECIAL_DEVICE = 4`  L86
- `int ACTION_CONTACT_SERVICE = 7`  L87
- `int ACTION_JUMP_DEEPLINK = 5`  L88
- `int ACTION_JUMP_TO_DEVICE_DETAIL = 1`  L89
- `int ACTION_PLAY_VIDEO = 2`  L90
- `int ACTION_REMOVE_SPECIAL_DEVICE = 6`  L91
- `String TAG = "HomeListAdapter"`  L92
- `int VIEW_TYPE_ADD_DEVICE = 5`  L93
- `int VIEW_TYPE_DEVICE_ITEM = 4`  L94
- `int VIEW_TYPE_DEVICE_TITLE = 2`  L95
- `int VIEW_TYPE_SERVICE_CARD = 3`  L96
- `int VIEW_TYPE_WEATHER = 1`  L97
- `CoroutineScope adapterScope`  L98
- `DeviceItemViewHolder attachedHolder`  L99
- `List<BannerItem> bannerList`  L100
- `String cardMediaSessionId`  L101
- `FFmpegPlayerView.PlayerCallback cardPlayerCallback`  L102
- `List<ConnectedDevice> deviceList`  L103
- `OnItemClickListener listener`  L104
- `MediaSessionCoordinator mediaCoordinator`  L105
- `MediaSessionHandle mediaSessionHandle`  L106
- `Job mediaStartJob`  L107
- `Function1<BannerItem, Unit> onBannerClick`  L108
- `HomeListPreviewState playerState`  L109
- `Job playerStateSyncJob`  L110
- `String playingSsid`  L111
- `String playingUrl`  L112
- `Ride3ProStreamRepositoryImpl ride3ProStreamRepository`  L113
- `FFmpegPlayerView sharedPlayerView`  L114
- `boolean showChineseOnlyContent`  L115
- `List<BannerItem> list = this.bannerList`  L199
- `FFmpegPlayerView fFmpegPlayerView = this.sharedPlayerView`  L217
- `FFmpegPlayerView fFmpegPlayerView = this.sharedPlayerView`  L225
- `String string`  L291
- `int i`  L292
- `String string2`  L293
- `String str = remark`  L306
- `String str2 = this.playingSsid`  L405
- `View itemView = holder.itemView`  L418
- `OnItemClickListener onItemClickListener = this$0.listener`  L476
- `OnItemClickListener onItemClickListener = this$0.listener`  L486
- `OnItemClickListener onItemClickListener = this$0.listener`  L495
- `OnItemClickListener onItemClickListener = this$0.listener`  L504
- `OnItemClickListener onItemClickListener = this$0.listener`  L513
- `LocalUpgradeBean localUpgradeBeanFindUpgradeBean`  L520
- `FFmpegPlayerView fFmpegPlayerView = this.sharedPlayerView`  L584
- `FFmpegPlayerView.PlayerCallback playerCallback = this.cardPlayerCallback`  L596
- `DeviceItemViewHolder deviceItemViewHolder = HomeListAdapter.this.attachedHolder`  L614
- `DeviceItemViewHolder deviceItemViewHolder = HomeListAdapter.this.attachedHolder`  L624
- `DeviceItemViewHolder deviceItemViewHolder = HomeListAdapter.this.attachedHolder`  L634
- `DeviceItemViewHolder deviceItemViewHolder = HomeListAdapter.this.attachedHolder`  L644
- `FFmpegPlayerView fFmpegPlayerView = this.sharedPlayerView`  L655
- `FFmpegPlayerView fFmpegPlayerView = this.sharedPlayerView`  L684
- `DeviceItemViewHolder deviceItemViewHolder = this.attachedHolder`  L702
- `FFmpegPlayerView fFmpegPlayerView = this.sharedPlayerView`  L703
- `String str = this.playingSsid`  L719
- `FFmpegPlayerView fFmpegPlayerView = this.sharedPlayerView`  L724
- `Job job = this.mediaStartJob`  L737
- `MediaSessionHandle mediaSessionHandle = this.mediaSessionHandle`  L741
- `MediaSessionCoordinator mediaSessionCoordinator = this.mediaCoordinator`  L1174
- `Job job = this.mediaStartJob`  L1210
- `MediaSessionHandle mediaSessionHandle = this.mediaSessionHandle`  L1215
- `String str = this.playingSsid`  L1285
- `OnItemClickListener onItemClickListener = this.listener`  L1291
- `Job job = this.playerStateSyncJob`  L1387
- `DeviceItemViewHolder deviceItemViewHolder`  L1396
- `DeviceItemViewHolder deviceItemViewHolder = this.attachedHolder`  L1412
- `FFmpegPlayerView fFmpegPlayerView = this.sharedPlayerView`  L1419
- `HomeListPreviewState homeListPreviewState`  L1424
- `int i = 0`  L1466

方法（63）：
- ` HomeListAdapter(List list, OnItemClickListener onItemClickListener, Function1 function1, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker)`  L159
- `List<ConnectedDevice> getDeviceList()`  L163
- `OnItemClickListener getListener()`  L167
- `public HomeListAdapter(List<ConnectedDevice> deviceList, OnItemClickListener onItemClickListener, Function1<? super BannerItem, Unit> function1, boolean z)`  L172
    - 体内字面量："deviceList" · "home-card-preview-"
- `void refreshDevice(List<ConnectedDevice> list)`  L185
    - 体内字面量："list" · "refreshDevice"
- `void updateBanners(List<BannerItem> banners)`  L194
    - 体内字面量："banners"
- `void clearPreviewSession()`  L212
- `void onHostResume()`  L216
- `void onHostPause()`  L224
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L232 @Override
    - 体内字面量："parent" · "inflate(...)" · "inflate(...)" · "inflate(...)" · "inflate(...)" · "inflate(...)"
- `int getItemViewType(int position)`  L260 @Override
- `void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position)`  L290 @Override
- `void onClick(View view)`  L351 @Override
    - 体内字面量："btnActionPause"
- `void onClick(View view)`  L359 @Override
    - 体内字面量："btnPlay"
- `void onClick(View view)`  L367 @Override
    - 体内字面量："btnLostConnection"
- `void onClick(View view)`  L392 @Override
    - 体内字面量："btnDelete"
- `void onClick(View view)`  L400 @Override
- `void onClick(View view)`  L422 @Override
    - 体内字面量："getRoot(...)"
- `void onClick(View view)`  L432 @Override
    - 体内字面量："btnConsult"
- `void onClick(View view)`  L440 @Override
- `void onBindViewHolder$lambda$4(HomeListAdapter this$0, int i, ConnectedDevice item, View view)`  L448
    - 体内字面量："this$0" · "$item"
- `void onBindViewHolder$lambda$5(HomeListAdapter this$0, View view)`  L455
    - 体内字面量："this$0"
- `void onBindViewHolder$lambda$6(ConnectedDevice item, HomeListAdapter this$0, int i, RecyclerView.ViewHolder holder, View view)`  L461
    - 体内字面量："$item" · "this$0" · "$holder"
- `void onBindViewHolder$lambda$7(HomeListAdapter this$0, int i, ConnectedDevice item, View view)`  L473
    - 体内字面量："this$0" · "$item"
- `void onBindViewHolder$lambda$8(HomeListAdapter this$0, int i, ConnectedDevice item, View view)`  L483
    - 体内字面量："this$0" · "$item"
- `void onBindViewHolder$lambda$9(HomeListAdapter this$0, int i, View view)`  L493
    - 体内字面量："this$0"
- `void onBindViewHolder$lambda$10(HomeListAdapter this$0, int i, View view)`  L502
    - 体内字面量："this$0"
- `void onBindViewHolder$lambda$11(HomeListAdapter this$0, int i, View view)`  L511
    - 体内字面量："this$0"
- `boolean hadSoftwareUpdate(ConnectedDevice device)`  L519
- `LocalUpgradeBean findUpgradeBean(ConnectedDevice device, String version)`  L528
- `int getItemCount()`  L533 @Override
- `int deviceStartPosition()`  L537
- `int deviceViewType(int position)`  L541
- `void onViewRecycled(RecyclerView.ViewHolder holder)`  L546 @Override
    - 体内字面量："holder"
- `void onViewDetachedFromWindow(RecyclerView.ViewHolder holder)`  L562 @Override
    - 体内字面量："holder"
- `void onDetachedFromRecyclerView(RecyclerView recyclerView)`  L578 @Override
    - 体内字面量："recyclerView"
- `FFmpegPlayerView.PlayerCallback cardPlayerCallback()`  L595
- `void onFullscreenChanged(boolean isFullscreen)`  L602 @Override
- `void onPlaying()`  L606 @Override
- `void onStopped()`  L611 @Override
- `void onBuffering()`  L621 @Override
- `void onError(String message)`  L631 @Override
- `void onRetrying(int retryCount, int maxRetry)`  L641 @Override
- `FFmpegPlayerView ensurePlayerView(DeviceItemViewHolder holder)`  L654
- `void attachPlayer(DeviceItemViewHolder holder)`  L668
    - 体内字面量："flVideoContainer"
- `void detachPlayer(DeviceItemViewHolder holder)`  L683
- `void stopPlayback()`  L699
- `void startCardPreview(DeviceItemViewHolder holder, ConnectedDevice item)`  L718
- `void startCardMediaSession(ConnectedDevice item)`  L736
- `MediaSessionCoordinator cardMediaCoordinator(NetworkRuntime runtime)`  L1173
- `FFmpegTexturePlayerView invoke()`  L1181 @Override
- `FFmpegPlayerView invoke()`  L1191 @Override
- `FFmpegPlayerView.PlayerCallback invoke()`  L1201 @Override
- `void stopCardMediaSession()`  L1209
- `void updateUiForHolder(DeviceItemViewHolder holder)`  L1278
- `void navigateToDeviceDetail(int position, ConnectedDevice item)`  L1289
- `void startPlayerStateSync()`  L1380
- `void cancelPlayerStateSync()`  L1386
- `void syncPlayerStateFromRendererIfNeeded()`  L1395
- `void markPlayerAsPlaying()`  L1409
- `boolean isPlayerRendering()`  L1418
- `void applyPlayerState(DeviceItemViewHolder holder, boolean isConnected, boolean isCurrentPlayingItem)`  L1423
- `void moveToFirst(List<ConnectedDevice> list)`  L1463
    - 体内字面量："list"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListAdapter$C27631`
L750 · [class] static final C27631 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListAdapter.java`
注解：

字段/常量（49）：
- `ConnectedDevice $item`  L751
- `MediaSessionHandle $previousHandle`  L752
- `Object L$0`  L753
- `int label`  L754
- `HomeListAdapter this$0`  L755
- `Object objM3074constructorimpl`  L798
- `CoroutineScope coroutineScope`  L799
- `DeviceSessionManager deviceSessionManager`  L800
- `String sessionId`  L801
- `Object objM3074constructorimpl2`  L802
- `DeviceSessionSnapshot deviceSessionSnapshot`  L803
- `RouteSnapshot route`  L804
- `EndpointGrant controlEndpointGrant`  L805
- `Object objStart`  L806
- `Iterator it`  L807
- `Object next`  L808
- `DeviceSessionSnapshot deviceSessionSnapshot2`  L809
- `MediaStartResult mediaStartResult`  L810
- `int i = this.label`  L812
- `MediaSessionHandle mediaSessionHandle = this.$previousHandle`  L839
- `Result.Companion companion = Result.INSTANCE`  L841
- `Result.Companion companion2 = Result.INSTANCE`  L856
- `Result.Companion companion3 = Result.INSTANCE`  L859
- `Object objM3074constructorimpl3`  L879
- `DeviceSessionManager deviceSessionManager2 = deviceSessionManager`  L881
- `Result.Companion companion4 = Result.INSTANCE`  L883
- `Result.Companion companion5 = Result.INSTANCE`  L886
- `Object objM3074constructorimpl3`  L916
- `DeviceSessionManager deviceSessionManager2 = deviceSessionManager`  L918
- `Result.Companion companion4 = Result.INSTANCE`  L920
- `Result.Companion companion5 = Result.INSTANCE`  L923
- `Object objM3074constructorimpl3`  L954
- `DeviceSessionManager deviceSessionManager2 = deviceSessionManager`  L956
- `Result.Companion companion4 = Result.INSTANCE`  L958
- `Result.Companion companion5 = Result.INSTANCE`  L961
- `Result.Companion companion4 = Result.INSTANCE`  L1018
- `Result.Companion companion5 = Result.INSTANCE`  L1031
- `Object objM3074constructorimpl3`  L1052
- `DeviceSessionManager deviceSessionManager2 = deviceSessionManager`  L1054
- `Result.Companion companion6 = Result.INSTANCE`  L1056
- `Result.Companion companion7 = Result.INSTANCE`  L1059
- `Object objM3074constructorimpl3`  L1089
- `DeviceSessionManager deviceSessionManager2 = deviceSessionManager`  L1091
- `Result.Companion companion6 = Result.INSTANCE`  L1093
- `Result.Companion companion7 = Result.INSTANCE`  L1096
- `Object objM3074constructorimpl3`  L1126
- `DeviceSessionManager deviceSessionManager2 = deviceSessionManager`  L1128
- `Result.Companion companion6 = Result.INSTANCE`  L1130
- `Result.Companion companion7 = Result.INSTANCE`  L1133

方法（9）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L766 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L773 @Override
- `Object invokeSuspend(Object obj)`  L797 @Override
- `DeviceSessionSnapshot invoke(String id)`  L878 @Override
- `DeviceSessionSnapshot invoke(String id)`  L915 @Override
- `DeviceSessionSnapshot invoke(String id)`  L953 @Override
- `DeviceSessionSnapshot invoke(String id2)`  L1051 @Override
- `DeviceSessionSnapshot invoke(String id2)`  L1088 @Override
- `DeviceSessionSnapshot invoke(String id2)`  L1125 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListAdapter$C27641`
L1301 · [class] static final C27641 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListAdapter.java`
注解：

字段/常量（1）：
- `int label`  L1302

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1309 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1314 @Override
- `java.lang.Object invokeSuspend(java.lang.Object r6)`  L1329 @Override
    - 体内字面量："Method not decompiled: com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListAdapter.C27641.invokeSuspend(java.lang.Object):java.lang.Object"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListAdapter$C27651`
L1226 · [class] static final C27651 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListAdapter.java`
注解：

字段/常量（7）：
- `MediaSessionHandle $handle`  L1227
- `Object L$0`  L1228
- `int label`  L1229
- `int i = this.label`  L1252
- `MediaSessionHandle mediaSessionHandle = this.$handle`  L1256
- `Result.Companion companion = Result.INSTANCE`  L1257
- `Result.Companion companion2 = Result.INSTANCE`  L1270

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1238 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1245 @Override
- `Object invokeSuspend(Object obj)`  L1250 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListAdapter$WhenMappings`
L119 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListAdapter.java`
注解：

字段/常量（2）：
- `int[] $EnumSwitchMapping$0`  L120
- `int[] $EnumSwitchMapping$1`  L121
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListPreviewState`
L11 · [enum] public HomeListPreviewState · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListPreviewState.java`
注解：

枚举常量（3）：
- `IDLE()`  L12
- `BUFFERING()`  L13
- `PLAYING()`  L14

方法（1）：
- `EnumEntries<HomeListPreviewState> getEntries()`  L18
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListPreviewStateSyncPolicy`
L11 · [class] public final HomeListPreviewStateSyncPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListPreviewStateSyncPolicy.java`
注解：

方法（3）：
- `private HomeListPreviewStateSyncPolicy()`  L14
- `boolean shouldPromoteToPlaying(HomeListPreviewState state, boolean isPlayerRendering)`  L17
    - 体内字面量："state"
- `boolean shouldRefreshUiAfterRendererCheck(HomeListPreviewState state, boolean isPlayerRendering)`  L22
    - 体内字面量："state"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListVideoLoadingVisibilityPolicy`
L11 · [class] public final HomeListVideoLoadingVisibilityPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/HomeListVideoLoadingVisibilityPolicy.java`
注解：

方法（3）：
- `private HomeListVideoLoadingVisibilityPolicy()`  L14
- `boolean shouldShowLoading$default(HomeListVideoLoadingVisibilityPolicy homeListVideoLoadingVisibilityPolicy, HomeListPreviewState homeListPreviewState, boolean z, int i, Object obj)`  L17
- `boolean shouldShowLoading(HomeListPreviewState state, boolean isPlayerRendering)`  L24
    - 体内字面量："state"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.OnItemClickListener`
L11 · [interface] public OnItemClickListener · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/OnItemClickListener.java`
注解：

方法（1）：
- `void onItemClick(int position, ConnectedDevice item, int actionId)`  L12
### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.ServiceCardViewHolder`
L12 · [class] public final ServiceCardViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/home/adapter/ServiceCardViewHolder.java`
注解：

字段/常量（1）：
- `ItemHomeListServiceCardBinding binding`  L13

方法（2）：
- `ItemHomeListServiceCardBinding getBinding()`  L15
- `public ServiceCardViewHolder(ItemHomeListServiceCardBinding binding)`  L20
    - 体内字面量："binding"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.C2757x4614b080`
L18 · [class] final C2757x4614b080 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object>` · implements `Function2<CoroutineScope, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/C2757x4614b080.java`
注解：

字段/常量（4）：
- `RoutedInternetTextFetcher $fetcher`  L19
- `String $rawUrl`  L20
- `Object L$0`  L21
- `int label`  L22

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L32 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation)`  L37 @Override
- `java.lang.Object invokeSuspend(java.lang.Object r8)`  L51 @Override
    - 体内字面量："Method not decompiled: com.tuwinsmart.tuwin.presentation.p010ui.home.C2757x4614b080.invokeSuspend(java.lang.Object):java.lang.Object" · "call to 'resume' before 'invoke' with coroutine" · "yomu.atlasmeta.one"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomeActivity`
L44 · [class] public final HomeActivity · extends `BaseActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java`
注解：

字段/常量（37）：
- `String STATE_CURRENT_INDEX = "current_index"`  L45
- `ActivityHomeBinding binding`  L46
- `int mCurrentIndex = -1`  L47
- `BaseMainFragment[] mFragments`  L48
- `View permissionView`  L49
- `String FRAGMENT_TAG_CONNECT = "connect"`  L50
- `String FRAGMENT_TAG_ALBUM = "album"`  L51
- `String FRAGMENT_TAG_HELPER = "helper"`  L52
- `String[] FRAGMENT_TAGS = {FRAGMENT_TAG_CONNECT, FRAGMENT_TAG_ALBUM, FRAGMENT_TAG_HELPER}`  L53
- `BaseMainFragment[] baseMainFragmentArr = new BaseMainFragment[3]`  L81
- `ActivityHomeBinding activityHomeBinding = null`  L83
- `BaseMainFragment[] baseMainFragmentArr2 = this.mFragments`  L104
- `BaseMainFragment[] baseMainFragmentArr3 = this.mFragments`  L112
- `ActivityHomeBinding activityHomeBinding2 = this.binding`  L130
- `LinearLayout btnConnect = activityHomeBinding2.btnConnect`  L135
- `ActivityHomeBinding activityHomeBinding3 = this.binding`  L143
- `LinearLayout btnAlbum = activityHomeBinding3.btnAlbum`  L148
- `ActivityHomeBinding activityHomeBinding4 = this.binding`  L156
- `LinearLayout btnHelper = activityHomeBinding.btnHelper`  L162
- `BaseMainFragment[] baseMainFragmentArr = this.mFragments`  L194
- `BaseMainFragment[] baseMainFragmentArr2 = null`  L195
- `BaseMainFragment baseMainFragment = baseMainFragmentArr[index]`  L200
- `BaseMainFragment[] baseMainFragmentArr3 = this.mFragments`  L205
- `BaseMainFragment[] baseMainFragmentArr4 = this.mFragments`  L211
- `BaseMainFragment[] baseMainFragmentArr5 = this.mFragments`  L225
- `BaseMainFragment[] baseMainFragmentArr6 = this.mFragments`  L231
- `ActivityHomeBinding activityHomeBinding = this.binding`  L253
- `ActivityHomeBinding activityHomeBinding2 = null`  L254
- `ActivityHomeBinding activityHomeBinding3 = this.binding`  L260
- `ActivityHomeBinding activityHomeBinding4 = this.binding`  L266
- `ActivityHomeBinding activityHomeBinding5 = this.binding`  L272
- `ActivityHomeBinding activityHomeBinding6 = this.binding`  L278
- `ActivityHomeBinding activityHomeBinding7 = this.binding`  L284
- `HomeActivity homeActivity = this`  L294
- `Object next`  L328
- `Object next`  L357
- `ActivityHomeBinding activityHomeBinding = this.binding`  L431

方法（25）：
- `View getPermissionView()`  L55
- `void setPermissionView(View view)`  L59
- `View getContentRoot()`  L64 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L79 @Override
- `void onClick(View view)`  L139 @Override
- `void onClick(View view)`  L152 @Override
- `void onClick(View view)`  L166 @Override
- `void onCreate$lambda$0(HomeActivity this$0, View view)`  L173
    - 体内字面量："this$0"
- `void onCreate$lambda$1(HomeActivity this$0, View view)`  L179
    - 体内字面量："this$0"
- `void onCreate$lambda$2(HomeActivity this$0, View view)`  L185
    - 体内字面量："this$0"
- `void switchFragment(int index)`  L190
- `void onSaveInstanceState(Bundle outState)`  L246 @Override
    - 体内字面量："outState"
- `void refreshBottomBar()`  L252
- `void showPrivacyDialog()`  L293
- `void onClick(View view)`  L297 @Override
- `void onClick(View view)`  L302 @Override
- `Unit invoke(String str)`  L313 @Override
- `void invoke2(String privacyPolicyHtml)`  L319
    - 体内字面量："privacyPolicyHtml"
- `void showPrivacyDialog$lambda$6(HomeActivity this$0, View view)`  L327
- `void showPrivacyDialog$lambda$7(View view)`  L350
    - 体内字面量："System.exit returned normally, while it was supposed to halt JVM."
- `void onResume()`  L356 @Override
- `void toggleBottomBar(boolean show)`  L430
- `void onPause()`  L440 @Override
- `void onDestroy()`  L446 @Override
- `void onBackPressed()`  L452 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomeActivity$C27541`
L384 · [class] static final C27541 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity.java`
注解：

字段/常量（7）：
- `ConnectedDevice $connectedDevice`  L385
- `DeviceType $effectiveDeviceType`  L386
- `int label`  L387
- `int i = this.label`  L409
- `LogHelper logHelper = LogHelper.INSTANCE`  L412
- `DeviceType deviceType = this.$effectiveDeviceType`  L413
- `ConnectedDevice connectedDevice = this.$connectedDevice`  L414

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L397 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L402 @Override
- `Object invokeSuspend(Object obj)`  L407 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomeActivity$showPrivacyDialog$alert$1$1`
L20 · [class] final HomeActivity$showPrivacyDialog$alert$1$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomeActivity$showPrivacyDialog$alert$1$1.java`
注解：

字段/常量（3）：
- `ConnectedDevice $connectedDevice`  L21
- `int label`  L22
- `int i = this.label`  L43

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L31 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L36 @Override
- `Object invokeSuspend(Object obj)`  L41 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomeLegacyDeviceActionPolicy`
L12 · [class] public final HomeLegacyDeviceActionPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomeLegacyDeviceActionPolicy.java`
注解：

方法（2）：
- `private HomeLegacyDeviceActionPolicy()`  L42
- `boolean shouldRunLegacyDeviceActions(DeviceType deviceType)`  L45
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomeLegacyDeviceActionPolicy$WhenMappings`
L17 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomeLegacyDeviceActionPolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L18
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomePrivacyPolicyContentLoader`
L38 · [class] public final HomePrivacyPolicyContentLoader · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomePrivacyPolicyContentLoader.java`
注解：

字段/常量（17）：
- `String DEFAULT_PROMINENT_LOCATION_DISCLOSURE_HTML = "<binary/metadata>"`  L39
- `long ROUTE_RETRY_DELAY_MILLIS = 200`  L40
- `long ROUTE_WAIT_TIMEOUT_MILLIS = 10000`  L41
- `Object objM3074constructorimpl`  L69
- `Result.Companion companion = Result.INSTANCE`  L71
- `HomePrivacyPolicyContentLoader homePrivacyPolicyContentLoader = this`  L72
- `Result.Companion companion2 = Result.INSTANCE`  L75
- `Object objM3074constructorimpl`  L85
- `Result.Companion companion = Result.INSTANCE`  L87
- `HomePrivacyPolicyContentLoader homePrivacyPolicyContentLoader = this`  L88
- `Result.Companion companion2 = Result.INSTANCE`  L91
- `C27561 c27561`  L241
- `Object objWithTimeoutOrNull = c27561.result`  L252
- `int i = c27561.label`  L254
- `int iIndexOf$default`  L282
- `int iLastIndexOf$default`  L283
- `String str = html`  L285

方法（7）：
- `private HomePrivacyPolicyContentLoader()`  L65
- `String getProminentLocationDisclosureHtml()`  L68
- `String getLoadingHtml()`  L84
- `void loadOnline(Context context, Function1<? super String, Unit> onLoaded)`  L232
    - 体内字面量："context" · "onLoaded"
- `Object fetchWhenInternetRouteReady(String str, Continuation<? super String> continuation)`  L240
- `String buildDialogHtml$app_release_64(String privacyPolicyHtml)`  L276
    - 体内字面量："privacyPolicyHtml" · "\n"
- `String extractDialogHtml$app_release_64(String html)`  L281
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomePrivacyPolicyContentLoader$C27561`
L49 · [class] static final C27561 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomePrivacyPolicyContentLoader.java`
注解：

字段/常量（2）：
- `int label`  L50
- `Object result`  L51

方法（1）：
- `Object invokeSuspend(Object obj)`  L58 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomePrivacyPolicyContentLoader$C27581`
L105 · [class] static final C27581 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomePrivacyPolicyContentLoader.java`
注解：

字段/常量（15）：
- `Function1<String, Unit> $onLoaded`  L106
- `String $privacyPolicyUrl`  L107
- `Object L$0`  L108
- `int label`  L109
- `Object objM3074constructorimpl`  L133
- `Object objM3074constructorimpl2`  L134
- `int i = this.label`  L136
- `String str = this.$privacyPolicyUrl`  L142
- `Result.Companion companion = Result.INSTANCE`  L143
- `HomePrivacyPolicyContentLoader homePrivacyPolicyContentLoader = HomePrivacyPolicyContentLoader.INSTANCE`  L144
- `Result.Companion companion2 = Result.INSTANCE`  L164
- `Result.Companion companion3 = Result.INSTANCE`  L167
- `Result.Companion companion4 = Result.INSTANCE`  L170
- `HomePrivacyPolicyContentLoader homePrivacyPolicyContentLoader2 = HomePrivacyPolicyContentLoader.INSTANCE`  L173
- `Function1<String, Unit> function1 = this.$onLoaded`  L183

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L120 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L127 @Override
- `Object invokeSuspend(Object obj)`  L132 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomePrivacyPolicyContentLoader$C27581$AnonymousClass1`
L196 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomePrivacyPolicyContentLoader.java`
注解：

字段/常量（3）：
- `String $html`  L197
- `Function1<String, Unit> $onLoaded`  L198
- `int label`  L199

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L210 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L215 @Override
- `Object invokeSuspend(Object obj)`  L220 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomeTipsWebsiteCacheCoordinator`
L17 · [class] public final HomeTipsWebsiteCacheCoordinator · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomeTipsWebsiteCacheCoordinator.java`
注解：

字段/常量（4）：
- `Function3<String, Function0<Unit>, Function1<? super String, Unit>, Unit> cacheUrl`  L18
- `Function1<String, Unit> logError`  L19
- `Function0<String> readCachedMarker`  L20
- `Function1<String, Unit> writeCachedMarker`  L21

方法（6）：
- `public HomeTipsWebsiteCacheCoordinator(Function0<String> readCachedMarker, Function1<? super String, Unit> writeCachedMarker, Function3<? super String, ? super Function0<Unit>, ? super Function1<? super String, Unit>, Unit> cacheUrl, Function1<? super String, Unit> logError)`  L24
    - 体内字面量："readCachedMarker" · "writeCachedMarker" · "cacheUrl" · "logError"
- `void cacheIfNeeded()`  L35
- `Unit invoke()`  L47 @Override
- `void invoke2()`  L53
- `Unit invoke(String str2)`  L69 @Override
- `void invoke2(String it)`  L75
    - 体内字面量："it"
### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomeTipsWebsiteCachePolicy`
L12 · [class] public final HomeTipsWebsiteCachePolicy · `com/tuwinsmart/tuwin/presentation/p010ui/home/HomeTipsWebsiteCachePolicy.java`
注解：

字段/常量（5）：
- `String ASSET_BASE_URL = "http://tuwinwifihelp.tuwinsmart.com/assets/"`  L13
- `String CACHE_MARK_KEY = "HOME_TIPS_WEBSITE_CACHE_URL"`  L14
- `String CACHE_MARK_VALUE`  L15
- `String TIPS_URL = "http://tuwinwifihelp.tuwinsmart.com/#/"`  L17
- `List<String> TIPS_URLS_TO_CACHE`  L18

方法（4）：
- `private HomeTipsWebsiteCachePolicy()`  L20
- `List<String> getTIPS_URLS_TO_CACHE()`  L23
    - 体内字面量："http://tuwinwifihelp.tuwinsmart.com/#/pages/detail/detail" · "http://tuwinwifihelp.tuwinsmart.com/assets/uni.92962d95.css" · "http://tuwinwifihelp.tuwinsmart.com/assets/index-QBOHzVR1.js" · "http://tuwinwifihelp.tuwinsmart.com/assets/index-yksqsBZR.css" · "http://tuwinwifihelp.tuwinsmart.com/assets/pages-index-index.Db_F_afS.js" · "http://tuwinwifihelp.tuwinsmart.com/assets/_plugin-vue_export-helper.BCo6x5W8.js" · "http://tuwinwifihelp.tuwinsmart.com/assets/index-25iIq76Q.css" · "http://tuwinwifihelp.tuwinsmart.com/assets/pages-detail-detail.BNTkq3Bp.js" · "http://tuwinwifihelp.tuwinsmart.com/assets/detail-CIO5uBGQ.css" · "|"
- `String getCACHE_MARK_VALUE()`  L33
- `boolean shouldCache(String cachedMarker)`  L37
### `com.tuwinsmart.tuwin.presentation.p010ui.home.PrivacyPolicySource`
L14 · [class] public final PrivacyPolicySource · `com/tuwinsmart/tuwin/presentation/p010ui/home/PrivacyPolicySource.java`
注解：

字段/常量（3）：
- `String baseUrl = "https://yomu.atlasmeta.one"`  L16
- `Locale ROOT = Locale.ROOT`  L40
- `Locale ROOT2 = Locale.ROOT`  L50

方法（4）：
- `private PrivacyPolicySource()`  L18
- `String url(Context context)`  L21
    - 体内字面量："context"
- `String url$app_release_64(Locale locale)`  L31
    - 体内字面量："locale" · "https://yomu.atlasmeta.one/" · "/privacy.html"
- `String pathFor$app_release_64(Locale locale)`  L36
    - 体内字面量："locale" · "getLanguage(...)"