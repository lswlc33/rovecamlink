# XTU GO — 类与成员明细：com.gku.crashhandle

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.crashhandle.CrashMock`
L4 · [class] public CrashMock · `com/gku/crashhandle/CrashMock.java`

方法（2）：
- `void mockJavaCrash()`  L5
- `throw new RuntimeException()`  L6
### `com.gku.crashhandle.CrashReportManager`
L17 · [class] public final CrashReportManager · `com/gku/crashhandle/CrashReportManager.java`
注解：

字段/常量（2）：
- `Boolean isDebuggable = BuildConfig.isDebuggable`  L46
- `String MODEL = Build.MODEL`  L55

方法（4）：
- `private CrashReportManager()`  L20
- `void initCrashReport(Context context)`  L24 
    - 体内字面量："context" · "android_id" · "unknown" · "getApplicationInfo(...)" · "UMENG_CHANNEL"
- `throw new RuntimeException(e)`  L50
- `String getSystemModel()`  L54