# idGoLive — 类与成员明细：com.icatch.golive.utils

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 43 个文件 / 50 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.utils.BitmapTools`
L10 · [class] public BitmapTools · `com/icatch/golive/utils/BitmapTools.java`

字段/常量（8）：
- `long LIMITED_IMGAE_SIZE = 10485760`  L11
- `String TAG = "BitmapTools"`  L12
- `int THUMBNAIL_HEIGHT = 100`  L13
- `int THUMBNAIL_WIDTH = 100`  L14
- `int i3 = options.outHeight`  L17
- `int i4 = options.outWidth`  L18
- `int i5 = 1`  L19
- `float width`  L94

方法（8）：
- `int calculateInSampleSize(BitmapFactory.Options options, int i, int i2)`  L16
- `Bitmap decodeByteArray(byte[] bArr)`  L32
    - 体内字面量："start decodeByteArray" · "end decodeByteArray bitmap="
- `Bitmap decodeByteArray(byte[] bArr, int i, int i2)`  L45
- `Bitmap getImageByPath(String str, int i, int i2)`  L55
    - 体内字面量："Start getImageByPath imagePath="
- `int getImageHeight(String str)`  L68
- `int getImageWidth(String str)`  L75
- `Bitmap getVideoThumbnail(String str, int i, int i2)`  L82
    - 体内字面量："start getVideoThumbnail videoPath=" · "End getVideoThumbnail bitmap="
- `Bitmap zoomBitmap(Bitmap bitmap, float f, float f2)`  L93
### `com.icatch.golive.utils.ClickUtils`
L7 · [class] public ClickUtils · `com/icatch/golive/utils/ClickUtils.java`

字段/常量（5）：
- `long MIN_CLICK_DELAY_TIME = 500`  L8
- `long lastClickTime`  L9
- `int mLastClickViewId`  L10
- `long j = jCurrentTimeMillis - lastClickTime`  L33
- `long j = jCurrentTimeMillis - lastClickTime`  L46

方法（4）：
- `boolean isFastClick()`  L12
    - 体内字面量："ClickUtils" · "isFastClick"
- `boolean isFastDoubleClick()`  L22
- `boolean isFastDoubleClick(int i)`  L31
- `boolean isFastDoubleClick(View view)`  L43
### `com.icatch.golive.utils.ConvertTools`
L11 · [class] public ConvertTools · `com/icatch/golive/utils/ConvertTools.java`

字段/常量（14）：
- `double GB = 1.073741824E9d`  L12
- `double KB = 1024.0d`  L13
- `double MB = 1048576.0d`  L14
- `String TAG = "ConvertTools"`  L15
- `String timeFormatFromApp = "yyyy-MM-dd HH:mm:ss"`  L16
- `String timeFormatFromFw = "yyyyMMdd'T'HHmmss"`  L17
- `double d = j`  L21
- `Date date`  L32
- `Date date`  L46
- `int i2 = 16777215 & i`  L59
- `Date date`  L66
- `String str2 = strArrSplit[0] + "?W=" + strArrSplit[1] + "&H=" + strArrSplit[2] + "&BR=" + strArrSplit[3]`  L86
- `String str`  L108
- `String str`  L125

方法（10）：
- `String ByteConversionGBMBKB(long j)`  L19
    - 体内字面量："######0.0"
- `long getDateTime(String str)`  L31
- `String getDateTimeString(String str)`  L45
- `String getExposureCompensation(int i)`  L56
    - 体内字面量："start getExposureCompensation value=" · "EV -" · "EV "
- `String getTimeByfileDate(String str)`  L65
- `String millisecondsToMinuteOrHours(int i)`  L76
- `String resolutionConvert(String str)`  L80
    - 体内字面量："start resolution = " · "\\?|&" · "W=" · "H=" · "BR="
- `String secondsToHours(int i)`  L98
    - 体内字面量：":" · ":"
- `String secondsToMinute(int i)`  L107
- `String secondsToMinuteOrHours(int i)`  L124
### `com.icatch.golive.utils.CrashHandler`
L23 · [class] public CrashHandler · implements `Thread.UncaughtExceptionHandler` · `com/icatch/golive/utils/CrashHandler.java`

字段/常量（5）：
- `String TAG = "CrashHandler"`  L25
- `Context mContext`  L26
- `Thread.UncaughtExceptionHandler mDefaultHandler`  L27
- `String str = packageInfo.versionName == null ? "null" : packageInfo.versionName`  L99
- `String str2 = packageInfo.versionCode + "<binary/metadata>"`  L100

方法（10）：
- `private CrashHandler()`  L32
- `CrashHandler getInstance()`  L35
- `void getStackTrace(Throwable th)`  L39
- `void getThreadStackTrace(Thread thread)`  L51
    - 体内字面量："thread id:" · " name:"
- `boolean handleException(Thread thread, final Throwable th)`  L68
- `void run()`  L74 @Override
    - 体内字面量："\n" · "localizedMessage" · "null" · "null"
- `void collectDeviceInfo(Context context)`  L95
- `void init(Context context)`  L118
- `void uncaughtException(Thread thread, Throwable th)`  L125 @Override
    - 体内字面量："....default process!" · "....show custom process!"
- `void run()`  L139 @Override
### `com.icatch.golive.utils.DateUtils`
L8 · [class] public DateUtils · `com/icatch/golive/utils/DateUtils.java`

方法（2）：
- `String getHourMinuteSecond(Date date)`  L9
    - 体内字面量："HH:mm:ss"
- `String getYearMonthDay(Date date)`  L13
    - 体内字面量："yyyy-MM-dd"
### `com.icatch.golive.utils.DialogUtils`
L15 · [class] public DialogUtils · `com/icatch/golive/utils/DialogUtils.java`

方法（3）：
- `void closeDialog(Dialog dialog)`  L16
- `Dialog createLoadingDialog(Context context, String str)`  L23
- `Dialog createLoadingDialog(Context context, String str, boolean z)`  L27
### `com.icatch.golive.utils.DisplayHelper`
L18 · [class] public DisplayHelper · `com/icatch/golive/utils/DisplayHelper.java`

字段/常量（5）：
- `String TAG = "Devices"`  L19
- `float sDensity = 0.0f`  L21
- `Boolean sHasCamera = null`  L22
- `int iIntValue = displayMetrics.widthPixels`  L75
- `int iIntValue2 = displayMetrics.heightPixels`  L76

方法（24）：
- `void cancelFullScreen(Context context)`  L24
- `int dp2px(Context context, int i)`  L34
- `int dpToPx(int i)`  L38
- `int getActionBarHeight(Context context)`  L42
- `String getCurCountryLan(Context context)`  L50
    - 体内字面量："-"
- `float getDensity(Context context)`  L54
- `DisplayMetrics getDisplayMetrics(Context context)`  L61
    - 体内字面量："window"
- `int getNavMenuHeight(Context context)`  L67
- `int[] getRealScreenSize(Context context)`  L71
    - 体内字面量："window"
- `int getScreenHeight(Context context)`  L92
- `int getScreenWidth(Context context)`  L96
- `int getStatusBarHeight(Context context)`  L100
    - 体内字面量："com.android.internal.R$dimen" · "status_bar_height"
- `boolean hasCamera(Context context)`  L110
    - 体内字面量："android.hardware.camera.front" · "android.hardware.camera"
- `boolean hasHardwareMenuKey(Context context)`  L118
- `boolean hasInternet(Context context)`  L122
    - 体内字面量："connectivity"
- `boolean hasStatusBar(Context context)`  L126
- `boolean isElevationSupported()`  L130
- `boolean isFullScreen(Activity activity)`  L134
- `boolean isPackageExist(Context context, String str)`  L138
- `boolean isSdcardReady()`  L145
    - 体内字面量："mounted"
- `boolean isZhCN(Context context)`  L149
    - 体内字面量："CN"
- `int px2dp(Context context, int i)`  L153
- `int pxToDp(float f)`  L157
- `void setFullScreen(Context context)`  L161
### `com.icatch.golive.utils.FileFilter`
L10 · [class] public FileFilter · `com/icatch/golive/utils/FileFilter.java`

字段/常量（14）：
- `int TIME_TYPE_ALL_TIME = 6`  L11
- `int TIME_TYPE_ALMOST_A_MONTH = 3`  L12
- `int TIME_TYPE_ALMOST_A_WEEK = 2`  L13
- `int TIME_TYPE_CUSTOMIZE = 5`  L14
- `int TIME_TYPE_LAST_HALF_YEAR = 4`  L15
- `int TIME_TYPE_LAST_THREE_DAY = 1`  L16
- `int TIME_TYPE_TODAY = 0`  L17
- `String formatType = "yyyy-MM-dd HH:mm:ss"`  L18
- `String timeFormat = "yyyyMMddHHmmss"`  L19
- `long endTime`  L20
- `long startTime`  L21
- `int sensorType = 0`  L22
- `int timeFilterType = 6`  L23
- `int i = this.timeFilterType`  L46

方法（12）：
- `long getEndTime()`  L25
- `long getStartTime()`  L37
- `String getEndTimeString()`  L69
- `int getSensorType()`  L73
- `String getStringTimeString()`  L77
- `int getTimeFilterType()`  L81
- `boolean isLess(ICatchFile iCatchFile)`  L85
- `boolean isMatch(ICatchFile iCatchFile)`  L92
- `void setEndTime(long j)`  L100
- `void setSensorType(int i)`  L104
- `void setStartTime(long j)`  L108
- `void setTimeFilterType(int i)`  L112
### `com.icatch.golive.utils.fileutils.FileNameSorter`
L11 · [class] public FileNameSorter · `com/icatch/golive/utils/fileutils/FileNameSorter.java`

方法（3）：
- `String extractDateTimeKey(String str)`  L13
    - 体内字面量：".MP4" · "(\\d{4}-\\d{2}-\\d{2})_(\\d{2})_(\\d{2})_(\\d{2})" · "-" · "(\\d{8})[_-]?(\\d{6})" · "(\\d{14})"
- `void sortFilesByDateTimeDesc(List<FileItemInfo> list)`  L32
- `Object apply(Object obj)`  L35 @Override
### `com.icatch.golive.utils.fileutils.FileOper`
L11 · [class] public FileOper · `com/icatch/golive/utils/fileutils/FileOper.java`

字段/常量（1）：
- `String TAG = "FileOper"`  L12

方法（3）：
- `void createDirectory(String str)`  L14
- `void createFile(String str, String str2)`  L24
    - 体内字面量："FileOper" · "start createFile" · "FileOper" · "directoryPath+fileName =" · "FileOper" · "file is not exists,need to create!" · "FileOper" · "FileNotFoundException" · "FileOper" · "IOException"
- `File getAppSpecificAlbumStorageDir(Context context, String str)`  L49
    - 体内字面量："getAppSpecificAlbumStorageDir path:"
### `com.icatch.golive.utils.fileutils.FileTools`
L26 · [class] public FileTools · `com/icatch/golive/utils/fileutils/FileTools.java`

字段/常量（15）：
- `String FILENAME_SEQUENCE_SEPARATOR = "-"`  L27
- `String TAG = "FileTools"`  L28
- `String[] Urls`  L29
- `String str2 = strSubstring + strSubstring2`  L46
- `String str3 = strSubstring + FILENAME_SEQUENCE_SEPARATOR`  L51
- `int i = 1`  L52
- `FileOutputStream fileOutputStream`  L64
- `InputStream inputStream = null`  L78
- `byte[] bArr = new byte[1024]`  L87
- `long fileSize = 0`  L158
- `FileInputStream fileInputStream`  L273
- `Throwable th`  L274
- `ObjectInputStream objectInputStream`  L275
- `FileOutputStream fileOutputStream`  L359
- `ObjectOutputStream objectOutputStream = null`  L371

方法（16）：
- `boolean checkFwUpgradeFile(String str, String str2)`  L31
- `String chooseUniqueFilename(String str)`  L40
    - 体内字面量："error" · "." · "."
- `void copyFile(int i, String str)`  L63
- `String getFileDate(String str)`  L142
    - 体内字面量："file neme" · "file.lastModified()" · "yyyy-MM-dd"
- `long getFileSize(File file)`  L156
- `String[] getFileUrls(String str, FileType fileType)`  L165
    - 体内字面量："Start getUrls path=" · "Start getUrls temp=" · "Start getUrls temp size=" · ".jpg" · ".png" · ".PNG" · ".JPG" · ".MP4" · ".wmv" · ".mp4" · ".3gp" · ".MOV" · ".mov" · ".AVI" · ".avi" · "Urls.length =="
- `List<File> getFilesOrderByDate(String str)`  L193
    - 体内字面量："Start getFilesOrderByDate filePath=" · "Start getFilesOrderByDate file=" · "Start getFilesOrderByDate fileArray=" · "Start getFilesOrderByDate size=" · "Start getFilesOrderByDate 2"
- `int compare(File file2, File file3)`  L207 @Override
- `boolean equals(Object obj)`  L216 @Override
    - 体内字面量："End getFilesOrderByDate"
- `List<File> getFilesOrderByLength(String str)`  L224
- `int compare(File file, File file2)`  L228 @Override
- `boolean equals(Object obj)`  L237 @Override
- `List<File> getFilesOrderByName(String str)`  L248
- `int compare(File file, File file2)`  L252 @Override
- `Serializable readSerializable(String str)`  L272
- `boolean saveSerializable(String str, Serializable serializable)`  L358
### `com.icatch.golive.utils.fileutils.FileUtil`
L26 · [class] public FileUtil · `com/icatch/golive/utils/fileutils/FileUtil.java`

字段/常量（20）：
- `String TAG = "FileUtil"`  L27
- `FileOutputStream fileOutputStream`  L38
- `InputStream inputStreamOpenInputStream = null`  L39
- `byte[] bArr = new byte[4096]`  L70
- `String str4`  L145
- `Throwable th`  L146
- `File file`  L147
- `?? r11`  L148
- `Uri uriInsert`  L149
- `?? r12`  L150
- `OutputStream outputStream`  L151
- `OutputStream outputStreamOpenOutputStream`  L152
- `String strSubstring = str2`  L153
- `FileInputStream fileInputStream = null`  L154
- `Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI`  L164
- `String str5 = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO`  L166
- `byte[] bArr = new byte[4096]`  L278
- `int iDelete = -1`  L401
- `int i = 1`  L420
- `int i2 = 0`  L427

方法（9）：
- `Uri copyFileToCache(Context context, Uri uri, String str, String str2)`  L37
- `Uri copyPrivateToDCIM(Context context, String str, String str2, String str3)`  L122
- `Uri copyPrivateToDCIM(Context context, String str, String str2, String str3, boolean z)`  L144
- `int deleteFile(Context context, Uri uri)`  L390
    - 体内字面量："deleteFile: "
- `int deleteFile(Context context, LocalFileInfo localFileInfo)`  L400
- `int deleteImageFile(Context context, long j)`  L415
    - 体内字面量："_id=?"
- `List<LocalFileInfo> queryFileList(Context context, String str, Uri uri)`  L419
- `List<LocalFileInfo> queryImageFileList(Context context, String str)`  L465
    - 体内字面量："queryImageFileList relativePath:"
- `List<LocalFileInfo> queryVideoFileList(Context context, String str)`  L473
    - 体内字面量："queryVideoFileList relativePath:"
### `com.icatch.golive.utils.fileutils.LocalFileInfo`
L9 · [class] public LocalFileInfo · implements `Serializable` · `com/icatch/golive/utils/fileutils/LocalFileInfo.java`

字段/常量（11）：
- `String absolutePath`  L10
- `long duration`  L11
- `int height`  L12
- `long id`  L13
- `String mimeType`  L14
- `long modifyTime`  L15
- `String name`  L16
- `String relativePath`  L17
- `long size`  L18
- `int width`  L19
- `Uri contentUri`  L22

方法（1）：
- `Uri getUri()`  L21
### `com.icatch.golive.utils.fileutils.MFileTools`
L9 · [class] public MFileTools · extends `FileTools` · `com/icatch/golive/utils/fileutils/MFileTools.java`

字段/常量（3）：
- `String TAG = "MFileTools"`  L10
- `String str2 = TAG`  L49
- `String str2 = TAG`  L73

方法（6）：
- `String getNewestPhotoFromDirectory(String str)`  L12
    - 体内字面量："getNewestPhotoFromDirectory = null" · "getNewestPhotoFromDirectory path ="
- `String getNewestVideoFromDirectory(String str)`  L22
    - 体内字面量："getNewestVideoFromDirectory path ="
- `List<File> getPhotosOrderByDate(String str)`  L31
    - 体内字面量："start getPhotosOrderByDate" · ".jpg" · ".png" · ".PNG" · ".JPG" · "end getPhotosOrderByDate"
- `int getPhotosSize(String str)`  L48
- `List<File> getVideosOrderByDate(String str)`  L57
    - 体内字面量：".MP4" · ".wmv" · ".mp4" · ".3gp" · ".MOV" · ".mov" · ".AVI" · ".avi"
- `int getVideosSize(String str)`  L72
### `com.icatch.golive.utils.FirmwareDownloader`
L14 · [class] public FirmwareDownloader · `com/icatch/golive/utils/FirmwareDownloader.java`

字段/常量（2）：
- `byte[] bArr = new byte[8192]`  L46
- `long j = 0`  L47

方法（3）：
- `void downloadFile(String str, final File file, final ProgressListener progressListener)`  L25
- `void onFailure(Call call, IOException iOException)`  L28 @Override
- `void onResponse(Call call, Response response)`  L33 @Override
    - 体内字面量："æå¡ç«¯éè¯¯: "
### `com.icatch.golive.utils.FirmwareDownloader$ProgressListener`
L17 · [interface] public ProgressListener · `com/icatch/golive/utils/FirmwareDownloader.java`

方法（3）：
- `void onComplete(File file)`  L18
- `void onError(String str)`  L20
- `void onProgress(long j, long j2)`  L22
### `com.icatch.golive.utils.FixedSpeedScroller`
L9 · [class] public FixedSpeedScroller · extends `Scroller` · `com/icatch/golive/utils/FixedSpeedScroller.java`

字段/常量（1）：
- `int mDuration`  L10

方法（6）：
- `public FixedSpeedScroller(Context context)`  L12
- `public FixedSpeedScroller(Context context, Interpolator interpolator)`  L17
- `int getmDuration()`  L22
- `void setmDuration(int i)`  L26
- `void startScroll(int i, int i2, int i3, int i4)`  L31 @Override
- `void startScroll(int i, int i2, int i3, int i4, int i5)`  L36 @Override
### `com.icatch.golive.utils.GlideUtils`
L10 · [class] public GlideUtils · `com/icatch/golive/utils/GlideUtils.java`

方法（15）：
- `void GuideClearDiskCache(Context context)`  L11
- `void GuideClearMemory(Context context)`  L15
- `void clear(ImageView imageView)`  L19
- `void loadImageView(Context context, String str, ImageView imageView)`  L22
- `void loadImageViewCache(Context context, String str, ImageView imageView)`  L26
- `void loadImageViewCrop(Context context, String str, ImageView imageView)`  L30
- `void loadImageViewDiskCache(Context context, String str, ImageView imageView)`  L34
- `void loadImageViewDynamicGif(Context context, String str, ImageView imageView)`  L38
- `void loadImageViewLoding(Context context, String str, ImageView imageView, int i, int i2)`  L41
- `void loadImageViewLodingSize(Context context, String str, int i, int i2, ImageView imageView, int i3, int i4)`  L45
- `void loadImageViewPriority(Context context, String str, ImageView imageView)`  L49
- `void loadImageViewSize(Context context, String str, int i, int i2, ImageView imageView)`  L53
- `void loadImageViewSkipCacheSize(Context context, String str, int i, int i2, ImageView imageView)`  L57
- `void loadImageViewStaticGif(Context context, String str, ImageView imageView)`  L61
- `void loadImageViewThumbnail(Context context, String str, ImageView imageView)`  L64
### `com.icatch.golive.utils.GpsUtil`
L11 · [class] public GpsUtil · `com/icatch/golive/utils/GpsUtil.java`

方法（4）：
- `boolean checkGPSIsOpen(Context context)`  L12
    - 体内字面量："location" · "gps"
- `boolean isOPen(Context context)`  L16
    - 体内字面量："location" · "gps" · "network"
- `void openGPS(Context context)`  L21
    - 体内字面量："com.android.settings" · "com.android.settings.widget.SettingsAppWidgetProvider" · "android.intent.category.ALTERNATIVE" · "custom:3"
- `void openGpsSettings(Context context)`  L33
    - 体内字面量："android.settings.LOCATION_SOURCE_SETTINGS"
### `com.icatch.golive.utils.imageloader.ICatchtekImageDownloader`
L19 · [class] public ICatchtekImageDownloader · extends `BaseImageDownloader` · `com/icatch/golive/utils/imageloader/ICatchtekImageDownloader.java`

字段/常量（5）：
- `int HTTP_SOCKET_TIMEOUT_MS = 10000`  L20
- `String TAG = "ICatchtekImageDownloader"`  L21
- `long sleep_millis = 1500`  L22
- `MyCamera curCamera`  L33
- `byte[] buffer`  L34

方法（4）：
- `public ICatchtekImageDownloader(Context context)`  L24
- `public ICatchtekImageDownloader(Context context, int i, int i2)`  L28
- `InputStream getStreamFromTUTK(String str, Object obj)`  L32
- `InputStream getStreamFromOtherSource(String str, Object obj)`  L76 @Override
### `com.icatch.golive.utils.imageloader.ImageLoaderConfig`
L19 · [class] public ImageLoaderConfig · `com/icatch/golive/utils/imageloader/ImageLoaderConfig.java`

字段/常量（6）：
- `String TAG = "ImageLoaderConfig"`  L20
- `DiskCache diskCache`  L21
- `FileNameGenerator fileNameGenerator`  L22
- `DisplayImageOptions options`  L23
- `ExecutorService taskExecutor`  L24
- `DiskCache diskCache2 = diskCache`  L27

方法（8）：
- `void clearDiskCache()`  L26
- `DisplayImageOptions getDefaultDisplayOptions()`  L35
- `DisplayImageOptions getDefaultDisplayOptions(int i)`  L39
- `DisplayImageOptions getSingletonDisplayOptions()`  L46
- `void initImageLoader(Context context, ImageDownloader imageDownloader)`  L57
- `void removeDiskCache(String str)`  L80
    - 体内字面量："removeDiskCache ret:" · " url:"
- `void saveDiskCache(String str, Bitmap bitmap)`  L87
    - 体内字面量："saveDiskCache ret:" · " url:" · "saveDiskCache IOException e:"
- `void stopLoad()`  L99
### `com.icatch.golive.utils.imageloader.ImageLoaderUtil`
L14 · [class] public ImageLoaderUtil · `com/icatch/golive/utils/imageloader/ImageLoaderUtil.java`

字段/常量（18）：
- `OnLoadListener onLoadListener2 = onLoadListener`  L46
- `OnLoadListener onLoadListener2 = onLoadListener`  L54
- `OnLoadListener onLoadListener2 = onLoadListener`  L62
- `OnLoadListener onLoadListener2 = onLoadListener`  L86
- `OnLoadListener onLoadListener2 = onLoadListener`  L94
- `OnLoadListener onLoadListener2 = onLoadListener`  L102
- `OnLoadListener onLoadListener2 = onLoadListener`  L118
- `OnLoadListener onLoadListener2 = onLoadListener`  L126
- `OnLoadListener onLoadListener2 = onLoadListener`  L134
- `OnLoadListener onLoadListener2 = onLoadListener`  L150
- `OnLoadListener onLoadListener2 = onLoadListener`  L158
- `OnLoadListener onLoadListener2 = onLoadListener`  L166
- `OnLoadListener onLoadListener2 = onLoadListener`  L186
- `OnLoadListener onLoadListener2 = onLoadListener`  L194
- `OnLoadListener onLoadListener2 = onLoadListener`  L202
- `OnLoadListener onLoadListener2 = onLoadListener`  L218
- `OnLoadListener onLoadListener2 = onLoadListener`  L226
- `OnLoadListener onLoadListener2 = onLoadListener`  L234

方法（39）：
- `void destroyLoad()`  L24
- `DisplayImageOptions getDefaultDisplayOptions(int i)`  L30
- `DisplayImageOptions getDelayDisplayOptions(int i, int i2)`  L34
- `void loadImage(String str, final OnLoadListener onLoadListener)`  L38
- `void onLoadingCancelled(String str2, View view)`  L41 @Override
- `void onLoadingComplete(String str2, View view, Bitmap bitmap)`  L45 @Override
- `void onLoadingFailed(String str2, View view, FailReason failReason)`  L53 @Override
- `void onLoadingStarted(String str2, View view)`  L61 @Override
- `void loadImageView(String str, ImageView imageView)`  L70
- `void loadImageView(String str, ImageView imageView, int i)`  L74
- `void loadImageView(String str, ImageView imageView, int i, int i2, final OnLoadListener onLoadListener)`  L78
- `void onLoadingCancelled(String str2, View view)`  L81 @Override
- `void onLoadingComplete(String str2, View view, Bitmap bitmap)`  L85 @Override
- `void onLoadingFailed(String str2, View view, FailReason failReason)`  L93 @Override
- `void onLoadingStarted(String str2, View view)`  L101 @Override
- `void loadImageView(String str, ImageView imageView, int i, final OnLoadListener onLoadListener)`  L110
- `void onLoadingCancelled(String str2, View view)`  L113 @Override
- `void onLoadingComplete(String str2, View view, Bitmap bitmap)`  L117 @Override
- `void onLoadingFailed(String str2, View view, FailReason failReason)`  L125 @Override
- `void onLoadingStarted(String str2, View view)`  L133 @Override
- `void loadImageView(String str, ImageView imageView, final OnLoadListener onLoadListener)`  L142
- `void onLoadingCancelled(String str2, View view)`  L145 @Override
- `void onLoadingComplete(String str2, View view, Bitmap bitmap)`  L149 @Override
- `void onLoadingFailed(String str2, View view, FailReason failReason)`  L157 @Override
- `void onLoadingStarted(String str2, View view)`  L165 @Override
- `void loadImageViewNoCache(String str, ImageView imageView)`  L174
- `void loadLocalImage(File file, final OnLoadListener onLoadListener)`  L178
    - 体内字面量："file://"
- `void onLoadingCancelled(String str, View view)`  L181 @Override
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L185 @Override
- `void onLoadingFailed(String str, View view, FailReason failReason)`  L193 @Override
- `void onLoadingStarted(String str, View view)`  L201 @Override
- `void loadLocalImageView(File file, ImageView imageView, final OnLoadListener onLoadListener)`  L210
    - 体内字面量："file://"
- `void onLoadingCancelled(String str, View view)`  L213 @Override
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L217 @Override
- `void onLoadingFailed(String str, View view, FailReason failReason)`  L225 @Override
- `void onLoadingStarted(String str, View view)`  L233 @Override
- `void pauseLoad()`  L242
- `void resumeLoad()`  L248
- `void stopLoad()`  L254
### `com.icatch.golive.utils.imageloader.ImageLoaderUtil$OnLoadListener`
L16 · [interface] public OnLoadListener · `com/icatch/golive/utils/imageloader/ImageLoaderUtil.java`

方法（3）：
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L17
- `void onLoadingFailed(String str, View view)`  L19
- `void onLoadingStarted(String str, View view)`  L21
### `com.icatch.golive.utils.imageloader.Md5FileNameGeneratorMatchFaceName`
L10 · [class] public Md5FileNameGeneratorMatchFaceName · implements `FileNameGenerator` · `com/icatch/golive/utils/imageloader/Md5FileNameGeneratorMatchFaceName.java`

字段/常量（2）：
- `String HASH_ALGORITHM = "MD5"`  L11
- `int RADIX = 36`  L12

方法（2）：
- `byte[] getMD5(byte[] bArr)`  L14
- `String generate(String str)`  L26 @Override
### `com.icatch.golive.utils.imageloader.TutkUriUtil`
L7 · [class] public TutkUriUtil · `com/icatch/golive/utils/imageloader/TutkUriUtil.java`

字段/常量（1）：
- `String URI_PREFIX = "tutk://"`  L8

方法（11）：
- `boolean belongsTo(String str)`  L10
- `String crop(String str)`  L14
    - 体内字面量："URI [%1$s] doesn't have expected scheme [%2$s]"
- `ICatchFile getICatchFile(String str)`  L21
    - 体内字面量："&" · "="
- `ICatchFile getInfoOfUri(String str)`  L33
- `String getKey(String str)`  L37
    - 体内字面量："fileName"
- `String getTutkOriginalUri(ICatchFile iCatchFile)`  L42
    - 体内字面量："fileHandle=" · "&fileName=" · "&fileSize=" · "&original"
- `String getTutkThumbnailUri(int i, String str, long j)`  L46
    - 体内字面量："fileHandle=" · "&fileName=" · "&fileSize=" · "&thumbnail"
- `String getTutkThumbnailUri(ICatchFile iCatchFile)`  L50
    - 体内字面量："fileHandle=" · "&fileName=" · "&fileSize=" · "&thumbnail"
- `boolean isOriginalUri(String str)`  L54
    - 体内字面量："original"
- `boolean isThumbnailUri(String str)`  L58
    - 体内字面量："thumbnail"
- `boolean isTutkUri(String str)`  L62
### `com.icatch.golive.utils.LruCacheTool`
L8 · [class] public LruCacheTool · `com/icatch/golive/utils/LruCacheTool.java`

字段/常量（3）：
- `String TAG = "LruCacheTool"`  L9
- `LruCacheTool instance`  L10
- `LruCache<String, Bitmap> localThumbnailLruCache`  L11

方法（9）：
- `private LruCacheTool()`  L13
- `LruCacheTool getInstance()`  L16
- `void addBitmapToLruCache(String str, Bitmap bitmap)`  L23
    - 体内字面量："addBitmapToLruCache key=" · " size=" · " bitmap="
- `void clearCache()`  L31
    - 体内字面量："clearCache"
- `Bitmap getBitmapFromLruCache(String str)`  L36
    - 体内字面量："getBitmapFromLruCache key=" · " bitmap="
- `LruCache<String, Bitmap> getLruCache()`  L45
- `void initLruCache()`  L49
    - 体内字面量："initLruCache cacheMemory="
- `void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2)`  L55 @Override
    - 体内字面量："cacheMemory entryRemoved key="
- `int sizeOf(String str, Bitmap bitmap)`  L65 @Override
    - 体内字面量："cacheMemory value.getByteCount()=" · " key="
### `com.icatch.golive.utils.MediaLoader`
L10 · [class] public MediaLoader · implements `AlbumLoader` · `com/icatch/golive/utils/MediaLoader.java`

方法（2）：
- `void load(ImageView imageView, AlbumFile albumFile)`  L12 @Override
- `void load(ImageView imageView, String str)`  L17 @Override
### `com.icatch.golive.utils.MediaRefresh`
L17 · [class] public MediaRefresh · `com/icatch/golive/utils/MediaRefresh.java`

字段/常量（2）：
- `String ACTION_MEDIA_SCANNER_SCAN_DIR = "android.intent.action.MEDIA_SCANNER_SCAN_DIR"`  L18
- `String TAG = "MediaRefresh"`  L19

方法（6）：
- `void addMediaToDB(Context context, String str, String str2)`  L21
    - 体内字面量："addMediaToDB filePath=" · "addMediaToDB fileType=" · "title" · "date_added" · "mime_type" · "relative_path" · "is_pending" · "_data" · "album" · "addMediaToDB: insert uri is "
- `void notifySystemToScan(File file)`  L41
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `void notifySystemToScan(String str, Context context)`  L50
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `void scanDirAsync(Context context, String str)`  L56
- `void scanFileAsync(Context context, String str)`  L62
    - 体内字面量："scanFileAsync"
- `void onScanCompleted(String str2, Uri uri)`  L66 @Override
### `com.icatch.golive.utils.OnCallback`
L4 · [interface] public OnCallback · `com/icatch/golive/utils/OnCallback.java`

方法（2）：
- `void onError(int i)`  L5
- `void onSuccess(String str)`  L7
### `com.icatch.golive.utils.PanoramaTools`
L10 · [class] public PanoramaTools · `com/icatch/golive/utils/PanoramaTools.java`

字段/常量（3）：
- `String TAG = "PanoramaTools"`  L11
- `String str2 = TAG`  L21
- `boolean zIsPanorama = false`  L28

方法（3）：
- `boolean isPanorama(long j, long j2)`  L13
- `boolean isPanorama(String str)`  L17
- `boolean isPanoramaForVideo(String str)`  L27
### `com.icatch.golive.utils.PermissionTools`
L12 · [class] public PermissionTools · `com/icatch/golive/utils/PermissionTools.java`

字段/常量（4）：
- `int ALL_REQUEST_CODE = 102`  L13
- `int CAMERA_REQUEST_CODE = 103`  L14
- `String TAG = "PermissionTools"`  L15
- `int WRITE_OR_READ_EXTERNAL_STORAGE_REQUEST_CODE = 102`  L16

方法（6）：
- `boolean CheckSelfPermission(Activity activity)`  L18
    - 体内字面量："android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.ACCESS_COARSE_LOCATION"
- `void RequestPermissions(Activity activity)`  L22
    - 体内字面量："Start RequestPermissions" · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.ACCESS_COARSE_LOCATION" · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.ACCESS_COARSE_LOCATION" · "End RequestPermissions"
- `boolean checkAllSelfPermission(Activity activity)`  L30
    - 体内字面量："PERM" · "checkAllSelfPermission" · "Build.Version.SDK_INT = " · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.READ_EXTERNAL_STORAGE" · "android.permission.ACCESS_FINE_LOCATION" · "android.permission.ACCESS_FINE_LOCATION" · "android.permission.ACCESS_FINE_LOCATION" · "android.permission.READ_EXTERNAL_STORAGE" · "android.permission.ACCESS_FINE_LOCATION"
- `boolean checkCameraSelfPermission(Activity activity)`  L45
    - 体内字面量："android.permission.CAMERA"
- `void requestAllPermissions(Activity activity)`  L49
    - 体内字面量："Start request all necessary permissions" · "Build.Version.SDK_INT = " · "android.permission.READ_MEDIA_IMAGES" · "PERM" · "request READ_MEDIA_IMAGES" · "android.permission.READ_MEDIA_VIDEO" · "PERM" · "request READ_MEDIA_VIDEO" · "android.permission.READ_MEDIA_VISUAL_USER_SELECTED" · "PERM" · "request READ_MEDIA_VISUAL_USER_SELECTED" · "android.permission.READ_MEDIA_VISUAL_USER_SELECTED" · "android.permission.READ_EXTERNAL_STORAGE" · "PERM" · "request READ_EXTERNAL_STORAGE" · "android.permission.READ_EXTERNAL_STORAGE" · "android.permission.WRITE_EXTERNAL_STORAGE" · "PERM" · "request WRITE_EXTERNAL_STORAGE" · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.ACCESS_FINE_LOCATION" · "PERM" · "request ACCESS_FINE_LOCATION" · "android.permission.ACCESS_FINE_LOCATION" · "PERM" · "request ACCESS_COARSE_LOCATION" · "android.permission.ACCESS_COARSE_LOCATION" · "permission has granted!" · "End requestPermissions"
- `void requestCameraPermissions(Activity activity)`  L87
    - 体内字面量："Start request camera necessary permissions" · "android.permission.CAMERA" · "android.permission.CAMERA" · "permission has granted!" · "End requestPermissions"
### `com.icatch.golive.utils.QRCode`
L14 · [class] public QRCode · `com/icatch/golive/utils/QRCode.java`

字段/常量（6）：
- `int IMAGE_HALFWIDTH = 50`  L15
- `int WIDTH = 500`  L16
- `int[] iArr = new int[i * i]`  L27
- `int i2 = width / 2`  L54
- `int[] iArr = new int[i * i]`  L59
- `int i5 = IMAGE_HALFWIDTH`  L62

方法（4）：
- `Bitmap createQRCode(String str)`  L18
- `Bitmap createQRCode(String str, int i)`  L22
    - 体内字面量："utf-8"
- `Bitmap createQRCodeWithLogo(String str, int i, Bitmap bitmap)`  L46
    - 体内字面量："utf-8"
- `Bitmap createQRCodeWithLogo(String str, Bitmap bitmap)`  L81
### `com.icatch.golive.utils.ScaleTool`
L6 · [class] public ScaleTool · `com/icatch/golive/utils/ScaleTool.java`

字段/常量（4）：
- `int i5`  L8
- `int i6 = i3 * i2`  L10
- `int i7 = i4 * i`  L11
- `int i8 = 0`  L12

方法（1）：
- `Rect getScaledPosition(int i, int i2, int i3, int i4)`  L7
### `com.icatch.golive.utils.SharedPreferencesUtil`
L11 · [class] public SharedPreferencesUtil · `com/icatch/golive/utils/SharedPreferencesUtil.java`

字段/常量（4）：
- `String CONFIG_FILE = "appLocalInfo"`  L12
- `String SETUP_WIFI_LIST = "setup_wifi_list"`  L14
- `String TAG = "SharedPreferencesUtil"`  L15
- `boolean isDebug = false`  L16

方法（7）：
- `void clear(Context context, String str)`  L45
- `boolean contains(Context context, String str, String str2)`  L51
- `Object get(Context context, String str, String str2, Object obj)`  L55
- `Map<String, ?> getAll(Context context, String str)`  L75
- `SharedPreferences getSharedPreferences(Context context, String str)`  L79
- `void put(Context context, String str, String str2, Object obj)`  L83
- `void remove(Context context, String str, String str2)`  L101
### `com.icatch.golive.utils.SharedPreferencesUtil$SharedPreferencesCompat`
L18 · [class] private static SharedPreferencesCompat · `com/icatch/golive/utils/SharedPreferencesUtil.java`

字段/常量（1）：
- `Method method = sApplyMethod`  L26

方法（3）：
- `private SharedPreferencesCompat()`  L21
- `void apply(SharedPreferences.Editor editor)`  L24
- `Method findApplyMethod()`  L36
    - 体内字面量："apply"
### `com.icatch.golive.utils.SPUtil`
L15 · [class] public SPUtil · `com/icatch/golive/utils/SPUtil.java`

字段/常量（3）：
- `String KEY_AREA = "local-user-area"`  L16
- `String KEY_LANGUAGE = "local-language"`  L17
- `String KEY_VIDEOS = "local-private-videos"`  L18

方法（6）：
- `String getAppLanguage(Context context)`  L20
- `String getUserArea(Context context)`  L24
    - 体内字面量："appData"
- `List<FileInfo> getVideosInfoFromLocal(Context context)`  L28
    - 体内字面量："SPUtil" · "Exception : "
- `void saveAppLanguage(Context context, String str)`  L45
- `void saveUserArea(Context context, String str)`  L49
    - 体内字面量："appData"
- `void saveVideosInfoToLocal(Context context, List<FileInfo> list)`  L53
### `com.icatch.golive.utils.StorageUtil`
L11 · [class] public StorageUtil · `com/icatch/golive/utils/StorageUtil.java`

字段/常量（6）：
- `String TAG = "StorageUtil"`  L12
- `File file`  L19
- `File file`  L31
- `File file`  L43
- `File file`  L55
- `boolean z = false`  L58

方法（5）：
- `String getCurStorageLocation(Context context)`  L14
    - 体内字面量："appData" · "storageLocation" · "InternalStorage" · "InternalStorage"
- `String getDownloadPath(Context context)`  L18
- `String getRootPath(Context context)`  L30
- `File getStorageDirectory(Context context)`  L42
- `boolean sdCardExist(Context context)`  L54
### `com.icatch.golive.utils.TimeTools`
L8 · [class] public TimeTools · `com/icatch/golive/utils/TimeTools.java`

字段/常量（1）：
- `long lastClickTime`  L9

方法（6）：
- `String getCountTimeByInt(int i)`  L11
    - 体内字面量："%02d:%02d:%02d"
- `String getDateToString(long j, String str)`  L15
- `boolean isFastClick()`  L19
- `Date stringToDate(String str, String str2)`  L28
- `int stringToInt(String str, int i)`  L32
- `long stringToLong(String str, String str2)`  L42
### `com.icatch.golive.utils.ToastHelper`
L9 · [class] public ToastHelper · `com/icatch/golive/utils/ToastHelper.java`

字段/常量（2）：
- `Toast toast`  L10
- `Toast toast2 = toast`  L13

方法（3）：
- `void hide()`  L12
- `void show(Context context, String str)`  L20
    - 体内字面量："ToastHelper" · "message = "
- `void showLong(Context context, String str)`  L34
    - 体内字面量："ToastHelper" · "message = "
### `com.icatch.golive.utils.URLEncodeing`
L9 · [class] public URLEncodeing · `com/icatch/golive/utils/URLEncodeing.java`

方法（2）：
- `String toURLDecoder(String str)`  L10
- `String toURLEncoded(String str)`  L21
    - 体内字面量："\\+" · "%20"
### `com.icatch.golive.utils.VersionChecker`
L9 · [class] public VersionChecker · `com/icatch/golive/utils/VersionChecker.java`

字段/常量（3）：
- `String TAG = "VersionChecker"`  L10
- `String str2 = strArrSplit[1]`  L20
- `String str2 = strArrSplit[strArrSplit.length - 1]`  L34

方法（4）：
- `String[] extractDate(String str)`  L12
    - 体内字面量："_"
- `String getFirmwarePath(Context context, String str)`  L27
- `boolean isFirmwareNewerThanTargetDate(String str)`  L44
- `boolean isVersionValid(String str, String str2)`  L48
    - 体内字面量：" " · " "
### `com.icatch.golive.utils.VideoConverter`
L13 · [class] public VideoConverter · `com/icatch/golive/utils/VideoConverter.java`

方法（3）：
- `void convertTStoMP4(String str, String str2, VideoConverterCallback videoConverterCallback)`  L21
- `void apply(Log log)`  L25 @Override
    - 体内字面量：" " · "-i" · "-c:v" · "copy" · "-c:a" · "aac" · "VideoConverter" · "è½¬æ¢æå" · "VideoConverter" · "è½¬æ¢è¢«åæ¶" · "VideoConverter" · "è½¬æ¢å¤±è´¥ï¼session = "
- `void lambda$convertTStoMP4$0(Log log)`  L42
### `com.icatch.golive.utils.VideoConverter$VideoConverterCallback`
L15 · [interface] public VideoConverterCallback · `com/icatch/golive/utils/VideoConverter.java`

方法（2）：
- `void onFailed()`  L16
- `void onSuccess()`  L18
### `com.icatch.golive.utils.WifiAPUtil`
L19 · [class] public WifiAPUtil · `com/icatch/golive/utils/WifiAPUtil.java`

字段/常量（20）：
- `String CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE"`  L20
- `boolean DEBUG = true`  L21
- `String DEFAULT_AP_PASSWORD = "12345678"`  L22
- `String EXTRA_WIFI_AP_STATE = "wifi_state"`  L23
- `int MESSAGE_AP_STATE_ENABLED = 1`  L24
- `int MESSAGE_AP_STATE_FAILED = 2`  L25
- `String TAG = "WifiAPUtil"`  L26
- `String WIFI_AP_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_AP_STATE_CHANGED"`  L27
- `int WIFI_AP_STATE_DISABLED = 11`  L28
- `int WIFI_AP_STATE_DISABLING = 10`  L29
- `int WIFI_AP_STATE_ENABLED = 13`  L30
- `int WIFI_AP_STATE_ENABLING = 12`  L31
- `int WIFI_AP_STATE_FAILED = 14`  L32
- `Context mContext`  L33
- `Handler mHandler`  L34
- `WifiAPUtil sInstance`  L35
- `WifiManager mWifiManager`  L36
- `WifiListener wifiListener`  L37
- `int iIntValue`  L206
- `BroadcastReceiver broadcastReceiver = this.mWifiStateBroadcastReceiver`  L281

