# XTU GO — 类与成员明细：icatch

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 13 个文件 / 40 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `icatch.AppLog`
L6 · [class] public AppLog · `icatch/AppLog.java`

方法（3）：
- `void i(String str, Object obj)`  L7
- `void e(String str, Object obj)`  L10
    - 体内字面量："  "
- `void d(String str, Object obj)`  L14
    - 体内字面量："  "
### `icatch.AppMessage`
L4 · [class] public AppMessage · `icatch/AppMessage.java`

字段/常量（39）：
- `int ACTIVITY_MESSAGE = 0`  L5
- `int AP_MODE_TO_STA_MODE_FAILURE = 4098`  L6
- `int AP_MODE_TO_STA_MODE_SUSSED = 4097`  L7
- `int CANCEL_DOWNLOAD_ALL = 772`  L8
- `int CANCEL_DOWNLOAD_SINGLE = 771`  L9
- `int DOWNLOAD_BEGIN = 775`  L10
- `int DOWNLOAD_FAILURE = 778`  L11
- `int DOWNLOAD_FINISHED = 776`  L12
- `int DOWNLOAD_SUCCEED = 777`  L13
- `int EVENT_CACHE_PROGRESS_NOTIFY = 1538`  L14
- `int EVENT_CACHE_STATE_CHANGED = 1537`  L15
- `int EVENT_VIDEO_PLAY_COMPLETED = 1539`  L16
- `int FACEBOOK_LOGIN_SUCCEED = 4101`  L17
- `int FUNCTION_MESSAGE = 4096`  L18
- `int GOOGLE_LOGIN_SUCCEED = 6`  L19
- `int LAUNCH_ACTIVITY = 0`  L20
- `int LOCAL_ACTIVITY = 256`  L21
- `int LOCAL_VIDEO_PBACTIVITY = 1536`  L22
- `int MESSAGE_CAMERA_CONNECTING_START = 5`  L23
- `int MESSAGE_CAMERA_CONNECT_FAIL = 3`  L24
- `int MESSAGE_CAMERA_CONNECT_SUCCESS = 4`  L25
- `int MESSAGE_CAMERA_SCAN_TIME_OUT = 2`  L26
- `int MESSAGE_CANCEL_DOWNLOAD_SINGLE = 769`  L27
- `int MESSAGE_CANCEL_VIDEO_DOWNLOAD = 1541`  L28
- `int MESSAGE_CONNECTED = 4100`  L29
- `int MESSAGE_DELETE_CAMERA = 1`  L30
- `int MESSAGE_DISCONNECTED = 4099`  L31
- `int MESSAGE_LIVE_NETWORK_DISCONNECT = 514`  L32
- `int MESSAGE_STREAM_CLOSED = 1543`  L33
- `int MESSAGE_UPDATE_VIDEOPB_BAR = 1540`  L34
- `int MESSAGE_VIDEO_STREAM_NO_EIS_INFORMATION = 1542`  L35
- `int MESSAGE_VIDEO_STREAM_STOP = 1544`  L36
- `int MPB_ACTIVITY = 768`  L37
- `int PHOTO_PBACTIVITY = 1024`  L38
- `int PREVIEW_ACTIVITY = 512`  L39
- `int SETTING_OPTION_AUTO_DOWNLOAD = 513`  L40
- `int UPDATE_LOADING_PROGRESS = 770`  L41
- `int UPDATE_TOTAL_PROGRESS = 773`  L42
- `int VIDEO_PBACTIVITY = 1280`  L43
### `icatch.ConvertTools`
L7 · [class] public ConvertTools · `icatch/ConvertTools.java`

字段/常量（17）：
- `int GB = 1073741824`  L8
- `int KB = 1024`  L9
- `int MB = 1048576`  L10
- `String TAG = "ConvertTools"`  L11
- `String str`  L14
- `String str2`  L15
- `String string`  L16
- `int i2 = i / 3600`  L17
- `int i4 = i % 60`  L21
- `String str3 = str2 + ":"`  L41
- `String string`  L50
- `String str`  L51
- `int i2 = i / 3600`  L52
- `int i4 = i % 60`  L56
- `String str2 = string + ":"`  L64
- `String str3 = str + ":"`  L71
- `String str2 = strArrSplit[0] + "?W=" + strArrSplit[1] + "&H=" + strArrSplit[2] + "&BR=" + strArrSplit[3]`  L99

