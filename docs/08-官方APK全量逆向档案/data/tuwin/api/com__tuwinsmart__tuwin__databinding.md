# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.databinding

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 100 个文件 / 100 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.databinding.ActivityAboutBinding`
L14 · [class] public final ActivityAboutBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityAboutBinding.java`

字段/常量（7）：
- `ImageView logo`  L15
- `ConstraintLayout rootView`  L16
- `TextView tvBeian`  L17
- `TextView tvBuildNumber`  L18
- `TextView tvCopyright`  L19
- `TextView tvVersionName`  L20
- `int i = C1870R.id.logo`  L49

方法（5）：
- `private ActivityAboutBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4)`  L22
- `ConstraintLayout getRoot()`  L32 @Override
- `ActivityAboutBinding inflate(LayoutInflater layoutInflater)`  L36
- `ActivityAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L40
- `ActivityAboutBinding bind(View view)`  L48
### `com.tuwinsmart.tuwin.databinding.ActivityActionbarBinding`
L14 · [class] public final ActivityActionbarBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityActionbarBinding.java`

字段/常量（5）：
- `ToolBar actionbar`  L15
- `FrameLayout flContent`  L16
- `LinearLayout mainLayoutLl`  L17
- `LinearLayout rootView`  L18
- `int i = C1870R.id.actionbar`  L45

方法（5）：
- `private ActivityActionbarBinding(LinearLayout linearLayout, ToolBar toolBar, FrameLayout frameLayout, LinearLayout linearLayout2)`  L20
- `LinearLayout getRoot()`  L28 @Override
- `ActivityActionbarBinding inflate(LayoutInflater layoutInflater)`  L32
- `ActivityActionbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L36
- `ActivityActionbarBinding bind(View view)`  L44
### `com.tuwinsmart.tuwin.databinding.ActivityConnectHelperBinding`
L15 · [class] public final ActivityConnectHelperBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityConnectHelperBinding.java`

字段/常量（7）：
- `BLTextView btnAction`  L16
- `ImageView ivGif`  L17
- `LinearLayout rootView`  L18
- `TextView tvDefaultWifiName`  L19
- `TextView tvDefaultWifiPassword`  L20
- `TextView tvMsg`  L21
- `int i = C1870R.id.btn_action`  L50

方法（5）：
- `private ActivityConnectHelperBinding(LinearLayout linearLayout, BLTextView bLTextView, ImageView imageView, TextView textView, TextView textView2, TextView textView3)`  L23
- `LinearLayout getRoot()`  L33 @Override
- `ActivityConnectHelperBinding inflate(LayoutInflater layoutInflater)`  L37
- `ActivityConnectHelperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L41
- `ActivityConnectHelperBinding bind(View view)`  L49
### `com.tuwinsmart.tuwin.databinding.ActivityDailyDetailBinding`
L17 · [class] public final ActivityDailyDetailBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityDailyDetailBinding.java`

字段/常量（9）：
- `LinearLayout btnDelete`  L18
- `LinearLayout btnDownload`  L19
- `LinearLayout llBottomActions`  L20
- `RecyclerView recyclerView`  L21
- `ConstraintLayout rootView`  L22
- `ToolBar toolBar`  L23
- `BLTextView tvDownloadState`  L24
- `PlayListControlVideo videoView`  L25
- `int i = C1870R.id.btn_delete`  L56

方法（5）：
- `private ActivityDailyDetailBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, ToolBar toolBar, BLTextView bLTextView, PlayListControlVideo playListControlVideo)`  L27
- `ConstraintLayout getRoot()`  L39 @Override
- `ActivityDailyDetailBinding inflate(LayoutInflater layoutInflater)`  L43
- `ActivityDailyDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L47
- `ActivityDailyDetailBinding bind(View view)`  L55
### `com.tuwinsmart.tuwin.databinding.ActivityDeviceDetailBinding`
L23 · [class] public final ActivityDeviceDetailBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityDeviceDetailBinding.java`

字段/常量（39）：
- `BatteryView batteryView`  L24
- `ImageView btnFullscreen`  L25
- `BLTextView btnLowQuality`  L26
- `ConstraintLayout btnReview`  L27
- `ImageView btnScreenshot`  L28
- `ImageView btnSteamType`  L29
- `ConstraintLayout btnTip`  L30
- `ConstraintLayout clCameraAbnormal`  L31
- `ConstraintLayout clRecordingWriteError`  L32
- `ConstraintLayout clSdAbnormal`  L33
- `ConstraintLayout clStorage`  L34
- `RelativeLayout frame88`  L35
- `BLImageView ivRecordingWriteErrorIcon`  L36
- `BLImageView ivReviewIcon`  L37
- `BLImageView ivSdAbnormalIcon`  L38
- `BLImageView ivStorageIcon`  L39
- `BLImageView ivTipsIcon`  L40
- `BLLinearLayout llActionButtons`  L41
- `ProgressBar pbVideoLoading`  L42
- `ImageView playerDefaultBackground`  L43
- `ConstraintLayout rootView`  L44
- `NestedScrollView svDeviceActions`  L45
- `ToolBar toolBar`  L46
- `TextView tvCameraAbnormalDescription`  L47
- `TextView tvCameraAbnormalTitle`  L48
- `TextView tvDeviceVersionInfo`  L49
- `TextView tvPreviewWatermark`  L50
- `TextView tvRecordingWriteErrorDescription`  L51
- `TextView tvRecordingWriteErrorTitle`  L52
- `TextView tvReviewDescription`  L53
- `TextView tvReviewTitle`  L54
- `TextView tvSdAbnormalDescription`  L55
- `TextView tvSdAbnormalTitle`  L56
- `TextView tvStorageDescription`  L57
- `TextView tvStorageTitle`  L58
- `TextView tvTipsDescription`  L59
- `TextView tvTipsTitle`  L60
- `FFmpegPlayerView videoView`  L61
- `int i = C1870R.id.battery_view`  L122

方法（5）：
- `private ActivityDeviceDetailBinding(ConstraintLayout constraintLayout, BatteryView batteryView, ImageView imageView, BLTextView bLTextView, ConstraintLayout constraintLayout2, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, RelativeLayout relativeLayout, BLImageView bLImageView, BLImageView bLImageView2, BLImageView bLImageView3, BLImageView bLImageView4, BLImageView bLImageView5, BLLinearLayout bLLinearLayout, ProgressBar progressBar, ImageView imageView4, NestedScrollView nestedScrollView, ToolBar toolBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, FFmpegPlayerView fFmpegPlayerView)`  L63
- `ConstraintLayout getRoot()`  L105 @Override
- `ActivityDeviceDetailBinding inflate(LayoutInflater layoutInflater)`  L109
- `ActivityDeviceDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L113
- `ActivityDeviceDetailBinding bind(View view)`  L121
### `com.tuwinsmart.tuwin.databinding.ActivityDeviceListBinding`
L13 · [class] public final ActivityDeviceListBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityDeviceListBinding.java`

字段/常量（3）：
- `LinearLayout rootView`  L14
- `RecyclerView rvDeviceList`  L15
- `int i = C1870R.id.rv_device_list`  L40

方法（5）：
- `private ActivityDeviceListBinding(LinearLayout linearLayout, RecyclerView recyclerView)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `ActivityDeviceListBinding inflate(LayoutInflater layoutInflater)`  L27
- `ActivityDeviceListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L31
- `ActivityDeviceListBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.ActivityDownloadListBinding`
L15 · [class] public final ActivityDownloadListBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityDownloadListBinding.java`

字段/常量（5）：
- `RecyclerView recyclerView`  L16
- `SwipeRefreshLayout refreshLayout`  L17
- `FrameLayout rootView`  L18
- `TextView tvState`  L19
- `int i = C1870R.id.recycler_view`  L46

方法（5）：
- `private ActivityDownloadListBinding(FrameLayout frameLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TextView textView)`  L21
- `FrameLayout getRoot()`  L29 @Override
- `ActivityDownloadListBinding inflate(LayoutInflater layoutInflater)`  L33
- `ActivityDownloadListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L37
- `ActivityDownloadListBinding bind(View view)`  L45
### `com.tuwinsmart.tuwin.databinding.ActivityExternalWebBinding`
L14 · [class] public final ActivityExternalWebBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityExternalWebBinding.java`

字段/常量（4）：
- `LinearLayout rootView`  L15
- `ToolBar toolbar`  L16
- `FrameLayout webviewContainer`  L17
- `int i = C1870R.id.toolbar`  L43

方法（5）：
- `private ActivityExternalWebBinding(LinearLayout linearLayout, ToolBar toolBar, FrameLayout frameLayout)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `ActivityExternalWebBinding inflate(LayoutInflater layoutInflater)`  L30
- `ActivityExternalWebBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `ActivityExternalWebBinding bind(View view)`  L42
### `com.tuwinsmart.tuwin.databinding.ActivityFeedbackBinding`
L17 · [class] public final ActivityFeedbackBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityFeedbackBinding.java`

字段/常量（9）：
- `BLTextView btnSubmit`  L18
- `BLEditText etContact`  L19
- `BLEditText etContent`  L20
- `FrameLayout layoutDeviceSelector`  L21
- `ConstraintLayout rootView`  L22
- `Spinner spinnerDevice`  L23
- `TextView tvDeviceLabel`  L24
- `TextView tvDevicePlaceholder`  L25
- `int i = C1870R.id.btn_submit`  L56

方法（5）：
- `private ActivityFeedbackBinding(ConstraintLayout constraintLayout, BLTextView bLTextView, BLEditText bLEditText, BLEditText bLEditText2, FrameLayout frameLayout, Spinner spinner, TextView textView, TextView textView2)`  L27
- `ConstraintLayout getRoot()`  L39 @Override
- `ActivityFeedbackBinding inflate(LayoutInflater layoutInflater)`  L43
- `ActivityFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L47
- `ActivityFeedbackBinding bind(View view)`  L55
### `com.tuwinsmart.tuwin.databinding.ActivityFlashBinding`
L13 · [class] public final ActivityFlashBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityFlashBinding.java`

字段/常量（3）：
- `ImageView ivLogo`  L14
- `ConstraintLayout rootView`  L15
- `int i = C1870R.id.ivLogo`  L40

方法（5）：
- `private ActivityFlashBinding(ConstraintLayout constraintLayout, ImageView imageView)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `ActivityFlashBinding inflate(LayoutInflater layoutInflater)`  L27
- `ActivityFlashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L31
- `ActivityFlashBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.ActivityHomeBinding`
L17 · [class] public final ActivityHomeBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityHomeBinding.java`

字段/常量（14）：
- `LinearLayout btnAlbum`  L18
- `LinearLayout btnConnect`  L19
- `LinearLayout btnHelper`  L20
- `FrameLayout flContent`  L21
- `ImageView ivAlbum`  L22
- `ImageView ivHelper`  L23
- `ImageView ivHome`  L24
- `LinearLayout llBottomBar`  L25
- `ViewStub permissionViewStub`  L26
- `ConstraintLayout rootView`  L27
- `BLTextView tvAlbum`  L28
- `BLTextView tvHelper`  L29
- `BLTextView tvHome`  L30
- `int i = C1870R.id.btn_album`  L66

方法（5）：
- `private ActivityHomeBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout4, ViewStub viewStub, BLTextView bLTextView, BLTextView bLTextView2, BLTextView bLTextView3)`  L32
- `ConstraintLayout getRoot()`  L49 @Override
- `ActivityHomeBinding inflate(LayoutInflater layoutInflater)`  L53
- `ActivityHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L57
- `ActivityHomeBinding bind(View view)`  L65
### `com.tuwinsmart.tuwin.databinding.ActivityM3DeviceDetailBinding`
L19 · [class] public final ActivityM3DeviceDetailBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityM3DeviceDetailBinding.java`

字段/常量（31）：
- `ConstraintLayout clControls`  L20
- `FFmpegPlayerView ffmpegPlayerView`  L21
- `FrameLayout flModeContainer`  L22
- `FrameLayout flPreviewContainer`  L23
- `ImageView ivBack`  L24
- `ImageView ivBattery`  L25
- `ImageView ivCharging`  L26
- `ImageView ivFullscreen`  L27
- `ImageView ivGallery`  L28
- `ImageView ivHelp`  L29
- `ImageView ivModeMenu`  L30
- `ImageView ivSettings`  L31
- `LinearLayout llBatteryContainer`  L32
- `LinearLayout llLowQualityPreview`  L33
- `LinearLayout llSDError`  L34
- `LinearLayout llStorage`  L35
- `ProgressBar pbPlayerLoading`  L36
- `ConstraintLayout rootView`  L37
- `RecyclerView rvModeSelector`  L38
- `TextView tvBatteryLevel`  L39
- `TextView tvSDError`  L40
- `TextView tvStorage`  L41
- `TextView tvSubtitle`  L42
- `TextView tvTitle`  L43
- `View vCenterIndicator`  L44
- `View vControlAnchor`  L45
- `View vFlashOverlay`  L46
- `View viewFindChildViewById`  L96
- `View viewFindChildViewById2`  L97
- `View viewFindChildViewById3`  L98
- `int i = C1870R.id.clControls`  L99

方法（5）：
- `private ActivityM3DeviceDetailBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FFmpegPlayerView fFmpegPlayerView, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2, View view3)`  L48
- `ConstraintLayout getRoot()`  L79 @Override
- `ActivityM3DeviceDetailBinding inflate(LayoutInflater layoutInflater)`  L83
- `ActivityM3DeviceDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L87
- `ActivityM3DeviceDetailBinding bind(View view)`  L95
### `com.tuwinsmart.tuwin.databinding.ActivityM3DeviceSettingsBinding`
L14 · [class] public final ActivityM3DeviceSettingsBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityM3DeviceSettingsBinding.java`

字段/常量（4）：
- `LinearLayout rootView`  L15
- `RecyclerView rvSettings`  L16
- `TextView tvStatus`  L17
- `int i = C1870R.id.rv_settings`  L43

方法（5）：
- `private ActivityM3DeviceSettingsBinding(LinearLayout linearLayout, RecyclerView recyclerView, TextView textView)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `ActivityM3DeviceSettingsBinding inflate(LayoutInflater layoutInflater)`  L30
- `ActivityM3DeviceSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `ActivityM3DeviceSettingsBinding bind(View view)`  L42
### `com.tuwinsmart.tuwin.databinding.ActivityM3FactoryResetBinding`
L13 · [class] public final ActivityM3FactoryResetBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityM3FactoryResetBinding.java`

