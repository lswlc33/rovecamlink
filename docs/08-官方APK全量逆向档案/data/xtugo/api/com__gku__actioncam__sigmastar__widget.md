# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.widget

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 26 个文件 / 53 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.widget.adapter.SSModeSelectPopupListAdapter`
L18 · [class] public SSModeSelectPopupListAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/widget/adapter/SSModeSelectPopupListAdapter.java`

字段/常量（6）：
- `String currentMode`  L19
- `Context mContext`  L20
- `OnModeItemClickListener onModeItemClickListener`  L21
- `ArrayList<String> type_mode_list`  L22
- `OnModeItemClickListener onModeItemClickListener = this.onModeItemClickListener`  L77
- `ArrayList<String> arrayList = this.type_mode_list`  L85

方法（9）：
- `void setOnModeItemClickListener(OnModeItemClickListener onModeItemClickListener)`  L28
- `void setCurrentMode(String currentMode)`  L32
- `public SSModeSelectPopupListAdapter(Context context, String currentMode, ArrayList<String> type_mode_list)`  L37
- `void updateModeType(ArrayList<String> type_mode_list)`  L43
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L49 @Override
- `void onBindViewHolder(ViewHolder holder, final int position)`  L54 @Override
- `void onClick(View view)`  L69 @Override
- `void lambda$onBindViewHolder$0(int i, View view)`  L76
- `int getItemCount()`  L84 @Override
### `com.gku.actioncam.sigmastar.widget.adapter.SSModeSelectPopupListAdapter$OnModeItemClickListener`
L24 · [interface] public OnModeItemClickListener · `com/gku/actioncam/sigmastar/widget/adapter/SSModeSelectPopupListAdapter.java`

