# TUWIN — 类与成员明细：com.release.alert

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 8 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `com.release.alert.Alert`
L35 · [class] public Alert · `com/release/alert/Alert.java`

字段/常量（54）：
- `RecyclerView bottom_rv_content`  L36
- `Button btn_neg`  L37
- `Button btn_pos`  L38
- `Context context`  L39
- `Dialog dialog`  L40
- `LinearLayout dialog_loading_bg`  L41
- `Display display`  L42
- `EditText etInput`  L43
- `EditText etInput2`  L44
- `EditText etInput3`  L45
- `View img_line`  L46
- `LinearLayout lLayout_bg`  L47
- `AlertAdapter mAlertViewAdapter`  L48
- `List<ItemBean> mAlertViewItems`  L49
- `View mDialogLayout`  L50
- `OnInputListener mOnInputListener`  L51
- `TextView mProMsgText`  L52
- `TextView txt_cancel`  L53
- `TextView txt_msg`  L54
- `TextView txt_sub_title`  L55
- `TextView txt_title`  L56
- `Type mType = Type.NORMAL`  L57
- `int mSelectPosition = -1`  L58
- `boolean trimInput = true`  L59
- `OnInputListener onInputListener = this.mOnInputListener`  L242
- `OnInputListener onInputListener = this.mOnInputListener`  L309
- `TextView textView = this.txt_cancel`  L351
- `TextView textView = this.mProMsgText`  L359
- `TextView textView2 = this.mProMsgText`  L362
- `TextView textView = this.mProMsgText`  L372
- `TextView textView = this.txt_title`  L380
- `TextView textView2 = this.txt_title`  L383
- `TextView textView = this.txt_sub_title`  L393
- `TextView textView2 = this.txt_sub_title`  L396
- `TextView textView = this.txt_msg`  L406
- `TextView textView = this.txt_msg`  L421
- `TextView textView = this.txt_msg`  L434
- `Button button = this.btn_pos`  L452
- `Button button2 = this.btn_pos`  L456
- `Button button = this.btn_pos`  L473
- `Button button = this.btn_neg`  L490
- `Button button2 = this.btn_neg`  L495
- `Button button = this.btn_neg`  L511
- `Button button2 = this.btn_neg`  L516
- `Button button = this.btn_neg`  L533
- `AlertAdapter alertAdapter = this.mAlertViewAdapter`  L551
- `List<ItemBean> list = this.mAlertViewItems`  L566
- `List<ItemBean> list = this.mAlertViewItems`  L574
- `AlertAdapter alertAdapter = this.mAlertViewAdapter`  L602
- `EditText editText = this.etInput`  L610
- `EditText editText = this.etInput`  L618
- `EditText editText = this.etInput2`  L631
- `EditText editText2 = this.etInput3`  L635
- `List<ItemBean> list = this.mAlertViewItems`  L648

方法（64）：
- `public Alert(Context context)`  L82
    - 体内字面量："window"
