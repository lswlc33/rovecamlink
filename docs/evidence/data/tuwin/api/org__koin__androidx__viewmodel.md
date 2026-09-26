# TUWIN — 类与成员明细：org.koin.androidx.viewmodel

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 8 个文件 / 57 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.androidx.viewmodel.dsl.ModuleExtKt`
L27 · [class] public final ModuleExtKt · `org/koin/androidx/viewmodel/dsl/ModuleExtKt.java`
注解：

字段/常量（2）：
- `Kind kind = Kind.Factory`  L35
- `Kind kind = Kind.Factory`  L48

方法（2）：
- `KoinDefinition viewModel$default(Module module, Qualifier qualifier, Function2 definition, int i, Object obj)`  L28
    - 体内字面量："<this>" · "definition"
- `KoinDefinition<T> viewModel(Module module, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition)`  L44 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "definition"
### `org.koin.androidx.viewmodel.dsl.ScopeSetExtKt`
L26 · [class] public final ScopeSetExtKt · `org/koin/androidx/viewmodel/dsl/ScopeSetExtKt.java`
注解：

字段/常量（3）：
- `Qualifier qualifier2 = qualifier`  L31
- `Kind kind = Kind.Factory`  L36
- `Kind kind = Kind.Factory`  L50

方法（2）：
- `KoinDefinition viewModel$default(ScopeDSL scopeDSL, Qualifier qualifier, Function2 definition, int i, Object obj)`  L27
- `KoinDefinition<T> viewModel(ScopeDSL scopeDSL, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition)`  L45 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "definition"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt`
L49 · [class] public final ScopeViewModelOfKt · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（46）：
- `Kind kind = Kind.Factory`  L60
- `Kind kind = Kind.Factory`  L97
- `Kind kind = Kind.Factory`  L115
- `Kind kind = Kind.Factory`  L155
- `Kind kind = Kind.Factory`  L173
- `Kind kind = Kind.Factory`  L215
- `Kind kind = Kind.Factory`  L233
- `Kind kind = Kind.Factory`  L277
- `Kind kind = Kind.Factory`  L295
- `Kind kind = Kind.Factory`  L341
- `Kind kind = Kind.Factory`  L359
- `Kind kind = Kind.Factory`  L407
- `Kind kind = Kind.Factory`  L425
- `Kind kind = Kind.Factory`  L475
- `Kind kind = Kind.Factory`  L493
- `Kind kind = Kind.Factory`  L545
- `Kind kind = Kind.Factory`  L563
- `Kind kind = Kind.Factory`  L617
- `Kind kind = Kind.Factory`  L635
- `Kind kind = Kind.Factory`  L691
- `Kind kind = Kind.Factory`  L709
- `Kind kind = Kind.Factory`  L767
- `Kind kind = Kind.Factory`  L785
- `Kind kind = Kind.Factory`  L845
- `Kind kind = Kind.Factory`  L863
- `Kind kind = Kind.Factory`  L925
- `Kind kind = Kind.Factory`  L943
- `Kind kind = Kind.Factory`  L1007
- `Kind kind = Kind.Factory`  L1025
- `Kind kind = Kind.Factory`  L1091
- `Kind kind = Kind.Factory`  L1109
- `Kind kind = Kind.Factory`  L1177
- `Kind kind = Kind.Factory`  L1195
- `Kind kind = Kind.Factory`  L1265
- `Kind kind = Kind.Factory`  L1283
- `Kind kind = Kind.Factory`  L1355
- `Kind kind = Kind.Factory`  L1373
- `Kind kind = Kind.Factory`  L1447
- `Kind kind = Kind.Factory`  L1465
- `Kind kind = Kind.Factory`  L1541
- `Kind kind = Kind.Factory`  L1559
- `Kind kind = Kind.Factory`  L1637
- `Kind kind = Kind.Factory`  L1655
- `Kind kind = Kind.Factory`  L1735
- `Kind kind = Kind.Factory`  L1753
- `Kind kind = Kind.Factory`  L1835