方法（1）：
- `void onModeItemClick(String mode)`  L25
### `com.gku.actioncam.sigmastar.widget.adapter.SSModeSelectPopupListAdapter$ViewHolder`
L92 · [class] public ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/widget/adapter/SSModeSelectPopupListAdapter.java`

字段/常量（4）：
- `LinearLayout itemLayout`  L93
- `ImageView layout_ss_select_popup_list_item_icon`  L94
- `ImageView layout_ss_select_popup_list_item_selected`  L95
- `TextView layout_ss_select_popup_list_item_text`  L96

方法（1）：
- `public ViewHolder(View itemView)`  L98
### `com.gku.actioncam.sigmastar.widget.controller.SSMediaController`
L26 · [class] public SSMediaController · extends `FrameLayout` · `com/gku/actioncam/sigmastar/widget/controller/SSMediaController.java`

字段/常量（50）：
- `int FADE_OUT = 1`  L27
- `int SHOW_PROGRESS = 2`  L28
- `String TAG = "SSMediaController"`  L29
- `int sDefaultTimeout = 3000`  L30
- `Runnable lastRunnable`  L31
- `AudioManager mAM`  L32
- `View mAnchor`  L33
- `int mAnimStyle`  L34
- `Context mContext`  L35
- `TextView mCurrentTime`  L36
- `boolean mDragging`  L37
- `long mDuration`  L38
- `TextView mEndTime`  L39
- `TextView mFileName`  L40
- `boolean mFromXml`  L41
- `Handler mHandler`  L42
- `OnHiddenListener mHiddenListener`  L43
- `OutlineTextView mInfoView`  L44
- `boolean mInstantSeeking`  L45
- `ImageButton mPauseButton`  L46
- `View.OnClickListener mPauseListener`  L47
- `MediaPlayerControl mPlayer`  L48
- `ProgressBar mProgress`  L49
- `View mRoot`  L50
- `SeekBar.OnSeekBarChangeListener mSeekListener`  L51
- `boolean mShowing`  L52
- `OnShownListener mShownListener`  L53
- `String mTitle`  L54
- `PopupWindow mWindow`  L55
- `int i = msg.what`  L94
- `int i = msg.what`  L184
- `View view = this.mRoot`  L277
- `TextView textView = this.mFileName`  L349
- `View view`  L374
- `ImageButton imageButton = this.mPauseButton`  L377
- `int[] iArr = new int[2]`  L385
- `int i = iArr[0]`  L387
- `OnShownListener onShownListener = this.mShownListener`  L393
- `Handler handler = this.mHandler`  L402
- `OnHiddenListener onHiddenListener = this.mHiddenListener`  L425
- `MediaPlayerControl mediaPlayerControl = this.mPlayer`  L442
- `ProgressBar progressBar = this.mProgress`  L448
- `long j = duration`  L455
- `TextView textView = this.mEndTime`  L457
- `TextView textView2 = this.mCurrentTime`  L461
- `int i2 = i % 60`  L471
- `int i4 = i / 3600`  L473
- `ImageButton imageButton = this.mPauseButton`  L498
- `ImageButton imageButton = this.mPauseButton`  L543
- `ProgressBar progressBar = this.mProgress`  L547

方法（40）：
- `public SSMediaController(Context context, AttributeSet attrs)`  L87
- `void handleMessage(Message msg)`  L93 @Override
- `void onClick(View v)`  L112 @Override
- `void onStartTrackingTouch(SeekBar bar)`  L119 @Override
- `void onProgressChanged(SeekBar bar, int progress, boolean fromuser)`  L133 @Override
- `void run()`  L141 @Override
- `void onStopTrackingTouch(SeekBar bar)`  L157 @Override
- `public SSMediaController(Context context)`  L177
- `void handleMessage(Message msg)`  L183 @Override
- `void onClick(View v)`  L202 @Override
- `void onStartTrackingTouch(SeekBar bar)`  L209 @Override
- `void onProgressChanged(SeekBar bar, int progress, boolean fromuser)`  L223 @Override
- `void run()`  L231 @Override
- `void onStopTrackingTouch(SeekBar bar)`  L247 @Override
- `boolean initController(Context context)`  L268
    - 体内字面量："audio"
- `void onFinishInflate()`  L275 @Override
- `void initFloatingWindow()`  L283
- `void setAnchorView(View view)`  L292
- `View makeControllerView()`  L305
    - 体内字面量："layout_inflater"
- `void initControllerView(View v)`  L309
- `void setMediaPlayer(MediaPlayerControl player)`  L334
- `void setInstantSeeking(boolean seekWhenDragging)`  L339
- `void show()`  L343
- `void setFileName(String name)`  L347
- `void setInfoView(OutlineTextView v)`  L355
- `void disableUnsupportedButtons()`  L359
- `void setAnimationStyle(int animationStyle)`  L369
- `void show(int timeout)`  L373
- `boolean isShowing()`  L407
- `void hide()`  L411
    - 体内字面量："MediaController already removed"
- `void setOnShownListener(OnShownListener l)`  L432
- `void setOnHiddenListener(OnHiddenListener l)`  L436
- `long setProgress()`  L441
- `String generateTime(long position)`  L469
- `boolean onTouchEvent(MotionEvent event)`  L481 @Override
- `boolean onTrackballEvent(MotionEvent ev)`  L487 @Override
- `boolean dispatchKeyEvent(KeyEvent event)`  L493 @Override
- `void updatePausePlay()`  L520
- `void doPauseResume()`  L532
- `void setEnabled(boolean enabled)`  L542 @Override
### `com.gku.actioncam.sigmastar.widget.controller.SSMediaController$MediaPlayerControl`
L57 · [interface] public MediaPlayerControl · `com/gku/actioncam/sigmastar/widget/controller/SSMediaController.java`

方法（10）：
- `boolean canPause()`  L58
- `boolean canSeekBackward()`  L60
- `boolean canSeekForward()`  L62
- `int getBufferPercentage()`  L64
- `int getCurrentPosition()`  L66
- `int getDuration()`  L68
- `boolean isPlaying()`  L70
- `void pause()`  L72
- `void seekTo(long pos)`  L74
- `void start()`  L76
### `com.gku.actioncam.sigmastar.widget.controller.SSMediaController$OnHiddenListener`
L79 · [interface] public OnHiddenListener · `com/gku/actioncam/sigmastar/widget/controller/SSMediaController.java`

方法（1）：
- `void onHidden()`  L80
### `com.gku.actioncam.sigmastar.widget.controller.SSMediaController$OnShownListener`
L83 · [interface] public OnShownListener · `com/gku/actioncam/sigmastar/widget/controller/SSMediaController.java`

方法（1）：
- `void onShown()`  L84
### `com.gku.actioncam.sigmastar.widget.controller.SSMediaControllerWrapper`
L9 · [class] public SSMediaControllerWrapper · extends `SSMediaController` · `com/gku/actioncam/sigmastar/widget/controller/SSMediaControllerWrapper.java`

字段/常量（2）：
- `SSPlayerControlView playerControlView`  L10
- `View rootView = view`  L28

方法（13）：
- `public SSMediaControllerWrapper(Context context)`  L12
- `public SSMediaControllerWrapper(SSPlayerControlView playerControlView)`  L16
- `void setMediaPlayer(SSMediaController.MediaPlayerControl player)`  L22 @Override
- `void setAnchorView(View view)`  L27 @Override
- `void show()`  L36 @Override
- `void show(int timeout)`  L41 @Override
- `boolean isShowing()`  L46 @Override
- `void hide()`  L51 @Override
- `boolean onTouchEvent(MotionEvent event)`  L59 @Override
- `boolean onTrackballEvent(MotionEvent ev)`  L64 @Override
- `boolean dispatchTouchEvent(MotionEvent ev)`  L69 @Override
- `void setEnabled(boolean enabled)`  L74 @Override
- `CharSequence getAccessibilityClassName()`  L79 @Override
### `com.gku.actioncam.sigmastar.widget.controller.SSPlayerControlView`
L19 · [class] public SSPlayerControlView · extends `LinearLayout` · `com/gku/actioncam/sigmastar/widget/controller/SSPlayerControlView.java`

字段/常量（22）：
- `boolean alwaysShow`  L20
- `boolean dragging`  L21
- `Runnable hideRunnable`  L22
- `SSMediaController.MediaPlayerControl player`  L23
- `int showTimeoutMs`  L24
- `boolean showing`  L25
- `Runnable updateProgressRunnable`  L26
- `ViewHolder viewHolder`  L27
- `SSPlayerControlView sSPlayerControlView = SSPlayerControlView.this`  L57
- `SSPlayerControlView sSPlayerControlView = SSPlayerControlView.this`  L96
- `SSPlayerControlView sSPlayerControlView2 = SSPlayerControlView.this`  L98
- `SSPlayerControlView sSPlayerControlView = SSPlayerControlView.this`  L106
- `ViewHolder viewHolder = this.viewHolder`  L271
- `SSMediaController.MediaPlayerControl mediaPlayerControl = this.player`  L278
- `SSMediaController.MediaPlayerControl mediaPlayerControl = this.player`  L286
- `String str`  L294
- `int i = timeMs / 1000`  L298
- `int i2 = i / 3600`  L299
- `int i4 = i % 60`  L301
- `String str2 = "<binary/metadata>"`  L302
- `SSMediaController.MediaPlayerControl mediaPlayerControl = this.player`  L319
- `SSMediaController.MediaPlayerControl mediaPlayerControl = this.player`  L332

方法（29）：
- `boolean isShowing()`  L29
- `void hide()`  L33
- `public SSPlayerControlView(Context context)`  L40
- `public SSPlayerControlView(Context context, AttributeSet attrs)`  L44
- `public SSPlayerControlView(Context context, AttributeSet attrs, int defStyleAttr)`  L48
- `void run()`  L52 @Override
- `void run()`  L63 @Override
- `void onClick(View v)`  L76 @Override
- `void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)`  L84 @Override
- `void onStartTrackingTouch(SeekBar seekBar)`  L93 @Override
- `void onStopTrackingTouch(SeekBar seekBar)`  L103 @Override
- `void onClick(View v)`  L112 @Override
- `SSMediaControllerWrapper getSSMediaControlWrapper()`  L117
- `void setPlayer(SSMediaController.MediaPlayerControl player)`  L121
- `void attach(Activity activity)`  L126
- `void attach(ViewGroup rootView)`  L130
- `boolean dispatchKeyEvent(KeyEvent event)`  L142 @Override
- `void onDetachedFromWindow()`  L193 @Override
- `void setEnabled(boolean enabled)`  L200 @Override
- `void show()`  L209
- `void show(int showTimeoutMs)`  L213
- `void updatePausePlayImage()`  L246
- `int updateProgress()`  L254
- `void updateTimeText()`  L270
- `int getCurrentTime()`  L277
- `int getTotalTime()`  L285
- `String formatTime(int timeMs)`  L293
- `void doPauseResume()`  L318
- `void disableUnsupportedButtons()`  L331
### `com.gku.actioncam.sigmastar.widget.controller.SSPlayerControlView$ViewHolder`
L232 · [class] public static final ViewHolder · `com/gku/actioncam/sigmastar/widget/controller/SSPlayerControlView.java`

字段/常量（4）：
- `ImageView video_opera_orientation`  L233
- `ImageView video_opera_play`  L234
- `AppCompatSeekBar video_opera_seek`  L235
- `TextView video_opera_time`  L236

方法（1）：
- `public ViewHolder(View view)`  L238
### `com.gku.actioncam.sigmastar.widget.IconTextView`
L13 · [class] public IconTextView · extends `LinearLayout` · `com/gku/actioncam/sigmastar/widget/IconTextView.java`

字段/常量（2）：
- `ImageView ivIcon`  L14
- `TextView tvText`  L15

方法（3）：
- `public IconTextView(Context context, AttributeSet attrs)`  L17
- `void init(Context context)`  L22
- `void setData(int iconRes, int stringRes)`  L28
### `com.gku.actioncam.sigmastar.widget.MyCircleProgress`
L15 · [class] public MyCircleProgress · extends `View` · `com/gku/actioncam/sigmastar/widget/MyCircleProgress.java`

字段/常量（12）：
- `String TAG = "MyCircleProgress"`  L16
- `float _arcWidth`  L17
- `int _current`  L18
- `int _max`  L19
- `Paint _paint`  L20
- `Rect _rect`  L21
- `RectF _rectF`  L22
- `float _width`  L23
- `float f = this._width / 2.0f`  L67
- `RectF rectF = this._rectF`  L70
- `float f2 = this._arcWidth`  L71
- `float f3 = this._width`  L72

方法（7）：
- `public MyCircleProgress(Context context)`  L25
- `public MyCircleProgress(Context context, AttributeSet attrs)`  L29
- `public MyCircleProgress(Context context, AttributeSet attrs, int defStyleAttr)`  L33
- `void SetCurrent(int _current)`  L45
    - 体内字面量："å½åå¼ï¼" · "ï¼æå¤§å¼ï¼"
- `void SetMax(int _max)`  L51
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L56 @Override
- `void onDraw(Canvas canvas)`  L62 @Override
### `com.gku.actioncam.sigmastar.widget.OutlineTextView`
L15 · [class] public OutlineTextView · extends `AppCompatTextView` · `com/gku/actioncam/sigmastar/widget/OutlineTextView.java`

字段/常量（10）：
- `int mAscent`  L16
- `int mBorderColor`  L17
- `float mBorderSize`  L18
- `int mColor`  L19
- `boolean mIncludePad`  L20
- `float mSpacingAdd`  L21
- `float mSpacingMult`  L22
- `String mText`  L23
- `TextPaint mTextPaint`  L24
- `TextPaint mTextPaintOutline`  L25

方法（14）：
- `public OutlineTextView(Context context)`  L27
- `public OutlineTextView(Context context, AttributeSet attrs)`  L37
- `public OutlineTextView(Context context, AttributeSet attrs, int defStyle)`  L47
- `void initPaint()`  L57
- `void setText(String text)`  L75
- `void setTextSize(float size)`  L83 @Override
- `void setTextColor(int color)`  L91 @Override
- `void setShadowLayer(float radius, float dx, float dy, int color)`  L99 @Override
- `void setTypeface(Typeface tf, int style)`  L109 @Override
- `void setTypeface(Typeface tf)`  L117 @Override
- `void onDraw(Canvas canvas)`  L125 @Override
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L131 @Override
- `int measureWidth(int measureSpec)`  L137
- `int measureHeight(int measureSpec)`  L147
### `com.gku.actioncam.sigmastar.widget.PlaybackImageView`
L8 · [class] public PlaybackImageView · extends `AppCompatImageView` · `com/gku/actioncam/sigmastar/widget/PlaybackImageView.java`

字段/常量（1）：
- `String originalPath`  L9

方法（6）：
- `public PlaybackImageView(Context context)`  L11
- `String getOriginalPath()`  L15
- `void setOriginalPath(String originalPath)`  L19
- `public PlaybackImageView(Context context, AttributeSet attrs)`  L23
- `public PlaybackImageView(Context context, AttributeSet attrs, int defStyleAttr)`  L27
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L32 @Override
### `com.gku.actioncam.sigmastar.widget.RadarView`
L19 · [class] public RadarView · extends `View` · `com/gku/actioncam/sigmastar/widget/RadarView.java`

字段/常量（14）：
- `int SCAN_ANGLE = 60`  L20
- `ValueAnimator animator`  L21
- `float centerX`  L22
- `float centerY`  L23
- `Paint circlePaint`  L24
- `Paint maskPaint`  L25
- `float radius`  L26
- `Paint scanPaint`  L27
- `float sweepAngle`  L28
- `float f = this.centerX`  L101
- `float f2 = this.radius`  L102
- `float f3 = this.centerY`  L103
- `ValueAnimator valueAnimator = this.animator`  L110
- `ValueAnimator valueAnimator = this.animator`  L118

方法（18）：
- `public RadarView(Context context)`  L30
- `public RadarView(Context context, AttributeSet attrs)`  L36
- `void init()`  L42
- `void onAnimationUpdate(ValueAnimator valueAnimator)`  L62 @Override
- `void lambda$init$0(ValueAnimator valueAnimator)`  L69
- `void onAttachedToWindow()`  L75 @Override
- `void onDetachedFromWindow()`  L81 @Override
- `void onSizeChanged(int w, int h, int oldw, int oldh)`  L87 @Override
- `void onDraw(Canvas canvas)`  L95 @Override
- `void startScan()`  L109
- `void stopScan()`  L117
- `void bindLifecycle(LifecycleOwner owner)`  L124
- `void onCreate(LifecycleOwner lifecycleOwner)`  L127 @Override
    - 体内字面量："owner"
- `void onDestroy(LifecycleOwner lifecycleOwner)`  L132 @Override
    - 体内字面量："owner"
- `void onStart(LifecycleOwner lifecycleOwner)`  L137 @Override
    - 体内字面量："owner"
- `void onStop(LifecycleOwner lifecycleOwner)`  L142 @Override
    - 体内字面量："owner"
- `void onResume(LifecycleOwner owner2)`  L147 @Override
- `void onPause(LifecycleOwner owner2)`  L152 @Override
### `com.gku.actioncam.sigmastar.widget.roundview.RoundedImagView`
L14 · [class] public RoundedImagView · extends `AppCompatImageView` · `com/gku/actioncam/sigmastar/widget/roundview/RoundedImagView.java`

字段/常量（5）：
- `float corner`  L15
- `float cornerSize`  L16
- `Paint paint`  L17
- `float f = this.cornerSize`  L63
- `float f = this.cornerSize`  L75

方法（10）：
- `public RoundedImagView(Context context)`  L19
- `public RoundedImagView(Context context, AttributeSet attrs)`  L28
- `public RoundedImagView(Context context, AttributeSet attrs, int defStyleAttr)`  L40
- `void draw(Canvas canvas)`  L50 @Override
- `void drawLeftTop(Canvas canvas)`  L58
- `void drawLeftBottom(Canvas canvas)`  L69
- `void drawRightBottom(Canvas canvas)`  L81
- `void drawRightTop(Canvas canvas)`  L91
- `float getCornerSize()`  L101
- `void setCornerSize(int cornerSize)`  L105
### `com.gku.actioncam.sigmastar.widget.roundview.RoundImageView`
L22 · [class] public RoundImageView · extends `AppCompatImageView` · `com/gku/actioncam/sigmastar/widget/roundview/RoundImageView.java`

字段/常量（37）：
- `int TYPE_CIRCLE = 0`  L23
- `int TYPE_OVAL = 2`  L24
- `int TYPE_ROUND = 1`  L25
- `Paint mBitmapPaint`  L26
- `BitmapShader mBitmapShader`  L27
- `int mBorderColor`  L28
- `Paint mBorderPaint`  L29
- `float mBorderWidth`  L30
- `float mCornerRadius`  L31
- `float mLeftBottomCornerRadius`  L32
- `float mLeftTopCornerRadius`  L33
- `Matrix mMatrix`  L34
- `float mRadius`  L35
- `float mRightBottomCornerRadius`  L36
- `float mRightTopCornerRadius`  L37
- `Path mRoundPath`  L38
- `RectF mRoundRect`  L39
- `int mWidth`  L40
- `int type`  L41
- `int i = this.type`  L92
- `float f = this.mBorderWidth`  L94
- `int i = this.type`  L107
- `float f = this.mRadius`  L114
- `float f2 = this.mBorderWidth`  L115
- `float f3 = this.mRadius`  L117
- `float f4 = this.mBorderWidth`  L118
- `float f = this.mLeftTopCornerRadius`  L129
- `Path path = this.mRoundPath`  L131
- `RectF rectF = this.mRoundRect`  L132
- `float f2 = this.mCornerRadius`  L133
- `Path path2 = this.mRoundPath`  L137
- `RectF rectF2 = this.mRoundRect`  L138
- `float f3 = this.mRightTopCornerRadius`  L139
- `float f4 = this.mRightBottomCornerRadius`  L140
- `float f5 = this.mLeftBottomCornerRadius`  L141
- `int i = this.type`  L152
- `float fMax = 1.0f`  L153

方法（19）：
- `public RoundImageView(Context context)`  L43
- `public RoundImageView(Context context, AttributeSet attrs)`  L47
- `public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr)`  L51
- `void init()`  L66
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L79 @Override
- `void onSizeChanged(int w, int h, int oldw, int oldh)`  L90 @Override
- `void onDraw(Canvas canvas)`  L100 @Override
- `void setRoundPath()`  L127
- `void setUpShader()`  L145
- `Bitmap drawableToBitamp(Drawable drawable)`  L167
- `RoundImageView setType(int imageType)`  L180
- `RoundImageView setCornerRadius(int cornerRadius)`  L191
- `RoundImageView setLeftTopCornerRadius(int cornerRadius)`  L200
- `RoundImageView setRightTopCornerRadius(int cornerRadius)`  L209
- `RoundImageView setLeftBottomCornerRadius(int cornerRadius)`  L218
- `RoundImageView setRightBottomCornerRadius(int cornerRadius)`  L227
- `RoundImageView setBorderWidth(int borderWidth)`  L236
- `RoundImageView setBorderColor(int borderColor)`  L245
- `int dp2px(int dpVal)`  L253
### `com.gku.actioncam.sigmastar.widget.roundview.RoundLinearLayout`
L8 · [class] public RoundLinearLayout · extends `LinearLayout` · `com/gku/actioncam/sigmastar/widget/roundview/RoundLinearLayout.java`

字段/常量（1）：
- `RoundViewDelegate delegate`  L9

方法（6）：
- `public RoundLinearLayout(Context context)`  L11
- `public RoundLinearLayout(Context context, AttributeSet attrs)`  L15
- `RoundViewDelegate getDelegate()`  L20
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L25 @Override
- `void onLayout(boolean changed, int left, int top, int right, int bottom)`  L34 @Override
- `void setRvbackgroundColor(int color)`  L43
### `com.gku.actioncam.sigmastar.widget.roundview.RoundRelativeLayout`
L9 · [class] public RoundRelativeLayout · extends `RelativeLayout` · `com/gku/actioncam/sigmastar/widget/roundview/RoundRelativeLayout.java`

字段/常量（1）：
- `RoundViewDelegate delegate`  L10

方法（5）：
- `public RoundRelativeLayout(Context context)`  L12
- `public RoundRelativeLayout(Context context, AttributeSet attrs)`  L16
- `RoundViewDelegate getDelegate()`  L21
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L26 @Override
- `void onLayout(boolean changed, int left, int top, int right, int bottom)`  L37 @Override
### `com.gku.actioncam.sigmastar.widget.roundview.RoundTextView`
L9 · [class] public RoundTextView · extends `AppCompatTextView` · `com/gku/actioncam/sigmastar/widget/roundview/RoundTextView.java`

字段/常量（1）：
- `RoundViewDelegate delegate`  L10

方法（6）：
- `public RoundTextView(Context context)`  L12
- `public RoundTextView(Context context, AttributeSet attrs)`  L16
- `public RoundTextView(Context context, AttributeSet attrs, int defStyleAttr)`  L20
- `RoundViewDelegate getDelegate()`  L25
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L30 @Override
- `void onLayout(boolean changed, int left, int top, int right, int bottom)`  L40 @Override
### `com.gku.actioncam.sigmastar.widget.roundview.RoundViewDelegate`
L15 · [class] public RoundViewDelegate · `com/gku/actioncam/sigmastar/widget/roundview/RoundViewDelegate.java`

字段/常量（28）：
- `int backgroundColor`  L16
- `int backgroundPressColor`  L17
- `Context context`  L18
- `int cornerRadius`  L19
- `int cornerRadius_BL`  L20
- `int cornerRadius_BR`  L21
- `int cornerRadius_TL`  L22
- `int cornerRadius_TR`  L23
- `boolean isRadiusHalfHeight`  L24
- `boolean isRippleEnable`  L25
- `boolean isWidthHeightEqual`  L26
- `int strokeColor`  L27
- `int strokeDashGap`  L28
- `int strokeDashWidth`  L29
- `int strokePressColor`  L30
- `int strokeWidth`  L31
- `int textPressColor`  L32
- `View view`  L33
- `float[] radiusArr = new float[8]`  L36
- `int i = this.cornerRadius_TL`  L192
- `float[] fArr = this.radiusArr`  L194
- `int i2 = this.cornerRadius_TR`  L197
- `int i3 = this.cornerRadius_BR`  L200
- `int i4 = this.cornerRadius_BL`  L203
- `int i = this.backgroundPressColor`  L221
- `GradientDrawable gradientDrawable = this.gd_background_press`  L223
- `int i2 = this.strokePressColor`  L227
- `View view = this.view`  L236

方法（33）：
- `public RoundViewDelegate(View view, Context context, AttributeSet attrs)`  L38
- `void obtainAttributes(Context context, AttributeSet attrs)`  L44
- `void setBackgroundColor(int backgroundColor)`  L65
- `void setBackgroundPressColor(int backgroundPressColor)`  L70
- `void setCornerRadius(int cornerRadius)`  L75
- `void setStrokeWidth(float strokeWidth)`  L80
- `void setStrokeColor(int strokeColor)`  L85
- `void setStrokePressColor(int strokePressColor)`  L90
- `void setTextPressColor(int textPressColor)`  L95
- `void setIsRadiusHalfHeight(boolean isRadiusHalfHeight)`  L100
- `void setIsWidthHeightEqual(boolean isWidthHeightEqual)`  L105
- `void setCornerRadius_TL(int cornerRadius_TL)`  L110
- `void setCornerRadius_TR(int cornerRadius_TR)`  L115
- `void setCornerRadius_BL(int cornerRadius_BL)`  L120
- `void setCornerRadius_BR(int cornerRadius_BR)`  L125
- `int getBackgroundColor()`  L130
- `int getBackgroundPressColor()`  L134
- `int getCornerRadius()`  L138
- `int getStrokeWidth()`  L142
- `int getStrokeColor()`  L146
- `int getStrokePressColor()`  L150
- `int getTextPressColor()`  L154
- `boolean isRadiusHalfHeight()`  L158
- `boolean isWidthHeightEqual()`  L162
- `int getCornerRadius_TL()`  L166
- `int getCornerRadius_TR()`  L170
- `int getCornerRadius_BL()`  L174
- `int getCornerRadius_BR()`  L178
- `int dp2px(float dp)`  L182
- `int sp2px(float sp)`  L186
- `void setDrawable(GradientDrawable gd, int color, int strokeColor)`  L190
- `void setBgSelector()`  L213
- `ColorStateList getPressedColorSelector(int normalColor, int pressedColor)`  L243
### `com.gku.actioncam.sigmastar.widget.ScreenResolution`
L10 · [class] public ScreenResolution · `com/gku/actioncam/sigmastar/widget/ScreenResolution.java`

方法（3）：
- `Pair<Integer, Integer> getResolution(Context ctx)`  L11
- `Pair<Integer, Integer> getRealResolutionOnOldDevice(Context ctx)`  L15
    - 体内字面量："window" · "getRawWidth" · "getRawHeight"
- `Pair<Integer, Integer> getRealResolution(Context ctx)`  L25
    - 体内字面量："window"
### `com.gku.actioncam.sigmastar.widget.SSDialog`
L25 · [class] public SSDialog · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

字段/常量（2）：
- `String TAG = "SSDialog"`  L26
- `View.OnClickListener onClickListener2 = onClickListener`  L169

方法（31）：
- `AlertDialog createSSDialog(Context context, View view, boolean cancelOnTouchOutsize, DialogInterface.OnCancelListener onCancelListener)`  L28
- `AlertDialog createProgressDialog(Context context, DialogInterface.OnCancelListener onCancelListener)`  L42
- `AlertDialog createProgressDialogHasText(Context context, DialogInterface.OnCancelListener onCancelListener)`  L46
- `void showMessageTipDialog(Context context, String title, String message, final View.OnClickListener onClickListener)`  L50
- `void onClick(View view)`  L61 @Override
- `void onClick(View view)`  L67 @Override
- `void lambda$showMessageTipDialog$0(AlertDialog alertDialog, View view)`  L74
- `void lambda$showMessageTipDialog$1(View.OnClickListener onClickListener, AlertDialog alertDialog, View view)`  L80
- `AlertDialog showTipNoConfirmDialog(Context context, String title, String contentMessage, String CancelName, boolean CancelOnTouchOutsize, DialogInterface.OnCancelListener onCancelListener, final View.OnClickListener onClickListener)`  L87
- `void onClick(View view)`  L98 @Override
- `void lambda$showTipNoConfirmDialog$2(View.OnClickListener onClickListener, AlertDialog alertDialog, View view)`  L105
- `AlertDialog showTipDialog(Context context, String title, String contentMessage, String cancelName, String confirmName, boolean CancelOnTouchOutsize, DialogInterface.OnCancelListener onCancelListener, final View.OnClickListener onClickListener1, final View.OnClickListener onClickListener2)`  L114
- `void onClick(View view)`  L127 @Override
- `void onClick(View view)`  L133 @Override
- `void lambda$showTipDialog$3(View.OnClickListener onClickListener, AlertDialog alertDialog, View view)`  L140
- `void lambda$showTipDialog$4(View.OnClickListener onClickListener, AlertDialog alertDialog, View view)`  L149
- `AlertDialog showJumpDialog(Context context, Drawable drawable, String text, final View.OnClickListener onClickListener)`  L158
- `void onClick(View v)`  L168 @Override
- `void showFileInfoDialog(Context context, String title, String name, String size, String create, String path, DialogInterface.OnCancelListener onCancelListener)`  L178
- `void onClick(View view)`  L194 @Override
- `void lambda$showFileInfoDialog$5(AlertDialog alertDialog, View view)`  L201
- `void showListDialog(Context context, SSListDialogRecycleAdapter.TYPE_SHOW_ITEM type, String title, ArrayList<SSListDialogRecycleItemBean> recycleItemBeans, final SSListDialogRecycleAdapter.OnSSDialogListItemClickListener onSSDialogListItemClickListener, DialogInterface.OnDismissListener onDismissListener)`  L207
- `void onClick(View view)`  L219 @Override
- `void onItemClick(SSListDialogRecycleItemBean sSListDialogRecycleItemBean)`  L226 @Override
- `void lambda$showListDialog$6(AlertDialog alertDialog, View view)`  L236
- `void lambda$showListDialog$7(AlertDialog alertDialog, SSListDialogRecycleAdapter.OnSSDialogListItemClickListener onSSDialogListItemClickListener, SSListDialogRecycleItemBean sSListDialogRecycleItemBean)`  L242
- `void showFastSettingSecondListDialog(Context context, FastSettingSecondListDialogRecycleAdapter.TYPE_SHOW_ITEM type, String title, ArrayList<FastSecondItemValueBean> recycleItemBeans, final FastSettingSecondListDialogRecycleAdapter.OnFastSettingSecondListDialogClickListener onFastSettingSecondListDialogClickListener, DialogInterface.OnDismissListener onDismissListener)`  L247
- `void onClick(View view)`  L259 @Override
- `void onItemClick(FastSecondItemValueBean fastSecondItemValueBean)`  L266 @Override
- `void lambda$showFastSettingSecondListDialog$8(AlertDialog alertDialog, View view)`  L276
- `void lambda$showFastSettingSecondListDialog$9(AlertDialog alertDialog, FastSettingSecondListDialogRecycleAdapter.OnFastSettingSecondListDialogClickListener onFastSettingSecondListDialogClickListener, FastSecondItemValueBean fastSecondItemValueBean)`  L282
### `com.gku.actioncam.sigmastar.widget.SSDialog$FastSettingSecondListDialogRecycleAdapter`
L414 · [class] public static FastSettingSecondListDialogRecycleAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

字段/常量（4）：
- `OnFastSettingSecondListDialogClickListener onFastSettingSecondListDialogClickListener`  L415
- `ArrayList<FastSecondItemValueBean> showList`  L416
- `TYPE_SHOW_ITEM type`  L417
- `ArrayList<FastSecondItemValueBean> arrayList = this.showList`  L477

方法（8）：
- `public FastSettingSecondListDialogRecycleAdapter(TYPE_SHOW_ITEM type, ArrayList<FastSecondItemValueBean> showList)`  L428
- `void setOnFastSettingSecondListDialogClickListener(OnFastSettingSecondListDialogClickListener onFastSettingSecondListDialogClickListener)`  L433
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L438 @Override
- `void onBindViewHolder(ViewHolder holder, final int position)`  L446 @Override
- `void onClick(View view)`  L450 @Override
- `void lambda$onBindViewHolder$0(int i, View view)`  L466
- `int getItemViewType(int position)`  L471 @Override
- `int getItemCount()`  L476 @Override
### `com.gku.actioncam.sigmastar.widget.SSDialog$FastSettingSecondListDialogRecycleAdapter$OnFastSettingSecondListDialogClickListener`
L419 · [interface] public OnFastSettingSecondListDialogClickListener · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

方法（1）：
- `void onItemClick(FastSecondItemValueBean fastSecondItemValueBean)`  L420
### `com.gku.actioncam.sigmastar.widget.SSDialog$FastSettingSecondListDialogRecycleAdapter$OperateViewHolder`
L501 · [class] public static OperateViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

字段/常量（2）：
- `ImageView ss_list_dialog_recycle_operate_item_icon`  L502
- `TextView ss_list_dialog_recycle_operate_item_name`  L503

方法（1）：
- `public OperateViewHolder(View itemView)`  L505
### `com.gku.actioncam.sigmastar.widget.SSDialog$FastSettingSecondListDialogRecycleAdapter$SettingViewHolder`
L490 · [class] public static SettingViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

字段/常量（2）：
- `TextView ss_list_dialog_recycle_setting_item_name`  L491
- `ImageView ss_list_dialog_recycle_setting_item_selected`  L492

方法（1）：
- `public SettingViewHolder(View itemView)`  L494
### `com.gku.actioncam.sigmastar.widget.SSDialog$FastSettingSecondListDialogRecycleAdapter$TYPE_SHOW_ITEM`
L423 · [enum] public TYPE_SHOW_ITEM · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

枚举常量（1）：
- `SETTING()`  L424
### `com.gku.actioncam.sigmastar.widget.SSDialog$FastSettingSecondListDialogRecycleAdapter$ViewHolder`
L484 · [class] public static ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

方法（1）：
- `public ViewHolder(View itemView)`  L485
### `com.gku.actioncam.sigmastar.widget.SSDialog$SSListDialogRecycleAdapter`
L287 · [class] public static SSListDialogRecycleAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

字段/常量（4）：
- `OnSSDialogListItemClickListener onSSDialogListItemClickListener`  L288
- `ArrayList<SSListDialogRecycleItemBean> showList`  L289
- `TYPE_SHOW_ITEM type`  L290
- `ArrayList<SSListDialogRecycleItemBean> arrayList = this.showList`  L378

方法（8）：
- `public SSListDialogRecycleAdapter(TYPE_SHOW_ITEM type, ArrayList<SSListDialogRecycleItemBean> showList)`  L301
- `void setOnSSDialogListItemClickListener(OnSSDialogListItemClickListener onSSDialogListItemClickListener)`  L306
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L311 @Override
- `void onBindViewHolder(ViewHolder holder, final int position)`  L319 @Override
- `void onClick(View view)`  L323 @Override
- `void lambda$onBindViewHolder$0(int i, View view)`  L367
- `int getItemViewType(int position)`  L372 @Override
- `int getItemCount()`  L377 @Override
### `com.gku.actioncam.sigmastar.widget.SSDialog$SSListDialogRecycleAdapter$OnSSDialogListItemClickListener`
L292 · [interface] public OnSSDialogListItemClickListener · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

方法（1）：
- `void onItemClick(SSListDialogRecycleItemBean ssListDialogRecycleItem)`  L293
### `com.gku.actioncam.sigmastar.widget.SSDialog$SSListDialogRecycleAdapter$OperateViewHolder`
L402 · [class] public static OperateViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

字段/常量（2）：
- `ImageView ss_list_dialog_recycle_operate_item_icon`  L403
- `TextView ss_list_dialog_recycle_operate_item_name`  L404

方法（1）：
- `public OperateViewHolder(View itemView)`  L406
### `com.gku.actioncam.sigmastar.widget.SSDialog$SSListDialogRecycleAdapter$SettingViewHolder`
L391 · [class] public static SettingViewHolder · extends `ViewHolder` · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

字段/常量（2）：
- `TextView ss_list_dialog_recycle_setting_item_name`  L392
- `ImageView ss_list_dialog_recycle_setting_item_selected`  L393

方法（1）：
- `public SettingViewHolder(View itemView)`  L395
### `com.gku.actioncam.sigmastar.widget.SSDialog$SSListDialogRecycleAdapter$TYPE_SHOW_ITEM`
L296 · [enum] public TYPE_SHOW_ITEM · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

枚举常量（1）：
- `SETTING()`  L297
### `com.gku.actioncam.sigmastar.widget.SSDialog$SSListDialogRecycleAdapter$ViewHolder`
L385 · [class] public static ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/widget/SSDialog.java`

