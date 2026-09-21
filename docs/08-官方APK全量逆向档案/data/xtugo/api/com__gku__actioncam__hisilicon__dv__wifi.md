# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.wifi

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 5 个文件 / 15 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.wifi.HiWifiScrollView`
L36 · [class] public HiWifiScrollView · extends `ScrollView` · `com/gku/actioncam/hisilicon/dv/wifi/HiWifiScrollView.java`

字段/常量（57）：
- `int BREAK_LINE_BOTTOM = 5`  L37
- `int BREAK_LINE_LEFT = 30`  L38
- `int BREAK_LINE_RIGHT = 4`  L39
- `int BREAK_LINE_TOP = 5`  L40
- `int CHECK_CONNECT_TIMES = 60`  L41
- `int CHECK_GET_IP = 3`  L42
- `int CHECK_IDENTIFING = 5`  L43
- `int CHECK_LINKING = 2`  L44
- `int CHECK_POPUP_DLG = 1`  L45
- `int CHECK_PWD_ID = 1`  L46
- `int CHECK_TEXT_SIZE = 14`  L47
- `int CHECK_VERIFY = 4`  L48
- `int DEVICE_HEIGHT = 55`  L49
- `int DEVICE_LEFT_MARGIN = 15`  L50
- `int DEVICE_MARGIN = 1`  L51
- `int DEVICE_RIGHT_MARGIN = 20`  L52
- `int DEVICE_TEXT_SIZE = 18`  L53
- `String ENCRY_WPA = "WPA-"`  L54
- `String ENCRY_WPA2 = "WPA2-"`  L55
- `int ERROR_VALUE = 10`  L56
- `int MAX_COUNT_TIMEOUT = 250`  L57
- `int MIN_COUNT_TIMEOUT = 100`  L58
- `String TAG = "HiWifiScrollView"`  L59
- `Handler handVerifyDV`  L60
- `Handler handler`  L61
- `LinearLayout layoutColumn`  L62
- `Activity mActvitity`  L63
- `boolean mBcheckDV`  L64
- `Context mContext`  L65
- `int mCountTimeout`  L66
- `DisplayMetrics mDispalyMetrix`  L67
- `Handler mHandler`  L68
- `SupplicantState mLastSupplican`  L69
- `int mNetID`  L70
- `OnSetActivity mOnsetAct`  L71
- `View mVCurSelect`  L72
- `Verifydvfrag mVerify_dv`  L73
- `HiWifiManager mWifiManager`  L74
- `Wifipasswdinputfrag mWifi_passwdInput`  L75
- `String mstrConnectSSID`  L76
- `String mstrPassWord`  L77
- `String mstrSSID`  L78
- `Runnable runWifiConnect`  L79
- `int i = msg.what`  L96
- `HiWifiScrollView hiWifiScrollView = HiWifiScrollView.this`  L98
- `int i = msg.what`  L123
- `boolean z`  L181
- `String str = this.mstrConnectSSID`  L303
- `LinearLayout linearLayout = this.layoutColumn`  L321
- `String strSubstring`  L350
- `String str = this.mstrConnectSSID`  L378
- `HiWifiScrollView hiWifiScrollView = HiWifiScrollView.this`  L423
- `HiWifiScrollView hiWifiScrollView2 = HiWifiScrollView.this`  L430
- `OnSetActivity onSetActivity = this.mOnsetAct`  L556
- `HiWifiScrollView hiWifiScrollView = HiWifiScrollView.this`  L564
- `OnSetActivity onSetActivity2 = this.mOnsetAct`  L585
- `Handler handler = this.mHandler`  L589

方法（26）：
- `public HiWifiScrollView(Context context, AttributeSet attrs)`  L85
- `void handleMessage(Message msg)`  L95 @Override
- `void handleMessage(Message msg)`  L122 @Override
- `void run()`  L145 @Override
    - 体内字面量："case WIFI_DISCONNECT setWifiToAp" · "setWifiToAp ret:"
- `void run()`  L180 @Override
- `void run()`  L214 @Override
    - 体内字面量："mDispalyMetrix.density = "
- `void setHandler(Handler handler, HiWifiManager wifiManager)`  L281
- `void setActivity(Activity activity)`  L286
- `void setActivity(OnSetActivity onSetActivity)`  L290
- `void setListScanWifi(List<ScanResult> listScanResult)`  L294
- `void clearList()`  L320
- `void setScanWifi(ScanResult ScanResult)`  L328
- `boolean judgeEncryption(String capabilities)`  L340
- `boolean judgeCheckPassword(String SSID)`  L345
- `void addWifiDevice(ScanResult scanResult)`  L349
- `void onClick(View v)`  L419 @Override
- `void addNotRangeDevice(String SSID)`  L450
- `void onClick(View v)`  L479 @Override
- `void getSingnalLevel(ArrayList<String> listCode, int nSingnal)`  L489
- `void getCheckKeyAndCodelist(View v, ArrayList<String> listKey, ArrayList<String> listCode)`  L508
- `void getNotRangeKeyAndCodeList(ArrayList<String> listKey, ArrayList<String> listCode)`  L517
- `void getConnectKeyAndCodeList(View v, WifiInfo wifiInfo, ArrayList<String> listKey, ArrayList<String> listCode)`  L523
    - 体内字面量："Mbps"
- `String getIPFromInt(int ip)`  L537
    - 体内字面量："0.0.0.0"
- `void addBreakLine()`  L545
- `void connectDevice()`  L555
- `void run()`  L562 @Override
### `com.gku.actioncam.hisilicon.dv.wifi.HiWifiScrollView$AnonymousClass7`
L602 · [class] static AnonymousClass7 · `com/gku/actioncam/hisilicon/dv/wifi/HiWifiScrollView.java`

字段/常量（1）：
- `int[] $SwitchMap$android$net$wifi$SupplicantState`  L603
### `com.gku.actioncam.hisilicon.dv.wifi.HiWifiScrollView$OnSetActivity`
L81 · [interface] public OnSetActivity · `com/gku/actioncam/hisilicon/dv/wifi/HiWifiScrollView.java`

方法（1）：
- `void setEnable(boolean bEnable)`  L82
### `com.gku.actioncam.hisilicon.dv.wifi.WifiConnUtil`
L12 · [class] public WifiConnUtil · `com/gku/actioncam/hisilicon/dv/wifi/WifiConnUtil.java`

字段/常量（3）：
- `String TAG = "WifiConnUtil"`  L13
- `WifiManager wifiManager`  L14
- `String str = scanResult.capabilities`  L153

方法（9）：
- `public WifiConnUtil(WifiManager wifiManager)`  L23
- `void connect(String ssid, String password, WifiCipherType type)`  L27
- `WifiConfiguration isExsits(String SSID)`  L32
    - 体内字面量："\"" · "\""
- `WifiConfiguration createWifiInfo(String SSID, String Password, WifiCipherType Type)`  L42
    - 体内字面量："\"" · "\"" · "\"" · "\"" · "\"" · "\""
- `boolean openWifi()`  L81
- `void closeWifi()`  L88
- `boolean isHexWepKey(String wepKey)`  L132
- `boolean isHex(String key)`  L140
    - 体内字面量："0" · "9" · "A" · "F" · "a" · "f"
- `WifiCipherType getCipherType(Context context, String ssid)`  L150
    - 体内字面量："wifi"
### `com.gku.actioncam.hisilicon.dv.wifi.WifiConnUtil$ConnectRunnable`
L94 · [class] ConnectRunnable · implements `Runnable` · `com/gku/actioncam/hisilicon/dv/wifi/WifiConnUtil.java`

字段/常量（3）：
- `String password`  L95
- `String ssid`  L96
- `WifiCipherType type`  L97

方法（2）：
- `public ConnectRunnable(String ssid, String password, WifiCipherType type)`  L99
- `void run()`  L106 @Override
    - 体内字面量："wifiConfig is null!" · "enableNetwork status enable=" · "enableNetwork connected="
### `com.gku.actioncam.hisilicon.dv.wifi.WifiConnUtil$WifiCipherType`
L16 · [enum] public WifiCipherType · `com/gku/actioncam/hisilicon/dv/wifi/WifiConnUtil.java`

枚举常量（3）：
- `WIFICIPHER_WEP()`  L17
- `WIFICIPHER_WPA()`  L18
- `WIFICIPHER_NOPASS()`  L19
### `com.gku.actioncam.hisilicon.dv.wifi.WifiDeviceActivity`
L24 · [class] public WifiDeviceActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/wifi/WifiDeviceActivity.java`

