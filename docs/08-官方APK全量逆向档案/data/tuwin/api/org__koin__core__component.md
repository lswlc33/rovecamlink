# TUWIN — 类与成员明细：org.koin.core.component

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.core.component.KoinComponent`
L11 · [interface] public KoinComponent · `org/koin/core/component/KoinComponent.java`
注解：

方法（1）：
- `Koin getKoin()`  L12
### `org.koin.core.component.KoinComponent$DefaultImpls`
L16 · [class] public static final DefaultImpls · `org/koin/core/component/KoinComponent.java`
注解：

方法（1）：
- `Koin getKoin(KoinComponent koinComponent)`  L17
### `org.koin.core.component.KoinComponentKt`
L20 · [class] public final KoinComponentKt · `org/koin/core/component/KoinComponentKt.java`
注解：

方法（4）：
- `Object get$default(KoinComponent koinComponent, Qualifier qualifier, Function0 function0, int i, Object obj)`  L22
    - 体内字面量："<this>"
- `T get(KoinComponent koinComponent, Qualifier qualifier, Function0<? extends ParametersHolder> function0)`  L40
    - 体内字面量："<this>"
- `Lazy inject$default(KoinComponent koinComponent, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj)`  L52
    - 体内字面量："<this>" · "mode"
- `Lazy<T> inject(KoinComponent koinComponent, Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> function0)`  L100
    - 体内字面量："<this>" · "mode"
### `org.koin.core.component.KoinComponentKt$C38621`
L72 · [class] public static final C38621 · implements `Function0<T>` · `org/koin/core/component/KoinComponentKt.java`
注解：

字段/常量（7）：
- `Function0<ParametersHolder> $parameters`  L73
- `Qualifier $qualifier`  L74
- `KoinComponent $this_inject`  L75
- `Scope rootScope`  L86
- `KoinComponent koinComponent = this.$this_inject`  L87
- `Qualifier qualifier = this.$qualifier`  L88
- `Function0<ParametersHolder> function0 = this.$parameters`  L89

方法（2）：
- `public C38621(KoinComponent koinComponent, Qualifier qualifier, Function0<? extends ParametersHolder> function0)`  L78
- `T invoke()`  L85 @Override
### `org.koin.core.component.KoinScopeComponent`
L11 · [interface] public KoinScopeComponent · extends `KoinComponent` · `org/koin/core/component/KoinScopeComponent.java`
注解：

方法（1）：
- `Scope getScope()`  L12
### `org.koin.core.component.KoinScopeComponent$DefaultImpls`
L16 · [class] public static final DefaultImpls · `org/koin/core/component/KoinScopeComponent.java`
注解：

方法（1）：
- `Koin getKoin(KoinScopeComponent koinScopeComponent)`  L17
### `org.koin.core.component.KoinScopeComponentKt`
L18 · [class] public final KoinScopeComponentKt · `org/koin/core/component/KoinScopeComponentKt.java`
注解：

方法（13）：
- `String getScopeId(T t)`  L19
    - 体内字面量："<this>" · "@"
- `TypeQualifier getScopeName(T t)`  L24
    - 体内字面量："<this>"
- `Scope createScope$default(KoinScopeComponent koinScopeComponent, String str, Object obj, int i, Object obj2)`  L29
- `Scope createScope(T t, String scopeId, Object obj)`  L36
    - 体内字面量："<this>" · "scopeId"
- `Scope createScope$default(KoinScopeComponent koinScopeComponent, Object obj, int i, Object obj2)`  L42
- `Scope createScope(T t, Object obj)`  L49
    - 体内字面量："<this>"
- `Scope getScopeOrNull(T t)`  L54
    - 体内字面量："<this>"
- `Lazy<Scope> newScope(final T t)`  L59
    - 体内字面量："<this>"
- `Object invoke()`  L63 @Override
- `Scope newScope$lambda$0(KoinScopeComponent koinScopeComponent)`  L70
- `Lazy<Scope> getOrCreateScope(final T t)`  L74
    - 体内字面量："<this>"
- `Object invoke()`  L78 @Override
- `Scope getOrCreateScope$lambda$1(KoinScopeComponent koinScopeComponent)`  L85