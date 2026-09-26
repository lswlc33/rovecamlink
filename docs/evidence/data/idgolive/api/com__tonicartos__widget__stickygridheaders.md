# idGoLive — 类与成员明细：com.tonicartos.widget.stickygridheaders

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 8 个文件 / 24 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `com.tonicartos.widget.stickygridheaders.BuildConfig`
L4 · [class] public final BuildConfig · `com/tonicartos/widget/stickygridheaders/BuildConfig.java`

字段/常量（6）：
- `String APPLICATION_ID = "com.tonicartos.widget.stickygridheaders"`  L5
- `String BUILD_TYPE = "release"`  L6
- `boolean DEBUG = false`  L7
- `String FLAVOR = "<binary/metadata>"`  L8
- `int VERSION_CODE = 1`  L9
- `String VERSION_NAME = "1.0"`  L10
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersBaseAdapter`
L8 · [interface] public StickyGridHeadersBaseAdapter · extends `ListAdapter` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersBaseAdapter.java`

方法（3）：
- `int getCountForHeader(int i)`  L9
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L11
- `int getNumHeaders()`  L13
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper`
L12 · [class] public StickyGridHeadersBaseAdapterWrapper · extends `BaseAdapter` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersBaseAdapterWrapper.java`

字段/常量（26）：
- `int ID_FILLER = -2`  L13
- `int ID_HEADER = -1`  L14
- `int ID_HEADER_FILLER = -3`  L15
- `int POSITION_FILLER = -1`  L16
- `int POSITION_HEADER = -2`  L17
- `int POSITION_HEADER_FILLER = -3`  L18
- `int VIEW_TYPE_FILLER = 0`  L19
- `int VIEW_TYPE_HEADER = 1`  L20
- `int VIEW_TYPE_HEADER_FILLER = 2`  L21
- `int sNumViewTypes = 3`  L22
- `Context mContext`  L23
- `int mCount`  L24
- `boolean mCounted = false`  L25
- `DataSetObserver mDataSetObserver`  L26
- `StickyGridHeadersBaseAdapter mDelegate`  L27
- `StickyGridHeadersGridView mGridView`  L28
- `View mLastHeaderViewSeen`  L29
- `View mLastViewSeen`  L30
- `int mNumColumns`  L31
- `int i2 = this.mNumColumns`  L158
- `int i3 = countForHeader % i2`  L159
- `int i2 = 0`  L312
- `int i3 = i`  L313
- `int i4 = this.mNumColumns`  L319
- `int i5 = i - i4`  L320
- `int i6 = i3 - i4`  L324

方法（24）：
- `public StickyGridHeadersBaseAdapterWrapper(Context context, StickyGridHeadersGridView stickyGridHeadersGridView, StickyGridHeadersBaseAdapter stickyGridHeadersBaseAdapter)`  L119
- `void onChanged()`  L122 @Override
- `void onInvalidated()`  L127 @Override
- `FillerView getFillerView(View view, ViewGroup viewGroup, View view2)`  L139
- `HeaderFillerView getHeaderFillerView(int i, View view, ViewGroup viewGroup)`  L148
- `int unFilledSpacesInHeaderGroup(int i)`  L153
- `boolean areAllItemsEnabled()`  L167 @Override
- `int getCount()`  L172 @Override
- `long getHeaderId(int i)`  L191
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L195
- `Object getItem(int i)`  L203 @Override
- `long getItemId(int i)`  L212 @Override
- `int getItemViewType(int i)`  L227 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L243 @Override
- `int getViewTypeCount()`  L269 @Override
- `StickyGridHeadersBaseAdapter getWrappedAdapter()`  L273
- `boolean hasStableIds()`  L278 @Override
- `boolean isEmpty()`  L283 @Override
- `boolean isEnabled(int i)`  L288 @Override
- `void registerDataSetObserver(DataSetObserver dataSetObserver)`  L297 @Override
- `void setNumColumns(int i)`  L302
- `Position translatePosition(int i)`  L307
- `void unregisterDataSetObserver(DataSetObserver dataSetObserver)`  L340 @Override
- `void updateCount()`  L345
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper$FillerView`
L33 · [class] protected FillerView · extends `View` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersBaseAdapterWrapper.java`

字段/常量（1）：
- `View mMeasureTarget`  L34

方法（5）：
- `public FillerView(Context context)`  L36
- `public FillerView(Context context, AttributeSet attributeSet)`  L40
- `public FillerView(Context context, AttributeSet attributeSet, int i)`  L44
- `void onMeasure(int i, int i2)`  L49 @Override
- `void setMeasureTarget(View view)`  L53
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper$HeaderFillerView`
L58 · [class] protected HeaderFillerView · extends `FrameLayout` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersBaseAdapterWrapper.java`

