# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.filebrowser

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 8 个文件 / 21 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.filebrowser.Hi3518PriviewImageActivity`
L61 · [class] public Hi3518PriviewImageActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/filebrowser/Hi3518PriviewImageActivity.java`

字段/常量（69）：
- `String TAG = "BH01PriviewImageActvity"`  L62
- `int TIME_REFRESH_DELAY = 350`  L63
- `int WHAT_REFRESH_DELAY = 922`  L64
- `Button btnConfirm`  L66
- `Button btnUndo`  L67
- `ProgressBar firstLoading`  L68
- `HiGridView hiGridView`  L69
- `ImageView ivModeMenu`  L70
- `View layoutBack`  L71
- `LinearLayout lineDelete`  L72
- `LinearLayout lineDownload`  L73
- `LinearLayout lineFileInfo`  L74
- `LinearLayout lineShare`  L75
- `View loadingView`  L76
- `int mFirstVisibleItem`  L77
- `GetLocalPath mGetLocalPath`  L78
- `ImageAdapter mImgAdapter`  L79
- `int mLastFirstVisibleItem`  L80
- `int mLastVisibleItemCount`  L81
- `SdcardReceiver mSdcardReceiver`  L82
- `int mVisibleItemCount`  L83
- `WifiDisconnectReceiver mWifiDisReceiver`  L84
- `PopupWindow preViewWindow`  L85
- `RefreshHeadView refreshHeadView`  L86
- `TextView tvSelectAll`  L87
- `TextView tvTitle`  L88
- `View vLeftMargin`  L89
- `View vRightMargin`  L90
- `int MAX_VISIBLE_COUNT = 20`  L91
- `int mFilebrowserType = 0`  L94
- `int operType = 0`  L95
- `boolean bSelectAll = false`  L96
- `int nSelectCount = 0`  L99
- `String mStrSSID = null`  L100
- `int mLongPressPos = -1`  L101
- `boolean isRefresh = true`  L102
- `boolean bLoadOnce = false`  L103
- `boolean isGridClickEnable = true`  L104
- `int mEvent = -1`  L105
- `int shareType = 0`  L106
- `int i = msg.arg1`  L111
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity = Hi3518PriviewImageActivity.this`  L117
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity2 = Hi3518PriviewImageActivity.this`  L120
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity3 = Hi3518PriviewImageActivity.this`  L135
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity4 = Hi3518PriviewImageActivity.this`  L138
- `boolean enableClickSeg = false`  L148
- `int MAX_FRESH_COUNT = 3`  L150
- `int mFreshCount = 0`  L151
- `int i = msg.what`  L155
- `int i2 = Hi3518PriviewImageActivity.this.mEvent`  L174
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity = Hi3518PriviewImageActivity.this`  L255
- `boolean z`  L287
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity = Hi3518PriviewImageActivity.this`  L295
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity2 = Hi3518PriviewImageActivity.this`  L297
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity = Hi3518PriviewImageActivity.this`  L449
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity2 = Hi3518PriviewImageActivity.this`  L454
- `ArrayList<HiDefine.PathConnection> arrayList = this.mFilelistManager.mstrDVListFileForUI`  L477
- `int i = this.operType`  L539
- `int i2 = this.operType`  L554
- `int i = HiDefine.FILEBROESER_TYPE_DV`  L571
- `ArrayList<HiDefine.PathConnection> arrayList = this.listPathCon`  L593
- `SdcardReceiver sdcardReceiver = this.mSdcardReceiver`  L628
- `Bundle extras`  L732
- `int i = 0`  L765
- `ArrayList<HiDefine.PathConnection> arrayList = this.mFilelistManager.mstrDVListFileForUI`  L835
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity = Hi3518PriviewImageActivity.this`  L910
- `WifiDisconnectReceiver wifiDisconnectReceiver = this.mWifiDisReceiver`  L944
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity`  L1041
- `int i = this.operType`  L1050

方法（65）：
- `void handleMessage(Message msg)`  L109 @Override
- `void handleMessage(Message msg)`  L154 @Override
- `void run()`  L193 @Override
- `boolean lambda$enableClick$1(boolean z, View view, MotionEvent motionEvent)`  L213
- `boolean lambda$enableClick$2(boolean z, View view, MotionEvent motionEvent)`  L217
- `void onCreate(Bundle savedInstanceState)`  L222 @Override
    - 体内字面量："yunqi_debug" · "onCreate: BH01PriviewImageActivity" · "filebrowserType"
- `void onRemoveBitmap(int position)`  L240 @Override
    - 体内字面量："453412311111" · "onRemoveBitmap:--------------------------------      åå¼ å é¤"
- `void onRemoveAllBitmap()`  L246 @Override
- `void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)`  L252 @Override
- `void onScrollStateChanged(AbsListView view, int nScrollState)`  L286 @Override
- `void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)`  L319 @Override
- `boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)`  L343 @Override
    - 体内字面量："785453" · "onItemLongClick: ----------------   " · "OriFileName" · "bDownloadVisiable" · "bShareVisiable" · "bPushVisiable" · "bPushVisiable"
- `boolean OnTouchEvent(MotionEvent event)`  L365 @Override
- `void onClick(View v)`  L377 @Override
- `void onClick(View v)`  L383 @Override
- `void onClick(View v)`  L393 @Override
    - 体内字面量："78798787867876" · "onClick:  -------------------   " · "78798787867876" · "onClick:  ------111111-------------   "
- `void onClick(View v)`  L405 @Override
- `void onClick(View v)`  L415 @Override
- `void onClick(View v)`  L421 @Override
- `void onClick(View v)`  L427 @Override
- `void onClick(View v)`  L440 @Override
- `void onClick(View v)`  L446 @Override
- `void startLoad()`  L468 @Override
- `void loadDone()`  L473 @Override
- `void firstLoadThumb()`  L523
- `void onDvDisconnectionEvent(DvDisconnectionEvent event)`  L531 @Subscribe(threadMode = ThreadMode.MAIN)
- `void updateConfirmText()`  L536
    - 体内字面量："7894654222777" · "onClick:  ---------------------------    7"
- `void onStart()`  L569 @Override
- `void onResume()`  L584 @Override
    - 体内字面量："7894654222777" · "startImageDetail:  ----------è¿åæ¥çæ¶ååè¡¨ä¸ªæ°æ¯---------   "
- `void startLoad()`  L602 @Override
- `void loadDone()`  L607 @Override
    - 体内字面量："7894654222777" · "startImageDetail:  --------22222--è¿åæ¥çæ¶ååè¡¨ä¸ªæ°æ¯---------   "
- `void onStop()`  L624 @Override
- `void findView()`  L636
- `void loading(final boolean isLoading)`  L665
- `void run()`  L668 @Override
- `void lambda$loading$0(boolean z)`  L676
- `void enableClick(final boolean enableAllViewClick)`  L686
- `boolean onTouch(View view, MotionEvent motionEvent)`  L689 @Override
- `boolean onTouch(View view, MotionEvent motionEvent)`  L695 @Override
- `boolean onTouchEvent(MotionEvent event)`  L702 @Override
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L710 @Override
- `void onDestroy()`  L723 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L731 @Override
- `void processSwitchImage(Bundle MarsBuddle)`  L761
    - 体内字面量："isDeletefile" · "imgPathLen" · "imgPath"
- `void processPopupForWin(Bundle MarsBuddle)`  L781
    - 体内字面量："oprateType"
- `void processDeleteFresh(Bundle MarsBuddle)`  L814
    - 体内字面量："453412311" · "processDeleteFresh:  --------------------  "
- `void startLoad()`  L826 @Override
- `void loadDone()`  L831 @Override
- `void processDownloadOption(Bundle MarsBuddle)`  L843
    - 体内字面量："Option"
- `void processDeleteConfirm(Bundle MarsBuddle)`  L847
    - 体内字面量："oprateType" · "453412311" · "processDeleteConfirm:  --------------------------  DV ç¸æºåçå é¤" · "453412311" · "processDeleteConfirm:  ------FILEBROESER_TYPE_DV--------   éé¿æå é¤" · "453412311" · "processDeleteConfirm:  -------FILEBROESER_TYPE_DV-------   é¿æå é¤" · "453412311" · "processDeleteConfirm:  -------------------   åå¤å¼å§å é¤ç§ç" · "85265211111" · "processDeleteConfirm:  --------------   éé¿æå é¤" · "85265211111" · "processDeleteConfirm:  --------------   é¿æå é¤" · " delete failed"
- `void starListenWifi()`  L891
- `void onWifiStateChanged(NetworkInfo.DetailedState detailedState)`  L897 @Override
    - 体内字面量："detailedState"
- `void stopLislenWifi()`  L943
- `void showMenu()`  L953
    - 体内字面量："showMenu"
- `void photoOrDVswitch()`  L967
- `void menuDelete()`  L978
- `void menuShare()`  L994
- `void menuDownload()`  L1010
- `void UndoOperate()`  L1026
- `void doOperate()`  L1040
- `void startImageDetail(String strUrl, int position)`  L1087
    - 体内字面量："7894654222777" · "startImageDetail: ---------------------   æ­æ¾:" · "dng" · "7894654222777" · "onCreate:  ----------------  ä¼ éæ­æ¾å°å  " · "MP4" · "7894654222777" · "startImageDetail: ----------------------   MP4" · "android.intent.action.VIEW" · "7894654222777" · "startImageDetail:  ----------11111---------   " · "7894654222777" · "onCreate:  ----------è·³è½¬----LRV-------  æ­æ¾è§é¢" · "7894654222777" · "startImageDetail:  ----------11111---------   " · "start" · "CurIndex" · "PathNum" · "ShareType" · "wifiSSID"
- `void setTitile()`  L1147
    - 体内字面量："setTitileaa: AAAAAA  1"
- `void onMessageEvent(MessageEvent MessageEvent)`  L1157 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："66656565655665" · "onMessageEvent:  ----------PIA-----------   å·æ°" · "45453435132" · "onMessageEvent:  --------------------   æ¶å°å·æ°é¡µé¢æ¶æ¯     "
- `void startLoad()`  L1167 @Override
- `void loadDone()`  L1172 @Override
    - 体内字面量："avbngscvx" · "downloadImage:  --------------  æ¶å°åéSDå¡æ»¡æ¶æ¯"
### `com.gku.actioncam.hisilicon.dv.filebrowser.Hi3518PriviewImageActivity$AnonymousClass23`
L926 · [class] static AnonymousClass23 · `com/gku/actioncam/hisilicon/dv/filebrowser/Hi3518PriviewImageActivity.java`

字段/常量（1）：
- `int[] $SwitchMap$android$net$NetworkInfo$DetailedState`  L927
### `com.gku.actioncam.hisilicon.dv.filebrowser.Hi3518PriviewImageActivity$AnonymousClass6`
L484 · [class] AnonymousClass6 · implements `RefreshHeadView.PullToRefreshListener` · `com/gku/actioncam/hisilicon/dv/filebrowser/Hi3518PriviewImageActivity.java`

字段/常量（1）：
- `Hi3518PriviewImageActivity hi3518PriviewImageActivity = Hi3518PriviewImageActivity.this`  L514

方法（5）：
- `void onRefresh()`  L489 @Override
- `void run()`  L492 @Override
- `void lambda$onRefresh$0()`  L500
- `void startLoad()`  L505 @Override
- `void loadDone()`  L510 @Override
### `com.gku.actioncam.hisilicon.dv.filebrowser.Hi3518PriviewImageActivity$SdcardReceiver`
L1129 · [class] SdcardReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/hisilicon/dv/filebrowser/Hi3518PriviewImageActivity.java`

