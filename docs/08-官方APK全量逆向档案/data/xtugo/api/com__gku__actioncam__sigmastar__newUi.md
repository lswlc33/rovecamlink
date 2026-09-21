# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.newUi

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 79 个文件 / 123 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.newUi.album.Data.AlbumNewItemModel`
L8 · [class] public AlbumNewItemModel · implements `Parcelable` · `com/gku/actioncam/sigmastar/newUi/album/Data/AlbumNewItemModel.java`

字段/常量（12）：
- `int TYPE_HD_VIDEO = 3`  L22
- `int TYPE_IMAGE = 1`  L23
- `int TYPE_VIDEO = 2`  L24
- `long createTime`  L25
- `Uri fileUri`  L26
- `long id_thumbnail_cover`  L27
- `boolean isNeedShowSelect`  L28
- `boolean isSelect`  L29
- `long length`  L30
- `long mAddedDate`  L31
- `String mPath`  L32
- `int mType`  L33

方法（29）：
- `AlbumNewItemModel createFromParcel(Parcel source)`  L12 @Override
- `AlbumNewItemModel[] newArray(int size)`  L18 @Override
- `public AlbumNewItemModel(String path, long addedDate, int type)`  L35
- `public AlbumNewItemModel()`  L41
- `long getId_thumbnail_cover()`  L44
- `void setId_thumbnail_cover(long id_thumbnail_cover)`  L48
- `Uri getFileUri()`  L52
- `void setFileUri(Uri fileUri)`  L56
- `long getCreateTime()`  L60
- `void setCreateTime(long createTime)`  L64
- `String getPath()`  L68
- `void setPath(String path)`  L72
- `long getAddedDate()`  L76
- `void setAddedDate(long addedDate)`  L80
- `int getType()`  L84
- `void setType(int type)`  L88
- `boolean isImage()`  L92
- `boolean isVideo()`  L96
- `boolean isHDVideo()`  L100
- `long getLength()`  L104
- `void setLength(long length)`  L108
- `boolean isSelect()`  L112
- `void setSelect(boolean isSelect)`  L116
- `boolean isNeedShowSelect()`  L120
- `void setNeedShowSelect(boolean needShowSelect)`  L124
- `int describeContents()`  L129 @Override
- `void writeToParcel(Parcel dest, int flags)`  L134 @Override
- `boolean equals(Object obj)`  L141
- `protected AlbumNewItemModel(Parcel in)`  L149
### `com.gku.actioncam.sigmastar.newUi.album.Data.MediaNewScanTask`
L24 · [class] public MediaNewScanTask · extends `AsyncTask<Void, Void, List<AlbumNewItemModel>>` · `com/gku/actioncam/sigmastar/newUi/album/Data/MediaNewScanTask.java`

字段/常量（19）：
- `String TAG = "MediaNewScanTask"`  L25
- `boolean sIsRefresh`  L26
- `int sRefreshCount`  L27
- `CallBack mCallBack`  L28
- `Context mContext`  L29
- `List<String> mScanDir`  L30
- `List<Integer> mType`  L31
- `boolean z = sIsRefresh`  L38
- `int i = sRefreshCount + 1`  L39
- `CallBack callBack = this.mCallBack`  L72
- `List<Integer> list = this.mType`  L87
- `StringBuilder sb`  L98
- `AlbumNewItemModel albumNewItemModel`  L99
- `Uri uri`  L150
- `AlbumNewItemModel albumNewItemModel`  L151
- `String[] strArr = {"_data", "date_added"}`  L152
- `Uri uri2 = uri`  L158
- `List<MediaRepository2.MediaItem> videosInAllMedia`  L214
- `AlbumNewItemModel albumNewItemModel`  L248

方法（12）：
- `boolean isRefresh()`  L37
- `void refresh()`  L48
- `public MediaNewScanTask(Context context, String scanDir, int type)`  L52
- `public MediaNewScanTask(Context context, List<String> scanDir, List<Integer> type)`  L62
- `void onPostExecute(List<AlbumNewItemModel> albumNewItemModels)`  L70 @Override
- `List<AlbumNewItemModel> doInBackground(Void... params)`  L81 @Override
    - 体内字面量："doInBackground:  -------------------   mType    "
- `List<AlbumNewItemModel> getMediaData(String scanDir, int type)`  L97
- `List<AlbumNewItemModel> getMediaData(Context context, String scanDir, int type)`  L149
- `List<AlbumNewItemModel> getMediaDataFromDCIM2(String directoryPath, int type)`  L213
- `List<AlbumNewItemModel> getMediaDataFromDCIM(String directoryPath, int type)`  L247
- `void release()`  L286
- `void setResultCallback(CallBack callback)`  L291
### `com.gku.actioncam.sigmastar.newUi.album.Data.MediaNewScanTask$CallBack`
L33 · [interface] public CallBack · `com/gku/actioncam/sigmastar/newUi/album/Data/MediaNewScanTask.java`

方法（1）：
- `void onScanResultCallback(List<AlbumNewItemModel> data)`  L34
### `com.gku.actioncam.sigmastar.newUi.album.Data.SectionItemModel`
L6 · [class] public SectionItemModel · `com/gku/actioncam/sigmastar/newUi/album/Data/SectionItemModel.java`

字段/常量（3）：
- `Map<Integer, Integer> itemMap`  L7
- `String name`  L8
- `String stringChoice`  L9

方法（7）：
- `public SectionItemModel(String name, Map<Integer, Integer> itemMap)`  L11
- `String getName()`  L16
- `void setName(String name)`  L20
- `Map<Integer, Integer> getItemMap()`  L24
- `void setItemMap(Map<Integer, Integer> itemMap)`  L28
- `String getStringChoice()`  L32
- `void setStringChoice(String choice)`  L36
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Activity.ActivityNewPreview`
L46 · [class] public ActivityNewPreview · extends `BaseActivity implements Toolbar.OnMenuItemClickListener, PreviewPagerNewAdapter.OnAlbumPreviewItemClickListener` · implements `Toolbar.OnMenuItemClickListener, PreviewPagerNewAdapter.OnAlbumPreviewItemClickListener` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Activity/ActivityNewPreview.java`

字段/常量（23）：
- `String ARG_DATA = "data"`  L47
- `String ARG_POSITION = "position"`  L48
- `String ARG_TYPE = "TYPE"`  L49
- `String TAG = "ActivityNewPreview"`  L50
- `int TYPE`  L51
- `int currentPosition`  L52
- `PreviewPagerNewAdapter mAdapter`  L53
- `List<AlbumNewItemModel> mData`  L54
- `FrameLayout mFrameLayout`  L55
- `BottomButtomItem mImageEditYutupro`  L56
- `ImageView mIvDelete`  L57
- `BottomButtomItem mIvDeleteYutupro`  L58
- `ImageView mIvEdit`  L59
- `BottomButtomItem mIvShareYutupro`  L60
- `ImageView mIvVideoEdit`  L61
- `BottomButtomItem mIvVideoEditYutupro`  L62
- `LinearLayout mLinearLayoutTool`  L63
- `LinearLayout mLinearLayoutToolYutupro`  L64
- `Toolbar mToolbar`  L65
- `ViewPager mVpager`  L66
- `ActivityNewPreview activityNewPreview = ActivityNewPreview.this`  L194
- `ActivityNewPreview activityNewPreview2 = ActivityNewPreview.this`  L199
- `String str = isImage ? "image" : "video"`  L326

方法（26）：
- `void open(Context context, List<AlbumNewItemModel> data, int selectPosition, int TYPE)`  L69
    - 体内字面量："data" · "position"
- `void onCreate(Bundle savedInstanceState)`  L92 @Override
- `void onClick(View view)`  L109 @Override
- `void onClick(View view)`  L117 @Override
- `void onClick(View view)`  L125 @Override
- `void onClick(View view)`  L133 @Override
- `void onClick(View v)`  L141 @Override
    - 体内字面量："Intent is empty!!!" · "position" · "data"
- `void onPageScrollStateChanged(int state)`  L184 @Override
- `void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)`  L188 @Override
- `void onPageSelected(int position)`  L192 @Override
- `void lambda$onCreate$1(View view)`  L211
- `void onClick(View view2)`  L217 @Override
- `void lambda$onCreate$0(View view)`  L225
- `void lambda$onCreate$2(View view)`  L230
- `void lambda$onCreate$3(View view)`  L235
    - 体内字面量："video"
- `void lambda$onCreate$4(View view)`  L240
- `void onBackPressed()`  L246 @Override
- `void hideIvEdit()`  L252
- `void hideIvEditYutupro()`  L263
- `void syncTitle(int index)`  L276
    - 体内字面量："/"
- `void delete()`  L280
- `void exitAndNotify()`  L299
- `boolean onCreateOptionsMenu(Menu menu)`  L307 @Override
- `boolean onMenuItemClick(MenuItem item)`  L315 @Override
- `void shareContent(boolean isImage, String path, Uri fileUri)`  L324
- `void onAlbumPreviewItemClick(int position)`  L344 @Override
    - 体内字面量："DashCam" · "LocalVideoPath" · "/"
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.CommonNewAdapter`
L14 · [class] public abstract CommonNewAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/CommonNewAdapter.java`

字段/常量（5）：
- `Context mContext`  L16
- `List<T> mDatas`  L17
- `LayoutInflater mInflater`  L18
- `int mLayoutId`  L19
- `CommonClickListener mListener`  L20

方法（7）：
- `void convert(ViewHolder holder, T t)`  L26
- `public CommonNewAdapter(Context context, int layoutId, List<T> datas)`  L28
- `ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType)`  L36 @Override
- `void onBindViewHolder(final ViewHolder holder, int position)`  L41 @Override
- `void onClick(View v)`  L50 @Override
- `int getItemCount()`  L61 @Override
- `void addCommonClickListener(CommonClickListener listener)`  L65
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.CommonNewAdapter$CommonClickListener`
L22 · [interface] public CommonClickListener · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/CommonNewAdapter.java`

方法（1）：
- `void onCommonClick(int position)`  L23
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.MultiItemNewCommonNewAdapter`
L10 · [class] public abstract MultiItemNewCommonNewAdapter · extends `CommonNewAdapter<T>` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/MultiItemNewCommonNewAdapter.java`

字段/常量（1）：
- `MultiItemNewTypeSupport<T> mMultiItemTypeSupport`  L11

方法（3）：
- `public MultiItemNewCommonNewAdapter(Context context, List<T> data, MultiItemNewTypeSupport multiItemTypeSupport)`  L13
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L19 @Override
- `int getItemViewType(int i)`  L34 @Override
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.PagerNewAdapter`
L15 · [class] public PagerNewAdapter · extends `FragmentPagerAdapter` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/PagerNewAdapter.java`

字段/常量（4）：
- `FragmentNewNormalAlbum fragment`  L16
- `FragmentFavorites fragmentFavorites`  L17
- `List<Fragment> fragmentList`  L18
- `Context mContext`  L19

方法（4）：
- `public PagerNewAdapter(FragmentManager fm, Context context)`  L21
- `CharSequence getPageTitle(int position)`  L40 @Override
- `Fragment getItem(int position)`  L63 @Override
- `int getCount()`  L68 @Override
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.PreviewPagerNewAdapter`
L15 · [class] public PreviewPagerNewAdapter · extends `PagerAdapter` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/PreviewPagerNewAdapter.java`

字段/常量（3）：
- `List<AlbumNewItemModel> mData`  L16
- `OnAlbumPreviewItemClickListener mListener`  L17
- `List<AlbumNewItemModel> list = this.mData`  L40

方法（7）：
- `int getItemPosition(Object object)`  L24 @Override
- `boolean isViewFromObject(View view, Object object)`  L29 @Override
- `public PreviewPagerNewAdapter(List<AlbumNewItemModel> data, OnAlbumPreviewItemClickListener listener)`  L33
- `int getCount()`  L39 @Override
- `Object instantiateItem(ViewGroup container, final int position)`  L48 @Override
- `void onClick(View v)`  L64 @Override
- `void destroyItem(ViewGroup container, int position, Object object)`  L74 @Override
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.PreviewPagerNewAdapter$OnAlbumPreviewItemClickListener`
L19 · [interface] public OnAlbumPreviewItemClickListener · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/PreviewPagerNewAdapter.java`

方法（1）：
- `void onAlbumPreviewItemClick(int position)`  L20
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.SectionNewAdapter`
L22 · [class] public abstract SectionNewAdapter · extends `MultiItemNewCommonNewAdapter<T>` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/SectionNewAdapter.java`

字段/常量（23）：
- `int TYPE_SECTION = 0`  L23
- `BatchClickListener batchClickListener`  L24
- `List<Integer> clickPositions`  L25
- `MultiItemNewTypeSupport headerItemTypeSupport`  L26
- `RecyclerView mRecyclerView`  L27
- `int mSectionCount`  L28
- `List<SectionItemModel> mSectionItemModelList`  L29
- `SectionNewSupport mSectionNewSupport`  L30
- `List<Integer> mSectionPositions`  L31
- `List<String> mSectionStrings`  L32
- `LinkedHashMap<String, Integer> mSections`  L33
- `RecyclerView.AdapterDataObserver observer`  L34
- `int sectionItemNum`  L35
- `List<ViewHolder> viewHolderList`  L36
- `int i = 0`  L53
- `List<Integer> list = this.clickPositions`  L61
- `List<Integer> list2 = this.mSectionPositions`  L66
- `List<String> list3 = this.mSectionStrings`  L71
- `RecyclerView recyclerView = this.mRecyclerView`  L96
- `int i = 0`  L153
- `int[] wh`  L168
- `SectionNewAdapter sectionNewAdapter = SectionNewAdapter.this`  L192
- `SectionNewAdapter sectionNewAdapter2 = SectionNewAdapter.this`  L195

方法（21）：
- `int[] getWH()`  L42
- `int getItemViewType(int position)`  L47 @Override
- `void findSection()`  L51
- `int getSpanSize(int position)`  L104 @Override
- `public SectionNewAdapter(Context context, List<T> data, int layoutId, SectionNewSupport sectionNewSupport)`  L115
- `int getLayoutId(int itemType)`  L119 @Override
- `int getItemViewType(int i, Object obj)`  L127 @Override
- `void onChanged()`  L133 @Override
- `int getItemCount()`  L147 @Override
- `int getIndexForPosition(int position)`  L151
- `int getLayoutPositionForDataIndex(String sectionName, int index)`  L162
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L167 @Override
- `void onBindViewHolder(final ViewHolder holder, int position)`  L177 @Override
- `void onClick(View v)`  L190 @Override
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L223 @Override
- `void onDetachedFromRecyclerView(RecyclerView recyclerView)`  L230 @Override
- `void setAllBatchTextVisible(boolean visible)`  L235
- `void setAllBatchText(String text)`  L242
- `void setAllBatchText(int textId)`  L249
- `void setSingleBatchText(String text, String name)`  L256
- `void addBatchClickListener(BatchClickListener batchClickListener)`  L264
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.SectionNewAdapter$BatchClickListener`
L38 · [interface] public BatchClickListener · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/SectionNewAdapter.java`

方法（1）：
- `void batchClick(List<Integer> clickPositions, int sectionIndex, String choice)`  L39
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.SubNewAdapter`
L27 · [class] public SubNewAdapter · extends `SectionNewAdapter<AlbumNewItemModel>` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/SubNewAdapter.java`

字段/常量（4）：
- `String TAG = "SubNewAdapter"`  L28
- `int mItemWidth`  L29
- `OnLoadThumbListener onLoadThumbListener`  L30
- `int i = this.mItemWidth`  L128

方法（12）：
- `public SubNewAdapter(Context context, List<AlbumNewItemModel> datas)`  L36
- `int sectionHeaderLayoutId()`  L39 @Override
- `int sectionTitleTextViewId()`  L44 @Override
- `int sectionTitleBatchSelectId()`  L49 @Override
- `String getTitle(AlbumNewItemModel model)`  L54 @Override
    - 体内字面量："window"
- `void notifyNoFlash()`  L65
    - 体内字面量："payload"
- `void convert(final ViewHolder holder, AlbumNewItemModel model)`  L70 @Override
    - 体内字面量："convert" · "s.MP4" · "s.MP4" · "s.mp4" · "s.mp4"
- `void run()`  L91 @Override
- `void run()`  L98 @Override
    - 体内字面量："timer convert: "
- `int[] getWH()`  L127 @Override
- `void setOnLoadThumbListener(OnLoadThumbListener onLoadThumbListener)`  L132
- `String getFormattedDuration(long durationMs)`  L137
    - 体内字面量："%02d:%02d:%02d"
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.SubNewAdapter$OnLoadThumbListener`
L32 · [interface] public OnLoadThumbListener · `com/gku/actioncam/sigmastar/newUi/album/Ui/Adapter/SubNewAdapter.java`

