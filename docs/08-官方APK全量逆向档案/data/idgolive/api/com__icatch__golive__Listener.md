# idGoLive — 类与成员明细：com.icatch.golive.Listener

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 13 个文件 / 18 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.Listener.Callback`
L4 · [interface] public Callback · `com/icatch/golive/Listener/Callback.java`

方法（3）：
- `void processAbnormal()`  L5
- `void processFailed()`  L7
- `void processSucceed()`  L9
### `com.icatch.golive.Listener.EndlessRecyclerOnScrollListener`
L7 · [class] public abstract EndlessRecyclerOnScrollListener · extends `RecyclerView.OnScrollListener` · `com/icatch/golive/Listener/EndlessRecyclerOnScrollListener.java`

字段/常量（1）：
- `boolean isSlidingUpward = false`  L8

方法（3）：
- `void onLoadMore()`  L10
- `void onScrollStateChanged(RecyclerView recyclerView, int i)`  L13 @Override
- `void onScrolled(RecyclerView recyclerView, int i, int i2)`  L22 @Override
### `com.icatch.golive.Listener.MyOrientoinListener`
L10 · [class] public MyOrientoinListener · extends `OrientationEventListener` · `com/icatch/golive/Listener/MyOrientoinListener.java`

字段/常量（3）：
- `String TAG = "MyOrientoinListener"`  L11
- `Activity activity`  L12
- `Context context`  L13

方法（3）：
- `public MyOrientoinListener(Activity activity, Context context)`  L22
- `public MyOrientoinListener(Activity activity, Context context, int i)`  L28
- `void onOrientationChanged(int i)`  L35 @Override
    - 体内字面量："è®¾ç½®ç«å±" · "è®¾ç½®ååç«å±"
### `com.icatch.golive.Listener.MyOrientoinListener$ScreenOrientation`
L15 · [enum] public ScreenOrientation · `com/icatch/golive/Listener/MyOrientoinListener.java`

枚举常量（3）：
- `SCREEN_ORIENTATION_PORTRAIT()`  L16
- `SCREEN_ORIENTATION_REVERSE_PORTRAIT()`  L17
- `SCREEN_ORIENTATION_LANDSCAPE()`  L18
### `com.icatch.golive.Listener.OnAddAsytaskListener`
L4 · [interface] public OnAddAsytaskListener · `com/icatch/golive/Listener/OnAddAsytaskListener.java`

方法（1）：
- `void addAsytask(int i)`  L5
### `com.icatch.golive.Listener.OnFragmentInteractionListener`
L4 · [interface] public OnFragmentInteractionListener · `com/icatch/golive/Listener/OnFragmentInteractionListener.java`

方法（2）：
- `void removeFragment()`  L5
- `void submitFragmentInfo(String str, int i)`  L7
### `com.icatch.golive.Listener.OnProgressBarListener`
L4 · [interface] public OnProgressBarListener · `com/icatch/golive/Listener/OnProgressBarListener.java`

方法（1）：
- `void onProgressChange(int i, int i2)`  L5
### `com.icatch.golive.Listener.OnRecyclerItemClickListener`
L10 · [class] public abstract OnRecyclerItemClickListener · implements `RecyclerView.OnItemTouchListener` · `com/icatch/golive/Listener/OnRecyclerItemClickListener.java`

字段/常量（2）：
- `GestureDetectorCompat mGestureDetector`  L11
- `RecyclerView recyclerView`  L12

方法（6）：
- `public OnRecyclerItemClickListener(RecyclerView recyclerView)`  L39
- `boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)`  L45 @Override
- `void onItemClick(int i, View view, RecyclerView.ViewHolder viewHolder)`  L50
- `void onItemLongClick(int i, View view, RecyclerView.ViewHolder viewHolder)`  L52
- `void onRequestDisallowInterceptTouchEvent(boolean z)`  L55 @Override
- `void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)`  L59 @Override
### `com.icatch.golive.Listener.OnRecyclerItemClickListener$ItemTouchHelperGestureListener`
L14 · [class] private ItemTouchHelperGestureListener · extends `GestureDetector.SimpleOnGestureListener` · `com/icatch/golive/Listener/OnRecyclerItemClickListener.java`

方法（3）：
- `private ItemTouchHelperGestureListener()`  L15
- `void onLongPress(MotionEvent motionEvent)`  L19 @Override
- `boolean onSingleTapUp(MotionEvent motionEvent)`  L28 @Override
### `com.icatch.golive.Listener.OnSettingCompleteListener`
L4 · [interface] public OnSettingCompleteListener · `com/icatch/golive/Listener/OnSettingCompleteListener.java`

方法（3）：
- `void onOptionSettingComplete()`  L5
- `void settingTimeLapseModeComplete(int i)`  L7
- `void settingVideoSizeComplete()`  L9
### `com.icatch.golive.Listener.OnStatusChangedListener`
L6 · [interface] public OnStatusChangedListener · `com/icatch/golive/Listener/OnStatusChangedListener.java`

方法（2）：
- `void onChangeOperationMode(OperationMode operationMode)`  L7
- `void onSelectedItemsCountChanged(int i)`  L9
### `com.icatch.golive.Listener.ScreenListener`
L11 · [class] public ScreenListener · `com/icatch/golive/Listener/ScreenListener.java`

字段/常量（5）：
- `Context mContext`  L12
- `ScreenStateListener mScreenStateListener`  L13
- `String TAG = "ScreenListener"`  L14
- `ScreenStateListener screenStateListener = this.mScreenStateListener`  L52
- `ScreenStateListener screenStateListener2 = this.mScreenStateListener`  L59

方法（5）：
- `public ScreenListener(Context context)`  L46
- `void getScreenState()`  L50
    - 体内字面量："power"
- `void registerListener()`  L65
    - 体内字面量："ScreenListener" · "registerListener" · "android.intent.action.SCREEN_ON" · "android.intent.action.SCREEN_OFF" · "android.intent.action.USER_PRESENT"
- `void begin(ScreenStateListener screenStateListener)`  L74
- `void unregisterListener()`  L80
    - 体内字面量："ScreenListener" · "unregisterListener"
### `com.icatch.golive.Listener.ScreenListener$ScreenBroadcastReceiver`
L17 · [class] private ScreenBroadcastReceiver · extends `BroadcastReceiver` · `com/icatch/golive/Listener/ScreenListener.java`

字段/常量（1）：
- `String action`  L18

方法（2）：
- `private ScreenBroadcastReceiver()`  L20
- `void onReceive(Context context, Intent intent)`  L25 @Override
    - 体内字面量："android.intent.action.SCREEN_ON" · "android.intent.action.SCREEN_OFF" · "android.intent.action.USER_PRESENT"
### `com.icatch.golive.Listener.ScreenListener$ScreenStateListener`
L38 · [interface] public ScreenStateListener · `com/icatch/golive/Listener/ScreenListener.java`

方法（3）：
- `void onScreenOff()`  L39
- `void onScreenOn()`  L41
- `void onUserPresent()`  L43
### `com.icatch.golive.Listener.UpdateImageViewListener`
L6 · [interface] public UpdateImageViewListener · `com/icatch/golive/Listener/UpdateImageViewListener.java`

方法（1）：
- `void onBitmapLoadComplete(String str, Bitmap bitmap)`  L7
### `com.icatch.golive.Listener.VideoFramePtsChangedListener`
L4 · [interface] public VideoFramePtsChangedListener · `com/icatch/golive/Listener/VideoFramePtsChangedListener.java`

方法（1）：
- `void onFramePtsChanged(double d)`  L5
### `com.icatch.golive.Listener.WifiListener`
L16 · [class] public WifiListener · `com/icatch/golive/Listener/WifiListener.java`

字段/常量（5）：
- `String TAG = "WifiListener"`  L17
- `Context context`  L18
- `Handler handler`  L19
- `WifiReceiver wifiReceiver`  L20
- `WifiReceiver wifiReceiver = this.wifiReceiver`  L90

方法（3）：
- `public WifiListener(Context context, Handler handler)`  L71
- `void registerReceiver()`  L76
    - 体内字面量："registerReceiver" · "android.net.wifi.STATE_CHANGE" · "android.net.wifi.WIFI_STATE_CHANGED" · "android.net.wifi.supplicant.STATE_CHANGE"
- `void unregisterReceiver()`  L88
    - 体内字面量："unregisterReceiver"
### `com.icatch.golive.Listener.WifiListener$WifiReceiver`
L22 · [class] private WifiReceiver · extends `BroadcastReceiver` · `com/icatch/golive/Listener/WifiListener.java`

方法（2）：
- `private WifiReceiver()`  L23
- `void onReceive(Context context, Intent intent)`  L27 @Override
    - 体内字面量："android.net.wifi.RSSI_CHANGED" · "android.net.wifi.STATE_CHANGE" · "networkInfo" · "ç½ç»è¿æ¥æ­å¼" · "wifi" · "è¿æ¥å°ç½ç» " · "android.net.wifi.WIFI_STATE_CHANGED" · "ç³»ç»å³é­wifi" · "ç³»ç»å¼å¯wifi" · "android.net.wifi.supplicant.STATE_CHANGE" · "supplicantError" · "newState" · "WiFiå¯ç éè¯¯"