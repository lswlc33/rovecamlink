# idGoLive — 类与成员明细：com.tinyai.libmediacomponent.engine

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 32 个文件 / 36 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tinyai.libmediacomponent.engine.CameraPreferences`
L18 · [class] public CameraPreferences · `com/tinyai/libmediacomponent/engine/CameraPreferences.java`

字段/常量（4）：
- `String FILE_NAME = "storeInfo"`  L19
- `String PUSH_TEST = "pushTest"`  L21
- `String TAG = "CameraPreferences"`  L22
- `boolean isDebug = true`  L23

方法（11）：
- `MAudioFormat deSerializationAudioFormat(String str)`  L25
    - 体内字面量："ISO-8859-1"
- `MAudioFormat getAudioFormatFromPreferences(Context context, String str)`  L34
    - 体内字面量："_audioFormat" · "end getAudioFormatFromPreferences formatString is null" · "end getAudioFormatFromPreferences Exception:"
- `SharedPreferences getSharedPreferences(Context context, String str)`  L49
    - 体内字面量："mBase" · "mPreferencesDir"
- `boolean readBoolDataByName(Context context, String str)`  L70
- `boolean readBoolDataByName(Context context, String str, boolean z)`  L74
- `int readIntDataByName(Context context, String str)`  L78
    - 体内字面量："readIntDataByName name=" · " value="
- `String readStringDataByName(Context context, String str)`  L84
- `void writeDataByName(Context context, String str, int i)`  L88
- `void writeDataByName(Context context, String str, String str2)`  L94
- `void writeDataByName(Context context, String str, boolean z)`  L100
- `void writeIntDataByName(Context context, String str, int i)`  L106
    - 体内字面量："writeIntDataByName name=" · " value="
### `com.tinyai.libmediacomponent.engine.ICameraObserver`
L4 · [interface] public ICameraObserver · `com/tinyai/libmediacomponent/engine/ICameraObserver.java`

方法（1）：
- `void notify(Object obj)`  L5
### `com.tinyai.libmediacomponent.engine.listener.FramePtsChangedListener`
L4 · [interface] public FramePtsChangedListener · `com/tinyai/libmediacomponent/engine/listener/FramePtsChangedListener.java`

方法（1）：
- `void onFramePtsChanged(double d)`  L5
### `com.tinyai.libmediacomponent.engine.listener.StreamFormatListener`
L6 · [interface] public StreamFormatListener · `com/tinyai/libmediacomponent/engine/listener/StreamFormatListener.java`

方法（1）：
- `void onFormatChanged(MVideoFormat mVideoFormat)`  L7
### `com.tinyai.libmediacomponent.engine.streaming.EventListener`
L6 · [interface] public EventListener · `com/tinyai/libmediacomponent/engine/streaming/EventListener.java`

方法（5）：
- `void onBufferingProgressChanged(int i, int i2)`  L7
- `void onLoadingChanged(int i)`  L9
- `void onPlayProgressChanged(double d)`  L11
- `void onPlaybackError(String str)`  L13
- `void onPlaybackStateChanged(PlayState playState)`  L15
### `com.tinyai.libmediacomponent.engine.streaming.exception.PreviewingByOthersException`
L4 · [class] public PreviewingByOthersException · extends `Exception` · `com/tinyai/libmediacomponent/engine/streaming/exception/PreviewingByOthersException.java`

字段/常量（1）：
- `long serialVersionUID = 1`  L5

方法（2）：
- `public PreviewingByOthersException()`  L7
- `public PreviewingByOthersException(String str)`  L10
### `com.tinyai.libmediacomponent.engine.streaming.exception.TryAgainException`
L4 · [class] public TryAgainException · extends `Exception` · `com/tinyai/libmediacomponent/engine/streaming/exception/TryAgainException.java`
### `com.tinyai.libmediacomponent.engine.streaming.GLPoint`
L4 · [class] public GLPoint · `com/tinyai/libmediacomponent/engine/streaming/GLPoint.java`

字段/常量（2）：
- `float x`  L5
- `float y`  L6

方法（6）：
- `public GLPoint()`  L8
- `public GLPoint(float f, float f2)`  L13
- `float getX()`  L18
- `float getY()`  L22
- `void setX(float f)`  L26
- `void setY(float f)`  L30
### `com.tinyai.libmediacomponent.engine.streaming.Headset.HeadsetBase`
L12 · [class] public abstract HeadsetBase · `com/tinyai/libmediacomponent/engine/streaming/Headset/HeadsetBase.java`

字段/常量（7）：
- `String TAG = "HeadsetBase"`  L13
- `AudioManager audioManager`  L14
- `Context context`  L15
- `HeadsetReciver headsetReciver`  L16
- `IntentFilter intentFilter`  L17
- `String str = TAG`  L79
- `HeadsetReciver headsetReciver = this.headsetReciver`  L117

方法（10）：
- `private HeadsetBase()`  L63
- `public HeadsetBase(Context context)`  L66
    - 体内字面量："audio" · "android.intent.action.HEADSET_PLUG" · "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED" · "android.bluetooth.adapter.action.STATE_CHANGED"
- `void audioTransfer2BluetoothHeadset()`  L78
- `void audioTransfer2Speaker()`  L88
    - 体内字面量："audioTransfer2Speaker: have setted"
- `void audioTransfer2WiredHeadset()`  L94
    - 体内字面量："audioTransfer2WiredHeadset: have setted"
- `void initAudioMode()`  L101
- `boolean isBluetoothHeadsetConnected()`  L103
- `boolean isWiredHeadsetOn()`  L108
- `void registerHeadsetListener()`  L112
- `void unregisterHeadsetListener()`  L116
### `com.tinyai.libmediacomponent.engine.streaming.Headset.HeadsetBase$HeadsetReciver`
L19 · [class] HeadsetReciver · extends `BroadcastReceiver` · `com/tinyai/libmediacomponent/engine/streaming/Headset/HeadsetBase.java`

方法（1）：
- `void onReceive(Context context, Intent intent)`  L24 @Override
    - 体内字面量："android.intent.action.HEADSET_PLUG" · "state" · "onReceive: intent has no state" · "state" · "onReceive: wiredHeadset connect" · "microphone" · "onReceive: wiredHeadset disconnect" · "android.bluetooth.adapter.action.STATE_CHANGED" · "android.bluetooth.adapter.extra.STATE" · "onReceive: BluetoothState on" · "onReceive: BluetoothState off" · "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED" · "android.bluetooth.adapter.extra.CONNECTION_STATE" · "onReceive: BluetoothHeadset connect" · "onReceive: BluetoothHeadset disconnect"
### `com.tinyai.libmediacomponent.engine.streaming.Headset.HeadsetWiredFirst`
L6 · [class] public HeadsetWiredFirst · extends `HeadsetBase` · `com/tinyai/libmediacomponent/engine/streaming/Headset/HeadsetWiredFirst.java`

方法（2）：
- `public HeadsetWiredFirst(Context context)`  L7
- `void initAudioMode()`  L12 @Override
### `com.tinyai.libmediacomponent.engine.streaming.IPanoramaControl`
L6 · [interface] public IPanoramaControl · `com/tinyai/libmediacomponent/engine/streaming/IPanoramaControl.java`

方法（9）：
- `boolean changePanoramaType(int i)`  L7
- `boolean glTransformLocate(float f)`  L9
- `boolean glTransformLocate(int i, float f, float f2, float f3, long j)`  L11
- `boolean init(int i)`  L13
- `boolean release()`  L15
- `boolean removeSurface(int i)`  L17
- `boolean rotate(GLPoint gLPoint, GLPoint gLPoint2)`  L19
- `boolean setSurface(int i, Surface surface)`  L21
- `boolean setViewPort(int i, int i2)`  L23
### `com.tinyai.libmediacomponent.engine.streaming.IStreamingControl`
L7 · [interface] public IStreamingControl · `com/tinyai/libmediacomponent/engine/streaming/IStreamingControl.java`

方法（17）：
- `IStreamProvider disableRender()`  L8
- `IPanoramaControl enableGLRender()`  L10
- `boolean enableRender(Surface surface)`  L12
- `double getDuration()`  L14
- `IPanoramaControl getPanoramaControl()`  L16
- `boolean isMute()`  L18
- `boolean isOpenStream()`  L20
- `int mute(boolean z)`  L22
- `int pause()`  L24
- `int play()`  L26
- `int resume()`  L28
- `int seek(double d)`  L30
- `void setEventListener(EventListener eventListener)`  L32
- `boolean setVideoQuality(VideoQuality videoQuality)`  L34
- `boolean setViewPort(int i, int i2)`  L36
- `int start(StreamRequest streamRequest)`  L38
- `int stop()`  L40
### `com.tinyai.libmediacomponent.engine.streaming.IStreamProvider`
L9 · [interface] public IStreamProvider · `com/tinyai/libmediacomponent/engine/streaming/IStreamProvider.java`

方法（6）：
- `boolean containsAudioStream()`  L10
- `boolean containsVideoStream()`  L12
- `MAudioFormat getAudioFormat()`  L14
- `boolean getNextAudioFrame(FrameBuffer frameBuffer)`  L16
- `boolean getNextVideoFrame(FrameBuffer frameBuffer)`  L18
- `MVideoFormat getVideoFormat()`  L20
### `com.tinyai.libmediacomponent.engine.streaming.ISurfaceContext`
L6 · [interface] public ISurfaceContext · `com/tinyai/libmediacomponent/engine/streaming/ISurfaceContext.java`

方法（3）：
- `Surface getSurface()`  L7
- `int getSurfaceID()`  L9
- `boolean setViewPort(int i, int i2, int i3, int i4)`  L11
### `com.tinyai.libmediacomponent.engine.streaming.MediaStreamPlayer`
L37 · [class] public MediaStreamPlayer · implements `SensorEventListener` · `com/tinyai/libmediacomponent/engine/streaming/MediaStreamPlayer.java`

字段/常量（65）：
- `MAudioFormat audioFormat`  L38
- `AudioPlayThread audioRunnable`  L39
- `Thread audioThread`  L40
- `Context context`  L41
- `MediaCodec decoder`  L42
- `boolean disableAudio`  L43
- `FramePtsChangedListener framePtsChangedListener`  L44
- `Sensor gyroscopeSensor`  L45
- `RgbaDecoderThread mjpgRunnable`  L46
- `int previewCodec`  L47
- `StreamRequest request`  L48
- `SensorManager sensorManager`  L49
- `IStreamingControl stream`  L50
- `StreamFormatListener streamFormatListener`  L51
- `View surfaceView`  L52
- `String uid`  L53
- `MVideoFormat videoFormat`  L54
- `H264DecodeThread videoRunnable`  L55
- `Thread videoThread`  L56
- `int viewHeigth`  L57
- `int viewWidth`  L58
- `String TAG = "CameraStreaming"`  L59
- `boolean isStreaming = false`  L60
- `boolean freezeDecoder = false`  L61
- `ICameraObserver frameLoadingObserver = null`  L62
- `boolean displayPaused = false`  L63
- `int audioBufferSize = -1`  L64
- `IStreamProvider streamProvider = null`  L65
- `boolean sdkRender = false`  L66
- `int audioSessionId = -1`  L67
- `int streamType = 1`  L68
- `IPanoramaControl iPanoramaControl = null`  L69
- `byte[] bArr3 = {0, 0, 0, 1, 103, 100, 0, 40, -84, 52, -59, 1, -32, 17, Ascii.US, 120, 11, 80, Ascii.DLE, Ascii.DLE, Ascii.US, 0, 0, 3, 3, -23, 0, 0, -22, 96, -108}`  L100
- `byte[] bArr4 = {0, 0, 0, 1, 104, -18, 60, -128}`  L101
- `int i2 = this.previewCodec`  L145
- `IPanoramaControl iPanoramaControl = this.iPanoramaControl`  L188
- `boolean z2 = this.freezeDecoder`  L213
- `View view = this.surfaceView`  L237
- `float f = sensorEvent.values[0]`  L284
- `float f2 = sensorEvent.values[1]`  L285
- `float f3 = sensorEvent.values[2]`  L286
- `MediaCodec mediaCodec = this.decoder`  L298
- `SensorManager sensorManager = this.sensorManager`  L306
- `H264DecodeThread h264DecodeThread = this.videoRunnable`  L327
- `IStreamingControl iStreamingControl = this.stream`  L334
- `H264DecodeThread h264DecodeThread = this.videoRunnable`  L343
- `H264DecodeThread h264DecodeThread = this.videoRunnable`  L354
- `IPanoramaControl iPanoramaControl = this.iPanoramaControl`  L389
- `IStreamingControl iStreamingControl = this.stream`  L393
- `RgbaDecoderThread rgbaDecoderThread = this.mjpgRunnable`  L399
- `int width`  L408
- `int fileHeight`  L409
- `int i`  L410
- `int i2`  L411
- `int i3 = this.viewWidth`  L446
- `int i4 = this.viewWidth`  L453
- `int videoW = 0`  L473
- `int videoH = 0`  L474
- `int i5 = 0`  L475
- `StreamFormatListener streamFormatListener = this.streamFormatListener`  L495
- `IPanoramaControl iPanoramaControl`  L513
- `H264DecodeThread h264DecodeThread = this.videoRunnable`  L522
- `RgbaDecoderThread rgbaDecoderThread = this.mjpgRunnable`  L531
- `AudioPlayThread audioPlayThread = this.audioRunnable`  L540
- `IStreamingControl iStreamingControl = this.stream`  L552

方法（41）：
- `public MediaStreamPlayer(Context context, IStreamingControl iStreamingControl, String str)`  L71
- `StreamRequest getDefaultRequest()`  L78
- `void initAudiobufferSize()`  L82
- `int initVideoDecoder(MVideoFormat mVideoFormat)`  L91
    - 体内字面量："CameraStreaming" · "initVideoDecoder  videoFormat:" · "CameraStreaming" · "initVideoDecoder test01 time=" · "ms"
- `int initVideoDecoder(String str, int i, int i2, byte[] bArr, byte[] bArr2, int i3, int i4)`  L99
- `int play(int i)`  L134
    - 体内字面量："CameraStreaming" · "start startDecoderThread previewCodec=" · " enableAudio=" · "CameraStreaming" · "stream.play() ret = "
- `void registerGyroscopeSensor()`  L177
    - 体内字面量："CameraStreaming" · "registerGyroscopeSensor" · "sensor"
- `void rotate(float f, float f2, float f3, long j)`  L186
- `void createDecoder(String str)`  L194
- `int freezeDecoder(boolean z)`  L202
    - 体内字面量："CameraStreaming" · "start freezeDecoder freeze=" · "CameraStreaming" · "freeze is alreay the state: " · "CameraStreaming" · "resume decoder.... freeze="
- `double getDuration()`  L224
- `IPanoramaControl getPanoramaControl()`  L228
- `StreamRequest getStreamRequest()`  L232
- `Surface getSurface()`  L236
- `boolean isDisplayPaused()`  L250
    - 体内字面量："CameraStreaming" · "displayPaused is ="
- `boolean isFreezing()`  L255
    - 体内字面量："CameraStreaming" · "isFreezing ="
- `boolean isMute()`  L260
- `boolean isPanorama(long j, long j2)`  L264
- `boolean isStreaming()`  L268
    - 体内字面量："CameraStreaming" · "get getStream: "
- `int mute(boolean z)`  L273
- `void onAccuracyChanged(Sensor sensor, int i)`  L278 @Override
- `void onSensorChanged(SensorEvent sensorEvent)`  L282 @Override
- `int pause()`  L293
- `void releaseDecoder()`  L297
- `void removeGyroscopeListener()`  L305
- `int resume()`  L312
- `int seek(double d)`  L316
- `void setAudioSessionId(int i)`  L320
- `void setDisplayPaused(boolean z)`  L324
    - 体内字面量："CameraStreaming" · "set display pause displayPaused is "
- `void setEventListener(EventListener eventListener)`  L333
- `void setFrameLoadingObserver(ICameraObserver iCameraObserver)`  L340
    - 体内字面量："CameraStreaming" · "setFrameLoadingObserver  observer: "
- `void setFramePtsChangedListener(FramePtsChangedListener framePtsChangedListener)`  L349
- `boolean setMediaCodecOutputSurface(Surface surface)`  L353
- `void setStreamFormatListener(StreamFormatListener streamFormatListener)`  L362
- `void setStreamRequest(StreamRequest streamRequest)`  L366
- `void setStreamType(int i)`  L370
- `void setSurfaceView(View view, boolean z)`  L374
    - 体内字面量："CameraStreaming" · "setSurface surface:"
- `boolean setVideoQuality(VideoQuality videoQuality)`  L380
- `boolean setViewPort(int i, int i2, int i3, int i4)`  L384
    - 体内字面量："CameraStreaming" · "setViewPort width=" · " height="
- `boolean start()`  L407
- `boolean stop()`  L512
### `com.tinyai.libmediacomponent.engine.streaming.render.AudioPlayThread`
L14 · [class] public AudioPlayThread · implements `Runnable` · `com/tinyai/libmediacomponent/engine/streaming/render/AudioPlayThread.java`

字段/常量（8）：
- `int audioSessionId`  L15
- `AudioTrack audioTrack`  L16
- `int bufferSize`  L17
- `Context context`  L18
- `boolean done`  L19
- `IStreamProvider stream`  L20
- `String TAG = "AudioPlayThread"`  L21
- `int AUDIO_BUF_SIZE = 10000`  L22

方法（3）：
- `public AudioPlayThread(Context context, IStreamProvider iStreamProvider, int i, int i2)`  L24
- `void run()`  L32 @Override
    - 体内字面量："audio" · "auido mode is : " · "audioSessionId: " · "get audio format err: format is null!" · "get audio frame err: " · "audio play thread, out while, audiotrack release" · "audio play thread end, setMode(AudioManager.MODE_NORMAL)" · "get audio format err: "
- `void stop()`  L86
    - 体内字面量："pausePreview audio play"
### `com.tinyai.libmediacomponent.engine.streaming.render.CodecType`
L4 · [class] public CodecType · `com/tinyai/libmediacomponent/engine/streaming/render/CodecType.java`

字段/常量（2）：
- `int CODEC_H264 = 41`  L5
- `int CODEC_RGBA_8888 = 149`  L6
### `com.tinyai.libmediacomponent.engine.streaming.render.H264DecodeThread`
L14 · [class] public H264DecodeThread · implements `Runnable` · `com/tinyai/libmediacomponent/engine/streaming/render/H264DecodeThread.java`

字段/常量（36）：
- `DecoderState decoderState`  L15
- `FramePtsChangedListener framePtsChangedListener`  L16
- `boolean freeze`  L17
- `ICameraObserver loadingObserver`  L18
- `PreviewCallback previewCallback`  L19
- `IStreamProvider stream`  L20
- `boolean done = false`  L22
- `MediaCodec decoder = null`  L23
- `ByteBuffer[] inputBuffers = null`  L24
- `int BUFFER_SIZE = 8294400`  L25
- `boolean displayPaused = false`  L26
- `boolean outputRender = true`  L27
- `?? r0`  L166
- `?? r4`  L167
- `?? r1`  L168
- `boolean z`  L169
- `?? r2`  L170
- `?? r3`  L171
- `?? r11`  L172
- `?? r5`  L173
- `?? r6`  L174
- `long j`  L175
- `int iDequeueInputBuffer`  L176
- `int iDequeueOutputBuffer`  L177
- `boolean z2`  L178
- `ICameraObserver iCameraObserver`  L179
- `boolean z3`  L180
- `FramePtsChangedListener framePtsChangedListener`  L181
- `?? r7 = 0`  L186
- `boolean z4 = true`  L194
- `ICameraObserver iCameraObserver2 = this.loadingObserver`  L196
- `?? r8 = 1`  L200
- `boolean z5 = true`  L201
- `ICameraObserver iCameraObserver3 = this.loadingObserver`  L210
- `ICameraObserver iCameraObserver4 = this.loadingObserver`  L236
- `?? r9 = r7`  L242

方法（12）：
- `public H264DecodeThread(IStreamProvider iStreamProvider)`  L47
- `boolean canputFrame(FrameBuffer frameBuffer)`  L55
- `void setDecoderState(DecoderOperation decoderOperation)`  L59
    - 体内字面量："setDecoderState operation = " · "decoder status set error, may not set decoder first" · "decoder freeze error, may can not freeze decoder here"
- `void freezeDecoder(boolean z)`  L91
    - 体内字面量："start freezeDecoder: " · "end freezeDecoder"
- `void run()`  L165 @Override
- `void setDecoder(MediaCodec mediaCodec)`  L538
    - 体内字面量："start setDecoder decoder=" · "end setDecoder"
- `void setDisplayPaused(boolean z)`  L547
    - 体内字面量："setDisplayPaused is " · " outputRender=" · "test002 sleep setDisplayPaused outputRender="
- `void setLoadingObserver(ICameraObserver iCameraObserver)`  L562
    - 体内字面量："setLoadingObserver   observer = "
- `void setMediacodeSurface(Surface surface)`  L567
    - 体内字面量："start  setMediacodeSurface surface = " · "test002 start setOutputSurface outputRender=" · "test002 setOutputSurface success" · "test002 setOutputSurface Exception:" · "test002 setOutputSurface Exception:" · ", isRecoverable = " · ", isTransient = " · "end setMediacodeSurface surface = "
- `void setPreviewCallback(PreviewCallback previewCallback)`  L585
- `void setframePtsChangedListener(FramePtsChangedListener framePtsChangedListener)`  L589
    - 体内字面量："start freezeDecoder: "
- `void stop()`  L594
    - 体内字面量："stopPreview video decode thread"
### `com.tinyai.libmediacomponent.engine.streaming.render.H264DecodeThread$DecoderOperation`
L29 · [enum] private DecoderOperation · `com/tinyai/libmediacomponent/engine/streaming/render/H264DecodeThread.java`

枚举常量（2）：
- `set()`  L30
- `freeze()`  L31
### `com.tinyai.libmediacomponent.engine.streaming.render.H264DecodeThread$DecoderState`
L35 · [enum] private DecoderState · `com/tinyai/libmediacomponent/engine/streaming/render/H264DecodeThread.java`

枚举常量（4）：
- `notReady()`  L36
- `ready()`  L37
- `run()`  L38
- `freezed()`  L39
### `com.tinyai.libmediacomponent.engine.streaming.render.H264DecodeThread$PreviewCallback`
L43 · [interface] public PreviewCallback · `com/tinyai/libmediacomponent/engine/streaming/render/H264DecodeThread.java`

方法（1）：
- `void onPreviewFrame(byte[] bArr)`  L44
### `com.tinyai.libmediacomponent.engine.streaming.render.RgbaDecoderThread`
L20 · [class] public RgbaDecoderThread · implements `Runnable` · `com/tinyai/libmediacomponent/engine/streaming/render/RgbaDecoderThread.java`

字段/常量（23）：
- `String TAG = "MjpgDecoderThread"`  L21
- `ByteBuffer bmpBuf`  L22
- `boolean done`  L23
- `Rect drawFrameRect`  L24
- `int frameHeight`  L25
- `FramePtsChangedListener framePtsChangedListener`  L26
- `int frameWidth`  L27
- `ICameraObserver loadingObserver`  L28
- `byte[] pixelBuf`  L29
- `IStreamProvider streamProvider`  L30
- `SurfaceHolder surfaceHolder`  L31
- `MVideoFormat videoFormat`  L32
- `Bitmap videoFrameBitmap`  L33
- `int viewHeight`  L34
- `int viewWidth`  L35
- `byte[] bArr = new byte[this.frameWidth * this.frameHeight * 4]`  L51
- `int i5`  L59
- `int i6 = i3 * i2`  L61
- `int i7 = i4 * i`  L62
- `int i8 = 0`  L63
- `boolean z = true`  L84
- `SurfaceHolder surfaceHolder = this.surfaceHolder`  L98
- `FramePtsChangedListener framePtsChangedListener = this.framePtsChangedListener`  L110

方法（7）：
- `public RgbaDecoderThread(IStreamProvider iStreamProvider, View view, int i, int i2)`  L37
    - 体内字面量："start surface is SurfaceView" · "start frameHeight=" · " frameWidth="
- `Rect getScaledPosition(int i, int i2, int i3, int i4)`  L58
- `void run()`  L79 @Override
    - 体内字面量："start running video thread"
- `void setLoadingObserver(ICameraObserver iCameraObserver)`  L128
    - 体内字面量："setLoadingObserver   observer = "
- `void setViewParam(int i, int i2)`  L133
- `void setframePtsChangedListener(FramePtsChangedListener framePtsChangedListener)`  L138
- `void stop()`  L142
### `com.tinyai.libmediacomponent.engine.streaming.StreamRequest`
L7 · [class] public StreamRequest · `com/tinyai/libmediacomponent/engine/streaming/StreamRequest.java`

字段/常量（3）：
- `boolean disableAudio`  L8
- `PreviewStreamParam previewStreamParam`  L9
- `VideoStreamParam videotreamParam`  L10

方法（5）：
- `public StreamRequest(PreviewStreamParam previewStreamParam, boolean z)`  L12
- `public StreamRequest(VideoStreamParam videoStreamParam, boolean z)`  L17
- `PreviewStreamParam getPreviewStreamParam()`  L22
- `VideoStreamParam getVideotreamParam()`  L26
- `boolean isDisableAudio()`  L30
### `com.tinyai.libmediacomponent.engine.streaming.type.DeviceFile`
L4 · [class] public DeviceFile · `com/tinyai/libmediacomponent/engine/streaming/type/DeviceFile.java`

字段/常量（17）：
- `boolean containsAudio`  L5
- `String fileDate`  L6
- `int fileDuration`  L7
- `boolean fileFavorite`  L8
- `int fileHandle`  L9
- `int fileHeight`  L10
- `int fileMotion`  L11
- `String fileName`  L12
- `String filePath`  L13
- `int fileProtection`  L14
- `long fileSize`  L15
- `String fileTime`  L16
- `int fileType`  L17
- `int fileWidth`  L18
- `double frameRate`  L19
- `String guid`  L20
- `int thumbSize`  L21

方法（28）：
- `public DeviceFile(int i)`  L23
- `public DeviceFile(int i, int i2, String str, long j)`  L27
- `public DeviceFile(int i, int i2, String str, String str2, long j)`  L34
- `public DeviceFile(int i, int i2, String str, String str2, long j, String str3)`  L42
- `public DeviceFile(int i, int i2, String str, String str2, long j, String str3, double d, int i3, int i4)`  L51
- `public DeviceFile(int i, int i2, String str, String str2, long j, String str3, double d, int i3, int i4, int i5, int i6)`  L63
- `public DeviceFile(int i, int i2, String str, String str2, String str3, long j, String str4, String str5, double d, int i3, int i4, int i5, boolean z, int i6, boolean z2, int i7)`  L77
- `boolean containsAudio()`  L96
- `boolean equals(Object obj)`  L100
- `String getFileDate()`  L107
- `int getFileDuration()`  L111
- `boolean getFileFavorite()`  L115
- `int getFileHandle()`  L119
- `int getFileHeight()`  L123
- `int getFileMotion()`  L127
- `String getFileName()`  L131
- `String getFilePath()`  L135
- `int getFileProtection()`  L139
- `long getFileSize()`  L143
- `String getFileTime()`  L147
- `int getFileType()`  L151
- `int getFileWidth()`  L155
- `double getFrameRate()`  L159
- `String getGuid()`  L163
- `int getThumbSize()`  L167
- `int hashCode()`  L171
- `void setFileFavorite(boolean z)`  L175
- `String toString()`  L179
    - 体内字面量："fileHandle: " · ", filePath: " · ", fileName: " · ", fileDate: " · ", fileType: " · ", fileSize: " · ", fileWidth: " · ", fileHeight: " · ", frameRate: "
### `com.tinyai.libmediacomponent.engine.streaming.type.FileType`
L4 · [class] public FileType · `com/tinyai/libmediacomponent/engine/streaming/type/FileType.java`

字段/常量（6）：
- `int FILE_TYPE_ALL = 31`  L5
- `int FILE_TYPE_AUDIO = 4`  L6
- `int FILE_TYPE_EMERGENCY_VIDEO = 16`  L7
- `int FILE_TYPE_IMAGE = 1`  L8
- `int FILE_TYPE_TEXT = 8`  L9
- `int FILE_TYPE_VIDEO = 2`  L10
### `com.tinyai.libmediacomponent.engine.streaming.type.FrameBuffer`
L6 · [class] public FrameBuffer · `com/tinyai/libmediacomponent/engine/streaming/type/FrameBuffer.java`

字段/常量（13）：
- `int aresend`  L7
- `int bitrate`  L8
- `byte[] buffer`  L9
- `int debug`  L10
- `double fps`  L11
- `int frameSize`  L12
- `boolean isIFrame`  L13
- `int netload`  L14
- `int originalFPS`  L15
- `double presentationTime`  L16
- `int rssi`  L17
- `int speakerOn`  L18
- `int vresend`  L19

方法（21）：
- `public FrameBuffer()`  L21
- `public FrameBuffer(int i)`  L24
- `public FrameBuffer(byte[] bArr)`  L28
- `int getAresend()`  L32
- `int getBitrate()`  L36
- `byte[] getBuffer()`  L40
- `ByteBuffer getByteBuffer()`  L44
- `int getDebug()`  L48
- `double getFPS()`  L52
- `int getFrameSize()`  L56
- `boolean getIsIFrame()`  L60
- `int getNetload()`  L64
- `int getOriginalFPS()`  L68
- `double getPresentationTime()`  L72
- `int getRssi()`  L76
- `int getSpeakerOn()`  L80
- `int getVresend()`  L84
- `void setBuffer(byte[] bArr)`  L88
- `boolean setFrameDebugInfo(int i, int i2, int i3, int i4, int i5, double d, int i6, int i7, int i8, boolean z)`  L92
- `void setFrameSize(int i)`  L106
- `void setPresentationTime(double d)`  L110
### `com.tinyai.libmediacomponent.engine.streaming.type.MAudioFormat`
L8 · [class] public MAudioFormat · implements `Serializable` · `com/tinyai/libmediacomponent/engine/streaming/type/MAudioFormat.java`

字段/常量（4）：
- `int codec`  L9
- `int frequency`  L10
- `int nChannels`  L11
- `int sampleBits`  L12

方法（6）：
- `public MAudioFormat(int i, int i2, int i3, int i4)`  L14
- `int getCodec()`  L21
- `int getFrequency()`  L25
- `int getNChannels()`  L29
- `int getSampleBits()`  L33
- `String toString()`  L37
    - 体内字面量："codec" · "frequency" · "sampleBits" · "nChannels"
### `com.tinyai.libmediacomponent.engine.streaming.type.MVideoFormat`
L6 · [class] public MVideoFormat · `com/tinyai/libmediacomponent/engine/streaming/type/MVideoFormat.java`

字段/常量（15）：
- `int bitrate`  L7
- `int codec`  L8
- `byte[] csd_0`  L9
- `int csd_0_size`  L10
- `byte[] csd_1`  L11
- `int csd_1_size`  L12
- `int durationUs`  L13
- `int fps`  L14
- `int frameRate`  L15
- `int gop`  L16
- `int maxInputSize`  L17
- `String mineType`  L18
- `int streamType`  L19
- `int videoH`  L20
- `int videoW`  L21

方法（29）：
- `public MVideoFormat()`  L23
- `public MVideoFormat(int i, int i2, int i3, int i4)`  L26
- `int getBitrate()`  L33
- `int getCodec()`  L37
- `byte[] getCsd_0()`  L41
- `int getCsd_0_size()`  L45
- `byte[] getCsd_1()`  L49
- `int getCsd_1_size()`  L53
- `int getDurationUs()`  L57
- `int getFps()`  L61
- `int getFrameRate()`  L65
- `int getGOP()`  L69
- `int getMaxInputSize()`  L73
- `String getMineType()`  L77
- `int getStreamType()`  L81
- `int getVideoH()`  L85
- `int getVideoW()`  L89
- `void setBitrate(int i)`  L93
- `void setCodec(int i)`  L97
- `void setCsd_0(byte[] bArr, int i)`  L101
- `void setCsd_1(byte[] bArr, int i)`  L106
- `void setDurationUs(int i)`  L111
- `void setFps(int i)`  L115
- `void setGOP(int i)`  L119
- `void setMaxInputSize(int i)`  L123
- `void setMineType(String str)`  L127
- `void setVideoH(int i)`  L131
- `void setVideoW(int i)`  L135
- `String toString()`  L139
    - 体内字面量："mineType=" · ",codec=" · ",videoW=" · ",videoH=" · ",bitrate=" · ",durationUs=" · ",maxInputSize=" · ",fps=" · ",gop=" · ",csd_0_size=" · ",csd_1_size=" · ",csd_0=" · "0x%02x " · ",csd_1=" · "0x%02x " · ","
### `com.tinyai.libmediacomponent.engine.streaming.type.PlayState`
L4 · [enum] public PlayState · `com/tinyai/libmediacomponent/engine/streaming/type/PlayState.java`

枚举常量（3）：
- `IDEA()`  L5
- `PLAY()`  L6
- `PAUSE()`  L7
### `com.tinyai.libmediacomponent.engine.streaming.type.PreviewStreamParam`
L4 · [class] public PreviewStreamParam · `com/tinyai/libmediacomponent/engine/streaming/type/PreviewStreamParam.java`

字段/常量（5）：
- `int bitRate`  L5
- `int codec`  L6
- `int frameRate`  L7
- `int height`  L8
- `int width`  L9

方法（11）：
- `public PreviewStreamParam(int i, int i2, int i3, int i4, int i5)`  L11
- `int getBitRate()`  L19
- `int getCodec()`  L23
- `int getFrameRate()`  L27
- `int getHeight()`  L31
- `int getWidth()`  L35
- `void setBitRate(int i)`  L39
- `void setCodec(int i)`  L43
- `void setFrameRate(int i)`  L47
- `void setHeight(int i)`  L51
- `void setWidth(int i)`  L55
### `com.tinyai.libmediacomponent.engine.streaming.type.StreamMessage`
L4 · [class] public StreamMessage · `com/tinyai/libmediacomponent/engine/streaming/type/StreamMessage.java`

字段/常量（9）：
- `int EVENT_AUDIO_TIMEOUT = 4102`  L5
- `int EVENT_CACHE_PROGRESS_NOTIFY = 4098`  L6
- `int EVENT_CACHE_STATE_CHANGED = 4097`  L7
- `int EVENT_VIDEO_PLAY_COMPLETED = 4099`  L8
- `int EVENT_VIDEO_PLAY_PTS = 4104`  L9
- `int EVENT_VIDEO_TIMEOUT = 4103`  L10
- `int MESSAGE_CANCEL_VIDEO_DOWNLOAD = 4101`  L11
- `int MESSAGE_UPDATE_VIDEOPB_BAR = 4100`  L12
- `int STREAM_MESSAGE = 4096`  L13
### `com.tinyai.libmediacomponent.engine.streaming.type.StreamType`
L4 · [class] public StreamType · `com/tinyai/libmediacomponent/engine/streaming/type/StreamType.java`

字段/常量（2）：
- `int PREVIEW_STREAM = 0`  L5
- `int VIDEO_STREAM = 1`  L6
### `com.tinyai.libmediacomponent.engine.streaming.type.SurfaceType`
L4 · [class] public SurfaceType · `com/tinyai/libmediacomponent/engine/streaming/type/SurfaceType.java`

字段/常量（2）：
- `int SURFACE_TYPE_SURFACE_VIEW = 1`  L5
- `int SURFACE_TYPE_TEXTURE_VIEW = 2`  L6
### `com.tinyai.libmediacomponent.engine.streaming.type.VideoQuality`
L4 · [enum] public VideoQuality · `com/tinyai/libmediacomponent/engine/streaming/type/VideoQuality.java`

字段/常量（1）：
- `int value`  L9

枚举常量（4）：
- `VIDEO_QUALITY_SMOOTH(0)`  L5
- `VIDEO_QUALITY_HD(1)`  L6
- `VIDEO_QUALITY_FHD(2)`  L7
- `VideoQuality(int i)`  L11

方法（1）：
- `int value()`  L15
### `com.tinyai.libmediacomponent.engine.streaming.type.VideoStreamParam`
L4 · [class] public VideoStreamParam · `com/tinyai/libmediacomponent/engine/streaming/type/VideoStreamParam.java`

字段/常量（2）：
- `DeviceFile deviceFile`  L5
- `boolean remote`  L6

方法（3）：
- `public VideoStreamParam(DeviceFile deviceFile, boolean z)`  L8
- `DeviceFile getDeviceFile()`  L13
- `boolean isRemote()`  L17