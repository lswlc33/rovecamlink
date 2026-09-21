# idGoLive — 类与成员明细：com.icatchtek.baseutil.log

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.log.AppLog`
L19 · [class] public AppLog · `com/icatchtek/baseutil/log/AppLog.java`

字段/常量（16）：
- `String TAG = "AppLog"`  L20
- `Context context = null`  L21
- `boolean enableLog = false`  L22
- `boolean hasConfiguration = false`  L23
- `long maxFileSize = 52428800`  L24
- `FileOutputStream out`  L25
- `String writeFile`  L26
- `File writeLogFile`  L27
- `FileOutputStream fileOutputStream = out`  L31
- `FileOutputStream fileOutputStream = out`  L77
- `FileOutputStream fileOutputStream = out`  L98
- `PackageInfo packageInfo`  L109
- `FileOutputStream fileOutputStream = out`  L144
- `File file`  L155
- `FileOutputStream fileOutputStream = out`  L190
- `FileOutputStream fileOutputStream = out`  L210

方法（10）：
- `void closeWriteStream()`  L29
    - 体内字面量："1111" · "closeWriteStream"
- `void createFile(String str, String str2)`  L41
    - 体内字面量："FileOper" · "start createFile" · "FileOper" · "directoryPath+fileName =" · "FileOper" · "file is not exists,need to create!" · "FileOper" · "FileNotFoundException" · "FileOper" · "IOException"
- `void d(String str, String str2)`  L66
    - 体内字面量：" [Debug] [" · "] [" · "]\n"
- `void e(String str, String str2)`  L87
    - 体内字面量：" [Error] [" · "] [" · "]\n"
- `void enableAppLog(Context context2)`  L108
- `String getSystemDate()`  L129
    - 体内字面量："yyyy-MM-dd HH:mm:ss:SSS"
- `void i(String str, String str2)`  L133
    - 体内字面量：" [Info ] [" · "] [" · "]\n"
- `void initConfiguration()`  L154
- `void tmpi(String str, String str2)`  L185
    - 体内字面量：" [Info ] [" · "] [" · "]\n"
- `void w(String str, String str2)`  L200
    - 体内字面量：" [Warn ] [" · "] [" · "]\n"