方法（1）：
- `void onReceive(Context context, Intent intent)`  L1134 @Override
    - 体内字面量："event" · "event:"
### `com.gku.actioncam.hisilicon.dv.filebrowser.HiGridView`
L9 · [class] public HiGridView · extends `GridView` · `com/gku/actioncam/hisilicon/dv/filebrowser/HiGridView.java`

字段/常量（7）：
- `int MOVE_EVENT_DOWN = 0`  L10
- `int MOVE_EVENT_UP = 1`  L11
- `int mCurStatus`  L12
- `OnTouchEventListen mOntouchListener`  L13
- `OnTouchEventListen onTouchEventListen`  L29
- `OnTouchEventListen onTouchEventListen2`  L30
- `OnTouchEventListen onTouchEventListen3 = this.mOntouchListener`  L45

方法（4）：
- `public HiGridView(Context context, AttributeSet attrs)`  L19
- `void setOnToulisten(OnTouchEventListen onTouchLisenter)`  L24
- `boolean startOnTouch(MotionEvent ev)`  L28
- `boolean dispatchTouchEvent(MotionEvent ev)`  L54 @Override
### `com.gku.actioncam.hisilicon.dv.filebrowser.HiGridView$OnTouchEventListen`
L15 · [interface] public OnTouchEventListen · `com/gku/actioncam/hisilicon/dv/filebrowser/HiGridView.java`

