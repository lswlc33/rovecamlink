# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.player

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 16 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.player.HiDVPlayerInterface`
L4 · [interface] public HiDVPlayerInterface · `com/gku/actioncam/hisilicon/dv/player/HiDVPlayerInterface.java`

方法（16）：
- `int getCurrentPosition()`  L48
- `int getDuration()`  L50
- `HiDVPlayerStatus getStatus()`  L52
- `HiDVPlayerType getType()`  L54
- `int getVideoHeight()`  L56
- `int getVideoWidth()`  L58
- `boolean pause()`  L60
- `boolean play()`  L62
- `boolean prepare()`  L64
- `void registerListener(HiDVPlayerListener listener)`  L66
- `void release()`  L68
- `boolean seek(int time)`  L70
- `boolean setDataSource(String url, HiDVMediaType mediaType)`  L72
- `boolean setVolume(int volume)`  L74
- `boolean stop()`  L76
- `void unRegisterListener(HiDVPlayerListener listener)`  L78
### `com.gku.actioncam.hisilicon.dv.player.HiDVPlayerInterface$HiDVMediaType`
L6 · [enum] public HiDVMediaType · `com/gku/actioncam/hisilicon/dv/player/HiDVPlayerInterface.java`

枚举常量（1）：
- `PICTURE()`  L7
### `com.gku.actioncam.hisilicon.dv.player.HiDVPlayerInterface$HiDVPlayerListener`
L11 · [interface] public HiDVPlayerListener · `com/gku/actioncam/hisilicon/dv/player/HiDVPlayerInterface.java`

方法（7）：
- `void onBufferring(int percent)`  L12
- `void onError(String msg)`  L14
- `void onMediaChanged(String currentURI)`  L16
- `void onSeekBufferringState(HiDVPlayerSeekStatus state, int percent)`  L18
- `void onTransportStateChange(HiDVPlayerStatus currentStatus)`  L20
- `void onUpdateProgress(int durantion, int currentPostion)`  L22
- `void onUpdateVolume(int volume)`  L24
### `com.gku.actioncam.hisilicon.dv.player.HiDVPlayerInterface$HiDVPlayerSeekStatus`
L27 · [enum] public HiDVPlayerSeekStatus · `com/gku/actioncam/hisilicon/dv/player/HiDVPlayerInterface.java`

枚举常量（2）：
- `SEEK_START()`  L28
- `SEEK_MID()`  L29
### `com.gku.actioncam.hisilicon.dv.player.HiDVPlayerInterface$HiDVPlayerStatus`
L33 · [enum] public HiDVPlayerStatus · `com/gku/actioncam/hisilicon/dv/player/HiDVPlayerInterface.java`

枚举常量（5）：
- `PREPARED()`  L34
- `PLAYING()`  L35
- `PAUSED()`  L36
- `STOPED()`  L37
- `RELEASE()`  L38
### `com.gku.actioncam.hisilicon.dv.player.HiDVPlayerInterface$HiDVPlayerType`
L42 · [enum] public HiDVPlayerType · `com/gku/actioncam/hisilicon/dv/player/HiDVPlayerInterface.java`

枚举常量（2）：
- `LOCAL_FILE_PLAYER()`  L43
- `REMOTE_FILE_PLAYER()`  L44
### `com.gku.actioncam.hisilicon.dv.player.HiDVRemoteFilePlayer`
L11 · [class] public HiDVRemoteFilePlayer · implements `HiDVPlayerInterface, HiCamPlayer.HiCamPlayerStateListener, HiCamPlayer.onSeekBufferingStateListener` · `com/gku/actioncam/hisilicon/dv/player/HiDVRemoteFilePlayer.java`

字段/常量（21）：
- `String TAG = "HiDVRemoteFilePlayer"`  L12
- `AudioManager audioManager`  L13
- `HiDVPlayerInterface.HiDVPlayerListener mPlayerListeners`  L14
- `HiCamPlayer player`  L15
- `HiCamPlayer hiCamPlayer = this.player`  L85
- `HiCamPlayer hiCamPlayer = this.player`  L105
- `HiCamPlayer hiCamPlayer = this.player`  L121
- `HiCamPlayer hiCamPlayer = this.player`  L137
- `HiCamPlayer hiCamPlayer = this.player`  L153
- `HiCamPlayer hiCamPlayer = this.player`  L163
- `HiCamPlayer hiCamPlayer = this.player`  L172
- `HiCamPlayer hiCamPlayer = this.player`  L181
- `HiCamPlayer hiCamPlayer = this.player`  L190
- `HiCamPlayer hiCamPlayer = this.player`  L199
- `AudioManager audioManager = this.audioManager`  L213
- `HiDVPlayerInterface.HiDVPlayerListener hiDVPlayerListener = this.mPlayerListeners`  L236
- `HiDVPlayerInterface.HiDVPlayerListener hiDVPlayerListener`  L266
- `HiDVPlayerInterface.HiDVPlayerListener hiDVPlayerListener2 = this.mPlayerListeners`  L269
- `HiDVPlayerInterface.HiDVPlayerListener hiDVPlayerListener3 = this.mPlayerListeners`  L283
- `HiDVPlayerInterface.HiDVPlayerListener hiDVPlayerListener = this.mPlayerListeners`  L291
- `HiDVPlayerInterface.HiDVPlayerListener hiDVPlayerListener = this.mPlayerListeners`  L299

方法（25）：
- `HiDVPlayerInterface.HiDVPlayerStatus getStatus()`  L18 @Override
- `void onASRChange(HiCamPlayer mplayer)`  L23 @Override
- `void onBufferingUpdate(HiCamPlayer mplayer, int percent)`  L27 @Override
- `public HiDVRemoteFilePlayer(Context mContext, SurfaceHolder surfaceHolder)`  L30
    - 体内字面量："audio"
- `void registerListener(HiDVPlayerInterface.HiDVPlayerListener listener)`  L45 @Override
- `void unRegisterListener(HiDVPlayerInterface.HiDVPlayerListener listener)`  L52 @Override
    - 体内字面量："575421546" · "unRegisterListener: --------------------  æ­æ¾å¨ç  mPlayerListeners  ç½®ç©º" · "575421546" · "unRegisterListener: --------------------  æ­æ¾å¨ç  listener.equals(mPlayerListeners) ä¸ºfalse "
- `boolean setDataSource(String url, HiDVPlayerInterface.HiDVMediaType mediaType)`  L64 @Override
    - 体内字面量："reason=" · "reason=" · "reason="
- `boolean prepare()`  L84 @Override
- `boolean play()`  L104 @Override
- `boolean pause()`  L120 @Override
- `boolean stop()`  L136 @Override
- `boolean seek(int time)`  L152 @Override
- `int getCurrentPosition()`  L162 @Override
- `int getDuration()`  L171 @Override
- `int getVideoWidth()`  L180 @Override
- `int getVideoHeight()`  L189 @Override
- `void release()`  L198 @Override
- `boolean setVolume(int volume)`  L212 @Override
- `HiDVPlayerInterface.HiDVPlayerType getType()`  L222 @Override
- `void onError(HiCamPlayer mplayer, String msg, int extra)`  L227 @Override
    - 体内字面量："onError="
- `void onFinish(HiCamPlayer mplayer)`  L235 @Override
- `void onStateChange(HiCamPlayer mplayer, HiCamPlayer.HiCamPlayerState state)`  L265 @Override
- `void onSeekBufferingStart(HiCamPlayer mplayer)`  L290 @Override
- `void onSeekBufferingEnd(HiCamPlayer mplayer)`  L298 @Override
- `void onSeekBufferingLoadingPercent(HiCamPlayer mplayer, int percent)`  L306 @Override
    - 体内字面量："bufferingpercent="
### `com.gku.actioncam.hisilicon.dv.player.HiDVRemoteFilePlayer$AnonymousClass1`
L243 · [class] static AnonymousClass1 · `com/gku/actioncam/hisilicon/dv/player/HiDVRemoteFilePlayer.java`

字段/常量（1）：
- `int[] $SwitchMap$com$gku$actioncam$hisilicon$camplayer$HiCamPlayer$HiCamPlayerState`  L244
### `com.gku.actioncam.hisilicon.dv.player.PlayControlThread`
L13 · [class] public PlayControlThread · extends `HandlerThread implements Handler.Callback, HiDVPlayerInterface.HiDVPlayerListener` · implements `Handler.Callback, HiDVPlayerInterface.HiDVPlayerListener` · `com/gku/actioncam/hisilicon/dv/player/PlayControlThread.java`

字段/常量（49）：
- `int CONTROL_FAIL = 101`  L14
- `int CONTROL_SUCCESS = 100`  L15
- `int IMAGE_PLAY = 103`  L16
- `int IMAGE_PLAY_RESULT = 104`  L17
- `int IMAGE_STOP_RESULT = 105`  L18
- `int LOCAL_PLAY_SET_URI_RESULT = 26`  L19
- `int PLAY_ERROR = 400`  L20
- `int SEEKBAR_MAX = 100`  L21
- `int SEEK_BUFFERRING_END = 302`  L22
- `int SEEK_BUFFERRING_LOAD = 301`  L23
- `int SEEK_BUFFERRING_START = 300`  L24
- `int SET_VOLUME = 17`  L25
- `int SET_VOLUME_RESULT = 24`  L26
- `String TAG = "PlayControlThread"`  L27
- `int UNSUPPORT_OPERATE = 200`  L28
- `int UPDATE_PLAY_STATE_NO_MEDIA_PRESENT = 206`  L29
- `int UPDATE_PLAY_STATE_PAUSED = 204`  L30
- `int UPDATE_PLAY_STATE_PLAYING = 203`  L31
- `int UPDATE_PLAY_STATE_STOPPED = 205`  L32
- `int UPDATE_POSITION = 201`  L33
- `int UPDATE_VOLUME = 202`  L34
- `int VIDEO_PAUSE = 15`  L35
- `int VIDEO_PAUSE_RESULT = 21`  L36
- `int VIDEO_PLAY = 13`  L37
- `int VIDEO_PLAY_RESULT = 22`  L38
- `int VIDEO_PULL = 12`  L39
- `int VIDEO_SEEK = 16`  L40
- `int VIDEO_SEEK_RESULT = 23`  L41
- `int VIDEO_STOP = 14`  L42
- `int VIDEO_STOP_RESULT = 106`  L43
- `boolean bPlaying`  L44
- `boolean mBquit`  L45
- `Context mContext`  L46
- `Object mPlayLock`  L47
- `HiDVPlayerInterface mPlayer`  L48
- `Handler mUIHandler`  L49
- `SurfaceHolder videoSurfaceHolder`  L50
- `HiDVPlayerInterface hiDVPlayerInterface = this.mPlayer`  L80
- `InterruptedException e`  L108
- `int i = msg.what`  L116
- `boolean zPlay = false`  L117
- `HiDVPlayerInterface hiDVPlayerInterface = this.mPlayer`  L121
- `HiDVPlayerInterface hiDVPlayerInterface2 = this.mPlayer`  L187
- `HiDVPlayerInterface hiDVPlayerInterface3 = this.mPlayer`  L203
- `HiDVPlayerInterface hiDVPlayerInterface4 = this.mPlayer`  L213
- `HiDVPlayerInterface hiDVPlayerInterface = this.mPlayer`  L233
- `HiDVPlayerInterface hiDVPlayerInterface = this.mPlayer`  L243
- `HiDVPlayerInterface hiDVPlayerInterface = this.mPlayer`  L253
- `HiDVPlayerInterface hiDVPlayerInterface = this.mPlayer`  L263

方法（20）：
- `void onBufferring(int percent)`  L53 @Override
- `void onMediaChanged(String currentURI)`  L57 @Override
- `void unRegisterDeviceListener()`  L60
- `public PlayControlThread(String name, Handler handler)`  L63
- `public PlayControlThread(String name, Handler handler, Context context)`  L67
- `void stopPlayer()`  L76
- `void startPlayer(SurfaceHolder surfaceHolder)`  L90
- `void start()`  L96 @Override
- `boolean quit()`  L101 @Override
- `boolean handleMessage(Message msg)`  L107 @Override
- `int getVideoHeight()`  L231
- `int getVideoWidth()`  L241
- `int getDuration()`  L251
- `int getCurrentPosition()`  L261
- `void unRegisterPlayListener()`  L271
    - 体内字面量："575421546" · "unRegisterPlayListener:  ---------------  å»é¤æ³¨åçå¬" · "575421546" · "unRegisterPlayListener:  ---------------  mPlayer==null"
- `void onTransportStateChange(HiDVPlayerInterface.HiDVPlayerStatus currentStatus)`  L283 @Override
    - 体内字面量："currentStatus=" · "onTransportStateChange: Playing" · "onTransportStateChange: Stoped" · "onTransportStateChange: Paused"
- `void onError(String msg)`  L305 @Override
- `void onUpdateProgress(int durantion, int currentPostion)`  L314 @Override
- `void onUpdateVolume(int volume)`  L325 @Override
- `void onSeekBufferringState(HiDVPlayerInterface.HiDVPlayerSeekStatus state, int percent)`  L370 @Override
### `com.gku.actioncam.hisilicon.dv.player.PlayControlThread$AnonymousClass1`
L333 · [class] static AnonymousClass1 · `com/gku/actioncam/hisilicon/dv/player/PlayControlThread.java`

字段/常量（2）：
- `int[] $SwitchMap$com$gku$actioncam$hisilicon$dv$player$HiDVPlayerInterface$HiDVPlayerSeekStatus`  L334
- `int[] $SwitchMap$com$gku$actioncam$hisilicon$dv$player$HiDVPlayerInterface$HiDVPlayerStatus`  L335
### `com.gku.actioncam.hisilicon.dv.player.VideoControlActivity`
L35 · [class] public VideoControlActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/player/VideoControlActivity.java`