字段/常量（3）：
- `FrameLayout btnFactoryReset`  L14
- `ScrollView rootView`  L15
- `int i = C1870R.id.btn_factory_reset`  L40

方法（5）：
- `private ActivityM3FactoryResetBinding(ScrollView scrollView, FrameLayout frameLayout)`  L17
- `ScrollView getRoot()`  L23 @Override
- `ActivityM3FactoryResetBinding inflate(LayoutInflater layoutInflater)`  L27
- `ActivityM3FactoryResetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L31
- `ActivityM3FactoryResetBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.ActivityM3FirmwareUpgradeBinding`
L16 · [class] public final ActivityM3FirmwareUpgradeBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityM3FirmwareUpgradeBinding.java`

字段/常量（9）：
- `FrameLayout btnSelectFile`  L17
- `Button btnUpload`  L18
- `ProgressBar pbUpload`  L19
- `ScrollView rootView`  L20
- `TextView tvCurrentVersion`  L21
- `TextView tvSelectedFile`  L22
- `TextView tvUploadProgress`  L23
- `TextView tvUploadStatus`  L24
- `int i = C1870R.id.btn_select_file`  L55

方法（5）：
- `private ActivityM3FirmwareUpgradeBinding(ScrollView scrollView, FrameLayout frameLayout, Button button, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4)`  L26
- `ScrollView getRoot()`  L38 @Override
- `ActivityM3FirmwareUpgradeBinding inflate(LayoutInflater layoutInflater)`  L42
- `ActivityM3FirmwareUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L46
- `ActivityM3FirmwareUpgradeBinding bind(View view)`  L54
### `com.tuwinsmart.tuwin.databinding.ActivityM3StorageBinding`
L19 · [class] public final ActivityM3StorageBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityM3StorageBinding.java`

字段/常量（27）：
- `ImageView btnBack`  L20
- `ImageView btnCloseSelect`  L21
- `LinearLayout btnDelete`  L22
- `LinearLayout btnDownload`  L23
- `ImageView btnDownloading`  L24
- `ImageView btnSelectAll`  L25
- `ConstraintLayout clToolbar`  L26
- `FrameLayout emptyState`  L27
- `FrameLayout flDownloading`  L28
- `FrameLayout flSelectToolbar`  L29
- `ImageView ivDelete`  L30
- `ImageView ivDownload`  L31
- `LinearLayout llBottomActions`  L32
- `ConstraintLayout rootView`  L33
- `ItemStorageListSdcardBinding sdcardRoot`  L34
- `SlidingTabLayout tabLayout`  L35
- `FrameLayout toolbarContainer`  L36
- `TextView tvDelete`  L37
- `TextView tvDownload`  L38
- `BLTextView tvDownloadingNumber`  L39
- `TextView tvEmptyState`  L40
- `TextView tvSelectAll`  L41
- `TextView tvSelectCount`  L42
- `TextView tvTitle`  L43
- `SwipeViewPager viewPager`  L44
- `View viewFindChildViewById`  L92
- `int i = C1870R.id.btn_back`  L93

方法（5）：
- `private ActivityM3StorageBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout3, ItemStorageListSdcardBinding itemStorageListSdcardBinding, SlidingTabLayout slidingTabLayout, FrameLayout frameLayout4, TextView textView, TextView textView2, BLTextView bLTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, SwipeViewPager swipeViewPager)`  L46
- `ConstraintLayout getRoot()`  L75 @Override
- `ActivityM3StorageBinding inflate(LayoutInflater layoutInflater)`  L79
- `ActivityM3StorageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L83
- `ActivityM3StorageBinding bind(View view)`  L91
### `com.tuwinsmart.tuwin.databinding.ActivityM3StorageSettingsBinding`
L13 · [class] public final ActivityM3StorageSettingsBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityM3StorageSettingsBinding.java`

字段/常量（3）：
- `FrameLayout btnFormatSdcard`  L14
- `ScrollView rootView`  L15
- `int i = C1870R.id.btn_format_sdcard`  L40

方法（5）：
- `private ActivityM3StorageSettingsBinding(ScrollView scrollView, FrameLayout frameLayout)`  L17
- `ScrollView getRoot()`  L23 @Override
- `ActivityM3StorageSettingsBinding inflate(LayoutInflater layoutInflater)`  L27
- `ActivityM3StorageSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L31
- `ActivityM3StorageSettingsBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.ActivityM3VideoPlayBinding`
L18 · [class] public final ActivityM3VideoPlayBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityM3VideoPlayBinding.java`

字段/常量（14）：
- `ImageView btnBack`  L19
- `LinearLayout btnDelete`  L20
- `LinearLayout btnDownload`  L21
- `ImageView btnToolbarDownloading`  L22
- `FrameLayout flDownloadingContainer`  L23
- `LinearLayout llBottomActions`  L24
- `LinearLayout llLowQualityPreview`  L25
- `ConstraintLayout rootView`  L26
- `ConstraintLayout toolBar`  L27
- `BLTextView tvDownloadingNumber`  L28
- `TextView tvTitle`  L29
- `TextView tvVideoInfo`  L30
- `PlayListControlVideo videoPlayer`  L31
- `int i = C1870R.id.btn_back`  L67

方法（5）：
- `private ActivityM3VideoPlayBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, FrameLayout frameLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout2, BLTextView bLTextView, TextView textView, TextView textView2, PlayListControlVideo playListControlVideo)`  L33
- `ConstraintLayout getRoot()`  L50 @Override
- `ActivityM3VideoPlayBinding inflate(LayoutInflater layoutInflater)`  L54
- `ActivityM3VideoPlayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L58
- `ActivityM3VideoPlayBinding bind(View view)`  L66
### `com.tuwinsmart.tuwin.databinding.ActivityM3WifiSettingsBinding`
L14 · [class] public final ActivityM3WifiSettingsBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityM3WifiSettingsBinding.java`

字段/常量（5）：
- `FrameLayout btnWifiName`  L15
- `FrameLayout btnWifiPassword`  L16
- `ScrollView rootView`  L17
- `TextView tvWifiNameValue`  L18
- `int i = C1870R.id.btn_wifi_name`  L45

方法（5）：
- `private ActivityM3WifiSettingsBinding(ScrollView scrollView, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView)`  L20
- `ScrollView getRoot()`  L28 @Override
- `ActivityM3WifiSettingsBinding inflate(LayoutInflater layoutInflater)`  L32
- `ActivityM3WifiSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L36
- `ActivityM3WifiSettingsBinding bind(View view)`  L44
### `com.tuwinsmart.tuwin.databinding.ActivityMoreSettingsBinding`
L16 · [class] public final ActivityMoreSettingsBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityMoreSettingsBinding.java`

字段/常量（25）：
- `FrameLayout btnCircleRecordDuration`  L17
- `FrameLayout btnDeviceName`  L18
- `FrameLayout btnDpiSetting`  L19
- `LinearLayout btnParkingLevel`  L20
- `TextView btnResetDevice`  L21
- `TextView btnSoftwareUpdate`  L22
- `TextView btnStorageSetting`  L23
- `TextView btnSyncTime`  L24
- `LinearLayout btnUrgentLevel`  L25
- `FrameLayout btnWifiMode`  L26
- `TextView btnWifiSetting`  L27
- `LinearLayout btnWindNoise`  L28
- `ScrollView rootView`  L29
- `Switch switchParkingLevel`  L30
- `Switch switchRecordVoice`  L31
- `Switch switchShangxia`  L32
- `Switch switchUrgentLevel`  L33
- `Switch switchWindNoise`  L34
- `Switch switchZuoyou`  L35
- `TextView tvCircleRecordDuration`  L36
- `TextView tvDeviceName`  L37
- `TextView tvDpiSetting`  L38
- `TextView tvSoftVersion`  L39
- `TextView tvWifiModeDesc`  L40
- `int i = C1870R.id.btn_circle_record_duration`  L87

方法（5）：
- `private ActivityMoreSettingsBinding(ScrollView scrollView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout2, FrameLayout frameLayout4, TextView textView5, LinearLayout linearLayout3, Switch r16, Switch r17, Switch r18, Switch r19, Switch r20, Switch r21, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10)`  L42
- `ScrollView getRoot()`  L70 @Override
- `ActivityMoreSettingsBinding inflate(LayoutInflater layoutInflater)`  L74
- `ActivityMoreSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L78
- `ActivityMoreSettingsBinding bind(View view)`  L86
### `com.tuwinsmart.tuwin.databinding.ActivityPlayVideoBinding`
L17 · [class] public final ActivityPlayVideoBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityPlayVideoBinding.java`

字段/常量（10）：
- `TextView btnShareDownloadCancel`  L18
- `FrameLayout layoutShareDownloadProgress`  L19
- `ProgressBar progressShareDownload`  L20
- `ConstraintLayout rootView`  L21
- `ToolBar toolBar`  L22
- `TextView tvPath`  L23
- `TextView tvShareDownloadProgress`  L24
- `TextView tvShareDownloadTitle`  L25
- `PlayListControlVideo videoView`  L26
- `int i = C1870R.id.btn_share_download_cancel`  L58

方法（5）：
- `private ActivityPlayVideoBinding(ConstraintLayout constraintLayout, TextView textView, FrameLayout frameLayout, ProgressBar progressBar, ToolBar toolBar, TextView textView2, TextView textView3, TextView textView4, PlayListControlVideo playListControlVideo)`  L28
- `ConstraintLayout getRoot()`  L41 @Override
- `ActivityPlayVideoBinding inflate(LayoutInflater layoutInflater)`  L45
- `ActivityPlayVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L49
- `ActivityPlayVideoBinding bind(View view)`  L57
### `com.tuwinsmart.tuwin.databinding.ActivityRide3ProDailyDetailBinding`
L18 · [class] public final ActivityRide3ProDailyDetailBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityRide3ProDailyDetailBinding.java`

字段/常量（21）：
- `ImageView btnBack`  L19
- `LinearLayout btnDelete`  L20
- `LinearLayout btnDownload`  L21
- `LinearLayout btnReplayPlayback`  L22
- `ImageView btnShare`  L23
- `TextView btnShareDownloadCancel`  L24
- `ImageView imgReplayPlaybackIcon`  L25
- `FrameLayout layoutPlaybackOverlayHost`  L26
- `FrameLayout layoutPlayerContainer`  L27
- `FrameLayout layoutShareDownloadProgress`  L28
- `LinearLayout llBottomActions`  L29
- `LinearLayout llLowQualityPreview`  L30
- `ProgressBar progressShareDownload`  L31
- `ConstraintLayout rootView`  L32
- `ConstraintLayout toolBar`  L33
- `TextView tvShareDownloadProgress`  L34
- `TextView tvShareDownloadTitle`  L35
- `TextView tvTitle`  L36
- `TextView tvVideoInfo`  L37
- `FFmpegPlayerView videoView`  L38
- `int i = C1870R.id.btn_back`  L81

方法（5）：
- `private ActivityRide3ProDailyDetailBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView2, TextView textView, ImageView imageView3, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, ProgressBar progressBar, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, FFmpegPlayerView fFmpegPlayerView)`  L40
- `ConstraintLayout getRoot()`  L64 @Override
- `ActivityRide3ProDailyDetailBinding inflate(LayoutInflater layoutInflater)`  L68
- `ActivityRide3ProDailyDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L72
- `ActivityRide3ProDailyDetailBinding bind(View view)`  L80
### `com.tuwinsmart.tuwin.databinding.ActivityRide3proHourDetailBinding`
L20 · [class] public final ActivityRide3proHourDetailBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityRide3proHourDetailBinding.java`

字段/常量（24）：
- `ImageView btnBack`  L21
- `ImageView btnCloseSelect`  L22
- `LinearLayout btnDelete`  L23
- `LinearLayout btnDownload`  L24
- `ImageView btnDownloading`  L25
- `ImageView btnEdit`  L26
- `Button btnRetry`  L27
- `Ride3ProLoadingCardView deleteLoadingCard`  L28
- `LinearLayout errorContainer`  L29
- `FrameLayout flSelectToolbar`  L30
- `ImageView ivDelete`  L31
- `ImageView ivDownload`  L32
- `LinearLayout llBottomActions`  L33
- `ProgressBar progressBar`  L34
- `RecyclerView recyclerView`  L35
- `ConstraintLayout rootView`  L36
- `FrameLayout toolbarContainer`  L37
- `TextView tvDelete`  L38
- `TextView tvDownload`  L39
- `TextView tvEmpty`  L40
- `TextView tvSelectAll`  L41
- `TextView tvSelectCount`  L42
- `TextView tvTitle`  L43
- `int i = C1870R.id.btn_back`  L89

方法（5）：
- `private ActivityRide3proHourDetailBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView3, ImageView imageView4, Button button, Ride3ProLoadingCardView ride3ProLoadingCardView, LinearLayout linearLayout3, FrameLayout frameLayout, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout4, ProgressBar progressBar, RecyclerView recyclerView, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6)`  L45
- `ConstraintLayout getRoot()`  L72 @Override
- `ActivityRide3proHourDetailBinding inflate(LayoutInflater layoutInflater)`  L76
- `ActivityRide3proHourDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L80
- `ActivityRide3proHourDetailBinding bind(View view)`  L88
### `com.tuwinsmart.tuwin.databinding.ActivityRide3proHourPlaybackDetailBinding`
L23 · [class] public final ActivityRide3proHourPlaybackDetailBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityRide3proHourPlaybackDetailBinding.java`

