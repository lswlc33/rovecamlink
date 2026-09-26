# TUWIN — 类与成员明细：org.koin.androidx.fragment

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 7 个文件 / 53 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.androidx.fragment.android.ActivityExtKt`
L19 · [class] public final ActivityExtKt · `org/koin/androidx/fragment/android/ActivityExtKt.java`
注解：

方法（4）：
- `void setupKoinFragmentFactory$default(FragmentActivity fragmentActivity, Scope scope, int i, Object obj)`  L20
- `void setupKoinFragmentFactory(FragmentActivity fragmentActivity, Scope scope)`  L27
    - 体内字面量："<this>"
- `FragmentTransaction replace$default(FragmentTransaction fragmentTransaction, int i, Bundle bundle, String str, int i2, Object obj)`  L36
    - 体内字面量："<this>" · "F" · "replace(...)"
- `FragmentTransaction replace(FragmentTransaction fragmentTransaction, int i, Bundle bundle, String str)`  L50
    - 体内字面量："<this>" · "F" · "replace(...)"
### `org.koin.androidx.fragment.android.KoinFragmentFactory`
L18 · [class] public final KoinFragmentFactory · extends `FragmentFactory implements KoinComponent` · implements `KoinComponent` · `org/koin/androidx/fragment/android/KoinFragmentFactory.java`
注解：

字段/常量（3）：
- `Scope scope`  L19
- `Fragment fragment`  L41
- `Scope scope = this.scope`  L47

方法（5）：
- `public KoinFragmentFactory()`  L22
- `public KoinFragmentFactory(Scope scope)`  L26
- ` KoinFragmentFactory(Scope scope, int i, DefaultConstructorMarker defaultConstructorMarker)`  L30
- `Koin getKoin()`  L35 @Override
- `Fragment instantiate(ClassLoader classLoader, String className)`  L40 @Override
### `org.koin.androidx.fragment.dsl.FragmentOfKt`
L48 · [class] public final FragmentOfKt · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（46）：
- `Kind kind = Kind.Factory`  L58
- `Kind kind = Kind.Factory`  L93
- `Kind kind = Kind.Factory`  L110
- `Kind kind = Kind.Factory`  L148
- `Kind kind = Kind.Factory`  L165
- `Kind kind = Kind.Factory`  L205
- `Kind kind = Kind.Factory`  L222
- `Kind kind = Kind.Factory`  L264
- `Kind kind = Kind.Factory`  L281
- `Kind kind = Kind.Factory`  L325
- `Kind kind = Kind.Factory`  L342
- `Kind kind = Kind.Factory`  L388
- `Kind kind = Kind.Factory`  L405
- `Kind kind = Kind.Factory`  L453
- `Kind kind = Kind.Factory`  L470
- `Kind kind = Kind.Factory`  L520
- `Kind kind = Kind.Factory`  L537
- `Kind kind = Kind.Factory`  L589
- `Kind kind = Kind.Factory`  L606
- `Kind kind = Kind.Factory`  L660
- `Kind kind = Kind.Factory`  L677
- `Kind kind = Kind.Factory`  L733
- `Kind kind = Kind.Factory`  L750
- `Kind kind = Kind.Factory`  L808
- `Kind kind = Kind.Factory`  L825
- `Kind kind = Kind.Factory`  L885
- `Kind kind = Kind.Factory`  L902
- `Kind kind = Kind.Factory`  L964
- `Kind kind = Kind.Factory`  L981
- `Kind kind = Kind.Factory`  L1045
- `Kind kind = Kind.Factory`  L1062
- `Kind kind = Kind.Factory`  L1128
- `Kind kind = Kind.Factory`  L1145
- `Kind kind = Kind.Factory`  L1213
- `Kind kind = Kind.Factory`  L1230
- `Kind kind = Kind.Factory`  L1300
- `Kind kind = Kind.Factory`  L1317
- `Kind kind = Kind.Factory`  L1389
- `Kind kind = Kind.Factory`  L1406
- `Kind kind = Kind.Factory`  L1480
- `Kind kind = Kind.Factory`  L1497
- `Kind kind = Kind.Factory`  L1573
- `Kind kind = Kind.Factory`  L1590
- `Kind kind = Kind.Factory`  L1668
- `Kind kind = Kind.Factory`  L1685
- `Kind kind = Kind.Factory`  L1765

方法（46）：
- `KoinDefinition fragmentOf$default(Module module, Function0 constructor, Function1 function1, int i, Object obj)`  L49
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function0<? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L87
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function1 constructor, Function1 function1, int i, Object obj)`  L101
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function1<? super T1, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L142
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function2 constructor, Function1 function1, int i, Object obj)`  L156
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function2<? super T1, ? super T2, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L199
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function3 constructor, Function1 function1, int i, Object obj)`  L213
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function3<? super T1, ? super T2, ? super T3, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L258
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function4 constructor, Function1 function1, int i, Object obj)`  L272
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L319
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function5 constructor, Function1 function1, int i, Object obj)`  L333
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L382
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function6 constructor, Function1 function1, int i, Object obj)`  L396
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L447
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function7 constructor, Function1 function1, int i, Object obj)`  L461
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L514
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function8 constructor, Function1 function1, int i, Object obj)`  L528
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L583
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function9 constructor, Function1 function1, int i, Object obj)`  L597
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L654
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function10 constructor, Function1 function1, int i, Object obj)`  L668
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L727
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function11 constructor, Function1 function1, int i, Object obj)`  L741
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L802
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function12 constructor, Function1 function1, int i, Object obj)`  L816
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L879
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function13 constructor, Function1 function1, int i, Object obj)`  L893
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L958
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function14 constructor, Function1 function1, int i, Object obj)`  L972
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1039
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function15 constructor, Function1 function1, int i, Object obj)`  L1053
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1122
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function16 constructor, Function1 function1, int i, Object obj)`  L1136
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1207
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function17 constructor, Function1 function1, int i, Object obj)`  L1221
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1294
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function18 constructor, Function1 function1, int i, Object obj)`  L1308
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1383
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function19 constructor, Function1 function1, int i, Object obj)`  L1397
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1474
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function20 constructor, Function1 function1, int i, Object obj)`  L1488
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1567
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function21 constructor, Function1 function1, int i, Object obj)`  L1581
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1662
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(Module module, Function22 constructor, Function1 function1, int i, Object obj)`  L1676
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(Module module, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1759
    - 体内字面量："<this>" · "constructor"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C37581`
