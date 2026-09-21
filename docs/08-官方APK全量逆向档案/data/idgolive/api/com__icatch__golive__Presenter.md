# idGoLive — 类与成员明细：com.icatch.golive.Presenter

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 19 个文件 / 49 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.Presenter.BTPairBeginPresenter`
L38 · [class] public BTPairBeginPresenter · `com/icatch/golive/Presenter/BTPairBeginPresenter.java`

字段/常量（32）：
- `int BLUETOOTH_SCAN_TIME_OUT = 4`  L39
- `int CONNECT_CAMERA_FAILED = 7`  L40
- `int CONNECT_WIFI_FAILED = 6`  L41
- `int GET_BLUETOOTH_CLIENT = 3`  L42
- `int GET_BLUETOOTH_CLIENT_FAILED = 9`  L43
- `int GET_BLUETOOTH_CLIENT_SUCCESS = 8`  L44
- `int GET_BLUETOOTH_DEVICE = 2`  L45
- `int REQUEST_BLUETOOTH_SCAN = 0`  L46
- `Activity activity`  L47
- `Context appContext`  L48
- `BlueToothListAdapter blueToothListAdapter`  L49
- `ICatchBluetoothAdapter bluetoothAdapter`  L50
- `List<BluetoothAppDevice> bluetoothDeviceList`  L51
- `ICatchBluetoothManager bluetoothManager`  L52
- `BluetoothLEConnectionStateReceiver connectionStateReceiver`  L53
- `ExecutorService executor`  L54
- `FragmentManager fragmentManager`  L55
- `Handler launchHandler`  L56
- `BTPairBeginFragmentView pairBeginFragmentView`  L57
- `Timer searchTimer`  L58
- `ICatchBluetoothClient tempClient`  L59
- `String TAG = "BTPairBeginPresenter"`  L60
- `int curListViewPointer = 0`  L61
- `boolean scanning = false`  L63
- `int i = message.what`  L67
- `ExecutorService executorService = BTPairBeginPresenter.this.executor`  L97
- `BTPairBeginPresenter bTPairBeginPresenter = BTPairBeginPresenter.this`  L98
- `BlueToothListAdapter blueToothListAdapter = this.blueToothListAdapter`  L277
- `BlueToothListAdapter blueToothListAdapter = this.blueToothListAdapter`  L345
- `Timer timer = this.searchTimer`  L358
- `BlueToothListAdapter blueToothListAdapter = this.blueToothListAdapter`  L383
- `int i2 = i - 1`  L397

方法（15）：
- `void handleMessage(Message message)`  L66 @Override
- `void onReceive(Intent intent)`  L168 @Override
    - 体内字面量："blue tooth bondState =" · "blue tooth mac ="
- `public BTPairBeginPresenter(Activity activity, Context context, Handler handler, FragmentManager fragmentManager)`  L250
- `void applyUIBondState(int i, String str)`  L258
    - 体内字面量："applyUIBondState BT_BOND_STATE_NONE" · "failed to bounded." · "applyUIBondState BT_BOND_STATE_BONDED" · "Bounded is ok"
- `void closeScan()`  L289
- `void getBluetoothManager()`  L296
    - 体内字面量："End getBluetoothManager() bluetoothManager=" · "End sleep()" · "End registerBroadcastReceiver()"
- `void startScan()`  L331
    - 体内字面量："startScan  isBLE="
- `void startSearchTimeoutTimer()`  L357
- `void run()`  L365 @Override
- `void updateBindedDeviceToUI()`  L371
    - 体内字面量："BT Name="
- `void connectBT(int i)`  L393
- `void loadBtList()`  L426
- `void searchBluetooth()`  L431
- `void setView(BTPairBeginFragmentView bTPairBeginFragmentView)`  L436
- `void unregister()`  L440
### `com.icatch.golive.Presenter.BTPairBeginPresenter$BluetoothLEConnectionStateReceiver`
L179 · [class] public BluetoothLEConnectionStateReceiver · implements `ICatchBroadcastReceiver` · `com/icatch/golive/Presenter/BTPairBeginPresenter.java`

字段/常量（1）：
- `Handler handler`  L180

方法（2）：
- `public BluetoothLEConnectionStateReceiver(Handler handler)`  L182
- `void onReceive(Intent intent)`  L187 @Override
### `com.icatch.golive.Presenter.BTPairBeginPresenter$BluetoothListener`
L197 · [class] private BluetoothListener · implements `ICatchBTDeviceDetectedListener` · `com/icatch/golive/Presenter/BTPairBeginPresenter.java`

方法（2）：
- `private BluetoothListener()`  L198
- `void deviceDetected(ICatchBluetoothDevice iCatchBluetoothDevice)`  L202 @Override
    - 体内字面量："get new device name ="
### `com.icatch.golive.Presenter.BTPairBeginPresenter$GetBtClientThread`
L218 · [class] GetBtClientThread · implements `Runnable` · `com/icatch/golive/Presenter/BTPairBeginPresenter.java`

字段/常量（3）：
- `Handler handler`  L219
- `String mac`  L220
- `BTPairBeginPresenter bTPairBeginPresenter = BTPairBeginPresenter.this`  L231

方法（1）：
- `void run()`  L228 @Override
    - 体内字面量："start GetBtClientThread curListViewPointer="
### `com.icatch.golive.Presenter.Interface.BasePresenter`
L14 · [class] public abstract BasePresenter · `com/icatch/golive/Presenter/Interface/BasePresenter.java`

字段/常量（2）：
- `Activity activity`  L15
- `String tag = "BasePresenter"`  L16

方法（8）：
- `public BasePresenter(Activity activity)`  L18
- `void finishActivity()`  L22
- `void initCfg()`  L26
- `void isAppBackground()`  L31
- `void redirectToAnotherActivity(Context context, Class<?> cls)`  L34
    - 体内字面量："BasePresenter" · "intent:start redirectToAnotherActivity class ="
- `void removeActivity()`  L41
- `void showOptionIcon(Menu menu)`  L47
    - 体内字面量："MenuBuilder" · "setOptionalIconsVisible" · "onMenuOpened...unable to set icons for overflow menu"
- `void submitAppInfo()`  L60
### `com.icatch.golive.Presenter.LaunchPresenter`
L72 · [class] public LaunchPresenter · extends `BasePresenter` · `com/icatch/golive/Presenter/LaunchPresenter.java`

字段/常量（40）：
- `String TAG = "LaunchPresenter"`  L73
- `Activity activity`  L74
- `ArrayList<CameraSlot> camSlotList`  L75
- `CameraSlotAdapter cameraSlotAdapter`  L76
- `int cameraSlotPosition`  L77
- `GlobalEvent globalEvent`  L78
- `LaunchHandler launchHandler`  L79
- `LaunchView launchView`  L80
- `USBMonitor.OnDeviceConnectListener mOnDeviceConnectListener`  L81
- `USBMonitor mUSBMonitor`  L82
- `LinkedList<SelectedCameraInfo> searchCameraInfoList`  L83
- `WifiListener wifiListener`  L84
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L212
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L227
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L235
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L257
- `String str4 = TAG`  L289
- `String str = TAG`  L320
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L363
- `String str = AppInfo.inputIp`  L371
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L393
- `CharSequence[] charSequenceArr = new CharSequence[size]`  L494
- `String str2`  L523
- `UsbDevice usbDevice`  L524
- `String deviceName`  L525
- `String str3 = TAG`  L526
- `UsbDevice usbDevice2 = null`  L534
- `Activity activity = this.activity`  L548
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L559
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L580
- `Activity activity2 = this.activity`  L588
- `String str = TAG`  L641
- `String str2 = ssid`  L653
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L663
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L689
- `CameraSlotAdapter cameraSlotAdapter = this.cameraSlotAdapter`  L719
- `CameraSlotAdapter cameraSlotAdapter = this.cameraSlotAdapter`  L761
- `LinkedList<SelectedCameraInfo> linkedList = this.searchCameraInfoList`  L915
- `USBMonitor uSBMonitor = this.mUSBMonitor`  L928
- `WifiListener wifiListener = this.wifiListener`  L936

方法（76）：
- `public LaunchPresenter(Activity activity)`  L204
- `void onAttach(UsbDevice usbDevice)`  L209 @Override
    - 体内字面量："USBMonitor onAttach:"
- `void onCancel()`  L218 @Override
    - 体内字面量："USBMonitor onCancel:"
- `void onConnect(UsbDevice usbDevice, USBMonitor.UsbControlBlock usbControlBlock, boolean z)`  L225 @Override
    - 体内字面量："USBMonitor onConnect getDeviceName:"
- `void onDettach(UsbDevice usbDevice)`  L232 @Override
    - 体内字面量："USB_DEVICE_DETACHED:"
- `void onDisconnect(UsbDevice usbDevice, USBMonitor.UsbControlBlock usbControlBlock)`  L241 @Override
    - 体内字面量："USBMonitor onDisconnect:"
- `void autoConnectDeviceWifi(final int i, final String str, final String str2, final String str3)`  L249
- `void onError(int i2)`  L253 @Override
- `void onSuccess(String str4)`  L263 @Override
- `void autoConnectWifi(final int i, final String str)`  L270
    - 体内字面量："[一-龥a-zA-z0-9@_-]+.*"
- `void onError(int i2)`  L273 @Override
- `void onSuccess(String str2)`  L281 @Override
- `void beginConnectCamera(int i, String str, String str2, int i2, String str3)`  L288
- `void run()`  L312 @Override
- `void beginConnectUSBCamera(final int i, final UsbDevice usbDevice)`  L319
- `void run()`  L325 @Override
    - 体内字面量："appLocalInfo" · "camera_position"
- `void onSure()`  L333 @Override
    - 体内字面量："beginConnectUSBCamera camera is connected."
- `void run()`  L361 @Override
- `String getCameraIp()`  L370
- `String getDeviceName(UsbDevice usbDevice)`  L377
    - 体内字面量："UsbDevice_" · "UsbDevice"
- `void gotoLiveVideo()`  L382
- `void handleMessage(Message message)`  L385 @Override
- `boolean isRegistered(String str)`  L399
- `void lambda$beginConnectCamera$0()`  L408
- `void normalConnectDeviceWifi(final int i, final String str, final String str2, final int i2, final String str3)`  L414
- `void onError(int i3)`  L420 @Override
    - 体内字面量："bindToNetwork Error"
- `void onSuccess(String str4)`  L426 @Override
    - 体内字面量："bindToNetwork Success"
- `void resetWifiState()`  L435
- `void setReadyState(boolean z, String str)`  L444
- `void showConfigDevicePwdDialog(Context context, final int i, final String str, final String str2, final int i2)`  L457
- `void onClick(DialogInterface dialogInterface, int i3)`  L467 @Override
- `void onClick(DialogInterface dialogInterface, int i3)`  L476 @Override
- `void showOptionDialogSingle(CharSequence charSequence, CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener, boolean z)`  L482
- `void showSearchCameraListSingleDialog()`  L489
- `void onClick(DialogInterface dialogInterface, int i2)`  L500 @Override
- `void startSearchTimeoutTimer()`  L506
- `void run()`  L509 @Override
- `void addGlobalLisnter(int i, boolean z)`  L515
- `void addNewCamera(final int i, final int i2, final int i3, final String str)`  L522
- `void run()`  L557 @Override
- `void run()`  L578 @Override
- `void configDevicePwd()`  L596
- `void delGlobalLisnter(int i, boolean z)`  L600
- `UsbDevice getUsbDevice()`  L604
    - 体内字面量："getUsbDevice mUSBMonitor:"
- `void initCfg()`  L617 @Override
    - 体内字面量："192.168.1.1" · "1234567890"
- `void initUsbMonitor()`  L626
- `void inputIp()`  L630
- `void m491x188c71f2()`  L635
- `void launchCamera(final int i, FragmentManager fragmentManager)`  L640
- `void run()`  L661 @Override
- `void run()`  L672 @Override
- `void run()`  L688 @Override
- `void onClick(DialogInterface dialogInterface, int i4)`  L701 @Override
    - 体内字面量："android.net.wifi.PICK_WIFI_NETWORK"
- `void loadListview()`  L717
- `void loadLocalThumbnails02()`  L731
    - 体内字面量："/DCIM/idGoLive/photo/" · "/DCIM/idGoLive/photo/"
- `void notifyListview()`  L760
- `void reconnectUSBCamera()`  L767
    - 体内字面量："appLocalInfo" · "camera_position"
- `void redirectToAnotherActivity(Context context)`  L771
    - 体内字面量："intent:start PbMainActivity.class" · "isSDCardExist IchSocketException"
- `void registerUSB()`  L796
- `void registerWifiReceiver()`  L803
- `void removeCamera(final int i)`  L810
    - 体内字面量："remove camera position = "
- `void onClick(DialogInterface dialogInterface, int i2)`  L817 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L824 @Override
- `void setView(LaunchView launchView)`  L833
- `void showConfigDevicePwdDialog(final Context context)`  L839
- `void onClick(DialogInterface dialogInterface, int i)`  L849 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L856 @Override
- `void showHelpDialogWarn(final Context context, int i)`  L862
    - 体内字面量："showHelpDialogWarn"
- `void onClick(DialogInterface dialogInterface, int i2)`  L869 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L876 @Override
    - 体内字面量："android.net.wifi.PICK_WIFI_NETWORK"
- `void showInputIpDialog(final Context context)`  L891
- `void onClick(DialogInterface dialogInterface, int i)`  L901 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L908 @Override
- `void startSearchCamera()`  L914
- `void unregisterUSB()`  L927
- `void unregisterWifiReceiver()`  L935
### `com.icatch.golive.Presenter.LaunchPresenter$AnonymousClass18`
L87 · [class] AnonymousClass18 · extends `Handler` · `com/icatch/golive/Presenter/LaunchPresenter.java`

字段/常量（4）：
- `int val$addType`  L88
- `int val$position`  L89
- `String val$wifiPassword`  L90
- `String val$wifiSsid`  L91

方法（3）：
- `void handleMessage(Message message)`  L103 @Override
    - 体内字面量："old_camera"
- `void run()`  L112 @Override
- `void m492x32f6d9fb()`  L119
### `com.icatch.golive.Presenter.LaunchPresenter$LaunchHandler`
L124 · [class] private LaunchHandler · extends `Handler` · `com/icatch/golive/Presenter/LaunchPresenter.java`

字段/常量（7）：
- `int i = message.what`  L130
- `LaunchPresenter launchPresenter = LaunchPresenter.this`  L150
- `LaunchPresenter launchPresenter2 = LaunchPresenter.this`  L156
- `int i2 = message.arg1`  L162
- `int i3 = message.arg2`  L163
- `int i4 = CameraAddType.USB_CONNECTION`  L164
- `String str = "<binary/metadata>"`  L165

方法（2）：
- `private LaunchHandler()`  L125
- `void handleMessage(Message message)`  L129 @Override
### `com.icatch.golive.Presenter.LocalDeviceFilesFragmentPresenter`
L31 · [class] public LocalDeviceFilesFragmentPresenter · extends `BasePresenter` · `com/icatch/golive/Presenter/LocalDeviceFilesFragmentPresenter.java`

字段/常量（10）：
- `String TAG`  L32
- `Activity activity`  L33
- `int fileType`  L34
- `Handler handler`  L35
- `LocalMultiPbFragmentView multiPbPhotoView`  L36
- `List<FileItemInfo> pbItemInfoList`  L37
- `int i = this.fileType`  L117
- `int i2 = 1`  L131
- `int i3 = 0`  L137
- `LocalDeviceFilesFragmentPresenter localDeviceFilesFragmentPresenter = LocalDeviceFilesFragmentPresenter.this`  L181

方法（12）：
- `public LocalDeviceFilesFragmentPresenter(Activity activity, int i)`  L93
    - 体内字面量："LocalDeviceFilesFragmentPresenter"
- `void delete(final List<FileItemInfo> list, final FileListView.DeleteResponse deleteResponse)`  L101
    - 体内字面量："asytaskList size=" · "$1$"
- `void onClick(DialogInterface dialogInterface, int i)`  L113 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L120 @Override
- `List<FileItemInfo> getPhotoInfoList(int i)`  L128
- `void itemClick(FileItemInfo fileItemInfo, int i)`  L155
    - 体内字面量："listViewSelectOrCancelOnce positon=" · " AppInfo.photoWallPreviewType=" · "listViewSelectOrCancelOnce curOperationMode=" · "curfilePosition" · "VideoPlayURL" · "VideoPlayTitle"
- `void loadPhotoWall()`  L176
    - 体内字面量："Loading..."
- `void run()`  L180 @Override
- `void run()`  L186 @Override
- `void run()`  L195 @Override
- `void refreshPhotoWall()`  L206
    - 体内字面量："refreshPhotoWall layoutType="
- `void setView(LocalMultiPbFragmentView localMultiPbFragmentView)`  L218
### `com.icatch.golive.Presenter.LocalDeviceFilesFragmentPresenter$DeleteFileThread`
L39 · [class] DeleteFileThread · implements `Runnable` · `com/icatch/golive/Presenter/LocalDeviceFilesFragmentPresenter.java`

字段/常量（7）：
- `List<FileItemInfo> deleteFailedList`  L40
- `List<FileItemInfo> deleteSucceedList`  L41
- `List<FileItemInfo> fileList`  L42
- `int fileType`  L43
- `FileListView.DeleteResponse response`  L45
- `List<FileItemInfo> list = this.deleteFailedList`  L57
- `List<FileItemInfo> list2 = this.deleteSucceedList`  L63

方法（3）：
- `public DeleteFileThread(List<FileItemInfo> list, int i, FileListView.DeleteResponse deleteResponse)`  L47
- `void run()`  L55 @Override
    - 体内字面量："DeleteThread"
- `void run()`  L78 @Override
### `com.icatch.golive.Presenter.LocalMultiPbFragmentPresenter`
L30 · [class] public LocalMultiPbFragmentPresenter · extends `BasePresenter` · `com/icatch/golive/Presenter/LocalMultiPbFragmentPresenter.java`

字段/常量（10）：
- `String TAG`  L31
- `Activity activity`  L32
- `int fileType`  L33
- `Handler handler`  L34
- `LocalMultiPbFragmentView multiPbPhotoView`  L35
- `List<FileItemInfo> pbItemInfoList`  L36
- `int i = this.fileType`  L116
- `int i2 = 1`  L130
- `int i3 = 0`  L136
- `LocalMultiPbFragmentPresenter localMultiPbFragmentPresenter = LocalMultiPbFragmentPresenter.this`  L181

方法（12）：
- `public LocalMultiPbFragmentPresenter(Activity activity, int i)`  L92
    - 体内字面量："LocalMultiPbFragmentPresenter"
- `void delete(final List<FileItemInfo> list, final FileListView.DeleteResponse deleteResponse)`  L100
    - 体内字面量："asytaskList size=" · "$1$"
- `void onClick(DialogInterface dialogInterface, int i)`  L112 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L119 @Override
- `List<FileItemInfo> getPhotoInfoList(int i)`  L127
- `void itemClick(FileItemInfo fileItemInfo, int i)`  L154
    - 体内字面量："listViewSelectOrCancelOnce positon=" · " AppInfo.photoWallPreviewType=" · "listViewSelectOrCancelOnce curOperationMode=" · "curfilePosition" · "curfilePath" · "curfilePosition" · "remote"
- `void loadPhotoWall()`  L176
    - 体内字面量："Loading..."
- `void run()`  L180 @Override
- `void run()`  L186 @Override
- `void run()`  L195 @Override
- `void refreshPhotoWall()`  L206
    - 体内字面量："refreshPhotoWall layoutType="
- `void setView(LocalMultiPbFragmentView localMultiPbFragmentView)`  L218
### `com.icatch.golive.Presenter.LocalMultiPbFragmentPresenter$DeleteFileThread`
L38 · [class] DeleteFileThread · implements `Runnable` · `com/icatch/golive/Presenter/LocalMultiPbFragmentPresenter.java`

字段/常量（7）：
- `List<FileItemInfo> deleteFailedList`  L39
- `List<FileItemInfo> deleteSucceedList`  L40
- `List<FileItemInfo> fileList`  L41
- `int fileType`  L42
- `FileListView.DeleteResponse response`  L44
- `List<FileItemInfo> list = this.deleteFailedList`  L56
- `List<FileItemInfo> list2 = this.deleteSucceedList`  L62

方法（3）：
- `public DeleteFileThread(List<FileItemInfo> list, int i, FileListView.DeleteResponse deleteResponse)`  L46
- `void run()`  L54 @Override
    - 体内字面量："DeleteThread"
- `void run()`  L77 @Override
### `com.icatch.golive.Presenter.LocalMultiPbPresenter`
L16 · [class] public LocalMultiPbPresenter · extends `BasePresenter` · `com/icatch/golive/Presenter/LocalMultiPbPresenter.java`

字段/常量（8）：
- `String TAG = "LocalMultiPbPresenter"`  L17
- `Activity activity`  L18
- `ViewPagerAdapter adapter`  L19
- `OperationMode curOperationMode`  L20
- `LocalDeviceFilesFragment multiPbPhotoFragment`  L21
- `LocalDeviceFilesFragment multiPbVideoFragment`  L22
- `LocalMultiPbView multiPbView`  L23
- `int photoWallLayoutType`  L24

方法（17）：
- `public LocalMultiPbPresenter(Activity activity)`  L26
    - 体内字面量："CUR_POSITION"
- `void initViewpager()`  L34
- `void onChangeOperationMode(OperationMode operationMode)`  L40 @Override
    - 体内字面量："multiPbPhotoFragment quit EditMode"
- `void onSelectedItemsCountChanged(int i)`  L53 @Override
- `void onChangeOperationMode(OperationMode operationMode)`  L61 @Override
    - 体内字面量："multiPbVideoFragment quit EditMode"
- `void onSelectedItemsCountChanged(int i)`  L74 @Override
- `void changePreviewType()`  L87
    - 体内字面量：" changePreviewType AppInfo.photoWallPreviewType"
- `void clearDownloadState()`  L102
- `boolean clickSelectState()`  L106
- `LocalDeviceFilesFragment getCurrentFragment()`  L121
- `void loadViewPager()`  L125
- `boolean onSelectAllOrNone()`  L129
- `void reback()`  L133
- `void reset()`  L148
- `boolean setDownloadState()`  L154
- `void setView(LocalMultiPbView localMultiPbView)`  L158
- `void updateViewpagerStatus(int i)`  L163
    - 体内字面量："updateViewpagerStatus arg0="
### `com.icatch.golive.Presenter.LocalPhotoPbPresenter`
L47 · [class] public LocalPhotoPbPresenter · extends `BasePresenter implements SensorEventListener` · implements `SensorEventListener` · `com/icatch/golive/Presenter/LocalPhotoPbPresenter.java`

字段/常量（53）：
- `int DIRECTION_LEFT = 2`  L48
- `int DIRECTION_RIGHT = 1`  L49
- `int DIRECTION_UNKNOWN = 4`  L50
- `float FIXED_INSIDE_DISTANCE = 0.45454544f`  L51
- `float FIXED_INSIDE_FOCUS = 2.0f`  L52
- `float FIXED_NEAR_DISTANCE = 0.6f`  L53
- `float FIXED_OUTSIDE_DISTANCE = 2.0f`  L54
- `float FIXED_OUTSIDE_FOCUS = 1.0f`  L55
- `float MAX_ZOOM = 2.2f`  L56
- `float MIN_ZOOM = 0.5f`  L57
- `String TAG`  L58
- `Activity activity`  L59
- `float afterLenght`  L60
- `float beforeLenght`  L61
- `int curPanoramaType`  L62
- `int curPhotoIdx`  L63
- `float currentZoomRate`  L64
- `ExecutorService executor`  L65
- `List<FileItemInfo> fileList`  L66
- `Sensor gyroscopeSensor`  L67
- `Handler handler`  L68
- `ICatchSurfaceContext iCatchSurfaceContext`  L69
- `boolean isScrolling`  L70
- `int lastItem`  L71
- `float mPreviousX`  L72
- `float mPreviousY`  L73
- `PanoramaPhotoPlayback panoramaPhotoPlayback`  L74
- `int photoNums`  L75
- `LocalPhotoPbView photoPbView`  L76
- `SensorManager sensorManager`  L77
- `int slideDirection`  L78
- `boolean surfaceCreated`  L79
- `int tempLastItem`  L80
- `TouchMode touchMode`  L81
- `LocalPhotoPbViewPagerAdapter viewPagerAdapter`  L82
- `int i = localPhotoPbPresenter.curPhotoIdx`  L178
- `PanoramaPhotoPlayback panoramaPhotoPlayback = this.panoramaPhotoPlayback`  L269
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L271
- `PanoramaPhotoPlayback panoramaPhotoPlayback = this.panoramaPhotoPlayback`  L285
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L288
- `int i = this.curPhotoIdx`  L348
- `List<FileItemInfo> list = this.fileList`  L361
- `float f = sensorEvent.values[0]`  L365
- `float f2 = sensorEvent.values[1]`  L366
- `float f3 = sensorEvent.values[2]`  L367
- `SensorManager sensorManager = this.sensorManager`  L421
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L433
- `int i = this.curPanoramaType`  L449
- `float f2 = this.currentZoomRate`  L470
- `float f3 = f2 * f`  L473
- `float f4 = f2 * f`  L480
- `float f5 = f2 * f`  L491
- `Activity activity = this.activity`  L529

方法（45）：
- `public LocalPhotoPbPresenter(Activity activity)`  L160
    - 体内字面量："LocalPhotoPbPresenter"
- `int access$510(LocalPhotoPbPresenter localPhotoPbPresenter)`  L177
- `void destroySession()`  L183
- `void initClient()`  L187
- `void loadPanoramaPhoto(FileItemInfo fileItemInfo)`  L192
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L196 @Override
    - 体内字面量："onLoadingComplete imageUri:"
- `void onLoadingFailed(String str, View view)`  L208 @Override
    - 体内字面量："onLoadingFailed imageUri:"
- `void onLoadingStarted(String str, View view)`  L213 @Override
    - 体内字面量："onLoadingStarted imageUri:"
- `void locate(float f)`  L220
- `void rotate(float f, float f2, float f3, long j)`  L224
- `void showDeleteEnsureDialog()`  L228
- `void onClick(DialogInterface dialogInterface, int i)`  L234 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L242 @Override
- `void updateUi()`  L250
- `void zoom(float f)`  L262
- `void clearImage(int i)`  L266
- `void delete()`  L280
- `void destroyImage(int i)`  L284
- `void finish()`  L297
- `float getDistance(MotionEvent motionEvent)`  L302
- `void info()`  L308
- `void initPanorama()`  L311
- `void initView()`  L315
- `void onPhotoTap()`  L320 @Override
- `void insidePanorama()`  L330
- `void loadNextImage()`  L334
    - 体内字面量："loadNextImage="
- `void loadPanoramaImage()`  L342
- `void loadPreviousImage()`  L346
    - 体内字面量："loadPreviousImage="
- `void onAccuracyChanged(Sensor sensor, int i)`  L356 @Override
- `void onSensorChanged(SensorEvent sensorEvent)`  L360 @Override
- `void onSufaceViewPointerDown(MotionEvent motionEvent)`  L373
    - 体内字面量："2222" · "event.getPointerCount()................="
- `void onSufaceViewTouchDown(MotionEvent motionEvent)`  L381
- `void onSufaceViewTouchMove(MotionEvent motionEvent)`  L389
- `void onSufaceViewTouchPointerUp()`  L404
- `void onSufaceViewTouchUp()`  L408
- `void registerGyroscopeSensor()`  L412
    - 体内字面量："sensor"
- `void removeGyroscopeListener()`  L420
- `void rotateB(MotionEvent motionEvent, float f, float f2)`  L427
- `void setDrawingArea(int i, int i2)`  L431
    - 体内字面量："start setDrawingArea windowW= " · " windowH= "
- `void setPanoramaType()`  L444
- `void setScale(float f)`  L469
- `void setShowArea(Surface surface)`  L500
    - 体内字面量："start initSurface" · "end initSurface"
- `void setView(LocalPhotoPbView localPhotoPbView)`  L509
    - 体内字面量："curfilePosition" · "photo position ="
- `void share(Context context)`  L518
    - 体内字面量："share curPosition=" · " photoPath=" · " packagename:" · ".provider" · "android.intent.action.SEND" · "android.intent.extra.STREAM" · "image/*"
- `void showBar()`  L533
    - 体内字面量："showBar isShowBar="
### `com.icatch.golive.Presenter.LocalPhotoPbPresenter$DeleteThread`
L84 · [class] private DeleteThread · implements `Runnable` · `com/icatch/golive/Presenter/LocalPhotoPbPresenter.java`

字段/常量（1）：
- `LocalPhotoPbPresenter localPhotoPbPresenter = LocalPhotoPbPresenter.this`  L90

方法（3）：
- `private DeleteThread()`  L85
- `void run()`  L89 @Override
- `void run()`  L99 @Override
    - 体内字面量："photoNums=" · " curPhotoIdx=" · "end DeleteThread"
### `com.icatch.golive.Presenter.LocalPhotoPbPresenter$MyViewPagerOnPagerChangeListener`
L121 · [class] private MyViewPagerOnPagerChangeListener · implements `ViewPager.OnPageChangeListener` · `com/icatch/golive/Presenter/LocalPhotoPbPresenter.java`

字段/常量（4）：
- `LocalPhotoPbPresenter localPhotoPbPresenter = LocalPhotoPbPresenter.this`  L129
- `LocalPhotoPbPresenter localPhotoPbPresenter2 = LocalPhotoPbPresenter.this`  L136
- `LocalPhotoPbPresenter localPhotoPbPresenter3 = LocalPhotoPbPresenter.this`  L139
- `int unused = LocalPhotoPbPresenter.this.lastItem`  L148

方法（4）：
- `private MyViewPagerOnPagerChangeListener()`  L122
- `void onPageScrollStateChanged(int i)`  L126 @Override
- `void onPageScrolled(int i, float f, int i2)`  L146 @Override
- `void onPageSelected(int i)`  L154 @Override
    - 体内字面量："onPageSelected arg0:"
### `com.icatch.golive.Presenter.LocalVideoPbPresenter`
L36 · [class] public LocalVideoPbPresenter · extends `BasePresenter implements SensorEventListener` · implements `SensorEventListener` · `com/icatch/golive/Presenter/LocalVideoPbPresenter.java`

字段/常量（42）：
- `float FIXED_INSIDE_DISTANCE = 0.45454544f`  L37
- `float FIXED_OUTSIDE_DISTANCE = 2.0f`  L38
- `float MAX_ZOOM = 2.2f`  L39
- `float MIN_ZOOM = 0.5f`  L40
- `String TAG`  L41
- `Activity activity`  L42
- `float afterLenght`  L43
- `float beforeLenght`  L44
- `boolean cacheFlag`  L45
- `long codeInfoLastShowTime`  L46
- `Toast codeInfoToast`  L47
- `String curLocalVideoPath`  L48
- `int curPanoramaType`  L49
- `double currentTime`  L50
- `float currentZoomRate`  L51
- `boolean enableRender`  L52
- `Sensor gyroscopeSensor`  L53
- `VideoPbHandler handler`  L54
- `int lastSeekBarPosition`  L55
- `LocalVideoPbView localVideoPbView`  L56
- `float mPreviousX`  L57
- `float mPreviousY`  L58
- `boolean needUpdateSeekBar`  L59
- `PanoramaControl panoramaControl`  L60
- `PanoramaVideoPlayback panoramaVideoPlayback`  L61
- `SDKEvent sdkEvent`  L62
- `SensorManager sensorManager`  L63
- `TouchMode touchMode`  L64
- `int videoDuration`  L65
- `VideoPbMode videoPbMode`  L66
- `VideoStreaming videoStreaming`  L67
- `Boolean waitForCaching`  L68
- `float f = sensorEvent.values[0]`  L312
- `float f2 = sensorEvent.values[1]`  L313
- `float f3 = sensorEvent.values[2]`  L314
- `String str = this.curLocalVideoPath`  L414
- `SensorManager sensorManager = this.sensorManager`  L470
- `int i = this.curPanoramaType`  L488
- `float f2 = this.currentZoomRate`  L510
- `float f3 = f2 * f`  L513
- `float f4 = f2 * f`  L520
- `float f5 = f2 * f`  L531

方法（41）：
- `public LocalVideoPbPresenter(Activity activity, String str)`  L146
    - 体内字面量："LocalVideoPbPresenter"
- `void initClient()`  L166
- `void initView()`  L173
- `void registerGyroscopeSensor()`  L182
    - 体内字面量："sensor"
- `void rotate(float f, float f2, float f3, long j)`  L190
- `void zoom(float f)`  L194
- `void addEventListener()`  L198
- `void back()`  L213
    - 体内字面量：" 12233 back"
- `void completedSeekToPosition()`  L221
- `void destroySession()`  L238
- `void destroyVideo()`  L242
- `void enableEIS(boolean z)`  L252
- `float getDistance(MotionEvent motionEvent)`  L264
- `void initSurface(SurfaceHolder surfaceHolder)`  L270
    - 体内字面量："begin initSurface" · "SurfaceViewWidth=" · " SurfaceViewHeight=" · "end initSurface"
- `void initZoomView()`  L287
- `void insidePanorama()`  L294
- `void locate(float f)`  L298
- `void onAccuracyChanged(Sensor sensor, int i)`  L306 @Override
- `void onSensorChanged(SensorEvent sensorEvent)`  L310 @Override
- `void onSufaceViewPointerDown(MotionEvent motionEvent)`  L321
- `void onSufaceViewTouchDown(MotionEvent motionEvent)`  L328
- `void onSufaceViewTouchMove(MotionEvent motionEvent)`  L339
- `void onSufaceViewTouchPointerUp()`  L357
- `void onSufaceViewTouchUp()`  L364
- `void play()`  L371
    - 体内字面量："start play video videoPbMode=" · "mode == MODE_VIDEO_PAUSE" · "failed to resumePlayback" · "begin pause the playing" · "failed to pausePlayback" · "start play video"
- `void onFramePtsChanged(double d)`  L408 @Override
    - 体内字面量："start play video curLocalVideoPath="
- `void redrawSurface()`  L447
- `void release()`  L452
- `void removeEventListener()`  L457
- `void removeGyroscopeListener()`  L469
- `void rotateB(MotionEvent motionEvent, float f, float f2)`  L477
- `void setDrawingArea(int i, int i2)`  L483
- `void setPanoramaType()`  L487
- `void setScale(float f)`  L509
- `void setTimeLapsedValue(int i)`  L540
- `void setView(LocalVideoPbView localVideoPbView)`  L544
- `void showBar(boolean z)`  L551
- `void showMoreSettingLayout(boolean z)`  L561
- `void startSeekTouch()`  L573
- `void stopVideoStream()`  L577
    - 体内字面量："00:00"
- `void updatePbSeekbar(double d)`  L595
### `com.icatch.golive.Presenter.LocalVideoPbPresenter$VideoPbHandler`
L70 · [class] private VideoPbHandler · extends `Handler` · `com/icatch/golive/Presenter/LocalVideoPbPresenter.java`

字段/常量（2）：
- `int i = message.what`  L76
- `LocalVideoPbPresenter localVideoPbPresenter = LocalVideoPbPresenter.this`  L135

方法（2）：
- `private VideoPbHandler()`  L71
- `void handleMessage(Message message)`  L75 @Override
### `com.icatch.golive.Presenter.MultiPbFragmentPresenter`
L36 · [class] public MultiPbFragmentPresenter · extends `BasePresenter` · `com/icatch/golive/Presenter/MultiPbFragmentPresenter.java`

字段/常量（30）：
- `String TAG`  L37
- `Activity activity`  L38
- `int curIndex`  L39
- `PhotoWallLayoutType curLayoutType`  L40
- `OperationMode curOperationMode`  L41
- `FileOperation fileOperation`  L42
- `int fileTotalNum`  L43
- `FileType fileType`  L44
- `Fragment fragment`  L45
- `Handler handler`  L46
- `boolean isMore`  L47
- `int maxNum`  L48
- `MultiPbFragmentView multiPbPhotoView`  L49
- `boolean needGetFileNumRemote`  L50
- `List<MultiPbItemInfo> pbItemInfoList`  L51
- `MultiPbRecyclerViewAdapter recyclerViewAdapter`  L52
- `boolean supportSegmentedLoading`  L53
- `FileType fileType = this.fileType`  L142
- `OperationMode operationMode = OperationMode.MODE_EDIT`  L160
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter = this.recyclerViewAdapter`  L221
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter2 = this.recyclerViewAdapter`  L229
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter3 = MultiPbFragmentPresenter.this.recyclerViewAdapter`  L245
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter3 = this.recyclerViewAdapter`  L253
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L343
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L352
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter = this.recyclerViewAdapter`  L356
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L368
- `int selectedCount`  L387
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L403
- `MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter = this.recyclerViewAdapter`  L407

