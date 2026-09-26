# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.core.util

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 93 个文件 / 161 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.core.util.ActivityStack`
L10 · [class] public ActivityStack · `com/tuwinsmart/tuwin/core/util/ActivityStack.java`

字段/常量（10）：
- `ActivityStack instance`  L11
- `Stack<BaseActivity> stack`  L12
- `Stack<BaseActivity> stack2`  L29
- `Stack<BaseActivity> stack2 = stack`  L37
- `Stack<BaseActivity> stack2 = stack`  L45
- `Stack<BaseActivity> stack2 = stack`  L58
- `Stack<BaseActivity> stack2 = stack`  L73
- `Stack<BaseActivity> stack2 = stack`  L85
- `Stack<BaseActivity> stack2 = stack`  L101
- `Stack<BaseActivity> stack2 = stack`  L117

方法（10）：
- `ActivityStack getInstance()`  L14
- `void pushActivity(BaseActivity baseActivity)`  L21
- `void popActivity(Activity activity)`  L28
- `BaseActivity currentActivity()`  L36
- `void popAllActivityExceptOne(Class cls)`  L44
- `void popAllActivityExceptOne(String str)`  L57
- `void finishAllActivity()`  L72
- `void finishActivity(Class<?> cls)`  L84
- `void finishActivityByName(String str)`  L100
- `boolean hadActivity(Class cls)`  L116
### `com.tuwinsmart.tuwin.core.util.BuildUtilKt`
L10 · [class] public final BuildUtilKt · `com/tuwinsmart/tuwin/core/util/BuildUtilKt.java`
注解：

方法（5）：
- `boolean buildMinVersionT()`  L11
- `boolean buildMinVersionR()`  L15
- `boolean buildMinVersionQ()`  L19
- `boolean buildMinVersionP()`  L23
- `boolean buildVersionP()`  L27
### `com.tuwinsmart.tuwin.core.util.CloudApiNetworkPolicy`
L16 · [class] public final CloudApiNetworkPolicy · `com/tuwinsmart/tuwin/core/util/CloudApiNetworkPolicy.java`
注解：

字段/常量（3）：
- `ArrayList arrayList2 = arrayList`  L40
- `String string`  L53
- `String strRemoveSurrounding`  L54

方法（4）：
- `boolean shouldUseDedicatedCloudNetwork(boolean hasAvailableInternetNetwork)`  L19
- `private CloudApiNetworkPolicy()`  L23
- `boolean isCloudWifiCandidate(String ssid, List<String> cachedDeviceSsids)`  L26
    - 体内字面量："cachedDeviceSsids" · "TUWIN"
- `String normalizeSsid(String ssid)`  L52
### `com.tuwinsmart.tuwin.core.util.CommonUtil`
L50 · [class] public CommonUtil · `com/tuwinsmart/tuwin/core/util/CommonUtil.java`

字段/常量（18）：
- `Map<String, String> map`  L51
- `PopupWindow popupWindow`  L52
- `String xiaoMiDeviceName = "<binary/metadata>"`  L54
- `String str`  L96
- `ReflectiveOperationException e`  L97
- `int i = 0`  L221
- `int i2 = i + 1`  L223
- `FileOutputStream fileOutputStream = null`  L263
- `FileOutputStream fileOutputStream`  L342
- `FileOutputStream fileOutputStream2 = null`  L343
- `Throwable th = e`  L365
- `Throwable th3 = e`  L392
- `PopupWindow popupWindow2 = popupWindow`  L452
- `String str = "<binary/metadata>"`  L505
- `float f`  L518
- `String strSubstring`  L536
- `String strSubstring2`  L537
- `List<String> list`  L565

方法（49）：
- `int dpToPx(int i)`  L64
- `String getVersion(Context context)`  L68
- `String getVersionName(Context context)`  L77
- `String getServerVersion(Context context)`  L86
    - 体内字面量："1.0.0"
- `String getModel()`  L95
- `boolean checkNull(String str)`  L132
    - 体内字面量："null"
- `int getScreenWidth(Context context)`  L136
    - 体内字面量："window"
- `int getScreenHeight(Context context)`  L143
    - 体内字面量："window"
- `String getPrice(double d)`  L150
    - 体内字面量："0"
- `String formatDate(Date date)`  L154
    - 体内字面量："yyyy-MM-dd"
- `String formatFullDate(Date date)`  L158
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
- `String formatDateHourMinSec(Date date)`  L162
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
- `List<String> arrayToList(String str)`  L166
    - 体内字面量：","
- `Map<String, String> getColorMap()`  L173
    - 体内字面量："#ef5350" · "b" · "#EC407A" · "#AB47BC" · "d" · "#7E57C2" · "e" · "#5C6BC0" · "f" · "#42A5F5" · "g" · "#29B6F6" · "#26C6DA" · "#26A69A" · "j" · "#66BB6A" · "k" · "#9CCC65" · "l" · "#25D366" · "m" · "#0077B5" · "n" · "#3aaf85" · "o" · "#FFA726" · "#FF7043" · "q" · "#8D6E63" · "r" · "#BDBDBD" · "#78909C" · "#ff5252" · "#FF4081" · "#E040FB" · "w" · "#7C4DFF" · "x" · "#536DFE" · "y" · "#448AFF" · "#40C4FF" · "#00838F" · "#FBC02D" · "#1abc9c" · "4" · "#2ecc71" · "5" · "#3498db" · "6" · "#F57F17" · "7" · "#9b59b6" · "8" · "#2980b9" · "9" · "#e67e22" · "0" · "#2c3e50"
- `int sp2px(Context context, float f)`  L216
- `String toLowerString(String str)`  L220
- `boolean isNetWorkAvailable(boolean z)`  L232
    - 体内字面量："connectivity"
- `String saveImage(Context context, Bitmap bitmap)`  L241
    - 体内字面量："temp/" · ".png"
- `String saveBitmapToFile(Context context, Bitmap bitmap, int i, boolean z)`  L262
- `File saveBitmapToCacheFolder(Context context, Bitmap bitmap)`  L341
- `String savePhotoToMedia(Context context, File file, String str)`  L429
- `void updatePhotoMedia(File file, Context context)`  L435
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `String getRealPathFromURI(Uri uri, Context context)`  L442
    - 体内字面量："_data" · "_data"
- `void dismissPopupWindow()`  L451
- `int getVersionCode(Context context)`  L458
- `String getPicStringDou(List<String> list)`  L467
    - 体内字面量：","
- `String getDeviceToken(Context context)`  L484
    - 体内字面量："android_id"
- `String getUniquePsuedoID()`  L488
    - 体内字面量："35" · "SERIAL"
- `String subYearMonthDate(String str)`  L496
    - 体内字面量：" "
- `String subYearMonthDateHourMinute(String str)`  L500
- `String getSpace(int i)`  L504
- `void hideSoftInput(Activity activity)`  L513
    - 体内字面量："input_method"
- `String numFormatString(String str)`  L517
- `String numFormatString(Float f)`  L528
    - 体内字面量："0"
- `Map<String, List<String>> getUrlParameters(String str)`  L535
- `String getUrlParameters(String str, String str2)`  L564
- `String oneCharCapital(String str)`  L573
- `String getViewTagStringValue(View view)`  L580
- `int getIntByString(String str)`  L587
- `void setFieldBoolean(Object obj, String str, boolean z)`  L599
- `boolean getFieldBoolean(Object obj, String str, boolean z)`  L612
- `void setFieldInt(Object obj, String str, int i)`  L626
- `int getFieldInt(Object obj, String str)`  L639
- `void showKeyboard(View view)`  L653
    - 体内字面量："input_method"
- `void hideKeyboard(View view)`  L661
    - 体内字面量："input_method"
- `void toggleSoftInput(View view)`  L668
    - 体内字面量："input_method"
- `int getTextPrimaryColor(Context context)`  L675
- `int getTextSecondaryColor(Context context)`  L679
- `void saveBitmap(Bitmap bitmap)`  L683
    - 体内字面量："yyyy_MM_dd_HHmmss" · ".jpg"
### `com.tuwinsmart.tuwin.core.util.CommonUtil$OnCompressSuccessListener`
L56 · [interface] public OnCompressSuccessListener · `com/tuwinsmart/tuwin/core/util/CommonUtil.java`

方法（1）：
- `void onSuccess(File file)`  L57
### `com.tuwinsmart.tuwin.core.util.CommonUtil$OnEnterpriseAdminListener`
L60 · [interface] public OnEnterpriseAdminListener · `com/tuwinsmart/tuwin/core/util/CommonUtil.java`

方法（1）：
- `void isAdmin(boolean z)`  L61
### `com.tuwinsmart.tuwin.core.util.CompatUtilsKt`
L23 · [class] public final CompatUtilsKt · `com/tuwinsmart/tuwin/core/util/CompatUtilsKt.java`
注解：

字段/常量（5）：
- `String strSsidLegacy`  L58
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L69
- `String str2 = str`  L107
- `int i = 0`  L109
- `boolean z = false`  L110

方法（12）：
- `Context createContext(Context context, Locale newLocale)`  L24
    - 体内字面量："<this>" · "newLocale" · "getResources(...)" · "getConfiguration(...)" · "createConfigurationContext(...)"
- `PackageInfo packageInfo(Context context)`  L37
    - 体内字面量："<this>"
- `PackageInfo packageInfoAndroidT(Context context)`  L45
    - 体内字面量："getPackageInfo(...)"
- `PackageInfo packageInfoLegacy(Context context)`  L51
    - 体内字面量："getPackageInfo(...)"
- `String ssid(ScanResult scanResult)`  L57
- `String ssidAndroidT(ScanResult scanResult)`  L68
- `String ssidLegacy(ScanResult scanResult)`  L74
- `String getEMPTY(StringCompanionObject stringCompanionObject)`  L78
    - 体内字面量："<this>"
- `String getSPACE_SEPARATOR(StringCompanionObject stringCompanionObject)`  L83
    - 体内字面量："<this>" · " "
- `String nullToEmpty(StringCompanionObject stringCompanionObject, String str)`  L88
    - 体内字面量："<this>"
- `String toCapitalize(String str, Locale locale)`  L93
    - 体内字面量："<this>" · "locale" · "substring(...)"
- `String specialTrim(String str)`  L105
    - 体内字面量："<this>"
### `com.tuwinsmart.tuwin.core.util.ConnectUtil`
L29 · [class] public final ConnectUtil · `com/tuwinsmart/tuwin/core/util/ConnectUtil.java`
注解：

字段/常量（17）：
- `String TAG = "fingdo"`  L30
- `WifiManager wifiManager`  L31
- `boolean z = false`  L54
- `String strRemoveDoubleQue`  L79
- `WifiManager wifiManager2 = wifiManager`  L80
- `WifiManager wifiManager3 = wifiManager`  L84
- `WifiInfo connectionInfo`  L100
- `WifiManager wifiManager2 = wifiManager`  L101
- `String bssid = null`  L102
- `WifiManager wifiManager3 = wifiManager`  L106
- `String str = currentSSID`  L119
- `String str = strNormalizeSsid`  L133
- `String str2 = str`  L197
- `String string`  L213
- `String strRemoveSurrounding`  L214
- `String string`  L222
- `String strReplace$default`  L223

方法（16）：
- `private ConnectUtil()`  L40
- `void init(Context context)`  L43
    - 体内字面量："context" · "null cannot be cast to non-null type android.net.wifi.WifiManager"
- `boolean isLocationServiceEnabled(Context context)`  L50
    - 体内字面量："context"
- `boolean isWifiEnabled(Context context)`  L71
    - 体内字面量："context"
- `String getCurrentSSID()`  L78
- `String getCurrentBSSID()`  L99
- `boolean isConnectedTUWIN()`  L113
    - 体内字面量："isConnectedTUWIN: "
- `DeviceType inferDeviceTypeFromSsid(String ssid)`  L128
- `boolean isExpectedDeviceWifiSsid$default(ConnectUtil connectUtil, String str, DeviceType deviceType, String str2, int i, Object obj)`  L149
- `boolean isExpectedDeviceWifiSsid(String currentSsid, DeviceType expectedDeviceType, String expectedSsid)`  L156
    - 体内字面量："expectedDeviceType"
- `boolean isExpectedDeviceWifi(String currentSsid, String currentBssid, DeviceType expectedDeviceType, String expectedSsid, String expectedBssid)`  L169
    - 体内字面量："expectedDeviceType"
- `DeviceType resolveDeviceType$default(ConnectUtil connectUtil, String str, boolean z, int i, Object obj)`  L178
- `DeviceType resolveDeviceType(String cachedSsid, boolean allowRuntimeSsidRead)`  L185
- `String removeDoubleQue(String str)`  L196
- `String normalizeSsid(String ssid)`  L212
- `String normalizeBssid(String bssid)`  L221
### `com.tuwinsmart.tuwin.core.util.DateUtil`
L13 · [class] public final DateUtil · `com/tuwinsmart/tuwin/core/util/DateUtil.java`
注解：

方法（4）：
- `private DateUtil()`  L16
- `boolean isToday(Date date)`  L19
    - 体内字面量："date"
- `boolean isYesterday(Date date)`  L27
    - 体内字面量："date"
- `boolean isBeforeYesterday(Date date)`  L36
    - 体内字面量："date"
### `com.tuwinsmart.tuwin.core.util.download.DeviceTransferSpeedTracker`
L14 · [class] public final DeviceTransferSpeedTracker · `com/tuwinsmart/tuwin/core/util/download/DeviceTransferSpeedTracker.java`
注解：

字段/常量（11）：
- `long NANOS_PER_SECOND = 1000000000`  L18 @Deprecated
- `long PREVIOUS_SAMPLE_WEIGHT = 3`  L21 @Deprecated
- `long SAMPLE_INTERVAL_NANOS = 1000000000`  L24 @Deprecated
- `long lastSpeed`  L25
- `Function0<Long> nanoTime`  L26
- `long sampleBytes`  L27
- `long sampleTimeNanos`  L28
- `long j = this.sampleBytes`  L65
- `long j2 = jLongValue - this.sampleTimeNanos`  L72
- `long j3 = jCoerceAtLeast - j`  L76
- `long j4 = this.lastSpeed`  L81

方法（4）：
- `public DeviceTransferSpeedTracker()`  L31
- `public DeviceTransferSpeedTracker(Function0<Long> nanoTime)`  L52
    - 体内字面量："nanoTime"
- ` DeviceTransferSpeedTracker(C21321 c21321, int i, DefaultConstructorMarker defaultConstructorMarker)`  L58
- `long bytesPerSecond(long transferredBytes)`  L62
### `com.tuwinsmart.tuwin.core.util.download.DeviceTransferSpeedTracker$C21321`
L38 · [class] C21321 · extends `FunctionReferenceImpl implements Function0<Long>` · implements `Function0<Long>` · `com/tuwinsmart/tuwin/core/util/download/DeviceTransferSpeedTracker.java`
注解：

方法（1）：
- `Long invoke()`  L47 @Override
### `com.tuwinsmart.tuwin.core.util.download.DeviceTransferSpeedTracker$Companion`
L93 · [class] private static final Companion · `com/tuwinsmart/tuwin/core/util/download/DeviceTransferSpeedTracker.java`
注解：

方法（2）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L94
- `private Companion()`  L98
### `com.tuwinsmart.tuwin.core.util.download.DeviceUrlBuilder`
L28 · [class] public final DeviceUrlBuilder · `com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java`
注解：

字段/常量（4）：
- `String host`  L184
- `DeviceType deviceType`  L218
- `Object obj = null`  L219
- `Object next`  L231

方法（15）：
- `private DeviceUrlBuilder()`  L58
- `String buildM3DownloadUrl(String fileName)`  L61
    - 体内字面量："fileName" · "M3 download"
- `String buildM3ThumbnailUrl(String fileName)`  L66
    - 体内字面量："fileName" · "/" · "M3 thumbnail"
- `String buildRide5ThumbnailUrl(String relativePath)`  L77
    - 体内字面量："relativePath" · "RIDE5 thumbnail"
- `String buildRide3ProThumbnailUrl(int fileIndex)`  L82
    - 体内字面量："RIDE3PRO thumbnail"
- `String buildRide3ProRawDataUrl(int fileIndex)`  L86
    - 体内字面量："RIDE3PRO raw data"
- `String buildRide5DownloadUrl(String relativePath)`  L90
    - 体内字面量："relativePath" · "RIDE5 download"
- `String buildDownloadUrl$default(DeviceUrlBuilder deviceUrlBuilder, DeviceType deviceType, String str, String str2, Integer num, int i, Object obj)`  L95
- `String buildDownloadUrl(DeviceType deviceType, String relativePath, String fileName, Integer fileIndex)`  L105
    - 体内字面量："deviceType" · "relativePath" · "RIDE3PRO download" · "RIDE6 download"
- `String buildThumbnailUrl$default(DeviceUrlBuilder deviceUrlBuilder, DeviceType deviceType, String str, String str2, Integer num, int i, Object obj)`  L139
- `String buildThumbnailUrl(DeviceType deviceType, String relativePath, String fileName, Integer fileIndex)`  L149
    - 体内字面量："deviceType" · "relativePath" · "RIDE3PRO thumbnail" · "RIDE6 thumbnail"
- `String buildAuthorizedHttpUrl(DeviceEndpointAuthority authority, String grantId, String sessionId, long routeRevision, EndpointPurpose purpose, String relativePath)`  L183
- `DeviceType getCurrentDeviceType()`  L217
- `String getConnectedDeviceVersion(DeviceType deviceType)`  L230
- `String unavailable(String kind)`  L252
    - 体内字面量："DeviceUrlBuilder: " · " skipped because EndpointGrant is unavailable"
### `com.tuwinsmart.tuwin.core.util.download.DeviceUrlBuilder$WhenMappings`
L33 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/util/download/DeviceUrlBuilder.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L34
### `com.tuwinsmart.tuwin.core.util.download.DownloadFileCallbacks`
L15 · [class] public final DownloadFileCallbacks · `com/tuwinsmart/tuwin/core/util/download/DownloadFileCallbacks.java`
注解：

字段/常量（6）：
- `Function1<Call, Unit> onCallCreated`  L16
- `Function1<String, Unit> onError`  L17
- `Function1<Progress, Unit> onProgress`  L18
- `Function1<String, Unit> onSuccess`  L19
- `Function1<Progress, Unit> function1 = this.onProgress`  L73
- `Function1<Call, Unit> function2 = this.onCallCreated`  L75

方法（14）：
- `DownloadFileCallbacks copy$default(DownloadFileCallbacks downloadFileCallbacks, Function1 function1, Function1 function2, Function1 function3, Function1 function4, int i, Object obj)`  L22
- `Function1<String, Unit> component1()`  L38
- `Function1<String, Unit> component2()`  L42
- `Function1<Progress, Unit> component3()`  L46
- `Function1<Call, Unit> component4()`  L50
- `DownloadFileCallbacks copy(Function1<? super String, Unit> onSuccess, Function1<? super String, Unit> onError, Function1<? super Progress, Unit> onProgress, Function1<? super Call, Unit> onCallCreated)`  L54
    - 体内字面量："onSuccess" · "onError"
- `boolean equals(Object other)`  L60
- `int hashCode()`  L71
- `String toString()`  L79
    - 体内字面量："DownloadFileCallbacks(onSuccess=" · ", onError=" · ", onProgress=" · ", onCallCreated=" · ")"
- `public DownloadFileCallbacks(Function1<? super String, Unit> onSuccess, Function1<? super String, Unit> onError, Function1<? super Progress, Unit> function1, Function1<? super Call, Unit> function2)`  L84
    - 体内字面量："onSuccess" · "onError"
- `Function1<String, Unit> getOnSuccess()`  L93
- `Function1<String, Unit> getOnError()`  L97
- `Function1<Progress, Unit> getOnProgress()`  L101
- `Function1<Call, Unit> getOnCallCreated()`  L105
### `com.tuwinsmart.tuwin.core.util.download.DownloadFileExecution`
L37 · [class] public final DownloadFileExecution · `com/tuwinsmart/tuwin/core/util/download/DownloadFileExecution.java`
注解：

字段/常量（39）：
- `DownloadFileCallbacks callbacks`  L38
- `OkHttpClient client`  L39
- `File destinationFile`  L40
- `long downloadedBytes`  L41
- `long initialOffset`  L42
- `int lastLoggedMilestone`  L43
- `DownloadFileOptions options`  L44
- `Progress progress`  L45
- `Ride3ProPlaybackDownloadResumePolicy.Decision resumeDecision`  L46
- `String sourceUrl`  L47
- `long startedAtMs`  L48
- `String taskId`  L49
- `Unit unit = Unit.INSTANCE`  L96
- `String strWithOffset`  L116
- `Response response2 = response`  L140
- `DownloadFileExecution downloadFileExecution = DownloadFileExecution.this`  L141
- `int i = completedRetries`  L142
- `long j = offset`  L143
- `Response response3 = response2`  L145
- `Unit unit = Unit.INSTANCE`  L165
- `boolean z = true`  L203
- `InputStream inputStream = input`  L206
- `InputStream inputStream2 = inputStream`  L208
- `File file = this.destinationFile`  L209
- `FileOutputStream fileOutputStream2 = fileOutputStream`  L215
- `byte[] bArr = new byte[8192]`  L216
- `Unit unit = Unit.INSTANCE`  L228
- `Unit unit2 = Unit.INSTANCE`  L230
- `Progress progress = this.progress`  L272
- `int iCoerceIn`  L287
- `long j = read`  L288
- `long j2 = this.downloadedBytes + j`  L289
- `Progress progress = this.progress`  L295
- `Progress progress = this.progress`  L321
- `Progress progress2 = this.progress`  L329
- `Progress progress = this.progress`  L340
- `IOException iOException = error`  L353
- `Progress progress = this.progress`  L355
- `Progress progress = this.progress`  L370

方法（17）：
- `public DownloadFileExecution(String sourceUrl, File destinationFile, OkHttpClient client, Progress progress, DownloadFileCallbacks callbacks, DownloadFileOptions options, Ride3ProPlaybackDownloadResumePolicy.Decision resumeDecision, long j)`  L51
    - 体内字面量："sourceUrl" · "destinationFile" · "client" · "callbacks" · "options" · "resumeDecision" · "download"
- ` DownloadFileExecution(String str, File file, OkHttpClient okHttpClient, Progress progress, DownloadFileCallbacks downloadFileCallbacks, DownloadFileOptions downloadFileOptions, Ride3ProPlaybackDownloadResumePolicy.Decision decision, long j, int i, DefaultConstructorMarker defaultConstructorMarker)`  L70
- `void start()`  L74
    - 体内字面量："initial download offset must not be negative" · "download_task_started" · "task_id" · "source" · "file" · "resume_enabled" · "offset" · "Initial resume offset does not match file length: expected=" · " actual="
- `void executeAttempt(final int completedRetries, final long offset)`  L115
- `void onFailure(Call call, IOException e)`  L130 @Override
    - 体内字面量："call" · "e" · "Download failed: "
- `void onResponse(Call call, Response response)`  L137 @Override
    - 体内字面量："call" · "response"
- `void writeResponseBody(Call call, InputStream input, long responseContentLength, long offset)`  L198
    - 体内字面量："Resume offset changed before write: expected=" · " actual="
- `void handleAttemptFailure(Call call, int completedRetries, String message, IOException error)`  L251
    - 体内字面量："download_retry_scheduled" · "task_id" · "max_retries" · "offset" · "error_type" · "Ride3Pro rawdata resume exhausted retries=" · " offset="
- `void publishLoading(long offset, long totalBytes)`  L270
- `void publishBytesRead(int read, long totalBytes)`  L286
- `void call(Progress progress2)`  L304 @Override
- `void publishBytesRead$lambda$4(DownloadFileExecution this$0, Progress progress)`  L311
    - 体内字面量："this$0"
- `void publishWaitingForRetry(long offset)`  L320
- `void publishPaused()`  L338
    - 体内字面量："download_paused" · "task_id" · "bytes" · "duration_ms"
- `void publishTerminalError(IOException error)`  L352
- `void publishFinished()`  L368
    - 体内字面量："download_completed" · "task_id" · "bytes" · "duration_ms" · "file"
- `String safeSource(String url)`  L392
    - 体内字面量："?"
### `com.tuwinsmart.tuwin.core.util.download.DownloadFileOptions`
L9 · [class] public final DownloadFileOptions · `com/tuwinsmart/tuwin/core/util/download/DownloadFileOptions.java`
注解：

字段/常量（2）：
- `boolean addToMediaStore`  L10
- `boolean postFinishEvent`  L11

方法（10）：
- `DownloadFileOptions copy$default(DownloadFileOptions downloadFileOptions, boolean z, boolean z2, int i, Object obj)`  L13
- `boolean getAddToMediaStore()`  L24
- `boolean getPostFinishEvent()`  L29
- `DownloadFileOptions copy(boolean addToMediaStore, boolean postFinishEvent)`  L33
- `boolean equals(Object other)`  L37
- `int hashCode()`  L48
- `String toString()`  L52
    - 体内字面量："DownloadFileOptions(addToMediaStore=" · ", postFinishEvent=" · ")"
- `public DownloadFileOptions(boolean z, boolean z2)`  L56
- `boolean getAddToMediaStore()`  L61
- `boolean getPostFinishEvent()`  L65
### `com.tuwinsmart.tuwin.core.util.download.DownloadLeaseHandle`
L19 · [class] final DownloadLeaseHandle · `com/tuwinsmart/tuwin/core/util/download/DownloadLeaseHandle.java`
注解：

字段/常量（4）：
- `AtomicReference<Call> call`  L20
- `DisposableHandle cancellation`  L21
- `AtomicBoolean closed`  L22
- `RouteLease lease`  L23

方法（5）：
- `public DownloadLeaseHandle(RouteLease lease)`  L25
    - 体内字面量："lease"
- `Unit invoke(Throwable th)`  L36 @Override
- `void invoke2(Throwable th)`  L42
- `void setCall(Call value)`  L51
    - 体内字面量："value"
- `void close()`  L60
### `com.tuwinsmart.tuwin.core.util.download.DownloadNetworkBindingPolicy`
L9 · [class] public final DownloadNetworkBindingPolicy · `com/tuwinsmart/tuwin/core/util/download/DownloadNetworkBindingPolicy.java`
注解：

方法（2）：
- `private DownloadNetworkBindingPolicy()`  L12
- `boolean isInternetRoute(DownloadNetworkRoute route)`  L15
### `com.tuwinsmart.tuwin.core.util.download.DownloadNetworkRoute`
L17 · [interface] public DownloadNetworkRoute · `com/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute.java`
注解：

方法（1）：
- `NetworkIntent getIntent()`  L18
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute$Internet;" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute;" · "purpose" · "(Ljava/lang/String;)V" · "intent" · "Lcom/tuwinsmart/tuwin/core/network/NetworkIntent;" · "getIntent" · "()Lcom/tuwinsmart/tuwin/core/network/NetworkIntent;" · "getPurpose" · "()Ljava/lang/String;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute$Device;" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute;" · "sessionId" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "endpointGrantId" · "routeRevision" · "purpose" · "Lcom/tuwinsmart/tuwin/core/network/EndpointPurpose;" · "(Ljava/lang/String;Lcom/tuwinsmart/tuwin/domain/model/DeviceType;Ljava/lang/String;JLcom/tuwinsmart/tuwin/core/network/EndpointPurpose;)V" · "getDeviceType" · "()Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "getEndpointGrantId" · "()Ljava/lang/String;" · "intent" · "Lcom/tuwinsmart/tuwin/core/network/NetworkIntent;" · "getIntent" · "()Lcom/tuwinsmart/tuwin/core/network/NetworkIntent;" · "getPurpose" · "()Lcom/tuwinsmart/tuwin/core/network/EndpointPurpose;" · "getRouteRevision" · "()J" · "getSessionId" · "component1" · "component2" · "component3" · "component4" · "component5" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.core.util.download.DownloadNetworkRoute$Device`
L85 · [class] public static final Device · implements `DownloadNetworkRoute` · `com/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute.java`
注解：