字段/常量（45）：
- `String INTENT_FLAG_LIST = "list"`  L36
- `String INTENT_FLAG_START_INDEX = "start"`  L37
- `int MSG_HIDE_OVERLAY = 3`  L38
- `int MSG_REFRESH_PROGRESS = 1`  L39
- `int MSG_SHOW_OVERLAY = 2`  L40
- `String TAG = "VideoControlActivity"`  L41
- `float density`  L42
- `WifiDisconnectReceiver disconnectReceiver`  L43
- `ImageView imageLine`  L44
- `int mCurrentPosition`  L45
- `Dialog mLoadingDialog`  L46
- `Handler mPlayControlHandler`  L47
- `int screenHeight`  L48
- `int screenWidth`  L49
- `TextView txtDialog`  L50
- `View vDialog`  L51
- `ImageView ivBack = null`  L52
- `ImageView ivPlay = null`  L53
- `ImageView ivNext = null`  L54
- `ImageView ivPrev = null`  L55
- `RelativeLayout layoutOverlay = null`  L56
- `TextView tvCurrentPosition = null`  L57
- `TextView tvDuration = null`  L58
- `TextView tvTitle = null`  L59
- `SeekBar seekBar = null`  L60
- `SurfaceView surface = null`  L61
- `boolean bSeeking = false`  L62
- `int srcVideoHeight = 0`  L63
- `ArrayList<String> mAllURIs = null`  L64
- `int playingIndex = 0`  L65
- `boolean isDestory = false`  L66
- `boolean isPause = false`  L67
- `boolean isPlaying = true`  L68
- `boolean isClickPlay = false`  L69
- `boolean isShowOverlay = true`  L70
- `int mDuration = 0`  L71
- `PlayControlThread mPlayControlThread = null`  L72
- `boolean mTouchHandUp = true`  L75
- `PlayControlThread playControlThread = this.mPlayControlThread`  L84
- `WifiDisconnectReceiver wifiDisconnectReceiver = this.disconnectReceiver`  L310
- `Dialog dialog = this.mLoadingDialog`  L323
- `int i`  L516
- `int i = time / 3600`  L618
- `int i2 = time % 3600`  L619
- `int i = this.srcVideoHeight`  L645