方法（31）：
- `public MultiPbFragmentPresenter(Activity activity, FileType fileType)`  L103
    - 体内字面量："MultiPbFragmentPresenter"
- `void changePreviewType(PhotoWallLayoutType photoWallLayoutType)`  L120
- `void deleteFile()`  L125
    - 体内字面量："asytaskList size=" · "$1$"
- `void onClick(DialogInterface dialogInterface, int i)`  L138 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L145 @Override
- `void emptyFileList()`  L154
- `void enterEditMode(int i)`  L158
- `List<MultiPbItemInfo> getRemotePhotoInfoList()`  L170
- `List<MultiPbItemInfo> getSelectedList()`  L181
- `void itemClick(final int i)`  L185
    - 体内字面量："listViewSelectOrCancelOnce positon=" · "listViewSelectOrCancelOnce curOperationMode=" · "curfilePosition" · "fileType"
- `void run()`  L204 @Override
    - 体内字面量："curfilePosition" · "fileType"
- `void loadMoreFile()`  L220
- `void run()`  L236 @Override
- `void run()`  L244 @Override
- `void loadPhotoWall()`  L260
- `void run()`  L264 @Override
    - 体内字面量："pbItemInfoList="
- `void run()`  L283 @Override
- `void run()`  L293 @Override
    - 体内字面量："pbItemInfoList="