L70 · [class] public static final C37581 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（1）：
- `Function0<R> $constructor`  L71

方法（2）：
- `public C37581(Function0<? extends R> function0)`  L74
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L80 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C375910`
L618 · [class] public static final C375910 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> $constructor`  L619
- `Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9 = this.$constructor`  L632

方法（2）：
- `public C375910(Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9)`  L622
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L629 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C376011`
L689 · [class] public static final C376011 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> $constructor`  L690
- `Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> function10 = this.$constructor`  L703

方法（2）：
- `public C376011(Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10)`  L693
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L700 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C376112`
L762 · [class] public static final C376112 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> $constructor`  L763
- `Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> function11 = this.$constructor`  L776

方法（2）：
- `public C376112(Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11)`  L766
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L773 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C376213`
L837 · [class] public static final C376213 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> $constructor`  L838
- `Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> function12 = this.$constructor`  L851

方法（2）：
- `public C376213(Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12)`  L841
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L848 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C376314`
L914 · [class] public static final C376314 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> $constructor`  L915
- `Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> function13 = this.$constructor`  L928

方法（2）：
- `public C376314(Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13)`  L918
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L925 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C376415`
L993 · [class] public static final C376415 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> $constructor`  L994
- `Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> function14 = this.$constructor`  L1007

方法（2）：
- `public C376415(Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14)`  L997
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1004 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C376516`
L1074 · [class] public static final C376516 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> $constructor`  L1075
- `Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> function15 = this.$constructor`  L1088

方法（2）：
- `public C376516(Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15)`  L1078
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1085 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C376617`
L1157 · [class] public static final C376617 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> $constructor`  L1158
- `Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> function16 = this.$constructor`  L1171

