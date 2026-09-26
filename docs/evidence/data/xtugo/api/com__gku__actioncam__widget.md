# XTU GO — 类与成员明细：com.gku.actioncam.widget

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 9 个文件 / 14 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.widget.controller.YunqiMediaControllerWrapper`
L10 · [class] public YunqiMediaControllerWrapper · extends `MediaController` · `com/gku/actioncam/widget/controller/YunqiMediaControllerWrapper.java`

字段/常量（2）：
- `YunqiPlayerControlView playerControlView`  L11
- `View rootView = view`  L29

方法（13）：
- `public YunqiMediaControllerWrapper(Context context)`  L13
- `public YunqiMediaControllerWrapper(YunqiPlayerControlView playerControlView)`  L17
- `void setMediaPlayer(MediaController.MediaPlayerControl player)`  L23 @Override
- `void setAnchorView(View view)`  L28 @Override
- `void show()`  L37 @Override
- `void show(int timeout)`  L42 @Override
- `boolean isShowing()`  L47 @Override
- `void hide()`  L52 @Override
- `boolean onTouchEvent(MotionEvent event)`  L60 @Override
- `boolean onTrackballEvent(MotionEvent ev)`  L65 @Override
- `boolean dispatchTouchEvent(MotionEvent ev)`  L70 @Override
- `void setEnabled(boolean enabled)`  L75 @Override
- `CharSequence getAccessibilityClassName()`  L80 @Override
### `com.gku.actioncam.widget.controller.YunqiPlayerControlView`
L20 · [class] public YunqiPlayerControlView · extends `LinearLayout` · `com/gku/actioncam/widget/controller/YunqiPlayerControlView.java`

字段/常量（25）：
- `boolean alwaysShow`  L21
- `boolean dragging`  L22
- `Runnable hideRunnable`  L23
- `MediaController.MediaPlayerControl player`  L24
- `int showTimeoutMs`  L25
- `boolean showing`  L26
- `Runnable updateProgressRunnable`  L27
- `VideoControlStateListener videoControlStateListener`  L28
- `ViewHolder viewHolder`  L29
- `VideoControlStateListener videoControlStateListener = this.videoControlStateListener`  L54
- `YunqiPlayerControlView yunqiPlayerControlView = YunqiPlayerControlView.this`  L77
- `YunqiPlayerControlView yunqiPlayerControlView = YunqiPlayerControlView.this`  L117
- `YunqiPlayerControlView yunqiPlayerControlView2 = YunqiPlayerControlView.this`  L119
- `YunqiPlayerControlView yunqiPlayerControlView = YunqiPlayerControlView.this`  L127
- `VideoControlStateListener videoControlStateListener = this.videoControlStateListener`  L253
- `ViewHolder viewHolder = this.viewHolder`  L298
- `MediaController.MediaPlayerControl mediaPlayerControl = this.player`  L305
- `MediaController.MediaPlayerControl mediaPlayerControl = this.player`  L313
- `String str`  L321
- `int i = timeMs / 1000`  L325
- `int i2 = i / 3600`  L326
- `int i4 = i % 60`  L328
- `String str2 = "<binary/metadata>"`  L329
- `MediaController.MediaPlayerControl mediaPlayerControl = this.player`  L346
- `MediaController.MediaPlayerControl mediaPlayerControl = this.player`  L360

方法（31）：
- `boolean isShowing()`  L41
- `MediaController.MediaPlayerControl getPlayer()`  L45
- `void hide()`  L49
- `public YunqiPlayerControlView(Context context)`  L60
- `public YunqiPlayerControlView(Context context, AttributeSet attrs)`  L64
- `public YunqiPlayerControlView(Context context, AttributeSet attrs, int defStyleAttr)`  L68
- `void run()`  L72 @Override
- `void run()`  L83 @Override
- `void onClick(View v)`  L96 @Override
- `void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)`  L104 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L114 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L124 @Override
- `void onClick(View v)`  L134 @Override
- `YunqiMediaControllerWrapper getYunqiMediaControlWrapper(VideoControlStateListener videoControlStateListener)`  L139
- `void setPlayer(MediaController.MediaPlayerControl player)`  L144
- `void attach(Activity activity)`  L149
- `void attach(ViewGroup rootView)`  L153
- `boolean dispatchKeyEvent(KeyEvent event)`  L165 @Override
- `void onDetachedFromWindow()`  L216 @Override
- `void setEnabled(boolean enabled)`  L223 @Override
- `void show()`  L232
- `void show(int showTimeoutMs)`  L236
- `void updatePausePlayImage()`  L273
- `int updateProgress()`  L281
- `void updateTimeText()`  L297
- `int getCurrentTime()`  L304
- `int getTotalTime()`  L312
- `String formatTime(int timeMs)`  L320
- `void doPauseResume()`  L345
- `void disableUnsupportedButtons()`  L359
- `void setAlwaysShow(boolean alwaysShow)`  L373
### `com.gku.actioncam.widget.controller.YunqiPlayerControlView$VideoControlStateListener`
L31 · [interface] public VideoControlStateListener · `com/gku/actioncam/widget/controller/YunqiPlayerControlView.java`

方法（4）：
- `void isControlShow(boolean isShow)`  L32
- `void isPlaying(boolean isPlaying)`  L34
- `void onProgressChanged(SeekBar seekBar)`  L36
- `void onStopTrackingTouch(SeekBar seekBar)`  L38
### `com.gku.actioncam.widget.controller.YunqiPlayerControlView$ViewHolder`
L259 · [class] public static final ViewHolder · `com/gku/actioncam/widget/controller/YunqiPlayerControlView.java`

字段/常量（4）：
- `ImageView video_opera_orientation`  L260
- `ImageView video_opera_play`  L261
- `AppCompatSeekBar video_opera_seek`  L262
- `TextView video_opera_time`  L263

方法（1）：
- `public ViewHolder(View view)`  L265
### `com.gku.actioncam.widget.MediaController`
L25 · [class] public MediaController · extends `FrameLayout` · `com/gku/actioncam/widget/MediaController.java`

字段/常量（50）：
- `int FADE_OUT = 1`  L26
- `int SHOW_PROGRESS = 2`  L27
- `String TAG = "MediaController"`  L28
- `int sDefaultTimeout = 3000`  L29
- `Runnable lastRunnable`  L30
- `AudioManager mAM`  L31
- `View mAnchor`  L32
- `int mAnimStyle`  L33
- `Context mContext`  L34
- `TextView mCurrentTime`  L35
- `boolean mDragging`  L36
- `long mDuration`  L37
- `TextView mEndTime`  L38
- `TextView mFileName`  L39
- `boolean mFromXml`  L40
- `Handler mHandler`  L41
- `OnHiddenListener mHiddenListener`  L42
- `OutlineTextView mInfoView`  L43
- `boolean mInstantSeeking`  L44
- `ImageButton mPauseButton`  L45
- `View.OnClickListener mPauseListener`  L46
- `MediaPlayerControl mPlayer`  L47
- `ProgressBar mProgress`  L48
- `View mRoot`  L49
- `SeekBar.OnSeekBarChangeListener mSeekListener`  L50
- `boolean mShowing`  L51
- `OnShownListener mShownListener`  L52
- `String mTitle`  L53
- `PopupWindow mWindow`  L54
- `int i = msg.what`  L93
- `int i = msg.what`  L183
- `View view = this.mRoot`  L276
- `TextView textView = this.mFileName`  L348
- `View view`  L373
- `ImageButton imageButton = this.mPauseButton`  L376
- `int[] iArr = new int[2]`  L384
- `int i = iArr[0]`  L386
- `OnShownListener onShownListener = this.mShownListener`  L392
- `Handler handler = this.mHandler`  L401
- `OnHiddenListener onHiddenListener = this.mHiddenListener`  L424
- `MediaPlayerControl mediaPlayerControl = this.mPlayer`  L441
- `ProgressBar progressBar = this.mProgress`  L447
- `long j = duration`  L454
- `TextView textView = this.mEndTime`  L456
- `TextView textView2 = this.mCurrentTime`  L460
- `int i2 = i % 60`  L470
- `int i4 = i / 3600`  L472
- `ImageButton imageButton = this.mPauseButton`  L497
- `ImageButton imageButton = this.mPauseButton`  L542
- `ProgressBar progressBar = this.mProgress`  L546

方法（40）：
- `public MediaController(Context context, AttributeSet attrs)`  L86
- `void handleMessage(Message msg)`  L92 @Override
- `void onClick(View v)`  L111 @Override
- `void onStartTrackingTouch(SeekBar bar)`  L118 @Override
- `void onProgressChanged(SeekBar bar, int progress, boolean fromuser)`  L132 @Override
- `void run()`  L140 @Override
- `void onStopTrackingTouch(SeekBar bar)`  L156 @Override
- `public MediaController(Context context)`  L176
- `void handleMessage(Message msg)`  L182 @Override
- `void onClick(View v)`  L201 @Override
- `void onStartTrackingTouch(SeekBar bar)`  L208 @Override
- `void onProgressChanged(SeekBar bar, int progress, boolean fromuser)`  L222 @Override
- `void run()`  L230 @Override
- `void onStopTrackingTouch(SeekBar bar)`  L246 @Override
- `boolean initController(Context context)`  L267
    - 体内字面量："audio"
- `void onFinishInflate()`  L274 @Override
- `void initFloatingWindow()`  L282
- `void setAnchorView(View view)`  L291
- `View makeControllerView()`  L304
    - 体内字面量："layout_inflater"
- `void initControllerView(View v)`  L308
- `void setMediaPlayer(MediaPlayerControl player)`  L333
- `void setInstantSeeking(boolean seekWhenDragging)`  L338
- `void show()`  L342
- `void setFileName(String name)`  L346
- `void setInfoView(OutlineTextView v)`  L354
- `void disableUnsupportedButtons()`  L358
- `void setAnimationStyle(int animationStyle)`  L368
- `void show(int timeout)`  L372
- `boolean isShowing()`  L406
- `void hide()`  L410
    - 体内字面量："MediaController already removed"
- `void setOnShownListener(OnShownListener l)`  L431
- `void setOnHiddenListener(OnHiddenListener l)`  L435
- `long setProgress()`  L440
- `String generateTime(long position)`  L468
- `boolean onTouchEvent(MotionEvent event)`  L480 @Override
- `boolean onTrackballEvent(MotionEvent ev)`  L486 @Override
- `boolean dispatchKeyEvent(KeyEvent event)`  L492 @Override
- `void updatePausePlay()`  L519
- `void doPauseResume()`  L531
- `void setEnabled(boolean enabled)`  L541 @Override
### `com.gku.actioncam.widget.MediaController$MediaPlayerControl`
L56 · [interface] public MediaPlayerControl · `com/gku/actioncam/widget/MediaController.java`

方法（10）：
- `boolean canPause()`  L57
- `boolean canSeekBackward()`  L59
- `boolean canSeekForward()`  L61
- `int getBufferPercentage()`  L63
- `int getCurrentPosition()`  L65
- `int getDuration()`  L67
- `boolean isPlaying()`  L69
- `void pause()`  L71
- `void seekTo(long pos)`  L73
- `void start()`  L75
### `com.gku.actioncam.widget.MediaController$OnHiddenListener`
L78 · [interface] public OnHiddenListener · `com/gku/actioncam/widget/MediaController.java`

方法（1）：
- `void onHidden()`  L79
### `com.gku.actioncam.widget.MediaController$OnShownListener`
L82 · [interface] public OnShownListener · `com/gku/actioncam/widget/MediaController.java`

方法（1）：
- `void onShown()`  L83
### `com.gku.actioncam.widget.OutlineTextView`
L15 · [class] public OutlineTextView · extends `AppCompatTextView` · `com/gku/actioncam/widget/OutlineTextView.java`

字段/常量（10）：
- `int mAscent`  L16
- `int mBorderColor`  L17
- `float mBorderSize`  L18
- `int mColor`  L19
- `boolean mIncludePad`  L20
- `float mSpacingAdd`  L21
- `float mSpacingMult`  L22
- `String mText`  L23
- `TextPaint mTextPaint`  L24
- `TextPaint mTextPaintOutline`  L25

方法（14）：
- `public OutlineTextView(Context context)`  L27
- `public OutlineTextView(Context context, AttributeSet attrs)`  L37
- `public OutlineTextView(Context context, AttributeSet attrs, int defStyle)`  L47
- `void initPaint()`  L57
- `void setText(String text)`  L75
- `void setTextSize(float size)`  L83 @Override
- `void setTextColor(int color)`  L91 @Override
- `void setShadowLayer(float radius, float dx, float dy, int color)`  L99 @Override
- `void setTypeface(Typeface tf, int style)`  L109 @Override
- `void setTypeface(Typeface tf)`  L117 @Override
- `void onDraw(Canvas canvas)`  L125 @Override
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L131 @Override
- `int measureWidth(int measureSpec)`  L137
- `int measureHeight(int measureSpec)`  L147
### `com.gku.actioncam.widget.ScreenResolution`
L10 · [class] public ScreenResolution · `com/gku/actioncam/widget/ScreenResolution.java`

方法（3）：
- `Pair<Integer, Integer> getResolution(Context ctx)`  L11
- `Pair<Integer, Integer> getRealResolutionOnOldDevice(Context ctx)`  L15
    - 体内字面量："window" · "getRawWidth" · "getRawHeight"
- `Pair<Integer, Integer> getRealResolution(Context ctx)`  L25
    - 体内字面量："window"
### `com.gku.actioncam.widget.SimpleCameraScan`
L37 · [class] public SimpleCameraScan · extends `CameraScan<T>` · `com/gku/actioncam/widget/SimpleCameraScan.java`

字段/常量（43）：
- `int HOVER_TAP_SLOP = 20`  L38
- `int HOVER_TAP_TIMEOUT = 150`  L39
- `float ZOOM_STEP_SIZE = 0.1f`  L40
- `View flashlightView`  L41
- `boolean isAnalyze`  L42
- `boolean isAnalyzeResult`  L43
- `boolean isAutoStopAnalyze`  L44
- `boolean isClickTap`  L45
- `AmbientLightManager mAmbientLightManager`  L46
- `Analyzer<T> mAnalyzer`  L47
- `BeepManager mBeepManager`  L48
- `Camera mCamera`  L49
- `CameraConfig mCameraConfig`  L50
- `ListenableFuture<ProcessCameraProvider> mCameraProviderFuture`  L51
- `Context mContext`  L52
- `float mDownX`  L53
- `float mDownY`  L54
- `long mLastHoveTapTime`  L55
- `LifecycleOwner mLifecycleOwner`  L56
- `Analyzer.OnAnalyzeListener<T> mOnAnalyzeListener`  L57
- `ScaleGestureDetector.OnScaleGestureListener mOnScaleGestureListener`  L58
- `CameraScan.OnScanResultCallback<T> mOnScanResultCallback`  L59
- `PreviewView mPreviewView`  L60
- `MutableLiveData<AnalyzeResult<T>> mResultLiveData`  L61
- `CameraScan.OnScanResultCallback<T> onScanResultCallback = this.mOnScanResultCallback`  L131
- `float f = aX - bX`  L171
- `float f2 = aY - bY`  L172
- `Analyzer<T> analyzer`  L256
- `BeepManager beepManager = this.mBeepManager`  L269
- `CameraScan.OnScanResultCallback<T> onScanResultCallback = this.mOnScanResultCallback`  L273
- `ListenableFuture<ProcessCameraProvider> listenableFuture = this.mCameraProviderFuture`  L283
- `Camera camera = this.mCamera`  L366
- `Integer value`  L382
- `Camera camera = this.mCamera`  L383
- `Camera camera = this.mCamera`  L389
- `BeepManager beepManager = this.mBeepManager`  L398
- `BeepManager beepManager = this.mBeepManager`  L407
- `Camera camera = this.mCamera`  L427
- `AmbientLightManager ambientLightManager = this.mAmbientLightManager`  L438
- `BeepManager beepManager = this.mBeepManager`  L442
- `AmbientLightManager ambientLightManager = this.mAmbientLightManager`  L452
- `AmbientLightManager ambientLightManager = this.mAmbientLightManager`  L461
- `AmbientLightManager ambientLightManager = this.mAmbientLightManager`  L470

方法（46）：
- `public SimpleCameraScan(ComponentActivity activity, PreviewView previewView)`  L63
- `public SimpleCameraScan(Fragment fragment, PreviewView previewView)`  L67
- `public SimpleCameraScan(Context context, LifecycleOwner lifecycleOwner, PreviewView previewView)`  L71
- `boolean onScale(ScaleGestureDetector detector)`  L76 @Override
- `void initData()`  L92
- `void onChanged(Object obj)`  L97 @Override
- `void onSuccess(AnalyzeResult<T> result)`  L103 @Override
- `void onFailure(Exception e)`  L108 @Override
- `boolean onTouch(View view, MotionEvent motionEvent)`  L115 @Override
- `void lambda$initData$0(AnalyzeResult analyzeResult)`  L126
- `boolean lambda$initData$1(ScaleGestureDetector scaleGestureDetector, View view, MotionEvent motionEvent)`  L138
- `void handlePreviewViewClickTap(MotionEvent event)`  L146
- `float distance(float aX, float aY, float bX, float bY)`  L170
- `void startFocusAndMetering(float x, float y)`  L176
    - 体内字面量："startFocusAndMetering: %f, %f"
- `CameraScan<T> setCameraConfig(CameraConfig cameraConfig)`  L187 @Override
- `void startCamera()`  L195 @Override
- `void run()`  L203 @Override
- `void lambda$startCamera$3()`  L210
- `void analyze(ImageProxy imageProxy)`  L218 @Override
- `Size getDefaultTargetResolution()`  L223 @Override
- `int getTargetCoordinateSystem()`  L228 @Override
- `void updateTransform(Matrix matrix)`  L233 @Override
    - 体内字面量："Preview resolution: " · "ImageAnalysis resolution: "
- `void lambda$startCamera$2(ImageProxy imageProxy)`  L255
- `void handleAnalyzeResult(AnalyzeResult<T> result)`  L263
- `void stopCamera()`  L282 @Override
- `CameraScan<T> setAnalyzeImage(boolean analyze)`  L294 @Override
- `CameraScan<T> setAutoStopAnalyze(boolean autoStopAnalyze)`  L300 @Override
- `CameraScan<T> setAnalyzer(Analyzer<T> analyzer)`  L306 @Override
- `void zoomIn()`  L312 @Override
- `void zoomOut()`  L323 @Override
- `void zoomTo(float ratio)`  L334 @Override
- `void lineZoomIn()`  L343 @Override
- `void lineZoomOut()`  L354 @Override
- `void lineZoomTo(float linearZoom)`  L365 @Override
- `void enableTorch(boolean torch)`  L373 @Override
- `boolean isTorchEnabled()`  L381 @Override
- `boolean hasFlashUnit()`  L388 @Override
- `CameraScan<T> setVibrate(boolean vibrate)`  L397 @Override
- `CameraScan<T> setPlayBeep(boolean playBeep)`  L406 @Override
- `CameraScan<T> setOnScanResultCallback(CameraScan.OnScanResultCallback<T> callback)`  L415 @Override
- `Camera getCamera()`  L421 @Override
- `ZoomState getZoomState()`  L426
- `void release()`  L435 @Override
- `CameraScan<T> bindFlashlightView(View flashlightView)`  L450 @Override
- `CameraScan<T> setDarkLightLux(float lightLux)`  L460 @Override
- `CameraScan<T> setBrightLightLux(float lightLux)`  L469 @Override
### `com.gku.actioncam.widget.SwitchImageView`
L16 · [class] public final SwitchImageView · extends `AppCompatImageView implements Checkable` · implements `Checkable` · `com/gku/actioncam/widget/SwitchImageView.java`
注解：

字段/常量（4）：
- `int iconOffResId`  L17
- `int iconOnResId`  L18
- `int i`  L60
- `int i2 = this.iconOnResId`  L62

方法（7）：
- `public SwitchImageView(Context context)`  L21
    - 体内字面量："context"
- `public SwitchImageView(Context context, AttributeSet attributeSet)`  L27
    - 体内字面量："context"
- ` SwitchImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L32
- `public SwitchImageView(Context context, AttributeSet attributeSet, int i)`  L37
    - 体内字面量："context" · "obtainStyledAttributes(...)"