方法（1）：
- `boolean OnTouchEvent(MotionEvent event)`  L16
### `com.gku.actioncam.hisilicon.dv.filebrowser.HiImageView`
L10 · [class] public HiImageView · extends `AppCompatImageView` · `com/gku/actioncam/hisilicon/dv/filebrowser/HiImageView.java`

字段/常量（1）：
- `String TAG = "HiImageView"`  L11

方法（3）：
- `public HiImageView(Context context)`  L13
- `public HiImageView(Context context, AttributeSet attrs)`  L17
- `void onDraw(Canvas canvas)`  L22 @Override
    - 体内字面量："trying to use a recycled bitmap"
### `com.gku.actioncam.hisilicon.dv.filebrowser.ImageAdapter`
L37 · [class] public ImageAdapter · extends `ArrayAdapter<HiDefine.PathConnection>` · `com/gku/actioncam/hisilicon/dv/filebrowser/ImageAdapter.java`

字段/常量（21）：
- `int IMAGE_WIDTH_HEIGHT = 85`  L38
- `int SELECT_X_POS = 2`  L39
- `int SELECT_Y_POS = 2`  L40
- `String TAG = "ImageAdapter"`  L41
- `int TIME_TEXT_SIZE = 7`  L42
- `boolean bClearShow`  L43
- `ImageLoader imgLoader`  L44
- `Context mContext`  L45
- `DisplayMetrics mDispalyMetrix`  L46
- `GetLocalPath mGetLocalPath`  L47
- `List<HiDefine.PathConnection> mPathConList`  L48
- `Set<LoadImageTask> taskCollection`  L49
- `int i`  L78
- `List<HiDefine.PathConnection> list = this.mPathConList`  L82
- `String str = pathConnection.strPath`  L91
- `List<HiDefine.PathConnection> list = this.mPathConList`  L130
- `List<HiDefine.PathConnection> list = this.mPathConList`  L140
- `List<HiDefine.PathConnection> list = this.mPathConList`  L211
- `List<HiDefine.PathConnection> list = this.mPathConList`  L254
- `int size = nCountItem + nFirstItem`  L259
- `Set<LoadImageTask> set = this.taskCollection`  L273