方法（31）：
- `void run()`  L78 @Override
- `void startPlayControlHandler()`  L83
- `void stopMessageHandler()`  L93
- `void videoPushDmr(View v)`  L220
    - 体内字面量："575421546" · "videoPushDmr:  ---------------------   23333" · "575421546" · "videoPushDmr:  ---------------------   2444444" · "575421546" · "videoPushDmr:  ---------------------   66666"
- `void onCreate(Bundle savedInstanceState)`  L235 @Override
    - 体内字面量："onCreate" · "start"
- `void run()`  L263 @Override
- `void lambda$onCreate$1()`  L270
- `void run()`  L273 @Override
- `void lambda$onCreate$0()`  L280
- `void refreshViewStatus()`  L285
    - 体内字面量："00:00:00" · "00:00:00"
- `void onResume()`  L296 @Override
    - 体内字面量："4564654654654654654" · "onResume"
- `void onStop()`  L308 @Override
    - 体内字面量："onStop"
- `void onDestroy()`  L320 @Override
    - 体内字面量："onDestroy"
- `void onConfigurationChanged(Configuration newConfig)`  L335 @Override
    - 体内字面量："onConfigurationChanged()"
- `boolean onTouchEvent(MotionEvent event)`  L342 @Override
    - 体内字面量："ACTION_DOWN MSG_REFRESH_PROGRESS"
