# XTU GO — 类与成员明细：m.mifan.player

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 4 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `m.mifan.player.IjkPlayerController`
L16 · [class] public final IjkPlayerController · `m/mifan/player/IjkPlayerController.java`
注解：

字段/常量（10）：
- `Event event`  L17
- `StringBuilder formatBuilder`  L18
- `Formatter formatter`  L19
- `IjkMediaPlayer ijkPlayer`  L20
- `boolean lastSeekPlayState`  L21
- `Handler mainHandler`  L22
- `boolean seekState`  L23
- `IjkPlayerController$updateRunnable$1 updateRunnable`  L24
- `long j2 = 60`  L118
- `long j3 = j % j2`  L119

方法（14）：
- `public IjkPlayerController(IjkMediaPlayer ijkPlayer, Event event)`  L33
    - 体内字面量："ijkPlayer" · "event"
- `void run()`  L44 @Override
- `void updateDuration$default(IjkPlayerController ijkPlayerController, long j, int i, Object obj)`  L51
- `void updateDuration(long position)`  L58
- `void play()`  L66
- `void pause()`  L71
- `void onShow()`  L76
- `void onHide()`  L81
- `void Completion()`  L85
- `void onSeek(int progress)`  L91
    - 体内字面量："===============seekState:"
- `void onSeekStart()`  L98
- `void onSeekStop()`  L104
- `void release()`  L112
- `String stringForTime(long timeMs)`  L116
### `m.mifan.player.IjkPlayerController$Event`
L28 · [interface] public Event · `m/mifan/player/IjkPlayerController.java`
注解：

方法（1）：
- `void onUpdateTimeText(String position, String duration, int progress)`  L29
### `m.mifan.player.PlayerView`
L26 · [class] public final PlayerView · extends `ConstraintLayout` · `m/mifan/player/PlayerView.java`
注解：

字段/常量（29）：
- `boolean controlView`  L27
- `boolean isPlaying`  L28
- `boolean needAutoResumePlay`  L29
- `Event playEvent`  L30
- `IjkMediaPlayer player`  L31
- `IjkPlayerController playerController`  L32
- `ViewIjkLibPlayerBinding viewBinding`  L33
- `IjkPlayerController ijkPlayerController = PlayerView.this.playerController`  L153
- `IjkPlayerController ijkPlayerController = PlayerView.this.playerController`  L164
- `IjkPlayerController ijkPlayerController = PlayerView.this.playerController`  L174
- `IjkPlayerController ijkPlayerController = null`  L200
- `IjkPlayerController ijkPlayerController2 = playerView.playerController`  L202
- `IjkPlayerController ijkPlayerController3 = playerView.playerController`  L211
- `IjkPlayerController ijkPlayerController = null`  L222
- `IjkPlayerController ijkPlayerController2 = playerView.playerController`  L224
- `IjkPlayerController ijkPlayerController = null`  L236
- `IjkPlayerController ijkPlayerController2 = playerView.playerController`  L238
- `IjkPlayerController ijkPlayerController = null`  L249
- `IjkPlayerController ijkPlayerController2 = playerView.playerController`  L253
- `ImageView playButton = this.viewBinding.playButton`  L287
- `ImageView pauseButton = this.viewBinding.pauseButton`  L290
- `Event event = this.playEvent`  L294
- `FrameLayout viewError = this.viewBinding.viewError`  L299
- `TextView positionTextView = this.viewBinding.positionTextView`  L306
- `TextView durationTextView = this.viewBinding.durationTextView`  L309
- `SeekBar seekBar = this.viewBinding.seekBar`  L312
- `ImageView pauseButton = this.viewBinding.pauseButton`  L316
- `ImageView playButton = this.viewBinding.playButton`  L320
- `IjkPlayerController ijkPlayerController = this.playerController`  L329

方法（33）：
- `public PlayerView(Context context)`  L42
    - 体内字面量："context"
- `public PlayerView(Context context, AttributeSet attributeSet)`  L48
    - 体内字面量："context"
- ` PlayerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L53
- `public PlayerView(Context context, AttributeSet attributeSet, int i)`  L58
    - 体内字面量："context"
- `Event getPlayEvent()`  L66
- `void setPlayEvent(Event event)`  L70
- `void initView()`  L74
- `void surfaceChanged(SurfaceHolder holder, int format, int width, int height)`  L77 @Override
    - 体内字面量："holder"
- `void surfaceDestroyed(SurfaceHolder holder)`  L83 @Override
    - 体内字面量："holder" · "========================================="
- `void surfaceCreated(SurfaceHolder holder)`  L95 @Override
    - 体内字面量："holder"
- `void onPrepared(IMediaPlayer iMediaPlayer)`  L105 @Override
- `boolean onError(IMediaPlayer iMediaPlayer, int i, int i2)`  L111 @Override
- `void onUpdateTimeText(String position, String duration, int progress)`  L117 @Override
    - 体内字面量："position" · "duration"
- `void onClick(View view)`  L127 @Override
- `void onClick(View view)`  L133 @Override
- `void onClick(View view)`  L139 @Override
- `void onCompletion(IMediaPlayer iMediaPlayer)`  L145 @Override
- `void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)`  L151 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L163 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L173 @Override
- `void initView$lambda$0(PlayerView playerView, IMediaPlayer iMediaPlayer)`  L185
- `boolean initView$lambda$1(PlayerView playerView, IMediaPlayer iMediaPlayer, int i, int i2)`  L192
- `void initView$lambda$2(PlayerView playerView, View view)`  L198
- `void initView$lambda$3(PlayerView playerView, View view)`  L221
- `void initView$lambda$4(PlayerView playerView, View view)`  L235
- `void initView$lambda$5(PlayerView playerView, IMediaPlayer iMediaPlayer)`  L248
- `void setDataSource(String path)`  L262
    - 体内字面量："path"
- `long getPosition()`  L269
- `long getDuration()`  L273
- `void playOrPause$default(PlayerView playerView, boolean z, boolean z2, int i, Object obj)`  L277
- `void playOrPause(boolean play, boolean error)`  L284
- `void setControlViewDisplay(boolean display)`  L305
- `void release()`  L327
### `m.mifan.player.PlayerView$Event`
L37 · [interface] public Event · `m/mifan/player/PlayerView.java`
注解：

方法（1）：
- `void onPlayStatus(boolean play)`  L38