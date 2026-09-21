# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.presentation.p010ui.download

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 29 个文件 / 42 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadDateTitleViewHolder`
L12 · [class] public final DownloadDateTitleViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadDateTitleViewHolder.java`
注解：

字段/常量（1）：
- `ItemDownloadListVideoDateTitleBinding binding`  L13

方法（2）：
- `ItemDownloadListVideoDateTitleBinding getBinding()`  L15
- `public DownloadDateTitleViewHolder(ItemDownloadListVideoDateTitleBinding binding)`  L20
    - 体内字面量："binding"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadFileItemViewHolder`
L22 · [class] public final DownloadFileItemViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadFileItemViewHolder.java`
注解：

字段/常量（5）：
- `ItemDownloadListItemBinding binding`  L23
- `String fileSize`  L47
- `int i = progress.status`  L48
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L107
- `String str2 = fileSize3 + "/" + fileSize`  L121

方法（10）：
- `ItemDownloadListItemBinding getBinding()`  L25
- `public DownloadFileItemViewHolder(ItemDownloadListItemBinding binding)`  L30
    - 体内字面量："binding"
- `void refresh(DownloadUtil.DownloadFileTask task)`  L36
    - 体内字面量："task"
- `void refresh(Progress progress)`  L41
    - 体内字面量："progress"
- `void refresh(Progress progress, DownloadUtil.DownloadFileTaskPhase phase)`  L46
- `void refreshProgress(Progress progress)`  L129
    - 体内字面量："progress"
- `void refreshProgress(DownloadUtil.DownloadFileTask task)`  L134
    - 体内字面量："task"
- `void setViewWidthPercent(float percent)`  L139
- `void run()`  L145 @Override
- `void setViewWidthPercent$lambda$0(DownloadFileItemViewHolder this$0, float f)`  L158
    - 体内字面量："this$0"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadFileTaskAdapter`
L54 · [class] public final DownloadFileTaskAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadFileTaskAdapter.java`
注解：

字段/常量（28）：
- `String[] VIDEO_FRAME_EXTENSIONS = {".mp4", ".ts", ".mov", ".avi"}`  L55
- `int VIEW_TYPE_DOWNLOAD_ITEM = 2`  L56
- `int VIEW_TYPE_DOWNLOAD_TITLE = 1`  L57
- `Function3<String, String, Long, Object> authorizeM3Thumbnail`  L58
- `Function3<String, Integer, Long, Object> authorizeRide3ProThumbnail`  L59
- `Function3<String, String, Long, Object> authorizeRide5Preview`  L60
- `Function0<DownloadNetworkRoute.Device> currentDeviceRoute`  L61
- `List<String> failedTaskTags`  L62
- `SimpleDateFormat format`  L63
- `Lazy format2`  L66
- `Object headerPayload`  L67
- `Regex m3DateRegex`  L68
- `List<DownloadUtil.DownloadFileTask> mediaList`  L69
- `Function1<DownloadUtil.DownloadFileTask, Unit> onTaskClick`  L70
- `Function0<Unit> onTasksCleared`  L71
- `Object progressPayload`  L72
- `Regex regex`  L73
- `Function1<String, Object> resolveLocalThumbnail`  L74
- `String strSubstringAfterLast$default`  L203
- `String strResolveSignatureKey`  L263
- `Function1<DownloadUtil.DownloadFileTask, Unit> function1 = this$0.onTaskClick`  L336
- `boolean z`  L361
- `int i = 0`  L363
- `Function0<Unit> function0`  L404
- `int i = 0`  L407
- `Function0<Unit> function0 = this$0.onTasksCleared`  L472
- `ArrayList arrayList2 = arrayList`  L485
- `String path`  L495

方法（39）：
- `int getItemViewType(int position)`  L104 @Override
- `List<DownloadUtil.DownloadFileTask> getMediaList$app_release_64()`  L108
- `void setMediaList$app_release_64(List<DownloadUtil.DownloadFileTask> list)`  L112
    - 体内字面量："<set-?>"
- ` DownloadFileTaskAdapter(List list, Function0 function0, Function1 function1, Function0 function2, Function1 function3, Function3 function4, Function3 function5, Function3 function6, int i, DefaultConstructorMarker defaultConstructorMarker)`  L117
- `Void invoke()`  L120 @Override
- `String invoke(String it)`  L125 @Override
    - 体内字面量："it"
- `Void invoke(String str, String str2, long j)`  L130
    - 体内字面量："<anonymous parameter 0>" · "<anonymous parameter 1>"
- `Object invoke(Object obj, Object obj2, Object obj3)`  L137 @Override
- `Void invoke(String str, int i2, long j)`  L141
    - 体内字面量："<anonymous parameter 0>"
- `Object invoke(Object obj, Object obj2, Object obj3)`  L147 @Override
- `Void invoke(String str, String str2, long j)`  L151
    - 体内字面量："<anonymous parameter 0>" · "<anonymous parameter 1>"
- `Object invoke(Object obj, Object obj2, Object obj3)`  L158 @Override
- `public DownloadFileTaskAdapter(List<DownloadUtil.DownloadFileTask> mediaList, Function0<Unit> function0, Function1<? super DownloadUtil.DownloadFileTask, Unit> function1, Function0<DownloadNetworkRoute.Device> currentDeviceRoute, Function1<? super String, ? extends Object> resolveLocalThumbnail, Function3<? super String, ? super String, ? super Long, ? extends Object> authorizeM3Thumbnail, Function3<? super String, ? super Integer, ? super Long, ? extends Object> authorizeRide3ProThumbnail, Function3<? super String, ? super String, ? super Long, ? extends Object> authorizeRide5Preview)`  L165
    - 体内字面量："mediaList" · "currentDeviceRoute" · "resolveLocalThumbnail" · "authorizeM3Thumbnail" · "authorizeRide3ProThumbnail" · "authorizeRide5Preview" · "yyyy_MM_dd_HHmmss"
- `SimpleDateFormat invoke()`  L186 @Override
    - 体内字面量："(\\d{4}_\\d{2}_\\d{2}_\\d{6})" · "(\\d{8}_\\d{6})"
- `SimpleDateFormat getFormat2()`  L194
- `DownloadTagInfo parseDownloadTag(String tag)`  L198
- `String parseDate(DownloadTagInfo tagInfo)`  L202
- `throw new NoWhenBranchMatchedException()`  L232
    - 体内字面量："/" · "/"
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L249 @Override
    - 体内字面量："parent" · "inflate(...)" · "inflate(...)"
- `void onBindViewHolder(RecyclerView.ViewHolder holder, int position)`  L262 @Override
- `void onClick(View view)`  L290 @Override
    - 体内字面量："tvRedownload"
- `void onClick(View view)`  L298 @Override
    - 体内字面量："getRoot(...)"
- `void onClick(View view)`  L306 @Override
- `void onBindViewHolder$lambda$2(DownloadFileTaskAdapter this$0, DownloadUtil.DownloadFileTask item, View view)`  L318
    - 体内字面量："this$0" · "$item"
- `void onBindViewHolder$lambda$3(DownloadUtil.DownloadFileTask item, View view)`  L325
    - 体内字面量："$item"