字段/常量（1）：
- `int mHeaderId`  L59

方法（7）：
- `public HeaderFillerView(Context context)`  L61
- `public HeaderFillerView(Context context, AttributeSet attributeSet)`  L65
- `public HeaderFillerView(Context context, AttributeSet attributeSet, int i)`  L69
- `FrameLayout.LayoutParams generateDefaultLayoutParams()`  L75 @Override
- `int getHeaderId()`  L79
- `void onMeasure(int i, int i2)`  L84 @Override
- `void setHeaderId(int i)`  L97
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper$HeaderHolder`
L102 · [class] protected HeaderHolder · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersBaseAdapterWrapper.java`

字段/常量（1）：
- `View mHeaderView`  L103

方法（1）：
- `protected HeaderHolder()`  L105
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper$Position`
L109 · [class] protected Position · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersBaseAdapterWrapper.java`

字段/常量（2）：
- `int mHeader`  L110
- `int mPosition`  L111

方法（1）：
- `protected Position(int i, int i2)`  L113
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView`
L27 · [class] public StickyGridHeadersGridView · extends `GridView implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, AdapterView.OnItemLongClickListener` · implements `AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, AdapterView.OnItemLongClickListener` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersGridView.java`

字段/常量（93）：
- `int MATCHED_STICKIED_HEADER = -2`  L28
- `int NO_MATCHED_HEADER = -1`  L29
- `int TOUCH_MODE_DONE_WAITING = 2`  L30
- `int TOUCH_MODE_DOWN = 0`  L31
- `int TOUCH_MODE_FINISHED_LONG_PRESS = -2`  L32
- `int TOUCH_MODE_REST = -1`  L33
- `int TOUCH_MODE_TAP = 1`  L34
- `StickyGridHeadersBaseAdapterWrapper mAdapter`  L35
- `boolean mAreHeadersSticky`  L36
- `boolean mClipToPaddingHasBeenSet`  L37
- `Rect mClippingRect`  L38
- `boolean mClippingToPadding`  L39
- `int mColumnWidth`  L40
- `long mCurrentHeaderId`  L41
- `boolean mDataChanged`  L42
- `DataSetObserver mDataSetObserver`  L43
- `int mHeaderBottomPosition`  L44
- `boolean mHeaderChildBeingPressed`  L45
- `boolean mHeadersIgnorePadding`  L46
- `int mHorizontalSpacing`  L47
- `boolean mMaskStickyHeaderRegion`  L48
- `int mMotionHeaderPosition`  L49
- `float mMotionY`  L50
- `int mNumColumns`  L51
- `boolean mNumColumnsSet`  L52
- `int mNumMeasuredColumns`  L53
- `OnHeaderClickListener mOnHeaderClickListener`  L54
- `OnHeaderLongClickListener mOnHeaderLongClickListener`  L55
- `AdapterView.OnItemClickListener mOnItemClickListener`  L56
- `AdapterView.OnItemLongClickListener mOnItemLongClickListener`  L57
- `AdapterView.OnItemSelectedListener mOnItemSelectedListener`  L58
- `CheckForHeaderLongPress mPendingCheckForLongPress`  L59
- `CheckForHeaderTap mPendingCheckForTap`  L60
- `PerformHeaderClick mPerformHeaderClick`  L61
- `AbsListView.OnScrollListener mScrollListener`  L62
- `int mScrollState`  L63
- `View mStickiedHeader`  L64
- `int mTouchMode`  L65
- `Runnable mTouchModeReset`  L66
- `int mTouchSlop`  L67
- `int mVerticalSpacing`  L68
- `String ERROR_PLATFORM = "Error supporting platform " + Build.VERSION.SDK_INT + "."`  L69
- `String TAG = "StickyGridHeadersGridView"`  L70
- `int i = 0`  L256
- `int i2 = this.mNumMeasuredColumns`  L266
- `View view = this.mStickiedHeader`  L274
- `MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount]`  L283
- `int[] iArr = new int[pointerCount]`  L294
- `long headerId`  L345
- `long headerId2`  L346
- `int i2`  L347
- `int childCount`  L348
- `View view`  L349
- `int i3`  L350
- `int i4`  L351
- `int headerHeight`  L352
- `int iMin`  L353
- `int iMin2`  L354
- `int paddingTop`  L355
- `View childAt`  L356
- `int top`  L357
- `StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.mAdapter`  L358
- `int i5 = this.mNumMeasuredColumns`  L362
- `int i6 = i - i5`  L363
- `int i7 = i5 + i`  L367
- `int i8 = this.mVerticalSpacing`  L371
- `int i2 = 0`  L527
- `int i3 = source`  L529
- `int i`  L587
- `View view = this.mStickiedHeader`  L588
- `int i2 = this.mHeaderBottomPosition - headerHeight`  L591
- `int i3 = 0`  L608
- `int i4 = this.mNumMeasuredColumns`  L613
- `int i3`  L740
- `int i4 = this.mNumColumns`  L741
- `int i5 = iMax / this.mColumnWidth`  L745
- `StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.mAdapter`  L760
- `AbsListView.OnScrollListener onScrollListener = this.mScrollListener`  L790
- `AbsListView.OnScrollListener onScrollListener = this.mScrollListener`  L799
- `int i`  L808
- `boolean z = this.mHeaderChildBeingPressed`  L810
- `int i2 = this.mMotionHeaderPosition`  L813
- `int i3 = action & 255`  L830
- `int i4 = this.mMotionHeaderPosition`  L848
- `int i5 = this.mTouchMode`  L858
- `PerformHeaderClick performHeaderClick = this.mPerformHeaderClick`  L872
- `int i6 = this.mTouchMode`  L875
- `Runnable runnable = this.mTouchModeReset`  L887
- `OnHeaderLongClickListener onHeaderLongClickListener = this.mOnHeaderLongClickListener`  L946
- `StickyGridHeadersBaseAdapter stickyGridHeadersSimpleAdapterWrapper`  L959
- `DataSetObserver dataSetObserver`  L960
- `StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper = this.mAdapter`  L961
- `StickyGridHeadersBaseAdapterWrapper stickyGridHeadersBaseAdapterWrapper`  L1012