方法（4）：
- `String secondsToMinuteOrHours(int i)`  L13
- `String secondsToHours(int i)`  L49
- `String ByteConversionGBMBKB(Integer num)`  L79
    - 体内字面量："######0.0" · "G" · "M" · "K" · "B"
- `String resolutionConvert(String str)`  L93
    - 体内字面量："start resolution = " · "\\?|&" · "W=" · "H=" · "BR="
### `icatch.PanoramaPreviewPlayback`
L36 · [class] public PanoramaPreviewPlayback · `icatch/PanoramaPreviewPlayback.java`

字段/常量（44）：
- `String TAG = "PanoramaPreviewPlayback"`  L37
- `ICatchIPancamPreview previewPlayback`  L38
- `ICatchIPancamGL pancamGL = null`  L39
- `List<ICatchImageSize> imageSizelist = null`  L40
- `ICatchImageSize curImageSize = null`  L41
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L73
- `boolean zChangePanoramaType = false`  L74
- `ICatchIStreamProvider iCatchIStreamProviderDisableRender`  L92
- `ICatchIPancamPreview iCatchIPancamPreview = this.previewPlayback`  L105
- `ICatchIPancamPreview iCatchIPancamPreview = this.previewPlayback`  L124
- `int i`  L142
- `String str = TAG`  L143
- `boolean zStart = false`  L145
- `String str2 = TAG`  L164
- `boolean zStop`  L171
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L191
- `boolean zInit = false`  L192
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L213
- `boolean zRelease = false`  L214
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L231
- `boolean surface = false`  L232
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L253
- `boolean zRemoveSurface = false`  L254
- `String str = TAG`  L272
- `boolean zIsStreamSupportPublish = false`  L275
- `String str2 = TAG`  L294
- `boolean zStartPublishStreaming = false`  L297
- `String str = TAG`  L313
- `boolean zStopPublishStreaming = false`  L316
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L332
- `String str2 = TAG`  L393
- `boolean zStartMovieRecord = false`  L396
- `String str = TAG`  L424
- `boolean zStopMovieRecord = false`  L427
- `String str = TAG`  L452
- `List<ICatchImageSize> list = this.imageSizelist`  L454
- `String str = TAG`  L480
- `boolean imageSize = false`  L483
- `String str = TAG`  L515
- `boolean zSnapImage = false`  L518
- `String str3 = TAG`  L546
- `String str = TAG`  L559
- `String str = TAG`  L571
- `String str = TAG`  L584

方法（30）：
- `public PanoramaPreviewPlayback(ICatchIPancamPreview iCatchIPancamPreview)`  L43
- `boolean enableCommonRender(ICatchSurfaceContext iCatchSurfaceContext)`  L47
    - 体内字面量："Exception : "
- `boolean enableGLRender()`  L58
    - 体内字面量："enableGLRender" · "Exception : " · "end enableGLRender"
- `boolean changePanoramaType(int i)`  L71
    - 体内字面量："start changePanoramaType panoramaType="
- `ICatchIStreamProvider disableRender()`  L91
- `ICatchIStreamControl getStreamControl()`  L104
- `ICatchIStreamPublish getStreamPublish()`  L122
    - 体内字面量："getStreamPublish"
- `int start(ICatchStreamParam iCatchStreamParam, boolean z)`  L141
- `boolean stop()`  L170
- `boolean init(int i)`  L189
    - 体内字面量："start init "
- `boolean release()`  L211
    - 体内字面量："start pancamGLRelease "
- `boolean setSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L229
    - 体内字面量："start initSurface "
- `boolean removeSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L251
    - 体内字面量："start removeSurface "