- `void onBindViewHolder$lambda$4(DownloadFileTaskAdapter this$0, DownloadUtil.DownloadFileTask item, View view)`  L333
    - 体内字面量："this$0" · "$item"
- `void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads)`  L343 @Override
    - 体内字面量："holder" · "payloads"
- `int getItemCount()`  L356 @Override
- `void submitList(List<DownloadUtil.DownloadFileTask> list)`  L360
- `boolean isEmpty()`  L399
- `void removeTask(DownloadUtil.DownloadFileTask task)`  L403
- `void bindHeader(DownloadFileTitleViewHolder holder)`  L430
    - 体内字面量："btnRetryAll"
- `void onClick(View view)`  L436 @Override
    - 体内字面量："btnSelectAll"
- `void onClick(View view)`  L447 @Override
- `void bindHeader$lambda$7(DownloadFileTaskAdapter this$0, View view)`  L454
    - 体内字面量："this$0"
- `void bindHeader$lambda$8(DownloadFileTaskAdapter this$0, View view)`  L460
    - 体内字面量："this$0"
- `Boolean invoke(DownloadUtil.DownloadFileTask task)`  L464 @Override
    - 体内字面量："task"
- `List<String> failedTags(List<DownloadUtil.DownloadFileTask> tasks)`  L478
- `boolean shouldExtractVideoFrame(Object model)`  L494
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadFileTaskAdapter$WhenMappings`
L78 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadFileTaskAdapter.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L79
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadFileTitleViewHolder`
L12 · [class] public final DownloadFileTitleViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadFileTitleViewHolder.java`
注解：

字段/常量（1）：
- `ItemDownloadListTitleBinding binding`  L13

方法（2）：
- `ItemDownloadListTitleBinding getBinding()`  L15
- `public DownloadFileTitleViewHolder(ItemDownloadListTitleBinding binding)`  L20
    - 体内字面量："binding"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadItemViewHolder`
L27 · [class] public final DownloadItemViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadItemViewHolder.java`
注解：

字段/常量（9）：
- `DownloadListAdapter adapter`  L28
- `ItemDownloadListItemBinding binding`  L29
- `DownloadTask boundTask`  L30
- `boolean isDownloading`  L31
- `Function1<DownloadTask, Unit> removeListener`  L32
- `int i = item.progress.status`  L77
- `TextView textView = this.binding.tvVideoSpeed`  L100
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L101
- `TextView tvRedownload = this.binding.tvRedownload`  L133

方法（13）：
- `DownloadListAdapter getAdapter()`  L34
- `boolean getIsDownloading()`  L39
- `ItemDownloadListItemBinding getBinding()`  L43
- `public DownloadItemViewHolder(DownloadListAdapter adapter, boolean z, ItemDownloadListItemBinding binding, Function1<? super DownloadTask, Unit> removeListener)`  L49
    - 体内字面量："adapter" · "binding" · "removeListener"
- `DownloadTask getBoundTask()`  L60
- `void setBoundTask(DownloadTask downloadTask)`  L64
- `void downloadFinish()`  L68
- `void refresh(final DownloadTask item)`  L75
    - 体内字面量："item"
- `void onClick(View view)`  L137 @Override
- `void refresh$lambda$0(DownloadItemViewHolder this$0, DownloadTask item, View view)`  L147
    - 体内字面量："this$0" · "$item"
- `void setViewWidthPercent(final float percent)`  L154
- `void run()`  L159 @Override
- `void setViewWidthPercent$lambda$1(DownloadItemViewHolder this$0, float f)`  L172
    - 体内字面量："this$0"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadListAdapter`
L51 · [class] public final DownloadListAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadListAdapter.java`
注解：

字段/常量（25）：
- `int VIEW_TYPE_DOWNLOAD_ITEM = 2`  L52
- `int VIEW_TYPE_DOWNLOAD_TITLE = 1`  L53
- `DeviceType deviceType`  L54
- `SimpleDateFormat format`  L55
- `Lazy format2`  L58
- `boolean isDownloading`  L59
- `Regex m3DateRegex`  L60
- `int maxRetryCount`  L61
- `List<DownloadTask> mediaList`  L62
- `Function0<Unit> onTasksCleared`  L63
- `RecyclerView recyclerView`  L64
- `Regex regex`  L65
- `Map<String, Integer> retryCounts`  L66
- `String strSubstringAfterLast$default`  L154
- `boolean z = this.isDownloading`  L211
- `RecyclerView recyclerView = this.recyclerView`  L235
- `Function0<Unit> function0`  L256
- `int i = 0`  L258
- `String str = task.progress.tag`  L284
- `Map<String, Integer> map = this.retryCounts`  L288
- `RecyclerView recyclerView = this.recyclerView`  L300
- `String tag = downloadTask.progress.tag`  L340
- `Function0<Unit> function0`  L406
- `int i2 = i - 1`  L409
- `Function0<Unit> function0 = this$0.onTasksCleared`  L441

方法（41）：
- `int getItemViewType(int position)`  L96 @Override
- `List<DownloadTask> getMediaList$app_release_64()`  L100
- `void setMediaList$app_release_64(List<DownloadTask> list)`  L104
    - 体内字面量："<set-?>"
- ` DownloadListAdapter(boolean z, List list, DeviceType deviceType, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker)`  L109
- `public DownloadListAdapter(boolean z, List<DownloadTask> mediaList, DeviceType deviceType, Function0<Unit> function0)`  L113
    - 体内字面量："mediaList" · "deviceType" · "yyyy_MM_dd_HHmmss"
- `SimpleDateFormat invoke()`  L123 @Override
    - 体内字面量："(\\d{4}_\\d{2}_\\d{2}_\\d{6})" · "(\\d{8}_\\d{6})"
- `SimpleDateFormat getFormat()`  L133
- `SimpleDateFormat getFormat2()`  L137
- `Regex getRegex()`  L141
- `Regex getM3DateRegex()`  L145
- `DownloadTagInfo parseDownloadTag(String tag)`  L149
- `String parseDate(DownloadTagInfo tagInfo)`  L153
- `throw new NoWhenBranchMatchedException()`  L183
    - 体内字面量："/" · "/"
- `String buildThumbnailUrl(DownloadTagInfo tagInfo)`  L199
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L204 @Override
    - 体内字面量："parent" · "inflate(...)"
- `Unit invoke(DownloadTask downloadTask)`  L220 @Override
- `void invoke2(DownloadTask it)`  L226
    - 体内字面量："it"
- `void removeTask(final DownloadTask task)`  L234
- `void run()`  L239 @Override
- `void removeTask$lambda$0(DownloadListAdapter this$0, DownloadTask task)`  L249
    - 体内字面量："this$0" · "$task"
- `void removeTaskInternal(DownloadTask task)`  L255
- `boolean shouldRetry$app_release_64(DownloadTask task)`  L282
    - 体内字面量："task"
- `void resetRetryCount$app_release_64(DownloadTask task)`  L294
    - 体内字面量："task"
- `void notifyDataSetChangedSafely$app_release_64()`  L299
- `void run()`  L304 @Override
- `void notifyDataSetChangedSafely$lambda$2(DownloadListAdapter this$0)`  L314
    - 体内字面量："this$0"
- `void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position)`  L320 @Override
    - 体内字面量："holder" · "LogDownloadListener"
- `void onClick(View view)`  L364 @Override
    - 体内字面量："btnSelectAll"
- `void onClick(View view)`  L384 @Override
    - 体内字面量："btnSelectAll"
- `void onClick(View view)`  L397 @Override
- `void onBindViewHolder$lambda$7(int i, DownloadListAdapter this$0, DownloadTask item, View view)`  L405
- `void onBindViewHolder$lambda$10(DownloadListAdapter this$0, RecyclerView.ViewHolder holder, View view)`  L422
    - 体内字面量："this$0" · "$holder" · "LogDownloadListener" · "DownloadListAdapter: Removed task " · "DownloadListAdapter: Failed to remove task" · "DownloadListAdapter: Cleared all " · " tasks"
- `void onBindViewHolder$lambda$12(DownloadListAdapter this$0, View view)`  L448
    - 体内字面量："this$0"
- `void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads)`  L461 @Override
    - 体内字面量："holder" · "payloads" · "countUpdated"
- `int getItemCount()`  L480 @Override
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L485 @Override
    - 体内字面量："recyclerView"
- `void onDetachedFromRecyclerView(RecyclerView recyclerView)`  L492 @Override
    - 体内字面量："recyclerView"
- `void onViewRecycled(RecyclerView.ViewHolder holder)`  L499 @Override
    - 体内字面量："holder" · "LogDownloadListener"
- `void unRegister()`  L513
    - 体内字面量："LogDownloadListener"
- `void addTask(DownloadTask task)`  L520
    - 体内字面量："task"
- `boolean isEmpty()`  L530
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadListAdapter$WhenMappings`
L70 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadListAdapter.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L71
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTagInfo`
L13 · [class] public final DownloadTagInfo · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadTagInfo.java`
注解：