- `boolean isChecked()`  L49 @Override
- `void toggle()`  L54 @Override
- `void setChecked(boolean checked)`  L59 @Override
### `com.gku.actioncam.widget.VideoTextureView`
L22 · [class] public VideoTextureView · extends `TextureView implements TextureView.SurfaceTextureListener, MediaController.MediaPlayerControl` · implements `TextureView.SurfaceTextureListener, MediaController.MediaPlayerControl` · `com/gku/actioncam/widget/VideoTextureView.java`

字段/常量（80）：
- `int STATE_ERROR = -1`  L23
- `int STATE_IDLE = 0`  L24
- `int STATE_PAUSED = 4`  L25
- `int STATE_PLAYBACK_COMPLETED = 5`  L26
- `int STATE_PLAYING = 3`  L27
- `int STATE_PREPARED = 2`  L28
- `int STATE_PREPARING = 1`  L29
- `int STATE_RESUME = 7`  L30
- `int STATE_SUSPEND = 6`  L31
- `int STATE_SUSPEND_UNSUPPORTED = 8`  L32
- `String TAG = "VideoTextureView"`  L33
- `int VIDEO_LAYOUT_ORIGIN = 0`  L34
- `int VIDEO_LAYOUT_SCALE = 1`  L35
- `int VIDEO_LAYOUT_STRETCH = 2`  L36
- `int VIDEO_LAYOUT_ZOOM = 3`  L37
- `String flipValue`  L38
- `boolean hasPrepared`  L39
- `boolean hasSizeChange`  L40
- `IMediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener`  L41
- `boolean mCanPause`  L42
- `boolean mCanSeekBack`  L43
- `boolean mCanSeekForward`  L44
- `IMediaPlayer.OnCompletionListener mCompletionListener`  L45
- `Context mContext`  L46
- `int mCurrentBufferPercentage`  L47
- `int mCurrentState`  L48
- `long mDuration`  L49
- `IMediaPlayer.OnErrorListener mErrorListener`  L50
- `IMediaPlayer.OnInfoListener mInfoListener`  L51
- `View mMediaBufferingIndicator`  L52
- `MediaController mMediaController`  L53
- `IMediaPlayer mMediaPlayer`  L54
- `IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener`  L55
- `IMediaPlayer.OnCompletionListener mOnCompletionListener`  L56
- `IMediaPlayer.OnErrorListener mOnErrorListener`  L57
- `IMediaPlayer.OnInfoListener mOnInfoListener`  L58
- `IMediaPlayer.OnPreparedListener mOnPreparedListener`  L59
- `IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener`  L60
- `IMediaPlayer.OnPreparedListener mPreparedListener`  L61
- `IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener`  L62
- `long mSeekWhenPrepared`  L63
- `IMediaPlayer.OnVideoSizeChangedListener mSizeChangedListener`  L64
- `int mSurfaceHeight`  L65
- `Surface mSurfaceHolder`  L66
- `int mSurfaceWidth`  L67
- `int mTargetState`  L68
- `Uri mUri`  L69
- `String mUserAgent`  L70
- `int mVideoHeight`  L71
- `int mVideoLayout`  L72
- `int mVideoSarDen`  L73
- `int mVideoSarNum`  L74
- `int mVideoWidth`  L75
- `long j = VideoTextureView.this.mSeekWhenPrepared`  L132
- `VideoTextureView videoTextureView = VideoTextureView.this`  L150
- `long j = VideoTextureView.this.mSeekWhenPrepared`  L303
- `VideoTextureView videoTextureView = VideoTextureView.this`  L321
- `IMediaPlayer iMediaPlayer = this.mMediaPlayer`  L438
- `IMediaPlayer iMediaPlayer = this.mMediaPlayer`  L453
- `Surface surface2 = this.mSurfaceHolder`  L471
- `MediaController mediaController = this.mMediaController`  L475
- `MediaController mediaController = this.mMediaController`  L489
- `long duration`  L520
- `long j = this.mDuration`  L522
- `IjkMediaPlayer ijkMediaPlayer`  L607
- `Uri uri = this.mUri`  L658
- `IMediaPlayer iMediaPlayer = this.mMediaPlayer`  L676
- `MediaController mediaController`  L689
- `String str`  L690
- `Uri uri = this.mUri`  L697
- `int i`  L710
- `float f = iIntValue`  L716
- `float f2 = iIntValue2`  L717
- `float f3 = f / f2`  L718
- `int i2 = this.mVideoSarNum`  L719
- `int i3 = this.mVideoSarDen`  L720
- `int i4 = this.mVideoHeight`  L721
- `float f4 = i / i4`  L725
- `boolean z = layout == 2`  L738
- `int i`  L771

