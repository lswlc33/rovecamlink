# XTU GO — 类与成员明细：icatch.streaming

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 6 个文件 / 10 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `icatch.streaming.CameraStreaming`
L14 · [class] public CameraStreaming · `icatch/streaming/CameraStreaming.java`

字段/常量（28）：
- `MediaCodec decoder`  L15
- `H264DecoderThread h264DecoderThread`  L16
- `SurfaceHolder holder`  L17
- `ICatchIStreamProvider iCatchIStreamProvider`  L18
- `MjpgDecoderThread mjpgDecoderThread`  L19
- `int previewCodec`  L20
- `PanoramaPreviewPlayback previewPlayback`  L21
- `StreamProvider streamProvider`  L22
- `Surface surface`  L23
- `ICatchVideoFormat videoFormat`  L24
- `String TAG = "CameraStreaming"`  L25
- `boolean isStreaming = false`  L26
- `boolean freezeDecoder = false`  L27
- `int frmW = 0`  L28
- `int frmH = 0`  L29
- `int viewWidth = 0`  L30
- `int viewHeigth = 0`  L31
- `int i2 = this.previewCodec`  L93
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L113
- `H264DecoderThread h264DecoderThread = this.h264DecoderThread`  L118
- `int i`  L135
- `int i2`  L136
- `int i3 = this.viewWidth`  L138
- `int i4 = this.frmH`  L142
- `SurfaceHolder surfaceHolder = this.holder`  L145
- `int i5 = this.viewWidth`  L146
- `int i6 = this.previewCodec`  L150
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L152

方法（9）：
- `public CameraStreaming(PanoramaPreviewPlayback panoramaPreviewPlayback)`  L33
- `void setSurface(SurfaceHolder surfaceHolder)`  L37
    - 体内字面量："initSurface: "
- `void setViewParam(int i, int i2)`  L43
- `void disnableRender()`  L48
- `int start(ICatchStreamParam iCatchStreamParam, boolean z)`  L53
    - 体内字面量："startStreaming, enableAudio: " · "surface is not set" · "apv streaming already started" · "sdk start streamProvider ret =" · "sdk start streamProvider OK" · "get video format err: "
- `void startDecoderThread(int i, ICatchVideoFormat iCatchVideoFormat)`  L84
    - 体内字面量："start startDecoderThread" · "start startDecoderThread videoFormat=" · "start startDecoderThread previewCodec=" · " enableAudio="
- `boolean stop()`  L110
    - 体内字面量："stopStreaming isStreaming = " · "stopMPreview preview"
- `boolean isStreaming()`  L129
    - 体内字面量："get getStream: "
- `void setSurfaceViewArea()`  L134
### `icatch.streaming.H264DecoderThread`
L20 · [class] public H264DecoderThread · `icatch/streaming/H264DecoderThread.java`

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
- `double curVideoPts = AudioStats.AUDIO_AMPLITUDE_NONE`  L36
- `VideoThread videoThread = this.videoThread`  L70
- `AudioThread audioThread = this.audioThread`  L74
- `AudioThread audioThread = this.audioThread`  L79
- `VideoThread videoThread = this.videoThread`  L83
- `ICatchVideoFormat iCatchVideoFormat = this.videoFormat`  L185

方法（6）：
- `public H264DecoderThread(StreamProvider streamProvider, Surface surface, int i)`  L38
- `void setframePtsChangedListener(VideoFramePtsChangedListener videoFramePtsChangedListener)`  L50
- `void start(boolean z, boolean z2)`  L54
    - 体内字面量："start"
- `boolean isAlive()`  L69
- `void stop()`  L78
- `void setFormat()`  L184
### `icatch.streaming.H264DecoderThread$AudioThread`
L207 · [class] private AudioThread · extends `Thread` · `icatch/streaming/H264DecoderThread.java`

字段/常量（2）：
- `AudioTrack audioTrack`  L208
- `boolean done`  L209

方法（3）：
- `private AudioThread()`  L211
- `void run()`  L216 @Override
    - 体内字面量："Run AudioThread" · "Run AudioThread audioFormat is null!" · "Run AudioThread 3" · "getNextVideoFrame " · "stopMPreview audio thread"
