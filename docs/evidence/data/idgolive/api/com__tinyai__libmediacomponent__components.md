# idGoLive — 类与成员明细：com.tinyai.libmediacomponent.components

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 45 个文件 / 85 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tinyai.libmediacomponent.components.BorderImageView`
L12 · [class] public BorderImageView · extends `ImageView` · `com/tinyai/libmediacomponent/components/BorderImageView.java`

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
### `com.tinyai.libmediacomponent.components.cameralist.DeviceItem`
L6 · [class] public DeviceItem · `com/tinyai/libmediacomponent/components/cameralist/DeviceItem.java`

字段/常量（12）：
- `Date addTime`  L7
- `byte[] coverData`  L8
- `Date coverTime`  L9
- `String coverUrl`  L10
- `int deviceType = 0`  L11
- `String id`  L12
- `String ip`  L13
- `boolean isAdmin`  L14
- `String name`  L15
- `boolean newMessage`  L16
- `boolean newSetting`  L17
- `boolean online`  L18

方法（26）：
- `public DeviceItem(String str, Date date, byte[] bArr, String str2, Date date2, String str3, boolean z, String str4)`  L20
- `public DeviceItem(String str, boolean z, Date date, byte[] bArr, String str2, Date date2, String str3, boolean z2, boolean z3, boolean z4)`  L31
- `Date getAddTime()`  L44
- `byte[] getCoverData()`  L48
- `Date getCoverTime()`  L52
- `String getCoverUrl()`  L56
- `int getDeviceType()`  L60
- `String getId()`  L64
- `String getIp()`  L68
- `String getName()`  L72
- `boolean isAdmin()`  L76
- `boolean isNewMessage()`  L80
- `boolean isNewSetting()`  L84
- `boolean isOnline()`  L88
- `void setAddTime(Date date)`  L92
- `void setAdmin(boolean z)`  L96
- `void setCoverData(byte[] bArr)`  L100
- `void setCoverTime(Date date)`  L104
- `void setCoverUrl(String str)`  L108
- `void setDeviceType(int i)`  L112
- `void setId(String str)`  L116
- `void setIp(String str)`  L120
- `void setName(String str)`  L124
- `void setNewMessage(boolean z)`  L128
- `void setNewSetting(boolean z)`  L132
- `void setOnline(boolean z)`  L136
### `com.tinyai.libmediacomponent.components.cameralist.DeviceItemProperty`
L4 · [class] public DeviceItemProperty · `com/tinyai/libmediacomponent/components/cameralist/DeviceItemProperty.java`

字段/常量（15）：
- `int device_online_icon = -1`  L5
- `int device_offline_icon = -1`  L6
- `int message_icon = -1`  L7
- `int file_icon = -1`  L8
- `int share_icon = -1`  L9
- `int delete_icon = -1`  L10
- `int setting_icon = -1`  L11
- `int control_icon_size = -1`  L12
- `int title_size = -1`  L13
- `int title_color = -1`  L14
- `int circular_color = -1`  L15
- `int play_icon = -1`  L16
- `int preview_time_size = -1`  L17
- `int preview_time_color = -1`  L18
- `int defaule_preview_icon = -1`  L19

方法（30）：
- `int getCircular_color()`  L21
- `int getControl_icon_size()`  L25
- `int getDefaule_preview_icon()`  L29
- `int getDelete_icon()`  L33
- `int getDevice_offline_icon()`  L37
- `int getDevice_online_icon()`  L41
- `int getFile_icon()`  L45
- `int getMessage_icon()`  L49
- `int getPlay_icon()`  L53
- `int getPreview_time_color()`  L57
- `int getPreview_time_size()`  L61
- `int getSetting_icon()`  L65
- `int getShare_icon()`  L69
- `int getTitle_color()`  L73
- `int getTitle_size()`  L77
- `void setCircular_color(int i)`  L81
- `void setControl_icon_size(int i)`  L85
- `void setDefaule_preview_icon(int i)`  L89
- `void setDelete_icon(int i)`  L93
- `void setDevice_offline_icon(int i)`  L97
- `void setDevice_online_icon(int i)`  L101
- `void setFile_icon(int i)`  L105
- `void setMessage_icon(int i)`  L109
- `void setPlay_icon(int i)`  L113
- `void setPreview_time_color(int i)`  L117
- `void setPreview_time_size(int i)`  L121
- `void setSetting_icon(int i)`  L125
- `void setShare_icon(int i)`  L129
- `void setTitle_color(int i)`  L133
- `void setTitle_size(int i)`  L137
### `com.tinyai.libmediacomponent.components.cameralist.DeviceListAdapter`
L25 · [class] public DeviceListAdapter · extends `BaseAdapter` · `com/tinyai/libmediacomponent/components/cameralist/DeviceListAdapter.java`

字段/常量（18）：
- `AttributeSet attrs`  L26
- `Context context`  L27
- `DeviceItemProperty deviceItemProperty`  L28
- `ItemContentClickListener itemContentClickListener`  L29
- `List<DeviceItem> list`  L30
- `String TAG = "DeviceListAdapter"`  L31
- `int maxCoverSize = 60`  L32
- `int deviceOnlineIcon = R.drawable.meida_online`  L33
- `int deviceOfflineIcon = R.drawable.meida_offline`  L34
- `List<DeviceItem> list = this.list`  L44
- `List<DeviceItem> list = this.list`  L52
- `TextView textView`  L76
- `RelativeLayout relativeLayout`  L77
- `RelativeLayout relativeLayout2`  L78
- `View view2 = viewInflate`  L106
- `DeviceItemProperty deviceItemProperty = this.deviceItemProperty`  L107
- `TextView textView4 = textView`  L273
- `List<DeviceItem> list = this.list`  L298

方法（19）：
- `public DeviceListAdapter(Context context, List<DeviceItem> list, DeviceItemProperty deviceItemProperty)`  L37
- `void add(DeviceItem deviceItem)`  L43
- `void delete(int i, DeviceItem deviceItem)`  L51
- `int getCount()`  L60 @Override
- `Object getItem(int i)`  L65 @Override
- `long getItemId(int i)`  L70 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L75 @Override
- `void onLoadingComplete(String str, View view3, Bitmap bitmap)`  L153 @Override
- `void onLoadingFailed(String str, View view3)`  L157 @Override
- `void onLoadingStarted(String str, View view3)`  L162 @Override
- `void onClick(View view3)`  L169 @Override
    - 体内字面量："isFastDoubleClick the v.id="
- `void onClick(View view3)`  L179 @Override
    - 体内字面量："isFastDoubleClick the v.id="
- `void onClick(View view3)`  L189 @Override
    - 体内字面量："isFastDoubleClick the v.id="
- `void onClick(View view3)`  L199 @Override
    - 体内字面量："isFastDoubleClick the v.id="
- `void onClick(View view3)`  L209 @Override
    - 体内字面量："isFastDoubleClick the v.id="
- `void onClick(View view3)`  L220 @Override
    - 体内字面量："isFastDoubleClick the v.id="
- `void onClick(View view3)`  L231 @Override
    - 体内字面量："isDeviceOnline: true" · "isDeviceOnline: false"
- `void setItemContentClickListener(ItemContentClickListener itemContentClickListener)`  L293
- `void update(int i, DeviceItem deviceItem)`  L297
### `com.tinyai.libmediacomponent.components.cameralist.DeviceListView`
L15 · [class] public DeviceListView · extends `LinearLayout implements PullToRefreshBase.OnRefreshListener2` · implements `PullToRefreshBase.OnRefreshListener2` · `com/tinyai/libmediacomponent/components/cameralist/DeviceListView.java`

字段/常量（31）：
- `String TAG = "FileListView"`  L16
- `DeviceListAdapter adapter`  L17
- `AttributeSet attrs`  L18
- `Context context`  L19
- `List<DeviceItem> deviceFileList`  L20
- `PullToRefreshListView deviceFileListView`  L21
- `DeviceItemProperty deviceItemProperty`  L22
- `ItemContentClickListener itemContentClickListener`  L23
- `RefreshCallback refreshListener`  L24
- `int refresh_mode`  L25
- `List<DeviceItem> list = this.deviceFileList`  L61
- `DeviceListAdapter deviceListAdapter = this.adapter`  L64
- `int itemIndexById`  L72
- `DeviceListAdapter deviceListAdapter = this.adapter`  L77
- `PullToRefreshListView pullToRefreshListView = this.deviceFileListView`  L84
- `PullToRefreshListView pullToRefreshListView = this.deviceFileListView`  L144
- `DeviceListAdapter deviceListAdapter = this.adapter`  L153
- `ItemContentClickListener itemContentClickListener = this.itemContentClickListener`  L160
- `DeviceListAdapter deviceListAdapter = this.adapter`  L169
- `DeviceItem itemById`  L180
- `DeviceListAdapter deviceListAdapter = this.adapter`  L185
- `DeviceItem itemById`  L192
- `DeviceListAdapter deviceListAdapter = this.adapter`  L197
- `DeviceItem itemById`  L204
- `DeviceListAdapter deviceListAdapter = this.adapter`  L209
- `DeviceItem itemById`  L216
- `DeviceListAdapter deviceListAdapter = this.adapter`  L221
- `DeviceItem itemById`  L228
- `DeviceListAdapter deviceListAdapter = this.adapter`  L233
- `DeviceItem itemById`  L240
- `DeviceListAdapter deviceListAdapter = this.adapter`  L245

方法（23）：
- `public DeviceListView(Context context)`  L31
- `public DeviceListView(Context context, AttributeSet attributeSet)`  L35
- `public DeviceListView(Context context, AttributeSet attributeSet, int i)`  L39
- `void initView(Context context, AttributeSet attributeSet)`  L48
- `void add(DeviceItem deviceItem)`  L60
- `void delete(String str)`  L71
- `void enableRefresh(boolean z)`  L83
- `DeviceItem getItemById(String str)`  L94
- `int getItemIndexById(String str)`  L107
- `void onPullDownToRefresh(PullToRefreshBase pullToRefreshBase)`  L121 @Override
- `void run()`  L125 @Override
- `void run()`  L129 @Override
- `void onPullUpToRefresh(PullToRefreshBase pullToRefreshBase)`  L140 @Override
- `void refreshComplete()`  L143
- `void renderList(List<DeviceItem> list)`  L150
- `void setItemContentClickListener(ItemContentClickListener itemContentClickListener)`  L167
- `void setRefreshListener(RefreshCallback refreshCallback)`  L175
- `void updateCover(String str, String str2)`  L179
- `void updateCover(String str, byte[] bArr)`  L191
- `void updateMessageState(String str, boolean z)`  L203
- `void updateName(String str, String str2)`  L215
- `void updateOnlineState(String str, boolean z)`  L227
- `void updateSettingState(String str, boolean z)`  L239
### `com.tinyai.libmediacomponent.components.cameralist.DeviceListView$RefreshCallback`
L27 · [interface] public RefreshCallback · `com/tinyai/libmediacomponent/components/cameralist/DeviceListView.java`

方法（1）：
- `List<DeviceItem> refreshData()`  L28
### `com.tinyai.libmediacomponent.components.cameralist.DeviceType`
L4 · [class] public DeviceType · `com/tinyai/libmediacomponent/components/cameralist/DeviceType.java`

字段/常量（2）：
- `int TYPE_LOCAL = 0`  L5
- `int TYPE_REMOTE = 1`  L6
### `com.tinyai.libmediacomponent.components.cameralist.ItemContentClickListener`
L4 · [interface] public ItemContentClickListener · `com/tinyai/libmediacomponent/components/cameralist/ItemContentClickListener.java`

方法（7）：
- `void onDeleteClick(DeviceItem deviceItem)`  L5
- `void onMediaClick(DeviceItem deviceItem)`  L7
- `void onMessageClick(DeviceItem deviceItem)`  L9
- `void onPreviewClick(DeviceItem deviceItem)`  L11
- `void onSettingClick(DeviceItem deviceItem)`  L13
- `void onShareClick(DeviceItem deviceItem)`  L15
- `void onWifiSetingClick(DeviceItem deviceItem)`  L17
### `com.tinyai.libmediacomponent.components.filelist.EndlessRecyclerOnScrollListener`
L7 · [class] public abstract EndlessRecyclerOnScrollListener · extends `RecyclerView.OnScrollListener` · `com/tinyai/libmediacomponent/components/filelist/EndlessRecyclerOnScrollListener.java`

字段/常量（1）：
- `boolean isSlidingUpward = false`  L8

方法（3）：
- `void onLoadMore()`  L10
- `void onScrollStateChanged(RecyclerView recyclerView, int i)`  L13 @Override
- `void onScrolled(RecyclerView recyclerView, int i, int i2)`  L22 @Override
### `com.tinyai.libmediacomponent.components.filelist.FileItemInfo`
L4 · [class] public FileItemInfo · `com/tinyai/libmediacomponent/components/filelist/FileItemInfo.java`

字段/常量（15）：
- `int fileDuration`  L5
- `int fileHandle`  L6
- `int fileHeight`  L7
- `String fileName`  L8
- `String filePath`  L9
- `int fileProtection`  L10
- `long fileSize`  L11
- `int fileType`  L12
- `int fileWidth`  L13
- `double frameRate`  L14
- `boolean itemChecked`  L15
- `boolean panorama`  L16
- `String thumbPath`  L17
- `long time`  L18
- `int triggerType`  L19

方法（35）：
- `public FileItemInfo(int i, int i2, String str, String str2, long j, long j2, double d, int i3, int i4, int i5, int i6, String str3)`  L21
- `public FileItemInfo(int i, int i2, String str, String str2, long j, long j2, String str3)`  L29
- `public FileItemInfo(int i, int i2, String str, String str2, long j, String str3)`  L37
- `public FileItemInfo(long j, long j2, int i, int i2, int i3, String str, String str2)`  L45
- `void init(int i, int i2, String str, String str2, long j, long j2, double d, int i3, int i4, int i5, int i6, String str3)`  L57
- `int getFileDuration()`  L72
- `int getFileHandle()`  L76
- `int getFileHeight()`  L80
- `String getFileName()`  L84
- `String getFilePath()`  L88
- `int getFileProtection()`  L92
- `long getFileSize()`  L96
- `int getFileType()`  L100
- `int getFileWidth()`  L104
- `double getFrameRate()`  L108
- `String getThumbPath()`  L112
- `long getTime()`  L116
- `int getTriggerType()`  L120
- `boolean isItemChecked()`  L124
- `boolean isPanorama()`  L128
- `void setFileDuration(int i)`  L132
- `void setFileHandle(int i)`  L136
- `void setFileHeight(int i)`  L140
- `void setFileName(String str)`  L144
- `void setFilePath(String str)`  L148
- `void setFileProtection(int i)`  L152
- `void setFileSize(long j)`  L156
- `void setFileType(int i)`  L160
- `void setFileWidth(int i)`  L164
- `void setFrameRate(double d)`  L168
- `void setItemChecked(boolean z)`  L172
- `void setPanorama(boolean z)`  L176
- `void setThumbPath(String str)`  L180
- `void setTime(long j)`  L184
- `void setTriggerType(int i)`  L188
### `com.tinyai.libmediacomponent.components.filelist.FileListRecyclerViewAdapter`
L31 · [class] public FileListRecyclerViewAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/tinyai/libmediacomponent/components/filelist/FileListRecyclerViewAdapter.java`

