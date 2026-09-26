# TUWIN — 类与成员明细：org.repackage.com.meizu

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 3 个文件 / 3 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：UNKNOWN
### `org.repackage.com.meizu.flyme.openidsdk.C4009a`
L11 · [class] final C4009a · extends `BroadcastReceiver` · `org/repackage/com/meizu/flyme/openidsdk/C4009a.java`

字段/常量（2）：
- `OpenId openId`  L18
- `boolean zContains = false`  L22

方法（1）：
- `void onReceive(Context context, Intent intent)`  L17 @Override
### `org.repackage.com.meizu.flyme.openidsdk.C4010b`
L17 · [class] C4010b · `org/repackage/com/meizu/flyme/openidsdk/C4010b.java`

字段/常量（13）：
- `C4010b f3872e = null`  L20
- `boolean f3873f = false`  L23
- `BroadcastReceiver f3879h`  L26
- `ProviderInfo providerInfoResolveContentProvider`  L48
- `String str`  L57
- `Cursor cursorQuery = null`  L117
- `String str`  L150
- `String strConcat`  L151
- `String str2`  L152
- `?? r0 = 0`  L154
- `String str3 = null`  L157
- `Cursor cursor = null`  L158
- `String str`  L248

方法（12）：
- `private C4010b()`  L43
- `String m2523a(PackageManager packageManager, String str)`  L47
- `ValueData m2524a(Cursor cursor)`  L56
- `C4010b m2525a()`  L91
- `void m2526a(String str)`  L103
    - 体内字面量："OpenIdManager"
- `void m2527a(boolean z)`  L110
- `boolean m2528a(Context context)`  L115
    - 体内字面量："querySupport version : 1.0.8"
- `String m2529b(Context context, OpenId openId)`  L149
- `String m2530b(PackageManager packageManager, String str)`  L220
    - 体内字面量："getAppVersion, Exception : "
- `void m2531b(Context context)`  L235
    - 体内字面量："com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE" · "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE"
- `String m2532a(Context context, OpenId openId)`  L247
- `boolean m2533a(Context context, boolean z)`  L265
    - 体内字面量："com.meizu.flyme.openidsdk" · "use same version cache, safeVersion : " · "query support, result : "
### `org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper`
L8 · [class] public OpenIdHelper · `org/repackage/com/meizu/flyme/openidsdk/OpenIdHelper.java`

字段/常量（3）：
- `String f3865a = "OpenIdHelper"`  L11
- `Method f3866b`  L14
- `Context context = null`  L30

方法（6）：
- `String m2512a(Context context)`  L17
- `void m2513a(boolean z)`  L23
- `boolean m2514a()`  L29
- `String m2515b(Context context)`  L48
- `String m2516c(Context context)`  L54
- `String m2517d(Context context)`  L60