# XTU GO — 类与成员明细：com.gku.loginmodule.ui

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 78 个文件 / 103 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.ui.activity.AnnouncementLatestActivity`
L27 · [class] public AnnouncementLatestActivity · extends `Hilt_AnnouncementLatestActivity` · `com/gku/loginmodule/ui/activity/AnnouncementLatestActivity.java`

字段/常量（5）：
- `String TAG = "AmLatestActivity"`  L28
- `AnnouncementAdapter mAdapter`  L29
- `ActivityAnnouncementLatestBinding mBinding`  L30
- `AnnouncementLatestViewModel mViewModel`  L33
- `AnnouncementLatestActivity announcementLatestActivity = AnnouncementLatestActivity.this`  L84

方法（12）：
- `void start(Context context)`  L35
- `void onCreate(Bundle savedInstanceState)`  L40 @Override
- `boolean onOptionsItemSelected(MenuItem item)`  L50 @Override
- `void initView()`  L58
- `boolean canScrollHorizontally()`  L66 @Override
- `boolean canScrollVertically()`  L71 @Override
- `void onItemClick(int position)`  L79 @Override
- `void onChanged(Object obj)`  L93 @Override
- `void lambda$initView$1(List list)`  L100
- `int compare(Object obj, Object obj2)`  L118 @Override
- `void run()`  L131 @Override
- `int lambda$initView$0(Map.Entry entry, Map.Entry entry2)`  L137
### `com.gku.loginmodule.ui.activity.AnnouncementLatestActivity_GeneratedInjector`
L4 · [interface] public AnnouncementLatestActivity_GeneratedInjector · `com/gku/loginmodule/ui/activity/AnnouncementLatestActivity_GeneratedInjector.java`

方法（1）：
- `void injectAnnouncementLatestActivity(AnnouncementLatestActivity announcementLatestActivity)`  L5
### `com.gku.loginmodule.ui.activity.BaseActivity`
L23 · [class] public BaseActivity · extends `AppCompatActivity` · `com/gku/loginmodule/ui/activity/BaseActivity.java`

字段/常量（9）：
- `int SELECT_PHOTO_CODE = 2000`  L24
- `String TAG = "BaseActivity"`  L25
- `int TAKE_PHOTO_CODE = 2001`  L26
- `AppCompatActivity context`  L27
- `DialogLoading dialogLoading`  L28
- `boolean isConnectedANetwork = false`  L29
- `LoadingDialog loadingDialog`  L30
- `LoadingDialog loadingDialog = this.loadingDialog`  L59
- `LoadingDialog loadingDialog = this.loadingDialog`  L140

方法（28）：
- `boolean isAndroid6()`  L32
- `void requestPermission(String permissionName)`  L36
- `void onCreate(Bundle savedInstanceState)`  L40 @Override
- `DialogLoading getDialogLoading()`  L49
- `void onDestroy()`  L57 @Override
- `void showToast(String message)`  L65
- `void showToast(int resId)`  L69
- `void showMsg(CharSequence msg)`  L73
- `void jumpActivity(final Class<?> clazz)`  L77
- `void jumpActivityFinish(final Class<?> clazz)`  L81
- `void lambda$back$0(View view)`  L87
- `void back(Toolbar toolbar)`  L91
- `void onClick(View view)`  L94 @Override
- `void lambda$backAndFinish$1(View view)`  L101
- `void backAndFinish(Toolbar toolbar)`  L105
- `void onClick(View view)`  L108 @Override
- `void setStatusBar(boolean dark)`  L114
- `void exitTheProgram()`  L123
- `void showLoading()`  L127
- `void showLoading(boolean isClose)`  L133
- `void dismissLoading()`  L139
- `boolean isAndroid11()`  L146
- `boolean isAndroid10()`  L150
- `boolean isAndroid7()`  L154
- `boolean isStorageManager()`  L158
- `boolean hasPermission(String permissionName)`  L165
- `void requestManageExternalStorage(ActivityResultLauncher<Intent> intentActivityResultLauncher)`  L169
    - 体内字面量："android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION" · "package:"
- `boolean isNight()`  L175
    - 体内字面量："uimode"
### `com.gku.loginmodule.ui.activity.DeviceManagerActivity`
L38 · [class] public final DeviceManagerActivity · extends `BaseBdingActivity<ActivityDeviceManagerBinding> implements DeviceVersionManager.OnDownloadStatusListener` · implements `DeviceVersionManager.OnDownloadStatusListener` · `com/gku/loginmodule/ui/activity/DeviceManagerActivity.java`
注解：

字段/常量（48）：
- `DeviceManagerAdapter deviceManagerAdapter`  L39
- `boolean isAutoUpdate`  L40
- `boolean isCheckAll`  L41
- `boolean isManagerMode`  L42
- `DeviceInfoViewModel mViewModel`  L43
- `ActivityResultLauncher<Intent> startUpgradeLaunch`  L44
- `RecyclerView recyclerView = activityDeviceManagerBinding.recyclerView`  L83
- `DeviceManagerAdapter deviceManagerAdapter = this.deviceManagerAdapter`  L124
- `ArrayList arrayList`  L129
- `boolean z = true`  L131
- `DeviceManagerAdapter deviceManagerAdapter2 = this.this$0.deviceManagerAdapter`  L133
- `DeviceManagerAdapter deviceManagerAdapter3 = this.this$0.deviceManagerAdapter`  L137
- `String str = region`  L174
- `ArrayList arrayList`  L210
- `boolean z = !deviceManagerActivity.isManagerMode`  L211
- `DeviceManagerAdapter deviceManagerAdapter = deviceManagerActivity.deviceManagerAdapter`  L213
- `DeviceManagerAdapter deviceManagerAdapter2 = deviceManagerActivity.deviceManagerAdapter`  L231
- `DeviceManagerAdapter deviceManagerAdapter3 = deviceManagerActivity.deviceManagerAdapter`  L249
- `ArrayList arrayList`  L263
- `boolean z = deviceManagerActivity.isCheckAll`  L264
- `DeviceManagerAdapter deviceManagerAdapter = deviceManagerActivity.deviceManagerAdapter`  L271
- `DeviceManagerAdapter deviceManagerAdapter2 = deviceManagerActivity.deviceManagerAdapter`  L279
- `List<DeviceVersionInfo> arrayList`  L287
- `MutableLiveData<String> mutableLiveData`  L288
- `DeviceManagerAdapter deviceManagerAdapter = deviceManagerActivity.deviceManagerAdapter`  L291
- `DeviceInfoViewModel deviceInfoViewModel = deviceManagerActivity.mViewModel`  L345
- `DeviceInfoViewModel deviceInfoViewModel2 = deviceManagerActivity.mViewModel`  L349
- `MutableLiveData<List<DeviceVersionInfo>> mutableLiveData`  L390
- `DeviceInfoViewModel deviceInfoViewModel = this.mViewModel`  L391
- `DeviceInfoViewModel deviceInfoViewModel2 = this.mViewModel`  L395
- `List list2 = list`  L411
- `DeviceManagerAdapter deviceManagerAdapter = deviceManagerActivity.deviceManagerAdapter`  L421
- `DeviceManagerAdapter deviceManagerAdapter = this.deviceManagerAdapter`  L437
- `ArrayList arrayList`  L445
- `DeviceManagerAdapter deviceManagerAdapter`  L446
- `DeviceManagerAdapter deviceManagerAdapter2 = this.deviceManagerAdapter`  L448
- `int i = 0`  L452
- `int i2 = i + 1`  L454
- `ArrayList arrayList`  L467
- `DeviceManagerAdapter deviceManagerAdapter = this.deviceManagerAdapter`  L469
- `int i = 0`  L473
- `int i2 = i + 1`  L475
- `DeviceManagerAdapter deviceManagerAdapter2 = this.deviceManagerAdapter`  L482
- `ArrayList arrayList`  L493
- `DeviceManagerAdapter deviceManagerAdapter = this.deviceManagerAdapter`  L495
- `int i = 0`  L499
- `int i2 = i + 1`  L501
- `DeviceManagerAdapter deviceManagerAdapter2 = this.deviceManagerAdapter`  L508

方法（33）：
- `void onDownloadPause(String model)`  L47 @Override
    - 体内字面量："model"
- `void onDownloadStart(String model)`  L52 @Override
    - 体内字面量："model"
- `public DeviceManagerActivity()`  L56
- `void onActivityResult(Object obj)`  L59 @Override
    - 体内字面量："registerForActivityResult(...)"
- `ActivityResultLauncher<Intent> getStartUpgradeLaunch()`  L67
- `int getLayoutId()`  L72 @Override
- `void initView(Bundle saveInstanceState)`  L77 @Override
- `void initListener()`  L92 @Override
- `void onClick(View view)`  L96 @Override
- `void onClick(View view)`  L102 @Override
- `void onCheckedChanged(SimpleSwitchButton simpleSwitchButton, boolean z, boolean z2)`  L108 @Override
- `void onClick(View view)`  L114 @Override
- `void onClick(View view)`  L120 @Override
- `void onItemSelect(DeviceVersionInfo bean, int position)`  L128 @Override
- `void onStartDownload(DeviceVersionInfo bean)`  L157 @Override
    - 体内字面量："bean"
- `void onStartUpgrade(DeviceVersionInfo bean)`  L166 @Override
    - 体内字面量："bean" · "G"
- `void onClick(View view)`  L202 @Override
- `void initListener$lambda$10$lambda$4(DeviceManagerActivity deviceManagerActivity, ActivityDeviceManagerBinding activityDeviceManagerBinding, View view)`  L209
- `void initListener$lambda$10$lambda$5(DeviceManagerActivity deviceManagerActivity, SimpleSwitchButton simpleSwitchButton, boolean z, boolean z2)`  L256
- `void initListener$lambda$10$lambda$6(DeviceManagerActivity deviceManagerActivity, ActivityDeviceManagerBinding activityDeviceManagerBinding, View view)`  L262
- `void initListener$lambda$10$lambda$8(final DeviceManagerActivity deviceManagerActivity, View view)`  L286
- `Object invoke(Object obj)`  L355 @Override
- `Unit initListener$lambda$10$lambda$8$lambda$7(DeviceManagerActivity deviceManagerActivity, String str)`  L362
- `void initListener$lambda$10$lambda$9(View view)`  L372
- `boolean isContainer(String model, ArrayList<DeviceVersionInfo> datas)`  L376
    - 体内字面量："iterator(...)"
- `void loadData()`  L389 @Override
- `Object invoke(Object obj)`  L401 @Override
- `Unit loadData$lambda$12(DeviceManagerActivity deviceManagerActivity, List list)`  L408
- `void onDestroy()`  L429 @Override
- `void onCheckFinished()`  L436 @Override
- `void onDownloadEnd(String model)`  L444 @Override
- `void onDownloadFailed(String model)`  L466 @Override
- `void onDownloadProgress(String model, long current, long total)`  L492 @Override
### `com.gku.loginmodule.ui.activity.DeviceManagerActivity$sam$androidx_lifecycle_Observer$0`
L13 · [class] final DeviceManagerActivity$sam$androidx_lifecycle_Observer$0 · implements `Observer, FunctionAdapter` · `com/gku/loginmodule/ui/activity/DeviceManagerActivity$sam$androidx_lifecycle_Observer$0.java`
注解：

字段/常量（1）：
- `Function1 function`  L14

方法（4）：
- `boolean equals(Object obj)`  L21
- `Function<?> getFunctionDelegate()`  L29 @Override
- `int hashCode()`  L33
- `void onChanged(Object obj)`  L38 @Override
### `com.gku.loginmodule.ui.activity.DeviceUpgradeActivity`
L42 · [class] public DeviceUpgradeActivity · extends `BaseXtuGoActivity implements DeviceConnectManager.OnDeviceConnectListener` · implements `DeviceConnectManager.OnDeviceConnectListener` · `com/gku/loginmodule/ui/activity/DeviceUpgradeActivity.java`

字段/常量（50）：
- `String ARGUMENT_DATA = "ARGUMENT_DATA"`  L43
- `String ARGUMENT_FILE_PATH = "ARGUMENT_FILE_PATH"`  L44
- `String ARGUMENT_NEW_VERSION = "ARGUMENT_NEW_VERSION"`  L45
- `String ARGUMENT_UPDATE_INFO = "ARGUMENT_UPDATE_INFO"`  L46
- `DeviceVersionInfo deviceVersionInfo`  L47
- `String filePath`  L48
- `ImageView ivBack`  L49
- `RelativeLayout layoutButton`  L50
- `DeviceUpgradeViewModel mViewModel`  L51
- `String modelName`  L52
- `String newVersion`  L53
- `CustomRoundProgress progress`  L54
- `List<GetDeviceNewestVersionResponse.DataBean.GetDeviceNewestVersionBean.GetDeviceNewestVersionNote> releaseNotes`  L55
- `Socket socket`  L56
- `TextView tvButton`  L57
- `TextView tvContent`  L58
- `TextView tvDeviceName`  L59
- `TextView tvHint`  L60
- `TextViewShape tvNewVersion`  L61
- `TextViewShape tvOldVersion`  L62
- `int CODE_HISI_CREATESOCKET_FAIL = -100001`  L63
- `int CODE_HISI_WRITE_MSG_FAIL = -100002`  L64
- `int CODE_HISI_READ_FAIL = -100003`  L65
- `int CODE_HISI_RECV_MSG_FAIL = -100004`  L66
- `int CODE_HISI_SEND_SOFT_CANCEL = -100005`  L67
- `int CODE_HISI_CREATE_TCP_MSG_S_FAIL = -100006`  L68
- `int CODE_HISI_CREATE_WIRTE_DATA_FAIL = -100007`  L69
- `int CODE_HISI_CREATE_FILE_INPUT_STRAEM_FAIL = -100008`  L70
- `int CODE_HISI_CREATE_WIRTE_MD5_FAIL = -100009`  L71
- `int PROCESS_NONE = 0`  L72
- `int PROCESS_ERROR = 1`  L73
- `int PROCESS_TRANSFER = 2`  L74
- `int PROCESS_SUCCESS = 3`  L75
- `int processStatus = 0`  L76
- `Spanned spannedFromHtml`  L164
- `DeviceVersionInfo deviceVersionInfo = this.deviceVersionInfo`  L165
- `int i = this.processStatus`  L211
- `DeviceVersionInfo deviceVersionInfo = this.deviceVersionInfo`  L254
- `DeviceUpgradeActivity deviceUpgradeActivity = DeviceUpgradeActivity.this`  L279
- `int i`  L294
- `byte[] bArr = new byte[72]`  L310
- `byte[] bArr2 = new byte[65536]`  L331
- `int i3 = 10`  L332
- `byte[] bArr3 = new byte[10]`  L333
- `byte[] bArr4 = new byte[10]`  L334
- `boolean z = true`  L335
- `int i4 = 0`  L336
- `int i5 = 0`  L337
- `byte[] bArr5 = bArr3`  L362
- `long j = i4`  L363

方法（28）：
- `void onCreate(Bundle savedInstanceState)`  L79 @Override
    - 体内字面量："ARGUMENT_DATA"
- `void onResume()`  L98 @Override
- `void updateConnectStatus()`  L103
    - 体内字面量："xs, " · " IsConnectCamera = " · " cameraInfo = " · "xs, " · "xs, " · " deviceName = " · ", showModel = "
- `void onDestroy()`  L146 @Override
- `void initView()`  L151
- `void initData()`  L163
- `void initListener()`  L185
- `void onClick(View view)`  L188 @Override
- `void onClick(View view)`  L194 @Override
- `void lambda$initListener$0(View view)`  L201
- `void lambda$initListener$1(View view)`  L210
- `void showTransferHint()`  L227
- `void showErrorHint(final String hint)`  L234
- `void run()`  L238 @Override
- `void startUpload()`  L253
- `void onRefreshSpeed(long bytesPerSecond)`  L261 @Override
- `void onSuccess()`  L265 @Override
- `void onProgress(long current, long contentLength, int percent)`  L270 @Override
    - 体内字面量："%"
- `void onFail(int code)`  L277 @Override
    - 体内字面量："\n" · ":"
- `void onInterrupted()`  L286 @Override
    - 体内字面量："\n" · ":-100005"
- `Integer runThread()`  L293 @Override
- `void run()`  L367 @Override
    - 体内字面量："%" · "sendRtmp2Hisi write data" · "\n" · ":-100007" · "sendRtmp2Hisi write data" · "last 10 bytes: " · "sendRtmp2Hisi FileInputStream" · "\n" · ":-100008" · "sendRtmp2Hisi md5" · "\n" · ":-100009" · "\n" · ":-100004" · "\n" · ":-100006" · "\n" · ":-100003" · "\n" · ":-100002" · "\n" · ":-100001"
- `void run_UIThread(Integer code)`  L422 @Override
    - 体内字面量："\n" · ":"
- `int closeSocket(int ret)`  L434
- `String bytesToHex(byte[] bytes)`  L445
    - 体内字面量："%02X "
- `void dealSuccess()`  L454
- `void run()`  L457 @Override
- `void onDeviceConnecting(boolean isConnected)`  L470 @Override
### `com.gku.loginmodule.ui.activity.Hilt_AnnouncementLatestActivity`
L12 · [class] abstract Hilt_AnnouncementLatestActivity · extends `BaseActivity implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/activity/Hilt_AnnouncementLatestActivity.java`

字段/常量（2）：
- `ActivityComponentManager componentManager`  L13
- `boolean injected = false`  L15

方法（7）：
- `void _initHiltInternal()`  L21
- `void onContextAvailable(Context context)`  L24 @Override
- `Object generatedComponent()`  L31 @Override
- `ActivityComponentManager createComponentManager()`  L35
- `ActivityComponentManager componentManager()`  L40 @Override
- `void inject()`  L51
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L60 @Override
### `com.gku.loginmodule.ui.activity.Hilt_Login_Register_Activity`
L12 · [class] abstract Hilt_Login_Register_Activity · extends `BaseActivity implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/activity/Hilt_Login_Register_Activity.java`

字段/常量（2）：
- `ActivityComponentManager componentManager`  L13
- `boolean injected = false`  L15

方法（7）：
- `void _initHiltInternal()`  L21
- `void onContextAvailable(Context context)`  L24 @Override
- `Object generatedComponent()`  L31 @Override
- `ActivityComponentManager createComponentManager()`  L35
- `ActivityComponentManager componentManager()`  L40 @Override
- `void inject()`  L51
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L60 @Override
### `com.gku.loginmodule.ui.activity.Hilt_Report_Feedback_Activity`
L12 · [class] abstract Hilt_Report_Feedback_Activity · extends `BaseActivity implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/activity/Hilt_Report_Feedback_Activity.java`

字段/常量（2）：
- `ActivityComponentManager componentManager`  L13
- `boolean injected = false`  L15

方法（7）：
- `void _initHiltInternal()`  L21
- `void onContextAvailable(Context context)`  L24 @Override
- `Object generatedComponent()`  L31 @Override
- `ActivityComponentManager createComponentManager()`  L35
- `ActivityComponentManager componentManager()`  L40 @Override
- `void inject()`  L51
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L60 @Override
### `com.gku.loginmodule.ui.activity.Hilt_UserInfoActivity`
L12 · [class] abstract Hilt_UserInfoActivity · extends `BaseActivity implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/activity/Hilt_UserInfoActivity.java`

字段/常量（2）：
- `ActivityComponentManager componentManager`  L13
- `boolean injected = false`  L15

方法（7）：
- `void _initHiltInternal()`  L21
- `void onContextAvailable(Context context)`  L24 @Override
- `Object generatedComponent()`  L31 @Override
- `ActivityComponentManager createComponentManager()`  L35
- `ActivityComponentManager componentManager()`  L40 @Override
- `void inject()`  L51
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L60 @Override
### `com.gku.loginmodule.ui.activity.Hilt_WebViewActivity`
L12 · [class] abstract Hilt_WebViewActivity · extends `BaseActivity implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/activity/Hilt_WebViewActivity.java`

字段/常量（2）：
- `ActivityComponentManager componentManager`  L13
- `boolean injected = false`  L15

方法（7）：
- `void _initHiltInternal()`  L21
- `void onContextAvailable(Context context)`  L24 @Override
- `Object generatedComponent()`  L31 @Override
- `ActivityComponentManager createComponentManager()`  L35
- `ActivityComponentManager componentManager()`  L40 @Override
- `void inject()`  L51
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L60 @Override
### `com.gku.loginmodule.ui.activity.Login_Register_Activity`
L22 · [class] public Login_Register_Activity · extends `Hilt_Login_Register_Activity` · `com/gku/loginmodule/ui/activity/Login_Register_Activity.java`

字段/常量（4）：
- `ActivityLoginRegisterModuleBinding mBinding`  L23
- `LoginRegisterViewModel mViewModel`  L24
- `MVUtils mvUtils`  L27 @Inject
- `long timeMillis`  L28

方法（15）：
- `void onCreate(Bundle savedInstanceState)`  L31 @Override
- `void initView()`  L40
- `void onClick(View view)`  L48 @Override
- `void lambda$initView$0(View view)`  L58
- `void onResume()`  L63 @Override
- `void onStart()`  L68 @Override
- `void onPause()`  L73 @Override
- `void onStop()`  L78 @Override
- `void onDestroy()`  L83 @Override
- `void onRestart()`  L88 @Override
- `boolean onCreateOptionsMenu(Menu menu)`  L93 @Override
- `boolean onOptionsItemSelected(MenuItem item)`  L98 @Override
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L115 @Override
- `void switchFragment(int position)`  L131
- `void showOrHideTouristsEnter(boolean isShowTouristsEnter)`  L166
### `com.gku.loginmodule.ui.activity.Login_Register_Activity_GeneratedInjector`
L4 · [interface] public Login_Register_Activity_GeneratedInjector · `com/gku/loginmodule/ui/activity/Login_Register_Activity_GeneratedInjector.java`

方法（1）：
- `void injectLogin_Register_Activity(Login_Register_Activity login_Register_Activity)`  L5
### `com.gku.loginmodule.ui.activity.Login_Register_Activity_MembersInjector`
L8 · [class] public final Login_Register_Activity_MembersInjector · implements `MembersInjector<Login_Register_Activity>` · `com/gku/loginmodule/ui/activity/Login_Register_Activity_MembersInjector.java`

字段/常量（1）：
- `Provider<MVUtils> mvUtilsProvider`  L9

方法（4）：
- `public Login_Register_Activity_MembersInjector(Provider<MVUtils> mvUtilsProvider)`  L11
- `MembersInjector<Login_Register_Activity> create(Provider<MVUtils> mvUtilsProvider)`  L15
- `void injectMembers(Login_Register_Activity instance)`  L20 @Override
- `void injectMvUtils(Login_Register_Activity instance, MVUtils mvUtils)`  L24
### `com.gku.loginmodule.ui.activity.MSG_TYPE`
L4 · [enum] public MSG_TYPE · `com/gku/loginmodule/ui/activity/MSG_TYPE.java`

枚举常量（4）：
- `GET_FILE()`  L5
- `GET_FAILED()`  L6
- `RECV_FILE()`  L7
- `RECV_FAILED()`  L8
### `com.gku.loginmodule.ui.activity.Report_Feedback_Activity`
L19 · [class] public Report_Feedback_Activity · extends `Hilt_Report_Feedback_Activity` · `com/gku/loginmodule/ui/activity/Report_Feedback_Activity.java`

字段/常量（4）：
- `String TAG = "Report_Feedback_Activity"`  L20
- `ActivityReportFeedbackBinding mBinding`  L21
- `MVUtils mvUtils`  L24 @Inject
- `long timeMillis`  L25

方法（9）：
- `void onCreate(Bundle savedInstanceState)`  L28 @Override
    - 体内字面量："TAG" · "onCreateDDFSGGSGS: "
- `void initView()`  L35
- `boolean onOptionsItemSelected(MenuItem item)`  L49 @Override
- `void onClick(View view)`  L56 @Override
- `void lambda$onOptionsItemSelected$0(View view)`  L68
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L73 @Override
- `void onClick(View view)`  L80 @Override
- `void lambda$onKeyDown$1(View view)`  L92
- `void switchFragment(int position)`  L96
### `com.gku.loginmodule.ui.activity.Report_Feedback_Activity_GeneratedInjector`
L4 · [interface] public Report_Feedback_Activity_GeneratedInjector · `com/gku/loginmodule/ui/activity/Report_Feedback_Activity_GeneratedInjector.java`

方法（1）：
- `void injectReport_Feedback_Activity(Report_Feedback_Activity report_Feedback_Activity)`  L5
### `com.gku.loginmodule.ui.activity.Report_Feedback_Activity_MembersInjector`
L8 · [class] public final Report_Feedback_Activity_MembersInjector · implements `MembersInjector<Report_Feedback_Activity>` · `com/gku/loginmodule/ui/activity/Report_Feedback_Activity_MembersInjector.java`

字段/常量（1）：
- `Provider<MVUtils> mvUtilsProvider`  L9

方法（4）：
- `public Report_Feedback_Activity_MembersInjector(Provider<MVUtils> mvUtilsProvider)`  L11
- `MembersInjector<Report_Feedback_Activity> create(Provider<MVUtils> mvUtilsProvider)`  L15
- `void injectMembers(Report_Feedback_Activity instance)`  L20 @Override
- `void injectMvUtils(Report_Feedback_Activity instance, MVUtils mvUtils)`  L24
### `com.gku.loginmodule.ui.activity.TCP_MSG_S`
L7 · [class] public TCP_MSG_S · `com/gku/loginmodule/ui/activity/TCP_MSG_S.java`

字段/常量（3）：
- `int s32Cmd`  L8
- `int s32DataLen`  L9
- `byte[] szData`  L10

方法（3）：
- `public TCP_MSG_S()`  L12
- `public TCP_MSG_S(byte[] data)`  L16
- `byte[] toBytes()`  L25
### `com.gku.loginmodule.ui.activity.UserInfoActivity`
L18 · [class] public UserInfoActivity · extends `Hilt_UserInfoActivity` · `com/gku/loginmodule/ui/activity/UserInfoActivity.java`

字段/常量（3）：
- `ActivityUserInfoBinding mBinding`  L19
- `MVUtils mvUtils`  L22 @Inject
- `UserInfoViewModel userInfoViewModel`  L23

方法（13）：
- `void initView()`  L25
- `void onCreate(Bundle savedInstanceState)`  L29 @Override
- `void onResume()`  L41 @Override
- `void onStart()`  L46 @Override
- `void onPause()`  L51 @Override
- `void onStop()`  L56 @Override
- `void onDestroy()`  L61 @Override
- `void onRestart()`  L66 @Override
- `boolean onCreateOptionsMenu(Menu menu)`  L71 @Override
- `boolean onOptionsItemSelected(MenuItem item)`  L76 @Override
- `void onBackPressed()`  L88 @Override
- `void switchFragment(int position)`  L96
- `void signOut(boolean isJumpToLoginFragment)`  L128
### `com.gku.loginmodule.ui.activity.UserInfoActivity_GeneratedInjector`
L4 · [interface] public UserInfoActivity_GeneratedInjector · `com/gku/loginmodule/ui/activity/UserInfoActivity_GeneratedInjector.java`

方法（1）：
- `void injectUserInfoActivity(UserInfoActivity userInfoActivity)`  L5
### `com.gku.loginmodule.ui.activity.UserInfoActivity_MembersInjector`
L8 · [class] public final UserInfoActivity_MembersInjector · implements `MembersInjector<UserInfoActivity>` · `com/gku/loginmodule/ui/activity/UserInfoActivity_MembersInjector.java`

字段/常量（1）：
- `Provider<MVUtils> mvUtilsProvider`  L9

方法（4）：
- `public UserInfoActivity_MembersInjector(Provider<MVUtils> mvUtilsProvider)`  L11
- `MembersInjector<UserInfoActivity> create(Provider<MVUtils> mvUtilsProvider)`  L15
- `void injectMembers(UserInfoActivity instance)`  L20 @Override
- `void injectMvUtils(UserInfoActivity instance, MVUtils mvUtils)`  L24
### `com.gku.loginmodule.ui.activity.WebViewActivity`
L13 · [class] public WebViewActivity · extends `Hilt_WebViewActivity` · `com/gku/loginmodule/ui/activity/WebViewActivity.java`

字段/常量（5）：
- `String TAG = "WebViewActivity"`  L14
- `String[] info`  L15
- `ActivityWebBinding mBinding`  L16
- `String title`  L17
- `String url`  L18

方法（5）：
- `void start(Context context, String[] info)`  L20
    - 体内字面量："webView"
- `void onCreate(Bundle savedInstanceState)`  L27 @Override
- `boolean onOptionsItemSelected(MenuItem item)`  L34 @Override
- `void initView()`  L42
    - 体内字面量："webView"
- `void onBackPressed()`  L60 @Override
### `com.gku.loginmodule.ui.activity.WebViewActivity_GeneratedInjector`
L4 · [interface] public WebViewActivity_GeneratedInjector · `com/gku/loginmodule/ui/activity/WebViewActivity_GeneratedInjector.java`

方法（1）：
- `void injectWebViewActivity(WebViewActivity webViewActivity)`  L5
### `com.gku.loginmodule.ui.adapter.AnnouncementAdapter`
L23 · [class] public AnnouncementAdapter · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/loginmodule/ui/adapter/AnnouncementAdapter.java`

