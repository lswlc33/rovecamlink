# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.bluetooth

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 22 个文件 / 29 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.bluetooth.adapter.BaseArrayListAdapter`
L12 · [class] public abstract BaseArrayListAdapter · extends `BaseAdapter` · `com/gku/actioncam/sigmastar/bluetooth/adapter/BaseArrayListAdapter.java`

字段/常量（7）：
- `Context mContext`  L13
- `List<T> mDatas`  L14
- `float mDensity`  L15
- `LayoutInflater mInflater`  L16
- `int mScreenHeight`  L17
- `int mScreenWidth`  L18
- `List<T> list = this.mDatas`  L141

方法（19）：
- `long getItemId(int position)`  L21 @Override
- `public BaseArrayListAdapter(Context context)`  L25
    - 体内字面量："window"
- `public BaseArrayListAdapter(Context context, List<T> datas)`  L36
- `Context getContext()`  L46
- `LayoutInflater getInflater()`  L50
- `int getScreenWidth()`  L54
- `int getScreenHeight()`  L58
- `List<T> getAllData()`  L62
- `void addHead(T datas)`  L66
- `void addHead(List<T> datas)`  L73
- `void add(T datas)`  L82
- `void add(int position, T datas)`  L89
- `void update(int position, T datas)`  L97
- `void addAll(List<T> datas)`  L106
- `void refreshData(List<T> datas)`  L113
- `void clear()`  L121
- `void delete(int position)`  L126
- `int getCount()`  L135 @Override
- `Object getItem(int position)`  L140 @Override
### `com.gku.actioncam.sigmastar.bluetooth.adapter.BluetoothPagerAdapter`
L9 · [class] public BluetoothPagerAdapter · extends `FragmentStateAdapter` · `com/gku/actioncam/sigmastar/bluetooth/adapter/BluetoothPagerAdapter.java`

字段/常量（1）：
- `List<Fragment> fragments`  L10

方法（3）：
- `public BluetoothPagerAdapter(FragmentActivity fragmentActivity, List<Fragment> fragments)`  L12
- `Fragment createFragment(int position)`  L18 @Override
- `int getItemCount()`  L23 @Override
### `com.gku.actioncam.sigmastar.bluetooth.adapter.TopPopupListAdapter`
L15 · [class] public TopPopupListAdapter · extends `RecyclerView.Adapter<ViewHolder> implements Serializable` · implements `Serializable` · `com/gku/actioncam/sigmastar/bluetooth/adapter/TopPopupListAdapter.java`

字段/常量（4）：
- `OnItemClickListener onItemClickListener`  L16
- `List<String> scanList`  L17
- `ViewHolder viewHolder`  L18
- `List<String> list = this.scanList`  L49

方法（7）：
- `public TopPopupListAdapter(List<String> scanList)`  L24
- `ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)`  L29 @Override
- `void onBindViewHolder(ViewHolder holder, final int position)`  L34 @Override
- `void onClick(View v)`  L38 @Override
- `int getItemCount()`  L48 @Override
- `void setOnItemClickListener(OnItemClickListener onItemClickListener)`  L56
- `void refreshText(List<String> data)`  L60
### `com.gku.actioncam.sigmastar.bluetooth.adapter.TopPopupListAdapter$OnItemClickListener`
L20 · [interface] public OnItemClickListener · extends `Serializable` · `com/gku/actioncam/sigmastar/bluetooth/adapter/TopPopupListAdapter.java`

方法（1）：
- `void onItemClick(int position)`  L21
### `com.gku.actioncam.sigmastar.bluetooth.adapter.TopPopupListAdapter$ViewHolder`
L64 · [class] public static ViewHolder · extends `RecyclerView.ViewHolder implements Serializable` · implements `Serializable` · `com/gku/actioncam/sigmastar/bluetooth/adapter/TopPopupListAdapter.java`

字段/常量（3）：
- `Button popup_button`  L65
- `ImageView popup_image`  L66
- `TextView popup_text`  L67

方法（1）：
- `public ViewHolder(View itemView)`  L69
### `com.gku.actioncam.sigmastar.bluetooth.callback.TopPopupClickCallback`
L4 · [interface] public TopPopupClickCallback · `com/gku/actioncam/sigmastar/bluetooth/callback/TopPopupClickCallback.java`

方法（1）：
- `void onClick(int position)`  L5
### `com.gku.actioncam.sigmastar.bluetooth.Constants`
L6 · [class] public Constants · `com/gku/actioncam/sigmastar/bluetooth/Constants.java`

字段/常量（7）：
- `String FILTER_NAME = "name"`  L8
- `String FILTER_RSSI = "rssi"`  L9
- `String FILTER_SWITCH = "switch"`  L10
- `String PAUSE_PERIOD = "pause"`  L11
- `String SCAN_PERIOD = "scan"`  L12
- `String SHOW_SPINNER = "spinner"`  L13
- `String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"`  L14
### `com.gku.actioncam.sigmastar.bluetooth.containers.BluetoothLeDeviceStore`
L15 · [class] public BluetoothLeDeviceStore · `com/gku/actioncam/sigmastar/bluetooth/containers/BluetoothLeDeviceStore.java`

字段/常量（2）：
- `FileWriter fileWriter`  L46
- `FileWriter fileWriter2 = null`  L47

方法（6）：
- `void addDevice(final BluetoothLeDevice device)`  L18
- `void clear()`  L26
- `List<BluetoothLeDevice> getDeviceList()`  L30
- `int compare(final BluetoothLeDevice arg0, final BluetoothLeDevice arg1)`  L34 @Override
- `int size()`  L41
- `FileWriter generateFile(final File file, final String contents)`  L45
### `com.gku.actioncam.sigmastar.bluetooth.DiffuseView`
L14 · [class] public DiffuseView · extends `View` · `com/gku/actioncam/sigmastar/bluetooth/DiffuseView.java`

字段/常量（12）：
- `List<Integer> mAlphas`  L15
- `int mColor`  L16
- `int mCoreColor`  L17
- `float mCoreRadius`  L18
- `int mDiffuseSpeed`  L19
- `int mDiffuseWidth`  L20
- `boolean mIsDiffuse`  L21
- `Integer mMaxWidth`  L22
- `Paint mPaint`  L23
- `List<Integer> mWidths`  L24
- `int i = 0`  L84
- `List<Integer> list = this.mWidths`  L99

方法（16）：
- `public DiffuseView(Context context)`  L26
- `public DiffuseView(Context context, AttributeSet attrs)`  L30
- `public DiffuseView(Context context, AttributeSet attrs, int defStyleAttr)`  L34
- `void init()`  L56
- `void invalidate()`  L65 @Override
- `void onWindowFocusChanged(boolean hasWindowFocus)`  L72 @Override
- `void onDraw(Canvas canvas)`  L80 @Override
- `void start()`  L113
- `void stop()`  L118
- `boolean isDiffuse()`  L127
- `void setColor(int colorId)`  L131
- `void setCoreColor(int colorId)`  L135
- `void setCoreRadius(int radius)`  L139
- `void setDiffuseWidth(int width)`  L143
- `void setMaxWidth(int maxWidth)`  L147
- `void setDiffuseSpeed(int speed)`  L151
### `com.gku.actioncam.sigmastar.bluetooth.event.UpdateEvent`
L4 · [class] public UpdateEvent · `com/gku/actioncam/sigmastar/bluetooth/event/UpdateEvent.java`

字段/常量（4）：
- `int arg1`  L5
- `String msg`  L6
- `Object obj`  L7
- `Type type`  L8