字段/常量（9）：
- `DeviceType deviceType`  L86
- `String endpointGrantId`  L87
- `NetworkIntent intent`  L88
- `EndpointPurpose purpose`  L89
- `long routeRevision`  L90
- `String sessionId`  L91
- `DeviceType deviceType2 = deviceType`  L100
- `String str3 = str2`  L104
- `long j2 = j`  L108

方法（18）：
- `Device copy$default(Device device, String str, DeviceType deviceType, String str2, long j, EndpointPurpose endpointPurpose, int i, Object obj)`  L93
- `String getSessionId()`  L116
- `DeviceType getDeviceType()`  L121
- `String getEndpointGrantId()`  L126
- `long getRouteRevision()`  L131
- `EndpointPurpose getPurpose()`  L136
- `Device copy(String sessionId, DeviceType deviceType, String endpointGrantId, long routeRevision, EndpointPurpose purpose)`  L140
    - 体内字面量："sessionId" · "deviceType" · "endpointGrantId" · "purpose"
- `boolean equals(Object other)`  L148
- `int hashCode()`  L159
- `String toString()`  L163
    - 体内字面量："Device(sessionId=" · ", deviceType=" · ", endpointGrantId=" · ", routeRevision=" · ", purpose=" · ")"
- `public Device(String sessionId, DeviceType deviceType, String endpointGrantId, long j, EndpointPurpose purpose)`  L167
    - 体内字面量："sessionId" · "deviceType" · "endpointGrantId" · "purpose" · "Failed requirement." · "Failed requirement." · "Failed requirement."
- `String getSessionId()`  L189
- `DeviceType getDeviceType()`  L193
- `String getEndpointGrantId()`  L197
- `long getRouteRevision()`  L201
- ` Device(String str, DeviceType deviceType, String str2, long j, EndpointPurpose endpointPurpose, int i, DefaultConstructorMarker defaultConstructorMarker)`  L205
- `EndpointPurpose getPurpose()`  L209
- `NetworkIntent getIntent()`  L214 @Override
### `com.tuwinsmart.tuwin.core.util.download.DownloadNetworkRoute$Internet`
L22 · [class] public static final Internet · implements `DownloadNetworkRoute` · `com/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute.java`
注解：

字段/常量（2）：
- `NetworkIntent intent`  L23
- `String purpose`  L24

方法（11）：
- `public Internet()`  L27
- `Internet copy$default(Internet internet, String str, int i, Object obj)`  L31
- `String getPurpose()`  L39
- `Internet copy(String purpose)`  L43
    - 体内字面量："purpose"
- `boolean equals(Object other)`  L48
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："Internet(purpose=" · ")"
- `public Internet(String purpose)`  L63
    - 体内字面量："purpose"
- ` Internet(String str, int i, DefaultConstructorMarker defaultConstructorMarker)`  L69
    - 体内字面量："download"
- `String getPurpose()`  L73
- `NetworkIntent getIntent()`  L78 @Override
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil`
L120 · [class] public final DownloadUtil · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

字段/常量（151）：
- `String BACKGROUND_INTERRUPTION_MESSAGE = "Download interrupted because the app entered background"`  L121
- `long DEVICE_HTTP_TIMEOUT_SECONDS = 5`  L122
- `String RESUME_PART_SUFFIX = ".tuwin.part"`  L123
- `String activeDownloadTag`  L124
- `Object objM3074constructorimpl`  L701
- `DownloadUtil downloadUtil = INSTANCE`  L706
- `Result.Companion companion = Result.INSTANCE`  L708
- `Result.Companion companion2 = Result.INSTANCE`  L712
- `List<String> list = jsonTags`  L736
- `ArrayList arrayList2 = arrayList`  L742
- `DownloadUtil downloadUtil = INSTANCE`  L788
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L795
- `Unit unit = Unit.INSTANCE`  L798
- `String str = strOptString2 != null ? strOptString2 : "<binary/metadata>"`  L812
- `List list`  L863
- `OnPermissionCallback onPermissionCallback2 = onPermissionCallback`  L926
- `OnPermissionCallback onPermissionCallback2 = onPermissionCallback`  L934
- `FileOutputStream fileOutputStream2 = fileOutputStream`  L1009
- `Unit unit = Unit.INSTANCE`  L1012
- `String str = strSubstring`  L1043
- `Object objM3074constructorimpl`  L1062
- `HttpClientProfile httpClientProfile`  L1063
- `Result.Companion companion = Result.INSTANCE`  L1069
- `DownloadUtil downloadUtil = this`  L1070
- `Result.Companion companion2 = Result.INSTANCE`  L1081
- `Long longOrNull`  L1105
- `Response response2 = response`  L1108
- `DownloadLeaseHandle downloadLeaseHandle2 = downloadLeaseHandle`  L1109
- `Function1<Long, Unit> function1 = onResult`  L1110
- `Response response3 = response2`  L1112
- `Unit unit = Unit.INSTANCE`  L1124
- `DownloadUtil downloadUtil`  L1144
- `Object objM3074constructorimpl`  L1145
- `File downloadFile`  L1146
- `HttpClientProfile httpClientProfile`  L1147
- `File file`  L1148
- `File downloadFile2`  L1149
- `String str = fileName`  L1157
- `Result.Companion companion = Result.INSTANCE`  L1171
- `String str2 = fileName`  L1198
- `Function1<Progress, Unit> function1 = onProgress`  L1257
- `Function1<Call, Unit> function1 = onCallCreated`  L1282
- `Result.Companion companion2 = Result.INSTANCE`  L1296
- `Object objM3074constructorimpl`  L1306
- `Object objM3074constructorimpl2`  L1307
- `Object objM3074constructorimpl3`  L1308
- `ResumePolicy.Disabled deviceQueryOffset`  L1309
- `TransferRetryPolicy.Disabled resumeFromCheckpoint`  L1310
- `Progress progress2`  L1311
- `RouteSnapshot route2`  L1312
- `DeviceIdentity identity`  L1313
- `Result.Companion companion = Result.INSTANCE`  L1315
- `DownloadUtil downloadUtil = this`  L1316
- `Result.Companion companion2 = Result.INSTANCE`  L1319
- `Result.Companion companion3 = Result.INSTANCE`  L1333
- `DownloadUtil downloadUtil2 = this`  L1334
- `Result.Companion companion4 = Result.INSTANCE`  L1337
- `Result.Companion companion5 = Result.INSTANCE`  L1352
- `DownloadUtil downloadUtil3 = this`  L1353
- `Result.Companion companion6 = Result.INSTANCE`  L1356
- `AuthorizedTransferSource.Device device2 = device`  L1367
- `ResumePolicy resumePolicy = deviceQueryOffset`  L1374
- `Function1<TransferCheckpoint, Unit> function1`  L1395
- `CoroutineScope coroutineScope = downloadScope`  L1415
- `Object objM3074constructorimpl`  L1579
- `Result.Companion companion = Result.INSTANCE`  L1588
- `DownloadUtil downloadUtil = this`  L1589
- `Result.Companion companion2 = Result.INSTANCE`  L1593
- `List<DownloadFileTask> listSortedWith`  L1615
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L1616
- `DownloadUtil downloadUtil = INSTANCE`  L1627
- `int i2 = 1`  L1639
- `ArrayList arrayList`  L1663
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L1664
- `Set<Function1<List<DownloadFileTask>, Unit>> set = downloadFileTaskListeners`  L1682
- `Set<Function1<List<DownloadFileTask>, Unit>> set = downloadFileTaskListeners`  L1691
- `DownloadFileTask downloadFileTaskRemove`  L1705
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L1707
- `ArrayList arrayList`  L1733
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L1735
- `ArrayList<DownloadFileTask> arrayList3 = arrayList`  L1754
- `DownloadUtil downloadUtil = INSTANCE`  L1764
- `ArrayList arrayList`  L1784
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L1786
- `ArrayList<DownloadFileTask> arrayList3 = arrayList`  L1802
- `DownloadUtil downloadUtil = INSTANCE`  L1814
- `List<DownloadFileTask> list`  L1836
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L1837
- `DownloadUtil downloadUtil = INSTANCE`  L1846
- `List<DownloadFileTask> list`  L1858
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L1860
- `DownloadUtil downloadUtil = INSTANCE`  L1869
- `ArrayList arrayList`  L1891
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L1892
- `ArrayList<DownloadFileTask> arrayList3 = arrayList`  L1912
- `DownloadUtil downloadUtil = INSTANCE`  L1923
- `ArrayList<DownloadFileTask> arrayList`  L1946
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L1951
- `DownloadUtil downloadUtil = INSTANCE`  L1968
- `DownloadTaskCancellationHandles downloadTaskCancellationHandles`  L1995
- `Object objM3074constructorimpl`  L1996
- `Object objM3074constructorimpl2`  L1997
- `Object objM3074constructorimpl3`  L1998
- `Result.Companion companion = Result.INSTANCE`  L2007
- `Result.Companion companion2 = Result.INSTANCE`  L2014
- `Result.Companion companion3 = Result.INSTANCE`  L2022
- `Result.Companion companion4 = Result.INSTANCE`  L2029
- `Result.Companion companion5 = Result.INSTANCE`  L2037
- `Result.Companion companion6 = Result.INSTANCE`  L2044
- `Object objM3074constructorimpl`  L2054
- `Result.Companion companion = Result.INSTANCE`  L2056
- `Result.Companion companion2 = Result.INSTANCE`  L2059
- `boolean z`  L2070
- `Object objM3074constructorimpl`  L2071
- `Result.Companion companion = Result.INSTANCE`  L2082
- `Result.Companion companion2 = Result.INSTANCE`  L2086
- `boolean z`  L2099
- `Object objM3074constructorimpl`  L2100
- `Result.Companion companion = Result.INSTANCE`  L2111
- `Result.Companion companion2 = Result.INSTANCE`  L2114
- `TransferCheckpoint transferCheckpoint`  L2126
- `String partialFilePath`  L2127
- `boolean z`  L2143
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L2144
- `DownloadUtil downloadUtil = DownloadUtil.INSTANCE`  L2194
- `DownloadNetworkRoute downloadNetworkRoute = networkRoute`  L2381
- `RouteLease routeLease = routeLeaseAcquire`  L2388
- `Interceptor.Companion companion = Interceptor.INSTANCE`  L2389
- `boolean z`  L2427
- `Ride3ProDownloadTranscodePolicy ride3ProDownloadTranscodePolicy = Ride3ProDownloadTranscodePolicy.INSTANCE`  L2433
- `DownloadUtil downloadUtil = INSTANCE`  L2616
- `DownloadFileTask downloadFileTask`  L2649
- `Object next`  L2650
- `LinkedHashMap<String, DownloadFileTask> linkedHashMap = downloadFileTasks`  L2651
- `Unit unit = Unit.INSTANCE`  L2670
- `List list`  L2683
- `Set<Function1<List<DownloadFileTask>, Unit>> set = downloadFileTaskListeners`  L2684
- `boolean z`  L2712
- `String str`  L2713
- `Set<String> set`  L2714
- `String str2`  L2715
- `String str3`  L2716
- `Uri uriInsert`  L2717
- `Unit unit`  L2718
- `Set<String> set2 = addedToMediaStoreFiles`  L2725
- `String str4 = "image/png"`  L2745
- `OutputStream outputStream = outputStreamOpenOutputStream`  L2782
- `OutputStream outputStream2 = outputStream`  L2784
- `Unit unit2 = Unit.INSTANCE`  L2791
- `DownloadUtil downloadUtil = this`  L2818
- `Set<String> set = addedToMediaStoreFiles`  L2850

方法（121）：
- `File invoke()`  L136 @Override
    - 体内字面量："TUWIN" · "TUWIN" · "TUWIN"
- `int compare(Object obj, Object obj2)`  L155 @Override
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/util/download/DownloadUtil$DownloadFileTaskPhase;" · "(Ljava/lang/String;I)V" · "DOWNLOADING" · "TRANSCODING" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadUtil$DownloadRestartMode;" · "(Ljava/lang/String;I)V" · "REDOWNLOAD" · "CONTINUE" · "app_release_64"
- `private DownloadUtil()`  L217
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/util/download/DownloadUtil$DownloadTaskCancellationHandles;" · "Lokhttp3/Call;" · "cancelTransfer" · "Lkotlin/Function0;" · "cancelTranscode" · "(Lokhttp3/Call;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V" · "getCall" · "()Lokhttp3/Call;" · "getCancelTranscode" · "()Lkotlin/jvm/functions/Function0;" · "getCancelTransfer" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadUtil$DownloadFileTask;" · "url" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "progress" · "Lcom/lzy/okgo/model/Progress;" · "transcodeOutputFileName" · "firmwareVersion" · "networkRoute" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute;" · "partialFilePath" · "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tuwinsmart/tuwin/domain/model/DeviceType;Lcom/lzy/okgo/model/Progress;Ljava/lang/String;Ljava/lang/String;Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute;Ljava/lang/String;)V" · "Lokhttp3/Call;" · "getCall" · "()Lokhttp3/Call;" · "setCall" · "(Lokhttp3/Call;)V" · "cancelTranscode" · "Lkotlin/Function0;" · "getCancelTranscode" · "()Lkotlin/jvm/functions/Function0;" · "setCancelTranscode" · "(Lkotlin/jvm/functions/Function0;)V" · "cancelTransfer" · "getCancelTransfer" · "setCancelTransfer" · "canceled" · "getCanceled" · "()Z" · "setCanceled" · "(Z)V" · "getDeviceType" · "()Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "getFileName" · "()Ljava/lang/String;" · "getFirmwareVersion" · "setFirmwareVersion" · "(Ljava/lang/String;)V" · "getNetworkRoute" · "()Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute;" · "getPartialFilePath" · "pendingInitialOffset" · "getPendingInitialOffset" · "()J" · "setPendingInitialOffset" · "(J)V" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadUtil$DownloadFileTaskPhase;" · "getPhase" · "()Lcom/tuwinsmart/tuwin/core/util/download/DownloadUtil$DownloadFileTaskPhase;" · "setPhase" · "(Lcom/tuwinsmart/tuwin/core/util/download/DownloadUtil$DownloadFileTaskPhase;)V" · "getProgress" · "()Lcom/lzy/okgo/model/Progress;" · "retainAsFailureAfterCancel" · "getRetainAsFailureAfterCancel" · "setRetainAsFailureAfterCancel" · "getTag" · "getTranscodeOutputFileName" · "transferCheckpoint" · "Lcom/tuwinsmart/tuwin/core/transfer/TransferCheckpoint;" · "getTransferCheckpoint" · "()Lcom/tuwinsmart/tuwin/core/transfer/TransferCheckpoint;" · "setTransferCheckpoint" · "(Lcom/tuwinsmart/tuwin/core/transfer/TransferCheckpoint;)V" · "getUrl" · "component1" · "component2" · "component3" · "component4" · "component5" · "component6" · "component7" · "component8" · "component9" · "copy" · "equals" · "other" · "hashCode" · "isActive" · "markTranscodingProgress" · "processedFrames" · "totalFrames" · "prepareForRetry" · "initialOffset" · "shouldTranscodeAfterDownload" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadUtil$DownloadTaskInput;" · "url" · "transcodeOutputFileName" · "networkRoute" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute;" · "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute;)V" · "getFileName" · "()Ljava/lang/String;" · "getNetworkRoute" · "()Lcom/tuwinsmart/tuwin/core/util/download/DownloadNetworkRoute;" · "getTag" · "getTranscodeOutputFileName" · "getUrl" · "component1" · "component2" · "component3" · "component4" · "component5" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
- `File getRootDir()`  L685
- `void init()`  L689
- `void addTasks$default(DownloadUtil downloadUtil, List list, DeviceType deviceType, DownloadNetworkRoute downloadNetworkRoute, int i, Object obj)`  L693
- `void addTasks(List<String> jsonTags, DeviceType deviceType, DownloadNetworkRoute networkRoute)`  L700
- `int addTasksStrict$default(DownloadUtil downloadUtil, List list, DeviceType deviceType, DownloadNetworkRoute downloadNetworkRoute, int i, Object obj)`  L723
- `int addTasksStrict(List<String> jsonTags, DeviceType deviceType, DownloadNetworkRoute networkRoute)`  L730
    - 体内字面量："jsonTags" · "deviceType" · "download storage permission is required"
- `DownloadTaskInput parseDownloadTaskInput(String jsonTag, DeviceType deviceType, DownloadNetworkRoute networkRoute)`  L750
    - 体内字面量："url" · "download task url is required" · "download task requires an explicit NetworkIntent and EndpointGrant"
- `void enqueueDownloadTask(DownloadTaskInput input, DeviceType deviceType)`  L764
    - 体内字面量："DownloadUtil: Existing file found, deleting for fresh download: " · "DownloadUtil: Failed to delete existing file: " · "DownloadUtil: Failed to delete existing partial file: " · "DownloadUtil: Failed to delete existing transcoded file: "
- `String resolveTargetFileName$app_release_64(DeviceType deviceType, JSONObject json)`  L804
    - 体内字面量："deviceType" · "json" · "filename" · "url"
- `List<File> getAllFile()`  L822
- `int compare(T t, T t2)`  L828 @Override
- `void startDownload()`  L836
- `List<DownloadTask> getAllTask()`  L840
- `List<DownloadTask> getDownloadingTask()`  L844
- `List<DownloadTask> getDownloadedTask()`  L848
- `List getLocalDirFile$default(DownloadUtil downloadUtil, boolean z, boolean z2, int i, Object obj)`  L852
- `List<File> getLocalDirFile(boolean needVideo, boolean needPhoto)`  L862
- `File createLocalMediaFile(String fileName)`  L884
    - 体内字面量："fileName"
- `boolean hasPermission()`  L890
- `String[] getStoragePermissionsForDownload()`  L896
- `boolean requestPermission$default(DownloadUtil downloadUtil, Context context, OnPermissionCallback onPermissionCallback, int i, Object obj)`  L903
- `boolean requestPermission(Context context, final OnPermissionCallback onPermissionCallback)`  L910
- `void onGranted(List<String> permissions, boolean all)`  L925 @Override
- `void onDenied(List<String> permissions, boolean never)`  L933 @Override
- `void showAskPermissionDialog(final Activity context, final OnPermissionCallback callback)`  L945
    - 体内字面量："context"
- `void onClick(View view)`  L949 @Override
- `void showAskPermissionDialog$lambda$13(Activity context, OnPermissionCallback onPermissionCallback, View view)`  L956
    - 体内字面量："$context"
- `void showNeverAskDialog(final Activity context)`  L961
    - 体内字面量："context"
- `void onClick(View view)`  L969 @Override
- `void showNeverAskDialog$lambda$14(Activity context, String[] permissions, View view)`  L976
    - 体内字面量："$context" · "$permissions"
- `File saveBitmapToDir(Bitmap bitmap, String fileName)`  L982
    - 体内字面量："bitmap" · "fileName"
- `File writeBitmapToLocalMediaDir$app_release_64$default(DownloadUtil downloadUtil, Bitmap bitmap, String str, File file, int i, Object obj)`  L993
- `File writeBitmapToLocalMediaDir$app_release_64(Bitmap bitmap, String fileName, File targetDir)`  L1000
    - 体内字面量："bitmap" · "fileName" · "targetDir"
- `boolean isDownloaded(String url)`  L1029
    - 体内字面量："url" · "http"
- `File getDownloadFile(String url)`  L1034
    - 体内字面量："url"
- `String getDownloadName(String url)`  L1039
    - 体内字面量："/" · "substring(...)" · "(\\d{4})(\\d{2})(\\d{2})_(\\d{6})"
- `CharSequence invoke(MatchResult matchResult)`  L1046 @Override
    - 体内字面量："matchResult" · "_" · "_" · "_"
- `void fetchRemoteFileSize(String url, Function1<? super Long, Unit> onResult)`  L1054
    - 体内字面量："url" · "onResult" · "DownloadUtil: fetchRemoteFileSize rejected because NetworkIntent is missing"
- `void fetchRemoteFileSizeRouted(String url, DownloadNetworkRoute networkRoute, final Function1<? super Long, Unit> onResult)`  L1061
- `void onFailure(Call call, IOException e)`  L1096 @Override
    - 体内字面量："call" · "e"
- `void onResponse(Call call, Response response)`  L1104 @Override
- `void downloadFile$default(DownloadUtil downloadUtil, String str, Function1 function1, Function1 function2, String str2, Progress progress, Function1 function3, Function1 function4, Function1 function5, boolean z, boolean z2, String str3, long j, DownloadNetworkRoute downloadNetworkRoute, File file, Function1 function6, TransferCheckpoint transferCheckpoint, File file2, Function1 function7, int i, Object obj)`  L1139
- `void downloadFile(String url, final Function1<? super String, Unit> onSuccess, final Function1<? super String, Unit> onError, String fileName, Progress progress, final Function1<? super Progress, Unit> onProgress, final Function1<? super Call, Unit> onCallCreated, Function1<? super Function0<Unit>, Unit> onCancelHandleCreated, boolean addToMediaStore, boolean postFinishEvent, String ride3ProFirmwareVersion, long initialOffset, DownloadNetworkRoute networkRoute, File destination, Function1<? super String, Unit> onCancelled, TransferCheckpoint transferCheckpoint, File transferPartialFile, Function1<? super TransferCheckpoint, Unit> onTransferCheckpoint)`  L1143
- `void invoke2(String filePath)`  L1217
    - 体内字面量："filePath"
- `Unit invoke(String str3)`  L1224 @Override
- `void invoke2(String errorMessage)`  L1236
    - 体内字面量："errorMessage"
- `Unit invoke(String str3)`  L1243 @Override
- `void invoke2(Progress state)`  L1255
    - 体内字面量："state"
- `Unit invoke(Progress progress2)`  L1267 @Override
- `void invoke2(Call call)`  L1279
    - 体内字面量："call"
- `Unit invoke(Call call)`  L1289 @Override
- `void startRoutedDeviceDownload(String url, final DownloadNetworkRoute.Device route, File destinationFile, Progress progress, Function1<? super Progress, Unit> onProgress, Function1<? super String, Unit> onSuccess, Function1<? super String, Unit> onError, Function1<? super String, Unit> onCancelled, Function1<? super Function0<Unit>, Unit> onCancelHandleCreated, boolean addToMediaStore, boolean postFinishEvent, TransferCheckpoint transferCheckpoint, File transferPartialFile, final Function1<? super TransferCheckpoint, Unit> onTransferCheckpoint)`  L1305
- `Unit invoke(TransferCheckpoint transferCheckpoint2)`  L1388 @Override
- `void invoke2(TransferCheckpoint checkpoint)`  L1394
- `Unit invoke()`  L1430 @Override
- `void invoke2()`  L1436
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.core.util.download.DownloadUtil$startRoutedDeviceDownload$2" · "DownloadUtil.kt" · "invokeSuspend"
- `String resolveRide3ProFirmwareVersion(String url)`  L1566
- `String resolveRouteFirmwareVersion(DownloadNetworkRoute networkRoute)`  L1578
- `void logRide3ProResumeDecision(Ride3ProPlaybackDownloadResumePolicy.Decision decision)`  L1599
    - 体内字面量："Ride3Pro rawdata resume enabled firmware=" · " max_retries=5" · "Ride3Pro rawdata resume disabled reason=legacy_firmware firmware=" · " minimum=v1.20260708.101448" · "toLowerCase(...)" · "Ride3Pro rawdata resume disabled reason=" · " firmware="
- `List<DownloadFileTask> getDownloadFileTasks()`  L1614
- `int downloadTaskStatusComparator$lambda$32(DownloadFileTask downloadFileTask, DownloadFileTask downloadFileTask2)`  L1626
- `int statusPriority(DownloadFileTask downloadFileTask)`  L1634
- `List getActiveDownloadFileTasks$default(DownloadUtil downloadUtil, DeviceType deviceType, int i, Object obj)`  L1655
- `List<DownloadFileTask> getActiveDownloadFileTasks(DeviceType deviceType)`  L1662
- `void addDownloadFileTaskListener(Function1<? super List<DownloadFileTask>, Unit> listener)`  L1680
    - 体内字面量："listener"
- `void removeDownloadFileTaskListener(Function1<? super List<DownloadFileTask>, Unit> listener)`  L1689
    - 体内字面量："listener"
- `void cancelDownloadFileTask$default(DownloadUtil downloadUtil, String str, boolean z, int i, Object obj)`  L1697
- `void cancelDownloadFileTask(String tag, boolean deleteFile)`  L1704
- `void cancelDownloadFileTasks$default(DownloadUtil downloadUtil, DeviceType deviceType, boolean z, int i, Object obj)`  L1725
- `void cancelDownloadFileTasks(DeviceType deviceType, boolean deleteIncompleteFiles)`  L1732
- `void failActiveDownloadFileTasks$default(DownloadUtil downloadUtil, DeviceType deviceType, boolean z, int i, Object obj)`  L1776
- `void failActiveDownloadFileTasks(DeviceType deviceType, boolean deleteIncompleteFiles)`  L1783
- `void cancelAllDownloadFileTasks$default(DownloadUtil downloadUtil, boolean z, int i, Object obj)`  L1828
- `void cancelAllDownloadFileTasks(boolean deleteFile)`  L1835
- `void cancelAllDownloadFileTasks(Function1<? super DownloadFileTask, Boolean> deleteFilePredicate)`  L1857
- `void cancelActiveDownloadFileTasks$default(DownloadUtil downloadUtil, DeviceType deviceType, boolean z, int i, Object obj)`  L1880
- `void cancelActiveDownloadFileTasks(DeviceType deviceType, boolean deleteFile)`  L1890
- `void redownloadFileTask(String tag)`  L1935
    - 体内字面量："tag"
- `void resumeDownloadFileTasks(Collection<String> tags)`  L1940
    - 体内字面量："tags"
- `void restartDownloadFileTasks(Collection<String> tags, DownloadRestartMode mode)`  L1945
- `void cancelTaskExecution(DownloadFileTask task, String reason)`  L1994
- `void cancelTaskHandle(DownloadFileTask task, String reason, String handleType, Function0<Unit> cancel)`  L2053
- `boolean registerTaskCall(DownloadFileTask task, Call call)`  L2069
- `boolean registerTaskTransferCancellation(DownloadFileTask task, Function0<Unit> cancelTransfer)`  L2098
- `long resolveContinueOffset(DownloadFileTask task)`  L2125
- `void startDownloadFileTask(final DownloadFileTask task)`  L2142
- `Unit invoke(String str)`  L2161 @Override
- `void invoke2(String filePath)`  L2167
    - 体内字面量："filePath" · "DownloadUtil: Download success: "
- `Unit invoke(String str)`  L2184 @Override
- `void invoke2(String errorMessage)`  L2190
    - 体内字面量："errorMessage" · "DownloadUtil: Download failed: "
- `Unit invoke(Progress progress2)`  L2209 @Override
- `void invoke2(Progress it)`  L2215
    - 体内字面量："it"
- `Unit invoke(Call call)`  L2232 @Override
- `void invoke2(Call call)`  L2238
    - 体内字面量："call"
- `Unit invoke(Function0<? extends Unit> function0)`  L2252 @Override
- `void invoke2(Function0<Unit> cancel)`  L2258
    - 体内字面量："cancel"
- `Unit invoke(TransferCheckpoint transferCheckpoint2)`  L2278 @Override
- `void invoke2(TransferCheckpoint checkpoint)`  L2284
    - 体内字面量："checkpoint" · "Lcom/tuwinsmart/tuwin/core/util/download/DownloadUtil$ScopedDownloadClient;" · "lease" · "Lcom/tuwinsmart/tuwin/core/network/RouteLease;" · "client" · "Lokhttp3/OkHttpClient;" · "(Lcom/tuwinsmart/tuwin/core/network/RouteLease;Lokhttp3/OkHttpClient;)V" · "getClient" · "()Lokhttp3/OkHttpClient;" · "getLease" · "()Lcom/tuwinsmart/tuwin/core/network/RouteLease;" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
- `ScopedDownloadClient createScopedDownloadClient(String url, final DownloadNetworkRoute networkRoute, HttpClientProfile profile, final String clientName)`  L2359
- `Unit invoke(OkHttpClient.Builder builder)`  L2372 @Override
- `void invoke2(OkHttpClient.Builder client)`  L2378
    - 体内字面量："$this$client"
- `Response intercept(Interceptor.Chain chain)`  L2392 @Override
    - 体内字面量："chain" · "Invalid internet download URL" · "http" · "https" · "Internet download URL must use http or https" · "Internet download URL must not contain credentials" · "Download route revision changed before request creation"
- `void startTranscodeDownloadFileTask(DownloadFileTask task, File inputFile)`  L2426
- `Unit invoke()`  L2450 @Override
- `void invoke2()`  L2456
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.core.util.download.DownloadUtil$startTranscodeDownloadFileTask$1" · "DownloadUtil.kt" · "invokeSuspend"
- `void completeDownloadFileTask(DownloadFileTask task)`  L2581
- `void markTaskFailedAfterCancel(DownloadFileTask task)`  L2590
- `void deleteTaskFiles(DownloadFileTask task, String reason)`  L2597
- `void deleteTaskOutputFile(DownloadFileTask task, String reason)`  L2628
    - 体内字面量："DownloadUtil: Failed to delete transcoded file on " · ": "
- `void deleteRawInputAfterTranscode(File inputFile, File readyFile)`  L2640
    - 体内字面量："DownloadUtil: Failed to delete Ride3Pro raw input after transcode: "
- `void scheduleNextDownloadFileTask()`  L2648
- `void notifyDownloadFileTaskChanged()`  L2682
- `void run()`  L2694 @Override
- `void notifyDownloadFileTaskChanged$lambda$85(List listeners, List tasks)`  L2701
    - 体内字面量："$listeners" · "$tasks"
- `void addFileToMediaStore(File file)`  L2711
- `void onScanCompleted(String str5, Uri uri)`  L2838 @Override
    - 体内字面量："DownloadUtil: Error adding file to MediaStore: "
- `void addFileToMediaStore$lambda$91(String str, String str2, Uri uri)`  L2849
- `File resumePartialFile(File destination)`  L2856
    - 体内字面量："."
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$C21492`
L1448 · [class] static final C21492 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

