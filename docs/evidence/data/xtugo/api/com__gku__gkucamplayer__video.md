# XTU GO — 类与成员明细：com.gku.gkucamplayer.video

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.gkucamplayer.video.LandLayoutVideo`
L15 · [class] public LandLayoutVideo · extends `StandardGSYVideoPlayer` · `com/gku/gkucamplayer/video/LandLayoutVideo.java`

字段/常量（1）：
- `boolean isLinkScroll`  L16

方法（17）：
- `public LandLayoutVideo(Context context, Boolean bool)`  L18
- `public LandLayoutVideo(Context context)`  L23
- `public LandLayoutVideo(Context context, AttributeSet attributeSet)`  L28
- `void init(Context context)`  L34 @Override
- `void run()`  L38 @Override
- `boolean onDoubleTap(MotionEvent motionEvent)`  L41 @Override
- `boolean onSingleTapConfirmed(MotionEvent motionEvent)`  L47 @Override
- `void onLongPress(MotionEvent motionEvent)`  L55 @Override
- `int getLayoutId()`  L64 @Override
- `void updateStartImage()`  L72 @Override
- `int getEnlargeImageRes()`  L93 @Override
- `int getShrinkImageRes()`  L98 @Override
- `boolean onInterceptTouchEvent(MotionEvent motionEvent)`  L103 @Override
- `void resolveNormalVideoShow(View view, ViewGroup viewGroup, GSYVideoPlayer gSYVideoPlayer)`  L111 @Override
- `void setLinkScroll(boolean z)`  L119
- `void changeUiToCompleteClear()`  L124 @Override
- `void changeUiToCompleteShow()`  L130 @Override