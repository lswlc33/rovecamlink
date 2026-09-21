# XTU GO — 类与成员明细：com.gku.amba

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 9 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.amba.AmbaCameraFileActivity`
L34 · [class] public AmbaCameraFileActivity · extends `BaseXtuGoActivity` · `com/gku/amba/AmbaCameraFileActivity.java`

字段/常量（9）：
- `String CALLBACK_CHOOSE_CLICK = "CALLBACK_CHOOSE_CLICK"`  L35
- `int PAGE_SIZE = 50`  L36
- `FragPageAdapterVpNoScroll<Integer> fragPageAdapterVpNoScroll`  L37
- `SBTHeartbeatPresenter sbtHeartbeatPresenter`  L38
- `ShimmerLayoutSimple shimmerLayoutSimple`  L39
- `TabAdapterNoScroll<Integer> tabAdapter`  L40
- `TabLayoutNoScroll tabLayoutNoScroll`  L41
- `ViewPager viewPager`  L42
- `String[] strArrSplit = new String[0]`  L124

方法（15）：
- `void onCreate(Bundle savedInstanceState)`  L45 @Override
- `void onClick(View v)`  L54 @Override
- `void onClick(View v)`  L60 @Override
    - 体内字面量："CALLBACK_CHOOSE_CLICK"
- `void bindDataToTab(TabNoScrollViewHolder holder, int position, Integer bean, boolean isSelected)`  L68 @Override
- `int getTabLayoutID(int position, Integer bean)`  L74 @Override
- `Fragment createFragment(Integer bean, int position)`  L79 @Override
- `void onDoNet(int mode)`  L91 @Override
    - 体内字面量："onDoNet"
- `void onSuccess(GetFileCountResponseBean responseBean, String json)`  L95 @Override
- `void onFail(int code)`  L105 @Override
    - 体内字面量："\n"
- `void loadList(final GetFileCountResponseBean getFileCountResponseBean, final int page_start)`  L115
    - 体内字面量："page_start count" · "page_start"
- `void onSuccess(GetFileInfoListResponseBean responseBean, String json)`  L123 @Override
- `void onInterrupted()`  L147 @Override
- `Object runThread()`  L151 @Override
- `void run_UIThread(Object result)`  L157 @Override
- `void onFail(int code)`  L170 @Override
    - 体内字面量："loadList" · "onFail" · "\n"
### `com.gku.amba.AmbaCameraPicFragment`
L36 · [class] public AmbaCameraPicFragment · extends `BaseFragment` · `com/gku/amba/AmbaCameraPicFragment.java`

字段/常量（9）：
- `String CALLBACK_DELETE_ONE = "CALLBACK_DELETE_ONE"`  L37
- `String CALLBACK_DOWNLOAD_ONE = "CALLBACK_DOWNLOAD_ONE"`  L38
- `String CALLBACK_UPDATE_LIST_PIC_POSITION = "CALLBACK_UPDATE_LIST_POSITION"`  L39
- `DialogAmbaSDMediaDelete dialogAmbaSDMediaDelete`  L40
- `DialogAmbaSDMediaDownload dialogAmbaSDMediaDownload`  L41
- `DragSelectorAdapter<FileListInfoResponseBean> dragSelectorAdapter`  L42
- `ImageViewSelector imageViewSelector`  L43
- `View layout_menu`  L44
- `TextView tv_count`  L45

方法（18）：
- `void onCreate(Bundle savedInstanceState)`  L222 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L228 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L233 @Override
- `void onDeleteOne(int position, int count_deleted)`  L237 @Override
- `void onDismiss()`  L242 @Override
- `void onSuccessOne(int position, int count_downloaded)`  L249 @Override
- `void onDismiss()`  L254 @Override
- `void callback(Object o)`  L266 @Override
- `void onCheckedChanged(ImageViewSelector iv, boolean isChecked, boolean byTouch)`  L281 @Override
- `void onClick(View v)`  L287 @Override
- `void onClick(View v)`  L294 @Override
- `void onConfirmed()`  L300 @Override
- `void onClick(View v)`  L309 @Override
    - 体内字面量："CALLBACK_CHOOSE_CLICK"
- `void callback(Object o)`  L319 @Override
    - 体内字面量："CALLBACK_UPDATE_LIST_POSITION"
- `void callback(Integer integer)`  L326 @Override
    - 体内字面量："CALLBACK_DOWNLOAD_ONE"
- `void callback(Integer integer)`  L332 @Override
    - 体内字面量："CALLBACK_DELETE_ONE"
- `void callback(Integer integer)`  L338 @Override
- `void handleOnBackPressed()`  L344 @Override
### `com.gku.amba.AmbaCameraPicFragment$AnonymousClass1`
L48 · [class] AnonymousClass1 · extends `DragSelectorAdapter<FileListInfoResponseBean>` · `com/gku/amba/AmbaCameraPicFragment.java`

字段/常量（5）：
- `int i`  L106
- `BaseViewHolder baseViewHolder = holder`  L107
- `int i2 = com.gku.module_camera.R.id.tv_download_state`  L108
- `ComponentActivity componentActivity = AmbaCameraPicFragment.this.activity`  L109
- `AmbaCameraPicFragment ambaCameraPicFragment = AmbaCameraPicFragment.this`  L211

方法（26）：
- `void bindDataToView(BaseViewHolder holder, int position, FileListInfoResponseBean bean, boolean isSelected, List payloads)`  L53 @Override
- `boolean areItemsTheSame(FileListInfoResponseBean beanOld, FileListInfoResponseBean beanNew, int oldItemPosition, int newItemPosition)`  L58 @Override
- `boolean areContentsTheSame(FileListInfoResponseBean beanOld, FileListInfoResponseBean beanNew, int oldItemPosition, int newItemPosition)`  L66 @Override
- `void onSelectCountChanged(boolean isAllSelected, int count_selected)`  L74 @Override
- `void onViewRecycled(BaseViewHolder holder)`  L80 @Override
- `void bindDataToView2(final BaseViewHolder holder, final int position, final FileListInfoResponseBean bean, boolean isSelected, List<Object> payloads)`  L86
- `void onInterrupted()`  L92 @Override
- `Boolean runThread()`  L97 @Override
- `void run_UIThread(final Boolean result)`  L102 @Override
- `void onTagEquls(Object tag)`  L105 @Override
- `void onCheckedChanged(ImageViewSelector iv, boolean isChecked, boolean byTouch)`  L124 @Override
    - 体内字面量："NOTIFY_STATE_DRAG_SELECT"
- `void downloadThumb(final Object tag, final BaseViewHolder holder, final FileListInfoResponseBean bean)`  L141
- `void onClick(View v)`  L145 @Override
- `void onProgress(FileListInfoResponseBean fileListInfoResponseBean, long current, long contentLength, int percent)`  L152 @Override
- `void onRefreshSpeed(FileListInfoResponseBean fileListInfoResponseBean, long bytesPerSecond)`  L156 @Override
- `void onStart(FileListInfoResponseBean fileListInfoResponseBean)`  L160 @Override
- `void onSuccess(final FileListInfoResponseBean fileListInfoResponseBean, final String pathSaved)`  L164 @Override
- `void onTagEquls(Object tag2)`  L167 @Override
- `void onFail(FileListInfoResponseBean fileListInfoResponseBean, final int code)`  L174 @Override
- `void onTagEquls(Object tag2)`  L177 @Override
    - 体内字面量：":" · "\n"
- `void onItemLongClick__(BaseViewHolder holder, final int position, FileListInfoResponseBean bean)`  L187 @Override
- `void onDeleteClick(final FileListInfoResponseBean fileListInfoResponseBean)`  L190 @Override
- `void onConfirmed()`  L193 @Override
- `void onDownloadClick(FileListInfoResponseBean fileListInfoResponseBean)`  L200 @Override
- `void onItemClick__(BaseViewHolder holder, int position, FileListInfoResponseBean bean)`  L207 @Override
    - 体内字面量："KEY_POSITION" · "KEY_LIST"
- `int getItemLayoutID(int position, FileListInfoResponseBean bean)`  L216 @Override
### `com.gku.amba.AmbaCameraRecordFragment`
L46 · [class] public AmbaCameraRecordFragment · extends `BaseFragment` · `com/gku/amba/AmbaCameraRecordFragment.java`

字段/常量（6）：
- `DialogAmbaSDMediaDelete dialogAmbaSDMediaDelete`  L47
- `DialogAmbaSDMediaDownload dialogAmbaSDMediaDownload`  L48
- `DragSelectorAdapter<FileListInfoResponseBean> dragSelectorAdapter`  L49
- `ImageViewSelector imageViewSelector`  L50
- `View layout_menu`  L51
- `TextView tv_count`  L52

方法（15）：
- `void onCreate(Bundle savedInstanceState)`  L245 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L251 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L256 @Override
- `void onDeleteOne(int position, int count_deleted)`  L260 @Override
- `void onDismiss()`  L265 @Override
- `void onSuccessOne(int position, int count_downloaded)`  L272 @Override
- `void onDismiss()`  L277 @Override
- `void callback(Object o)`  L289 @Override
- `void onCheckedChanged(ImageViewSelector iv, boolean isChecked, boolean byTouch)`  L304 @Override
- `void onClick(View v)`  L310 @Override
- `void onClick(View v)`  L317 @Override
- `void onConfirmed()`  L323 @Override
- `void onClick(View v)`  L332 @Override
    - 体内字面量："CALLBACK_CHOOSE_CLICK"
- `void callback(Object o)`  L342 @Override
- `void handleOnBackPressed()`  L349 @Override
### `com.gku.amba.AmbaCameraRecordFragment$AnonymousClass1`
L55 · [class] AnonymousClass1 · extends `DragSelectorAdapter<FileListInfoResponseBean>` · `com/gku/amba/AmbaCameraRecordFragment.java`

字段/常量（5）：
- `int i`  L114
- `BaseViewHolder baseViewHolder = holder`  L115
- `int i2 = com.gku.module_camera.R.id.tv_download_state`  L116
- `ComponentActivity componentActivity = AmbaCameraRecordFragment.this.activity`  L117
- `String playPath`  L227

方法（27）：
- `void bindDataToView(BaseViewHolder holder, int position, FileListInfoResponseBean bean, boolean isSelected, List payloads)`  L60 @Override
- `boolean areItemsTheSame(FileListInfoResponseBean beanOld, FileListInfoResponseBean beanNew, int oldItemPosition, int newItemPosition)`  L65 @Override
- `boolean areContentsTheSame(FileListInfoResponseBean beanOld, FileListInfoResponseBean beanNew, int oldItemPosition, int newItemPosition)`  L73 @Override
- `void onSelectCountChanged(boolean isAllSelected, int count_selected)`  L81 @Override
- `void onViewRecycled(BaseViewHolder holder)`  L87 @Override
- `void bindDataToView2(final BaseViewHolder holder, final int position, final FileListInfoResponseBean bean, boolean isSelected, List<Object> payloads)`  L93
- `void onInterrupted()`  L100 @Override
- `Boolean runThread()`  L105 @Override
- `void run_UIThread(final Boolean result)`  L110 @Override
- `void onTagEquls(Object tag)`  L113 @Override
- `void onCheckedChanged(ImageViewSelector iv, boolean isChecked, boolean byTouch)`  L132 @Override
    - 体内字面量："NOTIFY_STATE_DRAG_SELECT"
- `void downloadThumb(final Object tag, final BaseViewHolder holder, final FileListInfoResponseBean bean)`  L149
- `void onClick(View v)`  L153 @Override
- `void onProgress(FileListInfoResponseBean fileListInfoResponseBean, long current, long contentLength, int percent)`  L160 @Override
- `void onRefreshSpeed(FileListInfoResponseBean fileListInfoResponseBean, long bytesPerSecond)`  L164 @Override
- `void onStart(FileListInfoResponseBean fileListInfoResponseBean)`  L168 @Override
- `void onSuccess(FileListInfoResponseBean fileListInfoResponseBean, final String pathSaved)`  L172 @Override
- `void onTagEquls(Object tag2)`  L175 @Override
- `void onFail(FileListInfoResponseBean fileListInfoResponseBean, final int code)`  L182 @Override
- `void onTagEquls(Object tag2)`  L185 @Override
    - 体内字面量：":" · "\n"
- `void onItemLongClick__(BaseViewHolder holder, final int position, FileListInfoResponseBean bean)`  L195 @Override
- `void onDeleteClick(final FileListInfoResponseBean fileListInfoResponseBean)`  L198 @Override
- `void onConfirmed()`  L201 @Override
- `void onDownloadClick(FileListInfoResponseBean fileListInfoResponseBean)`  L208 @Override
- `String getPlayPath(FileListInfoResponseBean bean)`  L214
    - 体内字面量："CV75" · "http://%s%s" · "/tmp/SD0" · "http://%s/%s"
- `void onItemClick__(BaseViewHolder holder, int position, FileListInfoResponseBean bean)`  L226 @Override
- `int getItemLayoutID(int position, FileListInfoResponseBean bean)`  L239 @Override
### `com.gku.amba.AmbaPicPreviewActivity`
L23 · [class] public AmbaPicPreviewActivity · extends `BaseXtuGoActivity` · `com/gku/amba/AmbaPicPreviewActivity.java`

字段/常量（6）：
- `String KEY_INTENT = "KEY_INTENT"`  L24
- `String KEY_LIST = "KEY_LIST"`  L25
- `String KEY_POSITION = "KEY_POSITION"`  L26
- `DialogAmbaSDMediaDelete dialogAmbaSDMediaDelete`  L27
- `DialogAmbaSDMediaDownload dialogAmbaSDMediaDownload`  L28
- `ViewPager2Adapter<FileListInfoResponseBean> viewPager2Adapter`  L29

方法（6）：
- `void onCreate(Bundle savedInstanceState)`  L32 @Override
- `void onClick(View v)`  L37 @Override
    - 体内字面量："KEY_INTENT" · "onItemClick__preview" · "KEY_LIST" · "KEY_LIST" · "KEY_POSITION"
- `void onDismiss()`  L51 @Override
- `void onSuccessOne(int position, int count_downloaded)`  L55 @Override
    - 体内字面量："CALLBACK_DOWNLOAD_ONE"
- `void onDismiss()`  L61 @Override
- `void onDeleteOne(int position, int count_deleted)`  L65 @Override
    - 体内字面量："CALLBACK_DELETE_ONE"
### `com.gku.amba.AmbaPicPreviewActivity$AnonymousClass2`
L74 · [class] AnonymousClass2 · extends `ViewPager2Adapter<FileListInfoResponseBean>` · `com/gku/amba/AmbaPicPreviewActivity.java`

方法（5）：
- `void onItemClick(ViewPager2Holder holder, int position, FileListInfoResponseBean bean)`  L76 @Override
- `void onPageSelected(ViewPager2Holder holder, int position, FileListInfoResponseBean bean)`  L84 @Override
    - 体内字面量："CALLBACK_UPDATE_LIST_POSITION"
- `void onViewRecycled(ViewPager2Holder holder)`  L90 @Override
- `void bindDataToView(ViewPager2Holder holder, int position, FileListInfoResponseBean bean)`  L96 @Override
- `int getItemLayoutID(int position, FileListInfoResponseBean bean)`  L178 @Override
### `com.gku.amba.AmbaPicPreviewActivity$AnonymousClass2$AnonymousClass1`
L106 · [class] AnonymousClass1 · extends `ShimmerLayoutSimple.Callback` · `com/gku/amba/AmbaPicPreviewActivity.java`

字段/常量（5）：
- `FileListInfoResponseBean val$bean`  L107
- `ViewPager2Holder val$holder`  L108
- `ShimmerLayoutSimple val$shimmerLayoutSimple`  L109
- `SubsamplingScaleImageView val$subsamplingScaleImageView`  L110
- `String val$tag`  L111

方法（10）：
- `void onDoNet(int mode)`  L122 @Override
    - 体内字面量："downloadFile bindDataToView"
- `void onProgress(FileListInfoResponseBean fileListInfoResponseBean, long current, long contentLength, int percent)`  L126 @Override
- `void onRefreshSpeed(FileListInfoResponseBean fileListInfoResponseBean, long bytesPerSecond)`  L130 @Override
- `void onStart(FileListInfoResponseBean fileListInfoResponseBean)`  L134 @Override
- `void onSuccess(FileListInfoResponseBean fileListInfoResponseBean, String pathSaved)`  L138 @Override
- `void onReady()`  L142 @Override
- `void onImageLoadError(Exception e)`  L148 @Override
- `void onPreviewLoadError(Exception e)`  L154 @Override
- `void onTileLoadError(Exception e)`  L160 @Override
- `void onFail(FileListInfoResponseBean fileListInfoResponseBean, int code)`  L170 @Override
    - 体内字面量："\n"
### `com.gku.amba.AmbaPicPreviewActivity$AnonymousClass5`
L184 · [class] AnonymousClass5 · implements `View.OnClickListener` · `com/gku/amba/AmbaPicPreviewActivity.java`

字段/常量（1）：
- `ViewPager2 val$viewPager2`  L185

方法（4）：
- `void onClick(View v)`  L192 @Override
- `void onDeleteClick(final FileListInfoResponseBean fileListInfoResponseBean)`  L195 @Override
- `void onConfirmed()`  L198 @Override
- `void onDownloadClick(FileListInfoResponseBean fileListInfoResponseBean)`  L205 @Override