字段/常量（19）：
- `boolean $addToMediaStore`  L1449
- `Function1<String, Unit> $onCancelled`  L1450
- `Function1<String, Unit> $onError`  L1451
- `Function1<Progress, Unit> $onProgress`  L1452
- `Function1<String, Unit> $onSuccess`  L1453
- `boolean $postFinishEvent`  L1454
- `DeviceTransferQueue $queue`  L1455
- `Deferred<TransferResult> $result`  L1456
- `DownloadNetworkRoute.Device $route`  L1457
- `Progress $state`  L1458
- `Job $stateJob`  L1459
- `TransferId $transferId`  L1460
- `int label`  L1461
- `int i = this.label`  L1494
- `Function1<Progress, Unit> function1 = this.$onProgress`  L1526
- `Function1<String, Unit> function2 = this.$onSuccess`  L1530
- `Function1<Progress, Unit> function3 = this.$onProgress`  L1539
- `Function1<String, Unit> function4 = this.$onError`  L1543
- `Function1<Progress, Unit> function5 = this.$onProgress`  L1554

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1482 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1487 @Override
- `Object invokeSuspend(Object obj)`  L1492 @Override
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$C21511`
L2476 · [class] static final C21511 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

字段/常量（15）：
- `File $inputFile`  L2477
- `File $outputFile`  L2478
- `DownloadFileTask $task`  L2479
- `Ride3ProLocalVideoTranscoder $transcoder`  L2480
- `int label`  L2481
- `Object objM2922transcodeyxL6bBk`  L2504
- `int i = this.label`  L2506
- `Ride3ProLocalVideoTranscoder ride3ProLocalVideoTranscoder = this.$transcoder`  L2509
- `File file = this.$inputFile`  L2510
- `File file2 = this.$outputFile`  L2511
- `DownloadFileTask downloadFileTask = this.$task`  L2512
- `File file3 = this.$inputFile`  L2544
- `DownloadFileTask downloadFileTask2 = this.$task`  L2545
- `DownloadFileTask downloadFileTask3 = this.$task`  L2561
- `DownloadUtil downloadUtil = DownloadUtil.INSTANCE`  L2570

方法（5）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L2493 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L2498 @Override
- `Object invokeSuspend(Object obj)`  L2503 @Override
- `Unit invoke(Integer num, Integer num2)`  L2520 @Override
- `void invoke(int i2, int i3)`  L2525
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$DownloadFileTask`
L303 · [class] public static final DownloadFileTask · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

字段/常量（21）：
- `Call call`  L304
- `Function0<Unit> cancelTranscode`  L305
- `Function0<Unit> cancelTransfer`  L306
- `boolean canceled`  L307
- `DeviceType deviceType`  L308
- `String fileName`  L309
- `String firmwareVersion`  L310
- `DownloadNetworkRoute networkRoute`  L311
- `String partialFilePath`  L312
- `long pendingInitialOffset`  L313
- `DownloadFileTaskPhase phase`  L314
- `Progress progress`  L315
- `boolean retainAsFailureAfterCancel`  L316
- `String tag`  L317
- `String transcodeOutputFileName`  L318
- `TransferCheckpoint transferCheckpoint`  L319
- `String url`  L320
- `String str = this.transcodeOutputFileName`  L389
- `DownloadNetworkRoute downloadNetworkRoute = this.networkRoute`  L391
- `String str2 = this.partialFilePath`  L393
- `Progress progress = this.progress`  L560

方法（45）：
- `String getTag()`  L323
- `String getUrl()`  L328
- `String getFileName()`  L333
- `DeviceType getDeviceType()`  L338
- `Progress getProgress()`  L343
- `String getTranscodeOutputFileName()`  L348
- `String getFirmwareVersion()`  L353
- `DownloadNetworkRoute getNetworkRoute()`  L358
- `String getPartialFilePath()`  L363
- `DownloadFileTask copy(String tag, String url, String fileName, DeviceType deviceType, Progress progress, String transcodeOutputFileName, String firmwareVersion, DownloadNetworkRoute networkRoute, String partialFilePath)`  L367
    - 体内字面量："tag" · "url" · "fileName" · "deviceType" · "progress"
- `boolean equals(Object other)`  L376
- `int hashCode()`  L387
- `String toString()`  L397
    - 体内字面量："DownloadFileTask(tag=" · ", url=" · ", fileName=" · ", deviceType=" · ", progress=" · ", transcodeOutputFileName=" · ", firmwareVersion=" · ", networkRoute=" · ", partialFilePath=" · ")"
- `public DownloadFileTask(String tag, String url, String fileName, DeviceType deviceType, Progress progress, String str, String str2, DownloadNetworkRoute downloadNetworkRoute, String str3)`  L401
    - 体内字面量："tag" · "url" · "fileName" · "deviceType" · "progress"
- `String getTag()`  L419
- `String getUrl()`  L423
- `String getFileName()`  L427
- `DeviceType getDeviceType()`  L431
- ` DownloadFileTask(String str, String str2, String str3, DeviceType deviceType, Progress progress, String str4, String str5, DownloadNetworkRoute downloadNetworkRoute, String str6, int i, DefaultConstructorMarker defaultConstructorMarker)`  L435
- `Progress getProgress()`  L439
- `String getTranscodeOutputFileName()`  L443
- `String getFirmwareVersion()`  L447
- `void setFirmwareVersion(String str)`  L451
- `DownloadNetworkRoute getNetworkRoute()`  L455
- `String getPartialFilePath()`  L459
- `Call getCall()`  L463
- `void setCall(Call call)`  L467
- `boolean getCanceled()`  L471
- `void setCanceled(boolean z)`  L475
- `DownloadFileTaskPhase getPhase()`  L479
- `void setPhase(DownloadFileTaskPhase downloadFileTaskPhase)`  L483
    - 体内字面量："<set-?>"
- `Function0<Unit> getCancelTranscode()`  L488
- `void setCancelTranscode(Function0<Unit> function0)`  L492
- `Function0<Unit> getCancelTransfer()`  L496
- `void setCancelTransfer(Function0<Unit> function0)`  L500
- `boolean getRetainAsFailureAfterCancel()`  L504
- `void setRetainAsFailureAfterCancel(boolean z)`  L508
- `long getPendingInitialOffset()`  L512
- `void setPendingInitialOffset(long j)`  L516
- `TransferCheckpoint getTransferCheckpoint()`  L520
- `void setTransferCheckpoint(TransferCheckpoint transferCheckpoint)`  L524
- `boolean shouldTranscodeAfterDownload()`  L528
- `void markTranscodingProgress(int processedFrames, int totalFrames)`  L532
- `boolean isActive()`  L543
- `void prepareForRetry(long initialOffset)`  L547
    - 体内字面量："retry offset must not be negative"
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$DownloadFileTaskPhase`
L162 · [enum] public DownloadFileTaskPhase · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

枚举常量（2）：
- `DOWNLOADING()`  L163
- `TRANSCODING()`  L164

方法（1）：
- `EnumEntries<DownloadFileTaskPhase> getEntries()`  L168
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$DownloadRestartMode`
L175 · [enum] private DownloadRestartMode · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

枚举常量（2）：
- `REDOWNLOAD()`  L176
- `CONTINUE()`  L177

方法（1）：
- `EnumEntries<DownloadRestartMode> getEntries()`  L181
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$DownloadTaskCancellationHandles`
L222 · [class] private static final DownloadTaskCancellationHandles · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

字段/常量（6）：
- `Call call`  L223
- `Function0<Unit> cancelTranscode`  L224
- `Function0<Unit> cancelTransfer`  L225
- `Call call = this.call`  L270
- `Function0<Unit> function0 = this.cancelTransfer`  L272
- `Function0<Unit> function1 = this.cancelTranscode`  L274

方法（12）：
- `DownloadTaskCancellationHandles copy$default(DownloadTaskCancellationHandles downloadTaskCancellationHandles, Call call, Function0 function0, Function0 function1, int i, Object obj)`  L228
- `Call getCall()`  L242
- `Function0<Unit> component2()`  L246
- `Function0<Unit> component3()`  L250
- `DownloadTaskCancellationHandles copy(Call call, Function0<Unit> cancelTransfer, Function0<Unit> cancelTranscode)`  L254
- `boolean equals(Object other)`  L258
- `int hashCode()`  L269
- `String toString()`  L278
    - 体内字面量："DownloadTaskCancellationHandles(call=" · ", cancelTransfer=" · ", cancelTranscode=" · ")"
- `public DownloadTaskCancellationHandles(Call call, Function0<Unit> function0, Function0<Unit> function1)`  L282
- `Call getCall()`  L288
- `Function0<Unit> getCancelTransfer()`  L292
- `Function0<Unit> getCancelTranscode()`  L296
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$DownloadTaskInput`
L569 · [class] private static final DownloadTaskInput · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

字段/常量（10）：
- `String fileName`  L570
- `DownloadNetworkRoute networkRoute`  L571
- `String tag`  L572
- `String transcodeOutputFileName`  L573
- `String url`  L574
- `String str5 = str2`  L583
- `String str6 = str3`  L587
- `String str7 = str4`  L591
- `String str = this.transcodeOutputFileName`  L643
- `DownloadNetworkRoute downloadNetworkRoute = this.networkRoute`  L645

方法（16）：
- `DownloadTaskInput copy$default(DownloadTaskInput downloadTaskInput, String str, String str2, String str3, String str4, DownloadNetworkRoute downloadNetworkRoute, int i, Object obj)`  L576
- `String getTag()`  L599
- `String getUrl()`  L604
- `String getFileName()`  L609
- `String getTranscodeOutputFileName()`  L614
- `DownloadNetworkRoute getNetworkRoute()`  L619
- `DownloadTaskInput copy(String tag, String url, String fileName, String transcodeOutputFileName, DownloadNetworkRoute networkRoute)`  L623
    - 体内字面量："tag" · "url" · "fileName"
- `boolean equals(Object other)`  L630
- `int hashCode()`  L641
- `String toString()`  L649
    - 体内字面量："DownloadTaskInput(tag=" · ", url=" · ", fileName=" · ", transcodeOutputFileName=" · ", networkRoute=" · ")"
- `public DownloadTaskInput(String tag, String url, String fileName, String str, DownloadNetworkRoute downloadNetworkRoute)`  L653
    - 体内字面量："tag" · "url" · "fileName"
- `String getTag()`  L664
- `String getUrl()`  L668
- `String getFileName()`  L672
- `String getTranscodeOutputFileName()`  L676
- `DownloadNetworkRoute getNetworkRoute()`  L680
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$ScopedDownloadClient`
L2294 · [class] private static final ScopedDownloadClient · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

字段/常量（2）：
- `OkHttpClient client`  L2295
- `RouteLease lease`  L2296

方法（10）：
- `ScopedDownloadClient copy$default(ScopedDownloadClient scopedDownloadClient, RouteLease routeLease, OkHttpClient okHttpClient, int i, Object obj)`  L2298
- `RouteLease getLease()`  L2309
- `OkHttpClient getClient()`  L2314
- `ScopedDownloadClient copy(RouteLease lease, OkHttpClient client)`  L2318
    - 体内字面量："lease" · "client"
- `boolean equals(Object other)`  L2324
- `int hashCode()`  L2335
- `String toString()`  L2339
    - 体内字面量："ScopedDownloadClient(lease=" · ", client=" · ")"
- `public ScopedDownloadClient(RouteLease lease, OkHttpClient client)`  L2343
    - 体内字面量："lease" · "client"
- `RouteLease getLease()`  L2350
- `OkHttpClient getClient()`  L2354
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$startRoutedDeviceDownload$stateJob$1`
L26 · [class] final DownloadUtil$startRoutedDeviceDownload$stateJob$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil$startRoutedDeviceDownload$stateJob$1.java`
注解：

字段/常量（15）：
- `Function1<Progress, Unit> $onProgress`  L27
- `DeviceTransferQueue $queue`  L28
- `DownloadNetworkRoute.Device $route`  L29
- `DeviceTransferSpeedTracker $speedTracker`  L30
- `Progress $state`  L31
- `TransferId $transferId`  L32
- `int label`  L33
- `int i = this.label`  L60
- `Progress progress = this.$state`  L64
- `DeviceTransferSpeedTracker deviceTransferSpeedTracker = this.$speedTracker`  L65
- `Function1<Progress, Unit> function1 = this.$onProgress`  L66
- `Progress progress2 = progress`  L79
- `Progress progress3 = progress`  L82
- `Progress progress4 = progress`  L84
- `Function1<Progress, Unit> function2 = function1`  L86

方法（5）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L48 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L53 @Override
- `Object invokeSuspend(Object obj)`  L58 @Override
- `Object emit(Object obj2, Continuation continuation)`  L70 @Override
- `Object emit(TransferState transferState, Continuation<? super Unit> continuation)`  L74
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$WhenMappings`
L188 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/util/download/DownloadUtil.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L189
### `com.tuwinsmart.tuwin.core.util.download.DownloadUtilKt`
L12 · [class] public final DownloadUtilKt · `com/tuwinsmart/tuwin/core/util/download/DownloadUtilKt.java`
注解：

方法（1）：
- `void dispatchDownloadCancellation(String reason, Function1<? super String, Unit> function1, Function1<? super String, Unit> onError)`  L13
    - 体内字面量："reason" · "onError"
### `com.tuwinsmart.tuwin.core.util.download.Ride3ProDownloadTranscodePolicy`
L14 · [class] public final Ride3ProDownloadTranscodePolicy · `com/tuwinsmart/tuwin/core/util/download/Ride3ProDownloadTranscodePolicy.java`
注解：

方法（3）：
- `private Ride3ProDownloadTranscodePolicy()`  L17
- `boolean shouldTranscode(DeviceType deviceType, String fileName)`  L20
    - 体内字面量："deviceType" · "fileName" · ".avi" · ".mov"
- `String resolveOutputFileName(String inputFileName)`  L29
    - 体内字面量："inputFileName" · "/" · "." · ".MP4"
### `com.tuwinsmart.tuwin.core.util.download.Ride3ProPlaybackDownloadResumePolicy`
L21 · [class] public final Ride3ProPlaybackDownloadResumePolicy · `com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java`
注解：

字段/常量（7）：
- `Ride3ProPlaybackDownloadResumePolicy INSTANCE`  L22
- `int MAX_RETRY_COUNT = 5`  L23
- `String MINIMUM_FIRMWARE_VERSION = "v1.20260708.101448"`  L24
- `String RAW_DATA_PATH = "/api/playback/rawdata"`  L25
- `List<Long> minimumVersion`  L26
- `Regex versionPattern`  L27
- `String string`  L204

方法（8）：
- `private Ride3ProPlaybackDownloadResumePolicy()`  L45
    - 体内字面量："^[vV]?(\\d+)\\.(\\d{8})\\.(\\d+)$" · "Required value was null." · "Lcom/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy$Decision;" · "enabled" · "reason" · "Lcom/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy$Reason;" · "firmwareVersion" · "(ZLcom/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy$Reason;Ljava/lang/String;)V" · "getEnabled" · "()Z" · "getFirmwareVersion" · "()Ljava/lang/String;" · "getReason" · "()Lcom/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy$Reason;" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy$RetryPlan;" · "retryCount" · "offset" · "(IJ)V" · "getOffset" · "()J" · "getRetryCount" · "()I" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
- `Decision evaluate(String url, String firmwareVersion)`  L203
- `boolean isRawDataUrl(String url)`  L227
    - 体内字面量："url" · "/api/playback/rawdata"
- `String withOffset(String url, long offset)`  L233
    - 体内字面量："url" · "resume offset must not be negative" · "offset"
- `RetryPlan nextRetry(int completedRetries, long offset)`  L241
    - 体内字面量："completed retry count must not be negative" · "resume offset must not be negative"
- `long totalBytes(long offset, long responseContentLength)`  L254
    - 体内字面量："resume offset must not be negative"
- `List<Long> parseVersion(String version)`  L264
- `int compareVersions(List<Long> left, List<Long> right)`  L282
### `com.tuwinsmart.tuwin.core.util.download.Ride3ProPlaybackDownloadResumePolicy$Decision`
L61 · [class] public static final Decision · `com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java`
注解：

字段/常量（4）：
- `boolean enabled`  L62
- `String firmwareVersion`  L63
- `Reason reason`  L64
- `String str = this.firmwareVersion`  L112

方法（12）：
- `Decision copy$default(Decision decision, boolean z, Reason reason, String str, int i, Object obj)`  L66
- `boolean getEnabled()`  L80
- `Reason getReason()`  L85
- `String getFirmwareVersion()`  L90
- `Decision copy(boolean enabled, Reason reason, String firmwareVersion)`  L94
    - 体内字面量："reason"
- `boolean equals(Object other)`  L99
- `int hashCode()`  L110
- `String toString()`  L116
    - 体内字面量："Decision(enabled=" · ", reason=" · ", firmwareVersion=" · ")"
- `public Decision(boolean z, Reason reason, String str)`  L120
    - 体内字面量："reason"
- `boolean getEnabled()`  L127
- `Reason getReason()`  L131
- `String getFirmwareVersion()`  L135
### `com.tuwinsmart.tuwin.core.util.download.Ride3ProPlaybackDownloadResumePolicy$Reason`
L31 · [enum] public Reason · `com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java`
注解：

枚举常量（5）：
- `SUPPORTED()`  L32
- `NOT_RAW_DATA()`  L33
- `VERSION_UNAVAILABLE()`  L34
- `VERSION_INVALID()`  L35
- `LEGACY_FIRMWARE()`  L36

方法（1）：
- `EnumEntries<Reason> getEntries()`  L40
### `com.tuwinsmart.tuwin.core.util.download.Ride3ProPlaybackDownloadResumePolicy$RetryPlan`
L142 · [class] public static final RetryPlan · `com/tuwinsmart/tuwin/core/util/download/Ride3ProPlaybackDownloadResumePolicy.java`
注解：

字段/常量（2）：
- `long offset`  L143
- `int retryCount`  L144

方法（10）：
- `RetryPlan copy$default(RetryPlan retryPlan, int i, long j, int i2, Object obj)`  L146
- `int getRetryCount()`  L157
- `long getOffset()`  L162
- `RetryPlan copy(int retryCount, long offset)`  L166
- `boolean equals(Object other)`  L170
- `int hashCode()`  L181
- `String toString()`  L185
    - 体内字面量："RetryPlan(retryCount=" · ", offset=" · ")"
- `public RetryPlan(int i, long j)`  L189
- `int getRetryCount()`  L194
- `long getOffset()`  L198
### `com.tuwinsmart.tuwin.core.util.FirmwareOtaAppLifecyclePolicy`
L10 · [class] public final FirmwareOtaAppLifecyclePolicy · `com/tuwinsmart/tuwin/core/util/FirmwareOtaAppLifecyclePolicy.java`
注解：

方法（6）：
- `private FirmwareOtaAppLifecyclePolicy()`  L16
- `boolean requestStartupCheck()`  L19
- `boolean hasPendingStartupCheck()`  L23
- `boolean completeStartupCheck()`  L27
- `boolean tryConsumeDownloadPrompt()`  L31
- `void resetForTests()`  L35
### `com.tuwinsmart.tuwin.core.util.FirmwareUpgradeReconnectGate`
L12 · [class] public final FirmwareUpgradeReconnectGate · `com/tuwinsmart/tuwin/core/util/FirmwareUpgradeReconnectGate.java`
注解：

字段/常量（5）：
- `boolean pending`  L14
- `String pendingSsid`  L15
- `String str = pendingSsid`  L33
- `String string`  L52
- `String strRemoveSurrounding`  L53

方法（7）：
- `private FirmwareUpgradeReconnectGate()`  L17
- `void markPending(String ssid)`  L20
- `boolean isPending()`  L25
- `boolean matches(String ssid)`  L29
- `boolean completeIfMatches(String ssid)`  L37
- `void reset$app_release_64()`  L46
- `String normalizeSsid(String ssid)`  L51
### `com.tuwinsmart.tuwin.core.util.gesture.VideoScaleHelper`
L26 · [class] public final VideoScaleHelper · `com/tuwinsmart/tuwin/core/util/gesture/VideoScaleHelper.java`
注解：

字段/常量（67）：
- `AccelerateInterpolator mAccelerateInterpolator`  L27
- `View mContainerView`  L28
- `DecelerateInterpolator mDecelerateInterpolator`  L29
- `GestureDetector mGestureDetector`  L30
- `int mLastCenterX`  L31
- `int mLastCenterY`  L32
- `int mMaximumVelocity`  L33
- `int mMinimumVelocity`  L34
- `OverScroller mOverScroller`  L35
- `ScaleGestureDetector mScaleDetector`  L36
- `ScaleHelper mScaleHelper`  L37
- `boolean mScrollBegin`  L38
- `ZoomLayout.ZoomLayoutGestureListener mZoomLayoutGestureListener`  L39
- `float mDoubleClickZoom = 2.0f`  L40
- `float mMinZoom = 1.0f`  L41
- `float mMaxZoom = 3.0f`  L42
- `float mCurrentZoom = 1.0f`  L43
- `ZoomLayout.ZoomLayoutGestureListener zoomLayoutGestureListener = this.this$0.mZoomLayoutGestureListener`  L67
- `OverScroller overScroller`  L78
- `OverScroller overScroller2 = this.this$0.mOverScroller`  L80
- `float f = 1.0f`  L90
- `ZoomLayout.ZoomLayoutGestureListener zoomLayoutGestureListener = this.this$0.mZoomLayoutGestureListener`  L95
- `ZoomLayout.ZoomLayoutGestureListener zoomLayoutGestureListener = this.this$0.mZoomLayoutGestureListener`  L108
- `VideoScaleHelper videoScaleHelper = this.this$0`  L113
- `float f = this.mCurrentZoom`  L142
- `View view = this.mContainerView`  L144
- `View view2 = null`  L145
- `View view3 = this.mContainerView`  L151
- `View view4 = this.mContainerView`  L160
- `View view5 = this.mContainerView`  L165
- `View view6 = this.mContainerView`  L171
- `View view7 = this.mContainerView`  L178
- `View view8 = this.mContainerView`  L184
- `View view9 = this.mContainerView`  L190
- `View view10 = this.mContainerView`  L198
- `View view11 = this.mContainerView`  L203
- `View view12 = this.mContainerView`  L209
- `View view13 = this.mContainerView`  L216
- `View view14 = this.mContainerView`  L222
- `View view15 = this.mContainerView`  L228
- `View view16 = this.mContainerView`  L235
- `View view17 = this.mContainerView`  L241
- `int i = x`  L253
- `View view = this.mContainerView`  L260
- `View view2 = null`  L261
- `View view3 = this.mContainerView`  L267
- `int i2 = this.mMaximumVelocity`  L277
- `int i3 = this.mMaximumVelocity`  L279
- `View view4 = this.mContainerView`  L281
- `View view5 = this.mContainerView`  L287
- `OverScroller overScroller = this.mOverScroller`  L295
- `View view6 = this.mContainerView`  L297
- `View view7 = this.mContainerView`  L303
- `ScaleHelper scaleHelper = this.mScaleHelper`  L319
- `ScaleHelper scaleHelper2 = this.mScaleHelper`  L329
- `View view = this.mContainerView`  L337
- `View view = this.mContainerView`  L346
- `View view = this.mContainerView`  L356
- `View view = this.mContainerView`  L365
- `View view = this.mContainerView`  L375
- `View view2 = null`  L376
- `View view3 = this.mContainerView`  L382
- `int i = scrollX + deltaX`  L387
- `int i2 = scrollRangeY >= 0 ? scrollRangeY : 0`  L398
- `View view4 = this.mContainerView`  L399
- `GestureDetector gestureDetector = this.mGestureDetector`  L413
- `ScaleGestureDetector scaleGestureDetector = this.mScaleDetector`  L417

方法（17）：
- `void onScaleEnd(ScaleGestureDetector detector)`  L46 @Override
    - 体内字面量："detector"
- `boolean onScale(ScaleGestureDetector detector)`  L51 @Override
    - 体内字面量："detector" · "scale:" · " - " · "-"
- `boolean onScaleBegin(ScaleGestureDetector detector)`  L65 @Override
    - 体内字面量："detector"
- `boolean onDown(MotionEvent e)`  L77 @Override
- `boolean onDoubleTap(MotionEvent e)`  L88 @Override
    - 体内字面量："e"
- `boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)`  L104 @Override
    - 体内字面量："e2"
- `boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)`  L119 @Override
    - 体内字面量："e2"
- `void init(Context context, ViewGroup containerView)`  L126
    - 体内字面量："context" · "containerView"
- `void setScale(float scale, int centerX, int centerY)`  L139
- `boolean fling(int x, int y)`  L252
- `void smoothScale(float newScale, int centerX, int centerY)`  L314
- `int getScrollRangeX()`  L336
- `float getContentWidth()`  L345
- `int getScrollRangeY()`  L355
- `float getContentHeight()`  L364
- `void processScroll(int deltaX, int deltaY, int scrollRangeX, int scrollRangeY)`  L374
- `void onTouchEvent(MotionEvent event)`  L408
### `com.tuwinsmart.tuwin.core.util.gson.M3ParamValueTypeAdapter`
L15 · [class] public final M3ParamValueTypeAdapter · extends `TypeAdapter<String>` · `com/tuwinsmart/tuwin/core/util/gson/M3ParamValueTypeAdapter.java`
注解：

方法（2）：
- `void write(JsonWriter out, String value)`  L45 @Override
    - 体内字面量："out"
- `String read2(JsonReader in)`  L52 @Override
    - 体内字面量："in"
### `com.tuwinsmart.tuwin.core.util.gson.M3ParamValueTypeAdapter$WhenMappings`
L19 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/util/gson/M3ParamValueTypeAdapter.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L20
### `com.tuwinsmart.tuwin.core.util.LocalUpgradeBean`
L12 · [class] public final LocalUpgradeBean · `com/tuwinsmart/tuwin/core/util/LocalUpgradeBean.java`
注解：