字段/常量（51）：
- `ImageView btnBack`  L24
- `LinearLayout btnDelete`  L25
- `LinearLayout btnDownload`  L26
- `LinearLayout btnReplayPlayback`  L27
- `TextView btnRetryPlayback`  L28
- `ImageView btnShare`  L29
- `TextView btnShareDownloadCancel`  L30
- `View hourRecordingCenterGlow`  L31
- `View hourRecordingCenterHighlight`  L32
- `LinearLayout hourRecordingListSection`  L33
- `Ride3ProHourTimelineView hourTimeline`  L34
- `LinearLayout hourTimelineSection`  L35
- `ImageView imgReplayPlaybackIcon`  L36
- `ImageView ivTitleCalendar`  L37
- `ImageView ivTitleClock`  L38
- `FrameLayout layoutPlaybackOverlayHost`  L39
- `FrameLayout layoutPlayerContainer`  L40
- `FrameLayout layoutShareDownloadProgress`  L41
- `LinearLayout llBottomActions`  L42
- `LinearLayout llLowQualityPreview`  L43
- `NestedScrollView playbackContentScroll`  L44
- `LinearLayout playbackErrorState`  L45
- `ImageView playerDefaultBackground`  L46
- `ProgressBar progressShareDownload`  L47
- `RecordingControlEventsView recordingControlEvents`  L48
- `RecyclerView recyclerHourRecordings`  L49
- `RecyclerView recyclerSelectedVideos`  L50
- `ConstraintLayout rootView`  L51
- `ConstraintLayout selectedVideoPanel`  L52
- `Space spacePlayerToVideoInfo`  L53
- `Space spaceTimelineToBottomActions`  L54
- `Space spaceVideoInfoToTimeline`  L55
- `LinearLayout titleCapsule`  L56
- `LinearLayout titleDateGroup`  L57
- `LinearLayout titleTimeGroup`  L58
- `ConstraintLayout toolBar`  L59
- `TextView tvHourContentCount`  L60
- `TextView tvHourRange`  L61
- `TextView tvHourRecordingCount`  L62
- `TextView tvSelectedVideoTitle`  L63
- `TextView tvShareDownloadProgress`  L64
- `TextView tvShareDownloadTitle`  L65
- `TextView tvTitle`  L66
- `TextView tvTitleDate`  L67
- `TextView tvTitleTime`  L68
- `TextView tvVideoInfo`  L69
- `ConstraintLayout videoInfoCard`  L70
- `FFmpegPlayerView videoView`  L71
- `View viewFindChildViewById`  L142
- `View viewFindChildViewById2`  L143
- `int i = C1870R.id.btn_back`  L144

方法（5）：
- `private ActivityRide3proHourPlaybackDetailBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, ImageView imageView2, TextView textView2, View view, View view2, LinearLayout linearLayout4, Ride3ProHourTimelineView ride3ProHourTimelineView, LinearLayout linearLayout5, ImageView imageView3, ImageView imageView4, ImageView imageView5, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout6, LinearLayout linearLayout7, NestedScrollView nestedScrollView, LinearLayout linearLayout8, ImageView imageView6, ProgressBar progressBar, RecordingControlEventsView recordingControlEventsView, RecyclerView recyclerView, RecyclerView recyclerView2, ConstraintLayout constraintLayout2, Space space, Space space2, Space space3, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, ConstraintLayout constraintLayout4, FFmpegPlayerView fFmpegPlayerView)`  L73
- `ConstraintLayout getRoot()`  L125 @Override
- `ActivityRide3proHourPlaybackDetailBinding inflate(LayoutInflater layoutInflater)`  L129
- `ActivityRide3proHourPlaybackDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L133
- `ActivityRide3proHourPlaybackDetailBinding bind(View view)`  L141
### `com.tuwinsmart.tuwin.databinding.ActivityRide3proIndexedStorageBinding`
L15 · [class] public final ActivityRide3proIndexedStorageBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityRide3proIndexedStorageBinding.java`

字段/常量（5）：
- `ImageView btnBack`  L16
- `FragmentContainerView indexedStorageFragmentContainer`  L17
- `ConstraintLayout rootView`  L18
- `FrameLayout toolbarContainer`  L19
- `int i = C1870R.id.btn_back`  L46

方法（5）：
- `private ActivityRide3proIndexedStorageBinding(ConstraintLayout constraintLayout, ImageView imageView, FragmentContainerView fragmentContainerView, FrameLayout frameLayout)`  L21
- `ConstraintLayout getRoot()`  L29 @Override
- `ActivityRide3proIndexedStorageBinding inflate(LayoutInflater layoutInflater)`  L33
- `ActivityRide3proIndexedStorageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L37
- `ActivityRide3proIndexedStorageBinding bind(View view)`  L45
### `com.tuwinsmart.tuwin.databinding.ActivityRide3ProSettingsBinding`
L16 · [class] public final ActivityRide3ProSettingsBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityRide3ProSettingsBinding.java`

字段/常量（15）：
- `FrameLayout btnDeviceName`  L17
- `TextView btnFactoryReset`  L18
- `FrameLayout btnFirmwareUpgrade`  L19
- `TextView btnReboot`  L20
- `TextView btnStorageSetting`  L21
- `TextView btnWifiSetting`  L22
- `ScrollView legacySettingsContainer`  L23
- `LinearLayout ride6DynamicContainer`  L24
- `LinearLayout rootView`  L25
- `RecyclerView rvSettings`  L26
- `TextView tvDeviceName`  L27
- `TextView tvFirmwareVersion`  L28
- `TextView tvRide6SettingsHeader`  L29
- `TextView tvSettingsError`  L30
- `int i = C1870R.id.btn_device_name`  L67

方法（5）：
- `private ActivityRide3ProSettingsBinding(LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, TextView textView2, TextView textView3, TextView textView4, ScrollView scrollView, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView5, TextView textView6, TextView textView7, TextView textView8)`  L32
- `LinearLayout getRoot()`  L50 @Override
- `ActivityRide3ProSettingsBinding inflate(LayoutInflater layoutInflater)`  L54
- `ActivityRide3ProSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L58
- `ActivityRide3ProSettingsBinding bind(View view)`  L66
### `com.tuwinsmart.tuwin.databinding.ActivityRide3proStorageBinding`
L19 · [class] public final ActivityRide3proStorageBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityRide3proStorageBinding.java`

字段/常量（25）：
- `ImageView btnBack`  L20
- `ImageView btnCloseSelect`  L21
- `LinearLayout btnDelete`  L22
- `LinearLayout btnDownload`  L23
- `ImageView btnDownloading`  L24
- `ImageView btnSelectAll`  L25
- `ConstraintLayout clToolbar`  L26
- `FrameLayout flDownloading`  L27
- `FrameLayout flSelectToolbar`  L28
- `ImageView ivDelete`  L29
- `ImageView ivDownload`  L30
- `LinearLayout llBottomActions`  L31
- `ConstraintLayout rootView`  L32
- `ItemStorageListSdcardBinding sdcardRoot`  L33
- `SlidingTabLayout tabLayout`  L34
- `FrameLayout toolbarContainer`  L35
- `TextView tvDelete`  L36
- `TextView tvDownload`  L37
- `BLTextView tvDownloadingNumber`  L38
- `TextView tvSelectAll`  L39
- `TextView tvSelectCount`  L40
- `TextView tvTitle`  L41
- `SwipeViewPager viewPager`  L42
- `View viewFindChildViewById`  L88
- `int i = C1870R.id.btn_back`  L89

方法（5）：
- `private ActivityRide3proStorageBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout3, ItemStorageListSdcardBinding itemStorageListSdcardBinding, SlidingTabLayout slidingTabLayout, FrameLayout frameLayout3, TextView textView, TextView textView2, BLTextView bLTextView, TextView textView3, TextView textView4, TextView textView5, SwipeViewPager swipeViewPager)`  L44
- `ConstraintLayout getRoot()`  L71 @Override
- `ActivityRide3proStorageBinding inflate(LayoutInflater layoutInflater)`  L75
- `ActivityRide3proStorageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L79
- `ActivityRide3proStorageBinding bind(View view)`  L87
### `com.tuwinsmart.tuwin.databinding.ActivityRide5HourDetailBinding`
L19 · [class] public final ActivityRide5HourDetailBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityRide5HourDetailBinding.java`

字段/常量（23）：
- `ImageView btnBack`  L20
- `ImageView btnCloseSelect`  L21
- `LinearLayout btnDelete`  L22
- `LinearLayout btnDownload`  L23
- `ImageView btnDownloading`  L24
- `ImageView btnEdit`  L25
- `Button btnRetry`  L26
- `LinearLayout errorContainer`  L27
- `FrameLayout flSelectToolbar`  L28
- `ImageView ivDelete`  L29
- `ImageView ivDownload`  L30
- `LinearLayout llBottomActions`  L31
- `ProgressBar progressBar`  L32
- `RecyclerView recyclerView`  L33
- `ConstraintLayout rootView`  L34
- `FrameLayout toolbarContainer`  L35
- `TextView tvDelete`  L36
- `TextView tvDownload`  L37
- `TextView tvEmpty`  L38
- `TextView tvSelectAll`  L39
- `TextView tvSelectCount`  L40
- `TextView tvTitle`  L41
- `int i = C1870R.id.btn_back`  L86

方法（5）：
- `private ActivityRide5HourDetailBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView3, ImageView imageView4, Button button, LinearLayout linearLayout3, FrameLayout frameLayout, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout4, ProgressBar progressBar, RecyclerView recyclerView, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6)`  L43
- `ConstraintLayout getRoot()`  L69 @Override
- `ActivityRide5HourDetailBinding inflate(LayoutInflater layoutInflater)`  L73
- `ActivityRide5HourDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L77
- `ActivityRide5HourDetailBinding bind(View view)`  L85
### `com.tuwinsmart.tuwin.databinding.ActivityRide5HourPlaybackDetailBinding`
L23 · [class] public final ActivityRide5HourPlaybackDetailBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityRide5HourPlaybackDetailBinding.java`

字段/常量（51）：
- `ImageView btnBack`  L24
- `LinearLayout btnDelete`  L25
- `LinearLayout btnDownload`  L26
- `LinearLayout btnReplayPlayback`  L27
- `TextView btnRetryPlayback`  L28
- `ImageView btnShare`  L29
- `TextView btnShareDownloadCancel`  L30
- `View hourRecordingCenterGlow`  L31
- `View hourRecordingCenterHighlight`  L32
- `LinearLayout hourRecordingListSection`  L33
- `Ride5HourTimelineView hourTimeline`  L34
- `LinearLayout hourTimelineSection`  L35
- `ImageView imgReplayPlaybackIcon`  L36
- `ImageView ivTitleCalendar`  L37
- `ImageView ivTitleClock`  L38
- `FrameLayout layoutPlaybackOverlayHost`  L39
- `FrameLayout layoutPlayerContainer`  L40
- `FrameLayout layoutShareDownloadProgress`  L41
- `LinearLayout llBottomActions`  L42
- `LinearLayout llLowQualityPreview`  L43
- `NestedScrollView playbackContentScroll`  L44
- `LinearLayout playbackErrorState`  L45
- `ImageView playerDefaultBackground`  L46
- `ProgressBar progressShareDownload`  L47
- `RecordingControlEventsView recordingControlEvents`  L48
- `RecyclerView recyclerHourRecordings`  L49
- `RecyclerView recyclerSelectedVideos`  L50
- `ConstraintLayout rootView`  L51
- `ConstraintLayout selectedVideoPanel`  L52
- `Space spacePlayerToVideoInfo`  L53
- `Space spaceTimelineToBottomActions`  L54
- `Space spaceVideoInfoToTimeline`  L55
- `LinearLayout titleCapsule`  L56
- `LinearLayout titleDateGroup`  L57
- `LinearLayout titleTimeGroup`  L58
- `ConstraintLayout toolBar`  L59
- `TextView tvHourContentCount`  L60
- `TextView tvHourRange`  L61
- `TextView tvHourRecordingCount`  L62
- `TextView tvSelectedVideoTitle`  L63
- `TextView tvShareDownloadProgress`  L64
- `TextView tvShareDownloadTitle`  L65
- `TextView tvTitle`  L66
- `TextView tvTitleDate`  L67
- `TextView tvTitleTime`  L68
- `TextView tvVideoInfo`  L69
- `ConstraintLayout videoInfoCard`  L70
- `PlayListControlVideo videoView`  L71
- `View viewFindChildViewById`  L142
- `View viewFindChildViewById2`  L143
- `int i = C1870R.id.btn_back`  L144

方法（5）：
- `private ActivityRide5HourPlaybackDetailBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, ImageView imageView2, TextView textView2, View view, View view2, LinearLayout linearLayout4, Ride5HourTimelineView ride5HourTimelineView, LinearLayout linearLayout5, ImageView imageView3, ImageView imageView4, ImageView imageView5, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout6, LinearLayout linearLayout7, NestedScrollView nestedScrollView, LinearLayout linearLayout8, ImageView imageView6, ProgressBar progressBar, RecordingControlEventsView recordingControlEventsView, RecyclerView recyclerView, RecyclerView recyclerView2, ConstraintLayout constraintLayout2, Space space, Space space2, Space space3, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, ConstraintLayout constraintLayout4, PlayListControlVideo playListControlVideo)`  L73
- `ConstraintLayout getRoot()`  L125 @Override
- `ActivityRide5HourPlaybackDetailBinding inflate(LayoutInflater layoutInflater)`  L129
- `ActivityRide5HourPlaybackDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L133
- `ActivityRide5HourPlaybackDetailBinding bind(View view)`  L141
### `com.tuwinsmart.tuwin.databinding.ActivityShowPicsBinding`
L11 · [class] public final ActivityShowPicsBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityShowPicsBinding.java`

字段/常量（2）：
- `ViewPager rootView`  L12
- `ViewPager viewPager`  L13

方法（6）：
- `private ActivityShowPicsBinding(ViewPager viewPager, ViewPager viewPager2)`  L15
- `ViewPager getRoot()`  L21 @Override
- `ActivityShowPicsBinding inflate(LayoutInflater layoutInflater)`  L25
- `ActivityShowPicsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L29
- `ActivityShowPicsBinding bind(View view)`  L37
- `throw new NullPointerException( 0 )`  L39
### `com.tuwinsmart.tuwin.databinding.ActivityStorageManagerBinding`
L16 · [class] public final ActivityStorageManagerBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityStorageManagerBinding.java`

