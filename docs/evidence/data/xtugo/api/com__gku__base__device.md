# XTU GO — 类与成员明细：com.gku.base.device

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.base.device.DeviceHttpUtils`
L8 · [class] public DeviceHttpUtils · `com/gku/base/device/DeviceHttpUtils.java`

字段/常量（4）：
- `int CODE_JSON_PARSE_ERROR = -200`  L9
- `int CODE_NO_DATA = -100`  L10
- `int CODE_OK = 0`  L11
- `String HTTP = "http://"`  L12

方法（2）：
- `GetRequestGenerator get(String str)`  L14
    - 体内字面量："http://"
- `FileUploadGenerator uploadFile(String str)`  L18
    - 体内字面量："http://"
### `com.gku.base.device.NetworkDeviceUtils`
L34 · [class] public NetworkDeviceUtils · `com/gku/base/device/NetworkDeviceUtils.java`

字段/常量（22）：
- `int NET_STATE_ONAVAILABLE`  L36
- `int NET_STATE_ONLOST`  L37
- `int NET_STATE_ONUNAVAILABLE`  L38
- `int NET_STATE_UNKNOWN`  L39
- `int activityCount`  L40
- `Activity activityTop`  L41
- `boolean appFront`  L42
- `boolean connecting`  L43
- `ConnectivityManager connectivityManager`  L44
- `Context contextApp`  L45
- `boolean fromScan`  L46
- `List<Callback> listCallback`  L47
- `Object lockNetwork`  L48
- `Map<Long, NetworkState> mapNetworkState`  L49
- `int net_state`  L50
- `ConnectivityManager.NetworkCallback networkCallbackGlobal`  L51
- `ConnectivityManager.NetworkCallback networkCallbackScan`  L52
- `Network networkDevice`  L53
- `NetworkState networkState`  L238
- `String hostAddress = "<binary/metadata>"`  L333
- `Activity activity = this.activityTop`  L368
- `int i = this.net_state`  L394

方法（44）：
- `private NetworkDeviceUtils()`  L69
- `NetworkDeviceUtils getInstance()`  L91
- `void init(Application application)`  L95
    - 体内字面量："connectivity"
- `void onAvailable(Network network)`  L104 @Override
    - 体内字面量："global onAvailable" · "global onAvailable" · "global onAvailable" · "global onAvailable gateway = " · "global onAvailable Exception = " · "global onAvailable"
- `void onUnavailable()`  L130 @Override
    - 体内字面量："global" · "onUnavailable"
- `void onLost(Network network)`  L136 @Override
    - 体内字面量："global onLost"
- `void onAvailable(Network network)`  L143 @Override
    - 体内字面量："scan onAvailable" · "scan onAvailable" · "scan onAvailable" · "scan gateway = " · " scan onAvailable Exception = " · "scan onAvailable"
- `void onUnavailable()`  L169 @Override
    - 体内字面量："scan onUnavailable"
- `void onLost(Network network)`  L176 @Override
    - 体内字面量："scan onLost"
- `void onActivityCreated(Activity activity, Bundle bundle)`  L184 @Override
- `void onActivityPaused(Activity activity)`  L188 @Override
- `void onActivitySaveInstanceState(Activity activity, Bundle bundle)`  L192 @Override
- `void onActivityStarted(Activity activity)`  L196 @Override
    - 体内字面量："åºç¨è¿å¥åå°"
- `void onActivityStopped(Activity activity)`  L209 @Override
    - 体内字面量："åºç¨è¿å¥åå°"
- `void onActivityDestroyed(Activity activity)`  L222 @Override
- `void onActivityResumed(Activity activity)`  L229 @Override
    - 体内字面量："netonActivityResumed"
- `NetworkState getNetworkState(Network network)`  L237
- `void device_wifi_Available(boolean z, Network network, NetworkState networkState)`  L251
- `void run()`  L260 @Override
- `void m2276x3a9a207d()`  L269
- `void device_wifi_Lost(Network network)`  L277
- `void run()`  L286 @Override
- `void m2277lambda$device_wifi_Lost$1$comgkubasedeviceNetworkDeviceUtils()`  L295
- `void deal_Unavailable(final boolean z)`  L303
- `void run()`  L306 @Override
- `void notifyConnectFailed()`  L315
- `ConnectivityManager getConnectivityManager()`  L324
- `Network getNetworkDevice()`  L328
- `String getIpDevice()`  L332
- `String getWiFiServerIp(Context context)`  L347
    - 体内字面量："wifi"
- `String intIPToIp(int i)`  L356
- `boolean isValidIp(String str)`  L360
- `Activity getActivityTop()`  L367
- `void addCallback(final T t, final Callback callback)`  L375
- `void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event)`  L378 @Override
    - 体内字面量："åºç¨ addCallback ON_DESTROY" · "åºç¨è¿å¥åå°addCallback" · "åºç¨è¿å¥åå°addCallback"
- `void setWifiScanListener(Context context, String str, String str2)`  L403
    - 体内字面量："setWifiScanListener" · "WPA"
- `void unregisterNetworkCallbackAll()`  L412
- `void registerNetworkCallbackGlobal()`  L417
- `void unregisterNetworkCallbackGlobal()`  L424
- `void unregisterNetworkCallbackScan()`  L432
    - 体内字面量："unregisterNetworkCallbackScan"
- `void bindProcessToNetworkNoNet()`  L440
- `void unBindProcessToNetworkNoNet()`  L444
- `void bindProcessToNetwork(Network network)`  L448
- `boolean connectWifi(Context context, String str, String str2, String str3)`  L455
    - 体内字面量："wifi" · "\"" · "\"" · "\"" · "\"" · "WPA" · "\"" · "\"" · "WEP" · "\"" · "\""
### `com.gku.base.device.NetworkDeviceUtils$Callback`
L55 · [interface] public Callback · `com/gku/base/device/NetworkDeviceUtils.java`

方法（6）：
- `void onAppStart()`  L56
- `void onAppStop()`  L58
- `void onAvailable()`  L60
- `void onCurrentLifecycleOwnerDestroy()`  L62
- `void onLost()`  L64
- `void onUnavailable(boolean z)`  L66
### `com.gku.base.device.NetworkDeviceUtils$Holder`
L84 · [class] private static Holder · `com/gku/base/device/NetworkDeviceUtils.java`

方法（1）：
- `private Holder()`  L87
### `com.gku.base.device.NetworkDeviceUtils$NetworkState`
L501 · [class] private static NetworkState · `com/gku/base/device/NetworkDeviceUtils.java`

字段/常量（1）：
- `boolean available`  L502

方法（1）：
- `private NetworkState()`  L504