字段/常量（7）：
- `ArrayList<AnnouncementItem> itemList`  L24
- `Context mContext`  L25
- `OnItemClickListener mOnItemClickListener`  L26
- `int TYPE_TIME = 0`  L27
- `int TYPE_ITEM = 1`  L28
- `View viewInflate`  L53
- `ArrayList<AnnouncementItem> arrayList = this.itemList`  L100

方法（9）：
- `void setOnItemClickListener(OnItemClickListener mOnItemClickListener)`  L34
- `public AnnouncementAdapter(Context mContext, ArrayList<AnnouncementItem> itemList)`  L38
- `int getItemViewType(int position)`  L44 @Override
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L52 @Override
- `void onBindViewHolder(final MyViewHolder holder, final int position)`  L63 @Override
- `boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource)`  L70 @Override
- `boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource)`  L75 @Override
- `void onClick(View v)`  L83 @Override
- `int getItemCount()`  L99 @Override
### `com.gku.loginmodule.ui.adapter.AnnouncementAdapter$MyViewHolder`
L107 · [class] static MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/loginmodule/ui/adapter/AnnouncementAdapter.java`

字段/常量（5）：
- `TextView content`  L108
- `ImageView icon`  L109
- `TextView itemCreateTime`  L110
- `LinearLayout itemLayout`  L111
- `TextView title`  L112

方法（1）：
- `public MyViewHolder(View itemView)`  L114
### `com.gku.loginmodule.ui.adapter.AnnouncementAdapter$OnItemClickListener`
L30 · [interface] public OnItemClickListener · `com/gku/loginmodule/ui/adapter/AnnouncementAdapter.java`

方法（1）：
- `void onItemClick(int position)`  L31
### `com.gku.loginmodule.ui.adapter.DeviceManagerAdapter`
L21 · [class] public final DeviceManagerAdapter · extends `BaseQuickAdapter<DeviceVersionInfo, BaseDataBindingHolder<ItemDeviceManagerBinding>>` · `com/gku/loginmodule/ui/adapter/DeviceManagerAdapter.java`
注解：

字段/常量（6）：
- `OnDeviceManagerCallback callback`  L22
- `boolean isCheckMode`  L23
- `OnDeviceManagerCallback onDeviceManagerCallback = deviceManagerAdapter.callback`  L150
- `OnDeviceManagerCallback onDeviceManagerCallback = deviceManagerAdapter.callback`  L158
- `OnDeviceManagerCallback onDeviceManagerCallback = deviceManagerAdapter.callback`  L166
- `OnDeviceManagerCallback onDeviceManagerCallback = deviceManagerAdapter.callback`  L174

方法（12）：
- `public DeviceManagerAdapter()`  L35
- `void setMode(boolean mode)`  L39
- `void convert(BaseDataBindingHolder<ItemDeviceManagerBinding> holder, final DeviceVersionInfo item)`  L46 @Override
    - 体内字面量："holder" · "item" · "ï¼" · "ï¼" · "ï¼" · "getNewVersion(...)" · "getVersion(...)" · "ï¼" · "ï¼" · "ï¼" · "ï¼" · "ï¼" · "ï¼"
- `void onClick(View view)`  L123 @Override
- `void onClick(View view)`  L129 @Override
- `void onClick(View view)`  L135 @Override
- `void onClick(View view)`  L141 @Override
- `void convert$lambda$4$lambda$0(DeviceManagerAdapter deviceManagerAdapter, DeviceVersionInfo deviceVersionInfo, int i, View view)`  L149
- `void convert$lambda$4$lambda$1(DeviceManagerAdapter deviceManagerAdapter, DeviceVersionInfo deviceVersionInfo, View view)`  L157
- `void convert$lambda$4$lambda$2(DeviceManagerAdapter deviceManagerAdapter, DeviceVersionInfo deviceVersionInfo, View view)`  L165
- `void convert$lambda$4$lambda$3(DeviceManagerAdapter deviceManagerAdapter, DeviceVersionInfo deviceVersionInfo, View view)`  L173
- `void setOnDeviceManagerCallback(OnDeviceManagerCallback callback)`  L180
    - 体内字面量："callback"
### `com.gku.loginmodule.ui.adapter.DeviceManagerAdapter$OnDeviceManagerCallback`
L27 · [interface] public OnDeviceManagerCallback · `com/gku/loginmodule/ui/adapter/DeviceManagerAdapter.java`
注解：

方法（3）：
- `void onItemSelect(DeviceVersionInfo bean, int position)`  L28
- `void onStartDownload(DeviceVersionInfo bean)`  L30
- `void onStartUpgrade(DeviceVersionInfo bean)`  L32
### `com.gku.loginmodule.ui.adapter.ReportFeedBackAdapter`
L24 · [class] public ReportFeedBackAdapter · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/loginmodule/ui/adapter/ReportFeedBackAdapter.java`

