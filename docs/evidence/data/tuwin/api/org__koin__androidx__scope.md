# TUWIN — 类与成员明细：org.koin.androidx.scope

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 7 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.androidx.scope.ComponentActivityExtKt`
L28 · [class] public final ComponentActivityExtKt · `org/koin/androidx/scope/ComponentActivityExtKt.java`
注解：

字段/常量（5）：
- `ComponentActivity componentActivity2 = componentActivity`  L71
- `LifecycleOwner lifecycleOwner = owner`  L84
- `Function0 function0 = null`  L112
- `CreationExtras creationExtras`  L142
- `Function0 function1 = function0`  L143

方法（16）：
- `Lazy<Scope> activityScope(final ComponentActivity componentActivity)`  L29
    - 体内字面量："<this>"
- `Object invoke()`  L33 @Override
- `Lazy<Scope> activityRetainedScope(final ComponentActivity componentActivity)`  L39
    - 体内字面量："<this>"
- `Object invoke()`  L43 @Override
- `Scope createScope$default(ComponentActivity componentActivity, Object obj, int i, Object obj2)`  L49
- `Scope createScope(ComponentActivity componentActivity, Object obj)`  L56
    - 体内字面量："<this>"
- `Scope getScopeOrNull(ComponentActivity componentActivity)`  L61
    - 体内字面量："<this>"
- `Scope createActivityScope(ComponentActivity componentActivity)`  L66
    - 体内字面量："<this>" · "Activity should implement AndroidScopeComponent"
- `Scope createScopeForCurrentLifecycle(ComponentCallbacks componentCallbacks, final LifecycleOwner owner)`  L76
    - 体内字面量："<this>" · "owner"
- `void onScopeClose(Scope scope)`  L82 @Override
    - 体内字面量："scope"
- `void registerScopeForLifecycle(LifecycleOwner lifecycleOwner, final Scope scope)`  L93
    - 体内字面量："<this>" · "scope"
- `void onDestroy(LifecycleOwner owner)`  L98 @Override
    - 体内字面量："owner"
- `Scope createActivityRetainedScope(final ComponentActivity componentActivity)`  L107
    - 体内字面量："<this>" · "Activity should implement AndroidScopeComponent"
- `ViewModelStore invoke()`  L120 @Override
- `ViewModelProvider.Factory invoke()`  L130 @Override
- `CreationExtras invoke()`  L141 @Override
### `org.koin.androidx.scope.FragmentExtKt`
L22 · [class] public final FragmentExtKt · `org/koin/androidx/scope/FragmentExtKt.java`
注解：

字段/常量（1）：
- `Fragment fragment2 = fragment`  L35

方法（8）：
- `Scope createFragmentScope$default(Fragment fragment, boolean z, int i, Object obj)`  L23
- `Scope createFragmentScope(Fragment fragment, boolean z)`  L30
    - 体内字面量："<this>" · "Fragment should implement AndroidScopeComponent"
- `Lazy<Scope> fragmentScope(final Fragment fragment, final boolean z)`  L53
    - 体内字面量："<this>"
- `Object invoke()`  L57 @Override
- `Lazy fragmentScope$default(Fragment fragment, boolean z, int i, Object obj)`  L63
- `Scope getScopeOrNull(Fragment fragment)`  L70
    - 体内字面量："<this>"
- `ScopeActivity getScopeActivity(Fragment fragment)`  L75
    - 体内字面量："<this>"
- `T requireScopeActivity(Fragment fragment)`  L84
    - 体内字面量："<this>" · "can't get ScopeActivity for class "
### `org.koin.androidx.scope.RetainedScopeActivity`
L15 · [class] public abstract RetainedScopeActivity · extends `AppCompatActivity implements AndroidScopeComponent` · implements `AndroidScopeComponent` · `org/koin/androidx/scope/RetainedScopeActivity.java`
注解：

字段/常量（1）：
- `Lazy scope`  L18

方法（6）：
- `public RetainedScopeActivity()`  L20
- ` RetainedScopeActivity(int i, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L24
- `void onCloseScope()`  L29 @Override
- `public RetainedScopeActivity(int i)`  L33
- `Scope getScope()`  L39 @Override
- `void onCreate(Bundle savedInstanceState)`  L44 @Override
    - 体内字面量："Required value was null."
### `org.koin.androidx.scope.ScopeActivity`
L15 · [class] public abstract ScopeActivity · extends `AppCompatActivity implements AndroidScopeComponent` · implements `AndroidScopeComponent` · `org/koin/androidx/scope/ScopeActivity.java`
注解：

字段/常量（1）：
- `Lazy scope`  L18

方法（6）：
- `public ScopeActivity()`  L20
- ` ScopeActivity(int i, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L24
- `void onCloseScope()`  L29 @Override
- `public ScopeActivity(int i)`  L33
- `Scope getScope()`  L39 @Override
- `void onCreate(Bundle savedInstanceState)`  L44 @Override
    - 体内字面量："Required value was null."
### `org.koin.androidx.scope.ScopeFragment`
L17 · [class] public abstract ScopeFragment · extends `Fragment implements AndroidScopeComponent` · implements `AndroidScopeComponent` · `org/koin/androidx/scope/ScopeFragment.java`
注解：

字段/常量（1）：
- `Lazy scope`  L20

方法（6）：
- `public ScopeFragment()`  L22
- ` ScopeFragment(int i, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L26
- `void onCloseScope()`  L31 @Override
- `public ScopeFragment(int i)`  L35
- `Scope getScope()`  L41 @Override
- `void onViewCreated(View view, Bundle savedInstanceState)`  L46 @Override
    - 体内字面量："view" · "Required value was null."
### `org.koin.androidx.scope.ScopeHandlerViewModel`
L11 · [class] public final ScopeHandlerViewModel · extends `ViewModel` · `org/koin/androidx/scope/ScopeHandlerViewModel.java`
注解：

字段/常量（2）：
- `Scope scope`  L12
- `Scope scope = this.scope`  L25

方法（3）：
- `Scope getScope()`  L14
- `void setScope(Scope scope)`  L18
- `void onCleared()`  L23 @Override
### `org.koin.androidx.scope.ScopeViewModel`
L14 · [class] public abstract ScopeViewModel · extends `ViewModel implements KoinScopeComponent` · implements `KoinScopeComponent` · `org/koin/androidx/scope/ScopeViewModel.java`
注解：

方法（4）：
- `void onCloseScope()`  L17
- `Koin getKoin()`  L21 @Override
- `Scope getScope()`  L26 @Override
- `void onCleared()`  L31 @Override