字段/常量（14）：
- `TextView btnRemoveSdcard`  L17
- `ConstraintLayout btnRestoreSdcard`  L18
- `ImageView ivFormatSdcard`  L19
- `ConstraintLayout rootView`  L20
- `TextView tvFormatSdcard`  L21
- `TextView tvSdFormatReminder`  L22
- `TextView tvStorageRemains`  L23
- `TextView tvStorageStatus`  L24
- `TextView tvStorageTotal`  L25
- `BLView viewCircleBg`  L26
- `View viewFormatDivider`  L27
- `MultiWaveHeader waveView`  L28
- `View viewFindChildViewById`  L63
- `int i = C1870R.id.btn_remove_sdcard`  L64

方法（5）：
- `private ActivityStorageManagerBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, BLView bLView, View view, MultiWaveHeader multiWaveHeader)`  L30
- `ConstraintLayout getRoot()`  L46 @Override
- `ActivityStorageManagerBinding inflate(LayoutInflater layoutInflater)`  L50
- `ActivityStorageManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L54
- `ActivityStorageManagerBinding bind(View view)`  L62
### `com.tuwinsmart.tuwin.databinding.ActivityStorageTabBinding`
L14 · [class] public final ActivityStorageTabBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityStorageTabBinding.java`

字段/常量（6）：
- `CoordinatorLayout rootView`  L15
- `ItemStorageListSdcardBinding sdcardRoot`  L16
- `SlidingTabLayout tabLayout`  L17
- `SwipeViewPager viewPager`  L18
- `int i = C1870R.id.sdcard_root`  L45
- `int i2 = C1870R.id.tab_layout`  L49

方法（5）：
- `private ActivityStorageTabBinding(CoordinatorLayout coordinatorLayout, ItemStorageListSdcardBinding itemStorageListSdcardBinding, SlidingTabLayout slidingTabLayout, SwipeViewPager swipeViewPager)`  L20
- `CoordinatorLayout getRoot()`  L28 @Override
- `ActivityStorageTabBinding inflate(LayoutInflater layoutInflater)`  L32
- `ActivityStorageTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L36
- `ActivityStorageTabBinding bind(View view)`  L44
### `com.tuwinsmart.tuwin.databinding.ActivityUpgradeBinding`
L17 · [class] public final ActivityUpgradeBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityUpgradeBinding.java`

字段/常量（14）：
- `BLTextView btnUpgrade`  L18
- `ImageView ivUpgrade`  L19
- `LinearLayout llProgress`  L20
- `LinearLayout llUpgradeContent`  L21
- `LinearLayout llUpgrading`  L22
- `ProgressBar pbDownload`  L23
- `ConstraintLayout rootView`  L24
- `TextView tvProgress`  L25
- `TextView tvSubTitle`  L26
- `TextView tvTitle`  L27
- `TextView tvUpgradeContent`  L28
- `TextView tvUpgradingSubTitle`  L29
- `TextView tvUpgradingTitle`  L30
- `int i = C1870R.id.btn_upgrade`  L66

方法（5）：
- `private ActivityUpgradeBinding(ConstraintLayout constraintLayout, BLTextView bLTextView, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6)`  L32
- `ConstraintLayout getRoot()`  L49 @Override
- `ActivityUpgradeBinding inflate(LayoutInflater layoutInflater)`  L53
- `ActivityUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L57
- `ActivityUpgradeBinding bind(View view)`  L65
### `com.tuwinsmart.tuwin.databinding.ActivityWebviewBinding`
L16 · [class] public final ActivityWebviewBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ActivityWebviewBinding.java`

字段/常量（6）：
- `WebProgress progressBar`  L17
- `LinearLayout rootView`  L18
- `ToolBar toolbar`  L19
- `WebView webview`  L20
- `FrameLayout webviewContainer`  L21
- `int i = C1870R.id.progress_bar`  L49

方法（5）：
- `private ActivityWebviewBinding(LinearLayout linearLayout, WebProgress webProgress, ToolBar toolBar, WebView webView, FrameLayout frameLayout)`  L23
- `LinearLayout getRoot()`  L32 @Override
- `ActivityWebviewBinding inflate(LayoutInflater layoutInflater)`  L36
- `ActivityWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L40
- `ActivityWebviewBinding bind(View view)`  L48
### `com.tuwinsmart.tuwin.databinding.DialogCommonBinding`
L14 · [class] public final DialogCommonBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogCommonBinding.java`

字段/常量（6）：
- `BLTextView btnPrimary`  L15
- `BLTextView btnSecond`  L16
- `BLLinearLayout rootView`  L17
- `TextView tvSubTitle`  L18
- `TextView tvTitle`  L19
- `int i = C1870R.id.btn_primary`  L47

方法（5）：
- `private DialogCommonBinding(BLLinearLayout bLLinearLayout, BLTextView bLTextView, BLTextView bLTextView2, TextView textView, TextView textView2)`  L21
- `BLLinearLayout getRoot()`  L30 @Override
- `DialogCommonBinding inflate(LayoutInflater layoutInflater)`  L34
- `DialogCommonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L38
- `DialogCommonBinding bind(View view)`  L46
### `com.tuwinsmart.tuwin.databinding.DialogConnect2Binding`
L16 · [class] public final DialogConnect2Binding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogConnect2Binding.java`

字段/常量（8）：
- `BLTextView btnSubmit`  L17
- `ScrollView rootView`  L18
- `TextView tvDialogSubTitle`  L19
- `TextView tvDialogTitle`  L20
- `TextView tvWifiDisabledHint`  L21
- `BLConstraintLayout wifiDisabledContent`  L22
- `ImageView wifiDisabledIllustration`  L23
- `int i = C1870R.id.btn_submit`  L53

方法（5）：
- `private DialogConnect2Binding(ScrollView scrollView, BLTextView bLTextView, TextView textView, TextView textView2, TextView textView3, BLConstraintLayout bLConstraintLayout, ImageView imageView)`  L25
- `ScrollView getRoot()`  L36 @Override
- `DialogConnect2Binding inflate(LayoutInflater layoutInflater)`  L40
- `DialogConnect2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L44
- `DialogConnect2Binding bind(View view)`  L52
### `com.tuwinsmart.tuwin.databinding.DialogConnectHelperBinding`
L14 · [class] public final DialogConnectHelperBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogConnectHelperBinding.java`

字段/常量（8）：
- `BLTextView btnReject`  L15
- `BLTextView btnSubmit`  L16
- `FrameLayout rootView`  L17
- `TextView tvLocationItem`  L18
- `TextView tvLocationTitle`  L19
- `TextView tvStorageItem`  L20
- `TextView tvStorageTitle`  L21
- `int i = C1870R.id.btn_reject`  L51

方法（5）：
- `private DialogConnectHelperBinding(FrameLayout frameLayout, BLTextView bLTextView, BLTextView bLTextView2, TextView textView, TextView textView2, TextView textView3, TextView textView4)`  L23
- `FrameLayout getRoot()`  L34 @Override
- `DialogConnectHelperBinding inflate(LayoutInflater layoutInflater)`  L38
- `DialogConnectHelperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L42
- `DialogConnectHelperBinding bind(View view)`  L50
### `com.tuwinsmart.tuwin.databinding.DialogConnectionProgressBinding`
L15 · [class] public final DialogConnectionProgressBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogConnectionProgressBinding.java`

字段/常量（8）：
- `ImageView ivConnectionStatus`  L16
- `ProgressBar progressConnection`  L17
- `FrameLayout rootView`  L18
- `FrameLayout statusContainer`  L19
- `TextView tvConnectionDetail`  L20
- `TextView tvConnectionHint`  L21
- `TextView tvConnectionTitle`  L22
- `int i = C1870R.id.iv_connection_status`  L52

方法（5）：
- `private DialogConnectionProgressBinding(FrameLayout frameLayout, ImageView imageView, ProgressBar progressBar, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3)`  L24
- `FrameLayout getRoot()`  L35 @Override
- `DialogConnectionProgressBinding inflate(LayoutInflater layoutInflater)`  L39
- `DialogConnectionProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L43
- `DialogConnectionProgressBinding bind(View view)`  L51
### `com.tuwinsmart.tuwin.databinding.DialogDeviceWifiScanBinding`
L18 · [class] public final DialogDeviceWifiScanBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogDeviceWifiScanBinding.java`

字段/常量（17）：
- `BLTextView btnDeviceWifiCancel`  L19
- `TextView btnDeviceWifiFallback`  L20
- `BLTextView btnDeviceWifiRetry`  L21
- `LinearLayout deviceWifiActions`  L22
- `View deviceWifiContentAnchor`  L23
- `Barrier deviceWifiContentBarrier`  L24
- `View deviceWifiFooterDivider`  L25
- `ProgressBar progressDeviceWifiScan`  L26
- `FrameLayout rootView`  L27
- `RecyclerView rvDeviceWifi`  L28
- `TextView tvDeviceWifiFallbackTitle`  L29
- `TextView tvDeviceWifiSectionTitle`  L30
- `TextView tvDeviceWifiStatus`  L31
- `TextView tvDeviceWifiTitle`  L32
- `View viewFindChildViewById`  L69
- `View viewFindChildViewById2`  L70
- `int i = C1870R.id.btn_device_wifi_cancel`  L71

方法（5）：
- `private DialogDeviceWifiScanBinding(FrameLayout frameLayout, BLTextView bLTextView, TextView textView, BLTextView bLTextView2, LinearLayout linearLayout, View view, Barrier barrier, View view2, ProgressBar progressBar, RecyclerView recyclerView, TextView textView2, TextView textView3, TextView textView4, TextView textView5)`  L34
- `FrameLayout getRoot()`  L52 @Override
- `DialogDeviceWifiScanBinding inflate(LayoutInflater layoutInflater)`  L56
- `DialogDeviceWifiScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L60
- `DialogDeviceWifiScanBinding bind(View view)`  L68
### `com.tuwinsmart.tuwin.databinding.DialogFirmwareDownloadBinding`
L16 · [class] public final DialogFirmwareDownloadBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogFirmwareDownloadBinding.java`

字段/常量（10）：
- `BLTextView firmwareDownloadAction`  L17
- `ImageView firmwareDownloadIcon`  L18
- `TextView firmwareDownloadMessage`  L19
- `TextView firmwareDownloadPercent`  L20
- `ProgressBar firmwareDownloadProgress`  L21
- `View firmwareDownloadResultSpacer`  L22
- `TextView firmwareDownloadTitle`  L23
- `FrameLayout rootView`  L24
- `View viewFindChildViewById`  L55
- `int i = C1870R.id.firmwareDownloadAction`  L56

方法（5）：
- `private DialogFirmwareDownloadBinding(FrameLayout frameLayout, BLTextView bLTextView, ImageView imageView, TextView textView, TextView textView2, ProgressBar progressBar, View view, TextView textView3)`  L26
- `FrameLayout getRoot()`  L38 @Override
- `DialogFirmwareDownloadBinding inflate(LayoutInflater layoutInflater)`  L42
- `DialogFirmwareDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L46
- `DialogFirmwareDownloadBinding bind(View view)`  L54
### `com.tuwinsmart.tuwin.databinding.DialogFirmwareUpdateBinding`
L18 · [class] public final DialogFirmwareUpdateBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogFirmwareUpdateBinding.java`

字段/常量（13）：
- `View blackBgView`  L19
- `BLImageView closeBtn`  L20
- `BLLinearLayout contentView`  L21
- `ImageView iconImageView`  L22
- `FrameLayout rootView`  L23
- `TextView titleLabel`  L24
- `View topBarView`  L25
- `ScrollView updateLogScrollView`  L26
- `BLTextView updateLogTextView`  L27
- `BLTextView upgradeBtn`  L28
- `TextView versionLabel`  L29
- `View viewFindChildViewById`  L63
- `int i = C1870R.id.blackBgView`  L64

方法（5）：
- `private DialogFirmwareUpdateBinding(FrameLayout frameLayout, View view, BLImageView bLImageView, BLLinearLayout bLLinearLayout, ImageView imageView, TextView textView, View view2, ScrollView scrollView, BLTextView bLTextView, BLTextView bLTextView2, TextView textView2)`  L31
- `FrameLayout getRoot()`  L46 @Override
- `DialogFirmwareUpdateBinding inflate(LayoutInflater layoutInflater)`  L50
- `DialogFirmwareUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L54
- `DialogFirmwareUpdateBinding bind(View view)`  L62
### `com.tuwinsmart.tuwin.databinding.DialogFirmwareUploadBinding`
L17 · [class] public final DialogFirmwareUploadBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogFirmwareUploadBinding.java`

字段/常量（13）：
- `TextView firmwareRemainTime`  L18
- `TextView firmwareTotalSize`  L19
- `ImageView firmwareUploadIcon`  L20
- `TextView firmwareUploadPercent`  L21
- `FirmwareUploadRingView firmwareUploadProgress`  L22
- `BLTextView firmwareUploadRetry`  L23
- `ProgressBar firmwareUploadSpinner`  L24
- `TextView firmwareUploadStatus`  L25
- `TextView firmwareUploadTitle`  L26
- `TextView firmwareUploadWarning`  L27
- `TextView firmwareUploadedSize`  L28
- `FrameLayout rootView`  L29
- `int i = C1870R.id.firmwareRemainTime`  L64

方法（5）：
- `private DialogFirmwareUploadBinding(FrameLayout frameLayout, TextView textView, TextView textView2, ImageView imageView, TextView textView3, FirmwareUploadRingView firmwareUploadRingView, BLTextView bLTextView, ProgressBar progressBar, TextView textView4, TextView textView5, TextView textView6, TextView textView7)`  L31
- `FrameLayout getRoot()`  L47 @Override
- `DialogFirmwareUploadBinding inflate(LayoutInflater layoutInflater)`  L51
- `DialogFirmwareUploadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L55
- `DialogFirmwareUploadBinding bind(View view)`  L63
### `com.tuwinsmart.tuwin.databinding.DialogM3ModeSelectorBinding`
L14 · [class] public final DialogM3ModeSelectorBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogM3ModeSelectorBinding.java`

字段/常量（6）：
- `ConstraintLayout rootView`  L15
- `RecyclerView rvModeGrid`  L16
- `TextView tvTitle`  L17
- `View vHandle`  L18
- `View viewFindChildViewById`  L45
- `int i = C1870R.id.rvModeGrid`  L46

