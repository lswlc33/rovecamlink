# idGoLive — 类与成员明细：com.icatchtek.baseutil.date

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.date.DateConverter`
L11 · [class] public DateConverter · `com/icatchtek/baseutil/date/DateConverter.java`

字段/常量（10）：
- `String ACCOUNT_SERVER_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"`  L12
- `String DAY_FORMAT = "yyyy/MM/dd"`  L13
- `String DEVICE_DAY_FORMAT = "yyyy-MM-dd"`  L14
- `String DEVICE_FORMAT = "yyyyMMdd'T'HHmmss"`  L15
- `String FILE_NAME_FORMAT = "yyyy-MM-dd_HH-mm-ss"`  L16
- `String MONTH_FORMAT = "yyyy/MM"`  L17
- `String TAG = "DateConverter"`  L18
- `String TIME = "HH:mm:ss"`  L19
- `String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss"`  L20
- `String UI_FORMAT = "yyyy-MM-dd HH:mm:ss"`  L21

方法（22）：
- `Date DeviceDayStringToDate(String str)`  L23
    - 体内字面量："DeviceDayStringToDate error, dayStr = "
- `Date GMTStringToDate(String str)`  L34
    - 体内字面量："GMT" · "GMTStringToDate error, dayStr = "
- `boolean areSameDay(Date date, Date date2)`  L45
- `long converterDeviceTime(String str)`  L53
    - 体内字面量："converterDeviceTime error:" · ", dayStr = "
- `Date dayStr2Date(String str)`  L62
    - 体内字面量："dayStr2Date error, dayStr = "
- `Date getDateBefore(Date date, int i)`  L71
- `Date getDayBefore(Date date, int i)`  L78
- `Date getNextDay(Date date, int i)`  L85
- `Date monthStr2Date(String str)`  L92
    - 体内字面量："monthStr2Date error, monthStr = "
- `Date serverTimeStr2Date(String str)`  L101
    - 体内字面量："GMT" · "serverTimeStr2Date error, datetimeStr = "
- `Date setEndTimeOfDay(Date date)`  L112
- `Date setStartTimeOfDay(Date date)`  L122
- `String timeConvert(String str)`  L132
    - 体内字面量："Asia/Shanghai" · "GMT" · "æ ¼å¼åç»æ1ï¼" · "error format"
- `String timeFormatDeviceString(long j)`  L146
- `String timeFormatFileNameString(long j)`  L150
- `String timeFormatGMTString(long j)`  L154
    - 体内字面量："GMT"
- `String timeFormatUIString(long j)`  L160
- `Date timeStr2Date(String str)`  L164
    - 体内字面量："timeStr2Date error, datetimeStr = "
- `String toDayStr(Date date)`  L173
- `String toLocalTimeStr(Date date)`  L177
- `String toMonthStr(Date date)`  L181
- `String toTimeStr(Date date)`  L185
### `com.icatchtek.baseutil.date.DateUtil`
L10 · [class] public DateUtil · `com/icatchtek/baseutil/date/DateUtil.java`

字段/常量（8）：
- `String CamDayFormat = "yyyy/MM/dd"`  L11
- `String DayFormat = "yyyy-MM-dd"`  L12
- `String TAG = "DateUtil"`  L13
- `String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss"`  L14
- `String TimeFormat = "HH:mm:ss"`  L15
- `Date today`  L16
- `boolean isTimeSync = true`  L17
- `String str = TAG`  L82

方法（21）：
- `Date camDayStr2Date(String str)`  L19
- `Calendar dayStr2Calendar(String str)`  L30
- `Date getDayBegin(Date date)`  L37
- `Date getDayEnd(Date date)`  L46
- `String getDayOnMonth(String str)`  L59
- `Date getEndDayofMonth(Date date)`  L63
- `Date getFirstDayofMonth(Date date)`  L70
- `String getMonth(String str)`  L77
- `Date getToday()`  L81
- `String getYear(String str)`  L99
- `boolean isAfterMonth(Date date, Date date2)`  L103
- `boolean isBeforeMonth(Date date, Date date2)`  L117
- `boolean isDayAfter(Date date, Date date2)`  L131
- `boolean isDayBefore(Date date, Date date2)`  L145
- `boolean isSameDay(Date date, Date date2)`  L159
- `boolean isSameMonth(Date date, Date date2)`  L168
- `Date nextDay(Date date)`  L177
- `String toCamDayStr(String str)`  L184
- `String toCamDayStr(Date date)`  L193
- `String toDayStr(Date date)`  L197
- `String toTimeStr(Date date)`  L201