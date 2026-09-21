# idGoLive — 类与成员明细：com.icatch.golive.Function

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 26 个文件 / 77 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.Function.BaseProrertys`
L14 · [class] public BaseProrertys · `com/icatch/golive/Function/BaseProrertys.java`

字段/常量（29）：
- `String TAG = "BaseProrertys"`  L15
- `PropertyTypeInteger autoPowerOff`  L16
- `PropertyTypeInteger bluetoothAudioRecording`  L17
- `PropertyTypeInteger burst`  L18
- `PropertyTypeInteger cameraImageSwitching`  L19
- `CameraProperties cameraProperty`  L20
- `PropertyTypeInteger cameraSwitch`  L21
- `PropertyTypeInteger captureDelay`  L22
- `PropertyTypeInteger dateStamp`  L23
- `PropertyTypeInteger electricityFrequency`  L24
- `PropertyTypeInteger exposureCompensation`  L25
- `PropertyTypeInteger fastMotionMovie`  L26
- `PropertyTypeInteger gSensor`  L27
- `PropertyTypeString imageSize`  L28
- `PropertyTypeInteger microphoneReception`  L29
- `PropertyTypeInteger restDevice`  L30
- `PropertyTypeInteger screenSaver`  L31
- `PropertyTypeInteger sdSpace`  L32
- `PropertyTypeInteger sdSpaceRemain`  L33
- `PropertyTypeInteger slowMotion`  L34
- `TimeLapseDuration timeLapseDuration`  L35
- `PropertyTypeInteger timeLapseMode`  L36
- `TimeLapseInterval timeLapseStillInterval`  L37
- `TimeLapseInterval timeLapseVideoInterval`  L38
- `PropertyTypeInteger upside`  L39
- `PropertyTypeInteger videoFileLength`  L40
- `PropertyTypeString videoSize`  L41
- `PropertyTypeInteger videoWarningQuery`  L42
- `PropertyTypeInteger whiteBalance`  L43

方法（28）：
- `public BaseProrertys(CameraProperties cameraProperties)`  L45
- `void initProperty()`  L51
    - 体内字面量："Start initProperty" · "End initProperty"
- `PropertyTypeInteger getAutoPowerOff()`  L82
- `PropertyTypeInteger getBluetoothAudioRecording()`  L86
- `PropertyTypeInteger getBurst()`  L90
- `PropertyTypeInteger getCameraImageSwitching()`  L94
- `PropertyTypeInteger getCameraSwitch()`  L98
- `PropertyTypeInteger getCaptureDelay()`  L102
- `PropertyTypeInteger getDateStamp()`  L106
- `PropertyTypeInteger getElectricityFrequency()`  L110
- `PropertyTypeInteger getExposureCompensation()`  L114
- `PropertyTypeInteger getFastMotionMovie()`  L118
- `PropertyTypeString getImageSize()`  L122
- `PropertyTypeInteger getMicrophoneReception()`  L126
- `PropertyTypeInteger getRestDevice()`  L130
- `PropertyTypeInteger getScreenSaver()`  L134
- `PropertyTypeInteger getSdSpace()`  L138
- `PropertyTypeInteger getSdSpaceRemain()`  L142
- `PropertyTypeInteger getSlowMotion()`  L146
- `PropertyTypeInteger getTimeLapseMode()`  L150
- `TimeLapseInterval getTimeLapseStillInterval()`  L154
- `TimeLapseInterval getTimeLapseVideoInterval()`  L158
- `PropertyTypeInteger getUpside()`  L162
- `PropertyTypeInteger getVideoFileLength()`  L166
- `PropertyTypeString getVideoSize()`  L170
- `PropertyTypeInteger getWhiteBalance()`  L174
- `PropertyTypeInteger getgSensor()`  L178
- `TimeLapseDuration gettimeLapseDuration()`  L182
### `com.icatch.golive.Function.CameraAction.PbDownloadManager`
L40 · [class] public PbDownloadManager · `com/icatch/golive/Function/CameraAction/PbDownloadManager.java`

字段/常量（23）：
- `String TAG = "PbDownloadManager"`  L41
- `AlertDialog.Builder builder`  L42
- `AlertDialog cancelDownloadDialog`  L43
- `Context context`  L44
- `ICatchFile curDownloadFile`  L45
- `ICatchFile currentDownloadFile`  L46
- `CustomDownloadDialog customDownloadDialog`  L47
- `LinkedList<ICatchFile> downloadChooseList`  L48
- `DownloadManagerAdapter downloadManagerAdapter`  L49
- `long downloadProgress`  L50
- `Timer downloadProgressTimer`  L51
- `LinkedList<ICatchFile> downloadTaskList`  L52
- `ExecutorService executor`  L53
- `int downloadFailed = 0`  L55
- `int downloadSucceed = 0`  L56
- `String curFilePath = "<binary/metadata>"`  L57
- `int i = message.what`  L61
- `int i = pbDownloadManager.downloadFailed`  L268
- `int i = pbDownloadManager.downloadSucceed`  L274
- `Uri contentUri`  L281
- `String str2`  L282
- `CustomDownloadDialog customDownloadDialog`  L374
- `AlertDialog alertDialog = this.cancelDownloadDialog`  L402

方法（17）：
- `void handleMessage(Message message)`  L60 @Override
- `public PbDownloadManager(Context context, LinkedList<ICatchFile> linkedList)`  L256
- `int access$1008(PbDownloadManager pbDownloadManager)`  L267
- `int access$1108(PbDownloadManager pbDownloadManager)`  L273
- `void deleteExistingMediaFile(String str, int i)`  L280
- `void updateDownloadMessage()`  L325
    - 体内字面量："$1$" · "$2$" · "$3$"
- `void alertForQuitDownload()`  L329
- `void onClick(DialogInterface dialogInterface, int i)`  L338 @Override
    - 体内字面量："2222" · "alertForQuitDownload file success == " · "cancel download task and quit download manager"
- `void onClick(DialogInterface dialogInterface, int i)`  L363 @Override
- `void cancelDownload(ICatchFile iCatchFile)`  L373
- `void downloadCompleted()`  L401
- `void onClick(DialogInterface dialogInterface, int i)`  L413 @Override
- `void show()`  L422
- `void showDownloadManagerDialog()`  L434
- `void onClick(ICatchFile iCatchFile)`  L439 @Override
- `void onClick(View view)`  L448 @Override
- `void singleDownloadComplete(boolean z, ICatchFile iCatchFile)`  L455
### `com.icatch.golive.Function.CameraAction.PbDownloadManager$DownloadAsytask`
L116 · [class] DownloadAsytask · extends `AsyncTask<String, Integer, Boolean>` · `com/icatch/golive/Function/CameraAction/PbDownloadManager.java`

字段/常量（7）：
- `ICatchFile downloadFile`  L117
- `String fileName`  L118
- `String filePath`  L119
- `String TAG = "DownloadAsytask"`  L120
- `String fileType = null`  L121
- `PbDownloadManager pbDownloadManager = PbDownloadManager.this`  L194
- `PbDownloadManager pbDownloadManager2 = PbDownloadManager.this`  L196

方法（4）：
- `public DownloadAsytask(ICatchFile iCatchFile)`  L123
    - 体内字面量："/DCIM/idGoLive/photo/"
- `Boolean doInBackground(String... strArr)`  L136 @Override
    - 体内字面量："start downloadFile=" · "end downloadFile retvalue =" · "/DCIM/idGoLive/photo/" · "fileName = " · ".mov" · ".MOV" · "video/quicktime"
- `void onPostExecute(Boolean bool)`  L182 @Override
    - 体内字面量："receive DOWNLOAD_FAILURE downloadFailed="
- `void onProgressUpdate(Integer... numArr)`  L211 @Override
### `com.icatch.golive.Function.CameraAction.PbDownloadManager$DownloadProgressTask`
L215 · [class] DownloadProgressTask · extends `TimerTask` · `com/icatch/golive/Function/CameraAction/PbDownloadManager.java`

字段/常量（2）：
- `long lastTime = 0`  L216
- `ICatchFile iCatchFile = PbDownloadManager.this.curDownloadFile`  L226

方法（2）：
- `void run()`  L222 @Override
- `void run()`  L247 @Override
### `com.icatch.golive.Function.CameraAction.PhotoCapture`
L17 · [class] public PhotoCapture · `com/icatch/golive/Function/CameraAction/PhotoCapture.java`

字段/常量（10）：
- `String TAG = "PhotoCapture"`  L18
- `int TYPE_BURST_CAPTURE = 1`  L19
- `int TYPE_NORMAL_CAPTURE = 2`  L20
- `CameraAction cameraAction`  L21
- `CameraProperties cameraProperties`  L22
- `MediaPlayer continuousCaptureBeep`  L23
- `MediaPlayer delayBeep`  L24
- `OnCaptureListener onCaptureListener`  L25
- `OnStopPreviewListener onStopPreviewListener`  L26
- `MediaPlayer stillCaptureStartBeep`  L27

方法（4）：
- `public PhotoCapture()`  L145
- `void addOnStopPreviewListener(OnStopPreviewListener onStopPreviewListener)`  L154
- `void setOnCaptureListener(OnCaptureListener onCaptureListener)`  L158
- `void startCapture()`  L162
### `com.icatch.golive.Function.CameraAction.PhotoCapture$CaptureAudioTask`
L29 · [class] private CaptureAudioTask · extends `TimerTask` · `com/icatch/golive/Function/CameraAction/PhotoCapture.java`

字段/常量（2）：
- `int burstNumber`  L30
- `int type`  L31

方法（2）：
- `public CaptureAudioTask(int i, int i2)`  L33
- `void run()`  L39 @Override
    - 体内字面量："CaptureAudioTask remainBurstNumer =" · "CaptureAudioTask remainBurstNumer ="
### `com.icatch.golive.Function.CameraAction.PhotoCapture$CaptureThread`
L60 · [class] CaptureThread · implements `Runnable` · `com/icatch/golive/Function/CameraAction/PhotoCapture.java`

字段/常量（3）：
- `int i`  L66
- `int i2 = 0`  L68
- `int i3 = currentCaptureDelay / 1000`  L86

方法（2）：
- `void run()`  L65 @Override
- `void run()`  L73 @Override
### `com.icatch.golive.Function.CameraAction.PhotoCapture$DelayTimerTask`
L113 · [class] private DelayTimerTask · extends `TimerTask` · `com/icatch/golive/Function/CameraAction/PhotoCapture.java`

字段/常量（4）：
- `int count`  L114
- `Timer timer`  L115
- `int i = this.count`  L124
- `Timer timer = this.timer`  L130

方法（2）：
- `public DelayTimerTask(int i, Timer timer)`  L117
- `void run()`  L123 @Override
### `com.icatch.golive.Function.CameraAction.PhotoCapture$OnCaptureListener`
L137 · [interface] public OnCaptureListener · `com/icatch/golive/Function/CameraAction/PhotoCapture.java`

方法（1）：
- `void onCompleted()`  L138
### `com.icatch.golive.Function.CameraAction.PhotoCapture$OnStopPreviewListener`
L141 · [interface] public OnStopPreviewListener · `com/icatch/golive/Function/CameraAction/PhotoCapture.java`

方法（1）：
- `void onStop()`  L142
### `com.icatch.golive.Function.CameraAction.SdCardFormat`
L4 · [class] public SdCardFormat · `com/icatch/golive/Function/CameraAction/SdCardFormat.java`
### `com.icatch.golive.Function.CameraAction.ZoomInOut`
L10 · [class] public ZoomInOut · `com/icatch/golive/Function/CameraAction/ZoomInOut.java`

字段/常量（6）：
- `ZoomInOut zoomInOut`  L11
- `ZoomCompletedListener zoomCompletedListener`  L12
- `float lastZoomRate = 1.0f`  L13
- `int i = 50`  L24
- `int i2 = i - 1`  L27
- `int i3 = i - 1`  L37

方法（6）：
- `void zoom(PreviewPresenter previewPresenter)`  L22
- `void addZoomCompletedListener(ZoomCompletedListener zoomCompletedListener)`  L49
- `void startZoomInOutThread(final PreviewPresenter previewPresenter)`  L53
- `void run()`  L56 @Override
- `void zoomIn()`  L62
- `void zoomOut()`  L69
### `com.icatch.golive.Function.CameraAction.ZoomInOut$ZoomCompletedListener`
L17 · [interface] public ZoomCompletedListener · `com/icatch/golive/Function/CameraAction/ZoomInOut.java`

方法（1）：
- `void onCompleted(float f)`  L18
### `com.icatch.golive.Function.GlobalEvent`
L13 · [class] public GlobalEvent · `com/icatch/golive/Function/GlobalEvent.java`

字段/常量（9）：
- `int EVENT_SDCARD_INSERT = 17`  L14
- `int EVENT_SDCARD_REMOVED = 16`  L15
- `int EVENT_SEARCHED_NEW_CAMERA = 15`  L16
- `String TAG = "GlobalEvent"`  L17
- `Handler handler`  L18
- `NoSdcardListener noSdcardListener`  L19
- `ScanCameraListener scanCameraListener`  L20
- `ScanCameraListener scanCameraListener`  L66
- `NoSdcardListener noSdcardListener = this.noSdcardListener`  L69

方法（3）：
- `public GlobalEvent(Handler handler)`  L47
- `void addGlobalEventListener(int i, Boolean bool)`  L51
    - 体内字面量："Start addGlobalEventListener iCatchEventID=" · "End addGlobalEventListener"
- `void delGlobalEventListener(int i, Boolean bool)`  L65
### `com.icatch.golive.Function.GlobalEvent$NoSdcardListener`
L22 · [class] public NoSdcardListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/GlobalEvent.java`

