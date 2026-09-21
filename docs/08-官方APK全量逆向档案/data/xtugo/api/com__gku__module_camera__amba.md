# XTU GO — 类与成员明细：com.gku.module_camera.amba

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 42 个文件 / 71 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.module_camera.amba.bean.AmbaFileTagBean`
L4 · [class] public AmbaFileTagBean · `com/gku/module_camera/amba/bean/AmbaFileTagBean.java`

字段/常量（3）：
- `FileListInfoResponseBean bean`  L5
- `String clazz`  L6
- `boolean thumb`  L7

方法（6）：
- `String getClazz()`  L9
- `void setClazz(String str)`  L13
- `FileListInfoResponseBean getBean()`  L17
- `void setBean(FileListInfoResponseBean fileListInfoResponseBean)`  L21
- `boolean isThumb()`  L25
- `void setThumb(boolean z)`  L29
### `com.gku.module_camera.amba.bean.CameraInfoResponseBean`
L4 · [class] public CameraInfoResponseBean · extends `CmdResponseBean` · `com/gku/module_camera/amba/bean/CameraInfoResponseBean.java`

字段/常量（10）：
- `String hardversion`  L5
- `int model`  L6
- `String name`  L7
- `int networkstatus`  L8
- `int runtimes`  L9
- `String serialnum`  L10
- `String softversion`  L11
- `int startdate`  L12
- `int timeout`  L13
- `String type`  L14

方法（20）：
- `String getName()`  L16
- `void setName(String str)`  L20
- `String getSerialnum()`  L24
- `void setSerialnum(String str)`  L28
- `String getType()`  L32
- `void setType(String str)`  L36
- `int getNetworkstatus()`  L40
- `void setNetworkstatus(int i)`  L44
- `String getSoftversion()`  L48
- `void setSoftversion(String str)`  L52
- `String getHardversion()`  L56
- `void setHardversion(String str)`  L60
- `int getStartdate()`  L64
- `void setStartdate(int i)`  L68
- `int getRuntimes()`  L72
- `void setRuntimes(int i)`  L76
- `int getModel()`  L80
- `void setModel(int i)`  L84
- `int getTimeout()`  L88
- `void setTimeout(int i)`  L92
### `com.gku.module_camera.amba.bean.CancelPutFileRequestBean`
L4 · [class] public CancelPutFileRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/CancelPutFileRequestBean.java`

字段/常量（2）：
- `String param`  L5
- `int sent_size`  L6

方法（5）：
- `public CancelPutFileRequestBean(int i)`  L8
- `String getParam()`  L12
- `CancelPutFileRequestBean setParam(String str)`  L16
- `int getSent_size()`  L21
- `CancelPutFileRequestBean setSent_size(int i)`  L25
### `com.gku.module_camera.amba.bean.CmdRequestBean`
L4 · [class] public CmdRequestBean · `com/gku/module_camera/amba/bean/CmdRequestBean.java`

字段/常量（2）：
- `int msg_id`  L5
- `int token`  L6

方法（5）：
- `public CmdRequestBean(int i)`  L8
- `int getToken()`  L12
- `CmdRequestBean setToken(int i)`  L16
- `int getMsg_id()`  L21
- `void setMsg_id(int i)`  L25
### `com.gku.module_camera.amba.bean.CmdResponseBean`
L4 · [class] public CmdResponseBean · `com/gku/module_camera/amba/bean/CmdResponseBean.java`

字段/常量（2）：
- `int msg_id`  L5
- `int rval`  L6

方法（4）：
- `int getRval()`  L8
- `void setRval(int i)`  L12
- `int getMsg_id()`  L16
- `void setMsg_id(int i)`  L20
### `com.gku.module_camera.amba.bean.CurrentWorkModeResponseBean`
L6 · [class] public CurrentWorkModeResponseBean · `com/gku/module_camera/amba/bean/CurrentWorkModeResponseBean.java`

字段/常量（3）：
- `String _$VarWorkmode280`  L9 @SerializedName("var workmode")
- `int msg_id`  L10
- `int rval`  L11

方法（6）：
- `int getRval()`  L13
- `void setRval(int i)`  L17
- `int getMsg_id()`  L21
- `void setMsg_id(int i)`  L25
- `String get_$VarWorkmode280()`  L29
- `void set_$VarWorkmode280(String str)`  L33
### `com.gku.module_camera.amba.bean.FileListInfoResponseBean`
L7 · [class] public FileListInfoResponseBean · implements `Parcelable` · `com/gku/module_camera/amba/bean/FileListInfoResponseBean.java`

字段/常量（5）：
- `String createTime`  L21
- `long duration`  L22
- `String path`  L23
- `int rotate`  L24
- `long size`  L25

方法（16）：
- `FileListInfoResponseBean createFromParcel(Parcel parcel)`  L11 @Override
- `FileListInfoResponseBean[] newArray(int i)`  L17 @Override
- `int describeContents()`  L28 @Override
- `String getPath()`  L32
- `void setPath(String str)`  L36
- `String getCreateTime()`  L40
- `void setCreateTime(String str)`  L44
- `long getDuration()`  L48
- `void setDuration(long j)`  L52
- `long getSize()`  L56
- `void setSize(long j)`  L60
- `int getRotate()`  L64
- `void setRotate(int i)`  L68
- `public FileListInfoResponseBean()`  L72
- `void writeToParcel(Parcel parcel, int i)`  L76 @Override
- `protected FileListInfoResponseBean(Parcel parcel)`  L84
### `com.gku.module_camera.amba.bean.GetActivateStatusResposeBean`
L4 · [class] public GetActivateStatusResposeBean · extends `CmdResponseBean` · `com/gku/module_camera/amba/bean/GetActivateStatusResposeBean.java`

字段/常量（4）：
- `String macaddr`  L5
- `String number`  L6
- `String status`  L7
- `String version`  L8

方法（8）：
- `String getStatus()`  L10
- `GetActivateStatusResposeBean setStatus(String str)`  L14
- `String getNumber()`  L19
- `GetActivateStatusResposeBean setNumber(String str)`  L23
- `String getVersion()`  L28
- `GetActivateStatusResposeBean setVersion(String str)`  L32
- `String getMacaddr()`  L37
- `GetActivateStatusResposeBean setMacaddr(String str)`  L41
### `com.gku.module_camera.amba.bean.GetFileCountResponseBean`
L6 · [class] public GetFileCountResponseBean · extends `CmdResponseBean` · `com/gku/module_camera/amba/bean/GetFileCountResponseBean.java`

字段/常量（1）：
- `int _$VarCount293`  L9 @SerializedName("var count")

方法（2）：
- `int get_$VarCount293()`  L11
- `void set_$VarCount293(int i)`  L15
### `com.gku.module_camera.amba.bean.GetFileInfoListRequestBean`
L4 · [class] public GetFileInfoListRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/GetFileInfoListRequestBean.java`

字段/常量（2）：
- `int end`  L5
- `int start`  L6

方法（5）：
- `public GetFileInfoListRequestBean(int i)`  L8
- `int getStart()`  L12
- `GetFileInfoListRequestBean setStart(int i)`  L16
- `int getEnd()`  L21
- `GetFileInfoListRequestBean setEnd(int i)`  L25
### `com.gku.module_camera.amba.bean.GetFileInfoListResponseBean`
L4 · [class] public GetFileInfoListResponseBean · extends `CmdResponseBean` · `com/gku/module_camera/amba/bean/GetFileInfoListResponseBean.java`

字段/常量（1）：
- `String fileinfolist`  L5

方法（2）：
- `String getFileinfolist()`  L7
- `void setFileinfolist(String str)`  L11
### `com.gku.module_camera.amba.bean.GetFileInfoRequestBean`
L4 · [class] public GetFileInfoRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/GetFileInfoRequestBean.java`

