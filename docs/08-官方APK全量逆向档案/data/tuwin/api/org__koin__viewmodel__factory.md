# TUWIN — 类与成员明细：org.koin.viewmodel.factory

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.viewmodel.factory.AndroidParametersHolder`
L24 · [class] public final AndroidParametersHolder · extends `ParametersHolder` · `org/koin/viewmodel/factory/AndroidParametersHolder.java`
注解：

字段/常量（4）：
- `CreationExtras extras`  L25
- `ParametersHolder parametersHolderInvoke`  L33
- `List<Object> values`  L34
- `ArrayList mutableList`  L35

方法（5）：
- ` AndroidParametersHolder(Function0 function0, CreationExtras creationExtras, int i, DefaultConstructorMarker defaultConstructorMarker)`  L27
- `public AndroidParametersHolder(Function0<? extends ParametersHolder> function0, CreationExtras extras)`  L32
- `T createSavedStateHandleOrElse(KClass<?> clazz, Function0<? extends T> block)`  L41
- `T elementAt(int i, KClass<?> clazz)`  L49 @Override
    - 体内字面量："clazz"
- `T getOrNull(KClass<?> clazz)`  L58 @Override
    - 体内字面量："clazz"
### `org.koin.viewmodel.factory.KoinViewModelFactory`
L20 · [class] public final KoinViewModelFactory · implements `ViewModelProvider.Factory` · `org/koin/viewmodel/factory/KoinViewModelFactory.java`
注解：

字段/常量（4）：
- `KClass<? extends ViewModel> kClass`  L21
- `Function0<ParametersHolder> params`  L22
- `Qualifier qualifier`  L23
- `Scope scope`  L24

方法（3）：
- `public KoinViewModelFactory(KClass<? extends ViewModel> kClass, Scope scope, Qualifier qualifier, Function0<? extends ParametersHolder> function0)`  L27
    - 体内字面量："kClass" · "scope"
- ` KoinViewModelFactory(KClass kClass, Scope scope, Qualifier qualifier, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker)`  L36
- `T create(KClass<T> modelClass, CreationExtras extras)`  L41 @Override
    - 体内字面量："modelClass" · "extras"