方法（46）：
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function0 constructor, Function1 function1, int i, Object obj)`  L50
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function0<? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L90 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function1 constructor, Function1 function1, int i, Object obj)`  L105
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function1<? super T1, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L148 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function2 constructor, Function1 function1, int i, Object obj)`  L163
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function2<? super T1, ? super T2, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L208 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function3 constructor, Function1 function1, int i, Object obj)`  L223
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function3<? super T1, ? super T2, ? super T3, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L270 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function4 constructor, Function1 function1, int i, Object obj)`  L285
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L334 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function5 constructor, Function1 function1, int i, Object obj)`  L349
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L400 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function6 constructor, Function1 function1, int i, Object obj)`  L415
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L468 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function7 constructor, Function1 function1, int i, Object obj)`  L483
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L538 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function8 constructor, Function1 function1, int i, Object obj)`  L553
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L610 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function9 constructor, Function1 function1, int i, Object obj)`  L625
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L684 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function10 constructor, Function1 function1, int i, Object obj)`  L699
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L760 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function11 constructor, Function1 function1, int i, Object obj)`  L775
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L838 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function12 constructor, Function1 function1, int i, Object obj)`  L853
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L918 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function13 constructor, Function1 function1, int i, Object obj)`  L933
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1000 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function14 constructor, Function1 function1, int i, Object obj)`  L1015
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1084 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function15 constructor, Function1 function1, int i, Object obj)`  L1099
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1170 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function16 constructor, Function1 function1, int i, Object obj)`  L1185
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1258 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function17 constructor, Function1 function1, int i, Object obj)`  L1273
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1348 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function18 constructor, Function1 function1, int i, Object obj)`  L1363
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1440 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function19 constructor, Function1 function1, int i, Object obj)`  L1455
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1534 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function20 constructor, Function1 function1, int i, Object obj)`  L1549
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1630 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function21 constructor, Function1 function1, int i, Object obj)`  L1645
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1728 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(ScopeDSL scopeDSL, Function22 constructor, Function1 function1, int i, Object obj)`  L1743
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(ScopeDSL scopeDSL, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1828 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C38091`
L72 · [class] public static final C38091 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（1）：
- `Function0<R> $constructor`  L73

方法（2）：
- `public C38091(Function0<? extends R> function0)`  L76
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L82 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381010`
L647 · [class] public static final C381010 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> $constructor`  L648
- `Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9 = this.$constructor`  L661

方法（2）：
- `public C381010(Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9)`  L651
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L658 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381111`
L721 · [class] public static final C381111 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> $constructor`  L722
- `Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> function10 = this.$constructor`  L735

方法（2）：
- `public C381111(Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10)`  L725
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L732 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381212`
L797 · [class] public static final C381212 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> $constructor`  L798
- `Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> function11 = this.$constructor`  L811

方法（2）：
- `public C381212(Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11)`  L801
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L808 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381313`
L875 · [class] public static final C381313 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> $constructor`  L876
- `Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> function12 = this.$constructor`  L889

方法（2）：
- `public C381313(Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12)`  L879
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L886 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381414`
L955 · [class] public static final C381414 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> $constructor`  L956
- `Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> function13 = this.$constructor`  L969

方法（2）：
- `public C381414(Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13)`  L959
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L966 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381515`
L1037 · [class] public static final C381515 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> $constructor`  L1038
- `Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> function14 = this.$constructor`  L1051

方法（2）：
- `public C381515(Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14)`  L1041
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1048 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381616`
L1121 · [class] public static final C381616 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> $constructor`  L1122
- `Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> function15 = this.$constructor`  L1135

方法（2）：
- `public C381616(Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15)`  L1125
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1132 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381717`
L1207 · [class] public static final C381717 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> $constructor`  L1208
- `Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> function16 = this.$constructor`  L1221

方法（2）：
- `public C381717(Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16)`  L1211
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1218 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381818`
L1295 · [class] public static final C381818 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> $constructor`  L1296
- `Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> function17 = this.$constructor`  L1309

