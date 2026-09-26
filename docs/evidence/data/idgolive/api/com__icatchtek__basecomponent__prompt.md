# idGoLive — 类与成员明细：com.icatchtek.basecomponent.prompt

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 5 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.basecomponent.prompt.AppDialog`
L12 · [class] public AppDialog · `com/icatchtek/basecomponent/prompt/AppDialog.java`

字段/常量（16）：
- `String TAG = "AppDialog"`  L13
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L42
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L52
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L75
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L85
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L105
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L115
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L138
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L148
- `OnDialogSureClickListener onDialogSureClickListener2 = onDialogSureClickListener`  L202
- `OnDialogSureClickListener onDialogSureClickListener2 = onDialogSureClickListener`  L240
- `OnDialogSureClickListener onDialogSureClickListener2 = onDialogSureClickListener`  L263
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L283
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L293
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L313
- `OnDialogButtonClickListener onDialogButtonClickListener2 = onDialogButtonClickListener`  L323

方法（36）：
- `void dismissDialog()`  L25
- `boolean isLiving(Activity activity)`  L28
- `void showDialogHint(Activity activity, int i, int i2, int i3, final OnDialogButtonClickListener onDialogButtonClickListener)`  L32
- `void onClick(DialogInterface dialogInterface, int i4)`  L40 @Override
- `void onClick(DialogInterface dialogInterface, int i4)`  L50 @Override
- `void showDialogHint(Activity activity, int i, final OnDialogButtonClickListener onDialogButtonClickListener)`  L65
- `void onClick(DialogInterface dialogInterface, int i2)`  L73 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L83 @Override
- `void showDialogHint(Activity activity, String str, final OnDialogButtonClickListener onDialogButtonClickListener)`  L95
- `void onClick(DialogInterface dialogInterface, int i)`  L103 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L113 @Override
- `void showDialogHint(Activity activity, String str, String str2, int i, int i2, final OnDialogButtonClickListener onDialogButtonClickListener)`  L125
- `void onClick(DialogInterface dialogInterface, int i3)`  L136 @Override
- `void onClick(DialogInterface dialogInterface, int i3)`  L146 @Override
- `void showDialogQuit(Activity activity, int i)`  L158
- `void onClick(DialogInterface dialogInterface, int i2)`  L166 @Override
- `void showDialogWarn(Activity activity, int i)`  L176
- `void onClick(DialogInterface dialogInterface, int i2)`  L184 @Override
- `void showDialogWarn(Activity activity, int i, final OnDialogSureClickListener onDialogSureClickListener)`  L192
- `void onClick(DialogInterface dialogInterface, int i2)`  L200 @Override
- `void showDialogWarn(Activity activity, String str)`  L212
- `void onClick(DialogInterface dialogInterface, int i)`  L220 @Override
- `void showDialogWarn(Activity activity, String str, final OnDialogSureClickListener onDialogSureClickListener)`  L230
- `void onClick(DialogInterface dialogInterface, int i)`  L238 @Override
- `void showDialogWarn(Activity activity, String str, String str2, final OnDialogSureClickListener onDialogSureClickListener)`  L250
- `void onClick(DialogInterface dialogInterface, int i)`  L261 @Override
- `void showDialogWarning(Activity activity, int i, final OnDialogButtonClickListener onDialogButtonClickListener)`  L273
- `void onClick(DialogInterface dialogInterface, int i2)`  L281 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L291 @Override
- `void showDialogWarning(Activity activity, String str, final OnDialogButtonClickListener onDialogButtonClickListener)`  L303
- `void onClick(DialogInterface dialogInterface, int i)`  L311 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L321 @Override
- `void showDisconnectDialog(final Activity activity, final String str)`  L333
- `void onClick(DialogInterface dialogInterface, int i)`  L342 @Override
    - 体内字面量："ExitApp because of " · "com.tinyai.bpscam.activity.MultiPreivewActivity" · "can not change to activity of MultiPreviewActivity"
- `void showSignInExpireDialog(final Activity activity, final String str)`  L359
- `void onClick(DialogInterface dialogInterface, int i)`  L368 @Override
    - 体内字面量："ExitApp because of " · "com.icatchtek.account.login.LoginActivity" · "can not change to activity of LoginActivity"
### `com.icatchtek.basecomponent.prompt.AppDialog$OnDialogButtonClickListener`
L15 · [interface] public OnDialogButtonClickListener · `com/icatchtek/basecomponent/prompt/AppDialog.java`

方法（2）：
- `void onCancel()`  L16
- `void onSure()`  L18
### `com.icatchtek.basecomponent.prompt.AppDialog$OnDialogSureClickListener`
L21 · [interface] public OnDialogSureClickListener · `com/icatchtek/basecomponent/prompt/AppDialog.java`

方法（1）：
- `void onSure()`  L22
### `com.icatchtek.basecomponent.prompt.CustomProgressDialog`
L11 · [class] public CustomProgressDialog · extends `ProgressDialog` · `com/icatchtek/basecomponent/prompt/CustomProgressDialog.java`

字段/常量（2）：
- `String text`  L12
- `String str`  L24

方法（5）：
- `public CustomProgressDialog(Context context)`  L14
- `public CustomProgressDialog(Context context, int i, String str)`  L18
- `void init(Context context)`  L23
- `void onCreate(Bundle bundle)`  L39 @Override
- `void show()`  L45 @Override
### `com.icatchtek.basecomponent.prompt.MyProgressDialog`
L9 · [class] public MyProgressDialog · `com/icatchtek/basecomponent/prompt/MyProgressDialog.java`

字段/常量（2）：
- `ProgressDialog mDialog`  L10
- `ProgressDialog progressDialog = mDialog`  L13

方法（7）：
- `void closeProgressDialog()`  L12
- `boolean isLiving(Activity activity)`  L25
- `void showProgressDialog(Activity activity)`  L29
- `void showProgressDialog(Activity activity, int i)`  L38
- `void showProgressDialog(Activity activity, String str)`  L47
- `void showProgressDialog(Context context, int i)`  L56
- `void showProgressDialogForFullsreen(Activity activity, int i)`  L68
### `com.icatchtek.basecomponent.prompt.MyToast`
L12 · [class] public MyToast · `com/icatchtek/basecomponent/prompt/MyToast.java`

字段/常量（4）：
- `Toast toast`  L13
- `Toast toast2 = toast`  L19
- `Toast toast2 = toast`  L34
- `Toast toast2 = toast`  L53

方法（4）：
- `void show(Context context, int i)`  L15
- `void show(Context context, int i, int i2)`  L30
- `void show(Context context, String str)`  L45
- `void show(Context context, String str, int i)`  L49
### `com.icatchtek.basecomponent.prompt.PercentageProgressDialog`
L12 · [class] public PercentageProgressDialog · extends `ProgressDialog` · `com/icatchtek/basecomponent/prompt/PercentageProgressDialog.java`

字段/常量（5）：
- `ImageProgressView imageProgressView`  L13
- `long maxValue`  L14
- `TextView percentageTxv`  L15
- `String text`  L16
- `String str`  L30

方法（7）：
- `public PercentageProgressDialog(Context context)`  L18
- `public PercentageProgressDialog(Context context, int i, String str)`  L23
- `void init(Context context)`  L29
- `void onCreate(Bundle bundle)`  L47 @Override
- `void setCurrentProgress(long j)`  L52
    - 体内字面量："%"
- `void setMaxProgress(long j)`  L61
- `void show()`  L67 @Override