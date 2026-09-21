# TUWIN — 类与成员明细：com.xuliwen.zoom

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `com.xuliwen.zoom.ZoomLayout`
L22 · [class] public ZoomLayout · extends `LinearLayout` · `com/xuliwen/zoom/ZoomLayout.java`

字段/常量（42）：
- `float DEFAULT_DOUBLE_CLICK_ZOOM = 2.0f`  L23
- `float DEFAULT_MAX_ZOOM = 4.0f`  L24
- `float DEFAULT_MIN_ZOOM = 1.0f`  L25
- `String TAG = "ZoomLayout"`  L26
- `AccelerateInterpolator mAccelerateInterpolator`  L27
- `float mCurrentZoom`  L28
- `DecelerateInterpolator mDecelerateInterpolator`  L29
- `float mDoubleClickZoom`  L30
- `GestureDetector mGestureDetector`  L31
- `int mLastCenterX`  L32
- `int mLastCenterY`  L33
- `int mLastChildHeight`  L34
- `int mLastChildWidth`  L35
- `int mLastHeight`  L36
- `int mLastWidth`  L37
- `float mMaxZoom`  L38
- `int mMaximumVelocity`  L39
- `float mMinZoom`  L40
- `int mMinimumVelocity`  L41
- `boolean mNeedReScale`  L42
- `OverScroller mOverScroller`  L43
- `ScaleGestureDetector mScaleDetector`  L44
- `ScaleHelper mScaleHelper`  L45
- `boolean mScrollBegin`  L46
- `GestureDetector.SimpleOnGestureListener mSimpleOnGestureListener`  L47
- `ScaleGestureDetector.SimpleOnScaleGestureListener mSimpleOnScaleGestureListener`  L48
- `ZoomLayoutGestureListener mZoomLayoutGestureListener`  L49
- `float f = 1.0f`  L103
- `ZoomLayout zoomLayout = ZoomLayout.this`  L126
- `float f = 1.0f`  L187
- `ZoomLayout zoomLayout = ZoomLayout.this`  L210
- `float f = 1.0f`  L271
- `ZoomLayout zoomLayout = ZoomLayout.this`  L294
- `TypedArray typedArrayObtainStyledAttributes = null`  L321
- `float f2 = this.mMaxZoom`  L328
- `int i5 = this.mMaximumVelocity`  L352
- `int i6 = this.mMaximumVelocity`  L354
- `float f2 = this.mCurrentZoom`  L384
- `int i5 = i4 >= 0 ? i4 : 0`  L422
- `int i = currX - scrollX`  L491
- `int i2 = currY - scrollY`  L492
- `int childMeasureSpec`  L514

方法（43）：
- `public ZoomLayout(Context context)`  L59
- `void onScaleEnd(ScaleGestureDetector scaleGestureDetector)`  L64 @Override
- `boolean onScale(ScaleGestureDetector scaleGestureDetector)`  L68 @Override
- `boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector)`  L83 @Override
- `boolean onDown(MotionEvent motionEvent)`  L93 @Override
- `boolean onDoubleTap(MotionEvent motionEvent)`  L102 @Override
- `boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2)`  L116 @Override
- `boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2)`  L132 @Override
- `public ZoomLayout(Context context, AttributeSet attributeSet)`  L143
- `void onScaleEnd(ScaleGestureDetector scaleGestureDetector)`  L148 @Override
- `boolean onScale(ScaleGestureDetector scaleGestureDetector)`  L152 @Override
- `boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector)`  L167 @Override
- `boolean onDown(MotionEvent motionEvent)`  L177 @Override
- `boolean onDoubleTap(MotionEvent motionEvent)`  L186 @Override
- `boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2)`  L200 @Override
- `boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2)`  L216 @Override
- `public ZoomLayout(Context context, AttributeSet attributeSet, int i)`  L227
- `void onScaleEnd(ScaleGestureDetector scaleGestureDetector)`  L232 @Override
- `boolean onScale(ScaleGestureDetector scaleGestureDetector)`  L236 @Override
- `boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector)`  L251 @Override
- `boolean onDown(MotionEvent motionEvent)`  L261 @Override
- `boolean onDoubleTap(MotionEvent motionEvent)`  L270 @Override
- `boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2)`  L284 @Override
- `boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2)`  L300 @Override
- `void init(Context context, AttributeSet attributeSet)`  L311
- `boolean fling(int i, int i2)`  L343
- `void smoothScale(float f, int i, int i2)`  L362
- `void notifyInvalidate()`  L377
- `void setScale(float f, int i, int i2)`  L381
- `void processScroll(int i, int i2, int i3, int i4)`  L410
- `int getScrollRangeX()`  L428
- `int getContentWidth()`  L432
- `int getScrollRangeY()`  L437
- `int getContentHeight()`  L441
- `View child()`  L445
- `void onLayout(boolean z, int i, int i2, int i3, int i4)`  L450 @Override
- `void onDraw(Canvas canvas)`  L459 @Override
- `void computeScroll()`  L480 @Override
- `boolean dispatchTouchEvent(MotionEvent motionEvent)`  L503 @Override
- `void measureChildWithMargins(View view, int i, int i2, int i3, int i4)`  L513 @Override
- `boolean canScrollHorizontally(int i)`  L527 @Override
- `boolean canScrollVertically(int i)`  L535 @Override
- `void setZoomLayoutGestureListener(ZoomLayoutGestureListener zoomLayoutGestureListener)`  L542
### `com.xuliwen.zoom.ZoomLayout$ZoomLayoutGestureListener`
L51 · [interface] public ZoomLayoutGestureListener · `com/xuliwen/zoom/ZoomLayout.java`

方法（3）：
- `void onDoubleTap()`  L52
- `void onScaleGestureBegin()`  L54
- `void onScrollBegin()`  L56