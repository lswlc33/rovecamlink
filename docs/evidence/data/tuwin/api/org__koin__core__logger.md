# TUWIN — 类与成员明细：org.koin.core.logger

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 5 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.core.logger.EmptyLogger`
L10 · [class] public final EmptyLogger · extends `Logger` · `org/koin/core/logger/EmptyLogger.java`
注解：

方法（2）：
- `void display(Level level, String msg)`  L12 @Override
    - 体内字面量："level" · "msg"
- `public EmptyLogger()`  L17
### `org.koin.core.logger.Level`
L11 · [enum] public Level · `org/koin/core/logger/Level.java`
注解：

枚举常量（5）：
- `DEBUG()`  L12
- `INFO()`  L13
- `WARNING()`  L14
- `ERROR()`  L15
- `NONE()`  L16

方法（1）：
- `EnumEntries<Level> getEntries()`  L20
### `org.koin.core.logger.Logger`
L13 · [class] public abstract Logger · `org/koin/core/logger/Logger.java`
注解：

字段/常量（1）：
- `Level level`  L14

方法（13）：
- `public Logger()`  L17
- `void display(Level level, String msg)`  L21
- `public Logger(Level level)`  L23
    - 体内字面量："level"
- ` Logger(Level level, int i, DefaultConstructorMarker defaultConstructorMarker)`  L28
- `Level getLevel()`  L32
- `void setLevel(Level level)`  L36
    - 体内字面量："<set-?>"
- `void debug(String msg)`  L41
    - 体内字面量："msg"
- `void info(String msg)`  L46
    - 体内字面量："msg"
- `void warn(String msg)`  L51
    - 体内字面量："msg"
- `void error(String msg)`  L56
    - 体内字面量："msg"
- `boolean isAt(Level lvl)`  L61
    - 体内字面量："lvl"
- `void log(Level lvl, String msg)`  L66
    - 体内字面量："lvl" · "msg"
- `void log(Level lvl, Function0<String> msg)`  L74
    - 体内字面量："lvl" · "msg"
### `org.koin.core.logger.LoggerKt`
L9 · [class] public final LoggerKt · `org/koin/core/logger/LoggerKt.java`
注解：

字段/常量（1）：
- `String KOIN_TAG = "[Koin]"`  L10
### `org.koin.core.logger.PrintLogger`
L12 · [class] public final PrintLogger · extends `Logger` · `org/koin/core/logger/PrintLogger.java`
注解：

字段/常量（1）：
- `PrintStream printer`  L13

方法（4）：
- `public PrintLogger()`  L16
- `public PrintLogger(Level level)`  L21
    - 体内字面量："level"
- ` PrintLogger(Level level, int i, DefaultConstructorMarker defaultConstructorMarker)`  L27
- `void display(Level level, String msg)`  L32 @Override
    - 体内字面量："level" · "msg" · "[" · "] [Koin] "