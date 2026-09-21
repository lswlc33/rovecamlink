# TUWIN — 类与成员明细：org.koin.p017mp

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 5 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.p017mp.KoinPlatform`
L18 · [class] public final KoinPlatform · `org/koin/p017mp/KoinPlatform.java`
注解：

方法（7）：
- `private KoinPlatform()`  L21
- `void startKoin(final List<Module> modules, final Level level)`  L24
    - 体内字面量："modules" · "level"
- `Object invoke(Object obj)`  L29 @Override
- `Unit startKoin$lambda$0(Level level, List list, KoinApplication startKoin)`  L36
    - 体内字面量："$this$startKoin"
- `void stopKoin()`  L43
- `Koin getKoin()`  L47
- `Koin getKoinOrNull()`  L51
### `org.koin.p017mp.KoinPlatformTools`
L28 · [class] public final KoinPlatformTools · `org/koin/p017mp/KoinPlatformTools.java`
注解：

字段/常量（1）：
- `R rInvoke`  L85

方法（11）：
- `private KoinPlatformTools()`  L31
- `Logger defaultLogger$default(KoinPlatformTools koinPlatformTools, Level level, int i, Object obj)`  L34
- `String getStackTrace(Exception e)`  L41
    - 体内字面量："e" · "getStackTrace(...)" · "getClassName(...)" · "sun.reflect"
- `String getClassName(KClass<?> kClass)`  L58
    - 体内字面量："kClass" · "getName(...)"
- `String getClassFullNameOrNull(KClass<?> kClass)`  L65
    - 体内字面量："kClass"
- `LazyThreadSafetyMode defaultLazyMode()`  L70
- `Logger defaultLogger(Level level)`  L74
    - 体内字面量："level"
- `KoinContext defaultContext()`  L79
- `R m4840synchronized(Object lock, Function0<? extends R> block)`  L84
- `Map<K, V> safeHashMap()`  L94
- `Set<K> safeSet()`  L98
    - 体内字面量："newSetFromMap(...)"
### `org.koin.p017mp.KoinPlatformTools_jvmKt`
L11 · [class] public final KoinPlatformTools_jvmKt · `org/koin/p017mp/KoinPlatformTools_jvmKt.java`
注解：

方法（1）：
- `String generateId(KoinPlatformTools koinPlatformTools)`  L12
    - 体内字面量："<this>"
### `org.koin.p017mp.KoinPlatformToolsKt`
L11 · [class] public final KoinPlatformToolsKt · `org/koin/p017mp/KoinPlatformToolsKt.java`
注解：

方法（1）：
- `String getKClassDefaultName(KoinPlatformTools koinPlatformTools, KClass<?> kClass)`  L12
    - 体内字面量："<this>" · "kClass" · "KClass@"
### `org.koin.p017mp.ThreadLocalKt`
L10 · [class] public final ThreadLocalKt · `org/koin/p017mp/ThreadLocalKt.java`
注解：