- `void run()`  L320 @Override
- `void run()`  L329 @Override
- `void quitEditMode()`  L341
- `void refreshAdaper()`  L350
- `void refreshPhotoWall()`  L366
    - 体内字面量："1122" · "refreshPhotoWall"
- `void resetAdpter()`  L378
- `void resetCurIndex()`  L382
- `void selectOrCancelAll(boolean z)`  L386
- `void setAdaper()`  L401
- `void setFragment(Fragment fragment)`  L417
- `void setLayoutType(PhotoWallLayoutType photoWallLayoutType)`  L421
- `void setView(MultiPbFragmentView multiPbFragmentView)`  L438
- `void stopLoad()`  L443
### `com.icatch.golive.Presenter.MultiPbFragmentPresenter$DeleteFileThread`
L55 · [class] private DeleteFileThread · implements `Runnable` · `com/icatch/golive/Presenter/MultiPbFragmentPresenter.java`

字段/常量（3）：
- `List<MultiPbItemInfo> deleteSucceedList`  L56
- `List<MultiPbItemInfo> fileList`  L57
- `FileType fileType`  L58

方法（3）：
- `public DeleteFileThread(List<MultiPbItemInfo> list, FileType fileType)`  L62
- `void run()`  L68 @Override
    - 体内字面量："DeleteThread" · "deleteFile f.getFileHandle ="
- `void run()`  L79 @Override
### `com.icatch.golive.Presenter.MultiPbFragmentPresenter$OnGetListCompleteListener`
L99 · [interface] public OnGetListCompleteListener · `com/icatch/golive/Presenter/MultiPbFragmentPresenter.java`

方法（1）：
- `void onGetFileListComplete()`  L100
### `com.icatch.golive.Presenter.MultiPbFragmentPresenter2`
L38 · [class] public MultiPbFragmentPresenter2 · extends `BasePresenter` · `com/icatch/golive/Presenter/MultiPbFragmentPresenter2.java`

字段/常量（21）：
- `String TAG`  L39
- `Activity activity`  L40
- `int curIndex`  L41
- `FileOperation fileOperation`  L42
- `int fileTotalNum`  L43
- `int fileType`  L44
- `Fragment fragment`  L45
- `Handler handler`  L46
- `boolean isMore`  L47
- `int maxNum`  L48
- `MultiPbFragmentView2 multiPbPhotoView`  L49
- `List<MultiPbItemInfo> pbItemInfoList`  L50
- `boolean supportSegmentedLoading`  L51
- `List<MultiPbItemInfo> list2 = list`  L133
- `int i = 0`  L138
- `LinkedList linkedList2 = linkedList`  L141
- `MultiPbItemInfo next`  L152
- `FileListView.DeleteResponse deleteResponse2 = deleteResponse`  L180
- `int i = this.fileType`  L186
- `long fileSize = 0`  L206
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L362

方法（24）：
- `public MultiPbFragmentPresenter2(Activity activity, int i)`  L105
    - 体内字面量："MultiPbFragmentPresenter2"
- `LinkedList<ICatchFile> convertFileList(List<FileItemInfo> list)`  L119
- `List<FileItemInfo> convertList(List<MultiPbItemInfo> list)`  L132
- `void removeLocal(FileItemInfo fileItemInfo)`  L151
- `void deleteFile(final List<FileItemInfo> list, final FileListView.DeleteResponse deleteResponse)`  L166
    - 体内字面量："asytaskList size=" · "$1$"
