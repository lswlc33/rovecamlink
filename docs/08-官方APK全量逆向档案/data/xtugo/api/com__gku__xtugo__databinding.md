# XTU GO — 类与成员明细：com.gku.xtugo.databinding

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 295 个文件 / 295 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.xtugo.databinding.ActivityAboutCameraBinding`
L14 · [class] public final ActivityAboutCameraBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAboutCameraBinding.java`

字段/常量（13）：
- `TextView aboutCameraName`  L15
- `ImageView logoIconCamera`  L16
- `ImageView logoMainCamera`  L17
- `LinearLayout rootView`  L18
- `TextView textAppVer`  L19
- `TextView textBuildDate`  L20
- `TextView textDeviceChip`  L21
- `TextView textDeviceOS`  L22
- `TextView textDeviceSensor`  L23
- `TextView textFirmwareVersion`  L24
- `TextView textHardwareFeature`  L25
- `TextView textUpgradeFirmware`  L26
- `int i = R.id.about_camera_name`  L61

方法（5）：
- `private ActivityAboutCameraBinding(LinearLayout rootView, TextView aboutCameraName, ImageView logoIconCamera, ImageView logoMainCamera, TextView textAppVer, TextView textBuildDate, TextView textDeviceChip, TextView textDeviceOS, TextView textDeviceSensor, TextView textFirmwareVersion, TextView textHardwareFeature, TextView textUpgradeFirmware)`  L28
- `LinearLayout getRoot()`  L44 @Override
- `ActivityAboutCameraBinding inflate(LayoutInflater inflater)`  L48
- `ActivityAboutCameraBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L52
- `ActivityAboutCameraBinding bind(View rootView)`  L60
### `com.gku.xtugo.databinding.ActivityAboutClientBinding`
L15 · [class] public final ActivityAboutClientBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAboutClientBinding.java`

字段/常量（14）：
- `ImageView backReturn`  L16
- `RelativeLayout checkUpdate`  L17
- `TextView clientName`  L18
- `RelativeLayout contactUs`  L19
- `ImageView itemNext`  L20
- `ImageView logoIconClient`  L21
- `ImageView logoMainClient`  L22
- `LinearLayout rootView`  L23
- `TextView textBuildDate`  L24
- `TextView textCheckUpdate`  L25
- `TextView textClientVersion`  L26
- `TextView textICP`  L27
- `LinearLayout visitCustomerService`  L28
- `int i = R.id.backReturn`  L64

方法（5）：
- `private ActivityAboutClientBinding(LinearLayout rootView, ImageView backReturn, RelativeLayout checkUpdate, TextView clientName, RelativeLayout contactUs, ImageView itemNext, ImageView logoIconClient, ImageView logoMainClient, TextView textBuildDate, TextView textCheckUpdate, TextView textClientVersion, TextView textICP, LinearLayout visitCustomerService)`  L30
- `LinearLayout getRoot()`  L47 @Override
- `ActivityAboutClientBinding inflate(LayoutInflater inflater)`  L51
- `ActivityAboutClientBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L55
- `ActivityAboutClientBinding bind(View rootView)`  L63
### `com.gku.xtugo.databinding.ActivityAlbumPreviewBinding`
L17 · [class] public final ActivityAlbumPreviewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAlbumPreviewBinding.java`

字段/常量（14）：
- `ImageView ivDelete`  L18
- `BottomButtomItem ivDeleteYutupro`  L19
- `ImageView ivEdit`  L20
- `BottomButtomItem ivEditYutupro`  L21
- `BottomButtomItem ivShareYutupro`  L22
- `ImageView ivVideoEdit`  L23
- `BottomButtomItem ivVideoEditYutupro`  L24
- `FrameLayout localAlbumPreview`  L25
- `LinearLayout localAlbumPreviewToolBar`  L26
- `LinearLayout localAlbumPreviewToolBarYutupro`  L27
- `FrameLayout rootView`  L28
- `Toolbar toolbar`  L29
- `PhotoViewPager vpager`  L30
- `int i = R.id.iv_delete`  L66

方法（5）：
- `private ActivityAlbumPreviewBinding(FrameLayout rootView, ImageView ivDelete, BottomButtomItem ivDeleteYutupro, ImageView ivEdit, BottomButtomItem ivEditYutupro, BottomButtomItem ivShareYutupro, ImageView ivVideoEdit, BottomButtomItem ivVideoEditYutupro, FrameLayout localAlbumPreview, LinearLayout localAlbumPreviewToolBar, LinearLayout localAlbumPreviewToolBarYutupro, Toolbar toolbar, PhotoViewPager vpager)`  L32
- `FrameLayout getRoot()`  L49 @Override
- `ActivityAlbumPreviewBinding inflate(LayoutInflater inflater)`  L53
- `ActivityAlbumPreviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L57
- `ActivityAlbumPreviewBinding bind(View rootView)`  L65
### `com.gku.xtugo.databinding.ActivityAmbaDeviceSettingBinding`
L13 · [class] public final ActivityAmbaDeviceSettingBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAmbaDeviceSettingBinding.java`

字段/常量（5）：
- `RecyclerView ambaSystemRecyModel`  L14
- `LayoutPreferTitleBinding ambaSystemTitlePrefer`  L15
- `RelativeLayout rootView`  L16
- `View viewFindChildViewById`  L42
- `int i = R.id.amba_system_recy_model`  L43

方法（5）：
- `private ActivityAmbaDeviceSettingBinding(RelativeLayout rootView, RecyclerView ambaSystemRecyModel, LayoutPreferTitleBinding ambaSystemTitlePrefer)`  L18
- `RelativeLayout getRoot()`  L25 @Override
- `ActivityAmbaDeviceSettingBinding inflate(LayoutInflater inflater)`  L29
- `ActivityAmbaDeviceSettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `ActivityAmbaDeviceSettingBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.ActivityAmbaPlaybackBinding`
L19 · [class] public final ActivityAmbaPlaybackBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAmbaPlaybackBinding.java`

字段/常量（17）：
- `RelativeLayout bottomToolbar`  L20
- `Button ibConfirm`  L21
- `HiGridView ibImgGridView`  L22
- `ImageView ibPreviewMenu`  L23
- `TextView ibSelectAll`  L24
- `Button ibUndo`  L25
- `ImageView ibback`  L26
- `RelativeLayout ibtopTitle`  L27
- `TextView ibtvTitle`  L28
- `View leftMargin`  L29
- `ProgressBar loadingView`  L30
- `RefreshHeadView refreshHeaderView`  L31
- `View rightMargin`  L32
- `FrameLayout rootView`  L33
- `View viewFindChildViewById`  L70
- `View viewFindChildViewById2`  L71
- `int i = R.id.bottom_toolbar`  L72

方法（5）：
- `private ActivityAmbaPlaybackBinding(FrameLayout rootView, RelativeLayout bottomToolbar, Button ibConfirm, HiGridView ibImgGridView, ImageView ibPreviewMenu, TextView ibSelectAll, Button ibUndo, ImageView ibback, RelativeLayout ibtopTitle, TextView ibtvTitle, View leftMargin, ProgressBar loadingView, RefreshHeadView refreshHeaderView, View rightMargin)`  L35
- `FrameLayout getRoot()`  L53 @Override
- `ActivityAmbaPlaybackBinding inflate(LayoutInflater inflater)`  L57
- `ActivityAmbaPlaybackBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L61
- `ActivityAmbaPlaybackBinding bind(View rootView)`  L69
### `com.gku.xtugo.databinding.ActivityAmbaPreviewBinding`
L15 · [class] public final ActivityAmbaPreviewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAmbaPreviewBinding.java`

字段/常量（7）：
- `VideoView ijkplayerVideo`  L16
- `RelativeLayout layoutFragLand`  L17
- `RelativeLayout layoutFragPort`  L18
- `FrameLayout mainBasePreview`  L19
- `FrameLayout rootView`  L20
- `TextView tvPrompt`  L21
- `int i = R.id.ijkplayer_video`  L50

方法（5）：
- `private ActivityAmbaPreviewBinding(FrameLayout rootView, VideoView ijkplayerVideo, RelativeLayout layoutFragLand, RelativeLayout layoutFragPort, FrameLayout mainBasePreview, TextView tvPrompt)`  L23
- `FrameLayout getRoot()`  L33 @Override
- `ActivityAmbaPreviewBinding inflate(LayoutInflater inflater)`  L37
- `ActivityAmbaPreviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `ActivityAmbaPreviewBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.ActivityAmbaRemotePhotoBinding`
L15 · [class] public final ActivityAmbaRemotePhotoBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAmbaRemotePhotoBinding.java`

字段/常量（8）：
- `RelativeLayout bottomToolbar`  L16
- `TextView ibprogress`  L17
- `ImageView playVideo`  L18
- `RelativeLayout rootView`  L19
- `SwitchImageView switchImageView`  L20
- `View topView`  L21
- `View viewFindChildViewById`  L50
- `int i = R.id.bottom_toolbar`  L51

方法（5）：
- `private ActivityAmbaRemotePhotoBinding(RelativeLayout rootView, RelativeLayout bottomToolbar, TextView ibprogress, ImageView playVideo, SwitchImageView switchImageView, View topView)`  L23
- `RelativeLayout getRoot()`  L33 @Override
- `ActivityAmbaRemotePhotoBinding inflate(LayoutInflater inflater)`  L37
- `ActivityAmbaRemotePhotoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `ActivityAmbaRemotePhotoBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.ActivityAmbaRemoteVideoBinding`
L13 · [class] public final ActivityAmbaRemoteVideoBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAmbaRemoteVideoBinding.java`

字段/常量（5）：
- `VideoView ambaControlVideo`  L14
- `FrameLayout rootView`  L15
- `View topView`  L16
- `View viewFindChildViewById`  L42
- `int i = R.id.amba_control_video`  L43

方法（5）：
- `private ActivityAmbaRemoteVideoBinding(FrameLayout rootView, VideoView ambaControlVideo, View topView)`  L18
- `FrameLayout getRoot()`  L25 @Override
- `ActivityAmbaRemoteVideoBinding inflate(LayoutInflater inflater)`  L29
- `ActivityAmbaRemoteVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `ActivityAmbaRemoteVideoBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.ActivityAmbaWorkSettingBinding`
L13 · [class] public final ActivityAmbaWorkSettingBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAmbaWorkSettingBinding.java`

字段/常量（5）：
- `RecyclerView ambaWorkRecyModel`  L14
- `LayoutPreferTitleBinding ambaWorkTitlePrefer`  L15
- `RelativeLayout rootView`  L16
- `View viewFindChildViewById`  L42
- `int i = R.id.amba_work_recy_model`  L43

方法（5）：
- `private ActivityAmbaWorkSettingBinding(RelativeLayout rootView, RecyclerView ambaWorkRecyModel, LayoutPreferTitleBinding ambaWorkTitlePrefer)`  L18
- `RelativeLayout getRoot()`  L25 @Override
- `ActivityAmbaWorkSettingBinding inflate(LayoutInflater inflater)`  L29
- `ActivityAmbaWorkSettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `ActivityAmbaWorkSettingBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.ActivityAnnouncementLatestBinding`
L16 · [class] public abstract ActivityAnnouncementLatestBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ActivityAnnouncementLatestBinding.java`

字段/常量（5）：
- `ImageView iconRecLeft`  L17
- `ImageView iconRecRight`  L18
- `AnnouncementLatestViewModel mAnnouncementLatestViewModel`  L21 @Bindable
- `RecyclerView recyclerAnnouncementLatest`  L22
- `MaterialToolbar toolbar`  L23

方法（9）：
- `void setAnnouncementLatestViewModel(AnnouncementLatestViewModel announcementLatestViewModel)`  L25
- `protected ActivityAnnouncementLatestBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView iconRecLeft, ImageView iconRecRight, RecyclerView recyclerAnnouncementLatest, MaterialToolbar toolbar)`  L27
- `AnnouncementLatestViewModel getAnnouncementLatestViewModel()`  L35
- `ActivityAnnouncementLatestBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L39
- `ActivityAnnouncementLatestBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L44 @Deprecated
- `ActivityAnnouncementLatestBinding inflate(LayoutInflater inflater)`  L48
- `ActivityAnnouncementLatestBinding inflate(LayoutInflater inflater, Object component)`  L53 @Deprecated
- `ActivityAnnouncementLatestBinding bind(View view)`  L57
- `ActivityAnnouncementLatestBinding bind(View view, Object component)`  L62 @Deprecated
### `com.gku.xtugo.databinding.ActivityAnnouncementLatestBindingImpl`
L15 · [class] public ActivityAnnouncementLatestBindingImpl · extends `ActivityAnnouncementLatestBinding` · `com/gku/xtugo/databinding/ActivityAnnouncementLatestBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L16
- `SparseIntArray sViewsWithIds`  L17
- `long mDirtyFlags`  L18
- `LinearLayout mboundView0`  L19

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L22 @Override
- `public ActivityAnnouncementLatestBindingImpl(DataBindingComponent bindingComponent, View root)`  L35
- `private ActivityAnnouncementLatestBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L39
- `void invalidateAll()`  L50 @Override
- `boolean hasPendingBindings()`  L58 @Override
- `boolean setVariable(int variableId, Object variable)`  L65 @Override
- `void setAnnouncementLatestViewModel(AnnouncementLatestViewModel AnnouncementLatestViewModel)`  L74 @Override
- `void executeBindings()`  L79 @Override
### `com.gku.xtugo.databinding.ActivityAudioCollectBinding`
L16 · [class] public final ActivityAudioCollectBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityAudioCollectBinding.java`

字段/常量（7）：
- `ImageView ivClose`  L17
- `LinearLayoutCompat llSelect`  L18
- `ConstraintLayout rootView`  L19
- `RecyclerView rvList`  L20
- `TextView tvCollect`  L21
- `TextView tvLocal`  L22
- `int i = R.id.iv_close`  L51

方法（5）：
- `private ActivityAudioCollectBinding(ConstraintLayout rootView, ImageView ivClose, LinearLayoutCompat llSelect, RecyclerView rvList, TextView tvCollect, TextView tvLocal)`  L24
- `ConstraintLayout getRoot()`  L34 @Override
- `ActivityAudioCollectBinding inflate(LayoutInflater inflater)`  L38
- `ActivityAudioCollectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L42
- `ActivityAudioCollectBinding bind(View rootView)`  L50
### `com.gku.xtugo.databinding.ActivityBitRateBinding`
L15 · [class] public final ActivityBitRateBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityBitRateBinding.java`

字段/常量（5）：
- `Button btnBitRate`  L16
- `EditText editBitRate`  L17
- `LinearLayout rootView`  L18
- `TextView textBitRate`  L19
- `int i = R.id.btnBitRate`  L46

方法（5）：
- `private ActivityBitRateBinding(LinearLayout rootView, Button btnBitRate, EditText editBitRate, TextView textBitRate)`  L21
- `LinearLayout getRoot()`  L29 @Override
- `ActivityBitRateBinding inflate(LayoutInflater inflater)`  L33
- `ActivityBitRateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `ActivityBitRateBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.ActivityCameraVideoBinding`
L14 · [class] public final ActivityCameraVideoBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityCameraVideoBinding.java`

字段/常量（6）：
- `ConstraintLayout rootView`  L15
- `RecyclerView rvList`  L16
- `TextView tvCancal`  L17
- `TextView tvNoFile`  L18
- `TextView tvTitle`  L19
- `int i = R.id.rv_list`  L47

方法（5）：
- `private ActivityCameraVideoBinding(ConstraintLayout rootView, RecyclerView rvList, TextView tvCancal, TextView tvNoFile, TextView tvTitle)`  L21
- `ConstraintLayout getRoot()`  L30 @Override
- `ActivityCameraVideoBinding inflate(LayoutInflater inflater)`  L34
- `ActivityCameraVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `ActivityCameraVideoBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.ActivityCustomLiveBinding`
L17 · [class] public final ActivityCustomLiveBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityCustomLiveBinding.java`

字段/常量（11）：
- `LinearLayout FacebookLiveLoginTitle`  L18
- `LinearLayout FacebookLiveTitle`  L19
- `EditText customLiveRtmpEdit`  L20
- `Toolbar customLiveToolbar`  L21
- `TextView customLiveWifiName`  L22
- `ConstraintLayout customLiveWifiScan`  L23
- `ImageView rlStartLiveImage`  L24
- `TextView rlStartLiveText`  L25
- `LinearLayout rootView`  L26
- `LinearLayout startLiveButton`  L27
- `int i = R.id._facebook_live_login_title`  L60

方法（5）：
- `private ActivityCustomLiveBinding(LinearLayout rootView, LinearLayout FacebookLiveLoginTitle, LinearLayout FacebookLiveTitle, EditText customLiveRtmpEdit, Toolbar customLiveToolbar, TextView customLiveWifiName, ConstraintLayout customLiveWifiScan, ImageView rlStartLiveImage, TextView rlStartLiveText, LinearLayout startLiveButton)`  L29
- `LinearLayout getRoot()`  L43 @Override
- `ActivityCustomLiveBinding inflate(LayoutInflater inflater)`  L47
- `ActivityCustomLiveBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L51
- `ActivityCustomLiveBinding bind(View rootView)`  L59
### `com.gku.xtugo.databinding.ActivityCutBinding`
L18 · [class] public final ActivityCutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityCutBinding.java`

字段/常量（20）：
- `Button btnCancal`  L19
- `Button btnCut`  L20
- `LinearLayout idSeekBarLayout`  L21
- `ConstraintLayout llAudio`  L22
- `LinearLayout llSpeed`  L23
- `LinearLayout llVideo`  L24
- `ImageView positionIcon`  L25
- `ConstraintLayout rootView`  L26
- `RecyclerView rvAudio`  L27
- `TextView tvAudioCut`  L28
- `TextView tvEndTime`  L29
- `TextView tvMoreAudio`  L30
- `TextView tvMusic`  L31
- `TextView tvSpeed`  L32
- `TextView tvStartTime`  L33
- `TextView tvVideoAudioOpen`  L34
- `TextView tvVideoCut`  L35
- `RecyclerView videoThumbListview`  L36
- `MyVideoView videoview`  L37
- `int i = R.id.btn_cancal`  L79

方法（5）：
- `private ActivityCutBinding(ConstraintLayout rootView, Button btnCancal, Button btnCut, LinearLayout idSeekBarLayout, ConstraintLayout llAudio, LinearLayout llSpeed, LinearLayout llVideo, ImageView positionIcon, RecyclerView rvAudio, TextView tvAudioCut, TextView tvEndTime, TextView tvMoreAudio, TextView tvMusic, TextView tvSpeed, TextView tvStartTime, TextView tvVideoAudioOpen, TextView tvVideoCut, RecyclerView videoThumbListview, MyVideoView videoview)`  L39
- `ConstraintLayout getRoot()`  L62 @Override
- `ActivityCutBinding inflate(LayoutInflater inflater)`  L66
- `ActivityCutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L70
- `ActivityCutBinding bind(View rootView)`  L78
### `com.gku.xtugo.databinding.ActivityDeviceAddBinding`
L16 · [class] public final ActivityDeviceAddBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityDeviceAddBinding.java`

字段/常量（8）：
- `FrameLayout flDeviceAdd`  L17
- `ConstraintLayout rootView`  L18
- `RecyclerView rvDeviceAdd`  L19
- `TextView sportCamera`  L20
- `LayoutDeviceAddTitleBarBinding toolbarDeviceAdd`  L21
- `ViewPager2 vpDeviceAdd`  L22
- `View viewFindChildViewById`  L51
- `int i = R.id.fl_device_add`  L52

方法（5）：
- `private ActivityDeviceAddBinding(ConstraintLayout rootView, FrameLayout flDeviceAdd, RecyclerView rvDeviceAdd, TextView sportCamera, LayoutDeviceAddTitleBarBinding toolbarDeviceAdd, ViewPager2 vpDeviceAdd)`  L24
- `ConstraintLayout getRoot()`  L34 @Override
- `ActivityDeviceAddBinding inflate(LayoutInflater inflater)`  L38
- `ActivityDeviceAddBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L42
- `ActivityDeviceAddBinding bind(View rootView)`  L50
### `com.gku.xtugo.databinding.ActivityDeviceAddNewBinding`
L16 · [class] public final ActivityDeviceAddNewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityDeviceAddNewBinding.java`

字段/常量（10）：
- `FrameLayout flDeviceAdd`  L17
- `IconTextView itBluetooth`  L18
- `IconTextView itHandle`  L19
- `IconTextView itScan`  L20
- `ConstraintLayout rootView`  L21
- `RecyclerView rvDeviceAdd`  L22
- `TextView sportCamera`  L23
- `LayoutDeviceAddTitleBarBinding toolbarDeviceAdd`  L24
- `View viewFindChildViewById`  L55
- `int i = R.id.fl_device_add`  L56

方法（5）：
- `private ActivityDeviceAddNewBinding(ConstraintLayout rootView, FrameLayout flDeviceAdd, IconTextView itBluetooth, IconTextView itHandle, IconTextView itScan, RecyclerView rvDeviceAdd, TextView sportCamera, LayoutDeviceAddTitleBarBinding toolbarDeviceAdd)`  L26
- `ConstraintLayout getRoot()`  L38 @Override
- `ActivityDeviceAddNewBinding inflate(LayoutInflater inflater)`  L42
- `ActivityDeviceAddNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `ActivityDeviceAddNewBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.ActivityDeviceManagerBinding`
L18 · [class] public abstract ActivityDeviceManagerBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ActivityDeviceManagerBinding.java`

字段/常量（11）：
- `ImageView imageCheckAll`  L19
- `ImageView ivBack`  L20
- `RelativeLayout layoutAutoDownload`  L21
- `LinearLayout layoutCheckAll`  L22
- `RecyclerView recyclerView`  L23
- `SimpleSwitchButton switchButton`  L24
- `Button tvCheckVersion`  L25
- `TextView tvCheckVersionHint`  L26
- `TextView tvDelete`  L27
- `TextView tvEmptyHint`  L28
- `TextView tvManager`  L29

方法（7）：
- `protected ActivityDeviceManagerBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imageCheckAll, ImageView ivBack, RelativeLayout layoutAutoDownload, LinearLayout layoutCheckAll, RecyclerView recyclerView, SimpleSwitchButton switchButton, Button tvCheckVersion, TextView tvCheckVersionHint, TextView tvDelete, TextView tvEmptyHint, TextView tvManager)`  L31
- `ActivityDeviceManagerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L46
- `ActivityDeviceManagerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L51 @Deprecated
- `ActivityDeviceManagerBinding inflate(LayoutInflater inflater)`  L55
- `ActivityDeviceManagerBinding inflate(LayoutInflater inflater, Object component)`  L60 @Deprecated
- `ActivityDeviceManagerBinding bind(View view)`  L64
- `ActivityDeviceManagerBinding bind(View view, Object component)`  L69 @Deprecated
### `com.gku.xtugo.databinding.ActivityDeviceManagerBindingImpl`
L17 · [class] public ActivityDeviceManagerBindingImpl · extends `ActivityDeviceManagerBinding` · `com/gku/xtugo/databinding/ActivityDeviceManagerBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L18
- `SparseIntArray sViewsWithIds`  L19
- `long mDirtyFlags`  L20
- `LinearLayout mboundView0`  L21

方法（7）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L24 @Override
- `boolean setVariable(int variableId, Object variable)`  L29 @Override
- `public ActivityDeviceManagerBindingImpl(DataBindingComponent bindingComponent, View root)`  L49
- `private ActivityDeviceManagerBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L53
- `void invalidateAll()`  L64 @Override
- `boolean hasPendingBindings()`  L72 @Override
- `void executeBindings()`  L79 @Override
### `com.gku.xtugo.databinding.ActivityDeviceStrBinding`
L13 · [class] public final ActivityDeviceStrBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityDeviceStrBinding.java`

字段/常量（5）：
- `LayoutPreferTitleBinding ambaWorkTitlePrefer`  L14
- `RecyclerView recyDevice`  L15
- `RelativeLayout rootView`  L16
- `int i = R.id.amba_work_title_prefer`  L42
- `int i2 = R.id.recy_device`  L46

方法（5）：
- `private ActivityDeviceStrBinding(RelativeLayout rootView, LayoutPreferTitleBinding ambaWorkTitlePrefer, RecyclerView recyDevice)`  L18
- `RelativeLayout getRoot()`  L25 @Override
- `ActivityDeviceStrBinding inflate(LayoutInflater inflater)`  L29
- `ActivityDeviceStrBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `ActivityDeviceStrBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.ActivityDeviceUpgradeBinding`
L18 · [class] public final ActivityDeviceUpgradeBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityDeviceUpgradeBinding.java`

字段/常量（12）：
- `ImageView ivBack`  L19
- `RelativeLayout layoutButton`  L20
- `CustomRoundProgress progress`  L21
- `LinearLayout rootView`  L22
- `TextView tvButton`  L23
- `LinearLayoutShape tvCheckVersion`  L24
- `TextView tvContent`  L25
- `TextView tvDeviceName`  L26
- `TextView tvHint`  L27
- `TextViewShape tvNewVersion`  L28
- `TextViewShape tvOldVersion`  L29
- `int i = R.id.iv_back`  L63

方法（5）：
- `private ActivityDeviceUpgradeBinding(LinearLayout rootView, ImageView ivBack, RelativeLayout layoutButton, CustomRoundProgress progress, TextView tvButton, LinearLayoutShape tvCheckVersion, TextView tvContent, TextView tvDeviceName, TextView tvHint, TextViewShape tvNewVersion, TextViewShape tvOldVersion)`  L31
- `LinearLayout getRoot()`  L46 @Override
- `ActivityDeviceUpgradeBinding inflate(LayoutInflater inflater)`  L50
- `ActivityDeviceUpgradeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L54
- `ActivityDeviceUpgradeBinding bind(View rootView)`  L62
### `com.gku.xtugo.databinding.ActivityDownloadPackagesBinding`
L13 · [class] public final ActivityDownloadPackagesBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityDownloadPackagesBinding.java`

字段/常量（3）：
- `ListView listViewPackage`  L14
- `RelativeLayout rootView`  L15
- `int i = R.id.listViewPackage`  L40

方法（5）：
- `private ActivityDownloadPackagesBinding(RelativeLayout rootView, ListView listViewPackage)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `ActivityDownloadPackagesBinding inflate(LayoutInflater inflater)`  L27
- `ActivityDownloadPackagesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `ActivityDownloadPackagesBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.ActivityExceptionBinding`
L13 · [class] public final ActivityExceptionBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityExceptionBinding.java`

字段/常量（3）：
- `TextView exceptionLog`  L14
- `ConstraintLayout rootView`  L15
- `int i = R.id.exception_log`  L40

方法（5）：
- `private ActivityExceptionBinding(ConstraintLayout rootView, TextView exceptionLog)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `ActivityExceptionBinding inflate(LayoutInflater inflater)`  L27
- `ActivityExceptionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `ActivityExceptionBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.ActivityHomeBinding`
L16 · [class] public final ActivityHomeBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityHomeBinding.java`

字段/常量（20）：
- `RelativeLayout activityHome`  L17
- `BottomButtomItem bottomCamera`  L18
- `LinearLayout bottomLinear`  L19
- `BottomButtomItem bottomPhoto`  L20
- `PopupSelectViewBinding bottomPopup`  L21
- `RelativeLayout bottomRela`  L22
- `BottomButtomItem bottomUser`  L23
- `BottomButtomItem bottomXtuPlus`  L24
- `Button btnLog`  L25
- `Button deleteFiles`  L26
- `LayoutTitleBarBinding layoutTitle`  L27
- `ViewPager mFvpager`  L28
- `RelativeLayout rootView`  L29
- `Button selectAllFiles`  L30
- `LinearLayout selectFilesLayout`  L31
- `LayoutTopPopupViewBinding topPopupList`  L32
- `View viewFindChildViewById`  L71
- `View viewFindChildViewById2`  L72
- `View viewFindChildViewById3`  L73
- `int i = R.id.bottom_camera`  L75

方法（5）：
- `private ActivityHomeBinding(RelativeLayout rootView, RelativeLayout activityHome, BottomButtomItem bottomCamera, LinearLayout bottomLinear, BottomButtomItem bottomPhoto, PopupSelectViewBinding bottomPopup, RelativeLayout bottomRela, BottomButtomItem bottomUser, BottomButtomItem bottomXtuPlus, Button btnLog, Button deleteFiles, LayoutTitleBarBinding layoutTitle, ViewPager mFvpager, Button selectAllFiles, LinearLayout selectFilesLayout, LayoutTopPopupViewBinding topPopupList)`  L34
- `RelativeLayout getRoot()`  L54 @Override
- `ActivityHomeBinding inflate(LayoutInflater inflater)`  L58
- `ActivityHomeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L62
- `ActivityHomeBinding bind(View rootView)`  L70
### `com.gku.xtugo.databinding.ActivityHwscaningBinding`
L17 · [class] public final ActivityHwscaningBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityHwscaningBinding.java`

字段/常量（8）：
- `ImageView backImg`  L18
- `FrameLayout rim`  L19
- `ConstraintLayout rootView`  L20
- `ScrollingYellowLineView scrollingYellowLineView`  L21
- `TextView viewPSWhw`  L22
- `TextView viewSSIDhw`  L23
- `LinearLayout viewWifiContainerhw`  L24
- `int i = R.id.back_img`  L54

方法（5）：
- `private ActivityHwscaningBinding(ConstraintLayout rootView, ImageView backImg, FrameLayout rim, ScrollingYellowLineView scrollingYellowLineView, TextView viewPSWhw, TextView viewSSIDhw, LinearLayout viewWifiContainerhw)`  L26
- `ConstraintLayout getRoot()`  L37 @Override
- `ActivityHwscaningBinding inflate(LayoutInflater inflater)`  L41
- `ActivityHwscaningBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L45
- `ActivityHwscaningBinding bind(View rootView)`  L53
### `com.gku.xtugo.databinding.ActivityImageEditBinding`
L17 · [class] public final ActivityImageEditBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityImageEditBinding.java`

字段/常量（10）：
- `LinearLayout llBottomContainer`  L18
- `LinearLayout llTab1`  L19
- `LinearLayout llTab2`  L20
- `LinearLayout llTab3`  L21
- `PhotoView pvCover`  L22
- `RecyclerView rlvAction`  L23
- `RelativeLayout rootView`  L24
- `SimpleTabLinearLayout tab`  L25
- `Toolbar toolbar`  L26
- `int i = R.id.ll_bottom_container`  L58

方法（5）：
- `private ActivityImageEditBinding(RelativeLayout rootView, LinearLayout llBottomContainer, LinearLayout llTab1, LinearLayout llTab2, LinearLayout llTab3, PhotoView pvCover, RecyclerView rlvAction, SimpleTabLinearLayout tab, Toolbar toolbar)`  L28
- `RelativeLayout getRoot()`  L41 @Override
- `ActivityImageEditBinding inflate(LayoutInflater inflater)`  L45
- `ActivityImageEditBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L49
- `ActivityImageEditBinding bind(View rootView)`  L57
### `com.gku.xtugo.databinding.ActivityImageEditClipBinding`
L17 · [class] public final ActivityImageEditClipBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityImageEditClipBinding.java`

字段/常量（8）：
- `ImageView ivDone`  L18
- `ImageView ivQuitSelectAll`  L19
- `LinearLayout llBottomContainer`  L20
- `RelativeLayout rootView`  L21
- `Toolbar toolbar`  L22
- `TextView tvSize`  L23
- `UCropView ucvCover`  L24
- `int i = R.id.iv_done`  L54

方法（5）：
- `private ActivityImageEditClipBinding(RelativeLayout rootView, ImageView ivDone, ImageView ivQuitSelectAll, LinearLayout llBottomContainer, Toolbar toolbar, TextView tvSize, UCropView ucvCover)`  L26
- `RelativeLayout getRoot()`  L37 @Override
- `ActivityImageEditClipBinding inflate(LayoutInflater inflater)`  L41
- `ActivityImageEditClipBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L45
- `ActivityImageEditClipBinding bind(View rootView)`  L53
### `com.gku.xtugo.databinding.ActivityImageEditEffectBinding`
L17 · [class] public final ActivityImageEditEffectBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityImageEditEffectBinding.java`

字段/常量（8）：
- `GPUImageView ivCover`  L18
- `ImageView ivDone`  L19
- `ImageView ivQuitSelectAll`  L20
- `LinearLayout llBottomContainer`  L21
- `RelativeLayout rootView`  L22
- `SeekBar sbSeekbar`  L23
- `Toolbar toolbar`  L24
- `int i = R.id.iv_cover`  L54

方法（5）：
- `private ActivityImageEditEffectBinding(RelativeLayout rootView, GPUImageView ivCover, ImageView ivDone, ImageView ivQuitSelectAll, LinearLayout llBottomContainer, SeekBar sbSeekbar, Toolbar toolbar)`  L26
- `RelativeLayout getRoot()`  L37 @Override
- `ActivityImageEditEffectBinding inflate(LayoutInflater inflater)`  L41
- `ActivityImageEditEffectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L45
- `ActivityImageEditEffectBinding bind(View rootView)`  L53
### `com.gku.xtugo.databinding.ActivityLocalAlbumBinding`
L11 · [class] public final ActivityLocalAlbumBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityLocalAlbumBinding.java`

字段/常量（1）：
- `FrameLayout rootView`  L12

方法（5）：
- `private ActivityLocalAlbumBinding(FrameLayout rootView)`  L14
- `FrameLayout getRoot()`  L19 @Override
- `ActivityLocalAlbumBinding inflate(LayoutInflater inflater)`  L23
- `ActivityLocalAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L27
- `ActivityLocalAlbumBinding bind(View rootView)`  L35
    - 体内字面量："rootView"
### `com.gku.xtugo.databinding.ActivityLoginRegisterModuleBinding`
L15 · [class] public abstract ActivityLoginRegisterModuleBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ActivityLoginRegisterModuleBinding.java`

字段/常量（3）：
- `LinearLayout llTouristsEnter`  L16
- `LoginRegisterViewModel mLoginViewModel`  L19 @Bindable
- `MaterialToolbar toolbarLogin`  L20

方法（9）：
- `void setLoginViewModel(LoginRegisterViewModel loginViewModel)`  L22
- `protected ActivityLoginRegisterModuleBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout llTouristsEnter, MaterialToolbar toolbarLogin)`  L24
- `LoginRegisterViewModel getLoginViewModel()`  L30
- `ActivityLoginRegisterModuleBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L34
- `ActivityLoginRegisterModuleBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L39 @Deprecated
- `ActivityLoginRegisterModuleBinding inflate(LayoutInflater inflater)`  L43
- `ActivityLoginRegisterModuleBinding inflate(LayoutInflater inflater, Object component)`  L48 @Deprecated
- `ActivityLoginRegisterModuleBinding bind(View view)`  L52
- `ActivityLoginRegisterModuleBinding bind(View view, Object component)`  L57 @Deprecated
### `com.gku.xtugo.databinding.ActivityLoginRegisterModuleBindingImpl`
L13 · [class] public ActivityLoginRegisterModuleBindingImpl · extends `ActivityLoginRegisterModuleBinding` · `com/gku/xtugo/databinding/ActivityLoginRegisterModuleBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L14
- `SparseIntArray sViewsWithIds`  L15
- `long mDirtyFlags`  L16
- `LinearLayout mboundView0`  L17

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L20 @Override
- `public ActivityLoginRegisterModuleBindingImpl(DataBindingComponent bindingComponent, View root)`  L31
- `private ActivityLoginRegisterModuleBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L35
- `void invalidateAll()`  L46 @Override
- `boolean hasPendingBindings()`  L54 @Override
- `boolean setVariable(int variableId, Object variable)`  L61 @Override
- `void setLoginViewModel(LoginRegisterViewModel LoginViewModel)`  L70 @Override
- `void executeBindings()`  L75 @Override
### `com.gku.xtugo.databinding.ActivityMultiPbBinding`
L14 · [class] public final ActivityMultiPbBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityMultiPbBinding.java`

字段/常量（4）：
- `CoordinatorLayout rootView`  L15
- `TabLayout tabs`  L16
- `Toolbar toolbar`  L17
- `int i = R.id.tabs`  L43

方法（5）：
- `private ActivityMultiPbBinding(CoordinatorLayout rootView, TabLayout tabs, Toolbar toolbar)`  L19
- `CoordinatorLayout getRoot()`  L26 @Override
- `ActivityMultiPbBinding inflate(LayoutInflater inflater)`  L30
- `ActivityMultiPbBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ActivityMultiPbBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.ActivityOnlineAndOfflinePlayerBinding`
L13 · [class] public final ActivityOnlineAndOfflinePlayerBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityOnlineAndOfflinePlayerBinding.java`

字段/常量（3）：
- `ImageView backImg`  L14
- `ConstraintLayout rootView`  L15
- `int i = R.id.back_img`  L40

