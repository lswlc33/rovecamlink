# XTU GO — 类与成员明细：com.gku.rxt

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 6 个文件 / 9 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.rxt.FullScreenLoadingDialog`
L9 · [class] public FullScreenLoadingDialog · extends `Dialog` · `com/gku/rxt/FullScreenLoadingDialog.java`

方法（2）：
- `public FullScreenLoadingDialog(Context context)`  L10
- `void onCreate(Bundle savedInstanceState)`  L15 @Override
### `com.gku.rxt.FwUpload2`
L17 · [class] public FwUpload2 · implements `Runnable` · `com/gku/rxt/FwUpload2.java`

字段/常量（15）：
- `String HOST = "192.168.0.1"`  L18
- `int PORT = 8080`  L19
- `int TIME_OUT = 5000`  L20
- `String assetsFile`  L21
- `Context context`  L22
- `FwUpload.Event event`  L23
- `FwUpload.ProgressBack progressBack`  L24
- `FileInputStream fileInputStream`  L59
- `?? r1 = "è§£æåå¤ä¿¡æ¯æå>>>"`  L60
- `byte[] bArr = new byte[256]`  L78
- `byte[] bArr2 = new byte[1024]`  L122
- `int i2 = 0`  L123
- `FwUpload.ProgressBack progressBack = this.progressBack`  L137
- `FwUpload.ProgressBack progressBack2 = this.progressBack`  L142
- `FwUpload.Event event = this.event`  L224

方法（7）：
- `void setProgressBack(FwUpload.ProgressBack pro)`  L36
- `void log(String msg)`  L40
    - 体内字面量："yunqi_debug" · "log: "
- `void run()`  L58 @Override
- `void finishCall(Exception error)`  L223
- `void closeStream(Closeable closeable)`  L230
- `public FwUpload2(Context context, String assetsFile, FwUpload.Event event)`  L240
- `void upload()`  L246
### `com.gku.rxt.FwUpload2$Event`
L26 · [interface] public Event · `com/gku/rxt/FwUpload2.java`

方法（1）：
- `void onFwUploadFinish(Exception var1)`  L27
### `com.gku.rxt.FwUpload2$ProgressBack`
L30 · [interface] public ProgressBack · `com/gku/rxt/FwUpload2.java`

方法（2）：
- `void finish()`  L31
- `void progress(float var1)`  L33
### `com.gku.rxt.MediaRepository`
L28 · [class] public final MediaRepository · `com/gku/rxt/MediaRepository.java`
注解：

字段/常量（19）：
- `Context context`  L29
- `Context context = this.context`  L189
- `Context context = this.context`  L198
- `Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI`  L199
- `Context context = this.context`  L207
- `Uri EXTERNAL_CONTENT_URI = MediaStore.Video.Media.EXTERNAL_CONTENT_URI`  L208
- `String[] strArr`  L214
- `String[] strArr2`  L215
- `String str`  L216
- `ArrayList arrayList`  L217
- `boolean z`  L218
- `int i = type`  L219
- `String[] strArr3 = strArr`  L227
- `Uri uriWithAppendedId = null`  L228
- `boolean z2 = i == 2`  L244
- `int i2 = 0`  L245
- `boolean z3 = z2`  L265
- `int i3 = i2`  L269
- `Uri uri2 = uriWithAppendedId`  L273

方法（5）：
- `public MediaRepository(Context context)`  L182
    - 体内字面量："context"
- `List<MediaItem> getAllMedia(String path)`  L187
    - 体内字面量："path"
- `List<MediaItem> getImages(String path)`  L195
    - 体内字面量："path" · " getImages path="
- `List<MediaItem> getVideos(String path)`  L204
    - 体内字面量："path" · " getVideos path="
- `List<MediaItem> query(Context context, Uri uri, String dir, int type)`  L213
### `com.gku.rxt.MediaRepository$MediaItem`
L33 · [class] public static final MediaItem · `com/gku/rxt/MediaRepository.java`
注解：

字段/常量（12）：
- `long date`  L34
- `int duration`  L35
- `boolean isVideo`  L36
- `long length`  L37
- `String name`  L38
- `String path`  L39
- `Uri uri`  L40
- `Uri uri2 = uri`  L64
- `int i3 = i`  L65
- `long j3 = j2`  L66
- `long j4 = j`  L67
- `Uri uri = this.uri`  L125

方法（22）：
- `MediaItem copy$default(MediaItem mediaItem, String str, String str2, long j, long j2, int i, boolean z, Uri uri, int i2, Object obj)`  L42
- `String getPath()`  L72
- `String getName()`  L77
- `long getLength()`  L82
- `long getDate()`  L87
- `int getDuration()`  L92
- `boolean getIsVideo()`  L97
- `Uri getUri()`  L102
- `MediaItem copy(String path, String name, long length, long date, int duration, boolean isVideo, Uri uri)`  L106
    - 体内字面量："path" · "name"
- `boolean equals(Object other)`  L112
- `int hashCode()`  L123
- `String toString()`  L129
    - 体内字面量："MediaItem(path=" · ", name=" · ", length=" · ", date=" · ", duration=" · ", isVideo=" · ", uri=" · ")"
- `public MediaItem(String path, String name, long j, long j2, int i, boolean z, Uri uri)`  L133
    - 体内字面量："path" · "name"
- ` MediaItem(String str, String str2, long j, long j2, int i, boolean z, Uri uri, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L145
- `String getPath()`  L149
- `String getName()`  L153
- `long getLength()`  L157
- `long getDate()`  L161
- `int getDuration()`  L165
- `boolean isVideo()`  L169
- `Uri getUri()`  L173
- `void setUri(Uri uri)`  L177
### `com.gku.rxt.MediaRepositoryKt`
L8 · [class] public final MediaRepositoryKt · `com/gku/rxt/MediaRepositoryKt.java`
注解：

字段/常量（6）：
- `int QUERY_TYPE_ALL = 1`  L9
- `int QUERY_TYPE_IMAGE = 3`  L10
- `int QUERY_TYPE_VIDEO = 2`  L11
- `String SELECTION = "_data like ? AND (media_type=1 OR media_type=3)"`  L12
- `String SELECTION_ALL_VIDEO = "_data like ? AND (media_type=0 OR media_type=3)"`  L13
- `String SORT_ORDER = "date_added desc"`  L14
### `com.gku.rxt.MediaStorage`
L16 · [class] public final MediaStorage · `com/gku/rxt/MediaStorage.java`
注解：

字段/常量（4）：
- `Context appContext`  L17
- `String directory = "<binary/metadata>"`  L19
- `Context context = appContext`  L31
- `Context context = appContext`  L44

方法（4）：
- `private MediaStorage()`  L21
- `void init(Application application)`  L24
    - 体内字面量："application"
- `void scan(String[] paths)`  L29
    - 体内字面量："paths"
- `void scan(String path)`  L39
    - 体内字面量："path"
### `com.gku.rxt.ThumbHelp`
L18 · [class] public ThumbHelp · `com/gku/rxt/ThumbHelp.java`

字段/常量（19）：
- `String TAG = "ThumbHelp"`  L19
- `boolean isFirst = true`  L20
- `boolean isWorking = false`  L21
- `ThumbHelp stance`  L23
- `ExecutorService worker`  L24
- `ExecutorService worker2`  L25
- `IChannelListener mListener`  L26
- `LinkedBlockingQueue<Pair<String, String>> mSendQeue`  L27
- `int code = -1`  L29
- `int workCount = 0`  L30
- `ThumbHelp thumbHelp = stance`  L36
- `Pair<String, String> pairTake`  L65
- `String str`  L66
- `int i = 5`  L88
- `int i2 = 0`  L107
- `Pair pair`  L144
- `String str3`  L145
- `int i3 = 0`  L183
- `LinkedBlockingQueue<Pair<String, String>> linkedBlockingQueue = this.mSendQeue`  L233

方法（17）：
- `void getThumb(String data, String createTime)`  L32
- `ThumbHelp getInstance(IChannelListener iChannelListener)`  L35
- `ThumbHelp getInstance()`  L48
- `void setListener(IChannelListener iChannelListener)`  L52
- `private ThumbHelp(IChannelListener iChannelListener)`  L56
- `void startWork()`  L64
- `void success()`  L93 @Override
    - 体内字面量："1 åç¸æºåéå°é¢æä»¶è¯·æ±:Success  code="
- `void failure(int code)`  L99 @Override
    - 体内字面量："1 åç¸æºåéå°é¢æä»¶è¯·æ±:failure" · "1 æ¬å°å­å¨å°é¢æä»¶è·¯å¾:"
- `void failure(int code)`  L123 @Override
- `void success()`  L127 @Override
    - 体内字面量："1025 worker2  execute "
- `void run()`  L143 @Override
- `void success()`  L172 @Override
    - 体内字面量："åç¸æºåéå°é¢æä»¶è¯·æ±:Success  resultCode="
- `void failure(int code)`  L177 @Override
    - 体内字面量："åç¸æºåéå°é¢æä»¶è¯·æ±:failure" · "æ¬å°å­å¨å°é¢æä»¶è·¯å¾:"
- `void stop()`  L203
    - 体内字面量："1025 stop "
- `void restart()`  L209
- `void run()`  L224 @Override
- `void clear()`  L230