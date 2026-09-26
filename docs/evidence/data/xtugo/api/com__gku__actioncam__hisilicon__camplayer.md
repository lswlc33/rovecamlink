# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.camplayer

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.camplayer.HiCamPlayer`
L14 · [class] public HiCamPlayer · `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java`

字段/常量（47）：
- `int MEDIA_ASR_CHANGE = 300`  L15
- `int MEDIA_BUFFERING_UPDATE = 3`  L16
- `int MEDIA_ERROR = 100`  L17
- `int MEDIA_ERROR_SERVER_DIED = 100`  L18
- `int MEDIA_ERROR_UNKNOWN = 1`  L19
- `int MEDIA_FILE_EOF = 400`  L20
- `int MEDIA_INFO = 200`  L21
- `int MEDIA_PLAYBACK_BUFFERING_END = 702`  L22
- `int MEDIA_PLAYBACK_BUFFERING_START = 701`  L23
- `int MEDIA_PLAYBACK_INFO = 2`  L24
- `int MEDIA_PLAYBACK_LOADING_PERCNT = 711`  L25
- `int MEDIA_PLAYBACK_PAUSED = 7`  L26
- `int MEDIA_PLAYBACK_PREPARED = 1`  L27
- `int MEDIA_PLAYBACK_STARTED = 6`  L28
- `int MEDIA_PLAYBACK_STOPPED = 8`  L29
- `int MEDIA_PREPARED = 1`  L30
- `int MEDIA_STREAM_TYPE_AUDIO = 2`  L31
- `int MEDIA_STREAM_TYPE_METADATA = 3`  L32
- `int MEDIA_STREAM_TYPE_UNKOWN = 4`  L33
- `int MEDIA_STREAM_TYPE_VIDEO = 1`  L34
- `String TAG = "HICAMPlayer"`  L35
- `AudioTrack mAudioTrack`  L36
- `onSeekBufferingStateListener mSeekBufferingStateListener`  L37
- `SurfaceHolder mSurfaceHolder`  L38
- `long mNativeContext = 0`  L39
- `long mNativeField = 0`  L40
- `long mNativeSurface = 0`  L41
- `Surface mSurface = null`  L42
- `PowerManager.WakeLock mWakeLock = null`  L43
- `HiCamPlayerStateListener mCamPlayerListener = null`  L44
- `boolean mScreenOnWhilePlaying = false`  L45
- `boolean mStayAwake = false`  L46
- `int i = Build.VERSION.SDK_INT`  L189
- `AudioTrack audioTrack = mAudioTrack`  L201
- `AudioTrack audioTrack = mAudioTrack`  L253
- `AudioTrack audioTrack = mAudioTrack`  L263
- `SurfaceHolder surfaceHolder = this.mSurfaceHolder`  L275
- `HiCamPlayerStateListener hiCamPlayerStateListener = hiCamPlayer.mCamPlayerListener`  L283
- `onSeekBufferingStateListener onseekbufferingstatelistener = hiCamPlayer.mSeekBufferingStateListener`  L284
- `HiCamPlayerStateListener hiCamPlayerStateListener = hiCamPlayer.mCamPlayerListener`  L353
- `HiCamPlayerStateListener hiCamPlayerStateListener2 = hiCamPlayer.mCamPlayerListener`  L364
- `HiCamPlayerStateListener hiCamPlayerStateListener3 = hiCamPlayer.mCamPlayerListener`  L374
- `PowerManager.WakeLock wakeLock = this.mWakeLock`  L388
- `AudioTrack audioTrack = mAudioTrack`  L402
- `AudioTrack audioTrack = mAudioTrack`  L410
- `int i = channelConfig == 2 ? 4 : 12`  L418
- `int i2 = 0`  L421

方法（52）：
- `RecFrameInfo _getRecordAudio(ByteBuffer byteBuf)`  L77
- `RecFrameInfo _getRecordVideo(ByteBuffer byteBuf)`  L79
- `YuvFrameInfo _getSnapData(ByteBuffer byteBuf)`  L81
- `StreamInfo[] _getStreamInfo()`  L83
- `int _invoke(int msgId, int what, int extra)`  L85
- `void _pause()`  L87
- `void _release()`  L89
- `void _reset()`  L91
- `int _selectIndex(int index)`  L93
- `void _setDataSource(String URL)`  L95
- `void _setRecordFlag(int flag)`  L97
- `void _setVideoSurface(Surface surface, int apiVersion)`  L99
- `void _start()`  L101
- `void _stop()`  L103
- `void native_init()`  L105
- `void native_setup(Object mediaplayer_this)`  L107
- `void setMaxResolution(int maxWidth, int maxHeight)`  L109
- `void setSaveDataFlag(int flag)`  L111
- `void setVideoMbufLimit(int dropLimit, int clearLimit)`  L113
- `int getCurrentPosition()`  L115
- `int getDuration()`  L117
- `int getVideoHeight()`  L119
- `int getVideoWidth()`  L121
- `boolean isPlaying()`  L123
- `void prepare()`  L125
- `void seekTo(int msec)`  L127
- `void setLivePlayMode(int mode)`  L129
- `public HiCamPlayer()`  L170
- `void setOnSeekBufferingStateListener(onSeekBufferingStateListener listener)`  L174
- `void setHiCamPlayerListener(HiCamPlayerStateListener listener)`  L178
- `void setDisplay(SurfaceHolder sh)`  L182
- `void setRecordFlag(int flag)`  L195
- `void start()`  L199
- `void stop()`  L208
- `RecFrameInfo getRecordVideo(ByteBuffer buffer)`  L213
- `RecFrameInfo getRecordAudio(ByteBuffer buffer)`  L217
- `YuvFrameInfo getSnapData(ByteBuffer buffer)`  L221
- `StreamInfo[] getStreamInfo()`  L225
- `int selectIndex(int index)`  L229
- `void pause()`  L233
- `void setScreenOnWhilePlaying(boolean screenOn)`  L238
- `void setDataSource(String URL)`  L245
- `void release()`  L249
- `void reset()`  L260
- `int invoke(int msgId, int what, int extra)`  L270
- `void updateSurfaceScreenOn()`  L274
- `void onMediaPlayBackInfo(Object mediaplayer_ref, int arg1, int arg2)`  L281
- `void postEventFromNative(Object mediaplayer_ref, int what, int arg1, int arg2, Object obj)`  L343
    - 体内字面量："HiCamPlayer Error listener null~"
- `void stayAwake(boolean awake)`  L387
- `void audioFlush()`  L400
    - 体内字面量："audioFlush"
- `void writePCM(byte[] byteArray)`  L409
- `int configATrack(int streamType, int sampleRate, int channelConfig, int bytesPerSample, int trackMode)`  L417
### `com.gku.actioncam.hisilicon.camplayer.HiCamPlayer$HiCamPlayerState`
L48 · [enum] public HiCamPlayerState · `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java`

枚举常量（5）：
- `HICAMPLAYER_STATE_IDLE()`  L49
- `HICAMPLAYER_STATE_PREPARED()`  L50
- `HICAMPLAYER_STATE_PLAY()`  L51
- `HICAMPLAYER_STATE_PAUSE()`  L52
- `HICAMPLAYER_STATE_STOP()`  L53
### `com.gku.actioncam.hisilicon.camplayer.HiCamPlayer$HiCamPlayerStateListener`
L57 · [interface] public HiCamPlayerStateListener · `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java`

方法（5）：
- `void onASRChange(HiCamPlayer player)`  L58
- `void onBufferingUpdate(HiCamPlayer player, int percent)`  L60
- `void onError(HiCamPlayer player, String msg, int extra)`  L62
- `void onFinish(HiCamPlayer player)`  L64
- `void onStateChange(HiCamPlayer player, HiCamPlayerState state)`  L66
### `com.gku.actioncam.hisilicon.camplayer.HiCamPlayer$onSeekBufferingStateListener`
L69 · [interface] public onSeekBufferingStateListener · `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java`

方法（3）：
- `void onSeekBufferingEnd(HiCamPlayer player)`  L70
- `void onSeekBufferingLoadingPercent(HiCamPlayer player, int percent)`  L72
- `void onSeekBufferingStart(HiCamPlayer player)`  L74
### `com.gku.actioncam.hisilicon.camplayer.HiCamPlayer$RecFrameInfo`
L131 · [class] public RecFrameInfo · `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java`

字段/常量（3）：
- `int frameSize`  L132
- `int payload`  L133
- `long pts`  L134

方法（1）：
- `public RecFrameInfo()`  L136
### `com.gku.actioncam.hisilicon.camplayer.HiCamPlayer$StreamInfo`
L154 · [class] public StreamInfo · `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java`

字段/常量（6）：
- `int audiochn`  L155
- `int height`  L156
- `String mime`  L157
- `int sampleRate`  L158
- `int trackType`  L159
- `int width`  L160

方法（1）：
- `public StreamInfo()`  L162
### `com.gku.actioncam.hisilicon.camplayer.HiCamPlayer$YuvFrameInfo`
L140 · [class] public YuvFrameInfo · `com/gku/actioncam/hisilicon/camplayer/HiCamPlayer.java`

字段/常量（8）：
- `int height`  L141
- `long pts`  L142
- `int uoffset`  L143
- `int upitch`  L144
- `int voffset`  L145
- `int vpitch`  L146
- `int width`  L147
- `int ypitch`  L148

方法（1）：
- `public YuvFrameInfo()`  L150