# idGoLive — 类与成员明细：com.icatch.golive.entity

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 4 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.entity.EmailSender`
L18 · [class] public EmailSender · `com/icatch/golive/entity/EmailSender.java`

字段/常量（5）：
- `Message message`  L19
- `MimeMultipart multipart`  L20
- `Session session`  L22
- `Message message = this.message`  L39
- `InternetAddress[] internetAddressArr = new InternetAddress[strArr.length]`  L62

方法（5）：
- `void addAttachment(String str)`  L24
- `void sendEmail(String str, String str2, String str3)`  L33
    - 体内字面量："smtp"
- `void setMessage(String str, String str2, String str3)`  L44
    - 体内字面量："text/html;charset=gbk"
- `void setProperties(String str, String str2)`  L52
    - 体内字面量："mail.smtp.host" · "mail.smtp.post" · "mail.smtp.auth" · "mixed"
- `void setReceiver(String[] strArr)`  L61
### `com.icatch.golive.entity.FileInfo`
L9 · [class] public FileInfo · implements `Serializable` · `com/icatch/golive/entity/FileInfo.java`

字段/常量（12）：
- `String kTakePhotoType = "kTakePhotoType"`  L10
- `String kVideoNormalType = "kVideoNormalType"`  L11
- `String kVideoWarningType = "kVideoWarningType"`  L12
- `String attr`  L13
- `String fpath`  L14
- `String furl`  L15
- `String name`  L16
- `String size`  L17
- `String time`  L18
- `String timecode`  L19
- `String turl`  L20
- `String str4 = strArrSplit[strArrSplit.length - 1]`  L37

方法（13）：
- `public FileInfo(String str, String str2, int i, long j, long j2, long j3, int i2, String str3)`  L22
    - 体内字面量："\\." · "\\." · "/app/getthumbnail?file="
- `public FileInfo(String str, String str2, String str3, int i)`  L35
- `public FileInfo(String str, String str2, String str3, String str4, String str5, String str6)`  L46
    - 体内字面量："\\\\" · "http://192.168.1.254/Novatek/" · "?custom=1&cmd=4002"
- `String getAttr()`  L58
- `String getFpath()`  L62
- `String getFurl()`  L66
    - 体内字面量："FileInfoGetFurl"
- `String getName()`  L71
- `String getSize()`  L75
- `String getSizeKeep2()`  L79
    - 体内字面量："#0.00" · "Novatek" · "MB" · "getSizeKeep2"
- `String getTime()`  L90
- `String getTimecode()`  L94
- `String getTurl()`  L98
- `String toString()`  L102
    - 体内字面量："FileInfo{name='" · "', fpath='" · "', size='" · "', timecode='" · "', time='" · "', attr='" · "'}"
### `com.icatch.golive.entity.FirmwareInfo`
L16 · [class] public FirmwareInfo · implements `Serializable` · `com/icatch/golive/entity/FirmwareInfo.java`

字段/常量（8）：
- `String KEY_FIRMWARE_LIST = "firmware_list"`  L17
- `String PREFS_NAME = "firmware_prefs"`  L18
- `String download`  L20
- `String name`  L21
- `String product`  L22
- `String region`  L23
- `String version`  L24
- `String str = strArrSplit[strArrSplit.length - 1]`  L104

方法（11）：
- `public FirmwareInfo()`  L26
- `public FirmwareInfo(String str, String str2, String str3, String str4, String str5)`  L29
- `void clearFiles(Context context)`  L37
    - 体内字面量："/Firmware/"
- `List<FirmwareInfo> getFirmwareList(Context context)`  L46
    - 体内字面量："/Firmware/"
- `void saveFirmwareList(Context context, List<FirmwareInfo> list)`  L71
- `String getDownload()`  L75
- `String getName()`  L79
- `String getProduct()`  L83
- `String getRegion()`  L87
- `String getVersion()`  L91
- `void removeFile(Context context)`  L95
### `com.icatch.golive.entity.LanguageInfo`
L4 · [class] public LanguageInfo · `com/icatch/golive/entity/LanguageInfo.java`

字段/常量（6）：
- `String kLanguageEn = "language_english_new"`  L5
- `String kLanguageJa = "language_japanese_new"`  L6
- `String kLanguageKr = "language_korean_new"`  L7
- `String kLanguageTh = "language_thai_new"`  L8
- `String kLanguageZh = "language_zh_cn_new"`  L9
- `String kLanguageZhHant = "language_zh_hant_new"`  L10