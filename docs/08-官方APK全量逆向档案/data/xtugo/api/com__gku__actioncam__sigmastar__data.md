# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.data

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 7 个文件 / 9 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.data.connect.ClientThread`
L8 · [class] public ClientThread · implements `Runnable` · `com/gku/actioncam/sigmastar/data/connect/ClientThread.java`

字段/常量（4）：
- `String TAG = "lzy"`  L9
- `BufferedReader br`  L10
- `OutputStream os`  L11
- `Socket socket`  L12

方法（1）：
- `void run()`  L15 @Override
### `com.gku.actioncam.sigmastar.data.connect.DownLoadFileUtils`
L21 · [class] public DownLoadFileUtils · `com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java`

字段/常量（26）：
- `DownLoadFileUtils instance`  L22
- `Context mContext`  L23
- `BufferedReader br`  L24
- `File file`  L25
- `OnDownloadProgressListener mOnDownloadProgressListener`  L26
- `String savePath`  L27
- `Socket socket`  L28
- `InputStream socketReader`  L29
- `OutputStream socketWriter`  L30
- `String IP = "192.168.0.1"`  L31
- `int port = 8080`  L32
- `boolean Tag = true`  L33
- `DownLoadFileUtils downLoadFileUtils = DownLoadFileUtils.this`  L65
- `OutputStream outputStream = this.socketWriter`  L91
- `Socket socket = this.socket`  L95
- `Socket socket = this.socket`  L106
- `byte[] bArr = new byte[10240]`  L115
- `long j = messageFileInfor.DATA_LENTH`  L116
- `long j2 = 0`  L118
- `int i = 0`  L119
- `long j`  L168
- `byte[] bArr = new byte[4]`  L174
- `byte[] bArr2 = new byte[4]`  L176
- `byte[] bArr3 = new byte[64]`  L178
- `BufferedOutputStream bufferedOutputStream`  L226
- `FileOutputStream fileOutputStream = null`  L229

方法（12）：
- `DownLoadFileUtils getInstance(Context context)`  L39
- `private DownLoadFileUtils()`  L47
- `void setDownloadProgressListener(OnDownloadProgressListener mOnDownloadProgressLitener)`  L50
- `void createConnection(final String cServerPath, String savePath)`  L55
    - 体内字面量："yingxinquan123456" · "run:  -----------------  è¿æ¥ " · "http://192.168.0.1/"
- `void run()`  L61 @Override
- `void releaseSocket()`  L89
- `void disConnect()`  L104
    - 体内字面量："7653432125" · "disConnect:  --------------  ä¸­æ­"
- `void downloadFile(MessageFileInfor messageFileInfor, Thread thread)`  L114
- `MessageFileInfor getDataFromSer()`  L167
- `String byteArrayToStr(byte[] byteArray)`  L211
- `int bytesToInt(byte[] src, int offset)`  L218
- `File saveData(byte[] bytes, String savePath, int len)`  L225
### `com.gku.actioncam.sigmastar.data.connect.DownLoadFileUtils$OnDownloadProgressListener`
L35 · [interface] public OnDownloadProgressListener · `com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java`

方法（1）：
- `void onItemClick(int progress, File file)`  L36
### `com.gku.actioncam.sigmastar.data.connect.FirmwareClientThread`
L28 · [class] public FirmwareClientThread · implements `Runnable` · `com/gku/actioncam/sigmastar/data/connect/FirmwareClientThread.java`

字段/常量（27）：
- `SendFirmwareListener sendFirmwareListener`  L29
- `int FileLength`  L30
- `BufferedReader br`  L31
- `int data`  L32
- `File file`  L33
- `InputStream inputStream`  L34
- `OnFirewareThreadCreatedListener mOnFirewareThreadCreatedListener`  L35
- `OutputStream os`  L36
- `Handler revHandler`  L37
- `int sendLength`  L38
- `Socket socket`  L39
- `int CurrentCopySize = 0`  L40
- `int newstPercent = 0`  L41
- `int percent = 0`  L42
- `boolean spliteMessage = false`  L43
- `OnFirewareThreadCreatedListener onFirewareThreadCreatedListener = this.mOnFirewareThreadCreatedListener`  L89
- `byte[] bArr = new byte[256]`  L104
- `FirmwareClientThread firmwareClientThread = FirmwareClientThread.this`  L107
- `byte[] bArr = new byte[10240]`  L127
- `int i2 = this.FileLength`  L134
- `int i3 = this.CurrentCopySize`  L135
- `int i4 = this.CurrentCopySize`  L138
- `int i5 = this.newstPercent`  L146
- `SendFirmwareListener sendFirmwareListener2 = sendFirmwareListener`  L156
- `SendFirmwareListener sendFirmwareListener3 = sendFirmwareListener`  L167
- `byte[] bArr = new byte[length]`  L174
- `byte[] bArr = new byte[1024]`  L187

方法（10）：
- `void setOnFirwareThreadCreatedListener(OnFirewareThreadCreatedListener mOnFirewareThreadCreatedListener)`  L49
- `public FirmwareClientThread(int FileLength, File file)`  L53
- `void run()`  L59 @Override
    - 体内字面量："192.168.0.1" · "454121244444" · "run:  ----------------------  Socketè¿æ¥ä¸äº" · "utf-8"
- `void handleMessage(Message msg)`  L73 @Override
    - 体内字面量："454121244444" · "handleMessage:  -----------------------   "
- `void getMessage()`  L99
- `void run()`  L102 @Override
- `void sendFile(String fliePath)`  L121
    - 体内字面量："4541212444333" · "sendFile:  -------------------  "
- `byte[] subByte(byte[] b, int off, int length)`  L173
- `void setSendFirmwareListener(SendFirmwareListener listener)`  L179
- `String getFileMD5(File file)`  L183
### `com.gku.actioncam.sigmastar.data.connect.FirmwareClientThread$OnFirewareThreadCreatedListener`
L45 · [interface] public OnFirewareThreadCreatedListener · `com/gku/actioncam/sigmastar/data/connect/FirmwareClientThread.java`

方法（1）：
- `void onFirwareThreadCreated(boolean IsCreated)`  L46
### `com.gku.actioncam.sigmastar.data.connect.SSConnectDevice`
L28 · [class] public SSConnectDevice · `com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java`

字段/常量（9）：
- `String TAG = "SSConnectDevice"`  L29
- `SSConnectDevice instance`  L30
- `ClientThread clientThread`  L31
- `Context mContext`  L38
- `String str2 = CameraParameters.VersionNo + ".txt"`  L108
- `FileOutputStream fileOutputStream = null`  L117
- `String str = filePath + fileName`  L166
- `String str2 = strcontent + Registry.LINE_SEPARATOR`  L167
- `File file = null`  L187

方法（12）：
- `void handleMessage(Message msg)`  L34 @Override
- `SSConnectDevice getInstance()`  L40
- `private SSConnectDevice()`  L47
- `void connect(Context context)`  L50
- `void run()`  L54 @Override
    - 体内字面量："192.168.0.1" · "run:  ------xml--------------  å»ºç«äºsocketè¿æ¥" · "utf-8" · "/tmp/FL0/language.json"
- `void run()`  L72 @Override
    - 体内字面量："run:  ----------------------   å¼å§è¯»åç¸æºçjsonä¿¡æ¯" · "run:  -------------------  "
- `void initData(String context)`  L106
    - 体内字面量："/"
- `void writeToFile(File file, String text)`  L116
- `String subStr(String text, String pre, String end)`  L155
- `void writeTxtToFile(String strcontent, String filePath, String fileName)`  L164
- `File makeFilePath(String filePath, String fileName)`  L185
- `void makeRootDirectory(String filePath)`  L206
### `com.gku.actioncam.sigmastar.data.SSFileUtils`
L41 · [class] public SSFileUtils · `com/gku/actioncam/sigmastar/data/SSFileUtils.java`

字段/常量（4）：
- `String TAG = "SSFileUtils"`  L42
- `SSFileUtils instance`  L43
- `String lastCamerInfoType = "<binary/metadata>"`  L44
- `Node namedItem`  L161

方法（10）：
- `SSFileUtils getInstance()`  L46
- `private SSFileUtils()`  L53
- `void getLanguageJson(Activity mActivity)`  L56
    - 体内字面量："android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.READ_EXTERNAL_STORAGE" · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.READ_EXTERNAL_STORAGE"
- `void getLanguageXml(Context mContext)`  L68
    - 体内字面量："android.permission.WRITE_EXTERNAL_STORAGE"
- `String changeStr(String value)`  L77
    - 体内字面量："ASAFASFASFASF changeStr: " · "HK" · "_HK" · "changeStr" · "DV.cameraInfors="
- `String readTxtFile(String filePath)`  L115
    - 体内字面量："æ¾ä¸å°æå®çæä»¶" · "UTF-8" · "è¯»åæä»¶åå®¹åºé"
- `String getReplaceValueForJson(String value, String sysLanguage)`  L141
    - 体内字面量："/" · ".txt" · "en"
- `String getReplaceValueForXml(String enValue, String targetLang)`  L160
- `String escapeXml(String xml)`  L185
    - 体内字面量："&(?!amp;|lt;|gt;|quot;|apos;|#[0-9]+;)" · "&amp;"
- `String readFileToString(File file, Charset charset)`  L192
    - 体内字面量："\n"
### `com.gku.actioncam.sigmastar.data.SSLanguageParse`
L15 · [class] public SSLanguageParse · `com/gku/actioncam/sigmastar/data/SSLanguageParse.java`

方法（1）：
- `String exchangeStringLanguage(String value)`  L16
    - 体内字面量："HK" · "_HK" · "/" · ".txt" · "lanstr" · "en"
### `com.gku.actioncam.sigmastar.data.SSResponseParse`
L38 · [class] public SSResponseParse · `com/gku/actioncam/sigmastar/data/SSResponseParse.java`

字段/常量（18）：
- `String HEAD_VAR = "var "`  L39
- `String MID_EQUAL_MARK = "=\""`  L40
- `String SS_SUCCESS = "Success"`  L41
- `String TAG = "SSResponseParse"`  L42
- `String TAIL_SEMICOLON = "\";\r\n"`  L43
- `int i = 0`  L98
- `int i2 = 0`  L103
- `int i3 = 0`  L104
- `boolean zContains`  L133
- `int i`  L246
- `int i2 = 0`  L249
- `int i`  L264
- `int i2 = 0`  L267
- `SSTFCardInfo.TFCardState tFCardState`  L282
- `SSTFCardInfo.TFCardState tFCardState`  L302
- `SettingRecycleAdapter.SettingItemType settingItemType`  L385
- `SettingRecycleAdapter.SettingItemType settingItemType`  L424
- `int i`  L498

方法（30）：
- `String parseToString(Response response)`  L45
- `String[] parseDirname(String response)`  L54
    - 体内字面量："parseGetFileCount: " · "value"
- `int parseGetFileCount(Response response, int type)`  L68
    - 体内字面量："parseGetFileCount: " · "imagecount" · "videocount"
- `int parseGetFileCount(String response, String type)`  L79
    - 体内字面量："Video" · "Normal" · "Emr" · "eventcount" · "Photo" · "imagecount" · "videocount"
- `int parseGetFileCount(String response)`  L97
- `SSRemoteFileInfo parseGetFileInfo(String response)`  L117
    - 体内字面量："size"
- `ArrayList<SSFileInfoBean> parseGetFileListAndInfo(String response, String type)`  L132
- `void parseGetFileInfo(String response, String type)`  L175
    - 体内字面量："size" · "Normal" · "Video" · "Event" · "Photo"
- `HashMap<String, ArrayList<String>> parseGetAllWorkMode(String response)`  L203
    - 体内字面量："video" · "video" · "photo" · "photo" · "photo"
- `String parseGetCurWorkMode(Response response)`  L218
    - 体内字面量："workmode"
- `String parseGetCurWorkMode(String response)`  L227
    - 体内字面量："workmode"
- `HashMap<String, String> parseGetCurWorkModeForMap(String response)`  L236
- `SSBatteryInfo parseGetBatteryInfo(Response response)`  L245
- `SSBatteryInfo parseGetBatteryInfo(String response)`  L263
- `SSTFCardInfo parseGetSdCardInfo(Response response)`  L281
- `SSTFCardInfo parseGetSdCardInfo(String response)`  L301
- `String parseGetResolution(Response response)`  L325
    - 体内字面量："value"
- `String parseGetResolution(String response)`  L334
    - 体内字面量："value"
- `SSecondItemBean parseGetSecondItem(Response response)`  L343
    - 体内字面量："parseGetSecondItem: " · "item" · "value"
- `SSecondItemBean parseGetSecondItem(String response)`  L355
    - 体内字面量："parseGetSecondItem: " · "item" · "value"
- `String parseGetFastSetting(Response response)`  L366
    - 体内字面量："value"
- `String parseGetFastSetting(String response)`  L375
    - 体内字面量："value"
- `ArrayList<SSettingItemBean> parseGetPrimaryMenuItem(Response response)`  L384
- `ArrayList<SSettingItemBean> parseGetPrimaryMenuItem(String response)`  L423
- `SSWiFiInfo parseGetWiFi(Response response)`  L467
    - 体内字面量："wifissid" · "wifikey"
- `SSWiFiInfo parseGetWiFi(String response)`  L477
    - 体内字面量："wifissid" · "wifikey"
- `SSystemWorkState parseGetAllInfo(Response response)`  L487
    - 体内字面量："mode" · "state" · "event" · "pasttime"
- `SSystemWorkState parseGetAllInfo(String message)`  L497
- `HashMap<String, String> parseMessageToMap(String content)`  L532
- `HashMap<String, String> parseMessageToMap2(String content)`  L547
    - 体内字面量："\";"