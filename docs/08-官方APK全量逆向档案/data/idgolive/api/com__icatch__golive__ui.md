# idGoLive — 类与成员明细：com.icatch.golive.ui

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 108 个文件 / 158 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.ui.activity.AboutAppActivity`
L20 · [class] public AboutAppActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/AboutAppActivity.java`

字段/常量（2）：
- `boolean gotoChangeLanguage = false`  L21
- `Locale locale`  L67

方法（15）：
- `String getAppVersionName(Context context)`  L23
    - 体内字面量："VersionInfo" · "Exception"
- `void initView()`  L32
- `void onClick(View view)`  L35 @Override
- `void onClick(View view)`  L41 @Override
- `void onClick(View view)`  L47 @Override
- `void onClick(View view)`  L53 @Override
- `void onClick(View view)`  L59 @Override
- `void updateLanguage()`  L66
- `void m515lambda$initView$0$comicatchgoliveuiactivityAboutAppActivity(View view)`  L96
- `void m516lambda$initView$1$comicatchgoliveuiactivityAboutAppActivity(View view)`  L101
- `void m517lambda$initView$2$comicatchgoliveuiactivityAboutAppActivity(View view)`  L106
- `void m518lambda$initView$3$comicatchgoliveuiactivityAboutAppActivity(View view)`  L111
- `void m519lambda$initView$4$comicatchgoliveuiactivityAboutAppActivity(View view)`  L117
- `void onCreate(Bundle bundle)`  L122 @Override
- `void onResume()`  L130 @Override
### `com.icatch.golive.ui.activity.ChangeLanguageActivity`
L22 · [class] public ChangeLanguageActivity · extends `BaseActivity implements View.OnClickListener` · implements `View.OnClickListener` · `com/icatch/golive/ui/activity/ChangeLanguageActivity.java`

字段/常量（14）：
- `boolean hasChangeLanguage = false`  L23
- `CheckBox cb_chinese_s`  L24
- `CheckBox cb_chinese_t`  L25
- `CheckBox cb_english`  L26
- `CheckBox cb_japanese`  L27
- `CheckBox cb_korean`  L28
- `CheckBox cb_thai`  L29
- `LinearLayout ll_chinese_s`  L30
- `LinearLayout ll_chinese_t`  L31
- `LinearLayout ll_english`  L32
- `LinearLayout ll_japanese`  L33
- `LinearLayout ll_korean`  L34
- `LinearLayout ll_thai`  L35
- `Locale locale`  L130

方法（10）：
- `void initData()`  L37
- `void initView()`  L41
- `void onClick(View view)`  L44 @Override
- `void resetActivity(int i)`  L75
- `void setLanguage(String str)`  L99
- `void updateLanguage()`  L129
- `void m520x61a83dcc(View view)`  L159
- `void onClick(View view)`  L164 @Override
- `void onSure()`  L168 @Override
    - 体内字面量："ChangeLanguageActivity" · "onClick id = "
- `void onCreate(Bundle bundle)`  L200 @Override
### `com.icatch.golive.ui.activity.CommonVideoPlayerActivity`
L28 · [class] public CommonVideoPlayerActivity · extends `AppCompatActivity` · `com/icatch/golive/ui/activity/CommonVideoPlayerActivity.java`

字段/常量（11）：
- `String TAG = "CommonVideoPlayerActivity"`  L29
- `ICatchFile curVideoFile`  L30
- `int curVideoPosition`  L31
- `ExecutorService executor`  L32
- `List<MultiPbItemInfo> fileList`  L33
- `FileType fileType`  L34
- `MediaStreamPlayer mediaStreamPlayer`  L35
- `VideoPlayerView videoPlayerView`  L36
- `boolean remote = false`  L37
- `boolean hasDeleted = false`  L38
- `DeviceFile deviceFile`  L77

方法（18）：
- `void back()`  L41
    - 体内字面量："hasDeleted" · "fileType"
- `void delete()`  L55
- `void download()`  L59
- `void initClient()`  L62
    - 体内字面量："remote"
- `void initStreamParam()`  L76
- `void onBackClick()`  L102 @Override
- `void onDeleteClick()`  L107 @Override
- `void onDownloadClick()`  L112 @Override
- `void onMoreClick()`  L117 @Override
- `void onFullScreenModeChanged(boolean z)`  L122 @Override
    - 体内字面量："onFullScreenModeChanged isFullScreen:"
- `void startStream()`  L133
    - 体内字面量："startStream"
- `void stopStream()`  L138
    - 体内字面量："stopStream"
- `void destroySession()`  L143
- `void onConfigurationChanged(Configuration configuration)`  L151 @Override
    - 体内字面量："onConfigurationChanged newConfig.orientation:"
- `void onCreate(Bundle bundle)`  L162 @Override
- `void onDestroy()`  L176 @Override
- `void onPause()`  L182 @Override
- `void onResume()`  L188 @Override
### `com.icatch.golive.ui.activity.ConnectCourseActivity`
L10 · [class] public ConnectCourseActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/ConnectCourseActivity.java`

方法（4）：
- `void initView()`  L11
- `void onClick(View view)`  L14 @Override
- `void m521x8aec59bf(View view)`  L21
- `void onCreate(Bundle bundle)`  L26 @Override
### `com.icatch.golive.ui.activity.DownloadFirmwareActivity`
L42 · [class] public DownloadFirmwareActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/DownloadFirmwareActivity.java`

字段/常量（11）：
- `String TAG = "DownloadFirmwareActivity"`  L43
- `ImageView iv_hint`  L45
- `List<FirmwareInfo> list_downloaded_firmware`  L46
- `List<FirmwareInfo> list_firmware`  L47
- `LinearLayout ll_hint`  L48
- `DownloadFirmwareAdapter mAdapter`  L49
- `ProgressBar progressBar`  L50
- `Dialog progressDialog`  L51
- `TextView progressText`  L52
- `TextView tv_hint`  L53
- `String str = strArrSplit[strArrSplit.length - 1]`  L330

方法（21）：
- `void handleData(String str)`  L168
    - 体内字面量："firmware_list" · "product" · "name" · "version" · "download" · "list_firmware size: "
- `throw new RuntimeException(e)`  L184
- `boolean hasDownloaded(final FirmwareInfo firmwareInfo)`  L188
    - 体内字面量：" " · " "
- `void onClick(DialogInterface dialogInterface, int i)`  L202 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L208 @Override
- `void initData()`  L217
    - 体内字面量："https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json"
- `void initView()`  L223
- `void onClick(View view)`  L226 @Override
- `void onClick(View view)`  L232 @Override
- `void didClickCell(FirmwareInfo firmwareInfo)`  L245 @Override
    - 体内字面量："DownloadFirmwareAdapter didClickCell: "
- `void onClickCell(final FirmwareInfo firmwareInfo)`  L256
    - 体内字面量：" "
- `void onClick(DialogInterface dialogInterface, int i)`  L265 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L271 @Override
- `void onDelete(String str)`  L280
- `void onDeleteAll()`  L293
- `void onClick(DialogInterface dialogInterface, int i)`  L299 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L305 @Override
- `void onDownload(FirmwareInfo firmwareInfo)`  L316
- `void m522xe91cccc7(View view)`  L338
- `void m523xea531fa6(View view)`  L343
- `void onCreate(Bundle bundle)`  L348 @Override
### `com.icatch.golive.ui.activity.DownloadFirmwareActivity$AnonymousClass2`
L56 · [class] AnonymousClass2 · implements `Callback` · `com/icatch/golive/ui/activity/DownloadFirmwareActivity.java`

字段/常量（1）：
- `DownloadFirmwareActivity downloadFirmwareActivity = DownloadFirmwareActivity.this`  L62

方法（6）：
- `void m524xaebfd019()`  L61
- `void m525xbef7eba9(String str)`  L75
- `void onFailure(Call call, IOException iOException)`  L80 @Override
    - 体内字面量："onResponse Failure mRequestCode:"
- `void run()`  L84 @Override
- `void onResponse(Call call, Response response)`  L91 @Override
    - 体内字面量："request_url:https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json \n response_obj:"
- `void run()`  L96 @Override
### `com.icatch.golive.ui.activity.DownloadFirmwareActivity$AnonymousClass9`
L104 · [class] AnonymousClass9 · implements `FirmwareDownloader.ProgressListener` · `com/icatch/golive/ui/activity/DownloadFirmwareActivity.java`

字段/常量（4）：
- `FirmwareInfo val$item`  L105
- `DownloadFirmwareActivity downloadFirmwareActivity = DownloadFirmwareActivity.this`  L115
- `DownloadFirmwareActivity downloadFirmwareActivity = DownloadFirmwareActivity.this`  L135
- `FirmwareInfo firmwareInfo = this.val$item`  L136

方法（9）：
- `void m526xdb9553b8(FirmwareInfo firmwareInfo, File file)`  L112
- `void m527x68fa8620(String str)`  L122
    - 体内字面量：": "
- `void m528x2f3c8325(double d)`  L128
    - 体内字面量：" " · "%.1f%%"