字段/常量（12）：
- `DeviceType deviceType`  L14
- `String filename`  L15
- `Integer ride3ProFileIndex`  L16
- `String ride3ProThumbnailCacheKey`  L17
- `String thumbnailUrl`  L18
- `String url`  L19
- `DeviceType deviceType2 = deviceType`  L28
- `String str5 = str2`  L32
- `String str6 = str3`  L36
- `Integer num2 = num`  L40
- `Integer num = this.ride3ProFileIndex`  L98
- `String str = this.ride3ProThumbnailCacheKey`  L100

方法（19）：
- `DownloadTagInfo copy$default(DownloadTagInfo downloadTagInfo, String str, DeviceType deviceType, String str2, String str3, Integer num, String str4, int i, Object obj)`  L21
- `String getFilename()`  L48
- `DeviceType getDeviceType()`  L53
- `String getUrl()`  L58
- `String getThumbnailUrl()`  L63
- `Integer getRide3ProFileIndex()`  L68
- `String getRide3ProThumbnailCacheKey()`  L73
- `DownloadTagInfo copy(String filename, DeviceType deviceType, String url, String thumbnailUrl, Integer ride3ProFileIndex, String ride3ProThumbnailCacheKey)`  L77
    - 体内字面量："filename" · "deviceType" · "url" · "thumbnailUrl"
- `boolean equals(Object other)`  L85
- `int hashCode()`  L96
- `String toString()`  L104
    - 体内字面量："DownloadTagInfo(filename=" · ", deviceType=" · ", url=" · ", thumbnailUrl=" · ", ride3ProFileIndex=" · ", ride3ProThumbnailCacheKey=" · ")"
- `public DownloadTagInfo(String filename, DeviceType deviceType, String url, String thumbnailUrl, Integer num, String str)`  L108
    - 体内字面量："filename" · "deviceType" · "url" · "thumbnailUrl"
- ` DownloadTagInfo(String str, DeviceType deviceType, String str2, String str3, Integer num, String str4, int i, DefaultConstructorMarker defaultConstructorMarker)`  L121
- `String getFilename()`  L125
- `DeviceType getDeviceType()`  L129
- `String getUrl()`  L133
- `String getThumbnailUrl()`  L137
- `Integer getRide3ProFileIndex()`  L141
- `String getRide3ProThumbnailCacheKey()`  L145
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTagInfoParser`
L16 · [class] public final DownloadTagInfoParser · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadTagInfoParser.java`
注解：

字段/常量（12）：
- `String FIELD_DEVICE_TYPE = "device_type"`  L17
- `String FIELD_FILENAME = "filename"`  L18
- `String FIELD_FILE_INDEX = "file_index"`  L19
- `String FIELD_THUMBNAIL_CACHE_KEY = "thumbnail_cache_key"`  L20
- `String FIELD_THUMBNAIL_URL = "thumbnail_url"`  L21
- `String FIELD_URL = "url"`  L22
- `int MIN_FILE_INDEX = 0`  L24
- `String strBuildThumbnailUrl$default`  L59
- `DeviceUrlBuilder deviceUrlBuilder = DeviceUrlBuilder.INSTANCE`  L66
- `String str = strOptString3`  L70
- `DeviceUrlBuilder deviceUrlBuilder2 = DeviceUrlBuilder.INSTANCE`  L74
- `String str2 = strBuildThumbnailUrl$default`  L78

方法（7）：
- `private DownloadTagInfoParser()`  L26
- `String encode(DownloadTagInfo info)`  L29
    - 体内字面量："info" · "device_type" · "url" · "toString(...)"
- `DownloadTagInfo parse(String tag)`  L49
    - 体内字面量："tag"
- `DownloadTagInfo parseJson(JSONObject json)`  L58
- `DeviceType parseDeviceType(String value)`  L90
- `Integer parseFileIndex(JSONObject json)`  L98
- `DownloadTagInfo legacyTag(String tag)`  L109
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTaskCurrentDeviceRoute`
L25 · [class] public final DownloadTaskCurrentDeviceRoute · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadTaskCurrentDeviceRoute.java`
注解：

字段/常量（8）：
- `RouteSnapshot route`  L32
- `EndpointGrant controlEndpointGrant`  L33
- `String id`  L34
- `Object objM3074constructorimpl`  L35
- `Result.Companion companion = Result.INSTANCE`  L47
- `Result.Companion companion2 = Result.INSTANCE`  L50
- `boolean z = false`  L59
- `Object obj = null`  L60

方法（2）：
- `private DownloadTaskCurrentDeviceRoute()`  L28
- `DownloadNetworkRoute.Device resolve(DeviceType deviceType, DeviceSessionManager sessions)`  L31
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTaskThumbnailModel`
L11 · [class] public abstract DownloadTaskThumbnailModel · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadTaskThumbnailModel.java`
注解：

方法（3）：
- ` DownloadTaskThumbnailModel(DefaultConstructorMarker defaultConstructorMarker)`  L12
- `Object getModel()`  L16
- `private DownloadTaskThumbnailModel()`  L18
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/download/adapter/DownloadTaskThumbnailModel$Local;" · "Lcom/tuwinsmart/tuwin/presentation/ui/download/adapter/DownloadTaskThumbnailModel;" · "model" · "(Ljava/lang/Object;)V" · "getModel" · "()Ljava/lang/Object;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/presentation/ui/download/adapter/DownloadTaskThumbnailModel$Device;" · "Lcom/tuwinsmart/tuwin/presentation/ui/download/adapter/DownloadTaskThumbnailModel;" · "model" · "(Ljava/lang/Object;)V" · "getModel" · "()Ljava/lang/Object;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTaskThumbnailModel$Device`
L73 · [class] public static final Device · extends `DownloadTaskThumbnailModel` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadTaskThumbnailModel.java`
注解：