字段/常量（24）：
- `String boardversion`  L13
- `String deviceTypeCode`  L14
- `String expectedFileName`  L15
- `String file`  L16
- `Long fileSize`  L17
- `String model`  L18
- `String newVersion`  L19
- `String ride3ProFirmwareHw`  L20
- `String ride3ProFirmwareModel`  L21
- `String ride3ProFirmwareSw`  L22
- `String updateLog`  L23
- `String version`  L24
- `String str = this.version`  L102
- `String str2 = this.newVersion`  L104
- `String str3 = this.updateLog`  L106
- `String str4 = this.file`  L108
- `String str5 = this.expectedFileName`  L110
- `Long l = this.fileSize`  L112
- `String str6 = this.boardversion`  L114
- `String str7 = this.model`  L116
- `String str8 = this.deviceTypeCode`  L118
- `String str9 = this.ride3ProFirmwareModel`  L120
- `String str10 = this.ride3ProFirmwareHw`  L122
- `String str11 = this.ride3ProFirmwareSw`  L124

方法（41）：
- `String getVersion()`  L27
- `String getRide3ProFirmwareModel()`  L32
- `String getRide3ProFirmwareHw()`  L37
- `String getRide3ProFirmwareSw()`  L42
- `String getNewVersion()`  L47
- `String getUpdateLog()`  L52
- `String getFile()`  L57
- `String getExpectedFileName()`  L62
- `Long getFileSize()`  L67
- `String getBoardversion()`  L72
- `String getModel()`  L77
- `String getDeviceTypeCode()`  L82
- `LocalUpgradeBean copy(String version, String newVersion, String updateLog, String file, String expectedFileName, Long fileSize, String boardversion, String model, String deviceTypeCode, String ride3ProFirmwareModel, String ride3ProFirmwareHw, String ride3ProFirmwareSw)`  L86
- `boolean equals(Object other)`  L90
- `int hashCode()`  L101
- `String toString()`  L128
    - 体内字面量："LocalUpgradeBean(version=" · ", newVersion=" · ", updateLog=" · ", file=" · ", expectedFileName=" · ", fileSize=" · ", boardversion=" · ", model=" · ", deviceTypeCode=" · ", ride3ProFirmwareModel=" · ", ride3ProFirmwareHw=" · ", ride3ProFirmwareSw=" · ")"
- `public LocalUpgradeBean(String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7, String str8, String str9, String str10, String str11)`  L132
- ` LocalUpgradeBean(String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker)`  L147
- `String getVersion()`  L151
- `String getNewVersion()`  L155
- `void setNewVersion(String str)`  L159
- `String getUpdateLog()`  L163
- `void setUpdateLog(String str)`  L167
- `String getFile()`  L171
- `void setFile(String str)`  L175
- `String getExpectedFileName()`  L179
- `void setExpectedFileName(String str)`  L183
- `Long getFileSize()`  L187
- `void setFileSize(Long l)`  L191
- `String getBoardversion()`  L195
- `void setBoardversion(String str)`  L199
- `String getModel()`  L203
- `void setModel(String str)`  L207
- `String getDeviceTypeCode()`  L211
- `void setDeviceTypeCode(String str)`  L215
- `String getRide3ProFirmwareModel()`  L219
- `void setRide3ProFirmwareModel(String str)`  L223
- `String getRide3ProFirmwareHw()`  L227
- `void setRide3ProFirmwareHw(String str)`  L231
- `String getRide3ProFirmwareSw()`  L235
- `void setRide3ProFirmwareSw(String str)`  L239
### `com.tuwinsmart.tuwin.core.util.logging.AppCrashHandler`
L24 · [class] public final AppCrashHandler · `com/tuwinsmart/tuwin/core/util/logging/AppCrashHandler.java`
注解：

字段/常量（4）：
- `String TAG = "TUWIN_LOG"`  L25
- `List<ActivityManager.RunningAppProcessInfo> runningAppProcesses`  L44
- `Object next`  L45
- `String str = null`  L52

方法（3）：
- `private AppCrashHandler()`  L29
- `void install(Context context)`  L32
    - 体内字面量："context" · "CLOG" · "å´©æºæ¥å¿å¤çå¨å·²å®è£: "
- `String resolveProcessName(Context context)`  L43
### `com.tuwinsmart.tuwin.core.util.logging.AppCrashHandler$DelegatingHandler`
L78 · [class] private static final DelegatingHandler · implements `Thread.UncaughtExceptionHandler` · `com/tuwinsmart/tuwin/core/util/logging/AppCrashHandler.java`
注解：

字段/常量（4）：
- `File crashLogDir`  L79
- `Thread.UncaughtExceptionHandler previousHandler`  L80
- `String processName`  L81
- `Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler`  L102

方法（3）：
- `public DelegatingHandler(String processName, File crashLogDir, Thread.UncaughtExceptionHandler uncaughtExceptionHandler)`  L83
    - 体内字面量："processName" · "crashLogDir"
- `void uncaughtException(Thread thread, Throwable throwable)`  L92 @Override
    - 体内字面量："thread" · "throwable" · "å´©æºå æ å·²ä¿å­: " · "ä¿å­å´©æºå æ å¤±è´¥"
- `Map<String, String> crashMetadata()`  L112
    - 体内字面量："session_id" · "process_name" · "process_id" · "app_version" · "app_version_code" · "250" · "android_version" · "android_sdk" · "device" · " "
### `com.tuwinsmart.tuwin.core.util.logging.AppHttpLogger`
L12 · [class] final AppHttpLogger · implements `Logger` · `com/tuwinsmart/tuwin/core/util/logging/AppHttpLogger.java`
注解：

字段/常量（2）：
- `String strReplace$default`  L21
- `String strRemovePrefix`  L22

方法（2）：
- `private AppHttpLogger()`  L15
- `void log(int level, String tag, String msg)`  L20 @Override
### `com.tuwinsmart.tuwin.core.util.logging.DiagnosticHttpLoggingInterceptor`
L26 · [class] public final DiagnosticHttpLoggingInterceptor · implements `Interceptor` · `com/tuwinsmart/tuwin/core/util/logging/DiagnosticHttpLoggingInterceptor.java`
注解：

字段/常量（29）：
- `String clientName`  L27
- `boolean logBodies`  L28
- `String requestIdHeader`  L29
- `String strNextId`  L44
- `char c`  L45
- `String strRequestBodySummary$default`  L46
- `Object obj`  L47
- `Object obj2`  L48
- `Object obj3`  L49
- `Object obj4`  L50
- `Object obj5`  L51
- `String str = this.requestIdHeader`  L54
- `String str2 = strNextId`  L58
- `DiagnosticLog diagnosticLog = DiagnosticLog.INSTANCE`  L62
- `Pair<String, ? extends Object>[] pairArr = new Pair[7]`  L63
- `DiagnosticLog diagnosticLog2 = DiagnosticLog.INSTANCE`  L83
- `Pair<String, ? extends Object>[] pairArr2 = new Pair[10]`  L84
- `DiagnosticLog diagnosticLog3 = DiagnosticLog.INSTANCE`  L118
- `Pair<String, ? extends Object>[] pairArr3 = new Pair[8]`  L119
- `DiagnosticLog diagnosticLog4 = DiagnosticLog.INSTANCE`  L135
- `Pair<String, ? extends Object>[] pairArr4 = new Pair[8]`  L136
- `DiagnosticLog diagnosticLog5 = DiagnosticLog.INSTANCE`  L153
- `Pair<String, ? extends Object>[] pairArr5 = new Pair[8]`  L154
- `DiagnosticLog diagnosticLog6 = DiagnosticLog.INSTANCE`  L180
- `Pair<String, ? extends Object>[] pairArr6 = new Pair[8]`  L181
- `Object objM3074constructorimpl`  L199
- `Result.Companion companion = Result.INSTANCE`  L210
- `DiagnosticHttpLoggingInterceptor diagnosticHttpLoggingInterceptor = this`  L211
- `Result.Companion companion2 = Result.INSTANCE`  L220

方法（4）：
- `public DiagnosticHttpLoggingInterceptor(String clientName, boolean z, String str)`  L31
    - 体内字面量："clientName"
- ` DiagnosticHttpLoggingInterceptor(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker)`  L38
- `Response intercept(Interceptor.Chain chain)`  L43 @Override
- `BodySummary responseBodySummary(Response response)`  L198
### `com.tuwinsmart.tuwin.core.util.logging.DiagnosticHttpLoggingInterceptor$BodySummary`
L228 · [class] private static final BodySummary · `com/tuwinsmart/tuwin/core/util/logging/DiagnosticHttpLoggingInterceptor.java`
注解：

字段/常量（2）：
- `String text`  L229
- `boolean truncated`  L230

方法（10）：
- `BodySummary copy$default(BodySummary bodySummary, String str, boolean z, int i, Object obj)`  L232
- `String getText()`  L243
- `boolean getTruncated()`  L248
- `BodySummary copy(String text, boolean truncated)`  L252
    - 体内字面量："text"
- `boolean equals(Object other)`  L257
- `int hashCode()`  L268
- `String toString()`  L272
    - 体内字面量："BodySummary(text=" · ", truncated=" · ")"
- `public BodySummary(String text, boolean z)`  L276
    - 体内字面量："text"
- `String getText()`  L282
- `boolean getTruncated()`  L286
### `com.tuwinsmart.tuwin.core.util.logging.DiagnosticHttpLogPolicy`
L45 · [class] public final DiagnosticHttpLogPolicy · `com/tuwinsmart/tuwin/core/util/logging/DiagnosticHttpLogPolicy.java`
注解：

字段/常量（30）：
- `long ERROR_BODY_LIMIT_BYTES = 16384`  L46
- `long SUCCESS_BODY_LIMIT_BYTES = 4096`  L47
- `Locale US = Locale.US`  L57
- `Locale US = Locale.US`  L70
- `Set<String> set = textTypes`  L74
- `Object objM3074constructorimpl`  L94
- `String str`  L95
- `Result.Companion companion = Result.INSTANCE`  L97
- `DiagnosticHttpLogPolicy diagnosticHttpLogPolicy = this`  L98
- `Result.Companion companion2 = Result.INSTANCE`  L105
- `String str3 = str2 != null ? str + "=" + str2 : null`  L143
- `ArrayList arrayList2 = arrayList`  L148
- `Object objM3074constructorimpl`  L166
- `Object objM3074constructorimpl2`  L167
- `Result.Companion companion = Result.INSTANCE`  L190
- `DiagnosticHttpLogPolicy diagnosticHttpLogPolicy = this`  L191
- `Result.Companion companion2 = Result.INSTANCE`  L194
- `Result.Companion companion3 = Result.INSTANCE`  L205
- `DiagnosticHttpLogPolicy diagnosticHttpLogPolicy2 = this`  L206
- `Result.Companion companion4 = Result.INSTANCE`  L211
- `String mediaType2`  L218
- `Object objM3074constructorimpl`  L219
- `Result.Companion companion = Result.INSTANCE`  L223
- `DiagnosticHttpLogPolicy diagnosticHttpLogPolicy = this`  L224
- `Result.Companion companion2 = Result.INSTANCE`  L229
- `JsonElement jsonPrimitive`  L241
- `JsonElement jsonElementRedactJson`  L242
- `DiagnosticHttpLogPolicy diagnosticHttpLogPolicy = INSTANCE`  L253
- `DiagnosticHttpLogPolicy diagnosticHttpLogPolicy2 = INSTANCE`  L270
- `HttpUrl.Companion companion = HttpUrl.INSTANCE`  L278

方法（13）：
- `private DiagnosticHttpLogPolicy()`  L52
- `boolean isSensitive(String name)`  L55
    - 体内字面量："name"
- `boolean isText(MediaType mediaType)`  L65
- `String redactUrl(HttpUrl url)`  L87
    - 体内字面量："url"
- `String redactUri(String raw)`  L93
- `String headerSummary(Headers headers)`  L132
    - 体内字面量："headers" · "Content-Type" · "Content-Length" · "Range" · "Retry-After" · "Request-Id"
- `String requestBodySummary$default(DiagnosticHttpLogPolicy diagnosticHttpLogPolicy, Request request, long j, int i, Object obj)`  L158
- `String requestBodySummary(Request request, long limitBytes)`  L165
- `String redactText(MediaType mediaType, String text)`  L217
- `JsonElement redactJson(JsonElement element)`  L240
- `String portSuffix(HttpUrl url)`  L295
    - 体内字面量："https" · ":"
- `String redactPairs(String text)`  L302
    - 体内字面量："(?i)([\\\"']?" · "[\\\"']?\\s*[:=]\\s*)[^,;&\\s}]+"
- `CharSequence invoke(MatchResult match)`  L307 @Override
    - 体内字面量："match" · "***"
### `com.tuwinsmart.tuwin.core.util.logging.DiagnosticLog`
L17 · [class] public final DiagnosticLog · `com/tuwinsmart/tuwin/core/util/logging/DiagnosticLog.java`
注解：

字段/常量（3）：
- `AtomicLong sequence`  L19
- `String sessionId`  L20
- `DiagnosticLog diagnosticLog = INSTANCE`  L45

方法（5）：
- `private DiagnosticLog()`  L22
    - 体内字面量："toString(...)" · "-"
- `String getSessionId()`  L32
- `String nextId(String prefix)`  L36
    - 体内字面量："prefix" · "-" · "-"
- `String event(String name, Pair<String, ? extends Object>... fields)`  L41
    - 体内字面量："name" · "fields" · "event="
- `String encode(String value)`  L60
    - 体内字面量："\"" · "\\" · "\\\\" · "\r" · "\\\r" · "\n" · "\\\n" · "\"" · "\\\"" · "\""
### `com.tuwinsmart.tuwin.core.util.logging.FullHttpLoggingInterceptorKt`
L12 · [class] public final FullHttpLoggingInterceptorKt · `com/tuwinsmart/tuwin/core/util/logging/FullHttpLoggingInterceptorKt.java`
注解：

字段/常量（5）：
- `String LOG_SOURCE = "HTTP_FULL"`  L13
- `String REQUEST = "REQUEST"`  L14
- `String RESPONSE = "RESPONSE"`  L15
- `String TAG_PREFIX = "HTTP_FULL|"`  L16
- `String TAG_SEPARATOR = "|"`  L17

方法（2）：
- `LoggingInterceptor fullHttpLoggingInterceptor(String clientName)`  L19
    - 体内字面量："clientName"
- `String logTag(String str, String str2)`  L24
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticEvent`
L11 · [interface] public Ride3ProIndexedDiagnosticEvent · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent.java`
注解：

方法（1）：
- `long getTraceId()`  L12
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent$HourScanStarted;" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent;" · "traceId" · "hourKey" · "Lcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;" · "lastFileIndex" · "startedAtElapsedMs" · "(JLcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;IJ)V" · "getHourKey" · "()Lcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;" · "getLastFileIndex" · "()I" · "getStartedAtElapsedMs" · "()J" · "getTraceId" · "component1" · "component2" · "component3" · "component4" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent$FileListPage;" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent;" · "traceId" · "pageNumber" · "requestFileIndex" · "pageSize" · "validFileCount" · "skippedFileCount" · "targetCount" · "newerCount" · "olderCount" · "collectedFileCount" · "decision" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedPageDecision;" · "nextFileIndex" · "completionReason" · "failureReason" · "pageCostMs" · "(JIIIIIIIIILcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedPageDecision;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;J)V" · "getCollectedFileCount" · "()I" · "getCompletionReason" · "()Ljava/lang/String;" · "getDecision" · "()Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedPageDecision;" · "getFailureReason" · "getNewerCount" · "getNextFileIndex" · "()Ljava/lang/Integer;" · "Ljava/lang/Integer;" · "getOlderCount" · "getPageCostMs" · "()J" · "getPageNumber" · "getPageSize" · "getRequestFileIndex" · "getSkippedFileCount" · "getTargetCount" · "getTraceId" · "getValidFileCount" · "component1" · "component10" · "component11" · "component12" · "component13" · "component14" · "component15" · "component2" · "component3" · "component4" · "component5" · "component6" · "component7" · "component8" · "component9" · "copy" · "(JIIIIIIIIILcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedPageDecision;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;J)Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent$FileListPage;" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent$HourScanFinished;" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent;" · "traceId" · "pageCount" · "fileCount" · "outcome" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScanOutcome;" · "reason" · "wrapped" · "totalCostMs" · "(JIILcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScanOutcome;Ljava/lang/String;ZJ)V" · "getFileCount" · "()I" · "getOutcome" · "()Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScanOutcome;" · "getPageCount" · "getReason" · "()Ljava/lang/String;" · "getTotalCostMs" · "()J" · "getTraceId" · "getWrapped" · "()Z" · "component1" · "component2" · "component3" · "component4" · "component5" · "component6" · "component7" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent$ScreenStarted;" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent;" · "traceId" · "screen" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScreen;" · "startedAtElapsedMs" · "(JLcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScreen;J)V" · "getScreen" · "()Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScreen;" · "getStartedAtElapsedMs" · "()J" · "getTraceId" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent$ScreenVisible;" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent;" · "traceId" · "screen" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScreen;" · "outcome" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedVisibilityOutcome;" · "itemCount" · "totalCostMs" · "(JLcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScreen;Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedVisibilityOutcome;IJ)V" · "getItemCount" · "()I" · "getOutcome" · "()Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedVisibilityOutcome;" · "getScreen" · "()Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScreen;" · "getTotalCostMs" · "()J" · "getTraceId" · "component1" · "component2" · "component3" · "component4" · "component5" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent$HourOpenStarted;" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent;" · "traceId" · "hourKey" · "Lcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;" · "reportedFileCount" · "lastFileIndex" · "cached" · "latest" · "startedAtElapsedMs" · "(JLcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;Ljava/lang/Integer;IZZJ)V" · "getCached" · "()Z" · "getHourKey" · "()Lcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;" · "getLastFileIndex" · "()I" · "getLatest" · "getReportedFileCount" · "()Ljava/lang/Integer;" · "Ljava/lang/Integer;" · "getStartedAtElapsedMs" · "()J" · "getTraceId" · "component1" · "component2" · "component3" · "component4" · "component5" · "component6" · "component7" · "copy" · "(JLcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;Ljava/lang/Integer;IZZJ)Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent$HourOpenStarted;" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent$HourOpenFinished;" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent;" · "traceId" · "hourKey" · "Lcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;" · "outcome" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedVisibilityOutcome;" · "itemCount" · "totalCostMs" · "(JLcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedVisibilityOutcome;IJ)V" · "getHourKey" · "()Lcom/tuwinsmart/tuwin/domain/model/Ride3ProHourKey;" · "getItemCount" · "()I" · "getOutcome" · "()Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedVisibilityOutcome;" · "getTotalCostMs" · "()J" · "getTraceId" · "component1" · "component2" · "component3" · "component4" · "component5" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticEvent$FileListPage`
L113 · [class] public static final FileListPage · implements `Ride3ProIndexedDiagnosticEvent` · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent.java`
注解：

字段/常量（18）：
- `int collectedFileCount`  L114
- `String completionReason`  L115
- `Ride3ProIndexedPageDecision decision`  L116
- `String failureReason`  L117
- `int newerCount`  L118
- `Integer nextFileIndex`  L119
- `int olderCount`  L120
- `long pageCostMs`  L121
- `int pageNumber`  L122
- `int pageSize`  L123
- `int requestFileIndex`  L124
- `int skippedFileCount`  L125
- `int targetCount`  L126
- `long traceId`  L127
- `int validFileCount`  L128
- `Integer num = this.nextFileIndex`  L223
- `String str = this.completionReason`  L225
- `String str2 = this.failureReason`  L227

方法（35）：
- `long getTraceId()`  L131
- `int getCollectedFileCount()`  L136
- `Ride3ProIndexedPageDecision getDecision()`  L141
- `Integer getNextFileIndex()`  L146
- `String getCompletionReason()`  L151
- `String getFailureReason()`  L156
- `long getPageCostMs()`  L161
- `int getPageNumber()`  L166
- `int getRequestFileIndex()`  L171
- `int getPageSize()`  L176
- `int getValidFileCount()`  L181
- `int getSkippedFileCount()`  L186
- `int getTargetCount()`  L191
- `int getNewerCount()`  L196
- `int getOlderCount()`  L201
- `FileListPage copy(long traceId, int pageNumber, int requestFileIndex, int pageSize, int validFileCount, int skippedFileCount, int targetCount, int newerCount, int olderCount, int collectedFileCount, Ride3ProIndexedPageDecision decision, Integer nextFileIndex, String completionReason, String failureReason, long pageCostMs)`  L205
    - 体内字面量："decision"
- `boolean equals(Object other)`  L210
- `int hashCode()`  L221
- `String toString()`  L231
    - 体内字面量："FileListPage(traceId=" · ", pageNumber=" · ", requestFileIndex=" · ", pageSize=" · ", validFileCount=" · ", skippedFileCount=" · ", targetCount=" · ", newerCount=" · ", olderCount=" · ", collectedFileCount=" · ", decision=" · ", nextFileIndex=" · ", completionReason=" · ", failureReason=" · ", pageCostMs=" · ")"
- `public FileListPage(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Ride3ProIndexedPageDecision decision, Integer num, String str, String str2, long j2)`  L235
    - 体内字面量："decision"
- `long getTraceId()`  L255 @Override
- `int getPageNumber()`  L259
- `int getRequestFileIndex()`  L263
- `int getPageSize()`  L267
- `int getValidFileCount()`  L271
- `int getSkippedFileCount()`  L275
- `int getTargetCount()`  L279
- `int getNewerCount()`  L283
- `int getOlderCount()`  L287
- `int getCollectedFileCount()`  L291
- `Ride3ProIndexedPageDecision getDecision()`  L295
- `Integer getNextFileIndex()`  L299
- `String getCompletionReason()`  L303
- `String getFailureReason()`  L307
- `long getPageCostMs()`  L311
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticEvent$HourOpenFinished`
L717 · [class] public static final HourOpenFinished · implements `Ride3ProIndexedDiagnosticEvent` · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent.java`
注解：

字段/常量（5）：
- `Ride3ProHourKey hourKey`  L718
- `int itemCount`  L719
- `Ride3ProIndexedVisibilityOutcome outcome`  L720
- `long totalCostMs`  L721
- `long traceId`  L722

方法（15）：
- `long getTraceId()`  L725
- `Ride3ProHourKey getHourKey()`  L730
- `Ride3ProIndexedVisibilityOutcome getOutcome()`  L735
- `int getItemCount()`  L740
- `long getTotalCostMs()`  L745
- `HourOpenFinished copy(long traceId, Ride3ProHourKey hourKey, Ride3ProIndexedVisibilityOutcome outcome, int itemCount, long totalCostMs)`  L749
    - 体内字面量："hourKey" · "outcome"
- `boolean equals(Object other)`  L755
- `int hashCode()`  L766
- `String toString()`  L770
    - 体内字面量："HourOpenFinished(traceId=" · ", hourKey=" · ", outcome=" · ", itemCount=" · ", totalCostMs=" · ")"
- `public HourOpenFinished(long j, Ride3ProHourKey hourKey, Ride3ProIndexedVisibilityOutcome outcome, int i, long j2)`  L774
    - 体内字面量："hourKey" · "outcome"
- `long getTraceId()`  L785 @Override
- `Ride3ProHourKey getHourKey()`  L789
- `Ride3ProIndexedVisibilityOutcome getOutcome()`  L793
- `int getItemCount()`  L797
- `long getTotalCostMs()`  L801
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticEvent$HourOpenStarted`
L604 · [class] public static final HourOpenStarted · implements `Ride3ProIndexedDiagnosticEvent` · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent.java`
注解：

字段/常量（8）：
- `boolean cached`  L605
- `Ride3ProHourKey hourKey`  L606
- `int lastFileIndex`  L607
- `boolean latest`  L608
- `Integer reportedFileCount`  L609
- `long startedAtElapsedMs`  L610
- `long traceId`  L611
- `Integer num = this.reportedFileCount`  L666

方法（19）：
- `long getTraceId()`  L614
- `Ride3ProHourKey getHourKey()`  L619
- `Integer getReportedFileCount()`  L624
- `int getLastFileIndex()`  L629
- `boolean getCached()`  L634
- `boolean getLatest()`  L639
- `long getStartedAtElapsedMs()`  L644
- `HourOpenStarted copy(long traceId, Ride3ProHourKey hourKey, Integer reportedFileCount, int lastFileIndex, boolean cached, boolean latest, long startedAtElapsedMs)`  L648
    - 体内字面量："hourKey"
- `boolean equals(Object other)`  L653
- `int hashCode()`  L664
- `String toString()`  L670
    - 体内字面量："HourOpenStarted(traceId=" · ", hourKey=" · ", reportedFileCount=" · ", lastFileIndex=" · ", cached=" · ", latest=" · ", startedAtElapsedMs=" · ")"
- `public HourOpenStarted(long j, Ride3ProHourKey hourKey, Integer num, int i, boolean z, boolean z2, long j2)`  L674
    - 体内字面量："hourKey"
- `long getTraceId()`  L686 @Override
- `Ride3ProHourKey getHourKey()`  L690
- `Integer getReportedFileCount()`  L694
- `int getLastFileIndex()`  L698
- `boolean getCached()`  L702
- `boolean getLatest()`  L706
- `long getStartedAtElapsedMs()`  L710
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticEvent$HourScanFinished`
L318 · [class] public static final HourScanFinished · implements `Ride3ProIndexedDiagnosticEvent` · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent.java`
注解：

字段/常量（7）：
- `int fileCount`  L319
- `Ride3ProIndexedScanOutcome outcome`  L320
- `int pageCount`  L321
- `String reason`  L322
- `long totalCostMs`  L323
- `long traceId`  L324
- `boolean wrapped`  L325

方法（19）：
- `long getTraceId()`  L328
- `int getPageCount()`  L333
- `int getFileCount()`  L338
- `Ride3ProIndexedScanOutcome getOutcome()`  L343
- `String getReason()`  L348
- `boolean getWrapped()`  L353
- `long getTotalCostMs()`  L358
- `HourScanFinished copy(long traceId, int pageCount, int fileCount, Ride3ProIndexedScanOutcome outcome, String reason, boolean wrapped, long totalCostMs)`  L362
    - 体内字面量："outcome" · "reason"
- `boolean equals(Object other)`  L368
- `int hashCode()`  L379
- `String toString()`  L383
    - 体内字面量："HourScanFinished(traceId=" · ", pageCount=" · ", fileCount=" · ", outcome=" · ", reason=" · ", wrapped=" · ", totalCostMs=" · ")"
- `public HourScanFinished(long j, int i, int i2, Ride3ProIndexedScanOutcome outcome, String reason, boolean z, long j2)`  L387
    - 体内字面量："outcome" · "reason"
- `long getTraceId()`  L400 @Override
- `int getPageCount()`  L404
- `int getFileCount()`  L408
- `Ride3ProIndexedScanOutcome getOutcome()`  L412
- `String getReason()`  L416
- `boolean getWrapped()`  L420
- `long getTotalCostMs()`  L424
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticEvent$HourScanStarted`
L16 · [class] public static final HourScanStarted · implements `Ride3ProIndexedDiagnosticEvent` · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent.java`
注解：

字段/常量（7）：
- `Ride3ProHourKey hourKey`  L17
- `int lastFileIndex`  L18
- `long startedAtElapsedMs`  L19
- `long traceId`  L20
- `long j3 = j`  L26
- `Ride3ProHourKey ride3ProHourKey2 = ride3ProHourKey`  L30
- `int i3 = i`  L34

方法（14）：
- `HourScanStarted copy$default(HourScanStarted hourScanStarted, long j, Ride3ProHourKey ride3ProHourKey, int i, long j2, int i2, Object obj)`  L22
- `long getTraceId()`  L42
- `Ride3ProHourKey getHourKey()`  L47
- `int getLastFileIndex()`  L52
- `long getStartedAtElapsedMs()`  L57
- `HourScanStarted copy(long traceId, Ride3ProHourKey hourKey, int lastFileIndex, long startedAtElapsedMs)`  L61
    - 体内字面量："hourKey"
