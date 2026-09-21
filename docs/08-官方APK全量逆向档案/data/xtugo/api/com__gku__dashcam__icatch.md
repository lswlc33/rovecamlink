# XTU GO — 类与成员明细：com.gku.dashcam.icatch

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 146 个文件 / 227 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.dashcam.icatch.appdialog.AppToast`
L7 · [class] public AppToast · `com/gku/dashcam/icatch/appdialog/AppToast.java`

字段/常量（1）：
- `Toast toast`  L8

方法（2）：
- `void show(Context context, CharSequence text, int duration)`  L10
    - 体内字面量："é»è®¤çToast"
- `void show(Context context, int stringId, int duration)`  L19
    - 体内字面量："é»è®¤çToast"
### `com.gku.dashcam.icatch.appdialog.CustomDownloadDialog`
L13 · [class] public CustomDownloadDialog · `com/gku/dashcam/icatch/appdialog/CustomDownloadDialog.java`

字段/常量（6）：
- `AlertDialog alertDialog`  L14
- `AlertDialog.Builder builder`  L15
- `TextView cancelAllTxv`  L16
- `ListView downloadStatus`  L17
- `TextView message`  L18
- `AlertDialog alertDialog = this.alertDialog`  L37

方法（5）：
- `void showDownloadDialog(Context context, DownloadManagerAdapter adapter)`  L20
- `void dismissDownloadDialog()`  L36
- `void setMessage(String myMessage)`  L43
- `void setBackBtnOnClickListener(View.OnClickListener onClickListener)`  L47
- `void setAdapter(DownloadManagerAdapter adapter)`  L53
### `com.gku.dashcam.icatch.appdialog.CustomProgressBigDialog`
L11 · [class] public CustomProgressBigDialog · extends `ProgressDialog` · `com/gku/dashcam/icatch/appdialog/CustomProgressBigDialog.java`

字段/常量（2）：
- `String text`  L12
- `String str`  L30

方法（5）：
- `public CustomProgressBigDialog(Context context)`  L14
- `public CustomProgressBigDialog(Context context, int theme, String text)`  L18
- `void onCreate(Bundle savedInstanceState)`  L24 @Override
- `void init(Context context)`  L29
- `void show()`  L45 @Override
### `com.gku.dashcam.icatch.appdialog.CustomProgressDialog`
L11 · [class] public CustomProgressDialog · extends `ProgressDialog` · `com/gku/dashcam/icatch/appdialog/CustomProgressDialog.java`

字段/常量（2）：
- `String text`  L12
- `String str`  L30

方法（5）：
- `public CustomProgressDialog(Context context)`  L14
- `public CustomProgressDialog(Context context, int theme, String text)`  L18
- `void onCreate(Bundle savedInstanceState)`  L24 @Override
- `void init(Context context)`  L29
- `void show()`  L45 @Override
### `com.gku.dashcam.icatch.appdialog.SingleDownloadDialog`
L15 · [class] public SingleDownloadDialog · `com/gku/dashcam/icatch/appdialog/SingleDownloadDialog.java`

字段/常量（10）：
- `AlertDialog alertDialog`  L16
- `AlertDialog.Builder builder`  L17
- `Context context`  L18
- `ICatchFile curVideoFile`  L19
- `ImageButton exitBtn`  L20
- `TextView fileDownloadStatus`  L21
- `TextView fileNameTxv`  L22
- `NumberProgressBar numberProgressBar`  L23
- `AlertDialog alertDialog = this.alertDialog`  L43
- `AlertDialog alertDialog = this.alertDialog`  L50

方法（5）：
- `public SingleDownloadDialog(Context context, ICatchFile iCatchFile)`  L25
- `void showDownloadDialog()`  L42
- `void dismissDownloadDialog()`  L49
- `void setBackBtnOnClickListener(View.OnClickListener onClickListener)`  L56
- `void updateDownloadStatus(DownloadInfo downloadInfo)`  L62
    - 体内字面量："#.#" · "M" · "M" · "/"
### `com.gku.dashcam.icatch.appinfo.AppInfo`
L10 · [class] public AppInfo · `com/gku/dashcam/icatch/appinfo/AppInfo.java`

字段/常量（39）：
- `String APP_LOG_DIRECTORY_PATH = "/ActionCam/ActionCam_APP_Log/"`  L11
- `String APP_PATH = "/ActionCam/"`  L12
- `String APP_VERSION = "V1.2.0_beta34"`  L13
- `String AUTO_DOWNLOAD_PATH = "/DCIM/ActionCam/photo/"`  L14
- `String DOWNLOAD_PATH = "/DCIM/ActionCam/"`  L15
- `String DOWNLOAD_PATH_PHOTO = "/DCIM/ActionCam/photo/"`  L16
- `String DOWNLOAD_PATH_VIDEO = "/DCIM/ActionCam/video/"`  L17
- `String EULA_VERSION = "1.3"`  L18
- `String FILE_GOOGLE_TOKEN = "file_googleToken.dat"`  L19
- `String FW_UPGRADE_FILENAME = "sphost.BRN"`  L20
- `String PROPERTY_CFG_DIRECTORY_PATH = "/ActionCam/Resoure/"`  L21
- `String PROPERTY_CFG_FILE_NAME = "netconfig.properties"`  L22
- `String SDK_LOG_DIRECTORY_PATH = "/ActionCam/ActionCam_SDK_Log/"`  L23
- `String SDK_VERSION = "V3.6.0.35"`  L24
- `String STREAM_OUTPUT_DIRECTORY_PATH = "/ActionCam/Resoure/Raw/"`  L25
- `String TAG = "AppInfo"`  L26
- `boolean autoDownloadAllow = false`  L27
- `float autoDownloadSizeLimit = 1.0f`  L28
- `boolean disableAudio = false`  L29
- `boolean enableLive = false`  L30
- `boolean isDownloading = false`  L31
- `boolean isSdCardExist = true`  L32
- `boolean isSupportAutoReconnection = false`  L33
- `boolean isSupportBroadcast = false`  L34
- `boolean isSupportSetting = false`  L35
- `boolean saveSDKLog = false`  L36
- `PhotoWallLayoutType photoWallLayoutType = PhotoWallLayoutType.PREVIEW_TYPE_LIST`  L37
- `int currentViewpagerPosition = 0`  L38
- `int curVisibleItem = 0`  L39
- `boolean enableSoftwareDecoder = false`  L40
- `boolean isBLE = false`  L41
- `boolean isReleaseBTClient = true`  L42
- `int videoCacheNum = 0`  L43
- `int curFps = 30`  L44
- `double unsteadyTime = 0.1d`  L45
- `String inputIp = IcatchCaseKt.API_HOST_ICATCH`  L46
- `boolean isNeedReconnect = true`  L47
- `boolean enableDumpVideo = false`  L48
- `boolean enableRender = false`  L49

方法（1）：
- `boolean isAppSentToBackground(final Context context)`  L51
    - 体内字面量："activity"
### `com.gku.dashcam.icatch.appinfo.ExitApp`
L11 · [class] public ExitApp · `com/gku/dashcam/icatch/appinfo/ExitApp.java`

字段/常量（4）：
- `String TAG = "ExitApp"`  L12
- `ExitApp instance`  L13
- `LinkedList<Activity> linkedList = this.activityList`  L39
- `LinkedList<Activity> linkedList = this.activityList`  L59

方法（6）：
- `ExitApp getInstance()`  L16
- `void addActivity(Activity activity)`  L23
- `void removeActivity(Activity activity)`  L30
- `void getActivities()`  L34
    - 体内字面量："getActivities: \n"
- `void exit()`  L38
- `void finishAllActivity()`  L54
### `com.gku.dashcam.icatch.appinfo.GlobalInfo`
L16 · [class] public GlobalInfo · `com/gku/dashcam/icatch/appinfo/GlobalInfo.java`

字段/常量（14）：
- `String TAG = "GlobalInfo"`  L17
- `GlobalInfo instance`  L18
- `Activity activity`  L19
- `List<MultiPbItemInfo> fileList`  L20
- `int i = msg.what`  L24
- `ScreenListener listener`  L50
- `List<LocalPbItemInfo> localPhotoList`  L51
- `List<LocalPbItemInfo> localVideoList`  L52
- `OnEventListener onEventListener`  L53
- `SDKEvent sdkEvent`  L54
- `WifiCheck wifiCheck`  L55
- `ScreenListener screenListener = this.listener`  L116
- `SDKEvent sDKEvent = this.sdkEvent`  L130
- `WifiCheck wifiCheck = this.wifiCheck`  L141

方法（21）：
- `void handleMessage(Message msg)`  L23 @Override
- `void success()`  L30 @Override
    - 体内字面量："Globalinfo" · "EVENT_RCONNECT_SUCC showAutoReconnectDialog"
- `GlobalInfo getInstance()`  L61
- `void setOnEventListener(OnEventListener onEventListener)`  L68
- `Context getAppContext()`  L72
- `void setCurrentApp(Activity activity)`  L76
- `Activity getCurrentApp()`  L80
- `List<LocalPbItemInfo> getLocalPhotoList()`  L84
- `void setLocalPhotoList(List<LocalPbItemInfo> localPhotoList)`  L88
- `void setLocalVideoList(List<LocalPbItemInfo> localVideoList)`  L92
- `void startScreenListener()`  L96
- `void onScreenOn()`  L101 @Override
- `void onUserPresent()`  L105 @Override
- `void onScreenOff()`  L109 @Override
- `void endSceenListener()`  L115
- `void addEventListener(int eventId)`  L122
- `void delEventListener(int eventId)`  L129
- `void delete()`  L136
- `void cancelReconnect()`  L140
- `void setFileList(List<MultiPbItemInfo> fileList)`  L147
- `List<MultiPbItemInfo> getFileList()`  L151
### `com.gku.dashcam.icatch.appinfo.GlobalInfo$OnEventListener`
L57 · [interface] public OnEventListener · `com/gku/dashcam/icatch/appinfo/GlobalInfo.java`

方法（1）：
- `void eventListener(int sdkEventId)`  L58
### `com.gku.dashcam.icatch.appinfo.SystemInfo`
L14 · [class] public SystemInfo · `com/gku/dashcam/icatch/appinfo/SystemInfo.java`

字段/常量（3）：
- `String TAG = "SystemInfo"`  L15
- `SystemInfo instance`  L16
- `View currentFocus`  L52

方法（7）：
- `SystemInfo getInstance()`  L18
- `DisplayMetrics getMetrics(Context context)`  L25
- `long getSDFreeSize(Context context)`  L29
- `String formatSize(Context context, long size)`  L36
- `long getFreeMemory(Context mContext)`  L40
    - 体内字面量："activity"
- `int getWindowVisibleCountMax(Context context, int row)`  L47
- `void hideInputMethod(Activity activity)`  L51
### `com.gku.dashcam.icatch.BaseProperties`
L13 · [class] public BaseProperties · `com/gku/dashcam/icatch/BaseProperties.java`

字段/常量（31）：
- `String TAG = "BaseProperties"`  L14
- `PropertyTypeInteger audioRecord`  L15
- `PropertyTypeInteger autoPowerOff`  L16
- `PropertyTypeInteger beepSound`  L17
- `PropertyTypeInteger bootSound`  L18
- `PropertyTypeInteger burst`  L19
- `CameraProperties cameraProperty`  L20
- `PropertyTypeInteger cameraSwitch`  L21
- `PropertyTypeInteger captureDelay`  L22
- `PropertyTypeInteger dateStamp`  L23
- `PropertyTypeInteger electricityFrequency`  L24
- `PropertyTypeInteger exposureCompensation`  L25
- `PropertyTypeInteger fastMotionMovie`  L26
- `PropertyTypeInteger fbPreview`  L27
- `PropertyTypeInteger gSensor`  L28
- `PropertyTypeString gkuString`  L29
- `PropertyTypeString imageSize`  L30
- `PropertyTypeInteger language`  L31
- `PropertyTypeInteger motionDetect`  L32
- `PropertyTypeInteger reset`  L33
- `PropertyTypeInteger screenSaver`  L34
- `PropertyTypeInteger slowMotion`  L35
- `PropertyTypeInteger speedUnit`  L36
- `TimeLapseDuration timeLapseDuration`  L37
- `PropertyTypeInteger timeLapseMode`  L38
- `TimeLapseInterval timeLapseStillInterval`  L39
- `TimeLapseInterval timeLapseVideoInterval`  L40
- `PropertyTypeInteger upside`  L41
- `PropertyTypeInteger videoFileLength`  L42
- `PropertyTypeString videoSize`  L43
- `PropertyTypeInteger whiteBalance`  L44

方法（32）：
- `public BaseProperties(CameraProperties cameraProperty)`  L46
- `void initProperty()`  L52
- `PropertyTypeInteger getScreenSaver()`  L83
- `PropertyTypeInteger getAutoPowerOff()`  L87
- `PropertyTypeInteger getCameraSwitch()`  L91
- `PropertyTypeInteger getExposureCompensation()`  L95
- `PropertyTypeInteger getVideoFileLength()`  L99
- `PropertyTypeInteger getFastMotionMovie()`  L103
- `PropertyTypeInteger getWhiteBalance()`  L107
- `PropertyTypeInteger getBurst()`  L111
- `PropertyTypeInteger getDateStamp()`  L115
- `PropertyTypeInteger getCaptureDelay()`  L119
- `PropertyTypeInteger getSlowMotion()`  L123
- `PropertyTypeInteger getUpside()`  L127
- `PropertyTypeString getVideoSize()`  L131
- `PropertyTypeString getImageSize()`  L135
- `PropertyTypeInteger getElectricityFrequency()`  L139
- `TimeLapseInterval getTimeLapseVideoInterval()`  L143
- `TimeLapseInterval getTimeLapseStillInterval()`  L147
- `TimeLapseDuration gettimeLapseDuration()`  L151
- `PropertyTypeInteger getTimeLapseMode()`  L155
- `PropertyTypeInteger getMotionDetect()`  L159
- `PropertyTypeInteger getAudioRecord()`  L163
- `PropertyTypeInteger getBeepSound()`  L167
- `PropertyTypeInteger getBootSound()`  L171
- `PropertyTypeInteger getLanguage()`  L175
- `PropertyTypeInteger getgSensor()`  L179
- `PropertyTypeInteger getSpeedUnit()`  L183
- `boolean reset()`  L187
- `String getGkuString()`  L191
- `PropertyTypeString getGkuString2()`  L195
- `PropertyTypeInteger getFbPreview()`  L199
### `com.gku.dashcam.icatch.CameraManager`
L6 · [class] public CameraManager · `com/gku/dashcam/icatch/CameraManager.java`

字段/常量（6）：
- `CameraManager instance`  L7
- `String TAG = "CameraManager"`  L8
- `DashCamera curCamera`  L9
- `DashCamera dashCamera = this.curCamera`  L27
- `DashCamera dashCamera`  L38
- `DashCamera dashCamera`  L45

方法（6）：
- `CameraManager getInstance()`  L11
- `DashCamera getCurCamera()`  L22
- `void disconnect()`  L26
- `void setCurCamera(DashCamera curCamera)`  L33
- `DashCamera createCamera(int cameraType, String ssid, String ipAddress, int mode)`  L37
- `DashCamera createUSBCamera(int cameraType, UsbDevice usbDevice, int position)`  L44
### `com.gku.dashcam.icatch.CameraSlotSQLite`
L11 · [class] public CameraSlotSQLite · `com/gku/dashcam/icatch/CameraSlotSQLite.java`

字段/常量（5）：
- `CameraSlotSQLite instance`  L12
- `String TAG = "CameraSlotSQLite"`  L13
- `ArrayList<CameraSlot> camSlotList`  L14
- `Context context`  L15
- `SQLiteDatabase db`  L16

方法（8）：
- `CameraSlotSQLite getInstance()`  L18
- `private CameraSlotSQLite()`  L25
- `void creatTable(Context context)`  L29
- `boolean insert(CameraSlot camSlot)`  L34
    - 体内字面量："isOccupied" · "cameraName" · "imageBuffer" · "cameraType"
- `void update(CameraSlot camSlot)`  L43
    - 体内字面量："isOccupied" · "imageBuffer" · "cameraName" · "cameraType" · "_id=?"
- `void deleteByPosition(int slotPosition)`  L54
- `int switchBoolToInt(Boolean value)`  L58
- `Boolean switchIntToBool(int value)`  L62
### `com.gku.dashcam.icatch.CameraSlotSQLiteHelper`
L8 · [class] public CameraSlotSQLiteHelper · extends `SQLiteOpenHelper` · `com/gku/dashcam/icatch/CameraSlotSQLiteHelper.java`

字段/常量（6）：
- `String DATABASE_NAME = "cameraSlotDb112.db"`  L9
- `String DATABASE_TABLE = "cameraSlotInfo"`  L10
- `int DATABASE_VERSION = 1`  L11
- `String CREATE_CAMINFODB`  L12
- `String databaseCreate`  L13
- `String tableDrop`  L14

方法（3）：
- `public CameraSlotSQLiteHelper(Context context)`  L16
    - 体内字面量："CREATE TABLE IF NOT EXISTS cameraSlotDb112.db (_id INTEGER PRIMARY KEY AUTOINCREMENT, isOccupied INTEGER, cameraName VARCHAR, imageBuffer BLOB)" · "drop table if exists cameraSlotInfo" · "CREATE TABLE IF NOT EXISTS cameraSlotInfo (_id integer primary key autoincrement, isOccupied integer, cameraName varchar, cameraType integer, imageBuffer blob)"
- `void onCreate(SQLiteDatabase db)`  L24 @Override
- `void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)`  L29 @Override
### `com.gku.dashcam.icatch.CameraType`
L4 · [class] public CameraType · `com/gku/dashcam/icatch/CameraType.java`

字段/常量（3）：
- `int UNDEFIND_CAMERA = 0`  L5
- `int USB_CAMERA = 1`  L6
- `int WIFI_CAMERA = 2`  L7
### `com.gku.dashcam.icatch.CommandSession`
L11 · [class] public CommandSession · `com/gku/dashcam/icatch/CommandSession.java`

字段/常量（14）：
- `String TAG = "CommandSession"`  L12
- `int scanFlag = 0`  L13
- `String tag = "CommandSession"`  L14
- `String ipAddress`  L15
- `String password`  L16
- `ICatchCameraSession session`  L17
- `boolean sessionPrepared = false`  L18
- `String uid`  L19
- `String username`  L20
- `boolean zPrepareSession`  L33
- `boolean zPrepareSession`  L55
- `boolean zCheckConnection`  L96
- `Boolean boolValueOf = false`  L110
- `boolean z = scanFlag != 1`  L128

方法（9）：
- `public CommandSession(String ipAddress, String uid, String username, String password)`  L22
- `public CommandSession()`  L29
- `boolean prepareSession(ICatchITransport itrans)`  L32
- `boolean prepareSession(ICatchITransport itrans, boolean enablePTPIP)`  L54
- `ICatchCameraSession getSDKSession()`  L90
    - 体内字面量："getSDKSession ="
- `boolean checkWifiConnection()`  L95
- `boolean destroySession()`  L108
    - 体内字面量："Start destroyPanoramaSession"
- `boolean startDeviceScan()`  L120
    - 体内字面量："Start startDeviceScan" · "End startDeviceScan,tempStartDeviceScanValue=false"
- `void stopDeviceScan()`  L126
    - 体内字面量："Start stopDeviceScan"
### `com.gku.dashcam.icatch.DashCamera`
L26 · [class] public DashCamera · `com/gku/dashcam/icatch/DashCamera.java`

字段/常量（27）：
- `BaseProperties baseProperties`  L27
- `CameraAction cameraAction`  L28
- `CameraFixedInfo cameraFixedInfo`  L29
- `String cameraName`  L30
- `CameraProperties cameraProperties`  L31
- `CameraState cameraState`  L32
- `int cameraType`  L33
- `CommandSession commandSession`  L34
- `FileOperation fileOperation`  L35
- `String ipAddress`  L36
- `int mode`  L37
- `PanoramaControl panoramaControl`  L38
- `PanoramaPhotoPlayback panoramaPhotoPlayback`  L39
- `PanoramaPreviewPlayback panoramaPreviewPlayback`  L40
- `PanoramaSession panoramaSession`  L41
- `PanoramaVideoPlayback panoramaVideoPlayback`  L42
- `int position`  L43
- `ICatchITransport transport`  L44
- `UsbDevice usbDevice`  L45
- `String TAG = "DashCamera"`  L46
- `int timeLapsePreviewMode = 1`  L47
- `boolean needInputPassword = true`  L48
- `boolean isStreamReady = false`  L49
- `boolean isConnected = false`  L50
- `boolean isLoadThumbnail = false`  L51
- `boolean zPrepareSession = false`  L106
- `ICatchITransport iCatchITransport = this.transport`  L143

方法（27）：
- `public DashCamera(int cameraType)`  L53
- `public DashCamera(int cameraType, String cameraName)`  L57
- `void setLoadThumbnail(boolean loadThumbnail)`  L62
- `boolean isLoadThumbnail()`  L66
- `public DashCamera(int cameraType, String ssid, String ipAddress, int mode)`  L70
- `public DashCamera(int cameraType, UsbDevice usbDevice, int position)`  L77
    - 体内字面量："UsbDevice_"
- `boolean connect(boolean enablePTPIP)`  L85
    - 体内字面量："connect cameraType=" · " enablePTPIP=" · "ICatchUVCBulkTransport IchInvalidArgumentException"
- `boolean disconnect()`  L141
- `boolean initCamera()`  L158
    - 体内字面量："Start initCamera"
- `int getMyMode()`  L178
- `CommandSession getSDKSession()`  L182
- `CameraAction getCameraAction()`  L186
- `CameraFixedInfo getCameraFixedInfo()`  L190
- `CameraProperties getCameraProperties()`  L194
- `CameraState getCameraState()`  L198
- `FileOperation getFileOperation()`  L202
- `PanoramaPhotoPlayback getPanoramaPhotoPlayback()`  L206
- `PanoramaPreviewPlayback getPanoramaPreviewPlayback()`  L210
- `PanoramaVideoPlayback getPanoramaVideoPlayback()`  L214
- `PanoramaControl getPanoramaControl()`  L218
- `BaseProperties getBaseProperties()`  L222
- `boolean isConnected()`  L226
    - 体内字面量："isConnected:"
- `String getCameraName()`  L231
- `int getPosition()`  L235
- `UsbDevice getUsbDevice()`  L239
- `int getCameraType()`  L243
- `String getIpAddress()`  L247
### `com.gku.dashcam.icatch.data.IcatchClientThread`
L18 · [class] public IcatchClientThread · implements `Runnable` · `com/gku/dashcam/icatch/data/IcatchClientThread.java`

字段/常量（10）：
- `String TAG = "ClientThread"`  L19
- `BufferedReader br`  L20
- `Handler handler`  L21
- `OnThreadCreatedListener mOnThreadCreatedListener`  L22
- `OutputStream os`  L23
- `Handler revHandler`  L24
- `Socket socket`  L25
- `String line = null`  L61
- `boolean z = true`  L62
- `OnThreadCreatedListener onThreadCreatedListener = this.mOnThreadCreatedListener`  L114

方法（6）：
- `void setOnThreadCreatedListener(OnThreadCreatedListener mOnThreadCreatedLitener)`  L31
- `public IcatchClientThread(Handler handler)`  L35
- `void release()`  L39
- `void run()`  L48 @Override
    - 体内字面量："utf-8"
- `void run()`  L59 @Override
- `void handleMessage(Message msg)`  L102 @Override
    - 体内字面量："/tmp/FL0/language.json"
### `com.gku.dashcam.icatch.data.IcatchClientThread$OnThreadCreatedListener`
L27 · [interface] public OnThreadCreatedListener · `com/gku/dashcam/icatch/data/IcatchClientThread.java`

方法（1）：
- `void onThreadCreated(boolean IsCreated)`  L28
### `com.gku.dashcam.icatch.data.IcatchConnectDevice`
L19 · [class] public IcatchConnectDevice · `com/gku/dashcam/icatch/data/IcatchConnectDevice.java`

字段/常量（9）：
- `String TAG = "IcatchConnectDevice"`  L20
- `IcatchConnectDevice instance`  L21
- `IcatchClientThread icatchClientThread`  L29
- `Context mContext`  L30
- `IcatchClientThread icatchClientThread = this.icatchClientThread`  L60
- `FileOutputStream fileOutputStream = null`  L77
- `String str = filePath + fileName`  L134
- `String str2 = strcontent + Registry.LINE_SEPARATOR`  L135
- `File file = null`  L155

方法（12）：
- `void handleMessage(Message msg)`  L24 @Override
    - 体内字面量："123->" · " ç¿»è¯æä»¶  language="
- `IcatchConnectDevice getInstance()`  L32
- `private IcatchConnectDevice()`  L39
- `void connect(Context context)`  L42
- `void onThreadCreated(boolean IsCreated)`  L48 @Override
    - 体内字面量："Error is in icatchClientThread#onThreadCreated"
- `void release()`  L59
- `void initData(String content)`  L67
    - 体内字面量："/" · "ICatchParams.txt" · "[" · "]"
- `void writeToFile(File file, String text)`  L75
    - 体内字面量："123->" · " file.name=" · "  text="
- `String subStr(String text, String pre, String end)`  L123
- `void writeTxtToFile(String strcontent, String filePath, String fileName)`  L132
- `File makeFilePath(String filePath, String fileName)`  L153
- `void makeRootDirectory(String filePath)`  L174
### `com.gku.dashcam.icatch.dataconvert.BurstConvert`
L6 · [class] public BurstConvert · `com/gku/dashcam/icatch/dataconvert/BurstConvert.java`

字段/常量（1）：
- `BurstConvert burstConvert`  L7

方法（4）：
- `BurstConvert getInstance()`  L10
- `public BurstConvert()`  L17
- `void initBurstMap()`  L21
- `int getBurstConverFromFw(int fwValue)`  L32
### `com.gku.dashcam.icatch.dataconvert.StreamInfoConvert`
L6 · [class] public StreamInfoConvert · `com/gku/dashcam/icatch/dataconvert/StreamInfoConvert.java`

方法（1）：
- `StreamInfo convertToStreamInfoBean(String cmd)`  L7
    - 体内字面量："FPS" · "\\?|&" · "W=" · "H=" · "BR=" · "FPS=" · "\\?|&" · "W=" · "H=" · "BR="
### `com.gku.dashcam.icatch.entity.BluetoothAppDevice`
L4 · [class] public BluetoothAppDevice · `com/gku/dashcam/icatch/entity/BluetoothAppDevice.java`

字段/常量（4）：
- `String bluetoothAddr`  L5
- `boolean bluetoothConnect`  L6
- `boolean bluetoothExist`  L7
- `String bluetoothName`  L8

方法（10）：
- `public BluetoothAppDevice(String name, String addr, boolean bluetoothConnect)`  L10
- `public BluetoothAppDevice(String name, String addr, boolean bluetoothConnect, boolean bluetoothExist)`  L17
- `String getBluetoothName()`  L24
- `void setBluetoothName(String bluetoothName)`  L28
- `String getBluetoothAddr()`  L32
- `void setBluetoothAddr(String bluetoothAddr)`  L36
- `boolean getBluetoothConnect()`  L40
- `void setBluetoothConnect(boolean bluetoothConnect)`  L44
- `boolean getBluetoothExist()`  L48
- `void setBluetoothExist(boolean bluetoothExist)`  L52
### `com.gku.dashcam.icatch.entity.CameraSlot`
L6 · [class] public CameraSlot · `com/gku/dashcam/icatch/entity/CameraSlot.java`

字段/常量（6）：
- `String cameraName`  L7
- `byte[] cameraPhoto`  L8
- `int cameraType`  L9
- `boolean isOccupied`  L10
- `boolean isReady`  L11
- `int slotPosition`  L12

方法（2）：
- `public CameraSlot(int slotPosition, boolean isOccupied, String cameraName, byte[] cameraPhoto)`  L14
- `public CameraSlot(int slotPosition, boolean isOccupied, String cameraName, int cameraType, byte[] cameraPhoto, boolean isReady)`  L23
### `com.gku.dashcam.icatch.entity.DownloadInfo`
L6 · [class] public DownloadInfo · `com/gku/dashcam/icatch/entity/DownloadInfo.java`

字段/常量（5）：
- `long curFileLength`  L7
- `boolean done`  L8
- `ICatchFile file`  L9
- `long fileSize`  L10
- `int progress`  L11

方法（3）：
- `public DownloadInfo(ICatchFile file, long fileSize, long curFileLength, int progress, boolean done)`  L13
- `void setDone(boolean done)`  L21
- `boolean isDone()`  L25
### `com.gku.dashcam.icatch.entity.FilterItem`
L4 · [class] public FilterItem · `com/gku/dashcam/icatch/entity/FilterItem.java`

字段/常量（2）：
- `int filterValue`  L5
- `String value`  L6

方法（5）：
- `public FilterItem(String value, int filterValue)`  L8
- `String getValue()`  L13
- `void setValue(String value)`  L17
- `int getFilterValue()`  L21
- `void setFilterValue(int filterValue)`  L25
### `com.gku.dashcam.icatch.entity.GoogleToken`
L6 · [class] public GoogleToken · implements `Serializable` · `com/gku/dashcam/icatch/entity/GoogleToken.java`

字段/常量（2）：
- `String accessToken`  L7
- `String refreshToken`  L8

方法（5）：
- `public GoogleToken(String accessToken, String refreshToken)`  L10
- `String getAccessToken()`  L15
- `void setCurrentAccessToken(String token)`  L19
- `String getRefreshToken()`  L23
- `void setCurrentRefreshToken(String token)`  L27
### `com.gku.dashcam.icatch.entity.ItemInfo`
L4 · [class] public ItemInfo · `com/gku/dashcam/icatch/entity/ItemInfo.java`

字段/常量（4）：
- `int iconID`  L5
- `String uiStringInPreview`  L6
- `int uiStringInSetting`  L7
- `String uiStringInSettingString`  L8

方法（2）：
- `public ItemInfo(int uiStringInSetting, String uiStringInPreview, int iconID)`  L10
- `public ItemInfo(String uiStringInSetting, String uiStringInPreview, int iconID)`  L17
### `com.gku.dashcam.icatch.entity.LimitQueue`
L9 · [class] public LimitQueue · implements `Queue<E>` · `com/gku/dashcam/icatch/entity/LimitQueue.java`

字段/常量（1）：
- `int limit`  L10

方法（22）：
- `public LimitQueue(int limit)`  L13
- `boolean offer(E e)`  L18 @Override
- `E poll()`  L26 @Override
- `E removeLast()`  L30
- `Queue<E> getQueue()`  L34
- `int getLimit()`  L38
- `boolean add(E e)`  L43 @Override
- `E element()`  L48 @Override
- `E peek()`  L53 @Override
- `boolean isEmpty()`  L58 @Override
- `int size()`  L63 @Override
- `E remove()`  L68 @Override
- `boolean addAll(Collection<? extends E> c)`  L73 @Override
- `void clear()`  L78 @Override
- `boolean contains(Object o)`  L83 @Override
- `boolean containsAll(Collection<?> c)`  L88 @Override
- `Iterator<E> iterator()`  L93 @Override
- `boolean remove(Object o)`  L98 @Override
- `boolean removeAll(Collection<?> c)`  L103 @Override
- `boolean retainAll(Collection<?> c)`  L108 @Override
- `Object[] toArray()`  L113 @Override
- `T[] toArray(T[] tArr)`  L118 @Override
### `com.gku.dashcam.icatch.entity.LocalPbItemInfo`
L13 · [class] public LocalPbItemInfo · `com/gku/dashcam/icatch/entity/LocalPbItemInfo.java`

字段/常量（6）：
- `File file`  L14
- `boolean isItemChecked`  L15
- `boolean isPanorama`  L16
- `int section`  L17
- `String line`  L72
- `String strSubstring = null`  L74

方法（12）：
- `public LocalPbItemInfo(File file, int section)`  L19
- `public LocalPbItemInfo(File file, int section, boolean isPanorama)`  L26
- `public LocalPbItemInfo(File file)`  L33
- `void setSection(int section)`  L39
- `String getFilePath()`  L43
- `String getFileDate()`  L47
- `String getFileSize()`  L51
- `String getFileName()`  L55
- `String getFileDateMMSS()`  L59
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
- `boolean isPanorama()`  L63
- `void setPanorama(boolean panorama)`  L67
- `void getCreateTime()`  L71
### `com.gku.dashcam.icatch.entity.MultiPbFileResult`
L7 · [class] public MultiPbFileResult · `com/gku/dashcam/icatch/entity/MultiPbFileResult.java`

字段/常量（4）：
- `List<MultiPbItemInfo> fileList`  L8
- `boolean isMore`  L9
- `ICatchFile lastFile`  L10
- `int lastIndex`  L11

方法（8）：
- `List<MultiPbItemInfo> getFileList()`  L13
- `void setFileList(List<MultiPbItemInfo> fileList)`  L17
- `int getLastIndex()`  L21
- `void setLastIndex(int lastIndex)`  L25
- `ICatchFile getLastFile()`  L29
- `void setLastFile(ICatchFile lastFile)`  L33
- `boolean isMore()`  L37
- `void setMore(boolean more)`  L41
### `com.gku.dashcam.icatch.entity.MultiPbItemInfo`
L9 · [class] public MultiPbItemInfo · implements `Parcelable, Serializable` · `com/gku/dashcam/icatch/entity/MultiPbItemInfo.java`

字段/常量（9）：
- `String TAG = "MultiPbItemInfo"`  L23
- `String fileDate`  L24
- `String fileDuration`  L25
- `String fileSize`  L26
- `String fileTime`  L27
- `ICatchFile iCatchFile`  L28
- `boolean isItemChecked`  L29
- `boolean isPanorama`  L30
- `int section`  L31

方法（19）：
- `MultiPbItemInfo createFromParcel(Parcel in)`  L13 @Override
- `MultiPbItemInfo[] newArray(int size)`  L19 @Override
- `public MultiPbItemInfo(ICatchFile file)`  L33
- `public MultiPbItemInfo(ICatchFile file, int section)`  L39
- `public MultiPbItemInfo(ICatchFile iCatchFile, int section, boolean isPanorama, String fileSize, String fileTime, String fileDate, String fileDuration)`  L46
- `protected MultiPbItemInfo(Parcel in)`  L57
- `void setPanorama(boolean panorama)`  L70
- `boolean isPanorama()`  L74
- `void setSection(int section)`  L78
- `String getFilePath()`  L82
- `int getFileHandle()`  L86
- `String getFileDate()`  L90
- `String getFileSize()`  L94
- `long getFileSizeInteger()`  L98
- `String getFileDuration()`  L102
- `String getFileName()`  L106
- `String getFileDateMMSS()`  L110
- `int describeContents()`  L115 @Override
- `void writeToParcel(Parcel parcel, int i)`  L120 @Override
### `com.gku.dashcam.icatch.entity.PropertyTypeInteger`
L17 · [class] public PropertyTypeInteger · `com/gku/dashcam/icatch/entity/PropertyTypeInteger.java`

字段/常量（18）：
- `String TAG = "PropertyTypeInteger"`  L18
- `CameraProperties cameraProperties`  L19
- `Context context`  L20
- `HashMap<Integer, ItemInfo> hashMap`  L21
- `int propertyId`  L22
- `Resources res`  L23
- `List<Integer> valueListInt`  L24
- `String[] valueListString`  L25
- `int i = this.propertyId`  L48
- `HashMap<Integer, ItemInfo> map = this.hashMap`  L61
- `int i = this.propertyId`  L115
- `ItemInfo itemInfo`  L147
- `HashMap<Integer, ItemInfo> map = this.hashMap`  L148
- `boolean whiteBalance`  L170
- `int i = this.propertyId`  L171
- `boolean whiteBalance`  L195
- `int i = this.propertyId`  L196
- `boolean z = true`  L229

方法（13）：
- `public PropertyTypeInteger(CameraProperties cameraProperties, HashMap<Integer, ItemInfo> hashMap, int propertyId, Context context)`  L27
- `public PropertyTypeInteger(CameraProperties cameraProperties, int propertyId, Context context)`  L35
- `void initItem()`  L42
    - 体内字面量："initItem: "
- `int getCurrentValue()`  L114
- `String getCurrentUiStringInSetting()`  L138
- `String getCurrentUiStringInPreview()`  L146
- `String getCurrentUiStringInSetting(int position)`  L152
- `int getCurrentIcon()`  L156
    - 体内字面量："itemInfo="
- `throw new NullPointerException( 4 )`  L160
- `String[] getValueList()`  L165
- `Boolean setValue(int value)`  L169
- `Boolean setValueByPosition(int position)`  L194
- `Boolean needDisplayByMode(int previewMode)`  L228
### `com.gku.dashcam.icatch.entity.PropertyTypeString`
L12 · [class] public PropertyTypeString · `com/gku/dashcam/icatch/entity/PropertyTypeString.java`

字段/常量（13）：
- `CameraProperties cameraProperties`  L13
- `HashMap<String, ItemInfo> hashMap`  L14
- `int propertyId`  L15
- `String[] valueArrayString`  L16
- `List<String> valueListString`  L17
- `List<String> valueListStringUI`  L18
- `int i = 0`  L39
- `ItemInfo itemInfo`  L62
- `HashMap<String, ItemInfo> map = this.hashMap`  L63
- `ItemInfo itemInfo`  L68
- `HashMap<String, ItemInfo> map = this.hashMap`  L69
- `int i = this.propertyId`  L98
- `boolean z = true`  L99

方法（12）：
- `public PropertyTypeString(CameraProperties cameraProperties, int propertyId, Context context)`  L20
- `void initItem()`  L26
- `String getCurrentValue()`  L57
- `String getCurrentUiStringInSetting()`  L61
- `String getCurrentUiStringInPreview()`  L67
- `String getCurrentUiStringInSetting(int position)`  L73
- `List<String> getValueList()`  L77
- `List<String> getValueListUI()`  L81
- `Boolean setValue(String value)`  L85
- `boolean setValueByPosition(int position)`  L89
- `String[] getValueArrayString()`  L93
- `Boolean needDisplayByMode(int previewMode)`  L97
### `com.gku.dashcam.icatch.entity.SearchedCameraInfo`
L4 · [class] public SearchedCameraInfo · `com/gku/dashcam/icatch/entity/SearchedCameraInfo.java`

字段/常量（4）：
- `String cameraIp`  L5
- `int cameraMode`  L6
- `String cameraName`  L7
- `String uid`  L8

方法（1）：
- `public SearchedCameraInfo(String cameraName, String cameraIp, int cameraMode, String uid)`  L10
### `com.gku.dashcam.icatch.entity.SelectedCameraInfo`
L4 · [class] public SelectedCameraInfo · `com/gku/dashcam/icatch/entity/SelectedCameraInfo.java`

字段/常量（5）：
- `String cameraIp`  L5
- `int cameraMode`  L6
- `String cameraName`  L7
- `String password`  L8
- `String uid`  L9

方法（1）：
- `public SelectedCameraInfo(String cameraName, String cameraIp, int cameraMode, String uid)`  L11
### `com.gku.dashcam.icatch.entity.SettingMenu`
L4 · [class] public SettingMenu · `com/gku/dashcam/icatch/entity/SettingMenu.java`

字段/常量（2）：
- `int name`  L5
- `String value`  L6

方法（3）：
- `public SettingMenu(int name, String value)`  L8
- `int getName()`  L13
- `String getValue()`  L17
### `com.gku.dashcam.icatch.entity.StreamInfo`
L4 · [class] public StreamInfo · `com/gku/dashcam/icatch/entity/StreamInfo.java`

字段/常量（5）：
- `int bitrate`  L5
- `int fps`  L6
- `int height`  L7
- `String mediaCodecType`  L8
- `int width`  L9

方法（2）：
- `public StreamInfo(String mediaCodecType, int width, int height, int bitrate, int fps)`  L11
- `public StreamInfo()`  L19
### `com.gku.dashcam.icatch.hash.PropertyHashMapDynamic`
L19 · [class] public PropertyHashMapDynamic · `com/gku/dashcam/icatch/hash/PropertyHashMapDynamic.java`

字段/常量（19）：
- `PropertyHashMapDynamic propertyHashMap`  L20
- `String TAG = "PropertyHashMapDynamic"`  L21
- `String string`  L66
- `String string`  L108
- `String str`  L132
- `String string`  L152
- `String string`  L185
- `String string`  L203
- `String string`  L221
- `String string`  L239
- `String string`  L336
- `int i2 = iIntValue % 1000`  L349
- `List<Integer> listConvertImageSizes`  L359
- `String str`  L360
- `String str`  L402
- `String str2 = null`  L403
- `String str3 = strArrSplit[0]`  L413
- `String str4 = strArrSplit[1]`  L414
- `String str = strArrSplit[0] + StringUtils.SPACE + strArrSplit[1] + "fps"`  L469

方法（21）：
- `PropertyHashMapDynamic getInstance()`  L23
- `HashMap<Integer, ItemInfo> getDynamicHashInt(CameraProperties cameraProperties, int propertyId)`  L30
- `HashMap<Integer, ItemInfo> getFbPreviewMap(CameraProperties cameraProperties)`  L65
- `HashMap<Integer, ItemInfo> getGSensorMap(CameraProperties cameraProperties)`  L107
- `HashMap<Integer, ItemInfo> getSpeedUnitMap(CameraProperties cameraProperties)`  L131
- `HashMap<Integer, ItemInfo> getLanguageMap(CameraProperties cameraProperties)`  L151
- `HashMap<Integer, ItemInfo> getMotionDetectMap(CameraProperties cameraProperties)`  L184
- `HashMap<Integer, ItemInfo> getAudioRecordMap(CameraProperties cameraProperties)`  L202
- `HashMap<Integer, ItemInfo> getBeepSoundMap(CameraProperties cameraProperties)`  L220
- `HashMap<Integer, ItemInfo> getBootSoundMap(CameraProperties cameraProperties)`  L238
- `HashMap<Integer, ItemInfo> getAutoPowerOffMap(CameraProperties cameraProperties)`  L256
    - 体内字面量："s" · "PropertyHashMapDynamic" · "autoPowerOffList ii=" · " value="
- `HashMap<Integer, ItemInfo> getScreenSaverMap(CameraProperties cameraProperties)`  L269
    - 体内字面量："s" · "PropertyHashMapDynamic" · "screenSaverList ii=" · " value="
- `HashMap<String, ItemInfo> getDynamicHashString(CameraProperties cameraProperties, int propertyId)`  L282
- `HashMap<Integer, ItemInfo> getFastMotionMovieMap(CameraProperties cameraProperties)`  L298
    - 体内字面量："x" · "PropertyHashMapDynamic" · "fastMotionMovieList ii=" · " value="
- `HashMap<Integer, ItemInfo> getCaptureDelayMap(CameraProperties cameraProperties)`  L311
    - 体内字面量："PropertyHashMapDynamic" · "delyaList.get(ii) =="
- `HashMap<Integer, ItemInfo> getExposureCompensationMap(CameraProperties cameraProperties)`  L322
    - 体内字面量："PropertyHashMapDynamic" · "exposureCompensationList ii=" · " value=" · " temp="
- `HashMap<Integer, ItemInfo> getVideoFileLengthMap(CameraProperties cameraProperties)`  L335
- `HashMap<String, ItemInfo> getImageSizeMap(CameraProperties cameraProperties)`  L358
- `HashMap<String, ItemInfo> getVideoSizeMap(CameraProperties cameraProperties)`  L382
    - 体内字面量："PropertyHashMapDynamic" · "videoSizeList_" · " = " · "PropertyHashMapDynamic" · "end initVideoSizeMap videoSizeList size=" · " videoSizeMap size="
- `String getAbbreviation(String videoSize)`  L401
- `String getFullName(String videoSize)`  L459
    - 体内字面量："PropertyHashMapDynamic" · "getFullName videoSize is null!" · "PropertyHashMapDynamic" · "getFullName videoSize æ ¼å¼ä¸æ­£ç¡®!"
### `com.gku.dashcam.icatch.hash.PropertyHashMapStatic`
L9 · [class] public PropertyHashMapStatic · `com/gku/dashcam/icatch/hash/PropertyHashMapStatic.java`

字段/常量（2）：
- `PropertyHashMapStatic propertyHashMap`  L10
- `String tag = "PropertyHashMapStatic"`  L11

方法（11）：
- `PropertyHashMapStatic getInstance()`  L23
- `void initPropertyHashMap()`  L30
- `void initCameraSwitch()`  L42
- `void ininTimeLapseMode()`  L47
- `void initWhiteBalanceMap()`  L52
- `void initTimeLapseDuration()`  L60
- `void initSlowMotion()`  L71
- `void initUpside()`  L76
- `void initBurstMap()`  L81
- `void initElectricityFrequencyMap()`  L92
- `void initDateStampMap()`  L97
### `com.gku.dashcam.icatch.listener.EndlessRecyclerOnScrollListener`
L7 · [class] public abstract EndlessRecyclerOnScrollListener · extends `RecyclerView.OnScrollListener` · `com/gku/dashcam/icatch/listener/EndlessRecyclerOnScrollListener.java`

字段/常量（1）：
- `boolean isSlidingUpward = false`  L8

方法（3）：
- `void onLoadMore()`  L10
- `void onScrollStateChanged(RecyclerView recyclerView, int newState)`  L13 @Override
- `void onScrolled(RecyclerView recyclerView, int dx, int dy)`  L22 @Override
### `com.gku.dashcam.icatch.listener.OnProgressBarListener`
L4 · [interface] public OnProgressBarListener · `com/gku/dashcam/icatch/listener/OnProgressBarListener.java`

方法（1）：
- `void onProgressChange(int current, int max)`  L5
### `com.gku.dashcam.icatch.listener.OnRecyclerItemClickListener`
L10 · [class] public abstract OnRecyclerItemClickListener · implements `RecyclerView.OnItemTouchListener` · `com/gku/dashcam/icatch/listener/OnRecyclerItemClickListener.java`

字段/常量（2）：
- `GestureDetectorCompat mGestureDetector`  L11
- `RecyclerView recyclerView`  L12

方法（6）：
- `void onItemClick(int position, View view, RecyclerView.ViewHolder viewHolder)`  L14
- `void onItemLongClick(int position, View view, RecyclerView.ViewHolder viewHolder)`  L16
- `void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept)`  L19 @Override
- `public OnRecyclerItemClickListener(RecyclerView recyclerView)`  L22
- `boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e)`  L28 @Override
- `void onTouchEvent(RecyclerView rv, MotionEvent e)`  L34 @Override
### `com.gku.dashcam.icatch.listener.OnRecyclerItemClickListener$ItemTouchHelperGestureListener`
L38 · [class] private ItemTouchHelperGestureListener · extends `GestureDetector.SimpleOnGestureListener` · `com/gku/dashcam/icatch/listener/OnRecyclerItemClickListener.java`

方法（3）：
- `private ItemTouchHelperGestureListener()`  L39
- `boolean onSingleTapUp(MotionEvent e)`  L43 @Override
- `void onLongPress(MotionEvent e)`  L54 @Override
### `com.gku.dashcam.icatch.listener.OnSettingCompleteListener`
L4 · [interface] public OnSettingCompleteListener · `com/gku/dashcam/icatch/listener/OnSettingCompleteListener.java`

方法（3）：
- `void onOptionSettingComplete()`  L5
- `void settingTimeLapseModeComplete(int previewMode)`  L7
- `void settingVideoSizeComplete()`  L9
### `com.gku.dashcam.icatch.listener.OnStatusChangedListener`
L6 · [interface] public OnStatusChangedListener · `com/gku/dashcam/icatch/listener/OnStatusChangedListener.java`

方法（2）：
- `void onChangeOperationMode(OperationMode curOperationMode)`  L7
- `void onSelectedItemsCountChanged(int SelectedNum)`  L9
### `com.gku.dashcam.icatch.listener.ScreenListener`
L11 · [class] public ScreenListener · `com/gku/dashcam/icatch/listener/ScreenListener.java`

字段/常量（5）：
- `Context mContext`  L12
- `ScreenStateListener mScreenStateListener`  L13
- `String TAG = "ScreenListener"`  L14
- `ScreenStateListener screenStateListener = this.mScreenStateListener`  L58
- `ScreenStateListener screenStateListener2 = this.mScreenStateListener`  L65

方法（5）：
- `public ScreenListener(Context context)`  L25
- `void begin(ScreenStateListener listener)`  L50
- `void getScreenState()`  L56
    - 体内字面量："power"
- `void unregisterListener()`  L71
- `void registerListener()`  L75
    - 体内字面量："android.intent.action.SCREEN_ON" · "android.intent.action.SCREEN_OFF" · "android.intent.action.USER_PRESENT"
### `com.gku.dashcam.icatch.listener.ScreenListener$ScreenBroadcastReceiver`
L29 · [class] private ScreenBroadcastReceiver · extends `BroadcastReceiver` · `com/gku/dashcam/icatch/listener/ScreenListener.java`

字段/常量（1）：
- `String action`  L30

方法（2）：
- `private ScreenBroadcastReceiver()`  L32
- `void onReceive(Context context, Intent intent)`  L37 @Override
    - 体内字面量："android.intent.action.SCREEN_ON" · "android.intent.action.SCREEN_OFF" · "android.intent.action.USER_PRESENT"
### `com.gku.dashcam.icatch.listener.ScreenListener$ScreenStateListener`
L17 · [interface] public ScreenStateListener · `com/gku/dashcam/icatch/listener/ScreenListener.java`

方法（3）：
- `void onScreenOff()`  L18
- `void onScreenOn()`  L20
- `void onUserPresent()`  L22
### `com.gku.dashcam.icatch.listener.VideoFramePtsChangedListener`
L4 · [interface] public VideoFramePtsChangedListener · `com/gku/dashcam/icatch/listener/VideoFramePtsChangedListener.java`

方法（1）：
- `void onFramePtsChanged(double pts)`  L5
### `com.gku.dashcam.icatch.LocalSession`
L12 · [class] public LocalSession · `com/gku/dashcam/icatch/LocalSession.java`

字段/常量（10）：
- `String TAG = "LocalSession"`  L13
- `LocalSession instance`  L14
- `CommandSession commandSession`  L15
- `ICatchCameraPlayback iCatchCameraPlayback`  L16
- `PanoramaControl panoramaControl`  L17
- `PanoramaPhotoPlayback panoramaPhotoPlayback`  L18
- `PanoramaSession panoramaSession`  L19
- `PanoramaVideoPlayback panoramaVideoPlayback`  L20
- `PanoramaSession panoramaSession = this.panoramaSession`  L42
- `CommandSession commandSession = this.commandSession`  L67

方法（12）：
- `LocalSession getInstance()`  L22
- `private LocalSession()`  L29
- `boolean preparePanoramaSession()`  L32
- `boolean destroyPanoramaSession()`  L41
- `void initPanorama()`  L51
- `boolean prepareCommandSession()`  L57
- `boolean destroyCommandSession()`  L66
- `void initCommand()`  L76
- `PanoramaVideoPlayback getPanoramaVideoPlayback()`  L84
- `PanoramaPhotoPlayback getPanoramaPhotoPlayback()`  L88
- `ICatchCameraPlayback getICatchCameraPlayback()`  L92
- `PanoramaControl getPanoramaControl()`  L96
### `com.gku.dashcam.icatch.message.AppMessage`
L4 · [class] public AppMessage · `com/gku/dashcam/icatch/message/AppMessage.java`

字段/常量（38）：
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
- `int FUNCTION_MESSAGE = 4096`  L17
- `int GOOGLE_LOGIN_SUCCEED = 6`  L18
- `int LAUNCH_ACTIVITY = 0`  L19
- `int LOCAL_ACTIVITY = 256`  L20
- `int LOCAL_VIDEO_PBACTIVITY = 1536`  L21
- `int MESSAGE_CAMERA_CONNECTING_START = 5`  L22
- `int MESSAGE_CAMERA_CONNECT_FAIL = 3`  L23
- `int MESSAGE_CAMERA_CONNECT_SUCCESS = 4`  L24
- `int MESSAGE_CAMERA_SCAN_TIME_OUT = 2`  L25
- `int MESSAGE_CANCEL_DOWNLOAD_SINGLE = 769`  L26
- `int MESSAGE_CANCEL_VIDEO_DOWNLOAD = 1541`  L27
- `int MESSAGE_CONNECTED = 4100`  L28
- `int MESSAGE_DELETE_CAMERA = 1`  L29
- `int MESSAGE_DISCONNECTED = 4099`  L30
- `int MESSAGE_LIVE_NETWORK_DISCONNECT = 514`  L31
- `int MESSAGE_UPDATE_VIDEOPB_BAR = 1540`  L32
- `int MESSAGE_VIDEO_STREAM_CODEC_INFO = 1543`  L33
- `int MESSAGE_VIDEO_STREAM_NO_EIS_INFORMATION = 1542`  L34
- `int MPB_ACTIVITY = 768`  L35
- `int OPEN_WIFI_HOTSPOT_FAILED = 4102`  L36
- `int PHOTO_PBACTIVITY = 1024`  L37
- `int PREVIEW_ACTIVITY = 512`  L38
- `int SETTING_OPTION_AUTO_DOWNLOAD = 513`  L39
- `int UPDATE_LOADING_PROGRESS = 770`  L40
- `int UPDATE_TOTAL_PROGRESS = 773`  L41
- `int VIDEO_PBACTIVITY = 1280`  L42
### `com.gku.dashcam.icatch.mode.CameraNetworkMode`
L6 · [class] public final CameraNetworkMode · `com/gku/dashcam/icatch/mode/CameraNetworkMode.java`

字段/常量（3）：
- `int AP = 1`  L7
- `int ETHERNET = 2`  L8
- `int STATION = 0`  L9

方法（2）：
- `String getModeConvert(int mode)`  L12
- `void initNetworkModeMap()`  L19
    - 体内字面量："Station" · "AP" · "Ethernet"
### `com.gku.dashcam.icatch.mode.LiveMode`
L4 · [enum] public LiveMode · `com/gku/dashcam/icatch/mode/LiveMode.java`

枚举常量（1）：
- `MODE_OTHER_LIVE()`  L5
### `com.gku.dashcam.icatch.mode.OperationMode`
L4 · [enum] public OperationMode · `com/gku/dashcam/icatch/mode/OperationMode.java`

枚举常量（1）：
- `MODE_BROWSE()`  L5
### `com.gku.dashcam.icatch.mode.PreviewLaunchMode`
L4 · [class] public PreviewLaunchMode · `com/gku/dashcam/icatch/mode/PreviewLaunchMode.java`

字段/常量（2）：
- `int RT_PREVIEW_MODE = 2`  L5
- `int VIDEO_PB_MODE = 1`  L6
### `com.gku.dashcam.icatch.mode.PreviewMode`
L4 · [class] public PreviewMode · `com/gku/dashcam/icatch/mode/PreviewMode.java`

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
### `com.gku.dashcam.icatch.mode.TouchMode`
L4 · [enum] public TouchMode · `com/gku/dashcam/icatch/mode/TouchMode.java`

枚举常量（3）：
- `MOVE()`  L5
- `DRAG()`  L6
- `NONE()`  L7
### `com.gku.dashcam.icatch.mode.VideoPbMode`
L4 · [enum] public VideoPbMode · `com/gku/dashcam/icatch/mode/VideoPbMode.java`

枚举常量（2）：
- `MODE_VIDEO_PLAY()`  L5
- `MODE_VIDEO_IDLE()`  L6
### `com.gku.dashcam.icatch.PanoramaSession`
L14 · [class] public PanoramaSession · `com/gku/dashcam/icatch/PanoramaSession.java`

字段/常量（5）：
- `String TAG = "PanoramaSession"`  L15
- `ICatchPancamSession iCatchPancamSession`  L16
- `boolean zPrepareSession`  L19
- `ICatchPancamSession iCatchPancamSession = this.iCatchPancamSession`  L37
- `boolean zDestroySession = false`  L38

方法（3）：
- `boolean prepareSession(ICatchITransport transport)`  L18
- `ICatchPancamSession getSession()`  L32
- `boolean destroySession()`  L36
### `com.gku.dashcam.icatch.PbDownloadManager`
L29 · [class] public PbDownloadManager · `com/gku/dashcam/icatch/PbDownloadManager.java`

字段/常量（19）：
- `String TAG = "PbDownloadManager"`  L30
- `AlertDialog.Builder builder`  L31
- `AlertDialog cancelDownloadDialog`  L32
- `Context context`  L33
- `ICatchFile curDownloadFile`  L34
- `ICatchFile currentDownloadFile`  L35
- `CustomDownloadDialog customDownloadDialog`  L36
- `LinkedList<ICatchFile> downloadChooseList`  L37
- `DownloadManagerAdapter downloadManagerAdapter`  L38
- `long downloadProgress`  L39
- `Timer downloadProgressTimer`  L40
- `LinkedList<ICatchFile> downloadTaskList`  L41
- `ExecutorService executor`  L42
- `int downloadFailed = 0`  L44
- `int downloadSucceed = 0`  L45
- `String curFilePath = "<binary/metadata>"`  L46
- `int i = msg.what`  L50
- `CustomDownloadDialog customDownloadDialog`  L148
- `AlertDialog alertDialog = this.cancelDownloadDialog`  L226

方法（14）：
- `void handleMessage(Message msg)`  L49 @Override
- `public PbDownloadManager(Context context, LinkedList<ICatchFile> downloadList)`  L103
- `void show()`  L114
- `void showDownloadManagerDialog()`  L126
- `void onClick(ICatchFile downloadFile)`  L131 @Override
- `void onClick(View arg0)`  L140 @Override
- `void cancelDownload(ICatchFile downloadFile)`  L147
- `void alertForQuitDownload()`  L174
- `void onClick(DialogInterface dialog, int which)`  L183 @Override
- `void onClick(DialogInterface dialog, int which)`  L206 @Override
- `void singleDownloadComplete(boolean result, ICatchFile iCatchFile)`  L216
- `void downloadCompleted()`  L225
- `void onClick(DialogInterface dialog, int which)`  L236 @Override
- `void updateDownloadMessage()`  L366
    - 体内字面量："$1$" · "$2$" · "$3$"
### `com.gku.dashcam.icatch.PbDownloadManager$DownloadAsyncTask`
L281 · [class] DownloadAsyncTask · extends `AsyncTask<String, Integer, Boolean>` · `com/gku/dashcam/icatch/PbDownloadManager.java`

字段/常量（7）：
- `ICatchFile downloadFile`  L282
- `String fileName`  L283
- `String filePath`  L284
- `String TAG = "DownloadAsyncTask "`  L285
- `String fileType = null`  L286
- `PbDownloadManager pbDownloadManager = PbDownloadManager.this`  L349
- `PbDownloadManager pbDownloadManager2 = PbDownloadManager.this`  L351

方法（4）：
- `void onProgressUpdate(Integer... progress)`  L290 @Override
- `public DownloadAsyncTask(ICatchFile iCatchFile)`  L293
    - 体内字面量："/" · "/"
- `Boolean doInBackground(String... params)`  L308 @Override
    - 体内字面量：".mov" · ".MOV" · "video/quicktime" · "video/mp4"
- `void onPostExecute(Boolean result)`  L338 @Override
### `com.gku.dashcam.icatch.PbDownloadManager$DownloadProgressTask`
L245 · [class] DownloadProgressTask · extends `TimerTask` · `com/gku/dashcam/icatch/PbDownloadManager.java`

字段/常量（1）：
- `ICatchFile iCatchFile = PbDownloadManager.this.curDownloadFile`  L254

方法（2）：
- `void run()`  L250 @Override
- `void run()`  L272 @Override
### `com.gku.dashcam.icatch.PhotoCapture`
L10 · [class] public PhotoCapture · `com/gku/dashcam/icatch/PhotoCapture.java`

字段/常量（10）：
- `String TAG = "PhotoCapture"`  L11
- `int TYPE_BURST_CAPTURE = 1`  L12
- `int TYPE_NORMAL_CAPTURE = 2`  L13
- `CameraAction cameraAction`  L14
- `CameraProperties cameraProperties`  L15
- `MediaPlayer continuousCaptureBeep`  L16
- `MediaPlayer delayBeep`  L17
- `OnCaptureListener onCaptureListener`  L18
- `OnStopPreviewListener onStopPreviewListener`  L19
- `MediaPlayer stillCaptureStartBeep`  L20

方法（3）：
- `void startCapture()`  L30
- `void addOnStopPreviewListener(OnStopPreviewListener onStopPreviewListener)`  L87
- `void setOnCaptureListener(OnCaptureListener onCaptureListener)`  L91
### `com.gku.dashcam.icatch.PhotoCapture$CaptureAudioTask`
L95 · [class] private CaptureAudioTask · extends `TimerTask` · `com/gku/dashcam/icatch/PhotoCapture.java`

字段/常量（2）：
- `int burstNumber`  L96
- `int type`  L97

方法（2）：
- `public CaptureAudioTask(int burstNumber, int type)`  L99
- `void run()`  L105 @Override
### `com.gku.dashcam.icatch.PhotoCapture$CaptureThread`
L34 · [class] CaptureThread · implements `Runnable` · `com/gku/dashcam/icatch/PhotoCapture.java`

字段/常量（3）：
- `int i`  L40
- `int i2 = 0`  L44
- `int i3 = currentCaptureDelay / 1000`  L62

方法（2）：
- `void run()`  L39 @Override
- `void run()`  L49 @Override
### `com.gku.dashcam.icatch.PhotoCapture$DelayTimerTask`
L125 · [class] private DelayTimerTask · extends `TimerTask` · `com/gku/dashcam/icatch/PhotoCapture.java`

字段/常量（4）：
- `int count`  L126
- `Timer timer`  L127
- `int i = this.count`  L136
- `Timer timer = this.timer`  L142

方法（2）：
- `public DelayTimerTask(int count, Timer timer)`  L129
- `void run()`  L135 @Override
### `com.gku.dashcam.icatch.PhotoCapture$OnCaptureListener`
L22 · [interface] public OnCaptureListener · `com/gku/dashcam/icatch/PhotoCapture.java`

方法（1）：
- `void onCompleted()`  L23
### `com.gku.dashcam.icatch.PhotoCapture$OnStopPreviewListener`
L26 · [interface] public OnStopPreviewListener · `com/gku/dashcam/icatch/PhotoCapture.java`

方法（1）：
- `void onStop()`  L27
### `com.gku.dashcam.icatch.presenter.BasePresenter`
L14 · [class] public abstract BasePresenter · `com/gku/dashcam/icatch/presenter/BasePresenter.java`

字段/常量（2）：
- `Activity activity`  L15
- `String tag = "BasePresenter"`  L16

方法（8）：
- `public BasePresenter(Activity activity)`  L18
- `void initCfg()`  L22
- `void redirectToAnotherActivity(Context context, Class<?> cls)`  L28
- `void finishActivity()`  L34
- `void isAppBackground()`  L38
- `void submitAppInfo()`  L44
- `void removeActivity()`  L49
- `void showOptionIcon(Menu menu)`  L55
    - 体内字面量："MenuBuilder" · "setOptionalIconsVisible" · "onMenuOpened...unable to set icons for overflow menu"
### `com.gku.dashcam.icatch.presenter.MultiPbFragmentPresenter`
L41 · [class] public MultiPbFragmentPresenter · extends `BasePresenter` · `com/gku/dashcam/icatch/presenter/MultiPbFragmentPresenter.java`

字段/常量（30）：
- `String TAG`  L42
- `Activity activity`  L43
- `int curIndex`  L44
- `PhotoWallLayoutType curLayoutType`  L45
- `OperationMode curOperationMode`  L46
- `FileOperation fileOperation`  L47
- `int fileTotalNum`  L48
- `FileType fileType`  L49
- `Fragment fragment`  L50
- `Handler handler`  L51
- `boolean isMore`  L52
- `int maxNum`  L53
- `MultiPbFragmentView multiPbPhotoView`  L54
- `boolean needGetFileNumRemote`  L55
- `List<MultiPbItemInfo> pbItemInfoList`  L56
- `MultiPbRecyclerViewAdapter recyclerViewAdapter`  L57
- `boolean supportSegmentedLoading`  L58
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter = this.recyclerViewAdapter`  L114
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter2 = this.recyclerViewAdapter`  L121
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter3 = MultiPbFragmentPresenter.this.recyclerViewAdapter`  L137
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter3 = this.recyclerViewAdapter`  L145
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L264
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter = this.recyclerViewAdapter`  L268
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L309
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L321
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter = this.recyclerViewAdapter`  L325
- `OperationMode operationMode = OperationMode.MODE_EDIT`  L359
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L370
- `int selectedCount`  L411
- `FileType fileType = this.fileType`  L449

方法（30）：
- `public MultiPbFragmentPresenter(Activity activity, FileType fileType)`  L64
    - 体内字面量："MultiPbFragmentPresenter"
- `void setView(MultiPbFragmentView pbFragmentView)`  L81
- `void setFragment(Fragment fragment)`  L86
- `void resetCurIndex()`  L90
- `void resetAdpter()`  L94
- `List<MultiPbItemInfo> getRemotePhotoInfoList()`  L98
- `void getRemotePhotoInfoList(RemoteFileHelper.DataCallBack dataCallBack)`  L109
- `void loadMoreFile()`  L113
- `void run()`  L128 @Override
- `void run()`  L136 @Override
- `void loadPhotoWall()`  L257
- `void setAdapter()`  L262
- `int compare(Object obj, Object obj2)`  L275 @Override
- `int lambda$setAdapter$0(MultiPbItemInfo multiPbItemInfo, MultiPbItemInfo multiPbItemInfo2)`  L284
- `void setPbItemInfoList(List<MultiPbItemInfo> transportList)`  L291
    - 体内字面量："deletePbItemInfoList: "
- `void refreshPhotoWall()`  L306
    - 体内字面量："1122" · "refreshPhotoWall" · "refreshPhotoWall + pbItemInfoList: "
- `void refreshAdapter()`  L319
- `void setLayoutType(PhotoWallLayoutType layoutType)`  L335
- `void changePreviewType(PhotoWallLayoutType layoutType)`  L352
- `void enterEditMode(int position)`  L357
- `void quitEditMode()`  L368
- `void itemClick(final int position)`  L377
    - 体内字面量："curFilePosition" · "fileType"
- `void run()`  L394 @Override
    - 体内字面量："curFilePosition" · "fileType"
- `void selectOrCancelAll(boolean isSelectAll)`  L410
- `List<MultiPbItemInfo> getSelectedList()`  L425
- `void emptyFileList()`  L429
- `void deleteFile()`  L433
    - 体内字面量："$1$"
- `void onClick(DialogInterface dialog, int which)`  L445 @Override
- `void onClick(DialogInterface dialog, int which)`  L452 @Override
- `void stopLoad()`  L461
### `com.gku.dashcam.icatch.presenter.MultiPbFragmentPresenter$AnonymousClass2`
L153 · [class] AnonymousClass2 · implements `Runnable` · `com/gku/dashcam/icatch/presenter/MultiPbFragmentPresenter.java`

字段/常量（2）：
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter = MultiPbFragmentPresenter.this.recyclerViewAdapter`  L205
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter = MultiPbFragmentPresenter.this.recyclerViewAdapter`  L245

方法（8）：
- `void run()`  L158 @Override
- `void run()`  L177 @Override
- `void run()`  L187 @Override
- `void run()`  L201 @Override
- `void success(List<MultiPbItemInfo> multiPbItemInfo)`  L213 @Override
- `void run()`  L222 @Override
- `void finish(final int size)`  L232 @Override
- `void run()`  L238 @Override
### `com.gku.dashcam.icatch.presenter.MultiPbFragmentPresenter$DeleteFileThread`
L465 · [class] private DeleteFileThread · implements `Runnable` · `com/gku/dashcam/icatch/presenter/MultiPbFragmentPresenter.java`

字段/常量（6）：
- `ICatchCameraSession cameraSession`  L466
- `List<MultiPbItemInfo> deleteSucceedList`  L467
- `List<MultiPbItemInfo> fileList`  L468
- `FileType fileType`  L469
- `ICatchITransport transport`  L470
- `String currentStringPropertyValue`  L481

方法（3）：
- `public DeleteFileThread(List<MultiPbItemInfo> fileList, FileType fileType)`  L474
- `void run()`  L480 @Override
- `void run()`  L515 @Override
### `com.gku.dashcam.icatch.presenter.MultiPbFragmentPresenter$OnGetListCompleteListener`
L60 · [interface] public OnGetListCompleteListener · `com/gku/dashcam/icatch/presenter/MultiPbFragmentPresenter.java`

方法（1）：
- `void onGetFileListComplete()`  L61
### `com.gku.dashcam.icatch.presenter.PhotoPbPresenter`
L55 · [class] public PhotoPbPresenter · extends `BasePresenter implements SensorEventListener` · implements `SensorEventListener` · `com/gku/dashcam/icatch/presenter/PhotoPbPresenter.java`

字段/常量（59）：
- `int DIRECTION_LEFT = 2`  L56
- `int DIRECTION_RIGHT = 1`  L57
- `int DIRECTION_UNKNOWN = 4`  L58
- `float FIXED_INSIDE_DISTANCE = 0.45454544f`  L59
- `float FIXED_INSIDE_FOCUS = 2.0f`  L60
- `float FIXED_NEAR_DISTANCE = 0.6f`  L61
- `float FIXED_OUTSIDE_DISTANCE = 2.0f`  L62
- `float FIXED_OUTSIDE_FOCUS = 1.0f`  L63
- `float MAX_ZOOM = 2.2f`  L64
- `float MIN_ZOOM = 0.5f`  L65
- `String TAG`  L66
- `Activity activity`  L67
- `float afterLenght`  L68
- `float beforeLenght`  L69
- `String curFilePath`  L70
- `int curPanoramaType`  L71
- `int curPhotoIdx`  L72
- `float currentZoomRate`  L73
- `List<MultiPbItemInfo> deleteSuccessFileList`  L74
- `long downloadProcess`  L75
- `String downloadingFilename`  L76
- `long downloadingFilesize`  L77
- `ExecutorService executor`  L78
- `ArrayList<MultiPbItemInfo> fileList`  L79
- `FileOperation fileOperation`  L80
- `Future<Object> future`  L81
- `Sensor gyroscopeSensor`  L82
- `Handler handler`  L83
- `boolean hasDeleted`  L84
- `ICatchSurfaceContext iCatchSurfaceContext`  L85
- `boolean isScrolling`  L86
- `MultiPbItemInfo itemFile`  L87
- `int lastItem`  L88
- `float mPreviousX`  L89
- `float mPreviousY`  L90
- `PanoramaPhotoPlayback panoramaPhotoPlayback`  L91
- `PhotoPbView photoPbView`  L92
- `List<MultiPbItemInfo> remainFileList`  L93
- `SensorManager sensorManager`  L94
- `boolean surfaceCreated`  L95
- `int tempLastItem`  L96
- `TouchMode touchMode`  L97
- `PhotoPbViewPagerAdapter viewPagerAdapter`  L98
- `int i = this.curPhotoIdx`  L173
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L367
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L390
- `PanoramaPhotoPlayback panoramaPhotoPlayback = this.panoramaPhotoPlayback`  L421
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L423
- `float f = this.currentZoomRate`  L474
- `float f2 = f * scale`  L477
- `float f3 = f * scale`  L480
- `float f4 = f * scale`  L492
- `float f = event.values[0]`  L519
- `float f2 = event.values[1]`  L520
- `float f3 = event.values[2]`  L521
- `SensorManager sensorManager = this.sensorManager`  L542
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L549
- `PanoramaPhotoPlayback panoramaPhotoPlayback = this.panoramaPhotoPlayback`  L587
- `int i = this.curPanoramaType`  L602

方法（49）：
- `void onAccuracyChanged(Sensor sensor, int accuracy)`  L101 @Override
- `public PhotoPbPresenter(Activity activity)`  L104
    - 体内字面量："PhotoPbPresenter"
- `void setView(PhotoPbView photoPbView)`  L123
    - 体内字面量："curFilePosition"
- `void loadPanoramaImage()`  L134
- `void initView()`  L138
- `void onPhotoTap()`  L144 @Override
- `void showBar()`  L154
- `void delete()`  L164
- `void download()`  L168
- `void loadPreviousImage()`  L172
- `void loadNextImage()`  L180
- `void back()`  L187
    - 体内字面量："Remain_FileList" · "hasDeleted" · "fileType"
- `void updateUi()`  L331
    - 体内字面量："/"
- `List<MultiPbItemInfo> getDeletedFileList()`  L342
- `List<MultiPbItemInfo> getRemainFileList()`  L346
- `void showDownloadEnsureDialog()`  L350
    - 体内字面量："$1$" · "$3$" · "$2$"
- `void onClick(DialogInterface dialog, int whichButton)`  L358 @Override
- `void onClick(DialogInterface dialog, int whichButton)`  L373 @Override
- `void showDeleteEnsureDialog()`  L380
- `void onClick(DialogInterface dialog, int whichButton)`  L386 @Override
- `void onClick(DialogInterface dialog, int whichButton)`  L396 @Override
- `void setShowArea(Surface surface)`  L403
- `void insidePanorama()`  L410
- `void locate(float distance)`  L414
- `void clearImage(int iCatchSphereType)`  L418
- `void rotateB(MotionEvent e, float prevX, float prevY)`  L432
- `void onSufaceViewTouchDown(MotionEvent event)`  L436
- `void onSufaceViewPointerDown(MotionEvent event)`  L444
    - 体内字面量："2222" · "event.getPointerCount()................="
- `void onSufaceViewTouchMove(MotionEvent event)`  L452
- `float getDistance(MotionEvent event)`  L467
- `void setScale(float scale)`  L473
- `void zoom(float currentZoomRate)`  L504
- `void onSufaceViewTouchUp()`  L508
- `void onSufaceViewTouchPointerUp()`  L512
- `void onSensorChanged(SensorEvent event)`  L517 @Override
- `void rotate(float speedX, float speedY, float speedZ, long timestamp)`  L528
- `void registerGyroscopeSensor()`  L533
    - 体内字面量："sensor"
- `void removeGyroscopeListener()`  L541
- `void setDrawingArea(int windowW, int windowH)`  L548
- `void loadPanoramaPhoto(final MultiPbItemInfo itemInfo)`  L559
- `void onLoadingFailed(String imageUri, View view)`  L563 @Override
- `void onLoadingStarted(String imageUri, View view)`  L567 @Override
- `void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)`  L571 @Override
- `void release()`  L586
- `void initPanorama()`  L593
- `void setPanoramaType()`  L597
- `void setSdCardEventListener()`  L622
- `void eventListener(int sdkEventId)`  L625 @Override
- `void onSure()`  L632 @Override
### `com.gku.dashcam.icatch.presenter.PhotoPbPresenter$DeleteThread`
L283 · [class] private DeleteThread · implements `Runnable` · `com/gku/dashcam/icatch/presenter/PhotoPbPresenter.java`

字段/常量（3）：
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L289
- `PhotoPbPresenter photoPbPresenter2 = PhotoPbPresenter.this`  L291
- `ICatchFile iCatchFile = PhotoPbPresenter.this.itemFile.iCatchFile`  L293

方法（4）：
- `private DeleteThread()`  L284
- `void run()`  L288 @Override
- `void run()`  L300 @Override
- `void run()`  L308 @Override
### `com.gku.dashcam.icatch.presenter.PhotoPbPresenter$DownloadThread`
L238 · [class] private DownloadThread · implements `Runnable` · `com/gku/dashcam/icatch/presenter/PhotoPbPresenter.java`

字段/常量（4）：
- `String TAG`  L239
- `int curIdx`  L240
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L254
- `PhotoPbPresenter photoPbPresenter2 = PhotoPbPresenter.this`  L257

方法（4）：
- `private DownloadThread()`  L242
    - 体内字面量："DownloadThread"
- `void run()`  L248 @Override
    - 体内字面量："/"
- `void run()`  L262 @Override
    - 体内字面量："$1$"
- `void run()`  L274 @Override
### `com.gku.dashcam.icatch.presenter.PhotoPbPresenter$MyViewPagerOnPagerChangeListener`
L200 · [class] private MyViewPagerOnPagerChangeListener · implements `ViewPager.OnPageChangeListener` · `com/gku/dashcam/icatch/presenter/PhotoPbPresenter.java`

字段/常量（4）：
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L208
- `PhotoPbPresenter photoPbPresenter2 = PhotoPbPresenter.this`  L215
- `PhotoPbPresenter photoPbPresenter3 = PhotoPbPresenter.this`  L218
- `int unused = PhotoPbPresenter.this.lastItem`  L227

方法（4）：
- `private MyViewPagerOnPagerChangeListener()`  L201
- `void onPageScrollStateChanged(int arg0)`  L205 @Override
- `void onPageScrolled(int arg0, float arg1, int arg2)`  L225 @Override
- `void onPageSelected(int arg0)`  L233 @Override
### `com.gku.dashcam.icatch.presenter.PreviewPresenter`
L79 · [class] public PreviewPresenter · extends `BasePresenter implements SensorEventListener` · implements `SensorEventListener` · `com/gku/dashcam/icatch/presenter/PreviewPresenter.java`

字段/常量（96）：
- `float FIXED_INSIDE_DISTANCE = 0.5f`  L80
- `float FIXED_OUTSIDE_DISTANCE = 3.0f`  L81
- `float MAX_ZOOM = 2.2f`  L82
- `float MIN_ZOOM = 0.4f`  L83
- `String TAG = "PreviewPresenter"`  L84
- `Activity activity`  L85
- `float afterLenght`  L86
- `boolean allowClickButtoms`  L87
- `BaseProperties baseProrertys`  L88
- `float beforeLenght`  L89
- `CameraAction cameraAction`  L90
- `CameraProperties cameraProperties`  L91
- `CameraState cameraState`  L92
- `CameraStreaming cameraStreaming`  L93
- `MediaPlayer continuousCaptureBeep`  L94
- `int curAppStateMode`  L95
- `DashCamera curCamera`  L96
- `String curCodecType`  L97
- `int curIcatchMode`  L98
- `int curPanoramaType`  L99
- `int curVideoFps`  L100
- `int curVideoHeight`  L101
- `int curVideoWidth`  L102
- `int currentSettingMenuMode`  L103
- `float currentZoomRate`  L104
- `FileOperation fileOperation`  L105
- `Sensor gyroscopeSensor`  L106
- `boolean hasInitSurface`  L107
- `ICatchSurfaceContext iCatchSurfaceContext`  L108
- `boolean isConnectiond_failure`  L109
- `boolean isDelEvent`  L110
- `boolean isLive`  L111
- `int lapseTime`  L112
- `long lastCilckTime`  L113
- `long lastRecordTime`  L114
- `float mPreviousX`  L115
- `float mPreviousY`  L116
- `MediaPlayer modeSwitchBeep`  L117
- `PanoramaPreviewPlayback panoramaPreviewPlayback`  L118
- `PreviewHandler previewHandler`  L119
- `PreviewView previewView`  L120
- `Timer recordingLapseTimeTimer`  L121
- `SDKEvent sdkEvent`  L122
- `SensorManager sensorManager`  L123
- `SettingListAdapter settingListAdapter`  L124
- `List<SettingMenu> settingMenuList`  L125
- `MediaPlayer stillCaptureStartBeep`  L126
- `TouchMode touchMode`  L127
- `boolean videoCaptureButtomChangeFlag`  L128
- `Timer videoCaptureButtomChangeTimer`  L129
- `MediaPlayer videoCaptureStartBeep`  L130
- `WifiSSReceiver wifiSSReceiver`  L131
- `ZoomInOut zoomInOut`  L132
- `int i = this.curAppStateMode`  L252
- `int i = this.curAppStateMode`  L535
- `Timer timer = this.videoCaptureButtomChangeTimer`  L603
- `int i = this.curAppStateMode`  L613
- `Timer timer = this.recordingLapseTimeTimer`  L615
- `PreviewView previewView = PreviewPresenter.this.previewView`  L628
- `PreviewPresenter previewPresenter = PreviewPresenter.this`  L629
- `int i2 = previewPresenter.lapseTime`  L630
- `Timer timer = this.recordingLapseTimeTimer`  L643
- `int i = this.curAppStateMode`  L667
- `int i2 = this.curAppStateMode`  L676
- `int i3 = this.curAppStateMode`  L685
- `WifiSSReceiver wifiSSReceiver = this.wifiSSReceiver`  L759
- `int i = this.curAppStateMode`  L767
- `int i = this.curAppStateMode`  L776
- `int i = this.curAppStateMode`  L802
- `List<SettingMenu> list = this.settingMenuList`  L821
- `int i = this.curAppStateMode`  L869
- `DashCamera dashCamera = this.curCamera`  L1036
- `int i = this.curAppStateMode`  L1064
- `List<SettingMenu> list = this.settingMenuList`  L1068
- `SettingListAdapter settingListAdapter = this.settingListAdapter`  L1072
- `List<SettingMenu> list2 = this.settingMenuList`  L1100
- `SettingListAdapter settingListAdapter2 = this.settingListAdapter`  L1104
- `List<SettingMenu> list3 = this.settingMenuList`  L1131
- `SettingListAdapter settingListAdapter3 = this.settingListAdapter`  L1135
- `Tristate tristate = Tristate.NORMAL`  L1170
- `int i = this.curAppStateMode`  L1181
- `int i`  L1245
- `Tristate tristateStart`  L1281
- `StreamInfo streamInfoConvertToStreamInfoBean`  L1335
- `Bitmap pvThumbnail`  L1378
- `DashCamera dashCamera = this.curCamera`  L1379
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L1404
- `float f = this.currentZoomRate`  L1460
- `float f2 = f * scale`  L1463
- `float f3 = f * scale`  L1466
- `float f4 = f * scale`  L1478
- `float f = event.values[0]`  L1506
- `float f2 = event.values[1]`  L1507
- `float f3 = event.values[2]`  L1508
- `SensorManager sensorManager = this.sensorManager`  L1528
- `ICatchSurfaceContext iCatchSurfaceContext`  L1535

方法（87）：
- `void onAccuracyChanged(Sensor sensor, int accuracy)`  L135 @Override
- `public PreviewPresenter(Activity activity)`  L138
- `void setView(PreviewView previewView)`  L159
- `void initData()`  L165
    - 体内字面量："videoWidth" · "videoHeight" · "videoFps" · "videoCodec"
- `void initStatus()`  L201
    - 体内字面量："android.net.wifi.RSSI_CHANGED"
- `void changeCameraMode(final int previewMode, final int ichVideoPreviewMode)`  L217
- `void run()`  L222 @Override
- `void run()`  L227 @Override
- `void redrawSurface()`  L238
- `void startOrStopCapture()`  L250
- `void run()`  L264 @Override
- `void run()`  L275 @Override
- `void run()`  L298 @Override
- `void run()`  L303 @Override
- `void createUIByMode(int appStateMode)`  L395
- `void initPreview()`  L472
- `void eventListener(int sdkEventId)`  L475 @Override
    - 体内字面量："EVENT_RCONNECT_SUCC initData"
- `void run()`  L496 @Override
- `void startVideoCaptureButtomChangeTimer()`  L570
- `void run()`  L573 @Override
- `void run()`  L578 @Override
- `void run()`  L588 @Override
- `void stopVideoCaptureButtomChangeTimer()`  L602
- `void startRecordingLapseTimeTimer(int startTime)`  L611
- `void run()`  L624 @Override
- `void run()`  L627 @Override
- `void stopRecordingLapseTimeTimer()`  L642
- `void changePreviewMode(int previewMode)`  L651
- `void startPhotoCapture()`  L697
- `void onStop()`  L704 @Override
- `void onCompleted()`  L713 @Override
- `void run()`  L716 @Override
- `void run()`  L731 @Override
- `void run()`  L735 @Override
- `boolean disconnectCamera()`  L749
- `void unregisterWifiSSReceiver()`  L758
- `void zoomIn()`  L766
- `void zoomOut()`  L775
- `void zoomBySeekBar()`  L784
- `void onCompleted(final float currentZoomRate)`  L787 @Override
- `void run()`  L790 @Override
- `void showZoomView()`  L801
- `float getMaxZoomRate()`  L811
- `float getZoomViewProgress()`  L815
- `void showSettingDialog(int position)`  L819
- `void settingVideoSizeComplete()`  L827 @Override
- `void onOptionSettingComplete()`  L831 @Override
- `void settingTimeLapseModeComplete(int timeLapseMode)`  L837 @Override
- `void showPvModePopupWindow()`  L857
- `void addEvent()`  L1018
- `void delEvent()`  L1035
- `void loadSettingMenuList()`  L1054
- `void run()`  L1083 @Override
- `void run()`  L1086 @Override
- `void run()`  L1114 @Override
- `void run()`  L1117 @Override
- `void run()`  L1144 @Override
- `void run()`  L1147 @Override
- `void isAppBackground()`  L1164 @Override
- `void finishActivity()`  L1169 @Override
- `void redirectToAnotherActivity(final Context context, final Class<?> cls)`  L1210 @Override
- `void run()`  L1233 @Override
- `boolean checkModeSwitch(int appStateMode)`  L1244
- `int getSwitchErrorResId(int appStateMode)`  L1249
- `void startPreview()`  L1280
- `void run()`  L1288 @Override
- `void run()`  L1321 @Override
- `ICatchStreamParam getStreamParam()`  L1334
- `void stopPreview()`  L1354
- `void locate(float progerss)`  L1373
- `void savePvThumbnail()`  L1377
- `void destroyPreview()`  L1394
- `void rotateB(MotionEvent e, float prevX, float prevY)`  L1419
- `void onSufaceViewTouchDown(MotionEvent event)`  L1423
- `void onSufaceViewPointerDown(MotionEvent event)`  L1431
- `void onSufaceViewTouchMove(MotionEvent event)`  L1438
- `float getDistance(MotionEvent event)`  L1453
- `void setScale(float scale)`  L1459
- `void zoom(float currentZoomRate)`  L1490
- `void onSufaceViewTouchUp()`  L1494
- `void onSufaceViewTouchPointerUp()`  L1499
- `void onSensorChanged(SensorEvent event)`  L1504 @Override
- `void rotate(float speedX, float speedY, float speedZ, long timestamp)`  L1515
- `void registerGyroscopeSensor()`  L1519
    - 体内字面量："sensor"
- `void removeGyroscopeListener()`  L1527
- `void setDrawingArea(int width, int height)`  L1534
- `void initSurface(SurfaceHolder surfaceHolder)`  L1546
### `com.gku.dashcam.icatch.presenter.PreviewPresenter$PreviewHandler`
L881 · [class] private PreviewHandler · extends `Handler` · `com/gku/dashcam/icatch/presenter/PreviewPresenter.java`

字段/常量（2）：
- `Tristate tristate = Tristate.FALSE`  L887
- `int i = msg.what`  L888

方法（4）：
- `private PreviewHandler()`  L882
- `void handleMessage(Message msg)`  L886 @Override
- `void run()`  L903 @Override
- `void run()`  L910 @Override
### `com.gku.dashcam.icatch.presenter.PreviewPresenter$WifiSSReceiver`
L1259 · [class] private WifiSSReceiver · extends `BroadcastReceiver` · `com/gku/dashcam/icatch/presenter/PreviewPresenter.java`

字段/常量（1）：
- `WifiManager wifi`  L1260

方法（3）：
- `public WifiSSReceiver()`  L1262
    - 体内字面量："wifi"
- `void onReceive(Context arg0, Intent arg1)`  L1268 @Override
- `void changeWifiStatusIcon()`  L1272
### `com.gku.dashcam.icatch.presenter.RemoteMultiPbPresenter`
L34 · [class] public RemoteMultiPbPresenter · extends `BasePresenter` · `com/gku/dashcam/icatch/presenter/RemoteMultiPbPresenter.java`

字段/常量（22）：
- `String TAG = "RemoteMultiPbPresenter"`  L35
- `Activity activity`  L36
- `ViewPagerAdapter adapter`  L37
- `PhotoWallLayoutType curLayoutType`  L38
- `OperationMode curOperationMode`  L39
- `boolean curSelectAll`  L40
- `List<BaseMultiPbFragment> fragments`  L41
- `Handler handler`  L42
- `MultiPbView multiPbView`  L43
- `OnStatusChangedListener onStatusChangedListener`  L44
- `List<BaseMultiPbFragment> list = this.fragments`  L106
- `List<BaseMultiPbFragment> list = this.fragments`  L135
- `List<BaseMultiPbFragment> list = this.fragments`  L182
- `BaseMultiPbFragment baseMultiPbFragment`  L193
- `List<BaseMultiPbFragment> list = this.fragments`  L194
- `BaseMultiPbFragment baseMultiPbFragment`  L202
- `List<BaseMultiPbFragment> list = this.fragments`  L204
- `long fileSizeInteger = 0`  L210
- `BaseMultiPbFragment baseMultiPbFragment`  L224
- `List<BaseMultiPbFragment> list = this.fragments`  L226
- `BaseMultiPbFragment baseMultiPbFragment`  L235
- `List<BaseMultiPbFragment> list = this.fragments`  L237

方法（20）：
- `public RemoteMultiPbPresenter(Activity activity)`  L46
- `void onChangeOperationMode(OperationMode operationMode)`  L54 @Override
- `void onSelectedItemsCountChanged(int SelectedNum)`  L70 @Override
    - 体内字面量："$1$"
- `void setView(MultiPbView multiPbView)`  L77
- `void loadViewPager()`  L82
- `void initEditLayout()`  L88
- `void reset()`  L94
- `void initViewpager()`  L105
- `void updateViewpagerStatus(int arg0)`  L125
- `void changePreviewType(PhotoWallLayoutType layoutType)`  L129
- `void back()`  L148
- `void run()`  L159 @Override
- `void selectOrCancel()`  L174
- `void delete()`  L192
- `void download()`  L201
- `void quitEditMode()`  L223
- `void reloadFileList()`  L234
- `void setFileFilter(FileFilter fileFilter)`  L244
- `void setSdCardEventListener()`  L249
- `void eventListener(int sdkEventId)`  L252 @Override
### `com.gku.dashcam.icatch.presenter.VideoPbPresenter`
L64 · [class] public VideoPbPresenter · extends `BasePresenter implements SensorEventListener` · implements `SensorEventListener` · `com/gku/dashcam/icatch/presenter/VideoPbPresenter.java`

字段/常量（50）：
- `float FIXED_INSIDE_DISTANCE = 0.45454544f`  L65
- `float FIXED_OUTSIDE_DISTANCE = 2.0f`  L66
- `float MAX_ZOOM = 2.2f`  L67
- `float MIN_ZOOM = 0.5f`  L68
- `String TAG`  L69
- `Activity activity`  L70
- `float afterLenght`  L71
- `float beforeLenght`  L72
- `boolean cacheFlag`  L73
- `ICatchCameraSession cameraSession`  L74
- `int curPanoramaType`  L75
- `ICatchFile curVideoFile`  L76
- `int curVideoPosition`  L77
- `double currentTime`  L78
- `float currentZoomRate`  L79
- `Timer downloadProgressTimer`  L80
- `boolean enableRender`  L81
- `ExecutorService executor`  L82
- `List<MultiPbItemInfo> fileList`  L83
- `FileOperation fileOperation`  L84
- `FileType fileType`  L85
- `Sensor gyroscopeSensor`  L86
- `VideoPbHandler handler`  L87
- `boolean hasDeleted`  L88
- `int lastSeekBarPosition`  L89
- `float mPreviousX`  L90
- `float mPreviousY`  L91
- `boolean needUpdateSeekBar`  L92
- `PanoramaVideoPlayback panoramaVideoPlayback`  L93
- `List<MultiPbItemInfo> remainFileList`  L94
- `SDKEvent sdkEvent`  L95
- `SensorManager sensorManager`  L96
- `SingleDownloadDialog singleDownloadDialog`  L97
- `TouchMode touchMode`  L98
- `int videoDuration`  L99
- `VideoPbMode videoPbMode`  L100
- `VideoPbView videoPbView`  L101
- `VideoStreaming videoStreaming`  L102
- `Boolean waitForCaching`  L103
- `List<MultiPbItemInfo> list = this.fileList`  L139
- `int i = this.videoDuration`  L282
- `int i2 = i - 100`  L284
- `int i`  L336
- `VideoPbMode videoPbMode = VideoPbMode.MODE_VIDEO_PLAY`  L517
- `float f = this.currentZoomRate`  L817
- `float f2 = f * scale`  L820
- `float f3 = f * scale`  L823
- `float f4 = f * scale`  L835
- `SensorManager sensorManager = this.sensorManager`  L885
- `int i = this.curPanoramaType`  L902

方法（58）：
- `void onAccuracyChanged(Sensor sensor, int accuracy)`  L106 @Override
- `public VideoPbPresenter(Activity activity)`  L109
    - 体内字面量："VideoPbPresenter" · "curFilePosition" · "fileType"
- `int compare(MultiPbItemInfo lhs, MultiPbItemInfo rhs)`  L132 @Override
- `void isAppBackground()`  L147 @Override
- `void updatePbSeekbar(double pts)`  L152
- `void setView(VideoPbView videoPbView)`  L159
- `void initView()`  L165
    - 体内字面量："/"
- `void initClint()`  L175
- `void addEventListener()`  L182
- `void removeEventListener()`  L196
- `void play()`  L207
- `void onFramePtsChanged(double pts)`  L216 @Override
    - 体内字面量："currentVideoFile: " · "00:00"
- `void resumeVideoPb()`  L255
- `void pauseVideoPb()`  L265
- `void seekBarOnStopTrackingTouch()`  L277
- `void run()`  L294 @Override
- `void run()`  L304 @Override
- `void run()`  L314 @Override
- `void seekBarOnStartTrackingTouch()`  L327
- `void setTimeLapsedValue(int progress)`  L335
- `void initSurface(SurfaceHolder surfaceHolder)`  L343
- `void stopVideoStream()`  L360
    - 体内字面量："00:00"
- `void locate(float progerss)`  L378
- `void destroyVideo(int iCatchSphereType)`  L384
- `void rotateB(MotionEvent e, float prevX, float prevY)`  L394
- `void delete()`  L398
- `void download()`  L405
- `void back()`  L412
    - 体内字面量："hasDeleted" · "fileType"
- `void showBar(boolean isShowBar)`  L506
- `void sendVideoBroadcast()`  L656
    - 体内字面量："RemainVideo_FileList"
- `List<MultiPbItemInfo> getRemainFileList()`  L663
- `void showDownloadEnsureDialog()`  L667
    - 体内字面量："$1$" · "$3$" · "$2$"
- `void onClick(DialogInterface dialog, int whichButton)`  L675 @Override
- `void onClick(View v)`  L687 @Override
    - 体内字面量："/"
- `void onClick(DialogInterface dialog, int whichButton)`  L704 @Override
- `void showDeleteEnsureDialog()`  L714
    - 体内字面量："$1$"
- `void onClick(DialogInterface dialog, int whichButton)`  L720 @Override
- `void onClick(DialogInterface dialog, int whichButton)`  L731 @Override
- `void onSufaceViewTouchDown(MotionEvent event)`  L774
- `void onSufaceViewPointerDown(MotionEvent event)`  L785
- `void onSufaceViewTouchMove(MotionEvent event)`  L792
- `float getDistance(MotionEvent event)`  L810
- `void setScale(float scale)`  L816
- `void zoom(float currentZoomRate)`  L847
- `void onSufaceViewTouchUp()`  L851
- `void onSufaceViewTouchPointerUp()`  L858
- `void onSensorChanged(SensorEvent event)`  L866 @Override
- `void rotate(float speedX, float speedY, float speedZ, long timestamp)`  L872
- `void registerGyroscopeSensor()`  L876
    - 体内字面量："sensor"
- `void removeGyroscopeListener()`  L884
- `void setDrawingArea(int windowW, int windowH)`  L892
- `void redrawSurface()`  L896
- `void setPanoramaType()`  L901
- `void showMoreSettingLayout(boolean isShowBar)`  L923
- `void enableEIS(boolean enable)`  L935
- `void setSdCardEventListener()`  L947
- `void eventListener(int sdkEventId)`  L950 @Override
- `void onSure()`  L958 @Override
### `com.gku.dashcam.icatch.presenter.VideoPbPresenter$DeleteThread`
L571 · [class] private DeleteThread · implements `Runnable` · `com/gku/dashcam/icatch/presenter/VideoPbPresenter.java`

方法（6）：
- `private DeleteThread()`  L572
- `void run()`  L576 @Override
    - 体内字面量："__file_protection__" · "retVal: " · "æä»¶è§£éæåretVal: "
- `void run()`  L591 @Override
    - 体内字面量："hasDeleted" · "fileType"
- `void run()`  L609 @Override
    - 体内字面量："ç´§æ¥å½åæä»¶æ æ³å é¤ï¼" · "æä»¶è§£éå¤±è´¥retVal: " · "ErrorInfo: "
- `void run()`  L630 @Override
- `void run()`  L638 @Override
    - 体内字面量："hasDeleted" · "fileType"
### `com.gku.dashcam.icatch.presenter.VideoPbPresenter$DownloadProcessTask`
L741 · [class] DownloadProcessTask · extends `TimerTask` · `com/gku/dashcam/icatch/presenter/VideoPbPresenter.java`

字段/常量（4）：
- `String curDownloadFile`  L742
- `long curFileLength`  L743
- `int downloadProgress = 0`  L744
- `long fileSize`  L745

方法（3）：
- `public DownloadProcessTask(String downloadFile)`  L747
- `void run()`  L752 @Override
- `void run()`  L765 @Override
### `com.gku.dashcam.icatch.presenter.VideoPbPresenter$DownloadThread`
L520 · [class] private DownloadThread · implements `Runnable` · `com/gku/dashcam/icatch/presenter/VideoPbPresenter.java`

字段/常量（3）：
- `String TAG = "DownloadThread"`  L521
- `String fileType`  L522
- `String targetPath`  L523

方法（3）：
- `void run()`  L530 @Override
- `void run()`  L535 @Override
    - 体内字面量：".mov" · ".MOV" · "video/mov" · "video/mp4" · "$1$"
- `void run()`  L558 @Override
### `com.gku.dashcam.icatch.presenter.VideoPbPresenter$VideoPbHandler`
L422 · [class] private VideoPbHandler · extends `Handler` · `com/gku/dashcam/icatch/presenter/VideoPbPresenter.java`

字段/常量（1）：
- `int i = msg.what`  L428

方法（2）：
- `private VideoPbHandler()`  L423
- `void handleMessage(Message msg)`  L427 @Override
### `com.gku.dashcam.icatch.ProgressWheel`
L15 · [class] public ProgressWheel · extends `View` · `com/gku/dashcam/icatch/ProgressWheel.java`

字段/常量（52）：
- `int barColor`  L16
- `int barLength`  L17
- `Paint barPaint`  L18
- `int barWidth`  L19
- `RectF circleBounds`  L20
- `int circleColor`  L21
- `RectF circleInnerContour`  L22
- `RectF circleOuterContour`  L23
- `Paint circlePaint`  L24
- `int circleRadius`  L25
- `int contourColor`  L26
- `Paint contourPaint`  L27
- `float contourSize`  L28
- `int delayMillis`  L29
- `int fullRadius`  L30
- `RectF innerCircleBounds`  L31
- `boolean isSpinning`  L32
- `int layoutHeight`  L33
- `int layoutWidth`  L34
- `int paddingBottom`  L35
- `int paddingLeft`  L36
- `int paddingRight`  L37
- `int paddingTop`  L38
- `float progress`  L39
- `int rimColor`  L40
- `Paint rimPaint`  L41
- `int rimWidth`  L42
- `float spinSpeed`  L43
- `String[] splitText`  L44
- `String text`  L45
- `int textColor`  L46
- `Paint textPaint`  L47
- `int textSize`  L48
- `int i = this.layoutWidth - iMin`  L139
- `int i3 = i / 2`  L143
- `float f = this.paddingLeft`  L148
- `int i4 = this.barWidth`  L149
- `int i5 = this.paddingLeft`  L151
- `int i6 = this.barWidth`  L152
- `int i7 = width - this.paddingRight`  L156
- `int i8 = this.barWidth`  L157
- `float f = this.progress + this.spinSpeed`  L207
- `float f = this.progress + amount`  L242
- `Paint paint = this.barPaint`  L283
- `Paint paint = this.textPaint`  L295
- `Paint paint = this.barPaint`  L343
- `Paint paint = this.circlePaint`  L355
- `Paint paint = this.rimPaint`  L367
- `Paint paint = this.textPaint`  L387
- `Paint paint = this.rimPaint`  L407
- `Paint paint = this.contourPaint`  L427
- `Paint paint = this.contourPaint`  L439

方法（53）：
- `public ProgressWheel(Context context, AttributeSet attrs)`  L50
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L89 @Override
- `void onSizeChanged(int newWidth, int newHeight, int oldWidth, int oldHeight)`  L106 @Override
- `void setupPaints()`  L115
- `void setupBounds()`  L137
- `void parseAttributes(TypedArray a)`  L163
- `void onDraw(Canvas canvas)`  L187 @Override
- `void scheduleRedraw()`  L206
- `boolean isSpinning()`  L215
- `void resetCount()`  L219
    - 体内字面量："0%"
- `void stopSpinning()`  L225
- `void startSpinning()`  L231
- `void incrementProgress()`  L236
- `void incrementProgress(int amount)`  L240
- `void setProgress(int i)`  L250
- `void setText(String text)`  L256
    - 体内字面量："\n"
- `int getCircleRadius()`  L261
- `void setCircleRadius(int circleRadius)`  L265
- `int getBarLength()`  L269
- `void setBarLength(int barLength)`  L273
- `int getBarWidth()`  L277
- `void setBarWidth(int barWidth)`  L281
- `int getTextSize()`  L289
- `void setTextSize(int textSize)`  L293
- `int getPaddingTop()`  L302 @Override
- `void setPaddingTop(int paddingTop)`  L306
- `int getPaddingBottom()`  L311 @Override
- `void setPaddingBottom(int paddingBottom)`  L315
- `int getPaddingLeft()`  L320 @Override
- `void setPaddingLeft(int paddingLeft)`  L324
- `int getPaddingRight()`  L329 @Override
- `void setPaddingRight(int paddingRight)`  L333
- `int getBarColor()`  L337
- `void setBarColor(int barColor)`  L341
- `int getCircleColor()`  L349
- `void setCircleColor(int circleColor)`  L353
- `int getRimColor()`  L361
- `void setRimColor(int rimColor)`  L365
- `Shader getRimShader()`  L373
- `void setRimShader(Shader shader)`  L377
- `int getTextColor()`  L381
- `void setTextColor(int textColor)`  L385
- `float getSpinSpeed()`  L393
- `void setSpinSpeed(float spinSpeed)`  L397
- `int getRimWidth()`  L401
- `void setRimWidth(int rimWidth)`  L405
- `int getDelayMillis()`  L413
- `void setDelayMillis(int delayMillis)`  L417
- `int getContourColor()`  L421
- `void setContourColor(int contourColor)`  L425
- `float getContourSize()`  L433
- `void setContourSize(float contourSize)`  L437
- `int getProgress()`  L445
### `com.gku.dashcam.icatch.PropertyId`
L4 · [class] public PropertyId · `com/gku/dashcam/icatch/PropertyId.java`

字段/常量（55）：
- `int AP_MODE_TO_STA_MODE = 55291`  L5
- `int AUTO_POWER_OFF = 55073`  L6
- `int BURST_NUMBER = 20504`  L7
- `int CAMERA_CONNECT_CHANGE = 55201`  L8
- `int CAMERA_DATE = 20497`  L9
- `int CAMERA_DATE_TIMEZONE = 55358`  L10
- `int CAMERA_ESSID = 55356`  L11
- `int CAMERA_NAME = 55345`  L12
- `int CAMERA_PASSWORD = 55357`  L13
- `int CAMERA_PASSWORD_NEW = 55346`  L14
- `int CAMERA_PB_LIMIT_NUMBER = 55359`  L15
- `int CAMERA_SWITCH = 55091`  L16
- `int CAPTURE_DELAY = 20498`  L17
- `int CAPTURE_DELAY_MODE = 55280`  L18
- `int CAPTURE_IN_VIDEO_RECORD = 55082`  L19
- `int DATE_STAMP = 54791`  L20
- `int DEFALUT_TO_PREVIEW = 55084`  L21
- `int DEL_FILE = 55299`  L22
- `int ESSID_NAME = 55348`  L23
- `int ESSID_PASSWORD = 55349`  L24
- `int EXPOSURE_COMPENSATION = 55075`  L25
- `int FAST_MOTION_MOVIE = 55078`  L26
- `int IMAGE_SIZE = 20483`  L27
- `int IMAGE_STABILIZATION = 55076`  L28
- `int LIGHT_FREQUENCY = 54790`  L29
- `int MULTIPLE_CAMERA_SENSOR = 55081`  L30
- `int NOTIFY_FW_TO_SHARE_MODE = 55291`  L31
- `int POWER_ON_AUTO_RECORD = 55074`  L32
- `int SCREEN_SAVER = 55072`  L33
- `int SERVICE_ESSID = 55350`  L34
- `int SERVICE_PASSWORD = 55351`  L35
- `int SLOW_MOTION = 54805`  L36
- `int STA_MODE_PASSWORD = 55349`  L37
- `int STA_MODE_SSID = 55348`  L38
- `int SUPPORT_PREVIEW = 55295`  L39
- `int TIMELAPSE_MODE = 60928`  L40
- `int TIMELAPSE_VIDEO_SIZE_LIST_MASK = 55291`  L41
- `int UP_SIDE = 54804`  L42
- `int USB_PIMA_DCP_CUSTOM_PV_DISP_TYPE = 55232`  L43
- `int USB_PIMA_DCP_Custom_AudioRec = 55217`  L44
- `int USB_PIMA_DCP_Custom_BeepSound = 55222`  L45
- `int USB_PIMA_DCP_Custom_BooTSound = 55223`  L46
- `int USB_PIMA_DCP_Custom_GKU_PDT_STRING = 55298`  L47
- `int USB_PIMA_DCP_Custom_GKU_PDT_STRING_new = 55296`  L48
- `int USB_PIMA_DCP_Custom_Gsensor = 55218`  L49
- `int USB_PIMA_DCP_Custom_Language = 55221`  L50
- `int USB_PIMA_DCP_Custom_MotionDetect = 55216`  L51
- `int USB_PIMA_DCP_Custom_RESET_FACTORY = 55224`  L52
- `int USB_PIMA_DCP_Custom_SPEEDUNIT = 55225`  L53
- `int VIDEO_FILE_LENGTH = 55077`  L54
- `int VIDEO_RECORDING_TIME = 55293`  L55
- `int VIDEO_SIZE = 54789`  L56
- `int VIDEO_SIZE_FLOW = 55292`  L57
- `int WHITE_BALANCE = 20485`  L58
- `int WIND_NOISE_REDUCTION = 55079`  L59
### `com.gku.dashcam.icatch.sdkapi.CameraAction`
L21 · [class] public CameraAction · `com/gku/dashcam/icatch/sdkapi/CameraAction.java`

字段/常量（22）：
- `String TAG = "CameraAction"`  L22
- `ICatchCameraAssist cameraAssist`  L23
- `ICatchCameraControl cameraControl`  L24
- `boolean zCapturePhoto`  L32
- `boolean zTriggerCapturePhoto`  L46
- `boolean z = false`  L73
- `boolean zStartTimeLapse`  L93
- `boolean zStopTimeLapse`  L107
- `boolean z = false`  L130
- `boolean z = false`  L151
- `boolean standbyMode = false`  L175
- `boolean zAddCustomEventListener`  L194
- `ICatchCameraControl iCatchCameraControl = this.cameraControl`  L211
- `boolean zDelCustomEventListener = false`  L212
- `boolean zAddEventListener`  L228
- `ICatchCameraControl iCatchCameraControl = this.cameraControl`  L247
- `boolean zDelEventListener = false`  L248
- `boolean zZoomIn`  L270
- `boolean zZoomOut`  L292
- `boolean zUpdateFw`  L314
- `boolean zAddEventListener`  L352
- `boolean zChangePreviewMode`  L387

方法（23）：
- `public CameraAction(ICatchCameraControl control, ICatchCameraAssist assist)`  L26
- `boolean capturePhoto()`  L31
- `boolean triggerCapturePhoto()`  L45
- `boolean startMovieRecord()`  L71
    - 体内字面量："begin startVideoCapture"
- `boolean startTimeLapse()`  L92
- `boolean stopTimeLapse()`  L106
- `boolean stopVideoCapture()`  L128
    - 体内字面量："begin stopVideoCapture"
- `boolean formatStorage()`  L149
    - 体内字面量："begin formatSD"
- `boolean sleepCamera()`  L173
    - 体内字面量："begin sleepCamera"
- `boolean addCustomEventListener(int eventID, ICatchCameraListener listener)`  L193
- `boolean delCustomEventListener(int eventID, ICatchCameraListener listener)`  L209
    - 体内字面量："begin delEventListener eventID="
- `boolean addEventListener(int eventID, ICatchCameraListener listener)`  L227
- `boolean delEventListener(int eventID, ICatchCameraListener listener)`  L245
    - 体内字面量："begin delEventListener eventID="
- `String getCameraMacAddress()`  L265
- `boolean zoomIn()`  L269
- `boolean zoomOut()`  L291
- `boolean updateFW(String fileName)`  L313
- `boolean addGlobalEventListener(int iCatchEventID, ICatchCameraListener listener, Boolean forAllSession)`  L351
- `boolean delGlobalEventListener(int iCatchEventID, ICatchCameraListener listener, Boolean forAllSession)`  L363
- `boolean previewMove(int xshift, int yshfit)`  L372
    - 体内字面量："begin previewMove" · "end previewMove ret = "
- `boolean resetPreviewMove()`  L379
    - 体内字面量："begin resetPreviewMove" · "end resetPreviewMove ret = "
- `boolean changePreviewMode(int mode)`  L386
- `int getCurrentCameraMode()`  L399
    - 体内字面量："begin getCurrentCameraMode" · "end getCurrentCameraMode ret = "
### `com.gku.dashcam.icatch.sdkapi.CameraFixedInfo`
L8 · [class] public CameraFixedInfo · `com/gku/dashcam/icatch/sdkapi/CameraFixedInfo.java`

字段/常量（2）：
- `ICatchCameraInfo cameraInfo`  L9
- `String tag = "CameraFixedInfo"`  L10

方法（3）：
- `public CameraFixedInfo(ICatchCameraInfo cameraInfo)`  L12
- `String getCameraName()`  L16
- `String getCameraVersion()`  L25
    - 体内字面量："CameraFixedInfo" · "IchInvalidSessionException"
### `com.gku.dashcam.icatch.sdkapi.CameraProperties`
L28 · [class] public CameraProperties · `com/gku/dashcam/icatch/sdkapi/CameraProperties.java`

字段/常量（25）：
- `ICatchCameraControl cameraAction`  L29
- `ICatchCameraProperty cameraProperty`  L30
- `List<Integer> fuction`  L31
- `List<Integer> modeList`  L32
- `List<ICatchVideoFormat> resolutionList`  L33
- `String tag = "CameraProperties"`  L34
- `List<String> supportedImageSizes`  L42
- `List<String> supportedVideoSizes`  L71
- `List<Integer> supportedCaptureDelays`  L120
- `List<Integer> supportedLightFrequencies`  L147
- `int currentDateStamp`  L405
- `Boolean boolValueOf = false`  L432
- `int currentBurstNumber`  L498
- `int currentBurstNumber`  L524
- `Boolean boolValueOf = false`  L627
- `boolean zSupportVideoPlayback`  L669
- `Boolean bool = false`  L700
- `Boolean bool = false`  L720
- `List<Integer> supportedBurstNumbers`  L751
- `List<Integer> supportedTimeLapseDurations`  L824
- `List<Integer> supportedTimeLapseIntervals`  L848
- `String cameraName`  L1117
- `ICatchVideoFormat currentStreamingInfo`  L1693
- `ICatchVideoFormat currentStreamingInfo`  L1748
- `int currentPropertyValue`  L1812

方法（83）：
- `public CameraProperties(ICatchCameraProperty cameraProperty, ICatchCameraControl cameraAction)`  L36
- `List<String> getSupportedImageSizes()`  L41
- `List<String> getSupportedVideoSizes()`  L70
- `List<Integer> getSupportedWhiteBalances()`  L96
    - 体内字面量："CameraProperties" · "begin getSupportedWhiteBalances" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `List<Integer> getSupportedCaptureDelays()`  L119
- `List<Integer> getSupportedLightFrequencys()`  L146
- `boolean setImageSize(String value)`  L176
    - 体内字面量："CameraProperties" · "begin setImageSize set value =" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setVideoSize(String value)`  L199
    - 体内字面量："CameraProperties" · "begin setVideoSize set value =" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setWhiteBalance(int value)`  L222
    - 体内字面量："CameraProperties" · "begin setWhiteBalanceset value =" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setLightFrequency(int value)`  L244
    - 体内字面量："CameraProperties" · "begin setLightFrequency set value =" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `String getCurrentImageSize()`  L266
    - 体内字面量："CameraProperties" · "begin getCurrentImageSize" · "CameraProperties" · "IchCameraModeException" · "unknown" · "CameraProperties" · "IchDevicePropException" · "unknown" · "CameraProperties" · "IchInvalidSessionException" · "unknown" · "CameraProperties" · "IchSocketException" · "unknown"
