# idGoLive — 类与成员明细：com.icatchtek.basecomponent.utils

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 4 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.basecomponent.utils.AnimationUtil`
L8 · [class] public AnimationUtil · `com/icatchtek/basecomponent/utils/AnimationUtil.java`

字段/常量（2）：
- `AnimationUtil mInstance`  L9
- `boolean ismHiddenActionstart = false`  L10

方法（16）：
- `AnimationUtil with()`  L12
- `void bottomMoveToViewLocation(View view, long j)`  L23
- `void moveToViewBottom(final View view, long j)`  L34
- `void onAnimationEnd(Animation animation)`  L42 @Override
- `void onAnimationRepeat(Animation animation)`  L48 @Override
- `void onAnimationStart(Animation animation)`  L52 @Override
- `void moveToViewRight(final View view, long j)`  L59
- `void onAnimationEnd(Animation animation)`  L67 @Override
- `void onAnimationRepeat(Animation animation)`  L73 @Override
- `void onAnimationStart(Animation animation)`  L77 @Override
- `void moveToViewTop(final View view, long j)`  L84
- `void onAnimationEnd(Animation animation)`  L92 @Override
- `void onAnimationRepeat(Animation animation)`  L98 @Override
- `void onAnimationStart(Animation animation)`  L102 @Override
- `void rightMoveToViewLocation(View view, long j, Animation.AnimationListener animationListener)`  L109
- `void topMoveToViewLocation(View view, long j)`  L123
### `com.icatchtek.basecomponent.utils.ClickUtils`
L6 · [class] public ClickUtils · `com/icatchtek/basecomponent/utils/ClickUtils.java`

字段/常量（3）：
- `long defaultIntervalMillis = 1000`  L7
- `long mLastClickTime`  L8
- `int mLastClickViewId`  L9

方法（2）：
- `boolean isFastDoubleClick(View view)`  L11
- `boolean isFastDoubleClick(View view, long j)`  L22
### `com.icatchtek.basecomponent.utils.LongClickUtils`
L11 · [class] public LongClickUtils · `com/icatchtek/basecomponent/utils/LongClickUtils.java`

字段/常量（5）：
- `String TAG = "LongClickUtils"`  L12
- `ImageView imageViewv`  L16
- `int mLastMotionX`  L17
- `int mLastMotionY`  L18
- `int TOUCH_MAX = 20`  L19

方法（5）：
- `void setLongClick(final Handler handler, final View view, final long j, final View.OnLongClickListener onLongClickListener)`  L14
- `void run()`  L22 @Override
- `void run()`  L30 @Override
- `void run()`  L37 @Override
- `boolean onTouch(View view2, MotionEvent motionEvent)`  L44 @Override
    - 体内字面量："ACTION_DOWN" · "ACTION_UP" · "ACTION_MOVE  x=" · ", y=" · "ACTION_MOVE removeCallbacks" · "ACTION_CANCEL" · "ACTION_OUTSIDE"
### `com.icatchtek.basecomponent.utils.StatusBar.StatusBarUtils`
L18 · [class] public StatusBarUtils · `com/icatchtek/basecomponent/utils/StatusBar/StatusBarUtils.java`

方法（10）：
- `boolean FlymeSetStatusBarLightMode(Window window, boolean z)`  L19
    - 体内字面量："MEIZU_FLAG_DARK_STATUS_BAR_ICON" · "meizuFlags"
- `boolean MIUISetStatusBarLightMode(Window window, boolean z)`  L38
    - 体内字面量："android.view.MiuiWindowManager$LayoutParams" · "EXTRA_FLAG_STATUS_BAR_DARK_MODE" · "setExtraFlags" · "statusbar1" · "miui method: 1" · "statusbar1" · "miui method: 2" · "statusbar1" · "miui method: error"
- `int StatusBarLightMode(Activity activity)`  L61
    - 体内字面量："statusbar1" · "api method"
- `void fillStatusBar(Activity activity)`  L74
- `int getStatusBarHeight(Context context)`  L79
    - 体内字面量："status_bar_height" · "dimen" · "android"
- `void setFullScreen(Activity activity, boolean z)`  L87
- `void setFullScreenNoStatusBar(Activity activity)`  L95
- `void setFullScreenWithStatusBar(Activity activity)`  L99
- `void setTranslucentStatusbar(Activity activity)`  L106
- `void setWindowStatusBarColor(Activity activity, int i, boolean z)`  L115
    - 体内字面量："StatusBar" · "Build.VERSION.SDK_INT:"