方法（48）：
- `void onSurfaceTextureUpdated(SurfaceTexture surface)`  L78 @Override
- `void setOnErrorListener(IMediaPlayer.OnErrorListener mOnErrorListener)`  L81
- `void setOnCompletionListener(IMediaPlayer.OnCompletionListener mOnCompletionListener)`  L85
- `public VideoTextureView(Context context)`  L89
    - 体内字面量："0Â°"
- `void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sarNum, int sarDen)`  L104 @Override
    - 体内字面量："onVideoSizeChanged: (%dx%d)"
- `void onPrepared(IMediaPlayer mp)`  L118 @Override
    - 体内字面量："initIjkVideoView onPrepared"
- `void onCompletion(IMediaPlayer mp)`  L179 @Override
    - 体内字面量："onCompletion"
- `boolean onError(IMediaPlayer mp, int framework_err, int impl_err)`  L193 @Override
    - 体内字面量："Error: %d, %d"
- `void onBufferingUpdate(IMediaPlayer mp, int percent)`  L209 @Override
- `boolean onInfo(IMediaPlayer mp, int what, int extra)`  L218 @Override
- `void onSeekComplete(IMediaPlayer mp)`  L242 @Override
    - 体内字面量："onSeekComplete"
- `public VideoTextureView(Context context, AttributeSet attrs)`  L252
- `public VideoTextureView(Context context, AttributeSet attrs, int defStyleAttr)`  L256
- `public VideoTextureView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)`  L260
    - 体内字面量："0Â°"