方法（14）：
- `public ImageAdapter(Context context, int resource, List<HiDefine.PathConnection> objects)`  L51
- `void setFileList(List<HiDefine.PathConnection> objects)`  L65
- `void release()`  L72
- `View getView(int position, View convertView, ViewGroup parent)`  L77 @Override
- `int getCount()`  L129 @Override
- `long getItemId(int position)`  L138 @Override
- `View addImage()`  L148
- `void startTask(View imgView, int nPosition)`  L207
- `void setClearShow(boolean bClearShow)`  L225
    - 体内字面量："453412311111" · "setClearShow:  ----------------------    "
- `void updateSSID()`  L235
- `void setClearShowNotFresh(boolean bClearShow)`  L239
- `void removeBitmap(List<String> listStrPath)`  L243
- `void clearAllBitmap(int nFirstItem, int nCountItem)`  L252
- `void cancelAllTasks()`  L272
### `com.gku.actioncam.hisilicon.dv.filebrowser.ImageAdapter$LoadImageTask`
L284 · [class] private LoadImageTask · extends `AsyncTask<String, Void, Void>` · `com/gku/actioncam/hisilicon/dv/filebrowser/ImageAdapter.java`

字段/常量（7）：
- `View mVShowlayout`  L291
- `String str = arg0[0]`  L302
- `HttpURLConnection httpURLConnection`  L327
- `BufferedOutputStream bufferedOutputStream`  L328
- `File file`  L329
- `BufferedInputStream bufferedInputStream = null`  L347
- `byte[] bArr = new byte[1024]`  L364

方法（5）：
- `void handleMessage(Message msg)`  L287 @Override
- `public LoadImageTask(View vLayout)`  L293
- `Void doInBackground(String... arg0)`  L300 @Override
- `void onPostExecute(Void result)`  L311 @Override
- `void downloadImage(String imageUrl)`  L326
### `com.gku.actioncam.hisilicon.dv.filebrowser.ImageLoader`
L29 · [class] public ImageLoader · `com/gku/actioncam/hisilicon/dv/filebrowser/ImageLoader.java`

字段/常量（11）：
- `String TAG = "ImageLoader"`  L30
- `Timer timer = null`  L32
- `boolean bDecodeFinish = true`  L34
- `Bitmap bitmap`  L85
- `Timer timer = this.timer`  L119
- `int fileAttr`  L128
- `int time = 0`  L142
- `Bitmap bitmapDecodeResource = null`  L173
- `int i = options.outHeight`  L192
- `int i2 = options.outWidth / 160`  L193
- `int i3 = i / 120`  L194

方法（10）：
- `void handleMessage(Message msg)`  L37 @Override
    - 体内字面量："00" · ":"
- `int sizeOf(String key, Bitmap bitmap)`  L73 @Override
- `void addBitmapToMemoryCache(String key, Bitmap bitmap)`  L78
- `void removeBitmapMemoryCache(String key)`  L84
- `Bitmap getBitmapFromMemoryCache(String key)`  L94
- `void decodeSampledBitmapFromResource(Resources res, RelativeLayout relativeLayout)`  L101
- `void clearDecodeData()`  L112
- `void release()`  L118
- `void getImageThumbnail(Resources res, RelativeLayout relative)`  L127
- `Bitmap getVideoThumbnail(String videoPath, int width, int height)`  L247
    - 体内字面量："54645323" · "getVideoThumbnail: ----------------------   è·åç¼©ç¥å¾è·¯å¾-------   "