- `String getCurrentVideoSize()`  L289
    - 体内字面量："CameraProperties" · "begin getCurrentVideoSize" · "CameraProperties" · "IchCameraModeException" · "unknown" · "CameraProperties" · "IchDevicePropException" · "unknown" · "CameraProperties" · "IchInvalidSessionException" · "unknown" · "CameraProperties" · "IchSocketException" · "unknown"
- `int getCurrentWhiteBalance()`  L312
    - 体内字面量："CameraProperties" · "begin getCurrentWhiteBalance" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getCurrentLightFrequency()`  L335
    - 体内字面量："CameraProperties" · "begin getCurrentLightFrequency" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setCaptureDelay(int value)`  L358
    - 体内字面量："CameraProperties" · "begin setCaptureDelay set value =" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getCurrentCaptureDelay()`  L381
    - 体内字面量："CameraProperties" · "begin getCurrentCaptureDelay" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getCurrentDateStamp()`  L404
- `boolean setDateStamp(int dateStamp)`  L430
    - 体内字面量："CameraProperties" · "begin setDateStampType set value = "
- `List<Integer> getDateStampList()`  L451
    - 体内字面量："CameraProperties" · "begin getDateStampList" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `List<Integer> getSupportFuction()`  L474
    - 体内字面量："CameraProperties" · "begin getSupportFuction" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getCurrentBurstNum()`  L497
- `int getCurrentAppBurstNum()`  L523
- `boolean setCurrentBurst(int burstNum)`  L550
    - 体内字面量："CameraProperties" · "begin setCurrentBurst set value = " · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getRemainImageNum()`  L572
    - 体内字面量："CameraProperties" · "begin getRemainImageNum" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchNoSDCardException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getRecordingRemainTime()`  L599
    - 体内字面量："CameraProperties" · "begin getRecordingRemainTimeInt" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean isSDCardExist()`  L625
    - 体内字面量："CameraProperties" · "begin isSDCardExist"
