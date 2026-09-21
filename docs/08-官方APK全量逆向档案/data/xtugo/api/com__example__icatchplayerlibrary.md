# XTU GO — 类与成员明细：com.example.icatchplayerlibrary

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 24 个文件 / 40 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.example.icatchplayerlibrary.AppInfo`
L9 · [class] public AppInfo · `com/example/icatchplayerlibrary/AppInfo.java`

字段/常量（21）：
- `String APP_VERSION = "R1.4.14_beta3_3"`  L10
- `String AUTO_DOWNLOAD_PATH = "/DCIM/GoLiveCam/"`  L11
- `String DOWNLOAD_PATH = "/DCIM/QSLyCamera/"`  L12
- `String EULA_VERSION = "1.1"`  L13
- `String FILE_GOOGLE_TOKEN = "file_googleToken.dat"`  L14
- `String PROPERTY_CFG_DIRECTORY_PATH = "/SportCamResoure/"`  L15
- `String PROPERTY_CFG_FILE_NAME = "netconfig.properties"`  L16
- `String SDK_LOG_DIRECTORY_PATH = "/IcatchSportCamera_SDK_Log"`  L17
- `String STREAM_OUTPUT_DIRECTORY_PATH = "/SportCamResoure/Raw/"`  L18
- `String UPDATEFW_FILENAME = "/SportCamResoure/tactacam50.BRN"`  L19
- `boolean autoDownloadAllow = false`  L20
- `float autoDownloadSizeLimit = 1.0f`  L21
- `boolean disableAudio = false`  L22
- `boolean displayDecodeTime = false`  L23
- `boolean isDownloading = false`  L24
- `boolean isSdCardExist = true`  L25
- `boolean isSupportAutoReconnection = false`  L26
- `boolean isSupportBroadcast = false`  L27
- `boolean isSupportSetting = false`  L28
- `boolean saveSDKLog = false`  L29
- `boolean youtubeLive = false`  L30

方法（1）：
- `boolean isAppSentToBackground(Context context)`  L32
    - 体内字面量："activity" · "TAG" · "isAppSentToBackground: true" · "TAG" · "isAppSentToBackground: false" · "TAG" · "isAppSentToBackground: false"
### `com.example.icatchplayerlibrary.BaseActivity`
L8 · [class] public BaseActivity · extends `AppCompatActivity` · `com/example/icatchplayerlibrary/BaseActivity.java`

字段/常量（1）：
- `String TAG = "BaseActivity"`  L9

方法（3）：
- `void onCreate(Bundle bundle)`  L12 @Override
- `void onResume()`  L21 @Override
- `void onDestroy()`  L27 @Override
### `com.example.icatchplayerlibrary.CameraAction`
L23 · [class] public CameraAction · `com/example/icatchplayerlibrary/CameraAction.java`

字段/常量（18）：
- `CameraAction instance`  L24
- `ICatchIPancamControl cameraAction`  L25
- `ICatchCameraControl cameraControl`  L26
- `String tag = "CameraAction"`  L27
- `boolean zCapturePhoto`  L54
- `boolean zTriggerCapturePhoto`  L83
- `boolean z = false`  L110
- `boolean zStartTimeLapse`  L129
- `boolean zStopTimeLapse`  L151
- `boolean z = false`  L174
- `boolean z = false`  L195
- `boolean standbyMode = false`  L219
- `boolean zAddCustomEventListener`  L238
- `boolean zDelCustomEventListener`  L254
- `boolean z`  L270
- `boolean z`  L288
- `boolean zZoomIn`  L334
- `boolean zZoomOut`  L356

方法（26）：
- `CameraAction getInstance()`  L29
- `private CameraAction()`  L36
- `void release()`  L40
- `void initCameraAction()`  L44
- `void initCameraAction(ICatchIPancamControl iCatchIPancamControl)`  L49
- `boolean capturePhoto()`  L53
- `boolean triggerCapturePhoto()`  L82
- `boolean startMovieRecord()`  L108
    - 体内字面量："CameraAction" · "begin startVideoCapture"
- `boolean startTimeLapse()`  L128
- `boolean stopTimeLapse()`  L150
- `boolean stopVideoCapture()`  L172
    - 体内字面量："CameraAction" · "begin stopVideoCapture"
- `boolean formatStorage()`  L193
    - 体内字面量："CameraAction" · "begin formatSD"
- `boolean sleepCamera()`  L217
    - 体内字面量："CameraAction" · "begin sleepCamera"
- `boolean addCustomEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L237
- `boolean delCustomEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L253
- `boolean addEventListener(int i, ICatchIPancamListener iCatchIPancamListener)`  L269
- `boolean delEventListener(int i, ICatchIPancamListener iCatchIPancamListener)`  L287
- `boolean addScanEventListener(ICatchIPancamListener iCatchIPancamListener)`  L305
- `boolean delScanEventListener(ICatchIPancamListener iCatchIPancamListener)`  L317
- `String getCameraMacAddress()`  L329
- `boolean zoomIn()`  L333
- `boolean zoomOut()`  L355
- `boolean addGlobalEventListener(int i, ICatchIPancamListener iCatchIPancamListener, Boolean bool)`  L377
- `boolean delGlobalEventListener(int i, ICatchIPancamListener iCatchIPancamListener, Boolean bool)`  L386
- `boolean previewMove(int i, int i2)`  L395
    - 体内字面量："CameraAction" · "begin previewMove" · "CameraAction" · "end previewMove ret = "
- `boolean resetPreviewMove()`  L402
    - 体内字面量："CameraAction" · "begin resetPreviewMove" · "CameraAction" · "end resetPreviewMove ret = "
### `com.example.icatchplayerlibrary.ExitApp`
L9 · [class] public ExitApp · `com/example/icatchplayerlibrary/ExitApp.java`

字段/常量（4）：
- `ExitApp instance`  L10
- `Activity activity`  L11
- `String TAG = "ExitApp"`  L12
- `LinkedList<Activity> linkedList = this.activityList`  L55

方法（7）：
- `ExitApp getInstance()`  L15
- `Activity getCurActivity()`  L22
- `void setCurActivity(Activity activity)`  L26
- `void addActivity(Activity activity)`  L30
    - 体内字面量："ExitApp" · "addActivity activity=" · "ExitApp" · "addActivity activityList size="
- `void removeActivity(Activity activity)`  L39
    - 体内字面量："ExitApp" · "removeActivity activity=" · "ExitApp" · "removeActivity activityList size="
- `void finishActivity(Activity activity)`  L45
- `void exit(int i)`  L52
    - 体内字面量："45241212" · "exit:  ------------------------   " · "ExitApp" · "start exit activity activityList size="
### `com.example.icatchplayerlibrary.FileOperation`
L20 · [class] public FileOperation · `com/example/icatchplayerlibrary/FileOperation.java`

字段/常量（18）：
- `FileOperation instance`  L21
- `ICatchCameraPlayback cameraPlayback`  L22
- `String tag = "FileOperation"`  L23
- `boolean zCancelFileDownload`  L45
- `boolean zCancelFileDownload`  L74
- `ICatchCameraPlayback iCatchCameraPlayback = this.cameraPlayback`  L76
- `List<ICatchFile> listListFiles = null`  L106
- `boolean zDeleteFile`  L130
- `boolean zDownloadFileQuick`  L159
- `boolean zDownloadFile`  L189
- `ICatchFrameBuffer iCatchFrameBufferDownloadFile`  L220
- `ICatchFrameBuffer quickview`  L253
- `ICatchFrameBuffer thumbnail`  L286
- `ICatchFrameBuffer thumbnail`  L319
- `ICatchFrameBuffer thumbnail`  L355
- `boolean zOpenFileTransChannel`  L392
- `boolean zCloseFileTransChannel`  L409
- `boolean zUploadFile`  L426

方法（18）：
- `FileOperation getInstance()`  L25
- `private FileOperation()`  L32
- `void release()`  L36
- `void initICatchWificamPlayback()`  L40
- `boolean cancelDownload(ICatchCameraPlayback iCatchCameraPlayback)`  L44
- `boolean cancelDownload()`  L73
- `List<ICatchFile> getFileList(int i)`  L104
    - 体内字面量："125645124" · "begin getFileList timeout 20s----------------"
- `boolean deleteFile(ICatchFile iCatchFile)`  L129
- `boolean downloadFileQuick(ICatchFile iCatchFile, String str)`  L158
- `boolean downloadFile(ICatchFile iCatchFile, String str)`  L188
- `ICatchFrameBuffer downloadFile(ICatchFile iCatchFile)`  L219
- `ICatchFrameBuffer getQuickview(ICatchFile iCatchFile)`  L252
- `ICatchFrameBuffer getThumbnail(ICatchFile iCatchFile)`  L285
- `ICatchFrameBuffer getThumbnail(String str)`  L318
- `ICatchFrameBuffer getThumbnail(ICatchCameraPlayback iCatchCameraPlayback, String str)`  L354
- `boolean openFileTransChannel()`  L391
- `boolean closeFileTransChannel()`  L408
- `boolean uploadFile(String str, String str2)`  L425
### `com.example.icatchplayerlibrary.GlobalInfo`
L4 · [class] public GlobalInfo · `com/example/icatchplayerlibrary/GlobalInfo.java`

字段/常量（6）：
- `double THRESHOLD_TIME = 0.1d`  L5
- `double curFps = 30.0d`  L6
- `int curSlotId = 0`  L7
- `boolean isNeedGetBTClient = true`  L8
- `boolean isPrepareSession = false`  L9
- `int videoCacheNum`  L10
### `com.example.icatchplayerlibrary.H264DecoderThread1`
L28 · [class] public H264DecoderThread1 · `com/example/icatchplayerlibrary/H264DecoderThread1.java`

字段/常量（26）：
- `String TAG = "H264DecoderThread--"`  L29
- `AudioThread audioThread`  L30
- `MediaCodec decoder`  L31
- `int fps`  L32
- `int frameHeight`  L33
- `int frameWidth`  L34
- `MPreview mPreview`  L35
- `OnDecodeTimeListener onDecodeTimeListener`  L36
- `int previewLaunchMode`  L37
- `ICatchIStreamProvider previewStreamControl`  L38
- `SurfaceHolder surfaceHolder`  L39
- `int timeout`  L40
- `ICatchVideoFormat videoFormat`  L41
- `ICatchIStreamProvider videoPbControl`  L42
- `VideoFramePtsChangedListener videoPbUpdateBarLitener`  L43
- `VideoThread videoThread`  L44
- `boolean audioPlayFlag = false`  L47
- `int BUFFER_LENGTH = 3686400`  L48
- `long videoShowtime = 0`  L49
- `double curVideoPts = AudioStats.AUDIO_AMPLITUDE_NONE`  L50
- `ICatchVideoFormat iCatchVideoFormat2 = this.videoFormat`  L62
- `VideoThread videoThread = this.videoThread`  L96
- `AudioThread audioThread = this.audioThread`  L100
- `AudioThread audioThread = this.audioThread`  L105
- `VideoThread videoThread = this.videoThread`  L109
- `ICatchVideoFormat iCatchVideoFormat = this.videoFormat`  L211

方法（6）：
- `public H264DecoderThread1(MyCamera myCamera, SurfaceHolder surfaceHolder, MPreview mPreview, int i, ICatchVideoFormat iCatchVideoFormat, VideoFramePtsChangedListener videoFramePtsChangedListener)`  L52
- `void setOnDecodeTimeListener(OnDecodeTimeListener onDecodeTimeListener)`  L76
- `void start(boolean z, boolean z2)`  L80
    - 体内字面量："start"
- `boolean isAlive()`  L95
- `void stop()`  L104
- `void setFormat()`  L210
### `com.example.icatchplayerlibrary.H264DecoderThread1$AudioThread`
L234 · [class] private AudioThread · extends `Thread` · `com/example/icatchplayerlibrary/H264DecoderThread1.java`

字段/常量（11）：
- `LinkedList<ICatchFrameBuffer> audioQueue`  L235
- `AudioTrack audioTrack`  L236
- `boolean done`  L237
- `boolean isFirstShow`  L238
- `ICatchAudioFormat audioFormat`  L247
- `boolean nextAudioFrame`  L248
- `ICatchFrameBuffer iCatchFrameBufferPoll`  L249
- `double d`  L250
- `LinkedList<ICatchFrameBuffer> linkedList = this.audioQueue`  L281
- `double d2 = H264DecoderThread1.this.curVideoPts`  L321
- `double d3 = d2 - d`  L330

方法（3）：
- `private AudioThread()`  L240
- `void run()`  L246 @Override
- `void requestExitAndWait()`  L354
### `com.example.icatchplayerlibrary.H264DecoderThread1$VideoThread`
L116 · [class] private VideoThread · extends `Thread` · `com/example/icatchplayerlibrary/H264DecoderThread1.java`

字段/常量（8）：
- `MediaCodec.BufferInfo info`  L117
- `long startTime = 0`  L118
- `int frameSize = 0`  L119
- `boolean done = false`  L120
- `boolean nextVideoFrame`  L127
- `byte[] bArr = new byte[H264DecoderThread1.this.frameWidth * H264DecoderThread1.this.frameHeight * 4]`  L131
- `boolean z = true`  L136
- `ByteBuffer byteBuffer = inputBuffers[iDequeueInputBuffer]`  L157

方法（2）：
- `void run()`  L126 @Override
- `void requestExitAndWait()`  L196
    - 体内字面量："H264Decoder requestExitAndWait isAlive=" · "end  H264Decoder requestExitAndWait"
### `com.example.icatchplayerlibrary.ICatchPreviewMode`
L4 · [enum] public ICatchPreviewMode · `com/example/icatchplayerlibrary/ICatchPreviewMode.java`

枚举常量（3）：
- `ICH_STILL_PREVIEW_MODE()`  L5
- `ICH_VIDEO_PREVIEW_MODE()`  L6
- `ICH_TIMELAPSE_STILL_PREVIEW_MODE()`  L7
### `com.example.icatchplayerlibrary.MjpgDecoderThread1`
L20 · [class] public MjpgDecoderThread1 · `com/example/icatchplayerlibrary/MjpgDecoderThread1.java`

字段/常量（21）：
- `String TAG = "MjpgDecoderThread"`  L21
- `AudioThread audioThread`  L22
- `Rect drawFrameRect`  L23
- `int frameHeight`  L24
- `int frameWidth`  L25
- `MPreview mPreview`  L26
- `OnDecodeTimeListener onDecodeTimeListener`  L27
- `int previewLaunchMode`  L28
- `ICatchIStreamProvider previewStreamControl`  L29
- `SurfaceHolder surfaceHolder`  L30
- `ICatchVideoFormat videoFormat`  L31
- `Bitmap videoFrameBitmap`  L32
- `ICatchIStreamProvider videoPbControl`  L33
- `VideoFramePtsChangedListener videoPbUpdateBarLitener`  L34
- `VideoThread videoThread`  L35
- `VideoThread videoThread = this.videoThread`  L74
- `AudioThread audioThread = this.audioThread`  L78
- `AudioThread audioThread = this.audioThread`  L83
- `VideoThread videoThread = this.videoThread`  L87
- `Canvas canvasLockCanvas`  L181
- `Canvas canvasLockCanvas`  L272

方法（7）：
- `void setOnDecodeTimeListener(OnDecodeTimeListener onDecodeTimeListener)`  L39
- `public MjpgDecoderThread1(MyCamera myCamera, SurfaceHolder surfaceHolder, MPreview mPreview, int i, ICatchVideoFormat iCatchVideoFormat, VideoFramePtsChangedListener videoFramePtsChangedListener)`  L43
- `void start(boolean z, boolean z2)`  L59
    - 体内字面量："start"
- `boolean isAlive()`  L73
- `void stop()`  L82
- `void redrawBitmap()`  L180
- `void redrawBitmap(SurfaceHolder surfaceHolder, int i, int i2)`  L271
### `com.example.icatchplayerlibrary.MjpgDecoderThread1$AudioThread`
L194 · [class] private AudioThread · extends `Thread` · `com/example/icatchplayerlibrary/MjpgDecoderThread1.java`

字段/常量（4）：
- `AudioTrack audioTrack`  L195
- `boolean done`  L196
- `ICatchAudioFormat audioFormat`  L204
- `boolean nextAudioFrame`  L205

方法（3）：
- `private AudioThread()`  L198
- `void run()`  L203 @Override
- `void requestExitAndWait()`  L260
### `com.example.icatchplayerlibrary.MjpgDecoderThread1$VideoThread`
L93 · [class] private VideoThread · extends `Thread` · `com/example/icatchplayerlibrary/MjpgDecoderThread1.java`

字段/常量（8）：
- `ByteBuffer bmpBuf`  L94
- `boolean done = false`  L95
- `byte[] pixelBuf`  L96
- `byte[] bArr = new byte[MjpgDecoderThread1.this.frameWidth * MjpgDecoderThread1.this.frameHeight * 4]`  L99
- `boolean nextVideoFrame`  L108
- `boolean z = false`  L113
- `boolean z2 = true`  L114
- `MjpgDecoderThread1 mjpgDecoderThread1 = MjpgDecoderThread1.this`  L144

方法（2）：
- `void run()`  L107 @Override
- `void requestExitAndWait()`  L169
### `com.example.icatchplayerlibrary.MPreview`
L12 · [class] public MPreview · extends `SurfaceView implements SurfaceHolder.Callback` · implements `SurfaceHolder.Callback` · `com/example/icatchplayerlibrary/MPreview.java`

字段/常量（25）：
- `String TAG = "MPreview"`  L13
- `int frmH`  L14
- `int frmW`  L15
- `H264DecoderThread1 h264DecoderThread`  L16
- `boolean hasSurface`  L17
- `SurfaceHolder holder`  L18
- `MyCamera mCamera`  L19
- `MjpgDecoderThread1 mjpgDecoderThread`  L20
- `boolean needStart`  L21
- `OnDecodeTimeListener onDecodeTimeListener`  L22
- `int previewCodec`  L23
- `int previewLaunchMode`  L24
- `PreviewStream previewStream`  L25
- `ICatchVideoFormat videoFormat`  L26
- `VideoFramePtsChangedListener videoPbUpdateBarLitener`  L27
- `VideoPlayback videoPlayback`  L28
- `int i2 = 0`  L54
- `MjpgDecoderThread1 mjpgDecoderThread1 = this.mjpgDecoderThread`  L95
- `H264DecoderThread1 h264DecoderThread1 = this.h264DecoderThread`  L101
- `boolean z`  L121
- `int i2 = this.previewCodec`  L134
- `int i`  L179
- `int i2 = this.frmH`  L187
- `int i3 = this.previewCodec`  L196
- `MjpgDecoderThread1 mjpgDecoderThread1 = this.mjpgDecoderThread`  L198

方法（12）：
- `public MPreview(Context context, AttributeSet attributeSet)`  L30
    - 体内字面量："create MPreview"
- `void setOnDecodeTimeListener(OnDecodeTimeListener onDecodeTimeListener)`  L46
- `boolean start(MyCamera myCamera, int i)`  L50
    - 体内字面量："start preview hasSurface =" · " previewLaunchMode="
- `boolean stop(int i)`  L93
    - 体内字面量："stopMPreview preview-------------"
- `void surfaceCreated(SurfaceHolder surfaceHolder)`  L112 @Override
    - 体内字面量："surfaceCreated hasSurface ="
- `void startDecoderThread(int i, ICatchVideoFormat iCatchVideoFormat)`  L120
- `void surfaceDestroyed(SurfaceHolder surfaceHolder)`  L154 @Override
    - 体内字面量：" surfaceDestroyed hasSurface ="
- `void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3)`  L161 @Override
    - 体内字面量：" redrawBitmap" · "start startDecoderThread.I'm coming......"
- `void onLayout(boolean z, int i, int i2, int i3, int i4)`  L167 @Override
    - 体内字面量：" change ....onLayout"
- `void run()`  L172 @Override
- `void setSurfaceViewArea()`  L178
- `void addVideoFramePtsChangedListener(VideoFramePtsChangedListener videoFramePtsChangedListener)`  L212
### `com.example.icatchplayerlibrary.MyCamera`
L9 · [class] public MyCamera · `com/example/icatchplayerlibrary/MyCamera.java`

方法（1）：
- `ICatchIStreamProvider getPreviewStreamClient()`  L10
    - 体内字面量："123->" · "Exception : "
### `com.example.icatchplayerlibrary.MyProgressDialog`
L12 · [class] public MyProgressDialog · `com/example/icatchplayerlibrary/MyProgressDialog.java`

字段/常量（5）：
- `boolean hasInit = false`  L13
- `Dialog mDialog`  L14
- `ProgressWheel mProgressWheel`  L15
- `ProgressWheel progressWheel = mProgressWheel`  L66
- `Dialog dialog = mDialog`  L71

方法（3）：
- `void showProgressDialog(Context context, String str)`  L17
- `void showProgressDialog(Context context, int i)`  L41
- `void closeProgressDialog()`  L65
### `com.example.icatchplayerlibrary.MyToast`
L7 · [class] public MyToast · `com/example/icatchplayerlibrary/MyToast.java`

字段/常量（3）：
- `Toast toast`  L8
- `Toast toast2 = toast`  L11
- `Toast toast2 = toast`  L23

方法（2）：
- `void show(Context context, String str)`  L10
- `void show(Context context, int i)`  L22
### `com.example.icatchplayerlibrary.OnDecodeTimeListener`
L4 · [interface] public OnDecodeTimeListener · `com/example/icatchplayerlibrary/OnDecodeTimeListener.java`

方法（1）：
- `void decodeTime(long j)`  L5
### `com.example.icatchplayerlibrary.PreviewStream`
L30 · [class] public PreviewStream · `com/example/icatchplayerlibrary/PreviewStream.java`

字段/常量（19）：
- `PreviewStream instance`  L31
- `String TAG = "PreviewStream"`  L32
- `ICatchIStreamProvider iCatchIStreamProvider`  L33
- `boolean zStop`  L43
- `boolean zContainsAudioStream`  L63
- `Tristate tristate`  L157
- `Tristate tristate2 = Tristate.FALSE`  L159
- `boolean zChangePreviewMode`  L187
- `int videoW`  L201
- `int videoH`  L225
- `ICatchVideoFormat videoFormat`  L249
- `int codec`  L273
- `int bitrate`  L297
- `ICatchAudioFormat audioFormat`  L321
- `boolean zEnableAudio`  L345
- `boolean zDisableAudio`  L371
- `boolean zStartPublishStreaming`  L397
- `boolean zStopPublishStreaming`  L422
- `boolean zIsStreamSupportPublish`  L447

方法（18）：
- `PreviewStream getInstance()`  L35
- `boolean stopMediaStream(ICatchIPancamPreview iCatchIPancamPreview)`  L42
- `boolean supportAudio(ICatchIStreamProvider iCatchIStreamProvider)`  L62
- `boolean getNextVideoFrame(ICatchFrameBuffer iCatchFrameBuffer, ICatchIStreamProvider iCatchIStreamProvider)`  L86
    - 体内字面量："PreviewStream" · "IchBufferTooSmallException" · "PreviewStream" · "IchInvalidSessionException" · "PreviewStream" · "IchStreamNotRunningException" · "PreviewStream" · "IchTryAgainException" · "PreviewStream" · "IchVideoStreamClosedException"
- `boolean getNextAudioFrame(ICatchIStreamProvider iCatchIStreamProvider, ICatchFrameBuffer iCatchFrameBuffer)`  L121
    - 体内字面量："PreviewStream" · "IchAudioStreamClosedException" · "PreviewStream" · "IchBufferTooSmallException" · "PreviewStream" · "IchInvalidSessionException" · "PreviewStream" · "IchStreamNotRunningException" · "PreviewStream" · "IchTryAgainException"
- `Tristate startMediaStream(ICatchIPancamPreview iCatchIPancamPreview, ICatchStreamParam iCatchStreamParam, ICatchPreviewMode iCatchPreviewMode, boolean z)`  L156
- `boolean changePreviewMode(ICatchCameraControl iCatchCameraControl, ICatchPreviewMode iCatchPreviewMode)`  L186
- `int getVideoWidth(ICatchIStreamProvider iCatchIStreamProvider)`  L200
- `int getVideoHeigth(ICatchIStreamProvider iCatchIStreamProvider)`  L224
- `ICatchVideoFormat getVideoFormat(ICatchIStreamProvider iCatchIStreamProvider)`  L248
- `int getCodec(ICatchIStreamProvider iCatchIStreamProvider)`  L272
- `int getBitrate(ICatchIStreamProvider iCatchIStreamProvider)`  L296
- `ICatchAudioFormat getAudioFormat(ICatchIStreamProvider iCatchIStreamProvider)`  L320
- `boolean enableAudio(ICatchIPancamPreview iCatchIPancamPreview)`  L344
- `boolean disableAudio(ICatchIPancamPreview iCatchIPancamPreview)`  L370
- `boolean startPublishStreaming(ICatchIPancamPreview iCatchIPancamPreview, String str)`  L396
- `boolean stopPublishStreaming(ICatchIPancamPreview iCatchIPancamPreview)`  L421
- `boolean isStreamSupportPublish(ICatchIPancamPreview iCatchIPancamPreview)`  L446
### `com.example.icatchplayerlibrary.ProgressWheel`
L14 · [class] public ProgressWheel · extends `View` · `com/example/icatchplayerlibrary/ProgressWheel.java`

字段/常量（52）：
- `int barColor`  L15
- `int barLength`  L16
- `Paint barPaint`  L17
- `int barWidth`  L18
- `RectF circleBounds`  L19
- `int circleColor`  L20
- `RectF circleInnerContour`  L21
- `RectF circleOuterContour`  L22
- `Paint circlePaint`  L23
- `int circleRadius`  L24
- `int contourColor`  L25
- `Paint contourPaint`  L26
- `float contourSize`  L27
- `int delayMillis`  L28
- `int fullRadius`  L29
- `RectF innerCircleBounds`  L30
- `boolean isSpinning`  L31
- `int layoutHeight`  L32
- `int layoutWidth`  L33
- `int paddingBottom`  L34
- `int paddingLeft`  L35
- `int paddingRight`  L36
- `int paddingTop`  L37
- `float progress`  L38
- `int rimColor`  L39
- `Paint rimPaint`  L40
- `int rimWidth`  L41
- `float spinSpeed`  L42
- `String[] splitText`  L43
- `String text`  L44
- `int textColor`  L45
- `Paint textPaint`  L46
- `int textSize`  L47
- `int i = this.layoutWidth - iMin`  L138
- `int i3 = i / 2`  L142
- `float f = this.paddingLeft`  L147
- `int i4 = this.barWidth`  L148
- `int i5 = this.paddingLeft`  L150
- `int i6 = this.barWidth`  L151
- `int i7 = width - this.paddingRight`  L155
- `int i8 = this.barWidth`  L156
- `float f = this.progress + this.spinSpeed`  L206
- `float f = this.progress + i`  L241
- `Paint paint = this.barPaint`  L282
- `Paint paint = this.textPaint`  L294
- `Paint paint = this.barPaint`  L342
- `Paint paint = this.circlePaint`  L354
- `Paint paint = this.rimPaint`  L366
- `Paint paint = this.textPaint`  L386
- `Paint paint = this.rimPaint`  L406
- `Paint paint = this.contourPaint`  L426
- `Paint paint = this.contourPaint`  L438

方法（53）：
- `public ProgressWheel(Context context, AttributeSet attributeSet)`  L49
- `void onMeasure(int i, int i2)`  L88 @Override
- `void onSizeChanged(int i, int i2, int i3, int i4)`  L105 @Override
- `void setupPaints()`  L114
- `void setupBounds()`  L136
- `void parseAttributes(TypedArray typedArray)`  L162
- `void onDraw(Canvas canvas)`  L186 @Override
- `void scheduleRedraw()`  L205
- `boolean isSpinning()`  L214
- `void resetCount()`  L218
    - 体内字面量："0%"
- `void stopSpinning()`  L224
- `void startSpinning()`  L230
- `void incrementProgress()`  L235
- `void incrementProgress(int i)`  L239
- `void setProgress(int i)`  L249
- `void setText(String str)`  L255
    - 体内字面量："\n"
- `int getCircleRadius()`  L260
- `void setCircleRadius(int i)`  L264
- `int getBarLength()`  L268
- `void setBarLength(int i)`  L272
- `int getBarWidth()`  L276
- `void setBarWidth(int i)`  L280
- `int getTextSize()`  L288
- `void setTextSize(int i)`  L292
- `int getPaddingTop()`  L301 @Override
- `void setPaddingTop(int i)`  L305
- `int getPaddingBottom()`  L310 @Override
- `void setPaddingBottom(int i)`  L314
- `int getPaddingLeft()`  L319 @Override
- `void setPaddingLeft(int i)`  L323
- `int getPaddingRight()`  L328 @Override
- `void setPaddingRight(int i)`  L332
- `int getBarColor()`  L336
- `void setBarColor(int i)`  L340
- `int getCircleColor()`  L348
- `void setCircleColor(int i)`  L352
- `int getRimColor()`  L360
- `void setRimColor(int i)`  L364
- `Shader getRimShader()`  L372
- `void setRimShader(Shader shader)`  L376
- `int getTextColor()`  L380
- `void setTextColor(int i)`  L384
- `float getSpinSpeed()`  L392
- `void setSpinSpeed(float f)`  L396
- `int getRimWidth()`  L400
- `void setRimWidth(int i)`  L404
- `int getDelayMillis()`  L412
- `void setDelayMillis(int i)`  L416
- `int getContourColor()`  L420
- `void setContourColor(int i)`  L424
- `float getContourSize()`  L432
- `void setContourSize(float f)`  L436
- `int getProgress()`  L444
### `com.example.icatchplayerlibrary.R`
L4 · [class] public final R · `com/example/icatchplayerlibrary/R.java`

方法（1）：
- `private R()`  L152
### `com.example.icatchplayerlibrary.R$attr`
L6 · [class] public static final attr · `com/example/icatchplayerlibrary/R.java`

字段/常量（14）：
- `int barColor = 0x7f040071`  L7
- `int barLengthP = 0x7f040073`  L8
- `int barWidth = 0x7f040074`  L9
- `int circleColor = 0x7f0400fb`  L10
- `int contourColor = 0x7f04017f`  L11
- `int contourSize = 0x7f040180`  L12
- `int delayMillis = 0x7f040229`  L13
- `int pw_radius = 0x7f0404c4`  L14
- `int rimColor = 0x7f0404eb`  L15
- `int rimWidth = 0x7f0404ec`  L16
- `int spinSpeed = 0x7f040589`  L17
- `int text = 0x7f040625`  L18
- `int textColor = 0x7f040651`  L19
- `int textSize = 0x7f040663`  L20

方法（1）：
- `private attr()`  L22
### `com.example.icatchplayerlibrary.R$color`
L26 · [class] public static final color · `com/example/icatchplayerlibrary/R.java`

字段/常量（5）：
- `int full_transparent = 0x7f0600c0`  L27
- `int grayslate = 0x7f0600dc`  L28
- `int graywhite = 0x7f0600dd`  L29
- `int greyish_white = 0x7f0600e3`  L30
- `int half_transparent_grey = 0x7f0600e6`  L31

方法（1）：
- `private color()`  L33
### `com.example.icatchplayerlibrary.R$drawable`
L37 · [class] public static final drawable · `com/example/icatchplayerlibrary/R.java`

字段/常量（49）：
- `int action_about = 0x7f08007e`  L38
- `int camera_wifi_connected = 0x7f08010d`  L39
- `int camera_wifi_disconnected = 0x7f08010e`  L40
- `int ic_action_right = 0x7f08027e`  L41
- `int ic_add_circle_24dp = 0x7f08027f`  L42
- `int ic_add_circle_greyish_white_36dp = 0x7f080280`  L43
- `int ic_add_white_24dp = 0x7f080282`  L44
- `int ic_arrow_back_black_18dp = 0x7f080285`  L45
- `int ic_arrow_back_white_24dp = 0x7f080287`  L46
- `int ic_arrow_back_white_36dp = 0x7f080288`  L47
- `int ic_check_box_blank_grey = 0x7f0802a8`  L48
- `int ic_close_black = 0x7f0802af`  L49
- `int ic_delete_grey_600_24dp = 0x7f0802b8`  L50
- `int ic_delete_white_18dp = 0x7f0802b9`  L51
- `int ic_delete_white_24dp = 0x7f0802ba`  L52
- `int ic_delete_white_36dp = 0x7f0802bb`  L53
- `int ic_done_black = 0x7f0802be`  L54
- `int ic_done_blue_grey_900_48dp = 0x7f0802bf`  L55
- `int ic_done_cyan = 0x7f0802c0`  L56
- `int ic_done_grey_100_48dp = 0x7f0802c1`  L57
- `int ic_download = 0x7f0802c2`  L58
- `int ic_downloads = 0x7f0802c3`  L59
- `int ic_file_download_grey_600_24dp = 0x7f0802c7`  L60
- `int ic_file_download_white_24dp = 0x7f0802c8`  L61
- `int ic_info_white_36dp = 0x7f0802f1`  L62
- `int ic_navigate_before_white_18dp = 0x7f080315`  L63
- `int ic_navigate_before_white_36dp = 0x7f080316`  L64
- `int ic_pause_white = 0x7f08031d`  L65
- `int ic_pause_white_36dp = 0x7f08031e`  L66
- `int ic_play_arrow_white = 0x7f080320`  L67
- `int ic_play_arrow_white_24dp = 0x7f080321`  L68
- `int ic_play_arrow_white_36dp = 0x7f080322`  L69
- `int ic_play_circle_outline_blue_grey = 0x7f080326`  L70
- `int ic_play_circle_outline_blue_grey_48dp = 0x7f080327`  L71
- `int ic_refresh_white_24dp = 0x7f080334`  L72
- `int ic_remove_white_24dp = 0x7f080335`  L73
- `int ic_settings_power = 0x7f08033a`  L74
- `int ic_settings_white = 0x7f08033b`  L75
- `int ic_share_white_24dp = 0x7f08033e`  L76
- `int ic_share_white_36dp = 0x7f08033f`  L77
- `int ic_stop_white_24dp = 0x7f080340`  L78
- `int ic_stop_white_36dp = 0x7f080341`  L79
- `int icon_full = 0x7f080366`  L80
- `int icon_zoom = 0x7f0803aa`  L81
- `int po_seekbar_02 = 0x7f080496`  L82
- `int seekbar_thumb = 0x7f08051d`  L83
- `int selector_full_screen = 0x7f080530`  L84
- `int selector_transparent2gray = 0x7f080546`  L85
- `int video_fast_search_nomal = 0x7f080629`  L86

方法（1）：
- `private drawable()`  L88
### `com.example.icatchplayerlibrary.R$id`
L92 · [class] public static final id · `com/example/icatchplayerlibrary/R.java`

字段/常量（16）：
- `int delete = 0x7f0a0175`  L93
- `int download = 0x7f0a01aa`  L94
- `int layout_progress_wheel = 0x7f0a03a6`  L95
- `int pw_spinner = 0x7f0a052c`  L96
- `int video_full_screen = 0x7f0a07d3`  L97
- `int video_pb_back = 0x7f0a07d9`  L98
- `int video_pb_bottom_layout = 0x7f0a07da`  L99
- `int video_pb_play_btn = 0x7f0a07db`  L100
- `int video_pb_seekBar = 0x7f0a07dc`  L101
- `int video_pb_spinner = 0x7f0a07dd`  L102
- `int video_pb_stop_btn = 0x7f0a07de`  L103
- `int video_pb_time_duration = 0x7f0a07df`  L104
- `int video_pb_time_lapsed = 0x7f0a07e0`  L105
- `int video_pb_top_layout = 0x7f0a07e1`  L106
- `int video_pb_video_name = 0x7f0a07e2`  L107
- `int video_pb_view = 0x7f0a07e3`  L108

方法（1）：
- `private id()`  L110
### `com.example.icatchplayerlibrary.R$layout`
L114 · [class] public static final layout · `com/example/icatchplayerlibrary/R.java`

字段/常量（3）：
- `int activity_video_pb = 0x7f0d0070`  L115
- `int content_video_pb = 0x7f0d008b`  L116
- `int layout_progress_wheel_small = 0x7f0d0150`  L117

方法（1）：
- `private layout()`  L119
### `com.example.icatchplayerlibrary.R$style`
L123 · [class] public static final style · `com/example/icatchplayerlibrary/R.java`

字段/常量（2）：
- `int Dialog = 0x7f150138`  L124
- `int PbVideoTheme = 0x7f150183`  L125

方法（1）：
- `private style()`  L127
### `com.example.icatchplayerlibrary.R$styleable`
L131 · [class] public static final styleable · `com/example/icatchplayerlibrary/R.java`

字段/常量（15）：
- `int[] ProgressWheel = {com.gku.xtugo.R.attr.barColor, com.gku.xtugo.R.attr.barLengthP, com.gku.xtugo.R.attr.barWidth, com.gku.xtugo.R.attr.circleColor, com.gku.xtugo.R.attr.contourColor, com.gku.xtugo.R.attr.contourSize, com.gku.xtugo.R.attr.delayMillis, com.gku.xtugo.R.attr.pw_radius, com.gku.xtugo.R.attr.rimColor, com.gku.xtugo.R.attr.rimWidth, com.gku.xtugo.R.attr.spinSpeed, com.gku.xtugo.R.attr.text, com.gku.xtugo.R.attr.textColor, com.gku.xtugo.R.attr.textSize}`  L132
- `int ProgressWheel_barColor = 0x00000000`  L133
- `int ProgressWheel_barLengthP = 0x00000001`  L134
- `int ProgressWheel_barWidth = 0x00000002`  L135
- `int ProgressWheel_circleColor = 0x00000003`  L136
- `int ProgressWheel_contourColor = 0x00000004`  L137
- `int ProgressWheel_contourSize = 0x00000005`  L138
- `int ProgressWheel_delayMillis = 0x00000006`  L139
- `int ProgressWheel_pw_radius = 0x00000007`  L140
- `int ProgressWheel_rimColor = 0x00000008`  L141
- `int ProgressWheel_rimWidth = 0x00000009`  L142
- `int ProgressWheel_spinSpeed = 0x0000000a`  L143
- `int ProgressWheel_text = 0x0000000b`  L144
- `int ProgressWheel_textColor = 0x0000000c`  L145
- `int ProgressWheel_textSize = 0x0000000d`  L146

方法（1）：
- `private styleable()`  L148
### `com.example.icatchplayerlibrary.StorageUtil`
L9 · [class] public StorageUtil · `com/example/icatchplayerlibrary/StorageUtil.java`

字段/常量（7）：
- `String TAG = "StorageUtil"`  L10
- `String str`  L13
- `File file = externalFilesDirs[1]`  L20
- `File externalStorageDirectory`  L34
- `File file`  L35
- `File file`  L51
- `boolean z = false`  L54

方法（4）：
- `String getDownloadPath(Context context)`  L12
- `File getStorageDirectory(Context context)`  L33
- `boolean sdCardExist(Context context)`  L50
- `String getCurStorageLocation(Context context)`  L62
    - 体内字面量："appData" · "storageLocation" · "InternalStorage" · "InternalStorage" · "ææºå­å¨" · "SDå¡"
### `com.example.icatchplayerlibrary.Tristate`
L4 · [enum] public Tristate · `com/example/icatchplayerlibrary/Tristate.java`

枚举常量（2）：
- `FALSE()`  L5
- `NORMAL()`  L6
### `com.example.icatchplayerlibrary.VideoFramePtsChangedListener`
L4 · [interface] public VideoFramePtsChangedListener · `com/example/icatchplayerlibrary/VideoFramePtsChangedListener.java`

方法（1）：
- `void onFramePtsChanged(double d)`  L5
### `com.example.icatchplayerlibrary.VideoPbActivity`
L21 · [class] public VideoPbActivity · extends `BaseActivity implements VideoPbView` · implements `VideoPbView` · `com/example/icatchplayerlibrary/VideoPbActivity.java`

字段/常量（18）：
- `ImageButton back`  L22
- `RelativeLayout bottomBar`  L23
- `ImageButton deleteBtn`  L24
- `ImageButton downloadBtn`  L25
- `ImageView fullScreen`  L26
- `Handler mainHandler`  L27
- `ImageButton play`  L28
- `VideoPbPresenter presenter`  L29
- `ProgressWheel progressWheel`  L30
- `SeekBar seekBar`  L31
- `ImageButton stopBtn`  L32
- `TextView timeDuration`  L33
- `TextView timeLapsed`  L34
- `LinearLayout topBar`  L35
- `TextView videoNameTxv`  L36
- `MPreview videoPbView`  L37
- `String TAG = "VideoPbActivity"`  L38
- `boolean isShowBar = true`  L39

方法（39）：
- `void setPlayCircleImageViewVisibility(int i)`  L42 @Override
- `void onCreate(Bundle bundle)`  L46 @Override
- `void onFramePtsChanged(double d)`  L69 @Override
- `void onClick(View view)`  L75 @Override
- `void onClick(View view)`  L81 @Override
- `void run()`  L91 @Override
- `void onClick(View view)`  L103 @Override
- `void onClick(View view)`  L113 @Override
- `void onClick(View view)`  L119 @Override
- `void onProgressChanged(SeekBar seekBar, int i, boolean z)`  L125 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L130 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L135 @Override
- `void onResume()`  L142 @Override
- `void onStop()`  L148 @Override
- `void onDestroy()`  L154 @Override
- `void setTopBarVisibility(int i)`  L162 @Override
- `void setBottomBarVisibility(int i)`  L167 @Override
- `void setTimeLapsedValue(String str)`  L172 @Override
- `void setTimeDurationValue(String str)`  L177 @Override
- `void setSeekBarProgress(int i)`  L182 @Override
- `void setSeekBarMaxValue(int i)`  L187 @Override
- `int getSeekBarProgress()`  L192 @Override
- `void setSeekBarSecondProgress(int i)`  L197 @Override
- `void setPlayBtnSrc(int i)`  L202 @Override
- `void showLoadingCircle(boolean z)`  L207 @Override
    - 体内字面量："showLoadingCircle isShow=" · "0%"
- `void setLoadPercent(int i)`  L220 @Override
    - 体内字面量："%"
- `void showExitLoadingCircle(boolean z)`  L225 @Override
- `void setVideoNameTxv(String str)`  L237 @Override
- `void startMPreview(MyCamera myCamera, int i)`  L242 @Override
- `void stopMPreview()`  L247 @Override
- `void setSeekbarEnabled(boolean z)`  L252 @Override
- `void setDeleteBtnEnabled(boolean z)`  L259 @Override
- `void setDownloadBtnEnabled(boolean z)`  L269 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L279 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `void run()`  L293 @Override
    - 体内字面量："123->" · "time 1  =" · "123->" · "time 2  =" · "123->" · "time 3  ="
- `void onVideoStopSuccess()`  L311 @Override
- `void onConfigurationChanged(Configuration configuration)`  L316 @Override
    - 体内字面量："onConfigurationChanged"
- `void refresh()`  L322
- `void setFullScreen(Boolean bool)`  L326
### `com.example.icatchplayerlibrary.VideoPbPresenter`
L22 · [class] public VideoPbPresenter · `com/example/icatchplayerlibrary/VideoPbPresenter.java`

字段/常量（30）：
- `Activity activity`  L23
- `CacheProgressListener cacheProgressListener`  L24
- `CacheStateChangedListener cacheStateChangedListener`  L25
- `CameraAction cameraAction`  L26
- `ICatchFile curVideoFile`  L27
- `int curVideoPosition`  L28
- `Timer downloadProgressTimer`  L29
- `ExecutorService executor`  L30
- `FileOperation fileOperation`  L31
- `int lastSeekBarPosition`  L32
- `MediaClosedListener mediaClosedListener`  L33
- `MyCamera myCamera`  L34
- `VideoIsEndListener videoIsEndListener`  L35
- `VideoPbView videoPbView`  L36
- `VideoPlayback videoPlayback`  L37
- `String TAG = "123->"`  L38
- `VideoPbMode videoPbMode = VideoPbMode.MODE_VIDEO_IDLE`  L39
- `boolean needUpdateSeekBar = true`  L40
- `boolean cacheFlag = false`  L43
- `Boolean waitForCaching = false`  L44
- `double currentTime = -1.0d`  L45
- `int videoDuration = 0`  L46
- `String downloadingFilename = "<binary/metadata>"`  L47
- `String curFilePath = "<binary/metadata>"`  L48
- `boolean isMediaClosed = false`  L49
- `int count = 0`  L51
- `CacheStateChangedListener cacheStateChangedListener = this.cacheStateChangedListener`  L131
- `CacheProgressListener cacheProgressListener = this.cacheProgressListener`  L135
- `VideoIsEndListener videoIsEndListener = this.videoIsEndListener`  L139
- `MediaClosedListener mediaClosedListener = this.mediaClosedListener`  L143

方法（31）：
- `void submitAppInfo()`  L53
- `void release()`  L56
- `public VideoPbPresenter(Activity activity)`  L64
    - 体内字面量："curfilePosition" · "cur video position=" · " video name="
- `public VideoPbPresenter(Activity activity, String str)`  L72
    - 体内字面量："curfilePosition" · "cur video position=" · " video name="
- `void updatePbSeekbar(double d)`  L81
- `void setView(VideoPbView videoPbView)`  L88
- `void initView()`  L94
    - 体内字面量："/"
- `void initClint()`  L99
- `void isAppBackground()`  L106
- `void removeActivity()`  L113
- `void addEventListener()`  L119
- `void removeEventListener()`  L130
- `void play()`  L150
    - 体内字面量："start play video  currentTime=" · "æä½å¤±è´¥ï¼è¯·éè¯ã" · "failed to startPlaybackStream" · "seekBar.getProgress() =" · "end getLength = " · "00:00" · "has start the GetVideoFrameThread() to get play video"
- `void startVideoPbForSeek()`  L184
    - 体内字面量："startVideoPbForSeek" · "æä½å¤±è´¥ï¼è¯·éè¯ã" · "failed to startPlaybackStream"
- `void seekBarOnStopTrackingTouch()`  L201
    - 体内字面量："seekBarOnStopTrackingTouch lastSeekBarPosition=" · " videoDuration="
- `void run()`  L212 @Override
- `void run()`  L222 @Override
- `void run()`  L232 @Override
- `void seekBarOnStartTrackingTouch()`  L245
    - 体内字面量："seekBarOnStartTrackingTouch lastSeekBarPosition="
- `void setTimeLapsedValue(int i)`  L254
- `void resumeVideoPb()`  L258
    - 体内字面量："mode == MODE_VIDEO_PAUSE" · "failed to resumePlayback"
- `void pauseVideoPb()`  L273
    - 体内字面量："begin pause the playing" · "failed to pausePlayback"
- `void startVideoPb()`  L287
    - 体内字面量："startVideoPb"
- `boolean videoHasStop()`  L295
- `void stopVideoPbAndFinish()`  L299
    - 体内字面量："123->" · "stopVideoPbAndFinish VideoPbMode.MODE_VIDEO_IDLE" · "00:00" · "123->" · "stopVideoPb time="
- `void run()`  L313 @Override
    - 体内字面量："123->" · "åéMESSAGE_VIDEO_STREAM_STOP" · "123->" · "åéMESSAGE_VIDEO_STREAM_STOP =" · "123->" · "stopPlaybackStream time="
- `void stopVideoPb()`  L330
    - 体内字面量："00:00"
- `void run()`  L338 @Override
    - 体内字面量："123->" · "åéMESSAGE_VIDEO_STREAM_STOP" · "123->" · "åéMESSAGE_VIDEO_STREAM_STOP ="
- `void refresh()`  L355
    - 体内字面量："refresh"
- `void run()`  L361 @Override
- `void showBar(boolean z)`  L467
### `com.example.icatchplayerlibrary.VideoPbPresenter$CacheProgressListener`
L437 · [class] public CacheProgressListener · implements `ICatchIPancamListener` · `com/example/icatchplayerlibrary/VideoPbPresenter.java`

方法（2）：
- `public CacheProgressListener()`  L438
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L442 @Override
### `com.example.icatchplayerlibrary.VideoPbPresenter$CacheStateChangedListener`
L427 · [class] public CacheStateChangedListener · implements `ICatchIPancamListener` · `com/example/icatchplayerlibrary/VideoPbPresenter.java`

方法（2）：
- `public CacheStateChangedListener()`  L428
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L432 @Override
### `com.example.icatchplayerlibrary.VideoPbPresenter$MediaClosedListener`
L457 · [class] public MediaClosedListener · implements `ICatchIPancamListener` · `com/example/icatchplayerlibrary/VideoPbPresenter.java`

方法（2）：
- `public MediaClosedListener()`  L458
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L462 @Override
### `com.example.icatchplayerlibrary.VideoPbPresenter$VideoIsEndListener`
L447 · [class] public VideoIsEndListener · implements `ICatchIPancamListener` · `com/example/icatchplayerlibrary/VideoPbPresenter.java`

方法（2）：
- `public VideoIsEndListener()`  L448
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L452 @Override
### `com.example.icatchplayerlibrary.VideoPbPresenter$VideoPbHandler`
L367 · [class] private VideoPbHandler · extends `Handler` · `com/example/icatchplayerlibrary/VideoPbPresenter.java`

方法（3）：
- `private VideoPbHandler()`  L368
- `void handleMessage(Message message)`  L372 @Override
    - 体内字面量："receive EVENT_VIDEO_PLAY_COMPLETED" · "receive MESSAGE_STREAM_CLOSED" · "123->" · "æ¶å°MESSAGE_VIDEO_STREAM_STOP ="
- `void run()`  L417 @Override
### `com.example.icatchplayerlibrary.VideoPbView`
L4 · [interface] public VideoPbView · `com/example/icatchplayerlibrary/VideoPbView.java`

方法（20）：
- `int getSeekBarProgress()`  L5
- `void onVideoStopSuccess()`  L7
- `void setBottomBarVisibility(int i)`  L9
- `void setDeleteBtnEnabled(boolean z)`  L11
- `void setDownloadBtnEnabled(boolean z)`  L13
- `void setLoadPercent(int i)`  L15
- `void setPlayBtnSrc(int i)`  L17
- `void setPlayCircleImageViewVisibility(int i)`  L19
- `void setSeekBarMaxValue(int i)`  L21
- `void setSeekBarProgress(int i)`  L23
- `void setSeekBarSecondProgress(int i)`  L25
- `void setSeekbarEnabled(boolean z)`  L27
- `void setTimeDurationValue(String str)`  L29
- `void setTimeLapsedValue(String str)`  L31
- `void setTopBarVisibility(int i)`  L33
- `void setVideoNameTxv(String str)`  L35
- `void showExitLoadingCircle(boolean z)`  L37
- `void showLoadingCircle(boolean z)`  L39
- `void startMPreview(MyCamera myCamera, int i)`  L41
- `void stopMPreview()`  L43
### `com.example.icatchplayerlibrary.VideoPlayback`
L32 · [class] public VideoPlayback · `com/example/icatchplayerlibrary/VideoPlayback.java`

字段/常量（19）：
- `VideoPlayback instance`  L33
- `ICatchIStreamProvider iCatchIStreamProvider`  L34
- `String tag = "VideoPlayback"`  L35
- `ICatchIPancamVideoPlayback videoPlayback`  L36
- `boolean zStop`  L75
- `ICatchIPancamVideoPlayback iCatchIPancamVideoPlayback = this.videoPlayback`  L77
- `boolean zStop`  L99
- `boolean zPlay = false`  L123
- `boolean zPlay = false`  L148
- `boolean zPause`  L170
- `boolean zResume`  L195
- `double length`  L220
- `double d = length * 100.0d`  L238
- `boolean zSeek`  L245
- `boolean nextVideoFrame`  L270
- `boolean nextAudioFrame`  L312
- `boolean zContainsAudioStream`  L352
- `ICatchAudioFormat audioFormat`  L376
- `ICatchVideoFormat videoFormat`  L400

方法（19）：
- `VideoPlayback getInstance()`  L38
- `private VideoPlayback()`  L45
- `void release()`  L49
- `void refreshVideoPlayback()`  L53
- `void initVideoPlayback()`  L58
- `void initVideoPlayback(ICatchIPancamVideoPlayback iCatchIPancamVideoPlayback)`  L70
- `boolean stopPlaybackStream()`  L74
- `boolean stopPlaybackStream(ICatchIPancamVideoPlayback iCatchIPancamVideoPlayback)`  L98
- `boolean startPlaybackStream(ICatchFile iCatchFile)`  L121
    - 体内字面量："VideoPlayback" · "begin startPlaybackStream file="
- `boolean startPlaybackStream(String str)`  L145
    - 体内字面量："VideoPlayback" · "begin startPlaybackStream file="
- `boolean pausePlayback()`  L169
- `boolean resumePlayback()`  L194
- `int getVideoDuration()`  L219
- `boolean videoSeek(double d)`  L244
- `boolean getNextVideoFrame(ICatchFrameBuffer iCatchFrameBuffer)`  L269
- `boolean getNextAudioFrame(ICatchFrameBuffer iCatchFrameBuffer)`  L311
- `boolean containsAudioStream()`  L351
- `ICatchAudioFormat getAudioFormat()`  L375
- `ICatchVideoFormat getVideoFormat()`  L399