- `void lambda$new$2()`  L357
- `void setCallbacks()`  L446
- `void onClick(View view)`  L451 @Override
- `void onClick(View view)`  L457 @Override
    - 体内字面量："Prev" · "Next" · "575421546" · "onClick: ------------------------2"
- `void onClick(View view)`  L481 @Override
- `void lambda$setCallbacks$3(View view)`  L488
    - 体内字面量："Pause" · "575421546" · "onClick:  -------------------   1" · "Play"
- `void refreshTitleBar()`  L504
    - 体内字面量：" (%d/%d)" · "45615312" · "refreshTitleBar:  ------------------   "
- `void refreshProgress()`  L515
- `boolean isAutoBrightness()`  L528
    - 体内字面量："screen_brightness_mode"
- `void updateScreenWidthHeight()`  L537
- `void findAllViews()`  L545
    - 体内字面量："layout_inflater"
- `void showLoadingDialog(boolean show)`  L586
    - 体内字面量："575421546" · "showLoadingDialog:  --------------  å¤ä½ç´æ¥ç»æï¼"
- `void onCancel(DialogInterface dialog2)`  L597 @Override
- `String seconds2String(int time)`  L617
- `void resizeSurfaceView(Configuration newConfig)`  L624
    - 体内字面量："Screen:[%d,%d], Video:[%d,%d], Set Surface:[%d,%d]"