字段/常量（6）：
- `ArrayList<ReportFeedBackItem> itemList`  L25
- `Context mContext`  L26
- `OnItemClickListener mOnItemClickListener`  L27
- `int selectMax = 9`  L28
- `OnItemClickListener onItemClickListener = this.mOnItemClickListener`  L127
- `ArrayList<ReportFeedBackItem> arrayList = this.itemList`  L135

方法（15）：
- `void setOnItemClickListener(OnItemClickListener mOnItemClickListener)`  L36
- `public ReportFeedBackAdapter(Context mContext, ArrayList<ReportFeedBackItem> itemList)`  L40
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L46 @Override
- `void onBindViewHolder(final MyViewHolder holder, int position)`  L51 @Override
- `boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource)`  L88 @Override
- `boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource)`  L93 @Override
- `void onClick(View view)`  L104 @Override
- `void onClick(View view)`  L110 @Override
- `void lambda$onBindViewHolder$0(MyViewHolder myViewHolder, View view)`  L118
- `void lambda$onBindViewHolder$1(MyViewHolder myViewHolder, View view)`  L125
- `int getItemCount()`  L134 @Override
- `void setSelectMax(int selectMax)`  L142
- `int getSelectMax()`  L146
- `ArrayList<ReportFeedBackItem> getData()`  L150
- `void remove(int position)`  L154
### `com.gku.loginmodule.ui.adapter.ReportFeedBackAdapter$MyViewHolder`
L160 · [class] static MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/loginmodule/ui/adapter/ReportFeedBackAdapter.java`

字段/常量（6）：
- `ImageView itemImageDelete`  L161
- `ImageView itemImageMedia`  L162
- `ImageView itemImagePlay`  L163
- `RelativeLayout itemLayout`  L164
- `TextView itemSizeDes`  L165
- `TextView itemVideoTime`  L166

方法（1）：
- `public MyViewHolder(View itemView)`  L168
### `com.gku.loginmodule.ui.adapter.ReportFeedBackAdapter$OnItemClickListener`
L30 · [interface] public OnItemClickListener · `com/gku/loginmodule/ui/adapter/ReportFeedBackAdapter.java`

方法（2）：
- `void onDeleteClick(int position)`  L31
- `void onMediaBackgroundClick(int position)`  L33
### `com.gku.loginmodule.ui.adapter.UserCenterNewAdapter`
L16 · [class] public UserCenterNewAdapter · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/loginmodule/ui/adapter/UserCenterNewAdapter.java`

