# idGoLive — 类与成员明细：com.icatchtek

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.ImageUtil`
L14 · [class] public ImageUtil · `com/icatchtek/ImageUtil.java`

字段/常量（3）：
- `Cursor cursor = null`  L16
- `Uri uri2 = null`  L47
- `String str = strArrSplit2[0]`  L61

方法（6）：
- `String getDataColumn(Context context, Uri uri, String str, String[] strArr)`  L15
- `String getImageAbsolutePath(Context context, Uri uri)`  L46
- `boolean isDownloadsDocument(Uri uri)`  L84
    - 体内字面量："com.android.providers.downloads.documents"
- `boolean isExternalStorageDocument(Uri uri)`  L88
    - 体内字面量："com.android.externalstorage.documents"
- `boolean isGooglePhotosUri(Uri uri)`  L92
    - 体内字面量："com.google.android.apps.photos.content"
- `boolean isMediaDocument(Uri uri)`  L96
    - 体内字面量："com.android.providers.media.documents"