字段/常量（11）：
- `ImageView imgBack`  L25
- `ImageView imgScanRefresh`  L26
- `List<ScanResult> mListScanResult`  L27
- `HiWifiManager mWifiManager`  L28
- `HiWifiScrollView mWifiScrollView`  L29
- `wifiStateBrodcast mWifiStateBrodcast`  L30
- `String TAG = "WifiDeviceActivity"`  L31
- `boolean mBfreshWifiList = true`  L32
- `String connectWifiName`  L95
- `List<ScanResult> list = this.mListScanResult`  L99
- `wifiStateBrodcast wifistatebrodcast = this.mWifiStateBrodcast`  L115

方法（9）：
- `void handleMessage(Message msg)`  L35 @Override
- `void onCreate(Bundle savedInstanceState)`  L43 @Override
    - 体内字面量："android.net.wifi.STATE_CHANGE" · "android.net.wifi.STATE_CHANGE"
- `void onClick(View v)`  L56 @Override
- `void setEnable(boolean bEnable)`  L62 @Override
- `void onClick(View v)`  L69 @Override
- `void onResume()`  L76 @Override
- `void findView()`  L80
- `void startScan()`  L94
- `void onDestroy()`  L114 @Override
### `com.gku.actioncam.hisilicon.dv.wifi.WifiDeviceActivity$AnonymousClass5`
L141 · [class] static AnonymousClass5 · `com/gku/actioncam/hisilicon/dv/wifi/WifiDeviceActivity.java`