- `int getBatteryElectric()`  L646
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean supportVideoPlayback()`  L668
- `boolean cameraModeSupport(int mode)`  L698
    - 体内字面量："CameraProperties" · "begin cameraModeSupport  mode="
- `String getCameraMacAddress()`  L710
    - 体内字面量："CameraProperties" · "begin getCameraMacAddress macAddress macAddress "
- `boolean hasFuction(int fuc)`  L715
    - 体内字面量："CameraProperties" · "begin hasFuction query fuction = "
- `List<Integer> getsupportedDateStamps()`  L727
    - 体内字面量："CameraProperties" · "begin getsupportedDateStamps" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `List<Integer> getsupportedBurstNums()`  L750
- `List<Integer> getSupportedFrequencies()`  L781
    - 体内字面量："CameraProperties" · "begin getSupportedFrequencies" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `List<Integer> getSupportedModes()`  L804
    - 体内字面量："CameraProperties" · "begin getSupportedModes" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `List<Integer> getSupportedTimeLapseDurations()`  L823
- `List<Integer> getSupportedTimeLapseIntervals()`  L847
- `boolean setTimeLapseDuration(int timeDuration)`  L871
    - 体内字面量："CameraProperties" · "begin setTimeLapseDuration videoDuration =" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getCurrentTimeLapseDuration()`  L893
    - 体内字面量："CameraProperties" · "begin getCurrentTimeLapseDuration" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setTimeLapseInterval(int timeInterval)`  L916
    - 体内字面量："CameraProperties" · "begin setTimeLapseInterval videoDuration =" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getCurrentTimeLapseInterval()`  L939
    - 体内字面量："CameraProperties" · "begin getCurrentTimeLapseInterval" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `float getMaxZoomRatio()`  L962
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `float getCurrentZoomRatio()`  L984
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getCurrentUpsideDown()`  L1006
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setUpsideDown(int upside)`  L1028
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getCurrentSlowMotion()`  L1050
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setSlowMotion(int slowMotion)`  L1072
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setCameraDate()`  L1094
    - 体内字面量："yyyyMMdd HHmmss" · ".0" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setCameraDateTimeZone()`  L1116