方法（17）：
- `void onReceive(Context context, Intent intent)`  L40 @Override
    - 体内字面量："WifiAPUtils onReceive: "
- `void onReceive(Context context, Intent intent)`  L55 @Override
    - 体内字面量："android.net.wifi.RSSI_CHANGED" · "android.net.wifi.STATE_CHANGE" · "networkInfo" · "ç½ç»è¿æ¥æ­å¼" · "è¿æ¥å°ç½ç» " · "wifi" · "android.net.wifi.WIFI_STATE_CHANGED" · "ç³»ç»å³é­wifi" · "ç³»ç»å¼å¯wifi"
- `private WifiAPUtil(Context context)`  L91
    - 体内字面量："WifiAPUtils construct" · "wifi"
- `WifiAPUtil getInstance(Context context)`  L97
- `String getLocalIPAddressFromWifiInfo(Context context)`  L104
    - 体内字面量："wifi"
- `String intIP2StringIP(int i)`  L109
    - 体内字面量："." · "." · "."
- `boolean isMobile(Context context)`  L113
    - 体内字面量："connectivity"
- `boolean setWifiApEnabled()`  L118
    - 体内字面量："setWifiApEnabled" · "setWifiApEnabled"
- `void closeWifiAp()`  L147
    - 体内字面量："getWifiApConfiguration" · "setWifiApEnabled"
