# idGoLive — 类与成员明细：com.icatch.golive.Log

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.Log.AppLog`
L19 · [class] public AppLog · `com/icatch/golive/Log/AppLog.java`

字段/常量（14）：
- `String TAG = "AppLog"`  L20
- `boolean enableLog = false`  L21
- `boolean hasConfiguration = false`  L22
- `long maxFileSize = 52428800`  L23
- `FileOutputStream out`  L24
- `String path`  L25
- `String writeFile`  L26
- `File writeLogFile`  L27
- `FileOutputStream fileOutputStream = out`  L48
- `FileOutputStream fileOutputStream = out`  L69
- `FileOutputStream fileOutputStream = out`  L104
- `File file`  L115
- `String str`  L166
- `FileOutputStream fileOutputStream = out`  L185

方法（9）：
- `void closeWriteStream()`  L29
- `void d(String str, String str2)`  L37
    - 体内字面量："[" · "]:AppDebug:" · "\n"
- `void e(String str, String str2)`  L58
    - 体内字面量："[" · "]" · ": AppError:" · "\n"
- `void enableAppLog(Context context)`  L79
- `String getSystemDate()`  L89
    - 体内字面量："yyyy-MM-dd HH:mm:ss:sss\t"
- `void i(String str, String str2)`  L93
    - 体内字面量：" AppInfo:[" · "]" · "\n"
- `void initConfiguration()`  L114
- `void refreshAppLog()`  L165
- `void w(String str, String str2)`  L174
    - 体内字面量："[" · "]" · ": AppWarning:" · "\n"
### `com.icatch.golive.Log.SdkLog`
L13 · [class] public SdkLog · `com/icatch/golive/Log/SdkLog.java`

字段/常量（1）：
- `SdkLog sdkLog`  L14

方法（5）：
- `SdkLog getInstance()`  L16
- `void initCameraLog(String str)`  L23
- `void initPancamLog(String str)`  L34
- `void initUsbLog(String str)`  L49
- `void enableSDKLog(Context context)`  L56
    - 体内字面量："sdkLog" · "start enable sdklog path:" · "sdkLog" · "end enable sdklog"