# TUWIN — 类与成员明细：ren.yale.android.cachewebviewlib

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `ren.yale.android.cachewebviewlib.HttpCacheInterceptor`
L10 · [class] HttpCacheInterceptor · implements `Interceptor` · `ren/yale/android/cachewebviewlib/HttpCacheInterceptor.java`

方法（1）：
- `Response intercept(Interceptor.Chain chain)`  L15 @Override
    - 体内字面量："pragma" · "Cache-Control" · "Cache-Control" · "max-age=3153600000"
### `ren.yale.android.cachewebviewlib.utils.OKHttpFile`
L15 · [class] public OKHttpFile · `ren/yale/android/cachewebviewlib/utils/OKHttpFile.java`

字段/常量（3）：
- `int ENTRY_BODY = 1`  L16
- `int ENTRY_METADATA = 0`  L17
- `boolean z`  L20

方法（1）：
- `InputStream getCacheFile(File file, String str)`  L19
### `ren.yale.android.cachewebviewlib.WebViewCacheInterceptor`
L34 · [class] public WebViewCacheInterceptor · implements `WebViewRequestInterceptor` · `ren/yale/android/cachewebviewlib/WebViewCacheInterceptor.java`

字段/常量（28）：
- `String KEY_CACHE = "WebResourceInterceptor-Key-Cache"`  L35
- `String mAssetsDir`  L36
- `CacheExtensionConfig mCacheExtensionConfig`  L37
- `File mCacheFile`  L38
- `long mCacheSize`  L39
- `CacheType mCacheType`  L40
- `long mConnectTimeout`  L41
- `Context mContext`  L42
- `boolean mDebug`  L43
- `Dns mDns`  L44
- `File mDynamicCacheFile`  L45
- `boolean mIsSuffixMod`  L46
- `long mReadTimeout`  L47
- `ResourceInterceptor mResourceInterceptor`  L48
- `SSLSocketFactory mSSLSocketFactory`  L49
- `boolean mTrustAllHostname`  L50
- `X509TrustManager mX509TrustManager`  L51
- `OkHttpClient mHttpClient = null`  L52
- `String mOrigin = "<binary/metadata>"`  L53
- `String mReferer = "<binary/metadata>"`  L54
- `String mUserAgent = "<binary/metadata>"`  L55
- `X509TrustManager x509TrustManager`  L99
- `SSLSocketFactory sSLSocketFactory = this.mSSLSocketFactory`  L109
- `Dns dns = this.mDns`  L113
- `ResourceInterceptor resourceInterceptor = this.mResourceInterceptor`  L148
- `InputStream resByUrl`  L236
- `File resByUrl2`  L237
- `FileInputStream fileInputStream = null`  L238

方法（22）：
- `public WebViewCacheInterceptor(Builder builder)`  L57
- `boolean isEnableDynamicCache()`  L86
- `boolean isEnableAssets()`  L90
- `void initAssetsLoader()`  L94
- `void initHttpClient()`  L98
- `boolean verify(String str, SSLSession sSLSession)`  L104 @Override
- `WebResourceResponse interceptRequest(WebResourceRequest webResourceRequest)`  L121 @Override
- `Map<String, String> buildHeaders()`  L125
    - 体内字面量："Origin" · "Referer" · "User-Agent"
- `WebResourceResponse interceptRequest(String str)`  L140 @Override
- `boolean checkUrl(String str)`  L144
    - 体内字面量："http"
- `void loadUrl(WebView webView, String str)`  L157 @Override
- `void loadUrl(String str, String str2)`  L168 @Override
- `void loadUrl(String str, Map<String, String> map, String str2)`  L177 @Override
- `void loadUrl(WebView webView, String str, Map<String, String> map)`  L186 @Override
- `void clearCache()`  L197 @Override
- `void enableForce(boolean z)`  L203 @Override
- `InputStream getCacheFile(String str)`  L212 @Override
- `void initAssetsData()`  L217 @Override
- `File getCachePath()`  L222 @Override
- `void addHeader(Request.Builder builder, Map<String, String> map)`  L226
- `WebResourceResponse interceptRequest(String str, Map<String, String> map)`  L235
- `boolean isValidUrl(String str)`  L405
### `ren.yale.android.cachewebviewlib.WebViewCacheInterceptor$Builder`
L292 · [class] public static Builder · `ren/yale/android/cachewebviewlib/WebViewCacheInterceptor.java`

字段/常量（15）：
- `File mCacheFile`  L293
- `Context mContext`  L294
- `File mDynamicCacheFile`  L295
- `ResourceInterceptor mResourceInterceptor`  L296
- `long mCacheSize = 104857600`  L297
- `long mConnectTimeout = 20`  L298
- `long mReadTimeout = 20`  L299
- `boolean mDebug = true`  L300
- `CacheType mCacheType = CacheType.FORCE`  L301
- `boolean mTrustAllHostname = false`  L302
- `SSLSocketFactory mSSLSocketFactory = null`  L303
- `X509TrustManager mX509TrustManager = null`  L304
- `String mAssetsDir = null`  L305
- `boolean mIsSuffixMod = false`  L306
- `Dns mDns = null`  L307

方法（16）：
- `public Builder(Context context)`  L310
    - 体内字面量："CacheWebViewCache"
- `void setResourceInterceptor(ResourceInterceptor resourceInterceptor)`  L315
- `Builder setTrustAllHostname()`  L319
- `Builder setSSLSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager)`  L324
- `Builder setCachePath(File file)`  L332
- `Builder setDynamicCachePath(File file)`  L339
- `Builder setCacheSize(long j)`  L346
- `Builder setReadTimeoutSecond(long j)`  L353
- `Builder setConnectTimeoutSecond(long j)`  L360
- `Builder setCacheExtensionConfig(CacheExtensionConfig cacheExtensionConfig)`  L367
- `Builder setDebug(boolean z)`  L374
- `Builder setCacheType(CacheType cacheType)`  L379
- `Builder isAssetsSuffixMod(boolean z)`  L384
- `Builder setAssetsDir(String str)`  L389
- `void setDns(Dns dns)`  L396
- `WebViewRequestInterceptor build()`  L400
### `ren.yale.android.cachewebviewlib.WebViewCacheInterceptorInst`
L11 · [class] public WebViewCacheInterceptorInst · implements `WebViewRequestInterceptor` · `ren/yale/android/cachewebviewlib/WebViewCacheInterceptorInst.java`

字段/常量（12）：
- `WebViewCacheInterceptorInst webViewCacheInterceptorInst`  L12
- `WebViewRequestInterceptor mInterceptor`  L13
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L34
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L43
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L52
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L61
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L70
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L79
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L88
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L97
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L106
- `WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor`  L120

方法（13）：
- `void init(WebViewCacheInterceptor.Builder builder)`  L15
- `WebViewCacheInterceptorInst getInstance()`  L21
- `WebResourceResponse interceptRequest(WebResourceRequest webResourceRequest)`  L33 @Override
- `WebResourceResponse interceptRequest(String str)`  L42 @Override
- `void loadUrl(WebView webView, String str)`  L51 @Override
- `void loadUrl(String str, String str2)`  L60 @Override
- `void loadUrl(String str, Map<String, String> map, String str2)`  L69 @Override
- `void loadUrl(WebView webView, String str, Map<String, String> map)`  L78 @Override
- `void clearCache()`  L87 @Override
- `void enableForce(boolean z)`  L96 @Override
- `InputStream getCacheFile(String str)`  L105 @Override
- `void initAssetsData()`  L114 @Override
- `File getCachePath()`  L119 @Override