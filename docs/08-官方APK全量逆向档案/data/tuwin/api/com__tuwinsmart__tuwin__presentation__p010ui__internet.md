# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.presentation.p010ui.internet

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 4 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.presentation.p010ui.internet.ExternalWebActivity`
L56 · [class] public final ExternalWebActivity · extends `Activity` · `com/tuwinsmart/tuwin/presentation/p010ui/internet/ExternalWebActivity.java`
注解：

字段/常量（74）：
- `String EXTRA_EXPIRES_AT = "internet_route_expires_at"`  L60
- `String EXTRA_NETWORK_HANDLE = "internet_network_handle"`  L61
- `String EXTRA_ROUTE_REVISION = "internet_route_revision"`  L62
- `String EXTRA_TITLE = "external_title"`  L63
- `String EXTRA_TOKEN = "internet_route_token"`  L64
- `String EXTRA_URL = "external_url"`  L65
- `String HELP_SITE_COMPATIBILITY_SCRIPT = "<binary/metadata>"`  L66
- `ActivityExternalWebBinding binding`  L67
- `ExternalWebCoordinator coordinator`  L69
- `InternetProcessRuntime internetRuntime`  L70
- `InternetProcessRouteGrant routeGrant`  L71
- `AutoCloseable routeMonitor`  L72
- `WebView webView`  L73
- `Object objM3074constructorimpl`  L96
- `InternetProcessRuntime internetProcessRuntime = null`  L102
- `String str = stringExtra`  L112
- `Result.Companion companion = Result.INSTANCE`  L121
- `ExternalWebActivity externalWebActivity = this`  L122
- `Result.Companion companion2 = Result.INSTANCE`  L125
- `InternetProcessRuntime internetProcessRuntime3 = this.internetRuntime`  L157
- `ActivityExternalWebBinding activityExternalWebBinding = null`  L207
- `String str = rawTitle`  L220
- `ActivityExternalWebBinding activityExternalWebBinding2 = this.binding`  L222
- `ActivityExternalWebBinding activityExternalWebBinding3 = this.binding`  L228
- `ActivityExternalWebBinding activityExternalWebBinding4 = this.binding`  L234
- `ActivityExternalWebBinding activityExternalWebBinding = this.binding`  L256
- `WebView webView = null`  L257
- `FrameLayout frameLayout = activityExternalWebBinding.webviewContainer`  L262
- `WebView webView2 = this.webView`  L263
- `WebView webView3 = this.webView`  L269
- `WebView webView4 = this.webView`  L284
- `WebView webView5 = this.webView`  L290
- `Uri url`  L299
- `String string`  L300
- `String str = url`  L309
- `Uri url`  L315
- `String string`  L316
- `Object objM3074constructorimpl`  L317
- `ExternalWebResourcePolicy externalWebResourcePolicy = resourcePolicy`  L321
- `Result.Companion companion = Result.INSTANCE`  L323
- `C27662 c27662 = this`  L324
- `Result.Companion companion2 = Result.INSTANCE`  L327
- `Object objM3074constructorimpl`  L338
- `ExternalWebResourcePolicy externalWebResourcePolicy = resourcePolicy`  L340
- `Result.Companion companion = Result.INSTANCE`  L342
- `C27662 c27662 = this`  L343
- `Result.Companion companion2 = Result.INSTANCE`  L346
- `Object objM3074constructorimpl`  L358
- `ExternalUrlPolicy externalUrlPolicy = policy`  L367
- `Result.Companion companion = Result.INSTANCE`  L369
- `C27662 c27662 = this`  L370
- `Result.Companion companion2 = Result.INSTANCE`  L373
- `WebView webView6 = ExternalWebActivity.this.webView`  L397
- `WebView webView6 = ExternalWebActivity.this.webView`  L407
- `WebView webView7 = null`  L408
- `WebView webView8 = ExternalWebActivity.this.webView`  L414
- `WebView webView9 = ExternalWebActivity.this.webView`  L420
- `WebView webView10 = ExternalWebActivity.this.webView`  L426
- `Object objM3074constructorimpl`  L439
- `Result.Companion companion = Result.INSTANCE`  L455
- `ExternalWebActivity externalWebActivity = this`  L456
- `Result.Companion companion2 = Result.INSTANCE`  L459
- `String lowerCase`  L473
- `Object objM3074constructorimpl`  L490
- `Result.Companion companion = Result.INSTANCE`  L492
- `ExternalWebActivity externalWebActivity = this`  L493
- `Result.Companion companion2 = Result.INSTANCE`  L497
- `ExternalWebCoordinator externalWebCoordinator = this$0.coordinator`  L526
- `AutoCloseable autoCloseable = this.routeMonitor`  L539
- `ExternalWebCoordinator externalWebCoordinator = null`  L543
- `ExternalWebCoordinator externalWebCoordinator2 = this.coordinator`  L545
- `WebView webView = this.webView`  L563
- `WebView webView2 = null`  L565
- `WebView webView3 = this.webView`  L571

方法（28）：
- `void onCreate(Bundle savedInstanceState)`  L95 @Override
- `ExternalWebSurface create()`  L141 @Override
    - 体内字面量："coordinator"
- `ExternalWebSurface onCreate$lambda$2(ExternalWebActivity this$0, ExternalUrlPolicy policy, ExternalWebResourcePolicy resourcePolicy, HttpUrl authorizedUrl)`  L168
    - 体内字面量："this$0" · "$policy" · "$resourcePolicy" · "$authorizedUrl"
- `void configureWindow()`  L196
- `void configureToolbar(String rawTitle)`  L206
- `void onClick(View view)`  L242 @Override
- `void configureToolbar$lambda$5(ExternalWebActivity this$0, View view)`  L249
    - 体内字面量："this$0"
- `ExternalWebSurface createSurface(final ExternalUrlPolicy policy, final ExternalWebResourcePolicy resourcePolicy, String initialUrl)`  L254
- `boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)`  L298 @Override
- `boolean shouldOverrideUrlLoading(WebView view, String url)`  L308 @Override
- `WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request)`  L314 @Override
- `WebResourceResponse shouldInterceptRequest(WebView view, String url)`  L337 @Override
- `void onPageStarted(WebView view, String url, Bitmap favicon)`  L357 @Override
- `void onPageFinished(WebView view, String url)`  L386 @Override
- `void loadUrl(String url)`  L395 @Override
    - 体内字面量："url"
- `void destroy()`  L406 @Override
- `boolean handleNavigation(WebView view, String target, ExternalUrlPolicy policy)`  L438
- `boolean isHttpUrl(String rawUrl)`  L472
- `void showUrlBlockedToast()`  L485
- `void launchExternalApp(String target)`  L489
- `WebResourceResponse blockedResponse()`  L509
    - 体内字面量："text/plain"
- `void closeForRouteChange()`  L514
- `void run()`  L517 @Override
- `void closeForRouteChange$lambda$11(ExternalWebActivity this$0)`  L524
    - 体内字面量："this$0"
- `void onDestroy()`  L538 @Override
- `void onBackPressed()`  L558 @Override
- `void navigateBack()`  L562
- `InternetProcessRouteGrant readGrant(Intent source)`  L584
    - 体内字面量："Lcom/tuwinsmart/tuwin/presentation/ui/internet/ExternalWebActivity$Companion;" · "()V" · "EXTRA_EXPIRES_AT" · "EXTRA_NETWORK_HANDLE" · "EXTRA_ROUTE_REVISION" · "EXTRA_TITLE" · "EXTRA_TOKEN" · "EXTRA_URL" · "HELP_SITE_COMPATIBILITY_SCRIPT" · "launch" · "Lkotlin/Result;" · "Landroid/content/Context;" · "rawUrl" · "title" · "launch-0E7RQCE" · "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;" · "showUrlBlockedToast" · "app_release_64"
### `com.tuwinsmart.tuwin.presentation.p010ui.internet.ExternalWebActivity$C27682`
L179 · [class] C27682 · extends `FunctionReferenceImpl implements Function0<Unit>` · implements `Function0<Unit>` · `com/tuwinsmart/tuwin/presentation/p010ui/internet/ExternalWebActivity.java`
注解：

方法（2）：
- `Unit invoke()`  L185 @Override
- `void invoke2()`  L191
### `com.tuwinsmart.tuwin.presentation.p010ui.internet.ExternalWebActivity$Companion`
L602 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/p010ui/internet/ExternalWebActivity.java`
注解：

