# idGoLive — 类与成员明细：com.icatchtek.baseutil.download

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 3 个文件 / 4 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.download.ApiHelper`
L8 · [class] public ApiHelper · `com/icatchtek/baseutil/download/ApiHelper.java`

字段/常量（4）：
- `String TAG = "ApiHelper"`  L9
- `ApiHelper mInstance`  L10
- `OkHttpClient mHttpClient`  L11
- `Retrofit mRetrofit`  L12

方法（5）：
- `private ApiHelper()`  L14
- `public ApiHelper(int i, int i2, int i3)`  L18
- `ApiHelper getInstance()`  L22
- `ApiHelper buildRetrofit(String str)`  L29
- `T createService(Class<T> cls)`  L34
### `com.icatchtek.baseutil.download.DownloadListener`
L4 · [interface] public DownloadListener · `com/icatchtek/baseutil/download/DownloadListener.java`

方法（4）：
- `void onFailure()`  L5
- `void onFinish(String str)`  L7
- `void onProgress(int i)`  L9
- `void onStart()`  L11
### `com.icatchtek.baseutil.download.DownLoadUtils`
L25 · [class] public DownLoadUtils · `com/icatchtek/baseutil/download/DownLoadUtils.java`

字段/常量（16）：
- `String TAG = "DownloadUtil"`  L26
- `String baseUrl = AppInfo.ACCOUNT_SERVER_BASE_URL`  L27
- `ApiInterface mApi`  L28
- `Call<ResponseBody> mCall`  L29
- `File mFile`  L30
- `Thread mThread`  L31
- `FileOutputStream fileOutputStream`  L47
- `IOException e`  L48
- `FileNotFoundException e2`  L49
- `OutputStream outputStream = null`  L55
- `byte[] bArr = new byte[1024]`  L61
- `long j2 = 0`  L62
- `byte[] bArr = new byte[1024]`  L166
- `int i = 0`  L167
- `ApiInterface apiInterface = this.mApi`  L198
- `ApiInterface apiInterface = this.mApi`  L236

方法（8）：
- `public DownLoadUtils()`  L39
- `void writeFile2Disk(Response<ResponseBody> response, File file, DownloadListener downloadListener)`  L46
- `ByteArrayOutputStream downloadFile(String str)`  L150
- `void downloadFile(String str, String str2, final DownloadListener downloadListener)`  L184
    - 体内字面量："downloadVideo: å­å¨è·¯å¾ä¸ºç©ºäº"
- `void onFailure(Call<ResponseBody> call, Throwable th)`  L206
- `void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response)`  L210
- `void run()`  L213 @Override
- `boolean downloadFile(String str, String str2)`  L223
    - 体内字面量："downloadVideo: å­å¨è·¯å¾ä¸ºç©ºäº"
### `com.icatchtek.baseutil.download.DownLoadUtils$ApiInterface`
L33 · [interface] ApiInterface · `com/icatchtek/baseutil/download/DownLoadUtils.java`

方法（1）：
- `Call<ResponseBody> downloadFile(@Url String str)`  L36 @Streaming @GET