方法（2）：
- `public NoSdcardListener()`  L23
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L27 @Override
    - 体内字面量："--------------receive NoSdcardListener" · "receive NoSdcardListener GlobalInfo.isSdCard = "
### `com.icatch.golive.Function.GlobalEvent$ScanCameraListener`
L35 · [class] public ScanCameraListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/GlobalEvent.java`

方法（2）：
- `public ScanCameraListener()`  L36
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L40 @Override
    - 体内字面量："Send..........EVENT_SEARCHED_NEW_CAMERA" · "1111" · "get a uid arg0.getgetStringValue3() =="
### `com.icatch.golive.Function.live.Facebook.FacebookInfo`
L4 · [class] public FacebookInfo · `com/icatch/golive/Function/live/Facebook/FacebookInfo.java`

字段/常量（2）：
- `String streamUrl`  L5
- `String videoId`  L6

方法（4）：
- `String getStreamUrl()`  L8
- `String getVideoId()`  L12
- `void setStreamUrl(String str)`  L16
- `void setVideoId(String str)`  L20
### `com.icatch.golive.Function.live.Facebook.GraphOperation`
L17 · [class] public GraphOperation · `com/icatch/golive/Function/live/Facebook/GraphOperation.java`

字段/常量（11）：
- `String TAG = "GraphOperation"`  L18
- `GraphRequest graphRequestNewPostRequest`  L36
- `JSONArray jSONArray`  L60
- `String str2`  L61
- `JSONException e`  L62
- `JSONObject jSONObject = null`  L71
- `String str3 = null`  L79
- `String str4 = null`  L80
- `String str7 = str3`  L104
- `GraphRequest graphRequestNewPostRequest`  L159
- `String str2 = MqttTopic.TOPIC_LEVEL_SEPARATOR + str + "/live_videos"`  L160

方法（11）：
- `AccessToken create(String str)`  L27
    - 体内字面量："create AccessToken curAccessToken=" · "create AccessToken accessToken="
- `void endLiveStream(AccessToken accessToken, String str)`  L35
- `void onCompleted(GraphResponse graphResponse)`  L41 @Override
    - 体内字面量："endLiveStream onCompleted" · "endLiveStream JSONException" · "end_live_video"
- `void getStreamByPageToken(AccessToken accessToken, final String str, final RequestCallback requestCallback)`  L56
    - 体内字面量："/me/accounts"
- `void onCompleted(GraphResponse graphResponse)`  L59 @Override
- `void getStreamByToken(final AccessToken accessToken, final RequestCallback requestCallback)`  L128
    - 体内字面量："/me?fields=id,name"
- `void onCompleted(GraphResponse graphResponse)`  L131 @Override
    - 体内字面量：" response=" · " response.getJSONObject()=" · " response.getJSONArray()=" · "jsonObject is null" · "id" · " id=" · "Did not find the user id " · "get id exception" · "get id exception"
- `void getStreamurl(AccessToken accessToken, String str, final RequestCallback requestCallback)`  L158
- `void onCompleted(GraphResponse graphResponse)`  L165 @Override
    - 体内字面量：" response=" · " response.getJSONObject()=" · "stream_url" · "id" · " jsonObject stream_url=" · " jsonObject id=" · "yyyy-MM-dd HH:mm:ss:sss\t" · " start live" · "title" · "My Test 360" · "description" · "{\"value\":\"EVERYONE\"}" · "save_vod" · "status" · "LIVE_NOW" · "stream_type" · "AMBIENT" · "is_spherical"
- `void getPageAccessToken(AccessToken accessToken, String str, RequestCallback requestCallback)`  L199
- `void onCompleted(GraphResponse graphResponse)`  L202 @Override
    - 体内字面量：" response=" · " response.getJSONObject()=" · " response.getJSONArray()=" · " response.getRequest()=" · " response.getRequest().getAccessToken()=" · " mjsonObject=" · "access_token" · "access_token" · "object instanceof AccessToken" · "object instanceof String=" · "object instanceof other" · "access_token"
### `com.icatch.golive.Function.live.Facebook.GraphOperation$RequestCallback`
L20 · [interface] public RequestCallback · `com/icatch/golive/Function/live/Facebook/GraphOperation.java`

方法（2）：
- `void onCompleted(String str, String str2)`  L21
- `void onError(String str)`  L23
### `com.icatch.golive.Function.live.google.CreateBroadcast`
L26 · [class] public CreateBroadcast · `com/icatch/golive/Function/live/google/CreateBroadcast.java`

字段/常量（7）：
- `String TAG = "CreateBroadcast"`  L27
- `LiveBroadcast liveBroadcast`  L28
- `String push_addr`  L29
- `String share_addr`  L30
- `YouTube youtube`  L31
- `String str = null`  L129
- `LiveBroadcast liveBroadcast2`  L179

方法（7）：
- `String createLive(Context context, Credential credential)`  L33
    - 体内字面量："youtube-cmdline-createbroadcast-sample" · "You chose " · " for broadcast title." · "public" · "youtube#liveBroadcast" · "360" · "snippet,status,contentDetails" · "\n================== Returned Broadcast ==================\n" · " publish - Id: " · " publish - Title: " · " publish - Description: " · " publish - Published At: " · " publish - Scheduled Start Time: " · " publish - Scheduled End Time: " · "You chose " · " for stream title." · "Education" · "rtmp://a.rtmp.youtube.com/live2" · "720p" · "rtmp" · "youtube#liveStream" · "snippet,cdn" · "\n================== Returned Stream ==================\n" · " publish - Id: " · " publish - Title: " · " publish - Description: " · " publish - Published At: " · " publish - Stream push address:" · "id,contentDetails" · "https://www.youtube.com/watch?v=" · "\n================== Returned Bound Broadcast ==================\n" · " publish - Broadcast Id: " · " publish - Bound Stream Id: " · " publish - Stream share address: " · "GoogleJsonResponseException code: " · " : " · "IOException: " · "Throwable: "
- `String getBroadcastTitle()`  L107
    - 体内字面量："360Test"
- `String getStreamTitle()`  L111
    - 体内字面量："Live Stream"
- `void startEvent(String str)`  L115
    - 体内字面量："Info" · "publish broadcast - set Status: testing" · "Info" · "publish broadcast - start Event" · "live" · "status" · "Info" · "publish broadcast - start Execute" · "Info" · "publish broadcast - start Execute success"
- `String startLive()`  L128
- `void stopLive()`  L172
    - 体内字面量："Info" · "Start publish broadcast - stop Live" · "complete" · "status" · "Info" · "End publish broadcast - stop Live"
- `void waitTestingState()`  L178
### `com.icatch.golive.Function.live.google.Credentials`
L4 · [class] public Credentials · `com/icatch/golive/Function/live/google/Credentials.java`

字段/常量（6）：
- `String FACEBOOK_APP_ID = "1540807289473122"`  L5
- `String FACEBOOK_APP_SECRET = "236e282277e8ee3150c447cf0307bcb3"`  L6
- `String FACEBOOK_REDIRECT_URI = "http://demo.xarx.rocks/"`  L7
- `String GOOGLE_CLIENT_ID = "982555336638-vis3bioouhq71m4logk3qo525dpt3b37.apps.googleusercontent.com"`  L8
- `String GOOGLE_CLIENT_SECRET = "RsVLvlB509wjbY4clv5ih_mn"`  L9
- `String GOOGLE_REDIRECT_URI = "http://localhost:8080"`  L10
### `com.icatch.golive.Function.live.google.GoogleAuthTool`
L12 · [class] public GoogleAuthTool · `com/icatch/golive/Function/live/google/GoogleAuthTool.java`

字段/常量（4）：
- `String CLIENT_ID = "168811923581-u0njo0me7v4dd2ihb1n1c5hbkk0d1v9d.apps.googleusercontent.com"`  L13
- `String CLIENT_SECRET = "6sMzO0akSmW2GOcSyQPGkm4o"`  L14
- `String TAG = "GoogleAuthTool"`  L15
- `String accessToken`  L18

方法（1）：
- `String refreshAccessToken(Context context, String str)`  L17
### `com.icatch.golive.Function.live.google.YoutubeCredential`
L21 · [class] public YoutubeCredential · `com/icatch/golive/Function/live/google/YoutubeCredential.java`

方法（3）：
- `Credential authorize(GoogleClientSecrets googleClientSecrets, OAuth2AccessToken oAuth2AccessToken)`  L25
    - 体内字面量："https://www.googleapis.com/auth/user.birthday.read" · "user"
- `Credential authorize(GoogleClientSecrets googleClientSecrets, String str, String str2)`  L33
    - 体内字面量："https://www.googleapis.com/auth/user.birthday.read" · "user"
- `GoogleClientSecrets readClientSecrets(Activity activity)`  L41
### `com.icatch.golive.Function.live.google.YouTubeUrl`
L4 · [class] public YouTubeUrl · `com/icatch/golive/Function/live/google/YouTubeUrl.java`

字段/常量（2）：
- `String push_addr`  L5
- `String share_addr`  L6

方法（3）：
- `public YouTubeUrl(String str, String str2)`  L8
- `String getPush_addr()`  L13
- `String getShare_addr()`  L17
### `com.icatch.golive.Function.SDKEvent`
L18 · [class] public SDKEvent · `com/icatch/golive/Function/SDKEvent.java`

字段/常量（76）：
- `int EVENT_BATTERY_ELETRIC_CHANGED = 0`  L19
- `int EVENT_CAPTURE_COMPLETED = 1`  L20
- `int EVENT_CAPTURE_START = 3`  L21
- `int EVENT_CONNECTION_FAILURE = 8`  L22
- `int EVENT_FILE_ADDED = 7`  L23
- `int EVENT_FILE_DOWNLOAD = 11`  L24
- `int EVENT_FW_UPDATE_CHECK = 25`  L25
- `int EVENT_FW_UPDATE_CHKSUMERR = 26`  L26
- `int EVENT_FW_UPDATE_COMPLETED = 13`  L27
- `int EVENT_FW_UPDATE_NG = 27`  L28
- `int EVENT_FW_UPDATE_POWEROFF = 14`  L29
- `int EVENT_SDCARD_INSERT = 17`  L30
- `int EVENT_SDCARD_REMOVED = 16`  L31
- `int EVENT_SD_CARD_FULL = 4`  L32
- `int EVENT_SEARCHED_NEW_CAMERA = 15`  L33
- `int EVENT_SERVER_STREAM_ERROR = 10`  L34
- `int EVENT_TIME_LAPSE_STOP = 9`  L35
- `int EVENT_VIDEO_OFF = 5`  L36
- `int EVENT_VIDEO_ON = 6`  L37
- `int EVENT_VIDEO_PLAY_CLOSED = 24`  L38
- `int EVENT_VIDEO_PLAY_PTS = 23`  L39
- `int EVENT_VIDEO_RECORDING_TIME = 12`  L40
- `String TAG = "SDKEvent"`  L41
- `BatteryStateListener batteryStateListener`  L42
- `CacheProgressListener cacheProgressListener`  L43
- `CacheStateChangedListener cacheStateChangedListener`  L44
- `CameraAction cameraAction`  L45
- `CaptureDoneListener captureDoneListener`  L46
- `CaptureStartListener captureStartListener`  L47
- `ConnectionFailureListener connectionFailureListener`  L48
- `FileAddedListener fileAddedListener`  L49
- `FileDownloadListener fileDownloadListener`  L50
- `Handler handler`  L51
- `InsertSdcardListener insertSdcardListener`  L52
- `NetworkDisconnectListener networkDisconnectListener`  L53
- `NoEISInformationListener noEISInformationListener`  L54
- `NoSdcardListener noSdcardListener`  L55
- `PanoramaControl panoramaControl`  L56
- `SdcardStateListener sdcardStateListener`  L57
- `ServerStreamErrorListener serverStreamErrorListener`  L58
- `TimeLapseStopListener timeLapseStopListener`  L59
- `UpdateFWCHKSumErrListener updateFWCHKSumErrListener`  L60
- `UpdateFWCheckListener updateFWCheckListener`  L61
- `UpdateFWCompletedListener updateFWCompletedListener`  L62
- `UpdateFWNGListener updateFWNGListener`  L63
- `UpdateFWPoweroffListener updateFWPoweroffListener`  L64
- `VideoCodecInformationListener videoCodecInformationListener`  L65
- `VideoOffListener videoOffListener`  L66
- `VideoOnListener videoOnListener`  L67
- `VideoRecordingTimeStartListener videoRecordingTimeStartListener`  L68
- `VideoStreamCloseListener videoStreamCloseListener`  L69
- `VideoStreamStatusListener videoStreamStatusListener`  L70
- `VideoRecordingTimeStartListener videoRecordingTimeStartListener`  L533
- `InsertSdcardListener insertSdcardListener = this.insertSdcardListener`  L542
- `NoSdcardListener noSdcardListener`  L550
- `UpdateFWPoweroffListener updateFWPoweroffListener`  L551
- `UpdateFWCompletedListener updateFWCompletedListener`  L552
- `FileDownloadListener fileDownloadListener`  L553
- `TimeLapseStopListener timeLapseStopListener`  L554
- `VideoOnListener videoOnListener`  L555
- `FileAddedListener fileAddedListener`  L556
- `VideoOffListener videoOffListener`  L557
- `CaptureStartListener captureStartListener`  L558
- `CaptureDoneListener captureDoneListener`  L559
- `BatteryStateListener batteryStateListener`  L560
- `UpdateFWNGListener updateFWNGListener`  L561
- `UpdateFWCHKSumErrListener updateFWCHKSumErrListener`  L562
- `UpdateFWCheckListener updateFWCheckListener`  L563
- `SdcardStateListener sdcardStateListener`  L564
- `CacheStateChangedListener cacheStateChangedListener`  L622
- `VideoStreamStatusListener videoStreamStatusListener = this.videoStreamStatusListener`  L624
- `VideoStreamCloseListener videoStreamCloseListener = this.videoStreamCloseListener`  L633
- `NoEISInformationListener noEISInformationListener = this.noEISInformationListener`  L642
- `VideoCodecInformationListener videoCodecInformationListener = this.videoCodecInformationListener`  L651
- `NetworkDisconnectListener networkDisconnectListener = this.networkDisconnectListener`  L660
- `CacheProgressListener cacheProgressListener = this.cacheProgressListener`  L676

方法（8）：
- `public SDKEvent(Handler handler)`  L389
- `public SDKEvent(Handler handler, PanoramaControl panoramaControl)`  L395
- `void addCustomizeEvent(int i)`  L400
- `void addEventListener(int i)`  L414
- `void addPanoramaEventListener(int i)`  L489
    - 体内字面量："addPanoramaEventListener videoStreamStatusListener"
- `void delCustomizeEventListener(int i)`  L532
- `void delEventListener(int i)`  L549
- `void removePanoramaEventListener(int i)`  L621
### `com.icatch.golive.Function.SDKEvent$BatteryStateListener`
L72 · [class] public BatteryStateListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public BatteryStateListener()`  L73
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L77 @Override
    - 体内字面量："--------------receive event:BatteryStateListener intValue1:" · " intValue2:"