- `boolean isStreamSupportPublish()`  L271
- `boolean startPublishStreaming(String str)`  L293
- `boolean stopPublishStreaming()`  L312
- `ICatchIPancamGLTransform getPancamGLTransform()`  L331
- `boolean locate(float f)`  L344
- `boolean rotate(int i, float f, float f2, float f3, long j)`  L360
- `boolean rotate(ICatchGLPoint iCatchGLPoint, ICatchGLPoint iCatchGLPoint2)`  L376
- `boolean startMovieRecord(String str, boolean z)`  L392
- `boolean stopMovieRecord()`  L423
- `List<ICatchImageSize> getSupportedImageSize()`  L451
- `boolean setImageSize(ICatchImageSize iCatchImageSize)`  L479
- `ICatchImageSize getCurImageSize()`  L509
    - 体内字面量："start getCurImageSize curImageSize="
- `boolean snapImage(ICatchFrameBuffer iCatchFrameBuffer, int i)`  L514
- `String createChannel(ICatchGLCredential iCatchGLCredential, String str, String str2, boolean z)`  L545
- `void deleteChannel()`  L558
- `String startLive()`  L570
- `void stopLive()`  L583
### `icatch.PanoramaVideoPlayback`
L26 · [class] public PanoramaVideoPlayback · `icatch/PanoramaVideoPlayback.java`

字段/常量（24）：
- `String TAG = "PanoramaVideoPlayback"`  L27
- `ICatchIPancamGL pancamGL`  L28
- `ICatchIPancamVideoPlayback videoPlayback`  L29
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L80
- `boolean zChangePanoramaType = false`  L81
- `boolean zPlay`  L109
- `double length`  L123
- `boolean zStop`  L137
- `boolean zResume`  L151
- `boolean zPause`  L173
- `boolean zSeek`  L195
- `String str = TAG`  L217
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L219
- `boolean zInit = false`  L220
- `String str = TAG`  L236
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L238
- `boolean zRelease = false`  L239
- `String str = TAG`  L255
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L257
- `boolean surface = false`  L258
- `String str = TAG`  L274
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L276
- `boolean zRemoveSurface = false`  L277
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L293

方法（21）：
- `boolean setFormat(int i)`  L31
- `public PanoramaVideoPlayback(ICatchIPancamVideoPlayback iCatchIPancamVideoPlayback)`  L35
- `void enableGLRender()`  L46
    - 体内字面量："Exception : " · "enableGLRender pancamGL="
- `boolean enableCommonRender(ICatchSurfaceContext iCatchSurfaceContext)`  L56
    - 体内字面量："Exception : "
- `void enableGLRender(int i)`  L67
    - 体内字面量："begin enableGLRender var1=" · "Exception : " · "enableGLRender pancamGL="
- `boolean changePanoramaType(int i)`  L78
    - 体内字面量："start changePanoramaType panoramaType="
- `ICatchIStreamProvider disableRender()`  L98
    - 体内字面量："Exception : "
- `boolean openVideoStream(ICatchFile iCatchFile, boolean z, boolean z2)`  L108
- `int getLength()`  L122
- `boolean stop()`  L136
- `boolean resumePlayback()`  L150
- `boolean pausePlayback()`  L172
- `boolean videoSeek(double d)`  L194
- `boolean initPancamGL(int i)`  L216
- `boolean pancamGLRelease()`  L235
- `boolean setSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L254
- `boolean removeSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L273
- `ICatchIPancamGLTransform getPancamGLTransform()`  L292
- `boolean locate(float f)`  L305
- `boolean rotate(int i, float f, float f2, float f3, long j)`  L321
- `boolean rotate(ICatchGLPoint iCatchGLPoint, ICatchGLPoint iCatchGLPoint2)`  L337
### `icatch.PreviewLaunchMode`
L4 · [class] public PreviewLaunchMode · `icatch/PreviewLaunchMode.java`

字段/常量（2）：
- `int RT_PREVIEW_MODE = 2`  L5
- `int VIDEO_PB_MODE = 1`  L6
### `icatch.ScaleTool`
L6 · [class] public ScaleTool · `icatch/ScaleTool.java`