- `void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sarNum, int sarDen)`  L275 @Override
    - 体内字面量："onVideoSizeChanged: (%dx%d)"
- `void onPrepared(IMediaPlayer mp)`  L289 @Override
    - 体内字面量："initIjkVideoView onPrepared"
- `void onCompletion(IMediaPlayer mp)`  L350 @Override
    - 体内字面量："onCompletion"
- `boolean onError(IMediaPlayer mp, int framework_err, int impl_err)`  L364 @Override
    - 体内字面量："Error: %d, %d"
- `void onBufferingUpdate(IMediaPlayer mp, int percent)`  L380 @Override
- `boolean onInfo(IMediaPlayer mp, int what, int extra)`  L389 @Override
- `void onSeekComplete(IMediaPlayer mp)`  L413 @Override
    - 体内字面量："onSeekComplete"
- `void setVideoPath(String path, boolean isAmba, String flipValue)`  L423
- `void setVideoURI(Uri uri, boolean isAmba)`  L429
- `void stopPlayback()`  L437
- `void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height)`  L449 @Override
    - 体内字面量："initIjkVideoView" · "onSurfaceTextureAvailable"
- `void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height)`  L462 @Override
- `boolean onSurfaceTextureDestroyed(SurfaceTexture surface)`  L468 @Override
    - 体内字面量："initIjkVideoView" · "onSurfaceTextureDestroyed"