字段/常量（9）：
- `int TYPE_GRID = 0`  L17
- `int TYPE_LINEAR = 1`  L18
- `MyViewHolder holder`  L19
- `ArrayList<UserCenterNewItem> itemList`  L20
- `Context mContext`  L21
- `OnItemClickListener mOnItemClickListener`  L22
- `View viewInflate`  L47
- `ArrayList<UserCenterNewItem> arrayList = this.itemList`  L77
- `MyViewHolder myViewHolder = this.holder`  L85

方法（8）：
- `void setOnItemClickListener(OnItemClickListener mOnItemClickListener)`  L28
- `public UserCenterNewAdapter(Context mContext, ArrayList<UserCenterNewItem> itemList)`  L32
- `int getItemViewType(int position)`  L38 @Override
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L46 @Override
- `void onBindViewHolder(final MyViewHolder holder, final int position)`  L57 @Override
- `void onClick(View v)`  L67 @Override
- `int getItemCount()`  L76 @Override
- `void setShowRedDot(boolean isVisible)`  L84
### `com.gku.loginmodule.ui.adapter.UserCenterNewAdapter$MyViewHolder`
L97 · [class] static MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/loginmodule/ui/adapter/UserCenterNewAdapter.java`

字段/常量（6）：
- `View itemBottomLine`  L98
- `ImageView itemImageIcon`  L99
- `ImageView itemImageNext`  L100
- `RelativeLayout itemLayout`  L101
- `TextView itemRedDot`  L102
- `TextView itemTextTitle`  L103

方法（1）：
- `public MyViewHolder(View itemView)`  L105
### `com.gku.loginmodule.ui.adapter.UserCenterNewAdapter$OnItemClickListener`
L24 · [interface] public OnItemClickListener · `com/gku/loginmodule/ui/adapter/UserCenterNewAdapter.java`

方法（1）：
- `void onItemClick(int position)`  L25
### `com.gku.loginmodule.ui.adapter.UserCenterNewTopAdapter`
L16 · [class] public UserCenterNewTopAdapter · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/loginmodule/ui/adapter/UserCenterNewTopAdapter.java`

字段/常量（7）：
- `MyViewHolder holder`  L17
- `ArrayList<UserCenterItem_1> itemList`  L18
- `Context mContext`  L19
- `OnItemClickListener mOnItemClickListener`  L20
- `OnItemClickListener onItemClickListener = this.mOnItemClickListener`  L55
- `ArrayList<UserCenterItem_1> arrayList = this.itemList`  L63
- `MyViewHolder myViewHolder = this.holder`  L71

方法（8）：
- `void setOnItemClickListener(OnItemClickListener mOnItemClickListener)`  L26
- `public UserCenterNewTopAdapter(Context mContext, ArrayList<UserCenterItem_1> itemList)`  L30
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L36 @Override
- `void onBindViewHolder(final MyViewHolder holder, final int position)`  L41 @Override
- `void onClick(View view)`  L47 @Override
- `void lambda$onBindViewHolder$0(int i, View view)`  L54
- `int getItemCount()`  L62 @Override
- `void setTextLeftVisible(boolean visible)`  L70
### `com.gku.loginmodule.ui.adapter.UserCenterNewTopAdapter$MyViewHolder`
L82 · [class] static MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/loginmodule/ui/adapter/UserCenterNewTopAdapter.java`

字段/常量（4）：
- `ImageView itemImageNext`  L83
- `RelativeLayout itemLayout`  L84
- `TextView itemTextLeft`  L85
- `TextView itemTextRight`  L86

方法（1）：
- `public MyViewHolder(View itemView)`  L88
### `com.gku.loginmodule.ui.adapter.UserCenterNewTopAdapter$OnItemClickListener`
L22 · [interface] public OnItemClickListener · `com/gku/loginmodule/ui/adapter/UserCenterNewTopAdapter.java`

方法（1）：
- `void onItemClick(int position)`  L23
### `com.gku.loginmodule.ui.adapter.UserInfoAdapter`
L16 · [class] public UserInfoAdapter · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/loginmodule/ui/adapter/UserInfoAdapter.java`

字段/常量（8）：
- `int TYPE_IMMUTABLE = 0`  L17
- `int TYPE_MUTABLE = 1`  L18
- `MyViewHolder holder`  L19
- `Context mContext`  L20
- `OnItemClickListener mOnItemClickListener`  L21
- `ArrayList<UserInfoItem> userInfoItemList`  L22
- `MyViewHolder myViewHolder = this.holder`  L77
- `ArrayList<UserInfoItem> arrayList = this.userInfoItemList`  L86

方法（8）：
- `void setOnItemClickListener(OnItemClickListener mOnItemClickListener)`  L28
- `public UserInfoAdapter(Context mContext, ArrayList<UserInfoItem> userInfoItemList)`  L32
- `int getItemViewType(int position)`  L38 @Override
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L46 @Override
- `void onBindViewHolder(final MyViewHolder holder, final int position)`  L51 @Override
- `void onClick(View v)`  L68 @Override
- `void setDeleteAccountRed()`  L76
- `int getItemCount()`  L85 @Override
### `com.gku.loginmodule.ui.adapter.UserInfoAdapter$MyViewHolder`
L93 · [class] static MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/loginmodule/ui/adapter/UserInfoAdapter.java`

字段/常量（5）：
- `View itemBottomLine`  L94
- `ImageView itemImageNext`  L95
- `LinearLayout itemLayout`  L96
- `TextView itemTextLeft`  L97
- `TextView itemTextRight`  L98

方法（1）：
- `public MyViewHolder(View itemView)`  L100
### `com.gku.loginmodule.ui.adapter.UserInfoAdapter$OnItemClickListener`
L24 · [interface] public OnItemClickListener · `com/gku/loginmodule/ui/adapter/UserInfoAdapter.java`

方法（1）：
- `void onItemClick(int position)`  L25
### `com.gku.loginmodule.ui.dialog.AlertController`
L12 · [class] public AlertController · `com/gku/loginmodule/ui/dialog/AlertController.java`

字段/常量（3）：
- `AlertDialog mAlertDialog`  L13
- `DialogViewHelper mViewHelper`  L14
- `Window mWindow`  L15

方法（8）：
- `public AlertController(AlertDialog alertDialog, Window window)`  L17
- `void setDialogViewHelper(DialogViewHelper dialogViewHelper)`  L22
- `void setText(int viewId, CharSequence text)`  L26
- `void setIcon(int viewId, int resId)`  L30
- `T getView(int i)`  L34
- `void setOnClickListener(int viewId, View.OnClickListener onClickListener)`  L38
- `AlertDialog getDialog()`  L42
- `Window getWindow()`  L46
### `com.gku.loginmodule.ui.dialog.AlertController$AlertParams`
L50 · [class] public static AlertParams · `com/gku/loginmodule/ui/dialog/AlertController.java`

字段/常量（15）：
- `int mAnimation`  L51
- `boolean mCancelable`  L52
- `Context mContext`  L53
- `int mHeight`  L54
- `int mHeightMargin`  L55
- `int mLayoutResId`  L56
- `DialogInterface.OnCancelListener mOnCancelListener`  L57
- `DialogInterface.OnDismissListener mOnDismissListener`  L58
- `DialogInterface.OnKeyListener mOnKeyListener`  L59
- `int mThemeResId`  L60
- `View mView`  L61
- `int mWidth`  L62
- `int mWidthMargin`  L63
- `int mGravity = 17`  L70
- `int i4 = this.mAnimation`  L99

方法（2）：
- `public AlertParams(Context context, int themeResId)`  L72
- `void apply(AlertController alert)`  L77
    - 体内字面量："please set layout"
### `com.gku.loginmodule.ui.dialog.AlertDialog`
L11 · [class] public AlertDialog · extends `Dialog` · `com/gku/loginmodule/ui/dialog/AlertDialog.java`

字段/常量（1）：
- `AlertController mAlert`  L12

方法（4）：
- `public AlertDialog(Context context, int themeResId)`  L14
- `void setText(int viewId, CharSequence text)`  L19
- `T getView(int i)`  L23
- `void setOnClickListener(int viewId, View.OnClickListener onClickListener)`  L27
### `com.gku.loginmodule.ui.dialog.AlertDialog$Builder`
L31 · [class] public static Builder · `com/gku/loginmodule/ui/dialog/AlertDialog.java`

字段/常量（1）：
- `AlertController.AlertParams P`  L32

方法（23）：
- `public Builder(Context context)`  L34
- `public Builder(Context context, int themeResId)`  L38
- `Builder setContentView(View view)`  L42
- `Builder setContentView(int layoutId)`  L48
- `Builder setText(int viewId, CharSequence text)`  L54
- `Builder setTextColor(int viewId, int color)`  L59
- `Builder setIcon(int iconId, int resId)`  L64
- `Builder setBitmap(int viewId, Bitmap bitmap)`  L69
- `Builder fullWidth()`  L74
- `Builder fromBottom(boolean isAnimation)`  L79
- `Builder fromRight(boolean isAnimation)`  L87
- `Builder setWidthAndHeight(int width, int heigth)`  L95
- `Builder setWidthAndHeightMargin(int width, int heigth, int heightMargin, int widthMargin)`  L101
- `Builder addDefaultAnimation()`  L109
- `Builder setAnimation(int styleAnimation)`  L114
- `Builder setOnClickListener(int viewId, View.OnClickListener onClickListener)`  L119
- `Builder setOnLongClickListener(int viewId, View.OnLongClickListener onLongClickListener)`  L124
- `Builder setCancelable(boolean cancelable)`  L129
- `Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener)`  L134
- `Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener)`  L139
- `Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener)`  L144
- `AlertDialog create()`  L149
- `AlertDialog show()`  L164
### `com.gku.loginmodule.ui.dialog.DialogViewHelper`
L13 · [class] public DialogViewHelper · `com/gku/loginmodule/ui/dialog/DialogViewHelper.java`

字段/常量（2）：
- `View mContentView`  L14
- `SparseArray<WeakReference<View>> mViews`  L15

方法（8）：
- `public DialogViewHelper(Context context, int layoutResId)`  L17
- `public DialogViewHelper()`  L22
- `void setText(int viewId, CharSequence text)`  L26
- `T getView(int i)`  L33
- `void setOnClickListener(int viewId, View.OnClickListener onClickListener)`  L42
- `void setIcon(int viewId, int resId)`  L49
- `void setContentView(View contentView)`  L56
- `View getContentView()`  L60
### `com.gku.loginmodule.ui.dialog.LoadingDialog`
L11 · [class] public LoadingDialog · extends `Dialog` · `com/gku/loginmodule/ui/dialog/LoadingDialog.java`

字段/常量（2）：
- `ImageView ivLoading`  L12
- `TextView tvLoadingTx`  L13

方法（6）：
- `public LoadingDialog(Context context)`  L15
- `public LoadingDialog(Context context, String string)`  L19
- `public LoadingDialog(Context context, boolean close)`  L23
- `protected LoadingDialog(Context context, int theme, String string)`  L27
- `protected LoadingDialog(Context context, int theme, String string, boolean isOtherOnClickClose)`  L40
- `void dismiss()`  L54 @Override
### `com.gku.loginmodule.ui.fragment.BaseFragment`
L20 · [class] public BaseFragment · extends `Fragment` · `com/gku/loginmodule/ui/fragment/BaseFragment.java`

字段/常量（4）：
- `Context context`  L21
- `LoadingDialog loadingDialog`  L22
- `AppCompatActivity mActivity`  L23
- `LoadingDialog loadingDialog = this.loadingDialog`  L66

方法（13）：
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L26 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L31 @Override
- `void onAttach(Context context)`  L36 @Override
- `void onDetach()`  L45 @Override
- `void showMsg(String msg)`  L51
- `void showLoading()`  L55
- `void showLoading(boolean isClose)`  L61
- `void dismissLoading()`  L65
- `boolean isNight()`  L72
    - 体内字面量："uimode"
- `boolean isValidEmail(String strEmail, boolean needShowMsg)`  L118
    - 体内字面量："^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$" · "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$"
- `boolean isValidPassword(String strPassword, boolean needShowMsg)`  L129
    - 体内字面量："^(?=.*[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]{8,20}$"
- `boolean isPhone(String number)`  L141
    - 体内字面量："[1][358]\\d{9}"
- `boolean isPhoneByDigitalAndLength(String number)`  L149
    - 体内字面量："^\\d{1,11}$"
### `com.gku.loginmodule.ui.fragment.BaseFragment$EmailFilter`
L103 · [class] protected EmailFilter · implements `InputFilter` · `com/gku/loginmodule/ui/fragment/BaseFragment.java`

字段/常量（1）：
- `BaseFragment baseFragment = BaseFragment.this`  L112

方法（2）：
- `protected EmailFilter()`  L104
- `CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend)`  L108 @Override
    - 体内字面量："^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$"
### `com.gku.loginmodule.ui.fragment.BaseFragment$PassWordFilter`
L76 · [class] protected PassWordFilter · implements `InputFilter` · `com/gku/loginmodule/ui/fragment/BaseFragment.java`

字段/常量（3）：
- `BaseFragment baseFragment = BaseFragment.this`  L84
- `BaseFragment baseFragment2 = BaseFragment.this`  L90
- `BaseFragment baseFragment3 = BaseFragment.this`  L97

方法（2）：
- `protected PassWordFilter()`  L77
- `CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend)`  L81 @Override
    - 体内字面量："[a-zA-Z0-9]+"
### `com.gku.loginmodule.ui.fragment.DeleteAccountFragment`
L23 · [class] public DeleteAccountFragment · extends `Hilt_DeleteAccountFragment` · `com/gku/loginmodule/ui/fragment/DeleteAccountFragment.java`

字段/常量（9）：
- `String TAG = "DeleteAccountFragment"`  L24
- `String inputEmail`  L25
- `String inputPwd`  L26
- `boolean isClickVerifyCodeBtn = false`  L27
- `UserInfoActivity mActivity`  L28
- `FragmentDeleteAccountBinding mBinding`  L29
- `CountDownTimer mCountdownTimer`  L30
- `DeleteAccountViewModel mViewModel`  L31
- `UserInfoActivity userInfoActivity = this.mActivity`  L125

方法（22）：
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L34 @Override
- `void onChanged(Object obj)`  L41 @Override
- `void lambda$onCreateView$0(GKUUser gKUUser)`  L50
- `void initView()`  L56
- `void onClick(View view)`  L59 @Override
- `void onChanged(Object obj)`  L65 @Override
- `void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)`  L71 @Override
- `void onTextChanged(CharSequence charSequence, int i, int i1, int i2)`  L75 @Override
- `void afterTextChanged(Editable editable)`  L79 @Override
- `void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)`  L85 @Override
- `void onTextChanged(CharSequence charSequence, int i, int i1, int i2)`  L89 @Override
- `void afterTextChanged(Editable editable)`  L93 @Override
- `void onClick(View view)`  L99 @Override
- `void lambda$initView$1(View view)`  L106
- `void lambda$initView$2(VerifyCodeResponse verifyCodeResponse)`  L112
- `void lambda$initView$4(View view)`  L119
- `void onClick(View view2)`  L128 @Override
- `void lambda$initView$3(View view)`  L136
- `void handleConfirmBtn()`  L155
- `void startCountdown(int countdownTime)`  L169
- `void onTick(long millisUntilFinished)`  L172 @Override
- `void onFinish()`  L180 @Override
### `com.gku.loginmodule.ui.fragment.DeleteAccountFragment_GeneratedInjector`
L4 · [interface] public DeleteAccountFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/DeleteAccountFragment_GeneratedInjector.java`