字段/常量（4）：
- `int i5`  L8
- `int i6 = i3 * i2`  L10
- `int i7 = i4 * i`  L11
- `int i8 = 0`  L12

方法（1）：
- `Rect getScaledPosition(int i, int i2, int i3, int i4)`  L7
### `icatch.SDKEvent`
L13 · [class] public SDKEvent · `icatch/SDKEvent.java`

字段/常量（74）：
- `int EVENT_BATTERY_ELETRIC_CHANGED = 0`  L14
- `int EVENT_BURST_NUM_CHANGE = 110`  L15
- `int EVENT_CAPTURE_COMPLETED = 1`  L16
- `int EVENT_CAPTURE_START = 3`  L17
- `int EVENT_CONNECTION_FAILURE = 8`  L18
- `int EVENT_FILE_ADDED = 7`  L19
- `int EVENT_FILE_DOWNLOAD = 11`  L20
- `int EVENT_FW_UPDATE_CHECK = 18`  L21
- `int EVENT_FW_UPDATE_CHKSUMERR = 19`  L22
- `int EVENT_FW_UPDATE_COMPLETED = 13`  L23
- `int EVENT_FW_UPDATE_NG = 20`  L24
- `int EVENT_FW_UPDATE_POWEROFF = 14`  L25
- `int EVENT_SDCARD_INSERT = 17`  L26
- `int EVENT_SDCARD_REMOVED = 16`  L27
- `int EVENT_SD_CARD_FULL = 4`  L28
- `int EVENT_SEARCHED_NEW_CAMERA = 15`  L29
- `int EVENT_SERVER_STREAM_ERROR = 10`  L30
- `int EVENT_TIME_LAPSE_STOP = 9`  L31
- `int EVENT_VIDEO_OFF = 5`  L32
- `int EVENT_VIDEO_ON = 6`  L33
- `int EVENT_VIDEO_PLAY_CLOSED = 24`  L34
- `int EVENT_VIDEO_PLAY_PTS = 23`  L35
- `int EVENT_VIDEO_RECORDING_TIME = 12`  L36
- `String TAG = "SDKEvent"`  L37
- `BatteryStateListener batteryStateListener`  L38
- `BurstNumChangeListener burstNumChangeListener`  L39
- `CacheProgressListener cacheProgressListener`  L40
- `CacheStateChangedListener cacheStateChangedListener`  L41
- `ICatchCameraControl cameraAction`  L42
- `CaptureDoneListener captureDoneListener`  L43
- `CaptureStartListener captureStartListener`  L44
- `ConnectionFailureListener connectionFailureListener`  L45
- `FileAddedListener fileAddedListener`  L46
- `FileDownloadListener fileDownloadListener`  L47
- `Handler handler`  L48
- `InsertSdcardListener insertSdcardListener`  L49
- `NetworkDisconnectListener networkDisconnectListener`  L50
- `NoEISInformationListener noEISInformationListener`  L51
- `NoSdcardListener noSdcardListener`  L52
- `ICatchIPancamControl panoramaControl`  L53
- `SdcardStateListener sdcardStateListener`  L54
- `ServerStreamErrorListener serverStreamErrorListener`  L55
- `TimeLapseStopListener timeLapseStopListener`  L56
- `UpdateFWCHKSumErrListener updateFWCHKSumErrListener`  L57
- `UpdateFWCheckListener updateFWCheckListener`  L58
- `UpdateFWCompletedListener updateFWCompletedListener`  L59
- `UpdateFWNGListener updateFWNGListener`  L60
- `UpdateFWPoweroffListener updateFWPoweroffListener`  L61
- `VideoOffListener videoOffListener`  L62
- `VideoOnListener videoOnListener`  L63
- `VideoRecordingTimeStartListener videoRecordingTimeStartListener`  L64
- `VideoStreamCloseListener videoStreamCloseListener`  L65
- `VideoStreamStatusListener videoStreamStatusListener`  L66
- `NoSdcardListener noSdcardListener`  L183
- `UpdateFWPoweroffListener updateFWPoweroffListener`  L184
- `UpdateFWCompletedListener updateFWCompletedListener`  L185
- `FileDownloadListener fileDownloadListener`  L186
- `TimeLapseStopListener timeLapseStopListener`  L187
- `VideoOnListener videoOnListener`  L188
- `FileAddedListener fileAddedListener`  L189
- `VideoOffListener videoOffListener`  L190
- `CaptureStartListener captureStartListener`  L191
- `CaptureDoneListener captureDoneListener`  L192
- `BatteryStateListener batteryStateListener`  L193
- `UpdateFWNGListener updateFWNGListener`  L194
- `UpdateFWCHKSumErrListener updateFWCHKSumErrListener`  L195
- `UpdateFWCheckListener updateFWCheckListener`  L196
- `SdcardStateListener sdcardStateListener`  L197
- `CacheStateChangedListener cacheStateChangedListener`  L298
- `VideoStreamStatusListener videoStreamStatusListener = this.videoStreamStatusListener`  L300
- `VideoStreamCloseListener videoStreamCloseListener = this.videoStreamCloseListener`  L309
- `NoEISInformationListener noEISInformationListener = this.noEISInformationListener`  L318
- `NetworkDisconnectListener networkDisconnectListener = this.networkDisconnectListener`  L327
- `CacheProgressListener cacheProgressListener = this.cacheProgressListener`  L343