方法（2）：
- `public C381818(Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17)`  L1299
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1306 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C381919`
L1385 · [class] public static final C381919 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> $constructor`  L1386
- `Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> function18 = this.$constructor`  L1399

方法（2）：
- `public C381919(Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> function18)`  L1389
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1396 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C38202`
L127 · [class] public static final C38202 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function1<T1, R> $constructor`  L128
- `Function1<T1, R> function1 = this.$constructor`  L141

方法（2）：
- `public C38202(Function1<? super T1, ? extends R> function1)`  L131
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L138 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C382120`
L1477 · [class] public static final C382120 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> $constructor`  L1478
- `Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> function19 = this.$constructor`  L1491

方法（2）：
- `public C382120(Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> function19)`  L1481
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1488 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C382221`
L1571 · [class] public static final C382221 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> $constructor`  L1572
- `Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> function20 = this.$constructor`  L1585

方法（2）：
- `public C382221(Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> function20)`  L1575
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1582 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C382322`
L1667 · [class] public static final C382322 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> $constructor`  L1668
- `Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> function21 = this.$constructor`  L1681

方法（2）：
- `public C382322(Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> function21)`  L1671
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1678 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C382423`
L1765 · [class] public static final C382423 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> $constructor`  L1766
- `Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> function22 = this.$constructor`  L1779

方法（2）：
- `public C382423(Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22)`  L1769
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1776 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C38253`
L185 · [class] public static final C38253 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function2<T1, T2, R> $constructor`  L186
- `Function2<T1, T2, R> function2 = this.$constructor`  L199

方法（2）：
- `public C38253(Function2<? super T1, ? super T2, ? extends R> function2)`  L189
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L196 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C38264`
L245 · [class] public static final C38264 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function3<T1, T2, T3, R> $constructor`  L246
- `Function3<T1, T2, T3, R> function3 = this.$constructor`  L259

方法（2）：
- `public C38264(Function3<? super T1, ? super T2, ? super T3, ? extends R> function3)`  L249
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L256 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C38275`
L307 · [class] public static final C38275 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function4<T1, T2, T3, T4, R> $constructor`  L308
- `Function4<T1, T2, T3, T4, R> function4 = this.$constructor`  L321

方法（2）：
- `public C38275(Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4)`  L311
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L318 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C38286`
L371 · [class] public static final C38286 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function5<T1, T2, T3, T4, T5, R> $constructor`  L372
- `Function5<T1, T2, T3, T4, T5, R> function5 = this.$constructor`  L385

方法（2）：
- `public C38286(Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5)`  L375
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L382 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C38297`
L437 · [class] public static final C38297 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function6<T1, T2, T3, T4, T5, T6, R> $constructor`  L438
- `Function6<T1, T2, T3, T4, T5, T6, R> function6 = this.$constructor`  L451

方法（2）：
- `public C38297(Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6)`  L441
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L448 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C38308`
L505 · [class] public static final C38308 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function7<T1, T2, T3, T4, T5, T6, T7, R> $constructor`  L506
- `Function7<T1, T2, T3, T4, T5, T6, T7, R> function7 = this.$constructor`  L519

方法（2）：
- `public C38308(Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7)`  L509
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L516 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ScopeViewModelOfKt$C38319`
L575 · [class] public static final C38319 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ScopeViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> $constructor`  L576
- `Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8 = this.$constructor`  L589

