# XTU GO — 类与成员明细：com.gku.base.permission

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 5 个文件 / 6 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.base.permission.CallbackPermission`
L13 · [class] public abstract CallbackPermission · `com/gku/base/permission/CallbackPermission.java`

字段/常量（2）：
- `Context context`  L14
- `Activity activity`  L35

方法（13）：
- `void onAuthorizeDialogCanceled()`  L16
- `void onAuthorizeDialogDismissed()`  L19
- `void onAuthorizeDialogGoTo()`  L22
- `void onPermissionHave()`  L25
- `void onPermissionRefuse()`  L27
- `public CallbackPermission(Context context)`  L30
- `void onPermissionNoAsk()`  L34
- `void onClick(DialogInterface dialogInterface, int i)`  L46 @Override
    - 体内字面量："android.settings.APPLICATION_DETAILS_SETTINGS"
- `void onClick(DialogInterface dialogInterface, int i)`  L55 @Override
- `void onDismiss(DialogInterface dialogInterface)`  L61 @Override
- `String getAuthorizeDialogButtonPositive()`  L67
- `String getAuthorizeDialogMessage()`  L71
- `String getAuthorizeDialogButtonNegative()`  L75
### `com.gku.base.permission.CallbackPermissionSimple`
L6 · [class] public abstract CallbackPermissionSimple · extends `CallbackPermission` · `com/gku/base/permission/CallbackPermissionSimple.java`

方法（3）：
- `void onPermissionHave()`  L8 @Override
- `void onPermissionRefuse()`  L11 @Override
- `public CallbackPermissionSimple(Context context)`  L14
### `com.gku.base.permission.PermissionActivity`
L16 · [class] public PermissionActivity · extends `AppCompatActivity` · `com/gku/base/permission/PermissionActivity.java`

字段/常量（4）：
- `int REQUEST_CODE_CTORAGE_11 = 100`  L17
- `int REQUEST_CODE_WRITE_SETTINGS = 101`  L18
- `TextView tv_toast`  L19
- `int i3 = iArr[i2]`  L77

方法（3）：
- `void onCreate(Bundle bundle)`  L22 @Override
    - 体内字面量："android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION" · "package:" · "android.settings.action.MANAGE_WRITE_SETTINGS" · "package:"
- `void onRequestPermissionsResult(int i, String[] strArr, int[] iArr)`  L72 @Override
- `void onActivityResult(int i, int i2, Intent intent)`  L102 @Override
### `com.gku.base.permission.PermissionManager`
L4 · [class] PermissionManager · `com/gku/base/permission/PermissionManager.java`

字段/常量（6）：
- `String ACTION_MANAGE_WRITE_SETTINGS = "ACTION_MANAGE_WRITE_SETTINGS"`  L5
- `String BUNDLE_KEY_PERMISSIONS = "bundle_key_permissions"`  L6
- `String INTENT_KEY_ASK = "intent_key_ask"`  L7
- `String INTENT_KEY_PERMISSIONS = "intent_key_permissions"`  L8
- `String STORAGE_11 = "STORAGE_11"`  L9
- `CallbackPermission callbackPermission`  L10

方法（4）：
- `private PermissionManager()`  L12
- `PermissionManager getInstance()`  L22
- `CallbackPermission getOnPermissionCallback()`  L26
- `void setOnPermissionCallback(CallbackPermission callbackPermission)`  L30
### `com.gku.base.permission.PermissionManager$PermissionManagerHolder`
L15 · [class] private static PermissionManagerHolder · `com/gku/base/permission/PermissionManager.java`

方法（1）：
- `private PermissionManagerHolder()`  L18
### `com.gku.base.permission.PermissionUtils`
L18 · [class] public PermissionUtils · `com/gku/base/permission/PermissionUtils.java`

字段/常量（2）：
- `String[] LOCATION_PERMISSIONS_BASIC = {com.gku.loginmodule.utils.PermissionUtils.LOCATION, "android.permission.ACCESS_COARSE_LOCATION"}`  L19
- `String[] strArr = LOCATION_PERMISSIONS_BASIC`  L103

方法（17）：
- `String getApplicationMeta(Context context, String str)`  L21
- `String getChannel(Context context)`  L34
    - 体内字面量："CHANNEL"
- `void showDialog(Context context, String str, DialogInterface.OnClickListener onClickListener)`  L38
- `void onClick(DialogInterface dialogInterface, int i)`  L41 @Override
- `void startRequestPermission(final Context context, String str, final Intent intent)`  L47
- `void onClick(DialogInterface dialogInterface, int i)`  L53 @Override
- `void requestPicSelect(Context context, CallbackPermission callbackPermission)`  L61
    - 体内字面量："android.permission.READ_EXTERNAL_STORAGE"
- `boolean isStoragePermission(String str)`  L69
    - 体内字面量："android.permission-group.STORAGE" · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.READ_EXTERNAL_STORAGE"
- `boolean haveLocationPermission(Context context)`  L73
- `String replaceWRITE_EXTERNAL_STORAGE(String str)`  L77
    - 体内字面量："android.permission.WRITE_EXTERNAL_STORAGE"
- `boolean havePermission(Context context, String str)`  L81
- `boolean havePermissions(Context context, String[] strArr)`  L89
- `boolean havePermissionExternalStorage(Context context)`  L98
    - 体内字面量："android.permission.WRITE_EXTERNAL_STORAGE"
- `void requestLocationPermission(Context context, String str, CallbackPermission callbackPermission)`  L102
- `void requestPermission(Context context, String str, String[] strArr, CallbackPermission callbackPermission)`  L123
    - 体内字面量："android.permission.WRITE_EXTERNAL_STORAGE" · "isExternalStorageManager" · "vivo" · "isExternalStorageManager 11111111" · "vivo"
- `void requestPermissionExternalStorage(Context context, String str, CallbackPermission callbackPermission)`  L161
    - 体内字面量："vivo" · "android.permission.WRITE_EXTERNAL_STORAGE"
- `void requestWRITE_SETTINGS(Context context, String str, CallbackPermission callbackPermission)`  L182
    - 体内字面量："vivo"