方法（12）：
- `public UpdateEvent(Type type)`  L20
- `public UpdateEvent(Type type, Object obj)`  L24
- `public UpdateEvent(Type type, Object obj, String msg)`  L29
- `public UpdateEvent(Type type, int arg1)`  L35
- `int getArg1()`  L40
- `void setArg1(int arg1)`  L44
- `String getMsg()`  L48
- `void setMsg(String msg)`  L52
- `Type getType()`  L56
- `void setType(Type type)`  L60
- `Object getObj()`  L64
- `void setObj(Object obj)`  L68
### `com.gku.actioncam.sigmastar.bluetooth.event.UpdateEvent$Type`
L10 · [enum] public Type · `com/gku/actioncam/sigmastar/bluetooth/event/UpdateEvent.java`

枚举常量（6）：
- `SCAN_UPDATE()`  L11
- `BLE_DATA()`  L12
- `POP_SHOW()`  L13
- `TAB_SWITCH()`  L14
- `CONFIG_CHANGE()`  L15
- `SCAN_STOP()`  L16
### `com.gku.actioncam.sigmastar.bluetooth.Permission.PermissionListener`
L6 · [interface] public PermissionListener · `com/gku/actioncam/sigmastar/bluetooth/Permission/PermissionListener.java`

方法（2）：
- `void onDenied(List<String> deniedPermissions)`  L7
- `void onGranted()`  L9
### `com.gku.actioncam.sigmastar.bluetooth.Permission.PermissionRequest`
L10 · [class] public PermissionRequest · extends `Activity` · `com/gku/actioncam/sigmastar/bluetooth/Permission/PermissionRequest.java`

字段/常量（8）：
- `int REQUEST_PERMISSION_CODE = 1`  L11
- `String TAG = "PermissionRequest"`  L12
- `PermissionListener mListener`  L13
- `PermissionListener permissionListener2 = mListener`  L24
- `PermissionListener permissionListener3 = mListener`  L31
- `String str = permissions[i]`  L43
- `PermissionListener permissionListener = mListener`  L49
- `PermissionListener permissionListener2 = mListener`  L57

方法（2）：
- `void requestRuntimePermission(Context context, String[] permissions, PermissionListener permissionListener)`  L15
- `void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)`  L38 @Override
### `com.gku.actioncam.sigmastar.bluetooth.ui.PopupDialogActivity`
L33 · [class] public PopupDialogActivity · extends `FragmentActivity` · `com/gku/actioncam/sigmastar/bluetooth/ui/PopupDialogActivity.java`

字段/常量（20）：
- `int FLING_MIN_DISTANCE = 40`  L34
- `int FLING_MIN_VELOCITY = 400`  L35
- `String TAG = "PopupDialogActivity"`  L36
- `GestureDetector.OnGestureListener Listener`  L37
- `String deviceName`  L38
- `GestureDetector gestureDetector`  L39
- `boolean isConnected`  L40
- `String pwd`  L41
- `List<String> scanList`  L42
- `String ssid`  L43
- `RecyclerView topPopupList`  L44
- `TopPopupListAdapter topPopupListAdapter`  L45
- `float mPosX = 0.0f`  L46
- `float mPosY = 0.0f`  L47
- `float mCurPosX = 0.0f`  L48
- `float mCurPosY = 0.0f`  L49
- `boolean $assertionsDisabled = false`  L178
- `String str = PopupDialogActivity.this.ssid`  L206
- `String str2 = PopupDialogActivity.this.pwd`  L207
- `PopupDialogActivity popupDialogActivity = PopupDialogActivity.this`  L208

方法（16）：
- `void onReceive(Context context, Intent intent)`  L52 @Override
    - 体内字面量："onReceive: " · "ssid" · "pwd" · "deviceName"
- `void onResult(boolean success)`  L63 @Override
- `void startPopupDialog(Context context, boolean isConnected)`  L72
    - 体内字面量："isConnected"
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L81 @Override
    - 体内字面量："onActivityResult: " · "ssid" · "pwd" · "deviceName"
- `void onCreate(Bundle savedInstanceState)`  L94 @Override
    - 体内字面量："onCreate: " · " ; " · "onCreate: " · " ; " · "BluetoothData"
- `boolean onDown(MotionEvent e)`  L123 @Override
- `void onLongPress(MotionEvent e)`  L128 @Override
- `boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)`  L132 @Override
- `void onShowPress(MotionEvent e)`  L137 @Override
- `boolean onSingleTapUp(MotionEvent e)`  L141 @Override
- `boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)`  L146 @Override
    - 体内字面量："onFling: " · "isConnected"
- `void onItemClick(int position)`  L169 @Override
- `void onItemClick(int position)`  L181 @Override
    - 体内字面量："wifi" · "android.settings.WIFI_SETTINGS" · "XTU" · "wifidisableNet: "
- `void onDestroy()`  L224 @Override
- `void setFinishOnTouchOutside(boolean finish)`  L232 @Override
- `boolean onTouchEvent(MotionEvent event)`  L237 @Override
### `com.gku.actioncam.sigmastar.bluetooth.utils.BluetoothUtils`
L9 · [class] public final BluetoothUtils · `com/gku/actioncam/sigmastar/bluetooth/utils/BluetoothUtils.java`

字段/常量（5）：
- `int REQUEST_ENABLE_BT = 2001`  L10
- `Activity mActivity`  L11
- `BluetoothAdapter mBluetoothAdapter`  L12
- `BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter`  L21
- `BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter`  L37

方法（5）：
- `public BluetoothUtils(final Activity activity)`  L14
    - 体内字面量："bluetooth"
- `void askUserToEnableBluetoothIfNeeded()`  L19
- `BluetoothAdapter getBluetoothAdapter()`  L28
- `boolean isBluetoothLeSupported()`  L32
    - 体内字面量："android.hardware.bluetooth_le"
- `boolean isBluetoothOn()`  L36
### `com.gku.actioncam.sigmastar.bluetooth.utils.ByteUtils`
L19 · [class] public ByteUtils · `com/gku/actioncam/sigmastar/bluetooth/utils/ByteUtils.java`

字段/常量（10）：
- `String HEXES = "0123456789ABCDEF"`  L20
- `int length = array.length`  L28
- `boolean z = true`  L29
- `int i = 0`  L30
- `byte b = array[i]`  L32
- `char c`  L55
- `int length = charArray.length`  L57
- `int i = 0`  L60
- `int length = array.length`  L116
- `byte b = array[i]`  L118

方法（13）：
- `int getIntFromByte(final byte bite)`  L22
- `String byteArrayToHexString(final byte[] array)`  L26
    - 体内字面量："["
- `String byteArray2HexString(final byte[] array)`  L45
- `List<String> divideString(String s)`  L54
- `HashMap<String, String> divideString2(String s)`  L77
- `boolean doesArrayBeginWith(final byte[] array, final byte[] prefix)`  L91
- `int getIntFrom2ByteArray(final byte[] input)`  L103
- `int getIntFromByteArray(final byte[] bytes)`  L107
- `long getLongFromByteArray(final byte[] bytes)`  L111
- `void invertArray(final byte[] array)`  L115
- `String toString(SparseArray<byte[]> array)`  L125
    - 体内字面量："null" · "{}" · "{" · "}"
- `String toString(Map<T, byte[]> map)`  L142
    - 体内字面量："null" · "{}" · "{" · ", " · "}"