方法（5）：
- `private ActivityOnlineAndOfflinePlayerBinding(ConstraintLayout rootView, ImageView backImg)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `ActivityOnlineAndOfflinePlayerBinding inflate(LayoutInflater inflater)`  L27
- `ActivityOnlineAndOfflinePlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `ActivityOnlineAndOfflinePlayerBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.ActivityPhoneSpaceBinding`
L14 · [class] public final ActivityPhoneSpaceBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityPhoneSpaceBinding.java`

字段/常量（6）：
- `LayoutPreferTitleBinding ambaWorkTitlePrefer`  L15
- `MyCircleProgress mcpSpace`  L16
- `RelativeLayout rootView`  L17
- `TextView tvSpace`  L18
- `int i = R.id.amba_work_title_prefer`  L45
- `int i2 = R.id.mcp_space`  L49

方法（5）：
- `private ActivityPhoneSpaceBinding(RelativeLayout rootView, LayoutPreferTitleBinding ambaWorkTitlePrefer, MyCircleProgress mcpSpace, TextView tvSpace)`  L20
- `RelativeLayout getRoot()`  L28 @Override
- `ActivityPhoneSpaceBinding inflate(LayoutInflater inflater)`  L32
- `ActivityPhoneSpaceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `ActivityPhoneSpaceBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.ActivityPhotoPbBinding`
L11 · [class] public final ActivityPhotoPbBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityPhotoPbBinding.java`

字段/常量（1）：
- `CoordinatorLayout rootView`  L12

方法（5）：
- `private ActivityPhotoPbBinding(CoordinatorLayout rootView)`  L14
- `CoordinatorLayout getRoot()`  L19 @Override
- `ActivityPhotoPbBinding inflate(LayoutInflater inflater)`  L23
- `ActivityPhotoPbBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L27
- `ActivityPhotoPbBinding bind(View rootView)`  L35
    - 体内字面量："rootView"
### `com.gku.xtugo.databinding.ActivityPreferStrBinding`
L13 · [class] public final ActivityPreferStrBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityPreferStrBinding.java`

字段/常量（5）：
- `RecyclerView ambaWorkRecyModel`  L14
- `LayoutPreferTitleBinding ambaWorkTitlePrefer`  L15
- `RelativeLayout rootView`  L16
- `View viewFindChildViewById`  L42
- `int i = R.id.amba_work_recy_model`  L43

方法（5）：
- `private ActivityPreferStrBinding(RelativeLayout rootView, RecyclerView ambaWorkRecyModel, LayoutPreferTitleBinding ambaWorkTitlePrefer)`  L18
- `RelativeLayout getRoot()`  L25 @Override
- `ActivityPreferStrBinding inflate(LayoutInflater inflater)`  L29
- `ActivityPreferStrBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `ActivityPreferStrBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.ActivityPreviewBinding`
L14 · [class] public final ActivityPreviewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityPreviewBinding.java`

字段/常量（4）：
- `AppBarLayout AppBarLayout`  L15
- `RelativeLayout rootView`  L16
- `Toolbar toolbar`  L17
- `int i = R.id.AppBarLayout`  L43

方法（5）：
- `private ActivityPreviewBinding(RelativeLayout rootView, AppBarLayout AppBarLayout, Toolbar toolbar)`  L19
- `RelativeLayout getRoot()`  L26 @Override
- `ActivityPreviewBinding inflate(LayoutInflater inflater)`  L30
- `ActivityPreviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ActivityPreviewBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.ActivityPreviewNewBinding`
L16 · [class] public final ActivityPreviewNewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityPreviewNewBinding.java`

字段/常量（15）：
- `View grayArea`  L17
- `ImageView ivCountDownBackground`  L18
- `ImageView ivSavedSign`  L19
- `RelativeLayout layoutFragLand`  L20
- `RelativeLayout layoutFragPort`  L21
- `FrameLayout previewContainer`  L22
- `ImageView previewCover`  L23
- `FrameLayout rootView`  L24
- `FrameLayout ssPreviewMain`  L25
- `StateView svMessage`  L26
- `TextView tvCountDownTime`  L27
- `TextView tvPrompt`  L28
- `View viewSpaceLayout`  L29
- `View viewFindChildViewById`  L65
- `int i = R.id.grayArea`  L66

方法（5）：
- `private ActivityPreviewNewBinding(FrameLayout rootView, View grayArea, ImageView ivCountDownBackground, ImageView ivSavedSign, RelativeLayout layoutFragLand, RelativeLayout layoutFragPort, FrameLayout previewContainer, ImageView previewCover, FrameLayout ssPreviewMain, StateView svMessage, TextView tvCountDownTime, TextView tvPrompt, View viewSpaceLayout)`  L31
- `FrameLayout getRoot()`  L48 @Override
- `ActivityPreviewNewBinding inflate(LayoutInflater inflater)`  L52
- `ActivityPreviewNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L56
- `ActivityPreviewNewBinding bind(View rootView)`  L64
### `com.gku.xtugo.databinding.ActivityPrivacyAgreementBinding`
L12 · [class] public final ActivityPrivacyAgreementBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityPrivacyAgreementBinding.java`

字段/常量（5）：
- `LayoutPrivacyAgreementBinding paActivityContent`  L13
- `LinearLayout paBack`  L14
- `LinearLayout rootView`  L15
- `int i = R.id.pa_activity_content`  L41
- `int i2 = R.id.pa_back`  L45

方法（5）：
- `private ActivityPrivacyAgreementBinding(LinearLayout rootView, LayoutPrivacyAgreementBinding paActivityContent, LinearLayout paBack)`  L17
- `LinearLayout getRoot()`  L24 @Override
- `ActivityPrivacyAgreementBinding inflate(LayoutInflater inflater)`  L28
- `ActivityPrivacyAgreementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L32
- `ActivityPrivacyAgreementBinding bind(View rootView)`  L40
### `com.gku.xtugo.databinding.ActivityQRShowBinding`
L16 · [class] public final ActivityQRShowBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityQRShowBinding.java`

字段/常量（6）：
- `Guideline Guideline`  L17
- `TextView QrShowScanQrText`  L18
- `ImageView qrShowImage`  L19
- `Toolbar qrShowToolbar`  L20
- `ConstraintLayout rootView`  L21
- `int i = R.id._guideline`  L49

方法（5）：
- `private ActivityQRShowBinding(ConstraintLayout rootView, Guideline Guideline, TextView QrShowScanQrText, ImageView qrShowImage, Toolbar qrShowToolbar)`  L23
- `ConstraintLayout getRoot()`  L32 @Override
- `ActivityQRShowBinding inflate(LayoutInflater inflater)`  L36
- `ActivityQRShowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `ActivityQRShowBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.ActivityQuestionDescriptionBinding`
L17 · [class] public final ActivityQuestionDescriptionBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityQuestionDescriptionBinding.java`

字段/常量（13）：
- `TextView contactDetails`  L18
- `EditText detailContent`  L19
- `View detailContentBottomLine`  L20
- `RadioButton radioEmail`  L21
- `RadioGroup radioGroup`  L22
- `RadioButton radioPhone`  L23
- `EditText remainContactDetails`  L24
- `ConstraintLayout rootView`  L25
- `Button submit`  L26
- `LayoutQuestionSelectTitleBarBinding titleQuestionDescription`  L27
- `View viewFindChildViewById`  L60
- `View viewFindChildViewById2`  L61
- `int i = R.id.contact_details`  L62

方法（5）：
- `private ActivityQuestionDescriptionBinding(ConstraintLayout rootView, TextView contactDetails, EditText detailContent, View detailContentBottomLine, RadioButton radioEmail, RadioGroup radioGroup, RadioButton radioPhone, EditText remainContactDetails, Button submit, LayoutQuestionSelectTitleBarBinding titleQuestionDescription)`  L29
- `ConstraintLayout getRoot()`  L43 @Override
- `ActivityQuestionDescriptionBinding inflate(LayoutInflater inflater)`  L47
- `ActivityQuestionDescriptionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L51
- `ActivityQuestionDescriptionBinding bind(View rootView)`  L59
### `com.gku.xtugo.databinding.ActivityQuestionSelectBinding`
L14 · [class] public final ActivityQuestionSelectBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityQuestionSelectBinding.java`

字段/常量（6）：
- `TextView issueSelect`  L15
- `ConstraintLayout rootView`  L16
- `RecyclerView rvQuestionSelect`  L17
- `LayoutQuestionSelectTitleBarBinding titleQuestionSelect`  L18
- `View viewFindChildViewById`  L45
- `int i = R.id.issue_select`  L46

方法（5）：
- `private ActivityQuestionSelectBinding(ConstraintLayout rootView, TextView issueSelect, RecyclerView rvQuestionSelect, LayoutQuestionSelectTitleBarBinding titleQuestionSelect)`  L20
- `ConstraintLayout getRoot()`  L28 @Override
- `ActivityQuestionSelectBinding inflate(LayoutInflater inflater)`  L32
- `ActivityQuestionSelectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `ActivityQuestionSelectBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.ActivityReportFeedbackBinding`
L13 · [class] public abstract ActivityReportFeedbackBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ActivityReportFeedbackBinding.java`

字段/常量（2）：
- `MaterialToolbar toolbar`  L14
- `TextView tvReportFeedback`  L15

方法（7）：
- `protected ActivityReportFeedbackBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialToolbar toolbar, TextView tvReportFeedback)`  L17
- `ActivityReportFeedbackBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L23
- `ActivityReportFeedbackBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L28 @Deprecated
- `ActivityReportFeedbackBinding inflate(LayoutInflater inflater)`  L32
- `ActivityReportFeedbackBinding inflate(LayoutInflater inflater, Object component)`  L37 @Deprecated
- `ActivityReportFeedbackBinding bind(View view)`  L41
- `ActivityReportFeedbackBinding bind(View view, Object component)`  L46 @Deprecated
### `com.gku.xtugo.databinding.ActivityReportFeedbackBindingImpl`
L13 · [class] public ActivityReportFeedbackBindingImpl · extends `ActivityReportFeedbackBinding` · `com/gku/xtugo/databinding/ActivityReportFeedbackBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L14
- `SparseIntArray sViewsWithIds`  L15
- `long mDirtyFlags`  L16
- `LinearLayout mboundView0`  L17

方法（7）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L20 @Override
- `boolean setVariable(int variableId, Object variable)`  L25 @Override
- `public ActivityReportFeedbackBindingImpl(DataBindingComponent bindingComponent, View root)`  L36
- `private ActivityReportFeedbackBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L40
- `void invalidateAll()`  L51 @Override
- `boolean hasPendingBindings()`  L59 @Override
- `void executeBindings()`  L66 @Override
### `com.gku.xtugo.databinding.ActivityScanWifiBinding`
L14 · [class] public final ActivityScanWifiBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityScanWifiBinding.java`

字段/常量（5）：
- `LinearLayout rootView`  L15
- `LinearLayout scanWifiHotPoint`  L16
- `ListView scanWifiList`  L17
- `Toolbar scanWifiToolbar`  L18
- `int i = R.id.scan_wifi_hot_point`  L45

方法（5）：
- `private ActivityScanWifiBinding(LinearLayout rootView, LinearLayout scanWifiHotPoint, ListView scanWifiList, Toolbar scanWifiToolbar)`  L20
- `LinearLayout getRoot()`  L28 @Override
- `ActivityScanWifiBinding inflate(LayoutInflater inflater)`  L32
- `ActivityScanWifiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `ActivityScanWifiBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.ActivitySelectLiveBinding`
L14 · [class] public final ActivitySelectLiveBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivitySelectLiveBinding.java`

字段/常量（4）：
- `LinearLayout rootView`  L15
- `GridView selectLiveGrid`  L16
- `Toolbar selectToolBar`  L17
- `int i = R.id.select_live_grid`  L43

方法（5）：
- `private ActivitySelectLiveBinding(LinearLayout rootView, GridView selectLiveGrid, Toolbar selectToolBar)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `ActivitySelectLiveBinding inflate(LayoutInflater inflater)`  L30
- `ActivitySelectLiveBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ActivitySelectLiveBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.ActivitySelectLiveDeviceBinding`
L14 · [class] public abstract ActivitySelectLiveDeviceBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ActivitySelectLiveDeviceBinding.java`

字段/常量（3）：
- `Button btnConfirm`  L15
- `ImageView imgBack`  L16
- `RecyclerView recyclerView`  L17

方法（7）：
- `protected ActivitySelectLiveDeviceBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnConfirm, ImageView imgBack, RecyclerView recyclerView)`  L19
- `ActivitySelectLiveDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L26
- `ActivitySelectLiveDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L31 @Deprecated
- `ActivitySelectLiveDeviceBinding inflate(LayoutInflater inflater)`  L35
- `ActivitySelectLiveDeviceBinding inflate(LayoutInflater inflater, Object component)`  L40 @Deprecated
- `ActivitySelectLiveDeviceBinding bind(View view)`  L44
- `ActivitySelectLiveDeviceBinding bind(View view, Object component)`  L49 @Deprecated
### `com.gku.xtugo.databinding.ActivitySelectLiveDeviceBindingImpl`
L14 · [class] public ActivitySelectLiveDeviceBindingImpl · extends `ActivitySelectLiveDeviceBinding` · `com/gku/xtugo/databinding/ActivitySelectLiveDeviceBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L15
- `SparseIntArray sViewsWithIds`  L16
- `long mDirtyFlags`  L17
- `LinearLayout mboundView0`  L18

方法（7）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L21 @Override
- `boolean setVariable(int variableId, Object variable)`  L26 @Override
- `public ActivitySelectLiveDeviceBindingImpl(DataBindingComponent bindingComponent, View root)`  L38
- `private ActivitySelectLiveDeviceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L42
- `void invalidateAll()`  L53 @Override
- `boolean hasPendingBindings()`  L61 @Override
- `void executeBindings()`  L68 @Override
### `com.gku.xtugo.databinding.ActivitySelectLiveWifiBinding`
L18 · [class] public abstract ActivitySelectLiveWifiBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ActivitySelectLiveWifiBinding.java`

字段/常量（8）：
- `Button btnConnect`  L19
- `EditText evPassword`  L20
- `ImageView imgBack`  L21
- `ShimmerLayoutSimple layoutShimmer`  L22
- `LinearLayoutShape llSelectWifi`  L23
- `TextView manualInput`  L24
- `RecyclerView recyclerView`  L25
- `TextView tvSsid`  L26

方法（7）：
- `protected ActivitySelectLiveWifiBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnConnect, EditText evPassword, ImageView imgBack, ShimmerLayoutSimple layoutShimmer, LinearLayoutShape llSelectWifi, TextView manualInput, RecyclerView recyclerView, TextView tvSsid)`  L28
- `ActivitySelectLiveWifiBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L40
- `ActivitySelectLiveWifiBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L45 @Deprecated
- `ActivitySelectLiveWifiBinding inflate(LayoutInflater inflater)`  L49
- `ActivitySelectLiveWifiBinding inflate(LayoutInflater inflater, Object component)`  L54 @Deprecated
- `ActivitySelectLiveWifiBinding bind(View view)`  L58
- `ActivitySelectLiveWifiBinding bind(View view, Object component)`  L63 @Deprecated
### `com.gku.xtugo.databinding.ActivitySelectLiveWifiBindingImpl`
L18 · [class] public ActivitySelectLiveWifiBindingImpl · extends `ActivitySelectLiveWifiBinding` · `com/gku/xtugo/databinding/ActivitySelectLiveWifiBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L19
- `SparseIntArray sViewsWithIds`  L20
- `long mDirtyFlags`  L21
- `LinearLayout mboundView0`  L22

方法（7）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L25 @Override
- `boolean setVariable(int variableId, Object variable)`  L30 @Override
- `public ActivitySelectLiveWifiBindingImpl(DataBindingComponent bindingComponent, View root)`  L47
- `private ActivitySelectLiveWifiBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L51
- `void invalidateAll()`  L62 @Override
- `boolean hasPendingBindings()`  L70 @Override
- `void executeBindings()`  L77 @Override
### `com.gku.xtugo.databinding.ActivitySendSoftBinding`
L15 · [class] public final ActivitySendSoftBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivitySendSoftBinding.java`

字段/常量（8）：
- `View centerPoint`  L16
- `LayoutTitleBarBinding layoutTitle`  L17
- `RelativeLayout rootView`  L18
- `ImageView sendingImage`  L19
- `TextView sendingText`  L20
- `Button updateFinish`  L21
- `View viewFindChildViewById`  L50
- `int i = R.id.center_point`  L51

方法（5）：
- `private ActivitySendSoftBinding(RelativeLayout rootView, View centerPoint, LayoutTitleBarBinding layoutTitle, ImageView sendingImage, TextView sendingText, Button updateFinish)`  L23
- `RelativeLayout getRoot()`  L33 @Override
- `ActivitySendSoftBinding inflate(LayoutInflater inflater)`  L37
- `ActivitySendSoftBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `ActivitySendSoftBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.ActivitySSBluetoothTxBinding`
L14 · [class] public final ActivitySSBluetoothTxBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivitySSBluetoothTxBinding.java`

字段/常量（9）：
- `ImageView blackImg`  L15
- `ImageView ivSearch`  L16
- `LinearLayout rootView`  L17
- `TextView titleModeText`  L18
- `TextView tvBtTxName1`  L19
- `TextView tvBtTxName2`  L20
- `TextView tvBtTxStatus1`  L21
- `TextView tvBtTxStatus2`  L22
- `int i = R.id.blackImg`  L53

方法（5）：
- `private ActivitySSBluetoothTxBinding(LinearLayout rootView, ImageView blackImg, ImageView ivSearch, TextView titleModeText, TextView tvBtTxName1, TextView tvBtTxName2, TextView tvBtTxStatus1, TextView tvBtTxStatus2)`  L24
- `LinearLayout getRoot()`  L36 @Override
- `ActivitySSBluetoothTxBinding inflate(LayoutInflater inflater)`  L40
- `ActivitySSBluetoothTxBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L44
- `ActivitySSBluetoothTxBinding bind(View rootView)`  L52
### `com.gku.xtugo.databinding.ActivitySSCameraAboutBinding`
L16 · [class] public final ActivitySSCameraAboutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivitySSCameraAboutBinding.java`

字段/常量（30）：
- `View SsAboutCameraLine1`  L17
- `View SsAboutCameraLine2`  L18
- `View SsAboutCameraLine3`  L19
- `View SsAboutCameraLine4`  L20
- `View SsAboutCameraLine5`  L21
- `View SsAboutCameraLine6`  L22
- `View SsAboutCameraLine7`  L23
- `LinearLayout bluetoothTxoneversion`  L24
- `TextView bluetoothTxoneversionName`  L25
- `LinearLayout bluetoothTxtwoversion`  L26
- `TextView bluetoothTxtwoversionName`  L27
- `ConstraintLayout bluetoothVersion`  L28
- `TextView bluetoothVersionName`  L29
- `ConstraintLayout clearCache`  L30
- `TextView clearCacheSize`  L31
- `LinearLayout layoutData`  L32
- `ConstraintLayout rootView`  L33
- `TextView ssAboutCameraAppVersion`  L34
- `TextView ssAboutCameraFwVersion`  L35
- `ImageView ssAboutCameraLogoIcon`  L36
- `ImageView ssAboutCameraLogoMain`  L37
- `Toolbar ssAboutCameraTool`  L38
- `TextView ssAboutCameraVersionDate`  L39
- `View viewFindChildViewById`  L85
- `View viewFindChildViewById2`  L86
- `View viewFindChildViewById3`  L87
- `View viewFindChildViewById4`  L88
- `View viewFindChildViewById5`  L89
- `View viewFindChildViewById6`  L90
- `int i = R.id._ss_about_camera_line1`  L91

方法（5）：
- `private ActivitySSCameraAboutBinding(ConstraintLayout rootView, View SsAboutCameraLine1, View SsAboutCameraLine2, View SsAboutCameraLine3, View SsAboutCameraLine4, View SsAboutCameraLine5, View SsAboutCameraLine6, View SsAboutCameraLine7, LinearLayout bluetoothTxoneversion, TextView bluetoothTxoneversionName, LinearLayout bluetoothTxtwoversion, TextView bluetoothTxtwoversionName, ConstraintLayout bluetoothVersion, TextView bluetoothVersionName, ConstraintLayout clearCache, TextView clearCacheSize, LinearLayout layoutData, TextView ssAboutCameraAppVersion, TextView ssAboutCameraFwVersion, ImageView ssAboutCameraLogoIcon, ImageView ssAboutCameraLogoMain, Toolbar ssAboutCameraTool, TextView ssAboutCameraVersionDate)`  L41
- `ConstraintLayout getRoot()`  L68 @Override
- `ActivitySSCameraAboutBinding inflate(LayoutInflater inflater)`  L72
- `ActivitySSCameraAboutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L76
- `ActivitySSCameraAboutBinding bind(View rootView)`  L84
### `com.gku.xtugo.databinding.ActivitySSDeviceSettingBinding`
L15 · [class] public final ActivitySSDeviceSettingBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivitySSDeviceSettingBinding.java`

字段/常量（5）：
- `ImageView blackImg`  L16
- `LinearLayout rootView`  L17
- `RecyclerView ssDeviceSettingRecycle`  L18
- `TextView titleModeText`  L19
- `int i = R.id.blackImg`  L46

方法（5）：
- `private ActivitySSDeviceSettingBinding(LinearLayout rootView, ImageView blackImg, RecyclerView ssDeviceSettingRecycle, TextView titleModeText)`  L21
- `LinearLayout getRoot()`  L29 @Override
- `ActivitySSDeviceSettingBinding inflate(LayoutInflater inflater)`  L33
- `ActivitySSDeviceSettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `ActivitySSDeviceSettingBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.ActivitySSModeSettingBinding`
L16 · [class] public final ActivitySSModeSettingBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivitySSModeSettingBinding.java`

字段/常量（7）：
- `ShimmerLayoutSimple ShimmerLayoutSimple`  L17
- `ImageView blackImg`  L18
- `TextView enterDeviceSett`  L19
- `LinearLayout rootView`  L20
- `RecyclerView ssModeSettingRecycle`  L21
- `TextView titleModeText`  L22
- `int i = R.id.ShimmerLayoutSimple`  L51

方法（5）：
- `private ActivitySSModeSettingBinding(LinearLayout rootView, ShimmerLayoutSimple ShimmerLayoutSimple, ImageView blackImg, TextView enterDeviceSett, RecyclerView ssModeSettingRecycle, TextView titleModeText)`  L24
- `LinearLayout getRoot()`  L34 @Override
- `ActivitySSModeSettingBinding inflate(LayoutInflater inflater)`  L38
- `ActivitySSModeSettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L42
- `ActivitySSModeSettingBinding bind(View rootView)`  L50
### `com.gku.xtugo.databinding.ActivitySSPhotoRemotePlayBinding`
L14 · [class] public final ActivitySSPhotoRemotePlayBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivitySSPhotoRemotePlayBinding.java`

字段/常量（4）：
- `ViewPager2 ViewPager2`  L15
- `FrameLayout rootView`  L16
- `Toolbar ssRemotePhotoToolbar`  L17
- `int i = R.id.ViewPager2`  L43

方法（5）：
- `private ActivitySSPhotoRemotePlayBinding(FrameLayout rootView, ViewPager2 ViewPager2, Toolbar ssRemotePhotoToolbar)`  L19
- `FrameLayout getRoot()`  L26 @Override
- `ActivitySSPhotoRemotePlayBinding inflate(LayoutInflater inflater)`  L30
- `ActivitySSPhotoRemotePlayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ActivitySSPhotoRemotePlayBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.ActivitySSPlaybackBinding`
L15 · [class] public final ActivitySSPlaybackBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivitySSPlaybackBinding.java`

字段/常量（5）：
- `LinearLayout rootView`  L16
- `SegmentTabLayout ssPlaybackTab`  L17
- `Toolbar ssPlaybackTool`  L18
- `ViewPager2 ssPlaybackViewPager`  L19
- `int i = R.id.ss_playback_tab`  L46

方法（5）：
- `private ActivitySSPlaybackBinding(LinearLayout rootView, SegmentTabLayout ssPlaybackTab, Toolbar ssPlaybackTool, ViewPager2 ssPlaybackViewPager)`  L21
- `LinearLayout getRoot()`  L29 @Override
- `ActivitySSPlaybackBinding inflate(LayoutInflater inflater)`  L33
- `ActivitySSPlaybackBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `ActivitySSPlaybackBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.ActivitySSVideoRemotePlayBinding`
L14 · [class] public final ActivitySSVideoRemotePlayBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivitySSVideoRemotePlayBinding.java`

字段/常量（4）：
- `FrameLayout rootView`  L15
- `Toolbar ssVideoRemotePlayTool`  L16
- `SSVideoView videoRemotePlayVideo`  L17
- `int i = R.id.ss_video_remote_play_tool`  L43

方法（5）：
- `private ActivitySSVideoRemotePlayBinding(FrameLayout rootView, Toolbar ssVideoRemotePlayTool, SSVideoView videoRemotePlayVideo)`  L19
- `FrameLayout getRoot()`  L26 @Override
- `ActivitySSVideoRemotePlayBinding inflate(LayoutInflater inflater)`  L30
- `ActivitySSVideoRemotePlayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ActivitySSVideoRemotePlayBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.ActivityStreamBinding`
L12 · [class] public final ActivityStreamBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityStreamBinding.java`

字段/常量（3）：
- `FrameLayout rootView`  L13
- `FrameLayout streamSettingViewContainer`  L14
- `int i = R.id.stream_setting_view_container`  L39

方法（5）：
- `private ActivityStreamBinding(FrameLayout rootView, FrameLayout streamSettingViewContainer)`  L16
- `FrameLayout getRoot()`  L22 @Override
- `ActivityStreamBinding inflate(LayoutInflater inflater)`  L26
- `ActivityStreamBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L30
- `ActivityStreamBinding bind(View rootView)`  L38
### `com.gku.xtugo.databinding.ActivityStreamDemoBinding`
L20 · [class] public final ActivityStreamDemoBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityStreamDemoBinding.java`

字段/常量（24）：
- `Button authBtn`  L21
- `LinearLayout broadcastOption`  L22
- `RadioButton camTypeApp`  L23
- `RadioButton camTypeHardware`  L24
- `RadioGroup camTypeRg`  L25
- `LinearLayout gameBroadcastOption`  L26
- `Button initBtn`  L27
- `AppCompatCheckBox liveAgreement`  L28
- `RadioButton liveType180`  L29
- `RadioButton liveType360`  L30
- `RadioButton liveTypeFlat`  L31
- `RadioGroup liveTypeRg`  L32
- `Button meBtn`  L33
- `ImageView qrcode`  L34
- `Button quitBtn`  L35
- `TextView resultConsole`  L36
- `FrameLayout rootView`  L37
- `Button startBroadcast`  L38
- `Button streamQuit`  L39
- `Button streamSetting`  L40
- `FrameLayout streamSettingViewContainer`  L41
- `Button streamToken`  L42
- `Switch switchToGame`  L43
- `int i = R.id.auth_btn`  L89

方法（5）：
- `private ActivityStreamDemoBinding(FrameLayout rootView, Button authBtn, LinearLayout broadcastOption, RadioButton camTypeApp, RadioButton camTypeHardware, RadioGroup camTypeRg, LinearLayout gameBroadcastOption, Button initBtn, AppCompatCheckBox liveAgreement, RadioButton liveType180, RadioButton liveType360, RadioButton liveTypeFlat, RadioGroup liveTypeRg, Button meBtn, ImageView qrcode, Button quitBtn, TextView resultConsole, Button startBroadcast, Button streamQuit, Button streamSetting, FrameLayout streamSettingViewContainer, Button streamToken, Switch switchToGame)`  L45
- `FrameLayout getRoot()`  L72 @Override
- `ActivityStreamDemoBinding inflate(LayoutInflater inflater)`  L76
- `ActivityStreamDemoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L80
- `ActivityStreamDemoBinding bind(View rootView)`  L88
### `com.gku.xtugo.databinding.ActivityStreamingBinding`
L15 · [class] public final ActivityStreamingBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityStreamingBinding.java`

字段/常量（5）：
- `ImageView blackImg`  L16
- `LinearLayout rootView`  L17
- `MaterialButton streamEnd`  L18
- `TextView tvTimer`  L19
- `int i = R.id.blackImg`  L46

方法（5）：
- `private ActivityStreamingBinding(LinearLayout rootView, ImageView blackImg, MaterialButton streamEnd, TextView tvTimer)`  L21
- `LinearLayout getRoot()`  L29 @Override
- `ActivityStreamingBinding inflate(LayoutInflater inflater)`  L33
- `ActivityStreamingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `ActivityStreamingBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.ActivityStreamSettingFirstBinding`
L15 · [class] public final ActivityStreamSettingFirstBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityStreamSettingFirstBinding.java`

字段/常量（5）：
- `VerticalRecyclerView VerticalRecyclerView`  L16
- `ImageView blackImg`  L17
- `LinearLayout rootView`  L18
- `MaterialButton streamSetting`  L19
- `int i = R.id.VerticalRecyclerView`  L46

方法（5）：
- `private ActivityStreamSettingFirstBinding(LinearLayout rootView, VerticalRecyclerView VerticalRecyclerView, ImageView blackImg, MaterialButton streamSetting)`  L21
- `LinearLayout getRoot()`  L29 @Override
- `ActivityStreamSettingFirstBinding inflate(LayoutInflater inflater)`  L33
- `ActivityStreamSettingFirstBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `ActivityStreamSettingFirstBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.ActivityStreamSettingSecondBinding`
L19 · [class] public final ActivityStreamSettingSecondBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityStreamSettingSecondBinding.java`

字段/常量（31）：
- `ImageView blackImg`  L20
- `TextView cancelAuthor`  L21
- `ImageView imgCheck`  L22
- `ImageView imgDeviceConnect`  L23
- `TextView imgDeviceConnectDot`  L24
- `ImageView imgWifiConnect`  L25
- `LinearLayout llBStatus`  L26
- `LinearLayoutShape llConnectWifi`  L27
- `LinearLayoutShape llSelectDevice`  L28
- `RadioButtonSelector rbs1080`  L29
- `RadioButtonSelector rbs25`  L30
- `RadioButtonSelector rbs30`  L31
- `RadioButtonSelector rbs720`  L32
- `RadioButtonSelector rbsFlu`  L33
- `RadioButtonSelector rbsHigh`  L34
- `RadioGroup rgBs`  L35
- `RadioGroup rgFps`  L36
- `RadioGroup rgResolution`  L37
- `LinearLayout rootView`  L38
- `Button streamEnd`  L39
- `MaterialButton streamStart`  L40
- `TextView switchDevice`  L41
- `TextView switchWifi`  L42
- `TextView tvAgreement`  L43
- `TextView tvBStatus`  L44
- `TextView tvConnectHint`  L45
- `TextView tvDeviceConnectStatus`  L46
- `TextView tvSelectDevice`  L47
- `TextView tvWifConnectDot`  L48
- `TextView tvWifiConnectStatus`  L49
- `int i = R.id.blackImg`  L102

方法（5）：
- `private ActivityStreamSettingSecondBinding(LinearLayout rootView, ImageView blackImg, TextView cancelAuthor, ImageView imgCheck, ImageView imgDeviceConnect, TextView imgDeviceConnectDot, ImageView imgWifiConnect, LinearLayout llBStatus, LinearLayoutShape llConnectWifi, LinearLayoutShape llSelectDevice, RadioButtonSelector rbs1080, RadioButtonSelector rbs25, RadioButtonSelector rbs30, RadioButtonSelector rbs720, RadioButtonSelector rbsFlu, RadioButtonSelector rbsHigh, RadioGroup rgBs, RadioGroup rgFps, RadioGroup rgResolution, Button streamEnd, MaterialButton streamStart, TextView switchDevice, TextView switchWifi, TextView tvAgreement, TextView tvBStatus, TextView tvConnectHint, TextView tvDeviceConnectStatus, TextView tvSelectDevice, TextView tvWifConnectDot, TextView tvWifiConnectStatus)`  L51
- `LinearLayout getRoot()`  L85 @Override
- `ActivityStreamSettingSecondBinding inflate(LayoutInflater inflater)`  L89
- `ActivityStreamSettingSecondBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L93
- `ActivityStreamSettingSecondBinding bind(View rootView)`  L101
### `com.gku.xtugo.databinding.ActivityStreamSettingSecondRtmpBinding`
L19 · [class] public final ActivityStreamSettingSecondRtmpBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityStreamSettingSecondRtmpBinding.java`

字段/常量（20）：
- `ImageView blackImg`  L20
- `EditText etRtmp`  L21
- `LinearLayout layoutContent`  L22
- `LinearLayoutShape llConnectWifi`  L23
- `LinearLayoutShape llSelectDevice`  L24
- `RadioButtonSelector rbs1080`  L25
- `RadioButtonSelector rbs25`  L26
- `RadioButtonSelector rbs30`  L27
- `RadioButtonSelector rbs720`  L28
- `RadioButtonSelector rbsFlu`  L29
- `RadioButtonSelector rbsHigh`  L30
- `RadioGroup rgBs`  L31
- `RadioGroup rgFps`  L32
- `RadioGroup rgResolution`  L33
- `LinearLayout rootView`  L34
- `MaterialButton streamStart`  L35
- `TextView switchDevice`  L36
- `TextView tvConnectHint`  L37
- `TextView tvSelectDevice`  L38
- `int i = R.id.blackImg`  L80

方法（5）：
- `private ActivityStreamSettingSecondRtmpBinding(LinearLayout rootView, ImageView blackImg, EditText etRtmp, LinearLayout layoutContent, LinearLayoutShape llConnectWifi, LinearLayoutShape llSelectDevice, RadioButtonSelector rbs1080, RadioButtonSelector rbs25, RadioButtonSelector rbs30, RadioButtonSelector rbs720, RadioButtonSelector rbsFlu, RadioButtonSelector rbsHigh, RadioGroup rgBs, RadioGroup rgFps, RadioGroup rgResolution, MaterialButton streamStart, TextView switchDevice, TextView tvConnectHint, TextView tvSelectDevice)`  L40
- `LinearLayout getRoot()`  L63 @Override
- `ActivityStreamSettingSecondRtmpBinding inflate(LayoutInflater inflater)`  L67
- `ActivityStreamSettingSecondRtmpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L71
- `ActivityStreamSettingSecondRtmpBinding bind(View rootView)`  L79
### `com.gku.xtugo.databinding.ActivityStreamSettingThirdBinding`
L15 · [class] public final ActivityStreamSettingThirdBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityStreamSettingThirdBinding.java`

字段/常量（7）：
- `ImageView blackImg`  L16
- `LinearLayout rootView`  L17
- `MaterialButton streamEnd`  L18
- `MaterialButton streamStart`  L19
- `TextView tvLog`  L20
- `TextView tvNotReady`  L21
- `int i = R.id.blackImg`  L50

方法（5）：
- `private ActivityStreamSettingThirdBinding(LinearLayout rootView, ImageView blackImg, MaterialButton streamEnd, MaterialButton streamStart, TextView tvLog, TextView tvNotReady)`  L23
- `LinearLayout getRoot()`  L33 @Override
- `ActivityStreamSettingThirdBinding inflate(LayoutInflater inflater)`  L37
- `ActivityStreamSettingThirdBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `ActivityStreamSettingThirdBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.ActivityStreamWifiBinding`
L15 · [class] public final ActivityStreamWifiBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityStreamWifiBinding.java`

字段/常量（5）：
- `LinearRefreshLayout LinearRefreshLayout`  L16
- `ShimmerLayoutSimple ShimmerLayoutSimple`  L17
- `ImageView blackImg`  L18
- `LinearLayout rootView`  L19
- `int i = R.id.LinearRefreshLayout`  L46

方法（5）：
- `private ActivityStreamWifiBinding(LinearLayout rootView, LinearRefreshLayout LinearRefreshLayout, ShimmerLayoutSimple ShimmerLayoutSimple, ImageView blackImg)`  L21
- `LinearLayout getRoot()`  L29 @Override
- `ActivityStreamWifiBinding inflate(LayoutInflater inflater)`  L33
- `ActivityStreamWifiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `ActivityStreamWifiBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.ActivityStreamWifiTypeinBinding`
L15 · [class] public final ActivityStreamWifiTypeinBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityStreamWifiTypeinBinding.java`

字段/常量（6）：
- `ImageView blackImg`  L16
- `MaterialButton confirmWifi`  L17
- `EditText evPassword`  L18
- `EditText evSsid`  L19
- `LinearLayout rootView`  L20
- `int i = R.id.blackImg`  L48

方法（5）：
- `private ActivityStreamWifiTypeinBinding(LinearLayout rootView, ImageView blackImg, MaterialButton confirmWifi, EditText evPassword, EditText evSsid)`  L22
- `LinearLayout getRoot()`  L31 @Override
- `ActivityStreamWifiTypeinBinding inflate(LayoutInflater inflater)`  L35
- `ActivityStreamWifiTypeinBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `ActivityStreamWifiTypeinBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.ActivityTelevisionBinding`
L15 · [class] public final ActivityTelevisionBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityTelevisionBinding.java`

字段/常量（11）：
- `ImageView imageCover`  L16
- `ImageView imageLogo`  L17
- `ImageView imagePower`  L18
- `ImageView imageView1`  L19
- `ImageView imageView2`  L20
- `ImageView imageView3`  L21
- `ImageView imageView4`  L22
- `ProgressBar pbWakingProgress`  L23
- `LinearLayout rootView`  L24
- `SurfaceView surfaceView`  L25
- `int i = R.id.imageCover`  L58

方法（5）：
- `private ActivityTelevisionBinding(LinearLayout rootView, ImageView imageCover, ImageView imageLogo, ImageView imagePower, ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4, ProgressBar pbWakingProgress, SurfaceView surfaceView)`  L27
- `LinearLayout getRoot()`  L41 @Override
- `ActivityTelevisionBinding inflate(LayoutInflater inflater)`  L45
- `ActivityTelevisionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L49
- `ActivityTelevisionBinding bind(View rootView)`  L57
### `com.gku.xtugo.databinding.ActivityTrackBinding`
L19 · [class] public final ActivityTrackBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityTrackBinding.java`

字段/常量（20）：
- `LinearLayout bottomButton`  L20
- `MapView gaodeMapView`  L21
- `com.google.android.gms.maps.MapView googleMapView`  L22
- `ConstraintLayout gpsInfoConstraint`  L23
- `TextView latitudeText`  L24
- `TextView longtitudeText`  L25
- `VideoView mapVideoView`  L26
- `LinearLayout rootView`  L27
- `TextView speedText`  L28
- `ConstraintLayout sr`  L29
- `Button srExport`  L30
- `Button srShow`  L31
- `LinearLayout topButton`  L32
- `ImageView trackBackImage`  L33
- `LinearLayout trackContentSll`  L34
- `TextView trackVideoName`  L35
- `ImageView videoFullScreen`  L36
- `SeekBar videoSeek`  L37
- `ImageView videoStart`  L38
- `int i = R.id.bottom_button`  L80

方法（5）：
- `private ActivityTrackBinding(LinearLayout rootView, LinearLayout bottomButton, MapView gaodeMapView, com.google.android.gms.maps.MapView googleMapView, ConstraintLayout gpsInfoConstraint, TextView latitudeText, TextView longtitudeText, VideoView mapVideoView, TextView speedText, ConstraintLayout sr, Button srExport, Button srShow, LinearLayout topButton, ImageView trackBackImage, LinearLayout trackContentSll, TextView trackVideoName, ImageView videoFullScreen, SeekBar videoSeek, ImageView videoStart)`  L40
- `LinearLayout getRoot()`  L63 @Override
- `ActivityTrackBinding inflate(LayoutInflater inflater)`  L67
- `ActivityTrackBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L71
- `ActivityTrackBinding bind(View rootView)`  L79
### `com.gku.xtugo.databinding.ActivityTrackLandBinding`
L17 · [class] public final ActivityTrackLandBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityTrackLandBinding.java`

字段/常量（10）：
- `LinearLayout bottomButton`  L18
- `VideoView mapVideoView`  L19
- `ConstraintLayout rootView`  L20
- `LinearLayout topButton`  L21
- `ImageView trackBackImage`  L22
- `TextView trackVideoName`  L23
- `ImageView videoFullScreen`  L24
- `SeekBar videoSeek`  L25
- `ImageView videoStart`  L26
- `int i = R.id.bottom_button`  L58

方法（5）：
- `private ActivityTrackLandBinding(ConstraintLayout rootView, LinearLayout bottomButton, VideoView mapVideoView, LinearLayout topButton, ImageView trackBackImage, TextView trackVideoName, ImageView videoFullScreen, SeekBar videoSeek, ImageView videoStart)`  L28
- `ConstraintLayout getRoot()`  L41 @Override
- `ActivityTrackLandBinding inflate(LayoutInflater inflater)`  L45
- `ActivityTrackLandBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L49
- `ActivityTrackLandBinding bind(View rootView)`  L57
### `com.gku.xtugo.databinding.ActivityUploadFirmwareBinding`
L13 · [class] public final ActivityUploadFirmwareBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityUploadFirmwareBinding.java`

字段/常量（3）：
- `ListView listViewPackage`  L14
- `RelativeLayout rootView`  L15
- `int i = R.id.listViewPackage`  L40

方法（5）：
- `private ActivityUploadFirmwareBinding(RelativeLayout rootView, ListView listViewPackage)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `ActivityUploadFirmwareBinding inflate(LayoutInflater inflater)`  L27
- `ActivityUploadFirmwareBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `ActivityUploadFirmwareBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.ActivityUserInfoBinding`
L14 · [class] public abstract ActivityUserInfoBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ActivityUserInfoBinding.java`

