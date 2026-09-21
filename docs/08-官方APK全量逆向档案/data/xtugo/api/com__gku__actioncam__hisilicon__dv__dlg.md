# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.dlg

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 9 个文件 / 12 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.dlg.ConfirmForActivity`
L11 · [class] public ConfirmForActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/dlg/ConfirmForActivity.java`

字段/常量（2）：
- `Button btnCancel`  L12
- `Button btnOK`  L13

方法（5）：
- `void onCreate(Bundle savedInstanceState)`  L16 @Override
- `void onClick(View view)`  L22 @Override
- `void onClick(View view)`  L28 @Override
- `void setResultForActivity(boolean bConfirm)`  L36
    - 体内字面量："dlgType" · "oprateType"
- `void findView()`  L43
### `com.gku.actioncam.hisilicon.dv.dlg.CustomDialog`
L20 · [class] public CustomDialog · extends `Dialog` · `com/gku/actioncam/hisilicon/dv/dlg/CustomDialog.java`

方法（2）：
- `public CustomDialog(Context context)`  L21
- `public CustomDialog(Context context, int theme)`  L25
### `com.gku.actioncam.hisilicon.dv.dlg.CustomDialog$Builder`
L29 · [class] public static Builder · `com/gku/actioncam/hisilicon/dv/dlg/CustomDialog.java`

字段/常量（14）：
- `Context context`  L30
- `int curSelected = -1`  L31
- `boolean isDoubleButton = false`  L32
- `AdapterView.OnItemClickListener itemClickListener`  L33
- `DialogInterface.OnClickListener mNegativeButtonClickListener`  L34
- `String mNegativeButtonText`  L35
- `DialogInterface.OnClickListener mPositiveButtonClickListener`  L36
- `String mPositiveButtonText`  L37
- `String message`  L38
- `CharSequence[] strEnters`  L39
- `String title`  L40
- `Button button`  L106
- `CharSequence[] charSequenceArr = this.strEnters`  L148
- `int length = charSequenceArr.length`  L150

方法（16）：
- `Builder setContentView(View v)`  L42
- `public Builder(Context context)`  L46
- `Builder setMessage(String message)`  L50
- `Builder setCurSelected(int curSelected)`  L55
- `Builder setMessage(int message)`  L60
- `Builder setTitle(int title)`  L65
- `Builder setTitle(String title)`  L70
- `Builder setEntres(CharSequence[] entres, AdapterView.OnItemClickListener listener)`  L75
- `Builder setNegativeButton(String negativeButtonText, DialogInterface.OnClickListener listener)`  L81
- `Builder setNegativeButton(int negativeText, DialogInterface.OnClickListener listener)`  L87
- `Builder setPositiveButton(String positiveText, DialogInterface.OnClickListener listener)`  L93
- `Builder setPositiveButton(int positiveText, DialogInterface.OnClickListener listener)`  L99
- `CustomDialog create()`  L105
- `void onClick(View v)`  L116 @Override
- `void onClick(View v)`  L133 @Override
- `void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)`  L168 @Override
### `com.gku.actioncam.hisilicon.dv.dlg.CustomDialogStr`
L22 · [class] public CustomDialogStr · extends `Dialog` · `com/gku/actioncam/hisilicon/dv/dlg/CustomDialogStr.java`

方法（2）：
- `public CustomDialogStr(Context context)`  L23
- `public CustomDialogStr(Context context, int theme)`  L27
### `com.gku.actioncam.hisilicon.dv.dlg.CustomDialogStr$Builder`
L31 · [class] public static Builder · `com/gku/actioncam/hisilicon/dv/dlg/CustomDialogStr.java`

字段/常量（14）：
- `Context context`  L32
- `String curSelected = "<binary/metadata>"`  L33
- `boolean isDoubleButton = false`  L34
- `AdapterView.OnItemClickListener itemClickListener`  L35
- `DialogInterface.OnClickListener mNegativeButtonClickListener`  L36
- `String mNegativeButtonText`  L37
- `DialogInterface.OnClickListener mPositiveButtonClickListener`  L38
- `String mPositiveButtonText`  L39
- `String message`  L40
- `String[] strEnters`  L41
- `String title`  L42
- `Button button`  L108
- `String[] strArr = this.strEnters`  L151
- `int length = strArr.length`  L153