### `com.gku.actioncam.hisilicon.dv.filebrowser.ImageLoader$DecodeImageTimer`
L224 · [class] private DecodeImageTimer · extends `TimerTask` · `com/gku/actioncam/hisilicon/dv/filebrowser/ImageLoader.java`

字段/常量（1）：
- `Resources mRes`  L225

方法（2）：
- `public DecodeImageTimer(Resources res)`  L227
- `void run()`  L232 @Override
### `com.gku.actioncam.hisilicon.dv.filebrowser.obj.MediaModel`
L7 · [class] public MediaModel · implements `Parcelable` · `com/gku/actioncam/hisilicon/dv/filebrowser/obj/MediaModel.java`

字段/常量（4）：
- `String create`  L21
- `String path`  L22
- `long size`  L23
- `int time`  L24

方法（17）：
- `MediaModel createFromParcel(Parcel source)`  L11 @Override
- `MediaModel[] newArray(int size)`  L17 @Override
- `int describeContents()`  L27 @Override
- `public MediaModel(String path, String create, int time, long size)`  L31
- `String getPath()`  L38
- `void setPath(String path)`  L42
- `String getCreate()`  L46
- `void setCreate(String create)`  L50
- `int getTime()`  L54
- `void setTime(int time)`  L58
- `long getSize()`  L62
- `void setSize(long size)`  L66
- `Parcelable.Creator<MediaModel> getCREATOR()`  L70
- `void writeToParcel(Parcel dest, int flags)`  L75 @Override
- `public MediaModel()`  L82
- `protected MediaModel(Parcel in)`  L85
- `String toString()`  L92
    - 体内字面量："MediaModel{path='" · "', create='" · "', time=" · ", size=" · "}"
