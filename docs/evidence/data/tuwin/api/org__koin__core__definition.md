# TUWIN — 类与成员明细：org.koin.core.definition

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 6 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.core.definition.BeanDefinition`
L24 · [class] public final BeanDefinition · `org/koin/core/definition/BeanDefinition.java`
注解：@KoinDslMarker

字段/常量（9）：
- `boolean _createdAtStart`  L25
- `Callbacks<T> callbacks`  L26
- `Function2<Scope, ParametersHolder, T> definition`  L27
- `Kind kind`  L28
- `KClass<?> primaryType`  L29
- `Qualifier qualifier`  L30
- `Qualifier scopeQualifier`  L31
- `List<? extends KClass<?>> secondaryTypes`  L32
- `Qualifier qualifier = this.qualifier`  L158

方法（22）：
- `void get_createdAtStart$annotations()`  L34
- `public BeanDefinition(Qualifier scopeQualifier, KClass<?> primaryType, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, Kind kind, List<? extends KClass<?>> secondaryTypes)`  L38
    - 体内字面量："scopeQualifier" · "primaryType" · "definition" · "kind" · "secondaryTypes"
- `Qualifier getScopeQualifier()`  L53
- `KClass<?> getPrimaryType()`  L57
- `Qualifier getQualifier()`  L61
- `void setQualifier(Qualifier qualifier)`  L65
- `Function2<Scope, ParametersHolder, T> getDefinition()`  L69
- `Kind getKind()`  L73
- ` BeanDefinition(Qualifier qualifier, KClass kClass, Qualifier qualifier2, Function2 function2, Kind kind, List list, int i, DefaultConstructorMarker defaultConstructorMarker)`  L77
- `List<KClass<?>> getSecondaryTypes()`  L81
- `void setSecondaryTypes(List<? extends KClass<?>> list)`  L85
    - 体内字面量："<set-?>"
- `Callbacks<T> getCallbacks()`  L90
- `void setCallbacks(Callbacks<T> callbacks)`  L94
    - 体内字面量："<set-?>"
- `boolean get_createdAtStart()`  L99
- `void set_createdAtStart(boolean z)`  L103
- `String toString()`  L107
    - 体内字面量："[" · ": '" · "\\'" · ",qualifier:" · ",scope:" · ",binds:" · ", " · "," · "..."
- `Object invoke(Object obj)`  L126 @Override
    - 体内字面量："]" · "toString(...)"
- `CharSequence toString$lambda$1$lambda$0(KClass it)`  L138
    - 体内字面量："it"
- `boolean equals(Object other)`  L143
    - 体内字面量："null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>"
- `boolean hasType(KClass<?> clazz)`  L152
    - 体内字面量："clazz"
- `int hashCode()`  L157
- `boolean m2493is(KClass<?> clazz, Qualifier qualifier, Qualifier scopeDefinition)`  L163
    - 体内字面量："clazz" · "scopeDefinition"
### `org.koin.core.definition.BeanDefinitionKt`
L20 · [class] public final BeanDefinitionKt · `org/koin/core/definition/BeanDefinitionKt.java`
注解：

字段/常量（7）：
- `String value`  L22
- `Kind kind2 = kind`  L43
- `Qualifier qualifier2 = qualifier`  L47
- `List secondaryTypes = list`  L51
- `Kind kind2 = kind`  L73
- `Qualifier qualifier2 = qualifier`  L77
- `List secondaryTypes = list`  L81

方法（5）：
- `String indexKey(KClass<?> clazz, Qualifier qualifier, Qualifier scopeQualifier)`  L21
- `BeanDefinition _createDefinition$default(Kind kind, Qualifier qualifier, Function2 definition, List list, Qualifier scopeQualifier, int i, Object obj)`  L39
- `BeanDefinition<T> _createDefinition(Kind kind, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition, List<? extends KClass<?>> secondaryTypes, Qualifier scopeQualifier)`  L60
    - 体内字面量："kind" · "definition" · "secondaryTypes" · "scopeQualifier"
- `BeanDefinition _createDeclaredDefinition$default(Kind kind, Qualifier qualifier, List list, Qualifier scopeQualifier, int i, Object obj)`  L69
- `BeanDefinition<T> _createDeclaredDefinition(Kind kind, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, Qualifier scopeQualifier)`  L91
    - 体内字面量："kind" · "secondaryTypes" · "scopeQualifier"
### `org.koin.core.definition.BeanDefinitionKt$C38631`
L105 · [class] public static final C38631 · implements `Function2<Scope, ParametersHolder, T>` · `org/koin/core/definition/BeanDefinitionKt.java`
注解：

字段/常量（1）：
- `C38631 INSTANCE`  L106

方法（1）：
- `T invoke(Scope BeanDefinition, ParametersHolder it)`  L114 @Override
    - 体内字面量："$this$BeanDefinition" · "it" · "declared instance error "
### `org.koin.core.definition.Callbacks`
L14 · [class] public final Callbacks · `org/koin/core/definition/Callbacks.java`
注解：

字段/常量（2）：
- `Function1<T, Unit> onClose`  L15
- `Function1<T, Unit> function1 = this.onClose`  L46

方法（10）：
- `public Callbacks()`  L18
- `Callbacks copy$default(Callbacks callbacks, Function1 function1, int i, Object obj)`  L23
- `Function1<T, Unit> component1()`  L30
- `Callbacks<T> copy(Function1<? super T, Unit> onClose)`  L34
- `boolean equals(Object other)`  L38
- `int hashCode()`  L45
- `String toString()`  L53
    - 体内字面量："Callbacks(onClose=" · ")"
- `public Callbacks(Function1<? super T, Unit> function1)`  L58
- ` Callbacks(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker)`  L62
- `Function1<T, Unit> getOnClose()`  L66
### `org.koin.core.definition.CallbacksKt`
L10 · [class] public final CallbacksKt · `org/koin/core/definition/CallbacksKt.java`
注解：
### `org.koin.core.definition.Kind`
L11 · [enum] public Kind · `org/koin/core/definition/Kind.java`
注解：

枚举常量（3）：
- `Singleton()`  L12
- `Factory()`  L13
- `Scoped()`  L14

方法（1）：
- `EnumEntries<Kind> getEntries()`  L18
### `org.koin.core.definition.KoinDefinition`
L15 · [class] public final KoinDefinition · `org/koin/core/definition/KoinDefinition.java`
注解：@KoinDslMarker

字段/常量（2）：
- `InstanceFactory<R> factory`  L16
- `Module module`  L17

方法（10）：
- `KoinDefinition copy$default(KoinDefinition koinDefinition, Module module, InstanceFactory instanceFactory, int i, Object obj)`  L20
- `Module getModule()`  L31
- `InstanceFactory<R> component2()`  L35
- `KoinDefinition<R> copy(Module module, InstanceFactory<R> factory)`  L39
    - 体内字面量："module" · "factory"
- `boolean equals(Object other)`  L45
- `int hashCode()`  L56
- `String toString()`  L60
    - 体内字面量："KoinDefinition(module=" · ", factory=" · ")"
- `public KoinDefinition(Module module, InstanceFactory<R> factory)`  L64
    - 体内字面量："module" · "factory"
- `InstanceFactory<R> getFactory()`  L71
- `Module getModule()`  L75