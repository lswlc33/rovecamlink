# TUWIN — 类与成员明细：org.koin.core.extension

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.core.extension.ExtensionManager`
L16 · [class] public final ExtensionManager · `org/koin/core/extension/ExtensionManager.java`
注解：

字段/常量（2）：
- `Koin _koin`  L17
- `HashMap<String, KoinExtension> extensions`  L18

方法（8）：
- `void getExtensions$annotations()`  L20
- `public ExtensionManager(Koin _koin)`  L23
    - 体内字面量："_koin"
- `Koin get_koin()`  L30
- `HashMap<String, KoinExtension> getExtensions()`  L34
- `T getExtension(String id)`  L38
    - 体内字面量："id" · "Koin extension '" · "' not found."
- `T getExtensionOrNull(String id)`  L49
    - 体内字面量："id"
- `void registerExtension(String id, T extension)`  L56
    - 体内字面量："id" · "extension"
- `void close()`  L63
    - 体内字面量："<get-values>(...)"
### `org.koin.core.extension.KoinExtension`
L10 · [interface] public KoinExtension · `org/koin/core/extension/KoinExtension.java`
注解：

方法（2）：
- `void onClose()`  L11
- `void onRegister(Koin koin)`  L13