- `void finalize()`  L165
    - 体内字面量："finalize"
- `String getValidApSsid()`  L170
    - 体内字面量："getWifiApConfiguration"
- `String getValidPassword()`  L179
    - 体内字面量："getWifiApConfiguration"
- `int getValidSecurity()`  L188
    - 体内字面量："getWifiApConfiguration" · "getSecurity security="
- `int getWifiAPState()`  L205
- `void regitsterHandler(Handler handler)`  L217
- `boolean turnOnWifiAp(String str, String str2, WifiSecurityType wifiSecurityType)`  L224
    - 体内字面量："wifi ap----no password" · "wifi ap----wpa" · "wifi ap---- wpa2" · " rt = " · "setWifiApConfiguration"
- `void unregitsterHandler()`  L279
### `com.icatch.golive.utils.WifiAPUtil$WifiSecurityType`
L83 · [enum] public WifiSecurityType · `com/icatch/golive/utils/WifiAPUtil.java`

枚举常量（4）：
- `WIFICIPHER_NOPASS()`  L84
- `WIFICIPHER_WPA()`  L85
- `WIFICIPHER_WEP()`  L86
- `WIFICIPHER_INVALID()`  L87
### `com.icatch.golive.utils.WifiCheck`
L25 · [class] public WifiCheck · `com/icatch/golive/utils/WifiCheck.java`

