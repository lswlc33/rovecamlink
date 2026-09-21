# idGoLive — 类与成员明细：com.icatchtek.baseutil.network

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 3 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.network.NetWorkUtils`
L27 · [class] public NetWorkUtils · `com/icatchtek/baseutil/network/NetWorkUtils.java`

字段/常量（12）：
- `String ACCOUNT_SERVER = AppInfo.ACCOUNT_SERVER_ADDRESS`  L28
- `String PUSH_SERVER = "push.smarthome.icatchtek.com"`  L29
- `String TAG = "NetWorkUtils"`  L30
- `HttpURLConnection httpURLConnection`  L100
- `int i = 0`  L170
- `NetworkInfo activeNetworkInfo`  L198
- `NetworkInfo activeNetworkInfo`  L217
- `NetworkInfo activeNetworkInfo`  L253
- `StringBuilder sbAppend`  L263
- `String str2`  L264
- `StringBuilder sbAppend2`  L265
- `String str3 = str`  L266

方法（26）：
- `void checkAccountServerState(Context context)`  L64
    - 体内字面量："https://"
- `void onError()`  L67 @Override
    - 体内字面量："checkAccountServerState onError"
- `void onSuccess()`  L72 @Override
    - 体内字面量："checkAccountServerState onSuccess"
- `void checkICatchPushServerState(Context context)`  L78
    - 体内字面量："https://push.smarthome.icatchtek.com"
- `void onError()`  L81 @Override
    - 体内字面量："checkICatchPushServerState onError"
- `void onSuccess()`  L86 @Override
    - 体内字面量："checkICatchPushServerState onSuccess"
- `void checkNetworkState(Context context, OnCallback onCallback)`  L92
    - 体内字面量："https://www.baidu.com"
- `void checkNetworkState(Context context, final String str, final OnCallback onCallback)`  L96
- `void run()`  L99 @Override
- `void run()`  L122 @Override
- `void run()`  L129 @Override
    - 体内字面量："checkNetworkState[" · "] IOException"
- `void run()`  L139 @Override
    - 体内字面量："checkNetworkState[" · "] ProtocolException"
- `void run()`  L149 @Override
    - 体内字面量："checkNetworkState[" · "] MalformedURLException"
- `void run()`  L159 @Override
- `int getAPNType(Context context)`  L168
    - 体内字面量："connectivity"
- `int getConnectedType(Context context)`  L197
- `boolean is24GWifi(Context context)`  L205
    - 体内字面量："wifi" · "SDK_INT > LOLLIPOP"
- `boolean isGPSEnabled(Context context)`  L212
    - 体内字面量："location" · "gps"
- `boolean isMobileConnected(Context context)`  L216
- `void isNetWorkAvailableOfDNS(final String str, final OnCallback onCallback)`  L224
- `void run()`  L227 @Override
    - 体内字面量："isNetWorkAvailableOfDNS[" · "] resCode: "
- `boolean isNetworkConnected(Context context)`  L252
- `void ping(final String str)`  L259
- `void run()`  L262 @Override
- `void pingAccountServer()`  L297
- `void pingICatchPushServer()`  L301
    - 体内字面量："push.smarthome.icatchtek.com"
### `com.icatchtek.baseutil.network.NetWorkUtils$DNSParse`
L32 · [class] private static DNSParse · implements `Runnable` · `com/icatchtek/baseutil/network/NetWorkUtils.java`

字段/常量（2）：
- `InetAddress address`  L33
- `String hostname`  L34

方法（4）：
- `public DNSParse(String str)`  L36
- `InetAddress get()`  L40
- `void run()`  L45 @Override
- `void set(InetAddress inetAddress)`  L53
### `com.icatchtek.baseutil.network.NetWorkUtils$OnCallback`
L58 · [interface] public OnCallback · `com/icatchtek/baseutil/network/NetWorkUtils.java`

方法（2）：
- `void onError()`  L59
- `void onSuccess()`  L61