方法（2）：
- `public C38319(Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8)`  L579
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L586 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt`
L49 · [class] public final ViewModelOfKt · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（46）：
- `Kind kind = Kind.Factory`  L59
- `Kind kind = Kind.Factory`  L95
- `Kind kind = Kind.Factory`  L112
- `Kind kind = Kind.Factory`  L151
- `Kind kind = Kind.Factory`  L168
- `Kind kind = Kind.Factory`  L209
- `Kind kind = Kind.Factory`  L226
- `Kind kind = Kind.Factory`  L269
- `Kind kind = Kind.Factory`  L286
- `Kind kind = Kind.Factory`  L331
- `Kind kind = Kind.Factory`  L348
- `Kind kind = Kind.Factory`  L395
- `Kind kind = Kind.Factory`  L412
- `Kind kind = Kind.Factory`  L461
- `Kind kind = Kind.Factory`  L478
- `Kind kind = Kind.Factory`  L529
- `Kind kind = Kind.Factory`  L546
- `Kind kind = Kind.Factory`  L599
- `Kind kind = Kind.Factory`  L616
- `Kind kind = Kind.Factory`  L671
- `Kind kind = Kind.Factory`  L688
- `Kind kind = Kind.Factory`  L745
- `Kind kind = Kind.Factory`  L762
- `Kind kind = Kind.Factory`  L821
- `Kind kind = Kind.Factory`  L838
- `Kind kind = Kind.Factory`  L899
- `Kind kind = Kind.Factory`  L916
- `Kind kind = Kind.Factory`  L979
- `Kind kind = Kind.Factory`  L996
- `Kind kind = Kind.Factory`  L1061
- `Kind kind = Kind.Factory`  L1078
- `Kind kind = Kind.Factory`  L1145
- `Kind kind = Kind.Factory`  L1162
- `Kind kind = Kind.Factory`  L1231
- `Kind kind = Kind.Factory`  L1248
- `Kind kind = Kind.Factory`  L1319
- `Kind kind = Kind.Factory`  L1336
- `Kind kind = Kind.Factory`  L1409
- `Kind kind = Kind.Factory`  L1426
- `Kind kind = Kind.Factory`  L1501
- `Kind kind = Kind.Factory`  L1518
- `Kind kind = Kind.Factory`  L1595
- `Kind kind = Kind.Factory`  L1612
- `Kind kind = Kind.Factory`  L1691
- `Kind kind = Kind.Factory`  L1708
- `Kind kind = Kind.Factory`  L1789

方法（46）：
- `KoinDefinition viewModelOf$default(Module module, Function0 constructor, Function1 function1, int i, Object obj)`  L50
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function0<? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L89 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function1 constructor, Function1 function1, int i, Object obj)`  L103
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function1<? super T1, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L145 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function2 constructor, Function1 function1, int i, Object obj)`  L159
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function2<? super T1, ? super T2, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L203 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function3 constructor, Function1 function1, int i, Object obj)`  L217
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function3<? super T1, ? super T2, ? super T3, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L263 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function4 constructor, Function1 function1, int i, Object obj)`  L277
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L325 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function5 constructor, Function1 function1, int i, Object obj)`  L339
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L389 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function6 constructor, Function1 function1, int i, Object obj)`  L403
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L455 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function7 constructor, Function1 function1, int i, Object obj)`  L469
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L523 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function8 constructor, Function1 function1, int i, Object obj)`  L537
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L593 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function9 constructor, Function1 function1, int i, Object obj)`  L607
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L665 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function10 constructor, Function1 function1, int i, Object obj)`  L679
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L739 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function11 constructor, Function1 function1, int i, Object obj)`  L753
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L815 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function12 constructor, Function1 function1, int i, Object obj)`  L829
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L893 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function13 constructor, Function1 function1, int i, Object obj)`  L907
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L973 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function14 constructor, Function1 function1, int i, Object obj)`  L987
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1055 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function15 constructor, Function1 function1, int i, Object obj)`  L1069
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1139 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function16 constructor, Function1 function1, int i, Object obj)`  L1153
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1225 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function17 constructor, Function1 function1, int i, Object obj)`  L1239
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1313 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function18 constructor, Function1 function1, int i, Object obj)`  L1327
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1403 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function19 constructor, Function1 function1, int i, Object obj)`  L1417
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1495 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function20 constructor, Function1 function1, int i, Object obj)`  L1509
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1589 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function21 constructor, Function1 function1, int i, Object obj)`  L1603
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1685 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition viewModelOf$default(Module module, Function22 constructor, Function1 function1, int i, Object obj)`  L1699
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> viewModelOf(Module module, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1783 @Deprecated(message = "Moved ViewModel DSL package. Remove old imports and use org.koin.core.module.dsl.*")
    - 体内字面量："<this>" · "constructor"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C38321`
