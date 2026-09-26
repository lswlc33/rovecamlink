# TUWIN — 类与成员明细：org.koin.core.qualifier

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 4 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.core.qualifier.Qualifier`
L9 · [interface] public Qualifier · `org/koin/core/qualifier/Qualifier.java`
注解：

方法（1）：
- `String getValue()`  L10
### `org.koin.core.qualifier.QualifierKt`
L14 · [class] public final QualifierKt · `org/koin/core/qualifier/QualifierKt.java`
注解：

方法（9）：
- `StringQualifier named(String name)`  L15
    - 体内字面量："name"
- `> Qualifier named(Enum<E> r1)`  L20
    - 体内字面量："enum"
- `StringQualifier qualifier(String name)`  L25
    - 体内字面量："name"
- `> Qualifier qualifier(Enum<E> r1)`  L30
    - 体内字面量："enum"
- `StringQualifier m2494_q(String name)`  L36
    - 体内字面量："name"
- `TypeQualifier named()`  L41
- `TypeQualifier qualifier()`  L46
- `TypeQualifier m2495_q()`  L52
- `> Qualifier getQualifier(Enum<E> r2)`  L57
    - 体内字面量："<this>" · "toLowerCase(...)"
### `org.koin.core.qualifier.StringQualifier`
L10 · [class] public final StringQualifier · implements `Qualifier` · `org/koin/core/qualifier/StringQualifier.java`
注解：

字段/常量（1）：
- `String value`  L11

方法（8）：
- `StringQualifier copy$default(StringQualifier stringQualifier, String str, int i, Object obj)`  L13
- `String getValue()`  L21
- `StringQualifier copy(String value)`  L25
    - 体内字面量："value"
- `boolean equals(Object other)`  L30
- `int hashCode()`  L37
- `public StringQualifier(String value)`  L41
    - 体内字面量："value"
- `String getValue()`  L47 @Override
- `String toString()`  L51
### `org.koin.core.qualifier.TypeQualifier`
L12 · [class] public final TypeQualifier · implements `Qualifier` · `org/koin/core/qualifier/TypeQualifier.java`
注解：

字段/常量（2）：
- `KClass<?> type`  L13
- `String value`  L14

方法（6）：
- `public TypeQualifier(KClass<?> type)`  L16
    - 体内字面量："type"
- `KClass<?> getType()`  L22
- `String getValue()`  L27 @Override
- `String toString()`  L31
- `boolean equals(Object other)`  L35
- `int hashCode()`  L42