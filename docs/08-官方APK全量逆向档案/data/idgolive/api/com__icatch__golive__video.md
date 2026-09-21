# idGoLive — 类与成员明细：com.icatch.golive.video

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.video.EmptyControlVideo`
L10 · [class] public EmptyControlVideo · extends `StandardGSYVideoPlayer` · `com/icatch/golive/video/EmptyControlVideo.java`

方法（6）：
- `public EmptyControlVideo(Context context)`  L11
- `public EmptyControlVideo(Context context, AttributeSet attributeSet)`  L15
- `public EmptyControlVideo(Context context, Boolean bool)`  L19
- `int getLayoutId()`  L24 @Override
- `void touchDoubleUp(MotionEvent motionEvent)`  L29 @Override
- `void touchSurfaceMoveFullLogic(float f, float f2)`  L33 @Override
### `com.icatch.golive.video.LandLayoutVideo`
L18 · [class] public LandLayoutVideo · extends `StandardGSYVideoPlayer` · `com/icatch/golive/video/LandLayoutVideo.java`

字段/常量（4）：
- `boolean isLinkScroll`  L19
- `float scaleFactor`  L20
- `ScaleGestureDetector scaleGestureDetector`  L21
- `float[] fArr = new float[16]`  L112

方法（20）：
- `public LandLayoutVideo(Context context)`  L23
- `public LandLayoutVideo(Context context, AttributeSet attributeSet)`  L28
- `public LandLayoutVideo(Context context, Boolean bool)`  L33
- `void changeUiToCompleteClear()`  L39 @Override
- `void changeUiToCompleteShow()`  L45 @Override
- `int getEnlargeImageRes()`  L51 @Override
- `int getLayoutId()`  L56 @Override
- `int getShrinkImageRes()`  L61 @Override
- `void init(Context context)`  L66 @Override
- `void run()`  L70 @Override
- `boolean onDoubleTap(MotionEvent motionEvent)`  L73 @Override
- `void onLongPress(MotionEvent motionEvent)`  L79 @Override
- `boolean onSingleTapConfirmed(MotionEvent motionEvent)`  L84 @Override
- `boolean onScale(ScaleGestureDetector scaleGestureDetector)`  L93 @Override
- `void onInfo(int i, int i2)`  L107 @Override
- `boolean onInterceptTouchEvent(MotionEvent motionEvent)`  L119 @Override
- `boolean onTouch(View view, MotionEvent motionEvent)`  L127 @Override
- `void resolveNormalVideoShow(View view, ViewGroup viewGroup, GSYVideoPlayer gSYVideoPlayer)`  L136 @Override
- `void setLinkScroll(boolean z)`  L144
- `void updateStartImage()`  L149 @Override