字段/常量（45）：
- `String TAG = "FileListRecyclerViewAdapter"`  L32
- `int TYPE_GRID = 1`  L33
- `int TYPE_LIST = 2`  L34
- `int TYPE_QUICK_LIST = 3`  L35
- `int checkedImgResId`  L36
- `Context context`  L37
- `int deleteImgResId`  L38
- `int downloadImgResId`  L39
- `boolean enableChecked`  L40
- `boolean enableDelete`  L41
- `boolean enableDownload`  L42
- `int image_radius`  L43
- `int itemLayoutRes`  L44
- `int item_background`  L45
- `int item_height`  L46
- `List<FileItemInfo> list`  L47
- `LayoutInflater mInflater`  L48
- `MultipleSelectionListener multipleSelectionListener`  L49
- `OperationMode operationMode`  L50
- `int triggerTypeImgPirResId`  L51
- `int triggerTypeImgRingResId`  L52
- `int uncheckedImgResId`  L53
- `int width`  L54
- `int TYPE_FOOTER = 4`  L55
- `int LOADING = 1`  L56
- `int LOADING_COMPLETE = 2`  L57
- `int LOADING_END = 3`  L58
- `int curViewType = 1`  L59
- `int loadState = 2`  L60
- `long selectTitleIndex = 0`  L61
- `FileItemInfo selectItem = null`  L62
- `MediaListItemClickListener mediaListItemClickListener = null`  L63
- `int gridColumn = 3`  L64
- `boolean enableLoadMore = true`  L65
- `String deviceId`  L66
- `int i2`  L257
- `int fileDuration`  L258
- `FileItemInfo fileItemInfo`  L259
- `int i3 = R.drawable.meida_camera_roll_btn_video_loading`  L278
- `int i4 = R.drawable.meida_camera_roll_btn_photo_loading`  L280
- `int i5 = R.drawable.meida_camera_roll_btn_video_loading`  L282
- `int i6 = this.loadState`  L297
- `int i7 = R.drawable.meida_camera_roll_btn_video_loading`  L337
- `int i8 = fileDuration / 1000`  L397
- `MultipleSelectionListener multipleSelectionListener = this.multipleSelectionListener`  L455

方法（30）：
- `public FileListRecyclerViewAdapter(Context context, List<FileItemInfo> list, AttributeSet attributeSet, OperationMode operationMode)`  L138
    - 体内字面量："enableChecked:" · " enableDownload=" · " enableDelete="