- `void onComplete(final File file)`  L134 @Override
- `void run()`  L139 @Override
- `void onError(final String str)`  L146 @Override
- `void run()`  L149 @Override
- `void onProgress(long j, long j2)`  L156 @Override
- `void run()`  L160 @Override
### `com.icatch.golive.ui.activity.FeedbackActivity`
L32 · [class] public FeedbackActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/FeedbackActivity.java`

字段/常量（10）：
- `String TAG = "FeedbackActivity"`  L33
- `EditText et_content`  L34
- `EditText et_device_type`  L35
- `EditText et_device_usage_region`  L36
- `EditText et_email`  L37
- `EditText et_phone`  L38
- `Dialog mLoadingDialog`  L39
- `String webhook = "aHR0cHM6Ly9xeWFwaS53ZWl4aW4ucXEuY29tL2NnaS1iaW4vd2ViaG9vay9zZW5kP2tleT1jNjc5M2FjNC0zMmUyLTQxZWUtYmNlNi0yMTFiNDZhMGVlM2U="`  L40
- `String str = "email: " + string3`  L141
- `String str2 = str + "   content: " + string5`  L151

方法（9）：
- `String getAppVersionName(Context context)`  L95
    - 体内字面量："VersionInfo" · "Exception: "
- `void initView()`  L104
- `void onClick(View view)`  L107 @Override
- `void onClick(View view)`  L118 @Override
- `void onSubmit()`  L125
- `throw new RuntimeException(e)`  L165
- `void m529lambda$initView$0$comicatchgoliveuiactivityFeedbackActivity(View view)`  L170
- `void m530lambda$initView$1$comicatchgoliveuiactivityFeedbackActivity(View view)`  L175
- `void onCreate(Bundle bundle)`  L180 @Override
### `com.icatch.golive.ui.activity.FeedbackActivity$AnonymousClass1`
L43 · [class] AnonymousClass1 · implements `Callback` · `com/icatch/golive/ui/activity/FeedbackActivity.java`

字段/常量（2）：
- `FeedbackActivity feedbackActivity = FeedbackActivity.this`  L50
- `FeedbackActivity feedbackActivity = FeedbackActivity.this`  L57

方法（8）：
- `void m531xf61063ba()`  L48
- `void m532xbda50f4a()`  L55
- `void m533xaf4eb569()`  L63
- `void run()`  L66 @Override
- `void onFailure(Call call, IOException iOException)`  L73 @Override
    - 体内字面量："onResponse Failure mRequestCode:"
- `void run()`  L77 @Override
- `void onResponse(Call call, Response response)`  L84 @Override
    - 体内字面量："request_url:" · " \n response_obj:"
- `void run()`  L88 @Override
### `com.icatch.golive.ui.activity.LaunchActivity`
L63 · [class] public LaunchActivity · extends `BaseActivity implements View.OnClickListener, LaunchView, OnFragmentInteractionListener` · implements `View.OnClickListener, LaunchView, OnFragmentInteractionListener` · `com/icatch/golive/ui/activity/LaunchActivity.java`

字段/常量（21）：
- `String TAG = "LaunchActivity"`  L64
- `boolean gotoAbout = true`  L65
- `boolean kPublishGooglePlay = false`  L66
- `ActionBar actionBar`  L67
- `AlertDialog agreementDialog`  L68
- `AppBarLayout appBarLayout`  L69
- `ListView camSlotListView`  L70
- `LinearLayout launchLayout`  L71
- `FrameLayout launchSettingFrame`  L72
- `ImageView localPhoto`  L73
- `ImageView localVideo`  L74
- `MyOrientoinListener myOrientoinListener`  L75
- `boolean noPhotoFile`  L76
- `TextView noPhotosFound`  L77
- `boolean noVideoFile`  L78
- `TextView noVideosFound`  L79
- `LaunchPresenter presenter`  L80
- `Locale locale`  L111
- `AlertDialog alertDialog = this.agreementDialog`  L152
- `MyOrientoinListener myOrientoinListener = this.myOrientoinListener`  L412
- `int i2 = 0`  L429

方法（54）：
- `boolean getAllSelfPermission()`  L83
- `void showPermissionDialogWarn()`  L91
- `void onClick(DialogInterface dialogInterface, int i)`  L97 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L103 @Override
- `void updateLanguage()`  L110
- `void checkLicenseAgreement(Context context)`  L139
    - 体内字面量："appData" · "agreeLicenseAgreement" · "showLicenseAgreementDialog isAgreeLicenseAgreement=" · "agreeLicenseAgreementVersion" · "showLicenseAgreementDialog Version ="
- `void closeLicenseAgreementDialog()`  L151
- `void fragmentPopStackOfAll()`  L160 @Override
- `void m560lambda$onCreate$0$comicatchgoliveuiactivityLaunchActivity(View view)`  L173
- `void m561lambda$onCreate$1$comicatchgoliveuiactivityLaunchActivity(View view)`  L178
- `void m562lambda$onCreate$2$comicatchgoliveuiactivityLaunchActivity(View view)`  L184
    - 体内字面量："CUR_POSITION"
- `void m563lambda$onCreate$3$comicatchgoliveuiactivityLaunchActivity(View view)`  L198
    - 体内字面量："CUR_POSITION"
- `void m564xa7ef2ded(DialogInterface dialogInterface, int i)`  L212
    - 体内字面量："PERM" · "start to request All permission"
- `void loadDefaultLocalPhotoThumbnail()`  L219 @Override
- `void loadDefaultLocalVideoThumbnail()`  L224 @Override
- `void onClick(View view)`  L229 @Override
    - 体内字面量："click info:::v.getId() =" · "click info:::R.id.local_photo =" · "click info:::R.id.local_video =" · "click the local photo" · "CUR_POSITION" · "click the local video" · "CUR_POSITION"
- `void onCreate(Bundle bundle)`  L251 @Override
- `void onClick(View view)`  L258 @Override
- `void onClick(View view)`  L264 @Override
- `void onClick(View view)`  L270 @Override
- `void onClick(View view)`  L276 @Override
- `boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j)`  L298 @Override
- `void onItemClick(AdapterView<?> adapterView, View view, int i, long j)`  L305 @Override
- `void onSure()`  L311 @Override
    - 体内字面量："PERM" · "wait! when click this page button, start to request All permission" · "PERM" · "MANAGE_EXTERNAL_STORAGE=" · "PERM" · "MANAGE_EXTERNAL_STORAGE=" · "android.permission.MANAGE_EXTERNAL_STORAGE" · "PERM" · "WRITE_EXTERNAL_STORAGE=" · "android.permission.WRITE_EXTERNAL_STORAGE" · "PERM" · "ACCESS_FINE_LOCATION=" · "android.permission.ACCESS_FINE_LOCATION" · "PERM" · "READ_EXTERNAL_STORAGE=" · "android.permission.READ_EXTERNAL_STORAGE" · "end onCreate"
- `boolean onCreateOptionsMenu(Menu menu)`  L350 @Override
- `void onDestroy()`  L355 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L364 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back" · "AppStart" · "KEYCODE_MENU"
- `boolean onOptionsItemSelected(MenuItem menuItem)`  L382 @Override
    - 体内字面量："id =" · "R.id.action_search ="
- `void onPause()`  L409 @Override
    - 体内字面量："onPause"
- `boolean onPrepareOptionsMenu(Menu menu)`  L420 @Override
    - 体内字面量："onPrepareOptionsMenu"
- `void onRequestPermissionsResult(int i, String[] strArr, int[] iArr)`  L427 @Override
- `void onResume()`  L464 @Override
    - 体内字面量："Start onResume" · "accelerometer_rotation" · "End onResume"
- `void onStart()`  L485 @Override
    - 体内字面量："onStart"
- `void onStop()`  L491 @Override
    - 体内字面量："onStop"
- `void removeFragment()`  L499 @Override
- `void setBackBtnVisibility(boolean z)`  L515 @Override
- `void setLaunchLayoutVisibility(int i)`  L519 @Override
- `void setLaunchSettingFrameVisibility(int i)`  L525 @Override
- `void setListviewAdapter(CameraSlotAdapter cameraSlotAdapter)`  L530 @Override
- `void setLocalPhotoThumbnail(Bitmap bitmap)`  L535 @Override
- `void setLocalPhotoThumbnail(String str)`  L540 @Override
- `void setLocalVideoThumbnail(Bitmap bitmap)`  L545 @Override
- `void setLocalVideoThumbnail(String str)`  L550 @Override
- `void setNavigationTitle(int i)`  L555 @Override
- `void setNavigationTitle(String str)`  L559 @Override
- `void setNoPhotoFilesFoundVisibility(int i)`  L563 @Override
- `void setNoVideoFilesFoundVisibility(int i)`  L568 @Override
- `void setPhotoClickable(boolean z)`  L573 @Override
- `void setVideoClickable(boolean z)`  L579 @Override
- `void showLicenseAgreementDialog(final Context context, final String str)`  L584
- `void onClick(View view)`  L591 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L603 @Override
    - 体内字面量："appData" · "agreeLicenseAgreement" · "agreeLicenseAgreementVersion"
- `void onClick(DialogInterface dialogInterface, int i)`  L614 @Override
- `void submitFragmentInfo(String str, int i)`  L625 @Override
### `com.icatch.golive.ui.activity.LaunchHelpActivity`
L11 · [class] public LaunchHelpActivity · extends `AppCompatActivity` · `com/icatch/golive/ui/activity/LaunchHelpActivity.java`

字段/常量（1）：
- `String TAG = "LaunchHelpActivity"`  L12

方法（3）：
- `void onCreate(Bundle bundle)`  L15 @Override
- `boolean onCreateOptionsMenu(Menu menu)`  L25 @Override
- `boolean onOptionsItemSelected(MenuItem menuItem)`  L30 @Override
### `com.icatch.golive.ui.activity.LdeviceSettingActivity`
L42 · [class] public LdeviceSettingActivity · extends `AppCompatActivity` · `com/icatch/golive/ui/activity/LdeviceSettingActivity.java`

字段/常量（70）：
- `boolean $assertionsDisabled = false`  L43
- `String TAG = "LdeviceSettingActivity"`  L44
- `String currentDevicePWD`  L45
- `String currentDeviceSSID`  L46
- `String[] g_sensor_arr`  L47
- `String kGSensorHigh`  L48
- `String kGSensorLow`  L49
- `String kGSensorMed`  L50
- `String kGSensorOFF`  L51
- `String kMicrophoneModeHeadphone`  L52
- `String kMicrophoneModeNoumenon`  L53
- `LdeviceSettingAdapter mAdapter`  L54
- `String[] microphone_mode_arr`  L55
- `RecyclerView rv_settings`  L56
- `TextView tv_device_name`  L57
- `TextView tv_device_pwd`  L58
- `String[] video_definition_arr = {"2160p@30fps", "1440p@30fps", "1080p@60fps", "1080p@30fps", "720p@60fps", "720p@30fps"}`  L59
- `String[] video_definition_index_arr = {"1", "6", "10", "11", "14", "15"}`  L60
- `String kPhoto12M = "12M"`  L61
- `String kPhoto10M = "10M"`  L62
- `String kPhoto8M = "8M"`  L63
- `String kPhoto5M = "5M"`  L64
- `String[] photo_definition_arr = {"12M", "10M", "8M", "5M"}`  L65
- `String[] duration_index_arr = {AppEventsConstants.EVENT_PARAM_VALUE_NO, "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D}`  L66
- `String[] duration_arr = {"OFF", "1 MIN", "3 MIN", "5 MIN"}`  L67
- `String cmd2002status = "2002"`  L68
- `String cmd2003status = "2003"`  L69
- `String cmd2008status = "2008"`  L70
- `String cmd2011status = "2011"`  L71
- `String cmd3044status = "3044"`  L72
- `String cmd8010status = "8010"`  L73
- `String cmd8011status = "8011"`  L74
- `String cmd8012status = "8012"`  L75
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L152
- `LdeviceSettingActivity ldeviceSettingActivity2 = LdeviceSettingActivity.this`  L157
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L177
- `LdeviceSettingActivity ldeviceSettingActivity2 = LdeviceSettingActivity.this`  L182
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L205
- `LdeviceSettingActivity ldeviceSettingActivity2 = LdeviceSettingActivity.this`  L209
- `String str2 = RequestInfo.urlMovieRecordSizeCustom + str`  L237
- `String str`  L313
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L316
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L339
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L363
- `LdeviceSettingActivity ldeviceSettingActivity2 = LdeviceSettingActivity.this`  L369
- `LdeviceSettingActivity ldeviceSettingActivity3 = LdeviceSettingActivity.this`  L372
- `LdeviceSettingActivity ldeviceSettingActivity4 = LdeviceSettingActivity.this`  L375
- `LdeviceSettingActivity ldeviceSettingActivity5 = LdeviceSettingActivity.this`  L379
- `LdeviceSettingActivity ldeviceSettingActivity6 = LdeviceSettingActivity.this`  L384
- `LdeviceSettingActivity ldeviceSettingActivity7 = LdeviceSettingActivity.this`  L389
- `LdeviceSettingActivity ldeviceSettingActivity8 = LdeviceSettingActivity.this`  L394
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L409
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L438
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L459
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L622
- `String str = this.cmd8012status`  L679
- `String str`  L694
- `String str2 = this.cmd8010status`  L695
- `String str3 = this.cmd8012status`  L697
- `String str4 = this.cmd8010status`  L702
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L719
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L736
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L752
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L769
- `LdeviceSettingActivity ldeviceSettingActivity = LdeviceSettingActivity.this`  L854
- `int i = 0`  L866
- `String[] strArr = this.duration_index_arr`  L868
- `int i = 0`  L880
- `String[] strArr = this.video_definition_index_arr`  L882
- `String str = this.cmd8012status`  L953

方法（95）：
- `void change8010AfterRefreshState()`  L145
    - 体内字面量："8011"
- `void handleMessage(Message message)`  L149 @Override
- `void changeDeviceName(String str, final String str2)`  L171
    - 体内字面量：" " · "%C2%A0"
- `void handleMessage(Message message)`  L174 @Override
- `void changeDevicePWD(String str)`  L195
- `void handleMessage(Message message)`  L202 @Override
- `void changeRecordDuration(String str)`  L218
- `void handleMessage(Message message)`  L222 @Override
- `void changeVideoDefinition(final String str)`  L236
- `void handleMessage(Message message)`  L241 @Override
    - 体内字面量："2002" · "2002"
- `void changeonGSensor(String str)`  L258
- `void changeonMicrophoneMode(String str)`  L263
- `void confirmFormatDevice()`  L268
- `void handleMessage(Message message)`  L272 @Override
- `void confirmReconnect()`  L286
- `void confirmResetDevice()`  L290
- `void handleMessage(Message message)`  L294 @Override
- `void getDeviceFreeSpace()`  L309
- `void handleMessage(Message message)`  L312 @Override
- `void getDeviceInfo()`  L333
- `void handleMessage(Message message)`  L336 @Override
- `void getDeviceStatus()`  L357
- `void handleMessage(Message message)`  L360 @Override
- `void getDeviceVersionInfo()`  L401
- `void handleMessage(Message message)`  L404 @Override
    - 体内字面量："String" · "String"
- `void getHeadphoneState()`  L417
- `void handleMessage(Message message)`  L420 @Override
    - 体内字面量："String" · "String"
- `void getMenuConfigInfo()`  L432
- `void handleMessage(Message message)`  L435 @Override
- `void getVideoDefinitionConfigInfo()`  L453
- `void handleMessage(Message message)`  L456 @Override
- `void handleDeviceNamePwd(String str, String str2, AlertDialog alertDialog)`  L469
- `void handleList3030(List<String> list)`  L494
- `void handleMap2003(Map<String, String> map)`  L507
- `void initData()`  L523
- `void initEvent()`  L530
- `void onClick(View view)`  L533 @Override
- `void onClick(View view)`  L539 @Override
- `void onClick(View view)`  L545 @Override
- `void onClick(View view)`  L551 @Override
- `void initView()`  L557
- `void didClickCell(int i)`  L576 @Override
- `void didSwitchCell(int i, CompoundButton compoundButton, boolean z)`  L595 @Override
    - 体内字面量："1" · "1" · "3044"
- `void onBack()`  L636
- `void handleMessage(Message message)`  L640 @Override
- `void onChangeRecordDuration()`  L648
- `void onClick(DialogInterface dialogInterface, int i)`  L651 @Override
- `void onChangeVideoDefinition()`  L658
- `void onClick(DialogInterface dialogInterface, int i)`  L661 @Override
- `void onGSensor()`  L668
- `void onClick(DialogInterface dialogInterface, int i)`  L671 @Override
- `void onMicrophoneMode()`  L678
- `void onClick(DialogInterface dialogInterface, int i)`  L685 @Override
- `void onRecordAudio()`  L693
- `void onSwitchLensRotation(String str)`  L712
- `void handleMessage(Message message)`  L716 @Override
- `void onSwitchRecordAudio(String str)`  L728
- `void handleMessage(Message message)`  L732 @Override
- `void onSwitchTimeImprint(String str)`  L744
- `void handleMessage(Message message)`  L748 @Override
- `void reconnectWiFi()`  L760
- `void handleMessage(Message message)`  L763 @Override
- `void setDuration_arr(String[] strArr)`  L776
- `void showDeviceFormatDialog()`  L780
- `void onClick(DialogInterface dialogInterface, int i)`  L786 @Override
- `void showDeviceNamePwdDialog()`  L793
- `void onClick(View view)`  L808 @Override
- `void onClick(View view)`  L814 @Override
- `void showDeviceResetDialog()`  L820
- `void onClick(DialogInterface dialogInterface, int i)`  L826 @Override
- `void showReconnectDialog()`  L834
- `void onClick(DialogInterface dialogInterface, int i)`  L839 @Override
- `void startMovieRecord()`  L848
- `void handleMessage(Message message)`  L851 @Override
- `String getDuration_text()`  L865
- `String getVideoDefinition_text()`  L879
- `void m565x91a21db7(View view)`  L894
- `void m566xabbd9c56(View view)`  L899
- `void m567xc5d91af5(View view)`  L904
- `void m568xdff49994(View view)`  L909
- `void m569x8f5b28ed(DialogInterface dialogInterface, int i)`  L914
- `void m570xd769675b(DialogInterface dialogInterface, int i)`  L921
- `void m571xb23952f7(DialogInterface dialogInterface, int i)`  L927
    - 体内字面量："1" · "4"
- `void m572xdcf2c3b2(DialogInterface dialogInterface, int i)`  L948
- `void m573x969b22bc(DialogInterface dialogInterface, int i)`  L965
- `void m574xb8384b35(EditText editText, EditText editText2, AlertDialog alertDialog, View view)`  L970
- `void m575x30a38913(DialogInterface dialogInterface, int i)`  L975
- `void m576x86e45770(DialogInterface dialogInterface, int i)`  L980
- `void onCreate(Bundle bundle)`  L985 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L994 @Override
- `void onTrimMemory(int i)`  L1003 @Override
- `void handleMessage(Message message)`  L1008 @Override
- `void handleMessage(Message message2)`  L1012 @Override
- `void handleMessage(Message message3)`  L1016 @Override
- `void handleMessage(Message message4)`  L1020 @Override
### `com.icatch.golive.ui.activity.LdeviceSettingActivity$AnonymousClass17`
L78 · [class] AnonymousClass17 · extends `Handler` · `com/icatch/golive/ui/activity/LdeviceSettingActivity.java`

方法（3）：
- `void handleMessage(Message message)`  L84 @Override
- `void run()`  L94 @Override
- `void m577x399957c8(String str)`  L101
### `com.icatch.golive.ui.activity.LdeviceSettingActivity$AnonymousClass18`
L108 · [class] AnonymousClass18 · extends `Handler` · `com/icatch/golive/ui/activity/LdeviceSettingActivity.java`

方法（3）：
- `void handleMessage(Message message)`  L114 @Override
- `void run()`  L127 @Override
- `void m578x399957c9(String str)`  L134
    - 体内字面量："1"
### `com.icatch.golive.ui.activity.LicenseAgreementActivity`
L11 · [class] public LicenseAgreementActivity · extends `AppCompatActivity` · `com/icatch/golive/ui/activity/LicenseAgreementActivity.java`

方法（3）：
- `void onCreate(Bundle bundle)`  L13 @Override
- `boolean onCreateOptionsMenu(Menu menu)`  L23 @Override
- `boolean onOptionsItemSelected(MenuItem menuItem)`  L28 @Override
### `com.icatch.golive.ui.activity.LocalMultiPbActivity`
L26 · [class] public LocalMultiPbActivity · extends `BaseActivity implements LocalMultiPbView` · implements `LocalMultiPbView` · `com/icatch/golive/ui/activity/LocalMultiPbActivity.java`

字段/常量（7）：
- `String TAG = "LocalMultiPbActivity"`  L27
- `MenuItem menuPhotoWallType`  L28
- `LocalMultiPbPresenter presenter`  L29
- `TabLayout tabLayout`  L30
- `TextView tv_select_all`  L31
- `TextView tv_selector`  L32
- `ViewPager viewPager`  L33

方法（23）：
- `void initTitle()`  L35
    - 体内字面量：" (" · ")" · " (" · ")"
- `void m579xac990ade(View view)`  L46
- `void m580xda71a53d(View view)`  L51
- `void m581x84a3f9c(View view)`  L63
- `void onCreate(Bundle bundle)`  L72 @Override
- `void onClick(View view)`  L80 @Override
- `void onClick(View view)`  L88 @Override
- `void onClick(View view)`  L96 @Override
- `void onPageScrollStateChanged(int i)`  L107 @Override
- `void onPageScrolled(int i, float f, int i2)`  L111 @Override
- `void onPageSelected(int i)`  L115 @Override
    - 体内字面量："mScroller" · "FixedSpeedScroller Exception"
- `boolean onCreateOptionsMenu(Menu menu)`  L133 @Override
- `void onDestroy()`  L139 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L146 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `void onManualSelectedAll(boolean z)`  L159
- `boolean onOptionsItemSelected(MenuItem menuItem)`  L168 @Override
- `void onResume()`  L181 @Override
    - 体内字面量："onResume()"
- `void onStop()`  L188 @Override
- `void setMenuPhotoWallTypeIcon(int i)`  L193 @Override
- `void setTabLayoutClickable(boolean z)`  L198 @Override
    - 体内字面量："setTabLayoutClickable value="
- `void setViewPageAdapter(FragmentPagerAdapter fragmentPagerAdapter)`  L212 @Override
- `void setViewPageCurrentItem(int i)`  L217 @Override
    - 体内字面量："setViewPageCurrentItem item="
- `void setViewPagerScanScroll(boolean z)`  L223 @Override
### `com.icatch.golive.ui.activity.LocalPhotoPbActivity`
L25 · [class] public LocalPhotoPbActivity · extends `BaseActivity implements LocalPhotoPbView` · implements `LocalPhotoPbView` · `com/icatch/golive/ui/activity/LocalPhotoPbActivity.java`

字段/常量（14）：
- `String TAG = "LocalPhotoPbActivity"`  L26
- `ImageButton back`  L27
- `LinearLayout bottomBar`  L28
- `ImageButton deleteBtn`  L29
- `ImageButton doNext`  L30
- `ImageButton doPrevious`  L31
- `TextView indexInfoTxv`  L32
- `SurfaceView mSurfaceView`  L33
- `ImageButton panoramaTypeBtn`  L34
- `ImageButton photoInfoBtn`  L35
- `LocalPhotoPbPresenter presenter`  L36
- `ImageButton shareBtn`  L37
- `RelativeLayout topBar`  L38
- `HackyViewPager viewPager`  L39

方法（31）：
- `int getTopBarVisibility()`  L42 @Override
- `int getViewPagerCurrentItem()`  L47 @Override
- `void onCreate(Bundle bundle)`  L52 @Override
    - 体内字面量："onCreate"
- `void onClick(View view)`  L76 @Override
- `void onClick(View view)`  L82 @Override
- `void onClick(View view)`  L88 @Override
- `void onClick(View view)`  L94 @Override
- `void onClick(View view)`  L100 @Override
- `void onClick(View view)`  L106 @Override
    - 体内字面量："....doPrevious"
- `void onClick(View view)`  L113 @Override
    - 体内字面量："....doNext"
- `void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3)`  L120 @Override
    - 体内字面量："surfaceChanged........width="
- `void surfaceCreated(SurfaceHolder surfaceHolder)`  L126 @Override
    - 体内字面量："surfaceCreated"
- `void surfaceDestroyed(SurfaceHolder surfaceHolder)`  L133 @Override
    - 体内字面量："surfaceDestroyed"
- `boolean onTouch(View view, MotionEvent motionEvent)`  L140 @Override
- `void onClick(View view)`  L158 @Override
    - 体内字面量："viewPager.setOnClickListener"
- `void onDestroy()`  L166 @Override
    - 体内字面量："onDestroy"
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L173 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `void onPause()`  L187 @Override
- `void onResume()`  L193 @Override
    - 体内字面量："onResume"
- `void onStart()`  L202 @Override
    - 体内字面量："onStart"
- `void onStop()`  L208 @Override
    - 体内字面量："onStop"
- `void setBottomBarVisibility(int i)`  L215 @Override
- `void setIndexInfoTxv(String str)`  L220 @Override
- `void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener)`  L225 @Override
- `void setPanoramaTypeBtnImg(int i)`  L230 @Override
- `void setPanoramaTypeBtnVisibility(int i)`  L235 @Override
- `void setSurfaceviewVisibility(int i)`  L240 @Override
- `void setTopBarVisibility(int i)`  L247 @Override
- `void setViewPagerAdapter(PagerAdapter pagerAdapter)`  L252 @Override
- `void setViewPagerCurrentItem(int i)`  L259 @Override
- `void setViewPagerVisibility(int i)`  L264 @Override
### `com.icatch.golive.ui.activity.LocalVideoPbActivity`
L27 · [class] public LocalVideoPbActivity · extends `BaseActivity implements LocalVideoPbView` · implements `LocalVideoPbView` · `com/icatch/golive/ui/activity/LocalVideoPbActivity.java`

字段/常量（20）：
- `ImageButton back`  L28
- `LinearLayout bottomBar`  L29
- `ImageButton cancelBtn`  L30
- `TextView codecInfoTxv`  L31
- `Switch eisSwitch`  L32
- `TextView localVideoNameTxv`  L33
- `SurfaceView mSurfaceViewImage`  L34
- `ImageButton moreBtn`  L35
- `LinearLayout moreSettingLayout`  L36
- `ImageButton panoramaTypeBtn`  L37
- `ImageButton play`  L38
- `LocalVideoPbPresenter presenter`  L39
- `ProgressWheel progressWheel`  L40
- `SeekBar seekBar`  L41
- `TextView timeDuration`  L42
- `TextView timeLapsed`  L43
- `RelativeLayout topBar`  L44
- `String videoPath`  L45
- `String TAG = "LocalVideoPbActivity"`  L46
- `boolean isShowBar = true`  L47

方法（45）：
- `int getSeekBarProgress()`  L50 @Override
- `int getSurfaceViewHeight()`  L55 @Override
- `int getSurfaceViewWidth()`  L60 @Override
- `void onConfigurationChanged(Configuration configuration)`  L65 @Override
- `void run()`  L69 @Override
    - 体内字面量："onConfigurationChanged newConfig Orientation="
- `void onCreate(Bundle bundle)`  L77 @Override
- `void onClick(View view)`  L96 @Override
    - 体内字面量："curfilePath" · "videoPath="
- `void onClick(View view)`  L110 @Override
    - 体内字面量："mSurfaceViewImage ClickListener"
- `void onClick(View view)`  L117 @Override
- `void onClick(View view)`  L123 @Override
- `void onProgressChanged(SeekBar seekBar, int i, boolean z)`  L129 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L134 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L139 @Override
    - 体内字面量："mSurfaceView = "
- `void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3)`  L146 @Override
- `void surfaceCreated(SurfaceHolder surfaceHolder)`  L151 @Override
- `void surfaceDestroyed(SurfaceHolder surfaceHolder)`  L157 @Override
    - 体内字面量：" 12233 surfaceDestroyed"
- `boolean onTouch(View view, MotionEvent motionEvent)`  L164 @Override
- `void onClick(View view)`  L186 @Override
- `void onClick(View view)`  L192 @Override
- `void onClick(View view)`  L198 @Override
- `void onDestroy()`  L205 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L211 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `void onResume()`  L225 @Override
- `void onStop()`  L231 @Override
- `void setBottomBarVisibility(int i)`  L236 @Override
- `void setCodecInfoTxv(String str)`  L241 @Override
- `void setEisSwitchChecked(boolean z)`  L249 @Override
- `void setLoadPercent(int i)`  L254 @Override
    - 体内字面量："%"
- `void setMoreSettingLayoutVisibility(int i)`  L261 @Override
- `void setPanoramaTypeBtnVisibility(int i)`  L266 @Override
- `void setPanoramaTypeImageResource(int i)`  L271 @Override
- `void setPlayBtnSrc(int i)`  L276 @Override
- `void setProgress(float f)`  L281 @Override
- `void setSeekBarMaxValue(int i)`  L285 @Override
- `void setSeekBarProgress(int i)`  L290 @Override
- `void setSeekBarSecondProgress(int i)`  L295 @Override
- `void setTimeDurationValue(String str)`  L300 @Override
- `void setTimeLapsedValue(String str)`  L305 @Override
- `void setTopBarVisibility(int i)`  L310 @Override
- `void setVideoNameTxv(String str)`  L315 @Override
- `void setZoomMaxValue(float f)`  L320 @Override
- `void setZoomMinValue(float f)`  L324 @Override
- `void showLoadingCircle(boolean z)`  L328 @Override
    - 体内字面量："showLoadingCircle isShow=" · "0%"
- `void showZoomView(int i)`  L341 @Override
- `void updateZoomRateTV(float f)`  L345 @Override
### `com.icatch.golive.ui.activity.LocalVideoPlayerActivity`
L14 · [class] public LocalVideoPlayerActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/LocalVideoPlayerActivity.java`

字段/常量（3）：
- `String kVideoPlayTitle = "VideoPlayTitle"`  L15
- `String kVideoPlayURL = "VideoPlayURL"`  L16
- `JzvdStd jzvdStd`  L17

方法（7）：
- `void initDataAndView()`  L19
    - 体内字面量："VideoPlayURL" · "VideoPlayTitle"
- `void onClick(View view)`  L24 @Override
- `void m582x8238a6a2(View view)`  L35
- `void onBackPressed()`  L40 @Override
- `void onCreate(Bundle bundle)`  L48 @Override
- `boolean onOptionsItemSelected(MenuItem menuItem)`  L57 @Override
- `void onPause()`  L65 @Override
### `com.icatch.golive.ui.activity.LoginFacebookActivity`
L17 · [class] public LoginFacebookActivity · extends `Activity` · `com/icatch/golive/ui/activity/LoginFacebookActivity.java`

字段/常量（5）：
- `String TAG = "LoginFacebookActivity"`  L18
- `CallbackManager callbackManager`  L19
- `Intent intent`  L20
- `LoginButton loginButton`  L21
- `LoginFacebookActivity loginFacebookActivity = LoginFacebookActivity.this`  L56

方法（5）：
- `void onActivityResult(int i, int i2, Intent intent)`  L24 @Override
    - 体内字面量："request: " · ",  resultCode: " · ", data: "
- `void onCreate(Bundle bundle)`  L31 @Override
    - 体内字面量："manage_pages" · "publish_pages" · "publish_actions"
- `void onCancel()`  L40 @Override
- `void onError(FacebookException facebookException)`  L45 @Override
- `void onSuccess(LoginResult loginResult)`  L50 @Override
    - 体内字面量："FacebookCallback onSuccess" · "FacebookCallback getPermissions" · "FacebookCallback loginResult.getAccessToken().getDeclinedPermissions()=" · "FacebookCallback loginResult.getRecentlyGrantedPermissions()=" · "FacebookCallback loginResult.getRecentlyDeniedPermissions()="
### `com.icatch.golive.ui.activity.LoginGoogleActivity`
L37 · [class] public LoginGoogleActivity · extends `AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener` · implements `GoogleApiClient.OnConnectionFailedListener, View.OnClickListener` · `com/icatch/golive/ui/activity/LoginGoogleActivity.java`

字段/常量（14）：
- `int RC_GET_AUTH_CODE = 9003`  L38
- `String TAG = "LoginGoogleActivity"`  L39
- `Activity activity`  L40
- `String directoryPath`  L41
- `Intent intent`  L42
- `TextView mAuthCodeTextView`  L43
- `GoogleApiClient mGoogleApiClient`  L44
- `String authCode = "<binary/metadata>"`  L45
- `String refreshToken = "<binary/metadata>"`  L46
- `String accessToken = "<binary/metadata>"`  L47
- `String fileName = AppInfo.FILE_GOOGLE_TOKEN`  L49
- `String str = "<binary/metadata>"`  L53
- `String str = "<binary/metadata>"`  L76
- `LoginGoogleActivity loginGoogleActivity = LoginGoogleActivity.this`  L202

方法（20）：
- `String getAccessTokenFromJson(JSONObject jSONObject)`  L51
    - 体内字面量："getAccessTokenFromJson jsonObject="
- `void getAuthCode()`  L70
- `String getRefreshTokenFromJson(JSONObject jSONObject)`  L74
    - 体内字面量："getRefreshTokenFromJson jsonObject="
- `void handleSignInResult(GoogleSignInResult googleSignInResult)`  L94
    - 体内字面量："handleSignInResult:"
- `String refreshAccessToken(String str, String str2, String str3)`  L105
- `void revokeAccess()`  L113
- `void onResult(Status status)`  L116 @Override
    - 体内字面量："revokeAccess:onResult:"
- `void signOut()`  L126
- `void onResult(Status status)`  L129 @Override
    - 体内字面量："signOut:onResult:"
- `void updateUI(boolean z)`  L140
    - 体内字面量："null"
- `void validateServerClientID()`  L153
- `void getToken(String str)`  L156
- `void onActivityResult(int i, int i2, Intent intent)`  L160 @Override
    - 体内字面量："onActivityResult..." · "onActivityResult:GET_AUTH_CODE:success:" · "getToken..."
- `void onClick(View view)`  L181 @Override
- `void run()`  L199 @Override
    - 体内字面量："Start refreshAccessToken"
- `void run()`  L206 @Override
    - 体内字面量："RefreshToken:" · "\nAccessToken:" · "End refreshAccessToken accessToken=" · "refreshAccessToken IOException="
- `void onConnectionFailed(ConnectionResult connectionResult)`  L222 @Override
    - 体内字面量："onConnectionFailed:"
- `void onCreate(Bundle bundle)`  L227 @Override
    - 体内字面量："https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/user.birthday.read https://www.googleapis.com/auth/youtube"
- `void onStart()`  L243 @Override
    - 体内字面量："Got cached sign-in"
- `void onResult(GoogleSignInResult googleSignInResult)`  L253 @Override
### `com.icatch.golive.ui.activity.LYDownloadFileActivity`
L35 · [class] public LYDownloadFileActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/LYDownloadFileActivity.java`

字段/常量（17）：
- `String TAG = "LYDownloadFileActivity"`  L36
- `String kDownloadFileType = "DownloadFileType"`  L37
- `String kDownloadFiles = "DownloadFiles"`  L38
- `OkHttpDownUtil currentDownloadingObj`  L39
- `List<FileInfo> list_files`  L40
- `LYDownloadFileAdapter mAdapter`  L41
- `Handler mainHandler`  L42
- `AlertDialog myDialog`  L43
- `RecyclerView rv_remote_files`  L44
- `String saveFilePath`  L45
- `String currentFileType = "<binary/metadata>"`  L46
- `int current_download_index = 0`  L47
- `int failure_tyr_count = 0`  L48
- `int current_progress = 0`  L49
- `int i = lYDownloadFileActivity.failure_tyr_count`  L160
- `int i = this.current_download_index`  L226
- `AlertDialog alertDialog = this.myDialog`  L273

方法（21）：
- `int access$008(LYDownloadFileActivity lYDownloadFileActivity)`  L159
- `void downloadFiles(FileInfo fileInfo)`  L166
- `void initData()`  L173
    - 体内字面量："/DCIM/idGoLive/photo/"
- `void initView()`  L189
- `void onClick(View view)`  L192 @Override
- `void loadData()`  L205
- `void run()`  L210 @Override
- `void saveToAlbum(final File file, FileInfo fileInfo)`  L217
- `void run()`  L220 @Override
- `void run()`  L230 @Override
- `void showBackAlertDialog()`  L239
- `void onClick(DialogInterface dialogInterface, int i)`  L245 @Override
- `void m534xea381dd5(View view)`  L255
- `void m535xc4272839()`  L260
- `void m536x2217df0b(File file)`  L265
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `void m537x3c335daa()`  L272
- `void m538xfc946c00(DialogInterface dialogInterface, int i)`  L282
- `void onCreate(Bundle bundle)`  L288 @Override
- `void onDestroy()`  L298 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L305 @Override
- `void onTrimMemory(int i)`  L314 @Override
### `com.icatch.golive.ui.activity.LYDownloadFileActivity$AnonymousClass1`
L52 · [class] AnonymousClass1 · implements `HttpDownListener` · `com/icatch/golive/ui/activity/LYDownloadFileActivity.java`

字段/常量（4）：
- `FileInfo val$item`  L53
- `File val$mFile`  L54
- `LYDownloadFileActivity lYDownloadFileActivity = LYDownloadFileActivity.this`  L63
- `LYDownloadFileActivity lYDownloadFileActivity = LYDownloadFileActivity.this`  L70

方法（12）：
- `void m539xa64e66a6()`  L62
- `void m540xa784b985()`  L69
- `void m541xfb2e7915(int i)`  L75
- `void m542xfc64cbf4(int i)`  L80
- `void onFailure(Call call, IOException iOException)`  L85 @Override
    - 体内字面量："downloadFiles" · "IOException = "
- `void run()`  L91 @Override
    - 体内字面量："downloadFiles" · "failure_tyr_count = "
- `void run()`  L99 @Override
- `void onResponse(Call call, Response response, long j, long j2)`  L107 @Override
- `void run()`  L117 @Override
- `void run()`  L124 @Override
    - 体内字面量："downloadFiles" · "mTotalLength = " · "; mAlreadyDownLength = " · "; index = " · "; progress = " · ".TS" · ".ts" · ".TS" · ".MP4" · ".ts" · ".MP4" · "willMP4File exists, is deleted => "
- `void onFailed()`  L145 @Override
    - 体内字面量："convertTStoMP4 onFailed"
- `void onSuccess()`  L150 @Override
    - 体内字面量："mFile isDeleted = "
### `com.icatch.golive.ui.activity.LYLiveVideoActivity`
L54 · [class] public LYLiveVideoActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/LYLiveVideoActivity.java`

字段/常量（30）：
- `String TAG = "LYLiveVideoActivity"`  L55
- `boolean isFrontCamLive = true`  L56
- `ImageButton ib_live`  L57
- `ImageButton ib_video_zoom`  L58
- `ImageView iv_battery_state`  L59
- `EmptyControlVideo livePlayer`  L60
- `int music`  L61
- `SoundPool sp_shutter`  L62
- `Timer timer`  L63
- `TransitionDrawable transitionDrawable`  L64
- `TextView tv_fps`  L65
- `TextView tv_recording_time`  L66
- `TextView tv_resolution`  L67
- `TextView tv_video_state`  L68
- `boolean isFullscreen = false`  L69
- `long timerPeriod = 360000`  L70
- `boolean isRecording = false`  L71
- `BroadcastReceiver receiver = null`  L72
- `int current_record_duration = 0`  L73
- `boolean isTimer = false`  L74
- `LYLiveVideoActivity lYLiveVideoActivity = LYLiveVideoActivity.this`  L369
- `boolean z = !isFrontCamLive`  L503
- `String str = z ? M1RequestInfo.urlSwitchFrontCam : M1RequestInfo.urlSwitchBackCam`  L505
- `LYLiveVideoActivity lYLiveVideoActivity = LYLiveVideoActivity.this`  L526
- `boolean z = !this.isRecording`  L537
- `LYLiveVideoActivity lYLiveVideoActivity = LYLiveVideoActivity.this`  L553
- `LYLiveVideoActivity lYLiveVideoActivity = LYLiveVideoActivity.this`  L575
- `LYLiveVideoActivity lYLiveVideoActivity = LYLiveVideoActivity.this`  L591
- `LYLiveVideoActivity lYLiveVideoActivity = LYLiveVideoActivity.this`  L613
- `Timer timer = this.timer`  L761

方法（54）：
- `void run()`  L78 @Override
- `void getBatteryState()`  L244
- `void getDataRefreshUI()`  L251
- `void getLiveState()`  L257
- `void handleMessage(Message message)`  L260 @Override
- `void getRecResolution()`  L273
- `void handleMessage(Message message)`  L276 @Override
- `void handleReceivedMessage(String str, int i)`  L295
    - 体内字面量："3020" · "onReceive LySocketClient str_cmd = " · "; status = "
- `void initEvent()`  L316
- `void onClick(View view)`  L319 @Override
- `void onClick(View view)`  L325 @Override
- `boolean onTouch(View view, MotionEvent motionEvent)`  L332 @Override
- `void onClick(View view)`  L338 @Override
- `void onClick(View view)`  L344 @Override
- `void onClick(View view)`  L350 @Override
- `void onClick(View view)`  L356 @Override
- `void onClick(View view)`  L362 @Override
- `void onClick(View view)`  L368 @Override
- `void initLive()`  L402
- `void initView()`  L407
    - 体内字面量："QzIntegratedCircuit"
- `void handleMessage(Message message)`  L421 @Override
    - 体内字面量："info" · "camnum"
- `void keepRecordingCount()`  L440
- `void run()`  L448 @Override
- `void keepRecordingState()`  L457
- `void run()`  L462 @Override
- `void lambda$initEvent$2(View view)`  L469
    - 体内字面量："scaleX" · "scaleY"
- `boolean lambda$initEvent$3(final View view, MotionEvent motionEvent)`  L478
    - 体内字面量："scaleX" · "scaleY"
- `void run()`  L489 @Override
- `void onBack()`  L496
- `void onCameraConvert()`  L501
- `void handleMessage(Message message)`  L509 @Override
    - 体内字面量："onCameraConvert -> msg.obj:"
- `void onDeviceFiles()`  L517
    - 体内字面量："onDeviceFiles"
- `void handleMessage(Message message)`  L522 @Override
- `void onLive()`  L536
- `void handleMessage(Message message)`  L550 @Override
- `void onPhotograph()`  L568
- `void handleMessage(Message message)`  L572 @Override
- `void onSettings()`  L582
    - 体内字面量："onSettings"
- `void handleMessage(Message message)`  L587 @Override
- `void registerLocalReceiver()`  L607
- `void onReceive(Context context, Intent intent)`  L610 @Override
    - 体内字面量："Cmd" · "Status"
- `void unregisterLocalReceiver()`  L624
    - 体内字面量："unregisterLocalReceiver LySocketClient"
- `void m543x319fd17(View view)`  L633
- `void m544x46a51ad8(View view)`  L638
- `void m545x1146741b(View view)`  L653
- `void m546x54d191dc(View view)`  L661
- `void m547x985caf9d(View view)`  L666
- `void m548xdbe7cd5e(View view)`  L671
- `void m549x1f72eb1f(View view)`  L676
- `void onCreate(Bundle bundle)`  L681 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L691 @Override
- `void onStart()`  L704 @Override
    - 体内字面量："QzIntegratedCircuit" · "enable-accurate-seek" · "videotoolbox" · "rtsp_transport" · "tcp" · "network-caching" · "300" · "packet-buffering" · "skip_loop_filter" · "48" · "infbuf" · "analyzeduration" · "2000000" · "probesize" · "4096" · "low_pic" · "network-caching" · "clock-synchro" · "fast" · "probesize" · "flush_packets" · "packet-buffering" · "start-on-prepared" · "mediacodec" · "mediacodec-auto-rotate" · "mediacodec-handle-resolution-change" · "max-buffer-size" · "min-frames" · "max_cached_duration" · "infbuf" · "fflags" · "nobuffer" · "analyzedmaxduration" · "dns_cache_clear"
- `void onStop()`  L758 @Override
- `void onTrimMemory(int i)`  L773 @Override
    - 体内字面量："onTrimMemory TRIM_MEMORY_UI_HIDDEN ..."
### `com.icatch.golive.ui.activity.LYLiveVideoActivity$AnonymousClass11`
L85 · [class] AnonymousClass11 · extends `TimerTask` · `com/icatch/golive/ui/activity/LYLiveVideoActivity.java`

方法（4）：
- `void m550x8ca6324c()`  L90
- `void handleMessage(Message message)`  L93 @Override
    - 体内字面量："1" · "4"
- `void run()`  L118 @Override
- `void run()`  L121 @Override
### `com.icatch.golive.ui.activity.LYLiveVideoActivity$AnonymousClass8`
L129 · [class] AnonymousClass8 · implements `VideoAllCallBack` · `com/icatch/golive/ui/activity/LYLiveVideoActivity.java`

方法（25）：
- `void m551x77197996()`  L134
- `void onAutoComplete(String str, Object... objArr)`  L139 @Override
- `void onClickBlank(String str, Object... objArr)`  L143 @Override
- `void onClickBlankFullscreen(String str, Object... objArr)`  L147 @Override
- `void onClickResume(String str, Object... objArr)`  L151 @Override
- `void onClickResumeFullscreen(String str, Object... objArr)`  L155 @Override
- `void onClickSeekbar(String str, Object... objArr)`  L159 @Override
- `void onClickSeekbarFullscreen(String str, Object... objArr)`  L163 @Override
- `void onClickStartError(String str, Object... objArr)`  L167 @Override
- `void onClickStartIcon(String str, Object... objArr)`  L171 @Override
- `void onClickStartThumb(String str, Object... objArr)`  L175 @Override
- `void onClickStop(String str, Object... objArr)`  L179 @Override
- `void onClickStopFullscreen(String str, Object... objArr)`  L183 @Override
- `void onComplete(String str, Object... objArr)`  L187 @Override
- `void onEnterFullscreen(String str, Object... objArr)`  L191 @Override
- `void onEnterSmallWidget(String str, Object... objArr)`  L195 @Override
- `void onPlayError(String str, Object... objArr)`  L199 @Override
    - 体内字面量："setVideoAllCallBack => onPlayError"
- `void run()`  L203 @Override
- `void onPrepared(String str, Object... objArr)`  L210 @Override
- `void onQuitFullscreen(String str, Object... objArr)`  L220 @Override
- `void onQuitSmallWidget(String str, Object... objArr)`  L224 @Override
- `void onStartPrepared(String str, Object... objArr)`  L228 @Override
- `void onTouchScreenSeekLight(String str, Object... objArr)`  L232 @Override
- `void onTouchScreenSeekPosition(String str, Object... objArr)`  L236 @Override
- `void onTouchScreenSeekVolume(String str, Object... objArr)`  L240 @Override
### `com.icatch.golive.ui.activity.LYRemoteFileActivity`
L28 · [class] public LYRemoteFileActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/LYRemoteFileActivity.java`

字段/常量（11）：
- `String TAG = "LYRemoteFileActivity"`  L29
- `ViewPagerAdapter adapter`  L30
- `Button btn_emergency`  L31
- `Button btn_photo`  L32
- `Button btn_video`  L33
- `int currentSelectedPosition = 0`  L34
- `List<LYRemoteFileFragment> fragments`  L35
- `ViewPager mViewPage`  L36
- `TextView tv_selector`  L37
- `List<LYRemoteFileFragment> list = this.fragments`  L40
- `LYRemoteFileActivity lYRemoteFileActivity = LYRemoteFileActivity.this`  L150

方法（24）：
- `void initData()`  L39
- `void initEvent()`  L59
- `void onClick(View view)`  L62 @Override
- `void onClick(View view)`  L68 @Override
- `void onClick(View view)`  L76 @Override
- `void onClick(View view)`  L84 @Override
- `void onClick(View view)`  L92 @Override
- `void onPageScrollStateChanged(int i)`  L98 @Override
- `void onPageScrolled(int i, float f, int i2)`  L102 @Override
- `void onPageSelected(int i)`  L106 @Override
    - 体内字面量："onPageSelected position = "
- `void initView()`  L137
- `void onBack()`  L142
- `void handleMessage(Message message)`  L146 @Override
- `void clearDownloadState()`  L161
- `void m552x37b30538(View view)`  L166
- `void m553x658b9f97(View view)`  L171
- `void m554x936439f6(View view)`  L181
- `void m555xc13cd455(View view)`  L186
- `void m556xef156eb4(View view)`  L191
- `void onCreate(Bundle bundle)`  L196 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L206 @Override
- `void onManualSelectedAll(boolean z)`  L214
- `void onTrimMemory(int i)`  L218 @Override
- `void run()`  L223 @Override
### `com.icatch.golive.ui.activity.LYVideoPlayerActivity`
L22 · [class] public LYVideoPlayerActivity · extends `Activity` · `com/icatch/golive/ui/activity/LYVideoPlayerActivity.java`

字段/常量（12）：
- `String kVideoPlayTitle = "VideoPlayTitle"`  L23
- `String kVideoPlayURL = "VideoPlayURL"`  L24
- `String kVideoPlayUrlThumbnail = "VideoPlayUrlThumbnail"`  L25
- `LandLayoutVideo detail_player`  L26
- `Boolean isFullScreen = true`  L27
- `boolean isPause`  L28
- `boolean isPlay`  L29
- `OrientationUtils orientationUtils`  L30
- `String str_url`  L31
- `OrientationUtils orientationUtils = this.orientationUtils`  L107
- `OrientationUtils orientationUtils = this.orientationUtils`  L115
- `OrientationUtils orientationUtils = this.orientationUtils`  L147

方法（17）：
- `GSYVideoPlayer getCurPlay()`  L33
- `void initView()`  L37
    - 体内字面量："VideoPlayURL" · "VideoPlayTitle"
- `void onClick(View view)`  L42 @Override
    - 体内字面量："enable-accurate-seek" · "probesize" · "max-buffer-duration" · "min-frames"
- `void onPrepared(String str, Object... objArr)`  L64 @Override
- `void onQuitFullscreen(String str, Object... objArr)`  L71 @Override
- `void onClick(View view)`  L80 @Override
- `void onClick(View view, boolean z)`  L86 @Override
- `void m557xf75259a9(View view)`  L95
- `void m558x848d0b2a(View view)`  L100
- `void m559x11c7bcab(View view, boolean z)`  L106
- `void onBackPressed()`  L114 @Override
- `void onConfigurationChanged(Configuration configuration)`  L126 @Override
- `void onCreate(Bundle bundle)`  L135 @Override
- `void onDestroy()`  L142 @Override
- `void onPause()`  L154 @Override
- `void onResume()`  L161 @Override
- `void onTrimMemory(int i)`  L168 @Override
### `com.icatch.golive.ui.activity.PhotoPbActivity`
L23 · [class] public PhotoPbActivity · extends `AppCompatActivity implements PhotoPbView` · implements `PhotoPbView` · `com/icatch/golive/ui/activity/PhotoPbActivity.java`

字段/常量（14）：
- `String TAG = "PhotoPbActivity"`  L24
- `ImageButton back`  L25
- `LinearLayout bottomBar`  L26
- `ImageButton deleteBtn`  L27
- `ImageButton doNext`  L28
- `ImageButton doPrevious`  L29
- `ImageButton downloadBtn`  L30
- `TextView indexInfoTxv`  L31
- `SurfaceView mSurfaceView`  L32
- `ImageButton panoramaTypeBtn`  L33
- `PhotoPbPresenter presenter`  L34
- `ImageButton shareBtn`  L35
- `RelativeLayout topBar`  L36
- `ViewPager viewPager`  L37

方法（31）：
- `int getTopBarVisibility()`  L40 @Override
- `int getViewPagerCurrentItem()`  L45 @Override
- `void onCreate(Bundle bundle)`  L50 @Override
- `void onClick(View view)`  L72 @Override
- `void onClick(View view)`  L78 @Override
- `void onClick(View view)`  L84 @Override
    - 体内字面量："....doPrevious"
- `void onClick(View view)`  L91 @Override
    - 体内字面量："....doNext"
- `void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3)`  L98 @Override
    - 体内字面量："surfaceChanged........width="
- `void surfaceCreated(SurfaceHolder surfaceHolder)`  L104 @Override
    - 体内字面量："surfaceCreated"
- `void surfaceDestroyed(SurfaceHolder surfaceHolder)`  L111 @Override
    - 体内字面量："surfaceDestroyed"
- `boolean onTouch(View view, MotionEvent motionEvent)`  L118 @Override
- `void onClick(View view)`  L136 @Override
    - 体内字面量："mSurfaceView.setOnClickListener"
- `void onClick(View view)`  L142 @Override
    - 体内字面量："viewPager.setOnClickListener"
- `void onClick(View view)`  L148 @Override
- `void onClick(View view)`  L154 @Override
- `void onClick(View view)`  L160 @Override
- `void onDestroy()`  L168 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L175 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `void onResume()`  L189 @Override
    - 体内字面量："onResume"
- `void onStop()`  L198 @Override
- `void setBottomBarVisibility(int i)`  L203 @Override
- `void setIndexInfoTxv(String str)`  L208 @Override
- `void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener)`  L213 @Override
- `void setPanoramaTypeBtnImg(int i)`  L218 @Override
- `void setPanoramaTypeBtnVisibility(int i)`  L223 @Override
- `void setShareBtnVisibility(int i)`  L228 @Override
- `void setSurfaceviewVisibility(int i)`  L233 @Override
- `void setTopBarVisibility(int i)`  L240 @Override
- `void setViewPagerAdapter(PagerAdapter pagerAdapter)`  L245 @Override
- `void setViewPagerCurrentItem(int i)`  L252 @Override
- `void setViewPagerVisibility(int i)`  L257 @Override
### `com.icatch.golive.ui.activity.PreviewActivity`
L61 · [class] public PreviewActivity · extends `BaseActivity implements View.OnClickListener, PreviewView` · implements `View.OnClickListener, PreviewView` · `com/icatch/golive/ui/activity/PreviewActivity.java`

字段/常量（86）：
- `String TAG = "PreviewActivity"`  L62
- `ActionBar actionBar`  L63
- `ImageView autoDownloadImagview`  L64
- `ImageView batteryStatus`  L65
- `Button btn_format`  L66
- `Button btn_reset`  L67
- `ImageView burstStatus`  L68
- `ImageButton captureBtn`  L69
- `RadioButton captureRadioBtn`  L70
- `ImageView carMode`  L71
- `View contentView`  L72
- `int currentPreviewMode`  L73
- `Button customerLiveBtn`  L74
- `RelativeLayout delayCaptureLayout`  L75
- `TextView delayCaptureText`  L76
- `Button facebookLiveBtn`  L77
- `Button googleAccountBtn`  L78
- `ImageButton ib_shot_cut`  L79
- `ImageButton ib_state_camera`  L80
- `ImageButton ib_state_record`  L81
- `ImageButton ib_video_zoom_in`  L82
- `ImageButton ib_video_zoom_out`  L83
- `RelativeLayout imageSizeLayout`  L84
- `TextView imageSizeTxv`  L85
- `ImageButton iv_back`  L86
- `ImageButton iv_setting`  L87
- `ImageView iv_state_camera`  L88
- `ImageView iv_state_record`  L89
- `LinearLayout liveLayout`  L90
- `LinearLayout ll_change_device_info`  L91
- `LinearLayout ll_shot_cut`  L92
- `LinearLayout ll_state_camera`  L93
- `LinearLayout ll_state_record`  L94
- `LinearLayout ll_title`  L95
- `LinearLayout ll_watermark`  L96
- `TextView noSupportPreviewTxv`  L97
- `ImageButton panoramaTypeBtn`  L98
- `ImageButton pbBtn`  L99
- `PreviewPresenter presenter`  L100
- `PreviewPlayerView previewPlayerView`  L101
- `ImageButton pvModeBtn`  L102
- `PopupWindow pvModePopupWindow`  L103
- `TextView recordingTime`  L104
- `TextView remainCaptureCountText`  L105
- `TextView remainRecordingTimeText`  L106
- `CommonItemLayout settingLayout`  L107
- `MenuItem settingMenu`  L108
- `RelativeLayout setupMainMenu`  L109
- `ImageView slowMotion`  L110
- `ImageView timelapseMode`  L111
- `RadioButton timepLapseRadioBtn`  L112
- `Toolbar toolbar`  L113
- `TextView tv_battery_value`  L114
- `TextView tv_device_name`  L115
- `TextView tv_device_pwd`  L116
- `TextView tv_state_camera`  L117
- `TextView tv_state_record`  L118
- `TextView tv_title`  L119
- `TextView tv_video_state`  L120
- `TextView tv_watermark`  L121
- `RadioButton videoRadioBtn`  L122
- `TextView videoSizeFPS`  L123
- `RelativeLayout videoSizeLayout`  L124
- `TextView videoSizeTxv`  L125
- `ImageView wbStatus`  L126
- `ImageView wifiStatus`  L127
- `Button youtubeLiveBtn`  L128
- `ZoomView zoomView`  L129
- `String currentDeviceName = "<binary/metadata>"`  L130
- `boolean first_into = true`  L131
- `boolean isAppSentToBackground = false`  L132
- `boolean showCustomWatermark = false`  L133
- `PopupWindow popupWindow = this.pvModePopupWindow`  L310
- `PreviewPlayerView previewPlayerView = this.previewPlayerView`  L349
- `CommonItemLayout commonItemLayout = this.settingLayout`  L406
- `String str = TAG`  L427
- `CommonItemLayout commonItemLayout = this.settingLayout`  L832
- `CommonItemLayout commonItemLayout = this.settingLayout`  L1022
- `CommonItemLayout commonItemLayout = this.settingLayout`  L1034
- `String str2`  L1117
- `String str3 = strArrSplit.length == 2 ? strArrSplit[0] : "1080"`  L1120
- `String str4 = strArrSplit.length == 2 ? strArrSplit[1] : "30fps"`  L1121
- `PopupWindow popupWindow = this.pvModePopupWindow`  L1191
- `ImageButton imageButton = this.pvModeBtn`  L1192
- `PreviewPlayerView previewPlayerView = this.previewPlayerView`  L1204
- `PreviewPlayerView previewPlayerView = this.previewPlayerView`  L1213

方法（127）：
- `void changeSettingUI()`  L135
    - 体内字面量："listView"
- `throw new RuntimeException(e)`  L145
- `throw new RuntimeException(e2)`  L147
- `void delayStartRecording()`  L151
- `void run()`  L155 @Override
- `void initView()`  L161
- `void onClick(View view)`  L169 @Override
- `boolean onTouch(View view, MotionEvent motionEvent)`  L177 @Override
- `void onClick(View view)`  L183 @Override
- `void onClick(View view)`  L208 @Override
- `void onClick(View view)`  L218 @Override
- `void onClick(View view)`  L226 @Override
- `void lambda$initView$1(View view)`  L245
    - 体内字面量："scaleX" · "scaleY"
- `boolean lambda$initView$2(final View view, MotionEvent motionEvent)`  L254
    - 体内字面量："scaleX" · "scaleY"
- `void run()`  L265 @Override
- `void onLoopWatermark()`  L273
- `void run()`  L277 @Override
    - 体内字面量：" " · ":" · ":" · "current time = "
- `void switchCameraState(View view)`  L294
- `void switchRecordState(View view)`  L301
- `void dismissPopupWindow()`  L309 @Override
- `int getSetupMainMenuVisibility()`  L318 @Override
- `int getSurfaceViewHeight()`  L323 @Override
- `int getSurfaceViewWidth()`  L328 @Override
- `float getZoomViewMaxZoomRate()`  L333 @Override
- `float getZoomViewProgress()`  L338 @Override
- `void hideZoomView()`  L343 @Override
- `void initPreviewPlayerView(MediaStreamPlayer mediaStreamPlayer, boolean z)`  L348 @Override
- `void m583xe14ec0cd()`  L360
- `void m584lambda$initView$0$comicatchgoliveuiactivityPreviewActivity(View view)`  L371
- `void m585lambda$initView$3$comicatchgoliveuiactivityPreviewActivity(View view)`  L376
- `void m586lambda$initView$4$comicatchgoliveuiactivityPreviewActivity(View view)`  L384
- `void m587lambda$initView$5$comicatchgoliveuiactivityPreviewActivity(View view)`  L389
- `void m588lambda$initView$6$comicatchgoliveuiactivityPreviewActivity(View view)`  L394
- `void m589lambda$onResume$7$comicatchgoliveuiactivityPreviewActivity()`  L399
- `void loadSetting(List<SettingGroup> list)`  L405 @Override
- `void onActivityResult(int i, int i2, Intent intent, ComponentCaller componentCaller)`  L412
- `void run()`  L419 @Override
- `void onClick(View view)`  L426 @Override
- `void onConfigurationChanged(Configuration configuration)`  L497 @Override
- `void run()`  L501 @Override
    - 体内字面量："onConfigurationChanged newConfig Orientation="
- `void onCreate(Bundle bundle)`  L509 @Override
- `void onClick(View view)`  L566 @Override
- `void onClick(View view)`  L575 @Override
- `void onClick(View view)`  L584 @Override
- `void onClick(View view)`  L593 @Override
- `void onClick(View view)`  L604 @Override
- `void onClick(View view)`  L613 @Override
- `void onProgressChanged(ZoomView zoomView2, float f, boolean z)`  L622 @Override
- `void onStartTrackingTouch(ZoomView zoomView2)`  L626 @Override
- `void onStopTrackingTouch(ZoomView zoomView2)`  L630 @Override
- `void onClick(View view)`  L636 @Override
- `void onClick(View view)`  L645 @Override
- `void onClick(View view)`  L654 @Override
- `void onClick(View view)`  L663 @Override
- `boolean onTouch(View view, MotionEvent motionEvent)`  L672 @Override
- `void onClick(View view)`  L695 @Override
    - 体内字面量："BC2" · "C6" · "CN"
- `boolean onCreateOptionsMenu(Menu menu)`  L717 @Override
- `void onDestroy()`  L723 @Override
    - 体内字面量："onDestroy"
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L735 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `boolean onOptionsItemSelected(MenuItem menuItem)`  L749 @Override
    - 体内字面量："tigertiger" · "id == android.R.id.home"
- `void onPause()`  L764 @Override
- `boolean onPrepareOptionsMenu(Menu menu)`  L771 @Override
- `void onResume()`  L776 @Override
    - 体内字面量："onResume"
- `void run()`  L792 @Override
- `void onStart()`  L800 @Override
- `void onStop()`  L808 @Override
    - 体内字面量："onStop"
- `void refeshDateStampState(boolean z)`  L818 @Override
- `void refeshSetting()`  L831 @Override
- `void setActionBarTitle(int i)`  L839 @Override
- `void setAutoDownloadBitmap(Bitmap bitmap)`  L848 @Override
- `void setAutoDownloadVisibility(int i)`  L855 @Override
- `void setBackBtnVisibility(boolean z)`  L860 @Override
- `void setBatteryIcon(int i, int i2)`  L869 @Override
    - 体内字面量："%"
- `void setBatteryStatusVisibility(int i)`  L875 @Override
- `void setBurstStatusIcon(int i)`  L880 @Override
- `void setBurstStatusVisibility(int i)`  L885 @Override
- `void setCaptureBtnBackgroundResource(int i)`  L889 @Override
- `void setCaptureBtnEnability(boolean z)`  L894 @Override
- `void setCaptureRadioBtnChecked(boolean z)`  L899 @Override
- `void setCaptureRadioBtnVisibility(int i)`  L904 @Override
- `void setCarModeVisibility(int i)`  L909 @Override
- `void setCustomerLiveBtnTxv(String str)`  L914 @Override
- `void setDelayCaptureLayoutVisibility(int i)`  L919 @Override
- `void setDelayCaptureTextTime(String str)`  L924 @Override
- `void setDeviceName(String str, String str2)`  L929 @Override
- `void setFacebookBtnTxv(int i)`  L941 @Override
- `void setFacebookBtnTxv(String str)`  L946 @Override
- `void setImageSizeInfo(String str)`  L951 @Override
    - 体内字面量："sizeInfo = "
- `void setImageSizeLayoutVisibility(int i)`  L957 @Override
- `void setMaxZoomRate(float f)`  L961 @Override
- `void setMinZoomRate(float f)`  L966 @Override
- `void setPanoramaTypeBtnSrc(int i)`  L971 @Override
- `void setPanoramaTypeBtnVisibility(int i)`  L976 @Override
- `void setPvModeBtnBackgroundResource(int i)`  L981 @Override
- `void setRecordingTime(String str)`  L986 @Override
- `void setRecordingTimeVisibility(int i)`  L991 @Override
- `void setRemainCaptureCount(String str)`  L1001 @Override
- `void setRemainRecordingTimeText(String str)`  L1006 @Override
- `void setSettingBtnVisible(boolean z)`  L1011 @Override
- `void setSettingItemClickListener(CommonItemView.OnItemClickListener onItemClickListener)`  L1021 @Override
- `void setSettingMenuListAdapter(SettingListAdapter settingListAdapter)`  L1029 @Override
- `void setSettingSwitchChangedListener(CommonItemView.OnSwitchChangedListener onSwitchChangedListener)`  L1033 @Override
- `void setSetupMainMenuVisibility(int i)`  L1041 @Override
- `void setSlowMotionVisibility(int i)`  L1051 @Override
- `void setSupportPreviewTxvVisibility(int i)`  L1056 @Override
- `void setSwitchRecordState(int i)`  L1061 @Override
- `void setTimepLapseRadioBtnVisibility(int i)`  L1091 @Override
- `void setTimepLapseRadioChecked(boolean z)`  L1096 @Override
- `void setUpsideVisibility(int i)`  L1101 @Override
- `void setVideoRadioBtnChecked(boolean z)`  L1106 @Override
- `void setVideoRadioBtnVisibility(int i)`  L1111 @Override
- `void setVideoSizeInfo(String str)`  L1116 @Override
- `void setVideoSizeLayoutVisibility(int i)`  L1134 @Override
- `void setWbStatusIcon(int i)`  L1139 @Override
- `void setWbStatusVisibility(int i)`  L1144 @Override
- `void setWifiIcon(int i)`  L1149 @Override
- `void setWifiStatusVisibility(int i)`  L1154 @Override
- `void setYouTubeBtnTxv(int i)`  L1159 @Override
- `void setYouTubeBtnTxv(String str)`  L1164 @Override
- `void setYouTubeLiveLayoutVisibility(int i)`  L1169 @Override
- `void settimeLapseModeIcon(int i)`  L1174 @Override
- `void settimeLapseModeVisibility(int i)`  L1179 @Override
- `void showPopupWindow(int i)`  L1184 @Override
- `void showZoomView()`  L1198 @Override
- `void startPreview()`  L1203 @Override
- `void stopPreview()`  L1212 @Override
- `void updateZoomViewProgress(float f)`  L1221 @Override
### `com.icatch.golive.ui.activity.PvParamSettingActivity`
L23 · [class] public PvParamSettingActivity · extends `AppCompatActivity` · `com/icatch/golive/ui/activity/PvParamSettingActivity.java`

字段/常量（14）：
- `CameraProperties cameraProperties`  L24
- `ICatchVideoFormat curVideoFormat`  L25
- `RadioGroup frameRateRadioGroup`  L26
- `MyOrientoinListener myOrientoinListener`  L27
- `Button startPvBtn`  L28
- `RadioGroup videoCodecRadioGroup`  L29
- `RadioGroup videoSizeRadioGroup`  L30
- `String TAG = "PvParamSettingActivity"`  L31
- `int curVideoFps = 30`  L32
- `String curVideoCodec = "H264"`  L33
- `MyOrientoinListener myOrientoinListener = this.myOrientoinListener`  L118
- `int videoW`  L144
- `int videoH`  L145
- `ICatchVideoFormat iCatchVideoFormat = this.curVideoFormat`  L146

方法（12）：
- `void initVideoCodecRadioGroup()`  L35
- `void initVideoSizeRadioGroup(int i)`  L38
    - 体内字面量："*"
- `void onClick(View view)`  L52 @Override
- `void onBackPressed()`  L65 @Override
- `void onCreate(Bundle bundle)`  L71 @Override
- `void onClick(View view)`  L82 @Override
- `void onCheckedChanged(RadioGroup radioGroup, int i)`  L88 @Override
    - 体内字面量："frameRateRadioGroup.setOnCheckedChangeListener curVideoFps="
- `void onCheckedChanged(RadioGroup radioGroup, int i)`  L101 @Override
    - 体内字面量："H264" · "MJPG" · "videoCodecRadioGroup.setOnCheckedChangeListener curVideoCodec="
- `void onPause()`  L116 @Override
- `void onResume()`  L126 @Override
    - 体内字面量："accelerometer_rotation"
- `void onStop()`  L135 @Override
- `void startPv()`  L143
### `com.icatch.golive.ui.activity.RemoteMultiPbActivity`
L34 · [class] public RemoteMultiPbActivity · extends `AppCompatActivity implements MultiPbView` · implements `MultiPbView` · `com/icatch/golive/ui/activity/RemoteMultiPbActivity.java`

字段/常量（12）：
- `String TAG = "RemoteMultiPbActivity"`  L35
- `ImageButton deleteBtn`  L36
- `ImageButton downloadBtn`  L37
- `MenuItem filterItem`  L38
- `MenuItem menuPhotoWallType`  L39
- `LinearLayout multiPbEditLayout`  L40
- `RemoteMultiPbPresenter presenter`  L41
- `ImageButton selectBtn`  L42
- `TextView selectedNumTxv`  L43
- `TabLayout tabLayout`  L44
- `ViewPager viewPager`  L45
- `MenuItem menuItem = this.filterItem`  L199

方法（28）：
- `int getViewPageIndex()`  L48 @Override
- `void onCreate(Bundle bundle)`  L53 @Override
    - 体内字面量："onCreate "
- `void onPageScrollStateChanged(int i)`  L71 @Override
- `void onPageScrolled(int i, float f, int i2)`  L75 @Override
- `void onPageSelected(int i)`  L79 @Override
- `void onClick(View view)`  L85 @Override
- `void onClick(View view)`  L91 @Override
- `void onClick(View view)`  L97 @Override
    - 体内字面量："mScroller" · "FixedSpeedScroller Exception"
- `boolean onCreateOptionsMenu(Menu menu)`  L119 @Override
- `void onDestroy()`  L127 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L138 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `boolean onOptionsItemSelected(MenuItem menuItem)`  L152 @Override
- `void onResume()`  L173 @Override
    - 体内字面量："onResume()"
- `void onStart()`  L181 @Override
- `void onStop()`  L186 @Override
    - 体内字面量："onStop()"
- `void setEditLayoutVisibiliy(int i)`  L193 @Override
- `void setFilterItemVisibiliy(boolean z)`  L198 @Override
- `void setMenuPhotoWallTypeIcon(int i)`  L206 @Override
- `void setSelectBtnIcon(int i)`  L210 @Override
- `void setSelectBtnVisibility(int i)`  L215 @Override
- `void setSelectNumText(String str)`  L220 @Override
- `void setSelectNumTextVisibility(int i)`  L225 @Override
- `void setTabLayoutClickable(boolean z)`  L230 @Override
    - 体内字面量："setTabLayoutClickable value="
- `void setViewPageAdapter(FragmentPagerAdapter fragmentPagerAdapter)`  L240 @Override
- `void setViewPageCurrentItem(int i)`  L245 @Override
    - 体内字面量："setViewPageCurrentItem item="
- `void setViewPagerScanScroll(boolean z)`  L251 @Override
- `void showFilterDialog()`  L254
    - 体内字面量："dialog"
- `void onSureClick(FileFilter fileFilter)`  L266 @Override
    - 体内字面量："onSureClick fileFilter:" · "onSureClick startTime:" · "onSureClick endTime:" · "dialog"
### `com.icatch.golive.ui.activity.RemoteMultiPbActivity2`
L37 · [class] public RemoteMultiPbActivity2 · extends `BaseActivity implements MultiPbView2` · implements `MultiPbView2` · `com/icatch/golive/ui/activity/RemoteMultiPbActivity2.java`

字段/常量（13）：
- `Button btn_emergency`  L38
- `Button btn_photo`  L39
- `Button btn_video`  L40
- `MenuItem filterItem`  L41
- `RemoteMultiPbPresenter2 presenter`  L42
- `TabLayout tabLayout`  L43
- `TextView tv_select_all`  L44
- `TextView tv_selector`  L45
- `ViewPager viewPager`  L46
- `String TAG = "RemoteMultiPbActivity2"`  L47
- `boolean isAppSentToBackground = false`  L48
- `boolean first_into = true`  L49
- `MenuItem menuItem = this.filterItem`  L323

方法（34）：
- `int getViewPageIndex()`  L52 @Override
- `void m590xd82636d(View view)`  L57
- `void m591x279de20c(View view)`  L62
- `void m592x41b960ab(View view)`  L74
- `void m593x5bd4df4a(View view)`  L83
- `void m594x75f05de9(View view)`  L88
- `void m595x900bdc88(View view)`  L93
- `void onCreate(Bundle bundle)`  L98 @Override
    - 体内字面量："onCreate "
- `void onClick(View view)`  L107 @Override
- `void onClick(View view)`  L115 @Override
- `void onClick(View view)`  L123 @Override
- `void onClick(View view)`  L131 @Override
- `void onClick(View view)`  L139 @Override
- `void onClick(View view)`  L147 @Override
- `void onPageScrollStateChanged(int i)`  L158 @Override
- `void onPageScrolled(int i, float f, int i2)`  L162 @Override
- `void onPageSelected(int i)`  L166 @Override
    - 体内字面量："onPageSelected position = " · "tabLayout" · "getTabCount: " · "mScroller" · "FixedSpeedScroller Exception"
- `boolean onCreateOptionsMenu(Menu menu)`  L218 @Override
- `void onDestroy()`  L226 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L237 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `void onManualSelectedAll(boolean z)`  L250
- `boolean onOptionsItemSelected(MenuItem menuItem)`  L259 @Override
- `void onRestart()`  L280 @Override
- `void onResume()`  L291 @Override
    - 体内字面量："onResume()"
- `void onStart()`  L307 @Override
- `void onStop()`  L312 @Override
    - 体内字面量："onStop()"
- `void setFilterItemVisibiliy(boolean z)`  L322 @Override
- `void setMenuPhotoWallTypeIcon(int i)`  L330 @Override
- `void setTabLayoutClickable(boolean z)`  L334 @Override
    - 体内字面量："setTabLayoutClickable value="
- `void setViewPageAdapter(FragmentPagerAdapter fragmentPagerAdapter)`  L348 @Override
- `void setViewPageCurrentItem(int i)`  L353 @Override
    - 体内字面量："setViewPageCurrentItem item="
- `void setViewPagerScanScroll(boolean z)`  L359 @Override
- `void showFilterDialog()`  L362
    - 体内字面量："dialog"
- `void onSureClick(FileFilter fileFilter)`  L374 @Override
    - 体内字面量："onSureClick fileFilter:" · "onSureClick startTime:" · "onSureClick endTime:" · "dialog"
### `com.icatch.golive.ui.activity.RtspPlayerActivity`
L23 · [class] public RtspPlayerActivity · extends `Activity` · `com/icatch/golive/ui/activity/RtspPlayerActivity.java`

字段/常量（9）：
- `LandLayoutVideo detail_player`  L24
- `Boolean isFullScreen = true`  L25
- `boolean isPause`  L26
- `boolean isPlay`  L27
- `OrientationUtils orientationUtils`  L28
- `String str_url`  L29
- `OrientationUtils orientationUtils = this.orientationUtils`  L114
- `OrientationUtils orientationUtils = this.orientationUtils`  L122
- `OrientationUtils orientationUtils = this.orientationUtils`  L154

方法（17）：
- `GSYVideoPlayer getCurPlay()`  L31
- `void initView()`  L35
    - 体内字面量："VideoPlayURL" · "VideoPlayTitle"
- `void onClick(View view)`  L40 @Override
    - 体内字面量："mediacodec" · "mediacodec-auto-rotate" · "opensles" · "audio-resample" · "rtsp_transport" · "tcp" · "rtsp_flags" · "prefer_tcp" · "probesize" · "analyzeduration" · "fflags" · "nofillin" · "start-on-prepared" · "packet-buffering" · "framedrop" · "max-buffer-duration" · "flush_packets" · "enable-accurate-seek" · "overlay-format"
- `void onPrepared(String str, Object... objArr)`  L71 @Override
- `void onQuitFullscreen(String str, Object... objArr)`  L78 @Override
- `void onClick(View view)`  L87 @Override
- `void onClick(View view, boolean z)`  L93 @Override
- `void m596x543ff504(View view)`  L102
- `void m597x45e99b23(View view)`  L107
- `void m598x37934142(View view, boolean z)`  L113
- `void onBackPressed()`  L121 @Override
- `void onConfigurationChanged(Configuration configuration)`  L133 @Override
- `void onCreate(Bundle bundle)`  L142 @Override
- `void onDestroy()`  L149 @Override
- `void onPause()`  L161 @Override
- `void onResume()`  L168 @Override
- `void onTrimMemory(int i)`  L175 @Override
### `com.icatch.golive.ui.activity.StartPageActivity`
L32 · [class] public StartPageActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/StartPageActivity.java`

字段/常量（8）：
- `String TAG = "StartPageActivity"`  L33
- `boolean isShowedGlobalContent = true`  L34
- `boolean onceRecreate = false`  L35
- `AlertDialog mAlertDialog`  L36
- `View view`  L37
- `WebView wv_policy`  L38
- `Locale localeSyncSystemLanguage`  L85
- `String str2`  L120

方法（14）：
- `void checkLicenseAgreement(Context context)`  L40
    - 体内字面量："appData" · "agreeLicenseAgreement" · "showLicenseAgreementDialog isAgreeLicenseAgreement=" · "agreeLicenseAgreementVersion" · "showLicenseAgreementDialog Version ="
- `void gotoLaunch()`  L53
- `void gotoLogin()`  L62
- `void initView()`  L66
- `void run()`  L70 @Override
- `void lambda$showPrivacyPolicy$1(DialogInterface dialogInterface, int i)`  L79
- `void settingLanguage()`  L84
- `void showPrivacyPolicy(final Context context, final String str)`  L115
- `boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest)`  L119 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L142 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L148 @Override
- `Locale syncSystemLanguage()`  L163
    - 体内字面量："zh" · "CN" · "ko" · "th" · "th" · "TH" · "ja"
- `void m599x77651f59(Context context, String str, DialogInterface dialogInterface, int i)`  L193
    - 体内字面量："appData" · "agreeLicenseAgreement" · "agreeLicenseAgreementVersion"
- `void onCreate(Bundle bundle)`  L203 @Override
### `com.icatch.golive.ui.activity.USBPreviewActivity`
L39 · [class] public USBPreviewActivity · extends `AppCompatActivity implements View.OnClickListener, USBPreviewView` · implements `View.OnClickListener, USBPreviewView` · `com/icatch/golive/ui/activity/USBPreviewActivity.java`

字段/常量（45）：
- `String TAG = "USBPreviewActivity"`  L40
- `ActionBar actionBar`  L41
- `SwitchCompat audioSwitcher`  L42
- `ImageView autoDownloadImagview`  L43
- `ImageView batteryStatus`  L44
- `ImageView burstStatus`  L45
- `ImageButton captureBtn`  L46
- `RadioButton captureRadioBtn`  L47
- `ImageView carMode`  L48
- `View contentView`  L49
- `RelativeLayout delayCaptureLayout`  L50
- `TextView delayCaptureText`  L51
- `Button facebookLiveBtn`  L52
- `Button googleAccountBtn`  L53
- `RelativeLayout imageSizeLayout`  L54
- `TextView imageSizeSetting`  L55
- `TextView imageSizeTxv`  L56
- `LinearLayout liveLayout`  L57
- `SurfaceView mSurfaceView`  L58
- `MyOrientoinListener myOrientoinListener`  L59
- `TextView noSupportPreviewTxv`  L60
- `ImageButton pbBtn`  L61
- `USBPreviewPresenter presenter`  L62
- `ImageButton pvModeBtn`  L63
- `PopupWindow pvModePopupWindow`  L64
- `TextView recordingTime`  L65
- `TextView remainCaptureCountText`  L66
- `TextView remainRecordingTimeText`  L67
- `MenuItem settingMenu`  L68
- `RelativeLayout setupMainMenu`  L69
- `ImageView slowMotion`  L70
- `ImageView timelapseMode`  L71
- `RadioButton timepLapseRadioBtn`  L72
- `Toolbar toolbar`  L73
- `RadioButton videoRadioBtn`  L74
- `RelativeLayout videoSizeLayout`  L75
- `TextView videoSizeTxv`  L76
- `ImageView wbStatus`  L77
- `ImageView wifiStatus`  L78
- `Button youtubeLiveBtn`  L79
- `PopupWindow popupWindow = this.pvModePopupWindow`  L83
- `String str = TAG`  L107
- `MyOrientoinListener myOrientoinListener = this.myOrientoinListener`  L318
- `PopupWindow popupWindow = this.pvModePopupWindow`  L603
- `ImageButton imageButton = this.pvModeBtn`  L604

方法（77）：
- `void dismissPopupWindow()`  L82 @Override
- `int getSetupMainMenuVisibility()`  L91 @Override
- `int getSurfaceViewHeight()`  L96 @Override
- `int getSurfaceViewWidth()`  L101 @Override
- `void onClick(View view)`  L106 @Override
- `void onConfigurationChanged(Configuration configuration)`  L120 @Override
    - 体内字面量："onConfigurationChanged newConfig Orientation="
- `void onCreate(Bundle bundle)`  L126 @Override
- `void onClick(View view)`  L184 @Override
- `void onClick(View view)`  L190 @Override
- `void onClick(View view)`  L196 @Override
- `void onClick(View view)`  L202 @Override
- `void onClick(View view)`  L208 @Override
- `void onClick(View view)`  L214 @Override
- `void onClick(View view)`  L220 @Override
- `void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3)`  L226 @Override
    - 体内字面量："surfaceChanged!!!"
- `void surfaceCreated(SurfaceHolder surfaceHolder)`  L232 @Override
    - 体内字面量："surfaceCreated!!!"
- `void surfaceDestroyed(SurfaceHolder surfaceHolder)`  L239 @Override
- `boolean onTouch(View view, MotionEvent motionEvent)`  L244 @Override
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L262 @Override
- `void onClick(View view)`  L268 @Override
    - 体内字面量："onCreate"
- `boolean onCreateOptionsMenu(Menu menu)`  L276 @Override
- `void onDestroy()`  L282 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L288 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `boolean onOptionsItemSelected(MenuItem menuItem)`  L302 @Override
    - 体内字面量："tigertiger" · "id == android.R.id.home"
- `void onPause()`  L315 @Override
- `void onResume()`  L326 @Override
    - 体内字面量："accelerometer_rotation"
- `void onStart()`  L340 @Override
- `void onStop()`  L345 @Override
- `void setActionBarTitle(int i)`  L352 @Override
- `void setAudioSwitcherChecked(boolean z)`  L357 @Override
- `void setAudioSwitcherVisibility(int i)`  L362 @Override
- `void setAutoDownloadBitmap(Bitmap bitmap)`  L367 @Override
- `void setAutoDownloadVisibility(int i)`  L374 @Override
- `void setBackBtnVisibility(boolean z)`  L379 @Override
- `void setBatteryIcon(int i)`  L384 @Override
- `void setBatteryStatusVisibility(int i)`  L389 @Override
- `void setBurstStatusIcon(int i)`  L394 @Override
- `void setBurstStatusVisibility(int i)`  L399 @Override
- `void setCaptureBtnBackgroundResource(int i)`  L404 @Override
- `void setCaptureBtnEnability(boolean z)`  L409 @Override
- `void setCaptureRadioBtnChecked(boolean z)`  L414 @Override
- `void setCaptureRadioBtnVisibility(int i)`  L419 @Override
- `void setCarModeVisibility(int i)`  L424 @Override
- `void setDelayCaptureLayoutVisibility(int i)`  L429 @Override
- `void setDelayCaptureTextTime(String str)`  L434 @Override
- `void setFacebookBtnTxv(int i)`  L439 @Override
- `void setFacebookBtnTxv(String str)`  L444 @Override
- `void setImageSizeInfo(String str)`  L449 @Override
    - 体内字面量："sizeInfo = "
- `void setImageSizeLayoutVisibility(int i)`  L455 @Override
- `void setImageSizeSettingText(String str)`  L460 @Override
- `void setLiveLayoutVisibility(int i)`  L465 @Override
- `void setPvModeBtnBackgroundResource(int i)`  L470 @Override
- `void setRecordingTime(String str)`  L475 @Override
- `void setRecordingTimeVisibility(int i)`  L480 @Override
- `void setRemainCaptureCount(String str)`  L485 @Override
- `void setRemainRecordingTimeText(String str)`  L490 @Override
- `void setSettingBtnVisible(boolean z)`  L495 @Override
- `void setSettingMenuListAdapter(SettingListAdapter settingListAdapter)`  L500 @Override
- `void setSetupMainMenuVisibility(int i)`  L504 @Override
- `void setSlowMotionVisibility(int i)`  L509 @Override
- `void setSupportPreviewTxvVisibility(int i)`  L514 @Override
- `void setTimepLapseRadioBtnVisibility(int i)`  L519 @Override
- `void setTimepLapseRadioChecked(boolean z)`  L524 @Override
- `void setUpsideVisibility(int i)`  L529 @Override
- `void setVideoRadioBtnChecked(boolean z)`  L534 @Override
- `void setVideoRadioBtnVisibility(int i)`  L539 @Override
- `void setVideoSizeInfo(String str)`  L544 @Override
    - 体内字面量："sizeInfo = "
- `void setVideoSizeLayoutVisibility(int i)`  L550 @Override
- `void setWbStatusIcon(int i)`  L556 @Override
- `void setWbStatusVisibility(int i)`  L561 @Override
- `void setWifiIcon(int i)`  L566 @Override
- `void setWifiStatusVisibility(int i)`  L571 @Override
- `void setYouTubeBtnTxv(int i)`  L576 @Override
- `void setYouTubeBtnTxv(String str)`  L581 @Override
- `void settimeLapseModeIcon(int i)`  L586 @Override
- `void settimeLapseModeVisibility(int i)`  L591 @Override
- `void showPopupWindow(int i)`  L596 @Override
### `com.icatch.golive.ui.activity.VideoPbActivity`
L25 · [class] public VideoPbActivity · extends `AppCompatActivity implements VideoPbView` · implements `VideoPbView` · `com/icatch/golive/ui/activity/VideoPbActivity.java`

字段/常量（14）：
- `ImageButton cancelBtn`  L26
- `TextView deleteTxv`  L27
- `Switch eisSwitch`  L28
- `LinearLayout moreSettingLayout`  L29
- `ImageButton panoramaTypeBtn`  L30
- `VideoPbPresenter presenter`  L31
- `VideoPlayerView videoPlayerView`  L32
- `String TAG = "VideoPbActivity"`  L33
- `boolean isFullScreen = false`  L34
- `VideoPlayerView videoPlayerView = this.videoPlayerView`  L47
- `VideoPlayerView videoPlayerView = this.videoPlayerView`  L221
- `VideoPlayerView videoPlayerView = this.videoPlayerView`  L250
- `VideoPlayerView videoPlayerView = this.videoPlayerView`  L259
- `VideoPlayerView videoPlayerView = this.videoPlayerView`  L268

方法（29）：
- `void backClick()`  L37
- `void initPreviewPlayerView(MediaStreamPlayer mediaStreamPlayer, boolean z)`  L46 @Override
- `void onConfigurationChanged(Configuration configuration)`  L56 @Override
    - 体内字面量："onConfigurationChanged newConfig Orientation="
- `void onCreate(Bundle bundle)`  L69 @Override
- `void onClick(View view)`  L86 @Override
- `void onClick(View view)`  L92 @Override
- `void onClick(View view)`  L98 @Override
- `void onBackClick()`  L104 @Override
- `void onDeleteClick()`  L109 @Override
- `void onDownloadClick()`  L114 @Override
- `void onMoreClick()`  L119 @Override
    - 体内字面量："controller"
- `void onFullScreenModeChanged(boolean z)`  L129 @Override
    - 体内字面量："onFullScreenModeChanged isFullScreen:"
- `boolean onTouch(View view, MotionEvent motionEvent)`  L140 @Override
    - 体内字面量："onTouch event:"
- `void onClick(View view)`  L168 @Override
- `throw new RuntimeException(e)`  L173
- `throw new RuntimeException(e2)`  L175
- `void onDestroy()`  L180 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L186 @Override
    - 体内字面量："AppStart" · "home" · "AppStart" · "back"
- `void onPause()`  L200 @Override
- `void onResume()`  L206 @Override
- `void onStop()`  L214 @Override
- `void setBarVisibility(int i)`  L220 @Override
- `void setEisSwitchChecked(boolean z)`  L229 @Override
- `void setMoreSettingLayoutVisibility(int i)`  L234 @Override
- `void setPanoramaTypeBtnVisibility(int i)`  L239 @Override
- `void setPanoramaTypeImageResource(int i)`  L244 @Override
- `void setVideoNameTxv(String str)`  L249 @Override
- `void startPreview()`  L258 @Override
- `void stopPreview()`  L267 @Override
### `com.icatch.golive.ui.activity.WebActivity`
L19 · [class] public WebActivity · extends `BaseActivity` · `com/icatch/golive/ui/activity/WebActivity.java`

字段/常量（2）：
- `WebView wv_policy`  L20
- `Locale locale`  L23

方法（9）：
- `void initLanguage()`  L22
- `void initView()`  L41
- `void onClick(View view)`  L44 @Override
- `void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError)`  L55 @Override
    - 体内字面量："file:///android_asset/privacyPolicy.html" · "file:///android_asset/privacyPolicy-zh_CN.html" · "https://id221.com/idGoLive/privacyPolicy-en.html" · "https://idcam.idalbum.com.cn/idGoLive/privacyPolicy-zh_CN.html"
- `Locale syncSystemLanguage()`  L71
    - 体内字面量："zh" · "CN" · "ko" · "th" · "th" · "TH"
- `void m600lambda$initView$0$comicatchgoliveuiactivityWebActivity(View view)`  L85
- `void onCreate(Bundle bundle)`  L90 @Override
- `void onStop()`  L98 @Override
- `void setLocale(Locale locale)`  L104
### `com.icatch.golive.ui.activity.WifiApActivity`
L20 · [class] public WifiApActivity · extends `AppCompatActivity` · `com/icatch/golive/ui/activity/WifiApActivity.java`

字段/常量（13）：
- `boolean DEBUG = true`  L21
- `Button mBtStartWifiAp`  L22
- `Button mBtStopWifiAp`  L23
- `RadioButton mRdNo`  L24
- `RadioButton mRdWpa`  L25
- `RadioButton mRdWpa2`  L26
- `RadioGroup mRgWifiSerurity`  L27
- `TextView mWifiApState`  L28
- `EditText mWifiPassword`  L29
- `EditText mWifiSsid`  L30
- `String TAG = "WifiApActivity"`  L31
- `WifiAPUtil.WifiSecurityType mWifiType = WifiAPUtil.WifiSecurityType.WIFICIPHER_NOPASS`  L32
- `int i = message.what`  L37

方法（10）：
- `void handleMessage(Message message)`  L35 @Override
    - 体内字面量："WifiApActivity message.what="
- `void openAPUI()`  L50
    - 体内字面量："com.android.settings" · "com.android.settings.Settings$TetherSettingsActivity"
- `void onBackPressed()`  L58 @Override
    - 体内字面量："WifiApActivity onBackPressed"
- `void onCreate(Bundle bundle)`  L65 @Override
- `void onDestroy()`  L83 @Override
    - 体内字面量："WifiApActivity onDestroy"
- `void onResume()`  L90 @Override
- `void onCheckedChanged(RadioGroup radioGroup, int i)`  L94 @Override
    - 体内字面量："radio check mWifiType = "
- `void onClick(View view)`  L107 @Override
- `void onClick(View view)`  L113 @Override
- `void onStop()`  L120 @Override
    - 体内字面量："WifiApActivity onStop"
### `com.icatch.golive.ui.activity.YdeviceSettingActivity`
L42 · [class] public YdeviceSettingActivity · extends `AppCompatActivity` · `com/icatch/golive/ui/activity/YdeviceSettingActivity.java`

字段/常量（41）：
- `String TAG = "YdeviceSettingActivity"`  L43
- `String kHiddenBackMirrorKey = "isHiddenBackMirror"`  L44
- `String[] date_format_arr`  L45
- `String[] g_sensor_arr`  L46
- `String[] lapse_photography_arr`  L47
- `YdeviceSettingAdapter mAdapter`  L48
- `String[] record_duration_arr`  L49
- `RecyclerView rv_settings`  L50
- `String[] time_format_arr`  L51
- `String[] time_lapse_photography_arr`  L52
- `TextView tv_device_name`  L53
- `String[] video_definition_arr`  L54
- `int sound_record_status = -1`  L55
- `int time_imprint_status = -1`  L56
- `int video_mirror = -1`  L57
- `int front_cam_rotation_status = -1`  L58
- `int back_cam_image_status = -1`  L59
- `int record_duration_status = -1`  L60
- `int video_definition_status = -1`  L61
- `int g_sensor_status = -1`  L62
- `int lapse_photography_status = -1`  L63
- `int time_lapse_photography_status = -1`  L64
- `int time_format_status = -1`  L65
- `int date_format_status = -1`  L66
- `boolean allow_change_pwd = true`  L67
- `boolean isHiddenBackMirror = false`  L68
- `YdeviceSettingActivity ydeviceSettingActivity = YdeviceSettingActivity.this`  L136
- `YdeviceSettingActivity ydeviceSettingActivity = YdeviceSettingActivity.this`  L154
- `YdeviceSettingActivity ydeviceSettingActivity = YdeviceSettingActivity.this`  L179
- `YdeviceSettingActivity ydeviceSettingActivity = YdeviceSettingActivity.this`  L198
- `String str2 = "GB"`  L215
- `byte b`  L230
- `YdeviceSettingActivity ydeviceSettingActivity = YdeviceSettingActivity.this`  L520
- `YdeviceSettingActivity ydeviceSettingActivity = YdeviceSettingActivity.this`  L569
- `YdeviceSettingActivity ydeviceSettingActivity2 = YdeviceSettingActivity.this`  L572
- `int i = this.g_sensor_status`  L662
- `int i = this.record_duration_status`  L667
- `String[] strArr = this.record_duration_arr`  L669
- `String[] strArr = this.video_definition_arr`  L678
- `int length = strArr.length`  L685
- `int i = this.video_definition_status`  L686

方法（74）：
- `void changeDeviceNamePwd(String str, String str2)`  L70
    - 体内字面量："http://192.168.169.1/app/setwifi?wifipwd=" · "http://192.168.169.1/app/setwifi?wifissid="
- `void confirmFormatDevice()`  L83
- `void handleMessage(Message message)`  L87 @Override
    - 体内字面量："å è½½ä¸­â¦"
- `void run()`  L98 @Override
- `void confirmReconnect()`  L108
- `void confirmResetDevice()`  L112
- `void handleMessage(Message message)`  L116 @Override
- `void getDeviceFreeSpace()`  L131
- `void handleMessage(Message message)`  L134 @Override
- `void getDeviceInfo()`  L148
- `void handleMessage(Message message)`  L151 @Override
- `void getMenuConfigInfo()`  L173
- `void handleMessage(Message message)`  L176 @Override
- `void getMenuCurrentValue()`  L192
- `void handleMessage(Message message)`  L195 @Override
- `void handleDeviceStatus(String str)`  L212
    - 体内字面量："info" · "free"
- `void handleMenuConfigInfo(String str)`  L229
- `throw new RuntimeException(e)`  L303
- `void handleMenuList(String str)`  L308
    - 体内字面量："info" · "name" · "YES" · "YES" · "YES"
- `void initData()`  L364
- `void handleMessage(Message message)`  L370 @Override
    - 体内字面量："M1RequestInfo.urlGetCapability RequestInfo = codeFailure" · "info" · "info" · "ç¬¬8ä½æ°å­æ¯ï¼"
- `throw new RuntimeException(e)`  L393
- `void initEvent()`  L399
- `void onClick(View view)`  L402 @Override
- `void onClick(View view)`  L408 @Override
- `void onClick(View view)`  L414 @Override
- `void onClick(View view)`  L420 @Override
- `void initView()`  L426
- `void didClickCell(String str)`  L434 @Override
- `void didSwitchCell(String str, CompoundButton compoundButton, boolean z)`  L445 @Override
- `void onBack()`  L456
- `void handleMessage(Message message)`  L461 @Override
- `void handleMessage(Message message2)`  L465 @Override
- `void onChangeGSensor()`  L482
- `void onClick(DialogInterface dialogInterface, int i)`  L485 @Override
- `void onChangeRecordDuration()`  L492
- `void onClick(DialogInterface dialogInterface, int i)`  L495 @Override
- `void onChangeVideoDefinition()`  L502
- `void onClick(DialogInterface dialogInterface, int i)`  L505 @Override
- `void reconnectWiFi()`  L512
- `void handleMessage(Message message)`  L515 @Override
- `void requestChangeDeviceStatus(final String str, final int i)`  L528
    - 体内字面量："http://192.168.169.1/app/setparamvalue?param=" · "&value="
- `void handleMessage(Message message)`  L532 @Override
- `void requestSetDeviceInfo(final String str)`  L563
- `void handleMessage(Message message)`  L566 @Override
- `void setH264()`  L584
    - 体内字面量："http://192.168.169.1/app/setparamvalue?param=encodec&value=0"
- `void handleMessage(Message message)`  L587 @Override
- `void showDeviceFormatDialog()`  L593
- `void onClick(DialogInterface dialogInterface, int i)`  L599 @Override
- `void showDeviceNamePwdDialog()`  L606
- `void onClick(View view)`  L621 @Override
- `void onClick(View view)`  L627 @Override
- `void showDeviceResetDialog()`  L634
- `void onClick(DialogInterface dialogInterface, int i)`  L640 @Override
- `void showReconnectDialog()`  L648
- `void onClick(DialogInterface dialogInterface, int i)`  L653 @Override
- `String getGSensor()`  L661
- `String getRecordDuration()`  L666
- `String getVideoDefinition()`  L677
- `void m601x666c97ca(View view)`  L691
- `void m602x80881669(View view)`  L696
- `void m603x9aa39508(View view)`  L701
- `void m604xb4bf13a7(View view)`  L706
- `void m605x91546e9c(DialogInterface dialogInterface, int i)`  L711
- `void m606x2feea5c2(DialogInterface dialogInterface, int i)`  L717
- `void m607x77fce430(DialogInterface dialogInterface, int i)`  L723
- `void m608x6b659ccf(DialogInterface dialogInterface, int i)`  L729
- `void m609xf570bfc4(AlertDialog alertDialog, EditText editText, EditText editText2, View view)`  L734
- `void m610x56e0326(DialogInterface dialogInterface, int i)`  L740
- `void m611x94f7ff8b(DialogInterface dialogInterface, int i)`  L745
- `void onCreate(Bundle bundle)`  L750 @Override
- `boolean onKeyDown(int i, KeyEvent keyEvent)`  L759 @Override
- `void onTrimMemory(int i)`  L768 @Override
- `void handleMessage(Message message)`  L773 @Override
### `com.icatch.golive.ui.adapter.BlueToothListAdapter`
L15 · [class] public BlueToothListAdapter · extends `BaseAdapter` · `com/icatch/golive/ui/adapter/BlueToothListAdapter.java`

字段/常量（4）：
- `Context context`  L16
- `LayoutInflater inflater`  L17
- `boolean isBLE`  L18
- `List<BluetoothAppDevice> list`  L19

方法（5）：
- `public BlueToothListAdapter(Context context, List<BluetoothAppDevice> list, boolean z)`  L21
- `int getCount()`  L29 @Override
- `Object getItem(int i)`  L34 @Override
- `long getItemId(int i)`  L39 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L44 @Override
    - 体内字面量："Binded" · "Unbinded"
### `com.icatch.golive.ui.adapter.CameraSlotAdapter`
L21 · [class] public CameraSlotAdapter · extends `BaseAdapter` · `com/icatch/golive/ui/adapter/CameraSlotAdapter.java`

字段/常量（6）：
- `List<CameraSlot> camSlotList`  L22
- `Context context`  L23
- `int listViewHeight`  L24
- `Handler myHandler`  L25
- `String tag = "CameraSlotAdapter"`  L26
- `byte[] bArr = cameraSlot.cameraPhoto`  L102

方法（7）：
- `public CameraSlotAdapter(Context context, List<CameraSlot> list, Handler handler)`  L28
- `public CameraSlotAdapter(Context context, List<CameraSlot> list, Handler handler, int i)`  L37
- `int getCount()`  L45 @Override
- `Object getItem(int i)`  L50 @Override
- `long getItemId(int i)`  L55 @Override
- `View getView(final int i, View view, ViewGroup viewGroup)`  L60 @Override
- `void onClick(View view2)`  L79 @Override
    - 体内字面量："#FFFFFF"
### `com.icatch.golive.ui.adapter.DownloadFirmwareAdapter`
L18 · [class] public DownloadFirmwareAdapter · extends `RecyclerView.Adapter<DownloadFirmwareViewHolder>` · `com/icatch/golive/ui/adapter/DownloadFirmwareAdapter.java`

字段/常量（5）：
- `List<String> list_downloaded_firmware_version`  L19
- `List<FirmwareInfo> list_firmware`  L20
- `DownloadFirmwareActivity mActivity`  L21
- `DownloadFirmwareOnClickListener mListener`  L22
- `List<FirmwareInfo> list = this.list_firmware`  L75

方法（5）：
- `public DownloadFirmwareAdapter(DownloadFirmwareActivity downloadFirmwareActivity, DownloadFirmwareOnClickListener downloadFirmwareOnClickListener)`  L68
- `int getItemCount()`  L74 @Override
- `void onBindViewHolder(DownloadFirmwareViewHolder downloadFirmwareViewHolder, int i)`  L83 @Override
- `DownloadFirmwareViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L88 @Override
- `void refreshData(List<FirmwareInfo> list, List<FirmwareInfo> list2)`  L92
### `com.icatch.golive.ui.adapter.DownloadFirmwareAdapter$DownloadFirmwareOnClickListener`
L24 · [interface] public DownloadFirmwareOnClickListener · `com/icatch/golive/ui/adapter/DownloadFirmwareAdapter.java`