方法（5）：
- `private DialogM3ModeSelectorBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, View view)`  L20
- `ConstraintLayout getRoot()`  L28 @Override
- `DialogM3ModeSelectorBinding inflate(LayoutInflater layoutInflater)`  L32
- `DialogM3ModeSelectorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L36
- `DialogM3ModeSelectorBinding bind(View view)`  L44
### `com.tuwinsmart.tuwin.databinding.DialogProgressBinding`
L13 · [class] public final DialogProgressBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogProgressBinding.java`

字段/常量（3）：
- `LinearLayout rootView`  L14
- `TextView tvLoadingDetail`  L15
- `int i = C1870R.id.tv_loading_detail`  L40

方法（5）：
- `private DialogProgressBinding(LinearLayout linearLayout, TextView textView)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `DialogProgressBinding inflate(LayoutInflater layoutInflater)`  L27
- `DialogProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L31
- `DialogProgressBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.DialogRide3proStorageLoadingBinding`
L13 · [class] public final DialogRide3proStorageLoadingBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogRide3proStorageLoadingBinding.java`

字段/常量（3）：
- `FrameLayout rootView`  L14
- `Ride3ProLoadingCardView storageLoadingCard`  L15
- `int i = C1870R.id.storage_loading_card`  L40

方法（5）：
- `private DialogRide3proStorageLoadingBinding(FrameLayout frameLayout, Ride3ProLoadingCardView ride3ProLoadingCardView)`  L17
- `FrameLayout getRoot()`  L23 @Override
- `DialogRide3proStorageLoadingBinding inflate(LayoutInflater layoutInflater)`  L27
- `DialogRide3proStorageLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L31
- `DialogRide3proStorageLoadingBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.DialogSettingSelectionBinding`
L14 · [class] public final DialogSettingSelectionBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/DialogSettingSelectionBinding.java`

字段/常量（7）：
- `TextView btnCancel`  L15
- `ConstraintLayout rootView`  L16
- `RecyclerView rvOptions`  L17
- `TextView tvDialogTitle`  L18
- `View vHandle`  L19
- `View viewFindChildViewById`  L47
- `int i = C1870R.id.btn_cancel`  L48

方法（5）：
- `private DialogSettingSelectionBinding(ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, TextView textView2, View view)`  L21
- `ConstraintLayout getRoot()`  L30 @Override
- `DialogSettingSelectionBinding inflate(LayoutInflater layoutInflater)`  L34
- `DialogSettingSelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L38
- `DialogSettingSelectionBinding bind(View view)`  L46
### `com.tuwinsmart.tuwin.databinding.EmptyControlVideoBinding`
L18 · [class] public final EmptyControlVideoBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/EmptyControlVideoBinding.java`

字段/常量（18）：
- `ImageView back`  L19
- `LinearLayout btnGsyChangeSpeed`  L20
- `LinearLayout btnGsyChangeVoice`  L21
- `TextView btnGsyDownload`  L22
- `LinearLayout btnGsyRecordVideo`  L23
- `TextView btnGsyScreenshot`  L24
- `ProgressBar gsyProgressBar`  L25
- `ImageView ivGsyCover`  L26
- `ImageView ivGsyRecordState`  L27
- `ImageView ivGsyVoiceState`  L28
- `BLLinearLayout layoutGsyRight`  L29
- `BLLinearLayout layoutGsyTop`  L30
- `RelativeLayout rootView`  L31
- `FrameLayout surfaceContainer`  L32
- `TextView tvGsyChangeSpeed`  L33
- `TextView tvGsyRecordState`  L34
- `TextView tvGsyVoiceState`  L35
- `int i = C1870R.id.back`  L75

方法（5）：
- `private EmptyControlVideoBinding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, TextView textView2, ProgressBar progressBar, ImageView imageView2, ImageView imageView3, ImageView imageView4, BLLinearLayout bLLinearLayout, BLLinearLayout bLLinearLayout2, FrameLayout frameLayout, TextView textView3, TextView textView4, TextView textView5)`  L37
- `RelativeLayout getRoot()`  L58 @Override
- `EmptyControlVideoBinding inflate(LayoutInflater layoutInflater)`  L62
- `EmptyControlVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L66
- `EmptyControlVideoBinding bind(View view)`  L74
### `com.tuwinsmart.tuwin.databinding.FragmentAlbumBinding`
L19 · [class] public final FragmentAlbumBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentAlbumBinding.java`

字段/常量（17）：
- `ImageView btnCloseSelect`  L20
- `LinearLayout btnDelete`  L21
- `ImageView btnDownloading`  L22
- `BLTextView btnRequestPermission`  L23
- `ImageView btnSelectAll`  L24
- `ConstraintLayout clToolbar`  L25
- `FrameLayout flSelectToolbar`  L26
- `LinearLayout llContent`  L27
- `LinearLayout llPermissionGroup`  L28
- `LinearLayout rootView`  L29
- `SlidingTabLayout tabLayout`  L30
- `TextView tvDelete`  L31
- `BLTextView tvDownloadingNumber`  L32
- `TextView tvSelectAll`  L33
- `TextView tvSelectCount`  L34
- `SwipeViewPager viewPager`  L35
- `int i = C1870R.id.btn_close_select`  L74

方法（5）：
- `private FragmentAlbumBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, ImageView imageView2, BLTextView bLTextView, ImageView imageView3, ConstraintLayout constraintLayout, FrameLayout frameLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, SlidingTabLayout slidingTabLayout, TextView textView, BLTextView bLTextView2, TextView textView2, TextView textView3, SwipeViewPager swipeViewPager)`  L37
- `LinearLayout getRoot()`  L57 @Override
- `FragmentAlbumBinding inflate(LayoutInflater layoutInflater)`  L61
- `FragmentAlbumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L65
- `FragmentAlbumBinding bind(View view)`  L73
### `com.tuwinsmart.tuwin.databinding.FragmentConnectBinding`
L16 · [class] public final FragmentConnectBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentConnectBinding.java`

字段/常量（7）：
- `ConstraintLayout clLogo`  L17
- `ImageView ivLogo`  L18
- `ViewStub permissionViewStub`  L19
- `RecyclerView recyclerView`  L20
- `SwipeRefreshLayout refreshLayout`  L21
- `ConstraintLayout rootView`  L22
- `int i = C1870R.id.cl_logo`  L51

方法（5）：
- `private FragmentConnectBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ViewStub viewStub, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout)`  L24
- `ConstraintLayout getRoot()`  L34 @Override
- `FragmentConnectBinding inflate(LayoutInflater layoutInflater)`  L38
- `FragmentConnectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L42
- `FragmentConnectBinding bind(View view)`  L50
### `com.tuwinsmart.tuwin.databinding.FragmentHelperBinding`
L15 · [class] public final FragmentHelperBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentHelperBinding.java`

字段/常量（8）：
- `TextView btnAboutUs`  L16
- `TextView btnFeedback`  L17
- `FrameLayout btnLanguage`  L18
- `TextView btnPrivacy`  L19
- `BLLinearLayout btnRide5Helper`  L20
- `LinearLayout rootView`  L21
- `TextView tvLanguage`  L22
- `int i = C1870R.id.btn_about_us`  L52

方法（5）：
- `private FragmentHelperBinding(LinearLayout linearLayout, TextView textView, TextView textView2, FrameLayout frameLayout, TextView textView3, BLLinearLayout bLLinearLayout, TextView textView4)`  L24
- `LinearLayout getRoot()`  L35 @Override
- `FragmentHelperBinding inflate(LayoutInflater layoutInflater)`  L39
- `FragmentHelperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L43
- `FragmentHelperBinding bind(View view)`  L51
### `com.tuwinsmart.tuwin.databinding.FragmentLocalDownloadListBinding`
L14 · [class] public final FragmentLocalDownloadListBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentLocalDownloadListBinding.java`

字段/常量（7）：
- `LinearLayout btnDelete`  L15
- `LinearLayout btnDownload`  L16
- `LinearLayout llBottomActions`  L17
- `RecyclerView recyclerView`  L18
- `SwipeRefreshLayout refreshLayout`  L19
- `LinearLayout rootView`  L20
- `int i = C1870R.id.btn_delete`  L49

方法（5）：
- `private FragmentLocalDownloadListBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout)`  L22
- `LinearLayout getRoot()`  L32 @Override
- `FragmentLocalDownloadListBinding inflate(LayoutInflater layoutInflater)`  L36
- `FragmentLocalDownloadListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L40
- `FragmentLocalDownloadListBinding bind(View view)`  L48
### `com.tuwinsmart.tuwin.databinding.FragmentM3StorageListBinding`
L14 · [class] public final FragmentM3StorageListBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentM3StorageListBinding.java`

字段/常量（4）：
- `RecyclerView recyclerView`  L15
- `ConstraintLayout rootView`  L16
- `TextView tvEmpty`  L17
- `int i = C1870R.id.recycler_view`  L43

方法（5）：
- `private FragmentM3StorageListBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `FragmentM3StorageListBinding inflate(LayoutInflater layoutInflater)`  L30
- `FragmentM3StorageListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `FragmentM3StorageListBinding bind(View view)`  L42
### `com.tuwinsmart.tuwin.databinding.FragmentNormalPhotoModeBinding`
L14 · [class] public final FragmentNormalPhotoModeBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentNormalPhotoModeBinding.java`

字段/常量（5）：
- `View btnPhoto`  L15
- `LinearLayout llPhotoStatus`  L16
- `ConstraintLayout rootView`  L17
- `TextView tvPhotoStatus`  L18
- `int i = C1870R.id.btnPhoto`  L45

方法（5）：
- `private FragmentNormalPhotoModeBinding(ConstraintLayout constraintLayout, View view, LinearLayout linearLayout, TextView textView)`  L20
- `ConstraintLayout getRoot()`  L28 @Override
- `FragmentNormalPhotoModeBinding inflate(LayoutInflater layoutInflater)`  L32
- `FragmentNormalPhotoModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L36
- `FragmentNormalPhotoModeBinding bind(View view)`  L44
### `com.tuwinsmart.tuwin.databinding.FragmentNormalRecordModeBinding`
L14 · [class] public final FragmentNormalRecordModeBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentNormalRecordModeBinding.java`

字段/常量（7）：
- `View btnRecord`  L15
- `View ivRecordingIndicator`  L16
- `LinearLayout llRecordingStatus`  L17
- `ConstraintLayout rootView`  L18
- `TextView tvRecordingStatus`  L19
- `View viewFindChildViewById`  L47
- `int i = C1870R.id.btnRecord`  L48

方法（5）：
- `private FragmentNormalRecordModeBinding(ConstraintLayout constraintLayout, View view, View view2, LinearLayout linearLayout, TextView textView)`  L21
- `ConstraintLayout getRoot()`  L30 @Override
- `FragmentNormalRecordModeBinding inflate(LayoutInflater layoutInflater)`  L34
- `FragmentNormalRecordModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L38
- `FragmentNormalRecordModeBinding bind(View view)`  L46
### `com.tuwinsmart.tuwin.databinding.FragmentRide3proIndexedStorageBinding`
L19 · [class] public final FragmentRide3proIndexedStorageBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentRide3proIndexedStorageBinding.java`

字段/常量（10）：
- `Button btnRetry`  L20
- `LinearLayout errorContainer`  L21
- `Ride3ProLoadingCardView hourFileLoadingCard`  L22
- `ProgressBar progressBar`  L23
- `RecyclerView recyclerView`  L24
- `SwipeRefreshLayout refreshLayout`  L25
- `ConstraintLayout rootView`  L26
- `TextView tvEmpty`  L27
- `TextView tvError`  L28
- `int i = C1870R.id.btn_retry`  L60

方法（5）：
- `private FragmentRide3proIndexedStorageBinding(ConstraintLayout constraintLayout, Button button, LinearLayout linearLayout, Ride3ProLoadingCardView ride3ProLoadingCardView, ProgressBar progressBar, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TextView textView, TextView textView2)`  L30
- `ConstraintLayout getRoot()`  L43 @Override
- `FragmentRide3proIndexedStorageBinding inflate(LayoutInflater layoutInflater)`  L47
- `FragmentRide3proIndexedStorageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L51
- `FragmentRide3proIndexedStorageBinding bind(View view)`  L59
### `com.tuwinsmart.tuwin.databinding.FragmentRide3proStorageListBinding`
L16 · [class] public final FragmentRide3proStorageListBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentRide3proStorageListBinding.java`

字段/常量（7）：
- `FrameLayout loadMoreHintContainer`  L17
- `ProgressBar progressBar`  L18
- `RecyclerView recyclerView`  L19
- `ConstraintLayout rootView`  L20
- `TextView tvEmpty`  L21
- `TextView tvLoadMoreHint`  L22
- `int i = C1870R.id.load_more_hint_container`  L51

方法（5）：
- `private FragmentRide3proStorageListBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, TextView textView2)`  L24
- `ConstraintLayout getRoot()`  L34 @Override
- `FragmentRide3proStorageListBinding inflate(LayoutInflater layoutInflater)`  L38
- `FragmentRide3proStorageListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L42
- `FragmentRide3proStorageListBinding bind(View view)`  L50
### `com.tuwinsmart.tuwin.databinding.FragmentStorageListBinding`
L16 · [class] public final FragmentStorageListBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentStorageListBinding.java`

字段/常量（8）：
- `LinearLayout btnDelete`  L17
- `LinearLayout btnDownload`  L18
- `Ride5LoadingCardView hourFileLoadingCard`  L19
- `LinearLayout llBottomActions`  L20
- `RecyclerView recyclerView`  L21
- `SwipeRefreshLayout refreshLayout`  L22
- `FrameLayout rootView`  L23
- `int i = C1870R.id.btn_delete`  L53

方法（5）：
- `private FragmentStorageListBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, Ride5LoadingCardView ride5LoadingCardView, LinearLayout linearLayout3, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout)`  L25
- `FrameLayout getRoot()`  L36 @Override
- `FragmentStorageListBinding inflate(LayoutInflater layoutInflater)`  L40
- `FragmentStorageListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L44
- `FragmentStorageListBinding bind(View view)`  L52
### `com.tuwinsmart.tuwin.databinding.FragmentStorageLocalBinding`
L14 · [class] public final FragmentStorageLocalBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentStorageLocalBinding.java`

