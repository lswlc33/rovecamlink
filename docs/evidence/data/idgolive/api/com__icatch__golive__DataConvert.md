# idGoLive — 类与成员明细：com.icatch.golive.DataConvert

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 3 个文件 / 3 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.DataConvert.BurstConvert`
L6 · [class] public BurstConvert · `com/icatch/golive/DataConvert/BurstConvert.java`

字段/常量（1）：
- `BurstConvert burstConvert`  L7

方法（4）：
- `public BurstConvert()`  L10
- `BurstConvert getInstance()`  L14
- `void initBurstMap()`  L21
- `int getBurstConverFromFw(int i)`  L32
### `com.icatch.golive.DataConvert.CameraNetworkMode`
L6 · [class] public final CameraNetworkMode · `com/icatch/golive/DataConvert/CameraNetworkMode.java`

字段/常量（3）：
- `int AP = 1`  L7
- `int ETHERNET = 2`  L8
- `int STATION = 0`  L9

方法（2）：
- `String getModeConvert(int i)`  L12
- `void initNetworkModeMap()`  L19
    - 体内字面量："Station" · "AP" · "Ethernet"
### `com.icatch.golive.DataConvert.StreamInfoConvert`
L7 · [class] public StreamInfoConvert · `com/icatch/golive/DataConvert/StreamInfoConvert.java`

方法（1）：
- `StreamInfo convertToStreamInfoBean(String str)`  L8
    - 体内字面量："FPS" · "\\?|&" · "W=" · "H=" · "BR=" · "FPS=" · "\\?|&" · "W=" · "H=" · "BR=" · "1111" · "streamInfo.width =" · "1111" · "streamInfo.heigh =" · "1111" · "streamInfo.mediaCodecType =" · "1111" · "streamInfo.bitrate =" · "1111" · "streamInfo.fps ="