字段/常量（1）：
- `String param`  L5

方法（3）：
- `public GetFileInfoRequestBean(int i)`  L7
- `String getParam()`  L11
- `GetFileInfoRequestBean setParam(String str)`  L15
### `com.gku.module_camera.amba.bean.GetFilePathListRequestBean`
L4 · [class] public GetFilePathListRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/GetFilePathListRequestBean.java`

字段/常量（2）：
- `int end`  L5
- `int start`  L6

方法（5）：
- `public GetFilePathListRequestBean(int i)`  L8
- `int getStart()`  L12
- `GetFilePathListRequestBean setStart(int i)`  L16
- `int getEnd()`  L21
- `GetFilePathListRequestBean setEnd(int i)`  L25
### `com.gku.module_camera.amba.bean.GetFileRequestBean`
L4 · [class] public GetFileRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/GetFileRequestBean.java`

字段/常量（3）：
- `long fetch_size`  L5
- `long offset`  L6
- `String param`  L7

方法（7）：
- `public GetFileRequestBean(int i)`  L9
- `String getParam()`  L13
- `GetFileRequestBean setParam(String str)`  L17
- `long getOffset()`  L22
- `GetFileRequestBean setOffset(long j)`  L26
- `long getFetch_size()`  L31
- `GetFileRequestBean setFetch_size(long j)`  L35
### `com.gku.module_camera.amba.bean.GetFileResponseBean`
L4 · [class] public GetFileResponseBean · extends `CmdResponseBean` · `com/gku/module_camera/amba/bean/GetFileResponseBean.java`

字段/常量（3）：
- `String path`  L5
- `long rem_size`  L6
- `Object size`  L7

方法（6）：
- `long getRem_size()`  L9
- `void setRem_size(long j)`  L13
- `String getPath()`  L17
- `void setPath(String str)`  L21
- `long toLong(Object obj)`  L25
- `Long getSize()`  L39
### `com.gku.module_camera.amba.bean.GetPrimaryMenuItem`
L4 · [class] public GetPrimaryMenuItem · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/GetPrimaryMenuItem.java`

字段/常量（1）：
- `String workmode`  L5

方法（3）：
- `public GetPrimaryMenuItem(int i)`  L7
- `String getWorkmode()`  L11
- `GetPrimaryMenuItem setWorkmode(String str)`  L15
### `com.gku.module_camera.amba.bean.GetSecondMenuItemRequestBean`
L4 · [class] public GetSecondMenuItemRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/GetSecondMenuItemRequestBean.java`

字段/常量（2）：
- `String name`  L5
- `String workmode`  L6

方法（5）：
- `public GetSecondMenuItemRequestBean(int i)`  L8
- `String getWorkmode()`  L12
- `GetSecondMenuItemRequestBean setWorkmode(String str)`  L16
- `String getName()`  L21
- `GetSecondMenuItemRequestBean setName(String str)`  L25
### `com.gku.module_camera.amba.bean.GetThumbRequestBean`
L4 · [class] public GetThumbRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/GetThumbRequestBean.java`

字段/常量（2）：
- `String param`  L5
- `String type`  L6

方法（5）：
- `public GetThumbRequestBean(int i)`  L8
- `String getParam()`  L12
- `GetThumbRequestBean setParam(String str)`  L16
- `String getType()`  L21
- `GetThumbRequestBean setType(String str)`  L25
### `com.gku.module_camera.amba.bean.GetThumbResponseBean`
L4 · [class] public GetThumbResponseBean · extends `CmdResponseBean` · `com/gku/module_camera/amba/bean/GetThumbResponseBean.java`

字段/常量（3）：
- `String path`  L5
- `int rotation`  L6
- `long size`  L7

方法（6）：
- `String getPath()`  L9
- `void setPath(String str)`  L13
- `long getSize()`  L17
- `void setSize(long j)`  L21
- `int getRotation()`  L25
- `void setRotation(int i)`  L29
### `com.gku.module_camera.amba.bean.IntParamRequestBean`
L4 · [class] public IntParamRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/IntParamRequestBean.java`

字段/常量（1）：
- `int param`  L5

方法（3）：
- `public IntParamRequestBean(int i)`  L7
- `int getParam()`  L11
- `IntParamRequestBean setParam(int i)`  L15
### `com.gku.module_camera.amba.bean.LangBean`
L4 · [class] public LangBean · `com/gku/module_camera/amba/bean/LangBean.java`

字段/常量（9）：
- `String de`  L5
- `String en`  L6
- `String fr`  L7
- `String it`  L8
- `String ja`  L9
- `String kr`  L10
- `String sp`  L11
- `String zh`  L12
- `String zh_HK`  L13

方法（18）：
- `String getEn()`  L15
- `void setEn(String str)`  L19
- `String getZh()`  L23
- `void setZh(String str)`  L27
- `String getJa()`  L31
- `void setJa(String str)`  L35
- `String getZh_HK()`  L39
- `void setZh_HK(String str)`  L43
- `String getKr()`  L47
- `void setKr(String str)`  L51
- `String getFr()`  L55
- `void setFr(String str)`  L59
- `String getSp()`  L63
- `void setSp(String str)`  L67
- `String getDe()`  L71
- `void setDe(String str)`  L75
- `String getIt()`  L79
- `void setIt(String str)`  L83
### `com.gku.module_camera.amba.bean.PutFileRequestBean`
L4 · [class] public PutFileRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/PutFileRequestBean.java`

字段/常量（4）：
- `String md5sum`  L5
- `int offset`  L6
- `String param`  L7
- `long size`  L8

方法（9）：
- `public PutFileRequestBean(int i)`  L10
- `String getParam()`  L14
- `PutFileRequestBean setParam(String str)`  L18
- `long getSize()`  L23
- `PutFileRequestBean setSize(long j)`  L27
- `String getMd5sum()`  L32
- `PutFileRequestBean setMd5sum(String str)`  L36
- `int getOffset()`  L41
- `PutFileRequestBean setOffset(int i)`  L45
### `com.gku.module_camera.amba.bean.SetActivateStatusRequestBean`
L4 · [class] public SetActivateStatusRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/SetActivateStatusRequestBean.java`

字段/常量（1）：
- `String status`  L5

方法（3）：
- `public SetActivateStatusRequestBean(int i)`  L7
- `String getStatus()`  L11
- `SetActivateStatusRequestBean setStatus(String str)`  L15
### `com.gku.module_camera.amba.bean.SetClntInfoRequestBean`
L4 · [class] public SetClntInfoRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/SetClntInfoRequestBean.java`

字段/常量（2）：
- `String param`  L5
- `String type`  L6

方法（5）：
- `public SetClntInfoRequestBean(int i)`  L8
- `String getType()`  L12
- `SetClntInfoRequestBean setType(String str)`  L16
- `String getParam()`  L21
- `SetClntInfoRequestBean setParam(String str)`  L25
### `com.gku.module_camera.amba.bean.SetCurParameterRequestBean`
L4 · [class] public SetCurParameterRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/SetCurParameterRequestBean.java`

字段/常量（3）：
- `String name`  L5
- `String value`  L6
- `String workmode`  L7

