# XTU GO — 类与成员明细：com.sherlockshi.widget

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `com.sherlockshi.widget.SherlockSpinner`
L19 · [class] public SherlockSpinner · extends `AppCompatEditText` · `com/sherlockshi/widget/SherlockSpinner.java`

字段/常量（14）：
- `int DEF_LINE_COLOR = -12627531`  L20
- `View mAnchorView`  L21
- `Context mContext`  L22
- `int mDropdownIcon`  L23
- `AdapterView.OnItemClickListener mItemClickListener`  L24
- `int mLineColor`  L25
- `ListAdapter mListAdapter`  L26
- `ListPopupWindow mListPopupWindow`  L27
- `OnClickListener mOnClickListener`  L28
- `OnClickListener onClickListener = this.mOnClickListener`  L66
- `View view = this.mAnchorView`  L80
- `SherlockSpinner sherlockSpinner = SherlockSpinner.this`  L90
- `ListPopupWindow listPopupWindow = this.mListPopupWindow`  L99
- `Drawable drawable`  L140

方法（15）：
- `public SherlockSpinner(Context context)`  L34
- `public SherlockSpinner(Context context, AttributeSet attrs)`  L40
- `void init()`  L56
- `boolean onTouchEvent(MotionEvent event)`  L63 @Override
- `void initSpinner()`  L76
- `void onItemClick(AdapterView<?> parent, View view2, int position, long id)`  L89 @Override
- `void show()`  L98
- `void setLineColorResource(int resId)`  L105
- `void setLineColor(int color)`  L109
- `void setOnItemClickListener(AdapterView.OnItemClickListener itemClickListener)`  L113
- `void setOnClickListener(OnClickListener l)`  L117
- `void setAnchorView(View anchor)`  L124
- `void setAdapter(ListAdapter adapter)`  L128
- `void setDropdownIcon(int resId)`  L134
- `void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom)`  L139 @Override
### `com.sherlockshi.widget.SherlockSpinner$OnClickListener`
L30 · [interface] public OnClickListener · `com/sherlockshi/widget/SherlockSpinner.java`

方法（1）：
- `void onClick(View v)`  L31