方法（2）：
- `public C376617(Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16)`  L1161
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1168 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C376718`
L1242 · [class] public static final C376718 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> $constructor`  L1243
- `Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> function17 = this.$constructor`  L1256

方法（2）：
- `public C376718(Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17)`  L1246
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1253 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C376819`
L1329 · [class] public static final C376819 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> $constructor`  L1330
- `Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> function18 = this.$constructor`  L1343

方法（2）：
- `public C376819(Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> function18)`  L1333
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1340 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C37692`
L122 · [class] public static final C37692 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function1<T1, R> $constructor`  L123
- `Function1<T1, R> function1 = this.$constructor`  L136

方法（2）：
- `public C37692(Function1<? super T1, ? extends R> function1)`  L126
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L133 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C377020`
L1418 · [class] public static final C377020 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> $constructor`  L1419
- `Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> function19 = this.$constructor`  L1432

方法（2）：
- `public C377020(Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> function19)`  L1422
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1429 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C377121`
L1509 · [class] public static final C377121 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> $constructor`  L1510
- `Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> function20 = this.$constructor`  L1523

方法（2）：
- `public C377121(Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> function20)`  L1513
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1520 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C377222`
L1602 · [class] public static final C377222 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> $constructor`  L1603
- `Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> function21 = this.$constructor`  L1616

方法（2）：
- `public C377222(Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> function21)`  L1606
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1613 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C377323`
L1697 · [class] public static final C377323 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> $constructor`  L1698
- `Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> function22 = this.$constructor`  L1711

方法（2）：
- `public C377323(Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22)`  L1701
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1708 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C37743`
L177 · [class] public static final C37743 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function2<T1, T2, R> $constructor`  L178
- `Function2<T1, T2, R> function2 = this.$constructor`  L191

方法（2）：
- `public C37743(Function2<? super T1, ? super T2, ? extends R> function2)`  L181
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L188 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C37754`
L234 · [class] public static final C37754 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function3<T1, T2, T3, R> $constructor`  L235
- `Function3<T1, T2, T3, R> function3 = this.$constructor`  L248

方法（2）：
- `public C37754(Function3<? super T1, ? super T2, ? super T3, ? extends R> function3)`  L238
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L245 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C37765`
L293 · [class] public static final C37765 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function4<T1, T2, T3, T4, R> $constructor`  L294
- `Function4<T1, T2, T3, T4, R> function4 = this.$constructor`  L307

方法（2）：
- `public C37765(Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4)`  L297
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L304 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C37776`
L354 · [class] public static final C37776 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function5<T1, T2, T3, T4, T5, R> $constructor`  L355
- `Function5<T1, T2, T3, T4, T5, R> function5 = this.$constructor`  L368

方法（2）：
- `public C37776(Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5)`  L358
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L365 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C37787`
L417 · [class] public static final C37787 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function6<T1, T2, T3, T4, T5, T6, R> $constructor`  L418
- `Function6<T1, T2, T3, T4, T5, T6, R> function6 = this.$constructor`  L431

方法（2）：
- `public C37787(Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6)`  L421
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L428 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C37798`
L482 · [class] public static final C37798 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function7<T1, T2, T3, T4, T5, T6, T7, R> $constructor`  L483
- `Function7<T1, T2, T3, T4, T5, T6, T7, R> function7 = this.$constructor`  L496

方法（2）：
- `public C37798(Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7)`  L486
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L493 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.FragmentOfKt$C37809`
L549 · [class] public static final C37809 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/FragmentOfKt.java`
注解：

字段/常量（2）：
- `Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> $constructor`  L550
- `Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8 = this.$constructor`  L563

方法（2）：
- `public C37809(Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8)`  L553
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L560 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ModuleExtKt`
L26 · [class] public final ModuleExtKt · `org/koin/androidx/fragment/dsl/ModuleExtKt.java`
注解：

字段/常量（2）：
- `Kind kind = Kind.Factory`  L34
- `Kind kind = Kind.Factory`  L46

方法（2）：
- `KoinDefinition fragment$default(Module module, Qualifier qualifier, Function2 definition, int i, Object obj)`  L27
    - 体内字面量："<this>" · "definition"
- `KoinDefinition<T> fragment(Module module, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition)`  L42
    - 体内字面量："<this>" · "definition"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt`