- `Alert builder()`  L87
- `Alert builder(Type type)`  L92
- `Alert builder(Type type, int i)`  L109
- `void initNormalType()`  L117
- `void initProgressType()`  L145
- `void initBottomType()`  L158
- `void run()`  L175 @Override
- `void m2703lambda$initBottomType$0$comreleasealertAlert()`  L187
- `void initInputType()`  L197
- `void onClick(View view)`  L206 @Override
- `void onClick(View view)`  L212 @Override
- `void run()`  L222 @Override
- `void m2704lambda$initInputType$1$comreleasealertAlert(View view)`  L234
- `void m2705lambda$initInputType$2$comreleasealertAlert(View view)`  L239
- `void m2706lambda$initInputType$3$comreleasealertAlert()`  L256
- `void initTwoInputType()`  L266
- `void onClick(View view)`  L275 @Override
- `void onClick(View view)`  L281 @Override
- `void run()`  L291 @Override
- `void m2707lambda$initTwoInputType$4$comreleasealertAlert(View view)`  L303
- `void m2708lambda$initTwoInputType$5$comreleasealertAlert(View view)`  L308
- `void m2709lambda$initTwoInputType$6$comreleasealertAlert()`  L321
- `void initCustomDialog(int i)`  L331
- `Alert initDialogLayout(OnInitDialogLayoutListener onInitDialogLayoutListener)`  L345
- `Alert setBottomCancelBtnColor(int i)`  L350
- `Alert setProgressText(String str)`  L358
- `Alert setProgressTextGone()`  L371
- `Alert setTitle(String str)`  L379
- `Alert setSubTitle(String str)`  L392
- `Alert setMsg(String str)`  L405
- `Alert setMsg(CharSequence charSequence)`  L420
- `Alert setMsgGravity(int i)`  L433
- `Alert setCancelable(boolean z)`  L441
- `Alert setCanceledOnTouchOutside(boolean z)`  L446
- `Alert setPositiveButton(String str, final View.OnClickListener onClickListener)`  L451
- `void onClick(View view)`  L463 @Override
- `Alert setPositiveButton(final View.OnClickListener onClickListener)`  L472
- `void onClick(View view)`  L480 @Override
- `Alert setNegativeButton(String str)`  L489
- `void onClick(View view)`  L502 @Override
- `Alert setNegativeButton(String str, final View.OnClickListener onClickListener)`  L510
- `void onClick(View view)`  L523 @Override
- `Alert setNegativeButton(final View.OnClickListener onClickListener)`  L532
- `void onClick(View view)`  L541 @Override
- `Alert setOnItemClickListener(final OnAlertItemClickListener onAlertItemClickListener)`  L550
- `void onItemClick(View view, int i)`  L555 @Override
- `Alert addItem(String str, int i)`  L565
- `Alert addItem(String str)`  L573
- `Alert addItem(String[] strArr)`  L581
- `Alert addItem(List<ItemBean> list)`  L590
- `Alert setItemSelected(int i)`  L600
- `Alert setInputText(String str)`  L609
- `Alert setInputHint(String str)`  L617
- `Alert setTrimInput(boolean z)`  L625
- `Alert setTwoInputText(String str, String str2)`  L630
- `Alert setOnInputListener(OnInputListener onInputListener)`  L642
- `void notifyData()`  L647
- `Dialog show()`  L656
- `void onDismiss(DialogInterface dialogInterface)`  L662 @Override
- `void m2711lambda$show$8$comreleasealertAlert(DialogInterface dialogInterface)`  L671
- `void run()`  L674 @Override
- `void m2710lambda$show$7$comreleasealertAlert()`  L681
- `void dissmiss()`  L691
### `com.release.alert.Alert$OnAlertItemClickListener`
L61 · [interface] public OnAlertItemClickListener · `com/release/alert/Alert.java`

方法（1）：
- `void onItemClick(View view, int i)`  L62
### `com.release.alert.Alert$OnInitDialogLayoutListener`
L65 · [interface] public OnInitDialogLayoutListener · `com/release/alert/Alert.java`

方法（1）：
- `void initView(View view, Dialog dialog)`  L66
### `com.release.alert.Alert$OnInputListener`
L69 · [interface] public OnInputListener · `com/release/alert/Alert.java`

方法（1）：
- `boolean onInput(String str, String str2)`  L70
### `com.release.alert.Alert$Type`
L73 · [enum] public Type · `com/release/alert/Alert.java`

枚举常量（5）：
- `NORMAL()`  L74
- `PROGRESS()`  L75
- `BOTTOM()`  L76
- `INPUT()`  L77
- `TWO_INPUT()`  L78
### `com.release.alert.AlertAdapter`
L16 · [class] public AlertAdapter · extends `RecyclerView.Adapter<ViewHolder>` · `com/release/alert/AlertAdapter.java`

字段/常量（4）：
- `List<ItemBean> mAlertViewItems`  L17
- `Context mContext`  L18
- `OnItemClickListener mOnItemClickListener`  L19
- `int selectPosition`  L20

方法（7）：
- `void setSelectedPosition(int i)`  L26
- `public AlertAdapter(Context context, List<ItemBean> list, int i)`  L30
- `void setOnItemClickLitener(OnItemClickListener onItemClickListener)`  L36
- `ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)`  L41 @Override
- `void onBindViewHolder(final ViewHolder viewHolder, int i)`  L46 @Override
- `void onClick(View view)`  L50 @Override
    - 体内字面量："#19279C"
- `int getItemCount()`  L67 @Override
### `com.release.alert.AlertAdapter$OnItemClickListener`
L22 · [interface] public OnItemClickListener · `com/release/alert/AlertAdapter.java`

方法（1）：
- `void onItemClick(View view, int i)`  L23
### `com.release.alert.AlertAdapter$ViewHolder`
L71 · [class] ViewHolder · extends `RecyclerView.ViewHolder` · `com/release/alert/AlertAdapter.java`

字段/常量（2）：
- `ImageView iv_select`  L72
- `TextView tv_text`  L73