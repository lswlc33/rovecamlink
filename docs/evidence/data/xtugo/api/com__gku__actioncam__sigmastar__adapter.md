# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.adapter

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.adapter.PagerFragmentAdapter`
L14 · [class] public PagerFragmentAdapter · extends `FragmentPagerAdapter` · `com/gku/actioncam/sigmastar/adapter/PagerFragmentAdapter.java`

字段/常量（4）：
- `FragmentConnectedCamera fragmentConnectedCamera`  L15
- `FragmentDisConnectCamera fragmentDisConnectCamera`  L16
- `FragmentNewAlbum fragmentNewAlbum`  L17
- `UserCenter userCenter`  L18

方法（3）：
- `int getCount()`  L21 @Override
- `public PagerFragmentAdapter(FragmentManager fm)`  L25
- `Fragment getItem(int position)`  L30 @Override
### `com.gku.actioncam.sigmastar.adapter.PagerFragmentNewAdapter`
L12 · [class] public PagerFragmentNewAdapter · extends `FragmentStatePagerAdapter` · `com/gku/actioncam/sigmastar/adapter/PagerFragmentNewAdapter.java`

字段/常量（4）：
- `List<Fragment> mFragmentList`  L13
- `FragmentManager mFragmentManager`  L14
- `SparseArray<String> mFragmentPositionMap`  L15
- `SparseArray<String> mFragmentPositionMapAfterUpdate`  L16

方法（16）：
- `public PagerFragmentNewAdapter(FragmentManager fm, List<Fragment> fragments)`  L18
- `void setFragmentPositionMap()`  L28
- `void setFragmentPositionMapForUpdate()`  L35
- `int getItemPosition(Object object)`  L43 @Override
- `void replaceFragment(Fragment oldFragment, Fragment newFragment)`  L59
- `void replaceFragment(int position, Fragment newFragment)`  L69
- `void removeFragment(Fragment fragment)`  L75
- `void removeFragment(int position)`  L81
- `void addFragment(Fragment fragment)`  L88
- `void insertFragment(int position, Fragment fragment)`  L93
- `void notifyItemChanged()`  L98
- `void removeFragmentInternal(Fragment fragment)`  L104
- `long getItemId(int position)`  L110
- `Fragment getItem(int position)`  L118 @Override
- `int getCount()`  L123 @Override
- `List<Fragment> getFragments()`  L127