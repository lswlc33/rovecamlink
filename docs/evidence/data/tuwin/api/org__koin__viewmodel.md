# TUWIN — 类与成员明细：org.koin.viewmodel

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 3 个文件 / 3 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.viewmodel.BundleExtKt`
L19 · [class] public final BundleExtKt · `org/koin/viewmodel/BundleExtKt.java`
注解：

字段/常量（3）：
- `Object objM3074constructorimpl`  L30
- `Result.Companion companion = Result.INSTANCE`  L37
- `Result.Companion companion2 = Result.INSTANCE`  L44

方法（4）：
- `Function0<Bundle> emptyState()`  L20
- `Object invoke()`  L23 @Override
- `CreationExtras toExtras(Bundle bundle, ViewModelStoreOwner viewModelStoreOwner)`  L29
- `Bundle emptyState$lambda$2()`  L51
### `org.koin.viewmodel.CreationExtrasExtKt`
L13 · [class] public final CreationExtrasExtKt · `org/koin/viewmodel/CreationExtrasExtKt.java`
注解：

方法（1）：
- `CreationExtras defaultExtras(ViewModelStoreOwner viewModelStoreOwner)`  L14
    - 体内字面量："viewModelStoreOwner"
### `org.koin.viewmodel.GetViewModelKt`
L26 · [class] public final GetViewModelKt · `org/koin/viewmodel/GetViewModelKt.java`
注解：

字段/常量（1）：
- `String str3`  L54

方法（6）：
- `T resolveViewModel(KClass<T> vmClass, ViewModelStore viewModelStore, String str, CreationExtras extras, Qualifier qualifier, Scope scope, Function0<? extends ParametersHolder> function0)`  L27
    - 体内字面量："vmClass" · "viewModelStore" · "extras" · "scope"
- `String getViewModelKey$default(Qualifier qualifier, String str, String str2, int i, Object obj)`  L40
- `String getViewModelKey(Qualifier qualifier, String str, String str2)`  L53
- `Lazy<T> lazyResolveViewModel(final KClass<T> vmClass, final Function0<? extends ViewModelStore> viewModelStore, final String str, final Function0<? extends CreationExtras> extras, final Qualifier qualifier, final Scope scope, final Function0<? extends ParametersHolder> function0)`  L68
    - 体内字面量："vmClass" · "viewModelStore" · "extras" · "scope"
- `Object invoke()`  L75 @Override
- `ViewModel lazyResolveViewModel$lambda$1(KClass kClass, Function0 function0, String str, Function0 function1, Qualifier qualifier, Scope scope, Function0 function2)`  L82