方法（1）：
- `public ViewHolder(View itemView)`  L386
### `com.gku.actioncam.sigmastar.widget.SSFastSettingPopupWindow`
L22 · [class] public SSFastSettingPopupWindow · extends `PopupWindow` · `com/gku/actioncam/sigmastar/widget/SSFastSettingPopupWindow.java`

字段/常量（2）：
- `SSFastSettingCallback sSFastSettingCallback2 = sSFastSettingCallback`  L76
- `SSFastSettingCallback sSFastSettingCallback2 = sSFastSettingCallback`  L84

方法（10）：
- `public SSFastSettingPopupWindow(Context context, final String workMode, final String itemName, SSecondItemBean sSecondItemBean, final SSFastSettingCallback ssFastSettingCallback)`  L34
- `void onSettingItemClick(String str)`  L42 @Override
- `void lambda$new$0(final SSFastSettingCallback sSFastSettingCallback, String str, String str2, final String str3)`  L57
- `void endRequest()`  L60 @Override
- `void onCancel()`  L65 @Override
- `void startRequest()`  L70 @Override
- `void onSuccess(Response response)`  L75 @Override
- `void onFailure(Exception exception)`  L83 @Override
- `public SSFastSettingPopupWindow(Context context, final String workMode, final String itemName, SSecondItemBean sSecondItemBean, final SSFastSettingClickback ssFastSettingClickback)`  L92
- `void onSettingItemClick(String str)`  L100 @Override
### `com.gku.actioncam.sigmastar.widget.SSFastSettingPopupWindow$SSFastSettingCallback`
L24 · [interface] public SSFastSettingCallback · `com/gku/actioncam/sigmastar/widget/SSFastSettingPopupWindow.java`

