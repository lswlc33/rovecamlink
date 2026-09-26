# idGoLive — 类与成员明细：com.icatchtek.baseutil.info

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 6 个文件 / 6 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.info.AppInfo`
L4 · [class] public AppInfo · `com/icatchtek/baseutil/info/AppInfo.java`

字段/常量（57）：
- `String ACCOUNT_SERVER_ADDRESS = "api.bpsc.tinyai.top"`  L5
- `String ACCOUNT_SERVER_ADDRESS_CN = "api.bpsc.tinyai.top"`  L6
- `String ACCOUNT_SERVER_ADDRESS_USA = "usa.boi.tinyai.top"`  L7
- `String ACCOUNT_SERVER_BASE_URL = "https://api.bpsc.tinyai.top:3026"`  L8
- `String ACCOUNT_SERVER_BASE_URL_CN = "https://api.bpsc.tinyai.top:3026"`  L9
- `int ACCOUNT_SERVER_BASE_URL_INDEX = 0`  L10
- `int ACCOUNT_SERVER_BASE_URL_INDEX_MAX = 255`  L11
- `String ACCOUNT_SERVER_BASE_URL_INDEX_PREFIX = "URL_"`  L12
- `String ACCOUNT_SERVER_BASE_URL_USA = "http://usa.boi.tinyai.top:3006"`  L13
- `String ACCOUNT_SERVER_DEFAULT_REGION = "ap-northeast-1"`  L14
- `String ACCOUNT_SERVER_REGION = "cn-northwest-1"`  L15
- `String ACCOUNT_SERVER_REGION_AP_EAST_1 = "ap-east-1"`  L16
- `String ACCOUNT_SERVER_REGION_AP_NORTHEAST_1 = "ap-northeast-1"`  L17
- `String ACCOUNT_SERVER_REGION_CN_NORTHWEST_1 = "cn-northwest-1"`  L18
- `String ACCOUNT_SERVER_REGION_CUSTOMIZATION_PREFIX = "customization-"`  L19
- `String ACCOUNT_SERVER_REGION_US_WEST_1 = "us-west-1"`  L20
- `String APP_LOG_DIRECTORY_PATH = "/BpSCam_APP_Log/"`  L21
- `String APP_LOG_TAG = "BpSCamAPP_"`  L22
- `String APP_VERSION = "<binary/metadata>"`  L23
- `String CUSTOMER_PRIVACY_POLICY_VERSION = "1.0"`  L24
- `int DEFAULT_PUSH_TYPE = 2`  L25
- `String DOWNLOAD_PATH = "/DCIM/BpSCam/"`  L26
- `String FILE_FILTER_FILE_NAME = "file_filter.dat"`  L27
- `String ICATCH_PUSH_APP_KEY = "XXXXXXX1C5262CC1"`  L28
- `String ICATCH_PUSH_APP_SECRET = "784DDA534A18B1AE76"`  L29
- `String KVS_WEBRTC_REGION = "ap-northeast-1"`  L30
- `String KVS_WEBRTC_REGION_HK = "ap-east-1"`  L31
- `String KVS_WEBRTC_REGION_TOKYO = "ap-northeast-1"`  L32
- `String NOT_AVAILABLE_DEVICE_NAME = "NA"`  L33
- `String PROPERTY_CFG_DIRECTORY_PATH = "/BpSCamResoure/"`  L34
- `String PROPERTY_CFG_FILE_NAME = "netconfig.properties"`  L35
- `int PUSH_SERVER = 1`  L36
- `String PUSH_SERVER_ADDRESS = "push.smarthome.icatchtek.com"`  L37
- `boolean PUSH_TO_TALK = false`  L38
- `String PV_THUMB_PATH = "/PVThumb/"`  L39
- `String SDK_LOG_DIRECTORY_PATH = "/BpSCam_SDK_Log/"`  L40
- `String SDK_VERSION = "V3.1.10"`  L41
- `String SETUP_DEFAULT_DEVICE_NAME_PREFIX = "BpSCam_"`  L42
- `int SHARE_CAMERA_DEADLINE_DAYS = 7`  L43
- `String SHARE_QR_CODE_PATH = "/ShareQrCode/"`  L44
- `String SIMPLELINK_LOG_DIRECTORY_PATH = "/BpSCam_SimpleLink_Log/"`  L45
- `String STREAM_OUTPUT_DIRECTORY_PATH = "/BpSCamResoure/Raw/"`  L46
- `boolean autoConfigPushType = false`  L47
- `boolean enableMsgCenter = true`  L48
- `boolean enableTalk = true`  L49
- `boolean isMiPushReady = false`  L50
- `boolean isSupportAutoReconnection = false`  L51
- `boolean isSupportBroadcast = false`  L52
- `boolean isSupportSetting = false`  L53
- `String pushToken = "<binary/metadata>"`  L54
- `int pushType = 2`  L55
- `boolean saveAudio = false`  L56
- `boolean saveSDKLog = false`  L57
- `boolean saveVideo = false`  L58
- `boolean showBatteryIcon = true`  L59
- `String uniqueDeviceId = "<binary/metadata>"`  L60
- `boolean useUSAServer = false`  L61
### `com.icatchtek.baseutil.info.LocationInfo`
L6 · [class] public LocationInfo · implements `Serializable` · `com/icatchtek/baseutil/info/LocationInfo.java`

字段/常量（6）：
- `int confidence`  L7
- `int height`  L8
- `int left`  L9
- `int rotation`  L10
- `int top`  L11
- `int width`  L12
### `com.icatchtek.baseutil.info.PushMessage`
L7 · [class] public PushMessage · implements `Serializable` · `com/icatchtek/baseutil/info/PushMessage.java`

字段/常量（20）：
- `int STRATEGY_ATTACHMENT_TYPE_JPG = 2`  L8
- `int STRATEGY_ATTACHMENT_TYPE_JPG_TS = 3`  L9
- `int STRATEGY_ATTACHMENT_TYPE_NON = 0`  L10
- `int STRATEGY_ATTACHMENT_TYPE_TS = 1`  L11
- `String attachment`  L12
- `String devID`  L13
- `String deviceId`  L14
- `int errCode`  L15
- `List<String> faceId`  L16
- `List<LocationInfo> faces`  L17
- `List<LocationInfo> locationInfos`  L18
- `int msgID`  L19
- `String msgParam`  L20
- `int msgType`  L21
- `String name`  L22
- `int result`  L23
- `String time`  L24
- `String deviceName = null`  L25
- `long timeInSecs = 0`  L26
- `int strategy = -1`  L27

方法（1）：
- `String toString()`  L29
    - 体内字面量："PushMessage{msgID=" · ", devID='" · "', time='" · "', msgType=" · ", msgParam='" · "', devName='" · "', result=" · ", name='" · "', attachment='" · "', deviceId='" · "', errCode=" · ", timeInSecs=" · "}"
### `com.icatchtek.baseutil.info.PushServer`
L4 · [class] public PushServer · `com/icatchtek/baseutil/info/PushServer.java`

字段/常量（7）：
- `int GCM = 4`  L5
- `int ICATCH = 1`  L6
- `int JG = 3`  L7
- `int MI = 6`  L8
- `int TUTK = 2`  L9
- `int UNKNOWN = 0`  L10
- `int XG = 5`  L11

方法（1）：
- `String getPushServerStr(int i)`  L13
    - 体内字面量："unkown" · "ICATCH" · "TUTK" · "JG" · "GCM" · "XG" · "MI" · "UNKNOWN"
### `com.icatchtek.baseutil.info.PushType`
L4 · [class] public PushType · `com/icatchtek/baseutil/info/PushType.java`

字段/常量（5）：
- `int FCM_PUSH = 1`  L5
- `int JGUANG_PUSH = 2`  L6
- `int MI_PUSH = 3`  L7
- `int UNKNOWN = 0`  L8
- `int XG_PUSH = 4`  L9

方法（1）：
- `String getPushTypeStr(int i)`  L11
    - 体内字面量："unkown" · "gcm" · "jpush" · "unkown" · "xg" · "mipush"
### `com.icatchtek.baseutil.info.SystemInfo`
L32 · [class] public SystemInfo · `com/icatchtek/baseutil/info/SystemInfo.java`

字段/常量（10）：
- `String TAG = "SystemInfo"`  L33
- `SystemInfo instance`  L34
- `long j = memoryInfo.availMem / 1024`  L125
- `InetAddress inetAddress`  L138
- `SocketException e`  L139
- `Enumeration<NetworkInterface> networkInterfaces`  L246
- `NetworkInterface networkInterfaceNextElement = null`  L248
- `String strReplace = null`  L255
- `int i = AppInfo.pushType`  L277
- `View currentFocus`  L312

方法（30）：
- `String bytesToString(byte[] bArr)`  L36
    - 体内字面量："%02X:"
- `String formatSize(Context context, long j)`  L50
- `String getAndroidId(Context context)`  L54
    - 体内字面量："appLocalInfo" · "AndroidId" · "11 getAndroidId androidId=" · "android_id" · "appLocalInfo" · "AndroidId" · "22 getAndroidId androidId="
- `int getBottomStatusHeight(Context context)`  L66
    - 体内字面量："1111" · "getBottomStatusHeight ="
- `int getBottomStatusWidth(Context context)`  L72
    - 体内字面量："1111" · "getBottomStatusWidth ="
- `String getDeviceId(Context context)`  L78
    - 体内字面量："phone" · "getDeviceId deviceId="
- `String getDeviceUniqueLabel(Context context)`  L84
- `int getDpi(Context context)`  L88
    - 体内字面量："window" · "android.view.Display" · "getRealMetrics"
- `String[] getExtSDCardPath(Context context)`  L100
    - 体内字面量："storage" · "getVolumePaths"
- `long getFreeMemory(Context context)`  L121
    - 体内字面量："activity"
- `SystemInfo getInstance()`  L130
- `InetAddress getLocalInetAddress()`  L137
- `String getLocalIpAddress()`  L174
- `String getLocalMacAddress(Context context)`  L193
    - 体内字面量："appLocalInfo" · "wifiMac" · ":" · ":" · "getLocalMacAddress = "
- `String getMacAddressByIp()`  L213
    - 体内字面量："getMacAddressByIp" · ":"
- `String getMacWithNoMaoHao(Context context)`  L238
    - 体内字面量："start getMacWithNoMaoHao" · "wifi" · ":" · "current Mac="
- `String getMachineHardwareAddress()`  L245
- `DisplayMetrics getMetrics(Context context)`  L271
- `int getPushType(Context context)`  L275
    - 体内字面量："start getPushType autoConfigPushType="
- `long getSDFreeSize()`  L282
    - 体内字面量："getSDFreeSize="
- `int getScreenHeight(Context context)`  L291
    - 体内字面量："window"
- `int getScreenWidth(Context context)`  L298
    - 体内字面量："window"
- `int getWindowVisibleCountMax(Context context, int i)`  L305
    - 体内字面量："end getWindowVisibleCountMax visibleCountMax="
- `void hideInputMethod(Activity activity)`  L311
- `boolean isAppSentToBackground(Context context)`  L320
    - 体内字面量："activity" · "1111" · "appProcess.processName ="
- `boolean isBackground(Context context)`  L332
    - 体内字面量："activity" · "æ­¤appimportace =" · ",context.getClass().getName()=" · "å¤äºåå°" · "å¤äºåå°"
- `boolean isGooglePlayServicesAvailable(Context context)`  L347
    - 体内字面量："isGooglePlayServicesAvailable:"
- `boolean isLock(Context context)`  L353
    - 体内字面量："keyguard" · "isLock:"
- `boolean isScreenOn(Context context)`  L359
    - 体内字面量："power" · "isScreenOn:"
- `void wakeUpAndUnlock(Context context)`  L365
    - 体内字面量："power" · "bright" · "keyguard" · "unLock"