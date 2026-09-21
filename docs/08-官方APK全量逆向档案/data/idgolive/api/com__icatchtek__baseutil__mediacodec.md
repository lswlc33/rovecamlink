# idGoLive — 类与成员明细：com.icatchtek.baseutil.mediacodec

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 5 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.mediacodec.PhoenixAudioFormat`
L4 · [class] public PhoenixAudioFormat · `com/icatchtek/baseutil/mediacodec/PhoenixAudioFormat.java`

字段/常量（4）：
- `int channels`  L5
- `int codec`  L6
- `int frequency`  L7
- `int samplebits`  L8

方法（6）：
- `public PhoenixAudioFormat(int i, int i2, int i3, int i4)`  L10
- `int getChannels()`  L17
- `int getCodec()`  L21
- `int getFrequency()`  L25
- `int getSamplebits()`  L29
- `String toString()`  L33
    - 体内字面量："PhoenixAudioFormat{codec=" · ", frequency=" · ", channels=" · ", samplebits=" · "}"
### `com.icatchtek.baseutil.mediacodec.PhoenixAVDemuxer`
L9 · [class] public PhoenixAVDemuxer · `com/icatchtek/baseutil/mediacodec/PhoenixAVDemuxer.java`

字段/常量（6）：
- `String TAG = "PhoenixAVDemuxer"`  L10
- `long pAVDemuxer`  L11
- `PhoenixFrameBuffer nextFrame`  L27
- `byte[] bArr = new byte[IoUtils.DEFAULT_IMAGE_TOTAL_SIZE]`  L60
- `byte[] bArr = new byte[24]`  L71
- `byte[] bArr2 = new byte[24]`  L72

方法（14）：
- `public PhoenixAVDemuxer()`  L18
- `public PhoenixAVDemuxer(boolean z)`  L22
- `int execute(String[] strArr)`  L26
- `void nativeDeleteAVDemuxer(long j)`  L38
- `String nativeGetNextFrame(long j, byte[] bArr)`  L40
- `String nativeGetStreamInfo(long j, byte[] bArr, byte[] bArr2)`  L42
- `int nativeInit(long j, String str)`  L44
- `long nativeNewAVDemuxer(boolean z)`  L46
- `void nativeUnInit(long j)`  L48
- `void finalize()`  L50
- `PhoenixFrameBuffer getNextFrame()`  L59
- `PhoenixStreamInfo getStreamInfo()`  L70
- `int init(String str)`  L83
- `void uninit()`  L87
### `com.icatchtek.baseutil.mediacodec.PhoenixFrameBuffer`
L6 · [class] public PhoenixFrameBuffer · `com/icatchtek/baseutil/mediacodec/PhoenixFrameBuffer.java`

字段/常量（7）：
- `byte[] buffer`  L7
- `int flags`  L8
- `int frame_size`  L9
- `int index`  L10
- `int isAudio`  L11
- `int pts`  L12
- `int slice`  L13

方法（19）：
- `public PhoenixFrameBuffer()`  L15
- `public PhoenixFrameBuffer(int i)`  L18
- `public PhoenixFrameBuffer(int i, int i2, int i3, int i4, int i5, int i6)`  L22
- `public PhoenixFrameBuffer(byte[] bArr)`  L31
- `byte[] getBuffer()`  L35
- `int getFlags()`  L39
- `int getFrame_size()`  L43
- `int getIndex()`  L47
- `int getIsAudio()`  L51
- `int getPts()`  L55
- `int getSlice()`  L59
- `void setBuffer(byte[] bArr)`  L63
- `void setFlags(int i)`  L67
- `void setFrame_size(int i)`  L71
- `void setIndex(int i)`  L75
- `void setIsAudio(int i)`  L79
- `void setPts(int i)`  L83
- `void setSlice(int i)`  L87
- `String toString()`  L91
    - 体内字面量："PhoenixFrameBuffer{pts=" · ", index=" · ", slice=" · ", flags=" · ", frame_size=" · ", isAudio=" · ", buffer=" · "}"
### `com.icatchtek.baseutil.mediacodec.PhoenixStreamInfo`
L4 · [class] public PhoenixStreamInfo · `com/icatchtek/baseutil/mediacodec/PhoenixStreamInfo.java`

字段/常量（4）：
- `PhoenixAudioFormat audio_format`  L5
- `int error`  L6
- `int length`  L7
- `PhoenixVideoFormat video_format`  L8

方法（6）：
- `public PhoenixStreamInfo(int i, int i2, PhoenixVideoFormat phoenixVideoFormat, PhoenixAudioFormat phoenixAudioFormat)`  L10
- `PhoenixAudioFormat getAudio_format()`  L17
- `int getError()`  L21
- `int getLength()`  L25
- `PhoenixVideoFormat getVideo_format()`  L29
- `String toString()`  L33
    - 体内字面量："PhoenixStreamInfo{error=" · ", length=" · ", video_format=" · ", audio_format=" · "}"
### `com.icatchtek.baseutil.mediacodec.PhoenixVideoFormat`
L7 · [class] public PhoenixVideoFormat · `com/icatchtek/baseutil/mediacodec/PhoenixVideoFormat.java`

字段/常量（9）：
- `int codec`  L8
- `int fps`  L9
- `int gop`  L10
- `int height`  L11
- `byte[] pps`  L12
- `int pps_size`  L13
- `byte[] sps`  L14
- `int sps_size`  L15
- `int width`  L16

方法（13）：
- `public PhoenixVideoFormat(int i, int i2, int i3, int i4, int i5, int i6, int i7)`  L18
- `int getCodec()`  L28
- `int getFps()`  L32
- `int getGop()`  L36
- `int getHeight()`  L40
- `byte[] getPps()`  L44
- `int getPpsSize()`  L48
- `byte[] getSps()`  L52
- `int getSpsSize()`  L56
- `int getWidth()`  L60
- `void setPps(byte[] bArr)`  L64
- `void setSps(byte[] bArr)`  L68
- `String toString()`  L72
    - 体内字面量："PhoenixVideoFormat{codec=" · ", width=" · ", height=" · ", fps=" · ", gop=" · ", sps_size=" · ", pps_size=" · ", sps=" · ", pps=" · "}"