L48 · [class] public final ScopeFragmentOfKt · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（46）：
- `Kind kind = Kind.Factory`  L59
- `Kind kind = Kind.Factory`  L95
- `Kind kind = Kind.Factory`  L113
- `Kind kind = Kind.Factory`  L152
- `Kind kind = Kind.Factory`  L170
- `Kind kind = Kind.Factory`  L211
- `Kind kind = Kind.Factory`  L229
- `Kind kind = Kind.Factory`  L272
- `Kind kind = Kind.Factory`  L290
- `Kind kind = Kind.Factory`  L335
- `Kind kind = Kind.Factory`  L353
- `Kind kind = Kind.Factory`  L400
- `Kind kind = Kind.Factory`  L418
- `Kind kind = Kind.Factory`  L467
- `Kind kind = Kind.Factory`  L485
- `Kind kind = Kind.Factory`  L536
- `Kind kind = Kind.Factory`  L554
- `Kind kind = Kind.Factory`  L607
- `Kind kind = Kind.Factory`  L625
- `Kind kind = Kind.Factory`  L680
- `Kind kind = Kind.Factory`  L698
- `Kind kind = Kind.Factory`  L755
- `Kind kind = Kind.Factory`  L773
- `Kind kind = Kind.Factory`  L832
- `Kind kind = Kind.Factory`  L850
- `Kind kind = Kind.Factory`  L911
- `Kind kind = Kind.Factory`  L929
- `Kind kind = Kind.Factory`  L992
- `Kind kind = Kind.Factory`  L1010
- `Kind kind = Kind.Factory`  L1075
- `Kind kind = Kind.Factory`  L1093
- `Kind kind = Kind.Factory`  L1160
- `Kind kind = Kind.Factory`  L1178
- `Kind kind = Kind.Factory`  L1247
- `Kind kind = Kind.Factory`  L1265
- `Kind kind = Kind.Factory`  L1336
- `Kind kind = Kind.Factory`  L1354
- `Kind kind = Kind.Factory`  L1427
- `Kind kind = Kind.Factory`  L1445
- `Kind kind = Kind.Factory`  L1520
- `Kind kind = Kind.Factory`  L1538
- `Kind kind = Kind.Factory`  L1615
- `Kind kind = Kind.Factory`  L1633
- `Kind kind = Kind.Factory`  L1712
- `Kind kind = Kind.Factory`  L1730
- `Kind kind = Kind.Factory`  L1811

方法（46）：
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function0 constructor, Function1 function1, int i, Object obj)`  L49
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function0<? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L88
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function1 constructor, Function1 function1, int i, Object obj)`  L103
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function1<? super T1, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L145
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function2 constructor, Function1 function1, int i, Object obj)`  L160
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function2<? super T1, ? super T2, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L204
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function3 constructor, Function1 function1, int i, Object obj)`  L219
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function3<? super T1, ? super T2, ? super T3, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L265
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function4 constructor, Function1 function1, int i, Object obj)`  L280
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L328
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function5 constructor, Function1 function1, int i, Object obj)`  L343
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L393
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function6 constructor, Function1 function1, int i, Object obj)`  L408
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L460
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function7 constructor, Function1 function1, int i, Object obj)`  L475
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L529
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function8 constructor, Function1 function1, int i, Object obj)`  L544
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L600
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function9 constructor, Function1 function1, int i, Object obj)`  L615
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L673
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function10 constructor, Function1 function1, int i, Object obj)`  L688
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L748
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function11 constructor, Function1 function1, int i, Object obj)`  L763
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L825
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function12 constructor, Function1 function1, int i, Object obj)`  L840
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L904
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function13 constructor, Function1 function1, int i, Object obj)`  L919
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L985
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function14 constructor, Function1 function1, int i, Object obj)`  L1000
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1068
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function15 constructor, Function1 function1, int i, Object obj)`  L1083
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1153
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function16 constructor, Function1 function1, int i, Object obj)`  L1168
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1240
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function17 constructor, Function1 function1, int i, Object obj)`  L1255
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1329
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function18 constructor, Function1 function1, int i, Object obj)`  L1344
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1420
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function19 constructor, Function1 function1, int i, Object obj)`  L1435
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1513
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function20 constructor, Function1 function1, int i, Object obj)`  L1528
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1608
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function21 constructor, Function1 function1, int i, Object obj)`  L1623
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1705
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition fragmentOf$default(ScopeDSL scopeDSL, Function22 constructor, Function1 function1, int i, Object obj)`  L1720
    - 体内字面量："<this>" · "constructor"
- `KoinDefinition<R> fragmentOf(ScopeDSL scopeDSL, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> constructor, Function1<? super BeanDefinition<R>, Unit> function1)`  L1804
    - 体内字面量："<this>" · "constructor"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C37811`
