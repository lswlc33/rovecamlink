# XTU GO — 类与成员明细：com.gku.loginmodule.manage

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 9 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.manage.DeviceConnectManager`
L14 · [class] public final DeviceConnectManager · `com/gku/loginmodule/manage/DeviceConnectManager.java`
注解：

字段/常量（3）：
- `DeviceConnectManager instance`  L18
- `boolean inConnectDevice`  L19
- `ArrayList<OnDeviceConnectListener> onDeviceConnectListenerList`  L20

方法（7）：
- ` DeviceConnectManager(DefaultConstructorMarker defaultConstructorMarker)`  L28
- `private DeviceConnectManager()`  L32
    - 体内字面量："Lcom/gku/loginmodule/manage/DeviceConnectManager$Companion;" · "<init>" · "()V" · "instance" · "Lcom/gku/loginmodule/manage/DeviceConnectManager;" · "getInstance" · "app_XTUGORelease"
- `void onConnect(boolean connectDevice)`  L56
    - 体内字面量："iterator(...)" · "next(...)"
- `void registerOnDeviceConnectStickyListener$default(DeviceConnectManager deviceConnectManager, OnDeviceConnectListener onDeviceConnectListener, boolean z, int i, Object obj)`  L67
- `void registerOnDeviceConnectStickyListener(OnDeviceConnectListener listener, boolean sticky)`  L74
    - 体内字面量："listener" · "xs, " · "register size = "
- `void registerOnDeviceConnectListener(OnDeviceConnectListener listener)`  L85
    - 体内字面量："listener" · "xs, " · "register size = "
- `void unOnDeviceConnectListener(OnDeviceConnectListener listener)`  L93
    - 体内字面量："listener"
### `com.gku.loginmodule.manage.DeviceConnectManager$Companion`
L38 · [class] public static final Companion · `com/gku/loginmodule/manage/DeviceConnectManager.java`
注解：

字段/常量（1）：
- `DeviceConnectManager deviceConnectManager = DeviceConnectManager.instance`  L50

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L39
- `private Companion()`  L43
- `DeviceConnectManager getInstance()`  L46
### `com.gku.loginmodule.manage.DeviceConnectManager$OnDeviceConnectListener`
L24 · [interface] public OnDeviceConnectListener · `com/gku/loginmodule/manage/DeviceConnectManager.java`
注解：

方法（1）：
- `void onDeviceConnecting(boolean isConnected)`  L25
### `com.gku.loginmodule.manage.DeviceVersionManager`
L47 · [class] public final DeviceVersionManager · `com/gku/loginmodule/manage/DeviceVersionManager.java`
注解：

字段/常量（36）：
- `DeviceVersionManager instance`  L51
- `HashMap<String, LocalDeviceVersionInfoBean> deviceMap`  L52
- `ConcurrentHashMap<String, DownloadTask> downloadTasks`  L53
- `boolean isAutoUpdate`  L54
- `int maxConcurrent`  L55
- `boolean needDownloadVersion`  L56
- `ArrayList<LocalDeviceVersionInfoBean> needUpdateDeviceList`  L57
- `OnDownloadMessageListener onDownloadMsgListener`  L58
- `OnDownloadStatusListener onDownloadStatusListener`  L59
- `List list2 = list`  L135
- `OnDownloadMessageListener onDownloadMessageListener = deviceVersionManager.onDownloadMsgListener`  L212
- `String str = hardware_version != null ? hardware_version : "<binary/metadata>"`  L266
- `ArrayList arrayList`  L290
- `GetDeviceNewestVersionResponse.DataBean data`  L291
- `DeviceVersionManager deviceVersionManager = DeviceVersionManager.this`  L296
- `OnDownloadMessageListener onDownloadMessageListener = DeviceVersionManager.this.onDownloadMsgListener`  L302
- `OnDownloadMessageListener onDownloadMessageListener2 = DeviceVersionManager.this.onDownloadMsgListener`  L307
- `DeviceVersionManager deviceVersionManager2 = DeviceVersionManager.this`  L317
- `OnDownloadStatusListener onDownloadStatusListener = DeviceVersionManager.this.onDownloadStatusListener`  L323
- `OnDownloadStatusListener onDownloadStatusListener = this.onDownloadStatusListener`  L433
- `boolean zRenameTo`  L461
- `DeviceVersionManager.OnDownloadStatusListener onDownloadStatusListener2 = this.onDownloadStatusListener`  L474
- `DeviceVersionManager.OnDownloadStatusListener onDownloadStatusListener3 = this.onDownloadStatusListener`  L480
- `DeviceVersionManager.OnDownloadStatusListener onDownloadStatusListener2 = this.onDownloadStatusListener`  L493
- `DeviceVersionManager.OnDownloadStatusListener onDownloadStatusListener2 = this.onDownloadStatusListener`  L505
- `DeviceVersionManager.OnDownloadStatusListener onDownloadStatusListener2 = this.onDownloadStatusListener`  L516
- `DeviceVersionManager.OnDownloadStatusListener onDownloadStatusListener2 = this.onDownloadStatusListener`  L527
- `Object next`  L537
- `Collection<DownloadTask> collection = collectionValues`  L580
- `int i = 0`  L581
- `LocalDeviceVersionInfoBean localDeviceVersionInfoBean = next`  L601
- `LocalDeviceVersionInfoBean localDeviceVersionInfoBean = next`  L616
- `String str = region`  L630
- `String str2 = File.separator`  L667
- `String str3 = File.separator`  L668
- `String str = version`  L702

方法（44）：
- ` DeviceVersionManager(DefaultConstructorMarker defaultConstructorMarker)`  L83
- `private DeviceVersionManager()`  L87
    - 体内字面量："Lcom/gku/loginmodule/manage/DeviceVersionManager$Companion;" · "<init>" · "()V" · "instance" · "Lcom/gku/loginmodule/manage/DeviceVersionManager;" · "getInstance" · "app_XTUGORelease"
- `void checkDeviceVersion$default(DeviceVersionManager deviceVersionManager, Boolean bool, int i, Object obj)`  L116
- `void checkDeviceVersion(Boolean needDownload)`  L123
- `void accept(Object obj)`  L127 @Override
- `void checkDeviceVersion$lambda$2(DeviceVersionManager deviceVersionManager, List list)`  L134
- `Object invoke(Object obj)`  L139 @Override
- `Object invoke(Object obj)`  L144 @Override
    - 体内字面量："<get-keys>(...)" · "\\s+" · "G" · "V1.0" · "xs, " · "deviceStr = " · ", regionStr = " · ", pcbrevisionStr = " · "toString(...)" · "toString(...)" · "toString(...)"
- `Comparable checkDeviceVersion$lambda$2$lambda$0(DeviceVersionInfo it)`  L219
    - 体内字面量："it"
- `Comparable checkDeviceVersion$lambda$2$lambda$1(DeviceVersionInfo it)`  L225
    - 体内字面量："it"
- `String getMapKey(DeviceVersionInfo item)`  L230
    - 体内字面量："getModel(...)" · "\\s+" · "-" · "G" · "-" · "V1.0" · "toString(...)"
- `String getServiceKey(GetDeviceNewestVersionResponse.DataBean.GetDeviceNewestVersionBean deviceNewestVersion)`  L260
- `void getNewestVersion(String model, String region, String hardVersion)`  L286
- `void onSuccess(GetDeviceNewestVersionResponse response)`  L289 @Override
- `void onFailure(Throwable e)`  L330 @Override
    - 体内字面量："xs, " · "getNewestVersion onFailure"
- `void handleDeviceVersion(GetDeviceNewestVersionResponse.DataBean.GetDeviceNewestVersionBean deviceNewestVersion)`  L337
    - 体内字面量："getCurVersion(...)" · "getVersion(...)" · "getFile_url(...)"
- `void handleDeviceEmpty()`  L364
- `void addDownloads(List<? extends LocalDeviceVersionInfoBean> downloadInfoBeans)`  L376
- `boolean addDownload$default(DeviceVersionManager deviceVersionManager, LocalDeviceVersionInfoBean localDeviceVersionInfoBean, boolean z, int i, Object obj)`  L383
- `boolean addDownload(LocalDeviceVersionInfoBean downloadInfoBean, boolean autoStart)`  L390
    - 体内字面量："downloadInfoBean" · "G" · "V1.0" · "getModel(...)" · "getNewVersion(...)" · "getDownloadUrl(...)" · "xs, " · "addDownload filePath = " · "getModel(...)" · "getDownloadUrl(...)" · ".tmp" · "getDownloadUrl(...)" · "getModel(...)"
- `void startDownload(String url, final String model)`  L427
- `void onFinished()`  L452 @Override
- `void onWaiting()`  L456 @Override
- `void onSuccess(File result)`  L460 @Override
- `void onError(Throwable ex, boolean isOnCallback)`  L490 @Override
- `void onCancelled(Callback.CancelledException ce)`  L503 @Override
- `void onStarted()`  L515 @Override
- `void onLoading(long total, long current, boolean isDownloading)`  L523 @Override
- `void tryStartNextPending()`  L536
- `boolean cancelDownload(String model)`  L555
    - 体内字面量："model"
- `void cancelDownloads(List<String> models)`  L569
    - 体内字面量："models"
- `int getActiveDownloadCount()`  L577
    - 体内字面量："<get-values>(...)"
- `LocalDeviceVersionInfoBean getDownloadVersionInfo(DeviceVersionInfo deviceVersionInfo)`  L594
    - 体内字面量："deviceVersionInfo" · "iterator(...)" · "next(...)"
- `LocalDeviceVersionInfoBean getDownloadVersionInfo(String model)`  L609
    - 体内字面量："model" · "iterator(...)" · "next(...)"
- `boolean hasDownloadZip(LocalDeviceVersionInfoBean downloadInfoBean)`  L624
    - 体内字面量："downloadInfoBean" · "G"
- `String getPathSave(String region, String hardware, String model, String version, String url)`  L644
    - 体内字面量："region" · "hardware" · "model" · "version" · "url"
- `String getPathDir(String region, String hardware, String model, String version)`  L655
    - 体内字面量："region" · "hardware" · "model" · "version" · "version"
- `File getCacheDir()`  L672
    - 体内字面量："mounted"
- `String getLocalVersionInfo(String version)`  L686
    - 体内字面量："version" · "\\d{8}" · "compile(...)" · "matcher(...)"
- `String getRemoteVersionInfo(String version)`  L700
    - 体内字面量："version"
- `void registerOnDownloadStatusListener(OnDownloadStatusListener listener)`  L710
    - 体内字面量："listener"
- `void unRegisterOnDownloadStatusListener()`  L715
- `void registerOnDownloadMessageListener(OnDownloadMessageListener listener)`  L719
    - 体内字面量："listener"
- `void unRegisterOnDownloadMessageListener()`  L724
### `com.gku.loginmodule.manage.DeviceVersionManager$Companion`
L98 · [class] public static final Companion · `com/gku/loginmodule/manage/DeviceVersionManager.java`
注解：

字段/常量（1）：
- `DeviceVersionManager deviceVersionManager = DeviceVersionManager.instance`  L110

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L99
- `private Companion()`  L103
- `DeviceVersionManager getInstance()`  L106
### `com.gku.loginmodule.manage.DeviceVersionManager$OnDownloadMessageListener`
L63 · [interface] public OnDownloadMessageListener · `com/gku/loginmodule/manage/DeviceVersionManager.java`
注解：

方法（1）：
- `void onNeedUpdateMsg(boolean needUpdate)`  L64
### `com.gku.loginmodule.manage.DeviceVersionManager$OnDownloadStatusListener`
L69 · [interface] public OnDownloadStatusListener · `com/gku/loginmodule/manage/DeviceVersionManager.java`
注解：

方法（6）：
- `void onCheckFinished()`  L70
- `void onDownloadEnd(String model)`  L72
- `void onDownloadFailed(String model)`  L74
- `void onDownloadPause(String model)`  L76
- `void onDownloadProgress(String model, long current, long total)`  L78
- `void onDownloadStart(String model)`  L80
### `com.gku.loginmodule.manage.DownloadTask`
L12 · [class] public final DownloadTask · `com/gku/loginmodule/manage/DownloadTask.java`
注解：

字段/常量（16）：
- `Callback.Cancelable cancelable`  L13
- `long current`  L14
- `String filePath`  L15
- `String model`  L16
- `int progress`  L17
- `Status status`  L18
- `String tempFilePath`  L19
- `long total`  L20
- `String url`  L21
- `long j3 = j2`  L51
- `long j4 = j`  L52
- `Status status2 = status`  L53
- `int i3 = i`  L54
- `Callback.Cancelable cancelable2 = cancelable`  L55
- `String str5 = str3`  L56
- `Callback.Cancelable cancelable = this.cancelable`  L127

方法（30）：
- `DownloadTask copy$default(DownloadTask downloadTask, String str, String str2, String str3, String str4, Callback.Cancelable cancelable, Status status, int i, long j, long j2, int i2, Object obj)`  L23
- `String getModel()`  L61
- `String getUrl()`  L66
- `String getFilePath()`  L71
- `String getTempFilePath()`  L76
- `Callback.Cancelable getCancelable()`  L81
- `Status getStatus()`  L86
- `int getProgress()`  L91
- `long getTotal()`  L96
- `long getCurrent()`  L101
- `DownloadTask copy(String model, String url, String filePath, String tempFilePath, Callback.Cancelable cancelable, Status status, int progress, long total, long current)`  L105
    - 体内字面量："model" · "url" · "filePath" · "tempFilePath" · "status"
- `boolean equals(Object other)`  L114
- `int hashCode()`  L125
- `String toString()`  L131
    - 体内字面量："DownloadTask(model=" · ", url=" · ", filePath=" · ", tempFilePath=" · ", cancelable=" · ", status=" · ", progress=" · ", total=" · ", current=" · ")"
- `public DownloadTask(String model, String url, String filePath, String tempFilePath, Callback.Cancelable cancelable, Status status, int i, long j, long j2)`  L135
    - 体内字面量："model" · "url" · "filePath" · "tempFilePath" · "status"
- `String getModel()`  L152
- `String getUrl()`  L156
- `String getFilePath()`  L160
- `String getTempFilePath()`  L164
- `Callback.Cancelable getCancelable()`  L168
- `void setCancelable(Callback.Cancelable cancelable)`  L172
- ` DownloadTask(String str, String str2, String str3, String str4, Callback.Cancelable cancelable, Status status, int i, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L176
- `Status getStatus()`  L180
- `void setStatus(Status status)`  L184
    - 体内字面量："<set-?>"
- `int getProgress()`  L189
- `void setProgress(int i)`  L193
- `long getTotal()`  L197
- `void setTotal(long j)`  L201
- `long getCurrent()`  L205
- `void setCurrent(long j)`  L209
### `com.gku.loginmodule.manage.Status`
L11 · [enum] public Status · `com/gku/loginmodule/manage/Status.java`
注解：

枚举常量（5）：
- `PENDING()`  L12
- `DOWNLOADING()`  L13
- `PAUSED()`  L14
- `COMPLETED()`  L15
- `FAILED()`  L16

方法（1）：
- `EnumEntries<Status> getEntries()`  L20