字段/常量（25）：
- `int CONNECT_FAILED = 2`  L26
- `int IN_BACKGROUND = 3`  L27
- `int RECONNECT_CAMERA = 9`  L28
- `int RECONNECT_CHECKING_PERIOD = 5000`  L29
- `int RECONNECT_FAILED = 5`  L30
- `int RECONNECT_SUCCESS = 4`  L31
- `int RECONNECT_TIME = 10`  L32
- `int RECONNECT_WAITING = 10000`  L33
- `int WIFICIPHER_NOPASS = 6`  L34
- `int WIFICIPHER_WAP = 8`  L35
- `int WIFICIPHER_WEP = 7`  L36
- `Activity activity`  L37
- `AlertDialog dialog`  L38
- `ExecutorService executor`  L39
- `WifiInfo mWifiInfo`  L40
- `WifiManager mWifiManager`  L41
- `AlertDialog reconnectDialog`  L42
- `Timer reconnectTimer`  L43
- `String TAG = "WifiCheck"`  L44
- `Boolean isShowed = false`  L45
- `int curReconnectTime = 0`  L46
- `int i = wifiCheck.curReconnectTime`  L111
- `AlertDialog alertDialog = this.dialog`  L118
- `AlertDialog alertDialog = this.dialog`  L139
- `AlertDialog alertDialog = this.dialog`  L241