### `com.icatch.golive.Function.SDKEvent$CacheProgressListener`
L83 · [class] public CacheProgressListener · implements `ICatchIPancamListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public CacheProgressListener()`  L84
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L88 @Override
    - 体内字面量："receive CacheProgressListener.......temp="
### `com.icatch.golive.Function.SDKEvent$CacheStateChangedListener`
L95 · [class] public CacheStateChangedListener · implements `ICatchIPancamListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public CacheStateChangedListener()`  L96
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L100 @Override
    - 体内字面量："receive CacheStateChangedListener........iCatchGLEvent.getLongValue1()="
### `com.icatch.golive.Function.SDKEvent$CaptureDoneListener`
L106 · [class] public CaptureDoneListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public CaptureDoneListener()`  L107
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L111 @Override
    - 体内字面量："--------------receive event:capture done"
### `com.icatch.golive.Function.SDKEvent$CaptureStartListener`
L117 · [class] public CaptureStartListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public CaptureStartListener()`  L118
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L122 @Override
    - 体内字面量："--------------receive event:capture start"
### `com.icatch.golive.Function.SDKEvent$ConnectionFailureListener`
L128 · [class] public ConnectionFailureListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public ConnectionFailureListener()`  L129
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L133 @Override
    - 体内字面量："--------------receive event:ConnectionFailureListener"
### `com.icatch.golive.Function.SDKEvent$CustomEventListener`
L139 · [class] public CustomEventListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public CustomEventListener()`  L140
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L144 @Override
    - 体内字面量："eventNotify iCatchCamEvent EventID:" · "eventNotify iCatchCamEvent StringValue1:" · "eventNotify iCatchCamEvent IntValue1:" · "eventNotify iCatchCamEvent DoubleValue1:"