方法（1）：
- `void didClickCell(FirmwareInfo firmwareInfo)`  L25
### `com.icatch.golive.ui.adapter.DownloadFirmwareAdapter$DownloadFirmwareViewHolder`
L28 · [class] DownloadFirmwareViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/DownloadFirmwareAdapter.java`

字段/常量（4）：
- `ImageView iv_download`  L29
- `TextView tv_firmware_name`  L30
- `TextView tv_firmware_region`  L31
- `TextView tv_firmware_version`  L32

方法（4）：
- `public DownloadFirmwareViewHolder(View view)`  L34
- `void onClick(View view2)`  L42 @Override
- `void bindData(int i)`  L48
    - 体内字面量：" " · "Version: "
- `void m612xe0b222e4(View view)`  L61
    - 体内字面量："DownloadFirmwareViewHolder" · "pos => "
### `com.icatch.golive.ui.adapter.DownloadManagerAdapter`
L21 · [class] public DownloadManagerAdapter · extends `BaseAdapter` · `com/icatch/golive/ui/adapter/DownloadManagerAdapter.java`

字段/常量（6）：
- `String TAG = "DownloadManagerAdapter"`  L22
- `List<ICatchFile> actList`  L23
- `HashMap<Integer, DownloadInfo> chooseListMap`  L24
- `Context context`  L25
- `Handler handler`  L26
- `OnCancelBtnClickListener onCancelBtnClickListener`  L27

方法（7）：
- `public DownloadManagerAdapter(Context context, HashMap<Integer, DownloadInfo> map, List<ICatchFile> list, Handler handler)`  L33
- `int getCount()`  L41 @Override
- `Object getItem(int i)`  L46 @Override
- `long getItemId(int i)`  L51 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L56 @Override
    - 体内字面量："#.#" · "M" · "M"
- `void onClick(View view2)`  L87 @Override
- `void setOnCancelBtnClickListener(OnCancelBtnClickListener onCancelBtnClickListener)`  L97
### `com.icatch.golive.ui.adapter.DownloadManagerAdapter$OnCancelBtnClickListener`
L29 · [interface] public OnCancelBtnClickListener · `com/icatch/golive/ui/adapter/DownloadManagerAdapter.java`

方法（1）：
- `void onClick(ICatchFile iCatchFile)`  L30
### `com.icatch.golive.ui.adapter.FilterGridAdaper`
L14 · [class] public FilterGridAdaper · extends `BaseAdapter` · `com/icatch/golive/ui/adapter/FilterGridAdaper.java`

字段/常量（8）：
- `Context context`  L15
- `List<FilterItem> list`  L16
- `LayoutInflater mInflater`  L17
- `int width`  L18
- `String TAG = "FilterGridAdaper"`  L19
- `int selectorPosition = -1`  L20
- `View viewInflate`  L58
- `ViewHolder viewHolder`  L59

方法（8）：
- `public FilterGridAdaper(Context context, List<FilterItem> list)`  L26
- `void changeState(int i)`  L32
- `int getCount()`  L38 @Override
- `Object getItem(int i)`  L43 @Override
- `long getItemId(int i)`  L48 @Override
- `int getSelectorPosition()`  L52
- `View getView(int i, View view, ViewGroup viewGroup)`  L57 @Override
- `void setSelectorPosition(int i)`  L80
### `com.icatch.golive.ui.adapter.FilterGridAdaper$ViewHolder`
L22 · [class] public static ViewHolder · `com/icatch/golive/ui/adapter/FilterGridAdaper.java`

字段/常量（1）：
- `TextView textView`  L23
### `com.icatch.golive.ui.adapter.GridSpacingItemDecoration`
L8 · [class] public GridSpacingItemDecoration · extends `RecyclerView.ItemDecoration` · `com/icatch/golive/ui/adapter/GridSpacingItemDecoration.java`

字段/常量（7）：
- `boolean includeEdge`  L9
- `int spacing`  L10
- `int spanCount`  L11
- `int i = this.spanCount`  L22
- `int i2 = childAdapterPosition % i`  L23
- `int i3 = this.spacing`  L25
- `int i4 = this.spacing`  L35

方法（2）：
- `public GridSpacingItemDecoration(int i, int i2, boolean z)`  L13
- `void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state)`  L20 @Override
### `com.icatch.golive.ui.adapter.LdeviceSettingAdapter`
L21 · [class] public LdeviceSettingAdapter · extends `RecyclerView.Adapter<LdeviceSettingViewHolder>` · `com/icatch/golive/ui/adapter/LdeviceSettingAdapter.java`

字段/常量（23）：
- `int kTableTypeDeviceVersionInfo`  L22
- `int kTableTypeFreeSpace`  L23
- `int kTableTypeGSensor`  L24
- `int kTableTypeLensRotation`  L25
- `int kTableTypeMicrophoneMode`  L26
- `int kTableTypeRecordAudio`  L27
- `int kTableTypeRecordDuration`  L28
- `int kTableTypeTimeImprint`  L29
- `int kTableTypeVideoDefinition`  L30
- `LdeviceSettingActivity mActivity`  L31
- `List<Map<String, String>> mList`  L32
- `LdeviceSettingOnClickListener mListener`  L33
- `String str_g_sensor`  L34
- `String str_microphone_mode`  L35
- `String str_record_time`  L36
- `String str_video_definition`  L37
- `String kCellLeftText = "cell_left_text"`  L38
- `String kCellRightText = "cell_right_text"`  L39
- `String kCellRightArrow = "cell_right_arrow"`  L40
- `String gCurSSID = "<binary/metadata>"`  L41
- `String deviceCurVersion = "<binary/metadata>"`  L42
- `String deviceFreeSpace = "<binary/metadata>"`  L43
- `List<Map<String, String>> list = this.mList`  L259

方法（8）：
- `public LdeviceSettingAdapter(LdeviceSettingActivity ldeviceSettingActivity, LdeviceSettingOnClickListener ldeviceSettingOnClickListener)`  L222
- `void initData()`  L228
    - 体内字面量："YES" · "YES"
- `int getItemCount()`  L258 @Override
- `void onBindViewHolder(LdeviceSettingViewHolder ldeviceSettingViewHolder, int i)`  L267 @Override
- `LdeviceSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L272 @Override
- `void refreshDeviceFreeSpace(String str)`  L276
- `void refreshDeviceVersion(String str)`  L281
- `void updataOtherData(boolean z, boolean z2, boolean z3)`  L286
    - 体内字面量："YES" · "YES"
