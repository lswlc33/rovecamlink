# XTU GO — 类与成员明细：com.gku.actioncam.amba

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 57 个文件 / 98 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.amba.AmbaConstant`
L4 · [class] public AmbaConstant · `com/gku/actioncam/amba/AmbaConstant.java`

字段/常量（3）：
- `int AMBA_CMD_PORT = 7878`  L5
- `int AMBA_DATA_PORT = 8787`  L6
- `boolean ENABLE_AMBA = true`  L7
### `com.gku.actioncam.amba.base.IjkBaseActivity`
L25 · [class] public IjkBaseActivity · extends `BaseActivity` · `com/gku/actioncam/amba/base/IjkBaseActivity.java`

字段/常量（7）：
- `ScanResultReceiver scanResultReceiver`  L26
- `WifiDisconnectReceiver disconnectReceiver`  L27
- `AlertDialog loadingDialog`  L28
- `WifiDisconnectListener wifiDisconnectListener`  L29
- `WifiDisconnectListener wifiDisconnectListener = this.wifiDisconnectListener`  L67
- `AlertDialog alertDialog = this.loadingDialog`  L155
- `WifiDisconnectReceiver wifiDisconnectReceiver = this.disconnectReceiver`  L176

方法（14）：
- `void onCreate(Bundle savedInstanceState)`  L37 @Override
    - 体内字面量："android.net.wifi.STATE_CHANGE"
- `void onWifiStateChanged(NetworkInfo.DetailedState detailedState)`  L55 @Override
- `void lambda$onCreate$0(NetworkInfo.DetailedState detailedState)`  L62
    - 体内字面量："yunqi_debug" · "onWifiStateChanged: ç½ç»æ­å¼äº"
- `void setWifiDisconnectListener(WifiDisconnectListener wifiDisconnectListener)`  L74
- `void exitCameraPage(String whyExit, IChannelListener iChannelListener)`  L116
    - 体内字面量："yunqi_debug" · "exitCameraPage: " · "amba_init_failed"
- `void backHomeNewActivity()`  L121
- `AlertDialog initUniversalProgressDialog()`  L127
- `void showProgressDialog()`  L137
- `void run()`  L140 @Override
- `void lambda$showProgressDialog$1()`  L147
- `void dismissProgressDialog()`  L154
- `void run()`  L161 @Override
- `void lambda$dismissProgressDialog$2()`  L168
- `void onDestroy()`  L174 @Override
### `com.gku.actioncam.amba.base.IjkBaseActivity$AnonymousClass1`
L99 · [class] static AnonymousClass1 · `com/gku/actioncam/amba/base/IjkBaseActivity.java`

字段/常量（1）：
- `int[] $SwitchMap$android$net$NetworkInfo$DetailedState`  L100
### `com.gku.actioncam.amba.base.IjkBaseActivity$ScanResultReceiver`
L78 · [class] public ScanResultReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/amba/base/IjkBaseActivity.java`

字段/常量（1）：
- `NetworkInfo networkInfo`  L84

方法（2）：
- `public ScanResultReceiver()`  L79
- `void onReceive(Context c, Intent intent)`  L83 @Override
### `com.gku.actioncam.amba.base.IjkBaseActivity$WifiDisconnectListener`
L32 · [interface] public WifiDisconnectListener · `com/gku/actioncam/amba/base/IjkBaseActivity.java`

方法（1）：
- `void disconnect()`  L33
### `com.gku.actioncam.amba.model.AmbaCmdModel`
L45 · [class] public AmbaCmdModel · `com/gku/actioncam/amba/model/AmbaCmdModel.java`

字段/常量（91）：
- `int AMBA_BATTERY_LEVEL = 13`  L46
- `int AMBA_BURN_FW = 8`  L47
- `int AMBA_CANCLE_XFER = 1287`  L48
- `int AMBA_CD = 1283`  L49
- `int AMBA_DEL = 1281`  L50
- `int AMBA_DELETE_ALL_FILE = 268435487`  L51
- `int AMBA_DELETE_FILE = 268435486`  L52
- `int AMBA_FORCE_SPLIT = 516`  L53
- `int AMBA_FORMAT_SD = 4`  L54
- `int AMBA_GET_ALL = 3`  L55
- `int AMBA_GET_ALL_WORKMODE = 268435457`  L56
- `int AMBA_GET_APP_CONNECT_STATE = 268435469`  L57
- `int AMBA_GET_BLUETOOTH_TX = 268435507`  L58
- `int AMBA_GET_BTATERY_INFO = 268435480`  L59
- `int AMBA_GET_CAMERA_STATE = 268435470`  L60
- `int AMBA_GET_CUR_PARAMETER = 268435462`  L61
- `int AMBA_GET_CUR_WORKMODE = 268435458`  L62
- `int AMBA_GET_DEVICE_INFO = 11`  L63
- `int AMBA_GET_DEVINFO = 11`  L64
- `int AMBA_GET_FILE = 1285`  L65
- `int AMBA_GET_FILELIST_INFO = 268435465`  L66
- `int AMBA_GET_FILELIST_INFO_IOS = 268435485`  L67
- `int AMBA_GET_FILETYPE_COUNT = 268435464`  L68
- `int AMBA_GET_FILE_COUNT = 268435482`  L69
- `int AMBA_GET_FILE_INFO = 268435484`  L70
- `int AMBA_GET_FILE_LIST = 268435483`  L71
- `int AMBA_GET_GPS_STATE = 268435468`  L72
- `int AMBA_GET_MEDIAINFO = 1026`  L73
- `int AMBA_GET_NUM_FILES = 6`  L74
- `int AMBA_GET_OPTIONS = 9`  L75
- `int AMBA_GET_PRIMARY_MENU_ITEM = 268435460`  L76
- `int AMBA_GET_ROTATE = 268435489`  L77
- `int AMBA_GET_SD_STATE = 268435475`  L78
- `int AMBA_GET_SECOND_MENU_ITEM = 268435461`  L79
- `int AMBA_GET_SETTING = 1`  L80
- `int AMBA_GET_SPACE = 5`  L81
- `int AMBA_GET_SYSTEM_WORK_STATE = 268435466`  L82
- `int AMBA_GET_THUMB = 1025`  L83
- `int AMBA_GET_WIFI_INFO = 268435478`  L84
- `int AMBA_GET_WIFI_SETTING = 1539`  L85
- `int AMBA_GET_WIFI_STATUS = 1542`  L86
- `int AMBA_HEART_BEAT = 268435467`  L87
- `int AMBA_LS = 1282`  L88
- `int AMBA_NOTIFICATION = 7`  L89
- `int AMBA_POWER_MANAGE = 12`  L90
- `int AMBA_PUT_FILE = 1286`  L91
- `int AMBA_PWD = 1284`  L92
- `int AMBA_QS_ADD_TIME = 268435488`  L93
- `int AMBA_QUERY_SESSION_HOLDER = 1793`  L94
- `int AMBA_RECORD_START = 513`  L95
- `int AMBA_RECORD_STOP = 514`  L96
- `int AMBA_RECORD_TIME = 515`  L97
- `int AMBA_RESETVF = 259`  L98
- `int AMBA_RESET_FACTORY = 268435477`  L99
- `int AMBA_SD_FORMAT = 268435476`  L100
- `int AMBA_SET_ATTRIBUTE = 1027`  L101
- `int AMBA_SET_BITRATE = 16`  L102
- `int AMBA_SET_CAMERA_STATE = 268435471`  L103
- `int AMBA_SET_CLINT_INFO = 261`  L104
- `int AMBA_SET_CUR_PARAMETER = 268435463`  L105
- `int AMBA_SET_CUR_WORKMODE = 268435459`  L106
- `int AMBA_SET_SETTING = 2`  L107
- `int AMBA_SET_WIFI_INFO = 268435479`  L108
- `int AMBA_SET_WIFI_SETTING = 1538`  L109
- `int AMBA_START_SESSION = 257`  L110
- `int AMBA_STOP_PHOTO = 770`  L111
- `int AMBA_STOP_SESSION = 258`  L112
- `int AMBA_STOP_VF = 260`  L113
- `int AMBA_SYNC_SYSTEM_TIME = 268435474`  L114
- `int AMBA_TAKE_PHOTO = 769`  L115
- `int AMBA_TAKE_PHOTO_END = 268632078`  L116
- `int AMBA_TAKE_PHOTO_START = 268632077`  L117
- `int AMBA_WIFI_RESTART = 1537`  L118
- `int AMBA_WIFI_START = 1541`  L119
- `int AMBA_WIFI_STOP = 1540`  L120
- `int AMBA_ZOOM = 14`  L121
- `int AMBA_ZOOM_INFO = 15`  L122
- `int CARD_PROTECTED = -18`  L123
- `int ERROR_NO_SUPPORT_PARAM = -34`  L124
- `int ERROR_UNKNOW = -1`  L125
- `int ERR_INVALID_TOKEN = -4`  L126
- `int ERR_MAX_NUM = 26`  L127
- `int LINK_REFUSE = -444`  L128
- `int NO_MORE_SPACE = -17`  L129
- `int NO_SD_CARD = -33`  L130
- `Boolean mLastOne`  L131
- `AmbaRequestCallback ambaRequestCallback2 = ambaRequestCallback`  L167
- `AmbaRequestCallback ambaRequestCallback2 = ambaRequestCallback`  L177
- `AmbaRequestCallback ambaRequestCallback2 = ambaRequestCallback`  L192
- `AmbaRequestCallback ambaRequestCallback2 = ambaRequestCallback`  L202
- `String str = "<binary/metadata>"`  L391

方法（56）：
- `void disConnect()`  L133
- `void reLoad()`  L136
- `void release()`  L139
- `void startSession(AmbaRequestCallback ambaRequestCallback)`  L142
- `private AmbaCmdModel()`  L145
- `AmbaCmdModel getInstance()`  L156
- `void sendCmdQueue(CmdRequestBean cmdRequestBean, final AmbaRequestCallback ambaRequestCallback, final IChannelListener iChannelListener)`  L161
    - 体内字面量："AmbaCmdMod"
- `void onSuccess(CmdResponseBean responseBean, String json)`  L165 @Override
- `void onFail(int code)`  L175 @Override
- `void sendCmdQueueTimesIfTimeOut(CmdRequestBean cmdRequestBean, final AmbaRequestCallback ambaRequestCallback, final IChannelListener iChannelListener, int times)`  L186
    - 体内字面量："AmbaCmdMod"