方法（9）：
- `public SDKEvent(Handler handler, ICatchCameraControl iCatchCameraControl, ICatchIPancamControl iCatchIPancamControl)`  L68
- `public SDKEvent(Handler handler, ICatchCameraControl iCatchCameraControl)`  L74
- `void acAddEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L79
- `void pcAddEventListener(int i, ICatchIPancamListener iCatchIPancamListener)`  L87
- `void pcRemoveEventListener(int i, ICatchIPancamListener iCatchIPancamListener)`  L95
- `void addEventListener(int i)`  L103
- `void delEventListener(int i)`  L182
- `void addPanoramaEventListener(int i)`  L260
    - 体内字面量："addPanoramaEventListener videoStreamStatusListener"
- `void removePanoramaEventListener(int i)`  L297
### `icatch.SDKEvent$BatteryStateListener`
L361 · [class] public BatteryStateListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public BatteryStateListener()`  L362
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L366 @Override
    - 体内字面量："123->" · "  BatteryStateListener  arg0="
### `icatch.SDKEvent$BurstNumChangeListener`
L560 · [class] public BurstNumChangeListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public BurstNumChangeListener()`  L561
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L565 @Override
    - 体内字面量："--------------receive InsertSdcardListener"
### `icatch.SDKEvent$CacheProgressListener`
L537 · [class] public CacheProgressListener · implements `ICatchIPancamListener` · `icatch/SDKEvent.java`

方法（2）：
- `public CacheProgressListener()`  L538
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L542 @Override
    - 体内字面量："receive CacheProgressListener.......temp="
### `icatch.SDKEvent$CacheStateChangedListener`
L526 · [class] public CacheStateChangedListener · implements `ICatchIPancamListener` · `icatch/SDKEvent.java`

方法（2）：
- `public CacheStateChangedListener()`  L527
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L531 @Override
    - 体内字面量："receive CacheStateChangedListener........iCatchGLEvent.getLongValue1()="
### `icatch.SDKEvent$CaptureDoneListener`
L372 · [class] public CaptureDoneListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public CaptureDoneListener()`  L373
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L377 @Override
    - 体内字面量："--------------receive event:capture done"
### `icatch.SDKEvent$CaptureStartListener`
L383 · [class] public CaptureStartListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public CaptureStartListener()`  L384
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L388 @Override
    - 体内字面量："--------------receive event:capture start"
### `icatch.SDKEvent$ConnectionFailureListener`
L427 · [class] public ConnectionFailureListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public ConnectionFailureListener()`  L428
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L432 @Override
    - 体内字面量："--------------receive event:ConnectionFailureListener"