字段/常量（16）：
- `Object objM3074constructorimpl`  L620
- `Object objM3074constructorimpl2`  L621
- `Object objM3074constructorimpl3`  L622
- `Result.Companion companion = Result.INSTANCE`  L627
- `Companion companion2 = this`  L628
- `Result.Companion companion3 = Result.INSTANCE`  L631
- `Result.Companion companion4 = Result.INSTANCE`  L637
- `Result.Companion companion5 = Result.INSTANCE`  L642
- `Companion companion6 = this`  L643
- `Result.Companion companion7 = Result.INSTANCE`  L646
- `Result.Companion companion8 = Result.INSTANCE`  L651
- `Result.Companion companion9 = Result.INSTANCE`  L661
- `Result.Companion companion10 = Result.INSTANCE`  L666
- `Companion companion11 = this`  L667
- `Result.Companion companion12 = Result.INSTANCE`  L681
- `Result.Companion companion13 = Result.INSTANCE`  L688

方法（5）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L603
- `private Companion()`  L607
- `Object m3002launch0E7RQCE$default(Companion companion, Context context, String str, String str2, int i, Object obj)`  L611
- `Object m3003launch0E7RQCE(Context context, String rawUrl, String title)`  L619
- `void showUrlBlockedToast(Context context)`  L695
### `com.tuwinsmart.tuwin.presentation.p010ui.internet.ExternalWebActivity$WhenMappings`
L77 · [class] public WhenMappings · `com/tuwinsmart/tuwin/presentation/p010ui/internet/ExternalWebActivity.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L78