- `boolean setCameraEssidName(String ssidName)`  L1145
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `String getCameraEssidName()`  L1167
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `String getCameraEssidPassword()`  L1189
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setCameraEssidPassword(String ssidPassword)`  L1211
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setCameraSsid(String ssid)`  L1233
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setCameraName(String cameraName)`  L1255
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `String getCameraName()`  L1277
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `String getCameraName(ICatchCameraProperty cameraConfiguration1)`  L1299
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `String getCameraPasswordNew()`  L1321
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setCameraPasswordNew(String cameraNamePassword)`  L1343
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `String getCameraSsid()`  L1365
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setCameraPassword(String password)`  L1387
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `String getCameraPassword()`  L1409
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setCaptureDelayMode(int value)`  L1431
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getVideoRecordingTime()`  L1453
    - 体内字面量："CameraProperties" · "Exception e:"
- `boolean setServiceEssid(String value)`  L1463
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setServicePassword(String value)`  L1485
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean notifyFwToShareMode(int value)`  L1507
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `List<Integer> getSupportedPropertyValues(int propertyId)`  L1529
    - 体内字面量："CameraProperties" · "begin getSupportedPropertyValues propertyId =" · "CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getCurrentPropertyValue(int propertyId)`  L1552
    - 体内字面量："CameraProperties" · "Exception e:"
- `String getCurrentStringPropertyValue(int propertyId)`  L1562
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setPropertyValue(int propertyId, int value)`  L1584
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean setStringPropertyValue(int propertyId, String value)`  L1606
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `int getVideoSizeFlow()`  L1628
    - 体内字面量："CameraProperties" · "Exception e:"
- `boolean notifyCameraConnectChnage(int value)`  L1638
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `List<ICatchVideoFormat> getResolutionList()`  L1660
    - 体内字面量："CameraProperties" · "Exception e:"
- `List<ICatchVideoFormat> getResolutionList(int codecType)`  L1674
    - 体内字面量："CameraProperties" · "Exception e:"
- `String getFWDefaultResolution()`  L1692
- `boolean setStreamingInfo(ICatchVideoFormat iCatchVideoFormat)`  L1725
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `String getCurrentStreamInfo()`  L1747
- `int getPreviewCacheTime()`  L1789
    - 体内字面量："CameraProperties" · "IchCameraModeException" · "CameraProperties" · "IchDevicePropException" · "CameraProperties" · "IchInvalidSessionException" · "CameraProperties" · "IchSocketException"
- `boolean isSupportPreview()`  L1811
- `int getNumberOfSensors()`  L1823
    - 体内字面量："CameraProperties" · "Exception:"
- `boolean checkCameraCapabilities(int featureID)`  L1833
    - 体内字面量："CameraProperties" · "Exception:"
### `com.gku.dashcam.icatch.sdkapi.CameraState`
L8 · [class] public CameraState · `com/gku/dashcam/icatch/sdkapi/CameraState.java`

字段/常量（2）：
- `ICatchCameraState cameraState`  L9
- `String tag = "CameraState"`  L10

方法（5）：
- `public CameraState(ICatchCameraState cameraState)`  L12
- `boolean isMovieRecording()`  L16
    - 体内字面量："CameraState" · "IchInvalidSessionException"
- `boolean isTimeLapseVideoOn()`  L26
    - 体内字面量："CameraState" · "IchInvalidSessionException"
- `boolean isTimeLapseStillOn()`  L36
    - 体内字面量："CameraState" · "IchInvalidSessionException"
- `boolean isSupportImageAutoDownload()`  L46
    - 体内字面量："CameraState" · "IchInvalidSessionException"
### `com.gku.dashcam.icatch.sdkapi.FileOperation`
L18 · [class] public FileOperation · `com/gku/dashcam/icatch/sdkapi/FileOperation.java`

字段/常量（14）：
- `ICatchCameraPlayback cameraPlayback`  L19
- `String tag = "FileOperation"`  L20
- `boolean zCancelFileDownload`  L27
- `ICatchCameraPlayback iCatchCameraPlayback = this.cameraPlayback`  L28
- `List<ICatchFile> listListFiles`  L56
- `List<ICatchFile> listListFiles`  L87
- `int fileCount`  L119
- `boolean fileListAttribute = false`  L131
- `boolean fileListAttribute = false`  L144
- `boolean zDeleteFile`  L157
- `boolean zDownloadFile`  L185
- `ICatchFrameBuffer iCatchFrameBufferDownloadFile`  L213
- `ICatchFrameBuffer quickview`  L245
- `ICatchFrameBuffer thumbnail`  L309

方法（13）：
- `public FileOperation(ICatchCameraPlayback cameraPlayback)`  L22
- `boolean cancelDownload()`  L26
- `List<ICatchFile> getFileList(int type, int startIndex, int endIndex)`  L55
- `List<ICatchFile> getFileList(int type)`  L86
- `int getFileCount()`  L118
- `boolean setFileListAttribute(int filterType)`  L130
- `boolean setFileListAttribute(int filterType, int sensorsType)`  L143
- `boolean deleteFile(ICatchFile file)`  L156
- `boolean downloadFile(ICatchFile file, String path)`  L184
- `ICatchFrameBuffer downloadFile(ICatchFile curFile)`  L212
- `ICatchFrameBuffer getQuickview(ICatchFile curFile)`  L244
- `ICatchFrameBuffer getThumbnail(ICatchFile file)`  L279
    - 体内字面量："FileOperation" · "IchCameraModeException" · "FileOperation" · "IchBufferTooSmallException" · "FileOperation" · "IchDeviceException" · "FileOperation" · "IchInvalidSessionException" · "FileOperation" · "IchNoSuchFileException" · "FileOperation" · "IchSocketException"
- `ICatchFrameBuffer getThumbnail(String filePath)`  L308
### `com.gku.dashcam.icatch.sdkapi.PanoramaControl`
L11 · [class] public PanoramaControl · `com/gku/dashcam/icatch/sdkapi/PanoramaControl.java`

字段/常量（3）：
- `String TAG = "PanoramaControl"`  L12
- `ICatchIPancamControl iCatchIPancamControl`  L13
- `ICatchIPancamControl iCatchIPancamControl = this.iCatchIPancamControl`  L34

方法（3）：
- `public PanoramaControl(ICatchPancamSession iCatchPancamSession)`  L15
- `void addEventListener(int var1, ICatchIPancamListener var2)`  L19
    - 体内字面量："addEventListener var1:" · "addEventListener e:" · "addEventListener ret:"
- `void removeEventListener(int var1, ICatchIPancamListener var2)`  L33
### `com.gku.dashcam.icatch.sdkapi.PanoramaPhotoPlayback`
L22 · [class] public PanoramaPhotoPlayback · `com/gku/dashcam/icatch/sdkapi/PanoramaPhotoPlayback.java`

字段/常量（19）：
- `String TAG = "PanoramaPhotoPlayback"`  L23
- `ICatchIPancamGL pancamGL`  L24
- `ICatchIPancamImage photoPlayback`  L25
- `boolean zRelease`  L60
- `boolean zUpdate`  L75
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L87
- `boolean surface = false`  L88
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L106
- `boolean zRemoveSurface = false`  L107
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L129
- `boolean zChangePanoramaType = false`  L130
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L148
- `boolean zInit = false`  L149
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L167
- `boolean format = false`  L168
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L183
- `boolean zClearFormat = false`  L184
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L199
- `boolean zLocate = false`  L246

方法（17）：
- `public PanoramaPhotoPlayback(ICatchPancamSession iCatchPancamSession)`  L27
    - 体内字面量："photoPlayback = "
- `ICatchIPancamGL enableGLRender(int panoramaType)`  L38
    - 体内字面量："Exception e:" · "end enableGLRender pancamGL:"
- `ICatchIPancamImage getPhotoPlayback()`  L49
- `boolean clear()`  L53
    - 体内字面量："end stop retValue ="
- `boolean release()`  L59
- `boolean update(ICatchGLImage image)`  L74
- `boolean setSurface(int ichSurfaceIdSphere, ICatchSurfaceContext iCatchSurfaceContext)`  L86
- `boolean removeSurface(int iCatchSphereType, ICatchSurfaceContext iCatchSurfaceContext)`  L105
- `ICatchIPancamGL getPancamGL()`  L124
- `boolean changePanoramaType(int panoramaType)`  L128
- `boolean pancamGLInit()`  L147
- `boolean pancamGLSetFormat(int sphereType, int width, int height)`  L166
- `boolean pancamGLClearFormat()`  L182
- `ICatchIPancamGLTransform getPancamGLTransform()`  L198
- `boolean pancamGLTransformRotate(int var1, float var2, float var3, float var4, long var5)`  L212
- `boolean pancamGLTransformRotate(ICatchGLPoint var1, ICatchGLPoint var2)`  L228
- `boolean pancamGLTransLocate(float var1)`  L244
### `com.gku.dashcam.icatch.sdkapi.PanoramaPreviewPlayback`
L40 · [class] public PanoramaPreviewPlayback · `com/gku/dashcam/icatch/sdkapi/PanoramaPreviewPlayback.java`

字段/常量（45）：
- `String TAG = "PanoramaPreviewPlayback"`  L41
- `ICatchIPancamPreview previewPlayback`  L42
- `ICatchIPancamGL pancamGL = null`  L43
- `List<ICatchImageSize> imageSizelist = null`  L44
- `ICatchImageSize curImageSize = null`  L45
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L77
- `boolean zChangePanoramaType = false`  L78
- `ICatchIStreamProvider iCatchIStreamProviderDisableRender`  L96
- `ICatchIPancamPreview iCatchIPancamPreview = this.previewPlayback`  L109
- `ICatchIPancamPreview iCatchIPancamPreview = this.previewPlayback`  L128
- `Tristate tristate = Tristate.FALSE`  L147
- `boolean zStart = false`  L148
- `String str = TAG`  L162
- `boolean zStop`  L169
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L189
- `boolean zInit = false`  L190
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L211
- `boolean zRelease = false`  L212
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L229
- `boolean surface = false`  L230
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L251
- `boolean zRemoveSurface = false`  L252
- `String str = TAG`  L270
- `boolean zIsStreamSupportPublish = false`  L273
- `String str = TAG`  L292
- `boolean zStartPublishStreaming = false`  L295
- `String str = TAG`  L311
- `boolean zStopPublishStreaming = false`  L314
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L330
- `String str = TAG`  L391
- `boolean zStartMovieRecord = false`  L394
- `String str = TAG`  L422
- `boolean zStopMovieRecord = false`  L425
- `String str = TAG`  L450
- `List<ICatchImageSize> list = this.imageSizelist`  L452
- `String str = TAG`  L478
- `boolean imageSize = false`  L481
- `String str = TAG`  L513
- `boolean zSnapImage = false`  L516
- `String str = TAG`  L544
- `String str = TAG`  L557
- `String str = TAG`  L569
- `String str = TAG`  L582
- `boolean thumbnail`  L594
- `byte[] bArr = new byte[8294400]`  L596

方法（31）：
- `public PanoramaPreviewPlayback(ICatchPancamSession iCatchPancamSession)`  L47
- `boolean enableCommonRender(ICatchSurfaceContext iCatchSurfaceContext)`  L51
    - 体内字面量："Exception : "
- `boolean enableGLRender()`  L62
    - 体内字面量："enableGLRender" · "Exception : " · "end enableGLRender"
- `boolean changePanoramaType(int panoramaType)`  L75
    - 体内字面量："start changePanoramaType panoramaType="
- `ICatchIStreamProvider disableRender()`  L95
- `ICatchIStreamControl getStreamControl()`  L108
- `ICatchIStreamPublish getStreamPublish()`  L126
    - 体内字面量："getStreamPublish"
- `Tristate start(ICatchStreamParam var1, boolean enableAudio)`  L145
    - 体内字面量："start Stream ICatchStreamParam=" · " enableAudio="
- `boolean stop()`  L168
- `boolean init(int panoramaType)`  L187
    - 体内字面量："start init "
- `boolean release()`  L209
    - 体内字面量："start pancamGLRelease "
- `boolean setSurface(int ichSurfaceIdSphere, ICatchSurfaceContext iCatchSurfaceContext)`  L227
    - 体内字面量："start initSurface "
- `boolean removeSurface(int iCatchSphereType, ICatchSurfaceContext iCatchSurfaceContext)`  L249
    - 体内字面量："start removeSurface "
- `boolean isStreamSupportPublish()`  L269
- `boolean startPublishStreaming(String rtmpUrl)`  L291
- `boolean stopPublishStreaming()`  L310
- `ICatchIPancamGLTransform getPancamGLTransform()`  L329
- `boolean locate(float var1)`  L342
- `boolean rotate(int var1, float var2, float var3, float var4, long var5)`  L358
- `boolean rotate(ICatchGLPoint var1, ICatchGLPoint var2)`  L374
- `boolean startMovieRecord(String var1, boolean var2)`  L390
- `boolean stopMovieRecord()`  L421
- `List<ICatchImageSize> getSupportedImageSize()`  L449
- `boolean setImageSize(ICatchImageSize var1)`  L477
- `ICatchImageSize getCurImageSize()`  L507
    - 体内字面量："start getCurImageSize curImageSize="
- `boolean snapImage(ICatchFrameBuffer var1, int var2)`  L512
- `String createChannel(ICatchGLCredential var1, String var2, String var3, boolean var4)`  L543
- `void deleteChannel()`  L556
- `String startLive()`  L568
- `void stopLive()`  L581
- `Bitmap getPvThumbnail()`  L593
### `com.gku.dashcam.icatch.sdkapi.PanoramaVideoPlayback`
L28 · [class] public PanoramaVideoPlayback · `com/gku/dashcam/icatch/sdkapi/PanoramaVideoPlayback.java`

字段/常量（25）：
- `String TAG = "PanoramaVideoPlayback"`  L29
- `ICatchIPancamGL pancamGL`  L30
- `StreamStablization streamStablization`  L31
- `ICatchIPancamVideoPlayback videoPlayback`  L32
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L89
- `boolean zChangePanoramaType = false`  L90
- `boolean zPlay`  L118
- `double length`  L132
- `boolean zStop`  L146
- `boolean zResume`  L160
- `boolean zPause`  L182
- `boolean zSeek`  L204
- `String str = TAG`  L226
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L228
- `boolean zInit = false`  L229
- `String str = TAG`  L245
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L247
- `boolean zRelease = false`  L248
- `String str = TAG`  L264
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L266
- `boolean surface = false`  L267
- `String str = TAG`  L283
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L285
- `boolean zRemoveSurface = false`  L286
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L302

方法（22）：
- `boolean setFormat(int type)`  L34
- `public PanoramaVideoPlayback(ICatchPancamSession iCatchPancamSession)`  L38
- `StreamStablization getStreamStablization()`  L51
- `void enableGLRender()`  L55
    - 体内字面量："Exception : " · "enableGLRender pancamGL="
- `boolean enableCommonRender(ICatchSurfaceContext iCatchSurfaceContext)`  L65
    - 体内字面量："Exception : "
- `void enableGLRender(int var1)`  L76
    - 体内字面量："begin enableGLRender var1=" · "Exception : " · "enableGLRender pancamGL="
- `boolean changePanoramaType(int panoramaType)`  L87
    - 体内字面量："start changePanoramaType panoramaType="
- `ICatchIStreamProvider disableRender()`  L107
    - 体内字面量："Exception : "
- `boolean openVideoStream(ICatchFile iCatchFile, boolean disableAudio, boolean isRemote)`  L117
- `int getLength()`  L131
- `boolean stop()`  L145
- `boolean resumePlayback()`  L159
- `boolean pausePlayback()`  L181
- `boolean videoSeek(double position)`  L203
- `boolean initPancamGL(int varl)`  L225
- `boolean pancamGLRelease()`  L244
- `boolean setSurface(int ichSurfaceIdSphere, ICatchSurfaceContext iCatchSurfaceContext)`  L263
- `boolean removeSurface(int iCatchSphereType, ICatchSurfaceContext iCatchSurfaceContext)`  L282
- `ICatchIPancamGLTransform getPancamGLTransform()`  L301
- `boolean locate(float var1)`  L314
- `boolean rotate(int var1, float var2, float var3, float var4, long var5)`  L330
- `boolean rotate(ICatchGLPoint var1, ICatchGLPoint var2)`  L346
### `com.gku.dashcam.icatch.sdkapi.SDKEvent`
L14 · [class] public SDKEvent · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

字段/常量（78）：
- `int EVENT_BATTERY_ELETRIC_CHANGED = 0`  L15
- `int EVENT_CAPTURE_COMPLETED = 1`  L16
- `int EVENT_CAPTURE_START = 3`  L17
- `int EVENT_CONNECTION_FAILURE = 8`  L18
- `int EVENT_FILE_ADDED = 7`  L19
- `int EVENT_FILE_DOWNLOAD = 11`  L20
- `int EVENT_FW_UPDATE_CHECK = 25`  L21
- `int EVENT_FW_UPDATE_CHKSUMERR = 26`  L22
- `int EVENT_FW_UPDATE_COMPLETED = 13`  L23
- `int EVENT_FW_UPDATE_NG = 27`  L24
- `int EVENT_FW_UPDATE_POWEROFF = 14`  L25
- `int EVENT_RCONNECT_SUCC = 28`  L26
- `int EVENT_SDCARD_INSERT = 17`  L27
- `int EVENT_SDCARD_REMOVED = 16`  L28
- `int EVENT_SD_CARD_FULL = 4`  L29
- `int EVENT_SEARCHED_NEW_CAMERA = 15`  L30
- `int EVENT_SERVER_STREAM_ERROR = 10`  L31
- `int EVENT_TIME_LAPSE_STOP = 9`  L32
- `int EVENT_VIDEO_OFF = 5`  L33
- `int EVENT_VIDEO_ON = 6`  L34
- `int EVENT_VIDEO_PLAY_CLOSED = 24`  L35
- `int EVENT_VIDEO_PLAY_PTS = 23`  L36
- `int EVENT_VIDEO_RECORDING_TIME = 12`  L37
- `String TAG = "SDKEvent"`  L38
- `BatteryStateListener batteryStateListener`  L39
- `CacheProgressListener cacheProgressListener`  L40
- `CacheStateChangedListener cacheStateChangedListener`  L41
- `CameraAction cameraAction`  L42
- `CaptureDoneListener captureDoneListener`  L43
- `CaptureStartListener captureStartListener`  L44
- `ConnectionFailureListener connectionFailureListener`  L45
- `FileAddedListener fileAddedListener`  L46
- `FileDownloadListener fileDownloadListener`  L47
- `Handler handler`  L48
- `InsertSdcardListener insertSdcardListener`  L49
- `NetworkDisconnectListener networkDisconnectListener`  L50
- `NoEISInformationListener noEISInformationListener`  L51
- `NoSdcardListener noSdcardListener`  L52
- `PanoramaControl panoramaControl`  L53
- `SdcardStateListener sdcardStateListener`  L54
- `ServerStreamErrorListener serverStreamErrorListener`  L55
- `TimeLapseStopListener timeLapseStopListener`  L56
- `UpdateFWCHKSumErrListener updateFWCHKSumErrListener`  L57
- `UpdateFWCheckListener updateFWCheckListener`  L58
- `UpdateFWCompletedListener updateFWCompletedListener`  L59
- `UpdateFWNGListener updateFWNGListener`  L60
- `UpdateFWPoweroffListener updateFWPoweroffListener`  L61
- `VideoCodecInformationListener videoCodecInformationListener`  L62
- `VideoOffListener videoOffListener`  L63
- `VideoOnListener videoOnListener`  L64
- `VideoRecordingTimeStartListener videoRecordingTimeStartListener`  L65
- `VideoStreamCloseListener videoStreamCloseListener`  L66
- `VideoStreamStatusListener videoStreamStatusListener`  L67
- `CacheStateChangedListener cacheStateChangedListener`  L214
- `VideoStreamStatusListener videoStreamStatusListener = this.videoStreamStatusListener`  L216
- `VideoStreamCloseListener videoStreamCloseListener = this.videoStreamCloseListener`  L225
- `NoEISInformationListener noEISInformationListener = this.noEISInformationListener`  L234
- `VideoCodecInformationListener videoCodecInformationListener = this.videoCodecInformationListener`  L243
- `NetworkDisconnectListener networkDisconnectListener = this.networkDisconnectListener`  L252
- `CacheProgressListener cacheProgressListener = this.cacheProgressListener`  L268
- `InsertSdcardListener insertSdcardListener = this.insertSdcardListener`  L292
- `VideoRecordingTimeStartListener videoRecordingTimeStartListener = this.videoRecordingTimeStartListener`  L301
- `ConnectionFailureListener connectionFailureListener`  L313
- `NoSdcardListener noSdcardListener`  L314
- `UpdateFWPoweroffListener updateFWPoweroffListener`  L315
- `UpdateFWCompletedListener updateFWCompletedListener`  L316
- `FileDownloadListener fileDownloadListener`  L317
- `TimeLapseStopListener timeLapseStopListener`  L318
- `VideoOnListener videoOnListener`  L319
- `FileAddedListener fileAddedListener`  L320
- `VideoOffListener videoOffListener`  L321
- `CaptureStartListener captureStartListener`  L322
- `CaptureDoneListener captureDoneListener`  L323
- `BatteryStateListener batteryStateListener`  L324
- `UpdateFWNGListener updateFWNGListener`  L325
- `UpdateFWCHKSumErrListener updateFWCHKSumErrListener`  L326
- `UpdateFWCheckListener updateFWCheckListener`  L327
- `SdcardStateListener sdcardStateListener`  L328

