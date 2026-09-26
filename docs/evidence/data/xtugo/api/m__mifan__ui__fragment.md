# XTU GO — 类与成员明细：m.mifan.ui.fragment

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 3 个文件 / 3 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `m.mifan.ui.fragment.BaseFragment`
L15 · [class] public abstract BaseFragment · extends `Fragment` · `m/mifan/ui/fragment/BaseFragment.java`
注解：

方法（4）：
- `int layout()`  L16
- `void onViewInit()`  L18
- `View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)`  L22 @Override
    - 体内字面量："inflater"
- `void onViewCreated(View view, Bundle savedInstanceState)`  L28 @Override
    - 体内字面量："view"
### `m.mifan.ui.fragment.OnBackPressedFragment`
L11 · [class] public abstract OnBackPressedFragment · extends `BaseFragment` · `m/mifan/ui/fragment/OnBackPressedFragment.java`
注解：

方法（4）：
- `void handleOnBackPressed()`  L18 @Override
- `void onBackPressed()`  L23
- `void hookBackPressed(boolean hook)`  L26
- `void onAttach(Context context)`  L31 @Override
    - 体内字面量："context"
### `m.mifan.ui.fragment.ViewPagerFragment`
L11 · [class] public abstract ViewPagerFragment · extends `BaseFragment` · `m/mifan/ui/fragment/ViewPagerFragment.java`
注解：

字段/常量（2）：
- `boolean firstInit = true`  L12
- `boolean isVisibleToUser`  L13

方法（9）：
- `boolean getIsVisibleToUser()`  L16
- `void setVisibleToUser(boolean z)`  L20
- `boolean getFirstInit()`  L24
- `void setFirstInit(boolean z)`  L28
- `void setUserVisibleHint(boolean isVisibleToUser)`  L33 @Override
    - 体内字面量："=============setUserVisibleHint:"
- `void onResume()`  L41 @Override
- `void onPause()`  L48 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L54 @Override
    - 体内字面量："view"
- `void callViewInit()`  L59