方法（7）：
- `public SetCurParameterRequestBean(int i)`  L9
- `String getWorkmode()`  L13
- `SetCurParameterRequestBean setWorkmode(String str)`  L17
- `String getName()`  L22
- `SetCurParameterRequestBean setName(String str)`  L26
- `String getValue()`  L31
- `SetCurParameterRequestBean setValue(String str)`  L35
### `com.gku.module_camera.amba.bean.SetWifiRequestBean`
L4 · [class] public SetWifiRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/SetWifiRequestBean.java`

字段/常量（2）：
- `String pwd`  L5
- `String ssid`  L6

方法（5）：
- `public SetWifiRequestBean(int i)`  L8
- `String getSsid()`  L12
- `SetWifiRequestBean setSsid(String str)`  L16
- `String getPwd()`  L21
- `SetWifiRequestBean setPwd(String str)`  L25
### `com.gku.module_camera.amba.bean.StartSessionResponseBean`
L4 · [class] public StartSessionResponseBean · extends `CmdResponseBean` · `com/gku/module_camera/amba/bean/StartSessionResponseBean.java`

字段/常量（1）：
- `int param`  L5

方法（2）：
- `int getParam()`  L7
- `void setParam(int i)`  L11
### `com.gku.module_camera.amba.bean.StringParamRequestBean`
L4 · [class] public StringParamRequestBean · extends `CmdRequestBean` · `com/gku/module_camera/amba/bean/StringParamRequestBean.java`

字段/常量（1）：
- `String param`  L5

方法（3）：
- `public StringParamRequestBean(int i)`  L7
- `String getParam()`  L11
- `StringParamRequestBean setParam(String str)`  L15
### `com.gku.module_camera.amba.connector.AmbaConnector`
L34 · [class] public AmbaConnector · `com/gku/module_camera/amba/connector/AmbaConnector.java`

字段/常量（49）：
- `int MSG_ID_BLUETOOTH_HEARTBEAT = 268435492`  L35
- `int MSG_ID_CANCLE_XFER = 1287`  L36
- `int MSG_ID_DELETE_ALL_FILE = 268435487`  L37
- `int MSG_ID_DELETE_FILE = 268435486`  L38
- `int MSG_ID_FORMAT_SD = 4`  L39
- `int MSG_ID_GET_ACTIVATE = 268435505`  L40
- `int MSG_ID_GET_ALL_WORK_MODE = 268435457`  L41
- `int MSG_ID_GET_BLUETOOTH_TX = 268435507`  L42
- `int MSG_ID_GET_BTATERY_INFO = 268435480`  L43
- `int MSG_ID_GET_CAMERA_INFO = 11`  L44
- `int MSG_ID_GET_CURRENT_WORK_MODE = 268435458`  L45
- `int MSG_ID_GET_FILE = 1285`  L46
- `int MSG_ID_GET_FILELIST_INFO_IOS = 268435485`  L47
- `int MSG_ID_GET_FILE_COUNT = 268435482`  L48
- `int MSG_ID_GET_FILE_INFO = 268435484`  L49
- `int MSG_ID_GET_FILE_LIST = 268435483`  L50
- `int MSG_ID_GET_PRIMARY_MENU_ITEM = 268435460`  L51
- `int MSG_ID_GET_ROTATE = 268435489`  L52
- `int MSG_ID_GET_SD_STATE = 268435475`  L53
- `int MSG_ID_GET_SECOND_MENU_ITEM = 268435461`  L54
- `int MSG_ID_GET_SYSTEM_WORK_STATE = 268435466`  L55
- `int MSG_ID_GET_THUMB = 1025`  L56
- `int MSG_ID_GET_WIFI_SETTING = 1539`  L57
- `int MSG_ID_HEART_BEAT = 268435467`  L58
- `int MSG_ID_PAIR_AND_GET_BLUETOOTH_TX = 268435508`  L59
- `int MSG_ID_PUT_FILE = 1286`  L60
- `int MSG_ID_QS_ADD_TIME = 268435488`  L61
- `int MSG_ID_RECORD_START = 513`  L62
- `int MSG_ID_RECORD_STOP = 514`  L63
- `int MSG_ID_RESETVF = 259`  L64
- `int MSG_ID_RESET_FACTORY = 268435477`  L65
- `int MSG_ID_SET_ACTIVATE = 268435506`  L66
- `int MSG_ID_SET_CLINT_INFO = 261`  L67
- `int MSG_ID_SET_CURRENT_WORK_MODE = 268435459`  L68
- `int MSG_ID_SET_CUR_PARAMETER = 268435463`  L69
- `int MSG_ID_SET_STREAM_DATA = 268435490`  L70
- `int MSG_ID_SET_WIFI_SETTING = 1538`  L71
- `int MSG_ID_START_SESSION = 257`  L72
- `int MSG_ID_STOP_PHOTO = 770`  L73
- `int MSG_ID_STOP_SESSION = 258`  L74
- `int MSG_ID_STOP_VF = 260`  L75
- `int MSG_ID_SYNC_SYSTEM_TIME = 268435474`  L76
- `int MSG_ID_TAKE_PHOTO = 769`  L77
- `int AMBA_CMD_PORT`  L78
- `Gson gson`  L79
- `Map<LifecycleOwner, CallbackPush> mapCallbackPush`  L80
- `int sessionId`  L81
- `boolean shouldCallStartSessionOnAppStart`  L82
- `int i2 = i - 1`  L286

方法（29）：
- `private AmbaConnector()`  L110
- `AmbaConnector getInstance()`  L125
- `void addCallbackPush(final LifecycleOwner lifecycleOwner, CallbackPush callbackPush)`  L129
- `void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event)`  L132 @Override
- `void startSession(Context context, CallbackSession callbackSession)`  L142
    - 体内字面量："startSession"
- `void stopSession()`  L210
    - 体内字面量："stopSessionnnn"
- `boolean isShouldCallStartSessionOnAppStart()`  L221
- `void sendCmdQueue(T t, int i, Class<R> cls, Callback<R> callback)`  L225
- `void sendCmdQueue(T t, P p, Class<R> cls, Callback<R> callback)`  L229
    - 体内字面量："sendCmdQueue"
- `void sendCmdQueueTimesIfTimeOut(T t, P p, Class<R> cls, Callback<R> callback, int i)`  L234
- `void sendCmd(T t, P p, final Class<R> cls, final Callback<R> callback)`  L239
- `void run()`  L243 @Override
- `void onSuccess(String str)`  L251 @Override
    - 体内字面量："queueRequest" · "onSuccess:"
- `void onFail(int i)`  L268 @Override
    - 体内字面量："queueRequest" · "onFail:"
- `void sendCmdTimesIfTimeOut(final T t, final P p, final Class<R> cls, final Callback<R> callback, int i)`  L277
- `void onSuccess(String str)`  L291 @Override
    - 体内字面量："queueRequest" · "onSuccess:"
- `void onFail(int i3)`  L308 @Override
    - 体内字面量："sendCmdTimesIfTimeOut queueRequest" · "onFail:" · "queueRequest" · "retry:"
- `void getFile(T t, String str, Callback<GetFileResponseBean> callback)`  L320
- `void deleteFile(T t, String str, Callback<CmdResponseBean> callback)`  L324
- `void cancelDeleteFile(List<FileListInfoResponseBean> list)`  L328
- `void cancelDeleteFile(SparseArray<FileListInfoResponseBean> sparseArray)`  L337
- `void cancelCmd(List<T> list)`  L345
- `void putFile(final T t, final File file, final Callback<CmdResponseBean> callback)`  L353
- `void onInterrupted()`  L356 @Override
- `String runThread()`  L360 @Override
- `void run_UIThread(String str)`  L365 @Override
    - 体内字面量："/tmp/SD0/"
- `void deleteFile(T t, final SparseArray<FileListInfoResponseBean> sparseArray, final CallbackDeletes callbackDeletes)`  L371
- `void onSuccess(CmdResponseBean cmdResponseBean, String str)`  L377 @Override
- `void onFail(int i)`  L385 @Override
### `com.gku.module_camera.amba.connector.AmbaConnector$AnonymousClass2`
L150 · [class] AnonymousClass2 · implements `SocketAmbaCmd.Callback` · `com/gku/module_camera/amba/connector/AmbaConnector.java`

字段/常量（2）：
- `CallbackSession val$callbackSession`  L151
- `Context val$context`  L152

方法（7）：
- `void onSocketConnect()`  L160 @Override
    - 体内字面量："onSocketConnect"
- `void onSuccess(StartSessionResponseBean startSessionResponseBean, String str)`  L166 @Override
    - 体内字面量："TCP"
- `void onSuccess(CmdResponseBean cmdResponseBean, String str2)`  L170 @Override
    - 体内字面量："startSession success"
- `void onFail(int i)`  L176 @Override
- `void onFail(int i)`  L184 @Override
- `void onPushMsgReceive(String str)`  L191 @Override
    - 体内字面量："onPushMsgReceive"
- `void onFail(int i)`  L204 @Override
    - 体内字面量："socketAmbaCmd.start onFail"
### `com.gku.module_camera.amba.connector.AmbaConnector$Callback`
L84 · [interface] public Callback · `com/gku/module_camera/amba/connector/AmbaConnector.java`

方法（2）：
- `void onFail(int i)`  L85
- `void onSuccess(T t, String str)`  L87
### `com.gku.module_camera.amba.connector.AmbaConnector$CallbackDeletes`
L90 · [interface] public CallbackDeletes · `com/gku/module_camera/amba/connector/AmbaConnector.java`

方法（3）：
- `void onFailOne(int i)`  L91
- `void onSuccessAll()`  L93
- `void onSuccessOne(int i, int i2)`  L95
### `com.gku.module_camera.amba.connector.AmbaConnector$CallbackPush`
L98 · [interface] public CallbackPush · `com/gku/module_camera/amba/connector/AmbaConnector.java`

方法（1）：
- `void callback(String str)`  L99
### `com.gku.module_camera.amba.connector.AmbaConnector$CallbackSession`
L102 · [interface] public CallbackSession · `com/gku/module_camera/amba/connector/AmbaConnector.java`

方法（3）：
- `void onFail(int i)`  L103
- `void onPushMsgReceive(String str)`  L105
- `void onSuccess()`  L107
### `com.gku.module_camera.amba.connector.AmbaConnector$Holder`
L118 · [class] private static Holder · `com/gku/module_camera/amba/connector/AmbaConnector.java`

方法（1）：
- `private Holder()`  L121
### `com.gku.module_camera.amba.connector.AmbaDownloader`
L41 · [class] public AmbaDownloader · `com/gku/module_camera/amba/connector/AmbaDownloader.java`

字段/常量（16）：
- `int FILE_TYPE_PIC = 1`  L42
- `int FILE_TYPE_UNKNOWN = -1`  L43
- `int FILE_TYPE_VIDEO = 0`  L44
- `ExecutorService executorServiceSingle`  L45
- `Gson gson`  L46
- `Object lockDownload`  L47
- `Object lockQueue`  L48
- `Map<LifecycleOwner, Map<String, Runnable>> mapQueue`  L49
- `String tag_downloading`  L50
- `int columnIndex`  L122
- `Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI`  L123
- `int columnIndex`  L142
- `Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI`  L143
- `String str2 = str + ".tmp"`  L193
- `boolean zRenameTo = false`  L204
- `Runnable runnable2`  L681

方法（47）：
- `private AmbaDownloader()`  L78
- `AmbaDownloader getInstance()`  L94
- `void download(Context context, final T t, long j, String str, SocketAmbaDownload.Callback callback)`  L98
- `void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event)`  L102 @Override
- `String getTagFromFileListInfoResponseBean(T t, FileListInfoResponseBean fileListInfoResponseBean, boolean z)`  L113
- `long getVideoSizeInDCIMSync(Context context, FileListInfoResponseBean fileListInfoResponseBean)`  L121
- `long getPicSizeInDCIMSync(Context context, FileListInfoResponseBean fileListInfoResponseBean)`  L141
- `boolean isFileDownloaded2DCIMSync(Context context, FileListInfoResponseBean fileListInfoResponseBean)`  L161
- `String getFilePathSaved(Context context, FileListInfoResponseBean fileListInfoResponseBean)`  L169
- `void downloadFile__(Context context, T t, final FileListInfoResponseBean fileListInfoResponseBean, final String str, final CallbackDownload callbackDownload)`  L174
    - 体内字面量："downloadFile ç¼å­"
- `void run()`  L180 @Override
    - 体内字面量："downloadFile" · "MSG_ID_GET_FILE:"
- `void run()`  L189 @Override
- `void onSuccess(GetFileResponseBean getFileResponseBean, String str3)`  L197 @Override
    - 体内字面量："downloadFile" · "socketAmbaFile:"
- `void onSuccess(String str4)`  L201 @Override
- `void onProgress(long j, long j2, int i)`  L223 @Override
- `void onRefreshSpeed(long j)`  L228 @Override
- `void onFail(int i)`  L233 @Override
- `void onFail(int i)`  L241 @Override
    - 体内字面量："downloadFile MSG_ID_GET_FILE onFail"
- `void downloadFile(final Context context, final T t, final FileListInfoResponseBean fileListInfoResponseBean, final CallbackDownload callbackDownload)`  L248
- `void run()`  L252 @Override
- `void onSuccess(FileListInfoResponseBean fileListInfoResponseBean2, String str)`  L258 @Override
- `void onStart(FileListInfoResponseBean fileListInfoResponseBean2)`  L264 @Override
- `void onProgress(FileListInfoResponseBean fileListInfoResponseBean2, long j, long j2, int i)`  L269 @Override
- `void onRefreshSpeed(FileListInfoResponseBean fileListInfoResponseBean2, long j)`  L274 @Override
- `void onFail(FileListInfoResponseBean fileListInfoResponseBean2, int i)`  L279 @Override
- `int getFileType(FileListInfoResponseBean fileListInfoResponseBean)`  L288
    - 体内字面量："jpg" · "jpeg" · "png" · "webp" · "dng" · "raw" · "mp4"
- `void downloadFile2DCIM(Context context, T t, final List<FileListInfoResponseBean> list, final CallbackDownload_s callbackDownload_s)`  L296
- `void onSuccess(FileListInfoResponseBean fileListInfoResponseBean, String str)`  L301 @Override
- `void onStart(FileListInfoResponseBean fileListInfoResponseBean)`  L309 @Override
- `void onProgress(FileListInfoResponseBean fileListInfoResponseBean, long j, long j2, int i2)`  L314 @Override
- `void onRefreshSpeed(FileListInfoResponseBean fileListInfoResponseBean, long j)`  L319 @Override
- `void onFail(FileListInfoResponseBean fileListInfoResponseBean, int i2)`  L324 @Override
- `String getDCIMPath(FileListInfoResponseBean fileListInfoResponseBean)`  L331
    - 体内字面量："xtugo" · "video" · "photo"
- `String getDCIMPath_9(FileListInfoResponseBean fileListInfoResponseBean)`  L343
    - 体内字面量："xtugo" · "video" · "photo"
- `String getDisplayName(FileListInfoResponseBean fileListInfoResponseBean)`  L355
    - 体内字面量："\\D+"
- `int copyFileToDCIMSync(Context context, File file, FileListInfoResponseBean fileListInfoResponseBean)`  L359
- `void downloadFile2DCIM(Context context, T t, FileListInfoResponseBean fileListInfoResponseBean, CallbackDownload callbackDownload)`  L366
- `void onPermissionHave()`  L370 @Override
- `void downloadThumb(Context context, T t, FileListInfoResponseBean fileListInfoResponseBean, CallbackDownload callbackDownload)`  L470
    - 体内字面量："\\D+" · "thumb.jpg" · "downloadThumb downloadThumb cancelCmd"
- `GetThumbRequestBean createGetThumbRequestBean(FileListInfoResponseBean fileListInfoResponseBean)`  L582
    - 体内字面量："idr" · "thumb"
- `void cancelDownload(T t, String str)`  L586
    - 体内字面量："download cancelDownload thumb" · "socketAmbaDownload.stop:" · "download cancelDownload thumb"
- `void cancelDownload(T t, List<FileListInfoResponseBean> list, boolean z)`  L606
    - 体内字面量："download cancelDownload" · "socketAmbaDownload.stop:" · "download cancelDownload"
- `void synchronized_tag_downloading_null()`  L629
- `void queueEvent(final T t, final String str, Runnable runnable)`  L636
    - 体内字面量："download_queueEvent ==111"
- `void run()`  L640 @Override
    - 体内字面量："download_queueEvent ==222"
- `void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event)`  L644 @Override
    - 体内字面量："download ON_DESTROY" · "socketAmbaDownload.stop():" · "download_queueEvent lockQueue" · "download_queueEvent lockQueue111" · "download_queueEvent lockQueue222" · "download_queueEvent execute"
- `void run()`  L680 @Override
### `com.gku.module_camera.amba.connector.AmbaDownloader$AnonymousClass8`
L381 · [class] AnonymousClass8 · implements `Runnable` · `com/gku/module_camera/amba/connector/AmbaDownloader.java`

字段/常量（9）：
- `CallbackDownload val$callbackDownload`  L382
- `Context val$context`  L383
- `FileListInfoResponseBean val$fileListInfoResponseBean`  L384
- `LifecycleOwner val$lifecycleOwner`  L385
- `String val$tag`  L386
- `AmbaDownloader ambaDownloader = AmbaDownloader.this`  L414
- `Context context = this.val$context`  L415
- `LifecycleOwner lifecycleOwner = this.val$lifecycleOwner`  L416
- `FileListInfoResponseBean fileListInfoResponseBean = this.val$fileListInfoResponseBean`  L417

方法（10）：
- `void run()`  L397 @Override
    - 体内字面量："downloadFile2DCIM" · "downloadFile2DCIM ç¼å­"
- `void run()`  L406 @Override
    - 体内字面量："downloadFile2DCIM downloadFile__"
- `void onSuccess(final FileListInfoResponseBean fileListInfoResponseBean2, final String str)`  L420 @Override
- `void onInterrupted()`  L423 @Override
- `Integer runThread()`  L428 @Override
- `void run_UIThread(Integer num)`  L435 @Override
- `void onStart(FileListInfoResponseBean fileListInfoResponseBean2)`  L447 @Override
- `void onProgress(FileListInfoResponseBean fileListInfoResponseBean2, long j, long j2, int i)`  L452 @Override
- `void onRefreshSpeed(FileListInfoResponseBean fileListInfoResponseBean2, long j)`  L457 @Override
- `void onFail(FileListInfoResponseBean fileListInfoResponseBean2, int i)`  L462 @Override
### `com.gku.module_camera.amba.connector.AmbaDownloader$AnonymousClass9`
L478 · [class] AnonymousClass9 · implements `Runnable` · `com/gku/module_camera/amba/connector/AmbaDownloader.java`

字段/常量（6）：
- `CallbackDownload val$callbackDownload`  L479
- `Context val$context`  L480
- `FileListInfoResponseBean val$fileListInfoResponseBean`  L481
- `LifecycleOwner val$lifecycleOwner`  L482
- `String val$pathSaved`  L483
- `String val$tag`  L484

方法（1）：
- `void run()`  L496 @Override
    - 体内字面量："downloadThumb querySize"
### `com.gku.module_camera.amba.connector.AmbaDownloader$AnonymousClass9$AnonymousClass1`
L505 · [class] AnonymousClass1 · implements `SQLiteHolder.CallbackQuery2<Long, Integer>` · `com/gku/module_camera/amba/connector/AmbaDownloader.java`

方法（8）：
- `void onComplete(Long l, final Integer num)`  L510 @Override
    - 体内字面量："downloadThumb querySize onComplete" · ":" · "::" · "downloadThumb querySize onComplete" · "downloadThumb ç¼å­"
- `void run()`  L519 @Override
    - 体内字面量："downloadThumb  queueEvent run cancelCmd"
- `void onSuccess(final GetThumbResponseBean getThumbResponseBean, String str)`  L531 @Override
    - 体内字面量："downloadThumb" · "socketAmbaFile: cancelCmd"
- `void onRefreshSpeed(long j)`  L535 @Override
- `void onSuccess(String str2)`  L539 @Override
    - 体内字面量："downloadThumb  onSuccess cancelCmd"
- `void onProgress(long j, long j2, int i)`  L557 @Override
- `void onFail(int i)`  L562 @Override
    - 体内字面量："downloadThumb onFail" · ":::"
- `void onFail(int i)`  L571 @Override
    - 体内字面量："downloadThumb" · "MSG_ID_GET_THUMB_onfail:" · "::"
### `com.gku.module_camera.amba.connector.AmbaDownloader$CallbackDownload`
L52 · [interface] public CallbackDownload · `com/gku/module_camera/amba/connector/AmbaDownloader.java`

方法（5）：
- `void onFail(FileListInfoResponseBean fileListInfoResponseBean, int i)`  L53
- `void onProgress(FileListInfoResponseBean fileListInfoResponseBean, long j, long j2, int i)`  L55
- `void onRefreshSpeed(FileListInfoResponseBean fileListInfoResponseBean, long j)`  L57
- `void onStart(FileListInfoResponseBean fileListInfoResponseBean)`  L59
- `void onSuccess(FileListInfoResponseBean fileListInfoResponseBean, String str)`  L61
### `com.gku.module_camera.amba.connector.AmbaDownloader$CallbackDownload_s`
L64 · [interface] public CallbackDownload_s · `com/gku/module_camera/amba/connector/AmbaDownloader.java`

方法（6）：
- `void onFailOne(int i, FileListInfoResponseBean fileListInfoResponseBean, int i2)`  L65
- `void onProgressOne(int i, FileListInfoResponseBean fileListInfoResponseBean, long j, long j2, int i2)`  L67
- `void onRefreshSpeed(int i, FileListInfoResponseBean fileListInfoResponseBean, long j)`  L69
- `void onStartOne(int i, FileListInfoResponseBean fileListInfoResponseBean, int i2)`  L71
- `void onSuccessAll()`  L73
- `void onSuccessOne(int i, FileListInfoResponseBean fileListInfoResponseBean, int i2)`  L75
### `com.gku.module_camera.amba.connector.AmbaDownloader$Holder`
L87 · [class] private static Holder · `com/gku/module_camera/amba/connector/AmbaDownloader.java`

方法（1）：
- `private Holder()`  L90
### `com.gku.module_camera.amba.connector.AmbaLangHolder`
L19 · [class] public AmbaLangHolder · `com/gku/module_camera/amba/connector/AmbaLangHolder.java`

字段/常量（4）：
- `String LANGUAGE_PATH`  L20
- `Map<String, LangBean> map`  L21
- `Exception e`  L68
- `List<LangBean> list`  L69

方法（10）：
- `private AmbaLangHolder()`  L27
    - 体内字面量："/tmp/FL0/language.json"
- `AmbaLangHolder getInstance()`  L39
- `void downloadJson(Context context, final int i, final Callback callback)`  L43
    - 体内字面量："/tmp/FL0/language.json"
- `void onSuccess(GetFileResponseBean getFileResponseBean, String str)`  L52 @Override
    - 体内字面量："downloadJson onSuccess GetFileResponseBean" · "language.json"
- `void onProgress(long j, long j2, int i2)`  L59 @Override
- `void onRefreshSpeed(long j)`  L63 @Override
- `void onSuccess(String str2)`  L67 @Override
- `void onFail(int i2)`  L94 @Override
    - 体内字面量："downloadJson è¯­è¨" · "onFail"
- `void onFail(int i2)`  L102 @Override
    - 体内字面量："downloadJson onSuccess" · "GetFileResponseBean"
- `String getStr(String str)`  L110
    - 体内字面量："de" · "en" · "es" · "fr" · "it" · "ja" · "ko" · "zh" · "HK"
### `com.gku.module_camera.amba.connector.AmbaLangHolder$Callback`
L23 · [interface] public Callback · `com/gku/module_camera/amba/connector/AmbaLangHolder.java`

方法（1）：
- `void goToNext(boolean z)`  L24
### `com.gku.module_camera.amba.connector.AmbaLangHolder$Holder`
L32 · [class] private static Holder · `com/gku/module_camera/amba/connector/AmbaLangHolder.java`

方法（1）：
- `private Holder()`  L35
### `com.gku.module_camera.amba.connector.AmbaUploader`
L12 · [class] public AmbaUploader · `com/gku/module_camera/amba/connector/AmbaUploader.java`

字段/常量（1）：
- `SocketAmbaUpload socketAmbaUpload`  L13

方法（12）：
- `private AmbaUploader()`  L21
- `AmbaUploader getInstance()`  L32
- `void uploadFile(Context context, final T t, final File file, final Callback callback)`  L36
- `void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event)`  L39 @Override
- `void onSocketConnect()`  L49 @Override
- `void onSuccess(CmdResponseBean cmdResponseBean, String str)`  L52 @Override
- `void onFail(int i)`  L57 @Override
- `void onSuccess()`  L64 @Override
- `void onProgress(long j, long j2, int i)`  L69 @Override
- `void onRefreshSpeed(long j)`  L74 @Override
- `void onFail(int i)`  L79 @Override
- `void cancelUpload()`  L85
### `com.gku.module_camera.amba.connector.AmbaUploader$Callback`
L15 · [class] public static abstract Callback · implements `SocketAmbaUpload.Callback` · `com/gku/module_camera/amba/connector/AmbaUploader.java`

方法（1）：
- `void onSocketConnect()`  L17 @Override
### `com.gku.module_camera.amba.connector.AmbaUploader$Holder`
L25 · [class] private static Holder · `com/gku/module_camera/amba/connector/AmbaUploader.java`

方法（1）：
- `private Holder()`  L28
### `com.gku.module_camera.amba.connector.SocketAmbaCmd`
L26 · [class] public SocketAmbaCmd · `com/gku/module_camera/amba/connector/SocketAmbaCmd.java`

字段/常量（11）：
- `byte[] buf`  L27
- `ExecutorService executorServiceSingleConnect`  L28
- `Gson gson`  L29
- `InputStream inputStream`  L30
- `boolean isRunning`  L31
- `Object lock`  L32
- `Map<String, CallbackCmd> mapMsgQueue`  L33
- `OutputStream outputStream`  L34
- `Socket socket`  L35
- `String json = "<binary/metadata>"`  L134
- `String json = "<binary/metadata>"`  L172

方法（13）：
- `private SocketAmbaCmd()`  L51
- `SocketAmbaCmd getInstance()`  L67
- `void start(Network network, String str, int i, int i2, Callback callback)`  L108
    - 体内字面量："SocketAmbaCmd" · "startstart"
- `void sendCmd(final T t, final C c, CallbackCmd callbackCmd)`  L113
- `void run()`  L117 @Override
- `void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event)`  L120 @Override
- `void sendCmd(T t, CallbackCmd callbackCmd)`  L133
- `void synchronized_cleare_msg()`  L149
    - 体内字面量："synchronized_cleare_msg cancelCmd!=null"
- `void run()`  L157 @Override
- `void cancelCmd(List<T> list)`  L168
- `void run()`  L183 @Override
- `void stop()`  L193
    - 体内字面量："socket call stop"
- `void closeConnection()`  L200
### `com.gku.module_camera.amba.connector.SocketAmbaCmd$AnonymousClass1`
L72 · [class] AnonymousClass1 · implements `Runnable` · `com/gku/module_camera/amba/connector/SocketAmbaCmd.java`

字段/常量（5）：
- `Callback val$callback`  L73
- `String val$ip`  L74
- `Network val$network`  L75
- `int val$port`  L76
- `int val$soTimeout`  L77

方法（3）：
- `void run()`  L93 @Override
- `throw new UnsupportedOperationException( 0 )`  L98
- `void lambda$run$0(CallbackCmd callbackCmd)`  L101
### `com.gku.module_camera.amba.connector.SocketAmbaCmd$Callback`
L37 · [interface] public Callback · `com/gku/module_camera/amba/connector/SocketAmbaCmd.java`

方法（3）：
- `void onFail(int i)`  L38
- `void onPushMsgReceive(String str)`  L40
- `void onSocketConnect()`  L42
### `com.gku.module_camera.amba.connector.SocketAmbaCmd$CallbackCmd`
L45 · [interface] public CallbackCmd · `com/gku/module_camera/amba/connector/SocketAmbaCmd.java`

方法（2）：
- `void onFail(int i)`  L46
- `void onSuccess(String str)`  L48
### `com.gku.module_camera.amba.connector.SocketAmbaCmd$Holder`
L60 · [class] private static Holder · `com/gku/module_camera/amba/connector/SocketAmbaCmd.java`

方法（1）：
- `private Holder()`  L63
### `com.gku.module_camera.amba.connector.SocketAmbaDownload`
L19 · [class] public SocketAmbaDownload · `com/gku/module_camera/amba/connector/SocketAmbaDownload.java`

字段/常量（11）：
- `byte[] buf`  L20
- `ExecutorService executorServiceSingleConnect`  L21
- `InputStream inputStream`  L22
- `boolean isRunning`  L23
- `int last_percent`  L24
- `OutputStream outputStreamFile`  L25
- `Socket socket`  L26
- `SocketAmbaDownload socketAmbaDownload = SocketAmbaDownload.this`  L76
- `int i2 = 0`  L97
- `long j2 = jCurrentTimeMillis2 - jCurrentTimeMillis`  L107
- `Socket socket`  L203

方法（14）：
- `private SocketAmbaDownload()`  L38
- `SocketAmbaDownload getInstance()`  L52
- `void start(final Network network, final String str, final int i, final boolean z, final long j, final String str2, final Callback callback)`  L56
- `void run()`  L68 @Override
    - 体内字面量："socket_file start" · "å°è¯è¿æ¥ " · ":8787"
- `void run()`  L88 @Override
- `void run()`  L111 @Override
- `void run()`  L124 @Override
    - 体内字面量："CODE_ERROR_AMBA_READ"
- `void run()`  L137 @Override
    - 体内字面量："downloaded == contentLength)"
- `void run()`  L153 @Override
- `void run()`  L160 @Override
    - 体内字面量："socket_file end000" · "è¿æ¥å¤±è´¥: "
- `void run()`  L172 @Override
- `void stop()`  L181
    - 体内字面量："socket call stop"
- `void closeConnection()`  L187
- `boolean isConnecting()`  L202
### `com.gku.module_camera.amba.connector.SocketAmbaDownload$Callback`
L28 · [interface] public Callback · `com/gku/module_camera/amba/connector/SocketAmbaDownload.java`

方法（4）：
- `void onFail(int i)`  L29
- `void onProgress(long j, long j2, int i)`  L31
- `void onRefreshSpeed(long j)`  L33
- `void onSuccess(String str)`  L35
### `com.gku.module_camera.amba.connector.SocketAmbaDownload$Holder`
L45 · [class] private static Holder · `com/gku/module_camera/amba/connector/SocketAmbaDownload.java`

方法（1）：
- `private Holder()`  L48
### `com.gku.module_camera.amba.connector.SocketAmbaUpload`
L15 · [class] public SocketAmbaUpload · `com/gku/module_camera/amba/connector/SocketAmbaUpload.java`

字段/常量（15）：
- `InputStream inputStreamFile`  L16
- `OutputStream outputStream`  L17
- `Socket socket`  L18
- `boolean isRunning = false`  L19
- `int last_percent = 0`  L20
- `boolean upload = false`  L21
- `byte[] buf = new byte[65536]`  L23
- `int i2`  L51
- `long j`  L52
- `SocketAmbaUpload socketAmbaUpload = SocketAmbaUpload.this`  L59
- `long j2 = 0`  L97
- `int i3 = 0`  L98
- `int i5 = i3 + i4`  L106
- `long j3 = jCurrentTimeMillis2 - jCurrentTimeMillis`  L108
- `Socket socket`  L221

方法（14）：
- `void connect(final Network network, final String str, final int i, final File file, final Callback callback)`  L38
- `void run()`  L50 @Override
- `void run()`  L70 @Override
- `void run()`  L78 @Override
- `void run()`  L112 @Override
- `void run()`  L128 @Override
- `void run()`  L144 @Override
    - 体内字面量："uploaded == contentLength)"
- `void run()`  L160 @Override
- `void run()`  L167 @Override
    - 体内字面量："socket_file end000" · ":" · "DvrSocket" · "è¿æ¥å¤±è´¥: "
- `void run()`  L179 @Override
- `void upload()`  L188
- `void stop()`  L195
    - 体内字面量："socket call stop"
- `void closeConnection()`  L205
- `boolean isConnecting()`  L220
### `com.gku.module_camera.amba.connector.SocketAmbaUpload$Callback`
L26 · [interface] public Callback · `com/gku/module_camera/amba/connector/SocketAmbaUpload.java`

方法（5）：
- `void onFail(int i)`  L27
- `void onProgress(long j, long j2, int i)`  L29
- `void onRefreshSpeed(long j)`  L31
- `void onSocketConnect()`  L33
- `void onSuccess()`  L35
### `com.gku.module_camera.amba.ConstantsAmba`
L4 · [class] public ConstantsAmba · `com/gku/module_camera/amba/ConstantsAmba.java`

字段/常量（18）：
- `int AMBA_DATA_PORT = 8787`  L5
- `String CALLBACK_AMBA_GET_INFOED = "dfdfew3434gf"`  L6
- `int CODE_ERROR_AMBA_CONNECT = -104`  L7
- `int CODE_ERROR_AMBA_COPYFILETODCIM_9_NO_PERMISSION = -111`  L8
- `int CODE_ERROR_AMBA_DOWNLOAD_CONTENTLENGTH_NOT_EQUALS = -106`  L9
- `int CODE_ERROR_AMBA_FILE_OUTPUT_STREAM_CREATE = -105`  L10
- `int CODE_ERROR_AMBA_JSON_PARSE = -103`  L11
- `int CODE_ERROR_AMBA_MSG_CANCELED = -115`  L12
- `int CODE_ERROR_AMBA_MSG_CLEARED = -116`  L13
- `int CODE_ERROR_AMBA_MSG_ID_PUT_FILE_FAIL = -114`  L14
- `int CODE_ERROR_AMBA_NO_RETRY_TIMES = -109`  L15
- `int CODE_ERROR_AMBA_READ = -102`  L16
- `int CODE_ERROR_AMBA_RVAL_NOT_0 = -108`  L17
- `int CODE_ERROR_AMBA_SESSIONID_INVALID = -107`  L18
- `int CODE_ERROR_AMBA_TEMP_RENAME = -117`  L19
- `int CODE_ERROR_AMBA_UPLOAD_CONTENTLENGTH_NOT_EQUALS = -112`  L20
- `int CODE_ERROR_AMBA_UPLOAD_INPUT_STREAM_CREATE = -113`  L21
- `int CODE_ERROR_AMBA_WRITE = -101`  L22
### `com.gku.module_camera.amba.dialog.DialogAmbaSDMediaDelete`
L16 · [class] public DialogAmbaSDMediaDelete · extends `BaseDialog` · `com/gku/module_camera/amba/dialog/DialogAmbaSDMediaDelete.java`

字段/常量（4）：
- `Callback callback`  L17
- `ComponentActivity componentActivity`  L18
- `SparseArray<FileListInfoResponseBean> sparseArray`  L19
- `TextView tv_delete_count`  L20

方法（8）：
- `public DialogAmbaSDMediaDelete(ComponentActivity componentActivity, final Callback callback)`  L28
- `void onClick(View view)`  L37 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L43 @Override
- `void deleteAndShow(int i, FileListInfoResponseBean fileListInfoResponseBean)`  L50
- `void deleteAndShow(SparseArray<FileListInfoResponseBean> sparseArray)`  L56
    - 体内字面量："1/"
- `void onSuccessAll()`  L67 @Override
- `void onSuccessOne(int i2, int i3)`  L73 @Override
    - 体内字面量："/"
- `void onFailOne(int i2)`  L79 @Override
    - 体内字面量：":"
### `com.gku.module_camera.amba.dialog.DialogAmbaSDMediaDelete$Callback`
L22 · [interface] public Callback · `com/gku/module_camera/amba/dialog/DialogAmbaSDMediaDelete.java`

方法（2）：
- `void onDeleteOne(int i, int i2)`  L23
- `void onDismiss()`  L25
### `com.gku.module_camera.amba.dialog.DialogAmbaSDMediaDownload`
L21 · [class] public DialogAmbaSDMediaDownload · extends `BaseDialog` · `com/gku/module_camera/amba/dialog/DialogAmbaSDMediaDownload.java`

字段/常量（22）：
- `String TAG = "DialogAmbaSDMediaDownload"`  L22
- `Callback callback`  L23
- `ComponentActivity componentActivity`  L24
- `View layout_error`  L25
- `ProgressBar progressBar`  L26
- `TextView tv_download_count`  L27
- `TextView tv_download_percent`  L28
- `TextView tv_download_time_left`  L29
- `TextView tv_error`  L30
- `TextView tv_file_name`  L31
- `TextView tv_retry`  L32
- `long size = 0`  L104
- `long[] jArr = {0}`  L108
- `long[] jArr2 = {0}`  L109
- `long[] jArr3 = {0}`  L110
- `long[] jArr4 = {0}`  L111
- `ComponentActivity componentActivity = this.componentActivity`  L113
- `long[] jArr5 = jArr`  L132
- `long j = jCurrentTimeMillis - jArr3[0]`  L135
- `long j2 = size - jArr[0]`  L137
- `long[] jArr5 = jArr4`  L156
- `String str = DialogAmbaSDMediaDownload.TAG`  L170

方法（14）：
- `public DialogAmbaSDMediaDownload(ComponentActivity componentActivity, Callback callback)`  L40
- `void onClick(View view)`  L55 @Override
- `void show()`  L62 @Override
- `void downloadAndShow(int i, FileListInfoResponseBean fileListInfoResponseBean)`  L67
- `void downloadAndShow(SparseArray<FileListInfoResponseBean> sparseArray)`  L73
- `void download(final SparseArray<FileListInfoResponseBean> sparseArray)`  L79
- `void onClick(View view)`  L83 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L96 @Override
    - 体内字面量："download onDismiss" · "1/" · "0%"
- `void onSuccessAll()`  L116 @Override
- `void onStartOne(int i3, FileListInfoResponseBean fileListInfoResponseBean, int i4)`  L122 @Override
    - 体内字面量："/" · "0%"
- `void onSuccessOne(int i3, FileListInfoResponseBean fileListInfoResponseBean, int i4)`  L130 @Override
- `void onProgressOne(int i3, FileListInfoResponseBean fileListInfoResponseBean, long j, long j2, int i4)`  L146 @Override
    - 体内字面量："%"
- `void onRefreshSpeed(int i3, FileListInfoResponseBean fileListInfoResponseBean, long j)`  L153 @Override
- `void onFailOne(int i3, FileListInfoResponseBean fileListInfoResponseBean, int i4)`  L166 @Override
    - 体内字面量："\n" · ":"
### `com.gku.module_camera.amba.dialog.DialogAmbaSDMediaDownload$Callback`
L34 · [interface] public Callback · `com/gku/module_camera/amba/dialog/DialogAmbaSDMediaDownload.java`

方法（2）：
- `void onDismiss()`  L35
- `void onSuccessOne(int i, int i2)`  L37
### `com.gku.module_camera.amba.dialog.DialogAmbaSDMediaMenu`
L13 · [class] public DialogAmbaSDMediaMenu · extends `BaseDialog` · `com/gku/module_camera/amba/dialog/DialogAmbaSDMediaMenu.java`

字段/常量（4）：
- `TextView tv_length`  L14
- `TextView tv_name`  L15
- `TextView tv_path`  L16
- `TextView tv_time`  L17

方法（3）：
- `public DialogAmbaSDMediaMenu(ComponentActivity componentActivity, final FileListInfoResponseBean fileListInfoResponseBean, final Callback callback)`  L25
- `void onClick(View view)`  L38 @Override
- `void onClick(View view)`  L45 @Override
### `com.gku.module_camera.amba.dialog.DialogAmbaSDMediaMenu$Callback`
L19 · [interface] public Callback · `com/gku/module_camera/amba/dialog/DialogAmbaSDMediaMenu.java`

方法（2）：
- `void onDeleteClick(FileListInfoResponseBean fileListInfoResponseBean)`  L20
- `void onDownloadClick(FileListInfoResponseBean fileListInfoResponseBean)`  L22
### `com.gku.module_camera.amba.dialog.DialogDownloadSoft`
L22 · [class] public final DialogDownloadSoft · extends `BaseDialog` · `com/gku/module_camera/amba/dialog/DialogDownloadSoft.java`
注解：

字段/常量（8）：
- `Callback callback`  L23
- `ComponentActivity componentActivity`  L24
- `ProgressBar progressBar`  L25
- `TextView tv_progress`  L26
- `String url`  L27
- `ComponentActivity componentActivity = this.componentActivity`  L65
- `ComponentActivity componentActivity2 = componentActivity`  L66
- `ComponentActivity componentActivity3 = componentActivity`  L67

方法（8）：
- `public DialogDownloadSoft(ComponentActivity componentActivity, Callback callback)`  L36
    - 体内字面量："componentActivity" · "callback"
- `void onClick(View view)`  L48 @Override
- `void _init_$lambda$0(DialogDownloadSoft dialogDownloadSoft, View view)`  L55
- `void dowonload(String url)`  L60
    - 体内字面量："url"
- `void onStarted__()`  L72 @Override
- `void onLoading__(int percent, float per, long total, long current, boolean isDownloading)`  L76 @Override
    - 体内字面量："%"
- `void onSuccess__(File file)`  L82 @Override
    - 体内字面量："file"
- `void onFail(int code, String errorMsg)`  L89 @Override
    - 体内字面量：":"
### `com.gku.module_camera.amba.dialog.DialogDownloadSoft$Callback`
L31 · [interface] public Callback · `com/gku/module_camera/amba/dialog/DialogDownloadSoft.java`
注解：

方法（1）：
- `void onSuccess(File file)`  L32
### `com.gku.module_camera.amba.dialog.DialogSendSoft`
L20 · [class] public final DialogSendSoft · extends `BaseDialog` · `com/gku/module_camera/amba/dialog/DialogSendSoft.java`
注解：

字段/常量（4）：
- `Callback callback`  L21
- `ComponentActivity componentActivity`  L22
- `ProgressBar progressBar`  L23
- `TextView tv_progress`  L24

方法（7）：
- `public DialogSendSoft(ComponentActivity componentActivity, Callback callback)`  L33
    - 体内字面量："componentActivity" · "callback"
- `void onClick(View view)`  L44 @Override
- `void send(File file)`  L50
    - 体内字面量："file"
- `void onFail(int code)`  L55 @Override
- `void onProgress(long current, long contentLength, int percent)`  L59 @Override
- `void onRefreshSpeed(long bytesPerSecond)`  L63 @Override
- `void onSuccess()`  L67 @Override
### `com.gku.module_camera.amba.dialog.DialogSendSoft$Callback`
L28 · [interface] public Callback · `com/gku/module_camera/amba/dialog/DialogSendSoft.java`
注解：

方法（1）：
- `void onSuccess(File file)`  L29
### `com.gku.module_camera.amba.SingleInstanceAmba`
L12 · [class] public SingleInstanceAmba · `com/gku/module_camera/amba/SingleInstanceAmba.java`

字段/常量（3）：
- `List<FileListInfoResponseBean> listMedia`  L13
- `List<FileListInfoResponseBean> listPic`  L14
- `List<FileListInfoResponseBean> listVideo`  L15

方法（9）：
- `private SingleInstanceAmba()`  L17
- `SingleInstanceAmba getInstance()`  L30
- `List<FileListInfoResponseBean> getListMedia()`  L34
- `void addMedia(FileListInfoResponseBean fileListInfoResponseBean)`  L38
- `void sortMedia()`  L42
- `int compare(FileListInfoResponseBean fileListInfoResponseBean, FileListInfoResponseBean fileListInfoResponseBean2)`  L45 @Override
    - 体内字面量："\\D+" · "\\D+"
- `void clearAll()`  L63
- `List<FileListInfoResponseBean> getListPic()`  L69
- `List<FileListInfoResponseBean> getListVideo()`  L73
### `com.gku.module_camera.amba.SingleInstanceAmba$Holder`
L23 · [class] private static Holder · `com/gku/module_camera/amba/SingleInstanceAmba.java`

方法（1）：
- `private Holder()`  L26