### `com.icatch.golive.Function.SDKEvent$FileAddedListener`
L152 · [class] public FileAddedListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public FileAddedListener()`  L153
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L157 @Override
    - 体内字面量："--------------receive event:FileAddedListener"
### `com.icatch.golive.Function.SDKEvent$FileDownloadListener`
L163 · [class] public FileDownloadListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public FileDownloadListener()`  L164
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L168 @Override
    - 体内字面量："--------------receive event:FileDownloadListener" · "1111" · "receive event:FileDownloadListener"
### `com.icatch.golive.Function.SDKEvent$ICatchCodecEventListener`
L175 · [class] public ICatchCodecEventListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public ICatchCodecEventListener()`  L176
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L180 @Override
    - 体内字面量："event: EVENT_SD_CARD_FULL"
### `com.icatch.golive.Function.SDKEvent$InsertSdcardListener`
L186 · [class] public InsertSdcardListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public InsertSdcardListener()`  L187
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L191 @Override
    - 体内字面量："--------------receive InsertSdcardListener" · "receive InsertSdcardListener GlobalInfo.isSdCard = "
### `com.icatch.golive.Function.SDKEvent$NetworkDisconnectListener`
L199 · [class] private NetworkDisconnectListener · implements `ICatchIPancamListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `private NetworkDisconnectListener()`  L200
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L204 @Override
    - 体内字面量："--------------receive VideoStreamCloseListener"
### `com.icatch.golive.Function.SDKEvent$NoEISInformationListener`
L210 · [class] private NoEISInformationListener · implements `ICatchIPancamListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `private NoEISInformationListener()`  L211
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L215 @Override
    - 体内字面量："--------------receive NoEISInformationListener"
### `com.icatch.golive.Function.SDKEvent$NoSdcardListener`
L221 · [class] public NoSdcardListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public NoSdcardListener()`  L222
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L226 @Override
    - 体内字面量："--------------receive NoSdcardListener" · "receive NoSdcardListener GlobalInfo.isSdCard = "
### `com.icatch.golive.Function.SDKEvent$SdcardStateListener`
L234 · [class] public SdcardStateListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public SdcardStateListener()`  L235
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L239 @Override
    - 体内字面量："event: EVENT_SD_CARD_FULL"
### `com.icatch.golive.Function.SDKEvent$ServerStreamErrorListener`
L245 · [class] public ServerStreamErrorListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public ServerStreamErrorListener()`  L246
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L250 @Override
    - 体内字面量："--------------receive event:ServerStreamErrorListener"
### `com.icatch.golive.Function.SDKEvent$TimeLapseStopListener`
L256 · [class] public TimeLapseStopListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public TimeLapseStopListener()`  L257
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L261 @Override
    - 体内字面量："--------------receive event:TimeLapseStopListener"
### `com.icatch.golive.Function.SDKEvent$UpdateFWCheckListener`
L278 · [class] public UpdateFWCheckListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public UpdateFWCheckListener()`  L279
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L283 @Override
    - 体内字面量："--------------receive UpdateFWCheckListener"
### `com.icatch.golive.Function.SDKEvent$UpdateFWCHKSumErrListener`
L267 · [class] public UpdateFWCHKSumErrListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public UpdateFWCHKSumErrListener()`  L268
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L272 @Override
    - 体内字面量："--------------receive UpdateFWCHKSumErrListener"
### `com.icatch.golive.Function.SDKEvent$UpdateFWCompletedListener`
L289 · [class] public UpdateFWCompletedListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public UpdateFWCompletedListener()`  L290
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L294 @Override
    - 体内字面量："--------------receive UpdateFWCompletedListener"
### `com.icatch.golive.Function.SDKEvent$UpdateFWNGListener`
L300 · [class] public UpdateFWNGListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public UpdateFWNGListener()`  L301
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L305 @Override
    - 体内字面量："--------------receive UpdateFWNGListener"
### `com.icatch.golive.Function.SDKEvent$UpdateFWPoweroffListener`
L311 · [class] public UpdateFWPoweroffListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public UpdateFWPoweroffListener()`  L312
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L316 @Override
    - 体内字面量："--------------receive UpdateFWPoweroffListener"
### `com.icatch.golive.Function.SDKEvent$VideoCodecInformationListener`
L322 · [class] private VideoCodecInformationListener · implements `ICatchIPancamListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `private VideoCodecInformationListener()`  L323
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L327 @Override
    - 体内字面量："--------------receive VideoCodecInformationListener" · "Warning, Insufficient performance.\ncodec: %d,Video width:%d,height: %d,Frame interval: %.4f,decode time: %.4f\nThe playback will stutter." · "__codec_performance__"
### `com.icatch.golive.Function.SDKEvent$VideoOffListener`
L335 · [class] public VideoOffListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public VideoOffListener()`  L336
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L340 @Override
    - 体内字面量："--------------receive event:videooff"
### `com.icatch.golive.Function.SDKEvent$VideoOnListener`
L346 · [class] public VideoOnListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public VideoOnListener()`  L347
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L351 @Override
    - 体内字面量："--------------receive event:videoON"
### `com.icatch.golive.Function.SDKEvent$VideoRecordingTimeStartListener`
L357 · [class] public VideoRecordingTimeStartListener · implements `ICatchCameraListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public VideoRecordingTimeStartListener()`  L358
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L362 @Override
    - 体内字面量："--------------receive VideoRecordingTimeStartListener"
### `com.icatch.golive.Function.SDKEvent$VideoStreamCloseListener`
L368 · [class] public VideoStreamCloseListener · implements `ICatchIPancamListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public VideoStreamCloseListener()`  L369
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L373 @Override
    - 体内字面量："--------------receive VideoStreamCloseListener"
### `com.icatch.golive.Function.SDKEvent$VideoStreamStatusListener`
L379 · [class] public VideoStreamStatusListener · implements `ICatchIPancamListener` · `com/icatch/golive/Function/SDKEvent.java`

方法（2）：
- `public VideoStreamStatusListener()`  L380
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L384 @Override
### `com.icatch.golive.Function.Setting.OptionSetting`
L51 · [class] public OptionSetting · `com/icatch/golive/Function/Setting/OptionSetting.java`