- `String bytes2String(byte[] b)`  L164
### `com.gku.actioncam.sigmastar.bluetooth.utils.GattAttributeResolver`
L9 · [class] public GattAttributeResolver · `com/gku/actioncam/sigmastar/bluetooth/utils/GattAttributeResolver.java`

字段/常量（175）：
- `String ACTIVESYNC = "831c4071-7bc8-4a9c-a01c-15df25a4adbc"`  L10
- `String ADVANCED_AUDIO = "0000110d-0000-1000-8000-00805f9b34fb"`  L11
- `String ALERT_CATEGORY_ID = "00002a43-0000-1000-8000-00805f9b34fb"`  L12
- `String ALERT_CATEGORY_ID_BIT_MASK = "00002a42-0000-1000-8000-00805f9b34fb"`  L13
- `String ALERT_LEVEL = "00002a06-0000-1000-8000-00805f9b34fb"`  L14
- `String ALERT_NOTIFICATION_CONTROL_POINT = "00002a44-0000-1000-8000-00805f9b34fb"`  L15
- `String ALERT_STATUS = "00002a3f-0000-1000-8000-00805f9b34fb"`  L16
- `String APPEARANCE = "00002a01-0000-1000-8000-00805f9b34fb"`  L17
- `String AUDIO_SINK = "0000110b-0000-1000-8000-00805f9b34fb"`  L18
- `String AUDIO_SOURCE = "0000110a-0000-1000-8000-00805f9b34fb"`  L19
- `String AUDIO_VIDEO = "0000112c-0000-1000-8000-00805f9b34fb"`  L20
- `String AVRCP_REMOTE = "0000110e-0000-1000-8000-00805f9b34fb"`  L21
- `String AV_REMOTE_CONTROL_TARGET = "0000110c-0000-1000-8000-00805f9b34fb"`  L22
- `String BASE_GUID = "00000000-0000-1000-8000-00805f9b34fb"`  L23
- `String BASIC_PRINTING = "00001122-0000-1000-8000-00805f9b34fb"`  L24
- `String BLOOD_PRESSURE_FEATURE = "00002a49-0000-1000-8000-00805f9b34fb"`  L25
- `String BLOOD_PRESSURE_MEASUREMENT = "00002a35-0000-1000-8000-00805f9b34fb"`  L26
- `String BNEP_SVC = "0000000f-0000-1000-8000-00805f9b34fb"`  L27
- `String BODY_SENSOR_LOCATION = "00002a38-0000-1000-8000-00805f9b34fb"`  L28
- `String BROWSE_GROUP_DESCRIPTOR = "00001001-0000-1000-8000-00805f9b34fb"`  L29
- `String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb"`  L30
- `String CMPT_PROTOCOL = "0000001b-0000-1000-8000-00805f9b34fb"`  L31
- `String COMMON_ISDN_ACCESS = "00001128-0000-1000-8000-00805f9b34fb"`  L32
- `String CORDLESS_TELEPHONY = "00001109-0000-1000-8000-00805f9b34fb"`  L33
- `String CSC_FEATURE = "00002a5c-0000-1000-8000-00805f9b34fb"`  L34
- `String CSC_MEASUREMENT = "00002a5b-0000-1000-8000-00805f9b34fb"`  L35
- `String CURRENT_TIME = "00002a2b-0000-1000-8000-00805f9b34fb"`  L36
- `String CYCLING_SC = "00001816-0000-1000-8000-00805f9b34fb"`  L37
- `String DATE_TIME = "00002a08-0000-1000-8000-00805f9b34fb"`  L38
- `String DAY_DATE_TIME = "00002a0a-0000-1000-8000-00805f9b34fb"`  L39
- `String DAY_OF_WEEK = "00002a09-0000-1000-8000-00805f9b34fb"`  L40
- `String DEVICE_INFORMATION = "0000180a-0000-1000-8000-00805f9b34fb"`  L41
- `String DEVICE_NAME = "00002a00-0000-1000-8000-00805f9b34fb"`  L42
- `String DIRECT_PRINTING = "00001118-0000-1000-8000-00805f9b34fb"`  L43
- `String DIRECT_PRINTING_REFERENCE_OBJECTS = "00001120-0000-1000-8000-00805f9b34fb"`  L44
- `String DST_OFFSET = "00002a0d-0000-1000-8000-00805f9b34fb"`  L45
- `String DUN_GW = "00001103-0000-1000-8000-00805f9b34fb"`  L46
- `String ESDP_UPNP_IP_LAP = "00001301-0000-1000-8000-00805f9b34fb"`  L47
- `String ESDP_UPNP_IP_PAN = "00001300-0000-1000-8000-00805f9b34fb"`  L48
- `String ESDP_UPNP_L2CAP = "00001302-0000-1000-8000-00805f9b34fb"`  L49
- `String ESTIMOTE_ADVERTISING_INTERVAL = "b9403012-f5f8-466e-aff9-25556b57fe6d"`  L50
- `String ESTIMOTE_ADVERTISING_SEED = "b9402001-f5f8-466e-aff9-25556b57fe6d"`  L51
- `String ESTIMOTE_ADVERTISING_VECTOR = "b9402002-f5f8-466e-aff9-25556b57fe6d"`  L52
- `String ESTIMOTE_AUTHENTICATION_SERVICE = "b9402000-f5f8-466e-aff9-25556b57fe6d"`  L53
- `String ESTIMOTE_BATTERY = "b9403041-f5f8-466e-aff9-25556b57fe6d"`  L54
- `String ESTIMOTE_HARDWARE_VERSION = "b9404002-f5f8-466e-aff9-25556b57fe6d"`  L55
- `String ESTIMOTE_MAJOR = "b9403001-f5f8-466e-aff9-25556b57fe6d"`  L56
- `String ESTIMOTE_MINOR = "b9403002-f5f8-466e-aff9-25556b57fe6d"`  L57
- `String ESTIMOTE_POWER = "b9403011-f5f8-466e-aff9-25556b57fe6d"`  L58
- `String ESTIMOTE_SERVICE = "b9403000-f5f8-466e-aff9-25556b57fe6d"`  L59
- `String ESTIMOTE_SOFTWARE_VERSION = "b9404001-f5f8-466e-aff9-25556b57fe6d"`  L60
- `String ESTIMOTE_TEMPERATURE = "b9403021-f5f8-466e-aff9-25556b57fe6d"`  L61
- `String ESTIMOTE_UUID = "b9403003-f5f8-466e-aff9-25556b57fe6d"`  L62
- `String ESTIMOTE_VERSION_SERVICE = "b9404000-f5f8-466e-aff9-25556b57fe6d"`  L63
- `String EXACT_TIME_256 = "00002a0c-0000-1000-8000-00805f9b34fb"`  L64
- `String FAX = "00001111-0000-1000-8000-00805f9b34fb"`  L65
- `String FIRMWARE_REVISION_STRING = "00002a26-0000-1000-8000-00805f9b34fb"`  L66
- `String FTP = "0000000a-0000-1000-8000-00805f9b34fb"`  L67
- `String GAP = "00001800-0000-1000-8000-00805f9b34fb"`  L68
- `String GATT = "00001801-0000-1000-8000-00805f9b34fb"`  L69
- `String GENERIC_AUDIO = "00001203-0000-1000-8000-00805f9b34fb"`  L70
- `String GENERIC_FILE_TRANSFER = "00001202-0000-1000-8000-00805f9b34fb"`  L71
- `String GENERIC_NETWORKING = "00001201-0000-1000-8000-00805f9b34fb"`  L72
- `String GENERIC_TELEPHONY = "00001204-0000-1000-8000-00805f9b34fb"`  L73
- `String GN = "00001117-0000-1000-8000-00805f9b34fb"`  L74
- `String HANDS_FREE_PROFILE_HFP = "0000111e-0000-1000-8000-00805f9b34fb"`  L75
- `String HANDS_FREE_PROFILE_HFP_AUDIO_GATEWAY = "0000111f-0000-1000-8000-00805f9b34fb"`  L76
- `String HARDCOPY_CABLE_REPLACEMENT = "00001125-0000-1000-8000-00805f9b34fb"`  L77
- `String HARDCOPY_CONTROL_CHANNEL_PROTOCOL = "00000012-0000-1000-8000-00805f9b34fb"`  L78
- `String HARDCOPY_DATA_CHANNEL_PROTOCOL = "00000014-0000-1000-8000-00805f9b34fb"`  L79
- `String HARDCOPY_NOTIFICATION_PROTOCOL = "00000016-0000-1000-8000-00805f9b34fb"`  L80
- `String HARDWARE_REVISION_STRING = "00002a27-0000-1000-8000-00805f9b34fb"`  L81
- `String HCR_PRINT = "00001126-0000-1000-8000-00805f9b34fb"`  L82
- `String HCR_SCAN = "00001127-0000-1000-8000-00805f9b34fb"`  L83
- `String HEADSET_PROFILE_HSP_AUDIO_GATEWAY = "00001112-0000-1000-8000-00805f9b34fb"`  L84
- `String HEALTH_DEVICE_PROFILE_HDP = "00001400-0000-1000-8000-00805f9b34fb"`  L85
- `String HEALTH_DEVICE_PROFILE_HDP_SINK = "00001402-0000-1000-8000-00805f9b34fb"`  L86
- `String HEALTH_DEVICE_PROFILE_HDP_SOURCE = "00001401-0000-1000-8000-00805f9b34fb"`  L87
- `String HEALTH_THERMOMETER = "00001809-0000-1000-8000-00805f9b34fb"`  L88
- `String HEART_RATE = "0000180d-0000-1000-8000-00805f9b34fb"`  L89
- `String HEART_RATE_CONTROL_POINT = "00002a39-0000-1000-8000-00805f9b34fb"`  L90
- `String HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb"`  L91
- `String HID = "00001124-0000-1000-8000-00805f9b34fb"`  L92
- `String HIDP = "00000011-0000-1000-8000-00805f9b34fb"`  L93
- `String HSP_HS = "00001108-0000-1000-8000-00805f9b34fb"`  L94
- `String HTTP = "0000000c-0000-1000-8000-00805f9b34fb"`  L95
- `String IEEE_1107320601_REGULATORY = "00002a2a-0000-1000-8000-00805f9b34fb"`  L96
- `String IMAGING = "0000111a-0000-1000-8000-00805f9b34fb"`  L97
- `String IMAGING_AUTOMATIC_ARCHIVE = "0000111c-0000-1000-8000-00805f9b34fb"`  L98
- `String IMAGING_REFERENCE_OBJECTS = "0000111d-0000-1000-8000-00805f9b34fb"`  L99
- `String IMAGING_RESPONDER = "0000111b-0000-1000-8000-00805f9b34fb"`  L100
- `String IMMEDIATE_ALERT = "00001802-0000-1000-8000-00805f9b34fb"`  L101
- `String INTERCOM = "00001110-0000-1000-8000-00805f9b34fb"`  L102
- `String INTERMEDIATE_CUFF_PRESSURE = "00002a36-0000-1000-8000-00805f9b34fb"`  L103
- `String INTERMEDIATE_TEMPERATURE = "00002a1e-0000-1000-8000-00805f9b34fb"`  L104
- `String IP = "00000009-0000-1000-8000-00805f9b34fb"`  L105
- `String IRMC_SYNC_COMMAND = "00001107-0000-1000-8000-00805f9b34fb"`  L106
- `String L2CAP = "00000100-0000-1000-8000-00805f9b34fb"`  L107
- `String LAN_ACCESS_USING_PPP = "00001102-0000-1000-8000-00805f9b34fb"`  L108
- `String LINK_LOSS = "00001803-0000-1000-8000-00805f9b34fb"`  L109
- `String LOCAL_TIME_INFORMATION = "00002a0f-0000-1000-8000-00805f9b34fb"`  L110
- `String MANUFACTURER_NAME_STRING = "00002a29-0000-1000-8000-00805f9b34fb"`  L111
- `String MCAP_CONTROL_CHANNEL = "0000001e-0000-1000-8000-00805f9b34fb"`  L112
- `String MCAP_DATA_CHANNEL = "0000001f-0000-1000-8000-00805f9b34fb"`  L113
- `String MEASUREMENT_INTERVAL = "00002a21-0000-1000-8000-00805f9b34fb"`  L114
- `String MODEL_NUMBER_STRING = "00002a24-0000-1000-8000-00805f9b34fb"`  L115
- `String NAP = "00001116-0000-1000-8000-00805f9b34fb"`  L116
- `String NEW_ALERT = "00002a46-0000-1000-8000-00805f9b34fb"`  L117
- `String OBEX_FILE_TRANSFER = "00001106-0000-1000-8000-00805f9b34fb"`  L118
- `String OBEX_MAP = "00001134-0000-1000-8000-00805f9b34fb"`  L119
- `String OBEX_MAS = "00001132-0000-1000-8000-00805f9b34fb"`  L120
- `String OBEX_MNS = "00001133-0000-1000-8000-00805f9b34fb"`  L121
- `String OBEX_OBJECT_PUSH = "00001105-0000-1000-8000-00805f9b34fb"`  L122
- `String OBEX_PBAP = "00001130-0000-1000-8000-00805f9b34fb"`  L123
- `String OBEX_PCE = "0000112e-0000-1000-8000-00805f9b34fb"`  L124
- `String OBEX_PSE = "0000112f-0000-1000-8000-00805f9b34fb"`  L125
- `String OBEX_SYNC = "00001104-0000-1000-8000-00805f9b34fb"`  L126
- `String OBJECT_EXCHANGE_PROTOCOL_OBEX = "00000008-0000-1000-8000-00805f9b34fb"`  L127
- `String PANU = "00001115-0000-1000-8000-00805f9b34fb"`  L128
- `String PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS = "00002a04-0000-1000-8000-00805f9b34fb"`  L129
- `String PERIPHERAL_PRIVACY_FLAG = "00002a02-0000-1000-8000-00805f9b34fb"`  L130
- `String PNP = "00001200-0000-1000-8000-00805f9b34fb"`  L131
- `String PNPID = "00002a50-0000-1000-8000-00805f9b34fb"`  L132
- `String PRINTING_STATUS = "00001123-0000-1000-8000-00805f9b34fb"`  L133
- `String PUBLIC_BROWSE_GROUP = "00001002-0000-1000-8000-00805f9b34fb"`  L134
- `String RADIO_FREQUENCY_COMMUNICATION_PROTOCOL_RFCOMM = "00000003-0000-1000-8000-00805f9b34fb"`  L135
- `String RECONNECTION_ADDRESS = "00002a03-0000-1000-8000-00805f9b34fb"`  L136
- `String REFERENCE_PRINTING = "00001119-0000-1000-8000-00805f9b34fb"`  L137
- `String REFERENCE_TIME_INFORMATION = "00002a14-0000-1000-8000-00805f9b34fb"`  L138
- `String REFLECTED_UI = "00001121-0000-1000-8000-00805f9b34fb"`  L139
- `String RINGER_CONTROL_POINT = "00002a40-0000-1000-8000-00805f9b34fb"`  L140
- `String RINGER_SETTING = "00002a41-0000-1000-8000-00805f9b34fb"`  L141
- `String SC_CONTROL_POINT = "00002a55-0000-1000-8000-00805f9b34fb"`  L142
- `String SENSOR_LOCATION = "00002a5d-0000-1000-8000-00805f9b34fb"`  L143
- `String SERIAL_NUMBER_STRING = "00002a25-0000-1000-8000-00805f9b34fb"`  L144
- `String SERVICE_CHANGED = "00002a05-0000-1000-8000-00805f9b34fb"`  L145
- `String SERVICE_DISCOVERY_PROTOCOL_SDP = "00000001-0000-1000-8000-00805f9b34fb"`  L146
- `String SERVICE_DISCOVERY_SERVER = "00001000-0000-1000-8000-00805f9b34fb"`  L147
- `String SIM_ACCESS = "0000112d-0000-1000-8000-00805f9b34fb"`  L148
- `String SOFTWARE_REVISION_STRING = "00002a28-0000-1000-8000-00805f9b34fb"`  L149
- `String SPP = "00001101-0000-1000-8000-00805f9b34fb"`  L150
- `String SUPPORTED_NEW_ALERT_CATEGORY = "00002a47-0000-1000-8000-00805f9b34fb"`  L151
- `String SUPPORTED_UNREAD_ALERT_CATEGORY = "00002a48-0000-1000-8000-00805f9b34fb"`  L152
- `String SYSTEM_ID = "00002a23-0000-1000-8000-00805f9b34fb"`  L153
- `String TCP = "00000004-0000-1000-8000-00805f9b34fb"`  L154
- `String TCSAT = "00000006-0000-1000-8000-00805f9b34fb"`  L155
- `String TCSBIN = "00000005-0000-1000-8000-00805f9b34fb"`  L156
- `String TEMPERATURE_MEASUREMENT = "00002a1c-0000-1000-8000-00805f9b34fb"`  L157
- `String TEMPERATURE_TYPE = "00002a1d-0000-1000-8000-00805f9b34fb"`  L158
- `String TIME_ACCURACY = "00002a12-0000-1000-8000-00805f9b34fb"`  L159
- `String TIME_SOURCE = "00002a13-0000-1000-8000-00805f9b34fb"`  L160
- `String TIME_UPDATE_CONTROL_POINT = "00002a16-0000-1000-8000-00805f9b34fb"`  L161
- `String TIME_UPDATE_STATE = "00002a17-0000-1000-8000-00805f9b34fb"`  L162
- `String TIME_WITH_DST = "00002a11-0000-1000-8000-00805f9b34fb"`  L163
- `String TIME_ZONE = "00002a0e-0000-1000-8000-00805f9b34fb"`  L164
- `String TX_POWER = "00001804-0000-1000-8000-00805f9b34fb"`  L165
- `String TX_POWER_LEVEL = "00002a07-0000-1000-8000-00805f9b34fb"`  L166
- `String UDIMT = "0000112a-0000-1000-8000-00805f9b34fb"`  L167
- `String UDITA = "0000112b-0000-1000-8000-00805f9b34fb"`  L168
- `String UDI_C_PLANE_PROTOCOL = "0000001d-0000-1000-8000-00805f9b34fb"`  L169
- `String UNREAD_ALERT_STATUS = "00002a45-0000-1000-8000-00805f9b34fb"`  L170
- `String UPNP = "00001205-0000-1000-8000-00805f9b34fb"`  L171
- `String UPNP_IP = "00001206-0000-1000-8000-00805f9b34fb"`  L172
- `String UPNP_PROTOCOL = "00000010-0000-1000-8000-00805f9b34fb"`  L173
- `String USER_DATAGRAM_PROTOCOL_UDP = "00000002-0000-1000-8000-00805f9b34fb"`  L174
- `String VCTP_PROTOCOL = "00000017-0000-1000-8000-00805f9b34fb"`  L175
- `String VDTP_PROTOCOL = "00000019-0000-1000-8000-00805f9b34fb"`  L176
- `String VIDEO_CONFERENCING = "0000110f-0000-1000-8000-00805f9b34fb"`  L177
- `String VIDEO_CONFERENCING_GATEWAY = "00001129-0000-1000-8000-00805f9b34fb"`  L178
- `String VIDEO_DISTRIBUTION_PROFILE_VDP = "00001305-0000-1000-8000-00805f9b34fb"`  L179
- `String VIDEO_DISTRIBUTION_PROFILE_VDP_SINK = "00001304-0000-1000-8000-00805f9b34fb"`  L180
- `String VIDEO_DISTRIBUTION_PROFILE_VDP_SOURCE = "00001303-0000-1000-8000-00805f9b34fb"`  L181
- `String WAP = "00001113-0000-1000-8000-00805f9b34fb"`  L182
- `String WAP_CLIENT = "00001114-0000-1000-8000-00805f9b34fb"`  L183
- `String WSP = "0000000e-0000-1000-8000-00805f9b34fb"`  L184