方法（1）：
- `void callback(String thumbPath, ImageView imageView)`  L33
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Fragment.CommonFragment`
L53 · [class] public CommonFragment · extends `BaseFragment implements CommonNewAdapter.CommonClickListener, SectionNewAdapter.BatchClickListener` · implements `CommonNewAdapter.CommonClickListener, SectionNewAdapter.BatchClickListener` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Fragment/CommonFragment.java`

字段/常量（13）：
- `String TAG = "CommonFragment"`  L54
- `int indexForPosition`  L55
- `SubNewAdapter mAdapter`  L56
- `List<AlbumNewItemModel> mData`  L57
- `TextView mEmptyView`  L58
- `RecyclerView mRecyclerView`  L59
- `Map<Integer, String> mSectionChoice`  L60
- `Set<AlbumNewItemModel> mSelectSet`  L61
- `SmartRefreshLayout smartRefreshLayout`  L62
- `SectionItemModel next`  L192
- `int i = sectionIndex + 1`  L230
- `Uri uri`  L281
- `String str = isImage ? "image" : "video"`  L307

方法（31）：
- `void handleMessage(Message msg)`  L66 @Override
- `void onCreate(Bundle savedInstanceState)`  L77 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L85 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L99 @Override
- `void initRecyclerView()`  L103
- `void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)`  L106 @Override
- `void onRefresh(final RefreshLayout smartRefreshLayout)`  L124 @Override
- `void run()`  L127 @Override
- `void onLoadMore(final RefreshLayout smartRefreshLayout)`  L136 @Override
- `void run()`  L139 @Override
- `void onResume()`  L151 @Override
    - 体内字面量："onResume: "
- `void onStart()`  L162 @Override
- `void onPause()`  L167 @Override
    - 体内字面量："onPause: "
- `void onStop()`  L173 @Override
    - 体内字面量："onStop: "
- `void onDestroy()`  L179 @Override
    - 体内字面量："onDestroy: "
- `void setUserVisibleHint(boolean isVisibleToUser)`  L185 @Override
    - 体内字面量："setUserVisibleHint: "
- `void onCommonClick(int position)`  L191 @Override
- `void batchClick(List<Integer> clickPositions, int sectionIndex, String choice)`  L228 @Override
    - 体内字面量："BatchSelect onClick: " · "\n sectionIndex: " · "\n choice: "
- `void updateChoiceStatus(int from, int to, boolean isNeedIndexTransfer, boolean visible)`  L240
- `void onReceiveMessageEvent(MessageFileEvent messageFileEvent)`  L261 @Subscribe(threadMode = ThreadMode.MAIN)
- `void shareContent(List<AlbumNewItemModel> mData)`  L280
- `void shareContent(boolean isImage, String path)`  L305
- `void updateCurPageSelectedAll()`  L322
- `void enterItemSelect()`  L329
- `void exitItemSelect()`  L338
- `void querySelectCount(Set<AlbumNewItemModel> mSelectedSet)`  L347
- `void querySelectMapCount(Map<Integer, AlbumNewItemModel> mSelectMap)`  L355
- `void reDrawBatchSelect(Map<Integer, AlbumNewItemModel> mSelectMap)`  L363
    - 体内字面量："æ¹ééæ©"
- `void refresh(Map<Integer, AlbumNewItemModel> mSelectMap, Handler handlerRefresh)`  L381
- `void refreshSpecifiedItem(int index, AlbumNewItemModel albumNewItemModel)`  L403
    - 体内字面量："payload"
- `Matcher getMatcher(String input)`  L407
    - 体内字面量："(\\d{8}[_-]\\d{6})"
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Fragment.FragmentFavorites`
L36 · [class] public FragmentFavorites · extends `CommonFragment implements MediaNewScanTask.CallBack` · implements `MediaNewScanTask.CallBack` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Fragment/FragmentFavorites.java`

字段/常量（6）：
- `String TAG = "FragmentFavorites"`  L37
- `int i = msg.what`  L47
- `FragmentFavorites fragmentFavorites = FragmentFavorites.this`  L75
- `Map<Integer, AlbumNewItemModel> mFavSelectMap`  L85
- `String updateItem`  L86
- `int i = 0`  L243

方法（19）：
- `void onReceive(Context context, Intent intent)`  L40 @Override
    - 体内字面量："itemName"
- `void handleMessage(Message msg)`  L46 @Override
- `FragmentFavorites newInstance()`  L88
- `void onCreate(Bundle savedInstanceState)`  L96 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L102 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L107 @Override
    - 体内字面量："onViewCreated: "
- `void onResume()`  L113 @Override
    - 体内字面量："123->" · "===========onResume() "
- `void onStart()`  L121 @Override
- `void onPause()`  L126 @Override
- `void onStop()`  L133 @Override
- `void onDestroy()`  L138 @Override
- `void setUserVisibleHint(boolean isVisibleToUser)`  L145 @Override
- `void refresh(Map<Integer, AlbumNewItemModel> mSelectMap, Handler handlerRefresh)`  L158 @Override
- `void queryData()`  L165
- `int compare(AlbumNewItemModel o1, AlbumNewItemModel o2)`  L183 @Override
- `void onCommonClick(int position)`  L205 @Override
    - 体内字面量："payload" · "CameraParameters.favoriteSelectedSet.size: "
- `void batchClick(List<Integer> clickPositions, int sectionIndex, String choice)`  L235 @Override
    - 体内字面量："BatchSelect onClick: " · "\n sectionIndex: " · "\n choice: "
- `void onReceiveMessageEvent(MessageFileEvent messageFileEvent)`  L269 @Override
- `void onScanResultCallback(List<AlbumNewItemModel> data)`  L336 @Override
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Fragment.FragmentNewAlbum`
L18 · [class] public FragmentNewAlbum · extends `Fragment` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Fragment/FragmentNewAlbum.java`

字段/常量（5）：
- `int REQUEST_PERMISSION_ALBUM = 321`  L19
- `String TAG = "FragmentNewAlbum"`  L20
- `PagerNewAdapter adapter`  L21
- `TabLayout mTablayout`  L22
- `ViewPager mVpager`  L23

方法（11）：
- `FragmentNewAlbum newInstance()`  L25
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L33 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L38 @Override
- `void onPageScrollStateChanged(int state)`  L58 @Override
- `void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)`  L62 @Override
- `void onPageSelected(int position)`  L66 @Override
    - 体内字面量："position: " · "CameraParameters.CURRENT_PAGES_SUB: "
- `void onTabReselected(TabLayout.Tab tab)`  L90 @Override
- `void onTabSelected(TabLayout.Tab tab)`  L94 @Override
- `void onTabUnselected(TabLayout.Tab tab)`  L98 @Override
- `void onResume()`  L104 @Override
    - 体内字面量："123->" · "===========onResume() "
- `void onDestroyView()`  L111 @Override
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Fragment.FragmentNewNormalAlbum`
L44 · [class] public FragmentNewNormalAlbum · extends `CommonFragment implements MediaNewScanTask.CallBack` · implements `MediaNewScanTask.CallBack` · `com/gku/actioncam/sigmastar/newUi/album/Ui/Fragment/FragmentNewNormalAlbum.java`

字段/常量（17）：
- `String ARG_TYPE = "type"`  L45
- `String TAG = "FragmentNewNormalAlbum"`  L46
- `Set<AlbumNewItemModel> dataSet`  L47
- `List<AlbumNewItemModel> mMediaData`  L48
- `Map<Integer, AlbumNewItemModel> mMediaSelectMap`  L49
- `int mType`  L50
- `int i = msg.what`  L55
- `int i2 = 0`  L73
- `FragmentNewNormalAlbum fragmentNewNormalAlbum = FragmentNewNormalAlbum.this`  L101
- `String[] permissionList = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}`  L112
- `String[] permissionList1 = {PermissionConfig.READ_MEDIA_VIDEO, PermissionConfig.READ_MEDIA_IMAGES, PermissionConfig.READ_MEDIA_AUDIO}`  L113
- `int i = this.mType`  L160
- `MediaNewScanTask mediaNewScanTask`  L219
- `int i = this.mType`  L221
- `int i = 0`  L289
- `int i = 0`  L328
- `boolean z = false`  L445

方法（24）：
- `void handleMessage(Message msg)`  L53 @Override
- `FragmentNewNormalAlbum newFragment(int type)`  L115
    - 体内字面量："type"
- `void onCreate(Bundle savedInstanceState)`  L124 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L132 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L137 @Override
    - 体内字面量："type" · "mType: " · "onViewCreated:  -----------------  æ¥è¯¢åªä½åº   "
- `void onStateChanged(LifecycleOwner source, Lifecycle.Event event)`  L147 @Override
    - 体内字面量："onResume-onStateChanged: " · "onPause-onStateChanged: "
- `void onResume()`  L158 @Override
- `void onStart()`  L173 @Override
- `void onPause()`  L178 @Override
    - 体内字面量："onPause: "
- `void onStop()`  L186 @Override
- `void onDestroy()`  L191 @Override
- `void setUserVisibleHint(boolean isVisibleToUser)`  L197 @Override
    - 体内字面量："123->" · "===========isVisibleToUser() " · "  " · "123->" · "===========isVisibleToUser()  mMediaData "
- `void refresh()`  L213
- `void queryData()`  L218
- `boolean checkPermission()`  L233
- `void onScanResultCallback(List<AlbumNewItemModel> data)`  L241 @Override
    - 体内字面量："onScanResultCallbackï¼è·åå°æ¬å°åªä½æ°æ®ï¼æ°æ®é¿åº¦æ¯ï¼  "
- `int compare(AlbumNewItemModel o1, AlbumNewItemModel o2)`  L267 @Override
- `void onCommonClick(int position)`  L281 @Override
- `void batchClick(List<Integer> clickPositions, int sectionIndex, String choice)`  L319 @Override
    - 体内字面量："BatchSelect onClick: " · "\n sectionIndex: " · "\n choice: "
- `void onMessageEvent(MessageEvent messageEvent)`  L366 @Subscribe(threadMode = ThreadMode.MAIN)
- `void onReceiveMessageEvent(MessageFileEvent messageFileEvent)`  L373 @Override
- `void onClick(View v)`  L397 @Override
- `void onClick(View v)`  L405 @Override
- `void deleteFiles(ArrayList<AlbumNewItemModel> items)`  L479
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Interface.MultiItemNewTypeSupport`
L4 · [interface] public MultiItemNewTypeSupport · `com/gku/actioncam/sigmastar/newUi/album/Ui/Interface/MultiItemNewTypeSupport.java`

方法（2）：
- `int getItemViewType(int position, T t)`  L5
- `int getLayoutId(int itemType)`  L7
### `com.gku.actioncam.sigmastar.newUi.album.Ui.Interface.SectionNewSupport`
L4 · [interface] public SectionNewSupport · `com/gku/actioncam/sigmastar/newUi/album/Ui/Interface/SectionNewSupport.java`

方法（4）：
- `String getTitle(T t)`  L5
- `int sectionHeaderLayoutId()`  L7
- `int sectionTitleBatchSelectId()`  L9
- `int sectionTitleTextViewId()`  L11
### `com.gku.actioncam.sigmastar.newUi.album.Ui.PopupWindow.SelectPopupWindow`
L17 · [class] public SelectPopupWindow · extends `PopupWindow` · `com/gku/actioncam/sigmastar/newUi/album/Ui/PopupWindow/SelectPopupWindow.java`

字段/常量（2）：
- `ImageView img_favorites`  L18
- `ImageView imageView = this.img_favorites`  L94

方法（7）：
- `public SelectPopupWindow(Context context, final OnImageViewClickListener onImageViewClickListener)`  L32
- `void onClick(View v)`  L43 @Override
- `void onClick(View v)`  L49 @Override
- `void onClick(View v)`  L61 @Override
- `void onClick(View v)`  L70 @Override
- `void onClick(View v)`  L79 @Override
- `void refreshFavorite(int resId)`  L93
### `com.gku.actioncam.sigmastar.newUi.album.Ui.PopupWindow.SelectPopupWindow$OnImageViewClickListener`
L20 · [interface] public OnImageViewClickListener · `com/gku/actioncam/sigmastar/newUi/album/Ui/PopupWindow/SelectPopupWindow.java`

方法（5）：
- `void OnDeleteClick()`  L21
- `void OnFavoritesClick()`  L23
- `void onDeleteYUTUproClick(BottomButtomItem bottomButtomItem)`  L25
- `void onFavoritesYUTUproClick(BottomButtomItem bottomButtomItem)`  L27
- `void onShareYUTUproClick(BottomButtomItem bottomButtomItem)`  L29
### `com.gku.actioncam.sigmastar.newUi.album.Utils.FavoriteDatabaseHelper`
L20 · [class] public FavoriteDatabaseHelper · extends `SQLiteOpenHelper` · `com/gku/actioncam/sigmastar/newUi/album/Utils/FavoriteDatabaseHelper.java`

字段/常量（16）：
- `String TAG = "FavoriteDatabaseHelper"`  L21
- `String FAVORITE_SET`  L22
- `String PLAYBACK_SET`  L23
- `Context mContext`  L24
- `Handler mHandler`  L25
- `String mName`  L26
- `int mVersion`  L27
- `AlbumNewItemModel albumNewItemModel2`  L113
- `SSFileInfoBean sSFileInfoBean2`  L133
- `SSFileInfoBean sSFileInfoBean3`  L134
- `Cursor cursor = null`  L136
- `SSFileInfoBean sSFileInfoBean4 = null`  L138
- `AlbumNewItemModel albumNewItemModel2`  L254
- `AlbumNewItemModel albumNewItemModel3`  L255
- `Cursor cursor = null`  L257
- `AlbumNewItemModel albumNewItemModel4 = null`  L259

方法（17）：
- `public FavoriteDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)`  L29
    - 体内字面量："create table Favorite(id integer primary key autoincrement,path text,addDate integer,type integer,isCollect integer)" · "create table Playback(id integer primary key autoincrement,path text,createTime text,videoTime text)"
- `void insertFavoriteAlbumSet(Set<AlbumNewItemModel> albumNewItemModelSet)`  L39
    - 体内字面量："insert into Favorite(path, addDate, type, isCollect) values(?, ?, ?, ?)"
- `void insertPlaybackSet(Set<SSFileInfoBean> ssFileInfoBeanSet)`  L47
    - 体内字面量："insert into Playback(path, createTime, videoTime) values(?, ?, ?)"
- `void delFavoriteAlbumSet(Set<AlbumNewItemModel> albumNewItemModelSet)`  L55
    - 体内字面量："delete from Favorite where path = ?"
- `void delPlaybackSet(Set<SSFileInfoBean> ssFileInfoBeanSet)`  L64
    - 体内字面量："delete from Playback where path = ?"
- `void updateFavoriteAlbumSet(AlbumNewItemModel albumNewItemModel, int isCollect)`  L73
    - 体内字面量："isCollect" · "Favorite" · "path = ?"
- `Set<AlbumNewItemModel> findAllFavoriteAlbumSet()`  L80
    - 体内字面量："select * from Favorite" · "addDate" · "type"
- `Set<SSFileInfoBean> findAllPlaybackSet()`  L96
    - 体内字面量："select * from Playback" · "createTime" · "videoTime"
- `AlbumNewItemModel findSingleFavorite(AlbumNewItemModel albumNewItemModel)`  L112
- `SSFileInfoBean findSinglePlayback(SSFileInfoBean sSFileInfoBean)`  L132
- `Set<AlbumNewItemModel> findAllFavoriteFromAlbum()`  L234
    - 体内字面量："select * from Favorite where isCollect = 1" · "addDate" · "type"
- `AlbumNewItemModel findSingleFavoriteAlbum(AlbumNewItemModel albumNewItemModel)`  L253
- `void onCreate(SQLiteDatabase db)`  L356 @Override
    - 体内字面量："create table Favorite(id integer primary key autoincrement,path text,addDate integer,type integer,isCollect integer)" · "create table Playback(id integer primary key autoincrement,path text,createTime text,videoTime text)"
- `void run()`  L361 @Override
- `void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)`  L367 @Override
    - 体内字面量："create table Playback(id integer primary key autoincrement,path text,createTime text,videoTime text)"
- `void run()`  L374 @Override
    - 体内字面量："Database onUpgradeï¼" · " ââ version: " · " has Created successfully!" · "drop table if exists Playback"
- `void run()`  L382 @Override
    - 体内字面量："Database onUpgradeï¼" · " ââ version: " · " has Created successfully!"
### `com.gku.actioncam.sigmastar.newUi.album.Utils.FavoriteDatabaseUtils`
L9 · [class] public FavoriteDatabaseUtils · `com/gku/actioncam/sigmastar/newUi/album/Utils/FavoriteDatabaseUtils.java`