### `com.icatch.golive.ui.adapter.LdeviceSettingAdapter$LdeviceSettingOnClickListener`
L45 · [interface] public LdeviceSettingOnClickListener · `com/icatch/golive/ui/adapter/LdeviceSettingAdapter.java`

方法（2）：
- `void didClickCell(int i)`  L46
- `void didSwitchCell(int i, CompoundButton compoundButton, boolean z)`  L48
### `com.icatch.golive.ui.adapter.LdeviceSettingAdapter$LdeviceSettingViewHolder`
L51 · [class] LdeviceSettingViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/LdeviceSettingAdapter.java`

字段/常量（5）：
- `int current_position`  L52
- `ImageView iv_right_arrow`  L53
- `Switch switch_right`  L54
- `TextView tv_left`  L55
- `TextView tv_right`  L56

方法（6）：
- `public LdeviceSettingViewHolder(View view)`  L58
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L71 @Override
- `void onClick(View view2)`  L77 @Override
- `void bindData(int i)`  L83
    - 体内字面量："1" · "1" · "2003" · "1" · "1" · "1" · "1" · "1"
- `void m615xc07fceba(CompoundButton compoundButton, boolean z)`  L201
- `void m616xc14e4d3b(View view)`  L208
### `com.icatch.golive.ui.adapter.LocalDeviceFilesAdapter`
L31 · [class] public LocalDeviceFilesAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/icatch/golive/ui/adapter/LocalDeviceFilesAdapter.java`

字段/常量（12）：
- `int DATE = 0`  L32
- `int PHOTO = 1`  L33
- `OnItemClickListener callback`  L34
- `LayoutInflater inflater`  L35
- `Context mContext`  L36
- `View mRootView`  L37
- `String str_date_current`  L38
- `boolean showSelectedBtn = false`  L39
- `int currentClieckItem = -1`  L43
- `String string`  L173
- `List list`  L174
- `int i2 = this.currentClieckItem`  L257

方法（16）：
- `public LocalDeviceFilesAdapter(Context context, OnItemClickListener onItemClickListener)`  L166
- `void initAllFiles()`  L172
- `int compare(Object obj, Object obj2)`  L214 @Override
- `void deleteFilesRefresh(List<FileItemInfo> list)`  L229
- `int getItemCount()`  L239 @Override
- `int getItemViewType(int i)`  L244 @Override
- `List<FileItemInfo> getListFilesSelected()`  L251
- `void m617x8929bf39(int i, FileItemInfo fileItemInfo, View view)`  L256
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L267 @Override
- `int getSpanSize(int i)`  L274 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i)`  L285 @Override
- `void onClick(View view)`  L297 @Override
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L310 @Override
- `boolean onSelectAllOrNone()`  L319
- `void renderList(List<FileItemInfo> list)`  L329
- `void setShowSelectedBtn(boolean z)`  L335
### `com.icatch.golive.ui.adapter.LocalDeviceFilesAdapter$LocalDateViewHolder`
L45 · [class] public LocalDateViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/LocalDeviceFilesAdapter.java`

字段/常量（1）：
- `TextView tv_date`  L46

