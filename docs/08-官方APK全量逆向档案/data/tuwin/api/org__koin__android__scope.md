# TUWIN — 类与成员明细：org.koin.android.scope

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.koin.android.scope.AndroidScopeComponent`
L10 · [interface] public AndroidScopeComponent · `org/koin/android/scope/AndroidScopeComponent.java`
注解：

方法（2）：
- `Scope getScope()`  L19
- `void onCloseScope()`  L21
### `org.koin.android.scope.AndroidScopeComponent$DefaultImpls`
L14 · [class] public static final DefaultImpls · `org/koin/android/scope/AndroidScopeComponent.java`
注解：

方法（1）：
- `void onCloseScope(AndroidScopeComponent androidScopeComponent)`  L15
### `org.koin.android.scope.ComponentCallbacksExtKt`
L18 · [class] public final ComponentCallbacksExtKt · `org/koin/android/scope/ComponentCallbacksExtKt.java`
注解：

方法（9）：
- `Scope createScope$default(ComponentCallbacks componentCallbacks, Object obj, int i, Object obj2)`  L19
- `Scope createScope(T t, Object obj)`  L26
    - 体内字面量："<this>"
- `Scope getScopeOrNull(T t)`  L31
    - 体内字面量："<this>"
- `Lazy<Scope> newScope(final T t)`  L36
    - 体内字面量："<this>"
- `Object invoke()`  L40 @Override
- `Scope newScope$lambda$0(ComponentCallbacks componentCallbacks)`  L47
- `Lazy<Scope> getOrCreateScope(final T t)`  L51
    - 体内字面量："<this>"
- `Object invoke()`  L55 @Override
- `Scope getOrCreateScope$lambda$1(ComponentCallbacks componentCallbacks)`  L62
### `org.koin.android.scope.ScopeService`
L12 · [class] public abstract ScopeService · extends `Service implements AndroidScopeComponent` · implements `AndroidScopeComponent` · `org/koin/android/scope/ScopeService.java`
注解：

方法（4）：
- `void onCloseScope()`  L18 @Override
- `Scope getScope()`  L23 @Override
- `void onCreate()`  L28 @Override
    - 体内字面量："Required value was null."
- `void onDestroy()`  L36 @Override
### `org.koin.android.scope.ServiceExtKt`
L18 · [class] public final ServiceExtKt · `org/koin/android/scope/ServiceExtKt.java`
注解：

方法（7）：
- `Scope createServiceScope(Service service)`  L19
    - 体内字面量："<this>" · "Service should implement AndroidScopeComponent"
- `void destroyServiceScope(Service service)`  L30
    - 体内字面量："<this>" · "Service should implement AndroidScopeComponent"
- `Lazy<Scope> serviceScope(final Service service)`  L38
    - 体内字面量："<this>"
- `Object invoke()`  L42 @Override
- `Scope createScope$default(Service service, Object obj, int i, Object obj2)`  L48
- `Scope createScope(Service service, Object obj)`  L55
    - 体内字面量："<this>"
- `Scope getScopeOrNull(Service service)`  L60
    - 体内字面量："<this>"