### `com.gku.actioncam.hisilicon.dv.filebrowser.PreviewImageActivity`
L64 · [class] public PreviewImageActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java`

字段/常量（64）：
- `String TAG = "PriviewImageActvity"`  L65
- `int TIME_REFRESH_DELAY = 350`  L66
- `int WHAT_REFRESH_DELAY = 922`  L67
- `Button btnConfirm`  L68
- `Button btnUndo`  L69
- `ProgressBar firstLoading`  L70
- `HiGridView hiGridView`  L71
- `ImageView ivModeMenu`  L72
- `View layoutBack`  L73
- `LinearLayout lineDelete`  L74
- `LinearLayout lineDownload`  L75
- `LinearLayout lineFileInfo`  L76
- `LinearLayout lineShare`  L77
- `View loadingView`  L78
- `int mFirstVisibleItem`  L79
- `GetLocalPath mGetLocalPath`  L80
- `ImageAdapter mImgAdapter`  L81
- `int mLastFirstVisibleItem`  L82
- `int mLastVisibleItemCount`  L83
- `SdcardReceiver mSdcardReceiver`  L84
- `int mVisibleItemCount`  L85
- `WifiDisconnectReceiver mWifiDisReceiver`  L86
- `PopupWindow preViewWindow`  L87
- `RefreshHeadView refreshHeadView`  L88
- `TextView tvSelectAll`  L89
- `TextView tvTitle`  L90
- `View vLeftMargin`  L91
- `View vRightMargin`  L92
- `int MAX_VISIBLE_COUNT = 20`  L93
- `int mFilebrowserType = 0`  L96
- `int operType = 0`  L97
- `boolean bSelectAll = false`  L98
- `int nSelectCount = 0`  L101
- `String mStrSSID = null`  L102
- `int mLongPressPos = -1`  L103
- `boolean isRefresh = true`  L104
- `boolean bLoadOnce = false`  L105
- `boolean isGridClickEnable = true`  L106
- `int mEvent = -1`  L107
- `int shareType = 0`  L108
- `boolean enableClickSeg = false`  L110
- `int MAX_FRESH_COUNT = 3`  L112
- `int mFreshCount = 0`  L113
- `int i = msg.what`  L117
- `int i2 = PreviewImageActivity.this.mEvent`  L136
- `PreviewImageActivity previewImageActivity = PreviewImageActivity.this`  L284
- `boolean z`  L316
- `PreviewImageActivity previewImageActivity = PreviewImageActivity.this`  L324
- `PreviewImageActivity previewImageActivity2 = PreviewImageActivity.this`  L326
- `PreviewImageActivity previewImageActivity = PreviewImageActivity.this`  L472
- `PreviewImageActivity previewImageActivity2 = PreviewImageActivity.this`  L477
- `ArrayList<HiDefine.PathConnection> arrayList = this.mFilelistManager.mstrDVListFileForUI`  L500
- `int i = this.operType`  L595
- `int i2 = this.operType`  L610
- `int i = HiDefine.FILEBROESER_TYPE_DV`  L627
- `ArrayList<HiDefine.PathConnection> arrayList = this.listPathCon`  L649
- `SdcardReceiver sdcardReceiver = this.mSdcardReceiver`  L700
- `Bundle extras`  L822
- `int i = 0`  L855
- `ArrayList<HiDefine.PathConnection> arrayList = this.mFilelistManager.mstrDVListFileForUI`  L925
- `PreviewImageActivity previewImageActivity = PreviewImageActivity.this`  L1000
- `WifiDisconnectReceiver wifiDisconnectReceiver = this.mWifiDisReceiver`  L1034
- `PreviewImageActivity previewImageActivity`  L1131
- `int i = this.operType`  L1140

方法（70）：
- `void handleMessage(Message msg)`  L116 @Override
- `void run()`  L155 @Override
- `boolean lambda$enableClick$3(boolean z, View view, MotionEvent motionEvent)`  L175
- `boolean lambda$enableClick$4(boolean z, View view, MotionEvent motionEvent)`  L179
- `void enableClickScreen(boolean isClickable)`  L184 @Deprecated
- `void onCreate(Bundle savedInstanceState)`  L251 @Override
    - 体内字面量："onCreate" · "filebrowserType"
- `void onRemoveBitmap(int position)`  L269 @Override
    - 体内字面量："453412311111" · "onRemoveBitmap:--------------------------------      åå¼ å é¤"
- `void onRemoveAllBitmap()`  L275 @Override
- `void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)`  L281 @Override
- `void onScrollStateChanged(AbsListView view, int nScrollState)`  L315 @Override
- `void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)`  L348 @Override
- `boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)`  L372 @Override
    - 体内字面量："785453" · "onItemLongClick: ----------------   " · "OriFileName" · "bDownloadVisiable" · "bShareVisiable" · "bPushVisiable" · "bPushVisiable"
- `boolean OnTouchEvent(MotionEvent event)`  L394 @Override
- `void onClick(View v)`  L406 @Override
- `void onClick(View v)`  L412 @Override
- `void onClick(View v)`  L422 @Override
    - 体内字面量："78798787867876" · "onClick:  -------------------   " · "78798787867876" · "onClick:  ------111111-------------   "
- `void onClick(View v)`  L434 @Override
- `void onClick(View v)`  L444 @Override
- `void onClick(View v)`  L450 @Override
- `void onClick(View v)`  L456 @Override
- `void onClick(View v)`  L469 @Override
- `void startLoad()`  L491 @Override
- `void loadDone()`  L496 @Override
- `int compare(Object obj, Object obj2)`  L506 @Override
- `int lambda$onCreate$0(SimpleDateFormat simpleDateFormat, HiDefine.PathConnection pathConnection, HiDefine.PathConnection pathConnection2)`  L569
- `void firstLoadThumb()`  L579 @Deprecated
- `void onDvDisconnectionEvent(DvDisconnectionEvent event)`  L587 @Subscribe(threadMode = ThreadMode.MAIN)
- `void updateConfirmText()`  L592
    - 体内字面量："7894654222777" · "onClick:  ---------------------------    7"
- `void onStart()`  L625 @Override
- `void onResume()`  L640 @Override
    - 体内字面量："7894654222777" · "startImageDetail:  ----------è¿åæ¥çæ¶ååè¡¨ä¸ªæ°æ¯---------   "
- `void startLoad()`  L658 @Override
- `void loadDone()`  L663 @Override
    - 体内字面量："yyyy/MM/dd HH:mm:ss"
- `int compare(Object obj, Object obj2)`  L673 @Override
    - 体内字面量："7894654222777" · "startImageDetail:  --------22222--è¿åæ¥çæ¶ååè¡¨ä¸ªæ°æ¯---------   "
- `int lambda$onResume$1(SimpleDateFormat simpleDateFormat, HiDefine.PathConnection pathConnection, HiDefine.PathConnection pathConnection2)`  L686
- `void onStop()`  L696 @Override
- `void findView()`  L708
- `void clearBitmapCache()`  L737
    - 体内字面量："/cache"
- `void clearFile(File file)`  L741
    - 体内字面量："clearFile: "
- `void loading(final boolean isLoading)`  L755
- `void run()`  L758 @Override
- `void lambda$loading$2(boolean z)`  L766
- `void enableClick(final boolean enableAllViewClick)`  L776
- `boolean onTouch(View view, MotionEvent motionEvent)`  L779 @Override
- `boolean onTouch(View view, MotionEvent motionEvent)`  L785 @Override
- `boolean onTouchEvent(MotionEvent event)`  L792 @Override
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L800 @Override
- `void onDestroy()`  L813 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L821 @Override
- `void processSwitchImage(Bundle MarsBuddle)`  L851
    - 体内字面量："isDeletefile" · "imgPathLen" · "imgPath"
- `void processPopupForWin(Bundle MarsBuddle)`  L871
    - 体内字面量："oprateType"
- `void processDeleteFresh(Bundle MarsBuddle)`  L904
    - 体内字面量："453412311" · "processDeleteFresh:  --------------------  "
- `void startLoad()`  L916 @Override
- `void loadDone()`  L921 @Override
- `void processDownloadOption(Bundle MarsBuddle)`  L933
    - 体内字面量："Option"
- `void processDeleteConfirm(Bundle MarsBuddle)`  L937
    - 体内字面量："oprateType" · "453412311" · "processDeleteConfirm:  --------------------------  DV ç¸æºåçå é¤" · "453412311" · "processDeleteConfirm:  ------FILEBROESER_TYPE_DV--------   éé¿æå é¤" · "453412311" · "processDeleteConfirm:  -------FILEBROESER_TYPE_DV-------   é¿æå é¤" · "453412311" · "processDeleteConfirm:  -------------------   åå¤å¼å§å é¤ç§ç" · "85265211111" · "processDeleteConfirm:  --------------   éé¿æå é¤" · "85265211111" · "processDeleteConfirm:  --------------   é¿æå é¤" · " delete failed"
- `void starListenWifi()`  L981
- `void onWifiStateChanged(NetworkInfo.DetailedState detailedState)`  L987 @Override
    - 体内字面量："detailedState"
- `void stopLislenWifi()`  L1033
- `void showMenu()`  L1043
    - 体内字面量："showMenu"
- `void photoOrDVswitch()`  L1057
- `void menuDelete()`  L1068
- `void menuShare()`  L1084
- `void menuDownload()`  L1100
- `void UndoOperate()`  L1116
- `void doOperate()`  L1130
- `void startImageDetail(String strUrl, int position)`  L1177
    - 体内字面量："7894654222777" · "startImageDetail: ---------------------   æ­æ¾:" · "dng" · "7894654222777" · "onCreate:  ----------------  ä¼ éæ­æ¾å°å  " · "MP4" · "7894654222777" · "startImageDetail: ----------------------   MP4" · "android.intent.action.VIEW" · "7894654222777" · "startImageDetail:  ----------11111---------   " · "7894654222777" · "onCreate:  ----------è·³è½¬----LRV-------  æ­æ¾è§é¢" · "7894654222777" · "startImageDetail:  ----------11111---------   " · "start" · "CurIndex" · "PathNum" · "ShareType" · "wifiSSID"
- `void setTitile()`  L1237
    - 体内字面量："setTitileaa: AAAAAA  2"
- `void onMessageEvent(MessageEvent messageEvent)`  L1247 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："66656565655665" · "onMessageEvent:  ----------PIA-----------   å·æ°" · "45453435132" · "onMessageEvent:  --------------------   æ¶å°å·æ°é¡µé¢æ¶æ¯     "
- `void startLoad()`  L1257 @Override
- `void loadDone()`  L1262 @Override
    - 体内字面量："avbngscvx" · "downloadImage:  --------------  æ¶å°åéSDå¡æ»¡æ¶æ¯"
### `com.gku.actioncam.hisilicon.dv.filebrowser.PreviewImageActivity$AnonymousClass1`
L188 · [class] AnonymousClass1 · extends `Handler` · `com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java`

字段/常量（5）：
- `int i = msg.arg1`  L196
- `PreviewImageActivity previewImageActivity = PreviewImageActivity.this`  L202
- `PreviewImageActivity previewImageActivity2 = PreviewImageActivity.this`  L205
- `PreviewImageActivity previewImageActivity3 = PreviewImageActivity.this`  L220
- `PreviewImageActivity previewImageActivity4 = PreviewImageActivity.this`  L223

方法（3）：
- `void handleMessage(Message msg)`  L194 @Override
- `int compare(Object obj, Object obj2)`  L230 @Override
- `int lambda$handleMessage$0(SimpleDateFormat simpleDateFormat, HiDefine.PathConnection pathConnection, HiDefine.PathConnection pathConnection2)`  L240
### `com.gku.actioncam.hisilicon.dv.filebrowser.PreviewImageActivity$AnonymousClass22`
L1016 · [class] static AnonymousClass22 · `com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java`

字段/常量（1）：
- `int[] $SwitchMap$android$net$NetworkInfo$DetailedState`  L1017
### `com.gku.actioncam.hisilicon.dv.filebrowser.PreviewImageActivity$AnonymousClass6`
L514 · [class] AnonymousClass6 · implements `RefreshHeadView.PullToRefreshListener` · `com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java`

字段/常量（1）：
- `PreviewImageActivity previewImageActivity = PreviewImageActivity.this`  L544

方法（7）：
- `void onRefresh()`  L519 @Override
- `void run()`  L522 @Override
- `void lambda$onRefresh$1()`  L530
- `void startLoad()`  L535 @Override
- `void loadDone()`  L540 @Override
- `int compare(Object obj, Object obj2)`  L550 @Override
- `int lambda$onRefresh$0(SimpleDateFormat simpleDateFormat, HiDefine.PathConnection pathConnection, HiDefine.PathConnection pathConnection2)`  L559
### `com.gku.actioncam.hisilicon.dv.filebrowser.PreviewImageActivity$SdcardReceiver`
L1219 · [class] SdcardReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java`