方法（51）：
- `public StickyGridHeadersGridView(Context context)`  L215
- `public StickyGridHeadersGridView(Context context, AttributeSet attributeSet)`  L219
- `public StickyGridHeadersGridView(Context context, AttributeSet attributeSet, int i)`  L223
- `void onChanged()`  L230 @Override
- `void onInvalidated()`  L235 @Override
- `int findMotionHeader(float f)`  L251
- `int getHeaderHeight()`  L273
- `MotionEvent.PointerCoords[] getPointerCoords(MotionEvent motionEvent)`  L281
- `int[] getPointerIds(MotionEvent motionEvent)`  L292
- `long headerViewPositionToId(int i)`  L302
- `void measureHeader()`  L306
- `void reset()`  L323
- `void scrollChanged(int i)`  L344
- `void swapStickiedHeader(View view)`  L503
- `MotionEvent transformEvent(MotionEvent motionEvent, int i)`  L509
- `boolean areHeadersSticky()`  L539
- `void attachHeader(View view)`  L543
    - 体内字面量："mAttachInfo" · "dispatchAttachedToWindow" · "android.view.View$AttachInfo"
- `void detachHeader(View view)`  L567
    - 体内字面量："dispatchDetachedFromWindow"
- `void dispatchDraw(Canvas canvas)`  L586 @Override
- `View getHeaderAt(int i)`  L704
- `View getStickiedHeader()`  L715
- `boolean getStickyHeaderIsTranscluent()`  L719
- `void onItemClick(AdapterView<?> adapterView, View view, int i, long j)`  L724 @Override
- `boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j)`  L729 @Override
- `void onItemSelected(AdapterView<?> adapterView, View view, int i, long j)`  L734 @Override
- `void onMeasure(int i, int i2)`  L739 @Override
- `void onNothingSelected(AdapterView<?> adapterView)`  L769 @Override
- `void onRestoreInstanceState(Parcelable parcelable)`  L774 @Override
- `Parcelable onSaveInstanceState()`  L782 @Override
- `void onScroll(AbsListView absListView, int i, int i2, int i3)`  L789 @Override
- `void onScrollStateChanged(AbsListView absListView, int i)`  L798 @Override
- `boolean onTouchEvent(MotionEvent motionEvent)`  L807 @Override
- `void run()`  L823 @Override
- `void run()`  L893 @Override
- `boolean performHeaderClick(View view, long j)`  L933
- `boolean performHeaderLongPress(View view, long j)`  L945
- `void setAdapter(ListAdapter listAdapter)`  L958 @Override
- `void setAreHeadersSticky(boolean z)`  L980
- `void setClipToPadding(boolean z)`  L988 @Override
- `void setColumnWidth(int i)`  L995 @Override
- `void setHeadersIgnorePadding(boolean z)`  L1000
- `void setHorizontalSpacing(int i)`  L1005 @Override
- `void setNumColumns(int i)`  L1011 @Override
- `void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener)`  L1022
- `void setOnHeaderLongClickListener(OnHeaderLongClickListener onHeaderLongClickListener)`  L1026
- `void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener)`  L1034 @Override
- `void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener)`  L1040 @Override
- `void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener)`  L1046 @Override
- `void setOnScrollListener(AbsListView.OnScrollListener onScrollListener)`  L1052 @Override
- `void setStickyHeaderIsTranscluent(boolean z)`  L1056
- `void setVerticalSpacing(int i)`  L1061 @Override
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView$CheckForHeaderLongPress`
L72 · [class] private CheckForHeaderLongPress · extends `WindowRunnable implements Runnable` · implements `Runnable` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersGridView.java`

