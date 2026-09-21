# XTU GO — 类与成员明细：m.mifan.acase.player

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `m.mifan.acase.player.HisiLivePlayer`
L12 · [class] public final HisiLivePlayer · `m/mifan/acase/player/HisiLivePlayer.java`
注解：

字段/常量（9）：
- `boolean delayPlay`  L13
- `boolean isRelease`  L14
- `ExecutorService playThread`  L15
- `boolean playThreadWorking`  L16
- `int retryConnectionCount`  L17
- `boolean surfaceEnable`  L18
- `SurfaceHolder surfaceHolder`  L19
- `String videoUrl`  L20
- `HisiLivePlayer hisiLivePlayer = HisiLivePlayer.this`  L57

方法（11）：
- `void _startPlay(String url)`  L28
- `void stopPlay()`  L31
- `public HisiLivePlayer(SurfaceHolder surfaceHolder)`  L34
    - 体内字面量："surfaceHolder"
- `void surfaceChanged(SurfaceHolder holder, int format, int width, int height)`  L40 @Override
    - 体内字面量："holder"
- `void surfaceDestroyed(SurfaceHolder holder)`  L45 @Override
    - 体内字面量："holder"
- `void surfaceCreated(SurfaceHolder holder)`  L52 @Override
    - 体内字面量："holder"
- `void startPlay(final String url)`  L65
    - 体内字面量："url"
- `void run()`  L78 @Override
- `void startPlay$lambda$0(HisiLivePlayer hisiLivePlayer, String str)`  L86
- `void release()`  L91
- `void _releasePlayer()`  L97
### `m.mifan.acase.player.HisiLivePlayer$PlayExceptionListener`
L24 · [interface] public PlayExceptionListener · `m/mifan/acase/player/HisiLivePlayer.java`
注解：

方法（1）：
- `void onThrowException(Exception e)`  L25
### `m.mifan.acase.player.HisiLivePlayerView`
L15 · [class] public final HisiLivePlayerView · extends `FrameLayout` · `m/mifan/acase/player/HisiLivePlayerView.java`
注解：

字段/常量（5）：
- `HisiLivePlayer player`  L16
- `HisiLivePlayer hisiLivePlayer = this.player`  L48
- `HisiLivePlayer hisiLivePlayer = this.player`  L57
- `HisiLivePlayer hisiLivePlayer = this.player`  L66
- `HisiLivePlayer hisiLivePlayer = this.player`  L77

方法（8）：
- `public HisiLivePlayerView(Context context)`  L19
    - 体内字面量："context"
- `public HisiLivePlayerView(Context context, AttributeSet attributeSet)`  L25
    - 体内字面量："context"
- ` HisiLivePlayerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L30
- `public HisiLivePlayerView(Context context, AttributeSet attributeSet, int i)`  L35
    - 体内字面量："context" · "getHolder(...)"
- `void play(String url)`  L46
    - 体内字面量："url"
- `void stop()`  L56
- `void release()`  L65
- `void onDetachedFromWindow()`  L75 @Override
### `m.mifan.acase.player.HisiPlayerDelegate`
L12 · [class] public final HisiPlayerDelegate · implements `LiveViewPlayer.Delegate` · `m/mifan/acase/player/HisiPlayerDelegate.java`
注解：

字段/常量（5）：
- `HisiLivePlayerView playerView`  L13
- `String url`  L14
- `HisiLivePlayerView hisiLivePlayerView = this.playerView`  L26
- `HisiLivePlayerView hisiLivePlayerView = this.playerView`  L34
- `HisiLivePlayerView hisiLivePlayerView = this.playerView`  L50

方法（5）：
- `public HisiPlayerDelegate(String url)`  L16
    - 体内字面量："url"
- `void play(String modeValue, boolean restore)`  L22 @Override
    - 体内字面量："modeValue" · "===========player start 4:" · "123->    "
- `void stop(boolean restore)`  L33 @Override
- `View getPlayerView(Context context)`  L41 @Override
    - 体内字面量："context"
- `void release()`  L49 @Override
### `m.mifan.acase.player.IjkPreviewSurfaceView`
L23 · [class] public final IjkPreviewSurfaceView · extends `TextureView` · `m/mifan/acase/player/IjkPreviewSurfaceView.java`
注解：

字段/常量（19）：
- `Runnable checkRunnable`  L24
- `Runnable checkRunnable2`  L25
- `String currentUrl`  L26
- `ICatchPlayerListener event`  L27
- `IjkMediaPlayer ijkMediaPlayer`  L28
- `boolean isStop`  L29
- `long lastCompleteTime`  L30
- `long lastStreamTime`  L31
- `Surface mSurface`  L32
- `boolean mute`  L33
- `boolean needCheck`  L34
- `boolean tcpMode`  L35
- `boolean videoRenderingStart`  L36
- `Surface surface2 = IjkPreviewSurfaceView.this.mSurface`  L72
- `ICatchPlayerListener iCatchPlayerListener = ijkPreviewSurfaceView.event`  L130
- `ICatchPlayerListener iCatchPlayerListener = ijkPreviewSurfaceView.event`  L140
- `ICatchPlayerListener iCatchPlayerListener = ijkPreviewSurfaceView.event`  L153
- `ICatchPlayerListener iCatchPlayerListener = this.event`  L257
- `boolean z = i > i2`  L322

方法（29）：
- ` IjkPreviewSurfaceView(Context context, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker)`  L38
- `public IjkPreviewSurfaceView(Context context, boolean z, boolean z2)`  L43
    - 体内字面量："context"
- `void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height)`  L53 @Override
    - 体内字面量："surface"
- `void onSurfaceTextureUpdated(SurfaceTexture surface)`  L58 @Override
    - 体内字面量："surface"
- `void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height)`  L63 @Override
    - 体内字面量："surface"
- `boolean onSurfaceTextureDestroyed(SurfaceTexture surface)`  L70 @Override
    - 体内字面量："surface"
- `void onCompletion(IMediaPlayer iMediaPlayer)`  L83 @Override
- `boolean onError(IMediaPlayer iMediaPlayer, int i, int i2)`  L89 @Override
- `boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2)`  L95 @Override
- `void onPrepared(IMediaPlayer iMediaPlayer)`  L101 @Override
- `void run()`  L107 @Override
- `void run()`  L113 @Override
- `void setOnPlayerListener(ICatchPlayerListener listener)`  L119
    - 体内字面量："listener"
- `void _init_$lambda$0(IjkPreviewSurfaceView ijkPreviewSurfaceView, IMediaPlayer iMediaPlayer)`  L125
    - 体内字面量："==========ijkMediaPlayer Completion"
- `boolean _init_$lambda$1(IjkPreviewSurfaceView ijkPreviewSurfaceView, IMediaPlayer iMediaPlayer, int i, int i2)`  L138
    - 体内字面量："==========ijkMediaPlayer Error"
- `boolean _init_$lambda$2(IjkPreviewSurfaceView ijkPreviewSurfaceView, IMediaPlayer iMediaPlayer, int i, int i2)`  L148
    - 体内字面量："ijkMediaPlayer live onInfo ââ> MEDIA_INFO_VIDEO_RENDERING_STARTï¼STATE_PLAYING" · "============== ijkMediaPlayer event.onFirstFrameRender()  "
- `void _init_$lambda$3(IjkPreviewSurfaceView ijkPreviewSurfaceView, IMediaPlayer iMediaPlayer)`  L177
    - 体内字面量："==========ijkMediaPlayer Prepared"
- `void checkRendering()`  L182
- `void checkRunnable2$lambda$4(IjkPreviewSurfaceView ijkPreviewSurfaceView)`  L187
    - 体内字面量："ijkMediaPlayer live æªæ¸²æéæ°æ­æ¾"
- `void startCheck()`  L200
- `void checkRunnable$lambda$5(IjkPreviewSurfaceView ijkPreviewSurfaceView)`  L205
    - 体内字面量："ijkMediaPlayer live å¡ä½éæ°æ­æ¾"
- `void lowDelayConf()`  L219
    - 体内字面量："mediacodec-hevc" · "analyzeduration" · "fflags" · "nobuffer" · "analyzemaxduration" · "flush_packets" · "probesize" · "start-on-prepared" · "packet-buffering" · "infbuf" · "framedrop" · "fps" · "fast" · "no_delay" · "flags" · "low_delay" · "dns_cache_clear" · "mediacodec" · "mediacodec-auto-rotate" · "mediacodec-handle-resolution-change" · "skip_loop_filter" · "http-detect-range-support" · "max-buffer-size" · "min-frames" · "max_cached_duration" · "an" · "rtsp_transport" · "tcp"
- `void play(String url)`  L251
    - 体内字面量："url" · "ijkMediaPlayer  ==play "
- `void stop()`  L278
- `boolean isPlaying()`  L287
- `Bitmap getShortCut()`  L291
- `void onDetachedFromWindow()`  L296 @Override
- `void rotateAndResize$default(IjkPreviewSurfaceView ijkPreviewSurfaceView, float f, int i, int i2, boolean z, int i3, Object obj)`  L304
- `void rotateAndResize(float degrees, int parentWidth, int measuredHeight, boolean isFull)`  L311
    - 体内字面量："=========== rotateAndResize   degrees=" · "  parentWidth=" · "  measuredHeight=" · "  isFull=" · "=========== rotateAndResize   screenWidth=" · "  screenHeight="