方法（1）：
- `void onReceive(Context context, Intent intent)`  L1224 @Override
    - 体内字面量："event" · "event:"
### `com.gku.actioncam.hisilicon.dv.filebrowser.RefreshHeadView`
L21 · [class] public RefreshHeadView · extends `LinearLayout` · `com/gku/actioncam/hisilicon/dv/filebrowser/RefreshHeadView.java`

字段/常量（32）：
- `int SCROLL_SPEED = -20`  L22
- `int STATUS_PULL_TO_REFRESH = 0`  L23
- `int STATUS_REFRESHING = 2`  L24
- `int STATUS_REFRESH_FINISHED = 3`  L25
- `int STATUS_RELEASE_TO_REFRESH = 1`  L26
- `String TAG = "RefreshHeadView"`  L27
- `boolean ableToPull`  L28
- `ImageView arrow`  L29
- `int currentStatus`  L30
- `TextView headViewMsg`  L31
- `View header`  L32
- `ViewGroup.MarginLayoutParams headerLayoutParams`  L33
- `HiGridView hiGridView`  L34
- `int hideHeaderHeight`  L35
- `int lastStatus`  L36
- `boolean loadOnce`  L37
- `DisplayMetrics mDispalyMetrix`  L38
- `PullToRefreshListener mListener`  L39
- `ProgressBar progressBar`  L40
- `int touchSlop`  L41
- `float yDown`  L42
- `int i = this.currentStatus`  L93
- `int i2 = this.headerLayoutParams.topMargin`  L113
- `int i3 = this.hideHeaderHeight`  L114
- `int i4 = this.currentStatus`  L125
- `int i = this.headerLayoutParams.topMargin`  L157
- `int i2 = this.hideHeaderHeight`  L158
- `int i = this.lastStatus`  L172
- `int i2 = this.currentStatus`  L173
- `float f`  L199
- `int i = this.currentStatus`  L202
- `float f2 = 180.0f`  L203