方法（16）：
- `Builder setContentView(View v)`  L44
- `public Builder(Context context)`  L48
- `Builder setMessage(String message)`  L52
- `Builder setCurSelected(String curSelected)`  L57
- `Builder setMessage(int message)`  L62
- `Builder setTitle(int title)`  L67
- `Builder setTitle(String title)`  L72
- `Builder setEntres(String[] entres, AdapterView.OnItemClickListener listener)`  L77
- `Builder setNegativeButton(String negativeButtonText, DialogInterface.OnClickListener listener)`  L83
- `Builder setNegativeButton(int negativeText, DialogInterface.OnClickListener listener)`  L89
- `Builder setPositiveButton(String positiveText, DialogInterface.OnClickListener listener)`  L95
- `Builder setPositiveButton(int positiveText, DialogInterface.OnClickListener listener)`  L101
- `CustomDialogStr create()`  L107
- `void onClick(View v)`  L119 @Override
- `void onClick(View v)`  L136 @Override
- `void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)`  L171 @Override
### `com.gku.actioncam.hisilicon.dv.dlg.DlgForDeleteProcessActivity`
L47 · [class] public DlgForDeleteProcessActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/dlg/DlgForDeleteProcessActivity.java`

字段/常量（64）：
- `int DELETE_FINISH = 1`  L48
- `int DELETE_PROCESS = 0`  L49
- `int DOWNLOAD_CANCEL = 3`  L50
- `int DOWNLOAD_FINISH = 2`  L51
- `int DOWNLOAD_PROCESS = 5`  L52
- `int DOWNLOAD_TOTAL_PROCESS = 4`  L53
- `String TAG = "DlgForProcessActivity"`  L54
- `boolean IsHeigh`  L55
- `boolean IsSocket`  L56
- `Button btnCancel`  L57
- `TextView download_progress_text`  L58
- `String largeLocalPath`  L59
- `ProgressBar mDownloadProcess`  L60
- `ArrayList<Integer> mListID`  L61
- `ArrayList<String> mListStrPath`  L62
- `OnDownListener mOnDownListenerListener`  L63
- `int mOption`  L64
- `int mProgressType`  L65
- `int mRenameCount`  L66
- `String strSSID`  L67
- `TextView tvMessage`  L68
- `TextView tvTitle`  L69
- `boolean bDeleteSuccess = false`  L71
- `boolean bUndoOperate = false`  L72
- `int nSuccess = 0`  L74
- `int nDownload = 0`  L75
- `Message message = null`  L76
- `String str`  L80
- `int i = msg.what`  L81
- `DlgForDeleteProcessActivity dlgForDeleteProcessActivity = DlgForDeleteProcessActivity.this`  L99
- `int i = this.mProgressType`  L190
- `String str3`  L372
- `long size`  L373
- `?? bufferedOutputStream`  L374
- `Throwable th`  L375
- `?? r5`  L376
- `?? r8`  L377
- `?? r6`  L378
- `?? r11`  L379
- `?? r9`  L380
- `?? r7`  L381
- `long j`  L382
- `?? r22`  L383
- `OnDownListener onDownListener`  L384
- `int i2 = 0`  L391
- `String strReplace = str3 + strSubstring`  L396
- `DlgForDeleteProcessActivity dlgForDeleteProcessActivity = DlgForDeleteProcessActivity.this`  L435
- `?? bufferedInputStream = "downloadImage: "`  L447
- `?? r10 = "downloadImage: " + str`  L448
- `byte[] bArr = new byte[2048]`  L466
- `OnDownListener onDownListener2 = this.mOnDownListenerListener`  L474
- `long j2 = j`  L518
- `long j3 = j2`  L519
- `?? r23 = bufferedInputStream`  L529
- `long j5 = i4`  L534
- `OnDownListener onDownListener3 = this.mOnDownListenerListener`  L634
- `String str = LocalFileName`  L822
- `OnDownListener onDownListener = this.mOnDownListenerListener`  L845
- `int i = 0`  L854
- `String str2`  L889
- `String str3 = str`  L894
- `FileOutputStream fileOutputStream`  L933
- `FileInputStream fileInputStream = null`  L937
- `byte[] bArr = new byte[1024]`  L943

方法（20）：
- `void handleMessage(Message msg)`  L79 @Override
- `void onCreate(Bundle savedInstanceState)`  L149 @Override
- `void onClick(View v)`  L156 @Override
- `boolean exitPropram()`  L163
- `void findView()`  L178
    - 体内字面量："SSID" · "progressType" · "5213213" · "findView:  ----------TYPEæ¯---------   "
- `void StartDeleteThread()`  L212
- `void run()`  L215 @Override
    - 体内字面量："yunqi_debug" · "need delete path: "
- `void setReturnForResult(int nPathLen)`  L255
    - 体内字面量："dlgType" · "imgPathLen" · "bDeleteSuccess"
- `void setOnDownListenerListener(OnDownListener mOnDownListenerLitener)`  L264
- `void downloadImage(String str, final String str2, int i)`  L371
- `void onItemClick(float progress, File file)`  L429 @Override
- `String path_rename(String path, int n)`  L802
    - 体内字面量："/" · "_" · "/"
- `void renameFile(String LocalFileName, String strLocal, File imageFile)`  L815
- `long getContentSize(HttpURLConnection conn)`  L853
- `void startDownlaod()`  L867
- `void run()`  L870 @Override
- `void downloadFile(final int n)`  L878
    - 体内字面量："yingxinquan123456" · "downloadImage: ----------------------   å¼å§ä¸è½½    "
- `void onListener(boolean sucess)`  L888 @Override
- `boolean copyFile(String oldPath, String newPath)`  L932
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L1034 @Override
### `com.gku.actioncam.hisilicon.dv.dlg.DlgForDeleteProcessActivity$OnDownListener`
L144 · [interface] public OnDownListener · `com/gku/actioncam/hisilicon/dv/dlg/DlgForDeleteProcessActivity.java`

方法（1）：
- `void onListener(boolean sucess)`  L145
### `com.gku.actioncam.hisilicon.dv.dlg.DlgForProcessActivity`
L42 · [class] public DlgForProcessActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/dlg/DlgForProcessActivity.java`