字段/常量（1）：
- `int[] $SwitchMap$android$net$NetworkInfo$DetailedState`  L142
### `com.gku.actioncam.hisilicon.dv.wifi.WifiDeviceActivity$wifiStateBrodcast`
L123 · [class] wifiStateBrodcast · extends `BroadcastReceiver` · `com/gku/actioncam/hisilicon/dv/wifi/WifiDeviceActivity.java`

方法（1）：
- `void onReceive(Context context, Intent intent)`  L128 @Override
    - 体内字面量："android.net.wifi.STATE_CHANGE" · "networkInfo" · "WifiDeviceActivity" · "info.state = " · ":"
### `com.gku.actioncam.hisilicon.dv.wifi.WifiDisconnectReceiver`
L18 · [class] public WifiDisconnectReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/hisilicon/dv/wifi/WifiDisconnectReceiver.java`

字段/常量（16）：
- `int CONNECT_TIMES_COUNT = 250`  L19
- `int CONNECT_TIMES_TIME = 60`  L20
- `String TAG = "WifiDisconnectReceiver"`  L21
- `Context mContext`  L22
- `HiWifiManager mHiWifiManager`  L23
- `setNetworkListener mOnWifiListener`  L24
- `String mstrPassword`  L25
- `String mstrSSID`  L26
- `int mConnectTime = 0`  L27
- `NetworkInfo.DetailedState mLastState = null`  L28
- `WifiDisconnectReceiver wifiDisconnectReceiver = WifiDisconnectReceiver.this`  L33
- `int i = wifiDisconnectReceiver.mConnectTime`  L34
- `WifiDisconnectReceiver wifiDisconnectReceiver = WifiDisconnectReceiver.this`  L55
- `int i = wifiDisconnectReceiver.mConnectTime`  L56
- `setNetworkListener setnetworklistener = this.mOnWifiListener`  L90
- `Context context2 = this.mContext`  L135

方法（6）：
- `void run()`  L32 @Override
- `void run()`  L45 @Override
    - 体内字面量："\"" · "\"" · "\"" · "\""
- `public WifiDisconnectReceiver(Context context)`  L69
- `void setOnWifilistener(setNetworkListener onWifiListen)`  L75
- `void onReceive(Context context, Intent intent)`  L80 @Override
    - 体内字面量："tagying" · "strAction:" · "android.net.wifi.STATE_CHANGE" · "networkInfo" · "info.state = "
- `void release()`  L166
### `com.gku.actioncam.hisilicon.dv.wifi.WifiDisconnectReceiver$AnonymousClass3`
L149 · [class] static AnonymousClass3 · `com/gku/actioncam/hisilicon/dv/wifi/WifiDisconnectReceiver.java`

字段/常量（1）：
- `int[] $SwitchMap$android$net$NetworkInfo$DetailedState`  L150
### `com.gku.actioncam.hisilicon.dv.wifi.WifiDisconnectReceiver$setNetworkListener`
L65 · [interface] public setNetworkListener · `com/gku/actioncam/hisilicon/dv/wifi/WifiDisconnectReceiver.java`

方法（1）：
- `void onWifiStateChanged(NetworkInfo.DetailedState detailedState)`  L66
### `com.gku.actioncam.hisilicon.dv.wifi.WifiUtils`
L28 · [class] public WifiUtils · `com/gku/actioncam/hisilicon/dv/wifi/WifiUtils.java`

字段/常量（19）：
- `boolean $assertionsDisabled = false`  L29
- `String ALL_SSID = "all_dv_device_ssid_list"`  L30
- `String TAG = "WifiUtils"`  L31
- `String WIFI_CONNECT_SSID = "start_wifi_ssid"`  L32
- `String WIFI_ENABLE = "dv_device_wifi_enable"`  L33
- `String WIFI_LAST_CONNECT_SSID = "wifi_last_Connected_SSID"`  L34
- `int WIFI_NO_CONFIG = -1`  L35
- `int WIFI_NO_ERROR = 0`  L36
- `int WIFI_NO_SCAN = -2`  L37
- `int WIFI_NO_SSID = -3`  L38
- `Context mConext`  L39
- `WifiManager mWifiManager`  L40
- `boolean mBEnable`  L41
- `List<ScanResult> mListScanResult`  L42
- `int iAddNetwork`  L309
- `ConnectCallback connectCallback = callback`  L370
- `ConnectCallback connectCallback = callback`  L378
- `WifiManager wifiManager = mWifiManager`  L433
- `WifiConfiguration wifiConfigurationFindConfiguration`  L442

方法（37）：
- `private WifiUtils()`  L50
- `WifiUtils getInstance(Context context)`  L61
    - 体内字面量："wifi"
- `String getWifiRemoteIp()`  L67
- `String intIPToIp(int ip)`  L75
- `void removeEnableState()`  L79
    - 体内字面量："openWifi strSSID:"
- `String getLastConnectDeviceInfo()`  L101
    - 体内字面量："getLastConnectDeviceInfo ssid:"
- `void removeDeviceInfo(String SSID)`  L107
    - 体内字面量：";"
- `void updateDeviceInfo(String oldSSID, String newSSID, String newPasswd)`  L124
- `void saveDeviceInfo(String SSID, String password)`  L134
    - 体内字面量："saveDeviceInfo:" · ":password" · "allSSID:" · ";"
- `String[] getAllSSID()`  L151
    - 体内字面量：";"
- `String getDevicePassword(String SSID)`  L159
    - 体内字面量："getDevicePassword SSID:" · "getDevicePassword strPassWord:"
- `WifiInfo getConnectWifiInfo()`  L169
- `boolean openWifi()`  L173
- `boolean isWifiEnabled()`  L182
- `void closeWifi()`  L186
- `boolean isWifiConnectState()`  L192
- `void setEnableState(boolean bEnable)`  L197
    - 体内字面量："strSSID:"
- `boolean isWifiConnected(Context context)`  L213
    - 体内字面量："connectivity"
- `boolean isDVDevice()`  L221
    - 体内字面量："\"" · "\""
- `String getConnectWifiName()`  L232
    - 体内字面量："\"" · "connectivity" · "\"" · "unknown ssid"
- `void startScan()`  L243
- `List<ScanResult> getWifiScanResult()`  L248
- `int findScanResult(String SSID)`  L252
    - 体内字面量："\"" · "\""
- `WifiConfiguration findConfiguration(String SSID)`  L276
    - 体内字面量："findConfiguration:null" · "wifiConfig.size = " · "find device configuration failed! "
- `void connectStartInternet()`  L292
    - 体内字面量："strSSID = "
- `void enableNetwork(String SSID)`  L300
    - 体内字面量："\"" · "\"" · "wifiConfig.SSID:"
- `int connectWifiBeforeQ(String SSID, String password)`  L308
- `void connectWifiAfterQ(String ssid, String pass, ConnectivityManager connectivityManager, final ConnectCallback callback)`  L362
- `void onAvailable(Network network)`  L369 @Override
- `void onUnavailable()`  L377 @Override
- `void connectWifiAfterQ(String ssid, String pass, final WIFIUtils.Callback callback)`  L390
    - 体内字面量："wifi" · "connectivity"
- `void onAvailable(Network network)`  L397 @Override
- `void onUnavailable()`  L402 @Override
- `void setConfigInfo(WifiConfiguration wifiConfig)`  L409
- `boolean disconnectWifi()`  L425
    - 体内字面量："disconnectWifi"
- `void disconnectCurWifi(int nID)`  L432
- `void clearConfigure(String SSID)`  L441
### `com.gku.actioncam.hisilicon.dv.wifi.WifiUtils$ConnectCallback`
L44 · [interface] public ConnectCallback · `com/gku/actioncam/hisilicon/dv/wifi/WifiUtils.java`

方法（2）：
- `void onFail()`  L45
- `void onSuccess(Network network)`  L47
### `com.gku.actioncam.hisilicon.dv.wifi.WifiUtils$SingleHolder`
L54 · [class] private static SingleHolder · `com/gku/actioncam/hisilicon/dv/wifi/WifiUtils.java`

方法（1）：
- `private SingleHolder()`  L57