方法（18）：
- `void handleMessage(Message message)`  L49 @Override
- `public WifiCheck(Activity activity)`  L103
    - 体内字面量："wifi"
- `int access$108(WifiCheck wifiCheck)`  L110
- `void showReconnectDialog()`  L117
- `void onClick(DialogInterface dialogInterface, int i)`  L126 @Override
    - 体内字面量："showReconnectDialog exit connect"
- `void showReconnectTimeoutDialog()`  L138
- `void onClick(DialogInterface dialogInterface, int i)`  L147 @Override
    - 体内字面量："showReconnectTimeoutDialog exit connect"
- `WifiConfiguration CreateWifiInfo(String str, String str2, int i)`  L158
    - 体内字面量："start CreateWifiInfo" · "\"" · "\"" · "[0-9A-Fa-f]*" · "\"" · "\\\"" · "\"" · "\"" · "end CreateWifiInfo config="
- `int checkState()`  L201
- `void closeWifi()`  L205
- `boolean connectWifi(String str, String str2, int i)`  L211
    - 体内字面量："connectWifi SSID=" · " Password=" · " activity=" · "wifi" · "connectWifi start addNetwork　config=" · "connectWifi start enableNetwork netID=" · "connectWifi end----bRet ="
- `boolean isWifiConnected(Context context, String str)`  L223
    - 体内字面量："connectivity" · "wifi"
