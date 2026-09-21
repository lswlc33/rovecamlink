# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.data.source

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 119 个文件 / 223 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.data.source.local.preferences.DeviceIdMigration`
L11 · [class] public final DeviceIdMigration · `com/tuwinsmart/tuwin/data/source/local/preferences/DeviceIdMigration.java`
注解：

字段/常量（4）：
- `String newId`  L12
- `String oldId`  L13
- `String version`  L14
- `String str = this.version`  L63

方法（12）：
- `DeviceIdMigration copy$default(DeviceIdMigration deviceIdMigration, String str, String str2, String str3, int i, Object obj)`  L16
- `String getOldId()`  L30
- `String getNewId()`  L35
- `String getVersion()`  L40
- `DeviceIdMigration copy(String oldId, String newId, String version)`  L44
    - 体内字面量："oldId" · "newId"
- `boolean equals(Object other)`  L50
- `int hashCode()`  L61
- `String toString()`  L67
    - 体内字面量："DeviceIdMigration(oldId=" · ", newId=" · ", version=" · ")"
- `public DeviceIdMigration(String oldId, String newId, String str)`  L71
    - 体内字面量："oldId" · "newId"
- `String getNewId()`  L79
- `String getOldId()`  L83
- `String getVersion()`  L87
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper`
L48 · [class] public final PreferenceHelper · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（34）：
- `List<ConnectedDevice> cacheDevices`  L49
- `Context context`  L50
- `String previousWifiNamePendingSync`  L51
- `UserPreferencesRepository repository`  L52
- `RuntimeDeviceIdentity runtimeConnectedDevice`  L53
- `boolean z`  L402
- `String apBssid`  L403
- `String ssid`  L404
- `DeviceIdMigration deviceIdMigration`  L405
- `boolean z2 = true`  L409
- `boolean z3 = false`  L410
- `DeviceIdMigration deviceIdMigration2 = null`  L423
- `String str = devid3`  L450
- `String devid`  L483
- `String str = devid2`  L487
- `int i = 0`  L488
- `String str2 = ssid`  L494
- `int i2 = 0`  L507
- `int i3 = 0`  L522
- `String str3 = ssid`  L542
- `boolean z`  L563
- `String devid`  L564
- `String ssid`  L565
- `boolean z2 = true`  L566
- `boolean z = false`  L635
- `String devid`  L649
- `int i = 0`  L841
- `int i2 = 0`  L858
- `String str = ssid`  L873
- `int i3 = 0`  L876
- `Object next`  L1009
- `RuntimeDeviceIdentity runtimeDeviceIdentity = this.runtimeConnectedDevice`  L1024
- `boolean z = false`  L1026
- `int i = 0`  L1291

方法（46）：
- `public PreferenceHelper(Context context, UserPreferencesRepository repository)`  L55
    - 体内字面量："context" · "repository"
- `List<ConnectedDevice> getCacheDevices()`  L63
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$isAgreePrivacy$1" · "PreferenceHelper.kt" · "invokeSuspend"
- `boolean isAgreePrivacy()`  L111
    - 体内字面量："<anonymous>" · "Landroidx/datastore/preferences/core/Preferences;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$agreePrivacy$1" · "PreferenceHelper.kt" · "invokeSuspend"
- `void agreePrivacy()`  L157
- `String getGetLastVersion()`  L161
    - 体内字面量："<anonymous>" · "Landroidx/datastore/preferences/core/Preferences;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$setLastVersion$1" · "PreferenceHelper.kt" · "invokeSuspend"
- `void setLastVersion(String version)`  L210
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$isRide6AddDeviceEntryEnabled$1" · "PreferenceHelper.kt" · "invokeSuspend"
- `boolean isRide6AddDeviceEntryEnabled()`  L256
    - 体内字面量："<anonymous>" · "Landroidx/datastore/preferences/core/Preferences;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$enableRide6AddDeviceEntry$1" · "PreferenceHelper.kt" · "invokeSuspend"
- `void enableRide6AddDeviceEntry()`  L302
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$isFront$1" · "PreferenceHelper.kt" · "invokeSuspend"
- `boolean isFront()`  L348
    - 体内字面量："<anonymous>" · "Landroidx/datastore/preferences/core/Preferences;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$setSteamType$1" · "PreferenceHelper.kt" · "invokeSuspend"
- `void setSteamType(boolean front)`  L397
- `List<ConnectedDevice> addDevice(ConnectedDevice data)`  L401
- `Boolean invoke(ConnectedDevice it)`  L458 @Override
    - 体内字面量："it"
- `int findDeviceMatchIndex(List<ConnectedDevice> devices, ConnectedDevice incoming)`  L482
- `boolean mergeDevice$default(PreferenceHelper preferenceHelper, ConnectedDevice connectedDevice, ConnectedDevice connectedDevice2, boolean z, int i, Object obj)`  L555
- `boolean mergeDevice(ConnectedDevice target, ConnectedDevice incoming, boolean updateSsid)`  L562
- `void clearConnected(String ssid)`  L632
- `List<ConnectedDevice> delete(ConnectedDevice data)`  L648
- `Boolean invoke(ConnectedDevice it)`  L669 @Override
    - 体内字面量："it"
- `boolean test(Object obj)`  L676 @Override
- `Boolean invoke(ConnectedDevice it)`  L688 @Override
    - 体内字面量："it"
- `boolean test(Object obj)`  L695 @Override
- `boolean delete$lambda$10(Function1 tmp0, Object obj)`  L706
    - 体内字面量："$tmp0"
- `boolean delete$lambda$11(Function1 tmp0, Object obj)`  L712
    - 体内字面量："$tmp0"
- `void updateDeviceRemark(String ssid, String remark)`  L717
    - 体内字面量："remark"
- `String getSSIDPwd$default(PreferenceHelper preferenceHelper, String str, String str2, int i, Object obj)`  L728
- `String getSSIDPwd(String ssid, String bssidHint)`  L735
- `boolean updateDeviceWifiInfo$default(PreferenceHelper preferenceHelper, String str, String str2, String str3, String str4, int i, Object obj)`  L744
- `boolean updateDeviceWifiInfo(String ssid, String wifiName, String pwd, String bssidHint)`  L751
    - 体内字面量："wifiName" · "pwd" · "PreferenceHelper" · "updateDeviceWifiInfo skipped: no device resolved for ssidHint=" · ", bssidHint="
- `boolean updateCurrentDevicePwd(String ssidHint, String pwd)`  L773
    - 体内字面量："pwd" · "PreferenceHelper" · "updateCurrentDevicePwd skipped: no device resolved for ssidHint="
- `String getCurrentDeviceSsid$default(PreferenceHelper preferenceHelper, String str, String str2, int i, Object obj)`  L788
- `String getCurrentDeviceSsid(String ssidHint, String bssidHint)`  L795
- `List<String> getCacheSSID()`  L804
- `String getSSIDRemark(String ssid)`  L814
    - 体内字面量："getString(...)"
- `int findDeviceIndexByContext$default(PreferenceHelper preferenceHelper, List list, String str, String str2, int i, Object obj)`  L830
- `int findDeviceIndexByContext(List<ConnectedDevice> devices, String ssid, String bssidHint)`  L839
- `List<ConnectedDevice> getCache()`  L908
    - 体内字面量："fromJson(...)"
- `List<ConnectedDevice> getCopyData()`  L915
- `ConnectedDevice getCurrentDevice$default(PreferenceHelper preferenceHelper, String str, String str2, int i, Object obj)`  L924
- `ConnectedDevice getCurrentDevice(String ssidHint, String bssidHint)`  L931
- `void saveCache$default(PreferenceHelper preferenceHelper, List list, DeviceIdMigration deviceIdMigration, int i, Object obj)`  L936
- `void saveCache(List<ConnectedDevice> list, DeviceIdMigration idMigration)`  L943
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$saveCache$1" · "PreferenceHelper.kt" · "invokeSuspend"
- `void updateCache(List<ConnectedDevice> devices)`  L1008
- `List<ConnectedDevice> applyRuntimeConnection(List<ConnectedDevice> list)`  L1023
- `void put(String key, String value)`  L1081
    - 体内字面量："key" · "value" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$get$1" · "PreferenceHelper.kt" · "invokeSuspend"
- `String get(String key)`  L1132
    - 体内字面量："key" · "Lcom/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper$RuntimeDeviceIdentity;" · "sessionId" · "deviceId" · "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V" · "getBssid" · "()Ljava/lang/String;" · "getDeviceId" · "getSessionId" · "getSsid" · "component1" · "component2" · "component3" · "component4" · "copy" · "equals" · "other" · "hashCode" · "matches" · "device" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectedDevice;" · "toString" · "Companion" · "app_release_64"
- `int findByBssid(List<ConnectedDevice> devices, String bssid)`  L1286
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22221`
L119 · [class] static final C22221 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（2）：
- `int label`  L120
- `int i = this.label`  L139

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L127 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Preferences> continuation)`  L132 @Override
- `Object invokeSuspend(Object obj)`  L137 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22251`
L264 · [class] static final C22251 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（2）：
- `int label`  L265
- `int i = this.label`  L284

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L272 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Preferences> continuation)`  L277 @Override
- `Object invokeSuspend(Object obj)`  L282 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22261`
L1091 · [class] static final C22261 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object>` · implements `Function2<CoroutineScope, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（3）：
- `String $key`  L1092
- `int label`  L1093
- `int i = this.label`  L1114

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1102 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation)`  L1107 @Override
- `Object invokeSuspend(Object obj)`  L1112 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22281`
L73 · [class] static final C22281 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Boolean>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（2）：
- `int label`  L74
- `int i = this.label`  L93

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L81 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation)`  L86 @Override
- `Object invokeSuspend(Object obj)`  L91 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22291`
L310 · [class] static final C22291 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Boolean>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（2）：
- `int label`  L311
- `int i = this.label`  L330

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L318 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation)`  L323 @Override
- `Object invokeSuspend(Object obj)`  L328 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22301`
L218 · [class] static final C22301 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Boolean>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（2）：
- `int label`  L219
- `int i = this.label`  L238

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L226 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation)`  L231 @Override
- `Object invokeSuspend(Object obj)`  L236 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22311`
L1039 · [class] static final C22311 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（4）：
- `String $key`  L1040
- `String $value`  L1041
- `int label`  L1042
- `int i = this.label`  L1064

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1052 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1057 @Override
- `Object invokeSuspend(Object obj)`  L1062 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22321`
L951 · [class] static final C22321 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（9）：
- `DeviceIdMigration $idMigration`  L952
- `String $jsonData`  L953
- `int label`  L954
- `PreferenceHelper this$0`  L955
- `int i = this.label`  L978
- `UserPreferencesRepository userPreferencesRepository = this.this$0.repository`  L982
- `String jsonData = this.$jsonData`  L983
- `UserPreferencesRepository userPreferencesRepository2 = this.this$0.repository`  L990
- `String jsonData2 = this.$jsonData`  L991

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L966 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L971 @Override
- `Object invokeSuspend(Object obj)`  L976 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22331`
L169 · [class] static final C22331 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（3）：
- `String $version`  L170
- `int label`  L171
- `int i = this.label`  L192

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L180 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Preferences> continuation)`  L185 @Override
- `Object invokeSuspend(Object obj)`  L190 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$C22341`
L356 · [class] static final C22341 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（3）：
- `boolean $front`  L357
- `int label`  L358
- `int i = this.label`  L379

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L367 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Preferences> continuation)`  L372 @Override
- `Object invokeSuspend(Object obj)`  L377 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$getCache$data$1`
L19 · [class] final PreferenceHelper$getCache$data$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object>` · implements `Function2<CoroutineScope, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper$getCache$data$1.java`
注解：

字段/常量（3）：
- `int label`  L20
- `PreferenceHelper this$0`  L21
- `int i = this.label`  L42

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L30 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation)`  L35 @Override
- `Object invokeSuspend(Object obj)`  L40 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$getLastVersion$1`
L19 · [class] final PreferenceHelper$getLastVersion$1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object>` · implements `Function2<CoroutineScope, Continuation<? super String>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper$getLastVersion$1.java`
注解：

字段/常量（3）：
- `int label`  L20
- `PreferenceHelper this$0`  L21
- `int i = this.label`  L42

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L30 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation)`  L35 @Override
- `Object invokeSuspend(Object obj)`  L40 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$RuntimeDeviceIdentity`
L1139 · [class] private static final RuntimeDeviceIdentity · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（12）：
- `String bssid`  L1143
- `String deviceId`  L1144
- `String sessionId`  L1145
- `String ssid`  L1146
- `String str = this.sessionId`  L1200
- `String str2 = this.deviceId`  L1202
- `String str3 = this.bssid`  L1204
- `String str4 = this.ssid`  L1206
- `String str = this.sessionId`  L1239
- `String str2 = this.deviceId`  L1243
- `String str3 = this.bssid`  L1247
- `String str4 = this.ssid`  L1251

方法（15）：
- `RuntimeDeviceIdentity copy$default(RuntimeDeviceIdentity runtimeDeviceIdentity, String str, String str2, String str3, String str4, int i, Object obj)`  L1148
- `String getSessionId()`  L1165
- `String getDeviceId()`  L1170
- `String getBssid()`  L1175
- `String getSsid()`  L1180
- `RuntimeDeviceIdentity copy(String sessionId, String deviceId, String bssid, String ssid)`  L1184
- `boolean equals(Object other)`  L1188
- `int hashCode()`  L1199
- `String toString()`  L1210
    - 体内字面量："RuntimeDeviceIdentity(sessionId=" · ", deviceId=" · ", bssid=" · ", ssid=" · ")"
- `public RuntimeDeviceIdentity(String str, String str2, String str3, String str4)`  L1214
- `String getSessionId()`  L1221
- `String getDeviceId()`  L1225
- `String getBssid()`  L1229
- `String getSsid()`  L1233
- `boolean matches(ConnectedDevice device)`  L1237
    - 体内字面量："device"
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceHelper$RuntimeDeviceIdentity$Companion`
L1257 · [class] public static final Companion · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceHelper.java`
注解：

字段/常量（1）：
- `String str = null`  L1268

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L1258
- `private Companion()`  L1262
- `RuntimeDeviceIdentity from(ConnectedDevice device)`  L1265
    - 体内字面量："device"
### `com.tuwinsmart.tuwin.data.source.local.preferences.PreferenceKeys`
L13 · [class] public final PreferenceKeys · `com/tuwinsmart/tuwin/data/source/local/preferences/PreferenceKeys.java`
注解：

方法（8）：
- `private PreferenceKeys()`  L22
- `Preferences.Key<Boolean> getPRIVACY_AGREE()`  L25
- `Preferences.Key<Boolean> getSTEAM_TYPE()`  L29
- `Preferences.Key<String> getCONNECTED_DEVICES()`  L33
- `Preferences.Key<String> getLAST_VERSION()`  L37
- `Preferences.Key<Boolean> getRIDE6_ADD_DEVICE_ENTRY_ENABLED()`  L41
- `Preferences.Key<String> getRECORDING_CONTROL_EVENTS()`  L45
- `Preferences.Key<String> stringKey(String name)`  L49
    - 体内字面量："name"
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository`
L50 · [class] public final UserPreferencesRepository · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（17）：
- `Flow<String> connectedDevicesJsonFlow`  L51
- `Type connectedDevicesType`  L52
- `Gson gson`  L53
- `Flow<Boolean> isAgreePrivacyFlow`  L54
- `Flow<Boolean> isFrontFlow`  L55
- `Flow<Boolean> isRide6AddDeviceEntryEnabledFlow`  L56
- `Flow<String> lastVersionFlow`  L57
- `Flow<String> recordingControlEventsJsonFlow`  L58
- `DataStore<Preferences> store`  L59
- `C22381 c22381`  L1124
- `Preferences.Key<String> keyStringKey`  L1125
- `Object objFirst = c22381.result`  L1136
- `int i = c22381.label`  L1138
- `C22371 c22371`  L1165
- `Object objFirst = c22371.result`  L1176
- `int i = c22371.label`  L1178
- `String json2`  L1303

方法（26）：
- `public UserPreferencesRepository(DataStore<Preferences> store)`  L102
    - 体内字面量："store" · "<anonymous>" · "R" · "value" · "emit" · "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1" · "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"
- `Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation)`  L179 @Override
    - 体内字面量："<anonymous>" · "R" · "value" · "emit" · "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1" · "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"
- `Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation)`  L255 @Override
    - 体内字面量："<anonymous>" · "R" · "value" · "emit" · "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1" · "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"
- `Object collect(FlowCollector<? super String> flowCollector, Continuation continuation)`  L331 @Override
    - 体内字面量："<anonymous>" · "R" · "value" · "emit" · "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1" · "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"
- `Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation)`  L407 @Override
    - 体内字面量："<anonymous>" · "R" · "value" · "emit" · "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1" · "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"
- `Object collect(FlowCollector<? super String> flowCollector, Continuation continuation)`  L485 @Override
    - 体内字面量："<anonymous>" · "R" · "value" · "emit" · "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;" · "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1" · "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"
- `Object collect(FlowCollector<? super String> flowCollector, Continuation continuation)`  L563 @Override
- `public UserPreferencesRepository(Context context)`  L571
    - 体内字面量："context"
- `Flow<Boolean> isAgreePrivacyFlow()`  L576
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/flow/FlowCollector;" · "exception" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$isAgreePrivacyFlow$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Flow<Boolean> isFrontFlow()`  L627
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/flow/FlowCollector;" · "exception" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$isFrontFlow$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Flow<String> getLastVersionFlow()`  L678
- `Flow<Boolean> isRide6AddDeviceEntryEnabledFlow()`  L682
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/flow/FlowCollector;" · "exception" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$isRide6AddDeviceEntryEnabledFlow$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Flow<String> getConnectedDevicesJsonFlow()`  L733
    - 体内字面量："<anonymous>" · "it" · "Landroidx/datastore/preferences/core/MutablePreferences;" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$setPrivacyAgreed$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Object setPrivacyAgreed(boolean z, Continuation<? super Preferences> continuation)`  L776
    - 体内字面量："<anonymous>" · "it" · "Landroidx/datastore/preferences/core/MutablePreferences;" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$setSteamType$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Object setSteamType(boolean z, Continuation<? super Preferences> continuation)`  L819
    - 体内字面量："<anonymous>" · "preferences" · "Landroidx/datastore/preferences/core/MutablePreferences;" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$setLastVersion$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Object setLastVersion(String str, Continuation<? super Preferences> continuation)`  L867
    - 体内字面量："<anonymous>" · "it" · "Landroidx/datastore/preferences/core/MutablePreferences;" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$enableRide6AddDeviceEntry$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Object enableRide6AddDeviceEntry(Continuation<? super Preferences> continuation)`  L907
    - 体内字面量："<anonymous>" · "it" · "Landroidx/datastore/preferences/core/MutablePreferences;" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$setConnectedDevicesJson$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Object setConnectedDevicesJson(String str, Continuation<? super Unit> continuation)`  L950
    - 体内字面量："<anonymous>" · "preferences" · "Landroidx/datastore/preferences/core/MutablePreferences;" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$setConnectedDevicesJson$4" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Object setConnectedDevicesJson$app_release_64(String str, DeviceIdMigration deviceIdMigration, Continuation<? super Unit> continuation)`  L1071
    - 体内字面量："<anonymous>" · "it" · "Landroidx/datastore/preferences/core/MutablePreferences;" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$putString$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Object putString(String str, String str2, Continuation<? super Unit> continuation)`  L1117
- `Object getString(String str, Continuation<? super String> continuation)`  L1123
- `Object getRecordingControlEventsJson(Continuation<? super String> continuation)`  L1164
- `Flow<String> getRecordingControlEventsJsonFlow()`  L1197
    - 体内字面量："<anonymous>" · "preferences" · "Landroidx/datastore/preferences/core/MutablePreferences;" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$updateRecordingControlEventsJson$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Object updateRecordingControlEventsJson(Function1<? super String, String> function1, Continuation<? super Unit> continuation)`  L1246
    - 体内字面量："<anonymous>" · "Landroidx/datastore/preferences/core/Preferences;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$edit$2" · "UserPreferencesRepository.kt" · "invokeSuspend"
- `Object edit(Function2<? super MutablePreferences, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Preferences> continuation)`  L1298
- `String normalizeConnectedDevicesJson(String json)`  L1302
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22352`
L1255 · [class] static final C22352 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Preferences>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `Function2<MutablePreferences, Continuation<? super Unit>, Object> $transform`  L1256
- `int label`  L1257
- `int i = this.label`  L1279

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1267 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Preferences> continuation)`  L1272 @Override
- `Object invokeSuspend(Object obj)`  L1277 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22362`
L875 · [class] static final C22362 · extends `SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object>` · implements `Function2<MutablePreferences, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（2）：
- `Object L$0`  L876
- `int label`  L877

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L884 @Override
- `Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation)`  L891 @Override
- `Object invokeSuspend(Object obj)`  L896 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22371`
L65 · [class] static final C22371 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（2）：
- `int label`  L66
- `Object result`  L67

方法（1）：
- `Object invokeSuspend(Object obj)`  L74 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22381`
L85 · [class] static final C22381 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `Object L$0`  L86
- `int label`  L87
- `Object result`  L88

方法（1）：
- `Object invokeSuspend(Object obj)`  L95 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22392`
L584 · [class] static final C22392 · extends `SuspendLambda implements Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object>` · implements `Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（4）：
- `Object L$0`  L585
- `Object L$1`  L586
- `int label`  L587
- `int i = this.label`  L604

方法（2）：
- `Object invoke(FlowCollector<? super Boolean> flowCollector, Throwable th, Continuation<? super Unit> continuation)`  L594 @Override
- `Object invokeSuspend(Object obj)`  L602 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22402`
L635 · [class] static final C22402 · extends `SuspendLambda implements Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object>` · implements `Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（4）：
- `Object L$0`  L636
- `Object L$1`  L637
- `int label`  L638
- `int i = this.label`  L655

方法（2）：
- `Object invoke(FlowCollector<? super Boolean> flowCollector, Throwable th, Continuation<? super Unit> continuation)`  L645 @Override
- `Object invokeSuspend(Object obj)`  L653 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22412`
L690 · [class] static final C22412 · extends `SuspendLambda implements Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object>` · implements `Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（4）：
- `Object L$0`  L691
- `Object L$1`  L692
- `int label`  L693
- `int i = this.label`  L710