字段/常量（2）：
- `UserInfoViewModel mUserInfoViewModel`  L17 @Bindable
- `MaterialToolbar toolbarUserInfo`  L18

方法（9）：
- `void setUserInfoViewModel(UserInfoViewModel userInfoViewModel)`  L20
- `protected ActivityUserInfoBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialToolbar toolbarUserInfo)`  L22
- `UserInfoViewModel getUserInfoViewModel()`  L27
- `ActivityUserInfoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L31
- `ActivityUserInfoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L36 @Deprecated
- `ActivityUserInfoBinding inflate(LayoutInflater inflater)`  L40
- `ActivityUserInfoBinding inflate(LayoutInflater inflater, Object component)`  L45 @Deprecated
- `ActivityUserInfoBinding bind(View view)`  L49
- `ActivityUserInfoBinding bind(View view, Object component)`  L54 @Deprecated
### `com.gku.xtugo.databinding.ActivityUserInfoBindingImpl`
L13 · [class] public ActivityUserInfoBindingImpl · extends `ActivityUserInfoBinding` · `com/gku/xtugo/databinding/ActivityUserInfoBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L14
- `SparseIntArray sViewsWithIds`  L15
- `long mDirtyFlags`  L16
- `LinearLayout mboundView0`  L17

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L20 @Override
- `public ActivityUserInfoBindingImpl(DataBindingComponent bindingComponent, View root)`  L30
- `private ActivityUserInfoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L34
- `void invalidateAll()`  L45 @Override
- `boolean hasPendingBindings()`  L53 @Override
- `boolean setVariable(int variableId, Object variable)`  L60 @Override
- `void setUserInfoViewModel(UserInfoViewModel UserInfoViewModel)`  L69 @Override
- `void executeBindings()`  L74 @Override
### `com.gku.xtugo.databinding.ActivityVideoPb2Binding`
L11 · [class] public final ActivityVideoPb2Binding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityVideoPb2Binding.java`

字段/常量（1）：
- `CoordinatorLayout rootView`  L12

方法（5）：
- `private ActivityVideoPb2Binding(CoordinatorLayout rootView)`  L14
- `CoordinatorLayout getRoot()`  L19 @Override
- `ActivityVideoPb2Binding inflate(LayoutInflater inflater)`  L23
- `ActivityVideoPb2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L27
- `ActivityVideoPb2Binding bind(View rootView)`  L35
    - 体内字面量："rootView"
### `com.gku.xtugo.databinding.ActivityVideoShareBinding`
L16 · [class] public final ActivityVideoShareBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityVideoShareBinding.java`

字段/常量（9）：
- `ImageView ivBack`  L17
- `ConstraintLayout rootView`  L18
- `SeekBar sbVideo`  L19
- `TextView tvSave`  L20
- `TextView tvShare`  L21
- `TextView tvTime`  L22
- `TextView tvTitle`  L23
- `MyVideoView videoview`  L24
- `int i = R.id.iv_back`  L55

方法（5）：
- `private ActivityVideoShareBinding(ConstraintLayout rootView, ImageView ivBack, SeekBar sbVideo, TextView tvSave, TextView tvShare, TextView tvTime, TextView tvTitle, MyVideoView videoview)`  L26
- `ConstraintLayout getRoot()`  L38 @Override
- `ActivityVideoShareBinding inflate(LayoutInflater inflater)`  L42
- `ActivityVideoShareBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `ActivityVideoShareBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.ActivityWebBinding`
L14 · [class] public abstract ActivityWebBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ActivityWebBinding.java`

字段/常量（3）：
- `WebView announcementWebView`  L15
- `MaterialToolbar toolbar`  L16
- `TextView tvWebViewTitle`  L17

方法（7）：
- `protected ActivityWebBinding(Object _bindingComponent, View _root, int _localFieldCount, WebView announcementWebView, MaterialToolbar toolbar, TextView tvWebViewTitle)`  L19
- `ActivityWebBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L26
- `ActivityWebBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L31 @Deprecated
- `ActivityWebBinding inflate(LayoutInflater inflater)`  L35
- `ActivityWebBinding inflate(LayoutInflater inflater, Object component)`  L40 @Deprecated
- `ActivityWebBinding bind(View view)`  L44
- `ActivityWebBinding bind(View view, Object component)`  L49 @Deprecated
### `com.gku.xtugo.databinding.ActivityWebBindingImpl`
L14 · [class] public ActivityWebBindingImpl · extends `ActivityWebBinding` · `com/gku/xtugo/databinding/ActivityWebBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L15
- `SparseIntArray sViewsWithIds`  L16
- `long mDirtyFlags`  L17
- `LinearLayout mboundView0`  L18

方法（7）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L21 @Override
- `boolean setVariable(int variableId, Object variable)`  L26 @Override
- `public ActivityWebBindingImpl(DataBindingComponent bindingComponent, View root)`  L38
- `private ActivityWebBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L42
- `void invalidateAll()`  L53 @Override
- `boolean hasPendingBindings()`  L61 @Override
- `void executeBindings()`  L68 @Override
### `com.gku.xtugo.databinding.ActivityWebviewBinding`
L14 · [class] public final ActivityWebviewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityWebviewBinding.java`

字段/常量（4）：
- `ProgressBar progressbar`  L15
- `FrameLayout rootView`  L16
- `WebView webview`  L17
- `int i = R.id.progressbar`  L43

方法（5）：
- `private ActivityWebviewBinding(FrameLayout rootView, ProgressBar progressbar, WebView webview)`  L19
- `FrameLayout getRoot()`  L26 @Override
- `ActivityWebviewBinding inflate(LayoutInflater inflater)`  L30
- `ActivityWebviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ActivityWebviewBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.ActivityWifiChannelBinding`
L15 · [class] public final ActivityWifiChannelBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ActivityWifiChannelBinding.java`

字段/常量（5）：
- `Button btnSetWifiChannel`  L16
- `EditText editWifiChannel`  L17
- `LinearLayout rootView`  L18
- `TextView textWifiChannel`  L19
- `int i = R.id.btnSetWifiChannel`  L46

方法（5）：
- `private ActivityWifiChannelBinding(LinearLayout rootView, Button btnSetWifiChannel, EditText editWifiChannel, TextView textWifiChannel)`  L21
- `LinearLayout getRoot()`  L29 @Override
- `ActivityWifiChannelBinding inflate(LayoutInflater inflater)`  L33
- `ActivityWifiChannelBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `ActivityWifiChannelBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.AlertdialogProgressBinding`
L14 · [class] public final AlertdialogProgressBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/AlertdialogProgressBinding.java`

字段/常量（5）：
- `ProgressBar pbDialogProgress`  L15
- `LinearLayout rootView`  L16
- `TextView tvDialogMessage01`  L17
- `TextView tvDialogTitle01`  L18
- `int i = R.id.pbDialogProgress`  L45

方法（5）：
- `private AlertdialogProgressBinding(LinearLayout rootView, ProgressBar pbDialogProgress, TextView tvDialogMessage01, TextView tvDialogTitle01)`  L20
- `LinearLayout getRoot()`  L28 @Override
- `AlertdialogProgressBinding inflate(LayoutInflater inflater)`  L32
- `AlertdialogProgressBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `AlertdialogProgressBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.AutoDownloadLayoutSizeBinding`
L14 · [class] public final AutoDownloadLayoutSizeBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/AutoDownloadLayoutSizeBinding.java`

字段/常量（4）：
- `EditText downloadSize`  L15
- `TextView itemText`  L16
- `RelativeLayout rootView`  L17
- `int i = R.id.download_size`  L43

方法（5）：
- `private AutoDownloadLayoutSizeBinding(RelativeLayout rootView, EditText downloadSize, TextView itemText)`  L19
- `RelativeLayout getRoot()`  L26 @Override
- `AutoDownloadLayoutSizeBinding inflate(LayoutInflater inflater)`  L30
- `AutoDownloadLayoutSizeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `AutoDownloadLayoutSizeBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.BottomButtomItemLayoutBinding`
L14 · [class] public final BottomButtomItemLayoutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/BottomButtomItemLayoutBinding.java`

字段/常量（4）：
- `TextView btnText`  L15
- `ImageView ivButton`  L16
- `RelativeLayout rootView`  L17
- `int i = R.id.btn_text`  L43

方法（5）：
- `private BottomButtomItemLayoutBinding(RelativeLayout rootView, TextView btnText, ImageView ivButton)`  L19
- `RelativeLayout getRoot()`  L26 @Override
- `BottomButtomItemLayoutBinding inflate(LayoutInflater inflater)`  L30
- `BottomButtomItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `BottomButtomItemLayoutBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.CameraGroupLayoutBinding`
L14 · [class] public final CameraGroupLayoutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/CameraGroupLayoutBinding.java`

字段/常量（5）：
- `ImageView cameraIc`  L15
- `TextView cameraNameText`  L16
- `RelativeLayout relat`  L17
- `RelativeLayout rootView`  L18
- `int i = R.id.camera_ic`  L45

方法（5）：
- `private CameraGroupLayoutBinding(RelativeLayout rootView, ImageView cameraIc, TextView cameraNameText, RelativeLayout relat)`  L20
- `RelativeLayout getRoot()`  L28 @Override
- `CameraGroupLayoutBinding inflate(LayoutInflater inflater)`  L32
- `CameraGroupLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `CameraGroupLayoutBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.CameraNamePasswordSetBinding`
L13 · [class] public final CameraNamePasswordSetBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/CameraNamePasswordSetBinding.java`

字段/常量（4）：
- `EditText cameraName`  L14
- `LinearLayout rootView`  L15
- `EditText wifiPassword`  L16
- `int i = R.id.camera_name`  L42

方法（5）：
- `private CameraNamePasswordSetBinding(LinearLayout rootView, EditText cameraName, EditText wifiPassword)`  L18
- `LinearLayout getRoot()`  L25 @Override
- `CameraNamePasswordSetBinding inflate(LayoutInflater inflater)`  L29
- `CameraNamePasswordSetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `CameraNamePasswordSetBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.CamerModeSwitchLayoutBinding`
L13 · [class] public final CamerModeSwitchLayoutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/CamerModeSwitchLayoutBinding.java`

字段/常量（5）：
- `RadioButton captureRadio`  L14
- `LinearLayout rootView`  L15
- `RadioButton timeLapseRadio`  L16
- `RadioButton videoRadio`  L17
- `int i = R.id.capture_radio`  L44

方法（5）：
- `private CamerModeSwitchLayoutBinding(LinearLayout rootView, RadioButton captureRadio, RadioButton timeLapseRadio, RadioButton videoRadio)`  L19
- `LinearLayout getRoot()`  L27 @Override
- `CamerModeSwitchLayoutBinding inflate(LayoutInflater inflater)`  L31
- `CamerModeSwitchLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L35
- `CamerModeSwitchLayoutBinding bind(View rootView)`  L43
### `com.gku.xtugo.databinding.CheckInternetBinding`
L13 · [class] public final CheckInternetBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/CheckInternetBinding.java`

字段/常量（3）：
- `TextView dlgFragMsg`  L14
- `LinearLayout rootView`  L15
- `int i = R.id.dlgFragMsg`  L40

方法（5）：
- `private CheckInternetBinding(LinearLayout rootView, TextView dlgFragMsg)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `CheckInternetBinding inflate(LayoutInflater inflater)`  L27
- `CheckInternetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `CheckInternetBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.CommonLayoutProgressDialogFullscreenBinding`
L11 · [class] public final CommonLayoutProgressDialogFullscreenBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/CommonLayoutProgressDialogFullscreenBinding.java`

字段/常量（1）：
- `LinearLayout rootView`  L12

方法（5）：
- `private CommonLayoutProgressDialogFullscreenBinding(LinearLayout rootView)`  L14
- `LinearLayout getRoot()`  L19 @Override
- `CommonLayoutProgressDialogFullscreenBinding inflate(LayoutInflater inflater)`  L23
- `CommonLayoutProgressDialogFullscreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L27
- `CommonLayoutProgressDialogFullscreenBinding bind(View rootView)`  L35
    - 体内字面量："rootView"
### `com.gku.xtugo.databinding.ContentDownloadSizeDialogBinding`
L13 · [class] public final ContentDownloadSizeDialogBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ContentDownloadSizeDialogBinding.java`

字段/常量（3）：
- `EditText downloadSize`  L14
- `RelativeLayout rootView`  L15
- `int i = R.id.download_size`  L40

方法（5）：
- `private ContentDownloadSizeDialogBinding(RelativeLayout rootView, EditText downloadSize)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `ContentDownloadSizeDialogBinding inflate(LayoutInflater inflater)`  L27
- `ContentDownloadSizeDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `ContentDownloadSizeDialogBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.ContentMultiPbBinding`
L13 · [class] public final ContentMultiPbBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ContentMultiPbBinding.java`

字段/常量（3）：
- `LinearLayout rootView`  L14
- `ViewPager vPager`  L15
- `int i = R.id.vPager`  L40

方法（5）：
- `private ContentMultiPbBinding(LinearLayout rootView, ViewPager vPager)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `ContentMultiPbBinding inflate(LayoutInflater inflater)`  L27
- `ContentMultiPbBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `ContentMultiPbBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.ContentPanoramaVideoPbBinding`
L20 · [class] public final ContentPanoramaVideoPbBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ContentPanoramaVideoPbBinding.java`

字段/常量（20）：
- `ImageButton cancelBtn`  L21
- `ImageView contentDelete`  L22
- `TextView deleteTxv`  L23
- `ImageButton download`  L24
- `Switch eisSwitch`  L25
- `SurfaceView mSurfaceView`  L26
- `ImageButton moreBtn`  L27
- `LinearLayout moreSettingLayout`  L28
- `ImageButton panoramaTypeBtn`  L29
- `RelativeLayout rootView`  L30
- `ImageButton videoPbBack`  L31
- `LinearLayout videoPbBottomLayout`  L32
- `ImageButton videoPbPlayBtn`  L33
- `SeekBar videoPbSeekBar`  L34
- `ProgressWheel videoPbSpinner`  L35
- `TextView videoPbTimeDuration`  L36
- `TextView videoPbTimeLapsed`  L37
- `LinearLayout videoPbTopLayout`  L38
- `TextView videoPbVideoName`  L39
- `int i = R.id.cancel_btn`  L81

方法（5）：
- `private ContentPanoramaVideoPbBinding(RelativeLayout rootView, ImageButton cancelBtn, ImageView contentDelete, TextView deleteTxv, ImageButton download, Switch eisSwitch, SurfaceView mSurfaceView, ImageButton moreBtn, LinearLayout moreSettingLayout, ImageButton panoramaTypeBtn, ImageButton videoPbBack, LinearLayout videoPbBottomLayout, ImageButton videoPbPlayBtn, SeekBar videoPbSeekBar, ProgressWheel videoPbSpinner, TextView videoPbTimeDuration, TextView videoPbTimeLapsed, LinearLayout videoPbTopLayout, TextView videoPbVideoName)`  L41
- `RelativeLayout getRoot()`  L64 @Override
- `ContentPanoramaVideoPbBinding inflate(LayoutInflater inflater)`  L68
- `ContentPanoramaVideoPbBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L72
- `ContentPanoramaVideoPbBinding bind(View rootView)`  L80
### `com.gku.xtugo.databinding.ContentPhotoPbBinding`
L17 · [class] public final ContentPhotoPbBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ContentPhotoPbBinding.java`

字段/常量（13）：
- `ImageButton doNext`  L18
- `ImageButton doPrevious`  L19
- `SurfaceView mSurfaceView`  L20
- `TextView panoramaTypeBtn`  L21
- `ImageButton pbBack`  L22
- `LinearLayout pbBottomLayout`  L23
- `TextView pbIndexInfo`  L24
- `RelativeLayout pbTopLayout`  L25
- `ImageButton photoPbDelete`  L26
- `ImageButton photoPbDownload`  L27
- `RelativeLayout rootView`  L28
- `ViewPager viewpager`  L29
- `int i = R.id.do_next`  L64

方法（5）：
- `private ContentPhotoPbBinding(RelativeLayout rootView, ImageButton doNext, ImageButton doPrevious, SurfaceView mSurfaceView, TextView panoramaTypeBtn, ImageButton pbBack, LinearLayout pbBottomLayout, TextView pbIndexInfo, RelativeLayout pbTopLayout, ImageButton photoPbDelete, ImageButton photoPbDownload, ViewPager viewpager)`  L31
- `RelativeLayout getRoot()`  L47 @Override
- `ContentPhotoPbBinding inflate(LayoutInflater inflater)`  L51
- `ContentPhotoPbBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L55
- `ContentPhotoPbBinding bind(View rootView)`  L63
### `com.gku.xtugo.databinding.CopyFileDialogBinding`
L14 · [class] public final CopyFileDialogBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/CopyFileDialogBinding.java`

字段/常量（5）：
- `TextView copyProgressText`  L15
- `ProgressBar dialogProgress`  L16
- `TextView dialogTitle`  L17
- `RelativeLayout rootView`  L18
- `int i = R.id.copy_progress_text`  L45

方法（5）：
- `private CopyFileDialogBinding(RelativeLayout rootView, TextView copyProgressText, ProgressBar dialogProgress, TextView dialogTitle)`  L20
- `RelativeLayout getRoot()`  L28 @Override
- `CopyFileDialogBinding inflate(LayoutInflater inflater)`  L32
- `CopyFileDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `CopyFileDialogBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.CustomToastBinding`
L13 · [class] public final CustomToastBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/CustomToastBinding.java`

字段/常量（3）：
- `LinearLayout rootView`  L14
- `TextView toastText`  L15
- `int i = R.id.toast_text`  L40

方法（5）：
- `private CustomToastBinding(LinearLayout rootView, TextView toastText)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `CustomToastBinding inflate(LayoutInflater inflater)`  L27
- `CustomToastBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `CustomToastBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.DeviceItemBinding`
L15 · [class] public final DeviceItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DeviceItemBinding.java`

字段/常量（5）：
- `ImageView ivCameraIcon`  L16
- `LinearLayout layoutCameraItem`  L17
- `RelativeLayout rootView`  L18
- `TextView tvWifiName`  L19
- `int i = R.id.ivCameraIcon`  L46

方法（5）：
- `private DeviceItemBinding(RelativeLayout rootView, ImageView ivCameraIcon, LinearLayout layoutCameraItem, TextView tvWifiName)`  L21
- `RelativeLayout getRoot()`  L29 @Override
- `DeviceItemBinding inflate(LayoutInflater inflater)`  L33
- `DeviceItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `DeviceItemBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.DeviceManageBinding`
L14 · [class] public final DeviceManageBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DeviceManageBinding.java`

字段/常量（7）：
- `GridView gvDeviceList`  L15
- `ImageView ibphoto`  L16
- `ImageView ibsetting`  L17
- `ImageView imgRefresh`  L18
- `ImageView imgTitle`  L19
- `LinearLayout rootView`  L20
- `int i = R.id.gvDeviceList`  L49

方法（5）：
- `private DeviceManageBinding(LinearLayout rootView, GridView gvDeviceList, ImageView ibphoto, ImageView ibsetting, ImageView imgRefresh, ImageView imgTitle)`  L22
- `LinearLayout getRoot()`  L32 @Override
- `DeviceManageBinding inflate(LayoutInflater inflater)`  L36
- `DeviceManageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `DeviceManageBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.DialogActivateBinding`
L15 · [class] public final DialogActivateBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogActivateBinding.java`

字段/常量（6）：
- `Button btnActivate`  L16
- `Button btnTrial`  L17
- `LinearLayout rootView`  L18
- `ScrollView svActivateContent`  L19
- `TextView tvActivatedContent`  L20
- `int i = R.id.btn_activate`  L48

方法（5）：
- `private DialogActivateBinding(LinearLayout rootView, Button btnActivate, Button btnTrial, ScrollView svActivateContent, TextView tvActivatedContent)`  L22
- `LinearLayout getRoot()`  L31 @Override
- `DialogActivateBinding inflate(LayoutInflater inflater)`  L35
- `DialogActivateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `DialogActivateBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.DialogAmbaProgressBinding`
L11 · [class] public final DialogAmbaProgressBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogAmbaProgressBinding.java`

字段/常量（1）：
- `LinearLayout rootView`  L12

方法（5）：
- `private DialogAmbaProgressBinding(LinearLayout rootView)`  L14
- `LinearLayout getRoot()`  L19 @Override
- `DialogAmbaProgressBinding inflate(LayoutInflater inflater)`  L23
- `DialogAmbaProgressBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L27
- `DialogAmbaProgressBinding bind(View rootView)`  L35
    - 体内字面量："rootView"
### `com.gku.xtugo.databinding.DialogAppUpdateBinding`
L15 · [class] public final DialogAppUpdateBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogAppUpdateBinding.java`

字段/常量（9）：
- `Button btnDialogCancel`  L16
- `Button btnDialogOK`  L17
- `RelativeLayout relDownloadPercent`  L18
- `LinearLayout rootView`  L19
- `TextView tvDialogAppVersion`  L20
- `TextView tvDialogTitle`  L21
- `TextView txtDialogUpdateMessage`  L22
- `TextView txtDialogUpdatePercent`  L23
- `int i = R.id.btnDialogCancel`  L54

方法（5）：
- `private DialogAppUpdateBinding(LinearLayout rootView, Button btnDialogCancel, Button btnDialogOK, RelativeLayout relDownloadPercent, TextView tvDialogAppVersion, TextView tvDialogTitle, TextView txtDialogUpdateMessage, TextView txtDialogUpdatePercent)`  L25
- `LinearLayout getRoot()`  L37 @Override
- `DialogAppUpdateBinding inflate(LayoutInflater inflater)`  L41
- `DialogAppUpdateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L45
- `DialogAppUpdateBinding bind(View rootView)`  L53
### `com.gku.xtugo.databinding.DialogBottomFastSettingBinding`
L16 · [class] public final DialogBottomFastSettingBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogBottomFastSettingBinding.java`

字段/常量（6）：
- `Button buttonDisconnect`  L17
- `ConstraintLayout rootView`  L18
- `ImageView settingBar`  L19
- `RecyclerView settingRecycle`  L20
- `TextView settingText`  L21
- `int i = R.id.button_disconnect`  L49

方法（5）：
- `private DialogBottomFastSettingBinding(ConstraintLayout rootView, Button buttonDisconnect, ImageView settingBar, RecyclerView settingRecycle, TextView settingText)`  L23
- `ConstraintLayout getRoot()`  L32 @Override
- `DialogBottomFastSettingBinding inflate(LayoutInflater inflater)`  L36
- `DialogBottomFastSettingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `DialogBottomFastSettingBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.DialogConfirmBinding`
L14 · [class] public final DialogConfirmBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogConfirmBinding.java`

字段/常量（6）：
- `Button btnDialogCancel`  L15
- `Button btnDialogOK`  L16
- `LinearLayout rootView`  L17
- `TextView tvDialogMessage`  L18
- `TextView tvDialogTitle`  L19
- `int i = R.id.btnDialogCancel`  L47

方法（5）：
- `private DialogConfirmBinding(LinearLayout rootView, Button btnDialogCancel, Button btnDialogOK, TextView tvDialogMessage, TextView tvDialogTitle)`  L21
- `LinearLayout getRoot()`  L30 @Override
- `DialogConfirmBinding inflate(LayoutInflater inflater)`  L34
- `DialogConfirmBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `DialogConfirmBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.DialogConfirmWithCheckboxBinding`
L14 · [class] public final DialogConfirmWithCheckboxBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogConfirmWithCheckboxBinding.java`

字段/常量（4）：
- `CheckBox cbNoRemind`  L15
- `LinearLayoutShape rootView`  L16
- `TextView tvMessage`  L17
- `int i = R.id.cb_no_remind`  L43

方法（5）：
- `private DialogConfirmWithCheckboxBinding(LinearLayoutShape rootView, CheckBox cbNoRemind, TextView tvMessage)`  L19
- `LinearLayoutShape getRoot()`  L26 @Override
- `DialogConfirmWithCheckboxBinding inflate(LayoutInflater inflater)`  L30
- `DialogConfirmWithCheckboxBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `DialogConfirmWithCheckboxBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.DialogCutAudioBinding`
L15 · [class] public final DialogCutAudioBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogCutAudioBinding.java`

字段/常量（7）：
- `FrameLayout flAudioPlay`  L16
- `ImageView positionIconAudio`  L17
- `ConstraintLayout rootView`  L18
- `TextView tvCollectTime`  L19
- `TextView tvCutCancal`  L20
- `TextView tvCutOk`  L21
- `int i = R.id.fl_audio_play`  L50

方法（5）：
- `private DialogCutAudioBinding(ConstraintLayout rootView, FrameLayout flAudioPlay, ImageView positionIconAudio, TextView tvCollectTime, TextView tvCutCancal, TextView tvCutOk)`  L23
- `ConstraintLayout getRoot()`  L33 @Override
- `DialogCutAudioBinding inflate(LayoutInflater inflater)`  L37
- `DialogCutAudioBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `DialogCutAudioBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.DialogCutVideoBinding`
L14 · [class] public final DialogCutVideoBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogCutVideoBinding.java`

字段/常量（5）：
- `ImageView ivClose`  L15
- `ConstraintLayout rootView`  L16
- `TextView tvCamera`  L17
- `TextView tvLocalIamge`  L18
- `int i = R.id.iv_close`  L45

方法（5）：
- `private DialogCutVideoBinding(ConstraintLayout rootView, ImageView ivClose, TextView tvCamera, TextView tvLocalIamge)`  L20
- `ConstraintLayout getRoot()`  L28 @Override
- `DialogCutVideoBinding inflate(LayoutInflater inflater)`  L32
- `DialogCutVideoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `DialogCutVideoBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.DialogFileActionBinding`
L14 · [class] public final DialogFileActionBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogFileActionBinding.java`

字段/常量（10）：
- `Button btnDialogCancel`  L15
- `LinearLayout ibPush`  L16
- `LinearLayout ibdelete`  L17
- `LinearLayout ibdownload`  L18
- `LinearLayout ibedit`  L19
- `LinearLayout ibfileInfo`  L20
- `LinearLayout ibshare`  L21
- `LinearLayout rootView`  L22
- `TextView tvDialogTitle`  L23
- `int i = R.id.btnDialogCancel`  L55

方法（5）：
- `private DialogFileActionBinding(LinearLayout rootView, Button btnDialogCancel, LinearLayout ibPush, LinearLayout ibdelete, LinearLayout ibdownload, LinearLayout ibedit, LinearLayout ibfileInfo, LinearLayout ibshare, TextView tvDialogTitle)`  L25
- `LinearLayout getRoot()`  L38 @Override
- `DialogFileActionBinding inflate(LayoutInflater inflater)`  L42
- `DialogFileActionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `DialogFileActionBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.DialogFileInfoBinding`
L14 · [class] public final DialogFileInfoBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogFileInfoBinding.java`

字段/常量（8）：
- `Button btnDialogCancel`  L15
- `TextView ibfilename`  L16
- `TextView ibfilesize`  L17
- `TextView ibmodifyTime`  L18
- `TextView ibstoragepath`  L19
- `LinearLayout rootView`  L20
- `TextView tvDialogTitle`  L21
- `int i = R.id.btnDialogCancel`  L51

方法（5）：
- `private DialogFileInfoBinding(LinearLayout rootView, Button btnDialogCancel, TextView ibfilename, TextView ibfilesize, TextView ibmodifyTime, TextView ibstoragepath, TextView tvDialogTitle)`  L23
- `LinearLayout getRoot()`  L34 @Override
- `DialogFileInfoBinding inflate(LayoutInflater inflater)`  L38
- `DialogFileInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L42
- `DialogFileInfoBinding bind(View rootView)`  L50
### `com.gku.xtugo.databinding.DialogHisiYingyanProgressBinding`
L13 · [class] public final DialogHisiYingyanProgressBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogHisiYingyanProgressBinding.java`

字段/常量（3）：
- `LinearLayout rootView`  L14
- `ImageView yingyanLoadingImage`  L15
- `int i = R.id.yingyan_loading_image`  L40

方法（5）：
- `private DialogHisiYingyanProgressBinding(LinearLayout rootView, ImageView yingyanLoadingImage)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `DialogHisiYingyanProgressBinding inflate(LayoutInflater inflater)`  L27
- `DialogHisiYingyanProgressBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `DialogHisiYingyanProgressBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.DialogListshowBinding`
L16 · [class] public final DialogListshowBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogListshowBinding.java`

字段/常量（11）：
- `ListView ListView01`  L17
- `Button btnCancel01`  L18
- `Button btnCancel02`  L19
- `Button btnDialogOK01`  L20
- `LinearLayout dialogAmbaProgressTopPart`  L21
- `LinearLayout onlyonebutton`  L22
- `RelativeLayout rootView`  L23
- `TextView tvDialogMessage`  L24
- `TextView tvDialogTitle`  L25
- `LinearLayout twobutton`  L26
- `int i = R.id.ListView01`  L59

方法（5）：
- `private DialogListshowBinding(RelativeLayout rootView, ListView ListView01, Button btnCancel01, Button btnCancel02, Button btnDialogOK01, LinearLayout dialogAmbaProgressTopPart, LinearLayout onlyonebutton, TextView tvDialogMessage, TextView tvDialogTitle, LinearLayout twobutton)`  L28
- `RelativeLayout getRoot()`  L42 @Override
- `DialogListshowBinding inflate(LayoutInflater inflater)`  L46
- `DialogListshowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L50
- `DialogListshowBinding bind(View rootView)`  L58
### `com.gku.xtugo.databinding.DialogLoadingBinding`
L14 · [class] public final DialogLoadingBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogLoadingBinding.java`

字段/常量（4）：
- `ImageView ivLoading`  L15
- `LinearLayout rootView`  L16
- `TextView tvLoadingTx`  L17
- `int i = R.id.iv_loading`  L43

方法（5）：
- `private DialogLoadingBinding(LinearLayout rootView, ImageView ivLoading, TextView tvLoadingTx)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `DialogLoadingBinding inflate(LayoutInflater inflater)`  L30
- `DialogLoadingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `DialogLoadingBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.DialogLoadingFullscreenBinding`
L11 · [class] public final DialogLoadingFullscreenBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogLoadingFullscreenBinding.java`

字段/常量（1）：
- `RelativeLayout rootView`  L12

方法（5）：
- `private DialogLoadingFullscreenBinding(RelativeLayout rootView)`  L14
- `RelativeLayout getRoot()`  L19 @Override
- `DialogLoadingFullscreenBinding inflate(LayoutInflater inflater)`  L23
- `DialogLoadingFullscreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L27
- `DialogLoadingFullscreenBinding bind(View rootView)`  L35
    - 体内字面量："rootView"
