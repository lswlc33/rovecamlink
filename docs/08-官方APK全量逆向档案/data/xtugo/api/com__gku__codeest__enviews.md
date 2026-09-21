# XTU GO — 类与成员明细：com.gku.codeest.enviews

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.codeest.enviews.ENDownloadView`
L20 · [class] public ENDownloadView · extends `View` · `com/gku/codeest/enviews/ENDownloadView.java`

字段/常量（114）：
- `int DEFAULT_BG_LINE_COLOR = -12959931`  L21
- `int DEFAULT_BG_LINE_WIDTH = 9`  L22
- `int DEFAULT_DOWNLOAD_TIME = 2000`  L23
- `DownloadUnit DEFAULT_DOWNLOAD_UNIT = DownloadUnit.B`  L24
- `int DEFAULT_LINE_COLOR = -1`  L25
- `int DEFAULT_LINE_WIDTH = 9`  L26
- `int DEFAULT_RIPPLE_SPEED = 2`  L27
- `int DEFAULT_STATE = 0`  L28
- `int DEFAULT_TEXT_COLOR = -1`  L29
- `int DEFAULT_TEXT_SIZE = 14`  L30
- `int STATE_DOWNLOADING = 1`  L31
- `int STATE_END = 2`  L32
- `int STATE_PRE = 0`  L33
- `int STATE_RESET = 3`  L34
- `float mBaseLength`  L35
- `float mBaseRippleLength`  L36
- `Paint mBgPaint`  L37
- `float mCenterX`  L38
- `float mCenterY`  L39
- `float mCircleRadius`  L40
- `RectF mClipRectF`  L41
- `float mCurrentRippleX`  L42
- `double mCurrentSize`  L43
- `int mCurrentState`  L44
- `int mDownloadTime`  L45
- `float mFraction`  L46
- `float mHeight`  L47
- `Paint mPaint`  L48
- `Path mPath`  L49
- `RectF mRectF`  L50
- `Paint mTextPaint`  L51
- `int mTextSize`  L52
- `double mTotalSize`  L53
- `DownloadUnit mUnit`  L54
- `ValueAnimator mValueAnimator`  L55
- `float mWidth`  L56
- `OnDownloadStateListener onDownloadStateListener`  L57
- `float f = i`  L114
- `float f2 = i2`  L116
- `float f3 = f / 2.0f`  L118
- `float f5 = f4 / 3.0f`  L123
- `float f7 = this.mCenterX`  L128
- `float f8 = this.mCircleRadius`  L129
- `float f9 = this.mCenterY`  L130
- `float f10 = this.mCenterX`  L132
- `float f11 = this.mBaseRippleLength`  L133
- `int i = this.mCurrentState`  L140
- `float f = this.mFraction`  L142
- `float f2 = this.mCenterX`  L145
- `float f3 = this.mBaseLength`  L146
- `float f4 = this.mCenterY`  L147
- `float f5 = this.mCenterX`  L149
- `float f6 = this.mCenterY`  L150
- `float f7 = this.mBaseLength`  L151
- `float f8 = this.mCenterX`  L153
- `float f9 = this.mCenterY`  L154
- `float f10 = this.mBaseLength`  L155
- `float f11 = this.mFraction`  L156
- `float f12 = this.mCenterX`  L163
- `float f13 = this.mBaseLength`  L164
- `float f14 = this.mFraction`  L165
- `float f15 = this.mCenterY`  L166
- `float f16 = this.mCenterX`  L168
- `float f17 = this.mCenterY`  L169
- `float f18 = this.mBaseLength`  L170
- `float f19 = this.mFraction`  L171
- `float f20 = this.mCenterX`  L177
- `float f21 = this.mCenterY`  L178
- `float f22 = this.mBaseLength`  L179
- `float f23 = this.mCenterX`  L181
- `float f24 = this.mBaseLength`  L182
- `float f26 = this.mCenterY`  L184
- `float f27 = this.mCenterX`  L190
- `float f28 = this.mBaseLength`  L191
- `float f30 = this.mCenterY`  L193
- `float f31 = this.mFraction`  L198
- `float f32 = this.mCurrentRippleX + 2.0f`  L205
- `float f33 = this.mCenterX`  L207
- `float f34 = this.mBaseRippleLength`  L208
- `Path path = this.mPath`  L214
- `float f35 = this.mBaseRippleLength`  L215
- `Path path2 = this.mPath`  L217
- `float f36 = this.mBaseRippleLength`  L218
- `DownloadUnit downloadUnit = DownloadUnit.NONE`  L225
- `float f37 = this.mCenterX`  L233
- `float f38 = this.mBaseLength`  L234
- `float f39 = f37 - f38`  L235
- `float f40 = this.mCenterY`  L236
- `float f41 = this.mFraction`  L237
- `float f42 = this.mCenterX`  L239
- `float f43 = this.mBaseLength`  L240
- `float f44 = this.mFraction`  L241
- `float f45 = this.mCenterY`  L242
- `float f46 = this.mCenterX`  L244
- `float f47 = this.mBaseLength`  L245
- `float f48 = this.mFraction`  L246
- `float f49 = this.mCenterY`  L247
- `float f50 = this.mFraction`  L252
- `Paint paint = this.mTextPaint`  L254
- `int i3 = this.mTextSize`  L255
- `float f51 = this.mCenterX`  L263
- `float f52 = this.mBaseLength`  L264
- `float f53 = this.mFraction`  L265
- `float f55 = this.mCenterY`  L267
- `float f56 = this.mCenterX`  L269
- `float f57 = this.mBaseLength`  L270
- `float f58 = this.mCenterY`  L271
- `float f59 = this.mFraction`  L272
- `ValueAnimator valueAnimator = this.mValueAnimator`  L277
- `ValueAnimator valueAnimator = this.mValueAnimator`  L289
- `ValueAnimator valueAnimator = this.mValueAnimator`  L322
- `ENDownloadView eNDownloadView = ENDownloadView.this`  L343
- `ValueAnimator valueAnimator = this.mValueAnimator`  L360
- `ValueAnimator valueAnimator = this.mValueAnimator`  L396

方法（19）：
- `public ENDownloadView(Context context)`  L73
- `public ENDownloadView(Context context, AttributeSet attributeSet)`  L77
- `void onSizeChanged(int i, int i2, int i3, int i4)`  L112 @Override
- `void onDraw(Canvas canvas)`  L138 @Override
- `void release()`  L276
- `void start()`  L288
- `void onAnimationUpdate(ValueAnimator valueAnimator2)`  L305 @Override
- `void onAnimationEnd(Animator animator)`  L312 @Override
- `void downloadAnim()`  L321
- `void onAnimationUpdate(ValueAnimator valueAnimator2)`  L340 @Override
- `void onAnimationEnd(Animator animator)`  L351 @Override
- `void endAnim()`  L359
- `void onAnimationUpdate(ValueAnimator valueAnimator2)`  L375 @Override
- `void onAnimationEnd(Animator animator)`  L382 @Override
- `void reset()`  L393
- `String getUnitStr(DownloadUnit downloadUnit)`  L433
    - 体内字面量：" gb" · " mb" · " kb" · " b"
- `void setDownloadConfig(int i, double d, DownloadUnit downloadUnit)`  L447
- `int getCurrentState()`  L453
- `void setOnDownloadStateListener(OnDownloadStateListener onDownloadStateListener)`  L457
### `com.gku.codeest.enviews.ENDownloadView$AnonymousClass7`
L408 · [class] static AnonymousClass7 · `com/gku/codeest/enviews/ENDownloadView.java`

字段/常量（1）：
- `int[] $SwitchMap$com$gku$codeest$enviews$ENDownloadView$DownloadUnit`  L409
### `com.gku.codeest.enviews.ENDownloadView$DownloadUnit`
L59 · [enum] public DownloadUnit · `com/gku/codeest/enviews/ENDownloadView.java`

枚举常量（4）：
- `GB()`  L60
- `MB()`  L61
- `KB()`  L62
- `B()`  L63
### `com.gku.codeest.enviews.ENDownloadView$OnDownloadStateListener`
L67 · [interface] OnDownloadStateListener · `com/gku/codeest/enviews/ENDownloadView.java`

方法（2）：
- `void onDownloadFinish()`  L68
- `void onResetFinish()`  L70
### `com.gku.codeest.enviews.ENPlayView`
L19 · [class] public ENPlayView · extends `View` · `com/gku/codeest/enviews/ENPlayView.java`

字段/常量（65）：
- `int DEFAULT_BG_LINE_COLOR = -328966`  L20
- `int DEFAULT_BG_LINE_WIDTH = 4`  L21
- `int DEFAULT_DURATION = 1200`  L22
- `int DEFAULT_LINE_COLOR = -1`  L23
- `int DEFAULT_LINE_WIDTH = 4`  L24
- `int STATE_PAUSE = 1`  L25
- `int STATE_PLAY`  L26
- `Paint mBgPaint`  L27
- `RectF mBgRectF`  L28
- `int mCenterX`  L29
- `int mCenterY`  L30
- `int mCircleRadius`  L31
- `int mCurrentState`  L32
- `Path mDstPath`  L33
- `int mDuration`  L34
- `float mFraction`  L35
- `int mHeight`  L36
- `Paint mPaint`  L37
- `Path mPath`  L38
- `float mPathLength`  L39
- `PathMeasure mPathMeasure`  L40
- `RectF mRectF`  L41
- `int mWidth`  L42
- `int i6 = this.mCenterX`  L89
- `int i7 = this.mCircleRadius`  L90
- `int i8 = this.mCenterY`  L91
- `int i9 = this.mCenterX`  L93
- `int i10 = this.mWidth`  L94
- `int i11 = this.mCenterY`  L95
- `int i12 = this.mHeight`  L96
- `Path path = this.mPath`  L98
- `int i13 = this.mCenterX`  L99
- `int i14 = this.mCircleRadius`  L100
- `Path path2 = this.mPath`  L102
- `int i15 = this.mCenterX`  L103
- `int i16 = this.mCircleRadius`  L104
- `float f = this.mFraction`  L116
- `int i = this.mCenterX`  L118
- `int i2 = this.mCircleRadius`  L119
- `int i3 = this.mCenterY`  L120
- `int i4 = this.mCenterX`  L122
- `int i5 = this.mCircleRadius`  L123
- `int i6 = this.mCenterY`  L124
- `int i7 = this.mCenterX`  L130
- `int i8 = this.mCircleRadius`  L131
- `int i9 = this.mCenterY`  L132
- `int i10 = this.mCenterX`  L134
- `int i11 = this.mCircleRadius`  L135
- `int i12 = this.mCenterY`  L136
- `float f2 = this.mFraction`  L138
- `RectF rectF = this.mBgRectF`  L142
- `float f3 = this.mFraction`  L143
- `PathMeasure pathMeasure = this.mPathMeasure`  L150
- `float f4 = this.mPathLength`  L151
- `RectF rectF2 = this.mBgRectF`  L154
- `float f5 = this.mFraction`  L155
- `PathMeasure pathMeasure2 = this.mPathMeasure`  L161
- `float f6 = this.mPathLength`  L162
- `float f7 = this.mFraction`  L163
- `RectF rectF3 = this.mBgRectF`  L166
- `float f8 = this.mFraction`  L167
- `int i = this.mCurrentState`  L177
- `int i2 = STATE_PLAY`  L178
- `int i = this.mCurrentState`  L200
- `int i2 = STATE_PAUSE`  L201

方法（11）：
- `public ENPlayView(Context context)`  L44
- `public ENPlayView(Context context, AttributeSet attributeSet)`  L50
- `void onSizeChanged(int i, int i2, int i3, int i4)`  L81 @Override
- `void onDraw(Canvas canvas)`  L113 @Override
- `void play()`  L176
- `void onAnimationUpdate(ValueAnimator valueAnimator)`  L188 @Override
- `void pause()`  L199
- `void onAnimationUpdate(ValueAnimator valueAnimator)`  L211 @Override
- `int getCurrentState()`  L222
- `void setDuration(int i)`  L226
- `int dp2px(int i)`  L230