方法（2）：
- `Object invoke(FlowCollector<? super Boolean> flowCollector, Throwable th, Continuation<? super Unit> continuation)`  L700 @Override
- `Object invokeSuspend(Object obj)`  L708 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22422`
L1080 · [class] static final C22422 · extends `SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object>` · implements `Function2<MutablePreferences, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（4）：
- `Preferences.Key<String> $preferenceKey`  L1081
- `String $value`  L1082
- `Object L$0`  L1083
- `int label`  L1084

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1094 @Override
- `Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation)`  L1101 @Override
- `Object invokeSuspend(Object obj)`  L1106 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22432`
L915 · [class] static final C22432 · extends `SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object>` · implements `Function2<MutablePreferences, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `String $normalized`  L916
- `Object L$0`  L917
- `int label`  L918

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L927 @Override
- `Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation)`  L934 @Override
- `Object invokeSuspend(Object obj)`  L939 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22444`
L959 · [class] static final C22444 · extends `SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object>` · implements `Function2<MutablePreferences, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（8）：
- `DeviceIdMigration $migration`  L960
- `String $normalized`  L961
- `Object L$0`  L962
- `int label`  L963
- `String str`  L990
- `String str2 = null`  L1000
- `ArrayList<String> arrayList2 = arrayList`  L1045
- `DeviceIdMigration deviceIdMigration = this.$migration`  L1046

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L973 @Override
- `Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation)`  L980 @Override
- `Object invokeSuspend(Object obj)`  L989 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22452`
L827 · [class] static final C22452 · extends `SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object>` · implements `Function2<MutablePreferences, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `String $version`  L828
- `Object L$0`  L829
- `int label`  L830

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L839 @Override
- `Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation)`  L846 @Override
- `Object invokeSuspend(Object obj)`  L851 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22462`
L741 · [class] static final C22462 · extends `SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object>` · implements `Function2<MutablePreferences, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `boolean $agreed`  L742
- `Object L$0`  L743
- `int label`  L744

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L753 @Override
- `Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation)`  L760 @Override
- `Object invokeSuspend(Object obj)`  L765 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22472`
L784 · [class] static final C22472 · extends `SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object>` · implements `Function2<MutablePreferences, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `boolean $front`  L785
- `Object L$0`  L786
- `int label`  L787

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L796 @Override
- `Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation)`  L803 @Override
- `Object invokeSuspend(Object obj)`  L808 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22482`
L114 · [class] public static final C22482 · implements `FlowCollector` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（5）：
- `FlowCollector $this_unsafeFlow`  L115
- `AnonymousClass1 anonymousClass1`  L145
- `Object obj2 = anonymousClass1.result`  L156
- `int i = anonymousClass1.label`  L158
- `FlowCollector flowCollector = this.$this_unsafeFlow`  L161

方法（2）：
- `public C22482(FlowCollector flowCollector)`  L138
- `Object emit(Object obj, Continuation continuation)`  L144 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22482$AnonymousClass1`
L121 · [class] public static final AnonymousClass1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `Object L$0`  L122
- `int label`  L123
- `Object result`  L124

方法（2）：
- `public AnonymousClass1(Continuation continuation)`  L126
- `Object invokeSuspend(Object obj)`  L131 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22492`
L190 · [class] public static final C22492 · implements `FlowCollector` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（5）：
- `FlowCollector $this_unsafeFlow`  L191
- `AnonymousClass1 anonymousClass1`  L221
- `Object obj2 = anonymousClass1.result`  L232
- `int i = anonymousClass1.label`  L234
- `FlowCollector flowCollector = this.$this_unsafeFlow`  L237

方法（2）：
- `public C22492(FlowCollector flowCollector)`  L214
- `Object emit(Object obj, Continuation continuation)`  L220 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22492$AnonymousClass1`
L197 · [class] public static final AnonymousClass1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `Object L$0`  L198
- `int label`  L199
- `Object result`  L200

方法（2）：
- `public AnonymousClass1(Continuation continuation)`  L202
- `Object invokeSuspend(Object obj)`  L207 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22502`
L266 · [class] public static final C22502 · implements `FlowCollector` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（5）：
- `FlowCollector $this_unsafeFlow`  L267
- `AnonymousClass1 anonymousClass1`  L298
- `Object obj2 = anonymousClass1.result`  L309
- `int i = anonymousClass1.label`  L311
- `FlowCollector flowCollector = this.$this_unsafeFlow`  L314

方法（2）：
- `public C22502(FlowCollector flowCollector)`  L290
- `Object emit(Object obj, Continuation continuation)`  L297 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22502$AnonymousClass1`
L273 · [class] public static final AnonymousClass1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `Object L$0`  L274
- `int label`  L275
- `Object result`  L276

方法（2）：
- `public AnonymousClass1(Continuation continuation)`  L278
- `Object invokeSuspend(Object obj)`  L283 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22512`
L342 · [class] public static final C22512 · implements `FlowCollector` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（5）：
- `FlowCollector $this_unsafeFlow`  L343
- `AnonymousClass1 anonymousClass1`  L373
- `Object obj2 = anonymousClass1.result`  L384
- `int i = anonymousClass1.label`  L386
- `FlowCollector flowCollector = this.$this_unsafeFlow`  L389

方法（2）：
- `public C22512(FlowCollector flowCollector)`  L366
- `Object emit(Object obj, Continuation continuation)`  L372 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22512$AnonymousClass1`
L349 · [class] public static final AnonymousClass1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `Object L$0`  L350
- `int label`  L351
- `Object result`  L352

方法（2）：
- `public AnonymousClass1(Continuation continuation)`  L354
- `Object invokeSuspend(Object obj)`  L359 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22522`
L418 · [class] public static final C22522 · implements `FlowCollector` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（5）：
- `FlowCollector $this_unsafeFlow`  L419
- `AnonymousClass1 anonymousClass1`  L449
- `Object obj2 = anonymousClass1.result`  L460
- `int i = anonymousClass1.label`  L462
- `FlowCollector flowCollector = this.$this_unsafeFlow`  L465

方法（2）：
- `public C22522(FlowCollector flowCollector)`  L442
- `Object emit(Object obj, Continuation continuation)`  L448 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22522$AnonymousClass1`
L425 · [class] public static final AnonymousClass1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `Object L$0`  L426
- `int label`  L427
- `Object result`  L428

方法（2）：
- `public AnonymousClass1(Continuation continuation)`  L430
- `Object invokeSuspend(Object obj)`  L435 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22532`
L496 · [class] public static final C22532 · implements `FlowCollector` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（5）：
- `FlowCollector $this_unsafeFlow`  L497
- `AnonymousClass1 anonymousClass1`  L527
- `Object obj2 = anonymousClass1.result`  L538
- `int i = anonymousClass1.label`  L540
- `FlowCollector flowCollector = this.$this_unsafeFlow`  L543

方法（2）：
- `public C22532(FlowCollector flowCollector)`  L520
- `Object emit(Object obj, Continuation continuation)`  L526 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22532$AnonymousClass1`
L503 · [class] public static final AnonymousClass1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `Object L$0`  L504
- `int label`  L505
- `Object result`  L506

方法（2）：
- `public AnonymousClass1(Continuation continuation)`  L508
- `Object invokeSuspend(Object obj)`  L513 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$C22542`
L1205 · [class] static final C22542 · extends `SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object>` · implements `Function2<MutablePreferences, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository.java`
注解：

字段/常量（3）：
- `Function1<String, String> $transform`  L1206
- `Object L$0`  L1207
- `int label`  L1208

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1218 @Override
- `Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation)`  L1225 @Override
- `Object invokeSuspend(Object obj)`  L1230 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$connectedDevicesJsonFlow$2`
L21 · [class] final UserPreferencesRepository$connectedDevicesJsonFlow$2 · extends `SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object>` · implements `Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository$connectedDevicesJsonFlow$2.java`
注解：

字段/常量（4）：
- `Object L$0`  L22
- `Object L$1`  L23
- `int label`  L24
- `int i = this.label`  L41

方法（2）：
- `Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation)`  L31 @Override
- `Object invokeSuspend(Object obj)`  L39 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepository$lastVersionFlow$2`
L19 · [class] final UserPreferencesRepository$lastVersionFlow$2 · extends `SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object>` · implements `Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepository$lastVersionFlow$2.java`
注解：

字段/常量（4）：
- `Object L$0`  L20
- `Object L$1`  L21
- `int label`  L22
- `int i = this.label`  L39

方法（2）：
- `Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation)`  L29 @Override
- `Object invokeSuspend(Object obj)`  L37 @Override
### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepositoryKt`
L23 · [class] public final UserPreferencesRepositoryKt · `com/tuwinsmart/tuwin/data/source/local/preferences/UserPreferencesRepositoryKt.java`
注解：

字段/常量（4）：
- `String DEFAULT_CONNECTED_DEVICES_JSON = "[]"`  L24
- `String DEFAULT_RECORDING_CONTROL_EVENTS_JSON = "[]"`  L25
- `String LEGACY_PREFERENCES_NAME = "TUWIN"`  L26
- `String DATASTORE_NAME = "user_preferences"`  L28

方法（2）：
- `List<DataMigration<Preferences>> invoke(Context context)`  L31 @Override
    - 体内字面量："context" · "TUWIN"
- `DataStore<Preferences> getDataStore(Context context)`  L38
### `com.tuwinsmart.tuwin.data.source.remote.api.p006m3.M3ApiService`
L46 · [interface] public M3ApiService · `com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java`
注解：

方法（12）：
- `Object downloadFile(@Url String str, Continuation<? super ResponseBody> continuation)`  L52 @Streaming @GET
    - 体内字面量："/app/getparamitems" · "param" · "/app/getparamvalue" · "param" · "/app/getbatteryinfo"
- `Object getBatteryInfo(Continuation<? super M3BatteryInfoResponse> continuation)`  L61 @GET("/app/getbatteryinfo")
    - 体内字面量："/app/getcurmode"
- `Object getCurMode(Continuation<? super M3CurModeResponse> continuation)`  L64 @GET("/app/getcurmode")
    - 体内字面量："/app/getdeviceattr"
- `Object getDeviceAttr(Continuation<? super M3DeviceAttrResponse> continuation)`  L67 @GET("/app/getdeviceattr")
    - 体内字面量："/app/getfilelist"
- `Object getFileList(Continuation<? super M3FileListResponse> continuation)`  L70 @GET("/app/getfilelist")
    - 体内字面量："/app/getgravitydirection"
- `Object getGravityDirection(Continuation<? super GravityDirectionResponse> continuation)`  L73 @GET("/app/getgravitydirection")
    - 体内字面量："/app/getmediainfo"
- `Object getMediaInfo(Continuation<? super M3MediaInfoResponse> continuation)`  L76 @GET("/app/getmediainfo")
    - 体内字面量："/app/getparamitems" · "param" · "/app/getparamitems" · "param" · "/app/getparamvalue" · "param" · "/app/getproductinfo"
- `Object getProductInfo(Continuation<? super M3ProductInfoResponse> continuation)`  L88 @GET("/app/getproductinfo")
    - 体内字面量："/app/getrecduration"
- `Object getRecDuration(Continuation<? super M3RecDurationResponse> continuation)`  L91 @GET("/app/getrecduration")
    - 体内字面量："/app/getsdinfo"
- `Object getSDInfo(Continuation<? super M3SDInfoResponse> continuation)`  L94 @GET("/app/getsdinfo")
    - 体内字面量："/app/getthumbnail" · "file" · "/app/reset"
- `Object reset(Continuation<? super M3ResetResponse> continuation)`  L101 @GET("/app/reset")
    - 体内字面量："/app/sdformat"
- `Object sdFormat(Continuation<? super M3SdFormatResponse> continuation)`  L104 @GET("/app/sdformat")
    - 体内字面量："/app/setting" · "param" · "/app/mode" · "param" · "/app/setparamvalue" · "param" · "value" · "/app/playback" · "param" · "/app/setparamvalue" · "param" · "value" · "/app/setsystime" · "/app/settimezone" · "/app/setwifi" · "wifissid" · "wifipwd" · "/app/setparamvalue" · "param" · "value" · "/upload/{savepath}/{filesize}" · "savepath" · "filesize"
### `com.tuwinsmart.tuwin.data.source.remote.api.p006m3.M3ApiService$DefaultImpls`
L139 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/data/source/remote/api/p006m3/M3ApiService.java`
注解：

方法（5）：
- `Object setWifi$default(M3ApiService m3ApiService, String str, String str2, Continuation continuation, int i, Object obj)`  L140
    - 体内字面量："Super calls with default arguments not supported in this target, function: setWifi"
- `Object setRecording$default(M3ApiService m3ApiService, String str, int i, Continuation continuation, int i2, Object obj)`  L153
    - 体内字面量："Super calls with default arguments not supported in this target, function: setRecording" · "rec"
- `Object takeSnapshot$default(M3ApiService m3ApiService, String str, int i, Continuation continuation, int i2, Object obj)`  L163
    - 体内字面量："Super calls with default arguments not supported in this target, function: takeSnapshot" · "snapshot"
- `Object getAllParamItems$default(M3ApiService m3ApiService, String str, Continuation continuation, int i, Object obj)`  L173
    - 体内字面量："Super calls with default arguments not supported in this target, function: getAllParamItems"
- `Object getAllParamValues$default(M3ApiService m3ApiService, String str, Continuation continuation, int i, Object obj)`  L183
    - 体内字面量："Super calls with default arguments not supported in this target, function: getAllParamValues"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.NonClosingExecutorService`
L15 · [class] final NonClosingExecutorService · extends `AbstractExecutorService` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/NonClosingExecutorService.java`
注解：

字段/常量（1）：
- `ExecutorService delegate`  L16

方法（7）：
- `boolean awaitTermination(long timeout, TimeUnit unit)`  L19 @Override
    - 体内字面量："unit"
- `boolean isShutdown()`  L25 @Override
- `boolean isTerminated()`  L30 @Override
- `void shutdown()`  L35 @Override
- `public NonClosingExecutorService(ExecutorService delegate)`  L38
    - 体内字面量："delegate"
- `void execute(Runnable command)`  L44 @Override
    - 体内字面量："command"
- `List<Runnable> shutdownNow()`  L50 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService`
L24 · [class] public final QueuedRide3ProApiService · implements `Ride3ProApiService` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（2）：
- `Ride3ProApiService delegate`  L25
- `Ride3ProHttpRequestQueue requestQueue`  L26

方法（28）：
- `public QueuedRide3ProApiService(Ride3ProApiService delegate, Ride3ProHttpRequestQueue requestQueue)`  L28
    - 体内字面量："delegate" · "requestQueue" · "<anonymous>" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$queued$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object queued(Function2<? super Ride3ProApiService, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation)`  L87
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$setMode$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object setMode(int i, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L140 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$capture$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object capture(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L190 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProDeviceStatusInfo;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getDeviceStatus$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getDeviceStatus(Continuation<? super Ride3ProApiResponse<Ride3ProDeviceStatusInfo>> continuation)`  L240 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProDeviceInfo;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getDeviceInfo$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getDeviceInfo(Continuation<? super Ride3ProApiResponse<Ride3ProDeviceInfo>> continuation)`  L290 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$reboot$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object reboot(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L340 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$authDevice$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object authDevice(long j, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L393 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getRtspStatus$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getRtspStatus(long j, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L446 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$sendTime$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object sendTime(int i, int i2, int i3, int i4, int i5, int i6, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L509 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$recordStart$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object recordStart(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L559 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$recordStop$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object recordStop(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L609 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackFileListInfo;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getPlaybackFileList$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getPlaybackFileList(int i, int i2, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackFileListInfo>> continuation)`  L664 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackFileCountInfo;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getPlaybackFileCount$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getPlaybackFileCount(Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackFileCountInfo>> continuation)`  L714 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackDayDetail;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getPlaybackDayInfo$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getPlaybackDayInfo(int i, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackDayDetail>> continuation)`  L767 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProSdInfo;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getSdInfo$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getSdInfo(Continuation<? super Ride3ProApiResponse<Ride3ProSdInfo>> continuation)`  L817 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$formatSd$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object formatSd(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L867 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$playbackStart$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object playbackStart(int i, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L920 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$playbackPause$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object playbackPause(int i, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L973 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$playbackStop$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object playbackStop(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1023 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$playbackDelete$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object playbackDelete(int i, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1076 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$playbackSetTime$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object playbackSetTime(int i, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1129 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$playbackSetSpeed$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object playbackSetSpeed(int i, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1182 @Override
    - 体内字面量："<anonymous>" · "Lokhttp3/ResponseBody;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getPlaybackThumbnail$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getPlaybackThumbnail(int i, Continuation<? super ResponseBody> continuation)`  L1235 @Override
    - 体内字面量："<anonymous>" · "Lokhttp3/ResponseBody;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getMenuXml$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getMenuXml(Continuation<? super ResponseBody> continuation)`  L1285 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$getParameter$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object getParameter(String str, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1338 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$setParameter$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object setParameter(String str, String str2, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1393 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse;" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService;" · "com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$uploadFirmware$2" · "Ride3ProHttpRequestQueue.kt" · "invokeSuspend"
- `Object uploadFirmware(String str, String str2, String str3, String str4, RequestBody requestBody, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1454 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22552`
L348 · [class] static final C22552 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `long $seed`  L349
- `Object L$0`  L350
- `int label`  L351
- `int i = this.label`  L374

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L360 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L367 @Override
- `Object invokeSuspend(Object obj)`  L372 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22562`
L148 · [class] static final C22562 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L149
- `int label`  L150
- `int i = this.label`  L171

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L157 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L164 @Override
- `Object invokeSuspend(Object obj)`  L169 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22572`
L825 · [class] static final C22572 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L826
- `int label`  L827
- `int i = this.label`  L848

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L834 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L841 @Override
- `Object invokeSuspend(Object obj)`  L846 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22582`
L248 · [class] static final C22582 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProDeviceInfo>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProDeviceInfo>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L249
- `int label`  L250
- `int i = this.label`  L271

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L257 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProDeviceInfo>> continuation)`  L264 @Override
- `Object invokeSuspend(Object obj)`  L269 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22592`
L198 · [class] static final C22592 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProDeviceStatusInfo>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProDeviceStatusInfo>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L199
- `int label`  L200
- `int i = this.label`  L221

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L207 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProDeviceStatusInfo>> continuation)`  L214 @Override
- `Object invokeSuspend(Object obj)`  L219 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22602`
L1243 · [class] static final C22602 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super ResponseBody>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super ResponseBody>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L1244
- `int label`  L1245
- `int i = this.label`  L1266

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1252 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super ResponseBody> continuation)`  L1259 @Override
- `Object invokeSuspend(Object obj)`  L1264 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22612`
L1293 · [class] static final C22612 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `String $id`  L1294
- `Object L$0`  L1295
- `int label`  L1296
- `int i = this.label`  L1319

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1305 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1312 @Override
- `Object invokeSuspend(Object obj)`  L1317 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22622`
L722 · [class] static final C22622 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackDayDetail>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackDayDetail>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `int $date`  L723
- `Object L$0`  L724
- `int label`  L725
- `int i = this.label`  L748

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L734 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackDayDetail>> continuation)`  L741 @Override
- `Object invokeSuspend(Object obj)`  L746 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22632`
L672 · [class] static final C22632 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackFileCountInfo>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackFileCountInfo>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L673
- `int label`  L674
- `int i = this.label`  L695

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L681 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackFileCountInfo>> continuation)`  L688 @Override
- `Object invokeSuspend(Object obj)`  L693 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22642`
L617 · [class] static final C22642 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackFileListInfo>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackFileListInfo>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（5）：
- `int $fileIndex`  L618
- `int $mode`  L619
- `Object L$0`  L620
- `int label`  L621
- `int i = this.label`  L645

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L631 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackFileListInfo>> continuation)`  L638 @Override
- `Object invokeSuspend(Object obj)`  L643 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22652`
L1190 · [class] static final C22652 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super ResponseBody>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super ResponseBody>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `int $fileIndex`  L1191
- `Object L$0`  L1192
- `int label`  L1193
- `int i = this.label`  L1216

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1202 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super ResponseBody> continuation)`  L1209 @Override
- `Object invokeSuspend(Object obj)`  L1214 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22662`
L401 · [class] static final C22662 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `long $seed`  L402
- `Object L$0`  L403
- `int label`  L404
- `int i = this.label`  L427

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L413 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L420 @Override
- `Object invokeSuspend(Object obj)`  L425 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22672`
L775 · [class] static final C22672 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProSdInfo>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProSdInfo>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L776
- `int label`  L777
- `int i = this.label`  L798

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L784 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Ride3ProSdInfo>> continuation)`  L791 @Override
- `Object invokeSuspend(Object obj)`  L796 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22682`
L1031 · [class] static final C22682 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `int $fileIndex`  L1032
- `Object L$0`  L1033
- `int label`  L1034
- `int i = this.label`  L1057

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1043 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1050 @Override
- `Object invokeSuspend(Object obj)`  L1055 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22692`
L928 · [class] static final C22692 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `int $fileType`  L929
- `Object L$0`  L930
- `int label`  L931
- `int i = this.label`  L954

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L940 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L947 @Override
- `Object invokeSuspend(Object obj)`  L952 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22702`
L1137 · [class] static final C22702 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `int $index`  L1138
- `Object L$0`  L1139
- `int label`  L1140
- `int i = this.label`  L1163

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1149 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1156 @Override
- `Object invokeSuspend(Object obj)`  L1161 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22712`
L1084 · [class] static final C22712 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `int $second`  L1085
- `Object L$0`  L1086
- `int label`  L1087
- `int i = this.label`  L1110

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1096 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1103 @Override
- `Object invokeSuspend(Object obj)`  L1108 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22722`
L875 · [class] static final C22722 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `int $fileIndex`  L876
- `Object L$0`  L877
- `int label`  L878
- `int i = this.label`  L901

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L887 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L894 @Override
- `Object invokeSuspend(Object obj)`  L899 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22732`
L981 · [class] static final C22732 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L982
- `int label`  L983
- `int i = this.label`  L1004

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L990 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L997 @Override
- `Object invokeSuspend(Object obj)`  L1002 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22742`
L40 · [class] static final C22742 · extends `SuspendLambda implements Function1<Continuation<? super T>, Object>` · implements `Function1<Continuation<? super T>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（6）：
- `Function2<Ride3ProApiService, Continuation<? super T>, Object> $request`  L41
- `int label`  L42
- `QueuedRide3ProApiService this$0`  L43
- `int i = this.label`  L66
- `Function2<Ride3ProApiService, Continuation<? super T>, Object> function2 = this.$request`  L69
- `Ride3ProApiService ride3ProApiService = this.this$0.delegate`  L70

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L54 @Override
- `Object invoke(Continuation<? super T> continuation)`  L59 @Override
- `Object invokeSuspend(Object obj)`  L64 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22752`
L298 · [class] static final C22752 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L299
- `int label`  L300
- `int i = this.label`  L321

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L307 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L314 @Override
- `Object invokeSuspend(Object obj)`  L319 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22762`
L517 · [class] static final C22762 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L518
- `int label`  L519
- `int i = this.label`  L540

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L526 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L533 @Override
- `Object invokeSuspend(Object obj)`  L538 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22772`
L567 · [class] static final C22772 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（3）：
- `Object L$0`  L568
- `int label`  L569
- `int i = this.label`  L590

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L576 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L583 @Override
- `Object invokeSuspend(Object obj)`  L588 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22782`
L454 · [class] static final C22782 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（9）：
- `int $day`  L455
- `int $hour`  L456
- `int $minute`  L457
- `int $month`  L458
- `int $second`  L459
- `int $year`  L460
- `Object L$0`  L461
- `int label`  L462
- `int i = this.label`  L490

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L476 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L483 @Override
- `Object invokeSuspend(Object obj)`  L488 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22792`
L95 · [class] static final C22792 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（4）：
- `int $mode`  L96
- `Object L$0`  L97
- `int label`  L98
- `int i = this.label`  L121

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L107 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L114 @Override
- `Object invokeSuspend(Object obj)`  L119 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22802`
L1346 · [class] static final C22802 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（5）：
- `String $id`  L1347
- `String $value`  L1348
- `Object L$0`  L1349
- `int label`  L1350
- `int i = this.label`  L1374

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1360 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1367 @Override
- `Object invokeSuspend(Object obj)`  L1372 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.QueuedRide3ProApiService$C22812`
L1401 · [class] static final C22812 · extends `SuspendLambda implements Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · implements `Function2<Ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/QueuedRide3ProApiService.java`
注解：