方法（8）：
- `public SDKEvent(Handler handler)`  L69
- `public SDKEvent(Handler handler, PanoramaControl panoramaControl)`  L83
- `void addEventListener(int iCatchEventID)`  L88
- `void addPanoramaEventListener(int iCatchEventID)`  L170
- `void removePanoramaEventListener(int iCatchEventID)`  L213
- `void addCustomizeEvent(int eventID)`  L275
    - 体内字面量："addCustomizeEvent: "
- `void delCustomizeEventListener(int eventID)`  L290
- `void delEventListener(int iCatchEventID)`  L312
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$BatteryStateListener`
L404 · [class] public BatteryStateListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public BatteryStateListener()`  L405
- `void eventNotify(ICatchCamEvent arg0)`  L409 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$CacheProgressListener`
L565 · [class] public CacheProgressListener · implements `ICatchIPancamListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public CacheProgressListener()`  L566
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L570 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$CacheStateChangedListener`
L555 · [class] public CacheStateChangedListener · implements `ICatchIPancamListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public CacheStateChangedListener()`  L556
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L560 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$CaptureDoneListener`
L414 · [class] public CaptureDoneListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public CaptureDoneListener()`  L415
- `void eventNotify(ICatchCamEvent arg0)`  L419 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$CaptureStartListener`
L424 · [class] public CaptureStartListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public CaptureStartListener()`  L425
- `void eventNotify(ICatchCamEvent arg0)`  L429 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$ConnectionFailureListener`
L464 · [class] public ConnectionFailureListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public ConnectionFailureListener()`  L465
- `void eventNotify(ICatchCamEvent arg0)`  L469 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$CustomEventListener`
L629 · [class] public CustomEventListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L631 @Override
- `public CustomEventListener()`  L634
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$FileAddedListener`
L454 · [class] public FileAddedListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public FileAddedListener()`  L455
- `void eventNotify(ICatchCamEvent arg0)`  L459 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$FileDownloadListener`
L494 · [class] public FileDownloadListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public FileDownloadListener()`  L495
- `void eventNotify(ICatchCamEvent arg0)`  L499 @Override
    - 体内字面量："1111" · "receive event:FileDownloadListener"
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$ICatchCodecEventListener`
L384 · [class] public ICatchCodecEventListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public ICatchCodecEventListener()`  L385
- `void eventNotify(ICatchCamEvent arg0)`  L389 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$InsertSdcardListener`
L575 · [class] public InsertSdcardListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public InsertSdcardListener()`  L576
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L580 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$NetworkDisconnectListener`
L597 · [class] private NetworkDisconnectListener · implements `ICatchIPancamListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `private NetworkDisconnectListener()`  L598
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L602 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$NoEISInformationListener`
L619 · [class] private NoEISInformationListener · implements `ICatchIPancamListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `private NoEISInformationListener()`  L620
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L624 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$NoSdcardListener`
L586 · [class] public NoSdcardListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public NoSdcardListener()`  L587
- `void eventNotify(ICatchCamEvent arg0)`  L591 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$SdcardStateListener`
L394 · [class] public SdcardStateListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public SdcardStateListener()`  L395
- `void eventNotify(ICatchCamEvent arg0)`  L399 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$ServerStreamErrorListener`
L484 · [class] public ServerStreamErrorListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public ServerStreamErrorListener()`  L485
- `void eventNotify(ICatchCamEvent arg0)`  L489 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$TimeLapseStopListener`
L474 · [class] public TimeLapseStopListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public TimeLapseStopListener()`  L475
- `void eventNotify(ICatchCamEvent arg0)`  L479 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$UpdateFWCheckListener`
L638 · [class] public UpdateFWCheckListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public UpdateFWCheckListener()`  L639
- `void eventNotify(ICatchCamEvent arg0)`  L643 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$UpdateFWCHKSumErrListener`
L648 · [class] public UpdateFWCHKSumErrListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public UpdateFWCHKSumErrListener()`  L649
- `void eventNotify(ICatchCamEvent arg0)`  L653 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$UpdateFWCompletedListener`
L515 · [class] public UpdateFWCompletedListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public UpdateFWCompletedListener()`  L516
- `void eventNotify(ICatchCamEvent arg0)`  L520 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$UpdateFWNGListener`
L658 · [class] public UpdateFWNGListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public UpdateFWNGListener()`  L659
- `void eventNotify(ICatchCamEvent arg0)`  L663 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$UpdateFWPoweroffListener`
L525 · [class] public UpdateFWPoweroffListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public UpdateFWPoweroffListener()`  L526
- `void eventNotify(ICatchCamEvent arg0)`  L530 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$VideoCodecInformationListener`
L607 · [class] private VideoCodecInformationListener · implements `ICatchIPancamListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `private VideoCodecInformationListener()`  L608
- `void eventNotify(ICatchGLEvent event)`  L612 @Override
    - 体内字面量："Warning, Insufficient performance.\ncodec: %d,Video width:%d,height: %d,Frame interval: %.4f,decode time: %.4f\nThe playback will stutter." · "__codec_performance__"
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$VideoOffListener`
L434 · [class] public VideoOffListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public VideoOffListener()`  L435
- `void eventNotify(ICatchCamEvent arg0)`  L439 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$VideoOnListener`
L444 · [class] public VideoOnListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public VideoOnListener()`  L445
- `void eventNotify(ICatchCamEvent arg0)`  L449 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$VideoRecordingTimeStartListener`
L505 · [class] public VideoRecordingTimeStartListener · implements `ICatchCameraListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public VideoRecordingTimeStartListener()`  L506
- `void eventNotify(ICatchCamEvent arg0)`  L510 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$VideoStreamCloseListener`
L545 · [class] public VideoStreamCloseListener · implements `ICatchIPancamListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public VideoStreamCloseListener()`  L546
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L550 @Override
### `com.gku.dashcam.icatch.sdkapi.SDKEvent$VideoStreamStatusListener`
L535 · [class] public VideoStreamStatusListener · implements `ICatchIPancamListener` · `com/gku/dashcam/icatch/sdkapi/SDKEvent.java`

方法（2）：
- `public VideoStreamStatusListener()`  L536
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L540 @Override
### `com.gku.dashcam.icatch.sdkapi.StreamProvider`
L12 · [class] public StreamProvider · `com/gku/dashcam/icatch/sdkapi/StreamProvider.java`

字段/常量（8）：
- `String TAG = "StreamProvider"`  L13
- `ICatchIStreamProvider iCatchIStreamProvider`  L14
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L21
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L33
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L45
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L58
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L71
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L84

方法（7）：
- `public StreamProvider(ICatchIStreamProvider streamProvider)`  L16
- `boolean containsVideoStream()`  L20
- `boolean containsAudioStream()`  L32
- `ICatchVideoFormat getVideoFormat()`  L44
- `ICatchAudioFormat getAudioFormat()`  L57
- `boolean getNextVideoFrame(ICatchFrameBuffer buffer)`  L70
- `boolean getNextAudioFrame(ICatchFrameBuffer buffer)`  L83
### `com.gku.dashcam.icatch.sdkapi.StreamStablization`
L8 · [class] public StreamStablization · `com/gku/dashcam/icatch/sdkapi/StreamStablization.java`

字段/常量（4）：
- `String TAG = "StreamStablization"`  L9
- `ICatchIStreamStablization streamStablization`  L10
- `ICatchIStreamStablization iCatchIStreamStablization = this.streamStablization`  L18
- `ICatchIStreamStablization iCatchIStreamStablization = this.streamStablization`  L32

方法（3）：
- `public StreamStablization(ICatchIStreamStablization streamStablization)`  L12
- `boolean enableStablization()`  L16
    - 体内字面量："enableStablization "
- `boolean disableStablization()`  L30
    - 体内字面量："disableStablization "
### `com.gku.dashcam.icatch.streaming.CameraStreaming`
L14 · [class] public CameraStreaming · `com/gku/dashcam/icatch/streaming/CameraStreaming.java`

字段/常量（25）：
- `MediaCodec decoder`  L15
- `H264DecoderThread h264DecoderThread`  L16
- `SurfaceHolder holder`  L17
- `ICatchIStreamProvider iCatchIStreamProvider`  L18
- `MjpgDecoderThread mjpgDecoderThread`  L19
- `int previewCodec`  L20
- `PanoramaPreviewPlayback previewPlayback`  L21
- `StreamProvider streamProvider`  L22
- `Surface surface`  L23
- `ICatchVideoFormat videoFormat`  L24
- `String TAG = "CameraStreaming"`  L25
- `boolean isStreaming = false`  L26
- `boolean freezeDecoder = false`  L27
- `int frmW = 0`  L28
- `int frmH = 0`  L29
- `int viewWidth = 0`  L30
- `int viewHeigth = 0`  L31
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L101
- `H264DecoderThread h264DecoderThread = this.h264DecoderThread`  L105
- `int i`  L119
- `int i2`  L120
- `int i3 = this.viewWidth`  L121
- `int i4 = this.frmH`  L125
- `int i5 = this.previewCodec`  L130
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L132

方法（9）：
- `public CameraStreaming(PanoramaPreviewPlayback previewPlayback)`  L33
- `void setSurface(SurfaceHolder holder)`  L37
- `void setViewParam(int w, int h)`  L42
- `void disnableRender()`  L47
- `Tristate start(ICatchStreamParam param, boolean enableAudio)`  L52
- `void startDecoderThread(int previewLaunchMode, ICatchVideoFormat videoFormat)`  L77
- `boolean stop()`  L100
- `boolean isStreaming()`  L114
- `void setSurfaceViewArea()`  L118
### `com.gku.dashcam.icatch.streaming.H264DecoderThread`
L20 · [class] public H264DecoderThread · `com/gku/dashcam/icatch/streaming/H264DecoderThread.java`

字段/常量（20）：
- `String TAG = "H264DecoderThread"`  L21
- `AudioThread audioThread`  L22
- `MediaCodec decoder`  L23
- `int frameHeight`  L24
- `VideoFramePtsChangedListener framePtsChangedListener`  L25
- `int frameWidth`  L26
- `int previewLaunchMode`  L27
- `StreamProvider streamProvider`  L28
- `Surface surface`  L29
- `ICatchVideoFormat videoFormat`  L30
- `VideoThread videoThread`  L31
- `boolean audioPlayFlag = false`  L32
- `int timeout = 20000`  L33
- `long videoShowtime = 0`  L34
- `double curVideoPts = AudioStats.AUDIO_AMPLITUDE_NONE`  L35
- `VideoThread videoThread = this.videoThread`  L68
- `AudioThread audioThread = this.audioThread`  L72
- `AudioThread audioThread = this.audioThread`  L77
- `VideoThread videoThread = this.videoThread`  L81
- `ICatchVideoFormat iCatchVideoFormat = this.videoFormat`  L169

方法（6）：
- `public H264DecoderThread(StreamProvider streamProvider, Surface surface, int previewLaunchMode)`  L37
- `void setframePtsChangedListener(VideoFramePtsChangedListener framePtsChangedListener)`  L49
- `void start(boolean enableAudio, boolean enableVideo)`  L53
- `boolean isAlive()`  L67
- `void stop()`  L76
- `void setFormat()`  L168
### `com.gku.dashcam.icatch.streaming.H264DecoderThread$AudioThread`
L189 · [class] private AudioThread · extends `Thread` · `com/gku/dashcam/icatch/streaming/H264DecoderThread.java`

字段/常量（2）：
- `AudioTrack audioTrack`  L190
- `boolean done`  L191

方法（3）：
- `private AudioThread()`  L193
- `void run()`  L198 @Override
- `void requestExitAndWait()`  L224
### `com.gku.dashcam.icatch.streaming.H264DecoderThread$VideoThread`
L88 · [class] private VideoThread · extends `Thread` · `com/gku/dashcam/icatch/streaming/H264DecoderThread.java`

字段/常量（7）：
- `MediaCodec.BufferInfo info`  L89
- `long startTime = 0`  L90
- `int frameSize = 0`  L91
- `boolean done = false`  L92
- `byte[] bArr = new byte[H264DecoderThread.this.frameWidth * H264DecoderThread.this.frameHeight * 4]`  L101
- `boolean z = true`  L106
- `ByteBuffer byteBuffer = inputBuffers[iDequeueInputBuffer]`  L122

方法（3）：
- `void run()`  L98 @Override
- `boolean dequeueAndRenderOutputBuffer(int outtime)`  L150
- `void requestExitAndWait()`  L163
### `com.gku.dashcam.icatch.streaming.MjpgDecoderThread`
L19 · [class] public MjpgDecoderThread · `com/gku/dashcam/icatch/streaming/MjpgDecoderThread.java`

字段/常量（19）：
- `String TAG = "MjpgDecoderThread"`  L20
- `AudioThread audioThread`  L21
- `Rect drawFrameRect`  L22
- `int frameHeight`  L23
- `VideoFramePtsChangedListener framePtsChangedListener`  L24
- `int frameWidth`  L25
- `int previewLaunchMode`  L26
- `StreamProvider streamProvider`  L27
- `SurfaceHolder surfaceHolder`  L28
- `ICatchVideoFormat videoFormat`  L29
- `Bitmap videoFrameBitmap`  L30
- `VideoThread videoThread`  L31
- `int viewHeight`  L32
- `int viewWidth`  L33
- `VideoThread videoThread = this.videoThread`  L65
- `AudioThread audioThread = this.audioThread`  L69
- `AudioThread audioThread = this.audioThread`  L74
- `VideoThread videoThread = this.videoThread`  L78
- `Canvas canvasLockCanvas`  L191

方法（6）：
- `public MjpgDecoderThread(StreamProvider streamProvider, SurfaceHolder holder, int previewLaunchMode, int viewWidth, int viewHeight)`  L35
- `void setframePtsChangedListener(VideoFramePtsChangedListener framePtsChangedListener)`  L47
- `void start(boolean enableAudio, boolean enableVideo)`  L51
- `boolean isAlive()`  L64
- `void stop()`  L73
- `void redrawBitmap(SurfaceHolder holder, int w, int h)`  L190
### `com.gku.dashcam.icatch.streaming.MjpgDecoderThread$AudioThread`
L146 · [class] private AudioThread · extends `Thread` · `com/gku/dashcam/icatch/streaming/MjpgDecoderThread.java`

字段/常量（2）：
- `AudioTrack audioTrack`  L147
- `boolean done`  L148

方法（3）：
- `private AudioThread()`  L150
- `void run()`  L155 @Override
- `void requestExitAndWait()`  L181
### `com.gku.dashcam.icatch.streaming.MjpgDecoderThread$VideoThread`
L84 · [class] private VideoThread · extends `Thread` · `com/gku/dashcam/icatch/streaming/MjpgDecoderThread.java`

字段/常量（7）：
- `ByteBuffer bmpBuf`  L85
- `boolean done = false`  L86
- `byte[] pixelBuf`  L87
- `byte[] bArr = new byte[MjpgDecoderThread.this.frameWidth * MjpgDecoderThread.this.frameHeight * 4]`  L90
- `boolean z = false`  L102
- `boolean z2 = true`  L103
- `MjpgDecoderThread mjpgDecoderThread = MjpgDecoderThread.this`  L118

方法（2）：
- `void run()`  L98 @Override
- `void requestExitAndWait()`  L137
### `com.gku.dashcam.icatch.streaming.RenderType`
L4 · [enum] public RenderType · `com/gku/dashcam/icatch/streaming/RenderType.java`

枚举常量（2）：
- `NO_RENDER()`  L5
- `PANORAMA_RENDER()`  L6
### `com.gku.dashcam.icatch.streaming.VideoStreaming`
L17 · [class] public VideoStreaming · `com/gku/dashcam/icatch/streaming/VideoStreaming.java`

字段/常量（34）：
- `boolean enableRender`  L18
- `H264DecoderThread h264DecoderThread`  L19
- `SurfaceHolder holder`  L20
- `ICatchIStreamProvider iCatchIStreamProvider`  L21
- `ICatchSurfaceContext iCatchSurfaceContext`  L22
- `MjpgDecoderThread mjpgDecoderThread`  L23
- `int previewCodec`  L24
- `StreamProvider streamProvider`  L25
- `Surface surface`  L26
- `ICatchVideoFormat videoFormat`  L27
- `PanoramaVideoPlayback videoPlayback`  L28
- `String TAG = "VideoStreaming"`  L29
- `boolean isStreaming = false`  L30
- `boolean needRelease = true`  L31
- `int frmW = 0`  L32
- `int frmH = 0`  L33
- `int viewWidth = 0`  L34
- `int viewHeigth = 0`  L35
- `VideoFramePtsChangedListener framePtsChangedListener = null`  L36
- `ICatchSurfaceContext iCatchSurfaceContext`  L80
- `int i`  L92
- `int i2 = 0`  L103
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L156
- `H264DecoderThread h264DecoderThread = this.h264DecoderThread`  L160
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L176
- `H264DecoderThread h264DecoderThread = this.h264DecoderThread`  L180
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L203
- `int i`  L219
- `int i2`  L220
- `SurfaceHolder surfaceHolder`  L221
- `int i3`  L222
- `int i4 = this.frmH`  L224
- `int i5 = this.previewCodec`  L229
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L231

方法（14）：
- `public VideoStreaming(PanoramaVideoPlayback videoPlayback)`  L38
- `void changePanoramaType(int var1)`  L42
- `void setFramePtsChangedListener(VideoFramePtsChangedListener framePtsChangedListener)`  L48
- `void initSurface(boolean enableRender, SurfaceHolder surfaceHolder, long videoWidth, long videoHeigth)`  L52
- `void setViewParam(int w, int h)`  L71
- `void setDrawingArea(int windowW, int windowH)`  L79
- `boolean play(ICatchFile iCatchFile, boolean disableAudio, boolean isRemote)`  L91
- `void startDecoderThread(int previewLaunchMode, ICatchVideoFormat videoFormat)`  L129
- `boolean stop()`  L154
- `boolean stopForSdRemove()`  L174
- `boolean release()`  L193
- `void removeSurface(int iCatchSphereType)`  L202
- `boolean isStreaming()`  L214
- `void setSurfaceViewArea()`  L218
### `com.gku.dashcam.icatch.ThumbnailOperation`
L10 · [class] public ThumbnailOperation · `com/gku/dashcam/icatch/ThumbnailOperation.java`

字段/常量（3）：
- `String TAG = "ThumbnailOperation"`  L11
- `ICatchFrameBuffer thumbnail`  L18
- `ICatchFrameBuffer thumbnail`  L51

方法（5）：
- `int getBatteryLevelIcon(int batteryPower)`  L13
- `Bitmap getVideoThumbnailFromSdk(String videoPath)`  L17
- `Bitmap getVideoThumbnail(String videoPath)`  L41
- `Bitmap getlocalVideoWallThumbnail(ICatchCameraPlayback iCatchCameraPlayback, String videoPath)`  L45
- `Bitmap getLocalVideoThumbnail(ICatchCameraPlayback iCatchCameraPlayback, String videoPath)`  L50
### `com.gku.dashcam.icatch.type.CameraSwitch`
L4 · [class] public CameraSwitch · `com/gku/dashcam/icatch/type/CameraSwitch.java`

字段/常量（2）：
- `int CAMERA_BACK = 1`  L5
- `int CAMERA_FRONT = 0`  L6
### `com.gku.dashcam.icatch.type.FileType`
L4 · [enum] public FileType · `com/gku/dashcam/icatch/type/FileType.java`

枚举常量（2）：
- `FILE_VIDEO()`  L5
- `FILE_PHOTO()`  L6
### `com.gku.dashcam.icatch.type.MotionDetect`
L4 · [class] public MotionDetect · `com/gku/dashcam/icatch/type/MotionDetect.java`

字段/常量（2）：
- `int MOTION_OFF = 0`  L5
- `int MOTION_ON = 1`  L6
### `com.gku.dashcam.icatch.type.PhotoWallLayoutType`
L4 · [enum] public PhotoWallLayoutType · `com/gku/dashcam/icatch/type/PhotoWallLayoutType.java`

枚举常量（2）：
- `PREVIEW_TYPE_LIST()`  L5
- `PREVIEW_TYPE_GRID()`  L6
### `com.gku.dashcam.icatch.type.SlowMotion`
L4 · [class] public SlowMotion · `com/gku/dashcam/icatch/type/SlowMotion.java`

字段/常量（2）：
- `int SLOW_MOTION_OFF = 0`  L5
- `int SLOW_MOTION_ON = 1`  L6
### `com.gku.dashcam.icatch.type.TimeLapseDuration`
L11 · [class] public TimeLapseDuration · `com/gku/dashcam/icatch/type/TimeLapseDuration.java`

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
- `int i = value / 60`  L76
- `int i2 = value % 60`  L77
- `String str = "<binary/metadata>"`  L78

方法（8）：
- `public TimeLapseDuration(CameraProperties cameraProperties)`  L25
- `String getCurrentValue()`  L30
- `String[] getValueStringList()`  L34
- `int[] getValueStringInt()`  L38
- `boolean setValueByPosition(int position)`  L42
- `void initTimeLapseDuration()`  L46
    - 体内字面量："TimeLapseDuration" · "begin initTimeLapseDuration" · "TimeLapseDuration" · "end initTimeLapseDuration timeLapseDuration ="
- `Boolean needDisplayByMode(int previewMode)`  L65
- `String convertTimeLapseDuration(int value)`  L72
### `com.gku.dashcam.icatch.type.TimeLapseInterval`
L9 · [class] public TimeLapseInterval · `com/gku/dashcam/icatch/type/TimeLapseInterval.java`

字段/常量（8）：
- `int TIME_LAPSE_INTERVAL_OFF = 0`  L10
- `CameraProperties cameraProperties`  L11
- `String tag = "TimeLapseInterval"`  L12
- `int[] valueListInt`  L13
- `String[] valueListString`  L14
- `int i = value / 3600`  L70
- `int i3 = value % 60`  L72
- `String str = "<binary/metadata>"`  L73

方法（8）：
- `public TimeLapseInterval(CameraProperties cameraProperties)`  L16
- `String getCurrentValue()`  L20
- `String[] getValueStringList()`  L24
- `int[] getValueStringInt()`  L29
- `boolean setValueByPosition(int position)`  L33
- `void initTimeLapseInterval()`  L37
    - 体内字面量："TimeLapseInterval" · "begin initTimeLapseInterval" · "TimeLapseInterval" · "end initTimeLapseInterval timeLapseInterval ="
- `Boolean needDisplayByMode(int previewMode)`  L56
- `String convertTimeLapseInterval(int value)`  L63
    - 体内字面量："OFF" · "0.5 Sec"
### `com.gku.dashcam.icatch.type.TimeLapseMode`
L4 · [class] public TimeLapseMode · `com/gku/dashcam/icatch/type/TimeLapseMode.java`

字段/常量（2）：
- `int TIME_LAPSE_MODE_STILL = 0`  L5
- `int TIME_LAPSE_MODE_VIDEO = 1`  L6
### `com.gku.dashcam.icatch.type.Tristate`
L4 · [enum] public Tristate · `com/gku/dashcam/icatch/type/Tristate.java`

枚举常量（3）：
- `FALSE()`  L5
- `NORMAL()`  L6
- `SIZE_NOT_SUPPORT()`  L7
### `com.gku.dashcam.icatch.type.Upside`
L4 · [class] public Upside · `com/gku/dashcam/icatch/type/Upside.java`

字段/常量（2）：
- `int UPSIDE_OFF = 0`  L5
- `int UPSIDE_ON = 1`  L6
### `com.gku.dashcam.icatch.ui.activity.PhotoPbActivity`
L23 · [class] public PhotoPbActivity · extends `BaseActivity implements PhotoPbView` · implements `PhotoPbView` · `com/gku/dashcam/icatch/ui/activity/PhotoPbActivity.java`

字段/常量（13）：
- `String TAG = "PhotoPbActivity"`  L24
- `ImageButton back`  L25
- `LinearLayout bottomBar`  L26
- `ImageButton deleteBtn`  L27
- `ImageButton doNext`  L28
- `ImageButton doPrevious`  L29
- `ImageButton downloadBtn`  L30
- `TextView indexInfoTxv`  L31
- `SurfaceView mSurfaceView`  L32
- `TextView panoramaTypeTxv`  L33
- `PhotoPbPresenter presenter`  L34
- `RelativeLayout topBar`  L35
- `ViewPager viewPager`  L36

方法（28）：
- `void onCreate(Bundle savedInstanceState)`  L39 @Override
- `void onClick(View view)`  L60 @Override
- `void onClick(View v)`  L66 @Override
- `void onClick(View v)`  L72 @Override
- `void surfaceCreated(SurfaceHolder holder)`  L78 @Override
- `void surfaceChanged(SurfaceHolder holder, int format, int width, int height)`  L84 @Override
- `void surfaceDestroyed(SurfaceHolder holder)`  L89 @Override
- `boolean onTouch(View v, MotionEvent event)`  L95 @Override
- `void onClick(View v)`  L113 @Override
- `void onClick(View v)`  L119 @Override
- `void onClick(View v)`  L124 @Override
- `void onClick(View v)`  L132 @Override
- `void onClick(View v)`  L138 @Override
- `void onResume()`  L146 @Override
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L154 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `void onStop()`  L168 @Override
- `void onDestroy()`  L174 @Override
- `void setViewPagerAdapter(PagerAdapter adapter)`  L181 @Override
- `void setTopBarVisibility(int visibility)`  L188 @Override
- `void setBottomBarVisibility(int visibility)`  L193 @Override
- `void setIndexInfoTxv(String photoName)`  L198 @Override
- `void setViewPagerCurrentItem(int position)`  L203 @Override
- `void setOnPageChangeListener(ViewPager.OnPageChangeListener listener)`  L208 @Override
- `int getViewPagerCurrentItem()`  L213 @Override
- `int getTopBarVisibility()`  L218 @Override
- `void setSurfaceviewVisibility(int visibility)`  L223 @Override
- `void setPanoramaTypeTxv(int resId)`  L230 @Override
- `void setViewPagerVisibility(int visibility)`  L235 @Override
### `com.gku.dashcam.icatch.ui.activity.PreviewActivity`
L46 · [class] public PreviewActivity · extends `CameraBaseActivity implements PreviewView, View.OnClickListener` · implements `PreviewView, View.OnClickListener` · `com/gku/dashcam/icatch/ui/activity/PreviewActivity.java`

字段/常量（40）：
- `String TAG = "PreviewActivity"`  L47
- `ActionBar actionBar`  L48
- `ImageView autoDownloadImagview`  L49
- `ImageView batteryStatus`  L50
- `ImageView burstStatus`  L51
- `ImageButton captureBtn`  L52
- `RadioButton captureRadioBtn`  L53
- `ImageView carMode`  L54
- `View contentView`  L55
- `RelativeLayout delayCaptureLayout`  L56
- `TextView delayCaptureText`  L57
- `RelativeLayout imageSizeLayout`  L58
- `TextView imageSizeTxv`  L59
- `SurfaceView mSurfaceView`  L60
- `ListView mainMenuList`  L61
- `List<SettingMenu> mainSettingMenuList`  L62
- `TextView noSupportPreviewTxv`  L63
- `ImageButton panoramaTypeBtn`  L64
- `ImageButton pbBtn`  L65
- `PreviewPresenter presenter`  L66
- `ImageButton pvModeBtn`  L67
- `PopupWindow pvModePopupWindow`  L68
- `TextView recordingTime`  L69
- `TextView remainCaptureCountText`  L70
- `TextView remainRecordingTimeText`  L71
- `MenuItem settingMenu`  L72
- `RelativeLayout setupMainMenu`  L73
- `ImageView slowMotion`  L74
- `ImageView timelapseMode`  L75
- `RadioButton timepLapseRadioBtn`  L76
- `Toolbar toolbar`  L77
- `RadioButton videoRadioBtn`  L78
- `RelativeLayout videoSizeLayout`  L79
- `TextView videoSizeTxv`  L80
- `ImageView wbStatus`  L81
- `ImageView wifiStatus`  L82
- `ZoomView zoomView`  L83
- `PopupWindow popupWindow = this.pvModePopupWindow`  L630
- `ImageButton imageButton = this.pvModeBtn`  L631
- `PopupWindow popupWindow = this.pvModePopupWindow`  L658

方法（89）：
- `void addData()`  L86 @Override
- `void initView()`  L90 @Override
- `void onProgressCancelListener(DialogInterface dialog)`  L94 @Override
- `void onCreate(Bundle savedInstanceState)`  L98 @Override
- `void onClick(View v)`  L158 @Override
- `void onClick(View v)`  L167 @Override
- `void onProgressChanged(ZoomView zoomView2, float progress, boolean fromUser)`  L176 @Override
- `void onStartTrackingTouch(ZoomView zoomView2)`  L180 @Override
- `void onStopTrackingTouch(ZoomView zoomView2)`  L184 @Override
- `void onClick(View v)`  L190 @Override
- `void onItemClick(AdapterView<?> parent, View view, int position, long id)`  L199 @Override
- `void onClick(View v)`  L208 @Override
- `void onClick(View v)`  L217 @Override
- `void onClick(View v)`  L226 @Override
- `void surfaceCreated(SurfaceHolder holder)`  L235 @Override
    - 体内字面量："wifi" · "\"" · "tigertiger" · "reconnect mWifiInfo.getSSID()="
- `void surfaceChanged(SurfaceHolder holder, int format, int width, int height)`  L245 @Override
    - 体内字面量："surfaceChanged!!!"
- `void surfaceDestroyed(SurfaceHolder holder)`  L251 @Override
- `boolean onTouch(View v, MotionEvent event)`  L257 @Override
- `void onClick(View view)`  L280 @Override
- `boolean checkCameraConnectStates()`  L286
    - 体内字面量："\"" · "EUKI" · "euki" · "GKU" · "gku"
- `String getSSID()`  L291
    - 体内字面量："wifi"
- `void onResume()`  L296 @Override
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L305 @Override
- `void onDestroy()`  L317 @Override
- `void sdCardIsNotReadyAlert()`  L323
    - 体内字面量："OK"
- `void onClick(DialogInterface dialog, int which)`  L328 @Override
- `void noModelNameAlert()`  L337
    - 体内字面量："äº§ååç§°è·åå¤±è´¥,æ æ³æ´æ°åºä»¶" · "OK"
- `void onClick(DialogInterface dialog, int which)`  L342 @Override
- `boolean onCreateOptionsMenu(Menu menu)`  L352 @Override
- `boolean onOptionsItemSelected(MenuItem item)`  L358 @Override
- `void onClick(View v)`  L372 @Override
- `void setWbStatusVisibility(int visibility)`  L388 @Override
- `void setBurstStatusVisibility(int visibility)`  L393 @Override
- `void setWifiStatusVisibility(int visibility)`  L398 @Override
- `void setWifiIcon(int drawableId)`  L403 @Override
- `void setBatteryStatusVisibility(int visibility)`  L408 @Override
- `void setBatteryIcon(int drawableId)`  L413 @Override
- `void settimeLapseModeVisibility(int visibility)`  L418 @Override
- `void settimeLapseModeIcon(int drawableId)`  L423 @Override
- `void setSlowMotionVisibility(int visibility)`  L428 @Override
- `void setCarModeVisibility(int visibility)`  L433 @Override
- `void setRecordingTimeVisibility(int visibility)`  L438 @Override
- `void setAutoDownloadVisibility(int visibility)`  L443 @Override
- `void setCaptureBtnBackgroundResource(int id)`  L448 @Override
- `void setRecordingTime(String laspeTime)`  L453 @Override
- `void setDelayCaptureLayoutVisibility(int visibility)`  L458 @Override
- `void setDelayCaptureTextTime(String delayCaptureTime)`  L463 @Override
- `void setImageSizeLayoutVisibility(int visibility)`  L468 @Override
- `void setRemainCaptureCount(String remainCaptureCount)`  L473 @Override
- `void setVideoSizeLayoutVisibility(int visibility)`  L478 @Override
- `void setRemainRecordingTimeText(String remainRecordingTime)`  L484 @Override
- `void setBurstStatusIcon(int drawableId)`  L489 @Override
- `void setWbStatusIcon(int drawableId)`  L494 @Override
- `void setUpsideVisibility(int visibility)`  L499 @Override
- `void setCaptureBtnEnability(boolean enablity)`  L504 @Override
- `void setVideoSizeInfo(String sizeInfo)`  L509 @Override
- `void setImageSizeInfo(String sizeInfo)`  L514 @Override
- `void showZoomView()`  L519 @Override
- `void hideZoomView()`  L524 @Override
- `void setMaxZoomRate(final float maxZoomRate)`  L529 @Override
- `void setMinZoomRate(final float minZoomRate)`  L534 @Override
- `float getZoomViewProgress()`  L539 @Override
- `float getZoomViewMaxZoomRate()`  L544 @Override
- `void updateZoomViewProgress(float currentZoomRatio)`  L549 @Override
- `int getSetupMainMenuVisibility()`  L555 @Override
- `void setSetupMainMenuVisibility(int visibility)`  L560 @Override
- `void setAutoDownloadBitmap(Bitmap bitmap)`  L565 @Override
- `void setActionBarTitle(int resId)`  L572 @Override
- `void setSettingBtnVisible(boolean isVisible)`  L577 @Override
- `void setBackBtnVisibility(boolean isVisible)`  L582 @Override
- `void setSettingMenuListAdapter(SettingListAdapter settingListAdapter)`  L587 @Override
- `void onConfigurationChanged(Configuration newConfig)`  L592 @Override
- `void run()`  L596 @Override
- `void setSupportPreviewTxvVisibility(int visibility)`  L603 @Override
- `void setPvModeBtnBackgroundResource(int drawableId)`  L608 @Override
- `void setTimepLapseRadioBtnVisibility(int visibility)`  L613 @Override
- `void setCaptureRadioBtnVisibility(int visibility)`  L618 @Override
- `void showPopupWindow(int curMode)`  L623 @Override
- `void setVideoRadioBtnVisibility(int visibility)`  L637 @Override
- `void setTimepLapseRadioChecked(boolean checked)`  L642 @Override
- `void setCaptureRadioBtnChecked(boolean checked)`  L647 @Override
- `void setVideoRadioBtnChecked(boolean checked)`  L652 @Override
- `void dismissPopupWindow()`  L657 @Override
- `int getSurfaceViewWidth()`  L666 @Override
- `int getSurfaceViewHeight()`  L671 @Override
- `void setPanoramaTypeBtnSrc(int srcId)`  L676 @Override
- `void setPanoramaTypeBtnVisibility(int visibility)`  L681 @Override
- `void setMenuList(List<SettingMenu> settingMenuList)`  L686 @Override
- `int setContentRes()`  L691 @Override
### `com.gku.dashcam.icatch.ui.activity.RemoteMultiPbActivity`
L35 · [class] public RemoteMultiPbActivity · extends `BaseActivity implements MultiPbView` · implements `MultiPbView` · `com/gku/dashcam/icatch/ui/activity/RemoteMultiPbActivity.java`

字段/常量（12）：
- `String TAG = "RemoteMultiPbActivity"`  L36
- `ImageButton deleteBtn`  L37
- `ImageButton downloadBtn`  L38
- `MenuItem filterItem`  L39
- `MenuItem menuPhotoWallType`  L40
- `LinearLayout multiPbEditLayout`  L41
- `RemoteMultiPbPresenter presenter`  L42
- `ImageButton selectBtn`  L43
- `TextView selectedNumTxv`  L44
- `TabLayout tabLayout`  L45
- `ViewPager viewPager`  L46
- `MenuItem menuItem = this.filterItem`  L160

方法（28）：
- `void setMenuPhotoWallTypeIcon(int iconRes)`  L49 @Override
- `void setViewPagerScanScroll(boolean isCanScroll)`  L53 @Override
- `void onCreate(Bundle savedInstanceState)`  L57 @Override
- `void onPageScrollStateChanged(int state)`  L74 @Override
- `void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)`  L78 @Override
- `void onPageSelected(int position)`  L82 @Override
- `void onClick(View v)`  L88 @Override
- `void onClick(View v)`  L94 @Override
- `void onClick(View v)`  L100 @Override
    - 体内字面量："mScroller"
- `void onStart()`  L121 @Override
- `void onStop()`  L126 @Override
- `void onResume()`  L132 @Override
- `void onDestroy()`  L139 @Override
- `boolean onCreateOptionsMenu(Menu menu)`  L151 @Override
- `void setFilterItemVisibility(boolean visibility)`  L159 @Override
- `boolean onOptionsItemSelected(MenuItem item)`  L167 @Override
- `void showFilterDialog()`  L187
    - 体内字面量："dialog"
- `void onSureClick(FileFilter fileFilter)`  L199 @Override
    - 体内字面量："dialog"
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L207 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `void setViewPageAdapter(FragmentPagerAdapter adapter)`  L221 @Override
- `void setViewPageCurrentItem(int item)`  L226 @Override
- `void setSelectNumText(String text)`  L231 @Override
- `void setSelectBtnVisibility(int visibility)`  L236 @Override
- `void setSelectBtnIcon(int icon)`  L241 @Override
- `void setSelectNumTextVisibility(int visibility)`  L246 @Override
- `void setTabLayoutClickable(boolean value)`  L251 @Override
- `void setEditLayoutVisibility(int visibility)`  L260 @Override
- `int getViewPageIndex()`  L265 @Override
### `com.gku.dashcam.icatch.ui.activity.VideoPb2Activity`
L26 · [class] public VideoPb2Activity · extends `BaseActivity implements VideoPbView` · implements `VideoPbView` · `com/gku/dashcam/icatch/ui/activity/VideoPb2Activity.java`

字段/常量（20）：
- `String TAG = "VideoPb2Activity"`  L27
- `ImageButton back`  L28
- `LinearLayout bottomBar`  L29
- `ImageButton cancelBtn`  L30
- `ImageView deleteBtn`  L31
- `TextView deleteTxv`  L32
- `ImageButton downloadBtn`  L33
- `Switch eisSwitch`  L34
- `SurfaceView mSurfaceView`  L35
- `ImageButton moreBtn`  L36
- `LinearLayout moreSettingLayout`  L37
- `ImageButton panoramaTypeBtn`  L38
- `ImageButton play`  L39
- `VideoPbPresenter presenter`  L40
- `ProgressWheel progressWheel`  L41
- `SeekBar seekBar`  L42
- `TextView timeDuration`  L43
- `TextView timeLapsed`  L44
- `LinearLayout topBar`  L45
- `TextView videoNameTxv`  L46

方法（46）：
- `void setProgress(float progress)`  L49 @Override
- `void onCreate(Bundle savedInstanceState)`  L53 @Override
- `void onClick(View view)`  L81 @Override
- `void onClick(View view)`  L87 @Override
- `void onClick(View view)`  L93 @Override
- `void onClick(View view)`  L99 @Override
- `void onClick(View v)`  L106 @Override
- `void onClick(View view)`  L112 @Override
- `void onClick(View v)`  L118 @Override
- `void onClick(View v)`  L124 @Override
- `void onClick(View v)`  L130 @Override
- `void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)`  L136 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L141 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L146 @Override
- `void onClick(View v)`  L152 @Override
- `void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7)`  L158 @Override
- `void surfaceCreated(SurfaceHolder holder)`  L167 @Override
- `void surfaceChanged(SurfaceHolder holder, int format, int width, int height)`  L173 @Override
- `void surfaceDestroyed(SurfaceHolder holder)`  L178 @Override
- `boolean onTouch(View v, MotionEvent event)`  L184 @Override
- `void onResume()`  L203 @Override
- `void onStop()`  L210 @Override
- `void onDestroy()`  L216 @Override
- `void setTopBarVisibility(int visibility)`  L223 @Override
- `void setBottomBarVisibility(int visibility)`  L228 @Override
- `void setTimeLapsedValue(String value)`  L233 @Override
- `void setTimeDurationValue(String value)`  L238 @Override
- `void setSeekBarProgress(int value)`  L243 @Override
- `void setSeekBarMaxValue(int value)`  L248 @Override
- `int getSeekBarProgress()`  L253 @Override
- `void setSeekBarSecondProgress(int value)`  L258 @Override
- `void setPlayBtnSrc(int resid)`  L263 @Override
- `void showLoadingCircle(boolean isShow)`  L268 @Override
    - 体内字面量："0%"
- `void setLoadPercent(int value)`  L280 @Override
    - 体内字面量："%"
- `void setVideoNameTxv(String value)`  L287 @Override
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L292 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `int getSurfaceViewWidth()`  L306 @Override
- `int getSurfaceViewHeight()`  L311 @Override
- `void setPanoramaTypeImageResource(int resId)`  L316 @Override
- `void setPanoramaTypeBtnVisibility(int visibility)`  L321 @Override
- `void setMoreSettingLayoutVisibility(int visibility)`  L326 @Override
- `void setEisSwitchChecked(boolean checked)`  L331 @Override
- `void setSeekbarEnabled(boolean enabled)`  L336 @Override
- `void setDownloadBtnEnabled(boolean enabled)`  L343 @Override
- `void onConfigurationChanged(Configuration newConfig)`  L353 @Override
- `void run()`  L357 @Override
### `com.gku.dashcam.icatch.ui.adapter.DownloadManagerAdapter`
L20 · [class] public DownloadManagerAdapter · extends `BaseAdapter` · `com/gku/dashcam/icatch/ui/adapter/DownloadManagerAdapter.java`

字段/常量（6）：
- `String TAG = "DownloadManagerAdapter"`  L21
- `List<ICatchFile> actList`  L22
- `HashMap<Integer, DownloadInfo> chooseListMap`  L23
- `Context context`  L24
- `Handler handler`  L25
- `OnCancelBtnClickListener onCancelBtnClickListener`  L26

方法（7）：
- `Object getItem(int arg0)`  L33 @Override
- `long getItemId(int arg0)`  L38 @Override
- `public DownloadManagerAdapter(Context context, HashMap<Integer, DownloadInfo> downloadDataList, List<ICatchFile> actList, Handler handler)`  L42
- `void setOnCancelBtnClickListener(OnCancelBtnClickListener onCancelBtnClickListener)`  L49
- `int getCount()`  L54 @Override
- `View getView(int position, View convertView, ViewGroup arg2)`  L59 @Override
    - 体内字面量："#.#" · "M" · "M" · "/" · "/" · "/"
- `void onClick(View arg0)`  L90 @Override
### `com.gku.dashcam.icatch.ui.adapter.DownloadManagerAdapter$OnCancelBtnClickListener`
L28 · [interface] public OnCancelBtnClickListener · `com/gku/dashcam/icatch/ui/adapter/DownloadManagerAdapter.java`

方法（1）：
- `void onClick(ICatchFile downloadFile)`  L29
### `com.gku.dashcam.icatch.ui.adapter.FilterGridAdaper`
L14 · [class] public FilterGridAdaper · extends `BaseAdapter` · `com/gku/dashcam/icatch/ui/adapter/FilterGridAdaper.java`

字段/常量（8）：
- `Context context`  L15
- `List<FilterItem> list`  L16
- `LayoutInflater mInflater`  L17
- `int width`  L18
- `String TAG = "FilterGridAdaper"`  L19
- `int selectorPosition = -1`  L20
- `View viewInflate`  L49
- `ViewHolder viewHolder`  L50

方法（8）：
- `long getItemId(int position)`  L27 @Override
- `public FilterGridAdaper(Context context, List<FilterItem> list)`  L31
- `int getCount()`  L38 @Override
- `Object getItem(int position)`  L43 @Override
- `View getView(int position, View convertView, ViewGroup parent)`  L48 @Override
- `void setSelectorPosition(int selectorPosition)`  L71
- `int getSelectorPosition()`  L75
- `void changeState(int pos)`  L79
### `com.gku.dashcam.icatch.ui.adapter.FilterGridAdaper$ViewHolder`
L22 · [class] public static ViewHolder · `com/gku/dashcam/icatch/ui/adapter/FilterGridAdaper.java`

字段/常量（1）：
- `TextView textView`  L23
### `com.gku.dashcam.icatch.ui.adapter.MultiPbRecyclerViewAdapter`
L27 · [class] public MultiPbRecyclerViewAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/gku/dashcam/icatch/ui/adapter/MultiPbRecyclerViewAdapter.java`

