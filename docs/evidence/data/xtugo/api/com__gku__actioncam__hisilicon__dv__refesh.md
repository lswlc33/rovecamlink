# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.refesh

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 3 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.refesh.AlbumItemModel`
L7 · [class] public AlbumItemModel · implements `Parcelable` · `com/gku/actioncam/hisilicon/dv/refesh/AlbumItemModel.java`

字段/常量（9）：
- `int TYPE_HD_VIDEO = 3`  L21
- `int TYPE_IMAGE = 1`  L22
- `int TYPE_VIDEO = 2`  L23
- `boolean IsSelect`  L24
- `boolean isNeedShowSelect`  L25
- `long length`  L26
- `long mAddedDate`  L27
- `String mPath`  L28
- `int mType`  L29

方法（22）：
- `AlbumItemModel createFromParcel(Parcel source)`  L11 @Override
- `AlbumItemModel[] newArray(int size)`  L17 @Override
- `int describeContents()`  L32 @Override
- `public AlbumItemModel(String path, long addedDate, int type)`  L36
- `public AlbumItemModel()`  L42
- `String getPath()`  L45
- `void setPath(String path)`  L49
- `long getAddedDate()`  L53
- `void setAddedDate(long addedDate)`  L57
- `int getType()`  L61
- `void setType(int type)`  L65
- `boolean isImage()`  L69
- `boolean isVideo()`  L73
- `boolean isHDVideo()`  L77
- `long getLength()`  L81
- `void setLength(long length)`  L85
- `boolean isSelect()`  L89
- `void setSelect(boolean select)`  L93
- `boolean isNeedShowSelect()`  L97
- `void setNeedShowSelect(boolean needShowSelect)`  L101
- `void writeToParcel(Parcel dest, int flags)`  L106 @Override
- `protected AlbumItemModel(Parcel in)`  L112
### `com.gku.actioncam.hisilicon.dv.refesh.MediaScanTask`
L17 · [class] public MediaScanTask · extends `AsyncTask<Void, Void, List<AlbumItemModel>>` · `com/gku/actioncam/hisilicon/dv/refesh/MediaScanTask.java`

字段/常量（22）：
- `boolean sIsRefresh`  L18
- `int sRefreshCount`  L19
- `CallBack mCallBack`  L20
- `Context mContext`  L21
- `String mScanDir`  L22
- `int mType`  L23
- `boolean z = sIsRefresh`  L30
- `int i = sRefreshCount + 1`  L31
- `CallBack callBack = this.mCallBack`  L54
- `File[] fileArrListFiles`  L77
- `StringBuilder sb`  L122
- `AlbumItemModel albumItemModel`  L123
- `int length = strArr.length`  L131
- `String str = strArr[i]`  L133
- `Uri uri`  L187
- `Throwable th`  L188
- `Exception exc`  L189
- `Cursor cursorQuery`  L190
- `AlbumItemModel albumItemModel`  L191
- `String[] strArr = {"_data", "date_added"}`  L192
- `Uri uri2 = uri`  L198
- `?? r3 = 0`  L199

方法（13）：
- `boolean isRefresh()`  L29
- `void refresh()`  L40
- `public MediaScanTask(Context context, String scanDir, int type)`  L44
- `void onPostExecute(List<AlbumItemModel> albumItemModels)`  L52 @Override
- `List<AlbumItemModel> doInBackground(Void... params)`  L63 @Override
    - 体内字面量："45613121" · "doInBackground:  -------------------   getData    " · "5656362" · "doInBackground:  ---------11111-------------------   "
- `List<AlbumItemModel> getMediaData2(String scanDir)`  L76
- `boolean isVideo(File file)`  L94
    - 体内字面量："MP4" · "mp4"
- `boolean isImage(File file)`  L103
    - 体内字面量："jpg" · "png" · "dng"
- `boolean isHDVideo(File file)`  L112
    - 体内字面量："s.MP4"
- `List<AlbumItemModel> getMediaData(String scanDir, int type)`  L121
- `List<AlbumItemModel> getMediaData(Context context, String scanDir, int type)`  L186
- `void release()`  L267
- `void setResultCallback(CallBack callback)`  L272
### `com.gku.actioncam.hisilicon.dv.refesh.MediaScanTask$CallBack`
L25 · [interface] public CallBack · `com/gku/actioncam/hisilicon/dv/refesh/MediaScanTask.java`

方法（1）：
- `void onScanResultCallback(List<AlbumItemModel> data)`  L26