- `void onClick(DialogInterface dialogInterface, int i)`  L178 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L189 @Override
- `void download(List<FileItemInfo> list)`  L198
    - 体内字面量："asytaskList size="
- `void emptyFileList()`  L218
- `List<MultiPbItemInfo> getRemotePhotoInfoList()`  L222
- `void itemClick(FileItemInfo fileItemInfo, final int i)`  L233
    - 体内字面量："listViewSelectOrCancelOnce positon=" · "listViewSelectOrCancelOnce curOperationMode=" · "curfilePosition" · "fileType"
- `void run()`  L253 @Override
    - 体内字面量："curfilePosition" · "fileType"
- `List<FileItemInfo> loadMoreFile()`  L266
- `void loadPhotoWall()`  L278
- `void run()`  L284 @Override
    - 体内字面量："pbItemInfoList="
- `void run()`  L302 @Override
- `void run()`  L312 @Override
    - 体内字面量："pbItemInfoList="
- `void run()`  L339 @Override
- `void run()`  L348 @Override
- `void refreshPhotoWall()`  L360
    - 体内字面量："1122" · "refreshPhotoWall"
- `void resetCurIndex()`  L371
- `void setFragment(Fragment fragment)`  L375
- `void setView(MultiPbFragmentView2 multiPbFragmentView2)`  L379
- `void stopLoad()`  L384
### `com.icatch.golive.Presenter.MultiPbFragmentPresenter2$DeleteFileThread`
L53 · [class] private DeleteFileThread · implements `Runnable` · `com/icatch/golive/Presenter/MultiPbFragmentPresenter2.java`

字段/常量（4）：
- `List<FileItemInfo> deleteSucceedList`  L54
- `List<FileItemInfo> fileList`  L55
- `int fileType`  L56
- `FileListView.DeleteResponse response`  L57

方法（3）：
- `public DeleteFileThread(List<FileItemInfo> list, int i, FileListView.DeleteResponse deleteResponse)`  L61
- `void run()`  L68 @Override
    - 体内字面量："DeleteThread" · "deleteFile f.getFileHandle ="
- `void run()`  L79 @Override
### `com.icatch.golive.Presenter.MultiPbPhotoFragmentPresenter`
L38 · [class] public MultiPbPhotoFragmentPresenter · extends `BasePresenter` · `com/icatch/golive/Presenter/MultiPbPhotoFragmentPresenter.java`

字段/常量（27）：
- `int section = 1`  L39
- `String TAG`  L40
- `Activity activity`  L41
- `PhotoWallLayoutType curLayoutType`  L42
- `OperationMode curOperationMode`  L43
- `FileOperation fileOperation`  L44
- `FileType fileType`  L45
- `Handler handler`  L46
- `boolean isFirstEnterThisActivity`  L47
- `MultiPbPhotoFragmentView multiPbPhotoView`  L48
- `List<MultiPbItemInfo> pbItemInfoList`  L49
- `MultiPbPhotoWallGridAdapter photoWallGridAdapter`  L50
- `MultiPbPhotoWallListAdapter photoWallListAdapter`  L51
- `Map<String, Integer> sectionMap`  L52
- `int topVisiblePosition`  L53
- `int width`  L54
- `FileType fileType = this.fileType`  L132
- `int i = this.fileType == FileType.FILE_PHOTO ? 1 : 2`  L150
- `OperationMode operationMode = OperationMode.MODE_EDIT`  L206
- `OperationMode operationMode = OperationMode.MODE_EDIT`  L227
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L286
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L304
- `int selectedCount`  L316
- `int selectedCount2`  L317
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L344
- `MultiPbPhotoWallListAdapter multiPbPhotoWallListAdapter = this.photoWallListAdapter`  L355
- `MultiPbPhotoWallGridAdapter multiPbPhotoWallGridAdapter = this.photoWallGridAdapter`  L369

方法（24）：
- `public MultiPbPhotoFragmentPresenter(Activity activity, FileType fileType)`  L95
    - 体内字面量："MultiPbPhotoFragmentPresenter"
- `void changePreviewType(PhotoWallLayoutType photoWallLayoutType)`  L110
- `void deleteFile()`  L115
    - 体内字面量："asytaskList size=" · "$1$"
- `void onClick(DialogInterface dialogInterface, int i)`  L128 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L135 @Override
- `void emptyFileList()`  L144
- `List<MultiPbItemInfo> getPhotoInfoList()`  L148
- `List<MultiPbItemInfo> getSelectedList()`  L176
- `void gotoSinglePb(final int i)`  L180
- `void run()`  L186 @Override
    - 体内字面量："curfilePosition" · "fileType" · "curfilePosition" · "fileType"
- `void gridViewEnterEditMode(int i)`  L204
- `void gridViewSelectOrCancelOnce(int i)`  L215
    - 体内字面量："gridViewSelectOrCancelOnce positon=" · " AppInfo.photoWallPreviewType="
- `void listViewEnterEditMode(int i)`  L225
- `void listViewSelectOrCancelOnce(int i)`  L237
    - 体内字面量："listViewSelectOrCancelOnce positon=" · " photoWallPreviewType=" · "listViewSelectOrCancelOnce curOperationMode="
- `void loadPhotoWall()`  L248
- `void run()`  L252 @Override
    - 体内字面量："pbItemInfoList="
- `void run()`  L263 @Override
- `void run()`  L273 @Override
- `void quitEditMode()`  L284
- `void refreshPhotoWall()`  L297
    - 体内字面量："1122" · "refreshPhotoWall layoutType="
- `void selectOrCancelAll(boolean z)`  L315
- `void setAdaper()`  L342
- `void setView(MultiPbPhotoFragmentView multiPbPhotoFragmentView)`  L379
- `void stopLoad()`  L384
### `com.icatch.golive.Presenter.MultiPbPhotoFragmentPresenter$DeleteFileThread`
L56 · [class] private DeleteFileThread · implements `Runnable` · `com/icatch/golive/Presenter/MultiPbPhotoFragmentPresenter.java`

字段/常量（4）：
- `List<MultiPbItemInfo> deleteFailedList`  L57
- `List<MultiPbItemInfo> deleteSucceedList`  L58
- `List<MultiPbItemInfo> fileList`  L59
- `FileType fileType`  L60

方法（3）：
- `public DeleteFileThread(List<MultiPbItemInfo> list, FileType fileType)`  L64
- `void run()`  L70 @Override
    - 体内字面量："DeleteThread" · "deleteFile f.getFileHandle ="
- `void run()`  L84 @Override
### `com.icatch.golive.Presenter.PhotoPbPresenter`
L60 · [class] public PhotoPbPresenter · extends `BasePresenter implements SensorEventListener` · implements `SensorEventListener` · `com/icatch/golive/Presenter/PhotoPbPresenter.java`

字段/常量（59）：
- `int DIRECTION_LEFT = 2`  L61
- `int DIRECTION_RIGHT = 1`  L62
- `int DIRECTION_UNKNOWN = 4`  L63
- `float FIXED_INSIDE_DISTANCE = 0.45454544f`  L64
- `float FIXED_INSIDE_FOCUS = 2.0f`  L65
- `float FIXED_NEAR_DISTANCE = 0.6f`  L66
- `float FIXED_OUTSIDE_DISTANCE = 2.0f`  L67
- `float FIXED_OUTSIDE_FOCUS = 1.0f`  L68
- `float MAX_ZOOM = 2.2f`  L69
- `float MIN_ZOOM = 0.5f`  L70
- `String TAG`  L71
- `Activity activity`  L72
- `float afterLenght`  L73
- `float beforeLenght`  L74
- `String curFilePath`  L75
- `int curPanoramaType`  L76
- `int curPhotoIdx`  L77
- `float currentZoomRate`  L78
- `long downloadProcess`  L79
- `String downloadingFilename`  L80
- `long downloadingFilesize`  L81
- `ExecutorService executor`  L82
- `List<MultiPbItemInfo> fileList`  L83
- `FileOperation fileOperation`  L84
- `Future<Object> future`  L85
- `Sensor gyroscopeSensor`  L86
- `Handler handler`  L87
- `boolean hasDeleted`  L88
- `ICatchSurfaceContext iCatchSurfaceContext`  L89
- `boolean isScrolling`  L90
- `int lastItem`  L91
- `float mPreviousX`  L92
- `float mPreviousY`  L93
- `PanoramaPhotoPlayback panoramaPhotoPlayback`  L94
- `PhotoPbView photoPbView`  L95
- `SensorManager sensorManager`  L96
- `boolean surfaceCreated`  L97
- `int tempLastItem`  L98
- `TouchMode touchMode`  L99
- `PhotoPbViewPagerAdapter viewPagerAdapter`  L100
- `int i = photoPbPresenter.curPhotoIdx`  L303
- `Activity activity = this.activity`  L316
- `PanoramaPhotoPlayback panoramaPhotoPlayback = this.panoramaPhotoPlayback`  L396
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L398
- `int i = this.curPhotoIdx`  L464
- `float f = sensorEvent.values[0]`  L478
- `float f2 = sensorEvent.values[1]`  L479
- `float f3 = sensorEvent.values[2]`  L480
- `PanoramaPhotoPlayback panoramaPhotoPlayback = this.panoramaPhotoPlayback`  L527
- `SensorManager sensorManager = this.sensorManager`  L534
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L546
- `int i = this.curPanoramaType`  L562
- `float f2 = this.currentZoomRate`  L583
- `float f3 = f2 * f`  L586
- `float f4 = f2 * f`  L593
- `float f5 = f2 * f`  L604
- `Activity activity = this.activity`  L653
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L685
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L716

方法（50）：
- `public PhotoPbPresenter(Activity activity)`  L284
    - 体内字面量："PhotoPbPresenter"
- `int access$610(PhotoPbPresenter photoPbPresenter)`  L302
- `void internalShare(String str)`  L309
    - 体内字面量：".provider" · "android.intent.action.SEND" · "android.intent.extra.STREAM" · "image/*"
- `void loadPanoramaPhoto(final MultiPbItemInfo multiPbItemInfo)`  L320
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L324 @Override
    - 体内字面量："onLoadingComplete imageUri:"
- `void onLoadingFailed(String str, View view)`  L338 @Override
    - 体内字面量："onLoadingFailed imageUri:"
- `void onLoadingStarted(String str, View view)`  L343 @Override
    - 体内字面量："onLoadingStarted imageUri:"
- `void locate(float f)`  L350
- `void registerGyroscopeSensor()`  L355
    - 体内字面量："sensor"
- `void rotate(float f, float f2, float f3, long j)`  L363
- `void updateUi()`  L368
- `void zoom(float f)`  L380
- `void back()`  L384
    - 体内字面量："hasDeleted" · "fileType"
- `void clearImage(int i)`  L393
- `void delete()`  L407
- `void download()`  L411
- `float getDistance(MotionEvent motionEvent)`  L415
- `void initPanorama()`  L421
- `void initView()`  L425
- `void onPhotoTap()`  L431 @Override
- `void insidePanorama()`  L446
- `void loadNextImage()`  L450
    - 体内字面量："loadNextImage="
- `void loadPanoramaImage()`  L458
- `void loadPreviousImage()`  L462
    - 体内字面量："loadPreviousImage="
- `void onAccuracyChanged(Sensor sensor, int i)`  L472 @Override
- `void onSensorChanged(SensorEvent sensorEvent)`  L476 @Override
- `void onSufaceViewPointerDown(MotionEvent motionEvent)`  L487
    - 体内字面量："2222" · "event.getPointerCount()................="
- `void onSufaceViewTouchDown(MotionEvent motionEvent)`  L495
- `void onSufaceViewTouchMove(MotionEvent motionEvent)`  L503
- `void onSufaceViewTouchPointerUp()`  L518
- `void onSufaceViewTouchUp()`  L522
- `void release()`  L526
- `void removeGyroscopeListener()`  L533
- `void rotateB(MotionEvent motionEvent, float f, float f2)`  L540
- `void setDrawingArea(int i, int i2)`  L544
    - 体内字面量："start setDrawingArea windowW= " · " windowH= "
- `void setPanoramaType()`  L557
- `void setScale(float f)`  L582
- `void setSdCardEventListener()`  L613
- `void eventListener(int i)`  L616 @Override
- `void onSure()`  L623 @Override
- `void setShowArea(Surface surface)`  L631
    - 体内字面量："start initSurface" · "end initSurface"
- `void setView(PhotoPbView photoPbView)`  L640
    - 体内字面量："curfilePosition"
- `void share()`  L651
- `void showBar()`  L663
    - 体内字面量："showBar isShowBar="
- `void showDeleteEnsureDialog()`  L675
- `void onClick(DialogInterface dialogInterface, int i)`  L681 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L691 @Override
- `void showDownloadEnsureDialog()`  L698
    - 体内字面量："$1$" · "1" · "$3$" · "$2$"
- `void onClick(DialogInterface dialogInterface, int i)`  L706 @Override
    - 体内字面量："showProgressDialog"
- `void onClick(DialogInterface dialogInterface, int i)`  L722 @Override
### `com.icatch.golive.Presenter.PhotoPbPresenter$DeleteThread`
L102 · [class] private DeleteThread · implements `Runnable` · `com/icatch/golive/Presenter/PhotoPbPresenter.java`

字段/常量（1）：
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L108

方法（4）：
- `private DeleteThread()`  L103
- `void run()`  L107 @Override
- `void run()`  L115 @Override
    - 体内字面量："photoNums=" · " curPhotoIdx="
- `void run()`  L137 @Override
    - 体内字面量："end DeleteThread"
### `com.icatch.golive.Presenter.PhotoPbPresenter$DownloadThread`
L147 · [class] private DownloadThread · implements `Runnable` · `com/icatch/golive/Presenter/PhotoPbPresenter.java`

字段/常量（4）：
- `String TAG`  L148
- `int curIdx`  L149
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L165
- `PhotoPbPresenter photoPbPresenter2 = PhotoPbPresenter.this`  L168

方法（4）：
- `private DownloadThread()`  L151
    - 体内字面量："DownloadThread"
