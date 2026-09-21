# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.localimage

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 37 个文件 / 89 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.AlbumAdapter`
L19 · [class] public AlbumAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/AlbumAdapter.java`

字段/常量（5）：
- `int TYPE`  L20
- `String currentDate = "<binary/metadata>"`  L21
- `List<AlbumItemModel> list`  L22
- `Context mContext`  L23
- `OnItemClickListener mOnItemClickListener`  L24

方法（6）：
- `void setOnItemClickListener(OnItemClickListener mOnItemClickListener)`  L30
- `public AlbumAdapter(List<AlbumItemModel> datas, Context mContext, int TYPE)`  L34
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L41 @Override
- `void onBindViewHolder(final ViewHolder holder, final int position)`  L46 @Override
    - 体内字面量："1213231" · "onBindViewHolder:  ---------------  "
- `void onClick(View v)`  L67 @Override
- `int getItemCount()`  L76 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.AlbumAdapter$OnItemClickListener`
L26 · [interface] public OnItemClickListener · `com/gku/actioncam/hisilicon/dv/localimage/adapter/AlbumAdapter.java`

方法（1）：
- `void onItemClick(View view, int position)`  L27
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.AlbumAdapter$ViewHolder`
L80 · [class] public ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/AlbumAdapter.java`

字段/常量（4）：
- `TextView DateTime`  L81
- `ImageView ItemIcon`  L82
- `ImageView ItemSelect`  L83
- `ImageView VideoPlayBtn`  L84

方法（1）：
- `public ViewHolder(View itemView)`  L86
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.AlbumPagerAdapter`
L11 · [class] public AlbumPagerAdapter · extends `FragmentPagerAdapter` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/AlbumPagerAdapter.java`

字段/常量（6）：
- `boolean IsPhoto`  L12
- `AlbumNormalFragment fragment`  L13
- `AlbumNormalFragment fragment1`  L14
- `AlbumNormalFragment fragment2`  L15
- `AlbumNormalFragment fragment3`  L16
- `Context mContext`  L17

方法（4）：
- `int getCount()`  L20 @Override
- `public AlbumPagerAdapter(FragmentManager fm, Context context, boolean IsPhoto)`  L24
- `CharSequence getPageTitle(int position)`  L35 @Override
- `Fragment getItem(int position)`  L49 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.AlbumPreviewPagerAdapter`
L15 · [class] public AlbumPreviewPagerAdapter · extends `PagerAdapter` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/AlbumPreviewPagerAdapter.java`

字段/常量（3）：
- `List<AlbumItemModel> mDatas`  L16
- `OnAlbumPreviewItemClickListener mListener`  L17
- `List<AlbumItemModel> list = this.mDatas`  L40

方法（7）：
- `int getItemPosition(Object object)`  L24 @Override
- `boolean isViewFromObject(View view, Object object)`  L29 @Override
- `public AlbumPreviewPagerAdapter(List<AlbumItemModel> datas, OnAlbumPreviewItemClickListener listener)`  L33
- `int getCount()`  L39 @Override
- `Object instantiateItem(ViewGroup container, final int position)`  L48 @Override
    - 体内字面量："4561231" · "instantiateItem:  --------------  "
- `void onClick(View v)`  L65 @Override
- `void destroyItem(ViewGroup container, int position, Object object)`  L75 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.AlbumPreviewPagerAdapter$OnAlbumPreviewItemClickListener`
L19 · [interface] public OnAlbumPreviewItemClickListener · `com/gku/actioncam/hisilicon/dv/localimage/adapter/AlbumPreviewPagerAdapter.java`

方法（1）：
- `void onAlbumPreviewItemClick(int position)`  L20
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.AlbumSubAdapter`
L14 · [class] public AlbumSubAdapter · extends `SectionAdapter<AlbumItemModel>` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/AlbumSubAdapter.java`

字段/常量（3）：
- `String TAG = "AlbumSubAdapter"`  L15
- `int mItemWidth`  L16
- `int i = this.mItemWidth`  L59

方法（7）：
- `public AlbumSubAdapter(Context context, List<AlbumItemModel> datas)`  L18
- `int sectionHeaderLayoutId()`  L21 @Override
- `int sectionTitleTextViewId()`  L26 @Override
- `String getTitle(AlbumItemModel model)`  L31 @Override
    - 体内字面量："window"
- `void notifyNoFlash()`  L42
- `void convert(ViewHolder holder, AlbumItemModel model)`  L47 @Override
- `int[] getWH()`  L58 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.CommonAdapter`
L13 · [class] public abstract CommonAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/CommonAdapter.java`

字段/常量（5）：
- `Context mContext`  L15
- `List<T> mDatas`  L16
- `LayoutInflater mInflater`  L17
- `int mLayoutId`  L18
- `CommonClickListener mListener`  L19

方法（7）：
- `void convert(ViewHolder holder, T t)`  L25
- `public CommonAdapter(Context context, int layoutId, List<T> datas)`  L27
- `ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType)`  L35 @Override
- `void onBindViewHolder(final ViewHolder holder, int position)`  L40 @Override
- `void onClick(View v)`  L49 @Override
- `int getItemCount()`  L60 @Override
- `void addCommonClickListener(CommonClickListener listener)`  L64
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.CommonAdapter$CommonClickListener`
L21 · [interface] public CommonClickListener · `com/gku/actioncam/hisilicon/dv/localimage/adapter/CommonAdapter.java`

方法（1）：
- `void onCommonClick(int position)`  L22
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.HomeFragmentAdapter`
L7 · [class] public HomeFragmentAdapter · implements `FragmentNavigatorAdapter` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/HomeFragmentAdapter.java`

字段/常量（2）：
- `boolean IsPhoto`  L8
- `AlbumFragment fragment = null`  L9

方法（4）：
- `int getCount()`  L12 @Override
- `AlbumFragment onCreateFragment(int position)`  L17 @Override
- `public HomeFragmentAdapter(boolean IsPhoto)`  L23
- `String getTag(int position)`  L28 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.HomeFragmentCaddxAdapter`
L7 · [class] public HomeFragmentCaddxAdapter · implements `FragmentNavigatorAdapter` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/HomeFragmentCaddxAdapter.java`

字段/常量（2）：
- `boolean IsPhoto`  L8
- `AlbumFragmentCaddx fragment = null`  L9

方法（4）：
- `int getCount()`  L12 @Override
- `AlbumFragmentCaddx onCreateFragment(int position)`  L17 @Override
- `public HomeFragmentCaddxAdapter(boolean IsPhoto)`  L23
- `String getTag(int position)`  L28 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.MultiItemCommonAdapter`
L8 · [class] public abstract MultiItemCommonAdapter · extends `CommonAdapter<T>` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/MultiItemCommonAdapter.java`

字段/常量（1）：
- `MultiItemTypeSupport<T> mMultiItemTypeSupport`  L9

方法（3）：
- `public MultiItemCommonAdapter(Context context, List<T> datas, MultiItemTypeSupport multiItemTypeSupport)`  L11
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L17 @Override
- `int getItemViewType(int i)`  L32 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.MultiItemTypeSupport`
L4 · [interface] public MultiItemTypeSupport · `com/gku/actioncam/hisilicon/dv/localimage/adapter/MultiItemTypeSupport.java`

方法（2）：
- `int getItemViewType(int position, T t)`  L5
- `int getLayoutId(int itemType)`  L7
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.SectionAdapter`
L13 · [class] public abstract SectionAdapter · extends `MultiItemCommonAdapter<T>` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/SectionAdapter.java`

字段/常量（10）：
- `int TYPE_SECTION = 0`  L14
- `MultiItemTypeSupport headerItemTypeSupport`  L15
- `RecyclerView mRecyclerView`  L16
- `SectionSupport mSectionSupport`  L17
- `LinkedHashMap<String, Integer> mSections`  L18
- `RecyclerView.AdapterDataObserver observer`  L19
- `int i = 0`  L33
- `RecyclerView recyclerView = this.mRecyclerView`  L41
- `int i = 0`  L97
- `int[] wh`  L121

方法（14）：
- `int[] getWH()`  L21
- `int getItemViewType(int position)`  L26 @Override
- `void findSection()`  L30
- `int getSpanSize(int position)`  L49 @Override
- `public SectionAdapter(Context context, List<T> datas, int layoutId, SectionSupport sectionSupport)`  L60
- `int getLayoutId(int itemType)`  L64 @Override
- `int getItemViewType(int i, Object obj)`  L72 @Override
- `void onChanged()`  L78 @Override
- `int getItemCount()`  L91 @Override
- `int getIndexForPosition(int position)`  L95
- `void onBindViewHolder(ViewHolder holder, int position)`  L107 @Override
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L120 @Override
- `void onAttachedToRecyclerView(RecyclerView recyclerView)`  L130 @Override
- `void onDetachedFromRecyclerView(RecyclerView recyclerView)`  L137 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.SectionSupport`
L4 · [interface] public SectionSupport · `com/gku/actioncam/hisilicon/dv/localimage/adapter/SectionSupport.java`

方法（3）：
- `String getTitle(T t)`  L5
- `int sectionHeaderLayoutId()`  L7
- `int sectionTitleTextViewId()`  L9
### `com.gku.actioncam.hisilicon.dv.localimage.adapter.ViewHolder`
L15 · [class] public ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/hisilicon/dv/localimage/adapter/ViewHolder.java`

