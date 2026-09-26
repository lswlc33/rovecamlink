# idGoLive — 类与成员明细：com.icatch.golive.data

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 48 个文件 / 50 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.data.AppInfo.AppInfo`
L13 · [class] public AppInfo · `com/icatch/golive/data/AppInfo/AppInfo.java`

字段/常量（46）：
- `String APP_LOG_DIRECTORY_PATH = "/idGoLive/MobileCam_APP_Log/"`  L14
- `String APP_PATH = "/idGoLive/"`  L15
- `String APP_VERSION = "V1.4.3"`  L16
- `String AUTO_DOWNLOAD_PATH = "/DCIM/idGoLive/photo/"`  L17
- `String DOWNLOAD_PATH = "/DCIM/idGoLive/"`  L18
- `String DOWNLOAD_PATH_PHOTO = "/DCIM/idGoLive/photo/"`  L19
- `String DOWNLOAD_PATH_VIDEO = "/DCIM/idGoLive/video/"`  L20
- `String EULA_VERSION = "1.3"`  L21
- `String FILE_GOOGLE_TOKEN = "file_googleToken.dat"`  L22
- `String FW_UPGRADE_FILENAME = "SPHOST.BRN"`  L23
- `String PROPERTY_CFG_DIRECTORY_PATH = "/idGoLive/Resoure/"`  L24
- `String PROPERTY_CFG_FILE_NAME = "netconfig.properties"`  L25
- `String SDK_LOG_DIRECTORY_PATH = "/idGoLive/MobileCam_SDK_Log/"`  L26
- `String SDK_VERSION = "V3.6.0.39"`  L27
- `String STREAM_OUTPUT_DIRECTORY_PATH = "/idGoLive/Resoure/Raw/"`  L28
- `String TAG = "AppInfo"`  L29
- `boolean autoDownloadAllow = false`  L30
- `float autoDownloadSizeLimit = 1.0f`  L31
- `BluetoothAppDevice curBtDevice = null`  L32
- `boolean disableAudio = false`  L33
- `boolean enableLive = false`  L34
- `ICatchBluetoothClient iCatchBluetoothClient = null`  L35
- `boolean isDownloading = false`  L36
- `boolean isSdCardExist = true`  L37
- `boolean isSupportAutoReconnection = false`  L38
- `boolean isSupportBroadcast = false`  L39
- `boolean isSupportSetting = false`  L40
- `boolean saveSDKLog = false`  L41
- `PhotoWallLayoutType photoWallLayoutType = PhotoWallLayoutType.PREVIEW_TYPE_LIST`  L42
- `int currentViewpagerPosition = 0`  L43
- `int curVisibleItem = 0`  L44
- `boolean enableSoftwareDecoder = false`  L45
- `boolean isBLE = false`  L46
- `boolean isReleaseBTClient = true`  L47
- `int videoCacheNum = 0`  L48
- `int curFps = 30`  L49
- `double unsteadyTime = 0.1d`  L50
- `String inputIp = "192.168.1.1"`  L51
- `String default_pwd = "1234567890"`  L52
- `boolean isNeedReconnect = true`  L53
- `boolean enableDumpVideo = false`  L54
- `MyOrientoinListener.ScreenOrientation curScreenOrientation = MyOrientoinListener.ScreenOrientation.SCREEN_ORIENTATION_PORTRAIT`  L55
- `boolean enableRender = false`  L56
- `int connectionCheckInterval = 4`  L57
- `int connectionCheckTimes = 4`  L58
- `boolean localPbUseSdkRender = false`  L59

方法（1）：
- `boolean isAppSentToBackground(Context context)`  L61
    - 体内字面量："activity" · "isAppSentToBackground: true" · "isAppSentToBackground: false" · "isAppSentToBackground: false"
### `com.icatch.golive.data.AppInfo.AppSharedPreferences`
L7 · [class] public AppSharedPreferences · `com/icatch/golive/data/AppInfo/AppSharedPreferences.java`

字段/常量（4）：
- `String FILE_NAME = "storeInfo"`  L8
- `String OBJECT_NAME_DEFAULT_PWD = "default_pwd"`  L9
- `String OBJECT_NAME_INPUT_IP = "inputIp"`  L10
- `String OBJECT_NAME_LIVE_URL = "liveUrl"`  L11

方法（2）：
- `String readDataByName(Context context, String str, String str2)`  L13
- `void writeDataByName(Context context, String str, String str2)`  L17
### `com.icatch.golive.data.AppInfo.CfgProperty`
L11 · [class] public CfgProperty · `com/icatch/golive/data/AppInfo/CfgProperty.java`

字段/常量（2）：
- `String fileName`  L13
- `FileInputStream fileInputStream = null`  L34

方法（3）：
- `public CfgProperty(String str)`  L15
- `String getProperty(String str)`  L19
- `Map<String, String> getProperty(List<String> list)`  L31
### `com.icatch.golive.data.AppInfo.ConfigureInfo`
L17 · [class] public ConfigureInfo · `com/icatch/golive/data/AppInfo/ConfigureInfo.java`

字段/常量（27）：
- `String TAG = "ConfigureInfo"`  L18
- `ConfigureInfo configureInfo`  L19
- `String[] cfgTopic = {"AppVersion=V1.4.3", "SupportAutoReconnection=false", "SaveStreamVideo=false", "SaveStreamAudio=false", "broadcast=false", "SupportSetting=false", "SaveAppLog=true", "SaveSDKLog=false", "disconnectRetry=10", "enableSoftwareDecoder=false", "disableAudio=false", "enableLive=false", "enableSdkRender=true", "enableInterExtHeadCheck=true", "connectionCheckInterval=4", "connectionCheckTimes=4", "localPbUseSdkRender=false"}`  L20
- `String property`  L77
- `String str`  L78
- `String property2`  L79
- `String property3`  L80
- `String property4`  L81
- `String property5`  L82
- `String property6`  L83
- `String property7`  L84
- `String property8`  L85
- `String property9`  L86
- `String property10`  L87
- `String property11`  L88
- `String property12`  L89
- `String str2`  L90
- `String str3`  L91
- `String property13`  L92
- `String str4`  L93
- `String str5`  L94
- `String str6`  L95
- `String property14`  L96
- `Throwable th`  L97
- `FileOutputStream fileOutputStream`  L98
- `FileOutputStream fileOutputStream2`  L99
- `String str8 = "<binary/metadata>"`  L105

方法（4）：
- `private ConfigureInfo()`  L22
- `ConfigureInfo getInstance()`  L25
- `void writeCfgInfo(String str, String str2)`  L32
    - 体内字面量："end writeCfgInfo :IOException "
- `void initCfgInfo(Context context)`  L76
### `com.icatch.golive.data.AppInfo.UserMacPermition`
L6 · [class] public UserMacPermition · `com/icatch/golive/data/AppInfo/UserMacPermition.java`

字段/常量（2）：
- `HashMap<String, MacPermit> macPermitList`  L7
- `UserMacPermition userMacPermition`  L8

方法（4）：
- `public UserMacPermition()`  L20
- `UserMacPermition getInstance()`  L24
- `void initUserMacPermition()`  L31
    - 体内字面量："00:08:22:a8:f7:fb" · "Asus-me173x" · "stanford" · "84:7a:88:44:71:a4" · "New HTC One" · "Kent" · "ac:f7:f3:cf:24:09" · "MI2S" · "Chris" · "b0:ec:71:70:d5:c6" · "Tab 7.7" · "Chris" · "30:85:a9:da:3d:03" · "Nexus 7" · "Chris" · "38:aa:3c:3f:15:c4" · "Samsung S3" · "Ethan" · "c4:43:8f:5c:26:1c" · "LG Gpro" · "Ethan" · "64:b4:73:45:c1:24" · "çº¢ç±³note" · "SZ  QA" · "cc:3a:61:7f:be:1e" · "Samsung S4" · "SZ  QA" · "5c:ff:35:8a:fd:62" · "Nexus5" · "CD" · "00:7c:05:02:f9:ae" · "å°çµP88" · "CD" · "cc:fa:00:e9:81:c6" · "åç¡å¹³æ¿" · "CD" · "9c:c1:72:36:fd:30" · "åä¸ºè£è3X" · "CD" · "a0:93:47:0b:62:09" · "OPPO Finder7" · "SZ yong.sun" · "18:87:96:8b:e9:a0" · "HTC One X" · "TW QA" · "30:a8:db:90:16:62" · "Sony Z2" · "giselle" · "f8:a9:d0:3e:b2:d8" · "xx" · "giselle" · "68:df:dd:14:da:3c" · "çº¢ç±³" · "Jimmy" · "b4:ce:f6:9d:c9:3f" · "Nexus 9" · "TW QA" · "10:bf:48:d0:c9:bf" · "ASUS ME301T" · "TW QA" · "78:24:af:22:a6:41" · "ASUS Zenfone4" · "Andy.Li" · "90:b6:86:73:92:46" · "Samsung S6" · "Stanford" · "88:32:9b:e4:8a:df" · "Samsung Note7108" · "Yanhu" · "80:01:84:11:b0:05" · "***" · "weber" · "f8:a9:d0:3e:b2:d8" · "LG" · "TW QA" · "48:5a:3f:23:c1:0c" · "Samsung Note3" · "TW QA" · "60:21:c0:31:c6:b0" · "Samsung S3" · "TW QA" · "08:62:66:15:7f:42" · "ASUS Zenfone 6" · "TW QA" · "80:01:84:13:63:7b" · "***" · "kent" · "cc:a2:23:fb:23:78" · "Huawei" · "Ruanxuan" · "90:e7:c4:c1:08:46" · "HTC Desire 820" · "TW QA" · "c8:a8:23:bf:fe:5f" · "Samsung E7" · "Jimmy.chiu" · "24:21:ab:81:68:7d" · "xxx" · "aries" · "00:94:08:00:91:d0" · "Vido MINI S" · "b.jiang" · "90:e7:c4:16:37:a3" · "HTC 826" · "Chris Wang" · "34:80:b3:a2:fd:9f" · "Mi4" · "zhouyongqiang" · "04:02:1f:1f:3e:f7" · "huawei" · "tiger" · "68:3e:34:69:c0:21" · "Meizu MX5" · "b.jiang" · "02:00:00:00:00:00" · "Android6.0" · "b.jiang"
- `boolean isAllowedMac(String str)`  L77
### `com.icatch.golive.data.AppInfo.UserMacPermition$MacPermit`
L10 · [class] public MacPermit · `com/icatch/golive/data/AppInfo/UserMacPermition.java`

字段/常量（2）：
- `String device`  L11
- `String person`  L12

方法（1）：
- `public MacPermit(String str, String str2)`  L14
### `com.icatch.golive.data.CustomException.DataFormatException`
L4 · [class] public DataFormatException · extends `Exception` · `com/icatch/golive/data/CustomException/DataFormatException.java`

方法（2）：
- `public DataFormatException()`  L5
- `public DataFormatException(String str, String str2)`  L8
### `com.icatch.golive.data.CustomException.NullPointerException`
L4 · [class] public NullPointerException · extends `Exception` · `com/icatch/golive/data/CustomException/NullPointerException.java`

字段/常量（1）：
- `String exceptionType`  L5

方法（2）：
- `public NullPointerException()`  L7
    - 体内字面量："NullPointerException!"
- `public NullPointerException(String str, String str2, String str3)`  L11
    - 体内字面量："NullPointerException!"
### `com.icatch.golive.data.entity.BluetoothAppDevice`
L4 · [class] public BluetoothAppDevice · `com/icatch/golive/data/entity/BluetoothAppDevice.java`

字段/常量（4）：
- `String bluetoothAddr`  L5
- `boolean bluetoothConnect`  L6
- `boolean bluetoothExist`  L7
- `String bluetoothName`  L8

方法（10）：
- `public BluetoothAppDevice(String str, String str2, boolean z)`  L10
- `public BluetoothAppDevice(String str, String str2, boolean z, boolean z2)`  L17
- `String getBluetoothAddr()`  L24
- `boolean getBluetoothConnect()`  L28
- `boolean getBluetoothExist()`  L32
- `String getBluetoothName()`  L36
- `void setBluetoothAddr(String str)`  L40
- `void setBluetoothConnect(boolean z)`  L44
- `void setBluetoothExist(boolean z)`  L48
- `void setBluetoothName(String str)`  L52
### `com.icatch.golive.data.entity.CameraSlot`
L7 · [class] public CameraSlot · `com/icatch/golive/data/entity/CameraSlot.java`

字段/常量（8）：
- `int addType`  L8
- `String cameraName`  L9
- `byte[] cameraPhoto`  L10
- `int cameraType`  L11
- `boolean isOccupied`  L12
- `boolean isReady`  L13
- `int slotPosition`  L14
- `String wifiPassword`  L15

方法（2）：
- `public CameraSlot(int i, boolean z, String str, int i2, byte[] bArr, boolean z2, int i3, String str2)`  L17
- `public CameraSlot(int i, boolean z, String str, byte[] bArr)`  L28
### `com.icatch.golive.data.entity.DownloadInfo`
L6 · [class] public DownloadInfo · `com/icatch/golive/data/entity/DownloadInfo.java`

字段/常量（5）：
- `long curFileLength`  L7
- `boolean done`  L8
- `ICatchFile file`  L9
- `long fileSize`  L10
- `int progress`  L11

方法（3）：
- `public DownloadInfo(ICatchFile iCatchFile, long j, long j2, int i, boolean z)`  L13
- `boolean isDone()`  L21
- `void setDone(boolean z)`  L25
### `com.icatch.golive.data.entity.FilterItem`
L4 · [class] public FilterItem · `com/icatch/golive/data/entity/FilterItem.java`

字段/常量（2）：
- `int filterValue`  L5
- `String value`  L6

方法（5）：
- `public FilterItem(String str, int i)`  L8
- `int getFilterValue()`  L13
- `String getValue()`  L17
- `void setFilterValue(int i)`  L21
- `void setValue(String str)`  L25
### `com.icatch.golive.data.entity.GoogleToken`
L6 · [class] public GoogleToken · implements `Serializable` · `com/icatch/golive/data/entity/GoogleToken.java`

字段/常量（2）：
- `String accessToken`  L7
- `String refreshToken`  L8

方法（5）：
- `public GoogleToken(String str, String str2)`  L10
- `String getAccessToken()`  L15
- `String getRefreshToken()`  L19
- `void setCurrentAccessToken(String str)`  L23
- `void setCurrentRefreshToken(String str)`  L27
### `com.icatch.golive.data.entity.ItemInfo`
L4 · [class] public ItemInfo · `com/icatch/golive/data/entity/ItemInfo.java`

字段/常量（4）：
- `int iconID`  L5
- `String uiStringInPreview`  L6
- `int uiStringInSetting`  L7
- `String uiStringInSettingString`  L8

方法（2）：
- `public ItemInfo(int i, String str, int i2)`  L10
- `public ItemInfo(String str, String str2, int i)`  L17
### `com.icatch.golive.data.entity.LimitQueue`
L9 · [class] public LimitQueue · implements `Queue<E>` · `com/icatch/golive/data/entity/LimitQueue.java`

字段/常量（1）：
- `int limit`  L10

方法（22）：
- `public LimitQueue(int i)`  L13
- `boolean add(E e)`  L18 @Override
- `boolean addAll(Collection<? extends E> collection)`  L23 @Override
- `void clear()`  L28 @Override
- `boolean contains(Object obj)`  L33 @Override
- `boolean containsAll(Collection<?> collection)`  L38 @Override
- `E element()`  L43 @Override
- `int getLimit()`  L47
- `Queue<E> getQueue()`  L51
- `boolean isEmpty()`  L56 @Override
- `Iterator<E> iterator()`  L61 @Override
- `boolean offer(E e)`  L66 @Override
- `E peek()`  L74 @Override
- `E poll()`  L79 @Override
- `E remove()`  L84 @Override
- `boolean remove(Object obj)`  L89 @Override
- `boolean removeAll(Collection<?> collection)`  L94 @Override
- `E removeLast()`  L98
- `boolean retainAll(Collection<?> collection)`  L103 @Override
- `int size()`  L108 @Override
- `Object[] toArray()`  L113 @Override
- `T[] toArray(T[] tArr)`  L118 @Override
### `com.icatch.golive.data.entity.LocalPbItemInfo`
L12 · [class] public LocalPbItemInfo · `com/icatch/golive/data/entity/LocalPbItemInfo.java`

字段/常量（6）：
- `File file`  L13
- `boolean isItemChecked`  L14
- `boolean isPanorama`  L15
- `int section`  L16
- `String line`  L39
- `String strSubstring = null`  L40

方法（12）：
- `public LocalPbItemInfo(File file)`  L18
- `public LocalPbItemInfo(File file, int i)`  L24
- `public LocalPbItemInfo(File file, int i, boolean z)`  L31
- `void getCreateTime()`  L38
- `String getFileDate()`  L56
    - 体内字面量："yyyy-MM-dd"
- `String getFileDateMMSS()`  L60
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
- `String getFileName()`  L64
- `String getFilePath()`  L68
- `String getFileSize()`  L72
- `boolean isPanorama()`  L76
- `void setPanorama(boolean z)`  L80
- `void setSection(int i)`  L84
### `com.icatch.golive.data.entity.MultiPbFileResult`
L7 · [class] public MultiPbFileResult · `com/icatch/golive/data/entity/MultiPbFileResult.java`

字段/常量（4）：
- `List<MultiPbItemInfo> fileList`  L8
- `boolean isMore`  L9
- `ICatchFile lastFile`  L10
- `int lastIndex`  L11

方法（8）：
- `List<MultiPbItemInfo> getFileList()`  L13
- `ICatchFile getLastFile()`  L17
- `int getLastIndex()`  L21
- `boolean isMore()`  L25
- `void setFileList(List<MultiPbItemInfo> list)`  L29
- `void setLastFile(ICatchFile iCatchFile)`  L33
- `void setLastIndex(int i)`  L37
- `void setMore(boolean z)`  L41
### `com.icatch.golive.data.entity.MultiPbItemInfo`
L6 · [class] public MultiPbItemInfo · `com/icatch/golive/data/entity/MultiPbItemInfo.java`

字段/常量（9）：
- `String TAG = "MultiPbItemInfo"`  L7
- `String fileDate`  L8
- `String fileDuration`  L9
- `String fileSize`  L10
- `String fileTime`  L11
- `ICatchFile iCatchFile`  L12
- `boolean isItemChecked`  L13
- `boolean isPanorama`  L14
- `int section`  L15

方法（15）：
- `public MultiPbItemInfo(ICatchFile iCatchFile)`  L17
- `public MultiPbItemInfo(ICatchFile iCatchFile, int i)`  L23
- `public MultiPbItemInfo(ICatchFile iCatchFile, int i, boolean z, String str, String str2, String str3, String str4)`  L30
- `String getFileDate()`  L41
- `String getFileDateMMSS()`  L45
- `String getFileDuration()`  L49
- `int getFileHandle()`  L53
- `String getFileName()`  L57
- `String getFilePath()`  L61
- `String getFileSize()`  L65
- `long getFileSizeInteger()`  L69
- `boolean isPanorama()`  L73
- `void setPanorama(boolean z)`  L77
- `void setSection(int i)`  L81
- `String toString()`  L85
    - 体内字面量："{\nfileSize = " · "\nfileDate = " · "\nfileTime = " · "\nfileDuration = " · "\niCatchFile.getFilePath = " · "\niCatchFile.getFileName = " · "\niCatchFile.getFileType = " · "\n};"
### `com.icatch.golive.data.entity.PropertyTypeInteger`
L20 · [class] public PropertyTypeInteger · `com/icatch/golive/data/entity/PropertyTypeInteger.java`

字段/常量（18）：
- `String TAG = "PropertyTypeInteger"`  L21
- `CameraProperties cameraProperties`  L22
- `Context context`  L23
- `HashMap<Integer, ItemInfo> hashMap`  L24
- `int propertyId`  L25
- `Resources res`  L26
- `List<Integer> valueListInt`  L27
- `String[] valueListString`  L28
- `ItemInfo itemInfo`  L55
- `HashMap<Integer, ItemInfo> map = this.hashMap`  L56
- `int i = this.propertyId`  L76
- `int i = this.propertyId`  L108
- `HashMap<Integer, ItemInfo> map = this.hashMap`  L122
- `boolean z = true`  L199
- `boolean whiteBalance`  L264
- `int i2 = this.propertyId`  L265
- `boolean whiteBalance`  L289
- `int i2 = this.propertyId`  L290

方法（12）：
- `public PropertyTypeInteger(CameraProperties cameraProperties, int i, Context context)`  L30
- `public PropertyTypeInteger(CameraProperties cameraProperties, HashMap<Integer, ItemInfo> map, int i, Context context)`  L37
- `int getCurrentIcon()`  L45
    - 体内字面量："itemInfo="
- `String getCurrentUiStringInPreview()`  L54
- `String getCurrentUiStringInSetting()`  L63
- `String getCurrentUiStringInSetting(int i)`  L71
- `int getCurrentValue()`  L75
- `String[] getValueList()`  L99
- `void initItem()`  L103
- `Boolean needDisplayByMode(int i)`  L198
- `Boolean setValue(int i)`  L263
- `Boolean setValueByPosition(int i)`  L288
### `com.icatch.golive.data.entity.PropertyTypeString`
L12 · [class] public PropertyTypeString · `com/icatch/golive/data/entity/PropertyTypeString.java`

字段/常量（13）：
- `CameraProperties cameraProperties`  L13
- `HashMap<String, ItemInfo> hashMap`  L14
- `int propertyId`  L15
- `String[] valueArrayString`  L16
- `List<String> valueListString`  L17
- `List<String> valueListStringUI`  L18
- `ItemInfo itemInfo`  L27
- `HashMap<String, ItemInfo> map = this.hashMap`  L28
- `ItemInfo itemInfo`  L33
- `HashMap<String, ItemInfo> map = this.hashMap`  L34
- `int i = 0`  L71
- `int i2 = this.propertyId`  L90
- `boolean z = true`  L91

方法（12）：
- `public PropertyTypeString(CameraProperties cameraProperties, int i, Context context)`  L20
- `String getCurrentUiStringInPreview()`  L26
- `String getCurrentUiStringInSetting()`  L32
- `String getCurrentUiStringInSetting(int i)`  L38
- `String getCurrentValue()`  L42
- `String[] getValueArrayString()`  L46
- `List<String> getValueList()`  L50
- `List<String> getValueListUI()`  L54
- `void initItem()`  L58
- `Boolean needDisplayByMode(int i)`  L89
- `Boolean setValue(String str)`  L98
- `boolean setValueByPosition(int i)`  L102
### `com.icatch.golive.data.entity.SearchedCameraInfo`
L4 · [class] public SearchedCameraInfo · `com/icatch/golive/data/entity/SearchedCameraInfo.java`

字段/常量（4）：
- `String cameraIp`  L5
- `int cameraMode`  L6
- `String cameraName`  L7
- `String uid`  L8

方法（1）：
- `public SearchedCameraInfo(String str, String str2, int i, String str3)`  L10
### `com.icatch.golive.data.entity.SelectedCameraInfo`
L4 · [class] public SelectedCameraInfo · `com/icatch/golive/data/entity/SelectedCameraInfo.java`

字段/常量（5）：
- `String cameraIp`  L5
- `int cameraMode`  L6
- `String cameraName`  L7
- `String password`  L8
- `String uid`  L9

方法（1）：
- `public SelectedCameraInfo(String str, String str2, int i, String str3)`  L11
### `com.icatch.golive.data.entity.SettingMenu`
L4 · [class] public SettingMenu · `com/icatch/golive/data/entity/SettingMenu.java`

字段/常量（2）：
- `int name`  L5
- `String value`  L6

方法（3）：
- `public SettingMenu(int i, String str)`  L8
- `int getName()`  L13
- `String getValue()`  L17
### `com.icatch.golive.data.entity.StreamInfo`
L4 · [class] public StreamInfo · `com/icatch/golive/data/entity/StreamInfo.java`

字段/常量（5）：
- `int bitrate`  L5
- `int fps`  L6
- `int height`  L7
- `String mediaCodecType`  L8
- `int width`  L9

方法（2）：
- `public StreamInfo()`  L11
- `public StreamInfo(String str, int i, int i2, int i3, int i4)`  L14
### `com.icatch.golive.data.GlobalApp.ExitApp`
L11 · [class] public ExitApp · `com/icatch/golive/data/GlobalApp/ExitApp.java`

字段/常量（4）：
- `String TAG = "ExitApp"`  L12
- `ExitApp instance`  L13
- `LinkedList<Activity> linkedList = this.activityList`  L34
- `LinkedList<Activity> linkedList = this.activityList`  L57

方法（5）：
- `ExitApp getInstance()`  L16
- `void addActivity(Activity activity)`  L23
    - 体内字面量："addActivity activity=" · "addActivity activityList size="
- `void exit()`  L32
    - 体内字面量："start exit activity activityList size="
- `void finishAllActivity()`  L51
    - 体内字面量："start finsh activity"
- `void removeActivity(Activity activity)`  L68
    - 体内字面量："removeActivity activity=" · "removeActivity activityList size="
### `com.icatch.golive.data.GlobalApp.GlobalInfo`
L17 · [class] public GlobalInfo · `com/icatch/golive/data/GlobalApp/GlobalInfo.java`

字段/常量（12）：
- `String TAG = "GlobalInfo"`  L18
- `GlobalInfo instance`  L19
- `Activity activity`  L20
- `int i = message.what`  L24
- `ScreenListener listener`  L47
- `List<FileItemInfo> localPhotoList`  L48
- `List<FileItemInfo> localVideoList`  L49
- `OnEventListener onEventListener`  L50
- `SDKEvent sdkEvent`  L51
- `WifiCheck wifiCheck`  L52
- `SDKEvent sDKEvent = this.sdkEvent`  L73
- `ScreenListener screenListener = this.listener`  L84

方法（17）：
- `void handleMessage(Message message)`  L23 @Override
- `GlobalInfo getInstance()`  L58
- `void addEventListener(int i)`  L65
- `void delEventListener(int i)`  L72
- `void delete()`  L79
- `void endSceenListener()`  L83
- `Context getAppContext()`  L90
- `Activity getCurrentApp()`  L94
- `List<FileItemInfo> getLocalPhotoList()`  L98
- `void setCurrentApp(Activity activity)`  L102
- `void setLocalPhotoList(List<FileItemInfo> list)`  L106
- `void setLocalVideoList(List<FileItemInfo> list)`  L110
- `void setOnEventListener(OnEventListener onEventListener)`  L114
- `void startScreenListener()`  L118
- `void onScreenOff()`  L123 @Override
    - 体内字面量："onScreenOff,need to close app!"
- `void onScreenOn()`  L129 @Override
    - 体内字面量："onScreenOn"
- `void onUserPresent()`  L134 @Override
    - 体内字面量："onUserPresent"
### `com.icatch.golive.data.GlobalApp.GlobalInfo$OnEventListener`
L54 · [interface] public OnEventListener · `com/icatch/golive/data/GlobalApp/GlobalInfo.java`

方法（1）：
- `void eventListener(int i)`  L55
### `com.icatch.golive.data.Hash.PropertyHashMapDynamic`
L20 · [class] public PropertyHashMapDynamic · `com/icatch/golive/data/Hash/PropertyHashMapDynamic.java`

字段/常量（12）：
- `PropertyHashMapDynamic propertyHashMap`  L21
- `String TAG = "PropertyHashMapDynamic"`  L22
- `String string = "<binary/metadata>"`  L75
- `List<Integer> listConvertImageSizes`  L94
- `String str`  L95
- `String string`  L137
- `int i2 = iIntValue % 1000`  L149
- `String str2`  L178
- `String str3 = null`  L179
- `String str4 = strArrSplit[0]`  L189
- `String str5 = strArrSplit[1]`  L190
- `String str2 = strArrSplit[0] + " " + strArrSplit[1] + "fps"`  L278

方法（14）：
- `HashMap<Integer, ItemInfo> getAutoPowerOffMap(CameraProperties cameraProperties)`  L24
    - 体内字面量："PropertyHashMapDynamic" · "autoPowerOffList ii=" · " value="
- `HashMap<Integer, ItemInfo> getCaptureDelayMap(CameraProperties cameraProperties)`  L36
    - 体内字面量："PropertyHashMapDynamic" · "delyaList.get(ii) =="
- `HashMap<Integer, ItemInfo> getExposureCompensationMap(CameraProperties cameraProperties)`  L47
    - 体内字面量："PropertyHashMapDynamic" · "exposureCompensationList ii=" · " value=" · " temp="
- `HashMap<Integer, ItemInfo> getFastMotionMovieMap(CameraProperties cameraProperties)`  L59
    - 体内字面量："x" · "PropertyHashMapDynamic" · "fastMotionMovieList ii=" · " value="
- `HashMap<Integer, ItemInfo> getGSensorMap(CameraProperties cameraProperties)`  L71
- `HashMap<String, ItemInfo> getImageSizeMap(CameraProperties cameraProperties)`  L93
- `PropertyHashMapDynamic getInstance()`  L117
- `HashMap<Integer, ItemInfo> getScreenSaverMap(CameraProperties cameraProperties)`  L124
    - 体内字面量："PropertyHashMapDynamic" · "screenSaverList ii=" · " value="
- `HashMap<Integer, ItemInfo> getVideoFileLengthMap(CameraProperties cameraProperties)`  L136
- `HashMap<String, ItemInfo> getVideoSizeMap(CameraProperties cameraProperties)`  L158
    - 体内字面量："PropertyHashMapDynamic" · "videoSizeList_" · " = " · "PropertyHashMapDynamic" · "end initVideoSizeMap videoSizeList size=" · " videoSizeMap size="
- `String getAbbreviation(String str)`  L177
- `HashMap<Integer, ItemInfo> getDynamicHashInt(CameraProperties cameraProperties, int i)`  L237
- `HashMap<String, ItemInfo> getDynamicHashString(CameraProperties cameraProperties, int i)`  L258
- `String getFullName(String str)`  L268
    - 体内字面量："PropertyHashMapDynamic" · "getFullName videoSize is null!" · " " · "PropertyHashMapDynamic" · "getFullName videoSize æ ¼å¼ä¸æ­£ç¡®!"
### `com.icatch.golive.data.Hash.PropertyHashMapStatic`
L10 · [class] public PropertyHashMapStatic · `com/icatch/golive/data/Hash/PropertyHashMapStatic.java`

字段/常量（2）：
- `PropertyHashMapStatic propertyHashMap`  L11
- `String tag = "PropertyHashMapStatic"`  L12

方法（14）：
- `PropertyHashMapStatic getInstance()`  L31
- `void ininTimeLapseMode()`  L38
- `void initBluetoothAudioRecording()`  L43
- `void initCameraImageSwitching()`  L48
- `void initCameraSwitch()`  L53
- `void initMicrophoneReception()`  L58
- `void initSlowMotion()`  L63
- `void initTimeLapseDuration()`  L68
- `void initUpside()`  L79
- `void initBurstMap()`  L84
- `void initDateStampMap()`  L95
- `void initElectricityFrequencyMap()`  L101
- `void initPropertyHashMap()`  L106
    - 体内字面量："PropertyHashMapStatic" · "Start initPropertyHashMap" · "PropertyHashMapStatic" · "End initPropertyHashMap"
- `void initWhiteBalanceMap()`  L123
### `com.icatch.golive.data.Message.AppMessage`
L4 · [class] public AppMessage · `com/icatch/golive/data/Message/AppMessage.java`

字段/常量（40）：
- `int ACTIVITY_MESSAGE = 0`  L5
- `int AP_MODE_TO_STA_MODE_FAILURE = 4098`  L6
- `int AP_MODE_TO_STA_MODE_SUSSED = 4097`  L7
- `int CANCEL_DOWNLOAD_ALL = 772`  L8
- `int CANCEL_DOWNLOAD_SINGLE = 771`  L9
- `int DOWNLOAD_BEGIN = 775`  L10
- `int DOWNLOAD_FAILURE = 778`  L11
- `int DOWNLOAD_FINISHED = 776`  L12
- `int DOWNLOAD_SUCCEED = 777`  L13
- `int EVENT_CACHE_PROGRESS_NOTIFY = 1538`  L14
- `int EVENT_CACHE_STATE_CHANGED = 1537`  L15
- `int EVENT_VIDEO_PLAY_COMPLETED = 1539`  L16
- `int FACEBOOK_LOGIN_SUCCEED = 4101`  L17
- `int FUNCTION_MESSAGE = 4096`  L18
- `int GOOGLE_LOGIN_SUCCEED = 6`  L19
- `int LAUNCH_ACTIVITY = 0`  L20
- `int LOCAL_ACTIVITY = 256`  L21
- `int LOCAL_VIDEO_PBACTIVITY = 1536`  L22
- `int MESSAGE_CAMERA_CONNECTING_START = 5`  L23
- `int MESSAGE_CAMERA_CONNECT_FAIL = 3`  L24
- `int MESSAGE_CAMERA_CONNECT_SUCCESS = 4`  L25
- `int MESSAGE_CAMERA_SCAN_TIME_OUT = 2`  L26
- `int MESSAGE_CANCEL_DOWNLOAD_SINGLE = 769`  L27
- `int MESSAGE_CANCEL_VIDEO_DOWNLOAD = 1541`  L28
- `int MESSAGE_CONNECTED = 4100`  L29
- `int MESSAGE_DELETE_CAMERA = 1`  L30
- `int MESSAGE_DISCONNECTED = 4099`  L31
- `int MESSAGE_LIVE_NETWORK_DISCONNECT = 514`  L32
- `int MESSAGE_UPDATE_VIDEOPB_BAR = 1540`  L33
- `int MESSAGE_VIDEO_STREAM_CODEC_INFO = 1543`  L34
- `int MESSAGE_VIDEO_STREAM_NO_EIS_INFORMATION = 1542`  L35
- `int MESSAGE_WIFI_PASSWORD_ERROR = 4103`  L36
- `int MPB_ACTIVITY = 768`  L37
- `int OPEN_WIFI_HOTSPOT_FAILED = 4102`  L38
- `int PHOTO_PBACTIVITY = 1024`  L39
- `int PREVIEW_ACTIVITY = 512`  L40
- `int SETTING_OPTION_AUTO_DOWNLOAD = 513`  L41
- `int UPDATE_LOADING_PROGRESS = 770`  L42
- `int UPDATE_TOTAL_PROGRESS = 773`  L43
- `int VIDEO_PBACTIVITY = 1280`  L44
### `com.icatch.golive.data.Mode.CameraNetworkMode`
L6 · [class] public final CameraNetworkMode · `com/icatch/golive/data/Mode/CameraNetworkMode.java`

字段/常量（3）：
- `int AP = 1`  L7
- `int ETHERNET = 2`  L8
- `int STATION = 0`  L9

方法（2）：
- `String getModeConvert(int i)`  L12
- `void initNetworkModeMap()`  L19
    - 体内字面量："Station" · "AP" · "Ethernet"
### `com.icatch.golive.data.Mode.LiveMode`
L4 · [enum] public LiveMode · `com/icatch/golive/data/Mode/LiveMode.java`

枚举常量（3）：
- `MODE_YOUTUBE_LIVE()`  L5
- `MODE_FACEBOOK_LIVE()`  L6
- `MODE_OTHER_LIVE()`  L7
### `com.icatch.golive.data.Mode.OperationMode`
L4 · [enum] public OperationMode · `com/icatch/golive/data/Mode/OperationMode.java`

枚举常量（1）：
- `MODE_BROWSE()`  L5
### `com.icatch.golive.data.Mode.PreviewLaunchMode`
L4 · [class] public PreviewLaunchMode · `com/icatch/golive/data/Mode/PreviewLaunchMode.java`

字段/常量（2）：
- `int RT_PREVIEW_MODE = 2`  L5
- `int VIDEO_PB_MODE = 1`  L6
### `com.icatch.golive.data.Mode.PreviewMode`
L4 · [class] public PreviewMode · `com/icatch/golive/data/Mode/PreviewMode.java`

字段/常量（12）：
- `int APP_STATE_NONE_MODE = 0`  L5
- `int APP_STATE_STILL_CAPTURE = 2`  L6
- `int APP_STATE_STILL_MODE = 4097`  L7
- `int APP_STATE_STILL_PREVIEW = 1`  L8
- `int APP_STATE_TIMELAPSE_MODE = 4099`  L9
- `int APP_STATE_TIMELAPSE_STILL_CAPTURE = 6`  L10
- `int APP_STATE_TIMELAPSE_STILL_PREVIEW = 8`  L11
- `int APP_STATE_TIMELAPSE_VIDEO_CAPTURE = 5`  L12
- `int APP_STATE_TIMELAPSE_VIDEO_PREVIEW = 7`  L13
- `int APP_STATE_VIDEO_CAPTURE = 4`  L14
- `int APP_STATE_VIDEO_MODE = 4098`  L15
- `int APP_STATE_VIDEO_PREVIEW = 3`  L16
### `com.icatch.golive.data.Mode.TouchMode`
L4 · [enum] public TouchMode · `com/icatch/golive/data/Mode/TouchMode.java`

枚举常量（3）：
- `MOVE()`  L5
- `DRAG()`  L6
- `NONE()`  L7
### `com.icatch.golive.data.Mode.VideoPbMode`
L4 · [enum] public VideoPbMode · `com/icatch/golive/data/Mode/VideoPbMode.java`

枚举常量（2）：
- `MODE_VIDEO_PLAY()`  L5
- `MODE_VIDEO_IDLE()`  L6
### `com.icatch.golive.data.PropertyId.PropertyId`
L4 · [class] public PropertyId · `com/icatch/golive/data/PropertyId/PropertyId.java`

字段/常量（51）：
- `int AP_MODE_TO_STA_MODE = 55291`  L5
- `int AUTO_POWER_OFF = 55073`  L6
- `int BLUETOOTH_AUDIO_RECORDING = 55221`  L7
- `int BURST_NUMBER = 20504`  L8
- `int CAMERA_CONNECT_CHANGE = 55201`  L9
- `int CAMERA_DATE = 20497`  L10
- `int CAMERA_DATE_TIMEZONE = 55358`  L11
- `int CAMERA_ESSID = 55356`  L12
- `int CAMERA_IMAGE_SWITCHING = 55222`  L13
- `int CAMERA_NAME = 55345`  L14
- `int CAMERA_PASSWORD = 55357`  L15
- `int CAMERA_PASSWORD_NEW = 55346`  L16
- `int CAMERA_PB_LIMIT_NUMBER = 55359`  L17
- `int CAMERA_SWITCH = 55091`  L18
- `int CAPTURE_DELAY = 20498`  L19
- `int CAPTURE_DELAY_MODE = 55280`  L20
- `int CAPTURE_IN_VIDEO_RECORD = 55082`  L21
- `int DATE_STAMP = 54791`  L22
- `int DEFALUT_TO_PREVIEW = 55084`  L23
- `int ESSID_NAME = 55348`  L24
- `int ESSID_PASSWORD = 55349`  L25
- `int EXPOSURE_COMPENSATION = 55075`  L26
- `int FAST_MOTION_MOVIE = 55078`  L27
- `int G_SENSOR = 55228`  L28
- `int IMAGE_SIZE = 20483`  L29
- `int IMAGE_STABILIZATION = 55076`  L30
- `int LIGHT_FREQUENCY = 54790`  L31
- `int MICROPHONE_RECEPTION = 55220`  L32
- `int MULTIPLE_CAMERA_SENSOR = 55081`  L33
- `int NOTIFY_FW_TO_SHARE_MODE = 55291`  L34
- `int POWER_ON_AUTO_RECORD = 55074`  L35
- `int RESET_DEVICE = 55217`  L36
- `int SCREEN_SAVER = 55072`  L37
- `int SD_SPACE = 55218`  L38
- `int SD_SPACE_REMAIN = 55219`  L39
- `int SERVICE_ESSID = 55350`  L40
- `int SERVICE_PASSWORD = 55351`  L41
- `int SLOW_MOTION = 54805`  L42
- `int STA_MODE_PASSWORD = 55349`  L43
- `int STA_MODE_SSID = 55348`  L44
- `int SUPPORT_PREVIEW = 55295`  L45
- `int TIMELAPSE_MODE = 60928`  L46
- `int TIMELAPSE_VIDEO_SIZE_LIST_MASK = 55291`  L47
- `int UP_SIDE = 55216`  L48
- `int VIDEO_FILE_LENGTH = 55077`  L49
- `int VIDEO_RECORDING_TIME = 55293`  L50
- `int VIDEO_SIZE = 54789`  L51
- `int VIDEO_SIZE_FLOW = 55292`  L52
- `int VIDEO_WARNING_QUERY = 55224`  L53
- `int WHITE_BALANCE = 20485`  L54
- `int WIND_NOISE_REDUCTION = 55079`  L55
### `com.icatch.golive.data.SystemInfo.HotSpot`
L15 · [class] public HotSpot · `com/icatch/golive/data/SystemInfo/HotSpot.java`

字段/常量（13）：
- `String TAG = "HotSpot"`  L16
- `int WIFI_AP_STATE_DISABLED = 11`  L17
- `int WIFI_AP_STATE_DISABLING = 10`  L18
- `int WIFI_AP_STATE_ENABLED = 13`  L19
- `int WIFI_AP_STATE_ENABLING = 12`  L20
- `int WIFI_AP_STATE_FAILED = 14`  L21
- `Method method`  L52
- `String str = null`  L54
- `Method method`  L75
- `String str = null`  L77
- `Method method`  L126
- `boolean zBooleanValue = false`  L128
- `Method method2 = null`  L133

方法（8）：
- `ArrayList<String> getConnectedHotIP()`  L23
    - 体内字面量："/proc/net/arp" · " +"
- `String getFirstConnectedHotIP()`  L43
- `String getWifiApSSID(Context context)`  L51
- `String getWifiApSharedKey(Context context)`  L74
- `int getWifiApState(Context context)`  L97
    - 体内字面量："wifi" · "getWifiApState" · "wifi state:  " · "Cannot get WiFi AP state"
- `boolean isApEnabled(Context context)`  L109
- `void printHotIp()`  L113
    - 体内字面量："\n" · "---->>heww resultList="
- `boolean setWifiApEnabled(Context context, boolean z)`  L125
### `com.icatch.golive.data.SystemInfo.MWifiManager`
L14 · [class] public MWifiManager · `com/icatch/golive/data/SystemInfo/MWifiManager.java`

字段/常量（4）：
- `String TAG = "MWifiManager"`  L15
- `String WIFI_SSID_UNKNOWN = "unknown"`  L16
- `String ssidByNetworkId = WIFI_SSID_UNKNOWN`  L23
- `String strReplace`  L47

方法（4）：
- `String getSsid(Context context)`  L18
    - 体内字面量："----------ssid is null="
- `String getSsidByNetworkId(Context context)`  L46
- `boolean isWifiConnected(Context context)`  L74
    - 体内字面量："connectivity"
- `boolean isWifiEnabled(Context context)`  L79
    - 体内字面量："wifi"
### `com.icatch.golive.data.SystemInfo.SystemInfo`
L17 · [class] public SystemInfo · `com/icatch/golive/data/SystemInfo/SystemInfo.java`

字段/常量（4）：
- `String TAG = "SystemInfo"`  L18
- `SystemInfo instance`  L19
- `long j = memoryInfo.availMem / 1024`  L29
- `View currentFocus`  L61

方法（8）：
- `String formatSize(Context context, long j)`  L21
- `long getFreeMemory(Context context)`  L25
    - 体内字面量："activity"
- `SystemInfo getInstance()`  L34
- `DisplayMetrics getMetrics(Context context)`  L41
- `long getSDFreeSize(Context context)`  L45
    - 体内字面量："getSDFreeSize="
- `int getWindowVisibleCountMax(Context context, int i)`  L54
    - 体内字面量："end getWindowVisibleCountMax visibleCountMax="
- `void hideInputMethod(Activity activity)`  L60
- `String getLocalMacAddress(Activity activity)`  L69
    - 体内字面量："wifi" · "current Mac="
### `com.icatch.golive.data.type.CameraSwitch`
L4 · [class] public CameraSwitch · `com/icatch/golive/data/type/CameraSwitch.java`

字段/常量（2）：
- `int CAMERA_BACK = 1`  L5
- `int CAMERA_FRONT = 0`  L6
### `com.icatch.golive.data.type.FileType`
L4 · [enum] public FileType · `com/icatch/golive/data/type/FileType.java`

枚举常量（2）：
- `FILE_VIDEO()`  L5
- `FILE_PHOTO()`  L6
### `com.icatch.golive.data.type.PhotoWallLayoutType`
L4 · [enum] public PhotoWallLayoutType · `com/icatch/golive/data/type/PhotoWallLayoutType.java`

枚举常量（2）：
- `PREVIEW_TYPE_LIST()`  L5
- `PREVIEW_TYPE_GRID()`  L6
### `com.icatch.golive.data.type.SlowMotion`
L4 · [class] public SlowMotion · `com/icatch/golive/data/type/SlowMotion.java`

字段/常量（2）：
- `int SLOW_MOTION_OFF = 0`  L5
- `int SLOW_MOTION_ON = 1`  L6
### `com.icatch.golive.data.type.TimeLapseDuration`
L11 · [class] public TimeLapseDuration · `com/icatch/golive/data/type/TimeLapseDuration.java`

字段/常量（15）：
- `int TIME_LAPSE_DURATION_10MIN = 10`  L12
- `int TIME_LAPSE_DURATION_15MIN = 15`  L13
- `int TIME_LAPSE_DURATION_20MIN = 20`  L14
- `int TIME_LAPSE_DURATION_2MIN = 2`  L15
- `int TIME_LAPSE_DURATION_30MIN = 30`  L16
- `int TIME_LAPSE_DURATION_5MIN = 5`  L17
- `int TIME_LAPSE_DURATION_60MIN = 60`  L18
- `int TIME_LAPSE_DURATION_UNLIMITED = 65535`  L19
- `CameraProperties cameraProperties`  L20
- `String tag = "TimeLapseDuration"`  L21
- `int[] valueListInt`  L22
- `String[] valueListString`  L23
- `int i2 = i / 60`  L34
- `int i3 = i % 60`  L35
- `String str = i2 > 0 ? "<binary/metadata>" + i2 + "HR" : "<binary/metadata>"`  L36

方法（8）：
- `public TimeLapseDuration(CameraProperties cameraProperties)`  L25
- `String convertTimeLapseDuration(int i)`  L30
- `String getCurrentValue()`  L40
- `int[] getValueStringInt()`  L44
- `String[] getValueStringList()`  L48
- `void initTimeLapseDuration()`  L52
    - 体内字面量："TimeLapseDuration" · "begin initTimeLapseDuration" · "TimeLapseDuration" · "end initTimeLapseDuration timeLapseDuration ="
- `Boolean needDisplayByMode(int i)`  L71
- `boolean setValueByPosition(int i)`  L75
### `com.icatch.golive.data.type.TimeLapseInterval`
L9 · [class] public TimeLapseInterval · `com/icatch/golive/data/type/TimeLapseInterval.java`

字段/常量（8）：
- `int TIME_LAPSE_INTERVAL_OFF = 0`  L10
- `CameraProperties cameraProperties`  L11
- `String tag = "TimeLapseInterval"`  L12
- `int[] valueListInt`  L13
- `String[] valueListString`  L14
- `int i2 = i / 3600`  L27
- `int i4 = i % 60`  L29
- `String str = i2 > 0 ? "<binary/metadata>" + i2 + " HR " : "<binary/metadata>"`  L30

方法（8）：
- `public TimeLapseInterval(CameraProperties cameraProperties)`  L16
- `String convertTimeLapseInterval(int i)`  L20
    - 体内字面量："OFF" · "0.5 Sec"
- `String getCurrentValue()`  L37
- `int[] getValueStringInt()`  L41
- `String[] getValueStringList()`  L45
- `void initTimeLapseInterval()`  L50
    - 体内字面量："TimeLapseInterval" · "begin initTimeLapseInterval" · "TimeLapseInterval" · "end initTimeLapseInterval timeLapseInterval ="
- `Boolean needDisplayByMode(int i)`  L69
- `boolean setValueByPosition(int i)`  L73
### `com.icatch.golive.data.type.TimeLapseMode`
L4 · [class] public TimeLapseMode · `com/icatch/golive/data/type/TimeLapseMode.java`

字段/常量（2）：
- `int TIME_LAPSE_MODE_STILL = 0`  L5
- `int TIME_LAPSE_MODE_VIDEO = 1`  L6
### `com.icatch.golive.data.type.Tristate`
L4 · [enum] public Tristate · `com/icatch/golive/data/type/Tristate.java`

枚举常量（3）：
- `FALSE()`  L5
- `NORMAL()`  L6
- `SIZE_NOT_SUPPORT()`  L7
### `com.icatch.golive.data.type.Upside`
L4 · [class] public Upside · `com/icatch/golive/data/type/Upside.java`

字段/常量（2）：
- `int UPSIDE_OFF = 0`  L5
- `int UPSIDE_ON = 1`  L6