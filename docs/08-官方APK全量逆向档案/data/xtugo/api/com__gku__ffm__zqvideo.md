# XTU GO — 类与成员明细：com.gku.ffm.zqvideo

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 93 个文件 / 102 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.ffm.zqvideo.builder.GSYVideoOptionBuilder`
L18 · [class] public GSYVideoOptionBuilder · `com/gku/ffm/zqvideo/builder/GSYVideoOptionBuilder.java`

字段/常量（64）：
- `Drawable mBottomProgressDrawable`  L19
- `Drawable mBottomShowProgressDrawable`  L20
- `Drawable mBottomShowProgressThumbDrawable`  L21
- `File mCachePath`  L22
- `boolean mCacheWithPlay`  L23
- `Drawable mDialogProgressBarDrawable`  L24
- `GSYStateUiListener mGSYStateUiListener`  L25
- `GSYVideoProgressListener mGSYVideoProgressListener`  L26
- `LockClickListener mLockClickListener`  L27
- `Map<String, String> mMapHeadData`  L28
- `boolean mNeedLockFull`  L29
- `String mOverrideExtension`  L30
- `boolean mSounchTouch`  L31
- `View mThumbImageView`  L32
- `boolean mThumbPlay`  L33
- `String mUrl`  L34
- `VideoAllCallBack mVideoAllCallBack`  L35
- `Drawable mVolumeProgressDrawable`  L36
- `int mShrinkImageRes = -1`  L37
- `int mEnlargeImageRes = -1`  L38
- `int mPlayPosition = -22`  L39
- `int mDialogProgressHighLightColor = -11`  L40
- `int mDialogProgressNormalColor = -11`  L41
- `int mDismissControlTime = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS`  L42
- `long mSeekOnStart = -1`  L43
- `float mSeekRatio = 1.0f`  L44
- `float mSpeed = 1.0f`  L45
- `boolean mHideKey = true`  L46
- `boolean mShowFullAnimation = true`  L47
- `boolean mAutoFullWithSize = false`  L48
- `boolean mNeedShowWifiTip = true`  L49
- `boolean mRotateViewAuto = true`  L50
- `boolean mLockLand = false`  L51
- `boolean mLooping = false`  L52
- `boolean mIsTouchWiget = true`  L53
- `boolean mIsTouchWigetFull = true`  L54
- `boolean mShowPauseCover = true`  L55
- `boolean mRotateWithSystem = true`  L56
- `boolean mSurfaceErrorPlay = true`  L57
- `boolean mSetUpLazy = false`  L58
- `boolean mStartAfterPrepared = true`  L59
- `boolean mReleaseWhenLossAudio = true`  L60
- `boolean mActionBar = false`  L61
- `boolean mStatusBar = false`  L62
- `boolean isShowDragProgressTextOnSeekBar = false`  L63
- `String mPlayTag = "<binary/metadata>"`  L64
- `String mVideoTitle = null`  L65
- `boolean mIsOnlyRotateLand = false`  L66
- `boolean mNeedOrientationUtils = true`  L68
- `int i`  L317
- `Drawable drawable`  L318
- `Drawable drawable2 = this.mBottomShowProgressDrawable`  L319
- `Drawable drawable3 = this.mBottomProgressDrawable`  L323
- `Drawable drawable4 = this.mVolumeProgressDrawable`  L327
- `Drawable drawable5 = this.mDialogProgressBarDrawable`  L331
- `int i2 = this.mDialogProgressHighLightColor`  L335
- `View view = this.mThumbImageView`  L346
- `LockClickListener lockClickListener = this.mLockClickListener`  L351
- `long j = this.mSeekOnStart`  L356
- `VideoAllCallBack videoAllCallBack = this.mVideoAllCallBack`  L364
- `GSYVideoProgressListener gSYVideoProgressListener = this.mGSYVideoProgressListener`  L368
- `GSYStateUiListener gSYStateUiListener = this.mGSYStateUiListener`  L372
- `int i = this.mEnlargeImageRes`  L392
- `int i2 = this.mShrinkImageRes`  L396

方法（50）：
- `GSYVideoOptionBuilder setAutoFullWithSize(boolean z)`  L70
- `GSYVideoOptionBuilder setShowFullAnimation(boolean z)`  L75
- `GSYVideoOptionBuilder setLooping(boolean z)`  L80
- `GSYVideoOptionBuilder setVideoAllCallBack(VideoAllCallBack videoAllCallBack)`  L85
- `GSYVideoOptionBuilder setRotateViewAuto(boolean z)`  L90
- `GSYVideoOptionBuilder setLockLand(boolean z)`  L95
- `GSYVideoOptionBuilder setSpeed(float f)`  L100
- `GSYVideoOptionBuilder setSoundTouch(boolean z)`  L105
- `GSYVideoOptionBuilder setHideKey(boolean z)`  L110
- `GSYVideoOptionBuilder setIsTouchWiget(boolean z)`  L115
- `GSYVideoOptionBuilder setIsTouchWigetFull(boolean z)`  L120
- `GSYVideoOptionBuilder setNeedShowWifiTip(boolean z)`  L125
- `GSYVideoOptionBuilder setEnlargeImageRes(int i)`  L130
- `GSYVideoOptionBuilder setShrinkImageRes(int i)`  L135
- `GSYVideoOptionBuilder setShowPauseCover(boolean z)`  L140
- `GSYVideoOptionBuilder setSeekRatio(float f)`  L145
- `GSYVideoOptionBuilder setRotateWithSystem(boolean z)`  L153
- `GSYVideoOptionBuilder setPlayTag(String str)`  L158
- `GSYVideoOptionBuilder setPlayPosition(int i)`  L163
- `GSYVideoOptionBuilder setSeekOnStart(long j)`  L168
- `GSYVideoOptionBuilder setUrl(String str)`  L173
- `GSYVideoOptionBuilder setVideoTitle(String str)`  L178
- `GSYVideoOptionBuilder setCacheWithPlay(boolean z)`  L183
- `GSYVideoOptionBuilder setStartAfterPrepared(boolean z)`  L188
- `GSYVideoOptionBuilder setReleaseWhenLossAudio(boolean z)`  L193
- `GSYVideoOptionBuilder setCachePath(File file)`  L198
- `GSYVideoOptionBuilder setMapHeadData(Map<String, String> map)`  L203
- `GSYVideoOptionBuilder setSurfaceErrorPlay(boolean z)`  L208
- `GSYVideoOptionBuilder setGSYVideoProgressListener(GSYVideoProgressListener gSYVideoProgressListener)`  L213
- `GSYVideoOptionBuilder setThumbImageView(View view)`  L218
- `GSYVideoOptionBuilder setBottomShowProgressBarDrawable(Drawable drawable, Drawable drawable2)`  L223
- `GSYVideoOptionBuilder setBottomProgressBarDrawable(Drawable drawable)`  L229
- `GSYVideoOptionBuilder setDialogVolumeProgressBar(Drawable drawable)`  L234
- `GSYVideoOptionBuilder setDialogProgressBar(Drawable drawable)`  L239
- `GSYVideoOptionBuilder setDialogProgressColor(int i, int i2)`  L244
- `GSYVideoOptionBuilder setThumbPlay(boolean z)`  L250
- `GSYVideoOptionBuilder setNeedLockFull(boolean z)`  L255
- `GSYVideoOptionBuilder setLockClickListener(LockClickListener lockClickListener)`  L260
- `GSYVideoOptionBuilder setDismissControlTime(int i)`  L265
- `GSYVideoOptionBuilder setEffectFilter(GSYVideoGLView.ShaderInterface shaderInterface)`  L270
- `GSYVideoOptionBuilder setOverrideExtension(String str)`  L275
- `GSYVideoOptionBuilder setOnlyRotateLand(boolean z)`  L280
- `GSYVideoOptionBuilder setShowDragProgressTextOnSeekBar(boolean z)`  L285
- `GSYVideoOptionBuilder setSetUpLazy(boolean z)`  L291 @Deprecated
- `GSYVideoOptionBuilder setFullHideActionBar(boolean z)`  L296
- `GSYVideoOptionBuilder setFullHideStatusBar(boolean z)`  L301
- `GSYVideoOptionBuilder setGSYStateUiListener(GSYStateUiListener gSYStateUiListener)`  L306
- `GSYVideoOptionBuilder setNeedOrientationUtils(boolean z)`  L311
- `void build(StandardGSYVideoPlayer standardGSYVideoPlayer)`  L316
- `void build(GSYBaseVideoPlayer gSYBaseVideoPlayer)`  L342
### `com.gku.ffm.zqvideo.cache.CacheFactory`
L4 · [class] public CacheFactory · `com/gku/ffm/zqvideo/cache/CacheFactory.java`

字段/常量（1）：
- `Class<? extends ICacheManager> sICacheManager`  L5

方法（2）：
- `void setCacheManager(Class<? extends ICacheManager> cls)`  L7
- `ICacheManager getCacheManager()`  L11
### `com.gku.ffm.zqvideo.cache.ICacheManager`
L9 · [interface] public ICacheManager · `com/gku/ffm/zqvideo/cache/ICacheManager.java`

方法（6）：
- `boolean cachePreview(Context context, File file, String str)`  L15
- `void clearCache(Context context, File file, String str)`  L17
- `void doCacheLogic(Context context, IMediaPlayer iMediaPlayer, String str, Map<String, String> map, File file)`  L19
- `boolean hadCached()`  L21
- `void release()`  L23
- `void setCacheAvailableListener(ICacheAvailableListener iCacheAvailableListener)`  L25
### `com.gku.ffm.zqvideo.cache.ICacheManager$ICacheAvailableListener`
L11 · [interface] public ICacheAvailableListener · `com/gku/ffm/zqvideo/cache/ICacheManager.java`

方法（1）：
- `void onCacheAvailable(File file, String str, int i)`  L12
### `com.gku.ffm.zqvideo.cache.ProxyCacheManager`
L22 · [class] public ProxyCacheManager · implements `ICacheManager, CacheListener` · `com/gku/ffm/zqvideo/cache/ProxyCacheManager.java`

字段/常量（16）：
- `int DEFAULT_MAX_COUNT = -1`  L23
- `long DEFAULT_MAX_SIZE = 536870912`  L24
- `FileNameGenerator fileNameGenerator`  L25
- `ProxyCacheManager proxyCacheManager`  L26
- `ICacheManager.ICacheAvailableListener cacheAvailableListener`  L27
- `File mCacheDir`  L28
- `boolean mCacheFile`  L29
- `HttpProxyCacheServer proxy`  L30
- `TrustManager[] trustAllCerts`  L31
- `HostnameVerifier v`  L33
- `ICacheManager.ICacheAvailableListener iCacheAvailableListener = this.cacheAvailableListener`  L44
- `FileNameGenerator fileNameGenerator2 = fileNameGenerator`  L89
- `HttpProxyCacheServer httpProxyCacheServer = this.proxy`  L109
- `int i = DEFAULT_MAX_COUNT`  L144
- `FileNameGenerator fileNameGenerator2 = fileNameGenerator`  L153
- `int i = DEFAULT_MAX_COUNT`  L167

方法（19）：
- `ProxyCacheManager instance()`  L35
- `void onCacheAvailable(File file, String str, int i)`  L43 @Override
- `void doCacheLogic(Context context, IMediaPlayer iMediaPlayer, String str, Map<String, String> map, File file)`  L51 @Override
    - 体内字面量："127.0.0.1" · ".m3u8" · "rtmp" · "rtsp" · ".m3u8"
- `void clearCache(Context context, File file, String str)`  L78 @Override
- `void release()`  L108 @Override
- `boolean cachePreview(Context context, File file, String str)`  L120 @Override
- `boolean hadCached()`  L129 @Override
- `void setCacheAvailableListener(ICacheManager.ICacheAvailableListener iCacheAvailableListener)`  L134 @Override
- `HttpProxyCacheServer newProxy(Context context, File file)`  L138
- `void setProxy(HttpProxyCacheServer httpProxyCacheServer)`  L161
- `HttpProxyCacheServer newProxy(Context context)`  L165
- `HttpProxyCacheServer getProxy(Context context)`  L178
- `HttpProxyCacheServer getProxy(Context context, File file)`  L189
- `void setFileNameGenerator(FileNameGenerator fileNameGenerator2)`  L213
- `void clearFileNameGenerator()`  L217
- `HostnameVerifier getHostnameVerifier()`  L221
- `void setHostnameVerifier(HostnameVerifier hostnameVerifier)`  L225
- `TrustManager[] getTrustAllCerts()`  L229
- `void setTrustAllCerts(TrustManager[] trustManagerArr)`  L233
### `com.gku.ffm.zqvideo.cache.ProxyCacheUserAgentHeadersInjector`
L9 · [class] public ProxyCacheUserAgentHeadersInjector · implements `HeaderInjector` · `com/gku/ffm/zqvideo/cache/ProxyCacheUserAgentHeadersInjector.java`

字段/常量（1）：
- `Map<String, String> map = mMapHeadData`  L15

方法（1）：
- `Map<String, String> addHeaders(String str)`  L13 @Override
    - 体内字面量："****** proxy addHeaders ****** "
### `com.gku.ffm.zqvideo.GSYBaseActivityDetail`
L14 · [class] public abstract GSYBaseActivityDetail · extends `GSYBaseVideoPlayer> extends AppCompatActivity implements VideoAllCallBack` · implements `VideoAllCallBack` · `com/gku/ffm/zqvideo/GSYBaseActivityDetail.java`

字段/常量（9）：
- `boolean isPause`  L15
- `boolean isPlay`  L16
- `OrientationUtils orientationUtils`  L17
- `OrientationUtils orientationUtils = this.orientationUtils`  L158
- `OrientationUtils orientationUtils = this.orientationUtils`  L172
- `OrientationUtils orientationUtils = this.orientationUtils`  L183
- `OrientationUtils orientationUtils = this.orientationUtils`  L196
- `OrientationUtils orientationUtils = this.orientationUtils`  L212
- `OrientationUtils orientationUtils = this.orientationUtils`  L222

方法（41）：
- `void clickForFullScreen()`  L19
- `boolean getDetailOrientationRotateAuto()`  L21
- `GSYVideoOptionBuilder getGSYVideoOptionBuilder()`  L23
- `T getGSYVideoPlayer()`  L25
- `OrientationOption getOrientationOption()`  L27
- `boolean hideActionBarWhenFull()`  L31
- `boolean hideStatusBarWhenFull()`  L35
- `boolean isAutoFullWithSize()`  L39
- `void onAutoComplete(String str, Object... objArr)`  L44 @Override
- `void onClickBlank(String str, Object... objArr)`  L48 @Override
- `void onClickBlankFullscreen(String str, Object... objArr)`  L52 @Override
- `void onClickResume(String str, Object... objArr)`  L56 @Override
- `void onClickResumeFullscreen(String str, Object... objArr)`  L60 @Override
- `void onClickSeekbar(String str, Object... objArr)`  L64 @Override
- `void onClickSeekbarFullscreen(String str, Object... objArr)`  L68 @Override
- `void onClickStartError(String str, Object... objArr)`  L72 @Override
- `void onClickStartIcon(String str, Object... objArr)`  L76 @Override
- `void onClickStartThumb(String str, Object... objArr)`  L80 @Override
- `void onClickStop(String str, Object... objArr)`  L84 @Override
- `void onClickStopFullscreen(String str, Object... objArr)`  L88 @Override
- `void onComplete(String str, Object... objArr)`  L91
- `void onEnterFullscreen(String str, Object... objArr)`  L94
- `void onEnterSmallWidget(String str, Object... objArr)`  L98 @Override
- `void onPlayError(String str, Object... objArr)`  L102 @Override
- `void onQuitSmallWidget(String str, Object... objArr)`  L106 @Override
- `void onStartPrepared(String str, Object... objArr)`  L109
- `void onTouchScreenSeekLight(String str, Object... objArr)`  L113 @Override
- `void onTouchScreenSeekPosition(String str, Object... objArr)`  L117 @Override
- `void onTouchScreenSeekVolume(String str, Object... objArr)`  L121 @Override
- `void onCreate(Bundle bundle)`  L125 @Override
- `void initVideo()`  L129
- `void onClick(View view)`  L136 @Override
- `void initVideoBuilderMode()`  L144
- `void showFull()`  L149
- `void onBackPressed()`  L157 @Override
- `void onPause()`  L169 @Override
- `void onResume()`  L180 @Override
- `void onDestroy()`  L191 @Override
- `void onConfigurationChanged(Configuration configuration)`  L203 @Override
- `void onPrepared(String str, Object... objArr)`  L211
- `void onQuitFullscreen(String str, Object... objArr)`  L221 @Override
### `com.gku.ffm.zqvideo.GSYBaseADActivityDetail`
L15 · [class] public abstract GSYBaseADActivityDetail · extends `GSYBaseVideoPlayer, R extends GSYADVideoPlayer> extends GSYBaseActivityDetail<T>` · `com/gku/ffm/zqvideo/GSYBaseADActivityDetail.java`

字段/常量（6）：
- `OrientationUtils mADOrientationUtils`  L16
- `OrientationUtils orientationUtils = this.mADOrientationUtils`  L107
- `OrientationUtils orientationUtils = this.mADOrientationUtils`  L133
- `GSYBaseADActivityDetail<T, R> gSYBaseADActivityDetail`  L141
- `Configuration configuration2`  L142
- `boolean z = this.isPlay`  L143

方法（24）：
- `void clickForFullScreen()`  L19 @Override
- `GSYVideoOptionBuilder getGSYADVideoOptionBuilder()`  L22
- `R getGSYADVideoPlayer()`  L24
- `OrientationOption getOrientationOption()`  L27 @Override
- `boolean isNeedAdOnStart()`  L31
- `void onComplete(String str, Object... objArr)`  L34 @Override
- `void initVideo()`  L38 @Override
- `void onClick(View view)`  L46 @Override
- `void initVideoBuilderMode()`  L55 @Override
- `void onStartPrepared(String str, Object... objArr)`  L59 @Override
- `void onAutoComplete(String str, Object... objArr)`  L68 @Override
- `void onQuitFullscreen(String str, Object... objArr)`  L86 @Override
- `void showFull()`  L98 @Override
- `void onBackPressed()`  L106 @Override
- `void onPause()`  L118 @Override
- `void onResume()`  L124 @Override
- `void onDestroy()`  L130 @Override
- `void onConfigurationChanged(Configuration configuration)`  L140 @Override
- `void onStartPrepared(String str, Object... objArr)`  L158 @Override
- `void onPrepared(String str, Object... objArr)`  L163 @Override
- `void onEnterFullscreen(String str, Object... objArr)`  L171 @Override
- `boolean isADStarted()`  L176
- `void startAdPlay()`  L180
- `void showADFull()`  L189
### `com.gku.ffm.zqvideo.GSYVideoADManager`
L12 · [class] public GSYVideoADManager · extends `GSYVideoBaseManager` · `com/gku/ffm/zqvideo/GSYVideoADManager.java`

字段/常量（4）：
- `GSYVideoADManager videoManager`  L13
- `int SMALL_ID = R.id.ad_small_id`  L14
- `int FULLSCREEN_ID = R.id.ad_full_id`  L15
- `String TAG = "GSYVideoADManager"`  L16

方法（8）：
- `private GSYVideoADManager()`  L18
- `GSYVideoADManager instance()`  L22
- `boolean backFromWindowFull(Context context)`  L29
- `void releaseAllVideos()`  L40
- `void onPause()`  L47
- `void onResume()`  L53
- `void onResume(boolean z)`  L59
- `boolean isFullState(Activity activity)`  L65
### `com.gku.ffm.zqvideo.GSYVideoBaseManager`
L28 · [class] public abstract GSYVideoBaseManager · implements `IMediaPlayer.OnPreparedListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnBufferingUpdateListener, IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnVideoSizeChangedListener, IMediaPlayer.OnInfoListener, ICacheManager.ICacheAvailableListener, GSYVideoViewBridge` · `com/gku/ffm/zqvideo/GSYVideoBaseManager.java`

字段/常量（50）：
- `int BUFFER_TIME_OUT_ERROR = -192`  L29
- `int HANDLER_PREPARE = 0`  L30
- `int HANDLER_RELEASE = 2`  L31
- `int HANDLER_RELEASE_SURFACE = 3`  L32
- `int HANDLER_SETDISPLAY = 1`  L33
- `String TAG = "GSYVideoBaseManager"`  L34
- `int bufferPoint`  L35
- `ICacheManager cacheManager`  L36
- `Context context`  L37
- `WeakReference<GSYMediaPlayerListener> lastListener`  L38
- `int lastState`  L39
- `WeakReference<GSYMediaPlayerListener> listener`  L40
- `MediaHandler mMediaHandler`  L41
- `IPlayerInitSuccessListener mPlayerInitSuccessListener`  L42
- `Handler mainThreadHandler`  L43
- `boolean needTimeOutOther`  L44
- `List<VideoOptionModel> optionModelList`  L45
- `IPlayerManager playerManager`  L46
- `String playTag = "<binary/metadata>"`  L47
- `int currentVideoWidth = 0`  L48
- `int currentVideoHeight = 0`  L49
- `int playPosition = -22`  L50
- `int timeOut = 8000`  L51
- `boolean needMute = false`  L52
- `ICacheManager iCacheManager = this.cacheManager`  L73
- `WeakReference<GSYMediaPlayerListener> weakReference = this.listener`  L96
- `WeakReference<GSYMediaPlayerListener> weakReference = this.lastListener`  L105
- `IPlayerManager iPlayerManager = this.playerManager`  L132
- `int i3 = i`  L270
- `ICacheManager iCacheManager = this.cacheManager`  L356
- `IPlayerManager iPlayerManager = this.playerManager`  L370
- `IPlayerManager iPlayerManager = this.playerManager`  L384
- `IPlayerManager iPlayerManager = this.playerManager`  L393
- `IPlayerManager iPlayerManager = this.playerManager`  L406
- `IPlayerManager iPlayerManager = this.playerManager`  L414
- `IPlayerManager iPlayerManager = this.playerManager`  L422
- `IPlayerManager iPlayerManager = this.playerManager`  L430
- `IPlayerManager iPlayerManager = this.playerManager`  L439
- `IPlayerManager iPlayerManager = this.playerManager`  L448
- `IPlayerManager iPlayerManager = this.playerManager`  L457
- `IPlayerManager iPlayerManager = this.playerManager`  L465
- `IPlayerManager iPlayerManager = this.playerManager`  L474
- `IPlayerManager iPlayerManager = this.playerManager`  L483
- `IPlayerManager iPlayerManager = this.playerManager`  L492
- `IPlayerManager iPlayerManager = this.playerManager`  L501
- `IPlayerManager iPlayerManager = this.playerManager`  L553
- `IPlayerManager iPlayerManager2 = this.playerManager`  L563
- `IPlayerManager iPlayerManager`  L598
- `IPlayerManager iPlayerManager = this.playerManager`  L606
- `IPlayerManager iPlayerManager = this.playerManager`  L634

方法（82）：
- `void run()`  L55 @Override
    - 体内字面量："time out for error listener"
- `int getRotateInfoFlag()`  L64 @Override
- `void clearAllDefaultCache(Context context)`  L68
- `void clearDefaultCache(Context context, File file, String str)`  L72
- `void init()`  L81
- `IPlayerManager getPlayManager()`  L86
- `ICacheManager getCacheManager()`  L90
- `GSYMediaPlayerListener listener()`  L95 @Override
- `GSYMediaPlayerListener lastListener()`  L104 @Override
- `void setListener(GSYMediaPlayerListener gSYMediaPlayerListener)`  L113 @Override
- `void setLastListener(GSYMediaPlayerListener gSYMediaPlayerListener)`  L122 @Override
- `void setSpeed(float f, boolean z)`  L131 @Override
- `void prepare(String str, Map<String, String> map, boolean z, float f, boolean z2, File file)`  L139 @Override
- `void prepare(String str, Map<String, String> map, boolean z, float f, boolean z2, File file, String str2)`  L144 @Override
- `void prepare(BufferedInputStream bufferedInputStream, Map<String, String> map, boolean z, float f, boolean z2, File file)`  L155 @Override
- `void prepare(BufferedInputStream bufferedInputStream, Map<String, String> map, boolean z, float f, boolean z2, File file, String str)`  L160 @Override
- `void releaseMediaPlayer()`  L171 @Override
- `void setDisplay(Surface surface)`  L180 @Override
- `void releaseSurface(Surface surface)`  L188 @Override
- `void onPrepared(IMediaPlayer iMediaPlayer)`  L196 @Override
- `void run()`  L199 @Override
- `void onCompletion(IMediaPlayer iMediaPlayer)`  L209 @Override
- `void run()`  L212 @Override
- `void onBufferingUpdate(IMediaPlayer iMediaPlayer, final int i)`  L222 @Override
- `void run()`  L225 @Override
- `void onSeekComplete(IMediaPlayer iMediaPlayer)`  L238 @Override
- `void run()`  L241 @Override
- `boolean onError(IMediaPlayer iMediaPlayer, final int i, final int i2)`  L251 @Override
- `void run()`  L254 @Override
- `boolean onInfo(IMediaPlayer iMediaPlayer, final int i, final int i2)`  L265 @Override
- `void run()`  L268 @Override
- `void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4)`  L286 @Override
- `void run()`  L291 @Override
- `void onCacheAvailable(File file, String str, int i)`  L300 @Override
- `int getLastState()`  L305 @Override
- `void setLastState(int i)`  L310 @Override
- `int getCurrentVideoWidth()`  L315 @Override
- `int getCurrentVideoHeight()`  L320 @Override
- `void setCurrentVideoHeight(int i)`  L325 @Override
- `void setCurrentVideoWidth(int i)`  L330 @Override
- `String getPlayTag()`  L335 @Override
- `void setPlayTag(String str)`  L340 @Override
- `int getPlayPosition()`  L345 @Override
- `void setPlayPosition(int i)`  L350 @Override
- `boolean isCacheFile()`  L355 @Override
- `boolean cachePreview(Context context, File file, String str)`  L361 @Override
- `long getNetSpeed()`  L369 @Override
- `void clearCache(Context context, File file, String str)`  L378 @Override
- `int getBufferedPercentage()`  L383 @Override
- `void setSpeedPlaying(float f, boolean z)`  L392 @Override
- `IPlayerManager getPlayer()`  L400 @Override
- `void start()`  L405 @Override
- `void stop()`  L413 @Override
- `void pause()`  L421 @Override
- `int getVideoWidth()`  L429 @Override
- `int getVideoHeight()`  L438 @Override
- `boolean isPlaying()`  L447 @Override
- `void seekTo(long j)`  L456 @Override
- `long getCurrentPosition()`  L464 @Override
- `long getDuration()`  L473 @Override
- `int getVideoSarNum()`  L482 @Override
- `int getVideoSarDen()`  L491 @Override
- `boolean isSurfaceSupportLockCanvas()`  L500 @Override
- `void sendMessage(Message message)`  L508
- `void initVideo(Message message)`  L549
- `void startTimeOutBuffer()`  L584
    - 体内字面量："startTimeOutBuffer"
- `void cancelTimeOutBuffer()`  L589
    - 体内字面量："cancelTimeOutBuffer"
- `void releaseSurface(Message message)`  L597
- `void showDisplay(Message message)`  L605
- `void initContext(Context context)`  L612
- `void enableRawPlay(Context context)`  L616
- `List<VideoOptionModel> getOptionModelList()`  L620
- `void setOptionModelList(List<VideoOptionModel> list)`  L624
- `boolean isNeedMute()`  L628
- `void setNeedMute(boolean z)`  L632
- `int getTimeOut()`  L640
- `boolean isNeedTimeOutOther()`  L644
- `void setTimeOut(int i, boolean z)`  L648
- `IPlayerManager getCurPlayerManager()`  L653
- `ICacheManager getCurCacheManager()`  L657
- `IPlayerInitSuccessListener getPlayerPreparedSuccessListener()`  L661
- `void setPlayerInitSuccessListener(IPlayerInitSuccessListener iPlayerInitSuccessListener)`  L665
### `com.gku.ffm.zqvideo.GSYVideoBaseManager$MediaHandler`
L512 · [class] private MediaHandler · extends `Handler` · `com/gku/ffm/zqvideo/GSYVideoBaseManager.java`

字段/常量（1）：
- `int i = message.what`  L520

方法（1）：
- `void handleMessage(Message message)`  L518 @Override
### `com.gku.ffm.zqvideo.GSYVideoManager`
L13 · [class] public GSYVideoManager · extends `GSYVideoBaseManager` · `com/gku/ffm/zqvideo/GSYVideoManager.java`

字段/常量（5）：
- `GSYVideoManager videoManager`  L14
- `int SMALL_ID = R.id.small_id`  L15
- `int FULLSCREEN_ID = R.id.full_id`  L16
- `String TAG = "GSYVideoManager"`  L17
- `GSYVideoManager gSYVideoManager`  L31

方法（10）：
- `private GSYVideoManager()`  L19
- `GSYVideoManager instance()`  L23
- `GSYVideoManager tmpInstance(GSYMediaPlayerListener gSYMediaPlayerListener)`  L30
- `void changeManager(GSYVideoManager gSYVideoManager)`  L48
- `boolean backFromWindowFull(Context context)`  L52
- `void releaseAllVideos()`  L63
- `void onPause()`  L70
- `void onResume()`  L76
- `void onResume(boolean z)`  L82
- `boolean isFullState(Activity activity)`  L88
### `com.gku.ffm.zqvideo.listener.GSYMediaPlayerListener`
L4 · [interface] public GSYMediaPlayerListener · `com/gku/ffm/zqvideo/listener/GSYMediaPlayerListener.java`

方法（12）：
- `void onAutoCompletion()`  L5
- `void onBackFullscreen()`  L7
- `void onBufferingUpdate(int i)`  L9
- `void onCompletion()`  L11
- `void onError(int i, int i2)`  L13
- `void onInfo(int i, int i2)`  L15
- `void onPrepared()`  L17
- `void onSeekComplete()`  L19
- `void onVideoPause()`  L21
- `void onVideoResume()`  L23
- `void onVideoResume(boolean z)`  L25
- `void onVideoSizeChanged()`  L27
### `com.gku.ffm.zqvideo.listener.GSYSampleCallBack`
L4 · [class] public GSYSampleCallBack · implements `VideoAllCallBack` · `com/gku/ffm/zqvideo/listener/GSYSampleCallBack.java`

方法（23）：
- `void onAutoComplete(String str, Object... objArr)`  L6 @Override
- `void onClickBlank(String str, Object... objArr)`  L10 @Override
- `void onClickBlankFullscreen(String str, Object... objArr)`  L14 @Override
- `void onClickResume(String str, Object... objArr)`  L18 @Override
- `void onClickResumeFullscreen(String str, Object... objArr)`  L22 @Override
- `void onClickSeekbar(String str, Object... objArr)`  L26 @Override
- `void onClickSeekbarFullscreen(String str, Object... objArr)`  L30 @Override
- `void onClickStartError(String str, Object... objArr)`  L34 @Override
- `void onClickStartIcon(String str, Object... objArr)`  L38 @Override
- `void onClickStartThumb(String str, Object... objArr)`  L42 @Override
- `void onClickStop(String str, Object... objArr)`  L46 @Override
- `void onClickStopFullscreen(String str, Object... objArr)`  L50 @Override
- `void onComplete(String str, Object... objArr)`  L54 @Override
- `void onEnterFullscreen(String str, Object... objArr)`  L58 @Override
- `void onEnterSmallWidget(String str, Object... objArr)`  L62 @Override
- `void onPlayError(String str, Object... objArr)`  L66 @Override
- `void onPrepared(String str, Object... objArr)`  L70 @Override
- `void onQuitFullscreen(String str, Object... objArr)`  L74 @Override
- `void onQuitSmallWidget(String str, Object... objArr)`  L78 @Override
- `void onStartPrepared(String str, Object... objArr)`  L82 @Override
- `void onTouchScreenSeekLight(String str, Object... objArr)`  L86 @Override
- `void onTouchScreenSeekPosition(String str, Object... objArr)`  L90 @Override
- `void onTouchScreenSeekVolume(String str, Object... objArr)`  L94 @Override
### `com.gku.ffm.zqvideo.listener.GSYStateUiListener`
L4 · [interface] public GSYStateUiListener · `com/gku/ffm/zqvideo/listener/GSYStateUiListener.java`

方法（1）：
- `void onStateChanged(int i)`  L5
### `com.gku.ffm.zqvideo.listener.GSYVideoGifSaveListener`
L6 · [interface] public GSYVideoGifSaveListener · `com/gku/ffm/zqvideo/listener/GSYVideoGifSaveListener.java`

方法（2）：
- `void process(int i, int i2)`  L7
- `void result(boolean z, File file)`  L9
### `com.gku.ffm.zqvideo.listener.GSYVideoProgressListener`
L4 · [interface] public GSYVideoProgressListener · `com/gku/ffm/zqvideo/listener/GSYVideoProgressListener.java`

方法（1）：
- `void onProgress(long j, long j2, long j3, long j4)`  L5
### `com.gku.ffm.zqvideo.listener.GSYVideoShotListener`
L6 · [interface] public GSYVideoShotListener · `com/gku/ffm/zqvideo/listener/GSYVideoShotListener.java`

方法（1）：
- `void getBitmap(Bitmap bitmap)`  L7
### `com.gku.ffm.zqvideo.listener.GSYVideoShotSaveListener`
L6 · [interface] public GSYVideoShotSaveListener · `com/gku/ffm/zqvideo/listener/GSYVideoShotSaveListener.java`

方法（1）：
- `void result(boolean z, File file)`  L7
### `com.gku.ffm.zqvideo.listener.LockClickListener`
L6 · [interface] public LockClickListener · `com/gku/ffm/zqvideo/listener/LockClickListener.java`

方法（1）：
- `void onClick(View view, boolean z)`  L7
### `com.gku.ffm.zqvideo.listener.VideoAllCallBack`
L4 · [interface] public VideoAllCallBack · `com/gku/ffm/zqvideo/listener/VideoAllCallBack.java`

方法（23）：
- `void onAutoComplete(String str, Object... objArr)`  L5
- `void onClickBlank(String str, Object... objArr)`  L7
- `void onClickBlankFullscreen(String str, Object... objArr)`  L9
- `void onClickResume(String str, Object... objArr)`  L11
- `void onClickResumeFullscreen(String str, Object... objArr)`  L13
- `void onClickSeekbar(String str, Object... objArr)`  L15
- `void onClickSeekbarFullscreen(String str, Object... objArr)`  L17
- `void onClickStartError(String str, Object... objArr)`  L19
- `void onClickStartIcon(String str, Object... objArr)`  L21
- `void onClickStartThumb(String str, Object... objArr)`  L23
- `void onClickStop(String str, Object... objArr)`  L25
- `void onClickStopFullscreen(String str, Object... objArr)`  L27
- `void onComplete(String str, Object... objArr)`  L29
- `void onEnterFullscreen(String str, Object... objArr)`  L31
- `void onEnterSmallWidget(String str, Object... objArr)`  L33
- `void onPlayError(String str, Object... objArr)`  L35
- `void onPrepared(String str, Object... objArr)`  L37
- `void onQuitFullscreen(String str, Object... objArr)`  L39
- `void onQuitSmallWidget(String str, Object... objArr)`  L41
- `void onStartPrepared(String str, Object... objArr)`  L43
- `void onTouchScreenSeekLight(String str, Object... objArr)`  L45
- `void onTouchScreenSeekPosition(String str, Object... objArr)`  L47
- `void onTouchScreenSeekVolume(String str, Object... objArr)`  L49
### `com.gku.ffm.zqvideo.model.GSYModel`
L8 · [class] public GSYModel · `com/gku/ffm/zqvideo/model/GSYModel.java`

字段/常量（8）：
- `boolean isCache`  L9
- `boolean looping`  L10
- `File mCachePath`  L11
- `Map<String, String> mapHeadData`  L12
- `String overrideExtension`  L13
- `float speed`  L14
- `String url`  L15
- `BufferedInputStream videoBufferedInputStream`  L16

方法（18）：
- `public GSYModel(String str, Map<String, String> map, boolean z, float f, boolean z2, File file, String str2)`  L18
- `public GSYModel(BufferedInputStream bufferedInputStream, Map<String, String> map, boolean z, float f, boolean z2, File file, String str)`  L28
- `String getUrl()`  L38
- `void setUrl(String str)`  L42
- `Map<String, String> getMapHeadData()`  L46
- `void setMapHeadData(Map<String, String> map)`  L50
- `boolean isLooping()`  L54
- `void setLooping(boolean z)`  L58
- `float getSpeed()`  L62
- `void setSpeed(float f)`  L66
- `boolean isCache()`  L70
- `void setCache(boolean z)`  L74
- `File getCachePath()`  L78
- `void setCachePath(File file)`  L82
- `String getOverrideExtension()`  L86
- `void setOverrideExtension(String str)`  L90
- `BufferedInputStream getVideoBufferedInputStream()`  L94
- `void setVideoBufferedInputStream(BufferedInputStream bufferedInputStream)`  L98
### `com.gku.ffm.zqvideo.model.GSYVideoModel`
L4 · [class] public GSYVideoModel · `com/gku/ffm/zqvideo/model/GSYVideoModel.java`

字段/常量（2）：
- `String mTitle`  L5
- `String mUrl`  L6

方法（5）：
- `public GSYVideoModel(String str, String str2)`  L8
- `String getUrl()`  L13
- `void setUrl(String str)`  L17
- `String getTitle()`  L21
- `void setTitle(String str)`  L25
### `com.gku.ffm.zqvideo.model.VideoOptionModel`
L4 · [class] public VideoOptionModel · `com/gku/ffm/zqvideo/model/VideoOptionModel.java`

字段/常量（7）：
- `int VALUE_TYPE_INT = 0`  L5
- `int VALUE_TYPE_STRING = 1`  L6
- `int category`  L7
- `String name`  L8
- `int valueInt`  L9
- `String valueString`  L10
- `int valueType = 0`  L11

方法（12）：
- `public VideoOptionModel(int i, String str, int i2)`  L13
- `public VideoOptionModel(int i, String str, String str2)`  L19
- `int getValueType()`  L25
- `void setValueType(int i)`  L29
- `int getCategory()`  L33
- `void setCategory(int i)`  L37
- `int getValueInt()`  L41
- `void setValueInt(int i)`  L45
- `String getName()`  L50
- `void setName(String str)`  L54
- `String getValueString()`  L58
- `void setValueString(String str)`  L62
### `com.gku.ffm.zqvideo.player.BasePlayerManager`
L6 · [class] public abstract BasePlayerManager · implements `IPlayerManager` · `com/gku/ffm/zqvideo/player/BasePlayerManager.java`

字段/常量（2）：
- `IPlayerInitSuccessListener mPlayerInitSuccessListener`  L7
- `IPlayerInitSuccessListener iPlayerInitSuccessListener = this.mPlayerInitSuccessListener`  L18

方法（3）：
- `IPlayerInitSuccessListener getPlayerPreparedSuccessListener()`  L9
- `void setPlayerInitSuccessListener(IPlayerInitSuccessListener iPlayerInitSuccessListener)`  L13
- `void initSuccess(GSYModel gSYModel)`  L17
### `com.gku.ffm.zqvideo.player.IjkPlayerManager`
L27 · [class] public IjkPlayerManager · extends `BasePlayerManager` · `com/gku/ffm/zqvideo/player/IjkPlayerManager.java`

字段/常量（27）：
- `IjkLibLoader ijkLibLoader = null`  L28
- `int logLevel = 1`  L29
- `IjkMediaPlayer mediaPlayer`  L30
- `List<VideoOptionModel> optionModelList`  L31
- `Surface surface`  L32
- `IjkMediaPlayer ijkMediaPlayer`  L104
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L121
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L144
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L156
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L171
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L180
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L189
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L198
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L206
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L214
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L222
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L231
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L240
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L249
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L257
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L266
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L275
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L284
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L292
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L300
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L308
- `IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer`  L315

方法（35）：
- `int getBufferedPercentage()`  L35 @Override
- `boolean isSurfaceSupportLockCanvas()`  L40 @Override
- `IMediaPlayer getMediaPlayer()`  L45 @Override
- `void initVideoPlayer(Context context, Message message, List<VideoOptionModel> list, ICacheManager iCacheManager)`  L50 @Override
- `boolean onNativeInvoke(int i, Bundle bundle)`  L56 @Override
    - 体内字面量："enable mediaCodec" · "mediacodec" · "mediacodec-auto-rotate" · "mediacodec-handle-resolution-change" · "android.resource" · "assets" · "content"
- `void showDisplay(Message message)`  L103 @Override
- `void setSpeed(float f, boolean z)`  L118 @Override
- `void setNeedMute(boolean z)`  L143 @Override
- `void setVolume(float f, float f2)`  L155 @Override
- `void releaseSurface()`  L163 @Override
- `void release()`  L170 @Override
- `long getNetSpeed()`  L179 @Override
- `void setSpeedPlaying(float f, boolean z)`  L188 @Override
- `void start()`  L197 @Override
- `void stop()`  L205 @Override
- `void pause()`  L213 @Override
- `int getVideoWidth()`  L221 @Override
- `int getVideoHeight()`  L230 @Override
- `boolean isPlaying()`  L239 @Override
- `void seekTo(long j)`  L248 @Override
- `long getCurrentPosition()`  L256 @Override
- `long getDuration()`  L265 @Override
- `int getVideoSarNum()`  L274 @Override
- `int getVideoSarDen()`  L283 @Override
- `IjkTrackInfo[] getTrackInfo()`  L291
- `int getSelectedTrack(int i)`  L299
- `void selectTrack(int i)`  L307
- `void deselectTrack(int i)`  L314
- `void initIJKOption(IjkMediaPlayer ijkMediaPlayer, List<VideoOptionModel> list)`  L321
- `List<VideoOptionModel> getOptionModelList()`  L334
- `void setOptionModelList(List<VideoOptionModel> list)`  L338
- `IjkLibLoader getIjkLibLoader()`  L342
- `void setIjkLibLoader(IjkLibLoader ijkLibLoader2)`  L346
- `int getLogLevel()`  L350
- `void setLogLevel(int i)`  L354
### `com.gku.ffm.zqvideo.player.IPlayerInitSuccessListener`
L7 · [interface] public IPlayerInitSuccessListener · `com/gku/ffm/zqvideo/player/IPlayerInitSuccessListener.java`

方法（1）：
- `void onPlayerInitSuccess(IMediaPlayer iMediaPlayer, GSYModel gSYModel)`  L8
### `com.gku.ffm.zqvideo.player.IPlayerManager`
L11 · [interface] public IPlayerManager · `com/gku/ffm/zqvideo/player/IPlayerManager.java`

方法（23）：
- `int getBufferedPercentage()`  L12
- `long getCurrentPosition()`  L14
- `long getDuration()`  L16
- `IMediaPlayer getMediaPlayer()`  L18
- `long getNetSpeed()`  L20
- `int getVideoHeight()`  L22
- `int getVideoSarDen()`  L24
- `int getVideoSarNum()`  L26
- `int getVideoWidth()`  L28
- `void initVideoPlayer(Context context, Message message, List<VideoOptionModel> list, ICacheManager iCacheManager)`  L30
- `boolean isPlaying()`  L32
- `boolean isSurfaceSupportLockCanvas()`  L34
- `void pause()`  L36
- `void release()`  L38
- `void releaseSurface()`  L40
- `void seekTo(long j)`  L42
- `void setNeedMute(boolean z)`  L44
- `void setSpeed(float f, boolean z)`  L46
- `void setSpeedPlaying(float f, boolean z)`  L48
- `void setVolume(float f, float f2)`  L50
- `void showDisplay(Message message)`  L52
- `void start()`  L54
- `void stop()`  L56
### `com.gku.ffm.zqvideo.player.PlayerFactory`
L4 · [class] public PlayerFactory · `com/gku/ffm/zqvideo/player/PlayerFactory.java`

字段/常量（1）：
- `Class<? extends IPlayerManager> sPlayerManager`  L5

方法（2）：
- `void setPlayManager(Class<? extends IPlayerManager> cls)`  L7
- `IPlayerManager getPlayManager()`  L11
### `com.gku.ffm.zqvideo.player.SystemPlayerManager`
L17 · [class] public SystemPlayerManager · extends `BasePlayerManager` · `com/gku/ffm/zqvideo/player/SystemPlayerManager.java`

字段/常量（24）：
- `Context context`  L18
- `AndroidMediaPlayer mediaPlayer`  L19
- `boolean release`  L20
- `Surface surface`  L21
- `long lastTotalRxBytes = 0`  L22
- `long lastTimeStamp = 0`  L23
- `boolean isPlaying = false`  L24
- `AndroidMediaPlayer androidMediaPlayer`  L71
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L97
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L113
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L128
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L148
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L157
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L166
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L175
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L184
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L193
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L202
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L210
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L219
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L228
- `AndroidMediaPlayer androidMediaPlayer = this.mediaPlayer`  L237
- `AndroidMediaPlayer androidMediaPlayer`  L245
- `long j = jCurrentTimeMillis - this.lastTimeStamp`  L264

方法（25）：
- `int getBufferedPercentage()`  L27 @Override
- `boolean isSurfaceSupportLockCanvas()`  L32 @Override
- `void setSpeedPlaying(float f, boolean z)`  L37 @Override
- `IMediaPlayer getMediaPlayer()`  L41 @Override
- `void initVideoPlayer(Context context, Message message, List<VideoOptionModel> list, ICacheManager iCacheManager)`  L46 @Override
- `void showDisplay(Message message)`  L70 @Override
- `void setSpeed(float f, boolean z)`  L90 @Override
- `void setNeedMute(boolean z)`  L95 @Override
- `void setVolume(float f, float f2)`  L112 @Override
- `void releaseSurface()`  L120 @Override
- `void release()`  L127 @Override
- `long getNetSpeed()`  L139 @Override
- `void start()`  L147 @Override
- `void stop()`  L156 @Override
- `void pause()`  L165 @Override
- `int getVideoWidth()`  L174 @Override
- `int getVideoHeight()`  L183 @Override
- `boolean isPlaying()`  L192 @Override
- `void seekTo(long j)`  L201 @Override
- `long getCurrentPosition()`  L209 @Override
- `long getDuration()`  L218 @Override
- `int getVideoSarNum()`  L227 @Override
- `int getVideoSarDen()`  L236 @Override
- `void setSpeed(float f)`  L244
- `long getNetSpeed(Context context)`  L258
### `com.gku.ffm.zqvideo.render.effect.AutoFixEffect`
L7 · [class] public AutoFixEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/AutoFixEffect.java`