方法（1）：
- `public LocalDateViewHolder(View view)`  L48
### `com.icatch.golive.ui.adapter.LocalDeviceFilesAdapter$LocalFileViewHolder`
L54 · [class] public LocalFileViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/LocalDeviceFilesAdapter.java`

字段/常量（7）：
- `CheckBox cb_select_item`  L55
- `int current_position`  L56
- `ImageView iv_video_file`  L57
- `ProgressWheel progressBar`  L58
- `TextView tv_file_info`  L59
- `long j2 = j / 1000`  L78
- `String string`  L83

方法（8）：
- `public LocalFileViewHolder(View view)`  L61
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L71 @Override
- `String getDuration(long j)`  L77
- `void bindData(int i, FileItemInfo fileItemInfo)`  L82
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L88 @Override
- `void onLoadingFailed(String str, View view)`  L94 @Override
- `void onLoadingStarted(String str, View view)`  L100 @Override
    - 体内字面量："M" · "K" · "\\." · "_" · ":" · ":" · ":" · ":" · " / "
- `void m618x863c5f55(CompoundButton compoundButton, boolean z)`  L138
### `com.icatch.golive.ui.adapter.LocalDeviceFilesAdapter$OnItemClickListener`
L160 · [interface] public OnItemClickListener · `com/icatch/golive/ui/adapter/LocalDeviceFilesAdapter.java`

方法（2）：
- `void onItemClick(FileItemInfo fileItemInfo, int i)`  L161
- `void onManualSelectedAll(boolean z)`  L163
### `com.icatch.golive.ui.adapter.LocalMultiPbWallGridAdapter`
L22 · [class] public LocalMultiPbWallGridAdapter · extends `BaseAdapter implements StickyGridHeadersSimpleAdapter` · implements `StickyGridHeadersSimpleAdapter` · `com/icatch/golive/ui/adapter/LocalMultiPbWallGridAdapter.java`

字段/常量（12）：
- `Context context`  L23
- `FileType fileType`  L24
- `List<LocalPbItemInfo> list`  L25
- `LayoutInflater mInflater`  L26
- `int width`  L27
- `String TAG = "LocalMultiPbWallGridAdapter"`  L28
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L29
- `View viewInflate`  L85
- `HeaderViewHolder headerViewHolder`  L86
- `int i = 0`  L111
- `View viewInflate`  L122
- `ViewHolder viewHolder`  L123

方法（14）：
- `public LocalMultiPbWallGridAdapter(Context context, List<LocalPbItemInfo> list, FileType fileType)`  L42
- `void cancelAllSelections()`  L50
- `void changeCheckBoxState(int i, OperationMode operationMode)`  L57
- `List<LocalPbItemInfo> getCheckedItemsList()`  L63
- `int getCount()`  L74 @Override
- `long getHeaderId(int i)`  L79 @Override
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L84 @Override
- `Object getItem(int i)`  L101 @Override
- `long getItemId(int i)`  L106 @Override
- `int getSelectedCount()`  L110
- `View getView(int i, View view, ViewGroup viewGroup)`  L121 @Override
- `void notifyDataSetChanged()`  L173 @Override
- `void quitEditMode()`  L178
- `void selectAllItems()`  L186
### `com.icatch.golive.ui.adapter.LocalMultiPbWallGridAdapter$HeaderViewHolder`
L31 · [class] public static HeaderViewHolder · `com/icatch/golive/ui/adapter/LocalMultiPbWallGridAdapter.java`

字段/常量（1）：
- `TextView mTextView`  L32
### `com.icatch.golive.ui.adapter.LocalMultiPbWallGridAdapter$ViewHolder`
L35 · [class] public static ViewHolder · `com/icatch/golive/ui/adapter/LocalMultiPbWallGridAdapter.java`

字段/常量（4）：
- `ImageView mCheckImageView`  L36
- `ImageView mImageView`  L37
- `ImageView mIsPanoramaSign`  L38
- `ImageView videoSignImageView`  L39
### `com.icatch.golive.ui.adapter.LocalMultiPbWallListAdapter`
L21 · [class] public LocalMultiPbWallListAdapter · extends `BaseAdapter` · `com/icatch/golive/ui/adapter/LocalMultiPbWallListAdapter.java`

字段/常量（6）：
- `Context context`  L22
- `FileType fileType`  L23
- `List<LocalPbItemInfo> list`  L24
- `String TAG = "LocalMultiPbWallListAdapter"`  L25
- `OperationMode curMode = OperationMode.MODE_BROWSE`  L26
- `int i = 0`  L62

方法（12）：
- `public LocalMultiPbWallListAdapter(Context context, List<LocalPbItemInfo> list, FileType fileType)`  L28
- `void cancelAllSelections()`  L34
- `void changeSelectionState(int i)`  L41
- `int getCount()`  L47 @Override
- `Object getItem(int i)`  L52 @Override
- `long getItemId(int i)`  L57 @Override
- `int getSelectedCount()`  L61
- `List<LocalPbItemInfo> getSelectedList()`  L71
- `View getView(int i, View view, ViewGroup viewGroup)`  L82 @Override
- `void quitEditMode()`  L132
- `void selectAllItems()`  L140
- `void setOperationMode(OperationMode operationMode)`  L147
### `com.icatch.golive.ui.adapter.LocalPhotoPbViewPagerAdapter`
L17 · [class] public LocalPhotoPbViewPagerAdapter · extends `PagerAdapter` · `com/icatch/golive/ui/adapter/LocalPhotoPbViewPagerAdapter.java`

字段/常量（4）：
- `String TAG = "PhotoPbViewPagerAdapter"`  L18
- `Context context`  L19
- `List<FileItemInfo> filesList`  L20
- `OnPhotoTapListener onPhotoTapListener`  L21

方法（11）：
- `public LocalPhotoPbViewPagerAdapter(Context context, List<FileItemInfo> list)`  L27
- `void destroyItem(ViewGroup viewGroup, int i, Object obj)`  L33 @Override
- `int getCount()`  L40 @Override
- `Object instantiateItem(ViewGroup viewGroup, int i)`  L45 @Override
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L53 @Override
- `void onLoadingFailed(String str, View view)`  L59 @Override
- `void onLoadingStarted(String str, View view)`  L65 @Override
- `void onOutsidePhotoTap()`  L72 @Override
- `void onPhotoTap(View view, float f, float f2)`  L76 @Override
- `boolean isViewFromObject(View view, Object obj)`  L88 @Override
- `void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener)`  L92
### `com.icatch.golive.ui.adapter.LocalPhotoPbViewPagerAdapter$OnPhotoTapListener`
L23 · [interface] public OnPhotoTapListener · `com/icatch/golive/ui/adapter/LocalPhotoPbViewPagerAdapter.java`

方法（1）：
- `void onPhotoTap()`  L24
### `com.icatch.golive.ui.adapter.LocalPhotoWallGridAdapter`
L23 · [class] public LocalPhotoWallGridAdapter · extends `BaseAdapter implements StickyGridHeadersSimpleAdapter` · implements `StickyGridHeadersSimpleAdapter` · `com/icatch/golive/ui/adapter/LocalPhotoWallGridAdapter.java`

字段/常量（15）：
- `Context context`  L24
- `FileType fileType`  L25
- `List<LocalPbItemInfo> list`  L26
- `OnAddAsytaskListener listener`  L27
- `LayoutInflater mInflater`  L28
- `LruCache<String, Bitmap> mLruCache`  L29
- `int width`  L30
- `String TAG = "LocalPhotoWallGridAdapter"`  L31
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L32
- `int i = 0`  L69
- `View viewInflate`  L100
- `HeaderViewHolder headerViewHolder`  L101
- `View viewInflate`  L127
- `ViewHolder viewHolder`  L128
- `OnAddAsytaskListener onAddAsytaskListener = this.listener`  L176

方法（14）：
- `public LocalPhotoWallGridAdapter(Context context, List<LocalPbItemInfo> list, int i, LruCache<String, Bitmap> lruCache, FileType fileType, OnAddAsytaskListener onAddAsytaskListener)`  L45
- `void cancalSelectAllCheckBoxState()`  L55
- `void changeCheckBoxState(int i, OperationMode operationMode)`  L62
- `int getCheckedBoxNum()`  L68
- `List<LocalPbItemInfo> getCheckedItemsList()`  L78
- `int getCount()`  L89 @Override
- `long getHeaderId(int i)`  L94 @Override
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L99 @Override
- `Object getItem(int i)`  L116 @Override
- `long getItemId(int i)`  L121 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L126 @Override
- `void notifyDataSetChanged()`  L186 @Override
- `void quitEditMode()`  L191
- `void selectAllCheckBoxState()`  L199
### `com.icatch.golive.ui.adapter.LocalPhotoWallGridAdapter$HeaderViewHolder`
L34 · [class] public static HeaderViewHolder · `com/icatch/golive/ui/adapter/LocalPhotoWallGridAdapter.java`

字段/常量（1）：
- `TextView mTextView`  L35
### `com.icatch.golive.ui.adapter.LocalPhotoWallGridAdapter$ViewHolder`
L38 · [class] public static ViewHolder · `com/icatch/golive/ui/adapter/LocalPhotoWallGridAdapter.java`

字段/常量（4）：
- `ImageView mCheckImageView`  L39
- `ImageView mImageView`  L40
- `ImageView mIsPanoramaSign`  L41
- `ImageView mVideoSign`  L42
### `com.icatch.golive.ui.adapter.LocalPhotoWallListAdapter`
L20 · [class] public LocalPhotoWallListAdapter · extends `BaseAdapter` · `com/icatch/golive/ui/adapter/LocalPhotoWallListAdapter.java`

字段/常量（7）：
- `Context context`  L21
- `FileType fileType`  L22
- `boolean[] isItemChecked`  L23
- `List<LocalPbItemInfo> list`  L24
- `LruCache<String, Bitmap> mLruCache`  L25
- `String TAG = "LocalPhotoWallListAdapter"`  L26
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L27

方法（5）：
- `public LocalPhotoWallListAdapter(Context context, List<LocalPbItemInfo> list, LruCache<String, Bitmap> lruCache, FileType fileType)`  L29
- `int getCount()`  L41 @Override
- `Object getItem(int i)`  L46 @Override
- `long getItemId(int i)`  L51 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L56 @Override
### `com.icatch.golive.ui.adapter.LocalVideoWallGridAdapter`
L21 · [class] public LocalVideoWallGridAdapter · extends `BaseAdapter implements StickyGridHeadersSimpleAdapter` · implements `StickyGridHeadersSimpleAdapter` · `com/icatch/golive/ui/adapter/LocalVideoWallGridAdapter.java`

字段/常量（16）：
- `Context context`  L22
- `boolean[] isItemChecked`  L23
- `List<LocalPbItemInfo> list`  L24
- `OnAddAsytaskListener listener`  L25
- `LayoutInflater mInflater`  L26
- `LruCache<String, Bitmap> mLruCache`  L27
- `int width`  L28
- `String TAG = "LocalVideoWallGridAdapter"`  L29
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L30
- `boolean[] zArr = this.isItemChecked`  L67
- `int i = 0`  L78
- `View viewInflate`  L102
- `HeaderViewHolder headerViewHolder`  L103
- `View viewInflate`  L129
- `ViewHolder viewHolder`  L130
- `OnAddAsytaskListener onAddAsytaskListener = this.listener`  L161

方法（14）：
- `public LocalVideoWallGridAdapter(Context context, List<LocalPbItemInfo> list, int i, LruCache<String, Bitmap> lruCache, OnAddAsytaskListener onAddAsytaskListener)`  L41
- `void cancalSelectAllCheckBoxState()`  L54
- `void changeCheckBoxState(int i, OperationMode operationMode)`  L64
    - 体内字面量："changeSelectionState positon=" · "state = "
- `boolean[] getCheckBoxState()`  L73
- `int getCheckedBoxNum()`  L77
- `void getCheckedItemsList()`  L87
- `int getCount()`  L91 @Override
- `long getHeaderId(int i)`  L96 @Override
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L101 @Override
- `Object getItem(int i)`  L118 @Override
- `long getItemId(int i)`  L123 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L128 @Override
- `void initCheckBoxState()`  L170
- `void selectAllCheckBoxState()`  L181
### `com.icatch.golive.ui.adapter.LocalVideoWallGridAdapter$HeaderViewHolder`
L32 · [class] public static HeaderViewHolder · `com/icatch/golive/ui/adapter/LocalVideoWallGridAdapter.java`

字段/常量（1）：
- `TextView mTextView`  L33
### `com.icatch.golive.ui.adapter.LocalVideoWallGridAdapter$ViewHolder`
L36 · [class] public static ViewHolder · `com/icatch/golive/ui/adapter/LocalVideoWallGridAdapter.java`

字段/常量（2）：
- `ImageView mCheckImageView`  L37
- `ImageView mImageView`  L38
### `com.icatch.golive.ui.adapter.LocalVideoWallListAdapter`
L19 · [class] public LocalVideoWallListAdapter · extends `BaseAdapter` · `com/icatch/golive/ui/adapter/LocalVideoWallListAdapter.java`

字段/常量（7）：
- `Context context`  L20
- `boolean[] isItemChecked`  L21
- `List<LocalPbItemInfo> list`  L22
- `LayoutInflater mInflater`  L23
- `LruCache<String, Bitmap> mLruCache`  L24
- `String TAG = "LocalPhotoWallListAdapter"`  L25
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L26

方法（5）：
- `public LocalVideoWallListAdapter(Context context, List<LocalPbItemInfo> list, LruCache<String, Bitmap> lruCache)`  L28
- `int getCount()`  L40 @Override
- `Object getItem(int i)`  L45 @Override
- `long getItemId(int i)`  L50 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L55 @Override
### `com.icatch.golive.ui.adapter.LYDownloadFileAdapter`
L19 · [class] public LYDownloadFileAdapter · extends `RecyclerView.Adapter<LYDownloadFileViewHolder>` · `com/icatch/golive/ui/adapter/LYDownloadFileAdapter.java`

字段/常量（5）：
- `int current_download_index = 0`  L20
- `LayoutInflater inflater`  L21
- `List<FileInfo> list_files`  L22
- `Context mContext`  L23
- `View mRootView`  L24

方法（6）：
- `public LYDownloadFileAdapter(Context context, List<FileInfo> list)`  L74
- `int getItemCount()`  L81 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list)`  L86 @Override
- `void onBindViewHolder(LYDownloadFileViewHolder lYDownloadFileViewHolder, int i)`  L91 @Override
- `void onBindViewHolder(LYDownloadFileViewHolder lYDownloadFileViewHolder, int i, List<Object> list)`  L95
- `LYDownloadFileViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L108 @Override
### `com.icatch.golive.ui.adapter.LYDownloadFileAdapter$LYDownloadFileViewHolder`
L26 · [class] public LYDownloadFileViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/LYDownloadFileAdapter.java`

字段/常量（6）：
- `String current_file_size`  L27
- `int current_position`  L28
- `ImageView iv_video_file`  L29
- `ProgressBar pb_progress`  L30
- `TextView tv_file_name`  L31
- `TextView tv_file_size`  L32

方法（3）：
- `public LYDownloadFileViewHolder(View view)`  L34
- `void bindData(int i, FileInfo fileInfo)`  L46
    - 体内字面量："-" · "_" · "-" · "_" · "F" · "_F" · "f" · "_F"
- `void setProgress(int i)`  L64
    - 体内字面量："%  "
### `com.icatch.golive.ui.adapter.LYRemoteFileAdapter`
L23 · [class] public LYRemoteFileAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/icatch/golive/ui/adapter/LYRemoteFileAdapter.java`

字段/常量（11）：
- `int DATE = 0`  L24
- `int PHOTO = 1`  L25
- `OnItemClickListener callback`  L26
- `LayoutInflater inflater`  L27
- `List<String> list_downloaded_file_name`  L28
- `List<FileInfo> list_files`  L29
- `Context mContext`  L30
- `View mRootView`  L31
- `String str_date_current`  L32
- `boolean showSelectedBtn = false`  L34
- `int currentClieckItem = -1`  L35

方法（16）：
- `public LYRemoteFileAdapter(Context context, List<FileInfo> list, List<String> list2, OnItemClickListener onItemClickListener)`  L128
- `void initAllFiles()`  L136
    - 体内字面量："QzIntegratedCircuit" · "_" · " " · "-" · "-"
- `void clearListFilesSelected()`  L156
- `FileInfo getFileByAll(int i)`  L160
- `int getItemCount()`  L165 @Override
- `int getItemViewType(int i)`  L170 @Override
- `List<FileInfo> getListFilesSelected()`  L177
- `void m613x84361821(LYRemoteFileViewHolder lYRemoteFileViewHolder, int i, View view)`  L182
- `void notifyDataSetChanged(List<FileInfo> list)`  L190
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L197 @Override
- `int getSpanSize(int i)`  L204 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i)`  L215 @Override
- `void onClick(View view)`  L226 @Override
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L239 @Override
- `boolean onSelectAllOrNone()`  L248
- `void setShowSelectedBtn(boolean z)`  L258
### `com.icatch.golive.ui.adapter.LYRemoteFileAdapter$LYRemoteDateViewHolder`
L38 · [class] public static LYRemoteDateViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/LYRemoteFileAdapter.java`

字段/常量（1）：
- `TextView tv_date`  L39

方法（1）：
- `public LYRemoteDateViewHolder(View view)`  L41
### `com.icatch.golive.ui.adapter.LYRemoteFileAdapter$LYRemoteFileViewHolder`
L47 · [class] public LYRemoteFileViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/LYRemoteFileAdapter.java`

字段/常量（6）：
- `CheckBox cb_select_item`  L48
- `int current_position`  L49
- `ImageView iv_video_file`  L50
- `TextView tv_file_downloaded`  L51
- `TextView tv_file_name`  L52
- `TextView tv_file_size`  L53

方法（4）：
- `public LYRemoteFileViewHolder(View view)`  L55
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L66 @Override
- `void bindData(int i, FileInfo fileInfo)`  L72
    - 体内字面量："_f" · "_F" · "_r" · "_R" · "-" · "_" · "_F" · "-" · "_" · "F" · "_F"
- `void m614x9eac167c(CompoundButton compoundButton, boolean z)`  L95
### `com.icatch.golive.ui.adapter.LYRemoteFileAdapter$OnItemClickListener`
L122 · [interface] public OnItemClickListener · `com/icatch/golive/ui/adapter/LYRemoteFileAdapter.java`

方法（2）：
- `void onItemClick(int i)`  L123
- `void onManualSelectedAll(boolean z)`  L125
### `com.icatch.golive.ui.adapter.MultiPbPhotoWallGridAdapter`
L22 · [class] public MultiPbPhotoWallGridAdapter · extends `BaseAdapter implements StickyGridHeadersSimpleAdapter` · implements `StickyGridHeadersSimpleAdapter` · `com/icatch/golive/ui/adapter/MultiPbPhotoWallGridAdapter.java`

字段/常量（12）：
- `Context context`  L23
- `FileType fileType`  L24
- `List<MultiPbItemInfo> list`  L25
- `LayoutInflater mInflater`  L26
- `int width`  L27
- `String TAG = "MultiPbPhotoWallGridAdapter"`  L28
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L29
- `View viewInflate`  L85
- `HeaderViewHolder headerViewHolder`  L86
- `int i = 0`  L113
- `View viewInflate`  L124
- `ViewHolder viewHolder`  L125

方法（14）：
- `public MultiPbPhotoWallGridAdapter(Context context, List<MultiPbItemInfo> list, FileType fileType)`  L42
- `void cancelAllSelections()`  L50
- `void changeCheckBoxState(int i, OperationMode operationMode)`  L57
- `List<MultiPbItemInfo> getCheckedItemsList()`  L63
- `int getCount()`  L74 @Override
- `long getHeaderId(int i)`  L79 @Override
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L84 @Override
- `Object getItem(int i)`  L103 @Override
- `long getItemId(int i)`  L108 @Override
- `int getSelectedCount()`  L112
- `View getView(int i, View view, ViewGroup viewGroup)`  L123 @Override
- `void notifyDataSetChanged()`  L175 @Override
- `void quitEditMode()`  L180
- `void selectAllItems()`  L188
### `com.icatch.golive.ui.adapter.MultiPbPhotoWallGridAdapter$HeaderViewHolder`
L31 · [class] public static HeaderViewHolder · `com/icatch/golive/ui/adapter/MultiPbPhotoWallGridAdapter.java`

字段/常量（1）：
- `TextView mTextView`  L32
### `com.icatch.golive.ui.adapter.MultiPbPhotoWallGridAdapter$ViewHolder`
L35 · [class] public static ViewHolder · `com/icatch/golive/ui/adapter/MultiPbPhotoWallGridAdapter.java`

字段/常量（4）：
- `ImageView mCheckImageView`  L36
- `ImageView mImageView`  L37
- `ImageView mIsPanoramaSign`  L38
- `ImageView videoSignImageView`  L39
### `com.icatch.golive.ui.adapter.MultiPbPhotoWallListAdapter`
L21 · [class] public MultiPbPhotoWallListAdapter · extends `BaseAdapter` · `com/icatch/golive/ui/adapter/MultiPbPhotoWallListAdapter.java`

字段/常量（6）：
- `Context context`  L22
- `FileType fileType`  L23
- `List<MultiPbItemInfo> list`  L24
- `String TAG = "MultiPbPhotoWallListAdapter"`  L25
- `OperationMode curMode = OperationMode.MODE_BROWSE`  L26
- `int i = 0`  L62

方法（12）：
- `public MultiPbPhotoWallListAdapter(Context context, List<MultiPbItemInfo> list, FileType fileType)`  L28
- `void cancelAllSelections()`  L34
- `void changeSelectionState(int i)`  L41
- `int getCount()`  L47 @Override
- `Object getItem(int i)`  L52 @Override
- `long getItemId(int i)`  L57 @Override
- `int getSelectedCount()`  L61
- `List<MultiPbItemInfo> getSelectedList()`  L71
- `View getView(int i, View view, ViewGroup viewGroup)`  L82 @Override
- `void quitEditMode()`  L137
- `void selectAllItems()`  L145
- `void setOperationMode(OperationMode operationMode)`  L152
### `com.icatch.golive.ui.adapter.MultiPbRecyclerViewAdapter`
L25 · [class] public MultiPbRecyclerViewAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/icatch/golive/ui/adapter/MultiPbRecyclerViewAdapter.java`

字段/常量（16）：
- `int TYPE_GRID = 1`  L26
- `int TYPE_LIST = 2`  L27
- `int TYPE_QUICK_LIST = 3`  L28
- `FileType fileType`  L29
- `List<MultiPbItemInfo> list`  L30
- `int width`  L31
- `int TYPE_FOOTER = 4`  L32
- `int LOADING = 1`  L33
- `int LOADING_COMPLETE = 2`  L34
- `int LOADING_END = 3`  L35
- `int curViewType = 1`  L36
- `int loadState = 2`  L37
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L38
- `int i = 0`  L139
- `MultiPbItemInfo multiPbItemInfo`  L164
- `int i2 = this.loadState`  L208

方法（16）：
- `public MultiPbRecyclerViewAdapter(Context context, List<MultiPbItemInfo> list, FileType fileType)`  L95
- `void cancelAllSelections()`  L101
- `void changeCheckBoxState(int i)`  L108
- `List<MultiPbItemInfo> getCheckedItemsList()`  L115
- `int getItemCount()`  L126 @Override
- `int getItemViewType(int i)`  L131 @Override
- `int getSelectedCount()`  L138
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L149 @Override
- `int getSpanSize(int i)`  L155 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i)`  L163 @Override
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L229 @Override
- `void quitEditMode()`  L242
- `void selectAllItems()`  L250
- `void setCurViewType(int i)`  L257
- `void setLoadState(int i)`  L261
- `void setOperationMode(OperationMode operationMode)`  L266
### `com.icatch.golive.ui.adapter.MultiPbRecyclerViewAdapter$FootViewHolder`
L40 · [class] private FootViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/MultiPbRecyclerViewAdapter.java`

字段/常量（3）：
- `LinearLayout llEnd`  L41
- `ProgressBar pbLoading`  L42
- `TextView tvLoading`  L43
### `com.icatch.golive.ui.adapter.MultiPbRecyclerViewAdapter$RecyclerViewGridHolder`
L53 · [class] private RecyclerViewGridHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/MultiPbRecyclerViewAdapter.java`

字段/常量（4）：
- `ImageView mCheckImageView`  L54
- `ImageView mImageView`  L55
- `ImageView mIsPanoramaSign`  L56
- `ImageView videoSignImageView`  L57
### `com.icatch.golive.ui.adapter.MultiPbRecyclerViewAdapter$RecyclerViewListHolder`
L68 · [class] private RecyclerViewListHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/MultiPbRecyclerViewAdapter.java`

字段/常量（10）：
- `TextView imageDateTextView`  L69
- `TextView imageDurationView`  L70
- `TextView imageNameTextView`  L71
- `TextView imageSizeTextView`  L72
- `ImageView imageView`  L73
- `ImageView mCheckImageView`  L74
- `ImageView mIsPanoramaSign`  L75
- `boolean showThumbnail`  L76
- `FrameLayout thumbnailLayout`  L77
- `ImageView videoSignImageView`  L78
### `com.icatch.golive.ui.adapter.MultiPbViewPageAdapter`
L9 · [class] public MultiPbViewPageAdapter · extends `FragmentPagerAdapter` · `com/icatch/golive/ui/adapter/MultiPbViewPageAdapter.java`

字段/常量（1）：
- `ArrayList<Fragment> list`  L10

方法（3）：
- `public MultiPbViewPageAdapter(FragmentManager fragmentManager, ArrayList<Fragment> arrayList)`  L12
- `int getCount()`  L18 @Override
- `Fragment getItem(int i)`  L23 @Override
### `com.icatch.golive.ui.adapter.MyViewPagerAdapter`
L11 · [class] public MyViewPagerAdapter · extends `PagerAdapter` · `com/icatch/golive/ui/adapter/MyViewPagerAdapter.java`

字段/常量（2）：
- `Context context`  L12
- `ArrayList<View> viewList`  L13

方法（5）：
- `public MyViewPagerAdapter(Context context, ArrayList<View> arrayList)`  L15
- `void destroyItem(ViewGroup viewGroup, int i, Object obj)`  L21 @Override
- `int getCount()`  L29 @Override
- `Object instantiateItem(ViewGroup viewGroup, int i)`  L34 @Override
- `boolean isViewFromObject(View view, Object obj)`  L42 @Override
### `com.icatch.golive.ui.adapter.PhotoPbViewPagerAdapter`
L19 · [class] public PhotoPbViewPagerAdapter · extends `PagerAdapter` · `com/icatch/golive/ui/adapter/PhotoPbViewPagerAdapter.java`

字段/常量（4）：
- `String TAG = "PhotoPbViewPagerAdapter"`  L20
- `Context context`  L21
- `List<MultiPbItemInfo> filesList`  L22
- `OnPhotoTapListener onPhotoTapListener`  L23

方法（11）：
- `public PhotoPbViewPagerAdapter(Context context, List<MultiPbItemInfo> list)`  L29
- `void destroyItem(ViewGroup viewGroup, int i, Object obj)`  L35 @Override
    - 体内字面量："destroyItem position:"
- `int getCount()`  L43 @Override
- `Object instantiateItem(ViewGroup viewGroup, int i)`  L48 @Override
    - 体内字面量："instantiateItem position:"
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L57 @Override
- `void onLoadingFailed(String str, View view)`  L63 @Override
- `void onLoadingStarted(String str, View view)`  L69 @Override
- `void onOutsidePhotoTap()`  L76 @Override
- `void onPhotoTap(View view, float f, float f2)`  L80 @Override
- `boolean isViewFromObject(View view, Object obj)`  L92 @Override
- `void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener)`  L96
### `com.icatch.golive.ui.adapter.PhotoPbViewPagerAdapter$OnPhotoTapListener`
L25 · [interface] public OnPhotoTapListener · `com/icatch/golive/ui/adapter/PhotoPbViewPagerAdapter.java`

方法（1）：
- `void onPhotoTap()`  L26
### `com.icatch.golive.ui.adapter.RemoteDeviceFilesAdapter`
L28 · [class] public RemoteDeviceFilesAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/icatch/golive/ui/adapter/RemoteDeviceFilesAdapter.java`

字段/常量（18）：
- `int DATE = 0`  L29
- `int PHOTO = 1`  L30
- `OnItemClickListener callback`  L31
- `LayoutInflater inflater`  L32
- `Context mContext`  L33
- `View mRootView`  L34
- `String str_date_current`  L35
- `boolean showSelectedBtn = false`  L36
- `int currentClieckItem = -1`  L40
- `boolean isLoading = true`  L41
- `boolean is_loading_thumb = false`  L43
- `Handler load_image_handler = null`  L44
- `long past_timestamp = 0`  L45
- `boolean isLoadingMoreFile = false`  L46
- `boolean switch_cancel_load = false`  L47
- `boolean z = !this.switch_cancel_load`  L252
- `int i2 = this.currentClieckItem`  L281
- `long j = ICatchtekImageDownloader.sleep_millis + 1600`  L295

方法（25）：
- `public RemoteDeviceFilesAdapter(Context context, OnItemClickListener onItemClickListener)`  L184
- `int getIndexByList(FileItemInfo fileItemInfo)`  L190
- `void initAllFiles()`  L200
    - 体内字面量："\\." · "_" · "-" · "-"
- `void deleteFilesRefresh(List<FileItemInfo> list)`  L216
- `int getItemCount()`  L226 @Override
- `int getItemViewType(int i)`  L231 @Override
- `List<FileItemInfo> getListFilesSelected()`  L238
- `void m619x6c9d9c20(LocalFileViewHolder localFileViewHolder)`  L243
- `void m620x95f1f161(final LocalFileViewHolder localFileViewHolder, long j, Handler handler)`  L263
    - 体内字面量："ImageLoaderUtil" · "cancelTask is_loading_thumb = " · "; imageUri = "
- `void run()`  L271 @Override
- `void m621xfb1ed1d3(int i, FileItemInfo fileItemInfo, View view)`  L280
- `void loadImageWithThumbList(final LocalFileViewHolder localFileViewHolder)`  L290
- `void run()`  L299 @Override
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L307 @Override
    - 体内字面量："ImageLoaderUtil" · "onLoadingComplete imageUri = "
- `void onLoadingFailed(String str, View view)`  L323 @Override
    - 体内字面量："ImageLoaderUtil" · "onLoadingFailed imageUri = "
- `void onLoadingStarted(String str, View view)`  L329 @Override
    - 体内字面量："ImageLoaderUtil" · "onLoadingStarted imageUri = "
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L338 @Override
- `int getSpanSize(int i)`  L345 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i)`  L356 @Override
- `void onClick(View view)`  L368 @Override
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L384 @Override
- `boolean onSelectAllOrNone()`  L393
- `void renderAddList(List<FileItemInfo> list)`  L403
- `void renderList(List<FileItemInfo> list)`  L413
- `void setShowSelectedBtn(boolean z)`  L419
### `com.icatch.golive.ui.adapter.RemoteDeviceFilesAdapter$LocalDateViewHolder`
L49 · [class] public LocalDateViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/RemoteDeviceFilesAdapter.java`

字段/常量（1）：
- `TextView tv_date`  L50

方法（1）：
- `public LocalDateViewHolder(View view)`  L52
### `com.icatch.golive.ui.adapter.RemoteDeviceFilesAdapter$LocalFileViewHolder`
L58 · [class] public LocalFileViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/RemoteDeviceFilesAdapter.java`

字段/常量（8）：
- `CheckBox cb_select_item`  L59
- `int current_position`  L60
- `String current_thumb_path`  L61
- `ImageView iv_video_file`  L62
- `ProgressWheel progressBar`  L63
- `TextView tv_file_info`  L64
- `long j2 = j / 1000`  L85
- `String string`  L90

方法（10）：
- `public LocalFileViewHolder(View view)`  L66
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L78 @Override
- `String getDuration(long j)`  L84
- `void bindData(int i, FileItemInfo fileItemInfo)`  L89
- `void onLoadingComplete(String str2, View view, Bitmap bitmap)`  L124 @Override
    - 体内字面量："ImageLoaderUtil" · "onLoadingComplete imageUri = "
- `void onLoadingFailed(String str2, View view)`  L129 @Override
    - 体内字面量："ImageLoaderUtil" · "onLoadingFailed imageUri = "
- `void onLoadingStarted(String str2, View view)`  L134 @Override
    - 体内字面量："ImageLoaderUtil" · "onLoadingStarted imageUri = "
- `void cancelLoadImageView()`  L140
    - 体内字面量："ImageLoaderUtil" · "cancelLoadImageView is Empty"
- `void m622x4397b120(CompoundButton compoundButton, boolean z)`  L150
- `void showThumbWithPath()`  L171
### `com.icatch.golive.ui.adapter.RemoteDeviceFilesAdapter$OnItemClickListener`
L176 · [interface] public OnItemClickListener · `com/icatch/golive/ui/adapter/RemoteDeviceFilesAdapter.java`

方法（3）：
- `void onItemClick(FileItemInfo fileItemInfo, int i)`  L177
- `void onLoadMoreFile()`  L179
- `void onManualSelectedAll(boolean z)`  L181
### `com.icatch.golive.ui.adapter.SettingListAdapter`
L25 · [class] public SettingListAdapter · extends `BaseAdapter` · `com/icatch/golive/ui/adapter/SettingListAdapter.java`

字段/常量（7）：
- `String TAG = "SettingListAdapter"`  L26
- `BaseProrertys baseProrertys`  L27
- `CameraProperties cameraProperties`  L28
- `Context context`  L29
- `MyCamera currCamera`  L30
- `Handler handler`  L31
- `List<SettingMenu> menuList`  L32

方法（10）：
- `public SettingListAdapter(Context context, List<SettingMenu> list, Handler handler)`  L42
- `int getCount()`  L53 @Override
- `Object getItem(int i)`  L58 @Override
- `long getItemId(int i)`  L63 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L68 @Override
- `void onClick(View view2)`  L77 @Override
- `void onClick(View view2)`  L91 @Override
    - 体内字面量："toggleButton.setOnClickListener disableAudio="
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L106 @Override
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L126 @Override
    - 体内字面量："GB"
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L150 @Override
### `com.icatch.golive.ui.adapter.SettingListAdapter$ViewHolder`
L34 · [class] public final ViewHolder · `com/icatch/golive/ui/adapter/SettingListAdapter.java`

字段/常量（2）：
- `TextView text`  L35
- `TextView title`  L36

方法（1）：
- `public ViewHolder()`  L38
### `com.icatch.golive.ui.adapter.ViewPagerAdapter`
L10 · [class] public ViewPagerAdapter · extends `FragmentPagerAdapter` · `com/icatch/golive/ui/adapter/ViewPagerAdapter.java`

字段/常量（2）：
- `List<Fragment> mFragmentList`  L11
- `List<String> mFragmentTitleList`  L12

方法（5）：
- `public ViewPagerAdapter(FragmentManager fragmentManager)`  L14
- `void addFragment(Fragment fragment, String str)`  L20
- `int getCount()`  L26 @Override
- `Fragment getItem(int i)`  L31 @Override
- `CharSequence getPageTitle(int i)`  L36 @Override
### `com.icatch.golive.ui.adapter.YdeviceSettingAdapter`
L19 · [class] public YdeviceSettingAdapter · extends `RecyclerView.Adapter<YdeviceSettingViewHolder>` · `com/icatch/golive/ui/adapter/YdeviceSettingAdapter.java`

字段/常量（24）：
- `YdeviceSettingActivity mActivity`  L20
- `List<Map<String, String>> mList`  L21
- `YdeviceSettingOnClickListener mListener`  L22
- `String kCellMenuCmd = "cell_menu_cmd"`  L23
- `String kCellLeftText = "cell_left_text"`  L24
- `String kCellRightText = "cell_right_text"`  L25
- `String kCellRightArrow = "cell_right_arrow"`  L26
- `String kCmdDeviceInfo = "3003"`  L27
- `String kCmdDevicePassword = "3004"`  L28
- `String kCmdSoundRecord = "mic"`  L29
- `String kCmdTimeImprint = "osd"`  L30
- `String kCmdVideoMirror = "video_mirror"`  L31
- `String kCmdFrontLensRotation = "rotate"`  L32
- `String kCmdBackLensMirrorImage = "back_mirror"`  L33
- `String kCmdRecordDuration = "rec_split_duration"`  L34
- `String kCmdVideoDefinition = "rec_resolution"`  L35
- `String kCmdGSensor = "gsr_sensitivity"`  L36
- `String kCmdFreeSpace = "2004"`  L37
- `String kCmdDeviceVersionInfo = "2002"`  L38
- `String gCurSSID = "<binary/metadata>"`  L39
- `String deviceCurVersion = "<binary/metadata>"`  L40
- `String deviceFreeSpace = "<binary/metadata>"`  L41
- `List<Map<String, String>> list = this.mList`  L192
- `int i = 0`  L204

方法（10）：
- `public YdeviceSettingAdapter(YdeviceSettingActivity ydeviceSettingActivity, YdeviceSettingOnClickListener ydeviceSettingOnClickListener)`  L180
- `void initData()`  L186
- `int getItemCount()`  L191 @Override
- `String getgCurSSID()`  L199
- `void notifyItemChangedForCMD(String str)`  L203
- `void onBindViewHolder(YdeviceSettingViewHolder ydeviceSettingViewHolder, int i)`  L215 @Override
- `YdeviceSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L220 @Override
- `void refreshCurrentSSIDAndVersion(String str, String str2)`  L224
- `void refreshDeviceFreeSpace(String str)`  L230
- `void updataMenuData(List<Map<String, String>> list)`  L242
### `com.icatch.golive.ui.adapter.YdeviceSettingAdapter$YdeviceSettingOnClickListener`
L43 · [interface] public YdeviceSettingOnClickListener · `com/icatch/golive/ui/adapter/YdeviceSettingAdapter.java`