方法（2）：
- `String getAttributeName(final String uuid, final String fallback)`  L187
- `Map<String, String> populateGattAttributesMap()`  L192
    - 体内字面量："00000000-0000-1000-8000-00805f9b34fb" · "Base GUID" · "00000001-0000-1000-8000-00805f9b34fb" · "Service Discovery Protocol (SDP)" · "00000002-0000-1000-8000-00805f9b34fb" · "User Datagram Protocol (UDP)" · "00000003-0000-1000-8000-00805f9b34fb" · "Radio Frequency Communication Protocol (RFCOMM)" · "00000004-0000-1000-8000-00805f9b34fb" · "TCP" · "00000005-0000-1000-8000-00805f9b34fb" · "TCSBIN" · "00000006-0000-1000-8000-00805f9b34fb" · "TCSAT" · "00000008-0000-1000-8000-00805f9b34fb" · "Object Exchange Protocol (OBEX)" · "00000009-0000-1000-8000-00805f9b34fb" · "IP" · "0000000a-0000-1000-8000-00805f9b34fb" · "FTP" · "0000000c-0000-1000-8000-00805f9b34fb" · "0000000e-0000-1000-8000-00805f9b34fb" · "WSP" · "0000000f-0000-1000-8000-00805f9b34fb" · "BNEP_SVC" · "00000010-0000-1000-8000-00805f9b34fb" · "UPNP Protocol" · "00000011-0000-1000-8000-00805f9b34fb" · "HIDP" · "00000012-0000-1000-8000-00805f9b34fb" · "Hardcopy Control Channel Protocol" · "00000014-0000-1000-8000-00805f9b34fb" · "Hardcopy Data Channel Protocol" · "00000016-0000-1000-8000-00805f9b34fb" · "Hardcopy Notification Protocol" · "00000017-0000-1000-8000-00805f9b34fb" · "VCTP Protocol" · "00000019-0000-1000-8000-00805f9b34fb" · "VDTP Protocol" · "0000001b-0000-1000-8000-00805f9b34fb" · "CMPT Protocol" · "0000001d-0000-1000-8000-00805f9b34fb" · "UDI C Plane Protocol" · "0000001e-0000-1000-8000-00805f9b34fb" · "MCAP Control Channel" · "0000001f-0000-1000-8000-00805f9b34fb" · "MCAP Data Channel" · "00000100-0000-1000-8000-00805f9b34fb" · "L2CAP" · "00001000-0000-1000-8000-00805f9b34fb" · "Service Discovery Server" · "00001001-0000-1000-8000-00805f9b34fb" · "Browse Group Descriptor" · "00001002-0000-1000-8000-00805f9b34fb" · "Public Browse Group" · "00001101-0000-1000-8000-00805f9b34fb" · "SPP" · "00001102-0000-1000-8000-00805f9b34fb" · "LAN Access Using PPP" · "00001103-0000-1000-8000-00805f9b34fb" · "DUN_GW" · "00001104-0000-1000-8000-00805f9b34fb" · "OBEX_SYNC" · "00001105-0000-1000-8000-00805f9b34fb" · "OBEX Object Push" · "00001106-0000-1000-8000-00805f9b34fb" · "OBEX File Transfer" · "00001107-0000-1000-8000-00805f9b34fb" · "IrMC Sync Command" · "00001108-0000-1000-8000-00805f9b34fb" · "HSP_HS" · "00001109-0000-1000-8000-00805f9b34fb" · "Cordless Telephony" · "0000110a-0000-1000-8000-00805f9b34fb" · "Audio Source" · "0000110b-0000-1000-8000-00805f9b34fb" · "Audio Sink" · "0000110c-0000-1000-8000-00805f9b34fb" · "AV Remote Control Target" · "0000110d-0000-1000-8000-00805f9b34fb" · "ADVANCED_AUDIO" · "0000110e-0000-1000-8000-00805f9b34fb" · "AVRCP_REMOTE" · "0000110f-0000-1000-8000-00805f9b34fb" · "Video Conferencing" · "00001110-0000-1000-8000-00805f9b34fb" · "Intercom" · "00001111-0000-1000-8000-00805f9b34fb" · "FAX" · "00001112-0000-1000-8000-00805f9b34fb" · "Headset Profile (HSP) - Audio Gateway" · "00001113-0000-1000-8000-00805f9b34fb" · "WAP" · "00001114-0000-1000-8000-00805f9b34fb" · "WAP Client" · "00001115-0000-1000-8000-00805f9b34fb" · "PANU" · "00001116-0000-1000-8000-00805f9b34fb" · "NAP" · "00001117-0000-1000-8000-00805f9b34fb" · "GN" · "00001118-0000-1000-8000-00805f9b34fb" · "Direct Printing" · "00001119-0000-1000-8000-00805f9b34fb" · "Reference Printing" · "0000111a-0000-1000-8000-00805f9b34fb" · "Imaging" · "0000111b-0000-1000-8000-00805f9b34fb" · "Imaging Responder" · "0000111c-0000-1000-8000-00805f9b34fb" · "Imaging Automatic Archive" · "0000111d-0000-1000-8000-00805f9b34fb" · "Imaging Reference Objects" · "0000111e-0000-1000-8000-00805f9b34fb" · "Hands Free Profile (HFP)" · "0000111f-0000-1000-8000-00805f9b34fb" · "Hands Free Profile (HFP) â Audio Gateway" · "00001120-0000-1000-8000-00805f9b34fb" · "Direct Printing Reference Objects" · "00001121-0000-1000-8000-00805f9b34fb" · "Reflected UI" · "00001122-0000-1000-8000-00805f9b34fb" · "Basic Printing" · "00001123-0000-1000-8000-00805f9b34fb" · "Printing Status" · "00001124-0000-1000-8000-00805f9b34fb" · "HID" · "00001125-0000-1000-8000-00805f9b34fb" · "Hardcopy Cable Replacement" · "00001126-0000-1000-8000-00805f9b34fb" · "HCR Print" · "00001127-0000-1000-8000-00805f9b34fb" · "HCR Scan" · "00001128-0000-1000-8000-00805f9b34fb" · "Common ISDN Access" · "00001129-0000-1000-8000-00805f9b34fb" · "Video Conferencing Gateway" · "0000112a-0000-1000-8000-00805f9b34fb" · "UDIMT" · "0000112b-0000-1000-8000-00805f9b34fb" · "UDITA" · "0000112c-0000-1000-8000-00805f9b34fb" · "Audio Video" · "0000112d-0000-1000-8000-00805f9b34fb" · "SIM Access" · "0000112e-0000-1000-8000-00805f9b34fb" · "OBEX PCE" · "0000112f-0000-1000-8000-00805f9b34fb" · "OBEX PSE" · "00001130-0000-1000-8000-00805f9b34fb" · "OBEX PBAP" · "00001132-0000-1000-8000-00805f9b34fb" · "OBEX MAS" · "00001133-0000-1000-8000-00805f9b34fb" · "OBEX MNS" · "00001134-0000-1000-8000-00805f9b34fb" · "OBEX MAP" · "00001200-0000-1000-8000-00805f9b34fb" · "PNP" · "00001201-0000-1000-8000-00805f9b34fb" · "Generic Networking" · "00001202-0000-1000-8000-00805f9b34fb" · "Generic File Transfer" · "00001203-0000-1000-8000-00805f9b34fb" · "Generic Audio" · "00001204-0000-1000-8000-00805f9b34fb" · "Generic Telephony" · "00001205-0000-1000-8000-00805f9b34fb" · "UPNP" · "00001206-0000-1000-8000-00805f9b34fb" · "UPNP IP" · "00001300-0000-1000-8000-00805f9b34fb" · "ESDP UPnP IP PAN" · "00001301-0000-1000-8000-00805f9b34fb" · "ESDP UPnP IP LAP" · "00001302-0000-1000-8000-00805f9b34fb" · "ESDP Upnp L2CAP" · "00001303-0000-1000-8000-00805f9b34fb" · "Video Distribution Profile (VDP) - Source" · "00001304-0000-1000-8000-00805f9b34fb" · "Video Distribution Profile (VDP) - Sink" · "00001305-0000-1000-8000-00805f9b34fb" · "Video Distribution Profile (VDP)" · "00001400-0000-1000-8000-00805f9b34fb" · "Health Device Profile (HDP)" · "00001401-0000-1000-8000-00805f9b34fb" · "Health Device Profile (HDP) - Source" · "00001402-0000-1000-8000-00805f9b34fb" · "Health Device Profile (HDP) - Sink" · "00001800-0000-1000-8000-00805f9b34fb" · "GAP" · "00001801-0000-1000-8000-00805f9b34fb" · "GATT" · "00001802-0000-1000-8000-00805f9b34fb" · "IMMEDIATE_ALERT" · "00001803-0000-1000-8000-00805f9b34fb" · "LINK_LOSS" · "00001804-0000-1000-8000-00805f9b34fb" · "TX_POWER" · "00001809-0000-1000-8000-00805f9b34fb" · "Health Thermometer" · "0000180a-0000-1000-8000-00805f9b34fb" · "Device Information" · "0000180d-0000-1000-8000-00805f9b34fb" · "HEART_RATE" · "00001816-0000-1000-8000-00805f9b34fb" · "CYCLING_SC" · "00002902-0000-1000-8000-00805f9b34fb" · "CLIENT_CHARACTERISTIC_CONFIG" · "00002a00-0000-1000-8000-00805f9b34fb" · "Device Name" · "00002a01-0000-1000-8000-00805f9b34fb" · "Appearance" · "00002a02-0000-1000-8000-00805f9b34fb" · "Peripheral Privacy Flag" · "00002a03-0000-1000-8000-00805f9b34fb" · "Reconnection Address" · "00002a04-0000-1000-8000-00805f9b34fb" · "Peripheral Preferred Connection Parameters" · "00002a05-0000-1000-8000-00805f9b34fb" · "Service Changed" · "00002a06-0000-1000-8000-00805f9b34fb" · "Alert Level" · "00002a07-0000-1000-8000-00805f9b34fb" · "Tx Power Level" · "00002a08-0000-1000-8000-00805f9b34fb" · "Date Time" · "00002a09-0000-1000-8000-00805f9b34fb" · "Day of Week" · "00002a0a-0000-1000-8000-00805f9b34fb" · "Day Date Time" · "00002a0c-0000-1000-8000-00805f9b34fb" · "Exact Time 256" · "00002a0d-0000-1000-8000-00805f9b34fb" · "DST Offset" · "00002a0e-0000-1000-8000-00805f9b34fb" · "Time Zone" · "00002a0f-0000-1000-8000-00805f9b34fb" · "Local Time Information" · "00002a11-0000-1000-8000-00805f9b34fb" · "Time with DST" · "00002a12-0000-1000-8000-00805f9b34fb" · "Time Accuracy" · "00002a13-0000-1000-8000-00805f9b34fb" · "Time Source" · "00002a14-0000-1000-8000-00805f9b34fb" · "Reference Time Information" · "00002a16-0000-1000-8000-00805f9b34fb" · "Time Update Control Point" · "00002a17-0000-1000-8000-00805f9b34fb" · "Time Update State" · "00002a1c-0000-1000-8000-00805f9b34fb" · "Temperature Measurement" · "00002a1d-0000-1000-8000-00805f9b34fb" · "Temperature Type" · "00002a1e-0000-1000-8000-00805f9b34fb" · "Intermediate Temperature" · "00002a21-0000-1000-8000-00805f9b34fb" · "Measurement Interval" · "00002a23-0000-1000-8000-00805f9b34fb" · "System ID" · "00002a24-0000-1000-8000-00805f9b34fb" · "Model Number String" · "00002a25-0000-1000-8000-00805f9b34fb" · "Serial Number String" · "00002a26-0000-1000-8000-00805f9b34fb" · "Firmware Revision String" · "00002a27-0000-1000-8000-00805f9b34fb" · "Hardware Revision String" · "00002a28-0000-1000-8000-00805f9b34fb" · "Software Revision String" · "00002a29-0000-1000-8000-00805f9b34fb" · "Manufacturer Name String" · "00002a2a-0000-1000-8000-00805f9b34fb" · "IEEE 11073-20601 Regulatory" · "00002a2b-0000-1000-8000-00805f9b34fb" · "Current Time" · "00002a35-0000-1000-8000-00805f9b34fb" · "Blood Pressure Measurement" · "00002a36-0000-1000-8000-00805f9b34fb" · "Intermediate Cuff Pressure" · "00002a37-0000-1000-8000-00805f9b34fb" · "Heart Rate Measurement" · "00002a38-0000-1000-8000-00805f9b34fb" · "Body Sensor Location" · "00002a39-0000-1000-8000-00805f9b34fb" · "Heart Rate Control Point" · "00002a3f-0000-1000-8000-00805f9b34fb" · "Alert Status" · "00002a40-0000-1000-8000-00805f9b34fb" · "Ringer Control Point" · "00002a41-0000-1000-8000-00805f9b34fb" · "Ringer Setting" · "00002a42-0000-1000-8000-00805f9b34fb" · "Alert Category ID Bit Mask" · "00002a43-0000-1000-8000-00805f9b34fb" · "Alert Category ID" · "00002a44-0000-1000-8000-00805f9b34fb" · "Alert Notification Control Point" · "00002a45-0000-1000-8000-00805f9b34fb" · "Unread Alert Status" · "00002a46-0000-1000-8000-00805f9b34fb" · "New Alert" · "00002a47-0000-1000-8000-00805f9b34fb" · "Supported New Alert Category" · "00002a48-0000-1000-8000-00805f9b34fb" · "Supported Unread Alert Category" · "00002a49-0000-1000-8000-00805f9b34fb" · "Blood Pressure Feature" · "00002a50-0000-1000-8000-00805f9b34fb" · "PNPID" · "00002a55-0000-1000-8000-00805f9b34fb" · "SC_CONTROL_POINT" · "00002a5b-0000-1000-8000-00805f9b34fb" · "CSC_MEASUREMENT" · "00002a5c-0000-1000-8000-00805f9b34fb" · "CSC_FEATURE" · "00002a5d-0000-1000-8000-00805f9b34fb" · "SENSOR_LOCATION" · "831c4071-7bc8-4a9c-a01c-15df25a4adbc" · "ActiveSync" · "b9403000-f5f8-466e-aff9-25556b57fe6d" · "Estimote Service" · "b9403003-f5f8-466e-aff9-25556b57fe6d" · "Estimote UUID" · "b9403001-f5f8-466e-aff9-25556b57fe6d" · "Estimote Major" · "b9403002-f5f8-466e-aff9-25556b57fe6d" · "Estimote Minor" · "b9403041-f5f8-466e-aff9-25556b57fe6d" · "Estimote Battery" · "b9403021-f5f8-466e-aff9-25556b57fe6d" · "Estimote Temperature" · "b9403011-f5f8-466e-aff9-25556b57fe6d" · "Estimote Power" · "b9403012-f5f8-466e-aff9-25556b57fe6d" · "Estimote Advertising Interval" · "b9404000-f5f8-466e-aff9-25556b57fe6d" · "Estimote Version Service" · "b9404001-f5f8-466e-aff9-25556b57fe6d" · "Estimote Software Version" · "b9404002-f5f8-466e-aff9-25556b57fe6d" · "Estimote Hardware Version" · "b9402000-f5f8-466e-aff9-25556b57fe6d" · "Estimote Authentication Service" · "b9402001-f5f8-466e-aff9-25556b57fe6d" · "Estimote Advertising Seed" · "b9402002-f5f8-466e-aff9-25556b57fe6d" · "Estimote Advertising Vector"
