# idGoLive — 类与成员明细：com.icatch.golive.Application

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.Application.BaseActivity`
L13 · [class] public abstract BaseActivity · extends `AppCompatActivity` · `com/icatch/golive/Application/BaseActivity.java`

方法（4）：
- `Context applyLanguage(Context context)`  L14
    - 体内字面量："_" · "th" · "TH"
- `void applyOverrideConfiguration(Configuration configuration)`  L38 @Override
    - 体内字面量："th" · "TH"
- `void attachBaseContext(Context context)`  L59 @Override
- `Resources getResources()`  L70 @Override
### `com.icatch.golive.Application.PanoramaApp`
L18 · [class] public PanoramaApp · extends `Application` · `com/icatch/golive/Application/PanoramaApp.java`

字段/常量（4）：
- `String TAG = "PanoramaApp"`  L19
- `PanoramaApp instance`  L20
- `Network wifiNetwork`  L21
- `String str`  L46

方法（10）：
- `PanoramaApp getContext()`  L23
- `void initAlbumSelectLoader()`  L27
- `void initBuglyCrash(Context context)`  L31
- `void attachBaseContext(Context context)`  L35 @Override
- `Network getWifiNetwork()`  L40
- `void onCreate()`  L45 @Override
- `void requestWifiNetwork()`  L64
    - 体内字面量："connectivity"
- `void onAvailable(Network network)`  L68 @Override
    - 体内字面量："NetworkCallback" · "onAvailable"
- `void onLost(Network network)`  L75 @Override
    - 体内字面量："NetworkCallback" · "onLost"
- `void onUnavailable()`  L82 @Override
    - 体内字面量："NetworkCallback" · "onUnavailable: WiFiç½ç»ä¸å¯ç¨"