- `void openWifi()`  L231
- `void showAutoReconnectDialog()`  L238
- `void onClick(DialogInterface dialogInterface, int i)`  L249 @Override
    - 体内字面量："showAutoReconnectDialog exit connect"
- `void showConectFailureWarningDlg(Context context)`  L260
- `void onClick(DialogInterface dialogInterface, int i)`  L268 @Override
    - 体内字面量："showConectFailureWarningDlg exit connect"
- `void onClick(DialogInterface dialogInterface, int i)`  L275 @Override
### `com.icatch.golive.utils.WifiCheck$ReconnectTask`
L57 · [class] private ReconnectTask · extends `TimerTask` · `com/icatch/golive/utils/WifiCheck.java`

字段/常量（1）：
- `WifiCheck wifiCheck = WifiCheck.this`  L64

方法（4）：
- `private ReconnectTask()`  L58
- `void run()`  L62 @Override
    - 体内字面量："wifi"
- `void run()`  L75 @Override
    - 体内字面量："reconnect success! start finishAllActivity()" · "reconnect curReconnectTime="
- `void run()`  L95 @Override
### `com.icatch.golive.utils.WifiNetworkSpecifierUtil`
L21 · [class] public WifiNetworkSpecifierUtil · `com/icatch/golive/utils/WifiNetworkSpecifierUtil.java`