字段/常量（1）：
- `Object model`  L74

方法（8）：
- `Device copy$default(Device device, Object obj, int i, Object obj2)`  L76
- `Object getModel()`  L84
- `Device copy(Object model)`  L88
    - 体内字面量："model"
- `boolean equals(Object other)`  L93
- `int hashCode()`  L100
- `String toString()`  L104
    - 体内字面量："Device(model=" · ")"
- `public Device(Object model)`  L109
    - 体内字面量："model"
- `Object getModel()`  L116 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTaskThumbnailModel$Local`
L23 · [class] public static final Local · extends `DownloadTaskThumbnailModel` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadTaskThumbnailModel.java`
注解：

字段/常量（1）：
- `Object model`  L24

方法（8）：
- `Local copy$default(Local local, Object obj, int i, Object obj2)`  L26
- `Object getModel()`  L34
- `Local copy(Object model)`  L38
    - 体内字面量："model"
- `boolean equals(Object other)`  L43
- `int hashCode()`  L50
- `String toString()`  L54
    - 体内字面量："Local(model=" · ")"
- `public Local(Object model)`  L59
    - 体内字面量："model"
- `Object getModel()`  L66 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTaskThumbnailRequestPolicy`
L22 · [class] public final DownloadTaskThumbnailRequestPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadTaskThumbnailRequestPolicy.java`
注解：

字段/常量（17）：
- `Object objM3074constructorimpl`  L56
- `Result.Companion companion = Result.INSTANCE`  L66
- `Result.Companion companion2 = Result.INSTANCE`  L69
- `Object objM3074constructorimpl`  L93
- `Result.Companion companion = Result.INSTANCE`  L98
- `DownloadTaskThumbnailRequestPolicy downloadTaskThumbnailRequestPolicy = this`  L99
- `Result.Companion companion2 = Result.INSTANCE`  L102
- `Integer ride3ProFileIndex`  L115
- `Object objM3074constructorimpl`  L116
- `Result.Companion companion = Result.INSTANCE`  L122
- `DownloadTaskThumbnailRequestPolicy downloadTaskThumbnailRequestPolicy = this`  L123
- `Result.Companion companion2 = Result.INSTANCE`  L126
- `Object objM3074constructorimpl`  L139
- `Result.Companion companion = Result.INSTANCE`  L144
- `DownloadTaskThumbnailRequestPolicy downloadTaskThumbnailRequestPolicy = this`  L145
- `Result.Companion companion2 = Result.INSTANCE`  L148
- `String str`  L161

方法（7）：
- `private DownloadTaskThumbnailRequestPolicy()`  L52
- `DownloadTaskThumbnailModel resolveModel(DownloadUtil.DownloadFileTask task, DownloadTagInfo tagInfo, DownloadNetworkRoute.Device currentDeviceRoute, Function1<? super String, ? extends Object> resolveLocalThumbnail, Function3<? super String, ? super String, ? super Long, ? extends Object> authorizeM3Thumbnail, Function3<? super String, ? super Integer, ? super Long, ? extends Object> authorizeRide3ProThumbnail, Function3<? super String, ? super String, ? super Long, ? extends Object> authorizeRide5Preview)`  L55
- `throw new NoWhenBranchMatchedException()`  L89
- `DownloadTaskThumbnailModel resolveM3Model(DownloadUtil.DownloadFileTask task, DownloadTagInfo tagInfo, DownloadNetworkRoute.Device currentDeviceRoute, Function3<? super String, ? super String, ? super Long, ? extends Object> authorizeThumbnail)`  L92
- `DownloadTaskThumbnailModel resolveRide3ProModel(DownloadUtil.DownloadFileTask task, DownloadTagInfo tagInfo, DownloadNetworkRoute.Device currentDeviceRoute, Function3<? super String, ? super Integer, ? super Long, ? extends Object> authorizeThumbnail)`  L114
- `DownloadTaskThumbnailModel resolveRide5Model(DownloadUtil.DownloadFileTask task, DownloadTagInfo tagInfo, DownloadNetworkRoute.Device currentDeviceRoute, Function3<? super String, ? super String, ? super Long, ? extends Object> authorizePreview)`  L138
- `String completedLocalPath(DownloadUtil.DownloadFileTask task)`  L160
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTaskThumbnailRequestPolicy$WhenMappings`
L27 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadTaskThumbnailRequestPolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L28
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTitleViewHolder`
L12 · [class] public final DownloadTitleViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadTitleViewHolder.java`
注解：

字段/常量（1）：
- `ItemDownloadListTitleBinding binding`  L13

方法（2）：
- `ItemDownloadListTitleBinding getBinding()`  L15
- `public DownloadTitleViewHolder(ItemDownloadListTitleBinding binding)`  L20
    - 体内字面量："binding"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadVideoItemViewHolder`
L12 · [class] public final DownloadVideoItemViewHolder · extends `RecyclerView.ViewHolder` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/DownloadVideoItemViewHolder.java`
注解：

字段/常量（1）：
- `ItemDownloadListVideoItemBinding binding`  L13

方法（2）：
- `ItemDownloadListVideoItemBinding getBinding()`  L15
- `public DownloadVideoItemViewHolder(ItemDownloadListVideoItemBinding binding)`  L20
    - 体内字面量："binding"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.ListDownloadListener`
L18 · [class] public final ListDownloadListener · extends `DownloadListener` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/ListDownloadListener.java`
注解：

字段/常量（4）：
- `DownloadListAdapter adapter`  L19
- `DownloadItemViewHolder holder`  L20
- `DownloadTask task`  L21
- `Throwable th = progress.exception`  L55

方法（7）：
- `void onStart(Progress progress)`  L24 @Override
    - 体内字面量："progress"
- `DownloadTask getTask()`  L28
- `public ListDownloadListener(DownloadListAdapter adapter, DownloadTask task, DownloadItemViewHolder holder)`  L33
    - 体内字面量："adapter" · "task" · "holder"
- `void onProgress(Progress progress)`  L44 @Override
    - 体内字面量："progress"
- `void onError(Progress progress)`  L53 @Override
    - 体内字面量："progress"
- `void onFinish(File file, Progress progress)`  L73 @Override
    - 体内字面量："file" · "progress"
- `void onRemove(Progress progress)`  L81 @Override
    - 体内字面量："progress"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.LocalDownloadListAdapter`