字段/常量（6）：
- `ItemStorageListDownloadBinding downloadHead`  L15
- `CoordinatorLayout rootView`  L16
- `SlidingTabLayout tabLayout`  L17
- `SwipeViewPager viewPager`  L18
- `int i = C1870R.id.download_head`  L45
- `int i2 = C1870R.id.tab_layout`  L49

方法（5）：
- `private FragmentStorageLocalBinding(CoordinatorLayout coordinatorLayout, ItemStorageListDownloadBinding itemStorageListDownloadBinding, SlidingTabLayout slidingTabLayout, SwipeViewPager swipeViewPager)`  L20
- `CoordinatorLayout getRoot()`  L28 @Override
- `FragmentStorageLocalBinding inflate(LayoutInflater layoutInflater)`  L32
- `FragmentStorageLocalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L36
- `FragmentStorageLocalBinding bind(View view)`  L44
### `com.tuwinsmart.tuwin.databinding.FragmentTimelapsePhotoModeBinding`
L15 · [class] public final FragmentTimelapsePhotoModeBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/FragmentTimelapsePhotoModeBinding.java`

字段/常量（6）：
- `View btnTimelapsePhoto`  L16
- `LinearLayout llPhotoStatus`  L17
- `ConstraintLayout rootView`  L18
- `TextView tvPhotoStatus`  L19
- `StrokeTextView tvTimelapseCountdown`  L20
- `int i = C1870R.id.btnTimelapsePhoto`  L48

方法（5）：
- `private FragmentTimelapsePhotoModeBinding(ConstraintLayout constraintLayout, View view, LinearLayout linearLayout, TextView textView, StrokeTextView strokeTextView)`  L22
- `ConstraintLayout getRoot()`  L31 @Override
- `FragmentTimelapsePhotoModeBinding inflate(LayoutInflater layoutInflater)`  L35
- `FragmentTimelapsePhotoModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L39
- `FragmentTimelapsePhotoModeBinding bind(View view)`  L47
### `com.tuwinsmart.tuwin.databinding.ItemBannerPageBinding`
L13 · [class] public final ItemBannerPageBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemBannerPageBinding.java`

字段/常量（3）：
- `RoundImageView ivBanner`  L14
- `FrameLayout rootView`  L15
- `int i = C1870R.id.iv_banner`  L40

方法（5）：
- `private ItemBannerPageBinding(FrameLayout frameLayout, RoundImageView roundImageView)`  L17
- `FrameLayout getRoot()`  L23 @Override
- `ItemBannerPageBinding inflate(LayoutInflater layoutInflater)`  L27
- `ItemBannerPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L31
- `ItemBannerPageBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.ItemDailyVideoItemBinding`
L16 · [class] public final ItemDailyVideoItemBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemDailyVideoItemBinding.java`

字段/常量（7）：
- `BLImageView ckSelect`  L17
- `BLView ivSelect`  L18
- `RoundImageView ivVideo`  L19
- `ConstraintLayout rootView`  L20
- `TextView tvHourTime`  L21
- `TextView tvVideoDuration`  L22
- `int i = C1870R.id.ck_select`  L51

方法（5）：
- `private ItemDailyVideoItemBinding(ConstraintLayout constraintLayout, BLImageView bLImageView, BLView bLView, RoundImageView roundImageView, TextView textView, TextView textView2)`  L24
- `ConstraintLayout getRoot()`  L34 @Override
- `ItemDailyVideoItemBinding inflate(LayoutInflater layoutInflater)`  L38
- `ItemDailyVideoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L42
- `ItemDailyVideoItemBinding bind(View view)`  L50
### `com.tuwinsmart.tuwin.databinding.ItemDateHeaderBinding`
L14 · [class] public final ItemDateHeaderBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemDateHeaderBinding.java`

字段/常量（4）：
- `BLTextView btnSelectAll`  L15
- `FrameLayout rootView`  L16
- `TextView tvDateTitle`  L17
- `int i = C1870R.id.btn_select_all`  L43

方法（5）：
- `private ItemDateHeaderBinding(FrameLayout frameLayout, BLTextView bLTextView, TextView textView)`  L19
- `FrameLayout getRoot()`  L26 @Override
- `ItemDateHeaderBinding inflate(LayoutInflater layoutInflater)`  L30
- `ItemDateHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `ItemDateHeaderBinding bind(View view)`  L42
### `com.tuwinsmart.tuwin.databinding.ItemDeviceEntryBinding`
L14 · [class] public final ItemDeviceEntryBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemDeviceEntryBinding.java`

字段/常量（5）：
- `ImageView ivArrow`  L15
- `ImageView ivDeviceIcon`  L16
- `BLLinearLayout rootView`  L17
- `TextView tvDeviceName`  L18
- `int i = C1870R.id.iv_arrow`  L45

方法（5）：
- `private ItemDeviceEntryBinding(BLLinearLayout bLLinearLayout, ImageView imageView, ImageView imageView2, TextView textView)`  L20
- `BLLinearLayout getRoot()`  L28 @Override
- `ItemDeviceEntryBinding inflate(LayoutInflater layoutInflater)`  L32
- `ItemDeviceEntryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L36
- `ItemDeviceEntryBinding bind(View view)`  L44
### `com.tuwinsmart.tuwin.databinding.ItemDeviceWifiBinding`
L15 · [class] public final ItemDeviceWifiBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemDeviceWifiBinding.java`

字段/常量（7）：
- `BLTextView btnDeviceWifiConnect`  L16
- `ImageView ivDeviceWifiIcon`  L17
- `BLConstraintLayout rootView`  L18
- `TextView tvDeviceWifiSsid`  L19
- `View viewDeviceWifiOnline`  L20
- `View viewFindChildViewById`  L48
- `int i = C1870R.id.btn_device_wifi_connect`  L49

方法（5）：
- `private ItemDeviceWifiBinding(BLConstraintLayout bLConstraintLayout, BLTextView bLTextView, ImageView imageView, TextView textView, View view)`  L22
- `BLConstraintLayout getRoot()`  L31 @Override
- `ItemDeviceWifiBinding inflate(LayoutInflater layoutInflater)`  L35
- `ItemDeviceWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L39
- `ItemDeviceWifiBinding bind(View view)`  L47
### `com.tuwinsmart.tuwin.databinding.ItemDownloadListItemBinding`
L17 · [class] public final ItemDownloadListItemBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemDownloadListItemBinding.java`

字段/常量（11）：
- `ImageView btnCancelDownload`  L18
- `FrameLayout clSeek`  L19
- `RoundImageView ivVideo`  L20
- `ConstraintLayout rootView`  L21
- `TextView tvRedownload`  L22
- `TextView tvVideoDate`  L23
- `TextView tvVideoSpeed`  L24
- `TextView tvVideoState`  L25
- `BLView viewSeekBg`  L26
- `BLView viewSeekStep`  L27
- `int i = C1870R.id.btn_cancel_download`  L60

方法（5）：
- `private ItemDownloadListItemBinding(ConstraintLayout constraintLayout, ImageView imageView, FrameLayout frameLayout, RoundImageView roundImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, BLView bLView, BLView bLView2)`  L29
- `ConstraintLayout getRoot()`  L43 @Override
- `ItemDownloadListItemBinding inflate(LayoutInflater layoutInflater)`  L47
- `ItemDownloadListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L51
- `ItemDownloadListItemBinding bind(View view)`  L59
### `com.tuwinsmart.tuwin.databinding.ItemDownloadListTitleBinding`
L13 · [class] public final ItemDownloadListTitleBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemDownloadListTitleBinding.java`

字段/常量（5）：
- `TextView btnRetryAll`  L14
- `TextView btnSelectAll`  L15
- `FrameLayout rootView`  L16
- `TextView tvDateTitle`  L17
- `int i = C1870R.id.btn_retry_all`  L44

方法（5）：
- `private ItemDownloadListTitleBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3)`  L19
- `FrameLayout getRoot()`  L27 @Override
- `ItemDownloadListTitleBinding inflate(LayoutInflater layoutInflater)`  L31
- `ItemDownloadListTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L35
- `ItemDownloadListTitleBinding bind(View view)`  L43
### `com.tuwinsmart.tuwin.databinding.ItemDownloadListVideoDateTitleBinding`
L14 · [class] public final ItemDownloadListVideoDateTitleBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemDownloadListVideoDateTitleBinding.java`

字段/常量（4）：
- `BLTextView btnSelectAll`  L15
- `FrameLayout rootView`  L16
- `TextView tvDateTitle`  L17
- `int i = C1870R.id.btn_select_all`  L43

方法（5）：
- `private ItemDownloadListVideoDateTitleBinding(FrameLayout frameLayout, BLTextView bLTextView, TextView textView)`  L19
- `FrameLayout getRoot()`  L26 @Override
- `ItemDownloadListVideoDateTitleBinding inflate(LayoutInflater layoutInflater)`  L30
- `ItemDownloadListVideoDateTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `ItemDownloadListVideoDateTitleBinding bind(View view)`  L42
### `com.tuwinsmart.tuwin.databinding.ItemDownloadListVideoItemBinding`
L15 · [class] public final ItemDownloadListVideoItemBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemDownloadListVideoItemBinding.java`

字段/常量（6）：
- `BLImageView ckSelect`  L16
- `ImageView ivMediaType`  L17
- `ImageView ivVideo`  L18
- `ConstraintLayout rootView`  L19
- `TextView tvHourTime`  L20
- `int i = C1870R.id.ck_select`  L48

方法（5）：
- `private ItemDownloadListVideoItemBinding(ConstraintLayout constraintLayout, BLImageView bLImageView, ImageView imageView, ImageView imageView2, TextView textView)`  L22
- `ConstraintLayout getRoot()`  L31 @Override
- `ItemDownloadListVideoItemBinding inflate(LayoutInflater layoutInflater)`  L35
- `ItemDownloadListVideoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L39
- `ItemDownloadListVideoItemBinding bind(View view)`  L47
### `com.tuwinsmart.tuwin.databinding.ItemHomeListAddDeviceBinding`
L11 · [class] public final ItemHomeListAddDeviceBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemHomeListAddDeviceBinding.java`

字段/常量（2）：
- `BLFrameLayout flEmptyDevice`  L12
- `BLFrameLayout rootView`  L13

方法（6）：
- `private ItemHomeListAddDeviceBinding(BLFrameLayout bLFrameLayout, BLFrameLayout bLFrameLayout2)`  L15
- `BLFrameLayout getRoot()`  L21 @Override
- `ItemHomeListAddDeviceBinding inflate(LayoutInflater layoutInflater)`  L25
- `ItemHomeListAddDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L29
- `ItemHomeListAddDeviceBinding bind(View view)`  L37
- `throw new NullPointerException( 0 )`  L39
### `com.tuwinsmart.tuwin.databinding.ItemHomeListBrandBinding`
L15 · [class] public final ItemHomeListBrandBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemHomeListBrandBinding.java`

字段/常量（5）：
- `CardView cardBanner`  L16
- `RoundImageView ivPlaceholder`  L17
- `ConstraintLayout rootView`  L18
- `ViewPager2 viewPagerBanner`  L19
- `int i = C1870R.id.card_banner`  L46

方法（5）：
- `private ItemHomeListBrandBinding(ConstraintLayout constraintLayout, CardView cardView, RoundImageView roundImageView, ViewPager2 viewPager2)`  L21
- `ConstraintLayout getRoot()`  L29 @Override
- `ItemHomeListBrandBinding inflate(LayoutInflater layoutInflater)`  L33
- `ItemHomeListBrandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L37
- `ItemHomeListBrandBinding bind(View view)`  L45
### `com.tuwinsmart.tuwin.databinding.ItemHomeListDeviceBinding`
L18 · [class] public final ItemHomeListDeviceBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemHomeListDeviceBinding.java`

字段/常量（15）：
- `BLImageView btnActionPause`  L19
- `TextView btnDelete`  L20
- `TextView btnDeviceDetail`  L21
- `TextView btnLostConnection`  L22
- `ImageView btnPlay`  L23
- `ConstraintLayout clPlayActions`  L24
- `FrameLayout flVideoContainer`  L25
- `ImageView ivDeviceIcon`  L26
- `ImageView ivVideoPlaceholder`  L27
- `ProgressBar pbVideoLoading`  L28
- `ConstraintLayout rootView`  L29
- `TextView tvDeviceName`  L30
- `AppCompatTextView tvDeviceSsid`  L31
- `TextView tvRemarkName`  L32
- `int i = C1870R.id.btn_action_pause`  L69

方法（5）：
- `private ItemHomeListDeviceBinding(ConstraintLayout constraintLayout, BLImageView bLImageView, TextView textView, TextView textView2, TextView textView3, ImageView imageView, ConstraintLayout constraintLayout2, FrameLayout frameLayout, ImageView imageView2, ImageView imageView3, ProgressBar progressBar, TextView textView4, AppCompatTextView appCompatTextView, TextView textView5)`  L34
- `ConstraintLayout getRoot()`  L52 @Override
- `ItemHomeListDeviceBinding inflate(LayoutInflater layoutInflater)`  L56
- `ItemHomeListDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L60
- `ItemHomeListDeviceBinding bind(View view)`  L68
### `com.tuwinsmart.tuwin.databinding.ItemHomeListServiceCardBinding`
L14 · [class] public final ItemHomeListServiceCardBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemHomeListServiceCardBinding.java`

字段/常量（6）：
- `TextView btnConsult`  L15
- `ImageView ivIcon`  L16
- `CardView rootView`  L17
- `TextView tvSubtitle`  L18
- `TextView tvTitle`  L19
- `int i = C1870R.id.btn_consult`  L47

方法（5）：
- `private ItemHomeListServiceCardBinding(CardView cardView, TextView textView, ImageView imageView, TextView textView2, TextView textView3)`  L21
- `CardView getRoot()`  L30 @Override
- `ItemHomeListServiceCardBinding inflate(LayoutInflater layoutInflater)`  L34
- `ItemHomeListServiceCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L38
- `ItemHomeListServiceCardBinding bind(View view)`  L46
### `com.tuwinsmart.tuwin.databinding.ItemHomeListWeatherBinding`
L15 · [class] public final ItemHomeListWeatherBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemHomeListWeatherBinding.java`

