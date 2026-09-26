# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.bean

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 11 个文件 / 12 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.bean.SSBatteryInfo`
L7 · [class] public SSBatteryInfo · implements `Parcelable` · `com/gku/actioncam/sigmastar/bean/SSBatteryInfo.java`

字段/常量（3）：
- `boolean bAC`  L21
- `boolean bCharging`  L22
- `int capacity`  L23

方法（8）：
- `SSBatteryInfo createFromParcel(Parcel in)`  L11 @Override
- `SSBatteryInfo[] newArray(int size)`  L17 @Override
- `int describeContents()`  L26 @Override
- `public SSBatteryInfo(int capacity, boolean bCharging, boolean bAC)`  L30
- `public SSBatteryInfo()`  L36
- `protected SSBatteryInfo(Parcel in)`  L39
- `String toString()`  L45
    - 体内字面量："SSBatteryInfo{capacity=" · ", bCharging=" · ", bAC=" · "}"
- `void writeToParcel(Parcel parcel, int i)`  L50 @Override
### `com.gku.actioncam.sigmastar.bean.SSDownloadState`
L7 · [class] public SSDownloadState · implements `Parcelable` · `com/gku/actioncam/sigmastar/bean/SSDownloadState.java`

字段/常量（8）：
- `String ALL_DOWNLOAD_FINISH = "ALL_DOWNLOAD_FINISH"`  L8
- `String DOWNLOADING = "DOWNLOADING"`  L22
- `String DOWNLOAD_FAILURE = "DOWNLOAD_FAILURE"`  L23
- `String FINISH_DOWNLOAD = "FINISH_DOWNLOAD"`  L24
- `String START_DOWNLOAD = "START_DOWNLOAD"`  L25
- `String fileName`  L26
- `int progress`  L27
- `String state`  L28

方法（14）：
- `SSDownloadState createFromParcel(Parcel in)`  L12 @Override
- `SSDownloadState[] newArray(int size)`  L18 @Override
- `int describeContents()`  L31 @Override
- `public SSDownloadState(String state)`  L35
- `public SSDownloadState(String state, String fileName, int progress)`  L40
- `protected SSDownloadState(Parcel in)`  L46
- `void writeToParcel(Parcel dest, int flags)`  L54 @Override
- `String getState()`  L60
- `void setState(String state)`  L64
- `int getProgress()`  L68
- `void setProgress(int progress)`  L72
- `String getFileName()`  L76
- `void setFileName(String fileName)`  L80
- `String toString()`  L84
    - 体内字面量："SSDownloadState{state='" · "', progress=" · ", fileName='" · "'}"
### `com.gku.actioncam.sigmastar.bean.SSecondItemBean`
L7 · [class] public SSecondItemBean · `com/gku/actioncam/sigmastar/bean/SSecondItemBean.java`

字段/常量（2）：
- `String curValue`  L8
- `List<String> itemList`  L9

方法（6）：
- `public SSecondItemBean(List<String> itemList, String curValue)`  L11
- `List<String> getItemList()`  L16
- `void setItemList(ArrayList<String> itemList)`  L20
- `String getCurValue()`  L24
- `void setCurValue(String curValue)`  L28
- `String toString()`  L32
    - 体内字面量："SSecondItemBean{itemList=" · ", curValue='" · "'}"
### `com.gku.actioncam.sigmastar.bean.SSettingItemBean`
L6 · [class] public SSettingItemBean · `com/gku/actioncam/sigmastar/bean/SSettingItemBean.java`

字段/常量（3）：
- `String itemName`  L7
- `String itemValue`  L8
- `SettingRecycleAdapter.SettingItemType type`  L9

方法（8）：
- `public SSettingItemBean(SettingRecycleAdapter.SettingItemType type, String itemName)`  L11
- `SettingRecycleAdapter.SettingItemType getType()`  L16
- `void setType(SettingRecycleAdapter.SettingItemType type)`  L20
- `String getItemName()`  L24
- `void setItemName(String itemName)`  L28
- `String getItemValue()`  L32
- `void setItemValue(String itemValue)`  L36
- `String toString()`  L40
    - 体内字面量："SSettingItemBean{type=" · ", itemName='" · "', itemValue='" · "'}"
### `com.gku.actioncam.sigmastar.bean.SSFileInfoBean`
L17 · [class] public SSFileInfoBean · implements `Parcelable` · `com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java`

字段/常量（13）：
- `boolean bSelect`  L31
- `String cachePath`  L32
- `String createTime`  L33
- `String fileName`  L34
- `String fileSize`  L35
- `boolean isDownload`  L36
- `String localPath`  L37
- `String localThumbPath`  L38
- `String originPath`  L39
- `String remotePath`  L40
- `String thumbPath`  L41
- `String videoTime`  L42
- `String str = this.thumbPath`  L89

方法（30）：
- `SSFileInfoBean createFromParcel(Parcel in)`  L21 @Override
- `SSFileInfoBean[] newArray(int size)`  L27 @Override
- `int describeContents()`  L45 @Override
- `public SSFileInfoBean(String originPath)`  L49
- `protected SSFileInfoBean(Parcel in)`  L56
- `void setLocalPath(String localPath)`  L73
- `String getThumbPath()`  L77
    - 体内字面量："http://%s/thumb%s" · "CV75" · "http://%s/%s"
- `String getOriginPath()`  L97
- `String getFileName()`  L101
- `void setFileName(String fileName)`  L105
- `String getRemotePath()`  L109
    - 体内字面量："http://%s%s" · "s.MP4" · "-s.MP4" · "s.mp4" · "-s.mp4" · "CV75" · "http://%s%s" · "/tmp/SD0" · "s.MP4" · "/tmp/SD0" · "s.mp4" · "/tmp/SD0" · "http://%s/%s" · "s.MP4" · "s.mp4"
- `String getPlayPath()`  L149
    - 体内字面量："http://%s%s" · "-s.MP4" · "-s.mp4" · "CV75" · "http://%s%s" · "/tmp/SD0" · "http://%s/%s"
- `String getCreateTime()`  L163
- `void setCreateTime(String createTime)`  L167
- `String getFileSize()`  L171
- `void setFileSize(String fileSize)`  L175
- `String getVideoTime()`  L179
- `void setVideoTime(String videoTime)`  L183
- `String getLocalPath()`  L187
    - 体内字面量："/" · "_"
- `String getLocalPathLRV()`  L199
    - 体内字面量："/" · "s.MP4" · "s.mp4"
- `String getCachePath()`  L203
    - 体内字面量："/"
- `boolean isbSelect()`  L209
- `void setbSelect(boolean bSelect)`  L213
- `boolean isDownloaded()`  L217
- `void setDownloaded(boolean download)`  L221
- `String getLocalThumbPath()`  L225
- `void setLocalThumbPath(String localThumbPath)`  L229
- `String toString()`  L233
    - 体内字面量："SSFileInfoBean{originPath='" · "', fileName='" · "', remotePath='" · "', localPath='" · "', cachePath='" · "', thumbPath='" · "', bSelect=" · ", createTime='" · "', fileSize='" · "', videoTime='" · "', localThumbPath='" · "', isDownload=" · "}"
- `void writeToParcel(Parcel parcel, int i)`  L238 @Override
- `boolean equals(Object o)`  L253
### `com.gku.actioncam.sigmastar.bean.SSListDialogRecycleItemBean`
L4 · [class] public SSListDialogRecycleItemBean · `com/gku/actioncam/sigmastar/bean/SSListDialogRecycleItemBean.java`

字段/常量（2）：
- `boolean bSelected`  L5
- `String name`  L6

方法（7）：
- `public SSListDialogRecycleItemBean(String name)`  L8
- `public SSListDialogRecycleItemBean(String name, boolean bSelected)`  L13
- `String getName()`  L18
- `void setName(String name)`  L22
- `boolean isbSelected()`  L26
- `void setSelected(boolean bSelected)`  L30
- `String toString()`  L34
    - 体内字面量："SSListDialogRecycleItemBean{name='" · "', bSelected=" · "}"
### `com.gku.actioncam.sigmastar.bean.SSPreviewSaveInfo`
L9 · [class] public SSPreviewSaveInfo · implements `Parcelable` · `com/gku/actioncam/sigmastar/bean/SSPreviewSaveInfo.java`

字段/常量（10）：
- `HashMap<String, ArrayList<String>> allWorkMode`  L23
- `SSBatteryInfo batteryInfo`  L24
- `String curMode`  L25
- `String fastSettingValue`  L26
- `int ivCommandRes`  L27
- `int modeImageRes`  L28
- `int quickStoriesRecordTime`  L29
- `String resolutionString`  L30
- `SSTFCardInfo tfCardInfo`  L31
- `SSystemWorkState workState`  L32

方法（27）：
- `SSPreviewSaveInfo createFromParcel(Parcel in)`  L13 @Override
- `SSPreviewSaveInfo[] newArray(int size)`  L19 @Override
- `int describeContents()`  L35 @Override
- `public SSPreviewSaveInfo(String curMode, SSystemWorkState workState, int ivCommandRes, String resolutionString, int modeImageRes, String fastSettingValue, int quickStoriesRecordTime, SSTFCardInfo tfCardInfo, SSBatteryInfo batteryInfo, HashMap<String, ArrayList<String>> allWorkMode)`  L39
- `protected SSPreviewSaveInfo(Parcel in)`  L52
- `void writeToParcel(Parcel dest, int flags)`  L66 @Override
- `String getCurMode()`  L79
- `void setCurMode(String curMode)`  L83
- `SSystemWorkState getWorkState()`  L87
- `void setWorkState(SSystemWorkState workState)`  L91
- `int getIvCommandRes()`  L95
- `void setIvCommandRes(int ivCommandRes)`  L99
- `String getResolutionString()`  L103
- `void setResolutionString(String resolutionString)`  L107
- `int getModeImageRes()`  L111
- `void setModeImageRes(int modeImageRes)`  L115
- `String getFastSettingValue()`  L119
- `void setFastSettingValue(String fastSettingValue)`  L123
- `int getQuickStoriesRecordTime()`  L127
- `void setQuickStoriesRecordTime(int quickStoriesRecordTime)`  L131
- `SSTFCardInfo getTfCardInfo()`  L135
- `void setTfCardInfo(SSTFCardInfo tfCardInfo)`  L139
- `SSBatteryInfo getBatteryInfo()`  L143
- `void setBatteryInfo(SSBatteryInfo batteryInfo)`  L147
- `HashMap<String, ArrayList<String>> getAllWorkMode()`  L151
- `void setAllWorkMode(HashMap<String, ArrayList<String>> allWorkMode)`  L155
- `String toString()`  L159
    - 体内字面量："SSPreviewSaveInfo{curMode='" · "', workState=" · ", ivCommandRes=" · ", resolutionString='" · "', modeImageRes=" · ", fastSettingValue='" · "', quickStoriesRecordTime=" · ", tfCardInfo=" · ", batteryInfo=" · ", allWorkMode=" · "}"
### `com.gku.actioncam.sigmastar.bean.SSRemoteFileInfo`
L7 · [class] public SSRemoteFileInfo · `com/gku/actioncam/sigmastar/bean/SSRemoteFileInfo.java`

字段/常量（4）：
- `String createTime`  L8
- `String path`  L9
- `String size`  L10
- `String time`  L11

方法（12）：
- `String getPath()`  L13
- `void setPath(String path)`  L17
- `String getSize()`  L21
- `void setSize(String size)`  L25
- `String getCreateTime()`  L29
- `void setCreateTime(String createTime)`  L33
- `String getTime()`  L37
- `void setTime(String time)`  L41
- `String formatSize(String size)`  L45
- `String formatTime(String time)`  L49
    - 体内字面量："00" · ":" · ":"
- `String formatShowSize(long size)`  L56
    - 体内字面量："%.1f" · "%.1f B" · "%.1f KB" · "%.1f MB" · "%.1f GB"
- `String toString()`  L69
    - 体内字面量："SSRemoteFileInfo{path='" · "', size='" · "', createTime='" · "', time='" · "'}"
### `com.gku.actioncam.sigmastar.bean.SSTFCardInfo`
L7 · [class] public SSTFCardInfo · implements `Parcelable` · `com/gku/actioncam/sigmastar/bean/SSTFCardInfo.java`

字段/常量（3）：
- `TFCardState sdState`  L21
- `int total`  L22
- `int used`  L23

方法（8）：
- `SSTFCardInfo createFromParcel(Parcel in)`  L11 @Override
- `SSTFCardInfo[] newArray(int size)`  L17 @Override
- `int describeContents()`  L33 @Override
- `protected SSTFCardInfo(Parcel in)`  L37
- `void writeToParcel(Parcel dest, int flags)`  L43 @Override
- `public SSTFCardInfo()`  L48
- `public SSTFCardInfo(TFCardState sdState, int total, int used)`  L51
- `String toString()`  L57
    - 体内字面量："SSTFCardInfo{sdState=" · ", total=" · ", used=" · "}"
### `com.gku.actioncam.sigmastar.bean.SSTFCardInfo$TFCardState`
L25 · [enum] public TFCardState · `com/gku/actioncam/sigmastar/bean/SSTFCardInfo.java`

枚举常量（3）：
- `NORMAL()`  L26
- `FULL()`  L27
- `NONE()`  L28
### `com.gku.actioncam.sigmastar.bean.SSWiFiInfo`
L4 · [class] public SSWiFiInfo · `com/gku/actioncam/sigmastar/bean/SSWiFiInfo.java`

字段/常量（2）：
- `String SSID`  L5
- `String password`  L6

方法（4）：
- `public SSWiFiInfo(String SSID, String password)`  L8
- `String getSSID()`  L13
- `String getPassword()`  L17
- `String toString()`  L21
    - 体内字面量："SSWiFiInfo{SSID='" · "', password='" · "'}"
### `com.gku.actioncam.sigmastar.bean.SSystemWorkState`
L7 · [class] public SSystemWorkState · implements `Parcelable` · `com/gku/actioncam/sigmastar/bean/SSystemWorkState.java`

字段/常量（17）：
- `int SS_EVENT_AMBA_PHOTO_END = 268632078`  L21
- `int SS_EVENT_AMBA_PHOTO_START = 268632077`  L22
- `int SS_EVENT_AMBA_VIDEO_END = 268763138`  L23
- `int SS_EVENT_AMBA_VIDEO_START = 268763137`  L24
- `int SS_EVENT_END = 11700002`  L25
- `int SS_EVENT_MODE = 11800001`  L26
- `int SS_EVENT_PHOTO_END = 4`  L27
- `int SS_EVENT_PHOTO_START = 3`  L28
- `int SS_EVENT_START = 11700001`  L29
- `int SS_EVENT_VIDEO_END = 2`  L30
- `int SS_EVENT_VIDEO_START = 1`  L31
- `int SS_STATE_STANDBY = 21`  L32
- `int SS_STATE_WORKING = 20`  L33
- `long event`  L34
- `int pastTime`  L35
- `int state`  L36
- `String workMode`  L37

方法（11）：
- `SSystemWorkState createFromParcel(Parcel in)`  L11 @Override
- `SSystemWorkState[] newArray(int size)`  L17 @Override
- `int describeContents()`  L40 @Override
- `public SSystemWorkState(String workMode, int state, long event, int pastTime)`  L44
- `protected SSystemWorkState(Parcel in)`  L51
- `void writeToParcel(Parcel dest, int flags)`  L59 @Override
- `String getWorkMode()`  L66
- `int getState()`  L70
- `long getEvent()`  L74
- `int getPastTime()`  L78
- `String toString()`  L82
    - 体内字面量："SSystemWorkState{workMode='" · "', state=" · ", event=" · ", pastTime=" · "}"