L44 · [class] public final LocalDownloadListAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/LocalDownloadListAdapter.java`
注解：

字段/常量（47）：
- `int ACTION_ENTER_SELECT_MODE = 1`  L45
- `int ACTION_EXIT_SELECT_MODE = 2`  L46
- `int ACTION_RETRY_LOAD = 6`  L47
- `int ACTION_VIDEO_ITEM_CLICK = 3`  L48
- `int VIEW_TYPE_DATE_TITLE = 5`  L49
- `int VIEW_TYPE_SECTION_TITLE = 3`  L50
- `int VIEW_TYPE_VIDEO_ITEM = 6`  L51
- `boolean isLoading`  L52
- `boolean isSuccess`  L53
- `OnStorageListActionListener listener`  L54
- `List<VideoItem> mSelectItems`  L55
- `List<VideoData> mediaList`  L56
- `SimpleDateFormat sdf`  L57
- `Function2<? super Integer, ? super Boolean, Unit> selectListener`  L58
- `boolean selectMode`  L59
- `List<Integer> titleIndex`  L60
- `int totalCount`  L61
- `List<VideoData> list = this.mediaList`  L105
- `OnStorageListActionListener onStorageListActionListener = this.listener`  L112
- `View itemView = holder.itemView`  L150
- `Ride3ProAviThumbnailCache ride3ProAviThumbnailCache = Ride3ProAviThumbnailCache.INSTANCE`  L194
- `View itemView2 = holder.itemView`  L199
- `OnStorageListActionListener onStorageListActionListener`  L221
- `int iIntValue`  L231
- `int i2 = i + 1`  L235
- `List<Integer> list = this$0.titleIndex`  L239
- `List<VideoItem> list2 = this$0.mSelectItems`  L244
- `Function2<? super Integer, ? super Boolean, Unit> function2 = this$0.selectListener`  L251
- `boolean z`  L259
- `int iIntValue`  L260
- `boolean z2`  L261
- `List<Integer> list = this$0.titleIndex`  L278
- `Function2<? super Integer, ? super Boolean, Unit> function2 = this$0.selectListener`  L300
- `OnStorageListActionListener onStorageListActionListener = this$0.listener`  L307
- `int size = 0`  L368
- `ArrayList arrayList`  L390
- `List<VideoItem> list = items`  L396
- `List<VideoData> list = this.mediaList`  L413
- `int i = 0`  L415
- `int i2 = 0`  L416
- `int i3 = i + 1`  L418
- `int i = 0`  L439
- `long j = 60`  L471
- `long j2 = totalSeconds / j`  L472
- `long j3 = totalSeconds % j`  L473
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L474
- `Function2<? super Integer, ? super Boolean, Unit> function2 = this.selectListener`  L491

方法（31）：
- ` LocalDownloadListAdapter(List list, OnStorageListActionListener onStorageListActionListener, int i, DefaultConstructorMarker defaultConstructorMarker)`  L63
- `public LocalDownloadListAdapter(List<VideoData> mediaList, OnStorageListActionListener onStorageListActionListener)`  L67
    - 体内字面量："mediaList" · "HH:mm"
- `int getTotalCount()`  L78
- `void setTotalCount(int i)`  L82
- `Function2<Integer, Boolean, Unit> getSelectListener()`  L86
- `void setSelectListener(Function2<? super Integer, ? super Boolean, Unit> function2)`  L90
- `boolean getSelectMode()`  L94
- `void setSelectMode(boolean z)`  L98
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L119 @Override
    - 体内字面量："parent" · "inflate(...)" · "inflate(...)" · "inflate(...)"
- `int getItemViewType(int position)`  L137 @Override
- `void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position)`  L142 @Override
    - 体内字面量："holder"
- `void onClick(View view)`  L154 @Override
    - 体内字面量："null cannot be cast to non-null type com.tuwinsmart.tuwin.presentation.ui.storage.adapter.VideTitle" · "btnSelectAll"
- `void onClick(View view)`  L175 @Override
    - 体内字面量："null cannot be cast to non-null type com.tuwinsmart.tuwin.presentation.ui.storage.adapter.VideoItem"
- `void onClick(View view)`  L203 @Override
    - 体内字面量："ckSelect"
- `void onClick(View view)`  L211 @Override
- `void onBindViewHolder$lambda$1(LocalDownloadListAdapter this$0, View view)`  L220
- `void onBindViewHolder$lambda$2(VideTitle item, int i, LocalDownloadListAdapter this$0, View view)`  L230
- `void onBindViewHolder$lambda$3(LocalDownloadListAdapter this$0, VideoItem item, RecyclerView.ViewHolder holder, int i, View view)`  L258
- `void onBindViewHolder$lambda$4(RecyclerView.ViewHolder holder, View view)`  L314
    - 体内字面量："$holder"
- `void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads)`  L320 @Override
    - 体内字面量："holder" · "payloads" · "checkStatus" · "null cannot be cast to non-null type com.tuwinsmart.tuwin.presentation.ui.storage.adapter.VideTitle" · "null cannot be cast to non-null type com.tuwinsmart.tuwin.presentation.ui.storage.adapter.VideoItem" · "update" · "null cannot be cast to non-null type com.tuwinsmart.tuwin.presentation.ui.storage.adapter.VideoItem"
- `int getItemCount()`  L358 @Override
- `boolean hasSelectedItems()`  L362
- `int hasSelectedCount()`  L366
- `void deleteSelectedItems()`  L376
- `List<String> getDownloadPaths()`  L389
- `void generateTitleIndex()`  L411
- `List<VideoData> processMediaList()`  L434
- `void loadFinish(boolean success)`  L454
- `void loadFinish()`  L464
- `String formatSecondsToMinutesAndSeconds(long totalSeconds)`  L470
- `void selectAll(boolean bool)`  L480
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.LogDownloadListener`
L13 · [class] public final LogDownloadListener · extends `DownloadListener` · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/LogDownloadListener.java`
注解：

方法（6）：
- `public LogDownloadListener()`  L14
    - 体内字面量："LogDownloadListener"
- `void onStart(Progress progress)`  L19 @Override
    - 体内字面量："progress" · "onStart: "
- `void onProgress(Progress progress)`  L25 @Override
    - 体内字面量："progress" · "onProgress: "
- `void onError(Progress progress)`  L31 @Override
    - 体内字面量："progress" · "onError: "
- `void onFinish(File file, Progress progress)`  L38 @Override
    - 体内字面量："file" · "progress" · "onFinish: "
- `void onRemove(Progress progress)`  L45 @Override
    - 体内字面量："progress" · "onRemove: "
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.Ride3ProAviThumbnailCache`
L24 · [class] public final Ride3ProAviThumbnailCache · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/Ride3ProAviThumbnailCache.java`
注解：

字段/常量（6）：
- `String CACHE_DIR_NAME = "ride3pro_avi_thumbnails"`  L25
- `int EXTRACTOR_OK = 0`  L26
- `Object objM3074constructorimpl`  L52
- `Result.Companion companion = Result.INSTANCE`  L66
- `Ride3ProAviThumbnailCache ride3ProAviThumbnailCache = this`  L67
- `Result.Companion companion2 = Result.INSTANCE`  L72

方法（8）：
- `private Ride3ProAviThumbnailCache()`  L29
- `Object resolveThumbnailModel$default(Ride3ProAviThumbnailCache ride3ProAviThumbnailCache, String str, File file, Function3 function3, int i, Object obj)`  L33
- `Integer invoke(String str2, String str3, Long l)`  L37 @Override
- `Integer invoke(String videoPath, String savePath, long j)`  L41
    - 体内字面量："videoPath" · "savePath"
- `Object resolveThumbnailModel(String filePath, File cacheRootDir, Function3<? super String, ? super String, ? super Long, Integer> frameExtractor)`  L51
- `String buildThumbName$app_release_64(String filePath)`  L78
    - 体内字面量："filePath" · "MD5" · "getBytes(...)"
- `CharSequence invoke(byte b)`  L86
    - 体内字面量："%02x" · "format(...)"
- `CharSequence invoke(Byte b)`  L93 @Override
    - 体内字面量：".jpg"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.Ride3ProThumbnailRequestPolicy`