字段/常量（1）：
- `float scale`  L8

方法（2）：
- `public AutoFixEffect(float f)`  L10
- `String getShader(GLSurfaceView gLSurfaceView)`  L16 @Override
### `com.gku.ffm.zqvideo.render.effect.BarrelBlurEffect`
L7 · [class] public BarrelBlurEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/BarrelBlurEffect.java`

字段/常量（1）：
- `int countLevel`  L8

方法（4）：
- `public BarrelBlurEffect()`  L10
- `public BarrelBlurEffect(int i)`  L14
- `void setCountLevel(int i)`  L18
- `String getShader(GLSurfaceView gLSurfaceView)`  L23 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;  \n  \nvarying vec2 vTextureCoord;\nconst float barrelPower = 0.5;   \nconst int num_iter = "
### `com.gku.ffm.zqvideo.render.effect.BlackAndWhiteEffect`
L7 · [class] public BlackAndWhiteEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/BlackAndWhiteEffect.java`

方法（1）：
- `String getShader(GLSurfaceView gLSurfaceView)`  L9 @Override
### `com.gku.ffm.zqvideo.render.effect.BrightnessEffect`
L7 · [class] public BrightnessEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/BrightnessEffect.java`

字段/常量（1）：
- `float brightnessValue`  L8

方法（2）：
- `public BrightnessEffect(float f)`  L10
- `String getShader(GLSurfaceView gLSurfaceView)`  L16 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nfloat brightness ;\nvarying vec2 vTextureCoord;\nvoid main() {\n  brightness =" · ";\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = brightness * color;\n}\n"
### `com.gku.ffm.zqvideo.render.effect.ContrastEffect`
L7 · [class] public ContrastEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/ContrastEffect.java`

