# TUWIN — 类与成员明细：org.koin.core.annotation

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.core.annotation.KoinExperimentalAPI`
L17 · [@interface] public KoinExperimentalAPI · `org/koin/core/annotation/KoinExperimentalAPI.java`
注解：@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR}) @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.CONSTRUCTOR}) @Retention(RetentionPolicy.RUNTIME)
### `org.koin.core.annotation.KoinInternalApi`
L19 · [@interface] public KoinInternalApi · `org/koin/core/annotation/KoinInternalApi.java`
注解：@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD}) @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.PROPERTY}) @Retention(RetentionPolicy.CLASS) @kotlin.annotation.Retention(AnnotationRetention.BINARY)