### `com.gku.xtugo.databinding.DialogModifyWifiBinding`
L15 · [class] public final DialogModifyWifiBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogModifyWifiBinding.java`

字段/常量（8）：
- `Button btnDialogApply`  L16
- `Button btnDialogCancel`  L17
- `EditText etPassword`  L18
- `EditText etSSID`  L19
- `RelativeLayout rootView`  L20
- `TextView tvDialogTitle`  L21
- `TextView txtWifiStart`  L22
- `int i = R.id.btnDialogApply`  L52

方法（5）：
- `private DialogModifyWifiBinding(RelativeLayout rootView, Button btnDialogApply, Button btnDialogCancel, EditText etPassword, EditText etSSID, TextView tvDialogTitle, TextView txtWifiStart)`  L24
- `RelativeLayout getRoot()`  L35 @Override
- `DialogModifyWifiBinding inflate(LayoutInflater inflater)`  L39
- `DialogModifyWifiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L43
- `DialogModifyWifiBinding bind(View rootView)`  L51
### `com.gku.xtugo.databinding.DialogMyBottomSheetBinding`
L15 · [class] public final DialogMyBottomSheetBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogMyBottomSheetBinding.java`

字段/常量（16）：
- `TextView bluetoothPermission`  L16
- `ConstraintLayout bluetoothPermissionLy`  L17
- `ImageView bluetoothPermissionSwitch`  L18
- `TextView dialogTit`  L19
- `Button enter`  L20
- `TextView locationPermission`  L21
- `ConstraintLayout locationPermissionLy`  L22
- `ImageView locationPermissionSwitch`  L23
- `TextView mediaPermission`  L24
- `ConstraintLayout mediaPermissionLy`  L25
- `ImageView mediaPermissionSwitch`  L26
- `ConstraintLayout rootView`  L27
- `TextView storagePermission`  L28
- `ConstraintLayout storagePermissionLy`  L29
- `ImageView storagePermissionSwitch`  L30
- `int i = R.id.bluetoothPermission`  L68

方法（5）：
- `private DialogMyBottomSheetBinding(ConstraintLayout rootView, TextView bluetoothPermission, ConstraintLayout bluetoothPermissionLy, ImageView bluetoothPermissionSwitch, TextView dialogTit, Button enter, TextView locationPermission, ConstraintLayout locationPermissionLy, ImageView locationPermissionSwitch, TextView mediaPermission, ConstraintLayout mediaPermissionLy, ImageView mediaPermissionSwitch, TextView storagePermission, ConstraintLayout storagePermissionLy, ImageView storagePermissionSwitch)`  L32
- `ConstraintLayout getRoot()`  L51 @Override
- `DialogMyBottomSheetBinding inflate(LayoutInflater inflater)`  L55
- `DialogMyBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L59
- `DialogMyBottomSheetBinding bind(View rootView)`  L67
### `com.gku.xtugo.databinding.DialogProgressBinding`
L15 · [class] public final DialogProgressBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogProgressBinding.java`

字段/常量（8）：
- `Button btnDialogCancel`  L16
- `TextView downloadProgressText`  L17
- `ProgressBar downloadProgressbar`  L18
- `ProgressBar pbDialogProgress`  L19
- `LinearLayout rootView`  L20
- `TextView tvDialogMessage`  L21
- `TextView tvDialogTitle`  L22
- `int i = R.id.btnDialogCancel`  L52

方法（5）：
- `private DialogProgressBinding(LinearLayout rootView, Button btnDialogCancel, TextView downloadProgressText, ProgressBar downloadProgressbar, ProgressBar pbDialogProgress, TextView tvDialogMessage, TextView tvDialogTitle)`  L24
- `LinearLayout getRoot()`  L35 @Override
- `DialogProgressBinding inflate(LayoutInflater inflater)`  L39
- `DialogProgressBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L43
- `DialogProgressBinding bind(View rootView)`  L51
### `com.gku.xtugo.databinding.DialogVideoSaveTophoneBinding`
L14 · [class] public final DialogVideoSaveTophoneBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DialogVideoSaveTophoneBinding.java`

字段/常量（5）：
- `EditText editVideoName`  L15
- `RoundLinearLayout rootView`  L16
- `RoundTextView tvCancal`  L17
- `RoundTextView tvOk`  L18
- `int i = R.id.edit_video_name`  L45

方法（5）：
- `private DialogVideoSaveTophoneBinding(RoundLinearLayout rootView, EditText editVideoName, RoundTextView tvCancal, RoundTextView tvOk)`  L20
- `RoundLinearLayout getRoot()`  L28 @Override
- `DialogVideoSaveTophoneBinding inflate(LayoutInflater inflater)`  L32
- `DialogVideoSaveTophoneBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `DialogVideoSaveTophoneBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.DmcControlLoadingDialogBinding`
L13 · [class] public final DmcControlLoadingDialogBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DmcControlLoadingDialogBinding.java`

字段/常量（3）：
- `RelativeLayout rootView`  L14
- `TextView txtDialog`  L15
- `int i = R.id.txtDialog`  L40

方法（5）：
- `private DmcControlLoadingDialogBinding(RelativeLayout rootView, TextView txtDialog)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `DmcControlLoadingDialogBinding inflate(LayoutInflater inflater)`  L27
- `DmcControlLoadingDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `DmcControlLoadingDialogBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.DmcVideoControlBinding`
L17 · [class] public final DmcVideoControlBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DmcVideoControlBinding.java`

字段/常量（14）：
- `ImageView imageLine`  L18
- `ImageView ivBack`  L19
- `ImageView ivNext`  L20
- `ImageView ivPlay`  L21
- `ImageView ivPrev`  L22
- `LinearLayout layoutControll`  L23
- `RelativeLayout layoutOverlay`  L24
- `RelativeLayout rootView`  L25
- `SeekBar sbProgress`  L26
- `SurfaceView surfaceView`  L27
- `TextView tvCurrentPosition`  L28
- `TextView tvDuration`  L29
- `TextView tvTitle`  L30
- `int i = R.id.imageLine`  L66

方法（5）：
- `private DmcVideoControlBinding(RelativeLayout rootView, ImageView imageLine, ImageView ivBack, ImageView ivNext, ImageView ivPlay, ImageView ivPrev, LinearLayout layoutControll, RelativeLayout layoutOverlay, SeekBar sbProgress, SurfaceView surfaceView, TextView tvCurrentPosition, TextView tvDuration, TextView tvTitle)`  L32
- `RelativeLayout getRoot()`  L49 @Override
- `DmcVideoControlBinding inflate(LayoutInflater inflater)`  L53
- `DmcVideoControlBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L57
- `DmcVideoControlBinding bind(View rootView)`  L65
### `com.gku.xtugo.databinding.DownloadBinding`
L15 · [class] public final DownloadBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DownloadBinding.java`

字段/常量（6）：
- `ImageButton doAction`  L16
- `TextView downloadStatus`  L17
- `TextView fileName`  L18
- `NumberProgressBar numberbar`  L19
- `LinearLayout rootView`  L20
- `int i = R.id.doAction`  L48

方法（5）：
- `private DownloadBinding(LinearLayout rootView, ImageButton doAction, TextView downloadStatus, TextView fileName, NumberProgressBar numberbar)`  L22
- `LinearLayout getRoot()`  L31 @Override
- `DownloadBinding inflate(LayoutInflater inflater)`  L35
- `DownloadBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `DownloadBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.DownloadContentDialogBinding`
L14 · [class] public final DownloadContentDialogBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DownloadContentDialogBinding.java`

字段/常量（4）：
- `ListView downloadStatus`  L15
- `TextView message`  L16
- `LinearLayout rootView`  L17
- `int i = R.id.downloadStatus`  L43

方法（5）：
- `private DownloadContentDialogBinding(LinearLayout rootView, ListView downloadStatus, TextView message)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `DownloadContentDialogBinding inflate(LayoutInflater inflater)`  L30
- `DownloadContentDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `DownloadContentDialogBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.DownloadDialogTitleBinding`
L13 · [class] public final DownloadDialogTitleBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DownloadDialogTitleBinding.java`

字段/常量（3）：
- `TextView cancelAllTxv`  L14
- `RelativeLayout rootView`  L15
- `int i = R.id.cancel_all_txv`  L40

方法（5）：
- `private DownloadDialogTitleBinding(RelativeLayout rootView, TextView cancelAllTxv)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `DownloadDialogTitleBinding inflate(LayoutInflater inflater)`  L27
- `DownloadDialogTitleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `DownloadDialogTitleBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.DownloadfileExceptionBinding`
L14 · [class] public final DownloadfileExceptionBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DownloadfileExceptionBinding.java`

字段/常量（9）：
- `TextView ibConfirm`  L15
- `TextView ibContent`  L16
- `TextView ibUndo`  L17
- `LinearLayout iboverLoad`  L18
- `LinearLayout ibrename`  L19
- `RadioButton rboverload`  L20
- `RadioButton rbrename`  L21
- `LinearLayout rootView`  L22
- `int i = R.id.ibConfirm`  L53

方法（5）：
- `private DownloadfileExceptionBinding(LinearLayout rootView, TextView ibConfirm, TextView ibContent, TextView ibUndo, LinearLayout iboverLoad, LinearLayout ibrename, RadioButton rboverload, RadioButton rbrename)`  L24
- `LinearLayout getRoot()`  L36 @Override
- `DownloadfileExceptionBinding inflate(LayoutInflater inflater)`  L40
- `DownloadfileExceptionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L44
- `DownloadfileExceptionBinding bind(View rootView)`  L52
### `com.gku.xtugo.databinding.DownloadSingleDialogTitleBinding`
L13 · [class] public final DownloadSingleDialogTitleBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/DownloadSingleDialogTitleBinding.java`

字段/常量（3）：
- `ImageButton exit`  L14
- `RelativeLayout rootView`  L15
- `int i = R.id.exit`  L40

方法（5）：
- `private DownloadSingleDialogTitleBinding(RelativeLayout rootView, ImageButton exit)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `DownloadSingleDialogTitleBinding inflate(LayoutInflater inflater)`  L27
- `DownloadSingleDialogTitleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `DownloadSingleDialogTitleBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.FileBrowserGridviewBinding`
L19 · [class] public final FileBrowserGridviewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FileBrowserGridviewBinding.java`

字段/常量（18）：
- `RelativeLayout bottomToolbar`  L20
- `ProgressBar firstLoading`  L21
- `Button ibConfirm`  L22
- `HiGridView ibImgGridView`  L23
- `ImageView ibPreviewMenu`  L24
- `TextView ibSelectAll`  L25
- `Button ibUndo`  L26
- `ImageView ibback`  L27
- `RelativeLayout ibtopTitle`  L28
- `TextView ibtvTitle`  L29
- `View leftMargin`  L30
- `ProgressBar loadingView`  L31
- `RefreshHeadView refreshHeaderView`  L32
- `View rightMargin`  L33
- `FrameLayout rootView`  L34
- `View viewFindChildViewById`  L72
- `View viewFindChildViewById2`  L73
- `int i = R.id.bottom_toolbar`  L74

方法（5）：
- `private FileBrowserGridviewBinding(FrameLayout rootView, RelativeLayout bottomToolbar, ProgressBar firstLoading, Button ibConfirm, HiGridView ibImgGridView, ImageView ibPreviewMenu, TextView ibSelectAll, Button ibUndo, ImageView ibback, RelativeLayout ibtopTitle, TextView ibtvTitle, View leftMargin, ProgressBar loadingView, RefreshHeadView refreshHeaderView, View rightMargin)`  L36
- `FrameLayout getRoot()`  L55 @Override
- `FileBrowserGridviewBinding inflate(LayoutInflater inflater)`  L59
- `FileBrowserGridviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L63
- `FileBrowserGridviewBinding bind(View rootView)`  L71
### `com.gku.xtugo.databinding.FileFilterBinding`
L15 · [class] public final FileFilterBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FileFilterBinding.java`

字段/常量（11）：
- `GridView cameraTypeList`  L16
- `TextView filterReset`  L17
- `TextView filterSure`  L18
- `LinearLayout layout01`  L19
- `TextView maxTimeEdt`  L20
- `TextView minTimeEdt`  L21
- `FrameLayout rootLayout`  L22
- `FrameLayout rootView`  L23
- `TextView sensorsTypeTxv`  L24
- `GridView timeList`  L25
- `int i = R.id.camera_type_list`  L58

方法（5）：
- `private FileFilterBinding(FrameLayout rootView, GridView cameraTypeList, TextView filterReset, TextView filterSure, LinearLayout layout01, TextView maxTimeEdt, TextView minTimeEdt, FrameLayout rootLayout, TextView sensorsTypeTxv, GridView timeList)`  L27
- `FrameLayout getRoot()`  L41 @Override
- `FileFilterBinding inflate(LayoutInflater inflater)`  L45
- `FileFilterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L49
- `FileFilterBinding bind(View rootView)`  L57
### `com.gku.xtugo.databinding.FragmentCameraFileBinding`
L15 · [class] public final FragmentCameraFileBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentCameraFileBinding.java`

字段/常量（6）：
- `ConstraintLayout localAlbumFragment`  L16
- `SmartRefreshLayout refreshLayout`  L17
- `ConstraintLayout rootView`  L18
- `RecyclerView rvList`  L19
- `TextView tvNoFile`  L20
- `int i = R.id.refresh_layout`  L49

方法（5）：
- `private FragmentCameraFileBinding(ConstraintLayout rootView, ConstraintLayout localAlbumFragment, SmartRefreshLayout refreshLayout, RecyclerView rvList, TextView tvNoFile)`  L22
- `ConstraintLayout getRoot()`  L31 @Override
- `FragmentCameraFileBinding inflate(LayoutInflater inflater)`  L35
- `FragmentCameraFileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `FragmentCameraFileBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.FragmentDeleteAccountBinding`
L17 · [class] public abstract FragmentDeleteAccountBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentDeleteAccountBinding.java`

字段/常量（9）：
- `MaterialButton btnConfirm`  L18
- `MaterialButton btnGetVerifyCode`  L19
- `TextInputEditText etAccount`  L20
- `TextInputLayout etAccountLayout`  L21
- `TextInputEditText etPwd`  L22
- `TextInputEditText etVerifyCode`  L23
- `DeleteAccountViewModel mFragmentDeleteAccountViewModel`  L26 @Bindable
- `TextView tvRegisterDes`  L27
- `TextView tvRegisterTitle`  L28

方法（9）：
- `void setFragmentDeleteAccountViewModel(DeleteAccountViewModel fragmentDeleteAccountViewModel)`  L30
- `protected FragmentDeleteAccountBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btnConfirm, MaterialButton btnGetVerifyCode, TextInputEditText etAccount, TextInputLayout etAccountLayout, TextInputEditText etPwd, TextInputEditText etVerifyCode, TextView tvRegisterDes, TextView tvRegisterTitle)`  L32
- `DeleteAccountViewModel getFragmentDeleteAccountViewModel()`  L44
- `FragmentDeleteAccountBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L48
- `FragmentDeleteAccountBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L53 @Deprecated
- `FragmentDeleteAccountBinding inflate(LayoutInflater inflater)`  L57
- `FragmentDeleteAccountBinding inflate(LayoutInflater inflater, Object component)`  L62 @Deprecated
- `FragmentDeleteAccountBinding bind(View view)`  L66
- `FragmentDeleteAccountBinding bind(View view, Object component)`  L71 @Deprecated
### `com.gku.xtugo.databinding.FragmentDeleteAccountBindingImpl`
L21 · [class] public FragmentDeleteAccountBindingImpl · extends `FragmentDeleteAccountBinding` · `com/gku/xtugo/databinding/FragmentDeleteAccountBindingImpl.java`

字段/常量（13）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L22
- `SparseIntArray sViewsWithIds`  L23
- `InverseBindingListener etAccountandroidTextAttrChanged`  L24
- `long mDirtyFlags`  L25
- `LinearLayout mboundView0`  L26
- `MutableLiveData<GKUUser> mutableLiveData`  L49
- `GKUUser value`  L50
- `DeleteAccountViewModel deleteAccountViewModel = FragmentDeleteAccountBindingImpl.this.mFragmentDeleteAccountViewModel`  L52
- `long j`  L142
- `String email`  L143
- `DeleteAccountViewModel deleteAccountViewModel = this.mFragmentDeleteAccountViewModel`  L148
- `long j2 = 31 & j`  L149
- `LiveData<?> liveData = deleteAccountViewModel != null ? deleteAccountViewModel.localGKUUser : null`  L153

方法（11）：
- `public FragmentDeleteAccountBindingImpl(DataBindingComponent bindingComponent, View root)`  L40
- `private FragmentDeleteAccountBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L44
- `void onChange()`  L48 @Override
- `void invalidateAll()`  L69 @Override
- `boolean hasPendingBindings()`  L77 @Override
- `boolean setVariable(int variableId, Object variable)`  L84 @Override
- `void setFragmentDeleteAccountViewModel(DeleteAccountViewModel FragmentDeleteAccountViewModel)`  L93 @Override
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L103 @Override
- `boolean onChangeFragmentDeleteAccountViewModelLocalGKUUser(MutableLiveData<GKUUser> FragmentDeleteAccountViewModelLocalGKUUser, int fieldId)`  L113
- `boolean onChangeFragmentDeleteAccountViewModelLocalGKUUserGetValue(GKUUser FragmentDeleteAccountViewModelLocalGKUUserGetValue, int fieldId)`  L123
- `void executeBindings()`  L141 @Override
### `com.gku.xtugo.databinding.FragmentDeviceAdd1ListBinding`
L18 · [class] public final FragmentDeviceAdd1ListBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentDeviceAdd1ListBinding.java`

字段/常量（13）：
- `ImageView btnClose`  L19
- `TextViewShape btnConnect`  L20
- `TextView content`  L21
- `RecyclerView deviceList`  L22
- `ImageView ivDeviceIcon`  L23
- `LinearLayout llBottom`  L24
- `LinearLayout llDeviceIcon`  L25
- `RadarView radar`  L26
- `ConstraintLayout rootView`  L27
- `TextView titleAdd`  L28
- `TextView tvBottomContent`  L29
- `TextView tvScanDevices`  L30
- `int i = R.id.btn_close`  L65

方法（5）：
- `private FragmentDeviceAdd1ListBinding(ConstraintLayout rootView, ImageView btnClose, TextViewShape btnConnect, TextView content, RecyclerView deviceList, ImageView ivDeviceIcon, LinearLayout llBottom, LinearLayout llDeviceIcon, RadarView radar, TextView titleAdd, TextView tvBottomContent, TextView tvScanDevices)`  L32
- `ConstraintLayout getRoot()`  L48 @Override
- `FragmentDeviceAdd1ListBinding inflate(LayoutInflater inflater)`  L52
- `FragmentDeviceAdd1ListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L56
- `FragmentDeviceAdd1ListBinding bind(View rootView)`  L64
### `com.gku.xtugo.databinding.FragmentDeviceAdd2KeyBinding`
L16 · [class] public final FragmentDeviceAdd2KeyBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentDeviceAdd2KeyBinding.java`

字段/常量（11）：
- `TextViewShape btCancelKey`  L17
- `ImageView btnClose`  L18
- `LinearLayout llBottom`  L19
- `LinearLayout llDeviceIcon`  L20
- `ConstraintLayout rootView`  L21
- `TextView tvDeviceAddKey`  L22
- `TextViewShape tvPin1`  L23
- `TextViewShape tvPin2`  L24
- `TextViewShape tvPin3`  L25
- `TextViewShape tvPin4`  L26
- `int i = R.id.bt_cancel_key`  L59

方法（5）：
- `private FragmentDeviceAdd2KeyBinding(ConstraintLayout rootView, TextViewShape btCancelKey, ImageView btnClose, LinearLayout llBottom, LinearLayout llDeviceIcon, TextView tvDeviceAddKey, TextViewShape tvPin1, TextViewShape tvPin2, TextViewShape tvPin3, TextViewShape tvPin4)`  L28
- `ConstraintLayout getRoot()`  L42 @Override
- `FragmentDeviceAdd2KeyBinding inflate(LayoutInflater inflater)`  L46
- `FragmentDeviceAdd2KeyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L50
- `FragmentDeviceAdd2KeyBinding bind(View rootView)`  L58
### `com.gku.xtugo.databinding.FragmentDeviceAdd3ConnectBinding`
L16 · [class] public final FragmentDeviceAdd3ConnectBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentDeviceAdd3ConnectBinding.java`

字段/常量（9）：
- `TextViewShape btStartConnect`  L17
- `ImageView btnClose`  L18
- `ImageView ivDeviceIcon`  L19
- `LinearLayout llBottom`  L20
- `LinearLayout llDeviceIcon`  L21
- `ConstraintLayout rootView`  L22
- `TextView tvBottomContent`  L23
- `TextView tvDeviceConnectStatus`  L24
- `int i = R.id.bt_start_connect`  L55

方法（5）：
- `private FragmentDeviceAdd3ConnectBinding(ConstraintLayout rootView, TextViewShape btStartConnect, ImageView btnClose, ImageView ivDeviceIcon, LinearLayout llBottom, LinearLayout llDeviceIcon, TextView tvBottomContent, TextView tvDeviceConnectStatus)`  L26
- `ConstraintLayout getRoot()`  L38 @Override
- `FragmentDeviceAdd3ConnectBinding inflate(LayoutInflater inflater)`  L42
- `FragmentDeviceAdd3ConnectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `FragmentDeviceAdd3ConnectBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.FragmentDeviceAddBinding`
L13 · [class] public final FragmentDeviceAddBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentDeviceAddBinding.java`

字段/常量（3）：
- `FrameLayoutRound flDeviceAdd`  L14
- `ConstraintLayout rootView`  L15
- `int i = R.id.fl_device_add`  L40

方法（5）：
- `private FragmentDeviceAddBinding(ConstraintLayout rootView, FrameLayoutRound flDeviceAdd)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `FragmentDeviceAddBinding inflate(LayoutInflater inflater)`  L27
- `FragmentDeviceAddBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `FragmentDeviceAddBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.FragmentDeviceAddWaveBinding`
L17 · [class] public final FragmentDeviceAddWaveBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentDeviceAddWaveBinding.java`

字段/常量（8）：
- `RecyclerView deviceList`  L18
- `DiffuseView2 diffuseView1`  L19
- `DiffuseView2 diffuseView2`  L20
- `Button helper`  L21
- `ConstraintLayout rootView`  L22
- `TextView searching`  L23
- `LinearLayout stopSearch`  L24
- `int i = R.id.device_list`  L54

方法（5）：
- `private FragmentDeviceAddWaveBinding(ConstraintLayout rootView, RecyclerView deviceList, DiffuseView2 diffuseView1, DiffuseView2 diffuseView2, Button helper, TextView searching, LinearLayout stopSearch)`  L26
- `ConstraintLayout getRoot()`  L37 @Override
- `FragmentDeviceAddWaveBinding inflate(LayoutInflater inflater)`  L41
- `FragmentDeviceAddWaveBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L45
- `FragmentDeviceAddWaveBinding bind(View rootView)`  L53
### `com.gku.xtugo.databinding.FragmentForgetPwdBinding`
L17 · [class] public abstract FragmentForgetPwdBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentForgetPwdBinding.java`

字段/常量（9）：
- `MaterialButton btnConfirm`  L18
- `MaterialButton btnGetVerifyCode`  L19
- `TextInputEditText etAccount`  L20
- `TextInputLayout etAccountLayout`  L21
- `TextInputEditText etNewPwd`  L22
- `TextInputEditText etVerifyCode`  L23
- `ForgetPasswordFragmentViewModel mForgetPwdViewModel`  L26 @Bindable
- `TextView tvRegisterDes`  L27
- `TextView tvRegisterTitle`  L28

方法（9）：
- `void setForgetPwdViewModel(ForgetPasswordFragmentViewModel forgetPwdViewModel)`  L30
- `protected FragmentForgetPwdBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btnConfirm, MaterialButton btnGetVerifyCode, TextInputEditText etAccount, TextInputLayout etAccountLayout, TextInputEditText etNewPwd, TextInputEditText etVerifyCode, TextView tvRegisterDes, TextView tvRegisterTitle)`  L32
- `ForgetPasswordFragmentViewModel getForgetPwdViewModel()`  L44
- `FragmentForgetPwdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L48
- `FragmentForgetPwdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L53 @Deprecated
- `FragmentForgetPwdBinding inflate(LayoutInflater inflater)`  L57
- `FragmentForgetPwdBinding inflate(LayoutInflater inflater, Object component)`  L62 @Deprecated
- `FragmentForgetPwdBinding bind(View view)`  L66
- `FragmentForgetPwdBinding bind(View view, Object component)`  L71 @Deprecated
### `com.gku.xtugo.databinding.FragmentForgetPwdBindingImpl`
L16 · [class] public FragmentForgetPwdBindingImpl · extends `FragmentForgetPwdBinding` · `com/gku/xtugo/databinding/FragmentForgetPwdBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L17
- `SparseIntArray sViewsWithIds`  L18
- `long mDirtyFlags`  L19
- `LinearLayout mboundView0`  L20

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L23 @Override
- `public FragmentForgetPwdBindingImpl(DataBindingComponent bindingComponent, View root)`  L40
- `private FragmentForgetPwdBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L44
- `void invalidateAll()`  L55 @Override
- `boolean hasPendingBindings()`  L63 @Override
- `boolean setVariable(int variableId, Object variable)`  L70 @Override
- `void setForgetPwdViewModel(ForgetPasswordFragmentViewModel ForgetPwdViewModel)`  L79 @Override
- `void executeBindings()`  L84 @Override
### `com.gku.xtugo.databinding.FragmentLoginBinding`
L19 · [class] public abstract FragmentLoginBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentLoginBinding.java`

字段/常量（12）：
- `MaterialTextView btnForgetPwd`  L20
- `MaterialButton btnLogin`  L21
- `MaterialTextView btnMeetProblem`  L22
- `MaterialRadioButton btnRadioLogin`  L23
- `TextInputLayout etAccountLayout`  L24
- `TextInputEditText etEmailLogin`  L25
- `TextInputEditText etPwdLogin`  L26
- `LoginFragmentViewModel mLoginFragmentViewModel`  L29 @Bindable
- `TextView tvAgreement`  L30
- `TextView tvLoginDes`  L31
- `TextView tvLoginTitle`  L32
- `TextView tvRegister`  L33

方法（9）：
- `void setLoginFragmentViewModel(LoginFragmentViewModel LoginFragmentViewModel)`  L35
- `protected FragmentLoginBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialTextView btnForgetPwd, MaterialButton btnLogin, MaterialTextView btnMeetProblem, MaterialRadioButton btnRadioLogin, TextInputLayout etAccountLayout, TextInputEditText etEmailLogin, TextInputEditText etPwdLogin, TextView tvAgreement, TextView tvLoginDes, TextView tvLoginTitle, TextView tvRegister)`  L37
- `LoginFragmentViewModel getLoginFragmentViewModel()`  L52
- `FragmentLoginBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L56
- `FragmentLoginBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L61 @Deprecated
- `FragmentLoginBinding inflate(LayoutInflater inflater)`  L65
- `FragmentLoginBinding inflate(LayoutInflater inflater, Object component)`  L70 @Deprecated
- `FragmentLoginBinding bind(View view)`  L74
- `FragmentLoginBinding bind(View view, Object component)`  L79 @Deprecated
### `com.gku.xtugo.databinding.FragmentLoginBindingImpl`
L23 · [class] public FragmentLoginBindingImpl · extends `FragmentLoginBinding` · `com/gku/xtugo/databinding/FragmentLoginBindingImpl.java`

字段/常量（16）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L24
- `SparseIntArray sViewsWithIds`  L25
- `InverseBindingListener etEmailLoginandroidTextAttrChanged`  L26
- `InverseBindingListener etPwdLoginandroidTextAttrChanged`  L27
- `long mDirtyFlags`  L28
- `LinearLayout mboundView0`  L29
- `MutableLiveData<GKUUser> gKUUser`  L54
- `GKUUser value`  L55
- `LoginFragmentViewModel loginFragmentViewModel = FragmentLoginBindingImpl.this.mLoginFragmentViewModel`  L57
- `MutableLiveData<GKUUser> gKUUser`  L67
- `GKUUser value`  L68
- `LoginFragmentViewModel loginFragmentViewModel = FragmentLoginBindingImpl.this.mLoginFragmentViewModel`  L70
- `long j`  L166
- `String email`  L167
- `String userPwd`  L168
- `LoginFragmentViewModel loginFragmentViewModel = this.mLoginFragmentViewModel`  L173

方法（12）：
- `public FragmentLoginBindingImpl(DataBindingComponent bindingComponent, View root)`  L45
- `private FragmentLoginBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L49
- `void onChange()`  L53 @Override
- `void onChange()`  L66 @Override
- `void invalidateAll()`  L88 @Override
- `boolean hasPendingBindings()`  L96 @Override
- `boolean setVariable(int variableId, Object variable)`  L103 @Override
- `void setLoginFragmentViewModel(LoginFragmentViewModel LoginFragmentViewModel)`  L112 @Override
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L122 @Override
- `boolean onChangeLoginFragmentViewModelGKUUser(MutableLiveData<GKUUser> LoginFragmentViewModelGKUUser, int fieldId)`  L132
- `boolean onChangeLoginFragmentViewModelGKUUserGetValue(GKUUser LoginFragmentViewModelGKUUserGetValue, int fieldId)`  L142
- `void executeBindings()`  L165 @Override
### `com.gku.xtugo.databinding.FragmentModifyPwdBinding`
L17 · [class] public abstract FragmentModifyPwdBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentModifyPwdBinding.java`

字段/常量（8）：
- `MaterialButton btnConfirm`  L18
- `TextInputEditText etAccount`  L19
- `TextInputLayout etAccountLayout`  L20
- `TextInputEditText etNewPwd`  L21
- `TextInputEditText etOldPwd`  L22
- `ModifyPasswordFragmentViewModel mModifyPwdViewModel`  L25 @Bindable
- `TextView tvRegisterDes`  L26
- `TextView tvRegisterTitle`  L27

方法（9）：
- `void setModifyPwdViewModel(ModifyPasswordFragmentViewModel modifyPwdViewModel)`  L29
- `protected FragmentModifyPwdBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btnConfirm, TextInputEditText etAccount, TextInputLayout etAccountLayout, TextInputEditText etNewPwd, TextInputEditText etOldPwd, TextView tvRegisterDes, TextView tvRegisterTitle)`  L31
- `ModifyPasswordFragmentViewModel getModifyPwdViewModel()`  L42
- `FragmentModifyPwdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L46
- `FragmentModifyPwdBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L51 @Deprecated
- `FragmentModifyPwdBinding inflate(LayoutInflater inflater)`  L55
- `FragmentModifyPwdBinding inflate(LayoutInflater inflater, Object component)`  L60 @Deprecated
- `FragmentModifyPwdBinding bind(View view)`  L64
- `FragmentModifyPwdBinding bind(View view, Object component)`  L69 @Deprecated
### `com.gku.xtugo.databinding.FragmentModifyPwdBindingImpl`
L21 · [class] public FragmentModifyPwdBindingImpl · extends `FragmentModifyPwdBinding` · `com/gku/xtugo/databinding/FragmentModifyPwdBindingImpl.java`

字段/常量（13）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L22
- `SparseIntArray sViewsWithIds`  L23
- `InverseBindingListener etAccountandroidTextAttrChanged`  L24
- `long mDirtyFlags`  L25
- `LinearLayout mboundView0`  L26
- `MutableLiveData<GKUUser> mutableLiveData`  L48
- `GKUUser value`  L49
- `ModifyPasswordFragmentViewModel modifyPasswordFragmentViewModel = FragmentModifyPwdBindingImpl.this.mModifyPwdViewModel`  L51
- `long j`  L141
- `String email`  L142
- `ModifyPasswordFragmentViewModel modifyPasswordFragmentViewModel = this.mModifyPwdViewModel`  L147
- `long j2 = 31 & j`  L148
- `LiveData<?> liveData = modifyPasswordFragmentViewModel != null ? modifyPasswordFragmentViewModel.localGkuUser : null`  L152

方法（11）：
- `public FragmentModifyPwdBindingImpl(DataBindingComponent bindingComponent, View root)`  L39
- `private FragmentModifyPwdBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L43
- `void onChange()`  L47 @Override
- `void invalidateAll()`  L68 @Override
- `boolean hasPendingBindings()`  L76 @Override
- `boolean setVariable(int variableId, Object variable)`  L83 @Override
- `void setModifyPwdViewModel(ModifyPasswordFragmentViewModel ModifyPwdViewModel)`  L92 @Override
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L102 @Override
- `boolean onChangeModifyPwdViewModelLocalGkuUser(MutableLiveData<GKUUser> ModifyPwdViewModelLocalGkuUser, int fieldId)`  L112
- `boolean onChangeModifyPwdViewModelLocalGkuUserGetValue(GKUUser ModifyPwdViewModelLocalGkuUserGetValue, int fieldId)`  L122
- `void executeBindings()`  L140 @Override
### `com.gku.xtugo.databinding.FragmentMultiPbBinding`
L14 · [class] public final FragmentMultiPbBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentMultiPbBinding.java`

字段/常量（5）：
- `TextView noContentTxv`  L15
- `RecyclerView recyclerView`  L16
- `LinearLayout rootView`  L17
- `TextView tvLoading`  L18
- `int i = R.id.no_content_txv`  L45

方法（5）：
- `private FragmentMultiPbBinding(LinearLayout rootView, TextView noContentTxv, RecyclerView recyclerView, TextView tvLoading)`  L20
- `LinearLayout getRoot()`  L28 @Override
- `FragmentMultiPbBinding inflate(LayoutInflater inflater)`  L32
- `FragmentMultiPbBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `FragmentMultiPbBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.FragmentOperationFailBinding`
L15 · [class] public abstract FragmentOperationFailBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentOperationFailBinding.java`

字段/常量（5）：
- `MaterialButton btnFailBack`  L16
- `OperationFailFragmentViewModel mOperationFail`  L19 @Bindable
- `TextView tvFailDes`  L20
- `TextView tvFailMeetProblem`  L21
- `TextView tvFailTitle`  L22

方法（9）：
- `void setOperationFail(OperationFailFragmentViewModel operationFail)`  L24
- `protected FragmentOperationFailBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btnFailBack, TextView tvFailDes, TextView tvFailMeetProblem, TextView tvFailTitle)`  L26
- `OperationFailFragmentViewModel getOperationFail()`  L34
- `FragmentOperationFailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L38
- `FragmentOperationFailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L43 @Deprecated
- `FragmentOperationFailBinding inflate(LayoutInflater inflater)`  L47
- `FragmentOperationFailBinding inflate(LayoutInflater inflater, Object component)`  L52 @Deprecated
- `FragmentOperationFailBinding bind(View view)`  L56
- `FragmentOperationFailBinding bind(View view, Object component)`  L61 @Deprecated
### `com.gku.xtugo.databinding.FragmentOperationFailBindingImpl`
L14 · [class] public FragmentOperationFailBindingImpl · extends `FragmentOperationFailBinding` · `com/gku/xtugo/databinding/FragmentOperationFailBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L15
- `SparseIntArray sViewsWithIds`  L16
- `long mDirtyFlags`  L17
- `LinearLayout mboundView0`  L18

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L21 @Override
- `public FragmentOperationFailBindingImpl(DataBindingComponent bindingComponent, View root)`  L34
- `private FragmentOperationFailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L38
- `void invalidateAll()`  L49 @Override
- `boolean hasPendingBindings()`  L57 @Override
- `boolean setVariable(int variableId, Object variable)`  L64 @Override
- `void setOperationFail(OperationFailFragmentViewModel OperationFail)`  L73 @Override
- `void executeBindings()`  L78 @Override
### `com.gku.xtugo.databinding.FragmentOperationSuccessBinding`
L15 · [class] public abstract FragmentOperationSuccessBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentOperationSuccessBinding.java`

字段/常量（4）：
- `MaterialButton btnSuccessBack`  L16
- `OperationSuccessFragmentViewModel mOperationSuccess`  L19 @Bindable
- `TextView tvSuccessDes`  L20
- `TextView tvSuccessTitle`  L21

