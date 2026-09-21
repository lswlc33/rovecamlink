# idGoLive — 类与成员明细：com.tinyai.libmediacomponent.utils

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 4 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tinyai.libmediacomponent.utils.AppInfo`
L4 · [class] public AppInfo · `com/tinyai/libmediacomponent/utils/AppInfo.java`

字段/常量（54）：
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
- `String DOWNLOAD_PATH = "/DCIM/BpSCam/"`  L25
- `String FILE_FILTER_FILE_NAME = "file_filter.dat"`  L26
- `String ICATCH_PUSH_APP_KEY = "XXXXXXX1C5262CC1"`  L27
- `String ICATCH_PUSH_APP_SECRET = "784DDA534A18B1AE76"`  L28
- `String KVS_WEBRTC_REGION = "ap-northeast-1"`  L29
- `String KVS_WEBRTC_REGION_HK = "ap-east-1"`  L30
- `String KVS_WEBRTC_REGION_TOKYO = "ap-northeast-1"`  L31
- `String NOT_AVAILABLE_DEVICE_NAME = "NA"`  L32
- `String PROPERTY_CFG_DIRECTORY_PATH = "/BpSCamResoure/"`  L33
- `String PROPERTY_CFG_FILE_NAME = "netconfig.properties"`  L34
- `String PUSH_SERVER_ADDRESS = "push.smarthome.icatchtek.com"`  L35
- `boolean PUSH_TO_TALK = false`  L36
- `String PV_THUMB_PATH = "/PVThumb/"`  L37
- `String SDK_LOG_DIRECTORY_PATH = "/BpSCam_SDK_Log/"`  L38
- `String SDK_VERSION = "V3.1.10"`  L39
- `String SETUP_DEFAULT_DEVICE_NAME_PREFIX = "BpSCam_"`  L40
- `int SHARE_CAMERA_DEADLINE_DAYS = 7`  L41
- `String SHARE_QR_CODE_PATH = "/ShareQrCode/"`  L42
- `String SIMPLELINK_LOG_DIRECTORY_PATH = "/BpSCam_SimpleLink_Log/"`  L43
- `String STREAM_OUTPUT_DIRECTORY_PATH = "/BpSCamResoure/Raw/"`  L44
- `boolean autoConfigPushType = false`  L45
- `boolean enableMsgCenter = true`  L46
- `boolean enableTalk = true`  L47
- `boolean isMiPushReady = false`  L48
- `boolean isSupportAutoReconnection = false`  L49
- `boolean isSupportBroadcast = false`  L50
- `boolean isSupportSetting = false`  L51
- `String pushToken = "<binary/metadata>"`  L52
- `boolean saveAudio = false`  L53
- `boolean saveSDKLog = false`  L54
- `boolean saveVideo = false`  L55
- `boolean showBatteryIcon = true`  L56
- `String uniqueDeviceId = "<binary/metadata>"`  L57
- `boolean useUSAServer = false`  L58
### `com.tinyai.libmediacomponent.utils.AudioFocusUtil`
L9 · [class] public AudioFocusUtil · `com/tinyai/libmediacomponent/utils/AudioFocusUtil.java`

字段/常量（6）：
- `String TAG = "AudioFocusUtil"`  L10
- `AudioFocusUtil audioFocusUtil`  L11
- `AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener`  L12
- `AudioManager mAudioManager`  L13
- `AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener`  L50
- `AudioManager audioManager = this.mAudioManager`  L51

方法（6）：
- `private AudioFocusUtil()`  L15
- `AudioFocusUtil getInstance()`  L18
    - 体内字面量："getInstance: "
- `int requestTheAudioFocus(Context context)`  L30
    - 体内字面量："audio"
- `void onAudioFocusChange(int i)`  L37 @Override
    - 体内字面量："onAudioFocusChange: LOSS..." · "onAudioFocusChange: GAIN..."
- `void releaseAudioFocus()`  L49
- `void requestAudioFocus(Context context)`  L59
    - 体内字面量："requestAudioFocus: AUDIOFOCUS_REQUEST_GRANTED" · "Please close other app playing audio"
### `com.tinyai.libmediacomponent.utils.ConvertTools`
L11 · [class] public ConvertTools · `com/tinyai/libmediacomponent/utils/ConvertTools.java`

字段/常量（14）：
- `double GB = 1.073741824E9d`  L12
- `double KB = 1024.0d`  L13
- `double MB = 1048576.0d`  L14
- `String TAG = "ConvertTools"`  L15
- `String timeFormatFromApp = "yyyy-MM-dd HH:mm:ss"`  L16
- `String timeFormatFromFw = "yyyyMMdd'T'HHmmss"`  L17
- `double d = j`  L21
- `Date date`  L32
- `Date date`  L46
- `int i2 = 16777215 & i`  L59
- `Date date`  L66
- `String str2 = strArrSplit[0] + "?W=" + strArrSplit[1] + "&H=" + strArrSplit[2] + "&BR=" + strArrSplit[3]`  L86
- `String str`  L108
- `String str`  L125

方法（10）：
- `String ByteConversionGBMBKB(long j)`  L19
    - 体内字面量："######0.0"
- `long getDateTime(String str)`  L31
- `String getDateTimeString(String str)`  L45
- `String getExposureCompensation(int i)`  L56
    - 体内字面量："start getExposureCompensation value=" · "EV -" · "EV "
- `String getTimeByfileDate(String str)`  L65
- `String millisecondsToMinuteOrHours(int i)`  L76
- `String resolutionConvert(String str)`  L80
    - 体内字面量："start resolution = " · "\\?|&" · "W=" · "H=" · "BR="
- `String secondsToHours(int i)`  L98
    - 体内字面量：":" · ":"
- `String secondsToMinute(int i)`  L107
- `String secondsToMinuteOrHours(int i)`  L124
### `com.tinyai.libmediacomponent.utils.log.MediaLog`
L19 · [class] public MediaLog · `com/tinyai/libmediacomponent/utils/log/MediaLog.java`

字段/常量（16）：
- `String TAG = "AppLog [Media]"`  L20
- `Context context = null`  L21
- `boolean enableLog = false`  L22
- `boolean hasConfiguration = false`  L23
- `long maxFileSize = 52428800`  L24
- `FileOutputStream out`  L25
- `String writeFile`  L26
- `File writeLogFile`  L27
- `FileOutputStream fileOutputStream = out`  L31
- `FileOutputStream fileOutputStream = out`  L77
- `FileOutputStream fileOutputStream = out`  L98
- `PackageInfo packageInfo`  L109
- `FileOutputStream fileOutputStream = out`  L144
- `File file`  L155
- `FileOutputStream fileOutputStream = out`  L190
- `FileOutputStream fileOutputStream = out`  L210

方法（10）：
- `void closeWriteStream()`  L29
    - 体内字面量："1111" · "closeWriteStream"
- `void createFile(String str, String str2)`  L41
    - 体内字面量："FileOper" · "start createFile" · "FileOper" · "directoryPath+fileName =" · "FileOper" · "file is not exists,need to create!" · "FileOper" · "FileNotFoundException" · "FileOper" · "IOException"
- `void d(String str, String str2)`  L66
    - 体内字面量：" [Debug] [" · "] [" · "]\n"
- `void e(String str, String str2)`  L87
    - 体内字面量：" [Error] [" · "] [" · "]\n"
- `void enableAppLog(Context context2)`  L108
- `String getSystemDate()`  L129
    - 体内字面量："yyyy-MM-dd HH:mm:ss:SSS"
- `void i(String str, String str2)`  L133
    - 体内字面量：" [Info ] [" · "] [" · "]\n"
- `void initConfiguration()`  L154
- `void tmpi(String str, String str2)`  L185
    - 体内字面量：" [Info ] [" · "] [" · "]\n"
- `void w(String str, String str2)`  L200
    - 体内字面量：" [Warn ] [" · "] [" · "]\n"