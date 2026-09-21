# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.presentation.p010ui.base

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 6 个文件 / 6 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.presentation.p010ui.base.BaseActivity`
L23 · [class] public abstract BaseActivity · extends `AppCompatActivity implements View.OnClickListener` · implements `View.OnClickListener` · `com/tuwinsmart/tuwin/presentation/p010ui/base/BaseActivity.java`

字段/常量（6）：
- `CompositeDisposable disposable`  L24
- `boolean finishAnim = true`  L25
- `ProgressDialog progressDialog`  L26
- `CompositeDisposable compositeDisposable = this.disposable`  L95
- `ProgressDialog progressDialog = this.progressDialog`  L130
- `ProgressDialog progressDialog = this.progressDialog`  L137

方法（31）：
- `View getContentRoot()`  L28
- `void onClick(View view)`  L31 @Override
- `PreferenceHelper getPreferenceHelper()`  L34
- `CompositeDisposable getDisposable()`  L38
- `void addDisposable(Disposable disposable)`  L45
- `void onCreate(Bundle bundle)`  L50 @Override
- `void onResume()`  L64 @Override
- `void onPause()`  L70 @Override
- `void setupNavigationBar()`  L74
- `void onRestart()`  L87 @Override
- `void onDestroy()`  L92 @Override
- `void showProgressDialog(String str, boolean z)`  L102
- `void showProgressDialog(String str, boolean z, boolean z2)`  L106
- `void showProgressDialog(String str)`  L121
- `void showMonospaceProgressDialog(String str)`  L125
- `void resetProgressText(String str)`  L129
- `void hideProgressDialog()`  L136
- `void launchByHideToShowAnim(Class cls)`  L144
- `void launchByHideToShowAnim(Intent intent)`  L149
- `void launchByHideToShowAnimByResult(Intent intent, int i)`  L154
- `void launchByRightToLeftAnim(Class cls)`  L159
- `void launchByRightToLeftAnim(Intent intent)`  L164
- `void launchDetailPage(Class cls, String str)`  L169
- `void launchDetailPage(Class cls, String str, int i)`  L173
    - 体内字面量："auditType" · "id"
- `void launchDetailPage(Class cls, String str, boolean z)`  L178
    - 体内字面量："isLocalMode" · "id"
- `void launchByRightToLeftAnimByResult(Intent intent, int i)`  L183
- `void launchByBottomToTopAnimByResult(Intent intent, int i)`  L188
- `void launchByRightToLeftAnimByResult(Class cls, int i)`  L193
- `boolean isFinishAnim()`  L198
- `void setFinishAnim(boolean z)`  L202
- `void onBackPressed()`  L207 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.base.fragment.BaseDialogFragment`
L15 · [class] public abstract BaseDialogFragment · extends `DialogFragment` · `com/tuwinsmart/tuwin/presentation/p010ui/base/fragment/BaseDialogFragment.java`

方法（6）：
- `View getContentRoot()`  L16
- `void initView()`  L18
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L21 @Override
- `void onStart()`  L29 @Override
- `void showProgressDialog(String str)`  L46
- `void hideProgressDialog()`  L53
### `com.tuwinsmart.tuwin.presentation.p010ui.base.fragment.BaseFragment`
L10 · [class] public BaseFragment · extends `Fragment` · `com/tuwinsmart/tuwin/presentation/p010ui/base/fragment/BaseFragment.java`

字段/常量（1）：
- `BaseActivity activity`  L11

