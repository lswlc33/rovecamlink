# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.upgrade

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 15 个文件 / 23 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.upgrade.app.ApkInfo`
L6 · [class] public ApkInfo · `com/gku/actioncam/sigmastar/upgrade/app/ApkInfo.java`

字段/常量（5）：
- `String TAG = "ApkInfo"`  L7
- `String chip = "<binary/metadata>"`  L8
- `String version = "<binary/metadata>"`  L9
- `String buildDate = "<binary/metadata>"`  L10
- `int i = 0`  L18

方法（1）：
- `ApkInfo getApkInfoFromName(String apkName)`  L12
    - 体内字面量：".apk" · "-"
### `com.gku.actioncam.sigmastar.upgrade.app.DownloadActivity`
L27 · [class] public DownloadActivity · extends `Activity` · `com/gku/actioncam/sigmastar/upgrade/app/DownloadActivity.java`

字段/常量（14）：
- `int MSG_DOWNLOAD_SUCCESS = 2002`  L28
- `int MSG_QUERY_PROGRESS = 2001`  L29
- `int MSG_REFRESH_UI = 2003`  L30
- `String TAG = "DownloadActivity"`  L31
- `ServerFileAdapter adapter`  L32
- `long downloadId = -1`  L33
- `int i`  L37
- `DownloadActivity downloadActivity = DownloadActivity.this`  L42
- `int i2 = downloadProgress[0]`  L44
- `ListView listViewPackage`  L73
- `ProgressDialog progressDialog`  L74
- `List<String> serverFileList`  L75
- `String serverInfo`  L76
- `DownloadActivity downloadActivity = DownloadActivity.this`  L99

方法（5）：
- `void handleMessage(Message msg)`  L36 @Override
- `void onCreate(Bundle savedInstanceState)`  L79 @Override
    - 体内字面量："ServerInfo"
- `void onClick(DialogInterface dialog, int whichButton)`  L98 @Override
- `void onStart()`  L110 @Override
- `void onStop()`  L119 @Override
### `com.gku.actioncam.sigmastar.upgrade.app.DownloadActivity$ServerFileAdapter`
L123 · [class] ServerFileAdapter · extends `BaseAdapter` · `com/gku/actioncam/sigmastar/upgrade/app/DownloadActivity.java`

字段/常量（4）：
- `List<String> fileList`  L136
- `LayoutInflater inflater`  L137
- `Context mContext`  L138
- `ViewHolder viewHolder`  L166

方法（7）：
- `void onClick(View v)`  L126 @Override
- `long getItemId(int position)`  L141 @Override
- `public ServerFileAdapter(Context context)`  L145
- `void setDataSource(List<String> data)`  L150
- `int getCount()`  L155 @Override
- `Object getItem(int position)`  L160 @Override
- `View getView(final int position, View convertView, ViewGroup parent)`  L165 @Override
### `com.gku.actioncam.sigmastar.upgrade.app.DownloadActivity$ServerFileAdapter$ViewHolder`
L193 · [class] ViewHolder · `com/gku/actioncam/sigmastar/upgrade/app/DownloadActivity.java`

字段/常量（2）：
- `Button btnDownloadFile`  L194
- `TextView textFileName`  L195
### `com.gku.actioncam.sigmastar.upgrade.app.UpgradeInfoJsonMode`
L7 · [class] public UpgradeInfoJsonMode · implements `Parcelable` · `com/gku/actioncam/sigmastar/upgrade/app/UpgradeInfoJsonMode.java`

字段/常量（3）：
- `String devicename`  L21
- `String sourcename`  L22
- `String version`  L23

方法（14）：
- `UpgradeInfoJsonMode createFromParcel(Parcel source)`  L11 @Override
- `UpgradeInfoJsonMode[] newArray(int size)`  L17 @Override
- `int describeContents()`  L26 @Override
- `public UpgradeInfoJsonMode(String devicename, String version, String sourcename)`  L30
- `String getDevicename()`  L36
- `void setDevicename(String devicename)`  L40
- `String getVersion()`  L44
- `void setVersion(String version)`  L48
- `String getSourcename()`  L52
- `void setSourcename(String sourcename)`  L56
- `Parcelable.Creator<UpgradeInfoJsonMode> getCREATOR()`  L60
- `void writeToParcel(Parcel dest, int flags)`  L65 @Override
- `public UpgradeInfoJsonMode()`  L71
- `protected UpgradeInfoJsonMode(Parcel in)`  L74
### `com.gku.actioncam.sigmastar.upgrade.app.UpgradeTaskManager`
L34 · [class] public UpgradeTaskManager · `com/gku/actioncam/sigmastar/upgrade/app/UpgradeTaskManager.java`

字段/常量（28）：
- `String SERVER_BASE_URL = "http://121.40.107.215:8041/firmware/"`  L35
- `String SERVER_INFO_FILE = "info.json"`  L36
- `String TAG = "UpgradeManager"`  L37
- `boolean bCancelUpload = false`  L38
- `UploadListener mUploadListener`  L39
- `String strSubstring`  L100
- `String[] localAllFirmware`  L118
- `String str`  L155
- `Throwable th`  L156
- `long j`  L157
- `FileInputStream fileInputStream`  L158
- `OutputStream outputStream`  L159
- `BufferedInputStream bufferedInputStream`  L160
- `Socket socket`  L161
- `UploadListener uploadListener`  L162
- `UploadListener uploadListener2`  L163
- `Throwable th2`  L164
- `UploadListener uploadListener3`  L165
- `UploadListener uploadListener4`  L166
- `BufferedInputStream bufferedInputStream2`  L167
- `long j2 = 0`  L169
- `byte[] bArr = new byte[1024]`  L204
- `UploadListener uploadListener5 = this.mUploadListener`  L214
- `UploadListener uploadListener6 = this.mUploadListener`  L781
- `UploadListener uploadListener7 = this.mUploadListener`  L785
- `String str = SERVER_BASE_URL + filename`  L871
- `Cursor cursorQuery`  L887
- `int[] iArr = {0, 100}`  L891

方法（19）：
- `void setUploadListener(UploadListener listener)`  L51
- `void stopUpload()`  L55
- `String[] getLocalAllFirmware(Context context)`  L59
- `boolean accept(File dir, String filename)`  L62 @Override
    - 体内字面量：".sw"
- `String[] getLocalFirmwareByChip(Context context, final String chip)`  L68
- `boolean accept(File dir, String filename)`  L71 @Override
    - 体内字面量：".sw"
- `String[] getLocalFirmwareByPrefix(Context context, final String prefix)`  L77
- `boolean accept(File dir, String filename)`  L80 @Override
    - 体内字面量：".sw"
- `String getUpgradePath(Context context)`  L86
    - 体内字面量："/upgrade/"
- `boolean exists(Context context, String filename)`  L95
- `boolean serverHaveLatestAPK(Context context, String serverApkName)`  L99
- `String[] getMatchedFirmware(Context context, Common.DeviceAttr deviceAttr)`  L117
- `void uploadFirmware(String deviceIP, String pathname)`  L154
- `String getServerInfo()`  L842
    - 体内字面量："http://121.40.107.215:8041/firmware/info.json" · "getServerInfo() failed"
- `List<String> parseServerFileList(String serverInfo)`  L851
    - 体内字面量："name"
- `long download(Context context, String filename)`  L869
- `int[] getDownloadProgress(Context context, long downloadId)`  L886
- `int cancelDownload(Context context, long downloadId)`  L918
- `void installAPK(Context context, Uri fileUri)`  L922
    - 体内字面量：".apk" · "android.intent.action.VIEW" · "application/vnd.android.package-archive"
### `com.gku.actioncam.sigmastar.upgrade.app.UpgradeTaskManager$UploadListener`
L41 · [interface] public UploadListener · `com/gku/actioncam/sigmastar/upgrade/app/UpgradeTaskManager.java`

方法（4）：
- `void onUploadCanceled()`  L42
- `void onUploadFailed()`  L44
- `void onUploadSuccess()`  L46
- `void onUploading(int total, int progress)`  L48
### `com.gku.actioncam.sigmastar.upgrade.app.UpgradeViewManager`
L46 · [class] public UpgradeViewManager · implements `View.OnClickListener` · `com/gku/actioncam/sigmastar/upgrade/app/UpgradeViewManager.java`

字段/常量（63）：
- `String APK_ORIGINAL_NAME = "xtugo_newui"`  L47
- `int CHECK_UPDATE = 4`  L48
- `int CHECK_UPDATE_FAIL = 6`  L49
- `int CHECK_UPDATE_FINISH = 5`  L50
- `int DOWNLOAD_FAIL = 3`  L51
- `int DOWNLOAD_FINISH = 2`  L52
- `int DOWNLOAD_PERCENT = 1`  L53
- `int DOWNLOAD_START = 0`  L54
- `int INSTALL_APK = 7`  L55
- `int SUCCESS = 0`  L56
- `String TAG = "UpgradeViewManager"`  L57
- `String apkDownloadUrl`  L58
- `String apkName`  L59
- `Handler appUpdateHandler`  L60
- `HandlerThread appUpdateThread`  L61
- `Button btnDialogCancel`  L62
- `Button btnDialogOK`  L63
- `IAppUpdateDialogDismissListener dialogDismissListener`  L64
- `NetworkInfo info`  L65
- `ConnectivityManager mConnectivity`  L66
- `Context mContext`  L67
- `Dialog mLoadingDialog`  L68
- `String mSavePath`  L69
- `int progress`  L70
- `RelativeLayout relDownloadPercent`  L71
- `TextView tvDialogAppVersion`  L72
- `TextView tvDialogTitle`  L73
- `TextView txtDialogUpdateMessage`  L74
- `TextView txtDialogUpdatePercent`  L75
- `boolean cancelUpdate = false`  L76
- `boolean isShowCheck = false`  L77
- `boolean isStartInstall = false`  L78
- `File apkFile = null`  L79
- `int i = msg.what`  L86
- `Dialog dialog = this.mLoadingDialog`  L127
- `Handler handler = this.appUpdateHandler`  L140
- `HandlerThread handlerThread = this.appUpdateThread`  L150
- `int i = msg.what`  L162
- `HandlerThread handlerThread = this.appUpdateThread`  L177
- `Dialog dialog = this.mLoadingDialog`  L287
- `String str = this.apkDownloadUrl`  L342
- `String str2 = this.apkName`  L348
- `String str3 = this.apkName`  L376
- `HttpURLConnection httpURLConnection`  L411
- `InputStream inputStream`  L412
- `FileOutputStream fileOutputStream`  L413
- `File file`  L414
- `File file2`  L415
- `File file3`  L416
- `File file4`  L417
- `int i = 0`  L418
- `FileOutputStream fileOutputStream2 = null`  L420
- `FileOutputStream fileOutputStream3 = null`  L421
- `HttpURLConnection httpURLConnection2 = null`  L424
- `byte[] bArr = new byte[1024]`  L453
- `int i2 = 0`  L454
- `int i3 = 0`  L455
- `Intent intent`  L629
- `?? inputStream`  L733
- `BufferedReader bufferedReader`  L734
- `StringBuilder sb`  L735
- `?? r3 = 0`  L738
- `File file = this.apkFile`  L1026

方法（23）：
- `void handleMessage(Message msg)`  L82 @Override
- `void registerAppUpdateDialogDismissListener(IAppUpdateDialogDismissListener dialogDismissListener)`  L118
- `void unRegisterAppUpdateDialogDismissListener()`  L122
- `void stopUpdateApp()`  L126
- `void startAppUpdateHandler()`  L149
- `boolean handleMessage(Message msg)`  L157 @Override
    - 体内字面量："--------------------------appUpdateHandler msg="
- `void stopAppUpdateHandler()`  L176
- `public UpgradeViewManager(Context context)`  L183
    - 体内字面量："connectivity"
- `void onDismiss(DialogInterface dialog2)`  L205 @Override
    - 体内字面量："set cancelUpdate is true" · "mLoadingDialog dismiss finish welcome"
- `void showLoadingDialog(boolean show, int status)`  L218
    - 体内字面量："status=" · " cancelUpdate=" · " isShowCheck=" · " mLoadingDialog is null="
- `void run()`  L296 @Override
    - 体内字面量："set cancelUpdate is true" · "CHECK_UPDATE_FAIL finish welcome"
- `void lambda$showLoadingDialog$0()`  L321
- `void checkUpdate(boolean isShowCheckDialog)`  L325
    - 体内字面量："------wifiName="
- `void CheckAppVersion()`  L339
    - 体内字面量："-------------apkDownloadUrl="
- `int getVersionCode(Context context)`  L392
- `void onlineDownloadApk()`  L410
- `void installApk()`  L628
- `void getApkDownLoadUrl()`  L647
    - 体内字面量："https://server4.gkuvision.com/push/api/getNewestVersion?firmWareModel=XTUGO_Android"
- `void onSuccess(String res)`  L650 @Override
    - 体内字面量："getApkDownLoadUrl : " · "retCode" · "data" · "url" · "Error in onSuccess - data: " · "Error in onSuccess - retCode: " · "Error in onSuccess: apkDownLoadUrl is nullï¼"
- `void onFailed(String err)`  L677 @Override
    - 体内字面量："onFailed: "
- `String getHtmlContent(URL url, String str)`  L732
- `String getHtmlContent(String url, String encode)`  L1009
- `void onClick(View v)`  L1022 @Override
### `com.gku.actioncam.sigmastar.upgrade.app.UpgradeViewManager$IAppUpdateDialogDismissListener`
L114 · [interface] public IAppUpdateDialogDismissListener · `com/gku/actioncam/sigmastar/upgrade/app/UpgradeViewManager.java`

方法（1）：
- `void dialogDismissListener()`  L115
### `com.gku.actioncam.sigmastar.upgrade.firm.Interface.IUpgradePresenter`
L4 · [interface] public IUpgradePresenter · `com/gku/actioncam/sigmastar/upgrade/firm/Interface/IUpgradePresenter.java`

方法（1）：
- `void upgrade(String mModelName, String softVersion)`  L5
### `com.gku.actioncam.sigmastar.upgrade.firm.Interface.UpgradeInterface`
L6 · [interface] public UpgradeInterface · `com/gku/actioncam/sigmastar/upgrade/firm/Interface/UpgradeInterface.java`

方法（1）：
- `void upgradeCameraFirm(UpgradeModel model)`  L7
### `com.gku.actioncam.sigmastar.upgrade.firm.Model.FirmwareInformation`
L4 · [class] public FirmwareInformation · `com/gku/actioncam/sigmastar/upgrade/firm/Model/FirmwareInformation.java`

字段/常量（4）：
- `String firmWareSize`  L5
- `Integer retCode`  L6
- `String updates`  L7
- `String url`  L8

方法（8）：
- `void setRetCode(Integer retcode)`  L10
- `Integer getRetCode()`  L14
- `void setUpdates(String upDates)`  L18
- `String getUpdates()`  L22
- `void setFirmWareSize(String firmWareSize)`  L26
- `String getFirmWareSize()`  L30
- `void setUrl(String url)`  L34
- `String getUrl()`  L38
### `com.gku.actioncam.sigmastar.upgrade.firm.Model.UpgradeModel`
L4 · [class] public UpgradeModel · `com/gku/actioncam/sigmastar/upgrade/firm/Model/UpgradeModel.java`

字段/常量（2）：
- `String updateFilePath`  L5
- `String updateVersionName`  L6

方法（3）：
- `void setUpdateFilePath(String updateFilePath)`  L8
- `void setUpdateVersionName(String updateVersionName)`  L12
- `String toString()`  L16
    - 体内字面量："UpgradeModel{updateFilePath='" · "', updateVersionName='" · "'}"
### `com.gku.actioncam.sigmastar.upgrade.firm.Presenter.UpgradePresenter`
L57 · [class] public UpgradePresenter · implements `IUpgradePresenter` · `com/gku/actioncam/sigmastar/upgrade/firm/Presenter/UpgradePresenter.java`

字段/常量（26）：
- `int DOWNLOAD_FILE_CODE = 100001`  L58
- `int DOWNLOAD_FILE_ContectCamera_CODE = 100008`  L59
- `int DOWNLOAD_FILE_DOWNLOADirmware_CODE = 100007`  L60
- `int DOWNLOAD_FILE_FAILE_CODE = 100002`  L61
- `int DOWNLOAD_FILE_FAILE_FINISH_CODE = 100003`  L62
- `int DOWNLOAD_FILE_FAILE_GETMODELNAME_CODE = 100004`  L63
- `int DOWNLOAD_FILE_FAILE_GETPATHERROR_CODE = 100005`  L64
- `int DOWNLOAD_FILE_FAILE_SVGreaterThan_LV_CODE = 100006`  L65
- `int DOWNLOAD_FILE_NotExistFileInfo_CODE = 100009`  L66
- `String TAG = "UpgradePresenter"`  L67
- `String cSoftVersion`  L68
- `String cSoftVersionName`  L69
- `ProgressDialog dialog`  L70
- `String lSoftVersion`  L71
- `String lSoftVersionName`  L72
- `UpgradeInterface launchInter`  L73
- `Context mContext`  L74
- `DownloadUtil mDownload`  L75
- `String mModelName`  L122
- `String sSoftVersion`  L123
- `String sSoftVersionName`  L124
- `String str = TAG`  L137
- `String str3 = strArrSplit3[strArrSplit3.length - 1]`  L204
- `PowerManager.WakeLock wakeLock = wakeLockNewWakeLock`  L334
- `int i = size - 1`  L383
- `File filesDir`  L429

方法（25）：
- `void handleMessage(Message msg)`  L78 @Override
    - 体内字面量："/" · "android.settings.WIFI_SETTINGS" · "android.settings.WIFI_SETTINGS"
- `public UpgradePresenter(Context context, UpgradeInterface launchInter)`  L126
- `void upgrade(String mModelName, String softVersion)`  L132 @Override
- `void upgradeOperate(String name, String softVersion)`  L136
- `void onFailure(Call call, IOException e)`  L169 @Override
    - 体内字面量："DNS è§£æå¤±è´¥ææ ç½ç»: " · "è¯·æ±è¶æ¶: " · "è¯·æ±å¤±è´¥: "
- `void onResponse(Call call, Response response)`  L185 @Override
    - 体内字面量："æå¡å¨è¿åéè¯¯ç : " · "è·åæå responseData=" · "retCode" · "data" · "updates" · "url" · "_"
- `void run()`  L245 @Override
- `void download(String url)`  L300
    - 体内字面量："power" · ":ScreenWakeLockTag" · "/"
- `void onDownloadSuccess()`  L308 @Override
    - 体内字面量："ä¸è½½æå"
- `void run()`  L315 @Override
- `void onDownloading(int progress)`  L324 @Override
    - 体内字面量："ä¸è½½è¿åº¦"
- `void onDownloadFailed()`  L333 @Override
- `boolean downloadedNewer()`  L355
    - 体内字面量："/"
- `UpgradeModel judgeCameraVersionAndLocalCameraVersion()`  L365
    - 体内字面量："/" · "è¯·è¿æ¥å¯ç¨ç½ç»å»ä¸è½½åºä»¶  savePath=" · "android.settings.WIFI_SETTINGS" · "/" · "/"
- `void showDialog()`  L407
- `void onClick(DialogInterface dialog, int which)`  L418 @Override
- `File getlocalAppDataPath()`  L428
- `boolean checkCameraConnectStates()`  L442
- `String getIp()`  L446
    - 体内字面量："wifi"
- `String intToIp(int i)`  L454
- `String getFirstDownloadFileName(String savePath)`  L458
    - 体内字面量："æ ä»¶ï¼"
- `ArrayList<String> getAllDataFileName(String savePath)`  L473
    - 体内字面量："æ ä»¶ï¼"
- `ArrayList<File> getAllDataFile(String savePath)`  L488
    - 体内字面量："æ ä»¶ï¼"
- `String getFileName(String urlName)`  L503
    - 体内字面量："/"
- `void DeleteFile(File file)`  L512
### `com.gku.actioncam.sigmastar.upgrade.firm.Presenter.UpgradePresenter$TimeoutDns`
L253 · [class] static TimeoutDns · implements `Dns` · `com/gku/actioncam/sigmastar/upgrade/firm/Presenter/UpgradePresenter.java`

字段/常量（1）：
- `int timeoutMs`  L254

方法（4）：
- `public TimeoutDns(int timeoutMs)`  L256
- `List<InetAddress> lookup(final String hostname)`  L261 @Override
- `Object call()`  L265 @Override
    - 体内字面量："DNS lookup failed: " · "DNS lookup failed: " · "DNS lookup timed out: "
- `List lambda$lookup$0(String str)`  L290
    - 体内字面量："DNS resolution failed: "
### `com.gku.actioncam.sigmastar.upgrade.firm.Ui.UpgradeSendFirmActivity`
L41 · [class] public UpgradeSendFirmActivity · extends `BaseActivity implements IChannelListener` · implements `IChannelListener` · `com/gku/actioncam/sigmastar/upgrade/firm/Ui/UpgradeSendFirmActivity.java`

字段/常量（15）：
- `String TAG = "UpgradeSendFirmActivity"`  L42
- `AmbaFWUtil ambaFWUtil`  L44
- `String[] arraySending`  L45
- `ImageView centerLogo`  L46
- `View centerPoint`  L47
- `ImageView icBack`  L48
- `ImageView ivSave`  L49
- `RelativeLayout layoutTitle`  L50
- `ProgressDialog progressDialog`  L51
- `ImageView sendingImage`  L52
- `TextView sendingText`  L53
- `Button updateFinish`  L54
- `int i = msg.what`  L59
- `boolean isUpdating = false`  L74
- `AmbaFWUtil ambaFWUtil = this.ambaFWUtil`  L269

方法（14）：
- `void handleMessage(Message msg)`  L57 @Override
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L77 @Override
- `void onCreate(Bundle savedInstanceState)`  L82 @Override
- `void onClick(View v)`  L96 @Override
    - 体内字面量："\\\n" · "onCreate: amba update fw" · "/tmp/SD0/"
- `void failure(int code)`  L111 @Override
- `void success()`  L115 @Override
    - 体内字面量："MINI1" · "====> FwUpload update fw"
- `void onFwUploadFinish(Exception e)`  L129 @Override
- `void progress(final float progress)`  L135 @Override
- `void run()`  L138 @Override
    - 体内字面量："(" · "%)\n"
- `void finish()`  L145 @Override
- `void onUserLeaveHint()`  L229 @Override
- `int getResId(String name)`  L233
    - 体内字面量："raw"
- `void onChannelEvent(int type, final Object param, String... array)`  L238 @Override
    - 体内字面量："put_file_complete" · "onChannelEvent: put start" · "onChannelEvent: put progress:"
- `void run()`  L257 @Override
    - 体内字面量："(" · "%)\n" · "onChannelEvent: put finish"
### `com.gku.actioncam.sigmastar.upgrade.firm.Ui.UpgradeSendFirmActivity$AnonymousClass3`
L153 · [class] AnonymousClass3 · implements `Runnable` · `com/gku/actioncam/sigmastar/upgrade/firm/Ui/UpgradeSendFirmActivity.java`

字段/常量（1）：
- `String str = strArrSplit[strArrSplit.length - 1]`  L160

方法（8）：
- `void run()`  L158 @Override
    - 体内字面量："/"
- `void onResult(int code)`  L169 @Override
- `void run()`  L173 @Override
- `void run()`  L183 @Override
    - 体内字面量："Failed to update firmware."
- `void run()`  L195 @Override
- `CoroutineContext get$context()`  L205 @Override
- `void resumeWith(Object r)`  L210 @Override
- `void run()`  L216 @Override
### `com.gku.actioncam.sigmastar.upgrade.firm.Ui.UpgradeVersionReadyActivity`
L22 · [class] public UpgradeVersionReadyActivity · extends `BaseActivity` · `com/gku/actioncam/sigmastar/upgrade/firm/Ui/UpgradeVersionReadyActivity.java`

字段/常量（8）：
- `ImageView centerLogo`  L23
- `View centerPoint`  L24
- `ImageView icBack`  L25
- `ImageView ivSave`  L26
- `RelativeLayout layoutTitle`  L27
- `Button sendFirm`  L28
- `Button sendFirmCancel`  L29
- `TextView updateFirmVersionText`  L30

方法（6）：
- `void onCreate(Bundle savedInstanceState)`  L34 @Override
- `void onClick(View view)`  L47 @Override
- `void onClick(View view)`  L53 @Override
- `void run()`  L60 @Override
- `void lambda$onCreate$0(View view)`  L69
    - 体内字面量："192.168.0.1" · "MINI1" · "android.settings.WIFI_SETTINGS"
- `void lambda$onCreate$1(View view)`  L80
### `com.gku.actioncam.sigmastar.upgrade.firm.Utils.AxiosGH`
L19 · [class] public AxiosGH · `com/gku/actioncam/sigmastar/upgrade/firm/Utils/AxiosGH.java`

字段/常量（7）：
- `int connectTimeout`  L20
- `String encode`  L21
- `String requestMethod`  L22
- `String serverUrl`  L23
- `boolean useCaches`  L24
- `byte[] bArr = new byte[1024]`  L147
- `Object obj2`  L163

方法（21）：
- `public AxiosGH()`  L32
- `public AxiosGH(String url, Callback callback)`  L36
- `void get(String url, Callback callback)`  L42
- `void get(String url, Map<String, Object> params, Callback callback)`  L47
- `void get(String url, Object params, Callback callback)`  L52
- `void post(String url, Callback callback)`  L57
    - 体内字面量："POST"
- `void post(String url, Map<String, Object> params, Callback callback)`  L63
    - 体内字面量："POST"
- `void post(String url, Object params, Callback callback)`  L69
    - 体内字面量："POST"
- `void init()`  L75
    - 体内字面量："GET" · "utf-8"
- `void handleData(final Map<String, Object> params, final Callback callback)`  L82
- `void handleMessage(Message msg)`  L85 @Override
- `void run()`  L92 @Override
- `void submitAllData(Map<String, Object> params, Callback callback, Handler handler)`  L99
    - 体内字面量："GET" · "POST" · "Content-Type" · "application/x-www-form-urlencoded" · "Content-Length" · "Error: response is" · "failure"
- `StringBuffer getRequestData(Map<String, Object> params, String encode)`  L131
- `String dealResponseResult(InputStream inputStream)`  L145
- `Map<String, Object> objectToMap(Object obj)`  L162
- `void setRequestMethod(String requestMethod)`  L179
- `void setUseCaches(boolean useCaches)`  L183
- `void setServerUrl(String serverUrl)`  L187
- `void setConnectTimeout(int connectTimeout)`  L191
- `void setEncode(String encode)`  L195
### `com.gku.actioncam.sigmastar.upgrade.firm.Utils.AxiosGH$Callback`
L26 · [interface] public Callback · `com/gku/actioncam/sigmastar/upgrade/firm/Utils/AxiosGH.java`

方法（2）：
- `void onFailed(String err)`  L27
- `void onSuccess(String res)`  L29
### `com.gku.actioncam.sigmastar.upgrade.firm.Utils.DownloadUtil`
L16 · [class] public DownloadUtil · `com/gku/actioncam/sigmastar/upgrade/firm/Utils/DownloadUtil.java`

字段/常量（7）：
- `String TAG = "com.gku.actioncam.sigmastar.upgrade.firm.Utils.DownloadUtil"`  L17
- `DownloadUtil downloadUtil`  L18
- `Call mCall`  L19
- `FileOutputStream fileOutputStream`  L52
- `byte[] bArr = new byte[2048]`  L54
- `InputStream inputStream = null`  L57
- `long j = 0`  L64

方法（9）：
- `DownloadUtil get()`  L30
- `private DownloadUtil()`  L37
- `void download(final String url, final String saveDir, final OnDownloadListener listener)`  L40
- `void onFailure(Call call, IOException e)`  L43 @Override
- `void onResponse(Call call, Response response)`  L51 @Override
- `String isExistDir(String saveDir)`  L149
- `String getSDCardPath()`  L157
    - 体内字面量："getSDCardPath:"
- `String getNameFromUrl(String url)`  L163
    - 体内字面量："/"
- `void cancelDownload()`  L167
### `com.gku.actioncam.sigmastar.upgrade.firm.Utils.DownloadUtil$OnDownloadListener`
L22 · [interface] public OnDownloadListener · `com/gku/actioncam/sigmastar/upgrade/firm/Utils/DownloadUtil.java`

方法（3）：
- `void onDownloadFailed()`  L23
- `void onDownloadSuccess()`  L25
- `void onDownloading(int progress)`  L27
### `com.gku.actioncam.sigmastar.upgrade.firm.Utils.UpdateVersionUtils`
L23 · [class] public UpdateVersionUtils · `com/gku/actioncam/sigmastar/upgrade/firm/Utils/UpdateVersionUtils.java`

字段/常量（6）：
- `String TAG = "UpdateVersionUtils"`  L24
- `UpdateVersionUtils instance`  L25
- `Context mContext`  L26
- `String strSubstring = strArrSplit2[1]`  L82
- `String str = "upgrade_" + strReplace`  L88
- `boolean z = false`  L104

方法（11）：
- `private UpdateVersionUtils()`  L28
- `UpdateVersionUtils getInstance(Context context)`  L31
- `String getDateByVersion(String version)`  L39
- `String getVersionString()`  L47
- `boolean compareVersion(String camVersion, String nVersion)`  L59
- `Pair<String, String> checkFwUpdate(String name, String version)`  L63
    - 体内字面量："-" · "yunqi_debug_data" · "checkFwUpdate: " · "yunqi_debug_Version" · "checkFwUpdate: " · "fw" · "yunqi_debug_list" · "checkFwUpdate: " · "yunqi_debug_mode" · "checkFwUpdate: " · "yunqi_debug_string" · "checkFwUpdate: " · "upgrade_" · "upgrade_" · "_" · "_"
- `boolean IsNeedUpdateNewVersion()`  L103
- `ArrayList<UpgradeInfoJsonMode> parseJSONWithGSON(String jsonData)`  L122
- `String get(Context context, int id)`  L129
- `String read(InputStream stream)`  L133
    - 体内字面量："utf-8"
- `String read(InputStream is, String encode)`  L137
    - 体内字面量："\n"