L71 · [class] public static final C38321 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（1）：
- `Function0<R> $constructor`  L72

方法（2）：
- `public C38321(Function0<? extends R> function0)`  L75
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L81 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C383310`
L628 · [class] public static final C383310 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> $constructor`  L629
- `Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9 = this.$constructor`  L642

方法（2）：
- `public C383310(Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9)`  L632
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L639 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C383411`
L700 · [class] public static final C383411 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> $constructor`  L701
- `Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> function10 = this.$constructor`  L714

方法（2）：
- `public C383411(Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10)`  L704
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L711 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C383512`
L774 · [class] public static final C383512 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> $constructor`  L775
- `Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> function11 = this.$constructor`  L788

方法（2）：
- `public C383512(Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11)`  L778
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L785 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C383613`
L850 · [class] public static final C383613 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> $constructor`  L851
- `Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> function12 = this.$constructor`  L864

方法（2）：
- `public C383613(Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12)`  L854
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L861 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C383714`
L928 · [class] public static final C383714 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> $constructor`  L929
- `Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> function13 = this.$constructor`  L942

方法（2）：
- `public C383714(Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13)`  L932
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L939 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C383815`
L1008 · [class] public static final C383815 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> $constructor`  L1009
- `Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> function14 = this.$constructor`  L1022

方法（2）：
- `public C383815(Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14)`  L1012
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1019 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C383916`
L1090 · [class] public static final C383916 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> $constructor`  L1091
- `Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> function15 = this.$constructor`  L1104

方法（2）：
- `public C383916(Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15)`  L1094
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1101 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C384017`
L1174 · [class] public static final C384017 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> $constructor`  L1175
- `Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> function16 = this.$constructor`  L1188

方法（2）：
- `public C384017(Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16)`  L1178
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1185 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C384118`
L1260 · [class] public static final C384118 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> $constructor`  L1261
- `Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> function17 = this.$constructor`  L1274

方法（2）：
- `public C384118(Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17)`  L1264
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1271 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C384219`
L1348 · [class] public static final C384219 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> $constructor`  L1349
- `Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> function18 = this.$constructor`  L1362

方法（2）：
- `public C384219(Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> function18)`  L1352
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1359 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C38432`
L124 · [class] public static final C38432 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function1<T1, R> $constructor`  L125
- `Function1<T1, R> function1 = this.$constructor`  L138

方法（2）：
- `public C38432(Function1<? super T1, ? extends R> function1)`  L128
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L135 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C384420`
L1438 · [class] public static final C384420 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> $constructor`  L1439
- `Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> function19 = this.$constructor`  L1452

方法（2）：
- `public C384420(Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> function19)`  L1442
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1449 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C384521`
L1530 · [class] public static final C384521 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> $constructor`  L1531
- `Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> function20 = this.$constructor`  L1544

方法（2）：
- `public C384521(Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> function20)`  L1534
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1541 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C384622`
L1624 · [class] public static final C384622 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> $constructor`  L1625
- `Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> function21 = this.$constructor`  L1638

方法（2）：
- `public C384622(Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> function21)`  L1628
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1635 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C384723`
L1720 · [class] public static final C384723 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> $constructor`  L1721
- `Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> function22 = this.$constructor`  L1734

方法（2）：
- `public C384723(Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22)`  L1724
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L1731 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C38483`
L180 · [class] public static final C38483 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function2<T1, T2, R> $constructor`  L181
- `Function2<T1, T2, R> function2 = this.$constructor`  L194

方法（2）：
- `public C38483(Function2<? super T1, ? super T2, ? extends R> function2)`  L184
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L191 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C38494`
L238 · [class] public static final C38494 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function3<T1, T2, T3, R> $constructor`  L239
- `Function3<T1, T2, T3, R> function3 = this.$constructor`  L252

