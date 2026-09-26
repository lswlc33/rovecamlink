# XTU GO — 类与成员明细：com.gku.loginmodule.utils

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 10 个文件 / 10 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.utils.CameraInfoUtils`
L6 · [class] public CameraInfoUtils · `com/gku/loginmodule/utils/CameraInfoUtils.java`

字段/常量（2）：
- `String str = "S2"`  L69
- `String str2 = "S7"`  L96

方法（2）：
- `int getCameraImageByModel(String modelName)`  L7
    - 体内字面量："XTUS2" · "S2" · "XTUS5k" · "S5K" · "XTUX1" · "X1" · "XTUX2" · "XTUMax2" · "MAX2" · "XTUMaxPro" · "MAXPRO" · "XTUS3Pro" · "S3PRO" · "XTUS3" · "S3" · "XTUMAX3" · "MAX3" · "XTUS6" · "S6" · "XTUX3" · "X3" · "XTUS6Pro" · "S6PRO" · "XTUR1" · "XTUS7" · "S7" · "XTU S7PRO" · "S7PRO" · "XTU S7PRO MAX" · "S7PRO MAX" · "XTUMINI2PRO" · "MINI2PRO"
- `String getCameraModelByName(String modelName)`  L65
    - 体内字面量："XTU GO"
### `com.gku.loginmodule.utils.Constant`
L4 · [class] public Constant · `com/gku/loginmodule/utils/Constant.java`

字段/常量（26）：
- `int ACTIVITY_RESULT = 1`  L5
- `int CALLBACK_RESULT = 2`  L6
- `String IS_FORGET_PASSWORD_FRAGMENT = "isForgetPasswordFragment"`  L7
- `String IS_FORGET_PASSWORD_OPERATION_SUCCESS_FRAGMENT = "isForgetPasswordOperationSuccessFragment"`  L8
- `String IS_LOGIN = "isLogin"`  L9
- `String IS_LOGIN_FRAGMENT = "isLoginFragment"`  L10
- `String IS_LOGOUT_ACCOUNT_FRAGMENT = "isLogoutAccountFragment"`  L11
- `String IS_OPERATION_FAILED_FRAGMENT = "isOperationFailedFragment"`  L12
- `String IS_OPERATION_SUCCESS_FRAGMENT = "isOperationSuccessFragment"`  L13
- `String IS_REGISTER_FRAGMENT = "isRegisterFragment"`  L14
- `String IS_REPORT_FEEDBACK_FRAGMENT = "isReportFeedbackFragment"`  L15
- `String IS_SHOW_RED_POINT = "isShowRedPoint"`  L16
- `String IS_SHOW_VISITOR_LOGIN = "isShowVisitorLogin"`  L17
- `String IS_TECH_SUPPORT_FRAGMENT_OR_NOT = "isTechSupportFragment"`  L18
- `String IS_TODAY_REQUEST = "isTodayRequest"`  L19
- `String IS_TODAY_REQUEST_WALLPAPER = "isTodayRequestWallPaper"`  L20
- `String IS_USER_CENTER_INTRODUCE = "isUserCenterIntroduce"`  L21
- `String IS_USER_CENTER_PRODUCT_IMPROVE = "isUserCenterProductImprove"`  L22
- `String IS_USER_CENTER_TECH_SUPPORT = "isUserCenterTechSupport"`  L23
- `String IS_USER_INFO_FRAGMENT_OR_NOT = "isUserInfoFragment"`  L24
- `int LAUNCHER_RESULT = 3`  L25
- `String PROBLEM_CONTENT = "problemContent"`  L26
- `String REQUEST_TIMESTAMP = "requestTimestamp"`  L27
- `String REQUEST_TIMESTAMP_WALLPAPER = "wallpaperRequestTimestamp"`  L28
- `String TAG_EXPLAIN_VIEW = "TAG_EXPLAIN_VIEW"`  L29
- `String WHICH_FRAGMENT = "whichFragment"`  L30
### `com.gku.loginmodule.utils.MVUtils`
L15 · [class] public MVUtils · `com/gku/loginmodule/utils/MVUtils.java`
注解：@Module

字段/常量（1）：
- `MMKV mmkv`  L16

方法（22）：
- `MVUtils getMVUtils(Context context)`  L20 @Provides @Singleton
- `void put(String key, Object object)`  L26
- `void putSet(String key, Set<String> sets)`  L56
- `void putParcelable(String key, Parcelable obj)`  L60
- `Integer getInt(String key)`  L64
- `Integer getInt(String key, int defaultValue)`  L68
- `Double getDouble(String key)`  L72
- `Double getDouble(String key, double defaultValue)`  L76
- `Long getLong(String key)`  L80
- `Long getLong(String key, long defaultValue)`  L84
- `Boolean getBoolean(String key)`  L88
- `Boolean getBoolean(String key, boolean defaultValue)`  L92
- `Float getFloat(String key)`  L96
- `Float getFloat(String key, float defaultValue)`  L100
- `byte[] getBytes(String key)`  L104
- `byte[] getBytes(String key, byte[] defaultValue)`  L108
- `String getString(String key)`  L112
- `String getString(String key, String defaultValue)`  L116
- `Set<String> getStringSet(String key)`  L120
- `Parcelable getParcelable(String key)`  L124
- `void removeKey(String key)`  L128
- `void clearAll()`  L132
### `com.gku.loginmodule.utils.MVUtils_GetMVUtilsFactory`
L9 · [class] public final MVUtils_GetMVUtilsFactory · implements `Factory<MVUtils>` · `com/gku/loginmodule/utils/MVUtils_GetMVUtilsFactory.java`

字段/常量（2）：
- `Provider<Context> contextProvider`  L10
- `MVUtils module`  L11

方法（4）：
- `public MVUtils_GetMVUtilsFactory(MVUtils module, Provider<Context> contextProvider)`  L13
- `MVUtils get()`  L19 @Override
- `MVUtils_GetMVUtilsFactory create(MVUtils module, Provider<Context> contextProvider)`  L23
- `MVUtils getMVUtils(MVUtils instance, Context context)`  L27
### `com.gku.loginmodule.utils.MVUtilsEntryPoint`
L4 · [interface] public MVUtilsEntryPoint · `com/gku/loginmodule/utils/MVUtilsEntryPoint.java`

方法（1）：
- `MVUtils getMVUtils()`  L5
### `com.gku.loginmodule.utils.NetworkUtils`
L8 · [class] public NetworkUtils · `com/gku/loginmodule/utils/NetworkUtils.java`

方法（4）：
- `void registerNetworkStatusListener(Context context, final ConnectivityManager.NetworkCallback networkCallback)`  L9
- `void unregisterNetworkStatusListener(Context context, ConnectivityManager.NetworkCallback callback)`  L12
    - 体内字面量："connectivity"
- `boolean isConnectedToInternet(Context context)`  L16
    - 体内字面量："connectivity"
- `boolean isConnectedToInternetWithPing()`  L21
    - 体内字面量："/system/bin/ping -c 1 8.8.8.8"
### `com.gku.loginmodule.utils.OtherUtils`
L16 · [class] public OtherUtils · `com/gku/loginmodule/utils/OtherUtils.java`

字段/常量（1）：
- `Activity activity = mActivity`  L45

方法（4）：
- `void showWeiXinIsExistDialog(final Activity mActivity)`  L17
- `void onClick(View v)`  L27 @Override
- `void onClick(View v)`  L33 @Override
    - 体内字面量："com.tencent.mm" · "com.tencent.mm.ui.LauncherUI" · "android.intent.action.MAIN" · "android.intent.category.LAUNCHER"
- `boolean isWeiXinAvailable(Context context)`  L53
    - 体内字面量："com.tencent.mm"
### `com.gku.loginmodule.utils.PermissionUtils`
L19 · [class] public PermissionUtils · `com/gku/loginmodule/utils/PermissionUtils.java`

字段/常量（11）：
- `String CAMERA = "android.permission.CAMERA"`  L20
- `String LOCATION = "android.permission.ACCESS_FINE_LOCATION"`  L21
- `String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE"`  L22
- `int REQUEST_CAMERA_CODE = 1002`  L23
- `int REQUEST_LOCATION_CODE = 1003`  L24
- `int REQUEST_MANAGE_EXTERNAL_STORAGE_CODE = 1000`  L25
- `int REQUEST_STORAGE_CODE = 1001`  L26
- `String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE"`  L27
- `PermissionUtils mInstance`  L28
- `List arrayList`  L57
- `List arrayList`  L82

