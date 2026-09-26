# TUWIN — 类与成员明细：com.flyco.tablayout.utils

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `com.flyco.tablayout.utils.FragmentChangeManager`
L9 · [class] public FragmentChangeManager · `com/flyco/tablayout/utils/FragmentChangeManager.java`

字段/常量（4）：
- `int mContainerViewId`  L10
- `int mCurrentTab`  L11
- `FragmentManager mFragmentManager`  L12
- `ArrayList<Fragment> mFragments`  L13

方法（5）：
- `public FragmentChangeManager(FragmentManager fm, int containerViewId, ArrayList<Fragment> fragments)`  L15
- `void initFragments()`  L22
- `void setFragments(int index)`  L29
- `int getCurrentTab()`  L43
- `Fragment getCurrentFragment()`  L47