L14 · [class] public final Ride3ProThumbnailRequestPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/download/adapter/Ride3ProThumbnailRequestPolicy.java`
注解：

方法（4）：
- `private Ride3ProThumbnailRequestPolicy()`  L17
- `boolean shouldRequestThumbnail(DeviceType deviceType)`  L20
    - 体内字面量："deviceType"
- `Object resolveThumbnailModel(DeviceType deviceType, Object model)`  L25
    - 体内字面量："deviceType"
- `String resolveSignatureKey(DownloadTagInfo tagInfo)`  L33
    - 体内字面量："tagInfo" · "Thumbnail_"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.CompletedDownloadPlaybackDecision`
L11 · [enum] public CompletedDownloadPlaybackDecision · `com/tuwinsmart/tuwin/presentation/p010ui/download/CompletedDownloadPlaybackDecision.java`
注解：

枚举常量（4）：
- `IGNORE()`  L12
- `SHOW_PHOTO()`  L13
- `PLAY_VIDEO()`  L14
- `CONFIRM_STOP()`  L15

方法（1）：
- `EnumEntries<CompletedDownloadPlaybackDecision> getEntries()`  L19
### `com.tuwinsmart.tuwin.presentation.p010ui.download.CompletedDownloadPlaybackPolicy`
L13 · [class] public final CompletedDownloadPlaybackPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/download/CompletedDownloadPlaybackPolicy.java`
注解：

字段/常量（1）：
- `String[] PHOTO_EXTENSIONS = {".jpg", ".jpeg", ".png"}`  L15

方法（3）：
- `private CompletedDownloadPlaybackPolicy()`  L17
- `CompletedDownloadPlaybackDecision decide(DeviceType entryDeviceType, DownloadUtil.DownloadFileTask task, boolean hasActiveTask)`  L20
    - 体内字面量："entryDeviceType" · "task"
- `boolean isPhoto(DownloadUtil.DownloadFileTask task)`  L39
### `com.tuwinsmart.tuwin.presentation.p010ui.download.DownloadListActivity`
L63 · [class] public final DownloadListActivity · extends `ToolBarActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity.java`
注解：

字段/常量（26）：
- `String EXTRA_ENTRY_DEVICE_TYPE = "extra_entry_device_type"`  L67
- `ActivityDownloadListBinding binding`  L68
- `boolean keepScreenOnApplied`  L69
- `DownloadFileTaskAdapter mAdapter`  L70
- `ActivityDownloadListBinding activityDownloadListBinding = this.binding`  L202
- `ActivityDownloadListBinding activityDownloadListBinding = this.binding`  L226
- `ActivityDownloadListBinding activityDownloadListBinding2 = null`  L227
- `ActivityDownloadListBinding activityDownloadListBinding3 = DownloadListActivity.this.binding`  L246
- `ActivityDownloadListBinding activityDownloadListBinding3 = this.binding`  L298
- `RecyclerView recyclerView = activityDownloadListBinding3.recyclerView`  L303
- `DownloadFileTaskAdapter downloadFileTaskAdapter = this.mAdapter`  L304
- `ActivityDownloadListBinding activityDownloadListBinding4 = this.binding`  L310
- `ActivityDownloadListBinding activityDownloadListBinding = this.binding`  L372
- `ActivityDownloadListBinding activityDownloadListBinding2 = null`  L373
- `DownloadFileTaskAdapter downloadFileTaskAdapter = this.mAdapter`  L379
- `ActivityDownloadListBinding activityDownloadListBinding3 = this.binding`  L385
- `DownloadFileTaskAdapter downloadFileTaskAdapter = this.mAdapter`  L402
- `boolean z`  L447
- `CommonDialog.Companion companion = CommonDialog.INSTANCE`  L486
- `Object objM3074constructorimpl`  L516
- `Result.Companion companion = Result.INSTANCE`  L518
- `DownloadListActivity downloadListActivity = this`  L519
- `Result.Companion companion2 = Result.INSTANCE`  L522
- `Ride3ProAviThumbnailCache ride3ProAviThumbnailCache = Ride3ProAviThumbnailCache.INSTANCE`  L537
- `List<DownloadUtil.DownloadFileTask> list = tasks`  L658
- `boolean z = false`  L659

方法（41）：
- `VerifiedDeviceFileCatalog invoke()`  L77 @Override
- `DeviceType invoke()`  L93 @Override
- `Boolean invoke()`  L119 @Override
- `VerifiedDeviceFileCatalog getFileCatalog()`  L152
- `DeviceType getEntryDeviceType()`  L157
- `boolean getShouldStopDownloadsOnExit()`  L161
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/download/DownloadListActivity$Companion;" · "()V" · "EXTRA_ENTRY_DEVICE_TYPE" · "createIntent" · "Landroid/content/Intent;" · "Landroid/content/Context;" · "entryDeviceType" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "app_release_64"
- `View getContentRoot()`  L185 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L199 @Override
- `void onRefresh()`  L209 @Override
- `void onCreate$lambda$0(DownloadListActivity this$0)`  L219
    - 体内字面量："this$0"
- `void initData()`  L224
- `Unit invoke()`  L239 @Override
- `void invoke2()`  L245
- `Object invoke(String str, String str2, Long l)`  L259 @Override
- `Object invoke(String sessionId, String filePath, long j)`  L263
    - 体内字面量："sessionId" · "filePath"
- `Object invoke(String str, Integer num, Long l)`  L274 @Override
- `Object invoke(String sessionId, int i, long j)`  L278
    - 体内字面量："sessionId"
- `Object invoke(String str, String str2, Long l)`  L288 @Override
- `Object invoke(String sessionId, String filePath, long j)`  L292
    - 体内字面量："sessionId" · "filePath"
- `void refreshTasks()`  L370
- `void onBackPressed()`  L396 @Override
    - 体内字面量："DownloadListActivity: Exit without stopping downloads"
- `void showDownloadExitConfirmDialog()`  L422
    - 体内字面量："getString(...)"
- `Unit invoke()`  L431 @Override
- `void invoke2()`  L437
- `void onTaskClick(final DownloadUtil.DownloadFileTask task)`  L446
- `Unit invoke()`  L471 @Override
- `void invoke2()`  L477
- `void showStopDownloadConfirmDialog(String message, Function0<Unit> onStop)`  L485
- `void invoke2()`  L493
- `Unit invoke()`  L497 @Override
- `void stopActiveDownloads()`  L505
    - 体内字面量："DownloadListActivity: Stopping " · " " · " tasks" · "Active " · " download tasks remain after cancellation"
- `DownloadNetworkRoute.Device currentReadyDeviceRoute()`  L515
- `Object resolveLocalThumbnail(String filePath)`  L536
- `void showDownloadedPhoto(DownloadUtil.DownloadFileTask task)`  L543
    - 体内字面量：" completed photo download is unavailable: "
- `void playDownloadedVideo(DownloadUtil.DownloadFileTask task)`  L554
    - 体内字面量：" completed video download is unavailable: "
- `File resolveCompletedFile(DownloadUtil.DownloadFileTask task)`  L564
- `void onResume()`  L583 @Override
- `void restoreRide3ProPlaybackModeAfterBackground()`  L589
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.presentation.ui.download.DownloadListActivity$restoreRide3ProPlaybackModeAfterBackground$1" · "DownloadListActivity.kt" · "invokeSuspend"
- `void syncKeepScreenOnState$default(DownloadListActivity downloadListActivity, List list, int i, Object obj)`  L646
- `void syncKeepScreenOnState(List<DownloadUtil.DownloadFileTask> tasks)`  L654
- `void onDestroy()`  L681 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.download.DownloadListActivity$C27302`
L322 · [class] C27302 · extends `FunctionReferenceImpl implements Function1<DownloadUtil.DownloadFileTask, Unit>` · implements `Function1<DownloadUtil.DownloadFileTask, Unit>` · `com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity.java`
注解：