- `void onDetachedFromWindow()`  L487 @Override
- `void start()`  L499 @Override
    - 体内字面量：" =========VideoTextureView mMediaPlayer.start()" · " =========VideoTextureView  start()"
- `void pause()`  L510 @Override
- `int getDuration()`  L519 @Override
- `int getCurrentPosition()`  L536 @Override
- `void seekTo(long pos)`  L544 @Override
- `boolean isPlaying()`  L554 @Override
- `int getBufferPercentage()`  L559 @Override
- `boolean canPause()`  L567 @Override
- `boolean canSeekBackward()`  L572 @Override
- `boolean canSeekForward()`  L577 @Override
- `int getVideoWidth()`  L581
- `int getVideoHeight()`  L585
- `void initVideoView(Context ctx)`  L589
- `void openVideo(boolean isAmba)`  L606
- `void release(boolean cleartargetstate)`  L675
- `void attachMediaController()`  L688
- `void setVideoLayout(int layout)`  L709
- `void setNewLp(ViewGroup.LayoutParams lp, int windowWidth)`  L761
- `void setOnInfoListener(IMediaPlayer.OnInfoListener l)`  L766
- `boolean isInPlaybackState()`  L770
### `com.gku.actioncam.widget.VideoView`
L26 · [class] public VideoView · extends `SurfaceView implements MediaController.MediaPlayerControl` · implements `MediaController.MediaPlayerControl` · `com/gku/actioncam/widget/VideoView.java`

