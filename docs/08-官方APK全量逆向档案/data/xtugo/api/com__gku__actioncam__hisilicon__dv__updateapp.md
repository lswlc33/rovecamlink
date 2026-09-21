# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.updateapp

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 6 个文件 / 11 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.updateapp.ApkInfo`
L6 · [class] public ApkInfo · `com/gku/actioncam/hisilicon/dv/updateapp/ApkInfo.java`

字段/常量（5）：
- `String TAG = "ApkInfo"`  L7
- `String chip = "<binary/metadata>"`  L8
- `String version = "<binary/metadata>"`  L9
- `String buildDate = "<binary/metadata>"`  L10
- `int i = 0`  L18

方法（1）：
- `ApkInfo getApkInfoFromName(String apkName)`  L12
    - 体内字面量：".apk" · "-"
### `com.gku.actioncam.hisilicon.dv.updateapp.DownloadActivity`
L27 · [class] public DownloadActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/updateapp/DownloadActivity.java`

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
### `com.gku.actioncam.hisilicon.dv.updateapp.DownloadActivity$ServerFileAdapter`
L123 · [class] ServerFileAdapter · extends `BaseAdapter` · `com/gku/actioncam/hisilicon/dv/updateapp/DownloadActivity.java`

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
### `com.gku.actioncam.hisilicon.dv.updateapp.DownloadActivity$ServerFileAdapter$ViewHolder`
L193 · [class] ViewHolder · `com/gku/actioncam/hisilicon/dv/updateapp/DownloadActivity.java`

字段/常量（2）：
- `Button btnDownloadFile`  L194
- `TextView textFileName`  L195
### `com.gku.actioncam.hisilicon.dv.updateapp.FirmwareInfo`
L8 · [class] public FirmwareInfo · `com/gku/actioncam/hisilicon/dv/updateapp/FirmwareInfo.java`

字段/常量（8）：
- `String TAG = "FirmwareInfo"`  L9
- `String chip = "<binary/metadata>"`  L10
- `String sensor = "<binary/metadata>"`  L11
- `String OS = "<binary/metadata>"`  L12
- `String hardwareFeature = "<binary/metadata>"`  L13
- `String firmwareVersion = "<binary/metadata>"`  L14
- `String buildDate = "<binary/metadata>"`  L15
- `int i = 0`  L40

方法（3）：
- `void parseOldFirmwareInfo(String softVersion, FirmwareInfo firmwareInfo)`  L17
    - 体内字面量：".sw" · "HiCam" · "V1" · "mn34220" · "V2" · "imx117" · "_T" · "20"
- `void parseNewFirmwareInfo(String packageName, FirmwareInfo firmwareInfo)`  L33
    - 体内字面量：".sw" · "parseNewFirmwareInfo() packageName is wrong."
- `FirmwareInfo getInstanceFromDeviceAttr(Common.DeviceAttr deviceAttr)`  L64
    - 体内字面量："deviceAttr is null or deviceAttr.softVersion is null" · "_"
### `com.gku.actioncam.hisilicon.dv.updateapp.UpdateInforJsonMode`
L7 · [class] public UpdateInforJsonMode · implements `Parcelable` · `com/gku/actioncam/hisilicon/dv/updateapp/UpdateInforJsonMode.java`

字段/常量（3）：
- `String devicename`  L21
- `String sourcename`  L22
- `String version`  L23

方法（14）：
- `UpdateInforJsonMode createFromParcel(Parcel source)`  L11 @Override
- `UpdateInforJsonMode[] newArray(int size)`  L17 @Override
- `int describeContents()`  L26 @Override
- `public UpdateInforJsonMode(String devicename, String version, String sourcename)`  L30
- `String getDevicename()`  L36
- `void setDevicename(String devicename)`  L40
- `String getVersion()`  L44
- `void setVersion(String version)`  L48
- `String getSourcename()`  L52
- `void setSourcename(String sourcename)`  L56
- `Parcelable.Creator<UpdateInforJsonMode> getCREATOR()`  L60
- `void writeToParcel(Parcel dest, int flags)`  L65 @Override
- `public UpdateInforJsonMode()`  L71
- `protected UpdateInforJsonMode(Parcel in)`  L74
### `com.gku.actioncam.hisilicon.dv.updateapp.UpgradeFirmwareActivity`
L27 · [class] public UpgradeFirmwareActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/updateapp/UpgradeFirmwareActivity.java`

字段/常量（9）：
- `int MSG_UPLOAD_CANCELED = 10004`  L28
- `int MSG_UPLOAD_FAILED = 10003`  L29
- `int MSG_UPLOAD_PROGRESS = 10001`  L30
- `int MSG_UPLOAD_SUCCESS = 10002`  L31
- `String TAG = "UpgradeFirmwareActivity"`  L32
- `ListView listViewPackage`  L33
- `String[] packages`  L34
- `ProgressDialog progressDialog`  L35
- `UpgradeManager upgradeManager`  L36

方法（9）：
- `void handleMessage(Message msg)`  L39 @Override
- `void onUploading(int total, int progress)`  L62 @Override
- `void onUploadSuccess()`  L71 @Override
- `void onUploadFailed()`  L78 @Override
- `void onUploadCanceled()`  L85 @Override
- `void onCreate(Bundle savedInstanceState)`  L93 @Override
- `void onClick(DialogInterface dialog, int whichButton)`  L112 @Override
- `void onStart()`  L119 @Override
- `void onStop()`  L128 @Override
### `com.gku.actioncam.hisilicon.dv.updateapp.UpgradeFirmwareActivity$LocalFirmwareAdapter`
L132 · [class] LocalFirmwareAdapter · extends `BaseAdapter` · `com/gku/actioncam/hisilicon/dv/updateapp/UpgradeFirmwareActivity.java`

字段/常量（4）：
- `LayoutInflater inflater`  L133
- `Context mContext`  L134
- `String[] packages`  L135
- `ViewHolder viewHolder`  L163

方法（8）：
- `long getItemId(int position)`  L138 @Override
- `public LocalFirmwareAdapter(Context context)`  L142
- `void setDataSource(String[] data)`  L147
- `int getCount()`  L152 @Override
- `Object getItem(int position)`  L157 @Override
- `View getView(final int position, View convertView, ViewGroup parent)`  L162 @Override
- `void onClick(View v)`  L177 @Override
- `void run()`  L182 @Override
### `com.gku.actioncam.hisilicon.dv.updateapp.UpgradeFirmwareActivity$LocalFirmwareAdapter$ViewHolder`
L191 · [class] ViewHolder · `com/gku/actioncam/hisilicon/dv/updateapp/UpgradeFirmwareActivity.java`

字段/常量（2）：
- `Button btnUpgradeFirmware`  L192
- `TextView textFirmwareName`  L193
### `com.gku.actioncam.hisilicon.dv.updateapp.UpgradeManager`
L34 · [class] public UpgradeManager · `com/gku/actioncam/hisilicon/dv/updateapp/UpgradeManager.java`

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
### `com.gku.actioncam.hisilicon.dv.updateapp.UpgradeManager$UploadListener`
L41 · [interface] public UploadListener · `com/gku/actioncam/hisilicon/dv/updateapp/UpgradeManager.java`

方法（4）：
- `void onUploadCanceled()`  L42
- `void onUploadFailed()`  L44
- `void onUploadSuccess()`  L46
- `void onUploading(int total, int progress)`  L48