方法（2）：
- `public C38494(Function3<? super T1, ? super T2, ? super T3, ? extends R> function3)`  L242
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L249 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C38505`
L298 · [class] public static final C38505 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function4<T1, T2, T3, T4, R> $constructor`  L299
- `Function4<T1, T2, T3, T4, R> function4 = this.$constructor`  L312

方法（2）：
- `public C38505(Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4)`  L302
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L309 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C38516`
L360 · [class] public static final C38516 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function5<T1, T2, T3, T4, T5, R> $constructor`  L361
- `Function5<T1, T2, T3, T4, T5, R> function5 = this.$constructor`  L374

方法（2）：
- `public C38516(Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5)`  L364
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L371 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C38527`
L424 · [class] public static final C38527 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function6<T1, T2, T3, T4, T5, T6, R> $constructor`  L425
- `Function6<T1, T2, T3, T4, T5, T6, R> function6 = this.$constructor`  L438

方法（2）：
- `public C38527(Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6)`  L428
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L435 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C38538`
L490 · [class] public static final C38538 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function7<T1, T2, T3, T4, T5, T6, T7, R> $constructor`  L491
- `Function7<T1, T2, T3, T4, T5, T6, T7, R> function7 = this.$constructor`  L504

方法（2）：
- `public C38538(Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7)`  L494
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L501 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.dsl.ViewModelOfKt$C38549`
L558 · [class] public static final C38549 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/viewmodel/dsl/ViewModelOfKt.java`
注解：

字段/常量（2）：
- `Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> $constructor`  L559
- `Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8 = this.$constructor`  L572

方法（2）：
- `public C38549(Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8)`  L562
- `ViewModel invoke(Scope viewModel, ParametersHolder it)`  L569 @Override
    - 体内字面量："$this$viewModel" · "it"
### `org.koin.androidx.viewmodel.ext.android.ActivityVMKt`
L25 · [class] public final ActivityVMKt · `org/koin/androidx/viewmodel/ext/android/ActivityVMKt.java`
注解：

字段/常量（4）：
- `LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE`  L37
- `LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE`  L81
- `CreationExtras defaultViewModelCreationExtras`  L87
- `CreationExtras defaultViewModelCreationExtras`  L104

方法（4）：
- `Lazy viewModel$default(ComponentActivity componentActivity, Qualifier qualifier, Function0 function0, Function0 function1, int i, Object obj)`  L26
    - 体内字面量："<this>"
- `Lazy<T> viewModel(ComponentActivity componentActivity, Qualifier qualifier, Function0<? extends CreationExtras> function0, Function0<? extends ParametersHolder> function1)`  L79
    - 体内字面量："<this>"
- `ViewModel getViewModel$default(ComponentActivity componentActivity, Qualifier qualifier, Function0 function0, Function0 function1, int i, Object obj)`  L86
- `T getViewModel(ComponentActivity componentActivity, Qualifier qualifier, Function0<? extends CreationExtras> function0, Function0<? extends ParametersHolder> function1)`  L103
### `org.koin.androidx.viewmodel.ext.android.ActivityVMKt$C38551`
L46 · [class] public static final C38551 · implements `Function0<T>` · `org/koin/androidx/viewmodel/ext/android/ActivityVMKt.java`
注解：

字段/常量（10）：
- `Function0<CreationExtras> $extrasProducer`  L47
- `Function0<ParametersHolder> $parameters`  L48
- `Qualifier $qualifier`  L49
- `ComponentActivity $this_viewModel`  L50
- `CreationExtras defaultViewModelCreationExtras`  L63
- `ComponentActivity componentActivity = this.$this_viewModel`  L64
- `Qualifier qualifier = this.$qualifier`  L65
- `Function0<CreationExtras> function0 = this.$extrasProducer`  L66
- `Function0<ParametersHolder> function1 = this.$parameters`  L67
- `CreationExtras creationExtras = defaultViewModelCreationExtras`  L72

