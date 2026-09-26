# XTU GO — 类与成员明细：com.gku.module_base_xtugo.api

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.module_base_xtugo.api.ApiUtils`
L8 · [class] public ApiUtils · `com/gku/module_base_xtugo/api/ApiUtils.java`

字段/常量（4）：
- `int CODE_JSON_PARSE_ERROR = 200`  L9
- `int CODE_NO_DATA = 100`  L10
- `int CODE_OK = 0`  L11
- `String URL_SERVER = "https://server4.gkuvision.com"`  L12

方法（1）：
- `GetRequestGenerator get(Context context, String str)`  L14
    - 体内字面量："https://server4.gkuvision.com"
### `com.gku.module_base_xtugo.api.bean.GetNewestVersionResponseBean`
L4 · [class] public GetNewestVersionResponseBean · extends `ResponseBean<DataBean>` · `com/gku/module_base_xtugo/api/bean/GetNewestVersionResponseBean.java`
### `com.gku.module_base_xtugo.api.bean.GetNewestVersionResponseBean$DataBean`
L6 · [class] public static DataBean · `com/gku/module_base_xtugo/api/bean/GetNewestVersionResponseBean.java`

字段/常量（4）：
- `String firmWareSize`  L7
- `String updates`  L8
- `String url`  L9
- `String versionNumber`  L10

方法（8）：
- `String getVersionNumber()`  L12
- `void setVersionNumber(String str)`  L16
- `String getFirmWareSize()`  L20
- `void setFirmWareSize(String str)`  L24
- `String getUpdates()`  L28
- `void setUpdates(String str)`  L32
- `String getUrl()`  L36
- `void setUrl(String str)`  L40
### `com.gku.module_base_xtugo.api.bean.ResponseBean`
L4 · [class] public ResponseBean · `com/gku/module_base_xtugo/api/bean/ResponseBean.java`

字段/常量（3）：
- `T data`  L5
- `String message`  L6
- `int retCode`  L7

方法（6）：
- `T getData()`  L9
- `void setData(T t)`  L13
- `int getRetCode()`  L17
- `void setRetCode(int i)`  L21
- `String getMessage()`  L25
- `void setMessage(String str)`  L29
### `com.gku.module_base_xtugo.api.StringCallbackApi`
L15 · [class] public abstract StringCallbackApi · extends `ResponseBean<?>> extends StringCallback` · `com/gku/module_base_xtugo/api/StringCallbackApi.java`

方法（5）：
- `void onFail(int i)`  L16
- `void onSuccess(T t, String str)`  L18
- `public StringCallbackApi(Context context)`  L20
- `void onSuccess(Call call, String str, Response response)`  L25 @Override
    - 体内字面量："onSuccess"
- `void onFail(Call call, int i, String str)`  L42 @Override
    - 体内字面量："onSuccessonFail" · ":"