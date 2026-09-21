# idGoLive — 类与成员明细：com.icatchtek.basecomponent.customcomponent

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 25 个文件 / 32 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.basecomponent.customcomponent.BorderImageView`
L12 · [class] public BorderImageView · extends `ImageView` · `com/icatchtek/basecomponent/customcomponent/BorderImageView.java`

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
### `com.icatchtek.basecomponent.customcomponent.CropImageView`
L16 · [class] public CropImageView · extends `View` · `com/icatchtek/basecomponent/customcomponent/CropImageView.java`

字段/常量（40）：
- `int EDGE_LB`  L17
- `int EDGE_LT`  L18
- `int EDGE_MOVE_IN`  L19
- `int EDGE_MOVE_OUT`  L20
- `int EDGE_NONE`  L21
- `int EDGE_RB`  L22
- `int EDGE_RT`  L23
- `int STATUS_MULTI_START`  L24
- `int STATUS_MULTI_TOUCHING`  L25
- `int STATUS_SINGLE`  L26
- `int cropHeight`  L27
- `int cropWidth`  L28
- `int currentEdge`  L29
- `boolean isFrist`  L30
- `boolean isTouchInSquare`  L31
- `Context mContext`  L32
- `Drawable mDrawable`  L33
- `Rect mDrawableDst`  L34
- `Rect mDrawableFloat`  L35
- `Rect mDrawableSrc`  L36
- `FloatDrawable mFloatDrawable`  L37
- `int mStatus`  L38
- `float mX_1`  L39
- `float mY_1`  L40
- `float maxZoomOut`  L41
- `float minZoomIn`  L42
- `float oriRationWH`  L43
- `boolean z`  L137
- `int right = this.mDrawableFloat.left`  L138
- `int bottom = this.mDrawableFloat.top`  L139
- `boolean z2 = true`  L140
- `Drawable drawable = this.mDrawable`  L227
- `int i = this.mStatus`  L243
- `int i2 = this.mStatus`  L250
- `int i3 = this.mStatus`  L267
- `int i4 = this.currentEdge`  L274
- `Rect rect = this.mDrawableFloat`  L276
- `Rect rect2 = this.mDrawableFloat`  L279
- `Rect rect3 = this.mDrawableFloat`  L282
- `Rect rect4 = this.mDrawableFloat`  L285

方法（12）：
- `public CropImageView(Context context)`  L45
- `public CropImageView(Context context, AttributeSet attributeSet)`  L72
- `public CropImageView(Context context, AttributeSet attributeSet, int i)`  L99
- `void init(Context context)`  L126
- `void checkBounds()`  L136
- `void configureBounds()`  L166
- `int dipTopx(Context context, float f)`  L194
- `Bitmap getCropImage()`  L198
- `int getTouch(int i, int i2)`  L209
- `void onDraw(Canvas canvas)`  L226 @Override
- `boolean onTouchEvent(MotionEvent motionEvent)`  L241 @Override
- `void setDrawable(Drawable drawable, int i, int i2)`  L300
### `com.icatchtek.basecomponent.customcomponent.FloatDrawable`
L11 · [class] public FloatDrawable · extends `Drawable` · `com/icatchtek/basecomponent/customcomponent/FloatDrawable.java`

字段/常量（2）：
- `Context mContext`  L12
- `int offset = 50`  L13

方法（9）：
- `public FloatDrawable(Context context)`  L17
- `int dipTopx(Context context, float f)`  L31
- `void draw(Canvas canvas)`  L36 @Override
- `int getBorderHeight()`  L52
- `int getBorderWidth()`  L56
- `int getOpacity()`  L61 @Override
- `void setAlpha(int i)`  L66 @Override
- `void setBounds(Rect rect)`  L70 @Override
- `void setColorFilter(ColorFilter colorFilter)`  L75 @Override
### `com.icatchtek.basecomponent.customcomponent.ImageProgressView`
L18 · [class] public ImageProgressView · extends `View` · `com/icatchtek/basecomponent/customcomponent/ImageProgressView.java`

字段/常量（24）：
- `int MAX_ALPHA = 255`  L19
- `int MIN_ALPHA = 0`  L20
- `Bitmap bitmap`  L21
- `float currentAngle`  L22
- `Handler handler`  L23
- `int len`  L24
- `Paint linePaint2`  L25
- `Paint linePaint3`  L26
- `float mHeight`  L27
- `float mWidth`  L28
- `int maxProgress`  L29
- `boolean needGradient`  L30
- `RectF oval`  L31
- `float radius`  L32
- `boolean running`  L33
- `float startAngle`  L34
- `float stepAngel`  L35
- `float sweepAngle`  L36
- `String text`  L37
- `Paint textPaint`  L38
- `MyThread thread`  L39
- `float f = this.radius`  L86
- `int i3 = this.len`  L124
- `int i4 = this.len`  L126

方法（13）：
- `public ImageProgressView(Context context, AttributeSet attributeSet)`  L54
    - 体内字面量："æµè¯"
- `void handleMessage(Message message)`  L65 @Override
- `void canvasArc(Canvas canvas)`  L79
- `void canvasCircle(Canvas canvas)`  L90
    - 体内字面量："#dddddd"
- `void drawText(Canvas canvas)`  L100
- `void init()`  L103
- `boolean isRunning()`  L107
- `void onDraw(Canvas canvas)`  L112 @Override
- `void onMeasure(int i, int i2)`  L119 @Override
- `void setCurrentProgress(int i)`  L131
- `void setMaxProgress(int i)`  L135
- `void startTurning()`  L140
- `void stopTurning()`  L148
### `com.icatchtek.basecomponent.customcomponent.ImageProgressView$MyThread`
L41 · [class] MyThread · extends `Thread` · `com/icatchtek/basecomponent/customcomponent/ImageProgressView.java`

方法（1）：
- `void run()`  L46 @Override
### `com.icatchtek.basecomponent.customcomponent.MProgressWheel`
L15 · [class] public MProgressWheel · extends `View` · `com/icatchtek/basecomponent/customcomponent/MProgressWheel.java`

字段/常量（52）：
- `int barColor`  L16
- `int barLength`  L17
- `Paint barPaint`  L18
- `int barWidth`  L19
- `RectF circleBounds`  L20
- `int circleColor`  L21
- `RectF circleInnerContour`  L22
- `RectF circleOuterContour`  L23
- `Paint circlePaint`  L24
- `int circleRadius`  L25
- `int contourColor`  L26
- `Paint contourPaint`  L27
- `float contourSize`  L28
- `int delayMillis`  L29
- `int fullRadius`  L30
- `RectF innerCircleBounds`  L31
- `boolean isSpinning`  L32
- `int layoutHeight`  L33
- `int layoutWidth`  L34
- `int paddingBottom`  L35
- `int paddingLeft`  L36
- `int paddingRight`  L37
- `int paddingTop`  L38
- `float progress`  L39
- `int rimColor`  L40
- `Paint rimPaint`  L41
- `int rimWidth`  L42
- `float spinSpeed`  L43
- `String[] splitText`  L44
- `String text`  L45
- `int textColor`  L46
- `Paint textPaint`  L47
- `int textSize`  L48
- `float f = this.progress + this.spinSpeed`  L112
- `int i = this.layoutWidth - iMin`  L122
- `int i3 = i / 2`  L126
- `float f = this.paddingLeft`  L131
- `int i4 = this.barWidth`  L132
- `int i5 = this.paddingLeft`  L134
- `int i6 = this.barWidth`  L135
- `int i7 = width - this.paddingRight`  L139
- `int i8 = this.barWidth`  L140
- `float f = this.progress + i`  L254
- `Paint paint = this.barPaint`  L321
- `Paint paint = this.barPaint`  L333
- `Paint paint = this.circlePaint`  L341
- `Paint paint = this.contourPaint`  L353
- `Paint paint = this.contourPaint`  L361
- `Paint paint = this.rimPaint`  L395
- `Paint paint = this.rimPaint`  L407
- `Paint paint = this.textPaint`  L424
- `Paint paint = this.textPaint`  L432

方法（53）：
- `public MProgressWheel(Context context, AttributeSet attributeSet)`  L50
- `void parseAttributes(TypedArray typedArray)`  L88
- `void scheduleRedraw()`  L111
- `void setupBounds()`  L120
- `void setupPaints()`  L146
- `int getBarColor()`  L168
- `int getBarLength()`  L172
- `int getBarWidth()`  L176
- `int getCircleColor()`  L180
- `int getCircleRadius()`  L184
- `int getContourColor()`  L188
- `float getContourSize()`  L192
- `int getDelayMillis()`  L196
- `int getPaddingBottom()`  L201 @Override
- `int getPaddingLeft()`  L206 @Override
- `int getPaddingRight()`  L211 @Override
- `int getPaddingTop()`  L216 @Override
- `int getProgress()`  L220
- `int getRimColor()`  L224
- `Shader getRimShader()`  L228
- `int getRimWidth()`  L232
- `float getSpinSpeed()`  L236
- `int getTextColor()`  L240
- `int getTextSize()`  L244
- `void incrementProgress()`  L248
- `void incrementProgress(int i)`  L252
- `boolean isSpinning()`  L262
- `void onDraw(Canvas canvas)`  L267 @Override
- `void onMeasure(int i, int i2)`  L287 @Override
- `void onSizeChanged(int i, int i2, int i3, int i4)`  L304 @Override
- `void resetCount()`  L313
    - 体内字面量："0%"
- `void setBarColor(int i)`  L319
- `void setBarLength(int i)`  L327
- `void setBarWidth(int i)`  L331
- `void setCircleColor(int i)`  L339
- `void setCircleRadius(int i)`  L347
- `void setContourColor(int i)`  L351
- `void setContourSize(float f)`  L359
- `void setDelayMillis(int i)`  L367
- `void setPaddingBottom(int i)`  L371
- `void setPaddingLeft(int i)`  L375
- `void setPaddingRight(int i)`  L379
- `void setPaddingTop(int i)`  L383
- `void setProgress(int i)`  L387
- `void setRimColor(int i)`  L393
- `void setRimShader(Shader shader)`  L401
- `void setRimWidth(int i)`  L405
- `void setSpinSpeed(float f)`  L413
- `void setText(String str)`  L417
    - 体内字面量："\n"
- `void setTextColor(int i)`  L422
- `void setTextSize(int i)`  L430
- `void startSpinning()`  L438
- `void stopSpinning()`  L443
### `com.icatchtek.basecomponent.customcomponent.PhotoCropView`
L17 · [class] public PhotoCropView · extends `View` · `com/icatchtek/basecomponent/customcomponent/PhotoCropView.java`

字段/常量（54）：
- `int ACCURACY = 15`  L18
- `float EDGE_WIDTH = 1.8f`  L19
- `int MODE_ILLEGAL = 221`  L20
- `int MODE_INSIDE = 187`  L21
- `int MODE_OUTSIDE = 170`  L22
- `int MODE_POINT = 204`  L23
- `int START_X = 200`  L24
- `int START_Y = 200`  L25
- `String TAG = "PhotoCropView"`  L26
- `int minHeight = 200`  L27
- `int minWidth = 100`  L28
- `int MODE`  L29
- `onChangeLocationlistener changeLocationlistener`  L30
- `int coverHeight`  L31
- `int coverWidth`  L32
- `int eX`  L33
- `int eY`  L34
- `onLocationListener locationListener`  L35
- `Bitmap mBitmapCover`  L36
- `Bitmap mBitmapRectBlack`  L37
- `Paint mPaint`  L38
- `Paint mPaintLine`  L39
- `int memonyX`  L40
- `int memonyY`  L41
- `int pointPosition`  L42
- `int pressX`  L43
- `int pressY`  L44
- `int sX`  L45
- `int sY`  L46
- `PorterDuffXfermode xfermode`  L47
- `int i = this.coverWidth`  L97
- `int i2 = this.coverHeight`  L98
- `int i3 = this.pointPosition`  L124
- `int i4 = this.coverWidth`  L134
- `int i5 = this.coverHeight`  L135
- `int i6 = this.coverWidth`  L149
- `int i7 = this.coverHeight`  L150
- `int i8 = this.coverWidth`  L164
- `int i9 = this.coverHeight`  L165
- `int i10 = this.coverWidth`  L181
- `int i11 = this.coverHeight`  L182
- `int i3 = i - this.memonyX`  L188
- `int i4 = i2 - this.memonyY`  L189
- `int i5 = this.sX + i3`  L190
- `int i6 = this.sY + i4`  L192
- `onLocationListener onlocationlistener = this.locationListener`  L244
- `float f = this.sX - EDGE_WIDTH`  L250
- `int i = this.sY`  L251
- `float f2 = this.sX - EDGE_WIDTH`  L253
- `int i2 = this.eY`  L254
- `int i3 = this.sX`  L256
- `int i4 = this.eX`  L258
- `int i`  L264
- `onChangeLocationlistener onchangelocationlistener = this.changeLocationlistener`  L267

方法（15）：
- `public PhotoCropView(Context context)`  L57
- `public PhotoCropView(Context context, AttributeSet attributeSet)`  L64
- `public PhotoCropView(Context context, AttributeSet attributeSet, int i)`  L71
- `boolean checkLegalRect(int i, int i2)`  L78
- `void checkMode(int i, int i2)`  L82
- `void init()`  L92
    - 体内字面量："window"
- `Bitmap makeBitmap(int i, int i2, int i3, int i4, int i5)`  L114
- `void moveByPoint(int i, int i2)`  L123
- `void moveByTouch(int i, int i2)`  L187
- `int nearbyPoint(int i, int i2)`  L200
- `void recoverFromIllegal(int i, int i2)`  L221
- `void refreshLocation(int i, int i2, int i3, int i4)`  L229
- `void onDraw(Canvas canvas)`  L237 @Override
- `boolean onTouchEvent(MotionEvent motionEvent)`  L263 @Override
- `void setLocationListener(onLocationListener onlocationlistener)`  L304
### `com.icatchtek.basecomponent.customcomponent.PhotoCropView$onChangeLocationlistener`
L49 · [interface] public onChangeLocationlistener · `com/icatchtek/basecomponent/customcomponent/PhotoCropView.java`

方法（1）：
- `void locationChange(String str)`  L50
### `com.icatchtek.basecomponent.customcomponent.PhotoCropView$onLocationListener`
L53 · [interface] public onLocationListener · `com/icatchtek/basecomponent/customcomponent/PhotoCropView.java`

方法（1）：
- `void locationRect(int i, int i2, int i3, int i4)`  L54
### `com.icatchtek.basecomponent.customcomponent.RadarData`
L6 · [class] public RadarData · `com/icatchtek/basecomponent/customcomponent/RadarData.java`

字段/常量（2）：
- `LinkedList<RadarPoint> points`  L7
- `long timestamp`  L8

方法（3）：
- `public RadarData()`  L10
- `public RadarData(long j, LinkedList<RadarPoint> linkedList)`  L14
- `public RadarData(RadarData radarData)`  L19
### `com.icatchtek.basecomponent.customcomponent.RadarPoint`
L4 · [class] public RadarPoint · `com/icatchtek/basecomponent/customcomponent/RadarPoint.java`

字段/常量（5）：
- `long timestamp`  L5
- `long vx`  L6
- `long vy`  L7
- `long x`  L8
- `long y`  L9

方法（12）：
- `public RadarPoint()`  L11
- `public RadarPoint(long j, long j2, long j3, long j4, long j5)`  L15
- `public RadarPoint(RadarPoint radarPoint)`  L23
- `long getTimestamp()`  L32
- `long getVx()`  L36
- `long getVy()`  L40
- `long getX()`  L44
- `long getY()`  L48
- `void setVx(long j)`  L52
- `void setVy(long j)`  L56
- `void setX(long j)`  L60
- `void setY(long j)`  L64
### `com.icatchtek.basecomponent.customcomponent.RadarView`
L17 · [class] public RadarView · extends `View` · `com/icatchtek/basecomponent/customcomponent/RadarView.java`

字段/常量（17）：
- `int LINE_NUM = 6`  L18
- `int Max_X = 680`  L19
- `int Max_Y = 680`  L20
- `int height = 600`  L21
- `int startX = 80`  L23
- `int startY = 80`  L24
- `int width = 600`  L25
- `CharSequence charSequence`  L26
- `Paint paintAxes`  L27
- `Paint paintAxes2`  L28
- `String[] xnums`  L29
- `String[] ynums`  L30
- `int i2 = i * 100`  L69
- `double d2 = 600`  L86
- `float[] fArr = {0.61f, 0.65f, 0.73f, 0.83f, 0.99f, 1.05f, 1.19f, 1.32f, 1.41f, 1.5f, 1.56f, 1.59f, 1.636f, 1.636f, 1.636f, 0.458f, 0.461f, 0.398f, 0.264f, 0.033f, -0.18f, -0.45f, -0.45f, -0.45f, -0.92f, -0.91f, -0.92f, -0.93f, -0.89f, -0.87f, -0.76f, -0.68f, -0.58f, -0.46f, -0.31f, -0.26f, -0.07f, -0.02f, -0.02f, -0.02f, -0.23f, -0.05f, -0.05f, -0.05f, -0.01f, -0.01f, -0.01f, -0.01f, -0.01f}`  L96
- `float[] fArr2 = {0.939f, 1.009f, 1.135f, 1.282f, 1.507f, 1.579f, 1.757f, 1.993f, 2.292f, 2.598f, 2.931f, 3.316f, 3.679f, 3.679f, 3.679f, 3.178f, 3.39f, 3.631f, 3.892f, 4.18f, 4.444f, 4.68f, 4.68f, 4.68f, 2.94f, 2.855f, 2.788f, 2.654f, 2.467f, 2.226f, 1.836f, 1.561f, 1.3f, 1.059f, 0.842f, 0.531f, 0.284f, 0.179f, 0.179f, 0.179f, 0.604f, 0.157f, 0.157f, 0.137f, 0.03f, 0.04f, 0.04f, 0.059f, 0.059f}`  L97
- `float f3 = fArr[i]`  L99

方法（5）：
- `public RadarView(Context context)`  L32
    - 体内字面量："-6" · "-4" · "-2" · "4" · "6" · "4" · "6" · "8" · "10" · "12"
- `public RadarView(Context context, AttributeSet attributeSet)`  L38
    - 体内字面量："-6" · "-4" · "-2" · "4" · "6" · "4" · "6" · "8" · "10" · "12"
- `public RadarView(Context context, AttributeSet attributeSet, int i)`  L44
    - 体内字面量："-6" · "-4" · "-2" · "4" · "6" · "4" · "6" · "8" · "10" · "12"
- `void onDraw(Canvas canvas)`  L51 @Override
- `void setPoints(float f, float f2)`  L95
### `com.icatchtek.basecomponent.customcomponent.RadarView2`
L18 · [class] public RadarView2 · extends `View` · `com/icatchtek/basecomponent/customcomponent/RadarView2.java`

字段/常量（26）：
- `int height`  L19
- `int width`  L20
- `Point Coordinate`  L21
- `int centerX`  L22
- `int centerY`  L23
- `TreeSet<Float> circleDf`  L24
- `Map<Float, Float> circleMap`  L25
- `Map<Float, Float> circleMap2`  L26
- `Map<Float, Float> circleMap3`  L27
- `Map<Float, Float> circleMap4`  L28
- `Map<Float, Float> circleMap5`  L29
- `double factLength`  L30
- `int lastX`  L31
- `int lastY`  L32
- `int level`  L33
- `Paint mCirclePaint`  L34
- `Paint mPaintLine`  L35
- `Paint mPointPaint`  L36
- `Paint mTextPaint`  L37
- `int number1`  L38
- `int number2`  L39
- `int number3`  L40
- `int number4`  L41
- `int number5`  L42
- `int i = x - this.lastX`  L210
- `int i2 = y - this.lastY`  L211

方法（10）：
- `public RadarView2(Context context)`  L44
- `public RadarView2(Context context, AttributeSet attributeSet)`  L62
- `void drawDataView(Canvas canvas, double d, double d2)`  L81
    - 体内字面量："#.000" · "km"
- `void drawMap(Canvas canvas, Map<Float, Float> map)`  L92
- `void init()`  L99
- `void resetCircleView()`  L125
- `void dispatchDraw(Canvas canvas)`  L150 @Override
- `void onDraw(Canvas canvas)`  L155 @Override
- `void onMeasure(int i, int i2)`  L178 @Override
- `boolean onTouchEvent(MotionEvent motionEvent)`  L199 @Override
### `com.icatchtek.basecomponent.customcomponent.RadarView3`
L19 · [class] public RadarView3 · extends `View` · `com/icatchtek/basecomponent/customcomponent/RadarView3.java`

字段/常量（31）：
- `int LINE_NUM = 6`  L20
- `int height = 800`  L21
- `int startX = 80`  L22
- `int startY = 80`  L23
- `int width = 800`  L24
- `RadarPoint anPoint`  L25
- `ValueAnimator anim`  L26
- `CharSequence charSequence`  L27
- `RadarPoint currentPoint`  L28
- `Paint paintAxes`  L29
- `Paint paintAxes2`  L30
- `Queue<RadarPoint> pointQueue`  L31
- `RadarPoint prePoint`  L32
- `boolean update`  L33
- `String[] xnums`  L34
- `String[] ynums`  L35
- `int Max_X = 800 + 80`  L36
- `int Max_Y = 800 + 80`  L37
- `RadarPoint radarPoint = this.anPoint`  L137
- `int i2 = Max_Y`  L186
- `int i4 = height`  L189
- `int i5 = width`  L191
- `int i7 = width`  L196
- `int i8 = height`  L199
- `double d2 = i8`  L202
- `int i10 = Max_Y`  L205
- `RadarPoint radarPoint = this.anPoint`  L209
- `RadarPoint radarPoint2 = this.anPoint`  L211
- `int i3 = width`  L245
- `int i4 = height`  L247
- `int i = width`  L255

方法（8）：
- `public RadarView3(Context context)`  L112
    - 体内字面量："-6" · "-4" · "-2" · "4" · "6" · "4" · "6" · "8" · "10" · "12"
- `public RadarView3(Context context, AttributeSet attributeSet)`  L120
    - 体内字面量："-6" · "-4" · "-2" · "4" · "6" · "4" · "6" · "8" · "10" · "12"
- `public RadarView3(Context context, AttributeSet attributeSet, int i)`  L128
    - 体内字面量："-6" · "-4" · "-2" · "4" · "6" · "4" · "6" · "8" · "10" · "12"
- `void startAnimation()`  L136
- `void onAnimationUpdate(ValueAnimator valueAnimator)`  L150 @Override
- `void onDraw(Canvas canvas)`  L165 @Override
- `void onMeasure(int i, int i2)`  L231 @Override
- `void setPoints(float f, float f2, float f3, float f4, long j)`  L254
### `com.icatchtek.basecomponent.customcomponent.RadarView3$PointEvaluator`
L40 · [class] public PointEvaluator · implements `TypeEvaluator` · `com/icatchtek/basecomponent/customcomponent/RadarView3.java`

方法（2）：
- `public PointEvaluator()`  L41
- `Object evaluate(float f, Object obj, Object obj2)`  L45 @Override
### `com.icatchtek.basecomponent.customcomponent.RadarView3$RadarPoint`
L52 · [class] public RadarPoint · `com/icatchtek/basecomponent/customcomponent/RadarView3.java`

字段/常量（5）：
- `long timestamp`  L53
- `float vx`  L54
- `float vy`  L55
- `float x`  L56
- `float y`  L57

方法（11）：
- `public RadarPoint(float f, float f2, float f3, float f4, long j)`  L59
- `public RadarPoint(RadarPoint radarPoint)`  L67
- `long getTimestamp()`  L75
- `float getVx()`  L79
- `float getVy()`  L83
- `float getX()`  L87
- `float getY()`  L91
- `void setVx(float f)`  L95
- `void setVy(float f)`  L99
- `void setX(float f)`  L103
- `void setY(float f)`  L107
### `com.icatchtek.basecomponent.customcomponent.RadarView4`
L20 · [class] public RadarView4 · extends `View` · `com/icatchtek/basecomponent/customcomponent/RadarView4.java`

字段/常量（58）：
- `int ASSISTANGLE = 12`  L21
- `float INTERVAL_MM = 2000.0f`  L22
- `float LINE_NUM_X = 6.0f`  L23
- `float LINE_NUM_Y = 3.0f`  L24
- `RadarPoint anPoint`  L26
- `ValueAnimator anim`  L27
- `float centerX`  L28
- `float centerY`  L29
- `CharSequence charSequence`  L30
- `RadarPoint currentPoint`  L31
- `float height`  L32
- `float interval`  L33
- `Paint mCirclePaint`  L34
- `Paint mPaintLine`  L35
- `Path mPath`  L36
- `Paint mPointPaint`  L37
- `Paint mTextPaint`  L38
- `float maxX`  L39
- `float maxY`  L40
- `Paint paintAxes`  L41
- `Paint paintAxes2`  L42
- `Queue<RadarPoint> pointQueue`  L43
- `RadarPoint prePoint`  L44
- `float startX`  L45
- `float startY`  L46
- `boolean update`  L47
- `float width`  L48
- `String[] xnums`  L49
- `String[] ynums`  L50
- `RadarPoint radarPoint = this.anPoint`  L186
- `RadarPoint radarPoint = this.anPoint`  L214
- `int i = 1`  L247
- `float f = this.startX / 2.0f`  L259
- `float f2 = this.startY`  L260
- `float f3 = f < f2 ? f : f2 / 2.0f`  L261
- `int i2 = 0`  L262
- `float f4 = i2`  L264
- `int i3 = 0`  L271
- `float f5 = i3`  L273
- `int i4 = 0`  L280
- `float f6 = i4`  L282
- `float f7 = this.startX`  L286
- `float f8 = this.startY`  L287
- `float f9 = this.interval`  L288
- `int i5 = 0`  L292
- `float f10 = i5`  L294
- `float f11 = this.interval`  L298
- `float f12 = this.startX`  L299
- `float f13 = i`  L305
- `float f14 = this.width`  L312
- `double d2 = f14`  L315
- `float f15 = this.centerY`  L318
- `RadarPoint radarPoint = this.anPoint`  L322
- `RadarPoint radarPoint2 = this.anPoint`  L324
- `float f = size / 8.0f`  L350
- `float f2 = LINE_NUM_X * f`  L352
- `float f3 = 3.0f * f`  L354
- `float f5 = this.interval`  L367

方法（11）：
- `public RadarView4(Context context)`  L158
    - 体内字面量："-6" · "-4" · "-2" · "4" · "6" · "4" · "6" · "8" · "10" · "12"
- `public RadarView4(Context context, AttributeSet attributeSet)`  L167
    - 体内字面量："-6" · "-4" · "-2" · "4" · "6" · "4" · "6" · "8" · "10" · "12"
- `public RadarView4(Context context, AttributeSet attributeSet, int i)`  L176
    - 体内字面量："-6" · "-4" · "-2" · "4" · "6" · "4" · "6" · "8" · "10" · "12"
- `void startAnimation()`  L185
- `void onAnimationUpdate(ValueAnimator valueAnimator)`  L199 @Override
- `void startThread()`  L213
- `void onAnimationUpdate(ValueAnimator valueAnimator)`  L227 @Override
- `void onDraw(Canvas canvas)`  L242 @Override
- `void onMeasure(int i, int i2)`  L344 @Override
- `void setPoints(float f, float f2, float f3, float f4, long j)`  L366
- `void update()`  L372
### `com.icatchtek.basecomponent.customcomponent.RadarView4$PointEvaluator`
L52 · [class] public PointEvaluator · implements `TypeEvaluator` · `com/icatchtek/basecomponent/customcomponent/RadarView4.java`

方法（2）：
- `public PointEvaluator()`  L53
- `Object evaluate(float f, Object obj, Object obj2)`  L57 @Override
### `com.icatchtek.basecomponent.customcomponent.RadarView4$RadarPoint`
L64 · [class] public RadarPoint · `com/icatchtek/basecomponent/customcomponent/RadarView4.java`

字段/常量（13）：
- `float androidvx`  L65
- `float androidvy`  L66
- `float f7androidx`  L69
- `float androidy`  L70
- `long timestamp`  L71
- `float vx`  L72
- `float vy`  L73
- `float x`  L74
- `float y`  L75
- `float f = radarPoint.x`  L90
- `float f2 = radarPoint.y`  L92
- `float f3 = radarPoint.vx`  L94
- `float f4 = radarPoint.vy`  L96

方法（15）：
- `public RadarPoint(float f, float f2, float f3, float f4, long j)`  L77
- `public RadarPoint(RadarPoint radarPoint)`  L89
- `float getAndroidvx()`  L105
- `float getAndroidvy()`  L109
- `float getAndroidx()`  L113
- `float getAndroidy()`  L117
- `long getTimestamp()`  L121
- `float getVx()`  L125
- `float getVy()`  L129
- `float getX()`  L133
- `float getY()`  L137
- `void setVx(float f)`  L141
- `void setVy(float f)`  L145
- `void setX(float f)`  L149
- `void setY(float f)`  L153
### `com.icatchtek.basecomponent.customcomponent.ViewHelper`
L12 · [class] public ViewHelper · `com/icatchtek/basecomponent/customcomponent/ViewHelper.java`

字段/常量（7）：
- `int ViewHightPixels`  L13
- `int ViewWidthPixels`  L14
- `Context context`  L15
- `int maxLevel`  L16
- `int i3 = i * i2`  L22
- `int i5 = i * i4`  L29
- `double d3 = d2 * 0.017453292519943295d`  L55

方法（5）：
- `void drawCoordinateText(Canvas canvas, Point point, Point point2, Paint paint, int i)`  L18
- `Path getLinePath(Point point)`  L41
- `Point getPoinByLineAndAngle(double d, double d2)`  L54
- `Point getWinSize()`  L59
- `void setCoordinate(Point point, Canvas canvas, int i)`  L66
### `com.icatchtek.basecomponent.customcomponent.zones.Area`
L6 · [class] public Area · `com/icatchtek/basecomponent/customcomponent/zones/Area.java`

字段/常量（2）：
- `int AreaType`  L7
- `List<PercentLocation> locations`  L8

方法（5）：
- `public Area(List<PercentLocation> list, int i)`  L10
- `int getAreaType()`  L15
- `List<PercentLocation> getLocations()`  L19
- `void setAreaType(int i)`  L23
- `void setLocations(List<PercentLocation> list)`  L27
### `com.icatchtek.basecomponent.customcomponent.zones.AreaType`
L4 · [class] public AreaType · `com/icatchtek/basecomponent/customcomponent/zones/AreaType.java`

字段/常量（2）：
- `int TYPE_POLYGON = 1`  L5
- `int TYPE_RECTANGLE = 0`  L6
### `com.icatchtek.basecomponent.customcomponent.zones.BitmapUtil`
L14 · [class] public BitmapUtil · `com/icatchtek/basecomponent/customcomponent/zones/BitmapUtil.java`

字段/常量（37）：
- `String TAG = "BitmapUtil"`  L15
- `Bitmap bitmap`  L16
- `int i2`  L19
- `int i3`  L20
- `int i4`  L21
- `int i5`  L22
- `char c`  L23
- `int i6 = width / i`  L30
- `int i7 = height / i`  L31
- `int i8 = i * i`  L32
- `int[] iArr = new int[i8]`  L33
- `int i9 = 0`  L34
- `int i10 = 0`  L36
- `int i11 = i4 * i`  L44
- `int i12 = height - i11`  L45
- `int i13 = i12 * i`  L46
- `int i14 = i3 * i`  L54
- `int i15 = width - i14`  L55
- `int i16 = i4 * i`  L56
- `int i17 = height - i16`  L57
- `int i18 = i15 * i17`  L58
- `int i19 = i9 * i`  L71
- `int i20 = width - i19`  L72
- `int i21 = i20 * i`  L73
- `int iAlpha = 0`  L83
- `int iRed = 0`  L84
- `int iGreen = 0`  L85
- `int iBlue = 0`  L86
- `int i24 = i3 * i`  L98
- `int i25 = width - i24`  L99
- `int i26 = i4 * i`  L102
- `int i27 = i3 * i`  L105
- `int i28 = i4 * i`  L106
- `Bitmap bitmap2 = bitmap`  L126
- `float f5 = f * width`  L131
- `float f6 = f2 * height`  L134
- `Bitmap bitmap2 = bitmap`  L139

方法（5）：
- `Bitmap bitmapMosaic(Bitmap bitmap2, int i)`  L18
- `Bitmap cropBitmap(float f, float f2, float f3, float f4)`  L125
- `void recycleBitmap()`  L138
- `Bitmap rsBlur(Context context, Bitmap bitmap2, int i)`  L146
    - 体内字面量："scale size:" · "*"
- `void setBitmap(Bitmap bitmap2)`  L160
### `com.icatchtek.basecomponent.customcomponent.zones.DragPolygonView`
L24 · [class] public DragPolygonView · extends `DragView implements View.OnTouchListener` · implements `View.OnTouchListener` · `com/icatchtek/basecomponent/customcomponent/zones/DragPolygonView.java`

字段/常量（72）：
- `int MAX_DISTANCE_FOR_CLICK = 100`  L25
- `int MAX_INTERVAL_FOR_CLICK = 200`  L26
- `String TAG = "DragPolygonView"`  L27
- `int TOUCH_CENTER = 18`  L28
- `int TOUCH_PAINT = 17`  L29
- `int MIX_SCOPE`  L30
- `boolean close`  L31
- `float downX`  L32
- `float downY`  L33
- `int dragDirection`  L34
- `int dragPointIndex`  L35
- `float event_x`  L36
- `float event_y`  L37
- `Paint fillPaint`  L38
- `long lastTime`  L39
- `int lastX`  L40
- `int lastY`  L41
- `int mLineSize`  L42
- `Paint mMosaicPaint`  L43
- `Paint mPaint`  L44
- `int mParentHeight`  L45
- `int mParentWidth`  L46
- `RelativeLayout.LayoutParams mlp`  L47
- `int offset`  L48
- `OnCreateListener onCreateListener`  L49
- `int oriBottom`  L50
- `int oriLeft`  L51
- `int oriRight`  L52
- `int oriTop`  L53
- `List<float[]> paints`  L54
- `float upX`  L55
- `float upY`  L56
- `float v_height`  L57
- `float v_width`  L58
- `float f = this.mParentWidth`  L109
- `float f2 = this.mParentHeight`  L110
- `int i = -1`  L115
- `int i = -1`  L131
- `int i = -1`  L147
- `int i = -1`  L163
- `float f3 = fArr[0]`  L184
- `float f4 = fArr[1]`  L185
- `DragPolygonView dragPolygonView = DragPolygonView.this`  L199
- `float f3 = fArr[0]`  L230
- `float f4 = f + f3`  L231
- `float f5 = fArr[1]`  L232
- `float f6 = f2 + f5`  L233
- `float f7 = left + f4`  L234
- `float f8 = top + f6`  L238
- `int i2 = this.offset`  L256
- `int i3 = -i2`  L258
- `int i4 = this.oriRight`  L262
- `int i5 = this.mParentWidth`  L263
- `int i6 = this.offset`  L264
- `int i7 = i5 + i6`  L266
- `int i8 = this.oriTop`  L270
- `int i9 = this.offset`  L271
- `int i10 = -i9`  L273
- `int i11 = this.oriBottom`  L277
- `int i12 = this.mParentHeight`  L278
- `int i13 = this.offset`  L279
- `int i14 = i12 + i13`  L281
- `int i15 = this.oriRight - this.oriLeft`  L285
- `int i16 = this.oriBottom - this.oriTop`  L286
- `float f = this.downX`  L299
- `float f2 = this.downY`  L300
- `OnCreateListener onCreateListener = this.onCreateListener`  L312
- `float f = this.mParentWidth`  L371
- `float f2 = this.mParentHeight`  L372
- `float f = this.event_x`  L491
- `int i = this.dragDirection`  L502
- `int i2 = this.dragPointIndex`  L504

方法（29）：
- `public DragPolygonView(Context context)`  L60
- `public DragPolygonView(Context context, AttributeSet attributeSet)`  L64
- `public DragPolygonView(Context context, AttributeSet attributeSet, int i)`  L68
- `void convertAbsoluteLocation()`  L81
- `void drawText(Canvas canvas)`  L92
    - 体内字面量："è¯·ç¹å»å±å¹ç»å¶å¤è¾¹å½¢,ç¹å»ç¬¬ä¸ä¸ªç¹å®æé­å"
- `Bitmap getBitmap()`  L103
- `int getFarBottomIndex()`  L114
- `int getFarLeftIndex()`  L130
- `int getFarRightIndex()`  L146
- `int getFarTopIndex()`  L162
- `int getPointIndex(float f, float f2)`  L178
- `void init()`  L193
- `void onGlobalLayout()`  L198 @Override
- `void move(float f, float f2)`  L212
- `void movePaint(int i, float f, float f2)`  L219
- `void moveView(float f, float f2)`  L245
- `void onSingleClick()`  L295
- `void resetViewLayout()`  L320
    - 体内字面量："resetViewLayout leftIndex:" · " rightIndex:" · " topIndex:" · " bottomIndex:" · "resetViewLayout left:" · " top:" · " right:" · " bottom:"
- `void cleanParams(RelativeLayout.LayoutParams layoutParams)`  L349
- `int getDirection(float f, float f2)`  L358
- `Area getPercentLocation()`  L363 @Override
    - 体内字面量："getPercentLocation mParentWidth:" · " mParentHeight:"
- `void onDraw(Canvas canvas)`  L397 @Override
- `void onLayout(boolean z, int i, int i2, int i3, int i4)`  L450 @Override
- `void onMeasure(int i, int i2)`  L455 @Override
- `void onSizeChanged(int i, int i2, int i3, int i4)`  L460 @Override
    - 体内字面量："onSizeChanged w:" · " h:" · " oldw:" · " oldh:"
- `boolean onTouch(View view, MotionEvent motionEvent)`  L468 @Override
    - 体内字面量："ACTION_DOWN evX:" · " evY:" · "ACTION_UP evX:" · " evY:"
- `void resize(List<float[]> list)`  L520 @Override
- `void setOnCreateListener(OnCreateListener onCreateListener)`  L526
- `void setPaints(List<float[]> list)`  L531 @Override
### `com.icatchtek.basecomponent.customcomponent.zones.DragRectView`
L26 · [class] public DragRectView · extends `DragView implements View.OnTouchListener` · implements `View.OnTouchListener` · `com/icatchtek/basecomponent/customcomponent/zones/DragRectView.java`

字段/常量（98）：
- `int BOTTOM = 35`  L27
- `int CENTER = 37`  L28
- `int LEFT = 34`  L29
- `int LEFT_BOTTOM = 25`  L30
- `int LEFT_TOP = 23`  L31
- `int RIGHT = 36`  L32
- `int RIGHT_BOTTOM = 32`  L33
- `int RIGHT_TOP = 24`  L34
- `String TAG = "DragRectView"`  L35
- `int TOP = 33`  L36
- `int MIN_SIZE`  L37
- `int downx`  L38
- `int downy`  L39
- `int dragDirection`  L40
- `int endh`  L41
- `int endw`  L42
- `Paint fillPaint`  L43
- `int height`  L44
- `int lastX`  L45
- `int lastY`  L46
- `Rect mBottomRect`  L47
- `Bitmap mLeftBottomBmp`  L48
- `Rect mLeftBottomRect`  L49
- `Rect mLeftRect`  L50
- `Bitmap mLeftRightBmp`  L51
- `Bitmap mLeftTopBmp`  L52
- `Rect mLeftTopRect`  L53
- `int mLineSize`  L54
- `Paint mMosaicPaint`  L55
- `Paint mPaint`  L56
- `int mParentHeight`  L57
- `int mParentWidth`  L58
- `Rect mRect`  L59
- `int mRectSize`  L60
- `Bitmap mRightBottomBmp`  L61
- `Rect mRightBottomRect`  L62
- `Rect mRightRect`  L63
- `Bitmap mRightTopBmp`  L64
- `Rect mRightTopRect`  L65
- `Paint.Style mStyle`  L66
- `Bitmap mTopBottomBmp`  L67
- `Rect mTopRect`  L68
- `RelativeLayout.LayoutParams mlp`  L69
- `int offset`  L70
- `int oriBottom`  L71
- `int oriLeft`  L72
- `int oriRight`  L73
- `int oriTop`  L74
- `int starh`  L75
- `int starw`  L76
- `int touchScope`  L77
- `int width`  L78
- `int i2 = this.height + i`  L114
- `int i3 = this.height`  L119
- `int i4 = this.MIN_SIZE`  L120
- `int i3 = this.mParentWidth`  L135
- `int i4 = this.mParentHeight`  L143
- `float f = this.mParentWidth`  L162
- `float f2 = this.mParentHeight`  L163
- `int i3 = this.touchScope`  L172
- `int i2 = this.width`  L205
- `int i3 = this.dragDirection`  L223
- `DragRectView dragRectView = DragRectView.this`  L288
- `DragRectView dragRectView2 = DragRectView.this`  L290
- `DragRectView dragRectView3 = DragRectView.this`  L293
- `DragRectView dragRectView4 = DragRectView.this`  L295
- `DragRectView dragRectView5 = DragRectView.this`  L298
- `int left`  L323
- `int i2 = this.width`  L332
- `int i3 = this.MIN_SIZE`  L333
- `int top`  L346
- `int left`  L347
- `int i3 = this.height - i2`  L356
- `int i4 = this.height`  L361
- `int i5 = this.MIN_SIZE`  L362
- `int i6 = this.width`  L372
- `int i7 = this.MIN_SIZE`  L373
- `int i2 = this.width + i`  L398
- `int i3 = this.width`  L403
- `int i4 = this.MIN_SIZE`  L404
- `int top`  L411
- `int i2 = this.height`  L419
- `int i3 = this.MIN_SIZE`  L420
- `float f = this.mParentWidth`  L482
- `float f2 = this.mParentHeight`  L483
- `Rect rect = this.mRect`  L526
- `int i = this.offset`  L527
- `int i2 = this.offset`  L532
- `Rect rect2 = this.mLeftTopRect`  L548
- `int i3 = this.offset`  L549
- `int i4 = this.mRectSize`  L550
- `Rect rect3 = this.mRightTopRect`  L553
- `int i5 = this.offset`  L555
- `int i6 = this.offset`  L557
- `Rect rect4 = this.mLeftBottomRect`  L560
- `int i7 = this.offset`  L561
- `int i8 = this.mRectSize`  L563
- `int i9 = this.offset`  L564

方法（33）：
- `public DragRectView(Context context)`  L80
- `public DragRectView(Context context, AttributeSet attributeSet)`  L84
- `public DragRectView(Context context, AttributeSet attributeSet, int i)`  L88
- `Bitmap adjustPhotoRotation(Bitmap bitmap, int i)`  L101
- `void bottom(View view, int i)`  L111
- `void center(View view, int i, int i2)`  L126
- `void drawMosaicPath(Canvas canvas)`  L152
- `Bitmap getBitmap()`  L156
- `int getDirection(View view, int i, int i2)`  L167
- `void handleDrag(View view, MotionEvent motionEvent, int i)`  L198
- `void handleSizeChanged(View view)`  L264
    - 体内字面量："...handleSizeChanged ..."
- `void init()`  L275
- `void onGlobalLayout()`  L287 @Override
- `void left(View view, int i)`  L322
- `void leftTop(View view, int i, int i2)`  L345
- `void move(View view)`  L385
    - 体内字面量："...move ..."
- `void right(View view, int i)`  L394
    - 体内字面量："...right ..."
- `void top(View view, int i)`  L410
- `void cleanParams(RelativeLayout.LayoutParams layoutParams)`  L433
- `int[] getLeftBottomLocation()`  L442
    - 体内字面量："getLeftBottomLocation: " · " "
- `int[] getLeftTopLocation()`  L449
    - 体内字面量："getLeftTopLocation: " · " "
- `String getLocation()`  L456
    - 体内字面量："tag:" · "left:" · " right:" · " top:" · " bottom:" · " width:" · " height:"
- `Area getPercentLocation()`  L474 @Override
    - 体内字面量："getPercentLocation mParentWidth:" · " mParentHeight:"
- `int[] getRightBottomLocation()`  L499
    - 体内字面量："getRightBottomLocation: " · " "
- `int[] getRightTopLocation()`  L506
    - 体内字面量："getRightTopLocation: " · " "
- `void onDraw(Canvas canvas)`  L514 @Override
- `void onSizeChanged(int i, int i2, int i3, int i4)`  L573 @Override
    - 体内字面量："getDirection w:" · " h:" · " oldw:" · " oldh:"
- `boolean onTouch(View view, MotionEvent motionEvent)`  L579 @Override
    - 体内字面量："getDirection :"
- `void resize(int i, int i2, int i3, int i4)`  L604
- `void resize(List<float[]> list)`  L614 @Override
- `void setHeights(float f)`  L618
- `void setPaints(List<float[]> list)`  L623 @Override
- `void setWidths(float f)`  L631
### `com.icatchtek.basecomponent.customcomponent.zones.DragView`
L9 · [class] public abstract DragView · extends `View` · `com/icatchtek/basecomponent/customcomponent/zones/DragView.java`

字段/常量（1）：
- `OnMyTouchListener myTouchListener`  L10

方法（7）：
- `public DragView(Context context)`  L12
- `public DragView(Context context, AttributeSet attributeSet)`  L16
- `public DragView(Context context, AttributeSet attributeSet, int i)`  L20
- `Area getPercentLocation()`  L24
- `void resize(List<float[]> list)`  L26
- `void setMyTouchListener(OnMyTouchListener onMyTouchListener)`  L28
- `void setPaints(List<float[]> list)`  L32
### `com.icatchtek.basecomponent.customcomponent.zones.LocationConverter`
L8 · [class] public LocationConverter · `com/icatchtek/basecomponent/customcomponent/zones/LocationConverter.java`

字段/常量（1）：
- `int offset`  L9

方法（2）：
- `List<float[]> converPolygonLocation(int i, int i2, List<PercentLocation> list)`  L11
- `int[] converRectangularLocation(View view, List<PercentLocation> list)`  L19
### `com.icatchtek.basecomponent.customcomponent.zones.OnCreateListener`
L4 · [interface] public OnCreateListener · `com/icatchtek/basecomponent/customcomponent/zones/OnCreateListener.java`

方法（1）：
- `void onComplete()`  L5
### `com.icatchtek.basecomponent.customcomponent.zones.OnMyTouchListener`
L6 · [interface] public OnMyTouchListener · `com/icatchtek/basecomponent/customcomponent/zones/OnMyTouchListener.java`

方法（1）：
- `void onClick(View view)`  L7
### `com.icatchtek.basecomponent.customcomponent.zones.OnSelectListener`
L6 · [interface] public OnSelectListener · `com/icatchtek/basecomponent/customcomponent/zones/OnSelectListener.java`

方法（1）：
- `void onSelect(View view)`  L7
### `com.icatchtek.basecomponent.customcomponent.zones.PercentLocation`
L4 · [class] public PercentLocation · `com/icatchtek/basecomponent/customcomponent/zones/PercentLocation.java`

字段/常量（2）：
- `float x`  L5
- `float y`  L6

方法（6）：
- `public PercentLocation(float f, float f2)`  L8
- `float getX()`  L13
- `float getY()`  L17
- `void setX(float f)`  L21
- `void setY(float f)`  L25
- `String toString()`  L29
    - 体内字面量："PercentLocation{x=" · ", y=" · "}"
### `com.icatchtek.basecomponent.customcomponent.zones.PrivacyZonesView`
L19 · [class] public PrivacyZonesView · extends `RelativeLayout` · `com/icatchtek/basecomponent/customcomponent/zones/PrivacyZonesView.java`

字段/常量（22）：
- `String TAG = "PrivacyZonesView"`  L20
- `Bitmap bitmap`  L21
- `Context context`  L22
- `RelativeLayout drawLayout`  L23
- `Button fullBtn`  L24
- `ImageView imageView`  L25
- `int imgHeight`  L26
- `int imgWidth`  L27
- `boolean isFull`  L28
- `View.OnClickListener layoutClickListener`  L29
- `OnSelectListener onSelectListener`  L30
- `int screenHeigth`  L31
- `int screenWidth`  L32
- `DragView selectView`  L33
- `List<Area> tempList`  L34
- `List<DragView> viewList`  L35
- `OnSelectListener onSelectListener = this.onSelectListener`  L143
- `OnSelectListener onSelectListener = this.onSelectListener`  L155
- `List<DragView> list = this.viewList`  L162
- `OnSelectListener onSelectListener = this.onSelectListener`  L172
- `DragView next`  L218
- `OnSelectListener onSelectListener = this.onSelectListener`  L233

方法（25）：
- `public PrivacyZonesView(Context context)`  L37
- `public PrivacyZonesView(Context context, AttributeSet attributeSet)`  L41
- `public PrivacyZonesView(Context context, AttributeSet attributeSet, int i)`  L45
- `void createPolygonView(Area area)`  L54
- `void onClick(View view)`  L67 @Override
- `void createRectView(Area area)`  L73
- `void onClick(View view)`  L84 @Override
- `void initView(Context context)`  L90
- `void onClick(View view)`  L96 @Override
- `void saveTempLocation()`  L104
- `void setDrawLayoutParams(int i, int i2, int i3, int i4)`  L113
    - 体内字面量："setDrawLayoutParams width=" · " height="
- `void setSelectView(int i)`  L133
- `void clearSelectView()`  L149
- `void clearView()`  L161
- `void createPolygonView(OnCreateListener onCreateListener)`  L178
- `void onClick(View view)`  L190 @Override
- `void createRectView()`  L196
- `void onClick(View view)`  L211 @Override
- `void deleteView(DragView dragView)`  L217
- `List<Area> getLocations()`  L239
- `DragView getSelectView()`  L251
- `void loadHistorical(List<Area> list)`  L255
- `void setImage(Bitmap bitmap)`  L268
- `void setLayoutClickListener(View.OnClickListener onClickListener)`  L278
- `void setOnSelectListener(OnSelectListener onSelectListener)`  L282