方法（2）：
- `Unit invoke(DownloadUtil.DownloadFileTask downloadFileTask)`  L328 @Override
- `void invoke2(DownloadUtil.DownloadFileTask p0)`  L334
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.DownloadListActivity$C27313`
L343 · [class] C27313 · extends `FunctionReferenceImpl implements Function0<DownloadNetworkRoute.Device>` · implements `Function0<DownloadNetworkRoute.Device>` · `com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity.java`
注解：

方法（1）：
- `DownloadNetworkRoute.Device invoke()`  L350 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.download.DownloadListActivity$C27324`
L358 · [class] C27324 · extends `FunctionReferenceImpl implements Function1<String, Object>` · implements `Function1<String, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity.java`
注解：

方法（1）：
- `Object invoke(String p0)`  L364 @Override
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.DownloadListActivity$C27371`
L599 · [class] static final C27371 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity.java`
注解：

字段/常量（4）：
- `int label`  L600
- `Object objM2859setPlaybackModeIoAF18A`  L618
- `int i = this.label`  L620
- `DownloadListActivity downloadListActivity = DownloadListActivity.this`  L635

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L607 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L612 @Override
- `Object invokeSuspend(Object obj)`  L617 @Override
- `throw new IllegalStateException( 130 )`  L630
### `com.tuwinsmart.tuwin.presentation.p010ui.download.DownloadListActivity$Companion`
L167 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L168
- `private Companion()`  L172
- `Intent createIntent(Context context, DeviceType entryDeviceType)`  L175
    - 体内字面量："context" · "entryDeviceType"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.DownloadListActivity$taskListener$1`
L17 · [class] final DownloadListActivity$taskListener$1 · extends `Lambda implements Function1<List<? extends DownloadUtil.DownloadFileTask>, Unit>` · implements `Function1<List<? extends DownloadUtil.DownloadFileTask>, Unit>` · `com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity$taskListener$1.java`
注解：

字段/常量（5）：
- `DownloadListActivity this$0`  L18
- `DownloadListActivity downloadListActivity = this.this$0`  L35
- `ActivityDownloadListBinding activityDownloadListBinding = this$0.binding`  L48
- `DownloadFileTaskAdapter downloadFileTaskAdapter = null`  L49
- `DownloadFileTaskAdapter downloadFileTaskAdapter2 = this$0.mAdapter`  L55

方法（4）：
- `Unit invoke(List<? extends DownloadUtil.DownloadFileTask> list)`  L27 @Override
- `void invoke2(final List<DownloadUtil.DownloadFileTask> tasks)`  L33
    - 体内字面量："tasks"
- `void run()`  L38 @Override
- `void invoke$lambda$0(DownloadListActivity this$0, List tasks)`  L45
    - 体内字面量："this$0" · "$tasks"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.DownloadListActivity$WhenMappings`
L126 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/download/DownloadListActivity.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L127
### `com.tuwinsmart.tuwin.presentation.p010ui.download.ExclusiveDownloadExitPolicy`
L12 · [class] public final ExclusiveDownloadExitPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/download/ExclusiveDownloadExitPolicy.java`
注解：

方法（2）：
- `private ExclusiveDownloadExitPolicy()`  L15
- `boolean shouldStopDownloadsOnExit(DeviceType deviceType)`  L18
    - 体内字面量："deviceType"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.fragment.FileWithTime`
L13 · [class] public final FileWithTime · `com/tuwinsmart/tuwin/presentation/p010ui/download/fragment/FileWithTime.java`
注解：

字段/常量（2）：
- `File file`  L14
- `Date time`  L15

方法（10）：
- `FileWithTime copy$default(FileWithTime fileWithTime, File file, Date date, int i, Object obj)`  L17
- `File getFile()`  L28
- `Date getTime()`  L33
- `FileWithTime copy(File file, Date time)`  L37
    - 体内字面量："file" · "time"
- `boolean equals(Object other)`  L43
- `int hashCode()`  L54
- `String toString()`  L58
    - 体内字面量："FileWithTime(file=" · ", time=" · ")"
- `public FileWithTime(File file, Date time)`  L62
    - 体内字面量："file" · "time"
- `File getFile()`  L69
- `Date getTime()`  L73
### `com.tuwinsmart.tuwin.presentation.p010ui.download.fragment.LocalDownloadItemFragment`
L72 · [class] public final LocalDownloadItemFragment · extends `BaseMainFragment` · `com/tuwinsmart/tuwin/presentation/p010ui/download/fragment/LocalDownloadItemFragment.java`
注解：

字段/常量（26）：
- `FragmentLocalDownloadListBinding binding`  L76
- `Gloading.Holder holder`  L77
- `LocalDownloadListAdapter mAdapter`  L78
- `String type`  L79
- `FragmentLocalDownloadListBinding fragmentLocalDownloadListBinding = this.binding`  L114
- `LocalDownloadListAdapter localDownloadListAdapter = this.mAdapter`  L128
- `String str = this.type`  L142
- `Gloading.Holder holder = null`  L164
- `Gloading.Holder holder2 = this.holder`  L181
- `VideoPlayActivity.Companion companion = VideoPlayActivity.INSTANCE`  L227
- `ShowPicsActivity.Companion companion2 = ShowPicsActivity.INSTANCE`  L234
- `Gloading.Holder holder = this.holder`  L270
- `String string`  L285
- `MatchGroupCollection groups`  L286
- `MatchGroup matchGroup`  L287
- `LocalDownloadItemFragment localDownloadItemFragment = LocalDownloadItemFragment.this`  L291
- `FileWithTime fileWithTime = null`  L295
- `String str = value`  L305
- `LocalDownloadItemFragment localDownloadItemFragment2 = LocalDownloadItemFragment.this`  L330
- `String str2 = null`  L331
- `boolean zAreEqual`  L378
- `Gloading.Holder holder2 = null`  L381
- `Gloading.Holder holder3 = LocalDownloadItemFragment.this.holder`  L385
- `Gloading.Holder holder4 = LocalDownloadItemFragment.this.holder`  L424
- `Gloading.Holder holder5 = LocalDownloadItemFragment.this.holder`  L433
- `boolean z = true`  L492

方法（36）：
- `SimpleDateFormat invoke()`  L89 @Override
    - 体内字面量："HH:mm:ss" · "(\\d{4}_\\d{2}_\\d{2}_\\d{6})"
