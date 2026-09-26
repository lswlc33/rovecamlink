# idGoLive — 类与成员明细：com.icatchtek.baseutil.io

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 3 个文件 / 3 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.io.CleanCacheUtil`
L11 · [class] public CleanCacheUtil · `com/icatchtek/baseutil/io/CleanCacheUtil.java`

字段/常量（7）：
- `String[] list`  L30
- `long folderSize = 0`  L45
- `int length = fileArrListFiles.length`  L49
- `double d2 = d / 1024.0d`  L61
- `double d3 = d2 / 1024.0d`  L65
- `double d4 = d3 / 1024.0d`  L69
- `double d5 = d4 / 1024.0d`  L73

方法（5）：
- `void clearAllCache(Context context, List<String> list)`  L12
    - 体内字面量："mounted"
- `boolean deleteDir(File file)`  L29
- `long getFolderSize(File file)`  L44
- `String getFormatSize(double d)`  L60
- `String getTotalCacheSize(Context context, List<String> list)`  L80
    - 体内字面量："mounted"
### `com.icatchtek.baseutil.io.FileOper`
L12 · [class] public FileOper · `com/icatchtek/baseutil/io/FileOper.java`

字段/常量（1）：
- `String TAG = "FileOper"`  L13

方法（4）：
- `void copyFile(Context context, String str, String str2, int i)`  L15
    - 体内字面量："copyFile filename =="
- `void createDirectory(String str)`  L24
    - 体内字面量："FileOper" · "createDirectory: " · ", ret = "
- `void createFile(String str, String str2)`  L34
    - 体内字面量："FileOper" · "directoryPath+fileName =" · "FileOper" · "file is not exists,need to create!" · "FileOper" · "FileNotFoundException" · "FileOper" · "IOException"
- `void readInputStream(String str, InputStream inputStream)`  L53
    - 体内字面量："readInputStream" · "FileNotFoundException" · "readInputStream" · "IOException"
### `com.icatchtek.baseutil.io.FileUtil`
L22 · [class] public FileUtil · `com/icatchtek/baseutil/io/FileUtil.java`

字段/常量（40）：
- `FileOutputStream fileOutputStream`  L27
- `FileInputStream fileInputStream = null`  L28
- `byte[] bArr = new byte[1024]`  L38
- `String str2 = "<binary/metadata>"`  L142
- `InputStream inputStreamOpen`  L162
- `String str2 = null`  L163
- `?? r0 = 0`  L169
- `byte[] bArr = new byte[1024]`  L176
- `FileInputStream fileInputStreamOpenFileInput`  L243
- `String str2 = null`  L244
- `?? r1 = 0`  L250
- `byte[] bArr = new byte[1024]`  L260
- `FileInputStream fileInputStream`  L324
- `?? r0 = 0`  L325
- `byte[] bArr = new byte[1024]`  L334
- `?? r6`  L417
- `ByteArrayOutputStream byteArrayOutputStream`  L418
- `Parcelable parcelable`  L419
- `?? r0 = 0`  L420
- `ByteArrayOutputStream byteArrayOutputStream2 = null`  L421
- `byte[] bArr = new byte[4096]`  L430
- `?? r6`  L569
- `ByteArrayOutputStream byteArrayOutputStream`  L570
- `ArrayList arrayList`  L571
- `?? r0 = 0`  L572
- `ByteArrayOutputStream byteArrayOutputStream2 = null`  L573
- `byte[] bArr = new byte[4096]`  L582
- `FileInputStream fileInputStream`  L707
- `Throwable th`  L708
- `ObjectInputStream objectInputStream`  L709
- `ObjectOutputStream objectOutputStream = null`  L793
- `FileOutputStream fileOutputStream`  L840
- `ObjectOutputStream objectOutputStream = null`  L852
- `boolean z = false`  L925
- `FileOutputStream fileOutputStreamOpenFileOutput = null`  L926
- `FileOutputStream fileOutputStream = null`  L968
- `boolean z = false`  L1024
- `FileOutputStream fileOutputStreamOpenFileOutput = null`  L1025
- `boolean z = false`  L1071
- `FileOutputStream fileOutputStreamOpenFileOutput = null`  L1072

方法（16）：
- `boolean copy(String str, String str2)`  L26
- `boolean deleteFile(Context context, String str)`  L131
- `boolean exists(Context context, String str)`  L135
- `String getFromAssets(Context context, String str)`  L139
- `String readAssets(Context context, String str)`  L161
- `String readFile(Context context, String str)`  L242
- `String readFile(String str)`  L323
- `Parcelable readParcelable(Context context, String str, ClassLoader classLoader)`  L416
- `List<Parcelable> readParcelableList(Context context, String str, ClassLoader classLoader)`  L568
- `Serializable readSerializable(String str)`  L706
- `boolean saveSerializable(Context context, String str, Serializable serializable)`  L792
- `boolean saveSerializable(String str, Serializable serializable)`  L839
- `boolean writeFile(Context context, String str, String str2)`  L924
- `boolean writeFile(String str, String str2)`  L967
- `boolean writeParcelable(Context context, String str, Parcelable parcelable)`  L1023
- `boolean writeParcelableList(Context context, String str, List<Parcelable> list)`  L1070