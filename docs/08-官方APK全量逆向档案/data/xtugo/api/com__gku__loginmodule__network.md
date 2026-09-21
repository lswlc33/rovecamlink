# XTU GO — 类与成员明细：com.gku.loginmodule.network

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 12 个文件 / 15 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.network.BaseObserver`
L7 · [class] public abstract BaseObserver · implements `Observer<T>` · `com/gku/loginmodule/network/BaseObserver.java`

方法（6）：
- `void onComplete()`  L9 @Override
- `void onFailure(Throwable e)`  L12
- `void onSubscribe(Disposable disposable)`  L15 @Override
- `void onSuccess(T t)`  L18
- `void onNext(T t)`  L21 @Override
- `void onError(Throwable e)`  L26 @Override
### `com.gku.loginmodule.network.BaseResponse`
L7 · [class] public BaseResponse · `com/gku/loginmodule/network/BaseResponse.java`

字段/常量（2）：
- `Integer responseCode`  L11 @SerializedName("res_code") @Expose
- `String responseError`  L15 @SerializedName("res_error") @Expose
### `com.gku.loginmodule.network.errorhandler.ExceptionHandle`
L13 · [class] public ExceptionHandle · `com/gku/loginmodule/network/errorhandler/ExceptionHandle.java`

字段/常量（8）：
- `int BAD_GATEWAY = 502`  L14
- `int FORBIDDEN = 403`  L15
- `int GATEWAY_TIMEOUT = 504`  L16
- `int INTERNAL_SERVER_ERROR = 500`  L17
- `int NOT_FOUND = 404`  L18
- `int REQUEST_TIMEOUT = 408`  L19
- `int SERVICE_UNAVAILABLE = 503`  L20
- `int UNAUTHORIZED = 401`  L21

方法（1）：
- `ResponseThrowable handleException(Throwable throwable)`  L28
    - 体内字面量："æªææ" · "è¯·æ±è¶æ¶" · "åé¨æå¡å¨éè¯¯" · "ç¦æ­¢è®¿é®" · "æªæ¾å°" · "éè¯¯ç½å³" · "æåæå¡" · "ç½å³è¶æ¶" · "ç½ç»éè¯¯" · "è§£æéè¯¯" · "è¿æ¥å¤±è´¥" · "è¯ä¹¦éªè¯å¤±è´¥" · "è¿æ¥è¶æ¶" · "è¿æ¥è¶æ¶" · "æªç¥éè¯¯"
### `com.gku.loginmodule.network.errorhandler.ExceptionHandle$ERROR`
L103 · [class] public ERROR · `com/gku/loginmodule/network/errorhandler/ExceptionHandle.java`

字段/常量（6）：
- `int HTTP_ERROR = 1003`  L104
- `int NETWORK_ERROR = 1002`  L105
- `int PARSE_ERROR = 1001`  L106
- `int SSL_ERROR = 1005`  L107
- `int TIMEOUT_ERROR = 1006`  L108
- `int UNKNOWN = 1000`  L109

方法（1）：
- `public ERROR()`  L111
### `com.gku.loginmodule.network.errorhandler.ExceptionHandle$ResponseThrowable`
L115 · [class] public static ResponseThrowable · extends `Exception` · `com/gku/loginmodule/network/errorhandler/ExceptionHandle.java`

字段/常量（2）：
- `int code`  L116
- `String message`  L117

方法（1）：
- `public ResponseThrowable(Throwable throwable, int code)`  L119
### `com.gku.loginmodule.network.errorhandler.ExceptionHandle$ServerException`
L23 · [class] public static ServerException · extends `RuntimeException` · `com/gku/loginmodule/network/errorhandler/ExceptionHandle.java`

字段/常量（2）：
- `int code`  L24
- `String message`  L25
### `com.gku.loginmodule.network.errorhandler.HttpErrorHandler`
L7 · [class] public HttpErrorHandler · implements `Function<Throwable, Observable<T>>` · `com/gku/loginmodule/network/errorhandler/HttpErrorHandler.java`

方法（1）：
- `Observable<T> apply(Throwable throwable)`  L9 @Override
### `com.gku.loginmodule.network.INetworkRequiredInfo`
L6 · [interface] public INetworkRequiredInfo · `com/gku/loginmodule/network/INetworkRequiredInfo.java`

方法（4）：
- `String getAppVersionCode()`  L7
- `String getAppVersionName()`  L9
- `Application getApplicationContext()`  L11
- `boolean isDebug()`  L13
### `com.gku.loginmodule.network.interceptor.AuthInterceptor`
L9 · [class] public AuthInterceptor · implements `Interceptor` · `com/gku/loginmodule/network/interceptor/AuthInterceptor.java`

方法（2）：
- `Response intercept(Interceptor.Chain chain)`  L11 @Override
    - 体内字面量："Authorization" · "Bearer "
- `String getToken()`  L16
    - 体内字面量："auth"
### `com.gku.loginmodule.network.interceptor.RequestInterceptor`
L13 · [class] public RequestInterceptor · implements `Interceptor` · `com/gku/loginmodule/network/interceptor/RequestInterceptor.java`

字段/常量（1）：
- `INetworkRequiredInfo iNetworkRequiredInfo`  L14

方法（2）：
- `public RequestInterceptor(INetworkRequiredInfo iNetworkRequiredInfo)`  L16
- `Response intercept(Interceptor.Chain chain)`  L21 @Override
    - 体内字面量："os" · "android" · "appVersionName" · "datetime" · "lang" · "region"
### `com.gku.loginmodule.network.interceptor.ResponseInterceptor`
L9 · [class] public ResponseInterceptor · implements `Interceptor` · `com/gku/loginmodule/network/interceptor/ResponseInterceptor.java`

字段/常量（1）：
- `String TAG = "ResponseInterceptor"`  L10

方法（1）：
- `Response intercept(Interceptor.Chain chain)`  L13 @Override
    - 体内字面量："requestSpendTime=" · "ms"
### `com.gku.loginmodule.network.interceptor.TokenInterceptor`
L13 · [class] public TokenInterceptor · implements `Interceptor` · `com/gku/loginmodule/network/interceptor/TokenInterceptor.java`

字段/常量（2）：
- `String TOKEN_KEY = "token"`  L14
- `JSONObject jSONObjectOptJSONObject`  L18

方法（3）：
- `Response intercept(Interceptor.Chain chain)`  L17 @Override
- `void saveToken(String token)`  L38
    - 体内字面量："auth"
- `void clearToken()`  L42
    - 体内字面量："auth"
### `com.gku.loginmodule.network.NetworkApi`
L25 · [class] public NetworkApi · `com/gku/loginmodule/network/NetworkApi.java`

字段/常量（5）：
- `String BASE_URL`  L26
- `INetworkRequiredInfo iNetworkRequiredInfo`  L27
- `OkHttpClient okHttpClient`  L28
- `INetworkRequiredInfo iNetworkRequiredInfo2 = iNetworkRequiredInfo`  L55
- `HashMap<String, Retrofit> map = retrofitHashMap`  L67

方法（11）：
- `void init(INetworkRequiredInfo networkRequiredInfo)`  L31
- `T createService(Class<T> cls, int i)`  L35
- `void setUrlType(int type)`  L40
    - 体内字面量："https://server4.gkuvision.com/"
- `OkHttpClient getOkHttpClient()`  L47
- `Retrofit getRetrofit(Class serviceClass)`  L66
- `ObservableTransformer<T, T> applySchedulers(final Observer<T> observer)`  L81
- `ObservableSource apply(Observable observable)`  L84 @Override
- `ObservableSource lambda$applySchedulers$0(Observer observer, Observable observable)`  L90
- `Function<T, T> getAppErrorHandler()`  L96
- `Object apply(Object obj)`  L99 @Override
- `Object lambda$getAppErrorHandler$1(Object obj)`  L105
### `com.gku.loginmodule.network.utils.DateUtil`
L12 · [class] public DateUtil · `com/gku/loginmodule/network/utils/DateUtil.java`

字段/常量（26）：
- `String DAY = "dd"`  L13
- `String FULL_TIME = "yyyy-MM-dd HH:mm:ss.SSS"`  L14
- `String HOUR = "HH"`  L15
- `String HOUR_MINUTE_SECOND = "HH:mm:ss"`  L16
- `String HOUR_MINUTE_SECOND_CN = "HHæ¶mmåssç§"`  L17
- `String MILLISECOND = "SSS"`  L18
- `String MINUTE = "mm"`  L19
- `String MONTH = "MM"`  L20
- `String SECOND = "ss"`  L21
- `String STANDARD_TIME = "yyyy-MM-dd HH:mm:ss"`  L22
- `String TODAY = "ä»å¤©"`  L23
- `String TOMORROW = "æå¤©"`  L24
- `String YEAR = "yyyy"`  L25
- `String YEAR_MONTH_DAY = "yyyy-MM-dd"`  L26
- `String YEAR_MONTH_DAY_CN = "yyyyå¹´MMæddå·"`  L27
- `String YESTERDAY = "æ¨å¤©"`  L28
- `String SUNDAY = "æææ¥"`  L29
- `String MONDAY = "ææä¸"`  L30
- `String TUESDAY = "ææäº"`  L31
- `String WEDNESDAY = "ææä¸"`  L32
- `String THURSDAY = "ææå"`  L33
- `String FRIDAY = "ææäº"`  L34
- `String SATURDAY = "ææå­"`  L35
- `String[] WEEK_DAYS = {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}`  L36
- `Date date`  L113
- `Date date`  L138

方法（26）：
- `String getDateTime()`  L38
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
- `String getFullDateTime()`  L42
- `String getTheYearMonthAndDay()`  L46
- `String getTheYearMonthAndDayCn()`  L50
- `String getTheYearMonthAndDayDelimiter(CharSequence delimiter)`  L54
- `String getHoursMinutesAndSeconds()`  L58
- `String getHoursMinutesAndSecondsCn()`  L62
- `String getHoursMinutesAndSecondsDelimiter(CharSequence delimiter)`  L66
- `String getYear()`  L70
- `String getMonth()`  L74
- `String getDay()`  L78
- `String getHour()`  L82
- `String getMinute()`  L86
- `String getSecond()`  L90
- `String getMilliSecond()`  L94
- `long getTimestamp()`  L98
- `long getMillisNextEarlyMorning()`  L102
- `long dateToStamp(String time)`  L112
- `String stampToDate(long timeMillis)`  L123
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
- `String getTodayOfWeek()`  L127
- `String getWeek(String dateTime)`  L137
- `String getYesterday(Date date)`  L156
- `String getTomorrow(Date date)`  L163
- `String getDayInfo(String dateTime)`  L170
- `int getCurrentMonthDays()`  L186
- `int getMonthDays(int year, int month)`  L193
### `com.gku.loginmodule.network.utils.KLog`
L10 · [class] public final KLog · `com/gku/loginmodule/network/utils/KLog.java`

字段/常量（12）：
- `int A = 6`  L11
- `int D = 2`  L12
- `String DEFAULT_MESSAGE = "execute"`  L13
- `int E = 5`  L14
- `int I = 3`  L15
- `boolean IS_SHOW_LOG = true`  L16
- `int JSON = 7`  L17
- `int JSON_INDENT = 4`  L18
- `int V = 1`  L20
- `int W = 4`  L21
- `String string`  L108
- `String str2 = LINE_SEPARATOR`  L161

方法（23）：
- `void init(boolean isShowLog)`  L23
- `void v()`  L27
- `void v(String msg)`  L31
- `void v(String tag, String msg)`  L35
- `void d()`  L39
- `void d(String msg)`  L43
- `void d(String tag, String msg)`  L47
- `void i()`  L51
- `void i(String msg)`  L55
- `void i(String tag, String msg)`  L59
- `void w()`  L63
- `void w(String msg)`  L67
- `void w(String tag, String msg)`  L71
- `void e()`  L75
- `void e(String msg)`  L79
- `void e(String tag, String msg)`  L83
- `void a()`  L87
- `void a(String msg)`  L91
- `void a(String tag, String msg)`  L95
- `void json(String jsonFormat)`  L99
- `void json(String tag, String jsonFormat)`  L103
- `void printLog(int type, String tagStr, String msg)`  L107
- `void printLine(String tag, boolean isTop)`  L183
    - 体内字面量："ââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââ" · "ââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââââ"