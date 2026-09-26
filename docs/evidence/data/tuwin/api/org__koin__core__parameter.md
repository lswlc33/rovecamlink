# TUWIN — 类与成员明细：org.koin.core.parameter

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.core.parameter.ParametersHolder`
L24 · [class] public ParametersHolder · `org/koin/core/parameter/ParametersHolder.java`
注解：@KoinDslMarker

字段/常量（6）：
- `List<Object> _values`  L25
- `int index`  L26
- `Boolean useIndexedValues`  L27
- `List<Object> list = this._values`  L105
- `Boolean bool = this.useIndexedValues`  L155
- `T t = null`  L183

方法（31）：
- `public ParametersHolder()`  L30
- `void get_values$annotations()`  L34
- `public ParametersHolder(List<Object> _values, Boolean bool)`  L37
    - 体内字面量："_values"
- `List<Object> get_values()`  L43
- ` ParametersHolder(ArrayList arrayList, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker)`  L47
- `Boolean getUseIndexedValues()`  L51
- `List<Object> getValues()`  L55
- `T elementAt(int i, KClass<?> clazz)`  L59
    - 体内字面量："clazz" · "Can't get injected parameter #" · " from " · " for type '" · "\\'"
- `T component1()`  L67
- `T component2()`  L72
- `T component3()`  L77
- `T component4()`  L82
- `T component5()`  L87
- `int getIndex()`  L92
- `void setIndex(int i)`  L96
- `T get(int i)`  L100
- `void set(int i, T t)`  L104
- `int size()`  L110
- `boolean isEmpty()`  L114
- `boolean isNotEmpty()`  L118
- `ParametersHolder insert(int index, Object value)`  L122
    - 体内字面量："value"
- `ParametersHolder add(Object value)`  L128
    - 体内字面量："value"
- `T get()`  L134
    - 体内字面量："No value found for type '" · "\\'"
- `T getOrNull()`  L145
- `T getOrNull(KClass<?> clazz)`  L150
    - 体内字面量："clazz"
- `T getFirstValue(KClass<?> clazz)`  L165
- `T getIndexedValue(KClass<?> clazz)`  L181
- `void increaseIndex()`  L196
- `String toString()`  L202
    - 体内字面量："DefinitionParameters"
- `boolean equals(Object other)`  L206
- `int hashCode()`  L213
### `org.koin.core.parameter.ParametersHolderKt`
L11 · [class] public final ParametersHolderKt · `org/koin/core/parameter/ParametersHolderKt.java`
注解：

方法（4）：
- `ParametersHolder parametersOf(Object... parameters)`  L12
    - 体内字面量："parameters"
- `ParametersHolder parameterArrayOf(Object... parameters)`  L17
    - 体内字面量："parameters"
- `ParametersHolder parameterSetOf(Object... parameters)`  L22
    - 体内字面量："parameters"
- `ParametersHolder emptyParametersHolder()`  L27