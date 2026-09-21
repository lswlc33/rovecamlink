# XTU GO — 类与成员明细：com.hisi.hisiFW

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 5 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.hisi.hisiFW.BuildConfig`
L4 · [class] public final BuildConfig · `com/hisi/hisiFW/BuildConfig.java`

字段/常量（3）：
- `String BUILD_TYPE = "release"`  L5
- `boolean DEBUG = false`  L6
- `String LIBRARY_PACKAGE_NAME = "com.hisi.hisiFW"`  L7
### `com.hisi.hisiFW.FwInfo`
L13 · [class] public FwInfo · `com/hisi/hisiFW/FwInfo.java`

字段/常量（5）：
- `String md5`  L14
- `String name`  L15
- `int size`  L16
- `byte[] bArr = new byte[1024]`  L44
- `int i = 0`  L49

方法（6）：
- `public FwInfo(Context context, String str)`  L18
- `byte[] getInfo()`  L24
- `int getSize()`  L28
- `String getName()`  L32
- `String getMd5()`  L36
- `void getMd5(InputStream inputStream)`  L40
### `com.hisi.hisiFW.FwUpload`
L15 · [class] public FwUpload · implements `Runnable` · `com/hisi/hisiFW/FwUpload.java`

字段/常量（15）：
- `String HOST = "192.168.0.1"`  L16
- `int PORT = 8080`  L17
- `int TIME_OUT = 5000`  L18
- `String assetsFile`  L19
- `Context context`  L20
- `Event event`  L21
- `ProgressBack progressBack`  L22
- `FileInputStream fileInputStream`  L44
- `Socket socket`  L45
- `byte[] bArr = new byte[256]`  L59
- `byte[] bArr2 = new byte[5120]`  L104
- `int i2 = 0`  L105
- `ProgressBack progressBack = this.progressBack`  L114
- `ProgressBack progressBack2 = this.progressBack`  L135
- `Event event = this.event`  L202

方法（7）：
- `void setProgressBack(ProgressBack progressBack)`  L34
- `void log(String str)`  L38
    - 体内字面量："yunqi_debug" · "log: "
- `void run()`  L43 @Override
- `void finishCall(Exception exc)`  L201
- `void closeStream(Closeable closeable)`  L208
- `public FwUpload(Context context, String str, Event event)`  L219
- `void upload()`  L225
### `com.hisi.hisiFW.FwUpload$Event`
L24 · [interface] public Event · `com/hisi/hisiFW/FwUpload.java`

方法（1）：
- `void onFwUploadFinish(Exception exc)`  L25
### `com.hisi.hisiFW.FwUpload$ProgressBack`
L28 · [interface] public ProgressBack · `com/hisi/hisiFW/FwUpload.java`

方法（2）：
- `void finish()`  L29
- `void progress(float f)`  L31
### `com.hisi.hisiFW.R`
L4 · [class] public final R · `com/hisi/hisiFW/R.java`

方法（1）：
- `private R()`  L5
### `com.hisi.hisiFW.RegisterDeviceToServer`
L6 · [class] public RegisterDeviceToServer · implements `Serializable` · `com/hisi/hisiFW/RegisterDeviceToServer.java`

字段/常量（4）：
- `byte[] buf`  L7
- `int cmd_type`  L8
- `String data`  L9
- `int length`  L10

方法（6）：
- `public RegisterDeviceToServer(int i, int i2, String str)`  L12
- `public RegisterDeviceToServer(int i, int i2, String str, String str2)`  L25
- `byte[] toLH(short s)`  L40
- `byte[] toLH(int i)`  L44
- `byte[] StringtoLH(String str)`  L48
- `byte[] getBuf()`  L52