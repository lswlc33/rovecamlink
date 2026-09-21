# TUWIN — 类与成员明细：org.koin.java

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.java.KoinJavaComponent`
L21 · [class] public final KoinJavaComponent · `org/koin/java/KoinJavaComponent.java`
注解：

方法（20）：
- `T get(Class<?> clazz)`  L25 
    - 体内字面量："clazz"
- `T get(Class<?> clazz, Qualifier qualifier)`  L31 
    - 体内字面量："clazz"
- `T getOrNull(Class<?> clazz)`  L37 
    - 体内字面量："clazz"
- `T getOrNull(Class<?> clazz, Qualifier qualifier)`  L43 
    - 体内字面量："clazz"
- `Lazy<T> inject(Class<?> clazz)`  L49 
    - 体内字面量："clazz"
- `Lazy<T> inject(Class<?> clazz, Qualifier qualifier)`  L55 
    - 体内字面量："clazz"
- `Lazy<T> injectOrNull(Class<?> clazz)`  L61 
    - 体内字面量："clazz"
- `Lazy<T> injectOrNull(Class<?> clazz, Qualifier qualifier)`  L67 
    - 体内字面量："clazz"
- `private KoinJavaComponent()`  L72
- `Lazy inject$default(Class cls, Qualifier qualifier, Function0 function0, int i, Object obj)`  L75
- `Lazy<T> inject(final Class<?> clazz, final Qualifier qualifier, final Function0<? extends ParametersHolder> parameters)`  L86 
    - 体内字面量："clazz"
- `Object invoke()`  L90 @Override
- `Lazy injectOrNull$default(Class cls, Qualifier qualifier, Function0 function0, int i, Object obj)`  L96
- `Lazy<T> injectOrNull(final Class<?> clazz, final Qualifier qualifier, final Function0<? extends ParametersHolder> parameters)`  L107 
    - 体内字面量："clazz"
- `Object invoke()`  L111 @Override
- `Object get$default(Class cls, Qualifier qualifier, Function0 function0, int i, Object obj)`  L117
- `T get(Class<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters)`  L128 
    - 体内字面量："clazz"
- `Object getOrNull$default(Class cls, Qualifier qualifier, Function0 function0, int i, Object obj)`  L133
- `T getOrNull(Class<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters)`  L144 
    - 体内字面量："clazz"
- `Koin getKoin()`  L150 