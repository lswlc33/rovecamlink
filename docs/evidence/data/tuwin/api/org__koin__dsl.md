# TUWIN — 类与成员明细：org.koin.dsl

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 6 个文件 / 6 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.dsl.DefinitionBindingKt`
L23 · [class] public final DefinitionBindingKt · `org/koin/dsl/DefinitionBindingKt.java`
注解：

字段/常量（2）：
- `String value`  L26
- `String value`  L57

方法（4）：
- `KoinDefinition<? extends S> bind(KoinDefinition<? extends S> koinDefinition, KClass<S> clazz)`  L25 @OptionDslMarker
- `KoinDefinition<? extends S> bind(KoinDefinition<? extends S> koinDefinition)`  L48 @OptionDslMarker
    - 体内字面量："<this>"
- `KoinDefinition<?> binds(KoinDefinition<?> koinDefinition, KClass<?>[] classes)`  L56 @OptionDslMarker
- `KoinDefinition<T> onClose(KoinDefinition<T> koinDefinition, Function1<? super T, Unit> onClose)`  L82 @OptionDslMarker
    - 体内字面量："<this>" · "onClose"
### `org.koin.dsl.KoinApplicationKt`
L13 · [class] public final KoinApplicationKt · `org/koin/dsl/KoinApplicationKt.java`
注解：

方法（5）：
- `KoinApplication koinApplication$default(boolean z, Function1 function1, int i, Object obj)`  L14
- `KoinApplication koinApplication(boolean z, Function1<? super KoinApplication, Unit> function1)`  L25 @KoinApplicationDslMarker
- `KoinApplication koinApplication(Function1<? super KoinApplication, Unit> function1)`  L37 @KoinApplicationDslMarker
- `KoinApplication koinApplication(KoinConfiguration koinConfiguration)`  L42 @KoinApplicationDslMarker
- `KoinApplication koinApplication(boolean z)`  L47 @KoinApplicationDslMarker
### `org.koin.dsl.KoinConfiguration`
L13 · [class] public final KoinConfiguration · `org/koin/dsl/KoinConfiguration.java`
注解：

字段/常量（1）：
- `Function1<KoinApplication, Unit> config`  L14

方法（3）：
- `public KoinConfiguration(Function1<? super KoinApplication, Unit> config)`  L17
    - 体内字面量："config"
- `Function1<KoinApplication, Unit> getConfig()`  L22
- `Function1<KoinApplication, Unit> invoke()`  L26
### `org.koin.dsl.KoinConfigurationKt`
L14 · [class] public final KoinConfigurationKt · `org/koin/dsl/KoinConfigurationKt.java`
注解：

字段/常量（1）：
- `Function1<KoinApplication, Unit> config`  L33

方法（3）：
- `KoinConfiguration koinConfiguration(Function1<? super KoinApplication, Unit> declaration)`  L16 @KoinApplicationDslMarker
    - 体内字面量："declaration"
- `KoinApplication includes(KoinApplication koinApplication, Function1<? super KoinApplication, Unit>... configurations)`  L21
    - 体内字面量："<this>" · "configurations"
- `KoinApplication includes(KoinApplication koinApplication, KoinConfiguration... configurations)`  L32
### `org.koin.dsl.ModuleDSLKt`
L15 · [class] public final ModuleDSLKt · `org/koin/dsl/ModuleDSLKt.java`
注解：

方法（2）：
- `Module module$default(boolean z, Function1 function1, int i, Object obj)`  L16
- `Module module(boolean z, Function1<? super Module, Unit> moduleDeclaration)`  L24 @KoinDslMarker
    - 体内字面量："moduleDeclaration"
### `org.koin.dsl.ScopeDSL`
L27 · [class] public final ScopeDSL · `org/koin/dsl/ScopeDSL.java`
注解：@KoinDslMarker

字段/常量（7）：
- `Module module`  L28
- `Qualifier scopeQualifier`  L29
- `Kind kind = Kind.Scoped`  L52
- `Kind kind = Kind.Scoped`  L63
- `Qualifier qualifier2 = qualifier`  L75
- `Kind kind = Kind.Factory`  L79
- `Kind kind = Kind.Factory`  L91

方法（7）：
- `public ScopeDSL(Qualifier scopeQualifier, Module module)`  L31
    - 体内字面量："scopeQualifier" · "module"
- `Module getModule()`  L38
- `Qualifier getScopeQualifier()`  L42
- `KoinDefinition scoped$default(ScopeDSL scopeDSL, Qualifier qualifier, Function2 definition, int i, Object obj)`  L46
    - 体内字面量："definition"
- `KoinDefinition<T> scoped(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition)`  L60
    - 体内字面量："definition"
- `KoinDefinition factory$default(ScopeDSL scopeDSL, Qualifier qualifier, Function2 definition, int i, Object obj)`  L71
- `KoinDefinition<T> factory(Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition)`  L87
    - 体内字面量："definition"