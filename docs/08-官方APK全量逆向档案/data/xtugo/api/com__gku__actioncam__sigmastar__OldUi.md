# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.OldUi

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 29 个文件 / 52 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.OldUi.playback.model.AmbaPlaybackModel`
L45 · [class] public AmbaPlaybackModel · implements `ISSPlaybackModel, IChannelListener` · `com/gku/actioncam/sigmastar/OldUi/playback/model/AmbaPlaybackModel.java`

字段/常量（28）：
- `int PAGECOUNT = 50`  L46
- `String TAG = "AmbaPlaybackModel"`  L47
- `boolean loadFileListWorking = false`  L48
- `ExecutorService worker`  L49
- `SSFileInfoBean fileInfo`  L50
- `Map<Integer, SSFileInfoBean> fileMap`  L51
- `SSFileInfoBean originfileInfo`  L52
- `ISSPlaybackModelCallback playbackModelCallback`  L53
- `int position`  L54
- `ISSPreviewModelCallback previewModelCallback`  L55
- `String requestType`  L56
- `ArrayList<SSFileInfoBean> ssFileInfoBeans`  L57
- `int curIndex = 0`  L58
- `boolean isFileListLoading = false`  L59
- `int mFileCount = 0`  L60
- `int mCurLoadFileCount = 0`  L61
- `int count_thumb = 0`  L65
- `int resultCode = -1`  L66
- `int keyIndex = 0`  L67
- `boolean deleteWorking = false`  L68
- `int resultNum = 0`  L69
- `int lastVideoSize = 0`  L70
- `int lastImageSize = 0`  L71
- `String str`  L167
- `long length`  L168
- `AmbaPlaybackModel ambaPlaybackModel = AmbaPlaybackModel.this`  L279
- `String str = array[0]`  L347
- `AmbaPlaybackModel ambaPlaybackModel = AmbaPlaybackModel.this`  L455

方法（45）：
- `public AmbaPlaybackModel(ISSPlaybackModelCallback playbackModelCallback, ISSPreviewModelCallback previewModelCallback)`  L74
- `void getFileInfoList(int start, int end, AmbaRequestCallback ambaRequestCallback)`  L80
- `void selfGetFileInfoList(int start, final int end)`  L89
    - 体内字面量："è·åæä»¶åè¡¨selfGetFileInfoList start=" · "  loadFileListWorking=" · " end="
- `void success()`  L98 @Override
    - 体内字面量："è·åæä»¶åè¡¨ onSuccess: getFileInfoList"
- `void failure(int code)`  L104 @Override
    - 体内字面量："è·åæä»¶åè¡¨ onFailure: getFileInfoList"
- `void getFileCount(AmbaRequestCallback ambaRequestCallback)`  L111
- `void pullRemoteList(AmbaRequestCallback ambaRequestCallback)`  L115
- `void loadData(String type)`  L120 @Override
    - 体内字面量："loadFilePageDataVASDD: 555"
- `void success()`  L130 @Override
    - 体内字面量："successSSDSDSDSDSD: å è½½æå"
- `void failure(int code)`  L135 @Override
- `void run()`  L138 @Override
- `void run()`  L147 @Override
    - 体内字面量："Video" · "Photo"
- `void stopData()`  L160 @Override
    - 体内字面量："è·åæä»¶åè¡¨ stopData  loadFileListWorking="
- `void loadThumb(String thumbPath, String savePath, String createTime, int position, ImageView view)`  L166 @Override
- `void run()`  L206 @Override
    - 体内字面量："å°é¢æ¬å°æä»¶ä¸å­å¨"
- `void loadFileInfo(SSFileInfoBean fileInfo)`  L219 @Override
- `void failure(int code)`  L223 @Override
- `void success()`  L227 @Override
- `void delFile(SSFileInfoBean fileInfo, ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L233 @Override
- `void failure(int code)`  L238 @Override
- `void success()`  L242 @Override
- `void delFile(int position, Map<Integer, SSFileInfoBean> fileMap)`  L248 @Override
- `void failure(int code)`  L253 @Override
- `void success()`  L257 @Override
- `void delFile(final Map<Integer, SSFileInfoBean> fileMap)`  L263 @Override
- `void run()`  L267 @Override
- `void success()`  L284 @Override
- `void failure(int code)`  L288 @Override
- `void stopDelete()`  L308 @Override
- `void startLoadThumb()`  L313 @Override
- `void stopLoadThumb()`  L318 @Override
- `void clearThumb()`  L323 @Override
- `void loadThumbRetry(String thumbPath)`  L328 @Override
- `void getFileAsync(String dtsPath, long size, AmbaRequestCallback ambaRequestCallback)`  L332
- `void onChannelEvent(int type, final Object param, String... array)`  L341 @Override
    - 体内字面量："AmabaPalybackMode" · "onChannelEvent-----type=" · " param=" · "onChannelEvent: " · "AmabaPalybackMode"
- `void success()`  L352 @Override
    - 体内字面量："get thumb:Success="
- `void failure(int code)`  L357 @Override
    - 体内字面量："failure: get thumb failure" · "onChannelEvent: è·åç³»ç»å·¥ä½ç¶æ (SyncStateMessageStr) param=" · "----------"
- `void run()`  L372 @Override
    - 体内字面量：";"
- `void run()`  L390 @Override
    - 体内字面量："onChannelEvent: GetFileInfo: "
- `void run()`  L400 @Override
    - 体内字面量："DATA_CHANNEL_EVENT_GET_FINISH:path="
- `void run()`  L405 @Override
    - 体内字面量："è¿ä¸ªåè°èµ°å°SSPlaybackNewPresenter#åé¨ç±»SSPlaybackModelBack#loadThumbSuccess" · "onChannelEvent: fileCount: "
- `void run()`  L434 @Override
- `void run()`  L447 @Override
    - 体内字面量："123->  deleteFile result position=" · "   fileMap.size="
- `ArrayList<SSFileInfoBean> parseGetFileList(JSONArray info_list_json_array)`  L493
    - 体内字面量："fileName" · "Video" · "fileTimeLong" · "fileCreateTime" · "fileSize" · "Photo" · "fileCreateTime" · "fileSize" · "thumbList size: "
- `void parseGetFileInfo(JSONArray info_list_json_array)`  L525
    - 体内字面量："fileName" · "parseGetFileInfo: " · "fileTimeLong" · "fileCreateTime" · "fileSize" · "fileCreateTime" · "fileSize" · "PlaybackModelManage.videoThumbList size: " · "PlaybackModelManage.imageThumbList size: "
### `com.gku.actioncam.sigmastar.OldUi.playback.model.HisiPlaybackModel`
L45 · [class] public HisiPlaybackModel · implements `ISSPlaybackModel` · `com/gku/actioncam/sigmastar/OldUi/playback/model/HisiPlaybackModel.java`

字段/常量（5）：
- `int PAGECOUNT = 50`  L46
- `String TAG = "HisiPlaybackModel"`  L47
- `ISSPlaybackModelCallback playbackModelCallback`  L49
- `int curIndex = 1`  L50
- `int i = this.curIndex`  L280

方法（39）：
- `void clearThumb()`  L56 @Override
- `void loadThumbRetry(String thumbPath)`  L60 @Override
- `void startLoadThumb()`  L64 @Override
- `void stopDelete()`  L68 @Override
- `void stopLoadThumb()`  L72 @Override
- `public HisiPlaybackModel(ISSPlaybackModelCallback playbackModelCallback)`  L75
- `void loadData(final String type)`  L80 @Override
    - 体内字面量："loadFilePageDataVASDD: 222"
- `void onSuccess(String result)`  L85 @Override
    - 体内字面量："count" · "info---" · "loadFilePageDataVASDD è·åæ°æ®æ»æ°" · "loadFilePageDataVASDD curIndex: "
- `void onError(int code, Exception e)`  L104 @Override
- `void onBefore()`  L109 @Override
- `void run()`  L117 @Override
    - 体内字面量："Video" · "Photo" · "è¿ä¸ªåè°èµ°å°SSPlaybackNewPresenter#åé¨ç±»SSPlaybackModelBack#updateData"
- `void stopData()`  L131 @Override
- `void loadThumb(final String thumbPath, String savePath, String createTime, int position, final ImageView view)`  L136 @Override
    - 体内字面量："loadThumb thumbPath" · "loadThumb savePath" · "loadThumb createTime" · "å°é¢æ¬å°æä»¶å­å¨"
- `void run()`  L150 @Override
- `void allTaskFinish()`  L159 @Override
- `void downloadTaskFailure(String path, String errMsg)`  L163 @Override
- `void notEnoughSpace()`  L167 @Override
- `void startDownload(String currentPath)`  L171 @Override
- `void updateProgress(String savePath2, float progress)`  L175 @Override
- `void downloadFinish(String savePath2)`  L179 @Override
- `void loadFileInfo(final SSFileInfoBean fileInfo)`  L187 @Override
- `void onSuccess(String result)`  L190 @Override
- `void onError(int code, Exception e)`  L195 @Override
- `void delFile(final SSFileInfoBean fileInfo, final ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L202 @Override
- `void onSuccess(String result)`  L205 @Override
- `void onError(int code, Exception e)`  L210 @Override
- `void delFile(final int position, final Map<Integer, SSFileInfoBean> fileMap)`  L217 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L220 @Override
- `void onFail(Call call, int code, String errorMsg)`  L225 @Override
- `void delFile(final Map<Integer, SSFileInfoBean> fileMap)`  L232 @Override
- `void onSuccess(String result)`  L237 @Override
- `void onError(int code, Exception e)`  L242 @Override
- `HashMap<String, Object> parseGetFileList(String response, String type)`  L249
    - 体内字面量：";" · "count" · "Video" · "Photo" · "data"
- `void loadFilePageData(final int count, final String type)`  L277
    - 体内字面量："loadFilePageDataVASDD: 111"
- `void onSuccess(String result)`  L283 @Override
    - 体内字面量："HisionSuccess: " · "count" · "Video" · "Photo" · "info---" · "å è½½åè¡¨æ°æ®æå"
- `void onError(int code, Exception e)`  L301 @Override
- `void onBefore()`  L306 @Override
- `HashMap<String, Object> parseGetFileInfo(String response, String type)`  L314
    - 体内字面量："size" · "count"
- `HashMap<String, Object> parseGetFileListAndInfo(String response, String type)`  L345
    - 体内字面量："size" · "Video" · "Photo" · "count" · "data"
### `com.gku.actioncam.sigmastar.OldUi.playback.model.PlaybackModelManage`
L15 · [class] public PlaybackModelManage · `com/gku/actioncam/sigmastar/OldUi/playback/model/PlaybackModelManage.java`

字段/常量（2）：
- `ISSPlaybackModel playbackModel`  L18
- `ISSPlaybackModel iSSPlaybackModel = this.playbackModel`  L40

方法（14）：
- `public PlaybackModelManage(ISSPlaybackModelCallback playbackModelCallback, ISSPreviewModelCallback previewModelCallback)`  L20
    - 体内字面量："CV75"
- `ISSPlaybackModel getModel()`  L39
- `void clearThumb()`  L46 @Override
- `void delFile(int position, Map<Integer, SSFileInfoBean> fileMap)`  L50 @Override
- `void delFile(SSFileInfoBean fileInfo, ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L54 @Override
- `void delFile(Map<Integer, SSFileInfoBean> fileMap)`  L58 @Override
- `void loadData(String type)`  L62 @Override
- `void loadFileInfo(SSFileInfoBean fileInfo)`  L66 @Override
- `void loadThumb(String thumbPath, String savePath, String createTime, int position, ImageView view)`  L70 @Override
- `void loadThumbRetry(String thumbPath)`  L74 @Override
- `void startLoadThumb()`  L78 @Override
- `void stopData()`  L82 @Override
- `void stopDelete()`  L86 @Override
- `void stopLoadThumb()`  L90 @Override
### `com.gku.actioncam.sigmastar.OldUi.playback.model.player.OnlineAndOfflinePlayer`
L23 · [class] public OnlineAndOfflinePlayer · extends `GKUCamPlayer` · `com/gku/actioncam/sigmastar/OldUi/playback/model/player/OnlineAndOfflinePlayer.java`

字段/常量（1）：
- `ImageButton backButton`  L24

方法（7）：
- `void onCreate(Bundle savedInstanceState)`  L27 @Override
    - 体内字面量："kPlayFilePath" · "OnlineAndOfflinePlayer" · "path: " · "http:" · "needShowPlayerTips"
- `void onClick(DialogInterface dialog, int which)`  L38 @Override
- `void onClick(DialogInterface dialog, int which)`  L42 @Override
    - 体内字面量："needShowPlayerTips"
- `void onClick(View view)`  L54 @Override
- `WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets)`  L64 @Override
- `void lambda$onCreate$0(View view)`  L78
- `void onConfigurationChanged(Configuration newConfig)`  L83 @Override
    - 体内字面量："Screen" · "æ¨ªå±æ¨¡å¼" · "Screen" · "ç«å±æ¨¡å¼"
### `com.gku.actioncam.sigmastar.OldUi.playback.model.service.DownloadIntentService`
L23 · [class] public DownloadIntentService · extends `IntentService` · `com/gku/actioncam/sigmastar/OldUi/playback/model/service/DownloadIntentService.java`

字段/常量（12）：
- `int DOWNLOAD_NOTIFICATION_ID = 1741`  L24
- `String DOWNLOAD_PATH = "com.gku.actioncam.sigmastar.OldUi.playback.path"`  L25
- `String DOWNLOAD_STATE = "com.gku.actioncam.sigmastar.OldUi.playback.state"`  L26
- `String DOWNLOAD_TASK = "com.gku.actioncam.sigmastar.OldUi.playback.action.DOWNLOAD_TASK"`  L27
- `String TAG = "DownloadIntentService"`  L28
- `boolean isDownloading = false`  L29
- `String notificationId`  L30
- `NotificationManager notificationManager`  L31
- `NotificationManager notificationManager = this.notificationManager`  L59
- `NotificationManager notificationManager = this.notificationManager`  L67
- `NotificationManager notificationManager = this.notificationManager`  L76
- `ArrayList<SSFileInfoBean> parcelableArrayListExtra`  L92

方法（12）：
- `public DownloadIntentService()`  L33
    - 体内字面量："DownloadIntentService" · "SSDownloadTask"
- `void onCreate()`  L39 @Override
    - 体内字面量："notification" · "SSDownloadTask"
- `Notification getNotification(String downloadInfo, int progress)`  L49
    - 体内字面量："SSDownloadTask"
- `void cancelNotification()`  L58
- `void notifyNotification(Notification notification)`  L66
- `void notifyNotification(String fileName, int progress)`  L75
- `void startDownloadTask(Context context, ArrayList<SSFileInfoBean> fileList)`  L83
- `void onHandleIntent(Intent intent)`  L91 @Override
- `boolean isDownloading()`  L99
- `void cancelDownloadTask()`  L103
- `void sendReceiverMessage(SSDownloadState state)`  L108
- `void handleDownload(ArrayList<SSFileInfoBean> fileList)`  L177
### `com.gku.actioncam.sigmastar.OldUi.playback.model.service.DownloadIntentService$AnonymousClass1`
L116 · [class] AnonymousClass1 · implements `SSHttpClientUtil.DownloadCallback` · `com/gku/actioncam/sigmastar/OldUi/playback/model/service/DownloadIntentService.java`

字段/常量（1）：
- `DownloadIntentService downloadIntentService = DownloadIntentService.this`  L165

方法（8）：
- `void notEnoughSpace()`  L118 @Override
- `void startDownload(String currentPath)`  L125 @Override
    - 体内字面量："startDownload: "
- `void updateProgress(String currentPath, float progress)`  L132 @Override
    - 体内字面量："%s:%s, %s" · "%" · "updateProgress: " · "path:%s, progress:%s"
- `void downloadFinish(String savePath)`  L143 @Override
    - 体内字面量："downloadFinish: "
- `void allTaskFinish()`  L150 @Override
    - 体内字面量："allTaskFinish: "
- `void run()`  L157 @Override
- `void lambda$allTaskFinish$0()`  L164
- `void downloadTaskFailure(String path, String errMsg)`  L170 @Override
    - 体内字面量："downloadTaskFailure: "
### `com.gku.actioncam.sigmastar.OldUi.playback.model.SigmastartPlaybackModel`
L31 · [class] public SigmastartPlaybackModel · implements `ISSPlaybackModel` · `com/gku/actioncam/sigmastar/OldUi/playback/model/SigmastartPlaybackModel.java`

字段/常量（6）：
- `int PAGECOUNT = 50`  L32
- `String TAG = "SigmastartPlaybackModel"`  L33
- `ISSPlaybackModelCallback playbackModelCallback`  L34
- `int curIndex = 0`  L35
- `int i = this.curIndex`  L204
- `int i2 = i + 50 > count ? count - 1 : i + 49`  L205

方法（33）：
- `void clearThumb()`  L41 @Override
- `void loadThumbRetry(String thumbPath)`  L45 @Override
- `void startLoadThumb()`  L49 @Override
- `void stopDelete()`  L53 @Override
- `void stopLoadThumb()`  L57 @Override
- `public SigmastartPlaybackModel(ISSPlaybackModelCallback playbackModelCallback)`  L60
- `void loadData(final String type)`  L65 @Override
    - 体内字面量："loadFilePageDataVASDD: 444"
- `void onSuccess(Call call, String responseBody, Response response)`  L70 @Override
    - 体内字面量："è·åæ°æ®æ»æ°"
- `void onFail(Call call, int code, String errorMsg)`  L77 @Override
- `void stopData()`  L84 @Override
- `void loadThumb(final String thumbPath, String savePath, String createTime, int position, final ImageView imageView)`  L89 @Override
    - 体内字面量："loadThumb" · "å°é¢æ¬å°æä»¶å­å¨"
- `void run()`  L101 @Override
    - 体内字面量："å°é¢æ¬å°æä»¶ä¸å­å¨"
- `void allTaskFinish()`  L111 @Override
- `void downloadTaskFailure(String path, String errMsg)`  L115 @Override
- `void notEnoughSpace()`  L119 @Override
- `void startDownload(String currentPath)`  L123 @Override
- `void updateProgress(String savePath2, float progress)`  L127 @Override
- `void downloadFinish(String savePath2)`  L131 @Override
- `void loadFileInfo(final SSFileInfoBean fileInfo)`  L139 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L142 @Override
- `void onFail(Call call, int code, String errorMsg)`  L147 @Override
- `void delFile(final SSFileInfoBean fileInfo, final ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L154 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L157 @Override
- `void onFail(Call call, int code, String errorMsg)`  L162 @Override
- `void delFile(final int position, final Map<Integer, SSFileInfoBean> fileMap)`  L169 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L172 @Override
- `void onFail(Call call, int code, String errorMsg)`  L177 @Override
- `void delFile(final Map<Integer, SSFileInfoBean> fileMap)`  L184 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L189 @Override
- `void onFail(Call call, int code, String errorMsg)`  L194 @Override
- `void loadFilePageData(final int count, final String type)`  L202
    - 体内字面量："loadFilePageDataVASDD: 333"
- `void onSuccess(Call call, String responseBody, Response response)`  L223 @Override
    - 体内字面量："å è½½åè¡¨æ°æ®æå"
- `void onFail(Call call, int code, String errorMsg)`  L238 @Override
### `com.gku.actioncam.sigmastar.OldUi.playback.presenter.SSPlaybackNewPresenter`
L79 · [class] public SSPlaybackNewPresenter · `com/gku/actioncam/sigmastar/OldUi/playback/presenter/SSPlaybackNewPresenter.java`

字段/常量（44）：
- `String TAG = "SSPlaybackNewPresenter"`  L80
- `Context context`  L81
- `AlertDialog deleteDialog`  L82
- `AlertDialog downloadDialog`  L83
- `List<Map.Entry<Integer, SSFileInfoBean>> mEntryList`  L84
- `Map<Integer, SSFileInfoBean> mFileMap`  L85
- `int mIndex`  L86
- `Timer mTimer`  L87
- `TimerTask mTimerTask`  L88
- `ISSPlayback playback`  L89
- `ISSPlayback2 playback2`  L90
- `ISSPreviewNew preview`  L91
- `boolean isCancelDelete = false`  L93
- `boolean isDownloadNormalVideo = false`  L94
- `ISSPlayback iSSPlayback = this.playback`  L214
- `AlertDialog alertDialog = this.downloadDialog`  L223
- `Uri uriInsert`  L414
- `OutputStream outputStream`  L415
- `OutputStream outputStream2`  L416
- `FileInputStream fileInputStream = null`  L429
- `OutputStream outputStreamOpenOutputStream = null`  L432
- `FileInputStream fileInputStream2 = null`  L433
- `byte[] bArr = new byte[4096]`  L471
- `Uri uriInsert`  L499
- `OutputStream outputStream`  L500
- `StringBuilder sb`  L501
- `IOException e`  L502
- `InputStream fileInputStream`  L503
- `InputStream inputStream = null`  L518
- `OutputStream outputStreamOpenOutputStream = null`  L521
- `OutputStream outputStream2 = outputStreamOpenOutputStream`  L534
- `OutputStream outputStream3 = outputStreamOpenOutputStream`  L574
- `byte[] bArr = new byte[4096]`  L589
- `Uri uri`  L628
- `OutputStream outputStream`  L629
- `String str3`  L630
- `IOException e`  L631
- `StringBuilder sb`  L632
- `InputStream inputStream = null`  L659
- `OutputStream outputStreamOpenOutputStream = null`  L662
- `byte[] bArr = new byte[4096]`  L727
- `String string`  L765
- `AlertDialog alertDialog = this.downloadDialog`  L784
- `ISSPlayback iSSPlayback = this.playback`  L798

方法（63）：
- `void lambda$downloadFileListSync$1(DialogInterface dialogInterface)`  L97
- `void lambda$showRenameDialog$5(DialogInterface dialogInterface)`  L100
- `void lambda$showRenameDialog$6(DialogInterface dialogInterface)`  L103
- `void lambda$showVideoQualityDialog$10(DialogInterface dialogInterface)`  L106
- `void lambda$showVideoQualityDialog$9(DialogInterface dialogInterface)`  L109
- `public SSPlaybackNewPresenter(Context context)`  L112
- `void setView(ISSPlayback playback, ISSPreviewNew preview)`  L116
- `void setView2(ISSPlayback2 playback)`  L121
- `void clearView()`  L125
- `void loadFileList(String type)`  L131
- `void stopFileList()`  L135
- `void stopLoadThumb()`  L139
- `void startLoadThumb()`  L143
- `void clearThumb()`  L147
- `void loadThumbRetry(String thumbPath)`  L151
- `void stopDelete()`  L155
- `void deleteFile(SSFileInfoBean ssFileInfoBean)`  L159
- `void deleteFileList(ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L165
    - 体内字面量："å¼å§æ§è¡å é¤"
- `void deleteFile(int position, SSFileInfoBean ssFileInfoBean)`  L173
- `void deleteFileList(Map<Integer, SSFileInfoBean> fileMap)`  L179
    - 体内字面量："fileMapå¼å§æ§è¡å é¤"
- `void initTimerTask()`  L187
- `void run()`  L190 @Override
- `void finishDeleteTask()`  L203
- `void run()`  L206 @Override
- `void lambda$finishDeleteTask$0()`  L213
- `void downloadFileListSync(final ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L221
    - 体内字面量："downloadFileListSync: "
- `void onCancel(DialogInterface dialogInterface)`  L229 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L237 @Override
- `void onClick(View view)`  L264 @Override
- `void lambda$downloadFileListSync$2(DialogInterface dialogInterface)`  L272
- `void lambda$downloadFileListSync$3(int i, ArrayList arrayList, View view)`  L277
    - 体内字面量："ss_dialog_download_cancel 0000" · "ss_dialog_download_cancel: " · "delete File encountered exception: "
- `long getphonesize()`  L407
- `void copyPrivateToDownload(Context context, String str)`  L413
- `void copyPrivateToDownload2(Context context, String str)`  L498
- `void downloadToDcimNoLessThan29(Context context, String str, String str2)`  L627
- `void downloadToDcimNoMoreThan28(Context context, String orgFilePath, String cameraType)`  L764
- `void finishDownloadTask()`  L783
- `void run()`  L790 @Override
- `void lambda$finishDownloadTask$4()`  L797
- `void showFileInfoDialog(SSFileInfoBean fileInfo)`  L804
- `boolean hasRepeatFile(SSFileInfoBean ssFileInfoBean)`  L808
- `void loadThumb(String thumbPath, String savePath, String createTime, int position, ImageView view)`  L812
- `boolean hasRepeatFile(ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L816
- `String renameRepeatFile(String localPath)`  L826
    - 体内字面量："/" · "/" · "_" · "%s_"
- `void showRenameDialog(SSFileInfoBean ssFileInfoBean)`  L839
- `void showRenameDialog(final ArrayList<SSFileInfoBean> ssFileInfoBeanArrayList)`  L845
- `void onCancel(DialogInterface dialogInterface)`  L852 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L858 @Override
- `void onClick(View view)`  L871 @Override
- `void onClick(View view)`  L877 @Override
- `void lambda$showRenameDialog$8(AlertDialog alertDialog, RadioGroup radioGroup, ArrayList arrayList, View view)`  L884
- `void showVideoQualityDialog(SSFileInfoBean ssFileInfoBean)`  L896
- `void showVideoQualityDialog(final ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L902
- `void onCancel(DialogInterface dialogInterface)`  L905 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L911 @Override
- `void onClick(View view)`  L935 @Override
- `void onClick(View view)`  L941 @Override
- `void lambda$showVideoQualityDialog$12(AlertDialog alertDialog, RadioGroup radioGroup, ArrayList arrayList, View view)`  L948
- `String renameToNormalVideoName(String localPath)`  L960
    - 体内字面量："/" · "/" · "s.MP4" · "s.mp4"
- `void startDownloadProcess(SSFileInfoBean ssFileInfoBean)`  L968
- `void startDownloadProcess(ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L974
    - 体内字面量："startDownloadProcess: " · "Video" · "Normal" · "Emr" · "Photo"
- `void onBack()`  L983
    - 体内字面量："123->   onBack"
- `void run()`  L990 @Override
### `com.gku.actioncam.sigmastar.OldUi.playback.presenter.SSPlaybackNewPresenter$AnonymousClass2`
L300 · [class] AnonymousClass2 · implements `SSHttpClientUtil.DownloadCallback` · `com/gku/actioncam/sigmastar/OldUi/playback/presenter/SSPlaybackNewPresenter.java`

字段/常量（15）：
- `int val$count`  L301
- `ArrayList val$ssFileInfoBeans`  L302
- `TextView val$ss_dialog_download_count`  L303
- `ProgressBar val$ss_dialog_download_progress`  L304
- `TextView val$ss_dialog_download_progress_Text`  L305
- `TextView val$ss_dialog_download_text`  L306
- `Handler handler = SSPlaybackNewPresenter.this.mainHandler`  L319
- `TextView textView = this.val$ss_dialog_download_count`  L320
- `int i = this.val$count`  L321
- `ArrayList arrayList = this.val$ssFileInfoBeans`  L322
- `TextView textView2 = this.val$ss_dialog_download_text`  L323
- `Handler handler = SSPlaybackNewPresenter.this.mainHandler`  L344
- `TextView textView = this.val$ss_dialog_download_text`  L345
- `TextView textView2 = this.val$ss_dialog_download_progress_Text`  L346
- `ProgressBar progressBar = this.val$ss_dialog_download_progress`  L347

方法（12）：
- `void startDownload(final String currentPath)`  L318 @Override
- `void run()`  L326 @Override
- `void lambda$startDownload$0(TextView textView, int i, ArrayList arrayList, TextView textView2, String str)`  L333
    - 体内字面量："(" · "/" · ")"
- `void updateProgress(final String savePath, final float progress)`  L343 @Override
- `void run()`  L350 @Override
- `void lambda$updateProgress$1(TextView textView, String str, TextView textView2, float f, ProgressBar progressBar)`  L357
    - 体内字面量："(" · "%.3f" · "%)"
- `void downloadFinish(String savePath)`  L367 @Override
    - 体内字面量："downloadFinish: " · "ç¡®å®"
- `void onCancel(DialogInterface dialogInterface)`  L374 @Override
- `void notEnoughSpace()`  L384 @Override
    - 体内字面量："ç¡®å®"
- `void onCancel(DialogInterface dialogInterface)`  L389 @Override
- `void allTaskFinish()`  L395 @Override
- `void downloadTaskFailure(String path, String errMsg)`  L400 @Override
    - 体内字面量："downloadTaskFailure: "
### `com.gku.actioncam.sigmastar.OldUi.playback.presenter.SSPlaybackNewPresenter$PreviewModelCallback`
L1141 · [class] PreviewModelCallback · implements `ISSPreviewModelCallback` · `com/gku/actioncam/sigmastar/OldUi/playback/presenter/SSPlaybackNewPresenter.java`

方法（13）：
- `void getAllWorkModeSuccess(HashMap<String, ArrayList<String>> allWorkMode)`  L1143 @Override
- `void getBatterySuccess(SSBatteryInfo ssBatteryInfo)`  L1147 @Override
- `void getBluetoothTXSuccess(String tx1Name, String tx2Name)`  L1151 @Override
- `void getCurModeParamSuccess(String param, String itemName)`  L1155 @Override
- `void getCurWorkModeSuccess(String curMode, String params)`  L1159 @Override
- `void getRotateSuccess(int rotate)`  L1163 @Override
- `void getSecondMenuItemSuccess(SSecondItemBean bean, View view)`  L1167 @Override
- `void getTFCardSuccess(SSTFCardInfo tfCardInfo)`  L1171 @Override
- `void httpRequestError(Exception e, String method)`  L1175 @Override
- `void loadCameraInfoSuccess(String requestMethod)`  L1179 @Override
- `void setCurModeParamSuccess(String result, String value)`  L1183 @Override
- `void setSystemTimeSuccess()`  L1187 @Override
- `void getSysWorkstateSuccess(SSystemWorkState sSystemWorkState)`  L1194 @Override
    - 体内字面量："getCurAllInfo: "
### `com.gku.actioncam.sigmastar.OldUi.playback.presenter.SSPlaybackNewPresenter$SSPlaybackModelBack`
L1002 · [class] SSPlaybackModelBack · implements `ISSPlaybackModelCallback` · `com/gku/actioncam/sigmastar/OldUi/playback/presenter/SSPlaybackNewPresenter.java`

方法（14）：
- `void lambda$loadFileInfoSuccess$0(DialogInterface dialogInterface)`  L1003
- `void updateData(ArrayList<SSFileInfoBean> data)`  L1010 @Override
    - 体内字面量："playback.updateData"
- `void loadDataError(Exception e)`  L1019 @Override
    - 体内字面量："playback is null"
- `void loadDataCancel()`  L1030 @Override
- `void loadDataFinish()`  L1038 @Override
- `void startLoadData()`  L1046 @Override
- `void loadThumbSuccess(final String thumbPath, final ImageView imageView, final String videoPath)`  L1054 @Override
- `void run()`  L1057 @Override
    - 体内字面量："è¿ä¸ªåè°èµ°å°SSRemoteSSFragment#åé¨ç±»ISSPlayback#loadThumbSucc"
- `void loadFileInfoSuccess(SSFileInfoBean fileInfo, SSRemoteFileInfo info)`  L1068 @Override
- `void onCancel(DialogInterface dialogInterface)`  L1075 @Override
- `void delFileSuccess(SSFileInfoBean fileInfo, ArrayList<SSFileInfoBean> fileInfoBeanArrayList)`  L1082 @Override
    - 体内字面量："æ¶å°äºå é¤åè°"
- `void delFileError(SSFileInfoBean fileInfo, ArrayList<SSFileInfoBean> fileInfoBeanArrayList)`  L1099 @Override
- `void delFileSuccess(int position, Map<Integer, SSFileInfoBean> fileMap)`  L1113 @Override
    - 体内字面量："fileMapæ¶å°äºå é¤åè°"
- `void delFileError(int position, Map<Integer, SSFileInfoBean> fileMap)`  L1133 @Override
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSDownloadStateDialogActivity`
L25 · [class] public SSDownloadStateDialogActivity · extends `Activity` · `com/gku/actioncam/sigmastar/OldUi/playback/ui/activity/SSDownloadStateDialogActivity.java`

字段/常量（10）：
- `int RESULT_CODE_DOWNLOAD_DIALOG = 87865`  L26
- `String RESULT_DOWNLOAD_DATA = "doneFileList"`  L27
- `String TAG = "SSDownloadStateDialogActivity"`  L28
- `String currentDownloadFile`  L29
- `ArrayList<String> doneFileList`  L30
- `DownloadReceiver downloadReceiver`  L31
- `Button ss_dialog_download_cancel`  L32
- `ProgressBar ss_dialog_download_progress`  L33
- `TextView ss_dialog_download_text`  L34
- `TextView ss_dialog_title`  L35

方法（8）：
- `void finishDialog()`  L66
- `void updateProgress(final SSDownloadState state)`  L74
- `void run()`  L80 @Override
- `void lambda$updateProgress$0(SSDownloadState sSDownloadState)`  L87
    - 体内字面量："(" · "%)"
- `void onCreate(Bundle savedInstanceState)`  L93 @Override
- `void onClick(View view)`  L109 @Override
- `void lambda$onCreate$1(View view)`  L116
    - 体内字面量："ss_dialog_download_cancel" · "undone: "
- `void onDestroy()`  L131 @Override
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSDownloadStateDialogActivity$DownloadReceiver`
L37 · [class] public DownloadReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/sigmastar/OldUi/playback/ui/activity/SSDownloadStateDialogActivity.java`

字段/常量（1）：
- `SSDownloadState sSDownloadState`  L43

方法（2）：
- `public DownloadReceiver()`  L38
- `void onReceive(Context context, Intent intent)`  L42 @Override
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.adapter.PlaybackPreviewPagerAdapter`
L22 · [class] public PlaybackPreviewPagerAdapter · extends `RecyclerView.Adapter<PreviewViewHolder>` · `com/gku/actioncam/sigmastar/OldUi/playback/ui/adapter/PlaybackPreviewPagerAdapter.java`

字段/常量（3）：
- `OnPlaybackPreviewItemClickListener mListener`  L24
- `OnPlaybackPreviewLoadListener mLoadListener`  L25
- `List<SSFileInfoBean> list = this.fileInfoBeanList`  L73

方法（8）：
- `public PlaybackPreviewPagerAdapter(OnPlaybackPreviewItemClickListener listener, OnPlaybackPreviewLoadListener loadListener)`  L35
- `void setFileInfoBeanList(List<SSFileInfoBean> fileInfoBeanList)`  L40
- `SSFileInfoBean get(int position)`  L45
- `void remove(int position)`  L52
- `int getListSize()`  L57
- `PreviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L62 @Override
- `void onBindViewHolder(PreviewViewHolder holder, int position)`  L67 @Override
- `int getItemCount()`  L72 @Override
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.adapter.PlaybackPreviewPagerAdapter$OnPlaybackPreviewItemClickListener`
L27 · [interface] public OnPlaybackPreviewItemClickListener · `com/gku/actioncam/sigmastar/OldUi/playback/ui/adapter/PlaybackPreviewPagerAdapter.java`

方法（1）：
- `void onPlaybackPreviewItemClick(int position)`  L28
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.adapter.PlaybackPreviewPagerAdapter$OnPlaybackPreviewLoadListener`
L31 · [interface] public OnPlaybackPreviewLoadListener · `com/gku/actioncam/sigmastar/OldUi/playback/ui/adapter/PlaybackPreviewPagerAdapter.java`

方法（1）：
- `void onPlaybackPreviewLoadFinish()`  L32
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.adapter.PlaybackPreviewPagerAdapter$PreviewViewHolder`
L80 · [class] PreviewViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/OldUi/playback/ui/adapter/PlaybackPreviewPagerAdapter.java`

字段/常量（1）：
- `PhotoView photoView`  L81

方法（6）：
- `public PreviewViewHolder(View itemView)`  L83
- `void bind(SSFileInfoBean bean, final int position)`  L88
    - 体内字面量：".dng"
- `boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource)`  L97 @Override
- `boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource)`  L102 @Override
- `void onClick(View view)`  L112 @Override
- `void lambda$bind$0(int i, View view)`  L119
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.adapter.SSPlaybackRecycleAdapter`
L32 · [class] public SSPlaybackRecycleAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/OldUi/playback/ui/adapter/SSPlaybackRecycleAdapter.java`

字段/常量（26）：
- `String PAYLOAD_UPDATE_DOWNLOAD = "update_download"`  L33
- `String PAYLOAD_UPDATE_SELECT_STATE = "update_select_state"`  L34
- `String TAG = "SSPlaybackRecycleAdapter"`  L35
- `Context context`  L36
- `ArrayList<SSFileInfoBean> fileInfoList`  L37
- `int imageHeightSize`  L38
- `int imageWidthSize`  L39
- `ILoadThumbnailCallBack loadThumbnailCallBack`  L40
- `OnSSClickListener onSSClickListener`  L41
- `String type`  L42
- `boolean isOpenSelectMode = false`  L43
- `boolean isAllSelect = false`  L44
- `ArrayList<SSFileInfoBean> arrayList = this.fileInfoList`  L59
- `int iIndexOf`  L113
- `ArrayList<SSFileInfoBean> arrayList = this.fileInfoList`  L114
- `ArrayList<SSFileInfoBean> arrayList = this.fileInfoList`  L123
- `int i`  L195
- `String str = TAG`  L197
- `ArrayList<SSFileInfoBean> arrayList = this.fileInfoList`  L200
- `ArrayList<SSFileInfoBean> arrayList2 = this.fileInfoList`  L213
- `Context context`  L256
- `int i`  L257
- `TextView textView = viewHolder.ss_playback_recycle_item_download`  L264
- `OnSSClickListener onSSClickListener = this.onSSClickListener`  L290
- `ArrayList<SSFileInfoBean> arrayList = this.fileInfoList`  L312
- `ArrayList<SSFileInfoBean> arrayList = this.fileInfoList`  L365

方法（35）：
- `int getItemViewType(int position)`  L54 @Override
- `void setThumbPath(String thumbPath, String originalPath)`  L58
- `public SSPlaybackRecycleAdapter(Context context, int imageWidthSize, int imageHeightSize, String type)`  L70
- `void setOnSSClickListener(OnSSClickListener onSSClickListener)`  L77
- `void setLoadThumbnailCallBack(ILoadThumbnailCallBack loadThumbnailCallBack)`  L81
- `void addThumbList(ArrayList<SSFileInfoBean> fileInfoList)`  L85
- `int compare(SSFileInfoBean o1, SSFileInfoBean o2)`  L100 @Override
- `void delFile(SSFileInfoBean ssFileInfoBean)`  L112
- `void setDownloadState(SSFileInfoBean ssFileInfoBean)`  L122
- `boolean isOpenSelectMode()`  L132
- `void setOpenSelectMode(boolean openSelectMode)`  L136
- `void notifyAllDataInMainThread()`  L144
- `void run()`  L147 @Override
- `void notifyDownloadState(final String savePath)`  L153
    - 体内字面量："notifyDownloadState"
- `void run()`  L159 @Override
- `void lambda$notifyDownloadState$0(String str)`  L168
    - 体内字面量："s.MP4" · "s.MP4" · "s.mp4" · "s.mp4" · "_"
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L189 @Override
- `void onBindViewHolder(final ViewHolder holder, int position)`  L194 @Override
- `void run()`  L225 @Override
    - 体内字面量："Video" · "Normal" · "Emr"
- `void onClick(View view)`  L242 @Override
- `boolean onLongClick(View view)`  L248 @Override
- `void lambda$onBindViewHolder$1(SSFileInfoBean sSFileInfoBean, ViewHolder viewHolder)`  L255
- `void lambda$onBindViewHolder$2(SSFileInfoBean sSFileInfoBean, int i, View view)`  L276
    - 体内字面量："payload"
- `boolean lambda$onBindViewHolder$3(SSFileInfoBean sSFileInfoBean, int i, View view)`  L289
- `void onViewRecycled(ViewHolder holder)`  L299 @Override
- `Map<Integer, SSFileInfoBean> getSelectedFileMap()`  L303
- `List<SSFileInfoBean> getSelectFileList()`  L307
- `void allItemSelect(boolean bSelect)`  L311
- `void run()`  L323 @Override
- `void lambda$allItemSelect$4()`  L330
- `void updateSelectFileList(int position, boolean bSelect, SSFileInfoBean ssFileInfoBean)`  L334
- `void addToSelectList(int position, SSFileInfoBean ssFileInfoBean)`  L343
- `void removeFromSelectMap(int position)`  L355
- `void removeFromSelectList(SSFileInfoBean ssFileInfoBean)`  L359
- `int getItemCount()`  L364 @Override
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.adapter.SSPlaybackRecycleAdapter$ILoadThumbnailCallBack`
L49 · [interface] public ILoadThumbnailCallBack · `com/gku/actioncam/sigmastar/OldUi/playback/ui/adapter/SSPlaybackRecycleAdapter.java`

方法（1）：
- `void callBack(String thumbPath, String savePath, String createTime, int position, ImageView view)`  L50
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.adapter.SSPlaybackRecycleAdapter$ViewHolder`
L372 · [class] public static ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/OldUi/playback/ui/adapter/SSPlaybackRecycleAdapter.java`

字段/常量（5）：
- `ImageView ss_playback_item_select_image`  L373
- `TextView ss_playback_recycle_item_download`  L374
- `PlaybackImageView ss_playback_recycle_item_image`  L375
- `ImageView ss_playback_recycle_item_play`  L376
- `TextView ss_playback_recycle_item_time`  L377

方法（1）：
- `public ViewHolder(View itemView)`  L379
### `com.gku.actioncam.sigmastar.OldUi.playback.ui.viewpager.VideoViewPager`
L8 · [class] public VideoViewPager · extends `ViewPager` · `com/gku/actioncam/sigmastar/OldUi/playback/ui/viewpager/VideoViewPager.java`

方法（1）：
- `public VideoViewPager(Context context, AttributeSet attributeSet)`  L9
### `com.gku.actioncam.sigmastar.OldUi.preview.model.AmbaPreviewModel`
L46 · [class] public AmbaPreviewModel · implements `ISSPreviewModel, IChannelListener` · `com/gku/actioncam/sigmastar/OldUi/preview/model/AmbaPreviewModel.java`

字段/常量（26）：
- `String TAG = "AmbaPreviewModel"`  L47
- `String cameraInfoRequestMethod`  L48
- `ISSPreviewModelCallback mCallback`  L49
- `Handler mHandler`  L50
- `HttpRequestUtils.StringCallBack mSetCurModeCallBack`  L51
- `View popView`  L52
- `boolean recordStateChanged = true`  L53
- `boolean isLayoutSetCaptureClick = false`  L54
- `String string`  L107
- `String[] strArrSplit = new String[0]`  L108
- `String string`  L142
- `String[] strArrSplit = new String[0]`  L143
- `String str = strArr[0]`  L532
- `String str2 = strArr[1]`  L533
- `String str3 = strArr[0]`  L547
- `String str4 = null`  L554
- `String str5 = strArr[0]`  L583
- `String str6 = strArr[1]`  L584
- `String str7 = strArr[0]`  L618
- `String str8 = strArr[0]`  L629
- `String str9 = strArr[0]`  L662
- `String str10 = strArr[1]`  L663
- `String str11 = strArr[2]`  L664
- `String str12 = strArr[0]`  L679
- `String str13 = strArr[1]`  L680
- `String str14 = strArr[2]`  L681

方法（78）：
- `void exitQuickRec()`  L57 @Override
- `void startRecord()`  L61 @Override
- `void stopPhoto()`  L65 @Override
- `void stopRecord()`  L69 @Override
- `void takePhoto()`  L73 @Override
- `public AmbaPreviewModel(ISSPreviewModelCallback mCallback)`  L76
- `void requestPreviewParams()`  L85 @Override
    - 体内字面量："requestPreviewParamssadasfa: " · "XTUS6Pro"
- `void getSecondMenuItem(String curWorkMode, final String itemName, View view)`  L97 @Override
    - 体内字面量："123->" · "getSecondMenuItem  isLayoutSetCaptureClick=" · "  itemName="
- `void success()`  L106 @Override
- `void failure(int code)`  L130 @Override
    - 体内字面量："getSecondMenuItem"
- `void getCurModeParam(String curWorkMode, final String itemName)`  L138 @Override
- `void success()`  L141 @Override
- `void failure(int code)`  L165 @Override
    - 体内字面量："getSecondMenuItem"
- `void setCurModeParam(String workMode, String itemName, String value)`  L172 @Override
- `void success()`  L175 @Override
- `void failure(int code)`  L179 @Override
    - 体内字面量："setCurModeParam"
- `void getAllWorkMode()`  L186 @Override
- `void success()`  L189 @Override
- `void failure(int code)`  L193 @Override
    - 体内字面量："getAllWorkMode"
- `void getCurWorkMode()`  L200 @Override
- `void success()`  L203 @Override
- `void failure(int code)`  L207 @Override
    - 体内字面量："getCurWorkMode"
- `void getBattery()`  L214 @Override
- `void success()`  L217 @Override
- `void failure(int code)`  L221 @Override
    - 体内字面量："getBatteryInfo"
- `void getTFCard()`  L228 @Override
- `void success()`  L231 @Override
- `void failure(int code)`  L235 @Override
    - 体内字面量："getSDState"
- `void getRotate()`  L242 @Override
- `void success()`  L245 @Override
- `void failure(int code)`  L249 @Override
    - 体内字面量："getRotate"
- `void getBluetoothTX()`  L256 @Override
- `void success()`  L259 @Override
- `void failure(int code)`  L263 @Override
    - 体内字面量："getBluetoothTX"
- `void pairAndGetBluetoothTX()`  L270 @Override
- `void success()`  L273 @Override
- `void failure(int code)`  L277 @Override
    - 体内字面量："getBluetoothTX"
- `void setSystemTime()`  L284 @Override
    - 体内字面量："yyyyMMddHHmmss"
- `void failure(int code)`  L287 @Override
- `void success()`  L291 @Override
    - 体内字面量："set setsystime success!"
- `void setSystemTimeZone()`  L297
- `void failure(int code)`  L300 @Override
- `void success()`  L304 @Override
    - 体内字面量："set setsystime success!"
- `void getSysWorkstate()`  L311 @Override
    - 体内字面量："getSystemWorkState åéè¯·æ±"
- `void success()`  L315 @Override
    - 体内字面量："getSystemWorkState success!"
- `void failure(int code)`  L320 @Override
    - 体内字面量："getSystemWorkState"
- `void quickStoriesAddTime()`  L327 @Override
- `void success()`  L330 @Override
- `void failure(int code)`  L334 @Override
    - 体内字面量："qsAddTime"
- `void setCurMode(String mode, HttpRequestUtils.StringCallBack callBack)`  L341 @Override
- `void success()`  L346 @Override
    - 体内字面量："setCurMode success"
- `void failure(int code)`  L351 @Override
    - 体内字面量："setCurMode failure" · "setCurWorkMode"
- `void commandOperation(HashMap<String, ArrayList<String>> allWorkMode, String curWorkMode, SSystemWorkState workState)`  L360 @Override
    - 体内字面量："51" · "!recordStateChanged" · "commandOperation" · "record_start"
- `void success()`  L371 @Override
- `void failure(int code)`  L377 @Override
    - 体内字面量："record_start" · "commandOperation" · "record_stop"
- `void success()`  L389 @Override
- `void failure(int code)`  L395 @Override
    - 体内字面量："record_stop" · "takePhoto   allWorkMode=" · "  curWorkMode=" · "  workState="
- `void success()`  L410 @Override
    - 体内字面量："takePhoto is success"
- `void failure(int code)`  L416 @Override
    - 体内字面量："takePhoto" · "takePhoto  SS_STATE_WORKING"
- `void success()`  L427 @Override
    - 体内字面量："stopPhoto is success"
- `void failure(int code)`  L433 @Override
    - 体内字面量："stopPhoto"
- `void success()`  L440 @Override
    - 体内字面量："stopPhoto is success"
- `void failure(int code)`  L446 @Override
    - 体内字面量："stopPhoto"
- `void loadCameraInfo(String requestMethod)`  L456 @Override
- `void success()`  L460 @Override
    - 体内字面量："getDeviceInfo success"
- `void failure(int code)`  L465 @Override
    - 体内字面量："getDeviceInfo failure" · "failure"
- `void onChannelEvent(int i, Object obj, String... strArr)`  L473 @Override
    - 体内字面量："type=" · "param=" · "array=" · "onChannelEvent: getDeviceInfo: è·åè®¾å¤ä¿¡æ¯" · "G" · "V1.0"
- `void run()`  L511 @Override
    - 体内字面量："onChannelEvent: startSession: å¼å¯åè¯" · "onChannelEvent: sync system time"
- `void run()`  L525 @Override
- `void run()`  L537 @Override
- `void run()`  L557 @Override
    - 体内字面量："SDå¡ç©ºé´ä¸è¶³" · "getTFCard"
- `void run()`  L569 @Override
    - 体内字面量："onChannelEvent: è·åææå·¥ä½æ¨¡å¼ type=48"
- `void run()`  L605 @Override
    - 体内字面量："onChannelEvent: è·åå½åå·¥ä½æ¨¡å¼ type=48" · "onChannelEvent: è·åå½åå·¥ä½æ¨¡å¼ workMode="
- `void run()`  L621 @Override
    - 体内字面量："onChannelEvent: è®¾ç½®å½åå·¥ä½æ¨¡å¼ type=50" · "onChannelEvent: è®¾ç½®å½åå·¥ä½æ¨¡å¼ mode="
- `void run()`  L635 @Override
    - 体内字面量："onChannelEvent: è·åç³»ç»å·¥ä½ç¶æ (SyncStateMessageStr) param=" · "----------"
- `void run()`  L655 @Override
    - 体内字面量："onChannelEvent: è·åçµéä¿¡æ¯ type=57"
- `void run()`  L671 @Override
    - 体内字面量："onChannelEvent: è·åçµéä¿¡æ¯ getBatteryInfo=" · "onChannelEvent: è·åsdå¡ç¶æ type=57"
- `void run()`  L703 @Override
    - 体内字面量："onChannelEvent: è·åsdå¡ç¶æ tfCardInfo="
### `com.gku.actioncam.sigmastar.OldUi.preview.model.HaisiPreviewModel`
L30 · [class] public HaisiPreviewModel · implements `ISSPreviewModel` · `com/gku/actioncam/sigmastar/OldUi/preview/model/HaisiPreviewModel.java`

字段/常量（4）：
- `String TAG = "SigmastartPreviewModel"`  L31
- `ISSPreviewModelCallback mCallback`  L32
- `int i = 1`  L341
- `int i2 = CameraParmeras.CAMERA_STATE_WORKING_STR`  L366

方法（56）：
- `void getBluetoothTX()`  L35 @Override
- `void pairAndGetBluetoothTX()`  L39 @Override
- `void startRecord()`  L43 @Override
- `void stopPhoto()`  L47 @Override
- `void stopRecord()`  L51 @Override
- `void takePhoto()`  L55 @Override
- `public HaisiPreviewModel(ISSPreviewModelCallback mCallback)`  L58
- `void requestPreviewParams()`  L63 @Override
- `void getSecondMenuItem(String curWorkMode, String itemName, final View view)`  L71 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L74 @Override
- `void onFail(Call call, int code, String errorMsg)`  L79 @Override
    - 体内字面量："getSecondMenuItem"
- `void getCurModeParam(String curWorkMode, final String itemName)`  L86 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L89 @Override
    - 体内字面量："Resolution"
- `void onFail(Call call, int code, String errorMsg)`  L98 @Override
    - 体内字面量："getCurModeParam"
- `void setCurModeParam(String workMode, String itemName, final String value)`  L105 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L108 @Override
- `void onFail(Call call, int code, String errorMsg)`  L113 @Override
    - 体内字面量："getCurModeParam"
- `void getAllWorkMode()`  L120 @Override
    - 体内字面量："haisi getAll getCurWo"
- `void onSuccess(Call call, String responseBody, Response response)`  L124 @Override
- `void onFail(Call call, int code, String errorMsg)`  L130 @Override
    - 体内字面量："getAllWorkMode"
- `void getCurWorkMode()`  L137 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L140 @Override
    - 体内字面量："workmode" · "value"
- `void onFail(Call call, int code, String errorMsg)`  L148 @Override
    - 体内字面量："getCurWorkMode"
- `void getBattery()`  L155 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L158 @Override
- `void onFail(Call call, int code, String errorMsg)`  L163 @Override
    - 体内字面量："getBattery"
- `SSTFCardInfo parseTFCardInfo(String content)`  L170
    - 体内字面量："sdstate" · "sdstate" · "total" · "used" · "SDOK" · "SDFULL" · "SDNONE" · "SDERROR" · " MB" · " MB"
- `void getTFCard()`  L205 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L208 @Override
- `void onFail(Call call, int code, String errorMsg)`  L213 @Override
    - 体内字面量："getTFCard"
- `void setSystemTime()`  L220 @Override
    - 体内字面量："yyyyMMddHHmmss"
- `void onSuccess(Call call, String responseBody, Response response)`  L223 @Override
    - 体内字面量："sethisisystemtime"
- `void onFail(Call call, int code, String errorMsg)`  L233 @Override
    - 体内字面量："setSystemTime"
- `SSystemWorkState parseSystemWorkState(String content)`  L240
    - 体内字面量："mode" · "state" · "event" · "pasttime"
- `int parseRotate(String content)`  L249
- `void getSysWorkstate()`  L263 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L266 @Override
- `void onFail(Call call, int code, String errorMsg)`  L271 @Override
    - 体内字面量："getSysWorkstate"
- `void getRotate()`  L278 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L281 @Override
    - 体内字面量："getRotate onSuccess: "
- `void onFail(Call call, int code, String errorMsg)`  L287 @Override
    - 体内字面量："getRotate"
- `void exitQuickRec()`  L294 @Override
- `void onFail(Call call, int code, String errorMsg)`  L297 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L301 @Override
- `void quickStoriesAddTime()`  L307 @Override
- `void onFail(Call call, int code, String errorMsg)`  L310 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L314 @Override
- `void setCurMode(String mode, final HttpRequestUtils.StringCallBack callBack)`  L320 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L324 @Override
- `void onFail(Call call, int code, String errorMsg)`  L330 @Override
- `void commandOperation(HashMap<String, ArrayList<String>> allWorkMode, String curWorkMode, SSystemWorkState workState)`  L340 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L385 @Override
    - 体内字面量："commandOperation ASSADASFSA" · "result=="
- `void onFail(Call call, int code, String errorMsg)`  L390 @Override
    - 体内字面量："commandOperation ASSADASFSA"
- `void loadCameraInfo(final String requestMethod)`  L397 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L400 @Override
- `void onFail(Call call, int code, String errorMsg)`  L405 @Override
    - 体内字面量："loadCameraInfo"
### `com.gku.actioncam.sigmastar.OldUi.preview.model.PreviewModelManage`
L11 · [class] public PreviewModelManage · `com/gku/actioncam/sigmastar/OldUi/preview/model/PreviewModelManage.java`

字段/常量（3）：
- `String TAG = "PreviewModelManage"`  L12
- `CameraInfors cameraInfors`  L13
- `ISSPreviewModel previewModelImp`  L14

方法（2）：
- `public PreviewModelManage(ISSPreviewModelCallback callback)`  L16
    - 体内字面量："CV75" · "è·åç¸æºåæ°å¤±è´¥"
- `ISSPreviewModel getModel()`  L34
### `com.gku.actioncam.sigmastar.OldUi.preview.model.SigmastartPreviewModel`
L21 · [class] public SigmastartPreviewModel · implements `ISSPreviewModel` · `com/gku/actioncam/sigmastar/OldUi/preview/model/SigmastartPreviewModel.java`

字段/常量（2）：
- `String TAG = "SigmastartPreviewModel"`  L22
- `ISSPreviewModelCallback mCallback`  L23

方法（57）：
- `void getBluetoothTX()`  L26 @Override
- `void getRotate()`  L30 @Override
- `void pairAndGetBluetoothTX()`  L34 @Override
- `public SigmastartPreviewModel(ISSPreviewModelCallback mCallback)`  L37
- `void requestPreviewParams()`  L42 @Override
- `void getSecondMenuItem(String curWorkMode, String itemName, final View view)`  L50 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L53 @Override
- `void onFail(Call call, int code, String errorMsg)`  L58 @Override
    - 体内字面量："getSecondMenuItem"
- `void getCurModeParam(String curWorkMode, final String itemName)`  L65 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L68 @Override
    - 体内字面量："Resolution"
- `void onFail(Call call, int code, String errorMsg)`  L77 @Override
    - 体内字面量："getCurModeParam"
- `void setCurModeParam(String workMode, String itemName, final String value)`  L84 @Override
- `void onFail(Call call, int code, String errorMsg)`  L87 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L91 @Override
- `void getAllWorkMode()`  L98 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L101 @Override
- `void onFail(Call call, int code, String errorMsg)`  L107 @Override
    - 体内字面量："getAllWorkMode"
- `void getCurWorkMode()`  L114 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L117 @Override
- `void onFail(Call call, int code, String errorMsg)`  L122 @Override
    - 体内字面量："getCurWorkMode"
- `void getBattery()`  L129 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L132 @Override
- `void onFail(Call call, int code, String errorMsg)`  L137 @Override
    - 体内字面量："getBattery"
- `void getTFCard()`  L144 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L147 @Override
- `void onFail(Call call, int code, String errorMsg)`  L152 @Override
    - 体内字面量："getTFCard"
- `void setSystemTime()`  L159 @Override
    - 体内字面量："yyyyMMddHHmmss"
- `void onSuccess(Call call, String responseBody, Response response)`  L162 @Override
- `void onFail(Call call, int code, String errorMsg)`  L171 @Override
    - 体内字面量："setSystemTime"
- `void getSysWorkstate()`  L178 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L181 @Override
- `void onFail(Call call, int code, String errorMsg)`  L186 @Override
    - 体内字面量："getSysWorkstate"
- `void startRecord()`  L193 @Override
- `void onFail(Call call, int code, String errorMsg)`  L196 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L200 @Override
- `void stopRecord()`  L206 @Override
- `void onFail(Call call, int code, String errorMsg)`  L209 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L213 @Override
- `void takePhoto()`  L219 @Override
- `void onFail(Call call, int code, String errorMsg)`  L222 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L226 @Override
- `void stopPhoto()`  L232 @Override
- `void onFail(Call call, int code, String errorMsg)`  L235 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L239 @Override
- `void exitQuickRec()`  L245 @Override
- `void onFail(Call call, int code, String errorMsg)`  L248 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L252 @Override
- `void quickStoriesAddTime()`  L258 @Override
- `void onFail(Call call, int code, String errorMsg)`  L261 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L265 @Override
- `void setCurMode(String mode, final HttpRequestUtils.StringCallBack callBack)`  L271 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L275 @Override
- `void onFail(Call call, int code, String errorMsg)`  L280 @Override
- `void commandOperation(HashMap<String, ArrayList<String>> allWorkMode, String curWorkMode, SSystemWorkState workState)`  L287 @Override
- `void loadCameraInfo(final String requestMethod)`  L310 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L313 @Override
- `void onFail(Call call, int code, String errorMsg)`  L318 @Override
    - 体内字面量："loadCameraInfo"
### `com.gku.actioncam.sigmastar.OldUi.preview.presenter.ActionCameraPreviewPresenter`
L45 · [class] public ActionCameraPreviewPresenter · `com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java`

字段/常量（43）：
- `String TAG = "ActionCameraPreviewPresenter"`  L46
- `int WHAT_BATTERY_POLLING = 211059`  L47
- `int WHAT_SD_POLLING = 211058`  L48
- `CameraBaseActivity activity`  L49
- `HashMap<String, ArrayList<String>> allWorkMode`  L50
- `SSBatteryInfo batteryInfo`  L51
- `Handler batteryPolling`  L52
- `String curworkModeItemData`  L53
- `String fastSettingValue`  L54
- `int ivCommandRes`  L55
- `Context mContext`  L56
- `Handler mHandler`  L57
- `String mModelName`  L58
- `String mSoftVersion`  L59
- `int modeImageRes`  L60
- `ISSPreviewNew preview`  L61
- `PreviewModelManage previewModelManage`  L62
- `RecordCountDownTimer recordCountDownTimer`  L63
- `String resolutionString`  L64
- `Handler sdCardPolling`  L65
- `SSFastSettingPopupWindow ssFastSettingPopupWindow`  L66
- `SSModeSelectPopupWindow ssModeSelectPopupWindow`  L67
- `SSTFCardInfo tfCardInfo`  L68
- `WifiManager wifiManager`  L69
- `WifiSignalReceiver wifiSignalReceiver`  L70
- `SSystemWorkState workState`  L71
- `String curWorkMode = "<binary/metadata>"`  L72
- `int quickStoriesRecordTime = 0`  L73
- `int timingPhotoTime = 0`  L74
- `int quickStoriesAddTime = 0`  L75
- `long lastRequest = 0`  L76
- `boolean isSetFastSettingPopup = false`  L77
- `SyncStateMessageStr syncStateMessageStr = null`  L104
- `WifiSignalReceiver wifiSignalReceiver = this.wifiSignalReceiver`  L190
- `String str = TAG`  L206
- `RecordCountDownTimer recordCountDownTimer = this.recordCountDownTimer`  L229
- `SSModeSelectPopupWindow sSModeSelectPopupWindow = this.ssModeSelectPopupWindow`  L280
- `String str = TAG`  L346
- `String fastSettingCurParamName = this.curworkModeItemData`  L352
- `SSFastSettingPopupWindow sSFastSettingPopupWindow = this.ssFastSettingPopupWindow`  L360
- `int i = time / 3600`  L429
- `int i2 = time % 3600`  L430
- `SSystemWorkState sSystemWorkState = this.workState`  L435

方法（44）：
- `void registerMessageReceiver()`  L80
- `void startBatteryPolling()`  L83
- `void startSDCardPolling()`  L86
- `void stopBatteryPolling()`  L89
- `void stopSDCardPolling()`  L92
- `public ActionCameraPreviewPresenter(CameraBaseActivity activity, String modelName, String softVersion)`  L95
- `void callback(String msg)`  L103 @Override
- `void setView(ISSPreviewNew preview)`  L146
- `void onReceive(String msg)`  L150
- `void registerAndUpdateWifi()`  L172
    - 体内字面量："android.net.wifi.RSSI_CHANGED" · "android.net.wifi.STATE_CHANGE" · "wifi"
- `void unRegisterWifi()`  L189
- `void startRecordCountDownForTimePhoto(int currentTime)`  L197
- `void startRecordCountDown(int currentTime)`  L204
- `void run()`  L211 @Override
    - 体内字面量："ASFASFASFASGSGA : 0" · "ASFASFASFASGSGA : 2"
- `void lambda$startRecordCountDown$0()`  L224
- `boolean finishRecordCountDown()`  L228
- `void showModeSelectPopupWindow(final View view)`  L274
    - 体内字面量："showModeSelectPopupWindow" · "onClick: " · "showModeSelectPopupWindow: " · "\n"
- `void onSelect(final String mode)`  L287 @Override
    - 体内字面量："showModeSelectPopupWindow onSelect"
- `void onSuccess(String result)`  L291 @Override
    - 体内字面量："showModeSelectPopupWindow onSelect onSuccess"
- `void onBefore()`  L304 @Override
    - 体内字面量："showModeSelectPopupWindow onSelect onBefore"
- `void onError(int code, Exception e)`  L311 @Override
    - 体内字面量：":" · "showModeSelectPopupWindow onSelect onError"
- `void run()`  L322 @Override
- `void lambda$showModeSelectPopupWindow$1(View view)`  L329
- `void subscribeScreenRotate()`  L333
- `void loadBluetoothTX()`  L337
- `void pairAndLoadBluetoothTX()`  L341
- `void showFastSettingPopupWindow(Context context, View view)`  L345
- `void requestCurWorkModeParams(String curWorkMode)`  L367
    - 体内字面量："Resolution"
- `void requestPreviewParams()`  L375
    - 体内字面量："è¯·å¨ç³»ç»wifiéæ°è¿æ¥ç¸æº"
- `void getSysWorkstate()`  L383
- `void getCurWorkMode()`  L387
- `void updateTFCard()`  L391
- `void updateBattery()`  L395
- `void exitQuickRec()`  L399
- `void quickStoriesAddTime()`  L403
- `void commandOperation()`  L407
- `SSystemWorkState getWorkState()`  L416
- `HashMap<String, ArrayList<String>> getAllWorkMode()`  L420
- `String getCurworkModeItemData()`  L424
- `String time2String(int time)`  L428
- `void screenRotateOperate()`  L434
- `void screenRotateDisable(OrientationDetector orientationDetector)`  L448
- `void screenRotateEnable(OrientationDetector orientationDetector)`  L455
- `void loadCameraInfo(String requestMethod)`  L459
### `com.gku.actioncam.sigmastar.OldUi.preview.presenter.ActionCameraPreviewPresenter$PreviewModelCallback`
L463 · [class] PreviewModelCallback · implements `ISSPreviewModelCallback` · `com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java`

字段/常量（2）：
- `ActionCameraPreviewPresenter actionCameraPreviewPresenter = ActionCameraPreviewPresenter.this`  L517
- `ActionCameraPreviewPresenter actionCameraPreviewPresenter = ActionCameraPreviewPresenter.this`  L729

方法（19）：
- `void getSecondMenuItemSuccess(SSecondItemBean bean, View view)`  L468 @Override
- `void onClick(String workMode, String itemName, String value)`  L472 @Override
    - 体内字面量："getSecondMenuItemSuccess: dlskgtuyfjfdggdgdsfg"
- `void getCurModeParamSuccess(String value, String itemName)`  L492 @Override
    - 体内字面量："getCurModeParamSucc: " · ":" · "Resolution" · "Sec"
- `void setCurModeParamSuccess(String result, final String value)`  L542 @Override
    - 体内字面量："123->" · "setCurModeParamSuccess  result=" · "  value="
- `void run()`  L552 @Override
- `void lambda$setCurModeParamSuccess$0(String str)`  L559
    - 体内字面量："Sec" · "Sec" · " =========setCurModeParamSuccess" · "sec" · " =========initIjkVideoView SAFAFAF 5"
- `void getAllWorkModeSuccess(HashMap<String, ArrayList<String>> allMode)`  L589 @Override
    - 体内字面量："\\." · "V2.1.1.5-A" · "V2.1.1.5-A" · "123->" · "==========mModelName=" · "mSoftVersion=" · " allWorkMode=" · "H22IMX377" · "20220702" · "photo"
- `void run()`  L612 @Override
- `void getCurWorkModeSuccess(String curMode, String params)`  L620 @Override
    - 体内字面量："H22IMX377" · "20220702" · "getCurWorkMode: "
- `void getTFCardSuccess(SSTFCardInfo cardInfo)`  L662 @Override
- `void getBatterySuccess(SSBatteryInfo ssBatteryInfo)`  L675 @Override
    - 体内字面量："getBatteryInfo: "
- `void setSystemTimeSuccess()`  L688 @Override
- `void getSysWorkstateSuccess(SSystemWorkState sSystemWorkState)`  L696 @Override
    - 体内字面量："getCurAllInfo: "
- `void run()`  L710 @Override
    - 体内字面量："123->" · "cameraInfors.getType()=" · "CV75" · "amba getSysPastTime / 2"
- `void lambda$getSysWorkstateSuccess$1()`  L743
- `void getRotateSuccess(int rotate)`  L748 @Override
- `void getBluetoothTXSuccess(String tx1Name, String tx2Name)`  L753 @Override
- `void loadCameraInfoSuccess(String requestMethod)`  L758 @Override
    - 体内字面量："Exception in loadCameraInfoSucc: "
- `void httpRequestError(Exception e, String method)`  L767 @Override
    - 体内字面量："123->" · " httpRequestError  method=" · ":" · "getBattery" · "getCurModeParam" · "getTFCard" · "setCurModeParam"
### `com.gku.actioncam.sigmastar.OldUi.preview.presenter.ActionCameraPreviewPresenter$RecordCountDownTimer`
L239 · [class] private RecordCountDownTimer · extends `CountDownTimer` · `com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java`

字段/常量（2）：
- `int currentTime`  L240
- `int i = this.currentTime`  L255

方法（3）：
- `public RecordCountDownTimer(int currentTime)`  L242
- `void onTick(long millisUntilFinished)`  L248 @Override
- `void onFinish()`  L269 @Override
### `com.gku.actioncam.sigmastar.OldUi.preview.presenter.ActionCameraPreviewPresenter$WifiSignalReceiver`
L158 · [class] private WifiSignalReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java`

方法（2）：
- `private WifiSignalReceiver()`  L159
- `void onReceive(Context context, Intent intent)`  L163 @Override
    - 体内字面量："android.net.wifi.RSSI_CHANGED"
### `com.gku.actioncam.sigmastar.OldUi.preview.ui.activity.AmbaActionCameraPreviewActivity`
L85 · [class] public AmbaActionCameraPreviewActivity · extends `CameraBaseActivity implements ISSPreviewNew, IChannelListener` · implements `ISSPreviewNew, IChannelListener` · `com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java`

字段/常量（89）：
- `int HANDLER_WHAT_HIDE_MAIN_UI = 1320`  L86
- `int HANDLER_WHAT_SHOW_MAIN_UI = 1319`  L87
- `int STATE_RECORDING = 1`  L88
- `int STATE_UNRECORDING = 0`  L89
- `String TAG = "SSPreviewNewActivity"`  L90
- `String TAG_SS_PREVIEW_SAVE = "ss_preview_save"`  L91
- `boolean curActivityIsVis`  L92
- `ImageView ivBackPreview`  L93
- `ImageView ivModeMore`  L94
- `ImageView ivSavedSign`  L95
- `ImageView iv_capture`  L96
- `LoadingDialog loadingDialog`  L97
- `String mModelName`  L98
- `String mSoftVersion`  L99
- `ActionCameraPreviewPresenter presenter`  L100
- `FrameLayout preview_container`  L101
- `ImageView preview_cover`  L102
- `VideoTextureView preview_texture_video_view`  L103
- `Bundle savedInstanceState`  L104
- `ImageView ss_preview_content_battery_capacity`  L105
- `ImageView ss_preview_content_bluetooth_tx`  L106
- `ImageView ss_preview_content_browse_file`  L107
- `RelativeLayout ss_preview_content_capture`  L108
- `ImageView ss_preview_content_exit_quick_video`  L109
- `TextView ss_preview_content_info`  L110
- `LinearLayout ss_preview_content_layout_info`  L111
- `ImageView ss_preview_content_loop_recording`  L112
- `ImageView ss_preview_content_main_logo`  L113
- `ImageView ss_preview_content_mode_menu`  L114
- `ImageView ss_preview_content_record_sign`  L115
- `TextView ss_preview_content_record_time`  L116
- `RelativeLayout ss_preview_content_record_time_bar`  L117
- `TextView ss_preview_content_resolution`  L118
- `ImageView ss_preview_content_setting`  L119
- `RelativeLayout ss_preview_content_setting_bar`  L120
- `ImageView ss_preview_content_short_video_add_time`  L121
- `TextView ss_preview_content_short_video_add_time_text`  L122
- `TextView ss_preview_content_short_video_time_text`  L123
- `TextView ss_preview_content_storage_available`  L124
- `ProgressBar ss_preview_content_storage_usage`  L125
- `ImageView ss_preview_content_type`  L126
- `ImageView ss_preview_content_wifi_signal`  L127
- `FrameLayout ss_preview_main`  L128
- `RelativeLayout ss_preview_set_mode`  L129
- `StateView sv_message`  L130
- `AlertDialog tipsDialog`  L131
- `TextView tvPrompt`  L132
- `String flipValue = "0Â°"`  L133
- `int mRotate = 0`  L134
- `float mScale = 1.0f`  L135
- `boolean isPulling = false`  L136
- `boolean viewRendered = false`  L145
- `boolean backEnable = true`  L146
- `boolean hasStartPlay = true`  L164
- `boolean isInitIjkPlayer = false`  L165
- `boolean videoRenderingStart = false`  L166
- `long lastStreamTime = 0`  L167
- `boolean needTips = true`  L169
- `int i = msg.what`  L200
- `int rawRotate = -1`  L233
- `ActionCameraPreviewPresenter actionCameraPreviewPresenter = this.presenter`  L302
- `SSystemWorkState sSystemWorkState = this.presenter.workState`  L333
- `ActionCameraPreviewPresenter actionCameraPreviewPresenter = this.presenter`  L364
- `AlertDialog alertDialog = this.tipsDialog`  L369
- `String[] strArr`  L508
- `ActionCameraPreviewPresenter actionCameraPreviewPresenter = AmbaActionCameraPreviewActivity.this.presenter`  L553
- `AmbaActionCameraPreviewActivity ambaActionCameraPreviewActivity = AmbaActionCameraPreviewActivity.this`  L554
- `SSPreviewSaveInfo sSPreviewSaveInfo`  L616
- `Bundle bundle = this.savedInstanceState`  L618
- `Bitmap bitmap`  L679
- `int i = this.mRotate`  L688
- `float f = this.mScale`  L694
- `FrameLayout frameLayout = this.preview_container`  L831
- `VideoTextureView videoTextureView = this.preview_texture_video_view`  L837
- `Handler handler = this.mainUIUpdateHandler`  L884
- `Handler handler = this.mainUIUpdateHandler`  L894
- `int i = tfCardInfo.total`  L915
- `int i2 = tfCardInfo.used`  L916
- `ProgressBar progressBar = this.ss_preview_content_storage_usage`  L925
- `ImageView imageView = this.ss_preview_content_battery_capacity`  L952
- `TextView textView = this.ss_preview_content_resolution`  L975
- `RelativeLayout relativeLayout = this.ss_preview_content_capture`  L1108
- `String str = this.presenter.curWorkMode`  L1294
- `RelativeLayout relativeLayout = this.ss_preview_content_record_time_bar`  L1347
- `RelativeLayout relativeLayout = this.ss_preview_content_record_time_bar`  L1362
- `TextView textView = this.ss_preview_content_record_time`  L1375
- `boolean z = newConfig.orientation == 2`  L1412
- `VideoTextureView videoTextureView = this.preview_texture_video_view`  L1413
- `String str = array[0]`  L1434

方法（95）：
- `void run()`  L139 @Override
- `void run()`  L149 @Override
    - 体内字面量：" =========initIjkVideoView SAFAFAF 2"
- `void run()`  L156 @Override
    - 体内字面量："4K60" · "4K30" · " =========initIjkVideoView SAFAFAF 3"
- `void run()`  L172 @Override
    - 体内字面量："ijkMediaPlayer live å¡ä½éæ°æ­æ¾"
- `void run()`  L179 @Override
    - 体内字面量：" =========initIjkVideoView SAFAFAF 4"
- `void handleMessage(Message msg)`  L198 @Override
- `void onProgressCancelListener(DialogInterface dialog)`  L236 @Override
- `void updateWiFiLevel(int level)`  L240 @Override
- `void startPolling()`  L243
- `void stopPolling()`  L251
- `void onSaveInstanceState(Bundle outState)`  L257 @Override
    - 体内字面量："ss_preview_save"
- `void onCreate(Bundle savedInstanceState)`  L263 @Override
    - 体内字面量："onCreateonCreateonCreate" · "PreViewFlip" · "PreViewFlip" · "needShowPreviewTips"
- `void onClick(DialogInterface dialog, int which)`  L275 @Override
- `void onClick(DialogInterface dialog, int which)`  L279 @Override
    - 体内字面量："needShowPreviewTips" · "FLIP"
- `void success()`  L288 @Override
    - 体内字面量："è·åç¿»è½¬ä¿¡æ¯æåï¼"
- `void failure(int code)`  L293 @Override
    - 体内字面量："è·åç¿»è½¬ä¿¡æ¯å¤±è´¥ï¼"
- `void onStart()`  L300 @Override
- `void onResume()`  L310 @Override
    - 体内字面量：" =========initIjkVideoView SAFAFAF  1" · " =========onResume()  initIjkVideoView(0)"
- `void onPause()`  L322 @Override
- `void onBackPressed()`  L331 @Override
- `void onStop()`  L351 @Override
    - 体内字面量："onStop"
- `void onDestroy()`  L357 @Override
    - 体内字面量："onDestroy"
- `void onMessageEvent(FlipMessageEvent event)`  L377 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："onMessageEvent: flipValue = "
- `void onMessageEvent2(MessageEvent messageEvent)`  L385 @Subscribe(threadMode = ThreadMode.MAIN)
- `void run()`  L394 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L408 @Override
    - 体内字面量："onActivityResult: 1" · "ss_preview_save"
- `void initPresenter()`  L430
    - 体内字面量："modelNameAndSoftVersion" · "modelName" · "softVersion" · "\\." · "H22IMX377" · "20220702"
- `void initView()`  L447 @Override
- `void onClick(View v)`  L483 @Override
    - 体内字面量："video" · "video"
- `void onClick(View v)`  L496 @Override
    - 体内字面量："Stop Record"
- `void onClick(View v)`  L507 @Override
- `void onClick(View v)`  L534 @Override
    - 体内字面量："ivSettings"
- `void onClick(View v)`  L547 @Override
- `void onClick(View v)`  L560 @Override
- `void onClick(View v)`  L578 @Override
- `void onClick(View v)`  L585 @Override
- `void onClick(View v)`  L596 @Override
    - 体内字面量："CV75" · "initView: "
- `void addData()`  L615 @Override
- `void updateUIBySaveState(SSPreviewSaveInfo ssPreviewSaveInfo)`  L628
- `void runRefView()`  L655
- `void stoprunRefView()`  L659
- `void runTask()`  L663
    - 体内字面量："runTask"
- `void initIjkVideoView(int time)`  L670 @Override
    - 体内字面量：" =========initIjkVideoView SAFAFAF"
- `void initIjkVideoView2(int time)`  L678
- `void startCheck()`  L825
- `void destroyVideoView()`  L830 @Override
- `void showProgress()`  L851 @Override
- `void run()`  L854 @Override
- `void dismissProgress()`  L861 @Override
- `void run()`  L864 @Override
- `void updateModeMenuIcon(int resId)`  L871 @Override
    - 体内字面量："video" · "video"
- `void showMainUI()`  L883 @Override
- `void hideMainUI(boolean isDelayed)`  L893 @Override
- `void showSdCardState(SSTFCardInfo tfCardInfo)`  L908 @Override
- `void hideSdCardUI()`  L923 @Override
- `void showBatteryState(SSBatteryInfo batteryInfo)`  L934 @Override
- `void hideBatteryUI()`  L951 @Override
- `void showResolution(String resolution)`  L960 @Override
    - 体内字面量："showResolution"
- `void dismissResolution()`  L974 @Override
- `void showQuickStoriesRestTime(int restTime)`  L983 @Override
- `void dismissQuickStoriesRestTime()`  L992
- `void requestDataError(Exception e)`  L998 @Override
- `void loadCameraInfoSuccess(String requestMethod)`  L1004 @Override
    - 体内字面量："ivBrowseFile" · "ivSettings"
- `void loadRotateSuccess(int rotate)`  L1028 @Override
    - 体内字面量："loadRotateSuccess rotateï¼"
- `void loadBluetoothTXSuccess(String tx1Name, String tx2Name)`  L1061 @Override
    - 体内字面量："loadBluetoothTXSuccess tx1Name&tx2Nameï¼" · " & "
- `void showFastSetting(String workMode, String value)`  L1077 @Override
    - 体内字面量："H22IMX377" · "20220702"
- `void settDelayedRecordingTime()`  L1096 @Override
- `void run()`  L1100 @Override
- `void dismissFastSetting()`  L1107 @Override
- `void updateOperateCommandUI(SSystemWorkState sSystemWorkState)`  L1116 @Override
    - 体内字面量："updateOperateCommandUI"
- `void updateCommandUI(SSystemWorkState sSystemWorkState)`  L1129
    - 体内字面量："updateCommandUI"
- `void run()`  L1159 @Override
    - 体内字面量："..."
- `void settingScreenOrientation(int options)`  L1214
    - 体内字面量："android.settings.action.MANAGE_WRITE_SETTINGS" · "package:" · "accelerometer_rotation"
- `void showQuickStoriesOperateUI()`  L1226 @Override
- `void dismissQuickStoriesOperateUI()`  L1232
- `void showAddTimeTip()`  L1238
- `void run()`  L1242 @Override
- `void dismissAddTimeTip()`  L1249
- `void dismissAddTimeButton()`  L1253
- `void showExitQuickVideoOperateUI()`  L1258 @Override
- `void dismissExitQuickVideoOperateUI()`  L1262
- `void updateCommandRes(HashMap<String, ArrayList<String>> allWorkMode, SSystemWorkState sSystemWorkState)`  L1266
    - 体内字面量："Start Record" · "Stop Record"
- `SSPreviewSaveInfo getSaveInfo()`  L1313
- `int setContentRes()`  L1318 @Override
- `int selectMainTopLogo()`  L1322
- `void selectMainLogo()`  L1333
- `void showRecordCountUI()`  L1346 @Override
- `void dismissRecordCountUI()`  L1361 @Override
- `void updateCDTimeString(int currentTime)`  L1373 @Override
- `void updateWiFiRssiUI(WifiManager wifiManager)`  L1383 @Override
- `void dumpToPlayback()`  L1388 @Override
- `void dumpToSetting()`  L1397 @Override
- `void enableActionButton(boolean enable)`  L1401
- `void onConfigurationChanged(Configuration newConfig)`  L1409 @Override
    - 体内字面量："onConfigurationChanged: "
- `void onChannelEvent(int type, Object param, String... array)`  L1429 @Override
    - 体内字面量："onChannelEvent: type: "
### `com.gku.actioncam.sigmastar.OldUi.preview.ui.activity.AmbaActionCameraPreviewActivity$AnonymousClass17`
L746 · [class] AnonymousClass17 · implements `Runnable` · `com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java`

方法（5）：
- `void run()`  L751 @Override
    - 体内字面量：" =========initIjkVideoView  liveStream=" · "libijkplayer.so" · " =========initIjkVideoView  isInitIjkPlayer="
- `boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1)`  L768 @Override
- `void run()`  L777 @Override
    - 体内字面量：" =========initIjkVideoView  onInfo= "
- `boolean onError(IMediaPlayer iMediaPlayer, int i, int i1)`  L795 @Override
    - 体内字面量：" =========initIjkVideoView  onError= "
- `void onCompletion(IMediaPlayer mp)`  L803 @Override
    - 体内字面量：" =========initIjkVideoView  onCompletion" · "initIjkVideoView  cameraInfors != null" · "CV75" · " =========initIjkVideoView  preview_texture_video_view.start()"
### `com.gku.actioncam.sigmastar.OldUi.preview.ui.activity.HisiActionCameraPreviewActivity`
L87 · [class] public HisiActionCameraPreviewActivity · extends `CameraBaseActivity implements ISSPreviewNew` · implements `ISSPreviewNew` · `com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java`

字段/常量（86）：
- `int HANDLER_WHAT_HIDE_MAIN_UI = 1320`  L88
- `int HANDLER_WHAT_SHOW_MAIN_UI = 1319`  L89
- `int STATE_RECORDING = 1`  L90
- `int STATE_UNRECORDING = 0`  L91
- `String TAG = "SSPreviewNewActivity"`  L92
- `String TAG_SS_PREVIEW_SAVE = "ss_preview_save"`  L93
- `boolean curActivityIsVis`  L94
- `FullScreenLoadingDialog fullscreenloadingdialog`  L96
- `ImageView ivBackPreview`  L97
- `ImageView ivModeMore`  L98
- `ImageView ivSavedSign`  L99
- `ImageView iv_capture`  L100
- `LoadingDialog loadingDialog`  L101
- `String mModelName`  L102
- `boolean mPhotoing`  L103
- `String mSoftVersion`  L104
- `boolean mTimingPhotoStopped`  L105
- `ActionCameraPreviewPresenter presenter`  L106
- `FrameLayout preview_container`  L107
- `ImageView preview_cover`  L108
- `VideoTextureView preview_texture_video_view`  L109
- `Bundle savedInstanceState`  L110
- `ImageView ss_preview_content_battery_capacity`  L111
- `ImageView ss_preview_content_browse_file`  L112
- `RelativeLayout ss_preview_content_capture`  L113
- `ImageView ss_preview_content_exit_quick_video`  L114
- `TextView ss_preview_content_info`  L115
- `LinearLayout ss_preview_content_layout_info`  L116
- `ImageView ss_preview_content_loop_recording`  L117
- `ImageView ss_preview_content_main_logo`  L118
- `ImageView ss_preview_content_mode_menu`  L119
- `ImageView ss_preview_content_record_sign`  L120
- `TextView ss_preview_content_record_time`  L121
- `RelativeLayout ss_preview_content_record_time_bar`  L122
- `TextView ss_preview_content_resolution`  L123
- `ImageView ss_preview_content_setting`  L124
- `RelativeLayout ss_preview_content_setting_bar`  L125
- `ImageView ss_preview_content_short_video_add_time`  L126
- `TextView ss_preview_content_short_video_add_time_text`  L127
- `TextView ss_preview_content_short_video_time_text`  L128
- `TextView ss_preview_content_storage_available`  L129
- `ProgressBar ss_preview_content_storage_usage`  L130
- `ImageView ss_preview_content_type`  L131
- `ImageView ss_preview_content_wifi_signal`  L132
- `FrameLayout ss_preview_main`  L133
- `RelativeLayout ss_preview_set_mode`  L134
- `StateView sv_message`  L135
- `AlertDialog tipsDialog`  L136
- `TextView tvPrompt`  L137
- `String flipValue = "0Â°"`  L138
- `int mRotate = -1`  L139
- `float mScale = 1.0f`  L140
- `boolean isPulling = false`  L141
- `boolean backEnable = true`  L151
- `boolean hasStartPlay = true`  L169
- `boolean viewRendered = false`  L170
- `boolean isInitIjkPlayer = false`  L171
- `boolean videoRenderingStart = false`  L172
- `long lastStreamTime = 0`  L173
- `boolean needTips = true`  L175
- `int i = msg.what`  L206
- `ActionCameraPreviewPresenter actionCameraPreviewPresenter = this.presenter`  L318
- `ActionCameraPreviewPresenter actionCameraPreviewPresenter = this.presenter`  L374
- `AlertDialog alertDialog = this.tipsDialog`  L379
- `String[] strArr`  L516
- `ActionCameraPreviewPresenter actionCameraPreviewPresenter = HisiActionCameraPreviewActivity.this.presenter`  L561
- `HisiActionCameraPreviewActivity hisiActionCameraPreviewActivity = HisiActionCameraPreviewActivity.this`  L562
- `SSPreviewSaveInfo sSPreviewSaveInfo`  L643
- `Bundle bundle = this.savedInstanceState`  L645
- `Bitmap bitmap`  L706
- `float f = this.mScale`  L716
- `FrameLayout frameLayout = this.preview_container`  L854
- `VideoTextureView videoTextureView = this.preview_texture_video_view`  L860
- `Handler handler = this.mainUIUpdateHandler`  L907
- `Handler handler = this.mainUIUpdateHandler`  L917
- `int i = tfCardInfo.total`  L938
- `int i2 = tfCardInfo.used`  L939
- `ProgressBar progressBar = this.ss_preview_content_storage_usage`  L948
- `ImageView imageView = this.ss_preview_content_battery_capacity`  L975
- `TextView textView = this.ss_preview_content_resolution`  L997
- `RelativeLayout relativeLayout = this.ss_preview_content_capture`  L1114
- `String str = this.presenter.curWorkMode`  L1305
- `RelativeLayout relativeLayout = this.ss_preview_content_record_time_bar`  L1372
- `TextView textView = this.ss_preview_content_record_time`  L1385
- `boolean z = newConfig.orientation == 2`  L1422
- `VideoTextureView videoTextureView = this.preview_texture_video_view`  L1423

方法（101）：
- `void run()`  L144 @Override
- `void run()`  L154 @Override
    - 体内字面量：" =========initIjkVideoView SAFAFAF 2"
- `void run()`  L161 @Override
    - 体内字面量："4K60" · "4K30" · " =========initIjkVideoView SAFAFAF 3"
- `void run()`  L178 @Override
    - 体内字面量："ijkMediaPlayer live å¡ä½éæ°æ­æ¾"
- `void run()`  L185 @Override
    - 体内字面量：" =========initIjkVideoView SAFAFAF 4"
- `void handleMessage(Message msg)`  L204 @Override
- `void loadBluetoothTXSuccess(String tx1Name, String tx2Name)`  L241 @Override
- `void onProgressCancelListener(DialogInterface dialog)`  L245 @Override
- `void updateWiFiLevel(int level)`  L249 @Override
- `void startPolling()`  L252
- `void stopPolling()`  L260
- `void startActionCameraPreviewActivity(Context context)`  L265
- `void startActionCameraPreviewActivity(Context context, String flipValue)`  L269
    - 体内字面量："PreViewFlip"
- `void onSaveInstanceState(Bundle outState)`  L277 @Override
    - 体内字面量："ss_preview_save"
- `void onCreate(Bundle savedInstanceState)`  L283 @Override
    - 体内字面量："onCreateonCreateonCreate" · "PreViewFlip" · "PreViewFlip" · "needShowPreviewTips"
- `void onClick(DialogInterface dialog, int which)`  L295 @Override
- `void onClick(DialogInterface dialog, int which)`  L299 @Override
    - 体内字面量："needShowPreviewTips"
- `void onReceiveMsg(String msg)`  L309 @Override
- `void onStart()`  L316 @Override
- `void onResume()`  L325 @Override
    - 体内字面量：" =========initIjkVideoView SAFAFAF  1" · " =========onResume()  initIjkVideoView(0)"
- `void onPause()`  L336 @Override
- `void onBackPressed()`  L345 @Override
    - 体内字面量："HomeActivity" · ">>>>>>>>Pressed: "
- `void onStop()`  L361 @Override
    - 体内字面量："onStop"
- `void onDestroy()`  L367 @Override
    - 体内字面量："onDestroy"
- `void onMessageEvent(FlipMessageEvent event)`  L387 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："onMessageEvent: flipValue = "
- `void onMessageEvent2(MessageEvent messageEvent)`  L395 @Subscribe(threadMode = ThreadMode.MAIN)
- `void run()`  L404 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L418 @Override
    - 体内字面量："onActivityResult: 1" · "ss_preview_save"
- `void initPresenter()`  L439
    - 体内字面量："modelNameAndSoftVersion" · "modelName" · "softVersion" · "\\." · "H22IMX377" · "20220702"
- `void initView()`  L456 @Override
- `void onClick(View v)`  L491 @Override
    - 体内字面量："video" · "video"
- `void onClick(View v)`  L504 @Override
    - 体内字面量："Stop Record"
- `void onClick(View v)`  L515 @Override
- `void onClick(View v)`  L542 @Override
    - 体内字面量："ivSettings"
- `void onClick(View v)`  L555 @Override
- `void onClick(View v)`  L568 @Override
    - 体内字面量："..." · "..."
- `void onClick(View v)`  L605 @Override
- `void onClick(View v)`  L612 @Override
- `void onClick(View v)`  L623 @Override
    - 体内字面量："CV75" · "initView: "
- `void addData()`  L642 @Override
- `void updateUIBySaveState(SSPreviewSaveInfo ssPreviewSaveInfo)`  L655
- `void runRefView()`  L682
- `void stoprunRefView()`  L686
- `void runTask()`  L690
    - 体内字面量："runTask"
- `void initIjkVideoView(int time)`  L697 @Override
    - 体内字面量：" =========initIjkVideoView SAFAFAF"
- `void initIjkVideoView2(int time)`  L705
- `void run()`  L766 @Override
    - 体内字面量：" =========initIjkVideoView  liveStream=" · "libijkplayer.so" · " =========initIjkVideoView  isInitIjkPlayer="
- `boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1)`  L783 @Override
    - 体内字面量：" =========initIjkVideoView  onInfo= "
- `boolean onError(IMediaPlayer iMediaPlayer, int i, int i1)`  L802 @Override
    - 体内字面量：" =========initIjkVideoView  onError= "
- `void onCompletion(IMediaPlayer mp)`  L810 @Override
    - 体内字面量：" =========initIjkVideoView  onCompletion" · "initIjkVideoView  cameraInfors == null"
- `void onFail(int code)`  L822 @Override
- `void onSuccess(CameraInfoResponseBean responseBean, String json)`  L826 @Override
    - 体内字面量："initIjkVideoView  cameraInfors == null" · "initIjkVideoView  cameraInfors != null" · "CV75" · " =========initIjkVideoView  preview_texture_video_view.start()"
- `void startCheck()`  L848
- `void destroyVideoView()`  L853 @Override
- `void showProgress()`  L874 @Override
- `void run()`  L877 @Override
- `void dismissProgress()`  L884 @Override
- `void run()`  L887 @Override
- `void updateModeMenuIcon(int resId)`  L894 @Override
    - 体内字面量："video" · "video"
- `void showMainUI()`  L906 @Override
- `void hideMainUI(boolean isDelayed)`  L916 @Override
- `void showSdCardState(SSTFCardInfo tfCardInfo)`  L931 @Override
- `void hideSdCardUI()`  L946 @Override
- `void showBatteryState(SSBatteryInfo batteryInfo)`  L957 @Override
- `void hideBatteryUI()`  L974 @Override
- `void showResolution(String resolution)`  L983 @Override
- `void dismissResolution()`  L996 @Override
- `void showQuickStoriesRestTime(int restTime)`  L1005 @Override
- `void dismissQuickStoriesRestTime()`  L1014
- `void requestDataError(Exception e)`  L1020 @Override
- `void loadCameraInfoSuccess(String requestMethod)`  L1026 @Override
    - 体内字面量："ivBrowseFile" · "ivSettings"
- `void loadRotateSuccess(int rotate)`  L1050 @Override
- `void showFastSetting(String workMode, String value)`  L1083 @Override
    - 体内字面量："H22IMX377" · "20220702"
- `void settDelayedRecordingTime()`  L1102 @Override
- `void run()`  L1106 @Override
- `void dismissFastSetting()`  L1113 @Override
- `void updateOperateCommandUI(SSystemWorkState sSystemWorkState)`  L1122 @Override
    - 体内字面量："updateOperateCommandUI"
- `void updateCommandUI(SSystemWorkState sSystemWorkState)`  L1135
    - 体内字面量："updateCommandUI"
- `void run()`  L1167 @Override
    - 体内字面量："..."
- `void settingScreenOrientation(int options)`  L1225
    - 体内字面量："android.settings.action.MANAGE_WRITE_SETTINGS" · "package:" · "accelerometer_rotation"
- `void showQuickStoriesOperateUI()`  L1237 @Override
- `void dismissQuickStoriesOperateUI()`  L1243
- `void showAddTimeTip()`  L1249
- `void run()`  L1253 @Override
- `void dismissAddTimeTip()`  L1260
- `void dismissAddTimeButton()`  L1264
- `void showExitQuickVideoOperateUI()`  L1269 @Override
- `void dismissExitQuickVideoOperateUI()`  L1273
- `void updateCommandRes(HashMap<String, ArrayList<String>> allWorkMode, SSystemWorkState sSystemWorkState)`  L1277
    - 体内字面量："Start Record" · "Stop Record"
- `SSPreviewSaveInfo getSaveInfo()`  L1324
- `int setContentRes()`  L1329 @Override
- `int selectMainTopLogo()`  L1333
- `void selectMainLogo()`  L1344
- `void showRecordCountUI()`  L1357 @Override
- `void dismissRecordCountUI()`  L1371 @Override
- `void updateCDTimeString(int currentTime)`  L1383 @Override
- `void updateWiFiRssiUI(WifiManager wifiManager)`  L1393 @Override
- `void dumpToPlayback()`  L1398 @Override
- `void dumpToSetting()`  L1407 @Override
- `void enableActionButton(boolean enable)`  L1411
- `void onConfigurationChanged(Configuration newConfig)`  L1419 @Override
    - 体内字面量："onConfigurationChanged: "
### `com.gku.actioncam.sigmastar.OldUi.setting.event.FlipMessageEvent`
L4 · [class] public FlipMessageEvent · `com/gku/actioncam/sigmastar/OldUi/setting/event/FlipMessageEvent.java`

字段/常量（1）：
- `String FlipValue`  L5

方法（3）：
- `public FlipMessageEvent(String FlipValue)`  L7
- `String getFlipValue()`  L11
- `void setFlipValue(String FlipValue)`  L15
### `com.gku.actioncam.sigmastar.OldUi.setting.model.AmbaSettingModel`
L39 · [class] public AmbaSettingModel · implements `ISSettingModel, IChannelListener` · `com/gku/actioncam/sigmastar/OldUi/setting/model/AmbaSettingModel.java`

字段/常量（9）：
- `String curValue`  L40
- `ISSPreviewModelCallback previewModelCallback`  L41
- `String secondParentName`  L42
- `ISSettingModelCallBack settingModelCallBack`  L43
- `String wifiSettingName`  L44
- `String TAG = "AmbaSettingModel"`  L45
- `SettingRecycleAdapter.SettingItemType settingItemType`  L198
- `String str = array[0]`  L287
- `String str2 = array[1]`  L288

方法（36）：
- `public AmbaSettingModel(ISSettingModelCallBack settingModelCallBack, ISSPreviewModelCallback previewModelCallback)`  L48
- `void getWifi(String name)`  L54 @Override
- `void failure(int code)`  L58 @Override
- `void success()`  L62 @Override
- `void setWiFi(final String outputSSID, final String password)`  L68 @Override
- `void success()`  L74 @Override
- `void failure(int code)`  L80 @Override
- `void formatSD()`  L87 @Override
- `void success()`  L90 @Override
- `void failure(int code)`  L94 @Override
    - 体内字面量："formatSD"
- `void reset()`  L101 @Override
- `void failure(int code)`  L104 @Override
- `void success()`  L108 @Override
- `void getSecondMenuItem(String curMode, String name)`  L114 @Override
- `void failure(int code)`  L121 @Override
- `void success()`  L125 @Override
- `void setCurParam(String curMode, String name, String value)`  L131 @Override
- `void failure(int code)`  L138 @Override
- `void success()`  L142 @Override
- `void getPrimaryMenuItem(String curMode, String itemName)`  L148 @Override
    - 体内字面量："AmbaSettingModel" · "getPrimaryMenuItem: AAAAAAA"
- `void success()`  L155 @Override
    - 体内字面量："getPrimaryMenuItem: success"
- `void failure(int code)`  L161 @Override
    - 体内字面量："getPrimaryMenuItem: failure"
- `void loadCameraInfo()`  L169 @Override
- `void success()`  L172 @Override
    - 体内字面量："AmbaSettingModel" · "getDeviceInfo success"
- `void failure(int code)`  L177 @Override
    - 体内字面量："AmbaSettingModel" · "getDeviceInfo failure"
- `String fillNullParam(String string)`  L183
    - 体内字面量：",," · ",," · ",-," · "-%s" · "%s-"
- `void onChannelEvent(int type, Object param, String... array)`  L197 @Override
- `void run()`  L234 @Override
- `void run()`  L243 @Override
- `void run()`  L253 @Override
    - 体内字面量："onChannelEvent: è·åç³»ç»å·¥ä½ç¶æ (SyncStateMessageStr) param=" · "AmbaSettingModel" · "AmbaSettingModel" · "----------"
- `void run()`  L268 @Override
- `void run()`  L281 @Override
- `void run()`  L291 @Override
- `void run()`  L299 @Override
- `void run()`  L310 @Override
    - 体内字面量："CMD_CHANNEL_EVENT_GET_PRIMARY_MENU_ITEM" · "AMBA_GET_PRIMARY_MENU_ITEM" · "ASFAFASFASFAFA  ==" · "-" · "ON" · "OFF" · "-"
- `void run()`  L347 @Override
### `com.gku.actioncam.sigmastar.OldUi.setting.model.HaisiSettingModel`
L18 · [class] public HaisiSettingModel · implements `ISSettingModel` · `com/gku/actioncam/sigmastar/OldUi/setting/model/HaisiSettingModel.java`

字段/常量（1）：
- `ISSettingModelCallBack settingModelCallBack`  L19

方法（26）：
- `public HaisiSettingModel(ISSettingModelCallBack settingModelCallBack)`  L21
- `void getWifi(final String name)`  L26 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L29 @Override
- `void onFail(Call call, int code, String errorMsg)`  L34 @Override
    - 体内字面量："getWifi"
- `void setWiFi(String outputSSID, String password)`  L41 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L44 @Override
- `void onFail(Call call, int code, String errorMsg)`  L50 @Override
- `void formatSD()`  L58 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L61 @Override
- `void onFail(Call call, int code, String errorMsg)`  L66 @Override
- `void reset()`  L73 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L76 @Override
- `void onFail(Call call, int code, String errorMsg)`  L81 @Override
- `void getSecondMenuItem(String curMode, final String name)`  L88 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L91 @Override
- `void onFail(Call call, int code, String errorMsg)`  L96 @Override
    - 体内字面量："getSecondMenuItem"
- `void setCurParam(String curMode, final String name, final String value)`  L103 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L106 @Override
- `void onFail(Call call, int code, String errorMsg)`  L111 @Override
    - 体内字面量："WiFi Frequency" · "setCurParam"
- `void recombinationData(ArrayList<SSettingItemBean> sSettingItemBeans, String itemName)`  L123
    - 体内字面量："P120" · "EIS" · "Gyro EIS" · "OFF"
- `void getPrimaryMenuItem(String curMode, final String itemName)`  L140 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L143 @Override
- `void onFail(Call call, int code, String errorMsg)`  L150 @Override
    - 体内字面量："getPrimaryMenuItem"
- `void loadCameraInfo()`  L157 @Override
- `void onFail(Call call, int code, String errorMsg)`  L160 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L164 @Override
### `com.gku.actioncam.sigmastar.OldUi.setting.model.SettingModelManage`
L11 · [class] public SettingModelManage · `com/gku/actioncam/sigmastar/OldUi/setting/model/SettingModelManage.java`

字段/常量（2）：
- `ISSettingModel isSettingModel`  L12
- `ISSettingModel iSSettingModel = this.isSettingModel`  L28

方法（10）：
- `public SettingModelManage(ISSettingModelCallBack settingModelCallBack, ISSPreviewModelCallback previewModelCallback)`  L14
    - 体内字面量："CV75"
- `ISSettingModel getModel()`  L27
- `void formatSD()`  L34 @Override
- `void getPrimaryMenuItem(String curMode, String itemName)`  L38 @Override
- `void getSecondMenuItem(String curMode, String name)`  L42 @Override
- `void getWifi(String name)`  L46 @Override
- `void loadCameraInfo()`  L50 @Override
- `void reset()`  L54 @Override
- `void setCurParam(String curMode, String name, String value)`  L58 @Override
- `void setWiFi(String outputSSID, String password)`  L62 @Override
### `com.gku.actioncam.sigmastar.OldUi.setting.model.SigmastartSettingModel`
L19 · [class] public SigmastartSettingModel · implements `ISSettingModel` · `com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java`

字段/常量（2）：
- `ISSettingModelCallBack settingModelCallBack`  L20
- `CameraInfors cameraInfors`  L118

方法（26）：
- `public SigmastartSettingModel(ISSettingModelCallBack settingModelCallBack)`  L22
- `void getWifi(final String name)`  L27 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L30 @Override
- `void onFail(Call call, int code, String errorMsg)`  L35 @Override
    - 体内字面量："getWifi"
- `void setWiFi(String outputSSID, String password)`  L42 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L45 @Override
- `void onFail(Call call, int code, String errorMsg)`  L50 @Override
    - 体内字面量："setWiFi"
- `void formatSD()`  L57 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L60 @Override
- `void onFail(Call call, int code, String errorMsg)`  L65 @Override
    - 体内字面量："formatSD"
- `void reset()`  L72 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L75 @Override
- `void onFail(Call call, int code, String errorMsg)`  L80 @Override
    - 体内字面量："reset"
- `void getSecondMenuItem(String curMode, final String name)`  L87 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L90 @Override
- `void onFail(Call call, int code, String errorMsg)`  L95 @Override
    - 体内字面量："getSecondMenuItem"
- `void setCurParam(String curMode, final String name, final String value)`  L102 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L105 @Override
- `void onFail(Call call, int code, String errorMsg)`  L110 @Override
    - 体内字面量："setCurParam"
- `void recombinationData(ArrayList<SSettingItemBean> sSettingItemBeans, String itemName)`  L117
- `void getPrimaryMenuItem(String curMode, final String itemName)`  L151 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L154 @Override
- `void onFail(Call call, int code, String errorMsg)`  L161 @Override
    - 体内字面量："getPrimaryMenuItem"
- `void loadCameraInfo()`  L168 @Override
- `void onFail(Call call, int code, String errorMsg)`  L171 @Override
- `void onSuccess(Call call, String responseBody, Response response)`  L175 @Override
### `com.gku.actioncam.sigmastar.OldUi.setting.presenter.SSettingPresenter`
L38 · [class] public SSettingPresenter · `com/gku/actioncam/sigmastar/OldUi/setting/presenter/SSettingPresenter.java`

字段/常量（6）：
- `String TAG = "SSettingPresenter"`  L39
- `CameraBaseActivity activity`  L40
- `ISSPreviewNew preview`  L41
- `ISSetting settingView`  L42
- `boolean newSelectedStatus = false`  L44
- `SSettingPresenter sSettingPresenter = SSettingPresenter.this`  L128

方法（26）：
- `public SSettingPresenter(CameraBaseActivity activity)`  L47
- `void setView(ISSetting setting, ISSPreviewNew preview)`  L51
- `void showToastTip(String message)`  L56
- `void showWiFiDialog(final String title, final String wifiName, final String wifiPassword, HttpRequestUtils.StringCallBack requestCallback)`  L63
- `void run()`  L69 @Override
- `void lambda$showWiFiDialog$2(String str, String str2, String str3)`  L76
    - 体内字面量："_" · "_" · "_"
- `void onClick(View view)`  L95 @Override
- `void onClick(View view)`  L101 @Override
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L107 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L111 @Override
- `void afterTextChanged(Editable s)`  L115 @Override
    - 体内字面量："[^a-zA-Z0-9]"
- `void onClick(View view)`  L127 @Override
- `void lambda$showWiFiDialog$1(EditText editText, EditText editText2, String str, AlertDialog alertDialog, View view)`  L143
    - 体内字面量："_"
- `void dumpToInformation()`  L158
- `void run()`  L161 @Override
- `void lambda$dumpToInformation$3()`  L168
- `void dumpToBluetoothTX()`  L172
- `void run()`  L175 @Override
- `void lambda$dumpToBluetoothTX$4()`  L182
- `void getWiFi(String name)`  L186
- `void formatSD()`  L190
- `void reset()`  L194
- `void getSecondMenuItem(String curMode, String name)`  L198
- `void setCurParam(String curMode, String name, String value)`  L202
- `void getPrimaryMenuItem(String curMode, String itemName)`  L206
- `void loadCameraInfo()`  L210
### `com.gku.actioncam.sigmastar.OldUi.setting.presenter.SSettingPresenter$PreviewModelCallback`
L291 · [class] PreviewModelCallback · implements `ISSPreviewModelCallback` · `com/gku/actioncam/sigmastar/OldUi/setting/presenter/SSettingPresenter.java`

方法（13）：
- `void getAllWorkModeSuccess(HashMap<String, ArrayList<String>> allWorkMode)`  L293 @Override
- `void getBatterySuccess(SSBatteryInfo ssBatteryInfo)`  L297 @Override
- `void getBluetoothTXSuccess(String tx1Name, String tx2Name)`  L301 @Override
- `void getCurModeParamSuccess(String param, String itemName)`  L305 @Override
- `void getCurWorkModeSuccess(String curMode, String params)`  L309 @Override
- `void getRotateSuccess(int rotate)`  L313 @Override
- `void getSecondMenuItemSuccess(SSecondItemBean bean, View view)`  L317 @Override
- `void getTFCardSuccess(SSTFCardInfo tfCardInfo)`  L321 @Override
- `void httpRequestError(Exception e, String method)`  L325 @Override
- `void loadCameraInfoSuccess(String requestMethod)`  L329 @Override
- `void setCurModeParamSuccess(String result, String value)`  L333 @Override
- `void setSystemTimeSuccess()`  L337 @Override
- `void getSysWorkstateSuccess(SSystemWorkState sSystemWorkState)`  L344 @Override
    - 体内字面量："getCurAllInfo: "
### `com.gku.actioncam.sigmastar.OldUi.setting.presenter.SSettingPresenter$SSettingModelCallback`
L214 · [class] SSettingModelCallback · implements `ISSettingModelCallBack` · `com/gku/actioncam/sigmastar/OldUi/setting/presenter/SSettingPresenter.java`

方法（9）：
- `void getWifiSuccess(SSWiFiInfo ssWiFiInfo, String name)`  L219 @Override
- `void setWiFiSuccess(String result)`  L227 @Override
- `void formatSDSuccess(String result)`  L235 @Override
- `void resetSuccess(String result)`  L243 @Override
- `void getSecondMenuItemSuccess(SSecondItemBean sSecondItemBean, String name)`  L251 @Override
- `void setCurParamSuccess(String result, String name, String value)`  L259 @Override
- `void getPrimaryMenuItemSuccess(ArrayList<SSettingItemBean> sSettingItemBeans)`  L267 @Override
- `void getDataError(Exception e, String methodName)`  L275 @Override
- `void loadCameraInfoSuccess()`  L283 @Override
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSBluetoothTXActivity`
L24 · [class] public SSBluetoothTXActivity · extends `CameraBaseActivity implements ISSPreviewNew` · implements `ISSPreviewNew` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/activity/SSBluetoothTXActivity.java`

字段/常量（8）：
- `ImageView blackImg`  L25
- `ImageView iv_search`  L26
- `ActionCameraPreviewPresenter presenter`  L27
- `Toolbar ssAboutCameraTool`  L28
- `TextView tv_bt_tx_name1`  L29
- `TextView tv_bt_tx_name2`  L30
- `TextView tv_bt_tx_status1`  L31
- `TextView tv_bt_tx_status2`  L32

方法（42）：
- `void destroyVideoView()`  L35 @Override
- `void dismissFastSetting()`  L39 @Override
- `void dismissProgress()`  L43 @Override
- `void dismissRecordCountUI()`  L47 @Override
- `void dismissResolution()`  L51 @Override
- `void dumpToPlayback()`  L55 @Override
- `void dumpToSetting()`  L59 @Override
- `void hideBatteryUI()`  L63 @Override
- `void hideMainUI(boolean isDelayed)`  L67 @Override
- `void hideSdCardUI()`  L71 @Override
- `void initIjkVideoView(int time)`  L75 @Override
- `void initView()`  L79 @Override
- `void loadCameraInfoSuccess(String requestMethod)`  L83 @Override
- `void loadRotateSuccess(int rotate)`  L87 @Override
- `boolean onOptionsItemSelected(MenuItem item)`  L91 @Override
- `void onProgressCancelListener(DialogInterface dialog)`  L96 @Override
- `void requestDataError(Exception e)`  L100 @Override
- `void settDelayedRecordingTime()`  L104 @Override
- `void showBatteryState(SSBatteryInfo batteryInfo)`  L108 @Override
- `void showExitQuickVideoOperateUI()`  L112 @Override
- `void showFastSetting(String workMode, String value)`  L116 @Override
- `void showMainUI()`  L120 @Override
- `void showProgress()`  L124 @Override
- `void showQuickStoriesOperateUI()`  L128 @Override
- `void showQuickStoriesRestTime(int time)`  L132 @Override
- `void showRecordCountUI()`  L136 @Override
- `void showResolution(String resolution)`  L140 @Override
- `void showSdCardState(SSTFCardInfo tfCardInfo)`  L144 @Override
- `void updateCDTimeString(int time)`  L148 @Override
- `void updateModeMenuIcon(int resId)`  L152 @Override
- `void updateOperateCommandUI(SSystemWorkState sSystemWorkState)`  L156 @Override
- `void updateWiFiLevel(int level)`  L160 @Override
- `void updateWiFiRssiUI(WifiManager wifiManager)`  L164 @Override
- `void startSSBluetoothTXActivity(Context context)`  L167
- `void onCreate(Bundle savedInstanceState)`  L172 @Override
- `void onClick(View view)`  L182 @Override
- `void onClick(View view)`  L189 @Override
- `void onStart()`  L196 @Override
- `void addData()`  L203 @Override
- `int setContentRes()`  L210 @Override
- `void loadBluetoothTXSuccess(String tx1Name, String tx2Name)`  L215 @Override
- `void setStatus(TextView tvBtTxStatus, boolean empty)`  L223
    - 体内字面量："#2C2C2C"
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSCameraAboutActivity`
L43 · [class] public SSCameraAboutActivity · extends `CameraBaseActivity implements ISSPreviewNew` · implements `ISSPreviewNew` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/activity/SSCameraAboutActivity.java`

字段/常量（14）：
- `TextView clearCacheSize`  L44
- `ActionCameraPreviewPresenter presenter`  L45
- `TextView ssAboutCameraAppVersion`  L46
- `TextView ssAboutCameraBluetoothTxOneVersion`  L47
- `TextView ssAboutCameraBluetoothTxTwoVersion`  L48
- `TextView ssAboutCameraBluetoothVersion`  L49
- `TextView ssAboutCameraFwVersion`  L50
- `ImageView ssAboutCameraLogoIcon`  L51
- `ImageView ssAboutCameraLogoMain`  L52
- `Toolbar ssAboutCameraTool`  L53
- `TextView ssAboutCameraVersionDate`  L54
- `SSCameraAboutActivity sSCameraAboutActivity = SSCameraAboutActivity.this`  L241
- `int length = -1`  L288
- `int i = length + 1`  L296

方法（47）：
- `void destroyVideoView()`  L57 @Override
- `void dismissFastSetting()`  L61 @Override
- `void dismissProgress()`  L65 @Override
- `void dismissRecordCountUI()`  L69 @Override
- `void dismissResolution()`  L73 @Override
- `void dumpToPlayback()`  L77 @Override
- `void dumpToSetting()`  L81 @Override
- `void hideBatteryUI()`  L85 @Override
- `void hideMainUI(boolean isDelayed)`  L89 @Override
- `void hideSdCardUI()`  L93 @Override
- `void initIjkVideoView(int time)`  L97 @Override
- `void loadCameraInfoSuccess(String requestMethod)`  L101 @Override
- `void loadRotateSuccess(int rotate)`  L105 @Override
- `void onProgressCancelListener(DialogInterface dialog)`  L109 @Override
- `void requestDataError(Exception e)`  L113 @Override
- `void settDelayedRecordingTime()`  L117 @Override
- `void showBatteryState(SSBatteryInfo batteryInfo)`  L121 @Override
- `void showExitQuickVideoOperateUI()`  L125 @Override
- `void showFastSetting(String workMode, String value)`  L129 @Override
- `void showMainUI()`  L133 @Override
- `void showProgress()`  L137 @Override
- `void showQuickStoriesOperateUI()`  L141 @Override
- `void showQuickStoriesRestTime(int time)`  L145 @Override
- `void showRecordCountUI()`  L149 @Override
- `void showResolution(String resolution)`  L153 @Override
- `void showSdCardState(SSTFCardInfo tfCardInfo)`  L157 @Override
- `void updateCDTimeString(int time)`  L161 @Override
- `void updateModeMenuIcon(int resId)`  L165 @Override
- `void updateOperateCommandUI(SSystemWorkState sSystemWorkState)`  L169 @Override
- `void updateWiFiLevel(int level)`  L173 @Override
- `void updateWiFiRssiUI(WifiManager wifiManager)`  L177 @Override
- `void startSSCameraAboutActivity(Context context)`  L180
- `void onCreate(Bundle savedInstanceState)`  L185 @Override
- `void onStart()`  L191 @Override
- `void onFail(int code)`  L195 @Override
- `void onSuccess(CameraInfoResponseBean responseBean, String json)`  L199 @Override
- `void run()`  L206 @Override
    - 体内字面量："/cgi-bin/hi3510/getdeviceattr.cgi"
- `void run()`  L213 @Override
- `void initView()`  L223 @Override
- `void onClick(View v)`  L237 @Override
- `void addData()`  L248 @Override
- `String departTxStr(String txName)`  L283
    - 体内字面量："[.:_ ]"
- `void loadBluetoothTXSuccess(String tx1Name, String tx2Name)`  L304 @Override
- `void updateText(String content, TextView textView)`  L326
- `String getAppVersion()`  L334
- `boolean onOptionsItemSelected(MenuItem item)`  L349 @Override
- `int setContentRes()`  L358 @Override
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSDeviceSettingActivity`
L47 · [class] public SSDeviceSettingActivity · extends `CameraBaseActivity implements ISSetting` · implements `ISSetting` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/activity/SSDeviceSettingActivity.java`

字段/常量（15）：
- `String CALLBACK_GET_PRIMARY_FAIL = "CALLBACK_GET_PRIMARY_FAIL"`  L48
- `String CALLBACK_GET_PRIMARY_SUCCUSS = "CALLBACK_GET_PRIMARY_SUCCUSS"`  L49
- `String TAG = "SSDeviceSettingActivity"`  L50
- `String curMode = "System"`  L51
- `String[] supportSwitchType = {"Inversion Mode", "Date Stamp", "Brand Stamp", "Key Tone", "Cap Tone", "Power Tone", "Remote Control", "Face Detection", "Grid", "Auto Sync Time", "Voice Control", "Time Stamp"}`  L52
- `ISSPreviewNew actionCameraPreviewActivity`  L53
- `SettingRecycleAdapter adapter`  L54
- `ImageView blackImg`  L55
- `ProgressDialog dialog`  L56
- `ArrayList<SSettingItemBean> itemList`  L57
- `SSettingPresenter presenter`  L58
- `SBTHeartbeatPresenter sbtHeartbeatPresenter`  L59
- `RecyclerView ss_device_setting_recycle`  L60
- `TextView titleModeText`  L61
- `boolean isPulling = false`  L63

方法（40）：
- `void run()`  L66 @Override
- `void lambda$getSecondMenuItemSuccess$1(DialogInterface dialogInterface)`  L74
- `void onProgressCancelListener(DialogInterface dialog)`  L78 @Override
- `void startSSDeviceSettingActivity(Context context)`  L81
- `void initView()`  L86 @Override
- `void addData()`  L94 @Override
    - 体内字面量："ActionCameraPreviewActivity" · "AmbaActionCameraPreviewActivity"
- `void initRecycle()`  L107
- `void onClick(View v)`  L118 @Override
- `boolean onOptionsItemSelected(MenuItem item)`  L195 @Override
- `int setContentRes()`  L204 @Override
- `void requestList()`  L209 @Override
    - 体内字面量："System"
- `void formatList(ArrayList<SSettingItemBean> settingList)`  L215 @Override
    - 体内字面量："HYH" · "sdhfgbsidhufgh " · "  "
- `void updateList(String itemName)`  L228 @Override
- `void getWifiSuccess(SSWiFiInfo wiFiInfo, String name)`  L236 @Override
- `void onError(int code, Exception e)`  L240 @Override
- `void onSuccess(String result)`  L244 @Override
- `void setWiFiSuccess(String result)`  L251 @Override
    - 体内字面量："wifiè®¾ç½®æå"
- `void formatSDSuccess(String result)`  L256 @Override
- `void resetSuccess(String result)`  L262 @Override
- `void getSecondMenuItemSuccess(final SSecondItemBean sSecondItemBean, final String name)`  L267 @Override
- `void onItemClick(SSListDialogRecycleItemBean sSListDialogRecycleItemBean2)`  L281 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L286 @Override
- `void lambda$getSecondMenuItemSuccess$0(SSecondItemBean sSecondItemBean, String str, SSListDialogRecycleItemBean sSListDialogRecycleItemBean)`  L293
    - 体内字面量："FLIP" · "System"
- `void setCurParamSuccess(String result, String name, String value)`  L305 @Override
- `void getPrimaryMenuItemSuccess(ArrayList<SSettingItemBean> settingList)`  L315 @Override
- `void requestListRetryDialog(final Context context)`  L327
- `void run()`  L330 @Override
- `void lambda$requestListRetryDialog$4(Context context)`  L337
- `void onClick(DialogInterface dialogInterface, int i)`  L341 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L347 @Override
- `void lambda$requestListRetryDialog$2(DialogInterface dialogInterface, int i)`  L359
- `void lambda$requestListRetryDialog$3(DialogInterface dialogInterface, int i)`  L364
- `void getDataError(Exception e, String methodName)`  L370 @Override
    - 体内字面量："getDataError" · "setCurParam" · "setCurParam: " · "formatSD"
- `void loadCameraInfoSuccess()`  L384 @Override
- `void showProgressDialog(boolean isShow)`  L389
- `void startPolling()`  L402
- `void stopPolling()`  L410
- `void onCreate(Bundle bundle)`  L416 @Override
- `void onResume()`  L422 @Override
- `void onPause()`  L428 @Override
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSDeviceSettingActivity$AnonymousClass1`
L125 · [class] AnonymousClass1 · implements `SettingRecycleAdapter.OnSettingItemClickListener` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/activity/SSDeviceSettingActivity.java`

方法（6）：
- `void onItemClick(SettingRecycleAdapter.SettingItemType type, String name)`  L130 @Override
    - 体内字面量："onItemClick" · "System" · "Wi-Fi" · "WiFi" · "SD Format" · "Format SD"
- `void onClick(View view)`  L144 @Override
    - 体内字面量："Factory Reset"
- `void onClick(View view)`  L153 @Override
    - 体内字面量："Information" · "Bluetooth Microphone Connection"
- `void lambda$onItemClick$0(View view)`  L176
- `void lambda$onItemClick$1(View view)`  L183
- `void onItemSwitch(String name, int position, boolean isChecked)`  L188 @Override
    - 体内字面量："onItemSwitch: " · "name:%s, isChecked:%s" · "System" · "ON" · "OFF"
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSModeSettingActivity`
L48 · [class] public SSModeSettingActivity · extends `CameraBaseActivity implements ISSetting` · implements `ISSetting` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/activity/SSModeSettingActivity.java`

字段/常量（19）：
- `String TAG = "SSModeSettingActivity"`  L49
- `String TAG_MODE_SETTING_WORK_MODE = "mode_setting_work_mode"`  L50
- `SettingRecycleAdapter adapter`  L51
- `ImageView blackImg`  L52
- `String curValue`  L53
- `TextView enterDeviceSett`  L54
- `Gson gson`  L55
- `HisiActionCameraPreviewActivity hisiActionCameraPreviewActivity`  L56
- `ArrayList<SSettingItemBean> mSettingList`  L57
- `SSettingPresenter presenter`  L58
- `SSPreviewSaveInfo saveInfo`  L59
- `SBTHeartbeatPresenter sbtHeartbeatPresenter`  L60
- `ShimmerLayoutSimple shimmerLayoutSimple`  L61
- `RecyclerView ss_mode_setting_recycle`  L62
- `TextView titleModeText`  L63
- `String workMode`  L64
- `boolean isPulling = false`  L66
- `SSPreviewSaveInfo sSPreviewSaveInfo`  L113
- `CurrentWorkModeResponseBean currentWorkModeResponseBean`  L150

方法（44）：
- `void run()`  L69 @Override
- `void lambda$getSecondMenuItemSuccess$4(DialogInterface dialogInterface)`  L77
- `void addData()`  L81 @Override
- `void formatSDSuccess(String result)`  L85 @Override
- `void getWifiSuccess(SSWiFiInfo ssWiFiInfo, String name)`  L89 @Override
- `void onProgressCancelListener(DialogInterface dialog)`  L93 @Override
- `void resetSuccess(String result)`  L97 @Override
- `void setWiFiSuccess(String result)`  L101 @Override
- `void startSSModeSettingActivity(Activity activity, String curWorkMode, SSPreviewSaveInfo ssPreviewSaveInfo)`  L104
    - 体内字面量："ss_preview_save"
- `void onCreate(Bundle savedInstanceState)`  L112 @Override
- `void onClick(View v)`  L126 @Override
- `void onClick(View v)`  L132 @Override
- `void onDoNet(int mode)`  L145 @Override
- `void success()`  L149 @Override
- `void failure(int code)`  L166 @Override
- `void onChannelEvent(int type, Object param, String... array)`  L171 @Override
- `void loadData()`  L183
    - 体内字面量："SSPreviewNewActivity"
- `void onPause()`  L197 @Override
- `void onDestroy()`  L203 @Override
- `void initView()`  L208 @Override
- `void onItemClick(SettingRecycleAdapter.SettingItemType type, String name)`  L217 @Override
- `void onItemSwitch(String name, int position, boolean isChecked)`  L224 @Override
    - 体内字面量："onItemSwitch: " · "name:%s, isChecked:%s"
- `void requestListRetryDialog(final Context context)`  L232
- `void run()`  L235 @Override
- `void lambda$requestListRetryDialog$2(Context context)`  L242
- `void onClick(DialogInterface dialogInterface, int i)`  L253 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L259 @Override
- `void lambda$requestListRetryDialog$0(DialogInterface dialogInterface, int i)`  L271
- `void lambda$requestListRetryDialog$1(DialogInterface dialogInterface, int i)`  L276
- `int setContentRes()`  L282 @Override
- `void requestList()`  L287 @Override
- `void formatList(ArrayList<SSettingItemBean> settingList)`  L292 @Override
- `void updateList(String itemName)`  L302 @Override
- `void getSecondMenuItemSuccess(SSecondItemBean sSecondItemBean, final String name)`  L311 @Override
    - 体内字面量："getSecondMenuItemSuccess" · " SuperView" · "EIS" · "Gyro EIS" · "ON"
- `void onItemClick(SSListDialogRecycleItemBean sSListDialogRecycleItemBean2)`  L333 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L338 @Override
- `void lambda$getSecondMenuItemSuccess$3(String str, SSListDialogRecycleItemBean sSListDialogRecycleItemBean)`  L345
    - 体内字面量："Resolution" · "Resolution"
- `void setCurParamSuccess(String result, String name, String value)`  L360 @Override
    - 体内字面量："Resolution" · "ss_preview_save"
- `void getPrimaryMenuItemSuccess(ArrayList<SSettingItemBean> settingList)`  L381 @Override
    - 体内字面量："getPrimaryMenuItemSuccess"
- `void getDataError(Exception e, String methodName)`  L395 @Override
    - 体内字面量："getPrimaryMenuItemSuccess getDataError" · "setCurParam" · "getPrimaryMenuItem"
- `void loadCameraInfoSuccess()`  L407 @Override
- `void startPolling()`  L411
- `void stopPolling()`  L419
- `void onResume()`  L425 @Override
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.adapter.SettingRecycleAdapter`
L16 · [class] public SettingRecycleAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/adapter/SettingRecycleAdapter.java`

字段/常量（5）：
- `String TAG = "SettingRecycleAdapter"`  L17
- `OnSettingItemClickListener onSettingItemClickListener`  L18
- `List<SSettingItemBean> settingList`  L19
- `List<SSettingItemBean> list = this.settingList`  L39
- `List<SSettingItemBean> list = this.settingList`  L134

方法（14）：
- `public SettingRecycleAdapter(List<SSettingItemBean> settingList, OnSettingItemClickListener onSettingItemClickListener)`  L33
- `boolean is120p()`  L38
- `void updateSettingList(List<SSettingItemBean> settingList)`  L51
- `void updateItem(int position)`  L56
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L61 @Override
- `void onBindViewHolder(ViewHolder holder, final int position)`  L73 @Override
- `void onClick(View view)`  L79 @Override
- `void onClick(View view)`  L87 @Override
    - 体内字面量："ON"
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L96 @Override
- `void lambda$onBindViewHolder$0(SSettingItemBean sSettingItemBean, View view)`  L104
- `void lambda$onBindViewHolder$1(SSettingItemBean sSettingItemBean, View view)`  L112
- `void lambda$onBindViewHolder$2(SSettingItemBean sSettingItemBean, int i, CompoundButton compoundButton, boolean z)`  L120
    - 体内字面量："ON" · "OFF"
- `int getItemViewType(int position)`  L128 @Override
- `int getItemCount()`  L133 @Override
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.adapter.SettingRecycleAdapter$ClickViewHolder`
L168 · [class] public static ClickViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/adapter/SettingRecycleAdapter.java`

方法（1）：
- `public ClickViewHolder(View itemView)`  L169
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.adapter.SettingRecycleAdapter$OnSettingItemClickListener`
L21 · [interface] public OnSettingItemClickListener · `com/gku/actioncam/sigmastar/OldUi/setting/ui/adapter/SettingRecycleAdapter.java`

方法（2）：
- `void onItemClick(SettingItemType type, String name)`  L22
- `void onItemSwitch(String name, int position, boolean isChecked)`  L24
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.adapter.SettingRecycleAdapter$SelectViewHolder`
L150 · [class] public static SelectViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/adapter/SettingRecycleAdapter.java`

字段/常量（1）：
- `TextView ss_setting_item_value`  L151

方法（1）：
- `public SelectViewHolder(View itemView)`  L153
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.adapter.SettingRecycleAdapter$SettingItemType`
L27 · [enum] public SettingItemType · `com/gku/actioncam/sigmastar/OldUi/setting/ui/adapter/SettingRecycleAdapter.java`

枚举常量（2）：
- `SELECT()`  L28
- `SWITCH()`  L29
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.adapter.SettingRecycleAdapter$SwitchViewHolder`
L159 · [class] public static SwitchViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/adapter/SettingRecycleAdapter.java`

字段/常量（1）：
- `SwitchCompat ss_setting_item_switch`  L160

方法（1）：
- `public SwitchViewHolder(View itemView)`  L162
### `com.gku.actioncam.sigmastar.OldUi.setting.ui.adapter.SettingRecycleAdapter$ViewHolder`
L141 · [class] public static ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/OldUi/setting/ui/adapter/SettingRecycleAdapter.java`

字段/常量（1）：
- `TextView ss_setting_item_name`  L142

方法（1）：
- `public ViewHolder(View itemView)`  L144