- `boolean isPanorama(long j, long j2)`  L172
- `int getItemCount()`  L177 @Override
- `long getItemId(int i)`  L182 @Override
- `int getItemViewType(int i)`  L187 @Override
- `int getLoadState()`  L194
- `OperationMode getOperationMode()`  L198
- `List<FileItemInfo> getSelectedItem()`  L202
- `void initLoadState(int i)`  L212
- `boolean isEnableLoadMore()`  L216
- `boolean isItemChecked(int i)`  L220
- `boolean isSelectedAll()`  L227
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L237 @Override
- `int getSpanSize(int i)`  L245 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i)`  L256 @Override
- `void onClick(View view)`  L404 @Override
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L415 @Override
- `void setCurViewType(int i)`  L428
- `void setEnableChecked(boolean z)`  L432
- `void setEnableDelete(boolean z)`  L437
- `void setEnableDownload(boolean z)`  L442
- `void setEnableLoadMore(boolean z)`  L447
- `void setItemChecked(int i, boolean z)`  L451
- `void setLoadState(int i)`  L461
- `void setMediaListItemClickListener(MediaListItemClickListener mediaListItemClickListener)`  L466
- `void setMultipleSelectionListener(MultipleSelectionListener multipleSelectionListener)`  L470
- `void setOperationMode(OperationMode operationMode)`  L474
- `void setSelectAll(boolean z)`  L481
- `void setSelectItem(int i, FileItemInfo fileItemInfo)`  L488
- `void setSelectTitleIndex(long j)`  L493
### `com.tinyai.libmediacomponent.components.filelist.FileListRecyclerViewAdapter$FootViewHolder`
L69 · [class] private FootViewHolder · extends `RecyclerView.ViewHolder` · `com/tinyai/libmediacomponent/components/filelist/FileListRecyclerViewAdapter.java`

字段/常量（3）：
- `LinearLayout llEnd`  L70
- `ProgressBar pbLoading`  L71
- `TextView tvLoading`  L72
### `com.tinyai.libmediacomponent.components.filelist.FileListRecyclerViewAdapter$RecyclerViewGridHolder`
L82 · [class] private RecyclerViewGridHolder · extends `RecyclerView.ViewHolder` · `com/tinyai/libmediacomponent/components/filelist/FileListRecyclerViewAdapter.java`

字段/常量（4）：
- `ImageView editCheckBox`  L83
- `ImageView mImageView`  L84
- `ImageView mIsPanoramaSign`  L85
- `ImageView videoTypeFlag`  L86
### `com.tinyai.libmediacomponent.components.filelist.FileListRecyclerViewAdapter$RecyclerViewListHolder`
L97 · [class] private RecyclerViewListHolder · extends `RecyclerView.ViewHolder` · `com/tinyai/libmediacomponent/components/filelist/FileListRecyclerViewAdapter.java`

字段/常量（13）：
- `ImageView downloadBtn`  L98
- `TextView downloadedTxv`  L99
- `ImageView editCheckBox`  L100
- `TextView fileDuration`  L101
- `TextView fileNameTxv`  L102
- `TextView fileSizeTxv`  L103
- `BorderImageView fileThumbnail`  L104
- `RelativeLayout fileThumbnailLayout`  L105
- `TextView fileTime`  L106
- `LinearLayout itemLayout`  L107
- `ImageView triggerType`  L108
- `ImageView videoTypeFlag`  L109
- `RelativeLayout relativeLayout = this.fileThumbnailLayout`  L120
### `com.tinyai.libmediacomponent.components.filelist.FileListView`
L24 · [class] public FileListView · extends `LinearLayout` · `com/tinyai/libmediacomponent/components/filelist/FileListView.java`

字段/常量（60）：
- `String TAG = "FileListView"`  L25
- `FileListRecyclerViewAdapter adapter`  L26
- `AttributeSet attrs`  L27
- `Context context`  L28
- `int curRefreshMode`  L29
- `List<FileItemInfo> deviceFileList`  L30
- `RecyclerView deviceFileListView`  L31
- `int editBarHeight`  L32
- `int editBarbackground`  L33
- `EditBtnClickListener editBtnClickListener`  L34
- `ImageButton editDeleteBtn`  L35
- `int editDeleteResId`  L36
- `ImageButton editDownloadBtn`  L37
- `int editDownloadResId`  L38
- `LinearLayout editLayout`  L39
- `int editSelectAllResId`  L40
- `ImageButton editSelectBtn`  L41
- `TextView editSelectedNumTxv`  L42
- `int editUnselectAllResId`  L43
- `int gridSpanCount`  L44
- `boolean isMore`  L45
- `ItemContentClickListener itemContentClickListener`  L46
- `int layoutType`  L47
- `OperationMode operationMode`  L48
- `OperationModeListener operationModeListener`  L49
- `RefreshCallback refreshListener`  L50
- `int refresh_mode`  L51
- `SwipeRefreshLayout swipeRefreshLayout`  L52
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L245
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter2 = this.adapter`  L253
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter3 = this.adapter`  L261
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L272
- `RecyclerView recyclerView = this.deviceFileListView`  L280
- `RecyclerView recyclerView = this.deviceFileListView`  L287
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L299
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L306
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L313
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L320
- `OperationMode operationMode = OperationMode.MODE_EDIT`  L327
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L330
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L339
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L342
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L350
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L362
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter2 = this.adapter`  L372
- `List list = modeData`  L383
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter3 = FileListView.this.adapter`  L385
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter4 = FileListView.this.adapter`  L392
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter3 = this.adapter`  L402
- `int i = 0`  L411
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L426
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L434
- `SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout`  L441
- `LinearLayout linearLayout = this.editLayout`  L487
- `ImageButton imageButton = this.editDeleteBtn`  L501
- `ImageButton imageButton = this.editDeleteBtn`  L509
- `ImageButton imageButton = this.editDownloadBtn`  L518
- `ImageButton imageButton = this.editDownloadBtn`  L526
- `FileListRecyclerViewAdapter fileListRecyclerViewAdapter = this.adapter`  L553
- `RecyclerView recyclerView = this.deviceFileListView`  L564

方法（49）：
- `public FileListView(Context context)`  L114
- `public FileListView(Context context, AttributeSet attributeSet)`  L118
- `public FileListView(Context context, AttributeSet attributeSet, int i)`  L122
- `void initView(Context context, AttributeSet attributeSet)`  L139
    - 体内字面量："#4DB6AC"
- `void onRefresh()`  L175 @Override
- `void run()`  L178 @Override
- `void onItemClick(int i, View view, RecyclerView.ViewHolder viewHolder)`  L189 @Override
    - 体内字面量："onItemClick position:"
- `void onItemLongClick(int i, View view, RecyclerView.ViewHolder viewHolder)`  L204 @Override
    - 体内字面量："onItemLongClick position:"
- `void onLoadMore()`  L213 @Override
- `void onClick(View view)`  L222 @Override
- `void onClick(View view)`  L231 @Override
    - 体内字面量："init view"
- `void setLayoutType(int i)`  L243
- `void setOperationMode(OperationMode operationMode)`  L269
- `void setRecyclerViewAdapter(FileListRecyclerViewAdapter fileListRecyclerViewAdapter)`  L279
- `void setRecyclerViewLayoutManager(RecyclerView.LayoutManager layoutManager)`  L286
- `void changeLayoutType(int i)`  L293
- `void enableChecked(boolean z)`  L305
- `void enableDelete(boolean z)`  L312
- `void enableDownload(boolean z)`  L319
- `void enterEditMode(int i)`  L326
- `void exitEditMode()`  L338
- `List<FileItemInfo> getMultipleSelectionItems()`  L349
- `OperationMode getOperationMode()`  L357
- `void loadMoreFile()`  L361
- `void run()`  L378 @Override
- `void run()`  L382 @Override
- `void markDeleted(FileItemInfo fileItemInfo)`  L410
- `void markDownloaded(FileItemInfo fileItemInfo)`  L433
- `void refreshComplete()`  L440
- `void renderList(List<FileItemInfo> list)`  L448
    - 体内字面量："renderList"
- `void delete(FileItemInfo fileItemInfo, int i)`  L454 @Override
- `void download(FileItemInfo fileItemInfo, int i)`  L461 @Override
- `void onItemsSelected(List<FileItemInfo> list2)`  L469 @Override
    - 体内字面量："$1$"
- `void setEditBarHeight(int i)`  L480
- `void setEditBarbackground(int i)`  L484
- `void setEditBtnClickListener(EditBtnClickListener editBtnClickListener)`  L494
- `void setEditDeleteResId(int i)`  L498
- `void setEditDeleteVisibility(int i)`  L508
- `void setEditDownloadResId(int i)`  L515
- `void setEditDownloadVisibility(int i)`  L525
- `void setEditSelectAllResId(int i)`  L532
- `void setEditUnselectAllResId(int i)`  L538
- `void setGridSpanCount(int i)`  L544
- `void setItemContentClickListener(ItemContentClickListener itemContentClickListener)`  L548
- `void setMultipleSelectionListener(MultipleSelectionListener multipleSelectionListener)`  L552
- `void setOperationModeListener(OperationModeListener operationModeListener)`  L559
- `void setRecyclerViewVisibility(int i)`  L563
- `void setRefreshListener(RefreshCallback refreshCallback)`  L570
- `void setRefreshMode(int i)`  L574
### `com.tinyai.libmediacomponent.components.filelist.FileListView$AnonymousClass4`
L55 · [class] AnonymousClass4 · implements `View.OnClickListener` · `com/tinyai/libmediacomponent/components/filelist/FileListView.java`

方法（3）：
- `void onClick(View view)`  L60 @Override
- `void onComplete(boolean z, List<FileItemInfo> list)`  L66 @Override
- `void run()`  L73 @Override
### `com.tinyai.libmediacomponent.components.filelist.FileListView$DeleteResponse`
L84 · [interface] public DeleteResponse · `com/tinyai/libmediacomponent/components/filelist/FileListView.java`

方法（1）：
- `void onComplete(boolean z, List<FileItemInfo> list)`  L85
### `com.tinyai.libmediacomponent.components.filelist.FileListView$EditBtnClickListener`
L88 · [interface] public EditBtnClickListener · `com/tinyai/libmediacomponent/components/filelist/FileListView.java`

方法（2）：
- `void deleteOnClick(List<FileItemInfo> list, DeleteResponse deleteResponse)`  L89
- `void downloadOnClick(List<FileItemInfo> list)`  L91
### `com.tinyai.libmediacomponent.components.filelist.FileListView$ItemContentClickListener`
L94 · [interface] public ItemContentClickListener · `com/tinyai/libmediacomponent/components/filelist/FileListView.java`

方法（4）：
- `void deleteOnClick(FileItemInfo fileItemInfo, int i)`  L95
- `void downloadOnClick(FileItemInfo fileItemInfo, int i)`  L97
- `void itemOnClick(FileItemInfo fileItemInfo, int i)`  L99
- `void itemOnLongClick(FileItemInfo fileItemInfo, int i)`  L101
### `com.tinyai.libmediacomponent.components.filelist.FileListView$OperationModeListener`
L104 · [interface] public OperationModeListener · `com/tinyai/libmediacomponent/components/filelist/FileListView.java`

方法（1）：
- `void onChanged(OperationMode operationMode)`  L105
### `com.tinyai.libmediacomponent.components.filelist.FileListView$RefreshCallback`
L108 · [interface] public RefreshCallback · `com/tinyai/libmediacomponent/components/filelist/FileListView.java`

方法（2）：
- `List<FileItemInfo> getModeData()`  L109
- `List<FileItemInfo> refreshData()`  L111
### `com.tinyai.libmediacomponent.components.filelist.FileListView2`
L21 · [class] public FileListView2 · extends `LinearLayout implements PullToRefreshBase.OnRefreshListener2` · implements `PullToRefreshBase.OnRefreshListener2` · `com/tinyai/libmediacomponent/components/filelist/FileListView2.java`

字段/常量（40）：
- `String TAG = "FileListView"`  L22
- `FileListViewAdapter adapter`  L23
- `AttributeSet attrs`  L24
- `int column`  L25
- `Context context`  L26
- `List<FileItemInfo> deviceFileList`  L27
- `PullToRefreshListView deviceFileListView`  L28
- `int editBarHeight`  L29
- `int editBarbackground`  L30
- `EditBtnClickListener editBtnClickListener`  L31
- `ImageButton editDeleteBtn`  L32
- `int editDeleteResId`  L33
- `ImageButton editDownloadBtn`  L34
- `int editDownloadResId`  L35
- `LinearLayout editLayout`  L36
- `int editSelectAllResId`  L37
- `ImageButton editSelectBtn`  L38
- `TextView editSelectedNumTxv`  L39
- `int editUnselectAllResId`  L40
- `ItemContentClickListener itemContentClickListener`  L41
- `OperationMode operationMode`  L42
- `OperationModeListener operationModeListener`  L43
- `RefreshCallback refreshListener`  L44
- `int refresh_mode`  L45
- `int viewType`  L46
- `int i2 = i - 1`  L167
- `FileListViewAdapter fileListViewAdapter = this.adapter`  L213
- `FileListViewAdapter fileListViewAdapter = this.adapter`  L220
- `FileListViewAdapter fileListViewAdapter = this.adapter`  L227
- `FileListViewAdapter fileListViewAdapter = this.adapter`  L234
- `int i = 0`  L246
- `FileListViewAdapter fileListViewAdapter = this.adapter`  L261
- `FileListViewAdapter fileListViewAdapter = this.adapter`  L269
- `PullToRefreshListView pullToRefreshListView = this.deviceFileListView`  L314
- `LinearLayout linearLayout = this.editLayout`  L358
- `ImageButton imageButton = this.editDeleteBtn`  L372
- `ImageButton imageButton = this.editDownloadBtn`  L382
- `FileListViewAdapter fileListViewAdapter = this.adapter`  L406
- `FileListViewAdapter fileListViewAdapter = this.adapter`  L415
- `PullToRefreshBase.Mode mode = PullToRefreshBase.Mode.DISABLED`  L431

方法（39）：
- `public FileListView2(Context context)`  L108
- `public FileListView2(Context context, AttributeSet attributeSet)`  L112
- `public FileListView2(Context context, AttributeSet attributeSet, int i)`  L116
- `void initView(Context context, AttributeSet attributeSet)`  L131
- `void onItemClick(AdapterView<?> adapterView, View view, int i, long j)`  L165 @Override
- `boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j)`  L180 @Override
- `void onClick(View view)`  L191 @Override
- `void onClick(View view)`  L200 @Override
    - 体内字面量："init view"
- `void enableChecked(boolean z)`  L212
- `void enableDelete(boolean z)`  L219
- `void enableDownload(boolean z)`  L226
- `List<FileItemInfo> getMultipleSelectionItems()`  L233
- `OperationMode getOperationMode()`  L241
- `void markDeleted(FileItemInfo fileItemInfo)`  L245
- `void markDownloaded(FileItemInfo fileItemInfo)`  L268
- `void onPullDownToRefresh(PullToRefreshBase pullToRefreshBase)`  L276 @Override
- `void run()`  L280 @Override
- `void run()`  L284 @Override
- `void onPullUpToRefresh(PullToRefreshBase pullToRefreshBase)`  L295 @Override
- `void run()`  L299 @Override
- `void run()`  L303 @Override
- `void refreshComplete()`  L313
- `void renderList(List<FileItemInfo> list)`  L320
    - 体内字面量："renderList"
- `void delete(FileItemInfo fileItemInfo, int i)`  L326 @Override
- `void download(FileItemInfo fileItemInfo, int i)`  L333 @Override
- `void onItemsSelected(List<FileItemInfo> list2)`  L341 @Override
    - 体内字面量："Selected(" · ")"
- `void setEditBarHeight(int i)`  L351
- `void setEditBarbackground(int i)`  L355
- `void setEditBtnClickListener(EditBtnClickListener editBtnClickListener)`  L365
- `void setEditDeleteResId(int i)`  L369
- `void setEditDownloadResId(int i)`  L379
- `void setEditSelectAllResId(int i)`  L389
- `void setEditUnselectAllResId(int i)`  L395
- `void setItemContentClickListener(ItemContentClickListener itemContentClickListener)`  L401
- `void setMultipleSelectionListener(MultipleSelectionListener multipleSelectionListener)`  L405
- `void setOperationMode(OperationMode operationMode)`  L412
- `void setOperationModeListener(OperationModeListener operationModeListener)`  L422
- `void setRefreshListener(RefreshCallback refreshCallback)`  L426
- `void setRefreshMode(int i)`  L430
### `com.tinyai.libmediacomponent.components.filelist.FileListView2$AnonymousClass3`
L49 · [class] AnonymousClass3 · implements `View.OnClickListener` · `com/tinyai/libmediacomponent/components/filelist/FileListView2.java`

方法（3）：
- `void onClick(View view)`  L54 @Override
- `void onComplete(boolean z, List<FileItemInfo> list)`  L60 @Override
- `void run()`  L67 @Override
### `com.tinyai.libmediacomponent.components.filelist.FileListView2$DeleteResponse`
L78 · [interface] public DeleteResponse · `com/tinyai/libmediacomponent/components/filelist/FileListView2.java`

方法（1）：
- `void onComplete(boolean z, List<FileItemInfo> list)`  L79
### `com.tinyai.libmediacomponent.components.filelist.FileListView2$EditBtnClickListener`
L82 · [interface] public EditBtnClickListener · `com/tinyai/libmediacomponent/components/filelist/FileListView2.java`

方法（2）：
- `void deleteOnClick(List<FileItemInfo> list, DeleteResponse deleteResponse)`  L83
- `void downloadOnClick(List<FileItemInfo> list)`  L85
### `com.tinyai.libmediacomponent.components.filelist.FileListView2$ItemContentClickListener`
L88 · [interface] public ItemContentClickListener · `com/tinyai/libmediacomponent/components/filelist/FileListView2.java`

方法（4）：
- `void deleteOnClick(FileItemInfo fileItemInfo)`  L89
- `void downloadOnClick(FileItemInfo fileItemInfo)`  L91
- `void itemOnClick(FileItemInfo fileItemInfo)`  L93
- `void itemOnLongClick(FileItemInfo fileItemInfo)`  L95
### `com.tinyai.libmediacomponent.components.filelist.FileListView2$OperationModeListener`
L98 · [interface] public OperationModeListener · `com/tinyai/libmediacomponent/components/filelist/FileListView2.java`

方法（1）：
- `void onChanged(OperationMode operationMode)`  L99
### `com.tinyai.libmediacomponent.components.filelist.FileListView2$RefreshCallback`
L102 · [interface] public RefreshCallback · `com/tinyai/libmediacomponent/components/filelist/FileListView2.java`

方法（2）：
- `List<FileItemInfo> getModeData()`  L103
- `List<FileItemInfo> refreshData()`  L105
### `com.tinyai.libmediacomponent.components.filelist.FileListViewAdapter`
L30 · [class] public FileListViewAdapter · extends `BaseAdapter implements StickyGridHeadersSimpleAdapter` · implements `StickyGridHeadersSimpleAdapter` · `com/tinyai/libmediacomponent/components/filelist/FileListViewAdapter.java`

字段/常量（30）：
- `String TAG = "FileListViewAdapter"`  L31
- `int checkedImgResId`  L32
- `Context context`  L33
- `int deleteImgResId`  L34
- `int downloadImgResId`  L35
- `boolean enableChecked`  L36
- `boolean enableDelete`  L37
- `boolean enableDownload`  L38
- `int image_radius`  L39
- `int itemLayoutRes`  L40
- `int item_background`  L41
- `int item_height`  L42
- `List<FileItemInfo> list`  L43
- `LayoutInflater mInflater`  L44
- `MultipleSelectionListener multipleSelectionListener`  L45
- `OperationMode operationMode`  L46
- `int triggerTypeImgPirResId`  L47
- `int triggerTypeImgRingResId`  L48
- `int uncheckedImgResId`  L49
- `long selectTitleIndex = 0`  L50
- `FileItemInfo selectItem = null`  L51
- `MediaListItemClickListener mediaListItemClickListener = null`  L52
- `String deviceId`  L54
- `HeaderViewHolder headerViewHolder`  L120
- `View viewInflate`  L166
- `ViewHolder viewHolder`  L167
- `int i2`  L168
- `FileItemInfo fileItemInfo`  L169
- `int i3 = R.drawable.meida_camera_roll_btn_video_loading`  L211
- `MultipleSelectionListener multipleSelectionListener = this.multipleSelectionListener`  L338

方法（30）：
- `public FileListViewAdapter(Context context, List<FileItemInfo> list, AttributeSet attributeSet, OperationMode operationMode)`  L75
    - 体内字面量："enableChecked:" · " enableDownload=" · " enableDelete="
- `int getCount()`  L109 @Override
- `long getHeaderId(int i)`  L114 @Override
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L119 @Override
- `Object getItem(int i)`  L134 @Override
- `long getItemId(int i)`  L139 @Override
- `OperationMode getOperationMode()`  L143
- `List<FileItemInfo> getSelectedItem()`  L147
- `String getThumbUrl(String str, int i)`  L157
    - 体内字面量："datachannel://" · "deviceId=" · "&fileHandle="
- `View getView(final int i, View view, ViewGroup viewGroup)`  L165 @Override
- `void onLoadingComplete(String str, View view2, Bitmap bitmap)`  L251 @Override
- `void onLoadingFailed(String str, View view2)`  L255 @Override
    - 体内字面量："ImageLoader.getInstance().displayImage failed, url = " · ", retry"
- `void onLoadingComplete(String str2, View view3, Bitmap bitmap)`  L259 @Override
- `void onLoadingFailed(String str2, View view3)`  L263 @Override
- `void onLoadingStarted(String str2, View view3)`  L267 @Override
- `void onLoadingStarted(String str, View view2)`  L273 @Override
    - 体内字面量："%02d:%02d"
- `void onClick(View view2)`  L298 @Override
- `boolean isItemChecked(int i)`  L308
- `boolean isSelectedAll()`  L312
- `void setEnableChecked(boolean z)`  L321
- `void setEnableDelete(boolean z)`  L326
- `void setEnableDownload(boolean z)`  L331
- `void setItemChecked(int i, boolean z)`  L336
- `void setList(List<FileItemInfo> list)`  L344
- `void setMediaListItemClickListener(MediaListItemClickListener mediaListItemClickListener)`  L348
- `void setMultipleSelectionListener(MultipleSelectionListener multipleSelectionListener)`  L352
- `void setOperationMode(OperationMode operationMode)`  L356
- `void setSelectAll(boolean z)`  L361
- `void setSelectItem(int i, FileItemInfo fileItemInfo)`  L368
- `void setSelectTitleIndex(long j)`  L374
### `com.tinyai.libmediacomponent.components.filelist.FileListViewAdapter$HeaderViewHolder`
L57 · [class] public static HeaderViewHolder · `com/tinyai/libmediacomponent/components/filelist/FileListViewAdapter.java`

字段/常量（1）：
- `TextView mTextView`  L58
### `com.tinyai.libmediacomponent.components.filelist.FileListViewAdapter$ViewHolder`
L61 · [class] public static ViewHolder · `com/tinyai/libmediacomponent/components/filelist/FileListViewAdapter.java`

字段/常量（11）：
- `ImageView downloadBtn`  L62
- `TextView downloadedTxv`  L63
- `ImageView editCheckBox`  L64
- `TextView fileDuration`  L65
- `TextView fileNameTxv`  L66
- `BorderImageView fileThumbnail`  L67
- `RelativeLayout fileThumbnailLayout`  L68
- `TextView fileTime`  L69
- `LinearLayout itemLayout`  L70
- `ImageView triggerType`  L71
- `ImageView videoTypeFlag`  L72
### `com.tinyai.libmediacomponent.components.filelist.MediaListItemClickListener`
L4 · [interface] public MediaListItemClickListener · `com/tinyai/libmediacomponent/components/filelist/MediaListItemClickListener.java`

方法（2）：
- `void delete(FileItemInfo fileItemInfo, int i)`  L5
- `void download(FileItemInfo fileItemInfo, int i)`  L7
### `com.tinyai.libmediacomponent.components.filelist.MultiPbRecyclerViewAdapter`
L22 · [class] public MultiPbRecyclerViewAdapter · extends `RecyclerView.Adapter<RecyclerView.ViewHolder>` · `com/tinyai/libmediacomponent/components/filelist/MultiPbRecyclerViewAdapter.java`

字段/常量（21）：
- `int TYPE_GRID = 1`  L23
- `int TYPE_LIST = 2`  L24
- `int TYPE_QUICK_LIST = 3`  L25
- `Context context`  L26
- `List<FileItemInfo> list`  L27
- `int width`  L28
- `int TYPE_FOOTER = 4`  L29
- `int LOADING = 1`  L30
- `int LOADING_COMPLETE = 2`  L31
- `int LOADING_END = 3`  L32
- `int curViewType = 1`  L33
- `int loadState = 2`  L34
- `OperationMode operationMode = OperationMode.MODE_BROWSE`  L35
- `int downloadImgResId = R.drawable.meida_selector_download_btn`  L36
- `int itemLayoutRes = R.layout.media_file_list_item`  L37
- `int deleteImgResId = R.drawable.meida_selector_delete_btn`  L38
- `int checkedImgResId = R.drawable.meida_check_box_blue`  L39
- `int uncheckedImgResId = R.drawable.meida_check_box_blank_grey`  L40
- `int defaultIcon = R.drawable.meida_camera_roll_btn_video_loading`  L41
- `int i = 0`  L158
- `int i2 = this.loadState`  L228

方法（20）：
- `public MultiPbRecyclerViewAdapter(Context context, List<FileItemInfo> list)`  L110
- `void cancelAllSelections()`  L116
- `void changeCheckBoxState(int i)`  L123
- `List<FileItemInfo> getCheckedItemsList()`  L130
- `int getItemCount()`  L141 @Override
- `int getItemViewType(int i)`  L146 @Override
- `int getLoadState()`  L153
- `int getSelectedCount()`  L157
- `boolean isItemChecked(int i)`  L167
- `boolean isSelectedAll()`  L171
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L181 @Override
- `int getSpanSize(int i)`  L187 @Override
- `void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i)`  L195 @Override
- `RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L249 @Override
- `void quitEditMode()`  L262
- `void selectAllItems()`  L270
- `void setCurViewType(int i)`  L277
- `void setLoadState(int i)`  L281
- `void setOperationMode(OperationMode operationMode)`  L286
- `void setSelectAll(boolean z)`  L290
### `com.tinyai.libmediacomponent.components.filelist.MultiPbRecyclerViewAdapter$FootViewHolder`
L43 · [class] private FootViewHolder · extends `RecyclerView.ViewHolder` · `com/tinyai/libmediacomponent/components/filelist/MultiPbRecyclerViewAdapter.java`

字段/常量（3）：
- `LinearLayout llEnd`  L44
- `ProgressBar pbLoading`  L45
- `TextView tvLoading`  L46
### `com.tinyai.libmediacomponent.components.filelist.MultiPbRecyclerViewAdapter$RecyclerViewGridHolder`
L56 · [class] private RecyclerViewGridHolder · extends `RecyclerView.ViewHolder` · `com/tinyai/libmediacomponent/components/filelist/MultiPbRecyclerViewAdapter.java`

字段/常量（4）：
- `ImageView editCheckBox`  L57
- `ImageView mImageView`  L58
- `ImageView mIsPanoramaSign`  L59
- `ImageView videoTypeFlag`  L60
### `com.tinyai.libmediacomponent.components.filelist.MultiPbRecyclerViewAdapter$RecyclerViewListHolder`
L71 · [class] private RecyclerViewListHolder · extends `RecyclerView.ViewHolder` · `com/tinyai/libmediacomponent/components/filelist/MultiPbRecyclerViewAdapter.java`

字段/常量（12）：
- `ImageView downloadBtn`  L72
- `TextView downloadedTxv`  L73
- `ImageView editCheckBox`  L74
- `TextView fileDuration`  L75
- `TextView fileNameTxv`  L76
- `BorderImageView fileThumbnail`  L77
- `RelativeLayout fileThumbnailLayout`  L78
- `TextView fileTime`  L79
- `LinearLayout itemLayout`  L80
- `ImageView triggerType`  L81
- `ImageView videoTypeFlag`  L82
- `BorderImageView borderImageView = this.fileThumbnail`  L92
### `com.tinyai.libmediacomponent.components.filelist.MultipleSelectionListener`
L6 · [interface] public MultipleSelectionListener · `com/tinyai/libmediacomponent/components/filelist/MultipleSelectionListener.java`

