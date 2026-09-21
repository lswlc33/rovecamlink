# XTU GO — 类与成员明细：com.gku.loginmodule

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.CallBack`
L4 · [interface] public CallBack · `com/gku/loginmodule/CallBack.java`

方法（1）：
- `void onResult()`  L5
### `com.gku.loginmodule.NetworkRequiredInfo`
L8 · [class] public NetworkRequiredInfo · implements `INetworkRequiredInfo` · `com/gku/loginmodule/NetworkRequiredInfo.java`

字段/常量（1）：
- `Application application`  L9

方法（5）：
- `boolean isDebug()`  L12 @Override
- `public NetworkRequiredInfo(Application application)`  L16
- `String getAppVersionName()`  L21 @Override
- `String getAppVersionCode()`  L26 @Override
- `Application getApplicationContext()`  L31 @Override