字段/常量（8）：
- `ConstraintLayout bgWeatherCard`  L16
- `ProgressBar loading`  L17
- `ConstraintLayout rootView`  L18
- `TextView tvDate`  L19
- `TextView tvLocation`  L20
- `TextView tvNoLocation`  L21
- `ExcludeFontPaddingTextView tvTempure`  L22
- `int i = C1870R.id.loading`  L53

方法（5）：
- `private ItemHomeListWeatherBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, ExcludeFontPaddingTextView excludeFontPaddingTextView)`  L24
- `ConstraintLayout getRoot()`  L35 @Override
- `ItemHomeListWeatherBinding inflate(LayoutInflater layoutInflater)`  L39
- `ItemHomeListWeatherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L43
- `ItemHomeListWeatherBinding bind(View view)`  L51
### `com.tuwinsmart.tuwin.databinding.ItemM3ModeOptionBinding`
L14 · [class] public final ItemM3ModeOptionBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemM3ModeOptionBinding.java`

字段/常量（4）：
- `ImageView ivModeIcon`  L15
- `LinearLayout rootView`  L16
- `TextView tvModeName`  L17
- `int i = C1870R.id.ivModeIcon`  L43

方法（5）：
- `private ItemM3ModeOptionBinding(LinearLayout linearLayout, ImageView imageView, TextView textView)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `ItemM3ModeOptionBinding inflate(LayoutInflater layoutInflater)`  L30
- `ItemM3ModeOptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `ItemM3ModeOptionBinding bind(View view)`  L42
### `com.tuwinsmart.tuwin.databinding.ItemM3SettingBinding`
L15 · [class] public final ItemM3SettingBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemM3SettingBinding.java`

字段/常量（6）：
- `ImageView ivArrow`  L16
- `LinearLayout rootView`  L17
- `Switch switchSetting`  L18
- `TextView tvSettingName`  L19
- `TextView tvSettingValue`  L20
- `int i = C1870R.id.iv_arrow`  L48

方法（5）：
- `private ItemM3SettingBinding(LinearLayout linearLayout, ImageView imageView, Switch r3, TextView textView, TextView textView2)`  L22
- `LinearLayout getRoot()`  L31 @Override
- `ItemM3SettingBinding inflate(LayoutInflater layoutInflater)`  L35
- `ItemM3SettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L39
- `ItemM3SettingBinding bind(View view)`  L47
### `com.tuwinsmart.tuwin.databinding.ItemM3StorageFileBinding`
L15 · [class] public final ItemM3StorageFileBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemM3StorageFileBinding.java`

字段/常量（6）：
- `BLImageView checkbox`  L16
- `ImageView ivFileType`  L17
- `ImageView ivThumbnail`  L18
- `FrameLayout rootView`  L19
- `TextView tvTime`  L20
- `int i = C1870R.id.checkbox`  L48

方法（5）：
- `private ItemM3StorageFileBinding(FrameLayout frameLayout, BLImageView bLImageView, ImageView imageView, ImageView imageView2, TextView textView)`  L22
- `FrameLayout getRoot()`  L31 @Override
- `ItemM3StorageFileBinding inflate(LayoutInflater layoutInflater)`  L35
- `ItemM3StorageFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L39
- `ItemM3StorageFileBinding bind(View view)`  L47
### `com.tuwinsmart.tuwin.databinding.ItemPhotoViewWithLoadingBinding`
L14 · [class] public final ItemPhotoViewWithLoadingBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemPhotoViewWithLoadingBinding.java`

字段/常量（4）：
- `PhotoView photoView`  L15
- `ProgressBar progressBar`  L16
- `FrameLayout rootView`  L17
- `int i = C1870R.id.photo_view`  L43

方法（5）：
- `private ItemPhotoViewWithLoadingBinding(FrameLayout frameLayout, PhotoView photoView, ProgressBar progressBar)`  L19
- `FrameLayout getRoot()`  L26 @Override
- `ItemPhotoViewWithLoadingBinding inflate(LayoutInflater layoutInflater)`  L30
- `ItemPhotoViewWithLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `ItemPhotoViewWithLoadingBinding bind(View view)`  L42
### `com.tuwinsmart.tuwin.databinding.ItemRide3proHourRecordingBinding`
L14 · [class] public final ItemRide3proHourRecordingBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemRide3proHourRecordingBinding.java`

字段/常量（6）：
- `FrameLayout cardVideo`  L15
- `ImageView ivThumbnail`  L16
- `FrameLayout rootView`  L17
- `TextView tvVideoDuration`  L18
- `TextView tvVideoTime`  L19
- `int i = C1870R.id.iv_thumbnail`  L48

方法（5）：
- `private ItemRide3proHourRecordingBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, TextView textView, TextView textView2)`  L21
- `FrameLayout getRoot()`  L30 @Override
- `ItemRide3proHourRecordingBinding inflate(LayoutInflater layoutInflater)`  L34
- `ItemRide3proHourRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L38
- `ItemRide3proHourRecordingBinding bind(View view)`  L46
### `com.tuwinsmart.tuwin.databinding.ItemRide3proSelectedVideoBinding`
L16 · [class] public final ItemRide3proSelectedVideoBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemRide3proSelectedVideoBinding.java`

字段/常量（13）：
- `AppCompatTextView btnPlayVideo`  L17
- `ConstraintLayout cardSelectedVideo`  L18
- `ImageView ivThumbnail`  L19
- `FrameLayout rootView`  L20
- `View selectedVideoGlow`  L21
- `FrameLayout selectedVideoItemRoot`  L22
- `FrameLayout thumbnailContainer`  L23
- `AppCompatTextView tvCreateTime`  L24
- `AppCompatTextView tvDuration`  L25
- `TextView tvFileName`  L26
- `TextView tvVideoTime`  L27
- `View viewFindChildViewById`  L61
- `int i = C1870R.id.btn_play_video`  L62

方法（5）：
- `private ItemRide3proSelectedVideoBinding(FrameLayout frameLayout, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, ImageView imageView, View view, FrameLayout frameLayout2, FrameLayout frameLayout3, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, TextView textView, TextView textView2)`  L29
- `FrameLayout getRoot()`  L44 @Override
- `ItemRide3proSelectedVideoBinding inflate(LayoutInflater layoutInflater)`  L48
- `ItemRide3proSelectedVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L52
- `ItemRide3proSelectedVideoBinding bind(View view)`  L60
### `com.tuwinsmart.tuwin.databinding.ItemRide3ProSettingsItemBinding`
L13 · [class] public final ItemRide3ProSettingsItemBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemRide3ProSettingsItemBinding.java`

字段/常量（4）：
- `LinearLayout rootView`  L14
- `TextView tvSettingMeta`  L15
- `TextView tvSettingName`  L16
- `int i = C1870R.id.tv_setting_meta`  L42

方法（5）：
- `private ItemRide3ProSettingsItemBinding(LinearLayout linearLayout, TextView textView, TextView textView2)`  L18
- `LinearLayout getRoot()`  L25 @Override
- `ItemRide3ProSettingsItemBinding inflate(LayoutInflater layoutInflater)`  L29
- `ItemRide3ProSettingsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L33
- `ItemRide3ProSettingsItemBinding bind(View view)`  L41
### `com.tuwinsmart.tuwin.databinding.ItemRide5HourRecordingBinding`
L14 · [class] public final ItemRide5HourRecordingBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemRide5HourRecordingBinding.java`

字段/常量（6）：
- `FrameLayout cardVideo`  L15
- `ImageView ivThumbnail`  L16
- `FrameLayout rootView`  L17
- `TextView tvVideoDuration`  L18
- `TextView tvVideoTime`  L19
- `int i = C1870R.id.iv_thumbnail`  L48

方法（5）：
- `private ItemRide5HourRecordingBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, TextView textView, TextView textView2)`  L21
- `FrameLayout getRoot()`  L30 @Override
- `ItemRide5HourRecordingBinding inflate(LayoutInflater layoutInflater)`  L34
- `ItemRide5HourRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L38
- `ItemRide5HourRecordingBinding bind(View view)`  L46
### `com.tuwinsmart.tuwin.databinding.ItemRide5SelectedVideoBinding`
L16 · [class] public final ItemRide5SelectedVideoBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemRide5SelectedVideoBinding.java`

字段/常量（13）：
- `AppCompatTextView btnPlayVideo`  L17
- `ConstraintLayout cardSelectedVideo`  L18
- `ImageView ivThumbnail`  L19
- `FrameLayout rootView`  L20
- `View selectedVideoGlow`  L21
- `FrameLayout selectedVideoItemRoot`  L22
- `FrameLayout thumbnailContainer`  L23
- `AppCompatTextView tvCreateTime`  L24
- `AppCompatTextView tvDuration`  L25
- `TextView tvFileName`  L26
- `TextView tvVideoTime`  L27
- `View viewFindChildViewById`  L61
- `int i = C1870R.id.btn_play_video`  L62

方法（5）：
- `private ItemRide5SelectedVideoBinding(FrameLayout frameLayout, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, ImageView imageView, View view, FrameLayout frameLayout2, FrameLayout frameLayout3, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, TextView textView, TextView textView2)`  L29
- `FrameLayout getRoot()`  L44 @Override
- `ItemRide5SelectedVideoBinding inflate(LayoutInflater layoutInflater)`  L48
- `ItemRide5SelectedVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L52
- `ItemRide5SelectedVideoBinding bind(View view)`  L60
### `com.tuwinsmart.tuwin.databinding.ItemStorageListDownloadBinding`
L14 · [class] public final ItemStorageListDownloadBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemStorageListDownloadBinding.java`

字段/常量（6）：
- `BLConstraintLayout clRoot`  L15
- `ImageView ivArrow`  L16
- `BLConstraintLayout rootView`  L17
- `BLTextView tvDownloadStatus`  L18
- `BLTextView tvDownloadSubTitle`  L19
- `int i = C1870R.id.iv_arrow`  L48

方法（5）：
- `private ItemStorageListDownloadBinding(BLConstraintLayout bLConstraintLayout, BLConstraintLayout bLConstraintLayout2, ImageView imageView, BLTextView bLTextView, BLTextView bLTextView2)`  L21
- `BLConstraintLayout getRoot()`  L30 @Override
- `ItemStorageListDownloadBinding inflate(LayoutInflater layoutInflater)`  L34
- `ItemStorageListDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L38
- `ItemStorageListDownloadBinding bind(View view)`  L46
### `com.tuwinsmart.tuwin.databinding.ItemStorageListItemBinding`
L14 · [class] public final ItemStorageListItemBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemStorageListItemBinding.java`

字段/常量（5）：
- `BLImageView ckSelect`  L15
- `BLImageView ivVideo`  L16
- `ConstraintLayout rootView`  L17
- `TextView tvHourTime`  L18
- `int i = C1870R.id.ck_select`  L45

方法（5）：
- `private ItemStorageListItemBinding(ConstraintLayout constraintLayout, BLImageView bLImageView, BLImageView bLImageView2, TextView textView)`  L20
- `ConstraintLayout getRoot()`  L28 @Override
- `ItemStorageListItemBinding inflate(LayoutInflater layoutInflater)`  L32
- `ItemStorageListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L36
- `ItemStorageListItemBinding bind(View view)`  L44
### `com.tuwinsmart.tuwin.databinding.ItemStorageListSdcardBinding`
L14 · [class] public final ItemStorageListSdcardBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemStorageListSdcardBinding.java`

字段/常量（6）：
- `BLConstraintLayout rootView`  L15
- `TextView tvSdcardStatus`  L16
- `TextView tvSdcardUsage`  L17
- `BLView viewSeekBg`  L18
- `BLView viewSeekStep`  L19
- `int i = C1870R.id.tv_sdcard_status`  L47

方法（5）：
- `private ItemStorageListSdcardBinding(BLConstraintLayout bLConstraintLayout, TextView textView, TextView textView2, BLView bLView, BLView bLView2)`  L21
- `BLConstraintLayout getRoot()`  L30 @Override
- `ItemStorageListSdcardBinding inflate(LayoutInflater layoutInflater)`  L34
- `ItemStorageListSdcardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L38
- `ItemStorageListSdcardBinding bind(View view)`  L46
### `com.tuwinsmart.tuwin.databinding.ItemStorageListSectionBinding`
L14 · [class] public final ItemStorageListSectionBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemStorageListSectionBinding.java`

字段/常量（4）：
- `ImageView btnEdit`  L15
- `ConstraintLayout rootView`  L16
- `TextView tvSectionTitle`  L17
- `int i = C1870R.id.btn_edit`  L43

方法（5）：
- `private ItemStorageListSectionBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `ItemStorageListSectionBinding inflate(LayoutInflater layoutInflater)`  L30
- `ItemStorageListSectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `ItemStorageListSectionBinding bind(View view)`  L42
### `com.tuwinsmart.tuwin.databinding.ItemStorageListVideoDateTitleBinding`
L14 · [class] public final ItemStorageListVideoDateTitleBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemStorageListVideoDateTitleBinding.java`

字段/常量（4）：
- `BLTextView btnSelectAll`  L15
- `FrameLayout rootView`  L16
- `TextView tvDateTitle`  L17
- `int i = C1870R.id.btn_select_all`  L43

方法（5）：
- `private ItemStorageListVideoDateTitleBinding(FrameLayout frameLayout, BLTextView bLTextView, TextView textView)`  L19
- `FrameLayout getRoot()`  L26 @Override
- `ItemStorageListVideoDateTitleBinding inflate(LayoutInflater layoutInflater)`  L30
- `ItemStorageListVideoDateTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `ItemStorageListVideoDateTitleBinding bind(View view)`  L42
### `com.tuwinsmart.tuwin.databinding.ItemStorageListVideoItemBinding`
L16 · [class] public final ItemStorageListVideoItemBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ItemStorageListVideoItemBinding.java`