- `boolean equals(Object other)`  L66
- `int hashCode()`  L77
- `String toString()`  L81
    - 体内字面量："HourScanStarted(traceId=" · ", hourKey=" · ", lastFileIndex=" · ", startedAtElapsedMs=" · ")"
- `public HourScanStarted(long j, Ride3ProHourKey hourKey, int i, long j2)`  L85
    - 体内字面量："hourKey"
- `long getTraceId()`  L94 @Override
- `Ride3ProHourKey getHourKey()`  L98
- `int getLastFileIndex()`  L102
- `long getStartedAtElapsedMs()`  L106
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticEvent$ScreenStarted`
L431 · [class] public static final ScreenStarted · implements `Ride3ProIndexedDiagnosticEvent` · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent.java`
注解：

字段/常量（5）：
- `Ride3ProIndexedScreen screen`  L432
- `long startedAtElapsedMs`  L433
- `long traceId`  L434
- `long j3 = j`  L440
- `Ride3ProIndexedScreen ride3ProIndexedScreen2 = ride3ProIndexedScreen`  L444

方法（12）：
- `ScreenStarted copy$default(ScreenStarted screenStarted, long j, Ride3ProIndexedScreen ride3ProIndexedScreen, long j2, int i, Object obj)`  L436
- `long getTraceId()`  L452
- `Ride3ProIndexedScreen getScreen()`  L457
- `long getStartedAtElapsedMs()`  L462
- `ScreenStarted copy(long traceId, Ride3ProIndexedScreen screen, long startedAtElapsedMs)`  L466
    - 体内字面量："screen"
- `boolean equals(Object other)`  L471
- `int hashCode()`  L482
- `String toString()`  L486
    - 体内字面量："ScreenStarted(traceId=" · ", screen=" · ", startedAtElapsedMs=" · ")"
- `public ScreenStarted(long j, Ride3ProIndexedScreen screen, long j2)`  L490
    - 体内字面量："screen"
- `long getTraceId()`  L498 @Override
- `Ride3ProIndexedScreen getScreen()`  L502
- `long getStartedAtElapsedMs()`  L506
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticEvent$ScreenVisible`
L513 · [class] public static final ScreenVisible · implements `Ride3ProIndexedDiagnosticEvent` · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticEvent.java`
注解：

字段/常量（5）：
- `int itemCount`  L514
- `Ride3ProIndexedVisibilityOutcome outcome`  L515
- `Ride3ProIndexedScreen screen`  L516
- `long totalCostMs`  L517
- `long traceId`  L518

方法（15）：
- `long getTraceId()`  L521
- `Ride3ProIndexedScreen getScreen()`  L526
- `Ride3ProIndexedVisibilityOutcome getOutcome()`  L531
- `int getItemCount()`  L536
- `long getTotalCostMs()`  L541
- `ScreenVisible copy(long traceId, Ride3ProIndexedScreen screen, Ride3ProIndexedVisibilityOutcome outcome, int itemCount, long totalCostMs)`  L545
    - 体内字面量："screen" · "outcome"
- `boolean equals(Object other)`  L551
- `int hashCode()`  L562
- `String toString()`  L566
    - 体内字面量："ScreenVisible(traceId=" · ", screen=" · ", outcome=" · ", itemCount=" · ", totalCostMs=" · ")"
- `public ScreenVisible(long j, Ride3ProIndexedScreen screen, Ride3ProIndexedVisibilityOutcome outcome, int i, long j2)`  L570
    - 体内字面量："screen" · "outcome"
- `long getTraceId()`  L581 @Override
- `Ride3ProIndexedScreen getScreen()`  L585
- `Ride3ProIndexedVisibilityOutcome getOutcome()`  L589
- `int getItemCount()`  L593
- `long getTotalCostMs()`  L597
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticFormatter`
L13 · [class] public final Ride3ProIndexedDiagnosticFormatter · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticFormatter.java`
注解：

字段/常量（1）：
- `String string`  L53

方法（3）：
- `private Ride3ProIndexedDiagnosticFormatter()`  L16
- `String format(Ride3ProIndexedDiagnosticEvent event)`  L19
    - 体内字面量："event" · "Ride3Pro Indexed Trace: event=hour_scan_start trace_id=" · " date=" · " hour=" · " last_file_index=" · " started_elapsed_ms=" · "Ride3Pro Indexed Trace: event=file_list_page trace_id=" · " page=" · " request_file_index=" · " page_size=" · " valid=" · " skipped=" · " target=" · " newer=" · " older=" · " collected=" · " decision=" · " next_file_index=" · " completion_reason=" · " failure_reason=" · " cost_ms=" · "Ride3Pro Indexed Trace: event=hour_scan_finish trace_id=" · " pages=" · " files=" · " outcome=" · " reason=" · " wrapped=" · " cost_ms=" · "Ride3Pro Indexed Trace: event=screen_start trace_id=" · " screen=" · " started_elapsed_ms=" · "Ride3Pro Indexed Trace: event=screen_visible trace_id=" · " screen=" · " outcome=" · " items=" · " cost_ms=" · "Ride3Pro Indexed Trace: event=hour_open_start trace_id=" · " date=" · " hour=" · " reported_file_count=" · " last_file_index=" · " cached=" · " latest=" · " started_elapsed_ms=" · "Ride3Pro Indexed Trace: event=hour_open_finish trace_id=" · " date=" · " hour=" · " outcome=" · " items=" · " cost_ms="
- `String orMissing(Object obj)`  L52
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnostics`
L13 · [class] public final Ride3ProIndexedDiagnostics · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnostics.java`
注解：

字段/常量（4）：
- `Function0<Long> elapsedRealtimeMs`  L17
- `Function0<Boolean> enabled`  L18
- `Function0<Long> nextTraceId`  L19
- `Ride3ProIndexedDiagnosticSink sink`  L20

方法（6）：
- `public Ride3ProIndexedDiagnostics(Function0<Boolean> enabled, Function0<Long> elapsedRealtimeMs, Function0<Long> nextTraceId, Ride3ProIndexedDiagnosticSink sink)`  L22
    - 体内字面量："enabled" · "elapsedRealtimeMs" · "nextTraceId" · "sink"
- `boolean isEnabled()`  L33
- `long now()`  L37
- `long elapsedSince(long startedAtElapsedMs)`  L41
    - 体内字面量："diagnostic monotonic clock moved backwards: start=" · ", finish="
- `long newTraceId()`  L49
- `void emit(Ride3ProIndexedDiagnosticEvent event)`  L53
    - 体内字面量："event" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnostics$Companion;" · "()V" · "disabled" · "Lcom/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnostics;" · "app_release_64"
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnostics$Companion`
L62 · [class] public static final Companion · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnostics.java`
注解：

方法（7）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L63
- `private Companion()`  L67
- `Ride3ProIndexedDiagnostics disabled()`  L70
- `Boolean invoke()`  L74 @Override
- `Long invoke()`  L80 @Override
- `Long invoke()`  L86 @Override
- `void emit(Ride3ProIndexedDiagnosticEvent ride3ProIndexedDiagnosticEvent)`  L91 @Override
    - 体内字面量："it"
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedDiagnosticSink`
L10 · [interface] public Ride3ProIndexedDiagnosticSink · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedDiagnosticSink.java`
注解：

方法（1）：
- `void emit(Ride3ProIndexedDiagnosticEvent event)`  L11
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedPageDecision`
L11 · [enum] public Ride3ProIndexedPageDecision · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedPageDecision.java`
注解：

枚举常量（4）：
- `CONTINUE()`  L12
- `COMPLETE()`  L13
- `NO_VALID_RECORDINGS()`  L14
- `FAILURE()`  L15

方法（1）：
- `EnumEntries<Ride3ProIndexedPageDecision> getEntries()`  L19
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedPerformanceTracer`
L12 · [class] public final Ride3ProIndexedPerformanceTracer · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedPerformanceTracer.java`
注解：

字段/常量（1）：
- `Ride3ProIndexedDiagnostics diagnostics`  L13

方法（6）：
- `public Ride3ProIndexedPerformanceTracer(Ride3ProIndexedDiagnostics diagnostics)`  L15
    - 体内字面量："diagnostics"
- `Ride3ProIndexedTraceContext startStorageEntry()`  L20
- `void finishStorageVisible(Ride3ProIndexedTraceContext context, Ride3ProIndexedScreen screen, Ride3ProIndexedVisibilityOutcome outcome, int itemCount)`  L26
    - 体内字面量："context" · "screen" · "outcome" · "visible item count must not be negative: "
- `Ride3ProIndexedTraceContext startHourOpen(Ride3ProHourKey hourKey, Integer reportedFileCount, int lastFileIndex, boolean cached, boolean latest)`  L36
    - 体内字面量："hourKey"
- `void finishHourOpen(Ride3ProIndexedTraceContext context, Ride3ProHourKey hourKey, Ride3ProIndexedVisibilityOutcome outcome, int itemCount)`  L43
    - 体内字面量："context" · "hourKey" · "outcome" · "visible item count must not be negative: "
- `Ride3ProIndexedTraceContext newContext()`  L53
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedScanOutcome`
L11 · [enum] public Ride3ProIndexedScanOutcome · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScanOutcome.java`
注解：

枚举常量（3）：
- `LOADED()`  L12
- `NO_VALID_RECORDINGS()`  L13
- `FAILURE()`  L14

方法（1）：
- `EnumEntries<Ride3ProIndexedScanOutcome> getEntries()`  L18
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedScreen`
L11 · [enum] public Ride3ProIndexedScreen · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedScreen.java`
注解：

枚举常量（2）：
- `STORAGE_ENTRY()`  L12
- `INDEXED_STORAGE()`  L13

方法（1）：
- `EnumEntries<Ride3ProIndexedScreen> getEntries()`  L17
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedTraceContext`
L9 · [class] public final Ride3ProIndexedTraceContext · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedTraceContext.java`
注解：

字段/常量（2）：
- `long startedAtElapsedMs`  L10
- `long traceId`  L11

方法（10）：
- `Ride3ProIndexedTraceContext copy$default(Ride3ProIndexedTraceContext ride3ProIndexedTraceContext, long j, long j2, int i, Object obj)`  L13
- `long getTraceId()`  L24
- `long getStartedAtElapsedMs()`  L29
- `Ride3ProIndexedTraceContext copy(long traceId, long startedAtElapsedMs)`  L33
- `boolean equals(Object other)`  L37
- `int hashCode()`  L48
- `String toString()`  L52
    - 体内字面量："Ride3ProIndexedTraceContext(traceId=" · ", startedAtElapsedMs=" · ")"
- `public Ride3ProIndexedTraceContext(long j, long j2)`  L56
    - 体内字面量："Ride3Pro indexed trace id must not be negative: " · "Ride3Pro indexed trace start time must not be negative: "
- `long getTraceId()`  L67
- `long getStartedAtElapsedMs()`  L71
### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedVisibilityOutcome`
L11 · [enum] public Ride3ProIndexedVisibilityOutcome · `com/tuwinsmart/tuwin/core/util/logging/Ride3ProIndexedVisibilityOutcome.java`
注解：

枚举常量（4）：
- `CONTENT()`  L12
- `EMPTY()`  L13
- `ERROR()`  L14
- `LEGACY_ROUTE()`  L15

方法（1）：
- `EnumEntries<Ride3ProIndexedVisibilityOutcome> getEntries()`  L19
### `com.tuwinsmart.tuwin.core.util.logging.RuntimeLogSnapshot`
L21 · [class] public final RuntimeLogSnapshot · `com/tuwinsmart/tuwin/core/util/logging/RuntimeLogSnapshot.java`

字段/常量（3）：
- `byte[] bArr = new byte[8192]`  L66
- `int i = 0`  L111
- `int i2 = i + 1`  L113

方法（10）：
- `private RuntimeLogSnapshot()`  L22
- `File[] selectLogFiles(File file)`  L25
- `boolean accept(File file2, String str)`  L28 @Override
- `long applyAsLong(Object obj)`  L37 @Override
- `boolean lambda$selectLogFiles$0(File file, String str)`  L44
    - 体内字面量："LOG" · ".txt"
- `File create(File file, File file2, String str, Map<String, String> map)`  L48
    - 体内字面量："Unable to create diagnostic directory: " · "diagnostic_" · ".zip" · "diagnostic_id" · "log_file_count" · "crash_file_count"
- `boolean test(Object obj)`  L59 @Override
    - 体内字面量："manifest.json"
- `void writeEntry(ZipOutputStream zipOutputStream, String str, byte[] bArr)`  L103
- `String manifestJson(Map<String, String> map)`  L109
    - 体内字面量："{\n"
- `String escape(String str)`  L123
    - 体内字面量："\\" · "\\\\" · "\"" · "\\\"" · "\r" · "\\\r" · "\n" · "\\\n"
### `com.tuwinsmart.tuwin.core.util.logging.Timber`
L4 · [class] public Timber · `com/tuwinsmart/tuwin/core/util/logging/Timber.java`

字段/常量（3）：
- `String CRASH = "crash"`  L5
- `String ONLY_US = "only_us"`  L6
- `String RUNTIME = "runtime"`  L7

方法（27）：
- `void m502v(String str, Object... objArr)`  L10
- `void m504v(Throwable th, String str, Object... objArr)`  L15
- `void m503v(Throwable th)`  L20
- `void m493d(String str, Object... objArr)`  L25
- `void m495d(Throwable th, String str, Object... objArr)`  L30
- `void m494d(Throwable th)`  L35
- `void m499i(String str, Object... objArr)`  L40
- `void m501i(Throwable th, String str, Object... objArr)`  L45
- `void m500i(Throwable th)`  L50
- `void m505w(String str, Object... objArr)`  L55
- `void m507w(Throwable th, String str, Object... objArr)`  L60
- `void m506w(Throwable th)`  L65
- `void m496e(String str, Object... objArr)`  L70
- `void m498e(Throwable th, String str, Object... objArr)`  L75
- `void m497e(Throwable th)`  L80
- `void wtf(String str, Object... objArr)`  L84
- `void wtf(Throwable th, String str, Object... objArr)`  L88
- `void wtf(Throwable th)`  L92
- `void log(int i, String str, Object... objArr)`  L96
- `void log(int i, Throwable th, String str, Object... objArr)`  L100
- `void log(int i, Throwable th)`  L104
- `TimberImpl tag(String str)`  L108
- `TimberImpl hiddenInPrint()`  L112
- `TimberImpl isWriteFile(boolean z)`  L116
- `void plant(TimberInterface.Tree tree)`  L120
- `void plant(TimberInterface.Tree... treeArr)`  L124
- `void uprootAll()`  L128
### `com.tuwinsmart.tuwin.core.util.logging.TimberImpl`
L8 · [class] public TimberImpl · extends `TimberInterface.Tree` · `com/tuwinsmart/tuwin/core/util/logging/TimberImpl.java`

字段/常量（2）：
- `TimberInterface.Tree[] treeArray = new TimberInterface.Tree[0]`  L11
- `List<TimberInterface.Tree> listUnmodifiableList`  L242

方法（31）：
- `void mo517v(String str, Object... objArr)`  L15 @Override
- `void mo519v(Throwable th, String str, Object... objArr)`  L23 @Override
- `void mo518v(Throwable th)`  L31 @Override
- `void mo508d(String str, Object... objArr)`  L39 @Override
- `void mo510d(Throwable th, String str, Object... objArr)`  L47 @Override
- `void mo509d(Throwable th)`  L55 @Override
- `void mo514i(String str, Object... objArr)`  L63 @Override
- `void mo516i(Throwable th, String str, Object... objArr)`  L71 @Override
- `void mo515i(Throwable th)`  L79 @Override
- `void mo520w(String str, Object... objArr)`  L87 @Override
- `void mo522w(Throwable th, String str, Object... objArr)`  L95 @Override
- `void mo521w(Throwable th)`  L103 @Override
- `void mo511e(String str, Object... objArr)`  L111 @Override
- `void mo513e(Throwable th, String str, Object... objArr)`  L119 @Override
- `void mo512e(Throwable th)`  L127 @Override
- `void wtf(String str, Object... objArr)`  L134 @Override
- `void wtf(Throwable th, String str, Object... objArr)`  L141 @Override
- `void wtf(Throwable th)`  L148 @Override
- `void log(int i, String str, Object... objArr)`  L155 @Override
- `void log(int i, Throwable th, String str, Object... objArr)`  L162 @Override
- `void log(int i, Throwable th)`  L169 @Override
- `void log(int i, String str, Boolean bool, String str2, Throwable th)`  L176 @Override
- `TimberImpl getInstance()`  L182
- `TimberImpl tag(String str)`  L186
- `TimberImpl isWrite(boolean z)`  L193
- `void plant(TimberInterface.Tree tree)`  L200
    - 体内字面量："Cannot plant Timber into itself."
- `void plant(TimberInterface.Tree... treeArr)`  L210
    - 体内字面量："trees contained null" · "Cannot plant Timber into itself."
- `void uproot(TimberInterface.Tree tree)`  L225
    - 体内字面量："Cannot uproot tree which is not planted: "
- `void uprootAll()`  L234
- `List<TimberInterface.Tree> forest()`  L241
- `int treeCount()`  L249
### `com.tuwinsmart.tuwin.core.util.logging.TimberInterface`
L17 · [class] public abstract TimberInterface · `com/tuwinsmart/tuwin/core/util/logging/TimberInterface.java`

字段/常量（2）：
- `int MAX_STACK_TRACE_LENGTH = 10240`  L18
- `String TAG = "TUWIN_LOG"`  L19

方法（1）：
- `private TimberInterface()`  L21
### `com.tuwinsmart.tuwin.core.util.logging.TimberInterface$DebugTree`
L250 · [class] public static DebugTree · extends `Tree` · `com/tuwinsmart/tuwin/core/util/logging/TimberInterface.java`

字段/常量（4）：
- `int MAX_LOG_LENGTH = 4000`  L251
- `int MAX_TAG_LENGTH = 23`  L252
- `int iMin`  L281
- `int i2 = 0`  L292

方法（3）：
- `String getTag()`  L257 @Override
- `String createStackElementTag(StackTraceElement stackTraceElement)`  L270
- `void log(int i, String str, Boolean bool, String str2, Throwable th)`  L280 @Override
### `com.tuwinsmart.tuwin.core.util.logging.TimberInterface$Tree`
L25 · [class] public static abstract Tree · `com/tuwinsmart/tuwin/core/util/logging/TimberInterface.java`

字段/常量（1）：
- `String str2`  L165

方法（33）：
- `boolean isLoggable(int i)`  L31 @Deprecated
- `void log(int i, String str, Boolean bool, String str2, Throwable th)`  L35
- `String getTag()`  L37
- `void setTag(String str)`  L45
- `Boolean getWrite()`  L49
- `void setWrite(boolean z)`  L57
- `void mo517v(String str, Object... objArr)`  L62
- `void mo519v(Throwable th, String str, Object... objArr)`  L67
- `void mo518v(Throwable th)`  L72
- `void mo508d(String str, Object... objArr)`  L77
- `void mo510d(Throwable th, String str, Object... objArr)`  L82
- `void mo509d(Throwable th)`  L87
- `void mo514i(String str, Object... objArr)`  L92
- `void mo516i(Throwable th, String str, Object... objArr)`  L97
- `void mo515i(Throwable th)`  L102
- `void mo520w(String str, Object... objArr)`  L107
- `void mo522w(Throwable th, String str, Object... objArr)`  L112
- `void mo521w(Throwable th)`  L117
- `void mo511e(String str, Object... objArr)`  L122
- `void mo513e(Throwable th, String str, Object... objArr)`  L127
- `void mo512e(Throwable th)`  L132
- `void wtf(String str, Object... objArr)`  L136
- `void wtf(Throwable th, String str, Object... objArr)`  L140
- `void wtf(Throwable th)`  L144
- `void log(int i, String str, Object... objArr)`  L148
- `void log(int i, Throwable th, String str, Object... objArr)`  L152
- `void log(int i, Throwable th)`  L156
- `boolean isLoggable(String str, int i)`  L160
- `void prepareLog(int i, Throwable th, String str, Object... objArr)`  L164
- `String getLogLevel(int i)`  L189
    - 体内字面量："[V]" · "[D]" · "[I]" · "[W]" · "[E]" · "[WTF]" · "[" · "]"
- `String formatMessage(String str, Object... objArr)`  L211
- `String getStackTraceString(Throwable th)`  L215
    - 体内字面量："null" · "[StackOverflowError (stack trace may be truncated)]\n"
- `String truncateStackTrace(String str)`  L245
    - 体内字面量："\n...[stack trace truncated due to length limit (10240 chars)]"
### `com.tuwinsmart.tuwin.core.util.logging.WriteRuntimeLogTree`
L23 · [class] public WriteRuntimeLogTree · extends `TimberInterface.DebugTree` · `com/tuwinsmart/tuwin/core/util/logging/WriteRuntimeLogTree.java`

字段/常量（8）：
- `long MAX_LOG_FILE_BYTES = 2097152`  L25
- `int MAX_RETAINED_LOG_FILES = 7`  L26
- `int MAX_RETAINED_SNAPSHOTS = 3`  L27
- `String TAG = "TUWIN_LOG"`  L28
- `File dirFile`  L29
- `ExecutorService executor`  L30
- `ExecutorService executorService = this.executor`  L77
- `ExecutorService executorService = this.executor`  L90

方法（21）：
- `void lambda$flush$0()`  L32
- `private WriteRuntimeLogTree()`  L35
- `WriteRuntimeLogTree getInstance()`  L42
- `void init()`  L46
    - 体内字面量："/CLOG"
- `void init(File file)`  L50
- `void log(int i, String str, Boolean bool, String str2, Throwable th)`  L63 @Override
    - 体内字面量："WriteRuntimeLogTree æªåå§åï¼è·³è¿æä»¶æ¥å¿" · "unknown" · "[session=" · "][source=" · "]"
- `void flush()`  L76
- `void run()`  L83 @Override
- `File createSnapshot(final String str)`  L89
- `Object call()`  L97 @Override
- `File lambda$createSnapshot$1(File file, String str)`  L104
    - 体内字面量："session_id" · "app_version" · "app_version_code" · "android_version" · "device_model" · " "
- `File getLogFile()`  L116
    - 体内字面量："/CLOG" · "LOG" · "yyyyMMdd" · ".txt"
- `void rotateIfNeeded(File file)`  L127
    - 体内字面量：".txt" · "_" · "HHmmss" · ".txt" · "è¿è¡æ¶æ¥å¿è½®è½¬å¤±è´¥: "
- `boolean lambda$pruneOldLogs$2(File file, String str)`  L137
    - 体内字面量："LOG" · ".txt"
- `void pruneOldLogs(File file)`  L142
- `boolean accept(File file2, String str)`  L145 @Override
- `int compare(Object obj, Object obj2)`  L155 @Override
    - 体内字面量："è¿è¡æ¶æ¥å¿æ¸çå¤±è´¥: "
- `boolean lambda$pruneOldSnapshots$4(File file, String str)`  L167
    - 体内字面量："diagnostic_" · ".zip"
- `void pruneOldSnapshots(File file)`  L171
- `boolean accept(File file2, String str)`  L174 @Override
- `int compare(Object obj, Object obj2)`  L184 @Override
    - 体内字面量："è¯æ­å¿«ç§æ¸çå¤±è´¥: "
### `com.tuwinsmart.tuwin.core.util.logging.WriteRuntimeLogTree$WriteLogRunnable`
L196 · [class] public static WriteLogRunnable · implements `Runnable` · `com/tuwinsmart/tuwin/core/util/logging/WriteRuntimeLogTree.java`

字段/常量（3）：
- `File dirFile`  L197
- `File file`  L198
- `String message`  L199

方法（2）：
- `public WriteLogRunnable(File file, String str, File file2)`  L201
- `void run()`  L208 @Override
    - 体内字面量："\n" · "åå¥è¿è¡æ¶æ¥å¿å¤±è´¥"
### `com.tuwinsmart.tuwin.core.util.M3OtaVersionPolicy`
L18 · [class] public final M3OtaVersionPolicy · `com/tuwinsmart/tuwin/core/util/M3OtaVersionPolicy.java`
注解：

字段/常量（3）：
- `String BOARD_VERSION = "M3"`  L19
- `String str = string`  L31
- `Map<String, String> map = monthValues`  L34

方法（2）：
- `private M3OtaVersionPolicy()`  L23
- `String normalize(String version)`  L26
### `com.tuwinsmart.tuwin.core.util.M3SettingNameMapper`
L15 · [class] public final M3SettingNameMapper · `com/tuwinsmart/tuwin/core/util/M3SettingNameMapper.java`
注解：

方法（3）：
- `private M3SettingNameMapper()`  L19
- `Integer getStringResourceId(String name)`  L22
    - 体内字面量："name"
- `boolean isMapped(String name)`  L27
    - 体内字面量："name"
### `com.tuwinsmart.tuwin.core.util.M3SettingValueMapper`
L23 · [class] public final M3SettingValueMapper · `com/tuwinsmart/tuwin/core/util/M3SettingValueMapper.java`
注解：

字段/常量（20）：
- `MatchResult matchResultMatchEntire`  L106
- `List<String> groupValues`  L107
- `String str`  L108
- `List<String> groupValues`  L119
- `List<String> groupValues2`  L120
- `List<String> groupValues3`  L121
- `String str`  L122
- `Integer intOrNull`  L123
- `List<String> groupValues4`  L124
- `String str2`  L125
- `Integer intOrNull2`  L126
- `List<String> groupValues5`  L127
- `String str3`  L128
- `Integer intOrNull3`  L129
- `int i = 2`  L132
- `List list = null`  L133
- `Object[] objArr = 0`  L134
- `String str4 = value`  L138
- `String str7 = str5`  L156
- `String str10 = str8`  L166

方法（4）：
- `private M3SettingValueMapper()`  L33
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/util/M3SettingValueMapper$LocalizedValue;" · "stringResId" · "formatArgs" · "(ILjava/util/List;)V" · "getFormatArgs" · "()Ljava/util/List;" · "getStringResId" · "()I" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
- `String getSettingSpecificDisplayValue(String settingName, String value)`  L105
- `LocalizedValue getLocalizedValue(String value)`  L118
- `boolean isMapped(String value)`  L174
    - 体内字面量："value"
### `com.tuwinsmart.tuwin.core.util.M3SettingValueMapper$LocalizedValue`
L38 · [class] public static final LocalizedValue · `com/tuwinsmart/tuwin/core/util/M3SettingValueMapper.java`
注解：

字段/常量（2）：
- `List<Object> formatArgs`  L39
- `int stringResId`  L40

方法（11）：
- `LocalizedValue copy$default(LocalizedValue localizedValue, int i, List list, int i2, Object obj)`  L43
- `int getStringResId()`  L54
- `List<Object> component2()`  L58
- `LocalizedValue copy(int stringResId, List<? extends Object> formatArgs)`  L62
    - 体内字面量："formatArgs"
- `boolean equals(Object other)`  L67
- `int hashCode()`  L78
- `String toString()`  L82
    - 体内字面量："LocalizedValue(stringResId=" · ", formatArgs=" · ")"
- `public LocalizedValue(int i, List<? extends Object> formatArgs)`  L86
    - 体内字面量："formatArgs"