### `icatch.SDKEvent$CustomEventListener`
L637 · [class] public CustomEventListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public CustomEventListener()`  L638
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L642 @Override
    - 体内字面量："eventNotify iCatchCamEvent EventID:" · "eventNotify iCatchCamEvent StringValue1:" · "eventNotify iCatchCamEvent IntValue1:" · "eventNotify iCatchCamEvent DoubleValue1:"
### `icatch.SDKEvent$FileAddedListener`
L416 · [class] public FileAddedListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public FileAddedListener()`  L417
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L421 @Override
    - 体内字面量："--------------receive event:FileAddedListener"
### `icatch.SDKEvent$FileDownloadListener`
L460 · [class] public FileDownloadListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public FileDownloadListener()`  L461
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L465 @Override
    - 体内字面量："--------------receive event:FileDownloadListener" · "1111" · "receive event:FileDownloadListener"
### `icatch.SDKEvent$InsertSdcardListener`
L549 · [class] public InsertSdcardListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public InsertSdcardListener()`  L550
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L554 @Override
    - 体内字面量："--------------receive InsertSdcardListener"
### `icatch.SDKEvent$NetworkDisconnectListener`
L615 · [class] private NetworkDisconnectListener · implements `ICatchIPancamListener` · `icatch/SDKEvent.java`

方法（2）：
- `private NetworkDisconnectListener()`  L616
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L620 @Override
    - 体内字面量："--------------receive VideoStreamCloseListener"
### `icatch.SDKEvent$NoEISInformationListener`
L626 · [class] private NoEISInformationListener · implements `ICatchIPancamListener` · `icatch/SDKEvent.java`

方法（2）：
- `private NoEISInformationListener()`  L627
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L631 @Override
    - 体内字面量："--------------receive NoEISInformationListener"
### `icatch.SDKEvent$NoSdcardListener`
L571 · [class] public NoSdcardListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public NoSdcardListener()`  L572
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L576 @Override
    - 体内字面量："--------------receive NoSdcardListener"
### `icatch.SDKEvent$SdcardStateListener`
L350 · [class] public SdcardStateListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public SdcardStateListener()`  L351
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L355 @Override
    - 体内字面量："event: EVENT_SD_CARD_FULL"
### `icatch.SDKEvent$ServerStreamErrorListener`
L449 · [class] public ServerStreamErrorListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public ServerStreamErrorListener()`  L450
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L454 @Override
    - 体内字面量："--------------receive event:ServerStreamErrorListener"
### `icatch.SDKEvent$TimeLapseStopListener`
L438 · [class] public TimeLapseStopListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public TimeLapseStopListener()`  L439
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L443 @Override
    - 体内字面量："--------------receive event:TimeLapseStopListener"
### `icatch.SDKEvent$UpdateFWCheckListener`
L582 · [class] public UpdateFWCheckListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public UpdateFWCheckListener()`  L583
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L587 @Override
    - 体内字面量："835432541010120" · "--------------receive UpdateFWCheckListener"
### `icatch.SDKEvent$UpdateFWCHKSumErrListener`
L593 · [class] public UpdateFWCHKSumErrListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public UpdateFWCHKSumErrListener()`  L594
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L598 @Override
    - 体内字面量："835432541010120" · "--------------receive UpdateFWCHKSumErrListener"
### `icatch.SDKEvent$UpdateFWCompletedListener`
L483 · [class] public UpdateFWCompletedListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public UpdateFWCompletedListener()`  L484
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L488 @Override
    - 体内字面量："--------------receive UpdateFWCompletedListener"
### `icatch.SDKEvent$UpdateFWNGListener`
L604 · [class] public UpdateFWNGListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public UpdateFWNGListener()`  L605
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L609 @Override
    - 体内字面量："835432541010120" · "--------------receive UpdateFWNGListener"