方法（8）：
- `void showProgressDialog(String str)`  L13
- `void hideProgressDialog()`  L17
- `void onAttach(Activity activity)`  L22 @Override
- `void launchByRightToLeftAnim(Class cls)`  L27
- `void launchByRightToLeftAnim(Intent intent)`  L32
- `void launchByRightToLeftAnimByResult(Intent intent, int i)`  L37
- `void launchByBottomToTopAnimByResult(Intent intent, int i)`  L42
- `void onDestroy()`  L48 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.base.fragment.BaseLazyLoadFragment`
L10 · [class] public abstract BaseLazyLoadFragment · extends `BaseFragment` · `com/tuwinsmart/tuwin/presentation/p010ui/base/fragment/BaseLazyLoadFragment.java`

字段/常量（6）：
- `View rootView`  L11
- `String TAG = "BaseLazyLoadFragment" + this`  L12
- `boolean isLayoutInitialized = false`  L13
- `boolean isLazyLoadFinished = false`  L14
- `boolean isVisibleToUser = false`  L15
- `boolean isInVisibleRelease = false`  L16

方法（17）：
- `void fragmentHide()`  L18
- `void fragmentShow()`  L20
- `View getLayoutRoot(LayoutInflater layoutInflater, ViewGroup viewGroup)`  L22
- `void inVisibleRelease()`  L24
- `void initFragment()`  L26
- `void lazyLoad()`  L28
- `void visibleReLoad()`  L30
- `void onCreate(Bundle bundle)`  L33 @Override
    - 体内字面量："  onCreate"
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L39 @Override
    - 体内字面量："  onCreateView"
- `void onDestroyView()`  L50 @Override
    - 体内字面量："  onDestroyView"
- `void onActivityCreated(Bundle bundle)`  L57 @Override
    - 体内字面量："  onActivityCreated"
- `void onStart()`  L65 @Override
    - 体内字面量："  onStart"
- `void onResume()`  L71 @Override
    - 体内字面量："  onResume"
- `void onPause()`  L81 @Override
    - 体内字面量："  onPause"
- `void onDestroy()`  L91 @Override
    - 体内字面量："  onDestroy"
- `void setUserVisibleHint(boolean z)`  L102 @Override
    - 体内字面量："  setUserVisibleHint isVisibleToUser = "
- `void dispatchVisibleEvent()`  L108
    - 体内字面量："  dispatchVisibleEvent isVisibleToUser = " · " --- isLayoutInitialized = " · " --- isLazyLoadFinished = "
### `com.tuwinsmart.tuwin.presentation.p010ui.base.fragment.BaseMainFragment`
L13 · [class] public abstract BaseMainFragment · extends `BaseFragment` · `com/tuwinsmart/tuwin/presentation/p010ui/base/fragment/BaseMainFragment.java`

字段/常量（3）：
- `boolean isFirstLoad = true`  L14
- `BaseActivity mActivity`  L15
- `View view`  L16

方法（12）：
- `void fragmentHide()`  L18
- `void fragmentShow()`  L20
- `View getLayoutRoot(LayoutInflater layoutInflater, ViewGroup viewGroup)`  L22
- `void initFragment()`  L24
- `void lazyInitData()`  L26
- `View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)`  L29 @Override
- `void onResume()`  L38 @Override
- `void onPause()`  L48 @Override
- `PreferenceHelper getPreferenceHelper()`  L53
- `void onAttach(Activity activity)`  L58 @Override
- `void onDestroy()`  L64 @Override
- `void onDestroyView()`  L70 @Override
### `com.tuwinsmart.tuwin.presentation.p010ui.base.ToolBarActivity`
L13 · [class] public abstract ToolBarActivity · extends `BaseActivity` · `com/tuwinsmart/tuwin/presentation/p010ui/base/ToolBarActivity.java`

字段/常量（2）：
- `ActivityActionbarBinding binding`  L14
- `Map<String, Object> data`  L15

方法（26）：
- `void onCreate(Bundle bundle)`  L18 @Override
- `void setContentView(View view)`  L24 @Override
- `void setTitle(CharSequence charSequence)`  L32 @Override
- `CharSequence getTitleText()`  L36
- `void setTitle(int i)`  L41 @Override
- `TextView getTitleView()`  L45
- `void setLeftImg(int i)`  L49
- `void setLeftImgVisibility(int i)`  L53
- `void setLeftClickListener(View.OnClickListener onClickListener)`  L57
- `void setRightImg(int i)`  L61
- `void setRightClickListener(View.OnClickListener onClickListener)`  L65
- `void setRightItemImg(int i)`  L69
- `void setRightItemClickListener(View.OnClickListener onClickListener)`  L73
- `void setLogoImg(int i)`  L77
- `void hideActionBar()`  L81
- `void showActionBar()`  L85
- `void setDefaultBar(String str, View.OnClickListener onClickListener)`  L89
- `void setDefaultBar(int i, View.OnClickListener onClickListener)`  L94
- `void setDefaultBar(String str)`  L99
- `void onClick(View view)`  L103 @Override
- `void setDefaultBar(int i)`  L110
- `void onClick(View view)`  L114 @Override
- `void setLeftLayout(int i, View.OnClickListener onClickListener)`  L121
- `void setRightItemLayout(int i, View.OnClickListener onClickListener)`  L128
- `void clearAll()`  L133
- `void onBackPressed()`  L145 @Override