方法（1）：
- `void injectDeleteAccountFragment(DeleteAccountFragment deleteAccountFragment)`  L5
### `com.gku.loginmodule.ui.fragment.ForgetPasswordFragment`
L21 · [class] public ForgetPasswordFragment · extends `BaseFragment` · `com/gku/loginmodule/ui/fragment/ForgetPasswordFragment.java`

字段/常量（6）：
- `String TAG = "ForgetPasswordFragment"`  L22
- `Login_Register_Activity mActivity`  L23
- `FragmentForgetPwdBinding mBinding`  L24
- `CountDownTimer mCountdownTimer`  L25
- `ForgetPasswordFragmentViewModel mViewModel`  L26
- `boolean isClickVerifyCodeBtn = false`  L48

方法（16）：
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L29 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L33 @Override
- `void afterTextChanged(Editable s)`  L37 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L51 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L61 @Override
- `void initView()`  L66
- `void onClick(View view)`  L69 @Override
- `void onChanged(Object obj)`  L75 @Override
- `void onClick(View view)`  L84 @Override
- `void lambda$initView$0(View view)`  L91
- `void lambda$initView$1(VerifyCodeResponse verifyCodeResponse)`  L101
- `void lambda$initView$2(View view)`  L108
- `void startCountdown(int countdownTime)`  L136
- `void onTick(long millisUntilFinished)`  L139 @Override
- `void onFinish()`  L147 @Override
- `void onActivityCreated(Bundle savedInstanceState)`  L156 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_DeleteAccountFragment`
L17 · [class] abstract Hilt_DeleteAccountFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_DeleteAccountFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_LoginFragment`
L17 · [class] abstract Hilt_LoginFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_LoginFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_ModifyPasswordFragment`
L17 · [class] abstract Hilt_ModifyPasswordFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_ModifyPasswordFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_OperationFailFragment`
L17 · [class] abstract Hilt_OperationFailFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_OperationFailFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_OperationSuccessFragment`
L17 · [class] abstract Hilt_OperationSuccessFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_OperationSuccessFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_PhoneNumberFragment`
L17 · [class] abstract Hilt_PhoneNumberFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_PhoneNumberFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_RegisterFragment`
L17 · [class] abstract Hilt_RegisterFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_RegisterFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_ReportFeedbackFragment`
L17 · [class] abstract Hilt_ReportFeedbackFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_ReportFeedbackFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_UserCenterNewFragment`
L17 · [class] abstract Hilt_UserCenterNewFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_UserCenterNewFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.Hilt_UserInfoFragment`
L17 · [class] abstract Hilt_UserInfoFragment · extends `BaseFragment implements GeneratedComponentManagerHolder` · implements `GeneratedComponentManagerHolder` · `com/gku/loginmodule/ui/fragment/Hilt_UserInfoFragment.java`

字段/常量（5）：
- `ContextWrapper componentContext`  L18
- `FragmentComponentManager componentManager`  L19
- `boolean disableGetContextFix`  L20
- `boolean injected = false`  L22
- `ContextWrapper contextWrapper = this.componentContext`  L37

方法（10）：
- `void onAttach(Context context)`  L28 @Override
- `void onAttach(Activity activity)`  L35 @Override
- `void initializeComponentContext()`  L43
- `Context getContext()`  L51 @Override
- `LayoutInflater onGetLayoutInflater(Bundle savedInstanceState)`  L60 @Override
- `Object generatedComponent()`  L66 @Override
- `FragmentComponentManager createComponentManager()`  L70
- `FragmentComponentManager componentManager()`  L75 @Override
- `void inject()`  L86
- `ViewModelProvider.Factory getDefaultViewModelProviderFactory()`  L95 @Override
### `com.gku.loginmodule.ui.fragment.LoginFragment`
L42 · [class] public LoginFragment · extends `Hilt_LoginFragment` · `com/gku/loginmodule/ui/fragment/LoginFragment.java`

字段/常量（9）：
- `String TAG = "LoginFragment"`  L43
- `Login_Register_Activity mActivity`  L44
- `FragmentLoginBinding mBinding`  L45
- `LoginFragmentViewModel mViewModel`  L46
- `MVUtils mvUtils`  L49 @Inject
- `String requestLanguage`  L50
- `boolean isAgree = false`  L51
- `String[] strArr`  L119
- `String[] strArr`  L142

方法（26）：
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L54 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L58 @Override
- `void afterTextChanged(Editable s)`  L62 @Override
- `LoginFragment newInstance()`  L67
- `void onAttach(Context context)`  L72 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L78 @Override
- `void initView()`  L88
- `void onClick(View view)`  L91 @Override
- `void onClick(View view)`  L97 @Override
- `void onClick(View view)`  L103 @Override
- `void onClick(View widget)`  L118 @Override
- `void updateDrawState(TextPaint ds)`  L129 @Override
- `void onClick(View widget)`  L141 @Override
- `void updateDrawState(TextPaint ds)`  L152 @Override
- `void onChanged(Object obj)`  L170 @Override
- `void onClick(View view)`  L178 @Override
- `void lambda$initView$0(View view)`  L185
- `void lambda$initView$1(View view)`  L190
- `void lambda$initView$2(View view)`  L195
- `void lambda$initView$3(List list)`  L207
    - 体内字面量："============requestLanguage: "
- `void lambda$initView$5(View view)`  L220
- `void run()`  L238 @Override
- `void lambda$initView$4(String str, String str2)`  L246
- `void onResult()`  L249 @Override
- `void updateBtnState()`  L256
- `void onActivityCreated(Bundle savedInstanceState)`  L267 @Override
### `com.gku.loginmodule.ui.fragment.LoginFragment_GeneratedInjector`
L4 · [interface] public LoginFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/LoginFragment_GeneratedInjector.java`

方法（1）：
- `void injectLoginFragment(LoginFragment loginFragment)`  L5
### `com.gku.loginmodule.ui.fragment.LoginFragment_MembersInjector`
L8 · [class] public final LoginFragment_MembersInjector · implements `MembersInjector<LoginFragment>` · `com/gku/loginmodule/ui/fragment/LoginFragment_MembersInjector.java`

字段/常量（1）：
- `Provider<MVUtils> mvUtilsProvider`  L9

方法（4）：
- `public LoginFragment_MembersInjector(Provider<MVUtils> mvUtilsProvider)`  L11
- `MembersInjector<LoginFragment> create(Provider<MVUtils> mvUtilsProvider)`  L15
- `void injectMembers(LoginFragment instance)`  L20 @Override
- `void injectMvUtils(LoginFragment instance, MVUtils mvUtils)`  L24
### `com.gku.loginmodule.ui.fragment.ModifyPasswordFragment`
L22 · [class] public ModifyPasswordFragment · extends `Hilt_ModifyPasswordFragment` · `com/gku/loginmodule/ui/fragment/ModifyPasswordFragment.java`

字段/常量（4）：
- `String TAG = "ModifyPasswordFragment"`  L23
- `UserInfoActivity mActivity`  L24
- `FragmentModifyPwdBinding mBinding`  L25
- `ModifyPasswordFragmentViewModel mViewModel`  L26

方法（14）：
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L29 @Override
- `void onChanged(Object obj)`  L37 @Override
- `void lambda$onCreateView$0(GKUUser gKUUser)`  L46
- `void initView()`  L52
- `void onClick(View view)`  L55 @Override
- `void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)`  L61 @Override
- `void onTextChanged(CharSequence charSequence, int i, int i1, int i2)`  L65 @Override
- `void afterTextChanged(Editable editable)`  L69 @Override
- `void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)`  L81 @Override
- `void onTextChanged(CharSequence charSequence, int i, int i1, int i2)`  L85 @Override
- `void afterTextChanged(Editable editable)`  L89 @Override
- `void lambda$initView$2(View view)`  L102
- `void run()`  L116 @Override
- `void lambda$initView$1(String str, String str2)`  L124
### `com.gku.loginmodule.ui.fragment.ModifyPasswordFragment_GeneratedInjector`
L4 · [interface] public ModifyPasswordFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/ModifyPasswordFragment_GeneratedInjector.java`

方法（1）：
- `void injectModifyPasswordFragment(ModifyPasswordFragment modifyPasswordFragment)`  L5
### `com.gku.loginmodule.ui.fragment.OperationFailFragment`
L21 · [class] public OperationFailFragment · extends `Hilt_OperationFailFragment` · `com/gku/loginmodule/ui/fragment/OperationFailFragment.java`

