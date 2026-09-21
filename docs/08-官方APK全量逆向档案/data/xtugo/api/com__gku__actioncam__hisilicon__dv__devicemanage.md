# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.devicemanage

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.devicemanage.DeviceManageActivity`
L62 · [class] public DeviceManageActivity · extends `Activity implements AdapterView.OnItemClickListener` · implements `AdapterView.OnItemClickListener` · `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java`

字段/常量（46）：
- `int MSG_CONNECT_AP = 5002`  L63
- `int MSG_CONNECT_TIMEOUT = 5001`  L64
- `int MSG_SCAN_WIFI = 5000`  L65
- `String TAG = "DeviceManageActivity"`  L66
- `Context mContext`  L69
- `SharedPreferences.Editor editor`  L70
- `GridView gvDeviceList`  L71
- `View imgPhoto`  L72
- `ImageView imgRefresh`  L73
- `View imgSetting`  L74
- `boolean isSynchronization`  L75
- `HiWifiManager mHiWifiManager`  L76
- `CustomDialog_Progress mProgressdlg`  L77
- `Wifipasswdinputfrag mWifi_passwdInput`  L78
- `NetworkStateReceiver networkStateReceiver`  L79
- `ProgressDialog progressDialog`  L80
- `ScanResultReceiver scanResultReceiver`  L81
- `SharedPreferences sp`  L82
- `List<ScanResult> wifiScanList`  L83
- `boolean bConnecting = false`  L85
- `String connectingSSID = "<binary/metadata>"`  L86
- `String connectingKey = "<binary/metadata>"`  L87
- `String waitforToConnectSSID = "<binary/metadata>"`  L88
- `String waitforToConnectKey = "<binary/metadata>"`  L89
- `int i = msg.what`  L94
- `long lastBackPressedTime = 0`  L135
- `DeviceManageActivity deviceManageActivity = DeviceManageActivity.this`  L176
- `DeviceManageActivity deviceManageActivity2 = DeviceManageActivity.this`  L178
- `DeviceManageActivity deviceManageActivity3 = DeviceManageActivity.this`  L180
- `DeviceManageActivity deviceManageActivity4 = DeviceManageActivity.this`  L183
- `File file = G.localDCIMDataPath`  L291
- `File file2 = G.localAppDataPath`  L296
- `NetworkStateReceiver networkStateReceiver = this.networkStateReceiver`  L376
- `ScanResultReceiver scanResultReceiver = this.scanResultReceiver`  L381
- `String str = this.waitforToConnectSSID`  L564
- `DeviceManageActivity deviceManageActivity = DeviceManageActivity.this`  L588
- `DeviceManageActivity deviceManageActivity2 = DeviceManageActivity.this`  L591
- `String str`  L606
- `String str2`  L607
- `HiWifiManager hiWifiManager = this.mHiWifiManager`  L608
- `String str`  L617
- `HiWifiManager hiWifiManager = this.mHiWifiManager`  L618
- `String str = gridItem.ssid`  L643
- `WifiInfo wifiInfo = connectionInfo`  L663
- `DeviceManageActivity deviceManageActivity = DeviceManageActivity.this`  L691
- `DeviceManageActivity deviceManageActivity2 = DeviceManageActivity.this`  L694

方法（40）：
- `void handleMessage(Message msg)`  L92 @Override
- `boolean onTouchEvent(MotionEvent event)`  L145 @Override
- `void onCreate(Bundle savedInstanceState)`  L150 @Override
- `boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id)`  L164 @Override
- `void onClick(View view)`  L170 @Override
- `void onClick(View v)`  L175 @Override
- `void onClick(View v)`  L192 @Override
- `void scanFile()`  L199
- `void onScanResultCallback(List<AlbumItemModel> data)`  L203 @Override
    - 体内字面量："66656565655665" · "onScanResultCallback:  ------------------  " · "               "
- `void synchronizationFile(boolean isSynchronization)`  L217
    - 体内字面量："android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.WRITE_EXTERNAL_STORAGE"
- `void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)`  L229 @Override
    - 体内字面量："ä½ è¿ææä»¶æ²¡æåæ­¥ï¼è¯·æäºæä»¶è¯»åæé"
- `void showSynchDialog()`  L238
    - 体内字面量："786452132131321" · "onCreate: ----------4-------------  "
- `void onClick(DialogInterface dialog, int which)`  L243 @Override
- `void onClick(DialogInterface dialog, int which)`  L247 @Override
- `void showProgressDialog()`  L255
    - 体内字面量："sync"
- `void syncTryAgain()`  L273
- `void onClick(DialogInterface dialog, int which)`  L277 @Override
- `void onClick(DialogInterface dialog, int which)`  L282 @Override
    - 体内字面量："786452132131321" · "showProgressDialog: -------------------------6"
- `boolean moveFile()`  L290
- `void move(String oldPath, String newPath)`  L312
    - 体内字面量："application/octet-stream"
- `void onScanCompleted(final String path, final Uri uri)`  L325 @Override
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `Vector<String> GetFileName(String fileAbsolutePath)`  L333
- `void onStart()`  L342 @Override
    - 体内字面量："android.net.wifi.SCAN_RESULTS" · "android.net.wifi.supplicant.STATE_CHANGE" · "android.net.wifi.STATE_CHANGE"
- `void onResume()`  L364 @Override
    - 体内字面量："onResume"
- `void onPause()`  L373 @Override
    - 体内字面量："onPause"
- `void guessDeviceIP()`  L558
- `void connectAP()`  L563
- `void run()`  L580 @Override
    - 体内字面量："android.net.wifi.STATE_CHANGE"
- `void saveKey()`  L605
- `void cleanKey()`  L616
- `void onBackPressed()`  L626 @Override
- `void onItemClick(AdapterView<?> adapterView, View view, int position, long id)`  L639 @Override
    - 体内字面量："modify dv, IP:"
- `void run()`  L653 @Override
- `void run()`  L657 @Override
- `void startConnectThread()`  L680
- `void run()`  L683 @Override
    - 体内字面量："android.net.wifi.STATE_CHANGE"
- `void onDestroy()`  L707 @Override
- `void showWaitDialog()`  L711
- `boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event)`  L722 @Override
    - 体内字面量："KeyEvent.KEYCODE_BACK4"
- `void closeWaitDialog()`  L736
### `com.gku.actioncam.hisilicon.dv.devicemanage.DeviceManageActivity$AnonymousClass16`
L494 · [class] static AnonymousClass16 · `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java`

字段/常量（1）：
- `int[] $SwitchMap$android$net$NetworkInfo$DetailedState`  L495
### `com.gku.actioncam.hisilicon.dv.devicemanage.DeviceManageActivity$DeviceAdapter`
L404 · [class] DeviceAdapter · extends `BaseAdapter` · `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java`

字段/常量（1）：
- `ViewHolder viewHolder`  L444

方法（6）：
- `long getItemId(int i)`  L408 @Override
- `void loadData()`  L415
    - 体内字面量："wifi" · "\""
- `boolean isEmpty()`  L428 @Override
- `int getCount()`  L433 @Override
- `Object getItem(int i)`  L438 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L443 @Override
### `com.gku.actioncam.hisilicon.dv.devicemanage.DeviceManageActivity$GridItem`
L137 · [class] public static GridItem · `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java`

字段/常量（3）：
- `String bssid`  L138
- `String capabilities`  L139
- `String ssid`  L141
### `com.gku.actioncam.hisilicon.dv.devicemanage.DeviceManageActivity$NetworkStateReceiver`
L511 · [class] NetworkStateReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java`

方法（1）：
- `void onReceive(Context c, Intent intent)`  L516 @Override
    - 体内字面量："android.net.wifi.STATE_CHANGE" · "networkInfo" · "NetworkInfo.DetailedState=" · "startActivity MainActivity." · "NetworkStateReceiver:"
### `com.gku.actioncam.hisilicon.dv.devicemanage.DeviceManageActivity$ScanResultReceiver`
L461 · [class] ScanResultReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java`

方法（1）：
- `void onReceive(Context c, Intent intent)`  L466 @Override
    - 体内字面量："wifi" · "android.net.wifi.STATE_CHANGE" · "android.net.wifi.SCAN_RESULTS" · "networkInfo" · "info.state = " · "android.net.wifi.supplicant.STATE_CHANGE" · "supplicantError"
### `com.gku.actioncam.hisilicon.dv.devicemanage.DeviceManageActivity$ViewHolder`
L396 · [class] static ViewHolder · `com/gku/actioncam/hisilicon/dv/devicemanage/DeviceManageActivity.java`

字段/常量（2）：
- `ImageView ivCameraIcon`  L397
- `TextView tvWifiName`  L398