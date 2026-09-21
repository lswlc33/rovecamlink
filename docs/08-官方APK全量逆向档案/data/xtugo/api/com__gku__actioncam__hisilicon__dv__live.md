# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.live

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 9 个文件 / 15 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.live.adapter.CameraModelRecAdapter`
L15 · [class] public CameraModelRecAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/hisilicon/dv/live/adapter/CameraModelRecAdapter.java`

字段/常量（2）：
- `ArrayList<NewAppModelItem> list`  L16
- `OnItemClickListener mOnItemClickListener`  L17

方法（6）：
- `void setOnItemClickListener(OnItemClickListener mOnItemClickListener)`  L23
- `public CameraModelRecAdapter(ArrayList<NewAppModelItem> list)`  L27
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L32 @Override
- `void onBindViewHolder(final ViewHolder holder, final int position)`  L37 @Override
- `void onClick(View v)`  L44 @Override
- `int getItemCount()`  L53 @Override
### `com.gku.actioncam.hisilicon.dv.live.adapter.CameraModelRecAdapter$OnItemClickListener`
L19 · [interface] public OnItemClickListener · `com/gku/actioncam/hisilicon/dv/live/adapter/CameraModelRecAdapter.java`

方法（1）：
- `void onItemClick(View view, int position)`  L20
### `com.gku.actioncam.hisilicon.dv.live.adapter.CameraModelRecAdapter$ViewHolder`
L57 · [class] public ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/hisilicon/dv/live/adapter/CameraModelRecAdapter.java`

字段/常量（4）：
- `ImageView ItemIcon`  L58
- `LinearLayout ItemLayout`  L59
- `ImageView ItemSelect`  L60
- `TextView ModelName`  L61

方法（1）：
- `public ViewHolder(View itemView)`  L63
### `com.gku.actioncam.hisilicon.dv.live.mode.CameraConnectInfor`
L7 · [class] public CameraConnectInfor · implements `Parcelable` · `com/gku/actioncam/hisilicon/dv/live/mode/CameraConnectInfor.java`

字段/常量（4）：
- `String Model`  L21
- `String event`  L22
- `String state`  L23
- `String time`  L24

方法（16）：
- `CameraConnectInfor createFromParcel(Parcel source)`  L11 @Override
- `CameraConnectInfor[] newArray(int size)`  L17 @Override
- `int describeContents()`  L27 @Override
- `public CameraConnectInfor(String model, String state, String event, String time)`  L31
- `String getModel()`  L38
- `void setModel(String model)`  L42
- `String getState()`  L46
- `void setState(String state)`  L50
- `String getEvent()`  L54
- `void setEvent(String event)`  L58
- `String getTime()`  L62
- `void setTime(String time)`  L66
- `Parcelable.Creator<CameraConnectInfor> getCREATOR()`  L70
- `void writeToParcel(Parcel dest, int flags)`  L75 @Override
- `public CameraConnectInfor()`  L82
- `protected CameraConnectInfor(Parcel in)`  L85
### `com.gku.actioncam.hisilicon.dv.live.mode.CameraStatusCallback`
L4 · [interface] public CameraStatusCallback · `com/gku/actioncam/hisilicon/dv/live/mode/CameraStatusCallback.java`

方法（2）：
- `void failure()`  L5
- `void success()`  L7
### `com.gku.actioncam.hisilicon.dv.live.mode.NewAppModelItem`
L6 · [class] public NewAppModelItem · implements `Serializable` · `com/gku/actioncam/hisilicon/dv/live/mode/NewAppModelItem.java`

字段/常量（5）：
- `boolean IsSelect`  L7
- `int ModelIconId`  L8
- `String ModelName`  L9
- `String TAG`  L10
- `String smdStr`  L11

方法（11）：
- `public NewAppModelItem(String modelName, int modelIconId, boolean isSelect, String smdStr, String TAG)`  L13
- `String getSmdStr()`  L21
- `void setSmdStr(String smdStr)`  L25
- `String getModelName()`  L29
- `void setModelName(String modelName)`  L33
- `int getModelIconId()`  L37
- `void setModelIconId(int modelIconId)`  L41
- `boolean isSelect()`  L45
- `void setSelect(boolean select)`  L49
- `String getTAG()`  L53
- `void setTAG(String TAG)`  L57
### `com.gku.actioncam.hisilicon.dv.live.PopupWindowMode`
L16 · [class] public PopupWindowMode · extends `PopupWindow` · `com/gku/actioncam/hisilicon/dv/live/PopupWindowMode.java`

字段/常量（8）：
- `ImageView[] ivSelected`  L17
- `LinearLayout layoutRowModeBurst`  L18
- `LinearLayout layoutRowModePhoto`  L19
- `LinearLayout layoutRowModeTimelapse`  L20
- `LinearLayout layoutRowModeTimer`  L21
- `LinearLayout layoutRowModeVideo`  L22
- `LinearLayout layoutRowModeVideoLoop`  L23
- `LinearLayout layoutRowModeVideoTimelapse`  L24

方法（2）：
- `public PopupWindowMode(Context context, int newMode)`  L26
- `void onClick(View view)`  L49 @Override
### `com.gku.actioncam.hisilicon.dv.live.SyncMessageManager`
L11 · [class] public SyncMessageManager · `com/gku/actioncam/hisilicon/dv/live/SyncMessageManager.java`

字段/常量（16）：
- `int MSG_SYNC_SETTING = 1`  L12
- `int MSG_SYNC_STATE = 0`  L13
- `int REMOTE_STATE_START_BURST = 9`  L14
- `int REMOTE_STATE_START_LOOPRECORD = 0`  L15
- `int REMOTE_STATE_START_RECORD = 1`  L16
- `int REMOTE_STATE_START_RECORD_TIMELAPSE = 8`  L17
- `int REMOTE_STATE_START_TIMELAPSE = 2`  L18
- `int REMOTE_STATE_START_TIMER = 3`  L19
- `int REMOTE_STATE_STOP_BURST = 10`  L20
- `int REMOTE_STATE_STOP_RECORD = 4`  L21
- `int REMOTE_STATE_STOP_TIMELAPSE = 5`  L22
- `int REMOTE_STATE_STOP_TIMER = 6`  L23
- `int REMOTE_STATE_UPDATE = 11`  L24
- `String TAG = "SyncMessageManager"`  L25
- `int i = message.what`  L44
- `int i = message.what`  L80

方法（2）：
- `Message parseSyncMessage(String data)`  L27
    - 体内字面量："45434354366986777777" · "parseSyncMessage:  ----------------------    " · "type" · "syncStateMessage.state=" · "state" · "syncStateMessage.event=" · "event" · "syncStateMessage.pasttime=" · "pasttime" · "syncStateMessage.mode=" · "mode"
- `Message parseSyncMessageStr(String data)`  L67
    - 体内字面量："abcdef" · "parseSyncMessageStr:  -----------------   111" · "type"
### `com.gku.actioncam.hisilicon.dv.live.SyncStateMessage`
L4 · [class] public SyncStateMessage · `com/gku/actioncam/hisilicon/dv/live/SyncStateMessage.java`

字段/常量（4）：
- `int event`  L5
- `int mode`  L6
- `int pasttime`  L7
- `int state`  L8
### `com.gku.actioncam.hisilicon.dv.live.SyncStateMessageStr`
L4 · [class] public SyncStateMessageStr · `com/gku/actioncam/hisilicon/dv/live/SyncStateMessageStr.java`

字段/常量（4）：
- `long event`  L5
- `String mode`  L6
- `int pasttime`  L7
- `int state`  L8

方法（1）：
- `String toString()`  L10
    - 体内字面量："SyncStateMessageStr{mode='" · "', state=" · ", event=" · ", pasttime=" · "}"
### `com.gku.actioncam.hisilicon.dv.live.TelevisionActivity`
L40 · [class] public TelevisionActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java`