方法（2）：
- `void didClickCell(String str)`  L44
- `void didSwitchCell(String str, CompoundButton compoundButton, boolean z)`  L46
### `com.icatch.golive.ui.adapter.YdeviceSettingAdapter$YdeviceSettingViewHolder`
L49 · [class] YdeviceSettingViewHolder · extends `RecyclerView.ViewHolder` · `com/icatch/golive/ui/adapter/YdeviceSettingAdapter.java`

字段/常量（5）：
- `int current_position`  L50
- `ImageView iv_right_arrow`  L51
- `Switch switch_right`  L52
- `TextView tv_left`  L53
- `TextView tv_right`  L54

方法（6）：
- `public YdeviceSettingViewHolder(View view)`  L56
- `void onCheckedChanged(CompoundButton compoundButton, boolean z)`  L69 @Override
- `void onClick(View view2)`  L75 @Override
- `void bindData(int i)`  L81
- `void m623xf7a64120(CompoundButton compoundButton, boolean z)`  L168
- `void m624xf874bfa1(View view)`  L175
### `com.icatch.golive.ui.appdialog.AppDialog`
L15 · [class] public AppDialog · `com/icatch/golive/ui/appdialog/AppDialog.java`

字段/常量（8）：
- `String TAG = "AppDialog"`  L16
- `AlertDialog dialog = null`  L17
- `boolean needShown = true`  L18
- `AlertDialog alertDialog`  L31
- `AlertDialog alertDialog2 = dialog`  L32
- `PackageInfo packageInfo`  L49
- `OnDialogSureClickListener onDialogSureClickListener2 = onDialogSureClickListener`  L95
- `OnDialogSureClickListener onDialogSureClickListener2 = onDialogSureClickListener`  L167

方法（20）：
- `void closeDialog()`  L30
- `void showAPPVersionDialog(Context context)`  L48
- `void onClick(DialogInterface dialogInterface, int i)`  L60 @Override
- `void showConectFailureWarning(Context context)`  L67
- `void onClick(DialogInterface dialogInterface, int i)`  L72 @Override
- `void showDialogInfo(Context context, String str, boolean z, final OnDialogSureClickListener onDialogSureClickListener)`  L86
- `void onClick(DialogInterface dialogInterface, int i)`  L93 @Override
- `void showDialogQuit(final Context context, final int i)`  L110
- `void onClick(DialogInterface dialogInterface, int i2)`  L116 @Override
    - 体内字面量："ExitApp because of "
- `void showDialogQuit(Context context, final String str)`  L124
- `void onClick(DialogInterface dialogInterface, int i)`  L130 @Override
    - 体内字面量："ExitApp because of "
- `void showDialogWarn(Context context, int i)`  L138
- `void onClick(DialogInterface dialogInterface, int i2)`  L145 @Override
- `void showDialogWarn(Context context, int i, boolean z, final OnDialogSureClickListener onDialogSureClickListener)`  L158
- `void onClick(DialogInterface dialogInterface, int i2)`  L165 @Override
- `void showDialogWarn(Context context, String str)`  L178
- `void onClick(DialogInterface dialogInterface, int i)`  L185 @Override
- `void showLowBatteryWarning(Context context)`  L194
- `void onClick(DialogInterface dialogInterface, int i)`  L199 @Override
- `void showDialog(String str, String str2, boolean z)`  L206
### `com.icatch.golive.ui.appdialog.AppDialog$OnDialogButtonClickListener`
L20 · [interface] public OnDialogButtonClickListener · `com/icatch/golive/ui/appdialog/AppDialog.java`

方法（2）：
- `void onCancel()`  L21
- `void onSure()`  L23
### `com.icatch.golive.ui.appdialog.AppDialog$OnDialogSureClickListener`
L26 · [interface] public OnDialogSureClickListener · `com/icatch/golive/ui/appdialog/AppDialog.java`

方法（1）：
- `void onSure()`  L27
### `com.icatch.golive.ui.appdialog.AppToast`
L12 · [class] public AppToast · `com/icatch/golive/ui/appdialog/AppToast.java`

字段/常量（1）：
- `Toast toast`  L13

方法（3）：
- `void show(Context context, int i, int i2)`  L15
    - 体内字面量："é»è®¤çToast"
- `void show(Context context, CharSequence charSequence, int i)`  L24
    - 体内字面量："é»è®¤çToast"
- `void showCustom(Activity activity, int i, int i2)`  L33
### `com.icatch.golive.ui.appdialog.CustomDownloadDialog`
L13 · [class] public CustomDownloadDialog · `com/icatch/golive/ui/appdialog/CustomDownloadDialog.java`

字段/常量（6）：
- `AlertDialog alertDialog`  L14
- `AlertDialog.Builder builder`  L15
- `TextView cancelAllTxv`  L16
- `ListView downloadStatus`  L17
- `TextView message`  L18
- `AlertDialog alertDialog = this.alertDialog`  L21

方法（5）：
- `void dismissDownloadDialog()`  L20
- `void setAdapter(DownloadManagerAdapter downloadManagerAdapter)`  L27
- `void setBackBtnOnClickListener(View.OnClickListener onClickListener)`  L31
- `void setMessage(String str)`  L37
- `void showDownloadDialog(Context context, DownloadManagerAdapter downloadManagerAdapter)`  L41
### `com.icatch.golive.ui.appdialog.CustomProgressDialog`
L11 · [class] public CustomProgressDialog · extends `ProgressDialog` · `com/icatch/golive/ui/appdialog/CustomProgressDialog.java`

字段/常量（2）：
- `String text`  L12
- `String str`  L24

方法（5）：
- `public CustomProgressDialog(Context context)`  L14
- `public CustomProgressDialog(Context context, int i, String str)`  L18
- `void init(Context context)`  L23
- `void onCreate(Bundle bundle)`  L39 @Override
- `void show()`  L45 @Override
### `com.icatch.golive.ui.appdialog.SingleDownloadDialog`
L16 · [class] public SingleDownloadDialog · `com/icatch/golive/ui/appdialog/SingleDownloadDialog.java`

字段/常量（10）：
- `AlertDialog alertDialog`  L17
- `AlertDialog.Builder builder`  L18
- `Context context`  L19
- `ICatchFile curVideoFile`  L20
- `ImageButton exitBtn`  L21
- `TextView fileDownloadStatus`  L22
- `TextView fileNameTxv`  L23
- `NumberProgressBar numberProgressBar`  L24
- `AlertDialog alertDialog = this.alertDialog`  L44
- `AlertDialog alertDialog = this.alertDialog`  L57

方法（5）：
- `public SingleDownloadDialog(Context context, ICatchFile iCatchFile)`  L26
- `void dismissDownloadDialog()`  L43
- `void setBackBtnOnClickListener(View.OnClickListener onClickListener)`  L50
- `void showDownloadDialog()`  L56
- `void updateDownloadStatus(DownloadInfo downloadInfo)`  L63
    - 体内字面量："#.#" · "M" · "M"
### `com.icatch.golive.ui.ExtendComponent.BorderImageView`
L12 · [class] public BorderImageView · extends `ImageView` · `com/icatch/golive/ui/ExtendComponent/BorderImageView.java`

字段/常量（3）：
- `Context context`  L13
- `boolean isShow`  L14
- `Paint paint`  L15

方法（5）：
- `public BorderImageView(Context context)`  L17
- `public BorderImageView(Context context, AttributeSet attributeSet)`  L23
- `public BorderImageView(Context context, AttributeSet attributeSet, int i)`  L29
- `void onDraw(Canvas canvas)`  L36 @Override
- `void showBorder(boolean z)`  L50
### `com.icatch.golive.ui.ExtendComponent.CustomViewPager`
L9 · [class] public CustomViewPager · extends `ViewPager` · `com/icatch/golive/ui/ExtendComponent/CustomViewPager.java`

字段/常量（1）：
- `boolean isCanScroll`  L10

方法（5）：
- `public CustomViewPager(Context context)`  L12
- `public CustomViewPager(Context context, AttributeSet attributeSet)`  L17
- `boolean onTouchEvent(MotionEvent motionEvent)`  L23 @Override
- `void scrollTo(int i, int i2)`  L31 @Override
- `void setScanScroll(boolean z)`  L37
### `com.icatch.golive.ui.ExtendComponent.DragImageView`
L14 · [class] public DragImageView · extends `ImageView` · `com/icatch/golive/ui/ExtendComponent/DragImageView.java`

字段/常量（50）：
- `int MAX_H`  L15
- `int MAX_W`  L16
- `int MIN_H`  L17
- `int MIN_W`  L18
- `float afterLenght`  L19
- `float beforeLenght`  L20
- `int bitmap_H`  L21
- `int bitmap_W`  L22
- `Bitmap bm`  L23
- `int current_Bottom`  L24
- `int current_Left`  L25
- `int current_Right`  L26
- `int current_Top`  L27
- `int current_x`  L28
- `int current_y`  L29
- `boolean firstTouch`  L30
- `boolean isControl_H`  L31
- `boolean isControl_V`  L32
- `Activity mActivity`  L33
- `int maxZoom`  L34
- `int minZoom`  L35
- `MODE mode`  L36
- `int originalBottom`  L37
- `int originalLeft`  L38
- `int originalRight`  L39
- `int originalTop`  L40
- `float scale_temp`  L41
- `int screen_H`  L42
- `int screen_W`  L43
- `int start_x`  L44
- `int start_y`  L45
- `float f = this.afterLenght / this.beforeLenght`  L143
- `int i = this.current_x`  L153
- `int left = i - this.start_x`  L154
- `int i2 = this.current_y`  L156
- `int i3 = this.start_y`  L157
- `int top = i2 - i3`  L158
- `int i4 = this.screen_W`  L165
- `int i5 = this.screen_H`  L179
- `Bitmap bitmap = this.bm`  L203
- `int i = this.bitmap_W`  L232
- `int i2 = this.maxZoom`  L233
- `int i3 = this.minZoom`  L236
- `float f2 = 1.0f - f`  L242
- `int i = this.screen_H`  L285
- `int i2 = this.current_Bottom`  L292
- `int i3 = this.screen_H`  L293
- `int i4 = this.screen_W`  L308
- `int i5 = this.current_Right`  L315
- `int i6 = this.screen_W`  L316

方法（16）：
- `public DragImageView(Context context)`  L53
- `public DragImageView(Context context, AttributeSet attributeSet)`  L67
- `void setPosition(int i, int i2, int i3, int i4)`  L81
- `float getDistance(MotionEvent motionEvent)`  L85
- `void onLayout(boolean z, int i, int i2, int i3, int i4)`  L92 @Override
- `void onPointerDown(MotionEvent motionEvent)`  L96
- `void onTouchDown(MotionEvent motionEvent)`  L103
- `boolean onTouchEvent(MotionEvent motionEvent)`  L112 @Override
- `void onTouchMove(MotionEvent motionEvent)`  L137
- `void recyleBitmap()`  L202
- `void setImageBitmap(Bitmap bitmap, int i, int i2)`  L210
- `void setMaxAndMin()`  L228
- `void setScale(float f)`  L241
- `void setScreen_H(int i)`  L334
- `void setScreen_W(int i)`  L338
- `void setmActivity(Activity activity)`  L342
### `com.icatch.golive.ui.ExtendComponent.DragImageView$MODE`
L47 · [enum] private MODE · `com/icatch/golive/ui/ExtendComponent/DragImageView.java`

枚举常量（2）：
- `NONE()`  L48
- `DRAG()`  L49
### `com.icatch.golive.ui.ExtendComponent.HackyDrawerLayout`
L8 · [class] public HackyDrawerLayout · extends `DrawerLayout` · `com/icatch/golive/ui/ExtendComponent/HackyDrawerLayout.java`

方法（2）：
- `public HackyDrawerLayout(Context context)`  L9
- `boolean onInterceptTouchEvent(MotionEvent motionEvent)`  L14 @Override
### `com.icatch.golive.ui.ExtendComponent.HackyViewPager`
L9 · [class] public HackyViewPager · extends `ViewPager` · `com/icatch/golive/ui/ExtendComponent/HackyViewPager.java`

字段/常量（1）：
- `boolean isLocked`  L10

方法（8）：
- `public HackyViewPager(Context context)`  L12
- `public HackyViewPager(Context context, AttributeSet attributeSet)`  L17
- `boolean isLocked()`  L22
- `boolean onInterceptTouchEvent(MotionEvent motionEvent)`  L27 @Override
- `boolean onTouchEvent(MotionEvent motionEvent)`  L39 @Override
- `void setLocked(boolean z)`  L43
- `void setOffscreenPageLimit(int i)`  L48 @Override
- `void toggleLock()`  L52
### `com.icatch.golive.ui.ExtendComponent.MyProgressDialog`
L9 · [class] public MyProgressDialog · `com/icatch/golive/ui/ExtendComponent/MyProgressDialog.java`

字段/常量（2）：
- `ProgressDialog mDialog`  L10
- `ProgressDialog progressDialog = mDialog`  L13

方法（3）：
- `void closeProgressDialog()`  L12
- `void showProgressDialog(Context context, int i)`  L24
- `void showProgressDialog(Context context, String str)`  L31
### `com.icatch.golive.ui.ExtendComponent.MyToast`
L12 · [class] public MyToast · `com/icatch/golive/ui/ExtendComponent/MyToast.java`

字段/常量（3）：
- `Toast toast`  L13
- `Toast toast2 = toast`  L29
- `Toast toast2 = toast`  L44

方法（3）：
- `Toast getToast(Context context, String str)`  L15
- `void show(Context context, int i)`  L26
- `void show(Context context, String str)`  L41
### `com.icatch.golive.ui.ExtendComponent.NumberProgressBar`
L20 · [class] public NumberProgressBar · extends `View` · `com/icatch/golive/ui/ExtendComponent/NumberProgressBar.java`

字段/常量（50）：
- `String INSTANCE_MAX = "max"`  L21
- `String INSTANCE_PREFIX = "prefix"`  L22
- `String INSTANCE_PROGRESS = "progress"`  L23
- `String INSTANCE_REACHED_BAR_COLOR = "reached_bar_color"`  L24
- `String INSTANCE_REACHED_BAR_HEIGHT = "reached_bar_height"`  L25
- `String INSTANCE_STATE = "saved_instance"`  L26
- `String INSTANCE_SUFFIX = "suffix"`  L27
- `String INSTANCE_TEXT_COLOR = "text_color"`  L28
- `String INSTANCE_TEXT_SIZE = "text_size"`  L29
- `String INSTANCE_TEXT_VISIBILITY = "text_visibility"`  L30
- `String INSTANCE_UNREACHED_BAR_COLOR = "unreached_bar_color"`  L31
- `String INSTANCE_UNREACHED_BAR_HEIGHT = "unreached_bar_height"`  L32
- `int PROGRESS_TEXT_VISIBLE = 0`  L33
- `float default_progress_text_offset`  L34
- `float default_reached_bar_height`  L35
- `int default_reached_color`  L36
- `int default_text_color`  L37
- `float default_text_size`  L38
- `float default_unreached_bar_height`  L39
- `int default_unreached_color`  L40
- `String mCurrentDrawText`  L41
- `int mCurrentProgress`  L42
- `boolean mDrawReachedBar`  L43
- `float mDrawTextEnd`  L44
- `float mDrawTextStart`  L45
- `float mDrawTextWidth`  L46
- `boolean mDrawUnreachedBar`  L47
- `boolean mIfDrawText`  L48
- `OnProgressBarListener mListener`  L49
- `int mMaxProgress`  L50
- `float mOffset`  L51
- `String mPrefix`  L52
- `int mReachedBarColor`  L53
- `float mReachedBarHeight`  L54
- `Paint mReachedBarPaint`  L55
- `RectF mReachedRectF`  L56
- `String mSuffix`  L57
- `int mTextColor`  L58
- `Paint mTextPaint`  L59
- `float mTextSize`  L60
- `int mUnreachedBarColor`  L61
- `float mUnreachedBarHeight`  L62
- `Paint mUnreachedBarPaint`  L63
- `RectF mUnreachedRectF`  L64
- `String str = this.mPrefix + this.mCurrentDrawText + this.mSuffix`  L123
- `float f = this.mDrawTextStart + this.mDrawTextWidth + this.mOffset`  L143
- `int paddingTop`  L180
- `int paddingBottom`  L181
- `int i2 = paddingTop + paddingBottom`  L191
- `OnProgressBarListener onProgressBarListener = this.mListener`  L264

方法（39）：
- `public NumberProgressBar(Context context)`  L71
- `public NumberProgressBar(Context context, AttributeSet attributeSet)`  L75
- `public NumberProgressBar(Context context, AttributeSet attributeSet, int i)`  L79
    - 体内字面量："%"
- `void calculateDrawRectF()`  L121
- `void calculateDrawRectFWithoutProgressText()`  L155
- `void initializePainters()`  L166
- `int measure(int i, boolean z)`  L179
- `float dp2px(float f)`  L202
- `int getMax()`  L206
- `String getPrefix()`  L210
- `int getProgress()`  L214
- `float getProgressTextSize()`  L218
- `boolean getProgressTextVisibility()`  L222
- `int getReachedBarColor()`  L226
- `float getReachedBarHeight()`  L230
- `String getSuffix()`  L234
- `int getSuggestedMinimumHeight()`  L239 @Override
- `int getSuggestedMinimumWidth()`  L244 @Override
- `int getTextColor()`  L248
- `int getUnreachedBarColor()`  L252
- `float getUnreachedBarHeight()`  L256
- `void incrementProgressBy(int i)`  L260
- `void onDraw(Canvas canvas)`  L271 @Override
- `void onMeasure(int i, int i2)`  L289 @Override
- `void onRestoreInstanceState(Parcelable parcelable)`  L294 @Override
    - 体内字面量："progress"
- `Parcelable onSaveInstanceState()`  L316 @Override
    - 体内字面量："progress"
- `void setMax(int i)`  L333
- `void setOnProgressBarListener(OnProgressBarListener onProgressBarListener)`  L340
- `void setPrefix(String str)`  L344
- `void setProgress(int i)`  L352
- `void setProgressTextColor(int i)`  L360
- `void setProgressTextSize(float f)`  L366
- `void setProgressTextVisibility(ProgressTextVisibility progressTextVisibility)`  L372
- `void setReachedBarColor(int i)`  L377
- `void setReachedBarHeight(float f)`  L383
- `void setSuffix(String str)`  L387
- `void setUnreachedBarColor(int i)`  L395
- `void setUnreachedBarHeight(float f)`  L401
- `float sp2px(float f)`  L405
### `com.icatch.golive.ui.ExtendComponent.NumberProgressBar$ProgressTextVisibility`
L66 · [enum] public ProgressTextVisibility · `com/icatch/golive/ui/ExtendComponent/NumberProgressBar.java`

枚举常量（1）：
- `Visible()`  L67
### `com.icatch.golive.ui.ExtendComponent.ProgressWheel`
L15 · [class] public ProgressWheel · extends `View` · `com/icatch/golive/ui/ExtendComponent/ProgressWheel.java`

字段/常量（52）：
- `int barColor`  L16
- `int barLength`  L17
- `Paint barPaint`  L18
- `int barWidth`  L19
- `RectF circleBounds`  L20
- `int circleColor`  L21
- `RectF circleInnerContour`  L22
- `RectF circleOuterContour`  L23
- `Paint circlePaint`  L24
- `int circleRadius`  L25
- `int contourColor`  L26
- `Paint contourPaint`  L27
- `float contourSize`  L28
- `int delayMillis`  L29
- `int fullRadius`  L30
- `RectF innerCircleBounds`  L31
- `boolean isSpinning`  L32
- `int layoutHeight`  L33
- `int layoutWidth`  L34
- `int paddingBottom`  L35
- `int paddingLeft`  L36
- `int paddingRight`  L37
- `int paddingTop`  L38
- `float progress`  L39
- `int rimColor`  L40
- `Paint rimPaint`  L41
- `int rimWidth`  L42
- `float spinSpeed`  L43
- `String[] splitText`  L44
- `String text`  L45
- `int textColor`  L46
- `Paint textPaint`  L47
- `int textSize`  L48
- `float f = this.progress + this.spinSpeed`  L112
- `int i = this.layoutWidth - iMin`  L122
- `int i3 = i / 2`  L126
- `float f = this.paddingLeft`  L131
- `int i4 = this.barWidth`  L132
- `int i5 = this.paddingLeft`  L134
- `int i6 = this.barWidth`  L135
- `int i7 = width - this.paddingRight`  L139
- `int i8 = this.barWidth`  L140
- `float f = this.progress + i`  L254
- `Paint paint = this.barPaint`  L321
- `Paint paint = this.barPaint`  L333
- `Paint paint = this.circlePaint`  L341
- `Paint paint = this.contourPaint`  L353
- `Paint paint = this.contourPaint`  L361
- `Paint paint = this.rimPaint`  L395
- `Paint paint = this.rimPaint`  L407
- `Paint paint = this.textPaint`  L424
- `Paint paint = this.textPaint`  L432

方法（53）：
- `public ProgressWheel(Context context, AttributeSet attributeSet)`  L50
- `void parseAttributes(TypedArray typedArray)`  L88
- `void scheduleRedraw()`  L111
- `void setupBounds()`  L120
- `void setupPaints()`  L146
- `int getBarColor()`  L168
- `int getBarLength()`  L172
- `int getBarWidth()`  L176
- `int getCircleColor()`  L180
- `int getCircleRadius()`  L184
- `int getContourColor()`  L188
- `float getContourSize()`  L192
- `int getDelayMillis()`  L196
- `int getPaddingBottom()`  L201 @Override
- `int getPaddingLeft()`  L206 @Override
- `int getPaddingRight()`  L211 @Override
- `int getPaddingTop()`  L216 @Override
- `int getProgress()`  L220
- `int getRimColor()`  L224
- `Shader getRimShader()`  L228
- `int getRimWidth()`  L232
- `float getSpinSpeed()`  L236
- `int getTextColor()`  L240
- `int getTextSize()`  L244
- `void incrementProgress()`  L248
- `void incrementProgress(int i)`  L252
- `boolean isSpinning()`  L262
- `void onDraw(Canvas canvas)`  L267 @Override
- `void onMeasure(int i, int i2)`  L287 @Override
- `void onSizeChanged(int i, int i2, int i3, int i4)`  L304 @Override
- `void resetCount()`  L313
    - 体内字面量："0%"
- `void setBarColor(int i)`  L319
- `void setBarLength(int i)`  L327
- `void setBarWidth(int i)`  L331
- `void setCircleColor(int i)`  L339
- `void setCircleRadius(int i)`  L347
- `void setContourColor(int i)`  L351
- `void setContourSize(float f)`  L359
- `void setDelayMillis(int i)`  L367
- `void setPaddingBottom(int i)`  L371
- `void setPaddingLeft(int i)`  L375
- `void setPaddingRight(int i)`  L379
- `void setPaddingTop(int i)`  L383
- `void setProgress(int i)`  L387
- `void setRimColor(int i)`  L393
- `void setRimShader(Shader shader)`  L401
- `void setRimWidth(int i)`  L405
- `void setSpinSpeed(float f)`  L413
- `void setText(String str)`  L417
    - 体内字面量："\n"
- `void setTextColor(int i)`  L422
- `void setTextSize(int i)`  L430
- `void startSpinning()`  L438
- `void stopSpinning()`  L443
### `com.icatch.golive.ui.ExtendComponent.RoundAngleImageView`
L17 · [class] public RoundAngleImageView · extends `ImageView` · `com/icatch/golive/ui/ExtendComponent/RoundAngleImageView.java`

字段/常量（4）：
- `Paint paint`  L18
- `Paint paint2`  L19
- `int roundHeight`  L20
- `int roundWidth`  L21

方法（9）：
- `public RoundAngleImageView(Context context)`  L23
- `public RoundAngleImageView(Context context, AttributeSet attributeSet)`  L30
- `public RoundAngleImageView(Context context, AttributeSet attributeSet, int i)`  L37
- `void drawLiftDown(Canvas canvas)`  L44
- `void drawLiftUp(Canvas canvas)`  L54
- `void drawRightDown(Canvas canvas)`  L64
- `void drawRightUp(Canvas canvas)`  L74
- `void init(Context context, AttributeSet attributeSet)`  L84
- `void draw(Canvas canvas)`  L106 @Override
### `com.icatch.golive.ui.ExtendComponent.ZoomView`
L20 · [class] public ZoomView · extends `RelativeLayout` · `com/icatch/golive/ui/ExtendComponent/ZoomView.java`

字段/常量（14）：
- `int DISPLAY_DURATION = 5000`  L21
- `float MAX_VALUE = 0.0f`  L22
- `float MIN_VALUE = 0.0f`  L23
- `String TAG = "ZoomView"`  L24
- `int zoomGrained = 10`  L25
- `boolean firstCreate`  L26
- `OnSeekBarChangeListener onSeekBarChangeListener`  L27
- `Timer timer`  L28
- `SeekBar zoomBar`  L29
- `ImageButton zoomIn`  L30
- `ImageButton zoomOut`  L31
- `TextView zoomRateText`  L32
- `Timer timer`  L68
- `Timer timer = this.timer`  L134

方法（21）：
- `public ZoomView(Context context, AttributeSet attributeSet)`  L42
- `void run()`  L52 @Override
- `void updateZoomRateText(float f)`  L58
    - 体内字面量："updateZoomRateText zoomRate =" · "x "
- `float getProgress()`  L63
- `void setHide()`  L67
- `void setMaxValue(float f)`  L77
- `void setMaxValue(int i)`  L82
- `void setMinValue(float f)`  L87
- `void setMinValue(int i)`  L91
- `void setOnSeekBarChangeListener(final OnSeekBarChangeListener onSeekBarChangeListener)`  L95
- `void onProgressChanged(SeekBar seekBar, int i, boolean z)`  L99 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L104 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L109 @Override
- `void setProgress(float f)`  L115
    - 体内字面量："setProgress value ="
- `void setZoomInOnclickListener(View.OnClickListener onClickListener)`  L120
- `void setZoomOutOnclickListener(View.OnClickListener onClickListener)`  L124
- `void startDisplay()`  L128
- `void run()`  L141 @Override
- `void run()`  L146 @Override
- `void updateZoomBarValue(float f)`  L157
    - 体内字面量："updateZoomBarValue value ="
- `void updateZoomBarValue(int i)`  L162
    - 体内字面量："updateZoomBarValue value ="
### `com.icatch.golive.ui.ExtendComponent.ZoomView$OnSeekBarChangeListener`
L34 · [interface] public OnSeekBarChangeListener · `com/icatch/golive/ui/ExtendComponent/ZoomView.java`

方法（3）：
- `void onProgressChanged(ZoomView zoomView, float f, boolean z)`  L35
- `void onStartTrackingTouch(ZoomView zoomView)`  L37
- `void onStopTrackingTouch(ZoomView zoomView)`  L39
### `com.icatch.golive.ui.Fragment.AddNewCamFragment`
L31 · [class] public AddNewCamFragment · extends `Fragment` · `com/icatch/golive/ui/Fragment/AddNewCamFragment.java`

字段/常量（13）：
- `Button BTPairBtn`  L32
- `Context appContext`  L33
- `Handler appStartHandler`  L34
- `ImageButton backBtn`  L35
- `OnFragmentInteractionListener mListener`  L36
- `int position`  L37
- `Button usbConnectCamBtn`  L38
- `Button wifiAudoConnectBtn`  L39
- `Button wifiConnectCamBtn`  L40
- `String TAG = "AddNewCamFragment"`  L41
- `String pwd = AppInfo.default_pwd`  L42
- `AddNewCamFragment addNewCamFragment = AddNewCamFragment.this`  L89
- `OnFragmentInteractionListener onFragmentInteractionListener = this.mListener`  L184

方法（21）：
- `public AddNewCamFragment()`  L44
- `public AddNewCamFragment(Context context, Handler handler, int i)`  L47
- `void autoConnectWifi(final String str)`  L54
    - 体内字面量："[一-龥a-zA-z0-9@_-]+.*"
- `void onError(int i)`  L57 @Override
- `void onSuccess(String str2)`  L66 @Override
- `void configDevicePwd(int i)`  L73
- `void showConfigDevicePwdDialog(Context context, int i)`  L77
- `void onClick(DialogInterface dialogInterface, int i2)`  L87 @Override
- `void onClick(DialogInterface dialogInterface, int i2)`  L95 @Override
- `void onAttach(Context context)`  L102 @Override
    - 体内字面量："onAttach" · " must implement OnFragmentInteractionListener"
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L113 @Override
    - 体内字面量："onCreateView"
- `void onClick(View view)`  L123 @Override
- `void onClick(View view)`  L133 @Override
- `void onClick(View view)`  L139 @Override
- `void onClick(View view)`  L145 @Override
    - 体内字面量："appLocalInfo" · "camera_position" · "BTPairBeginFragment"
- `void onClick(View view)`  L158 @Override
- `void onDestroy()`  L168 @Override
    - 体内字面量："onDestroy"
- `void onDetach()`  L174 @Override
    - 体内字面量："onDetach"
- `void onResume()`  L181 @Override
    - 体内字面量："onResume"
- `void onStart()`  L191 @Override
    - 体内字面量："onStart"
- `void onStop()`  L197 @Override
    - 体内字面量："onStop"
### `com.icatch.golive.ui.Fragment.BaseMultiPbFragment`
L10 · [class] public abstract BaseMultiPbFragment · extends `Fragment` · `com/icatch/golive/ui/Fragment/BaseMultiPbFragment.java`

方法（7）：
- `void changePreviewType(PhotoWallLayoutType photoWallLayoutType)`  L11
- `void deleteFile()`  L13
- `List<MultiPbItemInfo> getSelectedList()`  L15
- `void loadPhotoWall()`  L17
- `void quitEditMode()`  L19
- `void selectOrCancelAll(boolean z)`  L21
- `void setOperationListener(OnStatusChangedListener onStatusChangedListener)`  L23
### `com.icatch.golive.ui.Fragment.BaseMultiPbFragment2`
L7 · [class] public abstract BaseMultiPbFragment2 · extends `Fragment` · `com/icatch/golive/ui/Fragment/BaseMultiPbFragment2.java`

方法（5）：
- `void changePreviewType(int i)`  L8
- `void loadPhotoWall()`  L10
- `void loadThreadStop()`  L12
- `void quitEditMode()`  L14
- `void setOperationListener(OnStatusChangedListener onStatusChangedListener)`  L16
### `com.icatch.golive.ui.Fragment.BTPairBeginFragment`
L25 · [class] public BTPairBeginFragment · extends `Fragment implements BTPairBeginFragmentView` · implements `BTPairBeginFragmentView` · `com/icatch/golive/ui/Fragment/BTPairBeginFragment.java`