字段/常量（88）：
- `int STATE_ERROR = -1`  L27
- `int STATE_IDLE = 0`  L28
- `int STATE_PAUSED = 4`  L29
- `int STATE_PLAYBACK_COMPLETED = 5`  L30
- `int STATE_PLAYING = 3`  L31
- `int STATE_PREPARED = 2`  L32
- `int STATE_PREPARING = 1`  L33
- `int STATE_RESUME = 7`  L34
- `int STATE_SUSPEND = 6`  L35
- `int STATE_SUSPEND_UNSUPPORTED = 8`  L36
- `String TAG = "com.gku.actioncam.widget.VideoView"`  L37
- `int VIDEO_LAYOUT_ORIGIN = 0`  L38
- `int VIDEO_LAYOUT_SCALE = 1`  L39
- `int VIDEO_LAYOUT_STRETCH = 2`  L40
- `int VIDEO_LAYOUT_ZOOM = 3`  L41
- `String flipValue`  L42
- `IMediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener`  L43
- `boolean mCanPause`  L44
- `boolean mCanSeekBack`  L45
- `boolean mCanSeekForward`  L46
- `IMediaPlayer.OnCompletionListener mCompletionListener`  L47
- `Context mContext`  L48
- `int mCurrentBufferPercentage`  L49
- `int mCurrentState`  L50
- `long mDuration`  L51
- `IMediaPlayer.OnErrorListener mErrorListener`  L52
- `IMediaPlayer.OnInfoListener mInfoListener`  L53
- `View mMediaBufferingIndicator`  L54
- `MediaController mMediaController`  L55
- `IMediaPlayer mMediaPlayer`  L56
- `IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener`  L57
- `IMediaPlayer.OnCompletionListener mOnCompletionListener`  L58
- `IMediaPlayer.OnErrorListener mOnErrorListener`  L59
- `IMediaPlayer.OnInfoListener mOnInfoListener`  L60
- `IMediaPlayer.OnPreparedListener mOnPreparedListener`  L61
- `IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener`  L62
- `IMediaPlayer.OnPreparedListener mPreparedListener`  L63
- `SurfaceHolder.Callback mSHCallback`  L64
- `IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener`  L65
- `long mSeekWhenPrepared`  L66
- `IMediaPlayer.OnVideoSizeChangedListener mSizeChangedListener`  L67
- `int mSurfaceHeight`  L68
- `SurfaceHolder mSurfaceHolder`  L69
- `int mSurfaceWidth`  L70
- `int mTargetState`  L71
- `Uri mUri`  L72
- `String mUserAgent`  L73
- `int mVideoHeight`  L74
- `int mVideoLayout`  L75
- `int mVideoSarDen`  L76
- `int mVideoSarNum`  L77
- `int mVideoWidth`  L78
- `VideoView videoView = VideoView.this`  L100
- `long j = VideoView.this.mSeekWhenPrepared`  L118
- `VideoView videoView = VideoView.this`  L123
- `boolean z = VideoView.this.mTargetState == 3`  L229
- `boolean z2 = VideoView.this.mVideoWidth == w && VideoView.this.mVideoHeight == h`  L230
- `VideoView videoView = VideoView.this`  L233
- `VideoView videoView = VideoView.this`  L296
- `long j = VideoView.this.mSeekWhenPrepared`  L314
- `VideoView videoView = VideoView.this`  L319
- `boolean z = VideoView.this.mTargetState == 3`  L425
- `boolean z2 = VideoView.this.mVideoWidth == w && VideoView.this.mVideoHeight == h`  L426
- `VideoView videoView = VideoView.this`  L429
- `int i`  L474
- `float f = iIntValue`  L481
- `float f2 = iIntValue2`  L482
- `float f3 = f / f2`  L483
- `int i2 = this.mVideoSarNum`  L484
- `int i3 = this.mVideoSarDen`  L485
- `int i4 = this.mVideoHeight`  L486
- `float f4 = i / i4`  L490
- `boolean z = layout == 2`  L503
- `SurfaceHolder surfaceHolder = this.mSurfaceHolder`  L534
- `IMediaPlayer iMediaPlayer = this.mMediaPlayer`  L572
- `IjkMediaPlayer ijkMediaPlayer`  L584
- `Uri uri = this.mUri`  L636
- `IjkMediaPlayer ijkMediaPlayer`  L654
- `Uri uri = this.mUri`  L715
- `MediaController mediaController = this.mMediaController`  L733
- `View view = this.mMediaBufferingIndicator`  L742
- `MediaController mediaController`  L750
- `String str`  L751
- `Uri uri = this.mUri`  L758
- `IMediaPlayer iMediaPlayer = this.mMediaPlayer`  L796
- `long duration`  L884
- `long j = this.mDuration`  L886
- `int i`  L939