- `int getStringResId()`  L92
- ` LocalizedValue(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L96
- `List<Object> getFormatArgs()`  L100
### `com.tuwinsmart.tuwin.core.util.M3ThumbnailCache`
L22 · [class] public final M3ThumbnailCache · `com/tuwinsmart/tuwin/core/util/M3ThumbnailCache.java`
注解：

字段/常量（6）：
- `String CACHE_DIR_NAME = "m3_thumbnails"`  L23
- `String JPEG_EXTENSION = ".jpg"`  L24
- `int JPEG_QUALITY = 85`  L25
- `Lazy cacheDir`  L28
- `Context context`  L29
- `long length = 0`  L109

方法（8）：
- `public M3ThumbnailCache(Context context)`  L31
    - 体内字面量："context"
- `File invoke()`  L41 @Override
    - 体内字面量："m3_thumbnails"
- `File getCacheDir()`  L51
- `Bitmap get(String fileName)`  L55
    - 体内字面量："fileName"
- `boolean put(String fileName, Bitmap bitmap)`  L69
    - 体内字面量："fileName" · "bitmap"
- `File getCacheFile(String fileName)`  L93
    - 体内字面量："fileName" · "/" · "_"
- `void clearAll()`  L98
- `long getCacheSize()`  L107
### `com.tuwinsmart.tuwin.core.util.network.NetworkManager`
L27 · [class] public NetworkManager · `com/tuwinsmart/tuwin/core/util/network/NetworkManager.java`

字段/常量（12）：
- `Network activeMobileNetwork`  L28
- `Network activeWifiNetwork`  L29
- `boolean registered`  L30
- `NetworkTopologyMonitor.Listener topologyListener`  L31
- `NetworkTopologyMonitor topologyMonitor`  L32
- `boolean z = true`  L74
- `boolean z5 = zEquals && currentSSID != null`  L79
- `Network network = null`  L115
- `Network network2 = null`  L116
- `String currentSSID`  L135
- `Network network = this.activeWifiNetwork`  L148
- `int i = 0`  L165

方法（14）：
- `public NetworkManager(Context context)`  L34
- `public NetworkManager(Context context, NetworkTopologyMonitor networkTopologyMonitor)`  L38
- `void onTopologyChanged(TopologyChange topologyChange)`  L42 @Override
- `void onTopologyChanged(TopologyChange topologyChange)`  L54
    - 体内字面量："LOST" · "WifiChangeReceiver" · "topology change=" · "AVAILABLE"
- `void handleLost(ObservedNetwork observedNetwork)`  L69
- `void findBestAvailableNetwork()`  L107
- `long applyAsLong(Object obj)`  L111 @Override
- `boolean isKnownDeviceWifi()`  L134
- `void requestUpgradeDownloadCheck()`  L143
- `Network getBestNetwork()`  L147
- `Network getMobileNetwork()`  L152
- `void unregister()`  L156
- `boolean hasMultipleWifi()`  L164
- `List<Network> snapshotNetworks()`  L174
### `com.tuwinsmart.tuwin.core.util.network.NetworkUtil`
L23 · [class] public final NetworkUtil · `com/tuwinsmart/tuwin/core/util/network/NetworkUtil.java`
注解：

字段/常量（8）：
- `Unit unit`  L102
- `Gloading.Holder holder2 = holder`  L125
- `Gloading.Holder holder2 = holder`  L144
- `Unit unit`  L177
- `Gloading.Holder holder2 = holder`  L199
- `Gloading.Holder holder2 = holder`  L218
- `Gloading.Holder holder3 = holder`  L222
- `Unit unit`  L249

方法（28）：
- `private NetworkUtil()`  L26
- `void bind$default(NetworkUtil networkUtil, Observable observable, NetworkListener networkListener, boolean z, BaseActivity baseActivity, int i, Object obj)`  L29
- `void bind(Observable<HashMap<String, String>> observable, final NetworkListener listener, boolean needAddDisposable, BaseActivity ownerActivity)`  L39
    - 体内字面量："observable" · "listener"
- `Unit invoke(HashMap<String, String> map)`  L49 @Override
- `void invoke2(HashMap<String, String> map)`  L55
    - 体内字面量："Error in onSuccess callback: "
- `void accept(Object obj)`  L65 @Override
- `void onErrorMsg(String errorMsg)`  L70 @Override
    - 体内字面量："Error in onError callback: "
- `void bind$lambda$0(Function1 tmp0, Object obj)`  L89
    - 体内字面量："$tmp0"
- `void bind$default(NetworkUtil networkUtil, Observable observable, Gloading.Holder holder, NetworkListener networkListener, int i, Object obj)`  L94
- `void bind(Observable<HashMap<String, String>> observable, final Gloading.Holder holder, final NetworkListener listener)`  L101
- `Unit invoke(HashMap<String, String> map)`  L116 @Override
- `void invoke2(HashMap<String, String> map)`  L122
- `void accept(Object obj)`  L136 @Override
- `void onErrorMsg(String errorMsg)`  L141 @Override
- `void bind$lambda$1(Function1 tmp0, Object obj)`  L164
    - 体内字面量："$tmp0"
- `void bind$default(NetworkUtil networkUtil, String str, Observable observable, Gloading.Holder holder, NetworkListener networkListener, int i, Object obj)`  L169
- `void bind(String loadingMsg, Observable<HashMap<String, String>> observable, final Gloading.Holder holder, final NetworkListener listener)`  L176
- `Unit invoke(HashMap<String, String> map)`  L191 @Override
- `void invoke2(HashMap<String, String> map)`  L197
- `void accept(Object obj)`  L211 @Override
- `void onErrorMsg(String errorMsg)`  L216 @Override
- `void bind$lambda$3(Function1 tmp0, Object obj)`  L243
    - 体内字面量："$tmp0"
- `void bind(String loadingMsg, Observable<HashMap<String, String>> observable, final NetworkListener listener)`  L248
- `Unit invoke(HashMap<String, String> map)`  L260 @Override
- `void invoke2(HashMap<String, String> map)`  L266
    - 体内字面量："Error in onSuccess callback: "
- `void accept(Object obj)`  L276 @Override
- `void onErrorMsg(String errorMsg)`  L281 @Override
    - 体内字面量："Error in onError callback: "
- `void bind$lambda$5(Function1 tmp0, Object obj)`  L300
    - 体内字面量："$tmp0"
### `com.tuwinsmart.tuwin.core.util.OtaCurrentQueryIdentity`
L17 · [class] public final OtaCurrentQueryIdentity · `com/tuwinsmart/tuwin/core/util/OtaCurrentQueryIdentity.java`
注解：

字段/常量（3）：
- `String normalizedBoardVersion`  L21
- `String normalizedCurrentVersion`  L22
- `String normalizedModel`  L23

方法（12）：
- `OtaCurrentQueryIdentity copy$default(OtaCurrentQueryIdentity otaCurrentQueryIdentity, String str, String str2, String str3, int i, Object obj)`  L25
- `String getNormalizedCurrentVersion()`  L39
- `String getNormalizedBoardVersion()`  L44
- `String getNormalizedModel()`  L49
- `OtaCurrentQueryIdentity copy(String normalizedCurrentVersion, String normalizedBoardVersion, String normalizedModel)`  L53
    - 体内字面量："normalizedCurrentVersion" · "normalizedBoardVersion" · "normalizedModel"
- `boolean equals(Object other)`  L60
- `int hashCode()`  L71
- `String toString()`  L75
    - 体内字面量："OtaCurrentQueryIdentity(normalizedCurrentVersion=" · ", normalizedBoardVersion=" · ", normalizedModel=" · ")"
- `public OtaCurrentQueryIdentity(String normalizedCurrentVersion, String normalizedBoardVersion, String normalizedModel)`  L79
    - 体内字面量："normalizedCurrentVersion" · "normalizedBoardVersion" · "normalizedModel"
- `String getNormalizedCurrentVersion()`  L88
- `String getNormalizedBoardVersion()`  L92
- `String getNormalizedModel()`  L96
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/util/OtaCurrentQueryIdentity$Companion;" · "()V" · "Lcom/tuwinsmart/tuwin/core/util/OtaCurrentQueryIdentity;" · "query" · "Lcom/tuwinsmart/tuwin/core/util/OtaQuery;" · "app_release_64"
### `com.tuwinsmart.tuwin.core.util.OtaCurrentQueryIdentity$Companion`
L102 · [class] public static final Companion · `com/tuwinsmart/tuwin/core/util/OtaCurrentQueryIdentity.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L103
- `private Companion()`  L107
- `OtaCurrentQueryIdentity from(OtaQuery query)`  L110
    - 体内字面量："query" · "toUpperCase(...)" · "[^A-Za-z0-9]" · "toUpperCase(...)" · "[^A-Za-z0-9]" · "toUpperCase(...)"
### `com.tuwinsmart.tuwin.core.util.OtaDeviceLifecycle`
L11 · [interface] public OtaDeviceLifecycle · `com/tuwinsmart/tuwin/core/util/OtaDeviceLifecycle.java`
注解：

方法（1）：
- `void onDevicesChanged(List<ConnectedDevice> devices)`  L12
### `com.tuwinsmart.tuwin.core.util.OtaDeviceQuery`
L12 · [class] public final OtaDeviceQuery · `com/tuwinsmart/tuwin/core/util/OtaDeviceQuery.java`
注解：

字段/常量（3）：
- `DeviceType deviceType`  L13
- `OtaQuery query`  L14
- `DeviceType deviceType = this.deviceType`  L53

方法（10）：
- `OtaDeviceQuery copy$default(OtaDeviceQuery otaDeviceQuery, DeviceType deviceType, OtaQuery otaQuery, int i, Object obj)`  L16
- `DeviceType getDeviceType()`  L27
- `OtaQuery getQuery()`  L32
- `OtaDeviceQuery copy(DeviceType deviceType, OtaQuery query)`  L36
    - 体内字面量："query"
- `boolean equals(Object other)`  L41
- `int hashCode()`  L52
- `String toString()`  L57
    - 体内字面量："OtaDeviceQuery(deviceType=" · ", query=" · ")"
- `public OtaDeviceQuery(DeviceType deviceType, OtaQuery query)`  L61
    - 体内字面量："query"
- `DeviceType getDeviceType()`  L67
- `OtaQuery getQuery()`  L71
### `com.tuwinsmart.tuwin.core.util.OtaDownloadTask`
L12 · [class] final OtaDownloadTask · `com/tuwinsmart/tuwin/core/util/OtaDownloadTask.java`
注解：

字段/常量（10）：
- `OtaDeviceQuery candidate`  L13
- `String downloadTag`  L14
- `String expectedFileName`  L15
- `long expectedFileSize`  L16
- `OtaPackageIdentity identity`  L17
- `Function0<Unit> onFinished`  L18
- `String targetUrl`  L19
- `String targetVersion`  L20
- `String updateLog`  L21
- `String str = this.updateLog`  L79

方法（21）：
- `OtaDeviceQuery getCandidate()`  L24
- `String getTargetVersion()`  L29
- `String getTargetUrl()`  L34
- `String getExpectedFileName()`  L39
- `long getExpectedFileSize()`  L44
- `String getUpdateLog()`  L49
- `Function0<Unit> component7()`  L53
- `OtaDownloadTask copy(OtaDeviceQuery candidate, String targetVersion, String targetUrl, String expectedFileName, long expectedFileSize, String updateLog, Function0<Unit> onFinished)`  L57
    - 体内字面量："candidate" · "targetVersion" · "targetUrl" · "expectedFileName" · "onFinished"
- `boolean equals(Object other)`  L66
- `int hashCode()`  L77
- `String toString()`  L83
    - 体内字面量："OtaDownloadTask(candidate=" · ", targetVersion=" · ", targetUrl=" · ", expectedFileName=" · ", expectedFileSize=" · ", updateLog=" · ", onFinished=" · ")"
- `public OtaDownloadTask(OtaDeviceQuery candidate, String targetVersion, String targetUrl, String expectedFileName, long j, String str, Function0<Unit> onFinished)`  L87
    - 体内字面量："candidate" · "targetVersion" · "targetUrl" · "expectedFileName" · "onFinished" · "ota_"
- `OtaDeviceQuery getCandidate()`  L105
- `String getTargetVersion()`  L109
- `String getTargetUrl()`  L113
- `String getExpectedFileName()`  L117
- `long getExpectedFileSize()`  L121
- `String getUpdateLog()`  L125
- `Function0<Unit> getOnFinished()`  L129
- `OtaPackageIdentity getIdentity()`  L133
- `String getDownloadTag()`  L137
### `com.tuwinsmart.tuwin.core.util.OtaExpectedFileSizePolicy`
L9 · [class] public final OtaExpectedFileSizePolicy · `com/tuwinsmart/tuwin/core/util/OtaExpectedFileSizePolicy.java`
注解：

方法（2）：
- `private OtaExpectedFileSizePolicy()`  L12
- `Long resolve(Long expectedBeforeDownload, Long progressTotalSize)`  L15
### `com.tuwinsmart.tuwin.core.util.OtaPackageFilePolicy`
L12 · [class] public final OtaPackageFilePolicy · `com/tuwinsmart/tuwin/core/util/OtaPackageFilePolicy.java`
注解：

方法（4）：
- `private OtaPackageFilePolicy()`  L15
- `File downloadDirectory(File baseDir, OtaQuery query, String targetVersion)`  L18
    - 体内字面量："baseDir" · "query" · "targetVersion"
- `File findDownloadedPackage(File baseDir, OtaQuery query, String targetVersion, String expectedFileName, long expectedFileSize)`  L25
    - 体内字面量："baseDir" · "query" · "targetVersion" · "expectedFileName" · "Expected OTA filename is blank" · "Expected OTA file size must be positive"
- `boolean isExpectedPackage(File file, String expectedFileName, long expectedFileSize)`  L46
    - 体内字面量："file" · "expectedFileName"
### `com.tuwinsmart.tuwin.core.util.OtaPackageGroupPolicy`
L19 · [class] public final OtaPackageGroupPolicy · `com/tuwinsmart/tuwin/core/util/OtaPackageGroupPolicy.java`
注解：

字段/常量（15）：
- `String file`  L32
- `File file2 = null`  L39
- `boolean z`  L51
- `OtaPackageGroupPolicy otaPackageGroupPolicy = INSTANCE`  L60
- `OtaPackageGroupPolicy otaPackageGroupPolicy2 = INSTANCE`  L74
- `OtaPackageGroupPolicy otaPackageGroupPolicy = INSTANCE`  L100
- `String newVersion`  L114
- `Object obj = null`  L115
- `OtaPackageGroupPolicy otaPackageGroupPolicy = INSTANCE`  L129
- `DeviceType deviceType = null`  L150
- `String name`  L183
- `String strSubstringAfterLast$default`  L184
- `String strSubstringBefore$default = null`  L185
- `String strSubstringAfterLast$default`  L208
- `String strSubstringBefore$default`  L209

方法（12）：
- `private OtaPackageGroupPolicy()`  L22
- `boolean hasFreshPackage(List<LocalUpgradeBean> beans, OtaQuery targetQuery, String latestVersion, String latestUrl)`  L25
    - 体内字面量："beans" · "targetQuery"
- `File findFreshPackage(List<LocalUpgradeBean> beans, OtaQuery targetQuery, String latestVersion, String latestUrl, File baseDir, String expectedFileName, long expectedFileSize)`  L31
- `void recordAvailableUpdate(List<LocalUpgradeBean> beans, OtaQuery targetQuery, String latestVersion, String latestUrl, String updateLog, DeviceType deviceType)`  L50
- `void applyDownloadedPackage(List<LocalUpgradeBean> beans, OtaQuery targetQuery, String latestVersion, String latestUrl, String updateLog, File file, DeviceType deviceType, long fileSize)`  L80
    - 体内字面量："beans" · "targetQuery" · "file"
- `LocalUpgradeBean findFreshBean(List<LocalUpgradeBean> beans, OtaQuery targetQuery, String latestVersion, String latestUrl)`  L113
- `List<LocalUpgradeBean> findCurrentQueryBeans(List<LocalUpgradeBean> beans, OtaQuery targetQuery)`  L144
- `boolean hasUsableCachedPackage(String filePath)`  L167
- `boolean needDownloadLatest(String fileName, String url)`  L182
- `String expectedPackageFileName(String url)`  L207
- `Ride3ProFirmwareMeta resolveRide3ProFirmwareMeta(OtaQuery targetQuery, String latestVersion, String latestUrl, File file, DeviceType deviceType)`  L216
    - 体内字面量："R3Pro"
- `void applyUpdateMetadata(LocalUpgradeBean bean, OtaQuery targetQuery, String latestVersion, String updateLog, Ride3ProFirmwareMeta firmwareMeta, DeviceType deviceType)`  L227
### `com.tuwinsmart.tuwin.core.util.OtaPackageIdentity`
L20 · [class] public final OtaPackageIdentity · `com/tuwinsmart/tuwin/core/util/OtaPackageIdentity.java`
注解：

字段/常量（4）：
- `String MODEL_NONE = "MODEL_NONE"`  L24
- `String boardVersion`  L25
- `String model`  L26
- `String targetVersion`  L27

方法（13）：
- `OtaPackageIdentity copy$default(OtaPackageIdentity otaPackageIdentity, String str, String str2, String str3, int i, Object obj)`  L29
- `String getModel()`  L43
- `String getBoardVersion()`  L48
- `String getTargetVersion()`  L53
- `OtaPackageIdentity copy(String model, String boardVersion, String targetVersion)`  L57
    - 体内字面量："model" · "boardVersion" · "targetVersion"
- `boolean equals(Object other)`  L64
- `int hashCode()`  L75
- `String toString()`  L79
    - 体内字面量："OtaPackageIdentity(model=" · ", boardVersion=" · ", targetVersion=" · ")"
- `public OtaPackageIdentity(String model, String boardVersion, String targetVersion)`  L83
    - 体内字面量："model" · "boardVersion" · "targetVersion"
- `String getModel()`  L92
- `String getBoardVersion()`  L96
- `String getTargetVersion()`  L100
- `String getDirectoryName()`  L104
    - 体内字面量："_" · "Lcom/tuwinsmart/tuwin/core/util/OtaPackageIdentity$Companion;" · "()V" · "Lcom/tuwinsmart/tuwin/core/util/OtaPackageIdentity;" · "bean" · "Lcom/tuwinsmart/tuwin/core/util/LocalUpgradeBean;" · "query" · "Lcom/tuwinsmart/tuwin/core/util/OtaQuery;" · "targetVersion" · "normalizePart" · "value" · "app_release_64"
### `com.tuwinsmart.tuwin.core.util.OtaPackageIdentity$Companion`
L110 · [class] public static final Companion · `com/tuwinsmart/tuwin/core/util/OtaPackageIdentity.java`
注解：

字段/常量（4）：
- `Object objM3074constructorimpl`  L129
- `Result.Companion companion = Result.INSTANCE`  L148
- `Companion companion2 = this`  L149
- `Result.Companion companion3 = Result.INSTANCE`  L152

方法（5）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L111
- `private Companion()`  L115
- `OtaPackageIdentity from(OtaQuery query, String targetVersion)`  L118
    - 体内字面量："query" · "targetVersion"
- `OtaPackageIdentity from(LocalUpgradeBean bean)`  L128
- `String normalizePart(String value)`  L158
    - 体内字面量："[^A-Za-z0-9]" · "toUpperCase(...)" · "OTA package identity contains blank part"
### `com.tuwinsmart.tuwin.core.util.OtaPromptThrottlePolicy`
L13 · [class] public final OtaPromptThrottlePolicy · `com/tuwinsmart/tuwin/core/util/OtaPromptThrottlePolicy.java`
注解：

字段/常量（5）：
- `Set<OtaPackageIdentity> set = activePrompts`  L26
- `Unit unit = Unit.INSTANCE`  L40
- `Unit unit = Unit.INSTANCE`  L51
- `Unit unit = Unit.INSTANCE`  L60
- `Unit unit = Unit.INSTANCE`  L68

方法（6）：
- `private OtaPromptThrottlePolicy()`  L18
- `boolean tryAcquire(OtaQuery query, String targetVersion)`  L21
    - 体内字面量："query" · "targetVersion"
- `void release(OtaQuery query, String targetVersion)`  L35
    - 体内字面量："query" · "targetVersion"
- `void suppress(OtaQuery query, String targetVersion)`  L44
    - 体内字面量："query" · "targetVersion"
- `void clearSuppression(OtaQuery query, String targetVersion)`  L55
    - 体内字面量："query" · "targetVersion"
- `void reset()`  L64
### `com.tuwinsmart.tuwin.core.util.OtaQuery`
L11 · [class] public final OtaQuery · `com/tuwinsmart/tuwin/core/util/OtaQuery.java`
注解：

字段/常量（4）：
- `String boardVersion`  L12
- `String model`  L13
- `String version`  L14
- `String str = this.model`  L63

方法（12）：
- `OtaQuery copy$default(OtaQuery otaQuery, String str, String str2, String str3, int i, Object obj)`  L16
- `String getVersion()`  L30
- `String getBoardVersion()`  L35
- `String getModel()`  L40
- `OtaQuery copy(String version, String boardVersion, String model)`  L44
    - 体内字面量："version" · "boardVersion"
- `boolean equals(Object other)`  L50
- `int hashCode()`  L61
- `String toString()`  L67
    - 体内字面量："OtaQuery(version=" · ", boardVersion=" · ", model=" · ")"
- `public OtaQuery(String version, String boardVersion, String str)`  L71
    - 体内字面量："version" · "boardVersion"
- `String getVersion()`  L79
- `String getBoardVersion()`  L83
- `String getModel()`  L87
### `com.tuwinsmart.tuwin.core.util.OtaQueryPolicy`
L18 · [class] public final OtaQueryPolicy · `com/tuwinsmart/tuwin/core/util/OtaQueryPolicy.java`
注解：

字段/常量（7）：
- `String string`  L49
- `String str`  L50
- `String str2`  L51
- `DeviceType deviceType2 = DeviceType.M3`  L60
- `String string2 = M3OtaVersionPolicy.BOARD_VERSION`  L61
- `String str3 = str2`  L83
- `String str4 = str2`  L86

方法（4）：
- `private OtaQueryPolicy()`  L36
- `OtaQuery build$default(OtaQueryPolicy otaQueryPolicy, String str, String str2, DeviceType deviceType, String str3, int i, Object obj)`  L39
- `OtaQuery build(String version, String boardversion, DeviceType deviceType, String model)`  L48
- `String normalizeRide5IdentityPart(String value)`  L93
    - 体内字面量："[^A-Za-z0-9]" · "toUpperCase(...)"
### `com.tuwinsmart.tuwin.core.util.OtaQueryPolicy$WhenMappings`
L23 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/util/OtaQueryPolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L24
### `com.tuwinsmart.tuwin.core.util.OtaSerialTaskQueue`
L18 · [class] public final OtaSerialTaskQueue · `com/tuwinsmart/tuwin/core/util/OtaSerialTaskQueue.java`
注解：

字段/常量（10）：
- `T current`  L19
- `Function1<T, K> keyOf`  L20
- `ArrayDeque<T> pending`  L21
- `T t = this.current`  L32
- `ArrayDeque<T> arrayDeque = this.pending`  L34
- `T t = this.current`  L49
- `T t`  L67
- `T t = this.current`  L74
- `ArrayList arrayList`  L83
- `T t = this.current`  L86

方法（7）：
- `public OtaSerialTaskQueue(Function1<? super T, ? extends K> keyOf)`  L24
    - 体内字面量："keyOf"
- `boolean enqueue(T task)`  L30
- `T currentOrNext()`  L48
- `T currentTask()`  L62
- `T completeCurrent()`  L66
- `boolean completeCurrentIf(T task)`  L73
- `List<T> removeIf(Function1<? super T, Boolean> predicate)`  L82
### `com.tuwinsmart.tuwin.core.util.OtaVersionSeedPolicy`
L21 · [class] public final OtaVersionSeedPolicy · `com/tuwinsmart/tuwin/core/util/OtaVersionSeedPolicy.java`
注解：

字段/常量（25）：
- `LocalUpgradeBean localUpgradeBean`  L51
- `OtaVersionSeedPolicy otaVersionSeedPolicy`  L52
- `Object next`  L53
- `OtaVersionSeedPolicy otaVersionSeedPolicy2`  L54
- `List<ConnectedDevice> list = devices`  L57
- `ArrayList arrayList2 = arrayList`  L63
- `ArrayList<LocalUpgradeBean> arrayList4 = arrayList3`  L72
- `List<LocalUpgradeBean> list2 = mutableList`  L79
- `ArrayList<LocalUpgradeBean> arrayList5 = arrayList4`  L95
- `DeviceType deviceType`  L130
- `int length = deviceTypeArrValues.length`  L142
- `int i = 0`  L143
- `String string`  L192
- `String str`  L193
- `int i`  L194
- `String str2`  L195
- `String model`  L196
- `String string2`  L197
- `String str3`  L198
- `String boardversion`  L199
- `String string3`  L200
- `String model2`  L201
- `DeviceType deviceType`  L367
- `int length = deviceTypeArrValues.length`  L374
- `int i = 0`  L375

方法（7）：
- `private OtaVersionSeedPolicy()`  L47
- `List<LocalUpgradeBean> mergeFromDevices(List<LocalUpgradeBean> existing, List<ConnectedDevice> devices)`  L50
- `List<OtaDeviceQuery> activeQueries(List<ConnectedDevice> devices)`  L116
    - 体内字面量："devices"
- `OtaDeviceQuery queryFromDevice(ConnectedDevice device)`  L129
- `boolean isActive(OtaDeviceQuery candidate, List<ConnectedDevice> devices)`  L162
    - 体内字面量："candidate" · "devices"
- `LocalUpgradeBean seedFromDevice(ConnectedDevice device)`  L191
- `Pair<String, OtaCurrentQueryIdentity> identityOf(LocalUpgradeBean bean)`  L366
### `com.tuwinsmart.tuwin.core.util.OtaVersionSeedPolicy$WhenMappings`
L26 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/util/OtaVersionSeedPolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L27
### `com.tuwinsmart.tuwin.core.util.PlayUtil`
L13 · [class] public final PlayUtil · `com/tuwinsmart/tuwin/core/util/PlayUtil.java`
注解：

方法（5）：
- `private PlayUtil()`  L16
- `String getPlayUrl()`  L19
    - 体内字面量："device RTSP"
- `String getRide3ProPlayUrl()`  L23
    - 体内字面量："RIDE3PRO RTSP"
- `String authorizeRtspUrl(DeviceEndpointAuthority authority, String grantId, String sessionId, long routeRevision, String rawUrl, Integer declaredPort)`  L27
    - 体内字面量："authority" · "grantId" · "sessionId" · "rawUrl" · "toString(...)"
- `String unavailable(String kind)`  L37
    - 体内字面量："PlayUtil: " · " skipped because EndpointGrant is unavailable"
### `com.tuwinsmart.tuwin.core.util.PublicUrlPolicy`
L19 · [class] public final PublicUrlPolicy · `com/tuwinsmart/tuwin/core/util/PublicUrlPolicy.java`
注解：

字段/常量（3）：
- `String string`  L34
- `HttpUrl httpUrl`  L35
- `Set<String> set = allowedHosts`  L44

方法（6）：
- `private PublicUrlPolicy()`  L22
- `HttpUrl httpOrHttpsUrlOrNull$default(PublicUrlPolicy publicUrlPolicy, String str, Set set, int i, Object obj)`  L26
- `HttpUrl httpOrHttpsUrlOrNull(String value, Set<String> allowedHosts)`  L33
- `String canonicalHttpOrHttpsUrlOrNull$default(PublicUrlPolicy publicUrlPolicy, String str, Set set, int i, Object obj)`  L62
- `String canonicalHttpOrHttpsUrlOrNull(String value, Set<String> allowedHosts)`  L69
    - 体内字面量："allowedHosts"
- `String safeLogSource(String value)`  L78
### `com.tuwinsmart.tuwin.core.util.RecordControlDeviceTypeResolver`
L16 · [class] public final RecordControlDeviceTypeResolver · `com/tuwinsmart/tuwin/core/util/RecordControlDeviceTypeResolver.java`
注解：

字段/常量（4）：
- `Object next`  L23
- `Object next2`  L24
- `String string`  L74
- `String strRemoveSurrounding`  L75

方法（3）：
- `private RecordControlDeviceTypeResolver()`  L19
- `DeviceType resolve(String currentSsid, String globalSsid, List<ConnectedDevice> cachedDevices)`  L22
- `String normalize(String ssid)`  L73
### `com.tuwinsmart.tuwin.core.util.Ride3ProFirmwareMeta`
L13 · [class] public final Ride3ProFirmwareMeta · `com/tuwinsmart/tuwin/core/util/Ride3ProFirmwareMeta.java`
注解：

字段/常量（5）：
- `String DEFAULT_HW_VERSION = "1.1"`  L17
- `String DEFAULT_MODEL = "R3Pro"`  L18
- `String hwVersion`  L19
- `String model`  L20
- `String softwareVersion`  L21