字段/常量（7）：
- `BLImageView ckSelect`  L17
- `ImageView ivFileCountIcon`  L18
- `RoundImageView ivVideo`  L19
- `ConstraintLayout rootView`  L20
- `TextView tvFileCount`  L21
- `TextView tvHourTime`  L22
- `int i = C1870R.id.ck_select`  L51

方法（5）：
- `private ItemStorageListVideoItemBinding(ConstraintLayout constraintLayout, BLImageView bLImageView, ImageView imageView, RoundImageView roundImageView, TextView textView, TextView textView2)`  L24
- `ConstraintLayout getRoot()`  L34 @Override
- `ItemStorageListVideoItemBinding inflate(LayoutInflater layoutInflater)`  L38
- `ItemStorageListVideoItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L42
- `ItemStorageListVideoItemBinding bind(View view)`  L50
### `com.tuwinsmart.tuwin.databinding.LayoutActionbarBinding`
L15 · [class] public final LayoutActionbarBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/LayoutActionbarBinding.java`

字段/常量（8）：
- `ImageView ibLeft`  L16
- `ImageView ibRight`  L17
- `ImageButton ibRightItem`  L18
- `ImageView ivLogo`  L19
- `BLLinearLayout llActionBar`  L20
- `BLLinearLayout rootView`  L21
- `TextView tvTitle`  L22
- `int i = C1870R.id.ib_left`  L52

方法（5）：
- `private LayoutActionbarBinding(BLLinearLayout bLLinearLayout, ImageView imageView, ImageView imageView2, ImageButton imageButton, ImageView imageView3, BLLinearLayout bLLinearLayout2, TextView textView)`  L24
- `BLLinearLayout getRoot()`  L35 @Override
- `LayoutActionbarBinding inflate(LayoutInflater layoutInflater)`  L39
- `LayoutActionbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L43
- `LayoutActionbarBinding bind(View view)`  L51
### `com.tuwinsmart.tuwin.databinding.LayoutBatteryBinding`
L15 · [class] public final LayoutBatteryBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/LayoutBatteryBinding.java`

字段/常量（10）：
- `BLView bgBattery`  L16
- `BLView bgFull`  L17
- `BLView bgHigh`  L18
- `BLView bgLine`  L19
- `BLView bgLow`  L20
- `BLView bgMiddle`  L21
- `ImageView ivCharge`  L22
- `LinearLayout rootView`  L23
- `TextView tvBattery`  L24
- `int i = C1870R.id.bg_battery`  L56

方法（5）：
- `private LayoutBatteryBinding(LinearLayout linearLayout, BLView bLView, BLView bLView2, BLView bLView3, BLView bLView4, BLView bLView5, BLView bLView6, ImageView imageView, TextView textView)`  L26
- `LinearLayout getRoot()`  L39 @Override
- `LayoutBatteryBinding inflate(LayoutInflater layoutInflater)`  L43
- `LayoutBatteryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L47
- `LayoutBatteryBinding bind(View view)`  L55
### `com.tuwinsmart.tuwin.databinding.LayoutToastBinding`
L13 · [class] public final LayoutToastBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/LayoutToastBinding.java`

字段/常量（3）：
- `FrameLayout rootView`  L14
- `BLTextView toastContentTV`  L15
- `int i = C1870R.id.toast_contentTV`  L40

方法（5）：
- `private LayoutToastBinding(FrameLayout frameLayout, BLTextView bLTextView)`  L17
- `FrameLayout getRoot()`  L23 @Override
- `LayoutToastBinding inflate(LayoutInflater layoutInflater)`  L27
- `LayoutToastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L31
- `LayoutToastBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.PlayListControlVideoBinding`
L19 · [class] public final PlayListControlVideoBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/PlayListControlVideoBinding.java`

字段/常量（25）：
- `ImageView back`  L20
- `ProgressBar bottomProgressbar`  L21
- `LinearLayout btnGsyChangeSpeed`  L22
- `TextView btnGsyDownload`  L23
- `ImageView btnGsyDownloadSmall`  L24
- `TextView btnGsyScreenshot`  L25
- `ImageView btnGsyScreenshotSmall`  L26
- `TextView current`  L27
- `ProgressBar gsyProgressBar`  L28
- `ImageView ivGsyCover`  L29
- `ImageView ivGsyFullscreen`  L30
- `ImageView ivGsyPlayButton`  L31
- `ImageView ivGsyVoice`  L32
- `LinearLayout layoutBottom`  L33
- `BLLinearLayout layoutGsyRight`  L34
- `LinearLayout layoutGsyRightSmall`  L35
- `BLLinearLayout layoutGsyTop`  L36
- `SeekBar progress`  L37
- `RelativeLayout rootView`  L38
- `FrameLayout surfaceContainer`  L39
- `TextView total`  L40
- `TextView tvGsyChangeSpeed`  L41
- `TextView tvGsyChangeSpeedSmall`  L42
- `TextView tvSeekPreview`  L43
- `int i = C1870R.id.back`  L90

方法（5）：
- `private PlayListControlVideoBinding(RelativeLayout relativeLayout, ImageView imageView, ProgressBar progressBar, LinearLayout linearLayout, TextView textView, ImageView imageView2, TextView textView2, ImageView imageView3, TextView textView3, ProgressBar progressBar2, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout2, BLLinearLayout bLLinearLayout, LinearLayout linearLayout3, BLLinearLayout bLLinearLayout2, SeekBar seekBar, FrameLayout frameLayout, TextView textView4, TextView textView5, TextView textView6, TextView textView7)`  L45
- `RelativeLayout getRoot()`  L73 @Override
- `PlayListControlVideoBinding inflate(LayoutInflater layoutInflater)`  L77
- `PlayListControlVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L81
- `PlayListControlVideoBinding bind(View view)`  L89
### `com.tuwinsmart.tuwin.databinding.ViewGlobalLoadingStatusBinding`
L14 · [class] public final ViewGlobalLoadingStatusBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ViewGlobalLoadingStatusBinding.java`

字段/常量（5）：
- `ImageView image`  L15
- `ProgressBar loading`  L16
- `View rootView`  L17
- `TextView text`  L18
- `int i = C1870R.id.image`  L41

方法（5）：
- `private ViewGlobalLoadingStatusBinding(View view, ImageView imageView, ProgressBar progressBar, TextView textView)`  L20
- `View getRoot()`  L28 @Override
- `ViewGlobalLoadingStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup)`  L32
- `throw new NullPointerException( 0 )`  L34
- `ViewGlobalLoadingStatusBinding bind(View view)`  L40
### `com.tuwinsmart.tuwin.databinding.ViewRecordingControlEventsBinding`
L15 · [class] public final ViewRecordingControlEventsBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ViewRecordingControlEventsBinding.java`

字段/常量（8）：
- `LinearLayout recordingEventsBody`  L16
- `TextView recordingEventsCount`  L17
- `LinearLayout recordingEventsHeader`  L18
- `RecyclerView recordingEventsList`  L19
- `TextView recordingEventsStatus`  L20
- `ImageView recordingEventsTriangle`  L21
- `View rootView`  L22
- `int i = C1870R.id.recording_events_body`  L48

方法（5）：
- `private ViewRecordingControlEventsBinding(View view, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView2, ImageView imageView)`  L24
- `View getRoot()`  L35 @Override
- `ViewRecordingControlEventsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup)`  L39
- `throw new NullPointerException( 0 )`  L41
- `ViewRecordingControlEventsBinding bind(View view)`  L47
### `com.tuwinsmart.tuwin.databinding.ViewRide3proHourPlaybackOverlayBinding`
L17 · [class] public final ViewRide3proHourPlaybackOverlayBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ViewRide3proHourPlaybackOverlayBinding.java`

字段/常量（15）：
- `TextView btnPlaybackDownload`  L18
- `ImageView btnPlaybackFullscreen`  L19
- `ImageView btnPlaybackPause`  L20
- `TextView btnPlaybackScreenshot`  L21
- `LinearLayout btnPlaybackSpeed`  L22
- `LinearLayout layoutPlaybackActions`  L23
- `LinearLayout layoutPlaybackControls`  L24
- `ProgressBar progressPlaybackPersistent`  L25
- `FrameLayout rootView`  L26
- `SeekBar seekPlaybackProgress`  L27
- `TextView tvPlaybackCurrent`  L28
- `TextView tvPlaybackGestureSeek`  L29
- `TextView tvPlaybackSpeed`  L30
- `TextView tvPlaybackTotal`  L31
- `int i = C1870R.id.btn_playback_download`  L68

方法（5）：
- `private ViewRide3proHourPlaybackOverlayBinding(FrameLayout frameLayout, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar, SeekBar seekBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6)`  L33
- `FrameLayout getRoot()`  L51 @Override
- `ViewRide3proHourPlaybackOverlayBinding inflate(LayoutInflater layoutInflater)`  L55
- `ViewRide3proHourPlaybackOverlayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L59
- `ViewRide3proHourPlaybackOverlayBinding bind(View view)`  L67
### `com.tuwinsmart.tuwin.databinding.ViewRide3proLoadingCardBinding`
L13 · [class] public final ViewRide3proLoadingCardBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ViewRide3proLoadingCardBinding.java`

字段/常量（5）：
- `TextView loadingCardMessage`  L14
- `ProgressBar loadingCardSpinner`  L15
- `TextView loadingCardTitle`  L16
- `View rootView`  L17
- `int i = C1870R.id.loading_card_message`  L40

方法（5）：
- `private ViewRide3proLoadingCardBinding(View view, TextView textView, ProgressBar progressBar, TextView textView2)`  L19
- `View getRoot()`  L27 @Override
- `ViewRide3proLoadingCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup)`  L31
- `throw new NullPointerException( 0 )`  L33
- `ViewRide3proLoadingCardBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.ViewRide3proPlaybackOverlayBinding`
L16 · [class] public final ViewRide3proPlaybackOverlayBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ViewRide3proPlaybackOverlayBinding.java`

字段/常量（13）：
- `TextView btnPlaybackDownload`  L17
- `ImageView btnPlaybackFullscreen`  L18
- `ImageView btnPlaybackPause`  L19
- `TextView btnPlaybackScreenshot`  L20
- `LinearLayout btnPlaybackSpeed`  L21
- `LinearLayout layoutPlaybackActions`  L22
- `LinearLayout layoutPlaybackControls`  L23
- `FrameLayout rootView`  L24
- `SeekBar seekPlaybackProgress`  L25
- `TextView tvPlaybackCurrent`  L26
- `TextView tvPlaybackSpeed`  L27
- `TextView tvPlaybackTotal`  L28
- `int i = C1870R.id.btn_playback_download`  L63

方法（5）：
- `private ViewRide3proPlaybackOverlayBinding(FrameLayout frameLayout, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, SeekBar seekBar, TextView textView3, TextView textView4, TextView textView5)`  L30
- `FrameLayout getRoot()`  L46 @Override
- `ViewRide3proPlaybackOverlayBinding inflate(LayoutInflater layoutInflater)`  L50
- `ViewRide3proPlaybackOverlayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L54
- `ViewRide3proPlaybackOverlayBinding bind(View view)`  L62
### `com.tuwinsmart.tuwin.databinding.ViewRide5HourPlaybackOverlayBinding`
L17 · [class] public final ViewRide5HourPlaybackOverlayBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ViewRide5HourPlaybackOverlayBinding.java`

字段/常量（16）：
- `TextView btnPlaybackDownload`  L18
- `ImageView btnPlaybackFullscreen`  L19
- `ImageView btnPlaybackPause`  L20
- `TextView btnPlaybackScreenshot`  L21
- `LinearLayout btnPlaybackSpeed`  L22
- `LinearLayout layoutPlaybackActions`  L23
- `LinearLayout layoutPlaybackControls`  L24
- `ProgressBar progressPlaybackPersistent`  L25
- `ProgressBar progressPlaybackSeekLoading`  L26
- `FrameLayout rootView`  L27
- `SeekBar seekPlaybackProgress`  L28
- `TextView tvPlaybackCurrent`  L29
- `TextView tvPlaybackGestureSeek`  L30
- `TextView tvPlaybackSpeed`  L31
- `TextView tvPlaybackTotal`  L32
- `int i = C1870R.id.btn_playback_download`  L70

方法（5）：
- `private ViewRide5HourPlaybackOverlayBinding(FrameLayout frameLayout, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar, ProgressBar progressBar2, SeekBar seekBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6)`  L34
- `FrameLayout getRoot()`  L53 @Override
- `ViewRide5HourPlaybackOverlayBinding inflate(LayoutInflater layoutInflater)`  L57
- `ViewRide5HourPlaybackOverlayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L61
- `ViewRide5HourPlaybackOverlayBinding bind(View view)`  L69
### `com.tuwinsmart.tuwin.databinding.ViewRide5LoadingCardBinding`
L13 · [class] public final ViewRide5LoadingCardBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ViewRide5LoadingCardBinding.java`

字段/常量（5）：
- `TextView loadingCardMessage`  L14
- `ProgressBar loadingCardSpinner`  L15
- `TextView loadingCardTitle`  L16
- `View rootView`  L17
- `int i = C1870R.id.loading_card_message`  L40

方法（5）：
- `private ViewRide5LoadingCardBinding(View view, TextView textView, ProgressBar progressBar, TextView textView2)`  L19
- `View getRoot()`  L27 @Override
- `ViewRide5LoadingCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup)`  L31
- `throw new NullPointerException( 0 )`  L33
- `ViewRide5LoadingCardBinding bind(View view)`  L39
### `com.tuwinsmart.tuwin.databinding.ViewstubPermissionLayoutBinding`
L14 · [class] public final ViewstubPermissionLayoutBinding · implements `ViewBinding` · `com/tuwinsmart/tuwin/databinding/ViewstubPermissionLayoutBinding.java`

字段/常量（4）：
- `ImageView ivIcon`  L15
- `ConstraintLayout rootView`  L16
- `TextView tvTip`  L17
- `int i = C1870R.id.iv_icon`  L43

方法（5）：
- `private ViewstubPermissionLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `ViewstubPermissionLayoutBinding inflate(LayoutInflater layoutInflater)`  L30
- `ViewstubPermissionLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z)`  L34
- `ViewstubPermissionLayoutBinding bind(View view)`  L42