- `void run()`  L157 @Override
    - 体内字面量："begin DownloadThread" · "/DCIM/idGoLive/photo/" · "------------fileName ="
- `void run()`  L174 @Override
    - 体内字面量："end downloadFile temp =" · "$1$"
- `void run()`  L188 @Override
    - 体内字面量："end DownloadThread"
### `com.icatch.golive.Presenter.PhotoPbPresenter$MyViewPagerOnPagerChangeListener`
L197 · [class] private MyViewPagerOnPagerChangeListener · implements `ViewPager.OnPageChangeListener` · `com/icatch/golive/Presenter/PhotoPbPresenter.java`

字段/常量（4）：
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L205
- `PhotoPbPresenter photoPbPresenter2 = PhotoPbPresenter.this`  L212
- `PhotoPbPresenter photoPbPresenter3 = PhotoPbPresenter.this`  L215
- `int unused = PhotoPbPresenter.this.lastItem`  L224

方法（4）：
- `private MyViewPagerOnPagerChangeListener()`  L198
- `void onPageScrollStateChanged(int i)`  L202 @Override
- `void onPageScrolled(int i, float f, int i2)`  L222 @Override
- `void onPageSelected(int i)`  L230 @Override
    - 体内字面量："onPageSelected arg0:"
### `com.icatch.golive.Presenter.PhotoPbPresenter$ShareThread`
L236 · [class] private ShareThread · implements `Runnable` · `com/icatch/golive/Presenter/PhotoPbPresenter.java`

字段/常量（4）：
- `String TAG`  L237
- `int curIdx`  L238
- `PhotoPbPresenter photoPbPresenter = PhotoPbPresenter.this`  L254
- `PhotoPbPresenter photoPbPresenter2 = PhotoPbPresenter.this`  L256

方法（4）：
- `private ShareThread()`  L240
    - 体内字面量："DownloadThread"
- `void run()`  L246 @Override
    - 体内字面量："begin DownloadThread" · "/DCIM/idGoLive/photo/" · "------------fileName ="
- `void run()`  L262 @Override
    - 体内字面量："Sharing failed" · "end downloadFile temp ="
- `void run()`  L275 @Override
    - 体内字面量："end DownloadThread"
### `com.icatch.golive.Presenter.PreviewPresenter`
L117 · [class] public PreviewPresenter · extends `BasePresenter implements SensorEventListener` · implements `SensorEventListener` · `com/icatch/golive/Presenter/PreviewPresenter.java`

字段/常量（105）：
- `float FIXED_INSIDE_DISTANCE = 0.5f`  L118
- `float FIXED_OUTSIDE_DISTANCE = 3.0f`  L119
- `float MAX_ZOOM = 2.2f`  L120
- `float MIN_ZOOM = 0.4f`  L121
- `String TAG = "PanoramaPreviewPresenter"`  L122
- `String str_close = "<binary/metadata>"`  L123
- `String str_minutes = "<binary/metadata>"`  L124
- `String str_used = "Used"`  L125
- `Activity activity`  L126
- `float afterLenght`  L127
- `boolean allowClickButtoms`  L128
- `BaseProrertys baseProrertys`  L129
- `float beforeLenght`  L130
- `CameraAction cameraAction`  L131
- `CameraProperties cameraProperties`  L132
- `CameraState cameraState`  L133
- `MediaPlayer continuousCaptureBeep`  L134
- `int curAppStateMode`  L135
- `MyCamera curCamera`  L136
- `String curCodecType`  L137
- `int curIcatchMode`  L138
- `int curPanoramaType`  L139
- `int curVideoFps`  L140
- `int curVideoHeight`  L141
- `int curVideoWidth`  L142
- `int currentSettingMenuMode`  L143
- `float currentZoomRate`  L144
- `ICatchStreamParam defaultStreamParam`  L145
- `FileOperation fileOperation`  L146
- `boolean hasInitSurface`  L147
- `ICatchSurfaceContext iCatchSurfaceContext`  L148
- `IStreamingControl iStreamingControl`  L149
- `boolean isDelEvent`  L150
- `boolean isLive`  L151
- `int lapseTime`  L152
- `long lastCilckTime`  L153
- `long lastRecodeTime`  L154
- `LiveMode liveMode`  L155
- `float mPreviousX`  L156
- `float mPreviousY`  L157
- `MediaStreamPlayer mediaStreamPlayer`  L158
- `MediaPlayer modeSwitchBeep`  L159
- `Boolean needsCloseProgressDialog`  L160
- `PanoramaPreviewPlayback panoramaPreviewPlayback`  L161
- `PreviewHandler previewHandler`  L162
- `PreviewView previewView`  L163
- `Timer recordingLapseTimeTimer`  L164
- `SDKEvent sdkEvent`  L165
- `List<SettingGroup> settingMenuList`  L166
- `MediaPlayer stillCaptureStartBeep`  L167
- `TouchMode touchMode`  L168
- `boolean videoCaptureButtomChangeFlag`  L169
- `Timer videoCaptureButtomChangeTimer`  L170
- `MediaPlayer videoCaptureStartBeep`  L171
- `WifiSSReceiver wifiSSReceiver`  L172
- `ZoomInOut zoomInOut`  L173
- `int i = previewPresenter.lapseTime`  L650
- `int i2`  L656
- `StreamInfo streamInfoConvertToStreamInfoBean`  L661
- `ICatchStreamParam iCatchH264StreamParam`  L662
- `ICatchStreamParam iCatchStreamParam = this.defaultStreamParam`  L672
- `IPanoramaControl panoramaControl`  L697
- `IStreamingControl iStreamingControl = this.iStreamingControl`  L699
- `int i2 = this.curAppStateMode`  L717
- `Timer timer = this.recordingLapseTimeTimer`  L720
- `Timer timer = this.recordingLapseTimeTimer`  L955
- `int i2 = this.curAppStateMode`  L1115
- `int i3 = this.curAppStateMode`  L1125
- `int i4 = this.curAppStateMode`  L1135
- `MyCamera myCamera = this.curCamera`  L1234
- `Tristate tristate = Tristate.NORMAL`  L1287
- `int i = this.curAppStateMode`  L1303
- `int i = this.curAppStateMode`  L1458
- `ICatchCameraControl controlClient`  L1519
- `int i = this.curAppStateMode`  L1591
- `IPanoramaControl panoramaControl`  L1609
- `IStreamingControl iStreamingControl = this.iStreamingControl`  L1610
- `float f = sensorEvent.values[0]`  L1629
- `float f2 = sensorEvent.values[1]`  L1630
- `float f3 = sensorEvent.values[2]`  L1631
- `IPanoramaControl panoramaControl`  L1747
- `IStreamingControl iStreamingControl = this.iStreamingControl`  L1750
- `MyCamera myCamera`  L1758
- `String cameraName`  L1759
- `IPanoramaControl panoramaControl`  L1786
- `int i = this.curPanoramaType`  L1787
- `IStreamingControl iStreamingControl = this.iStreamingControl`  L1801
- `float f2 = this.currentZoomRate`  L1809
- `float f3 = f2 * f`  L1812
- `float f4 = f2 * f`  L1819
- `float f5 = f2 * f`  L1830
- `int i = this.curAppStateMode`  L1858
- `List<SettingGroup> list = this.settingMenuList`  L1872
- `int i = this.curAppStateMode`  L1932
- `int i = this.curAppStateMode`  L1966
- `String str`  L2018
- `String str2 = accessToken`  L2104
- `int i = this.curAppStateMode`  L2139
- `boolean z = AppInfo.disableAudio`  L2149
- `MediaStreamPlayer mediaStreamPlayer = this.mediaStreamPlayer`  L2159
- `String strRefreshAccessToken`  L2242
- `Timer timer = this.videoCaptureButtomChangeTimer`  L2433
- `WifiSSReceiver wifiSSReceiver = this.wifiSSReceiver`  L2465
- `int i = this.curAppStateMode`  L2491
- `int i = this.curAppStateMode`  L2500

方法（155）：
- `public PreviewPresenter(Activity activity)`  L623
    - 体内字面量："H264"
- `int access$1408(PreviewPresenter previewPresenter)`  L649
- `boolean checkModeSwitch(int i)`  L655
- `ICatchStreamParam getStreamParam()`  L660
- `int getSwitchErrorResId(int i)`  L686
- `void rotate(float f, float f2, float f3, long j)`  L696
- `void startPhotoCapture()`  L706
- `void startRecordingLapseTimeTimer(int i)`  L714
    - 体内字面量："startRecordingLapseTimeTimer curMode="
- `void run()`  L729 @Override
- `void run()`  L732 @Override
- `void startTimelapseStillCapture()`  L742
- `void run()`  L746 @Override
- `void run()`  L751 @Override
- `void run()`  L761 @Override
- `void run()`  L771 @Override
    - 体内字面量："failed to start startTimeLapse"
- `void run()`  L783 @Override
- `void run()`  L792 @Override
    - 体内字面量："isSDCardExist IchSocketException"
- `void run()`  L804 @Override
    - 体内字面量："ç½ç»éè¯¯"
- `void startTimelapseVideoCapture()`  L814
- `void run()`  L818 @Override
- `void run()`  L823 @Override
- `void run()`  L833 @Override
    - 体内字面量："time lapse is not allowed because of timelapse interval is OFF"
- `void run()`  L844 @Override
    - 体内字面量："failed to start startTimeLapse"
- `void run()`  L856 @Override
- `void run()`  L866 @Override
    - 体内字面量："isSDCardExist IchSocketException"
- `void run()`  L878 @Override
    - 体内字面量："ç½ç»éè¯¯"
- `void startVideoCapture()`  L888
- `void run()`  L893 @Override
- `void run()`  L899 @Override
- `void run()`  L909 @Override
    - 体内字面量："duration:"
- `void run()`  L926 @Override
    - 体内字面量："startRecordingLapseTimeTimer(0)" · "isSDCardExist IchSocketException"
- `void run()`  L943 @Override
    - 体内字面量："ç½ç»éè¯¯"
- `void stopRecordingLapseTimeTimer()`  L954
- `void stopTimelapseStillCapture()`  L963
- `void run()`  L967 @Override
- `void run()`  L971 @Override
    - 体内字面量："failed to stopTimeLapse"
- `void run()`  L981 @Override
- `void stopTimelapseVideoCapture()`  L991
- `void run()`  L995 @Override
- `void run()`  L1000 @Override
    - 体内字面量："failed to stopTimeLapse"
- `void run()`  L1011 @Override
- `void stopVideoCapture()`  L1021
- `void run()`  L1025 @Override
- `void run()`  L1030 @Override
- `void zoom(float f)`  L1050
- `void addEvent()`  L1054
- `void changeCameraMode(final int i, final int i2)`  L1069
    - 体内字面量："start changeCameraMode ichVideoPreviewMode=" · "start changeCameraMode previewMode=" · "  hasInitSurface="
- `void run()`  L1076 @Override
- `void run()`  L1081 @Override
- `void m493xff52b509(final int i)`  L1093
    - 体内字面量："changePreviewMode previewMode=" · "changePreviewMode curAppStateMode=" · "repeat click: timeInterval=" · "repeat click: timeInterval < 2000"
- `void run()`  L1107 @Override
- `void createUIByMode(int i)`  L1147
    - 体内字面量："start createUIByMode previewMode=" · "1920x1080 30fps"
- `boolean dateStampOffOn()`  L1226
- `void delConnectFailureListener()`  L1230
- `void delEvent()`  L1233
- `void destroyPreview()`  L1251
    - 体内字面量："destroyPreview....."
- `boolean disconnectCamera()`  L1274
- `void finishActivity()`  L1286 @Override
- `float getDistance(MotionEvent motionEvent)`  L1327
- `String getFWVersion()`  L1333
    - 体内字面量："str_fw_ver is "
- `float getMaxZoomRate()`  L1339
- `int getShotCut()`  L1343
- `float getZoomViewProgress()`  L1347
    - 体内字面量："getZoomViewProgress value="
- `void gotoGoogleAccountManagement()`  L1352
- `boolean hasShotCut()`  L1363
- `void initData()`  L1367
    - 体内字面量："videoWidth" · "videoHeight" · "videoFps" · "videoCodec" · "H264" · "initData videoWidth=" · " videoHeight=" · " videoFps=" · " curCodecType=" · "cameraProperties.getMaxZoomRatio() ="
- `void initPreview()`  L1404
    - 体内字面量："initPreview curMode="
- `void eventListener(int i)`  L1408 @Override
    - 体内字面量："camera is recording..." · "camera is TimeLapseVideoOn..." · "camera is TimeLapseStillOn..."
- `void initPreviewPlayer()`  L1518
- `void initStatus()`  L1533
    - 体内字面量："isSDCardExist IchSocketException" · "android.net.wifi.RSSI_CHANGED"
- `void isAppBackground()`  L1561 @Override
- `void m495lambda$onShotCut$1$comicatchgolivePresenterPreviewPresenter(int i)`  L1566
    - 体内字面量："1920x1080 30fps"
- `void m494x3a830ffb()`  L1576
    - 体内字面量："setupBtn is clicked:allowClickButtoms="
- `void run()`  L1584 @Override
- `void locate(float f)`  L1608
- `boolean needShowWatermark()`  L1617
    - 体内字面量："BC2" · "C6"
- `void onAccuracyChanged(Sensor sensor, int i)`  L1623 @Override
- `void onSensorChanged(SensorEvent sensorEvent)`  L1627 @Override
- `void onShotCut()`  L1638
- `void run()`  L1644 @Override
- `void onSufaceViewPointerDown(MotionEvent motionEvent)`  L1650
- `void onSufaceViewTouchDown(MotionEvent motionEvent)`  L1657
- `void onSufaceViewTouchMove(MotionEvent motionEvent)`  L1665
- `void onSufaceViewTouchPointerUp()`  L1680
- `void onSufaceViewTouchUp()`  L1684
- `void m496x77f119e6(final Context context, final Class<?> cls)`  L1690 @Override
    - 体内字面量："pbBtn is clicked curAppStateMode=" · "do not allow to response button clicking"