- `void requestExitAndWait()`  L252
### `icatch.streaming.H264DecoderThread$VideoThread`
L90 · [class] private VideoThread · extends `Thread` · `icatch/streaming/H264DecoderThread.java`

字段/常量（7）：
- `MediaCodec.BufferInfo info`  L91
- `long startTime = 0`  L92
- `int frameSize = 0`  L93
- `boolean done = false`  L94
- `byte[] bArr = new byte[H264DecoderThread.this.frameWidth * H264DecoderThread.this.frameHeight * 4]`  L104
- `boolean z = true`  L109
- `ByteBuffer byteBuffer = inputBuffers[iDequeueInputBuffer]`  L129

方法（3）：
- `void run()`  L100 @Override
    - 体内字面量："h264 run for gettting surface image"
- `boolean dequeueAndRenderOutputBuffer(int i)`  L162
    - 体内字面量："ok show image!.....................startTime= " · " frameSize=" · " curVideoPts="
- `void requestExitAndWait()`  L176
    - 体内字面量："H264Decoder requestExitAndWait isAlive=" · "end  H264Decoder requestExitAndWait"
### `icatch.streaming.MjpgDecoderThread`
L20 · [class] public MjpgDecoderThread · `icatch/streaming/MjpgDecoderThread.java`

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
- `VideoThread videoThread = this.videoThread`  L68
- `AudioThread audioThread = this.audioThread`  L72
- `AudioThread audioThread = this.audioThread`  L77
- `VideoThread videoThread = this.videoThread`  L81
- `Canvas canvasLockCanvas`  L214

方法（6）：
- `public MjpgDecoderThread(StreamProvider streamProvider, SurfaceHolder surfaceHolder, int i, int i2, int i3)`  L36
    - 体内字面量："start frameHeight=" · " frameWidth="
- `void setframePtsChangedListener(VideoFramePtsChangedListener videoFramePtsChangedListener)`  L49
- `void start(boolean z, boolean z2)`  L53
    - 体内字面量："start"
- `boolean isAlive()`  L67
- `void stop()`  L76
- `void redrawBitmap(SurfaceHolder surfaceHolder, int i, int i2)`  L213
### `icatch.streaming.MjpgDecoderThread$AudioThread`
L160 · [class] private AudioThread · extends `Thread` · `icatch/streaming/MjpgDecoderThread.java`

字段/常量（2）：
- `AudioTrack audioTrack`  L161
- `boolean done`  L162

方法（3）：
- `private AudioThread()`  L164
- `void run()`  L169 @Override
    - 体内字面量："Run AudioThread" · "Run AudioThread audioFormat is null!" · "Run AudioThread 3" · "AudioThread run  while (!done)=" · "getNextVideoFrame  AudioThread " · "stopMPreview audio thread"
- `void requestExitAndWait()`  L206
    - 体内字面量："123->" · "MjpgDecoderThread AudioThread requestExitAndWait"
### `icatch.streaming.MjpgDecoderThread$VideoThread`
L87 · [class] private VideoThread · extends `Thread` · `icatch/streaming/MjpgDecoderThread.java`

字段/常量（7）：
- `ByteBuffer bmpBuf`  L88
- `boolean done = false`  L89
- `byte[] pixelBuf`  L90
- `byte[] bArr = new byte[MjpgDecoderThread.this.frameWidth * MjpgDecoderThread.this.frameHeight * 4]`  L93
- `boolean z = false`  L106
- `boolean z2 = true`  L107
- `MjpgDecoderThread mjpgDecoderThread = MjpgDecoderThread.this`  L130

方法（2）：
- `void run()`  L101 @Override
    - 体内字面量："start running video thread"
- `void requestExitAndWait()`  L153
    - 体内字面量："123->" · "MjpgDecoderThread VideoThread requestExitAndWait"
### `icatch.streaming.RenderType`
L4 · [enum] public RenderType · `icatch/streaming/RenderType.java`