方法（9）：
- `void setOperationSuccess(OperationSuccessFragmentViewModel operationSuccess)`  L23
- `protected FragmentOperationSuccessBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btnSuccessBack, TextView tvSuccessDes, TextView tvSuccessTitle)`  L25
- `OperationSuccessFragmentViewModel getOperationSuccess()`  L32
- `FragmentOperationSuccessBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L36
- `FragmentOperationSuccessBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L41 @Deprecated
- `FragmentOperationSuccessBinding inflate(LayoutInflater inflater)`  L45
- `FragmentOperationSuccessBinding inflate(LayoutInflater inflater, Object component)`  L50 @Deprecated
- `FragmentOperationSuccessBinding bind(View view)`  L54
- `FragmentOperationSuccessBinding bind(View view, Object component)`  L59 @Deprecated
### `com.gku.xtugo.databinding.FragmentOperationSuccessBindingImpl`
L14 · [class] public FragmentOperationSuccessBindingImpl · extends `FragmentOperationSuccessBinding` · `com/gku/xtugo/databinding/FragmentOperationSuccessBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L15
- `SparseIntArray sViewsWithIds`  L16
- `long mDirtyFlags`  L17
- `LinearLayout mboundView0`  L18

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L21 @Override
- `public FragmentOperationSuccessBindingImpl(DataBindingComponent bindingComponent, View root)`  L33
- `private FragmentOperationSuccessBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L37
- `void invalidateAll()`  L48 @Override
- `boolean hasPendingBindings()`  L56 @Override
- `boolean setVariable(int variableId, Object variable)`  L63 @Override
- `void setOperationSuccess(OperationSuccessFragmentViewModel OperationSuccess)`  L72 @Override
- `void executeBindings()`  L77 @Override
### `com.gku.xtugo.databinding.FragmentPhoneNumberBinding`
L18 · [class] public abstract FragmentPhoneNumberBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentPhoneNumberBinding.java`

字段/常量（8）：
- `LinearLayout areaCodeLayout`  L19
- `Spinner areaCodeSpinner`  L20
- `MaterialButton btnConfirm`  L21
- `TextInputEditText etPhoneNumber`  L22
- `LinearLayout llPhoneNumber`  L23
- `PhoneNumberFragmentViewModel mPhoneNumberFragmentViewModel`  L26 @Bindable
- `TextView tvLoginDes`  L27
- `TextView tvLoginTitle`  L28

方法（9）：
- `void setPhoneNumberFragmentViewModel(PhoneNumberFragmentViewModel phoneNumberFragmentViewModel)`  L30
- `protected FragmentPhoneNumberBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout areaCodeLayout, Spinner areaCodeSpinner, MaterialButton btnConfirm, TextInputEditText etPhoneNumber, LinearLayout llPhoneNumber, TextView tvLoginDes, TextView tvLoginTitle)`  L32
- `PhoneNumberFragmentViewModel getPhoneNumberFragmentViewModel()`  L43
- `FragmentPhoneNumberBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L47
- `FragmentPhoneNumberBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L52 @Deprecated
- `FragmentPhoneNumberBinding inflate(LayoutInflater inflater)`  L56
- `FragmentPhoneNumberBinding inflate(LayoutInflater inflater, Object component)`  L61 @Deprecated
- `FragmentPhoneNumberBinding bind(View view)`  L65
- `FragmentPhoneNumberBinding bind(View view, Object component)`  L70 @Deprecated
### `com.gku.xtugo.databinding.FragmentPhoneNumberBindingImpl`
L16 · [class] public FragmentPhoneNumberBindingImpl · extends `FragmentPhoneNumberBinding` · `com/gku/xtugo/databinding/FragmentPhoneNumberBindingImpl.java`

字段/常量（3）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L17
- `SparseIntArray sViewsWithIds`  L18
- `long mDirtyFlags`  L19

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L22 @Override
- `public FragmentPhoneNumberBindingImpl(DataBindingComponent bindingComponent, View root)`  L37
- `private FragmentPhoneNumberBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L41
- `void invalidateAll()`  L50 @Override
- `boolean hasPendingBindings()`  L58 @Override
- `boolean setVariable(int variableId, Object variable)`  L65 @Override
- `void setPhoneNumberFragmentViewModel(PhoneNumberFragmentViewModel PhoneNumberFragmentViewModel)`  L74 @Override
- `void executeBindings()`  L79 @Override
### `com.gku.xtugo.databinding.FragmentRegisterBinding`
L18 · [class] public abstract FragmentRegisterBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentRegisterBinding.java`

字段/常量（12）：
- `MaterialButton btnGetVerifyCode`  L19
- `MaterialRadioButton btnRadioRegister`  L20
- `MaterialButton btnRegister`  L21
- `TextInputLayout etAccountLayout`  L22
- `TextInputEditText etEmail`  L23
- `TextInputEditText etPwd`  L24
- `TextInputEditText etVerifyCode`  L25
- `RegisterFragmentViewModel mRegister`  L28 @Bindable
- `TextView tvRadio2`  L29
- `TextView tvRadio4`  L30
- `TextView tvRegisterDes`  L31
- `TextView tvRegisterTitle`  L32

方法（9）：
- `void setRegister(RegisterFragmentViewModel register)`  L34
- `protected FragmentRegisterBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btnGetVerifyCode, MaterialRadioButton btnRadioRegister, MaterialButton btnRegister, TextInputLayout etAccountLayout, TextInputEditText etEmail, TextInputEditText etPwd, TextInputEditText etVerifyCode, TextView tvRadio2, TextView tvRadio4, TextView tvRegisterDes, TextView tvRegisterTitle)`  L36
- `RegisterFragmentViewModel getRegister()`  L51
- `FragmentRegisterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L55
- `FragmentRegisterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L60 @Deprecated
- `FragmentRegisterBinding inflate(LayoutInflater inflater)`  L64
- `FragmentRegisterBinding inflate(LayoutInflater inflater, Object component)`  L69 @Deprecated
- `FragmentRegisterBinding bind(View view)`  L73
- `FragmentRegisterBinding bind(View view, Object component)`  L78 @Deprecated
### `com.gku.xtugo.databinding.FragmentRegisterBindingImpl`
L22 · [class] public FragmentRegisterBindingImpl · extends `FragmentRegisterBinding` · `com/gku/xtugo/databinding/FragmentRegisterBindingImpl.java`

字段/常量（16）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L23
- `SparseIntArray sViewsWithIds`  L24
- `InverseBindingListener etEmailandroidTextAttrChanged`  L25
- `InverseBindingListener etPwdandroidTextAttrChanged`  L26
- `long mDirtyFlags`  L27
- `LinearLayout mboundView0`  L28
- `MutableLiveData<GKUUser> gKUUser`  L53
- `GKUUser value`  L54
- `RegisterFragmentViewModel registerFragmentViewModel = FragmentRegisterBindingImpl.this.mRegister`  L56
- `MutableLiveData<GKUUser> gKUUser`  L66
- `GKUUser value`  L67
- `RegisterFragmentViewModel registerFragmentViewModel = FragmentRegisterBindingImpl.this.mRegister`  L69
- `long j`  L165
- `String userPwd`  L166
- `String email`  L167
- `RegisterFragmentViewModel registerFragmentViewModel = this.mRegister`  L172

方法（12）：
- `public FragmentRegisterBindingImpl(DataBindingComponent bindingComponent, View root)`  L44
- `private FragmentRegisterBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L48
- `void onChange()`  L52 @Override
- `void onChange()`  L65 @Override
- `void invalidateAll()`  L87 @Override
- `boolean hasPendingBindings()`  L95 @Override
- `boolean setVariable(int variableId, Object variable)`  L102 @Override
- `void setRegister(RegisterFragmentViewModel Register)`  L111 @Override
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L121 @Override
- `boolean onChangeRegisterGKUUser(MutableLiveData<GKUUser> RegisterGKUUser, int fieldId)`  L131
- `boolean onChangeRegisterGKUUserGetValue(GKUUser RegisterGKUUserGetValue, int fieldId)`  L141
- `void executeBindings()`  L164 @Override
### `com.gku.xtugo.databinding.FragmentReportFeedbackBinding`
L17 · [class] public abstract FragmentReportFeedbackBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentReportFeedbackBinding.java`

字段/常量（7）：
- `Button btnSendFeedback`  L18
- `EditText etProblemDes`  L19
- `ReportFeedbackViewModel mReportFeedbackViewModel`  L22 @Bindable
- `RecyclerView rvMediaList`  L23
- `SherlockSpinner spProblemType`  L24
- `SherlockSpinner spProductModel`  L25
- `SherlockSpinner spProductType`  L26

方法（9）：
- `void setReportFeedbackViewModel(ReportFeedbackViewModel reportFeedbackViewModel)`  L28
- `protected FragmentReportFeedbackBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btnSendFeedback, EditText etProblemDes, RecyclerView rvMediaList, SherlockSpinner spProblemType, SherlockSpinner spProductModel, SherlockSpinner spProductType)`  L30
- `ReportFeedbackViewModel getReportFeedbackViewModel()`  L40
- `FragmentReportFeedbackBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L44
- `FragmentReportFeedbackBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L49 @Deprecated
- `FragmentReportFeedbackBinding inflate(LayoutInflater inflater)`  L53
- `FragmentReportFeedbackBinding inflate(LayoutInflater inflater, Object component)`  L58 @Deprecated
- `FragmentReportFeedbackBinding bind(View view)`  L62
- `FragmentReportFeedbackBinding bind(View view, Object component)`  L67 @Deprecated
### `com.gku.xtugo.databinding.FragmentReportFeedbackBindingImpl`
L16 · [class] public FragmentReportFeedbackBindingImpl · extends `FragmentReportFeedbackBinding` · `com/gku/xtugo/databinding/FragmentReportFeedbackBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L17
- `SparseIntArray sViewsWithIds`  L18
- `long mDirtyFlags`  L19
- `NestedScrollView mboundView0`  L20

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L23 @Override
- `public FragmentReportFeedbackBindingImpl(DataBindingComponent bindingComponent, View root)`  L38
- `private FragmentReportFeedbackBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L42
- `void invalidateAll()`  L53 @Override
- `boolean hasPendingBindings()`  L61 @Override
- `boolean setVariable(int variableId, Object variable)`  L68 @Override
- `void setReportFeedbackViewModel(ReportFeedbackViewModel ReportFeedbackViewModel)`  L77 @Override
- `void executeBindings()`  L82 @Override
### `com.gku.xtugo.databinding.FragmentStreamSettingFourBinding`
L14 · [class] public abstract FragmentStreamSettingFourBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentStreamSettingFourBinding.java`

字段/常量（4）：
- `ImageView blackImg`  L15
- `TextViewShape tvClose`  L16
- `TextView tvHint`  L17
- `TextView tvTime`  L18

方法（7）：
- `protected FragmentStreamSettingFourBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView blackImg, TextViewShape tvClose, TextView tvHint, TextView tvTime)`  L20
- `FragmentStreamSettingFourBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L28
- `FragmentStreamSettingFourBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L33 @Deprecated
- `FragmentStreamSettingFourBinding inflate(LayoutInflater inflater)`  L37
- `FragmentStreamSettingFourBinding inflate(LayoutInflater inflater, Object component)`  L42 @Deprecated
- `FragmentStreamSettingFourBinding bind(View view)`  L46
- `FragmentStreamSettingFourBinding bind(View view, Object component)`  L51 @Deprecated
### `com.gku.xtugo.databinding.FragmentStreamSettingFourBindingImpl`
L14 · [class] public FragmentStreamSettingFourBindingImpl · extends `FragmentStreamSettingFourBinding` · `com/gku/xtugo/databinding/FragmentStreamSettingFourBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L15
- `SparseIntArray sViewsWithIds`  L16
- `long mDirtyFlags`  L17
- `LinearLayout mboundView0`  L18

方法（7）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L21 @Override
- `boolean setVariable(int variableId, Object variable)`  L26 @Override
- `public FragmentStreamSettingFourBindingImpl(DataBindingComponent bindingComponent, View root)`  L39
- `private FragmentStreamSettingFourBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L43
- `void invalidateAll()`  L54 @Override
- `boolean hasPendingBindings()`  L62 @Override
- `void executeBindings()`  L69 @Override
### `com.gku.xtugo.databinding.FragmentUserCenterBinding`
L13 · [class] public final FragmentUserCenterBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentUserCenterBinding.java`

字段/常量（6）：
- `RelativeLayout recycler`  L14
- `RecyclerView recyclerUser`  L15
- `RecyclerView recyclerUserOther`  L16
- `RecyclerView recyclerUserYutupro`  L17
- `RelativeLayout rootView`  L18
- `int i = R.id.recycler_user`  L47

方法（5）：
- `private FragmentUserCenterBinding(RelativeLayout rootView, RelativeLayout recycler, RecyclerView recyclerUser, RecyclerView recyclerUserOther, RecyclerView recyclerUserYutupro)`  L20
- `RelativeLayout getRoot()`  L29 @Override
- `FragmentUserCenterBinding inflate(LayoutInflater inflater)`  L33
- `FragmentUserCenterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `FragmentUserCenterBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.FragmentUserCenterContactUsItemBinding`
L14 · [class] public final FragmentUserCenterContactUsItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentUserCenterContactUsItemBinding.java`

字段/常量（6）：
- `RelativeLayout rootView`  L15
- `ImageView userCenterNewItemIcon`  L16
- `RelativeLayout userCenterNewItemRelative`  L17
- `TextView userCenterNewItemTitle`  L18
- `int i = R.id.user_center_new_item_icon`  L45
- `int i2 = R.id.user_center_new_item_title`  L49

方法（5）：
- `private FragmentUserCenterContactUsItemBinding(RelativeLayout rootView, ImageView userCenterNewItemIcon, RelativeLayout userCenterNewItemRelative, TextView userCenterNewItemTitle)`  L20
- `RelativeLayout getRoot()`  L28 @Override
- `FragmentUserCenterContactUsItemBinding inflate(LayoutInflater inflater)`  L32
- `FragmentUserCenterContactUsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `FragmentUserCenterContactUsItemBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.FragmentUserCenterItemBinding`
L14 · [class] public final FragmentUserCenterItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentUserCenterItemBinding.java`

字段/常量（6）：
- `ImageView itemIcon`  L15
- `RelativeLayout itemRelative`  L16
- `TextView itemTitle`  L17
- `RelativeLayout rootView`  L18
- `int i = R.id.item_icon`  L45
- `int i2 = R.id.item_title`  L49

方法（5）：
- `private FragmentUserCenterItemBinding(RelativeLayout rootView, ImageView itemIcon, RelativeLayout itemRelative, TextView itemTitle)`  L20
- `RelativeLayout getRoot()`  L28 @Override
- `FragmentUserCenterItemBinding inflate(LayoutInflater inflater)`  L32
- `FragmentUserCenterItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `FragmentUserCenterItemBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.FragmentUserCenterItemTitleAndOtherBinding`
L14 · [class] public final FragmentUserCenterItemTitleAndOtherBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentUserCenterItemTitleAndOtherBinding.java`

字段/常量（7）：
- `View itemBottomLine`  L15
- `ImageView itemIcon`  L16
- `ImageView itemNext`  L17
- `RelativeLayout itemRelative`  L18
- `TextView itemTitle`  L19
- `RelativeLayout rootView`  L20
- `int i = R.id.item_bottom_line`  L49

方法（5）：
- `private FragmentUserCenterItemTitleAndOtherBinding(RelativeLayout rootView, View itemBottomLine, ImageView itemIcon, ImageView itemNext, RelativeLayout itemRelative, TextView itemTitle)`  L22
- `RelativeLayout getRoot()`  L32 @Override
- `FragmentUserCenterItemTitleAndOtherBinding inflate(LayoutInflater inflater)`  L36
- `FragmentUserCenterItemTitleAndOtherBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `FragmentUserCenterItemTitleAndOtherBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.FragmentUserCenterItemYutuproBinding`
L14 · [class] public final FragmentUserCenterItemYutuproBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentUserCenterItemYutuproBinding.java`

字段/常量（5）：
- `TextView itemImageNameYutupro`  L15
- `ImageView itemImageYutupro`  L16
- `ConstraintLayout rootView`  L17
- `ConstraintLayout userItemYutupro`  L18
- `int i = R.id.item_image_name_yutupro`  L45

方法（5）：
- `private FragmentUserCenterItemYutuproBinding(ConstraintLayout rootView, TextView itemImageNameYutupro, ImageView itemImageYutupro, ConstraintLayout userItemYutupro)`  L20
- `ConstraintLayout getRoot()`  L28 @Override
- `FragmentUserCenterItemYutuproBinding inflate(LayoutInflater inflater)`  L32
- `FragmentUserCenterItemYutuproBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `FragmentUserCenterItemYutuproBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.FragmentUserCenterNewBinding`
L14 · [class] public abstract FragmentUserCenterNewBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentUserCenterNewBinding.java`

字段/常量（4）：
- `UserCenterNewFragmentViewModel mUserCenterNewFragmentViewModel`  L17 @Bindable
- `RecyclerView recyclerContactUs`  L18
- `RecyclerView recyclerLoginInfo`  L19
- `RecyclerView recyclerSettingOptions`  L20

方法（9）：
- `void setUserCenterNewFragmentViewModel(UserCenterNewFragmentViewModel userCenterNewFragmentViewModel)`  L22
- `protected FragmentUserCenterNewBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerContactUs, RecyclerView recyclerLoginInfo, RecyclerView recyclerSettingOptions)`  L24
- `UserCenterNewFragmentViewModel getUserCenterNewFragmentViewModel()`  L31
- `FragmentUserCenterNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L35
- `FragmentUserCenterNewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L40 @Deprecated
- `FragmentUserCenterNewBinding inflate(LayoutInflater inflater)`  L44
- `FragmentUserCenterNewBinding inflate(LayoutInflater inflater, Object component)`  L49 @Deprecated
- `FragmentUserCenterNewBinding bind(View view)`  L53
- `FragmentUserCenterNewBinding bind(View view, Object component)`  L58 @Deprecated
### `com.gku.xtugo.databinding.FragmentUserCenterNewBindingImpl`
L13 · [class] public FragmentUserCenterNewBindingImpl · extends `FragmentUserCenterNewBinding` · `com/gku/xtugo/databinding/FragmentUserCenterNewBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L14
- `SparseIntArray sViewsWithIds`  L15
- `long mDirtyFlags`  L16
- `NestedScrollView mboundView0`  L17

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L20 @Override
- `public FragmentUserCenterNewBindingImpl(DataBindingComponent bindingComponent, View root)`  L32
- `private FragmentUserCenterNewBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L36
- `void invalidateAll()`  L47 @Override
- `boolean hasPendingBindings()`  L55 @Override
- `boolean setVariable(int variableId, Object variable)`  L62 @Override
- `void setUserCenterNewFragmentViewModel(UserCenterNewFragmentViewModel UserCenterNewFragmentViewModel)`  L71 @Override
- `void executeBindings()`  L76 @Override
### `com.gku.xtugo.databinding.FragmentUserCenterNewSettingOptionsItemBinding`
L14 · [class] public final FragmentUserCenterNewSettingOptionsItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentUserCenterNewSettingOptionsItemBinding.java`

字段/常量（8）：
- `RelativeLayout rootView`  L15
- `View userCenterNewItemBottomLine`  L16
- `ImageView userCenterNewItemIcon`  L17
- `ImageView userCenterNewItemNext`  L18
- `TextView userCenterNewItemRedDot`  L19
- `RelativeLayout userCenterNewItemRelative`  L20
- `TextView userCenterNewItemTitle`  L21
- `int i = R.id.user_center_new_item_bottom_line`  L51

方法（5）：
- `private FragmentUserCenterNewSettingOptionsItemBinding(RelativeLayout rootView, View userCenterNewItemBottomLine, ImageView userCenterNewItemIcon, ImageView userCenterNewItemNext, TextView userCenterNewItemRedDot, RelativeLayout userCenterNewItemRelative, TextView userCenterNewItemTitle)`  L23
- `RelativeLayout getRoot()`  L34 @Override
- `FragmentUserCenterNewSettingOptionsItemBinding inflate(LayoutInflater inflater)`  L38
- `FragmentUserCenterNewSettingOptionsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L42
- `FragmentUserCenterNewSettingOptionsItemBinding bind(View rootView)`  L50
### `com.gku.xtugo.databinding.FragmentUserCenterNewTopItemBinding`
L14 · [class] public final FragmentUserCenterNewTopItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentUserCenterNewTopItemBinding.java`

字段/常量（6）：
- `RelativeLayout rootView`  L15
- `ImageView userCenterTopItemNext`  L16
- `RelativeLayout userCenterTopItemRelative`  L17
- `TextView userCenterTopItemTextLeft`  L18
- `TextView userCenterTopItemTextRight`  L19
- `int i = R.id.user_center_top_item_next`  L47

方法（5）：
- `private FragmentUserCenterNewTopItemBinding(RelativeLayout rootView, ImageView userCenterTopItemNext, RelativeLayout userCenterTopItemRelative, TextView userCenterTopItemTextLeft, TextView userCenterTopItemTextRight)`  L21
- `RelativeLayout getRoot()`  L30 @Override
- `FragmentUserCenterNewTopItemBinding inflate(LayoutInflater inflater)`  L34
- `FragmentUserCenterNewTopItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `FragmentUserCenterNewTopItemBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.FragmentUserInfoBinding`
L16 · [class] public abstract FragmentUserInfoBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/FragmentUserInfoBinding.java`

字段/常量（5）：
- `MaterialButton btnSignOut`  L17
- `ImageView iconRec`  L18
- `UserInfoFragmentViewModel mUserInfoFragmentViewModel`  L21 @Bindable
- `RecyclerView recyclerUserInfo1`  L22
- `RecyclerView recyclerUserInfo2`  L23

方法（9）：
- `void setUserInfoFragmentViewModel(UserInfoFragmentViewModel userInfoFragmentViewModel)`  L25
- `protected FragmentUserInfoBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btnSignOut, ImageView iconRec, RecyclerView recyclerUserInfo1, RecyclerView recyclerUserInfo2)`  L27
- `UserInfoFragmentViewModel getUserInfoFragmentViewModel()`  L35
- `FragmentUserInfoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L39
- `FragmentUserInfoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L44 @Deprecated
- `FragmentUserInfoBinding inflate(LayoutInflater inflater)`  L48
- `FragmentUserInfoBinding inflate(LayoutInflater inflater, Object component)`  L53 @Deprecated
- `FragmentUserInfoBinding bind(View view)`  L57
- `FragmentUserInfoBinding bind(View view, Object component)`  L62 @Deprecated
### `com.gku.xtugo.databinding.FragmentUserInfoBindingImpl`
L15 · [class] public FragmentUserInfoBindingImpl · extends `FragmentUserInfoBinding` · `com/gku/xtugo/databinding/FragmentUserInfoBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L16
- `SparseIntArray sViewsWithIds`  L17
- `long mDirtyFlags`  L18
- `NestedScrollView mboundView0`  L19

方法（8）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L22 @Override
- `public FragmentUserInfoBindingImpl(DataBindingComponent bindingComponent, View root)`  L35
- `private FragmentUserInfoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L39
- `void invalidateAll()`  L50 @Override
- `boolean hasPendingBindings()`  L58 @Override
- `boolean setVariable(int variableId, Object variable)`  L65 @Override
- `void setUserInfoFragmentViewModel(UserInfoFragmentViewModel UserInfoFragmentViewModel)`  L74 @Override
- `void executeBindings()`  L79 @Override
### `com.gku.xtugo.databinding.FragmentUserInfoItemBinding`
L14 · [class] public final FragmentUserInfoItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentUserInfoItemBinding.java`

字段/常量（7）：
- `LinearLayout rootView`  L15
- `View userInfoItemBottomLine`  L16
- `ImageView userInfoItemNext`  L17
- `LinearLayout userInfoItemRelative`  L18
- `TextView userInfoItemTextLeft`  L19
- `TextView userInfoItemTextRight`  L20
- `int i = R.id.user_info_item_bottom_line`  L49

方法（5）：
- `private FragmentUserInfoItemBinding(LinearLayout rootView, View userInfoItemBottomLine, ImageView userInfoItemNext, LinearLayout userInfoItemRelative, TextView userInfoItemTextLeft, TextView userInfoItemTextRight)`  L22
- `LinearLayout getRoot()`  L32 @Override
- `FragmentUserInfoItemBinding inflate(LayoutInflater inflater)`  L36
- `FragmentUserInfoItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `FragmentUserInfoItemBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.FragmentWaveBinding`
L15 · [class] public final FragmentWaveBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FragmentWaveBinding.java`

字段/常量（6）：
- `DiffuseView diffuseView1`  L16
- `DiffuseView diffuseView2`  L17
- `Button helper`  L18
- `ConstraintLayout rootView`  L19
- `TextView searching`  L20
- `int i = R.id.diffuseView1`  L48

方法（5）：
- `private FragmentWaveBinding(ConstraintLayout rootView, DiffuseView diffuseView1, DiffuseView diffuseView2, Button helper, TextView searching)`  L22
- `ConstraintLayout getRoot()`  L31 @Override
- `FragmentWaveBinding inflate(LayoutInflater inflater)`  L35
- `FragmentWaveBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `FragmentWaveBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.FrgAlbumBinding`
L14 · [class] public final FrgAlbumBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FrgAlbumBinding.java`

字段/常量（4）：
- `LinearLayout rootView`  L15
- `TabLayout tablayout`  L16
- `ViewPager vpager`  L17
- `int i = R.id.tablayout`  L43

方法（5）：
- `private FrgAlbumBinding(LinearLayout rootView, TabLayout tablayout, ViewPager vpager)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `FrgAlbumBinding inflate(LayoutInflater inflater)`  L30
- `FrgAlbumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `FrgAlbumBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.FrgAlbumCaddxBinding`
L14 · [class] public final FrgAlbumCaddxBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/FrgAlbumCaddxBinding.java`

字段/常量（4）：
- `LinearLayout rootView`  L15
- `SegmentTabLayout ssTab`  L16
- `ViewPager vpager`  L17
- `int i = R.id.ss_tab`  L43

方法（5）：
- `private FrgAlbumCaddxBinding(LinearLayout rootView, SegmentTabLayout ssTab, ViewPager vpager)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `FrgAlbumCaddxBinding inflate(LayoutInflater inflater)`  L30
- `FrgAlbumCaddxBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `FrgAlbumCaddxBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.GeneralPopRecyclerItemBinding`
L14 · [class] public final GeneralPopRecyclerItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/GeneralPopRecyclerItemBinding.java`

字段/常量（6）：
- `TextView itemRecyItemname`  L15
- `RelativeLayout itemRelat`  L16
- `RelativeLayout rootView`  L17
- `ImageView srcChecked`  L18
- `int i = R.id.item_recy_itemname`  L45
- `int i2 = R.id.src_checked`  L49

方法（5）：
- `private GeneralPopRecyclerItemBinding(RelativeLayout rootView, TextView itemRecyItemname, RelativeLayout itemRelat, ImageView srcChecked)`  L20
- `RelativeLayout getRoot()`  L28 @Override
- `GeneralPopRecyclerItemBinding inflate(LayoutInflater inflater)`  L32
- `GeneralPopRecyclerItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `GeneralPopRecyclerItemBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.GeneralPopupwindowBinding`
L13 · [class] public final GeneralPopupwindowBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/GeneralPopupwindowBinding.java`

字段/常量（3）：
- `RecyclerView recyclerPop`  L14
- `RelativeLayout rootView`  L15
- `int i = R.id.recycler_pop`  L40

方法（5）：
- `private GeneralPopupwindowBinding(RelativeLayout rootView, RecyclerView recyclerPop)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `GeneralPopupwindowBinding inflate(LayoutInflater inflater)`  L27
- `GeneralPopupwindowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `GeneralPopupwindowBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.GridItemLayoutBinding`
L13 · [class] public final GridItemLayoutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/GridItemLayoutBinding.java`

字段/常量（4）：
- `CameraItemView itemCamera`  L14
- `RelativeLayout relatItem`  L15
- `RelativeLayout rootView`  L16
- `int i = R.id.item_camera`  L42

方法（5）：
- `private GridItemLayoutBinding(RelativeLayout rootView, CameraItemView itemCamera, RelativeLayout relatItem)`  L18
- `RelativeLayout getRoot()`  L25 @Override
- `GridItemLayoutBinding inflate(LayoutInflater inflater)`  L29
- `GridItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `GridItemLayoutBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.HicheckWidgetBinding`
L11 · [class] public final HicheckWidgetBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/HicheckWidgetBinding.java`

字段/常量（2）：
- `CheckBox checkbox`  L12
- `CheckBox rootView`  L13

方法（5）：
- `private HicheckWidgetBinding(CheckBox rootView, CheckBox checkbox)`  L15
- `CheckBox getRoot()`  L21 @Override
- `HicheckWidgetBinding inflate(LayoutInflater inflater)`  L25
- `HicheckWidgetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L29
- `HicheckWidgetBinding bind(View rootView)`  L37
    - 体内字面量："rootView"
### `com.gku.xtugo.databinding.IcatchContentPreviewBinding`
L17 · [class] public final IcatchContentPreviewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/IcatchContentPreviewBinding.java`

字段/常量（33）：
- `ImageView autoDownloadImageview`  L18
- `ImageView batteryStatus`  L19
- `ImageView burstStatus`  L20
- `RelativeLayout buttomBar`  L21
- `ImageView carMode`  L22
- `ImageView delayCaptureIv`  L23
- `RelativeLayout delayCaptureLayout`  L24
- `TextView delayCaptureText`  L25
- `ImageButton doCapture`  L26
- `RelativeLayout imageSizeLayout`  L27
- `TextView imageSizeTxv`  L28
- `ImageButton multiPb`  L29
- `TextView notSupportPreviewTxv`  L30
- `ImageButton panoramaTypeBtn`  L31
- `SurfaceView preview`  L32
- `ImageButton pvMode`  L33
- `TextView recordingTime`  L34
- `TextView remainCaptureCountText`  L35
- `TextView remainRecordingTimeText`  L36
- `RelativeLayout rootView`  L37
- `TextView separator1`  L38
- `TextView separator2`  L39
- `ImageView slowMotion`  L40
- `RelativeLayout statusBar1`  L41
- `RelativeLayout statusBar2`  L42
- `ImageButton stillToggle`  L43
- `ImageView timelapseMode`  L44
- `RelativeLayout videoSizeLayout`  L45
- `TextView videoSizeTxv`  L46
- `ImageView wbStatus`  L47
- `ImageView wifiStatus`  L48
- `ZoomView zoomView`  L49
- `int i = R.id.auto_download_imageview`  L104

方法（5）：
- `private IcatchContentPreviewBinding(RelativeLayout rootView, ImageView autoDownloadImageview, ImageView batteryStatus, ImageView burstStatus, RelativeLayout buttomBar, ImageView carMode, ImageView delayCaptureIv, RelativeLayout delayCaptureLayout, TextView delayCaptureText, ImageButton doCapture, RelativeLayout imageSizeLayout, TextView imageSizeTxv, ImageButton multiPb, TextView notSupportPreviewTxv, ImageButton panoramaTypeBtn, SurfaceView preview, ImageButton pvMode, TextView recordingTime, TextView remainCaptureCountText, TextView remainRecordingTimeText, TextView separator1, TextView separator2, ImageView slowMotion, RelativeLayout statusBar1, RelativeLayout statusBar2, ImageButton stillToggle, ImageView timelapseMode, RelativeLayout videoSizeLayout, TextView videoSizeTxv, ImageView wbStatus, ImageView wifiStatus, ZoomView zoomView)`  L51
- `RelativeLayout getRoot()`  L87 @Override
- `IcatchContentPreviewBinding inflate(LayoutInflater inflater)`  L91
- `IcatchContentPreviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L95
- `IcatchContentPreviewBinding bind(View rootView)`  L103
### `com.gku.xtugo.databinding.ImageEditLayoutActionItemBinding`
L14 · [class] public final ImageEditLayoutActionItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ImageEditLayoutActionItemBinding.java`

字段/常量（6）：
- `ImageView ivBg`  L15
- `FrameLayout rootView`  L16
- `TextView tvTitle`  L17
- `View vSelectRect`  L18
- `View viewFindChildViewById`  L45
- `int i = R.id.iv_bg`  L46

方法（5）：
- `private ImageEditLayoutActionItemBinding(FrameLayout rootView, ImageView ivBg, TextView tvTitle, View vSelectRect)`  L20
- `FrameLayout getRoot()`  L28 @Override
- `ImageEditLayoutActionItemBinding inflate(LayoutInflater inflater)`  L32
- `ImageEditLayoutActionItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `ImageEditLayoutActionItemBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.ImageLookoverBinding`
L16 · [class] public final ImageLookoverBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ImageLookoverBinding.java`

字段/常量（9）：
- `RelativeLayout bottomToolbar`  L17
- `ProgressBar ibPBarProgress`  L18
- `TextView ibprogress`  L19
- `ImageView playVideo`  L20
- `RelativeLayout rootView`  L21
- `SwitchImageView switchImageView`  L22
- `View topView`  L23
- `View viewFindChildViewById`  L53
- `int i = R.id.bottom_toolbar`  L54

方法（5）：
- `private ImageLookoverBinding(RelativeLayout rootView, RelativeLayout bottomToolbar, ProgressBar ibPBarProgress, TextView ibprogress, ImageView playVideo, SwitchImageView switchImageView, View topView)`  L25
- `RelativeLayout getRoot()`  L36 @Override
- `ImageLookoverBinding inflate(LayoutInflater inflater)`  L40
- `ImageLookoverBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L44
- `ImageLookoverBinding bind(View rootView)`  L52
### `com.gku.xtugo.databinding.ImageToolbarBinding`
L13 · [class] public final ImageToolbarBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ImageToolbarBinding.java`

字段/常量（5）：
- `ImageView ibPreviewMenu`  L14
- `ImageView ibback`  L15
- `RelativeLayout ibtopTitle`  L16
- `RelativeLayout rootView`  L17
- `int i = R.id.ibPreviewMenu`  L44

方法（5）：
- `private ImageToolbarBinding(RelativeLayout rootView, ImageView ibPreviewMenu, ImageView ibback, RelativeLayout ibtopTitle)`  L19
- `RelativeLayout getRoot()`  L27 @Override
- `ImageToolbarBinding inflate(LayoutInflater inflater)`  L31
- `ImageToolbarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L35
- `ImageToolbarBinding bind(View rootView)`  L43
### `com.gku.xtugo.databinding.IncludeLocationDialogBinding`
L11 · [class] public final IncludeLocationDialogBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/IncludeLocationDialogBinding.java`

字段/常量（1）：
- `LinearLayout rootView`  L12

方法（5）：
- `private IncludeLocationDialogBinding(LinearLayout rootView)`  L14
- `LinearLayout getRoot()`  L19 @Override
- `IncludeLocationDialogBinding inflate(LayoutInflater inflater)`  L23
- `IncludeLocationDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L27
- `IncludeLocationDialogBinding bind(View rootView)`  L35
    - 体内字面量："rootView"
### `com.gku.xtugo.databinding.ItemAnnouncementCreateTimeBinding`
L13 · [class] public final ItemAnnouncementCreateTimeBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ItemAnnouncementCreateTimeBinding.java`

字段/常量（4）：
- `TextView announcementItemCreateTime`  L14
- `LinearLayout announcementLatestItemLinear`  L15
- `LinearLayout rootView`  L16
- `int i = R.id.announcement_item_create_time`  L42

方法（5）：
- `private ItemAnnouncementCreateTimeBinding(LinearLayout rootView, TextView announcementItemCreateTime, LinearLayout announcementLatestItemLinear)`  L18
- `LinearLayout getRoot()`  L25 @Override
- `ItemAnnouncementCreateTimeBinding inflate(LayoutInflater inflater)`  L29
- `ItemAnnouncementCreateTimeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `ItemAnnouncementCreateTimeBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.ItemAnnouncementLatestBinding`
L14 · [class] public final ItemAnnouncementLatestBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ItemAnnouncementLatestBinding.java`

字段/常量（6）：
- `TextView announcementLatestItemContent`  L15
- `ImageView announcementLatestItemIcon`  L16
- `LinearLayout announcementLatestItemLinear`  L17
- `TextView announcementLatestItemTitle`  L18
- `LinearLayout rootView`  L19
- `int i = R.id.announcement_latest_item_content`  L47

方法（5）：
- `private ItemAnnouncementLatestBinding(LinearLayout rootView, TextView announcementLatestItemContent, ImageView announcementLatestItemIcon, LinearLayout announcementLatestItemLinear, TextView announcementLatestItemTitle)`  L21
- `LinearLayout getRoot()`  L30 @Override
- `ItemAnnouncementLatestBinding inflate(LayoutInflater inflater)`  L34
- `ItemAnnouncementLatestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `ItemAnnouncementLatestBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.ItemAudioBinding`
L14 · [class] public final ItemAudioBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ItemAudioBinding.java`

字段/常量（4）：
- `ImageView ivAudio`  L15
- `LinearLayout rootView`  L16
- `TextView tvAudioName`  L17
- `int i = R.id.iv_audio`  L43

方法（5）：
- `private ItemAudioBinding(LinearLayout rootView, ImageView ivAudio, TextView tvAudioName)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `ItemAudioBinding inflate(LayoutInflater inflater)`  L30
- `ItemAudioBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ItemAudioBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.ItemAudioCollectBinding`
L17 · [class] public final ItemAudioCollectBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ItemAudioCollectBinding.java`

字段/常量（11）：
- `FrameLayout flAudio`  L18
- `ImageView ivIcon`  L19
- `LinearLayout llAudio`  L20
- `ImageView positionIcon`  L21
- `RelativeLayout rlAudio`  L22
- `LinearLayout rootView`  L23
- `TextView tvCollectTime`  L24
- `TextView tvName`  L25
- `TextView tvTime`  L26
- `RoundTextView tvUse`  L27
- `int i = R.id.fl_audio`  L60

方法（5）：
- `private ItemAudioCollectBinding(LinearLayout rootView, FrameLayout flAudio, ImageView ivIcon, LinearLayout llAudio, ImageView positionIcon, RelativeLayout rlAudio, TextView tvCollectTime, TextView tvName, TextView tvTime, RoundTextView tvUse)`  L29
- `LinearLayout getRoot()`  L43 @Override
- `ItemAudioCollectBinding inflate(LayoutInflater inflater)`  L47
- `ItemAudioCollectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L51
- `ItemAudioCollectBinding bind(View rootView)`  L59
### `com.gku.xtugo.databinding.ItemDeviceManagerBinding`
L15 · [class] public abstract ItemDeviceManagerBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ItemDeviceManagerBinding.java`