字段/常量（18）：
- `String TAG = "WifiNetworkSpecifierUtil"`  L22
- `WifiNetworkSpecifierUtil api`  L23
- `ConnectivityManager connectivityManager`  L24
- `NetworkSpecifierCallback networkCallback`  L25
- `StringBuilder sbAppend`  L50
- `String str2`  L51
- `StringBuilder sbAppend2`  L52
- `String str3 = str`  L53
- `OnCallback onCallback2 = onCallback`  L95
- `OnCallback onCallback2 = onCallback`  L117
- `OnCallback onCallback2 = onCallback`  L146
- `OnCallback onCallback2 = onCallback`  L186
- `OnCallback onCallback2 = onCallback`  L196
- `ConnectivityManager connectivityManager = this.connectivityManager`  L243
- `NetworkSpecifierCallback networkSpecifierCallback = this.networkCallback`  L246
- `NetworkSpecifierCallback networkSpecifierCallback = this.networkCallback`  L261
- `OnCallback onCallback2 = onCallback`  L281
- `OnCallback onCallback2 = onCallback`  L303

方法（27）：
- `WifiNetworkSpecifierUtil getInstance()`  L35
- `void ping()`  L42
    - 体内字面量："www.baidu.com"
- `void ping(final String str)`  L46
- `void run()`  L49 @Override
- `void bindToNetwork(Context context, final OnCallback onCallback)`  L84
    - 体内字面量："bindToNetwork" · "connectivity"