字段/常量（15）：
- `String TAG = "BTPairBeginFragment"`  L26
- `Context appContext`  L27
- `Handler appStartHandler`  L28
- `ImageButton backBtn`  L29
- `ListView bluetoothListView`  L30
- `Button btnSearchBLE`  L31
- `Button btnSearchBluetooth`  L32
- `TextView listHeader`  L33
- `OnFragmentInteractionListener mListener`  L34
- `View myView`  L35
- `BTPairBeginPresenter presenter`  L36
- `ImageButton refreshBtn`  L37
- `View view = this.myView`  L67
- `OnFragmentInteractionListener onFragmentInteractionListener = this.mListener`  L139
- `ListView listView = this.bluetoothListView`  L149

方法（14）：
- `public BTPairBeginFragment()`  L39
- `public BTPairBeginFragment(Context context, Handler handler)`  L42
- `void onAttach(Context context)`  L48 @Override
    - 体内字面量："onAttach" · " must implement OnFragmentInteractionListener"
- `void onCreate(Bundle bundle)`  L59 @Override
    - 体内字面量："onCreate"
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L65 @Override
    - 体内字面量："onCreateView myView="
- `void onItemClick(AdapterView<?> adapterView, View view2, int i, long j)`  L87 @Override
- `void onClick(View view2)`  L93 @Override
- `void onClick(View view2)`  L105 @Override
- `void onClick(View view2)`  L115 @Override
- `void onDestroy()`  L123 @Override
    - 体内字面量："onDestroy"
- `void onDetach()`  L130 @Override
    - 体内字面量："onDetach"
- `void onResume()`  L137 @Override
    - 体内字面量："onResume"
- `void setBTListViewAdapter(BaseAdapter baseAdapter)`  L148 @Override
- `void setListHeader(int i)`  L156 @Override
### `com.icatch.golive.ui.Fragment.BTPairCompletedFragment`
L35 · [class] public BTPairCompletedFragment · extends `Fragment` · `com/icatch/golive/ui/Fragment/BTPairCompletedFragment.java`

字段/常量（19）：
- `int CONNECT_CAMERA_FAILED = 17`  L36
- `int CONNECT_WIFI_FAILED = 16`  L37
- `int ENABLE_WIFI_FAILED = 14`  L38
- `int START_CHECK_CONNECT_WIFI = 19`  L39
- `Handler appStartHandler`  L40
- `ImageButton backBtn`  L41
- `Timer connectTimer`  L42
- `ExecutorService executor`  L43
- `ICatchWifiInformation iCatchWifiAPInformation`  L44
- `OnFragmentInteractionListener mListener`  L45
- `View myView`  L46
- `String password`  L47
- `TextView txvPairCompleted`  L48
- `WifiCheck wifiCheck`  L49
- `String TAG = "BTPairCompletedFragment"`  L50
- `String ssid = "<binary/metadata>"`  L51
- `int i = message.what`  L55
- `Boolean bool = false`  L236
- `OnFragmentInteractionListener onFragmentInteractionListener = this.mListener`  L310

方法（10）：
- `void handleMessage(Message message)`  L54 @Override
- `public BTPairCompletedFragment()`  L227
- `public BTPairCompletedFragment(Handler handler)`  L230
- `boolean enableWifi()`  L235
- `void onAttach(Context context)`  L265 @Override
    - 体内字面量：" must implement OnFragmentInteractionListener"
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L276 @Override
- `void onClick(View view)`  L283 @Override
- `void onClick(View view)`  L293 @Override
- `void onDetach()`  L303 @Override
- `void onResume()`  L309 @Override
### `com.icatch.golive.ui.Fragment.BTPairCompletedFragment$ConnectWifiThread`
L77 · [class] ConnectWifiThread · implements `Runnable` · `com/icatch/golive/ui/Fragment/BTPairCompletedFragment.java`

字段/常量（4）：
- `int connectNum = 4`  L78
- `BTPairCompletedFragment bTPairCompletedFragment = BTPairCompletedFragment.this`  L155
- `BTPairCompletedFragment bTPairCompletedFragment2 = BTPairCompletedFragment.this`  L157
- `int i = this.connectNum - 1`  L181

方法（6）：
- `void run()`  L84 @Override
    - 体内字面量："------start getWifiInformation" · "------end getWifiInformation iCatchWifiAPInformation="
- `void run()`  L97 @Override
    - 体内字面量："get Wifi information is null!" · "getWifiInformation IchBluetoothDeviceBusyException"
- `void run()`  L113 @Override
    - 体内字面量："Device busy!" · "getWifiInformation IchBluetoothTimeoutException"
- `void run()`  L128 @Override
    - 体内字面量："connent timeout!" · "getWifiInformation IOException"
- `void run()`  L143 @Override
    - 体内字面量："connent IOException!"
- `void run()`  L162 @Override
    - 体内字面量："ssid=[" · "],pwd=[" · "]" · "connectWifi ssid=[" · "]" · "connectWifi password=[" · "]"
### `com.icatch.golive.ui.Fragment.BTPairCompletedFragment$WifiCheckTask`
L190 · [class] WifiCheckTask · extends `TimerTask` · `com/icatch/golive/ui/Fragment/BTPairCompletedFragment.java`

字段/常量（2）：
- `int reconnectTime = 0`  L191
- `int i = this.reconnectTime + 1`  L216

方法（2）：
- `void run()`  L197 @Override
    - 体内字面量："WifiCheckTask ssid=" · "isWifiConnect() == true"
- `void run()`  L207 @Override
    - 体内字面量："appLocalInfo" · "camera_position" · "isWifiConnect() == false  reconnectTime ="
### `com.icatch.golive.ui.Fragment.BTPairSetupFragment`
L29 · [class] public BTPairSetupFragment · extends `Fragment` · `com/icatch/golive/ui/Fragment/BTPairSetupFragment.java`

字段/常量（14）：
- `String TAG = "BTPairSetupFragment"`  L30
- `Handler appStartHandler`  L31
- `ImageButton backBtn`  L32
- `Button btnSetup`  L33
- `EditText cameraPassword`  L34
- `EditText cameraSsid`  L35
- `ICatchWifiInformation iCatchWifiInformation`  L37
- `OnFragmentInteractionListener mListener`  L38
- `View myView`  L39
- `TextView skipTxv`  L40
- `View view = this.myView`  L58
- `boolean z`  L144
- `boolean wifiInformation = false`  L154
- `OnFragmentInteractionListener onFragmentInteractionListener = this.mListener`  L225

方法（12）：
- `public BTPairSetupFragment(Handler handler)`  L42
- `void onAttach(Context context)`  L47 @Override
    - 体内字面量：" must implement OnFragmentInteractionListener"
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L57 @Override
- `void onClick(View view2)`  L71 @Override
- `void onClick(View view2)`  L81 @Override
    - 体内字面量："BTPairCompletedFragment"
- `void run()`  L91 @Override
    - 体内字面量："start getWifiInformation" · "getWifiInformation IchBluetoothDeviceBusyException" · "getWifiInformation IchBluetoothTimeoutException" · "getWifiInformation IOException" · "end getWifiInformation iCatchWifiInformation="
- `void run()`  L115 @Override
    - 体内字面量："get Wifi information is null!" · "getWifiInformation ssid=" · "getWifiInformation password="
- `void run()`  L128 @Override
    - 体内字面量："handler.post setText"
- `void onClick(View view2)`  L143 @Override
- `void onDestroy()`  L201 @Override
    - 体内字面量："onDestroy() iCatchBluetoothClient.pancamGLRelease()" · "iCatchBluetoothClient.pancamGLRelease() IOException"
- `void onDetach()`  L218 @Override
- `void onResume()`  L224 @Override
### `com.icatch.golive.ui.Fragment.DialogFragmentFromBottom`
L35 · [class] public DialogFragmentFromBottom · extends `DialogFragment` · `com/icatch/golive/ui/Fragment/DialogFragmentFromBottom.java`

字段/常量（42）：
- `String ANIM = "anim_style"`  L36
- `String BOTTOM = "show_bottom"`  L37
- `String CANCEL = "out_cancel"`  L38
- `String DIM = "dim_amount"`  L39
- `String HEIGHT = "height"`  L40
- `String LAYOUT = "layout_id"`  L41
- `String MARGIN = "margin"`  L42
- `String TAG = "DialogFragmentFromBottom"`  L43
- `String WIDTH = "width"`  L44
- `String formatType = "yyyy-MM-dd HH:mm:ss"`  L45
- `int animStyle`  L46
- `FilterGridAdaper cameraTypeAdaper`  L47
- `GridView cameraTypeGridView`  L48
- `int height`  L49
- `FileFilter lastFilter`  L50
- `LinearLayout layout`  L51
- `int layoutId`  L52
- `int margin`  L53
- `TextView maxTimeEdt`  L54
- `TextView minTimeEdt`  L55
- `OnSureClickListener onSureClickListener`  L56
- `TextView resetTxv`  L57
- `FrameLayout rootlayout`  L58
- `LinkedList<FilterItem> sensorsTypeList`  L59
- `TextView sensorsTypeTxv`  L60
- `TextView sureTxv`  L61
- `FilterGridAdaper timeAdaper`  L62
- `GridView timeGridView`  L63
- `LinkedList<FilterItem> timeTypelist`  L64
- `int width`  L65
- `float dimAmount = 0.5f`  L66
- `boolean showBottom = true`  L67
- `boolean outCancel = true`  L68
- `int sensorsNum = 2`  L69
- `boolean needFilterSensors = false`  L70
- `FileFilter fileFilter = this.lastFilter`  L131
- `FileFilter fileFilter2 = this.lastFilter`  L154
- `FilterGridAdaper filterGridAdaper = this.cameraTypeAdaper`  L167
- `FilterGridAdaper filterGridAdaper = this.timeAdaper`  L181
- `int selectorPosition`  L249
- `int selectorPosition2`  L250
- `FileFilter fileFilter = null`  L253

方法（32）：
- `int getPositionByType(List<FilterItem> list, int i)`  L76
- `void initData()`  L88
    - 体内字面量："ä»å¤©" · "è¿ä¸å¤©" · "è¿ä¸å¨" · "è¿ä¸ä¸ªæ" · "è¿åå¹´" · "å¨é¨" · "åç½®" · "åç½®"
- `void initParams()`  L103
- `void initUi()`  L130
- `void resetCameraTypeFilter()`  L166
- `void resetTimeEdit()`  L174
- `void resetTimeFilter()`  L180
- `void show02(OnTimeSelectListener onTimeSelectListener)`  L188
- `String getDateToString(long j)`  L202
- `String getTime(Date date)`  L206
- `void onCreate(Bundle bundle)`  L211 @Override
    - 体内字面量："width" · "height"
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L227 @Override
- `void onClick(View view)`  L240 @Override
- `void onClick(View view)`  L248 @Override
- `void onClick(View view)`  L291 @Override
- `void onTimeSelect(Date date, View view2)`  L294 @Override
- `void onClick(View view)`  L306 @Override
- `void onTimeSelect(Date date, View view2)`  L309 @Override
- `void onItemClick(AdapterView<?> adapterView, View view, int i, long j)`  L324 @Override
- `void onItemClick(AdapterView<?> adapterView, View view, int i, long j)`  L334 @Override
- `void onSaveInstanceState(Bundle bundle)`  L344 @Override
    - 体内字面量："width" · "height"
- `void onStart()`  L357 @Override
- `DialogFragmentFromBottom setAnimStyle(int i)`  L362
- `DialogFragmentFromBottom setDimAmount(float f)`  L367
- `DialogFragmentFromBottom setHeight(int i)`  L372
- `void setLastFilter(FileFilter fileFilter)`  L377
- `DialogFragmentFromBottom setMargin(int i)`  L381
- `void setOnSureClickListener(OnSureClickListener onSureClickListener)`  L386
- `DialogFragmentFromBottom setOutCancel(boolean z)`  L390
- `DialogFragmentFromBottom setShowBottom(boolean z)`  L395
- `DialogFragmentFromBottom setWidth(int i)`  L400
- `DialogFragmentFromBottom show(FragmentManager fragmentManager)`  L405
### `com.icatch.golive.ui.Fragment.DialogFragmentFromBottom$OnSureClickListener`
L72 · [interface] public OnSureClickListener · `com/icatch/golive/ui/Fragment/DialogFragmentFromBottom.java`

方法（1）：
- `void onSureClick(FileFilter fileFilter)`  L73
### `com.icatch.golive.ui.Fragment.LocalDeviceFilesFragment`
L30 · [class] public LocalDeviceFilesFragment · extends `Fragment implements LocalMultiPbFragmentView` · implements `LocalMultiPbFragmentView` · `com/icatch/golive/ui/Fragment/LocalDeviceFilesFragment.java`

字段/常量（18）：
- `String TAG = "LocalDeviceFilesFragment"`  L31
- `ImageButton ib_delete`  L32
- `LinearLayout ll_file_option`  L33
- `LocalDeviceFilesAdapter mAdapter`  L34
- `OnStatusChangedListener modeChangedListener`  L35
- `TextView noContentTxv`  L36
- `LocalDeviceFilesFragmentPresenter presenter`  L37
- `RecyclerView rv_remote_files`  L38
- `boolean isCreated = false`  L39
- `boolean isVisible = false`  L40
- `int fileType = 1`  L41
- `boolean currentDownloadState = false`  L42
- `int i = this.mAdapter.currentClieckItem`  L46
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L85
- `String str = TAG`  L167
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L187
- `LocalDeviceFilesAdapter localDeviceFilesAdapter`  L199
- `String str = TAG`  L238

方法（27）：
- `void cleanClickItemBorder()`  L45
- `LocalDeviceFilesFragment newInstance(int i)`  L53
    - 体内字面量："FILE_TYPE"
- `void onFilesDelete()`  L61
- `void onComplete(boolean z, List<FileItemInfo> list)`  L64 @Override
    - 体内字面量："FileListView.DeleteResponse" · "onComplete boolean = " · "; List<FileItemInfo> = "
- `void changePreviewType(int i)`  L73
    - 体内字面量："start changePreviewType presenter="
- `void clearDownloadState()`  L77
- `void clickSelectState()`  L84
- `com.tinyai.libmediacomponent.components.filelist.OperationMode getOperationMode()`  L92 @Override
- `void m508xbdc4d36f(View view)`  L97
- `void onConfigurationChanged(Configuration configuration)`  L102 @Override
    - 体内字面量："1122" · "MultiPbPhotoFragment onConfigurationChanged"
- `void onCreate(Bundle bundle)`  L109 @Override
    - 体内字面量："FILE_TYPE" · "onCreate fileType="
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L117 @Override
    - 体内字面量："MultiPbPhotoFragment onCreateView"
- `void onClick(View view)`  L129 @Override
- `void onItemClick(FileItemInfo fileItemInfo, int i)`  L140 @Override
- `void onManualSelectedAll(boolean z)`  L149 @Override
- `void onDestroy()`  L159 @Override
    - 体内字面量："start onDestroy()"
- `void onResume()`  L165 @Override
- `boolean onSelectAllOrNone()`  L175
- `void onStop()`  L180 @Override
    - 体内字面量："start onStop()"
- `void quitEditMode()`  L186 @Override
- `void refreshPhotoWall()`  L193
- `void renderList(List<FileItemInfo> list)`  L198 @Override
- `boolean setDownloadState()`  L206
- `void setFileListViewVisibility(int i)`  L221 @Override
- `void setNoContentTxvVisibility(int i)`  L225 @Override
- `void setOperationListener(OnStatusChangedListener onStatusChangedListener)`  L231
- `void setUserVisibleHint(boolean z)`  L236 @Override
### `com.icatch.golive.ui.Fragment.LocalMultiPbFragment`
L22 · [class] public LocalMultiPbFragment · extends `Fragment implements LocalMultiPbFragmentView` · implements `LocalMultiPbFragmentView` · `com/icatch/golive/ui/Fragment/LocalMultiPbFragment.java`

字段/常量（13）：
- `String TAG = "LocalMultiPbFragment"`  L23
- `FileListView fileListView`  L24
- `OnStatusChangedListener modeChangedListener`  L25
- `TextView noContentTxv`  L26
- `LocalMultiPbFragmentPresenter presenter`  L27
- `boolean isCreated = false`  L28
- `boolean isVisible = false`  L29
- `int fileType = 1`  L30
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L47
- `String str = TAG`  L133
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L150
- `FileListView fileListView = this.fileListView`  L162
- `String str = TAG`  L189

方法（23）：
- `LocalMultiPbFragment newInstance(int i)`  L32
    - 体内字面量："FILE_TYPE"
- `void changePreviewType(int i)`  L40
    - 体内字面量："start changePreviewType presenter="
- `void clickSelectState()`  L45
- `com.tinyai.libmediacomponent.components.filelist.OperationMode getOperationMode()`  L54 @Override
- `void onConfigurationChanged(Configuration configuration)`  L59 @Override
    - 体内字面量："1122" · "MultiPbPhotoFragment onConfigurationChanged"
- `void onCreate(Bundle bundle)`  L66 @Override
    - 体内字面量："FILE_TYPE" · "onCreate fileType="
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L74 @Override
    - 体内字面量："MultiPbPhotoFragment onCreateView"
- `void deleteOnClick(FileItemInfo fileItemInfo, int i)`  L90 @Override
- `void downloadOnClick(FileItemInfo fileItemInfo, int i)`  L94 @Override
- `void itemOnClick(FileItemInfo fileItemInfo, int i)`  L98 @Override
- `void itemOnLongClick(FileItemInfo fileItemInfo, int i)`  L103 @Override
- `void deleteOnClick(List<FileItemInfo> list, FileListView.DeleteResponse deleteResponse)`  L112 @Override
- `void downloadOnClick(List<FileItemInfo> list)`  L117 @Override
- `void onDestroy()`  L125 @Override
    - 体内字面量："start onDestroy()"
- `void onResume()`  L131 @Override
- `void onStop()`  L142 @Override
    - 体内字面量："start onStop()"
- `void quitEditMode()`  L148 @Override
- `void refreshPhotoWall()`  L156
- `void renderList(List<FileItemInfo> list)`  L161 @Override
- `void setFileListViewVisibility(int i)`  L169 @Override
- `void setNoContentTxvVisibility(int i)`  L176 @Override
- `void setOperationListener(OnStatusChangedListener onStatusChangedListener)`  L182
- `void setUserVisibleHint(boolean z)`  L187 @Override
### `com.icatch.golive.ui.Fragment.LYBaseFragment`
L11 · [class] public abstract LYBaseFragment · extends `Fragment` · `com/icatch/golive/ui/Fragment/LYBaseFragment.java`

字段/常量（1）：
- `boolean currentDownloadState = false`  L12

方法（3）：
- `boolean onSelectAllOrNone()`  L14
- `boolean setDownloadState()`  L16
- `boolean verifyStoragePermissions(Activity activity)`  L18
    - 体内字面量："android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.READ_EXTERNAL_STORAGE" · "android.permission.WRITE_EXTERNAL_STORAGE" · "android.permission.ACCESS_FINE_LOCATION"
### `com.icatch.golive.ui.Fragment.LYRemoteFileFragment`
L44 · [class] public LYRemoteFileFragment · extends `LYBaseFragment` · `com/icatch/golive/ui/Fragment/LYRemoteFileFragment.java`

字段/常量（14）：
- `String currentVideoType`  L45
- `int lastVisibleItem`  L46
- `LinearLayout ll_file_option`  L47
- `LYRemoteFileAdapter mAdapter`  L48
- `GridLayoutManager mLayoutManager`  L49
- `TextView no_content_txv`  L50
- `ProgressWheel pw_load_more`  L51
- `RecyclerView rv_remote_files`  L52
- `int load_files_count = 0`  L53
- `boolean isLoading = false`  L56
- `int i = lYRemoteFileFragment.load_files_count`  L148
- `LYRemoteFileFragment lYRemoteFileFragment = LYRemoteFileFragment.this`  L229
- `int i3 = this.mAdapter.currentClieckItem`  L318
- `LYRemoteFileAdapter lYRemoteFileAdapter = this.mAdapter`  L323

方法（29）：
- `public LYRemoteFileFragment(String str)`  L142
- `int access$908(LYRemoteFileFragment lYRemoteFileFragment)`  L147
- `void deleteOneFile(final List<FileInfo> list, final int i)`  L154
    - 体内字面量："QzIntegratedCircuit"
- `void handleMessage(Message message)`  L162 @Override
- `void getFileList()`  L178
- `void initView(View view)`  L186
- `void onClick(View view2)`  L190 @Override
- `void onClick(View view2)`  L196 @Override
- `void onItemClick(int i)`  L207 @Override
- `void onManualSelectedAll(boolean z)`  L212 @Override
- `void onScrollStateChanged(RecyclerView recyclerView, int i)`  L219 @Override
    - 体内字面量："QzIntegratedCircuit"
- `void onScrolled(RecyclerView recyclerView, int i, int i2)`  L227 @Override
- `void lambda$onRecyclerViewItemClick$3(ArrayList arrayList)`  L237
- `void loadMoreFile()`  L241
- `void onDeleteFile()`  L252
- `void onClick(DialogInterface dialogInterface, int i)`  L263 @Override
- `void onDownloadFile()`  L270
- `void onRecyclerViewItemClick(int i)`  L298
    - 体内字面量："onRecyclerViewItemClick" · "imageList = "
- `void onAction(Object obj)`  L312 @Override
- `void clearDownloadState()`  L342
- `void m503xb0250b93(View view)`  L351
- `void m504xddfda5f2(View view)`  L356
- `void m505xd5127e40(List list, DialogInterface dialogInterface, int i)`  L361
    - 体内字面量："â¦â¦"
- `void onCreate(Bundle bundle)`  L367 @Override
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L372 @Override
- `void onResume()`  L377 @Override
- `boolean onSelectAllOrNone()`  L389 @Override
- `void onViewCreated(View view, Bundle bundle)`  L394 @Override
- `boolean setDownloadState()`  L400 @Override
### `com.icatch.golive.ui.Fragment.LYRemoteFileFragment$AnonymousClass4`
L59 · [class] AnonymousClass4 · extends `Handler` · `com/icatch/golive/ui/Fragment/LYRemoteFileFragment.java`

方法（3）：
- `void handleMessage(Message message)`  L65 @Override
- `void run()`  L75 @Override
    - 体内字面量："loadMoreFile" · "loaded_data size => " · "loadMoreFile" · "list_files size => "
- `void m506x1de86d3()`  L94
### `com.icatch.golive.ui.Fragment.LYRemoteFileFragment$AnonymousClass5`
L100 · [class] AnonymousClass5 · extends `Handler` · `com/icatch/golive/ui/Fragment/LYRemoteFileFragment.java`

方法（3）：
- `void handleMessage(Message message)`  L106 @Override
- `void run()`  L120 @Override
- `void m507x1de86d4()`  L137
### `com.icatch.golive.ui.Fragment.RemoteDeviceFilesFragment`
L36 · [class] public RemoteDeviceFilesFragment · extends `BaseMultiPbFragment2 implements MultiPbFragmentView2` · implements `MultiPbFragmentView2` · `com/icatch/golive/ui/Fragment/RemoteDeviceFilesFragment.java`

字段/常量（25）：
- `String TAG = "RemoteMultiPbFragment2"`  L37
- `int fileType`  L38
- `ImageButton ib_delete`  L39
- `ImageButton ib_download`  L40
- `int lastVisibleItem`  L41
- `LinearLayout ll_file_option`  L42
- `Thread loadThread`  L43
- `RemoteDeviceFilesAdapter mAdapter`  L44
- `GridLayoutManager mLayoutManager`  L45
- `OnStatusChangedListener modeChangedListener`  L46
- `TextView noContentTxv`  L47
- `RemoteDeviceFilesFragmentPresenter presenter`  L48
- `ProgressWheel pw_load_more`  L49
- `RecyclerView rv_remote_files`  L50
- `boolean isCreated = false`  L51
- `boolean isVisible = false`  L52
- `boolean hasDeleted = false`  L53
- `boolean currentDownloadState = false`  L54
- `int i = this.mAdapter.currentClieckItem`  L58
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L131
- `RemoteDeviceFilesAdapter remoteDeviceFilesAdapter`  L148
- `Thread thread = this.loadThread`  L215
- `RemoteDeviceFilesFragment remoteDeviceFilesFragment = RemoteDeviceFilesFragment.this`  L320
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L362
- `RemoteDeviceFilesAdapter remoteDeviceFilesAdapter`  L370

方法（46）：
- `void cleanClickItemBorder()`  L57
- `void loadMoreFile()`  L66
- `void run()`  L84 @Override
- `RemoteDeviceFilesFragment newInstance(int i)`  L92
    - 体内字面量："FILE_TYPE"
- `void onFilesDelete()`  L100
- `void onComplete(boolean z, List list)`  L106 @Override
- `void onFilesDownload()`  L113
- `void changePreviewType(int i)`  L119 @Override
    - 体内字面量："start changePreviewType presenter="
- `void clearDownloadState()`  L123
- `void clickSelectState()`  L130
- `int getFileType()`  L137
- `com.tinyai.libmediacomponent.components.filelist.OperationMode getOperationMode()`  L142 @Override
- `void m509xd177843b(List list)`  L147
- `void m510xf70b8d3c()`  L162
- `void run()`  L168 @Override
- `throw new RuntimeException(e)`  L173
- `void m511xe6a34082(View view)`  L178
- `void m512xc374983(View view)`  L183
- `void m513x2d646a0f(List list)`  L188
- `void m514x52f87310(boolean z, final List list)`  L193
    - 体内字面量："FileListView.DeleteResponse" · "onComplete boolean = " · "; List<FileItemInfo> = "
- `void run()`  L200 @Override
- `void loadPhotoWall()`  L207 @Override
- `void loadThreadStop()`  L214 @Override
- `void onActivityResult(int i, int i2, Intent intent)`  L223 @Override
    - 体内字面量："onActivityResult requestCode=" · "onActivityResult data=" · "onActivityResult curfileType=" · "hasDeleted" · "onActivityResult hasDeleted=" · " fileType=" · "fileType"
- `void onConfigurationChanged(Configuration configuration)`  L235 @Override
    - 体内字面量："1122" · "RemoteMultiPbPhotoFragment onConfigurationChanged"
- `void onCreate(Bundle bundle)`  L242 @Override
    - 体内字面量："FILE_TYPE" · "onCreate fileType="
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L249 @Override
    - 体内字面量："onCreateView fileType="
- `void onClick(View view)`  L263 @Override
- `void onClick(View view)`  L271 @Override
- `void onItemClick(FileItemInfo fileItemInfo, int i)`  L283 @Override
- `void onLoadMoreFile()`  L292 @Override
- `void onManualSelectedAll(boolean z)`  L299 @Override
- `void onScrollStateChanged(RecyclerView recyclerView, int i)`  L307 @Override
    - 体内字面量："rv_remote_files.onScrollStateChanged newState = "
- `void onScrolled(RecyclerView recyclerView, int i, int i2)`  L318 @Override
- `void onDestroy()`  L328 @Override
    - 体内字面量："start onDestroy()"
- `void onResume()`  L335 @Override
    - 体内字面量："start onResume() isVisible=" · " fileType=" · "end onResume"
- `boolean onSelectAllOrNone()`  L350
- `void onStop()`  L355 @Override
    - 体内字面量："start onStop()"
- `void quitEditMode()`  L361 @Override
- `void renderList(List<FileItemInfo> list)`  L369 @Override
- `boolean setDownloadState()`  L377
- `void setFileListViewVisibility(int i)`  L396 @Override
- `void setNoContentTxvVisibility(int i)`  L400 @Override
- `void setOperationListener(OnStatusChangedListener onStatusChangedListener)`  L407 @Override
- `void setRefreshMode(int i)`  L412 @Override
- `void setUserVisibleHint(boolean z)`  L416 @Override
    - 体内字面量："setUserVisibleHint isVisibleToUser=" · " fileType=" · "setUserVisibleHint isCreated="
### `com.icatch.golive.ui.Fragment.RemoteMultiPbFragment`
L29 · [class] public RemoteMultiPbFragment · extends `BaseMultiPbFragment implements MultiPbFragmentView` · implements `MultiPbFragmentView` · `com/icatch/golive/ui/Fragment/RemoteMultiPbFragment.java`

字段/常量（12）：
- `String TAG = "RemoteMultiPbFragment"`  L30
- `FileType fileType`  L31
- `OnStatusChangedListener modeChangedListener`  L32
- `TextView noContentTxv`  L33
- `MultiPbFragmentPresenter presenter`  L34
- `RecyclerView recyclerView`  L35
- `boolean isCreated = false`  L36
- `boolean isVisible = false`  L37
- `boolean hasDeleted = false`  L38
- `MultiPbFragmentPresenter multiPbFragmentPresenter = this.presenter`  L51
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L80
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L201

方法（26）：
- `RemoteMultiPbFragment newInstance(int i)`  L40
    - 体内字面量："FILE_TYPE"
- `void changePreviewType(PhotoWallLayoutType photoWallLayoutType)`  L49 @Override
    - 体内字面量："start changePreviewType presenter="
- `void deleteFile()`  L58 @Override
- `FileType getFileType()`  L62
- `List<MultiPbItemInfo> getSelectedList()`  L67 @Override
- `void loadPhotoWall()`  L72 @Override
- `void notifyChangeMultiPbMode(OperationMode operationMode)`  L79 @Override
- `void onActivityResult(int i, int i2, Intent intent)`  L87 @Override
    - 体内字面量："onActivityResult requestCode=" · "onActivityResult data=" · "onActivityResult curfileType=" · "hasDeleted" · "onActivityResult hasDeleted=" · " fileType=" · "fileType"
- `void onConfigurationChanged(Configuration configuration)`  L99 @Override
    - 体内字面量："1122" · "RemoteMultiPbPhotoFragment onConfigurationChanged"
- `void onCreate(Bundle bundle)`  L106 @Override
    - 体内字面量："FILE_TYPE" · "onCreate fileType="
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L113 @Override
    - 体内字面量："onCreateView fileType="
- `void onItemClick(int i, View view, RecyclerView.ViewHolder viewHolder)`  L124 @Override
- `void onItemLongClick(int i, View view, RecyclerView.ViewHolder viewHolder)`  L132 @Override
- `void onLoadMore()`  L141 @Override
- `void onDestroy()`  L149 @Override
    - 体内字面量："start onDestroy()"
- `void onResume()`  L156 @Override
    - 体内字面量："start onResume() isVisible=" · " fileType=" · "end onResume"
- `void onStop()`  L172 @Override
    - 体内字面量："start onStop()"
- `void quitEditMode()`  L178 @Override
- `void selectOrCancelAll(boolean z)`  L183 @Override
- `void setNoContentTxvVisibility(int i)`  L188 @Override
- `void setOperationListener(OnStatusChangedListener onStatusChangedListener)`  L195 @Override
- `void setPhotoSelectNumText(int i)`  L200 @Override
- `void setRecyclerViewAdapter(MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter)`  L208 @Override
- `void setRecyclerViewLayoutManager(RecyclerView.LayoutManager layoutManager)`  L213 @Override
- `void setRecyclerViewVisibility(int i)`  L218 @Override
- `void setUserVisibleHint(boolean z)`  L223 @Override
    - 体内字面量："setUserVisibleHint isVisibleToUser=" · " fileType=" · "setUserVisibleHint isCreated="
### `com.icatch.golive.ui.Fragment.RemoteMultiPbFragment2`
L23 · [class] public RemoteMultiPbFragment2 · extends `BaseMultiPbFragment2 implements MultiPbFragmentView2` · implements `MultiPbFragmentView2` · `com/icatch/golive/ui/Fragment/RemoteMultiPbFragment2.java`

字段/常量（14）：
- `String TAG = "RemoteMultiPbFragment2"`  L24
- `FileListView fileListView`  L25
- `int fileType`  L26
- `OnStatusChangedListener modeChangedListener`  L27
- `TextView noContentTxv`  L28
- `MultiPbFragmentPresenter2 presenter`  L29
- `boolean isCreated = false`  L30
- `boolean isVisible = false`  L31
- `boolean hasDeleted = false`  L32
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L50
- `FileListView fileListView = this.fileListView`  L62
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L199
- `FileListView fileListView = this.fileListView`  L207
- `FileListView fileListView = this.fileListView`  L232