字段/常量（10）：
- `String TAG = "OperationFailFragment"`  L22
- `Login_Register_Activity loginActivity`  L23
- `FragmentOperationFailBinding mBinding`  L24
- `OperationFailFragmentViewModel mViewModel`  L25
- `MVUtils mvUtils`  L28 @Inject
- `Report_Feedback_Activity report_feedback_activity`  L29
- `UserInfoActivity userInfoActivity`  L30
- `Login_Register_Activity login_Register_Activity = this.loginActivity`  L63
- `Report_Feedback_Activity report_Feedback_Activity = this.report_feedback_activity`  L68
- `UserInfoActivity userInfoActivity = this.userInfoActivity`  L73

方法（4）：
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L33 @Override
- `void initView()`  L52
- `void onClick(View view)`  L55 @Override
- `void lambda$initView$0(View view)`  L62
### `com.gku.loginmodule.ui.fragment.OperationFailFragment_GeneratedInjector`
L4 · [interface] public OperationFailFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/OperationFailFragment_GeneratedInjector.java`

方法（1）：
- `void injectOperationFailFragment(OperationFailFragment operationFailFragment)`  L5
### `com.gku.loginmodule.ui.fragment.OperationFailFragment_MembersInjector`
L8 · [class] public final OperationFailFragment_MembersInjector · implements `MembersInjector<OperationFailFragment>` · `com/gku/loginmodule/ui/fragment/OperationFailFragment_MembersInjector.java`

字段/常量（1）：
- `Provider<MVUtils> mvUtilsProvider`  L9

方法（4）：
- `public OperationFailFragment_MembersInjector(Provider<MVUtils> mvUtilsProvider)`  L11
- `MembersInjector<OperationFailFragment> create(Provider<MVUtils> mvUtilsProvider)`  L15
- `void injectMembers(OperationFailFragment instance)`  L20 @Override
- `void injectMvUtils(OperationFailFragment instance, MVUtils mvUtils)`  L24
### `com.gku.loginmodule.ui.fragment.OperationSuccessFragment`
L22 · [class] public OperationSuccessFragment · extends `Hilt_OperationSuccessFragment` · `com/gku/loginmodule/ui/fragment/OperationSuccessFragment.java`

字段/常量（11）：
- `String TAG = "OperationSuccess"`  L23
- `Login_Register_Activity loginActivity`  L24
- `FragmentOperationSuccessBinding mBinding`  L25
- `Context mContext`  L26
- `OperationSuccessFragmentViewModel mViewModel`  L27
- `MVUtils mvUtils`  L30 @Inject
- `Report_Feedback_Activity report_feedback_activity`  L31
- `UserInfoActivity userInfoActivity`  L32
- `Login_Register_Activity login_Register_Activity = this.loginActivity`  L69
- `Report_Feedback_Activity report_Feedback_Activity = this.report_feedback_activity`  L74
- `UserInfoActivity userInfoActivity = this.userInfoActivity`  L79

方法（4）：
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L35 @Override
- `void initView()`  L58
- `void onClick(View view)`  L61 @Override
- `void lambda$initView$0(View view)`  L68
### `com.gku.loginmodule.ui.fragment.OperationSuccessFragment_GeneratedInjector`
L4 · [interface] public OperationSuccessFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/OperationSuccessFragment_GeneratedInjector.java`

方法（1）：
- `void injectOperationSuccessFragment(OperationSuccessFragment operationSuccessFragment)`  L5
### `com.gku.loginmodule.ui.fragment.OperationSuccessFragment_MembersInjector`
L8 · [class] public final OperationSuccessFragment_MembersInjector · implements `MembersInjector<OperationSuccessFragment>` · `com/gku/loginmodule/ui/fragment/OperationSuccessFragment_MembersInjector.java`

字段/常量（1）：
- `Provider<MVUtils> mvUtilsProvider`  L9

方法（4）：
- `public OperationSuccessFragment_MembersInjector(Provider<MVUtils> mvUtilsProvider)`  L11
- `MembersInjector<OperationSuccessFragment> create(Provider<MVUtils> mvUtilsProvider)`  L15
- `void injectMembers(OperationSuccessFragment instance)`  L20 @Override
- `void injectMvUtils(OperationSuccessFragment instance, MVUtils mvUtils)`  L24
### `com.gku.loginmodule.ui.fragment.PhoneNumberFragment`
L27 · [class] public PhoneNumberFragment · extends `Hilt_PhoneNumberFragment` · `com/gku/loginmodule/ui/fragment/PhoneNumberFragment.java`

字段/常量（5）：
- `String TAG = "PhoneNumberFragment"`  L28
- `UserInfoActivity mActivity`  L29
- `FragmentPhoneNumberBinding mBinding`  L30
- `PhoneNumberFragmentViewModel mViewModel`  L31
- `TextInputEditText textInputEditText = this.mBinding.etPhoneNumber`  L75

方法（12）：
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L34 @Override
- `void onChanged(Object obj)`  L41 @Override
- `void lambda$onCreateView$0(GKUUser gKUUser)`  L50
- `void initView()`  L61
- `void onClick(View view)`  L65 @Override
- `void onClick(View view)`  L71 @Override
- `void onClick(View view)`  L78 @Override
- `boolean onKey(View view, int i, KeyEvent keyEvent)`  L84 @Override
- `void lambda$initView$1(View view)`  L91
- `void lambda$initView$2(View view)`  L96
    - 体内字面量："input_method"
- `void lambda$initView$3(TextInputEditText textInputEditText, View view)`  L106
    - 体内字面量："(" · ")"
- `boolean lambda$initView$4(TextInputEditText textInputEditText, View view, int i, KeyEvent keyEvent)`  L119
### `com.gku.loginmodule.ui.fragment.PhoneNumberFragment_GeneratedInjector`
L4 · [interface] public PhoneNumberFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/PhoneNumberFragment_GeneratedInjector.java`

方法（1）：
- `void injectPhoneNumberFragment(PhoneNumberFragment phoneNumberFragment)`  L5
### `com.gku.loginmodule.ui.fragment.PhoneNumberFragment$MyAdapter`
L127 · [class] static MyAdapter · extends `ArrayAdapter<String>` · `com/gku/loginmodule/ui/fragment/PhoneNumberFragment.java`

方法（2）：
- `public MyAdapter(Context context, int resource, String[] objects)`  L128
- `View getView(int position, View convertView, ViewGroup parent)`  L133 @Override
### `com.gku.loginmodule.ui.fragment.RegisterFragment`
L33 · [class] public RegisterFragment · extends `Hilt_RegisterFragment` · `com/gku/loginmodule/ui/fragment/RegisterFragment.java`

字段/常量（11）：
- `String TAG = "RegisterFragment"`  L34
- `Login_Register_Activity mActivity`  L35
- `FragmentRegisterBinding mBinding`  L36
- `Context mContext`  L37
- `CountDownTimer mCountdownTimer`  L38
- `RegisterFragmentViewModel mViewModel`  L39
- `String requestLanguage = null`  L40
- `boolean isAgree = false`  L41
- `boolean isClickVerifyCodeBtn = false`  L56
- `String[] strArr`  L145
- `String[] strArr`  L156

方法（26）：
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L44 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L48 @Override
- `void afterTextChanged(Editable s)`  L52 @Override
- `RegisterFragment newInstance()`  L58
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L63 @Override
- `void initView()`  L72
- `void onClick(View view)`  L75 @Override
- `void onClick(View view)`  L81 @Override
- `void onClick(View view)`  L87 @Override
- `void onClick(View view)`  L93 @Override
- `void onChanged(Object obj)`  L100 @Override
- `void onChanged(Object obj)`  L106 @Override
- `void onClick(View view)`  L115 @Override
- `void lambda$initView$0(View view)`  L122
- `void lambda$initView$1(View view)`  L132
- `void lambda$initView$2(View view)`  L144
- `void lambda$initView$3(View view)`  L155
- `void lambda$initView$4(List list)`  L166
    - 体内字面量："============requestLanguage: "
- `void lambda$initView$5(VerifyCodeResponse verifyCodeResponse)`  L179
- `void lambda$initView$7(View view)`  L186
- `void run()`  L216 @Override
- `void lambda$initView$6(String str, String str2, String str3)`  L224
- `void updateBtnState()`  L229
- `void startCountdown(int countdownTime)`  L241
- `void onTick(long millisUntilFinished)`  L244 @Override
- `void onFinish()`  L252 @Override
### `com.gku.loginmodule.ui.fragment.RegisterFragment_GeneratedInjector`
L4 · [interface] public RegisterFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/RegisterFragment_GeneratedInjector.java`

方法（1）：
- `void injectRegisterFragment(RegisterFragment registerFragment)`  L5
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment`
L120 · [class] public ReportFeedbackFragment · extends `Hilt_ReportFeedbackFragment` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`

字段/常量（30）：
- `String TAG = "ReportFeedbackFragment"`  L121
- `String attachmentUrl`  L122
- `int chooseMode`  L123
- `ImageEngine imageEngine`  L124
- `int language`  L125
- `ActivityResultLauncher<Intent> launcherResult`  L126
- `String logUrl`  L127
- `Report_Feedback_Activity mActivity`  L128
- `FragmentReportFeedbackBinding mBinding`  L129
- `ReportFeedbackViewModel mViewModel`  L130
- `MVUtils mvUtils`  L133 @Inject
- `ReportFeedBackAdapter reportFeedBackAdapter`  L134
- `String requestLanguage`  L135
- `PictureSelectorStyle selectorStyle`  L136
- `VideoPlayerEngine videoPlayerEngine`  L137
- `long lastClickTime = 0`  L142
- `int maxSelectNum = 1`  L143
- `int resultMode = 2`  L144
- `Report_Feedback_Activity report_Feedback_Activity = this.mActivity`  L177
- `List<String> list = this.ptNameList`  L178
- `int i = android.R.layout.simple_spinner_item`  L179
- `String str = this.attachmentUrl`  L410
- `Animator[] animatorArr = new Animator[2]`  L588
- `int i = this.resultMode`  L606
- `Exception e`  L641
- `?? sandboxPath`  L642
- `String absolutePath = null`  L656
- `String str = absolutePath`  L692
- `String str`  L887
- `String str2`  L888

方法（66）：
- `void lambda$initSpinner$0(AdapterView adapterView, View view, int i, long j)`  L146
- `void lambda$initSpinner$3(AdapterView adapterView, View view, int i, long j)`  L149
- `void lambda$initSpinner$6(AdapterView adapterView, View view, int i, long j)`  L152
- `int lambda$previewMedia$11(Context context, int i)`  L155
- `PictureSelectorPreviewFragment lambda$previewMedia$12()`  L159
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L164 @Override
    - 体内字面量："onCreateViewDFDSFDSFS: "
- `void initSpinner()`  L175
- `View getDropDownView(int position, View convertView, ViewGroup parent)`  L182 @Override
- `View getView(int position, View convertView, ViewGroup parent)`  L189 @Override
- `void onItemClick(AdapterView adapterView, View view, int i2, long j)`  L201 @Override
- `void onClick(View view)`  L207 @Override
    - 体内字面量："S7PRO MAX" · "S7PRO" · "S7" · "MINI2PRO" · "X3" · "R1" · "S6PRO" · "S6" · "Mini1" · "MAX3" · "MAX2" · "MAXPRO" · "S3PRO" · "S5K" · "S2" · "X2" · "X1"
- `View getDropDownView(int position, View convertView, ViewGroup parent)`  L230 @Override
- `View getView(int position, View convertView, ViewGroup parent)`  L237 @Override
- `void onItemClick(AdapterView adapterView, View view, int i2, long j)`  L247 @Override
- `void onClick(View view)`  L253 @Override
- `View getDropDownView(int position, View convertView, ViewGroup parent)`  L269 @Override
- `View getView(int position, View convertView, ViewGroup parent)`  L276 @Override
- `void onItemClick(AdapterView adapterView, View view, int i2, long j)`  L286 @Override
- `void onClick(View view)`  L292 @Override
- `void lambda$initSpinner$2(View view)`  L299
- `void run()`  L302 @Override
- `void lambda$initSpinner$1()`  L309
- `void lambda$initSpinner$5(View view)`  L314
- `void run()`  L317 @Override
- `void lambda$initSpinner$4()`  L324
- `void lambda$initSpinner$8(View view)`  L329
- `void run()`  L332 @Override
- `void lambda$initSpinner$7()`  L339
- `void initView()`  L343
- `void onChanged(Object obj)`  L347 @Override
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L355 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L359 @Override
- `void afterTextChanged(Editable s)`  L363 @Override
- `void onClick(View view)`  L369 @Override
- `void lambda$initView$9(List list)`  L376
    - 体内字面量："============requestLanguage: "
