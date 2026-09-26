# XTU GO — 类与成员明细：com.gku.base.view

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 8 个文件 / 12 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.base.view.calendarview.CustomMonthView`
L13 · [class] public CustomMonthView · extends `MonthView` · `com/gku/base/view/calendarview/CustomMonthView.java`

字段/常量（20）：
- `int TYPE_VIDEO_EMERGENCY = 1001`  L14
- `int TYPE_VIDEO_NORMAL = 1000`  L15
- `float mCircleRadius`  L16
- `Paint mCurrentDayPaint`  L17
- `int mPadding`  L18
- `Paint mPointPaint`  L19
- `float mPointRadius`  L20
- `int mRadius`  L21
- `float mSchemeBaseLine`  L22
- `Paint mSchemeBasicPaint`  L23
- `Paint mSolarTermTextPaint`  L24
- `Paint mTextPaint`  L25
- `float f2 = this.mItemHeight + i2`  L82
- `float f3 = this.mPointRadius`  L83
- `Paint paint`  L91
- `int i5 = this.mItemHeight / 6`  L94
- `float f = i4`  L96
- `int i6 = i + this.mItemWidth`  L104
- `int i7 = this.mPadding`  L105
- `float f3 = i3`  L133

方法（6）：
- `public CustomMonthView(Context context)`  L27
- `void onPreviewHook()`  L61 @Override
- `boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, int i2, boolean z)`  L67 @Override
- `void onDrawScheme(Canvas canvas, Calendar calendar, int i, int i2)`  L73 @Override
- `void onDrawText(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2)`  L90 @Override
- `int dipToPx(Context context, float f)`  L142
### `com.gku.base.view.calendarview.CustomWeekView`
L13 · [class] public CustomWeekView · extends `WeekView` · `com/gku/base/view/calendarview/CustomWeekView.java`

字段/常量（18）：
- `float mCircleRadius`  L14
- `Paint mCurrentDayPaint`  L15
- `int mPadding`  L16
- `Paint mPointPaint`  L17
- `float mPointRadius`  L18
- `int mRadius`  L19
- `float mSchemeBaseLine`  L20
- `Paint mSchemeBasicPaint`  L21
- `Paint mSolarTermTextPaint`  L22
- `Paint mTextPaint`  L23
- `float f2 = this.mItemHeight`  L80
- `float f3 = this.mPointRadius`  L81
- `Paint paint`  L89
- `int i3 = this.mItemHeight / 2`  L91
- `int i4 = i + this.mItemWidth`  L98
- `int i5 = this.mPadding`  L99
- `float f = i2`  L127
- `float f2 = this.mTextBaseLine`  L128

方法（6）：
- `public CustomWeekView(Context context)`  L25
- `void onPreviewHook()`  L59 @Override
- `boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, boolean z)`  L65 @Override
- `void onDrawScheme(Canvas canvas, Calendar calendar, int i)`  L71 @Override
- `void onDrawText(Canvas canvas, Calendar calendar, int i, boolean z, boolean z2)`  L88 @Override
- `int dipToPx(Context context, float f)`  L137
### `com.gku.base.view.calendarview.CustomYearView`
L11 · [class] public CustomYearView · extends `YearView` · `com/gku/base/view/calendarview/CustomYearView.java`

字段/常量（4）：
- `Paint mLeapYearTextPaint`  L12
- `int mTextPadding`  L13
- `float f = i4`  L32
- `float f = this.mTextBaseLine + i2`  L60

方法（9）：
- `void onDrawScheme(Canvas canvas, Calendar calendar, int i, int i2)`  L16 @Override
- `public CustomYearView(Context context)`  L19
- `void onDrawMonth(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6)`  L30 @Override
- `float getTextWidth(Paint paint, String str)`  L39
- `boolean isLeapYear(int i)`  L43
- `void onDrawWeek(Canvas canvas, int i, int i2, int i3, int i4, int i5)`  L48 @Override
- `boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, int i2, boolean z)`  L53 @Override
- `void onDrawText(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2)`  L59 @Override
- `int dipToPx(Context context, float f)`  L71
### `com.gku.base.view.HideShowFrameLayout`
L13 · [class] public HideShowFrameLayout · extends `FrameLayout` · `com/gku/base/view/HideShowFrameLayout.java`

字段/常量（8）：
- `long AUTO_HIDE_DELAY = 5000`  L14
- `GestureDetector gestureDetector`  L15
- `Handler handler`  L16
- `Runnable hideRunnable`  L17
- `OnDoubleClickListener onDoubleClickListener`  L18
- `boolean show_before_down`  L19
- `boolean up_dispatch`  L20
- `Runnable runnable = this.hideRunnable`  L61

方法（11）：
- `public HideShowFrameLayout(Context context)`  L26
- `public HideShowFrameLayout(Context context, AttributeSet attributeSet)`  L30
- `boolean onSingleTapConfirmed(MotionEvent motionEvent)`  L37 @Override
- `boolean onDoubleTap(MotionEvent motionEvent)`  L50 @Override
- `void cancel()`  L60
- `void onFinishInflate()`  L69 @Override
    - 体内字面量：" only supports one child view"
- `boolean dispatchTouchEvent(MotionEvent motionEvent)`  L81 @Override
- `void run()`  L95 @Override
- `boolean onTouchEvent(MotionEvent motionEvent)`  L107 @Override
- `void onDetachedFromWindow()`  L120 @Override
- `void setOnDoubleClickListener(OnDoubleClickListener onDoubleClickListener)`  L125
### `com.gku.base.view.HideShowFrameLayout$OnDoubleClickListener`
L22 · [interface] public OnDoubleClickListener · `com/gku/base/view/HideShowFrameLayout.java`

方法（1）：
- `void onDoubleClick()`  L23
### `com.gku.base.view.LoadingLayout`
L13 · [class] public LoadingLayout · extends `RelativeLayout` · `com/gku/base/view/LoadingLayout.java`

字段/常量（3）：
- `FourCircleLoadingView fourCircleLoadingView`  L14
- `int mode`  L15
- `TextView tv_log`  L16

方法（14）：
- `public LoadingLayout(Context context)`  L22
- `public LoadingLayout(Context context, AttributeSet attributeSet)`  L26
- `void anim(boolean z)`  L45
- `TextView getTv_log()`  L53
- `void s(Callback callback, boolean z)`  L58
- `int getMode()`  L68
- `void setMode(int i)`  L72
- `void load(final Callback callback)`  L76
- `void onClick(View view)`  L80 @Override
- `void showText(String str)`  L86
- `void fail(String str)`  L92
- `void fail(String str, int i)`  L97
    - 体内字面量：":"
- `void fail()`  L101
- `void success()`  L105
### `com.gku.base.view.LoadingLayout$Callback`
L18 · [interface] public Callback · `com/gku/base/view/LoadingLayout.java`

方法（1）：
- `void onDoNet(int i, boolean z)`  L19
### `com.gku.base.view.RecordDotView`
L11 · [class] public RecordDotView · extends `View` · `com/gku/base/view/RecordDotView.java`

字段/常量（6）：
- `ValueAnimator blinkAnimator`  L12
- `Paint paint`  L13
- `ValueAnimator valueAnimator = this.blinkAnimator`  L56
- `ValueAnimator valueAnimator = this.blinkAnimator`  L79
- `ValueAnimator valueAnimator = this.blinkAnimator`  L87
- `ValueAnimator valueAnimator = this.blinkAnimator`  L94

方法（12）：
- `public RecordDotView(Context context)`  L15
- `public RecordDotView(Context context, AttributeSet attributeSet)`  L19
- `void onDraw(Canvas canvas)`  L28 @Override
- `void onAttachedToWindow()`  L34 @Override
- `void onDetachedFromWindow()`  L40 @Override
- `void onVisibilityChanged(View view, int i)`  L46 @Override
- `void startBlinkAnimation()`  L55
- `void onAnimationUpdate(ValueAnimator valueAnimator2)`  L65 @Override
- `void m2310lambda$startBlinkAnimation$0$comgkubaseviewRecordDotView(ValueAnimator valueAnimator)`  L74
- `void stopBlinkAnimation()`  L78
- `void pauseBlinkAnimation()`  L86
- `void resumeBlinkAnimation()`  L93
### `com.gku.base.view.ShimmerFrameLayout`
L23 · [class] public ShimmerFrameLayout · extends `FrameLayout` · `com/gku/base/view/ShimmerFrameLayout.java`

字段/常量（30）：
- `byte DEFAULT_ANGLE = 20`  L24
- `int DEFAULT_ANIMATION_DURATION = 1500`  L25
- `byte MAX_ANGLE_VALUE = 45`  L26
- `byte MAX_GRADIENT_CENTER_COLOR_WIDTH_VALUE = 1`  L27
- `byte MAX_MASK_WIDTH_VALUE = 1`  L28
- `byte MIN_ANGLE_VALUE = -45`  L29
- `byte MIN_GRADIENT_CENTER_COLOR_WIDTH_VALUE = 0`  L30
- `byte MIN_MASK_WIDTH_VALUE = 0`  L31
- `boolean autoStart`  L32
- `Canvas canvasForShimmerMask`  L33
- `float gradientCenterColorWidth`  L34
- `Paint gradientTexturePaint`  L35
- `boolean isAnimationReversed`  L36
- `boolean isAniming`  L37
- `Bitmap localMaskBitmap`  L38
- `ValueAnimator maskAnimator`  L39
- `Bitmap maskBitmap`  L40
- `int maskOffsetX`  L41
- `Rect maskRect`  L42
- `float maskWidth`  L43
- `int shimmerAngle`  L44
- `int shimmerAnimationDuration`  L45
- `int shimmerColor`  L46
- `ViewTreeObserver.OnPreDrawListener startAnimationPreDrawListener`  L47
- `ValueAnimator valueAnimator = this.maskAnimator`  L216
- `Bitmap bitmap = this.maskBitmap`  L229
- `int i = this.shimmerColor`  L252
- `ValueAnimator valueAnimator = this.maskAnimator`  L263
- `int i2 = width - i`  L273
- `float f = this.gradientCenterColorWidth`  L317

方法（31）：
- `public ShimmerFrameLayout(Context context)`  L49
- `public ShimmerFrameLayout(Context context, AttributeSet attributeSet)`  L53
- `public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i)`  L57
- `boolean isAniming()`  L83
- `void onDetachedFromWindow()`  L88 @Override
- `void dispatchDraw(Canvas canvas)`  L94 @Override
- `void setVisibility(int i)`  L103 @Override
- `void startShimmerAnimation()`  L115
- `boolean onPreDraw()`  L122 @Override
- `void stopShimmerAnimation()`  L135
- `void setShimmerColor(int i)`  L142
- `void setShimmerAnimationDuration(int i)`  L147
- `void setAnimationReversed(boolean z)`  L152
- `void setShimmerAngle(int i)`  L157
    - 体内字面量："shimmerAngle value must be between %d and %d"
- `void setMaskWidth(float f)`  L165
    - 体内字面量："maskWidth value must be higher than %d and less or equal to %d"
- `void setGradientCenterColorWidth(float f)`  L173
    - 体内字面量："gradientCenterColorWidth value must be higher than %d and less than %d"
- `void resetIfStarted()`  L181
- `void dispatchDrawShimmer(Canvas canvas)`  L188
- `void drawShimmer(Canvas canvas)`  L207
- `void resetShimmering()`  L215
- `void releaseBitMaps()`  L227
- `Bitmap getMaskBitmap()`  L236
- `void createShimmerPaint()`  L243
- `Animator getShimmerAnimation()`  L262
- `void onAnimationUpdate(ValueAnimator valueAnimator2)`  L280 @Override
- `Bitmap createBitmap(int i, int i2)`  L290
- `int getColor(int i)`  L299
- `int reduceColorAlphaValueToZero(int i)`  L303
- `Rect calculateBitmapMaskRect()`  L307
- `int calculateMaskWidth()`  L311
- `float[] getGradientColorDistribution()`  L315
### `com.gku.base.view.ShimmerLayoutSimple`
L29 · [class] public ShimmerLayoutSimple · extends `ShimmerFrameLayout` · `com/gku/base/view/ShimmerLayoutSimple.java`

字段/常量（14）：
- `int MODE_LOAD = 0`  L30
- `int MODE_LOADMORE = 2`  L31
- `int MODE_REFRESH = 1`  L32
- `ImageView iv`  L33
- `OnLoadMoreListener onLoadMoreListener`  L34
- `int page`  L35
- `RefreshLayoutNiubility refreshLayoutNiubility`  L36
- `TextView tv_hint`  L37
- `RefreshLayoutNiubility refreshLayoutNiubility = this.refreshLayoutNiubility`  L116
- `CallbackSuccess callbackSuccess2 = callbackSuccess`  L124
- `RefreshLayoutNiubility refreshLayoutNiubility = this.refreshLayoutNiubility`  L137
- `RefreshLayoutNiubility refreshLayoutNiubility = this.refreshLayoutNiubility`  L167
- `RefreshLayoutNiubility refreshLayoutNiubility = this.refreshLayoutNiubility`  L179
- `OnLoadMoreListener onLoadMoreListener = this.onLoadMoreListener`  L301

方法（38）：
- `public ShimmerLayoutSimple(Context context)`  L53
- `public ShimmerLayoutSimple(Context context, AttributeSet attributeSet)`  L57
- `void setIV(int i)`  L79
- `void s(Callback callback)`  L84
- `void shimmer(final Callback callback)`  L95
- `void onClick(View view)`  L99 @Override
- `TextView getTv_hint()`  L105
- `void success()`  L109
- `void success(final int i, final CallbackSuccess callbackSuccess)`  L114
- `void onClosed()`  L123 @Override
- `void successVisible(final int i, final CallbackSuccess callbackSuccess)`  L135
- `void onClosed()`  L146 @Override
- `void setHintText(String str)`  L153
- `void showHint(String str)`  L157
- `void showHint(String str, boolean z)`  L161
- `void onClosed()`  L173 @Override
- `void finishRefresh()`  L178
- `void showFail()`  L185
- `void showFail(boolean z)`  L189
- `void shimmer(RefreshLayoutNiubility refreshLayoutNiubility, int i, final Callback callback)`  L193
- `void onRefreshStart(IHeadView iHeadView)`  L199 @Override
- `void shimmer(BaseRVRefreshLayout baseRVRefreshLayout, int i, SimpleAdapter simpleAdapter, final Callback callback)`  L206
- `void onRefreshStart(IHeadView iHeadView)`  L212 @Override
- `void shimmer(LinearRefreshLayout linearRefreshLayout, final int i, MultiAdapter<SimpleAdapter> multiAdapter, final Callback callback)`  L219
- `void bindDataToLoadMore(BaseViewHolder baseViewHolder, String str)`  L225 @Override
- `void onLoadMoreStart()`  L231 @Override
- `void onRefreshStart(IHeadView iHeadView)`  L239 @Override
- `void shimmer(GridRefreshLayout gridRefreshLayout, final int i, MultiAdapter<SimpleAdapter> multiAdapter, final Callback callback)`  L246
- `void bindDataToLoadMore(BaseViewHolder baseViewHolder, String str)`  L252 @Override
- `void onLoadMoreStart()`  L258 @Override
- `void onRefreshStart(IHeadView iHeadView)`  L266 @Override
- `void shimmer(StaggeredRefreshLayout staggeredRefreshLayout, final int i, MultiAdapter<SimpleAdapter> multiAdapter, final Callback callback)`  L273
- `void bindDataToLoadMore(BaseViewHolder baseViewHolder, String str)`  L279 @Override
- `void onLoadMoreStart()`  L285 @Override
- `void onRefreshStart(IHeadView iHeadView)`  L293 @Override
- `void closeLoadMore(OnLoadMoreListener.Callback callback)`  L300
- `int getPage()`  L314
- `void setPage(int i)`  L318
### `com.gku.base.view.ShimmerLayoutSimple$Callback`
L39 · [class] public static abstract Callback · `com/gku/base/view/ShimmerLayoutSimple.java`

方法（2）：
- `int getPageFirst()`  L40
- `void onDoNet(int i)`  L44
### `com.gku.base.view.ShimmerLayoutSimple$CallbackSuccess`
L47 · [interface] public CallbackSuccess · `com/gku/base/view/ShimmerLayoutSimple.java`

方法（2）：
- `void onLoadMoreClosed(int i)`  L48
- `void onRefreshClosed(int i)`  L50