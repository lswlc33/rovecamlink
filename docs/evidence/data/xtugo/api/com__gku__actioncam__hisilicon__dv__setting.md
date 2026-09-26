# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.setting

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 7 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.setting.AboutCameraActivity`
L25 · [class] public AboutCameraActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/setting/AboutCameraActivity.java`

字段/常量（12）：
- `TextView aboutCameraName`  L26
- `FirmwareInfo firmwareInfo`  L27
- `ImageView logoIconCamera`  L28
- `ImageView logoMainCamera`  L29
- `TextView textAppVersion`  L30
- `TextView textBuildDate`  L31
- `TextView textDeviceChip`  L32
- `TextView textDeviceOS`  L33
- `TextView textDeviceSensor`  L34
- `TextView textFirmwareVersion`  L35
- `TextView textHardwareFeature`  L36
- `TextView textUpgradeFirmware`  L37

方法（7）：
- `void onClick(View v)`  L40 @Override
- `void onCreate(Bundle savedInstanceState)`  L51 @Override
    - 体内字面量："Supremo Conquest" · "CaddxFPV"
- `void onStart()`  L82 @Override
    - 体内字面量："yunqi_debug" · "onStart: "
- `void onStop()`  L96 @Override
- `void findViews()`  L100
- `void setAmbaTextViews(String version, String date)`  L111
- `void setTextViews(FirmwareInfo firmwareInfo)`  L128
    - 体内字面量："yunqi_debug" · "setTextViews: firmwareInfo null"
### `com.gku.actioncam.hisilicon.dv.setting.AboutClientActivity`
L39 · [class] public AboutClientActivity · extends `BaseActivity` · `com/gku/actioncam/hisilicon/dv/setting/AboutClientActivity.java`

字段/常量（23）：
- `int MSG_GET_SERVER_INFO_FAILED = 4098`  L40
- `int MSG_GET_SERVER_INFO_SUCCESS = 4097`  L41
- `ImageView backReturn`  L42
- `RelativeLayout cU`  L43
- `TextView clientName`  L44
- `RelativeLayout contactUs`  L45
- `ExecutorService executorServiceSingle`  L46
- `ImageView logoIconClient`  L47
- `ImageView logoMainClient`  L48
- `PackageInfo packageInfo`  L49
- `PackageManager packageManager`  L50
- `String serverInfo`  L51
- `TextView textBuildDate`  L52
- `TextView textCheckUpdate`  L53
- `TextView textClientVersion`  L54
- `TextView textICP`  L55
- `UpgradeViewManager upgradeViewManager`  L56
- `LinearLayout visitCS`  L57
- `int mMultiClick = 0`  L58
- `long mLastMultiClickTime = 0`  L59
- `int i = msg.what`  L68
- `AboutClientActivity aboutClientActivity = AboutClientActivity.this`  L154
- `String str = packageInfo.versionName`  L201

方法（13）：
- `void onClick(View v)`  L62 @Override
- `void handleMessage(Message msg)`  L67 @Override
- `void onCreate(Bundle savedInstanceState)`  L81 @Override
- `void onClick(View view)`  L103 @Override
    - 体内字面量："android.intent.action.SEND" · "android.intent.extra.STREAM" · "*/*" · "ä¸ä¼ æ¥å¿æä»¶" · "send_log"
- `void onClick(View v)`  L127 @Override
- `void onClick(View v)`  L134 @Override
    - 体内字面量："label" · "è¦å¤å¶çææ¬" · "clipboard" · "+86-15999693535"
- `void onClick(View v)`  L144 @Override
    - 体内字面量："clipboard" · "support@xtucam.com" · "text" · "support@xtucam.com"
- `void onClick(View v)`  L160 @Override
    - 体内字面量："https://play.google.com/store/apps/details?id=com.gku.yutupro"
- `void jumpToAppStore(String url)`  L171
    - 体内字面量："android.intent.action.VIEW"
- `void onStart()`  L178 @Override
- `void onStop()`  L183 @Override
- `void findViews()`  L187
    - 体内字面量："zh"