- `void lambda$initView$10(View view)`  L389
- `void onResult()`  L418 @Override
- `void run()`  L421 @Override
- `String getProblemId(String problem)`  L429
    - 体内字面量："System_Abnormal" · "Device_File_Storage" · "Device_File_Download" · "Device_Preview_Playback" · "Video_Not_Play" · "App_Album_Share" · "APP_Compatibility" · "Experience_Improvement" · "App_Experience_Improvement" · "Other"
- `void initMediaRecyclerView()`  L461
- `boolean canScrollHorizontally()`  L469 @Override
- `boolean canScrollVertically()`  L474 @Override
- `int getSpanSize(int position)`  L480 @Override
    - 体内字面量："#EEEEEE"
- `void onMediaBackgroundClick(int position)`  L525 @Override
- `void onDeleteClick(int position)`  L534 @Override
- `void onDestroyView()`  L546 @Override
- `void onCreate(Bundle savedInstanceState)`  L551 @Override
- `ActivityResultLauncher<Intent> createActivityResultLauncher()`  L556
- `void onActivityResult(ActivityResult result)`  L559 @Override
    - 体内字面量："onActivityResult PictureSelector Cancel"
- `void openGallery()`  L571
- `boolean onFilter(LocalMedia media)`  L581 @Override
    - 体内字面量："date_modified DESC"
- `void onSelectItemAnim(View view, boolean isSelected)`  L586 @Override
- `long onSelectAnim(View view)`  L597 @Override
- `void forSelectResult(PictureSelectionModel model)`  L605
- `void analyticalSelectResults(final ArrayList<LocalMedia> arrayList)`  L640
- `void run()`  L700 @Override
- `String getSandboxAudioOutputPath()`  L763
    - 体内字面量："Sound"
- `String getSandboxCameraOutputPath()`  L771
    - 体内字面量："Sandbox"
- `void startRecordSoundAction(Fragment fragment, int requestCode)`  L876
    - 体内字面量："android.provider.MediaStore.RECORD_SOUND"
- `void addPermissionDescription(boolean isHasSimpleXCamera, ViewGroup viewGroup, String[] permissionArray)`  L886
- `void removePermissionDescription(ViewGroup viewGroup)`  L932
- `void previewMedia(int position)`  L937
- `void onDestroy(Fragment fragment)`  L947 @Override
- `void onViewCreated(Fragment fragment, View view, Bundle savedInstanceState)`  L951 @Override
- `int getLayoutResourceId(Context context, int i2)`  L955 @Override
- `PictureSelectorPreviewFragment onInjectPreviewFragment()`  L960 @Override
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment_GeneratedInjector`
L4 · [interface] public ReportFeedbackFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment_GeneratedInjector.java`

方法（1）：
- `void injectReportFeedbackFragment(ReportFeedbackFragment reportFeedbackFragment)`  L5
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment_MembersInjector`
L8 · [class] public final ReportFeedbackFragment_MembersInjector · implements `MembersInjector<ReportFeedbackFragment>` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment_MembersInjector.java`

字段/常量（1）：
- `Provider<MVUtils> mvUtilsProvider`  L9

方法（4）：
- `public ReportFeedbackFragment_MembersInjector(Provider<MVUtils> mvUtilsProvider)`  L11
- `MembersInjector<ReportFeedbackFragment> create(Provider<MVUtils> mvUtilsProvider)`  L15
- `void injectMembers(ReportFeedbackFragment instance)`  L20 @Override
- `void injectMvUtils(ReportFeedbackFragment instance, MVUtils mvUtils)`  L24
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment$AnonymousClass13`
L717 · [class] AnonymousClass13 · implements `Runnable` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`

字段/常量（3）：
- `File val$finalZipDirectory`  L718
- `ArrayList val$result`  L719
- `File file`  L728

方法（5）：
- `void run()`  L727 @Override
- `void onChanged(Object obj)`  L737 @Override
- `void onChanged(Object obj)`  L744 @Override
- `void lambda$run$0(String str)`  L751
    - 体内字面量："onUriToFileAsyncTransform: "
- `void lambda$run$1(String str)`  L758
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment$MeOnPermissionDeniedListener`
L779 · [class] private static MeOnPermissionDeniedListener · implements `OnPermissionDeniedListener` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`

字段/常量（1）：
- `String str`  L785

方法（3）：
- `private MeOnPermissionDeniedListener()`  L780
- `void onDenied(final Fragment fragment, String[] permissionArray, final int requestCode, OnCallbackListener<Boolean> call)`  L784 @Override
- `void onClick(View view)`  L799 @Override
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment$MeOnPermissionDescriptionListener`
L808 · [class] private static MeOnPermissionDescriptionListener · implements `OnPermissionDescriptionListener` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`

方法（3）：
- `private MeOnPermissionDescriptionListener()`  L809
- `void onPermissionDescription(Fragment fragment, String[] permissionArray)`  L813 @Override
- `void onDismiss(Fragment fragment)`  L821 @Override
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment$MeOnRecordAudioInterceptListener`
L848 · [class] private static MeOnRecordAudioInterceptListener · implements `OnRecordAudioInterceptListener` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`

字段/常量（1）：
- `String[] strArr = {"android.permission.RECORD_AUDIO"}`  L854

方法（4）：
- `private MeOnRecordAudioInterceptListener()`  L849
- `void onRecordAudio(final Fragment fragment, final int requestCode)`  L853 @Override
- `void onGranted()`  L861 @Override
- `void onDenied()`  L867 @Override
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment$MeOnResultCallbackListener`
L616 · [class] private MeOnResultCallbackListener · implements `OnResultCallbackListener<LocalMedia>` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`

方法（3）：
- `private MeOnResultCallbackListener()`  L617
- `void onResult(ArrayList<LocalMedia> result)`  L621 @Override
- `void onCancel()`  L626 @Override
    - 体内字面量："PictureSelector Cancel"
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment$MeOnSelectLimitTipsListener`
L826 · [class] private static MeOnSelectLimitTipsListener · implements `OnSelectLimitTipsListener` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`

方法（2）：
- `private MeOnSelectLimitTipsListener()`  L827
- `boolean onSelectLimitTips(Context context, LocalMedia media, SelectorConfig config, int limitType)`  L831 @Override
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment$MeSandboxFileEngine`
L982 · [class] private MeSandboxFileEngine · implements `UriToFileTransformEngine` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`

字段/常量（2）：
- `String str`  L999
- `InputStream fileInputStream`  L1000

方法（3）：
- `private MeSandboxFileEngine()`  L983
- `File getLocalDataPath(Context context)`  L986
    - 体内字面量："mounted"
- `void onUriToFileAsyncTransform(Context context, String srcPath, String mineType, OnKeyValueResultCallbackListener call)`  L998 @Override
### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment$MyExternalPreviewEventListener`
L966 · [class] private MyExternalPreviewEventListener · implements `OnExternalPreviewEventListener` · `com/gku/loginmodule/ui/fragment/ReportFeedbackFragment.java`

方法（3）：
- `boolean onLongPressDownload(Context context, LocalMedia media)`  L968 @Override
- `private MyExternalPreviewEventListener()`  L972
- `void onPreviewDelete(int position)`  L976 @Override
### `com.gku.loginmodule.ui.fragment.UserCenterNewFragment`
L54 · [class] public UserCenterNewFragment · extends `Hilt_UserCenterNewFragment` · `com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java`

字段/常量（20）：
- `String TAG = "UserInfoFragment"`  L55
- `String emailAddress`  L56
- `HomeActivity mActivity`  L57
- `FragmentUserCenterNewBinding mBinding`  L58
- `UserCenterNewAdapter mUserCenterAdapter1`  L59
- `UserCenterNewAdapter mUserCenterAdapter2`  L60
- `UserCenterNewTopAdapter mUserCenterNewTopAdapter1`  L61
- `UserCenterNewFragmentViewModel mViewModel`  L62
- `MVUtils mvUtils`  L65 @Inject
- `LiveData<GetProductTypesResponse> ptAndPMResponse`  L66
- `String requestLanguage = "<binary/metadata>"`  L70
- `boolean isViewCreated = false`  L71
- `boolean goToReportFeedbackActivity = true`  L73
- `boolean observe = false`  L74
- `HomeActivity homeActivity`  L82
- `ArrayList<UserCenterNewItem> arrayList = this.mUserCenterItemList2`  L106
- `ArrayList<UserCenterNewItem> arrayList2 = this.mUserCenterItemList2`  L108
- `UserCenterNewFragmentViewModel userCenterNewFragmentViewModel = this.mViewModel`  L115
- `boolean z = false`  L211
- `int i = 1`  L213

方法（27）：
- `UserCenterNewFragment newInstance()`  L76
- `void setUserVisibleHint(boolean isVisibleToUser)`  L81 @Override
- `void run()`  L123 @Override
- `void lambda$setUserVisibleHint$1()`  L130
- `void onChanged(Object obj)`  L135 @Override
- `void lambda$setUserVisibleHint$0(List list)`  L145
    - 体内字面量："============requestLanguage: "
- `void onCreate(Bundle savedInstanceState)`  L158 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L163 @Override
- `void onChanged(Object obj)`  L170 @Override
- `void lambda$onCreateView$2(GKUUser gKUUser)`  L178
- `void onViewCreated(View view, Bundle savedInstanceState)`  L183 @Override
    - 体内字面量："zh"
- `void initRecyclerView(boolean isCN)`  L189
    - 体内字面量："https://xtucp.tmall.com/?spm=a1z10.3-b-s.w20166435-22198852064.1.35dc182aeGhCvE&scene=taobao_shop" · "https://h5.m.jd.com/dev/RLVegkgjdNJoM4Y1WsvAnKLD7Qw/index.html?appurl=https%3A%2F%2Fshop.m.jd.com%3FshopId%3D807701%26utm_source%3Dpdappwakeupup_20170002" · "https://z.douyin.com/p53t?scheme=snssdk1128%3A%2F%2Fgoods%2Fstore%3Fsec_shop_id%3DQMnJSSw%26entrance_location%3Ddou_shop_ad_101_2%26tab_id%3D16%26url_maker%3Dshop_sdk" · "http://mobile.yangkeduo.com/mall_page.html?mall_id=640975089\n" · "https://www.facebook.com/" · "https://www.youtube.com/"
- `boolean canScrollHorizontally()`  L216 @Override
- `boolean canScrollVertically()`  L221 @Override
- `void onItemClick(int position)`  L229 @Override
- `boolean canScrollHorizontally()`  L246 @Override
- `boolean canScrollVertically()`  L251 @Override
- `void onItemClick(int position)`  L259 @Override
    - 体内字面量："android.intent.action.VIEW" · "clipboard" · "text"
