# XTU GO — 类与成员明细：com.gku.hisi

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 10 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.hisi.Hisi_CameraFileActivity`
L21 · [class] public Hisi_CameraFileActivity · extends `BaseXtuGoActivity` · `com/gku/hisi/Hisi_CameraFileActivity.java`

字段/常量（5）：
- `String CALLBACK_CHOOSE_CLICK = "CALLBACK_CHOOSE_CLICK"`  L22
- `FragPageAdapterVpNoScroll<Integer> fragPageAdapterVpNoScroll`  L23
- `TabAdapterNoScroll<Integer> tabAdapter`  L24
- `TabLayoutNoScroll tabLayoutNoScroll`  L25
- `ViewPager viewPager`  L26

方法（6）：
- `void onCreate(Bundle savedInstanceState)`  L29 @Override
- `void onClick(View v)`  L38 @Override
- `void onClick(View v)`  L44 @Override
    - 体内字面量："CALLBACK_CHOOSE_CLICK"
- `void bindDataToTab(TabNoScrollViewHolder holder, int position, Integer bean, boolean isSelected)`  L52 @Override
- `int getTabLayoutID(int position, Integer bean)`  L58 @Override
- `Fragment createFragment(Integer bean, int position)`  L63 @Override
### `com.gku.hisi.Hisi_CameraPicFragment`
L49 · [class] public Hisi_CameraPicFragment · extends `BaseFragment` · `com/gku/hisi/Hisi_CameraPicFragment.java`

字段/常量（17）：
- `String CALLBACK_DELETE_ONE = "CALLBACK_DELETE_ONE"`  L50
- `String CALLBACK_DOWNLOAD_ONE = "CALLBACK_DOWNLOAD_ONE"`  L51
- `String CALLBACK_UPDATE_LIST_PIC_POSITION = "CALLBACK_UPDATE_LIST_POSITION"`  L52
- `int PAGE_SIZE = 50`  L53
- `DialogHisiSDMediaDelete dialogHisiSDMediaDelete`  L54
- `DialogHisiSDMediaDownload dialogHisiSDMediaDownload`  L55
- `DialogHisiSDMediaMenu dialogHisiSDMediaMenu`  L56
- `DragSelectorAdapter<GetfilelistinfoiosResponseBean> dragSelectorAdapter`  L57
- `GridRefreshLayout gridRefreshLayout`  L58
- `ImageViewSelector imageViewSelector`  L59
- `View layout_menu`  L60
- `ShimmerLayoutSimple shimmerLayoutSimple`  L61
- `TextView tv_count`  L62
- `int i`  L325
- `int i2 = page_start + Hisi_CameraPicFragment.this.PAGE_SIZE`  L382
- `int i3 = countTotal`  L383
- `Hisi_CameraPicFragment hisi_CameraPicFragment = Hisi_CameraPicFragment.this`  L402

方法（26）：
- `void onCreate(Bundle savedInstanceState)`  L195 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L201 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L207 @Override
- `void onDeleteOne(int position, int count_deleted)`  L212 @Override
- `void onDismiss()`  L217 @Override
- `void onSuccessOne(int position, int count_downloaded)`  L224 @Override
    - 体内字面量："onSuccessOne bindDataToView"
- `void onDismiss()`  L230 @Override
- `void onCheckedChanged(ImageViewSelector iv, boolean isChecked, boolean byTouch)`  L244 @Override
- `void onClick(View v)`  L250 @Override
- `void onClick(View v)`  L257 @Override
- `void onConfirmed()`  L263 @Override
- `void onClick(View v)`  L272 @Override
    - 体内字面量："CALLBACK_UPDATE_LIST_POSITION"
- `void callback(Integer integer)`  L282 @Override
    - 体内字面量："CALLBACK_CHOOSE_CLICK"
- `void callback(Object o)`  L288 @Override
    - 体内字面量："CALLBACK_DOWNLOAD_ONE"
- `void callback(Integer integer)`  L295 @Override
    - 体内字面量："CALLBACK_DELETE_ONE"
- `void callback(Integer integer)`  L301 @Override
- `void handleOnBackPressed()`  L307 @Override
- `void onDoNet(final int mode)`  L321 @Override
    - 体内字面量："/cgi-bin/hi3510/getfilecount.cgi" · "/cgi-bin/hi3510/getfiletypecount.cgi"
- `void onSuccess(Call call, String responseBody, Response response)`  L324 @Override
- `void onFail(Call call, int code, String errorMsg)`  L345 @Override
    - 体内字面量："getfilecount onFail" · "\n"
- `void loadList(final int countTotal, final int mode, final int page_start, final List<GetfilelistinfoiosResponseBean> listAll)`  L355
    - 体内字面量："loadList" · "/cgi-bin/hi3510/getfilelistinfoios.cgi" · "/cgi-bin/hi3510/getfilelist.cgi" · "-start" · "-end" · "-type" · "Photo"
- `List<GetfilelistinfoiosResponseBean> parse(List<GetfilelistinfoiosResponseBean> list)`  L366
- `void onSuccess(List<GetfilelistinfoiosResponseBean> list, String responseBody)`  L377 @Override
- `void onLoadMoreClosed(int mode2)`  L392 @Override
- `void onRefreshClosed(int mode2)`  L396 @Override
- `void onFail(int code, String msg)`  L407 @Override
    - 体内字面量："loadList" · "onFail" · "getfilelistinfoios onFail" · "\n"
### `com.gku.hisi.Hisi_CameraPicFragment$AnonymousClass1`
L65 · [class] AnonymousClass1 · extends `DragSelectorAdapter<GetfilelistinfoiosResponseBean>` · `com/gku/hisi/Hisi_CameraPicFragment.java`

字段/常量（7）：
- `String str`  L98
- `int i`  L118
- `BaseViewHolder baseViewHolder = holder`  L119
- `int i2 = com.gku.module_camera.R.id.tv_download_state`  L120
- `ComponentActivity componentActivity = Hisi_CameraPicFragment.this.activity`  L121
- `ComponentActivity componentActivity = Hisi_CameraPicFragment.this.activity`  L149
- `Hisi_CameraPicFragment hisi_CameraPicFragment = Hisi_CameraPicFragment.this`  L184

方法（16）：
- `void bindDataToView(BaseViewHolder holder, int position, GetfilelistinfoiosResponseBean bean, boolean isSelected, List payloads)`  L70 @Override
- `boolean areItemsTheSame(GetfilelistinfoiosResponseBean beanOld, GetfilelistinfoiosResponseBean beanNew, int oldItemPosition, int newItemPosition)`  L75 @Override
- `boolean areContentsTheSame(GetfilelistinfoiosResponseBean beanOld, GetfilelistinfoiosResponseBean beanNew, int oldItemPosition, int newItemPosition)`  L83 @Override
- `void onSelectCountChanged(boolean isAllSelected, int count_selected)`  L91 @Override
- `void bindDataToView2(final BaseViewHolder holder, final int position, final GetfilelistinfoiosResponseBean bean, boolean isSelected, List<Object> payloads)`  L97
- `void onInterrupted()`  L104 @Override
- `Boolean runThread()`  L109 @Override
- `void run_UIThread(final Boolean result)`  L114 @Override
- `void onTagEquls(Object tag)`  L117 @Override
- `void onCheckedChanged(ImageViewSelector iv, boolean isChecked, boolean byTouch)`  L136 @Override
    - 体内字面量："NOTIFY_STATE_DRAG_SELECT"
- `void onItemLongClick__(BaseViewHolder holder, final int position, GetfilelistinfoiosResponseBean bean)`  L160 @Override
- `void onDeleteClick(final GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L163 @Override
- `void onConfirmed()`  L166 @Override
- `void onDownloadClick(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L173 @Override
- `void onItemClick__(BaseViewHolder holder, int position, GetfilelistinfoiosResponseBean bean)`  L180 @Override
    - 体内字面量："KEY_POSITION" · "KEY_LIST"
- `int getItemLayoutID(int position, GetfilelistinfoiosResponseBean bean)`  L189 @Override
### `com.gku.hisi.Hisi_CameraRecordFragment`
L55 · [class] public Hisi_CameraRecordFragment · extends `BaseFragment` · `com/gku/hisi/Hisi_CameraRecordFragment.java`

字段/常量（14）：
- `int PAGE_SIZE = 50`  L56
- `DialogHisiSDMediaDelete dialogHisiSDMediaDelete`  L57
- `DialogHisiSDMediaDownload dialogHisiSDMediaDownload`  L58
- `DialogHisiSDMediaMenu dialogHisiSDMediaMenu`  L59
- `DragSelectorAdapter<GetfilelistinfoiosResponseBean> dragSelectorAdapter`  L60
- `GridRefreshLayout gridRefreshLayout`  L61
- `ImageViewSelector imageViewSelector`  L62
- `View layout_menu`  L63
- `ShimmerLayoutSimple shimmerLayoutSimple`  L64
- `TextView tv_count`  L65
- `int i`  L325
- `int i2 = page_start + Hisi_CameraRecordFragment.this.PAGE_SIZE`  L383
- `int i3 = countTotal`  L384
- `Hisi_CameraRecordFragment hisi_CameraRecordFragment = Hisi_CameraRecordFragment.this`  L403

方法（23）：
- `void onCreate(Bundle savedInstanceState)`  L214 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L220 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L226 @Override
- `void onDeleteOne(int position, int count_deleted)`  L231 @Override
- `void onDismiss()`  L236 @Override
- `void onSuccessOne(int position, int count_downloaded)`  L243 @Override
- `void onDismiss()`  L248 @Override
- `void onCheckedChanged(ImageViewSelector iv, boolean isChecked, boolean byTouch)`  L262 @Override
- `void onClick(View v)`  L268 @Override
- `void onClick(View v)`  L275 @Override
- `void onConfirmed()`  L281 @Override
- `void onClick(View v)`  L290 @Override
    - 体内字面量："CALLBACK_CHOOSE_CLICK"
- `void callback(Object o)`  L300 @Override
- `void handleOnBackPressed()`  L307 @Override
- `void onDoNet(final int mode)`  L321 @Override
    - 体内字面量："/cgi-bin/hi3510/getfilecount.cgi" · "/cgi-bin/hi3510/getfiletypecount.cgi"
- `void onSuccess(Call call, String responseBody, Response response)`  L324 @Override
- `void onFail(Call call, int code, String errorMsg)`  L345 @Override
    - 体内字面量："getfilecount onFail" · "\n"
- `void loadList(final int countTotal, final int mode, final int page_start, final List<GetfilelistinfoiosResponseBean> listAll)`  L355
    - 体内字面量："loadList page_start" · "loadList   page_end" · "/cgi-bin/hi3510/getfilelistinfoios.cgi" · "/cgi-bin/hi3510/getfilelist.cgi" · "-start" · "-end" · "-type" · "Video"
- `List<GetfilelistinfoiosResponseBean> parse(List<GetfilelistinfoiosResponseBean> list)`  L367
- `void onSuccess(List<GetfilelistinfoiosResponseBean> list, String responseBody)`  L378 @Override
- `void onLoadMoreClosed(int mode2)`  L393 @Override
- `void onRefreshClosed(int mode2)`  L397 @Override
- `void onFail(int code, String msg)`  L408 @Override
    - 体内字面量："loadList" · "onFail" · "getfilelistinfoios onFail" · "\n"
### `com.gku.hisi.Hisi_CameraRecordFragment$AnonymousClass1`
L68 · [class] AnonymousClass1 · extends `DragSelectorAdapter<GetfilelistinfoiosResponseBean>` · `com/gku/hisi/Hisi_CameraRecordFragment.java`

字段/常量（7）：
- `String str`  L101
- `int i`  L122
- `BaseViewHolder baseViewHolder = holder`  L123
- `int i2 = com.gku.module_camera.R.id.tv_download_state`  L124
- `ComponentActivity componentActivity = Hisi_CameraRecordFragment.this.activity`  L125
- `ComponentActivity componentActivity = Hisi_CameraRecordFragment.this.activity`  L153
- `String playPath`  L196

方法（17）：
- `void bindDataToView(BaseViewHolder holder, int position, GetfilelistinfoiosResponseBean bean, boolean isSelected, List payloads)`  L73 @Override
- `boolean areItemsTheSame(GetfilelistinfoiosResponseBean beanOld, GetfilelistinfoiosResponseBean beanNew, int oldItemPosition, int newItemPosition)`  L78 @Override
- `boolean areContentsTheSame(GetfilelistinfoiosResponseBean beanOld, GetfilelistinfoiosResponseBean beanNew, int oldItemPosition, int newItemPosition)`  L86 @Override
- `void onSelectCountChanged(boolean isAllSelected, int count_selected)`  L94 @Override
- `void bindDataToView2(final BaseViewHolder holder, final int position, final GetfilelistinfoiosResponseBean bean, boolean isSelected, List<Object> payloads)`  L100
- `void onInterrupted()`  L108 @Override
- `Boolean runThread()`  L113 @Override
- `void run_UIThread(final Boolean result)`  L118 @Override
- `void onTagEquls(Object tag)`  L121 @Override
- `void onCheckedChanged(ImageViewSelector iv, boolean isChecked, boolean byTouch)`  L140 @Override
    - 体内字面量："NOTIFY_STATE_DRAG_SELECT"
- `void onItemLongClick__(BaseViewHolder holder, final int position, GetfilelistinfoiosResponseBean bean)`  L164 @Override
- `void onDeleteClick(final GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L167 @Override
- `void onConfirmed()`  L170 @Override
- `void onDownloadClick(GetfilelistinfoiosResponseBean getfilelistinfoiosResponseBean)`  L177 @Override
- `String getPlayPath(GetfilelistinfoiosResponseBean bean)`  L183
    - 体内字面量："CV75" · "http://%s%s" · "/tmp/SD0" · "http://%s/%s" · "http://%s/%s"
- `void onItemClick__(BaseViewHolder holder, int position, GetfilelistinfoiosResponseBean bean)`  L195 @Override
- `int getItemLayoutID(int position, GetfilelistinfoiosResponseBean bean)`  L208 @Override
### `com.gku.hisi.Hisi_PicPreviewActivity`
L28 · [class] public Hisi_PicPreviewActivity · extends `BaseXtuGoActivity` · `com/gku/hisi/Hisi_PicPreviewActivity.java`

字段/常量（7）：
- `String KEY_INTENT = "KEY_INTENT"`  L29
- `String KEY_LIST = "KEY_LIST"`  L30
- `String KEY_POSITION = "KEY_POSITION"`  L31
- `DialogHisiSDMediaDelete dialogHisiSDMediaDelete`  L32
- `DialogHisiSDMediaDownload dialogHisiSDMediaDownload`  L33
- `DialogHisiSDMediaMenu dialogHisiSDMediaMenu`  L34
- `ViewPager2Adapter<GetfilelistinfoiosResponseBean> viewPager2Adapter`  L35

方法（6）：
- `void onCreate(Bundle savedInstanceState)`  L38 @Override
- `void onClick(View v)`  L43 @Override
    - 体内字面量："KEY_INTENT" · "onItemClick__preview" · "KEY_LIST" · "KEY_LIST" · "KEY_POSITION"
- `void onDismiss()`  L57 @Override
- `void onSuccessOne(int position, int count_downloaded)`  L61 @Override
    - 体内字面量："CALLBACK_DOWNLOAD_ONE"
- `void onDismiss()`  L67 @Override
- `void onDeleteOne(int position, int count_deleted)`  L71 @Override
    - 体内字面量："CALLBACK_DELETE_ONE"
### `com.gku.hisi.Hisi_PicPreviewActivity$AnonymousClass2`
L84 · [class] AnonymousClass2 · extends `ViewPager2Adapter<GetfilelistinfoiosResponseBean>` · `com/gku/hisi/Hisi_PicPreviewActivity.java`

方法（6）：
- `void onItemClick(ViewPager2Holder holder, int position, GetfilelistinfoiosResponseBean bean)`  L86 @Override
- `void onPageSelected(ViewPager2Holder holder, int position, GetfilelistinfoiosResponseBean bean)`  L94 @Override
    - 体内字面量："CALLBACK_UPDATE_LIST_POSITION"
- `void onViewRecycled(ViewPager2Holder holder)`  L100 @Override
- `int getExifRotation(String imagePath)`  L105
    - 体内字面量："Orientation"
- `void bindDataToView(ViewPager2Holder holder, int position, GetfilelistinfoiosResponseBean bean)`  L122 @Override
    - 体内字面量："downloadFile bindDataToView"
- `int getItemLayoutID(int position, GetfilelistinfoiosResponseBean bean)`  L213 @Override
### `com.gku.hisi.Hisi_PicPreviewActivity$AnonymousClass2$AnonymousClass1`
L132 · [class] AnonymousClass1 · extends `ShimmerLayoutSimple.Callback` · `com/gku/hisi/Hisi_PicPreviewActivity.java`

字段/常量（4）：
- `ViewPager2Holder val$holder`  L133
- `ShimmerLayoutSimple val$shimmerLayoutSimple`  L134
- `SubsamplingScaleImageView val$subsamplingScaleImageView`  L135
- `String val$url`  L136

方法（1）：
- `void onDoNet(int mode)`  L207 @Override
### `com.gku.hisi.Hisi_PicPreviewActivity$AnonymousClass2$AnonymousClass1$C01161`
L146 · [class] C01161 · extends `XUtils.CallbackDownloadSimple` · `com/gku/hisi/Hisi_PicPreviewActivity.java`

方法（9）：
- `void onSuccess__(final File file)`  L151 @Override
    - 体内字面量："downloadPic2File onSuccess"
- `void onInterrupted()`  L156 @Override
- `Integer runThread()`  L161 @Override
- `void run_UIThread(final Integer result)`  L166 @Override
- `void onReady()`  L169 @Override
- `void onImageLoadError(Exception e)`  L176 @Override
- `void onPreviewLoadError(Exception e)`  L182 @Override
- `void onTileLoadError(Exception e)`  L188 @Override
- `void onFail(int code, String errorMsg)`  L200 @Override
    - 体内字面量："downloadPic2File  onFail"
### `com.gku.hisi.Hisi_PicPreviewActivity$AnonymousClass5`
L219 · [class] AnonymousClass5 · implements `View.OnClickListener` · `com/gku/hisi/Hisi_PicPreviewActivity.java`

字段/常量（1）：
- `ViewPager2 val$viewPager2`  L220

方法（4）：
- `void onClick(View v)`  L227 @Override
- `void onDeleteClick(final GetfilelistinfoiosResponseBean GetfilelistinfoiosResponseBean)`  L230 @Override
- `void onConfirmed()`  L233 @Override
- `void onDownloadClick(GetfilelistinfoiosResponseBean GetfilelistinfoiosResponseBean)`  L240 @Override