### `com.gku.actioncam.sigmastar.bluetooth.utils.IntentUtils`
L11 · [class] public IntentUtils · `com/gku/actioncam/sigmastar/bluetooth/utils/IntentUtils.java`

字段/常量（1）：
- `PackageInfo packageInfo`  L36

方法（7）：
- `boolean isHavePermission(Context context, String permissionString)`  L12
- `String[] getPermissionList(Context context)`  L16
- `boolean isMIUI(Context context)`  L25
    - 体内字面量："miui.intent.action.APP_PERM_EDITOR" · "com.android.settings" · "com.miui.securitycenter.permission.AppPermissionsEditor"
- `boolean isIntentAvailable(Context context, Intent intent)`  L31
- `void startPermissionActivity(Context context)`  L35
- `void startAppSettings(Context context)`  L53
    - 体内字面量："android.settings.APPLICATION_DETAILS_SETTINGS" · "package:"
- `void startLocationSettings(Activity context, int requestCode)`  L59
    - 体内字面量："android.settings.LOCATION_SOURCE_SETTINGS"
### `com.gku.actioncam.sigmastar.bluetooth.utils.LocationUtils`
L7 · [class] public LocationUtils · `com/gku/actioncam/sigmastar/bluetooth/utils/LocationUtils.java`