- `void setTextViews()`  L197
### `com.gku.actioncam.hisilicon.dv.setting.BitRateActivity`
L17 · [class] public BitRateActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/setting/BitRateActivity.java`

字段/常量（7）：
- `int MSG_GOT_BITRATE = 0`  L18
- `int MSG_SET_FAIL = 2`  L19
- `int MSG_SET_OK = 1`  L20
- `Button btnBitRate`  L21
- `EditText editBitRate`  L22
- `int i = msg.what`  L26
- `TextView textBitRate`  L35

方法（5）：
- `void handleMessage(Message msg)`  L25 @Override
- `void onCreate(Bundle savedInstanceState)`  L39 @Override
- `void onClick(View v)`  L49 @Override
    - 体内字面量："è¯·è¾å¥æ°å­"
- `void run()`  L59 @Override
    - 体内字面量："è¾å¥æ°å­ä¸åæ³"
- `void run()`  L78 @Override
### `com.gku.actioncam.hisilicon.dv.setting.HiListPreference`
L14 · [class] public HiListPreference · extends `ListPreference` · `com/gku/actioncam/hisilicon/dv/setting/HiListPreference.java`

字段/常量（4）：
- `String TAG = "HiListPreference"`  L15
- `int mSelect`  L16
- `HiListPreference hiListPreference = HiListPreference.this`  L39
- `int length = entryValues.length`  L54

方法（5）：
- `public HiListPreference(Context context, AttributeSet attrs)`  L18
- `void onClick()`  L24 @Override
    - 体内字面量："454341324444555" · "onClick:  -----------------   1231312"
- `void onClick(DialogInterface dialog, int which)`  L30 @Override
- `void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)`  L37 @Override
- `void setValue(String value)`  L48 @Override
    - 体内字面量："454341324444555" · "setValue:  -------------------   "
### `com.gku.actioncam.hisilicon.dv.setting.PhoneSpaceActivity`
L14 · [class] public PhoneSpaceActivity · extends `BaseActivity` · `com/gku/actioncam/hisilicon/dv/setting/PhoneSpaceActivity.java`

字段/常量（6）：
- `TextView device_set_tv`  L15
- `ImageView ic_back`  L16
- `MyCircleProgress mcp_space`  L17
- `TextView mode_set_tv`  L18
- `TextView tv_space`  L19
- `double d = j - j2`  L40

方法（4）：
- `void onCreate(Bundle savedInstanceState)`  L22 @Override
- `void onClick(View view)`  L32 @Override
- `long getphonesize()`  L45
- `long getphoneallsize()`  L50
### `com.gku.actioncam.hisilicon.dv.setting.PrivacyAgreementActivity`
L15 · [class] public PrivacyAgreementActivity · extends `BaseXtuGoActivity` · `com/gku/actioncam/hisilicon/dv/setting/PrivacyAgreementActivity.java`

字段/常量（6）：
- `LinearLayout pa_activity_content`  L16
- `LinearLayout pa_back`  L17
- `LinearLayout pa_control`  L18
- `int type = 1`  L19
- `TextView welcome_pr_tip`  L20
- `String str`  L42

方法（4）：
- `void onCreate(Bundle savedInstanceState)`  L23 @Override
    - 体内字面量："type"
- `void onClick(View view)`  L30 @Override
- `void lambda$onCreate$0(View view)`  L37
- `void initView()`  L41
### `com.gku.actioncam.hisilicon.dv.setting.WifiChannelActivity`
L17 · [class] public WifiChannelActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/setting/WifiChannelActivity.java`

字段/常量（7）：
- `int MSG_GOT_WIFI_CHANNEL = 0`  L18
- `int MSG_SET_FAIL = 2`  L19
- `int MSG_SET_OK = 1`  L20
- `Button btnSetWifiChannel`  L21
- `EditText editWifiChannel`  L22
- `int i = msg.what`  L26
- `TextView textWifiChannel`  L35

方法（5）：
- `void handleMessage(Message msg)`  L25 @Override
- `void onCreate(Bundle savedInstanceState)`  L39 @Override
- `void onClick(View v)`  L49 @Override
    - 体内字面量："è¯·è¾å¥æ°å­"
- `void run()`  L59 @Override
    - 体内字面量："è¾å¥æ°å­ä¸åæ³"
- `void run()`  L78 @Override