字段/常量（61）：
- `int DELETE_FINISH = 1`  L43
- `int DELETE_PROCESS = 0`  L44
- `int DOWNLOAD_CANCEL = 3`  L45
- `int DOWNLOAD_FINISH = 2`  L46
- `int DOWNLOAD_PROCESS = 5`  L47
- `int DOWNLOAD_TOTAL_PROCESS = 4`  L48
- `String TAG = "DlgForProcessActivity"`  L49
- `boolean IsHeigh`  L50
- `Button btnCancel`  L51
- `ProgressBar mDownloadProcess`  L52
- `ArrayList<Integer> mListID`  L53
- `ArrayList<HiDefine.PathConnection> mListStrPathPathConnection`  L54
- `int mOption`  L55
- `int mProgressType`  L56
- `int mRenameCount`  L57
- `String strSSID`  L58
- `TextView tvMessage`  L59
- `TextView tvTitle`  L60
- `boolean bDeleteSuccess = false`  L62
- `boolean bUndoOperate = false`  L63
- `long MaxSize = IjkMediaMeta.AV_CH_WIDE_LEFT`  L64
- `String str`  L68
- `int i = msg.what`  L69
- `DlgForProcessActivity dlgForProcessActivity = DlgForProcessActivity.this`  L87
- `int i = this.mProgressType`  L151
- `Throwable th`  L256
- `?? r4`  L257
- `HttpURLConnection httpURLConnection`  L258
- `long j`  L259
- `File file`  L260
- `BufferedOutputStream bufferedOutputStream`  L261
- `BufferedInputStream bufferedInputStream`  L262
- `String str3`  L263
- `long contentSize`  L264
- `long j2`  L265
- `long j3`  L266
- `?? r25`  L267
- `int i`  L268
- `int i2`  L269
- `int i3`  L270
- `String str4 = "downloadImage:  ----------111---------  "`  L271
- `BufferedInputStream bufferedInputStream2 = null`  L274
- `int i4 = 0`  L277
- `int i5 = 0`  L283
- `String strReplace = str5 + strSubstring`  L289
- `String str6 = strReplace + ".TMP"`  L316
- `byte[] bArr = new byte[2048]`  L322
- `long j4 = 0`  L346
- `long j5 = 0`  L347
- `int i7 = i4`  L358
- `long j6 = i8`  L363
- `?? r7 = r25`  L527
- `int i = 0`  L882
- `String str`  L899
- `int i = 0`  L900
- `int i2 = 0`  L901
- `int i3 = 0`  L902
- `int i4 = i + 1`  L906
- `FileOutputStream fileOutputStream`  L954
- `FileInputStream fileInputStream = null`  L958
- `byte[] bArr = new byte[1024]`  L964

方法（15）：
- `void handleMessage(Message msg)`  L67 @Override
- `void onCreate(Bundle savedInstanceState)`  L117 @Override
- `void onClick(View v)`  L124 @Override
- `boolean exitPropram()`  L131
- `void findView()`  L140
    - 体内字面量："selectList" · "SSID" · "progressType" · "453412311" · "findView:  ----------TYPEæ¯---------   "
- `void StartDeleteThread()`  L172
- `void run()`  L175 @Override
- `void setReturnForResult(int nPathLen)`  L213
    - 体内字面量："dlgType" · "imgPathLen" · "bDeleteSuccess"
- `boolean downloadImage(String str, String str2)`  L255
- `boolean downloadImagePathConnection(com.gku.actioncam.hisilicon.dv.biz.HiDefine.PathConnection r23, java.lang.String r24)`  L873
    - 体内字面量："Method not decompiled: com.gku.actioncam.hisilicon.dv.dlg.DlgForProcessActivity.downloadImagePathConnection(com.gku.actioncam.hisilicon.dv.biz.HiDefine$PathConnection, java.lang.String):boolean"
