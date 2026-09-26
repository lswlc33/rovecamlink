# XTU GO — 类与成员明细：com.gku.module_camera.hisi

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 10 个文件 / 23 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.module_camera.hisi.api.StringCallbackHisi`
L16 · [class] public abstract StringCallbackHisi · extends `StringCallback` · `com/gku/module_camera/hisi/api/StringCallbackHisi.java`

字段/常量（1）：
- `Type type`  L17

方法（5）：
- `void onFail(int i, String str)`  L19
- `void onSuccess(T t, String str)`  L21
- `public StringCallbackHisi(Context context)`  L23
- `void onSuccess(Call call, String str, Response response)`  L30 @Override
    - 体内字面量："onSuccess"
- `void onFail(Call call, int i, String str)`  L48 @Override
    - 体内字面量："onSuccessonFail" · ":"
### `com.gku.module_camera.hisi.bean.GetfilelistinfoiosResponseBean`
L7 · [class] public GetfilelistinfoiosResponseBean · implements `Parcelable` · `com/gku/module_camera/hisi/bean/GetfilelistinfoiosResponseBean.java`

字段/常量（5）：
- `String create`  L21
- `String path`  L22
- `String rotation`  L23
- `String size`  L24
- `String time`  L25

方法（16）：
- `GetfilelistinfoiosResponseBean createFromParcel(Parcel parcel)`  L11 @Override
- `GetfilelistinfoiosResponseBean[] newArray(int i)`  L17 @Override
- `int describeContents()`  L28 @Override
- `String getPath()`  L32
- `void setPath(String str)`  L36
- `String getCreate()`  L40
- `void setCreate(String str)`  L44
- `String getTime()`  L48
- `void setTime(String str)`  L52
- `String getSize()`  L56
- `void setSize(String str)`  L60
- `String getRotation()`  L64
- `void setRotation(String str)`  L68
- `public GetfilelistinfoiosResponseBean()`  L72
- `void writeToParcel(Parcel parcel, int i)`  L76 @Override
- `protected GetfilelistinfoiosResponseBean(Parcel parcel)`  L84
### `com.gku.module_camera.hisi.ConstantsHisi`
L4 · [class] public ConstantsHisi · `com/gku/module_camera/hisi/ConstantsHisi.java`

字段/常量（11）：
- `int CODE_ERROR_HISI_CONNECT = -1004`  L5
- `int CODE_ERROR_HISI_COPYFILETODCIM_9_NO_PERMISSION = -1011`  L6
- `int CODE_ERROR_HISI_DOWNLOAD_CONTENTLENGTH_NOT_EQUALS = -1006`  L7
- `int CODE_ERROR_HISI_FILE_OUTPUT_STREAM_CREATE = -1005`  L8
- `int CODE_ERROR_HISI_GET_FILE_COUNT_ERROR = -1013`  L9
- `int CODE_ERROR_HISI_JSON_PARSE = -1003`  L10
- `int CODE_ERROR_HISI_LENGTH_GET = -1009`  L11
- `int CODE_ERROR_HISI_LENGTH_INVALID = -1008`  L12
- `int CODE_ERROR_HISI_NOT_SUCCESS = -1012`  L13
- `int CODE_ERROR_HISI_READ = -1002`  L14
- `int CODE_ERROR_HISI_WRITE = -1001`  L15
### `com.gku.module_camera.hisi.dialog.DialogHisiSDMediaDelete`
L23 · [class] public DialogHisiSDMediaDelete · extends `BaseDialog` · `com/gku/module_camera/hisi/dialog/DialogHisiSDMediaDelete.java`

字段/常量（5）：
- `Callback callback`  L24
- `CallbackDeletes callbackDeletes`  L25
- `ComponentActivity componentActivity`  L26
- `TextView tv_delete_count`  L27
- `int i2 = i`  L115

方法（11）：
- `public DialogHisiSDMediaDelete(ComponentActivity componentActivity, final Callback callback)`  L35
- `void onClick(View view)`  L43 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L49 @Override
- `void deleteAndShow(int i, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L58
- `void deleteAndShow(SparseArray<GetfilelistinfoiosResponseBean> sparseArray)`  L64
    - 体内字面量："1/"
- `void onSuccessAll()`  L80 @Override
- `void onSuccessOne(int i2, int i3)`  L86 @Override
    - 体内字面量："/"
- `void onFailOne(int i2)`  L92 @Override
    - 体内字面量：":"
- `void deleteFile(final SparseArray<GetfilelistinfoiosResponseBean> sparseArray, final int i, final CallbackDeletes callbackDeletes)`  L101
    - 体内字面量："deleteFile" · "deleteFile" · "interrupted" · "/cgi-bin/hi3510/deletefile.cgi" · "-name"
- `void onSuccess(Call call, String str, Response response)`  L108 @Override
    - 体内字面量："deleteFile"
- `void onFail(Call call, int i2, String str)`  L124 @Override
### `com.gku.module_camera.hisi.dialog.DialogHisiSDMediaDelete$Callback`
L29 · [interface] public Callback · `com/gku/module_camera/hisi/dialog/DialogHisiSDMediaDelete.java`

方法（2）：
- `void onDeleteOne(int i, int i2)`  L30
- `void onDismiss()`  L32
### `com.gku.module_camera.hisi.dialog.DialogHisiSDMediaDelete$CallbackDeletes`
L131 · [class] private abstract CallbackDeletes · `com/gku/module_camera/hisi/dialog/DialogHisiSDMediaDelete.java`

字段/常量（1）：
- `boolean interrupted`  L132

方法（6）：
- `void onFailOne(int i)`  L134
- `void onSuccessAll()`  L136
- `void onSuccessOne(int i, int i2)`  L138
- `private CallbackDeletes()`  L140
- `void interrupt()`  L143
- `boolean isInterrupted()`  L147
### `com.gku.module_camera.hisi.dialog.DialogHisiSDMediaDownload`
L21 · [class] public DialogHisiSDMediaDownload · extends `BaseDialog` · `com/gku/module_camera/hisi/dialog/DialogHisiSDMediaDownload.java`

字段/常量（25）：
- `Callback callback`  L22
- `ComponentActivity componentActivity`  L23
- `View layout_error`  L24
- `ProgressBar progressBar`  L25
- `TextView tv_download_count`  L26
- `TextView tv_download_hint`  L27
- `TextView tv_download_percent`  L28
- `TextView tv_download_time_left`  L29
- `TextView tv_error`  L30
- `TextView tv_file_name`  L31
- `TextView tv_retry`  L32
- `long j = 0`  L105
- `long[] jArr = {0}`  L109
- `long[] jArr2 = {0}`  L110
- `long[] jArr3 = {0}`  L111
- `long[] jArr4 = {0}`  L112
- `long[] jArr5 = jArr`  L132
- `long j2 = jCurrentTimeMillis - jArr3[0]`  L135
- `long j3 = j - jArr[0]`  L137
- `long[] jArr5 = jArr4`  L156
- `DialogHisiSDMediaDownload dialogHisiSDMediaDownload = DialogHisiSDMediaDownload.this`  L170
- `String[] strArr = {"B/s", "KB/s", "MB/s", "GB/s"}`  L189
- `long j2 = 1`  L190
- `int i = 0`  L191
- `long j3 = j2 << 10`  L193

方法（16）：
- `public DialogHisiSDMediaDownload(ComponentActivity componentActivity, Callback callback)`  L40
- `void onClick(View view)`  L56 @Override
- `void show()`  L63 @Override
- `void downloadAndShow(int i, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L68
- `void downloadAndShow(SparseArray<GetfilelistinfoiosResponseBean> sparseArray)`  L74
- `void download(final SparseArray<GetfilelistinfoiosResponseBean> sparseArray)`  L80
- `void onClick(View view)`  L84 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L97 @Override
    - 体内字面量："1/" · "0%"
- `void onSuccessAll()`  L115 @Override
- `void onStartOne(int i3, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, int i4)`  L121 @Override
    - 体内字面量："/" · "0%"
- `void onSuccessOne(int i3, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, int i4)`  L129 @Override
    - 体内字面量："count_downloaded"
- `void onProgressOne(int i3, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j2, long j3, int i4)`  L146 @Override
    - 体内字面量："%"
- `void onRefreshSpeed(int i3, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j2)`  L153 @Override
- `void onFailOne(int i3, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, int i4)`  L166 @Override
    - 体内字面量："\n" · ":"
- `String formatTime(long j)`  L178
    - 体内字面量："--:--:--" · "%02d:%02d:%02d"
- `String formatSpeed(long j)`  L188
### `com.gku.module_camera.hisi.dialog.DialogHisiSDMediaDownload$Callback`
L34 · [interface] public Callback · `com/gku/module_camera/hisi/dialog/DialogHisiSDMediaDownload.java`

方法（2）：
- `void onDismiss()`  L35
- `void onSuccessOne(int i, int i2)`  L37
### `com.gku.module_camera.hisi.dialog.DialogHisiSDMediaMenu`
L13 · [class] public DialogHisiSDMediaMenu · extends `BaseDialog` · `com/gku/module_camera/hisi/dialog/DialogHisiSDMediaMenu.java`

字段/常量（4）：
- `TextView tv_length`  L14
- `TextView tv_name`  L15
- `TextView tv_path`  L16
- `TextView tv_time`  L17

方法（4）：
- `public DialogHisiSDMediaMenu(ComponentActivity componentActivity)`  L25
- `void show(final GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, final Callback callback)`  L34
- `void onClick(View view)`  L41 @Override
- `void onClick(View view)`  L48 @Override
### `com.gku.module_camera.hisi.dialog.DialogHisiSDMediaMenu$Callback`
L19 · [interface] public Callback · `com/gku/module_camera/hisi/dialog/DialogHisiSDMediaMenu.java`

方法（2）：
- `void onDeleteClick(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L20
- `void onDownloadClick(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L22
### `com.gku.module_camera.hisi.HisiDownloader`
L36 · [class] public HisiDownloader · `com/gku/module_camera/hisi/HisiDownloader.java`

字段/常量（18）：
- `int FILE_TYPE_PIC = 1`  L37
- `int FILE_TYPE_UNKNOWN = -1`  L38
- `int FILE_TYPE_VIDEO = 0`  L39
- `int PORT`  L40
- `ExecutorService executorServiceSingle`  L41
- `Gson gson`  L42
- `Object lockDownload`  L43
- `Object lockQueue`  L44
- `Map<LifecycleOwner, Map<String, Runnable>> mapQueue`  L45
- `String tag_downloading`  L46
- `String path`  L193
- `String path`  L315
- `Runnable runnable2`  L410
- `String name`  L452
- `int columnIndex`  L473
- `Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI`  L474
- `int columnIndex`  L493
- `Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI`  L494

方法（34）：
- `private HisiDownloader()`  L74
- `HisiDownloader getInstance()`  L91
- `int getFileType(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L95
    - 体内字面量："jpg" · "jpeg" · "png" · "webp" · "dng" · "raw" · "mp4"
- `String getDCIMPath(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L103
    - 体内字面量："xtugo" · "video" · "photo"
- `String getDCIMPath_9(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L115
    - 体内字面量："xtugo" · "video" · "photo"
- `int copyFileToDCIMSync(Context context, File file, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L127
- `void cancelDownload(T t, List<GetfilelistinfoiosResponseBean> list)`  L134
    - 体内字面量："download cancelDownload" · "sockethisiDownload.stop:" · "download cancelDownload"
- `void downloadFile2DCIM(Context context, T t, final List<GetfilelistinfoiosResponseBean> list, final CallbackDownload_s callbackDownload_s)`  L157
- `void onSuccess(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, String str)`  L162 @Override
- `void onStart(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L170 @Override
- `void onProgress(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j, long j2, int i2)`  L175 @Override
- `void onRefreshSpeed(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j)`  L180 @Override
- `void onFail(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, int i2)`  L185 @Override
- `String getUrlDownload(Context context, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L192
- `String getFilePathSaved(Context context, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L203
- `String getTagFromGetfilelistinfoiosResponseBean(T t, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L207
- `void downloadFile2DCIM(Context context, T t, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, CallbackDownload callbackDownload)`  L211
- `void onPermissionHave()`  L215 @Override
- `void downloadFile(Context context, T t, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, CallbackDownload callbackDownload)`  L310
- `void downloadFile(Context context, T t, final GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, final String str, final CallbackDownload callbackDownload)`  L314
- `void run()`  L321 @Override
- `void run()`  L329 @Override
- `void onSuccess(String str2)`  L343 @Override
- `void onProgress(long j, long j2, int i)`  L348 @Override
- `void onRefreshSpeed(long j)`  L353 @Override
- `void onFail(int i)`  L358 @Override
- `void synchronized_tag_downloading_null()`  L364
- `void queueEvent(final T t, final String str, Runnable runnable)`  L371
    - 体内字面量："download_queueEvent ==111"
- `void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event)`  L375 @Override
    - 体内字面量："download ON_DESTROY" · "sockethisiDownload.stop():" · "download_queueEvent lockQueue" · "download_queueEvent lockQueue111" · "download_queueEvent lockQueue222" · "download_queueEvent execute"
- `void run()`  L409 @Override
- `String getDisplayName(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L451
- `boolean isFileDownloaded2DCIMSync(Context context, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L464
- `long getVideoSizeInDCIMSync(Context context, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L472
- `long getPicSizeInDCIMSync(Context context, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L492
### `com.gku.module_camera.hisi.HisiDownloader$AnonymousClass3`
L226 · [class] AnonymousClass3 · implements `Runnable` · `com/gku/module_camera/hisi/HisiDownloader.java`

字段/常量（5）：
- `CallbackDownload val$callbackDownload`  L227
- `Context val$context`  L228
- `GetfilelistinfoiosResponseBean val$getfilelistinfoiosResponseBean`  L229
- `LifecycleOwner val$lifecycleOwner`  L230
- `String val$tag`  L231

方法（10）：
- `void run()`  L242 @Override
    - 体内字面量："downloadFile ç¼å­"
- `void run()`  L250 @Override
- `void onStart(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L258 @Override
- `void onSuccess(final GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, final String str)`  L263 @Override
- `void onInterrupted()`  L266 @Override
- `Integer runThread()`  L271 @Override
- `void run_UIThread(Integer num)`  L278 @Override
- `void onProgress(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j, long j2, int i)`  L290 @Override
- `void onRefreshSpeed(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j)`  L295 @Override
- `void onFail(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, int i)`  L300 @Override
### `com.gku.module_camera.hisi.HisiDownloader$CallbackDownload`
L48 · [interface] private CallbackDownload · `com/gku/module_camera/hisi/HisiDownloader.java`

方法（5）：
- `void onFail(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, int i)`  L49
- `void onProgress(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j, long j2, int i)`  L51
- `void onRefreshSpeed(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j)`  L53
- `void onStart(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L55
- `void onSuccess(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, String str)`  L57
### `com.gku.module_camera.hisi.HisiDownloader$CallbackDownload_s`
L60 · [interface] public CallbackDownload_s · `com/gku/module_camera/hisi/HisiDownloader.java`

方法（6）：
- `void onFailOne(int i, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, int i2)`  L61
- `void onProgressOne(int i, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j, long j2, int i2)`  L63
- `void onRefreshSpeed(int i, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, long j)`  L65
- `void onStartOne(int i, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, int i2)`  L67
- `void onSuccessAll()`  L69
- `void onSuccessOne(int i, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, int i2)`  L71
### `com.gku.module_camera.hisi.HisiDownloader$Holder`
L84 · [class] private static Holder · `com/gku/module_camera/hisi/HisiDownloader.java`

方法（1）：
- `private Holder()`  L87
### `com.gku.module_camera.hisi.HisiSocketServer`
L18 · [class] public HisiSocketServer · `com/gku/module_camera/hisi/HisiSocketServer.java`

字段/常量（9）：
- `int SERVER_PORT = 5678`  L19
- `ExecutorService executorServiceSingle`  L20
- `boolean isRunning`  L21
- `ServerSocket serverSocket`  L22
- `Socket socket_current`  L23
- `ByteArrayOutputStream byteArrayOutputStream`  L83
- `Exception e`  L84
- `String str`  L85
- `byte[] bArr = new byte[65536]`  L88

方法（10）：
- `private HisiSocketServer()`  L29
- `HisiSocketServer getInstance()`  L41
- `void start(T t, final Callback callback)`  L45
- `void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event)`  L50 @Override
- `void run()`  L61 @Override
    - 体内字面量："Hisi-Accept-Thread"
- `void m2856lambda$start$0$comgkumodule_camerahisiHisiSocketServer(final Callback callback)`  L68
    - 体内字面量："isRunning"
- `void run()`  L82 @Override
- `void run()`  L119 @Override
    - 体内字面量："start Exception"
- `void stop()`  L132
    - 体内字面量："HisiSocketServer stopped"
- `void closeSocket(Socket socket)`  L143
### `com.gku.module_camera.hisi.HisiSocketServer$Callback`
L25 · [interface] public Callback · `com/gku/module_camera/hisi/HisiSocketServer.java`

方法（1）：
- `void onReceiveMsg(String str)`  L26
### `com.gku.module_camera.hisi.HisiSocketServer$Holder`
L34 · [class] private static Holder · `com/gku/module_camera/hisi/HisiSocketServer.java`

方法（1）：
- `private Holder()`  L37
### `com.gku.module_camera.hisi.SingleInstanceHisi`
L11 · [class] public SingleInstanceHisi · `com/gku/module_camera/hisi/SingleInstanceHisi.java`

字段/常量（3）：
- `List<GetfilelistinfoiosResponseBean> listMedia`  L12
- `List<GetfilelistinfoiosResponseBean> listPic`  L13
- `List<GetfilelistinfoiosResponseBean> listVideo`  L14

方法（9）：
- `private SingleInstanceHisi()`  L16
- `SingleInstanceHisi getInstance()`  L29
- `List<GetfilelistinfoiosResponseBean> getListMedia()`  L33
- `void addMedia(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L37
- `void sortMedia()`  L41
- `int compare(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean, GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean2)`  L44 @Override
    - 体内字面量："\\D+" · "\\D+"
- `void clearAll()`  L62
- `List<GetfilelistinfoiosResponseBean> getListPic()`  L68
- `List<GetfilelistinfoiosResponseBean> getListVideo()`  L72
### `com.gku.module_camera.hisi.SingleInstanceHisi$Holder`
L22 · [class] private static Holder · `com/gku/module_camera/hisi/SingleInstanceHisi.java`

方法（1）：
- `private Holder()`  L25
### `com.gku.module_camera.hisi.SocketHisiFile`
L20 · [class] public SocketHisiFile · `com/gku/module_camera/hisi/SocketHisiFile.java`

字段/常量（24）：
- `byte[] buf`  L21
- `ExecutorService executorServiceSingleConnect`  L22
- `Gson gson`  L23
- `InputStream inputStream`  L24
- `boolean isRunning`  L25
- `int last_percent`  L26
- `OutputStream outputStream`  L27
- `OutputStream outputStreamFile`  L28
- `Socket socket`  L29
- `long j`  L78
- `int i3`  L79
- `long j2`  L80
- `SocketHisiFile socketHisiFile = SocketHisiFile.this`  L88
- `SocketHisiFile socketHisiFile2 = SocketHisiFile.this`  L90
- `int i4 = 72`  L109
- `byte[] bArr = new byte[64]`  L116
- `byte[] bArr2 = new byte[72]`  L121
- `int i5 = 0`  L122
- `long j4 = 0`  L134
- `int i8 = 0`  L138
- `int i10 = i8 + i9`  L145
- `long j5 = jCurrentTimeMillis2 - jCurrentTimeMillis`  L147
- `long j7 = j3`  L164
- `Socket socket`  L284

方法（16）：
- `private SocketHisiFile()`  L41
- `SocketHisiFile getInstance()`  L56
- `void start(final Network network, final String str, final int i, final int i2, final String str2, final String str3, final Callback callback)`  L60
    - 体内字面量："start"
- `void run()`  L77 @Override
- `void run()`  L103 @Override
- `void run()`  L151 @Override
- `void run()`  L169 @Override
    - 体内字面量："read write "
- `void run()`  L191 @Override
    - 体内字面量："socket_file" · "flush: " · "socket_file downloaded == contentLength)"
- `void run()`  L211 @Override
- `void run()`  L218 @Override
    - 体内字面量："socket_file end000"
- `void run()`  L230 @Override
    - 体内字面量："socket_file Exception222"
- `void run()`  L239 @Override
    - 体内字面量："socket_file" · "è¿æ¥å¤±è´¥: "
- `void run()`  L249 @Override
- `void stop()`  L258
    - 体内字面量："socket call stop"
- `void closeConnection()`  L264
- `boolean isConnecting()`  L283
### `com.gku.module_camera.hisi.SocketHisiFile$Callback`
L31 · [interface] public Callback · `com/gku/module_camera/hisi/SocketHisiFile.java`

方法（4）：
- `void onFail(int i)`  L32
- `void onProgress(long j, long j2, int i)`  L34
- `void onRefreshSpeed(long j)`  L36
- `void onSuccess(String str)`  L38
### `com.gku.module_camera.hisi.SocketHisiFile$Holder`
L49 · [class] private static Holder · `com/gku/module_camera/hisi/SocketHisiFile.java`

方法（1）：
- `private Holder()`  L52