字段/常量（58）：
- `String TAG = "OptionSetting"`  L52
- `Activity activity`  L53
- `AlertDialog alertDialog`  L54
- `BaseProrertys baseProrertys`  L55
- `CameraAction cameraAction`  L56
- `CameraProperties cameraProperties`  L57
- `Context context`  L58
- `MyCamera myCamera`  L60
- `OnSettingCompleteListener onSettingCompleteListener`  L61
- `String password`  L62
- `SDKEvent sdkEvent`  L63
- `String wifiSsid`  L64
- `int length = valueList.length`  L472
- `int i = 0`  L474
- `int length = valueList.length`  L576
- `int i = 0`  L578
- `int length = valueList.length`  L601
- `int i = 0`  L603
- `int length = valueList.length`  L626
- `int i = 0`  L628
- `int length = valueList.length`  L651
- `int i = 0`  L653
- `int length = valueList.length`  L688
- `int i = 0`  L690
- `int length = valueList.length`  L743
- `int i = 0`  L745
- `int length = valueStringList.length`  L768
- `int i = 0`  L770
- `String str = TAG`  L788
- `int length = valueStringList.length`  L796
- `int i = 0`  L798
- `int length = valueList.length`  L821
- `int i = 0`  L823
- `String str = valueList[i2]`  L826
- `int length = valueList.length`  L863
- `int i = 0`  L865
- `String str`  L882
- `int length = valueArrayString.length`  L890
- `int i = 0`  L892
- `String str3 = strArrSplit[0]`  L901
- `String str4 = strArrSplit[1]`  L902
- `int length = valueList.length`  L930
- `int i = 0`  L932
- `int length = valueList.length`  L1012
- `int i = 0`  L1014
- `int length = valueList.length`  L1068
- `int i = 0`  L1070
- `int length = valueList.length`  L1093
- `int i = 0`  L1095
- `int length = valueArrayString.length`  L1127
- `int i = 0`  L1129
- `int length = valueList.length`  L1152
- `int i = 0`  L1154
- `boolean zIsSDCardExist`  L1197
- `String str = PreviewPresenter.str_close`  L1359
- `String str2 = PreviewPresenter.str_minutes`  L1360
- `int length = strArr.length`  L1375
- `int i = 0`  L1377

方法（68）：
- `public OptionSetting()`  L443
- `void sdCardIsNotReadyAlert(Context context)`  L451
    - 体内字面量："OK"
- `void onClick(DialogInterface dialogInterface, int i)`  L456 @Override
- `void showBurstOptionDialog(Context context)`  L465
    - 体内字面量："burstUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L482 @Override
    - 体内字面量："1111" · "refresh optionListAdapter!"
- `void showCameraConfigurationDialog(final Context context)`  L491
    - 体内字面量："DC1Pro"
- `void onClick(DialogInterface dialogInterface, int i)`  L509 @Override
    - 体内字面量："mShowing"
- `void onClick(DialogInterface dialogInterface, int i)`  L522 @Override
    - 体内字面量："mShowing" · "mShowing" · "mShowing"
- `void showDateStampOptionDialog(Context context)`  L569
    - 体内字面量："dateStampUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L586 @Override
- `void showDelayTimeOptionDialog(Context context)`  L594
    - 体内字面量："delayTimeUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L611 @Override
- `void showDelayTimeOptionDialog(Context context, final OnSettingCompleteListener onSettingCompleteListener)`  L619
    - 体内字面量："delayTimeUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L636 @Override
- `void showElectricityFrequencyOptionDialog(Context context)`  L644
    - 体内字面量："eleFreUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L661 @Override
- `void showFormatConfirmDialog(Context context)`  L669
- `void onClick(DialogInterface dialogInterface, int i)`  L674 @Override
- `void showMicRecodingOptionDialog(Context context)`  L681
    - 体内字面量："dateStampUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L698 @Override
- `void showOptionDialog(CharSequence charSequence, CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener, boolean z)`  L710
- `void showResetDeviceConfirmDialog(Context context)`  L717
- `void onClick(DialogInterface dialogInterface, int i)`  L722 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L727 @Override
- `void showSlowMotionDialog(Context context)`  L736
    - 体内字面量："slowmotionUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L753 @Override
- `void showTimeLapseDurationDialog(Context context)`  L761
    - 体内字面量："videoTimeLapseDurationString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L778 @Override
- `void showTimeLapseIntervalDialog(Context context)`  L786
- `void onClick(DialogInterface dialogInterface, int i3)`  L806 @Override
- `void showTimeLapseModeDialog(Context context)`  L814
    - 体内字面量："timeLapseModeString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L833 @Override
    - 体内字面量："tigertiger" · "showTimeLapseModeDialog  timeLapseMode ="
- `void showUpdateFWDialog(Context context, String str)`  L843
    - 体内字面量："showUpdateFWDialog"
- `void onClick(DialogInterface dialogInterface, int i)`  L849 @Override
- `void showUpsideDialog(Context context)`  L856
    - 体内字面量："upsideUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L873 @Override
- `void showVideoSizeOptionDialog(Context context)`  L881
- `void onClick(DialogInterface dialogInterface, int i3)`  L914 @Override
- `void showWhiteBalanceOptionDialog(Context context)`  L923
    - 体内字面量："whiteBalanceUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L946 @Override
- `void addSettingCompleteListener(OnSettingCompleteListener onSettingCompleteListener)`  L954
- `void connectWifi(String str, String str2)`  L958
    - 体内字面量："wifi"
- `void handleFirmwareUpdate()`  L976
    - 体内字面量："str_firmware_path: "
- `void onClick(DialogInterface dialogInterface, int i)`  L984 @Override
    - 体内字面量："$1$" · "$2$"
- `void m490x4ef141b(DialogInterface dialogInterface, int i)`  L999
- `void showAutoPowerOffDialog(Context context)`  L1005
    - 体内字面量："autoPowerOffUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L1022 @Override
- `void showEnableWifihotspotDialog()`  L1030
- `boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent)`  L1041 @Override
    - 体内字面量："1111" · "KeyEvent.KEYCODE_BACK" · "mShowing"
- `void showExposureCompensationDialog(Context context)`  L1061
    - 体内字面量："exposureCompensationUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L1078 @Override
- `void showFastMotionMovieDialog(Context context)`  L1086
    - 体内字面量："fastMotionMovieUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L1103 @Override
- `void showGSensorDialog(Context context)`  L1111
- `void onClick(DialogInterface dialogInterface, int i)`  L1114 @Override
- `void showImageSizeOptionDialog(Context context)`  L1120
    - 体内字面量："imageSizeUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L1137 @Override
- `void showScreenSaverDialog(Context context)`  L1145
    - 体内字面量："screenSaverUIString == null"
- `void onClick(DialogInterface dialogInterface, int i3)`  L1162 @Override
- `void showSetDownloadSizeLimitDialog(Context context)`  L1170
- `void onClick(DialogInterface dialogInterface, int i)`  L1180 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L1190 @Override
- `void showSettingDialog(int i, Activity activity)`  L1196
- `void showStorageLocationDialog(final Context context)`  L1328
    - 体内字面量："appData" · "storageLocation" · "InternalStorage" · "InternalStorage"
- `void onClick(DialogInterface dialogInterface, int i)`  L1331 @Override
    - 体内字面量："appData" · "storageLocation" · "InternalStorage" · "appData" · "storageLocation" · "SdCard" · "tigertiger" · "showStorageLocationDialog  storageLocation ="
- `void showUSBImageSizeOptionDialog(Context context)`  L1348
- `void showVideoFileLengthDialog(Context context)`  L1356
- `void onClick(DialogInterface dialogInterface, int i3)`  L1385 @Override
### `com.icatch.golive.Function.Setting.OptionSetting$AnonymousClass18`
L67 · [class] AnonymousClass18 · implements `Runnable` · `com/icatch/golive/Function/Setting/OptionSetting.java`

字段/常量（5）：
- `Handler val$handler`  L68
- `MyCamera val$myCamera`  L69
- `CharSequence val$title`  L70
- `int i`  L93
- `int i2 = 0`  L100

方法（4）：
- `void run()`  L79 @Override
- `void run()`  L83 @Override
    - 体内字面量："list == null"
- `void run()`  L92 @Override
- `void onClick(DialogInterface dialogInterface, int i4)`  L119 @Override
### `com.icatch.golive.Function.Setting.OptionSetting$AnonymousClass24`
L134 · [class] AnonymousClass24 · implements `DialogInterface.OnClickListener` · `com/icatch/golive/Function/Setting/OptionSetting.java`

字段/常量（1）：
- `Context val$context`  L135

方法（3）：
- `void onClick(DialogInterface dialogInterface, int i)`  L142 @Override
- `void run()`  L148 @Override
- `void run()`  L152 @Override
### `com.icatch.golive.Function.Setting.OptionSetting$AnonymousClass6`
L163 · [class] AnonymousClass6 · implements `DialogInterface.OnClickListener` · `com/icatch/golive/Function/Setting/OptionSetting.java`

字段/常量（2）：
- `EditText val$cameraPassword`  L164
- `EditText val$wifiName`  L165

方法（1）：
- `void onClick(DialogInterface dialogInterface, int i)`  L230 @Override
    - 体内字面量："mShowing" · "mShowing" · "mShowing" · "mShowing"
### `com.icatch.golive.Function.Setting.OptionSetting$AnonymousClass6$AnonymousClass1`
L168 · [class] AnonymousClass1 · implements `Runnable` · `com/icatch/golive/Function/Setting/OptionSetting.java`

方法（3）：
- `void run()`  L173 @Override
- `void run()`  L201 @Override
    - 体内字面量："$1$" · "$2$" · "Wifiç­ç¹å¼å¯å¤±è´¥ï¼å¯è½ç³»ç»ä¸æ¯æï¼éè¦æå¨å¼å¯,å¹¶è®¾ç½®Wifiç­ç¹åç§°ä¸ºï¼" · " å¯ç ä¸ºï¼" · " è®¾ç½®å®æåï¼è¯·éæ°å¯å¨å¹¶è¿æ¥ã"
- `void onClick(DialogInterface dialogInterface, int i)`  L208 @Override
    - 体内字面量："com.android.settings" · "com.android.settings.Settings$TetherSettingsActivity"
