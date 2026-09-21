# XTU GO — 类与成员明细：m.mifan.acase.log

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `m.mifan.acase.log.LogEx`
L17 · [class] public final LogEx · `m/mifan/acase/log/LogEx.java`
注解：

字段/常量（4）：
- `String log_tag = BuildConfig.FLAVOR`  L19
- `boolean logSaveLocal = true`  L21
- `boolean printLog = true`  L22
- `String str`  L42

方法（7）：
- `private LogEx()`  L24
- `void initLog(String logTag, boolean isSaveLogLocal, boolean isPrintLog)`  L27
    - 体内字面量："logTag"
- `File getLogFile$default(LogEx logEx, String str, int i, Object obj)`  L34
- `File getLogFile(String saveTag)`  L41
- `void logD$default(LogEx logEx, String str, boolean z, int i, Object obj)`  L55
- `void logD(String message, boolean isSave)`  L62
    - 体内字面量："message" · "->"
- `void logD(Exception exception)`  L69
    - 体内字面量："exception" · "toString(...)" · "->"