字段/常量（25）：
- `int MSG_CHECK_WAKEUP = 4097`  L41
- `int MSG_START_PLAYER = 4096`  L42
- `int MSG_WAKE_SUCCESSS = 4098`  L43
- `String TAG = "TelevisionActivity"`  L44
- `boolean bSurfaceOK`  L45
- `ImageView imageCover`  L46
- `ImageView imageLogo`  L47
- `ImageView imagePower`  L48
- `ProgressBar pbWakingProgress`  L49
- `HiCamPlayer player`  L50
- `SurfaceView surfaceView`  L51
- `ImageView[] thumbs`  L52
- `WifiBroadcastReceiver wifiReceiver`  L53
- `long timeWakeStart = -1`  L54
- `long timeWakeSuccess = -1`  L55
- `long timePlaySuccess = -1`  L56
- `IOException e`  L83
- `DatagramSocket datagramSocket`  L84
- `?? r0 = 4`  L86
- `?? r2 = 0`  L87
- `int i = 0`  L172
- `ImageView[] imageViewArr = new ImageView[4]`  L174
- `ImageView[] imageViewArr2 = this.thumbs`  L182
- `WifiBroadcastReceiver wifiBroadcastReceiver = this.wifiReceiver`  L251
- `Handler handler`  L283

方法（11）：
- `void handleMessage(Message msg)`  L60 @Override
- `void run()`  L82 @Override
- `void onCreate(Bundle savedInstanceState)`  L161 @Override
    - 体内字面量："wifi"