### `icatch.SDKEvent$UpdateFWPoweroffListener`
L494 · [class] public UpdateFWPoweroffListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public UpdateFWPoweroffListener()`  L495
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L499 @Override
    - 体内字面量："--------------receive UpdateFWPoweroffListener"
### `icatch.SDKEvent$VideoOffListener`
L394 · [class] public VideoOffListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public VideoOffListener()`  L395
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L399 @Override
    - 体内字面量："--------------receive event:videooff"
### `icatch.SDKEvent$VideoOnListener`
L405 · [class] public VideoOnListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public VideoOnListener()`  L406
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L410 @Override
    - 体内字面量："--------------receive event:videoON"
### `icatch.SDKEvent$VideoRecordingTimeStartListener`
L472 · [class] public VideoRecordingTimeStartListener · implements `ICatchCameraListener` · `icatch/SDKEvent.java`

方法（2）：
- `public VideoRecordingTimeStartListener()`  L473
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L477 @Override
    - 体内字面量："--------------receive VideoRecordingTimeStartListener"
### `icatch.SDKEvent$VideoStreamCloseListener`
L515 · [class] public VideoStreamCloseListener · implements `ICatchIPancamListener` · `icatch/SDKEvent.java`

方法（2）：
- `public VideoStreamCloseListener()`  L516
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L520 @Override
    - 体内字面量："--------------receive VideoStreamCloseListener"
### `icatch.SDKEvent$VideoStreamStatusListener`
L505 · [class] public VideoStreamStatusListener · implements `ICatchIPancamListener` · `icatch/SDKEvent.java`

方法（2）：
- `public VideoStreamStatusListener()`  L506
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L510 @Override
### `icatch.StreamInfo`
L4 · [class] public StreamInfo · `icatch/StreamInfo.java`

字段/常量（5）：
- `int bitrate`  L5
- `int fps`  L6
- `int height`  L7
- `String mediaCodecType`  L8
- `int width`  L9

方法（2）：
- `public StreamInfo(String str, int i, int i2, int i3, int i4)`  L11
- `public StreamInfo()`  L19
### `icatch.StreamInfoConvert`
L4 · [class] public StreamInfoConvert · `icatch/StreamInfoConvert.java`

方法（1）：
- `StreamInfo convertToStreamInfoBean(String str)`  L5
    - 体内字面量："FPS" · "\\?|&" · "W=" · "H=" · "BR=" · "FPS=" · "\\?|&" · "W=" · "H=" · "BR=" · "1111" · "streamInfo.width =" · "1111" · "streamInfo.heigh =" · "1111" · "streamInfo.mediaCodecType =" · "1111" · "streamInfo.bitrate =" · "1111" · "streamInfo.fps ="
### `icatch.StreamProvider`
L12 · [class] public StreamProvider · `icatch/StreamProvider.java`

字段/常量（9）：
- `String TAG = "StreamProvider"`  L13
- `ICatchIStreamProvider iCatchIStreamProvider`  L14
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L21
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L36
- `boolean zContainsAudioStream = false`  L37
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L51
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L65
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L80
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L94

方法（7）：
- `public StreamProvider(ICatchIStreamProvider iCatchIStreamProvider)`  L16
- `boolean containsVideoStream()`  L20
- `boolean containsAudioStream()`  L34
    - 体内字面量："start containsAudioStream"
- `ICatchVideoFormat getVideoFormat()`  L50
- `ICatchAudioFormat getAudioFormat()`  L64
- `boolean getNextVideoFrame(ICatchFrameBuffer iCatchFrameBuffer)`  L79
- `boolean getNextAudioFrame(ICatchFrameBuffer iCatchFrameBuffer)`  L93
### `icatch.Tristate`
L4 · [interface] public Tristate · `icatch/Tristate.java`

字段/常量（4）：
- `int ABNORMAL = 4`  L5
- `int FALSE = 1`  L6
- `int NORMAL = 2`  L7
- `int SIZE_NOT_SUPPORT = 3`  L8
### `icatch.VideoPbMode`
L4 · [enum] public VideoPbMode · `icatch/VideoPbMode.java`

枚举常量（2）：
- `MODE_VIDEO_PLAY()`  L5
- `MODE_VIDEO_IDLE()`  L6