方法（12）：
- `Ride3ProFirmwareMeta copy$default(Ride3ProFirmwareMeta ride3ProFirmwareMeta, String str, String str2, String str3, int i, Object obj)`  L23
- `String getModel()`  L37
- `String getHwVersion()`  L42
- `String getSoftwareVersion()`  L47
- `Ride3ProFirmwareMeta copy(String model, String hwVersion, String softwareVersion)`  L51
    - 体内字面量："model" · "hwVersion" · "softwareVersion"
- `boolean equals(Object other)`  L58
- `int hashCode()`  L69
- `String toString()`  L73
    - 体内字面量："Ride3ProFirmwareMeta(model=" · ", hwVersion=" · ", softwareVersion=" · ")"
- `public Ride3ProFirmwareMeta(String model, String hwVersion, String softwareVersion)`  L77
    - 体内字面量："model" · "hwVersion" · "softwareVersion"
- `String getModel()`  L86
- `String getHwVersion()`  L90
- `String getSoftwareVersion()`  L94
    - 体内字面量："Lcom/tuwinsmart/tuwin/core/util/Ride3ProFirmwareMeta$Companion;" · "()V" · "DEFAULT_HW_VERSION" · "DEFAULT_MODEL" · "create" · "Lcom/tuwinsmart/tuwin/core/util/Ride3ProFirmwareMeta;" · "model" · "hwVersion" · "softwareVersion" · "fromNewOta" · "boardVersion" · "app_release_64"
### `com.tuwinsmart.tuwin.core.util.Ride3ProFirmwareMeta$Companion`
L100 · [class] public static final Companion · `com/tuwinsmart/tuwin/core/util/Ride3ProFirmwareMeta.java`
注解：

字段/常量（6）：
- `String string`  L109
- `String string2`  L110
- `String string3`  L111
- `String string`  L138
- `String str`  L139
- `String string2`  L140

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L101
- `private Companion()`  L105
- `Ride3ProFirmwareMeta create(String model, String hwVersion, String softwareVersion)`  L108
- `Ride3ProFirmwareMeta fromNewOta(String boardVersion, String version)`  L137
### `com.tuwinsmart.tuwin.core.util.Ride3ProFirmwareMetaParser`
L17 · [class] public final Ride3ProFirmwareMetaParser · `com/tuwinsmart/tuwin/core/util/Ride3ProFirmwareMetaParser.java`
注解：

字段/常量（10）：
- `String str`  L26
- `MatchResult matchResultMatchEntire`  L27
- `String string`  L28
- `String strSubstringBefore$default`  L29
- `String strSubstringAfterLast$default`  L30
- `String strSubstringAfterLast$default2`  L31
- `Object objM3074constructorimpl`  L32
- `Result.Companion companion = Result.INSTANCE`  L43
- `Result.Companion companion2 = Result.INSTANCE`  L46
- `Object obj = strSubstringAfterLast$default2`  L49

方法（3）：
- `private Ride3ProFirmwareMetaParser()`  L21
- `Ride3ProFirmwareMeta parse(String source)`  L25
- `String normalizeVersionToken(String value)`  L62
    - 体内字面量："_" · "."
### `com.tuwinsmart.tuwin.core.util.SessionBoundOtaIdentity`
L11 · [class] public final SessionBoundOtaIdentity · `com/tuwinsmart/tuwin/core/util/SessionBoundOtaIdentity.java`
注解：

字段/常量（3）：
- `String boardVersion`  L12
- `String model`  L13
- `String version`  L14

方法（12）：
- `SessionBoundOtaIdentity copy$default(SessionBoundOtaIdentity sessionBoundOtaIdentity, String str, String str2, String str3, int i, Object obj)`  L16
- `String getVersion()`  L30
- `String getBoardVersion()`  L35
- `String getModel()`  L40
- `SessionBoundOtaIdentity copy(String version, String boardVersion, String model)`  L44
    - 体内字面量："version" · "boardVersion" · "model"
- `boolean equals(Object other)`  L51
- `int hashCode()`  L62
- `String toString()`  L66
    - 体内字面量："SessionBoundOtaIdentity(version=" · ", boardVersion=" · ", model=" · ")"
- `public SessionBoundOtaIdentity(String version, String boardVersion, String model)`  L70
    - 体内字面量："version" · "boardVersion" · "model"
- `String getVersion()`  L79
- `String getBoardVersion()`  L83
- `String getModel()`  L87
### `com.tuwinsmart.tuwin.core.util.SessionBoundOtaIdentityPolicy`
L17 · [class] public final SessionBoundOtaIdentityPolicy · `com/tuwinsmart/tuwin/core/util/SessionBoundOtaIdentityPolicy.java`
注解：

字段/常量（7）：
- `String string`  L55
- `ConnectedDevice connectedDevice`  L56
- `String string2`  L57
- `String string3`  L58
- `String devid`  L59
- `String string4`  L60
- `String str = "<binary/metadata>"`  L86

方法（3）：
- `private SessionBoundOtaIdentityPolicy()`  L43
- `SessionBoundOtaIdentity resolve$default(SessionBoundOtaIdentityPolicy sessionBoundOtaIdentityPolicy, String str, DeviceType deviceType, List list, String str2, int i, Object obj)`  L46
- `SessionBoundOtaIdentity resolve(String sessionId, DeviceType expectedDeviceType, List<ConnectedDevice> devices, String stableDeviceId)`  L54
### `com.tuwinsmart.tuwin.core.util.SessionBoundOtaIdentityPolicy$WhenMappings`
L22 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/util/SessionBoundOtaIdentityPolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L23
### `com.tuwinsmart.tuwin.core.util.SimpleTextWatch`
L13 · [class] public SimpleTextWatch · implements `TextWatcher` · `com/tuwinsmart/tuwin/core/util/SimpleTextWatch.java`
注解：

方法（3）：
- `void afterTextChanged(Editable s)`  L15 @Override
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L19 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L23 @Override
### `com.tuwinsmart.tuwin.core.util.SpanUtils`
L48 · [class] public final SpanUtils · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（60）：
- `int ALIGN_BASELINE = 1`  L49
- `int ALIGN_BOTTOM = 0`  L50
- `int ALIGN_CENTER = 2`  L51
- `int ALIGN_TOP = 3`  L52
- `int COLOR_DEFAULT = -65536`  L53
- `int alignImage`  L55
- `int alignLine`  L56
- `Layout.Alignment alignment`  L57
- `int backgroundColor`  L58
- `float blurRadius`  L59
- `int bulletColor`  L60
- `int bulletGapWidth`  L61
- `int bulletRadius`  L62
- `ClickableSpan clickSpan`  L63
- `int first`  L64
- `int flag`  L65
- `String fontFamily`  L66
- `int fontSize`  L67
- `boolean fontSizeIsDp`  L68
- `int foregroundColor`  L69
- `Bitmap imageBitmap`  L70
- `Drawable imageDrawable`  L71
- `int imageResourceId`  L72
- `Uri imageUri`  L73
- `boolean isBold`  L74
- `boolean isBoldItalic`  L75
- `boolean isItalic`  L76
- `boolean isStrikethrough`  L77
- `boolean isSubscript`  L78
- `boolean isSuperscript`  L79
- `boolean isUnderline`  L80
- `int lineHeight`  L81
- `int mType`  L82
- `float proportion`  L83
- `int quoteColor`  L84
- `int quoteGapWidth`  L85
- `int rest`  L86
- `Shader shader`  L87
- `int shadowColor`  L88
- `float shadowDx`  L89
- `float shadowDy`  L90
- `float shadowRadius`  L91
- `int spaceColor`  L92
- `int spaceSize`  L93
- `Object[] spans`  L94
- `int stripeWidth`  L95
- `BlurMaskFilter.Blur style`  L96
- `Typeface typeface`  L97
- `String url`  L98
- `float xProportion`  L99
- `int mTypeCharSequence = 0`  L100
- `int mTypeImage = 1`  L101
- `int mTypeSpace = 2`  L102
- `int urlColor = -65536`  L103
- `CharSequence mText = "<binary/metadata>"`  L105
- `int i = this.mType`  L393
- `Object[] objArr = 0`  L463
- `ClickableSpan clickableSpan = this.clickSpan`  L470
- `Object[] objArr2 = this.spans`  L486
- `int i = length + 5`  L497

方法（52）：
- `public SpanUtils()`  L111
- `void setDefault()`  L115
- `SpanUtils setFlag(int i)`  L149
- `SpanUtils setForegroundColor(int i)`  L154
- `SpanUtils setBackgroundColor(int i)`  L159
- `SpanUtils setLineHeight(int i)`  L164
- `SpanUtils setLineHeight(int i, int i2)`  L168
- `SpanUtils setQuoteColor(int i)`  L174
- `SpanUtils setQuoteColor(int i, int i2, int i3)`  L178
- `SpanUtils setLeadingMargin(int i, int i2)`  L185
- `SpanUtils setBullet(int i)`  L191
- `SpanUtils setBullet(int i, int i2, int i3)`  L195
- `SpanUtils setFontSize(int i)`  L202
- `SpanUtils setFontSize(int i, boolean z)`  L206
- `SpanUtils setFontProportion(float f)`  L212
- `SpanUtils setFontXProportion(float f)`  L217
- `SpanUtils setStrikethrough()`  L222
- `SpanUtils setUnderline()`  L227
- `SpanUtils setSuperscript()`  L232
- `SpanUtils setSubscript()`  L237
- `SpanUtils setBold()`  L242
- `SpanUtils setItalic()`  L247
- `SpanUtils setBoldItalic()`  L252
- `SpanUtils setFontFamily(String str)`  L257
- `SpanUtils setTypeface(Typeface typeface)`  L262
- `SpanUtils setAlign(Layout.Alignment alignment)`  L267
- `SpanUtils setClickSpan(ClickableSpan clickableSpan)`  L272
- `SpanUtils setUrl(String str)`  L277
- `SpanUtils setBlur(float f, BlurMaskFilter.Blur blur)`  L282
- `SpanUtils setShader(Shader shader)`  L288
- `SpanUtils setShadow(float f, float f2, float f3, int i)`  L293
- `SpanUtils setSpans(Object... objArr)`  L301
- `SpanUtils append(CharSequence charSequence)`  L308
- `SpanUtils appendLine()`  L314
- `SpanUtils appendLine(CharSequence charSequence)`  L320
- `SpanUtils appendImage(Bitmap bitmap)`  L326
- `SpanUtils appendImage(Bitmap bitmap, int i)`  L330
- `SpanUtils appendImage(Drawable drawable)`  L337
- `SpanUtils appendImage(Drawable drawable, int i)`  L341
- `SpanUtils appendImage(Uri uri)`  L348
- `SpanUtils appendImage(Uri uri, int i)`  L352
- `SpanUtils appendImage(int i)`  L359
- `SpanUtils appendImage(int i, int i2)`  L363
- `SpanUtils appendSpace(int i)`  L371
- `SpanUtils appendSpace(int i, int i2)`  L375
- `void apply(int i)`  L382
- `SpannableStringBuilder create()`  L387
- `void applyLast()`  L392
- `void updateCharCharSequence()`  L405
- `void updateImage()`  L494
    - 体内字面量："<img>"
- `void updateSpace()`  L511
    - 体内字面量："< >"
- `SpanUtils setUrlColor(int i)`  L517
### `com.tuwinsmart.tuwin.core.util.SpanUtils$Align`
L108 · [@interface] public Align · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`
注解：@Retention(RetentionPolicy.SOURCE)
### `com.tuwinsmart.tuwin.core.util.SpanUtils$CustomBulletSpan`
L637 · [class] CustomBulletSpan · implements `LeadingMarginSpan` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（5）：
- `int color`  L638
- `int gapWidth`  L639
- `int radius`  L640
- `Path sBulletPath`  L641
- `int i8 = this.radius`  L673

方法（3）：
- `private CustomBulletSpan(int i, int i2, int i3)`  L643
- `int getLeadingMargin(boolean z)`  L651 @Override
- `void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout)`  L656 @Override
### `com.tuwinsmart.tuwin.core.util.SpanUtils$CustomDynamicDrawableSpan`
L786 · [class] abstract CustomDynamicDrawableSpan · extends `ReplacementSpan` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（13）：
- `int ALIGN_BASELINE = 1`  L787
- `int ALIGN_BOTTOM = 0`  L788
- `int ALIGN_CENTER = 2`  L789
- `int ALIGN_TOP = 3`  L790
- `WeakReference<Drawable> mDrawableRef`  L791
- `int mVerticalAlignment`  L792
- `int i3`  L806
- `int i4 = this.mVerticalAlignment`  L809
- `int i5 = i3 / 4`  L814
- `int iHeight`  L829
- `float fHeight`  L830
- `int i6 = this.mVerticalAlignment`  L835
- `WeakReference<Drawable> weakReference = this.mDrawableRef`  L857

方法（6）：
- `Drawable getDrawable()`  L794
- `private CustomDynamicDrawableSpan()`  L796
- `private CustomDynamicDrawableSpan(int i)`  L800
- `int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt)`  L805 @Override
- `void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint)`  L828 @Override
- `Drawable getCachedDrawable()`  L856
### `com.tuwinsmart.tuwin.core.util.SpanUtils$CustomImageSpan`
L714 · [class] CustomImageSpan · extends `CustomDynamicDrawableSpan` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（6）：
- `Uri mContentUri`  L715
- `Drawable mDrawable`  L716
- `int mResourceId`  L717
- `Drawable drawable`  L744
- `Drawable drawable2 = this.mDrawable`  L745
- `BitmapDrawable bitmapDrawable = null`  L749

方法（5）：
- `private CustomImageSpan(Bitmap bitmap, int i)`  L719
- `private CustomImageSpan(Drawable drawable, int i)`  L726
- `private CustomImageSpan(Uri uri, int i)`  L732
- `private CustomImageSpan(int i, int i2)`  L737
- `Drawable getDrawable()`  L743 @Override
### `com.tuwinsmart.tuwin.core.util.SpanUtils$CustomLineHeightSpan`
L535 · [class] CustomLineHeightSpan · extends `CharacterStyle implements LineHeightSpan` · implements `LineHeightSpan` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（8）：
- `int ALIGN_CENTER = 2`  L536
- `int ALIGN_TOP = 3`  L537
- `int height`  L538
- `int mVerticalAlignment`  L539
- `int i6 = this.mVerticalAlignment`  L553
- `int i7 = i5 / 2`  L557
- `int i9 = this.mVerticalAlignment`  L564
- `int i10 = i8 / 2`  L569

方法（2）：
- `void updateDrawState(TextPaint textPaint)`  L542 @Override
- `void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt)`  L551 @Override
### `com.tuwinsmart.tuwin.core.util.SpanUtils$CustomQuoteSpan`
L609 · [class] CustomQuoteSpan · implements `LeadingMarginSpan` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（3）：
- `int color`  L610
- `int gapWidth`  L611
- `int stripeWidth`  L612

方法（3）：
- `private CustomQuoteSpan(int i, int i2, int i3)`  L614
- `int getLeadingMargin(boolean z)`  L621 @Override
- `void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout)`  L626 @Override
### `com.tuwinsmart.tuwin.core.util.SpanUtils$CustomTypefaceSpan`
L682 · [class] CustomTypefaceSpan · extends `TypefaceSpan` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（1）：
- `Typeface newType`  L683

方法（4）：
- `private CustomTypefaceSpan(Typeface typeface)`  L685
- `void updateDrawState(TextPaint textPaint)`  L691 @Override
- `void updateMeasureState(TextPaint textPaint)`  L696 @Override
- `void apply(Paint paint, Typeface typeface)`  L700
### `com.tuwinsmart.tuwin.core.util.SpanUtils$CustomUrlSpan`
L522 · [class] CustomUrlSpan · extends `URLSpan` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

方法（2）：
- `public CustomUrlSpan(String str)`  L523
- `void updateDrawState(TextPaint textPaint)`  L528 @Override
### `com.tuwinsmart.tuwin.core.util.SpanUtils$ShaderSpan`
L868 · [class] ShaderSpan · extends `CharacterStyle implements UpdateAppearance` · implements `UpdateAppearance` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（1）：
- `Shader mShader`  L869

方法（2）：
- `private ShaderSpan(Shader shader)`  L871
- `void updateDrawState(TextPaint textPaint)`  L876 @Override
### `com.tuwinsmart.tuwin.core.util.SpanUtils$ShadowSpan`
L881 · [class] ShadowSpan · extends `CharacterStyle implements UpdateAppearance` · implements `UpdateAppearance` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（4）：
- `float f1351dx`  L884
- `float f1352dy`  L887
- `float radius`  L888
- `int shadowColor`  L889

方法（2）：
- `private ShadowSpan(float f, float f2, float f3, int i)`  L891
- `void updateDrawState(TextPaint textPaint)`  L899 @Override
### `com.tuwinsmart.tuwin.core.util.SpanUtils$SpaceSpan`
L579 · [class] SpaceSpan · extends `ReplacementSpan` · `com/tuwinsmart/tuwin/core/util/SpanUtils.java`

字段/常量（2）：
- `int color`  L580
- `int width`  L581

方法（4）：
- `private SpaceSpan(SpanUtils spanUtils, int i)`  L583
- `private SpaceSpan(int i, int i2)`  L587
- `int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt)`  L593 @Override
- `void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint)`  L598 @Override
### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckBatch`
L12 · [class] public final StartupOtaCheckBatch · `com/tuwinsmart/tuwin/core/util/StartupOtaCheckBatch.java`
注解：

字段/常量（3）：
- `List<OtaDeviceQuery> candidates`  L13
- `boolean complete`  L14
- `List<ConnectedDevice> devices`  L15

方法（12）：
- `StartupOtaCheckBatch copy$default(StartupOtaCheckBatch startupOtaCheckBatch, List list, List list2, boolean z, int i, Object obj)`  L18
- `List<ConnectedDevice> component1()`  L31
- `List<OtaDeviceQuery> component2()`  L35
- `boolean getComplete()`  L40
- `StartupOtaCheckBatch copy(List<ConnectedDevice> devices, List<OtaDeviceQuery> candidates, boolean complete)`  L44
    - 体内字面量："devices" · "candidates"
- `boolean equals(Object other)`  L50
- `int hashCode()`  L61
- `String toString()`  L65
    - 体内字面量："StartupOtaCheckBatch(devices=" · ", candidates=" · ", complete=" · ")"
- `public StartupOtaCheckBatch(List<ConnectedDevice> devices, List<OtaDeviceQuery> candidates, boolean z)`  L69
    - 体内字面量："devices" · "candidates"
- `List<ConnectedDevice> getDevices()`  L77
- `List<OtaDeviceQuery> getCandidates()`  L81
- `boolean getComplete()`  L85
### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckCohort`
L23 · [class] public final StartupOtaCheckCohort · `com/tuwinsmart/tuwin/core/util/StartupOtaCheckCohort.java`
注解：

字段/常量（9）：
- `List<StartupDeviceReference> devices`  L27
- `Set<OtaDeviceQuery> requestedQueries`  L28
- `Set<Integer> resolvedDeviceIndexes`  L29
- `ArrayList arrayList`  L46
- `ArrayList arrayList2`  L47
- `List<StartupDeviceReference> list = this.devices`  L49
- `int i = 0`  L57
- `int i2 = i + 1`  L59
- `OtaDeviceQuery otaDeviceQuery = null`  L64

方法（4）：
- ` StartupOtaCheckCohort(List list, DefaultConstructorMarker defaultConstructorMarker)`  L31
- `private StartupOtaCheckCohort(List<StartupDeviceReference> list)`  L35
- `boolean isEmpty()`  L41
- `StartupOtaCheckBatch takeNextBatch(List<ConnectedDevice> currentDevices)`  L45
### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckCohort$Companion`
L81 · [class] public static final Companion · `com/tuwinsmart/tuwin/core/util/StartupOtaCheckCohort.java`
注解：

字段/常量（2）：
- `List<ConnectedDevice> list = devices`  L92
- `int iIntValue = 0`  L96

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L82
- `private Companion()`  L86
- `StartupOtaCheckCohort capture(List<ConnectedDevice> devices)`  L89
    - 体内字面量："devices"
### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckCohort$StartupDeviceIdentity`
L206 · [class] private static final StartupDeviceIdentity · `com/tuwinsmart/tuwin/core/util/StartupOtaCheckCohort.java`
注解：

字段/常量（2）：
- `Kind kind`  L210
- `String value`  L211

方法（11）：
- `StartupDeviceIdentity copy$default(StartupDeviceIdentity startupDeviceIdentity, Kind kind, String str, int i, Object obj)`  L250
- `Kind getKind()`  L261
- `String getValue()`  L266
- `StartupDeviceIdentity copy(Kind kind, String value)`  L270
    - 体内字面量："kind" · "value"
- `boolean equals(Object other)`  L276
- `int hashCode()`  L287
- `String toString()`  L291
    - 体内字面量："StartupDeviceIdentity(kind=" · ", value=" · ")"
- `public StartupDeviceIdentity(Kind kind, String value)`  L295
    - 体内字面量："kind" · "value"
- `Kind getKind()`  L302
- `String getValue()`  L306
- `boolean matches(ConnectedDevice device)`  L310
    - 体内字面量："device" · "Lcom/tuwinsmart/tuwin/core/util/StartupOtaCheckCohort$StartupDeviceIdentity$Companion;" · "()V" · "Lcom/tuwinsmart/tuwin/core/util/StartupOtaCheckCohort$StartupDeviceIdentity;" · "device" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectedDevice;" · "app_release_64"
### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckCohort$StartupDeviceIdentity$Companion`
L327 · [class] public static final Companion · `com/tuwinsmart/tuwin/core/util/StartupOtaCheckCohort.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L328
- `private Companion()`  L332
- `StartupDeviceIdentity from(ConnectedDevice device)`  L335
    - 体内字面量："device"
### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckCohort$StartupDeviceIdentity$Kind`
L215 · [enum] public Kind · `com/tuwinsmart/tuwin/core/util/StartupOtaCheckCohort.java`
注解：

枚举常量（3）：
- `DEVICE_ID()`  L216
- `SSID()`  L217
- `SESSION_ID()`  L218

方法（1）：
- `EnumEntries<Kind> getEntries()`  L222
### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckCohort$StartupDeviceIdentity$WhenMappings`
L229 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/util/StartupOtaCheckCohort.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L230
### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckCohort$StartupDeviceReference`
L110 · [class] private static final StartupDeviceReference · `com/tuwinsmart/tuwin/core/util/StartupOtaCheckCohort.java`
注解：

字段/常量（5）：
- `int occurrence`  L111
- `ConnectedDevice snapshot`  L112
- `StartupDeviceIdentity stableIdentity`  L113
- `StartupDeviceIdentity startupDeviceIdentity = this.stableIdentity`  L160
- `StartupDeviceIdentity startupDeviceIdentity = this.stableIdentity`  L189

方法（13）：
- `StartupDeviceReference copy$default(StartupDeviceReference startupDeviceReference, StartupDeviceIdentity startupDeviceIdentity, int i, ConnectedDevice connectedDevice, int i2, Object obj)`  L115
- `StartupDeviceIdentity getStableIdentity()`  L129
- `int getOccurrence()`  L134
- `ConnectedDevice getSnapshot()`  L139
- `StartupDeviceReference copy(StartupDeviceIdentity stableIdentity, int occurrence, ConnectedDevice snapshot)`  L143
    - 体内字面量："snapshot"
- `boolean equals(Object other)`  L148
- `int hashCode()`  L159
- `String toString()`  L164
    - 体内字面量："StartupDeviceReference(stableIdentity=" · ", occurrence=" · ", snapshot=" · ")"
- `public StartupDeviceReference(StartupDeviceIdentity startupDeviceIdentity, int i, ConnectedDevice snapshot)`  L168
    - 体内字面量："snapshot"
- `StartupDeviceIdentity getStableIdentity()`  L175
- `int getOccurrence()`  L179
- `ConnectedDevice getSnapshot()`  L183
- `ConnectedDevice resolve(List<ConnectedDevice> currentDevices)`  L187
    - 体内字面量："currentDevices"
### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckCohortKt`
L12 · [class] public final StartupOtaCheckCohortKt · `com/tuwinsmart/tuwin/core/util/StartupOtaCheckCohortKt.java`
注解：

字段/常量（2）：
- `String string`  L15
- `String strRemoveSurrounding`  L16

方法（1）：
- `String normalizedIdentityValue(String str)`  L14
### `com.tuwinsmart.tuwin.core.util.ToastUtil`
L7 · [class] public ToastUtil · `com/tuwinsmart/tuwin/core/util/ToastUtil.java`

方法（3）：
- `void showMessage(String str)`  L8
- `void showMessage(int i)`  L12
- `int dpToPx(int i)`  L16
### `com.tuwinsmart.tuwin.core.util.UmengSdkBridge`
L16 · [class] public final UmengSdkBridge · `com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java`
注解：

字段/常量（19）：
- `String DEVICE_TYPE_PHONE_FIELD_NAME = "DEVICE_TYPE_PHONE"`  L17
- `String UM_CONFIGURE_CLASS_NAME = "com.umeng.commonsdk.UMConfigure"`  L19
- `Object objM3074constructorimpl`  L77
- `Result.Companion companion = Result.INSTANCE`  L87
- `UmengSdkBridge umengSdkBridge = this`  L88
- `Result.Companion companion2 = Result.INSTANCE`  L92
- `Integer numResolveDeviceTypePhone`  L126
- `Object objM3074constructorimpl`  L127
- `Result.Companion companion = Result.INSTANCE`  L138
- `UmengSdkBridge umengSdkBridge = this`  L139
- `Result.Companion companion2 = Result.INSTANCE`  L143
- `Object objM3074constructorimpl`  L176
- `Result.Companion companion = Result.INSTANCE`  L183
- `UmengSdkBridge umengSdkBridge = this`  L184
- `Result.Companion companion2 = Result.INSTANCE`  L187
- `Object objM3074constructorimpl`  L199
- `Result.Companion companion = Result.INSTANCE`  L201
- `UmengSdkBridge umengSdkBridge = this`  L202
- `Result.Companion companion2 = Result.INSTANCE`  L205

方法（11）：
- `private UmengSdkBridge()`  L21
- `boolean isAvailable$default(UmengSdkBridge umengSdkBridge, Function1 function1, int i, Object obj)`  L40
- `boolean isAvailable(Function1<? super String, ? extends Class<?>> classResolver)`  L47
    - 体内字面量："classResolver"
- `boolean preInit$default(UmengSdkBridge umengSdkBridge, Context context, String str, String str2, Function1 function1, int i, Object obj)`  L69
- `boolean preInit(Context context, String appKey, String channel, Function1<? super String, ? extends Class<?>> classResolver)`  L76
- `boolean init$default(UmengSdkBridge umengSdkBridge, Context context, String str, String str2, Function1 function1, int i, Object obj)`  L118
- `boolean init(Context context, String appKey, String channel, Function1<? super String, ? extends Class<?>> classResolver)`  L125
- `Integer resolveDeviceTypePhone$default(UmengSdkBridge umengSdkBridge, Function1 function1, int i, Object obj)`  L168
- `Integer resolveDeviceTypePhone(Function1<? super String, ? extends Class<?>> classResolver)`  L175
- `Class<?> resolveUmConfigureClass(Function1<? super String, ? extends Class<?>> classResolver)`  L193
- `Class<?> resolveClass(String className)`  L198
### `com.tuwinsmart.tuwin.core.util.UmengSdkBridge$C21151`
L105 · [class] public C21151 · extends `FunctionReferenceImpl implements Function1<String, Class<?>>` · implements `Function1<String, Class<?>>` · `com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java`
注解：

方法（1）：
- `Class<?> invoke(String p0)`  L111 @Override
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.core.util.UmengSdkBridge$C21161`
L27 · [class] C21161 · extends `FunctionReferenceImpl implements Function1<String, Class<?>>` · implements `Function1<String, Class<?>>` · `com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java`
注解：

方法（1）：
- `Class<?> invoke(String p0)`  L33 @Override
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.core.util.UmengSdkBridge$C21171`
L56 · [class] public C21171 · extends `FunctionReferenceImpl implements Function1<String, Class<?>>` · implements `Function1<String, Class<?>>` · `com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java`
注解：

