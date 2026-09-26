# idGoLive — 类与成员明细：com.icatchtek.baseutil.qrcode

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.qrcode.QRCode`
L16 · [class] public QRCode · `com/icatchtek/baseutil/qrcode/QRCode.java`

字段/常量（16）：
- `int IMAGE_HALFWIDTH = 50`  L17
- `int WIDTH = 600`  L18
- `int i3`  L21
- `int i4`  L22
- `int i5`  L23
- `int i6`  L24
- `int i7 = i / 2`  L30
- `int i8 = i2 / 2`  L31
- `int i9 = 0`  L32
- `int[] iArr = new int[i * i2]`  L51
- `int i10 = 0`  L52
- `int i12 = ViewCompat.MEASURED_STATE_MASK`  L55
- `int[] iArr = new int[i * i]`  L93
- `int i2 = width / 2`  L120
- `int[] iArr = new int[i * i]`  L125
- `int i5 = IMAGE_HALFWIDTH`  L128

方法（6）：
- `Bitmap createImage(String str, int i, int i2, Bitmap bitmap)`  L20
- `Bitmap createQRCode(String str)`  L82
- `Bitmap createQRCode(String str, int i)`  L86
    - 体内字面量："utf-8"
- `Bitmap createQRCodeWithLogo(String str, int i, Bitmap bitmap)`  L112
    - 体内字面量："utf-8"
- `Bitmap createQRCodeWithLogo(String str, Bitmap bitmap)`  L147
- `Bitmap getScaleLogo(Bitmap bitmap, int i, int i2)`  L151
### `com.icatchtek.baseutil.qrcode.SetupQRCode`
L4 · [class] public SetupQRCode · `com/icatchtek/baseutil/qrcode/SetupQRCode.java`

字段/常量（5）：
- `String key`  L5
- `String ssid`  L6
- `String syspwd`  L7
- `String uid`  L8
- `String wifipwd`  L9

方法（6）：
- `public SetupQRCode(String str, String str2, String str3, String str4, String str5)`  L11
- `String getKey()`  L19
- `String getSsid()`  L23
- `String getSyspwd()`  L27
- `String getUid()`  L31
- `String getWifipwd()`  L35