字段/常量（17）：
- `int TYPE_GRID = 1`  L28
- `int TYPE_LIST = 2`  L29
- `int TYPE_QUICK_LIST = 3`  L30
- `FileType fileType`  L31
- `List<MultiPbItemInfo> list`  L32
- `int width`  L33
- `int TYPE_FOOTER = 4`  L34
- `int LOADING = 1`  L35
- `int LOADING_COMPLETE = 2`  L36
- `int LOADING_END = 3`  L37
- `int curViewType = 1`  L38
- `int loadState = 2`  L39
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L40
- `MultiPbItemInfo multiPbItemInfo`  L76
- `int i = this.loadState`  L125
- `int i = 0`  L272
- `List<MultiPbItemInfo> list = this.list`  L282

方法（19）：
- `public MultiPbRecyclerViewAdapter(Context context, List<MultiPbItemInfo> list, FileType fileType)`  L42
- `int getItemViewType(int position)`  L49 @Override
- `void setCurViewType(int curViewType)`  L56
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L61 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder holder, int position)`  L75 @Override
- `int getItemCount()`  L146 @Override
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L151 @Override
- `int getSpanSize(int position)`  L157 @Override
- `void setLoadState(int loadState)`  L219
- `int getLoadState()`  L224
- `void setOperationMode(OperationMode operationMode)`  L228
- `void changeCheckBoxState(int position)`  L232
- `List<MultiPbItemInfo> getCheckedItemsList()`  L239
- `void quitEditMode()`  L249
- `void selectAllItems()`  L257
- `void cancelAllSelections()`  L264
- `int getSelectedCount()`  L271
- `void sortDataByDate()`  L281
- `int compare(MultiPbItemInfo lhs, MultiPbItemInfo rhs)`  L288 @Override
### `com.gku.dashcam.icatch.ui.adapter.MultiPbRecyclerViewAdapter$FootViewHolder`
L206 · [class] private FootViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/dashcam/icatch/ui/adapter/MultiPbRecyclerViewAdapter.java`

字段/常量（3）：
- `LinearLayout llEnd`  L207
- `ProgressBar pbLoading`  L208
- `TextView tvLoading`  L209
### `com.gku.dashcam.icatch.ui.adapter.MultiPbRecyclerViewAdapter$RecyclerViewGridHolder`
L164 · [class] private RecyclerViewGridHolder · extends `RecyclerView.ViewHolder` · `com/gku/dashcam/icatch/ui/adapter/MultiPbRecyclerViewAdapter.java`

字段/常量（4）：
- `ImageView mCheckImageView`  L165
- `ImageView mImageView`  L166
- `ImageView mIsPanoramaSign`  L167
- `ImageView videoSignImageView`  L168
### `com.gku.dashcam.icatch.ui.adapter.MultiPbRecyclerViewAdapter$RecyclerViewListHolder`
L179 · [class] private RecyclerViewListHolder · extends `RecyclerView.ViewHolder` · `com/gku/dashcam/icatch/ui/adapter/MultiPbRecyclerViewAdapter.java`

字段/常量（10）：
- `TextView imageDateTextView`  L180
- `TextView imageDurationView`  L181
- `TextView imageNameTextView`  L182
- `TextView imageSizeTextView`  L183
- `ImageView imageView`  L184
- `ImageView mCheckImageView`  L185
- `ImageView mIsPanoramaSign`  L186
- `boolean showThumbnail`  L187
- `FrameLayout thumbnailLayout`  L188
- `ImageView videoSignImageView`  L189
### `com.gku.dashcam.icatch.ui.adapter.PhotoPbViewPagerAdapter`
L18 · [class] public PhotoPbViewPagerAdapter · extends `PagerAdapter` · `com/gku/dashcam/icatch/ui/adapter/PhotoPbViewPagerAdapter.java`

字段/常量（4）：
- `String TAG = "PhotoPbViewPagerAdapter"`  L19
- `Context context`  L20
- `List<MultiPbItemInfo> filesList`  L21
- `OnPhotoTapListener onPhotoTapListener`  L22

方法（10）：
- `boolean isViewFromObject(View arg0, Object arg1)`  L29 @Override
- `public PhotoPbViewPagerAdapter(Context context, List<MultiPbItemInfo> filesList)`  L33
- `void destroyItem(ViewGroup container, int position, Object object)`  L39 @Override
- `Object instantiateItem(ViewGroup container, final int position)`  L46 @Override
- `void onLoadingStarted(String imageUri, View view)`  L54 @Override
- `void onLoadingFailed(String imageUri, View view)`  L60 @Override
- `void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)`  L66 @Override
- `void onPhotoTap(View view, float v, float v1)`  L73 @Override
- `int getCount()`  L85 @Override
- `void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener)`  L89
### `com.gku.dashcam.icatch.ui.adapter.PhotoPbViewPagerAdapter$OnPhotoTapListener`
L24 · [interface] public OnPhotoTapListener · `com/gku/dashcam/icatch/ui/adapter/PhotoPbViewPagerAdapter.java`

方法（1）：
- `void onPhotoTap()`  L25
### `com.gku.dashcam.icatch.ui.adapter.SettingListAdapter`
L23 · [class] public SettingListAdapter · extends `BaseAdapter` · `com/gku/dashcam/icatch/ui/adapter/SettingListAdapter.java`

字段/常量（7）：
- `String TAG = "SettingListAdapter"`  L24
- `BaseProperties baseProperties`  L25
- `CameraProperties cameraProperties`  L26
- `Context context`  L27
- `DashCamera currCamera`  L28
- `Handler handler`  L29
- `List<SettingMenu> menuList`  L30

方法（10）：
- `Object getItem(int arg0)`  L33 @Override
- `long getItemId(int arg0)`  L38 @Override
- `public SettingListAdapter(Context context, List<SettingMenu> menuList, Handler handler)`  L42
- `int getCount()`  L53 @Override
- `View getView(int position, View convertView, ViewGroup parent)`  L58 @Override
- `void onClick(View arg0)`  L67 @Override
- `void onClick(View arg0)`  L81 @Override
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L94 @Override
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L114 @Override
    - 体内字面量："GB"
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L138 @Override
### `com.gku.dashcam.icatch.ui.adapter.SettingListAdapter$ViewHolder`
L166 · [class] public final ViewHolder · `com/gku/dashcam/icatch/ui/adapter/SettingListAdapter.java`

字段/常量（2）：
- `TextView text`  L167
- `TextView title`  L168

方法（1）：
- `public ViewHolder()`  L170
### `com.gku.dashcam.icatch.ui.adapter.ViewPagerAdapter`
L10 · [class] public ViewPagerAdapter · extends `FragmentPagerAdapter` · `com/gku/dashcam/icatch/ui/adapter/ViewPagerAdapter.java`

字段/常量（2）：
- `List<Fragment> mFragmentList`  L11
- `List<String> mFragmentTitleList`  L12

方法（5）：
- `public ViewPagerAdapter(FragmentManager manager)`  L14
- `Fragment getItem(int position)`  L21 @Override
- `int getCount()`  L26 @Override
- `void addFragment(Fragment fragment, String title)`  L30
- `CharSequence getPageTitle(int position)`  L36 @Override
### `com.gku.dashcam.icatch.ui.customview.ZoomView`
L19 · [class] public ZoomView · extends `RelativeLayout` · `com/gku/dashcam/icatch/ui/customview/ZoomView.java`

字段/常量（14）：
- `int DISPLAY_DURATION = 5000`  L20
- `float MAX_VALUE = 0.0f`  L21
- `float MIN_VALUE = 0.0f`  L22
- `String TAG = "ZoomView"`  L23
- `int zoomGrained = 10`  L24
- `boolean firstCreate`  L25
- `OnSeekBarChangeListener onSeekBarChangeListener`  L26
- `Timer timer`  L27
- `SeekBar zoomBar`  L28
- `ImageButton zoomIn`  L29
- `ImageButton zoomOut`  L30
- `TextView zoomRateText`  L31
- `Timer timer = this.timer`  L129
- `Timer timer`  L153

方法（21）：
- `public ZoomView(Context context, AttributeSet attrs)`  L41
- `void run()`  L51 @Override
- `void setZoomInOnclickListener(View.OnClickListener onclickListener)`  L57
- `void setZoomOutOnclickListener(View.OnClickListener onclickListener)`  L61
- `void setOnSeekBarChangeListener(final OnSeekBarChangeListener onSeekBarChangeListener)`  L65
- `void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)`  L69 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L74 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L79 @Override
- `void updateZoomRateText(float zoomRate)`  L85
    - 体内字面量："x "
- `void updateZoomBarValue(int value)`  L89
- `void updateZoomBarValue(float value)`  L93
- `void setProgress(float value)`  L97
- `void setMinValue(int minValue)`  L101
- `void setMinValue(float minValue)`  L105
- `void setMaxValue(float maxValue)`  L109
- `void setMaxValue(int maxValue)`  L114
- `float getProgress()`  L119
- `void startDisplay()`  L123
- `void run()`  L136 @Override
- `void run()`  L141 @Override
- `void setHide()`  L152
### `com.gku.dashcam.icatch.ui.customview.ZoomView$OnSeekBarChangeListener`
L33 · [interface] public OnSeekBarChangeListener · `com/gku/dashcam/icatch/ui/customview/ZoomView.java`

方法（3）：
- `void onProgressChanged(ZoomView zoomView, float progress, boolean fromUser)`  L34
- `void onStartTrackingTouch(ZoomView zoomView)`  L36
- `void onStopTrackingTouch(ZoomView zoomView)`  L38
### `com.gku.dashcam.icatch.ui.fragment.BaseMultiPbFragment`
L10 · [class] public abstract BaseMultiPbFragment · extends `Fragment` · `com/gku/dashcam/icatch/ui/fragment/BaseMultiPbFragment.java`

方法（7）：
- `void changePreviewType(PhotoWallLayoutType layoutType)`  L11
- `void deleteFile()`  L13
- `List<MultiPbItemInfo> getSelectedList()`  L15
- `void loadPhotoWall()`  L17
- `void quitEditMode()`  L19
- `void selectOrCancelAll(boolean isSelectAll)`  L21
- `void setOperationListener(OnStatusChangedListener modeChangedListener)`  L23
### `com.gku.dashcam.icatch.ui.fragment.DialogFragmentFromBottom`
L35 · [class] public DialogFragmentFromBottom · extends `DialogFragment` · `com/gku/dashcam/icatch/ui/fragment/DialogFragmentFromBottom.java`

字段/常量（42）：
- `String ANIM = "anim_style"`  L36
- `String BOTTOM = "show_bottom"`  L37
- `String CANCEL = "out_cancel"`  L38
- `String DIM = "dim_amount"`  L39
- `String HEIGHT = "height"`  L40
- `String LAYOUT = "layout_id"`  L41
- `String MARGIN = "margin"`  L42
- `String TAG = "DialogFragmentFromBottom"`  L43
- `String WIDTH = "width"`  L44
- `String formatType = "yyyy-MM-dd HH:mm:ss"`  L45
- `int animStyle`  L46
- `FilterGridAdaper cameraTypeAdaper`  L47
- `GridView cameraTypeGridView`  L48
- `int height`  L49
- `FileFilter lastFilter`  L50
- `LinearLayout layout`  L51
- `int layoutId`  L52
- `int margin`  L53
- `TextView maxTimeEdt`  L54
- `TextView minTimeEdt`  L55
- `OnSureClickListener onSureClickListener`  L56
- `TextView resetTxv`  L57
- `FrameLayout rootlayout`  L58
- `LinkedList<FilterItem> sensorsTypeList`  L59
- `TextView sensorsTypeTxv`  L60
- `TextView sureTxv`  L61
- `FilterGridAdaper timeAdaper`  L62
- `GridView timeGridView`  L63
- `LinkedList<FilterItem> timeTypelist`  L64
- `int width`  L65
- `float dimAmount = 0.5f`  L66
- `boolean showBottom = true`  L67
- `boolean outCancel = true`  L68
- `int sensorsNum = 2`  L69
- `boolean needFilterSensors = false`  L70
- `int selectorPosition`  L115
- `int selectorPosition2`  L116
- `FileFilter fileFilter = null`  L119
- `FileFilter fileFilter = this.lastFilter`  L224
- `FileFilter fileFilter2 = this.lastFilter`  L247
- `FilterGridAdaper filterGridAdaper = this.timeAdaper`  L388
- `FilterGridAdaper filterGridAdaper = this.cameraTypeAdaper`  L396

方法（32）：
- `void onCreate(Bundle savedInstanceState)`  L77 @Override
    - 体内字面量："width" · "height"
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L93 @Override
- `void onClick(View v)`  L106 @Override
- `void onClick(View v)`  L114 @Override
- `void onClick(View v)`  L156 @Override
- `void onTimeSelect(Date date, View v2)`  L159 @Override
- `void onClick(View v)`  L171 @Override
- `void onTimeSelect(Date date, View v2)`  L174 @Override
- `void onItemClick(AdapterView<?> parent, View view, int position, long id)`  L189 @Override
- `void onItemClick(AdapterView<?> parent, View view, int position, long id)`  L199 @Override
- `void initData()`  L208
    - 体内字面量："è¿ä¸å¤©" · "è¿ä¸å¨" · "è¿ä¸ä¸ªæ" · "è¿åå¹´" · "å¨é¨" · "åç½®" · "åç½®"
- `void initUi()`  L223
- `int getPositionByType(List<FilterItem> list, int type)`  L258
- `void onStart()`  L270 @Override
- `void setLastFilter(FileFilter lastFilter)`  L275
- `void setOnSureClickListener(OnSureClickListener onSureClickListener)`  L279
- `void show02(OnTimeSelectListener listener)`  L284
- `String getDateToString(long time)`  L298
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
- `String getTime(Date d)`  L302
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
- `void onSaveInstanceState(Bundle outState)`  L307 @Override
    - 体内字面量："width" · "height"
- `void initParams()`  L319
- `DialogFragmentFromBottom setMargin(int margin)`  L346
- `DialogFragmentFromBottom setWidth(int width)`  L351
- `DialogFragmentFromBottom setHeight(int height)`  L356
- `DialogFragmentFromBottom setDimAmount(float dimAmount)`  L361
- `DialogFragmentFromBottom setShowBottom(boolean showBottom)`  L366
- `DialogFragmentFromBottom setOutCancel(boolean outCancel)`  L371
- `DialogFragmentFromBottom setAnimStyle(int animStyle)`  L376
- `DialogFragmentFromBottom show(FragmentManager manager)`  L381
- `void resetTimeFilter()`  L387
- `void resetCameraTypeFilter()`  L395
- `void resetTimeEdit()`  L403
### `com.gku.dashcam.icatch.ui.fragment.DialogFragmentFromBottom$OnSureClickListener`
L72 · [interface] public OnSureClickListener · `com/gku/dashcam/icatch/ui/fragment/DialogFragmentFromBottom.java`

方法（1）：
- `void onSureClick(FileFilter fileFilter)`  L73
### `com.gku.dashcam.icatch.ui.fragment.RemoteMultiPbFragment`
L32 · [class] public RemoteMultiPbFragment · extends `BaseMultiPbFragment implements MultiPbFragmentView` · implements `MultiPbFragmentView` · `com/gku/dashcam/icatch/ui/fragment/RemoteMultiPbFragment.java`

字段/常量（13）：
- `String TAG = "RemoteMultiPbFragment"`  L33
- `FileType fileType`  L34
- `OnStatusChangedListener modeChangedListener`  L35
- `TextView noContentTxv`  L36
- `MultiPbFragmentPresenter presenter`  L37
- `RecyclerView recyclerView`  L38
- `TextView tv_loading`  L39
- `boolean isCreated = false`  L40
- `boolean isVisible = false`  L41
- `boolean hasDeleted = false`  L42
- `MultiPbFragmentPresenter multiPbFragmentPresenter = this.presenter`  L167
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L195
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L203

方法（34）：
- `void onReceive(Context context, Intent intent)`  L45 @Override
- `void onReceive(Context context, Intent intent)`  L56 @Override
- `RemoteMultiPbFragment newInstance(int param1)`  L66
    - 体内字面量："FILE_TYPE"
- `void onCreate(Bundle savedInstanceState)`  L75 @Override
    - 体内字面量："FILE_TYPE"
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L83 @Override
- `void onItemClick(int position, View view, RecyclerView.ViewHolder viewHolder)`  L94 @Override
- `void onItemLongClick(int position, View view, RecyclerView.ViewHolder viewHolder)`  L102 @Override
- `void onLoadMore()`  L111 @Override
- `void onResume()`  L119 @Override
- `void registerVideo()`  L123
    - 体内字面量："RemainVideo_FileList"
- `void unRegisterVideo()`  L132
- `void register()`  L136
    - 体内字面量："Remain_FileList"
- `void unRegister()`  L145
- `void onStop()`  L150 @Override
- `void onDestroy()`  L156 @Override
    - 体内字面量："onDestroy" · "Fragmentç»æäº"
- `void changePreviewType(PhotoWallLayoutType layoutType)`  L166 @Override
- `void quitEditMode()`  L174 @Override
- `void setRecyclerViewVisibility(int visibility)`  L179 @Override
- `void setRecyclerViewAdapter(MultiPbRecyclerViewAdapter recyclerViewAdapter)`  L184 @Override
- `void setRecyclerViewLayoutManager(RecyclerView.LayoutManager layout)`  L189 @Override
- `void notifyChangeMultiPbMode(OperationMode operationMode)`  L194 @Override
- `void setPhotoSelectNumText(int selectNum)`  L202 @Override
- `void setNoContentTxvVisibility(int visibility)`  L210 @Override
- `void showLoading()`  L217 @Override
- `void hintLoading()`  L222 @Override
- `void onConfigurationChanged(Configuration newConfig)`  L227 @Override
    - 体内字面量："RemoteMultiPbPhotoFragment onConfigurationChanged"
- `void setUserVisibleHint(boolean isVisibleToUser)`  L234 @Override
- `void setOperationListener(OnStatusChangedListener modeChangedListener)`  L240 @Override
- `void selectOrCancelAll(boolean isSelectAll)`  L245 @Override
- `List<MultiPbItemInfo> getSelectedList()`  L250 @Override
- `FileType getFileType()`  L254
- `void deleteFile()`  L259 @Override
- `void loadPhotoWall()`  L264 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L269 @Override
    - 体内字面量："hasDeleted" · "fileType"
### `com.gku.dashcam.icatch.ui.Interface.MultiPbFragmentView`
L8 · [interface] public MultiPbFragmentView · `com/gku/dashcam/icatch/ui/Interface/MultiPbFragmentView.java`

方法（8）：
- `void hintLoading()`  L9
- `void notifyChangeMultiPbMode(OperationMode operationMode)`  L11
- `void setNoContentTxvVisibility(int visibility)`  L13
- `void setPhotoSelectNumText(int selectNum)`  L15
- `void setRecyclerViewAdapter(MultiPbRecyclerViewAdapter recyclerViewAdapter)`  L17
- `void setRecyclerViewLayoutManager(RecyclerView.LayoutManager layout)`  L19
- `void setRecyclerViewVisibility(int visibility)`  L21
- `void showLoading()`  L23
### `com.gku.dashcam.icatch.ui.Interface.MultiPbView`
L6 · [interface] public MultiPbView · `com/gku/dashcam/icatch/ui/Interface/MultiPbView.java`

方法（12）：
- `int getViewPageIndex()`  L7
- `void setEditLayoutVisibility(int visibiliy)`  L9
- `void setFilterItemVisibility(boolean visibility)`  L11
- `void setMenuPhotoWallTypeIcon(int iconRes)`  L13
- `void setSelectBtnIcon(int icon)`  L15
- `void setSelectBtnVisibility(int visibility)`  L17
- `void setSelectNumText(String text)`  L19
- `void setSelectNumTextVisibility(int visibility)`  L21
- `void setTabLayoutClickable(boolean value)`  L23
- `void setViewPageAdapter(FragmentPagerAdapter adapter)`  L25
- `void setViewPageCurrentItem(int item)`  L27
- `void setViewPagerScanScroll(boolean isCanScroll)`  L29
### `com.gku.dashcam.icatch.ui.Interface.PhotoPbView`
L7 · [interface] public PhotoPbView · `com/gku/dashcam/icatch/ui/Interface/PhotoPbView.java`

方法（11）：
- `int getTopBarVisibility()`  L8
- `int getViewPagerCurrentItem()`  L10
- `void setBottomBarVisibility(int visibility)`  L12
- `void setIndexInfoTxv(String indexInfo)`  L14
- `void setOnPageChangeListener(ViewPager.OnPageChangeListener listener)`  L16
- `void setPanoramaTypeTxv(int resId)`  L18
- `void setSurfaceviewVisibility(int visibility)`  L20
- `void setTopBarVisibility(int visibility)`  L22
- `void setViewPagerAdapter(PagerAdapter adapter)`  L24
- `void setViewPagerCurrentItem(int position)`  L26
- `void setViewPagerVisibility(int visibility)`  L28
### `com.gku.dashcam.icatch.ui.Interface.PreviewView`
L9 · [interface] public PreviewView · `com/gku/dashcam/icatch/ui/Interface/PreviewView.java`

方法（55）：
- `void dismissPopupWindow()`  L10
- `int getSetupMainMenuVisibility()`  L12
- `int getSurfaceViewHeight()`  L14
- `int getSurfaceViewWidth()`  L16
- `float getZoomViewMaxZoomRate()`  L18
- `float getZoomViewProgress()`  L20
- `void hideZoomView()`  L22
- `void setActionBarTitle(int resId)`  L24
- `void setAutoDownloadBitmap(Bitmap bitmap)`  L26
- `void setAutoDownloadVisibility(int visibility)`  L28
- `void setBackBtnVisibility(boolean isVisible)`  L30
- `void setBatteryIcon(int drawableId)`  L32
- `void setBatteryStatusVisibility(int visibility)`  L34
- `void setBurstStatusIcon(int drawableId)`  L36
- `void setBurstStatusVisibility(int visibility)`  L38
- `void setCaptureBtnBackgroundResource(int id)`  L40
- `void setCaptureBtnEnability(boolean enablity)`  L42
- `void setCaptureRadioBtnChecked(boolean checked)`  L44
- `void setCaptureRadioBtnVisibility(int visibility)`  L46
- `void setCarModeVisibility(int visibility)`  L48
- `void setDelayCaptureLayoutVisibility(int visibility)`  L50
- `void setDelayCaptureTextTime(String delayCaptureTime)`  L52
- `void setImageSizeInfo(String sizeInfo)`  L54
- `void setImageSizeLayoutVisibility(int visibility)`  L56
- `void setMaxZoomRate(float maxZoomRate)`  L58
- `void setMenuList(List<SettingMenu> settingMenuList)`  L60
- `void setMinZoomRate(float minZoomRate)`  L62
- `void setPanoramaTypeBtnSrc(int srcId)`  L64
- `void setPanoramaTypeBtnVisibility(int visibility)`  L66
- `void setPvModeBtnBackgroundResource(int drawableId)`  L68
- `void setRecordingTime(String laspeTime)`  L70
- `void setRecordingTimeVisibility(int visibility)`  L72
- `void setRemainCaptureCount(String remainCaptureCount)`  L74
- `void setRemainRecordingTimeText(String remainRecordingTime)`  L76
- `void setSettingBtnVisible(boolean isVisible)`  L78
- `void setSettingMenuListAdapter(SettingListAdapter settingListAdapter)`  L80
- `void setSetupMainMenuVisibility(int visibility)`  L82
- `void setSlowMotionVisibility(int visibility)`  L84
- `void setSupportPreviewTxvVisibility(int visibility)`  L86
- `void setTimepLapseRadioBtnVisibility(int visibility)`  L88
- `void setTimepLapseRadioChecked(boolean checked)`  L90
- `void setUpsideVisibility(int visibility)`  L92
- `void setVideoRadioBtnChecked(boolean checked)`  L94
- `void setVideoRadioBtnVisibility(int visibility)`  L96
- `void setVideoSizeInfo(String sizeInfo)`  L98
- `void setVideoSizeLayoutVisibility(int visibility)`  L100
- `void setWbStatusIcon(int drawableId)`  L102
- `void setWbStatusVisibility(int visibility)`  L104
- `void setWifiIcon(int drawableId)`  L106
- `void setWifiStatusVisibility(int visibility)`  L108
- `void settimeLapseModeIcon(int drawableId)`  L110
- `void settimeLapseModeVisibility(int visibility)`  L112
- `void showPopupWindow(int curMode)`  L114
- `void showZoomView()`  L116
- `void updateZoomViewProgress(float currentZoomRatio)`  L118
### `com.gku.dashcam.icatch.ui.Interface.VideoPbView`
L4 · [interface] public VideoPbView · `com/gku/dashcam/icatch/ui/Interface/VideoPbView.java`