字段/常量（14）：
- `ImageView imageCheck`  L16
- `ImageView imgDevice`  L17
- `LinearLayout layoutBg`  L18
- `LinearLayout layoutFail`  L19
- `LinearLayout layoutProgress`  L20
- `LinearLayout layoutUpgrade`  L21
- `CusProgressBar progressBar`  L22
- `TextView tvDeviceModel`  L23
- `TextView tvDeviceName`  L24
- `TextView tvDeviceUpgrade`  L25
- `TextView tvDeviceVersion`  L26
- `TextView tvDownloadVersion`  L27
- `TextView tvRetry`  L28
- `TextView tvStartUpgrade`  L29

方法（7）：
- `protected ItemDeviceManagerBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imageCheck, ImageView imgDevice, LinearLayout layoutBg, LinearLayout layoutFail, LinearLayout layoutProgress, LinearLayout layoutUpgrade, CusProgressBar progressBar, TextView tvDeviceModel, TextView tvDeviceName, TextView tvDeviceUpgrade, TextView tvDeviceVersion, TextView tvDownloadVersion, TextView tvRetry, TextView tvStartUpgrade)`  L31
- `ItemDeviceManagerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L49
- `ItemDeviceManagerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L54 @Deprecated
- `ItemDeviceManagerBinding inflate(LayoutInflater inflater)`  L58
- `ItemDeviceManagerBinding inflate(LayoutInflater inflater, Object component)`  L63 @Deprecated
- `ItemDeviceManagerBinding bind(View view)`  L67
- `ItemDeviceManagerBinding bind(View view, Object component)`  L72 @Deprecated
### `com.gku.xtugo.databinding.ItemDeviceManagerBindingImpl`
L14 · [class] public ItemDeviceManagerBindingImpl · extends `ItemDeviceManagerBinding` · `com/gku/xtugo/databinding/ItemDeviceManagerBindingImpl.java`

字段/常量（4）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L15
- `SparseIntArray sViewsWithIds`  L16
- `long mDirtyFlags`  L17
- `LinearLayout mboundView0`  L18

方法（7）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L21 @Override
- `boolean setVariable(int variableId, Object variable)`  L26 @Override
- `public ItemDeviceManagerBindingImpl(DataBindingComponent bindingComponent, View root)`  L49
- `private ItemDeviceManagerBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L53
- `void invalidateAll()`  L64 @Override
- `boolean hasPendingBindings()`  L72 @Override
- `void executeBindings()`  L79 @Override
### `com.gku.xtugo.databinding.ItemFilterBinding`
L13 · [class] public final ItemFilterBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ItemFilterBinding.java`

字段/常量（3）：
- `RelativeLayout rootView`  L14
- `TextView text`  L15
- `int i = R.id.text`  L40

方法（5）：
- `private ItemFilterBinding(RelativeLayout rootView, TextView text)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `ItemFilterBinding inflate(LayoutInflater inflater)`  L27
- `ItemFilterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `ItemFilterBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.ItemPbRecyclerviewGridBinding`
L13 · [class] public final ItemPbRecyclerviewGridBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ItemPbRecyclerviewGridBinding.java`

字段/常量（6）：
- `ImageView isPanorama`  L14
- `ImageView localPhotoWallGridEdit`  L15
- `ImageView localPhotoWallGridItem`  L16
- `RelativeLayout rootView`  L17
- `ImageView videoSign`  L18
- `int i = R.id.is_panorama`  L46

方法（5）：
- `private ItemPbRecyclerviewGridBinding(RelativeLayout rootView, ImageView isPanorama, ImageView localPhotoWallGridEdit, ImageView localPhotoWallGridItem, ImageView videoSign)`  L20
- `RelativeLayout getRoot()`  L29 @Override
- `ItemPbRecyclerviewGridBinding inflate(LayoutInflater inflater)`  L33
- `ItemPbRecyclerviewGridBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `ItemPbRecyclerviewGridBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.ItemPbRecyclerviewListBinding`
L15 · [class] public final ItemPbRecyclerviewListBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ItemPbRecyclerviewListBinding.java`

字段/常量（11）：
- `ImageView isPanorama`  L16
- `TextView localPhotoDate`  L17
- `TextView localPhotoName`  L18
- `TextView localPhotoSize`  L19
- `ImageView localPhotoThumbnailList`  L20
- `ImageView localPhotoWallListEdit`  L21
- `TextView localVideoDuration`  L22
- `LinearLayout rootView`  L23
- `FrameLayout thumbnailLayout`  L24
- `ImageView videoSign`  L25
- `int i = R.id.is_panorama`  L58

方法（5）：
- `private ItemPbRecyclerviewListBinding(LinearLayout rootView, ImageView isPanorama, TextView localPhotoDate, TextView localPhotoName, TextView localPhotoSize, ImageView localPhotoThumbnailList, ImageView localPhotoWallListEdit, TextView localVideoDuration, FrameLayout thumbnailLayout, ImageView videoSign)`  L27
- `LinearLayout getRoot()`  L41 @Override
- `ItemPbRecyclerviewListBinding inflate(LayoutInflater inflater)`  L45
- `ItemPbRecyclerviewListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L49
- `ItemPbRecyclerviewListBinding bind(View rootView)`  L57
### `com.gku.xtugo.databinding.ItemPureImageBinding`
L11 · [class] public final ItemPureImageBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ItemPureImageBinding.java`

字段/常量（2）：
- `ImageView iv`  L12
- `ImageView rootView`  L13

方法（5）：
- `private ItemPureImageBinding(ImageView rootView, ImageView iv)`  L15
- `ImageView getRoot()`  L21 @Override
- `ItemPureImageBinding inflate(LayoutInflater inflater)`  L25
- `ItemPureImageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L29
- `ItemPureImageBinding bind(View rootView)`  L37
    - 体内字面量："rootView"
### `com.gku.xtugo.databinding.ItemReportFeedbackBinding`
L14 · [class] public final ItemReportFeedbackBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ItemReportFeedbackBinding.java`

字段/常量（8）：
- `ImageView ivItemReportFeedbackDelete`  L15
- `ImageView ivItemReportFeedbackMedia`  L16
- `ImageView ivItemReportFeedbackPlay`  L17
- `RelativeLayout rlItemReportFeedback`  L18
- `RelativeLayout rootView`  L19
- `TextView tvItemReportFeedbackSizeDes`  L20
- `TextView tvItemReportFeedbackVideoTime`  L21
- `int i = R.id.iv_item_report_feedback_delete`  L51

方法（5）：
- `private ItemReportFeedbackBinding(RelativeLayout rootView, ImageView ivItemReportFeedbackDelete, ImageView ivItemReportFeedbackMedia, ImageView ivItemReportFeedbackPlay, RelativeLayout rlItemReportFeedback, TextView tvItemReportFeedbackSizeDes, TextView tvItemReportFeedbackVideoTime)`  L23
- `RelativeLayout getRoot()`  L34 @Override
- `ItemReportFeedbackBinding inflate(LayoutInflater inflater)`  L38
- `ItemReportFeedbackBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L42
- `ItemReportFeedbackBinding bind(View rootView)`  L50
### `com.gku.xtugo.databinding.ItemSelectLiveDeviceBinding`
L14 · [class] public abstract ItemSelectLiveDeviceBinding · extends `ViewDataBinding` · `com/gku/xtugo/databinding/ItemSelectLiveDeviceBinding.java`

字段/常量（3）：
- `TextView itemDesc`  L15
- `ImageView itemImage`  L16
- `ConstraintLayout layoutBg`  L17

方法（7）：
- `protected ItemSelectLiveDeviceBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView itemDesc, ImageView itemImage, ConstraintLayout layoutBg)`  L19
- `ItemSelectLiveDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot)`  L26
- `ItemSelectLiveDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component)`  L31 @Deprecated
- `ItemSelectLiveDeviceBinding inflate(LayoutInflater inflater)`  L35
- `ItemSelectLiveDeviceBinding inflate(LayoutInflater inflater, Object component)`  L40 @Deprecated
- `ItemSelectLiveDeviceBinding bind(View view)`  L44
- `ItemSelectLiveDeviceBinding bind(View view, Object component)`  L49 @Deprecated
### `com.gku.xtugo.databinding.ItemSelectLiveDeviceBindingImpl`
L13 · [class] public ItemSelectLiveDeviceBindingImpl · extends `ItemSelectLiveDeviceBinding` · `com/gku/xtugo/databinding/ItemSelectLiveDeviceBindingImpl.java`

字段/常量（3）：
- `ViewDataBinding.IncludedLayouts sIncludes = null`  L14
- `SparseIntArray sViewsWithIds`  L15
- `long mDirtyFlags`  L16

方法（7）：
- `boolean onFieldChange(int localFieldId, Object object, int fieldId)`  L19 @Override
- `boolean setVariable(int variableId, Object variable)`  L24 @Override
- `public ItemSelectLiveDeviceBindingImpl(DataBindingComponent bindingComponent, View root)`  L35
- `private ItemSelectLiveDeviceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings)`  L39
- `void invalidateAll()`  L48 @Override
- `boolean hasPendingBindings()`  L56 @Override
- `void executeBindings()`  L63 @Override
### `com.gku.xtugo.databinding.LayoutCameraModelItemLayoutBinding`
L14 · [class] public final LayoutCameraModelItemLayoutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutCameraModelItemLayoutBinding.java`

字段/常量（6）：
- `ImageView itemIcon`  L15
- `LinearLayout itemLinear`  L16
- `ImageView itemSelect`  L17
- `TextView itemTitle`  L18
- `LinearLayout rootView`  L19
- `int i = R.id.item_icon`  L47

方法（5）：
- `private LayoutCameraModelItemLayoutBinding(LinearLayout rootView, ImageView itemIcon, LinearLayout itemLinear, ImageView itemSelect, TextView itemTitle)`  L21
- `LinearLayout getRoot()`  L30 @Override
- `LayoutCameraModelItemLayoutBinding inflate(LayoutInflater inflater)`  L34
- `LayoutCameraModelItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `LayoutCameraModelItemLayoutBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.LayoutConnectedCameraBinding`
L15 · [class] public final LayoutConnectedCameraBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutConnectedCameraBinding.java`

字段/常量（10）：
- `TextView cameraConnectedState`  L16
- `ImageView cameraImage`  L17
- `ImageView cameraImgState`  L18
- `TextView cameraName`  L19
- `TextView connectState`  L20
- `TextView connectedUpdateVersionTips`  L21
- `Button enterCameraBtn`  L22
- `RelativeLayout rootView`  L23
- `Button seeFile`  L24
- `int i = R.id.camera_connected_state`  L56

方法（5）：
- `private LayoutConnectedCameraBinding(RelativeLayout rootView, TextView cameraConnectedState, ImageView cameraImage, ImageView cameraImgState, TextView cameraName, TextView connectState, TextView connectedUpdateVersionTips, Button enterCameraBtn, Button seeFile)`  L26
- `RelativeLayout getRoot()`  L39 @Override
- `LayoutConnectedCameraBinding inflate(LayoutInflater inflater)`  L43
- `LayoutConnectedCameraBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L47
- `LayoutConnectedCameraBinding bind(View rootView)`  L55
### `com.gku.xtugo.databinding.LayoutConnectedCameraCaddxBinding`
L16 · [class] public final LayoutConnectedCameraCaddxBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutConnectedCameraCaddxBinding.java`

字段/常量（11）：
- `TextView cameraConnectedState`  L17
- `ImageView cameraImage`  L18
- `ImageView cameraImgState`  L19
- `TextView cameraName`  L20
- `TextView connectState`  L21
- `TextView connectedUpdateVersionTips`  L22
- `Button enterCameraBtn`  L23
- `LinearLayout llHint`  L24
- `LinearLayout llTop`  L25
- `RelativeLayout rootView`  L26
- `int i = R.id.camera_connected_state`  L59

方法（5）：
- `private LayoutConnectedCameraCaddxBinding(RelativeLayout rootView, TextView cameraConnectedState, ImageView cameraImage, ImageView cameraImgState, TextView cameraName, TextView connectState, TextView connectedUpdateVersionTips, Button enterCameraBtn, LinearLayout llHint, LinearLayout llTop)`  L28
- `RelativeLayout getRoot()`  L42 @Override
- `LayoutConnectedCameraCaddxBinding inflate(LayoutInflater inflater)`  L46
- `LayoutConnectedCameraCaddxBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L50
- `LayoutConnectedCameraCaddxBinding bind(View rootView)`  L58
### `com.gku.xtugo.databinding.LayoutDeviceAddItemBinding`
L14 · [class] public final LayoutDeviceAddItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDeviceAddItemBinding.java`

字段/常量（4）：
- `TextView itemDesc`  L15
- `ImageView itemImage`  L16
- `ConstraintLayout rootView`  L17
- `int i = R.id.item_desc`  L43

方法（5）：
- `private LayoutDeviceAddItemBinding(ConstraintLayout rootView, TextView itemDesc, ImageView itemImage)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `LayoutDeviceAddItemBinding inflate(LayoutInflater inflater)`  L30
- `LayoutDeviceAddItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutDeviceAddItemBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutDeviceAddTitleBarBinding`
L14 · [class] public final LayoutDeviceAddTitleBarBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDeviceAddTitleBarBinding.java`

字段/常量（4）：
- `ImageView ivBackDeviceAdd`  L15
- `TextView layoutTitleAdd`  L16
- `ConstraintLayout rootView`  L17
- `int i = R.id.iv_back_device_add`  L43

方法（5）：
- `private LayoutDeviceAddTitleBarBinding(ConstraintLayout rootView, ImageView ivBackDeviceAdd, TextView layoutTitleAdd)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `LayoutDeviceAddTitleBarBinding inflate(LayoutInflater inflater)`  L30
- `LayoutDeviceAddTitleBarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutDeviceAddTitleBarBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutDialogJumpBinding`
L15 · [class] public final LayoutDialogJumpBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogJumpBinding.java`

字段/常量（5）：
- `Button dialogConfirm`  L16
- `ImageView dialogImage`  L17
- `TextView dialogTips`  L18
- `ConstraintLayout rootView`  L19
- `int i = R.id.dialog_confirm`  L46

方法（5）：
- `private LayoutDialogJumpBinding(ConstraintLayout rootView, Button dialogConfirm, ImageView dialogImage, TextView dialogTips)`  L21
- `ConstraintLayout getRoot()`  L29 @Override
- `LayoutDialogJumpBinding inflate(LayoutInflater inflater)`  L33
- `LayoutDialogJumpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `LayoutDialogJumpBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.LayoutDialogNoConfirmTipBinding`
L15 · [class] public final LayoutDialogNoConfirmTipBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogNoConfirmTipBinding.java`

字段/常量（5）：
- `RelativeLayout rootView`  L16
- `Button ssDialogTipCancel`  L17
- `LinearLayout ssDialogTipContent`  L18
- `TextView ssDialogTipMessage`  L19
- `int i = R.id.ss_dialog_tip_cancel`  L46

方法（5）：
- `private LayoutDialogNoConfirmTipBinding(RelativeLayout rootView, Button ssDialogTipCancel, LinearLayout ssDialogTipContent, TextView ssDialogTipMessage)`  L21
- `RelativeLayout getRoot()`  L29 @Override
- `LayoutDialogNoConfirmTipBinding inflate(LayoutInflater inflater)`  L33
- `LayoutDialogNoConfirmTipBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `LayoutDialogNoConfirmTipBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.LayoutDialogSizeBinding`
L15 · [class] public final LayoutDialogSizeBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSizeBinding.java`

字段/常量（7）：
- `RadioButton btnRadio1`  L16
- `RadioButton btnRadio2`  L17
- `RelativeLayout highLayout`  L18
- `LinearLayout rootView`  L19
- `RelativeLayout smallLayout`  L20
- `TextView tvSure`  L21
- `int i = R.id.btn_radio1`  L50

方法（5）：
- `private LayoutDialogSizeBinding(LinearLayout rootView, RadioButton btnRadio1, RadioButton btnRadio2, RelativeLayout highLayout, RelativeLayout smallLayout, TextView tvSure)`  L23
- `LinearLayout getRoot()`  L33 @Override
- `LayoutDialogSizeBinding inflate(LayoutInflater inflater)`  L37
- `LayoutDialogSizeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `LayoutDialogSizeBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.LayoutDialogSsDownloadBinding`
L16 · [class] public final LayoutDialogSsDownloadBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSsDownloadBinding.java`

字段/常量（9）：
- `TextView downloadCatalogue`  L17
- `RelativeLayout rootView`  L18
- `Button ssDialogDownloadCancel`  L19
- `LinearLayout ssDialogDownloadContent`  L20
- `TextView ssDialogDownloadCount`  L21
- `ProgressBar ssDialogDownloadProgress`  L22
- `TextView ssDialogDownloadProgressText`  L23
- `TextView ssDialogDownloadText`  L24
- `int i = R.id.download_catalogue`  L55

方法（5）：
- `private LayoutDialogSsDownloadBinding(RelativeLayout rootView, TextView downloadCatalogue, Button ssDialogDownloadCancel, LinearLayout ssDialogDownloadContent, TextView ssDialogDownloadCount, ProgressBar ssDialogDownloadProgress, TextView ssDialogDownloadProgressText, TextView ssDialogDownloadText)`  L26
- `RelativeLayout getRoot()`  L38 @Override
- `LayoutDialogSsDownloadBinding inflate(LayoutInflater inflater)`  L42
- `LayoutDialogSsDownloadBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `LayoutDialogSsDownloadBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.LayoutDialogSsInfoBinding`
L15 · [class] public final LayoutDialogSsInfoBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSsInfoBinding.java`

字段/常量（8）：
- `RelativeLayout rootView`  L16
- `Button ssDialogInfoCancel`  L17
- `LinearLayout ssDialogInfoContent`  L18
- `TextView ssDialogInfoMessageCreate`  L19
- `TextView ssDialogInfoMessageName`  L20
- `TextView ssDialogInfoMessagePath`  L21
- `TextView ssDialogInfoMessageSize`  L22
- `int i = R.id.ss_dialog_info_cancel`  L52

方法（5）：
- `private LayoutDialogSsInfoBinding(RelativeLayout rootView, Button ssDialogInfoCancel, LinearLayout ssDialogInfoContent, TextView ssDialogInfoMessageCreate, TextView ssDialogInfoMessageName, TextView ssDialogInfoMessagePath, TextView ssDialogInfoMessageSize)`  L24
- `RelativeLayout getRoot()`  L35 @Override
- `LayoutDialogSsInfoBinding inflate(LayoutInflater inflater)`  L39
- `LayoutDialogSsInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L43
- `LayoutDialogSsInfoBinding bind(View rootView)`  L51
### `com.gku.xtugo.databinding.LayoutDialogSsListBinding`
L15 · [class] public final LayoutDialogSsListBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSsListBinding.java`

字段/常量（5）：
- `RelativeLayout rootView`  L16
- `Button ssDialogListCancel`  L17
- `LinearLayout ssDialogListContent`  L18
- `RecyclerView ssDialogListRecycle`  L19
- `int i = R.id.ss_dialog_list_cancel`  L46

方法（5）：
- `private LayoutDialogSsListBinding(RelativeLayout rootView, Button ssDialogListCancel, LinearLayout ssDialogListContent, RecyclerView ssDialogListRecycle)`  L21
- `RelativeLayout getRoot()`  L29 @Override
- `LayoutDialogSsListBinding inflate(LayoutInflater inflater)`  L33
- `LayoutDialogSsListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `LayoutDialogSsListBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.LayoutDialogSsMessageTipBinding`
L15 · [class] public final LayoutDialogSsMessageTipBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSsMessageTipBinding.java`

字段/常量（6）：
- `RelativeLayout rootView`  L16
- `LinearLayout ssDialogMessageContent`  L17
- `Button ssDialogMessageTipCancel`  L18
- `TextView ssDialogMessageTipMessage`  L19
- `Button ssDialogMessageTipOk`  L20
- `int i = R.id.ss_dialog_message_content`  L48

方法（5）：
- `private LayoutDialogSsMessageTipBinding(RelativeLayout rootView, LinearLayout ssDialogMessageContent, Button ssDialogMessageTipCancel, TextView ssDialogMessageTipMessage, Button ssDialogMessageTipOk)`  L22
- `RelativeLayout getRoot()`  L31 @Override
- `LayoutDialogSsMessageTipBinding inflate(LayoutInflater inflater)`  L35
- `LayoutDialogSsMessageTipBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `LayoutDialogSsMessageTipBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.LayoutDialogSsProgressBinding`
L13 · [class] public final LayoutDialogSsProgressBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSsProgressBinding.java`

字段/常量（3）：
- `ProgressBar firstLoading`  L14
- `LinearLayout rootView`  L15
- `int i = R.id.firstLoading`  L40

方法（5）：
- `private LayoutDialogSsProgressBinding(LinearLayout rootView, ProgressBar firstLoading)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `LayoutDialogSsProgressBinding inflate(LayoutInflater inflater)`  L27
- `LayoutDialogSsProgressBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutDialogSsProgressBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutDialogSsProgressTextBinding`
L14 · [class] public final LayoutDialogSsProgressTextBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSsProgressTextBinding.java`

字段/常量（4）：
- `ProgressBar firstLoading`  L15
- `LinearLayout rootView`  L16
- `TextView tvProgress`  L17
- `int i = R.id.firstLoading`  L43

方法（5）：
- `private LayoutDialogSsProgressTextBinding(LinearLayout rootView, ProgressBar firstLoading, TextView tvProgress)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `LayoutDialogSsProgressTextBinding inflate(LayoutInflater inflater)`  L30
- `LayoutDialogSsProgressTextBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutDialogSsProgressTextBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutDialogSsRenameGroupBinding`
L16 · [class] public final LayoutDialogSsRenameGroupBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSsRenameGroupBinding.java`

字段/常量（8）：
- `RelativeLayout rootView`  L17
- `RadioGroup ssDialogRenameGroup`  L18
- `Button ssDialogRenameGroupCancel`  L19
- `LinearLayout ssDialogRenameGroupContent`  L20
- `Button ssDialogRenameGroupOk`  L21
- `RadioButton ssDialogRenameGroupOverload`  L22
- `RadioButton ssDialogRenameGroupSkip`  L23
- `int i = R.id.ss_dialog_rename_group`  L53

方法（5）：
- `private LayoutDialogSsRenameGroupBinding(RelativeLayout rootView, RadioGroup ssDialogRenameGroup, Button ssDialogRenameGroupCancel, LinearLayout ssDialogRenameGroupContent, Button ssDialogRenameGroupOk, RadioButton ssDialogRenameGroupOverload, RadioButton ssDialogRenameGroupSkip)`  L25
- `RelativeLayout getRoot()`  L36 @Override
- `LayoutDialogSsRenameGroupBinding inflate(LayoutInflater inflater)`  L40
- `LayoutDialogSsRenameGroupBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L44
- `LayoutDialogSsRenameGroupBinding bind(View rootView)`  L52
### `com.gku.xtugo.databinding.LayoutDialogSsVideoQuelityGroupBinding`
L16 · [class] public final LayoutDialogSsVideoQuelityGroupBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSsVideoQuelityGroupBinding.java`

字段/常量（10）：
- `RelativeLayout rootView`  L17
- `RadioGroup ssDialogVideoQualityGroup`  L18
- `Button ssDialogVideoQualityGroupCancel`  L19
- `LinearLayout ssDialogVideoQualityGroupContent`  L20
- `RadioButton ssDialogVideoQualityGroupHd`  L21
- `RadioButton ssDialogVideoQualityGroupNormal`  L22
- `Button ssDialogVideoQualityGroupOk`  L23
- `View vLine`  L24
- `View viewFindChildViewById`  L55
- `int i = R.id.ss_dialog_video_quality_group`  L56

方法（5）：
- `private LayoutDialogSsVideoQuelityGroupBinding(RelativeLayout rootView, RadioGroup ssDialogVideoQualityGroup, Button ssDialogVideoQualityGroupCancel, LinearLayout ssDialogVideoQualityGroupContent, RadioButton ssDialogVideoQualityGroupHd, RadioButton ssDialogVideoQualityGroupNormal, Button ssDialogVideoQualityGroupOk, View vLine)`  L26
- `RelativeLayout getRoot()`  L38 @Override
- `LayoutDialogSsVideoQuelityGroupBinding inflate(LayoutInflater inflater)`  L42
- `LayoutDialogSsVideoQuelityGroupBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `LayoutDialogSsVideoQuelityGroupBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.LayoutDialogSsWifiBinding`
L16 · [class] public final LayoutDialogSsWifiBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogSsWifiBinding.java`

字段/常量（9）：
- `RelativeLayout rootView`  L17
- `Button ssDialogWifiCancel`  L18
- `LinearLayout ssDialogWifiContent`  L19
- `Button ssDialogWifiOk`  L20
- `EditText ssDialogWifiPasswordEdit`  L21
- `ImageView ssDialogWifiPasswordVisible`  L22
- `EditText ssDialogWifiSsidEdit`  L23
- `EditText ssDialogWifiSsidTail`  L24
- `int i = R.id.ss_dialog_wifi_cancel`  L55

方法（5）：
- `private LayoutDialogSsWifiBinding(RelativeLayout rootView, Button ssDialogWifiCancel, LinearLayout ssDialogWifiContent, Button ssDialogWifiOk, EditText ssDialogWifiPasswordEdit, ImageView ssDialogWifiPasswordVisible, EditText ssDialogWifiSsidEdit, EditText ssDialogWifiSsidTail)`  L26
- `RelativeLayout getRoot()`  L38 @Override
- `LayoutDialogSsWifiBinding inflate(LayoutInflater inflater)`  L42
- `LayoutDialogSsWifiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `LayoutDialogSsWifiBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.LayoutDialogTipBinding`
L15 · [class] public final LayoutDialogTipBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogTipBinding.java`

字段/常量（6）：
- `Button dialogTipCancel`  L16
- `Button dialogTipConfirm`  L17
- `LinearLayout dialogTipContent`  L18
- `TextView dialogTipMessage`  L19
- `RelativeLayout rootView`  L20
- `int i = R.id.dialog_tip_cancel`  L48

方法（5）：
- `private LayoutDialogTipBinding(RelativeLayout rootView, Button dialogTipCancel, Button dialogTipConfirm, LinearLayout dialogTipContent, TextView dialogTipMessage)`  L22
- `RelativeLayout getRoot()`  L31 @Override
- `LayoutDialogTipBinding inflate(LayoutInflater inflater)`  L35
- `LayoutDialogTipBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `LayoutDialogTipBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.LayoutDialogTitleBinding`
L13 · [class] public final LayoutDialogTitleBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDialogTitleBinding.java`

字段/常量（3）：
- `TextView dialogTitle`  L14
- `LinearLayout rootView`  L15
- `int i = R.id.dialog_title`  L40

方法（5）：
- `private LayoutDialogTitleBinding(LinearLayout rootView, TextView dialogTitle)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `LayoutDialogTitleBinding inflate(LayoutInflater inflater)`  L27
- `LayoutDialogTitleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutDialogTitleBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutDisconnectCamera1Binding`
L16 · [class] public final LayoutDisconnectCamera1Binding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDisconnectCamera1Binding.java`

字段/常量（11）：
- `Button connBtn`  L17
- `ImageView iconRec`  L18
- `Button nextBtn`  L19
- `ImageView picTop`  L20
- `Button previousBtn`  L21
- `RelativeLayout rootView`  L22
- `Button scanBtn`  L23
- `LinearLayout scanBtnLy`  L24
- `TextView textPageStep`  L25
- `TextView textPageTitle`  L26
- `int i = R.id.conn_btn`  L59

方法（5）：
- `private LayoutDisconnectCamera1Binding(RelativeLayout rootView, Button connBtn, ImageView iconRec, Button nextBtn, ImageView picTop, Button previousBtn, Button scanBtn, LinearLayout scanBtnLy, TextView textPageStep, TextView textPageTitle)`  L28
- `RelativeLayout getRoot()`  L42 @Override
- `LayoutDisconnectCamera1Binding inflate(LayoutInflater inflater)`  L46
- `LayoutDisconnectCamera1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L50
- `LayoutDisconnectCamera1Binding bind(View rootView)`  L58
### `com.gku.xtugo.databinding.LayoutDvSetItemBinding`
L15 · [class] public final LayoutDvSetItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutDvSetItemBinding.java`

字段/常量（7）：
- `RelativeLayout itemRealDv`  L16
- `TextView itemTitleDv`  L17
- `TextView itemValueTextDv`  L18
- `SwitchButton itemWechatSwitchDv`  L19
- `ImageView rightArrowDv`  L20
- `RelativeLayout rootView`  L21
- `int i = R.id.item_real_dv`  L50

方法（5）：
- `private LayoutDvSetItemBinding(RelativeLayout rootView, RelativeLayout itemRealDv, TextView itemTitleDv, TextView itemValueTextDv, SwitchButton itemWechatSwitchDv, ImageView rightArrowDv)`  L23
- `RelativeLayout getRoot()`  L33 @Override
- `LayoutDvSetItemBinding inflate(LayoutInflater inflater)`  L37
- `LayoutDvSetItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `LayoutDvSetItemBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.LayoutFastSettingItemBinding`
L13 · [class] public final LayoutFastSettingItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutFastSettingItemBinding.java`

字段/常量（3）：
- `ImageView itemImage`  L14
- `ConstraintLayout rootView`  L15
- `int i = R.id.item_image`  L40

方法（5）：
- `private LayoutFastSettingItemBinding(ConstraintLayout rootView, ImageView itemImage)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `LayoutFastSettingItemBinding inflate(LayoutInflater inflater)`  L27
- `LayoutFastSettingItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutFastSettingItemBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutFastSettingItemClickBinding`
L13 · [class] public final LayoutFastSettingItemClickBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutFastSettingItemClickBinding.java`

字段/常量（5）：
- `LayoutFastSettingItemBinding fastSettingParent`  L14
- `TextView itemDesc`  L15
- `ConstraintLayout rootView`  L16
- `int i = R.id.fast_setting_parent`  L42
- `int i2 = R.id.item_desc`  L46

方法（5）：
- `private LayoutFastSettingItemClickBinding(ConstraintLayout rootView, LayoutFastSettingItemBinding fastSettingParent, TextView itemDesc)`  L18
- `ConstraintLayout getRoot()`  L25 @Override
- `LayoutFastSettingItemClickBinding inflate(LayoutInflater inflater)`  L29
- `LayoutFastSettingItemClickBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `LayoutFastSettingItemClickBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.LayoutFastSettingItemSelectBinding`
L13 · [class] public final LayoutFastSettingItemSelectBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutFastSettingItemSelectBinding.java`

字段/常量（6）：
- `LayoutFastSettingItemBinding fastSettingParent`  L14
- `TextView itemDesc`  L15
- `TextView itemValue`  L16
- `ConstraintLayout rootView`  L17
- `int i = R.id.fast_setting_parent`  L44
- `int i2 = R.id.item_desc`  L48

方法（5）：
- `private LayoutFastSettingItemSelectBinding(ConstraintLayout rootView, LayoutFastSettingItemBinding fastSettingParent, TextView itemDesc, TextView itemValue)`  L19
- `ConstraintLayout getRoot()`  L27 @Override
- `LayoutFastSettingItemSelectBinding inflate(LayoutInflater inflater)`  L31
- `LayoutFastSettingItemSelectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L35
- `LayoutFastSettingItemSelectBinding bind(View rootView)`  L43
### `com.gku.xtugo.databinding.LayoutFastSettingPopupRecycleItemBinding`
L14 · [class] public final LayoutFastSettingPopupRecycleItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutFastSettingPopupRecycleItemBinding.java`

字段/常量（4）：
- `LinearLayout rootView`  L15
- `ImageView ssFastSettingPopupListItemSelected`  L16
- `TextView ssFastSettingPopupListItemText`  L17
- `int i = R.id.ss_fast_setting_popup_list_item_selected`  L43

方法（5）：
- `private LayoutFastSettingPopupRecycleItemBinding(LinearLayout rootView, ImageView ssFastSettingPopupListItemSelected, TextView ssFastSettingPopupListItemText)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `LayoutFastSettingPopupRecycleItemBinding inflate(LayoutInflater inflater)`  L30
- `LayoutFastSettingPopupRecycleItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutFastSettingPopupRecycleItemBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutFastSettingPopupViewBinding`
L13 · [class] public final LayoutFastSettingPopupViewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutFastSettingPopupViewBinding.java`

字段/常量（3）：
- `LinearLayout rootView`  L14
- `RecyclerView ssFastSettingPopupRecycle`  L15
- `int i = R.id.ss_fast_setting_popup_recycle`  L40

方法（5）：
- `private LayoutFastSettingPopupViewBinding(LinearLayout rootView, RecyclerView ssFastSettingPopupRecycle)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `LayoutFastSettingPopupViewBinding inflate(LayoutInflater inflater)`  L27
- `LayoutFastSettingPopupViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutFastSettingPopupViewBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutIssueSelectItemBinding`
L13 · [class] public final LayoutIssueSelectItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutIssueSelectItemBinding.java`

字段/常量（3）：
- `TextView issueSelectItemTitle`  L14
- `ConstraintLayout rootView`  L15
- `int i = R.id.issue_select_item_title`  L40

方法（5）：
- `private LayoutIssueSelectItemBinding(ConstraintLayout rootView, TextView issueSelectItemTitle)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `LayoutIssueSelectItemBinding inflate(LayoutInflater inflater)`  L27
- `LayoutIssueSelectItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutIssueSelectItemBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutLivePlatformBinding`
L13 · [class] public final LayoutLivePlatformBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutLivePlatformBinding.java`

字段/常量（3）：
- `ImageView layoutLivePlatformImage`  L14
- `LinearLayout rootView`  L15
- `int i = R.id.layout_live_platform_image`  L40

方法（5）：
- `private LayoutLivePlatformBinding(LinearLayout rootView, ImageView layoutLivePlatformImage)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `LayoutLivePlatformBinding inflate(LayoutInflater inflater)`  L27
- `LayoutLivePlatformBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutLivePlatformBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutModeSelectPopupListItemBinding`
L14 · [class] public final LayoutModeSelectPopupListItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutModeSelectPopupListItemBinding.java`

字段/常量（6）：
- `ImageView layoutSsSelectPopupListItemIcon`  L15
- `ImageView layoutSsSelectPopupListItemSelected`  L16
- `TextView layoutSsSelectPopupListItemText`  L17
- `LinearLayout rootView`  L18
- `LinearLayout selectPopupItem`  L19
- `int i = R.id.layout_ss_select_popup_list_item_icon`  L47

方法（5）：
- `private LayoutModeSelectPopupListItemBinding(LinearLayout rootView, ImageView layoutSsSelectPopupListItemIcon, ImageView layoutSsSelectPopupListItemSelected, TextView layoutSsSelectPopupListItemText, LinearLayout selectPopupItem)`  L21
- `LinearLayout getRoot()`  L30 @Override
- `LayoutModeSelectPopupListItemBinding inflate(LayoutInflater inflater)`  L34
- `LayoutModeSelectPopupListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `LayoutModeSelectPopupListItemBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.LayoutModeSelectPopupViewBinding`
L14 · [class] public final LayoutModeSelectPopupViewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutModeSelectPopupViewBinding.java`

字段/常量（12）：
- `RecyclerView layoutSsModeSelectPopupList`  L15
- `LinearLayout layoutSsModeSelectPopupPhoto`  L16
- `View layoutSsModeSelectPopupPhotoSelected`  L17
- `LinearLayout layoutSsModeSelectPopupVideo`  L18
- `View layoutSsModeSelectPopupVideoSelected`  L19
- `TextView popupPhotoText`  L20
- `TextView popupVideoText`  L21
- `LinearLayout rootView`  L22
- `LinearLayout selectPopupView`  L23
- `View viewFindChildViewById`  L55
- `View viewFindChildViewById2`  L56
- `int i = R.id.layout_ss_mode_select_popup_list`  L57

方法（5）：
- `private LayoutModeSelectPopupViewBinding(LinearLayout rootView, RecyclerView layoutSsModeSelectPopupList, LinearLayout layoutSsModeSelectPopupPhoto, View layoutSsModeSelectPopupPhotoSelected, LinearLayout layoutSsModeSelectPopupVideo, View layoutSsModeSelectPopupVideoSelected, TextView popupPhotoText, TextView popupVideoText, LinearLayout selectPopupView)`  L25
- `LinearLayout getRoot()`  L38 @Override
- `LayoutModeSelectPopupViewBinding inflate(LayoutInflater inflater)`  L42
- `LayoutModeSelectPopupViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `LayoutModeSelectPopupViewBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.LayoutModeSetItemBinding`
L14 · [class] public final LayoutModeSetItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutModeSetItemBinding.java`

字段/常量（6）：
- `RelativeLayout itemReal`  L15
- `TextView itemTitle`  L16
- `TextView itemValueText`  L17
- `ImageView rightArrow`  L18
- `RelativeLayout rootView`  L19
- `int i = R.id.item_real`  L47

方法（5）：
- `private LayoutModeSetItemBinding(RelativeLayout rootView, RelativeLayout itemReal, TextView itemTitle, TextView itemValueText, ImageView rightArrow)`  L21
- `RelativeLayout getRoot()`  L30 @Override
- `LayoutModeSetItemBinding inflate(LayoutInflater inflater)`  L34
- `LayoutModeSetItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `LayoutModeSetItemBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.LayoutPermissionAgreementBinding`
L14 · [class] public final LayoutPermissionAgreementBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutPermissionAgreementBinding.java`

字段/常量（6）：
- `Button agree`  L15
- `Button disagree`  L16
- `TextView permissionContent`  L17
- `TextView permissionTitle`  L18
- `ConstraintLayout rootView`  L19
- `int i = R.id.agree`  L47

方法（5）：
- `private LayoutPermissionAgreementBinding(ConstraintLayout rootView, Button agree, Button disagree, TextView permissionContent, TextView permissionTitle)`  L21
- `ConstraintLayout getRoot()`  L30 @Override
- `LayoutPermissionAgreementBinding inflate(LayoutInflater inflater)`  L34
- `LayoutPermissionAgreementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `LayoutPermissionAgreementBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.LayoutPhotosBinding`
L13 · [class] public final LayoutPhotosBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutPhotosBinding.java`

字段/常量（3）：
- `FrameLayout ffContainerPhoto`  L14
- `RelativeLayout rootView`  L15
- `int i = R.id.ff_container_photo`  L40

方法（5）：
- `private LayoutPhotosBinding(RelativeLayout rootView, FrameLayout ffContainerPhoto)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `LayoutPhotosBinding inflate(LayoutInflater inflater)`  L27
- `LayoutPhotosBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutPhotosBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutPreferTitleBinding`
L14 · [class] public final LayoutPreferTitleBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutPreferTitleBinding.java`

字段/常量（5）：
- `TextView deviceSetTv`  L15
- `ImageView icBack`  L16
- `TextView modeSetTv`  L17
- `RelativeLayout rootView`  L18
- `int i = R.id.device_set_tv`  L45

方法（5）：
- `private LayoutPreferTitleBinding(RelativeLayout rootView, TextView deviceSetTv, ImageView icBack, TextView modeSetTv)`  L20
- `RelativeLayout getRoot()`  L28 @Override
- `LayoutPreferTitleBinding inflate(LayoutInflater inflater)`  L32
- `LayoutPreferTitleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `LayoutPreferTitleBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.LayoutPrivacyAgreementBinding`
L14 · [class] public final LayoutPrivacyAgreementBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutPrivacyAgreementBinding.java`

字段/常量（7）：
- `TextView paAgree`  L15
- `TextView paCancel`  L16
- `LinearLayout paControl`  L17
- `WebView privacyWebView`  L18
- `LinearLayout rootView`  L19
- `TextView welcomePrTip`  L20
- `int i = R.id.pa_agree`  L49

方法（5）：
- `private LayoutPrivacyAgreementBinding(LinearLayout rootView, TextView paAgree, TextView paCancel, LinearLayout paControl, WebView privacyWebView, TextView welcomePrTip)`  L22
- `LinearLayout getRoot()`  L32 @Override
- `LayoutPrivacyAgreementBinding inflate(LayoutInflater inflater)`  L36
- `LayoutPrivacyAgreementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `LayoutPrivacyAgreementBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.LayoutPrivacyWebViewBinding`
L14 · [class] public final LayoutPrivacyWebViewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutPrivacyWebViewBinding.java`

字段/常量（7）：
- `TextView paAgree`  L15
- `TextView paCancel`  L16
- `LinearLayout paControl`  L17
- `WebView privacyWebView`  L18
- `LinearLayout rootView`  L19
- `TextView welcomePrTip`  L20
- `int i = R.id.pa_agree`  L49

方法（5）：
- `private LayoutPrivacyWebViewBinding(LinearLayout rootView, TextView paAgree, TextView paCancel, LinearLayout paControl, WebView privacyWebView, TextView welcomePrTip)`  L22
- `LinearLayout getRoot()`  L32 @Override
- `LayoutPrivacyWebViewBinding inflate(LayoutInflater inflater)`  L36
- `LayoutPrivacyWebViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `LayoutPrivacyWebViewBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.LayoutQuestionSelectTitleBarBinding`
L14 · [class] public final LayoutQuestionSelectTitleBarBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutQuestionSelectTitleBarBinding.java`

字段/常量（4）：
- `ImageView ivBackQuestionSelect`  L15
- `TextView layoutTitleQuestionSelect`  L16
- `ConstraintLayout rootView`  L17
- `int i = R.id.iv_back_question_select`  L43

方法（5）：
- `private LayoutQuestionSelectTitleBarBinding(ConstraintLayout rootView, ImageView ivBackQuestionSelect, TextView layoutTitleQuestionSelect)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `LayoutQuestionSelectTitleBarBinding inflate(LayoutInflater inflater)`  L30
- `LayoutQuestionSelectTitleBarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutQuestionSelectTitleBarBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutRefreshFooterBinding`
L14 · [class] public final LayoutRefreshFooterBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutRefreshFooterBinding.java`

字段/常量（5）：
- `LinearLayout llEnd`  L15
- `ProgressBar pbLoading`  L16
- `LinearLayout rootView`  L17
- `TextView tvLoading`  L18
- `int i = R.id.ll_end`  L45

方法（5）：
- `private LayoutRefreshFooterBinding(LinearLayout rootView, LinearLayout llEnd, ProgressBar pbLoading, TextView tvLoading)`  L20
- `LinearLayout getRoot()`  L28 @Override
- `LayoutRefreshFooterBinding inflate(LayoutInflater inflater)`  L32
- `LayoutRefreshFooterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `LayoutRefreshFooterBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.LayoutScanWifiListItemBinding`
L14 · [class] public final LayoutScanWifiListItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutScanWifiListItemBinding.java`

字段/常量（4）：
- `ConstraintLayout rootView`  L15
- `TextView scanWifiListItemName`  L16
- `ImageView scanWifiListItemStrength`  L17
- `int i = R.id.scan_wifi_list_item_name`  L43

方法（5）：
- `private LayoutScanWifiListItemBinding(ConstraintLayout rootView, TextView scanWifiListItemName, ImageView scanWifiListItemStrength)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `LayoutScanWifiListItemBinding inflate(LayoutInflater inflater)`  L30
- `LayoutScanWifiListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutScanWifiListItemBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutSsListDialogRecycleOperateItemBinding`
L14 · [class] public final LayoutSsListDialogRecycleOperateItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutSsListDialogRecycleOperateItemBinding.java`

字段/常量（4）：
- `ConstraintLayout rootView`  L15
- `ImageView ssListDialogRecycleOperateItemIcon`  L16
- `TextView ssListDialogRecycleOperateItemName`  L17
- `int i = R.id.ss_list_dialog_recycle_operate_item_icon`  L43

方法（5）：
- `private LayoutSsListDialogRecycleOperateItemBinding(ConstraintLayout rootView, ImageView ssListDialogRecycleOperateItemIcon, TextView ssListDialogRecycleOperateItemName)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `LayoutSsListDialogRecycleOperateItemBinding inflate(LayoutInflater inflater)`  L30
- `LayoutSsListDialogRecycleOperateItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutSsListDialogRecycleOperateItemBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutSsListDialogRecycleSettingItemBinding`
L14 · [class] public final LayoutSsListDialogRecycleSettingItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutSsListDialogRecycleSettingItemBinding.java`

字段/常量（4）：
- `ConstraintLayout rootView`  L15
- `TextView ssListDialogRecycleSettingItemName`  L16
- `ImageView ssListDialogRecycleSettingItemSelected`  L17
- `int i = R.id.ss_list_dialog_recycle_setting_item_name`  L43

方法（5）：
- `private LayoutSsListDialogRecycleSettingItemBinding(ConstraintLayout rootView, TextView ssListDialogRecycleSettingItemName, ImageView ssListDialogRecycleSettingItemSelected)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `LayoutSsListDialogRecycleSettingItemBinding inflate(LayoutInflater inflater)`  L30
- `LayoutSsListDialogRecycleSettingItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutSsListDialogRecycleSettingItemBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutSsPlaybackPopupSelectButtonBinding`
L13 · [class] public final LayoutSsPlaybackPopupSelectButtonBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutSsPlaybackPopupSelectButtonBinding.java`

字段/常量（5）：
- `LinearLayout rootView`  L14
- `Button ssSelectModeButtonAllSelect`  L15
- `Button ssSelectModeButtonDelete`  L16
- `Button ssSelectModeButtonDownload`  L17
- `int i = R.id.ss_select_mode_button_all_select`  L44

方法（5）：
- `private LayoutSsPlaybackPopupSelectButtonBinding(LinearLayout rootView, Button ssSelectModeButtonAllSelect, Button ssSelectModeButtonDelete, Button ssSelectModeButtonDownload)`  L19
- `LinearLayout getRoot()`  L27 @Override
- `LayoutSsPlaybackPopupSelectButtonBinding inflate(LayoutInflater inflater)`  L31
- `LayoutSsPlaybackPopupSelectButtonBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L35
- `LayoutSsPlaybackPopupSelectButtonBinding bind(View rootView)`  L43
### `com.gku.xtugo.databinding.LayoutSSPlaybackRecycleItemBinding`
L15 · [class] public final LayoutSSPlaybackRecycleItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutSSPlaybackRecycleItemBinding.java`

字段/常量（7）：
- `ImageView ivPlay`  L16
- `FrameLayout rootView`  L17
- `ImageView ssPlaybackItemSelectImage`  L18
- `TextView ssPlaybackRecycleItemDownload`  L19
- `PlaybackImageView ssPlaybackRecycleItemImage`  L20
- `TextView ssPlaybackRecycleItemTime`  L21
- `int i = R.id.iv_play`  L50

方法（5）：
- `private LayoutSSPlaybackRecycleItemBinding(FrameLayout rootView, ImageView ivPlay, ImageView ssPlaybackItemSelectImage, TextView ssPlaybackRecycleItemDownload, PlaybackImageView ssPlaybackRecycleItemImage, TextView ssPlaybackRecycleItemTime)`  L23
- `FrameLayout getRoot()`  L33 @Override
- `LayoutSSPlaybackRecycleItemBinding inflate(LayoutInflater inflater)`  L37
- `LayoutSSPlaybackRecycleItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `LayoutSSPlaybackRecycleItemBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.LayoutSSRemoteFragmentBinding`
L15 · [class] public final LayoutSSRemoteFragmentBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutSSRemoteFragmentBinding.java`

字段/常量（6）：
- `LayoutSsPlaybackPopupSelectButtonBinding layoutSsPlaybackSelectModeButton`  L16
- `FrameLayout rootView`  L17
- `RecyclerView ssRemoteRecycle`  L18
- `SmartRefreshLayout ssRemoteRefresh`  L19
- `TextView tvNoFile`  L20
- `int i = R.id.layout_ss_playback_select_mode_button`  L48

方法（5）：
- `private LayoutSSRemoteFragmentBinding(FrameLayout rootView, LayoutSsPlaybackPopupSelectButtonBinding layoutSsPlaybackSelectModeButton, RecyclerView ssRemoteRecycle, SmartRefreshLayout ssRemoteRefresh, TextView tvNoFile)`  L22
- `FrameLayout getRoot()`  L31 @Override
- `LayoutSSRemoteFragmentBinding inflate(LayoutInflater inflater)`  L35
- `LayoutSSRemoteFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `LayoutSSRemoteFragmentBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.LayoutSsSettingItemClickBinding`
L13 · [class] public final LayoutSsSettingItemClickBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutSsSettingItemClickBinding.java`

字段/常量（3）：
- `ConstraintLayout rootView`  L14
- `TextView ssSettingItemName`  L15
- `int i = R.id.ss_setting_item_name`  L40

方法（5）：
- `private LayoutSsSettingItemClickBinding(ConstraintLayout rootView, TextView ssSettingItemName)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `LayoutSsSettingItemClickBinding inflate(LayoutInflater inflater)`  L27
- `LayoutSsSettingItemClickBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutSsSettingItemClickBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutSsSettingItemSelectBinding`
L14 · [class] public final LayoutSsSettingItemSelectBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutSsSettingItemSelectBinding.java`

字段/常量（5）：
- `ConstraintLayout rootView`  L15
- `TextView ssSettingItemName`  L16
- `ImageView ssSettingItemRight`  L17
- `TextView ssSettingItemValue`  L18
- `int i = R.id.ss_setting_item_name`  L45

方法（5）：
- `private LayoutSsSettingItemSelectBinding(ConstraintLayout rootView, TextView ssSettingItemName, ImageView ssSettingItemRight, TextView ssSettingItemValue)`  L20
- `ConstraintLayout getRoot()`  L28 @Override
- `LayoutSsSettingItemSelectBinding inflate(LayoutInflater inflater)`  L32
- `LayoutSsSettingItemSelectBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `LayoutSsSettingItemSelectBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.LayoutSsSettingItemSwitchBinding`
L14 · [class] public final LayoutSsSettingItemSwitchBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutSsSettingItemSwitchBinding.java`

字段/常量（4）：
- `ConstraintLayout rootView`  L15
- `TextView ssSettingItemName`  L16
- `SwitchCompat ssSettingItemSwitch`  L17
- `int i = R.id.ss_setting_item_name`  L43

方法（5）：
- `private LayoutSsSettingItemSwitchBinding(ConstraintLayout rootView, TextView ssSettingItemName, SwitchCompat ssSettingItemSwitch)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `LayoutSsSettingItemSwitchBinding inflate(LayoutInflater inflater)`  L30
- `LayoutSsSettingItemSwitchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutSsSettingItemSwitchBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutStateviewBinding`
L14 · [class] public final LayoutStateviewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutStateviewBinding.java`

字段/常量（4）：
- `ImageView ivState`  L15
- `LinearLayout rootView`  L16
- `TextView tvMessage`  L17
- `int i = R.id.iv_state`  L43

方法（5）：
- `private LayoutStateviewBinding(LinearLayout rootView, ImageView ivState, TextView tvMessage)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `LayoutStateviewBinding inflate(LayoutInflater inflater)`  L30
- `LayoutStateviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutStateviewBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutTabSegmentBinding`
L13 · [class] public final LayoutTabSegmentBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutTabSegmentBinding.java`

字段/常量（3）：
- `RelativeLayout rootView`  L14
- `TextView tvTabTitle`  L15
- `int i = R.id.tv_tab_title`  L40

方法（5）：
- `private LayoutTabSegmentBinding(RelativeLayout rootView, TextView tvTabTitle)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `LayoutTabSegmentBinding inflate(LayoutInflater inflater)`  L27
- `LayoutTabSegmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutTabSegmentBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutTitleBarBinding`
L15 · [class] public final LayoutTitleBarBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutTitleBarBinding.java`

字段/常量（18）：
- `TextView albumText`  L16
- `ImageView centerLogo`  L17
- `ImageView icBack`  L18
- `ImageView icSetting`  L19
- `ImageView ivAdd`  L20
- `ImageView ivBluetoothIcon`  L21
- `ImageView ivEnterSelectAll`  L22
- `ImageView ivQuitSelectAll`  L23
- `ImageView ivUpgrade`  L24
- `LinearLayoutShape layoutRed`  L25
- `RelativeLayout layoutSetting`  L26
- `RelativeLayout layoutTitle`  L27
- `RelativeLayout rootView`  L28
- `TextView tvSelectAll`  L29
- `TextView tvUnselectAll`  L30
- `TextView tvUserCenter`  L31
- `TextView tvXtuPlus`  L32
- `int i = R.id.album_text`  L72

方法（5）：
- `private LayoutTitleBarBinding(RelativeLayout rootView, TextView albumText, ImageView centerLogo, ImageView icBack, ImageView icSetting, ImageView ivAdd, ImageView ivBluetoothIcon, ImageView ivEnterSelectAll, ImageView ivQuitSelectAll, ImageView ivUpgrade, LinearLayoutShape layoutRed, RelativeLayout layoutSetting, RelativeLayout layoutTitle, TextView tvSelectAll, TextView tvUnselectAll, TextView tvUserCenter, TextView tvXtuPlus)`  L34
- `RelativeLayout getRoot()`  L55 @Override
- `LayoutTitleBarBinding inflate(LayoutInflater inflater)`  L59
- `LayoutTitleBarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L63
- `LayoutTitleBarBinding bind(View rootView)`  L71
### `com.gku.xtugo.databinding.LayoutTitleUserGuideBinding`
L14 · [class] public final LayoutTitleUserGuideBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutTitleUserGuideBinding.java`

字段/常量（4）：
- `ImageView ivBackUser`  L15
- `TextView layoutTitleUser`  L16
- `ConstraintLayout rootView`  L17
- `int i = R.id.iv_back_user`  L43

方法（5）：
- `private LayoutTitleUserGuideBinding(ConstraintLayout rootView, ImageView ivBackUser, TextView layoutTitleUser)`  L19
- `ConstraintLayout getRoot()`  L26 @Override
- `LayoutTitleUserGuideBinding inflate(LayoutInflater inflater)`  L30
- `LayoutTitleUserGuideBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LayoutTitleUserGuideBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LayoutTopPopupRecycleItemBinding`
L15 · [class] public final LayoutTopPopupRecycleItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutTopPopupRecycleItemBinding.java`

字段/常量（5）：
- `Button popupButton`  L16
- `ImageView popupImage`  L17
- `TextView popupText`  L18
- `ConstraintLayout rootView`  L19
- `int i = R.id.popup_button`  L46

方法（5）：
- `private LayoutTopPopupRecycleItemBinding(ConstraintLayout rootView, Button popupButton, ImageView popupImage, TextView popupText)`  L21
- `ConstraintLayout getRoot()`  L29 @Override
- `LayoutTopPopupRecycleItemBinding inflate(LayoutInflater inflater)`  L33
- `LayoutTopPopupRecycleItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `LayoutTopPopupRecycleItemBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.LayoutTopPopupViewBinding`
L13 · [class] public final LayoutTopPopupViewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutTopPopupViewBinding.java`

字段/常量（3）：
- `ConstraintLayout rootView`  L14
- `RecyclerView topPopupList`  L15
- `int i = R.id.top_popup_list`  L40

方法（5）：
- `private LayoutTopPopupViewBinding(ConstraintLayout rootView, RecyclerView topPopupList)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `LayoutTopPopupViewBinding inflate(LayoutInflater inflater)`  L27
- `LayoutTopPopupViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutTopPopupViewBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutUserCenterItemBinding`
L14 · [class] public final LayoutUserCenterItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutUserCenterItemBinding.java`

字段/常量（6）：
- `ImageView itemIcon`  L15
- `ImageView itemNext`  L16
- `RelativeLayout itemRela`  L17
- `TextView itemTitle`  L18
- `RelativeLayout rootView`  L19
- `int i = R.id.item_icon`  L47

方法（5）：
- `private LayoutUserCenterItemBinding(RelativeLayout rootView, ImageView itemIcon, ImageView itemNext, RelativeLayout itemRela, TextView itemTitle)`  L21
- `RelativeLayout getRoot()`  L30 @Override
- `LayoutUserCenterItemBinding inflate(LayoutInflater inflater)`  L34
- `LayoutUserCenterItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `LayoutUserCenterItemBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.LayoutUserGuideBinding`
L16 · [class] public final LayoutUserGuideBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutUserGuideBinding.java`

字段/常量（8）：
- `LinearLayout buttonLayout`  L17
- `Button nextBtn`  L18
- `TextView pageContent`  L19
- `TextView pageTitle`  L20
- `Button previousBtn`  L21
- `PhotoViewPager pvPager`  L22
- `ConstraintLayout rootView`  L23
- `int i = R.id.button_layout`  L53

方法（5）：
- `private LayoutUserGuideBinding(ConstraintLayout rootView, LinearLayout buttonLayout, Button nextBtn, TextView pageContent, TextView pageTitle, Button previousBtn, PhotoViewPager pvPager)`  L25
- `ConstraintLayout getRoot()`  L36 @Override
- `LayoutUserGuideBinding inflate(LayoutInflater inflater)`  L40
- `LayoutUserGuideBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L44
- `LayoutUserGuideBinding bind(View rootView)`  L52
### `com.gku.xtugo.databinding.LayoutVideoOperaBinding`
L15 · [class] public final LayoutVideoOperaBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutVideoOperaBinding.java`

字段/常量（6）：
- `LinearLayout rootView`  L16
- `ImageView videoOperaOrientation`  L17
- `ImageView videoOperaPlay`  L18
- `AppCompatSeekBar videoOperaSeek`  L19
- `TextView videoOperaTime`  L20
- `int i = R.id.video_opera_orientation`  L48

方法（5）：
- `private LayoutVideoOperaBinding(LinearLayout rootView, ImageView videoOperaOrientation, ImageView videoOperaPlay, AppCompatSeekBar videoOperaSeek, TextView videoOperaTime)`  L22
- `LinearLayout getRoot()`  L31 @Override
- `LayoutVideoOperaBinding inflate(LayoutInflater inflater)`  L35
- `LayoutVideoOperaBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `LayoutVideoOperaBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.LayoutVideosBinding`
L13 · [class] public final LayoutVideosBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutVideosBinding.java`

字段/常量（3）：
- `FrameLayout ffContainerVideos`  L14
- `RelativeLayout rootView`  L15
- `int i = R.id.ff_container_videos`  L40

方法（5）：
- `private LayoutVideosBinding(RelativeLayout rootView, FrameLayout ffContainerVideos)`  L17
- `RelativeLayout getRoot()`  L23 @Override
- `LayoutVideosBinding inflate(LayoutInflater inflater)`  L27
- `LayoutVideosBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LayoutVideosBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LayoutWechatCenterBinding`
L13 · [class] public final LayoutWechatCenterBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutWechatCenterBinding.java`

字段/常量（4）：
- `Button cancel`  L14
- `LinearLayout rootView`  L15
- `Button sure`  L16
- `int i = R.id.cancel`  L42

方法（5）：
- `private LayoutWechatCenterBinding(LinearLayout rootView, Button cancel, Button sure)`  L18
- `LinearLayout getRoot()`  L25 @Override
- `LayoutWechatCenterBinding inflate(LayoutInflater inflater)`  L29
- `LayoutWechatCenterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `LayoutWechatCenterBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.LayoutWifiDialogBinding`
L15 · [class] public final LayoutWifiDialogBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutWifiDialogBinding.java`

字段/常量（9）：
- `LinearLayout rootView`  L16
- `TextView scanWifiDialogNegative`  L17
- `TextView scanWifiDialogPositive`  L18
- `EditText scanWifiDialogPwdEdit`  L19
- `ImageView scanWifiDialogPwdVisibility`  L20
- `EditText scanWifiDialogSsidEdit`  L21
- `TextView scanWifiDialogSsidText`  L22
- `LinearLayout scanWifiSsidLinear`  L23
- `int i = R.id.scan_wifi_dialog_negative`  L54

方法（5）：
- `private LayoutWifiDialogBinding(LinearLayout rootView, TextView scanWifiDialogNegative, TextView scanWifiDialogPositive, EditText scanWifiDialogPwdEdit, ImageView scanWifiDialogPwdVisibility, EditText scanWifiDialogSsidEdit, TextView scanWifiDialogSsidText, LinearLayout scanWifiSsidLinear)`  L25
- `LinearLayout getRoot()`  L37 @Override
- `LayoutWifiDialogBinding inflate(LayoutInflater inflater)`  L41
- `LayoutWifiDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L45
- `LayoutWifiDialogBinding bind(View rootView)`  L53
### `com.gku.xtugo.databinding.LayoutXtuPlusBinding`
L15 · [class] public final LayoutXtuPlusBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LayoutXtuPlusBinding.java`

字段/常量（5）：
- `SimpleIndicatorView indicator`  L16
- `LinearLayout rootView`  L17
- `TextViewShape tvStartLive`  L18
- `ViewPager2 vp2LoopBanner`  L19
- `int i = R.id.indicator`  L46

方法（5）：
- `private LayoutXtuPlusBinding(LinearLayout rootView, SimpleIndicatorView indicator, TextViewShape tvStartLive, ViewPager2 vp2LoopBanner)`  L21
- `LinearLayout getRoot()`  L29 @Override
- `LayoutXtuPlusBinding inflate(LayoutInflater inflater)`  L33
- `LayoutXtuPlusBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `LayoutXtuPlusBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.ListItemsBinding`
L14 · [class] public final ListItemsBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ListItemsBinding.java`

字段/常量（4）：
- `TextView ItemTitle`  L15
- `ImageView imagelast`  L16
- `LinearLayout rootView`  L17
- `int i = R.id.ItemTitle`  L43

方法（5）：
- `private ListItemsBinding(LinearLayout rootView, TextView ItemTitle, ImageView imagelast)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `ListItemsBinding inflate(LayoutInflater inflater)`  L30
- `ListItemsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ListItemsBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.LoadDialogBigBinding`
L13 · [class] public final LoadDialogBigBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LoadDialogBigBinding.java`

字段/常量（3）：
- `LinearLayout rootView`  L14
- `TextView tvLoadDialog`  L15
- `int i = R.id.tv_load_dialog`  L40

方法（5）：
- `private LoadDialogBigBinding(LinearLayout rootView, TextView tvLoadDialog)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `LoadDialogBigBinding inflate(LayoutInflater inflater)`  L27
- `LoadDialogBigBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LoadDialogBigBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LoadDialogBinding`
L13 · [class] public final LoadDialogBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LoadDialogBinding.java`

字段/常量（3）：
- `LinearLayout rootView`  L14
- `TextView tvLoadDialog`  L15
- `int i = R.id.tv_load_dialog`  L40

方法（5）：
- `private LoadDialogBinding(LinearLayout rootView, TextView tvLoadDialog)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `LoadDialogBinding inflate(LayoutInflater inflater)`  L27
- `LoadDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `LoadDialogBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.LocalFirmwareItemBinding`
L14 · [class] public final LocalFirmwareItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/LocalFirmwareItemBinding.java`

字段/常量（4）：
- `Button btnUpgradeFirmware`  L15
- `LinearLayout rootView`  L16
- `TextView textFirmwareName`  L17
- `int i = R.id.btnUpgradeFirmware`  L43