方法（1）：
- `void onItemsSelected(List<FileItemInfo> list)`  L7
### `com.tinyai.libmediacomponent.components.filelist.OnRecyclerItemClickListener`
L10 · [class] public abstract OnRecyclerItemClickListener · implements `RecyclerView.OnItemTouchListener` · `com/tinyai/libmediacomponent/components/filelist/OnRecyclerItemClickListener.java`

字段/常量（2）：
- `GestureDetectorCompat mGestureDetector`  L11
- `RecyclerView recyclerView`  L12

方法（6）：
- `public OnRecyclerItemClickListener(RecyclerView recyclerView)`  L39
- `boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)`  L45 @Override
- `void onItemClick(int i, View view, RecyclerView.ViewHolder viewHolder)`  L50
- `void onItemLongClick(int i, View view, RecyclerView.ViewHolder viewHolder)`  L52
- `void onRequestDisallowInterceptTouchEvent(boolean z)`  L55 @Override
- `void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent)`  L59 @Override
### `com.tinyai.libmediacomponent.components.filelist.OnRecyclerItemClickListener$ItemTouchHelperGestureListener`
L14 · [class] private ItemTouchHelperGestureListener · extends `GestureDetector.SimpleOnGestureListener` · `com/tinyai/libmediacomponent/components/filelist/OnRecyclerItemClickListener.java`

方法（3）：
- `private ItemTouchHelperGestureListener()`  L15
- `void onLongPress(MotionEvent motionEvent)`  L19 @Override
- `boolean onSingleTapUp(MotionEvent motionEvent)`  L28 @Override
### `com.tinyai.libmediacomponent.components.filelist.OperationMode`
L4 · [enum] public OperationMode · `com/tinyai/libmediacomponent/components/filelist/OperationMode.java`

枚举常量（1）：
- `MODE_BROWSE()`  L5
### `com.tinyai.libmediacomponent.components.filelist.PhotoWallLayoutType`
L4 · [class] public PhotoWallLayoutType · `com/tinyai/libmediacomponent/components/filelist/PhotoWallLayoutType.java`

字段/常量（3）：
- `int PREVIEW_TYPE_GRID = 1`  L5
- `int PREVIEW_TYPE_LIST = 0`  L6
- `int PREVIEW_TYPE_QUICK_LIST = 2`  L7
### `com.tinyai.libmediacomponent.components.filelist.RefreshMode`
L4 · [class] public RefreshMode · `com/tinyai/libmediacomponent/components/filelist/RefreshMode.java`

字段/常量（5）：
- `int BOTH = 3`  L5
- `int DISABLED = 0`  L6
- `int MANUAL_REFRESH_ONLY = 4`  L7
- `int PULL_FROM_END = 2`  L8
- `int PULL_FROM_START = 1`  L9
### `com.tinyai.libmediacomponent.components.media.audio.AudioPlayerView`
L18 · [class] public AudioPlayerView · extends `FrameLayout` · `com/tinyai/libmediacomponent/components/media/audio/AudioPlayerView.java`

字段/常量（35）：
- `String TAG = "AudioPlayerView"`  L19
- `ImageView back`  L20
- `LinearLayout bottomBar`  L21
- `boolean cacheFlag`  L22
- `double currentTime`  L23
- `ImageView delete`  L24
- `ImageView download`  L25
- `ImageButton fullScreenImgbtn`  L26
- `int lastSeekBarPosition`  L27
- `ImageView moreBtn`  L28
- `boolean needUpdateSeekBar`  L29
- `ImageButton play`  L30
- `ImageView playCircleImv`  L31
- `IPlayerApi playerApi`  L32
- `OnPrepareCompletedListener prepareCompletedListener`  L33
- `MProgressWheel progressWheel`  L34
- `SeekBar seekBar`  L35
- `TextView spaceTxv`  L36
- `ImageButton stop`  L37
- `TextView timeDurationTxv`  L38
- `TextView timeLapsedTxv`  L39
- `LinearLayout topBar`  L40
- `String url`  L41
- `int videoDuration`  L42
- `TextView videoNameTxv`  L43
- `Boolean waitForCaching`  L44
- `SeekBar seekBar = this.seekBar`  L113
- `SeekBar seekBar = this.seekBar`  L136
- `ImageButton imageButton = this.play`  L155
- `ImageView imageView = this.playCircleImv`  L163
- `SeekBar seekBar = this.seekBar`  L171
- `SeekBar seekBar = this.seekBar`  L179
- `SeekBar seekBar = this.seekBar`  L187
- `TextView textView = this.timeDurationTxv`  L195
- `TextView textView = this.timeLapsedTxv`  L203

方法（28）：
- `public AudioPlayerView(Context context)`  L46
- `public AudioPlayerView(Context context, AttributeSet attributeSet)`  L50
- `public AudioPlayerView(Context context, AttributeSet attributeSet, int i)`  L54
- `void initPlayer()`  L64
- `void onPlayCompleted()`  L69 @Override
    - 体内字面量："onPlayCompleted"
- `void onPositionChanged(int i)`  L74 @Override
    - 体内字面量："onPositionChanged position:"
- `void onStateChanged(int i)`  L82 @Override
    - 体内字面量："onStateChanged state:"
- `void onTotalDuration(int i)`  L87 @Override
    - 体内字面量："onTotalDuration duration:"
- `void initView(Context context, AttributeSet attributeSet)`  L95
- `void onProgressChanged(SeekBar seekBar2, int i, boolean z)`  L117 @Override
- `void onStartTrackingTouch(SeekBar seekBar2)`  L122 @Override
- `void onStopTrackingTouch(SeekBar seekBar2)`  L127 @Override
- `int getSeekBarProgress()`  L135
- `void release()`  L143
- `void seekToCurrentPosition()`  L146
- `void setPlayBtnBackground(int i)`  L154
- `void setPlayCircleImageViewVisibility(int i)`  L162
- `void setSeekBarMaxValue(int i)`  L170
- `void setSeekBarProgress(int i)`  L178
- `void setSeekBarSecondProgress(int i)`  L186
- `void setTimeDurationValue(String str)`  L194
- `void setTimeLapsedValue(String str)`  L202
- `void setUrl(String str)`  L210
- `void start()`  L214
- `void onComplete()`  L217 @Override
- `void stop()`  L225
- `void updateLapseTime(int i)`  L229
- `void updateLastSeekPosition()`  L233
### `com.tinyai.libmediacomponent.components.media.audio.IPlayerApi`
L4 · [interface] public IPlayerApi · `com/tinyai/libmediacomponent/components/media/audio/IPlayerApi.java`

方法（8）：
- `boolean isPlaying()`  L5
- `void loadMedia(String str, OnPrepareCompletedListener onPrepareCompletedListener)`  L7
- `void pause()`  L9
- `void play()`  L11
- `void release()`  L13
- `void reset()`  L15
- `void seekTo(int i)`  L17
- `void setPlaybackInfoListener(PlaybackInfoListener playbackInfoListener)`  L19
### `com.tinyai.libmediacomponent.components.media.audio.MediaPlayerAdpater`
L13 · [class] public MediaPlayerAdpater · implements `IPlayerApi` · `com/tinyai/libmediacomponent/components/media/audio/MediaPlayerAdpater.java`

字段/常量（30）：
- `int STATUS_ERROR = -1`  L14
- `int STATUS_PALYINGP = 0`  L15
- `int STATUS_PLAY_COMPLETE = 3`  L16
- `int STATUS_PREPER_COMPLETE = 4`  L17
- `int STATUS_PREPER_ING = 5`  L18
- `int STATUS_RESET = 2`  L19
- `int STATUS_STOP = 1`  L20
- `ScheduledExecutorService mExecutor`  L21
- `MediaPlayer mMediaPlayer`  L22
- `OnPrepareCompletedListener mOnPrepareCompletedListener`  L23
- `Runnable mSeekbarPositionUpdateTask`  L24
- `PlaybackInfoListener playbackInfoListener`  L25
- `int PLAYBACK_POSITION_REFRESH_INTERVAL_MS = 500`  L26
- `String TAG = "MediaPlayerHolder"`  L27
- `int mMusicRawId = 0`  L28
- `String mMusicUrl = null`  L29
- `PlaybackInfoListener playbackInfoListener = this.playbackInfoListener`  L113
- `PlaybackInfoListener playbackInfoListener`  L138
- `ScheduledExecutorService scheduledExecutorService = this.mExecutor`  L139
- `MediaPlayer mediaPlayer = this.mMediaPlayer`  L153
- `PlaybackInfoListener playbackInfoListener = this.playbackInfoListener`  L159
- `MediaPlayer mediaPlayer = this.mMediaPlayer`  L170
- `PlaybackInfoListener playbackInfoListener = this.playbackInfoListener`  L185
- `MediaPlayer mediaPlayer = this.mMediaPlayer`  L202
- `PlaybackInfoListener playbackInfoListener = this.playbackInfoListener`  L207
- `MediaPlayer mediaPlayer = this.mMediaPlayer`  L216
- `PlaybackInfoListener playbackInfoListener = this.playbackInfoListener`  L221
- `String str = this.mMusicUrl`  L243
- `PlaybackInfoListener playbackInfoListener = this.playbackInfoListener`  L247
- `MediaPlayer mediaPlayer = this.mMediaPlayer`  L257

方法（17）：
- `void initializeMediaPlayer()`  L31
- `void onCompletion(MediaPlayer mediaPlayer)`  L34 @Override
- `void onPrepared(MediaPlayer mediaPlayer)`  L44 @Override
- `boolean onError(MediaPlayer mediaPlayer, int i, int i2)`  L53 @Override
    - 体内字面量："MediaPlayerHolder" · "OnError - Error code: " · " Extra code: " · "MediaPlayerHolder" · "MEDIA_ERROR_UNSUPPORTED" · "MediaPlayerHolder" · "MEDIA_ERROR_MALFORMED" · "MediaPlayerHolder" · "MEDIA_ERROR_IO" · "MediaPlayerHolder" · "MEDIA_ERROR_TIMED_OUT" · "MediaPlayerHolder" · "MEDIA_ERROR_UNKNOWN" · "MediaPlayerHolder" · "MEDIA_ERROR_SERVER_DIED" · "MediaPlayerHolder" · "MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK" · "MediaPlayerHolder" · "MEDIA_INFO_UNKNOWN" · "MediaPlayerHolder" · "MEDIA_INFO_VIDEO_RENDERING_START" · "MediaPlayerHolder" · "MEDIA_INFO_VIDEO_TRACK_LAGGING" · "MediaPlayerHolder" · "MEDIA_INFO_METADATA_UPDATE" · "MediaPlayerHolder" · "MEDIA_INFO_BUFFERING_END" · "MediaPlayerHolder" · "MEDIA_INFO_BAD_INTERLEAVING" · "MediaPlayerHolder" · "MEDIA_INFO_NOT_SEEKABLE" · "MediaPlayerHolder" · "MEDIA_INFO_METADATA_UPDATE"
- `void medisaPreparedCompled()`  L111
- `void startUpdatingCallbackWithPosition()`  L121
- `void run()`  L128 @Override
- `void stopUpdatingCallbackWithPosition(boolean z)`  L137
- `void updateProgressCallbackTask()`  L152
- `boolean isPlaying()`  L169 @Override
- `void loadMedia(String str, OnPrepareCompletedListener onPrepareCompletedListener)`  L178 @Override
    - 体内字面量："MediaPlayerHolder" · "å°åä¸ºç©º"
- `void pause()`  L201 @Override
- `void play()`  L215 @Override
- `void release()`  L229 @Override
- `void reset()`  L241 @Override
- `void seekTo(int i)`  L256 @Override
- `void setPlaybackInfoListener(PlaybackInfoListener playbackInfoListener)`  L264 @Override
### `com.tinyai.libmediacomponent.components.media.audio.OnPrepareCompletedListener`
L4 · [interface] public OnPrepareCompletedListener · `com/tinyai/libmediacomponent/components/media/audio/OnPrepareCompletedListener.java`

方法（1）：
- `void onComplete()`  L5
### `com.tinyai.libmediacomponent.components.media.audio.PlaybackInfoListener`
L4 · [interface] public PlaybackInfoListener · `com/tinyai/libmediacomponent/components/media/audio/PlaybackInfoListener.java`

方法（4）：
- `void onPlayCompleted()`  L5
- `void onPositionChanged(int i)`  L7
- `void onStateChanged(int i)`  L9
- `void onTotalDuration(int i)`  L11
### `com.tinyai.libmediacomponent.components.media.interfaces.IVideoControlView`
L4 · [interface] public IVideoControlView · `com/tinyai/libmediacomponent/components/media/interfaces/IVideoControlView.java`

方法（39）：
- `int getBottomBarVisibility()`  L5
- `int getSeekBarProgress()`  L7
- `int getTopBarVisibility()`  L9
- `void setBackIcon(int i)`  L11
- `void setBottomBarBackground(int i)`  L13
- `void setBottomBarVisibility(int i)`  L15
- `void setButtomBarHeight(int i)`  L17
- `void setCircePlayIcon(int i)`  L19
- `void setDeleteBtnVisibility(int i)`  L21
- `void setDeleteIcon(int i)`  L23
- `void setDownloadBtnVisibility(int i)`  L25
- `void setDownloadIcon(int i)`  L27
- `void setFullScreenImgbtnVisibility(int i)`  L29
- `void setFullscreenEnterIcon(int i)`  L31
- `void setFullscreenExitIcon(int i)`  L33
- `void setLoadPercent(int i)`  L35
- `void setMoreBtnVisibility(int i)`  L37
- `void setMoreIcon(int i)`  L39
- `void setPauseIcon(int i)`  L41
- `void setPlayBtnBackground(int i)`  L43
- `void setPlayCircleImageViewVisibility(int i)`  L45
- `void setPlayIcon(int i)`  L47
- `void setSeekBarMaxValue(int i)`  L49
- `void setSeekBarProgress(int i)`  L51
- `void setSeekBarSecondProgress(int i)`  L53
- `void setSeekbarProgressDrawable(int i)`  L55
- `void setSpaceTxvColor(int i)`  L57
- `void setTimeColor(int i)`  L59
- `void setTimeDurationTxvColor(int i)`  L61
- `void setTimeDurationValue(String str)`  L63
- `void setTimeLapsedTxvColor(int i)`  L65
- `void setTimeLapsedValue(String str)`  L67
- `void setTitle(String str)`  L69
- `void setTitleColor(int i)`  L71
- `void setTopBarBackground(int i)`  L73
- `void setTopBarHeight(int i)`  L75
- `void setTopBarVisibility(int i)`  L77
- `void setVideoNameTxvColor(int i)`  L79
- `void showLoadingCircle(boolean z)`  L81
### `com.tinyai.libmediacomponent.components.media.MPreviewView`
L39 · [class] public MPreviewView · extends `RelativeLayout implements TextureView.SurfaceTextureListener, SurfaceHolder.Callback` · implements `TextureView.SurfaceTextureListener, SurfaceHolder.Callback` · `com/tinyai/libmediacomponent/components/media/MPreviewView.java`