字段/常量（7）：
- `LinkedHashSet<Integer> clickViewIds`  L16
- `Context mContext`  L17
- `View mConvertView`  L18
- `int mLayoutId`  L19
- `int mPosition`  L20
- `SparseArray<View> mViews`  L21
- `View view = this.mConvertView`  L38

方法（19）：
- `public ViewHolder(Context context, View itemView)`  L23
- `ViewHolder get(Context context, ViewGroup parent, int layoutId)`  L31
- `void afreshWH(int width, int height)`  L37
- `T getView(int i)`  L45
- `View getConvertView()`  L55
- `int getLayoutId()`  L59
- `void updatePosition(int position)`  L63
- `int getItemPosition()`  L67
- `ViewHolder setText(int viewId, CharSequence string)`  L71
- `ViewHolder setText(int viewId, int resId)`  L79
- `String getText(int viewId)`  L87
- `ViewHolder setVisibility(int viewId, boolean visibility)`  L95
- `boolean getVisibility(int viewId)`  L106
- `ViewHolder setImageResource(int viewId, int resId)`  L111
- `ViewHolder setTag(int viewId, Object tag)`  L119
- `Object getTag(int viewId)`  L124
- `ViewHolder setSelected(int viewId, boolean boo)`  L128
- `ViewHolder addListener(int viewId)`  L133
- `HashSet<Integer> getClickViewIds()`  L138
### `com.gku.actioncam.hisilicon.dv.localimage.AlbumFragment`
L14 · [class] public AlbumFragment · extends `Fragment` · `com/gku/actioncam/hisilicon/dv/localimage/AlbumFragment.java`

字段/常量（4）：
- `boolean IsPhoto`  L15
- `AlbumPagerAdapter adapter`  L16
- `TabLayout mTablayout`  L17
- `ViewPager mVpager`  L18

方法（10）：
- `public AlbumFragment(boolean IsPhoto)`  L20
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L25 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L30 @Override
- `void onPageScrollStateChanged(int state)`  L42 @Override
- `void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)`  L46 @Override
- `void onPageSelected(int position)`  L50 @Override
- `void onTabReselected(TabLayout.Tab tab)`  L55 @Override
- `void onTabSelected(TabLayout.Tab tab)`  L59 @Override
- `void onTabUnselected(TabLayout.Tab tab)`  L63 @Override
- `void onDestroyView()`  L69 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.AlbumFragmentCaddx`
L16 · [class] public AlbumFragmentCaddx · extends `Fragment` · `com/gku/actioncam/hisilicon/dv/localimage/AlbumFragmentCaddx.java`

字段/常量（4）：
- `AlbumPagerAdapter adapter`  L17
- `String[] mTitles = null`  L18
- `ViewPager mVpager`  L19
- `SegmentTabLayout ss_tab`  L20

方法（7）：
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L23 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L31 @Override
- `void onTabReselect(int position)`  L39 @Override
- `void onTabSelect(int position)`  L43 @Override
- `void onPageScrollStateChanged(int state)`  L54 @Override
- `void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)`  L58 @Override
- `void onPageSelected(int position)`  L62 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.AlbumPreviewActivity`
L37 · [class] public AlbumPreviewActivity · extends `BaseActivity implements Toolbar.OnMenuItemClickListener, PreviewPagerNewAdapter.OnAlbumPreviewItemClickListener` · implements `Toolbar.OnMenuItemClickListener, PreviewPagerNewAdapter.OnAlbumPreviewItemClickListener` · `com/gku/actioncam/hisilicon/dv/localimage/AlbumPreviewActivity.java`

字段/常量（13）：
- `String ARG_DATA = "data"`  L38
- `String ARG_POSITION = "position"`  L39
- `String ARG_TYPE = "TYPE"`  L40
- `String TAG = "AlbumPreviewActivity"`  L41
- `int TYPE`  L42
- `int currentPosition`  L43
- `PreviewPagerNewAdapter mAdapter`  L44
- `List<AlbumNewItemModel> mDatas`  L45
- `ImageView mIvDelete`  L46
- `ImageView mIvEdit`  L47
- `Toolbar mToolbar`  L48
- `ViewPager mVpager`  L49
- `String str = isImage ? "image" : "video"`  L191

方法（19）：
- `void open(Context context, List<AlbumItemModel> datas, int selectPosition, int TYPE)`  L51
    - 体内字面量："data" · "position"
- `void onCreate(Bundle savedInstanceState)`  L60 @Override
- `void onClick(View view)`  L69 @Override
- `void onClick(View view)`  L75 @Override
- `void onClick(View v)`  L83 @Override
    - 体内字面量："Intent is empty!!!" · "position" · "data"
- `void onPageScrollStateChanged(int state)`  L113 @Override
- `void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)`  L117 @Override
- `void onPageSelected(int position)`  L121 @Override
- `void lambda$onCreate$1(View view)`  L132
- `void onClick(DialogInterface dialogInterface, int i)`  L135 @Override
- `void lambda$onCreate$0(DialogInterface dialogInterface, int i)`  L142
- `void lambda$onCreate$2(View view)`  L147
- `void syncTitle(int index)`  L152
    - 体内字面量："/"
