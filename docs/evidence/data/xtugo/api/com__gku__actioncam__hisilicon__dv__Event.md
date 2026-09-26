# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.Event

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.Event.CrashException`
L22 · [class] public CrashException · implements `Thread.UncaughtExceptionHandler` · `com/gku/actioncam/hisilicon/dv/Event/CrashException.java`

字段/常量（6）：
- `Context context`  L23
- `Thread.UncaughtExceptionHandler exceptionHandler`  L24
- `Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.exceptionHandler`  L51
- `String str = packageInfo.versionName == null ? "null" : packageInfo.versionName`  L63
- `String str2 = packageInfo.versionCode + "<binary/metadata>"`  L64
- `FileOutputStream fileOutputStream = null`  L82

方法（4）：
- `void attach(Application application)`  L26
- `void uncaughtException(Thread t, Throwable e)`  L33 @Override
    - 体内字面量："/CrashLog/" · "yyyy-MM-dd-HH:mm:ss" · "crash-" · "-" · ".log" · "\n" · "\n" · "\n"
- `HashMap<String, String> collectDeviceInfo(Context context)`  L58
- `void writeToFile(File file, String text)`  L81
### `com.gku.actioncam.hisilicon.dv.Event.DvDisconnectionEvent`
L4 · [class] public DvDisconnectionEvent · `com/gku/actioncam/hisilicon/dv/Event/DvDisconnectionEvent.java`