字段/常量（2）：
- `StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this`  L79
- `StickyGridHeadersGridView stickyGridHeadersGridView2 = StickyGridHeadersGridView.this`  L82

方法（2）：
- `private CheckForHeaderLongPress()`  L73
- `void run()`  L78 @Override
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView$CheckForHeaderTap`
L94 · [class] final CheckForHeaderTap · implements `Runnable` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersGridView.java`

字段/常量（2）：
- `StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this`  L102
- `StickyGridHeadersGridView stickyGridHeadersGridView2 = StickyGridHeadersGridView.this`  L123

方法（1）：
- `void run()`  L99 @Override
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView$OnHeaderClickListener`
L129 · [interface] public OnHeaderClickListener · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersGridView.java`

方法（1）：
- `void onHeaderClick(AdapterView<?> adapterView, View view, long j)`  L130
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView$OnHeaderLongClickListener`
L133 · [interface] public OnHeaderLongClickListener · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersGridView.java`

方法（1）：
- `boolean onHeaderLongClick(AdapterView<?> adapterView, View view, long j)`  L134
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView$PerformHeaderClick`
L137 · [class] private PerformHeaderClick · extends `WindowRunnable implements Runnable` · implements `Runnable` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersGridView.java`

字段/常量（4）：
- `int mClickMotionPosition`  L138
- `int i`  L146
- `View headerAt`  L147
- `StickyGridHeadersGridView stickyGridHeadersGridView = StickyGridHeadersGridView.this`  L151

方法（2）：
- `private PerformHeaderClick()`  L140
- `void run()`  L145 @Override
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView$RuntimePlatformSupportException`
L156 · [class] RuntimePlatformSupportException · extends `RuntimeException` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersGridView.java`

字段/常量（1）：
- `long serialVersionUID = -6512098808936536538L`  L157

方法（1）：
- `public RuntimePlatformSupportException(Exception exc)`  L159
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView$SavedState`
L164 · [class] static SavedState · extends `View.BaseSavedState` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersGridView.java`

字段/常量（1）：
- `boolean areHeadersSticky`  L178

方法（6）：
- `SavedState createFromParcel(Parcel parcel)`  L168 @Override
- `SavedState[] newArray(int i)`  L174 @Override
- `private SavedState(Parcel parcel)`  L180
- `public SavedState(Parcelable parcelable)`  L185
- `String toString()`  L189
    - 体内字面量："StickyGridHeadersGridView.SavedState{" · " areHeadersSticky=" · "}"
- `void writeToParcel(Parcel parcel, int i)`  L194 @Override
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView$WindowRunnable`
L200 · [class] private WindowRunnable · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersGridView.java`

字段/常量（1）：
- `int mOriginalAttachCount`  L201

方法（3）：
- `private WindowRunnable()`  L203
- `void rememberWindowAttachCount()`  L206
- `boolean sameWindow()`  L210
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersListAdapterWrapper`
L10 · [class] public StickyGridHeadersListAdapterWrapper · extends `BaseAdapter implements StickyGridHeadersBaseAdapter` · implements `StickyGridHeadersBaseAdapter` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersListAdapterWrapper.java`

字段/常量（4）：
- `DataSetObserver mDataSetObserver`  L11
- `ListAdapter mDelegate`  L12
- `ListAdapter listAdapter = this.mDelegate`  L35
- `ListAdapter listAdapter = this.mDelegate`  L54