字段/常量（1）：
- `float contrast`  L8

方法（2）：
- `public ContrastEffect(float f)`  L10
- `String getShader(GLSurfaceView gLSurfaceView)`  L16 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\n float contrast;\nvarying vec2 vTextureCoord;\nvoid main() {\n  contrast =" · ";\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  color -= 0.5;\n  color *= contrast;\n  color += 0.5;\n  gl_FragColor = color;\n}\n"
### `com.gku.ffm.zqvideo.render.effect.CrossProcessEffect`
L7 · [class] public CrossProcessEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/CrossProcessEffect.java`

方法（1）：
- `String getShader(GLSurfaceView gLSurfaceView)`  L9 @Override
### `com.gku.ffm.zqvideo.render.effect.DocumentaryEffect`
L9 · [class] public DocumentaryEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/DocumentaryEffect.java`

字段/常量（10）：
- `int mHeight`  L10
- `Random mRandom`  L11
- `int mWidth`  L12
- `float[] fArr = new float[2]`  L23
- `int i = this.mWidth`  L24
- `int i2 = this.mHeight`  L25
- `float f = fArr[0]`  L33
- `float f2 = fArr[1]`  L34
- `String[] strArr = {"scale[0] = " + fArr[0] + ";\n", "scale[1] = " + fArr[1] + ";\n"}`  L37
- `String[] strArr2 = {"seed[0] = " + fArr2[0] + ";\n", "seed[1] = " + fArr2[1] + ";\n"}`  L38

方法（2）：
- `void initValues(GLSurfaceView gLSurfaceView)`  L14
- `String getShader(GLSurfaceView gLSurfaceView)`  L21 @Override
### `com.gku.ffm.zqvideo.render.effect.DuotoneEffect`
L8 · [class] public DuotoneEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/DuotoneEffect.java`

字段/常量（4）：
- `int mFirstColor`  L9
- `int mSecondColor`  L10
- `String[] strArr = {"first[0] = " + fArr[0] + ";\n", "first[1] = " + fArr[1] + ";\n", "first[2] = " + fArr[2] + ";\n"}`  L21
- `String[] strArr2 = {"second[0] = " + fArr2[0] + ";\n", "second[1] = " + fArr2[1] + ";\n", "second[2] = " + fArr2[2] + ";\n"}`  L22

方法（2）：
- `public DuotoneEffect(int i, int i2)`  L12
- `String getShader(GLSurfaceView gLSurfaceView)`  L18 @Override
### `com.gku.ffm.zqvideo.render.effect.FillLightEffect`
L7 · [class] public FillLightEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/FillLightEffect.java`

字段/常量（1）：
- `float strength`  L8

方法（2）：
- `public FillLightEffect(float f)`  L10
- `String getShader(GLSurfaceView gLSurfaceView)`  L17 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\n float mult;\n float igamma;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n" · "mult = " · ";\n" · "igamma = " · ";\n"
### `com.gku.ffm.zqvideo.render.effect.GammaEffect`
L7 · [class] public GammaEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/GammaEffect.java`

字段/常量（1）：
- `float gammaValue`  L8

方法（2）：
- `public GammaEffect(float f)`  L10
- `String getShader(GLSurfaceView gLSurfaceView)`  L16 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nfloat gamma=" · ";\nvoid main() {\nvec4 textureColor = texture2D(sTexture, vTextureCoord);\ngl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n}\n"
### `com.gku.ffm.zqvideo.render.effect.GaussianBlurEffect`
L7 · [class] public GaussianBlurEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/GaussianBlurEffect.java`

字段/常量（5）：
- `int TYPEX = 1`  L8
- `int TYPEXY = 3`  L9
- `int TYPEY = 2`  L10
- `String blurTypeString`  L11
- `float radius`  L12

方法（3）：
- `public GaussianBlurEffect(float f)`  L14
    - 体内字面量："vec2(1.0,0.0)"
- `public GaussianBlurEffect(float f, int i)`  L19
    - 体内字面量："vec2(1.0,0.0)" · "vec2(1.0,0.0)" · "vec2(0.0,1.0)" · "vec2(1.0,1.0)"
- `String getShader(GLSurfaceView gLSurfaceView)`  L35 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nconst float resolution=1024.0;\nconst float radius = " · ";\nvec2 dir ="
### `com.gku.ffm.zqvideo.render.effect.GrainEffect`
L9 · [class] public GrainEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/GrainEffect.java`

字段/常量（6）：
- `int mHeight`  L10
- `Random mRandom`  L11
- `int mWidth`  L12
- `float strength`  L13
- `String str = "scale = " + this.strength + ";\n"`  L30
- `String[] strArr = {"seed[0] = " + fArr[0] + ";\n", "seed[1] = " + fArr[1] + ";\n"}`  L31

方法（3）：
- `public GrainEffect(float f)`  L15
- `void initValues(GLSurfaceView gLSurfaceView)`  L20
- `String getShader(GLSurfaceView gLSurfaceView)`  L27 @Override
### `com.gku.ffm.zqvideo.render.effect.GreyScaleEffect`
L7 · [class] public GreyScaleEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/GreyScaleEffect.java`

方法（1）：
- `String getShader(GLSurfaceView gLSurfaceView)`  L9 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float y = dot(color, vec4(0.299, 0.587, 0.114, 0));\n  gl_FragColor = vec4(y, y, y, color.a);\n}\n"
### `com.gku.ffm.zqvideo.render.effect.HueEffect`
L7 · [class] public HueEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/HueEffect.java`

字段/常量（1）：
- `float hueValue`  L8

方法（2）：
- `public HueEffect(float f)`  L10
- `String getShader(GLSurfaceView gLSurfaceView)`  L15 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nfloat hue="
### `com.gku.ffm.zqvideo.render.effect.InvertColorsEffect`
L7 · [class] public InvertColorsEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/InvertColorsEffect.java`

方法（1）：
- `String getShader(GLSurfaceView gLSurfaceView)`  L9 @Override
### `com.gku.ffm.zqvideo.render.effect.LamoishEffect`
L9 · [class] public LamoishEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/LamoishEffect.java`

字段/常量（10）：
- `int mHeight`  L10
- `Random mRandom`  L11
- `int mWidth`  L12
- `float[] fArr = new float[2]`  L23
- `int i = this.mWidth`  L24
- `int i2 = this.mHeight`  L25
- `float f = fArr[0]`  L33
- `float f2 = fArr[1]`  L34
- `String[] strArr = {"scale[0] = " + fArr[0] + ";\n", "scale[1] = " + fArr[1] + ";\n"}`  L37
- `String[] strArr2 = {"seed[0] = " + fArr2[0] + ";\n", "seed[1] = " + fArr2[1] + ";\n"}`  L38

方法（2）：
- `void initValues(GLSurfaceView gLSurfaceView)`  L14
- `String getShader(GLSurfaceView gLSurfaceView)`  L21 @Override
### `com.gku.ffm.zqvideo.render.effect.NoEffect`
L7 · [class] public NoEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/NoEffect.java`

方法（1）：
- `String getShader(GLSurfaceView gLSurfaceView)`  L9 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n"
### `com.gku.ffm.zqvideo.render.effect.OverlayEffect`
L7 · [class] public OverlayEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/OverlayEffect.java`

字段/常量（1）：
- `float fstep`  L8

方法（3）：
- `public OverlayEffect()`  L10
- `public OverlayEffect(float f)`  L14
- `String getShader(GLSurfaceView gLSurfaceView)`  L19 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n             uniform samplerExternalOES sTexture; \n             varying vec2 vTextureCoord; \n  \n             void main() \n             { \n              vec4 sample0,sample1,sample2,sample3; \n              float fstep="
### `com.gku.ffm.zqvideo.render.effect.PosterizeEffect`
L7 · [class] public PosterizeEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/PosterizeEffect.java`

方法（1）：
- `String getShader(GLSurfaceView gLSurfaceView)`  L9 @Override
### `com.gku.ffm.zqvideo.render.effect.SampleBlurEffect`
L7 · [class] public SampleBlurEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/SampleBlurEffect.java`

字段/常量（1）：
- `float blur`  L8

方法（3）：
- `public SampleBlurEffect()`  L10
- `public SampleBlurEffect(float f)`  L14
- `String getShader(GLSurfaceView gLSurfaceView)`  L19 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 vTextureCoord;\nconst float blurSize = "
### `com.gku.ffm.zqvideo.render.effect.SaturationEffect`
L7 · [class] public SaturationEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/SaturationEffect.java`

字段/常量（6）：
- `float scale`  L8
- `float[] fArr = {0.25f, 0.625f, 0.125f}`  L16
- `String str = "<binary/metadata>"`  L17
- `String[] strArr = {"<binary/metadata>", "<binary/metadata>", "<binary/metadata>"}`  L18
- `float f = this.scale`  L19
- `String[] strArr2 = {"weights[0] = " + fArr[0] + ";\n", "weights[1] = " + fArr[1] + ";\n", "weights[2] = " + fArr[2] + ";\n"}`  L28

方法（2）：
- `public SaturationEffect(float f)`  L10
- `String getShader(GLSurfaceView gLSurfaceView)`  L15 @Override
### `com.gku.ffm.zqvideo.render.effect.SepiaEffect`
L7 · [class] public SepiaEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/SepiaEffect.java`

字段/常量（2）：
- `float[] fArr = {0.3930664f, 0.3491211f, 0.27197266f, 0.76904297f, 0.68603516f, 0.53564453f, 0.18896484f, 0.16796875f, 0.13085938f}`  L10
- `String[] strArr = {"  matrix[0][0]=" + fArr[0] + ";\n", "  matrix[0][1]=" + fArr[1] + ";\n", "  matrix[0][2]=" + fArr[2] + ";\n", "  matrix[1][0]=" + fArr[3] + ";\n", "  matrix[1][1]=" + fArr[4] + ";\n", "  matrix[1][2]=" + fArr[5] + ";\n", "  matrix[2][0]=" + fArr[6] + ";\n", "  matrix[2][1]=" + fArr[7] + ";\n", "  matrix[2][2]=" + fArr[8] + ";\n"}`  L11

方法（1）：
- `String getShader(GLSurfaceView gLSurfaceView)`  L9 @Override
### `com.gku.ffm.zqvideo.render.effect.SharpnessEffect`
L7 · [class] public SharpnessEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/SharpnessEffect.java`

字段/常量（3）：
- `int mHeight`  L8
- `int mWidth`  L9
- `float scale`  L10