- `boolean canScrollHorizontally()`  L280 @Override
- `boolean canScrollVertically()`  L285 @Override
- `void onStart()`  L384 @Override
- `void onResume()`  L389 @Override
- `void onPause()`  L395 @Override
- `void onStop()`  L401 @Override
- `void onDestroyView()`  L406 @Override
- `void onDestroy()`  L412 @Override
- `void onDetach()`  L417 @Override
### `com.gku.loginmodule.ui.fragment.UserCenterNewFragment_GeneratedInjector`
L4 · [interface] public UserCenterNewFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/UserCenterNewFragment_GeneratedInjector.java`

方法（1）：
- `void injectUserCenterNewFragment(UserCenterNewFragment userCenterNewFragment)`  L5
### `com.gku.loginmodule.ui.fragment.UserCenterNewFragment_MembersInjector`
L8 · [class] public final UserCenterNewFragment_MembersInjector · implements `MembersInjector<UserCenterNewFragment>` · `com/gku/loginmodule/ui/fragment/UserCenterNewFragment_MembersInjector.java`

字段/常量（1）：
- `Provider<MVUtils> mvUtilsProvider`  L9

方法（4）：
- `public UserCenterNewFragment_MembersInjector(Provider<MVUtils> mvUtilsProvider)`  L11
- `MembersInjector<UserCenterNewFragment> create(Provider<MVUtils> mvUtilsProvider)`  L15
- `void injectMembers(UserCenterNewFragment instance)`  L20 @Override
- `void injectMvUtils(UserCenterNewFragment instance, MVUtils mvUtils)`  L24
### `com.gku.loginmodule.ui.fragment.UserCenterNewFragment$AnonymousClass6`
L296 · [class] AnonymousClass6 · implements `UserCenterNewAdapter.OnItemClickListener` · `com/gku/loginmodule/ui/fragment/UserCenterNewFragment.java`

字段/常量（1）：
- `UserCenterNewFragment userCenterNewFragment = UserCenterNewFragment.this`  L350

方法（6）：
- `void lambda$onItemClick$1(GetProductTypesResponse getProductTypesResponse)`  L301
    - 体内字面量："onItemClickSDASFAFAFAF: "
- `void run()`  L308 @Override
- `void run()`  L323 @Override
- `void lambda$onItemClick$0()`  L330
- `void onItemClick(int position)`  L335 @Override
- `void onChanged(Object obj)`  L354 @Override
    - 体内字面量："(" · ")" · "payload"
### `com.gku.loginmodule.ui.fragment.UserInfoFragment`
L23 · [class] public UserInfoFragment · extends `Hilt_UserInfoFragment` · `com/gku/loginmodule/ui/fragment/UserInfoFragment.java`

字段/常量（10）：
- `String TAG = "UserInfoFragment"`  L24
- `FragmentUserInfoBinding binding`  L25
- `String emailAddress`  L26
- `UserInfoActivity mActivity`  L27
- `UserInfoAdapter mUserInfoAdapter1`  L28
- `UserInfoAdapter mUserInfoAdapter2`  L29
- `UserInfoFragmentViewModel mViewModel`  L32
- `String phoneNum`  L33
- `int i = 1`  L61
- `boolean z = false`  L62

方法（23）：
- `UserInfoFragment newInstance()`  L35
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L40 @Override
- `void initView()`  L50
- `void onClick(View v)`  L54 @Override
- `void initRecyclerView()`  L60
- `boolean canScrollHorizontally()`  L65 @Override
- `boolean canScrollVertically()`  L70 @Override
- `void onItemClick(int i2)`  L78 @Override
- `boolean canScrollHorizontally()`  L85 @Override
- `boolean canScrollVertically()`  L90 @Override
- `void onItemClick(int i2)`  L98 @Override
- `void onChanged(GKUUser gkuUser)`  L106 @Override
- `void run()`  L120 @Override
- `void lambda$initRecyclerView$0(int i)`  L130
- `void lambda$initRecyclerView$1(int i)`  L138
- `void onStart()`  L146 @Override
- `void run()`  L150 @Override
- `void onResume()`  L157 @Override
- `void onPause()`  L162 @Override
- `void onStop()`  L167 @Override
- `void onDestroyView()`  L172 @Override
- `void onDestroy()`  L177 @Override
- `void onDetach()`  L182 @Override
### `com.gku.loginmodule.ui.fragment.UserInfoFragment_GeneratedInjector`
L4 · [interface] public UserInfoFragment_GeneratedInjector · `com/gku/loginmodule/ui/fragment/UserInfoFragment_GeneratedInjector.java`

方法（1）：
- `void injectUserInfoFragment(UserInfoFragment userInfoFragment)`  L5
### `com.gku.loginmodule.ui.model.AnnouncementItem`
L7 · [class] public AnnouncementItem · implements `Parcelable` · `com/gku/loginmodule/ui/model/AnnouncementItem.java`

字段/常量（6）：
- `String content`  L21
- `String createTime`  L22
- `String iconUrl`  L23
- `boolean isCreateTimeItem`  L24
- `String linkUrl`  L25
- `String title`  L26

方法（19）：
- `AnnouncementItem createFromParcel(Parcel source)`  L11 @Override
- `AnnouncementItem[] newArray(int size)`  L17 @Override
- `int describeContents()`  L29 @Override
- `public AnnouncementItem(String iconUrl, String title, String content, String linkUrl, String createTime, boolean isCreateTimeItem)`  L33
- `String getIconUrl()`  L42
- `void setIconUrl(String iconUrl)`  L46
- `String getTitle()`  L50
- `void setTitle(String title)`  L54
- `String getContent()`  L58
- `void setContent(String content)`  L62
- `String getLinkUrl()`  L66
- `void setLinkUrl(String linkUrl)`  L70
- `String getCreateTime()`  L74
- `void setCreateTime(String createTime)`  L78
- `boolean isCreateTimeItem()`  L82
- `void setCreateTimeItem(boolean createTimeItem)`  L86
- `Parcelable.Creator<AnnouncementItem> getCREATOR()`  L90
- `void writeToParcel(Parcel parcel, int i)`  L95 @Override
- `protected AnnouncementItem(Parcel in)`  L103
### `com.gku.loginmodule.ui.model.ReportFeedBackItem`
L8 · [class] public ReportFeedBackItem · extends `LocalMedia implements Parcelable` · implements `Parcelable` · `com/gku/loginmodule/ui/model/ReportFeedBackItem.java`

字段/常量（9）：
- `int TYPE_ADD = 3`  L22
- `int TYPE_IMAGE = 1`  L23
- `int TYPE_TEXT = 0`  L24
- `int TYPE_VIDEO = 2`  L25
- `int drawableId`  L26
- `String path`  L27
- `String text`  L28
- `int type`  L29
- `long videoTime`  L30

方法（16）：
- `ReportFeedBackItem createFromParcel(Parcel in)`  L12 @Override
- `ReportFeedBackItem[] newArray(int size)`  L18 @Override
- `int describeContents()`  L33 @Override
- `public ReportFeedBackItem(int type, String path, long videoTime, String text, int drawableId)`  L37
- `int getType()`  L45
- `void setType(int type)`  L49
- `String getPath()`  L54 @Override
- `void setPath(String path)`  L59 @Override
- `long getVideoTime()`  L63
- `void setVideoTime(long videoTime)`  L67
- `String getText()`  L71
- `void setText(String text)`  L75
- `int getDrawableId()`  L79
- `void setDrawableId(int drawableId)`  L83
- `protected ReportFeedBackItem(Parcel in)`  L87
- `void writeToParcel(Parcel dest, int flags)`  L96 @Override
### `com.gku.loginmodule.ui.model.UserCenterItem_1`
L7 · [class] public UserCenterItem_1 · implements `Parcelable` · `com/gku/loginmodule/ui/model/UserCenterItem_1.java`

字段/常量（1）：
- `String textLeft`  L21

方法（9）：
- `UserCenterItem_1 createFromParcel(Parcel source)`  L11 @Override
- `UserCenterItem_1[] newArray(int size)`  L17 @Override
- `int describeContents()`  L24 @Override
- `public UserCenterItem_1(String textLeft)`  L28
- `String getTextLeft()`  L32
- `void setTextLeft(String textLeft)`  L36
- `Parcelable.Creator<UserCenterItem_1> getCREATOR()`  L40
- `void writeToParcel(Parcel dest, int flags)`  L45 @Override
- `protected UserCenterItem_1(Parcel in)`  L49
### `com.gku.loginmodule.ui.model.UserCenterNewItem`
L7 · [class] public UserCenterNewItem · implements `Parcelable` · `com/gku/loginmodule/ui/model/UserCenterNewItem.java`

字段/常量（7）：
- `boolean IsOutLink`  L21
- `boolean IsTitle`  L22
- `String ItemName`  L23
- `String Title`  L24
- `int drawableID`  L25
- `boolean isGridItem`  L26
- `String url`  L27

方法（21）：
- `UserCenterNewItem createFromParcel(Parcel source)`  L11 @Override
- `UserCenterNewItem[] newArray(int size)`  L17 @Override
- `int describeContents()`  L30 @Override
- `public UserCenterNewItem(boolean isGridItem, boolean isTitle, String title, String itemName, int drawableID, String url, boolean isOutLink)`  L34
- `boolean isGridItem()`  L44
- `void setGridItem(boolean gridItem)`  L48
- `boolean isTitle()`  L52
- `void setTitle(boolean title)`  L56
- `String getTitle()`  L60
- `void setTitle(String title)`  L64
- `String getItemName()`  L68
- `void setItemName(String itemName)`  L72
- `int getDrawableID()`  L76
- `void setDrawableID(int drawableID)`  L80
- `String getUrl()`  L84
- `void setUrl(String url)`  L88
- `boolean isOutLink()`  L92
- `void setOutLink(boolean outLink)`  L96
- `Parcelable.Creator<UserCenterNewItem> getCREATOR()`  L100
- `void writeToParcel(Parcel parcel, int i)`  L105 @Override
- `protected UserCenterNewItem(Parcel in)`  L115
### `com.gku.loginmodule.ui.model.UserInfoItem`
L7 · [class] public UserInfoItem · implements `Parcelable` · `com/gku/loginmodule/ui/model/UserInfoItem.java`

字段/常量（3）：
- `boolean isImmutable`  L21
- `String textLeft`  L22
- `String textRight`  L23

方法（13）：
- `UserInfoItem createFromParcel(Parcel source)`  L11 @Override
- `UserInfoItem[] newArray(int size)`  L17 @Override
- `int describeContents()`  L26 @Override
- `public UserInfoItem(boolean isImmutable, String textLeft, String textRight)`  L30
- `boolean isImmutable()`  L36
- `void setImmutable(boolean immutable)`  L40
- `String getTextLeft()`  L44
- `void setTextLeft(String textLeft)`  L48
- `String getTextRight()`  L52
- `void setTextRight(String textRight)`  L56
- `Parcelable.Creator<UserInfoItem> getCREATOR()`  L60
- `void writeToParcel(Parcel parcel, int i)`  L65 @Override
- `protected UserInfoItem(Parcel in)`  L71
### `com.gku.loginmodule.ui.widget.CusProgressBar`
L20 · [class] public final CusProgressBar · extends `View` · `com/gku/loginmodule/ui/widget/CusProgressBar.java`
注解：

字段/常量（6）：
- `Paint backgroundPaint`  L21
- `float progress`  L22
- `Paint progressPaint`  L23
- `RectF rectF`  L24
- `float viewHeight`  L25
- `float viewWidth`  L26

方法（7）：
- `public CusProgressBar(Context context)`  L29
    - 体内字面量："context"
- `public CusProgressBar(Context context, AttributeSet attributeSet)`  L35
    - 体内字面量："context"
- ` CusProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L40
- `public CusProgressBar(Context context, AttributeSet attributeSet, int i)`  L45
    - 体内字面量："context" · "#E0E0E0" · "#019FFF"
- `void setProgress(float value)`  L63
- `void onSizeChanged(int w, int h, int oldw, int oldh)`  L69 @Override
- `void onDraw(Canvas canvas)`  L78 @Override
    - 体内字面量："canvas"
### `com.gku.loginmodule.ui.widget.CustomRoundProgress`
L18 · [class] public final CustomRoundProgress · extends `View` · `com/gku/loginmodule/ui/widget/CustomRoundProgress.java`
注解：

字段/常量（12）：
- `int bgColor`  L19
- `Paint bgPaint`  L20
- `int fillColor`  L21
- `Paint fillPaint`  L22
- `float progress`  L23
- `int strokeColor`  L24
- `Paint strokePaint`  L25
- `float strokeWidth`  L26
- `float f = 2`  L80
- `float f2 = height / f`  L81
- `float f3 = this.strokeWidth / f`  L82
- `float f4 = height - f3`  L83

方法（6）：
- `public CustomRoundProgress(Context context)`  L29
    - 体内字面量："context"
- `public CustomRoundProgress(Context context, AttributeSet attributeSet)`  L35
    - 体内字面量："context"
- ` CustomRoundProgress(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L40
- `public CustomRoundProgress(Context context, AttributeSet attributeSet, int i)`  L45
    - 体内字面量："context" · "#019FFF" · "#019FFF"
- `void setProgress(float value)`  L69
- `void onDraw(Canvas canvas)`  L75 @Override
    - 体内字面量："canvas"