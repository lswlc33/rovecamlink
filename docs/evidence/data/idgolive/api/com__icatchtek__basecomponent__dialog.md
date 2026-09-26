# idGoLive — 类与成员明细：com.icatchtek.basecomponent.dialog

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 8 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.basecomponent.dialog.BaseDialog`
L13 · [class] public abstract BaseDialog · `com/icatchtek/basecomponent/dialog/BaseDialog.java`

字段/常量（3）：
- `Context context`  L14
- `Dialog dialog`  L15
- `Display display`  L16

方法（8）：
- `public BaseDialog(Context context)`  L18
    - 体内字面量："window"
- `void dismiss()`  L32
- `int getDialogStyleId()`  L36
- `View getView()`  L38
- `boolean isShowing()`  L40
- `BaseDialog setCancelable(boolean z)`  L44
- `BaseDialog setdismissListeren(DialogInterface.OnDismissListener onDismissListener)`  L49
- `void show()`  L54
### `com.icatchtek.basecomponent.dialog.SimpleCalendarDialogFragment`
L34 · [class] public SimpleCalendarDialogFragment · extends `DialogFragment implements OnMonthChangedListener, com.prolificinteractive.materialcalendarview.OnDateSelectedListener` · implements `OnMonthChangedListener, com.prolificinteractive.materialcalendarview.OnDateSelectedListener` · `com/icatchtek/basecomponent/dialog/SimpleCalendarDialogFragment.java`

字段/常量（20）：
- `int MAX_CROSS_YEARS = 3`  L36
- `String TAG = "SimpleCalendarDialogFragment"`  L37
- `Activity activity`  L38
- `CalendarDay calendarDay`  L39
- `MProgressWheel calendarSpinner`  L40
- `MaterialCalendarView calendarView`  L41
- `Date endTime`  L42
- `Map<Date, Integer> hasMediaDateMap`  L43
- `boolean isDismiss = false`  L45
- `OnDateSelectedListener onDateSelectedListener`  L46
- `OnDismissListener onDismissListener`  L47
- `onMonthChangedListener onMonthChangedListener`  L48
- `Date selectedTime`  L49
- `TextView textView`  L50
- `onMonthChangedListener onmonthchangedlistener = this.onMonthChangedListener`  L152
- `Map<Date, Integer> map = this.hasMediaDateMap`  L157
- `OnDateSelectedListener onDateSelectedListener = this.onDateSelectedListener`  L181
- `String str = TAG`  L190
- `OnDismissListener onDismissListener = this.onDismissListener`  L194
- `String str = TAG`  L212

方法（11）：
- `void updateDaysInfo(CalendarDay calendarDay)`  L143
    - 体内字面量："updateDaysInfo: need not to update from remote" · "updateDaysInfo: endDate = " · ", dayCount = "
- `void onAttach(Activity activity)`  L167 @Override
    - 体内字面量："onAttach"
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L174 @Override
- `void onDateSelected(MaterialCalendarView materialCalendarView, CalendarDay calendarDay, boolean z)`  L178
    - 体内字面量："onDateSelected calendarDay="
- `void onDismiss(DialogInterface dialogInterface)`  L189 @Override
- `void onMonthChanged(MaterialCalendarView materialCalendarView, CalendarDay calendarDay)`  L201
    - 体内字面量："onMonthChanged: "
- `void onViewCreated(View view, Bundle bundle)`  L210 @Override
- `void setOnDateSelectedListener(OnDateSelectedListener onDateSelectedListener)`  L235
- `void setOnMonthChanged(onMonthChangedListener onmonthchangedlistener)`  L239
- `void setParameter(Date date, Date date2)`  L243
- `void setonDismissListener(OnDismissListener onDismissListener)`  L248
### `com.icatchtek.basecomponent.dialog.SimpleCalendarDialogFragment$AllDayDisableDecorator`
L52 · [class] public AllDayDisableDecorator · implements `DayViewDecorator` · `com/icatchtek/basecomponent/dialog/SimpleCalendarDialogFragment.java`

方法（3）：
- `public AllDayDisableDecorator()`  L53
- `void decorate(DayViewFacade dayViewFacade)`  L56
- `boolean shouldDecorate(CalendarDay calendarDay)`  L60
### `com.icatchtek.basecomponent.dialog.SimpleCalendarDialogFragment$ApiSimulator`
L65 · [class] private ApiSimulator · extends `AsyncTask<Void, Void, List<CalendarDay>>` · `com/icatchtek/basecomponent/dialog/SimpleCalendarDialogFragment.java`

字段/常量（2）：
- `CalendarDay date`  L66
- `SimpleCalendarDialogFragment simpleCalendarDialogFragment = SimpleCalendarDialogFragment.this`  L77

方法（3）：
- `public ApiSimulator(CalendarDay calendarDay)`  L68
- `List<CalendarDay> doInBackground(Void... voidArr)`  L74 @Override
- `void onPostExecute(List<CalendarDay> list)`  L95 @Override
    - 体内字面量："onPostExecute isDismiss =......." · "onPostExecute calendarView.addDecorator......." · "activity="
### `com.icatchtek.basecomponent.dialog.SimpleCalendarDialogFragment$OnDateSelectedListener`
L110 · [interface] public OnDateSelectedListener · `com/icatchtek/basecomponent/dialog/SimpleCalendarDialogFragment.java`

方法（1）：
- `void onDateSelectedListener(Date date)`  L111
### `com.icatchtek.basecomponent.dialog.SimpleCalendarDialogFragment$OnDismissListener`
L114 · [interface] public OnDismissListener · `com/icatchtek/basecomponent/dialog/SimpleCalendarDialogFragment.java`

方法（1）：
- `void onDismissed()`  L115
### `com.icatchtek.basecomponent.dialog.SimpleCalendarDialogFragment$onMonthChangedListener`
L138 · [interface] public onMonthChangedListener · `com/icatchtek/basecomponent/dialog/SimpleCalendarDialogFragment.java`

方法（1）：
- `Map<Date, Integer> getHasMediaInOneMonth(Date date, int i)`  L139
### `com.icatchtek.basecomponent.dialog.SimpleCalendarDialogFragment$PrimeDayDisableDecorator`
L118 · [class] public PrimeDayDisableDecorator · implements `DayViewDecorator` · `com/icatchtek/basecomponent/dialog/SimpleCalendarDialogFragment.java`

字段/常量（2）：
- `List<CalendarDay> calendarDays`  L119
- `List<CalendarDay> list = this.calendarDays`  L133

方法（3）：
- `public PrimeDayDisableDecorator(List<CalendarDay> list)`  L121
- `void decorate(DayViewFacade dayViewFacade)`  L125
- `boolean shouldDecorate(CalendarDay calendarDay)`  L129