### `com.icatch.golive.Function.Setting.OptionSetting$AnonymousClass8`
L283 · [class] AnonymousClass8 · implements `DialogInterface.OnClickListener` · `com/icatch/golive/Function/Setting/OptionSetting.java`

字段/常量（2）：
- `Context val$context`  L284
- `String val$fileName`  L285

方法（3）：
- `void onClick(DialogInterface dialogInterface, int i)`  L293 @Override
    - 体内字面量："..."
- `void run()`  L305 @Override
- `void run()`  L311 @Override
### `com.icatch.golive.Function.Setting.OptionSetting$SettingHander`
L321 · [class] private SettingHander · extends `Handler` · `com/icatch/golive/Function/Setting/OptionSetting.java`

字段/常量（1）：
- `int i = message.what`  L327

方法（7）：
- `private SettingHander()`  L322
- `void handleMessage(Message message)`  L326 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L346 @Override
    - 体内字面量："com.android.settings" · "com.android.settings.Settings$TetherSettingsActivity" · "receive EVENT_FW_UPDATE_COMPLETED"
- `void onClick(DialogInterface dialogInterface, int i2)`  L365 @Override
    - 体内字面量："1111" · "update FW completed!" · "receive EVENT_FW_UPDATE_POWEROFF"
- `void onClick(DialogInterface dialogInterface, int i2)`  L385 @Override
    - 体内字面量："1111" · "App quit" · "receive EVENT_FW_UPDATE_CHECK" · "receive EVENT_FW_UPDATE_CHKSUMERR"
- `void onClick(DialogInterface dialogInterface, int i2)`  L410 @Override
    - 体内字面量："1111" · "App FW updatefw chech sume failed" · "receive EVENT_FW_UPDATE_NG"
- `void onClick(DialogInterface dialogInterface, int i2)`  L430 @Override
    - 体内字面量："1111" · "App FW updatefw failed"
### `com.icatch.golive.Function.Setting.UIDisplaySource`
L22 · [class] public UIDisplaySource · `com/icatch/golive/Function/Setting/UIDisplaySource.java`

字段/常量（16）：
- `int CAPTURE_SETTING_MENU = 1`  L23
- `int TIMELAPSE_SETTING_MENU = 3`  L24
- `int VIDEO_SETTING_MENU = 2`  L25
- `UIDisplaySource uiDisplayResource`  L26
- `BaseProrertys baseProrertys`  L27
- `CameraFixedInfo cameraFixedInfo`  L28
- `CameraProperties cameraProperties`  L29
- `CameraState cameraState`  L30
- `MyCamera curCamera`  L31
- `List<SettingGroup> settingMenuList`  L32
- `String str`  L35
- `List<SettingGroup> list = this.settingMenuList`  L36
- `String str2 = strArrSplit[0]`  L66
- `String str3 = strArrSplit[1]`  L67
- `List<SettingGroup> list = this.settingMenuList`  L136
- `List<SettingGroup> list = this.settingMenuList`  L177

方法（7）：
- `List<SettingGroup> getForVideoMode()`  L34
- `SettingGroup getInfoGroup()`  L99
- `UIDisplaySource getinstance()`  L128
- `List<SettingGroup> getForCaptureMode()`  L135
- `List<SettingGroup> getForTimelapseMode()`  L176
- `List<SettingGroup> getList(int i, MyCamera myCamera)`  L205
- `LinkedList<SettingMenu> getUSBList(Context context)`  L223
### `com.icatch.golive.Function.streaming.CameraStreaming`
L15 · [class] public CameraStreaming · `com/icatch/golive/Function/streaming/CameraStreaming.java`

字段/常量（28）：
- `MediaCodec decoder`  L16
- `H264DecoderThread h264DecoderThread`  L17
- `SurfaceHolder holder`  L18
- `ICatchIStreamProvider iCatchIStreamProvider`  L19
- `MjpgDecoderThread mjpgDecoderThread`  L20
- `int previewCodec`  L21
- `PanoramaPreviewPlayback previewPlayback`  L22
- `StreamProvider streamProvider`  L23
- `Surface surface`  L24
- `ICatchVideoFormat videoFormat`  L25
- `String TAG = "CameraStreaming"`  L26
- `boolean isStreaming = false`  L27
- `boolean freezeDecoder = false`  L28
- `int frmW = 0`  L29
- `int frmH = 0`  L30
- `int viewWidth = 0`  L31
- `int viewHeigth = 0`  L32
- `int i2 = this.previewCodec`  L48
- `int i`  L82
- `int i2`  L83
- `int i3 = this.viewWidth`  L85
- `int i4 = this.frmH`  L89
- `SurfaceHolder surfaceHolder = this.holder`  L92
- `int i5 = this.viewWidth`  L93
- `int i6 = this.previewCodec`  L97
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L99
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L152
- `H264DecoderThread h264DecoderThread = this.h264DecoderThread`  L157

方法（9）：
- `public CameraStreaming(PanoramaPreviewPlayback panoramaPreviewPlayback)`  L34
- `void startDecoderThread(int i, ICatchVideoFormat iCatchVideoFormat)`  L38
    - 体内字面量："start startDecoderThread" · "start startDecoderThread videoFormat is null" · "start startDecoderThread videoFormat:" · "start startDecoderThread previewCodec=" · " enableAudio="
- `void disnableRender()`  L65
- `boolean isStreaming()`  L70
    - 体内字面量："get getStream: "
- `void setSurface(SurfaceHolder surfaceHolder)`  L75
    - 体内字面量："initSurface: "
- `void setSurfaceViewArea()`  L81
- `void setViewParam(int i, int i2)`  L113
- `Tristate start(ICatchStreamParam iCatchStreamParam, boolean z)`  L118
    - 体内字面量："startStreaming, enableAudio: " · "surface is not set" · "apv streaming already started" · "sdk start streamProvider ret =" · "sdk start streamProvider OK" · "get video format err: "
- `boolean stop()`  L149
    - 体内字面量："stopStreaming isStreaming = " · "stopMPreview preview"
### `com.icatch.golive.Function.streaming.H264DecoderThread`
L20 · [class] public H264DecoderThread · `com/icatch/golive/Function/streaming/H264DecoderThread.java`

字段/常量（21）：
- `String TAG = "H264DecoderThread"`  L21
- `AudioThread audioThread`  L22
- `MediaCodec decoder`  L23
- `int frameHeight`  L24
- `VideoFramePtsChangedListener framePtsChangedListener`  L25
- `int frameWidth`  L26
- `int previewLaunchMode`  L27
- `StreamProvider streamProvider`  L28
- `Surface surface`  L29
- `ICatchVideoFormat videoFormat`  L30
- `VideoThread videoThread`  L31
- `boolean audioPlayFlag = false`  L32
- `int BUFFER_LENGTH = 3686400`  L33
- `int timeout = 20000`  L34
- `long videoShowtime = 0`  L35
- `double curVideoPts = 0.0d`  L36
- `ICatchVideoFormat iCatchVideoFormat = this.videoFormat`  L190
- `VideoThread videoThread = this.videoThread`  L213
- `AudioThread audioThread = this.audioThread`  L217
- `AudioThread audioThread = this.audioThread`  L241
- `VideoThread videoThread = this.videoThread`  L245

方法（6）：
- `public H264DecoderThread(StreamProvider streamProvider, Surface surface, int i)`  L177
- `void setFormat()`  L189
- `boolean isAlive()`  L212
- `void setframePtsChangedListener(VideoFramePtsChangedListener videoFramePtsChangedListener)`  L221
- `void start(boolean z, boolean z2)`  L225
    - 体内字面量："start"
- `void stop()`  L240
### `com.icatch.golive.Function.streaming.H264DecoderThread$AudioThread`
L38 · [class] private AudioThread · extends `Thread` · `com/icatch/golive/Function/streaming/H264DecoderThread.java`

字段/常量（2）：
- `AudioTrack audioTrack`  L39
- `boolean done`  L40

方法（3）：
- `private AudioThread()`  L42
- `void requestExitAndWait()`  L46
- `void run()`  L55 @Override
    - 体内字面量："Run AudioThread" · "Run AudioThread audioFormat is null!" · "Run AudioThread 3" · "getNextVideoFrame " · "stopMPreview audio thread"
### `com.icatch.golive.Function.streaming.H264DecoderThread$VideoThread`
L87 · [class] private VideoThread · extends `Thread` · `com/icatch/golive/Function/streaming/H264DecoderThread.java`

字段/常量（7）：
- `MediaCodec.BufferInfo info`  L88
- `long startTime = 0`  L89
- `int frameSize = 0`  L90
- `boolean done = false`  L91
- `byte[] bArr = new byte[H264DecoderThread.this.frameWidth * H264DecoderThread.this.frameHeight * 4]`  L121
- `boolean z = true`  L126
- `ByteBuffer byteBuffer = inputBuffers[iDequeueInputBuffer]`  L143

方法（3）：
- `boolean dequeueAndRenderOutputBuffer(int i)`  L96
    - 体内字面量："ok show image!.....................startTime= " · " frameSize=" · " curVideoPts="
- `void requestExitAndWait()`  L110
    - 体内字面量："H264Decoder requestExitAndWait isAlive=" · "end  H264Decoder requestExitAndWait"
- `void run()`  L117 @Override
    - 体内字面量："h264 run for gettting surface image"
### `com.icatch.golive.Function.streaming.MjpgDecoderThread`
L20 · [class] public MjpgDecoderThread · `com/icatch/golive/Function/streaming/MjpgDecoderThread.java`