字段/常量（8）：
- `RequestBody $body`  L1402
- `String $hw`  L1403
- `String $md5sum`  L1404
- `String $model`  L1405
- `String $sw`  L1406
- `Object L$0`  L1407
- `int label`  L1408
- `int i = this.label`  L1435

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1421 @Override
- `Object invoke(Ride3ProApiService ride3ProApiService, Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L1428 @Override
- `Object invokeSuspend(Object obj)`  L1433 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProApiClient`
L16 · [class] public final Ride3ProApiClient · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiClient.java`
注解：@Deprecated(message = "Use Ride3ProSessionExecutorResolver and a session-owned executor")

方法（12）：
- `void clearBindingForSession(String sessionId)`  L19
    - 体内字面量："sessionId"
- `void clearHttpRequests()`  L23
- `void clearNetworkBinding()`  L26
- `Network currentBoundNetwork()`  L29
- `void evictConnectionPool()`  L33
- `void refreshNetworkBindingIfNeeded()`  L36
- `private Ride3ProApiClient()`  L39
- `Ride3ProApiService getService()`  L42
- `Ride3ProApiService getLongOperationService()`  L46
- `void bindToNetwork$default(Ride3ProApiClient ride3ProApiClient, Network network, EndpointGrant endpointGrant, Long l, String str, int i, Object obj)`  L50
- `void bindToNetwork(Network network, EndpointGrant endpointGrant, Long routeRevision, String sessionId)`  L63
- `T unavailable()`  L70
    - 体内字面量："Ride3ProApiClient is disabled; a ready DeviceSession is required"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProApiResponse`