方法（2）：
- `boolean isGpsProviderEnabled(Context context)`  L8
    - 体内字面量："location" · "gps"
- `boolean isNetworkProviderEnabled(Context context)`  L12
    - 体内字面量："location" · "network"
### `com.gku.actioncam.sigmastar.bluetooth.utils.PreferencesUtils`
L7 · [class] public PreferencesUtils · `com/gku/actioncam/sigmastar/bluetooth/utils/PreferencesUtils.java`

字段/常量（1）：
- `String PREFERENCE_NAME = "BlakePreference"`  L8

方法（15）：
- `void putString(Context context, String key, String value)`  L10
- `String getString(Context context, String key)`  L20
- `String getString(Context context, String key, String defaultValue)`  L24
- `void putInt(Context context, String key, int value)`  L33
- `int getInt(Context context, String key)`  L43
- `int getInt(Context context, String key, int defaultValue)`  L47
- `void putLong(Context context, String key, long value)`  L56
- `long getLong(Context context, String key)`  L66
- `long getLong(Context context, String key, long defaultValue)`  L70
- `void putFloat(Context context, String key, float value)`  L79
- `float getFloat(Context context, String key)`  L89
- `float getFloat(Context context, String key, float defaultValue)`  L93
- `void putBoolean(Context context, String key, boolean value)`  L102
- `boolean getBoolean(Context context, String key)`  L112
- `boolean getBoolean(Context context, String key, boolean defaultValue)`  L116
### `com.gku.actioncam.sigmastar.bluetooth.utils.WIFIUtils`
L20 · [class] public WIFIUtils · `com/gku/actioncam/sigmastar/bluetooth/utils/WIFIUtils.java`