方法（3）：
- `public SharpnessEffect(float f)`  L12
- `void initValues(GLSurfaceView gLSurfaceView)`  L18
- `String getShader(GLSurfaceView gLSurfaceView)`  L24 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\n float scale;\n float stepsizeX;\n float stepsizeY;\nvarying vec2 vTextureCoord;\nvoid main() {\n" · "stepsizeX = " · ";\n" · "stepsizeY = " · ";\n" · "scale = " · ";\n"
### `com.gku.ffm.zqvideo.render.effect.TemperatureEffect`
L7 · [class] public TemperatureEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/TemperatureEffect.java`

字段/常量（1）：
- `float scale`  L8

方法（2）：
- `public TemperatureEffect(float f)`  L10
- `String getShader(GLSurfaceView gLSurfaceView)`  L17 @Override
    - 体内字面量："#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\n float scale;\nvarying vec2 vTextureCoord;\nvoid main() {\n" · "scale = " · ";\n"
### `com.gku.ffm.zqvideo.render.effect.TintEffect`
L8 · [class] public TintEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/TintEffect.java`

字段/常量（4）：
- `int mTint`  L9
- `float[] fArr = {0.21f, 0.71f, 0.07f}`  L17
- `String[] strArr = {"color_ratio[0] = " + fArr[0] + ";\n", "color_ratio[1] = " + fArr[1] + ";\n", "color_ratio[2] = " + fArr[2] + ";\n"}`  L18
- `String[] strArr2 = {"tint[0] = " + fArr2[0] + ";\n", "tint[1] = " + fArr2[1] + ";\n", "tint[2] = " + fArr2[2] + ";\n"}`  L20

方法（2）：
- `public TintEffect(int i)`  L11
- `String getShader(GLSurfaceView gLSurfaceView)`  L16 @Override
### `com.gku.ffm.zqvideo.render.effect.VignetteEffect`
L7 · [class] public VignetteEffect · implements `GSYVideoGLView.ShaderInterface` · `com/gku/ffm/zqvideo/render/effect/VignetteEffect.java`

字段/常量（10）：
- `float mScale`  L8
- `int mWidth = 0`  L9
- `int mHeight = 0`  L10
- `float mShade = 0.85f`  L11
- `float[] fArr = new float[2]`  L27
- `int i = this.mWidth`  L28
- `int i2 = this.mHeight`  L29
- `float f = fArr[0]`  L37
- `float f2 = fArr[1]`  L38
- `String[] strArr = {"scale[0] = " + fArr[0] + ";\n", "scale[1] = " + fArr[1] + ";\n"}`  L40

方法（3）：
- `public VignetteEffect(float f)`  L13
- `void initValues(GLSurfaceView gLSurfaceView)`  L19
- `String getShader(GLSurfaceView gLSurfaceView)`  L25 @Override
### `com.gku.ffm.zqvideo.render.glrender.GSYVideoGLViewBaseRender`
L20 · [class] public abstract GSYVideoGLViewBaseRender · implements `GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener` · `com/gku/ffm/zqvideo/render/glrender/GSYVideoGLViewBaseRender.java`

字段/常量（21）：
- `GLSurfaceListener mGSYSurfaceListener`  L21
- `GSYVideoGLRenderErrorListener mGSYVideoGLRenderErrorListener`  L22
- `GLSurfaceView mSurfaceView`  L23
- `boolean mHighShot = false`  L24
- `float[] mMVPMatrix = new float[16]`  L25
- `float[] mSTMatrix = new float[16]`  L26
- `int mCurrentViewWidth = 0`  L27
- `int mCurrentViewHeight = 0`  L28
- `int mCurrentVideoWidth = 0`  L29
- `int mCurrentVideoHeight = 0`  L30
- `boolean mChangeProgram = false`  L31
- `boolean mChangeProgramSupportError = false`  L32
- `int[] iArr = new int[1]`  L70
- `int iLoadShader`  L83
- `int[] iArr = new int[1]`  L95
- `int i5 = i3 * i4`  L124
- `int[] iArr = new int[i5]`  L125
- `int[] iArr2 = new int[i5]`  L126
- `int i7 = i6 * i3`  L132
- `int i10 = iArr[i7 + i9]`  L135
- `int i = this.mCurrentViewWidth`  L193

方法（26）：
- `GSYVideoGLView.ShaderInterface getEffect()`  L35
- `void releaseAll()`  L39
- `void setEffect(GSYVideoGLView.ShaderInterface shaderInterface)`  L41
- `void setGSYVideoShotListener(GSYVideoShotListener gSYVideoShotListener, boolean z)`  L44
- `void takeShotPic()`  L47
- `void setSurfaceView(GLSurfaceView gLSurfaceView)`  L50
- `void sendSurfaceForPlayer(final Surface surface)`  L54
- `void run()`  L57 @Override
- `int loadShader(int i, String str)`  L65
- `int createProgram(String str, String str2)`  L82
- `void checkGlError(final String str)`  L107
    - 体内字面量：": glError "
- `void run()`  L113 @Override
    - 体内字面量：": glError "
- `Bitmap createBitmapFromGLSurface(int i, int i2, int i3, int i4, GL10 gl10)`  L123
- `void setGSYSurfaceListener(GLSurfaceListener gLSurfaceListener)`  L148
- `float[] getMVPMatrix()`  L152
- `void setMVPMatrix(float[] fArr)`  L156
- `int getCurrentViewWidth()`  L160
- `void setCurrentViewWidth(int i)`  L164
- `int getCurrentViewHeight()`  L168
- `void setCurrentViewHeight(int i)`  L172
- `int getCurrentVideoWidth()`  L176
- `void setCurrentVideoWidth(int i)`  L180
- `int getCurrentVideoHeight()`  L184
- `void setCurrentVideoHeight(int i)`  L188
- `void initRenderSize()`  L192
- `void setGSYVideoGLRenderErrorListener(GSYVideoGLRenderErrorListener gSYVideoGLRenderErrorListener)`  L200
### `com.gku.ffm.zqvideo.render.glrender.GSYVideoGLViewSimpleRender`
L18 · [class] public GSYVideoGLViewSimpleRender · extends `GSYVideoGLViewBaseRender` · `com/gku/ffm/zqvideo/render/glrender/GSYVideoGLViewSimpleRender.java`

字段/常量（19）：
- `int FLOAT_SIZE_BYTES = 4`  L19
- `int GL_TEXTURE_EXTERNAL_OES = 36197`  L20
- `int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0`  L21
- `int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20`  L22
- `int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3`  L23
- `GSYVideoShotListener mGSYVideoShotListener`  L24
- `int mProgram`  L25
- `SurfaceTexture mSurface`  L26
- `FloatBuffer mTriangleVertices`  L27
- `float[] mTriangleVerticesData`  L28
- `int maPositionHandle`  L29
- `int maTextureHandle`  L30
- `int muMVPMatrixHandle`  L31
- `int muSTMatrixHandle`  L32
- `String mVertexShader = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n"`  L33
- `int[] mTextureID = new int[2]`  L34
- `boolean mUpdateSurface = false`  L35
- `boolean mTakeShotPic = false`  L36
- `float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f}`  L44

方法（23）：
- `void releaseAll()`  L40 @Override
- `public GSYVideoGLViewSimpleRender()`  L43
- `void onDrawFrame(GL10 gl10)`  L54 @Override
- `void onSurfaceChanged(GL10 gl10, int i, int i2)`  L70 @Override
- `void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig)`  L75 @Override
    - 体内字面量："aPosition" · "glGetAttribLocation aPosition" · "Could not get attrib location for aPosition" · "aTextureCoord" · "glGetAttribLocation aTextureCoord" · "Could not get attrib location for aTextureCoord" · "uMVPMatrix" · "glGetUniformLocation uMVPMatrix" · "Could not get attrib location for uMVPMatrix" · "uSTMatrix" · "glGetUniformLocation uSTMatrix" · "Could not get attrib location for uSTMatrix" · "glBindTexture mTextureID"
- `void onFrameAvailable(SurfaceTexture surfaceTexture)`  L115 @Override
- `void setEffect(GSYVideoGLView.ShaderInterface shaderInterface)`  L120 @Override
- `GSYVideoGLView.ShaderInterface getEffect()`  L129 @Override
- `void initDrawFrame()`  L133
    - 体内字面量："glUseProgram"
- `void bindDrawFrameTexture()`  L144
- `void takeBitmap(GL10 gl10)`  L149
- `void initPointerAndDraw()`  L158
    - 体内字面量："glVertexAttribPointer maPosition" · "glEnableVertexAttribArray maPositionHandle" · "glVertexAttribPointer maTextureHandle" · "glEnableVertexAttribArray maTextureHandle" · "glDrawArrays"
- `int getProgram()`  L175
- `int getMuMVPMatrixHandle()`  L179
- `int getMuSTMatrixHandle()`  L183
- `int getMaPositionHandle()`  L187
- `int getMaTextureHandle()`  L191
- `float[] getSTMatrix()`  L195
- `int[] getTextureID()`  L199
- `String getVertexShader()`  L203
    - 体内字面量："uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n"
- `String getFragmentShader()`  L207
- `void takeShotPic()`  L212 @Override
- `void setGSYVideoShotListener(GSYVideoShotListener gSYVideoShotListener, boolean z)`  L217 @Override
### `com.gku.ffm.zqvideo.render.GSYRenderView`
L23 · [class] public GSYRenderView · `com/gku/ffm/zqvideo/render/GSYRenderView.java`

字段/常量（20）：
- `IGSYRenderView mShowView`  L24
- `IGSYRenderView iGSYRenderView = this.mShowView`  L27
- `IGSYRenderView iGSYRenderView = this.mShowView`  L38
- `IGSYRenderView iGSYRenderView = this.mShowView`  L45
- `IGSYRenderView iGSYRenderView = this.mShowView`  L52
- `IGSYRenderView iGSYRenderView = this.mShowView`  L60
- `IGSYRenderView iGSYRenderView = this.mShowView`  L68
- `IGSYRenderView iGSYRenderView = this.mShowView`  L80
- `IGSYRenderView iGSYRenderView = this.mShowView`  L97
- `IGSYRenderView iGSYRenderView = this.mShowView`  L104
- `IGSYRenderView iGSYRenderView = this.mShowView`  L112
- `IGSYRenderView iGSYRenderView = this.mShowView`  L124
- `IGSYRenderView iGSYRenderView = this.mShowView`  L135
- `IGSYRenderView iGSYRenderView = this.mShowView`  L142
- `IGSYRenderView iGSYRenderView = this.mShowView`  L149
- `IGSYRenderView iGSYRenderView = this.mShowView`  L156
- `IGSYRenderView iGSYRenderView = this.mShowView`  L163
- `IGSYRenderView iGSYRenderView = this.mShowView`  L170
- `IGSYRenderView iGSYRenderView = this.mShowView`  L177
- `IGSYRenderView iGSYRenderView = this.mShowView`  L184

方法（26）：
- `void requestLayout()`  L26
- `float getRotation()`  L33
- `void setRotation(float f)`  L37
- `void invalidate()`  L44
- `int getWidth()`  L51
- `int getHeight()`  L59
- `View getShowView()`  L67
- `ViewGroup.LayoutParams getLayoutParams()`  L75
- `void setLayoutParams(ViewGroup.LayoutParams layoutParams)`  L79
- `void addView(Context context, ViewGroup viewGroup, int i, IGSYSurfaceListener iGSYSurfaceListener, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener, GSYVideoGLView.ShaderInterface shaderInterface, float[] fArr, GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender, int i2)`  L86
- `void setTransform(Matrix matrix)`  L96
- `Bitmap initCover()`  L103
- `Bitmap initCoverHigh()`  L111
- `void taskShotPic(GSYVideoShotListener gSYVideoShotListener)`  L119
- `void taskShotPic(GSYVideoShotListener gSYVideoShotListener, boolean z)`  L123
- `void saveFrame(File file, GSYVideoShotSaveListener gSYVideoShotSaveListener)`  L130
- `void saveFrame(File file, boolean z, GSYVideoShotSaveListener gSYVideoShotSaveListener)`  L134
- `void onResume()`  L141
- `void onPause()`  L148
- `void releaseAll()`  L155
- `void setGLRenderMode(int i)`  L162
- `void setGLRenderer(GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender)`  L169
- `void setMatrixGL(float[] fArr)`  L176
- `void setEffectFilter(GSYVideoGLView.ShaderInterface shaderInterface)`  L183
- `void addToParent(ViewGroup viewGroup, View view)`  L190
- `int getTextureParams()`  L203
### `com.gku.ffm.zqvideo.render.view.GSYSurfaceView`
L26 · [class] public GSYSurfaceView · extends `SurfaceView implements SurfaceHolder.Callback2, IGSYRenderView, MeasureHelper.MeasureFormVideoParamsListener` · implements `SurfaceHolder.Callback2, IGSYRenderView, MeasureHelper.MeasureFormVideoParamsListener` · `com/gku/ffm/zqvideo/render/view/GSYSurfaceView.java`

字段/常量（11）：
- `IGSYSurfaceListener mIGSYSurfaceListener`  L27
- `MeasureHelper.MeasureFormVideoParamsListener mVideoParamsListener`  L28
- `MeasureHelper measureHelper`  L29
- `IGSYSurfaceListener iGSYSurfaceListener = this.mIGSYSurfaceListener`  L62
- `IGSYSurfaceListener iGSYSurfaceListener = this.mIGSYSurfaceListener`  L70
- `IGSYSurfaceListener iGSYSurfaceListener = this.mIGSYSurfaceListener`  L78
- `Bitmap bitmapInitCover`  L123
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L201
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L210
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L219
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L228

方法（32）：
- `View getRenderView()`  L32 @Override
- `void surfaceRedrawNeeded(SurfaceHolder surfaceHolder)`  L37 @Override
- `public GSYSurfaceView(Context context)`  L40
- `public GSYSurfaceView(Context context, AttributeSet attributeSet)`  L45
- `void init()`  L50
- `void onMeasure(int i, int i2)`  L55 @Override
- `void surfaceCreated(SurfaceHolder surfaceHolder)`  L61 @Override
- `void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3)`  L69 @Override
- `void surfaceDestroyed(SurfaceHolder surfaceHolder)`  L77 @Override
- `IGSYSurfaceListener getIGSYSurfaceListener()`  L85 @Override
- `void setIGSYSurfaceListener(IGSYSurfaceListener iGSYSurfaceListener)`  L90 @Override
- `int getSizeH()`  L96 @Override
- `int getSizeW()`  L101 @Override
- `Bitmap initCover()`  L106 @Override
- `Bitmap initCoverHigh()`  L114 @Override
- `void taskShotPic(final GSYVideoShotListener gSYVideoShotListener, boolean z)`  L122 @Override
- `void onPixelCopyFinished(int i)`  L134
    - 体内字面量：" Build.VERSION.SDK_INT < Build.VERSION_CODES.N not support taskShotPic now"
- `void saveFrame(File file, boolean z, GSYVideoShotSaveListener gSYVideoShotSaveListener)`  L150 @Override
    - 体内字面量：" not support saveFrame now, use taskShotPic"
- `void onRenderResume()`  L155 @Override
    - 体内字面量：" not support onRenderResume now"
- `void onRenderPause()`  L160 @Override
    - 体内字面量：" not support onRenderPause now"
- `void releaseRenderAll()`  L165 @Override
    - 体内字面量：" not support releaseRenderAll now"
- `void setRenderMode(int i)`  L170 @Override
    - 体内字面量：" not support setRenderMode now"
- `void setRenderTransform(Matrix matrix)`  L175 @Override
    - 体内字面量：" not support setRenderTransform now"
- `void setGLRenderer(GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender)`  L180 @Override
    - 体内字面量：" not support setGLRenderer now"
- `void setGLMVPMatrix(float[] fArr)`  L185 @Override
    - 体内字面量：" not support setGLMVPMatrix now"
- `void setGLEffectFilter(GSYVideoGLView.ShaderInterface shaderInterface)`  L190 @Override
    - 体内字面量：" not support setGLEffectFilter now"
- `void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener)`  L195 @Override
- `int getCurrentVideoWidth()`  L200 @Override
- `int getCurrentVideoHeight()`  L209 @Override
- `int getVideoSarNum()`  L218 @Override
- `int getVideoSarDen()`  L227 @Override
- `GSYSurfaceView addSurfaceView(Context context, ViewGroup viewGroup, int i, IGSYSurfaceListener iGSYSurfaceListener, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener)`  L235
### `com.gku.ffm.zqvideo.render.view.GSYTextureView`
L24 · [class] public GSYTextureView · extends `TextureView implements TextureView.SurfaceTextureListener, IGSYRenderView, MeasureHelper.MeasureFormVideoParamsListener` · implements `TextureView.SurfaceTextureListener, IGSYRenderView, MeasureHelper.MeasureFormVideoParamsListener` · `com/gku/ffm/zqvideo/render/view/GSYTextureView.java`

字段/常量（15）：
- `IGSYSurfaceListener mIGSYSurfaceListener`  L25
- `SurfaceTexture mSaveTexture`  L26
- `Surface mSurface`  L27
- `MeasureHelper.MeasureFormVideoParamsListener mVideoParamsListener`  L28
- `MeasureHelper measureHelper`  L29
- `SurfaceTexture surfaceTexture2 = this.mSaveTexture`  L59
- `IGSYSurfaceListener iGSYSurfaceListener = this.mIGSYSurfaceListener`  L66
- `IGSYSurfaceListener iGSYSurfaceListener2 = this.mIGSYSurfaceListener`  L75
- `IGSYSurfaceListener iGSYSurfaceListener = this.mIGSYSurfaceListener`  L83
- `IGSYSurfaceListener iGSYSurfaceListener = this.mIGSYSurfaceListener`  L91
- `IGSYSurfaceListener iGSYSurfaceListener = this.mIGSYSurfaceListener`  L100
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L219
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L228
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L237
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L246

方法（32）：
- `View getRenderView()`  L32 @Override
- `public GSYTextureView(Context context)`  L36
- `public GSYTextureView(Context context, AttributeSet attributeSet)`  L41
- `void init()`  L46
- `void onMeasure(int i, int i2)`  L51 @Override
- `void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2)`  L57 @Override
- `void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2)`  L82 @Override
- `boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture)`  L90 @Override
- `void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture)`  L99 @Override
- `IGSYSurfaceListener getIGSYSurfaceListener()`  L107 @Override
- `void setIGSYSurfaceListener(IGSYSurfaceListener iGSYSurfaceListener)`  L112 @Override
- `int getSizeH()`  L118 @Override
- `int getSizeW()`  L123 @Override
- `Bitmap initCover()`  L128 @Override
- `Bitmap initCoverHigh()`  L136 @Override
- `void taskShotPic(GSYVideoShotListener gSYVideoShotListener, boolean z)`  L144 @Override
- `void saveFrame(final File file, boolean z, final GSYVideoShotSaveListener gSYVideoShotSaveListener)`  L153 @Override
- `void getBitmap(Bitmap bitmap)`  L156 @Override
- `void onRenderResume()`  L173 @Override
    - 体内字面量：" not support onRenderResume now"
- `void onRenderPause()`  L178 @Override
    - 体内字面量：" not support onRenderPause now"
- `void releaseRenderAll()`  L183 @Override
    - 体内字面量：" not support releaseRenderAll now"
- `void setRenderMode(int i)`  L188 @Override
    - 体内字面量：" not support setRenderMode now"
- `void setRenderTransform(Matrix matrix)`  L193 @Override
- `void setGLRenderer(GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender)`  L198 @Override
    - 体内字面量：" not support setGLRenderer now"
- `void setGLMVPMatrix(float[] fArr)`  L203 @Override
    - 体内字面量：" not support setGLMVPMatrix now"
- `void setGLEffectFilter(GSYVideoGLView.ShaderInterface shaderInterface)`  L208 @Override
    - 体内字面量：" not support setGLEffectFilter now"
- `void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener)`  L213 @Override
- `int getCurrentVideoWidth()`  L218 @Override
- `int getCurrentVideoHeight()`  L227 @Override
- `int getVideoSarNum()`  L236 @Override
- `int getVideoSarDen()`  L245 @Override
- `GSYTextureView addTextureView(Context context, ViewGroup viewGroup, int i, IGSYSurfaceListener iGSYSurfaceListener, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener)`  L253
### `com.gku.ffm.zqvideo.render.view.GSYVideoGLView`
L26 · [class] public GSYVideoGLView · extends `GLSurfaceView implements GLSurfaceListener, IGSYRenderView, MeasureHelper.MeasureFormVideoParamsListener` · implements `GLSurfaceListener, IGSYRenderView, MeasureHelper.MeasureFormVideoParamsListener` · `com/gku/ffm/zqvideo/render/view/GSYVideoGLView.java`

字段/常量（21）：
- `int MODE_LAYOUT_SIZE = 0`  L27
- `int MODE_RENDER_SIZE = 1`  L28
- `String TAG = "com.gku.ffm.zqvideo.render.view.GSYVideoGLView"`  L29
- `Context mContext`  L30
- `ShaderInterface mEffect`  L31
- `IGSYSurfaceListener mIGSYSurfaceListener`  L32
- `float[] mMVPMatrix`  L33
- `int mMode`  L34
- `GLSurfaceListener mOnGSYSurfaceListener`  L35
- `GSYVideoGLViewBaseRender mRenderer`  L36
- `MeasureHelper.MeasureFormVideoParamsListener mVideoParamsListener`  L37
- `MeasureHelper measureHelper`  L38
- `GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender = this.mRenderer`  L74
- `IGSYSurfaceListener iGSYSurfaceListener = this.mIGSYSurfaceListener`  L105
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L207
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L216
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L225
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L234
- `MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener`  L242
- `GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender = this.mRenderer`  L249
- `GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender = this.mRenderer`  L311

方法（46）：
- `View getRenderView()`  L45 @Override
- `public GSYVideoGLView(Context context)`  L49
- `public GSYVideoGLView(Context context, AttributeSet attributeSet)`  L56
- `void init(Context context)`  L63
- `void onResume()`  L72 @Override
- `void onMeasure(int i, int i2)`  L81 @Override
- `IGSYSurfaceListener getIGSYSurfaceListener()`  L93 @Override
- `void setIGSYSurfaceListener(IGSYSurfaceListener iGSYSurfaceListener)`  L98 @Override
- `void onSurfaceAvailable(Surface surface)`  L104 @Override
- `int getSizeH()`  L112 @Override
- `int getSizeW()`  L117 @Override
- `Bitmap initCover()`  L122 @Override
    - 体内字面量：" not support initCover now"
- `Bitmap initCoverHigh()`  L128 @Override
    - 体内字面量：" not support initCoverHigh now"
- `void taskShotPic(GSYVideoShotListener gSYVideoShotListener, boolean z)`  L134 @Override
- `void saveFrame(final File file, boolean z, final GSYVideoShotSaveListener gSYVideoShotSaveListener)`  L142 @Override
- `void getBitmap(Bitmap bitmap)`  L145 @Override
- `void onRenderResume()`  L158 @Override
- `void onRenderPause()`  L164 @Override
- `void releaseRenderAll()`  L170 @Override
- `void setRenderMode(int i)`  L176 @Override
- `void setRenderTransform(Matrix matrix)`  L181 @Override
    - 体内字面量：" not support setRenderTransform now"
- `void setGLRenderer(GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender)`  L186 @Override
- `void setGLMVPMatrix(float[] fArr)`  L191 @Override
- `void setGLEffectFilter(ShaderInterface shaderInterface)`  L196 @Override
- `void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener)`  L201 @Override
- `int getCurrentVideoWidth()`  L206 @Override
- `int getCurrentVideoHeight()`  L215 @Override
- `int getVideoSarNum()`  L224 @Override
- `int getVideoSarDen()`  L233 @Override
- `void initRenderMeasure()`  L241
- `void initRender()`  L261
- `void setGSYVideoGLRenderErrorListener(GSYVideoGLRenderErrorListener gSYVideoGLRenderErrorListener)`  L265
- `void setCustomRenderer(GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender)`  L269
- `void setOnGSYSurfaceListener(GLSurfaceListener gLSurfaceListener)`  L275
- `void setEffect(ShaderInterface shaderInterface)`  L280
- `void setMVPMatrix(float[] fArr)`  L287
- `void takeShotPic()`  L294
- `void setGSYVideoShotListener(GSYVideoShotListener gSYVideoShotListener, boolean z)`  L298
- `int getMode()`  L302
- `void setMode(int i)`  L306
- `void releaseAll()`  L310
- `GSYVideoGLViewBaseRender getRenderer()`  L317
- `ShaderInterface getEffect()`  L321
- `float[] getMVPMatrix()`  L325
- `GSYVideoGLView addGLView(final Context context, final ViewGroup viewGroup, final int i, final IGSYSurfaceListener iGSYSurfaceListener, final MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener, ShaderInterface shaderInterface, float[] fArr, GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender, final int i2)`  L329
- `void onError(GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender2, String str, int i3, boolean z)`  L345 @Override
### `com.gku.ffm.zqvideo.render.view.GSYVideoGLView$ShaderInterface`
L40 · [interface] public ShaderInterface · `com/gku/ffm/zqvideo/render/view/GSYVideoGLView.java`

方法（1）：
- `String getShader(GLSurfaceView gLSurfaceView)`  L41
### `com.gku.ffm.zqvideo.render.view.IGSYRenderView`
L14 · [interface] public IGSYRenderView · `com/gku/ffm/zqvideo/render/view/IGSYRenderView.java`

方法（18）：
- `IGSYSurfaceListener getIGSYSurfaceListener()`  L15
- `View getRenderView()`  L17
- `int getSizeH()`  L19
- `int getSizeW()`  L21
- `Bitmap initCover()`  L23
- `Bitmap initCoverHigh()`  L25
- `void onRenderPause()`  L27
- `void onRenderResume()`  L29
- `void releaseRenderAll()`  L31
- `void saveFrame(File file, boolean z, GSYVideoShotSaveListener gSYVideoShotSaveListener)`  L33
- `void setGLEffectFilter(GSYVideoGLView.ShaderInterface shaderInterface)`  L35
- `void setGLMVPMatrix(float[] fArr)`  L37
- `void setGLRenderer(GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender)`  L39
- `void setIGSYSurfaceListener(IGSYSurfaceListener iGSYSurfaceListener)`  L41
- `void setRenderMode(int i)`  L43
- `void setRenderTransform(Matrix matrix)`  L45
- `void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener)`  L47
- `void taskShotPic(GSYVideoShotListener gSYVideoShotListener, boolean z)`  L49
### `com.gku.ffm.zqvideo.render.view.listener.GLSurfaceListener`
L6 · [interface] public GLSurfaceListener · `com/gku/ffm/zqvideo/render/view/listener/GLSurfaceListener.java`

方法（1）：
- `void onSurfaceAvailable(Surface surface)`  L7
### `com.gku.ffm.zqvideo.render.view.listener.GSYVideoGLRenderErrorListener`
L6 · [interface] public GSYVideoGLRenderErrorListener · `com/gku/ffm/zqvideo/render/view/listener/GSYVideoGLRenderErrorListener.java`

方法（1）：
- `void onError(GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender, String str, int i, boolean z)`  L7
### `com.gku.ffm.zqvideo.render.view.listener.IGSYSurfaceListener`
L6 · [interface] public IGSYSurfaceListener · `com/gku/ffm/zqvideo/render/view/listener/IGSYSurfaceListener.java`

方法（4）：
- `void onSurfaceAvailable(Surface surface)`  L7
- `boolean onSurfaceDestroyed(Surface surface)`  L9
- `void onSurfaceSizeChanged(Surface surface, int i, int i2)`  L11
- `void onSurfaceUpdated(Surface surface)`  L13
### `com.gku.ffm.zqvideo.utils.AnimatedGifEncoder`
L12 · [class] public AnimatedGifEncoder · `com/gku/ffm/zqvideo/utils/AnimatedGifEncoder.java`

字段/常量（55）：
- `int colorDepth`  L13
- `byte[] colorTab`  L14
- `int height`  L15
- `Bitmap image`  L16
- `byte[] indexedPixels`  L17
- `OutputStream out`  L18
- `byte[] pixels`  L19
- `int transIndex`  L20
- `int width`  L21
- `int x = 0`  L22
- `int y = 0`  L23
- `int transparent = -1`  L24
- `int repeat = -1`  L25
- `int delay = 0`  L26
- `boolean started = false`  L27
- `boolean[] usedEntry = new boolean[256]`  L28
- `int palSize = 7`  L29
- `int dispose = -1`  L30
- `boolean closeStream = false`  L31
- `boolean firstFrame = true`  L32
- `boolean sizeSet = false`  L33
- `int sample = 10`  L34
- `boolean z`  L87
- `boolean z = false`  L144
- `int length = this.pixels.length`  L160
- `int i = length / 3`  L161
- `int i2 = 0`  L165
- `byte[] bArr = this.colorTab`  L167
- `byte b = bArr[i2]`  L171
- `int i3 = i2 + 2`  L172
- `int i4 = 0`  L178
- `byte[] bArr2 = this.pixels`  L180
- `int i6 = bArr2[i4] & 255`  L181
- `int i7 = i4 + 2`  L182
- `int i8 = bArr2[i4 + 1] & 255`  L183
- `int i9 = this.transparent`  L192
- `byte[] bArr = this.colorTab`  L199
- `int i4 = i & 255`  L205
- `int length = bArr.length`  L206
- `int i5 = 16777216`  L207
- `int i6 = 0`  L208
- `byte[] bArr2 = this.colorTab`  L210
- `int i9 = i7 + 2`  L212
- `int i13 = i9 / 3`  L216
- `int i = this.width`  L228
- `int i3 = imageData[i2]`  L237
- `int i4 = i2 * 3`  L238
- `byte[] bArr = this.pixels`  L239
- `int[] iArr = new int[width * height]`  L249
- `int i`  L255
- `int i2`  L256
- `int i3 = this.dispose`  L267
- `OutputStream outputStream = this.out`  L310
- `byte[] bArr = this.colorTab`  L311
- `int length = 768 - this.colorTab.length`  L313

方法（23）：
- `void setDelay(int i)`  L36
- `void setDispose(int i)`  L40
- `void setRepeat(int i)`  L46
- `void setTransparent(int i)`  L52
- `boolean addFrame(Bitmap bitmap)`  L56
- `boolean finish()`  L86
- `void setFrameRate(float f)`  L113
- `void setQuality(int i)`  L119
- `void setSize(int i, int i2)`  L126
- `void setPosition(int i, int i2)`  L138
- `boolean start(OutputStream outputStream)`  L143
- `void analyzePixels()`  L159
- `int findClosest(int i)`  L198
- `void getImagePixels()`  L225
- `int[] getImageData(Bitmap bitmap)`  L246
- `void writeGraphicCtrlExt()`  L254
- `void writeImageDesc()`  L277
- `void writeLSD()`  L290
- `void writeNetscapeExt()`  L298
    - 体内字面量："NETSCAPE2.0"
- `void writePalette()`  L309
- `void writePixels()`  L319
- `void writeShort(int i)`  L323
- `void writeString(String str)`  L328
### `com.gku.ffm.zqvideo.utils.CommonUtil`
L24 · [class] public CommonUtil · `com/gku/ffm/zqvideo/utils/CommonUtil.java`

字段/常量（7）：
- `long j2 = j / 1000`  L26
- `long j3 = j2 % 60`  L27
- `long j5 = j2 / AuthConstant.TSC_VALID_TIME_SECONDS`  L29
- `AppCompatActivity appCompActivity`  L75
- `ActionBar supportActionBar`  L76
- `AppCompatActivity appCompActivity`  L93
- `ActionBar supportActionBar`  L94

方法（19）：
- `String stringForTime(long j)`  L25
- `boolean isWifiConnected(Context context)`  L34
    - 体内字面量："connectivity"
- `Activity scanForActivity(Context context)`  L42
- `int getStatusBarHeight(Context context)`  L58
    - 体内字面量："status_bar_height" · "dimen" · "android"
- `int getActionBarHeight(Activity activity)`  L66
- `void hideSupportActionBar(Context context, boolean z, boolean z2)`  L74
- `void showSupportActionBar(Context context, boolean z, boolean z2)`  L92
- `void hideNavKey(Context context)`  L110
- `void showNavKey(Context context, int i)`  L121
- `AppCompatActivity getAppCompActivity(Context context)`  L125
- `Activity getActivityNestWrapper(Context context)`  L138
- `int dip2px(Context context, float f)`  L142
- `int px2dip(Context context, float f)`  L146
- `int getScreenWidth(Context context)`  L150
    - 体内字面量："window"
- `int getScreenHeight(Context context)`  L157
    - 体内字面量："window"
- `String getTextSpeed(long j)`  L164
    - 体内字面量：" KB/s" · " KB/s" · " MB/s"
- `void deleteFile(String str)`  L177
- `Activity getActivityContext(Context context)`  L191
- `boolean getCurrentScreenLand(Activity activity)`  L207
### `com.gku.ffm.zqvideo.utils.Debuger`
L9 · [class] public Debuger · `com/gku/ffm/zqvideo/utils/Debuger.java`

字段/常量（2）：
- `boolean DEBUG_TAG = false`  L10
- `String LOG_TAG = "GSYVideoPlayer"`  L11

方法（11）：
- `void enable()`  L13
- `void disable()`  L17
- `boolean getDebugMode()`  L21
- `void printfLog(String str, String str2)`  L25
- `void printfLog(String str)`  L32
- `void printfWarning(String str, String str2)`  L36
- `void printfWarning(String str)`  L43
- `void printfError(String str)`  L47
- `void printfError(String str, String str2)`  L54
- `void printfError(String str, Exception exc)`  L61
- `void Toast(Activity activity, String str)`  L70
### `com.gku.ffm.zqvideo.utils.FileUtils`
L10 · [class] public FileUtils · `com/gku/ffm/zqvideo/utils/FileUtils.java`

字段/常量（2）：
- `String NAME = "GSYVideo"`  L11
- `String NAME_TEST = "GSYVideoTest"`  L12

方法（5）：
- `String getAppPath(String str)`  L15
- `String getPath()`  L19
- `String getTestPath()`  L28
- `void deleteFiles(File file)`  L37
- `void saveBitmap(Bitmap bitmap, File file)`  L52
### `com.gku.ffm.zqvideo.utils.GifCreateHelper`
L19 · [class] public GifCreateHelper · `com/gku/ffm/zqvideo/utils/GifCreateHelper.java`

字段/常量（15）：
- `int mDelay`  L20
- `int mFrequencyCount`  L21
- `GSYVideoGifSaveListener mGSYVideoGifSaveListener`  L22
- `List<String> mPicList`  L23
- `StandardGSYVideoPlayer mPlayer`  L24
- `int mSampleSize`  L25
- `boolean mSaveShotBitmapSuccess`  L26
- `int mScaleSize`  L27
- `Timer mTimer`  L28
- `TaskLocal mTimerTask`  L29
- `File mTmpPath`  L30
- `GifCreateHelper gifCreateHelper = GifCreateHelper.this`  L66
- `TaskLocal taskLocal = this.mTimerTask`  L74
- `int i4 = 0`  L101
- `double d = i3`  L107

方法（9）：
- `public GifCreateHelper(StandardGSYVideoPlayer standardGSYVideoPlayer, GSYVideoGifSaveListener gSYVideoGifSaveListener)`  L32
- `public GifCreateHelper(StandardGSYVideoPlayer standardGSYVideoPlayer, GSYVideoGifSaveListener gSYVideoGifSaveListener, int i, int i2, int i3, int i4)`  L36
- `void startGif(File file)`  L48
- `void stopGif(final File file)`  L57
- `void run()`  L62 @Override
- `void cancelTask()`  L73
- `void startSaveBitmap()`  L82
    - 体内字面量："GSY-TMP-FRAME" · ".tmp"
- `void result(boolean z, File file)`  L85 @Override
    - 体内字面量：" SUCCESS CREATE FILE "
- `void createGif(File file, List<String> list, int i, int i2, int i3, GSYVideoGifSaveListener gSYVideoGifSaveListener)`  L95
### `com.gku.ffm.zqvideo.utils.GifCreateHelper$TaskLocal`
L134 · [class] private TaskLocal · extends `TimerTask` · `com/gku/ffm/zqvideo/utils/GifCreateHelper.java`

方法（2）：
- `private TaskLocal()`  L135
- `void run()`  L139 @Override
### `com.gku.ffm.zqvideo.utils.GSYVideoHelper`
L26 · [class] public GSYVideoHelper · `com/gku/ffm/zqvideo/utils/GSYVideoHelper.java`

字段/常量（32）：
- `String TAG`  L27
- `boolean isFull`  L28
- `boolean isSmall`  L29
- `Context mContext`  L30
- `ViewGroup mFullViewContainer`  L31
- `StandardGSYVideoPlayer mGsyVideoPlayer`  L32
- `Handler mHandler`  L33
- `int[] mNormalItemRect`  L34
- `int[] mNormalItemSize`  L35
- `ViewGroup.LayoutParams mNormalParams`  L36
- `OrientationOption mOrientationOption`  L37
- `OrientationUtils mOrientationUtils`  L38
- `ViewGroup mParent`  L39
- `int mPlayPosition`  L40
- `int mSystemUiVisibility`  L41
- `GSYVideoHelperBuilder mVideoOptionBuilder`  L42
- `ViewGroup mWindowViewContainer`  L43
- `GSYVideoHelper gSYVideoHelper = GSYVideoHelper.this`  L80
- `ViewGroup viewGroup`  L97
- `ViewGroup viewGroup2 = this.mFullViewContainer`  L102
- `int[] iArr = this.mNormalItemSize`  L117
- `int[] iArr2 = this.mNormalItemRect`  L119
- `ViewGroup viewGroup = this.mFullViewContainer`  L122
- `GSYVideoHelper gSYVideoHelper = GSYVideoHelper.this`  L136
- `ViewGroup viewGroup = this.mFullViewContainer`  L235
- `int[] iArr = this.mNormalItemRect`  L255
- `int[] iArr2 = this.mNormalItemRect`  L259
- `ViewGroup viewGroup = this.mWindowViewContainer`  L276
- `GSYVideoHelperBuilder gSYVideoHelperBuilder = this.mVideoOptionBuilder`  L313
- `ViewGroup viewGroup = this.mFullViewContainer`  L344
- `ViewGroup viewGroup2 = this.mWindowViewContainer`  L349
- `OrientationUtils orientationUtils = this.mOrientationUtils`  L365

方法（37）：
- `public GSYVideoHelper(Context context)`  L45
- `public GSYVideoHelper(Context context, StandardGSYVideoPlayer standardGSYVideoPlayer)`  L49
    - 体内字面量："NULL"
- `void resolveToFull()`  L58
- `void onClick(View view)`  L79 @Override
- `void resolveFullAdd()`  L96
- `void resolveMaterialAnimation()`  L110
- `void run()`  L130 @Override
- `void resolveMaterialFullVideoShow(GSYBaseVideoPlayer gSYBaseVideoPlayer)`  L144
- `void resolveToNormal()`  L155
- `void run()`  L162 @Override
    - 体内字面量："onQuitFullscreen"
- `void resolveMaterialToNormal(final GSYVideoPlayer gSYVideoPlayer)`  L194
- `void run()`  L198 @Override
- `void run()`  L208 @Override
- `void resolveChangeFirstLogic(int i)`  L220
- `void run()`  L225 @Override
- `void saveLocationStatus(Context context, boolean z, boolean z2)`  L250
- `boolean isPlayView(int i, String str)`  L266
- `boolean isCurrentViewPlaying(int i, String str)`  L270
- `boolean removeWindowContainer()`  L275
- `void addVideoPlayer(int i, View view, String str, ViewGroup viewGroup, View view2)`  L284
- `void setPlayPositionAndTag(int i, String str)`  L303
- `void startPlay()`  L308
- `void onClick(View view)`  L327 @Override
- `void doFullBtnLogic()`  L335
- `boolean backFromFull()`  L343
- `void releaseVideoPlayer()`  L357
    - 体内字面量："NULL"
- `void showSmallVideo(Point point, boolean z, boolean z2)`  L371
- `void smallVideoToNormal()`  L378
- `void setFullViewContainer(ViewGroup viewGroup)`  L383
- `void setOrientationOption(OrientationOption orientationOption)`  L387
- `boolean isFull()`  L391
- `void setGsyVideoOptionBuilder(GSYVideoHelperBuilder gSYVideoHelperBuilder)`  L395
- `GSYVideoOptionBuilder getGsyVideoOptionBuilder()`  L399
- `int getPlayPosition()`  L403
- `String getPlayTAG()`  L407
- `boolean isSmall()`  L411
- `StandardGSYVideoPlayer getGsyVideoPlayer()`  L415
### `com.gku.ffm.zqvideo.utils.GSYVideoHelper$GSYVideoHelperBuilder`
L419 · [class] public static GSYVideoHelperBuilder · extends `GSYVideoOptionBuilder` · `com/gku/ffm/zqvideo/utils/GSYVideoHelper.java`

字段/常量（2）：
- `boolean mHideActionBar`  L420
- `boolean mHideStatusBar`  L421

方法（43）：
- `boolean isHideActionBar()`  L423
- `GSYVideoHelperBuilder setHideActionBar(boolean z)`  L427
- `boolean isHideStatusBar()`  L432
- `GSYVideoHelperBuilder setHideStatusBar(boolean z)`  L436
- `int getShrinkImageRes()`  L441
- `int getEnlargeImageRes()`  L445
- `int getPlayPosition()`  L449
- `int getDialogProgressHighLightColor()`  L453
- `int getDialogProgressNormalColor()`  L457
- `int getDismissControlTime()`  L461
- `long getSeekOnStart()`  L465
- `float getSeekRatio()`  L469
- `float getSpeed()`  L473
- `boolean isHideKey()`  L477
- `boolean isShowFullAnimation()`  L481
- `boolean isNeedShowWifiTip()`  L485
- `boolean isRotateViewAuto()`  L489
- `boolean isLockLand()`  L493
- `boolean isLooping()`  L497
- `boolean isIsTouchWiget()`  L501
- `boolean isIsTouchWigetFull()`  L505
- `boolean isShowPauseCover()`  L509
- `boolean isRotateWithSystem()`  L513
- `boolean isCacheWithPlay()`  L517
- `boolean isNeedLockFull()`  L521
- `boolean isThumbPlay()`  L525
- `boolean isSounchTouch()`  L529
- `boolean isSetUpLazy()`  L533
- `String getPlayTag()`  L537
- `String getUrl()`  L541
- `String getVideoTitle()`  L545
- `File getCachePath()`  L549
- `Map<String, String> getMapHeadData()`  L553
- `VideoAllCallBack getVideoAllCallBack()`  L557
- `LockClickListener getLockClickListener()`  L561
- `View getThumbImageView()`  L565
- `Drawable getBottomProgressDrawable()`  L569
- `Drawable getBottomShowProgressDrawable()`  L573
- `Drawable getBottomShowProgressThumbDrawable()`  L577
- `Drawable getVolumeProgressDrawable()`  L581
- `Drawable getDialogProgressBarDrawable()`  L585
- `GSYVideoGLView.ShaderInterface getEffectFilter()`  L589
- `GSYVideoProgressListener getGSYVideoProgressListener()`  L593
### `com.gku.ffm.zqvideo.utils.GSYVideoType`
L4 · [class] public GSYVideoType · `com/gku/ffm/zqvideo/utils/GSYVideoType.java`

字段/常量（15）：
- `int GLSURFACE = 2`  L5
- `boolean MEDIA_CODEC_FLAG = false`  L6
- `int SCREEN_MATCH_FULL = -4`  L7
- `int SCREEN_TYPE_16_9 = 1`  L8
- `int SCREEN_TYPE_18_9 = 6`  L9
- `int SCREEN_TYPE_4_3 = 2`  L10
- `int SCREEN_TYPE_CUSTOM = -5`  L11
- `int SCREEN_TYPE_DEFAULT = 0`  L12
- `int SCREEN_TYPE_FULL = 4`  L13
- `int SUFRACE = 1`  L14
- `int TEXTURE = 0`  L15
- `int TYPE = 0`  L16
- `int sRenderType = 0`  L17
- `float sScreenScaleRatio = 0.0f`  L18
- `boolean sTextureMediaPlay = false`  L19

方法（12）：
- `void enableMediaCodec()`  L21
- `void disableMediaCodec()`  L25
- `void enableMediaCodecTexture()`  L29
- `void disableMediaCodecTexture()`  L33
- `boolean isMediaCodec()`  L37
- `boolean isMediaCodecTexture()`  L41
- `int getShowType()`  L45
- `void setShowType(int i)`  L49
- `int getRenderType()`  L53
- `void setRenderType(int i)`  L57
- `float getScreenScaleRatio()`  L61
- `void setScreenScaleRatio(float f)`  L65
### `com.gku.ffm.zqvideo.utils.ListVideoUtil`
L22 · [class] public ListVideoUtil · `com/gku/ffm/zqvideo/utils/ListVideoUtil.java`
注解：@Deprecated

字段/常量（35）：
- `File cachePath`  L23
- `Context context`  L24
- `ViewGroup fullViewContainer`  L25
- `StandardGSYVideoPlayer gsyVideoPlayer`  L26
- `boolean hideActionBar`  L27
- `boolean hideStatusBar`  L28
- `boolean isFull`  L29
- `boolean isLoop`  L30
- `boolean isSmall`  L31
- `int[] listItemRect`  L32
- `int[] listItemSize`  L33
- `ViewGroup.LayoutParams listParams`  L34
- `ViewGroup listParent`  L35
- `String mTitle`  L36
- `Map<String, String> mapHeadData`  L37
- `OrientationUtils orientationUtils`  L38
- `int systemUiVisibility`  L39
- `String url`  L40
- `VideoAllCallBack videoAllCallBack`  L41
- `String TAG = "NULL"`  L42
- `int playPosition = -1`  L43
- `int speed = 1`  L44
- `boolean hideKey = true`  L45
- `boolean needLockFull = true`  L46
- `boolean needShowWifiTip = true`  L47
- `boolean fullLandFrist = true`  L48
- `boolean autoRotation = true`  L49
- `boolean showFullAnimation = true`  L50
- `ListVideoUtil listVideoUtil = ListVideoUtil.this`  L140
- `int[] iArr = this.listItemSize`  L169
- `int[] iArr2 = this.listItemRect`  L171
- `ListVideoUtil listVideoUtil = ListVideoUtil.this`  L179
- `int[] iArr = this.listItemRect`  L276
- `int[] iArr2 = this.listItemRect`  L280
- `OrientationUtils orientationUtils = this.orientationUtils`  L310

方法（61）：
- `public ListVideoUtil(Context context)`  L53
- `void addVideoPlayer(int i, View view, String str, ViewGroup viewGroup, View view2)`  L58
- `void setPlayPositionAndTag(int i, String str)`  L77
- `void startPlay(String str)`  L82
- `void onClick(View view)`  L100 @Override
- `void resolveFullBtn()`  L107
- `void resolveToFull()`  L118
- `void onClick(View view)`  L139 @Override
- `void resolveFullAdd()`  L156
- `void resolveMaterialAnimation()`  L162
- `void run()`  L177 @Override
- `void resolveMaterialFullVideoShow(GSYBaseVideoPlayer gSYBaseVideoPlayer)`  L187
- `void resolveToNormal()`  L198
- `void run()`  L201 @Override
    - 体内字面量："onQuitFullscreen"
- `void resolveMaterialToNormal(final GSYVideoPlayer gSYVideoPlayer)`  L227
- `void run()`  L231 @Override
- `void run()`  L241 @Override
- `void resolveChangeFirstLogic(int i)`  L253
- `void run()`  L257 @Override
    - 体内字面量："onEnterFullscreen"
- `void saveLocationStatus(Context context, boolean z, boolean z2)`  L271
- `boolean isPlayView(int i, String str)`  L287
- `boolean isCurrentViewPlaying(int i, String str)`  L291
- `boolean backFromFull()`  L295
- `void releaseVideoPlayer()`  L303
    - 体内字面量："NULL"
- `void showSmallVideo(Point point, boolean z, boolean z2)`  L316
- `void smallVideoToNormal()`  L323
- `void setFullViewContainer(ViewGroup viewGroup)`  L328
- `boolean isFull()`  L332
- `void setAutoRotation(boolean z)`  L336
- `boolean isAutoRotation()`  L340
- `void setFullLandFrist(boolean z)`  L344
- `boolean isFullLandFrist()`  L348
- `void setShowFullAnimation(boolean z)`  L352
- `boolean isShowFullAnimation()`  L356
- `boolean isHideStatusBar()`  L360
- `void setHideStatusBar(boolean z)`  L364
- `boolean isHideActionBar()`  L368
- `void setHideActionBar(boolean z)`  L372
- `void setVideoAllCallBack(VideoAllCallBack videoAllCallBack)`  L376
- `int getPlayPosition()`  L381
- `String getPlayTAG()`  L385
- `boolean isSmall()`  L389
- `boolean isLoop()`  L393
- `void setLoop(boolean z)`  L397
- `long getDuration()`  L401
- `int getSpeed()`  L405
- `void setSpeed(int i)`  L409
- `File getCachePath()`  L413
- `void setCachePath(File file)`  L417
- `String getTitle()`  L421
- `void setTitle(String str)`  L425
- `Map<String, String> getMapHeadData()`  L429
- `void setMapHeadData(Map<String, String> map)`  L433
- `long getCurrentPositionWhenPlaying()`  L437
- `StandardGSYVideoPlayer getGsyVideoPlayer()`  L441
- `boolean isHideKey()`  L445
- `void setHideKey(boolean z)`  L449
- `boolean isNeedLockFull()`  L453
- `void setNeedLockFull(boolean z)`  L457
- `boolean isNeedShowWifiTip()`  L461
- `void setNeedShowWifiTip(boolean z)`  L465
### `com.gku.ffm.zqvideo.utils.LZWEncoder`
L10 · [class] LZWEncoder · `com/gku/ffm/zqvideo/utils/LZWEncoder.java`

字段/常量（48）：
- `int BITS = 12`  L11
- `int EOF = -1`  L12
- `int HSIZE = 5003`  L13
- `int ClearCode`  L14
- `int EOFCode`  L15
- `int a_count`  L16
- `int curPixel`  L17
- `int g_init_bits`  L18
- `int imgH`  L19
- `int imgW`  L20
- `int initCodeSize`  L21
- `int maxcode`  L22
- `int n_bits`  L23
- `byte[] pixAry`  L24
- `int remaining`  L25
- `int maxbits = 12`  L26
- `int maxmaxcode = 4096`  L27
- `int[] htab = new int[HSIZE]`  L28
- `int[] codetab = new int[HSIZE]`  L29
- `int hsize = HSIZE`  L30
- `int free_ent = 0`  L31
- `boolean clear_flg = false`  L32
- `int cur_accum = 0`  L33
- `int cur_bits = 0`  L34
- `int[] masks = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, 1023, 2047, 4095, HmsScanBase.ALL_SCAN_TYPE, 16383, 32767, 65535}`  L35
- `byte[] accum = new byte[256]`  L36
- `byte[] bArr = this.accum`  L50
- `int i = this.a_count`  L51
- `int i2 = i + 1`  L52
- `int i = this.ClearCode`  L62
- `int i2 = 0`  L76
- `int i5 = 8 - i2`  L89
- `int i6 = this.hsize`  L90
- `int i9 = this.htab[i8]`  L98
- `int i10 = i6 - i8`  L103
- `int i11 = this.htab[i8]`  L112
- `int i12 = this.free_ent`  L120
- `int[] iArr = this.codetab`  L122
- `int i = this.a_count`  L148
- `int i = this.remaining`  L157
- `byte[] bArr = this.pixAry`  L162
- `int i2 = this.curPixel`  L163
- `int i2 = this.cur_accum`  L169
- `int[] iArr = this.masks`  L170
- `int i3 = this.cur_bits`  L171
- `int i4 = i2 & iArr[i3]`  L172
- `int i5 = this.g_init_bits`  L187
- `int i6 = this.n_bits + 1`  L192

方法（9）：
- `int MAXCODE(int i)`  L38
- `void char_out(byte b, OutputStream outputStream)`  L49
- `void cl_block(OutputStream outputStream)`  L60
- `void cl_hash(int i)`  L68
- `void compress(int i, OutputStream outputStream)`  L74
- `void encode(OutputStream outputStream)`  L139
- `void flush_char(OutputStream outputStream)`  L147
- `int nextPixel()`  L156
- `void output(int i, OutputStream outputStream)`  L168
### `com.gku.ffm.zqvideo.utils.MeasureHelper`
L7 · [class] public final MeasureHelper · `com/gku/ffm/zqvideo/utils/MeasureHelper.java`

字段/常量（33）：
- `int mCurrentAspectRatio = 0`  L8
- `int mMeasuredHeight`  L9
- `int mMeasuredWidth`  L10
- `MeasureFormVideoParamsListener mParamsListener`  L11
- `int mVideoHeight`  L12
- `int mVideoRotationDegree`  L13
- `int mVideoSarDen`  L14
- `int mVideoSarNum`  L15
- `int mVideoWidth`  L16
- `WeakReference<View> mWeakView`  L17
- `WeakReference<View> weakReference = this.mWeakView`  L35
- `int i3`  L60
- `int i4`  L61
- `float f`  L62
- `int i5`  L63
- `int i6`  L64
- `int i7 = this.mVideoRotationDegree`  L71
- `int i8 = this.mVideoSarNum`  L76
- `float f2 = i`  L92
- `float f3 = i2`  L93
- `float f4 = f2 / f3`  L94
- `int i9 = this.mCurrentAspectRatio`  L95
- `int i10 = this.mVideoRotationDegree`  L98
- `int i11 = this.mVideoRotationDegree`  L101
- `int i12 = this.mVideoRotationDegree`  L104
- `int i13 = this.mVideoRotationDegree`  L107
- `int i14 = this.mVideoSarNum`  L111
- `boolean z = f > f4`  L116
- `int i15 = this.mCurrentAspectRatio`  L117
- `int i16 = i3 * i2`  L145
- `int i17 = this.mVideoHeight`  L146
- `int i20 = this.mVideoHeight`  L163
- `MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mParamsListener`  L183

方法（10）：
- `public MeasureHelper(View view, MeasureFormVideoParamsListener measureFormVideoParamsListener)`  L29
- `View getView()`  L34
- `void setVideoSize(int i, int i2)`  L42
- `void setVideoSampleAspectRatio(int i, int i2)`  L47
- `void setVideoRotation(int i)`  L52
- `void doMeasure(int i, int i2)`  L59
- `void prepareMeasure(int i, int i2, int i3)`  L182
- `int getMeasuredWidth()`  L203
- `int getMeasuredHeight()`  L207
- `void setAspectRatio(int i)`  L211
### `com.gku.ffm.zqvideo.utils.MeasureHelper$MeasureFormVideoParamsListener`
L19 · [interface] public MeasureFormVideoParamsListener · `com/gku/ffm/zqvideo/utils/MeasureHelper.java`

方法（4）：
- `int getCurrentVideoHeight()`  L20
- `int getCurrentVideoWidth()`  L22
- `int getVideoSarDen()`  L24
- `int getVideoSarNum()`  L26
### `com.gku.ffm.zqvideo.utils.NetInfoModule`
L13 · [class] public NetInfoModule · `com/gku/ffm/zqvideo/utils/NetInfoModule.java`

字段/常量（11）：
- `String CONNECTION_TYPE_NONE = "NONE"`  L14
- `String CONNECTION_TYPE_UNKNOWN = "UNKNOWN"`  L15
- `String ERROR_MISSING_PERMISSION = "E_MISSING_PERMISSION"`  L16
- `String MISSING_PERMISSION_MESSAGE = "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />"`  L17
- `ConnectivityManager mConnectivityManager`  L18
- `Context mContext`  L19
- `NetChangeListener mNetChangeListener`  L20
- `String mConnectivity = "<binary/metadata>"`  L21
- `boolean mNoNetworkPermission = false`  L22
- `String upperCase = "UNKNOWN"`  L85
- `NetChangeListener netChangeListener = this.mNetChangeListener`  L103

方法（11）：
- `void onHostDestroy()`  L29
- `public NetInfoModule(Context context, NetChangeListener netChangeListener)`  L32
    - 体内字面量："connectivity"
- `void onHostResume()`  L38
- `void onHostPause()`  L42
- `String getCurrentConnectivity()`  L46
- `boolean isConnectionMetered()`  L53
- `void registerReceiver()`  L60
- `void unregisterReceiver()`  L67
- `void updateAndSendConnectionType()`  L75
- `String getCurrentConnectionType()`  L84
- `void sendConnectivityChangedEvent()`  L102
### `com.gku.ffm.zqvideo.utils.NetInfoModule$ConnectivityBroadcastReceiver`
L109 · [class] private ConnectivityBroadcastReceiver · extends `BroadcastReceiver` · `com/gku/ffm/zqvideo/utils/NetInfoModule.java`

字段/常量（1）：
- `boolean isRegistered`  L110

方法（4）：
- `private ConnectivityBroadcastReceiver()`  L112
- `void setRegistered(boolean z)`  L116
- `boolean isRegistered()`  L120
- `void onReceive(Context context, Intent intent)`  L125 @Override
### `com.gku.ffm.zqvideo.utils.NetInfoModule$NetChangeListener`
L25 · [interface] public NetChangeListener · `com/gku/ffm/zqvideo/utils/NetInfoModule.java`

方法（1）：
- `void changed(String str)`  L26
### `com.gku.ffm.zqvideo.utils.NetworkUtils`
L10 · [class] public NetworkUtils · `com/gku/ffm/zqvideo/utils/NetworkUtils.java`

字段/常量（9）：
- `int NETWORK_2G = 2`  L11
- `int NETWORK_3G = 3`  L12
- `int NETWORK_4G = 4`  L13
- `int NETWORK_NO = -1`  L14
- `int NETWORK_TYPE_GSM = 16`  L15
- `int NETWORK_TYPE_IWLAN = 18`  L16
- `int NETWORK_TYPE_TD_SCDMA = 17`  L17
- `int NETWORK_UNKNOWN = 5`  L18
- `int NETWORK_WIFI = 1`  L19

方法（11）：
- `private NetworkUtils()`  L21
- `void openWirelessSettings(Context context)`  L24
    - 体内字面量："android.settings.SETTINGS"
- `NetworkInfo getActiveNetworkInfo(Context context)`  L28
    - 体内字面量："connectivity"
- `boolean isAvailable(Context context)`  L32
- `boolean isConnected(Context context)`  L37
- `boolean is4G(Context context)`  L42
- `boolean isWifiConnected(Context context)`  L47
    - 体内字面量："connectivity"
- `String getNetworkOperatorName(Context context)`  L52
    - 体内字面量："phone"
- `int getPhoneType(Context context)`  L60
    - 体内字面量："phone"
- `int getNetWorkType(Context context)`  L68
    - 体内字面量："TD-SCDMA" · "WCDMA" · "CDMA2000"
- `String getNetWorkTypeName(Context context)`  L107
    - 体内字面量："NETWORK_NO" · "NETWORK_WIFI" · "NETWORK_2G" · "NETWORK_3G" · "NETWORK_4G" · "NETWORK_UNKNOWN"
### `com.gku.ffm.zqvideo.utils.NeuQuant`
L5 · [class] NeuQuant · `com/gku/ffm/zqvideo/utils/NeuQuant.java`

字段/常量（126）：
- `int alphabiasshift = 10`  L6
- `int alpharadbias = 262144`  L7
- `int alpharadbshift = 18`  L8
- `int beta = 64`  L9
- `int betagamma = 65536`  L10
- `int betashift = 10`  L11
- `int gamma = 1024`  L12
- `int gammashift = 10`  L13
- `int initalpha = 1024`  L14
- `int initrad = 32`  L15
- `int initradius = 2048`  L16
- `int intbias = 65536`  L17
- `int intbiasshift = 16`  L18
- `int maxnetpos = 255`  L19
- `int minpicturebytes = 1509`  L20
- `int ncycles = 100`  L21
- `int netbiasshift = 4`  L22
- `int netsize = 256`  L23
- `int prime1 = 499`  L24
- `int prime2 = 491`  L25
- `int prime3 = 487`  L26
- `int prime4 = 503`  L27
- `int radbias = 256`  L28
- `int radbiasshift = 8`  L29
- `int radiusbias = 64`  L30
- `int radiusbiasshift = 6`  L31
- `int radiusdec = 30`  L32
- `int alphadec`  L33
- `int lengthcount`  L34
- `int samplefac`  L35
- `byte[] thepicture`  L36
- `int[] netindex = new int[256]`  L37
- `int[] bias = new int[256]`  L38
- `int[] freq = new int[256]`  L39
- `int[] radpower = new int[32]`  L40
- `int[][] network = new int[256][]`  L41
- `byte[] bArr = new byte[768]`  L56
- `int[] iArr = new int[256]`  L57
- `int i2 = 0`  L61
- `int[] iArr2 = this.network[iArr[i3]]`  L63
- `int i4 = i2 + 2`  L65
- `int i = 0`  L74
- `int i2 = 0`  L75
- `int i3 = 0`  L76
- `int[] iArr = this.network[i]`  L78
- `int i4 = iArr[1]`  L79
- `int i5 = i + 1`  L80
- `int i6 = i`  L81
- `int i8 = this.network[i7][1]`  L83
- `int[] iArr2 = this.network[i6]`  L89
- `int i9 = iArr2[0]`  L91
- `int i10 = iArr2[1]`  L94
- `int i11 = iArr2[2]`  L97
- `int i12 = iArr2[3]`  L100
- `int i`  L126
- `NeuQuant neuQuant = this`  L127
- `int i2 = neuQuant.lengthcount`  L128
- `int i3 = minpicturebytes`  L129
- `int i4 = neuQuant.samplefac`  L133
- `byte[] bArr = neuQuant.thepicture`  L135
- `int i6 = i5 / 100`  L137
- `int i8 = neuQuant.lengthcount`  L141
- `int i9 = i6`  L154
- `int i10 = 0`  L155
- `int i11 = 0`  L156
- `int i12 = 32`  L157
- `int i13 = 2048`  L158
- `int i14 = 1024`  L159
- `int i18 = i14`  L166
- `int i19 = i12`  L168
- `int i20 = i11 + i`  L172
- `int i21 = i13 >> 6`  L184
- `int i23 = i12 * i12`  L187
- `int i4 = this.netindex[i2]`  L198
- `int i5 = i4 - 1`  L199
- `int i6 = 1000`  L200
- `int i7 = -1`  L201
- `int[] iArr = this.network[i4]`  L207
- `int i8 = iArr[1] - i2`  L208
- `int i9 = iArr[0] - i`  L216
- `int i10 = i8 + i9`  L220
- `int i11 = iArr[2] - i3`  L222
- `int i12 = i10 + i11`  L226
- `int[] iArr2 = this.network[i5]`  L235
- `int i13 = i2 - iArr2[1]`  L236
- `int i14 = iArr2[0] - i`  L244
- `int i15 = i13 + i14`  L248
- `int i16 = iArr2[2] - i3`  L250
- `int i17 = i16 + i15`  L254
- `int[] iArr = this.network[i]`  L274
- `int i6 = i2 - i`  L283
- `int i7 = i + i2`  L287
- `int i8 = i2 + 1`  L291
- `int i9 = i2 - 1`  L292
- `int i10 = 1`  L293
- `int i11 = this.radpower[i10]`  L299
- `int i12 = i8 + 1`  L301
- `int[] iArr = this.network[i8]`  L302
- `int i13 = iArr[0]`  L304
- `int i14 = iArr[1]`  L306
- `int i15 = iArr[2]`  L308
- `int i16 = i9 - 1`  L315
- `int[] iArr2 = this.network[i9]`  L316
- `int i17 = iArr2[0]`  L318
- `int i18 = iArr2[1]`  L320
- `int i19 = iArr2[2]`  L322
- `int[] iArr = this.network[i2]`  L332
- `int i6 = iArr[0]`  L333
- `int i7 = iArr[1]`  L335
- `int i8 = iArr[2]`  L337
- `int i4 = Integer.MAX_VALUE`  L342
- `int i5 = -1`  L343
- `int i6 = -1`  L344
- `int i7 = Integer.MAX_VALUE`  L345
- `int[] iArr = this.network[i8]`  L347
- `int i9 = iArr[0] - i`  L348
- `int i10 = iArr[1] - i2`  L352
- `int i11 = i9 + i10`  L356
- `int i12 = iArr[2] - i3`  L357
- `int i13 = i11 + i12`  L361
- `int[] iArr2 = this.bias`  L366
- `int[] iArr3 = this.freq`  L372
- `int i15 = iArr3[i8]`  L373
- `int i16 = i15 >> 10`  L374
- `int[] iArr4 = this.freq`  L378
- `int[] iArr5 = this.bias`  L380

方法（10）：
- `public NeuQuant(byte[] bArr, int i, int i2)`  L43
- `byte[] colorMap()`  L55
- `void inxbuild()`  L73
- `void learn()`  L125
- `int map(int i, int i2, int i3)`  L197
- `byte[] process()`  L265
- `void unbiasnet()`  L272
- `void alterneigh(int i, int i2, int i3, int i4, int i5)`  L282
- `void altersingle(int i, int i2, int i3, int i4, int i5)`  L331
- `int contest(int i, int i2, int i3)`  L341
### `com.gku.ffm.zqvideo.utils.OrientationOption`
L6 · [class] public OrientationOption · `com/gku/ffm/zqvideo/utils/OrientationOption.java`

字段/常量（6）：
- `int mNormalLandAngleStart = CompanyIdentifierResolver.FRESHTEMP`  L7
- `int mNormalLandAngleEnd = 310`  L8
- `int mNormalPortraitAngleStart = 30`  L9
- `int mNormalPortraitAngleEnd = 330`  L10
- `int mReverseLandAngleStart = 30`  L11
- `int mReverseLandAngleEnd = 95`  L12

方法（12）：
- `int getNormalLandAngleStart()`  L14
- `void setNormalLandAngleStart(int i)`  L18
- `int getNormalLandAngleEnd()`  L22
- `void setNormalLandAngleEnd(int i)`  L26
- `int getNormalPortraitAngleStart()`  L30
- `void setNormalPortraitAngleStart(int i)`  L34
- `int getNormalPortraitAngleEnd()`  L38
- `void setNormalPortraitAngleEnd(int i)`  L42
- `int getReverseLandAngleStart()`  L46
- `void setReverseLandAngleStart(int i)`  L50
- `int getReverseLandAngleEnd()`  L54
- `void setReverseLandAngleEnd(int i)`  L58
### `com.gku.ffm.zqvideo.utils.OrientationUtils`
L12 · [class] public OrientationUtils · `com/gku/ffm/zqvideo/utils/OrientationUtils.java`

字段/常量（19）：
- `int LAND_TYPE_NORMAL = 1`  L13
- `int LAND_TYPE_NULL = 0`  L14
- `int LAND_TYPE_REVERSE = 2`  L15
- `WeakReference<Activity> mActivity`  L16
- `boolean mClick`  L17
- `boolean mClickLand`  L18
- `boolean mClickPort`  L19
- `boolean mEnable`  L20
- `int mIsLand`  L21
- `boolean mIsOnlyRotateLand`  L22
- `boolean mIsPause`  L23
- `OrientationEventListener mOrientationEventListener`  L24
- `OrientationOption mOrientationOption`  L25
- `boolean mRotateWithSystem`  L26
- `int mScreenType`  L27
- `GSYBaseVideoPlayer mVideoPlayer`  L28
- `GSYBaseVideoPlayer gSYBaseVideoPlayer`  L179
- `GSYBaseVideoPlayer gSYBaseVideoPlayer = this.mVideoPlayer`  L221
- `OrientationEventListener orientationEventListener = this.mOrientationEventListener`  L244

方法（29）：
- `public OrientationUtils(Activity activity, GSYBaseVideoPlayer gSYBaseVideoPlayer)`  L30
- `public OrientationUtils(Activity activity, GSYBaseVideoPlayer gSYBaseVideoPlayer, OrientationOption orientationOption)`  L34
- `void init()`  L54
- `void onOrientationChanged(int i)`  L62 @Override
    - 体内字面量："accelerometer_rotation"
- `void initGravity(Activity activity)`  L145
- `void setRequestedOrientation(int i)`  L162
    - 体内字面量："OrientationUtils"
- `void resolveByClick()`  L178
- `int backToProtVideo()`  L215
- `boolean isEnable()`  L230
- `void setEnable(boolean z)`  L234
- `void releaseListener()`  L243
- `boolean isClick()`  L250
- `void setClick(boolean z)`  L254
- `boolean isClickLand()`  L258
- `void setClickLand(boolean z)`  L262
- `int getIsLand()`  L266
- `void setIsLand(int i)`  L270
- `boolean isClickPort()`  L274
- `void setClickPort(boolean z)`  L278
- `int getScreenType()`  L282
- `void setScreenType(int i)`  L286
- `boolean isRotateWithSystem()`  L290
- `boolean isOnlyRotateLand()`  L294
- `void setOnlyRotateLand(boolean z)`  L298
- `void setRotateWithSystem(boolean z)`  L302
- `boolean isPause()`  L306
- `void setIsPause(boolean z)`  L310
- `OrientationOption getOrientationOption()`  L314
- `void setOrientationOption(OrientationOption orientationOption)`  L318
### `com.gku.ffm.zqvideo.utils.RawDataSourceProvider`
L13 · [class] public RawDataSourceProvider · implements `IMediaDataSource` · `com/gku/ffm/zqvideo/utils/RawDataSourceProvider.java`

字段/常量（6）：
- `AssetFileDescriptor mDescriptor`  L14
- `byte[] mMediaBytes`  L15
- `long j2 = 1 + j`  L23
- `byte[] bArr2 = this.mMediaBytes`  L24
- `AssetFileDescriptor assetFileDescriptor = this.mDescriptor`  L50
- `byte[] bArr = new byte[1024]`  L60

方法（6）：
- `public RawDataSourceProvider(AssetFileDescriptor assetFileDescriptor)`  L17
- `int readAt(long j, byte[] bArr, int i, int i2)`  L22 @Override
- `long getSize()`  L40 @Override
- `void close()`  L49 @Override
- `byte[] readBytes(InputStream inputStream)`  L58
- `RawDataSourceProvider create(Context context, Uri uri)`  L71
    - 体内字面量："assets"
### `com.gku.ffm.zqvideo.utils.StreamDataSourceProvider`
L8 · [class] public StreamDataSourceProvider · implements `IMediaDataSource` · `com/gku/ffm/zqvideo/utils/StreamDataSourceProvider.java`

字段/常量（1）：
- `BufferedInputStream bufferedInputStream`  L9

方法（4）：
- `public StreamDataSourceProvider(BufferedInputStream bufferedInputStream)`  L11
- `int readAt(long j, byte[] bArr, int i, int i2)`  L16 @Override
- `long getSize()`  L24 @Override
- `void close()`  L29 @Override
### `com.gku.ffm.zqvideo.video.base.GSYBaseVideoPlayer`
L22 · [class] public abstract GSYBaseVideoPlayer · extends `GSYVideoControlView` · `com/gku/ffm/zqvideo/video/base/GSYBaseVideoPlayer.java`

字段/常量（42）：
- `boolean isNeedAutoAdaptation`  L23
- `boolean mActionBar`  L24
- `boolean mAutoFullWithSize`  L25
- `View.OnClickListener mBackFromFullScreenListener`  L26
- `Runnable mCheckoutTask`  L27
- `boolean mFullAnimEnd`  L28
- `Handler mInnerHandler`  L29
- `boolean mIsOnlyRotateLand`  L30
- `int[] mListItemRect`  L31
- `int[] mListItemSize`  L32
- `boolean mLockLand`  L33
- `boolean mNeedOrientationUtils`  L34
- `OrientationUtils mOrientationUtils`  L35
- `boolean mRotateViewAuto`  L36
- `boolean mRotateWithSystem`  L37
- `boolean mShowFullAnimation`  L38
- `View mSmallClose`  L39
- `boolean mStatusBar`  L40
- `int mSystemUiVisibility`  L41
- `View view = this.mSmallClose`  L182
- `OrientationUtils orientationUtils = this.mOrientationUtils`  L199
- `OrientationUtils orientationUtils2 = this.mOrientationUtils`  L206
- `int[] iArr = this.mListItemRect`  L246
- `int[] iArr2 = this.mListItemRect`  L250
- `GSYBaseVideoPlayer gSYBaseVideoPlayer3`  L259
- `GSYBaseVideoPlayer gSYBaseVideoPlayer2`  L340
- `GSYBaseVideoPlayer gSYBaseVideoPlayer3`  L341
- `OrientationUtils orientationUtils`  L342
- `int iBackToProtVideo`  L422
- `OrientationUtils orientationUtils = this.mOrientationUtils`  L425
- `OrientationUtils orientationUtils2 = this.mOrientationUtils`  L429
- `int[] iArr = this.mListItemRect`  L462
- `OrientationUtils orientationUtils`  L510
- `GSYBaseVideoPlayer gSYBaseVideoPlayer`  L548
- `Exception exc`  L549
- `GSYBaseVideoPlayer gSYBaseVideoPlayer2 = gSYBaseVideoPlayer`  L572
- `int[] iArr = this.mListItemRect`  L610
- `OrientationUtils orientationUtils = this.mOrientationUtils`  L735
- `OrientationUtils orientationUtils = this.mOrientationUtils`  L755
- `View viewFindViewById`  L762
- `OrientationUtils orientationUtils = this.mOrientationUtils`  L843
- `int[] iArr = new int[2]`  L863

方法（73）：
- `int getFullId()`  L43
- `OrientationOption getOrientationOption()`  L45
- `int getSmallId()`  L49
- `public GSYBaseVideoPlayer(Context context, Boolean bool)`  L51
- `void run()`  L67 @Override
- `public GSYBaseVideoPlayer(Context context)`  L77
- `void run()`  L93 @Override
- `public GSYBaseVideoPlayer(Context context, AttributeSet attributeSet)`  L103
- `void run()`  L119 @Override
- `public GSYBaseVideoPlayer(Context context, AttributeSet attributeSet, int i)`  L129
- `void run()`  L145 @Override
- `void init(Context context)`  L156 @Override
- `void onBackFullscreen()`  L162 @Override
- `void setSmallVideoTextureView()`  L167 @Override
- `void onClick(View view2)`  L187 @Override
- `void lockTouchLogic()`  L196 @Override
- `void onPrepared()`  L213 @Override
- `void onInfo(int i, int i2)`  L219 @Override
- `ViewGroup getViewGroup()`  L226
- `void removeVideo(ViewGroup viewGroup, int i)`  L230
- `void saveLocationStatus(Context context, boolean z, boolean z2)`  L238
    - 体内字面量："*************isTranslucent*************** "
- `void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2)`  L258
- `void pauseFullCoverLogic()`  L308
- `void pauseFullBackCoverLogic(GSYBaseVideoPlayer gSYBaseVideoPlayer)`  L322
- `void resolveFullVideoShow(Context context, GSYBaseVideoPlayer gSYBaseVideoPlayer, final FrameLayout frameLayout)`  L339
- `void run()`  L365 @Override
    - 体内字面量："onEnterFullscreen"
- `void resolveNormalVideoShow(View view, ViewGroup viewGroup, GSYVideoPlayer gSYVideoPlayer)`  L391
    - 体内字面量："onQuitFullscreen"
- `void clearFullscreenLayout()`  L421
- `void run()`  L446 @Override
- `void backToNormal()`  L453
- `void run()`  L470 @Override
- `void checkoutState()`  L482
- `boolean isVerticalVideo()`  L487
    - 体内字面量："GSYVideoBase isVerticalVideo  videoHeight " · " videoWidth " · "GSYVideoBase isVerticalVideo  mRotate "
- `boolean isLockLandByAutoFullSize()`  L505
- `void checkAutoFullSizeWhenFull()`  L509
- `boolean isVerticalFullByVideoSize()`  L522
- `void onConfigurationChanged(Activity activity, Configuration configuration, OrientationUtils orientationUtils)`  L526
- `void onConfigurationChanged(Activity activity, Configuration configuration, OrientationUtils orientationUtils, boolean z, boolean z2)`  L530
- `GSYBaseVideoPlayer startWindowFullscreen(final Context context, boolean z, boolean z2)`  L547
- `void onClick(View view)`  L581 @Override
- `void onClick(View view)`  L594 @Override
- `void run()`  L616 @Override
- `GSYBaseVideoPlayer showSmallVideo(Point point, boolean z, boolean z2)`  L657
    - 体内字面量："onEnterSmallWidget"
- `void hideSmallVideo()`  L699
    - 体内字面量："onQuitSmallWidget"
- `boolean isShowFullAnimation()`  L718
- `void setShowFullAnimation(boolean z)`  L722
- `boolean isRotateViewAuto()`  L726
- `void setRotateViewAuto(boolean z)`  L733
- `boolean isLockLand()`  L741
- `void setLockLand(boolean z)`  L745
- `boolean isRotateWithSystem()`  L749
- `void setRotateWithSystem(boolean z)`  L753
- `GSYVideoPlayer getFullWindowPlayer()`  L761
- `GSYVideoPlayer getSmallWindowPlayer()`  L770
- `GSYBaseVideoPlayer getCurrentPlayer()`  L778
- `void setBackFromFullScreenListener(View.OnClickListener onClickListener)`  L785
- `void setFullHideActionBar(boolean z)`  L789
- `void setFullHideStatusBar(boolean z)`  L793
- `boolean isFullHideActionBar()`  L797
- `boolean isFullHideStatusBar()`  L801
- `int getSaveBeforeFullSystemUiVisibility()`  L805
- `void setSaveBeforeFullSystemUiVisibility(int i)`  L809
- `boolean isAutoFullWithSize()`  L813
- `void setAutoFullWithSize(boolean z)`  L817
- `boolean isNeedAutoAdaptation()`  L821
- `void setNeedOrientationUtils(boolean z)`  L825
- `boolean isNeedOrientationUtils()`  L829
- `void setNeedAutoAdaptation(boolean z)`  L833
- `boolean isOnlyRotateLand()`  L837
- `void setOnlyRotateLand(boolean z)`  L841
- `void checkAutoFullWithSizeAndAdaptation(final GSYBaseVideoPlayer gSYBaseVideoPlayer)`  L849
- `void run()`  L853 @Override
- `void autoAdaptation()`  L860
### `com.gku.ffm.zqvideo.video.base.GSYTextureRenderView`
L20 · [class] public abstract GSYTextureRenderView · extends `FrameLayout implements IGSYSurfaceListener, MeasureHelper.MeasureFormVideoParamsListener` · implements `IGSYSurfaceListener, MeasureHelper.MeasureFormVideoParamsListener` · `com/gku/ffm/zqvideo/video/base/GSYTextureRenderView.java`

字段/常量（15）：
- `GSYVideoGLView.ShaderInterface mEffectFilter`  L21
- `Bitmap mFullPauseBitmap`  L22
- `float[] mMatrixGL`  L23
- `int mMode`  L24
- `GSYVideoGLViewBaseRender mRenderer`  L25
- `int mRotate`  L26
- `Surface mSurface`  L27
- `GSYRenderView mTextureView`  L28
- `ViewGroup mTextureViewContainer`  L29
- `GSYRenderView gSYRenderView = this.mTextureView`  L68
- `GSYRenderView gSYRenderView = this.mTextureView`  L113
- `GSYRenderView gSYRenderView = this.mTextureView`  L135
- `GSYRenderView gSYRenderView = this.mTextureView`  L143
- `GSYRenderView gSYRenderView = this.mTextureView`  L151
- `GSYRenderView gSYRenderView = this.mTextureView`  L159

方法（24）：
- `void onSurfaceSizeChanged(Surface surface, int i, int i2)`  L32 @Override
- `void releasePauseCover()`  L35
- `void releaseSurface(Surface surface)`  L37
- `void setDisplay(Surface surface)`  L39
- `void setSmallVideoTextureView()`  L41
- `void showPauseCover()`  L43
- `public GSYTextureRenderView(Context context)`  L45
- `public GSYTextureRenderView(Context context, AttributeSet attributeSet)`  L52
- `public GSYTextureRenderView(Context context, AttributeSet attributeSet, int i)`  L59
- `void onSurfaceAvailable(Surface surface)`  L67 @Override
- `boolean onSurfaceDestroyed(Surface surface)`  L73 @Override
- `void onSurfaceUpdated(Surface surface)`  L80 @Override
- `void pauseLogic(Surface surface, boolean z)`  L84
- `void addTextureView()`  L92
- `int getTextureParams()`  L98
- `void changeTextureViewShowType()`  L102
- `void initCover()`  L112
- `void setSmallVideoTextureView(View.OnTouchListener onTouchListener)`  L119
- `GSYVideoGLView.ShaderInterface getEffectFilter()`  L125
- `GSYRenderView getRenderProxy()`  L129
- `void setEffectFilter(GSYVideoGLView.ShaderInterface shaderInterface)`  L133
- `void setMatrixGL(float[] fArr)`  L141
- `void setCustomGLRenderer(GSYVideoGLViewBaseRender gSYVideoGLViewBaseRender)`  L149
- `void setGLRenderMode(int i)`  L157
### `com.gku.ffm.zqvideo.video.base.GSYVideoControlView`
L31 · [class] public abstract GSYVideoControlView · extends `GSYVideoView implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener` · implements `View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener` · `com/gku/ffm/zqvideo/video/base/GSYVideoControlView.java`

字段/常量（103）：
- `Runnable dismissControlTask`  L32
- `GestureDetector gestureDetector`  L33
- `boolean isShowDragProgressTextOnSeekBar`  L34
- `ImageView mBackButton`  L35
- `ViewGroup mBottomContainer`  L36
- `ProgressBar mBottomProgressBar`  L37
- `boolean mBrightness`  L38
- `float mBrightnessData`  L39
- `boolean mChangePosition`  L40
- `boolean mChangeVolume`  L41
- `TextView mCurrentTimeTextView`  L42
- `int mDismissControlTime`  L43
- `long mDownPosition`  L44
- `float mDownX`  L45
- `float mDownY`  L46
- `int mEnlargeImageRes`  L47
- `boolean mFirstTouch`  L48
- `ImageView mFullscreenButton`  L49
- `GSYVideoProgressListener mGSYVideoProgressListener`  L50
- `int mGestureDownVolume`  L51
- `GSYStateUiListener mGsyStateUiListener`  L52
- `boolean mHadSeekTouch`  L53
- `boolean mHideKey`  L54
- `boolean mIsTouchWiget`  L55
- `boolean mIsTouchWigetFull`  L56
- `View mLoadingProgressBar`  L57
- `LockClickListener mLockClickListener`  L58
- `boolean mLockCurScreen`  L59
- `ImageView mLockScreen`  L60
- `float mMoveY`  L61
- `boolean mNeedLockFull`  L62
- `boolean mNeedShowWifiTip`  L63
- `boolean mPostDismiss`  L64
- `boolean mPostProgress`  L65
- `SeekBar mProgressBar`  L66
- `int mSeekEndOffset`  L67
- `float mSeekRatio`  L68
- `long mSeekTimePosition`  L69
- `boolean mSetUpLazy`  L70
- `boolean mShowVKey`  L71
- `int mShrinkImageRes`  L72
- `View mStartButton`  L73
- `boolean mSurfaceErrorPlay`  L74
- `int mThreshold`  L75
- `View mThumbImageView`  L76
- `RelativeLayout mThumbImageViewLayout`  L77
- `boolean mThumbPlay`  L78
- `TextView mTitleTextView`  L79
- `ViewGroup mTopContainer`  L80
- `TextView mTotalTimeTextView`  L81
- `boolean mTouchingProgressBar`  L82
- `Runnable progressTask`  L83
- `GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this`  L183
- `GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this`  L189
- `GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this`  L259
- `GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this`  L265
- `GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this`  L335
- `GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this`  L341
- `GSYVideoControlView gSYVideoControlView = GSYVideoControlView.this`  L411
- `GSYVideoControlView gSYVideoControlView2 = GSYVideoControlView.this`  L417
- `RelativeLayout relativeLayout`  L426
- `View view = this.mStartButton`  L444
- `ImageView imageView = this.mFullscreenButton`  L448
- `SeekBar seekBar = this.mProgressBar`  L453
- `ViewGroup viewGroup = this.mBottomContainer`  L457
- `SeekBar seekBar2 = this.mProgressBar`  L465
- `RelativeLayout relativeLayout2 = this.mThumbImageViewLayout`  L469
- `ImageView imageView2 = this.mBackButton`  L478
- `ImageView imageView3 = this.mLockScreen`  L482
- `TextView textView`  L531
- `int i2 = this.mCurrentState`  L536
- `SeekBar seekBar = this.mProgressBar`  L563
- `TextView textView2 = this.mCurrentTimeTextView`  L567
- `ProgressBar progressBar = this.mBottomProgressBar`  L571
- `GSYStateUiListener gSYStateUiListener = this.mGsyStateUiListener`  L581
- `RelativeLayout relativeLayout = this.mThumbImageViewLayout`  L590
- `float f = x - this.mDownX`  L681
- `float f2 = y - this.mDownY`  L682
- `TextView textView`  L720
- `ImageView imageView = this.mFullscreenButton`  L728
- `ImageView imageView2 = this.mFullscreenButton`  L735
- `int i2 = i`  L793
- `TextView textView = this.mCurrentTimeTextView`  L829
- `int i`  L837
- `int i2`  L838
- `float f4 = -f2`  L860
- `float f5 = i2`  L862
- `int i`  L875
- `int i2 = this.mThreshold`  L881
- `long j = this.mSeekTimePosition * 100`  L910
- `long j2 = j / duration`  L914
- `ProgressBar progressBar = this.mBottomProgressBar`  L915
- `SeekBar seekBar = this.mProgressBar`  L932
- `SeekBar seekBar = this.mProgressBar`  L1093
- `ProgressBar progressBar = this.mBottomProgressBar`  L1109
- `SeekBar seekBar = this.mProgressBar`  L1129
- `ProgressBar progressBar = this.mBottomProgressBar`  L1137
- `SeekBar seekBar = this.mProgressBar`  L1145
- `ProgressBar progressBar = this.mBottomProgressBar`  L1152
- `RelativeLayout relativeLayout = this.mThumbImageViewLayout`  L1170
- `RelativeLayout relativeLayout = this.mThumbImageViewLayout`  L1241
- `int i = this.mEnlargeImageRes`  L1268
- `int i = this.mShrinkImageRes`  L1277

方法（119）：
- `void changeUiToCompleteShow()`  L85
- `void changeUiToError()`  L87
- `void changeUiToNormal()`  L89
- `void changeUiToPauseShow()`  L91
- `void changeUiToPlayingBufferingShow()`  L93
- `void changeUiToPlayingShow()`  L95
- `void changeUiToPreparingShow()`  L97
- `void dismissBrightnessDialog()`  L99
- `void dismissProgressDialog()`  L101
- `void dismissVolumeDialog()`  L103
- `void hideAllWidget()`  L105
- `void onClickUiToggle(MotionEvent motionEvent)`  L107
- `void showBrightnessDialog(float f)`  L109
- `void showProgressDialog(float f, String str, long j, String str2, long j2)`  L111
- `void showVolumeDialog(float f, int i)`  L113
- `void showWifiDialog()`  L115
- `void touchLongPress(MotionEvent motionEvent)`  L117
- `public GSYVideoControlView(Context context)`  L120
- `boolean onDoubleTap(MotionEvent motionEvent)`  L146 @Override
- `boolean onSingleTapConfirmed(MotionEvent motionEvent)`  L152 @Override
- `void onLongPress(MotionEvent motionEvent)`  L160 @Override
- `void run()`  L167 @Override
- `void run()`  L178 @Override
- `public GSYVideoControlView(Context context, AttributeSet attributeSet)`  L196
- `boolean onDoubleTap(MotionEvent motionEvent)`  L222 @Override
- `boolean onSingleTapConfirmed(MotionEvent motionEvent)`  L228 @Override
- `void onLongPress(MotionEvent motionEvent)`  L236 @Override
- `void run()`  L243 @Override
- `void run()`  L254 @Override
- `public GSYVideoControlView(Context context, AttributeSet attributeSet, int i)`  L272
- `boolean onDoubleTap(MotionEvent motionEvent)`  L298 @Override
- `boolean onSingleTapConfirmed(MotionEvent motionEvent)`  L304 @Override
- `void onLongPress(MotionEvent motionEvent)`  L312 @Override
- `void run()`  L319 @Override
- `void run()`  L330 @Override
- `public GSYVideoControlView(Context context, Boolean bool)`  L348
- `boolean onDoubleTap(MotionEvent motionEvent)`  L374 @Override
- `boolean onSingleTapConfirmed(MotionEvent motionEvent)`  L380 @Override
- `void onLongPress(MotionEvent motionEvent)`  L388 @Override
- `void run()`  L395 @Override
- `void run()`  L406 @Override
- `void init(Context context)`  L425 @Override
- `void onClick(View view2)`  L487 @Override
- `void onDetachedFromWindow()`  L504 @Override
    - 体内字面量："------------------------------ dismiss onDetachedFromWindow"
- `void onAutoCompletion()`  L512 @Override
- `void onError(int i, int i2)`  L521 @Override
- `void setStateAndUi(int i)`  L530 @Override
- `void setSmallVideoTextureView(View.OnTouchListener onTouchListener)`  L588 @Override
- `void onClick(View view)`  L596
    - 体内字面量："onClickStartError" · "********" · "onClickBlankFullscreen" · "onClickBlank"
- `boolean onTouch(View view, MotionEvent motionEvent)`  L656 @Override
    - 体内字面量："------------------------------ surface_container ACTION_UP"
- `boolean setUp(String str, boolean z, String str2)`  L714 @Override
- `boolean setUp(String str, boolean z, File file, String str2)`  L719 @Override
- `void onProgressChanged(SeekBar seekBar, int i, boolean z)`  L744 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L749 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L754 @Override
    - 体内字面量："onClickSeekbarFullscreen" · "onClickSeekbar"
- `void onPrepared()`  L775 @Override
    - 体内字面量："------------------------------ surface_container onPrepared"
- `void onBufferingUpdate(final int i)`  L786 @Override
- `void run()`  L789 @Override
- `void prepareVideo()`  L807 @Override
- `void touchSurfaceDown(float f, float f2)`  L814
- `void showDragProgressTextOnSeekBar(boolean z, int i)`  L826
- `void touchSurfaceMove(float f, float f2, float f3)`  L836
- `void touchSurfaceMoveFullLogic(float f, float f2)`  L874
- `void touchSurfaceUp()`  L907
- `void touchDoubleUp(MotionEvent motionEvent)`  L957
- `void resolveUIState(int i)`  L963
- `void clickStartIcon()`  L997
    - 体内字面量："********" · "onClickStopFullscreen" · "onClickStop" · "onClickResumeFullscreen" · "onClickResume"
- `void lockTouchLogic()`  L1057
- `void startProgressTimer()`  L1068
- `void cancelProgressTimer()`  L1074
- `void setTextAndProgress(int i)`  L1079
- `void setTextAndProgress(int i, boolean z)`  L1083
- `void setProgressAndTime(long j, long j2, long j3, long j4, boolean z)`  L1089
- `void setSecondaryProgress(long j)`  L1118
- `void resetProgressAndTime()`  L1128
- `void loopSetProgressAndTime()`  L1144
- `void startDismissControlViewTimer()`  L1158
- `void cancelDismissControlViewTimer()`  L1164
- `void resolveThumbImage(View view)`  L1169
- `void setViewShowState(View view, int i)`  L1181
- `void onBrightnessSlide(float f)`  L1187
- `boolean isShowNetConfirm()`  L1206
    - 体内字面量："android.resource"
- `boolean setUpLazy(String str, boolean z, File file, Map<String, String> map, String str2)`  L1210
    - 体内字面量："waiting"
- `void initUIState()`  L1225
- `RelativeLayout getThumbImageViewLayout()`  L1229
- `void setThumbImageView(View view)`  L1233
- `void clearThumbImageView()`  L1240
- `View getThumbImageView()`  L1247
- `TextView getTitleTextView()`  L1251
- `View getStartButton()`  L1255
- `ImageView getFullscreenButton()`  L1259
- `ImageView getBackButton()`  L1263
- `int getEnlargeImageRes()`  L1267
- `void setEnlargeImageRes(int i)`  L1272
- `int getShrinkImageRes()`  L1276
- `void setShrinkImageRes(int i)`  L1281
- `void setIsTouchWigetFull(boolean z)`  L1285
- `void setThumbPlay(boolean z)`  L1289
- `boolean isSurfaceErrorPlay()`  L1293
- `void setSurfaceErrorPlay(boolean z)`  L1297
- `boolean isHideKey()`  L1301
- `void setHideKey(boolean z)`  L1305
- `boolean isNeedShowWifiTip()`  L1309
- `boolean isTouchWiget()`  L1313
- `void setIsTouchWiget(boolean z)`  L1317
- `boolean isTouchWigetFull()`  L1321
- `void setNeedShowWifiTip(boolean z)`  L1325
- `void setSeekRatio(float f)`  L1329
- `float getSeekRatio()`  L1336
- `boolean isNeedLockFull()`  L1340
- `void setNeedLockFull(boolean z)`  L1344
- `void setLockClickListener(LockClickListener lockClickListener)`  L1348
- `void setDismissControlTime(int i)`  L1352
- `int getDismissControlTime()`  L1356
- `void setGSYVideoProgressListener(GSYVideoProgressListener gSYVideoProgressListener)`  L1360
- `boolean isShowDragProgressTextOnSeekBar()`  L1364
- `void setShowDragProgressTextOnSeekBar(boolean z)`  L1368
- `GSYStateUiListener getGSYStateUiListener()`  L1372
- `void setGSYStateUiListener(GSYStateUiListener gSYStateUiListener)`  L1376
### `com.gku.ffm.zqvideo.video.base.GSYVideoPlayer`
L8 · [class] public abstract GSYVideoPlayer · extends `GSYBaseVideoPlayer` · `com/gku/ffm/zqvideo/video/base/GSYVideoPlayer.java`

方法（9）：
- `public GSYVideoPlayer(Context context, Boolean bool)`  L9
- `public GSYVideoPlayer(Context context)`  L13
- `public GSYVideoPlayer(Context context, AttributeSet attributeSet)`  L17
- `public GSYVideoPlayer(Context context, AttributeSet attributeSet, int i)`  L21
- `GSYVideoViewBridge getGSYVideoManager()`  L26 @Override
- `boolean backFromFull(Context context)`  L32 @Override
- `void releaseVideos()`  L37 @Override
- `int getFullId()`  L42 @Override
- `int getSmallId()`  L47 @Override
### `com.gku.ffm.zqvideo.video.base.GSYVideoView`
L29 · [class] public abstract GSYVideoView · extends `GSYTextureRenderView implements GSYMediaPlayerListener` · implements `GSYMediaPlayerListener` · `com/gku/ffm/zqvideo/video/base/GSYVideoView.java`

字段/常量（64）：
- `int CHANGE_DELAY_TIME = 2000`  L30
- `int CURRENT_STATE_AUTO_COMPLETE = 6`  L31
- `int CURRENT_STATE_ERROR = 7`  L32
- `int CURRENT_STATE_NORMAL = 0`  L33
- `int CURRENT_STATE_PAUSE = 5`  L34
- `int CURRENT_STATE_PLAYING = 2`  L35
- `int CURRENT_STATE_PLAYING_BUFFERING_START = 3`  L36
- `int CURRENT_STATE_PREPAREING = 1`  L37
- `AudioManager mAudioManager`  L38
- `int mBackUpPlayingBufferState`  L39
- `int mBufferPoint`  L40
- `boolean mCache`  L41
- `File mCachePath`  L42
- `Context mContext`  L43
- `long mCurrentPosition`  L44
- `int mCurrentState`  L45
- `boolean mHadPlay`  L46
- `boolean mHadPrepared`  L47
- `boolean mIfCurrentIsFullscreen`  L48
- `boolean mLooping`  L49
- `Map<String, String> mMapHeadData`  L50
- `boolean mNetChanged`  L51
- `NetInfoModule mNetInfoModule`  L52
- `String mNetSate`  L53
- `String mOriginUrl`  L54
- `String mOverrideExtension`  L55
- `boolean mPauseBeforePrepared`  L56
- `int mPlayPosition`  L57
- `String mPlayTag`  L58
- `boolean mReleaseWhenLossAudio`  L59
- `long mSaveChangeViewTIme`  L60
- `int mScreenHeight`  L61
- `int mScreenWidth`  L62
- `long mSeekOnStart`  L63
- `boolean mShowPauseCover`  L64
- `boolean mSoundTouch`  L65
- `float mSpeed`  L66
- `boolean mStartAfterPrepared`  L67
- `String mTitle`  L68
- `String mUrl`  L69
- `VideoAllCallBack mVideoAllCallBack`  L70
- `AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener`  L71
- `int i`  L374
- `VideoAllCallBack videoAllCallBack = this.mVideoAllCallBack`  L375
- `Context context = this.mContext`  L403
- `String str = this.mUrl`  L412
- `Map<String, String> map = this.mMapHeadData`  L413
- `Map<String, String> map2 = this.mMapHeadData`  L450
- `AudioManager audioManager = this.mAudioManager`  L525
- `Context context = this.mContext`  L586
- `Context context = this.mContext`  L616
- `VideoAllCallBack videoAllCallBack = this.mVideoAllCallBack`  L641
- `VideoAllCallBack videoAllCallBack2 = this.mVideoAllCallBack`  L653
- `int i3`  L660
- `int i4 = this.mCurrentState`  L662
- `int i5 = this.mBackUpPlayingBufferState`  L671
- `String str = this.mUrl`  L720
- `long currentPosition`  L728
- `int i = this.mCurrentState`  L729
- `long j = this.mCurrentPosition`  L741
- `NetInfoModule netInfoModule = this.mNetInfoModule`  L817
- `NetInfoModule netInfoModule = this.mNetInfoModule`  L824
- `NetInfoModule netInfoModule = this.mNetInfoModule`  L831
- `int i = this.mCurrentState`  L843

方法（94）：
- `boolean backFromFull(Context context)`  L73
- `GSYVideoViewBridge getGSYVideoManager()`  L75
- `int getLayoutId()`  L77
- `void onGankAudio()`  L79
- `void onLossTransientCanDuck()`  L82
- `void releaseVideos()`  L85
- `void setStateAndUi(int i)`  L87
- `void startPlayLogic()`  L89
- `public GSYVideoView(Context context)`  L91
    - 体内字面量："NORMAL"
- `void onAudioFocusChange(int i)`  L115 @Override
- `public GSYVideoView(Context context, AttributeSet attributeSet)`  L135
    - 体内字面量："NORMAL"
- `void onAudioFocusChange(int i)`  L159 @Override
- `public GSYVideoView(Context context, AttributeSet attributeSet, int i)`  L179
    - 体内字面量："NORMAL"
- `void onAudioFocusChange(int i2)`  L203 @Override
- `public GSYVideoView(Context context, Boolean bool)`  L223
    - 体内字面量："NORMAL"
- `void onAudioFocusChange(int i2)`  L247 @Override
- `void showPauseCover()`  L269 @Override
- `void releasePauseCover()`  L285 @Override
- `int getCurrentVideoWidth()`  L298 @Override
- `int getCurrentVideoHeight()`  L306 @Override
- `int getVideoSarNum()`  L314 @Override
- `int getVideoSarDen()`  L322 @Override
- `void updatePauseCover()`  L329
- `Context getActivityContext()`  L340
- `void init(Context context)`  L344
    - 体内字面量："audio"
- `void initInflate(Context context)`  L360
    - 体内字面量："GSYImageCover" · "********************\n*****   æ³¨æ   *************************\n*è¯¥çæ¬éè¦æ¸é¤å¸å±æä»¶ä¸­çGSYImageCover\n****  Attention  ***\n*Please remove GSYImageCover from Layout in this Version\n********************\n" · "è¯¥çæ¬éè¦æ¸é¤å¸å±æä»¶ä¸­çGSYImageCoverï¼please remove GSYImageCover from your layout"
- `void startButtonLogic()`  L373
- `void prepareVideo()`  L386
- `void startPrepare()`  L390
    - 体内字面量："onStartPrepared"
- `void onLossAudio()`  L421
- `void run()`  L424 @Override
- `void onLossTransientAudio()`  L434
- `boolean setUp(String str, boolean z, String str2)`  L442
- `boolean setUp(String str, boolean z, File file, Map<String, String> map, String str2)`  L446
- `boolean setUp(String str, boolean z, File file, String str2)`  L463
- `boolean setUp(String str, boolean z, File file, String str2, boolean z2)`  L467
- `void onVideoReset()`  L484
- `void onVideoPause()`  L489 @Override
- `void onVideoResume()`  L508 @Override
- `void onVideoResume(boolean z)`  L513 @Override
- `void netWorkErrorLogic()`  L536
    - 体内字面量："******* Net State Changed. renew player to connect *******"
- `void run()`  L542 @Override
- `void deleteCacheFileWhenError()`  L549
    - 体内字面量："Link Or mCache Error, Please Try Again " · "mCache Link "
- `void onPrepared()`  L558
    - 体内字面量："onPrepared"
- `void onAutoCompletion()`  L575
- `void onCompletion()`  L602
- `void onSeekComplete()`  L633 @Override
    - 体内字面量："onSeekComplete"
- `void onError(int i, int i2)`  L637
- `void onInfo(int i, int i2)`  L659
- `void onVideoSizeChanged()`  L694 @Override
- `void setDisplay(Surface surface)`  L704 @Override
- `void releaseSurface(Surface surface)`  L709 @Override
- `void clearCurrentCache()`  L713
    - 体内字面量："Play Error "
- `long getCurrentPositionWhenPlaying()`  L727
- `long getDuration()`  L749
- `void release()`  L758
- `void startAfterPrepared()`  L766
- `boolean isCurrentMediaListener()`  L795
- `void createNetWorkState()`  L799
- `void changed(String str)`  L803 @Override
    - 体内字面量："******* change network state ******* "
- `void listenerNetWorkState()`  L816
- `void unListenerNetWorkState()`  L823
- `void releaseNetWorkState()`  L830
- `int getCurrentState()`  L838
- `boolean isInPlayingState()`  L842
- `String getPlayTag()`  L847
- `void setPlayTag(String str)`  L851
- `int getPlayPosition()`  L855
- `void setPlayPosition(int i)`  L859
- `long getNetSpeed()`  L863
- `String getNetSpeedText()`  L867
- `long getSeekOnStart()`  L871
- `void setSeekOnStart(long j)`  L875
- `int getBuffterPoint()`  L879
- `boolean isIfCurrentIsFullscreen()`  L883
- `void setIfCurrentIsFullscreen(boolean z)`  L887
- `boolean isLooping()`  L891
- `void setLooping(boolean z)`  L895
- `void setVideoAllCallBack(VideoAllCallBack videoAllCallBack)`  L899
- `float getSpeed()`  L903
- `void setSpeed(float f)`  L907
- `void setSpeed(float f, boolean z)`  L911
- `void setSpeedPlaying(float f, boolean z)`  L919
- `boolean isShowPauseCover()`  L924
- `void setShowPauseCover(boolean z)`  L928
- `void seekTo(long j)`  L932
- `boolean isStartAfterPrepared()`  L943
- `void setStartAfterPrepared(boolean z)`  L947
- `boolean isReleaseWhenLossAudio()`  L951
- `void setReleaseWhenLossAudio(boolean z)`  L955
- `Map<String, String> getMapHeadData()`  L959
- `void setMapHeadData(Map<String, String> map)`  L963
- `String getOverrideExtension()`  L969
- `void setOverrideExtension(String str)`  L973
### `com.gku.ffm.zqvideo.video.base.GSYVideoViewBridge`
L12 · [interface] public GSYVideoViewBridge · `com/gku/ffm/zqvideo/video/base/GSYVideoViewBridge.java`

方法（42）：
- `boolean cachePreview(Context context, File file, String str)`  L13
- `void clearCache(Context context, File file, String str)`  L15
- `int getBufferedPercentage()`  L17
- `long getCurrentPosition()`  L19
- `int getCurrentVideoHeight()`  L21
- `int getCurrentVideoWidth()`  L23
- `long getDuration()`  L25
- `int getLastState()`  L27
- `long getNetSpeed()`  L29
- `int getPlayPosition()`  L31
- `String getPlayTag()`  L33
- `IPlayerManager getPlayer()`  L35
- `int getRotateInfoFlag()`  L37
- `int getVideoHeight()`  L39
- `int getVideoSarDen()`  L41
- `int getVideoSarNum()`  L43
- `int getVideoWidth()`  L45
- `boolean isCacheFile()`  L47
- `boolean isPlaying()`  L49
- `boolean isSurfaceSupportLockCanvas()`  L51
- `GSYMediaPlayerListener lastListener()`  L53
- `GSYMediaPlayerListener listener()`  L55
- `void pause()`  L57
- `void prepare(BufferedInputStream bufferedInputStream, Map<String, String> map, boolean z, float f, boolean z2, File file)`  L59
- `void prepare(BufferedInputStream bufferedInputStream, Map<String, String> map, boolean z, float f, boolean z2, File file, String str)`  L61
- `void prepare(String str, Map<String, String> map, boolean z, float f, boolean z2, File file)`  L63
- `void prepare(String str, Map<String, String> map, boolean z, float f, boolean z2, File file, String str2)`  L65
- `void releaseMediaPlayer()`  L67
- `void releaseSurface(Surface surface)`  L69
- `void seekTo(long j)`  L71
- `void setCurrentVideoHeight(int i)`  L73
- `void setCurrentVideoWidth(int i)`  L75
- `void setDisplay(Surface surface)`  L77
- `void setLastListener(GSYMediaPlayerListener gSYMediaPlayerListener)`  L79
- `void setLastState(int i)`  L81
- `void setListener(GSYMediaPlayerListener gSYMediaPlayerListener)`  L83
- `void setPlayPosition(int i)`  L85
- `void setPlayTag(String str)`  L87
- `void setSpeed(float f, boolean z)`  L89
- `void setSpeedPlaying(float f, boolean z)`  L91
- `void start()`  L93
- `void stop()`  L95
### `com.gku.ffm.zqvideo.video.GSYADVideoPlayer`
L17 · [class] public GSYADVideoPlayer · extends `StandardGSYVideoPlayer` · `com/gku/ffm/zqvideo/video/GSYADVideoPlayer.java`

字段/常量（8）：
- `boolean isFirstPrepared`  L18
- `TextView mADTime`  L19
- `View mJumpAd`  L20
- `View view = this.mJumpAd`  L44
- `TextView textView = this.mADTime`  L162
- `TextView textView = this.mADTime`  L180
- `View view = this.mJumpAd`  L187
- `TextView textView = this.mADTime`  L191

方法（24）：
- `void touchDoubleUp(MotionEvent motionEvent)`  L24 @Override
- `public GSYADVideoPlayer(Context context, Boolean bool)`  L27
- `public GSYADVideoPlayer(Context context)`  L31
- `public GSYADVideoPlayer(Context context, AttributeSet attributeSet)`  L35
- `void init(Context context)`  L40 @Override
- `void onClick(View view2)`  L48 @Override
- `int getLayoutId()`  L58 @Override
- `GSYVideoViewBridge getGSYVideoManager()`  L63 @Override
- `boolean backFromFull(Context context)`  L69 @Override
- `void releaseVideos()`  L74 @Override
- `int getFullId()`  L79 @Override
- `int getSmallId()`  L84 @Override
- `void onPrepared()`  L89 @Override
- `void onClick(View view)`  L96 @Override
- `void updateStartImage()`  L108 @Override
- `void touchSurfaceMove(float f, float f2, float f3)`  L123 @Override
- `void touchSurfaceMoveFullLogic(float f, float f2)`  L131 @Override
- `void touchSurfaceUp()`  L144 @Override
- `void hideAllWidget()`  L152 @Override
- `void setProgressAndTime(long j, long j2, long j3, long j4, boolean z)`  L160 @Override
- `void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2)`  L170 @Override
- `void release()`  L178 @Override
- `void changeAdUIState()`  L186
- `void removeFullWindowViewOnly()`  L210
### `com.gku.ffm.zqvideo.video.GSYSampleADVideoPlayer`
L21 · [class] public GSYSampleADVideoPlayer · extends `ListGSYVideoPlayer` · `com/gku/ffm/zqvideo/video/GSYSampleADVideoPlayer.java`

字段/常量（10）：
- `boolean isAdModel`  L22
- `boolean isFirstPrepared`  L23
- `TextView mADTime`  L24
- `View mJumpAd`  L25
- `ViewGroup mWidgetContainer`  L26
- `View view = this.mJumpAd`  L52
- `TextView textView = this.mADTime`  L168
- `View view = this.mJumpAd`  L186
- `TextView textView = this.mADTime`  L190
- `ViewGroup viewGroup = this.mWidgetContainer`  L194

方法（23）：
- `public GSYSampleADVideoPlayer(Context context, Boolean bool)`  L28
- `public GSYSampleADVideoPlayer(Context context)`  L34
- `public GSYSampleADVideoPlayer(Context context, AttributeSet attributeSet)`  L40
- `void init(Context context)`  L47 @Override
- `void onClick(View view2)`  L56 @Override
- `int getLayoutId()`  L64 @Override
- `boolean setUp(List<GSYVideoModel> list, boolean z, int i)`  L69 @Override
- `boolean setUp(List<GSYVideoModel> list, boolean z, int i, File file)`  L74 @Override
- `boolean setUp(List<GSYVideoModel> list, boolean z, int i, File file, Map<String, String> map)`  L79 @Override
- `boolean setUp(List<GSYVideoModel> list, boolean z, int i, File file, Map<String, String> map, boolean z2)`  L84 @Override
- `void onPrepared()`  L98 @Override
- `void updateStartImage()`  L105 @Override
- `void touchDoubleUp(MotionEvent motionEvent)`  L121 @Override
- `void touchSurfaceMove(float f, float f2, float f3)`  L129 @Override
- `void touchSurfaceMoveFullLogic(float f, float f2)`  L137 @Override
- `void touchSurfaceUp()`  L150 @Override
- `void hideAllWidget()`  L158 @Override
- `void setProgressAndTime(long j, long j2, long j3, long j4, boolean z)`  L166 @Override
- `void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2)`  L176 @Override
- `void changeAdUIState()`  L185
- `boolean setAdUp(ArrayList<GSYADVideoModel> arrayList, boolean z, int i)`  L213
- `boolean setAdUp(ArrayList<GSYADVideoModel> arrayList, boolean z, int i, File file)`  L217
- `boolean setAdUp(ArrayList<GSYADVideoModel> arrayList, boolean z, int i, File file, Map<String, String> map)`  L221
### `com.gku.ffm.zqvideo.video.GSYSampleADVideoPlayer$GSYADVideoModel`
L225 · [class] public static GSYADVideoModel · extends `GSYVideoModel` · `com/gku/ffm/zqvideo/video/GSYSampleADVideoPlayer.java`

字段/常量（4）：
- `int TYPE_AD = 1`  L226
- `int TYPE_NORMAL`  L227
- `boolean isSkip`  L228
- `int mType`  L229

方法（6）：
- `public GSYADVideoModel(String str, String str2, int i)`  L231
- `public GSYADVideoModel(String str, String str2, int i, boolean z)`  L235
- `int getType()`  L241
- `void setType(int i)`  L245
- `boolean isSkip()`  L249
- `void setSkip(boolean z)`  L253
### `com.gku.ffm.zqvideo.video.ListGSYVideoPlayer`
L19 · [class] public ListGSYVideoPlayer · extends `StandardGSYVideoPlayer` · `com/gku/ffm/zqvideo/video/ListGSYVideoPlayer.java`

字段/常量（3）：
- `int mPlayPosition`  L20
- `List<GSYVideoModel> mUriList`  L21
- `int i = this.mPlayPosition + 1`  L151

方法（16）：
- `public ListGSYVideoPlayer(Context context, Boolean bool)`  L23
- `public ListGSYVideoPlayer(Context context)`  L28
- `public ListGSYVideoPlayer(Context context, AttributeSet attributeSet)`  L33
- `boolean setUp(List<GSYVideoModel> list, boolean z, int i)`  L38
- `boolean setUp(List<GSYVideoModel> list, boolean z, int i, File file)`  L42
- `boolean setUp(List<GSYVideoModel> list, boolean z, int i, File file, Map<String, String> map)`  L46
- `boolean setUp(List<GSYVideoModel> list, boolean z, int i, File file, Map<String, String> map, boolean z2)`  L50
- `void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2)`  L63 @Override
- `GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean z, boolean z2)`  L72 @Override
- `void resolveNormalVideoShow(View view, ViewGroup viewGroup, GSYVideoPlayer gSYVideoPlayer)`  L85 @Override
- `void onCompletion()`  L96 @Override
- `void onAutoCompletion()`  L105 @Override
- `void prepareVideo()`  L113 @Override
- `void onPrepared()`  L125 @Override
- `void changeUiToNormal()`  L130 @Override
- `boolean playNext()`  L147
### `com.gku.ffm.zqvideo.video.NormalGSYVideoPlayer`
L9 · [class] public NormalGSYVideoPlayer · extends `StandardGSYVideoPlayer` · `com/gku/ffm/zqvideo/video/NormalGSYVideoPlayer.java`

方法（5）：
- `public NormalGSYVideoPlayer(Context context, Boolean bool)`  L10
- `public NormalGSYVideoPlayer(Context context)`  L14
- `public NormalGSYVideoPlayer(Context context, AttributeSet attributeSet)`  L18
- `int getLayoutId()`  L23 @Override
- `void updateStartImage()`  L28 @Override
### `com.gku.ffm.zqvideo.video.StandardGSYVideoPlayer`
L29 · [class] public StandardGSYVideoPlayer · extends `GSYVideoPlayer` · `com/gku/ffm/zqvideo/video/StandardGSYVideoPlayer.java`

字段/常量（42）：
- `Drawable mBottomProgressDrawable`  L30
- `Drawable mBottomShowProgressDrawable`  L31
- `Drawable mBottomShowProgressThumbDrawable`  L32
- `Dialog mBrightnessDialog`  L33
- `TextView mBrightnessDialogTv`  L34
- `ImageView mDialogIcon`  L35
- `ProgressBar mDialogProgressBar`  L36
- `Drawable mDialogProgressBarDrawable`  L37
- `int mDialogProgressHighLightColor`  L38
- `int mDialogProgressNormalColor`  L39
- `TextView mDialogSeekTime`  L40
- `TextView mDialogTotalTime`  L41
- `ProgressBar mDialogVolumeProgressBar`  L42
- `Dialog mProgressDialog`  L43
- `Dialog mVolumeDialog`  L44
- `Drawable mVolumeProgressDrawable`  L45
- `ProgressBar progressBar`  L120
- `TextView textView`  L121
- `TextView textView2`  L122
- `Drawable drawable = this.mDialogProgressBarDrawable`  L128
- `int i = this.mDialogProgressNormalColor`  L149
- `int i2 = this.mDialogProgressHighLightColor`  L153
- `int[] iArr = new int[2]`  L161
- `TextView textView3 = this.mDialogSeekTime`  L170
- `TextView textView4 = this.mDialogTotalTime`  L174
- `ImageView imageView = this.mDialogIcon`  L182
- `ImageView imageView2 = this.mDialogIcon`  L189
- `Dialog dialog = this.mProgressDialog`  L197
- `Drawable drawable = this.mVolumeProgressDrawable`  L211
- `int[] iArr = new int[2]`  L227
- `ProgressBar progressBar2 = this.mDialogVolumeProgressBar`  L236
- `Dialog dialog = this.mVolumeDialog`  L244
- `int[] iArr = new int[2]`  L270
- `TextView textView = this.mBrightnessDialogTv`  L279
- `Dialog dialog = this.mBrightnessDialog`  L287
- `int i`  L669
- `Drawable drawable`  L670
- `Drawable drawable2 = this.mBottomProgressDrawable`  L671
- `Drawable drawable3 = this.mBottomShowProgressDrawable`  L675
- `Drawable drawable4 = this.mVolumeProgressDrawable`  L679
- `Drawable drawable5 = this.mDialogProgressBarDrawable`  L683
- `int i2 = this.mDialogProgressHighLightColor`  L687

方法（54）：
- `public StandardGSYVideoPlayer(Context context, Boolean bool)`  L47
- `public StandardGSYVideoPlayer(Context context)`  L53
- `public StandardGSYVideoPlayer(Context context, AttributeSet attributeSet)`  L59
- `void init(Context context)`  L66 @Override
- `int getLayoutId()`  L80 @Override
- `void startPlayLogic()`  L85 @Override
    - 体内字面量："onClickStartThumb"
- `void showWifiDialog()`  L95 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L104 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L111 @Override
- `void showProgressDialog(float f, String str, long j, String str2, long j2)`  L119 @Override
- `void dismissProgressDialog()`  L196 @Override
- `void showVolumeDialog(float f, int i)`  L205 @Override
- `void dismissVolumeDialog()`  L243 @Override
- `void showBrightnessDialog(float f)`  L252 @Override
- `void dismissBrightnessDialog()`  L286 @Override
- `void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2)`  L295 @Override
- `GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean z, boolean z2)`  L313 @Override
- `void onClickUiToggle(MotionEvent motionEvent)`  L325 @Override
- `void hideAllWidget()`  L401 @Override
- `void changeUiToNormal()`  L409 @Override
    - 体内字面量："changeUiToNormal"
- `void changeUiToPreparingShow()`  L425 @Override
    - 体内字面量："changeUiToPreparingShow"
- `void changeUiToPlayingShow()`  L440 @Override
    - 体内字面量："changeUiToPlayingShow"
- `void changeUiToPauseShow()`  L460 @Override
    - 体内字面量："changeUiToPauseShow"
- `void changeUiToPlayingBufferingShow()`  L481 @Override
    - 体内字面量："changeUiToPlayingBufferingShow"
- `void changeUiToCompleteShow()`  L496 @Override
    - 体内字面量："changeUiToCompleteShow"
- `void changeUiToError()`  L512 @Override
    - 体内字面量："changeUiToError"
- `void onDetachedFromWindow()`  L528 @Override
- `int getProgressDialogLayoutId()`  L534
- `int getProgressDialogProgressId()`  L538
- `int getProgressDialogCurrentDurationTextId()`  L542
- `int getProgressDialogAllDurationTextId()`  L546
- `int getProgressDialogImageId()`  L550
- `int getVolumeLayoutId()`  L554
- `int getVolumeProgressId()`  L558
- `int getBrightnessLayoutId()`  L562
- `int getBrightnessTextId()`  L566
- `void changeUiToPrepareingClear()`  L570
    - 体内字面量："changeUiToPrepareingClear"
- `void changeUiToPlayingClear()`  L584
    - 体内字面量："changeUiToPlayingClear"
- `void changeUiToPauseClear()`  L590
    - 体内字面量："changeUiToPauseClear"
- `void changeUiToPlayingBufferingClear()`  L597
    - 体内字面量："changeUiToPlayingBufferingClear"
- `void changeUiToClear()`  L612
    - 体内字面量："changeUiToClear"
- `void changeUiToCompleteClear()`  L626
    - 体内字面量："changeUiToCompleteClear"
- `void updateStartImage()`  L641
- `void initFullUI(StandardGSYVideoPlayer standardGSYVideoPlayer)`  L668
- `void setBottomShowProgressBarDrawable(Drawable drawable, Drawable drawable2)`  L694
- `void setBottomProgressBarDrawable(Drawable drawable)`  L703
- `void setDialogVolumeProgressBar(Drawable drawable)`  L710
- `void setDialogProgressBar(Drawable drawable)`  L714
- `void setDialogProgressColor(int i, int i2)`  L718
- `void taskShotPic(GSYVideoShotListener gSYVideoShotListener)`  L723
- `void taskShotPic(GSYVideoShotListener gSYVideoShotListener, boolean z)`  L727
- `void saveFrame(File file, GSYVideoShotSaveListener gSYVideoShotSaveListener)`  L733
- `void saveFrame(File file, boolean z, GSYVideoShotSaveListener gSYVideoShotSaveListener)`  L737
- `void restartTimerTask()`  L743
### `com.gku.ffm.zqvideo.view.SmallVideoTouch`
L9 · [class] public SmallVideoTouch · implements `View.OnTouchListener` · `com/gku/ffm/zqvideo/view/SmallVideoTouch.java`

字段/常量（11）：
- `int _xDelta`  L10
- `int _yDelta`  L11
- `int mDownX`  L12
- `int mDownY`  L13
- `GSYBaseVideoPlayer mGsyBaseVideoPlayer`  L14
- `int mMarginLeft`  L15
- `int mMarginTop`  L16
- `int i = layoutParams2.leftMargin`  L43
- `int i2 = this.mMarginLeft`  L44
- `int i3 = layoutParams2.topMargin`  L48
- `int i4 = this.mMarginTop`  L49

方法（2）：
- `public SmallVideoTouch(GSYBaseVideoPlayer gSYBaseVideoPlayer, int i, int i2)`  L18
- `boolean onTouch(View view, MotionEvent motionEvent)`  L25 @Override