方法（5）：
- `private LocalFirmwareItemBinding(LinearLayout rootView, Button btnUpgradeFirmware, TextView textFirmwareName)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `LocalFirmwareItemBinding inflate(LayoutInflater inflater)`  L30
- `LocalFirmwareItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `LocalFirmwareItemBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.MainBinding`
L15 · [class] public final MainBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MainBinding.java`

字段/常量（12）：
- `View grayArea`  L16
- `ImageView ivCountDownBackground`  L17
- `ImageView ivSavedSign`  L18
- `RelativeLayout layoutFragLand`  L19
- `RelativeLayout layoutFragPort`  L20
- `RelativeLayout rootView`  L21
- `SurfaceView surfaceView`  L22
- `TextView tvCountDownTime`  L23
- `TextView tvPrompt`  L24
- `View viewSpaceLayout`  L25
- `View viewFindChildViewById`  L58
- `int i = R.id.grayArea`  L59

方法（5）：
- `private MainBinding(RelativeLayout rootView, View grayArea, ImageView ivCountDownBackground, ImageView ivSavedSign, RelativeLayout layoutFragLand, RelativeLayout layoutFragPort, SurfaceView surfaceView, TextView tvCountDownTime, TextView tvPrompt, View viewSpaceLayout)`  L27
- `RelativeLayout getRoot()`  L41 @Override
- `MainBinding inflate(LayoutInflater inflater)`  L45
- `MainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L49
- `MainBinding bind(View rootView)`  L57
### `com.gku.xtugo.databinding.MainFragLandBinding`
L16 · [class] public final MainFragLandBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MainFragLandBinding.java`

字段/常量（32）：
- `ImageView cameraStatusImage`  L17
- `ImageView exitQuickVideo`  L18
- `ImageView ivArrowTimeMenu`  L19
- `ImageView ivBatteryCapacity`  L20
- `ImageView ivBrowseFile`  L21
- `ImageView ivCaptureType`  L22
- `ImageView ivCommand`  L23
- `ImageView ivLoopRecording`  L24
- `ImageView ivModeMenu`  L25
- `ImageView ivModeMore`  L26
- `ImageView ivPower`  L27
- `ImageView ivRecordSign`  L28
- `ImageView ivSettings`  L29
- `ImageView ivWifiSignal`  L30
- `RelativeLayout layoutCommandBar`  L31
- `LinearLayout layoutInfoBar`  L32
- `RelativeLayout layoutRecordTimeBar`  L33
- `RelativeLayout layoutSetCapture`  L34
- `RelativeLayout layoutSetMode`  L35
- `RelativeLayout layoutSettingBar`  L36
- `ProgressBar pbStorageUsageVolume`  L37
- `RelativeLayout rootView`  L38
- `ImageView shortVideoAddTime`  L39
- `TextView shortVideoAddTimeText`  L40
- `TextView shortVideoTimeText`  L41
- `TextView tvCaptureInfo`  L42
- `TextView tvRecordTime`  L43
- `TextView tvResolution`  L44
- `TextView tvStorageAvailable`  L45
- `View viewCoverOnPowerOff`  L46
- `View viewFindChildViewById`  L99
- `int i = R.id.camera_status_image`  L100

方法（5）：
- `private MainFragLandBinding(RelativeLayout rootView, ImageView cameraStatusImage, ImageView exitQuickVideo, ImageView ivArrowTimeMenu, ImageView ivBatteryCapacity, ImageView ivBrowseFile, ImageView ivCaptureType, ImageView ivCommand, ImageView ivLoopRecording, ImageView ivModeMenu, ImageView ivModeMore, ImageView ivPower, ImageView ivRecordSign, ImageView ivSettings, ImageView ivWifiSignal, RelativeLayout layoutCommandBar, LinearLayout layoutInfoBar, RelativeLayout layoutRecordTimeBar, RelativeLayout layoutSetCapture, RelativeLayout layoutSetMode, RelativeLayout layoutSettingBar, ProgressBar pbStorageUsageVolume, ImageView shortVideoAddTime, TextView shortVideoAddTimeText, TextView shortVideoTimeText, TextView tvCaptureInfo, TextView tvRecordTime, TextView tvResolution, TextView tvStorageAvailable, View viewCoverOnPowerOff)`  L48
- `RelativeLayout getRoot()`  L82 @Override
- `MainFragLandBinding inflate(LayoutInflater inflater)`  L86
- `MainFragLandBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L90
- `MainFragLandBinding bind(View rootView)`  L98
### `com.gku.xtugo.databinding.MainFragPortBinding`
L16 · [class] public final MainFragPortBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MainFragPortBinding.java`

字段/常量（36）：
- `ImageView cameraStatusImage`  L17
- `ImageView exitQuickVideo`  L18
- `ImageView ivBackPreview`  L19
- `ImageView ivBatteryCapacity`  L20
- `ImageView ivBluetoothTX`  L21
- `ImageView ivBrowseFile`  L22
- `ImageView ivCaptureType`  L23
- `ImageView ivCommand`  L24
- `ImageView ivLoopRecording`  L25
- `ImageView ivModeMenu`  L26
- `ImageView ivModeMore`  L27
- `ImageView ivPower`  L28
- `ImageView ivRecordSign`  L29
- `ImageView ivSettings`  L30
- `ImageView ivWifiSignal`  L31
- `RelativeLayout layoutCommandBar`  L32
- `LinearLayout layoutInfoBar`  L33
- `RelativeLayout layoutRecordTimeBar`  L34
- `RelativeLayout layoutSetCapture`  L35
- `RelativeLayout layoutSetMode`  L36
- `RelativeLayout layoutSettingBar`  L37
- `ImageView mainTopLogo`  L38
- `ProgressBar pbStorageUsageVolume`  L39
- `RelativeLayout rootView`  L40
- `ImageView shortVideoAddTime`  L41
- `TextView shortVideoAddTimeText`  L42
- `TextView shortVideoTimeText`  L43
- `TextView tvCaptureInfo`  L44
- `TextView tvRecordTime`  L45
- `TextView tvResolution`  L46
- `TextView tvStorageAvailable`  L47
- `View vSpace`  L48
- `View viewCoverOnPowerOff`  L49
- `View viewFindChildViewById`  L105
- `View viewFindChildViewById2`  L106
- `int i = R.id.camera_status_image`  L107

方法（5）：
- `private MainFragPortBinding(RelativeLayout rootView, ImageView cameraStatusImage, ImageView exitQuickVideo, ImageView ivBackPreview, ImageView ivBatteryCapacity, ImageView ivBluetoothTX, ImageView ivBrowseFile, ImageView ivCaptureType, ImageView ivCommand, ImageView ivLoopRecording, ImageView ivModeMenu, ImageView ivModeMore, ImageView ivPower, ImageView ivRecordSign, ImageView ivSettings, ImageView ivWifiSignal, RelativeLayout layoutCommandBar, LinearLayout layoutInfoBar, RelativeLayout layoutRecordTimeBar, RelativeLayout layoutSetCapture, RelativeLayout layoutSetMode, RelativeLayout layoutSettingBar, ImageView mainTopLogo, ProgressBar pbStorageUsageVolume, ImageView shortVideoAddTime, TextView shortVideoAddTimeText, TextView shortVideoTimeText, TextView tvCaptureInfo, TextView tvRecordTime, TextView tvResolution, TextView tvStorageAvailable, View vSpace, View viewCoverOnPowerOff)`  L51
- `RelativeLayout getRoot()`  L88 @Override
- `MainFragPortBinding inflate(LayoutInflater inflater)`  L92
- `MainFragPortBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L96
- `MainFragPortBinding bind(View rootView)`  L104
### `com.gku.xtugo.databinding.MediacontrollerBinding`
L15 · [class] public final MediacontrollerBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MediacontrollerBinding.java`

字段/常量（7）：
- `TextView mediacontrollerFileName`  L16
- `ImageButton mediacontrollerPlayPause`  L17
- `SeekBar mediacontrollerSeekbar`  L18
- `TextView mediacontrollerTimeCurrent`  L19
- `TextView mediacontrollerTimeTotal`  L20
- `RelativeLayout rootView`  L21
- `int i = R.id.mediacontroller_file_name`  L50

方法（5）：
- `private MediacontrollerBinding(RelativeLayout rootView, TextView mediacontrollerFileName, ImageButton mediacontrollerPlayPause, SeekBar mediacontrollerSeekbar, TextView mediacontrollerTimeCurrent, TextView mediacontrollerTimeTotal)`  L23
- `RelativeLayout getRoot()`  L33 @Override
- `MediacontrollerBinding inflate(LayoutInflater inflater)`  L37
- `MediacontrollerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `MediacontrollerBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.MenuBurstBinding`
L13 · [class] public final MenuBurstBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MenuBurstBinding.java`

字段/常量（18）：
- `ImageView ivBurst110Selected`  L14
- `ImageView ivBurst115Selected`  L15
- `ImageView ivBurst120Selected`  L16
- `ImageView ivBurst125Selected`  L17
- `ImageView ivBurst12Selected`  L18
- `ImageView ivBurst130Selected`  L19
- `ImageView ivBurst13Selected`  L20
- `ImageView ivBurst15Selected`  L21
- `LinearLayout layoutRowBurst110`  L22
- `LinearLayout layoutRowBurst115`  L23
- `LinearLayout layoutRowBurst12`  L24
- `LinearLayout layoutRowBurst120`  L25
- `LinearLayout layoutRowBurst125`  L26
- `LinearLayout layoutRowBurst13`  L27
- `LinearLayout layoutRowBurst130`  L28
- `LinearLayout layoutRowBurst15`  L29
- `LinearLayout rootView`  L30
- `int i = R.id.ivBurst110Selected`  L70

方法（5）：
- `private MenuBurstBinding(LinearLayout rootView, ImageView ivBurst110Selected, ImageView ivBurst115Selected, ImageView ivBurst120Selected, ImageView ivBurst125Selected, ImageView ivBurst12Selected, ImageView ivBurst130Selected, ImageView ivBurst13Selected, ImageView ivBurst15Selected, LinearLayout layoutRowBurst110, LinearLayout layoutRowBurst115, LinearLayout layoutRowBurst12, LinearLayout layoutRowBurst120, LinearLayout layoutRowBurst125, LinearLayout layoutRowBurst13, LinearLayout layoutRowBurst130, LinearLayout layoutRowBurst15)`  L32
- `LinearLayout getRoot()`  L53 @Override
- `MenuBurstBinding inflate(LayoutInflater inflater)`  L57
- `MenuBurstBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L61
- `MenuBurstBinding bind(View rootView)`  L69
### `com.gku.xtugo.databinding.MenuFileBinding`
L12 · [class] public final MenuFileBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MenuFileBinding.java`

字段/常量（6）：
- `LinearLayout ibdelete`  L13
- `LinearLayout ibdownload`  L14
- `LinearLayout ibfileInfo`  L15
- `LinearLayout ibshare`  L16
- `LinearLayout rootView`  L17
- `int i = R.id.ibdelete`  L45

方法（5）：
- `private MenuFileBinding(LinearLayout rootView, LinearLayout ibdelete, LinearLayout ibdownload, LinearLayout ibfileInfo, LinearLayout ibshare)`  L19
- `LinearLayout getRoot()`  L28 @Override
- `MenuFileBinding inflate(LayoutInflater inflater)`  L32
- `MenuFileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `MenuFileBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.MenuModeBinding`
L13 · [class] public final MenuModeBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MenuModeBinding.java`

字段/常量（16）：
- `ImageView ivModeBurstSelected`  L14
- `ImageView ivModePhotoSelected`  L15
- `ImageView ivModeTimelapseSelected`  L16
- `ImageView ivModeTimerSelected`  L17
- `ImageView ivModeVideoLoopSelected`  L18
- `ImageView ivModeVideoSelected`  L19
- `ImageView ivModeVideoTimelapseSelected`  L20
- `LinearLayout layoutRowModeBurst`  L21
- `LinearLayout layoutRowModePhoto`  L22
- `LinearLayout layoutRowModeTimelapse`  L23
- `LinearLayout layoutRowModeTimer`  L24
- `LinearLayout layoutRowModeVideo`  L25
- `LinearLayout layoutRowModeVideoLoop`  L26
- `LinearLayout layoutRowModeVideoTimelapse`  L27
- `LinearLayout rootView`  L28
- `int i = R.id.ivModeBurstSelected`  L66

方法（5）：
- `private MenuModeBinding(LinearLayout rootView, ImageView ivModeBurstSelected, ImageView ivModePhotoSelected, ImageView ivModeTimelapseSelected, ImageView ivModeTimerSelected, ImageView ivModeVideoLoopSelected, ImageView ivModeVideoSelected, ImageView ivModeVideoTimelapseSelected, LinearLayout layoutRowModeBurst, LinearLayout layoutRowModePhoto, LinearLayout layoutRowModeTimelapse, LinearLayout layoutRowModeTimer, LinearLayout layoutRowModeVideo, LinearLayout layoutRowModeVideoLoop, LinearLayout layoutRowModeVideoTimelapse)`  L30
- `LinearLayout getRoot()`  L49 @Override
- `MenuModeBinding inflate(LayoutInflater inflater)`  L53
- `MenuModeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L57
- `MenuModeBinding bind(View rootView)`  L65
### `com.gku.xtugo.databinding.MenuTimeBinding`
L13 · [class] public final MenuTimeBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MenuTimeBinding.java`

字段/常量（18）：
- `ImageView ivTime10Selected`  L14
- `ImageView ivTime15Selected`  L15
- `ImageView ivTime1Selected`  L16
- `ImageView ivTime30Selected`  L17
- `ImageView ivTime3Selected`  L18
- `ImageView ivTime45Selected`  L19
- `ImageView ivTime5Selected`  L20
- `ImageView ivTime60Selected`  L21
- `LinearLayout layoutRowTime1`  L22
- `LinearLayout layoutRowTime10`  L23
- `LinearLayout layoutRowTime15`  L24
- `LinearLayout layoutRowTime3`  L25
- `LinearLayout layoutRowTime30`  L26
- `LinearLayout layoutRowTime45`  L27
- `LinearLayout layoutRowTime5`  L28
- `LinearLayout layoutRowTime60`  L29
- `LinearLayout rootView`  L30
- `int i = R.id.ivTime10Selected`  L70

方法（5）：
- `private MenuTimeBinding(LinearLayout rootView, ImageView ivTime10Selected, ImageView ivTime15Selected, ImageView ivTime1Selected, ImageView ivTime30Selected, ImageView ivTime3Selected, ImageView ivTime45Selected, ImageView ivTime5Selected, ImageView ivTime60Selected, LinearLayout layoutRowTime1, LinearLayout layoutRowTime10, LinearLayout layoutRowTime15, LinearLayout layoutRowTime3, LinearLayout layoutRowTime30, LinearLayout layoutRowTime45, LinearLayout layoutRowTime5, LinearLayout layoutRowTime60)`  L32
- `LinearLayout getRoot()`  L53 @Override
- `MenuTimeBinding inflate(LayoutInflater inflater)`  L57
- `MenuTimeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L61
- `MenuTimeBinding bind(View rootView)`  L69
### `com.gku.xtugo.databinding.MenuTimelapseBinding`
L13 · [class] public final MenuTimelapseBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MenuTimelapseBinding.java`

字段/常量（22）：
- `ImageView ivTimelapse0Selected`  L14
- `ImageView ivTimelapse10Selected`  L15
- `ImageView ivTimelapse15Selected`  L16
- `ImageView ivTimelapse1Selected`  L17
- `ImageView ivTimelapse2Selected`  L18
- `ImageView ivTimelapse30Selected`  L19
- `ImageView ivTimelapse3Selected`  L20
- `ImageView ivTimelapse45Selected`  L21
- `ImageView ivTimelapse5Selected`  L22
- `ImageView ivTimelapse60Selected`  L23
- `LinearLayout layoutRowTimelapse0`  L24
- `LinearLayout layoutRowTimelapse1`  L25
- `LinearLayout layoutRowTimelapse10`  L26
- `LinearLayout layoutRowTimelapse15`  L27
- `LinearLayout layoutRowTimelapse2`  L28
- `LinearLayout layoutRowTimelapse3`  L29
- `LinearLayout layoutRowTimelapse30`  L30
- `LinearLayout layoutRowTimelapse45`  L31
- `LinearLayout layoutRowTimelapse5`  L32
- `LinearLayout layoutRowTimelapse60`  L33
- `LinearLayout rootView`  L34
- `int i = R.id.ivTimelapse0Selected`  L78

方法（5）：
- `private MenuTimelapseBinding(LinearLayout rootView, ImageView ivTimelapse0Selected, ImageView ivTimelapse10Selected, ImageView ivTimelapse15Selected, ImageView ivTimelapse1Selected, ImageView ivTimelapse2Selected, ImageView ivTimelapse30Selected, ImageView ivTimelapse3Selected, ImageView ivTimelapse45Selected, ImageView ivTimelapse5Selected, ImageView ivTimelapse60Selected, LinearLayout layoutRowTimelapse0, LinearLayout layoutRowTimelapse1, LinearLayout layoutRowTimelapse10, LinearLayout layoutRowTimelapse15, LinearLayout layoutRowTimelapse2, LinearLayout layoutRowTimelapse3, LinearLayout layoutRowTimelapse30, LinearLayout layoutRowTimelapse45, LinearLayout layoutRowTimelapse5, LinearLayout layoutRowTimelapse60)`  L36
- `LinearLayout getRoot()`  L61 @Override
- `MenuTimelapseBinding inflate(LayoutInflater inflater)`  L65
- `MenuTimelapseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L69
- `MenuTimelapseBinding bind(View rootView)`  L77
### `com.gku.xtugo.databinding.MenuWorkModeBinding`
L16 · [class] public final MenuWorkModeBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MenuWorkModeBinding.java`

字段/常量（40）：
- `RecyclerView itemRecycler`  L17
- `ImageView ivCircleForMulti`  L18
- `ImageView ivCircleForPhoto`  L19
- `ImageView ivCircleForVideo`  L20
- `ImageView ivMarkMultiBurst`  L21
- `ImageView ivMarkMultiContinuous`  L22
- `ImageView ivMarkMultiTimelapse`  L23
- `ImageView ivMarkPhotoSingle`  L24
- `ImageView ivMarkPhotoTimer`  L25
- `ImageView ivMarkQuickVideo`  L26
- `ImageView ivMarkVideoLoop`  L27
- `ImageView ivMarkVideoNormal`  L28
- `ImageView ivMarkVideoSlow`  L29
- `ImageView ivMarkVideoTimelapse`  L30
- `RelativeLayout layout1`  L31
- `RelativeLayout layout2`  L32
- `RelativeLayout layout3`  L33
- `LinearLayout layoutOldLayout`  L34
- `LinearLayout modeGroupMulti`  L35
- `LinearLayout modeGroupPhoto`  L36
- `LinearLayout modeGroupVideo`  L37
- `RelativeLayout rootView`  L38
- `LinearLayout slaveModeMultiBurst`  L39
- `LinearLayout slaveModeMultiContinuous`  L40
- `LinearLayout slaveModeMultiTimelapse`  L41
- `LinearLayout slaveModePhotoSingle`  L42
- `LinearLayout slaveModePhotoTimer`  L43
- `LinearLayout slaveModeQuickVideo`  L44
- `LinearLayout slaveModeVideoLoop`  L45
- `LinearLayout slaveModeVideoNormal`  L46
- `LinearLayout slaveModeVideoSlow`  L47
- `LinearLayout slaveModeVideoTimelapse`  L48
- `LinearLayout titleCircleLayout`  L49
- `View titleLineMiddle`  L50
- `LinearLayout titleTop`  L51
- `TextView tvMasterModeMulti`  L52
- `TextView tvMasterModePhoto`  L53
- `TextView tvMasterModeVideo`  L54
- `View viewFindChildViewById`  L115
- `int i = R.id.item_recycler`  L116

方法（5）：
- `private MenuWorkModeBinding(RelativeLayout rootView, RecyclerView itemRecycler, ImageView ivCircleForMulti, ImageView ivCircleForPhoto, ImageView ivCircleForVideo, ImageView ivMarkMultiBurst, ImageView ivMarkMultiContinuous, ImageView ivMarkMultiTimelapse, ImageView ivMarkPhotoSingle, ImageView ivMarkPhotoTimer, ImageView ivMarkQuickVideo, ImageView ivMarkVideoLoop, ImageView ivMarkVideoNormal, ImageView ivMarkVideoSlow, ImageView ivMarkVideoTimelapse, RelativeLayout layout1, RelativeLayout layout2, RelativeLayout layout3, LinearLayout layoutOldLayout, LinearLayout modeGroupMulti, LinearLayout modeGroupPhoto, LinearLayout modeGroupVideo, LinearLayout slaveModeMultiBurst, LinearLayout slaveModeMultiContinuous, LinearLayout slaveModeMultiTimelapse, LinearLayout slaveModePhotoSingle, LinearLayout slaveModePhotoTimer, LinearLayout slaveModeQuickVideo, LinearLayout slaveModeVideoLoop, LinearLayout slaveModeVideoNormal, LinearLayout slaveModeVideoSlow, LinearLayout slaveModeVideoTimelapse, LinearLayout titleCircleLayout, View titleLineMiddle, LinearLayout titleTop, TextView tvMasterModeMulti, TextView tvMasterModePhoto, TextView tvMasterModeVideo)`  L56
- `RelativeLayout getRoot()`  L98 @Override
- `MenuWorkModeBinding inflate(LayoutInflater inflater)`  L102
- `MenuWorkModeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L106
- `MenuWorkModeBinding bind(View rootView)`  L114
### `com.gku.xtugo.databinding.MultiPbEditViewBinding`
L14 · [class] public final MultiPbEditViewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MultiPbEditViewBinding.java`

字段/常量（7）：
- `ImageButton actionDelete`  L15
- `ImageButton actionDownload`  L16
- `ImageButton actionSelect`  L17
- `LinearLayout editLayout`  L18
- `TextView infoSelectedNum`  L19
- `LinearLayout rootView`  L20
- `int i = R.id.action_delete`  L49

方法（5）：
- `private MultiPbEditViewBinding(LinearLayout rootView, ImageButton actionDelete, ImageButton actionDownload, ImageButton actionSelect, LinearLayout editLayout, TextView infoSelectedNum)`  L22
- `LinearLayout getRoot()`  L32 @Override
- `MultiPbEditViewBinding inflate(LayoutInflater inflater)`  L36
- `MultiPbEditViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `MultiPbEditViewBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.MyItemSwitchBinding`
L14 · [class] public final MyItemSwitchBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MyItemSwitchBinding.java`

字段/常量（6）：
- `ImageView ivIcon`  L15
- `ImageView ivSelect`  L16
- `LinearLayoutShape rootView`  L17
- `TextView tvComingSoon`  L18
- `TextView tvExample`  L19
- `int i = R.id.iv_icon`  L47

方法（5）：
- `private MyItemSwitchBinding(LinearLayoutShape rootView, ImageView ivIcon, ImageView ivSelect, TextView tvComingSoon, TextView tvExample)`  L21
- `LinearLayoutShape getRoot()`  L30 @Override
- `MyItemSwitchBinding inflate(LayoutInflater inflater)`  L34
- `MyItemSwitchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `MyItemSwitchBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.MyItemWifiSwitchBinding`
L14 · [class] public final MyItemWifiSwitchBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/MyItemWifiSwitchBinding.java`

字段/常量（5）：
- `ImageView ivWifiSignal`  L15
- `LinearLayoutShape rootView`  L16
- `TextView tvComingSoon`  L17
- `TextView tvExample`  L18
- `int i = R.id.ivWifiSignal`  L45

方法（5）：
- `private MyItemWifiSwitchBinding(LinearLayoutShape rootView, ImageView ivWifiSignal, TextView tvComingSoon, TextView tvExample)`  L20
- `LinearLayoutShape getRoot()`  L28 @Override
- `MyItemWifiSwitchBinding inflate(LayoutInflater inflater)`  L32
- `MyItemWifiSwitchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `MyItemWifiSwitchBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.PbPhotoItemBinding`
L15 · [class] public final PbPhotoItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/PbPhotoItemBinding.java`

字段/常量（5）：
- `PhotoView photo`  L16
- `SurfaceView photoSurfaceView`  L17
- `ProgressWheel progressWheel`  L18
- `RelativeLayout rootView`  L19
- `int i = R.id.photo`  L46

方法（5）：
- `private PbPhotoItemBinding(RelativeLayout rootView, PhotoView photo, SurfaceView photoSurfaceView, ProgressWheel progressWheel)`  L21
- `RelativeLayout getRoot()`  L29 @Override
- `PbPhotoItemBinding inflate(LayoutInflater inflater)`  L33
- `PbPhotoItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `PbPhotoItemBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.PlaybackPreviewItemBinding`
L13 · [class] public final PlaybackPreviewItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/PlaybackPreviewItemBinding.java`

字段/常量（3）：
- `PhotoView playbackBg`  L14
- `ConstraintLayout rootView`  L15
- `int i = R.id.playback_bg`  L40

方法（5）：
- `private PlaybackPreviewItemBinding(ConstraintLayout rootView, PhotoView playbackBg)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `PlaybackPreviewItemBinding inflate(LayoutInflater inflater)`  L27
- `PlaybackPreviewItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `PlaybackPreviewItemBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.PopupSelectViewBinding`
L16 · [class] public final PopupSelectViewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/PopupSelectViewBinding.java`

字段/常量（9）：
- `ImageView delete`  L17
- `ImageView favorites`  L18
- `BottomButtomItem ivDeleteLaYutupro`  L19
- `BottomButtomItem ivFavoriteYutupro`  L20
- `BottomButtomItem ivShareLaYutupro`  L21
- `RelativeLayout popupSelection`  L22
- `LinearLayout popupSelectionYutupro`  L23
- `ConstraintLayout rootView`  L24
- `int i = R.id.delete`  L55

方法（5）：
- `private PopupSelectViewBinding(ConstraintLayout rootView, ImageView delete, ImageView favorites, BottomButtomItem ivDeleteLaYutupro, BottomButtomItem ivFavoriteYutupro, BottomButtomItem ivShareLaYutupro, RelativeLayout popupSelection, LinearLayout popupSelectionYutupro)`  L26
- `ConstraintLayout getRoot()`  L38 @Override
- `PopupSelectViewBinding inflate(LayoutInflater inflater)`  L42
- `PopupSelectViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `PopupSelectViewBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.PreferenceBinding`
L13 · [class] public final PreferenceBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/PreferenceBinding.java`

字段/常量（5）：
- `LinearLayout rootView`  L14
- `TextView summary`  L15
- `TextView title`  L16
- `LinearLayout widgetFrame`  L17
- `int i = android.R.id.summary`  L44

方法（5）：
- `private PreferenceBinding(LinearLayout rootView, TextView summary, TextView title, LinearLayout widgetFrame)`  L19
- `LinearLayout getRoot()`  L27 @Override
- `PreferenceBinding inflate(LayoutInflater inflater)`  L31
- `PreferenceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L35
- `PreferenceBinding bind(View rootView)`  L43
### `com.gku.xtugo.databinding.PreferenceCategoryBinding`
L13 · [class] public final PreferenceCategoryBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/PreferenceCategoryBinding.java`

字段/常量（5）：
- `LinearLayout rootView`  L14
- `TextView summary`  L15
- `TextView title`  L16
- `LinearLayout widgetFrame`  L17
- `int i = android.R.id.summary`  L44

方法（5）：
- `private PreferenceCategoryBinding(LinearLayout rootView, TextView summary, TextView title, LinearLayout widgetFrame)`  L19
- `LinearLayout getRoot()`  L27 @Override
- `PreferenceCategoryBinding inflate(LayoutInflater inflater)`  L31
- `PreferenceCategoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L35
- `PreferenceCategoryBinding bind(View rootView)`  L43
### `com.gku.xtugo.databinding.PreferenceScreenBinding`
L13 · [class] public final PreferenceScreenBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/PreferenceScreenBinding.java`

字段/常量（4）：
- `LinearLayout rootView`  L14
- `TextView summary`  L15
- `TextView title`  L16
- `int i = android.R.id.summary`  L42

方法（5）：
- `private PreferenceScreenBinding(LinearLayout rootView, TextView summary, TextView title)`  L18
- `LinearLayout getRoot()`  L25 @Override
- `PreferenceScreenBinding inflate(LayoutInflater inflater)`  L29
- `PreferenceScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `PreferenceScreenBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.PullToRefreshBinding`
L15 · [class] public final PullToRefreshBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/PullToRefreshBinding.java`

字段/常量（5）：
- `ImageView arrow`  L16
- `ProgressBar progressBar`  L17
- `RelativeLayout rootView`  L18
- `TextView tvHeadViewMsg`  L19
- `int i = R.id.arrow`  L46

方法（5）：
- `private PullToRefreshBinding(RelativeLayout rootView, ImageView arrow, ProgressBar progressBar, TextView tvHeadViewMsg)`  L21
- `RelativeLayout getRoot()`  L29 @Override
- `PullToRefreshBinding inflate(LayoutInflater inflater)`  L33
- `PullToRefreshBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L37
- `PullToRefreshBinding bind(View rootView)`  L45
### `com.gku.xtugo.databinding.ScanAddItemBinding`
L16 · [class] public final ScanAddItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ScanAddItemBinding.java`

字段/常量（9）：
- `ProgressBar connectLoading`  L17
- `LinearLayoutRound itemCard`  L18
- `TextView itemDeviceName`  L19
- `TextView itemDevicePwd`  L20
- `TextView itemDeviceSsid`  L21
- `ImageView itemImageName`  L22
- `TextView itemPairedStatus`  L23
- `ConstraintLayout rootView`  L24
- `int i = R.id.connectLoading`  L55

方法（5）：
- `private ScanAddItemBinding(ConstraintLayout rootView, ProgressBar connectLoading, LinearLayoutRound itemCard, TextView itemDeviceName, TextView itemDevicePwd, TextView itemDeviceSsid, ImageView itemImageName, TextView itemPairedStatus)`  L26
- `ConstraintLayout getRoot()`  L38 @Override
- `ScanAddItemBinding inflate(LayoutInflater inflater)`  L42
- `ScanAddItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L46
- `ScanAddItemBinding bind(View rootView)`  L54
### `com.gku.xtugo.databinding.ServerFileItemBinding`
L14 · [class] public final ServerFileItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ServerFileItemBinding.java`

字段/常量（4）：
- `Button btnDownloadFile`  L15
- `LinearLayout rootView`  L16
- `TextView textFileName`  L17
- `int i = R.id.btnDownloadFile`  L43

方法（5）：
- `private ServerFileItemBinding(LinearLayout rootView, Button btnDownloadFile, TextView textFileName)`  L19
- `LinearLayout getRoot()`  L26 @Override
- `ServerFileItemBinding inflate(LayoutInflater inflater)`  L30
- `ServerFileItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ServerFileItemBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.SettingActionbarBinding`
L14 · [class] public final SettingActionbarBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/SettingActionbarBinding.java`

字段/常量（6）：
- `LinearLayout actionback`  L15
- `FrameLayout layout01`  L16
- `FrameLayout rootView`  L17
- `TextView f99tv`  L20
- `int i = R.id.actionback`  L47
- `int i2 = R.id.f98tv`  L51

方法（5）：
- `private SettingActionbarBinding(FrameLayout rootView, LinearLayout actionback, FrameLayout layout01, TextView tv2)`  L22
- `FrameLayout getRoot()`  L30 @Override
- `SettingActionbarBinding inflate(LayoutInflater inflater)`  L34
- `SettingActionbarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `SettingActionbarBinding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.SettingEnableWifiHotspotBinding`
L13 · [class] public final SettingEnableWifiHotspotBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/SettingEnableWifiHotspotBinding.java`

字段/常量（4）：
- `LinearLayout rootView`  L14
- `EditText wifiPassword`  L15
- `EditText wifiSsid`  L16
- `int i = R.id.wifi_password`  L42

方法（5）：
- `private SettingEnableWifiHotspotBinding(LinearLayout rootView, EditText wifiPassword, EditText wifiSsid)`  L18
- `LinearLayout getRoot()`  L25 @Override
- `SettingEnableWifiHotspotBinding inflate(LayoutInflater inflater)`  L29
- `SettingEnableWifiHotspotBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `SettingEnableWifiHotspotBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.SettingMenuBinding`
L13 · [class] public final SettingMenuBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/SettingMenuBinding.java`

字段/常量（4）：
- `RelativeLayout rootView`  L14
- `RelativeLayout setupMainMenu`  L15
- `ListView setupMenuListView`  L16
- `int i = R.id.setup_menu_listView`  L43

方法（5）：
- `private SettingMenuBinding(RelativeLayout rootView, RelativeLayout setupMainMenu, ListView setupMenuListView)`  L18
- `RelativeLayout getRoot()`  L25 @Override
- `SettingMenuBinding inflate(LayoutInflater inflater)`  L29
- `SettingMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `SettingMenuBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.SettingMenuItemBinding`
L13 · [class] public final SettingMenuItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/SettingMenuItemBinding.java`

字段/常量（4）：
- `TextView itemText`  L14
- `TextView itemValue`  L15
- `LinearLayout rootView`  L16
- `int i = R.id.item_text`  L42

方法（5）：
- `private SettingMenuItemBinding(LinearLayout rootView, TextView itemText, TextView itemValue)`  L18
- `LinearLayout getRoot()`  L25 @Override
- `SettingMenuItemBinding inflate(LayoutInflater inflater)`  L29
- `SettingMenuItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `SettingMenuItemBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.SettingSwitchLayoutBinding`
L14 · [class] public final SettingSwitchLayoutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/SettingSwitchLayoutBinding.java`

字段/常量（4）：
- `TextView itemName`  L15
- `RelativeLayout rootView`  L16
- `SwitchCompat switchCompat`  L17
- `int i = R.id.item_name`  L43

方法（5）：
- `private SettingSwitchLayoutBinding(RelativeLayout rootView, TextView itemName, SwitchCompat switchCompat)`  L19
- `RelativeLayout getRoot()`  L26 @Override
- `SettingSwitchLayoutBinding inflate(LayoutInflater inflater)`  L30
- `SettingSwitchLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `SettingSwitchLayoutBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.SingleDownloadContentDialogBinding`
L14 · [class] public final SingleDownloadContentDialogBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/SingleDownloadContentDialogBinding.java`

字段/常量（5）：
- `TextView downloadStatus`  L15
- `TextView fileName`  L16
- `NumberProgressBar numberbar`  L17
- `LinearLayout rootView`  L18
- `int i = R.id.downloadStatus`  L45

方法（5）：
- `private SingleDownloadContentDialogBinding(LinearLayout rootView, TextView downloadStatus, TextView fileName, NumberProgressBar numberbar)`  L20
- `LinearLayout getRoot()`  L28 @Override
- `SingleDownloadContentDialogBinding inflate(LayoutInflater inflater)`  L32
- `SingleDownloadContentDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `SingleDownloadContentDialogBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.UpdateDialogLayoutBinding`
L16 · [class] public final UpdateDialogLayoutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/UpdateDialogLayoutBinding.java`

字段/常量（8）：
- `LinearLayout buttonLayout`  L17
- `Button cancel`  L18
- `CheckBox dialogCheck`  L19
- `TextView dialogMessage`  L20
- `TextView dialogTitle`  L21
- `Button ok`  L22
- `RelativeLayout rootView`  L23
- `int i = R.id.button_layout`  L53

方法（5）：
- `private UpdateDialogLayoutBinding(RelativeLayout rootView, LinearLayout buttonLayout, Button cancel, CheckBox dialogCheck, TextView dialogMessage, TextView dialogTitle, Button ok)`  L25
- `RelativeLayout getRoot()`  L36 @Override
- `UpdateDialogLayoutBinding inflate(LayoutInflater inflater)`  L40
- `UpdateDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L44
- `UpdateDialogLayoutBinding bind(View rootView)`  L52
### `com.gku.xtugo.databinding.UpdateFirmSendBinding`
L15 · [class] public final UpdateFirmSendBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/UpdateFirmSendBinding.java`

字段/常量（8）：
- `View centerPoint`  L16
- `LayoutTitleBarBinding layoutTitle`  L17
- `RelativeLayout rootView`  L18
- `ImageView sendingImage`  L19
- `TextView sendingText`  L20
- `Button updateFinish`  L21
- `View viewFindChildViewById`  L50
- `int i = R.id.center_point`  L51

方法（5）：
- `private UpdateFirmSendBinding(RelativeLayout rootView, View centerPoint, LayoutTitleBarBinding layoutTitle, ImageView sendingImage, TextView sendingText, Button updateFinish)`  L23
- `RelativeLayout getRoot()`  L33 @Override
- `UpdateFirmSendBinding inflate(LayoutInflater inflater)`  L37
- `UpdateFirmSendBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `UpdateFirmSendBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.UpdateVersionReadyActivityBinding`
L14 · [class] public final UpdateVersionReadyActivityBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/UpdateVersionReadyActivityBinding.java`

字段/常量（8）：
- `View centerPoint`  L15
- `LayoutTitleBarBinding layoutTitle`  L16
- `RelativeLayout rootView`  L17
- `Button sendFirm`  L18
- `Button sendFirmCancel`  L19
- `TextView updateFirmVersionText`  L20
- `View viewFindChildViewById`  L49
- `int i = R.id.center_point`  L50

方法（5）：
- `private UpdateVersionReadyActivityBinding(RelativeLayout rootView, View centerPoint, LayoutTitleBarBinding layoutTitle, Button sendFirm, Button sendFirmCancel, TextView updateFirmVersionText)`  L22
- `RelativeLayout getRoot()`  L32 @Override
- `UpdateVersionReadyActivityBinding inflate(LayoutInflater inflater)`  L36
- `UpdateVersionReadyActivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `UpdateVersionReadyActivityBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.UserGuideItemBinding`
L13 · [class] public final UserGuideItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/UserGuideItemBinding.java`

字段/常量（3）：
- `PhotoView pvBg`  L14
- `ConstraintLayout rootView`  L15
- `int i = R.id.pv_bg`  L40

方法（5）：
- `private UserGuideItemBinding(ConstraintLayout rootView, PhotoView pvBg)`  L17
- `ConstraintLayout getRoot()`  L23 @Override
- `UserGuideItemBinding inflate(LayoutInflater inflater)`  L27
- `UserGuideItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `UserGuideItemBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.VideoThumbItemLayoutBinding`
L13 · [class] public final VideoThumbItemLayoutBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/VideoThumbItemLayoutBinding.java`

字段/常量（3）：
- `LinearLayout rootView`  L14
- `ImageView thumb`  L15
- `int i = R.id.thumb`  L40

方法（5）：
- `private VideoThumbItemLayoutBinding(LinearLayout rootView, ImageView thumb)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `VideoThumbItemLayoutBinding inflate(LayoutInflater inflater)`  L27
- `VideoThumbItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `VideoThumbItemLayoutBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.ViewAlbumPreviewItemBinding`
L14 · [class] public final ViewAlbumPreviewItemBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ViewAlbumPreviewItemBinding.java`

字段/常量（4）：
- `PhotoView ivBg`  L15
- `ImageView ivPlay`  L16
- `FrameLayout rootView`  L17
- `int i = R.id.iv_bg`  L43

方法（5）：
- `private ViewAlbumPreviewItemBinding(FrameLayout rootView, PhotoView ivBg, ImageView ivPlay)`  L19
- `FrameLayout getRoot()`  L26 @Override
- `ViewAlbumPreviewItemBinding inflate(LayoutInflater inflater)`  L30
- `ViewAlbumPreviewItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ViewAlbumPreviewItemBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.ViewIconTextBinding`
L14 · [class] public final ViewIconTextBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ViewIconTextBinding.java`

字段/常量（4）：
- `ImageView ivIcon`  L15
- `LinearLayoutRound rootView`  L16
- `TextView tvText`  L17
- `int i = R.id.ivIcon`  L43

方法（5）：
- `private ViewIconTextBinding(LinearLayoutRound rootView, ImageView ivIcon, TextView tvText)`  L19
- `LinearLayoutRound getRoot()`  L26 @Override
- `ViewIconTextBinding inflate(LayoutInflater inflater)`  L30
- `ViewIconTextBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L34
- `ViewIconTextBinding bind(View rootView)`  L42
### `com.gku.xtugo.databinding.ViewImage1Binding`
L14 · [class] public final ViewImage1Binding · implements `ViewBinding` · `com/gku/xtugo/databinding/ViewImage1Binding.java`

字段/常量（6）：
- `TextView header`  L15
- `ImageView ivBg`  L16
- `ImageView ivPlay`  L17
- `RelativeLayout rootView`  L18
- `ImageView selectIv`  L19
- `int i = R.id.header`  L47

方法（5）：
- `private ViewImage1Binding(RelativeLayout rootView, TextView header, ImageView ivBg, ImageView ivPlay, ImageView selectIv)`  L21
- `RelativeLayout getRoot()`  L30 @Override
- `ViewImage1Binding inflate(LayoutInflater inflater)`  L34
- `ViewImage1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L38
- `ViewImage1Binding bind(View rootView)`  L46
### `com.gku.xtugo.databinding.ViewImageBinding`
L14 · [class] public final ViewImageBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ViewImageBinding.java`

字段/常量（7）：
- `ImageView ivBg`  L15
- `ImageView ivFavorite`  L16
- `ImageView ivPlay`  L17
- `FrameLayout rootView`  L18
- `ImageView selectIv`  L19
- `TextView tvTime`  L20
- `int i = R.id.iv_bg`  L49

方法（5）：
- `private ViewImageBinding(FrameLayout rootView, ImageView ivBg, ImageView ivFavorite, ImageView ivPlay, ImageView selectIv, TextView tvTime)`  L22
- `FrameLayout getRoot()`  L32 @Override
- `ViewImageBinding inflate(LayoutInflater inflater)`  L36
- `ViewImageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L40
- `ViewImageBinding bind(View rootView)`  L48
### `com.gku.xtugo.databinding.ViewItemHeaderBinding`
L13 · [class] public final ViewItemHeaderBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ViewItemHeaderBinding.java`

字段/常量（3）：
- `TextView header`  L14
- `LinearLayout rootView`  L15
- `int i = R.id.header`  L40

方法（5）：
- `private ViewItemHeaderBinding(LinearLayout rootView, TextView header)`  L17
- `LinearLayout getRoot()`  L23 @Override
- `ViewItemHeaderBinding inflate(LayoutInflater inflater)`  L27
- `ViewItemHeaderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L31
- `ViewItemHeaderBinding bind(View rootView)`  L39
### `com.gku.xtugo.databinding.ViewNewitemHeaderBinding`
L13 · [class] public final ViewNewitemHeaderBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ViewNewitemHeaderBinding.java`

字段/常量（4）：
- `TextView batchSelect`  L14
- `TextView headerNew`  L15
- `LinearLayout rootView`  L16
- `int i = R.id.batch_select`  L42

方法（5）：
- `private ViewNewitemHeaderBinding(LinearLayout rootView, TextView batchSelect, TextView headerNew)`  L18
- `LinearLayout getRoot()`  L25 @Override
- `ViewNewitemHeaderBinding inflate(LayoutInflater inflater)`  L29
- `ViewNewitemHeaderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L33
- `ViewNewitemHeaderBinding bind(View rootView)`  L41
### `com.gku.xtugo.databinding.WelcomeBinding`
L14 · [class] public final WelcomeBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/WelcomeBinding.java`

字段/常量（7）：
- `ImageView backgroundImg`  L15
- `LayoutPrivacyWebViewBinding privacyWebView`  L16
- `RelativeLayout rootView`  L17
- `TextView tvVersion`  L18
- `View viewFindChildViewById`  L45
- `int i = R.id.background_img`  L46
- `int i2 = R.id.tv_version`  L50

方法（5）：
- `private WelcomeBinding(RelativeLayout rootView, ImageView backgroundImg, LayoutPrivacyWebViewBinding privacyWebView, TextView tvVersion)`  L20
- `RelativeLayout getRoot()`  L28 @Override
- `WelcomeBinding inflate(LayoutInflater inflater)`  L32
- `WelcomeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `WelcomeBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.WifiDeviceListBinding`
L15 · [class] public final WifiDeviceListBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/WifiDeviceListBinding.java`

字段/常量（7）：
- `LinearLayout deviceColumn`  L16
- `ImageView ibScanWifi`  L17
- `ImageView ibback`  L18
- `RelativeLayout ibtopTitle`  L19
- `LinearLayout rootView`  L20
- `HiWifiScrollView wifiScrollView`  L21
- `int i = R.id.device_column`  L50

方法（5）：
- `private WifiDeviceListBinding(LinearLayout rootView, LinearLayout deviceColumn, ImageView ibScanWifi, ImageView ibback, RelativeLayout ibtopTitle, HiWifiScrollView wifiScrollView)`  L23
- `LinearLayout getRoot()`  L33 @Override
- `WifiDeviceListBinding inflate(LayoutInflater inflater)`  L37
- `WifiDeviceListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L41
- `WifiDeviceListBinding bind(View rootView)`  L49
### `com.gku.xtugo.databinding.WifiPasswdLinkBinding`
L15 · [class] public final WifiPasswdLinkBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/WifiPasswdLinkBinding.java`

字段/常量（6）：
- `EditText etPasswd`  L16
- `Button ibConnect`  L17
- `Button ibUndo`  L18
- `LinearLayout rootView`  L19
- `TextView tvDialogTitle`  L20
- `int i = R.id.etPasswd`  L48

方法（5）：
- `private WifiPasswdLinkBinding(LinearLayout rootView, EditText etPasswd, Button ibConnect, Button ibUndo, TextView tvDialogTitle)`  L22
- `LinearLayout getRoot()`  L31 @Override
- `WifiPasswdLinkBinding inflate(LayoutInflater inflater)`  L35
- `WifiPasswdLinkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `WifiPasswdLinkBinding bind(View rootView)`  L47
### `com.gku.xtugo.databinding.WifiVerifyDeviceBinding`
L14 · [class] public final WifiVerifyDeviceBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/WifiVerifyDeviceBinding.java`

字段/常量（5）：
- `Button ibUndo`  L15
- `Button ibverify`  L16
- `LinearLayout rootView`  L17
- `TextView tvDialogTitle`  L18
- `int i = R.id.ibUndo`  L45

方法（5）：
- `private WifiVerifyDeviceBinding(LinearLayout rootView, Button ibUndo, Button ibverify, TextView tvDialogTitle)`  L20
- `LinearLayout getRoot()`  L28 @Override
- `WifiVerifyDeviceBinding inflate(LayoutInflater inflater)`  L32
- `WifiVerifyDeviceBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L36
- `WifiVerifyDeviceBinding bind(View rootView)`  L44
### `com.gku.xtugo.databinding.ZoombarViewBinding`
L15 · [class] public final ZoombarViewBinding · implements `ViewBinding` · `com/gku/xtugo/databinding/ZoombarViewBinding.java`

字段/常量（6）：
- `RelativeLayout rootView`  L16
- `SeekBar zoomBar`  L17
- `ImageButton zoomIn`  L18
- `ImageButton zoomOut`  L19
- `TextView zoomRate`  L20
- `int i = R.id.zoomBar`  L48

方法（5）：
- `private ZoombarViewBinding(RelativeLayout rootView, SeekBar zoomBar, ImageButton zoomIn, ImageButton zoomOut, TextView zoomRate)`  L22
- `RelativeLayout getRoot()`  L31 @Override
- `ZoombarViewBinding inflate(LayoutInflater inflater)`  L35
- `ZoombarViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent)`  L39
- `ZoombarViewBinding bind(View rootView)`  L47