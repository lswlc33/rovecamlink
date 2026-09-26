# idGoLive — 类与成员明细：com.icatchtek.baseutil.bitmap

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.bitmap.BitmapDecode`
L12 · [class] public BitmapDecode · `com/icatchtek/baseutil/bitmap/BitmapDecode.java`

字段/常量（10）：
- `String TAG = "BitmapDecode"`  L13
- `Bitmap bitmap`  L14
- `Bitmap resizeBmp`  L15
- `SoftReference<Bitmap> softBitmap`  L16
- `int i3 = options.outHeight`  L19
- `int i4 = options.outWidth`  L20
- `Bitmap bitmap = this.bitmap`  L44
- `SoftReference<Bitmap> softReference = this.softBitmap`  L49
- `Bitmap bitmap2 = this.resizeBmp`  L54
- `float width`  L64

方法（4）：
- `int calculateInSampleSize(BitmapFactory.Options options, int i, int i2)`  L18
- `Bitmap decodeSampledBitmapFromByteArray(byte[] bArr, int i, int i2, int i3, int i4)`  L29
    - 体内字面量："decodeSampledBitmapFromByteArray IOException"
- `void recycleBitmap()`  L43
- `Bitmap zoomBitmap(Bitmap bitmap, float f, float f2)`  L63
### `com.icatchtek.baseutil.bitmap.BitmapTools`
L20 · [class] public BitmapTools · `com/icatchtek/baseutil/bitmap/BitmapTools.java`

字段/常量（23）：
- `long LIMITED_IMGAE_SIZE = 10485760`  L21
- `String TAG = "BitmapTools"`  L22
- `int THUMBNAIL_HEIGHT = 100`  L23
- `int THUMBNAIL_WIDTH = 100`  L24
- `int i5 = 1`  L64
- `int i3`  L79
- `int i4`  L80
- `int i5 = 1`  L89
- `int i3 = options.outHeight`  L104
- `int i4 = options.outWidth`  L105
- `int i2 = i * 1024`  L123
- `byte[] bArr`  L167
- `FileInputStream fileInputStream`  L168
- `Exception e`  L169
- `Bitmap bitmapDecodeFile`  L229
- `int i3 = options.outHeight`  L279
- `float f = 100`  L306
- `float f = 100`  L317
- `int i2 = 100`  L336
- `File file`  L364
- `File file`  L408
- `String str3 = str + str2`  L427
- `float width`  L447

方法（24）：
- `Bitmap ImageCompress(Bitmap bitmap)`  L26
- `Bitmap base64ToBitmap(String str)`  L37
- `String bitmapToBase64(Bitmap bitmap)`  L44
- `byte[] bitmapToByteArray(Bitmap bitmap)`  L50
- `int calculateInSampleSize(int i, int i2, int i3, int i4)`  L62
    - 体内字面量："calculateInSampleSize srcWidth:" · " srcHeight:" · " reqWidth:" · " reqHeight:"
- `int calculateInSampleSize(BitmapFactory.Options options, int i, int i2)`  L78
- `int calculateInSampleSizeForPV(BitmapFactory.Options options, int i, int i2)`  L103
- `byte[] compressImage(String str, int i)`  L109
- `Bitmap decodeByteArray(byte[] bArr)`  L137
    - 体内字面量："start decodeByteArray" · "end decodeByteArray bitmap="
- `Bitmap decodeByteArray(byte[] bArr, int i, int i2)`  L153
    - 体内字面量："start decodeByteArray" · "end decodeByteArray"
- `byte[] fileToByteArray(String str)`  L166
- `List<Bitmap> getBitmap(String str)`  L228
- `Bitmap getBitmapByPath(String str)`  L245
    - 体内字面量："Start getImageByPath imagePath="
- `Bitmap getBitmapByPath(String str, int i, int i2)`  L258
    - 体内字面量："Start getImageByPath imagePath="
- `Bitmap getBitmapByWidth(String str, int i, int i2)`  L271
- `Bitmap getImageThumbnailByPath(String str)`  L295
    - 体内字面量："Start getImageByPath imagePath="
- `Bitmap getVideoThumbnailByPath(String str)`  L310
    - 体内字面量："start getVideoThumbnailByPath videoPath=" · "End getVideoThumbnailByPath bitmap="
- `Bitmap getVideoThumbnailByPath(String str, int i, int i2)`  L321
    - 体内字面量："start getVideoThumbnailByPath videoPath=" · "End getVideoThumbnailByPath bitmap="
- `byte[] qualityCompress(Bitmap bitmap, int i)`  L331
- `Bitmap rotateMyBitmap(Bitmap bitmap, float f)`  L354
- `boolean saveImage(Bitmap bitmap, String str, String str2)`  L363
- `boolean saveImage(byte[] bArr, String str, String str2)`  L407
- `Bitmap zoomBitmap(Bitmap bitmap, float f, float f2)`  L446
- `Bitmap zoomImage(Bitmap bitmap, double d, double d2)`  L473