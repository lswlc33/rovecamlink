# XTU GO — 类与成员明细：com.gku.base.eventbus

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.base.eventbus.MessageEvent`
L4 · [class] public MessageEvent · `com/gku/base/eventbus/MessageEvent.java`

字段/常量（2）：
- `String key`  L5
- `T msg`  L6

方法（5）：
- `public MessageEvent(String str, T t)`  L8
- `String getKey()`  L13
- `R setKey(String str)`  L17
- `T getMessage()`  L22
- `R setMessage(T t)`  L26
### `com.gku.base.eventbus.MsgEventConstants`
L4 · [class] public MsgEventConstants · `com/gku/base/eventbus/MsgEventConstants.java`

字段/常量（5）：
- `String KEY_EDIT_COLOR = "KEY_EDIT_COLOR"`  L5
- `String KEY_EDIT_COMPRESS = "KEY_EDIT_COMPRESS"`  L6
- `String KEY_EDIT_CUT = "KEY_EDIT_CUT"`  L7
- `String KEY_EDIT_FILTER = "KEY_EDIT_FILTER"`  L8
- `String KEY_EDIT_ROTATE = "key_edit_rotate"`  L9