- `void onPause()`  L681 @Override
### `com.gku.actioncam.hisilicon.dv.player.VideoControlActivity$EventHandler`
L367 · [class] private static EventHandler · extends `Handler` · `com/gku/actioncam/hisilicon/dv/player/VideoControlActivity.java`

字段/常量（2）：
- `WeakReference<VideoControlActivity> activity`  L368
- `int i = msg.what`  L382

方法（2）：
- `public EventHandler(VideoControlActivity anActivity)`  L370
- `void handleMessage(Message msg)`  L376 @Override
    - 体内字面量："WeakReference Outer Activity is NULL"
### `com.gku.actioncam.hisilicon.dv.player.VideoControlActivity$PlayStateChangedHandler`
L97 · [class] private PlayStateChangedHandler · extends `Handler` · `com/gku/actioncam/hisilicon/dv/player/VideoControlActivity.java`

字段/常量（8）：
- `int i = msg.what`  L104
- `VideoControlActivity videoControlActivity = VideoControlActivity.this`  L110
- `VideoControlActivity videoControlActivity2 = VideoControlActivity.this`  L113
- `int i2 = VideoControlActivity.this.mDuration`  L123
- `TextView textView = VideoControlActivity.this.tvDuration`  L134
- `VideoControlActivity videoControlActivity3 = VideoControlActivity.this`  L135
- `TextView textView2 = VideoControlActivity.this.tvCurrentPosition`  L140
- `VideoControlActivity videoControlActivity4 = VideoControlActivity.this`  L141

方法（2）：
- `private PlayStateChangedHandler()`  L98
- `void handleMessage(Message msg)`  L102 @Override
    - 体内字面量："msg.what = "
### `com.gku.actioncam.hisilicon.dv.player.VideoControlActivity$SeekListener`
L408 · [class] private SeekListener · implements `SeekBar.OnSeekBarChangeListener` · `com/gku/actioncam/hisilicon/dv/player/VideoControlActivity.java`

字段/常量（2）：
- `TextView textView = VideoControlActivity.this.tvCurrentPosition`  L425
- `VideoControlActivity videoControlActivity = VideoControlActivity.this`  L426

方法（4）：
- `private SeekListener()`  L409
- `void onStartTrackingTouch(SeekBar seekBar)`  L413 @Override
- `void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)`  L421 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L431 @Override
    - 体内字面量："setSeekP="
### `com.gku.actioncam.hisilicon.dv.player.VideoControlActivity$setOntouchListen`
L566 · [class] private setOntouchListen · implements `View.OnTouchListener` · `com/gku/actioncam/hisilicon/dv/player/VideoControlActivity.java`

方法（2）：
- `private setOntouchListen()`  L567
- `boolean onTouch(View v, MotionEvent event)`  L571 @Override
### `com.gku.actioncam.hisilicon.dv.player.VideoControlActivity$SurfaceHolderCallback`
L653 · [class] private SurfaceHolderCallback · implements `SurfaceHolder.Callback` · `com/gku/actioncam/hisilicon/dv/player/VideoControlActivity.java`

方法（4）：
- `private SurfaceHolderCallback()`  L654
- `void surfaceCreated(SurfaceHolder surfaceHolder)`  L658 @Override
    - 体内字面量："575421546" · "surfaceCreated()" · "575421546" · "surfaceCreated:  ------------------- 3"
- `void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height)`  L666 @Override
    - 体内字面量："surfaceChanged(), [%d,%d], format:%d"
- `void surfaceDestroyed(SurfaceHolder surfaceHolder)`  L671 @Override
    - 体内字面量："surfaceDestroyed()"