字段/常量（19）：
- `String TAG = "MjpgDecoderThread"`  L21
- `AudioThread audioThread`  L22
- `Rect drawFrameRect`  L23
- `int frameHeight`  L24
- `VideoFramePtsChangedListener framePtsChangedListener`  L25
- `int frameWidth`  L26
- `int previewLaunchMode`  L27
- `StreamProvider streamProvider`  L28
- `SurfaceHolder surfaceHolder`  L29
- `ICatchVideoFormat videoFormat`  L30
- `Bitmap videoFrameBitmap`  L31
- `VideoThread videoThread`  L32
- `int viewHeight`  L33
- `int viewWidth`  L34
- `VideoThread videoThread = this.videoThread`  L169
- `AudioThread audioThread = this.audioThread`  L173
- `Canvas canvasLockCanvas`  L178
- `AudioThread audioThread = this.audioThread`  L212
- `VideoThread videoThread = this.videoThread`  L216

方法（6）：
- `public MjpgDecoderThread(StreamProvider streamProvider, SurfaceHolder surfaceHolder, int i, int i2, int i3)`  L155
    - 体内字面量："start frameHeight=" · " frameWidth="
- `boolean isAlive()`  L168
- `void redrawBitmap(SurfaceHolder surfaceHolder, int i, int i2)`  L177
- `void setframePtsChangedListener(VideoFramePtsChangedListener videoFramePtsChangedListener)`  L193
- `void start(boolean z, boolean z2)`  L197
    - 体内字面量："start"
- `void stop()`  L211
### `com.icatch.golive.Function.streaming.MjpgDecoderThread$AudioThread`
L36 · [class] private AudioThread · extends `Thread` · `com/icatch/golive/Function/streaming/MjpgDecoderThread.java`

字段/常量（2）：
- `AudioTrack audioTrack`  L37
- `boolean done`  L38

方法（3）：
- `private AudioThread()`  L40
- `void requestExitAndWait()`  L44
- `void run()`  L53 @Override
    - 体内字面量："Run AudioThread" · "Run AudioThread audioFormat is null!" · "Run AudioThread 3" · "getNextVideoFrame " · "stopMPreview audio thread"
### `com.icatch.golive.Function.streaming.MjpgDecoderThread$VideoThread`
L85 · [class] private VideoThread · extends `Thread` · `com/icatch/golive/Function/streaming/MjpgDecoderThread.java`

字段/常量（7）：
- `ByteBuffer bmpBuf`  L86
- `boolean done = false`  L87
- `byte[] pixelBuf`  L88
- `byte[] bArr = new byte[MjpgDecoderThread.this.frameWidth * MjpgDecoderThread.this.frameHeight * 4]`  L91
- `boolean z = false`  L112
- `boolean z2 = true`  L113
- `MjpgDecoderThread mjpgDecoderThread = MjpgDecoderThread.this`  L132

方法（2）：
- `void requestExitAndWait()`  L98
- `void run()`  L107 @Override
    - 体内字面量："start running video thread"
### `com.icatch.golive.Function.streaming.RenderType`
L4 · [enum] public RenderType · `com/icatch/golive/Function/streaming/RenderType.java`

枚举常量（2）：
- `NO_RENDER()`  L5
- `PANORAMA_RENDER()`  L6
### `com.icatch.golive.Function.streaming.VideoStreaming`
L18 · [class] public VideoStreaming · `com/icatch/golive/Function/streaming/VideoStreaming.java`

字段/常量（41）：
- `boolean enableRender`  L19
- `H264DecoderThread h264DecoderThread`  L20
- `SurfaceHolder holder`  L21
- `ICatchIStreamProvider iCatchIStreamProvider`  L22
- `ICatchSurfaceContext iCatchSurfaceContext`  L23
- `MjpgDecoderThread mjpgDecoderThread`  L24
- `int previewCodec`  L25
- `StreamProvider streamProvider`  L26
- `Surface surface`  L27
- `ICatchVideoFormat videoFormat`  L28
- `PanoramaVideoPlayback videoPlayback`  L29
- `String TAG = "VideoStreaming"`  L30
- `boolean isStreaming = false`  L31
- `boolean needRelease = true`  L32
- `int frmW = 0`  L33
- `int frmH = 0`  L34
- `int viewWidth = 0`  L35
- `int viewHeigth = 0`  L36
- `VideoFramePtsChangedListener framePtsChangedListener = null`  L37
- `int i2 = this.previewCodec`  L51
- `int i`  L101
- `int i2 = 0`  L124
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L163
- `ICatchSurfaceContext iCatchSurfaceContext`  L171
- `int i`  L187
- `int i2`  L188
- `SurfaceHolder surfaceHolder`  L189
- `int i3`  L190
- `int i4 = this.frmH`  L193
- `SurfaceHolder surfaceHolder2 = this.holder`  L196
- `int i5 = this.viewWidth`  L197
- `int i6 = this.previewCodec`  L201
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L203
- `SurfaceHolder surfaceHolder3 = this.holder`  L210
- `int i7 = this.viewWidth`  L211
- `SurfaceHolder surfaceHolder4 = this.holder`  L215
- `int i8 = this.viewHeigth`  L216
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L236
- `H264DecoderThread h264DecoderThread = this.h264DecoderThread`  L241
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L262
- `H264DecoderThread h264DecoderThread = this.h264DecoderThread`  L267

方法（14）：
- `public VideoStreaming(PanoramaVideoPlayback panoramaVideoPlayback)`  L39
- `void startDecoderThread(int i, ICatchVideoFormat iCatchVideoFormat)`  L43
    - 体内字面量："start startDecoderThread videoFormat=" · "start startDecoderThread previewCodec=" · " enableAudio="
- `void changePanoramaType(int i)`  L70
- `void initSurface(boolean z, SurfaceHolder surfaceHolder, long j, long j2)`  L76
- `boolean isStreaming()`  L95
    - 体内字面量："get getStream: "
- `boolean play(ICatchFile iCatchFile, boolean z, boolean z2)`  L100
- `boolean release()`  L152
    - 体内字面量："pancamGLRelease enableRender=" · " needRelease = "
- `void removeSurface(int i)`  L162
- `void setDrawingArea(int i, int i2)`  L170
- `void setFramePtsChangedListener(VideoFramePtsChangedListener videoFramePtsChangedListener)`  L182
- `void setSurfaceViewArea()`  L186
- `void setViewParam(int i, int i2)`  L224
- `boolean stop()`  L232
    - 体内字面量："stopStreaming enableRender=" · " isStreaming = " · "stopMPreview preview"
- `boolean stopForSdRemove()`  L258
    - 体内字面量："stopStreaming enableRender=" · " isStreaming = " · "stopMPreview preview"
### `com.icatch.golive.Function.ThumbnailGetting.ThumbnailOperation`
L13 · [class] public ThumbnailOperation · `com/icatch/golive/Function/ThumbnailGetting/ThumbnailOperation.java`

字段/常量（4）：
- `String TAG = "ThumbnailOperation"`  L14
- `ICatchFrameBuffer thumbnail`  L51
- `Bitmap bitmapDecodeByteArray = null`  L53
- `ICatchFrameBuffer thumbnail`  L84

方法（6）：
- `int getBatteryLevelIcon(int i)`  L16
    - 体内字面量："current setBatteryLevelIcon= "
- `int getBatteryLevelIcon02(int i)`  L30
    - 体内字面量："current setBatteryLevelIcon= "
- `Bitmap getLocalVideoThumbnail(ICatchCameraPlayback iCatchCameraPlayback, String str)`  L50
- `Bitmap getVideoThumbnail(String str)`  L76
    - 体内字面量："start getVideoThumbnail" · "end getVideoThumbnail bitmap="
- `Bitmap getVideoThumbnailFromSdk(String str)`  L83
- `Bitmap getlocalVideoWallThumbnail(ICatchCameraPlayback iCatchCameraPlayback, String str)`  L116
    - 体内字面量："start getVideoThumbnail" · "end getVideoThumbnail bitmap="
### `com.icatch.golive.Function.USB.DeviceFilter`
L18 · [class] public final DeviceFilter · `com/icatch/golive/Function/USB/DeviceFilter.java`

字段/常量（33）：
- `String TAG = "DeviceFilter"`  L19
- `int mClass`  L20
- `String mManufacturerName`  L21
- `int mProductId`  L22
- `String mProductName`  L23
- `int mProtocol`  L24
- `String mSerialNumber`  L25
- `int mSubclass`  L26
- `int mVendorId`  L27
- `int i2`  L52
- `DeviceFilter deviceFilter`  L90
- `boolean z = false`  L109
- `int i = -1`  L110
- `int i2 = -1`  L111
- `int attributeInteger = -1`  L112
- `int attributeInteger2 = -1`  L113
- `int attributeInteger3 = -1`  L114
- `String str = null`  L115
- `String str2 = null`  L116
- `String attributeString = null`  L117
- `int i`  L160
- `int i2`  L161
- `int i3`  L162
- `int i4`  L163
- `String str`  L164
- `String str2`  L165
- `String str3`  L166
- `String str4`  L167
- `String str5`  L168
- `String str6`  L169
- `String str7`  L170
- `int i5 = this.mVendorId`  L171
- `String str8 = deviceFilter.mManufacturerName`  L178

方法（10）：
- `public DeviceFilter(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3)`  L29
- `public DeviceFilter(UsbDevice usbDevice)`  L40
- `int getAttributeInteger(Context context, XmlPullParser xmlPullParser, String str, String str2, int i)`  L51
- `String getAttributeString(Context context, XmlPullParser xmlPullParser, String str, String str2, String str3)`  L71
    - 体内字面量："@"