字段/常量（1）：
- `FavoriteDatabaseHelper favoriteDatabaseHelper`  L10

方法（13）：
- `private FavoriteDatabaseUtils()`  L12
    - 体内字面量："FavoriteStore.db"
- `FavoriteDatabaseUtils getInstance()`  L23
- `void insertFavoriteDataToDatabase(Set<AlbumNewItemModel> albumNewItemModelSet)`  L27
- `void deleteFavoriteDataFromDatabase(Set<AlbumNewItemModel> albumNewItemModelSet)`  L31
- `void updateFavoriteDataInSpecifiedRow(AlbumNewItemModel albumNewItemModel, int isCollect)`  L35
- `Set<AlbumNewItemModel> findFavoriteAllData()`  L39
- `AlbumNewItemModel findFavoriteSingleData(AlbumNewItemModel albumNewItemModel)`  L43
- `Set<AlbumNewItemModel> findAllFavoriteData()`  L47
- `boolean findSingleFavoriteAlbum(AlbumNewItemModel albumNewItemModel)`  L51
- `void insertPlaybackDataToDatabase(Set<SSFileInfoBean> ssFileInfoBeanSet)`  L55
- `void deletePlaybackDataFromDatabase(Set<SSFileInfoBean> ssFileInfoBeanSet)`  L59
- `Set<SSFileInfoBean> findPlaybackAllData()`  L63
- `SSFileInfoBean findPlaybackSingleData(SSFileInfoBean ssFileInfoBean)`  L67
### `com.gku.actioncam.sigmastar.newUi.album.Utils.FavoriteDatabaseUtils$SingleHolder`
L16 · [class] private static SingleHolder · `com/gku/actioncam/sigmastar/newUi/album/Utils/FavoriteDatabaseUtils.java`

方法（1）：
- `private SingleHolder()`  L19
### `com.gku.actioncam.sigmastar.newUi.album.Utils.FileNewUtils`
L39 · [class] public FileNewUtils · `com/gku/actioncam/sigmastar/newUi/album/Utils/FileNewUtils.java`

字段/常量（12）：
- `String TAG = "FileNewUtils"`  L40
- `?? r5`  L111
- `Uri uriWithAppendedId`  L112
- `Uri contentUri`  L113
- `Cursor cursorQuery`  L114
- `Uri contentUri2`  L115
- `Cursor cursorQuery2`  L116
- `?? r6 = 29`  L118
- `File externalCacheDir`  L216
- `Uri uriInsert`  L256
- `String str = absolutePath + "/Camera"`  L291
- `byte[] bArr = new byte[1024]`  L325

方法（20）：
- `private FileNewUtils()`  L42
- `FileNewUtils getInstance()`  L52
- `String getMediaPath()`  L56
    - 体内字面量："/" · "getMediaPath: "
- `boolean isFileExist(String path)`  L65
- `long getFreeSize(String path)`  L72
- `void delete(String path, Context mContext, int TYPE)`  L77
- `void updateMediaStore(final Context context, final String path)`  L81
- `void onScanCompleted(String path2, Uri uri)`  L84 @Override
    - 体内字面量："android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `void deleteMediaFromDCIM(String str, final Activity activity, Handler handler, int i)`  L110
- `void run()`  L184 @Override
- `void run()`  L197 @Override
- `void deleteFileList(Activity activity, List<Uri> uriList)`  L204
- `String getExternalCacheDirectory()`  L215
- `boolean isFileValid(String path)`  L231
- `InputStream path2InputStream(String path)`  L239
- `String getMimeType(File file)`  L251
- `void saveFileToDCIMCamera(Context context, File file)`  L255
- `boolean isVideo(String filename)`  L301
    - 体内字面量：".TS" · ".AVI" · ".MOV"
- `void createDirIfNotExist(String path)`  L306
- `void copyFile(File src, File dest)`  L318
### `com.gku.actioncam.sigmastar.newUi.album.Utils.FileNewUtils$singleInstance`
L45 · [class] private static singleInstance · `com/gku/actioncam/sigmastar/newUi/album/Utils/FileNewUtils.java`

方法（1）：
- `private singleInstance()`  L48
### `com.gku.actioncam.sigmastar.newUi.common.model.AmbaBTHeartbeatModel`
L13 · [class] public AmbaBTHeartbeatModel · implements `ISBTHeartbeatModel, IChannelListener` · `com/gku/actioncam/sigmastar/newUi/common/model/AmbaBTHeartbeatModel.java`

字段/常量（4）：
- `String TAG = "AmbaBTHeartbeatModel"`  L14
- `ISBTHeartbeatModelCallBack previewModelCallback`  L16
- `ISBTHeartbeatModelCallBack settingModelCallBack`  L17
- `String wifiSettingName`  L18

方法（5）：
- `public AmbaBTHeartbeatModel(ISBTHeartbeatModelCallBack settingModelCallBack, ISBTHeartbeatModelCallBack previewModelCallback)`  L20
- `void updateBTHeartbeat()`  L26 @Override
- `void failure(int code)`  L29 @Override
- `void success()`  L33 @Override
- `void onChannelEvent(int type, Object param, String... array)`  L39 @Override
    - 体内字面量："onChannelEvent---------type=" · "  param=" · "   array="
### `com.gku.actioncam.sigmastar.newUi.common.model.BTHeartbeatManage`
L10 · [class] public BTHeartbeatManage · `com/gku/actioncam/sigmastar/newUi/common/model/BTHeartbeatManage.java`

字段/常量（1）：
- `ISBTHeartbeatModel isBTHeartbeatModel`  L11

方法（2）：
- `public BTHeartbeatManage(ISBTHeartbeatModelCallBack isBTHeartbeatModelCallBack, ISBTHeartbeatModelCallBack previewModelCallback)`  L13
    - 体内字面量："CV75" · "S7"
- `ISBTHeartbeatModel getModel()`  L26
### `com.gku.actioncam.sigmastar.newUi.common.presenter.SBTHeartbeatPresenter`
L12 · [class] public SBTHeartbeatPresenter · `com/gku/actioncam/sigmastar/newUi/common/presenter/SBTHeartbeatPresenter.java`

字段/常量（2）：
- `String TAG = "SBTHeartbeatPresenter"`  L13
- `ISSetting settingView`  L14

方法（3）：
- `void setView(ISSetting setting, ISSPreviewNew preview)`  L18
- `public SBTHeartbeatPresenter(Activity activity)`  L21
- `void updateBTHeartbeat()`  L24
### `com.gku.actioncam.sigmastar.newUi.common.presenter.SBTHeartbeatPresenter$SBTHeartbeatModelCallBack`
L28 · [class] SBTHeartbeatModelCallBack · implements `ISBTHeartbeatModelCallBack` · `com/gku/actioncam/sigmastar/newUi/common/presenter/SBTHeartbeatPresenter.java`

方法（1）：
- `void updateBTHeartbeatSuccess()`  L30 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Activity.DeviceAddActivity`
L57 · [class] public DeviceAddActivity · extends `BaseActivity` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/DeviceAddActivity.java`

字段/常量（29）：
- `BLEManager bleManager`  L58
- `BluetoothGatt bluetoothGatt`  L59
- `BluetoothGattCharacteristic bluetoothGattCharacteristic`  L60
- `DeviceAddWaveFragment deviceAddWaveFragment`  L61
- `List<DeviceAddItem> deviceItemList`  L62
- `FrameLayout flDeviceAdd`  L63
- `List<Fragment> fragments`  L64
- `MyGridLayoutManager gridLayoutManager`  L65
- `ImageView ivDeviceAdd`  L66
- `List<BluetoothGattService> list`  L67
- `BluetoothPagerAdapter mAdapter`  L68
- `BluetoothAdapter mBluetoothAdapter`  L69
- `Map<String, BluetoothGatt> mBluetoothGattMap`  L70
- `BluetoothUtils mBluetoothUtils`  L71
- `BluetoothDevice mDevice`  L72
- `List<BluetoothDevice> mDeviceList`  L73
- `BluetoothLeDeviceStore mDeviceStore`  L74
- `Handler mainHandler`  L75
- `String max2`  L76
- `RecyclerView rvDeviceAdd`  L77
- `TextView tvDeviceAdd`  L78
- `ViewPager2 vpDeviceAdd`  L79
- `String TAG = "DeviceAddActivity"`  L80
- `int i = 0`  L83
- `int i2 = i + 1`  L86
- `int i3 = scanRecord[i] & 255`  L87
- `String str = permissions[i]`  L200
- `BLEManager bLEManager = this.bleManager`  L254
- `BLEManager bLEManager = this.bleManager`  L269

方法（35）：
- `String parseDeviceName(byte[] scanRecord)`  L82
- `void onScanResult(int callbackType, ScanResult result)`  L109 @Override
    - 体内字面量："android.permission.BLUETOOTH_CONNECT" · "èçæ«æï¼" · " åç§°ï¼" · "XTU" · "GKU" · "åç°è®¾å¤ï¼" · " åç§°ï¼" · "æ«æç»æä¸ºç©ºï¼å¿½ç¥"
- `void onBatchScanResults(List<ScanResult> results)`  L138 @Override
- `void onScanFailed(int errorCode)`  L143 @Override
- `void onReceiveEvent(UpdateEvent event)`  L149 @Subscribe(threadMode = ThreadMode.MAIN)
- `void startDeviceAddActivity(Context context)`  L152
- `void onCreate(Bundle savedInstanceState)`  L157 @Override
- `void onClick(View v)`  L188 @Override
- `void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)`  L195 @Override
- `void showPermissionRequestDialog(String permission)`  L216
- `void onClick(DialogInterface dialog, int id)`  L220 @Override
    - 体内字面量："android.settings.APPLICATION_DETAILS_SETTINGS"
- `void onClick(DialogInterface dialog, int id)`  L230 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L240 @Override
    - 体内字面量："onActivityResult: "
- `void startScan()`  L253
- `void onResume()`  L262 @Override
- `void onPause()`  L267 @Override
- `void onDestroy()`  L276 @Override
- `void initDeviceItemList()`  L280
- `void onClick(int position)`  L305 @Override
    - 体内字面量："deviceName"
- `List<BluetoothDevice> getDeviceList()`  L314
- `TextView getTvDeviceAdd()`  L318
- `Handler getMainHandler()`  L322
- `BluetoothLeDeviceStore getDeviceStore()`  L326
- `boolean checkIsBleState()`  L330
- `void showNotSupportDialog()`  L342
- `void onClick(DialogInterface dialog, int which)`  L345 @Override
- `void showOpenBleDialog()`  L352
- `void onClick(DialogInterface dialog, int which)`  L355 @Override
- `void onClick(DialogInterface dialog, int which)`  L361 @Override
- `void showReOpenLocationDialog()`  L368
- `void onClick(DialogInterface dialog, int which)`  L371 @Override
- `void onClick(DialogInterface dialog, int which)`  L377 @Override
- `void showOpenLocationSettingDialog()`  L383
- `void onClick(DialogInterface dialog, int which)`  L386 @Override
- `void onClick(DialogInterface dialog, int which)`  L392 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Activity.DeviceAddNewActivity`
L59 · [class] public DeviceAddNewActivity · extends `BaseBTPopupActivity` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/DeviceAddNewActivity.java`

字段/常量（26）：
- `String CALLBACK_SCANWIFI_RESULT_FOR_THIS = "DeviceAddNewActivity"`  L60
- `int CODE_SCAN_WIFI = 321`  L61
- `BluetoothGatt bluetoothGatt`  L62
- `BluetoothGattCharacteristic bluetoothGattCharacteristic`  L63
- `List<DeviceAddItem> deviceItemList`  L64
- `FrameLayout flDeviceAdd`  L65
- `List<Fragment> fragments`  L66
- `MyGridLayoutManager gridLayoutManager`  L67
- `IconTextView itBluetooth`  L68
- `IconTextView itHandle`  L69
- `IconTextView itScan`  L70
- `ImageView ivDeviceAdd`  L71
- `List<BluetoothGattService> list`  L72
- `BluetoothPagerAdapter mAdapter`  L73
- `BluetoothAdapter mBluetoothAdapter`  L74
- `BluetoothDevice mDevice`  L75
- `BluetoothLeDeviceStore mDeviceStore`  L76
- `Handler mainHandler`  L77
- `String max2`  L78
- `ProgressDialog progressDialog`  L79
- `RecyclerView rvDeviceAdd`  L80
- `TextView tvDeviceAdd`  L81
- `String TAG = CALLBACK_SCANWIFI_RESULT_FOR_THIS`  L82
- `boolean jumped = false`  L83
- `String str = permissions[i]`  L224
- `String stringExtra = "<binary/metadata>"`  L253

方法（35）：
- `void onReceiveEvent(UpdateEvent event)`  L86 @Subscribe(threadMode = ThreadMode.MAIN)
- `void startDeviceAddActivity(Context context)`  L89
- `void onCreate(Bundle savedInstanceState)`  L94 @Override
- `void callback(Object o)`  L113 @Override
- `void onClick(View view)`  L120 @Override
- `void onClick(View view)`  L126 @Override
- `void onClick(View view)`  L140 @Override
    - 体内字面量："android.settings.WIFI_SETTINGS"
- `void onClick(View v)`  L149 @Override
- `void addNetworkCallback()`  L155
- `void onAppStart()`  L158 @Override
- `void onAppStop()`  L162 @Override
- `void onCurrentLifecycleOwnerDestroy()`  L166 @Override
- `void onLost()`  L170 @Override
- `void onAvailable()`  L174 @Override
- `void run()`  L177 @Override
    - 体内字面量："networkCallback-onAvailable> è¿æ¥å°çipï¼" · "192.168.0.1" · "networkCallback onAvailableå·²è¿æ¥çç½ç»æ¯ç¸æºï¼"
- `void run()`  L194 @Override
- `void onUnavailable(boolean scan)`  L212 @Override
- `void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)`  L219 @Override
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L241 @Override
    - 体内字面量："onActivityResult: "
- `void initDeviceItemList()`  L268
- `void onClick(int position)`  L296 @Override
    - 体内字面量："deviceName"
- `TextView getTvDeviceAdd()`  L305
- `Handler getMainHandler()`  L309
- `BluetoothLeDeviceStore getDeviceStore()`  L313
- `void showReOpenLocationDialog()`  L318
- `void onClick(DialogInterface dialog, int which)`  L321 @Override
- `void onClick(DialogInterface dialog, int which)`  L327 @Override
- `void showOpenLocationSettingDialog()`  L333
- `void onClick(DialogInterface dialog, int which)`  L336 @Override
- `void onClick(DialogInterface dialog, int which)`  L342 @Override
- `void jumpToPreviewActivity()`  L350 @Override
    - 体内字面量："jumpToPreviewActivity: not activated, drop this jump" · "jumpToPreviewActivityï¼"
- `void run()`  L366 @Override
- `void run()`  L374 @Override
    - 体内字面量："jumpToPreviewActivity: "
- `void lambda$jumpToPreviewActivity$0()`  L384
- `void lambda$jumpToPreviewActivity$1()`  L389
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Activity.UserGuideActivity`
L23 · [class] public UserGuideActivity · extends `BaseActivity` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Activity/UserGuideActivity.java`

字段/常量（14）：
- `String TAG = "UserGuideActivity"`  L24
- `int curPage = 0`  L25
- `TextView layoutTitleUser`  L26
- `Context mContext`  L27
- `PhotoPagerAdapter mPhotoPagerAdapter`  L28
- `ViewPager mViewPager`  L29
- `Button nextBtn`  L30
- `TextView pageContent`  L31
- `TextView pageTitle`  L32
- `Button previousBtn`  L33
- `ArrayList<Integer> arrayList`  L37
- `int i = this.curPage`  L134
- `int i = this.curPage`  L145
- `int i = this.curPage`  L169

方法（15）：
- `void onCreate(Bundle savedInstanceState)`  L36 @Override
- `void onClick(View view)`  L49 @Override
- `void onClick(View view)`  L55 @Override
- `void onClick(View view)`  L61 @Override
    - 体内字面量："deviceName"
- `void onPageScrollStateChanged(int state)`  L89 @Override
- `void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)`  L93 @Override
- `void onPageSelected(int position)`  L97 @Override
- `void lambda$onCreate$0(View view)`  L128
- `void lambda$onCreate$1(View view)`  L133
- `void lambda$onCreate$2(View view)`  L144
- `void onActivityResult(int requestCode, int resultCode, Intent data)`  L153 @Override
    - 体内字面量："deviceName"
- `void onResume()`  L159 @Override
    - 体内字面量："192.168.0.1" · "XTUMax2"
- `void setView()`  L167
- `boolean isOutChina()`  L197
- `String guessDeviceIP()`  L201
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Adapter.BluetoothPagerAdapter`
L9 · [class] public BluetoothPagerAdapter · extends `FragmentStateAdapter` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/BluetoothPagerAdapter.java`