- `void onSuccess(CmdResponseBean responseBean, String json)`  L190 @Override
- `void onFail(int code)`  L200 @Override
- `void getDeviceInfo(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L211
- `void getAllWorkMode(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L215
- `void getCurWorkMode(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L219
- `void setCurWorkMode(String setCurMode, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L223
- `void takePhoto(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L227
- `void stopPhoto(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L231
- `void record_start(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L235
- `void record_stop(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L239
- `void getSystemWorkState(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L243
- `void getSDState(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L247
- `void getPrimaryMenuItem(String workMode, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L251
- `void getFileCount(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L255
- `void getFileInfoList(int start, int end, int realEnd, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L259
    - 体内字面量："getFileInfoList" · "start:" · " end:" · " realEnd" · "xtuGetFileInfoListè¿å¥" · "xtuGetFileInfoListè¯·æ±ä¸æ¬¡"
- `void getFileList(int start, int end, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L266
- `void getFileInfo(String path, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L270
- `void getFile(String path, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L274
- `void setClientInfo(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L278
    - 体内字面量："TCP"
- `void deleteFile(String path, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L282
- `void deleteAllTypeFile(int fileType, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L286
- `void getRotate(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L290
- `void getBluetoothTX(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L294
- `void pairAndGetBluetoothTX(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L298
- `void syncSystemTime(String timeFormat, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L302
- `void syncSystemTimeZone(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L306
    - 体内字面量："Time Zone"
- `String getCurrentTimeZoneOffset()`  L310
    - 体内字面量："%+d"
- `void getSecondMenuItem(String workMode, String name, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L314
- `void resetVF(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L319 @Deprecated
    - 体内字面量："none_force"
- `void stopVF(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L324 @Deprecated
- `void setCurParameter(String workMode, String itemName, String itemValue, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L328
- `void formatSD(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L332
    - 体内字面量："C:"
- `void putFile(String to, String md5, long size, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L336
- `void resetFactory(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L340
- `void getBatteryInfo(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L344
- `void getThumbOnWorkerThread(String path, String type, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L348
- `void getThumb(final String path, final String type, final AmbaRequestCallback ambaRequestCallback, final IChannelListener iChannelListener)`  L352
- `void failure(int code)`  L355 @Override
- `void success()`  L359 @Override
- `void getWifiSetting(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L365
- `void setWifiSetting(String ssid, String password, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L369
- `void cancelPutFile(String path, int size, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L373
- `void qsAddTime(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L377
- `void updateBTheartbeat(AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L381
- `void uploadStreamData(String param, AmbaRequestCallback ambaRequestCallback, IChannelListener iChannelListener)`  L385
- `void handleResponse(String msg, IChannelListener mListener)`  L390
### `com.gku.actioncam.amba.model.AmbaCmdModel$Holder`
L149 · [class] private static Holder · `com/gku/actioncam/amba/model/AmbaCmdModel.java`

方法（1）：
- `private Holder()`  L152
### `com.gku.actioncam.amba.model.AmbaDataModel`
L14 · [class] public AmbaDataModel · `com/gku/actioncam/amba/model/AmbaDataModel.java`

字段/常量（12）：
- `String TAG = "AmbaDataModel"`  L15
- `AmbaDataModel ambaDataModel`  L16
- `ExecutorService worker`  L17
- `DataChannelWIFI dataChannelWIFI`  L18
- `AmbaDataModel ambaDataModel2 = ambaDataModel`  L39
- `AmbaDataModel ambaDataModel2 = ambaDataModel`  L55
- `DataChannelWIFI dataChannelWIFI = this.dataChannelWIFI`  L67
- `DataChannelWIFI dataChannelWIFI = this.dataChannelWIFI`  L74
- `DataChannelWIFI dataChannelWIFI = this.dataChannelWIFI`  L101
- `DataChannelWIFI dataChannelWIFI = this.dataChannelWIFI`  L109
- `ExecutorService executorService = worker`  L119
- `DataChannelWIFI dataChannelWIFI = this.dataChannelWIFI`  L123

方法（23）：
- `private AmbaDataModel(String host, int port, IChannelListener iChannelListener)`  L20
- `void setChannelListener(IChannelListener iChannelListener)`  L26
- `AmbaDataModel getInstance(String host, int port, IChannelListener iChannelListener)`  L30
- `AmbaDataModel getInstance(IChannelListener iChannelListener)`  L46
- `AmbaDataModel getInstance()`  L62
- `void updateIp(String host, int port)`  L66
- `void setDataChannelErrorListener(DataChannel.DataChannelErrorListener listener)`  L73
- `void connect(final AmbaRequestCallback ambaRequestCallback)`  L80
    - 体内字面量："123->  ambaDataModel  socket connect"
- `void run()`  L84 @Override
    - 体内字面量："connect: data channel wifi connect on success" · "connect: data channel wifi connect on failure"
- `boolean isConnected()`  L96
- `void disConnect2()`  L100
- `void release()`  L108
- `void disConnect()`  L118
- `void getFile(final String dtsPath, final long size)`  L133 @Deprecated
- `void run()`  L136 @Override
- `void getFileAsync(final String dtsPath, final long size)`  L142
- `void run()`  L145 @Override
- `void getFileAsync(final String dtsPath, final long size, final DataChannel.GetFileResultListener listener)`  L151
- `void run()`  L154 @Override
- `void cancelGetFile()`  L160
- `void run()`  L163 @Override
- `void putFile(final Context context, final String srcPath)`  L169
- `void run()`  L172 @Override
### `com.gku.actioncam.amba.socket.AmbaRequestCallback`
L4 · [class] public abstract AmbaRequestCallback · `com/gku/actioncam/amba/socket/AmbaRequestCallback.java`

字段/常量（2）：
- `String json = "<binary/metadata>"`  L5
- `String msg_error = "<binary/metadata>"`  L6

方法（6）：
- `void failure(int code)`  L8
- `void success()`  L10
- `String getJson()`  L12
- `void setJson(String json)`  L16
- `String getMsg_error()`  L20
- `void setMsg_error(String msg_error)`  L24
### `com.gku.actioncam.amba.socket.bean.BaseAmbaBean`
L4 · [class] public BaseAmbaBean · `com/gku/actioncam/amba/socket/bean/BaseAmbaBean.java`

字段/常量（2）：
- `int msg_id`  L5
- `int rval`  L6

方法（4）：
- `int getRval()`  L8
- `void setRval(int rval)`  L12
- `int getMsg_id()`  L16
- `void setMsg_id(int msg_id)`  L20
### `com.gku.actioncam.amba.socket.bean.CameraInfoBean`
L4 · [class] public CameraInfoBean · extends `BaseAmbaBean` · `com/gku/actioncam/amba/socket/bean/CameraInfoBean.java`

字段/常量（15）：
- `String bluetoothrxversion`  L5
- `String bluetoothtxoneversion`  L6
- `String bluetoothtxtwoversion`  L7
- `String hardversion`  L8
- `int model`  L9
- `String name`  L10
- `int networkstatus`  L11
- `String pcbrevision`  L12
- `String region`  L13
- `int runtimes`  L14
- `String serialnum`  L15
- `String softversion`  L16
- `int startdate`  L17
- `int timeout`  L18
- `String type`  L19

方法（30）：
- `String getName()`  L21
- `void setName(String name)`  L25
- `String getSerialnum()`  L29
- `void setSerialnum(String serialnum)`  L33
- `String getType()`  L37
- `void setType(String type)`  L41
- `int getNetworkstatus()`  L45
- `String getPcbrevision()`  L49
- `void setPcbrevision(String pcbrevision)`  L53
- `void setNetworkstatus(int networkstatus)`  L57
- `String getSoftversion()`  L61
- `void setSoftversion(String softversion)`  L65
- `String getRegion()`  L69
- `void setRegion(String region)`  L73
- `String getHardversion()`  L77
- `void setHardversion(String hardversion)`  L81
- `int getStartdate()`  L85
- `void setStartdate(int startdate)`  L89
- `int getRuntimes()`  L93
- `void setRuntimes(int runtimes)`  L97
- `int getModel()`  L101
- `void setModel(int model)`  L105
- `int getTimeout()`  L109
- `void setTimeout(int timeout)`  L113
- `String getBluetoothrxversion()`  L117
- `void setBluetoothrxversion(String bluetoothrxversion)`  L121
- `String getBluetoothtxoneversion()`  L125
- `void setBluetoothtxoneversion(String bluetoothtxoneversion)`  L129
- `String getBluetoothtxtwoversion()`  L133
- `void setBluetoothtxtwoversion(String bluetoothtxtwoversion)`  L137
### `com.gku.actioncam.amba.socket.bean.LanguageBean`
L4 · [class] public LanguageBean · `com/gku/actioncam/amba/socket/bean/LanguageBean.java`

字段/常量（10）：
- `String de`  L5
- `String en`  L6
- `String fr`  L7
- `String it`  L8
- `String ja`  L9
- `String kr`  L10
- `String rus`  L11
- `String sp`  L12
- `String zh`  L13
- `String zh_HK`  L14

方法（21）：
- `String getKr()`  L16
- `void setKr(String kr)`  L20
- `String getFr()`  L24
- `void setFr(String fr)`  L28
- `String getSp()`  L32
- `void setSp(String sp)`  L36
- `String getDe()`  L40
- `void setDe(String de)`  L44
- `String getIt()`  L48
- `void setIt(String it)`  L52
- `String getRus()`  L56
- `void setRus(String rus)`  L60
- `String getEn()`  L64
- `void setEn(String en)`  L68
- `String getZh()`  L72
- `void setZh(String zh)`  L76
- `String getJa()`  L80
- `void setJa(String ja)`  L84
- `String getZh_HK()`  L88
- `void setZh_HK(String zh_HK)`  L92
- `String toString()`  L96
    - 体内字面量："LanguageBean{en='" · "', zh='" · "', ja='" · "', zh_HK='" · "'}"
### `com.gku.actioncam.amba.socket.DataChannel`
L14 · [class] public DataChannel · `com/gku/actioncam/amba/socket/DataChannel.java`

字段/常量（27）：
- `int PROGRESS_MIN_STEP = 1`  L15
- `String TAG = "DataChannel"`  L16
- `boolean mContinueRx`  L17
- `boolean mContinueTx`  L18
- `DataChannelErrorListener mErrorListener`  L19
- `InputStream mInputStream`  L20
- `IChannelListener mListener`  L21
- `OutputStream mOutputStream`  L22
- `int mTxBytes`  L23
- `int i`  L100
- `byte[] bArr = new byte[1024]`  L102
- `IChannelListener iChannelListener = this.mListener`  L106
- `int i2 = 0`  L110
- `int i3 = 0`  L111
- `IChannelListener iChannelListener2 = this.mListener`  L118
- `IChannelListener iChannelListener3 = this.mListener`  L127
- `DataChannelErrorListener dataChannelErrorListener = this.mErrorListener`  L138
- `int i`  L147
- `byte[] bArr = new byte[1048576]`  L152
- `IChannelListener iChannelListener = this.mListener`  L155
- `int i2 = 0`  L160
- `int i3 = 0`  L161
- `int i4 = 0`  L162
- `int i5 = 0`  L163
- `long j = i2`  L165
- `DataChannelErrorListener dataChannelErrorListener = this.mErrorListener`  L204
- `IChannelListener iChannelListener2 = this.mListener`  L224

方法（12）：
- `void setDataChannelErrorListener(DataChannelErrorListener listener)`  L36
- `public DataChannel(IChannelListener listener)`  L40
- `void setmListener(IChannelListener mListener)`  L44
- `DataChannel setStream(InputStream input, OutputStream output)`  L48
- `void getFile(final String dstPath, final long size)`  L54
- `void getFileAsync(String dstPath, long size, GetFileResultListener listener)`  L59
- `void getThumbFileAsync(String dstPath, long size)`  L70
- `void cancelGetFile()`  L75
- `void putFile(Context context, String srcPath)`  L82
- `int cancelPutFile()`  L87
- `void txStream(Context context, String srcPath)`  L99
- `void rxStream(String dstPath, long size)`  L146
### `com.gku.actioncam.amba.socket.DataChannel$DataChannelErrorListener`
L28 · [interface] public DataChannelErrorListener · `com/gku/actioncam/amba/socket/DataChannel.java`

方法（1）：
- `void onStreamError()`  L29
### `com.gku.actioncam.amba.socket.DataChannel$GetFileResultListener`
L32 · [interface] public GetFileResultListener · `com/gku/actioncam/amba/socket/DataChannel.java`

方法（1）：
- `void onResult(boolean isSuccess)`  L33
### `com.gku.actioncam.amba.socket.DataChannelWIFI`
L7 · [class] public DataChannelWIFI · extends `DataChannel` · `com/gku/actioncam/amba/socket/DataChannelWIFI.java`

字段/常量（8）：
- `int CONN_TIME_OUT = 3000`  L8
- `int READ_TIME_OUT = 3000`  L9
- `String TAG = "DataChannelWIFI"`  L10
- `String mHostName`  L11
- `int mPortNum`  L12
- `Socket mSocket`  L13
- `Socket socket = this.mSocket`  L46
- `Socket socket = this.mSocket`  L58

方法（5）：
- `boolean connect()`  L15
- `public DataChannelWIFI(IChannelListener listener)`  L19
- `DataChannelWIFI setIP(String host, int port)`  L23
- `void disConnect()`  L29
- `boolean isConnected()`  L57
### `com.gku.actioncam.amba.socket.IChannelListener`
L4 · [interface] public IChannelListener · `com/gku/actioncam/amba/socket/IChannelListener.java`

字段/常量（83）：
- `int CMD_CHANNEL_ERROR_BLE_DISABLED = 131`  L5
- `int CMD_CHANNEL_ERROR_BLE_INVALID_ADDR = 130`  L6
- `int CMD_CHANNEL_ERROR_BROKEN_CHANNEL = 132`  L7
- `int CMD_CHANNEL_ERROR_CONNECT = 134`  L8
- `int CMD_CHANNEL_ERROR_CONTENT = 135`  L9
- `int CMD_CHANNEL_ERROR_INVALID_TOKEN = 129`  L10
- `int CMD_CHANNEL_ERROR_LINK_REFUSE = 137`  L11
- `int CMD_CHANNEL_ERROR_TIMEOUT = 128`  L12
- `int CMD_CHANNEL_ERROR_UNKNOW = 136`  L13
- `int CMD_CHANNEL_ERROR_WAKEUP = 133`  L14
- `int CMD_CHANNEL_EVENT_BATTERY_LEVEL = 20`  L15
- `int CMD_CHANNEL_EVENT_CONNECTED = 13`  L16
- `int CMD_CHANNEL_EVENT_DEL = 6`  L17
- `int CMD_CHANNEL_EVENT_DELETE_ALL_TYPE_FILE = 63`  L18
- `int CMD_CHANNEL_EVENT_DELETE_FILE = 62`  L19
- `int CMD_CHANNEL_EVENT_FORMAT_SD = 18`  L20
- `int CMD_CHANNEL_EVENT_GET_ALL_SETTINGS = 10`  L21
- `int CMD_CHANNEL_EVENT_GET_ALL_WORK_MODE = 48`  L22
- `int CMD_CHANNEL_EVENT_GET_BATTERY_INFO = 56`  L23
- `int CMD_CHANNEL_EVENT_GET_BLUETOOTH_TX = 71`  L24
- `int CMD_CHANNEL_EVENT_GET_CUR_WORK_MODE = 49`  L25
- `int CMD_CHANNEL_EVENT_GET_DEVINFO = 17`  L26
- `int CMD_CHANNEL_EVENT_GET_FILE = 7`  L27
- `int CMD_CHANNEL_EVENT_GET_FILE_COUNT = 59`  L28
- `int CMD_CHANNEL_EVENT_GET_FILE_INFO = 69`  L29
- `int CMD_CHANNEL_EVENT_GET_FILE_LIST = 68`  L30
- `int CMD_CHANNEL_EVENT_GET_FILE_LIST_INFO_IOS = 60`  L31
- `int CMD_CHANNEL_EVENT_GET_INFO = 8`  L32
- `int CMD_CHANNEL_EVENT_GET_NUM_FILES = 16`  L33
- `int CMD_CHANNEL_EVENT_GET_OPTIONS = 11`  L34
- `int CMD_CHANNEL_EVENT_GET_PRIMARY_MENU_ITEM = 58`  L35
- `int CMD_CHANNEL_EVENT_GET_ROTATE = 70`  L36
- `int CMD_CHANNEL_EVENT_GET_SD_STATE = 57`  L37
- `int CMD_CHANNEL_EVENT_GET_SECOND_MENU_ITEM = 64`  L38
- `int CMD_CHANNEL_EVENT_GET_SPACE = 15`  L39
- `int CMD_CHANNEL_EVENT_GET_SYSTEM_WORK_STATE = 55`  L40
- `int CMD_CHANNEL_EVENT_GET_THUMB = 37`  L41
- `int CMD_CHANNEL_EVENT_GET_WIFI_SETTING = 41`  L42
- `int CMD_CHANNEL_EVENT_GET_ZOOM_INFO = 39`  L43
- `int CMD_CHANNEL_EVENT_INIT = 1`  L44
- `int CMD_CHANNEL_EVENT_LOG = 3`  L45
- `int CMD_CHANNEL_EVENT_LS = 5`  L46
- `int CMD_CHANNEL_EVENT_PUT_FILE = 19`  L47
- `int CMD_CHANNEL_EVENT_QS_ADD_TIME = 67`  L48
- `int CMD_CHANNEL_EVENT_QUERY_SESSION_HOLDER = 40`  L49
- `int CMD_CHANNEL_EVENT_RECORD_TIME = 21`  L50
- `int CMD_CHANNEL_EVENT_RESETVF = 9`  L51
- `int CMD_CHANNEL_EVENT_RESET_FACTORY = 66`  L52
- `int CMD_CHANNEL_EVENT_SET_ATTRIBUTE = 36`  L53
- `int CMD_CHANNEL_EVENT_SET_CUR_PARAMETER = 65`  L54
- `int CMD_CHANNEL_EVENT_SET_CUR_WORK_MODE = 50`  L55
- `int CMD_CHANNEL_EVENT_SET_SETTING = 12`  L56
- `int CMD_CHANNEL_EVENT_SET_ZOOM = 38`  L57
- `int CMD_CHANNEL_EVENT_SHOW_ALERT = 4`  L58
- `int CMD_CHANNEL_EVENT_SHUTDOWN = 2`  L59
- `int CMD_CHANNEL_EVENT_START_CONNECT = 32`  L60
- `int CMD_CHANNEL_EVENT_START_LS = 33`  L61
- `int CMD_CHANNEL_EVENT_START_RECORD = 53`  L62
- `int CMD_CHANNEL_EVENT_START_SESSION = 23`  L63
- `int CMD_CHANNEL_EVENT_STOP_PHOTO = 52`  L64
- `int CMD_CHANNEL_EVENT_STOP_RECORD = 54`  L65
- `int CMD_CHANNEL_EVENT_STOP_SESSION = 24`  L66
- `int CMD_CHANNEL_EVENT_STOP_VF = 22`  L67
- `int CMD_CHANNEL_EVENT_SYNC_SYSTEM_TIME = 61`  L68
- `int CMD_CHANNEL_EVENT_TAKE_PHOTO = 51`  L69
- `int CMD_CHANNEL_EVENT_WAKEUP_OK = 35`  L70
- `int CMD_CHANNEL_EVENT_WAKEUP_START = 34`  L71
- `int CMD_CHANNEL_MSG = 0`  L72
- `int DATA_CHANNEL_EVENT_GET_FINISH = 514`  L73
- `int DATA_CHANNEL_EVENT_GET_PROGRESS = 513`  L74
- `int DATA_CHANNEL_EVENT_GET_START = 512`  L75
- `int DATA_CHANNEL_EVENT_PUT_FINISH = 517`  L76
- `int DATA_CHANNEL_EVENT_PUT_MD5 = 518`  L77
- `int DATA_CHANNEL_EVENT_PUT_PROGRESS = 516`  L78
- `int DATA_CHANNEL_EVENT_PUT_START = 515`  L79
- `int DATA_CHANNEL_MSG = 512`  L80
- `int MSG_MASK = 2147483392`  L81
- `int STREAM_CHANNEL_ERROR_PLAYING = 1026`  L82
- `int STREAM_CHANNEL_EVENT_BUFFERING = 1024`  L83
- `int STREAM_CHANNEL_EVENT_PHOTOEND = 1028`  L84
- `int STREAM_CHANNEL_EVENT_PHOTOSTART = 1027`  L85
- `int STREAM_CHANNEL_EVENT_PLAYING = 1025`  L86
- `int STREAM_CHANNEL_MSG = 1024`  L87

方法（1）：
- `void onChannelEvent(int type, Object param, String... array)`  L89
### `com.gku.actioncam.amba.ui.AmbaErrorDialogFragment`
L17 · [class] public AmbaErrorDialogFragment · extends `DialogFragment` · `com/gku/actioncam/amba/ui/AmbaErrorDialogFragment.java`

字段/常量（2）：
- `String errorMessage`  L18
- `IChannelListener iChannelListener`  L19

方法（5）：
- `public AmbaErrorDialogFragment(String errorMessage, IChannelListener iChannelListener)`  L21
- `Dialog onCreateDialog(Bundle savedInstanceState)`  L27 @Override
    - 体内字面量："Network Error"
- `void onClick(DialogInterface dialogInterface, int i)`  L30 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L35 @Override
- `void lambda$onCreateDialog$1(DialogInterface dialogInterface, int i)`  L42
### `com.gku.actioncam.amba.ui.AmbaFWUtil`
L26 · [class] public AmbaFWUtil · `com/gku/actioncam/amba/ui/AmbaFWUtil.java`

字段/常量（10）：
- `String AMBA_FW_DIR = "fw_amba"`  L27
- `AmbaCmdModel ambaCmdModel`  L28
- `AmbaDataModel ambaDataModel`  L29
- `IChannelListener iChannelListener`  L30
- `String putFilePath`  L31
- `byte[] bArr = new byte[1024]`  L91
- `byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102}`  L116
- `byte b = data[i]`  L118
- `int length = bytes.length`  L126
- `char[] cArr = new char[length]`  L127

方法（16）：
- `public AmbaFWUtil(IChannelListener iChannelListener)`  L33
- `void failure(int code)`  L39 @Override
- `void success()`  L43 @Override
- `void failure(int code)`  L51 @Override
- `void success()`  L55 @Override
- `Pair<String, String> checkUpdate(Context context)`  L60
    - 体内字面量："yunqi_debug" · "checkUpdate: filePath: " · "éè¦æ´æ°çåºä»¶åç§°" · "_" · "fw_amba/"
- `long getSize(String path)`  L82
- `String md5sum(Context context, String filename)`  L90
- `String toHexString(byte[] data)`  L110
- `byte[] encode(byte[] data, int off, int length)`  L114
- `char[] asCharArray(byte[] bytes)`  L125
- `void putFileCmd(final String to, final String md5, final long size, final AmbaRequestCallback ambaRequestCallback)`  L134
- `void failure(int code)`  L140 @Override
- `void success()`  L144 @Override
- `void putFileData(Context context, String srcPath)`  L152
- `void putFirmware(Context context)`  L160
### `com.gku.actioncam.amba.ui.LanguageUtil`
L24 · [class] public LanguageUtil · implements `IChannelListener` · `com/gku/actioncam/amba/ui/LanguageUtil.java`

字段/常量（5）：
- `String TAG = "LanguageUtil"`  L25
- `LanguageUtil languageUtil`  L26
- `AmbaDataModel ambaDataModel`  L28
- `List<LanguageBean> languageBeans`  L29
- `String str = array[0]`  L198

方法（23）：
- `LanguageUtil getInstance()`  L31
- `LanguageUtil getLanguageInstance()`  L42
- `void release()`  L46
    - 体内字面量："123->  languageUtil release"
- `LanguageUtil getInstance(IChannelListener iChannelListener)`  L53
- `private LanguageUtil(IChannelListener iChannelListener)`  L64
- `private LanguageUtil()`  L70
- `String replaceLocaleString(String en)`  L77
    - 体内字面量："changeStr" · "languageLocalPath()=" · "changeStr" · "getLanguage=" · "  en=" · "  " · "zh" · "HK" · "en" · "ja" · "ru" · "ko" · "fr" · "es" · "it" · "de"
- `List<LanguageBean> getLanguageBeans()`  L124 @Deprecated
- `HashMap<String, LanguageBean> getLanguageMap()`  L128
    - 体内字面量："getLanguageMap: languageBeans null"
- `List<LanguageBean> encodeLanguageFile(String localLanguagePath)`  L140
- `String remoteLanguagePath()`  L154
    - 体内字面量："/tmp/FL0/language.json"
- `void pullLanguageFile(AmbaRequestCallback ambaRequestCallback)`  L158
- `void cmdGetFile(final String path, final AmbaRequestCallback ambaRequestCallback)`  L162
- `void success()`  L165 @Override
- `void success()`  L168 @Override
- `void failure(int code)`  L173 @Override
- `void failure(int code)`  L180 @Override
- `void dataGetFile(String localPath, long size, DataChannel.GetFileResultListener listener)`  L186
- `String languageLocalPath()`  L190
- `void onChannelEvent(int type, Object param, String... array)`  L195 @Override
    - 体内字面量："onChannelEvent: cmd get file: "
- `void onResult(boolean isSuccess)`  L201 @Override
    - 体内字面量：".json"
- `void success()`  L207 @Override
    - 体内字面量："è·åè¯­è¨åæå éè¯ rxStream"
- `void failure(int code)`  L212 @Override
    - 体内字面量："è·åè¯­è¨åå¤±è´¥ éè¯ rxStream" · "onChannelEvent: pull remote language file start"
### `com.gku.actioncam.amba.ui.playback.AmbaDlgOrDeleteActivity`
L19 · [class] public AmbaDlgOrDeleteActivity · extends `Activity` · `com/gku/actioncam/amba/ui/playback/AmbaDlgOrDeleteActivity.java`

字段/常量（26）：
- `String AMBA_DLG_RESULT = "amba_result"`  L20
- `String DIALOG_FILE_LIST = "amba_list"`  L21
- `String DIALOG_TYPE = "amba_type"`  L22
- `AmbaDlgOrDeletePresenter ambaDlgOrDeletePresenter`  L23
- `Button btnCancel`  L24
- `int current_operate_type`  L25
- `TextView download_progress_text`  L26
- `ArrayList<String> fileList`  L27
- `ProgressBar mDownloadProcess`  L28
- `TextView tvMessage`  L29
- `TextView tvTitle`  L30
- `Integer DIALOG_DOWNLOAD_TYPE_NORMAL = 11063`  L31
- `Integer DIALOG_DOWNLOAD_TYPE_HD = 11064`  L32
- `Integer DIALOG_DELETE_TYPE_NORMAL = 11060`  L33
- `Integer DIALOG_DELETE_TYPE_VIDEO = 11061`  L34
- `Integer DIALOG_DELETE_TYPE_PHOTO = 11062`  L35
- `boolean isWorking = false`  L36
- `int file_count = 0`  L37
- `boolean isHigh = true`  L38
- `boolean isNeedRenameFile = false`  L39
- `int i = this.current_operate_type`  L73
- `Integer num = DIALOG_DELETE_TYPE_NORMAL`  L90
- `int i = 0`  L91
- `Integer num2 = DIALOG_DELETE_TYPE_VIDEO`  L93
- `Integer num3 = DIALOG_DOWNLOAD_TYPE_HD`  L135
- `int i = this.file_count`  L214

方法（22）：
- `void onCreate(Bundle savedInstanceState)`  L42 @Override
- `void initView()`  L49
- `void onClick(View view)`  L57 @Override
- `void lambda$initView$0(View view)`  L65
- `void dismissDialog()`  L72
- `void addData()`  L82
- `void failure(int code)`  L102 @Override
- `void success()`  L106 @Override
- `void failure(int code)`  L113 @Override
- `void success()`  L117 @Override
- `void failure(int code)`  L124 @Override
- `void success()`  L128 @Override
- `void failure(int code)`  L156 @Override
- `void success()`  L160 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L168 @Override
    - 体内字面量："dlgType" · "Option" · "yunqi_debug" · "onActivityResult: reload" · "yunqi_debug" · "onActivityResult: rename" · "yunqi_debug" · "onActivityResult: skip"
- `void failure(int code)`  L198 @Override
- `void success()`  L202 @Override
- `void updateProgressText(int progress)`  L208
    - 体内字面量："%"
- `void setMessageText(int remainCount)`  L213
- `void downloadUI()`  L222
- `void deleteUI()`  L229
- `void setResultForOperate(int rval)`  L238
### `com.gku.actioncam.amba.ui.playback.AmbaDlgOrDeletePresenter`
L16 · [class] public AmbaDlgOrDeletePresenter · implements `IChannelListener` · `com/gku/actioncam/amba/ui/playback/AmbaDlgOrDeletePresenter.java`
注解：@Deprecated

字段/常量（10）：
- `int AMBA_DELETE_TYPE_PHOTO = 0`  L17
- `int AMBA_DELETE_TYPE_VIDEO = 2`  L18
- `int AMBA_DELETE_TYPE_VOICE = 1`  L19
- `AmbaDataModel ambaDataModel`  L20
- `AmbaDlgOrDeleteActivity ambaDlgOrDeleteActivity`  L21
- `String currentDownloadFileLocalPath = null`  L22
- `String str = array[0]`  L46
- `ArrayList<String> arrayList = this.deleteArray`  L80
- `ArrayList<String> arrayList2 = this.downloadArray`  L114
- `String str`  L152

方法（29）：
- `public AmbaDlgOrDeletePresenter(AmbaDlgOrDeleteActivity ambaDlgOrDeleteActivity)`  L27
- `void failure(int code)`  L34 @Override
- `void success()`  L38 @Override
- `void onChannelEvent(int type, final Object param, String... array)`  L44 @Override
- `void failure(int code)`  L62 @Override
- `void success()`  L66 @Override
- `void run()`  L71 @Override
    - 体内字面量："yunqi_debug" · "onChannelEvent: CMD_CHANNEL_EVENT_DELETE_FILE"
- `void failure(int code)`  L88 @Override
- `void success()`  L92 @Override
    - 体内字面量："yunqi_debug" · "onChannelEvent: DATA_CHANNEL_EVENT_GET_START"
- `void run()`  L105 @Override
    - 体内字面量："yunqi_debug" · "onChannelEvent: progress:" · "yunqi_debug" · "onChannelEvent: DATA_CHANNEL_EVENT_GET_FINISH:"
- `void failure(int code)`  L118 @Override
- `void success()`  L122 @Override
- `void lambda$onChannelEvent$0()`  L138
- `String renameFile(String localPath)`  L142
    - 体内字面量："/" · "/" · "%s_"
- `void deleteUndoneFile()`  L151
- `void downloadArrayTopFile(ArrayList<String> params, AmbaRequestCallback ambaRequestCallback)`  L160
- `void clearDownloadArray()`  L172
- `void downloadFile(final ArrayList<String> params, final AmbaRequestCallback ambaRequestCallback)`  L176
- `void success()`  L179 @Override
- `void failure(int code)`  L185 @Override
- `void replaceFile(ArrayList<String> file_list, boolean isHigh)`  L191
- `void prepareDownload(String dtsPath, AmbaRequestCallback ambaRequestCallback)`  L200
- `void setClientInfo(AmbaRequestCallback ambaRequestCallback)`  L204
- `void getFileAsync(String dtsPath, long size, AmbaRequestCallback ambaRequestCallback)`  L208
- `void cancelGetFile()`  L216
- `void deleteFile(String path, AmbaRequestCallback ambaRequestCallback)`  L220
- `void clearDeleteArray()`  L224
- `void deleteArrayTopFile(ArrayList<String> deleteFileList, AmbaRequestCallback ambaRequestCallback)`  L228
- `void deleteAllTypeFile(int fileType, AmbaRequestCallback ambaRequestCallback)`  L236
### `com.gku.actioncam.amba.ui.playback.AmbaImageAdapter`
L25 · [class] public AmbaImageAdapter · extends `ArrayAdapter<HiDefine.PathConnection>` · `com/gku/actioncam/amba/ui/playback/AmbaImageAdapter.java`

字段/常量（16）：
- `int AMBA_IMAGE_WIDTH_HEIGHT = 85`  L26
- `int AMBA_SELECT_X_POS = 2`  L27
- `int AMBA_SELECT_Y_POS = 2`  L28
- `int AMBA_TIME_TEXT_SIZE = 7`  L29
- `boolean bClearShow`  L30
- `Context context`  L31
- `GetLocalPath getLocalPath`  L32
- `DisplayMetrics mDisplayMetrics`  L33
- `List<HiDefine.PathConnection> mPathConList`  L34
- `List<HiDefine.PathConnection> list = this.mPathConList`  L66
- `String str = pathConnection.strPath`  L75
- `Resources resources`  L164
- `int i`  L165
- `String string`  L189
- `List<HiDefine.PathConnection> list = this.mPathConList`  L205
- `List<HiDefine.PathConnection> list = this.mPathConList`  L214

方法（10）：
- `public AmbaImageAdapter(Context context, int resource, List<HiDefine.PathConnection> mPathConList)`  L36
- `void setFileList(ArrayList<HiDefine.PathConnection> pathConnections)`  L45
- `void setbClearShow(boolean bClearShow)`  L49
    - 体内字面量："yunqi_debug" · "setbClearShow"
- `void setClearShowNoFresh(boolean bClearShow)`  L55
    - 体内字面量："yunqi_debug" · "setClearShowNoFresh"
- `View getView(int position, View convertView, ViewGroup parent)`  L61 @Override
- `View addImage()`  L104
- `void updateInfo(View view, Bitmap bitmap, boolean isDownload, String videoTimeLong)`  L163
- `void updateState(View view, boolean isDownload)`  L188
- `int getCount()`  L204 @Override
- `long getItemId(int position)`  L213 @Override
### `com.gku.actioncam.amba.ui.playback.AmbaPlaybackActivity`
L46 · [class] public AmbaPlaybackActivity · extends `IjkBaseActivity` · `com/gku/actioncam/amba/ui/playback/AmbaPlaybackActivity.java`

字段/常量（53）：
- `AmbaPlaybackPresenter ambaPlaybackPresenter`  L47
- `RelativeLayout bottom_button`  L48
- `Button btnConfirm`  L49
- `Button btnUndo`  L50
- `GetLocalPath getLocalPath`  L51
- `HiDownloadFile hiDownloadFile`  L52
- `HiGridView hiGridView`  L53
- `ImageView ivModeMenu`  L54
- `View layoutBack`  L55
- `LinearLayout lineDelete`  L56
- `LinearLayout lineDownload`  L57
- `LinearLayout lineFileInfo`  L58
- `LinearLayout lineShare`  L59
- `View loadingView`  L60
- `AmbaImageAdapter mImgAdapter`  L61
- `PopupWindow preViewWindow`  L62
- `RefreshHeadView refresh_header_view`  L63
- `TextView tvSelectAll`  L64
- `TextView tvTitle`  L65
- `View vLeftMargin`  L66
- `View vRightMargin`  L67
- `int nSelectCount = 0`  L69
- `boolean bSelectAll = false`  L70
- `int shareType = 0`  L71
- `int mLongPressPos = -1`  L72
- `int operType = 0`  L73
- `boolean isGridClickable = true`  L76
- `int pb_firstVisibleItem = 0`  L77
- `int pb_visibleItemCount = 0`  L78
- `List<HiDefine.PathConnection> prepareLoadThumbList = null`  L79
- `boolean isLoadingThumb = false`  L80
- `View view = this.loadingView`  L148
- `View view = this.loadingView`  L156
- `AmbaPlaybackActivity ambaPlaybackActivity = AmbaPlaybackActivity.this`  L186
- `int i = this.operType`  L250
- `long size = 0`  L272
- `String string`  L375
- `boolean z = this.nSelectCount == 0`  L376
- `int i = this.operType`  L378
- `Button button = this.btnConfirm`  L388
- `AmbaPlaybackPresenter ambaPlaybackPresenter = this.ambaPlaybackPresenter`  L492
- `boolean z = true`  L527
- `ArrayList<HiDefine.PathConnection> arrayList = this.listPathConnection`  L555
- `int i = this.pb_firstVisibleItem`  L556
- `List<HiDefine.PathConnection> list = this.prepareLoadThumbList`  L588
- `int time = 0`  L602
- `int i = 0`  L603
- `List<HiDefine.PathConnection> list = this.prepareLoadThumbList`  L620
- `int time = 0`  L634
- `int i = 0`  L635
- `Bundle extras`  L663
- `AmbaPlaybackActivity ambaPlaybackActivity`  L734
- `int i2 = 0`  L791

方法（66）：
- `void onCreate(Bundle savedInstanceState)`  L85 @Override
- `void disconnect()`  L91 @Override
- `void lambda$onCreate$0()`  L99
- `void onStart()`  L104 @Override
- `void onStop()`  L110 @Override
- `void onDestroy()`  L116 @Override
- `void onRestart()`  L121 @Override
- `void disconnect()`  L126 @Override
- `void failure(int code)`  L132 @Override
- `void success()`  L136 @Override
- `void lambda$onRestart$1()`  L142
- `void showProgress()`  L147 @Deprecated
- `void dismissProgress()`  L155 @Deprecated
- `void initView()`  L162
    - 体内字面量："HYH" · "uysatgfsuifysg7ufy "
- `void onClick(View v)`  L185 @Override
- `void onClick(View view)`  L192 @Override
- `void onClick(View v)`  L198 @Override
- `void onClick(View v)`  L205 @Override
    - 体内字面量："AA" · "setTitileaa: AAAAAA  4"
- `void onClick(View v)`  L217 @Override
- `void onClick(View view)`  L233 @Override
- `void onClick(View view)`  L239 @Override
- `void lambda$initView$2(View view)`  L249
- `void lambda$initView$3(View view)`  L289
- `void lambda$initView$4(View view)`  L294
- `void doOperate()`  L298
- `void undoOperate()`  L315
- `void updateListItemAfterDelete()`  L323
- `void selectAllItems(boolean bSelect)`  L339
- `void multipleChoiceUI(int choiceOperateType)`  L354
- `void updateConfirmText()`  L374
- `void updateAllInfoList(boolean isClearShow)`  L395
    - 体内字面量："JPG" · "MP4"
- `void initGridView()`  L411
- `void onRefresh()`  L416 @Override
- `void onScrollStateChanged(AbsListView view, int scrollState)`  L426 @Override
    - 体内字面量："yunqi_debug" · "onScrollStateChanged: æ»å¨åæ­¢" · "yunqi_debug" · "onScrollStateChanged: æ­£å¨æ»å¨"
- `void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)`  L440 @Override
    - 体内字面量："yunqi_debug" · "onScroll: " · "%s, %s" · "yunqi_debug" · "onScroll: " · "first:%s, visible:%s, total:%s"
- `boolean OnTouchEvent(MotionEvent motionEvent)`  L460 @Override
- `boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)`  L466 @Override
    - 体内字面量："OriFileName" · "bDownloadVisiable" · "bShareVisiable" · "bPushVisiable"
- `void onItemClick(AdapterView adapterView, View view, int i, long j)`  L483 @Override
- `void lambda$initGridView$5()`  L490
- `void failure(int code)`  L498 @Override
- `void success()`  L502 @Override
- `boolean lambda$initGridView$6(MotionEvent motionEvent)`  L508
- `void lambda$initGridView$7(AdapterView adapterView, View view, int i, long j)`  L519
- `void startLoadThumb()`  L550
    - 体内字面量："yunqi_debug" · "startLoadThumb: listPathConnection null"
- `void failure(int code)`  L577 @Override
- `void success()`  L581 @Override
- `void updateCacheThumbInfo(final String localPath, final Bitmap bitmap)`  L587
- `void run()`  L594 @Override
- `void lambda$updateCacheThumbInfo$8(String str, Bitmap bitmap)`  L601
- `void updateThumbInfo(final String localPath)`  L619
- `void run()`  L626 @Override
- `void lambda$updateThumbInfo$9(String str)`  L633
- `boolean onTouchEvent(MotionEvent event)`  L654 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L662 @Override
- `void disconnect()`  L672 @Override
- `void failure(int code)`  L678 @Override
- `void success()`  L682 @Override
    - 体内字面量："yunqi_debug" · "onActivityResult: delete failure" · "yunqi_debug" · "onActivityResult: download task finish" · "dlgType"
- `void lambda$onActivityResult$10()`  L712
- `void processDownloadOption(Bundle MarsBuddle)`  L716
    - 体内字面量："Option"
- `void processDeleteConfirm(Bundle MarsBuddle)`  L720
    - 体内字面量："oprateType" · "yunqi_debug" · "processDeleteConfirm: deletePath: "
- `void processPopupForWin(Bundle MarsBuddle)`  L733
- `void showMenu()`  L762
- `void addData()`  L768
- `void failure(int code)`  L776 @Override
- `void success()`  L780 @Override
- `void onMessageEvent(MessageEvent MessageEvent)`  L786 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："yunqi_debug" · "onMessageEvent: download finish"
### `com.gku.actioncam.amba.ui.playback.AmbaPlaybackPresenter`
L32 · [class] public AmbaPlaybackPresenter · implements `IChannelListener` · `com/gku/actioncam/amba/ui/playback/AmbaPlaybackPresenter.java`

字段/常量（23）：
- `int GET_FILE_INFO_LIST_END_HANDLER_WHAT = 10211`  L33
- `int GET_FILE_INFO_LIST_START_HANDLER_WHAT = 10210`  L34
- `AmbaDataModel ambaDataModel`  L35
- `AmbaPlaybackActivity ambaPlaybackActivity`  L36
- `LruCache<String, Bitmap> bitmapLruCache`  L37
- `boolean isDetectSDMount = false`  L38
- `int downloadCount = 0`  L40
- `int pathId = 0`  L41
- `int i = msg.what`  L46
- `int fileInfoLoopSize = 25`  L66
- `boolean isFileListLoading = false`  L67
- `int fileListLoopSize = 20`  L70 @Deprecated
- `int i4 = this.pathId`  L232
- `AmbaPlaybackActivity ambaPlaybackActivity = this.ambaPlaybackActivity`  L259
- `AmbaPlaybackActivity ambaPlaybackActivity2 = this.ambaPlaybackActivity`  L275
- `AmbaPlaybackPresenter ambaPlaybackPresenter = AmbaPlaybackPresenter.this`  L311
- `AmbaPlaybackActivity ambaPlaybackActivity = this.ambaPlaybackActivity`  L351
- `int i = end - start`  L357
- `boolean z = i > 25`  L363
- `int i = end - start`  L382
- `boolean z = i > 20`  L388
- `String str`  L416
- `LruCache<String, Bitmap> lruCache = this.bitmapLruCache`  L489

方法（49）：
- `void handleMessage(Message msg)`  L44 @Override
- `public AmbaPlaybackPresenter(AmbaPlaybackActivity ambaPlaybackActivity)`  L73
- `void failure(int code)`  L83 @Override
- `void success()`  L87 @Override
- `void onChannelEvent(int type, Object param, String... array)`  L93 @Override
- `void success()`  L97 @Override
- `void failure(int code)`  L101 @Override
    - 体内字面量："yunqi_debug" · "failure: get thumb failure"
- `void run()`  L111 @Override
- `void failure(int code)`  L130 @Override
- `void success()`  L134 @Override
    - 体内字面量："yunqi_debug" · "onChannelEvent: DATA_CHANNEL_EVENT_GET_FINISH:"
- `void failure(int code)`  L152 @Override
- `void success()`  L156 @Override
    - 体内字面量："yunqi_debug" · "onChannelEvent: count: "
- `void run()`  L177 @Override
    - 体内字面量："yunqi_debug" · "onChannelEvent: delete a file" · "yunqi_debug" · "onChannelEvent: GetFileInfo: " · "yunqi_debug" · "onChannelEvent: delete all type file" · "fileName" · "fileCreateTime" · "fileTimeLong" · "fileSize"
- `void lambda$onChannelEvent$0()`  L248
- `void sdStateListen(SyncStateMessageStr syncStateMessageStr)`  L253
- `void failure(int code)`  L264 @Override
- `void success()`  L268 @Override
- `void downloadArrayTopFile(ArrayList<String> params, AmbaRequestCallback ambaRequestCallback)`  L285
- `void clearDownloadArray()`  L298 @Deprecated
- `void downloadThumb(final ArrayList<String> params, final AmbaRequestCallback ambaRequestCallback)`  L303
- `void success()`  L309 @Override
- `void failure(int code)`  L317 @Override
- `void getFileAsync(String dtsPath, long size, AmbaRequestCallback ambaRequestCallback)`  L323
- `void disconnect()`  L331
- `boolean isStorageEnough(long allFileSize)`  L335
- `void run()`  L339 @Override
- `void lambda$isStorageEnough$1(boolean z)`  L347
- `void selfGetFileInfoList(final int start, final int end)`  L356
- `void success()`  L366 @Override
    - 体内字面量："yunqi_debug" · "onSuccess: getFileInfoList"
- `void failure(int code)`  L372 @Override
    - 体内字面量："yunqi_debug" · "onFailure: getFileInfoList"
- `void selfGetFileList(final int start, final int end)`  L381 @Deprecated
- `void success()`  L391 @Override
    - 体内字面量："yunqi_debug" · "onSuccess: getFileList"
- `void failure(int code)`  L397 @Override
    - 体内字面量："yunqi_debug" · "onFailure: getFileList"
- `void pullRemoteList(AmbaRequestCallback ambaRequestCallback)`  L403
- `void getFileCount(AmbaRequestCallback ambaRequestCallback)`  L411
- `void prepareDownloadThumb(String dtsPath, AmbaRequestCallback ambaRequestCallback)`  L415
- `void setClientInfo(AmbaRequestCallback ambaRequestCallback)`  L431
- `void getFileInfoList(int start, int end, AmbaRequestCallback ambaRequestCallback)`  L435
- `throw new Exception( 36 )`  L441
- `void getFileList(int start, int end, AmbaRequestCallback ambaRequestCallback)`  L448
- `void getFileInfo(String path, AmbaRequestCallback ambaRequestCallback)`  L456
- `void dumpToShow(int shareType, HiDefine.PathConnection pathConnection)`  L464
- `void remoteVideoPage(HiDefine.PathConnection pathConnection)`  L472
    - 体内字面量："MP4"
- `void remoteImagePage(HiDefine.PathConnection pathConnection)`  L480
    - 体内字面量："JPG"
- `void initBitmapCache()`  L488
- `int sizeOf(String key, Bitmap value)`  L496 @Override
- `void addBitmapCache(String key, Bitmap bitmap)`  L503
    - 体内字面量："yunqi_debug" · "addBitmapCache: "
- `void removeBitmapCache(String key)`  L510
    - 体内字面量："yunqi_debug" · "removeBitmapCache: "
- `Bitmap getBitmapFromCache(String key)`  L518
    - 体内字面量："yunqi_debug" · "getBitmapFromCache: "
### `com.gku.actioncam.amba.ui.playback.AmbaPlaybackUtil`
L39 · [class] public AmbaPlaybackUtil · `com/gku/actioncam/amba/ui/playback/AmbaPlaybackUtil.java`

字段/常量（6）：
- `String TAG = "AmbaPlaybackUtil"`  L40
- `String str = G.localAppDataPath + "/cache/" + currentSSID + "/"`  L77
- `String strReplace`  L128
- `Bitmap bitmapDecodeStream = null`  L144
- `Bitmap bitmapDecodeStream = null`  L165
- `String str = pathConnection.strPath`  L235

方法（36）：
- `String getWiFiIpAddress()`  L43
    - 体内字面量："wifi"
- `String intIPToIp(int ip)`  L52
- `String localAmbaPathExchangeRemote_dcf(String localPath)`  L56
    - 体内字面量："/" · "/tmp/SD0/DCIM/%s/%s" · "/"
- `String remotePathExchangeLocal(String remotePath)`  L61
    - 体内字面量："/" · "remotePathExchangeLocal: " · "/" · "/"
- `String remotePathExchangeLocalCache(String remotePath)`  L71 @Deprecated
    - 体内字面量："/"
- `String remotePathExchangeLocalCache_dcf(String remotePath)`  L88
    - 体内字面量："/" · "/" · "%s/%s/%s" · "MEDIA" · "remotePathExchangeLocalCache_new: finalPath: " · "/MEDIA"
- `String getCachePath()`  L104
    - 体内字面量："mounted"
- `void deleteFile(String path)`  L112 @Deprecated
    - 体内字面量："deleteUndoneFile: delete success"
- `String getCurrentSSID()`  L119
    - 体内字面量："wifi" · "\""
- `boolean isFileDownload(String localPath)`  L127
- `Bitmap decodeLocalFileToBitmap(String imagePath)`  L142
- `Bitmap decodeSampledBitmapFromResource(Context context, String imagePath)`  L163
- `void cleanCacheFile()`  L183
- `void run()`  L186 @Override
- `void lambda$cleanCacheFile$0()`  L192
    - 体内字面量："/" · "/" · "cleanCacheFile: "
- `void deleteLocalFile(final String localPath)`  L208
- `void run()`  L214 @Override
- `void lambda$deleteLocalFile$1(String str)`  L220
- `String strSSID(Context context)`  L227
- `void showFileInfoDialogPrepare(Context context, HiDefine.PathConnection pathConnection)`  L231
- `String formatDialogSize(Context context, long size)`  L248
    - 体内字面量：" B" · " KB" · " MB" · " GB"
- `void selectDownloadType(final IjkBaseActivity ijkBaseActivity, final ArrayList<String> params)`  L264
- `void onClick(View view)`  L279 @Override
- `void onClick(View view)`  L285 @Override
- `void onClick(View view)`  L291 @Override
- `void lambda$selectDownloadType$2(RadioButton radioButton, RadioButton radioButton2, View view)`  L298
- `void lambda$selectDownloadType$3(RadioButton radioButton, RadioButton radioButton2, View view)`  L303
- `void lambda$selectDownloadType$4(IjkBaseActivity ijkBaseActivity, ArrayList arrayList, RadioButton radioButton, AlertDialog alertDialog, View view)`  L308
- `void dumpToDownload(IjkBaseActivity ijkBaseActivity, ArrayList<String> file_list, boolean isHigh)`  L313
- `void dumpToDelete(IjkBaseActivity ijkBaseActivity, ArrayList<String> file_list, int deleteType)`  L321
- `void showRenameDialog(Activity activity, int sameFileCount)`  L328
    - 体内字面量："SameFileCount"
- `boolean externalMemoryAvailable()`  L334
    - 体内字面量："mounted"
- `long getAvailableExternalMemorySize()`  L338
- `long getTotalExternalMemorySize()`  L346
- `boolean isEnoughStorage(long allFileSize)`  L354
- `void backPreviewActivity(Context context)`  L358
### `com.gku.actioncam.amba.ui.playback.remote.photo.AmbaRemotePhotoActivity`
L29 · [class] public AmbaRemotePhotoActivity · extends `IjkBaseActivity implements View.OnClickListener` · implements `View.OnClickListener` · `com/gku/actioncam/amba/ui/playback/remote/photo/AmbaRemotePhotoActivity.java`

字段/常量（20）：
- `String AMBA_CONTROL_PHOTO_PARAM = "amba_control_photo_param"`  L30
- `int i = msg.what`  L35
- `AmbaRemotePhotoPresenter ambaRemotePhotoPresenter`  L38
- `SwitchImageView amba_remote_photo_image`  L39
- `TextView ibprogress`  L40
- `ImageView ivModeMenu`  L41
- `LinearLayout lineDelete`  L42
- `LinearLayout lineDownload`  L43
- `LinearLayout lineFileInfo`  L44
- `LinearLayout lineShare`  L45
- `HiDefine.PathConnection pathConnection`  L46
- `PopupWindow preViewMenuWin`  L47
- `PopupWindow toolbarWindow`  L48
- `View vTopView`  L49
- `int WHAT_UPDATE_HD_IMAGE = 1170`  L50
- `View ivBack = null`  L51
- `Bitmap bitmap`  L55
- `PopupWindow popupWindow = this.toolbarWindow`  L134
- `PopupWindow popupWindow = this.preViewMenuWin`  L155
- `AmbaRemotePhotoActivity ambaRemotePhotoActivity = AmbaRemotePhotoActivity.this`  L282

方法（31）：
- `void handleMessage(Message msg)`  L33 @Override
- `void handleMessage(Message msg)`  L54 @Override
- `void handleMessage(Message msg)`  L66 @Override
- `void onCreate(Bundle savedInstanceState)`  L76 @Override
- `void onRestart()`  L83 @Override
- `void disconnect()`  L88 @Override
- `void lambda$onRestart$0()`  L95
- `void isShowProgressText(final boolean isShow)`  L99
- `void run()`  L105 @Override
- `void lambda$isShowProgressText$1(boolean z)`  L112
- `void setProgressText(final int progress)`  L116
- `void run()`  L122 @Override
- `void lambda$setProgressText$2(int i)`  L129
    - 体内字面量："%"
- `void showOrDismissToolbar()`  L133
- `void showMenu()`  L146
- `void dismissMenu()`  L154
- `void initView()`  L161
- `void onClick(View view)`  L176 @Override
- `void onClick(View view)`  L182 @Override
- `void lambda$initView$3(View view)`  L203
- `void lambda$initView$4(View view)`  L208
- `void onClick(View v)`  L213 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L234 @Override
    - 体内字面量："yunqi_debug" · "onActivityResult: download task finish" · "yunqi_debug" · "onActivityResult: delete success" · "yunqi_debug" · "onActivityResult: delete failure"
- `void addData()`  L248
- `void disconnect()`  L252 @Override
- `void onCancel(DialogInterface dialogInterface)`  L266 @Override
- `void success()`  L277 @Override
- `void failure(int code)`  L281 @Override
- `void lambda$addData$5()`  L290
- `void lambda$addData$6(DialogInterface dialogInterface)`  L295
- `void showHDImage(Bitmap bitmap)`  L299
### `com.gku.actioncam.amba.ui.playback.remote.photo.AmbaRemotePhotoPresenter`
L14 · [class] public AmbaRemotePhotoPresenter · implements `IChannelListener` · `com/gku/actioncam/amba/ui/playback/remote/photo/AmbaRemotePhotoPresenter.java`

字段/常量（4）：
- `AmbaDataModel ambaDataModel`  L16
- `AmbaRemotePhotoActivity ambaRemotePhotoActivity`  L17
- `String str = array[0]`  L59
- `AmbaRemotePhotoActivity ambaRemotePhotoActivity = this.ambaRemotePhotoActivity`  L84

方法（11）：
- `public AmbaRemotePhotoPresenter(AmbaRemotePhotoActivity ambaRemotePhotoActivity)`  L19
- `void failure(int code)`  L29 @Override
- `void success()`  L33 @Override
- `void downloadFile(final String filePath, final AmbaRequestCallback ambaRequestCallback)`  L38
- `void success()`  L41 @Override
- `void failure(int code)`  L46 @Override
- `void disconnect()`  L52
- `void onChannelEvent(int type, Object param, String... array)`  L57 @Override
- `void prepareDownloadFile(String filePath, AmbaRequestCallback ambaRequestCallback)`  L99
- `void prepareDownloadThumb(String path, String type, AmbaRequestCallback ambaRequestCallback)`  L103
- `void getFileAsync(String dtsPath, long size)`  L107
### `com.gku.actioncam.amba.ui.playback.remote.video.AmbaRemoteVideoActivity`
L24 · [class] public AmbaRemoteVideoActivity · extends `IjkBaseActivity implements IMediaPlayer.OnPreparedListener, View.OnClickListener` · implements `IMediaPlayer.OnPreparedListener, View.OnClickListener` · `com/gku/actioncam/amba/ui/playback/remote/video/AmbaRemoteVideoActivity.java`

字段/常量（15）：
- `String AMBA_CONTROL_VIDEO_PARAM = "amba_control_video_param"`  L25
- `AmbaRemoteVideoPresenter ambaRemoteVideoPresenter`  L26
- `VideoView amba_control_video`  L27
- `View ivBack = null`  L28
- `ImageView ivModeMenu`  L29
- `LinearLayout lineDelete`  L30
- `LinearLayout lineDownload`  L31
- `LinearLayout lineFileInfo`  L32
- `LinearLayout lineShare`  L33
- `HiDefine.PathConnection pathConnection`  L34
- `PopupWindow preViewMenuWin`  L35
- `PopupWindow toolbarWindow`  L36
- `View vTopView`  L37
- `PopupWindow popupWindow = this.toolbarWindow`  L64
- `PopupWindow popupWindow = this.preViewMenuWin`  L85

方法（21）：
- `void onCreate(Bundle savedInstanceState)`  L40 @Override
- `void onRestart()`  L47 @Override
- `void disconnect()`  L52 @Override
- `void lambda$onRestart$0()`  L59
- `void showOrDismissToolbar()`  L63
- `void showMenu()`  L76
- `void dismissMenu()`  L84
- `void initView()`  L91
- `void onClick(View view)`  L102 @Override
- `void onClick(View view)`  L108 @Override
- `void lambda$initView$1(View view)`  L129
- `void lambda$initView$2(View view)`  L134
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L139 @Override
    - 体内字面量："yunqi_debug" · "onActivityResult: download task finish" · "yunqi_debug" · "onActivityResult: delete success" · "yunqi_debug" · "onActivityResult: delete failure"
- `void onClick(View v)`  L154 @Override
- `String formatPath(String path)`  L168
    - 体内字面量："/tmp/SD0"
- `void initIjkVideo()`  L172
    - 体内字面量："http://%s%s" · "libijkplayer.so" · "yunqi_debug" · "initIjkVideo: remote video: "
- `void onDestroy()`  L189 @Override
- `void addData()`  L194
- `void disconnect()`  L198 @Override
- `void lambda$addData$3()`  L205
- `void onPrepared(IMediaPlayer iMediaPlayer)`  L210 @Override
    - 体内字面量："yunqi_debug" · "onPrepared: " · "yunqi_debug" · "canSeekForward: " · "yunqi_debug" · "canSeekBackward: "
### `com.gku.actioncam.amba.ui.playback.remote.video.AmbaRemoteVideoPresenter`
L9 · [class] public AmbaRemoteVideoPresenter · implements `IChannelListener` · `com/gku/actioncam/amba/ui/playback/remote/video/AmbaRemoteVideoPresenter.java`

字段/常量（2）：
- `AmbaRemoteVideoActivity ambaRemoteVideoActivity`  L11
- `SyncStateMessageStr syncStateMessageStr`  L19

方法（3）：
- `public AmbaRemoteVideoPresenter(AmbaRemoteVideoActivity ambaRemoteVideoActivity)`  L13
- `void onChannelEvent(int type, Object param, String... array)`  L18 @Override
- `void disconnect()`  L28
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity`
L45 · [class] public AmbaPreviewActivity · extends `IjkBaseActivity` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java`

字段/常量（60）：
- `String AMBA_PREVIEW_DATE = "amba_preview_save_date"`  L46
- `int HIDE_MAIN_ICON = 12101110`  L47
- `int SHOW_MAIN_ICON = 12101112`  L48
- `String TAG = "AmbaPreviewActivity"`  L49
- `AmbaPreviewDate ambaPreviewDate`  L50
- `AmbaPreviewPresenter ambaPreviewPresenter`  L51
- `AmbaPreviewDate.BatteryState batteryState`  L52
- `String fastSettingText`  L53
- `PopupWindow fastSettingWindow`  L54
- `VideoView ijkplayer_video`  L55
- `ImageView ivBatteryCapacity`  L56
- `ImageView ivBrowseFile`  L57
- `ImageView ivCaptureType`  L58
- `ImageView ivCommand`  L59
- `int ivCommandRes`  L60
- `ImageView ivLoopRecording`  L61
- `ImageView ivModeMenu`  L62
- `ImageView ivRecordSign`  L63
- `ImageView ivSettings`  L64
- `ImageView ivWifiSignal`  L65
- `LinearLayout layoutInfoBar`  L66
- `RelativeLayout layoutSetCapture`  L67
- `View layoutSetMode`  L68
- `FrameLayout main_base_preview`  L69
- `ImageView main_top_logo`  L70
- `int modeRes`  L71
- `ProgressBar pbStorageUsageVolume`  L72
- `RecordCountDownTimer recordCountDownTimer`  L73
- `String resolutionString`  L74
- `AmbaPreviewDate.SDState sdState`  L75
- `TextView shortVideoAddTime`  L76
- `TextView shortVideoCountdown`  L77
- `ImageView startSlowStartStopRec`  L78
- `Timer timer`  L79
- `TextView tvCaptureInfo`  L80
- `TextView tvPrompt`  L81
- `TextView tvRecordTime`  L82
- `TextView tvResolution`  L83
- `TextView tvStorageAvailable`  L84
- `WifiManager wifiManager`  L85
- `WifiSignalReceiver wifiSignalReceiver`  L86
- `int i = msg.what`  L91
- `int quickStoriesCountTime = 0`  L127
- `RelativeLayout layoutFragLand = null`  L128
- `RelativeLayout layoutFragPort = null`  L129
- `boolean isInitIjkplayer = false`  L130
- `int i = this.quickStoriesCountTime`  L281
- `Timer timer = this.timer`  L308
- `int i = CameraParameters.CURRENT_APP_TYPE`  L401
- `int i2 = CameraParameters.APP_KBX`  L402
- `String str = Common.WORK_MODE_NOMAL_VIDEO`  L752
- `String str2 = "NormalPhoto"`  L774
- `PopupWindow popupWindow = this.fastSettingWindow`  L843
- `RelativeLayout relativeLayout = this.layoutSetCapture`  L844
- `RecordCountDownTimer recordCountDownTimer = this.recordCountDownTimer`  L895
- `RecordCountDownTimer recordCountDownTimer = this.recordCountDownTimer`  L905
- `VideoView videoView = this.ijkplayer_video`  L982
- `AmbaPreviewDate ambaPreviewDate`  L992
- `AmbaPreviewDate ambaPreviewDate`  L1025
- `WifiSignalReceiver wifiSignalReceiver = this.wifiSignalReceiver`  L1245

方法（119）：
- `void handleMessage(Message msg)`  L89 @Override
- `void showMainIcon()`  L132
- `void hideMainIcon()`  L137
- `AmbaPreviewPresenter getAmbaPreviewPresenter()`  L142
- `View getLayoutSetMode()`  L146
- `void onCreate(Bundle savedInstanceState)`  L151 @Override
    - 体内字面量："onCreate"
- `void uiForRecordState(final boolean isRecording)`  L167
- `void run()`  L170 @Override
- `void lambda$uiForRecordState$0(boolean z)`  L177
- `void uiForPhotoTimingState(final boolean isTiming)`  L186
- `void run()`  L189 @Override
- `void updateCommandIcon(String mode, boolean isRecording)`  L196
- `void showRecordCDViews()`  L204
    - 体内字面量："yunqi_debug" · "showRecordCDViews: "
- `void dismissRecordCDViews()`  L216
    - 体内字面量："yunqi_debug" · "dismissRecordCDViews: " · "00:00:00"
- `void updateCDTimer(String time)`  L225
    - 体内字面量："yunqi_debug" · "updateCDTimer: "
- `void hideSdStateUI()`  L233
- `void updateSdStateUI(String sdState, String sdFreeSpace, String sdTotalSpace)`  L238
    - 体内字面量："%.1fG/%.1fG"
- `void updateBatteryStateUI(final String capacity, final String charge, final String ac)`  L256
- `void run()`  L259 @Override
- `void lambda$updateBatteryStateUI$1(String str, String str2, String str3)`  L266
- `void quickStoriesCountDown()`  L280
- `void run()`  L291 @Override
- `void run()`  L294 @Override
    - 体内字面量："s" · "yunqi_debug" · "Quick Stories cancel"
- `void cancelQSCountDown()`  L307
- `void showQuickStoriesUI()`  L315
- `void run()`  L318 @Override
- `void lambda$showQuickStoriesUI$2()`  L325
- `void dismissQuickStoriesUI()`  L332
- `void run()`  L335 @Override
- `void lambda$dismissQuickStoriesUI$3()`  L342
- `void findLocalViews()`  L347
- `void findIncludeViews(RelativeLayout layout)`  L356
- `int selectMainTopLogo()`  L379
- `void initView(Bundle savedInstanceState)`  L406
- `void onClick(View view)`  L426 @Override
- `void onClick(View view)`  L432 @Override
- `void onClick(View view)`  L438 @Override
- `void onClick(View view)`  L444 @Override
- `void onClick(View view)`  L450 @Override
- `void onClick(View view)`  L456 @Override
- `void onClick(View view)`  L462 @Override
- `void lambda$initView$4(View view)`  L470
- `void failure(int code)`  L475 @Override
- `void success()`  L479 @Override
- `void lambda$initView$5(View view)`  L485
- `void failure(int code)`  L488 @Override
- `void success()`  L492 @Override
- `void lambda$initView$6(View view)`  L498
- `void lambda$initView$7(View view)`  L506
- `void lambda$initView$8(View view)`  L515
- `void lambda$initView$9(View view)`  L520
    - 体内字面量："yunqi_debug" · "ivCommand: " · "current mode: %s, current status:%s/%s"
- `void success()`  L530 @Override
    - 体内字面量："yunqi_debug" · "onSuccess: take photo"
- `void failure(int code)`  L541 @Override
    - 体内字面量："yunqi_debug" · "onFailure: take photo"
- `void success()`  L552 @Override
    - 体内字面量："yunqi_debug" · "onSuccess: stop record"
- `void failure(int code)`  L558 @Override
    - 体内字面量："yunqi_debug" · "onFailure: stop record"
- `void success()`  L567 @Override
    - 体内字面量："yunqi_debug" · "onSuccess: start record"
- `void failure(int code)`  L573 @Override
    - 体内字面量："yunqi_debug" · "onFailure: start record" · "yunqi_debug" · "ivCommand: else"
- `void lambda$initView$10(View view)`  L586
- `void showQShortAddTimeTextAutoDismiss()`  L594
- `void run()`  L600 @Override
- `void lambda$showQShortAddTimeTextAutoDismiss$12()`  L607
- `void run()`  L611 @Override
- `void lambda$showQShortAddTimeTextAutoDismiss$11()`  L618
- `void setQSAddTimeButtonVisibility(final boolean isShow)`  L622
    - 体内字面量："yunqi_debug" · "setQSAddTimeButtonVisibility: isShow"
- `void run()`  L629 @Override
- `void lambda$setQSAddTimeButtonVisibility$13(boolean z)`  L636
- `void contentTips(final String msg)`  L644
    - 体内字面量："å®æ¶æç§æç¤º" · "å®æ¶æç§å¼å§" · "å®æ¶æç§æç¤º" · "å®æ¶æç§ç»æ"
- `void run()`  L655 @Override
- `void lambda$contentTips$14(String str)`  L662
- `void hideContentTips()`  L667
- `void run()`  L673 @Override
- `void lambda$hideContentTips$15()`  L680
- `void updateCaptureInfoText(String captureInfo)`  L684
- `void run()`  L691 @Override
- `void lambda$updateCaptureInfoText$16()`  L698
- `void updateUIForModeChange()`  L702
- `void run()`  L705 @Override
- `void lambda$updateUIForModeChange$17()`  L712
    - 体内字面量："ic_image_" · "drawable"
- `void timeLapseVideoUI(final boolean isShow)`  L728
- `void run()`  L734 @Override
- `void lambda$timeLapseVideoUI$18(boolean z)`  L741
- `String modeExchange(String mode)`  L751
- `void showFastSettingPopupWindow(final String[] allItem, final String currentItem)`  L808
- `void run()`  L812 @Override
- `void run()`  L819 @Override
- `void lambda$showFastSettingPopupWindow$19()`  L828
- `void lambda$showFastSettingPopupWindow$20(String[] strArr, String str)`  L833
- `void onDismiss()`  L838 @Override
    - 体内字面量："showFastSettingPopupWindow: jsdhfygsdyufgsduifkj"
- `void onStart()`  L852 @Override
- `void onStop()`  L857 @Override
- `void onDestroy()`  L863 @Override
- `void setResolutionText(final String resolution)`  L871
- `void run()`  L877 @Override
- `void lambda$setResolutionText$21(String str)`  L884
- `void showRecordCDTime(int time)`  L888
- `void run()`  L891 @Override
- `void dismissRecordCDTime()`  L904
- `void run()`  L912 @Override
- `void initIjkVideoView()`  L952
    - 体内字面量："yunqi_debug" · "initIjkVideoView: " · "libijkplayer.so"
- `void run()`  L964 @Override
- `void lambda$initIjkVideoView$22()`  L971
    - 体内字面量："rtsp://%s:554/livestream/12" · "192.168.0.1" · "yunqi_debug" · "initIjkVideoView: rtspPath: "
- `void destroyVideoView()`  L979
    - 体内字面量："yunqi_debug" · "destroyVideoView: "
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L991 @Override
- `void failure(int code)`  L1000 @Override
- `void success()`  L1004 @Override
    - 体内字面量："onActivityResult saveDate is null"
- `AmbaPreviewDate getAmbaPreviewDate()`  L1012
- `void onSaveInstanceState(Bundle outState)`  L1019 @Override
- `void addData(Bundle savedInstanceState)`  L1024
- `void run()`  L1029 @Override
    - 体内字面量："yunqi_debug" · "ambaPreviewDate: "
- `void disconnect()`  L1040 @Override
- `void lambda$addData$24(AmbaPreviewDate ambaPreviewDate)`  L1048
- `void disconnect()`  L1070 @Override
- `void lambda$addData$23()`  L1079
- `void lambda$addData$25()`  L1084
    - 体内字面量："yunqi_debug" · "addData: disconnect"
- `void onResume()`  L1227 @Override
    - 体内字面量："android.net.wifi.RSSI_CHANGED" · "android.net.wifi.STATE_CHANGE" · "wifi"
- `void onPause()`  L1243 @Override
- `void updateWifiRssiUI(WifiManager wifiManager)`  L1267
- `void run()`  L1274 @Override
- `void lambda$updateWifiRssiUI$26(int i)`  L1281
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity$AnonymousClass12`
L1090 · [class] AnonymousClass12 · extends `AmbaRequestCallback` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java`

字段/常量（1）：
- `AmbaPreviewActivity ambaPreviewActivity = AmbaPreviewActivity.this`  L1221

方法（2）：
- `void success()`  L1214 @Override
    - 体内字面量："yunqi_debug" · "success: startSession"
- `void failure(int code)`  L1220 @Override
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity$AnonymousClass12$AnonymousClass1`
L1095 · [class] AnonymousClass1 · extends `AmbaRequestCallback` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java`

方法（2）：
- `void success()`  L1202 @Override
    - 体内字面量："yunqi_debug" · "success: getAllWorkMode"
- `void failure(int code)`  L1208 @Override
    - 体内字面量："getAllWorkMode error"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity$AnonymousClass12$AnonymousClass1$C00561`
L1100 · [class] C00561 · extends `AmbaRequestCallback` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java`

方法（2）：
- `void success()`  L1190 @Override
    - 体内字面量："yunqi_debug" · "success: getCurWorkMode"
- `void failure(int code)`  L1196 @Override
    - 体内字面量："getCurWorkMode error"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity$AnonymousClass12$AnonymousClass1$C00561$C00571`
L1105 · [class] C00571 · extends `AmbaRequestCallback` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java`

方法（2）：
- `void success()`  L1110 @Override
    - 体内字面量："yunqi_debug" · "success: getSystemWorkState"
- `void failure(int code)`  L1184 @Override
    - 体内字面量："getSystemWorkState error"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity$AnonymousClass12$AnonymousClass1$C00561$C00571$C00581`
L1116 · [class] C00581 · extends `AmbaRequestCallback` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java`

方法（2）：
- `void success()`  L1121 @Override
    - 体内字面量："yunqi_debug" · "success: getResolutionSecondMenuItem"
- `void failure(int code)`  L1178 @Override
    - 体内字面量："getResolutionSecondMenuItem error"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity$AnonymousClass12$AnonymousClass1$C00561$C00571$C00581$C00591`
L1127 · [class] C00591 · extends `AmbaRequestCallback` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java`

方法（8）：
- `void success()`  L1132 @Override
- `void success()`  L1135 @Override
- `void success()`  L1139 @Override
    - 体内字面量："yunqi_debug" · "success: getCurrentModeSecondMenuItem"
- `void failure(int code)`  L1145 @Override
    - 体内字面量："getResolutionSecondMenuItem error"
- `void failure(int code)`  L1154 @Override
- `void success()`  L1158 @Override
    - 体内字面量："setsystemtime:success"
- `void failure(int code)`  L1165 @Override
    - 体内字面量："getSdState"
- `void failure(int code)`  L1172 @Override
    - 体内字面量："getBatteryInfo"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity$RecordCountDownTimer`
L918 · [class] RecordCountDownTimer · extends `CountDownTimer` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java`

字段/常量（3）：
- `int time`  L919
- `AmbaPreviewActivity ambaPreviewActivity = AmbaPreviewActivity.this`  L929
- `int i = this.time - 1`  L933

方法（3）：
- `public RecordCountDownTimer(int time)`  L921
    - 体内字面量："yunqi_debug" · "RecordCountDownTimer: init record count down time"
- `void onTick(long millisUntilFinished)`  L928 @Override
- `void onFinish()`  L946 @Override
    - 体内字面量："yunqi_debug" · "onFinish: finish"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity$WifiSignalReceiver`
L1252 · [class] private WifiSignalReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java`

字段/常量（1）：
- `AmbaPreviewActivity ambaPreviewActivity = AmbaPreviewActivity.this`  L1262

方法（2）：
- `private WifiSignalReceiver()`  L1253
- `void onReceive(Context context, Intent intent)`  L1257 @Override
    - 体内字面量："android.net.wifi.RSSI_CHANGED"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewDate`
L7 · [class] public AmbaPreviewDate · implements `Parcelable` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewDate.java`

字段/常量（7）：
- `BatteryState batteryState`  L21
- `String fastSettingText`  L22
- `int ivCommandRes`  L23
- `String mode`  L24
- `int modeRes`  L25
- `String resolutionString`  L26
- `SDState sdState`  L27

方法（16）：
- `AmbaPreviewDate createFromParcel(Parcel in)`  L11 @Override
- `AmbaPreviewDate[] newArray(int size)`  L17 @Override
- `int describeContents()`  L30 @Override
- `public AmbaPreviewDate(String mode, int ivCommandRes, String resolutionString, int modeRes, String fastSettingText, SDState sdState, BatteryState batteryState)`  L34
- `protected AmbaPreviewDate(Parcel in)`  L44
- `void writeToParcel(Parcel dest, int flags)`  L55 @Override
- `String getMode()`  L65
- `int getIvCommandRes()`  L69
- `String getResolutionString()`  L73
- `void setResolutionString(String resolutionString)`  L77
- `int getModeRes()`  L81
- `String getFastSettingText()`  L85
- `void setFastSettingText(String fastSettingText)`  L89
- `SDState getSdState()`  L93
- `BatteryState getBatteryState()`  L97
- `String toString()`  L219
    - 体内字面量："AmbaPreviewDate{mode='" · "', ivCommandRes=" · ", resolutionString='" · "', modeRes=" · ", fastSettingText='" · "', sdState=" · ", batteryState=" · "}"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewDate$BatteryState`
L160 · [class] public static BatteryState · implements `Parcelable` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewDate.java`

字段/常量（3）：
- `String ac`  L174
- `String capacity`  L175
- `String charge`  L176

方法（10）：
- `BatteryState createFromParcel(Parcel in)`  L164 @Override
- `BatteryState[] newArray(int size)`  L170 @Override
- `int describeContents()`  L179 @Override
- `public BatteryState(String capacity, String charge, String ac)`  L183
- `protected BatteryState(Parcel in)`  L189
- `String getCapacity()`  L195
- `String getCharge()`  L199
- `String getAc()`  L203
- `void writeToParcel(Parcel dest, int flags)`  L208 @Override
- `String toString()`  L214
    - 体内字面量："BatteryState{capacity='" · "', charge='" · "', ac='" · "'}"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewDate$SDState`
L101 · [class] public static SDState · implements `Parcelable` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewDate.java`

字段/常量（3）：
- `String sdFreeSpace`  L115
- `String sdStatus`  L116
- `String sdTotalSpace`  L117

方法（10）：
- `SDState createFromParcel(Parcel in)`  L105 @Override
- `SDState[] newArray(int size)`  L111 @Override
- `int describeContents()`  L120 @Override
- `public SDState(String sdStatus, String sdFreeSpace, String sdTotalSpace)`  L124
- `protected SDState(Parcel in)`  L130
- `String getSdStatus()`  L136
- `String getSdFreeSpace()`  L140
- `String getSdTotalSpace()`  L144
- `void writeToParcel(Parcel dest, int flags)`  L149 @Override
- `String toString()`  L155
    - 体内字面量："SDState{sdStatus='" · "', sdFreeSpace='" · "', sdTotalSpace='" · "'}"
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewPopupWindowWorkMode`
L32 · [class] public AmbaPreviewPopupWindowWorkMode · extends `PopupWindow` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewPopupWindowWorkMode.java`

字段/常量（43）：
- `String TAG = "AmbaPreviewPopupWindowWorkMode"`  L33
- `CameraModelRecAdapter adapter`  L34
- `RelativeLayout circleRela1`  L35
- `RelativeLayout circleRela2`  L36
- `RelativeLayout circleRela3`  L37
- `Handler handler`  L38
- `ImageView[][] imageMarksNo`  L39
- `RecyclerView itemRecyclerView`  L40
- `ImageView ivCircleForMulti`  L41
- `ImageView ivCircleForPhoto`  L42
- `ImageView ivCircleForVideo`  L43
- `ArrayList<NewAppModelItem> list`  L44
- `AmbaPreviewActivity mActivity`  L45
- `Context mContext`  L46
- `View.OnClickListener masterModeListener`  L47
- `LinearLayout modeGroupMulti`  L48
- `LinearLayout modeGroupPhoto`  L49
- `LinearLayout modeGroupVideo`  L50
- `LinearLayout oldVersionLayout`  L51
- `LinearLayout slaveModeMultiBurst`  L52
- `LinearLayout slaveModeMultiContinuous`  L53
- `LinearLayout slaveModeMultiTimelapse`  L54
- `LinearLayout slaveModePhotoSingle`  L55
- `LinearLayout slaveModePhotoTimer`  L56
- `LinearLayout slaveModeQuickVideo`  L57
- `LinearLayout slaveModeVideoLoop`  L58
- `LinearLayout slaveModeVideoNormal`  L59
- `LinearLayout slaveModeVideoSlow`  L60
- `LinearLayout slaveModeVideoTimelapse`  L61
- `TextView tvMasterModeMulti`  L62
- `TextView tvMasterModePhoto`  L63
- `TextView tvMasterModeVideo`  L64
- `int i = msg.what`  L99
- `int i = msg.what`  L153
- `int i = workMode / 10`  L242
- `int i2 = workMode % 10`  L243
- `ImageView[][] imageViewArr = this.imageMarksNo`  L244
- `ImageView[] imageViewArr2 = imageViewArr[i]`  L246
- `int i = 0`  L255
- `int i2 = 0`  L260
- `int i3 = i == 0 ? i : 1`  L271
- `String str = "NormalPhoto"`  L334
- `String str = Common.WORK_MODE_NOMAL_VIDEO`  L360

方法（25）：
- `void hideAllMarker()`  L66
- `public AmbaPreviewPopupWindowWorkMode(Context context, int newMode, AmbaPreviewActivity activity)`  L69
- `void onClick(View view)`  L74 @Override
    - 体内字面量："12131" · "setUiByWorkMode:  --------tvMasterModePhoto--------  " · "12131" · "setUiByWorkMode:  --------tvMasterModeVideo--------  "
- `void handleMessage(Message msg)`  L97 @Override
- `void run()`  L103 @Override
    - 体内字面量："changemodelog" · "run:  -----------------    æ¨¡å¼åæ¢æå"
- `public AmbaPreviewPopupWindowWorkMode(Context context, String newMode, AmbaPreviewActivity activity)`  L123
- `void onClick(View view)`  L128 @Override
    - 体内字面量："12131" · "setUiByWorkMode:  --------tvMasterModePhoto--------  " · "12131" · "setUiByWorkMode:  --------tvMasterModeVideo--------  "
- `void handleMessage(Message msg)`  L151 @Override
- `void run()`  L157 @Override
    - 体内字面量："changemodelog" · "run:  -----------------    æ¨¡å¼åæ¢æå"
- `void initView()`  L177
- `void changeGroup(int masterMode)`  L185
- `void changeGroupStr(int a)`  L213
    - 体内字面量："12131" · "changeGroupStr:  ---------333--------   " · "12131" · "changeGroupStr:  ---------444--------   "
- `void setUiByWorkMode(int workMode)`  L240
- `void setUiByWorkMode(String workMode)`  L254
- `void onItemClick(View view, int position)`  L278 @Override
- `void success()`  L287 @Override
- `void failure(int code)`  L293 @Override
    - 体内字面量："yunqi_debug" · "Select model " · " failure"
- `void addVideoList(String CurrentModel)`  L304
    - 体内字面量："ic_image_" · "drawable" · "Video"
- `void replaceItemName(ArrayList<NewAppModelItem> list)`  L315
- `void addPhotoList(String CurrentModel)`  L322
    - 体内字面量："ic_image_" · "drawable" · "Photo"
- `String exchangePhotoModel(String ModelName)`  L333
- `String exchangeVideoModel(String ModelName)`  L359
- `void removeAllList()`  L395
- `void setListener()`  L399
- `void findViews(View content)`  L405
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewPresenter`
L37 · [class] public AmbaPreviewPresenter · implements `IChannelListener` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewPresenter.java`

字段/常量（38）：
- `String TAG = "AmbaPreviewPresenter"`  L38
- `int WORK_MODE_START = 20`  L39
- `int WORK_MODE_STOP = 21`  L40
- `PopupWindow allWorkModePopupWindow`  L41
- `AmbaPreviewActivity ambaPreviewActivity`  L42
- `SyncStateMessageStr qsMseeage`  L43
- `boolean isTakingPhoto = false`  L44
- `boolean isRecording = false`  L45
- `String currentFastParam = "<binary/metadata>"`  L46
- `boolean isFirstLoadingQS = true`  L47
- `int QS_CLICK_COUNT = 0`  L48
- `boolean isResolutionRequest = false`  L49
- `boolean isLayoutSetCaptureClick = false`  L50
- `String string`  L66
- `String str2 = array[0]`  L132
- `String str3 = array[0]`  L164
- `SyncStateMessageStr syncStateMessageStr = this.qsMseeage`  L179
- `String str4 = array[0]`  L195
- `String str5 = array[1]`  L196
- `String str6 = array[0]`  L215
- `String str7 = array[1]`  L216
- `String str8 = array[0]`  L237
- `String str9 = array[0]`  L246
- `String str10 = array[0]`  L258
- `String str11 = array[0]`  L298
- `String str12 = array[1]`  L299
- `String str13 = array[2]`  L300
- `String str14 = array[0]`  L306
- `String str15 = array[1]`  L307
- `String str16 = array[2]`  L308
- `String[] strArr = CameraParameters.VideoModel`  L468
- `String[] strArr = CameraParameters.PhotoModel`  L473
- `AmbaPreviewActivity ambaPreviewActivity = this.ambaPreviewActivity`  L545
- `AmbaPreviewActivity ambaPreviewActivity2 = this.ambaPreviewActivity`  L570
- `AmbaPreviewActivity ambaPreviewActivity3 = this.ambaPreviewActivity`  L576
- `AmbaPreviewActivity ambaPreviewActivity4 = this.ambaPreviewActivity`  L611
- `int i = time / 3600`  L658
- `int i2 = time % 3600`  L659

方法（65）：
- `void lambda$initAllWorkModePopupWindow$7()`  L53
- `public AmbaPreviewPresenter(AmbaPreviewActivity ambaPreviewActivity)`  L56
- `void disconnect()`  L60
- `void onChannelEvent(int type, Object param, String... array)`  L65 @Override
- `void run()`  L119 @Override
    - 体内字面量："yunqi_debug" · "run: QS_CLICK_COUNT: "
- `void run()`  L135 @Override
    - 体内字面量："onChannelEvent: errorType: "
- `void run()`  L154 @Override
- `void run()`  L184 @Override
- `void run()`  L273 @Override
    - 体内字面量："onChannelEvent: STOP_RECORD"
- `void run()`  L283 @Override
- `void run()`  L292 @Override
- `void run()`  L312 @Override
- `void run()`  L323 @Override
- `void lambda$onChannelEvent$0(String str)`  L335
- `void lambda$onChannelEvent$1(String str)`  L340
- `void lambda$onChannelEvent$2()`  L345
- `void lambda$onChannelEvent$3()`  L351
- `void lambda$onChannelEvent$5(String str, String str2, String str3)`  L357
- `void lambda$onChannelEvent$6(SyncStateMessageStr syncStateMessageStr)`  L362
- `void playTakePhotoSound()`  L370
    - 体内字面量："file:///system/media/audio/ui/camera_click.ogg"
- `void playStartRecordSound()`  L374
    - 体内字面量："file:///system/media/audio/ui/VideoRecord.ogg"
- `void playStopRecordSound()`  L378
    - 体内字面量："file:///system/media/audio/ui/VideoRecordEnd.ogg"
- `void playSound(String sound)`  L410
- `void updateFastSetting()`  L414
- `void failure(int code)`  L417 @Override
- `void success()`  L421 @Override
- `void failure(int code)`  L427 @Override
- `void success()`  L431 @Override
- `void dumpToWorkSettingActivity()`  L438
- `void dumpToPlaybackActivity()`  L445
- `void initAllWorkModePopupWindow()`  L451
- `void onDismiss()`  L456 @Override
- `boolean isContainMode(String work_mode)`  L463
- `boolean isVideoMode(String workMode)`  L467
- `boolean isPhotoMode(String workMode)`  L472
- `void lambda$onChannelEvent$4(final SyncStateMessageStr syncStateMessageStr)`  L478
    - 体内字面量："receiverRemoteUpdateUI: isRecording:" · "receiverRemoteUpdateUI: locked" · "receiverRemoteUpdateUI: full_sensor"
- `void run()`  L504 @Override
- `void lambda$receiverRemoteUpdateUI$10(SyncStateMessageStr syncStateMessageStr)`  L511
- `void run()`  L549 @Override
- `void failure(int code)`  L580 @Override
- `void success()`  L584 @Override
    - 体内字面量："yunqi_debug" · "receiverRemoteUpdateUI: state: " · "yunqi_debug" · "receiverRemoteUpdateUI: isTimingState: " · "yunqi_debug" · "receiverRemoteUpdateUI: éè"
- `void run()`  L623 @Override
- `void lambda$receiverRemoteUpdateUI$8()`  L632
- `void lambda$receiverRemoteUpdateUI$9()`  L637
- `int exchangeCurrentQSValue()`  L641
    - 体内字面量："30" · "25" · "20" · "15"
- `String time2String(int time)`  L657
- `String currentRequestParam()`  L663
    - 体内字面量："Time Lapse" · "Self-Timer" · "Number" · "Duration"
- `void startSession(AmbaRequestCallback ambaRequestCallback)`  L679
- `void getDeviceInfo(AmbaRequestCallback ambaRequestCallback)`  L683
- `void getAllWorkMode(AmbaRequestCallback ambaRequestCallback)`  L687
- `void getCurWorkMode(AmbaRequestCallback ambaRequestCallback)`  L691
- `void setCurWorkMode(String setCurMode, AmbaRequestCallback ambaRequestCallback)`  L695
- `void takePhoto(AmbaRequestCallback ambaRequestCallback)`  L704
- `void stopPhoto(AmbaRequestCallback ambaRequestCallback)`  L708
- `void record_start(AmbaRequestCallback ambaRequestCallback)`  L712
- `void record_stop(AmbaRequestCallback ambaRequestCallback)`  L716
- `void getSystemWorkState(AmbaRequestCallback ambaRequestCallback)`  L720
- `void getSdState(AmbaRequestCallback ambaRequestCallback)`  L724
- `void getBatteryInfo(AmbaRequestCallback ambaRequestCallback)`  L728
- `void syncSystemTime(AmbaRequestCallback ambaRequestCallback)`  L732
    - 体内字面量："yyyyMMddHHmmss"
- `void rotateAnimation(View view)`  L742 @Deprecated
- `void getResolutionSecondMenuItem(AmbaRequestCallback ambaRequestCallback)`  L751
    - 体内字面量："Resolution"
- `void getCurrentModeSecondMenuItem(AmbaRequestCallback ambaRequestCallback)`  L756
- `void setCurrentModeSecondMenuItem(String itemValue, AmbaRequestCallback ambaRequestCallback)`  L760
- `void qsAddTime(AmbaRequestCallback ambaRequestCallback)`  L764
### `com.gku.actioncam.amba.ui.preview.AmbaPreviewPresenter$AnonymousClass3`
L383 · [class] AnonymousClass3 · extends `Thread` · `com/gku/actioncam/amba/ui/preview/AmbaPreviewPresenter.java`

字段/常量（1）：
- `String val$sound`  L384

方法（2）：
- `void run()`  L391 @Override
- `void onCompletion(MediaPlayer mediaPlayer2)`  L395 @Override
### `com.gku.actioncam.amba.ui.preview.ModeSettingPopupWindow`
L21 · [class] public ModeSettingPopupWindow · extends `PopupWindow` · `com/gku/actioncam/amba/ui/preview/ModeSettingPopupWindow.java`

字段/常量（3）：
- `String[] allItem`  L22
- `AmbaPreviewActivity ambaPreviewActivity`  L23
- `String currentItem`  L24

方法（6）：
- `public ModeSettingPopupWindow(AmbaPreviewActivity ambaPreviewActivity, String[] allItem, String currentItem)`  L26
- `void initView()`  L33
    - 体内字面量："TAG" · "initView: asdiftgasyuifou" · "#fafafa"
- `void onItemSelect(int i, boolean z)`  L60 @Override
- `void lambda$initView$0(ArrayList arrayList, int i, boolean z)`  L68
- `void failure(int code)`  L77 @Override
- `void success()`  L81 @Override
### `com.gku.actioncam.amba.ui.setting.AmbaSettingUtil`
L19 · [class] public AmbaSettingUtil · `com/gku/actioncam/amba/ui/setting/AmbaSettingUtil.java`

字段/常量（1）：
- `boolean z = true`  L22

方法（5）：
- `ArrayList<SettingItemModel> getModeItem(String[] item, String[] value, Context mContext)`  L20
- `ArrayList<SettingItemModel> getDeviceItem(Context mContext, String[] itemName, String[] itemValue, HashMap<String, String[]> secondMenuItem)`  L38
    - 体内字面量："ON" · "OFF" · "ON" · "OFF" · "ON" · "ON" · "OFF"
- `WeChatSwitchButton createSwitch(Context mContext, boolean IsSelect)`  L63
- `TextView creatTextView(Context mContext)`  L72
- `void showSelectItemDialog(Context context, String[] itemValue, String title, String currentValue, AdapterView.OnItemClickListener onItemClickListener, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener)`  L80
    - 体内字面量："yunqi_debug" · "showSelectItemDialog: " · "yunqi_debug" · "showSelectItemDialog: "
### `com.gku.actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingActivity`
L25 · [class] public AmbaDeviceSettingActivity · extends `IjkBaseActivity` · `com/gku/actioncam/amba/ui/setting/device_setting/AmbaDeviceSettingActivity.java`

字段/常量（14）：
- `AmbaDeviceSettingAdapter ambaDeviceSettingAdapter`  L26
- `AmbaDeviceSettingPresenter ambaDeviceSettingPresenter`  L27
- `TextView deviceSetTv`  L28
- `ProgressDialog dialog`  L29
- `ImageView icBack`  L30
- `LinearLayoutManager layoutManager`  L31
- `TextView modeSetTv`  L32
- `RecyclerView recyModel`  L33
- `String currentClickItemName = null`  L34
- `boolean isSettingMenuItem = false`  L35
- `int curFirstPosition = 0`  L36
- `String[] strArr2 = new String[strArr.length]`  L137
- `LinearLayoutManager linearLayoutManager = this.layoutManager`  L196
- `AmbaDeviceSettingActivity ambaDeviceSettingActivity = AmbaDeviceSettingActivity.this`  L264

方法（27）：
- `void onCreate(Bundle savedInstanceState)`  L39 @Override
- `void onRestart()`  L46 @Override
- `void disconnect()`  L51 @Override
- `void lambda$onRestart$0()`  L58
- `void initView()`  L62
- `void onClick(View view)`  L69 @Override
- `void lambda$initView$1(View view)`  L79
- `void notifyData(String value)`  L83
    - 体内字面量："yunqi_debug" · "notifyData: " · "yunqi_debug" · "notifyData: settingItemModels is null"
- `void initRecycleView(final ArrayList<SettingItemModel> settingItemModels, final HashMap<String, String[]> secondMenuItem)`  L104
- `void onItemClick(int i)`  L113 @Override
- `void onItemClick(int i, boolean z)`  L119 @Override
- `void lambda$initRecycleView$3(HashMap map, ArrayList arrayList, int i)`  L126
- `void failure(int code)`  L145 @Override
- `void success()`  L149 @Override
    - 体内字面量："Time Set" · "Factory Reset" · "Format SD" · "Information"
- `void onItemClick(AdapterView adapterView, View view, int i3, long j)`  L172 @Override
- `void onClick(DialogInterface dialog, int which)`  L177 @Override
- `void onCancel(DialogInterface dialog)`  L183 @Override
- `void lambda$initRecycleView$2(String str, String[] strArr, AdapterView adapterView, View view, int i, long j)`  L191
- `void lambda$initRecycleView$4(ArrayList arrayList, int i, boolean z)`  L231
    - 体内字面量："ON" · "OFF" · "ON" · "OFF"
- `void failure(int code)`  L238 @Override
- `void success()`  L242 @Override
- `void addData()`  L247
    - 体内字面量："yunqi_debug" · "addData: device setting"
- `void disconnect()`  L253 @Override
- `void success()`  L259 @Override
- `void failure(int code)`  L263 @Override
- `void lambda$addData$5()`  L272
- `void showProgressDialog(boolean isShow)`  L276
### `com.gku.actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingActivity$AnonymousClass4`
L204 · [class] AnonymousClass4 · extends `AmbaRequestCallback` · `com/gku/actioncam/amba/ui/setting/device_setting/AmbaDeviceSettingActivity.java`

方法（4）：
- `void failure(int code)`  L206 @Override
- `void success()`  L213 @Override
- `void run()`  L217 @Override
- `void lambda$success$0()`  L225
### `com.gku.actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingAdapter`
L18 · [class] public AmbaDeviceSettingAdapter · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/actioncam/amba/ui/setting/device_setting/AmbaDeviceSettingAdapter.java`

字段/常量（5）：
- `ArrayList<SettingItemModel> ItemList`  L19
- `Context mContext`  L21
- `OnItemClickListener mOnItemClickListener`  L22
- `OnItemSwitchChangeListener mOnItemSwitchChangeListener`  L23
- `ArrayList<SettingItemModel> arrayList = this.ItemList`  L104

方法（8）：
- `public AmbaDeviceSettingAdapter(Context mContext, ArrayList<SettingItemModel> itemList)`  L33
- `void setOnItemClickListener(OnItemClickListener mOnItemClickListener)`  L38
- `void setOnItemSwitchChangeListener(OnItemSwitchChangeListener mOnItemSwitchChangeLitener)`  L42
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L47 @Override
- `void onBindViewHolder(final MyViewHolder holder, int position)`  L52 @Override
    - 体内字面量："ON"
- `void onCheckedChanged(SwitchButton switchButton, boolean b)`  L77 @Override
- `void onClick(View v)`  L87 @Override
- `int getItemCount()`  L103 @Override
### `com.gku.actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingAdapter$MyViewHolder`
L111 · [class] public MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/amba/ui/setting/device_setting/AmbaDeviceSettingAdapter.java`

字段/常量（5）：
- `TextView ItemTitle`  L112
- `ImageView RightArrow`  L113
- `RelativeLayout relativeLayout`  L114
- `SwitchButton switchButton`  L115
- `TextView textViewValue`  L116

方法（1）：
- `public MyViewHolder(View itemView)`  L118
### `com.gku.actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingAdapter$OnItemClickListener`
L25 · [interface] public OnItemClickListener · `com/gku/actioncam/amba/ui/setting/device_setting/AmbaDeviceSettingAdapter.java`

方法（1）：
- `void onItemClick(int position)`  L26
### `com.gku.actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingAdapter$OnItemSwitchChangeListener`
L29 · [interface] public OnItemSwitchChangeListener · `com/gku/actioncam/amba/ui/setting/device_setting/AmbaDeviceSettingAdapter.java`

方法（1）：
- `void onItemClick(int position, boolean b)`  L30
### `com.gku.actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingPresenter`
L29 · [class] public AmbaDeviceSettingPresenter · implements `IChannelListener` · `com/gku/actioncam/amba/ui/setting/device_setting/AmbaDeviceSettingPresenter.java`

字段/常量（20）：
- `String AMBA_GET_SYSTEM_SETTING_LIST = "System"`  L30
- `AmbaDeviceSettingActivity ambaDeviceSettingActivity`  L32
- `String[] cur`  L33
- `String curRequestName`  L34
- `String[] item`  L35
- `HashMap<String, String[]> secondMenuItem`  L36
- `ArrayList<SettingItemModel> settingItemModels`  L37
- `int i = 0`  L70
- `String str = array[0]`  L72
- `String str2 = array[1]`  L73
- `String str3 = array[0]`  L87
- `String str4 = this.curRequestName`  L88
- `String[] strArr2 = this.item`  L92
- `String str5 = array[0]`  L107
- `String str6 = array[1]`  L108
- `String[] strArr3 = this.cur`  L139
- `String string`  L282
- `int i = 0`  L359
- `String[] strArr = this.item`  L361
- `String str = strArr[i]`  L365

方法（39）：
- `public AmbaDeviceSettingPresenter(AmbaDeviceSettingActivity ambaDeviceSettingActivity)`  L39
- `void disconnect()`  L43
- `void lambda$onChannelEvent$0()`  L48
- `void lambda$onChannelEvent$1(String str)`  L54
- `void onChannelEvent(int type, Object param, String... array)`  L59 @Override
- `void run()`  L63 @Override
- `void run()`  L76 @Override
- `void run()`  L97 @Override
- `void run()`  L113 @Override
- `void run()`  L128 @Override
- `void showWiFiSetDialog(final String pwd, String ssid)`  L154
- `void onClick(View view)`  L179 @Override
- `void onClick(View view)`  L185 @Override
- `void lambda$showWiFiSetDialog$2(EditText editText, String[] strArr, EditText editText2, String str, Dialog dialog, View view)`  L192
    - 体内字面量："%s_%s"
- `void failure(int code)`  L203 @Override
- `void success()`  L207 @Override
- `String[] splitSSID(String ssid)`  L214
    - 体内字面量："_" · "_"
- `String fillNullParam(String string)`  L229
    - 体内字面量：",," · ",," · ",-," · "-%s" · "%s-"
- `void getSystemSetting(AmbaRequestCallback ambaRequestCallback)`  L242
- `void getSystemSecondMenuItem(String itemName, AmbaRequestCallback ambaRequestCallback)`  L246
- `void setCurParameter(String itemName, String itemValue, AmbaRequestCallback ambaRequestCallback)`  L254
- `void formatSD(AmbaRequestCallback ambaRequestCallback)`  L262
- `void resetFactory(AmbaRequestCallback ambaRequestCallback)`  L266
- `void getWifiSetting(AmbaRequestCallback ambaRequestCallback)`  L270
- `void setWifiSetting(String ssid, String password, AmbaRequestCallback ambaRequestCallback)`  L274
- `void showDeviceDialog(final int type, String strTitle)`  L281
- `void onClick(DialogInterface dialogInterface, int i)`  L297 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L303 @Override
- `void lambda$showDeviceDialog$4(int i, DialogInterface dialogInterface, int i2)`  L311
- `void failure(int code)`  L316 @Override
- `void success()`  L320 @Override
    - 体内字面量："123->" · " format   ambaDeviceSettingActivity "
- `void run()`  L327 @Override
- `void success()`  L333 @Override
- `void failure(int code)`  L337 @Override
- `void run()`  L341 @Override
- `void lambda$showDeviceDialog$5(DialogInterface dialogInterface, int i)`  L353
- `void selfGetSecondMenuItem()`  L358
- `void failure(int code)`  L370 @Override
- `void success()`  L374 @Override
### `com.gku.actioncam.amba.ui.setting.mode_setting.AmbaWorkSettingActivity`
L24 · [class] public AmbaWorkSettingActivity · extends `IjkBaseActivity` · `com/gku/actioncam/amba/ui/setting/mode_setting/AmbaWorkSettingActivity.java`

字段/常量（14）：
- `String AMBA_PRIMARY_SETTING_PAGE_MODE = "amba_setting_page_mode"`  L25
- `AmbaPreviewDate ambaPreviewDate`  L26
- `AmbaWorkSettingAdapter ambaWorkSettingAdapter`  L27
- `AmbaWorkSettingPresenter ambaWorkSettingPresenter`  L28
- `TextView deviceSetTv`  L29
- `ImageView icBack`  L30
- `LinearLayoutManager layoutManager`  L31
- `TextView modeSetTv`  L32
- `RecyclerView recyModel`  L33
- `String workMode`  L34
- `String currentClickItemName = null`  L36
- `boolean isSettingMenuItem = false`  L37
- `int curFirstPosition = 0`  L38
- `AmbaWorkSettingActivity ambaWorkSettingActivity = AmbaWorkSettingActivity.this`  L197

方法（23）：
- `void onCreate(Bundle savedInstanceState)`  L41 @Override
- `void onRestart()`  L48 @Override
- `void disconnect()`  L53 @Override
- `void lambda$onRestart$0()`  L61
- `void initView()`  L65
- `void onClick(View view)`  L72 @Override
- `void onClick(View view)`  L79 @Override
- `void lambda$initView$1(View view)`  L87
- `void lambda$initView$2(View view)`  L92
- `void notifyData(String value)`  L96
    - 体内字面量："yunqi_debug" · "notifyData: " · "Resolution"
- `void run()`  L117 @Override
- `void lambda$notifyData$3()`  L129
- `void initRecycleView(final String workMode)`  L133
- `void onItemClick(int i)`  L142 @Override
- `void lambda$initRecycleView$4(String str, int i)`  L149
- `void failure(int code)`  L157 @Override
- `void success()`  L161 @Override
- `void setSettingItemModels(ArrayList<SettingItemModel> settingItemModels)`  L166
- `void addData()`  L170
    - 体内字面量："take param workMode error" · "yunqi_debug" · "addData: " · "yunqi_debug" · "addData: workMode: "
- `void disconnect()`  L186 @Override
- `void success()`  L192 @Override
- `void failure(int code)`  L196 @Override
- `void lambda$addData$5()`  L205
### `com.gku.actioncam.amba.ui.setting.mode_setting.AmbaWorkSettingAdapter`
L17 · [class] public AmbaWorkSettingAdapter · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/actioncam/amba/ui/setting/mode_setting/AmbaWorkSettingAdapter.java`

字段/常量（3）：
- `Context context`  L19
- `OnItemClickListener onItemClickListener`  L20
- `ArrayList<SettingItemModel> settingItemModels`  L21

方法（7）：
- `public AmbaWorkSettingAdapter(Context context, ArrayList<SettingItemModel> settingItemModels)`  L27
- `void setOnItemClickListener(OnItemClickListener onItemClickListener)`  L32
- `View getLayout(int layoutId)`  L36
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L41 @Override
- `void onBindViewHolder(final MyViewHolder holder, int position)`  L46 @Override
- `void onClick(View v)`  L63 @Override
- `int getItemCount()`  L78 @Override
### `com.gku.actioncam.amba.ui.setting.mode_setting.AmbaWorkSettingAdapter$MyViewHolder`
L82 · [class] public MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/amba/ui/setting/mode_setting/AmbaWorkSettingAdapter.java`

字段/常量（4）：
- `TextView ItemTitle`  L83
- `ImageView RightArrow`  L84
- `RelativeLayout relativeLayout`  L85
- `TextView textViewValue`  L86

方法（1）：
- `public MyViewHolder(View itemView)`  L88
### `com.gku.actioncam.amba.ui.setting.mode_setting.AmbaWorkSettingAdapter$OnItemClickListener`
L23 · [interface] public OnItemClickListener · `com/gku/actioncam/amba/ui/setting/mode_setting/AmbaWorkSettingAdapter.java`

方法（1）：
- `void onItemClick(int position)`  L24
### `com.gku.actioncam.amba.ui.setting.mode_setting.AmbaWorkSettingPresenter`
L19 · [class] public AmbaWorkSettingPresenter · implements `IChannelListener` · `com/gku/actioncam/amba/ui/setting/mode_setting/AmbaWorkSettingPresenter.java`

字段/常量（7）：
- `AmbaWorkSettingActivity ambaWorkSettingActivity`  L21
- `AmbaWorkSettingActivity ambaWorkSettingActivity = this.ambaWorkSettingActivity`  L65
- `AmbaWorkSettingPresenter ambaWorkSettingPresenter = AmbaWorkSettingPresenter.this`  L105
- `String str = array[0]`  L138
- `String[] strArr2 = new String[strArr.length]`  L140
- `String str2 = array[0]`  L153
- `String str3 = array[1]`  L154

方法（18）：
- `public AmbaWorkSettingPresenter(AmbaWorkSettingActivity ambaWorkSettingActivity)`  L23
- `void disconnect()`  L27
- `void lambda$onChannelEvent$0()`  L32
- `void lambda$onChannelEvent$2(String[] strArr, String str, final String str2, final String[] strArr2)`  L38
- `void onItemClick(AdapterView adapterView, View view, int i, long j)`  L41 @Override
- `void onClick(DialogInterface dialog, int which)`  L46 @Override
- `void onCancel(DialogInterface dialog)`  L52 @Override
- `void lambda$onChannelEvent$1(String str, String[] strArr, AdapterView adapterView, View view, int i, long j)`  L59
- `void failure(int code)`  L70 @Override
- `void success()`  L101 @Override
- `void onChannelEvent(int type, Object param, String... array)`  L112 @Override
- `void run()`  L117 @Override
- `void run()`  L127 @Override
- `void run()`  L147 @Override
- `void getPrimaryMenuItem(String workMode, AmbaRequestCallback ambaRequestCallback)`  L161
- `void getSecondMenuItem(String workMode, String itemName, AmbaRequestCallback ambaRequestCallback)`  L169
- `void setCurParameter(String workMode, String itemName, String itemValue, AmbaRequestCallback ambaRequestCallback)`  L177
- `String currentRequestParam(String workMode)`  L185
    - 体内字面量："Time Lapse" · "Self-Timer" · "Number" · "Duration"
### `com.gku.actioncam.amba.ui.setting.mode_setting.AmbaWorkSettingPresenter$AnonymousClass1`
L74 · [class] AnonymousClass1 · extends `AmbaRequestCallback` · `com/gku/actioncam/amba/ui/setting/mode_setting/AmbaWorkSettingPresenter.java`

方法（4）：
- `void failure(int code)`  L76 @Override
- `void success()`  L83 @Override
- `void run()`  L87 @Override
- `void lambda$success$0()`  L95
### `com.gku.actioncam.amba.ui.setting.ShowItemDialog`
L20 · [class] public ShowItemDialog · extends `Dialog` · `com/gku/actioncam/amba/ui/setting/ShowItemDialog.java`

方法（2）：
- `public ShowItemDialog(Context context)`  L21
- `public ShowItemDialog(Context context, int themeResId)`  L25
### `com.gku.actioncam.amba.ui.setting.ShowItemDialog$Builder`
L29 · [class] public static Builder · `com/gku/actioncam/amba/ui/setting/ShowItemDialog.java`

字段/常量（14）：
- `Context context`  L30
- `String curSelected = "<binary/metadata>"`  L31
- `boolean isDoubleButton = false`  L32
- `AdapterView.OnItemClickListener itemClickListener`  L33
- `DialogInterface.OnClickListener mNegativeButtonClickListener`  L34
- `String mNegativeButtonText`  L35
- `DialogInterface.OnClickListener mPositiveButtonClickListener`  L36
- `String mPositiveButtonText`  L37
- `String message`  L38
- `String[] strEnters`  L39
- `String title`  L40
- `Button button`  L106
- `String[] strArr = this.strEnters`  L149
- `int length = strArr.length`  L151

方法（16）：
- `Builder setContentView(View v)`  L42
- `public Builder(Context context)`  L46
- `Builder setMessage(String message)`  L50
- `Builder setCurSelected(String curSelected)`  L55
- `Builder setMessage(int message)`  L60
- `Builder setTitle(int title)`  L65
- `Builder setTitle(String title)`  L70
- `Builder setEntres(String[] entres, AdapterView.OnItemClickListener listener)`  L75
- `Builder setNegativeButton(String negativeButtonText, DialogInterface.OnClickListener listener)`  L81
- `Builder setNegativeButton(int negativeText, DialogInterface.OnClickListener listener)`  L87
- `Builder setPositiveButton(String positiveText, DialogInterface.OnClickListener listener)`  L93
- `Builder setPositiveButton(int positiveText, DialogInterface.OnClickListener listener)`  L99
- `ShowItemDialog create()`  L105
- `void onClick(View v)`  L117 @Override
- `void onClick(View v)`  L134 @Override
- `void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)`  L169 @Override
### `com.gku.actioncam.amba.ui.stream.adapter.SelectLiveDeviceAdapter`
L14 · [class] public final SelectLiveDeviceAdapter · extends `BaseQuickAdapter<DeviceAddItem, BaseDataBindingHolder<ItemSelectLiveDeviceBinding>>` · `com/gku/actioncam/amba/ui/stream/adapter/SelectLiveDeviceAdapter.java`
注解：

字段/常量（1）：
- `int curSelect`  L15

方法（4）：
- `public SelectLiveDeviceAdapter()`  L17
- `void updateSelectIndex(int index)`  L22
- `int getCurSelect()`  L27
- `void convert(BaseDataBindingHolder<ItemSelectLiveDeviceBinding> holder, DeviceAddItem item)`  L33 @Override
    - 体内字面量："holder" · "item"
### `com.gku.actioncam.amba.ui.stream.BroadcastDouyinFragment2`
L62 · [class] public final BroadcastDouyinFragment2 · extends `BaseFragment implements StreamConfigActivity.OnFragmentBackPressed, DouyinStreamController.BroadcastStatusObserver, BLELiveCallback` · implements `StreamConfigActivity.OnFragmentBackPressed, DouyinStreamController.BroadcastStatusObserver, BLELiveCallback` · `com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment2.java`
注解：

字段/常量（92）：
- `TextView cancel_author`  L63
- `CountDownTimer countDownTimer`  L64
- `boolean hasLive`  L65
- `ImageView imgCheck`  L66
- `ImageView imgDeviceConnect`  L67
- `ImageView imgWifiConnect`  L68
- `boolean isAgreementChecked`  L69
- `boolean isAutoLive`  L70
- `boolean isNewLive`  L71
- `LinearLayoutShape llSelectDevice`  L72
- `DouyinStreamController.BroadcastStatus mBroadcastStatus`  L73
- `boolean needSkipThisAutoLive`  L74
- `RadioGroup rg_bs`  L75
- `RadioGroup rg_fps`  L76
- `RadioGroup rg_resolution`  L77
- `RTMPBean rtmpBean`  L78
- `DeviceAddItem selectDevice`  L79
- `ActivityResultLauncher<Intent> selectDeviceLaunch`  L80
- `ActivityResultLauncher<Intent> selectWifiLaunch`  L81
- `Button streamStart`  L82
- `DouyinStreamController subscribeController`  L83
- `TextView tvConnectHint`  L84
- `TextView tvDeviceConnectDot`  L85
- `TextView tvDeviceConnectStatus`  L86
- `TextView tvPrivacy`  L87
- `TextView tvSelectDevice`  L88
- `TextView tvSwitchWifi`  L89
- `TextView tvSwtichDevice`  L90
- `TextView tvWifiConnectDot`  L91
- `TextView tvWifiConnectStatus`  L92
- `TextView tv_b_status`  L93
- `String deviceName = "<binary/metadata>"`  L94
- `String ssid = "<binary/metadata>"`  L95
- `String pwd = "<binary/metadata>"`  L96
- `boolean hasDouyinReply = true`  L97
- `String wifiStatus = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE`  L98
- `LinearLayoutShape linearLayoutShape = this.llSelectDevice`  L151
- `TextView textView = this.tvConnectHint`  L165
- `Button button = this.streamStart`  L179
- `ImageView imageView = this.imgDeviceConnect`  L193
- `TextView textView = this.tvDeviceConnectDot`  L207
- `TextView textView = this.tvDeviceConnectStatus`  L221
- `ImageView imageView = this.imgWifiConnect`  L235
- `TextView textView = this.tvSwitchWifi`  L249
- `TextView textView = this.tvWifiConnectStatus`  L263
- `TextView textView = this.tv_b_status`  L277
- `TextView textView = this.cancel_author`  L291
- `ImageView imageView = this.imgCheck`  L305
- `TextView textView = this.tvPrivacy`  L319
- `TextView textView = this.tvSelectDevice`  L333
- `TextView textView = this.tvWifiConnectDot`  L347
- `TextView textView = this.tvSwtichDevice`  L361
- `RadioGroup radioGroup = this.rg_resolution`  L375
- `RadioGroup radioGroup = this.rg_fps`  L389
- `RadioGroup radioGroup = this.rg_bs`  L403
- `DouyinStreamController douyinStreamController = this.subscribeController`  L417
- `ComponentActivity componentActivity = broadcastDouyinFragment2.activity`  L447
- `String stringExtra`  L470
- `String stringExtra2`  L471
- `String str = "<binary/metadata>"`  L474
- `ComponentActivity componentActivity = this.activity`  L605
- `RTMPBean rTMPBean2 = this.rtmpBean`  L614
- `RTMPBean rTMPBean3 = this.rtmpBean`  L618
- `RTMPBean rTMPBean4 = this.rtmpBean`  L622
- `String[] strArr`  L671
- `RTMPBean rTMPBean = BroadcastDouyinFragment2.this.rtmpBean`  L764
- `BroadcastDouyinFragment2 broadcastDouyinFragment2 = BroadcastDouyinFragment2.this`  L766
- `BroadcastDouyinFragment2 broadcastDouyinFragment3 = BroadcastDouyinFragment2.this`  L776
- `BroadcastDouyinFragment2 broadcastDouyinFragment4 = broadcastDouyinFragment3`  L794
- `ComponentActivity componentActivity = broadcastDouyinFragment2.activity`  L850
- `String[] strArr = {PermissionUtils.LOCATION}`  L852
- `ComponentActivity componentActivity2 = broadcastDouyinFragment2.activity`  L853
- `BroadcastDouyinFragment2 broadcastDouyinFragment3 = this.this$0`  L908
- `boolean z = broadcastDouyinFragment2.isAgreementChecked`  L928
- `RTMPBean rTMPBean = this.rtmpBean`  L939
- `RTMPBean rTMPBean2 = this.rtmpBean`  L943
- `String str = bluLiveDevName`  L989
- `ComponentActivity componentActivity = this.activity`  L999
- `ComponentActivity componentActivity = BroadcastDouyinFragment2.this.activity`  L1026
- `BroadcastDouyinFragment2 broadcastDouyinFragment2 = BroadcastDouyinFragment2.this`  L1029
- `CountDownTimer countDownTimer = this.countDownTimer`  L1040
- `ArrayList arrayList`  L1048
- `BluetoothDevice next`  L1049
- `ComponentActivity componentActivity = this.activity`  L1054
- `ComponentActivity componentActivity2 = this.activity`  L1069
- `ComponentActivity componentActivity = this.activity`  L1143
- `String str2 = str`  L1157
- `DeviceAddItem deviceAddItem = broadcastDouyinFragment2.selectDevice`  L1170
- `ComponentActivity componentActivity`  L1179
- `ComponentActivity componentActivity = this.activity`  L1226
- `ComponentActivity componentActivity`  L1292
- `RTMPBean rTMPBean = broadcastDouyinFragment2.rtmpBean`  L1310

方法（118）：
- `public BroadcastDouyinFragment2()`  L130
- `void onActivityResult(Object obj)`  L133 @Override
    - 体内字面量："registerForActivityResult(...)"
- `void onActivityResult(Object obj)`  L141 @Override
    - 体内字面量："registerForActivityResult(...)"
- `LinearLayoutShape getLlSelectDevice()`  L150
- `void setLlSelectDevice(LinearLayoutShape linearLayoutShape)`  L159
    - 体内字面量："<set-?>"
- `TextView getTvConnectHint()`  L164
- `void setTvConnectHint(TextView textView)`  L173
    - 体内字面量："<set-?>"
- `Button getStreamStart()`  L178
- `void setStreamStart(Button button)`  L187
    - 体内字面量："<set-?>"
- `ImageView getImgDeviceConnect()`  L192
- `void setImgDeviceConnect(ImageView imageView)`  L201
    - 体内字面量："<set-?>"
- `TextView getTvDeviceConnectDot()`  L206
- `void setTvDeviceConnectDot(TextView textView)`  L215
    - 体内字面量："<set-?>"
- `TextView getTvDeviceConnectStatus()`  L220
- `void setTvDeviceConnectStatus(TextView textView)`  L229
    - 体内字面量："<set-?>"
- `ImageView getImgWifiConnect()`  L234
- `void setImgWifiConnect(ImageView imageView)`  L243
    - 体内字面量："<set-?>"
- `TextView getTvSwitchWifi()`  L248
- `void setTvSwitchWifi(TextView textView)`  L257
    - 体内字面量："<set-?>"
- `TextView getTvWifiConnectStatus()`  L262
- `void setTvWifiConnectStatus(TextView textView)`  L271
    - 体内字面量："<set-?>"
- `TextView getTv_b_status()`  L276
- `void setTv_b_status(TextView textView)`  L285
    - 体内字面量："<set-?>"
- `TextView getCancel_author()`  L290
- `void setCancel_author(TextView textView)`  L299
    - 体内字面量："<set-?>"
- `ImageView getImgCheck()`  L304
- `void setImgCheck(ImageView imageView)`  L313
    - 体内字面量："<set-?>"
- `TextView getTvPrivacy()`  L318
- `void setTvPrivacy(TextView textView)`  L327
    - 体内字面量："<set-?>"
- `TextView getTvSelectDevice()`  L332
- `void setTvSelectDevice(TextView textView)`  L341
    - 体内字面量："<set-?>"
- `TextView getTvWifiConnectDot()`  L346
- `void setTvWifiConnectDot(TextView textView)`  L355
    - 体内字面量："<set-?>"
- `TextView getTvSwtichDevice()`  L360
- `void setTvSwtichDevice(TextView textView)`  L369
    - 体内字面量："<set-?>"
- `RadioGroup getRg_resolution()`  L374
- `void setRg_resolution(RadioGroup radioGroup)`  L383
    - 体内字面量："<set-?>"
- `RadioGroup getRg_fps()`  L388
- `void setRg_fps(RadioGroup radioGroup)`  L397
    - 体内字面量："<set-?>"
- `RadioGroup getRg_bs()`  L402
- `void setRg_bs(RadioGroup radioGroup)`  L411
    - 体内字面量："<set-?>"
- `DouyinStreamController getSubscribeController()`  L416
- `void setSubscribeController(DouyinStreamController douyinStreamController)`  L425
    - 体内字面量："<set-?>"
- `ActivityResultLauncher<Intent> getSelectDeviceLaunch()`  L430
- `void selectDeviceLaunch$lambda$1(BroadcastDouyinFragment2 broadcastDouyinFragment2, ActivityResult activityResult)`  L435
    - 体内字面量："ARGUMENT_DATA"
- `ActivityResultLauncher<Intent> getSelectWifiLaunch()`  L464
- `void selectWifiLaunch$lambda$2(BroadcastDouyinFragment2 broadcastDouyinFragment2, ActivityResult activityResult)`  L469
- `void onCreate(Bundle b)`  L508 @Override
    - 体内字面量："broadcast_result"
- `void onFragmentResult(String str, Bundle bundle)`  L512 @Override
- `void onCreate$lambda$3(BroadcastDouyinFragment2 broadcastDouyinFragment2, String str, Bundle bundle)`  L521
    - 体内字面量："<unused var>" · "bundle"
- `void onHiddenChanged(boolean hidden)`  L530 @Override
    - 体内字面量："xs, " · "hidden = "
- `void onDestroyView()`  L536 @Override
    - 体内字面量："xs, " · "onDestroyView"
- `void onDestroy()`  L545 @Override
    - 体内字面量："xs, " · "onDestroy"
- `void clearAutoLiveInfo()`  L560
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L567 @Override
    - 体内字面量："inflater" · "inflate(...)"
- `void onViewCreated(View view, Bundle savedInstanceState)`  L575 @Override
    - 体内字面量："view"
- `Object invoke(Object obj)`  L631 @Override
- `Unit onViewCreated$lambda$6(final BroadcastDouyinFragment2 broadcastDouyinFragment2, Span span)`  L640
    - 体内字面量："$this$span" · "getString(...)" · "getString(...)"
- `Object invoke(Object obj)`  L649 @Override
- `Unit onViewCreated$lambda$6$lambda$5(final BroadcastDouyinFragment2 broadcastDouyinFragment2, Span span)`  L657
    - 体内字面量："$this$span"
- `Object invoke()`  L662 @Override
- `Unit onViewCreated$lambda$6$lambda$5$lambda$4(BroadcastDouyinFragment2 broadcastDouyinFragment2)`  L670
- `void initListener(View view)`  L683
- `void onClick(View view2)`  L686 @Override
- `void onClick(View view2)`  L692 @Override
- `void onClick(View view2)`  L698 @Override
- `void onClick(View view2)`  L704 @Override
- `void onClick(View view2)`  L710 @Override
- `void onClick(View view2)`  L716 @Override
- `void onClick(View p0)`  L747 @Override
    - 体内字面量："720" · "1080" · "25" · "30"
- `void onSuccess(String msg)`  L779 @Override
    - 体内字面量："msg"
- `void onFail(int code, String msg)`  L790 @Override
    - 体内字面量："msg"
- `throw new NoWhenBranchMatchedException()`  L806
- `void onClick(View view2)`  L812 @Override
- `void onClick(View view2)`  L818 @Override
- `void initListener$lambda$7(BroadcastDouyinFragment2 broadcastDouyinFragment2, View view)`  L825
- `void initListener$lambda$8(BroadcastDouyinFragment2 broadcastDouyinFragment2, View view)`  L830
- `void initListener$lambda$9(final BroadcastDouyinFragment2 broadcastDouyinFragment2, View view)`  L849
- `void onPermissionHave()`  L860 @Override
- `void initListener$lambda$10(BroadcastDouyinFragment2 broadcastDouyinFragment2, View view)`  L881
- `void initListener$lambda$11(BroadcastDouyinFragment2 broadcastDouyinFragment2, View view)`  L886
- `void initListener$lambda$12(final BroadcastDouyinFragment2 broadcastDouyinFragment2, View view)`  L891
- `void onSuccess(DouyinStreamController.BroadcastStatus status)`  L900 @Override
    - 体内字面量："status"
- `void onFail(int code, String msg)`  L906 @Override
    - 体内字面量："msg"
- `throw new NoWhenBranchMatchedException()`  L915
- `void initListener$lambda$13(BroadcastDouyinFragment2 broadcastDouyinFragment2, View view)`  L920
- `void initListener$lambda$14(BroadcastDouyinFragment2 broadcastDouyinFragment2, View view)`  L927
- `void startNewLive(String msg, int fbl, int fps, int bitrate)`  L938
- `void showDeviceConnectUI()`  L962
- `void hideDeviceConnectUI()`  L968
- `void showWifiConnectUI()`  L974
- `void hideWifiConnectUI()`  L980
- `void handleAutoLive()`  L986
- `void startCountdown()`  L1011
- `void onTick(long millisUntilFinished)`  L1014 @Override
- `void onFinish()`  L1022 @Override
- `void cancelCountdown()`  L1039
- `void onEventRefresh(UpdateEvent event)`  L1047 @Subscribe(threadMode = ThreadMode.MAIN)
- `void onDetach()`  L1080 @Override
- `boolean onBackPressed()`  L1088 @Override
- `DouyinStreamController.BroadcastStatus getMBroadcastStatus()`  L1093
- `void setMBroadcastStatus(DouyinStreamController.BroadcastStatus broadcastStatus)`  L1097
    - 体内字面量："<set-?>"
- `void broadcastStatusChanged(DouyinStreamController.BroadcastStatus broadcastStatus)`  L1103 @Override
    - 体内字面量："broadcastStatus"
- `throw new NoWhenBranchMatchedException()`  L1122
- `void onPinSuccess(final String deviceName, final boolean isSupportBlueLive)`  L1131 @Override
    - 体内字面量："deviceName"
- `void run()`  L1147 @Override
- `void onPinSuccess$lambda$15(boolean z, String str, BroadcastDouyinFragment2 broadcastDouyinFragment2)`  L1155
- `void onDeviceConnectStatus(final int status)`  L1178 @Override
- `void run()`  L1185 @Override
- `void onDeviceConnectStatus$lambda$16(BroadcastDouyinFragment2 broadcastDouyinFragment2, int i)`  L1192
- `void onStartWifiSuccess(final String status)`  L1220 @Override
    - 体内字面量："status"
- `void run()`  L1230 @Override
- `void onStartWifiSuccess$lambda$17(BroadcastDouyinFragment2 broadcastDouyinFragment2, String str)`  L1239
- `void onStartLiveSuccess()`  L1291 @Override
- `void run()`  L1298 @Override
- `void onStartLiveSuccess$lambda$18(BroadcastDouyinFragment2 broadcastDouyinFragment2)`  L1305
    - 体内字面量："xs, " · " onStartLiveSuccess"
- `void onSendFirstCmd()`  L1318 @Override
- `void onScanDialogDismiss()`  L1329
### `com.gku.actioncam.amba.ui.stream.BroadcastDouyinFragment2$WhenMappings`
L102 · [class] public WhenMappings · `com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment2.java`
注解：

字段/常量（3）：
- `int[] $EnumSwitchMapping$0`  L103
- `int[] $EnumSwitchMapping$1`  L104
- `int[] $EnumSwitchMapping$0`  L726
### `com.gku.actioncam.amba.ui.stream.BroadcastDouyinFragment2$WhenMappings`
L725 · [class] public WhenMappings · `com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment2.java`
注解：

字段/常量（3）：
- `int[] $EnumSwitchMapping$0`  L103
- `int[] $EnumSwitchMapping$1`  L104
- `int[] $EnumSwitchMapping$0`  L726
### `com.gku.actioncam.amba.ui.stream.BroadcastDouyinFragment3`
L34 · [class] public BroadcastDouyinFragment3 · extends `BaseFragment implements StreamConfigActivity.OnFragmentBackPressed` · implements `StreamConfigActivity.OnFragmentBackPressed` · `com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment3.java`

字段/常量（17）：
- `String BUNDLE_RETURN_FROM_OLD_LIVE = "BUNDLE_RETURN_FROM_OLD_LIVE"`  L35
- `String BUNDLE_RTMP = "BUNDLE_RTMP"`  L36
- `RTMPBean mRTMPBean`  L37
- `Socket socket`  L38
- `MaterialButton stream_end`  L39
- `MaterialButton stream_start`  L40
- `DouyinStreamController subscribeController`  L41
- `TextView tv_Log`  L42
- `TextView tv_not_ready`  L43
- `int CODE_ERROR_DOUYIN_HISI_CREATESOCKET_FAIL = -100001`  L44
- `int CODE_ERROR_DOUYIN_HISI_WRITE_MSG_FAIL = -100002`  L45
- `int CODE_ERROR_DOUYIN_HISI_WRITE_RTMP_FAIL = -100003`  L46
- `int CODE_ERROR_DOUYIN_HISI_READ_FAIL = -100004`  L47
- `int CODE_ERROR_DOUYIN_HISI_RECV_RTMP_FAIL = -100005`  L48
- `int CODE_ERROR_DOUYIN_HISI_PARESE_REV_FAIL = -100006`  L49
- `TCP_MSG_S tcp_msg_sFromBytes`  L248
- `byte[] bArr = new byte[72]`  L263

方法（27）：
- `void onCreate(Bundle savedInstanceState)`  L58 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L66 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L71 @Override
- `void callback(String deviceName)`  L78 @Override
- `void onClick(View view2)`  L90 @Override
- `void onClick(View view2)`  L96 @Override
- `void onClick(View view2)`  L102 @Override
- `void lambda$onViewCreated$0(View view)`  L110
- `void lambda$onViewCreated$1(View view)`  L115
- `void onConfirmed()`  L154 @Override
- `void lambda$onViewCreated$2(View view)`  L161
- `boolean onBackPressed()`  L166 @Override
    - 体内字面量："broadcast_result"
- `void sendRtmp(final String sendBuf, final Callback callback)`  L175
- `void onSuccess(CmdResponseBean responseBean, String json)`  L179 @Override
- `void onFail(final int code)`  L184 @Override
- `void onInterrupted()`  L187 @Override
- `Integer runThread()`  L192 @Override
- `void run_UIThread(Integer ret)`  L197 @Override
- `void onInterrupted()`  L210 @Override
- `Integer runThread()`  L215 @Override
- `void run_UIThread(Integer ret)`  L220 @Override
- `void onSuccess(CmdResponseBean responseBean, String json)`  L226 @Override
- `void onFail(int code)`  L231 @Override
- `void sendRtmp2Amba(String sendBuf, AmbaConnector.Callback<CmdResponseBean> callback)`  L242
- `int sendRtmp2Hisi(String sendBuf)`  L247
- `int closeSocket(int ret)`  L304
- `void onDestroy()`  L313 @Override
### `com.gku.actioncam.amba.ui.stream.BroadcastDouyinFragment3$AnonymousClass1`
L119 · [class] AnonymousClass1 · implements `Callback` · `com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment3.java`

方法（4）：
- `void onSuccess()`  L124 @Override
    - 体内字面量："tiktokCN"
- `void onClick(DialogInterface dialogInterface, int i)`  L129 @Override
- `void lambda$onSuccess$0(DialogInterface dialogInterface, int i)`  L143
- `void onFail(int code)`  L148 @Override
    - 体内字面量：":"
### `com.gku.actioncam.amba.ui.stream.BroadcastDouyinFragment3$Callback`
L51 · [interface] private Callback · `com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment3.java`

方法（2）：
- `void onFail(int code)`  L52
- `void onSuccess()`  L54
### `com.gku.actioncam.amba.ui.stream.BroadcastDouyinFragment4`
L33 · [class] public final BroadcastDouyinFragment4 · extends `BaseBdingFragment<FragmentStreamSettingFourBinding> implements StreamConfigActivity.OnFragmentBackPressed, BLELiveStatusCallback` · implements `StreamConfigActivity.OnFragmentBackPressed, BLELiveStatusCallback` · `com/gku/actioncam/amba/ui/stream/BroadcastDouyinFragment4.java`
注解：

字段/常量（24）：
- `String ARGUMENT_IS_AUTO_LIVE = "ARGUMENT_IS_AUTO_LIVE"`  L34
- `String ARGUMENT_ROOM_ID = "ARGUMENT_ROOM_ID"`  L35
- `long EXIT_TIMEOUT = 2000`  L36
- `int MSG_EXIT = 101`  L37
- `int MSG_TIMER = 100`  L38
- `BroadcastDouyinFragment4$handler$1 handler`  L39
- `boolean isAutoLive`  L40
- `String roomId = "<binary/metadata>"`  L41
- `long seconds`  L42
- `long startTime`  L43
- `DouyinStreamController subscribeController`  L44
- `int i = msg.what`  L57
- `BroadcastDouyinFragment4 broadcastDouyinFragment4 = this.this$0`  L68
- `long j = 3600`  L119
- `long j2 = seconds / j`  L120
- `long j3 = 60`  L121
- `long j5 = seconds % j3`  L123
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L124
- `long j6 = 60`  L130
- `long j7 = seconds / j6`  L131
- `long j8 = seconds % j6`  L132
- `StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE`  L133
- `StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE`  L138
- `ComponentActivity componentActivity = this.activity`  L155

方法（24）：
- `void loadData()`  L47 @Override
- `public BroadcastDouyinFragment4()`  L51
- `void handleMessage(Message msg)`  L55 @Override
    - 体内字面量："msg"
- `int getLayoutId()`  L77 @Override
- `void onCreate(Bundle b)`  L82 @Override
- `void startTimer()`  L87
- `void stopTimer()`  L92
- `void startExitTimeout()`  L97
- `void removeExitTimeout()`  L102
- `void onDestroy()`  L107 @Override
- `String formatDuration(long seconds)`  L117
- `void initView(Bundle saveInstanceState)`  L145 @Override
- `void initListener()`  L161 @Override
- `void onClick(View view)`  L165 @Override
- `void onClick(View view)`  L171 @Override
- `void closeLive()`  L178
    - 体内字面量："getString(...)"
- `void onConfirmed()`  L184 @Override
- `boolean onBackPressed()`  L192 @Override
- `void onLiveStatus(String status)`  L202 @Override
    - 体内字面量："status" · "4"
- `void doCloseLive()`  L244
- `void run()`  L247 @Override
- `void doCloseLive$lambda$7(final BroadcastDouyinFragment4 broadcastDouyinFragment4)`  L254
- `void run()`  L262 @Override
- `void doCloseLive$lambda$7$lambda$6(BroadcastDouyinFragment4 broadcastDouyinFragment4)`  L270
### `com.gku.actioncam.amba.ui.stream.BroadcastFragment`
L29 · [class] public final BroadcastFragment · extends `BaseFragment implements StreamConfigActivity.OnFragmentBackPressed` · implements `StreamConfigActivity.OnFragmentBackPressed` · `com/gku/actioncam/amba/ui/stream/BroadcastFragment.java`
注解：

字段/常量（9）：
- `SelectorAdapter<PlatFormInfo> selectorAdapter`  L30
- `SelectorAdapter<PlatFormInfo> selectorAdapter = this.selectorAdapter`  L33
- `int i = com.gku.module_base_xtugo.R.drawable.live_set_douyin_icon`  L123
- `int i2 = com.gku.module_base_xtugo.R.drawable.live_set_rtmp_icon`  L126
- `int i3 = com.gku.module_base_xtugo.R.drawable.live_set_wechat_icon`  L129
- `int i4 = com.gku.module_base_xtugo.R.drawable.live_set_bilibili_icon`  L132
- `ComponentActivity componentActivity = broadcastFragment.activity`  L140
- `BroadcastDouyinFragment2 broadcastDouyinFragment2`  L148
- `ComponentActivity componentActivity = this.activity`  L169

方法（14）：
- `SelectorAdapter<PlatFormInfo> getSelectorAdapter()`  L32
- `void setSelectorAdapter(SelectorAdapter<PlatFormInfo> selectorAdapter)`  L41
    - 体内字面量："<set-?>"
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L47 @Override
    - 体内字面量："inflater" · "inflate(...)"
- `void onViewCreated(View view, Bundle savedInstanceState)`  L55 @Override
    - 体内字面量："view"
- `void onClick(View view2)`  L59 @Override
- `void onClick(View view2)`  L65 @Override
- `void bindDataToView(BaseViewHolder baseViewHolder, int i, PlatFormInfo platFormInfo, boolean z, List list)`  L71 @Override
- `int getItemLayoutID(int position, PlatFormInfo bean)`  L76 @Override
- `void bindDataToView2(BaseViewHolder holder, int position, PlatFormInfo bean, boolean isSelected, List<? extends Object> payloads)`  L81
    - 体内字面量："holder" · "bean" · "payloads"
- `void onItemClick__(BaseViewHolder holder, int position, PlatFormInfo bean)`  L99 @Override
    - 体内字面量："holder" · "bean" · "findViewById(...)"
- `void onViewCreated$lambda$0(BroadcastFragment broadcastFragment, View view)`  L139
- `void onViewCreated$lambda$1(BroadcastFragment broadcastFragment, View view)`  L147
- `void onDestroy()`  L163 @Override
- `boolean onBackPressed()`  L168 @Override
### `com.gku.actioncam.amba.ui.stream.BroadcastFragment$PlatFormInfo`
L179 · [class] public static final PlatFormInfo · `com/gku/actioncam/amba/ui/stream/BroadcastFragment.java`
注解：

字段/常量（3）：
- `int iconRes`  L180
- `String name`  L181
- `boolean reachable`  L182

方法（4）：
- `int getIconRes()`  L184
- `String getName()`  L188
- `boolean getReachable()`  L192
- `public PlatFormInfo(int i, int i2, String name, boolean z)`  L196
    - 体内字面量："name"
### `com.gku.actioncam.amba.ui.stream.BroadcastRTMPFragment2`
L39 · [class] public final BroadcastRTMPFragment2 · extends `BaseFragment implements StreamConfigActivity.OnFragmentBackPressed, BLELiveCallback` · implements `StreamConfigActivity.OnFragmentBackPressed, BLELiveCallback` · `com/gku/actioncam/amba/ui/stream/BroadcastRTMPFragment2.java`
注解：

字段/常量（35）：
- `EditText et_rtmp`  L40
- `boolean isNewLive`  L41
- `RadioGroup rg_bs`  L42
- `RadioGroup rg_fps`  L43
- `RadioGroup rg_resolution`  L44
- `RTMPBean rtmpBean`  L45
- `DeviceAddItem selectDevice`  L46
- `ActivityResultLauncher<Intent> selectDeviceLaunch`  L47
- `ActivityResultLauncher<Intent> selectWifiLaunch`  L48
- `Button streamStart`  L49
- `TextView tvConnectHint`  L50
- `TextView tvSelectDevice`  L51
- `TextView tvSwtichDevice`  L52
- `String ssid = "<binary/metadata>"`  L53
- `String pwd = "<binary/metadata>"`  L54
- `String pinCode = "<binary/metadata>"`  L55
- `TextView textView = this.tvConnectHint`  L95
- `Button button = this.streamStart`  L109
- `EditText editText = this.et_rtmp`  L123
- `TextView textView = this.tvSelectDevice`  L137
- `TextView textView = this.tvSwtichDevice`  L151
- `RadioGroup radioGroup = this.rg_resolution`  L165
- `RadioGroup radioGroup = this.rg_fps`  L179
- `RadioGroup radioGroup = this.rg_bs`  L193
- `String stringExtra`  L243
- `String stringExtra2`  L244
- `String str = "<binary/metadata>"`  L247
- `RTMPBean rTMPBean2 = this.rtmpBean`  L325
- `RTMPBean rTMPBean3 = this.rtmpBean`  L329
- `RTMPBean rTMPBean4 = this.rtmpBean`  L333
- `RTMPBean rTMPBean5 = BroadcastRTMPFragment2.this.rtmpBean`  L349
- `BroadcastRTMPFragment2 broadcastRTMPFragment2 = BroadcastRTMPFragment2.this`  L351
- `ComponentActivity componentActivity = broadcastRTMPFragment2.activity`  L391
- `String[] strArr = {PermissionUtils.LOCATION}`  L393
- `ComponentActivity componentActivity2 = broadcastRTMPFragment2.activity`  L394

方法（43）：
- `void onDeviceConnectStatus(int status)`  L58 @Override
- `void onPinSuccess(String deviceName, boolean isSupportBlueLive)`  L62 @Override
    - 体内字面量："deviceName"
- `void onSendFirstCmd()`  L67 @Override
- `void onStartWifiSuccess(String status)`  L71 @Override
    - 体内字面量："status"
- `public BroadcastRTMPFragment2()`  L75
- `void onActivityResult(Object obj)`  L78 @Override
    - 体内字面量："registerForActivityResult(...)"
- `void onActivityResult(Object obj)`  L86 @Override
    - 体内字面量："registerForActivityResult(...)"
- `TextView getTvConnectHint()`  L94
- `void setTvConnectHint(TextView textView)`  L103
    - 体内字面量："<set-?>"
- `Button getStreamStart()`  L108
- `void setStreamStart(Button button)`  L117
    - 体内字面量："<set-?>"
- `EditText getEt_rtmp()`  L122
- `void setEt_rtmp(EditText editText)`  L131
    - 体内字面量："<set-?>"
- `TextView getTvSelectDevice()`  L136
- `void setTvSelectDevice(TextView textView)`  L145
    - 体内字面量："<set-?>"
- `TextView getTvSwtichDevice()`  L150
- `void setTvSwtichDevice(TextView textView)`  L159
    - 体内字面量："<set-?>"
- `RadioGroup getRg_resolution()`  L164
- `void setRg_resolution(RadioGroup radioGroup)`  L173
    - 体内字面量："<set-?>"
- `RadioGroup getRg_fps()`  L178
- `void setRg_fps(RadioGroup radioGroup)`  L187
    - 体内字面量："<set-?>"
- `RadioGroup getRg_bs()`  L192
- `void setRg_bs(RadioGroup radioGroup)`  L201
    - 体内字面量："<set-?>"
- `ActivityResultLauncher<Intent> getSelectDeviceLaunch()`  L206
- `void selectDeviceLaunch$lambda$1(BroadcastRTMPFragment2 broadcastRTMPFragment2, ActivityResult activityResult)`  L211
    - 体内字面量："ARGUMENT_DATA" · "null cannot be cast to non-null type com.gku.actioncam.amba.ui.stream.StreamConfigActivity"
- `ActivityResultLauncher<Intent> getSelectWifiLaunch()`  L237
- `void selectWifiLaunch$lambda$2(BroadcastRTMPFragment2 broadcastRTMPFragment2, ActivityResult activityResult)`  L242
- `void onCreate(Bundle b)`  L261 @Override
- `void onDestroy()`  L267 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L273 @Override
    - 体内字面量："inflater" · "inflate(...)"
- `void onViewCreated(View view, Bundle savedInstanceState)`  L281 @Override
    - 体内字面量："view"
- `void onClick(View view2)`  L292 @Override
- `void onClick(View view2)`  L299 @Override
- `void onClick(View view2)`  L305 @Override
- `void onClick(View view2)`  L311 @Override
- `void onClick(View p0)`  L341 @Override
    - 体内字面量："720" · "1080" · "25" · "30"
- `void onViewCreated$lambda$3(BroadcastRTMPFragment2 broadcastRTMPFragment2, View view)`  L375
- `void onViewCreated$lambda$4(BroadcastRTMPFragment2 broadcastRTMPFragment2, View view)`  L380
- `void onViewCreated$lambda$5(BroadcastRTMPFragment2 broadcastRTMPFragment2, View view)`  L385
- `void onViewCreated$lambda$6(final BroadcastRTMPFragment2 broadcastRTMPFragment2, View view)`  L390
- `void onPermissionHave()`  L401 @Override
- `boolean onBackPressed()`  L414 @Override
- `void onStartLiveSuccess()`  L420 @Override
    - 体内字面量："broadcast_view"
### `com.gku.actioncam.amba.ui.stream.CameraPreviewView`
L22 · [class] public final CameraPreviewView · extends `TextureView` · `com/gku/actioncam/amba/ui/stream/CameraPreviewView.java`
注解：

字段/常量（11）：
- `CameraDevice cameraDevice`  L23
- `CameraManager cameraManager`  L24
- `HandlerThread cameraThread`  L25
- `CameraCaptureSession captureSession`  L26
- `CameraCaptureSession cameraCaptureSession = this.captureSession`  L64
- `CameraDevice cameraDevice = this.cameraDevice`  L68
- `String str`  L77
- `String[] strArr = cameraIdList`  L80
- `int length = strArr.length`  L81
- `int i = 0`  L82
- `String str2 = str`  L98

方法（18）：
- `public CameraPreviewView(Context context)`  L29
    - 体内字面量："context" · "camera" · "null cannot be cast to non-null type android.hardware.camera2.CameraManager" · "CameraThread"
- `boolean onSurfaceTextureDestroyed(SurfaceTexture surface)`  L40 @Override
    - 体内字面量："surface"
- `void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height)`  L46 @Override
    - 体内字面量："surface"
- `void onSurfaceTextureUpdated(SurfaceTexture surface)`  L51 @Override
    - 体内字面量："surface"
- `void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height)`  L56 @Override
    - 体内字面量："surface"
- `void release()`  L63
- `void openFrontCamera()`  L76
- `throw new IllegalStateException( 33 )`  L100
- `void onOpened(CameraDevice device)`  L106 @Override
    - 体内字面量："device"
- `void onDisconnected(CameraDevice device)`  L113 @Override
    - 体内字面量："device"
- `void onError(CameraDevice device, int error)`  L120 @Override
    - 体内字面量："device"
- `throw new RuntimeException( 37  + error)`  L122
- `throw new RuntimeException( 38 , e)`  L126
- `throw new RuntimeException( 39 , e2)`  L128
- `void createPreviewSession(final CameraDevice camera, final Handler cameraHandler)`  L133
- `void onConfigured(CameraCaptureSession session)`  L142 @Override
    - 体内字面量："session" · "build(...)"
- `void onConfigureFailed(CameraCaptureSession session)`  L153 @Override
    - 体内字面量："session"
- `throw new RuntimeException( 43 )`  L155
### `com.gku.actioncam.amba.ui.stream.dialog.BluePinAddDialogFragment`
L17 · [class] public final BluePinAddDialogFragment · extends `BottomSheetDialogFragment` · `com/gku/actioncam/amba/ui/stream/dialog/BluePinAddDialogFragment.java`
注解：

方法（2）：
- `void onCreate(Bundle savedInstanceState)`  L19 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L24 @Override
    - 体内字面量："inflater" · "inflate(...)"
### `com.gku.actioncam.amba.ui.stream.DouyinStreamController`
L41 · [class] public final DouyinStreamController · `com/gku/actioncam/amba/ui/stream/DouyinStreamController.java`
注解：

字段/常量（27）：
- `String TAG`  L42
- `Activity mActivity`  L43
- `BroadcastStatus mBroadcastStatus`  L44
- `ArrayList<BroadcastStatusObserver> mBroadcastStatusObserverList`  L45
- `boolean mNetWorkStatus`  L46
- `ArrayList<NetWorkStatusObserver> mNetWorkStatusObserverList`  L47
- `StartLiveResp mResp`  L48
- `int CODE_ERROR_DOUYIN_UNINIT = -10001`  L52
- `int CODE_ERROR_DOUYIN_UNAUTH = -10002`  L53
- `int CODE_ERROR_DOUYIN_STARTBROADCAST_RETURN_NULL = -10003`  L54
- `int CODE_ERROR_DOUYIN_RTMPPUSHURL_ERROR = SocketErrorCode.BROKEN_PIPE`  L55
- `Callback callback2 = callback`  L164
- `Callback callback3 = callback`  L169
- `Callback callback2 = callback`  L181
- `int i = CODE_ERROR_DOUYIN_UNINIT`  L274
- `StartLiveResp startLiveResp = DouyinStreamController.this.mResp`  L300
- `StartStreamCallback startStreamCallback = callback`  L302
- `DouyinStreamController douyinStreamController = DouyinStreamController.this`  L303
- `int i2 = startLiveResp.statusCode`  L306
- `String prompts = startLiveResp.prompts`  L307
- `String str = startLiveResp.rtmpPushUrl`  L314
- `String rtmpPushUrl = startLiveResp.rtmpPushUrl`  L317
- `StartStreamCallback startStreamCallback2 = callback`  L335
- `int i2 = CODE_ERROR_DOUYIN_UNAUTH`  L345
- `StartLiveResp startLiveResp = DouyinStreamController.this.mResp`  L356
- `DouyinStreamController douyinStreamController = DouyinStreamController.this`  L358
- `StartLiveResp startLiveResp = this.mResp`  L442

方法（34）：
- `public DouyinStreamController(Activity activity)`  L130
    - 体内字面量："activity" · "DouyinStreamController"
- `void initBroadcast(final Callback callback)`  L139
    - 体内字面量："åå¤åå§å" · "å·²åå§å" · "780679" · "XTU GO"
- `void onInitializeSuccess()`  L160 @Override
- `void onInitializeFail(int msg)`  L179 @Override
    - 体内字面量："åå§åå¤±è´¥ï¼"
- `void login()`  L191
    - 体内字面量："å·²æææå"
- `void onSuccess()`  L198 @Override
    - 体内字面量："æææå"
- `void onFailed(int p0, String p1)`  L204 @Override
    - 体内字面量："ææå¤±è´¥ï¼" · "  ????   " · ":"
- `boolean loginForNow()`  L212
- `void loginOut()`  L220
- `void getUserInfo()`  L225
- `void run()`  L228 @Override
- `void getUserInfo$lambda$2(final DouyinStreamController douyinStreamController)`  L235
- `void run()`  L238 @Override
- `void run()`  L245 @Override
- `void getUserInfo$lambda$2$lambda$0(DouyinStreamController douyinStreamController)`  L252
    - 体内字面量："å¼å§è·åå¤´å"
- `void getUserInfo$lambda$2$lambda$1(AccountInfoResp accountInfoResp, DouyinStreamController douyinStreamController)`  L257
    - 体内字面量："è·åå¤´åæµç§°æå: " · "å½åä¸ºæªææç¶æï¼éæ°å¼å§ææ" · "è·åå¤´åæµç§°å¤±è´¥ï¼è¯·æ±å¤±è´¥" · "è·åå¤´åæµç§°å¤±è´¥ï¼è¯·æ±å¤±è´¥"
- `void startBroadcast(final StartStreamCallback callback)`  L271
- `void onInterrupted()`  L285 @Override
- `Object runThread()`  L289 @Override
- `void run_UIThread(Object result)`  L298 @Override
- `void endBroadcast()`  L352
- `void run()`  L355 @Override
- `Pair<CamType, LiveAngle> getBroadcastType()`  L370
- `void toast(String msg)`  L374
- `ArrayList<BroadcastStatusObserver> getMBroadcastStatusObserverList()`  L378
- `void onBroadcastStatusChanged(BroadcastStatus broadcastStatus)`  L382
    - 体内字面量："broadcastStatus" · "iterator(...)" · "next(...)"
- `void subscribe(BroadcastStatusObserver broadcastStatusObserver)`  L397
    - 体内字面量："broadcastStatusObserver"
- `void unsubscribe(BroadcastStatusObserver broadcastStatusObserver)`  L403
    - 体内字面量："broadcastStatusObserver"
- `ArrayList<NetWorkStatusObserver> getMNetWorkStatusObserverList()`  L408
- `void onNetWorkStatusChanged(boolean netWorkStatus)`  L412
    - 体内字面量："iterator(...)" · "next(...)"
- `void subscribe(NetWorkStatusObserver netWorkStatusObserver)`  L426
    - 体内字面量："netWorkStatusObserver"
- `void unsubscribe(NetWorkStatusObserver netWorkStatusObserver)`  L432
    - 体内字面量："netWorkStatusObserver"
- `void unsubscribeAll()`  L437
- `String getRoomId()`  L441
### `com.gku.actioncam.amba.ui.stream.DouyinStreamController$BroadcastStatus`
L59 · [enum] public BroadcastStatus · `com/gku/actioncam/amba/ui/stream/DouyinStreamController.java`
注解：

枚举常量（3）：
- `NOT_INIT()`  L60
- `NOT_ATH()`  L61
- `ATH()`  L62

方法（1）：
- `EnumEntries<BroadcastStatus> getEntries()`  L66
### `com.gku.actioncam.amba.ui.stream.DouyinStreamController$BroadcastStatusObserver`
L73 · [interface] public BroadcastStatusObserver · `com/gku/actioncam/amba/ui/stream/DouyinStreamController.java`
注解：

方法（1）：
- `void broadcastStatusChanged(BroadcastStatus broadcastStatus)`  L74
### `com.gku.actioncam.amba.ui.stream.DouyinStreamController$Callback`
L79 · [interface] public Callback · `com/gku/actioncam/amba/ui/stream/DouyinStreamController.java`
注解：

方法（2）：
- `void onFail(int i, String msg)`  L80
- `void onSuccess(BroadcastStatus status)`  L82
### `com.gku.actioncam.amba.ui.stream.DouyinStreamController$Companion`
L101 · [class] public static final Companion · `com/gku/actioncam/amba/ui/stream/DouyinStreamController.java`
注解：

方法（7）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L102
- `private Companion()`  L106
- `int getCODE_ERROR_DOUYIN_UNINIT()`  L109
- `int getCODE_ERROR_DOUYIN_UNAUTH()`  L113
- `int getCODE_ERROR_DOUYIN_STARTBROADCAST_RETURN_NULL()`  L117
- `int getCODE_ERROR_DOUYIN_RTMPPUSHURL_ERROR()`  L121
- `boolean turnOffBroadcast(String roomId)`  L125
### `com.gku.actioncam.amba.ui.stream.DouyinStreamController$NetControll`
L451 · [class] public static final NetControll · `com/gku/actioncam/amba/ui/stream/DouyinStreamController.java`
注解：

字段/常量（3）：
- `boolean connected`  L461
- `DouyinStreamController mDouyinStreamController`  L462
- `DouyinStreamController douyinStreamController = this.mDouyinStreamController`  L506

方法（6）：
- `Object invoke()`  L457 @Override
- `NetControll me_delegate$lambda$0()`  L484
- `boolean getNetWorkStatus()`  L488
- `void setDouyinStreamController(DouyinStreamController douyinStreamController)`  L492
    - 体内字面量："douyinStreamController"
- `void clearDouyinStreamController()`  L500
- `void transfer(boolean netStatus)`  L504
### `com.gku.actioncam.amba.ui.stream.DouyinStreamController$NetControll$Companion`
L466 · [class] public static final Companion · `com/gku/actioncam/amba/ui/stream/DouyinStreamController.java`
注解：

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L467
- `private Companion()`  L471
- `NetControll getMe()`  L474
- `NetControll getInstance()`  L478
### `com.gku.actioncam.amba.ui.stream.DouyinStreamController$NetWorkStatusObserver`
L87 · [interface] public NetWorkStatusObserver · `com/gku/actioncam/amba/ui/stream/DouyinStreamController.java`
注解：

方法（1）：
- `void netWorkStatusChanged(boolean netWorkStatus)`  L88
### `com.gku.actioncam.amba.ui.stream.DouyinStreamController$StartStreamCallback`
L93 · [interface] public StartStreamCallback · `com/gku/actioncam/amba/ui/stream/DouyinStreamController.java`
注解：

方法（2）：
- `void onFail(int i, String msg)`  L94
- `void onSuccess(String msg)`  L96
### `com.gku.actioncam.amba.ui.stream.MSG_TYPE`
L5 · [enum] MSG_TYPE · `com/gku/actioncam/amba/ui/stream/MSG_TYPE.java`

枚举常量（4）：
- `GET_FILE()`  L6
- `GET_FAILED()`  L7
- `RECV_FILE()`  L8
- `RECV_FAILED()`  L9
### `com.gku.actioncam.amba.ui.stream.RTMPBean`
L7 · [class] public RTMPBean · implements `Parcelable` · `com/gku/actioncam/amba/ui/stream/RTMPBean.java`

字段/常量（8）：
- `int bitrate`  L21
- `String fps`  L22
- `String live_type`  L23
- `String pwd`  L24
- `String res`  L25
- `String roomId`  L26
- `String rtmp_url`  L27
- `String ssid`  L28

方法（24）：
- `RTMPBean createFromParcel(Parcel in)`  L11 @Override
- `RTMPBean[] newArray(int size)`  L17 @Override
- `int describeContents()`  L31 @Override
- `public RTMPBean()`  L35
- `public RTMPBean(String ssid, String pwd, String live_type, String res, String fps, int bitrate, String rtmp_url, String roomId)`  L38
- `public RTMPBean(Parcel in)`  L49
- `void writeToParcel(Parcel dest, int flags)`  L61 @Override
- `String getSsid()`  L72
- `void setSsid(String ssid)`  L76
- `String getPwd()`  L80
- `void setPwd(String pwd)`  L84
- `String getLive_type()`  L88
- `void setLive_type(String live_type)`  L92
- `String getRes()`  L96
- `void setRes(String res)`  L100
- `String getFps()`  L104
- `void setFps(String fps)`  L108
- `int getBitrate()`  L112
- `void setBitrate(int bitrate)`  L116
- `String getRtmp_url()`  L120
- `void setRtmp_url(String rtmp_url)`  L124
- `String getRoomId()`  L128
- `void setRoomId(String roomId)`  L132
- `String toString()`  L136
    - 体内字面量："RTMPBean{ssid='" · "', pwd='" · "', live_type='" · "', res='" · "', fps='" · "', bitrate='" · "', rtmp_url='" · "', roomId='" · "'}"
### `com.gku.actioncam.amba.ui.stream.SelectLiveDeviceActivity`
L23 · [class] public final SelectLiveDeviceActivity · extends `BaseBdingActivity<ActivitySelectLiveDeviceBinding>` · `com/gku/actioncam/amba/ui/stream/SelectLiveDeviceActivity.java`
注解：

字段/常量（6）：
- `String ARGUMENT_DATA = "ARGUMENT_DATA"`  L24
- `SelectLiveDeviceAdapter deviceAdapter`  L25
- `SelectLiveDeviceAdapter selectLiveDeviceAdapter = this.deviceAdapter`  L51
- `SelectLiveDeviceAdapter selectLiveDeviceAdapter = selectLiveDeviceActivity.deviceAdapter`  L72
- `SelectLiveDeviceAdapter selectLiveDeviceAdapter = selectLiveDeviceActivity.deviceAdapter`  L80
- `SelectLiveDeviceAdapter selectLiveDeviceAdapter = this.deviceAdapter`  L116

方法（10）：
- `int getLayoutId()`  L29 @Override
- `void initView(Bundle saveInstanceState)`  L34 @Override
- `void initListener()`  L43 @Override
- `void onClick(View view)`  L47 @Override
- `void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i)`  L55 @Override
- `void onClick(View view)`  L62 @Override
- `void initListener$lambda$5$lambda$3(SelectLiveDeviceActivity selectLiveDeviceActivity, BaseQuickAdapter adapter, View view, int i)`  L69
    - 体内字面量："adapter" · "view"
- `void initListener$lambda$5$lambda$4(SelectLiveDeviceActivity selectLiveDeviceActivity, View view)`  L79
- `void loadData()`  L106 @Override
- `void initDeviceList()`  L110
### `com.gku.actioncam.amba.ui.stream.SelectLiveWifiActivity`
L40 · [class] public final SelectLiveWifiActivity · extends `BaseBdingActivity<ActivitySelectLiveWifiBinding>` · `com/gku/actioncam/amba/ui/stream/SelectLiveWifiActivity.java`
注解：

字段/常量（26）：
- `String ARGUMENT_ISNEWLIVE = "ARGUMENT_ISNEWLIVE"`  L41
- `String ARGUMENT_PWD = "ARGUMENT_PWD"`  L42
- `String ARGUMENT_SSID = "ARGUMENT_SSID"`  L43
- `boolean isNewLive`  L44
- `boolean isShowSoftInput`  L45
- `WifiListController mWifiListController`  L46
- `ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener`  L47
- `ActivityResultLauncher<Intent> resultLauncher`  L48
- `SimpleAdapter<ScanResult> simpleAdapter`  L49
- `View viewDecor`  L50
- `BroadcastReceiver wifiScanReceiver`  L51
- `String ssid = "<binary/metadata>"`  L52
- `String pwd = "<binary/metadata>"`  L53
- `SimpleAdapter<ScanResult> simpleAdapter = this.simpleAdapter`  L80
- `String stringExtra`  L95
- `SelectLiveWifiActivity selectLiveWifiActivity = this.this$0`  L156
- `View view = selectLiveWifiActivity.viewDecor`  L157
- `WifiListController wifiListController = null`  L176
- `WifiListController wifiListController2 = this.mWifiListController`  L179
- `WifiListController wifiListController3 = this.mWifiListController`  L185
- `View view = this.viewDecor`  L236
- `View view = selectLiveWifiActivity.viewDecor`  L273
- `View view2 = null`  L274
- `View view3 = selectLiveWifiActivity.viewDecor`  L280
- `WifiListController wifiListController = SelectLiveWifiActivity.this.mWifiListController`  L301
- `BroadcastReceiver broadcastReceiver = this.wifiScanReceiver`  L315

方法（25）：
- `int getSignalLevel(int rssi)`  L55
- `public SelectLiveWifiActivity()`  L68
- `void onActivityResult(Object obj)`  L71 @Override
    - 体内字面量："registerForActivityResult(...)"
- `SimpleAdapter<ScanResult> getSimpleAdapter()`  L79
- `void setSimpleAdapter(SimpleAdapter<ScanResult> simpleAdapter)`  L88
    - 体内字面量："<set-?>"
- `void resultLauncher$lambda$1(SelectLiveWifiActivity selectLiveWifiActivity, ActivityResult activityResult)`  L94
- `int getLayoutId()`  L109 @Override
- `void initView(Bundle saveInstanceState)`  L114 @Override
- `void bindDataToView(BaseViewHolder baseViewHolder, int i, ScanResult scanResult, List list)`  L133 @Override
- `int getItemLayoutID(int position, ScanResult bean)`  L138 @Override
- `void bindDataToView2(BaseViewHolder holder, int position, ScanResult bean, List<Object> payloads)`  L143
    - 体内字面量："holder" · "bean" · "payloads"
- `void onItemClick(BaseViewHolder holder, int position, ScanResult bean)`  L152 @Override
    - 体内字面量："holder" · "bean"
- `void onReceive(Context context, Intent intent2)`  L173 @Override
    - 体内字面量："context" · "intent"
- `void hideKeyboard(View view)`  L201
    - 体内字面量："view" · "input_method" · "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
- `void initListener()`  L209 @Override
- `void onClick(View view)`  L213 @Override
- `void onClick(View view)`  L219 @Override
- `void onClick(View view)`  L225 @Override
- `void onGlobalLayout()`  L232 @Override
- `void initListener$lambda$9$lambda$5(SelectLiveWifiActivity selectLiveWifiActivity, View view)`  L245
- `void initListener$lambda$9$lambda$7(ActivitySelectLiveWifiBinding activitySelectLiveWifiBinding, SelectLiveWifiActivity selectLiveWifiActivity, View view)`  L250
- `void initListener$lambda$9$lambda$8(SelectLiveWifiActivity selectLiveWifiActivity)`  L271
- `void loadData()`  L297 @Override
- `void onDoNet(int mode)`  L300 @Override
- `void onDestroy()`  L312 @Override
### `com.gku.actioncam.amba.ui.stream.StreamConfigActivity`
L23 · [class] public final StreamConfigActivity · extends `BaseBTPopupActivity` · `com/gku/actioncam/amba/ui/stream/StreamConfigActivity.java`
注解：

字段/常量（6）：
- `ConnectivityManager connectivityManager`  L24
- `String openRoomId`  L25
- `String TAG = "StreamConfigActivity"`  L26
- `StreamConfigActivity streamConfigActivity = this`  L55
- `ConnectivityManager connectivityManager = this.this$0.connectivityManager`  L90
- `ConnectivityManager connectivityManager = this.connectivityManager`  L105

方法（11）：
- `void jumpToPreviewActivity()`  L36 @Override
- `void onCreate(Bundle savedInstanceState)`  L40 @Override
    - 体内字面量："connectivity" · "null cannot be cast to non-null type android.net.ConnectivityManager" · "broadcast_view" · "initClickListeners" · "onCreate: "
- `void onDestroy()`  L54 @Override
- `void onBackPressed()`  L64 @Override
    - 体内字面量："next(...)"
- `DouyinStreamController getMStreamController()`  L79
- `void bindToMobileData()`  L83
- `void onAvailable(Network network)`  L87 @Override
    - 体内字面量："network"
- `void onUnavailable()`  L101 @Override
    - 体内字面量："Network" · "Cellular network unavailable"
- `void onDismiss()`  L112 @Override
    - 体内字面量："getSupportFragmentManager(...)"
- `Fragment getCurrentFragmentByShowHide(FragmentManager fragmentManager)`  L122
    - 体内字面量："fragmentManager" · "getFragments(...)"
- `void startBluScan(boolean autoLive)`  L134
### `com.gku.actioncam.amba.ui.stream.StreamConfigActivity$OnFragmentBackPressed`
L31 · [interface] public OnFragmentBackPressed · `com/gku/actioncam/amba/ui/stream/StreamConfigActivity.java`
注解：

方法（1）：
- `boolean onBackPressed()`  L32
### `com.gku.actioncam.amba.ui.stream.StreamingActivity`
L27 · [class] public final StreamingActivity · extends `BaseXtuGoActivity` · `com/gku/actioncam/amba/ui/stream/StreamingActivity.java`
注解：

字段/常量（18）：
- `String TAG = "StreamingActivity"`  L28
- `boolean isRunning`  L30
- `ImageView mBtnBack`  L31
- `Button mBtnEnd`  L32
- `TextView mTvTimer`  L33
- `long startTime`  L34
- `Runnable timerRunnable`  L35
- `ImageView imageView = null`  L46
- `TextView textView = this.mTvTimer`  L146
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L151
- `long j = 60`  L152
- `StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE`  L155
- `Handler handler = this.handler`  L166
- `Runnable runnable = this.timerRunnable`  L167
- `Handler handler = this.handler`  L177
- `Runnable runnable = this.timerRunnable`  L178
- `Handler handler = this.handler`  L194
- `Runnable runnable = this.timerRunnable`  L195

方法（10）：
- `void onCreate(Bundle savedInstanceState)`  L38 @Override
- `void onClick(View p0)`  L53 @Override
    - 体内字面量："mBtnBack"
- `void onClick(View p0)`  L66 @Override
- `void run()`  L72 @Override
    - 体内字面量："com/gku/actioncam/amba/ui/stream/StreamingActivity$closeLive$1" · "Lcom/gku/base/dialog/DialogAsk$Callback;" · "onConfirmed" · "app_XTUGORelease"
- `void closeLive(RTMPBean sendBufWithRTMP)`  L136
    - 体内字面量："getString(...)"
- `void updateUI()`  L144
- `void startTimer()`  L161
- `void pauseTimer()`  L175
- `void resetTimer()`  L186
- `void onDestroy()`  L192 @Override
### `com.gku.actioncam.amba.ui.stream.StreamingActivity$AnonymousClass1`
L88 · [class] public static final AnonymousClass1 · implements `DialogAsk.Callback` · `com/gku/actioncam/amba/ui/stream/StreamingActivity.java`
注解：

字段/常量（5）：
- `RTMPBean $sendBufWithRTMP`  L89
- `StreamingActivity this$0`  L90
- `StreamingActivity streamingActivity = this.this$0`  L101
- `RTMPBean rTMPBean = this.$sendBufWithRTMP`  L105
- `StreamingActivity streamingActivity2 = this.this$0`  L106

方法（5）：
- `void onConfirmed()`  L98 @Override
- `void run()`  L109 @Override
- `void onConfirmed$lambda$1(RTMPBean rTMPBean, final StreamingActivity streamingActivity)`  L117
- `void run()`  L121 @Override
- `void onConfirmed$lambda$1$lambda$0(StreamingActivity streamingActivity)`  L129
### `com.gku.actioncam.amba.ui.stream.TCP_MSG_S`
L8 · [class] TCP_MSG_S · `com/gku/actioncam/amba/ui/stream/TCP_MSG_S.java`

字段/常量（3）：
- `int s32Cmd`  L9
- `int s32DataLen`  L10
- `byte[] szData = new byte[64]`  L11

方法（2）：
- `byte[] toBytes()`  L16
- `TCP_MSG_S fromBytes(byte[] data)`  L25
### `com.gku.actioncam.amba.ui.stream.TCPClient`
L16 · [class] public TCPClient · `com/gku/actioncam/amba/ui/stream/TCPClient.java`

字段/常量（1）：
- `byte[] bArr = new byte[72]`  L73

方法（9）：
- `String format(RTMPBean rtmpBean)`  L22
- `String format(String ssid, String pwd, String live_type, String res, String fps, String url)`  L26
    - 体内字面量："ssid:%s;pwd:%s;live_type:%s;res:%s;fps:%s;rtmp_url:%s;"
- `void main(RTMPBean rtmpBean)`  L30
- `void main(RTMPBean rtmpBean, TCPClientCallback callback)`  L34
- `void main(String sendBuf)`  L38
- `void main(String sendBuf, final TCPClientCallback callback)`  L42
- `void success()`  L46 @Override
- `void failure(int code)`  L51 @Override
- `void onChannelEvent(int type, Object param, String... array)`  L56 @Override
    - 体内字面量："initClickListeners" · "192.168.0.1"
### `com.gku.actioncam.amba.ui.stream.TCPClient$TCPClientCallback`
L18 · [interface] public TCPClientCallback · `com/gku/actioncam/amba/ui/stream/TCPClient.java`

方法（1）：
- `void onSetupStreamResult(int code)`  L19
### `com.gku.actioncam.amba.ui.stream.wifi.WIFIListActivity`
L33 · [class] public final WIFIListActivity · extends `BaseXtuGoActivity` · `com/gku/actioncam/amba/ui/stream/wifi/WIFIListActivity.java`
注解：

字段/常量（17）：
- `int REQUEST_CODE_LOCATION_PERMISSION = 1001`  L34
- `String TAG = "WiFiScan"`  L35
- `String TAG_WIFI_RETURN = "TAG_WIFI_RETURN"`  L36
- `String TAG_WIFI_SSID = "TAG_WIFI_SELECTED"`  L37
- `WifiListController mWifiListController`  L38
- `SimpleAdapter<ScanResult> simpleAdapter`  L39
- `BroadcastReceiver wifiScanReceiver`  L40
- `SimpleAdapter<ScanResult> simpleAdapter = this.simpleAdapter`  L56
- `WifiListController wifiListController = null`  L123
- `WifiListController wifiListController2 = this.mWifiListController`  L126
- `WifiListController wifiListController3 = this.mWifiListController`  L132
- `ComponentActivity componentActivity = WIFIListActivity.this.activity`  L149
- `String[] strArr = {PermissionUtils.LOCATION}`  L151
- `ComponentActivity componentActivity2 = WIFIListActivity.this.activity`  L152
- `WIFIListActivity wIFIListActivity = WIFIListActivity.this`  L153
- `WifiListController wifiListController = this.this$0.mWifiListController`  L161
- `BroadcastReceiver broadcastReceiver = this.wifiScanReceiver`  L177

方法（13）：
- `int getSignalLevel(int rssi)`  L42
- `SimpleAdapter<ScanResult> getSimpleAdapter()`  L55
- `void setSimpleAdapter(SimpleAdapter<ScanResult> simpleAdapter)`  L64
    - 体内字面量："<set-?>"
- `void onCreate(Bundle savedInstanceState)`  L70 @Override
- `void onClick(View view)`  L75 @Override
- `void bindDataToView(BaseViewHolder baseViewHolder, int i, ScanResult scanResult, List list)`  L81 @Override
- `int getItemLayoutID(int position, ScanResult bean)`  L86 @Override
- `void bindDataToView2(BaseViewHolder holder, int position, ScanResult bean, List<Object> payloads)`  L91
    - 体内字面量："holder" · "bean" · "payloads"
- `void onItemClick(BaseViewHolder holder, int position, ScanResult bean)`  L100 @Override
    - 体内字面量："holder" · "bean" · "TAG_WIFI_RETURN" · "findViewById(...)" · "findViewById(...)"
- `void onReceive(Context context, Intent intent)`  L119 @Override
    - 体内字面量："context" · "intent" · "onReceive: "
- `void onDoNet(int mode)`  L148 @Override
- `void onPermissionHave()`  L160 @Override
- `void onDestroy()`  L174 @Override
### `com.gku.actioncam.amba.ui.stream.wifi.WifiListController`
L29 · [class] public final WifiListController · `com/gku/actioncam/amba/ui/stream/wifi/WifiListController.java`
注解：

字段/常量（7）：
- `String TAG`  L30
- `AppCompatActivity activity`  L31
- `WifiManager wifiManager`  L32
- `String str = "<binary/metadata>"`  L47
- `ScanResult scanResult = next`  L51
- `ArrayList scanResults`  L68
- `int i = size - 1`  L78

方法（7）：
- `public WifiListController(AppCompatActivity activity)`  L34
    - 体内字面量："activity" · "WifiListController" · "wifi" · "null cannot be cast to non-null type android.net.wifi.WifiManager"
- `void saveWifiInfo(ArrayList<ScanResult> list)`  L43
    - 体内字面量："list" · "iterator(...)"
- `boolean startScan()`  L63
- `ArrayList<ScanResult> getScanResult(AppCompatActivity activity)`  L67
- `int compare(T t, T t2)`  L95 @Override
- `boolean cacheOutOfDate()`  L115
- `ArrayList<ScanResult> getLocalWifiInfo()`  L122
    - 体内字面量："getLastWIFIList(...)" · "getWifiInfo :" · "æ¬å°ä¹æ¿ä¸å°æ°æ®å" · "ä»æ¬å°æ¢å¤å°æ°æ®ï¼æå"
### `com.gku.actioncam.amba.ui.stream.wifi.WIFITypeinActivity`
L16 · [class] public final WIFITypeinActivity · extends `BaseXtuGoActivity` · `com/gku/actioncam/amba/ui/stream/wifi/WIFITypeinActivity.java`
注解：

字段/常量（2）：
- `String TAG = "WIFITypein"`  L17
- `String TAG_WIFI_RETURN = "TAG_WIFI_RETURN"`  L18

方法（4）：
- `void onCreate(Bundle savedInstanceState)`  L21 @Override
- `void onClick(View view)`  L26 @Override
- `void onClick(View view)`  L32 @Override
- `void onCreate$lambda$2(WIFITypeinActivity wIFITypeinActivity, View view)`  L39
    - 体内字面量："TAG_WIFI_RETURN" · ",,"