字段/常量（2）：
- `boolean $assertionsDisabled = false`  L21
- `String TAG = "WIFIUtils"`  L22

方法（10）：
- `private WIFIUtils()`  L28
- `WIFIUtils getInstance()`  L38
- `void changeToWifiAfterQ(String ssid, String pass, Context context, final Callback callback)`  L42
    - 体内字面量："wifi" · "connectivity"
- `void onAvailable(Network network)`  L49 @Override
- `void onUnavailable()`  L54 @Override
- `void changeToWifiBeforeQ(String SSID, String PWD, Activity activity, Context context, final Callback callback)`  L61
- `void onConnectStart()`  L65 @Override
    - 体内字面量："onConnectStart: "
- `void onConnectSuccess()`  L70 @Override
    - 体内字面量："onConnectSuccess: "
- `void onConnectFail(String errorMsg)`  L76 @Override
    - 体内字面量："onConnectFail: "
- `String getWIFISSID(Activity activity)`  L83
    - 体内字面量："wifi" · "\"" · "connectivity" · "\"" · "unknown ssid"
### `com.gku.actioncam.sigmastar.bluetooth.utils.WIFIUtils$Callback`
L24 · [interface] public Callback · `com/gku/actioncam/sigmastar/bluetooth/utils/WIFIUtils.java`