字段/常量（1）：
- `List<Fragment> fragments`  L10

方法（3）：
- `public BluetoothPagerAdapter(FragmentActivity fragmentActivity, List<Fragment> fragments)`  L12
- `Fragment createFragment(int position)`  L18 @Override
- `int getItemCount()`  L23 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Adapter.DeviceAddRecycleAdapter`
L14 · [class] public DeviceAddRecycleAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/DeviceAddRecycleAdapter.java`

字段/常量（3）：
- `List<DeviceAddItem> deviceAddItemList`  L15
- `OnItemClickListener onItemClickListener`  L16
- `List<DeviceAddItem> list = this.deviceAddItemList`  L50

方法（6）：
- `void setItemClick(OnItemClickListener onItemClickListener)`  L22
- `public DeviceAddRecycleAdapter(List<DeviceAddItem> deviceAddItemList)`  L26
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L31 @Override
- `void onBindViewHolder(ViewHolder holder, final int position)`  L36 @Override
- `void onClick(View v)`  L42 @Override
- `int getItemCount()`  L49 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Adapter.DeviceAddRecycleAdapter$OnItemClickListener`
L18 · [interface] public OnItemClickListener · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/DeviceAddRecycleAdapter.java`

方法（1）：
- `void onClick(int position)`  L19
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Adapter.DeviceAddRecycleAdapter$ViewHolder`
L57 · [class] static ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/DeviceAddRecycleAdapter.java`

字段/常量（2）：
- `ImageView itemImage`  L58
- `TextView itemText`  L59

方法（1）：
- `public ViewHolder(View itemView)`  L61
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Adapter.PhotoPagerAdapter`
L14 · [class] public PhotoPagerAdapter · extends `PagerAdapter` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/PhotoPagerAdapter.java`

字段/常量（2）：
- `List<Integer> mPictureList`  L15
- `List<Integer> list = this.mPictureList`  L23

方法（5）：
- `public PhotoPagerAdapter(List<Integer> pictureList)`  L17
- `int getCount()`  L22 @Override
- `boolean isViewFromObject(View view, Object object)`  L31 @Override
- `Object instantiateItem(ViewGroup container, int position)`  L36 @Override
- `void destroyItem(ViewGroup container, int position, Object object)`  L48 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Adapter.ScanAddRecycleAdapter`
L17 · [class] public ScanAddRecycleAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/ScanAddRecycleAdapter.java`

字段/常量（7）：
- `ProgressBar connectProgress`  L18
- `List<BluetoothDevice> mDeviceList`  L19
- `List<String> mDeviceNameList`  L20
- `int mPatredDeviceNum = -1`  L21
- `OnScanItemClickListener onScanItemClickListener`  L22
- `int i = this.mPatredDeviceNum`  L47
- `List<BluetoothDevice> list = this.mDeviceList`  L134

方法（9）：
- `void showProgressBar(int show)`  L24
- `void setOnClickListener(OnScanItemClickListener onScanItemClickListener)`  L27
- `public ScanAddRecycleAdapter(List<BluetoothDevice> mDeviceList)`  L31
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L36 @Override
- `void onBindViewHolder(final ViewHolder holder, final int position)`  L41 @Override
- `void onClick(View v)`  L66 @Override
- `int getImageByDeviceName(String deviceName)`  L73
    - 体内字面量："_" · "XTUX1" · "XTUX2" · "XTUX2" · "XTUS5K" · "XTUs3pro" · "XTUmaxpro" · "XTUmax2" · "XTUmax3" · "XTUs6" · "XTUx3" · "XTUmini1" · "XTUs6pro" · "XTUr1" · "XTUs7" · "XTUs7pro" · "XTUs7promax"
- `int getItemCount()`  L133 @Override
- `void setPatredDeviceNum(int index)`  L160
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Adapter.ScanAddRecycleAdapter$ViewHolder`
L141 · [class] ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Adapter/ScanAddRecycleAdapter.java`

字段/常量（6）：
- `ImageView Image`  L142
- `ProgressBar connectLoading`  L143
- `TextView device_name`  L144
- `TextView device_pwd`  L145
- `TextView device_ssid`  L146
- `TextView paired_status`  L147
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.base.BaseActivateActivity`
L22 · [class] public abstract BaseActivateActivity · extends `BaseBTPopupActivity` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BaseActivateActivity.java`

字段/常量（11）：
- `String TAG = "BaseActivateActivity"`  L23
- `ActivateCallBack activateCallBack`  L24
- `int activatingStatus = -1`  L25
- `Activity activityTop`  L26
- `Activity curActivity`  L27
- `Dialog dialog`  L28
- `BaseActivateActivity baseActivateActivity = BaseActivateActivity.this`  L71
- `Activity activity = resumedActivity`  L82
- `String str = TAG`  L83
- `Dialog dialog = this.dialog`  L85
- `Dialog dialog = this.dialog`  L205

方法（12）：
- `void onCreate(Bundle savedInstanceState)`  L37 @Override
- `void onActivityCreated(Activity activity, Bundle bundle)`  L41 @Override
- `void onActivityDestroyed(Activity activity)`  L45 @Override
- `void onActivityPaused(Activity activity)`  L49 @Override
- `void onActivitySaveInstanceState(Activity activity, Bundle bundle)`  L53 @Override
- `void onActivityStarted(Activity activity)`  L57 @Override
- `void onActivityStopped(Activity activity)`  L61 @Override
- `void onActivityResumed(Activity activity)`  L65 @Override
    - 体内字面量："onActivityResumed: " · "\n" · "\n"
- `void popupActivate(final ActivateCallBack activateCallBack, Activity resumedActivity)`  L78
- `void onClick(View view)`  L128 @Override
- `void run()`  L133 @Override
- `void dismissActivate()`  L204
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.base.BaseActivateActivity$ActivateCallBack`
L30 · [interface] public ActivateCallBack · `com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BaseActivateActivity.java`

方法（2）：
- `boolean onActivate()`  L31
- `void onTrial()`  L33
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.base.BaseActivateActivity$AnonymousClass3`
L153 · [class] AnonymousClass3 · implements `View.OnClickListener` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BaseActivateActivity.java`

字段/常量（6）：
- `ActivateCallBack val$activateCallBack`  L154
- `Activity val$activity`  L155
- `Button val$btn_activate`  L156
- `Button val$btn_trial`  L157
- `ScrollView val$sv_activate_content`  L158
- `TextView val$tv_activated_content`  L159

方法（3）：
- `void onClick(View view)`  L171 @Override
- `void run()`  L177 @Override
- `void run()`  L183 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.base.BaseBTPopupActivity`
L33 · [class] public abstract BaseBTPopupActivity · extends `BasePermissionActivity implements DeviceAddBottomSheetDialogFragment.OnDismissListener` · implements `DeviceAddBottomSheetDialogFragment.OnDismissListener` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BaseBTPopupActivity.java`

字段/常量（19）：
- `BLEManager bleManager`  L34
- `DeviceAddBottomSheetDialogFragment deviceAddBottomSheetDialogFragment`  L35
- `BluetoothUtils mBluetoothUtils`  L36
- `List<BluetoothDevice> mDeviceList`  L37
- `Handler mHandler`  L38
- `String TAG = "BaseBTPopupActivity"`  L39
- `boolean mShouldPopup = true`  L40
- `boolean resumeFromScan = false`  L41
- `boolean mNeverPopupAfterResume = true`  L42
- `boolean mScanNew = false`  L43
- `boolean needAutoScan = true`  L44
- `boolean mShouldHandleAvailable = false`  L45
- `long mLastPopup = 0`  L47
- `int i = 0`  L50
- `int i2 = i + 1`  L53
- `int i3 = scanRecord[i] & 255`  L54
- `BLEManager bLEManager = this.bleManager`  L193
- `BLEManager bLEManager = this.bleManager`  L208
- `DeviceAddBottomSheetDialogFragment deviceAddBottomSheetDialogFragment = this.deviceAddBottomSheetDialogFragment`  L281

方法（27）：
- `String parseDeviceName(byte[] scanRecord)`  L49
- `void onScanResult(int callbackType, ScanResult result)`  L76 @Override
    - 体内字面量："android.permission.BLUETOOTH_CONNECT" · "xs, " · "ç¼ºå°æé" · "xtu_s7pro" · "xs, " · "åç°è®¾å¤ï¼" · " åç§°ï¼" · "xs, " · "æ«æç»æä¸ºç©ºï¼å¿½ç¥"
- `void onBatchScanResults(List<ScanResult> results)`  L112 @Override
- `void onScanFailed(int errorCode)`  L117 @Override
    - 体内字面量："xs, " · "onScanFailedï¼"
- `void jumpToPreviewActivity()`  L123
- `void setmShouldHandleAvailable(boolean b)`  L125
- `boolean getmShouldHandleAvailable()`  L129
- `void onCreate(Bundle savedInstanceState)`  L134 @Override
- `void popupBottomSheet(Boolean isNeedLive)`  L145
    - 体内字面量："shareBottomSheet"
- `boolean checkIsBleState()`  L158
- `void showNotSupportDialog()`  L166
- `void onClick(DialogInterface dialog, int which)`  L169 @Override
- `void showOpenBleDialog()`  L176
- `void onClick(DialogInterface dialog, int which)`  L179 @Override
- `void onClick(DialogInterface dialog, int which)`  L185 @Override
- `void startScan()`  L191
    - 体内字面量："xs, " · "startScan"
- `void onPause()`  L201 @Override
- `void stopScan()`  L206
    - 体内字面量："xs, " · "stopScan"
- `List<BluetoothDevice> getDeviceList()`  L214
- `void close()`  L218
- `void resetBT()`  L223
- `void onResume()`  L228 @Override
    - 体内字面量："onResume" · "xs, " · "onResume:  got permission, start scan."
- `void onDismiss()`  L248
    - 体内字面量："fragment onDismissï¼å°è¯å³é­èçè¿æ¥"
- `void onDestroy()`  L257 @Override
    - 体内字面量："xs, " · "Activity onDestroyï¼å°è¯å³é­èçè¿æ¥"
- `void tryToJump()`  L266
- `void run()`  L270 @Override
    - 体内字面量："xs, " · "æ£æµå°ç¸æºç½ç»ï¼ç¡®è®¤éè¦è·³è½¬ï¼åå¤å³é­èçè¿æ¥"
- `void dismiss()`  L280
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.base.BaseDialog`
L11 · [class] public BaseDialog · extends `Dialog` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BaseDialog.java`

字段/常量（1）：
- `AppCompatActivity appCompatActivity`  L12

方法（11）：
- `public BaseDialog(AppCompatActivity appCompatActivity)`  L14
- `public BaseDialog(AppCompatActivity appCompatActivity, int themeResId)`  L18
- `void show()`  L29 @Override
- `BaseDialog contentView(int layoutResID)`  L36
- `BaseDialog contentView(View view)`  L41
- `BaseDialog contentView(View view, ViewGroup.LayoutParams params)`  L46
- `BaseDialog layoutParams(ViewGroup.LayoutParams params)`  L51
- `BaseDialog canceledOnTouchOutside(boolean canceledOnTouchOutside)`  L56
- `BaseDialog gravity(int gravity)`  L61
- `BaseDialog offset(int x, int y)`  L66
- `BaseDialog dimAmount(float dimAmount)`  L73
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.base.BasePermissionActivity`
L17 · [class] public abstract BasePermissionActivity · extends `FragmentActivity` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/base/BasePermissionActivity.java`

字段/常量（11）：
- `String[] btPermissionList = {"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"}`  L18
- `String[] wifiPermissionList = {"android.permission.ACCESS_COARSE_LOCATION", PermissionUtils.LOCATION}`  L19
- `String[] btPermissionList1 = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"}`  L20
- `String[] wifiPermissionList1 = {"android.permission.ACCESS_COARSE_LOCATION", PermissionUtils.LOCATION}`  L21
- `String string`  L24
- `String[] strArr = wifiPermissionList`  L41
- `String[] strArr2 = btPermissionList`  L46
- `String[] strArr3 = wifiPermissionList1`  L52
- `String[] strArr4 = btPermissionList1`  L57
- `int i = 0`  L70
- `int i2 = i + 1`  L73

方法（3）：
- `boolean fetchPermission(final Activity activity, boolean request)`  L23
- `void onClick(DialogInterface dialog, int which)`  L86 @Override
- `void onClick(DialogInterface dialog, int which)`  L96 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.BLEManager`
L18 · [class] public BLEManager · `com/gku/actioncam/sigmastar/newUi/deviceAdd/BLEManager.java`

字段/常量（11）：
- `String TAG = "BLEManager"`  L19
- `long lastTimeStartScan`  L20
- `Object locker`  L21
- `BluetoothAdapter mBluetoothAdapter`  L22
- `BluetoothLeScanner mBluetoothLeScanner`  L23
- `BluetoothManager mBluetoothManager`  L24
- `BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter`  L65
- `LifecycleOwner lifecycleOwner`  L77
- `BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter`  L93
- `BluetoothLeScanner bluetoothLeScanner`  L100
- `BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter`  L101

方法（11）：
- `private BLEManager()`  L26
- `BLEManager getInstance()`  L38
- `Object getLocker()`  L42
- `BluetoothManager getBluetoothManager()`  L46
- `BluetoothAdapter getBluetoothAdapter()`  L50
- `void initBle(Activity activity)`  L54
    - 体内字面量："bluetooth"
- `void startScan(ScanCallback scanCallback)`  L64
- `void startScan(final LifecycleOwner owner, final ScanCallback scanCallback, final BluetoothUtils mBluetoothUtils)`  L71
    - 体内字面量："startScan: delay " · " ms"
- `void run()`  L76 @Override
- `void startLeScan(BluetoothAdapter.LeScanCallback leScanCallback)`  L92
- `void stopScan(ScanCallback scanCallback)`  L99
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.BLEManager$SingletonHolder`
L31 · [class] private static SingletonHolder · `com/gku/actioncam/sigmastar/newUi/deviceAdd/BLEManager.java`

方法（1）：
- `private SingletonHolder()`  L34
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Data.UserGuideItemModel`
L4 · [class] public UserGuideItemModel · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Data/UserGuideItemModel.java`
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.DeviceAddItem`
L4 · [class] public DeviceAddItem · `com/gku/actioncam/sigmastar/newUi/deviceAdd/DeviceAddItem.java`

字段/常量（2）：
- `int imageId`  L5
- `String imageName`  L6

方法（3）：
- `public DeviceAddItem(int imageId, String imageName)`  L8
- `int getImageId()`  L13
- `String getImageName()`  L17
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.DeviceAddRecycleAdapter`
L13 · [class] public DeviceAddRecycleAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/DeviceAddRecycleAdapter.java`

字段/常量（3）：
- `List<DeviceAddItem> deviceAddItemList`  L14
- `OnItemClickListener onItemClickListener`  L15
- `List<DeviceAddItem> list = this.deviceAddItemList`  L46

方法（5）：
- `public DeviceAddRecycleAdapter(List<DeviceAddItem> deviceAddItemList, OnItemClickListener onItemClickListener)`  L21
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L27 @Override
- `void onBindViewHolder(ViewHolder holder, int position)`  L32 @Override
- `void onClick(View v)`  L38 @Override
- `int getItemCount()`  L45 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.DeviceAddRecycleAdapter$OnItemClickListener`
L17 · [interface] OnItemClickListener · `com/gku/actioncam/sigmastar/newUi/deviceAdd/DeviceAddRecycleAdapter.java`

方法（1）：
- `void onClick()`  L18
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.DeviceAddRecycleAdapter$ViewHolder`
L53 · [class] static ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/DeviceAddRecycleAdapter.java`

字段/常量（2）：
- `ImageView itemImage`  L54
- `TextView itemText`  L55

方法（1）：
- `public ViewHolder(View itemView)`  L57
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.DiffuseView2`
L16 · [class] public DiffuseView2 · extends `View` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/DiffuseView2.java`

字段/常量（15）：
- `List<Integer> mAlphas`  L17
- `Canvas mCanvas`  L18
- `int mColor`  L19
- `Context mContext`  L20
- `int mCoreColor`  L21
- `float mCoreRadius`  L22
- `int mDiffuseSpeed`  L23
- `int mDiffuseWidth`  L24
- `boolean mIsDiffuse`  L25
- `Integer mMaxWidth`  L26
- `Paint mPaint`  L27
- `List<Integer> mWidths`  L28
- `int i = 0`  L88
- `List<Integer> list = this.mWidths`  L106
- `Canvas canvas = this.mCanvas`  L137

