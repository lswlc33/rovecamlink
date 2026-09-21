# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.util

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 15 个文件 / 21 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.util.CameraInforLocalDataUtils`
L9 · [class] public CameraInforLocalDataUtils · `com/gku/actioncam/sigmastar/util/CameraInforLocalDataUtils.java`

字段/常量（5）：
- `CameraInforLocalDataUtils cameraInforLocalDataUtils`  L10
- `String FILE_NAME = "my_cameraInfors"`  L11
- `String KEY = "cameraInfor"`  L12
- `SharedPreferences.Editor editor`  L13
- `SharedPreferences sp`  L14

方法（6）：
- `void setIs_down_success(String key, boolean value)`  L16
- `CameraInforLocalDataUtils getInstance()`  L19
- `private CameraInforLocalDataUtils()`  L30
    - 体内字面量："my_cameraInfors"
- `CameraInfors getCameraInfors()`  L36
    - 体内字面量："cameraInfor"
- `void setCameraInfors(CameraInfors cameraInfors)`  L44
    - 体内字面量："cameraInfor"
- `CameraInfors getIs_down_success(String key)`  L50
    - 体内字面量："cameraInfor"
### `com.gku.actioncam.sigmastar.util.ClearGlideCacheTask`
L9 · [class] public ClearGlideCacheTask · extends `AsyncTask<Void, Void, Void>` · `com/gku/actioncam/sigmastar/util/ClearGlideCacheTask.java`

字段/常量（1）：
- `String TAG = "ClearGlideCacheTask"`  L10

方法（2）：
- `Void doInBackground(Void... voids)`  L14 @Override
    - 体内字面量："doInBackground: clearDiskCache"
- `void onPostExecute(Void aVoid)`  L22 @Override
    - 体内字面量："onPostExecute: clearMemory"
### `com.gku.actioncam.sigmastar.util.DataCleanManager`
L10 · [class] public DataCleanManager · `com/gku/actioncam/sigmastar/util/DataCleanManager.java`

字段/常量（6）：
- `long length`  L68
- `long j = 0`  L69
- `double d = size / 1024.0d`  L130
- `double d2 = d / 1024.0d`  L134
- `double d3 = d2 / 1024.0d`  L138
- `double d4 = d3 / 1024.0d`  L142

方法（15）：
- `void cleanInternalCache(Context context)`  L11
- `void cleanDatabases(Context context)`  L15
    - 体内字面量："/data/data/" · "/databases"
- `void cleanSharedPreference(Context context)`  L19
    - 体内字面量："/data/data/" · "/shared_prefs"
- `void cleanDatabaseByName(Context context, String dbName)`  L23
- `void cleanFiles(Context context)`  L27
- `boolean cleanExternalCache(Context context)`  L31
    - 体内字面量："mounted"
- `void cleanCustomCache(String filePath)`  L38
- `void cleanApplicationData(Context context, String... filepath)`  L42
- `boolean deleteFilesByDirectory(File dir)`  L56
- `long getFolderSize(File file)`  L67
- `void deleteFolderFile(String filePath, boolean deleteThisPath)`  L86
- `String getCacheSize(Context context)`  L109
    - 体内字面量："mounted"
- `long getCacheSizeInt(Context context)`  L117
    - 体内字面量："mounted"
- `void clearIntExtCache(Context context)`  L122
    - 体内字面量："mounted"
- `String getFormatSize(double size)`  L129
### `com.gku.actioncam.sigmastar.util.FileUtils`
L27 · [class] public FileUtils · `com/gku/actioncam/sigmastar/util/FileUtils.java`

字段/常量（8）：
- `String MEDIA_DIR = "SportCam"`  L28
- `Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI`  L53
- `Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI`  L55
- `File externalCacheDir`  L75
- `Uri uriInsert`  L115
- `String str = absolutePath + "/Camera"`  L150
- `byte[] bArr = new byte[1024]`  L184
- `File[] fileArrListFiles`  L201

方法（15）：
- `String getMediaPath()`  L30
    - 体内字面量："/" · "FileUtils" · "getMediaPath: "
- `boolean isFileExist(String path)`  L39
- `long getFreeSize(String path)`  L46
- `void delete(String path, Context mContext, int TYPE)`  L51
- `void updateMediaStore(final Context context, final String path)`  L63
- `void onScanCompleted(String path2, Uri uri)`  L66 @Override
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `String getExternalCacheDirectory()`  L74
- `boolean isFileValid(String path)`  L90
- `InputStream path2InputStream(String path)`  L98
- `String getMimeType(File file)`  L110
- `void saveFileToDCIMCamera(Context context, File file)`  L114
- `boolean isVideo(String filename)`  L160
    - 体内字面量：".TS" · ".AVI" · ".MOV"
- `void createDirIfNotExist(String path)`  L165
- `void copyFile(File src, File dest)`  L177
- `boolean deleteFile(File var0)`  L200
### `com.gku.actioncam.sigmastar.util.HttpRequestUtils`
L14 · [class] public HttpRequestUtils · `com/gku/actioncam/sigmastar/util/HttpRequestUtils.java`

字段/常量（7）：
- `HttpRequestUtils httpRequestUtils`  L15
- `RequestCall call`  L16
- `StringCallBack stringCallBack2 = stringCallBack`  L68
- `StringCallBack stringCallBack2 = stringCallBack`  L77
- `StringCallBack stringCallBack2 = stringCallBack`  L86
- `StringCallBack stringCallBack2 = stringCallBack`  L95
- `RequestCall requestCall = this.call`  L108

方法（10）：
- `private HttpRequestUtils()`  L38
- `void log(String message)`  L41 @Override
    - 体内字面量："HttpRequestUtils" · "++++++++"
- `HttpRequestUtils getInstance()`  L49
- `void doRequest(String url, final StringCallBack stringCallBack)`  L60
    - 体内字面量："doRequest url"
- `void onError(Call call, Exception e, int id)`  L66 @Override
    - 体内字面量："doRequest onError"
- `void onResponse(String response, int id)`  L75 @Override
    - 体内字面量："doRequest onResponse"
- `void onBefore(Request request, int id)`  L84 @Override
- `void onAfter(int id)`  L93 @Override
- `void doRequest(String url)`  L103
- `void cancelRequest()`  L107
### `com.gku.actioncam.sigmastar.util.HttpRequestUtils$IStringCallBack`
L18 · [interface] public IStringCallBack · `com/gku/actioncam/sigmastar/util/HttpRequestUtils.java`

方法（4）：
- `void onBefore()`  L19
- `void onError(int code, Exception e)`  L21
- `void onFinish()`  L23
- `void onSuccess(String result)`  L25
### `com.gku.actioncam.sigmastar.util.HttpRequestUtils$StringCallBack`
L28 · [class] public static abstract StringCallBack · implements `IStringCallBack` · `com/gku/actioncam/sigmastar/util/HttpRequestUtils.java`

方法（2）：
- `void onBefore()`  L30 @Override
- `void onFinish()`  L34 @Override
### `com.gku.actioncam.sigmastar.util.OrientationDetector`
L8 · [class] public OrientationDetector · extends `OrientationEventListener` · `com/gku/actioncam/sigmastar/util/OrientationDetector.java`

字段/常量（4）：
- `Activity mActivity`  L9
- `int mOrientation`  L10
- `Activity activity = this.mActivity`  L20
- `int i = this.mOrientation`  L24

方法（3）：
- `public OrientationDetector(Activity activity)`  L12
- `void onOrientationChanged(int orientation)`  L19 @Override
- `void setRequestedOrientation(int orientation)`  L50
### `com.gku.actioncam.sigmastar.util.SaveFileToDcimUtils`
L19 · [class] public SaveFileToDcimUtils · `com/gku/actioncam/sigmastar/util/SaveFileToDcimUtils.java`

字段/常量（9）：
- `OutputStream outputStream`  L20
- `OutputStream outputStream = this.outputStream`  L45
- `Uri uriInsert`  L58
- `OutputStream outputStream`  L59
- `OutputStream outputStream2`  L60
- `FileInputStream fileInputStream = null`  L73
- `OutputStream outputStreamOpenOutputStream = null`  L76
- `FileInputStream fileInputStream2 = null`  L77
- `byte[] bArr = new byte[4096]`  L115

方法（3）：
- `void writeData(Context context, String fileName, byte[] data, int bufferLength)`  L22
    - 体内字面量："_display_name" · "mime_type" · "video/mp4" · "date_added" · "relative_path" · "/ActionCam"
- `void finishWrite()`  L44
- `void copyPrivateToDownload(Context context, String str)`  L57
### `com.gku.actioncam.sigmastar.util.SSDisplayUtil`
L6 · [class] public SSDisplayUtil · `com/gku/actioncam/sigmastar/util/SSDisplayUtil.java`

方法（4）：
- `int px2dip(float pxValue)`  L7
- `int dip2px(float dipValue)`  L11
- `int px2sp(float pxValue)`  L15
- `int sp2px(float spValue)`  L19
### `com.gku.actioncam.sigmastar.util.SSDownloadUtil`
L27 · [class] public SSDownloadUtil · `com/gku/actioncam/sigmastar/util/SSDownloadUtil.java`

字段/常量（11）：
- `SSDownloadUtil SSDownloadUtil = null`  L28
- `String TAG = "SSDownloadUtil"`  L29
- `Call currentDownloadCall`  L30
- `String savePath`  L31
- `boolean isSyncMultipleDownloadTaskCancel = false`  L34
- `Call call = this.currentDownloadCall`  L62
- `String str = TAG`  L72
- `SSHttpClientUtil.DownloadCallback downloadCallback2`  L92
- `SSHttpClientUtil.DownloadCallback downloadCallback3 = downloadCallback`  L114
- `SSHttpClientUtil.DownloadCallback downloadCallback4 = downloadCallback`  L129
- `ArrayList arrayList = ssFileInfoBeans`  L188

方法（13）：
- `SSDownloadUtil getInstance()`  L36
- `void singleSyncDownload(String downloadPath, final String savePath, final SSHttpClientUtil.DownloadCallback downloadCallback)`  L47
- `void onSuccess(Response response)`  L50 @Override
- `void onFailure(Exception exception)`  L55 @Override
- `void cancelHTTPSyncMultipleDownload()`  L61
- `void multipleSyncDownload(final ArrayList<SSFileInfoBean> ssFileInfoBeans, final boolean isAmba, final SSHttpClientUtil.DownloadCallback downloadCallback)`  L71
- `void onItemClick(float progress, File file)`  L91 @Override
- `void onSuccess(Response response)`  L157 @Override
    - 体内字面量："multipleSyncDownload onSuccess ssFileInfoBeans.size=" · "multipleSyncDownload åºç°äºlistè¢«æ¸ç©ºçæåµ" · "multipleSyncDownload onSuccess isSyncMultipleDownloadTaskCancel="
- `void onFailure(Exception exception)`  L187 @Override
- `void saveClassify()`  L215
    - 体内字面量："delete files in files"
- `long getphonesize()`  L231
- `ArrayList<SSFileInfoBean> getFileListFromCache()`  L236
    - 体内字面量："download_file_list" · "file_list"
- `void setFileListToCache(ArrayList<SSFileInfoBean> fileList)`  L245
    - 体内字面量："download_file_list" · "file_list"
### `com.gku.actioncam.sigmastar.util.SSExchangeWorkMode`
L10 · [class] public SSExchangeWorkMode · `com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java`

字段/常量（17）：
- `String SS_BURST_PHOTO = "Burst Photo"`  L11
- `String SS_CAR_LOOPING = "Car Looping"`  L12
- `String SS_LAPSE_PHOTO = "Lapse Photo"`  L13
- `String SS_LAPSE_PHOTO_OLD = "Timelapse Photo"`  L14
- `String SS_LAPSE_VIDEO = "Timelapse Video"`  L15
- `String SS_LONG_EXPOSURE = "Long Exposure"`  L16
- `String SS_NORMAL_PHOTO = "Normal Photo"`  L17
- `String SS_NORMAL_VIDEO = "Normal Video"`  L18
- `String SS_QUICK_STORIES = "Quick Stories"`  L19
- `String SS_QUICK_VIDEO = "Quick Video"`  L20
- `String SS_RAW_PHOTO = "Raw Photo"`  L21
- `String SS_SLOW_MOTION = "Slow Motion"`  L22
- `String SS_TIMING_PHOTO = "Timing Photo"`  L23
- `String SS_UNDER_WATER = "Under Water"`  L24
- `String SS_VIDEO_PHOTO = "Video and Photo"`  L25
- `ArrayList<String> arrayList`  L28
- `ArrayList<String> arrayList`  L33

方法（9）：
- `boolean isVideoMode(HashMap<String, ArrayList<String>> allWorkMode, String curWorkMode)`  L27
- `boolean isPhotoMode(HashMap<String, ArrayList<String>> allWorkMode, String curWorkMode)`  L32
- `String getPhotoType()`  L37
    - 体内字面量："photo"
- `String getFastSettingCurParamName(String workMode)`  L41
    - 体内字面量："Timing Photo" · "Self-Timer" · "Timelapse Photo" · "Timelapse Video" · "Time Lapse" · "Burst Photo" · "Number" · "Quick Stories" · "Duration"
- `boolean isWorkModeNeedFastSetting(String workMode)`  L61
- `int workModeToResId(String mode)`  L68
    - 体内字面量："ic_image_" · "drawable" · "_unselected_yutupro" · "mipmap"
- `int workModeToSelectedYUTUproResId(String mode)`  L76
    - 体内字面量："_selected_yutupro" · "mipmap"
- `int workModeToMiniYUTUproResId(String mode)`  L81
    - 体内字面量："_mini_yutupro" · "mipmap"
- `String exchangeWorkMode(String mode)`  L86
    - 体内字面量："Normal Photo_caddx" · "Normal Video_caddx" · "Raw_caddx" · "Lapse Video" · "VideoLapse_caddx" · "SlowRec_caddx" · "loopvideo_caddx" · "Video+Photo" · "VideoPhoto_caddx" · "PhotoLapse_caddx" · "TimerPhoto_caddx" · "Burst_caddx" · "Night Timelapse Photo_caddx" · "Lapse Video" · "VideoLapse" · "SlowRec" · "CarMode" · "Video+Photo" · "VideoPhoto" · "PhotoLapse" · "TimerPhoto" · "Burst" · "Night Timelapse Photo"
### `com.gku.actioncam.sigmastar.util.SSFileUtil`
L28 · [class] public SSFileUtil · `com/gku/actioncam/sigmastar/util/SSFileUtil.java`

字段/常量（3）：
- `String TAG = "SSFileUtil"`  L29
- `byte[] bArr = new byte[1024]`  L53
- `File[] fileArrListFiles`  L104

方法（19）：
- `void deleteFileIfExits(final String path)`  L32 @Deprecated
- `void run()`  L35 @Override
- `void lambda$deleteFileIfExits$0(String str)`  L41
    - 体内字面量："delete "
- `String md5HashCode(String filePath)`  L49 @Deprecated
- `void loadImageIntoImageView(Context context, String path, ImageView imageView)`  L69
- `boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource)`  L75 @Override
- `boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource)`  L80 @Override
- `ArrayList<String> allLocalVideoMD5()`  L87 @Deprecated
- `boolean isFileLocalExists(String localPath)`  L96
- `List<String> fileListScan(String scanDir)`  L103
- `String pathShortName(String path)`  L118
    - 体内字面量："/"
- `String getPathSuffix(String path)`  L125
- `int getVideoTime(String path)`  L132
- `boolean isLocalNormalVideo(String localPath)`  L138
    - 体内字面量："s.mp4"
- `boolean isLocalHDVideo(String localPath)`  L142
    - 体内字面量："mp4"
- `boolean isLocalPhoto(String localPath)`  L146
    - 体内字面量："dng" · "jpg" · "png"
- `boolean clearCache()`  L150
- `boolean clearThumbCache()`  L155
    - 体内字面量："clearThumbCache: unExists"
- `void clearGlideCache()`  L170
### `com.gku.actioncam.sigmastar.util.SSHttpClientUtil`
L33 · [class] public SSHttpClientUtil · `com/gku/actioncam/sigmastar/util/SSHttpClientUtil.java`

字段/常量（9）：
- `String TAG = "SSHttpClientUtil"`  L35
- `int TIMEOUT_SECONDS = 3`  L36
- `OkHttpClient okHttpClient = null`  L37
- `int sBufferSize = 524288`  L38
- `byte[] bArr = new byte[sBufferSize]`  L156
- `long j = 0`  L158
- `BufferedOutputStream bufferedOutputStream = null`  L333
- `byte[] bArr = new byte[sBufferSize]`  L343
- `int i = 0`  L344

方法（16）：
- `void initHttpClient()`  L60
    - 体内字面量："http-cache"
- `void setsBufferSize(int sBufferSize2)`  L68
- `Call GET(String baseUrl)`  L72
- `Call GET(URL url)`  L83
- `Call POST(String baseUrl, RequestBody requestBody)`  L88
- `Call POST(URL url, RequestBody requestBody)`  L99
- `void SYNC(final Call call, final OkHttpCallback okHttpCallBack)`  L104
- `void run()`  L107 @Override
- `void lambda$SYNC$0(OkHttpCallback okHttpCallback, Call call)`  L113
- `Response SYNC(Call call)`  L122
- `void ASYNC(Call call, Callback callback)`  L134
- `void HTTP_DOWNLOAD(Response response, String savePath, DownloadCallback downloadCallback)`  L138
    - 体内字面量："Download params error"
- `File createOrExistsFile(String path, DownloadCallback downloadCallback)`  L200 @Deprecated
    - 体内字面量："File operation create"
- `void SOCKET_WRITE(Socket socket, String content)`  L214
- `String SOCKET_READ(Socket socket)`  L256
- `void SOCKET_DOWNLOAD(Socket socket, String str, DownloadCallback downloadCallback)`  L324
    - 体内字面量："Download params error"
### `com.gku.actioncam.sigmastar.util.SSHttpClientUtil$DownloadCallback`
L40 · [interface] public DownloadCallback · `com/gku/actioncam/sigmastar/util/SSHttpClientUtil.java`

方法（6）：
- `void allTaskFinish()`  L41
- `void downloadFinish(String savePath)`  L43
- `void downloadTaskFailure(String path, String errMsg)`  L45
- `void notEnoughSpace()`  L47
- `void startDownload(String currentPath)`  L49
- `void updateProgress(String currentPath, float progress)`  L51
### `com.gku.actioncam.sigmastar.util.SSHttpClientUtil$OkHttpCallback`
L54 · [interface] public OkHttpCallback · `com/gku/actioncam/sigmastar/util/SSHttpClientUtil.java`

方法（2）：
- `void onFailure(Exception exception)`  L55
- `void onSuccess(Response response)`  L57
### `com.gku.actioncam.sigmastar.util.SSRequest`
L12 · [class] public SSRequest · `com/gku/actioncam/sigmastar/util/SSRequest.java`

字段/常量（9）：
- `Call call`  L13
- `boolean inMainThead`  L14
- `SSRequestCallback ssRequestCallback = null`  L15
- `int SUCCESS_CODE = 11000`  L16
- `int FAILURE_CODE = 11001`  L17
- `int CANCAL = 11002`  L18
- `int STARTREQUEST = 11003`  L19
- `int ENDREQUEST = 11004`  L20
- `Call call = this.call`  L171

方法（11）：
- `void handleMessage(Message msg)`  L23 @Override
- `SSRequest setRequestCallback(SSRequestCallback ssRequestCallback)`  L78
- `SSRequest setRequestCallback(SSRequestCallback ssRequestCallback, boolean inMainThead)`  L84
- `void requestAsync(String requestCommand)`  L90
    - 体内字面量："call can not null" · "call can not null"
- `void onFailure(Call call, IOException e)`  L113 @Override
- `void onResponse(Call call, Response response)`  L127 @Override
- `void requestSync(String requestCommand)`  L142
    - 体内字面量："call can not null"
- `void onSuccess(Response response)`  L152 @Override
- `void onFailure(Exception exception)`  L158 @Override
- `Response syncRequest(String requestCommand)`  L166
- `void cancel()`  L170
### `com.gku.actioncam.sigmastar.util.SSRequest$SSRequestCallback`
L57 · [interface] public SSRequestCallback · extends `SSHttpClientUtil.OkHttpCallback` · `com/gku/actioncam/sigmastar/util/SSRequest.java`

方法（3）：
- `void endRequest()`  L71
- `void onCancel()`  L73
- `void startRequest()`  L75
### `com.gku.actioncam.sigmastar.util.SSRequest$SSRequestCallback$CC`
L60 · [class] public final CC · `com/gku/actioncam/sigmastar/util/SSRequest.java`

方法（3）：
- `void $default$endRequest(SSRequestCallback _this)`  L61
- `void $default$onCancel(SSRequestCallback _this)`  L64
- `void $default$startRequest(SSRequestCallback _this)`  L67
### `com.gku.actioncam.sigmastar.util.SystemBarTintManager`
L10 · [class] public SystemBarTintManager · `com/gku/actioncam/sigmastar/util/SystemBarTintManager.java`

方法（2）：
- `void initWindowBar(Activity activity)`  L11
- `void initWindowBarWel(Activity activity)`  L23
### `com.gku.actioncam.sigmastar.util.SystemUtil`
L9 · [class] public SystemUtil · `com/gku/actioncam/sigmastar/util/SystemUtil.java`

字段/常量（15）：
- `String PHONE_HONOR = "HONOR"`  L10
- `String PHONE_HTC = "htc"`  L11
- `String PHONE_HUAWEI = "Huawei"`  L12
- `String PHONE_LENOVO = "lenovo"`  L13
- `String PHONE_LG = "lg"`  L14
- `String PHONE_Letv = "letv"`  L15
- `String PHONE_MEIZU = "Meizu"`  L16
- `String PHONE_NOVA = "nova"`  L17
- `String PHONE_OPPO = "OPPO"`  L18
- `String PHONE_OnePlus = "OnePlus"`  L19
- `String PHONE_SAMSUNG = "samsung"`  L20
- `String PHONE_SMARTISAN = "smartisan"`  L21
- `String PHONE_SONY = "sony"`  L22
- `String PHONE_VIVO = "vivo"`  L23
- `String PHONE_XIAOMI = "xiaomi"`  L24

方法（6）：
- `String getSystemLanguage()`  L26
- `Locale[] getSystemLanguageList()`  L30
- `String getSystemVersion()`  L34
- `String getSystemModel()`  L38
- `String getDeviceBrand()`  L42
- `String getIMEI(Context ctx)`  L46
    - 体内字面量："phone"