方法（64）：
- `public VideoView(Context context)`  L80
    - 体内字面量："0Â°"
- `void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sarNum, int sarDen)`  L93 @Override
    - 体内字面量："onVideoSizeChanged: (%dx%d)"
- `void onPrepared(IMediaPlayer mp)`  L106 @Override
    - 体内字面量："onPrepared"
- `void onCompletion(IMediaPlayer mp)`  L152 @Override
    - 体内字面量："onCompletion"
- `boolean onError(IMediaPlayer mp, int framework_err, int impl_err)`  L166 @Override
    - 体内字面量："Error: %d, %d"
- `void onBufferingUpdate(IMediaPlayer mp, int percent)`  L182 @Override
- `boolean onInfo(IMediaPlayer mp, int what, int extra)`  L191 @Override
    - 体内字面量："onInfo: (%d, %d)" · "onInfo: (MEDIA_INFO_BUFFERING_START)" · "onInfo: (MEDIA_INFO_BUFFERING_END)"
- `void onSeekComplete(IMediaPlayer mp)`  L213 @Override
    - 体内字面量："onSeekComplete"
- `void surfaceChanged(SurfaceHolder holder, int format, int w, int h)`  L222 @Override
- `void surfaceCreated(SurfaceHolder holder)`  L247 @Override
    - 体内字面量："mUriââ"