方法（13）：
- `public StickyGridHeadersListAdapterWrapper(ListAdapter listAdapter)`  L14
- `void onChanged()`  L17 @Override
- `void onInvalidated()`  L22 @Override
- `int getCount()`  L34 @Override
- `int getCountForHeader(int i)`  L43 @Override
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L48 @Override
- `Object getItem(int i)`  L53 @Override
- `long getItemId(int i)`  L62 @Override
- `int getItemViewType(int i)`  L67 @Override
- `int getNumHeaders()`  L72 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L77 @Override
- `int getViewTypeCount()`  L82 @Override
- `boolean hasStableIds()`  L87 @Override
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleAdapter`
L8 · [interface] public StickyGridHeadersSimpleAdapter · extends `ListAdapter` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersSimpleAdapter.java`

方法（2）：
- `long getHeaderId(int i)`  L9
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L11
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleAdapterWrapper`
L11 · [class] public StickyGridHeadersSimpleAdapterWrapper · extends `BaseAdapter implements StickyGridHeadersBaseAdapter` · implements `StickyGridHeadersBaseAdapter` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersSimpleAdapterWrapper.java`

字段/常量（2）：
- `StickyGridHeadersSimpleAdapter mDelegate`  L12
- `HeaderData[] mHeaders`  L13

方法（12）：
- `public StickyGridHeadersSimpleAdapterWrapper(StickyGridHeadersSimpleAdapter stickyGridHeadersSimpleAdapter)`  L55
- `HeaderData[] generateHeaderList(StickyGridHeadersSimpleAdapter stickyGridHeadersSimpleAdapter)`  L61
- `int getCount()`  L78 @Override
- `int getCountForHeader(int i)`  L83 @Override
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L88 @Override
- `Object getItem(int i)`  L93 @Override
- `long getItemId(int i)`  L98 @Override
- `int getItemViewType(int i)`  L103 @Override
- `int getNumHeaders()`  L108 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L113 @Override
- `int getViewTypeCount()`  L118 @Override
- `boolean hasStableIds()`  L123 @Override
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleAdapterWrapper$DataSetObserverExtension`
L15 · [class] private final DataSetObserverExtension · extends `DataSetObserver` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersSimpleAdapterWrapper.java`

字段/常量（2）：
- `StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = StickyGridHeadersSimpleAdapterWrapper.this`  L21
- `StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = StickyGridHeadersSimpleAdapterWrapper.this`  L28

方法（3）：
- `private DataSetObserverExtension()`  L16
- `void onChanged()`  L20 @Override
- `void onInvalidated()`  L27 @Override
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleAdapterWrapper$HeaderData`
L34 · [class] private HeaderData · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersSimpleAdapterWrapper.java`

字段/常量（2）：
- `int mCount = 0`  L35
- `int mRefPosition`  L36

方法（4）：
- `public HeaderData(int i)`  L38
- `int getCount()`  L42
- `int getRefPosition()`  L46
- `void incrementCount()`  L50
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleArrayAdapter`
L14 · [class] public StickyGridHeadersSimpleArrayAdapter · extends `BaseAdapter implements StickyGridHeadersSimpleAdapter` · implements `StickyGridHeadersSimpleAdapter` · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersSimpleArrayAdapter.java`

字段/常量（7）：
- `String TAG = "StickyGridHeadersSimpleArrayAdapter"`  L15
- `int mHeaderResId`  L16
- `LayoutInflater mInflater`  L17
- `int mItemResId`  L18
- `List<T> mItems`  L19
- `HeaderViewHolder headerViewHolder`  L68
- `ViewHolder viewHolder`  L94

方法（10）：
- `public StickyGridHeadersSimpleArrayAdapter(Context context, List<T> list, int i, int i2)`  L35
- `public StickyGridHeadersSimpleArrayAdapter(Context context, T[] tArr, int i, int i2)`  L39
- `void init(Context context, List<T> list, int i, int i2)`  L43
- `boolean areAllItemsEnabled()`  L51 @Override
- `int getCount()`  L56 @Override
- `long getHeaderId(int i)`  L61 @Override
- `View getHeaderView(int i, View view, ViewGroup viewGroup)`  L67 @Override
- `T getItem(int i)`  L83 @Override
- `long getItemId(int i)`  L88 @Override
- `View getView(int i, View view, ViewGroup viewGroup)`  L93 @Override
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleArrayAdapter$HeaderViewHolder`
L21 · [class] protected HeaderViewHolder · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersSimpleArrayAdapter.java`

字段/常量（1）：
- `TextView textView`  L22

方法（1）：
- `protected HeaderViewHolder()`  L24
### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleArrayAdapter$ViewHolder`
L28 · [class] protected ViewHolder · `com/tonicartos/widget/stickygridheaders/StickyGridHeadersSimpleArrayAdapter.java`

字段/常量（1）：
- `TextView textView`  L29

方法（1）：
- `protected ViewHolder()`  L31