字段/常量（104）：
- `int DRAG = 1`  L40
- `float MAX_SCALE = 5.0f`  L41
- `float MID_SCALE = 2.5f`  L42
- `float MIN_DISTANCE = 100.0f`  L43
- `float MIN_SCALE = 1.0f`  L44
- `int NONE = 0`  L45
- `String TAG = "MPreviewView"`  L46
- `int ZOOM = 2`  L47
- `ClickListener clickListener`  L48
- `ProgressBar connect_loading_bar`  L49
- `RelativeLayout connect_loading_layout`  L50
- `TextView connect_loading_txt`  L51
- `float[] drag`  L52
- `boolean enableZoom`  L53
- `int frameHeigth`  L54
- `FramePtsChangedListener framePtsChangedListener`  L55
- `int frameWidth`  L56
- `boolean freeze`  L57
- `GestureDetector gestureDetector`  L58
- `boolean hasSurface`  L59
- `Timer hideScaleTxtTimer`  L60
- `int lastHeigth`  L61
- `int lastWidth`  L62
- `ImageView mPreviewImage`  L63
- `ProgressBar mProgressBar`  L64
- `MediaStreamPlayer mediaStreamPlayer`  L65
- `PointF midPoint`  L66
- `int mode`  L67
- `boolean needStart`  L68
- `float oldDist`  L69
- `float[] oldDrag`  L70
- `float oldScale`  L71
- `OnStreamSizeChangeListener onStreamSizeChangeListener`  L72
- `OnStreamingStatusChangedListener onStreamingStatusChangedListener`  L73
- `PointF pA`  L74
- `PointF pB`  L75
- `View parentView`  L76
- `float[] pivotPoint`  L77
- `float scale`  L78
- `TextView scaleTxt`  L79
- `boolean sdkRender`  L80
- `Surface surface`  L81
- `int surfaceType`  L82
- `View surfaceView`  L83
- `float[] touchMidPoint`  L84
- `RelativeLayout txvContainer`  L85
- `float f4 = f3 - 1.0f`  L144
- `float f5 = f * f4`  L145
- `float f6 = f2 * f4`  L148
- `float f7 = -width`  L154
- `float f8 = -height`  L162
- `float f3 = -width`  L179
- `float f4 = -height`  L188
- `Timer timer = this.hideScaleTxtTimer`  L196
- `View view`  L204
- `SurfaceView surfaceView`  L205
- `TextureView textureView`  L206
- `int i = this.surfaceType`  L211
- `float f3 = this.scale`  L237
- `MPreviewView mPreviewView = MPreviewView.this`  L259
- `ClickListener clickListener = this.clickListener`  L294
- `MPreviewView mPreviewView = MPreviewView.this`  L327
- `MPreviewView mPreviewView2 = MPreviewView.this`  L336
- `float[] fArr = this.drag`  L364
- `float[] fArr2 = this.oldDrag`  L368
- `float[] fArr3 = this.drag`  L369
- `float[] fArr4 = this.drag`  L373
- `float[] fArr5 = this.touchMidPoint`  L374
- `float f4 = fArr5[0] - f`  L375
- `float f5 = fArr5[1] - f2`  L377
- `float[] fArr6 = this.oldDrag`  L380
- `float[] fArr7 = this.drag`  L381
- `float[] fArr8 = this.pivotPoint`  L389
- `float f5 = f - f3`  L430
- `float f6 = f2 - f4`  L431
- `MediaStreamPlayer mediaStreamPlayer = this.mediaStreamPlayer`  L459
- `ProgressBar progressBar`  L535
- `View view = this.surfaceView`  L537
- `MediaStreamPlayer mediaStreamPlayer`  L550
- `View view = this.surfaceView`  L559
- `MediaStreamPlayer mediaStreamPlayer = this.mediaStreamPlayer`  L610
- `float[] fArr = this.oldDrag`  L637
- `float[] fArr2 = this.drag`  L638
- `PointF pointF = this.midPoint`  L655
- `float[] fArr3 = this.pivotPoint`  L656
- `float[] fArr4 = this.touchMidPoint`  L660
- `float f = fArr4[0]`  L661
- `float f2 = fArr4[1]`  L662
- `float f3 = this.midPoint.x`  L664
- `float f4 = f - this.midPoint.x`  L665
- `float f5 = this.oldScale`  L666
- `float f6 = this.midPoint.y`  L668
- `float f7 = f2 - this.midPoint.y`  L669
- `float f8 = this.oldScale`  L670
- `float f9 = this.scale`  L698
- `float[] fArr5 = this.drag`  L715
- `MediaStreamPlayer mediaStreamPlayer = this.mediaStreamPlayer`  L723
- `ImageView imageView = this.mPreviewImage`  L743
- `RelativeLayout relativeLayout = this.txvContainer`  L754
- `ProgressBar progressBar = this.mProgressBar`  L791
- `int i`  L814
- `int i2 = this.lastWidth`  L842
- `MediaStreamPlayer mediaStreamPlayer = this.mediaStreamPlayer`  L876
- `MediaStreamPlayer mediaStreamPlayer = this.mediaStreamPlayer`  L895

方法（68）：
- `public MPreviewView(Context context)`  L103
- `public MPreviewView(Context context, AttributeSet attributeSet)`  L107
- `public MPreviewView(Context context, AttributeSet attributeSet, int i)`  L111
- `void adjustScale(float f, float f2, float f3)`  L142
- `void adjustTranslation()`  L168
- `void cancelHideScaleTxtTimer()`  L195
- `View createTextureView()`  L203
- `void doubleClickScale(float f, float f2)`  L236
- `void initClickListen()`  L249
- `void onClick(View view)`  L252 @Override
- `void initView(Context context)`  L266
- `void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8)`  L279 @Override
- `void run()`  L285 @Override
- `void notifyClickStatus(boolean z)`  L293
- `void resetScale()`  L300
- `void scaleChanged(float f)`  L306
    - 体内字面量："%.1fX"
- `void setDoubleClickListen()`  L316
- `boolean onDoubleTapEvent(MotionEvent motionEvent)`  L319 @Override
- `boolean onSingleTapConfirmed(MotionEvent motionEvent)`  L348 @Override
- `boolean onTouch(View view, MotionEvent motionEvent)`  L355 @Override
- `void setScale(float f, float f2, float f3)`  L362
- `void setSurfaceViewLayoutParams(int i, int i2, int i3, int i4)`  L397
    - 体内字面量："setTextureViewLayoutParams isPanorama" · "setTextViewArea frameWidth or frameHeight <= 0!!!" · "setTextureViewLayoutParams width=" · " height="
- `void setTranslation(float f, float f2)`  L424
- `float spacing(float f, float f2, float f3, float f4)`  L429
- `float spacing(PointF pointF, PointF pointF2)`  L435
- `void startHideScaleTxtTimer()`  L439
- `void run()`  L445 @Override
- `void run()`  L448 @Override
- `void startStreamingAndDecode()`  L456
    - 体内字面量："startStreamingAndDecode"
- `void onFormatChanged(MVideoFormat mVideoFormat)`  L463 @Override
- `void run()`  L472 @Override
- `void run()`  L482 @Override
    - 体内字面量："do  setFrameLoadingListener:" · "call preview.startStreaming, getStream"
- `void addFramePtsChangedListener(FramePtsChangedListener framePtsChangedListener)`  L526
- `void addOnStreamingStatusChangedListener(OnStreamingStatusChangedListener onStreamingStatusChangedListener)`  L530
- `Bitmap capture(int i, int i2)`  L534
- `void closeConnectLoading()`  L545
- `void freezeDecoder()`  L549
- `Surface getSurface()`  L558
- `boolean isPanorama(long j, long j2)`  L572
- `void onLayout(boolean z, int i, int i2, int i3, int i4)`  L577 @Override
- `void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2)`  L582 @Override
    - 体内字面量：" onSurfaceTextureAvailable hasSurface=" · " needStart="
- `boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture)`  L600 @Override
    - 体内字面量：" onSurfaceTextureDestroyed"
- `void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2)`  L608 @Override
    - 体内字面量：" onSurfaceTextureSizeChanged width:" · " height:"
- `void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture)`  L618 @Override
- `boolean onTouchEvent(MotionEvent motionEvent)`  L622 @Override
    - 体内字面量："onTouchEvent ACTION_DOWN: pointAX = " · ", pointAY = "
- `void resumeDecoder()`  L722
- `void setBackgroundImage(int i)`  L732
- `void setBackgroundImage(byte[] bArr)`  L736
- `void setCameraImageVisibility(int i)`  L742
- `void setClickListener(ClickListener clickListener)`  L749
- `void setContainerBackground(int i)`  L753
- `void setEnableZoom(boolean z)`  L761
- `void setFrameLoadingListener()`  L765
- `void notify(final Object obj)`  L769 @Override
- `void run()`  L772 @Override
    - 体内字面量："setFrameLoadingListener:loadingObserver = "
- `void setLoadingBarVisibility(int i)`  L790
- `void setOnStreamSizeChangeListener(OnStreamSizeChangeListener onStreamSizeChangeListener)`  L797
- `void setSdkRender(boolean z)`  L801
- `void setStream(MediaStreamPlayer mediaStreamPlayer)`  L805
- `void setSurfaceType(int i)`  L809
- `void setTextViewArea()`  L813
- `void showConnectLoading(int i)`  L853
- `void startPreview()`  L858
    - 体内字面量："startStream ------- hasSurface= " · "startStream ------- needStart= " · "startStream ------- needStart= true "
- `void stopPreview()`  L874
    - 体内字面量："stopPreview"
- `void run()`  L885 @Override
- `void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3)`  L893 @Override
    - 体内字面量：" surfaceChanged width:" · " height:"
- `void surfaceCreated(SurfaceHolder surfaceHolder)`  L902 @Override
    - 体内字面量：" surfaceCreated hasSurface=" · " needStart="
- `void surfaceDestroyed(SurfaceHolder surfaceHolder)`  L920 @Override
    - 体内字面量：" surfaceDestroyed"
### `com.tinyai.libmediacomponent.components.media.MPreviewView$ClickListener`
L87 · [interface] public ClickListener · `com/tinyai/libmediacomponent/components/media/MPreviewView.java`

方法（1）：
- `void notifyClickStatus(boolean z)`  L88
### `com.tinyai.libmediacomponent.components.media.MPreviewView$OnStreamingStatusChangedListener`
L97 · [interface] public OnStreamingStatusChangedListener · `com/tinyai/libmediacomponent/components/media/MPreviewView.java`

方法（2）：
- `void onStreamingError(int i)`  L98
- `void onStreamingSuccess()`  L100
### `com.tinyai.libmediacomponent.components.media.MPreviewView$OnStreamSizeChangeListener`
L91 · [interface] public OnStreamSizeChangeListener · `com/tinyai/libmediacomponent/components/media/MPreviewView.java`

方法（2）：
- `void onComplete()`  L92
- `void onError()`  L94
### `com.tinyai.libmediacomponent.components.media.PanoramaTouchTool`
L10 · [class] public PanoramaTouchTool · `com/tinyai/libmediacomponent/components/media/PanoramaTouchTool.java`

字段/常量（17）：
- `float MAX_ZOOM = 2.2f`  L11
- `float MIN_ZOOM = 0.5f`  L12
- `float afterLenght`  L13
- `float beforeLenght`  L14
- `MediaStreamPlayer iStreamingControl`  L15
- `float mPreviousX`  L16
- `float mPreviousY`  L17
- `TouchMode touchMode = TouchMode.NONE`  L18
- `float currentZoomRate = MAX_ZOOM`  L19
- `float f2 = this.currentZoomRate`  L32
- `float f3 = f2 * f`  L35
- `float f4 = f2 * f`  L42
- `float f5 = f2 * f`  L53
- `IPanoramaControl panoramaControl`  L67
- `MediaStreamPlayer mediaStreamPlayer = this.iStreamingControl`  L68
- `IPanoramaControl panoramaControl`  L114
- `MediaStreamPlayer mediaStreamPlayer = this.iStreamingControl`  L117

方法（11）：
- `public PanoramaTouchTool(MediaStreamPlayer mediaStreamPlayer)`  L21
- `float getDistance(MotionEvent motionEvent)`  L25
- `void setScale(float f)`  L31
- `void zoom(float f)`  L62
- `void locate(float f)`  L66
- `void onSufaceViewPointerDown(MotionEvent motionEvent)`  L75
- `void onSufaceViewTouchDown(MotionEvent motionEvent)`  L82
- `void onSufaceViewTouchMove(MotionEvent motionEvent)`  L90
- `void onSufaceViewTouchPointerUp()`  L105
- `void onSufaceViewTouchUp()`  L109
- `void rotateB(MotionEvent motionEvent, float f, float f2)`  L113
### `com.tinyai.libmediacomponent.components.media.PreviewControlView`
L21 · [class] public PreviewControlView · extends `FrameLayout` · `com/tinyai/libmediacomponent/components/media/PreviewControlView.java`

字段/常量（49）：
- `int DEFAULT_SHOW_TIMEOUT_MS = 5000`  L22
- `int MAX_UPDATE_INTERVAL_MS = 1000`  L23
- `boolean alwaysHideBars`  L24
- `boolean alwaysHideTopBars`  L25
- `boolean autoHideBar`  L26
- `ImageView back`  L27
- `RelativeLayout bottomBar`  L28
- `Context context`  L29
- `ImageView fullScreenButton`  L30
- `int fullScreenEnterResId`  L31
- `int fullScreenExitResId`  L32
- `OnFullScreenModeChangedListener fullScreenModeChangedListener`  L33
- `Timer hideBarTimer`  L34
- `boolean isFullScreen`  L35
- `List<String> perviewSizeList`  L36
- `PreviewSizeChangedListener previewSizeChangedListener`  L37
- `TextView sizeTxv`  L38
- `TextView titleTxv`  L39
- `RelativeLayout topBar`  L40
- `VisibilityListener visibilityListener`  L41
- `Timer timer = this.hideBarTimer`  L77
- `int i`  L85
- `int i2`  L86
- `int i3`  L87
- `int i4`  L88
- `int i5`  L89
- `int i6`  L90
- `int i7`  L91
- `int i8`  L92
- `int i9`  L93
- `int i10`  L94
- `int i11`  L95
- `int i12`  L96
- `int i13 = R.layout.preview_control_view`  L97
- `int i14 = 0`  L99
- `ImageView imageView = this.fullScreenButton`  L176
- `PreviewControlView previewControlView = PreviewControlView.this`  L181
- `PreviewControlView previewControlView2 = PreviewControlView.this`  L183
- `RelativeLayout relativeLayout = this.bottomBar`  L224
- `RelativeLayout relativeLayout = this.topBar`  L232
- `ImageView imageView = this.back`  L259
- `RelativeLayout relativeLayout = this.bottomBar`  L267
- `RelativeLayout relativeLayout = this.bottomBar`  L286
- `ImageView imageView = this.fullScreenButton`  L296
- `TextView textView = this.sizeTxv`  L333
- `TextView textView = this.titleTxv`  L340
- `TextView textView = this.titleTxv`  L348
- `RelativeLayout relativeLayout = this.topBar`  L356
- `RelativeLayout relativeLayout = this.topBar`  L364

