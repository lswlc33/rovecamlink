# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.presentation.p010ui.common

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 3 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.presentation.p010ui.common.FlashActivity`
L19 · [class] public final FlashActivity · extends `BaseActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/common/FlashActivity.java`
注解：

字段/常量（2）：
- `ActivityFlashBinding binding`  L20
- `long time`  L21

方法（7）：
- `long getTime()`  L23
- `void setTime(long j)`  L27
- `View getContentRoot()`  L32 @Override
    - 体内字面量："inflate(...)" · "binding" · "getRoot(...)"
- `void onCreate(Bundle savedInstanceState)`  L46 @Override
- `void initData()`  L52
- `void run()`  L59 @Override
- `void initData$lambda$0(FlashActivity this$0)`  L66
    - 体内字面量："this$0"
### `com.tuwinsmart.tuwin.presentation.p010ui.common.WebViewActivity`
L22 · [class] public final WebViewActivity · extends `BaseActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/common/WebViewActivity.java`
注解：@Deprecated(message = "Use ExternalWebActivity")

字段/常量（3）：
- `String EXTRA_TITLE = "title"`  L26
- `String EXTRA_URL = "url"`  L27
- `String str = stringExtra`  L38

方法（2）：
- `View getContentRoot()`  L30 @Override
- `void onCreate(Bundle savedInstanceState)`  L35 @Override
    - 体内字面量："url"
### `com.tuwinsmart.tuwin.presentation.p010ui.common.WebViewActivity$Companion`
L49 · [class] public static final Companion · `com/tuwinsmart/tuwin/presentation/p010ui/common/WebViewActivity.java`
注解：

字段/常量（1）：
- `String str = url`  L64

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L50
- `private Companion()`  L54
- `void launchActivity(BaseActivity activity, String url)`  L57
    - 体内字面量："activity"
- `void launchActivity(BaseActivity activity, String url, String title)`  L62
    - 体内字面量："activity"