- `void onClick(View v)`  L197 @Override
    - 体内字面量："Waking"
- `void run()`  L205 @Override
    - 体内字面量："Wake up Start"
- `void run()`  L215 @Override
    - 体内字面量："Sleeping"
- `void onDestroy()`  L231 @Override
- `void onStart()`  L236 @Override
    - 体内字面量："android.net.wifi.STATE_CHANGE"
- `void onStop()`  L249 @Override
- `void startPlayer()`  L282
- `void destroyPlayer()`  L325
    - 体内字面量："Destroy Player ---"
### `com.gku.actioncam.hisilicon.dv.live.TelevisionActivity$AhPlayerListener`
L334 · [class] AhPlayerListener · implements `HiCamPlayer.HiCamPlayerStateListener` · `com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java`

方法（5）：
- `void onASRChange(HiCamPlayer player)`  L336 @Override
- `void onBufferingUpdate(HiCamPlayer player, int percent)`  L340 @Override
- `void onFinish(HiCamPlayer player)`  L344 @Override
- `void onStateChange(HiCamPlayer player, HiCamPlayer.HiCamPlayerState state)`  L348 @Override
- `void onError(HiCamPlayer player, String msg, int extra)`  L355 @Override
    - 体内字面量："player onError "
### `com.gku.actioncam.hisilicon.dv.live.TelevisionActivity$SurfaceHolderCallback`
L258 · [class] SurfaceHolderCallback · implements `SurfaceHolder.Callback` · `com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java`

方法（3）：
- `void surfaceChanged(SurfaceHolder holder, int format, int width, int height)`  L260 @Override
- `void surfaceCreated(SurfaceHolder holder)`  L267 @Override
    - 体内字面量："surfaceCreated"
- `void surfaceDestroyed(SurfaceHolder holder)`  L274 @Override
    - 体内字面量："surfaceDestroyed"
### `com.gku.actioncam.hisilicon.dv.live.TelevisionActivity$ThumbClickListener`
L361 · [class] ThumbClickListener · implements `View.OnClickListener` · `com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java`

方法（1）：
- `void onClick(View v)`  L366 @Override
    - 体内字面量："file:///storage/emulated/0/DCIM/ActionCam/download/a_aba.mp4" · "file:///storage/emulated/0/DCIM/ActionCam/download/b_longji.mp4" · "file:///storage/emulated/0/DCIM/ActionCam/download/c_mabuer.mp4" · "file:///storage/emulated/0/DCIM/ActionCam/download/d_dive.mp4" · "android.intent.action.VIEW" · "com.gku.actioncam.hisilicon.android.videoplayer" · "com.gku.actioncam.hisilicon.android.videoplayer.activity.VideoActivity"
### `com.gku.actioncam.hisilicon.dv.live.TelevisionActivity$WifiBroadcastReceiver`
L375 · [class] WifiBroadcastReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/hisilicon/dv/live/TelevisionActivity.java`

字段/常量（1）：
- `WifiInfo connectionInfo`  L381

方法（1）：
- `void onReceive(Context context, Intent intent)`  L380 @Override