- `void delete()`  L156
- `boolean onCreateOptionsMenu(Menu menu)`  L174 @Override
- `boolean onMenuItemClick(MenuItem item)`  L180 @Override
- `void shareContent(boolean isImage, String path)`  L189
- `String getAuthority(Context context)`  L206
- `void onAlbumPreviewItemClick(int position)`  L211 @Override
    - 体内字面量："onAlbumPreviewItemClick: path: " · "LocalVideoPath"
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ColorFilterPreviewTask`
L15 · [class] public ColorFilterPreviewTask · extends `AsyncTask<List<ImageEditObj>, String, Void>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ColorFilterPreviewTask.java`

字段/常量（9）：
- `int count`  L16
- `String mBitmap`  L17
- `String mCacheDir`  L18
- `Callback mCallback`  L19
- `Bitmap sampleBitmap`  L45
- `Callback callback = this.mCallback`  L61
- `int i = this.count`  L63
- `Throwable th`  L72
- `Bitmap bitmapDecodeFile`  L73

方法（5）：
- `public ColorFilterPreviewTask(Context context, String bitmap, Callback callback)`  L25
- `Void doInBackground(List<ImageEditObj>... params)`  L44 @Override
- `void onProgressUpdate(String... values)`  L59 @Override
- `Bitmap getSampleBitmap(String path)`  L71
- `String getColorFilterPreviewImage(Bitmap bitmap, float[] src)`  L114
    - 体内字面量："-" · ".j" · "-" · ".j"
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ColorFilterPreviewTask$Callback`
L21 · [interface] public Callback · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ColorFilterPreviewTask.java`

方法（1）：
- `void onPreviewImageCallback(int position, String previewImagePath)`  L22
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools`
L88 · [class] public GPUImageFilterTools · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（3）：
- `GPUImageFilter createFilterForType(final Context context, final FilterType type)`  L169
- `throw new IllegalStateException( 0 )`  L329
- `GPUImageFilter createBlendFilter(Context context, Class<? extends GPUImageTwoInputFilter> filterClass)`  L333
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster`
L355 · [class] public static FilterAdjuster · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

字段/常量（2）：
- `Adjuster<? extends GPUImageFilter> adjuster`  L356
- `Adjuster<? extends GPUImageFilter> adjuster = this.adjuster`  L489

方法（3）：
- `public FilterAdjuster(final GPUImageFilter filter)`  L358
- `boolean canAdjust()`  L484
- `void adjust(final int percentage)`  L488
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$Adjuster`
L495 · [class] private abstract Adjuster · extends `GPUImageFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

字段/常量（1）：
- `T filter`  L496

方法（6）：
- `void adjust(int percentage)`  L498
- `float range(final int percentage, final float start, final float end)`  L500
- `private Adjuster()`  L504
- `Adjuster<T> filter(final GPUImageFilter filter)`  L508
- `T getFilter()`  L513
- `int range(final int percentage, final int start, final int end)`  L517
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$BilateralAdjuster`
L845 · [class] private BilateralAdjuster · extends `Adjuster<GPUImageBilateralFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private BilateralAdjuster()`  L846
- `void adjust(final int percentage)`  L851 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$BrightnessAdjuster`
L577 · [class] private BrightnessAdjuster · extends `Adjuster<GPUImageBrightnessFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private BrightnessAdjuster()`  L578
- `void adjust(final int percentage)`  L583 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$BulgeDistortionAdjuster`
L766 · [class] private BulgeDistortionAdjuster · extends `Adjuster<GPUImageBulgeDistortionFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private BulgeDistortionAdjuster()`  L767
- `void adjust(final int percentage)`  L772 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$ColorBalanceAdjuster`
L823 · [class] private ColorBalanceAdjuster · extends `Adjuster<GPUImageColorBalanceFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private ColorBalanceAdjuster()`  L824
- `void adjust(int percentage)`  L829 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$ContrastAdjuster`
L555 · [class] private ContrastAdjuster · extends `Adjuster<GPUImageContrastFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private ContrastAdjuster()`  L556
- `void adjust(final int percentage)`  L561 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$CrosshatchBlurAdjuster`
L754 · [class] private CrosshatchBlurAdjuster · extends `Adjuster<GPUImageCrosshatchFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private CrosshatchBlurAdjuster()`  L755
- `void adjust(final int percentage)`  L760 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$DissolveBlendAdjuster`
L732 · [class] private DissolveBlendAdjuster · extends `Adjuster<GPUImageDissolveBlendFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private DissolveBlendAdjuster()`  L733
- `void adjust(final int percentage)`  L738 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$EmbossAdjuster`
L610 · [class] private EmbossAdjuster · extends `Adjuster<GPUImageEmbossFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private EmbossAdjuster()`  L611
- `void adjust(final int percentage)`  L616 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$ExposureAdjuster`
L654 · [class] private ExposureAdjuster · extends `Adjuster<GPUImageExposureFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private ExposureAdjuster()`  L655
- `void adjust(final int percentage)`  L660 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$GammaAdjuster`
L566 · [class] private GammaAdjuster · extends `Adjuster<GPUImageGammaFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private GammaAdjuster()`  L567
- `void adjust(final int percentage)`  L572 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$GaussianBlurAdjuster`
L743 · [class] private GaussianBlurAdjuster · extends `Adjuster<GPUImageGaussianBlurFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private GaussianBlurAdjuster()`  L744
- `void adjust(final int percentage)`  L749 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$GlassSphereAdjuster`
L778 · [class] private GlassSphereAdjuster · extends `Adjuster<GPUImageGlassSphereFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private GlassSphereAdjuster()`  L779
- `void adjust(final int percentage)`  L784 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$GPU3x3TextureAdjuster`
L632 · [class] private GPU3x3TextureAdjuster · extends `Adjuster<GPUImage3x3TextureSamplingFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private GPU3x3TextureAdjuster()`  L633
- `void adjust(final int percentage)`  L638 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$HazeAdjuster`
L789 · [class] private HazeAdjuster · extends `Adjuster<GPUImageHazeFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private HazeAdjuster()`  L790
- `void adjust(final int percentage)`  L795 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$HighlightShadowAdjuster`
L665 · [class] private HighlightShadowAdjuster · extends `Adjuster<GPUImageHighlightShadowFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private HighlightShadowAdjuster()`  L666
- `void adjust(final int percentage)`  L671 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$HueAdjuster`
L544 · [class] private HueAdjuster · extends `Adjuster<GPUImageHueFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private HueAdjuster()`  L545
- `void adjust(final int percentage)`  L550 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$LevelsMinMidAdjuster`
L834 · [class] private LevelsMinMidAdjuster · extends `Adjuster<GPUImageLevelsFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private LevelsMinMidAdjuster()`  L835
- `void adjust(int percentage)`  L840 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$MonochromeAdjuster`
L677 · [class] private MonochromeAdjuster · extends `Adjuster<GPUImageMonochromeFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private MonochromeAdjuster()`  L678
- `void adjust(final int percentage)`  L683 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$OpacityAdjuster`
L688 · [class] private OpacityAdjuster · extends `Adjuster<GPUImageOpacityFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private OpacityAdjuster()`  L689
- `void adjust(final int percentage)`  L694 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$PixelationAdjuster`
L533 · [class] private PixelationAdjuster · extends `Adjuster<GPUImagePixelationFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private PixelationAdjuster()`  L534
- `void adjust(final int percentage)`  L539 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$PosterizeAdjuster`
L621 · [class] private PosterizeAdjuster · extends `Adjuster<GPUImagePosterizeFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private PosterizeAdjuster()`  L622
- `void adjust(final int percentage)`  L627 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$RGBAdjuster`
L699 · [class] private RGBAdjuster · extends `Adjuster<GPUImageRGBFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private RGBAdjuster()`  L700
- `void adjust(final int percentage)`  L705 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$RotateAdjuster`
L856 · [class] private RotateAdjuster · extends `Adjuster<GPUImageTransformFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

字段/常量（1）：
- `float[] fArr = new float[16]`  L863

方法（2）：
- `private RotateAdjuster()`  L857
- `void adjust(final int percentage)`  L862 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$SaturationAdjuster`
L643 · [class] private SaturationAdjuster · extends `Adjuster<GPUImageSaturationFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private SaturationAdjuster()`  L644
- `void adjust(final int percentage)`  L649 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$ScaleAdjuster`
L869 · [class] private ScaleAdjuster · extends `Adjuster<GPUImageColorMatrixFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `void adjust(int percentage)`  L871 @Override
- `private ScaleAdjuster()`  L874
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$SepiaAdjuster`
L588 · [class] private SepiaAdjuster · extends `Adjuster<GPUImageSepiaFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private SepiaAdjuster()`  L589
- `void adjust(final int percentage)`  L594 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$SharpnessAdjuster`
L522 · [class] private SharpnessAdjuster · extends `Adjuster<GPUImageSharpenFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private SharpnessAdjuster()`  L523
- `void adjust(final int percentage)`  L528 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$SobelAdjuster`
L599 · [class] private SobelAdjuster · extends `Adjuster<GPUImageSobelEdgeDetection>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private SobelAdjuster()`  L600
- `void adjust(final int percentage)`  L605 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$SphereRefractionAdjuster`
L801 · [class] private SphereRefractionAdjuster · extends `Adjuster<GPUImageSphereRefractionFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private SphereRefractionAdjuster()`  L802
- `void adjust(final int percentage)`  L807 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$SwirlAdjuster`
L812 · [class] private SwirlAdjuster · extends `Adjuster<GPUImageSwirlFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private SwirlAdjuster()`  L813
- `void adjust(final int percentage)`  L818 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$VignetteAdjuster`
L721 · [class] private VignetteAdjuster · extends `Adjuster<GPUImageVignetteFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private VignetteAdjuster()`  L722
- `void adjust(final int percentage)`  L727 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterAdjuster$WhiteBalanceAdjuster`
L710 · [class] private WhiteBalanceAdjuster · extends `Adjuster<GPUImageWhiteBalanceFilter>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private WhiteBalanceAdjuster()`  L711
- `void adjust(final int percentage)`  L716 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterList`
L342 · [class] private static FilterList · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（2）：
- `private FilterList()`  L346
- `void addFilter(final String name, final FilterType filter)`  L349
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$FilterType`
L90 · [enum] public FilterType · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

枚举常量（71）：
- `CONTRAST()`  L91
- `GRAYSCALE()`  L92
- `SHARPEN()`  L93
- `SEPIA()`  L94
- `SOBEL_EDGE_DETECTION()`  L95
- `THREE_X_THREE_CONVOLUTION()`  L96
- `FILTER_GROUP()`  L97
- `EMBOSS()`  L98
- `POSTERIZE()`  L99
- `GAMMA()`  L100
- `BRIGHTNESS()`  L101
- `INVERT()`  L102
- `HUE()`  L103
- `PIXELATION()`  L104
- `SATURATION()`  L105
- `EXPOSURE()`  L106
- `HIGHLIGHT_SHADOW()`  L107
- `MONOCHROME()`  L108
- `OPACITY()`  L109
- `RGB()`  L110
- `WHITE_BALANCE()`  L111
- `VIGNETTE()`  L112
- `TONE_CURVE()`  L113
- `BLEND_COLOR_BURN()`  L114
- `BLEND_COLOR_DODGE()`  L115
- `BLEND_DARKEN()`  L116
- `BLEND_DIFFERENCE()`  L117
- `BLEND_DISSOLVE()`  L118
- `BLEND_EXCLUSION()`  L119
- `BLEND_SOURCE_OVER()`  L120
- `BLEND_HARD_LIGHT()`  L121
- `BLEND_LIGHTEN()`  L122
- `BLEND_ADD()`  L123
- `BLEND_DIVIDE()`  L124
- `BLEND_MULTIPLY()`  L125
- `BLEND_OVERLAY()`  L126
- `BLEND_SCREEN()`  L127
- `BLEND_ALPHA()`  L128
- `BLEND_COLOR()`  L129
- `BLEND_HUE()`  L130
- `BLEND_SATURATION()`  L131
- `BLEND_LUMINOSITY()`  L132
- `BLEND_LINEAR_BURN()`  L133
- `BLEND_SOFT_LIGHT()`  L134
- `BLEND_SUBTRACT()`  L135
- `BLEND_CHROMA_KEY()`  L136
- `BLEND_NORMAL()`  L137
- `LOOKUP_AMATORKA()`  L138
- `GAUSSIAN_BLUR()`  L139
- `CROSSHATCH()`  L140
- `BOX_BLUR()`  L141
- `CGA_COLORSPACE()`  L142
- `DILATION()`  L143
- `KUWAHARA()`  L144
- `RGB_DILATION()`  L145
- `SKETCH()`  L146
- `TOON()`  L147
- `SMOOTH_TOON()`  L148
- `BULGE_DISTORTION()`  L149
- `GLASS_SPHERE()`  L150
- `HAZE()`  L151
- `LAPLACIAN()`  L152
- `NON_MAXIMUM_SUPPRESSION()`  L153
- `SPHERE_REFRACTION()`  L154
- `SWIRL()`  L155
- `WEAK_PIXEL_INCLUSION()`  L156
- `FALSE_COLOR()`  L157
- `COLOR_BALANCE()`  L158
- `LEVELS_FILTER_MIN()`  L159
- `BILATERAL_BLUR()`  L160
- `HALFTONE()`  L161
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.GPUImageFilterTools$OnGpuImageFilterChosenListener`
L165 · [interface] public OnGpuImageFilterChosenListener · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/GPUImageFilterTools.java`

方法（1）：
- `void onGpuImageFilterChosenListener(GPUImageFilter filter)`  L166
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEdit`
L12 · [class] public ImageEdit · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEdit.java`

字段/常量（11）：
- `String mColorFilterPath`  L13
- `ImageEditProgressListener mListener`  L14
- `String mRotationPath`  L15
- `boolean release`  L16
- `ImageEditProgressListener imageEditProgressListener = this.mListener`  L41
- `ImageEditProgressListener imageEditProgressListener = this.mListener`  L72
- `ImageEdit imageEdit = ImageEdit.this`  L80
- `Throwable th`  L103
- `Bitmap bitmap`  L104
- `Bitmap bitmap2`  L105
- `Bitmap bitmapCreateBitmap = null`  L106

方法（9）：
- `public ImageEdit(Context context, ImageEditProgressListener listener)`  L28
    - 体内字面量："rotation.jpg" · "colorFilter.jpg"
- `void setColorFilter(final String inPath, final float[] src, final CallBack callBack)`  L35
- `String doInBackground(Void... params)`  L48 @Override
- `void onPostExecute(String result)`  L57 @Override
- `void rotationImage(final String inPath, final float angle, final CallBack callBack)`  L71
- `String doInBackground(Void... params)`  L79 @Override
- `void onPostExecute(String result)`  L89 @Override
- `boolean rotationImage2(String inPath, String outPath, float angle)`  L102
- `void release(Context context)`  L167
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEdit$CallBack`
L18 · [interface] public CallBack · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEdit.java`

方法（1）：
- `void imageEditResult(String path)`  L19
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEdit$ImageEditProgressListener`
L22 · [interface] public ImageEditProgressListener · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEdit.java`

方法（2）：
- `void onFinishEdit()`  L23
- `void onStartEdit()`  L25
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditActivity`
L34 · [class] public ImageEditActivity · extends `BaseActivity implements SimpleTabLinearLayout.TabSelectListener, ImageEditObjAdapter.OnEditObjSelectListener, ColorFilterPreviewTask.Callback, ImageEdit.ImageEditProgressListener, Toolbar.OnMenuItemClickListener` · implements `SimpleTabLinearLayout.TabSelectListener, ImageEditObjAdapter.OnEditObjSelectListener, ColorFilterPreviewTask.Callback, ImageEdit.ImageEditProgressListener, Toolbar.OnMenuItemClickListener` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditActivity.java`

字段/常量（25）：
- `String ARG_PATH = "imagepath"`  L35
- `String TAG = "ImageEditActivity"`  L36
- `String cameraType`  L37
- `boolean isRotation`  L38
- `float mCoverRotation`  L39
- `List<ImageEditObj> mCurrentEffectObjs`  L40
- `ImageEditObjAdapter mEditObjAdapter`  L41
- `List<ImageEditObj> mEffectObjs`  L42
- `List<ImageEditObj> mFilterObjs`  L43
- `String mImageColorFilterPath`  L44
- `ImageEdit mImageEdit`  L45
- `String mImageResultPath`  L46
- `String mImageRotationPath`  L47
- `String mImageSourcePath`  L48
- `ProgressDialog mProgressDialog`  L49
- `PhotoView mPvCover`  L50
- `RecyclerView mRlvAction`  L51
- `SimpleTabLinearLayout mTab`  L52
- `Toolbar mToolbar`  L53
- `List<ImageEditObj> mToolsObjs`  L54
- `PhotoView photoView = this.mPvCover`  L174
- `List<ImageEditObj> list = this.mCurrentEffectObjs`  L303
- `ProgressDialog progressDialog = this.mProgressDialog`  L322
- `String str`  L330
- `ImageEdit imageEdit = this.mImageEdit`  L353

方法（26）：
- `void open(Context context, String imagePath)`  L56
- `void onCreate(Bundle savedInstanceState)`  L63 @Override
    - 体内字面量："/"
- `void onClick(View v)`  L77 @Override
- `void init()`  L87
    - 体内字面量："DashCam"
- `void refreshCover(String path)`  L108
- `void setUpActionRecycleView()`  L116
- `void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)`  L120 @Override
- `boolean onCreateOptionsMenu(Menu menu)`  L140 @Override
- `void onTabSelect(View v)`  L146 @Override
- `List<ImageEditObj> checkNullDatas(List<ImageEditObj> datas, int mode)`  L168
- `void resetImageCover()`  L172
- `ImageEdit getImageEdit()`  L179
- `String getColorFilterImagePath()`  L186
- `String getRotationImagePath()`  L190
- `void rotationImage(float angle)`  L194
- `void imageEditResult(String path)`  L198 @Override
- `void onEditObjSelect(int r4)`  L220 @Override
- `throw new UnsupportedOperationException( 4 )`  L284
- `void onStart()`  L288 @Override
- `String getResultPath()`  L296
- `void onPreviewImageCallback(int position, String previewImagePath)`  L301 @Override
- `void onStartEdit()`  L311 @Override
- `void onFinishEdit()`  L321 @Override
- `boolean onMenuItemClick(MenuItem item)`  L329 @Override
- `void onDestroy()`  L351 @Override
- `void onMessageEvent(MessageEvent messageEvent)`  L361 @Subscribe(threadMode = ThreadMode.MAIN)
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditClipActivity`
L28 · [class] public ImageEditClipActivity · extends `BaseActivity` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditClipActivity.java`

字段/常量（15）：
- `String ARG_PATH = "path"`  L29
- `String ARG_ROTATION = "rotation"`  L30
- `String CROP_RESULT_ASPECT_RATIO = "cropResultAspectRatio"`  L31
- `String TAG = "ImageEditClipActivity"`  L32
- `GestureCropImageView mGestureCropImageView`  L33
- `OverlayView mOverlayView`  L34
- `ProgressDialog mProgressDialog`  L35
- `String mSourceImagePath`  L36
- `Toolbar mToolbar`  L37
- `TextView mTvSize`  L38
- `UCropView mUcvCover`  L39
- `float mCropAspectRatio = 0.0f`  L40
- `int cnt = 0`  L41
- `float f = fWidth / currentScale`  L147
- `float f2 = fHeight / currentScale`  L148

方法（13）：
- `void open(Context context, String imagePath, float rotation)`  L43
    - 体内字面量："path" · "rotation"
- `void onCreate(Bundle savedInstanceState)`  L51 @Override
- `void onClick(View v)`  L61 @Override
- `void onClick(View view)`  L68 @Override
- `void onClick(View view)`  L74 @Override
- `void lambda$onCreate$0(View view)`  L81
- `void lambda$onCreate$1(View view)`  L86
- `void saveCropPhoto()`  L90
- `void onBitmapCropped(Uri resultUri, int offsetX, int offsetY, int imageWidth, int imageHeight)`  L93 @Override
    - 体内字面量："onBitmapCropped:  -------resultUri.getPath()----------   "
- `void onCropFailure(Throwable t)`  L99 @Override
    - 体内字面量："onCropFailure:  ----------------  "
- `void setResultUri(Uri uri)`  L106
    - 体内字面量："setResultUri:  ----------------  " · "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
- `void iniView()`  L117
    - 体内字面量："path" · "rotation" · "iniView:  -----------   " · "/" · "\\."
- `void onCropRectUpdated(RectF cropRect)`  L142 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditEffectActivity`
L24 · [class] public ImageEditEffectActivity · extends `BaseActivity implements SeekBar.OnSeekBarChangeListener` · implements `SeekBar.OnSeekBarChangeListener` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditEffectActivity.java`

字段/常量（28）：
- `String ARG_EFFECT_TYPE = "effect_type"`  L25
- `String ARG_PATH = "path"`  L26
- `boolean refreshImage`  L27
- `GPUImageFilterTools.FilterAdjuster mFilterAdjuster = null`  L28
- `ImageView mIvCancel`  L29
- `GPUImageView mIvCover`  L30
- `ImageView mIvDone`  L31
- `SeekBar mSbSeekbar`  L32
- `String mSourceImagePath`  L33
- `Toolbar mToolbar`  L34
- `Bitmap bitmapCapture = null`  L102
- `ImageEditEffectActivity imageEditEffectActivity = ImageEditEffectActivity.this`  L125
- `GPUImageFilterTools.FilterType filterType`  L151
- `String string`  L152
- `GPUImageFilterTools.FilterType filterType2`  L153
- `String str`  L154
- `String str2 = string`  L159
- `String str3 = string`  L166
- `String str4 = string`  L173
- `String str5 = string`  L180
- `String str6 = string`  L187
- `String str7 = string`  L194
- `String str8 = string`  L203
- `String str9 = string`  L210
- `String str10 = string`  L217
- `String str11 = string`  L224
- `String str12 = string`  L231
- `GPUImageFilterTools.FilterAdjuster filterAdjuster = this.mFilterAdjuster`  L251

方法（15）：
- `void onStartTrackingTouch(SeekBar seekBar)`  L37 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L41 @Override
- `void open(Context context, String imagePath, int effectType)`  L44
    - 体内字面量："path"
- `void onCreate(Bundle savedInstanceState)`  L52 @Override
- `void onClick(View v)`  L64 @Override
- `void onClick(View view)`  L70 @Override
- `void lambda$onCreate$0(View view)`  L80
- `void init()`  L89
    - 体内字面量："path"
- `void saveImage(String path)`  L101
- `void saveImageForBackground()`  L117
- `String doInBackground(Void... params)`  L124 @Override
- `void onPostExecute(String s)`  L132 @Override
- `void setGPUImageFilterAdjust(int effectType)`  L144
- `GPUImageFilter getFilterEffectForType(int effectType)`  L150
- `void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)`  L249 @Override
    - 体内字面量："7894654" · "onProgressChanged:  -------------------   "
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory`
L22 · [class] public ImageEditFactory · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditFactory.java`

字段/常量（17）：
- `String CACHE_DIR = "filterPreviewImages_cache"`  L23
- `String DIR = "filterPreviewImages"`  L24
- `Bitmap bitmap`  L136
- `Bitmap bitmap2`  L137
- `Bitmap bitmapCreateBitmap = null`  L138
- `Bitmap bitmap3 = bitmapCreateBitmap`  L160
- `Bitmap bitmap4 = bitmapCreateBitmap`  L172
- `Bitmap bitmap5 = bitmapCreateBitmap`  L185
- `File[] fileArrListFiles`  L235
- `FileInputStream fileInputStream`  L254
- `Throwable th`  L255
- `FileOutputStream fileOutputStream`  L256
- `byte[] bArr = new byte[1024]`  L268
- `Throwable th`  L360
- `Bitmap bitmap`  L361
- `Bitmap bitmap2`  L362
- `Bitmap bitmapCreateBitmap = null`  L363

方法（13）：
- `List<ImageEditObj> buildImageEditObjs(Context context, int mode)`  L70
- `void getColorFilterPreviewImages(List<ImageEditObj> datas)`  L113
- `Void doInBackground(List<ImageEditObj>... params)`  L117 @Override
- `void onProgressUpdate(String... values)`  L129 @Override
- `boolean setColorFilter(String inPath, String outPath, float[] src)`  L135
- `Bitmap setColorFilter(Bitmap bitmap, float[] src)`  L206
- `String getCachePath(Context context, String fileName)`  L226
- `void clearCache(Context context)`  L234
- `String getFileSuff(String path)`  L245
- `String copyToCachePath(Context context, String path)`  L253
- `void rotationImage(String inPath, String outPath, float angle)`  L347
- `String doInBackground(String... params)`  L351 @Override
- `String rotationImage2(String inPath, String outPath, float angle)`  L359
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory$Effect`
L26 · [interface] public Effect · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditFactory.java`

字段/常量（7）：
- `int BEAUTY = 17`  L27
- `int BLUR = 18`  L28
- `int CARTOON = 19`  L29
- `int FILTER = 273`  L30
- `int RELIEF = 20`  L31
- `int THE_SKETCH = 22`  L32
- `int WHITE_BALANCE = 21`  L33
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory$FilterEffect`
L36 · [interface] public FilterEffect · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditFactory.java`

字段/常量（13）：
- `float[] color_lomo = {1.7f, 0.1f, 0.1f, 0.0f, -73.1f, 0.0f, 1.7f, 0.1f, 0.0f, -73.1f, 0.0f, 0.1f, 1.6f, 0.0f, -73.1f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L37
- `float[] color_heibai = {0.8f, 1.6f, 0.2f, 0.0f, -163.9f, 0.8f, 1.6f, 0.2f, 0.0f, -163.9f, 0.8f, 1.6f, 0.2f, 0.0f, -163.9f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L38
- `float[] color_fugu = {0.2f, 0.5f, 0.1f, 0.0f, 40.8f, 0.2f, 0.5f, 0.1f, 0.0f, 40.8f, 0.2f, 0.5f, 0.1f, 0.0f, 40.8f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L39
- `float[] color_gete = {1.9f, -0.3f, -0.2f, 0.0f, -87.0f, -0.2f, 1.7f, -0.1f, 0.0f, -87.0f, -0.1f, -0.6f, 2.0f, 0.0f, -87.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L40
- `float[] color_ruihua = {4.8f, -1.0f, -0.1f, 0.0f, -388.4f, -0.5f, 4.4f, -0.1f, 0.0f, -388.4f, -0.5f, -1.0f, 5.2f, 0.0f, -388.4f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L41
- `float[] color_danya = {0.6f, 0.3f, 0.1f, 0.0f, 73.3f, 0.2f, 0.7f, 0.1f, 0.0f, 73.3f, 0.2f, 0.3f, 0.4f, 0.0f, 73.3f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L42
- `float[] color_jiuhong = {1.2f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L43
- `float[] color_qingning = {0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L44
- `float[] color_langman = {0.9f, 0.0f, 0.0f, 0.0f, 63.0f, 0.0f, 0.9f, 0.0f, 0.0f, 63.0f, 0.0f, 0.0f, 0.9f, 0.0f, 63.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L45
- `float[] color_guangyun = {0.9f, 0.0f, 0.0f, 0.0f, 64.9f, 0.0f, 0.9f, 0.0f, 0.0f, 64.9f, 0.0f, 0.0f, 0.9f, 0.0f, 64.9f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L46
- `float[] color_landiao = {2.1f, -1.4f, 0.6f, 0.0f, -31.0f, -0.3f, 2.0f, -0.3f, 0.0f, -31.0f, -1.1f, -0.2f, 2.6f, 0.0f, -31.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L47
- `float[] color_menghuan = {0.8f, 0.3f, 0.1f, 0.0f, 46.5f, 0.1f, 0.9f, 0.0f, 0.0f, 46.5f, 0.1f, 0.3f, 0.7f, 0.0f, 46.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L48
- `float[] color_yese = {1.0f, 0.0f, 0.0f, 0.0f, -66.6f, 0.0f, 1.1f, 0.0f, 0.0f, -66.6f, 0.0f, 0.0f, 1.0f, 0.0f, -66.6f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}`  L49
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory$Mode`
L52 · [interface] public Mode · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditFactory.java`

字段/常量（3）：
- `int EFFECT = 3`  L53
- `int FILTER = 2`  L54
- `int TOOLS = 1`  L55
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory$Tools`
L58 · [interface] public Tools · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditFactory.java`

字段/常量（9）：
- `int ACUTANCE = 7`  L59
- `int BRIGHTNESS = 4`  L60
- `int CHROMA = 9`  L61
- `int CLIP = 3`  L62
- `int CONTRAST = 5`  L63
- `int EXPOSURE = 8`  L64
- `int LEFT_ROTATE = 1`  L65
- `int RIGHT_ROTATE = 2`  L66
- `int SATURABILITY = 6`  L67
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditObj`
L4 · [class] public ImageEditObj · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditObj.java`

字段/常量（6）：
- `int effect`  L5
- `float[] filter`  L6
- `boolean isSelect`  L7
- `int previewImageId`  L8
- `String previewImagePath`  L9
- `String previewImageTitle`  L10

方法（11）：
- `public ImageEditObj(String previewImageTitle, int previewImageId, int effect)`  L12
- `public ImageEditObj(int effect, float[] filter)`  L18
- `void setSelect(boolean select)`  L23
- `boolean isSelect()`  L27
- `void setFilter(float[] filter)`  L31
- `float[] getFilter()`  L35
- `void setPreviewImagePath(String path)`  L39
- `String getPreviewImagePath()`  L43
- `int getPreviewImageId()`  L47
- `int getEffect()`  L51
- `String getPreviewImageTitle()`  L55
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditObjAdapter`
L17 · [class] public ImageEditObjAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditObjAdapter.java`

字段/常量（5）：
- `List<ImageEditObj> mDatas`  L18
- `LayoutInflater mInflater`  L19
- `OnEditObjSelectListener mListener`  L20
- `int i = 0`  L71
- `List<ImageEditObj> list = this.mDatas`  L81

方法（7）：
- `public ImageEditObjAdapter(Context context, OnEditObjSelectListener listener)`  L26
- `void switchDatas(List<ImageEditObj> datas)`  L31
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L37 @Override
- `void onBindViewHolder(ViewHolder holder, final int position)`  L42 @Override
- `void onClick(View v)`  L58 @Override
- `void selectObj(int position)`  L67
- `int getItemCount()`  L80 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditObjAdapter$OnEditObjSelectListener`
L22 · [interface] public OnEditObjSelectListener · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditObjAdapter.java`

方法（1）：
- `void onEditObjSelect(int position)`  L23
### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditObjAdapter$ViewHolder`
L88 · [class] public static ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/hisilicon/dv/localimage/ImageEditLib/ImageEditObjAdapter.java`

字段/常量（3）：
- `ImageView iv_bg`  L89
- `TextView tv_title`  L90
- `View v_select_rect`  L91

方法（1）：
- `public ViewHolder(View itemView)`  L93
### `com.gku.actioncam.hisilicon.dv.localimage.LocalAlbumActivity`
L18 · [class] public LocalAlbumActivity · extends `BaseActivity` · `com/gku/actioncam/hisilicon/dv/localimage/LocalAlbumActivity.java`

字段/常量（3）：
- `FragmentNavigator mFragmentNavigator`  L19
- `Bundle savedInstanceState`  L20
- `FragmentNavigator fragmentNavigator = this.mFragmentNavigator`  L50

方法（6）：
- `void initView()`  L22
- `void onCreate(Bundle savedInstanceState)`  L26 @Override
    - 体内字面量："android.permission.READ_EXTERNAL_STORAGE" · "android.permission.READ_EXTERNAL_STORAGE"
- `void onSaveInstanceState(Bundle outState)`  L48 @Override
- `void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)`  L57 @Override
- `void onDestroy()`  L69 @Override
- `void onMessageEvent(MessageEvent messageEvent)`  L75 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："æªæäºæéï¼æ­¤é¡µé¢ä¸å¯ç¨"
### `com.gku.actioncam.hisilicon.dv.localimage.obj.MessageEvent`
L4 · [class] public MessageEvent · `com/gku/actioncam/hisilicon/dv/localimage/obj/MessageEvent.java`

字段/常量（12）：
- `boolean IsClip`  L5
- `boolean IsDeleteFinish`  L6
- `boolean IsDownloadFinish`  L7
- `boolean IsRefershPriview`  L8
- `boolean IsSDCardFull`  L9
- `boolean IsTake`  L10
- `boolean UpdateImageEditActivity`  L11
- `boolean isBackFromPlayback`  L12
- `boolean isDownloadCancel`  L13
- `boolean isReconnect`  L14
- `String path`  L15
- `int update`  L16

方法（26）：
- `public MessageEvent(boolean isTake)`  L18
- `public MessageEvent()`  L22
- `boolean isRefershPriview()`  L25
- `void setRefershPriview(boolean refershPriview)`  L29
- `String getPath()`  L33
- `void setPath(String path)`  L37
- `boolean isUpdateImageEditActivity()`  L41
- `void setUpdateImageEditActivity(boolean updateImageEditActivity)`  L45
- `boolean isTake()`  L49
- `void setTake(boolean take)`  L53
- `int getUpdate()`  L57
- `void setUpdate(int update)`  L61
- `boolean isDownloadFinish()`  L65
- `void setDownloadFinish(boolean downloadFinish)`  L69
- `boolean isClip()`  L73
- `void setClip(boolean clip)`  L77
- `boolean isSDCardFull()`  L81
- `void setSDCardFull(boolean SDCardFull)`  L85
- `boolean isDeleteFinish()`  L89
- `void setDeleteFinish(boolean deleteFinish)`  L93
- `boolean isDownloadCancel()`  L97
- `void setDownloadCancel(boolean downloadCancel)`  L101
- `boolean isBackFromPlayback()`  L105
- `void setBackFromPlayback(boolean backFromPlayback)`  L109
- `boolean isReconnect()`  L113
- `void setReconnect(boolean reconnect)`  L117
### `com.gku.actioncam.hisilicon.dv.localimage.TrackActivity`
L49 · [class] public TrackActivity · extends `BaseActivity` · `com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java`

字段/常量（63）：
- `int MESSAGE_WHAT_CONTROL_BAR = 620`  L50
- `int MESSAGE_WHAT_SEEK_CHANGE = 615`  L51
- `String TAG = "TrackActivity"`  L52
- `GoogleMap _googleMap`  L53
- `LinearLayout bottom_button`  L54
- `LatLng firstLat`  L55
- `AMap gaodeAMap`  L56
- `MapView gaodeMapView`  L57
- `Marker gaodeMarker`  L58
- `List<LatLng> gaodePoints`  L59
- `com.google.android.gms.maps.MapView googleMapView`  L60
- `com.google.android.gms.maps.model.Marker googleMarker`  L61
- `List<GPSInfoBean.GpsBean> gpsBeanList_cp`  L62
- `ConstraintLayout gps_info_constraint`  L63
- `TextView latitude_text`  L64
- `TextView longtitude_text`  L65
- `VideoView mapVideoView`  L66
- `MovingPointOverlay movingPointOverlay`  L67
- `TextView speed_text`  L68
- `ConstraintLayout sr_cl`  L69
- `List<GPSInfoBean.GpsBean> subGpsBeanList`  L70
- `LinearLayout top_button`  L71
- `ImageView track_back_image`  L72
- `LinearLayout track_content_sll`  L73
- `TextView track_video_name`  L74
- `ImageView video_full_screen`  L75
- `SeekBar video_seek`  L76
- `ImageView video_start`  L77
- `boolean isGpsInfoExist = false`  L78
- `GPSInfoBean gpsInfoBean = null`  L79
- `int diff = 0`  L80
- `boolean keepGoogleMarkerMoving = true`  L81
- `int duration = 0`  L83
- `boolean isGaodeMap = false`  L84
- `int i = msg.what`  L89
- `TrackActivity trackActivity = TrackActivity.this`  L99
- `TrackActivity trackActivity2 = TrackActivity.this`  L105
- `TrackActivity trackActivity = TrackActivity.this`  L159
- `LinearLayout linearLayout = this.track_content_sll`  L172
- `ConstraintLayout constraintLayout = this.gps_info_constraint`  L179
- `int i = this.diff`  L233
- `com.google.android.gms.maps.MapView mapView = this.googleMapView`  L279
- `MapView mapView = this.gaodeMapView`  L293
- `com.google.android.gms.maps.MapView mapView2 = this.googleMapView`  L297
- `com.google.android.gms.maps.MapView mapView = this.googleMapView`  L311
- `MapView mapView = this.gaodeMapView`  L326
- `com.google.android.gms.maps.MapView mapView2 = this.googleMapView`  L330
- `ImageView imageView = this.video_start`  L338
- `MapView mapView = this.gaodeMapView`  L348
- `com.google.android.gms.maps.MapView mapView2 = this.googleMapView`  L352
- `MapView mapView = this.gaodeMapView`  L366
- `com.google.android.gms.maps.MapView mapView2 = this.googleMapView`  L370
- `MapView mapView2 = this.gaodeMapView`  L385
- `List<GPSInfoBean.GpsBean> list = this.gpsBeanList_cp`  L447
- `List<LatLng> list2 = this.gaodePoints`  L449
- `List<GPSInfoBean.GpsBean> list3 = this.gpsBeanList_cp`  L453
- `List<LatLng> list4 = this.gaodePoints`  L455
- `AMap aMap`  L460
- `VideoView videoView = this.mapVideoView`  L543
- `double d = interpolation`  L632
- `double d2 = 1.0f - interpolation`  L633
- `int i = seconds / 3600`  L685
- `int i3 = i2 / 60`  L687

方法（45）：
- `void handleMessage(Message msg)`  L87 @Override
- `void onCreate(Bundle savedInstanceState)`  L112 @Override
    - 体内字面量："LocalVideoPath" · "/"
- `void onClick(View view)`  L124 @Override
- `void onClick(View view)`  L131 @Override
- `void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)`  L144 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L148 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L152 @Override
- `void onClick(View view)`  L167 @Override
- `void onClick(View view)`  L189 @Override
- `void lambda$onCreate$0(View view)`  L196
- `void lambda$onCreate$1(View view)`  L201
- `void lambda$onCreate$2(View view)`  L221
- `void lambda$onCreate$3(View view)`  L244
- `void initView()`  L257
- `void onStart()`  L277 @Override
- `void onResume()`  L291 @Override
- `void onStop()`  L309 @Override
- `void onPause()`  L323 @Override
- `void onDestroy()`  L345 @Override
- `void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)`  L364 @Override
- `void initGaodeMapView(Bundle savedInstanceState)`  L380
- `void move(double d)`  L394 @Override
- `void lambda$initGaodeMapView$5(double d)`  L402
- `void run()`  L407 @Override
- `void lambda$initGaodeMapView$4(GPSInfoBean.GpsBean gpsBean)`  L415
    - 体内字面量："%.02f" · "%.03f" · "%.03f" · ":" · ":" · ":"
- `int updateDuration()`  L425
    - 体内字面量："test-updateDuration: "
- `List<LatLng> updatePoints()`  L438
- `void configMap()`  L459
- `void selectMap(GPSInfoBean gpsInfoBean, Bundle savedInstanceState)`  L467
- `void initGoogleMapView(final List<GPSInfoBean.GpsBean> gpsBeans, Bundle saveInstanceState)`  L507
- `void onMapReady(GoogleMap googleMap)`  L513 @Override
    - 体内字面量："initGoogleMapView: "
- `void lambda$initGoogleMapView$6(List list, GoogleMap googleMap)`  L523
- `int updateGooglePoints()`  L542
- `void initGoogleMarker()`  L550
- `float getRotation(double startX, double startY, double endX, double endY)`  L605
- `void animateMarker(final com.google.android.gms.maps.model.Marker marker, final com.google.android.gms.maps.model.LatLng toPosition, final boolean hideMarker)`  L622
- `void run()`  L630 @Override
- `void drawGoogleLine(PolylineOptions polylineOptions)`  L646
- `void initGaodeMarker(List<LatLng> markerPoints, int markerDuration)`  L651
- `void drawGaodeLine()`  L663
- `void getMp4Duration(String path)`  L670
- `void updateSeekBar(int position)`  L677
- `String seekBarTimeFormat(int seconds)`  L684
- `void onWindowFocusChanged(boolean hasFocus)`  L692 @Override
- `void onConfigurationChanged(Configuration newConfig)`  L700 @Override
    - 体内字面量："onConfigurationChanged: "
### `com.gku.actioncam.hisilicon.dv.localimage.TrackActivity$GoogleMapMarkerThread`
L560 · [class] GoogleMapMarkerThread · extends `Thread` · `com/gku/actioncam/hisilicon/dv/localimage/TrackActivity.java`

字段/常量（2）：
- `TrackActivity trackActivity = TrackActivity.this`  L588
- `int i2 = i + 1`  L591

方法（4）：
- `private GoogleMapMarkerThread()`  L561
- `void run()`  L565 @Override
- `void run()`  L573 @Override
- `void lambda$run$0(com.google.android.gms.maps.model.LatLng latLng, int i)`  L587
### `com.gku.actioncam.hisilicon.dv.localimage.utils.SJCamTools`
L24 · [class] public SJCamTools · `com/gku/actioncam/hisilicon/dv/localimage/utils/SJCamTools.java`

字段/常量（11）：
- `String TAG = "SJCamTools"`  L25
- `InputStreamReader inputStreamReader = null`  L63
- `char[] cArr = new char[1024]`  L68
- `int i`  L119
- `int i2`  L120
- `int i3 = second % 3600`  L121
- `int i4 = second / 60`  L137
- `int i5 = second % 60`  L138
- `String strSubstring`  L152
- `String str = "yyyy/MM/dd HH:mm:ss"`  L208
- `NetworkInfo[] allNetworkInfo`  L236

方法（18）：
- `String intIPToIp(int ip)`  L27
- `String getWifiRemoteIp(Context context)`  L31
    - 体内字面量："wifi"
- `boolean isWifiOpened(Context context)`  L36
    - 体内字面量："wifi"
- `String getIpAddress(Context context)`  L40
    - 体内字面量："wifi"
- `String getlanguage()`  L44
    - 体内字面量："zh" · "cn"
- `String toStrDate(long t)`  L53
    - 体内字面量："2017-7-13"
- `String inputStreamToString(InputStream in)`  L62
- `String formatTime(int second)`  L118
- `String subStr(String str, String start, String end)`  L151
- `int strToInt(String str)`  L166
- `int strToInt(String str, int defaultValue)`  L170
- `String strToUtf8Str(String str)`  L179
    - 体内字面量："UTF-8"
- `String getAPPVersion(Context context)`  L188
- `String formatDateForYMD(long date)`  L197
    - 体内字面量："yyyy/MM/dd" · "formatDateForYMD for date!"
- `long formatDateForTimeStamp(String time)`  L206
- `long formatDateForTimeStamp2(String time)`  L221
    - 体内字面量："yyyy-MM-dd HH:mm:ss" · "formatDataForTimeStamp2 for time"
- `String replaceMOV(String n)`  L230
    - 体内字面量："mov" · ".mov"
- `boolean isNetworkAvailable(Context context)`  L235
### `com.gku.actioncam.hisilicon.dv.localimage.utils.ToastUtils`
L12 · [class] public final ToastUtils · `com/gku/actioncam/hisilicon/dv/localimage/utils/ToastUtils.java`

字段/常量（1）：
- `Toast sToast`  L13

方法（7）：
- `Toast getToast(Context context)`  L15
- `void show(Context context, String tip)`  L22
- `void show(Context context, int tipSid)`  L29
- `void showLong(Context context, String tip)`  L36
- `void showLong(Context context, int tipSid)`  L45
- `void show2(Context context, String tip)`  L54
- `void show2(Context context, int tipSid)`  L61
### `com.gku.actioncam.hisilicon.dv.localimage.weight.AlbumFragment`
L39 · [class] public AlbumFragment · extends `Fragment implements MediaScanTask.CallBack, CommonAdapter.CommonClickListener` · implements `MediaScanTask.CallBack, CommonAdapter.CommonClickListener` · `com/gku/actioncam/hisilicon/dv/localimage/weight/AlbumFragment.java`

字段/常量（7）：
- `String ARG_TYPE = "type"`  L40
- `AlbumSubAdapter mAdapter`  L41
- `RecyclerView mRecyclerView`  L42
- `int mType`  L43
- `TextView tv_no_file`  L44
- `String TAG = "ç¸å"`  L45
- `List<AlbumItemModel> list`  L128

方法（20）：
- `void handleMessage(Message msg)`  L49 @Override
- `void handleMessage(Message msg)`  L58 @Override
- `AlbumFragment newFragment(int type)`  L64
    - 体内字面量："type"
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L73 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L81 @Override
    - 体内字面量："type"
- `void initView()`  L91
- `void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)`  L94 @Override
- `void setUserVisibleHint(boolean isVisibleToUser)`  L110 @Override
- `void refreshAlbum()`  L119
    - 体内字面量："45353432123" · "refreshAlbum:  ------------------------  å·æ°æ°å¾ç    "
- `void onScanResultCallback(List<AlbumItemModel> data)`  L127 @Override
- `int compare(Object obj, Object obj2)`  L143 @Override
- `int lambda$onScanResultCallback$0(AlbumItemModel albumItemModel, AlbumItemModel albumItemModel2)`  L156
- `void onCommonClick(int position)`  L161 @Override
- `void deleteFiles(ArrayList<String> paths)`  L180
- `void startDeleteDlg(ArrayList<String> listPath, ArrayList<Integer> listID, Activity context, int mType)`  L188
    - 体内字面量："progressType" · "TYPE" · "nTaskIDArray"
- `void onStart()`  L201 @Override
- `void run()`  L205 @Override
- `void onDestroy()`  L215 @Override
- `void onMessageEvent(MessageEvent MessageEvent)`  L221 @Subscribe(threadMode = ThreadMode.MAIN)
    - 体内字面量："shuaxin" · "onMessageEvent:  -----------------  å·æ°"
- `void onResume()`  L233 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.weight.AlbumHDFragment`
L38 · [class] public AlbumHDFragment · extends `Fragment implements MediaScanTask.CallBack, CommonAdapter.CommonClickListener` · implements `MediaScanTask.CallBack, CommonAdapter.CommonClickListener` · `com/gku/actioncam/hisilicon/dv/localimage/weight/AlbumHDFragment.java`

字段/常量（7）：
- `String ARG_TYPE = "type"`  L39
- `AlbumSubAdapter mAdapter`  L40
- `RecyclerView mRecyclerView`  L41
- `int mType`  L42
- `TextView tv_no_file`  L43
- `String TAG = "é«æ¸è§é¢Fragment"`  L44
- `List<AlbumItemModel> list`  L131

方法（19）：
- `void handleMessage(Message msg)`  L48 @Override
    - 体内字面量："456464132" · "onMessageEvent:  ------æ§è¡UIå·æ°"
- `void RefeshUI()`  L55
- `AlbumHDFragment newFragment(int type)`  L58
    - 体内字面量："type"
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L67 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L75 @Override
    - 体内字面量："type" · "4523132" · "onViewCreated:  -----------------  æ¥è¯¢åªä½åº   "
- `void onStateChanged(LifecycleOwner source, Lifecycle.Event event)`  L86 @Override
- `void initView()`  L94
- `void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)`  L98 @Override
- `void refreshAlbum()`  L114
    - 体内字面量："456464132" · "onMessageEvent:  ------å¼å§å·æ°æ°æ®ï¼éæ°å»è·å"
- `void run()`  L119 @Override
    - 体内字面量："456464132" · "run:  --------------   "
- `void onScanResultCallback(List<AlbumItemModel> data)`  L130 @Override
- `int compare(Object obj, Object obj2)`  L147 @Override
- `int lambda$onScanResultCallback$0(AlbumItemModel albumItemModel, AlbumItemModel albumItemModel2)`  L160
- `void onCommonClick(int position)`  L165 @Override
    - 体内字面量："4531231032" · "onCommonClick:  ------------------  " · "4531231032" · "onCommonClick:  ------------------  false" · "4531231032" · "onCommonClick:  ------------------  true"
- `void deleteFiles(ArrayList<String> paths)`  L187
- `void onStart()`  L196 @Override
- `void onDestroy()`  L204 @Override
- `void onMessageEvent(MessageEvent MessageEvent)`  L210 @Subscribe(threadMode = ThreadMode.MAIN)
- `void onResume()`  L217 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.weight.AlbumNormalFragment`
L39 · [class] public AlbumNormalFragment · extends `Fragment implements MediaScanTask.CallBack, CommonAdapter.CommonClickListener` · implements `MediaScanTask.CallBack, CommonAdapter.CommonClickListener` · `com/gku/actioncam/hisilicon/dv/localimage/weight/AlbumNormalFragment.java`

字段/常量（9）：
- `String ARG_TYPE = "type"`  L40
- `RecyclerView.ItemAnimator animator`  L41
- `AlbumSubAdapter mAdapter`  L42
- `RecyclerView mRecyclerView`  L43
- `int mType`  L44
- `TextView tv_no_file`  L45
- `String TAG = "æ®éè§é¢Fragment"`  L46
- `List<AlbumItemModel> list`  L134
- `RecyclerView.ItemAnimator itemAnimator = this.animator`  L161

方法（19）：
- `void handleMessage(Message msg)`  L50 @Override
    - 体内字面量："456464132" · "onMessageEvent:  ------æ§è¡UIå·æ°"
- `void RefeshUI()`  L57
- `AlbumNormalFragment newFragment(int type)`  L60
    - 体内字面量："type"
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L69 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L78 @Override
    - 体内字面量："type" · "4523132" · "onViewCreated:  -----------------  æ¥è¯¢åªä½åº   "
- `void onStateChanged(LifecycleOwner source, Lifecycle.Event event)`  L88 @Override
- `void initView()`  L96
- `void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)`  L100 @Override
- `void refreshAlbum()`  L117
    - 体内字面量："onMessageEvent:  ------å¼å§å·æ°æ°æ®ï¼éæ°å»è·å"
- `void run()`  L122 @Override
    - 体内字面量："456464132" · "run:  --------------   "
- `void onScanResultCallback(List<AlbumItemModel> data)`  L133 @Override
- `int compare(Object obj, Object obj2)`  L150 @Override
- `int lambda$onScanResultCallback$0(AlbumItemModel albumItemModel, AlbumItemModel albumItemModel2)`  L167
- `void onCommonClick(int position)`  L172 @Override
    - 体内字面量："4531231032" · "onCommonClick:  ------------------  " · "4531231032" · "onCommonClick:  ------------------  false" · "yunqi_debug" · "onCommonClick: this: " · "yunqi_debug" · "onCommonClick: " · "key:%s, value:%s" · "4531231032" · "onCommonClick:  ------------------  true" · "yunqi_debug" · "onCommonClick: position: "
- `void deleteFiles(ArrayList<String> paths)`  L199
- `void onStart()`  L208 @Override
- `void onDestroy()`  L216 @Override
- `void onMessageEvent(MessageEvent MessageEvent)`  L222 @Subscribe(threadMode = ThreadMode.MAIN)
- `void onResume()`  L229 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.weight.DlgForDeleteLocalProcessActivity`
L24 · [class] public DlgForDeleteLocalProcessActivity · extends `Activity` · `com/gku/actioncam/hisilicon/dv/localimage/weight/DlgForDeleteLocalProcessActivity.java`

字段/常量（21）：
- `int DELETE_FINISH = 1`  L25
- `int DELETE_PROCESS = 0`  L26
- `int DOWNLOAD_CANCEL = 3`  L27
- `int DOWNLOAD_FINISH = 2`  L28
- `int DOWNLOAD_PROCESS = 5`  L29
- `int DOWNLOAD_TOTAL_PROCESS = 4`  L30
- `String TAG = "DlgForProcessActivity"`  L31
- `int TYPE`  L32
- `Button btnCancel`  L33
- `ProgressBar mDownloadProcess`  L34
- `ArrayList<Integer> mListID`  L35
- `ArrayList<String> mListStrPath`  L36
- `int mProgressType`  L37
- `String strSSID`  L38
- `TextView tvMessage`  L39
- `TextView tvTitle`  L40
- `boolean bDeleteSuccess = false`  L42
- `boolean bUndoOperate = false`  L43
- `Message message = null`  L44
- `int i = msg.what`  L48
- `DlgForDeleteLocalProcessActivity dlgForDeleteLocalProcessActivity = DlgForDeleteLocalProcessActivity.this`  L122

方法（8）：
- `void handleMessage(Message msg)`  L47 @Override
- `void onCreate(Bundle savedInstanceState)`  L64 @Override
    - 体内字面量："TYPE"
- `boolean exitPropram()`  L73
- `void findView()`  L88
    - 体内字面量："SSID" · "progressType" · "nTaskIDArray"
- `void StartDeleteThread()`  L111
- `void run()`  L114 @Override
- `void setReturnForResult(int nPathLen)`  L158
    - 体内字面量："dlgType" · "imgPathLen" · "bDeleteSuccess"
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L168 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.weight.FragmentNavigator`
L9 · [class] public FragmentNavigator · `com/gku/actioncam/hisilicon/dv/localimage/weight/FragmentNavigator.java`

字段/常量（6）：
- `String EXTRA_CURRENT_POSITION = "extra_current_position"`  L10
- `FragmentNavigatorAdapter mAdapter`  L11
- `int mContainerViewId`  L12
- `int mCurrentPosition = -1`  L13
- `int mDefaultPosition`  L14
- `FragmentManager mFragmentManager`  L15

方法（20）：
- `public FragmentNavigator(FragmentManager fragmentManager, FragmentNavigatorAdapter adapter, int containerViewId)`  L17
- `void onCreate(Bundle savedInstanceState)`  L23
- `void onSaveInstanceState(Bundle outState)`  L29
- `void showFragment(int position)`  L33
- `void showFragment(int position, boolean reset)`  L37
- `void showFragment(int position, boolean reset, boolean allowingStateLoss)`  L41
- `void resetFragments()`  L62
- `void resetFragments(int position)`  L66
- `void resetFragments(int position, boolean allowingStateLoss)`  L70
- `void removeAllFragment()`  L82
- `void removeAllFragment(boolean allowingStateLoss)`  L86
- `int getCurrentPosition()`  L96
- `Fragment getCurrentFragment()`  L100
- `Fragment getFragment(int position)`  L104
- `void show(int position, FragmentTransaction transaction)`  L108
- `void hide(int position, FragmentTransaction transaction)`  L117
- `void add(int position, FragmentTransaction transaction)`  L124
- `void removeAll(FragmentTransaction transaction)`  L128
- `void remove(int position, FragmentTransaction transaction)`  L135
- `void setDefaultPosition(int defaultPosition)`  L142
### `com.gku.actioncam.hisilicon.dv.localimage.weight.FragmentNavigatorAdapter`
L6 · [interface] public FragmentNavigatorAdapter · `com/gku/actioncam/hisilicon/dv/localimage/weight/FragmentNavigatorAdapter.java`

方法（3）：
- `int getCount()`  L7
- `String getTag(int position)`  L9
- `Fragment onCreateFragment(int position)`  L11
### `com.gku.actioncam.hisilicon.dv.localimage.weight.PhotoViewPager`
L9 · [class] public PhotoViewPager · extends `ViewPager` · `com/gku/actioncam/hisilicon/dv/localimage/weight/PhotoViewPager.java`

方法（3）：
- `public PhotoViewPager(Context context)`  L10
- `public PhotoViewPager(Context context, AttributeSet attrs)`  L14
- `boolean onInterceptTouchEvent(MotionEvent ev)`  L19 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.weight.SimpleTabLinearLayout`
L13 · [class] public SimpleTabLinearLayout · extends `LinearLayout implements View.OnClickListener` · implements `View.OnClickListener` · `com/gku/actioncam/hisilicon/dv/localimage/weight/SimpleTabLinearLayout.java`

字段/常量（8）：
- `boolean mEnable`  L14
- `int mIndex`  L15
- `TabSelectListener mListener`  L16
- `List<View> mViews`  L17
- `boolean z`  L76
- `TabSelectListener tabSelectListener = this.mListener`  L80
- `boolean z`  L100
- `TabSelectListener tabSelectListener = this.mListener`  L106

方法（13）：
- `public SimpleTabLinearLayout(Context context)`  L23
- `public SimpleTabLinearLayout(Context context, AttributeSet attrs)`  L28
- `void setEnabled(boolean enabled)`  L34 @Override
- `boolean dispatchTouchEvent(MotionEvent ev)`  L44 @Override
- `void init()`  L51
- `void setSelectTab(int id)`  L71
- `void setSelectTabForIndex(int index)`  L75
- `void setTabVisibility(int id, boolean visiable)`  L92
- `void setSelectTab(int id, boolean isListener)`  L99
- `void setTabSelectListener(TabSelectListener l)`  L116
- `void onFinishInflate()`  L121 @Override
- `int getIndexForID(int id)`  L126
- `void onClick(View v)`  L137 @Override
### `com.gku.actioncam.hisilicon.dv.localimage.weight.SimpleTabLinearLayout$TabSelectListener`
L19 · [interface] public TabSelectListener · `com/gku/actioncam/hisilicon/dv/localimage/weight/SimpleTabLinearLayout.java`

方法（1）：
- `void onTabSelect(View v)`  L20