L71 · [class] public static final C37811 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（1）：
- `Function0<R> $constructor`  L72

方法（2）：
- `public C37811(Function0<? extends R> function0)`  L75
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L81 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C378210`
L637 · [class] public static final C378210 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> $constructor`  L638
- `Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9 = this.$constructor`  L651

方法（2）：
- `public C378210(Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9)`  L641
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L648 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C378311`
L710 · [class] public static final C378311 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> $constructor`  L711
- `Function10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> function10 = this.$constructor`  L724

方法（2）：
- `public C378311(Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10)`  L714
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L721 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C378412`
L785 · [class] public static final C378412 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> $constructor`  L786
- `Function11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> function11 = this.$constructor`  L799

方法（2）：
- `public C378412(Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11)`  L789
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L796 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C378513`
L862 · [class] public static final C378513 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> $constructor`  L863
- `Function12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> function12 = this.$constructor`  L876

方法（2）：
- `public C378513(Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12)`  L866
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L873 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C378614`
L941 · [class] public static final C378614 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> $constructor`  L942
- `Function13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> function13 = this.$constructor`  L955

方法（2）：
- `public C378614(Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13)`  L945
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L952 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C378715`
L1022 · [class] public static final C378715 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> $constructor`  L1023
- `Function14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> function14 = this.$constructor`  L1036

方法（2）：
- `public C378715(Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14)`  L1026
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1033 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C378816`
L1105 · [class] public static final C378816 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> $constructor`  L1106
- `Function15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> function15 = this.$constructor`  L1119

方法（2）：
- `public C378816(Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15)`  L1109
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1116 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C378917`
L1190 · [class] public static final C378917 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> $constructor`  L1191
- `Function16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> function16 = this.$constructor`  L1204

方法（2）：
- `public C378917(Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16)`  L1194
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1201 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C379018`
L1277 · [class] public static final C379018 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> $constructor`  L1278
- `Function17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> function17 = this.$constructor`  L1291

方法（2）：
- `public C379018(Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17)`  L1281
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1288 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C379119`
L1366 · [class] public static final C379119 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> $constructor`  L1367
- `Function18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R> function18 = this.$constructor`  L1380

方法（2）：
- `public C379119(Function18<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? extends R> function18)`  L1370
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1377 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C37922`
L125 · [class] public static final C37922 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function1<T1, R> $constructor`  L126
- `Function1<T1, R> function1 = this.$constructor`  L139

方法（2）：
- `public C37922(Function1<? super T1, ? extends R> function1)`  L129
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L136 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C379320`
L1457 · [class] public static final C379320 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> $constructor`  L1458
- `Function19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R> function19 = this.$constructor`  L1471

方法（2）：
- `public C379320(Function19<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? extends R> function19)`  L1461
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1468 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C379421`
L1550 · [class] public static final C379421 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> $constructor`  L1551
- `Function20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R> function20 = this.$constructor`  L1564

方法（2）：
- `public C379421(Function20<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? extends R> function20)`  L1554
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1561 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C379522`
L1645 · [class] public static final C379522 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> $constructor`  L1646
- `Function21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R> function21 = this.$constructor`  L1659

方法（2）：
- `public C379522(Function21<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? extends R> function21)`  L1649
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1656 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C379623`
L1742 · [class] public static final C379623 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> $constructor`  L1743
- `Function22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> function22 = this.$constructor`  L1756