方法（2）：
- `void onFailure(Exception exception)`  L25
- `void onSuccess(Response response, String value)`  L27
### `com.gku.actioncam.sigmastar.widget.SSFastSettingPopupWindow$SSFastSettingClickback`
L30 · [interface] public SSFastSettingClickback · `com/gku/actioncam/sigmastar/widget/SSFastSettingPopupWindow.java`

方法（1）：
- `void onClick(String workMode, String itemName, String value)`  L31
### `com.gku.actioncam.sigmastar.widget.SSFastSettingPopupWindow$SSFastSettingPopupListAdapter`
L114 · [class] public static SSFastSettingPopupListAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/gku/actioncam/sigmastar/widget/SSFastSettingPopupWindow.java`

字段/常量（4）：
- `String currentValue`  L115
- `List<String> fastSettingItemList`  L116
- `OnSettingItemClickListener onSettingItemClickListener`  L117
- `List<String> list = this.fastSettingItemList`  L159

方法（7）：
- `public SSFastSettingPopupListAdapter(List<String> fastSettingItemList, String currentValue)`  L123
- `ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)`  L129 @Override
- `void onBindViewHolder(ViewHolder holder, int position)`  L134 @Override
- `void onClick(View view)`  L145 @Override
- `void lambda$onBindViewHolder$0(String str, View view)`  L153
- `int getItemCount()`  L158 @Override
- `void setOnSettingItemClickListener(OnSettingItemClickListener onSettingItemClickListener)`  L166
### `com.gku.actioncam.sigmastar.widget.SSFastSettingPopupWindow$SSFastSettingPopupListAdapter$OnSettingItemClickListener`
L119 · [interface] public OnSettingItemClickListener · `com/gku/actioncam/sigmastar/widget/SSFastSettingPopupWindow.java`

方法（1）：
- `void onSettingItemClick(String value)`  L120
### `com.gku.actioncam.sigmastar.widget.SSFastSettingPopupWindow$SSFastSettingPopupListAdapter$ViewHolder`
L170 · [class] public static ViewHolder · extends `RecyclerView.ViewHolder` · `com/gku/actioncam/sigmastar/widget/SSFastSettingPopupWindow.java`

字段/常量（2）：
- `ImageView ss_fast_setting_popup_list_item_selected`  L171
- `TextView ss_fast_setting_popup_list_item_text`  L172

方法（1）：
- `public ViewHolder(View itemView)`  L174
### `com.gku.actioncam.sigmastar.widget.SSModeSelectPopupWindow`
L21 · [class] public SSModeSelectPopupWindow · extends `PopupWindow` · `com/gku/actioncam/sigmastar/widget/SSModeSelectPopupWindow.java`

字段/常量（15）：
- `SSModeSelectPopupListAdapter adapter`  L22
- `HashMap<String, ArrayList<String>> allWorkMode`  L23
- `Context mContext`  L24
- `View photo_selected`  L25
- `TextView photo_text`  L26
- `LinearLayout selectPopupWindow`  L27
- `View video_selected`  L28
- `TextView video_text`  L29
- `HashMap<String, ArrayList<String>> map = this.allWorkMode`  L120
- `SSModeSelectPopupListAdapter sSModeSelectPopupListAdapter`  L128
- `SSModeSelectPopupListAdapter sSModeSelectPopupListAdapter2 = this.adapter`  L129
- `HashMap<String, ArrayList<String>> map = this.allWorkMode`  L134
- `View view = this.video_selected`  L138
- `boolean z = view != null`  L139
- `View view2 = this.photo_selected`  L140

方法（9）：
- `public SSModeSelectPopupWindow(Context context, final String currentMode, HashMap<String, ArrayList<String>> allWorkMode, final SSModeSelectLis ssModeSelectLis)`  L43
    - 体内字面量："video" · "video" · "photo"
- `void onModeItemClick(String str)`  L72 @Override
- `void onClick(View view)`  L79 @Override
- `void onClick(View view)`  L85 @Override
- `void lambda$new$0(String str, SSModeSelectLis sSModeSelectLis, String str2)`  L98
- `void lambda$new$1(View view)`  L106
- `void lambda$new$2(View view)`  L111
- `void selectModeType(View video_selected, View photo_selected, boolean isVideoType)`  L115
- `void updateCurWorkMode(String workMode)`  L127 @Deprecated
### `com.gku.actioncam.sigmastar.widget.SSModeSelectPopupWindow$SSModeSelectCallback`
L31 · [interface] public SSModeSelectCallback · `com/gku/actioncam/sigmastar/widget/SSModeSelectPopupWindow.java`

方法（3）：
- `void onFailure(Exception exception)`  L32
- `void onSuccess(Response response, String currentMode)`  L34
- `void startRequest()`  L36
### `com.gku.actioncam.sigmastar.widget.SSModeSelectPopupWindow$SSModeSelectLis`
L39 · [interface] public SSModeSelectLis · `com/gku/actioncam/sigmastar/widget/SSModeSelectPopupWindow.java`

方法（1）：
- `void onSelect(String mode)`  L40
### `com.gku.actioncam.sigmastar.widget.SSVideoView`
L27 · [class] public SSVideoView · extends `SurfaceView implements SSMediaController.MediaPlayerControl` · implements `SSMediaController.MediaPlayerControl` · `com/gku/actioncam/sigmastar/widget/SSVideoView.java`

字段/常量（85）：
- `int STATE_ERROR = -1`  L28
- `int STATE_IDLE = 0`  L29
- `int STATE_PAUSED = 4`  L30
- `int STATE_PLAYBACK_COMPLETED = 5`  L31
- `int STATE_PLAYING = 3`  L32
- `int STATE_PREPARED = 2`  L33
- `int STATE_PREPARING = 1`  L34
- `int STATE_RESUME = 7`  L35
- `int STATE_SUSPEND = 6`  L36
- `int STATE_SUSPEND_UNSUPPORTED = 8`  L37
- `String TAG = "com.gku.actioncam.sigmastar.widget.SSVideoView"`  L38
- `int VIDEO_LAYOUT_ORIGIN = 0`  L39
- `int VIDEO_LAYOUT_SCALE = 1`  L40
- `int VIDEO_LAYOUT_STRETCH = 2`  L41
- `int VIDEO_LAYOUT_ZOOM = 3`  L42
- `IMediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener`  L43
- `boolean mCanPause`  L44
- `boolean mCanSeekBack`  L45
- `boolean mCanSeekForward`  L46
- `IMediaPlayer.OnCompletionListener mCompletionListener`  L47
- `Context mContext`  L48
- `int mCurrentBufferPercentage`  L49
- `int mCurrentState`  L50
- `long mDuration`  L51
- `IMediaPlayer.OnErrorListener mErrorListener`  L52
- `IMediaPlayer.OnInfoListener mInfoListener`  L53
- `View mMediaBufferingIndicator`  L54
- `IMediaPlayer mMediaPlayer`  L55
- `IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener`  L56
- `IMediaPlayer.OnCompletionListener mOnCompletionListener`  L57
- `IMediaPlayer.OnErrorListener mOnErrorListener`  L58
- `IMediaPlayer.OnInfoListener mOnInfoListener`  L59
- `IMediaPlayer.OnPreparedListener mOnPreparedListener`  L60
- `IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener`  L61
- `IMediaPlayer.OnPreparedListener mPreparedListener`  L62
- `SurfaceHolder.Callback mSHCallback`  L63
- `SSMediaController mSSMediaController`  L64
- `IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener`  L65
- `long mSeekWhenPrepared`  L66
- `IMediaPlayer.OnVideoSizeChangedListener mSizeChangedListener`  L67
- `int mSurfaceHeight`  L68
- `SurfaceHolder mSurfaceHolder`  L69
- `int mSurfaceWidth`  L70
- `int mTargetState`  L71
- `Uri mUri`  L72
- `String mUserAgent`  L73
- `int mVideoHeight`  L74
- `int mVideoLayout`  L75
- `int mVideoSarDen`  L76
- `int mVideoSarNum`  L77
- `int mVideoWidth`  L78
- `SSVideoView sSVideoView = SSVideoView.this`  L101
- `long j = SSVideoView.this.mSeekWhenPrepared`  L119
- `SSVideoView sSVideoView = SSVideoView.this`  L124
- `boolean z = SSVideoView.this.mTargetState == 3`  L232
- `boolean z2 = SSVideoView.this.mVideoWidth == w && SSVideoView.this.mVideoHeight == h`  L233
- `SSVideoView sSVideoView = SSVideoView.this`  L236
- `SSVideoView sSVideoView = SSVideoView.this`  L299
- `long j = SSVideoView.this.mSeekWhenPrepared`  L317
- `SSVideoView sSVideoView = SSVideoView.this`  L322
- `boolean z = SSVideoView.this.mTargetState == 3`  L430
- `boolean z2 = SSVideoView.this.mVideoWidth == w && SSVideoView.this.mVideoHeight == h`  L431
- `SSVideoView sSVideoView = SSVideoView.this`  L434
- `int i`  L478
- `float f = iIntValue`  L485
- `float f2 = iIntValue2`  L486
- `float f3 = f / f2`  L487
- `int i2 = this.mVideoSarNum`  L488
- `int i3 = this.mVideoSarDen`  L489
- `int i4 = this.mVideoHeight`  L490
- `float f4 = i / i4`  L492
- `boolean z = layout == 2`  L511
- `SurfaceHolder surfaceHolder = this.mSurfaceHolder`  L546
- `IMediaPlayer iMediaPlayer = this.mMediaPlayer`  L567
- `IjkMediaPlayer ijkMediaPlayer`  L579
- `Uri uri = this.mUri`  L625
- `SSMediaController sSMediaController = this.mSSMediaController`  L648
- `View view = this.mMediaBufferingIndicator`  L657
- `SSMediaController sSMediaController`  L665
- `String str`  L666
- `Uri uri = this.mUri`  L673
- `IMediaPlayer iMediaPlayer = this.mMediaPlayer`  L711
- `long duration`  L801
- `long j = this.mDuration`  L803
- `int i`  L856

方法（60）：
- `public SSVideoView(Context context)`  L80
- `void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sarNum, int sarDen)`  L92 @Override
    - 体内字面量："onVideoSizeChanged: (%dx%d)"
- `void onPrepared(IMediaPlayer mp)`  L107 @Override
    - 体内字面量："onPrepared"
- `void onCompletion(IMediaPlayer mp)`  L153 @Override
    - 体内字面量："onCompletion"
- `boolean onError(IMediaPlayer mp, int framework_err, int impl_err)`  L167 @Override
    - 体内字面量："Error: %d, %d"
- `void onBufferingUpdate(IMediaPlayer mp, int percent)`  L183 @Override
- `boolean onInfo(IMediaPlayer mp, int what, int extra)`  L192 @Override
- `void onSeekComplete(IMediaPlayer mp)`  L216 @Override
    - 体内字面量："onSeekComplete"
- `void surfaceChanged(SurfaceHolder holder, int format, int w, int h)`  L225 @Override
- `void surfaceCreated(SurfaceHolder holder)`  L250 @Override
- `void surfaceDestroyed(SurfaceHolder holder)`  L261 @Override
- `public SSVideoView(Context context, AttributeSet attrs)`  L274
- `public SSVideoView(Context context, AttributeSet attrs, int defStyle)`  L278
- `void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sarNum, int sarDen)`  L290 @Override
    - 体内字面量："onVideoSizeChanged: (%dx%d)"
- `void onPrepared(IMediaPlayer mp)`  L305 @Override
    - 体内字面量："onPrepared"
- `void onCompletion(IMediaPlayer mp)`  L351 @Override
    - 体内字面量："onCompletion"
- `boolean onError(IMediaPlayer mp, int framework_err, int impl_err)`  L365 @Override
    - 体内字面量："Error: %d, %d"
- `void onBufferingUpdate(IMediaPlayer mp, int percent)`  L381 @Override
- `boolean onInfo(IMediaPlayer mp, int what, int extra)`  L390 @Override
- `void onSeekComplete(IMediaPlayer mp)`  L414 @Override
    - 体内字面量："onSeekComplete"
- `void surfaceChanged(SurfaceHolder holder, int format, int w, int h)`  L423 @Override
- `void surfaceCreated(SurfaceHolder holder)`  L448 @Override
- `void surfaceDestroyed(SurfaceHolder holder)`  L459 @Override
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L473 @Override
- `void setVideoLayout(int layout)`  L477
- `void initVideoView(Context ctx)`  L528
- `boolean isValid()`  L545
- `void setVideoPath(String path)`  L550
- `void setVideoURI(Uri uri)`  L554
- `void setUserAgent(String ua)`  L562
- `void stopPlayback()`  L566
- `void openVideo()`  L578
- `void setMediaController(SSMediaController controller)`  L647
- `void setMediaBufferingIndicator(View mediaBufferingIndicator)`  L656
- `void attachMediaController()`  L664
- `void setOnPreparedListener(IMediaPlayer.OnPreparedListener l)`  L685
- `void setOnCompletionListener(IMediaPlayer.OnCompletionListener l)`  L689
- `void setOnErrorListener(IMediaPlayer.OnErrorListener l)`  L693
- `void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener l)`  L697
- `void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener l)`  L701
- `void setOnInfoListener(IMediaPlayer.OnInfoListener l)`  L705
- `void release(boolean cleartargetstate)`  L710
- `boolean onTouchEvent(MotionEvent ev)`  L724 @Override
- `boolean onTrackballEvent(MotionEvent ev)`  L733 @Override
- `boolean onKeyDown(int keyCode, KeyEvent event)`  L742 @Override
- `void toggleMediaControlsVisiblity()`  L765
- `void start()`  L774 @Override
- `void pause()`  L783 @Override
- `void resume()`  L791
- `int getDuration()`  L800 @Override
- `int getCurrentPosition()`  L817 @Override
- `void seekTo(long msec)`  L825 @Override
- `boolean isPlaying()`  L835 @Override
- `int getBufferPercentage()`  L840 @Override
- `int getVideoWidth()`  L847
- `int getVideoHeight()`  L851
- `boolean isInPlaybackState()`  L855
- `boolean canPause()`  L861 @Override
- `boolean canSeekBackward()`  L866 @Override
- `boolean canSeekForward()`  L871 @Override
### `com.gku.actioncam.sigmastar.widget.StateView`
L18 · [class] public StateView · extends `LinearLayout` · `com/gku/actioncam/sigmastar/widget/StateView.java`

字段/常量（6）：
- `int SHORT_TIME = 1500`  L19
- `int HINT_VIEW`  L20
- `ImageView ivState`  L21
- `Handler mHandler`  L22
- `RotateAnimation mRotateAnimation`  L23
- `TextView tvMessage`  L24

方法（15）：
- `public StateView(Context context)`  L26
- `void handleMessage(Message msg)`  L31 @Override
- `public StateView(Context context, AttributeSet attrs)`  L40
- `void handleMessage(Message msg)`  L45 @Override
- `void sendDelayedMessage(int time)`  L61
- `void hintMessage()`  L65
- `void showNormalMessage(int message)`  L69
- `void showNormalMessage(int message, int time)`  L77
- `void showLoadingMessage(int message)`  L82
- `void showLoadingMessage(String message)`  L91
- `void showLoadingMessage(String message, int spinningPic)`  L100
- `void showLoadingMessage(int message, int time)`  L109
- `void showFinishMessage(int message)`  L114
- `void showFinishMessage(int message, int time)`  L123
- `void rotateAnimHorizon(ImageView rotateImgv)`  L128
### `com.gku.actioncam.sigmastar.widget.TabLayout.FragmentChangeManager`
L9 · [class] public FragmentChangeManager · `com/gku/actioncam/sigmastar/widget/TabLayout/FragmentChangeManager.java`

字段/常量（4）：
- `int mContainerViewId`  L10
- `int mCurrentTab`  L11
- `FragmentManager mFragmentManager`  L12
- `ArrayList<Fragment> mFragments`  L13

方法（5）：
- `public FragmentChangeManager(FragmentManager fm, int containerViewId, ArrayList<Fragment> fragments)`  L15
- `void initFragments()`  L22
- `void setFragments(int index)`  L29
- `int getCurrentTab()`  L43
- `Fragment getCurrentFragment()`  L47
### `com.gku.actioncam.sigmastar.widget.TabLayout.MsgView`
L13 · [class] public MsgView · extends `AppCompatTextView` · `com/gku/actioncam/sigmastar/widget/TabLayout/MsgView.java`

字段/常量（8）：
- `int backgroundColor`  L14
- `Context context`  L15
- `int cornerRadius`  L16
- `GradientDrawable gd_background`  L17
- `boolean isRadiusHalfHeight`  L18
- `boolean isWidthHeightEqual`  L19
- `int strokeColor`  L20
- `int strokeWidth`  L21

方法（22）：
- `public MsgView(Context context)`  L23
- `public MsgView(Context context, AttributeSet attrs)`  L27
- `public MsgView(Context context, AttributeSet attrs, int defStyleAttr)`  L31
- `void obtainAttributes(Context context, AttributeSet attrs)`  L38
- `void onMeasure(int widthMeasureSpec, int heightMeasureSpec)`  L50 @Override
- `void onLayout(boolean changed, int left, int top, int right, int bottom)`  L60 @Override
- `void setBackgroundColor(int backgroundColor)`  L70 @Override
- `void setCornerRadius(int cornerRadius)`  L75
- `void setStrokeWidth(int strokeWidth)`  L80
- `void setStrokeColor(int strokeColor)`  L85
- `void setIsRadiusHalfHeight(boolean isRadiusHalfHeight)`  L90
- `void setIsWidthHeightEqual(boolean isWidthHeightEqual)`  L95
- `int getBackgroundColor()`  L100
- `int getCornerRadius()`  L104
- `int getStrokeWidth()`  L108
- `int getStrokeColor()`  L112
- `boolean isRadiusHalfHeight()`  L116
- `boolean isWidthHeightEqual()`  L120
- `int dp2px(float dp)`  L124
- `int sp2px(float sp)`  L128
- `void setDrawable(GradientDrawable gd, int color, int strokeColor)`  L132
- `void setBgSelector()`  L138
### `com.gku.actioncam.sigmastar.widget.TabLayout.OnTabSelectListener`
L4 · [interface] public OnTabSelectListener · `com/gku/actioncam/sigmastar/widget/TabLayout/OnTabSelectListener.java`

方法（2）：
- `void onTabReselect(int position)`  L5
- `void onTabSelect(int position)`  L7
### `com.gku.actioncam.sigmastar.widget.TabLayout.SegmentTabLayout`
L27 · [class] public SegmentTabLayout · extends `FrameLayout implements ValueAnimator.AnimatorUpdateListener` · implements `ValueAnimator.AnimatorUpdateListener` · `com/gku/actioncam/sigmastar/widget/TabLayout/SegmentTabLayout.java`

字段/常量（64）：
- `int TEXT_BOLD_BOTH = 2`  L28
- `int TEXT_BOLD_NONE = 0`  L29
- `int TEXT_BOLD_WHEN_SELECT = 1`  L30
- `boolean enableTabLayout`  L31
- `int mBarColor`  L32
- `int mBarStrokeColor`  L33
- `float mBarStrokeWidth`  L34
- `Context mContext`  L35
- `IndicatorPoint mCurrentP`  L36
- `int mCurrentTab`  L37
- `int mDividerColor`  L38
- `float mDividerPadding`  L39
- `Paint mDividerPaint`  L40
- `float mDividerWidth`  L41
- `FragmentChangeManager mFragmentChangeManager`  L42
- `int mHeight`  L43
- `long mIndicatorAnimDuration`  L44
- `boolean mIndicatorAnimEnable`  L45
- `boolean mIndicatorBounceEnable`  L46
- `int mIndicatorColor`  L47
- `float mIndicatorCornerRadius`  L48
- `GradientDrawable mIndicatorDrawable`  L49
- `float mIndicatorHeight`  L50
- `float mIndicatorMarginBottom`  L51
- `float mIndicatorMarginLeft`  L52
- `float mIndicatorMarginRight`  L53
- `float mIndicatorMarginTop`  L54
- `Rect mIndicatorRect`  L55
- `OvershootInterpolator mInterpolator`  L56
- `boolean mIsFirstDraw`  L57
- `IndicatorPoint mLastP`  L58
- `int mLastTab`  L59
- `OnTabSelectListener mListener`  L60
- `float[] mRadiusArr`  L61
- `GradientDrawable mRectDrawable`  L62
- `int mTabCount`  L63
- `float mTabPadding`  L64
- `boolean mTabSpaceEqual`  L65
- `float mTabWidth`  L66
- `LinearLayout mTabsContainer`  L67
- `boolean mTextAllCaps`  L68
- `int mTextBold`  L69
- `int mTextSelectColor`  L70
- `int mTextUnselectColor`  L71
- `float mTextsize`  L72
- `String[] mTitles`  L73
- `ValueAnimator mValueAnimator`  L74
- `LinearLayout.LayoutParams layoutParams`  L187
- `int i = 0`  L220
- `float f = this.mTabPadding`  L223
- `int i2 = this.mTextBold`  L231
- `int i = 0`  L242
- `boolean z = i == position`  L245
- `int i = this.mCurrentTab`  L284
- `float[] fArr = this.mRadiusArr`  L286
- `float f = this.mIndicatorCornerRadius`  L287
- `float[] fArr2 = this.mRadiusArr`  L299
- `float f2 = this.mIndicatorCornerRadius`  L302
- `float[] fArr3 = this.mRadiusArr`  L311
- `float[] fArr4 = this.mRadiusArr`  L322
- `float f3 = this.mIndicatorCornerRadius`  L323
- `float f = this.mIndicatorCornerRadius`  L353
- `float f2 = this.mDividerWidth`  L363
- `FragmentChangeManager fragmentChangeManager = this.mFragmentChangeManager`  L391

方法（65）：
- `public SegmentTabLayout(Context context)`  L76
- `public SegmentTabLayout(Context context, AttributeSet attrs)`  L80
- `public SegmentTabLayout(Context context, AttributeSet attrs, int defStyleAttr)`  L84
    - 体内字面量："http://schemas.android.com/apk/res/android" · "layout_height" · "-1" · "-2"
- `void obtainAttributes(Context context, AttributeSet attrs)`  L115
    - 体内字面量："#222831" · "#ffffff"
- `void setTabData(String[] titles)`  L158
- `throw new IllegalStateException( 6 )`  L160
- `void setTabData(String[] titles, FragmentActivity fa, int containerViewId, ArrayList<Fragment> fragments)`  L166
- `void notifyDataSetChanged()`  L171
- `void setEnableTabLayout(boolean enableTabLayout)`  L182
- `void addTab(final int position, View tabView)`  L186
- `void onClick(View v)`  L191 @Override
- `void updateTabStyles()`  L219
- `void updateTabSelection(int position)`  L241
- `void calcOffset()`  L255
- `void calcIndicatorRect()`  L277
- `void onAnimationUpdate(ValueAnimator animation)`  L335 @Override
- `void onDraw(Canvas canvas)`  L343 @Override
- `void setCurrentTab(int currentTab)`  L387
- `void setTabPadding(float tabPadding)`  L402
- `void setTabSpaceEqual(boolean tabSpaceEqual)`  L407
- `void setTabWidth(float tabWidth)`  L412
- `void setIndicatorColor(int indicatorColor)`  L417
- `void setIndicatorHeight(float indicatorHeight)`  L422
- `void setIndicatorCornerRadius(float indicatorCornerRadius)`  L427
- `void setIndicatorMargin(float indicatorMarginLeft, float indicatorMarginTop, float indicatorMarginRight, float indicatorMarginBottom)`  L432
- `void setIndicatorAnimDuration(long indicatorAnimDuration)`  L440
- `void setIndicatorAnimEnable(boolean indicatorAnimEnable)`  L444
- `void setIndicatorBounceEnable(boolean indicatorBounceEnable)`  L448
- `void setDividerColor(int dividerColor)`  L452
- `void setDividerWidth(float dividerWidth)`  L457
- `void setDividerPadding(float dividerPadding)`  L462
- `void setTextsize(float textsize)`  L467
- `void setTextSelectColor(int textSelectColor)`  L472
- `void setTextUnselectColor(int textUnselectColor)`  L477
- `void setTextBold(int textBold)`  L482
- `void setTextAllCaps(boolean textAllCaps)`  L487
- `int getTabCount()`  L492
- `int getCurrentTab()`  L496
- `float getTabPadding()`  L500
- `boolean isTabSpaceEqual()`  L504
- `float getTabWidth()`  L508
- `int getIndicatorColor()`  L512
- `float getIndicatorHeight()`  L516
- `float getIndicatorCornerRadius()`  L520
- `float getIndicatorMarginLeft()`  L524
- `float getIndicatorMarginTop()`  L528
- `float getIndicatorMarginRight()`  L532
- `float getIndicatorMarginBottom()`  L536
- `long getIndicatorAnimDuration()`  L540
- `boolean isIndicatorAnimEnable()`  L544
- `boolean isIndicatorBounceEnable()`  L548
- `int getDividerColor()`  L552
- `float getDividerWidth()`  L556
- `float getDividerPadding()`  L560
- `float getTextsize()`  L564
- `int getTextSelectColor()`  L568
- `int getTextUnselectColor()`  L572
- `int getTextBold()`  L576
- `boolean isTextAllCaps()`  L580
- `TextView getTitleView(int tab)`  L584
- `void setOnTabSelectListener(OnTabSelectListener listener)`  L588
- `Parcelable onSaveInstanceState()`  L593 @Override
    - 体内字面量："instanceState" · "mCurrentTab"
- `void onRestoreInstanceState(Parcelable state)`  L601 @Override
    - 体内字面量："mCurrentTab" · "instanceState"
- `int dp2px(float dp)`  L636
- `int sp2px(float sp)`  L640
### `com.gku.actioncam.sigmastar.widget.TabLayout.SegmentTabLayout$IndicatorPoint`
L613 · [class] IndicatorPoint · `com/gku/actioncam/sigmastar/widget/TabLayout/SegmentTabLayout.java`

字段/常量（2）：
- `float left`  L614
- `float right`  L615
### `com.gku.actioncam.sigmastar.widget.TabLayout.SegmentTabLayout$PointEvaluator`
L621 · [class] PointEvaluator · implements `TypeEvaluator<IndicatorPoint>` · `com/gku/actioncam/sigmastar/widget/TabLayout/SegmentTabLayout.java`

方法（1）：
- `IndicatorPoint evaluate(float fraction, IndicatorPoint startValue, IndicatorPoint endValue)`  L626 @Override
### `com.gku.actioncam.sigmastar.widget.TabLayout.UnreadMsgUtils`
L7 · [class] public UnreadMsgUtils · `com/gku/actioncam/sigmastar/widget/TabLayout/UnreadMsgUtils.java`

方法（2）：
- `void show(MsgView msgView, int num)`  L8
    - 体内字面量："99+"
- `void setSize(MsgView rtv, int size)`  L39