# idGoLive — 类与成员明细：com.icatchtek.baseutil.imageloader

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.imageloader.ImageLoaderConfig`
L18 · [class] public ImageLoaderConfig · `com/icatchtek/baseutil/imageloader/ImageLoaderConfig.java`

字段/常量（6）：
- `String TAG = "ImageLoaderConfig"`  L19
- `DiskCache diskCache`  L20
- `FileNameGenerator fileNameGenerator`  L21
- `DisplayImageOptions options`  L22
- `DiskCache diskCache2 = diskCache`  L25
- `File file`  L45

方法（9）：
- `void clearDiskCache()`  L24
- `DisplayImageOptions getDefaultDisplayOptions()`  L33
- `DisplayImageOptions getDefaultDisplayOptions(int i)`  L37
- `Bitmap getDiskCache(String str)`  L44
- `File getDiskCacheFile(String str)`  L54
- `DisplayImageOptions getSingletonDisplayOptions()`  L61
- `void initImageLoader(Context context, ImageDownloader imageDownloader)`  L72
- `void removeDiskCache(String str)`  L89
    - 体内字面量："removeDiskCache ret:" · " url:"
- `boolean saveDiskCache(String str, Bitmap bitmap)`  L96
    - 体内字面量："saveDiskCache ret:" · " url:" · "saveDiskCache IOException e:"
### `com.icatchtek.baseutil.imageloader.ImageLoaderUtil`
L21 · [class] public ImageLoaderUtil · `com/icatchtek/baseutil/imageloader/ImageLoaderUtil.java`

字段/常量（23）：
- `float f5 = f3 * 0.5f`  L34
- `float f6 = locationInfo.left - f5`  L35
- `float f7 = f6 < 0.0f ? 0.0f : f6`  L36
- `float f8 = f4 * 0.5f`  L37
- `float f9 = locationInfo.top - f8`  L38
- `float f10 = f9 < 0.0f ? 0.0f : f9`  L39
- `float width = locationInfo.left + locationInfo.width + f5`  L40
- `float f11 = width`  L44
- `float height = locationInfo.top + locationInfo.height + f8`  L45
- `float f = locationInfo.left * width`  L63
- `float f2 = locationInfo.top * height`  L64
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L103
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L111
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L119
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L135
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L143
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L151
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L167
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L175
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L183
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L214
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L222
- `MyLoadingListener myLoadingListener2 = myLoadingListener`  L230

方法（29）：
- `void ImageDrawRect(Canvas canvas, Paint paint, LocationInfo locationInfo, float f, float f2, int i)`  L31
- `void drawRectangles(ImageView imageView, Bitmap bitmap, List<LocationInfo> list)`  L55
    - 体内字面量："drawRectangles" · "Bitmap width = " · ", height = " · ", scaleX = " · ", scaleY = "
- `DisplayImageOptions getDefaultDisplayOptions(int i)`  L75
- `DisplayImageOptions getDelayDisplayOptions(int i, int i2)`  L79
- `DisplayImageOptions getRoundedDisplayOptions()`  L83
- `void loadImageView(String str, ImageView imageView)`  L87
- `void loadImageView(String str, ImageView imageView, int i)`  L91
- `void loadImageView(String str, ImageView imageView, int i, int i2, final MyLoadingListener myLoadingListener)`  L95
- `void onLoadingCancelled(String str2, View view)`  L98 @Override
- `void onLoadingComplete(String str2, View view, Bitmap bitmap)`  L102 @Override
- `void onLoadingFailed(String str2, View view, FailReason failReason)`  L110 @Override
- `void onLoadingStarted(String str2, View view)`  L118 @Override
- `void loadImageView(String str, ImageView imageView, int i, final MyLoadingListener myLoadingListener)`  L127
- `void onLoadingCancelled(String str2, View view)`  L130 @Override
- `void onLoadingComplete(String str2, View view, Bitmap bitmap)`  L134 @Override
- `void onLoadingFailed(String str2, View view, FailReason failReason)`  L142 @Override
- `void onLoadingStarted(String str2, View view)`  L150 @Override
- `void loadImageView(String str, ImageView imageView, final MyLoadingListener myLoadingListener)`  L159
- `void onLoadingCancelled(String str2, View view)`  L162 @Override
- `void onLoadingComplete(String str2, View view, Bitmap bitmap)`  L166 @Override
- `void onLoadingFailed(String str2, View view, FailReason failReason)`  L174 @Override
- `void onLoadingStarted(String str2, View view)`  L182 @Override
- `void loadImageViewForDevice(String str, String str2, ImageView imageView)`  L191
- `void loadImageViewNoCache(String str, ImageView imageView)`  L202
- `void loadRoundedImageView(String str, ImageView imageView, final MyLoadingListener myLoadingListener)`  L206
- `void onLoadingCancelled(String str2, View view)`  L209 @Override
- `void onLoadingComplete(String str2, View view, Bitmap bitmap)`  L213 @Override
- `void onLoadingFailed(String str2, View view, FailReason failReason)`  L221 @Override
- `void onLoadingStarted(String str2, View view)`  L229 @Override
### `com.icatchtek.baseutil.imageloader.ImageLoaderUtil$MyLoadingListener`
L23 · [interface] public MyLoadingListener · `com/icatchtek/baseutil/imageloader/ImageLoaderUtil.java`

方法（3）：
- `void onLoadingComplete(String str, View view, Bitmap bitmap)`  L24
- `void onLoadingFailed(String str, View view)`  L26
- `void onLoadingStarted(String str, View view)`  L28
### `com.icatchtek.baseutil.imageloader.ImageUri`
L10 · [enum] public ImageUri · `com/icatchtek/baseutil/imageloader/ImageUri.java`

字段/常量（8）：
- `String scheme`  L23
- `String uriPrefix`  L24
- `String str2 = "<binary/metadata>"`  L79
- `long jLongValue = 0`  L80
- `ImageUri imageUri = MSGFILE`  L120
- `ImageUri imageUri`  L128
- `ImageUri imageUri2 = TUTK`  L129
- `ImageUri imageUri = DEVICEMSGFILE`  L137

枚举常量（27）：
- `HTTP("http")`  L11
- `HTTPS(TournamentShareDialogURIBuilder.scheme)`  L12
- `FILE(ShareInternalUtility.STAGING_PARAM)`  L13
- `CONTENT("content")`  L14
- `ASSETS("assets")`  L15
- `DRAWABLE("drawable")`  L16
- `DATABASE("database")`  L17
- `TUTK("tutk")`  L18
- `MSGFILE("msgfile")`  L19
- `DEVICEMSGFILE("devicemsgfile")`  L20
- `UNKNOWN("<binary/metadata>")`  L21
- `ImageUri(String str)`  L26
- `for(String str2 : str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR))`  L48
- `if(strArrSplit.length == 2 && strArrSplit[0].equals("uid"))`  L50
- `for(String str2 : str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR))`  L58
- `if(strArrSplit.length == 2 && strArrSplit[0].equals("msgid"))`  L60
- `if(str != null)`  L68
- `for(ImageUri imageUri : values())`  L69
- `if(imageUri.belongsTo(str))`  L70
- `for(String str3 : str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR))`  L81
- `if(strArrSplit.length == 2)`  L83
- `if(strArrSplit[0].equals("uid"))`  L84
- `if(belongsTo(str))`  L98
- `if(this == DEVICEMSGFILE)`  L105
- `if(this == imageUri)`  L121
- `if(this == imageUri2 || this == (imageUri = DATABASE))`  L130
- `if(this == imageUri)`  L138

方法（16）：
- `boolean belongsTo(String str)`  L31
- `String converDeviceMsgInfo(String str, long j)`  L35
    - 体内字面量："/uid=" · "/timeInSecs=" · "/thumb_" · ".jpg"
- `String converFileInfo(String str, int i, int i2)`  L39
    - 体内字面量："/uid=" · "/fileHandle=" · "/thumbSize=" · "/thumb_" · ".jpg"
- `String converMsgInfo(String str, int i)`  L43
    - 体内字面量："/uid=" · "/msgid=" · "/thumb_" · ".jpg"
- `String getMsgUid(String str)`  L47
    - 体内字面量："=" · "uid"
- `int getMsgid(String str)`  L57
    - 体内字面量："=" · "msgid"
- `ImageUri ofUri(String str)`  L67
- `PushMessage parseDeviceMsgInfoStr(String str)`  L78
- `String crop(String str)`  L97
    - 体内字面量："URI [%1$s] doesn't have expected scheme [%2$s]"
- `PushMessage getDeviceMsgOfUri(String str)`  L104
- `String getScheme()`  L111
- `String getUri(String str)`  L115
- `String getUri(String str, int i)`  L119
- `String getUri(String str, int i, int i2)`  L127
- `String getUri(String str, long j)`  L136
- `String getUriPrefix()`  L144
### `com.icatchtek.baseutil.imageloader.Md5FileNameGeneratorMatchFaceName`
L10 · [class] public Md5FileNameGeneratorMatchFaceName · implements `FileNameGenerator` · `com/icatchtek/baseutil/imageloader/Md5FileNameGeneratorMatchFaceName.java`

字段/常量（2）：
- `String HASH_ALGORITHM = "MD5"`  L11
- `int RADIX = 36`  L12

方法（2）：
- `byte[] getMD5(byte[] bArr)`  L14
- `String generate(String str)`  L26 @Override
    - 体内字面量："?" · "?"