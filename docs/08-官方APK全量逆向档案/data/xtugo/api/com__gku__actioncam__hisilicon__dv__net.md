# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.net

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 6 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.net.HttpProxy`
L37 · [class] public HttpProxy · `com/gku/actioncam/hisilicon/dv/net/HttpProxy.java`

字段/常量（10）：
- `String TAG = "HttpProxy"`  L38
- `Handler handler`  L39
- `HttpClient httpClient`  L40
- `Context mContext`  L41
- `int i = -1`  L148
- `int i2 = -1`  L149
- `String str2 = httpResultDoHttpGetForContent.content`  L187
- `String strReplaceAll = CameraParameters.BaseUrl + "setcurworkmode.cgi?-workmode=" + SelectModel`  L225
- `String str`  L275
- `String str = CameraParameters.BaseUrl + "settimelapseinfo.cgi?-time=" + time`  L300

方法（21）：
- `void handleMessage(Message msg)`  L49 @Override
- `HttpResult doHttpGetForContent(String url)`  L59
    - 体内字面量："getbatterycapacity" · "getsdstate" · "doHttpGetForContent>>>:url: " · "doHttpGetForContent>>>:content: " · "doHttpGetForContent>>>:url: " · "doHttpGetForContent>>>:content: " · "doHttpGetForContent>>>:url: " · "doHttpGetForContent>>>:content: "
- `int doForSuccess(String url)`  L89
    - 体内字面量："doForSuccess = "
- `Boolean doForBoolean(String url)`  L94
    - 体内字面量："tagying" · "doForBoolean:  ---------------------   "
- `int doForMap(String url, Map<String, String> map)`  L109
    - 体内字面量："789789" · "doForMap:  -------------------   "
- `int doForIntByKey(String url, String key)`  L115
- `String doForStringByKey(String url, String key)`  L132
- `CameraStatus doForGetCameraStatus()`  L142
    - 体内字面量："/cgi-bin/hi3510/getcamerastatus.cgi"
- `void doForSetCameraStatus(final int status, final CameraStatusCallback cameraStatusCallback)`  L171
- `void run()`  L174 @Override
- `void lambda$doForSetCameraStatus$0(int i, CameraStatusCallback cameraStatusCallback)`  L180
    - 体内字面量："/cgi-bin/hi3510/setcamerastatus.cgi?-status=" · "yunqi_debug" · "doForSetCameraStatus: "
- `void getAllWorkModelNewAPP()`  L197
    - 体内字面量："getallworkmode.cgi" · "4531231" · "getAllWorkModelNewAPP:  ----------------   " · "photo" · "4531231" · "getAllWorkModelNewAPP:  -------------------   " · "video" · "video"
- `String getCurrentWorkModel()`  L213
    - 体内字面量："getcurworkmode.cgi" · "workmode"
- `boolean setCurrentWorkModel(String SelectModel, Context mcontext)`  L223
- `boolean setModelPamarsStr(String value, String itemName, int TYPE)`  L241
    - 体内字面量："setcurparameter.cgi?-workmode=" · "&-name=" · "&-value=" · "%20" · "avbngscvx" · "setModelPamarsStr:  ---------11----------------   "
- `boolean setDevicePamarsStr(String value, String itemName)`  L258
    - 体内字面量："utf-8" · "utf-8" · "setcurparameter.cgi?-workmode=System&-name=" · "&-value="
- `boolean setDevicePamarsStrNoValue(int type)`  L274
- `boolean setTimePhoto(int time)`  L291
    - 体内字面量："settimerinfo.cgi?&-time="
- `boolean setTimelapseInfo(int time)`  L299
- `void getCameraCurrentInfor(Context mContext2, int VERSION)`  L305
    - 体内字面量："getcurallinfo.cgi" · "getallinfo.cgi" · "mode" · "{\"mode\":\"" · "\";\"state\":\"" · "state" · "\";\"event\":\"" · "event" · "\";\"pasttime\":\"" · "pasttime" · "\"}" · "data"
- `String replaceMode(int value)`  L319
### `com.gku.actioncam.hisilicon.dv.net.HttpRequest`
L27 · [class] public final HttpRequest · `com/gku/actioncam/hisilicon/dv/net/HttpRequest.java`
注解：

字段/常量（44）：
- `String getActivateInfoCGI`  L28
- `String getDeviceAttrCGI`  L29
- `OkHttpClient okHttpClient`  L30
- `String setActivateInfoCGI`  L31
- `String setTrialCGI`  L32
- `SocketFactory socketFactory`  L33
- `CameraInfors cameraInfors`  L75
- `String strString`  L76
- `int iLastIndexOf$default`  L77
- `int i`  L78
- `String str`  L79
- `String str2`  L80
- `String str3`  L81
- `String str4`  L82
- `String str5`  L83
- `String str6`  L84
- `String str7`  L85
- `String str8`  L86
- `String str9`  L87
- `String str10`  L88
- `long j`  L89
- `int i2`  L90
- `String str11`  L91
- `String str12`  L92
- `String str13`  L93
- `String str14`  L94
- `String str15`  L95
- `int i3 = 0`  L111
- `String str16 = "G"`  L112
- `String strString`  L243
- `String str = "<binary/metadata>"`  L247
- `String strString`  L282
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L290
- `String strString`  L308
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L316
- `OkHttpClient okHttpClientBuild`  L332
- `String strString`  L333
- `String str = content`  L356
- `String str2 = strSubstring`  L366
- `int i = 0`  L368
- `boolean z = false`  L369
- `String str3 = strSubstring2`  L386
- `int i2 = 0`  L388
- `boolean z3 = false`  L389

方法（10）：
- `SocketFactory getSocketFactory()`  L35
- `OkHttpClient getOkHttpClient()`  L39
- `void setOkHttpClient(OkHttpClient okHttpClient)`  L43
    - 体内字面量："<set-?>"
- `public HttpRequest()`  L48
    - 体内字面量："getdeviceattr.cgi" · "getactivateinfo.cgi" · "setactivateinfo.cgi?-status=%d&-version=%s" · "settrial.cgi?-status=%d&-version=%s"
- `CameraInfors getDeviceAttrCameraInfo(String baseIp)`  L74
- `CameraActivateInfors getDeviceActivateInfo(String baseIp)`  L242
- `boolean setDeviceActivateInfo(String baseIp)`  L281
- `void setTrial(String baseIp)`  L307
- `HashMap<String, String> getDeviceAttrMap(String baseIp)`  L331
- `HashMap<String, String> getMap(String content)`  L354
### `com.gku.actioncam.hisilicon.dv.net.HttpResult`
L4 · [class] public HttpResult · `com/gku/actioncam/hisilicon/dv/net/HttpResult.java`

字段/常量（4）：
- `int HTTP_EXCEPTION = -1`  L5
- `int HTTP_OK = 200`  L6
- `String content`  L7
- `int statusCode`  L8
### `com.gku.actioncam.hisilicon.dv.net.KeepAliveService`
L11 · [class] public KeepAliveService · extends `Service` · `com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java`

字段/常量（9）：
- `int FAST_CHECK_TICK_TIME = 2000`  L12
- `int MAX_TICK_COUNT = 5`  L13
- `String MESSAGE_DV_ISALIVE_ACTION = "com.gku.xtugo.DV_ISALIVE_ACTION"`  L14
- `String MESSAGE_STRING_NETWORK_PAST = "networkpast"`  L15
- `int SLOW_CHECK_TICK_TIME = 5000`  L16
- `String TAG = "KeepAliveService"`  L17
- `boolean bRuning = false`  L18
- `boolean bNetworkPast = true`  L19
- `int mTickCount = 0`  L20

方法（5）：
- `IBinder onBind(Intent arg0)`  L23 @Override
- `void onCreate()`  L28 @Override
    - 体内字面量："onCreate"
- `void onDestroy()`  L36 @Override
    - 体内字面量："onDestroy"
- `void startThread()`  L43
    - 体内字面量："KeepAliveThread"
- `void run()`  L46 @Override
    - 体内字面量："tagying" · "run: ---------------------   " · "isDeviceAvailable:false" · "bNetworkPast:" · "isDeviceAvailable:true" · "bNetworkPast:"
### `com.gku.actioncam.hisilicon.dv.net.MessageService`
L17 · [class] public MessageService · extends `Service` · `com/gku/actioncam/hisilicon/dv/net/MessageService.java`

字段/常量（7）：
- `String MESSAGE_ACTION = "com.gku.xtugo.MESSAGE_ACTION"`  L18
- `int SERVER_PORT = 5678`  L19
- `String TAG = "MessageService"`  L20
- `ServerSocket mServerSocket = null`  L21
- `boolean bStopService = false`  L22
- `ServerSocket serverSocket = this.mServerSocket`  L78
- `Thread thread = this.mServerThread`  L82

方法（5）：
- `void run()`  L25 @Override
    - 体内字面量："yunqi_debug" · "run: MessageService start" · "45434354366986" · "Server begin accept"
- `IBinder onBind(Intent intent)`  L49 @Override
- `void onCreate()`  L54 @Override
    - 体内字面量："notification" · "message" · "message" · "message"
- `int onStartCommand(Intent intent, int flags, int startId)`  L64 @Override
    - 体内字面量："yingxinquanabc" · "onStartCommand:  ----------------   å¼å¯çº¿ç¨"
- `void onDestroy()`  L75 @Override
### `com.gku.actioncam.hisilicon.dv.net.MessageService$RecvThread`
L92 · [class] private static RecvThread · extends `Thread` · `com/gku/actioncam/hisilicon/dv/net/MessageService.java`

字段/常量（5）：
- `int BUFFER_LENGTH = 512`  L93
- `Context mContext`  L94
- `Socket mSocket`  L95
- `byte[] bArr = new byte[512]`  L104
- `int i = 0`  L110

方法（2）：
- `public RecvThread(Context context, Socket socket)`  L97
- `void run()`  L103 @Override
### `com.gku.actioncam.hisilicon.dv.net.StringParser`
L16 · [class] public StringParser · `com/gku/actioncam/hisilicon/dv/net/StringParser.java`

字段/常量（6）：
- `String HEAD_VAR = "var "`  L17
- `String MID_EQUAL_MARK = "=\""`  L18
- `String TAIL_SEMICOLON = "\";\r\n"`  L19
- `int i = 0`  L23
- `int i2 = 0`  L28
- `int i = 0`  L56

方法（5）：
- `int getStringList(String content, List<String> list)`  L21
    - 体内字面量："786452132131321" · "getStringList:  -----------------------------     "
- `ArrayList<MediaModel> getMediaList(String content, ArrayList<MediaModel> list)`  L41
    - 体内字面量："yunqi_debug" · "getMediaList: json: " · "size"
- `int getKeyValueMap(String content, Map<String, String> map)`  L55
- `Map<String, String> getMap(String content, Map<String, String> map)`  L74
- `Map<String, String> getMap2(String content, Map<String, String> map)`  L91
    - 体内字面量："jikjhnbm" · "getMap2:  ------------   è¿åäºç©º" · "453425421" · "getMap2:----------------   " · "\";"