方法（2）：
- `public C379623(Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22)`  L1746
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L1753 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C37973`
L182 · [class] public static final C37973 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function2<T1, T2, R> $constructor`  L183
- `Function2<T1, T2, R> function2 = this.$constructor`  L196

方法（2）：
- `public C37973(Function2<? super T1, ? super T2, ? extends R> function2)`  L186
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L193 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C37984`
L241 · [class] public static final C37984 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function3<T1, T2, T3, R> $constructor`  L242
- `Function3<T1, T2, T3, R> function3 = this.$constructor`  L255

方法（2）：
- `public C37984(Function3<? super T1, ? super T2, ? super T3, ? extends R> function3)`  L245
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L252 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C37995`
L302 · [class] public static final C37995 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function4<T1, T2, T3, T4, R> $constructor`  L303
- `Function4<T1, T2, T3, T4, R> function4 = this.$constructor`  L316

方法（2）：
- `public C37995(Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4)`  L306
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L313 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C38006`
L365 · [class] public static final C38006 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function5<T1, T2, T3, T4, T5, R> $constructor`  L366
- `Function5<T1, T2, T3, T4, T5, R> function5 = this.$constructor`  L379

方法（2）：
- `public C38006(Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5)`  L369
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L376 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C38017`
L430 · [class] public static final C38017 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function6<T1, T2, T3, T4, T5, T6, R> $constructor`  L431
- `Function6<T1, T2, T3, T4, T5, T6, R> function6 = this.$constructor`  L444

方法（2）：
- `public C38017(Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6)`  L434
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L441 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C38028`
L497 · [class] public static final C38028 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function7<T1, T2, T3, T4, T5, T6, T7, R> $constructor`  L498
- `Function7<T1, T2, T3, T4, T5, T6, T7, R> function7 = this.$constructor`  L511

方法（2）：
- `public C38028(Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7)`  L501
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L508 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeFragmentOfKt$C38039`
L566 · [class] public static final C38039 · implements `Function2<Scope, ParametersHolder, R>` · `org/koin/androidx/fragment/dsl/ScopeFragmentOfKt.java`
注解：

字段/常量（2）：
- `Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> $constructor`  L567
- `Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8 = this.$constructor`  L580

方法（2）：
- `public C38039(Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8)`  L570
- `Fragment invoke(Scope fragment, ParametersHolder it)`  L577 @Override
    - 体内字面量："$this$fragment" · "it"
### `org.koin.androidx.fragment.dsl.ScopeSetExtKt`
L25 · [class] public final ScopeSetExtKt · `org/koin/androidx/fragment/dsl/ScopeSetExtKt.java`
注解：

字段/常量（3）：
- `Qualifier qualifier2 = qualifier`  L30
- `Kind kind = Kind.Factory`  L35
- `Kind kind = Kind.Factory`  L48

方法（2）：
- `KoinDefinition fragment$default(ScopeDSL scopeDSL, Qualifier qualifier, Function2 definition, int i, Object obj)`  L26
- `KoinDefinition<T> fragment(ScopeDSL scopeDSL, Qualifier qualifier, Function2<? super Scope, ? super ParametersHolder, ? extends T> definition)`  L43
    - 体内字面量："<this>" · "definition"
### `org.koin.androidx.fragment.koin.KoinApplicationExtKt`
L28 · [class] public final KoinApplicationExtKt · `org/koin/androidx/fragment/koin/KoinApplicationExtKt.java`
注解：

字段/常量（1）：
- `SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory`  L58

方法（5）：
- `Object invoke(Object obj)`  L31 @Override
- `FragmentFactory fragmentFactoryModule$lambda$1$lambda$0(Scope single, ParametersHolder it)`  L37
    - 体内字面量："$this$single" · "it"
- `void fragmentFactory(KoinApplication koinApplication)`  L43
    - 体内字面量："<this>"
- `Unit fragmentFactoryModule$lambda$1(Module module)`  L49
    - 体内字面量："$this$module"
- `Object invoke(Object obj, Object obj2)`  L53 @Override