方法（29）：
- `RemoteMultiPbFragment2 newInstance(int i)`  L34
    - 体内字面量："FILE_TYPE"
- `void changePreviewType(int i)`  L43 @Override
    - 体内字面量："start changePreviewType presenter="
- `void clickSelectState()`  L48
- `int getFileType()`  L56
- `com.tinyai.libmediacomponent.components.filelist.OperationMode getOperationMode()`  L61 @Override
- `void loadPhotoWall()`  L67 @Override
- `void loadThreadStop()`  L74 @Override
- `void onActivityResult(int i, int i2, Intent intent)`  L78 @Override
    - 体内字面量："onActivityResult requestCode=" · "onActivityResult data=" · "onActivityResult curfileType=" · "hasDeleted" · "onActivityResult hasDeleted=" · " fileType=" · "fileType"
- `void onConfigurationChanged(Configuration configuration)`  L90 @Override
    - 体内字面量："1122" · "RemoteMultiPbPhotoFragment onConfigurationChanged"
- `void onCreate(Bundle bundle)`  L97 @Override
    - 体内字面量："FILE_TYPE" · "onCreate fileType="
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L104 @Override
    - 体内字面量："onCreateView fileType="
- `void deleteOnClick(FileItemInfo fileItemInfo, int i)`  L120 @Override
- `void downloadOnClick(FileItemInfo fileItemInfo, int i)`  L124 @Override
- `void itemOnClick(FileItemInfo fileItemInfo, int i)`  L128 @Override
- `void itemOnLongClick(FileItemInfo fileItemInfo, int i)`  L133 @Override
- `void deleteOnClick(List<FileItemInfo> list, FileListView.DeleteResponse deleteResponse)`  L144 @Override
- `void downloadOnClick(List<FileItemInfo> list)`  L149 @Override
- `List<FileItemInfo> getModeData()`  L156 @Override
- `List<FileItemInfo> refreshData()`  L161 @Override
- `void onDestroy()`  L169 @Override
    - 体内字面量："start onDestroy()"
- `void onResume()`  L176 @Override
    - 体内字面量："start onResume() isVisible=" · " fileType=" · "end onResume"
- `void onStop()`  L191 @Override
    - 体内字面量："start onStop()"
- `void quitEditMode()`  L197 @Override
- `void renderList(List<FileItemInfo> list)`  L206 @Override
- `void setFileListViewVisibility(int i)`  L214 @Override
- `void setNoContentTxvVisibility(int i)`  L219 @Override
- `void setOperationListener(OnStatusChangedListener onStatusChangedListener)`  L226 @Override
- `void setRefreshMode(int i)`  L231 @Override
- `void setUserVisibleHint(boolean z)`  L239 @Override
    - 体内字面量："setUserVisibleHint isVisibleToUser=" · " fileType=" · "setUserVisibleHint isCreated="
### `com.icatch.golive.ui.Fragment.RemoteMultiPbPhotoFragment`
L32 · [class] public RemoteMultiPbPhotoFragment · extends `BaseMultiPbFragment implements MultiPbPhotoFragmentView` · implements `MultiPbPhotoFragmentView` · `com/icatch/golive/ui/Fragment/RemoteMultiPbPhotoFragment.java`

字段/常量（14）：
- `String TAG = "RemoteMultiPbPhotoFragment"`  L33
- `FileType fileType`  L34
- `TextView headerView`  L35
- `boolean isCreated = false`  L36
- `boolean isVisible = false`  L37
- `ListView listView`  L38
- `OnStatusChangedListener modeChangedListener`  L39
- `StickyGridHeadersGridView multiPbPhotoGridView`  L40
- `FrameLayout multiPbPhotoListLayout`  L41
- `TextView noContentTxv`  L42
- `MultiPbPhotoFragmentPresenter presenter`  L43
- `MultiPbPhotoFragmentPresenter multiPbPhotoFragmentPresenter = this.presenter`  L55
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L90
- `OnStatusChangedListener onStatusChangedListener = this.modeChangedListener`  L249

方法（33）：
- `RemoteMultiPbPhotoFragment newInstance(int i)`  L45
    - 体内字面量："FILE_TYPE"
- `void changePreviewType(PhotoWallLayoutType photoWallLayoutType)`  L54 @Override
- `void deleteFile()`  L62 @Override
- `List<MultiPbItemInfo> getSelectedList()`  L67 @Override
- `View gridViewFindViewWithTag(int i)`  L72 @Override
- `View listViewFindViewWithTag(int i)`  L77 @Override
- `void loadPhotoWall()`  L82 @Override
- `void notifyChangeMultiPbMode(OperationMode operationMode)`  L89 @Override
- `void onConfigurationChanged(Configuration configuration)`  L97 @Override
    - 体内字面量："1122" · "RemoteMultiPbPhotoFragment onConfigurationChanged"
- `void onCreate(Bundle bundle)`  L104 @Override
    - 体内字面量："FILE_TYPE" · "onCreate fileType="
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L111 @Override
    - 体内字面量："RemoteMultiPbPhotoFragment onCreateView"
- `boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j)`  L124 @Override
- `boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j)`  L134 @Override
- `void onItemClick(AdapterView<?> adapterView, View view, int i, long j)`  L141 @Override
    - 体内字面量："1111" · "listView.setOnItemClickListener"
- `void onItemClick(AdapterView<?> adapterView, View view, int i, long j)`  L151 @Override
    - 体内字面量："1111" · "multiPbPhotoGridView.setOnItemClickListener"
- `void onDestroy()`  L164 @Override
    - 体内字面量："start onDestroy()"
- `void onResume()`  L171 @Override
    - 体内字面量："start onResume() isVisible=" · " presenter=" · "end onResume"
- `void onStop()`  L181 @Override
    - 体内字面量："start onStop()"
- `void quitEditMode()`  L187 @Override
- `void refreshPhotoWall()`  L191
- `void selectOrCancelAll(boolean z)`  L196 @Override
- `void setGridViewAdapter(MultiPbPhotoWallGridAdapter multiPbPhotoWallGridAdapter)`  L201 @Override
- `void setGridViewSelection(int i)`  L206 @Override
- `void setGridViewVisibility(int i)`  L211 @Override
- `void setListViewAdapter(MultiPbPhotoWallListAdapter multiPbPhotoWallListAdapter)`  L216 @Override
- `void setListViewHeaderText(String str)`  L221 @Override
- `void setListViewSelection(int i)`  L226 @Override
- `void setListViewVisibility(int i)`  L231 @Override
- `void setNoContentTxvVisibility(int i)`  L236 @Override
- `void setOperationListener(OnStatusChangedListener onStatusChangedListener)`  L243 @Override
- `void setPhotoSelectNumText(int i)`  L248 @Override
- `void setUserVisibleHint(boolean z)`  L256 @Override
    - 体内字面量："setUserVisibleHint isVisibleToUser=" · "setUserVisibleHint isCreated="
- `void updateGridViewBitmaps(String str, Bitmap bitmap)`  L271 @Override
### `com.icatch.golive.ui.Interface.BTPairBeginFragmentView`
L6 · [interface] public BTPairBeginFragmentView · `com/icatch/golive/ui/Interface/BTPairBeginFragmentView.java`

方法（2）：
- `void setBTListViewAdapter(BaseAdapter baseAdapter)`  L7
- `void setListHeader(int i)`  L9
### `com.icatch.golive.ui.Interface.LaunchView`
L7 · [interface] public LaunchView · `com/icatch/golive/ui/Interface/LaunchView.java`

方法（17）：
- `void fragmentPopStackOfAll()`  L8
- `void loadDefaultLocalPhotoThumbnail()`  L10
- `void loadDefaultLocalVideoThumbnail()`  L12
- `void setBackBtnVisibility(boolean z)`  L14
- `void setLaunchLayoutVisibility(int i)`  L16
- `void setLaunchSettingFrameVisibility(int i)`  L18
- `void setListviewAdapter(CameraSlotAdapter cameraSlotAdapter)`  L20
- `void setLocalPhotoThumbnail(Bitmap bitmap)`  L22
- `void setLocalPhotoThumbnail(String str)`  L24
- `void setLocalVideoThumbnail(Bitmap bitmap)`  L26
- `void setLocalVideoThumbnail(String str)`  L28
- `void setNavigationTitle(int i)`  L30
- `void setNavigationTitle(String str)`  L32
- `void setNoPhotoFilesFoundVisibility(int i)`  L34
- `void setNoVideoFilesFoundVisibility(int i)`  L36
- `void setPhotoClickable(boolean z)`  L38
- `void setVideoClickable(boolean z)`  L40
### `com.icatch.golive.ui.Interface.LocalMultiPbFragmentView`
L8 · [interface] public LocalMultiPbFragmentView · `com/icatch/golive/ui/Interface/LocalMultiPbFragmentView.java`

方法（5）：
- `OperationMode getOperationMode()`  L9
- `void quitEditMode()`  L11
- `void renderList(List<FileItemInfo> list)`  L13
- `void setFileListViewVisibility(int i)`  L15
- `void setNoContentTxvVisibility(int i)`  L17
### `com.icatch.golive.ui.Interface.LocalMultiPbView`
L6 · [interface] public LocalMultiPbView · `com/icatch/golive/ui/Interface/LocalMultiPbView.java`

方法（5）：
- `void setMenuPhotoWallTypeIcon(int i)`  L7
- `void setTabLayoutClickable(boolean z)`  L9
- `void setViewPageAdapter(FragmentPagerAdapter fragmentPagerAdapter)`  L11
- `void setViewPageCurrentItem(int i)`  L13
- `void setViewPagerScanScroll(boolean z)`  L15
### `com.icatch.golive.ui.Interface.LocalPhotoPbView`
L7 · [interface] public LocalPhotoPbView · `com/icatch/golive/ui/Interface/LocalPhotoPbView.java`

方法（12）：
- `int getTopBarVisibility()`  L8
- `int getViewPagerCurrentItem()`  L10
- `void setBottomBarVisibility(int i)`  L12
- `void setIndexInfoTxv(String str)`  L14
- `void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener)`  L16
- `void setPanoramaTypeBtnImg(int i)`  L18
- `void setPanoramaTypeBtnVisibility(int i)`  L20
- `void setSurfaceviewVisibility(int i)`  L22
- `void setTopBarVisibility(int i)`  L24
- `void setViewPagerAdapter(PagerAdapter pagerAdapter)`  L26
- `void setViewPagerCurrentItem(int i)`  L28
- `void setViewPagerVisibility(int i)`  L30
### `com.icatch.golive.ui.Interface.LocalVideoPbView`
L4 · [interface] public LocalVideoPbView · `com/icatch/golive/ui/Interface/LocalVideoPbView.java`

方法（24）：
- `int getSeekBarProgress()`  L5
- `int getSurfaceViewHeight()`  L7
- `int getSurfaceViewWidth()`  L9
- `void setBottomBarVisibility(int i)`  L11
- `void setCodecInfoTxv(String str)`  L13
- `void setEisSwitchChecked(boolean z)`  L15
- `void setLoadPercent(int i)`  L17
- `void setMoreSettingLayoutVisibility(int i)`  L19
- `void setPanoramaTypeBtnVisibility(int i)`  L21
- `void setPanoramaTypeImageResource(int i)`  L23
- `void setPlayBtnSrc(int i)`  L25
- `void setProgress(float f)`  L27
- `void setSeekBarMaxValue(int i)`  L29
- `void setSeekBarProgress(int i)`  L31
- `void setSeekBarSecondProgress(int i)`  L33
- `void setTimeDurationValue(String str)`  L35
- `void setTimeLapsedValue(String str)`  L37
- `void setTopBarVisibility(int i)`  L39
- `void setVideoNameTxv(String str)`  L41
- `void setZoomMaxValue(float f)`  L43
- `void setZoomMinValue(float f)`  L45
- `void showLoadingCircle(boolean z)`  L47
- `void showZoomView(int i)`  L49
- `void updateZoomRateTV(float f)`  L51
### `com.icatch.golive.ui.Interface.MultiPbFragmentView`
L8 · [interface] public MultiPbFragmentView · `com/icatch/golive/ui/Interface/MultiPbFragmentView.java`

方法（6）：
- `void notifyChangeMultiPbMode(OperationMode operationMode)`  L9
- `void setNoContentTxvVisibility(int i)`  L11
- `void setPhotoSelectNumText(int i)`  L13
- `void setRecyclerViewAdapter(MultiPbRecyclerViewAdapter multiPbRecyclerViewAdapter)`  L15
- `void setRecyclerViewLayoutManager(RecyclerView.LayoutManager layoutManager)`  L17
- `void setRecyclerViewVisibility(int i)`  L19
### `com.icatch.golive.ui.Interface.MultiPbFragmentView2`
L8 · [interface] public MultiPbFragmentView2 · `com/icatch/golive/ui/Interface/MultiPbFragmentView2.java`

方法（6）：
- `OperationMode getOperationMode()`  L9
- `void quitEditMode()`  L11
- `void renderList(List<FileItemInfo> list)`  L13
- `void setFileListViewVisibility(int i)`  L15
- `void setNoContentTxvVisibility(int i)`  L17
- `void setRefreshMode(int i)`  L19
### `com.icatch.golive.ui.Interface.MultiPbPhotoFragmentView`
L10 · [interface] public MultiPbPhotoFragmentView · `com/icatch/golive/ui/Interface/MultiPbPhotoFragmentView.java`

方法（13）：
- `View gridViewFindViewWithTag(int i)`  L11
- `View listViewFindViewWithTag(int i)`  L13
- `void notifyChangeMultiPbMode(OperationMode operationMode)`  L15
- `void setGridViewAdapter(MultiPbPhotoWallGridAdapter multiPbPhotoWallGridAdapter)`  L17
- `void setGridViewSelection(int i)`  L19
- `void setGridViewVisibility(int i)`  L21
- `void setListViewAdapter(MultiPbPhotoWallListAdapter multiPbPhotoWallListAdapter)`  L23
- `void setListViewHeaderText(String str)`  L25
- `void setListViewSelection(int i)`  L27
- `void setListViewVisibility(int i)`  L29
- `void setNoContentTxvVisibility(int i)`  L31
- `void setPhotoSelectNumText(int i)`  L33
- `void updateGridViewBitmaps(String str, Bitmap bitmap)`  L35
### `com.icatch.golive.ui.Interface.MultiPbVideoFragmentView`
L9 · [interface] public MultiPbVideoFragmentView · `com/icatch/golive/ui/Interface/MultiPbVideoFragmentView.java`

方法（12）：
- `void changeMultiPbMode(OperationMode operationMode)`  L10
- `View gridViewFindViewWithTag(int i)`  L12
- `View listViewFindViewWithTag(int i)`  L14
- `void setGridViewAdapter(MultiPbPhotoWallGridAdapter multiPbPhotoWallGridAdapter)`  L16
- `void setGridViewSelection(int i)`  L18
- `void setGridViewVisibility(int i)`  L20
- `void setListViewAdapter(MultiPbPhotoWallListAdapter multiPbPhotoWallListAdapter)`  L22
- `void setListViewHeaderText(String str)`  L24
- `void setListViewSelection(int i)`  L26
- `void setListViewVisibility(int i)`  L28
- `void setNoContentTxvVisibility(int i)`  L30
- `void setVideoSelectNumText(int i)`  L32
### `com.icatch.golive.ui.Interface.MultiPbView`
L6 · [interface] public MultiPbView · `com/icatch/golive/ui/Interface/MultiPbView.java`

方法（12）：
- `int getViewPageIndex()`  L7
- `void setEditLayoutVisibiliy(int i)`  L9
- `void setFilterItemVisibiliy(boolean z)`  L11
- `void setMenuPhotoWallTypeIcon(int i)`  L13
- `void setSelectBtnIcon(int i)`  L15
- `void setSelectBtnVisibility(int i)`  L17
- `void setSelectNumText(String str)`  L19
- `void setSelectNumTextVisibility(int i)`  L21
- `void setTabLayoutClickable(boolean z)`  L23
- `void setViewPageAdapter(FragmentPagerAdapter fragmentPagerAdapter)`  L25
- `void setViewPageCurrentItem(int i)`  L27
- `void setViewPagerScanScroll(boolean z)`  L29
### `com.icatch.golive.ui.Interface.MultiPbView2`
L6 · [interface] public MultiPbView2 · `com/icatch/golive/ui/Interface/MultiPbView2.java`

方法（7）：
- `int getViewPageIndex()`  L7
- `void setFilterItemVisibiliy(boolean z)`  L9
- `void setMenuPhotoWallTypeIcon(int i)`  L11
- `void setTabLayoutClickable(boolean z)`  L13
- `void setViewPageAdapter(FragmentPagerAdapter fragmentPagerAdapter)`  L15
- `void setViewPageCurrentItem(int i)`  L17
- `void setViewPagerScanScroll(boolean z)`  L19
### `com.icatch.golive.ui.Interface.PhotoPbView`
L7 · [interface] public PhotoPbView · `com/icatch/golive/ui/Interface/PhotoPbView.java`

方法（13）：
- `int getTopBarVisibility()`  L8
- `int getViewPagerCurrentItem()`  L10
- `void setBottomBarVisibility(int i)`  L12
- `void setIndexInfoTxv(String str)`  L14
- `void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener)`  L16
- `void setPanoramaTypeBtnImg(int i)`  L18
- `void setPanoramaTypeBtnVisibility(int i)`  L20
- `void setShareBtnVisibility(int i)`  L22
- `void setSurfaceviewVisibility(int i)`  L24
- `void setTopBarVisibility(int i)`  L26
- `void setViewPagerAdapter(PagerAdapter pagerAdapter)`  L28
- `void setViewPagerCurrentItem(int i)`  L30
- `void setViewPagerVisibility(int i)`  L32
### `com.icatch.golive.ui.Interface.PreviewView`
L11 · [interface] public PreviewView · `com/icatch/golive/ui/Interface/PreviewView.java`

方法（70）：
- `void dismissPopupWindow()`  L12
- `int getSetupMainMenuVisibility()`  L14
- `int getSurfaceViewHeight()`  L16
- `int getSurfaceViewWidth()`  L18
- `float getZoomViewMaxZoomRate()`  L20
- `float getZoomViewProgress()`  L22
- `void hideZoomView()`  L24
- `void initPreviewPlayerView(MediaStreamPlayer mediaStreamPlayer, boolean z)`  L26
- `void loadSetting(List<SettingGroup> list)`  L28
- `void refeshDateStampState(boolean z)`  L30
- `void refeshSetting()`  L32
- `void setActionBarTitle(int i)`  L34
- `void setAutoDownloadBitmap(Bitmap bitmap)`  L36
- `void setAutoDownloadVisibility(int i)`  L38
- `void setBackBtnVisibility(boolean z)`  L40
- `void setBatteryIcon(int i, int i2)`  L42
- `void setBatteryStatusVisibility(int i)`  L44
- `void setBurstStatusIcon(int i)`  L46
- `void setBurstStatusVisibility(int i)`  L48
- `void setCaptureBtnBackgroundResource(int i)`  L50
- `void setCaptureBtnEnability(boolean z)`  L52
- `void setCaptureRadioBtnChecked(boolean z)`  L54
- `void setCaptureRadioBtnVisibility(int i)`  L56
- `void setCarModeVisibility(int i)`  L58
- `void setCustomerLiveBtnTxv(String str)`  L60
- `void setDelayCaptureLayoutVisibility(int i)`  L62
- `void setDelayCaptureTextTime(String str)`  L64
- `void setDeviceName(String str, String str2)`  L66
- `void setFacebookBtnTxv(int i)`  L68
- `void setFacebookBtnTxv(String str)`  L70
- `void setImageSizeInfo(String str)`  L72
- `void setImageSizeLayoutVisibility(int i)`  L74
- `void setMaxZoomRate(float f)`  L76
- `void setMinZoomRate(float f)`  L78
- `void setPanoramaTypeBtnSrc(int i)`  L80
- `void setPanoramaTypeBtnVisibility(int i)`  L82
- `void setPvModeBtnBackgroundResource(int i)`  L84
- `void setRecordingTime(String str)`  L86
- `void setRecordingTimeVisibility(int i)`  L88
- `void setRemainCaptureCount(String str)`  L90
- `void setRemainRecordingTimeText(String str)`  L92
- `void setSettingBtnVisible(boolean z)`  L94
- `void setSettingItemClickListener(CommonItemView.OnItemClickListener onItemClickListener)`  L96
- `void setSettingMenuListAdapter(SettingListAdapter settingListAdapter)`  L98
- `void setSettingSwitchChangedListener(CommonItemView.OnSwitchChangedListener onSwitchChangedListener)`  L100
- `void setSetupMainMenuVisibility(int i)`  L102
- `void setSlowMotionVisibility(int i)`  L104
- `void setSupportPreviewTxvVisibility(int i)`  L106
- `void setSwitchRecordState(int i)`  L108
- `void setTimepLapseRadioBtnVisibility(int i)`  L110
- `void setTimepLapseRadioChecked(boolean z)`  L112
- `void setUpsideVisibility(int i)`  L114
- `void setVideoRadioBtnChecked(boolean z)`  L116
- `void setVideoRadioBtnVisibility(int i)`  L118
- `void setVideoSizeInfo(String str)`  L120
- `void setVideoSizeLayoutVisibility(int i)`  L122
- `void setWbStatusIcon(int i)`  L124
- `void setWbStatusVisibility(int i)`  L126
- `void setWifiIcon(int i)`  L128
- `void setWifiStatusVisibility(int i)`  L130
- `void setYouTubeBtnTxv(int i)`  L132
- `void setYouTubeBtnTxv(String str)`  L134
- `void setYouTubeLiveLayoutVisibility(int i)`  L136
- `void settimeLapseModeIcon(int i)`  L138
- `void settimeLapseModeVisibility(int i)`  L140
- `void showPopupWindow(int i)`  L142
- `void showZoomView()`  L144
- `void startPreview()`  L146
- `void stopPreview()`  L148
- `void updateZoomViewProgress(float f)`  L150
### `com.icatch.golive.ui.Interface.USBPreviewView`
L7 · [interface] public USBPreviewView · `com/icatch/golive/ui/Interface/USBPreviewView.java`

方法（53）：
- `void dismissPopupWindow()`  L8
- `int getSetupMainMenuVisibility()`  L10
- `int getSurfaceViewHeight()`  L12
- `int getSurfaceViewWidth()`  L14
- `void setActionBarTitle(int i)`  L16
- `void setAudioSwitcherChecked(boolean z)`  L18
- `void setAudioSwitcherVisibility(int i)`  L20
- `void setAutoDownloadBitmap(Bitmap bitmap)`  L22
- `void setAutoDownloadVisibility(int i)`  L24
- `void setBackBtnVisibility(boolean z)`  L26
- `void setBatteryIcon(int i)`  L28
- `void setBatteryStatusVisibility(int i)`  L30
- `void setBurstStatusIcon(int i)`  L32
- `void setBurstStatusVisibility(int i)`  L34
- `void setCaptureBtnBackgroundResource(int i)`  L36
- `void setCaptureBtnEnability(boolean z)`  L38
- `void setCaptureRadioBtnChecked(boolean z)`  L40
- `void setCaptureRadioBtnVisibility(int i)`  L42
- `void setCarModeVisibility(int i)`  L44
- `void setDelayCaptureLayoutVisibility(int i)`  L46
- `void setDelayCaptureTextTime(String str)`  L48
- `void setFacebookBtnTxv(int i)`  L50
- `void setFacebookBtnTxv(String str)`  L52
- `void setImageSizeInfo(String str)`  L54
- `void setImageSizeLayoutVisibility(int i)`  L56
- `void setImageSizeSettingText(String str)`  L58
- `void setLiveLayoutVisibility(int i)`  L60
- `void setPvModeBtnBackgroundResource(int i)`  L62
- `void setRecordingTime(String str)`  L64
- `void setRecordingTimeVisibility(int i)`  L66
- `void setRemainCaptureCount(String str)`  L68
- `void setRemainRecordingTimeText(String str)`  L70
- `void setSettingBtnVisible(boolean z)`  L72
- `void setSettingMenuListAdapter(SettingListAdapter settingListAdapter)`  L74
- `void setSetupMainMenuVisibility(int i)`  L76
- `void setSlowMotionVisibility(int i)`  L78
- `void setSupportPreviewTxvVisibility(int i)`  L80
- `void setTimepLapseRadioBtnVisibility(int i)`  L82
- `void setTimepLapseRadioChecked(boolean z)`  L84
- `void setUpsideVisibility(int i)`  L86
- `void setVideoRadioBtnChecked(boolean z)`  L88
- `void setVideoRadioBtnVisibility(int i)`  L90
- `void setVideoSizeInfo(String str)`  L92
- `void setVideoSizeLayoutVisibility(int i)`  L94
- `void setWbStatusIcon(int i)`  L96
- `void setWbStatusVisibility(int i)`  L98
- `void setWifiIcon(int i)`  L100
- `void setWifiStatusVisibility(int i)`  L102
- `void setYouTubeBtnTxv(int i)`  L104
- `void setYouTubeBtnTxv(String str)`  L106
- `void settimeLapseModeIcon(int i)`  L108
- `void settimeLapseModeVisibility(int i)`  L110
- `void showPopupWindow(int i)`  L112
### `com.icatch.golive.ui.Interface.VideoPbView`
L6 · [interface] public VideoPbView · `com/icatch/golive/ui/Interface/VideoPbView.java`

方法（9）：
- `void initPreviewPlayerView(MediaStreamPlayer mediaStreamPlayer, boolean z)`  L7
- `void setBarVisibility(int i)`  L9
- `void setEisSwitchChecked(boolean z)`  L11
- `void setMoreSettingLayoutVisibility(int i)`  L13
- `void setPanoramaTypeBtnVisibility(int i)`  L15
- `void setPanoramaTypeImageResource(int i)`  L17
- `void setVideoNameTxv(String str)`  L19
- `void startPreview()`  L21
- `void stopPreview()`  L23
### `com.icatch.golive.ui.RemoteFileHelper`
L21 · [class] public RemoteFileHelper · `com/icatch/golive/ui/RemoteFileHelper.java`

字段/常量（20）：
- `RemoteFileHelper instance`  L22
- `String TAG = "RemoteFileHelper"`  L23
- `int curFilterFileType = 255`  L25
- `FileFilter fileFilter = null`  L26
- `int MAX_NUM = 30`  L27
- `boolean supportSegmentedLoading = false`  L28
- `boolean supportSetFileListAttribute = false`  L29
- `int sensorsNum = 1`  L30
- `int i3 = fileCount < i2 ? fileCount : i2`  L93
- `int i4 = 1`  L94
- `boolean z = false`  L144
- `int i3 = i2 + 29`  L152
- `FileFilter fileFilter = this.fileFilter`  L158
- `int i4 = i3 + 1`  L161
- `int i5 = i3 + 1`  L175
- `int i6 = i5 + 29`  L177
- `int i = 1`  L201
- `FileFilter fileFilter = this.fileFilter`  L246
- `int i = 18`  L266
- `FileFilter fileFilter = this.fileFilter`  L274

方法（20）：
- `RemoteFileHelper getInstance()`  L32
- `List<MultiPbItemInfo> getList(List<ICatchFile> list, FileFilter fileFilter)`  L39
- `void clearAllFileList()`  L60
- `void clearFileList(FileType fileType)`  L64
- `int getFileCount(FileOperation fileOperation, FileType fileType)`  L70
    - 体内字面量："fileCount:"
- `FileFilter getFileFilter()`  L77
- `List<MultiPbItemInfo> getFileList(FileOperation fileOperation, int i, int i2)`  L81
    - 体内字面量："begin getFileList type: " · " maxNumï¼" · "cameraPlayback is null"
- `List<MultiPbItemInfo> getLocalFileList(FileType fileType)`  L138
- `MultiPbFileResult getRemoteFile(FileOperation fileOperation, FileType fileType, int i, int i2)`  L142
    - 体内字面量："getRemoteFile fileType:" · " fileTotalNum:" · " startIndex:" · " maxNum:30"
- `List<MultiPbItemInfo> getRemoteFile(FileOperation fileOperation, FileType fileType)`  L200
- `int getSensorsNum()`  L214
- `void initSupportCapabilities()`  L218
- `boolean isSupportSegmentedLoading()`  L233
- `boolean isSupportSetFileListAttribute()`  L237
- `boolean needFilter()`  L241
- `boolean needFilterMoreFile(ICatchFile iCatchFile)`  L245
- `void remove(MultiPbItemInfo multiPbItemInfo, FileType fileType)`  L253
- `void setFileFilter(FileFilter fileFilter)`  L260
- `void setFileListAttribute(FileOperation fileOperation, FileType fileType)`  L264
- `void setLocalFileList(List<MultiPbItemInfo> list, FileType fileType)`  L283
### `com.icatch.golive.ui.RemoteFileHelper2`
L20 · [class] public RemoteFileHelper2 · `com/icatch/golive/ui/RemoteFileHelper2.java`

字段/常量（20）：
- `RemoteFileHelper2 instance`  L21
- `String TAG = "RemoteFileHelper2"`  L22
- `int curFilterFileType = 255`  L24
- `FileFilter fileFilter = null`  L25
- `int MAX_NUM = 30`  L26
- `boolean supportSegmentedLoading = false`  L27
- `boolean supportSetFileListAttribute = false`  L28
- `int sensorsNum = 1`  L29
- `int i3 = fileCount < i2 ? fileCount : i2`  L92
- `int i4 = 1`  L93
- `boolean z = false`  L143
- `int i4 = i3 + 29`  L151
- `FileFilter fileFilter = this.fileFilter`  L157
- `int i5 = i4 + 1`  L160
- `int i6 = i4 + 1`  L174
- `int i7 = i6 + 29`  L176
- `int i2 = 1`  L200
- `FileFilter fileFilter = this.fileFilter`  L242
- `int i2 = 18`  L262
- `FileFilter fileFilter = this.fileFilter`  L270

方法（20）：
- `RemoteFileHelper2 getInstance()`  L31
- `List<MultiPbItemInfo> getList(List<ICatchFile> list, FileFilter fileFilter)`  L38
- `void clearAllFileList()`  L59
- `void clearFileList(int i)`  L63
- `int getFileCount(FileOperation fileOperation, int i)`  L69
    - 体内字面量："fileCount:"
- `FileFilter getFileFilter()`  L76
- `List<MultiPbItemInfo> getFileList(FileOperation fileOperation, int i, int i2)`  L80
    - 体内字面量："begin getFileList type: " · " maxNumï¼" · "cameraPlayback is null"
- `List<MultiPbItemInfo> getLocalFileList(int i)`  L137
- `MultiPbFileResult getRemoteFile(FileOperation fileOperation, int i, int i2, int i3)`  L141
    - 体内字面量："getRemoteFile fileType:" · " fileTotalNum:" · " startIndex:" · " maxNum:30"
- `List<MultiPbItemInfo> getRemoteFile(FileOperation fileOperation, int i)`  L199
- `int getSensorsNum()`  L213
- `void initSupportCapabilities()`  L217
- `boolean isSupportSegmentedLoading()`  L229
- `boolean isSupportSetFileListAttribute()`  L233
- `boolean needFilter()`  L237
- `boolean needFilterMoreFile(ICatchFile iCatchFile)`  L241
- `void remove(MultiPbItemInfo multiPbItemInfo, int i)`  L249
- `void setFileFilter(FileFilter fileFilter)`  L256
- `void setFileListAttribute(FileOperation fileOperation, int i)`  L260
- `void setLocalFileList(List<MultiPbItemInfo> list, int i)`  L279