- `void run()`  L1701 @Override
    - 体内字面量："curAppStateMode ="
- `void run()`  L1721 @Override
    - 体内字面量："intent:start PbMainActivity.class" · "intent:end start PbMainActivity.class" · "end processing for responsing pbBtn clicking" · "isSDCardExist IchSocketException" · "ç½ç»éè¯¯"
- `void redrawSurface()`  L1739
    - 体内字面量："SurfaceViewWidth=" · " SurfaceViewHeight="
- `void rotateB(MotionEvent motionEvent, float f, float f2)`  L1746
- `void savePvThumbnail()`  L1757
- `void setDrawingArea(int i, int i2)`  L1768
    - 体内字面量："start setDrawingArea width=" · " height=" · "end setDrawingArea"
- `void setNeedsCloseProgressDialog(Boolean bool)`  L1781
- `void setPanoramaType()`  L1785
- `void setScale(float f)`  L1808
- `void setView(PreviewView previewView)`  L1839
- `void showPvModePopupWindow()`  L1845
    - 体内字面量："showPvModePopupWindow curAppStateMode="
- `void showSettingDialog(final int i)`  L1870
- `void onOptionSettingComplete()`  L1878 @Override
    - 体内字面量："onOptionSettingComplete"
- `void settingTimeLapseModeComplete(int i2)`  L1889 @Override
- `void settingVideoSizeComplete()`  L1907 @Override
    - 体内字面量："settingVideoSizeComplete curAppStateMode="
- `void showSharedUrlDialog(Context context, String str)`  L1914
    - 体内字面量："Success, share url is:"
- `void onClick(DialogInterface dialogInterface, int i)`  L1923 @Override
- `void showZoomView()`  L1931
- `void startCustomerUrlPublish()`  L1941
    - 体内字面量："startStreamPublishUrl" · "Start customer live" · "rtmp://a.rtmp.youtube.com/live2/3fur-h6bh-as8j-w7wd-d7us" · "Set rtmp url"
- `void onClick(DialogInterface dialogInterface, int i)`  L1959 @Override
- `void startOrStopCapture()`  L1965
- `void startOrStopFacebookLive()`  L2001
    - 体内字面量："Not support Publish Streaming"
- `void OnTokenRefreshFailed(FacebookException facebookException)`  L2012 @Override
- `void OnTokenRefreshed(AccessToken accessToken)`  L2017 @Override
- `void run()`  L2021 @Override
    - 体内字面量："end facebook live"
- `void onCompleted(String str, String str2)`  L2041 @Override
    - 体内字面量：" onCompleted url=" · "start Facebook Live ret=" · " url=" · " id="
- `void run()`  L2048 @Override
- `void onError(final String str)`  L2056 @Override
- `void run()`  L2059 @Override
    - 体内字面量："startPublishStreaming "
- `void startOrStopYouTubeLiveForSdk()`  L2074
    - 体内字面量："Please stop other live!" · "stop push publish..." · "refreshAccessToken googleToken=" · "readSerializable accessToken=" · "readSerializable refreshToken=" · "You are not logged in, please login to google account!" · "readSerializable RefreshToken="
- `void run()`  L2100 @Override
    - 体内字面量："refreshAccessToken accessToken="
- `void run()`  L2107 @Override
    - 体内字面量："start live"
- `void startPreview()`  L2117
    - 体内字面量："start startPreview hasInitSurface=" · "start startPreview isSupportPreview="
- `void run()`  L2124 @Override
- `void startRecordingByResume()`  L2166
- `void startVideoCaptureButtomChangeTimer()`  L2174
    - 体内字面量："startVideoCaptureButtomChangeTimer videoCaptureButtomChangeTimer="
- `void run()`  L2178 @Override
- `void run()`  L2183 @Override
- `void run()`  L2193 @Override
- `void startYouTubeLive()`  L2207
    - 体内字面量："stop push publish..."
- `void run()`  L2213 @Override
    - 体内字面量："Not support Publish Streaming" · "refreshAccessToken googleToken=" · "readSerializable RefreshToken="
- `void run()`  L2241 @Override
- `void run()`  L2248 @Override
- `void run()`  L2259 @Override
    - 体内字面量："refreshAccessToken accessToken="
- `void run()`  L2271 @Override
- `void startYoutubeLiveForSdk(final String str, final String str2)`  L2281
    - 体内字面量："startYoutubeLiveForSdk"
- `void run()`  L2286 @Override
    - 体内字面量："credential getAccessToken=" · "credential getRefreshToken=" · "credential getClientId=" · "credential getClientSecret=" · "720p" · "360Live"
- `void run()`  L2296 @Override
    - 体内字面量："Failed to Youtube live,pushUrl is null!" · " publish broadcast stream push addr: "
- `void run()`  L2308 @Override
    - 体内字面量："Failed to startPublishStreaming!" · "publish broadcast stream share addr: "
- `void run()`  L2321 @Override
- `void run()`  L2335 @Override
    - 体内字面量："Failed to YouTube live,shareUrl is null!"
- `void startYoutubeStreamPublish()`  L2345
    - 体内字面量："readSerializable accessToken=" · "readSerializable refreshToken="
- `void run()`  L2358 @Override
    - 体内字面量："success credential="
- `void run()`  L2367 @Override
    - 体内字面量："push url..."
- `void run()`  L2373 @Override
- `void run()`  L2384 @Override
    - 体内字面量："shareUrl ="
- `void run()`  L2397 @Override
- `void run()`  L2409 @Override
    - 体内字面量："authorize IOException"
- `void stopPreview()`  L2424
- `void stopVideoCaptureButtomChangeTimer()`  L2431
    - 体内字面量："stopVideoCaptureButtomChangeTimer videoCaptureButtomChangeTimer="
- `void stopYoutubeLiveForSdk()`  L2440
    - 体内字面量："stopYoutubeLiveForSdk"
- `void run()`  L2444 @Override
- `void run()`  L2449 @Override
    - 体内字面量："Succed to stop living publish!" · "Failed to stop living publish!"
- `void unregisterWifiSSReceiver()`  L2464
- `void zoomBySeekBar()`  L2472
- `void onCompleted(final float f)`  L2475 @Override
- `void run()`  L2478 @Override
    - 体内字面量："addZoomCompletedListener currentZoomRate ="
- `void zoomIn()`  L2490
- `void zoomOut()`  L2499
### `com.icatch.golive.Presenter.PreviewPresenter$1$1$$ExternalSyntheticLambda0`
L7 · [class] public final PreviewPresenter$1$1$$ExternalSyntheticLambda0 · implements `Runnable` · `com/icatch/golive/Presenter/PreviewPresenter$1$1$$ExternalSyntheticLambda0.java`

方法（1）：
- `void run()`  L9 @Override
### `com.icatch.golive.Presenter.PreviewPresenter$AnonymousClass11`
L176 · [class] AnonymousClass11 · implements `Runnable` · `com/icatch/golive/Presenter/PreviewPresenter.java`

方法（9）：
- `void run()`  L181 @Override
- `void run()`  L186 @Override
- `void run()`  L196 @Override
- `void onStop()`  L208 @Override
- `void onCompleted()`  L217 @Override
- `void run()`  L220 @Override
- `void run()`  L234 @Override
- `void run()`  L241 @Override
    - 体内字面量："isSDCardExist IchSocketException"
- `void run()`  L256 @Override
    - 体内字面量："ç½ç»éè¯¯"
### `com.icatch.golive.Presenter.PreviewPresenter$AnonymousClass20`
L266 · [class] AnonymousClass20 · implements `DialogInterface.OnClickListener` · `com/icatch/golive/Presenter/PreviewPresenter.java`

字段/常量（1）：
- `EditText val$resetTxv`  L267

方法（3）：
- `void onClick(DialogInterface dialogInterface, int i)`  L274 @Override
    - 体内字面量："Url cannot be empty." · "å¼å§ç´æ­" · "Stop customer live"
- `void run()`  L284 @Override
- `void run()`  L289 @Override
    - 体内字面量："Start customer live"
### `com.icatch.golive.Presenter.PreviewPresenter$AnonymousClass24`
L304 · [class] AnonymousClass24 · implements `Runnable` · `com/icatch/golive/Presenter/PreviewPresenter.java`

字段/常量（1）：
- `boolean z2 = false`  L337

方法（4）：
- `void run()`  L309 @Override
- `void run()`  L313 @Override
    - 体内字面量："settingMenuList = "
- `void onItemClick(View view, SettingItem settingItem)`  L318 @Override
- `void onSwitchChanged(View view, SettingItem settingItem, boolean z)`  L324 @Override
    - 体内字面量："toggleButton.setOnClickListener disableAudio="
### `com.icatch.golive.Presenter.PreviewPresenter$PreviewHandler`
L406 · [class] private PreviewHandler · extends `Handler` · `com/icatch/golive/Presenter/PreviewPresenter.java`

字段/常量（3）：
- `Tristate tristate = Tristate.FALSE`  L413
- `int i = message.what`  L414
- `int i2 = message.arg1`  L417

方法（6）：
- `private PreviewHandler()`  L407
- `void handleMessage(Message message)`  L412 @Override
- `void run()`  L431 @Override
- `void run()`  L438 @Override
    - 体内字面量："receive EVENT_FILE_DOWNLOAD" · "receive EVENT_FILE_DOWNLOAD  msg.arg1 =" · "GlobalInfo.autoDownload == false" · "/DCIM/idGoLive/photo/" · "can not download because size limit"
- `void run()`  L475 @Override
    - 体内字面量："receive downloadFile file =" · "receive downloadFile path ="
- `void run()`  L482 @Override
    - 体内字面量："receive downloadFile retvalue =" · "receive EVENT_VIDEO_RECORDING_TIME" · "receive EVENT_SDCARD_INSERT" · "receive SETTING_OPTION_AUTO_DOWNLOAD" · "receive EVENT_CAPTURE_START:curAppStateMode=" · "receive EVENT_SD_CARD_FULL" · "receive EVENT_VIDEO_OFF:curAppStateMode=" · "receive EVENT_VIDEO_ON:curAppStateMode =" · "EVENT_FILE_ADDED" · "receive EVENT_CONNECTION_FAILURE" · "receive EVENT_TIME_LAPSE_STOP:curAppStateMode="
### `com.icatch.golive.Presenter.PreviewPresenter$WifiSSReceiver`
L581 · [class] private WifiSSReceiver · extends `BroadcastReceiver` · `com/icatch/golive/Presenter/PreviewPresenter.java`

字段/常量（1）：
- `WifiManager wifi`  L582

方法（3）：
- `public WifiSSReceiver()`  L584
    - 体内字面量："wifi"
- `void changeWifiStatusIcon()`  L589
    - 体内字面量："change Wifi Statusï¼"
- `void onReceive(Context context, Intent intent)`  L618 @Override
### `com.icatch.golive.Presenter.RemoteDeviceFilesFragmentPresenter`
L45 · [class] public RemoteDeviceFilesFragmentPresenter · extends `BasePresenter` · `com/icatch/golive/Presenter/RemoteDeviceFilesFragmentPresenter.java`

字段/常量（22）：
- `boolean $assertionsDisabled = false`  L46
- `boolean supportSegmentedLoading = true`  L47
- `String TAG`  L48
- `Activity activity`  L49
- `int curIndex`  L50
- `FileOperation fileOperation`  L51
- `int fileTotalNum`  L52
- `int fileType`  L53
- `Fragment fragment`  L54
- `Handler handler`  L55
- `boolean isMore`  L56
- `int maxNum`  L57
- `MultiPbFragmentView2 multiPbPhotoView`  L58
- `List<MultiPbItemInfo> pbItemInfoList`  L59
- `List<MultiPbItemInfo> list2 = list`  L140
- `int i = 0`  L145
- `LinkedList linkedList2 = linkedList`  L148
- `MultiPbItemInfo next`  L188
- `FileListView.DeleteResponse deleteResponse2 = deleteResponse`  L216
- `int i = this.fileType`  L222
- `long fileSize = 0`  L242
- `List<MultiPbItemInfo> list = this.pbItemInfoList`  L484

方法（32）：
- `public RemoteDeviceFilesFragmentPresenter(Activity activity, int i)`  L113
    - 体内字面量："RemoteDeviceFilesFragmentPresenter"
- `LinkedList<ICatchFile> convertFileList(List<FileItemInfo> list)`  L126
- `List<FileItemInfo> convertList(List<MultiPbItemInfo> list)`  L139
- `boolean queryNotVideoWarning()`  L158
- `void run()`  L166 @Override
    - 体内字面量："video_warning_query" · "video_warning_query = "
- `void run()`  L179 @Override
- `void removeLocal(FileItemInfo fileItemInfo)`  L187
- `void deleteFile(final List<FileItemInfo> list, final FileListView.DeleteResponse deleteResponse)`  L202
    - 体内字面量："asytaskList size=" · "$1$"
- `void onClick(DialogInterface dialogInterface, int i)`  L214 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L225 @Override
- `void download(List<FileItemInfo> list)`  L234
    - 体内字面量："asytaskList size="
- `void emptyFileList()`  L254
- `boolean getMoreState()`  L258
- `List<MultiPbItemInfo> getRemotePhotoInfoList()`  L262
- `void itemClick(final FileItemInfo fileItemInfo, final int i)`  L273
    - 体内字面量："listViewSelectOrCancelOnce positon=" · "listViewSelectOrCancelOnce curOperationMode=" · "curfilePosition" · "fileType"
- `void run()`  L293 @Override
- `void m497xd748586a(MyCamera myCamera, FileItemInfo fileItemInfo, int i)`  L302
    - 体内字面量："str_firmware_version = " · "VideoPlayURL" · "rtsp://192.168.1.1" · "VideoPlayTitle" · "curfilePosition" · "fileType"
- `void m498x6090a87b()`  L322
- `void m499xdef1ac5a()`  L329
- `List<FileItemInfo> loadMoreFile()`  L335
    - 体内字面量："/VIDEO" · "/JPG" · "/EVENT"
- `void loadPhotoWall()`  L366
- `void run()`  L374 @Override
    - 体内字面量："pbItemInfoList="