- `void onAvailable(Network network)`  L91 @Override
    - 体内字面量："bindToNetwork onAvailable:"
- `void onLosing(Network network, int i)`  L102 @Override
    - 体内字面量："bindToNetwork onLosing:"
- `void onLost(Network network)`  L108 @Override
    - 体内字面量："bindToNetwork onLost:"
- `void onUnavailable()`  L114 @Override
    - 体内字面量："bindToNetwork onUnavailable:"
- `void connectWifi(Context context, PatternMatcher patternMatcher, String str, final OnCallback onCallback)`  L125
    - 体内字面量："connectWifi pwd:" · "connectivity"
- `void onAvailable(Network network)`  L137 @Override
    - 体内字面量："Network onAvailable: "
- `void onBlockedStatusChanged(Network network, boolean z)`  L153 @Override
    - 体内字面量："Network onBlockedStatusChanged: "
- `void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities)`  L159 @Override
    - 体内字面量："Network onCapabilitiesChanged: "
- `void onLinkPropertiesChanged(Network network, LinkProperties linkProperties)`  L165 @Override
    - 体内字面量："Network onLinkPropertiesChanged: "
- `void onLosing(Network network, int i)`  L171 @Override
    - 体内字面量："Network onLosing: "
- `void onLost(Network network)`  L177 @Override
    - 体内字面量："Network onLost: "
- `void onPasswordError()`  L183 @Override
    - 体内字面量："Network onPasswordError"
- `void onUnavailable()`  L193 @Override
    - 体内字面量："Network onUnavailable"
- `void connectWifi(Context context, String str, String str2, OnCallback onCallback)`  L206
    - 体内字面量："connectWifi ssid:"
- `void connectWifi2(Context context)`  L211
    - 体内字面量："BOI_5G" · "boi_2020" · "wifi" · "WifiManager.STATUS_NETWORK_SUGGESTIONS_SUCCESS" · "!WifiManager.STATUS_NETWORK_SUGGESTIONS_SUCCESS status = "
- `void connectWifi3(Context context)`  L226
    - 体内字面量："SBC_C63149" · "1234567890" · "BOI" · "boi_2020" · "BpSC-VPN" · "BpSC-VPN" · "wifi" · "!WifiManager.STATUS_NETWORK_SUGGESTIONS_SUCCESS status = " · "status == WifiManager.STATUS_NETWORK_SUGGESTIONS_SUCCESS"
- `void disconnectWifi()`  L242
- `void notifyPasswordError()`  L260
- `void scanWifi(Context context, final OnCallback onCallback)`  L267
    - 体内字面量："[a-zA-z0-9@]+.*" · "1234567890" · "connectivity"
- `void onAvailable(Network network)`  L277 @Override
    - 体内字面量："Network onAvailable: "
- `void run()`  L288 @Override
    - 体内字面量："www.baidu.com"
- `void onUnavailable()`  L300 @Override
    - 体内字面量："Network onUnavailable"
### `com.icatch.golive.utils.WifiNetworkSpecifierUtil$NetworkSpecifierCallback`
L27 · [class] private NetworkSpecifierCallback · extends `ConnectivityManager.NetworkCallback` · `com/icatch/golive/utils/WifiNetworkSpecifierUtil.java`

方法（2）：
- `private NetworkSpecifierCallback()`  L28
- `void onPasswordError()`  L31
### `com.icatch.golive.utils.XmlParseUtil`
L15 · [class] public XmlParseUtil · `com/icatch/golive/utils/XmlParseUtil.java`

字段/常量（13）：
- `String keyCmd2003 = "Cmd2003"`  L16
- `String keyCmd2011 = "Cmd2011"`  L17
- `String keyCmd8010 = "Cmd8010"`  L18
- `String keyCmd8011 = "Cmd8011"`  L19
- `String strNextText = null`  L30
- `String strNextText2 = null`  L31
- `String strNextText = null`  L72
- `String strNextText = null`  L115
- `String strNextText2 = null`  L116
- `String strNextText3 = null`  L117
- `String strNextText4 = null`  L118
- `String strNextText5 = null`  L119
- `String strNextText6 = null`  L120

方法（5）：
- `Map<String, Object> parseXMLToMenuItemWithPull(String str)`  L21
- `Map<String, String> parseXMLToStringWithPull(String str, List<String> list)`  L67
- `List<String> parseXMLToVideoItemWithPull(String str)`  L93
    - 体内字面量："Index"
- `List<FileInfo> parseXMLWithPull(String str)`  L110
- `Map<String, String> parseXMLWithPull(String str, List<String> list)`  L148
    - 体内字面量："onResponse" · "xml parse result: "