方法（33）：
- `public PreviewControlView(Context context)`  L55
- `public PreviewControlView(Context context, AttributeSet attributeSet)`  L59
- `public PreviewControlView(Context context, AttributeSet attributeSet, int i)`  L63
- `void cancelHideBarTimer()`  L76
- `void initView(Context context, AttributeSet attributeSet)`  L84
- `void onClick(View view)`  L180 @Override
- `void startHideBarTimer()`  L193
- `void run()`  L199 @Override
- `void run()`  L202 @Override
- `void updateFullScreenButtonForState(ImageView imageView, boolean z)`  L212
- `int getBottomBarVisibility()`  L223
- `int getTopBarVisibility()`  L231
- `void setAlwaysHideBar(boolean z)`  L239
- `void setAlwaysHideTopBar(boolean z)`  L247
- `void setAutoHideBar(boolean z)`  L254
- `void setBackIcon(int i)`  L258
- `void setBottomBarBackground(int i)`  L266
- `void setBottomBarVisibility(int i)`  L274
- `void setButtomBarHeight(int i)`  L285
- `void setFullScreenImgbtnVisibility(int i)`  L295
- `void setFullScreenModeChangedListener(OnFullScreenModeChangedListener onFullScreenModeChangedListener)`  L302
- `void setFullScreenStatus(boolean z)`  L306
- `void setFullscreenEnterIcon(int i)`  L310
- `void setFullscreenExitIcon(int i)`  L317
- `void setPerviewSizeList(List<String> list)`  L324
- `void setPreviewSizeChangedListener(PreviewSizeChangedListener previewSizeChangedListener)`  L328
- `void setSizeBtnVisibility(int i)`  L332
- `void setTitle(String str)`  L339
- `void setTitleColor(int i)`  L347
- `void setTopBarBackground(int i)`  L355
- `void setTopBarHeight(int i)`  L363
- `void setTopBarVisibility(int i)`  L373
- `void showOrHideTopBar(boolean z)`  L384
### `com.tinyai.libmediacomponent.components.media.PreviewControlView$OnFullScreenModeChangedListener`
L43 · [interface] public OnFullScreenModeChangedListener · `com/tinyai/libmediacomponent/components/media/PreviewControlView.java`

方法（1）：
- `void onFullScreenModeChanged(boolean z)`  L44
### `com.tinyai.libmediacomponent.components.media.PreviewControlView$PreviewSizeChangedListener`
L47 · [interface] public PreviewSizeChangedListener · `com/tinyai/libmediacomponent/components/media/PreviewControlView.java`

方法（1）：
- `void onPreviewSizeChanged(int i, String str)`  L48
### `com.tinyai.libmediacomponent.components.media.PreviewControlView$VisibilityListener`
L51 · [interface] public VisibilityListener · `com/tinyai/libmediacomponent/components/media/PreviewControlView.java`

方法（1）：
- `void onVisibilityChange(int i)`  L52
### `com.tinyai.libmediacomponent.components.media.PreviewPlayerView`
L20 · [class] public PreviewPlayerView · extends `FrameLayout` · `com/tinyai/libmediacomponent/components/media/PreviewPlayerView.java`

字段/常量（37）：
- `String TAG`  L21
- `boolean alwaysHideBars`  L22
- `PreviewControlView controller`  L23
- `boolean hideBars`  L24
- `Timer hideControlBarTimer`  L25
- `MediaStreamPlayer mediaStreamPlayer`  L26
- `boolean needToHideBars`  L27
- `RelativeLayout previewLayout`  L28
- `MPreviewView previewView`  L29
- `int renderType`  L30
- `Timer timer = this.hideControlBarTimer`  L52
- `int i = R.layout.preview_player_view`  L60
- `int i2 = this.renderType`  L75
- `MPreviewView mPreviewView = this.previewView`  L130
- `PreviewControlView previewControlView = this.controller`  L137
- `PreviewControlView previewControlView = this.controller`  L151
- `PreviewControlView previewControlView = this.controller`  L158
- `PreviewControlView previewControlView = this.controller`  L165
- `PreviewControlView previewControlView = this.controller`  L172
- `PreviewControlView previewControlView = this.controller`  L179
- `PreviewControlView previewControlView = this.controller`  L186
- `MPreviewView mPreviewView = this.previewView`  L193
- `PreviewControlView previewControlView = this.controller`  L200
- `PreviewControlView previewControlView = this.controller`  L207
- `PreviewControlView previewControlView = this.controller`  L214
- `PreviewControlView previewControlView = this.controller`  L221
- `PreviewControlView previewControlView = this.controller`  L228
- `PreviewControlView previewControlView = this.controller`  L235
- `PreviewControlView previewControlView = this.controller`  L242
- `MPreviewView mPreviewView = this.previewView`  L249
- `PreviewControlView previewControlView = this.controller`  L256
- `MPreviewView mPreviewView = this.previewView`  L268
- `PreviewControlView previewControlView = this.controller`  L275
- `PreviewControlView previewControlView = this.controller`  L282
- `PreviewControlView previewControlView = this.controller`  L289
- `PreviewControlView previewControlView = this.controller`  L296
- `PreviewControlView previewControlView = this.controller`  L303

方法（38）：
- `public PreviewPlayerView(Context context)`  L32
- `public PreviewPlayerView(Context context, AttributeSet attributeSet)`  L36
- `public PreviewPlayerView(Context context, AttributeSet attributeSet, int i)`  L40
    - 体内字面量："PreviewPlayerView"
- `void cancelHideControlBarTimer()`  L51
- `void initView(Context context, AttributeSet attributeSet)`  L59
- `void onClick(View view)`  L94 @Override
    - 体内字面量："PreviewPlayerView" · "previewLayout onClick "
- `void postDelayedRunnable(Runnable runnable, long j)`  L103
- `void setHideControlBarTimer()`  L109
- `void run()`  L116 @Override
- `void run()`  L119 @Override
- `void enableZoom(boolean z)`  L129
- `void setAlwaysHideBar(boolean z)`  L136
- `void setAlwaysHideBars(boolean z)`  L143
- `void setAlwaysHideTopBar(boolean z)`  L150
- `void setAutoHideBar(boolean z)`  L157
- `void setBackIcon(int i)`  L164
- `void setButtomBarBackground(int i)`  L171
- `void setButtomBarHeight(int i)`  L178
- `void setButtomBarVisibility(int i)`  L185
- `void setContainerBackground(int i)`  L192
- `void setFullScreenImgbtnVisibility(int i)`  L199
- `void setFullScreenModeChangedListener(PreviewControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener)`  L206
- `void setFullScreenStatus(boolean z)`  L213
- `void setFullscreenEnterIcon(int i)`  L220
- `void setFullscreenExitIcon(int i)`  L227
- `void setPerviewSizeList(List<String> list)`  L234
- `void setPreviewSizeChangedListener(PreviewControlView.PreviewSizeChangedListener previewSizeChangedListener)`  L241
- `void setRenderType(int i)`  L248
- `void setSizeBtnVisibility(int i)`  L255
- `void setStream(MediaStreamPlayer mediaStreamPlayer)`  L262
- `void setSurfaceType(int i)`  L267
- `void setTitle(String str)`  L274
- `void setTitleColor(int i)`  L281
- `void setTopBarBackground(int i)`  L288
- `void setTopBarHeight(int i)`  L295
- `void setTopBarVisibility(int i)`  L302
- `void startPreview()`  L309
- `void stopPreview()`  L315
### `com.tinyai.libmediacomponent.components.media.type.PreviewRenderType`
L4 · [class] public PreviewRenderType · `com/tinyai/libmediacomponent/components/media/type/PreviewRenderType.java`

字段/常量（3）：
- `int APP_RENDER = 1`  L5
- `int EXTERNAL_RENDER = 2`  L6
- `int SDK_RENDER = 0`  L7
### `com.tinyai.libmediacomponent.components.media.type.TouchMode`
L4 · [enum] public TouchMode · `com/tinyai/libmediacomponent/components/media/type/TouchMode.java`

枚举常量（3）：
- `MOVE()`  L5
- `DRAG()`  L6
- `NONE()`  L7
### `com.tinyai.libmediacomponent.components.media.type.VideoPbMode`
L4 · [enum] public VideoPbMode · `com/tinyai/libmediacomponent/components/media/type/VideoPbMode.java`

枚举常量（2）：
- `MODE_VIDEO_PLAY()`  L5
- `MODE_VIDEO_IDLE()`  L6
### `com.tinyai.libmediacomponent.components.media.VideoControlView`
L36 · [class] public VideoControlView · extends `FrameLayout implements IVideoControlView` · implements `IVideoControlView` · `com/tinyai/libmediacomponent/components/media/VideoControlView.java`

字段/常量（123）：
- `int CACHE_LOADED = 2`  L37
- `int CACHE_LOADING = 1`  L38
- `int DEFAULT_SHOW_TIMEOUT_MS = 5000`  L39
- `int ENLARGE_RATE = 100`  L40
- `int MAX_UPDATE_INTERVAL_MS = 1000`  L41
- `String TAG = "VideoControlView"`  L42
- `boolean alwaysHideBars`  L43
- `boolean alwaysHideTopBars`  L44
- `boolean autoHideBar`  L45
- `ImageView back`  L46
- `LinearLayout bottomBar`  L47
- `boolean cacheFlag`  L48
- `Context context`  L49
- `double currentTime`  L50
- `ImageView delete`  L51
- `ImageView download`  L52
- `String fileName`  L53
- `int fullScreenEnterResId`  L54
- `int fullScreenExitResId`  L55
- `ImageButton fullScreenImgbtn`  L56
- `OnFullScreenModeChangedListener fullScreenModeChangedListener`  L57
- `VideoPbHandler handler`  L58
- `Timer hideBarTimer`  L59
- `boolean isFullScreen`  L60
- `int lastSeekBarPosition`  L61
- `MPreviewView mPreviewView`  L62
- `MediaStreamPlayer mediaStreamPlayer`  L63
- `ImageView moreBtn`  L64
- `boolean needUpdateSeekBar`  L65
- `OnControlBarClickListener onControlBarClickListener`  L66
- `int pauseBtnImgRes`  L67
- `ImageButton play`  L68
- `int playBtnImgRes`  L69
- `ImageView playCircleImv`  L70
- `MProgressWheel progressWheel`  L71
- `SeekBar seekBar`  L72
- `TextView spaceTxv`  L73
- `ImageButton stop`  L74
- `TextView timeDurationTxv`  L75
- `TextView timeLapsedTxv`  L76
- `LinearLayout topBar`  L77
- `int videoDuration`  L78
- `TextView videoNameTxv`  L79
- `VideoPbMode videoPbMode`  L80
- `PreviewControlView.VisibilityListener visibilityListener`  L81
- `Boolean waitForCaching`  L82
- `Timer timer = this.hideBarTimer`  L192
- `int i`  L200
- `int i2`  L201
- `int i3`  L202
- `int i4`  L203
- `int i5`  L204
- `int i6`  L205
- `int i7`  L206
- `int i8`  L207
- `int i9`  L208
- `int i10`  L209
- `int i11`  L210
- `int i12`  L211
- `int i13`  L212
- `int i14`  L213
- `int i15`  L214
- `int i16`  L215
- `int i17`  L216
- `int i18`  L217
- `int i19`  L218
- `int i20`  L219
- `int i21`  L220
- `int i22`  L221
- `int i23 = R.layout.video_control_view`  L223
- `int i44 = i20`  L348
- `int i45 = i19`  L352
- `int i46 = i18`  L356
- `int i47 = i17`  L360
- `int i48 = i16`  L364
- `int i49 = i15`  L368
- `ImageButton imageButton = this.play`  L375
- `ImageView imageView = this.playCircleImv`  L384
- `ImageView imageView2 = this.download`  L393
- `ImageView imageView3 = this.delete`  L404
- `ImageView imageView4 = this.moreBtn`  L415
- `ImageView imageView5 = this.back`  L426
- `ImageButton imageButton2 = this.fullScreenImgbtn`  L437
- `VideoControlView videoControlView = VideoControlView.this`  L442
- `VideoControlView videoControlView2 = VideoControlView.this`  L444
- `SeekBar seekBar = this.seekBar`  L452
- `MediaStreamPlayer mediaStreamPlayer = this.mediaStreamPlayer`  L511
- `LinearLayout linearLayout = this.bottomBar`  L577
- `SeekBar seekBar = this.seekBar`  L586
- `LinearLayout linearLayout = this.topBar`  L595
- `ImageView imageView = this.back`  L676
- `LinearLayout linearLayout = this.bottomBar`  L684
- `LinearLayout linearLayout = this.bottomBar`  L705
- `ImageView imageView = this.playCircleImv`  L716
- `ImageView imageView = this.delete`  L724
- `ImageView imageView = this.delete`  L732
- `ImageView imageView = this.download`  L740
- `ImageView imageView = this.download`  L748
- `ImageButton imageButton = this.fullScreenImgbtn`  L756
- `MProgressWheel mProgressWheel = this.progressWheel`  L789
- `ImageView imageView = this.moreBtn`  L801
- `ImageView imageView = this.moreBtn`  L809
- `ImageButton imageButton = this.play`  L826
- `ImageView imageView = this.playCircleImv`  L835
- `SeekBar seekBar = this.seekBar`  L862
- `SeekBar seekBar = this.seekBar`  L871
- `SeekBar seekBar = this.seekBar`  L880
- `SeekBar seekBar = this.seekBar`  L889
- `TextView textView = this.spaceTxv`  L898
- `TextView textView = this.timeDurationTxv`  L912
- `TextView textView2 = this.timeLapsedTxv`  L916
- `TextView textView = this.timeDurationTxv`  L925
- `TextView textView = this.timeDurationTxv`  L934
- `TextView textView = this.timeLapsedTxv`  L943
- `TextView textView = this.timeLapsedTxv`  L952
- `TextView textView = this.videoNameTxv`  L961
- `TextView textView = this.videoNameTxv`  L970
- `LinearLayout linearLayout = this.topBar`  L979
- `LinearLayout linearLayout = this.topBar`  L988
- `TextView textView = this.videoNameTxv`  L1011
- `MProgressWheel mProgressWheel = this.progressWheel`  L1032
- `MPreviewView mPreviewView = this.mPreviewView`  L1068
- `MPreviewView mPreviewView = this.mPreviewView`  L1105

方法（92）：
- `public VideoControlView(Context context)`  L159
- `public VideoControlView(Context context, AttributeSet attributeSet)`  L163
- `public VideoControlView(Context context, AttributeSet attributeSet, int i)`  L167
- `void cancelHideBarTimer()`  L191
- `void initView(Context context, AttributeSet attributeSet)`  L199
- `void onClick(View view)`  L379 @Override
- `void onClick(View view)`  L388 @Override
- `void onClick(View view)`  L397 @Override
- `void onClick(View view)`  L408 @Override
- `void onClick(View view)`  L419 @Override
- `void onClick(View view)`  L430 @Override
- `void onClick(View view)`  L441 @Override
- `void onProgressChanged(SeekBar seekBar2, int i50, boolean z)`  L456 @Override
- `void onStartTrackingTouch(SeekBar seekBar2)`  L461 @Override
- `void onStopTrackingTouch(SeekBar seekBar2)`  L466 @Override
- `void pauseVideoPb()`  L473
    - 体内字面量："begin pause the playing" · "failed to pausePlayback"
- `void playOnClick()`  L485
- `void release()`  L495
- `void resumeVideoPb()`  L498
    - 体内字面量："mode == MODE_VIDEO_PAUSE" · "failed to resumePlayback"
- `void setPlayerEventListener()`  L510
- `void onBufferingProgressChanged(int i, int i2)`  L515 @Override
- `void onLoadingChanged(int i)`  L520 @Override
- `void onPlayProgressChanged(double d)`  L525 @Override
- `void onPlaybackError(String str)`  L530 @Override
- `void onPlaybackStateChanged(PlayState playState)`  L534 @Override
- `void startHideBarTimer()`  L543
- `void run()`  L549 @Override
- `void run()`  L552 @Override
- `void updateFullScreenButtonForState(ImageView imageView, boolean z)`  L564
- `int getBottomBarVisibility()`  L576 @Override
- `int getSeekBarProgress()`  L585 @Override
- `int getTopBarVisibility()`  L594 @Override
- `void initUI()`  L602
    - 体内字面量："getDuration :"
