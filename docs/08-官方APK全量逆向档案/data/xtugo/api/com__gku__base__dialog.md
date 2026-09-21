# XTU GO — 类与成员明细：com.gku.base.dialog

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 5 个文件 / 8 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.base.dialog.CustomDialog`
L13 · [class] public final CustomDialog · extends `Dialog` · `com/gku/base/dialog/CustomDialog.java`
注解：

字段/常量（2）：
- `float dimAmount`  L14
- `boolean isSetTranslucentStatusBar`  L15

方法（6）：
- `public CustomDialog(Context context)`  L18
    - 体内字面量："context"
- `boolean getIsSetTranslucentStatusBar()`  L26
- `void setSetTranslucentStatusBar(boolean z)`  L30
- `float getDimAmount()`  L34
- `void setDimAmount(float f)`  L38
- `void show()`  L43 @Override
### `com.gku.base.dialog.DialogAsk`
L16 · [class] public final DialogAsk · extends `BaseDialog` · `com/gku/base/dialog/DialogAsk.java`
注解：

字段/常量（5）：
- `Callback callback`  L17
- `TextView tv_cancel`  L18
- `TextView tv_confirm`  L19
- `TextView tv_content`  L20
- `Callback callback = dialogAsk.callback`  L52

方法（6）：
- `public DialogAsk(ComponentActivity componentActivity)`  L29
    - 体内字面量："componentActivity"
- `void onClick(View view)`  L38 @Override
- `void onClick(View view)`  L44 @Override
- `void _init_$lambda$1(DialogAsk dialogAsk, View view)`  L51
- `DialogAsk setContent(String content)`  L59
    - 体内字面量："content"
- `DialogAsk setCallback(Callback callback)`  L65
    - 体内字面量："callback"
### `com.gku.base.dialog.DialogAsk$Callback`
L24 · [interface] public Callback · `com/gku/base/dialog/DialogAsk.java`
注解：

方法（1）：
- `void onConfirmed()`  L25
### `com.gku.base.dialog.DialogLoading`
L11 · [class] public DialogLoading · extends `BaseDialog` · `com/gku/base/dialog/DialogLoading.java`

方法（3）：
- `public DialogLoading(ComponentActivity componentActivity)`  L12
- `void onDismiss(DialogInterface dialogInterface)`  L18 @Override
- `void onShow(DialogInterface dialogInterface)`  L24 @Override
### `com.gku.base.dialog.DialogNotify`
L17 · [class] public final DialogNotify · extends `BaseDialog` · `com/gku/base/dialog/DialogNotify.java`
注解：

字段/常量（6）：
- `Callback callback`  L18
- `boolean showCancel`  L19
- `TextView tv_cancel`  L20
- `TextView tv_confirm`  L21
- `TextView tv_content`  L22
- `Callback callback = dialogNotify.callback`  L54

方法（9）：
- `public DialogNotify(ComponentActivity componentActivity)`  L31
    - 体内字面量："componentActivity"
- `void onClick(View view)`  L40 @Override
- `void onClick(View view)`  L46 @Override
- `void _init_$lambda$1(DialogNotify dialogNotify, View view)`  L53
- `DialogNotify setContent(String content)`  L61
    - 体内字面量："content"
- `DialogNotify setConfirmText(String text)`  L67
    - 体内字面量："text"
- `DialogNotify showCancel(boolean showCancel)`  L73
- `DialogNotify setCallback(Callback callback)`  L78
    - 体内字面量："callback"
- `void show()`  L85 @Override
### `com.gku.base.dialog.DialogNotify$Callback`
L26 · [interface] public Callback · `com/gku/base/dialog/DialogNotify.java`
注解：

方法（1）：
- `void onConfirmed()`  L27
### `com.gku.base.dialog.DialogRetry`
L18 · [class] public final DialogRetry · extends `BaseDialog` · `com/gku/base/dialog/DialogRetry.java`
注解：

字段/常量（7）：
- `Callback callback`  L19
- `FourCircleLoadingView fourCircleLoadingView`  L20
- `TextView tv_cancel`  L21
- `TextView tv_content`  L22
- `TextView tv_retry`  L23
- `Callback callback = dialogRetry.callback`  L72
- `Callback callback = dialogRetry.callback`  L82

方法（13）：
- `public DialogRetry(ComponentActivity componentActivity)`  L34
    - 体内字面量："componentActivity"
- `void onClick(View view)`  L46 @Override
- `void onClick(View view)`  L52 @Override
- `void onShow(DialogInterface dialogInterface)`  L58 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L64 @Override
- `void _init_$lambda$0(DialogRetry dialogRetry, View view)`  L71
- `void _init_$lambda$1(DialogRetry dialogRetry, View view)`  L80
- `void _init_$lambda$2(DialogRetry dialogRetry, DialogInterface dialogInterface)`  L91
- `void _init_$lambda$3(DialogRetry dialogRetry, DialogInterface dialogInterface)`  L96
- `void show()`  L101 @Override
- `DialogRetry doing(String content)`  L107
    - 体内字面量："content"
- `DialogRetry fail(String content)`  L113
    - 体内字面量："content"
- `DialogRetry setCallback(Callback callback)`  L122
    - 体内字面量："callback"
### `com.gku.base.dialog.DialogRetry$Callback`
L27 · [interface] public Callback · `com/gku/base/dialog/DialogRetry.java`
注解：

方法（2）：
- `void onCancel()`  L28
- `void onRetry()`  L30