枚举常量（2）：
- `NO_RENDER()`  L5
- `PANORAMA_RENDER()`  L6
### `icatch.streaming.VideoFramePtsChangedListener`
L4 · [interface] public VideoFramePtsChangedListener · `icatch/streaming/VideoFramePtsChangedListener.java`

方法（1）：
- `void onFramePtsChanged(double d)`  L5
### `icatch.streaming.VideoStreaming`
L16 · [class] public VideoStreaming · `icatch/streaming/VideoStreaming.java`

字段/常量（44）：
- `boolean enableRender`  L17
- `H264DecoderThread h264DecoderThread`  L18
- `SurfaceHolder holder`  L19
- `ICatchIStreamProvider iCatchIStreamProvider`  L20
- `ICatchSurfaceContext iCatchSurfaceContext`  L21
- `MjpgDecoderThread mjpgDecoderThread`  L22
- `int previewCodec`  L23
- `StreamProvider streamProvider`  L24
- `Surface surface`  L25
- `ICatchVideoFormat videoFormat`  L26
- `PanoramaVideoPlayback videoPlayback`  L27
- `String TAG = "VideoStreaming"`  L28
- `boolean isStreaming = false`  L29
- `boolean needRelease = false`  L30
- `int frmW = 0`  L31
- `int frmH = 0`  L32
- `int viewWidth = 0`  L33
- `int viewHeigth = 0`  L34
- `VideoFramePtsChangedListener framePtsChangedListener = null`  L35
- `String tag = "123->"`  L36
- `ICatchSurfaceContext iCatchSurfaceContext`  L75
- `int i`  L87
- `int i2 = 0`  L110
- `int i2 = this.previewCodec`  L146
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L169
- `H264DecoderThread h264DecoderThread = this.h264DecoderThread`  L174
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L194
- `H264DecoderThread h264DecoderThread = this.h264DecoderThread`  L199
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L231
- `int i`  L244
- `int i2`  L245
- `SurfaceHolder surfaceHolder`  L246
- `int i3`  L247
- `int i4 = this.frmH`  L250
- `SurfaceHolder surfaceHolder2 = this.holder`  L253
- `int i5 = this.viewWidth`  L254
- `int i6 = this.previewCodec`  L258
- `MjpgDecoderThread mjpgDecoderThread = this.mjpgDecoderThread`  L260
- `SurfaceHolder surfaceHolder3 = this.holder`  L267
- `int i7 = this.viewWidth`  L268
- `SurfaceHolder surfaceHolder4 = this.holder`  L272
- `int i8 = this.viewHeigth`  L273
- `boolean zVideoSeek`  L282
- `boolean zResumePlayback`  L296

方法（16）：
- `public VideoStreaming(PanoramaVideoPlayback panoramaVideoPlayback)`  L38
- `void changePanoramaType(int i)`  L42
- `void setFramePtsChangedListener(VideoFramePtsChangedListener videoFramePtsChangedListener)`  L48
- `void initSurface(boolean z, SurfaceHolder surfaceHolder, long j, long j2)`  L52
- `void setViewParam(int i, int i2)`  L66
- `void setDrawingArea(int i, int i2)`  L74
- `boolean play(ICatchFile iCatchFile, boolean z, boolean z2)`  L86
- `void startDecoderThread(int i, ICatchVideoFormat iCatchVideoFormat)`  L138
    - 体内字面量："start startDecoderThread videoFormat=" · "start startDecoderThread previewCodec=" · " enableAudio="
- `boolean stop()`  L165
    - 体内字面量："stopStreaming enableRender=" · " isStreaming = " · "stopMPreview preview"
- `boolean compelStop()`  L191
    - 体内字面量："stopStreaming enableRender=" · " isStreaming = " · "stopMPreview preview"
- `boolean release()`  L220
    - 体内字面量："pancamGLRelease enableRender=" · " needRelease = "
- `void removeSurface(int i)`  L230
- `boolean isStreaming()`  L238
    - 体内字面量："get getStream: "
- `void setSurfaceViewArea()`  L243
- `boolean videoSeek(double d)`  L281
- `boolean resumePlayback()`  L295