方法（21）：
- `int getSeekBarProgress()`  L5
- `int getSurfaceViewHeight()`  L7
- `int getSurfaceViewWidth()`  L9
- `void setBottomBarVisibility(int visibility)`  L11
- `void setDownloadBtnEnabled(boolean b)`  L13
- `void setEisSwitchChecked(boolean checked)`  L15
- `void setLoadPercent(int value)`  L17
- `void setMoreSettingLayoutVisibility(int visibility)`  L19
- `void setPanoramaTypeBtnVisibility(int visibility)`  L21
- `void setPanoramaTypeImageResource(int resId)`  L23
- `void setPlayBtnSrc(int resid)`  L25
- `void setProgress(float progress)`  L27
- `void setSeekBarMaxValue(int value)`  L29
- `void setSeekBarProgress(int value)`  L31
- `void setSeekBarSecondProgress(int value)`  L33
- `void setSeekbarEnabled(boolean b)`  L35
- `void setTimeDurationValue(String value)`  L37
- `void setTimeLapsedValue(String value)`  L39
- `void setTopBarVisibility(int visibility)`  L41
- `void setVideoNameTxv(String curLocalVideoPath)`  L43
- `void showLoadingCircle(boolean isShow)`  L45
### `com.gku.dashcam.icatch.ui.RemoteFileHelper`
L19 · [class] public RemoteFileHelper · `com/gku/dashcam/icatch/ui/RemoteFileHelper.java`

字段/常量（23）：
- `RemoteFileHelper instance`  L20
- `String TAG = "RemoteFileHelper"`  L21
- `int curFilterFileType = 255`  L23
- `FileFilter fileFilter = null`  L24
- `int MAX_NUM = 30`  L25
- `boolean supportSegmentedLoading = false`  L26
- `boolean supportSetFileListAttribute = false`  L27
- `int sensorsNum = 1`  L28
- `boolean cancalLoadData = false`  L29
- `int i = 1`  L81
- `boolean z = false`  L95
- `int i = startIndex + 29`  L103
- `FileFilter fileFilter = this.fileFilter`  L109
- `int i2 = i + 1`  L112
- `int i3 = i + 1`  L125
- `int i4 = i3 + 29`  L127
- `int i2 = fileCount < maxNum ? fileCount : maxNum`  L164
- `int i3 = 1`  L166
- `int i = fileCount < maxNum ? fileCount : maxNum`  L247
- `int i2 = 1`  L248
- `int i = 18`  L309
- `FileFilter fileFilter = this.fileFilter`  L317
- `FileFilter fileFilter = this.fileFilter`  L381

方法（23）：
- `RemoteFileHelper getInstance()`  L37
- `void initSupportCapabilities()`  L44
- `int getSensorsNum()`  L59
- `boolean isSupportSegmentedLoading()`  L63
- `boolean isSupportSetFileListAttribute()`  L67
- `void getRemoteFile(FileOperation fileOperation, FileType fileType, DataCallBack dataCallBack)`  L71
- `List<MultiPbItemInfo> getRemoteFile(FileOperation fileOperation, FileType fileType)`  L80
- `MultiPbFileResult getRemoteFile(FileOperation fileOperation, FileType fileType, int fileTotalNum, int startIndex)`  L94
- `void getFileList(FileOperation fileOperation, FileType fileType, int maxNum, DataCallBack dataCallBack)`  L151
- `List<MultiPbItemInfo> getFileList(FileOperation fileOperation, int type, int maxNum)`  L237
- `List<MultiPbItemInfo> getList(List<ICatchFile> fileList, FileFilter fileFilter)`  L285
- `void setFileListAttribute(FileOperation fileOperation, FileType fileType)`  L307
- `int getFileCount(FileOperation fileOperation, FileType fileType)`  L326
- `void setFileFilter(FileFilter fileFilter)`  L331
- `FileFilter getFileFilter()`  L335
- `void setLocalFileList(List<MultiPbItemInfo> pbItemInfoList, FileType fileType)`  L339
- `List<MultiPbItemInfo> getLocalFileList(FileType fileType)`  L351
- `void cancalLoadData()`  L355
- `void clearFileList(FileType fileType)`  L359
- `void remove(MultiPbItemInfo file, FileType fileType)`  L365
- `void clearAllFileList()`  L372
- `boolean needFilter()`  L376
- `boolean needFilterMoreFile(ICatchFile lastFile)`  L380
### `com.gku.dashcam.icatch.ui.RemoteFileHelper$DataCallBack`
L31 · [interface] public DataCallBack · `com/gku/dashcam/icatch/ui/RemoteFileHelper.java`

方法（2）：
- `void finish(int size)`  L32
- `void success(List<MultiPbItemInfo> multiPbItemInfos)`  L34
### `com.gku.dashcam.icatch.ui.setting.OptionSetting`
L47 · [class] public OptionSetting · `com/gku/dashcam/icatch/ui/setting/OptionSetting.java`

字段/常量（68）：
- `String TAG = "OptionSetting"`  L48
- `Activity activity`  L49
- `AlertDialog alertDialog`  L50
- `BaseProperties baseProrertys`  L51
- `CameraAction cameraAction`  L52
- `CameraProperties cameraProperties`  L53
- `Context context`  L54
- `DashCamera myCamera`  L72
- `OnSettingCompleteListener onSettingCompleteListener`  L73
- `String password`  L74
- `SDKEvent sdkEvent`  L75
- `String wifiSsid`  L76
- `String[] strArr`  L228
- `int length = valueList.length`  L259
- `int i = 0`  L261
- `int length = valueList.length`  L283
- `int i = 0`  L285
- `int length = valueList.length`  L307
- `int i = 0`  L309
- `int length = valueList.length`  L331
- `int i = 0`  L333
- `int length = valueList.length`  L355
- `int i = 0`  L357
- `int length = valueList.length`  L379
- `int i = 0`  L381
- `int length = valueList.length`  L403
- `int i = 0`  L405
- `int length = valueList.length`  L427
- `int i = 0`  L429
- `int length = valueList.length`  L686
- `int i = 0`  L688
- `int length = valueList.length`  L710
- `int i = 0`  L712
- `int length = valueList.length`  L734
- `int i = 0`  L736
- `String str = valueList[i2]`  L739
- `int length = valueStringList.length`  L762
- `int i = 0`  L764
- `TimeLapseInterval timeLapseVideoInterval`  L781
- `int length = valueStringList.length`  L792
- `int i = 0`  L794
- `int length = valueList.length`  L816
- `int i = 0`  L818
- `int length = valueArrayString.length`  L840
- `int i = 0`  L842
- `int length = valueList.length`  L938
- `int i = 0`  L940
- `int length = valueArrayString.length`  L963
- `int i = 0`  L965
- `int length = valueList.length`  L1034
- `int i = 0`  L1036
- `int length = valueList.length`  L1058
- `int i = 0`  L1060
- `int length = valueList.length`  L1082
- `int i = 0`  L1084
- `int length = valueList.length`  L1106
- `int i = 0`  L1108
- `int length = valueList.length`  L1293
- `int i = 0`  L1295
- `int length = valueList.length`  L1317
- `int i = 0`  L1319
- `int length = valueList.length`  L1341
- `int i = 0`  L1343
- `int length = valueList.length`  L1365
- `int i = 0`  L1367
- `Context context2 = context`  L1410
- `int length = valueList.length`  L1423
- `int i = 0`  L1425

方法（79）：
- `void handleMessage(Message msg)`  L58 @Override
- `void onClick(DialogInterface dialog, int which)`  L64 @Override
- `public OptionSetting()`  L78
- `void addSettingCompleteListener(OnSettingCompleteListener onSettingCompleteListener)`  L86
- `void showSettingDialog(int nameId, Activity activity)`  L90
- `boolean fileIsExists(String strFile)`  L219
- `void showStorageLocationDialog(final Context context)`  L227
- `void onClick(DialogInterface arg0, int arg1)`  L237 @Override
    - 体内字面量："appData" · "storageLocation" · "InternalStorage" · "appData" · "storageLocation" · "SdCard"
- `void showFastMotionMovieDialog(final Context context)`  L253
- `void onClick(DialogInterface arg0, int arg1)`  L269 @Override
- `void showLanguageDialog(final Context context)`  L277
- `void onClick(DialogInterface arg0, int arg1)`  L293 @Override
- `void showMotionDetectDialog(final Context context)`  L301
- `void onClick(DialogInterface arg0, int arg1)`  L317 @Override
- `void showAudioRecordDialog(final Context context)`  L325
- `void onClick(DialogInterface arg0, int arg1)`  L341 @Override
- `void showBeepSoundDialog(final Context context)`  L349
- `void onClick(DialogInterface arg0, int arg1)`  L365 @Override
- `void showBootSoundDialog(final Context context)`  L373
- `void onClick(DialogInterface arg0, int arg1)`  L389 @Override
- `void showAutoPowerOffDialog(final Context context)`  L397
- `void onClick(DialogInterface arg0, int arg1)`  L413 @Override
- `void showScreenSaverDialog(final Context context)`  L421
- `void onClick(DialogInterface arg0, int arg1)`  L437 @Override
- `void showEnableWifihotspotDialog()`  L445
- `boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event)`  L456 @Override
    - 体内字面量："mShowing"
- `void showCameraConfigurationDialog(final Context context)`  L607
- `void onClick(DialogInterface dialog, int which)`  L622 @Override
    - 体内字面量："mShowing"
- `void onClick(DialogInterface dialog, int arg1)`  L635 @Override
    - 体内字面量："mShowing" · "mShowing" · "mShowing"
- `void showUpsideDialog(final Context context)`  L680
- `void onClick(DialogInterface arg0, int arg1)`  L696 @Override
- `void showSlowMotionDialog(final Context context)`  L704
- `void onClick(DialogInterface arg0, int arg1)`  L720 @Override
- `void showTimeLapseModeDialog(final Context context)`  L728
- `void onClick(DialogInterface arg0, int arg1)`  L746 @Override
    - 体内字面量："tigertiger" · "showTimeLapseModeDialog  timeLapseMode ="
- `void showTimeLapseDurationDialog(final Context context)`  L756
- `void onClick(DialogInterface arg0, int arg1)`  L772 @Override
- `void showTimeLapseIntervalDialog(final Context context)`  L780
- `void onClick(DialogInterface arg0, int arg1)`  L802 @Override
- `void showDelayTimeOptionDialog(final Context context, final OnSettingCompleteListener settingCompleteListener)`  L810
- `void onClick(DialogInterface arg0, int arg1)`  L826 @Override
- `void showImageSizeOptionDialog(final Context context)`  L834
- `void onClick(DialogInterface arg0, int arg1)`  L850 @Override
- `void showUSBImageSizeOptionDialog(final Context context)`  L858
- `void showDelayTimeOptionDialog(final Context context)`  L932
- `void onClick(DialogInterface arg0, int arg1)`  L948 @Override
- `void showVideoSizeOptionDialog(final Context context)`  L956
- `void onClick(DialogInterface arg0, int arg1)`  L973 @Override
- `void showFormatConfirmDialog(final Context context)`  L982
- `void onClick(DialogInterface dialog, int which)`  L987 @Override
- `void showDateStampOptionDialog(final Context context)`  L1028
- `void onClick(DialogInterface arg0, int arg1)`  L1044 @Override
- `void showElectricityFrequencyOptionDialog(final Context context)`  L1052
- `void onClick(DialogInterface arg0, int arg1)`  L1068 @Override
- `void showWhiteBalanceOptionDialog(final Context context)`  L1076
- `void onClick(DialogInterface arg0, int arg1)`  L1092 @Override
- `void showBurstOptionDialog(final Context context)`  L1100
- `void onClick(DialogInterface arg0, int arg1)`  L1116 @Override
- `void showOptionDialog(CharSequence title, CharSequence[] items, int checkedItem, DialogInterface.OnClickListener listener, boolean cancelable)`  L1125
- `void sdCardIsNotReadyAlert(Context context)`  L1132
    - 体内字面量："OK"
- `void onClick(DialogInterface dialog, int which)`  L1137 @Override
- `void showSetDownloadSizeLimitDialog(final Context context)`  L1243
- `void onClick(DialogInterface dialog, int which)`  L1253 @Override
- `void onClick(DialogInterface dialog, int which)`  L1263 @Override
- `void connectWifi(String ssid, String password)`  L1269
    - 体内字面量："wifi"
- `void showExposureCompensationDialog(final Context context)`  L1287
- `void onClick(DialogInterface arg0, int arg1)`  L1303 @Override
- `void showVideoFileLengthDialog(final Context context)`  L1311
- `void onClick(DialogInterface arg0, int arg1)`  L1327 @Override
- `void showGSensorDialog(final Context context)`  L1335
- `void onClick(DialogInterface arg0, int arg1)`  L1351 @Override
- `void showSpeedUnitDialog(final Context context)`  L1359
- `void onClick(DialogInterface arg0, int arg1)`  L1375 @Override
- `void showResetDialog(final Context context)`  L1383
- `void onClick(DialogInterface dialog, int which)`  L1388 @Override
- `void onClick(DialogInterface dialog, int which)`  L1393 @Override
- `void run()`  L1402 @Override
- `void showFbPreviewDialog(final Context context)`  L1417
- `void onClick(DialogInterface arg0, int arg1)`  L1433 @Override
### `com.gku.dashcam.icatch.ui.setting.OptionSetting$AnonymousClass11`
L476 · [class] AnonymousClass11 · implements `DialogInterface.OnClickListener` · `com/gku/dashcam/icatch/ui/setting/OptionSetting.java`

字段/常量（2）：
- `EditText val$cameraPassword`  L477
- `EditText val$wifiName`  L478

方法（1）：
- `void onClick(DialogInterface dialog, int arg1)`  L486 @Override
    - 体内字面量："mShowing" · "mShowing" · "mShowing" · "mShowing"
### `com.gku.dashcam.icatch.ui.setting.OptionSetting$AnonymousClass11$AnonymousClass1`
L537 · [class] AnonymousClass1 · implements `Runnable` · `com/gku/dashcam/icatch/ui/setting/OptionSetting.java`

方法（4）：
- `void run()`  L542 @Override
- `void run()`  L570 @Override
    - 体内字面量："$1$" · "$2$" · "Wifiç­ç¹å¼å¯å¤±è´¥ï¼å¯è½ç³»ç»ä¸æ¯æï¼éè¦æå¨å¼å¯,å¹¶è®¾ç½®Wifiç­ç¹åç§°ä¸ºï¼" · " å¯ç ä¸ºï¼" · " è®¾ç½®å®æåï¼è¯·éæ°å¯å¨å¹¶è¿æ¥ã"
- `void onClick(DialogInterface dialog, int which)`  L577 @Override
    - 体内字面量："com.android.settings" · "com.android.settings.Settings$TetherSettingsActivity"
- `void run()`  L597 @Override
### `com.gku.dashcam.icatch.ui.setting.OptionSetting$AnonymousClass22`
L867 · [class] AnonymousClass22 · implements `Runnable` · `com/gku/dashcam/icatch/ui/setting/OptionSetting.java`

字段/常量（5）：
- `Handler val$handler`  L868
- `DashCamera val$myCamera`  L869
- `CharSequence val$title`  L870
- `int i`  L893
- `int i2 = 0`  L900

方法（4）：
- `void run()`  L879 @Override
- `void run()`  L883 @Override
- `void run()`  L892 @Override
- `void onClick(DialogInterface arg0, int arg1)`  L919 @Override
### `com.gku.dashcam.icatch.ui.setting.OptionSetting$AnonymousClass26`
L995 · [class] AnonymousClass26 · implements `DialogInterface.OnClickListener` · `com/gku/dashcam/icatch/ui/setting/OptionSetting.java`

字段/常量（2）：
- `Context val$context`  L996
- `int i`  L1010

方法（3）：
- `void onClick(DialogInterface dialog, int which)`  L1003 @Override
- `void run()`  L1009 @Override
- `void run()`  L1018 @Override
### `com.gku.dashcam.icatch.ui.setting.OptionSetting$SettingHander`
L1146 · [class] private SettingHander · extends `Handler` · `com/gku/dashcam/icatch/ui/setting/OptionSetting.java`

字段/常量（1）：
- `int i = msg.what`  L1152

方法（6）：
- `private SettingHander()`  L1147
- `void handleMessage(Message msg)`  L1151 @Override
- `void onClick(DialogInterface dialog, int which)`  L1170 @Override
    - 体内字面量："Wifiç­ç¹å¼å¯å¤±è´¥ï¼å¯è½ç³»ç»çæ¬ä¸æ¯æï¼éè¦æå¨å¼å¯"
- `void onClick(DialogInterface dialog, int which)`  L1190 @Override
    - 体内字面量："com.android.settings" · "com.android.settings.Settings$TetherSettingsActivity"
- `void onClick(DialogInterface dialog, int which)`  L1212 @Override
- `void onClick(DialogInterface dialog, int which)`  L1233 @Override
### `com.gku.dashcam.icatch.ui.setting.UIDisplaySource`
L20 · [class] public UIDisplaySource · `com/gku/dashcam/icatch/ui/setting/UIDisplaySource.java`

字段/常量（15）：
- `int CAPTURE_SETTING_MENU = 1`  L21
- `int TIMELAPSE_SETTING_MENU = 3`  L22
- `int VIDEO_SETTING_MENU = 2`  L23
- `UIDisplaySource uiDisplayResource`  L24
- `BaseProperties baseProrertys`  L25
- `CameraFixedInfo cameraFixedInfo`  L26
- `CameraProperties cameraProperties`  L27
- `CameraState cameraState`  L28
- `DashCamera curCamera`  L29
- `LinkedList<SettingMenu> settingMenuList`  L30
- `LinkedList<SettingMenu> linkedList = this.settingMenuList`  L58
- `LinkedList<SettingMenu> linkedList = this.settingMenuList`  L130
- `String currentValue`  L228
- `LinkedList<SettingMenu> linkedList = this.settingMenuList`  L229
- `LinkedList<SettingMenu> linkedList = this.settingMenuList`  L315

方法（6）：
- `UIDisplaySource getinstance()`  L32
- `LinkedList<SettingMenu> getList(int type, DashCamera currCamera)`  L39
- `LinkedList<SettingMenu> getForCaptureMode()`  L57
- `LinkedList<SettingMenu> getForVideoMode()`  L129
- `LinkedList<SettingMenu> getForTimelapseMode()`  L227
- `LinkedList<SettingMenu> getUSBList(Context context)`  L314
### `com.gku.dashcam.icatch.usb.DeviceFilter`
L18 · [class] public final DeviceFilter · `com/gku/dashcam/icatch/usb/DeviceFilter.java`

字段/常量（33）：
- `String TAG = "DeviceFilter"`  L19
- `int mClass`  L20
- `String mManufacturerName`  L21
- `int mProductId`  L22
- `String mProductName`  L23
- `int mProtocol`  L24
- `String mSerialNumber`  L25
- `int mSubclass`  L26
- `int mVendorId`  L27
- `DeviceFilter deviceFilter`  L52
- `int i`  L70
- `boolean z = false`  L111
- `int i = -1`  L112
- `int i2 = -1`  L113
- `int attributeInteger = -1`  L114
- `int attributeInteger2 = -1`  L115
- `int attributeInteger3 = -1`  L116
- `String str = null`  L117
- `String str2 = null`  L118
- `String attributeString = null`  L119
- `int i`  L167
- `int i2`  L168
- `int i3`  L169
- `int i4`  L170
- `String str`  L171
- `String str2`  L172
- `String str3`  L173
- `String str4`  L174
- `String str5`  L175
- `String str6`  L176
- `String str7`  L177
- `int i5 = this.mVendorId`  L178
- `String str8 = deviceFilter.mManufacturerName`  L185

方法（10）：
- `public DeviceFilter(final int vid, final int pid, final int clasz, final int subclass, final int protocol, final String manufacturer, final String product, final String serialnum)`  L29
- `public DeviceFilter(final UsbDevice device)`  L40
- `List<DeviceFilter> getDeviceFilters(final Context context, final int deviceFilterXmlId)`  L51
- `int getAttributeInteger(final Context context, final XmlPullParser parser, final String namespace, final String name, final int defaultValue)`  L69
- `String getAttributeString(final Context context, final XmlPullParser parser, final String namespace, final String name, final String defaultValue)`  L91
- `DeviceFilter read(final Context context, final XmlPullParser parser)`  L109
- `boolean matches(final UsbDevice device)`  L161
    - 体内字面量："mVendorId ="
- `boolean equals(final Object obj)`  L166
- `int hashCode()`  L201
- `String toString()`  L205
    - 体内字面量："DeviceFilter[mVendorId=" · ",mProductId=" · ",mClass=" · ",mSubclass=" · ",mProtocol=" · ",mManufacturerName=" · ",mProductName=" · ",mSerialNumber=" · "]"
### `com.gku.dashcam.icatch.usb.NotificationHandler`
L9 · [class] public NotificationHandler · extends `Handler` · `com/gku/dashcam/icatch/usb/NotificationHandler.java`

字段/常量（2）：
- `Context context`  L10
- `int i = message.what`  L18

方法（2）：
- `public NotificationHandler(Context context)`  L12
- `void handleMessage(Message message)`  L17 @Override
### `com.gku.dashcam.icatch.usb.USBHost_Feature`
L21 · [class] public USBHost_Feature · `com/gku/dashcam/icatch/usb/USBHost_Feature.java`

字段/常量（18）：
- `String ACTION_USB_PERMISSION_BASE = "com.example.USB_PERMISSION."`  L22
- `int HANDLER_USB_DEVICE_ATTACHED_ID = 1`  L23
- `String HANDLER_USB_DEVICE_ATTACHED_KEY = "HANDLER_USB_DEVICE_ATTACHED"`  L24
- `int HANDLER_USB_DEVICE_DETACHED_ID = 2`  L25
- `String HANDLER_USB_DEVICE_DETACHED_KEY = "HANDLER_USB_DEVICE_DETACHED"`  L26
- `int USB_PRODUCT_ID = 25427`  L27
- `int USB_UAC_FREQUENCY = 48000`  L28
- `int USB_UAC_NCHANNELS = 2`  L29
- `int USB_UAC_SAMPLEBIT = 16`  L30
- `int USB_VENDOR_ID = 10925`  L31
- `Context context`  L32
- `PendingIntent mPermissionIntent`  L33
- `UsbDevice usbDevice`  L34
- `UsbDeviceConnection usbDeviceConnection`  L35
- `UsbManager usbManager`  L36
- `UsbDevice usbDevice`  L41
- `int mVendorID = USB_VENDOR_ID`  L75
- `int mProductID = USB_PRODUCT_ID`  L76

方法（16）：
- `void onReceive(final Context context, final Intent intent)`  L40 @Override
- `public USBHost_Feature(Context context)`  L78
    - 体内字面量："usb"
- `void setUsbDevice(int vendorID, int productID)`  L83
- `boolean hasPermission()`  L88
- `void requestPermission()`  L94
    - 体内字面量："__lib_uvc__" · "has permission" · "__lib_uvc__" · "request permission"
- `UsbDevice getUsbDevice()`  L108
- `int getProductID()`  L117
- `int getVendorID()`  L121
- `int getFileDescriptor()`  L125
- `UsbDeviceConnection getUsbDeviceConnection()`  L134
- `void register()`  L146
    - 体内字面量："android.hardware.usb.action.USB_DEVICE_ATTACHED" · "android.hardware.usb.action.USB_DEVICE_DETACHED"
- `void unregister()`  L160
- `String generateNameForUsbDevice(UsbDevice usbDevice)`  L167
- `String generateNameForUsbDevice(int vendorID, int productID)`  L174
    - 体内字面量："USB[VID:0x%04x PID:0x%04x]"
- `UsbDevice getSpecifiedDevice(int mVendorId, int mProductId)`  L178
    - 体内字面量："__lib_uvc__" · "getDeviceList, USBDevice: " · "__lib_uvc__" · "getDeviceList, USBDevice: " · "__lib_uvc__" · "getDeviceList, USBDevice: "
- `List<UsbDevice> getExistsUsbDevices()`  L194
    - 体内字面量："__lib_uvc__" · "getDeviceList, USBDevice: " · "__lib_uvc__" · "getDeviceList, USBDevice: " · "__lib_uvc__" · "getDeviceList, USBDevice: "
### `com.gku.dashcam.icatch.usb.USBMonitor`
L26 · [class] public final USBMonitor · `com/gku/dashcam/icatch/usb/USBMonitor.java`

字段/常量（11）：
- `String ACTION_USB_PERMISSION_BASE = "com.serenegiant.USB_PERMISSION."`  L27
- `boolean DEBUG = true`  L28
- `String TAG = "USBMonitor"`  L29
- `IntentFilter filter`  L30
- `OnDeviceConnectListener mOnDeviceConnectListener`  L31
- `UsbManager mUsbManager`  L32
- `WeakReference<Context> mWeakContext`  L33
- `String ACTION_USB_PERMISSION = "com.android.usb.USB_PERMISSION"`  L34
- `UsbDevice usbDevice`  L41
- `int mDeviceCounts = 0`  L74
- `boolean z`  L261

方法（24）：
- `void onReceive(final Context context, final Intent intent)`  L40 @Override
- `void run()`  L77 @Override
- `public USBMonitor(final Context context, final OnDeviceConnectListener listener)`  L101
    - 体内字面量："USBMonitor:Constructor" · "usb" · "USBMonitor:mUsbManager="
- `void destroy()`  L110
    - 体内字面量："destroy:" · "destroy:"
- `void register()`  L127
    - 体内字面量："com.android.usb.USB_PERMISSION" · "android.hardware.usb.action.USB_DEVICE_ATTACHED" · "android.hardware.usb.action.USB_DEVICE_DETACHED"
- `void unregister()`  L146
    - 体内字面量："unregisterUSB:"
- `boolean isRegistered()`  L159
- `void setDeviceFilter(final DeviceFilter filter)`  L163
- `void setDeviceFilter(final List<DeviceFilter> filters)`  L168
- `int getDeviceCount()`  L173
- `List<UsbDevice> getDeviceList()`  L177
- `List<UsbDevice> getDeviceList(final List<DeviceFilter> filters)`  L181
- `List<UsbDevice> getDeviceList(final DeviceFilter filter)`  L196
    - 体内字面量："getDeviceList size is: " · "the device is: " · "getDeviceList result size is: "
- `void dumpDevices()`  L212
    - 体内字面量："interface%d:%s" · "key=" · ":" · ":" · "no device" · "no device"
- `boolean hasPermission(final UsbDevice device)`  L235
- `void requestPermission(final UsbDevice device)`  L239
    - 体内字面量："requestPermission:device=" · "mUsbManager.hasPermission( device )=" · "processConnect not from broadcaster" · "do not has permission,so  requestPermission" · "com.android.usb.USB_PERMISSION"
- `void processConnect(final UsbDevice device)`  L256
    - 体内字面量："processConnect:"
- `void run()`  L260 @Override
- `void processCancel(final UsbDevice device)`  L278
    - 体内字面量："processCancel:"
- `void run()`  L283 @Override
- `void processAttach(final UsbDevice device)`  L291
    - 体内字面量："processAttach:"
- `void run()`  L296 @Override
- `void processDettach(final UsbDevice device)`  L304
    - 体内字面量："processDettach:"
- `void run()`  L309 @Override
### `com.gku.dashcam.icatch.usb.USBMonitor$OnDeviceConnectListener`
L89 · [interface] public OnDeviceConnectListener · `com/gku/dashcam/icatch/usb/USBMonitor.java`

方法（5）：
- `void onAttach(UsbDevice device)`  L90
- `void onCancel()`  L92
- `void onConnect(UsbDevice device, UsbControlBlock ctrlBlock, boolean createNew)`  L94
- `void onDettach(UsbDevice device)`  L96
- `void onDisconnect(UsbDevice device, UsbControlBlock ctrlBlock)`  L98
### `com.gku.dashcam.icatch.usb.USBMonitor$UsbControlBlock`
L316 · [class] public static final UsbControlBlock · `com/gku/dashcam/icatch/usb/USBMonitor.java`

字段/常量（8）：
- `UsbDeviceConnection mConnection`  L317
- `WeakReference<UsbDevice> mWeakDevice`  L319
- `WeakReference<USBMonitor> mWeakMonitor`  L320
- `UsbDeviceConnection usbDeviceConnection = this.mConnection`  L328
- `UsbDeviceConnection usbDeviceConnection`  L350
- `UsbDeviceConnection usbDeviceConnection = this.mConnection`  L356
- `UsbDeviceConnection usbDeviceConnection`  L380
- `UsbInterface usbInterface`  L386

方法（12）：
- `public UsbControlBlock(final USBMonitor monitor, final UsbDevice device)`  L322
    - 体内字面量："UsbControlBlock:constructor"
- `UsbDevice getDevice()`  L336
- `String getDeviceName()`  L340
- `UsbDeviceConnection getUsbDeviceConnection()`  L345
- `int getFileDescriptor()`  L349
- `byte[] getRawDescriptors()`  L355
- `int getVenderId()`  L363
- `int getProductId()`  L371
- `String getSerial()`  L379
- `UsbInterface open(final int interfaceIndex)`  L385
- `void close(final int interfaceIndex)`  L398
- `void close()`  L408
    - 体内字面量："UsbControlBlock#close:"
### `com.gku.dashcam.icatch.utils.AppDialog`
L13 · [class] public AppDialog · `com/gku/dashcam/icatch/utils/AppDialog.java`

字段/常量（9）：
- `AlertDialog dialog = null`  L14
- `boolean needShown = true`  L15
- `String tag = "AppDialog"`  L16
- `AlertDialog alertDialog = dialog`  L48
- `AlertDialog alertDialog = dialog`  L67
- `AlertDialog alertDialog = dialog`  L86
- `OnDialogSureClickListener onDialogSureClickListener = listener`  L97
- `PackageInfo packageInfo`  L109
- `String str`  L110

方法（12）：
- `void showLowBatteryWarning(Context context)`  L28
- `void showDialog(String title, String message, boolean cancelable)`  L31
- `void showDialogQuit(final Context context, final String message)`  L34
- `void onClick(DialogInterface dialog2, int which)`  L40 @Override
- `void showDialogWarn(final Context context, String message)`  L47
- `void onClick(DialogInterface dialog2, int which)`  L57 @Override
- `void showDialogWarn(final Context context, int messageID)`  L66
- `void onClick(DialogInterface dialog2, int which)`  L76 @Override
- `void showDialogWarn(final Context context, int messageID, boolean canelable, final OnDialogSureClickListener listener)`  L85
- `void onClick(DialogInterface dialog2, int which)`  L95 @Override
- `void showAPPVersionDialog(Context context)`  L108
- `void onClick(DialogInterface dialog2, int which)`  L126 @Override
### `com.gku.dashcam.icatch.utils.AppDialog$OnDialogButtonClickListener`
L18 · [interface] public OnDialogButtonClickListener · `com/gku/dashcam/icatch/utils/AppDialog.java`

方法（2）：
- `void onCancel()`  L19
- `void onSure()`  L21
### `com.gku.dashcam.icatch.utils.AppDialog$OnDialogSureClickListener`
L24 · [interface] public OnDialogSureClickListener · `com/gku/dashcam/icatch/utils/AppDialog.java`

方法（1）：
- `void onSure()`  L25
### `com.gku.dashcam.icatch.utils.BitmapTools`
L10 · [class] public BitmapTools · `com/gku/dashcam/icatch/utils/BitmapTools.java`

字段/常量（9）：
- `long LIMITED_IMGAE_SIZE = 10485760`  L11
- `String TAG = "BitmapTools"`  L12
- `int THUMBNAIL_HEIGHT = 100`  L13
- `int THUMBNAIL_WIDTH = 100`  L14
- `int i = options.outHeight`  L29
- `int i2 = options.outWidth`  L30
- `int i3 = 1`  L31
- `float width2`  L53
- `Bitmap bitmap2`  L54

方法（8）：
- `Bitmap getImageByPath(String imagePath, int width, int height)`  L16
- `int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight)`  L28
- `Bitmap getVideoThumbnail(String videoPath, int width, int height)`  L44
- `Bitmap zoomBitmap(Bitmap bitmap, float width, float heigth)`  L52
- `Bitmap decodeByteArray(byte[] data)`  L84
- `Bitmap decodeByteArray(byte[] data, int reqWidth, int reqHeight)`  L94
- `int getImageWidth(String path)`  L104
- `int getImageHeight(String path)`  L111
### `com.gku.dashcam.icatch.utils.ClickUtils`
L6 · [class] public ClickUtils · `com/gku/dashcam/icatch/utils/ClickUtils.java`

字段/常量（3）：
- `long MIN_CLICK_DELAY_TIME = 500`  L7
- `long lastClickTime`  L8
- `int mLastClickViewId`  L9

方法（4）：
- `boolean isFastClick()`  L11
- `boolean isFastDoubleClick()`  L20
- `boolean isFastDoubleClick(View v)`  L29
- `boolean isFastDoubleClick(int id)`  L40
### `com.gku.dashcam.icatch.utils.ConvertTools`
L11 · [class] public ConvertTools · `com/gku/dashcam/icatch/utils/ConvertTools.java`

字段/常量（31）：
- `double GB = 1.073741824E9d`  L12
- `double KB = 1024.0d`  L13
- `double MB = 1048576.0d`  L14
- `String TAG = "ConvertTools"`  L15
- `String timeFormatFromApp = "yyyy-MM-dd HH:mm:ss"`  L16
- `String timeFormatFromFw = "yyyyMMdd'T'HHmmss"`  L17
- `String str`  L20
- `String str2`  L21
- `String string`  L22
- `int i = remainTime / 3600`  L26
- `int i3 = remainTime % 60`  L30
- `String str3 = str2 + ":"`  L50
- `String str`  L59
- `String str2`  L60
- `String string`  L61
- `int i = remainTime / 3600`  L65
- `int i3 = remainTime % 60`  L69
- `String str3 = str2 + ":"`  L89
- `String string`  L102
- `String str`  L103
- `int i = remainTime / 3600`  L104
- `int i3 = remainTime % 60`  L108
- `String str2 = string + ":"`  L116
- `String str3 = str + ":"`  L123
- `double d = KSize`  L133
- `String str = strArrSplit[0] + "?W=" + strArrSplit[1] + "&H=" + strArrSplit[2] + "&BR=" + strArrSplit[3]`  L151
- `Date date`  L165
- `String str`  L180
- `int i = 16777215 & value`  L186
- `Date date`  L194
- `Date date`  L208

方法（10）：
- `String secondsToMinuteOrHours(int remainTime)`  L19
- `String secondsToMinute(int remainTime)`  L58
- `String millisecondsToMinuteOrHours(int remainTime)`  L97
- `String secondsToHours(int remainTime)`  L101
- `String ByteConversionGBMBKB(long KSize)`  L131
    - 体内字面量："######0.0"
- `String resolutionConvert(String resolution)`  L146
    - 体内字面量："\\?|&" · "W=" · "H=" · "BR="
- `String getTimeByfileDate(String fileDate)`  L164
- `String getExposureCompensation(int value)`  L179
- `long getDateTime(String dateString)`  L193
- `String getDateTimeString(String dateString)`  L207
### `com.gku.dashcam.icatch.utils.CustomProgressBigDialog`
L11 · [class] public CustomProgressBigDialog · extends `ProgressDialog` · `com/gku/dashcam/icatch/utils/CustomProgressBigDialog.java`