方法（18）：
- `public DiffuseView2(Context context)`  L30
- `public DiffuseView2(Context context, AttributeSet attrs)`  L34
- `public DiffuseView2(Context context, AttributeSet attrs, int defStyleAttr)`  L38
- `void init()`  L59
- `void invalidate()`  L71 @Override
- `void onWindowFocusChanged(boolean hasWindowFocus)`  L78 @Override
- `void onDraw(Canvas canvas)`  L84 @Override
- `void start()`  L118
- `void reStart()`  L123
- `void stop()`  L129
- `void clearContent()`  L136
- `boolean isDiffuse()`  L143
- `void setColor(int colorId)`  L147
- `void setCoreColor(int colorId)`  L151
- `void setCoreRadius(int radius)`  L155
- `void setDiffuseWidth(int width)`  L159
- `void setMaxWidth(int maxWidth)`  L163
- `void setDiffuseSpeed(int speed)`  L167
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.BLEConnectUtils`
L42 · [class] public BLEConnectUtils · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java`

字段/常量（30）：
- `int CHUNK_SIZE = 100`  L43
- `String TAG = "BLEConnectUtils"`  L44
- `long TIMEOUT_MS = 1000`  L45
- `BLEConnectUtils sInstance`  L46
- `String backString`  L47
- `BluetoothGatt bluetoothGatt`  L48
- `BluetoothGattCharacteristic bluetoothGattCharacteristic`  L49
- `DeviceAddKeyItem deviceAddKeyItem`  L50
- `boolean isAutoLive`  L51
- `boolean isNeedLive`  L52
- `List<BluetoothGattService> list`  L53
- `BLEConnectbacks mConnectView`  L54
- `BLEKeyCallbacks mKeyView`  L55
- `BLEListCallbacks mListView`  L56
- `BluetoothGattCharacteristic mPairedCharacteristic`  L57
- `BluetoothGatt mPairedGatt`  L58
- `BLELiveStatusCallback onLiveStatusCallback`  L59
- `Runnable timeoutRunnable`  L60
- `String curBluName = "<binary/metadata>"`  L62
- `boolean isCapabilityReceived = false`  L65
- `boolean hasValidCapability = false`  L66
- `boolean closeManually = false`  L67
- `ConnectStatus curStatus = ConnectStatus.Listing`  L70
- `Runnable runnable = this.timeoutRunnable`  L216
- `BLEKeyCallbacks bLEKeyCallbacks = this.mKeyView`  L237
- `BLEListCallbacks bLEListCallbacks = this.mListView`  L241
- `int i = 0`  L307
- `int i2 = i + length`  L309
- `BLEListCallbacks bLEListCallbacks = this.mListView`  L390
- `BLEConnectbacks bLEConnectbacks = this.mConnectView`  L394

方法（47）：
- `BLEConnectUtils getInstance()`  L115
- `private BLEConnectUtils()`  L126
- `void setAutoLive(boolean autoLive)`  L129
- `void setNeedLive(boolean isNeedLive)`  L133
- `boolean isNeedLive()`  L137
- `void setCurBluName(String bluName)`  L141
- `void subscribe(BLEListCallbacks bleListCallbacks)`  L145
- `void unsubscribe(BLEListCallbacks bleListCallbacks)`  L149
- `void subscribe(BLEKeyCallbacks bleKeyCallbacks)`  L153
- `void unsubscribe(BLEKeyCallbacks bleKeyCallbacks)`  L157
- `void subscribe(BLEConnectbacks bleConnectbacks)`  L161
- `void unsubscribe(BLEConnectbacks bleConnectbacks)`  L165
- `void startConnect()`  L169
- `void onPermissionHave()`  L174 @Override
    - 体内字面量："R003_" · "xs, " · "startConnect:   writeCharacteristic  R003_  = " · ":" · "R001_" · "startConnect:   writeCharacteristic  " · ":" · "startConnect:   reconnect? last connection failed?  " · "R002_" · "startConnect:   writeCharacteristic  " · ":" · "startConnect:   wrong curStatus:"
- `void validCanLive()`  L204
- `void onPermissionHave()`  L211 @Override
    - 体内字面量："R009" · "xs, " · "canLive:   writeCharacteristic  R009 = " · ":"
- `void run()`  L222 @Override
- `void lambda$validCanLive$0()`  L232
- `void autoLive(String pin)`  L252
- `void sendPairCmd()`  L262
- `void onPermissionHave()`  L267 @Override
    - 体内字面量："R003_" · "xs, " · "autoLive startConnect:   writeCharacteristic  R003_  = " · ":"
- `void startWifi(String ssid, String pwd)`  L275
    - 体内字面量："ssid:%s;pwd:%s;" · "R006"
- `void startLive(String liveType, int res, int fps, int bitrate, String rtmpUrl)`  L282
    - 体内字面量："live_type:%s;res:%d;fps:%d;bitrate:%d;rtmp_url:%s;" · "R007"
- `void endLive()`  L289
- `void onPermissionHave()`  L293 @Override
    - 体内字面量："R008_" · "xs, " · "EndLive:   writeCharacteristic  " · ":"
- `void sendPacket(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, String data, String cmd)`  L302
    - 体内字面量："pin:" · ";"
- `void sendPackets(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, List<String> packets)`  L323
- `void sendNextPacket(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic)`  L330
    - 体内字面量："xs, " · "åéå®æ" · "xs, " · "Write="
- `void sendCmd(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, String cmd)`  L347
- `void onPermissionHave()`  L351 @Override
- `String md5(String text)`  L357
    - 体内字面量："%02x"
- `void cancelPair()`  L370
- `void onPermissionHave()`  L373 @Override
    - 体内字面量："R004" · "cancelPair:   writeCharacteristic  " · ":"
- `void reset()`  L389
- `void close()`  L401
    - 体内字面量："xs, " · "ble close"
- `void onPermissionHave()`  L410 @Override
- `void registerBLELiveCallback(BLELiveCallback liveCallback)`  L438
- `void unRegisterBLELiveCallback(BLELiveCallback liveCallback)`  L447
- `void registerBLELiveStatusCallback(BLELiveStatusCallback statusCallback)`  L456
- `void unRegisterBLELiveStatusCallback()`  L460
- `void connect(BluetoothDevice device)`  L464
- `boolean isBLE_Device(BluetoothDevice device)`  L472
    - 体内字面量："XTU_"
- `void saveDeviceWithPin(String btDeviceName, String pin)`  L901
    - 体内字面量："bt_pin"
- `String getDevicePin(String btDeviceName)`  L905
    - 体内字面量："bt_pin"
- `void checkBlePermission(CallbackPermissionSimple callback)`  L909
    - 体内字面量："android.permission.BLUETOOTH_SCAN" · "android.permission.BLUETOOTH_CONNECT"
- `boolean hasPermissions(String[] permissions)`  L919
- `boolean hasPermission(String permission)`  L930
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.BLEConnectUtils$AnonymousClass8`
L477 · [class] AnonymousClass8 · extends `BluetoothGattCallback` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java`

字段/常量（4）：
- `int i = 0`  L486
- `int i = 0`  L608
- `String str2 = strArrSplit[1]`  L630
- `String str6 = strArrSplit2[1]`  L766

方法（14）：
- `void onConnectionStateChange(BluetoothGatt gatt, int status, int newState)`  L482 @Override
    - 体内字面量："xs, " · "onConnectionStateChange: "
- `void onServicesDiscovered(final BluetoothGatt gatt, int status)`  L523 @Override
    - 体内字面量："xs, " · "onServicesDiscovered:    getServices size=" · "onServicesDiscovered:    serviceUUID=" · "onServicesDiscovered:    characteristicUUID=" · "00002902-0000-1000-8000-00805f9b34fb" · "00008888-0000-1000-8000-00805f9b34fb" · "xs, " · "onServicesDiscovered:   åèçåå¥æ°æ®" · "onServicesDiscovered:   notify  "
- `void run()`  L559 @Override
    - 体内字面量："00002902-0000-1000-8000-00805f9b34fb" · "xs, " · "onServicesDiscovered:   writeDescriptor  "
- `void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status)`  L572 @Override
    - 体内字面量："xs, " · "onCharacteristicWrite: success " · "4"
- `void onCharacteristicChanged(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic)`  L599 @Override
- `void onPermissionHave()`  L603 @Override
    - 体内字面量："xs, " · "onCharacteristicChanged: curStatu = " · ", backString="
- `void run()`  L652 @Override
    - 体内字面量："KEY" · "R003_" · "xs, " · "onCharacteristicChanged:   writeCharacteristic  R003_ = " · ":"
- `void run()`  L716 @Override
    - 体内字面量："SSID" · "PWD" · "SSID" · "PWD" · "R002_" · "onServicesDiscovered:   writeCharacteristic  " · ":" · "WiFi_Status" · "WiFi_Status"
- `void run()`  L742 @Override
- `void run()`  L754 @Override
    - 体内字面量："R002_" · "onServicesDiscovered:   writeCharacteristic  " · ":" · "_" · "_"
- `String extractPin(String packet)`  L825
    - 体内字面量："_" · "pin:" · ";"
- `void onDescriptorWrite(final BluetoothGatt gatt, BluetoothGattDescriptor descriptor, final int status)`  L843 @Override
- `void onPermissionHave()`  L847 @Override
- `void run()`  L850 @Override
    - 体内字面量："Descriptor written successfully" · "R003_" · "ä¸æ­£å¸¸ï¼ä¸ºä»ä¹æ²¡æèµ·åè¡¨fragmentï¼" · "R001" · "onDescriptorWrite:   writeCharacteristic  " · ":" · "Descriptor write failed: "
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.BLEConnectUtils$BLEConnectbacks`
L72 · [interface] public BLEConnectbacks · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java`

方法（3）：
- `void connectWifi(String btName, List<String> res)`  L73
- `void onCancel()`  L75
- `boolean onDeviceClosed()`  L77
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.BLEConnectUtils$BLEKeyCallbacks`
L80 · [interface] public BLEKeyCallbacks · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java`

方法（2）：
- `void onCancel()`  L81
- `void onKeySetted()`  L83
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.BLEConnectUtils$BLEListCallbacks`
L86 · [interface] public BLEListCallbacks · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java`

方法（6）：
- `void connectWifi(String btName, List<String> res)`  L87
- `void onClose()`  L89
- `void onKeySetted(boolean foundInLocal)`  L91
- `DeviceAddKeyItem onServicesDiscovered(String pin)`  L93
- `void rescan()`  L95
- `void reset()`  L97
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.BLEConnectUtils$ConnectStatus`
L100 · [enum] private ConnectStatus · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/BLEConnectUtils.java`

枚举常量（11）：
- `OldPairing()`  L101
- `Listing()`  L102
- `Pairing()`  L103
- `Opening()`  L104
- `Waiting()`  L105
- `Connecting()`  L106
- `DropPairing()`  L107
- `CanLive()`  L108
- `StartWifi()`  L109
- `StartLive()`  L110
- `Live()`  L111
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.DeviceAddConnectFragment`
L33 · [class] public DeviceAddConnectFragment · extends `Fragment implements StreamConfigActivity.OnFragmentBackPressed, BLEConnectUtils.BLEConnectbacks` · implements `StreamConfigActivity.OnFragmentBackPressed, BLEConnectUtils.BLEConnectbacks` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/DeviceAddConnectFragment.java`

字段/常量（11）：
- `String ATTR_FOUND_IN_LOCAL = "ATTR_FOUND_IN_LOCAL"`  L34
- `String TAG = "DeviceAddConnectFragment"`  L35
- `TextViewShape btStartConnect`  L36
- `ImageView btn_close`  L37
- `ImageView iv_device_icon`  L38
- `Activity mActivity`  L39
- `IChargeConnect mParent`  L40
- `TextView tvContentBottom`  L41
- `TextView tvTitle`  L42
- `boolean foundInLocal = false`  L43
- `Activity activity = this.mActivity`  L184

方法（27）：
- `void onResult(boolean success)`  L46 @Override
    - 体内字面量："onResult: "
- `boolean onDeviceClosed()`  L52 @Override
- `void onCreate(Bundle savedInstanceState)`  L57 @Override
- `void onAttach(Context context)`  L66 @Override
- `void onDetach()`  L75 @Override
- `void onDestroy()`  L81 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L86 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L97 @Override
- `void onClick(View view2)`  L101 @Override
- `void onClick(View view2)`  L107 @Override
- `void run()`  L116 @Override
- `void onAppStart()`  L130 @Override
- `void onAppStop()`  L134 @Override
- `void onCurrentLifecycleOwnerDestroy()`  L138 @Override
- `void onLost()`  L142 @Override
- `void onUnavailable(boolean scan)`  L146 @Override
- `void onAvailable()`  L150 @Override
    - 体内字面量："192.168.0.1"
- `void jumpToPreviewActivity()`  L159
- `void run()`  L165 @Override
- `void run()`  L173 @Override
    - 体内字面量："jumpToPreviewActivity: "
- `void lambda$jumpToPreviewActivity$0()`  L183
- `void lambda$jumpToPreviewActivity$1()`  L189
    - 体内字面量："wifiè¿æ¥æåï¼åå¤å³èçè¿æ¥äº"
- `void connectWi_fi(String ssid, String pwd)`  L194
- `void run()`  L198 @Override
- `boolean onBackPressed()`  L208 @Override
- `void connectWifi(String btName, List<String> res)`  L214 @Override
    - 体内字面量："xs, " · "connectWifi: "
- `void onCancel()`  L222 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.DeviceAddDeviceListFragment`
L50 · [class] public DeviceAddDeviceListFragment · extends `Fragment implements BLEConnectUtils.BLEListCallbacks, StreamConfigActivity.OnFragmentBackPressed` · implements `BLEConnectUtils.BLEListCallbacks, StreamConfigActivity.OnFragmentBackPressed` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/DeviceAddDeviceListFragment.java`

字段/常量（27）：
- `String TAG = "DeviceAddDeviceListFragment"`  L51
- `ImageView btn_close`  L52
- `TextViewShape btn_connect`  L53
- `RecyclerView deviceRecycle`  L54
- `ImageView iv_device_icon`  L55
- `LinearLayout ll_bottom`  L56
- `LinearLayout ll_device_icon`  L57
- `Activity mActivity`  L58
- `DeviceListManager mDeviceListMagager`  L59
- `LinearLayoutManager mLinearLayoutManager`  L60
- `IChargeDeviceList mParent`  L61
- `ScanAddRecycleAdapter mScanAddRecycleAdapter`  L62
- `RadarView radarView`  L63
- `TextView textContent`  L64
- `TextView title_add`  L65
- `TextView tv_bottom_content`  L66
- `TextView tv_scan_devices`  L67
- `boolean buttonConnectPressed = false`  L68
- `long mLastReadyForScan = Long.MAX_VALUE`  L69
- `boolean isRunning = false`  L71
- `boolean isReset = false`  L91
- `BluetoothAdapter adapter`  L269
- `Activity activity = this.mActivity`  L322
- `Activity activity = this.mActivity`  L329
- `Activity activity = this.mActivity`  L336
- `List<BluetoothDevice> deviceList`  L390
- `Activity activity = this.mActivity`  L444

方法（36）：
- `void run()`  L74 @Override
- `void onItemClick(int position)`  L83 @Override
- `void onCreate(Bundle savedInstanceState)`  L94 @Override
- `void onAttach(Context context)`  L101 @Override
- `void onDetach()`  L109 @Override
- `void onDestroy()`  L115 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L121 @Override
- `void startTimer()`  L146
- `void stopTimer()`  L151
- `void onDestroyView()`  L157 @Override
- `void doSomething()`  L164
- `void setPageStatus(int i)`  L195
- `void onViewCreated(View view, Bundle savedInstanceState)`  L241 @Override
- `void onClick(View view2)`  L248 @Override
- `void onClick(View view2)`  L255 @Override
- `boolean isBluetoothEnabled(Context context)`  L268
- `void initScanResultList()`  L277
- `void connectWi_fi(String ssid, String pwd)`  L288
- `void run()`  L295 @Override
    - 体内字面量："android.settings.WIFI_SETTINGS"
- `void run()`  L305 @Override
    - 体内字面量："XTU" · "Disable current connected Wifi: "
- `void lambda$connectWi_fi$0()`  L328
- `void lambda$connectWi_fi$1()`  L335
- `void onEventRefresh(UpdateEvent event)`  L382 @Subscribe(threadMode = ThreadMode.MAIN)
- `void refreshList()`  L389
- `void run()`  L399 @Override
- `void lambda$refreshList$2()`  L406
- `int resortWithPairedDeviceNum(List<BluetoothDevice> mDevices, List<BluetoothDevice> dest)`  L413
- `void rescan()`  L430 @Override
- `void run()`  L434 @Override
- `void lambda$rescan$3()`  L441
- `void connectWifi(String btName, List<String> res)`  L450 @Override
- `DeviceAddKeyItem onServicesDiscovered(String pin)`  L456 @Override
    - 体内字面量："%04d"
