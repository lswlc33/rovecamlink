# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.core.global

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.core.global.GlobalData`
L12 · [class] public final GlobalData · `com/tuwinsmart/tuwin/core/global/GlobalData.java`
注解：

字段/常量（5）：
- `String currentDevId`  L14
- `String currentSSID`  L15
- `HashMap<String, String> deviceAttr`  L16
- `boolean is4GDevice`  L17
- `String str`  L43

方法（9）：
- `private GlobalData()`  L19
- `String getCurrentDevId()`  L22
- `void setCurrentDevId(String str)`  L26
- `String getCurrentSSID()`  L30
- `void setCurrentSSID(String str)`  L34
- `HashMap<String, String> getDeviceAttr()`  L38
- `void setDeviceAttr(HashMap<String, String> map)`  L42
- `boolean is4GDevice()`  L52
- `void set4GDevice(boolean z)`  L56