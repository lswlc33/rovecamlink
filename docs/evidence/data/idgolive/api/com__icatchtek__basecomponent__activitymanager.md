# idGoLive — 类与成员明细：com.icatchtek.basecomponent.activitymanager

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.basecomponent.activitymanager.BaseActivity`
L12 · [class] public BaseActivity · extends `AppCompatActivity` · `com/icatchtek/basecomponent/activitymanager/BaseActivity.java`

字段/常量（4）：
- `String TAG = "BaseActivity"`  L13
- `Activity activity`  L14
- `AlertDialog dialog`  L15
- `AlertDialog alertDialog = this.dialog`  L18

方法（7）：
- `void dismissDialog()`  L17
- `AlertDialog getDialog()`  L29
- `void onCreate(Bundle bundle)`  L34 @Override
- `void onDestroy()`  L42 @Override
- `void onPause()`  L49 @Override
- `void onResume()`  L55 @Override
- `void setDialog(AlertDialog alertDialog)`  L60
### `com.icatchtek.basecomponent.activitymanager.MActivityManager`
L10 · [class] public MActivityManager · `com/icatchtek/basecomponent/activitymanager/MActivityManager.java`

字段/常量（10）：
- `MActivityManager instance`  L11
- `String TAG = "MActivityManager"`  L12
- `LinkedList<Activity> activityList = null`  L13
- `WeakReference<Activity> curActivity`  L14
- `WeakReference<Activity> firstActivity`  L15
- `WeakReference<Activity> weakReference = this.firstActivity`  L36
- `LinkedList<Activity> linkedList = this.activityList`  L53
- `LinkedList<Activity> linkedList = this.activityList`  L65
- `WeakReference<Activity> weakReference`  L80
- `LinkedList<Activity> linkedList = this.activityList`  L81

方法（13）：
- `private MActivityManager()`  L17
- `void finishActivity(Activity activity)`  L20
- `MActivityManager getInstance()`  L26
- `void backFirstPage()`  L34
    - 体内字面量："backFirstPage"
- `void exitApp()`  L47
    - 体内字面量："exitApp"
- `void finishAllActivity()`  L52
- `void finishAllActivityExceptOne(Class<? extends Activity> cls)`  L64
- `Activity getCurActivity()`  L79
- `void popActivity(Activity activity)`  L88
    - 体内字面量："popActivity activityList size="
- `void popAllActivityExceptOne(Class<? extends Activity> cls)`  L98
- `void pushActivity(Activity activity)`  L109
    - 体内字面量："pushActivity activityList size="
- `void setCurActivity(Activity activity)`  L120
- `void setFirstActivity(Activity activity)`  L124