- `void onKeySetted(boolean foundInLocal)`  L471 @Override
- `void reset()`  L481 @Override
- `void onClose()`  L486 @Override
- `boolean onBackPressed()`  L491 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.DeviceAddDeviceListFragment$AnonymousClass5`
L342 · [class] AnonymousClass5 · implements `WIFIUtils.Callback` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/DeviceAddDeviceListFragment.java`

方法（3）：
- `void onResult(boolean success)`  L347 @Override
    - 体内字面量："onResult: "
- `void run()`  L354 @Override
- `void lambda$onResult$0()`  L361
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.DeviceAddDeviceListFragment$AnonymousClass6`
L368 · [class] static AnonymousClass6 · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/DeviceAddDeviceListFragment.java`

字段/常量（1）：
- `int[] $SwitchMap$com$gku$actioncam$sigmastar$bluetooth$event$UpdateEvent$Type`  L369
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.DeviceAddDeviceListFragment$DeviceListManager`
L496 · [class] private DeviceListManager · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/connect/DeviceAddDeviceListFragment.java`

字段/常量（1）：
- `int selectedIndex = -1`  L497

方法（11）：
- `public DeviceListManager()`  L500
- `boolean contains(BluetoothDevice device)`  L503
- `BluetoothDevice get()`  L508
    - 体内字面量："DeviceListManager.get null" · "DeviceListManager.get 1:" · "ä¸è¯¥èµ°å°è¿ï¼ççæ¥å¿ãæµç¨ææ²¡æé®é¢" · "DeviceListManager.get " · ":"
- `void add(BluetoothDevice device)`  L525
    - 体内字面量："DeviceListManager.add "
- `void clear()`  L531
    - 体内字面量："DeviceListManager.clear "
- `void replace(List<BluetoothDevice> devices)`  L538
    - 体内字面量："DeviceListManager.replace "
- `int getSize()`  L546
    - 体内字面量："DeviceListManager.getSize "
- `void itemClicked(int position)`  L552
    - 体内字面量："DeviceListManager.itemClicked "
- `boolean itemClicked()`  L558
- `void wipeItemClicked()`  L563
    - 体内字面量："DeviceListManager.wipeItemClicked "
- `List<BluetoothDevice> forAdapterInit()`  L569
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddBottomSheetDialogFragment`
L29 · [class] public DeviceAddBottomSheetDialogFragment · extends `BottomSheetDialogFragment implements IChargeDeviceList, IChargeKey, IChargeConnect` · implements `IChargeDeviceList, IChargeKey, IChargeConnect` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddBottomSheetDialogFragment.java`

字段/常量（10）：
- `String ARGUMENT_LIVE = "ARGUMENT_LIVE"`  L30
- `String TAG = "DeviceAddBottomSheetDialogFragment"`  L31
- `BluetoothDevice deviceSelected`  L32
- `OnDismissListener dismissListener`  L33
- `Boolean isNeedLive = false`  L34
- `BaseBTPopupActivity mActivity`  L35
- `Context mContext`  L36
- `OnDismissListener onDismissListener = this.dismissListener`  L116
- `BluetoothDevice bluetoothDevice = this.deviceSelected`  L159
- `FrameLayout frameLayout`  L193

方法（23）：
- `void closeBT()`  L43 @Override
- `void onCreate(Bundle savedInstanceState)`  L47 @Override
- `Dialog onCreateDialog(Bundle savedInstanceState)`  L60 @Override
- `boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent)`  L64 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L75 @Override
- `void onDestroy()`  L82 @Override
- `void onDeviceSelected(BluetoothDevice device)`  L87 @Override
    - 体内字面量："mDevice: "
- `List<BluetoothDevice> getDeviceList()`  L97 @Override
- `void myDismiss()`  L102 @Override
- `void onDismiss(DialogInterface dialog)`  L114 @Override
- `void subscribe(BLEConnectUtils.BLEListCallbacks bleListCallbacks)`  L123 @Override
- `void unsubscribe(BLEConnectUtils.BLEListCallbacks bleListCallbacks)`  L128 @Override
- `void subscribe(BLEConnectUtils.BLEKeyCallbacks deviceAddSetKeyFragment)`  L133 @Override
- `void unsubscribe(BLEConnectUtils.BLEKeyCallbacks deviceAddSetKeyFragment)`  L138 @Override
- `void cancelPair()`  L143 @Override
- `void subscribe(BLEConnectUtils.BLEConnectbacks deviceAddConnectFragment)`  L148 @Override
- `void unsubscribe(BLEConnectUtils.BLEConnectbacks deviceAddConnectFragment)`  L153 @Override
- `String getSelectedDeviceName()`  L158 @Override
- `void startConnect()`  L167 @Override
    - 体内字面量："startConnect"
- `void setShouldHandleAvailable()`  L174 @Override
- `boolean onBackPressed()`  L178
- `void onStart()`  L192 @Override
- `void setOnDismissListener(OnDismissListener listener)`  L202
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddBottomSheetDialogFragment$OnDismissListener`
L38 · [interface] public OnDismissListener · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddBottomSheetDialogFragment.java`

方法（1）：
- `void onDismiss()`  L39
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddWaveFragment`
L57 · [class] public DeviceAddWaveFragment · extends `Fragment` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java`

字段/常量（28）：
- `String TAG = "DeviceAddWaveFragment"`  L58
- `String backString`  L59
- `BLEManager bleManager`  L60
- `BluetoothGattCharacteristic bluetoothGattCharacteristic`  L61
- `String deviceName`  L62
- `RecyclerView deviceRecycle`  L63
- `Button helper`  L64
- `int imageId`  L65
- `List<BluetoothGattService> list`  L66
- `DeviceAddActivity mActivity`  L67
- `Context mContext`  L68
- `BluetoothDevice mDevice`  L69
- `List<BluetoothDevice> mDeviceList`  L70
- `LinearLayoutManager mLinearLayoutManager`  L71
- `ScanAddRecycleAdapter mScanAddRecycleAdapter`  L72
- `String max2`  L73
- `String pwd`  L74
- `ScanResult scanResult`  L75
- `TextView search`  L76
- `String ssid`  L77
- `LinearLayout stopSearch`  L78
- `DiffuseView2 waveView1`  L79
- `DiffuseView2 waveView2`  L80
- `boolean getDeviceInfoSuccess = true`  L83
- `Context context = this.mContext`  L509
- `Context context = this.mContext`  L516
- `List<BluetoothDevice> deviceList`  L585
- `DeviceAddActivity deviceAddActivity = this.mActivity`  L586

方法（22）：
- `void onItemClick(int position)`  L113 @Override
- `DeviceAddWaveFragment newInstance()`  L121
- `void onCreate(Bundle savedInstanceState)`  L129 @Override
- `void onActivityCreated(Bundle savedInstanceState)`  L141 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L146 @Override
- `void onResume()`  L160 @Override
- `void onEventRefresh(UpdateEvent event)`  L179 @Subscribe(threadMode = ThreadMode.MAIN)
- `void onDestroyView()`  L187 @Override
    - 体内字面量："onDestroyView: "
- `void initScanResultList()`  L193
- `void connectWifi(String ssid, String pwd)`  L468
- `void run()`  L475 @Override
- `void run()`  L485 @Override
    - 体内字面量："XTU" · "Disable current connected Wifi: "
- `void lambda$connectWifi$0()`  L508
- `void lambda$connectWifi$1()`  L515
- `void jumpToPreviewActivity()`  L522
- `void run()`  L528 @Override
- `void run()`  L536 @Override
    - 体内字面量："jumpToPreviewActivity: "
- `void lambda$jumpToPreviewActivity$2()`  L547
- `void lambda$jumpToPreviewActivity$3()`  L552
- `void refreshList()`  L584
- `void run()`  L594 @Override
- `void lambda$refreshList$4()`  L601
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddWaveFragment$AnonymousClass2`
L205 · [class] AnonymousClass2 · extends `BluetoothGattCallback` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java`

字段/常量（1）：
- `BluetoothGatt bluetoothGatt`  L221

方法（16）：
- `void onPhyUpdate(BluetoothGatt gatt, int txPhy, int rxPhy, int status)`  L210 @Override
- `void onPhyRead(BluetoothGatt gatt, int txPhy, int rxPhy, int status)`  L215 @Override
- `void onConnectionStateChange(BluetoothGatt gatt, int status, int newState)`  L220 @Override
- `void run()`  L248 @Override
- `void lambda$onConnectionStateChange$0()`  L255
- `void onServicesDiscovered(final BluetoothGatt gatt, int status)`  L269 @Override
    - 体内字面量："onServicesDiscovered:    getServices size=" · "onServicesDiscovered:    serviceUUID=" · "onServicesDiscovered:    characteristicUUID=" · "00002902-0000-1000-8000-00805f9b34fb" · "00008888-0000-1000-8000-00805f9b34fb" · "onServicesDiscovered:   åèçåå¥æ°æ®" · "onServicesDiscovered:   notify  "
- `void run()`  L297 @Override
- `void lambda$onServicesDiscovered$1(BluetoothGatt bluetoothGatt)`  L306
    - 体内字面量："00002902-0000-1000-8000-00805f9b34fb" · "onServicesDiscovered:   writeDescriptor  " · "R001" · "onServicesDiscovered:   writeCharacteristic  "
- `void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status)`  L317 @Override
- `void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status)`  L322 @Override
    - 体内字面量："onCharacteristicWrite: success "
- `void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic)`  L330 @Override
    - 体内字面量："onCharacteristicChanged:   byteSize=" · "onCharacteristicChanged:   backString=" · "_" · "_" · "_"
- `void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status)`  L350 @Override
- `void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status)`  L355 @Override
- `void onReliableWriteCompleted(BluetoothGatt gatt, int status)`  L360 @Override
- `void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status)`  L365 @Override
- `void onMtuChanged(BluetoothGatt gatt, int mtu, int status)`  L370 @Override
    - 体内字面量："onMtuChanged:   mtu=" · "  status="
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddWaveFragment$AnonymousClass3`
L377 · [class] AnonymousClass3 · extends `ScanCallback` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java`

字段/常量（5）：
- `int iMin`  L382
- `int i = 0`  L383
- `int i2 = i + 1`  L386
- `int i3 = scanRecord[i] & 255`  L387
- `int i4 = scanRecord[i2] & 255`  L391

方法（6）：
- `String parseDeviceNameSafe(byte[] scanRecord)`  L381
- `void onScanResult(int callbackType, ScanResult result)`  L405 @Override
    - 体内字面量："android.permission.BLUETOOTH_CONNECT" · "XTU" · "GKU" · "åç°ç®æ è®¾å¤: " · " åç§°: "
- `void run()`  L423 @Override
    - 体内字面量："æ«æç»æä¸ºç©ºï¼å¿½ç¥"
- `void lambda$onScanResult$0()`  L438
- `void onBatchScanResults(List<ScanResult> results)`  L449 @Override
- `void onScanFailed(int errorCode)`  L461 @Override
    - 体内字面量："èçæ«æå¤±è´¥, éè¯¯ç : "
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddWaveFragment$AnonymousClass4`
L558 · [class] AnonymousClass4 · implements `WIFIUtils.Callback` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java`

方法（3）：
- `void onResult(boolean success)`  L563 @Override
    - 体内字面量："onResult: "
- `void run()`  L570 @Override
- `void lambda$onResult$0()`  L578
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddWaveFragment$AnonymousClass5`
L165 · [class] static AnonymousClass5 · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java`

字段/常量（1）：
- `int[] $SwitchMap$com$gku$actioncam$sigmastar$bluetooth$event$UpdateEvent$Type`  L166
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddWaveFragment$RunnableC00721`
L88 · [class] RunnableC00721 · implements `Runnable` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/DeviceAddWaveFragment.java`

字段/常量（1）：
- `int val$position`  L89

方法（3）：
- `void run()`  L96 @Override
    - 体内字面量："mDevice: "
- `void run()`  L100 @Override
- `void lambda$run$0()`  L107
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.itface.ICharge`
L4 · [interface] public ICharge · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/itface/ICharge.java`

方法（1）：
- `void myDismiss()`  L5
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.itface.IChargeConnect`
L6 · [interface] public IChargeConnect · extends `ICharge` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/itface/IChargeConnect.java`

方法（6）：
- `void closeBT()`  L7
- `String getSelectedDeviceName()`  L9
- `void setShouldHandleAvailable()`  L11
- `void startConnect()`  L13
- `void subscribe(BLEConnectUtils.BLEConnectbacks deviceAddConnectFragment)`  L15
- `void unsubscribe(BLEConnectUtils.BLEConnectbacks deviceAddConnectFragment)`  L17
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.itface.IChargeDeviceList`
L8 · [interface] public IChargeDeviceList · extends `ICharge` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/itface/IChargeDeviceList.java`

方法（4）：
- `List<BluetoothDevice> getDeviceList()`  L9
- `void onDeviceSelected(BluetoothDevice device)`  L11
- `void subscribe(BLEConnectUtils.BLEListCallbacks deviceAddDeviceListFragment)`  L13
- `void unsubscribe(BLEConnectUtils.BLEListCallbacks deviceAddDeviceListFragment)`  L15
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.itface.IChargeKey`
L6 · [interface] public IChargeKey · extends `ICharge` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/itface/IChargeKey.java`

方法（3）：
- `void cancelPair()`  L7
- `void subscribe(BLEConnectUtils.BLEKeyCallbacks deviceAddSetKeyFragment)`  L9
- `void unsubscribe(BLEConnectUtils.BLEKeyCallbacks deviceAddSetKeyFragment)`  L11
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.setkey.DeviceAddSetKeyFragment`
L18 · [class] public DeviceAddSetKeyFragment · extends `Fragment implements BLEConnectUtils.BLEKeyCallbacks, StreamConfigActivity.OnFragmentBackPressed` · implements `BLEConnectUtils.BLEKeyCallbacks, StreamConfigActivity.OnFragmentBackPressed` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Fragment/setkey/DeviceAddSetKeyFragment.java`

字段/常量（6）：
- `String BUNDLE_KEY = "BUNDLE_KEY"`  L19
- `String TAG = "DeviceAddSetKeyFragment"`  L20
- `TextViewShape btCancelKey`  L21
- `ImageView btn_close`  L22
- `String key`  L23
- `IChargeKey mParent`  L24

方法（9）：
- `void onCreate(Bundle savedInstanceState)`  L27 @Override
- `void onAttach(Context context)`  L33 @Override
- `void onDestroy()`  L41 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L47 @Override
- `void onClick(View view)`  L53 @Override
- `void onClick(View view)`  L60 @Override
- `boolean onBackPressed()`  L72 @Override
- `void onKeySetted()`  L78 @Override
- `void onCancel()`  L83 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Item.DeviceAddItem`
L6 · [class] public DeviceAddItem · implements `Serializable` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Item/DeviceAddItem.java`

字段/常量（2）：
- `int imageId`  L7
- `String imageName`  L8

方法（3）：
- `public DeviceAddItem(int imageId, String imageName)`  L10
- `int getImageId()`  L15
- `String getImageName()`  L19
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Item.DeviceAddKeyItem`
L4 · [class] public DeviceAddKeyItem · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Item/DeviceAddKeyItem.java`

字段/常量（5）：
- `String code`  L5
- `String deviceName`  L6
- `boolean foundInLocal`  L7
- `String pwd`  L8
- `String ssid`  L9

方法（11）：
- `public DeviceAddKeyItem(String code, String deviceName, String ssid, String pwd, boolean foundInLocal)`  L11
- `String getCode()`  L19
- `void setCode(String code)`  L23
- `String getDeviceName()`  L27
- `void setDeviceName(String deviceName)`  L31
- `String getSsid()`  L35
- `void setSsid(String ssid)`  L39
- `String getPwd()`  L43
- `void setPwd(String pwd)`  L47
- `boolean isFoundInLocal()`  L51
- `void setFoundInLocal(boolean foundInLocal)`  L55
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Item.ScanAddItem`
L4 · [class] public ScanAddItem · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Item/ScanAddItem.java`

字段/常量（4）：
- `int ImageId`  L5
- `String device_name`  L6
- `String device_pwd`  L7
- `String device_ssid`  L8

方法（9）：
- `public ScanAddItem(int ImageId, String device_name, String device_ssid, String device_pwd)`  L10
- `int getImageId()`  L17
- `String getDeviceName()`  L21
- `String getDeviceSsid()`  L25
- `String getDevicePwd()`  L29
- `void setImageId(int ImageId)`  L33
- `void setDeviceName(String deviceName)`  L37
- `void setDeviceSsid(String deviceSsid)`  L41
- `void setDevicePwd(String devicePwd)`  L45
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Iterface.OnScanItemClickListener`
L4 · [interface] public OnScanItemClickListener · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Iterface/OnScanItemClickListener.java`