方法（1）：
- `void onResult(boolean success)`  L25
### `com.gku.actioncam.sigmastar.bluetooth.utils.WIFIUtils$SingletonHolder`
L31 · [class] private static SingletonHolder · `com/gku/actioncam/sigmastar/bluetooth/utils/WIFIUtils.java`

方法（1）：
- `private SingletonHolder()`  L34
### `com.gku.actioncam.sigmastar.bluetooth.WaveFragment`
L13 · [class] public WaveFragment · extends `Fragment` · `com/gku/actioncam/sigmastar/bluetooth/WaveFragment.java`

字段/常量（2）：
- `DiffuseView waveView1`  L14
- `DiffuseView waveView2`  L15

方法（5）：
- `WaveFragment newInstance()`  L17
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L25 @Override
- `void onActivityCreated(Bundle savedInstanceState)`  L30 @Override
- `void run()`  L37 @Override
- `void onDestroyView()`  L44 @Override
### `com.gku.actioncam.sigmastar.bluetooth.widget.CustomPopupDialog`
L18 · [class] public CustomPopupDialog · `com/gku/actioncam/sigmastar/bluetooth/widget/CustomPopupDialog.java`

字段/常量（1）：
- `String TAG = "CustomPopupDialog"`  L19

方法（2）：
- `AlertDialog getAlertDialog(Context context, boolean cancelTouchOutSide, TopPopupListAdapter topPopupListAdapter, final TopPopupClickCallback topPopupClickCallback, DialogInterface.OnDismissListener onDismissListener)`  L21
- `void onItemClick(int position)`  L36 @Override
### `com.gku.actioncam.sigmastar.bluetooth.widget.MyAlertDialog`
L11 · [class] public MyAlertDialog · `com/gku/actioncam/sigmastar/bluetooth/widget/MyAlertDialog.java`

方法（8）：
- `AlertDialog showOpenSettingDialog(final Context context, int messageResId)`  L12
- `void onClick(DialogInterface dialog, int which)`  L15 @Override
- `void onClick(DialogInterface dialog, int which)`  L20 @Override
- `AlertDialog getDialog(final Context context, int messageResId, int postBtResId, int negaBtResId, DialogInterface.OnClickListener postListener, DialogInterface.OnClickListener negaListener)`  L26
- `AlertDialog getDialog(final Context context, int messageResId, int postBtResId, int neutralBtResId, int negaBtResId, DialogInterface.OnClickListener postListener, DialogInterface.OnClickListener neutralListener, DialogInterface.OnClickListener negaListener)`  L30
- `AlertDialog getDialog(final Context context, int messageResId, int postBtResId, DialogInterface.OnClickListener postListener)`  L34
- `AlertDialog getDialog(final Context context, int messageResId, int postBtResId, DialogInterface.OnClickListener postListener, boolean cancelable)`  L38
- `AlertDialog getViewDialog(final Context context, View view, int postBtResId, int negaBtResId, DialogInterface.OnClickListener postListener, DialogInterface.OnClickListener negaListener, boolean isCancel)`  L42
### `com.gku.actioncam.sigmastar.bluetooth.widget.TopPopupWindow`
L19 · [class] public TopPopupWindow · extends `PopupWindow` · `com/gku/actioncam/sigmastar/bluetooth/widget/TopPopupWindow.java`

字段/常量（2）：
- `String TAG = "TopPopupWindow"`  L20
- `TopPopupListAdapter adapter`  L21

方法（2）：
- `public TopPopupWindow(Context context, List<String> scanList, TopPopupListAdapter topPopupListAdapter, final TopPopupClickCallback topPopupClickCallback)`  L23
- `void onItemClick(int position)`  L32 @Override
### `com.gku.actioncam.sigmastar.bluetooth.widget.TopPopupWindow$RecyclerItemClickListener`
L45 · [class] public static RecyclerItemClickListener · implements `RecyclerView.OnItemTouchListener` · `com/gku/actioncam/sigmastar/bluetooth/widget/TopPopupWindow.java`

字段/常量（2）：
- `GestureDetector mGestureDetector`  L46
- `OnItemClickListener mListener`  L47

方法（6）：
- `void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept)`  L56 @Override
- `void onTouchEvent(RecyclerView view, MotionEvent motionEvent)`  L60 @Override
- `public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener)`  L63
- `boolean onSingleTapUp(MotionEvent e)`  L67 @Override
- `void onLongPress(MotionEvent e)`  L72 @Override
- `boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e)`  L83 @Override
### `com.gku.actioncam.sigmastar.bluetooth.widget.TopPopupWindow$RecyclerItemClickListener$OnItemClickListener`
L49 · [interface] public OnItemClickListener · `com/gku/actioncam/sigmastar/bluetooth/widget/TopPopupWindow.java`

方法（2）：
- `void onItemClick(View view, int position)`  L50
- `void onLongItemClick(View view, int position)`  L52