- `List<DeviceFilter> getDeviceFilters(Context context, int i)`  L89
- `DeviceFilter read(Context context, XmlPullParser xmlPullParser)`  L107
- `boolean equals(Object obj)`  L159
- `int hashCode()`  L194
- `boolean matches(UsbDevice usbDevice)`  L198
    - 体内字面量："mVendorId ="
- `String toString()`  L203
    - 体内字面量："DeviceFilter[mVendorId=" · ",mProductId=" · ",mClass=" · ",mSubclass=" · ",mProtocol=" · ",mManufacturerName=" · ",mProductName=" · ",mSerialNumber=" · "]"
### `com.icatch.golive.Function.USB.NotificationHandler`
L9 · [class] public NotificationHandler · extends `Handler` · `com/icatch/golive/Function/USB/NotificationHandler.java`

字段/常量（2）：
- `Context context`  L10
- `int i = message.what`  L18

方法（2）：
- `public NotificationHandler(Context context)`  L12
- `void handleMessage(Message message)`  L17 @Override
### `com.icatch.golive.Function.USB.USBHost_Feature`
L22 · [class] public USBHost_Feature · `com/icatch/golive/Function/USB/USBHost_Feature.java`

字段/常量（18）：
- `String ACTION_USB_PERMISSION_BASE = "com.example.USB_PERMISSION."`  L23
- `int HANDLER_USB_DEVICE_ATTACHED_ID = 1`  L24
- `String HANDLER_USB_DEVICE_ATTACHED_KEY = "HANDLER_USB_DEVICE_ATTACHED"`  L25
- `int HANDLER_USB_DEVICE_DETACHED_ID = 2`  L26
- `String HANDLER_USB_DEVICE_DETACHED_KEY = "HANDLER_USB_DEVICE_DETACHED"`  L27
- `int USB_PRODUCT_ID = 25427`  L28
- `int USB_UAC_FREQUENCY = 48000`  L29
- `int USB_UAC_NCHANNELS = 2`  L30
- `int USB_UAC_SAMPLEBIT = 16`  L31
- `int USB_VENDOR_ID = 10925`  L32
- `Context context`  L33
- `PendingIntent mPermissionIntent`  L34
- `UsbDevice usbDevice`  L35
- `UsbDeviceConnection usbDeviceConnection`  L36
- `UsbManager usbManager`  L37
- `UsbDevice usbDevice`  L42
- `int mVendorID = USB_VENDOR_ID`  L76
- `int mProductID = USB_PRODUCT_ID`  L77

方法（16）：
- `void onReceive(Context context, Intent intent)`  L41 @Override
- `public USBHost_Feature(Context context)`  L79
    - 体内字面量："usb"
- `String generateNameForUsbDevice(int i, int i2)`  L84
    - 体内字面量："USB[VID:0x%04x PID:0x%04x]"
- `String generateNameForUsbDevice(UsbDevice usbDevice)`  L88
- `UsbDevice getSpecifiedDevice(int i, int i2)`  L92
    - 体内字面量："__lib_uvc__" · "getDeviceList, USBDevice: " · "__lib_uvc__" · "getDeviceList, USBDevice: " · "__lib_uvc__" · "getDeviceList, USBDevice: "
- `List<UsbDevice> getExistsUsbDevices()`  L108
    - 体内字面量："__lib_uvc__" · "getDeviceList, USBDevice: " · "__lib_uvc__" · "getDeviceList, USBDevice: " · "__lib_uvc__" · "getDeviceList, USBDevice: "
- `int getFileDescriptor()`  L123
- `int getProductID()`  L132
- `UsbDevice getUsbDevice()`  L136
- `UsbDeviceConnection getUsbDeviceConnection()`  L145
- `int getVendorID()`  L157
- `boolean hasPermission()`  L161
- `void register()`  L167
    - 体内字面量："android.hardware.usb.action.USB_DEVICE_ATTACHED" · "android.hardware.usb.action.USB_DEVICE_DETACHED"
- `void requestPermission()`  L177
    - 体内字面量："__lib_uvc__" · "has permission" · "__lib_uvc__" · "request permission"
- `void setUsbDevice(int i, int i2)`  L191
- `void unregister()`  L196
### `com.icatch.golive.Function.USB.USBMonitor`
L27 · [class] public final USBMonitor · `com/icatch/golive/Function/USB/USBMonitor.java`

字段/常量（11）：
- `String ACTION_USB_PERMISSION_BASE = "com.serenegiant.USB_PERMISSION."`  L28
- `boolean DEBUG = true`  L29
- `String TAG = "USBMonitor"`  L30
- `IntentFilter filter`  L31
- `OnDeviceConnectListener mOnDeviceConnectListener`  L32
- `UsbManager mUsbManager`  L33
- `WeakReference<Context> mWeakContext`  L34
- `String ACTION_USB_PERMISSION = "com.android.usb.USB_PERMISSION"`  L35
- `UsbDevice usbDevice`  L42
- `int mDeviceCounts = 0`  L75
- `boolean z`  L255

方法（24）：
- `void onReceive(Context context, Intent intent)`  L41 @Override
- `void run()`  L78 @Override
- `public USBMonitor(Context context, OnDeviceConnectListener onDeviceConnectListener)`  L214
    - 体内字面量："USBMonitor:Constructor" · "usb" · "USBMonitor:mUsbManager="
- `void processAttach(final UsbDevice usbDevice)`  L224
    - 体内字面量："processAttach:"
- `void run()`  L229 @Override
- `void processCancel(UsbDevice usbDevice)`  L237
    - 体内字面量："processCancel:"
- `void run()`  L242 @Override
- `void processConnect(final UsbDevice usbDevice)`  L250
    - 体内字面量："processConnect:"
- `void run()`  L254 @Override
- `void processDettach(final UsbDevice usbDevice)`  L272
    - 体内字面量："processDettach:"
- `void run()`  L277 @Override
- `void destroy()`  L284
    - 体内字面量："destroy:" · "destroy:"
- `void dumpDevices()`  L301
    - 体内字面量："no device" · "no device" · "interface%d:%s" · "key=" · ":" · ":"
- `int getDeviceCount()`  L324
- `List<UsbDevice> getDeviceList()`  L328
- `List<UsbDevice> getDeviceList(DeviceFilter deviceFilter)`  L332
    - 体内字面量："getDeviceList size is: " · "the device is: " · "getDeviceList result size is: "
- `List<UsbDevice> getDeviceList(List<DeviceFilter> list)`  L348
- `boolean hasPermission(UsbDevice usbDevice)`  L363
- `boolean isRegistered()`  L367
- `void register()`  L371
    - 体内字面量："com.android.usb.USB_PERMISSION" · "android.hardware.usb.action.USB_DEVICE_ATTACHED" · "android.hardware.usb.action.USB_DEVICE_DETACHED"
- `void requestPermission(UsbDevice usbDevice)`  L386
    - 体内字面量："requestPermission:device=" · "mUsbManager.hasPermission( device )=" · "processConnect not from broadcaster" · "do not has permission,so  requestPermission" · "com.android.usb.USB_PERMISSION"
- `void setDeviceFilter(DeviceFilter deviceFilter)`  L402
- `void setDeviceFilter(List<DeviceFilter> list)`  L407
- `void unregister()`  L412
    - 体内字面量："unregisterUSB:"
### `com.icatch.golive.Function.USB.USBMonitor$OnDeviceConnectListener`
L90 · [interface] public OnDeviceConnectListener · `com/icatch/golive/Function/USB/USBMonitor.java`

方法（5）：
- `void onAttach(UsbDevice usbDevice)`  L91
- `void onCancel()`  L93
- `void onConnect(UsbDevice usbDevice, UsbControlBlock usbControlBlock, boolean z)`  L95
- `void onDettach(UsbDevice usbDevice)`  L97
- `void onDisconnect(UsbDevice usbDevice, UsbControlBlock usbControlBlock)`  L99
### `com.icatch.golive.Function.USB.USBMonitor$UsbControlBlock`
L102 · [class] public static final UsbControlBlock · `com/icatch/golive/Function/USB/USBMonitor.java`

字段/常量（8）：
- `UsbDeviceConnection mConnection`  L103
- `WeakReference<UsbDevice> mWeakDevice`  L105
- `WeakReference<USBMonitor> mWeakMonitor`  L106
- `UsbDeviceConnection usbDeviceConnection = this.mConnection`  L114
- `UsbDeviceConnection usbDeviceConnection`  L161
- `UsbDeviceConnection usbDeviceConnection = this.mConnection`  L175
- `UsbDeviceConnection usbDeviceConnection`  L183
- `UsbInterface usbInterface`  L201

方法（12）：
- `public UsbControlBlock(USBMonitor uSBMonitor, UsbDevice usbDevice)`  L108
    - 体内字面量："UsbControlBlock:constructor"
- `void close()`  L122
    - 体内字面量："UsbControlBlock#close:"
- `void close(int i)`  L141
- `UsbDevice getDevice()`  L151
- `String getDeviceName()`  L155
- `int getFileDescriptor()`  L160
- `int getProductId()`  L166
- `byte[] getRawDescriptors()`  L174
- `String getSerial()`  L182
- `UsbDeviceConnection getUsbDeviceConnection()`  L188
- `int getVenderId()`  L192
- `UsbInterface open(int i)`  L200