方法（1）：
- `void onItemClick(int position)`  L5
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.MyGridLayoutManager`
L8 · [class] public MyGridLayoutManager · extends `GridLayoutManager` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/MyGridLayoutManager.java`

字段/常量（1）：
- `boolean isScrollEnabled`  L9

方法（5）：
- `public MyGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)`  L11
- `public MyGridLayoutManager(Context context, int spanCount)`  L16
- `public MyGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout)`  L21
- `void setScrollEnabled(boolean flag)`  L26
- `boolean canScrollVertically()`  L31 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.NoScrollRecyclerView`
L9 · [class] public NoScrollRecyclerView · extends `RecyclerView` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/NoScrollRecyclerView.java`

方法（5）：
- `boolean onInterceptTouchEvent(MotionEvent e)`  L11 @Override
- `boolean onTouchEvent(MotionEvent e)`  L16 @Override
- `public NoScrollRecyclerView(Context context)`  L20
- `public NoScrollRecyclerView(Context context, AttributeSet attrs)`  L24
- `public NoScrollRecyclerView(Context context, AttributeSet attrs, int defStyleAttr)`  L28
### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Pager.PhotoViewPager`
L8 · [class] public PhotoViewPager · extends `ViewPager` · `com/gku/actioncam/sigmastar/newUi/deviceAdd/Pager/PhotoViewPager.java`

方法（1）：
- `public PhotoViewPager(Context context, AttributeSet attrs)`  L9
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.AmbaFastSettingModel`
L27 · [class] public AmbaFastSettingModel · implements `IsFastSettingModel, IChannelListener` · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/AmbaFastSettingModel.java`

字段/常量（7）：
- `String TAG = "AmbaFastSettingModel"`  L28
- `String curParamName`  L29
- `IsFastSettingModelCallBack fastSettingModelCallBack`  L30
- `String secondParamName`  L32
- `FastSettingRecycleAdapter.SettingItemType settingItemType`  L130
- `String str = this.secondParamName`  L213
- `String str2 = array[1]`  L214

方法（32）：
- `void connectCamera()`  L35 @Override
- `public AmbaFastSettingModel(IsFastSettingModelCallBack fastSettingModelCallBack)`  L38
- `void loadCameraInfo()`  L43 @Override
- `void success()`  L46 @Override
    - 体内字面量："getDeviceInfo successfully!"
- `void failure(int code)`  L51 @Override
    - 体内字面量："getDeviceInfo failed!"
- `void syncSystemTime()`  L58 @Override
    - 体内字面量："yyyyMMddHHmmss"
- `void success()`  L61 @Override
    - 体内字面量："setSyncTime successfully"
- `void failure(int code)`  L66 @Override
    - 体内字面量："setSyncTime failed"
- `void getPrimaryMenuItem(String curMode, String itemName)`  L73 @Override
- `void success()`  L79 @Override
    - 体内字面量："GetPrimaryMenuItem successfully!"
- `void failure(int code)`  L84 @Override
    - 体内字面量："GetPrimaryMenuItem failed!"
- `void getSecondMenuItem(String curMode, String name)`  L91 @Override
- `void success()`  L98 @Override
    - 体内字面量："SecondMenuItem got successfully!"
- `void failure(int code)`  L103 @Override
    - 体内字面量："SecondMenuItem got failed!"
- `void setCurParam(String curMode, String itemName, String value)`  L110 @Override
- `void success()`  L117 @Override
    - 体内字面量："SetCurParameter successfully!"
- `void failure(int code)`  L122 @Override
    - 体内字面量："SetCurParameter failed!"
- `void onChannelEvent(int type, Object param, String... array)`  L129 @Override
- `void run()`  L164 @Override
    - 体内字面量："onChannelEvent: è·åsession\n"
- `void run()`  L174 @Override
    - 体内字面量："onChannelEvent: sync system time ââ åæ­¥ç¸æºæ¶é´æåï¼"
- `void run()`  L185 @Override
- `void run()`  L194 @Override
- `void run()`  L204 @Override
- `void run()`  L217 @Override
    - 体内字面量："-" · "ON" · "OFF" · "-"
- `void run()`  L251 @Override
- `void lambda$onChannelEvent$0()`  L258
- `void lambda$onChannelEvent$1()`  L263
- `void lambda$onChannelEvent$2(FastSecondItemBean fastSecondItemBean)`  L268
- `void lambda$onChannelEvent$3(String str, String str2)`  L273
    - 体内字面量："Set Current Parameter successfully!"
- `void lambda$onChannelEvent$4(ArrayList arrayList)`  L278
- `void lambda$onChannelEvent$5()`  L283
- `String formatParam(String s)`  L287
    - 体内字面量：",," · ",," · ",-," · "-%s" · "%s-"
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.Base.BaseDialog`
L18 · [class] public abstract BaseDialog · extends `Dialog implements IsFastSettingView` · implements `IsFastSettingView` · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/Base/BaseDialog.java`

字段/常量（9）：
- `String TAG = "BaseDialog"`  L19
- `ConnectivityManager connectivityManager`  L20
- `FastSettingPresenter fastSettingPresenter`  L21
- `boolean isChecking`  L22
- `Context mContext`  L23
- `ConnectivityManager.NetworkCallback networkCallback`  L24
- `AlertDialog progressDialog`  L25
- `AlertDialog alertDialog = this.progressDialog`  L65
- `AlertDialog alertDialog = this.progressDialog`  L87

方法（11）：
- `void onProgressCancelListener(DialogInterface dialog)`  L27
- `public BaseDialog(Context context)`  L29
- `void showProgressDialog()`  L34
- `void onCancel(DialogInterface dialogInterface)`  L38 @Override
- `boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent keyEvent)`  L46 @Override
- `void run()`  L57 @Override
- `void lambda$showProgressDialog$0()`  L64
- `void dismissProgressDialog()`  L76
- `void run()`  L79 @Override
- `void lambda$dismissProgressDialog$1()`  L86
- `void onCreate(Bundle savedInstanceState)`  L96 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.Bean.FastSecondItemBean`
L7 · [class] public FastSecondItemBean · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/Bean/FastSecondItemBean.java`

字段/常量（2）：
- `String curValue`  L8
- `List<String> itemList`  L9

方法（6）：
- `public FastSecondItemBean(List<String> itemList, String curValue)`  L11
- `List<String> getItemList()`  L16
- `void setItemList(ArrayList<String> itemList)`  L20
- `String getCurValue()`  L24
- `void setCurValue(String curValue)`  L28
- `String toString()`  L32
    - 体内字面量："FastSecondItemBean{itemList=" · ", curValue='" · "'}"
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.Bean.FastSecondItemValueBean`
L4 · [class] public FastSecondItemValueBean · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/Bean/FastSecondItemValueBean.java`

字段/常量（2）：
- `String name`  L5
- `boolean select = false`  L6

方法（6）：
- `public FastSecondItemValueBean(String name)`  L8
- `String getName()`  L12
- `void setName(String name)`  L16
- `boolean isSelect()`  L20
- `void setSelect(boolean select)`  L24
- `String toString()`  L28
    - 体内字面量："SSListDialogRecycleItemBean{name='" · "', select=" · "}"
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.Bean.FastSettingItemBean`
L6 · [class] public FastSettingItemBean · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/Bean/FastSettingItemBean.java`

字段/常量（4）：
- `int imageId`  L7
- `String itemName`  L8
- `String itemValue`  L9
- `FastSettingRecycleAdapter.SettingItemType type`  L10

方法（10）：
- `public FastSettingItemBean(FastSettingRecycleAdapter.SettingItemType type, String itemName)`  L12
- `int getImageId()`  L17
- `void setImageId(int imageId)`  L21
- `FastSettingRecycleAdapter.SettingItemType getType()`  L25
- `void setType(FastSettingRecycleAdapter.SettingItemType type)`  L29
- `String getItemName()`  L33
- `void setItemName(String itemName)`  L37
- `String getItemValue()`  L41
- `void setItemValue(String itemValue)`  L45
- `String toString()`  L49
    - 体内字面量："FastSettingItemBean{type=" · ", itemName='" · "', itemValue='" · "'}"
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingItem`
L4 · [class] public FastSettingItem · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingItem.java`

字段/常量（2）：
- `int itemImageId`  L5
- `String itemName`  L6

方法（3）：
- `public FastSettingItem(int itemImageId, String itemName)`  L8
- `int getImageId()`  L13
- `String getName()`  L17
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingModelManage`
L10 · [class] public FastSettingModelManage · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingModelManage.java`

字段/常量（2）：
- `IsFastSettingModel isFastSettingModel`  L11
- `IsFastSettingModel isFastSettingModel = this.isFastSettingModel`  L28

方法（8）：
- `public FastSettingModelManage(IsFastSettingModelCallBack fastSettingModelCallBack)`  L13
    - 体内字面量："CV75"
- `IsFastSettingModel getModel()`  L27
- `void connectCamera()`  L34 @Override
- `void getPrimaryMenuItem(String curMode, String itemName)`  L38 @Override
- `void getSecondMenuItem(String curMode, String name)`  L42 @Override
- `void loadCameraInfo()`  L46 @Override
- `void setCurParam(String curMode, String name, String value)`  L50 @Override
- `void syncSystemTime()`  L54 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingPresenter`
L10 · [class] public FastSettingPresenter · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingPresenter.java`

字段/常量（2）：
- `String TAG = "FastSettingPresenter"`  L11
- `IsFastSettingViewCallBack fastSettingViewCallBack`  L13

方法（7）：
- `void connectCamera()`  L15
- `void loadCameraInfo()`  L19
- `void syncSystemTime()`  L23
- `void setFastSettingViewCallBack(IsFastSettingViewCallBack fastSettingViewCallBack)`  L27
- `void getSecondMenuItem(String curMode, String name)`  L31
- `void setCurParam(String curMode, String name, String value)`  L35
- `void getPrimaryMenuItem(String curMode, String name)`  L39
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingPresenter$FastSettingModelCallback`
L43 · [class] FastSettingModelCallback · implements `IsFastSettingModelCallBack` · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingPresenter.java`

方法（7）：
- `void connectCameraSuccess()`  L48 @Override
- `void loadCameraInfoSuccess()`  L56 @Override
- `void syncTimeSuccess()`  L64 @Override
- `void getSecondMenuItemSuccess(FastSecondItemBean fastSecondItemBean, String name)`  L72 @Override
- `void setCurParamSuccess(String result, String name, String value)`  L80 @Override
- `void getPrimaryMenuItemSuccess(ArrayList<FastSettingItemBean> fastSettingItemBeans)`  L88 @Override
- `void getDataError(Exception e, String methodName)`  L96 @Override
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingRecycleAdapter`
L20 · [class] public FastSettingRecycleAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingRecycleAdapter.java`

字段/常量（6）：
- `String TAG = "FastSettingRecycleAdapter"`  L21
- `List<FastSettingItemBean> fastSettingItemList`  L22
- `Context mContext`  L23
- `OnFastSettingItemClickListener onFastSettingItemClickListener`  L24
- `StringBuilder sb`  L78
- `List<FastSettingItemBean> list = this.fastSettingItemList`  L144

方法（11）：
- `public FastSettingRecycleAdapter(Context context, List<FastSettingItemBean> fastSettingItemList, OnFastSettingItemClickListener onFastSettingItemClickListener)`  L39
- `int getItemViewType(int position)`  L46 @Override
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L51 @Override
    - 体内字面量："window"
- `void onBindViewHolder(ViewHolder holder, int position)`  L77 @Override
- `void onClick(View view)`  L107 @Override
- `void onClick(View view)`  L118 @Override
- `void lambda$onBindViewHolder$0(FastSettingItemBean fastSettingItemBean, View view)`  L127
- `void lambda$onBindViewHolder$1(FastSettingItemBean fastSettingItemBean, View view)`  L135
- `int getItemCount()`  L143 @Override
- `void updateFastSettingList(List<FastSettingItemBean> fastSettingItemList)`  L151
- `void updateFastSettingItem(int position, String value)`  L156
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingRecycleAdapter$ClickViewHolder`
L172 · [class] public static ClickViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingRecycleAdapter.java`

字段/常量（1）：
- `TextView item_desc`  L173

方法（1）：
- `public ClickViewHolder(View itemView)`  L175
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingRecycleAdapter$OnFastSettingItemClickListener`
L27 · [interface] public OnFastSettingItemClickListener · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingRecycleAdapter.java`

方法（2）：
- `void onItemClick(SettingItemType type, String name)`  L28
- `void onItemSwitch(String name, int position, boolean isChecked)`  L30
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingRecycleAdapter$SelectViewHolder`
L181 · [class] public static SelectViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingRecycleAdapter.java`

字段/常量（2）：
- `TextView item_desc`  L182
- `TextView item_value`  L183

方法（1）：
- `public SelectViewHolder(View itemView)`  L185
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingRecycleAdapter$SettingItemType`
L33 · [enum] public SettingItemType · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingRecycleAdapter.java`

枚举常量（2）：
- `SELECT()`  L34
- `SWITCH()`  L35
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingRecycleAdapter$SwitchViewHolder`
L192 · [class] public static SwitchViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingRecycleAdapter.java`

字段/常量（1）：
- `SwitchCompat ss_setting_item_switch`  L193

方法（1）：
- `public SwitchViewHolder(View itemView)`  L195
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingRecycleAdapter$ViewHolder`
L163 · [class] public static ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingRecycleAdapter.java`

字段/常量（1）：
- `ImageView item_image`  L164

方法（1）：
- `public ViewHolder(View itemView)`  L166
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.Interface.IsFastSettingModel`
L4 · [interface] public IsFastSettingModel · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/Interface/IsFastSettingModel.java`

方法（6）：
- `void connectCamera()`  L5
- `void getPrimaryMenuItem(String curMode, String itemName)`  L7
- `void getSecondMenuItem(String curMode, String name)`  L9
- `void loadCameraInfo()`  L11
- `void setCurParam(String curMode, String name, String value)`  L13
- `void syncSystemTime()`  L15
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.Interface.IsFastSettingModelCallBack`
L8 · [interface] public IsFastSettingModelCallBack · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/Interface/IsFastSettingModelCallBack.java`

方法（7）：
- `void connectCameraSuccess()`  L9
- `void getDataError(Exception e, String itemName)`  L11
- `void getPrimaryMenuItemSuccess(ArrayList<FastSettingItemBean> fastSettingItemBeans)`  L13
- `void getSecondMenuItemSuccess(FastSecondItemBean fastSecondItemBean, String name)`  L15
- `void loadCameraInfoSuccess()`  L17
- `void setCurParamSuccess(String result, String name, String value)`  L19
- `void syncTimeSuccess()`  L21
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.Interface.IsFastSettingView`
L4 · [interface] public IsFastSettingView · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/Interface/IsFastSettingView.java`

方法（3）：
- `void addData()`  L5
- `void initView()`  L7
- `int setContentRes()`  L9
### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.Interface.IsFastSettingViewCallBack`
L8 · [interface] public IsFastSettingViewCallBack · `com/gku/actioncam/sigmastar/newUi/deviceFastSetting/Interface/IsFastSettingViewCallBack.java`

方法（9）：
- `void connectCameraSuccess()`  L9
- `void getDataError(Exception e, String methodName)`  L11
- `void getPrimaryMenuItemSuccess(ArrayList<FastSettingItemBean> fastSettingItemBeans)`  L13
- `void getSecondMenuItemSuccess(FastSecondItemBean fastSecondItemBean, String name)`  L15
- `void loadCameraInfoSuccess()`  L17
- `void requestList()`  L19
- `void setCurParamSuccess(String result, String name, String value)`  L21
- `void syncTimeSuccess()`  L23
- `void updateList(String itemName)`  L25
### `com.gku.actioncam.sigmastar.newUi.event.MessageFileEvent`
L4 · [class] public MessageFileEvent · `com/gku/actioncam/sigmastar/newUi/event/MessageFileEvent.java`

字段/常量（15）：
- `int delete = 0`  L5
- `int enterCircle = 2`  L6
- `int exitCircle = 3`  L7
- `int favorite = 1`  L8
- `int hideAndReset = 6`  L9
- `int refresh = 8`  L10
- `int reset = 7`  L11
- `int selectAll = 4`  L12
- `int shareMedia = 13`  L13
- `int unSelectAll = 5`  L14
- `int updateFavRedAllNumSelectAll = 9`  L15
- `int updateFavRedPartNumSelectAll = 10`  L16
- `int updateFavWhiteAllNumSelectAll = 11`  L17
- `int updateFavWhitePartNumSelectAll = 12`  L18
- `int MESSAGE_FILE_EVENT`  L19