- `boolean isFullScreen()`  L615
- `void resetUI()`  L619
- `void seekToCurrentPosition()`  L631
- `void setAlwaysHideBar(boolean z)`  L648
- `void setAlwaysHideBars(boolean z)`  L656
- `void setAlwaysHideTopBars(boolean z)`  L663
- `void setAutoHideBar(boolean z)`  L670
- `void setBackIcon(int i)`  L675 @Override
- `void setBottomBarBackground(int i)`  L683 @Override
- `void setBottomBarVisibility(int i)`  L692 @Override
- `void setButtomBarHeight(int i)`  L704 @Override
- `void setCircePlayIcon(int i)`  L715 @Override
- `void setDeleteBtnVisibility(int i)`  L723 @Override
- `void setDeleteIcon(int i)`  L731 @Override
- `void setDownloadBtnVisibility(int i)`  L739 @Override
- `void setDownloadIcon(int i)`  L747 @Override
- `void setFullScreenImgbtnVisibility(int i)`  L755 @Override
- `void setFullScreenModeChangedListener(OnFullScreenModeChangedListener onFullScreenModeChangedListener)`  L762
- `void setFullScreenStatus(boolean z)`  L766
- `void setFullscreenEnterIcon(int i)`  L772 @Override
- `void setFullscreenExitIcon(int i)`  L780 @Override
- `void setLoadPercent(int i)`  L788 @Override
- `void setMoreBtnVisibility(int i)`  L800 @Override
- `void setMoreIcon(int i)`  L808 @Override
- `void setOnControlBarClickListener(OnControlBarClickListener onControlBarClickListener)`  L815
- `void setPauseIcon(int i)`  L820 @Override
- `void setPlayBtnBackground(int i)`  L825 @Override
- `void setPlayCircleImageViewVisibility(int i)`  L834 @Override
- `void setPlayIcon(int i)`  L843 @Override
- `void setRenderView(MPreviewView mPreviewView)`  L847
- `void onFramePtsChanged(double d)`  L851 @Override
- `void setSeekBarMaxValue(int i)`  L861 @Override
- `void setSeekBarProgress(int i)`  L870 @Override
- `void setSeekBarSecondProgress(int i)`  L879 @Override
- `void setSeekbarProgressDrawable(int i)`  L888 @Override
- `void setSpaceTxvColor(int i)`  L897 @Override
- `void setStream(MediaStreamPlayer mediaStreamPlayer)`  L905
- `void setTimeColor(int i)`  L911 @Override
- `void setTimeDurationTxvColor(int i)`  L924 @Override
- `void setTimeDurationValue(String str)`  L933 @Override
- `void setTimeLapsedTxvColor(int i)`  L942 @Override
- `void setTimeLapsedValue(String str)`  L951 @Override
- `void setTitle(String str)`  L960 @Override
- `void setTitleColor(int i)`  L969 @Override
- `void setTopBarBackground(int i)`  L978 @Override
- `void setTopBarHeight(int i)`  L987 @Override
- `void setTopBarVisibility(int i)`  L998 @Override
- `void setVideoNameTxvColor(int i)`  L1010 @Override
- `void showDetailBar(boolean z)`  L1018
- `void showLoadingCircle(boolean z)`  L1031 @Override
- `void showOrHideTopBar(boolean z)`  L1046
- `void startVideoPb()`  L1067
- `void onStreamingError(int i)`  L1072 @Override
- `void run()`  L1075 @Override
- `void onStreamingSuccess()`  L1081 @Override
- `void run()`  L1084 @Override
- `void stopVideoPb()`  L1098
    - 体内字面量："setProgress = 0"
- `void updateLapseTime(int i)`  L1115
- `void updateLastSeekPosition()`  L1119
### `com.tinyai.libmediacomponent.components.media.VideoControlView$OnControlBarClickListener`
L84 · [interface] public OnControlBarClickListener · `com/tinyai/libmediacomponent/components/media/VideoControlView.java`

方法（4）：
- `void onBackClick()`  L85
- `void onDeleteClick()`  L87
- `void onDownloadClick()`  L89
- `void onMoreClick()`  L91
### `com.tinyai.libmediacomponent.components.media.VideoControlView$OnFullScreenModeChangedListener`
L94 · [interface] public OnFullScreenModeChangedListener · `com/tinyai/libmediacomponent/components/media/VideoControlView.java`

方法（1）：
- `void onFullScreenModeChanged(boolean z)`  L95
### `com.tinyai.libmediacomponent.components.media.VideoControlView$VideoPbHandler`
L98 · [class] private VideoPbHandler · extends `Handler` · `com/tinyai/libmediacomponent/components/media/VideoControlView.java`

字段/常量（1）：
- `int i = message.what`  L104

方法（2）：
- `private VideoPbHandler()`  L99
- `void handleMessage(Message message)`  L103 @Override
### `com.tinyai.libmediacomponent.components.media.VideoControlView$VisibilityListener`
L155 · [interface] public VisibilityListener · `com/tinyai/libmediacomponent/components/media/VideoControlView.java`

方法（1）：
- `void onVisibilityChange(int i)`  L156
### `com.tinyai.libmediacomponent.components.media.VideoPlayerView`
L19 · [class] public VideoPlayerView · extends `FrameLayout` · `com/tinyai/libmediacomponent/components/media/VideoPlayerView.java`

字段/常量（48）：
- `String TAG`  L20
- `boolean alwaysHideBars`  L21
- `VideoControlView controller`  L22
- `boolean hideBars`  L23
- `Timer hideControlBarTimer`  L24
- `MediaStreamPlayer mediaStreamPlayer`  L25
- `boolean needToHideBars`  L26
- `MPreviewView previewView`  L27
- `RelativeLayout previreViewLayout`  L28
- `int renderType`  L29
- `Timer timer = this.hideControlBarTimer`  L51
- `int i = R.layout.video_player_view`  L59
- `MPreviewView mPreviewView = this.previewView`  L128
- `VideoControlView videoControlView = this.controller`  L135
- `VideoControlView videoControlView = this.controller`  L143
- `VideoControlView videoControlView = this.controller`  L151
- `VideoControlView videoControlView = this.controller`  L158
- `VideoControlView videoControlView = this.controller`  L165
- `VideoControlView videoControlView = this.controller`  L172
- `VideoControlView videoControlView = this.controller`  L179
- `VideoControlView videoControlView = this.controller`  L186
- `VideoControlView videoControlView = this.controller`  L193
- `VideoControlView videoControlView = this.controller`  L200
- `MPreviewView mPreviewView = this.previewView`  L207
- `VideoControlView videoControlView = this.controller`  L214
- `VideoControlView videoControlView = this.controller`  L221
- `VideoControlView videoControlView = this.controller`  L228
- `VideoControlView videoControlView = this.controller`  L235
- `VideoControlView videoControlView = this.controller`  L242
- `VideoControlView videoControlView = this.controller`  L249
- `VideoControlView videoControlView = this.controller`  L256
- `VideoControlView videoControlView = this.controller`  L263
- `VideoControlView videoControlView = this.controller`  L270
- `VideoControlView videoControlView = this.controller`  L277
- `VideoControlView videoControlView = this.controller`  L284
- `VideoControlView videoControlView = this.controller`  L291
- `MPreviewView mPreviewView = this.previewView`  L298
- `VideoControlView videoControlView = this.controller`  L305
- `VideoControlView videoControlView = this.controller`  L314
- `MPreviewView mPreviewView = this.previewView`  L321
- `VideoControlView videoControlView = this.controller`  L328
- `VideoControlView videoControlView = this.controller`  L335
- `VideoControlView videoControlView = this.controller`  L342
- `VideoControlView videoControlView = this.controller`  L349
- `VideoControlView videoControlView = this.controller`  L356
- `VideoControlView videoControlView = this.controller`  L363
- `VideoControlView videoControlView = this.controller`  L370
- `VideoControlView videoControlView = this.controller`  L378

方法（46）：
- `public VideoPlayerView(Context context)`  L31
- `public VideoPlayerView(Context context, AttributeSet attributeSet)`  L35
- `public VideoPlayerView(Context context, AttributeSet attributeSet, int i)`  L39
    - 体内字面量："PreviewPlayerView"
- `void cancelHideControlBarTimer()`  L50
- `void initView(Context context, AttributeSet attributeSet)`  L58
- `void onClick(View view)`  L92 @Override
    - 体内字面量："PreviewPlayerView" · "VideoPlayerview onClick "
- `void postDelayedRunnable(Runnable runnable, long j)`  L101
- `void setHideControlBarTimer()`  L107
- `void run()`  L114 @Override
- `void run()`  L117 @Override
- `void enableZoom(boolean z)`  L127
- `boolean isFullScreen()`  L134
- `void setAlwaysHideBar(boolean z)`  L142
- `void setAlwaysHideBars(boolean z)`  L149
- `void setAlwaysHideTopBars(boolean z)`  L157
- `void setAutoHideBar(boolean z)`  L164
- `void setBackIcon(int i)`  L171
- `void setButtomBarBackground(int i)`  L178
- `void setButtomBarHeight(int i)`  L185
- `void setButtomBarVisibility(int i)`  L192
- `void setCircePlayIcon(int i)`  L199
- `void setContainerBackground(int i)`  L206
- `void setControlBarClickListener(VideoControlView.OnControlBarClickListener onControlBarClickListener)`  L213
- `void setDeleteBtnVisibility(int i)`  L220
- `void setDeleteIcon(int i)`  L227
- `void setDownloadBtnVisibility(int i)`  L234
- `void setDownloadIcon(int i)`  L241
- `void setFullScreenImgbtnVisibility(int i)`  L248
- `void setFullScreenModeChangedListener(VideoControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener)`  L255
- `void setFullScreenStatus(boolean z)`  L262
- `void setFullscreenEnterIcon(int i)`  L269
- `void setFullscreenExitIcon(int i)`  L276
- `void setPauseIcon(int i)`  L283
- `void setPlayIcon(int i)`  L290
- `void setRenderType(int i)`  L297
- `void setSeekbarProgressDrawable(int i)`  L304
- `void setStream(MediaStreamPlayer mediaStreamPlayer)`  L311
- `void setSurfaceType(int i)`  L320
- `void setTimeColor(int i)`  L327
- `void setTitle(String str)`  L334
- `void setTitleColor(int i)`  L341
- `void setTopBarBackground(int i)`  L348
- `void setTopBarHeight(int i)`  L355
- `void setTopBarVisibility(int i)`  L362
- `void startPreview()`  L369
- `void stopPreview()`  L377
### `com.tinyai.libmediacomponent.components.setting.Category`
L7 · [class] public Category · `com/tinyai/libmediacomponent/components/setting/Category.java`

字段/常量（1）：
- `String mCategoryName`  L9

方法（5）：
- `public Category(String str)`  L11
- `void addItem(String str)`  L15
- `String getItem(int i)`  L19
- `int getItemCount()`  L23
- `String getmCategoryName()`  L27
### `com.tinyai.libmediacomponent.components.setting.CategoryAdapter`
L15 · [class] public CategoryAdapter · extends `BaseAdapter` · `com/tinyai/libmediacomponent/components/setting/CategoryAdapter.java`

字段/常量（10）：
- `int TYPE_CATEGORY_ITEM = 0`  L16
- `int TYPE_ITEM = 1`  L17
- `LayoutInflater mInflater`  L18
- `ArrayList<Category> mListData`  L19
- `ArrayList<Category> arrayList = this.mListData`  L41
- `int itemCount = 0`  L42
- `int i2 = 0`  L55
- `int i3 = i - i2`  L58
- `int i2 = 0`  L77
- `ViewHolder viewHolder`  L91

方法（9）：
- `public CategoryAdapter(Context context, ArrayList<Category> arrayList)`  L29
- `boolean areAllItemsEnabled()`  L35 @Override
- `int getCount()`  L40 @Override
- `Object getItem(int i)`  L53 @Override
- `long getItemId(int i)`  L69 @Override
- `int getItemViewType(int i)`  L74 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L90 @Override
- `int getViewTypeCount()`  L115 @Override
- `boolean isEnabled(int i)`  L120 @Override
### `com.tinyai.libmediacomponent.components.setting.CategoryAdapter$ViewHolder`
L21 · [class] private ViewHolder · `com/tinyai/libmediacomponent/components/setting/CategoryAdapter.java`

字段/常量（2）：
- `TextView content`  L22
- `ImageView contentIcon`  L23

方法（1）：
- `private ViewHolder()`  L25
### `com.tinyai.libmediacomponent.components.setting.CommonItemLayout`
L15 · [class] public CommonItemLayout · extends `LinearLayout` · `com/tinyai/libmediacomponent/components/setting/CommonItemLayout.java`

字段/常量（29）：
- `String TAG = "CommonItemLayout"`  L16
- `CommonItemView.OnArrowClickListener arrowClickListener`  L17
- `AttributeSet attrs`  L18
- `Context context`  L19
- `CommonItemView.OnItemClickListener itemClickListener`  L20
- `int itemIconRes`  L21
- `int layoutId`  L22
- `ListView listView`  L23
- `SettingAdapter settingAdapter`  L24
- `SettingItemProperty settingItemProperty`  L25
- `CommonItemView.OnSwitchChangedListener switchChangedListener`  L26
- `CommonItemView.OnItemClickListener onItemClickListener = this.itemClickListener`  L79
- `CommonItemView.OnArrowClickListener onArrowClickListener = this.arrowClickListener`  L83
- `CommonItemView.OnSwitchChangedListener onSwitchChangedListener = this.switchChangedListener`  L87
- `SettingAdapter settingAdapter = this.settingAdapter`  L95
- `SettingAdapter settingAdapter = this.settingAdapter`  L103
- `SettingAdapter settingAdapter = this.settingAdapter`  L111
- `SettingAdapter settingAdapter = this.settingAdapter`  L119
- `SettingAdapter settingAdapter = this.settingAdapter`  L127
- `SettingAdapter settingAdapter = this.settingAdapter`  L135
- `SettingAdapter settingAdapter = this.settingAdapter`  L143
- `SettingAdapter settingAdapter = this.settingAdapter`  L151
- `SettingAdapter settingAdapter = this.settingAdapter`  L159
- `SettingAdapter settingAdapter = this.settingAdapter`  L167
- `SettingAdapter settingAdapter = this.settingAdapter`  L175
- `SettingAdapter settingAdapter = this.settingAdapter`  L183
- `SettingAdapter settingAdapter = this.settingAdapter`  L191
- `SettingAdapter settingAdapter = this.settingAdapter`  L199
- `SettingAdapter settingAdapter = this.settingAdapter`  L207

方法（20）：
- `public CommonItemLayout(Context context)`  L28
- `public CommonItemLayout(Context context, AttributeSet attributeSet)`  L32
- `public CommonItemLayout(Context context, AttributeSet attributeSet, int i)`  L36
- `void initView(Context context, AttributeSet attributeSet)`  L44
    - 体内字面量：" titleColorResId:"