字段/常量（2）：
- `String text`  L12
- `String str`  L30

方法（5）：
- `public CustomProgressBigDialog(Context context)`  L14
- `public CustomProgressBigDialog(Context context, int theme, String text)`  L18
- `void onCreate(Bundle savedInstanceState)`  L24 @Override
- `void init(Context context)`  L29
- `void show()`  L45 @Override
### `com.gku.dashcam.icatch.utils.CustomProgressDialog`
L11 · [class] public CustomProgressDialog · extends `ProgressDialog` · `com/gku/dashcam/icatch/utils/CustomProgressDialog.java`

字段/常量（2）：
- `String text`  L12
- `String str`  L30

方法（5）：
- `public CustomProgressDialog(Context context)`  L14
- `public CustomProgressDialog(Context context, int theme, String text)`  L18
- `void onCreate(Bundle savedInstanceState)`  L24 @Override
- `void init(Context context)`  L29
- `void show()`  L45 @Override
### `com.gku.dashcam.icatch.utils.DisplayHelper`
L19 · [class] public DisplayHelper · `com/gku/dashcam/icatch/utils/DisplayHelper.java`

字段/常量（5）：
- `String TAG = "Devices"`  L20
- `float sDensity = 0.0f`  L22
- `Boolean sHasCamera = null`  L23
- `int iIntValue = displayMetrics.widthPixels`  L62
- `int iIntValue2 = displayMetrics.heightPixels`  L63

方法（24）：
- `boolean isElevationSupported()`  L25
- `DisplayMetrics getDisplayMetrics(Context context)`  L29
    - 体内字面量："window"
- `int dpToPx(int dpValue)`  L35
- `int pxToDp(float pxValue)`  L39
- `float getDensity(Context context)`  L43
- `int getScreenWidth(Context context)`  L50
- `int getScreenHeight(Context context)`  L54
- `int[] getRealScreenSize(Context context)`  L58
    - 体内字面量："window"
- `int dp2px(Context context, int dp)`  L79
- `int px2dp(Context context, int px)`  L83
- `boolean hasStatusBar(Context context)`  L87
- `int getActionBarHeight(Context context)`  L91
- `int getStatusBarHeight(Context context)`  L99
    - 体内字面量："com.android.internal.R$dimen" · "status_bar_height"
- `int getNavMenuHeight(Context context)`  L109
- `boolean hasCamera(Context context)`  L113
    - 体内字面量："android.hardware.camera.front" · "android.hardware.camera"
- `boolean hasHardwareMenuKey(Context context)`  L121
- `boolean hasInternet(Context context)`  L125
    - 体内字面量："connectivity"
- `boolean isPackageExist(Context context, String pckName)`  L129
- `boolean isSdcardReady()`  L136
    - 体内字面量："mounted"
- `String getCurCountryLan(Context context)`  L140
    - 体内字面量："-"
- `boolean isZhCN(Context context)`  L144
- `void setFullScreen(Context context)`  L148
- `void cancelFullScreen(Context context)`  L158
- `boolean isFullScreen(Activity activity)`  L168
### `com.gku.dashcam.icatch.utils.fileutils.FileFilter`
L12 · [class] public FileFilter · `com/gku/dashcam/icatch/utils/fileutils/FileFilter.java`

字段/常量（14）：
- `int TIME_TYPE_ALL_TIME = 6`  L13
- `int TIME_TYPE_ALMOST_A_MONTH = 3`  L14
- `int TIME_TYPE_ALMOST_A_WEEK = 2`  L15
- `int TIME_TYPE_CUSTOMIZE = 5`  L16
- `int TIME_TYPE_LAST_HALF_YEAR = 4`  L17
- `int TIME_TYPE_LAST_THREE_DAY = 1`  L18
- `int TIME_TYPE_TODAY = 0`  L19
- `String formatType = "yyyy-MM-dd HH:mm:ss"`  L20
- `String timeFormat = "yyyyMMddHHmmss"`  L21
- `long endTime`  L22
- `long startTime`  L23
- `int sensorType = 0`  L24
- `int timeFilterType = 6`  L25
- `int i = this.timeFilterType`  L71

方法（12）：
- `int getTimeFilterType()`  L27
- `void setTimeFilterType(int timeFilterType)`  L31
- `boolean isMatch(ICatchFile itemInfo)`  L35
- `boolean isLess(ICatchFile itemInfo)`  L43
- `long getEndTime()`  L50
- `long getStartTime()`  L62
- `void setEndTime(long endTime)`  L94
- `void setStartTime(long startTime)`  L98
- `void setSensorType(int sensorType)`  L102
- `int getSensorType()`  L106
- `String getEndTimeString()`  L110
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
- `String getStringTimeString()`  L114
    - 体内字面量："yyyy-MM-dd HH:mm:ss"
### `com.gku.dashcam.icatch.utils.fileutils.FileOper`
L8 · [class] public FileOper · `com/gku/dashcam/icatch/utils/fileutils/FileOper.java`

方法（2）：
- `void createDirectory(String directoryPath)`  L9
- `void createFile(String directoryPath, String fileName)`  L19
### `com.gku.dashcam.icatch.utils.fileutils.FileTools`
L31 · [class] public FileTools · `com/gku/dashcam/icatch/utils/fileutils/FileTools.java`

字段/常量（18）：
- `String FILENAME_SEQUENCE_SEPARATOR = "-"`  L32
- `String TAG = "FileTools"`  L33
- `String[] Urls`  L34
- `long length`  L139
- `long j = 0`  L141
- `FileOutputStream fileOutputStream`  L163
- `Throwable th`  L164
- `InputStream inputStreamOpenRawResource`  L165
- `InputStream inputStream = null`  L178
- `byte[] bArr = new byte[1024]`  L185
- `String str = strSubstring + strSubstring2`  L234
- `String str2 = strSubstring + FILENAME_SEQUENCE_SEPARATOR`  L239
- `int i = 1`  L240
- `FileOutputStream fileOutputStream`  L252
- `ObjectOutputStream objectOutputStream = null`  L264
- `FileInputStream fileInputStream`  L339
- `Throwable th`  L340
- `ObjectInputStream objectInputStream`  L341

方法（16）：
- `List<File> getFilesOrderByLength(String fliePath)`  L36
- `boolean equals(Object obj)`  L40 @Override
- `int compare(File f1, File f2)`  L45 @Override
- `List<File> getFilesOrderByName(String fliePath)`  L60
- `int compare(File o1, File o2)`  L64 @Override
- `List<File> getFilesOrderByDate(String filePath)`  L79
- `boolean equals(Object obj)`  L87 @Override
- `int compare(File f1, File f2)`  L92 @Override
- `String[] getFileUrls(String path, FileType fileType)`  L103
    - 体内字面量：".PNG" · ".wmv" · ".3gp" · ".MOV" · ".mov" · ".AVI"
- `String getFileDate(String fileName)`  L127
- `long getFileSize(File f)`  L138
- `boolean checkFwUpgradeFile(String filePath, String fileName)`  L153
- `void copyFile(int resourceId, String filePath)`  L162
- `String chooseUniqueFilename(String fileNamePath)`  L228
- `boolean saveSerializable(String fileName, Serializable data)`  L251
- `Serializable readSerializable(String fileName)`  L338
### `com.gku.dashcam.icatch.utils.fileutils.MFileTools`
L10 · [class] public MFileTools · extends `FileTools` · `com/gku/dashcam/icatch/utils/fileutils/MFileTools.java`

字段/常量（1）：
- `String TAG = "MFileTools"`  L11

方法（6）：
- `String getNewestPhotoFromDirectory(String directoryPath)`  L13
- `String getNewestVideoFromDirectory(String directoryPath)`  L21
- `List<File> getPhotosOrderByDate(String directoryPath)`  L29
    - 体内字面量：".PNG"
- `List<File> getVideosOrderByDate(String directoryPath)`  L44
    - 体内字面量：".wmv" · ".3gp" · ".MOV" · ".mov" · ".AVI"
- `int getPhotosSize(String directoryPath)`  L59
- `int getVideosSize(String directoryPath)`  L67
### `com.gku.dashcam.icatch.utils.FixedSpeedScroller`
L8 · [class] public FixedSpeedScroller · extends `Scroller` · `com/gku/dashcam/icatch/utils/FixedSpeedScroller.java`

字段/常量（1）：
- `int mDuration`  L9

方法（6）：
- `public FixedSpeedScroller(Context context)`  L11
- `public FixedSpeedScroller(Context context, Interpolator interpolator)`  L16
- `void startScroll(int startX, int startY, int dx, int dy, int duration)`  L22 @Override
- `void startScroll(int startX, int startY, int dx, int dy)`  L27 @Override
- `void setmDuration(int time)`  L31
- `int getmDuration()`  L35
### `com.gku.dashcam.icatch.utils.imageloader.ICatchtekImageDownloader`
L18 · [class] public ICatchtekImageDownloader · extends `BaseImageDownloader` · `com/gku/dashcam/icatch/utils/imageloader/ICatchtekImageDownloader.java`

字段/常量（5）：
- `int HTTP_SOCKET_TIMEOUT_MS = 10000`  L19
- `String TAG = "ICatchtekImageDownloader"`  L20
- `DashCamera curCamera`  L39
- `FileOperation fileOperation`  L40
- `byte[] buffer`  L41

方法（4）：
- `public ICatchtekImageDownloader(Context context)`  L22
- `public ICatchtekImageDownloader(Context context, int connectTimeout, int readTimeout)`  L26
- `InputStream getStreamFromOtherSource(String imageUri, Object extra)`  L31 @Override
- `InputStream getStreamFromTUTK(String imageUri, Object extra)`  L38
### `com.gku.dashcam.icatch.utils.imageloader.ImageLoaderConfig`
L17 · [class] public ImageLoaderConfig · `com/gku/dashcam/icatch/utils/imageloader/ImageLoaderConfig.java`

字段/常量（6）：
- `String TAG = "ImageLoaderConfig"`  L18
- `DiskCache diskCache`  L19
- `FileNameGenerator fileNameGenerator`  L20
- `DisplayImageOptions options`  L21
- `ExecutorService taskExecutor`  L22
- `DiskCache diskCache2 = diskCache`  L56

方法（8）：
- `void initImageLoader(Context context, ImageDownloader imageDownloader)`  L24
- `DisplayImageOptions getDefaultDisplayOptions()`  L44
- `DisplayImageOptions getDefaultDisplayOptions(int defaultImg)`  L48
- `void clearDiskCache()`  L55
- `DisplayImageOptions getSingletonDisplayOptions()`  L64
- `void saveDiskCache(String url, Bitmap bitmap)`  L75
    - 体内字面量："saveDiskCache ret:" · " url:" · "saveDiskCache IOException e:"
- `void removeDiskCache(String url)`  L87
    - 体内字面量："removeDiskCache ret:" · " url:"
- `void stopLoad()`  L94
### `com.gku.dashcam.icatch.utils.imageloader.ImageLoaderUtil`
L14 · [class] public ImageLoaderUtil · `com/gku/dashcam/icatch/utils/imageloader/ImageLoaderUtil.java`

字段/常量（18）：
- `OnLoadListener onLoadListener = listener`  L32
- `OnLoadListener onLoadListener = listener`  L40
- `OnLoadListener onLoadListener = listener`  L48
- `OnLoadListener onLoadListener = listener`  L65
- `OnLoadListener onLoadListener = listener`  L73
- `OnLoadListener onLoadListener = listener`  L81
- `OnLoadListener onLoadListener = listener`  L109
- `OnLoadListener onLoadListener = listener`  L117
- `OnLoadListener onLoadListener = listener`  L125
- `OnLoadListener onLoadListener = listener`  L142
- `OnLoadListener onLoadListener = listener`  L150
- `OnLoadListener onLoadListener = listener`  L158
- `OnLoadListener onLoadListener = listener`  L174
- `OnLoadListener onLoadListener = listener`  L182
- `OnLoadListener onLoadListener = listener`  L190
- `OnLoadListener onLoadListener = listener`  L206
- `OnLoadListener onLoadListener = listener`  L214
- `OnLoadListener onLoadListener = listener`  L222

方法（36）：
- `void loadImage(String path, final OnLoadListener listener)`  L24
- `void onLoadingCancelled(String imageUri, View view)`  L27 @Override
- `void onLoadingStarted(String imageUri, View view)`  L31 @Override
- `void onLoadingFailed(String imageUri, View view, FailReason failReason)`  L39 @Override
- `void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)`  L47 @Override
- `void loadLocalImage(File file, final OnLoadListener listener)`  L56
    - 体内字面量："file://"
- `void onLoadingCancelled(String imageUri, View view)`  L60 @Override
- `void onLoadingStarted(String imageUri, View view)`  L64 @Override
- `void onLoadingFailed(String imageUri, View view, FailReason failReason)`  L72 @Override
- `void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)`  L80 @Override
- `void loadImageView(String path, ImageView mImageView)`  L89
- `void loadImageView(String path, ImageView mImageView, int defaultImg)`  L93
- `void loadImageViewNoCache(String path, ImageView mImageView)`  L97
- `void loadImageView(String path, ImageView mImageView, final OnLoadListener listener)`  L101
- `void onLoadingCancelled(String imageUri, View view)`  L104 @Override
- `void onLoadingStarted(String imageUri, View view)`  L108 @Override
- `void onLoadingFailed(String imageUri, View view, FailReason failReason)`  L116 @Override
- `void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)`  L124 @Override
- `void loadLocalImageView(File file, ImageView mImageView, final OnLoadListener listener)`  L133
    - 体内字面量："file://"
- `void onLoadingCancelled(String imageUri, View view)`  L137 @Override
- `void onLoadingStarted(String imageUri, View view)`  L141 @Override
- `void onLoadingFailed(String imageUri, View view, FailReason failReason)`  L149 @Override
- `void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)`  L157 @Override
- `void loadImageView(String path, ImageView mImageView, int defaultImg, final OnLoadListener listener)`  L166
- `void onLoadingCancelled(String imageUri, View view)`  L169 @Override
- `void onLoadingStarted(String imageUri, View view)`  L173 @Override
- `void onLoadingFailed(String imageUri, View view, FailReason failReason)`  L181 @Override
- `void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)`  L189 @Override
- `void loadImageView(String path, ImageView mImageView, int defaultImg, int delayInMillis, final OnLoadListener listener)`  L198
- `void onLoadingCancelled(String imageUri, View view)`  L201 @Override
- `void onLoadingStarted(String imageUri, View view)`  L205 @Override
- `void onLoadingFailed(String imageUri, View view, FailReason failReason)`  L213 @Override
- `void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)`  L221 @Override
- `DisplayImageOptions getDefaultDisplayOptions(int defaultImg)`  L230
- `DisplayImageOptions getDelayDisplayOptions(int defaultImg, int delayInMillis)`  L234
- `void stopLoad()`  L238
### `com.gku.dashcam.icatch.utils.imageloader.ImageLoaderUtil$OnLoadListener`
L16 · [interface] public OnLoadListener · `com/gku/dashcam/icatch/utils/imageloader/ImageLoaderUtil.java`

方法（3）：
- `void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)`  L17
- `void onLoadingFailed(String imageUri, View view)`  L19
- `void onLoadingStarted(String imageUri, View view)`  L21
### `com.gku.dashcam.icatch.utils.imageloader.Md5FileNameGeneratorMatchFaceName`
L10 · [class] public Md5FileNameGeneratorMatchFaceName · implements `FileNameGenerator` · `com/gku/dashcam/icatch/utils/imageloader/Md5FileNameGeneratorMatchFaceName.java`

字段/常量（3）：
- `String HASH_ALGORITHM = "MD5"`  L11
- `int RADIX = 36`  L12
- `String TAG = "Md5FileNameGeneratorMat"`  L13

方法（2）：
- `String generate(String imageUri)`  L16 @Override
- `byte[] getMD5(byte[] data)`  L23
    - 体内字面量："MD5" · "getMD5 Error: "
### `com.gku.dashcam.icatch.utils.imageloader.TutkUriUtil`
L8 · [class] public TutkUriUtil · `com/gku/dashcam/icatch/utils/imageloader/TutkUriUtil.java`

字段/常量（1）：
- `String URI_PREFIX = "tutk://"`  L9

方法（10）：
- `boolean isTutkUri(String uri)`  L11
- `String getKey(String uri)`  L18
    - 体内字面量："fileName"
- `String getTutkOriginalUri(ICatchFile iCatchFile)`  L23
    - 体内字面量："fileHandle=" · "&fileName=" · "&fileSize=" · "&original"
- `boolean isOriginalUri(String uri)`  L27
    - 体内字面量："original"
- `String getTutkThumbnailUri(ICatchFile iCatchFile)`  L31
    - 体内字面量："fileHandle=" · "&fileName=" · "&fileSize=" · "&thumbnail"
- `boolean isThumbnailUri(String uri)`  L35
    - 体内字面量："thumbnail"
- `boolean belongsTo(String uri)`  L39
- `String crop(String uri)`  L43
    - 体内字面量："URI [%1$s] doesn't have expected scheme [%2$s]"
- `ICatchFile getInfoOfUri(String uri)`  L50
- `ICatchFile getICatchFile(String infoStr)`  L54
### `com.gku.dashcam.icatch.utils.MediaRefresh`
L21 · [class] public MediaRefresh · `com/gku/dashcam/icatch/utils/MediaRefresh.java`

字段/常量（13）：
- `String ACTION_MEDIA_SCANNER_SCAN_DIR = "android.intent.action.MEDIA_SCANNER_SCAN_DIR"`  L22
- `String TAG = "MediaRefresh"`  L23
- `OutputStream outputStream`  L46
- `OutputStream outputStream2`  L47
- `File file`  L48
- `File file2`  L49
- `File file3`  L50
- `File file4`  L51
- `File file5`  L52
- `FileInputStream fileInputStream = null`  L64
- `OutputStream outputStreamOpenOutputStream = null`  L67
- `FileInputStream fileInputStream2 = null`  L68
- `byte[] bArr = new byte[4096]`  L137

方法（6）：
- `void scanDirAsync(Context ctx, String dir)`  L25
- `void scanFileAsync(Context ctx, String filename)`  L31
- `void onScanCompleted(String path, Uri uri)`  L34 @Override
- `void downloadDashCamVideoToDCIM(Context context, String str, String str2)`  L45
- `void notifySystemToScan(String filePath, Context context)`  L182
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `void notifySystemToScan(File file)`  L188
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
### `com.gku.dashcam.icatch.utils.MyProgressDialog`
L8 · [class] public MyProgressDialog · `com/gku/dashcam/icatch/utils/MyProgressDialog.java`

字段/常量（2）：
- `ProgressDialog mDialog`  L9
- `ProgressDialog progressDialog = mDialog`  L33

方法（4）：
- `void showProgressDialog(Context context, String text)`  L11
- `void showBigProgressDialog(Context context, String text)`  L18
- `void showProgressDialog(Context context, int stringID)`  L25
- `void closeProgressDialog()`  L32
### `com.gku.dashcam.icatch.utils.NumberProgressBar`
L19 · [class] public NumberProgressBar · extends `View` · `com/gku/dashcam/icatch/utils/NumberProgressBar.java`

字段/常量（50）：
- `String INSTANCE_MAX = "max"`  L20
- `String INSTANCE_PREFIX = "prefix"`  L21
- `String INSTANCE_PROGRESS = "progress"`  L22
- `String INSTANCE_REACHED_BAR_COLOR = "reached_bar_color"`  L23
- `String INSTANCE_REACHED_BAR_HEIGHT = "reached_bar_height"`  L24
- `String INSTANCE_STATE = "saved_instance"`  L25
- `String INSTANCE_SUFFIX = "suffix"`  L26
- `String INSTANCE_TEXT_COLOR = "text_color"`  L27
- `String INSTANCE_TEXT_SIZE = "text_size"`  L28
- `String INSTANCE_TEXT_VISIBILITY = "text_visibility"`  L29
- `String INSTANCE_UNREACHED_BAR_COLOR = "unreached_bar_color"`  L30
- `String INSTANCE_UNREACHED_BAR_HEIGHT = "unreached_bar_height"`  L31
- `int PROGRESS_TEXT_VISIBLE = 0`  L32
- `float default_progress_text_offset`  L33
- `float default_reached_bar_height`  L34
- `int default_reached_color`  L35
- `int default_text_color`  L36
- `float default_text_size`  L37
- `float default_unreached_bar_height`  L38
- `int default_unreached_color`  L39
- `String mCurrentDrawText`  L40
- `int mCurrentProgress`  L41
- `boolean mDrawReachedBar`  L42
- `float mDrawTextEnd`  L43
- `float mDrawTextStart`  L44
- `float mDrawTextWidth`  L45
- `boolean mDrawUnreachedBar`  L46
- `boolean mIfDrawText`  L47
- `OnProgressBarListener mListener`  L48
- `int mMaxProgress`  L49
- `float mOffset`  L50
- `String mPrefix`  L51
- `int mReachedBarColor`  L52
- `float mReachedBarHeight`  L53
- `Paint mReachedBarPaint`  L54
- `RectF mReachedRectF`  L55
- `String mSuffix`  L56
- `int mTextColor`  L57
- `Paint mTextPaint`  L58
- `float mTextSize`  L59
- `int mUnreachedBarColor`  L60
- `float mUnreachedBarHeight`  L61
- `Paint mUnreachedBarPaint`  L62
- `RectF mUnreachedRectF`  L63
- `int paddingTop`  L136
- `int paddingBottom`  L137
- `int i = paddingTop + paddingBottom`  L147
- `String str = this.mPrefix + this.mCurrentDrawText + this.mSuffix`  L205
- `float f = this.mDrawTextStart + this.mDrawTextWidth + this.mOffset`  L225
- `OnProgressBarListener onProgressBarListener = this.mListener`  L336

方法（39）：
- `public NumberProgressBar(Context context)`  L70
- `public NumberProgressBar(Context context, AttributeSet attrs)`  L74
- `public NumberProgressBar(Context context, AttributeSet attrs, int defStyleAttr)`  L78
    - 体内字面量："%"
- `int getSuggestedMinimumWidth()`  L121 @Override
- `int getSuggestedMinimumHeight()`  L126 @Override
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L131 @Override
- `int measure(int measureSpec, boolean isWidth)`  L135
- `void onDraw(Canvas canvas)`  L162 @Override
- `void initializePainters()`  L179
- `void calculateDrawRectFWithoutProgressText()`  L192
- `void calculateDrawRectF()`  L203
- `int getTextColor()`  L237
- `float getProgressTextSize()`  L241
- `int getUnreachedBarColor()`  L245
- `int getReachedBarColor()`  L249
- `int getProgress()`  L253
- `int getMax()`  L257
- `float getReachedBarHeight()`  L261
- `float getUnreachedBarHeight()`  L265
- `void setProgressTextSize(float textSize)`  L269
- `void setProgressTextColor(int textColor)`  L275
- `void setUnreachedBarColor(int barColor)`  L281
- `void setReachedBarColor(int progressColor)`  L287
- `void setReachedBarHeight(float height)`  L293
- `void setUnreachedBarHeight(float height)`  L297
- `void setMax(int maxProgress)`  L301
- `void setSuffix(String suffix)`  L308
- `String getSuffix()`  L316
- `void setPrefix(String prefix)`  L320
- `String getPrefix()`  L328
- `void incrementProgressBy(int by)`  L332
- `void setProgress(int progress)`  L342
- `Parcelable onSaveInstanceState()`  L351 @Override
    - 体内字面量："progress" · "prefix"
- `void onRestoreInstanceState(Parcelable state)`  L369 @Override
    - 体内字面量："progress" · "prefix"
- `float dp2px(float dp)`  L390
- `float sp2px(float sp)`  L394
- `void setProgressTextVisibility(ProgressTextVisibility visibility)`  L398
- `boolean getProgressTextVisibility()`  L403
- `void setOnProgressBarListener(OnProgressBarListener listener)`  L407
### `com.gku.dashcam.icatch.utils.NumberProgressBar$ProgressTextVisibility`
L65 · [enum] public ProgressTextVisibility · `com/gku/dashcam/icatch/utils/NumberProgressBar.java`

枚举常量（1）：
- `Visible()`  L66
### `com.gku.dashcam.icatch.utils.PanoramaTools`
L9 · [class] public PanoramaTools · `com/gku/dashcam/icatch/utils/PanoramaTools.java`

字段/常量（4）：
- `String TAG = "PanoramaTools"`  L10
- `String str`  L24
- `StringBuilder sb`  L25
- `boolean z = false`  L26

方法（3）：
- `boolean isPanorama(long width, long height)`  L12
- `boolean isPanorama(String imagePath)`  L16
- `boolean isPanoramaForVideo(String videoPath)`  L23
### `com.gku.dashcam.icatch.utils.ScaleTool`
L6 · [class] public ScaleTool · `com/gku/dashcam/icatch/utils/ScaleTool.java`

字段/常量（4）：
- `int i`  L8
- `int i2 = wndW * frmH`  L10
- `int i3 = wndH * frmW`  L11
- `int i4 = 0`  L12

方法（1）：
- `Rect getScaledPosition(int frmW, int frmH, int wndW, int wndH)`  L7
### `com.gku.dashcam.icatch.utils.StorageUtil`
L10 · [class] public StorageUtil · `com/gku/dashcam/icatch/utils/StorageUtil.java`

字段/常量（5）：
- `String TAG = "StorageUtil"`  L11
- `File file = externalFilesDirs[1]`  L19
- `File file = externalFilesDirs[1]`  L34
- `File file = externalFilesDirs[1]`  L49
- `File file`  L59

方法（5）：
- `String getDownloadPath(Context context)`  L13
    - 体内字面量："appData" · "storageLocation" · "InternalStorage" · "InternalStorage"
- `String getRootPath(Context context)`  L28
    - 体内字面量："appData" · "storageLocation" · "InternalStorage" · "InternalStorage"
- `File getStorageDirectory(Context context)`  L43
    - 体内字面量："appData" · "storageLocation" · "InternalStorage" · "InternalStorage"
- `boolean sdCardExist(Context context)`  L58
- `String getCurStorageLocation(Context context)`  L64
    - 体内字面量："appData" · "storageLocation" · "InternalStorage" · "InternalStorage"
### `com.gku.dashcam.icatch.utils.TimeTools`
L8 · [class] public TimeTools · `com/gku/dashcam/icatch/utils/TimeTools.java`

字段/常量（1）：
- `long lastClickTime`  L9

方法（4）：
- `boolean isFastClick()`  L11
- `long stringToLong(String strTime, String formatType)`  L20
- `Date stringToDate(String strTime, String formatType)`  L28
- `String getDateToString(long time, String formatType)`  L32
### `com.gku.dashcam.icatch.utils.WifiAPUtil`
L17 · [class] public WifiAPUtil · `com/gku/dashcam/icatch/utils/WifiAPUtil.java`

字段/常量（19）：
- `String CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE"`  L18
- `boolean DEBUG = true`  L19
- `String DEFAULT_AP_PASSWORD = "12345678"`  L20
- `String EXTRA_WIFI_AP_STATE = "wifi_state"`  L21
- `int MESSAGE_AP_STATE_ENABLED = 1`  L22
- `int MESSAGE_AP_STATE_FAILED = 2`  L23
- `String TAG = "WifiAPUtil"`  L24
- `String WIFI_AP_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_AP_STATE_CHANGED"`  L25
- `int WIFI_AP_STATE_DISABLED = 11`  L26
- `int WIFI_AP_STATE_DISABLING = 10`  L27
- `int WIFI_AP_STATE_ENABLED = 13`  L28
- `int WIFI_AP_STATE_ENABLING = 12`  L29
- `int WIFI_AP_STATE_FAILED = 14`  L30
- `Context mContext`  L31
- `Handler mHandler`  L32
- `WifiAPUtil sInstance`  L33
- `WifiManager mWifiManager`  L34
- `int iIntValue`  L160
- `BroadcastReceiver broadcastReceiver = this.mWifiStateBroadcastReceiver`  L231

方法（14）：
- `void onReceive(Context context, Intent intent)`  L37 @Override
    - 体内字面量："WifiAPUtils onReceive: "
- `void onReceive(Context context, Intent intent)`  L52 @Override
    - 体内字面量："android.net.wifi.RSSI_CHANGED" · "android.net.wifi.STATE_CHANGE" · "networkInfo" · "ç½ç»è¿æ¥æ­å¼" · "è¿æ¥å°ç½ç» " · "wifi" · "android.net.wifi.WIFI_STATE_CHANGED" · "ç³»ç»å³é­wifi" · "ç³»ç»å¼å¯wifi"
- `private WifiAPUtil(Context context)`  L88
    - 体内字面量："WifiAPUtils construct" · "wifi"
- `void finalize()`  L94
    - 体内字面量："finalize"
- `WifiAPUtil getInstance(Context c)`  L99
- `boolean turnOnWifiAp(String str, String password, WifiSecurityType Type)`  L106
    - 体内字面量："wifi ap----no password" · "wifi ap----wpa" · "wifi ap---- wpa2"
- `int getWifiAPState()`  L159
- `boolean setWifiApEnabled()`  L171
    - 体内字面量："setWifiApEnabled" · "setWifiApEnabled"
- `void closeWifiAp()`  L200
    - 体内字面量："getWifiApConfiguration" · "setWifiApEnabled"
- `void regitsterHandler(Handler handler)`  L218
- `void unregitsterHandler()`  L229
- `String getValidApSsid()`  L238
    - 体内字面量："getWifiApConfiguration"
- `String getValidPassword()`  L247
    - 体内字面量："getWifiApConfiguration"
- `int getValidSecurity()`  L256
    - 体内字面量："getWifiApConfiguration" · "getSecurity security="
### `com.gku.dashcam.icatch.utils.WifiAPUtil$WifiSecurityType`
L80 · [enum] public WifiSecurityType · `com/gku/dashcam/icatch/utils/WifiAPUtil.java`

枚举常量（4）：
- `WIFICIPHER_NOPASS()`  L81
- `WIFICIPHER_WPA()`  L82
- `WIFICIPHER_WEP()`  L83
- `WIFICIPHER_INVALID()`  L84
### `com.gku.dashcam.icatch.utils.WifiCheck`
L25 · [class] public WifiCheck · `com/gku/dashcam/icatch/utils/WifiCheck.java`

字段/常量（28）：
- `int CONNECT_FAILED = 2`  L26
- `int IN_BACKGROUND = 3`  L27
- `int RECONNECT_CAMERA = 9`  L28
- `int RECONNECT_CHECKING_PERIOD = 1000`  L29
- `int RECONNECT_FAILED = 5`  L30
- `int RECONNECT_SUCCESS = 4`  L31
- `int RECONNECT_TIME = 50`  L32
- `int RECONNECT_WAITING = 10000`  L33
- `int WIFICIPHER_NOPASS = 6`  L34
- `int WIFICIPHER_WAP = 8`  L35
- `int WIFICIPHER_WEP = 7`  L36
- `Activity activity`  L37
- `AlertDialog dialog`  L38
- `ExecutorService executor`  L39
- `WifiInfo mWifiInfo`  L40
- `WifiManager mWifiManager`  L41
- `ReconnectCallback reconnectCallback`  L42
- `AlertDialog reconnectDialog`  L43
- `Timer reconnectTimer`  L44
- `ReconnectTask task`  L45
- `String TAG = "WifiCheck"`  L46
- `Boolean isShowed = false`  L47
- `int curReconnectTime = 0`  L48
- `AlertDialog alertDialog = this.dialog`  L145
- `AlertDialog alertDialog = this.dialog`  L165
- `AlertDialog alertDialog = this.dialog`  L195
- `ReconnectTask reconnectTask = this.task`  L307
- `Timer timer = this.reconnectTimer`  L312

方法（17）：
- `void handleMessage(Message msg)`  L51 @Override
- `public WifiCheck(Activity activity)`  L63
    - 体内字面量："wifi"
- `void openWifi()`  L70
- `void closeWifi()`  L77
- `int checkState()`  L83
- `boolean connectWifi(String SSID, String Password, int Type)`  L87
    - 体内字面量："wifi"
- `WifiConfiguration CreateWifiInfo(String SSID, String Password, int Type)`  L92
    - 体内字面量："\"" · "\"" · "[0-9A-Fa-f]*" · "\"" · "\\\"" · "\"" · "\""
- `boolean isWifiConnected(Context context, String nameFilter)`  L133
    - 体内字面量："connectivity" · "wifi"
- `void showReconnectDialog()`  L144
- `void onClick(DialogInterface dialog, int which)`  L153 @Override
- `void showReconnectTimeoutDialog()`  L164
- `void onClick(DialogInterface dialog, int which)`  L172 @Override
- `void showAutoReconnectDialog(ReconnectCallback reconnectCallback)`  L189
- `void onClick(DialogInterface dialog, int which)`  L203 @Override
- `boolean reconnect()`  L270
- `boolean reconnect2()`  L288
- `void cancelReconnect()`  L306
### `com.gku.dashcam.icatch.utils.WifiCheck$ReconnectCallback`
L59 · [interface] public ReconnectCallback · `com/gku/dashcam/icatch/utils/WifiCheck.java`

方法（1）：
- `void success()`  L60
### `com.gku.dashcam.icatch.utils.WifiCheck$ReconnectTask`
L212 · [class] private ReconnectTask · extends `TimerTask` · `com/gku/dashcam/icatch/utils/WifiCheck.java`

字段/常量（1）：
- `WifiCheck wifiCheck = WifiCheck.this`  L219

方法（4）：
- `private ReconnectTask()`  L213
- `void run()`  L217 @Override
    - 体内字面量："wifi"
- `void run()`  L227 @Override
- `void run()`  L261 @Override
### `com.gku.dashcam.icatch.ZoomInOut`
L9 · [class] public ZoomInOut · `com/gku/dashcam/icatch/ZoomInOut.java`

字段/常量（6）：
- `ZoomInOut zoomInOut`  L10
- `ZoomCompletedListener zoomCompletedListener`  L11
- `float lastZoomRate = 1.0f`  L12
- `int i = 50`  L46
- `int i2 = i - 1`  L49
- `int i3 = i - 1`  L59

方法（6）：
- `void zoomIn()`  L20
- `void zoomOut()`  L27
- `void startZoomInOutThread(final PreviewPresenter presenter)`  L34
- `void run()`  L37 @Override
- `void zoom(PreviewPresenter presenter)`  L44
- `void addZoomCompletedListener(ZoomCompletedListener zoomCompletedListener)`  L71
### `com.gku.dashcam.icatch.ZoomInOut$ZoomCompletedListener`
L16 · [interface] public ZoomCompletedListener · `com/gku/dashcam/icatch/ZoomInOut.java`

方法（1）：
- `void onCompleted(float currentZoomRate)`  L17