方法（10）：
- `boolean isManageExternalStoragePermissionGranted(Activity activity)`  L30
- `PermissionUtils getInstance()`  L34
- `boolean hasPermission(Activity activity, String permission)`  L45
    - 体内字面量："123->" · "hasPermission " · "r=" · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.READ_EXTERNAL_STORAGE" · "123->" · "hasPermission status2="
- `void saveDeniedPermission(Activity activity, List<String> permissions)`  L56
- `boolean hasDeniedPermission(Activity activity, String... permissions)`  L81
- `boolean hasSelfPermissions(Activity activity, String... permissions)`  L99
- `void goToSystemPermissionUi(Activity activity)`  L108
    - 体内字面量："android.settings.APPLICATION_DETAILS_SETTINGS"
- `void requestManageExternalStoragePermission(Activity activity)`  L116
    - 体内字面量："android.settings.REQUEST_MANAGE_MEDIA"
- `int getPermissionRequestCode(String permissionName)`  L126
    - 体内字面量："android.permission.ACCESS_FINE_LOCATION" · "android.permission.READ_EXTERNAL_STORAGE" · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.CAMERA"
- `void requestPermission(Activity activity, String permission)`  L141
### `com.gku.loginmodule.utils.RequestUtils`
L15 · [class] public RequestUtils · `com/gku/loginmodule/utils/RequestUtils.java`

方法（4）：
- `Map<String, RequestBody> generateRequestBody(Map<String, String> requestDataMap)`  L16
- `RequestBody generateJsonBody(Map<String, Object> requestDataMap)`  L24
    - 体内字面量："application/json; charset=utf-8"
- `RequestBody generateRequestBody(File file)`  L28
    - 体内字面量："application/octet-stream"
- `boolean isZipFile(File file)`  L32
### `com.gku.loginmodule.utils.ZipUtils`
L17 · [class] public ZipUtils · `com/gku/loginmodule/utils/ZipUtils.java`

字段/常量（2）：
- `byte[] bArr = new byte[1024]`  L37
- `byte[] bArr = new byte[4096]`  L103

方法（5）：
- `void zipFile(String srcPath, String destPathAndName)`  L18
    - 体内字面量："File not found: "
- `void zipSingleFile(File file, String parentPath, ZipOutputStream zos)`  L34
- `void zipDirectory(File dir, String parentPath, ZipOutputStream zos)`  L50
    - 体内字面量："/" · "/"
- `List<String> unzip(String zipFilePath, String destDirectory)`  L64
    - 体内字面量："ZipFw  entry=" · ".zip"
- `void extractFile(ZipInputStream zipIn, String filePath)`  L101