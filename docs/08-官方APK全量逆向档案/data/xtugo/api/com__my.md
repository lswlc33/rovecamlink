# XTU GO — 类与成员明细：com.my

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `com.my.AppSettingActivity`
L25 · [class] public AppSettingActivity · extends `BaseXtuGoActivity` · `com/my/AppSettingActivity.java`

字段/常量（7）：
- `String TAG = "AppSettingActivity"`  L26
- `DialogDownloadSoft dialogDownloadSoft`  L27
- `boolean isAmba`  L28
- `String modelName`  L29
- `AppSettingActivity appSettingActivity = AppSettingActivity.this`  L51
- `AppSettingActivity appSettingActivity = AppSettingActivity.this`  L77
- `boolean zAfter`  L93

方法（10）：
- `void onDestroy()`  L32 @Override
- `void onCreate(Bundle savedInstanceState)`  L38 @Override
- `void onClick(View v)`  L44 @Override
- `void onClick(View v)`  L50 @Override
- `void onClick(View v)`  L57 @Override
    - 体内字面量："type"
- `void onClick(View v)`  L65 @Override
    - 体内字面量："type"
- `void onSuccess(File file)`  L73 @Override
- `void onClick(View v)`  L83 @Override
    - 体内字面量："modelNameAndSoftVersion" · "modelName" · "softVersion" · "isAmba" · "firmWareModel" · "\\s+" · "/push/api/getNewestVersion" · "firmWareModel" · "\\s+"
- `void onSuccess(GetNewestVersionResponseBean responseBean, String responseBody)`  L92 @Override
- `void onFail(int code)`  L116 @Override
    - 体内字面量：":"