方法（2）：
- `public C38551(ComponentActivity componentActivity, Qualifier qualifier, Function0<? extends CreationExtras> function0, Function0<? extends ParametersHolder> function1)`  L53
- `ViewModel invoke()`  L62 @Override
### `org.koin.androidx.viewmodel.ext.android.FragmentActivityVMKt`
L28 · [class] public final FragmentActivityVMKt · `org/koin/androidx/viewmodel/ext/android/FragmentActivityVMKt.java`
注解：

字段/常量（9）：
- `Function0 ownerProducer = function0`  L40
- `LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE`  L45
- `LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE`  L104
- `CreationExtras defaultViewModelCreationExtras`  L110
- `CreationExtras creationExtras`  L111
- `CreationExtras creationExtras2`  L112
- `CreationExtras defaultViewModelCreationExtras`  L145
- `CreationExtras creationExtras`  L146
- `CreationExtras creationExtrasInvoke`  L147

方法（6）：
- `Lazy activityViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function1, Function0 function2, int i, Object obj)`  L29
- `FragmentActivity invoke()`  L35 @Override
- `Lazy<T> activityViewModel(Fragment fragment, Qualifier qualifier, Function0<? extends ViewModelStoreOwner> ownerProducer, Function0<? extends CreationExtras> function0, Function0<? extends ParametersHolder> function1)`  L101
    - 体内字面量："<this>" · "ownerProducer"
- `ViewModel getActivityViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function1, Function0 function2, int i, Object obj)`  L109
- `FragmentActivity invoke()`  L117 @Override
    - 体内字面量："<this>" · "ownerProducer" · "<get-defaultViewModelCreationExtras>(...)"
- `T getActivityViewModel(Fragment fragment, Qualifier qualifier, Function0<? extends ViewModelStoreOwner> ownerProducer, Function0<? extends CreationExtras> function0, Function0<? extends ParametersHolder> function1)`  L144
### `org.koin.androidx.viewmodel.ext.android.FragmentActivityVMKt$C38572`
L54 · [class] public static final C38572 · implements `Function0<T>` · `org/koin/androidx/viewmodel/ext/android/FragmentActivityVMKt.java`
注解：

字段/常量（13）：
- `Function0<CreationExtras> $extrasProducer`  L55
- `Function0<ViewModelStoreOwner> $ownerProducer`  L56
- `Function0<ParametersHolder> $parameters`  L57
- `Qualifier $qualifier`  L58
- `Fragment $this_activityViewModel`  L59
- `CreationExtras defaultViewModelCreationExtras`  L73
- `CreationExtras creationExtras`  L74
- `CreationExtras creationExtrasInvoke`  L75
- `Fragment fragment = this.$this_activityViewModel`  L76
- `Qualifier qualifier = this.$qualifier`  L77
- `Function0<ViewModelStoreOwner> function0 = this.$ownerProducer`  L78
- `Function0<CreationExtras> function1 = this.$extrasProducer`  L79
- `Function0<ParametersHolder> function2 = this.$parameters`  L80

方法（2）：
- `public C38572(Fragment fragment, Qualifier qualifier, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends CreationExtras> function1, Function0<? extends ParametersHolder> function2)`  L62
- `ViewModel invoke()`  L72 @Override
### `org.koin.androidx.viewmodel.ext.android.FragmentVMKt`
L26 · [class] public final FragmentVMKt · `org/koin/androidx/viewmodel/ext/android/FragmentVMKt.java`
注解：

字段/常量（5）：
- `Function0 ownerProducer = function0`  L38
- `LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE`  L43
- `LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE`  L92
- `CreationExtras defaultViewModelCreationExtras`  L98
- `CreationExtras defaultViewModelCreationExtras`  L122