- `void loadView(List<SettingGroup> list)`  L76
- `void refresh()`  L94
- `void setDividerColor(int i)`  L101
- `void setDividerHigiht(int i)`  L109
- `void setIconPadding(int i)`  L117
- `void setIconSize(int i)`  L125
- `void setItemPaddingLeftRight(int i)`  L133
- `void setItemPaddingTopBottom(int i)`  L141
- `void setOnArrowClickListener(CommonItemView.OnArrowClickListener onArrowClickListener)`  L149
- `void setOnItemClickListener(CommonItemView.OnItemClickListener onItemClickListener)`  L157
- `void setOnSwitchChangedListener(CommonItemView.OnSwitchChangedListener onSwitchChangedListener)`  L165
- `void setRightSwitchColor(int i)`  L173
- `void setRightTextColor(int i)`  L181
- `void setRightTextSize(int i)`  L189
- `void setTitleColor(int i)`  L197
- `void setTitleSize(int i)`  L205
### `com.tinyai.libmediacomponent.components.setting.CommonItemView`
L16 · [class] public CommonItemView · extends `LinearLayout` · `com/tinyai/libmediacomponent/components/setting/CommonItemView.java`

字段/常量（42）：
- `Context context`  L17
- `View dividerBotttomView`  L18
- `View dividerTopView`  L19
- `int itemIconRes`  L20
- `int layoutId`  L21
- `ImageView leftIconImv`  L22
- `OnArrowClickListener onArrowClickListener`  L23
- `OnItemClickListener onItemClickListener`  L24
- `OnSwitchChangedListener onSwitchChangedListener`  L25
- `ImageView rightArrowImv`  L26
- `Switch rightSwitch`  L27
- `TextView rightValueTxv`  L28
- `LinearLayout rootLayout`  L29
- `TextView titleTxv`  L30
- `View view = this.dividerTopView`  L156
- `View view2 = this.dividerBotttomView`  L160
- `View view = this.dividerTopView`  L167
- `View view2 = this.dividerBotttomView`  L173
- `ImageView imageView`  L182
- `ImageView imageView = this.leftIconImv`  L190
- `ImageView imageView = this.leftIconImv`  L197
- `LinearLayout linearLayout = this.rootLayout`  L207
- `LinearLayout linearLayout = this.rootLayout`  L215
- `ImageView imageView = this.rightArrowImv`  L223
- `LinearLayout linearLayout = this.rootLayout`  L238
- `Switch r2 = this.rightSwitch`  L253
- `Switch r0 = this.rightSwitch`  L268
- `TextView textView`  L278
- `TextView textView = this.rightValueTxv`  L286
- `TextView textView`  L293
- `TextView textView`  L301
- `TextView textView = this.rightValueTxv`  L309
- `TextView textView = this.titleTxv`  L316
- `TextView textView = this.titleTxv`  L323
- `TextView textView`  L330
- `TextView textView`  L338
- `ImageView imageView = this.rightArrowImv`  L346
- `View view = this.dividerBotttomView`  L358
- `View view = this.dividerTopView`  L365
- `ImageView imageView = this.leftIconImv`  L372
- `Switch r0 = this.rightSwitch`  L379
- `TextView textView = this.rightValueTxv`  L386

方法（41）：
- `public CommonItemView(Context context)`  L44
- `public CommonItemView(Context context, AttributeSet attributeSet)`  L48
- `public CommonItemView(Context context, AttributeSet attributeSet, int i)`  L52
- `void initView(Context context, AttributeSet attributeSet)`  L59
- `CommonItemView init(int i, String str)`  L94
- `CommonItemView init(int i, String str, String str2, boolean z)`  L104
- `CommonItemView init(int i, String str, boolean z)`  L115
- `CommonItemView init(String str)`  L126
- `CommonItemView init(String str, String str2, boolean z)`  L135
- `CommonItemView init(String str, boolean z)`  L145
- `void setDividerColor(int i)`  L155
- `void setDividerHigiht(int i)`  L166
- `void setIcon(int i)`  L181
- `void setIconPadding(int i)`  L189
- `void setIconSize(int i)`  L196
- `void setItemPaddingLeftRight(int i)`  L206
- `void setItemPaddingTopBottom(int i)`  L214
- `void setOnArrowClickListener(OnArrowClickListener onArrowClickListener, final SettingItem settingItem)`  L221
- `void onClick(View view)`  L227 @Override
- `void setOnItemClickListener(OnItemClickListener onItemClickListener, final SettingItem settingItem)`  L236
- `void onClick(View view)`  L242 @Override
- `void setOnSwitchChangedListener(OnSwitchChangedListener onSwitchChangedListener, final SettingItem settingItem)`  L251
- `void onClick(View view)`  L257 @Override
- `void setRightSwitchChecked(boolean z)`  L267
- `void setRightSwitchColor(int i)`  L274
- `void setRightTextBackground(int i)`  L277
- `void setRightTextColor(int i)`  L285
- `void setRightTextContent(int i)`  L292
- `void setRightTextContent(String str)`  L300
- `void setRightTextSize(int i)`  L308
- `void setTitleColor(int i)`  L315
- `void setTitleSize(int i)`  L322
- `void setTitlecontent(int i)`  L329
- `void setTitlecontent(String str)`  L337
- `void showArrowRight(boolean z)`  L345
- `void showDivider(boolean z, boolean z2)`  L352
- `void showDividerBottom(boolean z)`  L357
- `void showDividerTop(boolean z)`  L364
- `void showIcon(boolean z)`  L371
- `void showRightSwitch(boolean z)`  L378
- `void showRightText(boolean z)`  L385
### `com.tinyai.libmediacomponent.components.setting.CommonItemView$OnArrowClickListener`
L32 · [interface] public OnArrowClickListener · `com/tinyai/libmediacomponent/components/setting/CommonItemView.java`

方法（1）：
- `void onArrowClick(View view, SettingItem settingItem)`  L33
### `com.tinyai.libmediacomponent.components.setting.CommonItemView$OnItemClickListener`
L36 · [interface] public OnItemClickListener · `com/tinyai/libmediacomponent/components/setting/CommonItemView.java`

方法（1）：
- `void onItemClick(View view, SettingItem settingItem)`  L37
### `com.tinyai.libmediacomponent.components.setting.CommonItemView$OnSwitchChangedListener`
L40 · [interface] public OnSwitchChangedListener · `com/tinyai/libmediacomponent/components/setting/CommonItemView.java`

方法（1）：
- `void onSwitchChanged(View view, SettingItem settingItem, boolean z)`  L41
### `com.tinyai.libmediacomponent.components.setting.CustomDialog`
L11 · [class] public CustomDialog · `com/tinyai/libmediacomponent/components/setting/CustomDialog.java`

字段/常量（6）：
- `String TAG = "CustomDialog"`  L12
- `int yourChoice`  L13
- `OnInputClickListener onInputClickListener2 = onInputClickListener`  L40
- `OnNormalDialogClickListener onNormalDialogClickListener2 = onNormalDialogClickListener`  L55
- `OnNormalDialogClickListener onNormalDialogClickListener2 = onNormalDialogClickListener`  L64
- `OnSingleChoiceClickListener onSingleChoiceClickListener2 = onSingleChoiceClickListener`  L87

方法（8）：
- `void showInputDialog(Context context, int i, String str, final OnInputClickListener onInputClickListener)`  L29
- `void onClick(DialogInterface dialogInterface, int i2)`  L38 @Override
    - 体内字面量："yourChoice :"
- `void showNormalDialog(Context context, String str, String str2, final OnNormalDialogClickListener onNormalDialogClickListener)`  L48
- `void onClick(DialogInterface dialogInterface, int i)`  L54 @Override
- `void onClick(DialogInterface dialogInterface, int i)`  L63 @Override
- `void showSingleChoiceDialog(Context context, int i, final String[] strArr, int i2, final OnSingleChoiceClickListener onSingleChoiceClickListener)`  L73
- `void onClick(DialogInterface dialogInterface, int i3)`  L79 @Override
- `void onClick(DialogInterface dialogInterface, int i3)`  L85 @Override
### `com.tinyai.libmediacomponent.components.setting.CustomDialog$OnInputClickListener`
L15 · [interface] public OnInputClickListener · `com/tinyai/libmediacomponent/components/setting/CustomDialog.java`

方法（1）：
- `void onClick(String str)`  L16
### `com.tinyai.libmediacomponent.components.setting.CustomDialog$OnNormalDialogClickListener`
L19 · [interface] public OnNormalDialogClickListener · `com/tinyai/libmediacomponent/components/setting/CustomDialog.java`

方法（2）：
- `void onCancel()`  L20
- `void onSure()`  L22
### `com.tinyai.libmediacomponent.components.setting.CustomDialog$OnSingleChoiceClickListener`
L25 · [interface] public OnSingleChoiceClickListener · `com/tinyai/libmediacomponent/components/setting/CustomDialog.java`

方法（1）：
- `void onClick(String[] strArr, int i)`  L26
### `com.tinyai.libmediacomponent.components.setting.SettingAdapter`
L15 · [class] public SettingAdapter · extends `BaseAdapter` · `com/tinyai/libmediacomponent/components/setting/SettingAdapter.java`

字段/常量（18）：
- `String TAG = "SettingAdapter"`  L16
- `int TYPE_CATEGORY_ITEM = 0`  L17
- `int TYPE_ITEM = 1`  L18
- `CommonItemView.OnArrowClickListener arrowClickListener`  L19
- `Context context`  L20
- `CommonItemView.OnItemClickListener itemClickListener`  L21
- `LayoutInflater mInflater`  L22
- `List<SettingGroup> mListData`  L23
- `SettingItemProperty settingItemProperty`  L24
- `CommonItemView.OnSwitchChangedListener switchChangedListener`  L25
- `int titleColorResId = -1`  L26
- `List<SettingGroup> list = this.mListData`  L50
- `int itemCount = 0`  L51
- `int i2 = 0`  L64
- `int i3 = i - i2`  L67
- `int i2 = 0`  L86
- `ViewHolder viewHolder`  L100
- `SettingItemProperty settingItemProperty = this.settingItemProperty`  L154

方法（12）：
- `public SettingAdapter(Context context, List<SettingGroup> list, SettingItemProperty settingItemProperty)`  L35
    - 体内字面量：" titleColorResId:"
- `boolean areAllItemsEnabled()`  L44 @Override
- `int getCount()`  L49 @Override
- `Object getItem(int i)`  L62 @Override
- `long getItemId(int i)`  L78 @Override
- `int getItemViewType(int i)`  L83 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L99 @Override
- `int getViewTypeCount()`  L196 @Override
- `boolean isEnabled(int i)`  L201 @Override
- `void setOnArrowClickListener(CommonItemView.OnArrowClickListener onArrowClickListener)`  L205
- `void setOnItemClickListener(CommonItemView.OnItemClickListener onItemClickListener)`  L209
- `void setOnSwitchChangedListener(CommonItemView.OnSwitchChangedListener onSwitchChangedListener)`  L213
### `com.tinyai.libmediacomponent.components.setting.SettingAdapter$ViewHolder`
L28 · [class] private ViewHolder · `com/tinyai/libmediacomponent/components/setting/SettingAdapter.java`

字段/常量（1）：
- `CommonItemView commonItemView`  L29

方法（1）：
- `private ViewHolder()`  L31
### `com.tinyai.libmediacomponent.components.setting.SettingGroup`
L7 · [class] public SettingGroup · `com/tinyai/libmediacomponent/components/setting/SettingGroup.java`

字段/常量（2）：
- `String groupName`  L8
- `List<SettingItem> mCategoryItem`  L9

方法（6）：
- `public SettingGroup()`  L11
- `public SettingGroup(String str)`  L16
- `void addItem(SettingItem settingItem)`  L21
- `String getGroupName()`  L25
- `Object getItem(int i)`  L29
- `int getItemCount()`  L33
### `com.tinyai.libmediacomponent.components.setting.SettingItem`
L4 · [class] public SettingItem · `com/tinyai/libmediacomponent/components/setting/SettingItem.java`

字段/常量（10）：
- `boolean checked`  L5
- `int groupId`  L6
- `String groupName`  L7
- `int itemIcon`  L8
- `SettingItemType settingItemType`  L9
- `boolean showArrow`  L10
- `boolean showDividerBottom`  L11
- `boolean showDividerTop`  L12
- `int titleResId`  L13
- `String value`  L14

方法（24）：
- `public SettingItem(int i, int i2, String str, boolean z, boolean z2, boolean z3)`  L16
- `public SettingItem(int i, int i2, boolean z, boolean z2, boolean z3)`  L28
- `public SettingItem(int i, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3)`  L39
- `public SettingItem(int i, String str, int i2, int i3, boolean z, boolean z2, boolean z3)`  L52
- `int getGroupId()`  L64
- `String getGroupName()`  L68
- `int getItemIcon()`  L72
- `SettingItemType getSettingItemType()`  L76
- `int getTitleResId()`  L80
- `String getValue()`  L84
- `boolean isChecked()`  L88
- `boolean isShowArrow()`  L92
- `boolean isShowDividerBottom()`  L96
- `boolean isShowDividerTop()`  L100
- `void setChecked(boolean z)`  L104
- `void setGroupId(int i)`  L108
- `void setGroupName(String str)`  L112
- `void setItemIcon(int i)`  L116
- `void setSettingItemType(SettingItemType settingItemType)`  L120
- `void setShowArrow(boolean z)`  L124
- `void setShowDividerBottom(boolean z)`  L128
- `void setShowDividerTop(boolean z)`  L132
- `void setTitleResId(int i)`  L136
- `void setValue(String str)`  L140
### `com.tinyai.libmediacomponent.components.setting.SettingItemProperty`
L4 · [class] public SettingItemProperty · `com/tinyai/libmediacomponent/components/setting/SettingItemProperty.java`

字段/常量（11）：
- `int itemPaddingTopBottom = -1`  L5
- `int itemPaddingLeftRight = -1`  L6
- `int iconPadding = -1`  L7
- `int iconSize = -1`  L8
- `int dividerColor = -1`  L9
- `int dividerHigiht = -1`  L10
- `int titleSize = -1`  L11
- `int titleColor = -1`  L12
- `int rightTextSize = -1`  L13
- `int rightTextColor = -1`  L14
- `int rightSwitchColor = -1`  L15

方法（22）：
- `int getDividerColor()`  L17
- `int getDividerHigiht()`  L21
- `int getIconPadding()`  L25
- `int getIconSize()`  L29
- `int getItemPaddingLeftRight()`  L33
- `int getItemPaddingTopBottom()`  L37
- `int getRightSwitchColor()`  L41
- `int getRightTextColor()`  L45
- `int getRightTextSize()`  L49
- `int getTitleColor()`  L53
- `int getTitleSize()`  L57
- `void setDividerColor(int i)`  L61
- `void setDividerHigiht(int i)`  L65
- `void setIconPadding(int i)`  L69
- `void setIconSize(int i)`  L73
- `void setItemPaddingLeftRight(int i)`  L77
- `void setItemPaddingTopBottom(int i)`  L81
- `void setRightSwitchColor(int i)`  L85
- `void setRightTextColor(int i)`  L89
- `void setRightTextSize(int i)`  L93
- `void setTitleColor(int i)`  L97
- `void setTitleSize(int i)`  L101
### `com.tinyai.libmediacomponent.components.setting.SettingItemType`
L4 · [enum] public SettingItemType · `com/tinyai/libmediacomponent/components/setting/SettingItemType.java`

枚举常量（2）：
- `SETTING_TYPE_SWITCH()`  L5
- `SETTING_TYPE_ARROW()`  L6