- `void run()`  L397 @Override
- `void run()`  L407 @Override
    - 体内字面量："/VIDEO" · "/JPG" · "/EVENT" · "/VIDEO" · "/JPG" · "/EVENT" · "pbItemInfoList="
- `void run()`  L458 @Override
- `void run()`  L467 @Override
- `throw new RuntimeException(e)`  L476
- `void refreshPhotoWall()`  L482
    - 体内字面量："1122" · "refreshPhotoWall"
- `void resetCurIndex()`  L493
- `void setFragment(Fragment fragment)`  L497
- `void setView(MultiPbFragmentView2 multiPbFragmentView2)`  L501
- `void stopLoad()`  L506
### `com.icatch.golive.Presenter.RemoteDeviceFilesFragmentPresenter$DeleteFileThread`
L61 · [class] private DeleteFileThread · implements `Runnable` · `com/icatch/golive/Presenter/RemoteDeviceFilesFragmentPresenter.java`

字段/常量（4）：
- `List<FileItemInfo> deleteSucceedList`  L62
- `List<FileItemInfo> fileList`  L63
- `int fileType`  L64
- `FileListView.DeleteResponse response`  L65

方法（3）：
- `public DeleteFileThread(List<FileItemInfo> list, int i, FileListView.DeleteResponse deleteResponse)`  L69
- `void run()`  L76 @Override
    - 体内字面量："DeleteThread" · "deleteFile f.getFileHandle ="
- `void run()`  L87 @Override
### `com.icatch.golive.Presenter.RemoteMultiPbPresenter`
L36 · [class] public RemoteMultiPbPresenter · extends `BasePresenter` · `com/icatch/golive/Presenter/RemoteMultiPbPresenter.java`

字段/常量（24）：
- `String TAG = "RemoteMultiPbPresenter"`  L37
- `Activity activity`  L38
- `ViewPagerAdapter adapter`  L39
- `PhotoWallLayoutType curLayoutType`  L40
- `OperationMode curOperationMode`  L41
- `boolean curSelectAll`  L42
- `List<BaseMultiPbFragment> fragments`  L43
- `Handler handler`  L44
- `MultiPbView multiPbView`  L45
- `OnStatusChangedListener onStatusChangedListener`  L46
- `List<BaseMultiPbFragment> list = this.fragments`  L81
- `BaseMultiPbFragment baseMultiPbFragment`  L101
- `List<BaseMultiPbFragment> list = this.fragments`  L103
- `BaseMultiPbFragment baseMultiPbFragment`  L112
- `List<BaseMultiPbFragment> list = this.fragments`  L114
- `Activity activity = this.activity`  L123
- `List<BaseMultiPbFragment> list = this.fragments`  L130
- `BaseMultiPbFragment baseMultiPbFragment`  L142
- `List<BaseMultiPbFragment> list = this.fragments`  L144
- `BaseMultiPbFragment baseMultiPbFragment`  L152
- `String str = TAG`  L154
- `List<BaseMultiPbFragment> list = this.fragments`  L156
- `long fileSizeInteger = 0`  L163
- `List<BaseMultiPbFragment> list = this.fragments`  L234

方法（20）：
- `public RemoteMultiPbPresenter(Activity activity)`  L48
- `void onChangeOperationMode(OperationMode operationMode)`  L56 @Override
    - 体内字面量："multiPbPhotoFragment quit EditMode"
- `void onSelectedItemsCountChanged(int i)`  L73 @Override
    - 体内字面量："$1$"
- `void initViewpager()`  L80
- `void quitEditMode()`  L100
- `void reloadFileList()`  L111
- `void changePreviewType(PhotoWallLayoutType photoWallLayoutType)`  L121
- `void delete()`  L141
- `void download()`  L151
- `void initEditLayout()`  L176
- `void loadViewPager()`  L182
- `void reback()`  L188
    - 体内字面量："reback curOperationMode:"
- `void run()`  L199 @Override
- `void reset()`  L215
- `void selectOrCancel()`  L226
- `void setFileFilter(FileFilter fileFilter)`  L244
- `void setSdCardEventListener()`  L249
- `void eventListener(int i)`  L252 @Override
- `void setView(MultiPbView multiPbView)`  L267
- `void updateViewpagerStatus(int i)`  L272
    - 体内字面量："updateViewpagerStatus arg0="
### `com.icatch.golive.Presenter.RemoteMultiPbPresenter2`
L31 · [class] public RemoteMultiPbPresenter2 · extends `BasePresenter` · `com/icatch/golive/Presenter/RemoteMultiPbPresenter2.java`

字段/常量（12）：
- `String TAG = "RemoteMultiPbPresenter2"`  L32
- `Activity activity`  L33
- `ViewPagerAdapter adapter`  L34
- `OperationMode curOperationMode`  L35
- `List<BaseMultiPbFragment2> fragments`  L36
- `Handler handler`  L37
- `MultiPbView2 multiPbView`  L38
- `OnStatusChangedListener onStatusChangedListener`  L39
- `List<BaseMultiPbFragment2> list = this.fragments`  L67
- `BaseMultiPbFragment2 baseMultiPbFragment2`  L93
- `List<BaseMultiPbFragment2> list = this.fragments`  L95
- `List<BaseMultiPbFragment2> list = this.fragments`  L107

方法（19）：
- `public RemoteMultiPbPresenter2(Activity activity)`  L41
- `void onChangeOperationMode(OperationMode operationMode)`  L47 @Override
    - 体内字面量："multiPbPhotoFragment quit EditMode"
- `void onSelectedItemsCountChanged(int i)`  L60 @Override
- `void initViewpager()`  L66
- `void reloadFileList()`  L92
- `void changePreviewType(int i)`  L102
- `void clearDownloadState()`  L117
- `boolean clickSelectState()`  L121
- `void loadViewPager()`  L130
- `boolean onSelectAllOrNone()`  L135
- `void reback()`  L139
    - 体内字面量："reback curOperationMode:"
- `void run()`  L154 @Override
- `void reset()`  L170
- `boolean setDownloadState()`  L181
- `void setFileFilter(FileFilter fileFilter)`  L185
- `void setSdCardEventListener()`  L190
- `void eventListener(int i)`  L193 @Override
- `void setView(MultiPbView2 multiPbView2)`  L208
- `void updateViewpagerStatus(int i)`  L213
    - 体内字面量："updateViewpagerStatus arg0="
### `com.icatch.golive.Presenter.USBPreviewPresenter`
L91 · [class] public USBPreviewPresenter · extends `BasePresenter implements SensorEventListener` · implements `SensorEventListener` · `com/icatch/golive/Presenter/USBPreviewPresenter.java`

字段/常量（87）：
- `float FIXED_INSIDE_DISTANCE = 0.5f`  L92
- `float FIXED_OUTSIDE_DISTANCE = 3.0f`  L93
- `float MAX_ZOOM = 2.2f`  L94
- `float MIN_ZOOM = 0.4f`  L95
- `String TAG = "USBPreviewPresenter"`  L96
- `Activity activity`  L97
- `float afterLenght`  L98
- `boolean allowClickButtoms`  L99
- `BaseProrertys baseProrertys`  L100
- `float beforeLenght`  L101
- `CameraProperties cameraProperties`  L102
- `CameraStreaming cameraStreaming`  L103
- `UsbDeviceConnection connection`  L104
- `MediaPlayer continuousCaptureBeep`  L105
- `MyCamera curCamera`  L106
- `String curCodecType`  L107
- `int curMode`  L108
- `String curRecordPath`  L109
- `int curVideoFps`  L110
- `int curVideoHeight`  L111
- `int curVideoWidth`  L112
- `float currentZoomRate`  L113
- `Sensor gyroscopeSensor`  L114
- `boolean hasInitSurface`  L115
- `ICatchSurfaceContext iCatchSurfaceContext`  L116
- `boolean isLive`  L117
- `int lapseTime`  L118
- `long lastCilckTime`  L119
- `long lastRecodeTime`  L120
- `LiveMode liveMode`  L121
- `USBMonitor.OnDeviceConnectListener mOnDeviceConnectListener`  L122
- `float mPreviousX`  L123
- `float mPreviousY`  L124
- `USBMonitor mUSBMonitor`  L125
- `MediaPlayer modeSwitchBeep`  L126
- `PanoramaPreviewPlayback panoramaPreviewPlayback`  L127
- `int panoramaType`  L128
- `PreviewHandler previewHandler`  L129
- `USBPreviewView previewView`  L130
- `Timer recordTimer`  L131
- `Timer recordingLapseTimeTimer`  L132
- `SDKEvent sdkEvent`  L133
- `SensorManager sensorManager`  L134
- `SettingListAdapter settingListAdapter`  L135
- `List<SettingMenu> settingMenuList`  L136
- `MediaPlayer stillCaptureStartBeep`  L137
- `int surfaceType`  L138
- `TouchMode touchMode`  L139
- `UsbManager usbManager`  L140
- `boolean videoCaptureButtomChangeFlag`  L141
- `Timer videoCaptureButtomChangeTimer`  L142
- `MediaPlayer videoCaptureStartBeep`  L143
- `USBPreviewPresenter uSBPreviewPresenter = USBPreviewPresenter.this`  L238
- `int i = uSBPreviewPresenter.lapseTime`  L250
- `boolean zStartMovieRecord = false`  L288
- `Timer timer = this.recordTimer`  L301
- `ICatchFrameBuffer iCatchFrameBuffer`  L321
- `Timer timer = this.recordingLapseTimeTimer`  L357
- `PanoramaPreviewPlayback panoramaPreviewPlayback = this.panoramaPreviewPlayback`  L380
- `String str = this.curRecordPath`  L382
- `Timer timer = this.recordTimer`  L391
- `Timer timer = this.recordingLapseTimeTimer`  L400
- `int i = this.curMode`  L620
- `List<SettingMenu> list = this.settingMenuList`  L630
- `SettingListAdapter settingListAdapter = this.settingListAdapter`  L634
- `int i = this.curMode`  L731
- `int i = this.curMode`  L759
- `USBMonitor uSBMonitor = this.mUSBMonitor`  L780
- `SDKEvent sDKEvent = this.sdkEvent`  L787
- `SensorManager sensorManager = this.sensorManager`  L795
- `File file`  L808
- `FileOutputStream fileOutputStream = null`  L810
- `String str3 = str + str2`  L828
- `float f2 = this.currentZoomRate`  L857
- `float f3 = f2 * f`  L860
- `float f4 = f2 * f`  L867
- `float f5 = f2 * f`  L878
- `int i = this.curMode`  L913
- `int i2 = this.curMode`  L919
- `int i = this.curMode`  L959
- `String str`  L1011
- `String strRefreshAccessToken`  L1091
- `Tristate tristateStart`  L1131
- `String str = this.curCodecType`  L1147
- `Tristate tristate = Tristate.FALSE`  L1168
- `Timer timer = this.videoCaptureButtomChangeTimer`  L1385
- `USBMonitor uSBMonitor = this.mUSBMonitor`  L1444

方法（114）：
- `public USBPreviewPresenter(Activity activity)`  L203
    - 体内字面量："H264"
- `void onAttach(UsbDevice usbDevice)`  L224 @Override
- `void onCancel()`  L228 @Override
- `void onConnect(UsbDevice usbDevice, USBMonitor.UsbControlBlock usbControlBlock, boolean z)`  L232 @Override
- `void onDettach(UsbDevice usbDevice)`  L236 @Override
- `void onDisconnect(UsbDevice usbDevice, USBMonitor.UsbControlBlock usbControlBlock)`  L243 @Override
- `int access$1308(USBPreviewPresenter uSBPreviewPresenter)`  L249
- `boolean checkMemory()`  L256
- `void registerGyroscopeSensor()`  L260
    - 体内字面量："sensor"
- `void rotate(float f, float f2, float f3, long j)`  L268
- `void setPanoramaCfg(boolean z)`  L275
    - 体内字面量："usb" · "usbDevice.getProductId() ="
- `boolean startMovieRecord()`  L287
- `void startMovieRecordTimer()`  L300
- `void startPhotoCapture()`  L309
    - 体内字面量："startPhotoCapture curMode=" · "Snap image  is in progress"
- `void run()`  L320 @Override
- `void run()`  L340 @Override
    - 体内字面量："snapImage success" · "snapImage failed"
- `void startRecordingLapseTimeTimer(int i)`  L353
    - 体内字面量："startRecordingLapseTimeTimer curMode=" · "startRecordingLapseTimeTimer"
- `void run()`  L366 @Override
- `void run()`  L369 @Override
- `boolean stopMovieRecord()`  L379
- `void stopMovieRecordTimer()`  L390
- `void stopRecordingLapseTimeTimer()`  L399
- `void zoom(float f)`  L408
- `void addEventListener()`  L412
- `void changePreviewMode(int i)`  L419
    - 体内字面量："changePreviewMode previewMode=" · "repeat click: timeInterval=" · "repeat click: timeInterval < 1000" · "End changePreviewMode curMode="
- `void createUIByMode(int i)`  L438
    - 体内字面量："start createUIByMode previewMode="
- `void destroyPreview()`  L449
    - 体内字面量："destroyPreview....."
- `void finishActivity()`  L477 @Override
    - 体内字面量："onKeyDown curMode=="
- `float getDistance(MotionEvent motionEvent)`  L496
- `void gotoGoogleAccountManagement()`  L502
- `void imageSizeSetting()`  L513
- `void onOptionSettingComplete()`  L517 @Override
    - 体内字面量："Image size:" · "x"
- `void settingTimeLapseModeComplete(int i)`  L525 @Override
- `void settingVideoSizeComplete()`  L529 @Override
- `void initData()`  L535
    - 体内字面量："videoWidth" · "videoHeight" · "videoFps" · "videoCodec" · "initData videoWidth=" · " videoHeight=" · " videoFps=" · " curCodecType="
- `void initImageSize()`  L555
    - 体内字面量："list == null"