方法（2）：
- `int getMESSAGE_FILE_EVENT()`  L21
- `void setMESSAGE_FILE_EVENT(int MESSAGE_FILE_EVENT)`  L25
### `com.gku.actioncam.sigmastar.newUi.userCenter.model.UserCenterItem`
L7 · [class] public UserCenterItem · implements `Parcelable` · `com/gku/actioncam/sigmastar/newUi/userCenter/model/UserCenterItem.java`

字段/常量（6）：
- `boolean IsOutLink`  L21
- `boolean IsTitle`  L22
- `String ItemName`  L23
- `String Title`  L24
- `int drawableID`  L25
- `String url`  L26

方法（19）：
- `UserCenterItem createFromParcel(Parcel source)`  L11 @Override
- `UserCenterItem[] newArray(int size)`  L17 @Override
- `int describeContents()`  L29 @Override
- `public UserCenterItem(boolean isTitle, String title, String itemName, int drawableID, String url, boolean isOutLink)`  L33
- `boolean isTitle()`  L42
- `void setTitle(boolean title)`  L46
- `String getTitle()`  L50
- `void setTitle(String title)`  L54
- `String getItemName()`  L58
- `void setItemName(String itemName)`  L62
- `int getDrawableID()`  L66
- `void setDrawableID(int drawableID)`  L70
- `String getUrl()`  L74
- `void setUrl(String url)`  L78
- `boolean isOutLink()`  L82
- `void setOutLink(boolean outLink)`  L86
- `Parcelable.Creator<UserCenterItem> getCREATOR()`  L90
- `void writeToParcel(Parcel parcel, int i)`  L95 @Override
- `protected UserCenterItem(Parcel in)`  L104
### `com.gku.actioncam.sigmastar.newUi.userCenter.model.UserCenterItemYutupro`
L7 · [class] public UserCenterItemYutupro · implements `Parcelable` · `com/gku/actioncam/sigmastar/newUi/userCenter/model/UserCenterItemYutupro.java`

字段/常量（5）：
- `int bgId`  L21
- `int drawableId`  L22
- `boolean isOutLink`  L23
- `String itemName`  L24
- `String url`  L25

方法（16）：
- `UserCenterItemYutupro createFromParcel(Parcel in)`  L11 @Override
- `UserCenterItemYutupro[] newArray(int size)`  L17 @Override
- `int describeContents()`  L28 @Override
- `public UserCenterItemYutupro(String itemName, int drawableId, int bgId, boolean isOutLink, String url)`  L32
- `String getItemName()`  L40
- `void setItemName(String itemName)`  L44
- `int getDrawableId()`  L48
- `void setDrawableId(int drawableId)`  L52
- `int getBgId()`  L56
- `void setBgId(int bgId)`  L60
- `boolean isOutLink()`  L64
- `void setOutLink(boolean outLink)`  L68
- `String getUrl()`  L72
- `void setUrl(String url)`  L76
- `public UserCenterItemYutupro(Parcel in)`  L80
- `void writeToParcel(Parcel parcel, int i)`  L89 @Override
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.activity.QuestionDescription`
L35 · [class] public QuestionDescription · extends `BaseActivity` · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/activity/QuestionDescription.java`

字段/常量（27）：
- `String contactType`  L36
- `EditText detailContent`  L37
- `String detailContentText`  L38
- `String issueType`  L39
- `ImageView ivBack`  L40
- `Handler mHandler`  L41
- `RadioButton radioEmail`  L42
- `RadioGroup radioGroup`  L43
- `RadioButton radioPhone`  L44
- `EditText remainContactDetails`  L45
- `String remainContactText`  L46
- `Button submitButton`  L47
- `TextView title`  L48
- `Resources resources`  L52
- `int i`  L53
- `QuestionDescription questionDescription = QuestionDescription.this`  L76
- `QuestionDescription questionDescription = QuestionDescription.this`  L91
- `boolean z`  L128
- `File file`  L129
- `File file2`  L130
- `String[] strArr`  L131
- `CameraInfors cameraInfors`  L132
- `String str`  L133
- `Uri uriForFileSimple`  L134
- `File[] fileArrListFiles`  L135
- `QuestionDescription questionDescription = QuestionDescription.this`  L145
- `QuestionDescription questionDescription2 = QuestionDescription.this`  L157

方法（23）：
- `void onCreate(Bundle savedInstanceState)`  L51 @Override
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L67 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L71 @Override
- `void afterTextChanged(Editable s)`  L75 @Override
- `void beforeTextChanged(CharSequence s, int start, int count, int after)`  L82 @Override
- `void onTextChanged(CharSequence s, int start, int before, int count)`  L86 @Override
- `void afterTextChanged(Editable s)`  L90 @Override
- `void onClick(View v)`  L111 @Override
- `void onClick(View v)`  L127 @Override
- `void run()`  L139 @Override
- `void run()`  L151 @Override
- `void run()`  L163 @Override
    - 体内字面量："android.intent.action.SEND" · "CrashLog" · "support@xtucam.com" · "yangzihe@xtucam.com" · "techsupport@gkuvision.com" · "\n" · "\n" · "\\." · " 8.4.3_243_2026-08-19-17-05-43\n" · "\n" · "\n" · "ï¼" · "\n" · "\\." · " 8.4.3_243_2026-08-19-17-05-43\n" · "\n" · "\n" · "ï¼" · "application/octet-stream" · "android.intent.extra.EMAIL" · "android.intent.extra.SUBJECT" · "android.intent.extra.TEXT"
- `void run()`  L199 @Override
    - 体内字面量："android.intent.extra.STREAM"
- `void run()`  L211 @Override
    - 体内字面量："æ æ³æå¼ç³»ç»é®ç®±ï¼è¯·æ£æ¥æ¯å¦å·²å®è£ï¼éå°çé®é¢æ¯ï¼" · "android.intent.action.SEND" · "CrashLog" · "support@xtucam.com" · "yangzihe@xtucam.com" · "techsupport@gkuvision.com" · "\n" · "\n" · "\\." · " 8.4.3_243_2026-08-19-17-05-43\n" · "\n" · "\n" · "ï¼" · "\n" · "\\." · " 8.4.3_243_2026-08-19-17-05-43\n" · "\n" · "\n" · "ï¼" · "application/octet-stream" · "android.intent.extra.EMAIL" · "android.intent.extra.SUBJECT" · "android.intent.extra.TEXT" · "android.intent.extra.STREAM"
- `void onResume()`  L254 @Override
- `void onStart()`  L259 @Override
- `void onPause()`  L264 @Override
- `void onStop()`  L269 @Override
- `void onDestroy()`  L274 @Override
- `void onRestart()`  L279 @Override
- `void onRadioButtonClicked(View view)`  L283
- `boolean isPhone(String number)`  L294
    - 体内字面量："[1][358]\\d{9}"
- `boolean isEmail(String strEmail)`  L302
    - 体内字面量："^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$" · "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$"
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.activity.QuestionSelect`
L15 · [class] public QuestionSelect · extends `BaseActivity` · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/activity/QuestionSelect.java`

字段/常量（3）：
- `ImageView ivBack`  L16
- `LinearLayoutManager linearLayoutManager`  L17
- `RecyclerView rvQuestionSelect`  L18

方法（11）：
- `void onCreate(Bundle savedInstanceState)`  L21 @Override
- `boolean canScrollHorizontally()`  L28 @Override
- `boolean canScrollVertically()`  L33 @Override
- `void onClick(int position)`  L50 @Override
    - 体内字面量："issueName"
- `void onClick(View v)`  L59 @Override
- `void onResume()`  L66 @Override
- `void onStart()`  L71 @Override
- `void onPause()`  L76 @Override
- `void onStop()`  L81 @Override
- `void onDestroy()`  L86 @Override
- `void onRestart()`  L91 @Override
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.adapter.QuestionSelectAdapter`
L12 · [class] public QuestionSelectAdapter · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/adapter/QuestionSelectAdapter.java`

字段/常量（3）：
- `List<String> issueSelectItemList`  L13
- `OnItemClickListener onItemClickListener`  L14
- `List<String> list = this.issueSelectItemList`  L46

方法（6）：
- `public QuestionSelectAdapter(List<String> issueSelectItemList)`  L20
- `void setItemClick(OnItemClickListener onItemClickListener)`  L24
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L29 @Override
- `void onBindViewHolder(MyViewHolder holder, final int position)`  L34 @Override
- `void onClick(View v)`  L38 @Override
- `int getItemCount()`  L45 @Override
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.adapter.QuestionSelectAdapter$MyViewHolder`
L53 · [class] static MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/adapter/QuestionSelectAdapter.java`

字段/常量（1）：
- `TextView itemText`  L54

方法（1）：
- `public MyViewHolder(View itemView)`  L56
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.adapter.QuestionSelectAdapter$OnItemClickListener`
L16 · [interface] public OnItemClickListener · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/adapter/QuestionSelectAdapter.java`

方法（1）：
- `void onClick(int position)`  L17
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.adapter.UserCenterAdapter`
L19 · [class] public UserCenterAdapter · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/adapter/UserCenterAdapter.java`

字段/常量（10）：
- `ArrayList<UserCenterItem> ItemList`  L20
- `boolean isGrid`  L21
- `Context mContext`  L22
- `OnItemClickListener mOnItemClickListener`  L23
- `RecyclerView mRecyclerView`  L24
- `int TYPE_TITLE = 0`  L25
- `int TYPE_ITEM = 1`  L26
- `View viewInflate`  L47
- `ArrayList<UserCenterItem> arrayList = this.ItemList`  L102
- `RecyclerView recyclerView = this.mRecyclerView`  L147

方法（10）：
- `void setOnItemClickListener(OnItemClickListener mOnItemClickListener)`  L32
- `public UserCenterAdapter(Context mContext, ArrayList<UserCenterItem> ItemList)`  L36
    - 体内字面量："å¶ä»"
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L46 @Override
- `void onBindViewHolder(final MyViewHolder holder, final int position)`  L57 @Override
    - 体内字面量："window"
- `void onClick(View v)`  L75 @Override
- `int getItemCount()`  L101 @Override
- `int getItemViewType(int position)`  L127 @Override
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L135 @Override
- `void ifGridLayoutManager()`  L146
- `int getSpanSize(int position)`  L157 @Override
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.adapter.UserCenterAdapter$MyViewHolder`
L109 · [class] public MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/adapter/UserCenterAdapter.java`

字段/常量（5）：
- `ImageView ImageNext`  L110
- `ImageView ItemIcon`  L111
- `TextView ItemTitle`  L112
- `View itemBottomLine`  L113
- `RelativeLayout relativeLayout`  L114

方法（1）：
- `public MyViewHolder(View itemView)`  L116
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.adapter.UserCenterAdapter$OnItemClickListener`
L28 · [interface] public OnItemClickListener · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/adapter/UserCenterAdapter.java`

方法（1）：
- `void onItemClick(int position)`  L29
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.adapter.UserCenterAdapterYutupro`
L16 · [class] public UserCenterAdapterYutupro · extends `RecyclerView.Adapter<MyViewHolder>` · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/adapter/UserCenterAdapterYutupro.java`

字段/常量（5）：
- `ArrayList<UserCenterItemYutupro> itemList`  L17
- `Context mContext`  L18
- `OnItemClickListener onItemClickListener`  L19
- `int i = dimensionPixelSize / 3`  L38
- `ArrayList<UserCenterItemYutupro> arrayList = this.itemList`  L54

方法（6）：
- `MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L26 @Override
- `void onBindViewHolder(MyViewHolder holder, final int position)`  L31 @Override
- `void onClick(View v)`  L44 @Override
- `int getItemCount()`  L53 @Override
- `void setOnItemClickListener(OnItemClickListener onItemClickListener)`  L61
- `public UserCenterAdapterYutupro(Context context, ArrayList<UserCenterItemYutupro> itemList)`  L65
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.adapter.UserCenterAdapterYutupro$MyViewHolder`
L70 · [class] public MyViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/adapter/UserCenterAdapterYutupro.java`

字段/常量（3）：
- `ConstraintLayout constraintLayout`  L71
- `ImageView imageView`  L72
- `TextView itemName`  L73

方法（1）：
- `public MyViewHolder(View itemView)`  L75
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.adapter.UserCenterAdapterYutupro$OnItemClickListener`
L21 · [interface] public OnItemClickListener · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/adapter/UserCenterAdapterYutupro.java`

方法（1）：
- `void onItemClick(int position)`  L22
### `com.gku.actioncam.sigmastar.newUi.userCenter.ui.fragment.UserCenter`
L48 · [class] public UserCenter · extends `Fragment` · `com/gku/actioncam/sigmastar/newUi/userCenter/ui/fragment/UserCenter.java`

字段/常量（14）：
- `boolean IsCN`  L49
- `UserCenterAdapter adapter`  L50
- `UserCenterAdapter adapterOther`  L51
- `UserCenterAdapterYutupro adapterYutupro`  L52
- `Context mContext`  L56
- `RelativeLayout recyclerRelative`  L57
- `RecyclerView recyclerUser`  L58
- `RecyclerView recyclerUserOther`  L59
- `RecyclerView recyclerUserYutupro`  L60
- `Lifecycle.Event event2 = Lifecycle.Event.ON_RESUME`  L102
- `ArrayList<UserCenterItemYutupro> arrayList = this.listYutupro`  L117
- `ArrayList<UserCenterItem> arrayList2 = this.listOther`  L125
- `int i = 1`  L234
- `boolean z = false`  L235

方法（24）：
- `UserCenter newInstance()`  L62
- `void onCreate(Bundle savedInstanceState)`  L69 @Override
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L75 @Override
- `void onDestroyView()`  L85 @Override
- `void onActivityCreated(Bundle savedInstanceState)`  L90 @Override
- `void onStateChanged(LifecycleOwner source, Lifecycle.Event event)`  L101 @Override
- `void onResume()`  L108 @Override
- `void setUserVisibleHint(boolean isVisibleToUser)`  L113 @Override
- `void initViewYutupro()`  L131
    - 体内字面量："(" · ")"
- `boolean canScrollHorizontally()`  L145 @Override
- `boolean canScrollVertically()`  L150 @Override
- `int getSpanSize(int position)`  L156 @Override
- `void onItemClick(int position)`  L165 @Override
    - 体内字面量："android.intent.action.VIEW" · "(" · ")" · "payload"
- `void initView(boolean isCN)`  L194
    - 体内字面量："https://shop183741064.m.taobao.com" · "https://xtucp.tmall.com/?spm=a1z10.3-b-s.w20166435-22198852064.1.35dc182aeGhCvE&scene=taobao_shop" · "https://h5.m.jd.com/dev/RLVegkgjdNJoM4Y1WsvAnKLD7Qw/index.html?appurl=https%3A%2F%2Fshop.m.jd.com%3FshopId%3D807701%26utm_source%3Dpdappwakeupup_20170002" · "https://m.weibo.cn/p/1005055290451249" · "å¶ä»" · "http://www.xtucam.com/index.php?r=article/Category/index&class_id=19" · "(" · ")" · "https://www.facebook.com/" · "https://www.youtube.com/" · "å¶ä»" · "https://www.xtucam.com/index.php?r=article/Category/index&class_id=19" · "(" · ")" · "window"
- `boolean canScrollHorizontally()`  L238 @Override
- `boolean canScrollVertically()`  L243 @Override
- `void onItemClick(int position)`  L251 @Override
    - 体内字面量："android.intent.action.VIEW" · "clipboard" · "text"
- `boolean canScrollHorizontally()`  L275 @Override
- `boolean canScrollVertically()`  L280 @Override
- `void onItemClick(int position)`  L288 @Override
    - 体内字面量："(" · ")" · "payload"
- `void showWeiXinIsExistDialog()`  L319
- `void onClick(View v)`  L329 @Override
- `void onClick(View v)`  L335 @Override
    - 体内字面量："com.tencent.mm" · "com.tencent.mm.ui.LauncherUI" · "android.intent.action.MAIN" · "android.intent.category.LAUNCHER" · "ä½ è¿æ²¡æå®è£å¾®ä¿¡APP"
- `boolean isWeiXinAvailable(Context context)`  L354
    - 体内字面量："com.tencent.mm"
### `com.gku.actioncam.sigmastar.newUi.userCenter.utils.ToastUtils`
L7 · [class] public final ToastUtils · `com/gku/actioncam/sigmastar/newUi/userCenter/utils/ToastUtils.java`

字段/常量（1）：
- `Toast sToast`  L8

方法（5）：
- `Toast getToast(Context context)`  L10
- `void show(Context context, String tip)`  L17
- `void show(Context context, int tipSid)`  L24
- `void show2(Context context, String tip)`  L31
- `void show2(Context context, int tipSid)`  L38