# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.base

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.base.CameraBaseActivity`
L27 · [class] public abstract CameraBaseActivity · extends `BaseActivity implements IStartView` · implements `IStartView` · `com/gku/actioncam/sigmastar/base/CameraBaseActivity.java`

字段/常量（10）：
- `String TAG = "BaseSSActivity"`  L28
- `boolean fullScreen = false`  L29
- `OrientationDetector mOrientationDetector`  L30
- `AlertDialog progressDialog`  L31
- `Toast toast`  L32
- `AlertDialog alertDialog`  L53
- `AlertDialog alertDialog = this.progressDialog`  L89
- `AlertDialog alertDialog = this.progressDialog`  L117
- `Toast toast = this.toast`  L179
- `Toast toast = this.toast`  L200

方法（24）：
- `void onProgressCancelListener(DialogInterface dialog)`  L34
- `void showProgressDialog()`  L36
- `void run()`  L45 @Override
- `void lambda$showProgressDialog$0()`  L52
- `void showProgressDialog(final int progress)`  L69
- `void run()`  L78 @Override
- `void lambda$showProgressDialog$1(int i)`  L85
- `void dismissProgressDialog()`  L102
- `void run()`  L105 @Override
- `void lambda$dismissProgressDialog$2()`  L112
- `void onCreate(Bundle savedInstanceState)`  L129 @Override
- `void backHomeNewActivity(String text)`  L139
- `String guessDeviceIP()`  L148
- `void onDestroy()`  L155 @Override
- `void disconnectDashCamera()`  L159
- `void showCenterToast(final String message)`  L168
- `void run()`  L171 @Override
- `void lambda$showCenterToast$3(String str)`  L178
- `void showCenterToast(final int resId)`  L189
- `void run()`  L192 @Override
- `void lambda$showCenterToast$4(int i)`  L199
- `int getScreenWidth()`  L210
- `int getScreenHeight()`  L216
- `void onWindowFocusChanged(boolean hasFocus)`  L223 @Override
### `com.gku.actioncam.sigmastar.base.CameraBaseActivity$$ExternalSyntheticLambda0`
L7 · [class] public final CameraBaseActivity$$ExternalSyntheticLambda0 · implements `DialogInterface.OnCancelListener` · `com/gku/actioncam/sigmastar/base/CameraBaseActivity$$ExternalSyntheticLambda0.java`

字段/常量（1）：
- `CameraBaseActivity f$0`  L8

方法（1）：
- `void onCancel(DialogInterface dialogInterface)`  L11 @Override