- `SimpleDateFormat getFormat()`  L97
- `SimpleDateFormat getFormat2()`  L101
- `SimpleDateFormat getFormat5()`  L105
- `Regex getRegex()`  L109
- `FragmentLocalDownloadListBinding getBinding()`  L113
- `void setBinding(FragmentLocalDownloadListBinding fragmentLocalDownloadListBinding)`  L122
    - 体内字面量："<set-?>"
- `LocalDownloadListAdapter getMAdapter()`  L127
- `void setMAdapter(LocalDownloadListAdapter localDownloadListAdapter)`  L136
    - 体内字面量："<set-?>"
- `String getType()`  L141
- `void setType(String str)`  L150
    - 体内字面量："<set-?>"
- `View getLayoutRoot(LayoutInflater inflater, ViewGroup container)`  L156 @Override
    - 体内字面量："inflater" · "inflate(...)" · "wrap(...)"
- `void run()`  L171 @Override
- `void onRefresh()`  L177 @Override
- `void getLayoutRoot$lambda$0(LocalDownloadItemFragment this$0)`  L193
    - 体内字面量："this$0"
- `void getLayoutRoot$lambda$1(LocalDownloadItemFragment this$0)`  L199
    - 体内字面量："this$0"
- `void initFragment()`  L205 @Override
    - 体内字面量："type"
- `void onItemClick(int actionId, int position, VideoData videoData)`  L215 @Override
    - 体内字面量："null cannot be cast to non-null type com.tuwinsmart.tuwin.presentation.ui.storage.adapter.VideoItem"
- `int getSpanSize(int position)`  L244 @Override
- `void lazyInitData()`  L256 @Override
- `void formatData$default(LocalDownloadItemFragment localDownloadItemFragment, boolean z, int i, Object obj)`  L260
- `void formatData(boolean needLoading)`  L267
    - 体内字面量："formatData   "
- `Pair<Integer, List<VideoData>> invoke(String origin)`  L284 @Override
- `int compare(T t, T t2)`  L326 @Override
- `Object apply(Object obj)`  L361 @Override
- `Unit invoke(Pair<? extends Integer, ? extends List<VideoData>> pair)`  L371 @Override
- `void invoke2(Pair<Integer, ? extends List<VideoData>> pair)`  L377
- `void accept(Object obj)`  L444 @Override
- `Pair formatData$lambda$3(Function1 tmp0, Object p0)`  L451
    - 体内字面量："$tmp0" · "p0"
- `void formatData$lambda$4(Function1 tmp0, Object obj)`  L458
    - 体内字面量："$tmp0"
- `void fragmentShow()`  L464 @Override
    - 体内字面量："fragmentShow " · "--"
- `void fragmentHide()`  L469 @Override
    - 体内字面量："fragmentHide " · "--"
- `void showSelectMode(boolean selectMode, Function2<? super Integer, ? super Boolean, Unit> selectListener)`  L473
- `boolean selectAll(boolean bool)`  L482
- `boolean isVideoExist(String filePath)`  L490
    - 体内字面量："filePath"
- `void deleteSelectItems()`  L512
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/download/fragment/LocalDownloadItemFragment$Companion;" · "()V" · "getInstance" · "Lcom/tuwinsmart/tuwin/presentation/ui/download/fragment/LocalDownloadItemFragment;" · "type" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.fragment.LocalDownloadItemFragment$Companion`
L518 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/p010ui/download/fragment/LocalDownloadItemFragment.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L519
- `private Companion()`  L523
- `LocalDownloadItemFragment getInstance(String type)`  L526
    - 体内字面量："type" · "type"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.fragment.LocalDownloadListFragment`
L27 · [class] public final LocalDownloadListFragment · extends `BaseMainFragment` · `com/tuwinsmart/tuwin/presentation/p010ui/download/fragment/LocalDownloadListFragment.java`
注解：

字段/常量（5）：
- `FragmentLocalDownloadListBinding binding`  L31
- `boolean isDownloading`  L32
- `DownloadListAdapter mAdapter`  L33
- `FragmentLocalDownloadListBinding fragmentLocalDownloadListBinding = this.binding`  L48
- `DownloadListAdapter downloadListAdapter = this.mAdapter`  L62

方法（13）：
- `void fragmentHide()`  L36 @Override
- `void fragmentShow()`  L40 @Override
- `void lazyInitData()`  L44 @Override
- `FragmentLocalDownloadListBinding getBinding()`  L47
- `void setBinding(FragmentLocalDownloadListBinding fragmentLocalDownloadListBinding)`  L56
    - 体内字面量："<set-?>"
- `DownloadListAdapter getMAdapter()`  L61
- `void setMAdapter(DownloadListAdapter downloadListAdapter)`  L70
    - 体内字面量："<set-?>"
- `boolean getIsDownloading()`  L76
- `void setDownloading(boolean z)`  L80
- `View getLayoutRoot(LayoutInflater inflater, ViewGroup container)`  L85 @Override
    - 体内字面量："inflater" · "inflate(...)" · "getRoot(...)"
- `void initFragment()`  L96 @Override
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/download/fragment/LocalDownloadListFragment$Companion;" · "()V" · "newInstance" · "Lcom/tuwinsmart/tuwin/presentation/ui/download/fragment/LocalDownloadListFragment;" · "isDownloading" · "app_release_64"
- `void onTaskDownloadFinish(TaskFinishInsertEvent event)`  L125 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："event"
- `void onDestroyView()`  L134 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.download.fragment.LocalDownloadListFragment$Companion`
L107 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/p010ui/download/fragment/LocalDownloadListFragment.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L108
- `private Companion()`  L112
- `LocalDownloadListFragment newInstance(boolean isDownloading)`  L115
    - 体内字面量："isDownloading"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.fragment.LocalDownloadVideoValidationPolicy`
L13 · [class] public final LocalDownloadVideoValidationPolicy · `com/tuwinsmart/tuwin/presentation/p010ui/download/fragment/LocalDownloadVideoValidationPolicy.java`
注解：

方法（2）：
- `private LocalDownloadVideoValidationPolicy()`  L16
- `boolean shouldShowLocalFile(String filePath, String metadataDuration, boolean hasFirstFrame, long fileLength)`  L19
    - 体内字面量："filePath" · ".avi"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.Ride3ProDownloadBackgroundAction`
L12 · [class] public final Ride3ProDownloadBackgroundAction · `com/tuwinsmart/tuwin/presentation/p010ui/download/Ride3ProDownloadBackgroundAction.java`
注解：

方法（2）：
- `private Ride3ProDownloadBackgroundAction()`  L15
- `void run(Function0<Unit> failActiveDownloads, Function0<Unit> resumeRecording)`  L18
    - 体内字面量："failActiveDownloads" · "resumeRecording"
### `com.tuwinsmart.tuwin.presentation.p010ui.download.Ride3ProDownloadResumeModeGate`
L9 · [class] public final Ride3ProDownloadResumeModeGate · `com/tuwinsmart/tuwin/presentation/p010ui/download/Ride3ProDownloadResumeModeGate.java`
注解：

字段/常量（1）：
- `boolean required`  L11

方法（4）：
- `private Ride3ProDownloadResumeModeGate()`  L13
- `void markRequired()`  L16
- `boolean consumeRequired()`  L20
- `void clearForTest()`  L28