- `void initState()`  L564
- `void initSurface(SurfaceHolder surfaceHolder)`  L572
    - 体内字面量："begin initSurface" · "SurfaceViewWidth=" · " SurfaceViewHeight=" · "end initSurface"
- `void initUsbMonitor()`  L602
- `void isAppBackground()`  L607 @Override
- `void loadSettingMenu()`  L614
    - 体内字面量："load setting menu"
- `void run()`  L645 @Override
- `void run()`  L648 @Override
- `void locate(float f)`  L659
- `void onAccuracyChanged(Sensor sensor, int i)`  L666 @Override
- `void onSensorChanged(SensorEvent sensorEvent)`  L670 @Override
- `void onSufaceViewPointerDown(MotionEvent motionEvent)`  L676
- `void onSufaceViewTouchDown(MotionEvent motionEvent)`  L683
- `void onSufaceViewTouchMove(MotionEvent motionEvent)`  L691
- `void onSufaceViewTouchPointerUp()`  L706
- `void onSufaceViewTouchUp()`  L710
- `void processAudioSwitcher(boolean z)`  L715
- `void m496x77f119e6(final Context context, final Class<?> cls)`  L723 @Override
    - 体内字面量："pbBtn is clicked curMode=" · "do not allow to response button clicking" · "curMode ="
- `void run()`  L739 @Override
    - 体内字面量："intent:start PbMainActivity.class" · "intent:end start PbMainActivity.class"
- `void redirectToPbActivity()`  L751
    - 体内字面量："pbBtn is clicked curMode=" · "do not allow to response button clicking" · "curMode ="
- `void run()`  L767 @Override
    - 体内字面量："CUR_POSITION" · "intent:end start PbMainActivity.class"
- `void registerUSB()`  L779
- `void removeEventListener()`  L786
- `void removeGyroscopeListener()`  L794
- `void rotateB(MotionEvent motionEvent, float f, float f2)`  L801
- `void saveImage(ICatchFrameBuffer iCatchFrameBuffer)`  L807
- `void setDrawingArea(int i, int i2)`  L843
    - 体内字面量："start setDrawingArea width=" · " height=" · "end setDrawingArea"
- `void setScale(float f)`  L856
- `void setView(USBPreviewView uSBPreviewView)`  L887
- `void showDialogQuit(Context context, final String str)`  L893
- `void onClick(DialogInterface dialogInterface, int i)`  L899 @Override
    - 体内字面量："ExitApp because of "
- `void showPvModePopupWindow()`  L907
    - 体内字面量："showPvModePopupWindow curMode="
- `void showSettingDialog(int i)`  L927
- `void showSharedUrlDialog(Context context, String str)`  L930
    - 体内字面量："Success, share url is:"
- `void onClick(DialogInterface dialogInterface, int i)`  L939 @Override
- `void showZoomView()`  L947
- `void startOrStopCapture()`  L950
    - 体内字面量："curMode ="
- `void startOrStopFacebookLive()`  L990
    - 体内字面量："Not support Publish Streaming"
- `void OnTokenRefreshFailed(FacebookException facebookException)`  L1005 @Override
- `void OnTokenRefreshed(AccessToken accessToken)`  L1010 @Override
- `void run()`  L1014 @Override
    - 体内字面量："end facebook live"
- `void onCompleted(String str, String str2)`  L1034 @Override
    - 体内字面量：" onCompleted url=" · "start Facebook Live ret=" · " url=" · " id="
- `void run()`  L1041 @Override
- `void onError(final String str)`  L1049 @Override
- `void run()`  L1052 @Override
    - 体内字面量："startPublishStreaming "
- `void startOrStopYouTubeLive()`  L1067
    - 体内字面量："Please stop other live!" · "stop push publish..." · "refreshAccessToken googleToken=" · "You are not logged in, please login to google account!" · "readSerializable RefreshToken="
- `void run()`  L1090 @Override
- `void run()`  L1097 @Override
    - 体内字面量："refreshAccessToken IOException"
- `void run()`  L1108 @Override
    - 体内字面量："Failed to get accessToken , Please enter the google account click disconnect and re-login!" · "refreshAccessToken accessToken="
- `void run()`  L1120 @Override
    - 体内字面量："start live"
- `void startPreview()`  L1130
- `void run()`  L1143 @Override
    - 体内字面量："PV param Width=" · " Height=" · " Fps=" · " curCodecType="
- `void run()`  L1162 @Override
- `void startVideoCaptureButtomChangeTimer()`  L1175
    - 体内字面量："startVideoCaptureButtomChangeTimer videoCaptureButtomChangeTimer="
- `void run()`  L1179 @Override
- `void run()`  L1184 @Override
- `void run()`  L1194 @Override
- `void startYoutubeLive()`  L1208
    - 体内字面量："readSerializable accessToken=" · "readSerializable refreshToken=" · "Failed to Youtube live,OAuth2AccessToken is null!"
- `void run()`  L1221 @Override
    - 体内字面量："success credential="
- `void run()`  L1230 @Override
    - 体内字面量："push url..."
- `void run()`  L1236 @Override
    - 体内字面量："Failed to Youtube live,pushUrl is null!"
- `void run()`  L1247 @Override
    - 体内字面量："Failed to start publish streaming!" · "shareUrl ="
- `void run()`  L1260 @Override
- `void run()`  L1272 @Override
    - 体内字面量："Failed to YouTube live,shareUrl is null!" · "authorize IOException"
- `void startYoutubeLiveForSdk()`  L1287
    - 体内字面量："startYoutubeLiveForSdk" · "readSerializable accessToken=" · "readSerializable refreshToken=" · "Failed to Youtube live,OAuth2 AccessToken is null!"
- `void run()`  L1300 @Override
    - 体内字面量："credential getAccessToken=" · "credential getRefreshToken=" · "credential getClientId=" · "credential getClientSecret=" · "720p" · "360Live"
- `void run()`  L1310 @Override
    - 体内字面量："Failed to Youtube live,pushUrl is null!" · " publish broadcast stream push addr: "
- `void run()`  L1322 @Override
    - 体内字面量："Failed to startPublishStreaming!" · "publish broadcast stream share addr: "
- `void run()`  L1335 @Override
- `void run()`  L1349 @Override
    - 体内字面量："Failed to YouTube live,shareUrl is null!"
- `boolean stopPreview()`  L1360
- `void stopVideoCaptureButtomChangeTimer()`  L1383
    - 体内字面量："stopVideoCaptureButtomChangeTimer videoCaptureButtomChangeTimer="
- `void stopYoutubeLive()`  L1392
- `void run()`  L1395 @Override
- `void run()`  L1404 @Override
    - 体内字面量："Succed to stop living publish!" · "Failed to stop living publish!"
- `void stopYoutubeLiveForSdk()`  L1419
    - 体内字面量："stopYoutubeLiveForSdk"
- `void run()`  L1423 @Override
- `void run()`  L1428 @Override
    - 体内字面量："Succed to stop living publish!" · "Failed to stop living publish!"
- `void unregisterUSB()`  L1443
### `com.icatch.golive.Presenter.USBPreviewPresenter$MyRecordTimerTask`
L145 · [class] MyRecordTimerTask · extends `TimerTask` · `com/icatch/golive/Presenter/USBPreviewPresenter.java`

方法（2）：
- `void run()`  L150 @Override
- `void run()`  L153 @Override
    - 体内字面量："stopMovieRecord false" · "There is not enough memory space" · "Add a new file" · "startMovieRecord false"
### `com.icatch.golive.Presenter.USBPreviewPresenter$PreviewHandler`
L182 · [class] private PreviewHandler · extends `Handler` · `com/icatch/golive/Presenter/USBPreviewPresenter.java`

字段/常量（1）：
- `Tristate tristate = Tristate.FALSE`  L188

方法（2）：
- `private PreviewHandler()`  L183
- `void handleMessage(Message message)`  L187 @Override
### `com.icatch.golive.Presenter.VideoPbPresenter`
L59 · [class] public VideoPbPresenter · extends `BasePresenter` · `com/icatch/golive/Presenter/VideoPbPresenter.java`

字段/常量（37）：
- `float MAX_ZOOM = 2.2f`  L60
- `float MIN_ZOOM = 0.5f`  L61
- `String TAG`  L62
- `Activity activity`  L63
- `float afterLenght`  L64
- `float beforeLenght`  L65
- `int curPanoramaType`  L66
- `ICatchFile curVideoFile`  L67
- `int curVideoPosition`  L68
- `float currentZoomRate`  L69
- `Timer downloadProgressTimer`  L70
- `boolean enableRender`  L71
- `ExecutorService executor`  L72
- `List<MultiPbItemInfo> fileList`  L73
- `FileOperation fileOperation`  L74
- `int fileType`  L75
- `VideoPbHandler handler`  L76
- `boolean hasDeleted`  L77
- `IStreamingControl iStreamingControl`  L78
- `float mPreviousX`  L79
- `float mPreviousY`  L80
- `MediaStreamPlayer mediaStreamPlayer`  L81
- `PanoramaVideoPlayback panoramaVideoPlayback`  L82
- `SingleDownloadDialog singleDownloadDialog`  L83
- `TouchMode touchMode`  L84
- `VideoPbView videoPbView`  L85
- `float f2 = this.currentZoomRate`  L314
- `float f3 = f2 * f`  L317
- `float f4 = f2 * f`  L324
- `float f5 = f2 * f`  L335
- `IStreamingControl iStreamingControl`  L396
- `IPanoramaControl panoramaControl`  L397
- `IStreamingControl iStreamingControl`  L447
- `IPanoramaControl panoramaControl`  L448
- `IPanoramaControl panoramaControl`  L458
- `int i = this.curPanoramaType`  L459
- `IStreamingControl iStreamingControl = this.iStreamingControl`  L473

方法（35）：
- `public VideoPbPresenter(Activity activity)`  L257
    - 体内字面量："VideoPbPresenter" · "curfilePosition" · "fileType" · "cur video fileType=" · " position=" · " video name="
- `float getDistance(MotionEvent motionEvent)`  L278
- `void initStreamParam()`  L284
    - 体内字面量："curfilePosition" · "fileType"
- `void initView()`  L296
- `void rotate(float f, float f2, float f3, long j)`  L306
- `void setScale(float f)`  L313
- `void zoom(float f)`  L344
- `void delete()`  L348
- `void download()`  L352
- `void enableEIS(boolean z)`  L356
- `void exitPlayback()`  L368
    - 体内字面量："hasDeleted" · "fileType"
- `void initClint()`  L378
- `void isAppBackground()`  L390 @Override
- `void locate(float f)`  L395
- `void onSufaceViewPointerDown(MotionEvent motionEvent)`  L404
- `void onSufaceViewTouchDown(MotionEvent motionEvent)`  L411
- `void onSufaceViewTouchMove(MotionEvent motionEvent)`  L419
- `void onSufaceViewTouchPointerUp()`  L434
- `void onSufaceViewTouchUp()`  L438
- `void play()`  L442
- `void rotateB(MotionEvent motionEvent, float f, float f2)`  L446
- `void setPanoramaType()`  L457
- `void setSdCardEventListener()`  L480
- `void eventListener(int i)`  L483 @Override
- `void onSure()`  L491 @Override
- `void setView(VideoPbView videoPbView)`  L499
- `void showDeleteEnsureDialog()`  L506
    - 体内字面量："$1$" · "1"
- `void onClick(DialogInterface dialogInterface, int i)`  L512 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L521 @Override
- `void showDownloadEnsureDialog()`  L528
    - 体内字面量："video FileSize=" · "$1$" · "1" · "$3$" · "$2$"
- `void onClick(DialogInterface dialogInterface, int i)`  L537 @Override
    - 体内字面量："showProgressDialog"
- `void onClick(View view)`  L548 @Override
    - 体内字面量："------------fileName ="
- `void onClick(DialogInterface dialogInterface, int i)`  L566 @Override
- `void showMoreSettingLayout(boolean z)`  L573
- `void stopVideoStream()`  L583
### `com.icatch.golive.Presenter.VideoPbPresenter$DeleteThread`
L87 · [class] private DeleteThread · implements `Runnable` · `com/icatch/golive/Presenter/VideoPbPresenter.java`

方法（4）：
- `private DeleteThread()`  L88
- `void run()`  L92 @Override
- `void run()`  L97 @Override
    - 体内字面量："hasDeleted" · "fileType"
- `void run()`  L111 @Override
    - 体内字面量："end DeleteThread"
### `com.icatch.golive.Presenter.VideoPbPresenter$DownloadProcessTask`
L121 · [class] DownloadProcessTask · extends `TimerTask` · `com/icatch/golive/Presenter/VideoPbPresenter.java`

字段/常量（4）：
- `String curDownloadFile`  L122
- `long curFileLength`  L123
- `int downloadProgress = 0`  L124
- `long fileSize`  L125

方法（3）：
- `public DownloadProcessTask(String str)`  L127
- `void run()`  L132 @Override
- `void run()`  L145 @Override
    - 体内字面量："update Process downloadProgress=" · "end DownloadProcessTask"
### `com.icatch.golive.Presenter.VideoPbPresenter$DownloadThread`
L156 · [class] private DownloadThread · implements `Runnable` · `com/icatch/golive/Presenter/VideoPbPresenter.java`

字段/常量（4）：
- `String TAG = "DownloadThread"`  L157
- `String fileName`  L158
- `String fileType`  L159
- `String targetPath`  L160

方法（3）：
- `void run()`  L168 @Override
    - 体内字面量："begin DownloadThread"
- `void run()`  L175 @Override
    - 体内字面量：".mov" · ".MOV" · "video/quicktime" · "end downloadFile temp =" · "$1$"
- `void run()`  L203 @Override
    - 体内字面量："end DownloadThread"
### `com.icatch.golive.Presenter.VideoPbPresenter$VideoPbHandler`
L217 · [class] private VideoPbHandler · extends `Handler` · `com/icatch/golive/Presenter/VideoPbPresenter.java`

字段/常量（1）：
- `int i = message.what`  L223

方法（2）：
- `private VideoPbHandler()`  L218
- `void handleMessage(Message message)`  L222 @Override