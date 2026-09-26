# XTU GO — 类与成员明细：com.gku.base.webview

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 3 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.base.webview.WebViewActivity`
L23 · [class] public WebViewActivity · extends `AppCompatActivity` · `com/gku/base/webview/WebViewActivity.java`

字段/常量（4）：
- `String INTENT_WEBVIEW_URL = "INTENT_WEBVIEW_URL"`  L24
- `String KYE_TITLE = "KYE_TITLE"`  L25
- `ProgressBar progressBar`  L26
- `WebView webView`  L27

方法（13）：
- `void onCreate(Bundle bundle)`  L30 @Override
- `void onClick(View view)`  L50 @Override
- `void onPageStarted(WebView webView, String str, Bitmap bitmap)`  L65 @Override
- `void onPageFinished(WebView webView, String str)`  L71 @Override
- `boolean shouldOverrideUrlLoading(WebView webView, String str)`  L76 @Override
- `void onReceivedTitle(WebView webView, String str)`  L82 @Override
- `void onProgressChanged(WebView webView, int i)`  L86 @Override
- `void loadPrepare()`  L93
- `void loadUrl(String str)`  L101
    - 体内字面量："text/html" · "utf-8"
- `void onResume()`  L110 @Override
- `void onPause()`  L116 @Override
- `void onDestroy()`  L122 @Override
    - 体内字面量："text/html" · "utf-8"
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L139 @Override
### `com.gku.base.webview.WebViewUtils`
L24 · [class] public WebViewUtils · `com/gku/base/webview/WebViewUtils.java`

字段/常量（1）：
- `String TAG = "IntentUtils"`  L26

方法（16）：
- `private WebViewUtils()`  L32
- `boolean shouldOverrideUrlLoadingByApp(Context context, WebView webView, String str)`  L35
- `boolean shouldOverrideUrlLoadingByAppInternal(Context context, WebView webView, String str)`  L39
    - 体内字面量："android.intent.category.BROWSABLE"
- `boolean tryHandleByMarket(Context context, Intent intent)`  L59
    - 体内字面量："android.intent.action.VIEW" · "market://details?id="
- `boolean isAcceptedScheme(String str)`  L70
- `void openBrowser(Context context, String str)`  L78
    - 体内字面量："https://" · "android.intent.action.VIEW"
- `void loadUrl(ComponentActivity componentActivity, final WebView webView, String str, final OnWebViewClient onWebViewClient)`  L88
- `void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event)`  L95 @Override
    - 体内字面量："text/html" · "utf-8" · "UTF-8"
- `void onPageFinished(WebView webView2, String str2)`  L127 @Override
- `boolean shouldOverrideUrlLoading(WebView webView2, String str2)`  L133 @Override
    - 体内字面量："text/html" · "utf-8"
- `void loadUrlAndAssets(ComponentActivity componentActivity, final WebView webView, String str, final String str2)`  L144
- `void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event)`  L151 @Override
    - 体内字面量："text/html" · "utf-8" · "UTF-8"
- `void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError)`  L183 @Override
- `void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError)`  L190 @Override
- `boolean shouldOverrideUrlLoading(WebView webView2, String str3)`  L196 @Override
- `void loadOfflineHtml(WebView webView2)`  L200
    - 体内字面量："file:///android_asset/" · "text/html" · "utf-8"
### `com.gku.base.webview.WebViewUtils$OnWebViewClient`
L28 · [interface] public OnWebViewClient · `com/gku/base/webview/WebViewUtils.java`

方法（1）：
- `void onPageFinished()`  L29