- `long getContentSize(HttpURLConnection conn)`  L881
- `void startDownlaod()`  L895
- `void run()`  L898 @Override
- `boolean copyFile(String oldPath, String newPath)`  L953
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L1055 @Override
### `com.gku.actioncam.hisilicon.dv.dlg.DownloadExceptionActivity`
L13 · [class] public DownloadExceptionActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/dlg/DownloadExceptionActivity.java`

字段/常量（8）：
- `TextView btOK`  L14
- `LinearLayout btReload`  L15
- `LinearLayout btRename`  L16
- `TextView btSkip`  L17
- `int mOption = 1`  L18
- `RadioButton rbReload`  L19
- `RadioButton rbRename`  L20
- `TextView tvContent`  L21

方法（9）：
- `void onCreate(Bundle savedInstanceState)`  L24 @Override
    - 体内字面量："SameFileCount"
- `void onClick(View v)`  L32 @Override
- `void onClick(View v)`  L42 @Override
- `void onClick(View v)`  L51 @Override
- `void onClick(View v)`  L59 @Override
- `void initView()`  L66
- `void setReturnForResult()`  L77
    - 体内字面量："dlgType" · "Option"
- `void onRestoreInstanceState(Bundle savedInstanceState)`  L85 @Override
    - 体内字面量："mOption"
- `void onSaveInstanceState(Bundle outState)`  L91 @Override
    - 体内字面量："mOption"
### `com.gku.actioncam.hisilicon.dv.dlg.FileInfoActivity`
L12 · [class] public FileInfoActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/dlg/FileInfoActivity.java`

字段/常量（1）：
- `Button btnCancel`  L13

方法（4）：
- `void onCreate(Bundle savedInstanceState)`  L16 @Override
- `void initView()`  L23
    - 体内字面量："Filename" · "FileSize" · "ModifyTime" · "StoragePath"
- `void SetCancelClickListener()`  L33
- `void onClick(View v)`  L36 @Override
### `com.gku.actioncam.hisilicon.dv.dlg.PopupWinforPreviewActivity`
L16 · [class] public PopupWinforPreviewActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/dlg/PopupWinforPreviewActivity.java`

字段/常量（13）：
- `Button btnPopupUndo`  L17
- `LinearLayout linePopupDelete`  L18
- `LinearLayout linePopupDownload`  L19
- `LinearLayout linePopupEdit`  L20
- `LinearLayout linePopupFileInfo`  L21
- `LinearLayout linePopupPush`  L22
- `LinearLayout linePopupShare`  L23
- `TextView tvPopupTitle`  L24
- `String strFileName = null`  L25
- `boolean bDownloadVisiable = false`  L26
- `boolean bShareVisiable = false`  L27
- `boolean bPushVisiable = false`  L28
- `String str = this.strFileName`  L115

方法（11）：
- `void onCreate(Bundle savedInstanceState)`  L31 @Override
    - 体内字面量："OriFileName" · "LRV" · "LRV" · "MP4" · "bDownloadVisiable" · "bShareVisiable" · "bPushVisiable"
- `void onClick(View v)`  L46 @Override
- `void onClick(View v)`  L53 @Override
- `void onClick(View v)`  L60 @Override
- `void onClick(View v)`  L67 @Override
- `void onClick(View v)`  L74 @Override
- `void onClick(View v)`  L81 @Override
- `void onClick(View v)`  L88 @Override
- `void onResume()`  L96 @Override
- `void findView()`  L105
- `void setResultForActivity(int nTypeOperate)`  L132
    - 体内字面量："dlgType" · "oprateType"
### `com.gku.actioncam.hisilicon.dv.dlg.Wifipasswdinputfrag`
L19 · [class] public Wifipasswdinputfrag · extends `DialogFragment` · `com/gku/actioncam/hisilicon/dv/dlg/Wifipasswdinputfrag.java`

字段/常量（3）：
- `Button mBtnConnect`  L20
- `EditText mEtPasswd`  L21
- `Handler mHandler`  L22

方法（9）：
- `Wifipasswdinputfrag newInstance(String strSSID)`  L24
    - 体内字面量："SSID"
- `void setHandler(Handler handler)`  L32
- `Dialog onCreateDialog(Bundle savedInstanceState)`  L37 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L45 @Override
- `void onClick(View arg0)`  L54 @Override
- `void afterTextChanged(Editable s)`  L60 @Override
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L64 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L68 @Override
- `void onClick(View arg0)`  L78 @Override
    - 体内字面量："SSID"