# XTU GO — 类与成员明细：com.gku.base.okhttputils

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 16 个文件 / 19 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.base.okhttputils.AbsCallback`
L11 · [class] public abstract AbsCallback · `com/gku/base/okhttputils/AbsCallback.java`

字段/常量（2）：
- `Context context`  L12
- `String strString`  L33

方法（15）：
- `T convertResponse(Response response)`  L14
- `void onFail(Call call, int i, String str)`  L16
- `void onProgress(long j, long j2, int i)`  L18
- `void onSuccess(Call call, T t, Response response)`  L21
- `public AbsCallback(Context context)`  L23
- `void dealFail(Call call, Exception exc)`  L27
    - 体内字面量："dealFail 00"
- `void dealResponse(Call call, Response response)`  L32
- `Callback getCallback()`  L53
- `void onFailure(Call call, IOException iOException)`  L56 @Override
- `void onResponse(Call call, Response response)`  L61 @Override
- `void callOnSuccess(final Call call, final T t, final Response response)`  L67
- `void run()`  L71 @Override
- `void callOnFail(final Call call, final int i, final String str)`  L77
- `void run()`  L80 @Override
- `void runOnUiThread(Runnable runnable)`  L86
### `com.gku.base.okhttputils.BaseRequestGenerator`
L20 · [class] public abstract BaseRequestGenerator · extends `BaseRequestGenerator>` · `com/gku/base/okhttputils/BaseRequestGenerator.java`

字段/常量（8）：
- `String baseUrl`  L21
- `String method`  L22
- `Network network`  L23
- `OkHttpClient.Builder okHttpClientBuilder`  L24
- `int connectTimeout = 60000`  L27
- `int readTimeout = 60000`  L28
- `int writeTimeout = 60000`  L29
- `Object tag = "tag"`  L30

方法（24）：
- `Request generateRequest(AbsCallback<?> absCallback)`  L32
- `T network(Network network)`  L34
- `T url(String str)`  L42
- `T method(String str)`  L47
- `T header(String str, String str2)`  L52
- `T headers(Map<String, String> map)`  L57
- `T param(String str, Object obj)`  L63
- `T params(Map<String, Object> map)`  L68
- `T connectTimeout(int i)`  L74
- `T readTimeout(int i)`  L82
- `T writeTimeout(int i)`  L90
- `OkHttpClient getOkHttpClient()`  L98
    - 体内字面量："getOkHttpClient " · "getOkHttpClient socketFactory"
- `void sync(Object obj, AbsCallback<?> absCallback)`  L113
- `String syncForResult()`  L125
- `void enqueue(Object obj, AbsCallback<?> absCallback)`  L161
    - 体内字面量："Url is illegal"
- `void enqueue_no_add(AbsCallback<?> absCallback)`  L173
    - 体内字面量："Url is illegal"
- `void enqueueLifecycle(final LifecycleOwner lifecycleOwner, AbsCallback absCallback)`  L183
- `void run()`  L187 @Override
- `void onCreate(LifecycleOwner lifecycleOwner2)`  L190 @Override
    - 体内字面量："owner"
- `void onPause(LifecycleOwner lifecycleOwner2)`  L195 @Override
    - 体内字面量："owner"
- `void onResume(LifecycleOwner lifecycleOwner2)`  L200 @Override
    - 体内字面量："owner"
- `void onStart(LifecycleOwner lifecycleOwner2)`  L205 @Override
    - 体内字面量："owner"
- `void onStop(LifecycleOwner lifecycleOwner2)`  L210 @Override
    - 体内字面量："owner"
- `void onDestroy(LifecycleOwner lifecycleOwner2)`  L215 @Override
### `com.gku.base.okhttputils.DeleteJsonRequestGenerator`
L11 · [class] public DeleteJsonRequestGenerator · extends `BaseRequestGenerator<DeleteJsonRequestGenerator>` · `com/gku/base/okhttputils/DeleteJsonRequestGenerator.java`

字段/常量（1）：
- `String json = "<binary/metadata>"`  L12

方法（3）：
- `Request generateRequest(AbsCallback<?> absCallback)`  L15 @Override
    - 体内字面量："{}" · "application/json; charset=utf-8"
- `DeleteJsonRequestGenerator json(JSONObject jSONObject)`  L30
- `DeleteJsonRequestGenerator json(String str)`  L35
### `com.gku.base.okhttputils.FileOctetUploadGenerator`
L9 · [class] public FileOctetUploadGenerator · extends `BaseRequestGenerator<FileOctetUploadGenerator>` · `com/gku/base/okhttputils/FileOctetUploadGenerator.java`

字段/常量（1）：
- `File file`  L10

方法（4）：
- `FileOctetUploadGenerator file(File file)`  L12
- `Request generateRequest(final AbsCallback<?> absCallback)`  L18 @Override
    - 体内字面量："application/octet-stream"
- `void onProgress(long j, long j2, int i)`  L29 @Override
- `void onFail(int i, String str3)`  L34 @Override
### `com.gku.base.okhttputils.FileUploadBody`
L17 · [class] public FileUploadBody · extends `RequestBody` · `com/gku/base/okhttputils/FileUploadBody.java`

字段/常量（12）：
- `Callback callback`  L18
- `long contentUploaded`  L19
- `File file`  L20
- `int lastPercent = -1`  L21
- `MediaType mediaType`  L22
- `MultipartBody multipartBody`  L23
- `MultipartBody multipartBody = this.multipartBody`  L45
- `MediaType mediaType = this.mediaType`  L49
- `MultipartBody multipartBody = this.multipartBody`  L58
- `File file = this.file`  L62
- `MultipartBody multipartBody = this.multipartBody`  L82
- `File file = this.file`  L86

方法（7）：
- `public FileUploadBody(MultipartBody multipartBody, Callback callback)`  L31
- `public FileUploadBody(File file, MediaType mediaType, Callback callback)`  L36
- `MediaType getContentType()`  L44 @Override
- `long contentLength()`  L57 @Override
- `void writeTo(BufferedSink bufferedSink)`  L70 @Override
- `void run()`  L75 @Override
- `void m2288lambda$writeTo$0$comgkubaseokhttputilsFileUploadBody()`  L97
    - 体内字面量："contentLength is 0"
### `com.gku.base.okhttputils.FileUploadBody$AnonymousClass1`
L102 · [class] AnonymousClass1 · extends `ForwardingSink` · `com/gku/base/okhttputils/FileUploadBody.java`

字段/常量（2）：
- `long val$contentTotal`  L103
- `long j2 = this.val$contentTotal`  L118

方法（3）：
- `void write(Buffer buffer, long j)`  L112 @Override
- `void run()`  L121 @Override
- `void m2289lambda$write$0$comgkubaseokhttputilsFileUploadBody$1(long j, int i)`  L129
### `com.gku.base.okhttputils.FileUploadBody$Callback`
L25 · [interface] public Callback · `com/gku/base/okhttputils/FileUploadBody.java`

方法（2）：
- `void onFail(int i, String str)`  L26
- `void onProgress(long j, long j2, int i)`  L28
### `com.gku.base.okhttputils.FileUploadGenerator`
L12 · [class] public FileUploadGenerator · extends `BaseRequestGenerator<FileUploadGenerator>` · `com/gku/base/okhttputils/FileUploadGenerator.java`

方法（5）：
- `FileUploadGenerator file(String str, File file)`  L16
- `FileUploadGenerator file(String str, List<File> list)`  L21
- `Request generateRequest(final AbsCallback<?> absCallback)`  L27 @Override
    - 体内字面量："multipart/form-data; charset=utf-8" · "multipart/form-data; charset=utf-8"
- `void onProgress(long j, long j2, int i)`  L47 @Override
- `void onFail(int i, String str5)`  L52 @Override
### `com.gku.base.okhttputils.GetRequestGenerator`
L7 · [class] public GetRequestGenerator · extends `BaseRequestGenerator<GetRequestGenerator>` · `com/gku/base/okhttputils/GetRequestGenerator.java`

方法（1）：
- `Request generateRequest(AbsCallback<?> absCallback)`  L9 @Override
### `com.gku.base.okhttputils.HttpUtils`
L17 · [class] public HttpUtils · `com/gku/base/okhttputils/HttpUtils.java`

字段/常量（14）：
- `int CODE_RESPONSE_ERROR_NO_NET = -10001`  L18
- `int CODE_RESPONSE_ERROR_OTHERS = -10002`  L19
- `int CODE_RESPONSE_ERROR_URL_ILLEGAL = -10003`  L20
- `String METHOD_DELETE = "DELETE"`  L21
- `String METHOD_GET = "GET"`  L22
- `String METHOD_HEAD = "HEAD"`  L23
- `String METHOD_OPTIONS = "OPTIONS"`  L24
- `String METHOD_POST = "POST"`  L25
- `String METHOD_PUT = "PUT"`  L26
- `String METHOD_TRACE = "TRACE"`  L27
- `int TIME_OUT_DEFAULT = 60000`  L28
- `Handler handler_deliver`  L29
- `List<OkHttpClientContainer> listOkHttpClientContainer`  L30
- `OkHttpClient okHttpClientDefault`  L31

方法（19）：
- `private HttpUtils()`  L33
- `HttpUtils getInstance()`  L50
- `OkHttpClient getOkHttpClientDefault()`  L54
- `Handler getHandler_deliver()`  L58
- `String fixUrl(String str)`  L62
    - 体内字面量："https://"
- `GetRequestGenerator get(String str)`  L70
    - 体内字面量："GetRequestGenerator" · "GetRequestGenerator fixUrl" · "GET"
- `PostRequestGenerator post(String str)`  L76
    - 体内字面量："POST"
- `FileUploadGenerator uploadFile(String str)`  L80
    - 体内字面量："POST"
- `FileOctetUploadGenerator uploadFileOctet(String str)`  L84
    - 体内字面量："POST"
- `PostJsonRequestGenerator postJson(String str)`  L88
    - 体内字面量："POST"
- `PutJsonRequestGenerator putJson(String str)`  L92
    - 体内字面量："PUT"
- `DeleteJsonRequestGenerator deleteJson(String str)`  L96
    - 体内字面量："DELETE"
- `void runOnUiThread(Runnable runnable)`  L100
- `void cancel(Object obj)`  L104
- `void cancelAll()`  L126
- `void cancelAll(OkHttpClient okHttpClient)`  L134
- `void addOkHttpClientContainer(Object obj, OkHttpClient okHttpClient)`  L138
- `String getKey(Object obj)`  L145
- `long getFileSize(String str, long j)`  L149
### `com.gku.base.okhttputils.HttpUtils$HttpUtilsFactory`
L43 · [class] private static HttpUtilsFactory · `com/gku/base/okhttputils/HttpUtils.java`

方法（1）：
- `private HttpUtilsFactory()`  L46
### `com.gku.base.okhttputils.MultiDownloader`
L30 · [class] public MultiDownloader · `com/gku/base/okhttputils/MultiDownloader.java`

字段/常量（48）：
- `int BUFFER_SIZE = 8192`  L31
- `int RETRY_LIMIT = 3`  L32
- `int THREAD_COUNT = 4`  L33
- `OkHttpClient client`  L34
- `long downloadedBytes`  L35
- `long fileLength`  L36
- `File progressFile`  L37
- `File targetFile`  L38
- `String url`  L39
- `long j = this.fileLength / 4`  L67
- `int i = 0`  L69
- `long j5 = j4 > j3 ? j3 : j4`  L74
- `byte[] bArr = new byte[8192]`  L132
- `long j = 0`  L133
- `int i2`  L209
- `int i3`  L210
- `int i4`  L211
- `Throwable th`  L212
- `Throwable th2`  L213
- `int i5`  L214
- `int i6 = 0`  L215
- `int i7 = 0`  L216
- `?? r6 = 3`  L218
- `int i8 = 3`  L219
- `int i9 = 1`  L225
- `PrintStream printStream = System.out`  L227
- `Object[] objArr = new Object[3]`  L231
- `byte[] bArr = new byte[8192]`  L258
- `long j3 = j`  L259
- `int i11 = i6`  L268
- `int i12 = i7`  L269
- `long j4 = i10`  L270
- `Response response = responseExecute`  L272
- `Map<Integer, long[]> map = this.progressMap`  L274
- `InputStream inputStream = inputStreamByteStream`  L276
- `long[] jArr = new long[2]`  L277
- `Response response2 = responseExecute`  L292
- `PrintStream printStream2 = System.out`  L293
- `Object[] objArr2 = new Object[i5]`  L294
- `Throwable th6 = th`  L316
- `PrintStream printStream3 = System.out`  L380
- `Object[] objArr3 = new Object[i4]`  L385
- `PrintStream printStream4 = System.out`  L391
- `Object[] objArr4 = new Object[1]`  L392
- `PrintStream printStream5 = System.out`  L403
- `Object[] objArr5 = new Object[i4]`  L408
- `PrintStream printStream6 = System.out`  L414
- `Object[] objArr6 = new Object[1]`  L415

方法（13）：
- `public MultiDownloader(Network network, String str, String str2)`  L43
    - 体内字面量：".tmp"
- `void start()`  L50
    - 体内字面量："â ï¸ æå¡å¨ä¸æ¯æ Rangeï¼å°ä½¿ç¨åçº¿ç¨ä¸è½½"
- `Object runThread()`  L55 @Override
    - 体内字面量："rw"
- `void run()`  L77 @Override
- `void run()`  L85 @Override
    - 体内字面量："\nâ ä¸è½½å®æï¼"
- `void m2292lambda$start$0$comgkubaseokhttputilsMultiDownloader(int i, long j, long j2, CountDownLatch countDownLatch)`  L105
- `void m2293lambda$start$1$comgkubaseokhttputilsMultiDownloader(CountDownLatch countDownLatch)`  L114
- `void singleThreadDownload()`  L125
- `boolean fetchFileInfo()`  L154
    - 体内字面量："Content-Length" · "Accept-Ranges" · "æä»¶å¤§å°: %d bytes, Rangeæ¯æ: %s%n" · "bytes"
- `void downloadPart(int i, long j, long j2)`  L208
- `void saveProgress()`  L427
- `void loadProgress()`  L446
    - 体内字面量："æ¢å¤è¿åº¦: å·²ä¸è½½ " · " bytes" · "æ æ³è¯»åè¿åº¦æä»¶ï¼éæ°å¼å§ä¸è½½ã"
- `void printProgress()`  L477
    - 体内字面量："\rè¿åº¦: %.2f%% (%d/%d)"
### `com.gku.base.okhttputils.OkHttpClientContainer`
L6 · [class] public OkHttpClientContainer · `com/gku/base/okhttputils/OkHttpClientContainer.java`

字段/常量（2）：
- `OkHttpClient okHttpClient`  L7
- `String tag`  L8

方法（2）：
- `String getTag()`  L15
- `OkHttpClient getOkHttpClient()`  L19
### `com.gku.base.okhttputils.PostJsonRequestGenerator`
L11 · [class] public PostJsonRequestGenerator · extends `BaseRequestGenerator<PostJsonRequestGenerator>` · `com/gku/base/okhttputils/PostJsonRequestGenerator.java`

字段/常量（1）：
- `String json = "<binary/metadata>"`  L12

方法（3）：
- `Request generateRequest(AbsCallback<?> absCallback)`  L15 @Override
    - 体内字面量："{}" · "application/json; charset=utf-8"
- `PostJsonRequestGenerator json(JSONObject jSONObject)`  L30
- `PostJsonRequestGenerator json(String str)`  L35
### `com.gku.base.okhttputils.PostRequestGenerator`
L7 · [class] public PostRequestGenerator · extends `BaseRequestGenerator<PostRequestGenerator>` · `com/gku/base/okhttputils/PostRequestGenerator.java`

方法（1）：
- `Request generateRequest(AbsCallback<?> absCallback)`  L9 @Override
### `com.gku.base.okhttputils.PutJsonRequestGenerator`
L11 · [class] public PutJsonRequestGenerator · extends `BaseRequestGenerator<PutJsonRequestGenerator>` · `com/gku/base/okhttputils/PutJsonRequestGenerator.java`

字段/常量（1）：
- `String json = "<binary/metadata>"`  L12

方法（3）：
- `Request generateRequest(AbsCallback<?> absCallback)`  L15 @Override
    - 体内字面量："{}" · "application/json; charset=utf-8"
- `PutJsonRequestGenerator json(JSONObject jSONObject)`  L30
- `PutJsonRequestGenerator json(String str)`  L35
### `com.gku.base.okhttputils.StringCallback`
L7 · [class] public abstract StringCallback · extends `AbsCallback<String>` · `com/gku/base/okhttputils/StringCallback.java`

方法（2）：
- `public StringCallback(Context context)`  L8
- `String convertResponse(Response response)`  L13 @Override
### `com.gku.base.okhttputils.utils.LogUtils`
L6 · [class] public LogUtils · `com/gku/base/okhttputils/utils/LogUtils.java`

字段/常量（1）：
- `boolean printLog = true`  L7

方法（5）：
- `void debug(boolean z)`  L9
- `void log(String str, Object obj)`  L13
    - 体内字面量："LOG_E" · "----->>>>"
- `void log(Object obj, Object obj2)`  L22
    - 体内字面量："LOG_E" · "----->>>>"
- `void log(String str)`  L31
    - 体内字面量："LOG_E" · "----->>>>"
- `void log(Object obj)`  L40
    - 体内字面量："LOG_E" · "----->>>>"
### `com.gku.base.okhttputils.utils.ParamsUtils`
L10 · [class] public ParamsUtils · `com/gku/base/okhttputils/utils/ParamsUtils.java`

方法（2）：
- `String createUrlFromParams(String str, Map<String, Object> map)`  L11
    - 体内字面量："UTF-8"
- `String createStringFromParams(Map<String, Object> map)`  L40
    - 体内字面量："UTF-8"