方法（6）：
- `Lazy viewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function1, Function0 function2, int i, Object obj)`  L27
- `Fragment invoke()`  L33 @Override
- `Lazy<T> viewModel(Fragment fragment, Qualifier qualifier, Function0<? extends ViewModelStoreOwner> ownerProducer, Function0<? extends CreationExtras> function0, Function0<? extends ParametersHolder> function1)`  L89
    - 体内字面量："<this>" · "ownerProducer"
- `ViewModel getViewModel$default(final Fragment fragment, Qualifier qualifier, Function0 function0, Function0 function1, Function0 function2, int i, Object obj)`  L97
- `Fragment invoke()`  L103 @Override
    - 体内字面量："<this>" · "ownerProducer" · "<get-defaultViewModelCreationExtras>(...)"
- `T getViewModel(Fragment fragment, Qualifier qualifier, Function0<? extends ViewModelStoreOwner> ownerProducer, Function0<? extends CreationExtras> function0, Function0<? extends ParametersHolder> function1)`  L121
### `org.koin.androidx.viewmodel.ext.android.FragmentVMKt$C38612`
L52 · [class] public static final C38612 · implements `Function0<T>` · `org/koin/androidx/viewmodel/ext/android/FragmentVMKt.java`
注解：

字段/常量（12）：
- `Function0<CreationExtras> $extrasProducer`  L53
- `Function0<ViewModelStoreOwner> $ownerProducer`  L54
- `Function0<ParametersHolder> $parameters`  L55
- `Qualifier $qualifier`  L56
- `Fragment $this_viewModel`  L57
- `CreationExtras defaultViewModelCreationExtras`  L71
- `Fragment fragment = this.$this_viewModel`  L72
- `Qualifier qualifier = this.$qualifier`  L73
- `Function0<ViewModelStoreOwner> function0 = this.$ownerProducer`  L74
- `Function0<CreationExtras> function1 = this.$extrasProducer`  L75
- `Function0<ParametersHolder> function2 = this.$parameters`  L76
- `CreationExtras creationExtras = defaultViewModelCreationExtras`  L82

方法（2）：
- `public C38612(Fragment fragment, Qualifier qualifier, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends CreationExtras> function1, Function0<? extends ParametersHolder> function2)`  L60
- `ViewModel invoke()`  L70 @Override
### `org.koin.androidx.viewmodel.ext.android.ViewModelLazyKt`
L30 · [class] public final ViewModelLazyKt · `org/koin/androidx/viewmodel/ext/android/ViewModelLazyKt.java`
注解：

字段/常量（4）：
- `CreationExtras.Empty extras`  L51
- `Bundle bundle`  L52
- `CreationExtras.Empty extras`  L73
- `Bundle bundle`  L74

方法（7）：
- `Fragment viewModelForClass$lambda$1(Fragment fragment)`  L32
- `Lazy<T> viewModelForClass(final ComponentActivity componentActivity, final KClass<T> clazz, final Qualifier qualifier, final ViewModelStoreOwner owner, final Function0<Bundle> function0, final String str, final Function0<? extends ParametersHolder> function1)`  L36
    - 体内字面量："<this>" · "clazz" · "owner"
- `Object invoke()`  L43 @Override
- `ViewModel viewModelForClass$lambda$0(Function0 function0, ViewModelStoreOwner viewModelStoreOwner, ComponentActivity componentActivity, KClass kClass, ViewModelStore viewModelStore, String str, Qualifier qualifier, Function0 function1)`  L50
- `Lazy<T> viewModelForClass(final Fragment fragment, final KClass<T> clazz, final Qualifier qualifier, final Function0<? extends ViewModelStoreOwner> owner, final Function0<Bundle> function0, final String str, final Function0<? extends ParametersHolder> function1)`  L59
    - 体内字面量："<this>" · "clazz" · "owner"
- `Object invoke()`  L65 @Override
- `ViewModel viewModelForClass$lambda$2(Function0 function0, Function0 function1, Fragment fragment, KClass kClass, String str, Qualifier qualifier, Function0 function2)`  L72