- `void surfaceDestroyed(SurfaceHolder holder)`  L259 @Override
- `public VideoView(Context context, AttributeSet attrs)`  L272
- `public VideoView(Context context, AttributeSet attrs, int defStyle)`  L276
    - 体内字面量："0Â°"
- `void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sarNum, int sarDen)`  L289 @Override
    - 体内字面量："onVideoSizeChanged: (%dx%d)"
- `void onPrepared(IMediaPlayer mp)`  L302 @Override
    - 体内字面量："onPrepared"
- `void onCompletion(IMediaPlayer mp)`  L348 @Override
    - 体内字面量："onCompletion"
- `boolean onError(IMediaPlayer mp, int framework_err, int impl_err)`  L362 @Override
    - 体内字面量："Error: %d, %d"
- `void onBufferingUpdate(IMediaPlayer mp, int percent)`  L378 @Override
- `boolean onInfo(IMediaPlayer mp, int what, int extra)`  L387 @Override
    - 体内字面量："onInfo: (%d, %d)" · "onInfo: (MEDIA_INFO_BUFFERING_START)" · "onInfo: (MEDIA_INFO_BUFFERING_END)"
- `void onSeekComplete(IMediaPlayer mp)`  L409 @Override
    - 体内字面量："onSeekComplete"
- `void surfaceChanged(SurfaceHolder holder, int format, int w, int h)`  L418 @Override
- `void surfaceCreated(SurfaceHolder holder)`  L443 @Override
    - 体内字面量："mUriââ"
- `void surfaceDestroyed(SurfaceHolder holder)`  L455 @Override
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L469 @Override
- `void setVideoLayout(int layout)`  L473
- `void initVideoView(Context ctx)`  L516
- `boolean isValid()`  L533
- `void setVideoPath(String path)`  L538
- `void setVideoPath(String path, String resolution, boolean isAmba)`  L542
- `void setVideoPath(String path, String resolution, boolean isAmba, String flipValue)`  L546
- `void setVideoURI(Uri uri)`  L551
- `void setVideoURI(Uri uri, String resolution, boolean isAmba)`  L559
- `void setUserAgent(String ua)`  L567
- `void stopPlayback()`  L571
- `void openVideo()`  L583
- `void openVideo(String resolution, boolean isAmba)`  L653
- `void setMediaController(MediaController controller)`  L732
- `void setMediaBufferingIndicator(View mediaBufferingIndicator)`  L741
- `void attachMediaController()`  L749
- `void setOnPreparedListener(IMediaPlayer.OnPreparedListener l)`  L770
- `void setOnCompletionListener(IMediaPlayer.OnCompletionListener l)`  L774
- `void setOnErrorListener(IMediaPlayer.OnErrorListener l)`  L778
- `void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener l)`  L782
- `void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener l)`  L786
- `void setOnInfoListener(IMediaPlayer.OnInfoListener l)`  L790
- `void release(boolean cleartargetstate)`  L795
- `boolean onTouchEvent(MotionEvent ev)`  L809 @Override
- `boolean onTrackballEvent(MotionEvent ev)`  L818 @Override
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L827 @Override
- `void toggleMediaControlsVisiblity()`  L850
- `void start()`  L859 @Override
- `void pause()`  L868 @Override
- `void resume()`  L876
- `int getDuration()`  L883 @Override
- `int getCurrentPosition()`  L900 @Override
- `void seekTo(long msec)`  L908 @Override
- `boolean isPlaying()`  L918 @Override
- `int getBufferPercentage()`  L923 @Override
- `int getVideoWidth()`  L930
- `int getVideoHeight()`  L934
- `boolean isInPlaybackState()`  L938
- `boolean canPause()`  L944 @Override
- `boolean canSeekBackward()`  L949 @Override
- `boolean canSeekForward()`  L954 @Override