方法（10）：
- `public RefreshHeadView(Context context, AttributeSet attrs)`  L48
- `void onLayout(boolean changed, int l, int t, int r, int b)`  L66 @Override
- `HiGridView getScrollView()`  L79
- `boolean onTouch(MotionEvent event)`  L86
- `void setOnRefreshListener(PullToRefreshListener listener)`  L138
- `void finishRefreshing()`  L142
- `void setIsAbleToPull(MotionEvent event)`  L147
- `void updateHeaderView()`  L171
- `void rotateArrow()`  L198
- `void sleep(int time)`  L289
### `com.gku.actioncam.hisilicon.dv.filebrowser.RefreshHeadView$HideHeaderTask`
L253 · [class] HideHeaderTask · extends `AsyncTask<Void, Integer, Integer>` · `com/gku/actioncam/hisilicon/dv/filebrowser/RefreshHeadView.java`

字段/常量（1）：
- `int i = RefreshHeadView.this.headerLayoutParams.topMargin`  L260

方法（3）：
- `Integer doInBackground(Void... params)`  L259 @Override
- `void onProgressUpdate(Integer... topMargin)`  L274 @Override
- `void onPostExecute(Integer topMargin)`  L281 @Override
### `com.gku.actioncam.hisilicon.dv.filebrowser.RefreshHeadView$PullToRefreshListener`
L44 · [interface] public PullToRefreshListener · `com/gku/actioncam/hisilicon/dv/filebrowser/RefreshHeadView.java`

方法（1）：
- `void onRefresh()`  L45
### `com.gku.actioncam.hisilicon.dv.filebrowser.RefreshHeadView$RefreshingTask`
L219 · [class] RefreshingTask · extends `AsyncTask<Void, Integer, Void>` · `com/gku/actioncam/hisilicon/dv/filebrowser/RefreshHeadView.java`

字段/常量（1）：
- `int i = RefreshHeadView.this.headerLayoutParams.topMargin`  L226

方法（2）：
- `Void doInBackground(Void... params)`  L225 @Override
- `void onProgressUpdate(Integer... topMargin)`  L246 @Override