方法（1）：
- `Class<?> invoke(String p0)`  L62 @Override
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.core.util.UmengSdkBridge$C21181`
L155 · [class] C21181 · extends `FunctionReferenceImpl implements Function1<String, Class<?>>` · implements `Function1<String, Class<?>>` · `com/tuwinsmart/tuwin/core/util/UmengSdkBridge.java`
注解：

方法（1）：
- `Class<?> invoke(String p0)`  L161 @Override
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.core.util.UmengSdkBridgeKt`
L9 · [class] public final UmengSdkBridgeKt · `com/tuwinsmart/tuwin/core/util/UmengSdkBridgeKt.java`
注解：
### `com.tuwinsmart.tuwin.core.util.UpgradeBoardVersionPolicy`
L15 · [class] public final UpgradeBoardVersionPolicy · `com/tuwinsmart/tuwin/core/util/UpgradeBoardVersionPolicy.java`
注解：

字段/常量（1）：
- `String str = string`  L54

方法（3）：
- `private UpgradeBoardVersionPolicy()`  L41
- `boolean matches(String cachedBoardVersion, String currentBoardVersion, DeviceType deviceType)`  L44
- `String normalize(String boardVersion, DeviceType deviceType)`  L49
### `com.tuwinsmart.tuwin.core.util.UpgradeBoardVersionPolicy$WhenMappings`
L20 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/util/UpgradeBoardVersionPolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L21
### `com.tuwinsmart.tuwin.core.util.UpgradeDevice`
L36 · [class] public UpgradeDevice · `com/tuwinsmart/tuwin/core/util/UpgradeDevice.java`

字段/常量（40）：
- `int MSG_UPLOAD_FAILED = 10003`  L38
- `String TAG = "UpgradeDevice"`  L39
- `boolean bCancelUpload`  L40
- `int blockLength`  L41
- `int chuncks`  L42
- `Network deviceNetwork`  L43
- `DeviceEndpointAuthority endpointAuthority`  L44
- `String endpointGrantId`  L45
- `Handler mHandler`  L46
- `UploadListener mUploadListener`  L47
- `long routeRevision`  L48
- `String sessionId`  L49
- `long uploadedCount`  L50
- `Throwable th`  L152
- `Socket socketCreateSocket`  L153
- `OutputStream outputStream`  L154
- `Socket socket`  L155
- `OutputStream outputStream2`  L156
- `ByteArrayInputStream byteArrayInputStream`  L157
- `byte[] bArr2`  L158
- `int i`  L159
- `byte[] bArr3 = new byte[bArr.length]`  L195
- `UploadListener uploadListener = this.mUploadListener`  L204
- `DeviceEndpointAuthority deviceEndpointAuthority`  L630
- `String str`  L631
- `RandomAccessFile randomAccessFile`  L641
- `RandomAccessFile randomAccessFile2`  L642
- `byte[] bArr = new byte[i]`  L643
- `RandomAccessFile randomAccessFile3 = null`  L644
- `byte[] bArr2 = new byte[i2]`  L667
- `UploadListener uploadListener = this.mUploadListener`  L731
- `long j`  L760
- `int i2 = 1`  L761
- `long j2 = this.uploadedCount`  L767
- `int i3 = this.blockLength`  L768
- `int i4 = i + 1`  L782
- `UploadListener uploadListener = this.mUploadListener`  L804
- `Handler handler = this.mHandler`  L809
- `Cursor cursorQuery`  L868
- `int[] iArr = {0, 100}`  L872

方法（26）：
- `public UpgradeDevice()`  L60
- `public UpgradeDevice(Network network, DeviceEndpointAuthority deviceEndpointAuthority, String str, String str2, long j)`  L64
- `void setHandler(Handler handler)`  L77
- `void setUploadListener(UploadListener uploadListener)`  L81
- `void stopUpload()`  L85
- `String[] getLocalAllFirmware(Context context)`  L89
- `boolean accept(File file, String str)`  L92 @Override
    - 体内字面量：".appsw"
- `String[] getLocalFirmwareByChip(Context context, final String str)`  L98
- `boolean accept(File file, String str2)`  L101 @Override
    - 体内字面量：".appsw"
- `String[] getLocalFirmwareByPrefix(Context context, final String str)`  L107
- `boolean accept(File file, String str2)`  L110 @Override
    - 体内字面量：".appsw"
- `String getUpgradePath(Context context)`  L116
- `boolean exists(Context context, String str)`  L125
- `String[] getMatchedFirmware(Context context)`  L129
- `void uploadFirmware(File file, byte[] bArr, long j)`  L151
- `EndpointGrant requireOtaGrant()`  L629
- `byte[] getBlock(Long l, File file, int i)`  L640
- `boolean upload(File file, String str, String str2)`  L712
    - 体内字面量："12233" · "åºä»¶åçº§åä¸ä¼ " · "12233" · "æ»åæ° " · "12233" · "å½åç¬¬å å " · "12233" · "å½ååæ° >= æ»åæ° ä¸ä¼ æå!"
- `int getChunck(int i, File file)`  L759
- `void notifyUploadFailed()`  L803
- `List<String> parseServerFileList(String str)`  L815
- `String getDownloadDevPath(Context context)`  L834
    - 体内字面量："upgrade"
- `String readLine(InputStream inputStream)`  L838
- `long download(Context context, String str)`  L848
    - 体内字面量："download" · "/" · "download() from " · "download() to " · "download() id: " · "event=system_download_enqueued task_id=system-download-" · " host=" · " path=" · " file="
- `int[] getDownloadProgress(Context context, long j)`  L867
- `int cancelDownload(Context context, long j)`  L905
    - 体内字面量："download" · "event=system_download_cancelled task_id=system-download-" · " removed="
### `com.tuwinsmart.tuwin.core.util.UpgradeDevice$UploadListener`
L52 · [interface] public UploadListener · `com/tuwinsmart/tuwin/core/util/UpgradeDevice.java`

方法（3）：
- `void onUploadFailed()`  L53
- `void onUploadSuccess()`  L55
- `void onUploading(int i, int i2)`  L57
### `com.tuwinsmart.tuwin.core.util.UpgradeHelper`
L71 · [class] public final UpgradeHelper · implements `OtaDeviceLifecycle` · `com/tuwinsmart/tuwin/core/util/UpgradeHelper.java`
注解：

字段/常量（41）：
- `long DOWNLOAD_COMPLETE_DISPLAY_MILLIS = 2000`  L72
- `String UPGRADE_DIRECTORY_NAME = "upgrade"`  L73
- `MutableStateFlow<Long> _versionListRevision`  L74
- `Call activeDownloadCall`  L75
- `boolean downloadInProgress`  L76
- `FirmwareDownloadDialog firmwareDownloadDialog`  L77
- `boolean firmwareDownloadPanelHidden`  L78
- `Dialog promptDialog`  L79
- `boolean promptVisible`  L80
- `StartupOtaCheckCohort startupCheckCohort`  L81
- `Object startupCheckLock`  L82
- `StateFlow<Long> versionListRevision`  L83
- `Unit unit = Unit.INSTANCE`  L121
- `StartupOtaCheckCohort startupOtaCheckCohort = startupCheckCohort`  L130
- `String string`  L359
- `String strSubstringAfterLast$default`  L360
- `String strSubstringBefore$default`  L361
- `String string2`  L362
- `String str = data.version`  L371
- `String str3 = data.fw_url`  L373
- `Long value`  L481
- `MutableStateFlow<Long> mutableStateFlow = _versionListRevision`  L483
- `String strSubstringBefore$default`  L528
- `String str = "ota-" + downloadTag`  L529
- `UpgradeHelper upgradeHelper = UpgradeHelper.INSTANCE`  L563
- `Long l = objectRef.element`  L566
- `UpgradeHelper upgradeHelper = UpgradeHelper.INSTANCE`  L593
- `UpgradeHelper upgradeHelper = UpgradeHelper.INSTANCE`  L628
- `OtaDownloadTask otaDownloadTaskCurrentOrNext`  L639
- `UpgradeHelper upgradeHelper = INSTANCE`  L683
- `UpgradeHelper upgradeHelper = INSTANCE`  L728
- `ArrayList arrayList2 = arrayList`  L748
- `OtaSerialTaskQueue<OtaPackageIdentity, OtaDownloadTask> otaSerialTaskQueue = downloadQueue`  L787
- `Dialog dialog = promptDialog`  L802
- `Call call = activeDownloadCall`  L809
- `FirmwareDownloadUiState firmwareDownloadUiStateCompleted`  L888
- `FirmwareDownloadDialog firmwareDownloadDialog2 = firmwareDownloadDialog`  L910
- `UpgradeHelper upgradeHelper = UpgradeHelper.INSTANCE`  L925
- `FirmwareDownloadDialog firmwareDownloadDialog4 = firmwareDownloadDialog`  L937
- `String version2`  L985
- `ArrayList arrayList3 = arrayList2`  L1027

方法（56）：
- `OtaPackageIdentity invoke(OtaDownloadTask it)`  L88 @Override
    - 体内字面量："it"
- `private UpgradeHelper()`  L96
- `StateFlow<Long> getVersionListRevision()`  L106
- `void checkFirmwareUpdatesAtStartup()`  L110
- `void requestFirmwareUpdatesAtStartup()`  L115
- `void tryRunFirmwareUpdatesAtStartup()`  L125
    - 体内字面量："OTA startup check already consumed for this app lifecycle"
- `Unit invoke()`  L177 @Override
- `void invoke2()`  L183
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.core.util.UpgradeHelper$tryRunFirmwareUpdatesAtStartup$1" · "UpgradeHelper.kt" · "invokeSuspend" · "startedRequestCount" · "candidate" · "L$0" · "L$4" · "call to 'resume' before 'invoke' with coroutine" · "OTA metadata request failed"
- `void notifyStartupCheckCompleteIfIdle()`  L350
- `void handleOtaMetadataResponse(OtaDeviceQuery candidate, UpgradeBean data, Function0<Unit> checkAndNotify)`  L358
- `boolean hasUsableCachedPackage$app_release_64(String filePath, String expectedFileName, Long expectedFileSize)`  L440
- `List<LocalUpgradeBean> getVersionList()`  L469
    - 体内字面量："versionList" · "fromJson(...)"
- `void saveVersionList(List<LocalUpgradeBean> list)`  L480
- `void processAvailableUpdate(OtaDeviceQuery candidate, String targetVersion, String targetUrl, String expectedFileName, Long expectedFileSize, String updateLog, Function0<Unit> checkAndNotify)`  L490
    - 体内字面量："OTA package verification failed: remote file size unavailable, deviceType=" · ", targetVersion=" · ", source="
- `void startDownload(String url, OtaQuery query, String targetVersion, final String expectedFileName, Long expectedFileSize, String downloadTag, final Function1<? super File, Unit> onSuccess, final Function0<Unit> onError)`  L527
- `Unit invoke(String str2)`  L555 @Override
- `void invoke2(String filePath)`  L561
    - 体内字面量："filePath"
- `Unit invoke(String str2)`  L585 @Override
- `void invoke2(String errorMessage)`  L591
    - 体内字面量："errorMessage"
- `Unit invoke(Progress progress)`  L606 @Override
- `void invoke2(Progress progress)`  L613
    - 体内字面量："progress"
- `Unit invoke(Call call)`  L620 @Override
- `void invoke2(Call call)`  L626
    - 体内字面量："call"
- `File upgradeBaseDirectory()`  L634
- `void showNextDownloadPromptIfPossible()`  L638
- `void onClick(View view)`  L668 @Override
- `void onClick(View view)`  L673 @Override
- `void showNextDownloadPromptIfPossible$lambda$12(final OtaDownloadTask task, View view)`  L681
    - 体内字面量："$task"
- `Unit invoke(File file)`  L696 @Override
- `void invoke2(File file)`  L702
    - 体内字面量："file"
- `Unit invoke()`  L712 @Override
- `void invoke2()`  L718
- `void showNextDownloadPromptIfPossible$lambda$13(OtaDownloadTask task, View view)`  L726
    - 体内字面量："$task"
- `void tryShowPendingConfirm()`  L734
- `void onDevicesChanged(List<ConnectedDevice> devices)`  L740 @Override
    - 体内字面量："devices"
- `void handleDownloadSuccess(OtaDownloadTask task, File file)`  L758
- `void finishTask(OtaDownloadTask task, boolean suppress)`  L771
- `void pruneInactiveTasks(final List<ConnectedDevice> devices)`  L786
- `Boolean invoke(OtaDownloadTask it)`  L796 @Override
    - 体内字面量："it"
- `boolean isCandidateActive(OtaDeviceQuery candidate)`  L823
- `boolean isTaskActive$default(UpgradeHelper upgradeHelper, OtaDownloadTask otaDownloadTask, List list, int i, Object obj)`  L828
- `boolean isTaskActive(OtaDownloadTask task, List<ConnectedDevice> devices)`  L836
- `List<ConnectedDevice> currentOtaDevices()`  L852
- `boolean isOtaDevice(ConnectedDevice device)`  L863
- `void showDownloadProgress$default(UpgradeHelper upgradeHelper, int i, boolean z, boolean z2, boolean z3, int i2, Object obj)`  L867
- `void showDownloadProgress(final int progress, final boolean downloading, final boolean failed, final boolean revealPanel)`  L877
- `void run()`  L880 @Override
- `void showDownloadProgress$lambda$22(boolean z, boolean z2, int i, boolean z3)`  L887
- `Unit invoke()`  L918 @Override
- `void invoke2()`  L924
- `void onDismiss(DialogInterface dialogInterface)`  L931 @Override
- `void run()`  L945 @Override
- `void showDownloadProgress$lambda$22$lambda$19$lambda$18(FirmwareDownloadDialog this_apply, DialogInterface dialogInterface)`  L953
    - 体内字面量："$this_apply"
- `void showDownloadProgress$lambda$22$lambda$21(FirmwareDownloadDialog dialog)`  L961
    - 体内字面量："$dialog"
- `LocalUpgradeBean checkHasUpdate$default(UpgradeHelper upgradeHelper, String str, String str2, DeviceType deviceType, String str3, int i, Object obj)`  L971
- `LocalUpgradeBean checkHasUpdate(String version, String boardversion, DeviceType deviceType, String model)`  L984
### `com.tuwinsmart.tuwin.core.util.UpgradeHelper$C21231`
L389 · [class] static final C21231 · extends `Lambda implements Function1<Long, Unit>` · implements `Function1<Long, Unit>` · `com/tuwinsmart/tuwin/core/util/UpgradeHelper.java`
注解：

字段/常量（13）：
- `OtaDeviceQuery $candidate`  L390
- `Function0<Unit> $checkAndNotify`  L391
- `UpgradeBean $data`  L392
- `String $expectedFileName`  L393
- `String $targetUrl`  L394
- `String $targetVersion`  L395
- `Handler handler = UpgradeHelper.mainHandler`  L416
- `OtaDeviceQuery otaDeviceQuery = this.$candidate`  L417
- `String str = this.$targetVersion`  L418
- `String str2 = this.$targetUrl`  L419
- `String str3 = this.$expectedFileName`  L420
- `UpgradeBean upgradeBean = this.$data`  L421
- `Function0<Unit> function0 = this.$checkAndNotify`  L422

方法（4）：
- `Unit invoke(Long l)`  L409 @Override
- `void invoke2(final Long l)`  L415
- `void run()`  L425 @Override
- `void invoke$lambda$0(OtaDeviceQuery candidate, String str, String str2, String str3, Long l, UpgradeBean data, Function0 checkAndNotify)`  L432
    - 体内字面量："$candidate" · "$data" · "$checkAndNotify"
### `com.tuwinsmart.tuwin.core.util.UpgradeHelper$C21291`
L196 · [class] static final C21291 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/core/util/UpgradeHelper.java`
注解：

字段/常量（9）：
- `List<OtaDeviceQuery> $candidates`  L197
- `Function0<Unit> $checkAndNotify`  L198
- `InternetCloudGateway $cloudGateway`  L199
- `Object L$0`  L200
- `Object L$1`  L201
- `Object L$2`  L202
- `Object L$3`  L203
- `Object L$4`  L204
- `int label`  L205

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L216 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L221 @Override
- `java.lang.Object invokeSuspend(java.lang.Object r10)`  L235 @Override
    - 体内字面量："Method not decompiled: com.tuwinsmart.tuwin.core.util.UpgradeHelper.C21291.invokeSuspend(java.lang.Object):java.lang.Object"
### `com.tuwinsmart.tuwin.core.util.UpgradeHelperKt`
L13 · [class] public final UpgradeHelperKt · `com/tuwinsmart/tuwin/core/util/UpgradeHelperKt.java`
注解：

方法（2）：
- `boolean otaModelMatches(String str, String str2)`  L15
- `String normalizeOtaModel(String str)`  L20
    - 体内字面量："[^A-Za-z0-9]" · "toUpperCase(...)"
### `com.tuwinsmart.tuwin.core.util.WebViewHelper`
L14 · [class] public final WebViewHelper · `com/tuwinsmart/tuwin/core/util/WebViewHelper.java`
注解：

方法（7）：
- `private WebViewHelper()`  L17
- `void cacheUrl$default(WebViewHelper webViewHelper, String str, Function0 function0, Function1 function1, int i, Object obj)`  L21
- `void invoke2()`  L25
- `Unit invoke()`  L29 @Override
- `Unit invoke(String str2)`  L38 @Override
- `void invoke2(String it)`  L44
    - 体内字面量："it"
- `void cacheUrl(String url, Function0<Unit> onSuccess, Function1<? super String, Unit> onError)`  L53
    - 体内字面量："url" · "onSuccess" · "onError" · "WebView preloading is disabled; open external pages in :internet process"
### `com.tuwinsmart.tuwin.core.util.wifi.DeviceLogDownloadPolicy`
L16 · [class] public final DeviceLogDownloadPolicy · `com/tuwinsmart/tuwin/core/util/wifi/DeviceLogDownloadPolicy.java`
注解：

字段/常量（1）：
- `String strSubstringAfterLast`  L28

方法（3）：
- `private DeviceLogDownloadPolicy()`  L19
- `List<String> candidateDates(DeviceType deviceType, String currentDate, String softVersion)`  L22
    - 体内字面量："currentDate"
- `String softVersionDate(String softVersion)`  L27
### `com.tuwinsmart.tuwin.core.util.wifi.DeviceLogFilePolicy`
L20 · [class] public final DeviceLogFilePolicy · `com/tuwinsmart/tuwin/core/util/wifi/DeviceLogFilePolicy.java`
注解：

字段/常量（6）：
- `String str = ssid`  L62
- `Object next`  L87
- `int length = fileArrListFiles.length`  L93
- `int i = 0`  L94
- `File file = fileArrListFiles[i]`  L100
- `DeviceLogFilePolicy deviceLogFilePolicy = INSTANCE`  L101

方法（6）：
- `private DeviceLogFilePolicy()`  L50
- `String fileName$default(DeviceLogFilePolicy deviceLogFilePolicy, String str, DeviceType deviceType, String str2, int i, Object obj)`  L53
- `String fileName(String date, DeviceType deviceType, String ssid)`  L60
    - 体内字面量："date"
- `String suffix(DeviceType deviceType)`  L66
    - 体内字面量："UNKNOWN" · "RIDE3PRO" · "RIDE6" · "RIDE5"
- `File findExistingFile(File fileDir, String date, DeviceType deviceType, String ssid)`  L86
- `boolean hasContent(File file)`  L135
### `com.tuwinsmart.tuwin.core.util.wifi.DeviceLogFilePolicy$WhenMappings`
L25 · [class] public WhenMappings · `com/tuwinsmart/tuwin/core/util/wifi/DeviceLogFilePolicy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L26
### `com.tuwinsmart.tuwin.core.util.wifi.DeviceLogReusePolicy`
L11 · [class] public final DeviceLogReusePolicy · `com/tuwinsmart/tuwin/core/util/wifi/DeviceLogReusePolicy.java`
注解：

字段/常量（1）：
- `long RECENT_LOG_MAX_AGE_MS = 30000`  L13

方法（2）：
- `private DeviceLogReusePolicy()`  L15
- `boolean canReuse(File file, long nowMs)`  L18
    - 体内字面量："file"
### `com.tuwinsmart.tuwin.core.util.wifi.FeedbackLogUploadPolicy`
L11 · [class] public final FeedbackLogUploadPolicy · `com/tuwinsmart/tuwin/core/util/wifi/FeedbackLogUploadPolicy.java`
注解：

方法（2）：
- `private FeedbackLogUploadPolicy()`  L14
- `String publicUrlIfUploaded(boolean uploaded, String bucket, String endpoint, String key)`  L17
    - 体内字面量："bucket" · "endpoint" · "key" · "https://" · "." · "/"
### `com.tuwinsmart.tuwin.core.util.wifi.FeedbackLogUploadResult`
L12 · [class] public final FeedbackLogUploadResult · `com/tuwinsmart/tuwin/core/util/wifi/FeedbackLogUploadResult.java`
注解：

字段/常量（6）：
- `String appLogUrl`  L13
- `String deviceLogUrl`  L14
- `String diagnosticId`  L15
- `DiagnosticUploadStatus status`  L16
- `String str = this.deviceLogUrl`  L73
- `String str2 = this.appLogUrl`  L75

方法（15）：
- `FeedbackLogUploadResult copy$default(FeedbackLogUploadResult feedbackLogUploadResult, String str, String str2, String str3, DiagnosticUploadStatus diagnosticUploadStatus, int i, Object obj)`  L18
- `String getDiagnosticId()`  L35
- `String getDeviceLogUrl()`  L40
- `String getAppLogUrl()`  L45
- `DiagnosticUploadStatus getStatus()`  L50
- `FeedbackLogUploadResult copy(String diagnosticId, String deviceLogUrl, String appLogUrl, DiagnosticUploadStatus status)`  L54
    - 体内字面量："diagnosticId" · "status"
- `boolean equals(Object other)`  L60
- `int hashCode()`  L71
- `String toString()`  L79
    - 体内字面量："FeedbackLogUploadResult(diagnosticId=" · ", deviceLogUrl=" · ", appLogUrl=" · ", status=" · ")"
- `public FeedbackLogUploadResult(String diagnosticId, String str, String str2, DiagnosticUploadStatus status)`  L83
    - 体内字面量："diagnosticId" · "status"
- `String getDiagnosticId()`  L92
- `String getDeviceLogUrl()`  L96
- `String getAppLogUrl()`  L100
- ` FeedbackLogUploadResult(String str, String str2, String str3, DiagnosticUploadStatus diagnosticUploadStatus, int i, DefaultConstructorMarker defaultConstructorMarker)`  L104
- `DiagnosticUploadStatus getStatus()`  L108
### `com.tuwinsmart.tuwin.core.util.wifi.LogHelper`
L51 · [class] public final LogHelper · `com/tuwinsmart/tuwin/core/util/wifi/LogHelper.java`
注解：

字段/常量（12）：
- `C21521 c21521`  L95
- `File file`  L96
- `List<String> listCandidateDates`  L97
- `Mutex mutex`  L98
- `DeviceType deviceType2`  L99
- `File file2`  L100
- `Mutex mutex2`  L101
- `DeviceLogDownloadResult deviceLogDownloadResult`  L102
- `Object obj = c21521.result`  L113
- `int i = c21521.label`  L115
- `String str`  L332
- `SimpleDateFormat simpleDateFormat = sdf`  L333

方法（12）：
- `private LogHelper()`  L80
- `Object downloadLogFile$default(LogHelper logHelper, DeviceType deviceType, String str, Continuation continuation, int i, Object obj)`  L83
- `Object downloadLogFile(DeviceType deviceType, String str, Continuation<? super DeviceLogDownloadResult> continuation)`  L94
- `File getFile()`  L192
- `File getFile(DeviceType deviceType)`  L201
- `File getFile(DeviceType deviceType, String ssid)`  L205
    - 体内字面量："/LOG"
- `boolean hasLogForDeviceType(DeviceType deviceType)`  L210
    - 体内字面量："/LOG" · "LOG" · "_" · "getName(...)"
- `String getCurrentSsid()`  L231
- `File getCFile()`  L236
    - 体内字面量："/CLOG" · "LOG" · ".txt" · "<anonymous>" · "Lcom/tuwinsmart/tuwin/core/util/wifi/FeedbackLogUploadResult;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.core.util.wifi.LogHelper$uploadLogFile$2" · "LogHelper.kt" · "invokeSuspend" · "diagnosticId" · "L$0"
- `Object uploadLogFile$default(LogHelper logHelper, DeviceType deviceType, Continuation continuation, int i, Object obj)`  L320
- `Object uploadLogFile(DeviceType deviceType, Continuation<? super FeedbackLogUploadResult> continuation)`  L327
- `String formatToday()`  L331
### `com.tuwinsmart.tuwin.core.util.wifi.LogHelper$C21521`
L60 · [class] static final C21521 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/core/util/wifi/LogHelper.java`
注解：

字段/常量（6）：
- `Object L$0`  L61
- `Object L$1`  L62
- `Object L$2`  L63
- `Object L$3`  L64
- `int label`  L65
- `Object result`  L66

方法（1）：
- `Object invokeSuspend(Object obj)`  L73 @Override
### `com.tuwinsmart.tuwin.core.util.wifi.LogHelper$C21532`
L244 · [class] static final C21532 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super FeedbackLogUploadResult>, Object>` · implements `Function2<CoroutineScope, Continuation<? super FeedbackLogUploadResult>, Object>` · `com/tuwinsmart/tuwin/core/util/wifi/LogHelper.java`
注解：

字段/常量（10）：
- `DeviceType $deviceType`  L245
- `Object L$0`  L246
- `int label`  L247
- `Object objM3074constructorimpl`  L269
- `String str`  L270
- `int i = this.label`  L272
- `Result.Companion companion = Result.INSTANCE`  L278
- `Result.Companion companion2 = Result.INSTANCE`  L281
- `File file = null`  L288
- `DeviceType deviceType = this.$deviceType`  L294

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L256 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super FeedbackLogUploadResult> continuation)`  L263 @Override
- `Object invokeSuspend(Object obj)`  L268 @Override
### `com.tuwinsmart.tuwin.core.util.wifi.manager.WiFiManagerWrapper`
L16 · [class] public final WiFiManagerWrapper · `com/tuwinsmart/tuwin/core/util/wifi/manager/WiFiManagerWrapper.java`
注解：

字段/常量（2）：
- `WiFiSwitch wiFiSwitch`  L17
- `WifiManager wifiManager`  L18

方法（8）：
- `public WiFiManagerWrapper(WifiManager wifiManager, WiFiSwitch wiFiSwitch)`  L20
    - 体内字面量："wifiManager" · "wiFiSwitch"
- ` WiFiManagerWrapper(WifiManager wifiManager, WiFiSwitch wiFiSwitch, int i, DefaultConstructorMarker defaultConstructorMarker)`  L27
- `boolean wiFiEnabled()`  L31
- `boolean enableWiFi()`  L39
- `boolean disableWiFi()`  L47
- `boolean startScan()`  L55
- `List<ScanResult> scanResults()`  L63
- `WifiInfo wiFiInfo()`  L72
### `com.tuwinsmart.tuwin.core.util.wifi.manager.WiFiSwitch`
L16 · [class] public final WiFiSwitch · `com/tuwinsmart/tuwin/core/util/wifi/manager/WiFiSwitch.java`
注解：

字段/常量（1）：
- `WifiManager wifiManager`  L17

方法（8）：
- `public WiFiSwitch(WifiManager wifiManager)`  L19
    - 体内字面量："wifiManager"
- `boolean m525on()`  L25
- `boolean off()`  L29
- `void startWiFiSettings()`  L33
    - 体内字面量："android.settings.panel.action.WIFI"
- `boolean minVersionQ()`  L40
- `boolean enable(boolean enabled)`  L44
- `boolean enableWiFiAndroidQ()`  L48
- `boolean enableWiFiLegacy(boolean enabled)`  L53