L13 · [class] public final Ride3ProApiResponse · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiResponse.java`
注解：

字段/常量（4）：
- `T info`  L16 @SerializedName("info")
- `int result`  L19 @SerializedName("result")
- `T t = this.info`  L58
- `T t = this.info`  L88

方法（13）：
- `Ride3ProApiResponse copy$default(Ride3ProApiResponse ride3ProApiResponse, int i, Object obj, int i2, Object obj2)`  L22
- `int getResult()`  L33
- `T component2()`  L37
- `Ride3ProApiResponse<T> copy(int result, T info)`  L41
- `boolean equals(Object other)`  L45
- `int hashCode()`  L56
- `String toString()`  L62
    - 体内字面量："Ride3ProApiResponse(result=" · ", info=" · ")"
- `public Ride3ProApiResponse(int i, T t)`  L66
- ` Ride3ProApiResponse(int i, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L71
- `int getResult()`  L75
- `T getInfo()`  L79
- `boolean isSuccess()`  L83
- `String getErrorMessage()`  L87
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProApiService`
L21 · [interface] public Ride3ProApiService · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java`
注解：

方法（11）：
- `Object capture(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L26 @GET("/api/capture")
    - 体内字面量："/api/system/formatsd"
- `Object formatSd(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L29 @GET("/api/system/formatsd")
    - 体内字面量："/api/device/info"
- `Object getDeviceInfo(Continuation<? super Ride3ProApiResponse<Ride3ProDeviceInfo>> continuation)`  L32 @GET("/api/device/info")
    - 体内字面量："/api/device/status"
- `Object getDeviceStatus(Continuation<? super Ride3ProApiResponse<Ride3ProDeviceStatusInfo>> continuation)`  L35 @GET("/api/device/status")
    - 体内字面量："/api/menu/xml"
- `Object getMenuXml(Continuation<? super ResponseBody> continuation)`  L39 @Streaming @GET("/api/menu/xml")
    - 体内字面量："/api/menu/getparameter" · "id" · "/api/playback/dayinfo"
- `Object getPlaybackFileCount(Continuation<? super Ride3ProApiResponse<Ride3ProPlaybackFileCountInfo>> continuation)`  L48 @GET(Ride3ProStorageCapabilityProbe.FILE_COUNT_ENDPOINT)
    - 体内字面量："/api/playback/filelist" · "mode" · "file_index" · "/api/playback/thumbnail" · "file_index" · "/api/rtspstatus" · "seed" · "/api/sd/info"
- `Object getSdInfo(Continuation<? super Ride3ProApiResponse<Ride3ProSdInfo>> continuation)`  L61 @GET("/api/sd/info")
    - 体内字面量："/api/playback/delete" · "file_index" · "/api/playback/pause" · "file_type" · "/api/playback/setspeed" · "/api/playback/settime" · "second" · "/api/playback/start" · "file_index" · "/api/playback/stop"
- `Object playbackStop(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L79 @GET("/api/playback/stop")
    - 体内字面量："/api/reboot"
- `Object reboot(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L82 @GET("/api/reboot")
    - 体内字面量："/api/record/start"
- `Object recordStart(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L85 @GET("/api/record/start")
    - 体内字面量："/api/record/stop"
- `Object recordStop(Continuation<? super Ride3ProApiResponse<Object>> continuation)`  L88 @GET("/api/record/stop")
    - 体内字面量："/api/vendor/send-time" · "year" · "month" · "day" · "hour" · "minute" · "second" · "/api/setmode" · "mode" · "/api/menu/setparameter" · "id" · "value" · "Content-Type: application/octet-stream" · "Content-Encoding: identity" · "Connection: close" · "/api/firmware/upload" · "md5sum" · "model" · "hw" · "sw"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProApiService$DefaultImpls`
L105 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiService.java`
注解：

方法（1）：
- `Object setParameter$default(Ride3ProApiService ride3ProApiService, String str, String str2, Continuation continuation, int i, Object obj)`  L106
    - 体内字面量："Super calls with default arguments not supported in this target, function: setParameter"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProApiServiceKt`
L20 · [class] public final Ride3ProApiServiceKt · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProApiServiceKt.java`
注解：

字段/常量（15）：
- `DeviceType deviceType`  L22
- `String fileType`  L44
- `String str`  L45
- `String str2`  L46
- `String str3`  L47
- `String upperCase = null`  L53
- `Locale ROOT = Locale.ROOT`  L70
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L76
- `StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE`  L86
- `StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE`  L91
- `Locale ROOT2 = Locale.ROOT`  L109
- `StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE`  L115
- `StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE`  L125
- `StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE`  L130
- `String str10 = time`  L144

方法（2）：
- `StorageRide3ProRemoteFile toStorageRide3ProRemoteFile(Ride3ProPlaybackFileEntry ride3ProPlaybackFileEntry)`  L21
- `StorageRide3ProRemoteFile toStorageRide3ProRemoteFile(Ride3ProPlaybackFileEntry ride3ProPlaybackFileEntry, DeviceType deviceType)`  L43
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProDeviceInfo`
L16 · [class] public final Ride3ProDeviceInfo · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProDeviceInfo.java`
注解：

字段/常量（18）：
- `List<String> features`  L19 @SerializedName("features")
- `String hwver`  L22 @SerializedName("hwver")
- `String mac`  L25 @SerializedName("mac")
- `String model`  L28 @SerializedName("model")
- `String pwd`  L31 @SerializedName("pwd")
- `String soc`  L34 @SerializedName("soc")
- `String ssid`  L37 @SerializedName(DeviceWifiScanDialog.RESULT_SSID)
- `String swver`  L40 @SerializedName("swver")
- `String uuid`  L43 @SerializedName("uuid")
- `String str = this.model`  L109
- `String str2 = this.soc`  L111
- `String str3 = this.hwver`  L113
- `String str4 = this.swver`  L115
- `String str5 = this.uuid`  L117
- `String str6 = this.ssid`  L119
- `String str7 = this.mac`  L121
- `String str8 = this.pwd`  L123
- `List<String> list = this.features`  L125

方法（26）：
- `public Ride3ProDeviceInfo()`  L45
- `String getModel()`  L50
- `String getSoc()`  L55
- `String getHwver()`  L60
- `String getSwver()`  L65
- `String getUuid()`  L70
- `String getSsid()`  L75
- `String getMac()`  L80
- `String getPwd()`  L85
- `List<String> component9()`  L89
- `Ride3ProDeviceInfo copy(String model, String soc, String hwver, String swver, String uuid, String ssid, String mac, String pwd, List<String> features)`  L93
- `boolean equals(Object other)`  L97
- `int hashCode()`  L108
- `String toString()`  L129
    - 体内字面量："Ride3ProDeviceInfo(model=" · ", soc=" · ", hwver=" · ", swver=" · ", uuid=" · ", ssid=" · ", mac=" · ", pwd=" · ", features=" · ")"
- `public Ride3ProDeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List<String> list)`  L133
- ` Ride3ProDeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List list, int i, DefaultConstructorMarker defaultConstructorMarker)`  L145
- `String getModel()`  L149
- `String getSoc()`  L153
- `String getHwver()`  L157
- `String getSwver()`  L161
- `String getUuid()`  L165
- `String getSsid()`  L169
- `String getMac()`  L173
- `String getPwd()`  L177
- `List<String> getFeatures()`  L181
- `Set<String> getNormalizedFeatures()`  L185
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProDeviceStatusInfo`
L12 · [class] public final Ride3ProDeviceStatusInfo · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProDeviceStatusInfo.java`
注解：

字段/常量（19）：
- `Integer adapterStatus`  L15 @SerializedName("adapter_status")
- `Integer batteryLevel`  L18 @SerializedName(alternate = {"battery_level"}, value = "battery_percent")
- `Integer currentMode`  L21 @SerializedName("current_mode")
- `Integer exceptionFlags`  L24 @SerializedName("exception_flags")
- `Integer hdrChkCnt`  L27 @SerializedName("hdr_chk_cnt")
- `Integer modeActive`  L30 @SerializedName("mode_active")
- `Integer recordingTime`  L33 @SerializedName("recording_time")
- `Integer num8 = num2`  L46
- `Integer num9 = num3`  L50
- `Integer num10 = num4`  L54
- `Integer num11 = num5`  L58
- `Integer num12 = num6`  L62
- `Integer num = this.currentMode`  L120
- `Integer num2 = this.modeActive`  L122
- `Integer num3 = this.batteryLevel`  L124
- `Integer num4 = this.adapterStatus`  L126
- `Integer num5 = this.recordingTime`  L128
- `Integer num6 = this.exceptionFlags`  L130
- `Integer num7 = this.hdrChkCnt`  L132

方法（23）：
- `public Ride3ProDeviceStatusInfo()`  L35
- `Ride3ProDeviceStatusInfo copy$default(Ride3ProDeviceStatusInfo ride3ProDeviceStatusInfo, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, int i, Object obj)`  L39
- `Integer getCurrentMode()`  L70
- `Integer getModeActive()`  L75
- `Integer getBatteryLevel()`  L80
- `Integer getAdapterStatus()`  L85
- `Integer getRecordingTime()`  L90
- `Integer getExceptionFlags()`  L95
- `Integer getHdrChkCnt()`  L100
- `Ride3ProDeviceStatusInfo copy(Integer currentMode, Integer modeActive, Integer batteryLevel, Integer adapterStatus, Integer recordingTime, Integer exceptionFlags, Integer hdrChkCnt)`  L104
- `boolean equals(Object other)`  L108
- `int hashCode()`  L119
- `String toString()`  L136
    - 体内字面量："Ride3ProDeviceStatusInfo(currentMode=" · ", modeActive=" · ", batteryLevel=" · ", adapterStatus=" · ", recordingTime=" · ", exceptionFlags=" · ", hdrChkCnt=" · ")"
- `public Ride3ProDeviceStatusInfo(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7)`  L140
- ` Ride3ProDeviceStatusInfo(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, int i, DefaultConstructorMarker defaultConstructorMarker)`  L150
- `Integer getCurrentMode()`  L154
- `Integer getModeActive()`  L158
- `Integer getBatteryLevel()`  L162
- `Integer getAdapterStatus()`  L166
- `Integer getRecordingTime()`  L170
- `Integer getExceptionFlags()`  L174
- `Integer getHdrChkCnt()`  L178
- `Integer getBatteryPercent()`  L182
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProFormatTimeoutInterceptor`
L13 · [class] public final Ride3ProFormatTimeoutInterceptor · implements `Interceptor` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProFormatTimeoutInterceptor.java`
注解：

方法（1）：
- `Response intercept(Interceptor.Chain chain)`  L15 @Override
    - 体内字面量："chain" · "/api/system/formatsd"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProGlideThumbnailPolicy`
L12 · [class] public final Ride3ProGlideThumbnailPolicy · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProGlideThumbnailPolicy.java`
注解：

方法（3）：
- `private Ride3ProGlideThumbnailPolicy()`  L15
- `boolean shouldSerialize(HttpUrl url)`  L18
    - 体内字面量："url" · "/api/playback/thumbnail"
- `boolean shouldSerialize(String url)`  L23
    - 体内字面量："url" · "/api/playback/thumbnail"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProHttpFileLoggingInterceptor`
L13 · [class] public final Ride3ProHttpFileLoggingInterceptor · implements `Interceptor` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpFileLoggingInterceptor.java`
注解：

方法（1）：
- `Response intercept(Interceptor.Chain chain)`  L17 @Override
    - 体内字面量："chain" · "Ride3Pro request is missing X-Request-Id"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProHttpLogFormatter`
L14 · [class] public final Ride3ProHttpLogFormatter · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpLogFormatter.java`
注解：

字段/常量（3）：
- `Locale US = Locale.US`  L24
- `Locale US = Locale.US`  L35
- `Locale US = Locale.US`  L47

方法（5）：
- `private Ride3ProHttpLogFormatter()`  L17
- `String request(String method, HttpUrl url, String requestId)`  L20
    - 体内字面量："method" · "url" · "requestId"
- `String response(String method, HttpUrl url, String requestId, int code, long elapsedMs)`  L31
    - 体内字面量："method" · "url" · "requestId"
- `String failure(String method, HttpUrl url, String requestId, long elapsedMs, String errorMessage)`  L42
    - 体内字面量："method" · "url" · "requestId" · "errorMessage"
- `String pathAndQuery(HttpUrl url)`  L54
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProHttpRequestIds`
L10 · [class] public final Ride3ProHttpRequestIds · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestIds.java`
注解：

方法（2）：
- `private Ride3ProHttpRequestIds()`  L14
- `long next()`  L17
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProHttpRequestQueue`
L28 · [class] public final Ride3ProHttpRequestQueue · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueue.java`
注解：

字段/常量（22）：
- `C22821 c22821`  L75
- `?? r6`  L76
- `Object obj`  L77
- `Mutex mutex`  L78
- `?? r7`  L79
- `Throwable th`  L80
- `Mutex mutex2`  L81
- `Object objInvoke`  L82
- `Object obj2`  L83
- `?? r0`  L84
- `Object obj3 = c22821.result`  L95
- `int i = c22821.label`  L97
- `Unit unit = Unit.INSTANCE`  L108
- `Mutex mutex3 = mutex`  L132
- `Unit unit2 = Unit.INSTANCE`  L138
- `Unit unit3 = Unit.INSTANCE`  L146
- `Unit unit4 = Unit.INSTANCE`  L164
- `Mutex mutex5 = mutex`  L194
- `Unit unit5 = Unit.INSTANCE`  L200
- `Mutex mutex6 = mutex`  L204
- `Unit unit6 = Unit.INSTANCE`  L214
- `List list`  L226

方法（2）：
- `Object execute(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation)`  L74
- `void clear()`  L225
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProHttpRequestQueue$C22821`
L37 · [class] static final C22821 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueue.java`
注解：

字段/常量（6）：
- `Object L$0`  L38
- `Object L$1`  L39
- `Object L$2`  L40
- `Object L$3`  L41
- `int label`  L42
- `Object result`  L43

方法（1）：
- `Object invokeSuspend(Object obj)`  L50 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProHttpRequestQueueKt`
L13 · [class] public final Ride3ProHttpRequestQueueKt · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpRequestQueueKt.java`
注解：

字段/常量（5）：
- `String RIDE3_PRO_FORMAT_SD_PATH = "/api/system/formatsd"`  L14
- `long RIDE3_PRO_FORMAT_SD_TIMEOUT_SECONDS = 60`  L15
- `String RIDE3_PRO_PLAYBACK_RAW_DATA_PATH = "/api/playback/rawdata"`  L16
- `String RIDE3_PRO_REQUEST_ID_HEADER = "X-Request-Id"`  L17
- `String RIDE3_PRO_PLAYBACK_THUMBNAIL_PATH = "/api/playback/thumbnail"`  L18

方法（1）：
- `OkHttpClient.Builder addRide3ProRequestIdInterceptor(OkHttpClient.Builder builder)`  L22
    - 体内字面量："<this>"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProHttpSerialDispatcher`
L14 · [class] public final Ride3ProHttpSerialDispatcher · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProHttpSerialDispatcher.java`
注解：

字段/常量（1）：
- `ExecutorService sharedExecutor`  L16

方法（4）：
- `private Ride3ProHttpSerialDispatcher()`  L18
- `Thread newThread(Runnable runnable)`  L24 @Override
    - 体内字面量："newSingleThreadExecutor(...)"
- `Thread sharedExecutor$lambda$1(Runnable runnable)`  L33
    - 体内字面量："Ride3ProHttpSerial"
- `Dispatcher newDispatcher()`  L39
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProPlaybackDayDetail`
L14 · [class] public final Ride3ProPlaybackDayDetail · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackDayDetail.java`
注解：

字段/常量（8）：
- `Integer date`  L17 @SerializedName(Progress.DATE)
- `Integer fileCount`  L20 @SerializedName("file_count")
- `Integer hourCount`  L23 @SerializedName("hour_count")
- `List<Ride3ProPlaybackHourInfo> hourList`  L26 @SerializedName("hour_list")
- `Integer num = this.date`  L84
- `Integer num2 = this.fileCount`  L86
- `Integer num3 = this.hourCount`  L88
- `List<Ride3ProPlaybackHourInfo> list = this.hourList`  L90

方法（16）：
- `public Ride3ProPlaybackDayDetail()`  L28
- `Ride3ProPlaybackDayDetail copy$default(Ride3ProPlaybackDayDetail ride3ProPlaybackDayDetail, Integer num, Integer num2, Integer num3, List list, int i, Object obj)`  L33
- `Integer getDate()`  L50
- `Integer getFileCount()`  L55
- `Integer getHourCount()`  L60
- `List<Ride3ProPlaybackHourInfo> component4()`  L64
- `Ride3ProPlaybackDayDetail copy(Integer date, Integer fileCount, Integer hourCount, List<Ride3ProPlaybackHourInfo> hourList)`  L68
- `boolean equals(Object other)`  L72
- `int hashCode()`  L83
- `String toString()`  L94
    - 体内字面量："Ride3ProPlaybackDayDetail(date=" · ", fileCount=" · ", hourCount=" · ", hourList=" · ")"
- `public Ride3ProPlaybackDayDetail(Integer num, Integer num2, Integer num3, List<Ride3ProPlaybackHourInfo> list)`  L98
- ` Ride3ProPlaybackDayDetail(Integer num, Integer num2, Integer num3, List list, int i, DefaultConstructorMarker defaultConstructorMarker)`  L105
- `Integer getDate()`  L109
- `Integer getFileCount()`  L113
- `Integer getHourCount()`  L117
- `List<Ride3ProPlaybackHourInfo> getHourList()`  L121
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProPlaybackDayInfo`
L13 · [class] public final Ride3ProPlaybackDayInfo · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackDayInfo.java`
注解：

字段/常量（6）：
- `Integer date`  L16 @SerializedName(Progress.DATE)
- `Integer fileCount`  L19 @SerializedName("file_count")
- `Integer lastFileIndex`  L22 @SerializedName("last_file_index")
- `Integer num = this.date`  L72
- `Integer num2 = this.fileCount`  L74
- `Integer num3 = this.lastFileIndex`  L76

方法（14）：
- `public Ride3ProPlaybackDayInfo()`  L24
- `Ride3ProPlaybackDayInfo copy$default(Ride3ProPlaybackDayInfo ride3ProPlaybackDayInfo, Integer num, Integer num2, Integer num3, int i, Object obj)`  L28
- `Integer getDate()`  L42
- `Integer getFileCount()`  L47
- `Integer getLastFileIndex()`  L52
- `Ride3ProPlaybackDayInfo copy(Integer date, Integer fileCount, Integer lastFileIndex)`  L56
- `boolean equals(Object other)`  L60
- `int hashCode()`  L71
- `String toString()`  L80
    - 体内字面量："Ride3ProPlaybackDayInfo(date=" · ", fileCount=" · ", lastFileIndex=" · ")"
- `public Ride3ProPlaybackDayInfo(Integer num, Integer num2, Integer num3)`  L84
- ` Ride3ProPlaybackDayInfo(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker)`  L90
- `Integer getDate()`  L94
- `Integer getFileCount()`  L98
- `Integer getLastFileIndex()`  L102
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProPlaybackFileCountInfo`
L13 · [class] public final Ride3ProPlaybackFileCountInfo · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackFileCountInfo.java`
注解：

字段/常量（8）：
- `Integer dayCount`  L16 @SerializedName("day_count")
- `List<Ride3ProPlaybackDayInfo> dayList`  L19 @SerializedName("day_list")
- `Integer nextFileIndex`  L22 @SerializedName("next_file_index")
- `Integer totalFileCount`  L25 @SerializedName("total_file_count")
- `Integer num = this.totalFileCount`  L83
- `Integer num2 = this.nextFileIndex`  L85
- `Integer num3 = this.dayCount`  L87
- `List<Ride3ProPlaybackDayInfo> list = this.dayList`  L89

方法（16）：
- `public Ride3ProPlaybackFileCountInfo()`  L27
- `Ride3ProPlaybackFileCountInfo copy$default(Ride3ProPlaybackFileCountInfo ride3ProPlaybackFileCountInfo, Integer num, Integer num2, Integer num3, List list, int i, Object obj)`  L32
- `Integer getTotalFileCount()`  L49
- `Integer getNextFileIndex()`  L54
- `Integer getDayCount()`  L59
- `List<Ride3ProPlaybackDayInfo> component4()`  L63
- `Ride3ProPlaybackFileCountInfo copy(Integer totalFileCount, Integer nextFileIndex, Integer dayCount, List<Ride3ProPlaybackDayInfo> dayList)`  L67
- `boolean equals(Object other)`  L71
- `int hashCode()`  L82
- `String toString()`  L93
    - 体内字面量："Ride3ProPlaybackFileCountInfo(totalFileCount=" · ", nextFileIndex=" · ", dayCount=" · ", dayList=" · ")"
- `public Ride3ProPlaybackFileCountInfo(Integer num, Integer num2, Integer num3, List<Ride3ProPlaybackDayInfo> list)`  L97
- ` Ride3ProPlaybackFileCountInfo(Integer num, Integer num2, Integer num3, List list, int i, DefaultConstructorMarker defaultConstructorMarker)`  L104
- `Integer getTotalFileCount()`  L108
- `Integer getNextFileIndex()`  L112
- `Integer getDayCount()`  L116
- `List<Ride3ProPlaybackDayInfo> getDayList()`  L120
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProPlaybackFileEntry`
L16 · [class] public final Ride3ProPlaybackFileEntry · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackFileEntry.java`
注解：

字段/常量（16）：
- `Integer fileIndex`  L19 @SerializedName("file_index")
- `String fileName`  L22 @SerializedName("file_name")
- `Long fileSize`  L25 @SerializedName(IjkMediaPlayer.OnNativeInvokeListener.ARG_FILE_SIZE)
- `String fileType`  L28 @SerializedName("file_type")
- `String name`  L31 @SerializedName(SerializableCookie.NAME)
- `String path`  L34 @SerializedName("path")
- `String time`  L37 @SerializedName(DeepLinkPresetEvent.UMEventParamTime)
- `Integer totalTime`  L40 @SerializedName("total_time")
- `String str = this.fileType`  L102
- `Integer num = this.fileIndex`  L104
- `String str2 = this.time`  L106
- `Long l = this.fileSize`  L108
- `Integer num2 = this.totalTime`  L110
- `String str3 = this.fileName`  L112
- `String str4 = this.name`  L114
- `String str5 = this.path`  L116

方法（23）：
- `public Ride3ProPlaybackFileEntry()`  L42
- `String getFileType()`  L47
- `Integer getFileIndex()`  L52
- `String getTime()`  L57
- `Long getFileSize()`  L62
- `Integer getTotalTime()`  L67
- `String getFileName()`  L72
- `String getName()`  L77
- `String getPath()`  L82
- `Ride3ProPlaybackFileEntry copy(String fileType, Integer fileIndex, String time, Long fileSize, Integer totalTime, String fileName, String name, String path)`  L86
- `boolean equals(Object other)`  L90
- `int hashCode()`  L101
- `String toString()`  L120
    - 体内字面量："Ride3ProPlaybackFileEntry(fileType=" · ", fileIndex=" · ", time=" · ", fileSize=" · ", totalTime=" · ", fileName=" · ", name=" · ", path=" · ")"
- `public Ride3ProPlaybackFileEntry(String str, Integer num, String str2, Long l, Integer num2, String str3, String str4, String str5)`  L124
- ` Ride3ProPlaybackFileEntry(String str, Integer num, String str2, Long l, Integer num2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker)`  L135
- `String getFileType()`  L139
- `Integer getFileIndex()`  L143
- `String getTime()`  L147
- `Long getFileSize()`  L151
- `Integer getTotalTime()`  L155
- `String getFileName()`  L159
- `String getName()`  L163
- `String getPath()`  L167
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProPlaybackFileListInfo`
L14 · [class] public final Ride3ProPlaybackFileListInfo · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackFileListInfo.java`
注解：

字段/常量（2）：
- `int fileCount`  L17 @SerializedName("file_count")
- `List<Ride3ProPlaybackFileEntry> fileList`  L20 @SerializedName("file_list")

方法（12）：
- `public Ride3ProPlaybackFileListInfo()`  L23
- `Ride3ProPlaybackFileListInfo copy$default(Ride3ProPlaybackFileListInfo ride3ProPlaybackFileListInfo, int i, List list, int i2, Object obj)`  L28
- `int getFileCount()`  L39
- `List<Ride3ProPlaybackFileEntry> component2()`  L43
- `Ride3ProPlaybackFileListInfo copy(int fileCount, List<Ride3ProPlaybackFileEntry> fileList)`  L47
    - 体内字面量："fileList"
- `boolean equals(Object other)`  L52
- `int hashCode()`  L63
- `String toString()`  L67
    - 体内字面量："Ride3ProPlaybackFileListInfo(fileCount=" · ", fileList=" · ")"
- `public Ride3ProPlaybackFileListInfo(int i, List<Ride3ProPlaybackFileEntry> fileList)`  L71
    - 体内字面量："fileList"
- `int getFileCount()`  L77
- ` Ride3ProPlaybackFileListInfo(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L81
- `List<Ride3ProPlaybackFileEntry> getFileList()`  L85
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProPlaybackHourInfo`
L12 · [class] public final Ride3ProPlaybackHourInfo · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackHourInfo.java`
注解：

字段/常量（6）：
- `Integer fileCount`  L15 @SerializedName("file_count")
- `Integer hour`  L18 @SerializedName("hour")
- `Integer lastFileIndex`  L21 @SerializedName("last_file_index")
- `Integer num = this.hour`  L71
- `Integer num2 = this.fileCount`  L73
- `Integer num3 = this.lastFileIndex`  L75

方法（14）：
- `public Ride3ProPlaybackHourInfo()`  L23
- `Ride3ProPlaybackHourInfo copy$default(Ride3ProPlaybackHourInfo ride3ProPlaybackHourInfo, Integer num, Integer num2, Integer num3, int i, Object obj)`  L27
- `Integer getHour()`  L41
- `Integer getFileCount()`  L46
- `Integer getLastFileIndex()`  L51
- `Ride3ProPlaybackHourInfo copy(Integer hour, Integer fileCount, Integer lastFileIndex)`  L55
- `boolean equals(Object other)`  L59
- `int hashCode()`  L70
- `String toString()`  L79
    - 体内字面量："Ride3ProPlaybackHourInfo(hour=" · ", fileCount=" · ", lastFileIndex=" · ")"
- `public Ride3ProPlaybackHourInfo(Integer num, Integer num2, Integer num3)`  L83
- ` Ride3ProPlaybackHourInfo(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker)`  L89
- `Integer getHour()`  L93
- `Integer getFileCount()`  L97
- `Integer getLastFileIndex()`  L101
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProPlaybackIndexValidator`
L17 · [class] public final Ride3ProPlaybackIndexValidator · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProPlaybackIndexValidator.java`
注解：

字段/常量（21）：
- `int DAY_MODULUS = 100`  L18
- `int MAX_FILE_INDEX = 9999`  L20
- `int MAX_HOUR = 23`  L21
- `int MAX_YYYYMMDD = 99999999`  L22
- `int MIN_FILE_INDEX = 0`  L23
- `int MIN_HOUR = 0`  L24
- `int MIN_YYYYMMDD = 10000000`  L25
- `int MONTH_DIVISOR = 100`  L26
- `int MONTH_MODULUS = 100`  L27
- `int YEAR_DIVISOR = 10000`  L28
- `List<Ride3ProPlaybackDayInfo> dayList`  L34
- `int i = 0`  L55
- `int i2 = i + 1`  L57
- `String str = "day_list[" + i + "]"`  L62
- `Ride3ProPlaybackIndexValidator ride3ProPlaybackIndexValidator = INSTANCE`  L63
- `int i = 0`  L96
- `int i2 = i + 1`  L98
- `String str = "hour_list[" + i + "]"`  L103
- `Ride3ProPlaybackIndexValidator ride3ProPlaybackIndexValidator = INSTANCE`  L104
- `int i = value / YEAR_DIVISOR`  L125
- `int i3 = value % 100`  L127

方法（7）：
- `private Ride3ProPlaybackIndexValidator()`  L30
- `List<String> validateFileCount(Ride3ProPlaybackFileCountInfo info)`  L33
- `List<String> validateDayInfo(int requestedDate, Ride3ProPlaybackDayDetail detail)`  L78
    - 体内字面量："detail" · "requested_date" · "file_count" · "hour_count" · "hour_list" · "DayInfo date does not match request date: requested=" · ", response=" · "file_count" · "hour_count" · "hour_count does not match hour_list size: reported=" · ", actual="
- `void requireValidDate(String fieldName, int value)`  L121
    - 体内字面量：" must be a valid YYYYMMDD date: "
- `void requireFileIndex(String fieldName, int value)`  L141
    - 体内字面量：" must be in 0..9999: "
- `void addNegativeWarning(String fieldName, Integer value, List<String> warnings)`  L147
    - 体内字面量：" is negative: "
- `T requireField(T value, String fieldName)`  L154
    - 体内字面量：" is required"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProProtocolFeatures`
L17 · [class] public final Ride3ProProtocolFeatures · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProProtocolFeatures.java`
注解：

字段/常量（3）：
- `String NV = "nv"`  L19
- `String REBOOT = "reboot"`  L20
- `Locale ROOT = Locale.ROOT`  L33

方法（2）：
- `private Ride3ProProtocolFeatures()`  L22
- `Set<String> normalize(Collection<String> features)`  L25
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProRequestIdAttachmentPolicy`
L12 · [class] public final Ride3ProRequestIdAttachmentPolicy · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProRequestIdAttachmentPolicy.java`
注解：

方法（3）：
- `private Ride3ProRequestIdAttachmentPolicy()`  L15
- `boolean shouldAttachTo(HttpUrl url)`  L18
    - 体内字面量："url"
- `boolean shouldAttachTo(String url)`  L23
    - 体内字面量："url"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProRequestIdInterceptor`
L15 · [class] public final Ride3ProRequestIdInterceptor · implements `Interceptor` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProRequestIdInterceptor.java`
注解：

字段/常量（1）：
- `Function0<Long> nextRequestId`  L16

方法（4）：
- `public Ride3ProRequestIdInterceptor()`  L19
- `public Ride3ProRequestIdInterceptor(Function0<Long> nextRequestId)`  L38
    - 体内字面量："nextRequestId"
- ` Ride3ProRequestIdInterceptor(C22831 c22831, int i, DefaultConstructorMarker defaultConstructorMarker)`  L43
- `Response intercept(Interceptor.Chain chain)`  L48 @Override
    - 体内字面量："chain"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProRequestIdInterceptor$C22831`
L26 · [class] C22831 · extends `FunctionReferenceImpl implements Function0<Long>` · implements `Function0<Long>` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProRequestIdInterceptor.java`
注解：

方法（1）：
- `Long invoke()`  L33 @Override
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProSdInfo`
L12 · [class] public final Ride3ProSdInfo · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProSdInfo.java`
注解：

字段/常量（6）：
- `Integer free`  L15 @SerializedName("free")
- `Integer status`  L18 @SerializedName("status")
- `Integer total`  L21 @SerializedName("total")
- `Integer num = this.status`  L71
- `Integer num2 = this.free`  L73
- `Integer num3 = this.total`  L75

方法（14）：
- `public Ride3ProSdInfo()`  L23
- `Ride3ProSdInfo copy$default(Ride3ProSdInfo ride3ProSdInfo, Integer num, Integer num2, Integer num3, int i, Object obj)`  L27
- `Integer getStatus()`  L41
- `Integer getFree()`  L46
- `Integer getTotal()`  L51
- `Ride3ProSdInfo copy(Integer status, Integer free, Integer total)`  L55
- `boolean equals(Object other)`  L59
- `int hashCode()`  L70
- `String toString()`  L79
    - 体内字面量："Ride3ProSdInfo(status=" · ", free=" · ", total=" · ")"
- `public Ride3ProSdInfo(Integer num, Integer num2, Integer num3)`  L83
- ` Ride3ProSdInfo(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker)`  L89
- `Integer getStatus()`  L93
- `Integer getFree()`  L97
- `Integer getTotal()`  L101
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProThumbnailRetryInterceptor`
L18 · [class] public final Ride3ProThumbnailRetryInterceptor · implements `Interceptor` · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProThumbnailRetryInterceptor.java`
注解：

字段/常量（3）：
- `long RETRY_DELAY_MILLIS = 500`  L22 @Deprecated
- `long retryDelayMillis`  L23
- `Function1<Long, Unit> waitBeforeRetry`  L24

方法（7）：
- `public Ride3ProThumbnailRetryInterceptor()`  L26
- `public Ride3ProThumbnailRetryInterceptor(long j, Function1<? super Long, Unit> waitBeforeRetry)`  L31
    - 体内字面量："waitBeforeRetry" · "retryDelayMillis must not be negative"
- ` Ride3ProThumbnailRetryInterceptor(long j, C22841 c22841, int i, DefaultConstructorMarker defaultConstructorMarker)`  L40
- `Unit invoke(Long l)`  L43 @Override
- `void invoke(long j2)`  L48
- `Response intercept(Interceptor.Chain chain)`  L55 @Override
    - 体内字面量："chain" · "GET"
- `boolean hasEofCause(IOException iOException)`  L80
    - 体内字面量："Lcom/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProThumbnailRetryInterceptor$Companion;" · "()V" · "RETRY_DELAY_MILLIS" · "app_release_64"
### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProThumbnailRetryInterceptor$Companion`
L91 · [class] private static final Companion · `com/tuwinsmart/tuwin/data/source/remote/api/ride3pro/Ride3ProThumbnailRetryInterceptor.java`
注解：

方法（2）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L92
- `private Companion()`  L96
### `com.tuwinsmart.tuwin.data.source.remote.api.TuwinSuspendApi`
L16 · [interface] public TuwinSuspendApi · `com/tuwinsmart/tuwin/data/source/remote/api/TuwinSuspendApi.java`
注解：

方法（1）：
- `Object getBanners(Continuation<? super BannerResponse> continuation)`  L21 @GET("banner")
    - 体内字面量："newota" · "boardversion"
### `com.tuwinsmart.tuwin.data.source.remote.dto.BannerData`
L13 · [class] public final BannerData · `com/tuwinsmart/tuwin/data/source/remote/dto/BannerData.java`
注解：

字段/常量（6）：
- `List<BannerItem> banners`  L16 @SerializedName("banners")
- `Long timestamp`  L19 @SerializedName(UMCrash.SP_KEY_TIMESTAMP)
- `Integer total`  L22 @SerializedName("total")
- `List<BannerItem> list = this.banners`  L68
- `Integer num = this.total`  L70
- `Long l = this.timestamp`  L72

方法（12）：
- `BannerData copy$default(BannerData bannerData, List list, Integer num, Long l, int i, Object obj)`  L25
- `List<BannerItem> component1()`  L38
- `Integer getTotal()`  L43
- `Long getTimestamp()`  L48
- `BannerData copy(List<BannerItem> banners, Integer total, Long timestamp)`  L52
- `boolean equals(Object other)`  L56
- `int hashCode()`  L67
- `String toString()`  L76
    - 体内字面量："BannerData(banners=" · ", total=" · ", timestamp=" · ")"
- `public BannerData(List<BannerItem> list, Integer num, Long l)`  L80
- `List<BannerItem> getBanners()`  L86
- `Integer getTotal()`  L90
- `Long getTimestamp()`  L94
### `com.tuwinsmart.tuwin.data.source.remote.dto.BannerItem`
L11 · [class] public final BannerItem · `com/tuwinsmart/tuwin/data/source/remote/dto/BannerItem.java`
注解：

字段/常量（19）：
- `String description`  L14 @SerializedName("description")
- `Integer id`  L17 @SerializedName("id")
- `String imageUrl`  L20 @SerializedName("image_url")
- `String link`  L23 @SerializedName("link")
- `Integer sortOrder`  L26 @SerializedName("sort_order")
- `String status`  L29 @SerializedName("status")
- `String title`  L32 @SerializedName("title")
- `String str6 = str`  L41
- `String str7 = str2`  L45
- `String str8 = str3`  L49
- `String str9 = str4`  L53
- `Integer num3 = num2`  L57
- `Integer num = this.id`  L115
- `String str = this.imageUrl`  L117
- `String str2 = this.title`  L119
- `String str3 = this.description`  L121
- `String str4 = this.link`  L123
- `Integer num2 = this.sortOrder`  L125
- `String str5 = this.status`  L127

方法（20）：
- `BannerItem copy$default(BannerItem bannerItem, Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, int i, Object obj)`  L34
- `Integer getId()`  L65
- `String getImageUrl()`  L70
- `String getTitle()`  L75
- `String getDescription()`  L80
- `String getLink()`  L85
- `Integer getSortOrder()`  L90
- `String getStatus()`  L95
- `BannerItem copy(Integer id, String imageUrl, String title, String description, String link, Integer sortOrder, String status)`  L99
- `boolean equals(Object other)`  L103
- `int hashCode()`  L114
- `String toString()`  L131
    - 体内字面量："BannerItem(id=" · ", imageUrl=" · ", title=" · ", description=" · ", link=" · ", sortOrder=" · ", status=" · ")"
- `public BannerItem(Integer num, String str, String str2, String str3, String str4, Integer num2, String str5)`  L135
- `Integer getId()`  L145
- `String getImageUrl()`  L149
- `String getTitle()`  L153
- `String getDescription()`  L157
- `String getLink()`  L161
- `Integer getSortOrder()`  L165
- `String getStatus()`  L169
### `com.tuwinsmart.tuwin.data.source.remote.dto.BannerResponse`
L12 · [class] public final BannerResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/BannerResponse.java`
注解：

字段/常量（5）：
- `int code`  L15 @SerializedName(C3077cm.f1931g)
- `BannerData data`  L18 @SerializedName("data")
- `String message`  L21 @SerializedName("message")
- `String str = this.message`  L68
- `BannerData bannerData = this.data`  L70

方法（12）：
- `BannerResponse copy$default(BannerResponse bannerResponse, int i, String str, BannerData bannerData, int i2, Object obj)`  L23
- `int getCode()`  L37
- `String getMessage()`  L42
- `BannerData getData()`  L47
- `BannerResponse copy(int code, String message, BannerData data)`  L51
- `boolean equals(Object other)`  L55
- `int hashCode()`  L66
- `String toString()`  L74
    - 体内字面量："BannerResponse(code=" · ", message=" · ", data=" · ")"
- `public BannerResponse(int i, String str, BannerData bannerData)`  L78
- `int getCode()`  L84
- `String getMessage()`  L88
- `BannerData getData()`  L92
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.GravityDirectionResponse`
L12 · [class] public final GravityDirectionResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/GravityDirectionResponse.java`
注解：

字段/常量（3）：
- `List<GravityInfo> info`  L15 @SerializedName("info")
- `int result`  L18 @SerializedName("result")
- `List<GravityInfo> list = this.info`  L57

方法（10）：
- `GravityDirectionResponse copy$default(GravityDirectionResponse gravityDirectionResponse, int i, List list, int i2, Object obj)`  L21
- `int getResult()`  L32
- `List<GravityInfo> component2()`  L36
- `GravityDirectionResponse copy(int result, List<GravityInfo> info)`  L40
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L61
    - 体内字面量："GravityDirectionResponse(result=" · ", info=" · ")"
- `public GravityDirectionResponse(int i, List<GravityInfo> list)`  L65
- `int getResult()`  L70
- `List<GravityInfo> getInfo()`  L74
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.GravityInfo`
L12 · [class] public final GravityInfo · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/GravityInfo.java`
注解：

字段/常量（4）：
- `String name`  L15 @SerializedName(SerializableCookie.NAME)
- `Integer value`  L18 @SerializedName("value")
- `String str = this.name`  L56
- `Integer num = this.value`  L58

方法（10）：
- `GravityInfo copy$default(GravityInfo gravityInfo, String str, Integer num, int i, Object obj)`  L20
- `String getName()`  L31
- `Integer getValue()`  L36
- `GravityInfo copy(String name, Integer value)`  L40
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L62
    - 体内字面量："GravityInfo(name=" · ", value=" · ")"
- `public GravityInfo(String str, Integer num)`  L66
- `String getName()`  L71
- `Integer getValue()`  L75
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3BatteryInfo`
L11 · [class] public final M3BatteryInfo · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3BatteryInfo.java`
注解：

字段/常量（3）：
- `int capacity`  L14 @SerializedName("capacity")
- `int charge`  L17 @SerializedName("charge")
- `int i = 0`  L21

方法（12）：
- `public M3BatteryInfo()`  L20
- `M3BatteryInfo copy$default(M3BatteryInfo m3BatteryInfo, int i, int i2, int i3, Object obj)`  L25
- `int getCapacity()`  L36
- `int getCharge()`  L41
- `M3BatteryInfo copy(int capacity, int charge)`  L45
- `boolean equals(Object other)`  L49
- `int hashCode()`  L60
- `String toString()`  L64
    - 体内字面量："M3BatteryInfo(capacity=" · ", charge=" · ")"
- `public M3BatteryInfo(int i, int i2)`  L68
- ` M3BatteryInfo(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker)`  L73
- `int getCapacity()`  L77
- `int getCharge()`  L81
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3BatteryInfoResponse`
L11 · [class] public final M3BatteryInfoResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3BatteryInfoResponse.java`
注解：

字段/常量（3）：
- `M3BatteryInfo info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")
- `M3BatteryInfo m3BatteryInfo = this.info`  L56

方法（10）：
- `M3BatteryInfoResponse copy$default(M3BatteryInfoResponse m3BatteryInfoResponse, int i, M3BatteryInfo m3BatteryInfo, int i2, Object obj)`  L19
- `int getResult()`  L30
- `M3BatteryInfo getInfo()`  L35
- `M3BatteryInfoResponse copy(int result, M3BatteryInfo info)`  L39
- `boolean equals(Object other)`  L43
- `int hashCode()`  L54
- `String toString()`  L60
    - 体内字面量："M3BatteryInfoResponse(result=" · ", info=" · ")"
- `public M3BatteryInfoResponse(int i, M3BatteryInfo m3BatteryInfo)`  L64
- `int getResult()`  L69
- `M3BatteryInfo getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3CurModeInfo`
L12 · [class] public final M3CurModeInfo · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3CurModeInfo.java`
注解：

字段/常量（4）：
- `String name`  L15 @SerializedName(SerializableCookie.NAME)
- `Integer value`  L18 @SerializedName("value")
- `String str = this.name`  L56
- `Integer num = this.value`  L58

方法（10）：
- `M3CurModeInfo copy$default(M3CurModeInfo m3CurModeInfo, String str, Integer num, int i, Object obj)`  L20
- `String getName()`  L31
- `Integer getValue()`  L36
- `M3CurModeInfo copy(String name, Integer value)`  L40
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L62
    - 体内字面量："M3CurModeInfo(name=" · ", value=" · ")"
- `public M3CurModeInfo(String str, Integer num)`  L66
- `String getName()`  L71
- `Integer getValue()`  L75
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3CurModeResponse`
L12 · [class] public final M3CurModeResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3CurModeResponse.java`
注解：

字段/常量（3）：
- `List<M3CurModeInfo> info`  L15 @SerializedName("info")
- `int result`  L18 @SerializedName("result")
- `List<M3CurModeInfo> list = this.info`  L57

方法（10）：
- `M3CurModeResponse copy$default(M3CurModeResponse m3CurModeResponse, int i, List list, int i2, Object obj)`  L21
- `int getResult()`  L32
- `List<M3CurModeInfo> component2()`  L36
- `M3CurModeResponse copy(int result, List<M3CurModeInfo> info)`  L40
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L61
    - 体内字面量："M3CurModeResponse(result=" · ", info=" · ")"
- `public M3CurModeResponse(int i, List<M3CurModeInfo> list)`  L65
- `int getResult()`  L70
- `List<M3CurModeInfo> getInfo()`  L74
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3DeleteFileResponse`
L11 · [class] public final M3DeleteFileResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3DeleteFileResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3DeleteFileResponse copy$default(M3DeleteFileResponse m3DeleteFileResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3DeleteFileResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3DeleteFileResponse(result=" · ", info=" · ")"
- `public M3DeleteFileResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3DeviceAttrInfo`
L14 · [class] public final M3DeviceAttrInfo · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3DeviceAttrInfo.java`
注解：

字段/常量（9）：
- `String bssid`  L17 @SerializedName(DeviceWifiScanDialog.RESULT_BSSID)
- `int camnum`  L20 @SerializedName("camnum")
- `int curcamid`  L23 @SerializedName("curcamid")
- `String hwver`  L26 @SerializedName("hwver")
- `String otaver`  L29 @SerializedName("otaver")
- `String softver`  L32 @SerializedName("softver")
- `String ssid`  L35 @SerializedName(DeviceWifiScanDialog.RESULT_SSID)
- `String uuid`  L38 @SerializedName("uuid")
- `int wifireboot`  L41 @SerializedName("wifireboot")

方法（25）：
- `public M3DeviceAttrInfo()`  L43
- `String getUuid()`  L48
- `String getSoftver()`  L53
- `String getOtaver()`  L58
- `String getHwver()`  L63
- `String getSsid()`  L68
- `String getBssid()`  L73
- `int getCamnum()`  L78
- `int getCurcamid()`  L83
- `int getWifireboot()`  L88
- `M3DeviceAttrInfo copy(String uuid, String softver, String otaver, String hwver, String ssid, String bssid, int camnum, int curcamid, int wifireboot)`  L92
    - 体内字面量："uuid" · "softver" · "otaver" · "hwver" · "ssid" · "bssid"
- `boolean equals(Object other)`  L102
- `int hashCode()`  L113
- `String toString()`  L117
    - 体内字面量："M3DeviceAttrInfo(uuid=" · ", softver=" · ", otaver=" · ", hwver=" · ", ssid=" · ", bssid=" · ", camnum=" · ", curcamid=" · ", wifireboot=" · ")"
- `public M3DeviceAttrInfo(String uuid, String softver, String otaver, String hwver, String ssid, String bssid, int i, int i2, int i3)`  L121
    - 体内字面量："uuid" · "softver" · "otaver" · "hwver" · "ssid" · "bssid"
- ` M3DeviceAttrInfo(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker)`  L139
- `String getUuid()`  L143
- `String getSoftver()`  L147
- `String getOtaver()`  L151
- `String getHwver()`  L155
- `String getSsid()`  L159
- `String getBssid()`  L163
- `int getCamnum()`  L167
- `int getCurcamid()`  L171
- `int getWifireboot()`  L175
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3DeviceAttrResponse`
L11 · [class] public final M3DeviceAttrResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3DeviceAttrResponse.java`
注解：

字段/常量（2）：
- `M3DeviceAttrInfo info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3DeviceAttrResponse copy$default(M3DeviceAttrResponse m3DeviceAttrResponse, int i, M3DeviceAttrInfo m3DeviceAttrInfo, int i2, Object obj)`  L19
- `int getResult()`  L30
- `M3DeviceAttrInfo getInfo()`  L35
- `M3DeviceAttrResponse copy(int result, M3DeviceAttrInfo info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3DeviceAttrResponse(result=" · ", info=" · ")"
- `public M3DeviceAttrResponse(int i, M3DeviceAttrInfo info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `M3DeviceAttrInfo getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3DeviceInfo`
L12 · [class] public final M3DeviceInfo · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3DeviceInfo.java`
注解：

字段/常量（4）：
- `String company`  L13
- `String model`  L14
- `String soc`  L15
- `String sp`  L16

方法（15）：
- `M3DeviceInfo copy$default(M3DeviceInfo m3DeviceInfo, String str, String str2, String str3, String str4, int i, Object obj)`  L18
- `String getModel()`  L35
- `String getCompany()`  L40
- `String getSoc()`  L45
- `String getSp()`  L50
- `M3DeviceInfo copy(String model, String company, String soc, String sp)`  L54
    - 体内字面量："model" · "company" · "soc" · "sp"
- `boolean equals(Object other)`  L62
- `int hashCode()`  L73
- `public M3DeviceInfo(String model, String company, String soc, String sp)`  L77
    - 体内字面量："model" · "company" · "soc" · "sp"
- `String getModel()`  L88
- `String getCompany()`  L92
- `String getSoc()`  L96
- `String getSp()`  L100
- `boolean isValidM3Device()`  L104
- `String toString()`  L108
    - 体内字面量："M3DeviceInfo(model='" · "', company='" · "', soc='" · "', sp='" · "')"
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3FileItem`
L23 · [class] public final M3FileItem · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3FileItem.java`
注解：

字段/常量（18）：
- `long createTime`  L26 @SerializedName("createtime")
- `int duration`  L29 @SerializedName("duration")
- `String name`  L32 @SerializedName(SerializableCookie.NAME)
- `long size`  L35 @SerializedName("size")
- `int type`  L38 @SerializedName("type")
- `int i4 = i`  L47
- `long j3 = j`  L51
- `long j4 = j2`  L55
- `int i = this.type`  L149
- `long j = this.size`  L174
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L179
- `StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE`  L185
- `StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE`  L190
- `int i`  L197
- `int i2 = i / 3600`  L201
- `int i4 = i % 60`  L203
- `StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE`  L205
- `StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE`  L210

方法（24）：
- `M3FileItem copy$default(M3FileItem m3FileItem, String str, int i, long j, long j2, int i2, int i3, Object obj)`  L40
- `String getName()`  L63
- `int getDuration()`  L68
- `long getSize()`  L73
- `long getCreateTime()`  L78
- `int getType()`  L83
- `M3FileItem copy(String name, int duration, long size, long createTime, int type)`  L87
    - 体内字面量："name"
- `boolean equals(Object other)`  L92
- `int hashCode()`  L103
- `String toString()`  L107
    - 体内字面量："M3FileItem(name=" · ", duration=" · ", size=" · ", createTime=" · ", type=" · ")"
- `public M3FileItem(String name, int i, long j, long j2, int i2)`  L111
    - 体内字面量："name"
- `String getName()`  L120
- `int getDuration()`  L124
- `long getSize()`  L128
- `long getCreateTime()`  L132
- `int getType()`  L136
- `String getFileName()`  L140
    - 体内字面量："/"
- `String getFileExtension()`  L144
    - 体内字面量："."
- `String getTypeDescription()`  L148
- `boolean isVideo()`  L165
- `boolean isImage()`  L169
- `String getFormattedSize()`  L173
- `String getFormattedDuration()`  L196
- `String getFormattedCreateTime(String pattern)`  L216
    - 体内字面量："pattern"
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3FileListResponse`
L13 · [class] public final M3FileListResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3FileListResponse.java`
注解：

字段/常量（3）：
- `List<M3FolderInfo> info`  L16 @SerializedName("info")
- `int result`  L19 @SerializedName("result")
- `List<M3FolderInfo> list = this.info`  L58

方法（11）：
- `M3FileListResponse copy$default(M3FileListResponse m3FileListResponse, int i, List list, int i2, Object obj)`  L22
- `int getResult()`  L33
- `List<M3FolderInfo> component2()`  L37
- `M3FileListResponse copy(int result, List<M3FolderInfo> info)`  L41
- `boolean equals(Object other)`  L45
- `int hashCode()`  L56
- `String toString()`  L62
    - 体内字面量："M3FileListResponse(result=" · ", info=" · ")"
- `public M3FileListResponse(int i, List<M3FolderInfo> list)`  L66
- ` M3FileListResponse(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L71
- `int getResult()`  L75
- `List<M3FolderInfo> getInfo()`  L79
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3FolderInfo`
L18 · [class] public final M3FolderInfo · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3FolderInfo.java`
注解：

字段/常量（4）：
- `int count`  L21 @SerializedName("count")
- `List<M3FileItem> files`  L24 @SerializedName("files")
- `String folder`  L27 @SerializedName(Progress.FOLDER)
- `String str = this.folder`  L107

方法（14）：
- `M3FolderInfo copy$default(M3FolderInfo m3FolderInfo, String str, int i, List list, int i2, Object obj)`  L30
- `String getFolder()`  L44
- `int getCount()`  L49
- `List<M3FileItem> component3()`  L53
- `M3FolderInfo copy(String folder, int count, List<M3FileItem> files)`  L57
    - 体内字面量："folder" · "files"
- `boolean equals(Object other)`  L63
- `int hashCode()`  L74
- `String toString()`  L78
    - 体内字面量："M3FolderInfo(folder=" · ", count=" · ", files=" · ")"
- `public M3FolderInfo(String folder, int i, List<M3FileItem> files)`  L82
    - 体内字面量："folder" · "files"
- `String getFolder()`  L90
- `int getCount()`  L94
- ` M3FolderInfo(String str, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L98
- `List<M3FileItem> getFiles()`  L102
- `Integer getFolderDisplayNameRes()`  L106
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3MediaInfo`
L12 · [class] public final M3MediaInfo · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3MediaInfo.java`
注解：

字段/常量（3）：
- `int port`  L13
- `String rtsp`  L14
- `String transport`  L15

方法（12）：
- `M3MediaInfo copy$default(M3MediaInfo m3MediaInfo, String str, String str2, int i, int i2, Object obj)`  L17
- `String getRtsp()`  L31
- `String getTransport()`  L36
- `int getPort()`  L41
- `M3MediaInfo copy(String rtsp, String transport, int port)`  L45
    - 体内字面量："rtsp" · "transport"
- `boolean equals(Object other)`  L51
- `int hashCode()`  L62
- `String toString()`  L66
    - 体内字面量："M3MediaInfo(rtsp=" · ", transport=" · ", port=" · ")"
- `public M3MediaInfo(String rtsp, String transport, int i)`  L70
    - 体内字面量："rtsp" · "transport"
- `String getRtsp()`  L78
- `String getTransport()`  L82
- `int getPort()`  L86
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3MediaInfoResponse`
L14 · [class] public final M3MediaInfoResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3MediaInfoResponse.java`
注解：

字段/常量（6）：
- `JsonElement info`  L15
- `int result`  L16
- `JsonElement jsonElement = this.info`  L55
- `JsonElement jsonElement = this.info`  L81
- `JsonElement jsonElement = this.info`  L99
- `int i = this.result`  L101

方法（13）：
- `M3MediaInfoResponse copy$default(M3MediaInfoResponse m3MediaInfoResponse, int i, JsonElement jsonElement, int i2, Object obj)`  L18
- `int getResult()`  L29
- `JsonElement getInfo()`  L34
- `M3MediaInfoResponse copy(int result, JsonElement info)`  L38
- `boolean equals(Object other)`  L42
- `int hashCode()`  L53
- `String toString()`  L59
    - 体内字面量："M3MediaInfoResponse(result=" · ", info=" · ")"
- `public M3MediaInfoResponse(int i, JsonElement jsonElement)`  L63
- `int getResult()`  L68
- `JsonElement getInfo()`  L72
- `boolean isSuccess()`  L76
- `M3MediaInfo getMediaInfo()`  L80
- `String getErrorMessage()`  L98
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3ParamItem`
L16 · [class] public final M3ParamItem · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamItem.java`
注解：

字段/常量（16）：
- `Integer curIndex`  L19 @SerializedName("cur_index")
- `Integer enable`  L22 @SerializedName(C3077cm.f1941q)
- `List<Integer> index`  L25 @SerializedName(C3174a.f2698H)
- `List<String> items`  L28 @SerializedName("items")
- `List<String> itemsDisable`  L31 @SerializedName("items_disable")
- `String name`  L34 @SerializedName(SerializableCookie.NAME)
- `List list4 = list`  L48
- `List list5 = list2`  L52
- `List list6 = list3`  L56
- `Integer num3 = num`  L60
- `String str = this.name`  L110
- `List<String> list = this.items`  L112
- `List<String> list2 = this.itemsDisable`  L114
- `List<Integer> list3 = this.index`  L116
- `Integer num = this.enable`  L118
- `Integer num2 = this.curIndex`  L120

方法（20）：
- `public M3ParamItem()`  L36
- `M3ParamItem copy$default(M3ParamItem m3ParamItem, String str, List list, List list2, List list3, Integer num, Integer num2, int i, Object obj)`  L41
- `String getName()`  L68
- `List<String> component2()`  L72
- `List<String> component3()`  L76
- `List<Integer> component4()`  L80
- `Integer getEnable()`  L85
- `Integer getCurIndex()`  L90
- `M3ParamItem copy(String name, List<String> items, List<String> itemsDisable, List<Integer> index, Integer enable, Integer curIndex)`  L94
- `boolean equals(Object other)`  L98
- `int hashCode()`  L109
- `String toString()`  L124
    - 体内字面量："M3ParamItem(name=" · ", items=" · ", itemsDisable=" · ", index=" · ", enable=" · ", curIndex=" · ")"
- `public M3ParamItem(String str, List<String> list, List<String> list2, List<Integer> list3, Integer num, Integer num2)`  L128
- ` M3ParamItem(String str, List list, List list2, List list3, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker)`  L137
- `String getName()`  L141
- `List<String> getItems()`  L145
- `List<String> getItemsDisable()`  L149
- `List<Integer> getIndex()`  L153
- `Integer getEnable()`  L157
- `Integer getCurIndex()`  L161
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3ParamItemResponse`
L11 · [class] public final M3ParamItemResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamItemResponse.java`
注解：

字段/常量（3）：
- `M3ParamItem info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")
- `M3ParamItem m3ParamItem = this.info`  L56

方法（10）：
- `M3ParamItemResponse copy$default(M3ParamItemResponse m3ParamItemResponse, int i, M3ParamItem m3ParamItem, int i2, Object obj)`  L19
- `int getResult()`  L30
- `M3ParamItem getInfo()`  L35
- `M3ParamItemResponse copy(int result, M3ParamItem info)`  L39
- `boolean equals(Object other)`  L43
- `int hashCode()`  L54
- `String toString()`  L60
    - 体内字面量："M3ParamItemResponse(result=" · ", info=" · ")"
- `public M3ParamItemResponse(int i, M3ParamItem m3ParamItem)`  L64
- `int getResult()`  L69
- `M3ParamItem getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3ParamItemsResponse`
L12 · [class] public final M3ParamItemsResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamItemsResponse.java`
注解：

字段/常量（3）：
- `List<M3ParamItem> info`  L15 @SerializedName("info")
- `int result`  L18 @SerializedName("result")
- `List<M3ParamItem> list = this.info`  L57

方法（10）：
- `M3ParamItemsResponse copy$default(M3ParamItemsResponse m3ParamItemsResponse, int i, List list, int i2, Object obj)`  L21
- `int getResult()`  L32
- `List<M3ParamItem> component2()`  L36
- `M3ParamItemsResponse copy(int result, List<M3ParamItem> info)`  L40
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L61
    - 体内字面量："M3ParamItemsResponse(result=" · ", info=" · ")"
- `public M3ParamItemsResponse(int i, List<M3ParamItem> list)`  L65
- `int getResult()`  L70
- `List<M3ParamItem> getInfo()`  L74
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3ParamValue`
L15 · [class] public final M3ParamValue · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamValue.java`
注解：

字段/常量（4）：
- `String name`  L18 @SerializedName(SerializableCookie.NAME)
- `String value`  L22 @SerializedName("value") @JsonAdapter(M3ParamValueTypeAdapter.class)
- `String str = this.name`  L65
- `String str2 = this.value`  L67

方法（12）：
- `public M3ParamValue()`  L25
- `M3ParamValue copy$default(M3ParamValue m3ParamValue, String str, String str2, int i, Object obj)`  L29
- `String getName()`  L40
- `String getValue()`  L45
- `M3ParamValue copy(String name, String value)`  L49
- `boolean equals(Object other)`  L53
- `int hashCode()`  L64
- `String toString()`  L71
    - 体内字面量："M3ParamValue(name=" · ", value=" · ")"
- `public M3ParamValue(String str, String str2)`  L75
- ` M3ParamValue(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker)`  L80
- `String getName()`  L84
- `String getValue()`  L88
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3ParamValueResponse`
L11 · [class] public final M3ParamValueResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamValueResponse.java`
注解：

字段/常量（3）：
- `M3ParamValue info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")
- `M3ParamValue m3ParamValue = this.info`  L56

方法（10）：
- `M3ParamValueResponse copy$default(M3ParamValueResponse m3ParamValueResponse, int i, M3ParamValue m3ParamValue, int i2, Object obj)`  L19
- `int getResult()`  L30
- `M3ParamValue getInfo()`  L35
- `M3ParamValueResponse copy(int result, M3ParamValue info)`  L39
- `boolean equals(Object other)`  L43
- `int hashCode()`  L54
- `String toString()`  L60
    - 体内字面量："M3ParamValueResponse(result=" · ", info=" · ")"
- `public M3ParamValueResponse(int i, M3ParamValue m3ParamValue)`  L64
- `int getResult()`  L69
- `M3ParamValue getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3ParamValuesResponse`
L12 · [class] public final M3ParamValuesResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ParamValuesResponse.java`
注解：

字段/常量（3）：
- `List<M3ParamValue> info`  L15 @SerializedName("info")
- `int result`  L18 @SerializedName("result")
- `List<M3ParamValue> list = this.info`  L57

方法（10）：
- `M3ParamValuesResponse copy$default(M3ParamValuesResponse m3ParamValuesResponse, int i, List list, int i2, Object obj)`  L21
- `int getResult()`  L32
- `List<M3ParamValue> component2()`  L36
- `M3ParamValuesResponse copy(int result, List<M3ParamValue> info)`  L40
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L61
    - 体内字面量："M3ParamValuesResponse(result=" · ", info=" · ")"
- `public M3ParamValuesResponse(int i, List<M3ParamValue> list)`  L65
- `int getResult()`  L70
- `List<M3ParamValue> getInfo()`  L74
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3PlaybackResponse`
L11 · [class] public final M3PlaybackResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3PlaybackResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3PlaybackResponse copy$default(M3PlaybackResponse m3PlaybackResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3PlaybackResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3PlaybackResponse(result=" · ", info=" · ")"
- `public M3PlaybackResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3ProductInfoResponse`
L12 · [class] public final M3ProductInfoResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ProductInfoResponse.java`
注解：

字段/常量（5）：
- `Object info`  L15 @SerializedName("info")
- `int result`  L18 @SerializedName("result")
- `Object obj = this.info`  L57
- `String str2 = "<binary/metadata>"`  L89
- `Object obj = this.info`  L116

方法（13）：
- `M3ProductInfoResponse copy$default(M3ProductInfoResponse m3ProductInfoResponse, int i, Object obj, int i2, Object obj2)`  L20
- `int getResult()`  L31
- `Object getInfo()`  L36
- `M3ProductInfoResponse copy(int result, Object info)`  L40
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L61
    - 体内字面量："M3ProductInfoResponse(result=" · ", info=" · ")"
- `public M3ProductInfoResponse(int i, Object obj)`  L65
- `int getResult()`  L70
- `Object getInfo()`  L74
- `boolean isSuccess()`  L78
- `M3DeviceInfo parseDeviceInfo()`  L82
    - 体内字面量："model"
- `String getErrorMessage()`  L114
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3RecDurationInfo`
L11 · [class] public final M3RecDurationInfo · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3RecDurationInfo.java`
注解：

字段/常量（1）：
- `int duration`  L14 @SerializedName("duration")

方法（10）：
- `public M3RecDurationInfo()`  L16
- `M3RecDurationInfo copy$default(M3RecDurationInfo m3RecDurationInfo, int i, int i2, Object obj)`  L20
- `int getDuration()`  L28
- `M3RecDurationInfo copy(int duration)`  L32
- `boolean equals(Object other)`  L36
- `int hashCode()`  L43
- `String toString()`  L47
    - 体内字面量："M3RecDurationInfo(duration=" · ")"
- `public M3RecDurationInfo(int i)`  L51
- ` M3RecDurationInfo(int i, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L55
- `int getDuration()`  L59
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3RecDurationResponse`
L11 · [class] public final M3RecDurationResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3RecDurationResponse.java`
注解：

字段/常量（3）：
- `M3RecDurationInfo info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")
- `M3RecDurationInfo m3RecDurationInfo = this.info`  L56

方法（10）：
- `M3RecDurationResponse copy$default(M3RecDurationResponse m3RecDurationResponse, int i, M3RecDurationInfo m3RecDurationInfo, int i2, Object obj)`  L19
- `int getResult()`  L30
- `M3RecDurationInfo getInfo()`  L35
- `M3RecDurationResponse copy(int result, M3RecDurationInfo info)`  L39
- `boolean equals(Object other)`  L43
- `int hashCode()`  L54
- `String toString()`  L60
    - 体内字面量："M3RecDurationResponse(result=" · ", info=" · ")"
- `public M3RecDurationResponse(int i, M3RecDurationInfo m3RecDurationInfo)`  L64
- `int getResult()`  L69
- `M3RecDurationInfo getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3RecordResponse`
L11 · [class] public final M3RecordResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3RecordResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3RecordResponse copy$default(M3RecordResponse m3RecordResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3RecordResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3RecordResponse(result=" · ", info=" · ")"
- `public M3RecordResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3ResetResponse`
L11 · [class] public final M3ResetResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3ResetResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3ResetResponse copy$default(M3ResetResponse m3ResetResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3ResetResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3ResetResponse(result=" · ", info=" · ")"
- `public M3ResetResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SdFormatResponse`
L11 · [class] public final M3SdFormatResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SdFormatResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3SdFormatResponse copy$default(M3SdFormatResponse m3SdFormatResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3SdFormatResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3SdFormatResponse(result=" · ", info=" · ")"
- `public M3SdFormatResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SDInfo`
L12 · [class] public final M3SDInfo · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SDInfo.java`
注解：

字段/常量（4）：
- `int free`  L15 @SerializedName("free")
- `int status`  L18 @SerializedName("status")
- `int total`  L21 @SerializedName("total")
- `int i = this.status`  L105

方法（16）：
- `public M3SDInfo()`  L23
- `M3SDInfo copy$default(M3SDInfo m3SDInfo, int i, int i2, int i3, int i4, Object obj)`  L27
- `int getStatus()`  L41
- `int getFree()`  L46
- `int getTotal()`  L51
- `M3SDInfo copy(int status, int free, int total)`  L55
- `boolean equals(Object other)`  L59
- `int hashCode()`  L70
- `String toString()`  L74
    - 体内字面量："M3SDInfo(status=" · ", free=" · ", total=" · ")"
- `public M3SDInfo(int i, int i2, int i3)`  L78
- ` M3SDInfo(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker)`  L84
- `int getStatus()`  L88
- `void setStatus(int i)`  L92
- `int getFree()`  L96
- `int getTotal()`  L100
- `String getStatusDescription()`  L104
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SDInfoResponse`
L11 · [class] public final M3SDInfoResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SDInfoResponse.java`
注解：

字段/常量（3）：
- `M3SDInfo info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")
- `M3SDInfo m3SDInfo = this.info`  L56

方法（10）：
- `M3SDInfoResponse copy$default(M3SDInfoResponse m3SDInfoResponse, int i, M3SDInfo m3SDInfo, int i2, Object obj)`  L19
- `int getResult()`  L30
- `M3SDInfo getInfo()`  L35
- `M3SDInfoResponse copy(int result, M3SDInfo info)`  L39
- `boolean equals(Object other)`  L43
- `int hashCode()`  L54
- `String toString()`  L60
    - 体内字面量："M3SDInfoResponse(result=" · ", info=" · ")"
- `public M3SDInfoResponse(int i, M3SDInfo m3SDInfo)`  L64
- `int getResult()`  L69
- `M3SDInfo getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SDInfoResponseKt`
L12 · [class] public final M3SDInfoResponseKt · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SDInfoResponseKt.java`
注解：

方法（1）：
- `String appString(int i, Object... objArr)`  L14
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SetModeResponse`
L11 · [class] public final M3SetModeResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SetModeResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3SetModeResponse copy$default(M3SetModeResponse m3SetModeResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3SetModeResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3SetModeResponse(result=" · ", info=" · ")"
- `public M3SetModeResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SetParamResponse`
L11 · [class] public final M3SetParamResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SetParamResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3SetParamResponse copy$default(M3SetParamResponse m3SetParamResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3SetParamResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3SetParamResponse(result=" · ", info=" · ")"
- `public M3SetParamResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SetSysTimeResponse`
L11 · [class] public final M3SetSysTimeResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SetSysTimeResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3SetSysTimeResponse copy$default(M3SetSysTimeResponse m3SetSysTimeResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3SetSysTimeResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3SetSysTimeResponse(result=" · ", info=" · ")"
- `public M3SetSysTimeResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SetTimeZoneResponse`
L11 · [class] public final M3SetTimeZoneResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SetTimeZoneResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3SetTimeZoneResponse copy$default(M3SetTimeZoneResponse m3SetTimeZoneResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3SetTimeZoneResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3SetTimeZoneResponse(result=" · ", info=" · ")"
- `public M3SetTimeZoneResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SettingResponse`
L11 · [class] public final M3SettingResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SettingResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3SettingResponse copy$default(M3SettingResponse m3SettingResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3SettingResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3SettingResponse(result=" · ", info=" · ")"
- `public M3SettingResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SetWifiResponse`
L11 · [class] public final M3SetWifiResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SetWifiResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3SetWifiResponse copy$default(M3SetWifiResponse m3SetWifiResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3SetWifiResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3SetWifiResponse(result=" · ", info=" · ")"
- `public M3SetWifiResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3SnapshotResponse`
L11 · [class] public final M3SnapshotResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3SnapshotResponse.java`
注解：

字段/常量（2）：
- `String info`  L14 @SerializedName("info")
- `int result`  L17 @SerializedName("result")

方法（10）：
- `M3SnapshotResponse copy$default(M3SnapshotResponse m3SnapshotResponse, int i, String str, int i2, Object obj)`  L19
- `int getResult()`  L30
- `String getInfo()`  L35
- `M3SnapshotResponse copy(int result, String info)`  L39
    - 体内字面量："info"
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L59
    - 体内字面量："M3SnapshotResponse(result=" · ", info=" · ")"
- `public M3SnapshotResponse(int i, String info)`  L63
    - 体内字面量："info"
- `int getResult()`  L69
- `String getInfo()`  L73
### `com.tuwinsmart.tuwin.data.source.remote.dto.p007m3.M3UploadResponse`
L12 · [class] public final M3UploadResponse · `com/tuwinsmart/tuwin/data/source/remote/dto/p007m3/M3UploadResponse.java`
注解：

字段/常量（3）：
- `String info`  L15 @SerializedName("info")
- `int result`  L18 @SerializedName("result")
- `String str = this.info`  L57

方法（11）：
- `M3UploadResponse copy$default(M3UploadResponse m3UploadResponse, int i, String str, int i2, Object obj)`  L20
- `int getResult()`  L31
- `String getInfo()`  L36
- `M3UploadResponse copy(int result, String info)`  L40
- `boolean equals(Object other)`  L44
- `int hashCode()`  L55
- `String toString()`  L61
    - 体内字面量："M3UploadResponse(result=" · ", info=" · ")"
- `public M3UploadResponse(int i, String str)`  L65
- ` M3UploadResponse(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L70
- `int getResult()`  L74
- `String getInfo()`  L78
### `com.tuwinsmart.tuwin.data.source.remote.exception.ApiException`
L21 · [class] public ApiException · extends `Exception` · `com/tuwinsmart/tuwin/data/source/remote/exception/ApiException.java`

字段/常量（2）：
- `String code`  L22
- `String msg`  L23

方法（8）：
- `private ApiException(Throwable th, String str)`  L35
- `ApiException handlerException(Throwable th)`  L41
    - 体内字面量："1001" · "1002" · "1003" · "1004" · "1006" · "Illegal state error" · "1005" · "1000" · "Unknown error"
- `String getErrorMsgByErrorCode(String str)`  L110
    - 体内字面量："no_login_001"
- `String getCode()`  L118
- `void setCode(String str)`  L122
- `String getMsg()`  L126
- `void setMsg(String str)`  L130
- `String toString()`  L135 @Override
    - 体内字面量："ApiException{errorCode=" · ", msg='" · "'}"
### `com.tuwinsmart.tuwin.data.source.remote.exception.ApiException$ERROR`
L25 · [class] public static ERROR · `com/tuwinsmart/tuwin/data/source/remote/exception/ApiException.java`

字段/常量（7）：
- `int CAST_ERROR = 1004`  L26
- `int ILLEGAL_STATE_ERROR = 1006`  L27
- `int NULL_POINTER_EXCEPTION = 1002`  L28
- `int PARSE_ERROR = 1005`  L29
- `int SSL_ERROR = 1003`  L30
- `int TIMEOUT_ERROR = 1001`  L31
- `int UNKNOWN = 1000`  L32
### `com.tuwinsmart.tuwin.data.source.remote.exception.ApiException$ProtocolException`
L151 · [class] public static ProtocolException · extends `RuntimeException` · `com/tuwinsmart/tuwin/data/source/remote/exception/ApiException.java`

方法（1）：
- `public ProtocolException(String str)`  L152
### `com.tuwinsmart.tuwin.data.source.remote.exception.ApiException$ServerException`
L139 · [class] public static ServerException · extends `RuntimeException` · `com/tuwinsmart/tuwin/data/source/remote/exception/ApiException.java`

字段/常量（1）：
- `String errorCode`  L140

方法（2）：
- `public ServerException(String str)`  L142
- `String getErrorCode()`  L146
### `com.tuwinsmart.tuwin.data.source.remote.exception.ErrorConsumer`
L9 · [class] public abstract ErrorConsumer · implements `Consumer<Throwable>` · `com/tuwinsmart/tuwin/data/source/remote/exception/ErrorConsumer.java`

字段/常量（2）：
- `String message`  L15
- `String string`  L16

方法（2）：
- `void onErrorMsg(String str)`  L10
- `void accept(Throwable th)`  L14 @Override
### `com.tuwinsmart.tuwin.data.source.remote.exception.M3ConnectionException`
L11 · [class] public final M3ConnectionException · extends `Exception` · `com/tuwinsmart/tuwin/data/source/remote/exception/M3ConnectionException.java`
注解：

方法（2）：
- ` M3ConnectionException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker)`  L16
- `public M3ConnectionException(String message, Throwable th)`  L21
    - 体内字面量："message" · "Lcom/tuwinsmart/tuwin/data/source/remote/exception/M3ConnectionException$Companion;" · "()V" · "deviceTypeMismatch" · "Lcom/tuwinsmart/tuwin/data/source/remote/exception/M3ConnectionException;" · "actualModel" · "fetchFailed" · "message" · "cause" · "httpFailed" · "errorMessage" · "invalidData" · "socketFailed" · "app_release_64"
### `com.tuwinsmart.tuwin.data.source.remote.exception.M3ConnectionException$Companion`
L28 · [class] public static final Companion · `com/tuwinsmart/tuwin/data/source/remote/exception/M3ConnectionException.java`
注解：

方法（9）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L29
- `private Companion()`  L33
- `M3ConnectionException httpFailed$default(Companion companion, String str, Throwable th, int i, Object obj)`  L36
- `M3ConnectionException httpFailed(String errorMessage, Throwable cause)`  L43
    - 体内字面量："unknown error" · "M3 HTTP request failed: "
- `M3ConnectionException deviceTypeMismatch(String actualModel)`  L51
    - 体内字面量："actualModel" · "Device type mismatch: expected 'M3', got '" · "'"
- `M3ConnectionException socketFailed(Throwable cause)`  L56
    - 体内字面量："cause" · "M3 TCP Socket connection failed"
- `M3ConnectionException invalidData(String message)`  L62
    - 体内字面量："message"
- `M3ConnectionException fetchFailed$default(Companion companion, String str, Throwable th, int i, Object obj)`  L67
- `M3ConnectionException fetchFailed(String message, Throwable cause)`  L74
    - 体内字面量："message"
### `com.tuwinsmart.tuwin.data.source.remote.exception.Ride3ProConnectionException`
L19 · [class] public final Ride3ProConnectionException · extends `Exception` · `com/tuwinsmart/tuwin/data/source/remote/exception/Ride3ProConnectionException.java`
注解：

字段/常量（1）：
- `String UNKNOWN_ERROR = "unknown error"`  L23

方法（2）：
- ` Ride3ProConnectionException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker)`  L25
- `public Ride3ProConnectionException(String message, Throwable th)`  L30
    - 体内字面量："message" · "Lcom/tuwinsmart/tuwin/data/source/remote/exception/Ride3ProConnectionException$Companion;" · "()V" · "UNKNOWN_ERROR" · "applicationString" · "resourceId" · "formatArgs" · "(ILjava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;" · "describeCause" · "cause" · "fetchFailed" · "Lcom/tuwinsmart/tuwin/data/source/remote/exception/Ride3ProConnectionException;" · "message" · "httpFailed" · "endpoint" · "errorMessage" · "previewStepFailed" · "stepName" · "todoApiMissing" · "placeholder" · "app_release_64"
### `com.tuwinsmart.tuwin.data.source.remote.exception.Ride3ProConnectionException$Companion`
L37 · [class] public static final Companion · `com/tuwinsmart/tuwin/data/source/remote/exception/Ride3ProConnectionException.java`
注解：

字段/常量（8）：
- `int i = C1870R.string.error_request_exception_format`  L86
- `String str = Ride3ProConnectionException.UNKNOWN_ERROR`  L91
- `String str2 = "è¯·æ±å¼å¸¸ï¼" + message`  L95
- `Object objM3074constructorimpl`  L107
- `Result.Companion companion = Result.INSTANCE`  L109
- `Companion companion2 = this`  L110
- `Result.Companion companion3 = Result.INSTANCE`  L113
- `Object obj = fallback`  L116

方法（9）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L38
- `private Companion()`  L42
- `Ride3ProConnectionException httpFailed(String endpoint, String errorMessage)`  L46
    - 体内字面量："endpoint" · "Ride3Pro HTTP request failed: endpoint=" · ", error="
- `Ride3ProConnectionException fetchFailed$default(Companion companion, String str, Throwable th, int i, Object obj)`  L54
- `Ride3ProConnectionException fetchFailed(String message, Throwable cause)`  L61
    - 体内字面量："message"
- `Ride3ProConnectionException previewStepFailed(String endpoint, String stepName, Throwable cause)`  L66
    - 体内字面量："endpoint" · "stepName" · "cause" · "Ride3Proé¢è§åå¤å¤±è´¥ï¼æ¥å£ " · " " · "ï¼" · "ï¼"
- `Ride3ProConnectionException todoApiMissing(String placeholder)`  L74
    - 体内字面量："placeholder" · "Ride3Pro protocol capability missing: "
- `String describeCause(Throwable cause)`  L79
    - 体内字面量："è¯·æ±è¶æ¶" · "DNSè§£æå¤±è´¥"
- `String applicationString(int resourceId, String fallback, Object... formatArgs)`  L106
### `com.tuwinsmart.tuwin.data.source.remote.factory.NullOnEmptyConverterFactory`
L11 · [class] public NullOnEmptyConverterFactory · extends `Converter.Factory` · `com/tuwinsmart/tuwin/data/source/remote/factory/NullOnEmptyConverterFactory.java`

字段/常量（2）：
- `NullConverter nullConverter`  L12
- `NullConverter nullConverter = this.nullConverter`  L17

方法（1）：
- `Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit)`  L15 @Override
### `com.tuwinsmart.tuwin.data.source.remote.factory.NullOnEmptyConverterFactory$NullConverter`
L26 · [class] NullConverter · implements `Converter<ResponseBody, Object>` · `com/tuwinsmart/tuwin/data/source/remote/factory/NullOnEmptyConverterFactory.java`

字段/常量（2）：
- `Converter<ResponseBody, ?> delagate`  L27
- `Converter<ResponseBody, ?> converter`  L43

方法（4）：
- `public NullConverter(Converter<ResponseBody, ?> converter)`  L29
- `Converter<ResponseBody, ?> getDelagate()`  L33
- `void setDelagate(Converter<ResponseBody, ?> converter)`  L37
- `Object convert(ResponseBody responseBody)`  L42 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DeviceLogDownloadRequest`
L14 · [class] public final DeviceLogDownloadRequest · `com/tuwinsmart/tuwin/data/source/remote/gateway/DeviceLogDownloadRequest.java`
注解：

字段/常量（3）：
- `List<String> candidateDates`  L15
- `DeviceType deviceType`  L16
- `File targetFile`  L17

方法（12）：
- `DeviceLogDownloadRequest copy$default(DeviceLogDownloadRequest deviceLogDownloadRequest, DeviceType deviceType, List list, File file, int i, Object obj)`  L20
- `DeviceType getDeviceType()`  L34
- `List<String> component2()`  L38
- `File getTargetFile()`  L43
- `DeviceLogDownloadRequest copy(DeviceType deviceType, List<String> candidateDates, File targetFile)`  L47
    - 体内字面量："deviceType" · "candidateDates" · "targetFile"
- `boolean equals(Object other)`  L54
- `int hashCode()`  L65
- `String toString()`  L69
    - 体内字面量："DeviceLogDownloadRequest(deviceType=" · ", candidateDates=" · ", targetFile=" · ")"
- `public DeviceLogDownloadRequest(DeviceType deviceType, List<String> candidateDates, File targetFile)`  L73
    - 体内字面量："deviceType" · "candidateDates" · "targetFile"
- `DeviceType getDeviceType()`  L82
- `List<String> getCandidateDates()`  L86
- `File getTargetFile()`  L90
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DeviceLogDownloadResult`
L13 · [class] public final DeviceLogDownloadResult · `com/tuwinsmart/tuwin/data/source/remote/gateway/DeviceLogDownloadResult.java`
注解：

字段/常量（8）：
- `long bytes`  L14
- `String date`  L15
- `File file`  L16
- `DeviceLogDownloadStatus status`  L17
- `File file2 = file`  L26
- `String str2 = str`  L30
- `File file = this.file`  L75
- `String str = this.date`  L77

方法（15）：
- `DeviceLogDownloadResult copy$default(DeviceLogDownloadResult deviceLogDownloadResult, DeviceLogDownloadStatus deviceLogDownloadStatus, File file, String str, long j, int i, Object obj)`  L19
- `DeviceLogDownloadStatus getStatus()`  L38
- `File getFile()`  L43
- `String getDate()`  L48
- `long getBytes()`  L53
- `DeviceLogDownloadResult copy(DeviceLogDownloadStatus status, File file, String date, long bytes)`  L57
    - 体内字面量："status"
- `boolean equals(Object other)`  L62
- `int hashCode()`  L73
- `String toString()`  L81
    - 体内字面量："DeviceLogDownloadResult(status=" · ", file=" · ", date=" · ", bytes=" · ")"
- `public DeviceLogDownloadResult(DeviceLogDownloadStatus status, File file, String str, long j)`  L85
    - 体内字面量："status"
- ` DeviceLogDownloadResult(DeviceLogDownloadStatus deviceLogDownloadStatus, File file, String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker)`  L93
- `DeviceLogDownloadStatus getStatus()`  L97
- `File getFile()`  L101
- `String getDate()`  L105
- `long getBytes()`  L109
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DeviceLogDownloadStatus`
L11 · [enum] public DeviceLogDownloadStatus · `com/tuwinsmart/tuwin/data/source/remote/gateway/DeviceLogDownloadStatus.java`
注解：

枚举常量（3）：
- `DOWNLOADED()`  L12
- `SKIPPED_NOT_READY()`  L13
- `FAILED()`  L14

方法（1）：
- `EnumEntries<DeviceLogDownloadStatus> getEntries()`  L18
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DeviceLogEndpointPolicy`
L16 · [class] public final DeviceLogEndpointPolicy · `com/tuwinsmart/tuwin/data/source/remote/gateway/DeviceLogEndpointPolicy.java`
注解：

方法（3）：
- `private DeviceLogEndpointPolicy()`  L19
- `String pathFor(DeviceType deviceType, String date)`  L22
    - 体内字面量："deviceType" · "date" · "\\d{8}" · "Failed requirement." · "/api/log/get" · "/sd/LOG" · ".txt"
- `String urlFor(DeviceType deviceType, String date)`  L34
    - 体内字面量："deviceType" · "date" · "http"
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DeviceLogGateway`
L11 · [interface] public DeviceLogGateway · `com/tuwinsmart/tuwin/data/source/remote/gateway/DeviceLogGateway.java`
注解：

方法（1）：
- `Object download(DeviceLogDownloadRequest deviceLogDownloadRequest, Continuation<? super DeviceLogDownloadResult> continuation)`  L12
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DiagnosticUploadGateway`
L11 · [interface] public DiagnosticUploadGateway · `com/tuwinsmart/tuwin/data/source/remote/gateway/DiagnosticUploadGateway.java`
注解：

方法（1）：
- `Object upload(DiagnosticUploadRequest diagnosticUploadRequest, Continuation<? super DiagnosticUploadResult> continuation)`  L12
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DiagnosticUploadRequest`
L13 · [class] public final DiagnosticUploadRequest · `com/tuwinsmart/tuwin/data/source/remote/gateway/DiagnosticUploadRequest.java`
注解：

字段/常量（7）：
- `File appLogFile`  L14
- `File deviceLogFile`  L15
- `DeviceType deviceType`  L16
- `String diagnosticId`  L17
- `DeviceType deviceType = this.deviceType`  L73
- `File file = this.deviceLogFile`  L75
- `File file2 = this.appLogFile`  L77

方法（14）：
- `DiagnosticUploadRequest copy$default(DiagnosticUploadRequest diagnosticUploadRequest, String str, DeviceType deviceType, File file, File file2, int i, Object obj)`  L19
- `String getDiagnosticId()`  L36
- `DeviceType getDeviceType()`  L41
- `File getDeviceLogFile()`  L46
- `File getAppLogFile()`  L51
- `DiagnosticUploadRequest copy(String diagnosticId, DeviceType deviceType, File deviceLogFile, File appLogFile)`  L55
    - 体内字面量："diagnosticId"
- `boolean equals(Object other)`  L60
- `int hashCode()`  L71
- `String toString()`  L81
    - 体内字面量："DiagnosticUploadRequest(diagnosticId=" · ", deviceType=" · ", deviceLogFile=" · ", appLogFile=" · ")"
- `public DiagnosticUploadRequest(String diagnosticId, DeviceType deviceType, File file, File file2)`  L85
    - 体内字面量："diagnosticId"
- `String getDiagnosticId()`  L93
- `DeviceType getDeviceType()`  L97
- `File getDeviceLogFile()`  L101
- `File getAppLogFile()`  L105
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DiagnosticUploadResult`
L11 · [class] public final DiagnosticUploadResult · `com/tuwinsmart/tuwin/data/source/remote/gateway/DiagnosticUploadResult.java`
注解：

字段/常量（5）：
- `String appLogUrl`  L12
- `String deviceLogUrl`  L13
- `DiagnosticUploadStatus status`  L14
- `String str = this.deviceLogUrl`  L62
- `String str2 = this.appLogUrl`  L64

方法（13）：
- `DiagnosticUploadResult copy$default(DiagnosticUploadResult diagnosticUploadResult, DiagnosticUploadStatus diagnosticUploadStatus, String str, String str2, int i, Object obj)`  L16
- `DiagnosticUploadStatus getStatus()`  L30
- `String getDeviceLogUrl()`  L35
- `String getAppLogUrl()`  L40
- `DiagnosticUploadResult copy(DiagnosticUploadStatus status, String deviceLogUrl, String appLogUrl)`  L44
    - 体内字面量："status"
- `boolean equals(Object other)`  L49
- `int hashCode()`  L60
- `String toString()`  L68
    - 体内字面量："DiagnosticUploadResult(status=" · ", deviceLogUrl=" · ", appLogUrl=" · ")"
- `public DiagnosticUploadResult(DiagnosticUploadStatus status, String str, String str2)`  L72
    - 体内字面量："status"
- ` DiagnosticUploadResult(DiagnosticUploadStatus diagnosticUploadStatus, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker)`  L79
- `DiagnosticUploadStatus getStatus()`  L83
- `String getDeviceLogUrl()`  L87
- `String getAppLogUrl()`  L91
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DiagnosticUploadSource`
L29 · [class] public final DiagnosticUploadSource · implements `Closeable` · `com/tuwinsmart/tuwin/data/source/remote/gateway/DiagnosticUploadSource.java`
注解：

字段/常量（4）：
- `boolean deleteOnClose`  L33
- `ObjectMetadata metadata`  L34
- `String objectExtension`  L35
- `File uploadFile`  L36

方法（6）：
- ` DiagnosticUploadSource(File file, String str, ObjectMetadata objectMetadata, boolean z, DefaultConstructorMarker defaultConstructorMarker)`  L38
- `private DiagnosticUploadSource(File file, String str, ObjectMetadata objectMetadata, boolean z)`  L42
- `File getUploadFile()`  L49
- `String getObjectExtension()`  L53
- `ObjectMetadata getMetadata()`  L57
- `void close()`  L62 @Override
    - 体内字面量："Lcom/tuwinsmart/tuwin/data/source/remote/gateway/DiagnosticUploadSource$Companion;" · "()V" · "direct" · "Lcom/tuwinsmart/tuwin/data/source/remote/gateway/DiagnosticUploadSource;" · "file" · "Ljava/io/File;" · "gzipText" · "app_release_64"
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DiagnosticUploadSource$Companion`
L70 · [class] public static final Companion · `com/tuwinsmart/tuwin/data/source/remote/gateway/DiagnosticUploadSource.java`
注解：

字段/常量（1）：
- `BufferedInputStream bufferedInputStream2 = bufferedInputStream`  L98

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L71
- `private Companion()`  L75
- `DiagnosticUploadSource direct(File file)`  L78
    - 体内字面量："file" · "txt"
- `DiagnosticUploadSource gzipText(File file)`  L87
    - 体内字面量："file" · "Required value was null." · "feedback-device-" · ".txt.gz"
### `com.tuwinsmart.tuwin.data.source.remote.gateway.DiagnosticUploadStatus`
L11 · [enum] public DiagnosticUploadStatus · `com/tuwinsmart/tuwin/data/source/remote/gateway/DiagnosticUploadStatus.java`
注解：

枚举常量（3）：
- `UPLOADED()`  L12
- `UNAVAILABLE()`  L13
- `FAILED()`  L14

方法（1）：
- `EnumEntries<DiagnosticUploadStatus> getEntries()`  L18
### `com.tuwinsmart.tuwin.data.source.remote.gateway.FeedbackApi`
L15 · [interface] FeedbackApi · `com/tuwinsmart/tuwin/data/source/remote/gateway/FeedbackApi.java`
注解：

方法（1）：
- `Object submit(@Body Map<String, String> map, Continuation<? super UpgradeBean> continuation)`  L17 @POST(ExternalWebCompatibilityPolicy.INTERNAL_COMMAND_FEEDBACK)
### `com.tuwinsmart.tuwin.data.source.remote.gateway.FeedbackApiEndpoint`
L9 · [class] public final FeedbackApiEndpoint · `com/tuwinsmart/tuwin/data/source/remote/gateway/FeedbackApiEndpoint.java`
注解：

字段/常量（2）：
- `String BASE_URL = "http://ali.tuwinsmart.com/"`  L10
- `String URL = "http://ali.tuwinsmart.com/feedback"`  L12

方法（1）：
- `private FeedbackApiEndpoint()`  L14
### `com.tuwinsmart.tuwin.data.source.remote.gateway.FeedbackGateway`
L12 · [interface] public FeedbackGateway · `com/tuwinsmart/tuwin/data/source/remote/gateway/FeedbackGateway.java`
注解：

方法（1）：
- `Object submit(Map<String, String> map, Continuation<? super UpgradeBean> continuation)`  L13
### `com.tuwinsmart.tuwin.data.source.remote.gateway.InternetCloudGateway`
L15 · [interface] public InternetCloudGateway · extends `AppUpdateGateway` · `com/tuwinsmart/tuwin/data/source/remote/gateway/InternetCloudGateway.java`
注解：

方法（2）：
- `Object getBanners(Continuation<? super List<BannerItem>> continuation)`  L16
- `Object getCurrentVersion(String str, String str2, Continuation<? super UpgradeBean> continuation)`  L18
### `com.tuwinsmart.tuwin.data.source.remote.gateway.LegacyDirectCloudConfig`
L18 · [class] public final LegacyDirectCloudConfig · `com/tuwinsmart/tuwin/data/source/remote/gateway/LegacyDirectCloudConfig.java`
注解：

字段/常量（8）：
- `String ossAccessKeyId`  L22
- `String ossAccessKeySecret`  L23
- `String ossBucket`  L24
- `String ossEndpoint`  L25
- `String ossRegion`  L26
- `String str6 = str2`  L35
- `String str7 = str3`  L39
- `String str8 = str4`  L43

方法（18）：
- `LegacyDirectCloudConfig copy$default(LegacyDirectCloudConfig legacyDirectCloudConfig, String str, String str2, String str3, String str4, String str5, int i, Object obj)`  L28
- `String getOssEndpoint()`  L51
- `String getOssRegion()`  L56
- `String getOssBucket()`  L61
- `String getOssAccessKeyId()`  L66
- `String getOssAccessKeySecret()`  L71
- `LegacyDirectCloudConfig copy(String ossEndpoint, String ossRegion, String ossBucket, String ossAccessKeyId, String ossAccessKeySecret)`  L75
    - 体内字面量："ossEndpoint" · "ossRegion" · "ossBucket" · "ossAccessKeyId" · "ossAccessKeySecret"
- `boolean equals(Object other)`  L84
- `int hashCode()`  L95
- `String toString()`  L99
    - 体内字面量："LegacyDirectCloudConfig(ossEndpoint=" · ", ossRegion=" · ", ossBucket=" · ", ossAccessKeyId=" · ", ossAccessKeySecret=" · ")"
- `public LegacyDirectCloudConfig(String ossEndpoint, String ossRegion, String ossBucket, String ossAccessKeyId, String ossAccessKeySecret)`  L103
    - 体内字面量："ossEndpoint" · "ossRegion" · "ossBucket" · "ossAccessKeyId" · "ossAccessKeySecret"
- `String getOssEndpoint()`  L116
- `String getOssRegion()`  L120
- `String getOssBucket()`  L124
- `String getOssAccessKeyId()`  L128
- `String getOssAccessKeySecret()`  L132
- `boolean isOssConfigured()`  L136
- `String publicOssUrl(String key)`  L149
    - 体内字面量："key" · "https://" · "." · "https://" · "http://" · "/" · "/" · "/" · "Lcom/tuwinsmart/tuwin/data/source/remote/gateway/LegacyDirectCloudConfig$Companion;" · "()V" · "fromBuildConfig" · "Lcom/tuwinsmart/tuwin/data/source/remote/gateway/LegacyDirectCloudConfig;" · "app_release_64"
### `com.tuwinsmart.tuwin.data.source.remote.gateway.LegacyDirectCloudConfig$Companion`
L156 · [class] public static final Companion · `com/tuwinsmart/tuwin/data/source/remote/gateway/LegacyDirectCloudConfig.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L157
- `private Companion()`  L161
- `LegacyDirectCloudConfig fromBuildConfig()`  L164
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedAppUpdateGateway`
L22 · [class] public final RoutedAppUpdateGateway · implements `AppUpdateGateway` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedAppUpdateGateway.java`
注解：

字段/常量（2）：
- `String baseUrl`  L23
- `RoutedRetrofitProvider retrofitProvider`  L24

方法（5）：
- `public RoutedAppUpdateGateway(RoutedRetrofitProvider retrofitProvider, String baseUrl)`  L26
    - 体内字面量："retrofitProvider" · "baseUrl"
- ` RoutedAppUpdateGateway(RoutedRetrofitProvider routedRetrofitProvider, String str, int i, DefaultConstructorMarker defaultConstructorMarker)`  L33
- `Object check(RouteLease routeLease, String str, Continuation<? super CheckUpdateBean> continuation)`  L38 @Override
- `Unit invoke(Retrofit.Builder builder)`  L41 @Override
- `void invoke2(Retrofit.Builder create)`  L47
    - 体内字面量："$this$create" · "android"
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedDeviceLogGateway`
L56 · [class] public final RoutedDeviceLogGateway · implements `DeviceLogGateway` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedDeviceLogGateway.java`
注解：

字段/常量（23）：
- `int DEVICE_HTTP_PORT = 80`  L60 @Deprecated
- `DeviceEndpointAuthority endpointAuthority`  L61
- `RoutedOkHttpProvider okHttpProvider`  L62
- `RouteProvider routeProvider`  L63
- `DeviceSessionManager sessions`  L64
- `Object objM3074constructorimpl`  L552
- `Result.Companion companion = Result.INSTANCE`  L562
- `RoutedDeviceLogGateway routedDeviceLogGateway = this`  L563
- `Result.Companion companion2 = Result.INSTANCE`  L566
- `RouteSnapshot route`  L594
- `byte[] bArrBytes`  L629
- `CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl`  L713
- `CancellableContinuation<RoutedDeviceLogGateway.DeviceLogPayload> cancellableContinuation = cancellableContinuationImpl2`  L736
- `Result.Companion companion = Result.INSTANCE`  L737
- `Object objM3074constructorimpl`  L744
- `Response response2 = response`  L747
- `CancellableContinuation<RoutedDeviceLogGateway.DeviceLogPayload> cancellableContinuation = cancellableContinuationImpl2`  L748
- `RoutedDeviceLogGateway routedDeviceLogGateway = this`  L749
- `Response response3 = response2`  L751
- `Result.Companion companion = Result.INSTANCE`  L753
- `RoutedDeviceLogGateway$execute$2$2 routedDeviceLogGateway$execute$2$2 = this`  L754
- `Result.Companion companion2 = Result.INSTANCE`  L757
- `Unit unit = Unit.INSTANCE`  L763

方法（10）：
- `public RoutedDeviceLogGateway(DeviceSessionManager sessions, DeviceEndpointAuthority endpointAuthority, RouteProvider routeProvider, RoutedOkHttpProvider okHttpProvider)`  L98
    - 体内字面量："sessions" · "endpointAuthority" · "routeProvider" · "okHttpProvider"
- `java.lang.Object download(com.tuwinsmart.tuwin.data.source.remote.gateway.DeviceLogDownloadRequest r46, kotlin.coroutines.Continuation<? super com.tuwinsmart.tuwin.data.source.remote.gateway.DeviceLogDownloadResult> r47)`  L543 @Override
    - 体内字面量："Method not decompiled: com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedDeviceLogGateway.download(com.tuwinsmart.tuwin.data.source.remote.gateway.DeviceLogDownloadRequest, kotlin.coroutines.Continuation):java.lang.Object"
- `DeviceSessionSnapshot readySession(DeviceType deviceType)`  L551
- `void saveIfCurrent(DeviceSessionSnapshot session, long routeRevision, RouteLease lease, File targetFile, byte[] bytes)`  L593
- `DeviceLogPayload validateResponse(Response response)`  L628
- `Object execute(final Call call, Continuation<? super DeviceLogPayload> continuation)`  L710
- `Unit invoke(Throwable th)`  L720 @Override
- `void invoke2(Throwable th)`  L726
- `void onFailure(Call call2, IOException error)`  L732 @Override
    - 体内字面量："call" · "error"
- `void onResponse(Call call2, Response response)`  L743 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedDeviceLogGateway$C22861`
L70 · [class] static final C22861 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedDeviceLogGateway.java`
注解：

字段/常量（14）：
- `int I$0`  L71
- `int I$1`  L72
- `Object L$0`  L73
- `Object L$1`  L74
- `Object L$2`  L75
- `Object L$3`  L76
- `Object L$4`  L77
- `Object L$5`  L78
- `Object L$6`  L79
- `Object L$7`  L80
- `Object L$8`  L81
- `Object L$9`  L82
- `int label`  L83
- `Object result`  L84

方法（1）：
- `Object invokeSuspend(Object obj)`  L91 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedDeviceLogGateway$Companion`
L700 · [class] private static final Companion · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedDeviceLogGateway.java`
注解：

方法（2）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L701
- `private Companion()`  L705
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedDeviceLogGateway$DeviceLogPayload`
L653 · [class] static final DeviceLogPayload · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedDeviceLogGateway.java`
注解：

字段/常量（1）：
- `byte[] bytes`  L654

方法（8）：
- `DeviceLogPayload copy$default(DeviceLogPayload deviceLogPayload, byte[] bArr, int i, Object obj)`  L656
- `byte[] getBytes()`  L664
- `DeviceLogPayload copy(byte[] bytes)`  L668
    - 体内字面量："bytes"
- `boolean equals(Object other)`  L673
- `int hashCode()`  L680
- `String toString()`  L684
    - 体内字面量："DeviceLogPayload(bytes=" · ")"
- `public DeviceLogPayload(byte[] bytes)`  L688
    - 体内字面量："bytes"
- `byte[] getBytes()`  L693
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedDeviceLogGateway$download$2$payload$1`
L20 · [class] final RoutedDeviceLogGateway$download$2$payload$1 · extends `SuspendLambda implements Function1<Continuation<? super RoutedDeviceLogGateway.DeviceLogPayload>, Object>` · implements `Function1<Continuation<? super RoutedDeviceLogGateway.DeviceLogPayload>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedDeviceLogGateway$download$2$payload$1.java`
注解：

字段/常量（5）：
- `HttpUrl $authorizedUrl`  L21
- `OkHttpClient $client`  L22
- `int label`  L23
- `RoutedDeviceLogGateway this$0`  L24
- `int i = this.label`  L47

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L35 @Override
- `Object invoke(Continuation<? super RoutedDeviceLogGateway.DeviceLogPayload> continuation)`  L40 @Override
- `Object invokeSuspend(Object obj)`  L45 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway`
L51 · [class] public final RoutedInternetCloudGateway · implements `InternetCloudGateway, AppUpdateGateway` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

字段/常量（15）：
- `String BANNER_ACTIVE_STATUS = "active"`  L54 @Deprecated
- `int BANNER_SUCCESS_CODE = 200`  L57 @Deprecated
- `ExternalUrlPolicy bannerPagePolicy`  L59
- `String baseUrl`  L60
- `RoutedRetrofitProvider retrofitProvider`  L61
- `RouteProvider routeProvider`  L62
- `C22941 c22941`  L347
- `Object objWithCancellation = c22941.result`  L358
- `int i = c22941.label`  L360
- `Integer num = id`  L527
- `Object objM3074constructorimpl`  L555
- `boolean z`  L556
- `Result.Companion companion = Result.INSTANCE`  L562
- `RoutedInternetCloudGateway routedInternetCloudGateway = this`  L563
- `Result.Companion companion2 = Result.INSTANCE`  L566

方法（13）：
- `public RoutedInternetCloudGateway(RouteProvider routeProvider, RoutedRetrofitProvider retrofitProvider, String baseUrl)`  L85
    - 体内字面量："routeProvider" · "retrofitProvider" · "baseUrl"
- ` RoutedInternetCloudGateway(RouteProvider routeProvider, RoutedRetrofitProvider routedRetrofitProvider, String str, int i, DefaultConstructorMarker defaultConstructorMarker)`  L95
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/CheckUpdateBean;" · "com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$check$2" · "RoutedInternetCloudGateway.kt" · "invokeSuspend"
- `Object check(RouteLease routeLease, String str, Continuation<? super CheckUpdateBean> continuation)`  L201 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/UpgradeBean;" · "api" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/TuwinSuspendApi;" · "com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$getCurrentVersion$2" · "RoutedInternetCloudGateway.kt" · "invokeSuspend"
- `Object getCurrentVersion(String str, String str2, Continuation<? super UpgradeBean> continuation)`  L256 @Override
    - 体内字面量："cloud_ota_metadata" · "<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/BannerItem;" · "api" · "Lcom/tuwinsmart/tuwin/data/source/remote/api/TuwinSuspendApi;" · "com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$getBanners$2" · "RoutedInternetCloudGateway.kt" · "invokeSuspend"
- `Object getBanners(Continuation<? super List<BannerItem>> continuation)`  L317 @Override
    - 体内字面量："cloud_banners"
- `TuwinSuspendApi service(RouteLease lease)`  L322
- `Unit invoke(Retrofit.Builder builder)`  L325 @Override
- `void invoke2(Retrofit.Builder create)`  L331
    - 体内字面量："$this$create"
- `Object withInternetLease(String str, Function2<? super TuwinSuspendApi, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation)`  L346
- `List<BannerItem> sanitizeBannerResponse(BannerResponse response)`  L495
    - 体内字面量："Cloud banner response rejected: code="
- `int compare(T t, T t2)`  L508 @Override
- `int compare(T t, T t2)`  L518 @Override
- `boolean isValidBanner(BannerItem item)`  L554
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$C22872`
L103 · [class] static final C22872 · extends `SuspendLambda implements Function1<Continuation<? super CheckUpdateBean>, Object>` · implements `Function1<Continuation<? super CheckUpdateBean>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

字段/常量（5）：
- `String $appVersion`  L104
- `RouteLease $lease`  L105
- `int label`  L106
- `RoutedInternetCloudGateway this$0`  L107
- `int i = this.label`  L182

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L118 @Override
- `Object invoke(Continuation<? super CheckUpdateBean> continuation)`  L123 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/CheckUpdateBean;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$check$2$1" · "RoutedInternetCloudGateway.kt" · "invokeSuspend"
- `Object invokeSuspend(Object obj)`  L180 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$C22872$AnonymousClass1`
L131 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super CheckUpdateBean>, Object>` · implements `Function2<CoroutineScope, Continuation<? super CheckUpdateBean>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

字段/常量（5）：
- `String $appVersion`  L132
- `RouteLease $lease`  L133
- `int label`  L134
- `RoutedInternetCloudGateway this$0`  L135
- `int i = this.label`  L158

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L146 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super CheckUpdateBean> continuation)`  L151 @Override
- `Object invokeSuspend(Object obj)`  L156 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$C22882`
L264 · [class] static final C22882 · extends `SuspendLambda implements Function2<TuwinSuspendApi, Continuation<? super List<? extends BannerItem>>, Object>` · implements `Function2<TuwinSuspendApi, Continuation<? super List<? extends BannerItem>>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

字段/常量（5）：
- `Object L$0`  L265
- `int label`  L266
- `RoutedInternetCloudGateway routedInternetCloudGateway`  L291
- `int i = this.label`  L293
- `RoutedInternetCloudGateway routedInternetCloudGateway2 = RoutedInternetCloudGateway.this`  L297

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L273 @Override
- `Object invoke2(TuwinSuspendApi tuwinSuspendApi, Continuation<? super List<BannerItem>> continuation)`  L280
- `Object invoke(TuwinSuspendApi tuwinSuspendApi, Continuation<? super List<? extends BannerItem>> continuation)`  L285 @Override
- `Object invokeSuspend(Object obj)`  L290 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$C22892`
L209 · [class] static final C22892 · extends `SuspendLambda implements Function2<TuwinSuspendApi, Continuation<? super UpgradeBean>, Object>` · implements `Function2<TuwinSuspendApi, Continuation<? super UpgradeBean>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

字段/常量（5）：
- `String $boardVersion`  L210
- `String $version`  L211
- `Object L$0`  L212
- `int label`  L213
- `int i = this.label`  L237

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L223 @Override
- `Object invoke(TuwinSuspendApi tuwinSuspendApi, Continuation<? super UpgradeBean> continuation)`  L230 @Override
- `Object invokeSuspend(Object obj)`  L235 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$C22921`
L540 · [class] C22921 · extends `FunctionReferenceImpl implements Function1<BannerItem, Boolean>` · implements `Function1<BannerItem, Boolean>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

方法（1）：
- `Boolean invoke(BannerItem p0)`  L546 @Override
    - 体内字面量："p0"
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$C22941`
L68 · [class] static final C22941 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L69
- `int label`  L70
- `Object result`  L71

方法（1）：
- `Object invokeSuspend(Object obj)`  L78 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$C22952`
L395 · [class] static final C22952 · extends `SuspendLambda implements Function1<Continuation<? super T>, Object>` · implements `Function1<Continuation<? super T>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

字段/常量（5）：
- `Function2<TuwinSuspendApi, Continuation<? super T>, Object> $block`  L396
- `RouteLease $lease`  L397
- `int label`  L398
- `RoutedInternetCloudGateway this$0`  L399
- `int i = this.label`  L476

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L411 @Override
- `Object invoke(Continuation<? super T> continuation)`  L416 @Override
    - 体内字面量："<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$withInternetLease$2$1" · "RoutedInternetCloudGateway.kt" · "invokeSuspend"
- `Object invokeSuspend(Object obj)`  L474 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$C22952$AnonymousClass1`
L424 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object>` · implements `Function2<CoroutineScope, Continuation<? super T>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

字段/常量（6）：
- `Function2<TuwinSuspendApi, Continuation<? super T>, Object> $block`  L425
- `RouteLease $lease`  L426
- `int label`  L427
- `RoutedInternetCloudGateway this$0`  L428
- `int i = this.label`  L452
- `Function2<TuwinSuspendApi, Continuation<? super T>, Object> function2 = this.$block`  L455

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L440 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation)`  L445 @Override
- `Object invokeSuspend(Object obj)`  L450 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway$Companion`
L582 · [class] private static final Companion · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedInternetCloudGateway.java`
注解：

方法（2）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L583
- `private Companion()`  L587
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedLegacyDiagnosticUploadGateway`
L59 · [class] public final RoutedLegacyDiagnosticUploadGateway · implements `DiagnosticUploadGateway` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyDiagnosticUploadGateway.java`
注解：

字段/常量（61）：
- `LegacyDirectCloudConfig config`  L60
- `Context context`  L61
- `RoutedOkHttpProvider okHttpProvider`  L62
- `RouteProvider routeProvider`  L63
- `C22961 c22961`  L128
- `RouteLease routeLeaseAcquire$default`  L129
- `RoutedLegacyDiagnosticUploadGateway routedLegacyDiagnosticUploadGateway`  L130
- `DiagnosticUploadResult diagnosticUploadResult`  L131
- `RouteLease routeLease`  L132
- `CancellationException e`  L133
- `DiagnosticUploadRequest diagnosticUploadRequest2 = diagnosticUploadRequest`  L134
- `Object objWithCancellation = c22961.result`  L145
- `int i = c22961.label`  L147
- `C22981 c22981`  L345
- `String strSubstringAfterLast$default`  L346
- `Object obj`  L347
- `long jCurrentTimeMillis`  L348
- `Object obj2`  L349
- `Object obj3`  L350
- `Object obj4`  L351
- `DiagnosticUploadSource diagnosticUploadSource`  L352
- `DiagnosticUploadSource diagnosticUploadSource2`  L353
- `DiagnosticUploadSource diagnosticUploadSourceDirect`  L354
- `Object obj5`  L355
- `String str3`  L356
- `Object obj6`  L357
- `Object obj7`  L358
- `String contentEncoding`  L359
- `boolean z2`  L360
- `Object objPutObject`  L361
- `RoutedLegacyDiagnosticUploadGateway routedLegacyDiagnosticUploadGateway`  L362
- `ServiceException serviceException`  L363
- `String requestId`  L364
- `ServiceException serviceException2`  L365
- `String errorCode`  L366
- `Object obj8`  L367
- `String strPublicOssUrl`  L368
- `String str4 = str2`  L369
- `Object obj9 = c22981.result`  L380
- `int i = c22981.label`  L382
- `DiagnosticLog diagnosticLog = DiagnosticLog.INSTANCE`  L408
- `Pair<String, ? extends Object>[] pairArr = new Pair[5]`  L411
- `DiagnosticLog diagnosticLog2 = DiagnosticLog.INSTANCE`  L428
- `Pair<String, ? extends Object>[] pairArr2 = new Pair[6]`  L429
- `DiagnosticLog diagnosticLog3 = DiagnosticLog.INSTANCE`  L484
- `Pair<String, ? extends Object>[] pairArr3 = new Pair[4]`  L485
- `DiagnosticLog diagnosticLog4 = DiagnosticLog.INSTANCE`  L506
- `Pair<String, ? extends Object>[] pairArr4 = new Pair[6]`  L507
- `long j = c22981.J$0`  L577
- `DiagnosticLog diagnosticLog5 = DiagnosticLog.INSTANCE`  L597
- `Pair<String, ? extends Object>[] pairArr5 = new Pair[4]`  L598
- `DiagnosticLog diagnosticLog6 = DiagnosticLog.INSTANCE`  L620
- `Pair<String, ? extends Object>[] pairArr6 = new Pair[6]`  L621
- `DiagnosticLog diagnosticLog7 = DiagnosticLog.INSTANCE`  L680
- `Pair<String, ? extends Object>[] pairArr7 = new Pair[6]`  L681
- `CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl`  L739
- `CancellableContinuation<PutObjectResult> cancellableContinuation = cancellableContinuationImpl2`  L767
- `Result.Companion companion = Result.INSTANCE`  L768
- `IOException iOException`  L775
- `CancellableContinuation<PutObjectResult> cancellableContinuation = cancellableContinuationImpl2`  L783
- `Result.Companion companion = Result.INSTANCE`  L784

方法（9）：
- `public RoutedLegacyDiagnosticUploadGateway(Context context, RouteProvider routeProvider, RoutedOkHttpProvider okHttpProvider, LegacyDirectCloudConfig config)`  L114
    - 体内字面量："context" · "routeProvider" · "okHttpProvider" · "config"
- `Object upload(DiagnosticUploadRequest diagnosticUploadRequest, Continuation<? super DiagnosticUploadResult> continuation)`  L127 @Override
- `Object uploadFile(OSSClient oSSClient, File file, String str, String str2, boolean z, Continuation<? super String> continuation)`  L344
- `void logUploadFailure(String diagnosticId, String stage, Throwable error)`  L731
    - 体内字面量："feedback_log_upload_failed" · "diagnostic_id" · "stage" · "error_type"
- `Object putObject(OSSClient oSSClient, PutObjectRequest putObjectRequest, Continuation<? super PutObjectResult> continuation)`  L736
- `Unit invoke(Throwable th)`  L748 @Override
- `void invoke2(Throwable th)`  L754
- `void onSuccess(PutObjectRequest request, PutObjectResult result)`  L763 @Override
    - 体内字面量："request" · "result"
- `void onFailure(PutObjectRequest request, ClientException clientException, ServiceException serviceException)`  L774 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedLegacyDiagnosticUploadGateway$C22961`
L69 · [class] static final C22961 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyDiagnosticUploadGateway.java`
注解：

字段/常量（5）：
- `Object L$0`  L70
- `Object L$1`  L71
- `Object L$2`  L72
- `int label`  L73
- `Object result`  L74

方法（1）：
- `Object invokeSuspend(Object obj)`  L81 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedLegacyDiagnosticUploadGateway$C22972`
L241 · [class] static final C22972 · extends `SuspendLambda implements Function1<Continuation<? super DiagnosticUploadResult>, Object>` · implements `Function1<Continuation<? super DiagnosticUploadResult>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyDiagnosticUploadGateway.java`
注解：

字段/常量（8）：
- `RouteLease $lease`  L242
- `DiagnosticUploadRequest $request`  L243
- `Object L$0`  L244
- `int label`  L245
- `OSSClient oSSClient`  L267
- `String str`  L268
- `DiagnosticUploadStatus diagnosticUploadStatus`  L269
- `int i = this.label`  L271

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L255 @Override
- `Object invoke(Continuation<? super DiagnosticUploadResult> continuation)`  L260 @Override
- `Object invokeSuspend(Object obj)`  L266 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedLegacyDiagnosticUploadGateway$C22981`
L92 · [class] static final C22981 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyDiagnosticUploadGateway.java`
注解：

字段/常量（8）：
- `long J$0`  L93
- `Object L$0`  L94
- `Object L$1`  L95
- `Object L$2`  L96
- `Object L$3`  L97
- `Object L$4`  L98
- `int label`  L99
- `Object result`  L100

方法（1）：
- `Object invokeSuspend(Object obj)`  L107 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedLegacyFeedbackGateway`
L32 · [class] public final RoutedLegacyFeedbackGateway · implements `FeedbackGateway` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyFeedbackGateway.java`
注解：

字段/常量（7）：
- `RoutedRetrofitProvider retrofitProvider`  L33
- `RouteProvider routeProvider`  L34
- `C22991 c22991`  L67
- `Throwable th`  L68
- `RouteLease routeLease`  L69
- `Object obj = c22991.result`  L80
- `int i = c22991.label`  L82

方法（2）：
- `public RoutedLegacyFeedbackGateway(RouteProvider routeProvider, RoutedRetrofitProvider retrofitProvider)`  L57
    - 体内字面量："routeProvider" · "retrofitProvider"
- `Object submit(Map<String, String> map, Continuation<? super UpgradeBean> continuation)`  L66 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedLegacyFeedbackGateway$C22991`
L40 · [class] static final C22991 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyFeedbackGateway.java`
注解：

字段/常量（3）：
- `Object L$0`  L41
- `int label`  L42
- `Object result`  L43

方法（1）：
- `Object invokeSuspend(Object obj)`  L50 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedLegacyFeedbackGateway$C23002`
L124 · [class] static final C23002 · extends `SuspendLambda implements Function1<Continuation<? super UpgradeBean>, Object>` · implements `Function1<Continuation<? super UpgradeBean>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyFeedbackGateway.java`
注解：

字段/常量（5）：
- `RouteLease $lease`  L125
- `Map<String, String> $payload`  L126
- `int label`  L127
- `RoutedLegacyFeedbackGateway this$0`  L128
- `int i = this.label`  L217

方法（3）：
- `Continuation<Unit> create(Continuation<?> continuation)`  L139 @Override
- `Object invoke(Continuation<? super UpgradeBean> continuation)`  L144 @Override
    - 体内字面量："<anonymous>" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/UpgradeBean;" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedLegacyFeedbackGateway$submit$2$1" · "LegacyDirectCloudGateways.kt" · "invokeSuspend"
- `Object invokeSuspend(Object obj)`  L215 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedLegacyFeedbackGateway$C23002$AnonymousClass1`
L152 · [class] static final AnonymousClass1 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super UpgradeBean>, Object>` · implements `Function2<CoroutineScope, Continuation<? super UpgradeBean>, Object>` · `com/tuwinsmart/tuwin/data/source/remote/gateway/RoutedLegacyFeedbackGateway.java`
注解：

字段/常量（7）：
- `RouteLease $lease`  L153
- `Map<String, String> $payload`  L154
- `int label`  L155
- `RoutedLegacyFeedbackGateway this$0`  L156
- `int i = this.label`  L179
- `RoutedRetrofitProvider routedRetrofitProvider = this.this$0.retrofitProvider`  L183
- `RouteLease routeLease = this.$lease`  L184

方法（5）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L167 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super UpgradeBean> continuation)`  L172 @Override
- `Object invokeSuspend(Object obj)`  L177 @Override
- `Unit invoke(Retrofit.Builder builder)`  L188 @Override
- `void invoke2(Retrofit.Builder create)`  L194
    - 体内字面量："$this$create" · "call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.data.source.remote.gateway.UnavailableDiagnosticUploadGateway`
L11 · [class] public final UnavailableDiagnosticUploadGateway · implements `DiagnosticUploadGateway` · `com/tuwinsmart/tuwin/data/source/remote/gateway/UnavailableDiagnosticUploadGateway.java`
注解：

方法（2）：
- `private UnavailableDiagnosticUploadGateway()`  L14
- `Object upload(DiagnosticUploadRequest diagnosticUploadRequest, Continuation<? super DiagnosticUploadResult> continuation)`  L18 @Override
### `com.tuwinsmart.tuwin.data.source.remote.gateway.UnavailableFeedbackGateway`
L12 · [class] public final UnavailableFeedbackGateway · implements `FeedbackGateway` · `com/tuwinsmart/tuwin/data/source/remote/gateway/UnavailableFeedbackGateway.java`
注解：

方法（2）：
- `private UnavailableFeedbackGateway()`  L15
- `Object submit(Map<String, String> map, Continuation<? super UpgradeBean> continuation)`  L19 @Override
    - 体内字面量："åé¦æå¡ç«¯æ¥å£å°æªéç½®ï¼æªåéåé¦åå®¹"
### `com.tuwinsmart.tuwin.data.source.remote.interceptor.AutoTokenHeaderInterceptor`
L11 · [class] public AutoTokenHeaderInterceptor · implements `Interceptor` · `com/tuwinsmart/tuwin/data/source/remote/interceptor/AutoTokenHeaderInterceptor.java`

方法（1）：
- `Response intercept(Interceptor.Chain chain)`  L13 @Override
    - 体内字面量："appVersion"
### `com.tuwinsmart.tuwin.data.source.remote.transform.HttpArrayResultFunc`
L9 · [class] public HttpArrayResultFunc · implements `Function<BaseArrayRes<T>, BaseArrayRes<T>>` · `com/tuwinsmart/tuwin/data/source/remote/transform/HttpArrayResultFunc.java`

方法（1）：
- `BaseArrayRes<T> apply(BaseArrayRes<T> baseArrayRes)`  L11 @Override
### `com.tuwinsmart.tuwin.data.source.remote.transform.HttpResultFunc`
L8 · [class] public HttpResultFunc · extends `BaseHttp<T> implements Function<BaseRes<T>, T>` · implements `Function<BaseRes<T>, T>` · `com/tuwinsmart/tuwin/data/source/remote/transform/HttpResultFunc.java`

字段/常量（2）：
- `Class clazz`  L9
- `boolean ignoreBody`  L10

方法（4）：
- `public HttpResultFunc()`  L12
- `public HttpResultFunc(boolean z)`  L16
- `public HttpResultFunc(boolean z, Class cls)`  L21
- `T apply(BaseRes<T> baseRes)`  L27 @Override
### `com.tuwinsmart.tuwin.data.source.remote.transform.NoCommonResultFunc`
L8 · [class] public NoCommonResultFunc · implements `Function<Response, Object>` · `com/tuwinsmart/tuwin/data/source/remote/transform/NoCommonResultFunc.java`

方法（1）：
- `Object apply(Response response)`  L10 @Override
### `com.tuwinsmart.tuwin.data.source.remote.transform.RxSchedulers`
L6 · [class] public RxSchedulers · `com/tuwinsmart/tuwin/data/source/remote/transform/RxSchedulers.java`

方法（1）：
- `ObservableTransformer<T, T> io_main()`  L7
### `com.tuwinsmart.tuwin.data.source.remote.transform.SchedulerTransformer`
L10 · [class] public SchedulerTransformer · implements `ObservableTransformer<T, T>` · `com/tuwinsmart/tuwin/data/source/remote/transform/SchedulerTransformer.java`

方法（1）：
- `ObservableSource<T> apply(Observable<T> observable)`  L12 @Override
### `com.tuwinsmart.tuwin.data.source.remote.transform.StringResultFunc`
L23 · [class] public final StringResultFunc · extends `BaseHttp<Object> implements Function<String, HashMap<String, String>>` · implements `Function<String, HashMap<String, String>>` · `com/tuwinsmart/tuwin/data/source/remote/transform/StringResultFunc.java`
注解：

字段/常量（8）：
- `Class<?> clazz`  L24
- `Regex failedRegex`  L25
- `boolean ignoreBody`  L26
- `Regex regex`  L27
- `MatchGroupCollection groups`  L58
- `MatchGroup matchGroup`  L59
- `String str = string`  L66
- `HashMap<String, String> map2 = map`  L77

方法（6）：
- `Regex getRegex()`  L29
- `Regex getFailedRegex()`  L33
- `public StringResultFunc()`  L37
    - 体内字面量："var\\s+(\\w+)=(\"(.*?)\");?" · "SvrFuncResult=\"(-?\\d+)\""
- `public StringResultFunc(boolean z)`  L42
    - 体内字面量："var\\s+(\\w+)=(\"(.*?)\");?" · "SvrFuncResult=\"(-?\\d+)\""
- `public StringResultFunc(boolean z, Class<?> cls)`  L49
    - 体内字面量："var\\s+(\\w+)=(\"(.*?)\");?" · "SvrFuncResult=\"(-?\\d+)\""
- `HashMap<String, String> apply(String s)`  L57 @Override
### `com.tuwinsmart.tuwin.data.source.remote.transform.WeatherResultFunc`
L12 · [class] public WeatherResultFunc · extends `BaseHttp implements Function<WeatherRes, List<WeatherInfo>>` · implements `Function<WeatherRes, List<WeatherInfo>>` · `com/tuwinsmart/tuwin/data/source/remote/transform/WeatherResultFunc.java`

字段/常量（2）：
- `Class clazz`  L13
- `boolean ignoreBody`  L14

方法（4）：
- `public WeatherResultFunc()`  L16
- `public WeatherResultFunc(boolean z)`  L20
- `public WeatherResultFunc(boolean z, Class cls)`  L25
- `List<WeatherInfo> apply(WeatherRes weatherRes)`  L31 @Override
### `com.tuwinsmart.tuwin.data.source.socket.p008m3.M3SocketMessage`
L13 · [class] public abstract M3SocketMessage · `com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`
注解：

方法（2）：
- ` M3SocketMessage(DefaultConstructorMarker defaultConstructorMarker)`  L14
- `private M3SocketMessage()`  L18
    - 体内字面量："Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage$BatteryUpdate;" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage;" · "info" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/m3/M3BatteryInfo;" · "(Lcom/tuwinsmart/tuwin/data/source/remote/dto/m3/M3BatteryInfo;J)V" · "getInfo" · "()Lcom/tuwinsmart/tuwin/data/source/remote/dto/m3/M3BatteryInfo;" · "getTime" · "()J" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage$RecordingUpdate;" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage;" · "isRecording" · "(ZJ)V" · "()Z" · "getTime" · "()J" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage$RecordingTimeUpdate;" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage;" · "recConsumTime" · "recFileTime" · "(IIJ)V" · "getRecConsumTime" · "()I" · "getRecFileTime" · "getTime" · "()J" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage$MicUpdate;" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage;" · "isMicOn" · "(ZJ)V" · "()Z" · "getTime" · "()J" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage$SDCardUpdate;" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage;" · "status" · "(IJ)V" · "getStatus" · "()I" · "getTime" · "()J" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage$CaptureUpdate;" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage;" · "value" · "(IJ)V" · "getTime" · "()J" · "getValue" · "()I" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage$CountdownTimeUpdate;" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage;" · "value" · "(IJ)V" · "getTime" · "()J" · "getValue" · "()I" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage$Unknown;" · "Lcom/tuwinsmart/tuwin/data/source/socket/m3/M3SocketMessage;" · "rawMessage" · "(Ljava/lang/String;)V" · "getRawMessage" · "()Ljava/lang/String;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.data.source.socket.p008m3.M3SocketMessage$BatteryUpdate`
L23 · [class] public static final BatteryUpdate · extends `M3SocketMessage` · `com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`
注解：

字段/常量（2）：
- `M3BatteryInfo info`  L24
- `long time`  L25

方法（10）：
- `BatteryUpdate copy$default(BatteryUpdate batteryUpdate, M3BatteryInfo m3BatteryInfo, long j, int i, Object obj)`  L27
- `M3BatteryInfo getInfo()`  L38
- `long getTime()`  L43
- `BatteryUpdate copy(M3BatteryInfo info, long time)`  L47
    - 体内字面量："info"
- `boolean equals(Object other)`  L52
- `int hashCode()`  L63
- `String toString()`  L67
    - 体内字面量："BatteryUpdate(info=" · ", time=" · ")"
- `M3BatteryInfo getInfo()`  L71
- `long getTime()`  L75
- `public BatteryUpdate(M3BatteryInfo info, long j)`  L80
    - 体内字面量："info"
### `com.tuwinsmart.tuwin.data.source.socket.p008m3.M3SocketMessage$CaptureUpdate`
L360 · [class] public static final CaptureUpdate · extends `M3SocketMessage` · `com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`
注解：

字段/常量（2）：
- `long time`  L361
- `int value`  L362

方法（10）：
- `CaptureUpdate copy$default(CaptureUpdate captureUpdate, int i, long j, int i2, Object obj)`  L364
- `int getValue()`  L375
- `long getTime()`  L380
- `CaptureUpdate copy(int value, long time)`  L384
- `boolean equals(Object other)`  L388
- `int hashCode()`  L399
- `String toString()`  L403
    - 体内字面量："CaptureUpdate(value=" · ", time=" · ")"
- `int getValue()`  L407
- `long getTime()`  L411
- `public CaptureUpdate(int i, long j)`  L415
### `com.tuwinsmart.tuwin.data.source.socket.p008m3.M3SocketMessage$CountdownTimeUpdate`
L424 · [class] public static final CountdownTimeUpdate · extends `M3SocketMessage` · `com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`
注解：

字段/常量（2）：
- `long time`  L425
- `int value`  L426

方法（10）：
- `CountdownTimeUpdate copy$default(CountdownTimeUpdate countdownTimeUpdate, int i, long j, int i2, Object obj)`  L428
- `int getValue()`  L439
- `long getTime()`  L444
- `CountdownTimeUpdate copy(int value, long time)`  L448
- `boolean equals(Object other)`  L452
- `int hashCode()`  L463
- `String toString()`  L467
    - 体内字面量："CountdownTimeUpdate(value=" · ", time=" · ")"
- `int getValue()`  L471
- `long getTime()`  L475
- `public CountdownTimeUpdate(int i, long j)`  L479
### `com.tuwinsmart.tuwin.data.source.socket.p008m3.M3SocketMessage$MicUpdate`
L232 · [class] public static final MicUpdate · extends `M3SocketMessage` · `com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`
注解：

字段/常量（2）：
- `boolean isMicOn`  L233
- `long time`  L234

方法（10）：
- `MicUpdate copy$default(MicUpdate micUpdate, boolean z, long j, int i, Object obj)`  L236
- `boolean getIsMicOn()`  L247
- `long getTime()`  L252
- `MicUpdate copy(boolean isMicOn, long time)`  L256
- `boolean equals(Object other)`  L260
- `int hashCode()`  L271
- `String toString()`  L275
    - 体内字面量："MicUpdate(isMicOn=" · ", time=" · ")"
- `boolean isMicOn()`  L279
- `long getTime()`  L283
- `public MicUpdate(boolean z, long j)`  L287
### `com.tuwinsmart.tuwin.data.source.socket.p008m3.M3SocketMessage$RecordingTimeUpdate`
L154 · [class] public static final RecordingTimeUpdate · extends `M3SocketMessage` · `com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`
注解：

字段/常量（3）：
- `int recConsumTime`  L155
- `int recFileTime`  L156
- `long time`  L157

方法（12）：
- `RecordingTimeUpdate copy$default(RecordingTimeUpdate recordingTimeUpdate, int i, int i2, long j, int i3, Object obj)`  L159
- `int getRecConsumTime()`  L173
- `int getRecFileTime()`  L178
- `long getTime()`  L183
- `RecordingTimeUpdate copy(int recConsumTime, int recFileTime, long time)`  L187
- `boolean equals(Object other)`  L191
- `int hashCode()`  L202
- `String toString()`  L206
    - 体内字面量："RecordingTimeUpdate(recConsumTime=" · ", recFileTime=" · ", time=" · ")"
- `int getRecConsumTime()`  L210
- `int getRecFileTime()`  L214
- `long getTime()`  L218
- `public RecordingTimeUpdate(int i, int i2, long j)`  L222
### `com.tuwinsmart.tuwin.data.source.socket.p008m3.M3SocketMessage$RecordingUpdate`
L90 · [class] public static final RecordingUpdate · extends `M3SocketMessage` · `com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`
注解：

字段/常量（2）：
- `boolean isRecording`  L91
- `long time`  L92

方法（10）：
- `RecordingUpdate copy$default(RecordingUpdate recordingUpdate, boolean z, long j, int i, Object obj)`  L94
- `boolean getIsRecording()`  L105
- `long getTime()`  L110
- `RecordingUpdate copy(boolean isRecording, long time)`  L114
- `boolean equals(Object other)`  L118
- `int hashCode()`  L129
- `String toString()`  L133
    - 体内字面量："RecordingUpdate(isRecording=" · ", time=" · ")"
- `boolean isRecording()`  L137
- `long getTime()`  L141
- `public RecordingUpdate(boolean z, long j)`  L145
### `com.tuwinsmart.tuwin.data.source.socket.p008m3.M3SocketMessage$SDCardUpdate`
L296 · [class] public static final SDCardUpdate · extends `M3SocketMessage` · `com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`
注解：

字段/常量（2）：
- `int status`  L297
- `long time`  L298

方法（10）：
- `SDCardUpdate copy$default(SDCardUpdate sDCardUpdate, int i, long j, int i2, Object obj)`  L300
- `int getStatus()`  L311
- `long getTime()`  L316
- `SDCardUpdate copy(int status, long time)`  L320
- `boolean equals(Object other)`  L324
- `int hashCode()`  L335
- `String toString()`  L339
    - 体内字面量："SDCardUpdate(status=" · ", time=" · ")"
- `int getStatus()`  L343
- `long getTime()`  L347
- `public SDCardUpdate(int i, long j)`  L351
### `com.tuwinsmart.tuwin.data.source.socket.p008m3.M3SocketMessage$Unknown`
L488 · [class] public static final Unknown · extends `M3SocketMessage` · `com/tuwinsmart/tuwin/data/source/socket/p008m3/M3SocketMessage.java`
注解：

字段/常量（1）：
- `String rawMessage`  L489

方法（8）：
- `Unknown copy$default(Unknown unknown, String str, int i, Object obj)`  L491
- `String getRawMessage()`  L499
- `Unknown copy(String rawMessage)`  L503
    - 体内字面量："rawMessage"
- `boolean equals(Object other)`  L508
- `int hashCode()`  L515
- `String toString()`  L519
    - 体内字面量："Unknown(rawMessage=" · ")"
- `public Unknown(String rawMessage)`  L524
    - 体内字面量："rawMessage"
- `String getRawMessage()`  L530
### `com.tuwinsmart.tuwin.data.source.socket.Ride5SocketMessagePolicy`
L11 · [class] public final Ride5SocketMessagePolicy · `com/tuwinsmart/tuwin/data/source/socket/Ride5SocketMessagePolicy.java`
注解：

方法（2）：
- `private Ride5SocketMessagePolicy()`  L14
- `boolean shouldRestartPreview(String message)`  L17
    - 体内字面量："message"