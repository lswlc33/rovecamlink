# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.domain

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 63 个文件 / 128 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.domain.model.ConnectedDevice`
L18 · [class] public final ConnectedDevice · `com/tuwinsmart/tuwin/domain/model/ConnectedDevice.java`
注解：

字段/常量（25）：
- `String DEFAULT_WIFI_PASSWORD = "12345678"`  L22
- `String apBssid`  L25 @Expose
- `String boardversion`  L28 @Expose
- `DeviceType deviceType`  L31 @Expose
- `String devid`  L34 @Expose
- `boolean isConnected`  L35
- `String model`  L38 @Expose
- `String product`  L41 @Expose
- `String pwd`  L44 @Expose
- `String remark`  L47 @Expose
- `String reportedWifiPassword`  L48
- `String sessionId`  L51 @Expose
- `String ssid`  L54 @Expose
- `String version`  L57 @Expose
- `String str = this.ssid`  L173
- `String str2 = this.apBssid`  L175
- `String str3 = this.devid`  L177
- `String str4 = this.reportedWifiPassword`  L179
- `String str5 = this.version`  L181
- `String str6 = this.boardversion`  L183
- `String str7 = this.model`  L185
- `String str8 = this.product`  L187
- `DeviceType deviceType = this.deviceType`  L189
- `String str9 = this.sessionId`  L191
- `DeviceType deviceType = this.deviceType`  L328

方法（47）：
- `public ConnectedDevice()`  L86
- `String getSsid()`  L91
- `String getModel()`  L96
- `String getProduct()`  L101
- `DeviceType getDeviceType()`  L106
- `String getSessionId()`  L111
- `String getApBssid()`  L116
- `String getDevid()`  L121
- `String getPwd()`  L126
- `String getReportedWifiPassword()`  L131
- `String getRemark()`  L136
- `boolean getIsConnected()`  L141
- `String getVersion()`  L146
- `String getBoardversion()`  L151
- `ConnectedDevice copy(String ssid, String apBssid, String devid, String pwd, String reportedWifiPassword, String remark, boolean isConnected, String version, String boardversion, String model, String product, DeviceType deviceType, String sessionId)`  L155
    - 体内字面量："pwd" · "remark"
- `boolean equals(Object other)`  L161
- `int hashCode()`  L172
- `String toString()`  L195
    - 体内字面量："ConnectedDevice(ssid=" · ", apBssid=" · ", devid=" · ", pwd=" · ", reportedWifiPassword=" · ", remark=" · ", isConnected=" · ", version=" · ", boardversion=" · ", model=" · ", product=" · ", deviceType=" · ", sessionId=" · ")"
- `public ConnectedDevice(String str, String str2, String str3, String pwd, String str4, String remark, boolean z, String str5, String str6, String str7, String str8, DeviceType deviceType, String str9)`  L199
    - 体内字面量："pwd" · "remark"
- `String getSsid()`  L217
- `void setSsid(String str)`  L221
- `String getApBssid()`  L225
- `void setApBssid(String str)`  L229
- `String getDevid()`  L233
- `void setDevid(String str)`  L237
- ` ConnectedDevice(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, DeviceType deviceType, String str11, int i, DefaultConstructorMarker defaultConstructorMarker)`  L241
- `String getPwd()`  L245
- `void setPwd(String str)`  L249
    - 体内字面量："<set-?>"
- `String getReportedWifiPassword()`  L254
- `void setReportedWifiPassword(String str)`  L258
- `String getRemark()`  L262
- `void setRemark(String str)`  L266
    - 体内字面量："<set-?>"
- `boolean isConnected()`  L271
- `void setConnected(boolean z)`  L275
- `String getVersion()`  L279
- `void setVersion(String str)`  L283
- `String getBoardversion()`  L287
- `void setBoardversion(String str)`  L291
- `String getModel()`  L295
- `void setModel(String str)`  L299
- `String getProduct()`  L303
- `void setProduct(String str)`  L307
- `DeviceType getDeviceType()`  L311
- `void setDeviceType(DeviceType deviceType)`  L315
- `String getSessionId()`  L319
- `void setSessionId(String str)`  L323
- `String getDeviceName()`  L327
### `com.tuwinsmart.tuwin.domain.model.ConnectedDevice$Companion`
L350 · [class] public static final Companion · `com/tuwinsmart/tuwin/domain/model/ConnectedDevice.java`
注解：

方法（5）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L351
- `private Companion()`  L355
- `ConnectedDevice fromM3DeviceAttr(M3DeviceAttr attr)`  L358
    - 体内字面量："attr"
- `ConnectedDevice fromRide5DeviceAttr$default(Companion companion, HashMap map, String str, int i, Object obj)`  L369
- `ConnectedDevice fromRide5DeviceAttr(HashMap<String, String> attr, String ssid)`  L376
    - 体内字面量："attr" · "devid" · "softversion" · "boardversion" · "model" · "product"
### `com.tuwinsmart.tuwin.domain.model.ConnectedDevice$WhenMappings`
L61 · [class] public WhenMappings · `com/tuwinsmart/tuwin/domain/model/ConnectedDevice.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L62
### `com.tuwinsmart.tuwin.domain.model.ConnectionProgress`
L11 · [enum] public ConnectionProgress · `com/tuwinsmart/tuwin/domain/model/ConnectionProgress.java`
注解：

枚举常量（13）：
- `CONNECTING()`  L12
- `AUTHENTICATING()`  L13
- `SYNCING_TIME()`  L14
- `FETCHING_DEVICE_INFO()`  L15
- `RIDE5_IDENTIFYING_NETWORK()`  L16
- `RIDE5_REGISTERING_DEVICE()`  L17
- `RIDE5_VERIFYING_ONLINE()`  L18
- `RIDE5_FETCHING_DEVICE_INFO()`  L19
- `M3_DETECTING_HTTP()`  L20
- `M3_VALIDATING_DEVICE()`  L21
- `M3_FETCHING_MEDIA_INFO()`  L22
- `M3_CONNECTING_CONTROL()`  L23
- `M3_FETCHING_DEVICE_INFO()`  L24

方法（1）：
- `EnumEntries<ConnectionProgress> getEntries()`  L28
### `com.tuwinsmart.tuwin.domain.model.ConnectionProgressUpdate`
L10 · [interface] public ConnectionProgressUpdate · `com/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate.java`
注解：

字面量："Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate$Started;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate;" · "step" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "(Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;)V" · "getStep" · "()Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate$Failed;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate;" · "step" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "(Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;)V" · "getStep" · "()Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate$Retrying;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate;" · "step" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "attempt" · "maxAttempts" · "(Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;II)V" · "getAttempt" · "()I" · "getMaxAttempts" · "getStep" · "()Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate$Warning;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate;" · "step" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "(Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;)V" · "getStep" · "()Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.model.ConnectionProgressUpdate$Failed`
L61 · [class] public static final Failed · implements `ConnectionProgressUpdate` · `com/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate.java`
注解：

字段/常量（1）：
- `ConnectionProgress step`  L62

方法（8）：
- `Failed copy$default(Failed failed, ConnectionProgress connectionProgress, int i, Object obj)`  L64
- `ConnectionProgress getStep()`  L72
- `Failed copy(ConnectionProgress step)`  L76
    - 体内字面量："step"
- `boolean equals(Object other)`  L81
- `int hashCode()`  L88
- `String toString()`  L92
    - 体内字面量："Failed(step=" · ")"
- `public Failed(ConnectionProgress step)`  L96
    - 体内字面量："step"
- `ConnectionProgress getStep()`  L101
### `com.tuwinsmart.tuwin.domain.model.ConnectionProgressUpdate$Retrying`
L108 · [class] public static final Retrying · implements `ConnectionProgressUpdate` · `com/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate.java`
注解：

字段/常量（3）：
- `int attempt`  L109
- `int maxAttempts`  L110
- `ConnectionProgress step`  L111

方法（12）：
- `Retrying copy$default(Retrying retrying, ConnectionProgress connectionProgress, int i, int i2, int i3, Object obj)`  L113
- `ConnectionProgress getStep()`  L127
- `int getAttempt()`  L132
- `int getMaxAttempts()`  L137
- `Retrying copy(ConnectionProgress step, int attempt, int maxAttempts)`  L141
    - 体内字面量："step"
- `boolean equals(Object other)`  L146
- `int hashCode()`  L157
- `String toString()`  L161
    - 体内字面量："Retrying(step=" · ", attempt=" · ", maxAttempts=" · ")"
- `public Retrying(ConnectionProgress step, int i, int i2)`  L165
    - 体内字面量："step"
- `ConnectionProgress getStep()`  L172
- `int getAttempt()`  L176
- `int getMaxAttempts()`  L180
### `com.tuwinsmart.tuwin.domain.model.ConnectionProgressUpdate$Started`
L14 · [class] public static final Started · implements `ConnectionProgressUpdate` · `com/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate.java`
注解：

字段/常量（1）：
- `ConnectionProgress step`  L15

方法（8）：
- `Started copy$default(Started started, ConnectionProgress connectionProgress, int i, Object obj)`  L17
- `ConnectionProgress getStep()`  L25
- `Started copy(ConnectionProgress step)`  L29
    - 体内字面量："step"
- `boolean equals(Object other)`  L34
- `int hashCode()`  L41
- `String toString()`  L45
    - 体内字面量："Started(step=" · ")"
- `public Started(ConnectionProgress step)`  L49
    - 体内字面量："step"
- `ConnectionProgress getStep()`  L54
### `com.tuwinsmart.tuwin.domain.model.ConnectionProgressUpdate$Warning`
L187 · [class] public static final Warning · implements `ConnectionProgressUpdate` · `com/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate.java`
注解：

字段/常量（1）：
- `ConnectionProgress step`  L188

方法（8）：
- `Warning copy$default(Warning warning, ConnectionProgress connectionProgress, int i, Object obj)`  L190
- `ConnectionProgress getStep()`  L198
- `Warning copy(ConnectionProgress step)`  L202
    - 体内字面量："step"
- `boolean equals(Object other)`  L207
- `int hashCode()`  L214
- `String toString()`  L218
    - 体内字面量："Warning(step=" · ")"
- `public Warning(ConnectionProgress step)`  L222
    - 体内字面量："step"
- `ConnectionProgress getStep()`  L227
### `com.tuwinsmart.tuwin.domain.model.ConnectState`
L13 · [class] public abstract ConnectState · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

方法（2）：
- ` ConnectState(DefaultConstructorMarker defaultConstructorMarker)`  L14
- `private ConnectState()`  L18
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/model/ConnectState$Idle;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$Detecting;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$RequestingWifi;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$WifiSettingsRequired;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "message" · "(Ljava/lang/String;)V" · "getMessage" · "()Ljava/lang/String;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$Timeout;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$WrongNetwork;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "currentSsid" · "expectedSsid" · "(Ljava/lang/String;Ljava/lang/String;)V" · "getCurrentSsid" · "()Ljava/lang/String;" · "getExpectedSsid" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$Progress;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "step" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "(Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;)V" · "getStep" · "()Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$StepFailed;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "step" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "attempt" · "maxAttempts" · "(Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;II)V" · "getAttempt" · "()I" · "getMaxAttempts" · "getStep" · "()Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$Retrying;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "step" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "attempt" · "maxAttempts" · "(Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;II)V" · "getAttempt" · "()I" · "getMaxAttempts" · "getStep" · "()Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$StepWarning;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "step" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "(Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;)V" · "getStep" · "()Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgress;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$Success;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "deviceInfo" · "Ljava/util/HashMap;" · "Lkotlin/collections/HashMap;" · "(Ljava/util/HashMap;)V" · "getDeviceInfo" · "()Ljava/util/HashMap;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$M3HttpSuccess;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "deviceInfo" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/m3/M3DeviceInfo;" · "(Lcom/tuwinsmart/tuwin/data/source/remote/dto/m3/M3DeviceInfo;)V" · "getDeviceInfo" · "()Lcom/tuwinsmart/tuwin/data/source/remote/dto/m3/M3DeviceInfo;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$M3SocketConnecting;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "deviceInfo" · "Lcom/tuwinsmart/tuwin/data/source/remote/dto/m3/M3DeviceInfo;" · "(Lcom/tuwinsmart/tuwin/data/source/remote/dto/m3/M3DeviceInfo;)V" · "getDeviceInfo" · "()Lcom/tuwinsmart/tuwin/data/source/remote/dto/m3/M3DeviceInfo;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$M3Success;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "result" · "Lcom/tuwinsmart/tuwin/domain/model/M3ConnectionResult;" · "(Lcom/tuwinsmart/tuwin/domain/model/M3ConnectionResult;)V" · "getResult" · "()Lcom/tuwinsmart/tuwin/domain/model/M3ConnectionResult;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$Failed;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState$Error;" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectState;" · "message" · "(Ljava/lang/String;)V" · "getMessage" · "()Ljava/lang/String;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.model.ConnectState$Detecting`
L33 · [class] public static final Detecting · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

方法（1）：
- `private Detecting()`  L36
### `com.tuwinsmart.tuwin.domain.model.ConnectState$Error`
L647 · [class] public static final Error · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（2）：
- `String message`  L648
- `String str = this.message`  L674

方法（8）：
- `Error copy$default(Error error, String str, int i, Object obj)`  L650
- `String getMessage()`  L658
- `Error copy(String message)`  L662
- `boolean equals(Object other)`  L666
- `int hashCode()`  L673
- `String toString()`  L681
    - 体内字面量："Error(message=" · ")"
- `public Error(String str)`  L685
- `String getMessage()`  L690
### `com.tuwinsmart.tuwin.domain.model.ConnectState$Failed`
L637 · [class] public static final Failed · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

方法（1）：
- `private Failed()`  L640
### `com.tuwinsmart.tuwin.domain.model.ConnectState$Idle`
L23 · [class] public static final Idle · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

方法（1）：
- `private Idle()`  L26
### `com.tuwinsmart.tuwin.domain.model.ConnectState$M3HttpSuccess`
L490 · [class] public static final M3HttpSuccess · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（1）：
- `M3DeviceInfo deviceInfo`  L491

方法（8）：
- `M3HttpSuccess copy$default(M3HttpSuccess m3HttpSuccess, M3DeviceInfo m3DeviceInfo, int i, Object obj)`  L493
- `M3DeviceInfo getDeviceInfo()`  L501
- `M3HttpSuccess copy(M3DeviceInfo deviceInfo)`  L505
    - 体内字面量："deviceInfo"
- `boolean equals(Object other)`  L510
- `int hashCode()`  L517
- `String toString()`  L521
    - 体内字面量："M3HttpSuccess(deviceInfo=" · ")"
- `public M3HttpSuccess(M3DeviceInfo deviceInfo)`  L526
    - 体内字面量："deviceInfo"
- `M3DeviceInfo getDeviceInfo()`  L532
### `com.tuwinsmart.tuwin.domain.model.ConnectState$M3SocketConnecting`
L539 · [class] public static final M3SocketConnecting · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（1）：
- `M3DeviceInfo deviceInfo`  L540

方法（8）：
- `M3SocketConnecting copy$default(M3SocketConnecting m3SocketConnecting, M3DeviceInfo m3DeviceInfo, int i, Object obj)`  L542
- `M3DeviceInfo getDeviceInfo()`  L550
- `M3SocketConnecting copy(M3DeviceInfo deviceInfo)`  L554
    - 体内字面量："deviceInfo"
- `boolean equals(Object other)`  L559
- `int hashCode()`  L566
- `String toString()`  L570
    - 体内字面量："M3SocketConnecting(deviceInfo=" · ")"
- `public M3SocketConnecting(M3DeviceInfo deviceInfo)`  L575
    - 体内字面量："deviceInfo"
- `M3DeviceInfo getDeviceInfo()`  L581
### `com.tuwinsmart.tuwin.domain.model.ConnectState$M3Success`
L588 · [class] public static final M3Success · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（1）：
- `M3ConnectionResult result`  L589

方法（8）：
- `M3Success copy$default(M3Success m3Success, M3ConnectionResult m3ConnectionResult, int i, Object obj)`  L591
- `M3ConnectionResult getResult()`  L599
- `M3Success copy(M3ConnectionResult result)`  L603
    - 体内字面量："result"
- `boolean equals(Object other)`  L608
- `int hashCode()`  L615
- `String toString()`  L619
    - 体内字面量："M3Success(result=" · ")"
- `public M3Success(M3ConnectionResult result)`  L624
    - 体内字面量："result"
- `M3ConnectionResult getResult()`  L630
### `com.tuwinsmart.tuwin.domain.model.ConnectState$Progress`
L181 · [class] public static final Progress · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（1）：
- `ConnectionProgress step`  L182

方法（8）：
- `Progress copy$default(Progress progress, ConnectionProgress connectionProgress, int i, Object obj)`  L184
- `ConnectionProgress getStep()`  L192
- `Progress copy(ConnectionProgress step)`  L196
    - 体内字面量："step"
- `boolean equals(Object other)`  L201
- `int hashCode()`  L208
- `String toString()`  L212
    - 体内字面量："Progress(step=" · ")"
- `public Progress(ConnectionProgress step)`  L217
    - 体内字面量："step"
- `ConnectionProgress getStep()`  L223
### `com.tuwinsmart.tuwin.domain.model.ConnectState$RequestingWifi`
L43 · [class] public static final RequestingWifi · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

方法（1）：
- `private RequestingWifi()`  L46
### `com.tuwinsmart.tuwin.domain.model.ConnectState$Retrying`
L311 · [class] public static final Retrying · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（3）：
- `int attempt`  L312
- `int maxAttempts`  L313
- `ConnectionProgress step`  L314

方法（12）：
- `Retrying copy$default(Retrying retrying, ConnectionProgress connectionProgress, int i, int i2, int i3, Object obj)`  L316
- `ConnectionProgress getStep()`  L330
- `int getAttempt()`  L335
- `int getMaxAttempts()`  L340
- `Retrying copy(ConnectionProgress step, int attempt, int maxAttempts)`  L344
    - 体内字面量："step"
- `boolean equals(Object other)`  L349
- `int hashCode()`  L360
- `String toString()`  L364
    - 体内字面量："Retrying(step=" · ", attempt=" · ", maxAttempts=" · ")"
- `ConnectionProgress getStep()`  L368
- `int getAttempt()`  L372
- `int getMaxAttempts()`  L376
- `public Retrying(ConnectionProgress step, int i, int i2)`  L381
    - 体内字面量："step"
### `com.tuwinsmart.tuwin.domain.model.ConnectState$StepFailed`
L230 · [class] public static final StepFailed · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（3）：
- `int attempt`  L231
- `int maxAttempts`  L232
- `ConnectionProgress step`  L233

方法（12）：
- `StepFailed copy$default(StepFailed stepFailed, ConnectionProgress connectionProgress, int i, int i2, int i3, Object obj)`  L235
- `ConnectionProgress getStep()`  L249
- `int getAttempt()`  L254
- `int getMaxAttempts()`  L259
- `StepFailed copy(ConnectionProgress step, int attempt, int maxAttempts)`  L263
    - 体内字面量："step"
- `boolean equals(Object other)`  L268
- `int hashCode()`  L279
- `String toString()`  L283
    - 体内字面量："StepFailed(step=" · ", attempt=" · ", maxAttempts=" · ")"
- `ConnectionProgress getStep()`  L287
- `int getAttempt()`  L291
- `int getMaxAttempts()`  L295
- `public StepFailed(ConnectionProgress step, int i, int i2)`  L300
    - 体内字面量："step"
### `com.tuwinsmart.tuwin.domain.model.ConnectState$StepWarning`
L392 · [class] public static final StepWarning · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（1）：
- `ConnectionProgress step`  L393

方法（8）：
- `StepWarning copy$default(StepWarning stepWarning, ConnectionProgress connectionProgress, int i, Object obj)`  L395
- `ConnectionProgress getStep()`  L403
- `StepWarning copy(ConnectionProgress step)`  L407
    - 体内字面量："step"
- `boolean equals(Object other)`  L412
- `int hashCode()`  L419
- `String toString()`  L423
    - 体内字面量："StepWarning(step=" · ")"
- `public StepWarning(ConnectionProgress step)`  L428
    - 体内字面量："step"
- `ConnectionProgress getStep()`  L434
### `com.tuwinsmart.tuwin.domain.model.ConnectState$Success`
L441 · [class] public static final Success · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（1）：
- `HashMap<String, String> deviceInfo`  L442

方法（8）：
- `Success copy$default(Success success, HashMap map, int i, Object obj)`  L445
- `HashMap<String, String> component1()`  L452
- `Success copy(HashMap<String, String> deviceInfo)`  L456
    - 体内字面量："deviceInfo"
- `boolean equals(Object other)`  L461
- `int hashCode()`  L468
- `String toString()`  L472
    - 体内字面量："Success(deviceInfo=" · ")"
- `public Success(HashMap<String, String> deviceInfo)`  L477
    - 体内字面量："deviceInfo"
- `HashMap<String, String> getDeviceInfo()`  L483
### `com.tuwinsmart.tuwin.domain.model.ConnectState$Timeout`
L103 · [class] public static final Timeout · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

方法（1）：
- `private Timeout()`  L106
### `com.tuwinsmart.tuwin.domain.model.ConnectState$WifiSettingsRequired`
L53 · [class] public static final WifiSettingsRequired · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（2）：
- `String message`  L54
- `String str = this.message`  L80

方法（8）：
- `WifiSettingsRequired copy$default(WifiSettingsRequired wifiSettingsRequired, String str, int i, Object obj)`  L56
- `String getMessage()`  L64
- `WifiSettingsRequired copy(String message)`  L68
- `boolean equals(Object other)`  L72
- `int hashCode()`  L79
- `String toString()`  L87
    - 体内字面量："WifiSettingsRequired(message=" · ")"
- `public WifiSettingsRequired(String str)`  L91
- `String getMessage()`  L96
### `com.tuwinsmart.tuwin.domain.model.ConnectState$WrongNetwork`
L113 · [class] public static final WrongNetwork · extends `ConnectState` · `com/tuwinsmart/tuwin/domain/model/ConnectState.java`
注解：

字段/常量（3）：
- `String currentSsid`  L114
- `String expectedSsid`  L115
- `String str = this.currentSsid`  L154

方法（10）：
- `WrongNetwork copy$default(WrongNetwork wrongNetwork, String str, String str2, int i, Object obj)`  L117
- `String getCurrentSsid()`  L128
- `String getExpectedSsid()`  L133
- `WrongNetwork copy(String currentSsid, String expectedSsid)`  L137
    - 体内字面量："expectedSsid"
- `boolean equals(Object other)`  L142
- `int hashCode()`  L153
- `String toString()`  L158
    - 体内字面量："WrongNetwork(currentSsid=" · ", expectedSsid=" · ")"
- `String getCurrentSsid()`  L162
- `String getExpectedSsid()`  L166
- `public WrongNetwork(String str, String expectedSsid)`  L171
    - 体内字面量："expectedSsid"
### `com.tuwinsmart.tuwin.domain.model.DeviceConfig`
L14 · [class] public final DeviceConfig · `com/tuwinsmart/tuwin/domain/model/DeviceConfig.java`
注解：

字段/常量（4）：
- `DeviceType deviceType`  L18
- `int helpUrlResId`  L19
- `String wifiNamePattern`  L20
- `String wifiPassword`  L21

方法（14）：
- `DeviceConfig copy$default(DeviceConfig deviceConfig, DeviceType deviceType, String str, String str2, int i, int i2, Object obj)`  L23
- `DeviceType getDeviceType()`  L40
- `String getWifiPassword()`  L45
- `String getWifiNamePattern()`  L50
- `int getHelpUrlResId()`  L55
- `DeviceConfig copy(DeviceType deviceType, String wifiPassword, String wifiNamePattern, int helpUrlResId)`  L59
    - 体内字面量："deviceType" · "wifiPassword" · "wifiNamePattern"
- `boolean equals(Object other)`  L66
- `int hashCode()`  L77
- `String toString()`  L81
    - 体内字面量："DeviceConfig(deviceType=" · ", wifiPassword=" · ", wifiNamePattern=" · ", helpUrlResId=" · ")"
- `public DeviceConfig(DeviceType deviceType, String wifiPassword, String wifiNamePattern, int i)`  L85
    - 体内字面量："deviceType" · "wifiPassword" · "wifiNamePattern"
- `DeviceType getDeviceType()`  L95
- `String getWifiPassword()`  L99
- `String getWifiNamePattern()`  L103
- `int getHelpUrlResId()`  L107
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/model/DeviceConfig$Companion;" · "()V" · "fromDeviceType" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceConfig;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.model.DeviceConfig$Companion`
L113 · [class] public static final Companion · `com/tuwinsmart/tuwin/domain/model/DeviceConfig.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L142
- `private Companion()`  L146
- `DeviceConfig fromDeviceType(DeviceType deviceType)`  L149
    - 体内字面量："deviceType" · "TUWIN_XXXX" · "TUWIN_R3P_XXX" · "TUWIN_R6_XXX" · "TUWIN_M3_XXXX"
### `com.tuwinsmart.tuwin.domain.model.DeviceConfig$Companion$WhenMappings`
L117 · [class] public WhenMappings · `com/tuwinsmart/tuwin/domain/model/DeviceConfig.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L118
### `com.tuwinsmart.tuwin.domain.model.DeviceListItem`
L12 · [class] public abstract DeviceListItem · `com/tuwinsmart/tuwin/domain/model/DeviceListItem.java`
注解：

方法（2）：
- ` DeviceListItem(DefaultConstructorMarker defaultConstructorMarker)`  L13
- `private DeviceListItem()`  L17
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/model/DeviceListItem$CategoryHeader;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceListItem;" · "titleResId" · "(I)V" · "getTitleResId" · "()I" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceListItem$DeviceEntry;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceListItem;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "(Lcom/tuwinsmart/tuwin/domain/model/DeviceType;)V" · "getDeviceType" · "()Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.model.DeviceListItem$CategoryHeader`
L22 · [class] public static final CategoryHeader · extends `DeviceListItem` · `com/tuwinsmart/tuwin/domain/model/DeviceListItem.java`
注解：

字段/常量（1）：
- `int titleResId`  L23

方法（8）：
- `CategoryHeader copy$default(CategoryHeader categoryHeader, int i, int i2, Object obj)`  L25
- `int getTitleResId()`  L33
- `CategoryHeader copy(int titleResId)`  L37
- `boolean equals(Object other)`  L41
- `int hashCode()`  L48
- `String toString()`  L52
    - 体内字面量："CategoryHeader(titleResId=" · ")"
- `public CategoryHeader(int i)`  L56
- `int getTitleResId()`  L61
### `com.tuwinsmart.tuwin.domain.model.DeviceListItem$DeviceEntry`
L68 · [class] public static final DeviceEntry · extends `DeviceListItem` · `com/tuwinsmart/tuwin/domain/model/DeviceListItem.java`
注解：

字段/常量（1）：
- `DeviceType deviceType`  L69

方法（8）：
- `DeviceEntry copy$default(DeviceEntry deviceEntry, DeviceType deviceType, int i, Object obj)`  L71
- `DeviceType getDeviceType()`  L79
- `DeviceEntry copy(DeviceType deviceType)`  L83
    - 体内字面量："deviceType"
- `boolean equals(Object other)`  L88
- `int hashCode()`  L95
- `String toString()`  L99
    - 体内字面量："DeviceEntry(deviceType=" · ")"
- `public DeviceEntry(DeviceType deviceType)`  L104
    - 体内字面量："deviceType"
- `DeviceType getDeviceType()`  L110
### `com.tuwinsmart.tuwin.domain.model.DeviceType`
L14 · [enum] public DeviceType · `com/tuwinsmart/tuwin/domain/model/DeviceType.java`
注解：

字段/常量（4）：
- `int categoryResId`  L21
- `String code`  L22
- `int iconResId`  L23
- `int nameResId`  L24

枚举常量（5）：
- `RIDE5("RIDE5", C1870R.string.riding_recorder, C1870R.string.ride5, C1870R.drawable.img_ride5)`  L15
- `RIDE3PRO("RIDE3PRO", C1870R.string.riding_recorder, C1870R.string.ride3pro, C1870R.drawable.img_ride3pro)`  L16
- `M3(M3OtaVersionPolicy.BOARD_VERSION, C1870R.string.thumb_camera, C1870R.string.device_m3, C1870R.drawable.img_m3)`  L17
- `RIDE6("RIDE6", C1870R.string.riding_recorder, C1870R.string.ride6, C1870R.drawable.img_ride6)`  L18
- `DeviceType(String str, int i, int i2, int i3)`  L30

方法（5）：
- `EnumEntries<DeviceType> getEntries()`  L26
- `String getCode()`  L37
- `int getCategoryResId()`  L41
- `int getNameResId()`  L45
- `int getIconResId()`  L49
### `com.tuwinsmart.tuwin.domain.model.DeviceWifiScanState`
L13 · [class] public abstract DeviceWifiScanState · `com/tuwinsmart/tuwin/domain/model/DeviceWifiScanState.java`
注解：

方法（2）：
- ` DeviceWifiScanState(DefaultConstructorMarker defaultConstructorMarker)`  L14
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState$Idle;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState;" · "()V" · "app_release_64"
- `private DeviceWifiScanState()`  L28
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState$Scanning;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState$Ready;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState;" · "accessPoints" · "Lcom/tuwinsmart/tuwin/core/network/DeviceWifiAccessPoint;" · "(Ljava/util/List;)V" · "getAccessPoints" · "()Ljava/util/List;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState$Empty;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState;" · "()V" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState$Failed;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceWifiScanState;" · "message" · "(Ljava/lang/String;)V" · "getMessage" · "()Ljava/lang/String;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.model.DeviceWifiScanState$Empty`
L92 · [class] public static final Empty · extends `DeviceWifiScanState` · `com/tuwinsmart/tuwin/domain/model/DeviceWifiScanState.java`
注解：

方法（1）：
- `private Empty()`  L95
### `com.tuwinsmart.tuwin.domain.model.DeviceWifiScanState$Failed`
L102 · [class] public static final Failed · extends `DeviceWifiScanState` · `com/tuwinsmart/tuwin/domain/model/DeviceWifiScanState.java`
注解：

字段/常量（2）：
- `String message`  L103
- `String str = this.message`  L134

方法（10）：
- `public Failed()`  L106
- `Failed copy$default(Failed failed, String str, int i, Object obj)`  L110
- `String getMessage()`  L118
- `Failed copy(String message)`  L122
- `boolean equals(Object other)`  L126
- `int hashCode()`  L133
- `String toString()`  L141
    - 体内字面量："Failed(message=" · ")"
- `public Failed(String str)`  L145
- ` Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker)`  L150
- `String getMessage()`  L154
### `com.tuwinsmart.tuwin.domain.model.DeviceWifiScanState$Idle`
L20 · [class] public static final Idle · extends `DeviceWifiScanState` · `com/tuwinsmart/tuwin/domain/model/DeviceWifiScanState.java`
注解：

方法（1）：
- `private Idle()`  L23
### `com.tuwinsmart.tuwin.domain.model.DeviceWifiScanState$Ready`
L43 · [class] public static final Ready · extends `DeviceWifiScanState` · `com/tuwinsmart/tuwin/domain/model/DeviceWifiScanState.java`
注解：

字段/常量（1）：
- `List<DeviceWifiAccessPoint> accessPoints`  L44

方法（8）：
- `Ready copy$default(Ready ready, List list, int i, Object obj)`  L47
- `List<DeviceWifiAccessPoint> component1()`  L54
- `Ready copy(List<DeviceWifiAccessPoint> accessPoints)`  L58
    - 体内字面量："accessPoints"
- `boolean equals(Object other)`  L63
- `int hashCode()`  L70
- `String toString()`  L74
    - 体内字面量："Ready(accessPoints=" · ")"
- `public Ready(List<DeviceWifiAccessPoint> accessPoints)`  L79
    - 体内字面量："accessPoints"
- `List<DeviceWifiAccessPoint> getAccessPoints()`  L85
### `com.tuwinsmart.tuwin.domain.model.DeviceWifiScanState$Scanning`
L33 · [class] public static final Scanning · extends `DeviceWifiScanState` · `com/tuwinsmart/tuwin/domain/model/DeviceWifiScanState.java`
注解：

方法（1）：
- `private Scanning()`  L36
### `com.tuwinsmart.tuwin.domain.model.LocationInfo`
L11 · [class] public final LocationInfo · `com/tuwinsmart/tuwin/domain/model/LocationInfo.java`
注解：

字段/常量（2）：
- `String areaAddress`  L12
- `String code`  L13

方法（10）：
- `LocationInfo copy$default(LocationInfo locationInfo, String str, String str2, int i, Object obj)`  L15
- `String getAreaAddress()`  L26
- `String getCode()`  L31
- `LocationInfo copy(String areaAddress, String code)`  L35
    - 体内字面量："areaAddress" · "code"
- `boolean equals(Object other)`  L41
- `int hashCode()`  L52
- `String toString()`  L56
    - 体内字面量："LocationInfo(areaAddress=" · ", code=" · ")"
- `public LocationInfo(String areaAddress, String code)`  L60
    - 体内字面量："areaAddress" · "code"
- `String getAreaAddress()`  L67
- `String getCode()`  L71
### `com.tuwinsmart.tuwin.domain.model.M3ConnectionResult`
L12 · [class] public final M3ConnectionResult · `com/tuwinsmart/tuwin/domain/model/M3ConnectionResult.java`
注解：

字段/常量（8）：
- `M3DeviceInfo deviceInfo`  L13
- `String transport`  L16
- `String rtspUrl`  L17
- `boolean socketConnected`  L18
- `int socketPort`  L19
- `int i3 = i`  L28
- `String str3 = str`  L32
- `String str4 = str2`  L36

方法（16）：
- `M3ConnectionResult copy$default(M3ConnectionResult m3ConnectionResult, M3DeviceInfo m3DeviceInfo, int i, String str, String str2, boolean z, int i2, Object obj)`  L21
- `M3DeviceInfo getDeviceInfo()`  L44
- `int getSocketPort()`  L49
- `String getRtspUrl()`  L54
- `String getTransport()`  L59
- `boolean getSocketConnected()`  L64
- `M3ConnectionResult copy(M3DeviceInfo deviceInfo, int socketPort, String rtspUrl, String rtspTransport, boolean socketConnected)`  L68
    - 体内字面量："deviceInfo" · "rtspUrl" · "rtspTransport"
- `boolean equals(Object other)`  L75
- `int hashCode()`  L86
- `public M3ConnectionResult(M3DeviceInfo deviceInfo, int i, String rtspUrl, String rtspTransport, boolean z)`  L90
    - 体内字面量："deviceInfo" · "rtspUrl" · "rtspTransport"
- `M3DeviceInfo getDeviceInfo()`  L101
- `int getSocketPort()`  L105
- `String getRtspUrl()`  L109
- `String getRtspTransport()`  L113
- `boolean getSocketConnected()`  L117
- `String toString()`  L121
    - 体内字面量："M3ConnectionResult(device=" · ", port=" · ", rtsp=" · ", transport=" · ", socketConnected=" · ")"
### `com.tuwinsmart.tuwin.domain.model.M3DeviceAttr`
L12 · [class] public final M3DeviceAttr · `com/tuwinsmart/tuwin/domain/model/M3DeviceAttr.java`
注解：

字段/常量（8）：
- `String hwver`  L13
- `String otaver`  L14
- `String softver`  L15
- `String ssid`  L16
- `String uuid`  L17
- `String str6 = str2`  L26
- `String str7 = str3`  L30
- `String str8 = str4`  L34

方法（17）：
- `M3DeviceAttr copy$default(M3DeviceAttr m3DeviceAttr, String str, String str2, String str3, String str4, String str5, int i, Object obj)`  L19
- `String getUuid()`  L42
- `String getSoftver()`  L47
- `String getHwver()`  L52
- `String getSsid()`  L57
- `String getOtaver()`  L62
- `M3DeviceAttr copy(String uuid, String softver, String hwver, String ssid, String otaver)`  L66
    - 体内字面量："uuid" · "softver" · "hwver" · "ssid" · "otaver"
- `boolean equals(Object other)`  L75
- `int hashCode()`  L86
- `String toString()`  L90
    - 体内字面量："M3DeviceAttr(uuid=" · ", softver=" · ", hwver=" · ", ssid=" · ", otaver=" · ")"
- `public M3DeviceAttr(String uuid, String softver, String hwver, String ssid, String otaver)`  L94
    - 体内字面量："uuid" · "softver" · "hwver" · "ssid" · "otaver"
- `String getUuid()`  L107
- `String getSoftver()`  L111
- `String getHwver()`  L115
- `String getSsid()`  L119
- ` M3DeviceAttr(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker)`  L123
- `String getOtaver()`  L127
### `com.tuwinsmart.tuwin.domain.model.RecordingControlAction`
L11 · [enum] public RecordingControlAction · `com/tuwinsmart/tuwin/domain/model/RecordingControlAction.java`
注解：

枚举常量（3）：
- `STARTED()`  L12
- `STOPPED()`  L13
- `PLAYBACK_MODE_ENTERED()`  L14

方法（1）：
- `EnumEntries<RecordingControlAction> getEntries()`  L18
### `com.tuwinsmart.tuwin.domain.model.RecordingControlDevice`
L18 · [class] public final RecordingControlDevice · `com/tuwinsmart/tuwin/domain/model/RecordingControlDevice.java`
注解：

字段/常量（4）：
- `Set<String> aliases`  L22
- `String deviceId`  L23
- `DeviceType deviceType`  L24
- `String sessionId`  L25

方法（15）：
- `RecordingControlDevice copy$default(RecordingControlDevice recordingControlDevice, DeviceType deviceType, String str, String str2, Set set, int i, Object obj)`  L28
- `DeviceType getDeviceType()`  L45
- `String getDeviceId()`  L50
- `String getSessionId()`  L55
- `Set<String> component4()`  L59
- `RecordingControlDevice copy(DeviceType deviceType, String deviceId, String sessionId, Set<String> aliases)`  L63
    - 体内字面量："deviceType" · "deviceId" · "sessionId" · "aliases"
- `boolean equals(Object other)`  L71
- `int hashCode()`  L82
- `String toString()`  L86
    - 体内字面量："RecordingControlDevice(deviceType=" · ", deviceId=" · ", sessionId=" · ", aliases=" · ")"
- `public RecordingControlDevice(DeviceType deviceType, String deviceId, String sessionId, Set<String> aliases)`  L90
    - 体内字面量："deviceType" · "deviceId" · "sessionId" · "aliases" · "recording control deviceId must not be blank" · "recording control sessionId must not be blank"
- `DeviceType getDeviceType()`  L107
- `String getDeviceId()`  L111
- `String getSessionId()`  L115
- ` RecordingControlDevice(DeviceType deviceType, String str, String str2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker)`  L119
- `Set<String> getAliases()`  L123
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/model/RecordingControlDevice$Companion;" · "()V" · "resolve" · "Lcom/tuwinsmart/tuwin/domain/model/RecordingControlDevice;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "sessionId" · "serial" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.model.RecordingControlDevice$Companion`
L129 · [class] public static final Companion · `com/tuwinsmart/tuwin/domain/model/RecordingControlDevice.java`
注解：

字段/常量（9）：
- `String string`  L139
- `String str`  L140
- `String strRemovePrefix`  L141
- `String strReplace$default`  L142
- `String string2`  L143
- `String upperCase = null`  L146
- `Locale ROOT = Locale.ROOT`  L153
- `String str2 = "session:" + sessionId`  L177
- `Locale ROOT2 = Locale.ROOT`  L179

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L130
- `private Companion()`  L134
- `RecordingControlDevice resolve(DeviceType deviceType, String sessionId, String serial, String bssid)`  L138
### `com.tuwinsmart.tuwin.domain.model.RecordingControlEvent`
L12 · [class] public final RecordingControlEvent · `com/tuwinsmart/tuwin/domain/model/RecordingControlEvent.java`
注解：

字段/常量（8）：
- `RecordingControlAction action`  L13
- `String deviceId`  L14
- `DeviceType deviceType`  L15
- `long occurredAtEpochMillis`  L16
- `String sessionId`  L17
- `String str3 = str`  L26
- `String str4 = str2`  L30
- `RecordingControlAction recordingControlAction2 = recordingControlAction`  L34

方法（17）：
- `RecordingControlEvent copy$default(RecordingControlEvent recordingControlEvent, DeviceType deviceType, String str, String str2, RecordingControlAction recordingControlAction, long j, int i, Object obj)`  L19
- `DeviceType getDeviceType()`  L42
- `String getDeviceId()`  L47
- `String getSessionId()`  L52
- `RecordingControlAction getAction()`  L57
- `long getOccurredAtEpochMillis()`  L62
- `RecordingControlEvent copy(DeviceType deviceType, String deviceId, String sessionId, RecordingControlAction action, long occurredAtEpochMillis)`  L66
    - 体内字面量："deviceType" · "deviceId" · "sessionId" · "action"
- `boolean equals(Object other)`  L74
- `int hashCode()`  L85
- `String toString()`  L89
    - 体内字面量："RecordingControlEvent(deviceType=" · ", deviceId=" · ", sessionId=" · ", action=" · ", occurredAtEpochMillis=" · ")"
- `public RecordingControlEvent(DeviceType deviceType, String deviceId, String sessionId, RecordingControlAction action, long j)`  L93
    - 体内字面量："deviceType" · "deviceId" · "sessionId" · "action" · "recording control event deviceId must not be blank" · "recording control event sessionId must not be blank" · "recording control event time must not be negative"
- `DeviceType getDeviceType()`  L114
- `String getDeviceId()`  L118
- `String getSessionId()`  L122
- `RecordingControlAction getAction()`  L126
- `long getOccurredAtEpochMillis()`  L130
- `boolean belongsTo(RecordingControlDevice device)`  L134
    - 体内字面量："device"
### `com.tuwinsmart.tuwin.domain.model.RecordingControlHourRange`
L15 · [class] public final RecordingControlHourRange · `com/tuwinsmart/tuwin/domain/model/RecordingControlHourRange.java`
注解：

字段/常量（2）：
- `long from`  L19
- `long until`  L20

方法（10）：
- `RecordingControlHourRange copy$default(RecordingControlHourRange recordingControlHourRange, long j, long j2, int i, Object obj)`  L22
- `long getFrom()`  L33
- `long getUntil()`  L38
- `RecordingControlHourRange copy(long from, long until)`  L42
- `boolean equals(Object other)`  L46
- `int hashCode()`  L57
- `String toString()`  L61
    - 体内字面量："RecordingControlHourRange(from=" · ", until=" · ")" · "Lcom/tuwinsmart/tuwin/domain/model/RecordingControlHourRange$Companion;" · "()V" · "forTimestamp" · "Lcom/tuwinsmart/tuwin/domain/model/RecordingControlHourRange;" · "timeZone" · "Ljava/util/TimeZone;" · "app_release_64"
- `public RecordingControlHourRange(long j, long j2)`  L96
- `long getFrom()`  L101
- `long getUntil()`  L105
### `com.tuwinsmart.tuwin.domain.model.RecordingControlHourRange$Companion`
L67 · [class] public static final Companion · `com/tuwinsmart/tuwin/domain/model/RecordingControlHourRange.java`
注解：

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L68
- `private Companion()`  L72
- `RecordingControlHourRange forTimestamp$default(Companion companion, long j, TimeZone timeZone, int i, Object obj)`  L75
    - 体内字面量："getDefault(...)"
- `RecordingControlHourRange forTimestamp(long timestamp, TimeZone timeZone)`  L83
    - 体内字面量："timeZone"
### `com.tuwinsmart.tuwin.domain.model.Ride3ProDayGroup`
L14 · [class] public final Ride3ProDayGroup · `com/tuwinsmart/tuwin/domain/model/Ride3ProDayGroup.java`
注解：

字段/常量（9）：
- `int date`  L15
- `List<Ride3ProHourGroup> hours`  L16
- `int lastFileIndex`  L17
- `Ride3ProGroupLoadState loadState`  L18
- `Integer reportedFileCount`  L19
- `Integer num2 = num`  L29
- `int i4 = i2`  L33
- `List list2 = list`  L37
- `Integer num = this.reportedFileCount`  L87

方法（17）：
- `Ride3ProDayGroup copy$default(Ride3ProDayGroup ride3ProDayGroup, int i, Integer num, int i2, List list, Ride3ProGroupLoadState ride3ProGroupLoadState, int i3, Object obj)`  L22
- `int getDate()`  L45
- `Integer getReportedFileCount()`  L50
- `int getLastFileIndex()`  L55
- `List<Ride3ProHourGroup> component4()`  L59
- `Ride3ProGroupLoadState getLoadState()`  L64
- `Ride3ProDayGroup copy(int date, Integer reportedFileCount, int lastFileIndex, List<Ride3ProHourGroup> hours, Ride3ProGroupLoadState loadState)`  L68
    - 体内字面量："hours" · "loadState"
- `boolean equals(Object other)`  L74
- `int hashCode()`  L85
- `String toString()`  L91
    - 体内字面量："Ride3ProDayGroup(date=" · ", reportedFileCount=" · ", lastFileIndex=" · ", hours=" · ", loadState=" · ")"
- `public Ride3ProDayGroup(int i, Integer num, int i2, List<Ride3ProHourGroup> hours, Ride3ProGroupLoadState loadState)`  L95
    - 体内字面量："hours" · "loadState"
- `int getDate()`  L105
- `Integer getReportedFileCount()`  L109
- `int getLastFileIndex()`  L113
- ` Ride3ProDayGroup(int i, Integer num, int i2, List list, Ride3ProGroupLoadState ride3ProGroupLoadState, int i3, DefaultConstructorMarker defaultConstructorMarker)`  L117
- `List<Ride3ProHourGroup> getHours()`  L121
- `Ride3ProGroupLoadState getLoadState()`  L125
### `com.tuwinsmart.tuwin.domain.model.Ride3ProDeviceAttr`
L14 · [class] public final Ride3ProDeviceAttr · `com/tuwinsmart/tuwin/domain/model/Ride3ProDeviceAttr.java`
注解：

字段/常量（9）：
- `Set<String> features`  L15
- `String hwver`  L16
- `String mac`  L17
- `String model`  L18
- `String pwd`  L19
- `String ssid`  L20
- `String swver`  L21
- `String uuid`  L22
- `String str = this.pwd`  L87

方法（22）：
- `String getModel()`  L25
- `String getHwver()`  L30
- `String getSwver()`  L35
- `String getUuid()`  L40
- `String getSsid()`  L45
- `String getMac()`  L50
- `String getPwd()`  L55
- `Set<String> component8()`  L59
- `Ride3ProDeviceAttr copy(String model, String hwver, String swver, String uuid, String ssid, String mac, String pwd, Set<String> features)`  L63
    - 体内字面量："model" · "hwver" · "swver" · "uuid" · "ssid" · "mac" · "features"
- `boolean equals(Object other)`  L74
- `int hashCode()`  L85
- `String toString()`  L91
    - 体内字面量："Ride3ProDeviceAttr(model=" · ", hwver=" · ", swver=" · ", uuid=" · ", ssid=" · ", mac=" · ", pwd=" · ", features=" · ")"
- `public Ride3ProDeviceAttr(String model, String hwver, String swver, String uuid, String ssid, String mac, String str, Set<String> features)`  L95
    - 体内字面量："model" · "hwver" · "swver" · "uuid" · "ssid" · "mac" · "features"
- `String getModel()`  L113
- `String getHwver()`  L117
- `String getSwver()`  L121
- `String getUuid()`  L125
- `String getSsid()`  L129
- `String getMac()`  L133
- `String getPwd()`  L137
- ` Ride3ProDeviceAttr(String str, String str2, String str3, String str4, String str5, String str6, String str7, Set set, int i, DefaultConstructorMarker defaultConstructorMarker)`  L141
- `Set<String> getFeatures()`  L145
### `com.tuwinsmart.tuwin.domain.model.Ride3ProGroupLoadState`
L11 · [enum] public Ride3ProGroupLoadState · `com/tuwinsmart/tuwin/domain/model/Ride3ProGroupLoadState.java`
注解：

枚举常量（4）：
- `NOT_LOADED()`  L12
- `LOADING()`  L13
- `LOADED()`  L14
- `FAILED()`  L15

方法（1）：
- `EnumEntries<Ride3ProGroupLoadState> getEntries()`  L19
### `com.tuwinsmart.tuwin.domain.model.Ride3ProHourGroup`
L13 · [class] public final Ride3ProHourGroup · `com/tuwinsmart/tuwin/domain/model/Ride3ProHourGroup.java`
注解：

字段/常量（10）：
- `List<Ride3ProPlaybackFile> files`  L14
- `Ride3ProHourKey key`  L15
- `int lastFileIndex`  L16
- `Ride3ProGroupLoadState loadState`  L17
- `Integer reportedFileCount`  L18
- `Integer num2 = num`  L28
- `int i3 = i`  L32
- `List list2 = list`  L36
- `Integer num = this.reportedFileCount`  L86
- `List<Ride3ProPlaybackFile> list = this.files`  L88

方法（17）：
- `Ride3ProHourGroup copy$default(Ride3ProHourGroup ride3ProHourGroup, Ride3ProHourKey ride3ProHourKey, Integer num, int i, List list, Ride3ProGroupLoadState ride3ProGroupLoadState, int i2, Object obj)`  L21
- `Ride3ProHourKey getKey()`  L44
- `Integer getReportedFileCount()`  L49
- `int getLastFileIndex()`  L54
- `List<Ride3ProPlaybackFile> component4()`  L58
- `Ride3ProGroupLoadState getLoadState()`  L63
- `Ride3ProHourGroup copy(Ride3ProHourKey key, Integer reportedFileCount, int lastFileIndex, List<Ride3ProPlaybackFile> files, Ride3ProGroupLoadState loadState)`  L67
    - 体内字面量："key" · "loadState"
- `boolean equals(Object other)`  L73
- `int hashCode()`  L84
- `String toString()`  L92
    - 体内字面量："Ride3ProHourGroup(key=" · ", reportedFileCount=" · ", lastFileIndex=" · ", files=" · ", loadState=" · ")"
- `public Ride3ProHourGroup(Ride3ProHourKey key, Integer num, int i, List<Ride3ProPlaybackFile> list, Ride3ProGroupLoadState loadState)`  L96
    - 体内字面量："key" · "loadState"
- `Ride3ProHourKey getKey()`  L106
- `Integer getReportedFileCount()`  L110
- `int getLastFileIndex()`  L114
- `List<Ride3ProPlaybackFile> getFiles()`  L118
- ` Ride3ProHourGroup(Ride3ProHourKey ride3ProHourKey, Integer num, int i, List list, Ride3ProGroupLoadState ride3ProGroupLoadState, int i2, DefaultConstructorMarker defaultConstructorMarker)`  L122
- `Ride3ProGroupLoadState getLoadState()`  L126
### `com.tuwinsmart.tuwin.domain.model.Ride3ProHourKey`
L10 · [class] public final Ride3ProHourKey · `com/tuwinsmart/tuwin/domain/model/Ride3ProHourKey.java`
注解：

字段/常量（2）：
- `int date`  L11
- `int hour`  L12

方法（10）：
- `Ride3ProHourKey copy$default(Ride3ProHourKey ride3ProHourKey, int i, int i2, int i3, Object obj)`  L14
- `int getDate()`  L25
- `int getHour()`  L30
- `Ride3ProHourKey copy(int date, int hour)`  L34
- `boolean equals(Object other)`  L38
- `int hashCode()`  L49
- `String toString()`  L53
    - 体内字面量："Ride3ProHourKey(date=" · ", hour=" · ")"
- `public Ride3ProHourKey(int i, int i2)`  L57
- `int getDate()`  L62
- `int getHour()`  L66
### `com.tuwinsmart.tuwin.domain.model.Ride3ProPlaybackCatalog`
L11 · [class] public final Ride3ProPlaybackCatalog · `com/tuwinsmart/tuwin/domain/model/Ride3ProPlaybackCatalog.java`
注解：

字段/常量（3）：
- `List<Ride3ProDayGroup> days`  L12
- `Integer reportedTotalFileCount`  L13
- `Integer num = this.reportedTotalFileCount`  L52

方法（10）：
- `Ride3ProPlaybackCatalog copy$default(Ride3ProPlaybackCatalog ride3ProPlaybackCatalog, Integer num, List list, int i, Object obj)`  L16
- `Integer getReportedTotalFileCount()`  L27
- `List<Ride3ProDayGroup> component2()`  L31
- `Ride3ProPlaybackCatalog copy(Integer reportedTotalFileCount, List<Ride3ProDayGroup> days)`  L35
    - 体内字面量："days"
- `boolean equals(Object other)`  L40
- `int hashCode()`  L51
- `String toString()`  L56
    - 体内字面量："Ride3ProPlaybackCatalog(reportedTotalFileCount=" · ", days=" · ")"
- `public Ride3ProPlaybackCatalog(Integer num, List<Ride3ProDayGroup> days)`  L60
    - 体内字面量："days"
- `Integer getReportedTotalFileCount()`  L66
- `List<Ride3ProDayGroup> getDays()`  L70
### `com.tuwinsmart.tuwin.domain.model.Ride3ProPlaybackCatalogReducer`
L21 · [class] public final Ride3ProPlaybackCatalogReducer · `com/tuwinsmart/tuwin/domain/model/Ride3ProPlaybackCatalogReducer.java`
注解：

字段/常量（9）：
- `ArrayList arrayList2 = arrayList`  L110
- `ArrayList arrayList`  L125
- `ArrayList arrayList2`  L126
- `List<Ride3ProPlaybackFile> list = files`  L134
- `ArrayList arrayList4 = arrayList3`  L145
- `Ride3ProHourKey ride3ProHourKey = key`  L211
- `Function1<Ride3ProHourGroup, Ride3ProHourGroup> function1 = transform`  L212
- `Object next`  L226
- `Object next`  L244

方法（18）：
- `private Ride3ProPlaybackCatalogReducer()`  L24
- `Ride3ProPlaybackCatalog replaceDay(Ride3ProPlaybackCatalog catalog, Ride3ProDayGroup dayGroup)`  L27
    - 体内字面量："catalog" · "dayGroup"
- `int compare(T t, T t2)`  L41 @Override
- `Ride3ProPlaybackCatalog setDayLoadState(Ride3ProPlaybackCatalog catalog, int date, final Ride3ProGroupLoadState loadState)`  L47
    - 体内字面量："catalog" · "loadState"
- `Ride3ProDayGroup invoke(Ride3ProDayGroup day)`  L56 @Override
    - 体内字面量："day"
- `Ride3ProPlaybackCatalog setHourLoadState(Ride3ProPlaybackCatalog catalog, Ride3ProHourKey key, final Ride3ProGroupLoadState loadState)`  L63
    - 体内字面量："catalog" · "key" · "loadState"
- `Ride3ProHourGroup invoke(Ride3ProHourGroup hour)`  L73 @Override
    - 体内字面量："hour"
- `Ride3ProPlaybackCatalog setHourFiles(Ride3ProPlaybackCatalog catalog, Ride3ProHourKey key, final List<Ride3ProPlaybackFile> files)`  L80
    - 体内字面量："catalog" · "key" · "files"
- `Ride3ProHourGroup invoke(Ride3ProHourGroup hour)`  L91 @Override
    - 体内字面量："hour"
- `Ride3ProPlaybackCatalog removeHour(Ride3ProPlaybackCatalog catalog, Ride3ProHourKey key)`  L98
    - 体内字面量："catalog" · "key"
- `Ride3ProPlaybackCatalog removeHourFile(Ride3ProPlaybackCatalog catalog, Ride3ProHourKey key, int fileIndex)`  L124
- `Ride3ProPlaybackCatalog updateDay(Ride3ProPlaybackCatalog catalog, int date, Function1<? super Ride3ProDayGroup, Ride3ProDayGroup> transform)`  L194
- `Ride3ProPlaybackCatalog updateHour(Ride3ProPlaybackCatalog catalog, final Ride3ProHourKey key, final Function1<? super Ride3ProHourGroup, Ride3ProHourGroup> transform)`  L198
- `Ride3ProDayGroup invoke(Ride3ProDayGroup day)`  L207 @Override
    - 体内字面量："day"
- `Ride3ProDayGroup requireDay(Ride3ProPlaybackCatalog catalog, int date)`  L225
- `Ride3ProHourGroup requireHour(Ride3ProDayGroup day, Ride3ProHourKey key)`  L243
- `Ride3ProDayGroup snapshot(Ride3ProDayGroup day)`  L260
- `Integer decrementReportedCount(Integer count)`  L270
### `com.tuwinsmart.tuwin.domain.model.Ride3ProPlaybackFile`
L11 · [class] public final Ride3ProPlaybackFile · `com/tuwinsmart/tuwin/domain/model/Ride3ProPlaybackFile.java`
注解：

字段/常量（10）：
- `int durationSeconds`  L12
- `int fileIndex`  L13
- `String fileName`  L14
- `long fileSizeKb`  L15
- `String fileType`  L16
- `Ride3ProPlaybackTimestamp recordedAt`  L17
- `String str3 = str`  L26
- `String str4 = str2`  L30
- `Ride3ProPlaybackTimestamp ride3ProPlaybackTimestamp2 = ride3ProPlaybackTimestamp`  L34
- `long j2 = j`  L38

方法（18）：
- `Ride3ProPlaybackFile copy$default(Ride3ProPlaybackFile ride3ProPlaybackFile, int i, String str, String str2, Ride3ProPlaybackTimestamp ride3ProPlaybackTimestamp, long j, int i2, int i3, Object obj)`  L19
- `int getFileIndex()`  L46
- `String getFileName()`  L51
- `String getFileType()`  L56
- `Ride3ProPlaybackTimestamp getRecordedAt()`  L61
- `long getFileSizeKb()`  L66
- `int getDurationSeconds()`  L71
- `Ride3ProPlaybackFile copy(int fileIndex, String fileName, String fileType, Ride3ProPlaybackTimestamp recordedAt, long fileSizeKb, int durationSeconds)`  L75
    - 体内字面量："fileName" · "fileType" · "recordedAt"
- `boolean equals(Object other)`  L82
- `int hashCode()`  L93
- `String toString()`  L97
    - 体内字面量："Ride3ProPlaybackFile(fileIndex=" · ", fileName=" · ", fileType=" · ", recordedAt=" · ", fileSizeKb=" · ", durationSeconds=" · ")"
- `public Ride3ProPlaybackFile(int i, String fileName, String fileType, Ride3ProPlaybackTimestamp recordedAt, long j, int i2)`  L101
    - 体内字面量："fileName" · "fileType" · "recordedAt"
- `int getFileIndex()`  L113
- `String getFileName()`  L117
- `String getFileType()`  L121
- `Ride3ProPlaybackTimestamp getRecordedAt()`  L125
- `long getFileSizeKb()`  L129
- `int getDurationSeconds()`  L133
### `com.tuwinsmart.tuwin.domain.model.Ride3ProPlaybackTimestamp`
L12 · [class] public final Ride3ProPlaybackTimestamp · `com/tuwinsmart/tuwin/domain/model/Ride3ProPlaybackTimestamp.java`
注解：

字段/常量（15）：
- `int DAY_MODULUS = 100`  L14
- `int MAX_HOUR = 23`  L15
- `int MAX_MINUTE = 59`  L16
- `int MAX_YYYYMMDD = 99999999`  L17
- `int MIN_HOUR = 0`  L18
- `int MIN_MINUTE = 0`  L19
- `int MIN_YYYYMMDD = 10000000`  L20
- `int MONTH_DIVISOR = 100`  L21
- `int MONTH_MODULUS = 100`  L22
- `int YEAR_DIVISOR = 10000`  L23
- `int date`  L24
- `int hour`  L25
- `int minute`  L26
- `int i = value / YEAR_DIVISOR`  L108
- `int i3 = value % 100`  L110

方法（13）：
- `Ride3ProPlaybackTimestamp copy$default(Ride3ProPlaybackTimestamp ride3ProPlaybackTimestamp, int i, int i2, int i3, int i4, Object obj)`  L28
- `int getDate()`  L42
- `int getHour()`  L47
- `int getMinute()`  L52
- `Ride3ProPlaybackTimestamp copy(int date, int hour, int minute)`  L56
- `boolean equals(Object other)`  L60
- `int hashCode()`  L71
- `String toString()`  L75
    - 体内字面量："Ride3ProPlaybackTimestamp(date=" · ", hour=" · ", minute=" · ")"
- `public Ride3ProPlaybackTimestamp(int i, int i2, int i3)`  L79
    - 体内字面量："hour must be in 0..23: " · "minute must be in 0..59: "
- `int getDate()`  L92
- `int getHour()`  L96
- `int getMinute()`  L100
- `void requireValidDate(int value)`  L104
    - 体内字面量："date must be a valid YYYYMMDD date: "
### `com.tuwinsmart.tuwin.domain.model.Ride3ProPlaybackTimestamp$Companion`
L126 · [class] private static final Companion · `com/tuwinsmart/tuwin/domain/model/Ride3ProPlaybackTimestamp.java`
注解：

方法（2）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L127
- `private Companion()`  L131
### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5FileInfo`
L14 · [class] public final Ride5FileInfo · `com/tuwinsmart/tuwin/domain/model/ride5/Ride5FileInfo.java`
注解：

字段/常量（7）：
- `long MILLIS_PER_SECOND = 1000`  L18
- `long durationMillis`  L19
- `LoadState loadState`  L20
- `String path`  L21
- `long sizeBytes`  L22
- `long j3 = j`  L44
- `long j4 = j2`  L48

方法（15）：
- `Ride5FileInfo copy$default(Ride5FileInfo ride5FileInfo, String str, long j, long j2, LoadState loadState, int i, Object obj)`  L37
- `String getPath()`  L56
- `long getDurationMillis()`  L61
- `long getSizeBytes()`  L66
- `LoadState getLoadState()`  L71
- `Ride5FileInfo copy(String path, long durationMillis, long sizeBytes, LoadState loadState)`  L75
    - 体内字面量："path" · "loadState"
- `boolean equals(Object other)`  L81
- `int hashCode()`  L92
- `String toString()`  L96
    - 体内字面量："Ride5FileInfo(path=" · ", durationMillis=" · ", sizeBytes=" · ", loadState=" · ")"
- `public Ride5FileInfo(String path, long j, long j2, LoadState loadState)`  L100
    - 体内字面量："path" · "loadState"
- `String getPath()`  L109
- `long getDurationMillis()`  L113
- `long getSizeBytes()`  L117
- `LoadState getLoadState()`  L121
- `int getDurationSeconds()`  L125
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/model/ride5/Ride5FileInfo$Companion;" · "()V" · "MILLIS_PER_SECOND" · "failed" · "Lcom/tuwinsmart/tuwin/domain/model/ride5/Ride5FileInfo;" · "path" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5FileInfo$Companion`
L131 · [class] public static final Companion · `com/tuwinsmart/tuwin/domain/model/ride5/Ride5FileInfo.java`
注解：

方法（3）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L132
- `private Companion()`  L136
- `Ride5FileInfo failed(String path)`  L139
    - 体内字面量："path"
### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5FileInfo$LoadState`
L26 · [enum] public LoadState · `com/tuwinsmart/tuwin/domain/model/ride5/Ride5FileInfo.java`
注解：

枚举常量（2）：
- `OK()`  L27
- `FAILED()`  L28

方法（1）：
- `EnumEntries<LoadState> getEntries()`  L32
### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5HourPlaybackItem`
L10 · [class] public final Ride5HourPlaybackItem · `com/tuwinsmart/tuwin/domain/model/ride5/Ride5HourPlaybackItem.java`
注解：

字段/常量（6）：
- `long durationMillis`  L11
- `String relativePath`  L12
- `long startEpochMs`  L13
- `String thumbnailUrl`  L14
- `long j3 = j`  L23
- `long j4 = j2`  L27

方法（14）：
- `Ride5HourPlaybackItem copy$default(Ride5HourPlaybackItem ride5HourPlaybackItem, String str, long j, long j2, String str2, int i, Object obj)`  L16
- `String getRelativePath()`  L35
- `long getStartEpochMs()`  L40
- `long getDurationMillis()`  L45
- `String getThumbnailUrl()`  L50
- `Ride5HourPlaybackItem copy(String relativePath, long startEpochMs, long durationMillis, String thumbnailUrl)`  L54
    - 体内字面量："relativePath" · "thumbnailUrl"
- `boolean equals(Object other)`  L60
- `int hashCode()`  L71
- `String toString()`  L75
    - 体内字面量："Ride5HourPlaybackItem(relativePath=" · ", startEpochMs=" · ", durationMillis=" · ", thumbnailUrl=" · ")"
- `public Ride5HourPlaybackItem(String relativePath, long j, long j2, String thumbnailUrl)`  L79
    - 体内字面量："relativePath" · "thumbnailUrl"
- `String getRelativePath()`  L88
- `long getStartEpochMs()`  L92
- `long getDurationMillis()`  L96
- `String getThumbnailUrl()`  L100
### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5HourRecording`
L15 · [class] public final Ride5HourRecording · implements `Serializable` · `com/tuwinsmart/tuwin/domain/model/ride5/Ride5HourRecording.java`
注解：

字段/常量（9）：
- `int HOUR_SECONDS = 3600`  L16
- `int LAST_SECOND_OF_HOUR = 3599`  L17
- `int SECONDS_PER_MINUTE = 60`  L18
- `long durationMillis`  L19
- `Ride5FileInfo.LoadState infoLoadState`  L20
- `String relativePath`  L21
- `long startEpochMs`  L22
- `long j3 = j`  L31
- `long j4 = j2`  L35

方法（19）：
- `Ride5HourRecording copy$default(Ride5HourRecording ride5HourRecording, String str, long j, long j2, Ride5FileInfo.LoadState loadState, int i, Object obj)`  L24
- `String getRelativePath()`  L43
- `long getStartEpochMs()`  L48
- `long getDurationMillis()`  L53
- `Ride5FileInfo.LoadState getInfoLoadState()`  L58
- `Ride5HourRecording copy(String relativePath, long startEpochMs, long durationMillis, Ride5FileInfo.LoadState infoLoadState)`  L62
    - 体内字面量："relativePath" · "infoLoadState"
- `boolean equals(Object other)`  L68
- `int hashCode()`  L79
- `String toString()`  L83
    - 体内字面量："Ride5HourRecording(relativePath=" · ", startEpochMs=" · ", durationMillis=" · ", infoLoadState=" · ")"
- `public Ride5HourRecording(String relativePath, long j, long j2, Ride5FileInfo.LoadState infoLoadState)`  L87
    - 体内字面量："relativePath" · "infoLoadState"
- `String getRelativePath()`  L96
- `long getStartEpochMs()`  L100
- `long getDurationMillis()`  L104
- `Ride5FileInfo.LoadState getInfoLoadState()`  L108
- `int secondsInHour$default(Ride5HourRecording ride5HourRecording, TimeZone timeZone, int i, Object obj)`  L112
    - 体内字面量："getDefault(...)"
- `int secondsInHour(TimeZone timeZone)`  L120
    - 体内字面量："timeZone"
- `int endSecondsExclusive$default(Ride5HourRecording ride5HourRecording, TimeZone timeZone, int i, Object obj)`  L127
    - 体内字面量："getDefault(...)"
- `int endSecondsExclusive(TimeZone timeZone)`  L135
    - 体内字面量："timeZone"
- `int getDurationSeconds()`  L140
### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5HourRecordingSelection`
L12 · [class] public final Ride5HourRecordingSelection · `com/tuwinsmart/tuwin/domain/model/ride5/Ride5HourRecordingSelection.java`
注解：

字段/常量（5）：
- `int cardIndex`  L16
- `Integer emptyCardInsertionIndex`  L17
- `Integer videoIndex`  L18
- `Integer num = this.videoIndex`  L64
- `Integer num2 = this.emptyCardInsertionIndex`  L66

方法（12）：
- `Ride5HourRecordingSelection copy$default(Ride5HourRecordingSelection ride5HourRecordingSelection, Integer num, int i, Integer num2, int i2, Object obj)`  L20
- `Integer getVideoIndex()`  L34
- `int getCardIndex()`  L39
- `Integer getEmptyCardInsertionIndex()`  L44
- `Ride5HourRecordingSelection copy(Integer videoIndex, int cardIndex, Integer emptyCardInsertionIndex)`  L48
- `boolean equals(Object other)`  L52
- `int hashCode()`  L63
- `String toString()`  L70
    - 体内字面量："Ride5HourRecordingSelection(videoIndex=" · ", cardIndex=" · ", emptyCardInsertionIndex=" · ")"
- `public Ride5HourRecordingSelection(Integer num, int i, Integer num2)`  L74
    - 体内字面量："cardIndex must be >= 0 but was " · "videoIndex and emptyCardInsertionIndex must be mutually exclusive: videoIndex=" · ", emptyCardInsertionIndex=" · "cardIndex must equal videoIndex when a video is selected: videoIndex=" · ", cardIndex=" · "cardIndex must equal emptyCardInsertionIndex when empty: emptyCardInsertionIndex=" · ", cardIndex="
- `Integer getVideoIndex()`  L94
- `int getCardIndex()`  L98
- `Integer getEmptyCardInsertionIndex()`  L102
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/model/ride5/Ride5HourRecordingSelection$Companion;" · "()V" · "empty" · "Lcom/tuwinsmart/tuwin/domain/model/ride5/Ride5HourRecordingSelection;" · "insertionIndex" · "video" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5HourRecordingSelection$Companion`
L108 · [class] public static final Companion · `com/tuwinsmart/tuwin/domain/model/ride5/Ride5HourRecordingSelection.java`
注解：

方法（4）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L109
- `private Companion()`  L113
- `Ride5HourRecordingSelection video(int index)`  L116
- `Ride5HourRecordingSelection empty(int insertionIndex)`  L120
### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5HourTimelineFocus`
L10 · [class] public final Ride5HourTimelineFocus · `com/tuwinsmart/tuwin/domain/model/ride5/Ride5HourTimelineFocus.java`
注解：

字段/常量（2）：
- `int pointerSeconds`  L11
- `Ride5HourRecordingSelection selection`  L12

方法（10）：
- `Ride5HourTimelineFocus copy$default(Ride5HourTimelineFocus ride5HourTimelineFocus, int i, Ride5HourRecordingSelection ride5HourRecordingSelection, int i2, Object obj)`  L14
- `int getPointerSeconds()`  L25
- `Ride5HourRecordingSelection getSelection()`  L30
- `Ride5HourTimelineFocus copy(int pointerSeconds, Ride5HourRecordingSelection selection)`  L34
    - 体内字面量："selection"
- `boolean equals(Object other)`  L39
- `int hashCode()`  L50
- `String toString()`  L54
    - 体内字面量："Ride5HourTimelineFocus(pointerSeconds=" · ", selection=" · ")"
- `public Ride5HourTimelineFocus(int i, Ride5HourRecordingSelection selection)`  L58
    - 体内字面量："selection"
- `int getPointerSeconds()`  L64
- `Ride5HourRecordingSelection getSelection()`  L68
### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5HourTimelineSegment`
L9 · [class] public final Ride5HourTimelineSegment · `com/tuwinsmart/tuwin/domain/model/ride5/Ride5HourTimelineSegment.java`
注解：

字段/常量（2）：
- `int endSecondsExclusive`  L10
- `int startSeconds`  L11

方法（11）：
- `Ride5HourTimelineSegment copy$default(Ride5HourTimelineSegment ride5HourTimelineSegment, int i, int i2, int i3, Object obj)`  L13
- `int getStartSeconds()`  L24
- `int getEndSecondsExclusive()`  L29
- `Ride5HourTimelineSegment copy(int startSeconds, int endSecondsExclusive)`  L33
- `boolean equals(Object other)`  L37
- `int hashCode()`  L48
- `String toString()`  L52
    - 体内字面量："Ride5HourTimelineSegment(startSeconds=" · ", endSecondsExclusive=" · ")"
- `public Ride5HourTimelineSegment(int i, int i2)`  L56
    - 体内字面量："startSeconds out of range: " · "endSecondsExclusive out of range: " · "endSecondsExclusive must be > startSeconds: " · ".."
- `int getStartSeconds()`  L70
- `int getEndSecondsExclusive()`  L74
- `boolean contains(int seconds)`  L78
### `com.tuwinsmart.tuwin.domain.model.Ride5ProductPolicy`
L12 · [class] public final Ride5ProductPolicy · `com/tuwinsmart/tuwin/domain/model/Ride5ProductPolicy.java`
注解：

字段/常量（4）：
- `String upperCase`  L19
- `String string`  L20
- `Locale US = Locale.US`  L24
- `String str = upperCase`  L32

方法（2）：
- `private Ride5ProductPolicy()`  L15
- `boolean isRide5Pro(String product)`  L18
### `com.tuwinsmart.tuwin.domain.model.SdcardStatus`
L10 · [class] public final SdcardStatus · `com/tuwinsmart/tuwin/domain/model/SdcardStatus.java`
注解：

字段/常量（3）：
- `float free`  L11
- `String status`  L12
- `float total`  L13

方法（12）：
- `SdcardStatus copy$default(SdcardStatus sdcardStatus, float f, float f2, String str, int i, Object obj)`  L15
- `float getFree()`  L29
- `float getTotal()`  L34
- `String getStatus()`  L39
- `SdcardStatus copy(float free, float total, String status)`  L43
    - 体内字面量："status"
- `boolean equals(Object other)`  L48
- `int hashCode()`  L59
- `String toString()`  L63
    - 体内字面量："SdcardStatus(free=" · ", total=" · ", status=" · ")"
- `public SdcardStatus(float f, float f2, String status)`  L67
    - 体内字面量："status"
- `float getFree()`  L74
- `float getTotal()`  L78
- `String getStatus()`  L82
### `com.tuwinsmart.tuwin.domain.model.SessionBoundDeviceResolver`
L14 · [class] public final SessionBoundDeviceResolver · `com/tuwinsmart/tuwin/domain/model/SessionBoundDeviceResolver.java`
注解：

方法（2）：
- `private SessionBoundDeviceResolver()`  L17
- `ConnectedDevice resolve(String sessionId, DeviceType expectedDeviceType, List<ConnectedDevice> devices)`  L20
    - 体内字面量："sessionId" · "expectedDeviceType" · "devices"
### `com.tuwinsmart.tuwin.domain.repository.DevicePersistenceRepository`
L12 · [interface] public DevicePersistenceRepository · `com/tuwinsmart/tuwin/domain/repository/DevicePersistenceRepository.java`
注解：

方法（3）：
- `List<ConnectedDevice> deleteDevice(ConnectedDevice device)`  L13
- `List<ConnectedDevice> getSavedDevices()`  L15
- `Object saveDevice(ConnectedDevice connectedDevice, Continuation<? super List<ConnectedDevice>> continuation)`  L17
### `com.tuwinsmart.tuwin.domain.repository.DeviceRepository`
L13 · [interface] public DeviceRepository · extends `DevicePersistenceRepository, Ride5DeviceAttrRepository, M3DeviceAttrRepository, M3ConnectionMaintenanceRepository` · `com/tuwinsmart/tuwin/domain/repository/DeviceRepository.java`
注解：

方法（1）：
- `Observable<HashMap<String, String>> getDeviceAttributes()`  L15
### `com.tuwinsmart.tuwin.domain.repository.DeviceVersionRepository`
L11 · [interface] public DeviceVersionRepository · `com/tuwinsmart/tuwin/domain/repository/DeviceVersionRepository.java`
注解：

方法（4）：
- `void clearVersion(String deviceId)`  L12
- `Map<String, String> getAllVersions()`  L14
- `String getVersion(String deviceId)`  L16
- `void saveVersion(String deviceId, String version)`  L18
### `com.tuwinsmart.tuwin.domain.repository.M3ConnectionMaintenanceRepository`
L15 · [interface] public M3ConnectionMaintenanceRepository · `com/tuwinsmart/tuwin/domain/repository/M3ConnectionMaintenanceRepository.java`
注解：

方法（2）：
- `Object mo2776detectM3ConnectiongIAlus(Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Result<M3ConnectionResult>> continuation)`  L17
- `Object mo2779syncM3TimeIoAF18A(Continuation<? super Result<Unit>> continuation)`  L20
### `com.tuwinsmart.tuwin.domain.repository.M3ConnectionMaintenanceRepository$DefaultImpls`
L24 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/domain/repository/M3ConnectionMaintenanceRepository.java`
注解：

方法（1）：
- `Object m2873detectM3ConnectiongIAlus$default(M3ConnectionMaintenanceRepository m3ConnectionMaintenanceRepository, Function2 function2, Continuation continuation, int i, Object obj)`  L27
    - 体内字面量："Super calls with default arguments not supported in this target, function: detectM3Connection-gIAlu-s"
### `com.tuwinsmart.tuwin.domain.repository.M3ConnectionMaintenanceRepository$detectM3Connection$1`
L18 · [class] final M3ConnectionMaintenanceRepository$detectM3Connection$1 · extends `SuspendLambda implements Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · implements `Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/domain/repository/M3ConnectionMaintenanceRepository$detectM3Connection$1.java`
注解：

字段/常量（1）：
- `int label`  L19

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L26 @Override
- `Object invoke(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L31 @Override
- `Object invokeSuspend(Object obj)`  L36 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.domain.repository.M3DeviceAttrRepository`
L12 · [interface] public M3DeviceAttrRepository · `com/tuwinsmart/tuwin/domain/repository/M3DeviceAttrRepository.java`
注解：

方法（1）：
- `Object mo2777getM3DeviceAttrIoAF18A(Continuation<? super Result<M3DeviceAttr>> continuation)`  L14
### `com.tuwinsmart.tuwin.domain.repository.M3DeviceRepository`
L26 · [interface] public M3DeviceRepository · `com/tuwinsmart/tuwin/domain/repository/M3DeviceRepository.java`
注解：

方法（29）：
- `Object mo2780deleteFilegIAlus(String str, Continuation<? super Result<Unit>> continuation)`  L28
- `Object mo2781factoryResetIoAF18A(Continuation<? super Result<Unit>> continuation)`  L31
- `Object mo2782formatSdCardIoAF18A(Continuation<? super Result<Unit>> continuation)`  L34
- `Object mo2783getBatteryInfoIoAF18A(Continuation<? super Result<M3BatteryInfo>> continuation)`  L37
- `Object mo2784getCurrentModeIoAF18A(Continuation<? super Result<Integer>> continuation)`  L40
- `Object mo2785getDeviceAttrIoAF18A(Continuation<? super Result<M3DeviceAttr>> continuation)`  L43
- `Object mo2786getFileListIoAF18A(Continuation<? super Result<M3FileListResponse>> continuation)`  L46
- `Object mo2787getGravityDirectionIoAF18A(Continuation<? super Result<Integer>> continuation)`  L49
- `Object mo2788getMediaInfoIoAF18A(Continuation<? super Result<M3MediaInfo>> continuation)`  L52
- `Object mo2789getParamItemValuegIAlus(String str, Continuation<? super Result<String>> continuation)`  L55
- `Object mo2790getParamItemsByModegIAlus(int i, Continuation<? super Result<? extends List<M3ParamItem>>> continuation)`  L58
- `Object mo2791getSDInfoIoAF18A(Continuation<? super Result<M3SDInfo>> continuation)`  L61
- `Object mo2792getThumbnailgIAlus(String str, Continuation<? super Result<Bitmap>> continuation)`  L64
- `Flow<M3BatteryInfo> observeBatteryUpdates()`  L66
- `Flow<Unit> observeCaptureUpdates()`  L68
- `Flow<Integer> observeCountdownTimeUpdates()`  L70
- `Flow<M3RecordingTimeUpdate> observeRecordingTimeUpdates()`  L72
- `Flow<Boolean> observeRecordingUpdates()`  L74
- `Flow<Integer> observeSDCardUpdates()`  L76
- `Object mo2793setMenuModegIAlus(String str, Continuation<? super Result<Unit>> continuation)`  L79
- `Object mo2794setModegIAlus(int i, Continuation<? super Result<Unit>> continuation)`  L82
- `Object mo2795setParamValue0E7RQCE(String str, int i, Continuation<? super Result<Unit>> continuation)`  L85
- `Object mo2796setPlaybackModegIAlus(String str, Continuation<? super Result<Unit>> continuation)`  L88
- `Object mo2797setRecordinggIAlus(int i, Continuation<? super Result<Unit>> continuation)`  L91
- `Object mo2798setWifiPasswordgIAlus(String str, Continuation<? super Result<Unit>> continuation)`  L94
- `Object mo2799setWifiSsidgIAlus(String str, Continuation<? super Result<Unit>> continuation)`  L97
- `Object mo2800syncDeviceTime0E7RQCE(String str, int i, Continuation<? super Result<Unit>> continuation)`  L100
- `Object mo2801takePhotogIAlus(int i, Continuation<? super Result<Unit>> continuation)`  L103
- `Object mo2802uploadFirmwareBWLJW6A(Uri uri, long j, Function2<? super Long, ? super Long, Unit> function2, Continuation<? super Result<Unit>> continuation)`  L106
### `com.tuwinsmart.tuwin.domain.repository.M3DeviceRepository$DefaultImpls`
L110 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/domain/repository/M3DeviceRepository.java`
注解：

方法（4）：
- `Object m2874takePhotogIAlus$default(M3DeviceRepository m3DeviceRepository, int i, Continuation continuation, int i2, Object obj)`  L112
    - 体内字面量："Super calls with default arguments not supported in this target, function: takePhoto-gIAlu-s"
- `Object m2875uploadFirmwareBWLJW6A$default(M3DeviceRepository m3DeviceRepository, Uri uri, long j, Function2 function2, Continuation continuation, int i, Object obj)`  L124
    - 体内字面量："Super calls with default arguments not supported in this target, function: uploadFirmware-BWLJW6A"
- `void invoke(long j2, long j3)`  L130
- `Unit invoke(Long l, Long l2)`  L134 @Override
### `com.tuwinsmart.tuwin.domain.repository.M3RecordingTimeUpdate`
L9 · [class] public final M3RecordingTimeUpdate · `com/tuwinsmart/tuwin/domain/repository/M3RecordingTimeUpdate.java`
注解：

字段/常量（3）：
- `long eventTimeSeconds`  L10
- `int fileSeconds`  L11
- `int recordingSeconds`  L12

方法（12）：
- `M3RecordingTimeUpdate copy$default(M3RecordingTimeUpdate m3RecordingTimeUpdate, int i, int i2, long j, int i3, Object obj)`  L14
- `int getRecordingSeconds()`  L28
- `int getFileSeconds()`  L33
- `long getEventTimeSeconds()`  L38
- `M3RecordingTimeUpdate copy(int recordingSeconds, int fileSeconds, long eventTimeSeconds)`  L42
- `boolean equals(Object other)`  L46
- `int hashCode()`  L57
- `String toString()`  L61
    - 体内字面量："M3RecordingTimeUpdate(recordingSeconds=" · ", fileSeconds=" · ", eventTimeSeconds=" · ")"
- `public M3RecordingTimeUpdate(int i, int i2, long j)`  L65
- `int getRecordingSeconds()`  L71
- `int getFileSeconds()`  L75
- `long getEventTimeSeconds()`  L79
### `com.tuwinsmart.tuwin.domain.repository.RecordingControlEventRepository`
L18 · [interface] public RecordingControlEventRepository · `com/tuwinsmart/tuwin/domain/repository/RecordingControlEventRepository.java`
注解：

方法（3）：
- `Object mo2803appendgIAlus(RecordingControlEvent recordingControlEvent, Continuation<? super Result<Unit>> continuation)`  L20
- `Object mo2804eventsForBWLJW6A(RecordingControlDevice recordingControlDevice, long j, long j2, Continuation<? super Result<? extends List<RecordingControlEvent>>> continuation)`  L23
- `Flow<Result<List<RecordingControlEvent>>> observeEventsFor(RecordingControlDevice device, long fromEpochMillisInclusive, long untilEpochMillisExclusive)`  L25
### `com.tuwinsmart.tuwin.domain.repository.Ride3ProConnectionSnapshot`
L11 · [class] public final Ride3ProConnectionSnapshot · `com/tuwinsmart/tuwin/domain/repository/Ride3ProConnectionSnapshot.java`
注解：

字段/常量（19）：
- `Integer adapterStatus`  L12
- `Long authKey`  L13
- `Integer batteryPercent`  L14
- `Integer currentMode`  L15
- `Integer exceptionFlags`  L16
- `Integer hdrChkCnt`  L17
- `Long rtspKey`  L18
- `Long l3 = l`  L27
- `Long l4 = l2`  L31
- `Integer num6 = num2`  L35
- `Integer num7 = num3`  L39
- `Integer num8 = num4`  L43
- `Integer num = this.currentMode`  L101
- `Long l = this.authKey`  L103
- `Long l2 = this.rtspKey`  L105
- `Integer num2 = this.batteryPercent`  L107
- `Integer num3 = this.adapterStatus`  L109
- `Integer num4 = this.exceptionFlags`  L111
- `Integer num5 = this.hdrChkCnt`  L113

方法（21）：
- `Ride3ProConnectionSnapshot copy$default(Ride3ProConnectionSnapshot ride3ProConnectionSnapshot, Integer num, Long l, Long l2, Integer num2, Integer num3, Integer num4, Integer num5, int i, Object obj)`  L20
- `Integer getCurrentMode()`  L51
- `Long getAuthKey()`  L56
- `Long getRtspKey()`  L61
- `Integer getBatteryPercent()`  L66
- `Integer getAdapterStatus()`  L71
- `Integer getExceptionFlags()`  L76
- `Integer getHdrChkCnt()`  L81
- `Ride3ProConnectionSnapshot copy(Integer currentMode, Long authKey, Long rtspKey, Integer batteryPercent, Integer adapterStatus, Integer exceptionFlags, Integer hdrChkCnt)`  L85
- `boolean equals(Object other)`  L89
- `int hashCode()`  L100
- `String toString()`  L117
    - 体内字面量："Ride3ProConnectionSnapshot(currentMode=" · ", authKey=" · ", rtspKey=" · ", batteryPercent=" · ", adapterStatus=" · ", exceptionFlags=" · ", hdrChkCnt=" · ")"
- `public Ride3ProConnectionSnapshot(Integer num, Long l, Long l2, Integer num2, Integer num3, Integer num4, Integer num5)`  L121
- ` Ride3ProConnectionSnapshot(Integer num, Long l, Long l2, Integer num2, Integer num3, Integer num4, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker)`  L131
- `Integer getCurrentMode()`  L135
- `Long getAuthKey()`  L139
- `Long getRtspKey()`  L143
- `Integer getBatteryPercent()`  L147
- `Integer getAdapterStatus()`  L151
- `Integer getExceptionFlags()`  L155
- `Integer getHdrChkCnt()`  L159
### `com.tuwinsmart.tuwin.domain.repository.Ride3ProDeviceRepository`
L20 · [interface] public Ride3ProDeviceRepository · `com/tuwinsmart/tuwin/domain/repository/Ride3ProDeviceRepository.java`
注解：

字段/常量（6）：
- `Companion INSTANCE = Companion.$$INSTANCE`  L23
- `String TODO_API_RIDE3PRO_FACTORY_RESET = "TODO_API_RIDE3PRO_FACTORY_RESET"`  L24
- `String TODO_API_RIDE3PRO_FORMAT_SD_CARD = "TODO_API_RIDE3PRO_FORMAT_SD_CARD"`  L25
- `String TODO_API_RIDE3PRO_GET_BATTERY_INFO = "TODO_API_RIDE3PRO_GET_BATTERY_INFO"`  L26
- `String TODO_API_RIDE3PRO_GET_MEDIA_INFO = "TODO_API_RIDE3PRO_GET_MEDIA_INFO"`  L27
- `String TODO_API_RIDE3PRO_GET_SD_INFO = "TODO_API_RIDE3PRO_GET_SD_INFO"`  L28

方法（11）：
- `Object mo2807detectConnection0E7RQCE(Network network, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Result<Ride3ProConnectionSnapshot>> continuation)`  L31
- `Object mo2808detectConnectionLightweightgIAlus(Network network, Continuation<? super Result<Ride3ProConnectionSnapshot>> continuation)`  L34
- `Object mo2809factoryResetIoAF18A(Continuation<? super Result<Unit>> continuation)`  L37
- `Object mo2810formatSdCardIoAF18A(Continuation<? super Result<Unit>> continuation)`  L40
- `Object mo2811getBatteryInfoIoAF18A(Continuation<? super Result<Ride3ProDeviceStatusInfo>> continuation)`  L43
- `Object mo2812getDeviceStatusIoAF18A(Continuation<? super Result<Ride3ProDeviceStatusInfo>> continuation)`  L46
- `Object mo2813getMediaInfoIoAF18A(Continuation<? super Result<Unit>> continuation)`  L49
- `Object mo2814getRide3ProDeviceAttrIoAF18A(Continuation<? super Result<Ride3ProDeviceAttr>> continuation)`  L52
- `Object mo2815getSDInfoIoAF18A(Continuation<? super Result<Ride3ProSdInfo>> continuation)`  L55
- `Object mo2816rebootIoAF18A(Continuation<? super Result<Unit>> continuation)`  L58
- `Object mo2817setWifiPasswordgIAlus(String str, Continuation<? super Result<Unit>> continuation)`  L61
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/repository/Ride3ProDeviceRepository$Companion;" · "()V" · "TODO_API_RIDE3PRO_FACTORY_RESET" · "TODO_API_RIDE3PRO_FORMAT_SD_CARD" · "TODO_API_RIDE3PRO_GET_BATTERY_INFO" · "getTODO_API_RIDE3PRO_GET_BATTERY_INFO$annotations" · "TODO_API_RIDE3PRO_GET_MEDIA_INFO" · "getTODO_API_RIDE3PRO_GET_MEDIA_INFO$annotations" · "TODO_API_RIDE3PRO_GET_SD_INFO" · "getTODO_API_RIDE3PRO_GET_SD_INFO$annotations" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.repository.Ride3ProDeviceRepository$Companion`
L95 · [class] public static final Companion · `com/tuwinsmart/tuwin/domain/repository/Ride3ProDeviceRepository.java`
注解：

字段/常量（5）：
- `String TODO_API_RIDE3PRO_FACTORY_RESET = "TODO_API_RIDE3PRO_FACTORY_RESET"`  L97
- `String TODO_API_RIDE3PRO_FORMAT_SD_CARD = "TODO_API_RIDE3PRO_FORMAT_SD_CARD"`  L98
- `String TODO_API_RIDE3PRO_GET_BATTERY_INFO = "TODO_API_RIDE3PRO_GET_BATTERY_INFO"`  L99
- `String TODO_API_RIDE3PRO_GET_MEDIA_INFO = "TODO_API_RIDE3PRO_GET_MEDIA_INFO"`  L100
- `String TODO_API_RIDE3PRO_GET_SD_INFO = "TODO_API_RIDE3PRO_GET_SD_INFO"`  L101

方法（4）：
- `void getTODO_API_RIDE3PRO_GET_BATTERY_INFO$annotations()`  L104 @Deprecated(message = "ä»ä¿çç»è¿ç§»æè°ç¨æ¹è¯å«ï¼ä¸ä»£è¡¨è¿è¡æ¶ TODO")
    - 体内字面量："åè®®å°æªç¡®è®¤"
- `void getTODO_API_RIDE3PRO_GET_MEDIA_INFO$annotations()`  L108 @Deprecated(message = "åè®®å°æªç¡®è®¤")
    - 体内字面量："ä»ä¿çç»è¿ç§»æè°ç¨æ¹è¯å«ï¼ä¸ä»£è¡¨è¿è¡æ¶ TODO"
- `void getTODO_API_RIDE3PRO_GET_SD_INFO$annotations()`  L112 @Deprecated(message = "ä»ä¿çç»è¿ç§»æè°ç¨æ¹è¯å«ï¼ä¸ä»£è¡¨è¿è¡æ¶ TODO")
- `private Companion()`  L115
### `com.tuwinsmart.tuwin.domain.repository.Ride3ProDeviceRepository$DefaultImpls`
L65 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/domain/repository/Ride3ProDeviceRepository.java`
注解：

方法（2）：
- `Object m2876detectConnection0E7RQCE$default(Ride3ProDeviceRepository ride3ProDeviceRepository, Network network, Function2 function2, Continuation continuation, int i, Object obj)`  L68
    - 体内字面量："Super calls with default arguments not supported in this target, function: detectConnection-0E7RQCE"
- `Object m2877detectConnectionLightweightgIAlus$default(Ride3ProDeviceRepository ride3ProDeviceRepository, Network network, Continuation continuation, int i, Object obj)`  L82
    - 体内字面量："Super calls with default arguments not supported in this target, function: detectConnectionLightweight-gIAlu-s"
### `com.tuwinsmart.tuwin.domain.repository.Ride3ProDeviceRepository$detectConnection$1`
L18 · [class] final Ride3ProDeviceRepository$detectConnection$1 · extends `SuspendLambda implements Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · implements `Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/domain/repository/Ride3ProDeviceRepository$detectConnection$1.java`
注解：

字段/常量（1）：
- `int label`  L19

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L26 @Override
- `Object invoke(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L31 @Override
- `Object invokeSuspend(Object obj)`  L36 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.domain.repository.Ride5DeviceAttrRepository`
L12 · [interface] public Ride5DeviceAttrRepository · `com/tuwinsmart/tuwin/domain/repository/Ride5DeviceAttrRepository.java`
注解：

方法（1）：
- `Object mo2778getRide5DeviceAttrIoAF18A(Continuation<? super Result<? extends HashMap<String, String>>> continuation)`  L14
### `com.tuwinsmart.tuwin.domain.repository.SdCardFormatReminderRepository`
L9 · [interface] public SdCardFormatReminderRepository · `com/tuwinsmart/tuwin/domain/repository/SdCardFormatReminderRepository.java`
注解：

方法（2）：
- `Long getReminderStartMillis(String deviceKey)`  L10
- `void saveReminderStartMillis(String deviceKey, long timestampMillis)`  L12
### `com.tuwinsmart.tuwin.domain.strategy.ConnectionCheckMode`
L11 · [enum] public ConnectionCheckMode · `com/tuwinsmart/tuwin/domain/strategy/ConnectionCheckMode.java`
注解：

枚举常量（2）：
- `FULL()`  L12
- `LIGHTWEIGHT_REFRESH()`  L13

方法（1）：
- `EnumEntries<ConnectionCheckMode> getEntries()`  L17
### `com.tuwinsmart.tuwin.domain.strategy.ConnectionResult`
L15 · [class] public abstract ConnectionResult · `com/tuwinsmart/tuwin/domain/strategy/ConnectionResult.java`
注解：

方法（2）：
- ` ConnectionResult(DefaultConstructorMarker defaultConstructorMarker)`  L16
- `private ConnectionResult()`  L20
    - 体内字面量："Lcom/tuwinsmart/tuwin/domain/strategy/ConnectionResult$Success;" · "Lcom/tuwinsmart/tuwin/domain/strategy/ConnectionResult;" · "device" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectedDevice;" · "Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "(Ljava/lang/String;Lcom/tuwinsmart/tuwin/domain/model/ConnectedDevice;Lcom/tuwinsmart/tuwin/domain/model/DeviceType;)V" · "getDevice" · "()Lcom/tuwinsmart/tuwin/domain/model/ConnectedDevice;" · "getDeviceType" · "()Lcom/tuwinsmart/tuwin/domain/model/DeviceType;" · "getSsid" · "()Ljava/lang/String;" · "component1" · "component2" · "component3" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/strategy/ConnectionResult$Failure;" · "Lcom/tuwinsmart/tuwin/domain/strategy/ConnectionResult;" · "reason" · "(Ljava/lang/String;)V" · "getReason" · "()Ljava/lang/String;" · "component1" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/strategy/ConnectionResult$NotConnected;" · "Lcom/tuwinsmart/tuwin/domain/strategy/ConnectionResult;" · "()V" · "equals" · "other" · "hashCode" · "toString" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.strategy.ConnectionResult$Failure`
L113 · [class] public static final Failure · extends `ConnectionResult` · `com/tuwinsmart/tuwin/domain/strategy/ConnectionResult.java`
注解：

字段/常量（1）：
- `String reason`  L114

方法（8）：
- `Failure copy$default(Failure failure, String str, int i, Object obj)`  L116
- `String getReason()`  L124
- `Failure copy(String reason)`  L128
    - 体内字面量："reason"
- `boolean equals(Object other)`  L133
- `int hashCode()`  L140
- `String toString()`  L144
    - 体内字面量："Failure(reason=" · ")"
- `public Failure(String reason)`  L149
    - 体内字面量："reason"
- `String getReason()`  L155
### `com.tuwinsmart.tuwin.domain.strategy.ConnectionResult$NotConnected`
L162 · [class] public static final NotConnected · extends `ConnectionResult` · `com/tuwinsmart/tuwin/domain/strategy/ConnectionResult.java`
注解：

方法（4）：
- `boolean equals(Object other)`  L165
- `int hashCode()`  L175
- `String toString()`  L179
    - 体内字面量："NotConnected"
- `private NotConnected()`  L183
### `com.tuwinsmart.tuwin.domain.strategy.ConnectionResult$Success`
L25 · [class] public static final Success · extends `ConnectionResult` · `com/tuwinsmart/tuwin/domain/strategy/ConnectionResult.java`
注解：

字段/常量（5）：
- `ConnectedDevice device`  L26
- `DeviceType deviceType`  L27
- `String ssid`  L28
- `String str = this.ssid`  L75
- `DeviceType deviceType = this.deviceType`  L77

方法（13）：
- `Success copy$default(Success success, String str, ConnectedDevice connectedDevice, DeviceType deviceType, int i, Object obj)`  L30
- `String getSsid()`  L44
- `ConnectedDevice getDevice()`  L49
- `DeviceType getDeviceType()`  L54
- `Success copy(String ssid, ConnectedDevice device, DeviceType deviceType)`  L58
    - 体内字面量："device"
- `boolean equals(Object other)`  L63
- `int hashCode()`  L74
- `String toString()`  L81
    - 体内字面量："Success(ssid=" · ", device=" · ", deviceType=" · ")"
- ` Success(String str, ConnectedDevice connectedDevice, DeviceType deviceType, int i, DefaultConstructorMarker defaultConstructorMarker)`  L85
- `String getSsid()`  L89
- `ConnectedDevice getDevice()`  L93
- `DeviceType getDeviceType()`  L97
- `public Success(String str, ConnectedDevice device, DeviceType deviceType)`  L102
    - 体内字面量："device"
### `com.tuwinsmart.tuwin.domain.strategy.ConnectionStrategy`
L18 · [interface] public ConnectionStrategy · `com/tuwinsmart/tuwin/domain/strategy/ConnectionStrategy.java`
注解：

方法（2）：
- `Object checkConnection(Network network, ConnectionCheckMode connectionCheckMode, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, String str, boolean z, Continuation<? super ConnectionResult> continuation)`  L19
- `Object checkPrerequisites(Continuation<? super PrerequisiteCheckResult> continuation)`  L21
    - 体内字面量："<anonymous>" · "it" · "Lcom/tuwinsmart/tuwin/domain/model/ConnectionProgressUpdate;" · "com.tuwinsmart.tuwin.domain.strategy.ConnectionStrategy$checkConnection$1" · "ConnectionStrategy.kt" · "invokeSuspend"
### `com.tuwinsmart.tuwin.domain.strategy.ConnectionStrategy$C23721`
L51 · [class] static final C23721 · extends `SuspendLambda implements Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · implements `Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/domain/strategy/ConnectionStrategy.java`
注解：

字段/常量（1）：
- `int label`  L52

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L59 @Override
- `Object invoke(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L64 @Override
- `Object invokeSuspend(Object obj)`  L69 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.domain.strategy.ConnectionStrategy$DefaultImpls`
L25 · [class] public static final DefaultImpls · `com/tuwinsmart/tuwin/domain/strategy/ConnectionStrategy.java`
注解：

字段/常量（2）：
- `ConnectionCheckMode connectionCheckMode2 = connectionCheckMode`  L34
- `Function2 function3 = function2`  L38

方法（1）：
- `Object checkConnection$default(ConnectionStrategy connectionStrategy, Network network, ConnectionCheckMode connectionCheckMode, Function2 function2, String str, boolean z, Continuation continuation, int i, Object obj)`  L27
    - 体内字面量："Super calls with default arguments not supported in this target, function: checkConnection"
### `com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy`
L72 · [class] public final M3ConnectionStrategy · implements `ConnectionStrategy` · `com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java`
注解：

字段/常量（82）：
- `int M3_CONTROL_PORT = 80`  L76 @Deprecated
- `String M3_TIME_PATTERN = "yyyyMMddHHmmss"`  L79 @Deprecated
- `int MILLIS_PER_HOUR = 3600000`  L82 @Deprecated
- `DeviceSessionManager deviceSessionManager`  L83
- `M3SessionConnector m3SessionConnector`  L84
- `Function0<Date> nowProvider`  L85
- `M3SessionRepositoryFactory repositoryFactory`  L86
- `Set<SessionRevision> scheduledTimeSyncs`  L87
- `Object timeSyncLock`  L88
- `CoroutineScope timeSyncScope`  L89
- `Function0<TimeZone> timeZoneProvider`  L90
- `boolean zIsWifiConnected`  L206
- `String[] strArr`  L207
- `String str = null`  L209
- `C23761 c23761`  L238
- `Object obj`  L239
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function3`  L240
- `Network network2`  L241
- `M3ConnectionStrategy m3ConnectionStrategy`  L242
- `C23761 c23762 = c23761`  L253
- `Object objCheckActiveSession = c23762.result`  L254
- `int i = c23762.label`  L256
- `M3SessionConnector m3SessionConnector = m3ConnectionStrategy.m3SessionConnector`  L316
- `DeviceSessionSnapshot deviceSessionSnapshotSnapshot = null`  L339
- `C23771 c23771`  L394
- `String message`  L395
- `M3ConnectionStrategy m3ConnectionStrategy`  L396
- `String str2`  L397
- `Network network2`  L398
- `M3SessionConnector m3SessionConnector2`  L399
- `String currentSSID`  L400
- `String string`  L401
- `Object objM2722connectUserInitiatedBWLJW6A`  L402
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function3`  L403
- `M3ConnectionStrategy m3ConnectionStrategy2`  L404
- `M3ConnectedSession m3ConnectedSession`  L405
- `ConnectionProgressUpdate.Started started`  L406
- `M3ConnectionStrategy m3ConnectionStrategy3`  L407
- `M3ConnectedSession m3ConnectedSession2`  L408
- `Throwable thM3077exceptionOrNullimpl`  L409
- `ConnectionProgressUpdate.Failed failed`  L410
- `Throwable th`  L411
- `String message2`  L412
- `ConnectionProgressUpdate.Started started2`  L413
- `ConnectionProgressUpdate.Started started3`  L414
- `ConnectionResult.Failure failure`  L415
- `String sessionId`  L416
- `Object objBuildSuccessFromDeviceAttr = c23771.result`  L427
- `String str3 = string`  L451
- `boolean z = string != null`  L456
- `?? c23751`  L954
- `String id`  L955
- `long revision`  L956
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function3`  L957
- `M3ConnectionStrategy m3ConnectionStrategy`  L958
- `DeviceIdentity deviceIdentity`  L959
- `?? Create`  L960
- `String str`  L961
- `Object value`  L962
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function4`  L963
- `?? r15`  L964
- `long j`  L965
- `?? r5`  L966
- `Throwable thM3077exceptionOrNullimpl`  L967
- `ConnectionProgressUpdate.Failed failed`  L968
- `?? r4`  L969
- `?? r3`  L970
- `ConnectionProgressUpdate.Failed failed2`  L971
- `?? r6`  L972
- `Throwable th`  L973
- `?? r7`  L974
- `String message`  L975
- `Object obj = c23751.result`  L987
- `int i = c23751.label`  L989
- `long j2 = revision`  L1147
- `boolean zAdd`  L1234
- `RouteSnapshot route`  L1496
- `Object objM3074constructorimpl`  L1585
- `Result.Companion companion = Result.INSTANCE`  L1587
- `M3ConnectionStrategy m3ConnectionStrategy = this`  L1588
- `Unit unit = null`  L1589
- `Result.Companion companion2 = Result.INSTANCE`  L1597

方法（15）：
- `public M3ConnectionStrategy(M3SessionConnector m3SessionConnector, DeviceSessionManager deviceSessionManager, M3SessionRepositoryFactory repositoryFactory, CoroutineScope timeSyncScope, Function0<? extends Date> nowProvider, Function0<? extends TimeZone> timeZoneProvider)`  L170
    - 体内字面量："m3SessionConnector" · "deviceSessionManager" · "repositoryFactory" · "timeSyncScope" · "nowProvider" · "timeZoneProvider"
- ` M3ConnectionStrategy(M3SessionConnector m3SessionConnector, DeviceSessionManager deviceSessionManager, M3SessionRepositoryFactory m3SessionRepositoryFactory, CoroutineScope coroutineScope, C23731 c23731, C23742 c23742, int i, DefaultConstructorMarker defaultConstructorMarker)`  L187
- `Date invoke()`  L190 @Override
- `TimeZone invoke()`  L195 @Override
    - 体内字面量："getDefault(...)"
- `Object checkPrerequisites(Continuation<? super PrerequisiteCheckResult> continuation)`  L205 @Override
- `Object checkConnection(Network network, ConnectionCheckMode connectionCheckMode, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, String str, boolean z, Continuation<? super ConnectionResult> continuation)`  L237 @Override
- `Object checkActiveSession(String str, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ConnectionResult> continuation)`  L337
- `Object checkUserSession(M3SessionConnector m3SessionConnector, Network network, String str, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ConnectionResult> continuation)`  L393
- `Object buildSuccessFromDeviceAttr(DeviceSessionSnapshot deviceSessionSnapshot, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ConnectionResult> continuation)`  L953
- `void scheduleTimeSync(final String sessionId, final long routeRevision)`  L1233
- `Boolean invoke(M3ConnectionStrategy.SessionRevision existing)`  L1244 @Override
    - 体内字面量："existing" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy$scheduleTimeSync$1" · "M3ConnectionStrategy.kt" · "invokeSuspend" · "repository" · "syncSucceeded" · "L$0" · "I$0"
- `boolean isUsableHttpSession(DeviceSessionSnapshot snapshot)`  L1481
- `boolean isCurrentRevision(String sessionId, long expectedRevision)`  L1495
- `Object closeNewSession(String str, String str2, Continuation<? super Unit> continuation)`  L1578
- `void closeRepository(M3DeviceRepository repository)`  L1584
### `com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy$C23751`
L96 · [class] static final C23751 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java`
注解：

字段/常量（8）：
- `long J$0`  L97
- `Object L$0`  L98
- `Object L$1`  L99
- `Object L$2`  L100
- `Object L$3`  L101
- `Object L$4`  L102
- `int label`  L103
- `Object result`  L104

方法（1）：
- `Object invokeSuspend(Object obj)`  L111 @Override
### `com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy$C23761`
L122 · [class] static final C23761 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java`
注解：

字段/常量（8）：
- `Object L$0`  L123
- `Object L$1`  L124
- `Object L$2`  L125
- `Object L$3`  L126
- `Object L$4`  L127
- `boolean Z$0`  L128
- `int label`  L129
- `Object result`  L130

方法（1）：
- `Object invokeSuspend(Object obj)`  L137 @Override
### `com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy$C23771`
L148 · [class] static final C23771 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java`
注解：

字段/常量（7）：
- `Object L$0`  L149
- `Object L$1`  L150
- `Object L$2`  L151
- `Object L$3`  L152
- `Object L$4`  L153
- `int label`  L154
- `Object result`  L155

方法（1）：
- `Object invokeSuspend(Object obj)`  L162 @Override
### `com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy$C23782`
L1511 · [class] static final C23782 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>` · `com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java`
注解：

字段/常量（12）：
- `String $reason`  L1512
- `String $sessionId`  L1513
- `Object L$0`  L1514
- `int label`  L1515
- `Object objM3074constructorimpl`  L1543
- `int i = this.label`  L1545
- `M3ConnectionStrategy m3ConnectionStrategy = M3ConnectionStrategy.this`  L1549
- `String str = this.$sessionId`  L1550
- `String str2 = this.$reason`  L1551
- `Result.Companion companion = Result.INSTANCE`  L1552
- `DeviceSessionManager deviceSessionManager = m3ConnectionStrategy.deviceSessionManager`  L1553
- `Result.Companion companion2 = Result.INSTANCE`  L1566

方法（4）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1525 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation)`  L1532 @Override
- `Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation)`  L1537
- `Object invokeSuspend(Object obj)`  L1542 @Override
### `com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy$C23791`
L1260 · [class] static final C23791 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java`
注解：

字段/常量（28）：
- `SessionRevision $key`  L1261
- `long $routeRevision`  L1262
- `String $sessionId`  L1263
- `int I$0`  L1264
- `Object L$0`  L1265
- `int label`  L1266
- `M3DeviceRepository m3DeviceRepositoryCreate`  L1299
- `Object objMo2800syncDeviceTime0E7RQCE`  L1300
- `int i`  L1301
- `Object obj2`  L1302
- `M3ConnectionStrategy m3ConnectionStrategy`  L1303
- `SessionRevision sessionRevision`  L1304
- `Throwable thM3077exceptionOrNullimpl`  L1305
- `M3ConnectionStrategy m3ConnectionStrategy2`  L1306
- `SessionRevision sessionRevision2`  L1307
- `?? r1 = this.label`  L1309
- `int i2 = 1`  L1310
- `Unit unit = Unit.INSTANCE`  L1317
- `Object obj3 = M3ConnectionStrategy.this.timeSyncLock`  L1318
- `M3ConnectionStrategy m3ConnectionStrategy3 = M3ConnectionStrategy.this`  L1319
- `SessionRevision sessionRevision3 = this.$key`  L1320
- `Unit unit2 = Unit.INSTANCE`  L1328
- `Object obj4 = M3ConnectionStrategy.this.timeSyncLock`  L1332
- `M3ConnectionStrategy m3ConnectionStrategy4 = M3ConnectionStrategy.this`  L1333
- `SessionRevision sessionRevision4 = this.$key`  L1334
- `Object obj5 = M3ConnectionStrategy.this.timeSyncLock`  L1469
- `M3ConnectionStrategy m3ConnectionStrategy5 = M3ConnectionStrategy.this`  L1470
- `SessionRevision sessionRevision5 = this.$key`  L1471

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1277 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1282 @Override
- `Object invokeSuspend(Object obj)`  L1298 @Override
### `com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy$Companion`
L1674 · [class] private static final Companion · `com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java`
注解：

方法（2）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L1675
- `private Companion()`  L1679
### `com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy$SessionRevision`
L1609 · [class] static final SessionRevision · `com/tuwinsmart/tuwin/domain/strategy/M3ConnectionStrategy.java`
注解：

字段/常量（2）：
- `long revision`  L1610
- `String sessionId`  L1611

方法（10）：
- `SessionRevision copy$default(SessionRevision sessionRevision, String str, long j, int i, Object obj)`  L1613
- `String getSessionId()`  L1624
- `long getRevision()`  L1629
- `SessionRevision copy(String sessionId, long revision)`  L1633
    - 体内字面量："sessionId"
- `boolean equals(Object other)`  L1638
- `int hashCode()`  L1649
- `String toString()`  L1653
    - 体内字面量："SessionRevision(sessionId=" · ", revision=" · ")"
- `public SessionRevision(String sessionId, long j)`  L1657
    - 体内字面量："sessionId"
- `long getRevision()`  L1663
- `String getSessionId()`  L1667
### `com.tuwinsmart.tuwin.domain.strategy.PrerequisiteCheckResult`
L11 · [class] public final PrerequisiteCheckResult · `com/tuwinsmart/tuwin/domain/strategy/PrerequisiteCheckResult.java`
注解：

字段/常量（5）：
- `String failureReason`  L12
- `boolean hasPermissions`  L13
- `boolean hasPrivacyConsent`  L14
- `boolean isWifiConnected`  L15
- `String str = this.failureReason`  L70

方法（16）：
- `PrerequisiteCheckResult copy$default(PrerequisiteCheckResult prerequisiteCheckResult, boolean z, boolean z2, boolean z3, String str, int i, Object obj)`  L17
- `boolean getIsWifiConnected()`  L34
- `boolean getHasPermissions()`  L39
- `boolean getHasPrivacyConsent()`  L44
- `String getFailureReason()`  L49
- `PrerequisiteCheckResult copy(boolean isWifiConnected, boolean hasPermissions, boolean hasPrivacyConsent, String failureReason)`  L53
- `boolean equals(Object other)`  L57
- `int hashCode()`  L68
- `String toString()`  L74
    - 体内字面量："PrerequisiteCheckResult(isWifiConnected=" · ", hasPermissions=" · ", hasPrivacyConsent=" · ", failureReason=" · ")"
- `public PrerequisiteCheckResult(boolean z, boolean z2, boolean z3, String str)`  L78
- ` PrerequisiteCheckResult(boolean z, boolean z2, boolean z3, String str, int i, DefaultConstructorMarker defaultConstructorMarker)`  L85
- `boolean isWifiConnected()`  L89
- `boolean getHasPermissions()`  L93
- `boolean getHasPrivacyConsent()`  L97
- `String getFailureReason()`  L101
- `boolean isPassed()`  L105
### `com.tuwinsmart.tuwin.domain.strategy.Ride3ProConnectionStrategy`
L50 · [class] public final Ride3ProConnectionStrategy · implements `ConnectionStrategy` · `com/tuwinsmart/tuwin/domain/strategy/Ride3ProConnectionStrategy.java`
注解：

字段/常量（97）：
- `Ride3ProDeviceRepository ride3ProDeviceRepository`  L51
- `Ride3ProSessionConnector sessionConnector`  L52
- `DeviceSessionManager sessionManager`  L53
- `DeviceType targetDeviceType`  L54
- `boolean zIsWifiConnected`  L140
- `String str = null`  L142
- `C23811 c23811`  L205
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function3`  L206
- `String str2`  L207
- `Ride3ProConnectionStrategy ride3ProConnectionStrategy`  L208
- `Network network2`  L209
- `ConnectionCheckMode connectionCheckMode2`  L210
- `boolean z2`  L211
- `PrerequisiteCheckResult prerequisiteCheckResult`  L212
- `String currentSSID`  L213
- `String strRemoveSurrounding`  L214
- `DeviceType deviceTypeInferDeviceTypeFromSsid`  L215
- `int i`  L216
- `Object objMo2807detectConnection0E7RQCE`  L217
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function4`  L218
- `Ride3ProConnectionStrategy ride3ProConnectionStrategy2`  L219
- `String string`  L220
- `ConnectionResult connectionResultExistingSession`  L221
- `Object objM2725connectUserInitiatedBWLJW6A`  L222
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function5`  L223
- `String failureReason`  L224
- `Throwable thM3077exceptionOrNullimpl`  L225
- `ConnectionProgressUpdate.Failed failed`  L226
- `Throwable th`  L227
- `ConnectedDevice device`  L228
- `ConnectionProgressUpdate.Started started`  L229
- `ConnectedDevice connectedDevice`  L230
- `Ride3ProConnectionStrategy ride3ProConnectionStrategy3`  L231
- `String message`  L232
- `Ride3ProConnectionSnapshot ride3ProConnectionSnapshot`  L233
- `ConnectionProgressUpdate.Started started2`  L234
- `Throwable thM3077exceptionOrNullimpl2`  L235
- `String message2`  L236
- `Object objMo2814getRide3ProDeviceAttrIoAF18A`  L237
- `Ride3ProDeviceAttr ride3ProDeviceAttr`  L238
- `String pwd`  L239
- `String str3`  L240
- `String model`  L241
- `String ssid`  L242
- `String str4`  L243
- `String string2`  L244
- `Throwable thM3077exceptionOrNullimpl3`  L245
- `ConnectionProgressUpdate.Failed failed2`  L246
- `String str5`  L247
- `Ride3ProConnectionStrategy ride3ProConnectionStrategy4`  L248
- `String message3`  L249
- `Object objReestablishSessionIfPossible = c23811.result`  L260
- `String str6 = "Unknown error"`  L262
- `Ride3ProSessionConnector ride3ProSessionConnector = ride3ProConnectionStrategy.sessionConnector`  L293
- `Ride3ProDeviceRepository ride3ProDeviceRepository = ride3ProConnectionStrategy.ride3ProDeviceRepository`  L372
- `Ride3ProDeviceRepository ride3ProDeviceRepository2 = ride3ProConnectionStrategy.ride3ProDeviceRepository`  L387
- `Ride3ProDeviceRepository ride3ProDeviceRepository3 = ride3ProConnectionStrategy2.ride3ProDeviceRepository`  L423
- `String str7 = model`  L465
- `String str8 = ssid`  L471
- `Ride3ProDeviceRepository ride3ProDeviceRepository4 = ride3ProConnectionStrategy.ride3ProDeviceRepository`  L528
- `Ride3ProDeviceRepository ride3ProDeviceRepository5 = ride3ProConnectionStrategy.ride3ProDeviceRepository`  L543
- `Ride3ProDeviceRepository ride3ProDeviceRepository6 = ride3ProConnectionStrategy2.ride3ProDeviceRepository`  L579
- `String str10 = model`  L621
- `String str11 = ssid`  L627
- `Ride3ProDeviceRepository ride3ProDeviceRepository7 = ride3ProConnectionStrategy2.ride3ProDeviceRepository`  L712
- `String str12 = model`  L754
- `String str13 = ssid`  L760
- `Ride3ProDeviceRepository ride3ProDeviceRepository8 = ride3ProConnectionStrategy2.ride3ProDeviceRepository`  L772
- `String str14 = model`  L814
- `String str15 = ssid`  L820
- `String str16 = model`  L866
- `String str17 = ssid`  L872
- `C23821 c23821`  L895
- `Ride3ProSessionConnector ride3ProSessionConnector`  L896
- `Object objM3074constructorimpl`  L897
- `Ride3ProConnectionStrategy ride3ProConnectionStrategy`  L898
- `Object objM2725connectUserInitiatedBWLJW6A`  L899
- `Ride3ProConnectionStrategy ride3ProConnectionStrategy2`  L900
- `Object obj = c23821.result`  L911
- `int i = c23821.label`  L913
- `Result.Companion companion = Result.INSTANCE`  L929
- `Ride3ProConnectionStrategy ride3ProConnectionStrategy3 = this`  L930
- `DeviceSessionManager deviceSessionManager = this.sessionManager`  L931
- `Result.Companion companion2 = Result.INSTANCE`  L934
- `DeviceSessionManager deviceSessionManager2 = this.sessionManager`  L942
- `Object objM3074constructorimpl`  L1028
- `DeviceSessionSnapshot deviceSessionSnapshotActiveRide3ProSession`  L1029
- `String str`  L1030
- `DeviceSessionManager deviceSessionManager = this.sessionManager`  L1031
- `Result.Companion companion = Result.INSTANCE`  L1038
- `Ride3ProConnectionStrategy ride3ProConnectionStrategy = this`  L1039
- `Result.Companion companion2 = Result.INSTANCE`  L1042
- `Object next`  L1093
- `Object objM3074constructorimpl`  L1102
- `DeviceSessionManager deviceSessionManager = manager`  L1104
- `Result.Companion companion = Result.INSTANCE`  L1106
- `Result.Companion companion2 = Result.INSTANCE`  L1109

方法（9）：
- `public Ride3ProConnectionStrategy(Ride3ProDeviceRepository ride3ProDeviceRepository, Ride3ProSessionConnector ride3ProSessionConnector, DeviceSessionManager deviceSessionManager, DeviceType targetDeviceType)`  L125
    - 体内字面量："ride3ProDeviceRepository" · "targetDeviceType"
- ` Ride3ProConnectionStrategy(Ride3ProDeviceRepository ride3ProDeviceRepository, Ride3ProSessionConnector ride3ProSessionConnector, DeviceSessionManager deviceSessionManager, DeviceType deviceType, int i, DefaultConstructorMarker defaultConstructorMarker)`  L134
- `Object checkPrerequisites(Continuation<? super PrerequisiteCheckResult> continuation)`  L139 @Override
- `Object checkConnection(Network network, ConnectionCheckMode connectionCheckMode, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, String str, boolean z, Continuation<? super ConnectionResult> continuation)`  L204 @Override
- `Object reestablishSessionIfPossible(Network network, String str, Continuation<? super ConnectionResult> continuation)`  L894
- `boolean isCurrentSsidReadable()`  L1016
    - 体内字面量："\"" · "unknown"
- `ConnectionResult existingSession(String sessionId)`  L1027
- `DeviceSessionSnapshot activeRide3ProSession(final DeviceSessionManager manager)`  L1092
- `DeviceSessionSnapshot invoke(String id)`  L1101 @Override
### `com.tuwinsmart.tuwin.domain.strategy.Ride3ProConnectionStrategy$C23811`
L79 · [class] static final C23811 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/Ride3ProConnectionStrategy.java`
注解：

字段/常量（8）：
- `Object L$0`  L80
- `Object L$1`  L81
- `Object L$2`  L82
- `Object L$3`  L83
- `Object L$4`  L84
- `boolean Z$0`  L85
- `int label`  L86
- `Object result`  L87

方法（1）：
- `Object invokeSuspend(Object obj)`  L94 @Override
### `com.tuwinsmart.tuwin.domain.strategy.Ride3ProConnectionStrategy$C23821`
L105 · [class] static final C23821 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/Ride3ProConnectionStrategy.java`
注解：

字段/常量（6）：
- `Object L$0`  L106
- `Object L$1`  L107
- `Object L$2`  L108
- `Object L$3`  L109
- `int label`  L110
- `Object result`  L111

方法（1）：
- `Object invokeSuspend(Object obj)`  L118 @Override
### `com.tuwinsmart.tuwin.domain.strategy.Ride3ProConnectionStrategy$WhenMappings`
L58 · [class] public WhenMappings · `com/tuwinsmart/tuwin/domain/strategy/Ride3ProConnectionStrategy.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L59
### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy`
L74 · [class] public final Ride5ConnectionStrategy · implements `ConnectionStrategy` · `com/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy.java`
注解：

字段/常量（99）：
- `String RIDE5_TIME_PATTERN = "yyyyMMddHHmmss"`  L78 @Deprecated
- `Function0<Date> nowProvider`  L79
- `Ride5DeviceAttrRepository ride5DeviceAttrRepository`  L80
- `Set<SessionRevision> scheduledTimeSyncs`  L81
- `Ride5SessionConnector sessionConnector`  L82
- `DeviceSessionManager sessionManager`  L83
- `Ride5SessionPortProvider sessionPortProvider`  L84
- `Object timeSyncLock`  L85
- `CoroutineScope timeSyncScope`  L86
- `Function0<TimeZone> timeZoneProvider`  L87
- `boolean zIsWifiConnected`  L247
- `String[] strArr`  L248
- `String str = null`  L250
- `C23861 c23861`  L281
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function3`  L282
- `Ride5ConnectionStrategy ride5ConnectionStrategy`  L283
- `Network network2`  L284
- `String str2`  L285
- `ConnectionCheckMode connectionCheckMode2`  L286
- `boolean z2`  L287
- `String str3`  L288
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function4`  L289
- `Network network3`  L290
- `Ride5ConnectionStrategy ride5ConnectionStrategy2`  L291
- `ConnectionResult connectionResult`  L292
- `Object objExistingSession = c23861.result`  L303
- `int i = c23861.label`  L305
- `C23871 c23871`  L464
- `String str2`  L465
- `Ride5SessionConnector ride5SessionConnector`  L466
- `Network network2`  L467
- `Ride5ConnectionStrategy ride5ConnectionStrategy`  L468
- `ConnectionProgressUpdate.Started started`  L469
- `Network network3`  L470
- `Ride5ConnectionStrategy ride5ConnectionStrategy2`  L471
- `String currentSSID`  L472
- `String string`  L473
- `boolean z`  L474
- `Object objM2726connectUserInitiatedyxL6bBk$default`  L475
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function3`  L476
- `Object obj`  L477
- `Ride5ConnectionStrategy ride5ConnectionStrategy3`  L478
- `String str3`  L479
- `String str4`  L480
- `ConnectionProgressUpdate.Started started2`  L481
- `String str5`  L482
- `String str6`  L483
- `ConnectionProgressUpdate.Failed failed`  L484
- `Throwable thM3077exceptionOrNullimpl`  L485
- `String message`  L486
- `ConnectionProgressUpdate.Started started3`  L487
- `Ride5ConnectionStrategy ride5ConnectionStrategy4`  L488
- `Ride5ConnectedSession ride5ConnectedSession`  L489
- `String strRemoveDoubleQue`  L490
- `DeviceIdentity identity`  L491
- `String serial`  L492
- `String firmwareVersion`  L493
- `String boardVersion`  L494
- `ConnectedDevice connectedDevice`  L495
- `long revision`  L496
- `Ride5ConnectedSession ride5ConnectedSession2`  L497
- `ConnectedDevice connectedDevice2`  L498
- `Ride5ConnectionStrategy ride5ConnectionStrategy5`  L499
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function4 = function2`  L500
- `Object obj2 = c23871.result`  L511
- `String str7 = string`  L551
- `C23901 c23901`  L1148
- `Object objM3074constructorimpl`  L1149
- `Ride5ConnectionStrategy ride5ConnectionStrategy`  L1150
- `Object objConnectUserSession = c23901.result`  L1161
- `int i = c23901.label`  L1163
- `Result.Companion companion = Result.INSTANCE`  L1175
- `Ride5ConnectionStrategy ride5ConnectionStrategy2 = this`  L1176
- `DeviceSessionManager deviceSessionManager = this.sessionManager`  L1177
- `Result.Companion companion2 = Result.INSTANCE`  L1180
- `DeviceSessionManager deviceSessionManager2 = this.sessionManager`  L1188
- `C23881 c23881`  L1274
- `Object objM3074constructorimpl`  L1275
- `DeviceSessionSnapshot deviceSessionSnapshotActiveRide5Session`  L1276
- `ConnectedDevice connectedDevice`  L1277
- `String str2`  L1278
- `Object obj = c23881.result`  L1289
- `int i = c23881.label`  L1291
- `DeviceSessionManager deviceSessionManager = this.sessionManager`  L1294
- `Result.Companion companion = Result.INSTANCE`  L1301
- `Ride5ConnectionStrategy ride5ConnectionStrategy = this`  L1302
- `Result.Companion companion2 = Result.INSTANCE`  L1305
- `C23891 c23891`  L1365
- `ConnectedDevice connectedDevice2`  L1366
- `String str`  L1367
- `Ride5ConnectionStrategy ride5ConnectionStrategy`  L1368
- `Object obj = c23891.result`  L1379
- `int i = c23891.label`  L1381
- `Object next`  L1440
- `Object objM3074constructorimpl`  L1449
- `DeviceSessionManager deviceSessionManager = manager`  L1451
- `Result.Companion companion = Result.INSTANCE`  L1453
- `Result.Companion companion2 = Result.INSTANCE`  L1456
- `boolean zAdd`  L1477

方法（15）：
- `public Ride5ConnectionStrategy(Ride5DeviceAttrRepository ride5DeviceAttrRepository, Ride5SessionConnector ride5SessionConnector, DeviceSessionManager deviceSessionManager, Ride5SessionPortProvider sessionPortProvider, CoroutineScope timeSyncScope, Function0<? extends Date> nowProvider, Function0<? extends TimeZone> timeZoneProvider)`  L211
    - 体内字面量："ride5DeviceAttrRepository" · "sessionPortProvider" · "timeSyncScope" · "nowProvider" · "timeZoneProvider"
- ` Ride5ConnectionStrategy(Ride5DeviceAttrRepository ride5DeviceAttrRepository, Ride5SessionConnector ride5SessionConnector, DeviceSessionManager deviceSessionManager, Ride5SessionPortProvider ride5SessionPortProvider, CoroutineScope coroutineScope, Function0 function0, Function0 function1, int i, DefaultConstructorMarker defaultConstructorMarker)`  L228
- `Date invoke()`  L231 @Override
- `TimeZone invoke()`  L236 @Override
    - 体内字面量："getDefault(...)"
- `Object checkPrerequisites(Continuation<? super PrerequisiteCheckResult> continuation)`  L246 @Override
- `Object checkConnection(Network network, ConnectionCheckMode connectionCheckMode, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, String str, boolean z, Continuation<? super ConnectionResult> continuation)`  L280 @Override
- `Object connectUserSession(Network network, String str, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ConnectionResult> continuation)`  L463
- `Object reestablishSessionIfPossible(Network network, String str, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ConnectionResult> continuation)`  L1147
- `boolean isCurrentSsidReadable()`  L1260
    - 体内字面量："\"" · "unknown"
- `Object existingSession(String str, Continuation<? super ConnectionResult> continuation)`  L1273
- `Object readWifiPassword(ConnectedDevice connectedDevice, long j, Continuation<? super Unit> continuation)`  L1364
- `DeviceSessionSnapshot activeRide5Session(final DeviceSessionManager manager)`  L1439
- `DeviceSessionSnapshot invoke(String id)`  L1448 @Override
- `void scheduleTimeSync(final String sessionId, final long routeRevision)`  L1476
- `Boolean invoke(Ride5ConnectionStrategy.SessionRevision existing)`  L1487 @Override
    - 体内字面量："existing" · "<anonymous>" · "Lkotlinx/coroutines/CoroutineScope;" · "com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy$scheduleTimeSync$1" · "Ride5ConnectionStrategy.kt" · "invokeSuspend" · "syncSucceeded" · "I$0" · "Lcom/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy$SessionRevision;" · "sessionId" · "(Ljava/lang/String;J)V" · "getRevision" · "()J" · "getSessionId" · "()Ljava/lang/String;" · "component1" · "component2" · "copy" · "equals" · "other" · "hashCode" · "toString" · "app_release_64" · "Lcom/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy$Companion;" · "()V" · "RIDE5_TIME_PATTERN" · "app_release_64"
### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy$C23861`
L93 · [class] static final C23861 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy.java`
注解：

字段/常量（8）：
- `Object L$0`  L94
- `Object L$1`  L95
- `Object L$2`  L96
- `Object L$3`  L97
- `Object L$4`  L98
- `boolean Z$0`  L99
- `int label`  L100
- `Object result`  L101

方法（1）：
- `Object invokeSuspend(Object obj)`  L108 @Override
### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy$C23871`
L119 · [class] static final C23871 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy.java`
注解：

字段/常量（7）：
- `Object L$0`  L120
- `Object L$1`  L121
- `Object L$2`  L122
- `Object L$3`  L123
- `Object L$4`  L124
- `int label`  L125
- `Object result`  L126

方法（1）：
- `Object invokeSuspend(Object obj)`  L133 @Override
### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy$C23881`
L144 · [class] static final C23881 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy.java`
注解：

字段/常量（4）：
- `Object L$0`  L145
- `Object L$1`  L146
- `int label`  L147
- `Object result`  L148

方法（1）：
- `Object invokeSuspend(Object obj)`  L155 @Override
### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy$C23891`
L166 · [class] static final C23891 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy.java`
注解：

字段/常量（6）：
- `long J$0`  L167
- `Object L$0`  L168
- `Object L$1`  L169
- `Object L$2`  L170
- `int label`  L171
- `Object result`  L172

方法（1）：
- `Object invokeSuspend(Object obj)`  L179 @Override
### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy$C23901`
L190 · [class] static final C23901 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy.java`
注解：

字段/常量（6）：
- `Object L$0`  L191
- `Object L$1`  L192
- `Object L$2`  L193
- `Object L$3`  L194
- `int label`  L195
- `Object result`  L196

方法（1）：
- `Object invokeSuspend(Object obj)`  L203 @Override
### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy$C23911`
L1503 · [class] static final C23911 · extends `SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object>` · implements `Function2<CoroutineScope, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy.java`
注解：

字段/常量（19）：
- `SessionRevision $key`  L1504
- `long $routeRevision`  L1505
- `String $sessionId`  L1506
- `int I$0`  L1507
- `int label`  L1508
- `Object obj2`  L1534
- `Ride5ConnectionStrategy ride5ConnectionStrategy`  L1535
- `SessionRevision sessionRevision`  L1536
- `Object obj3`  L1537
- `Ride5ConnectionStrategy ride5ConnectionStrategy2`  L1538
- `SessionRevision sessionRevision2`  L1539
- `int i = this.label`  L1541
- `int i2 = 0`  L1542
- `int i3 = 1`  L1543
- `Unit unit = Unit.INSTANCE`  L1549
- `Object obj4 = Ride5ConnectionStrategy.this.timeSyncLock`  L1550
- `Ride5ConnectionStrategy ride5ConnectionStrategy3 = Ride5ConnectionStrategy.this`  L1551
- `SessionRevision sessionRevision3 = this.$key`  L1552
- `int i4 = this.I$0`  L1592

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L1519 @Override
- `Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation)`  L1524 @Override
- `Object invokeSuspend(Object obj)`  L1533 @Override
### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy$Companion`
L1730 · [class] private static final Companion · `com/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy.java`
注解：

方法（2）：
- ` Companion(DefaultConstructorMarker defaultConstructorMarker)`  L1731
- `private Companion()`  L1735
### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy$SessionRevision`
L1665 · [class] static final SessionRevision · `com/tuwinsmart/tuwin/domain/strategy/Ride5ConnectionStrategy.java`
注解：

字段/常量（2）：
- `long revision`  L1666
- `String sessionId`  L1667

方法（10）：
- `SessionRevision copy$default(SessionRevision sessionRevision, String str, long j, int i, Object obj)`  L1669
- `String getSessionId()`  L1680
- `long getRevision()`  L1685
- `SessionRevision copy(String sessionId, long revision)`  L1689
    - 体内字面量："sessionId"
- `boolean equals(Object other)`  L1694
- `int hashCode()`  L1705
- `String toString()`  L1709
    - 体内字面量："SessionRevision(sessionId=" · ", revision=" · ")"
- `public SessionRevision(String sessionId, long j)`  L1713
    - 体内字面量："sessionId"
- `long getRevision()`  L1719
- `String getSessionId()`  L1723
### `com.tuwinsmart.tuwin.domain.usecase.device.DetectConnectionUseCase`
L28 · [class] public final DetectConnectionUseCase · `com/tuwinsmart/tuwin/domain/usecase/device/DetectConnectionUseCase.java`
注解：

字段/常量（14）：
- `M3ConnectionStrategy m3Strategy`  L29
- `Ride3ProConnectionStrategy ride3ProStrategy`  L30
- `Ride5ConnectionStrategy ride5Strategy`  L31
- `Ride3ProConnectionStrategy ride6Strategy`  L32
- `DetectConnectionUseCase$invoke$1 detectConnectionUseCase$invoke$1`  L78
- `M3ConnectionStrategy m3ConnectionStrategy`  L79
- `DeviceType deviceType2`  L80
- `DetectConnectionUseCase$invoke$1 detectConnectionUseCase$invoke$2 = detectConnectionUseCase$invoke$1`  L91
- `Object obj = detectConnectionUseCase$invoke$2.result`  L92
- `int i = detectConnectionUseCase$invoke$2.label`  L94
- `Ride3ProConnectionStrategy ride3ProConnectionStrategy = this.ride6Strategy`  L108
- `Result.Companion companion = Result.INSTANCE`  L134
- `Result.Companion companion2 = Result.INSTANCE`  L138
- `Result.Companion companion3 = Result.INSTANCE`  L144

方法（3）：
- `public DetectConnectionUseCase(M3ConnectionStrategy m3Strategy, Ride5ConnectionStrategy ride5Strategy, Ride3ProConnectionStrategy ride3ProStrategy, Ride3ProConnectionStrategy ride3ProConnectionStrategy)`  L61
    - 体内字面量："m3Strategy" · "ride5Strategy" · "ride3ProStrategy"
- ` DetectConnectionUseCase(M3ConnectionStrategy m3ConnectionStrategy, Ride5ConnectionStrategy ride5ConnectionStrategy, Ride3ProConnectionStrategy ride3ProConnectionStrategy, Ride3ProConnectionStrategy ride3ProConnectionStrategy2, int i, DefaultConstructorMarker defaultConstructorMarker)`  L71
- `Object m2879invokebMdYcbs(DeviceType deviceType, Network network, ConnectionCheckMode connectionCheckMode, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, String str, boolean z, Continuation<? super Result<ConnectedDevice>> continuation)`  L77
### `com.tuwinsmart.tuwin.domain.usecase.device.DetectConnectionUseCase$invoke$1`
L16 · [class] final DetectConnectionUseCase$invoke$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/usecase/device/DetectConnectionUseCase$invoke$1.java`
注解：

字段/常量（4）：
- `Object L$0`  L17
- `int label`  L18
- `Object result`  L19
- `DetectConnectionUseCase this$0`  L20

方法（1）：
- `Object invokeSuspend(Object obj)`  L29 @Override
### `com.tuwinsmart.tuwin.domain.usecase.device.DetectConnectionUseCase$invoke$2`
L18 · [class] final DetectConnectionUseCase$invoke$2 · extends `SuspendLambda implements Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · implements `Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/domain/usecase/device/DetectConnectionUseCase$invoke$2.java`
注解：

字段/常量（1）：
- `int label`  L19

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L26 @Override
- `Object invoke(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L31 @Override
- `Object invokeSuspend(Object obj)`  L36 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.domain.usecase.device.DetectConnectionUseCase$WhenMappings`
L36 · [class] public WhenMappings · `com/tuwinsmart/tuwin/domain/usecase/device/DetectConnectionUseCase.java`
注解：

字段/常量（1）：
- `int[] $EnumSwitchMapping$0`  L37
### `com.tuwinsmart.tuwin.domain.usecase.device.RefreshConnectionUseCase`
L25 · [class] public final RefreshConnectionUseCase · `com/tuwinsmart/tuwin/domain/usecase/device/RefreshConnectionUseCase.java`
注解：

字段/常量（55）：
- `DetectConnectionUseCase detectConnectionUseCase`  L26
- `DeviceRepository deviceRepository`  L27
- `DeviceVersionRepository deviceVersionRepository`  L28
- `Mutex mutex`  L29
- `SdCardFormatReminderUseCase sdCardFormatReminderUseCase`  L30
- `RefreshConnectionUseCase$invoke$1 refreshConnectionUseCase$invoke$1`  L69
- `Network network2`  L70
- `ConnectionCheckMode connectionCheckMode2`  L71
- `Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function3`  L72
- `Mutex mutex`  L73
- `ConnectedDevice connectedDevice2`  L74
- `boolean z2`  L75
- `RefreshConnectionUseCase refreshConnectionUseCase`  L76
- `Object obj`  L77
- `Throwable th`  L78
- `RefreshConnectionUseCase refreshConnectionUseCase2`  L79
- `ConnectedDevice connectedDevice3`  L80
- `Mutex mutex2`  L81
- `int i`  L82
- `String devid`  L83
- `String version`  L84
- `Object objM3074constructorimpl`  L85
- `int i2`  L86
- `RefreshConnectionUseCase refreshConnectionUseCase3`  L87
- `Mutex mutex3`  L88
- `Mutex mutex4`  L89
- `Mutex mutex5`  L90
- `Object objM2879invokebMdYcbs`  L91
- `String devid2`  L92
- `String ssid`  L93
- `String apBssid`  L94
- `String version2`  L95
- `String boardversion`  L96
- `String model`  L97
- `String product`  L98
- `String sessionId`  L99
- `String reportedWifiPassword`  L100
- `DeviceRepository deviceRepository`  L101
- `DeviceRepository deviceRepository2`  L102
- `String ssid2`  L103
- `Object obj2 = refreshConnectionUseCase$invoke$1.result`  L114
- `int i3 = refreshConnectionUseCase$invoke$1.label`  L116
- `?? r4 = 2`  L117
- `Mutex mutex6 = this.mutex`  L121
- `Result.Companion companion = Result.INSTANCE`  L153
- `Result.Companion companion2 = Result.INSTANCE`  L180
- `int i4 = refreshConnectionUseCase$invoke$1.I$0`  L187
- `Result.Companion companion3 = Result.INSTANCE`  L215
- `Result.Companion companion4 = Result.INSTANCE`  L294
- `boolean z3 = refreshConnectionUseCase$invoke$1.Z$0`  L313
- `Result.Companion companion5 = Result.INSTANCE`  L333
- `DetectConnectionUseCase detectConnectionUseCase = refreshConnectionUseCase.detectConnectionUseCase`  L338
- `int i6 = i5`  L348
- `Result.Companion companion6 = Result.INSTANCE`  L376
- `Result.Companion companion7 = Result.INSTANCE`  L453

方法（2）：
- `public RefreshConnectionUseCase(DetectConnectionUseCase detectConnectionUseCase, DeviceRepository deviceRepository, DeviceVersionRepository deviceVersionRepository, SdCardFormatReminderUseCase sdCardFormatReminderUseCase)`  L32
    - 体内字面量："detectConnectionUseCase" · "deviceRepository" · "deviceVersionRepository" · "sdCardFormatReminderUseCase"
- `Object m2881invokehUnOzRk(ConnectedDevice connectedDevice, Network network, ConnectionCheckMode connectionCheckMode, Function2<? super ConnectionProgressUpdate, ? super Continuation<? super Unit>, ? extends Object> function2, boolean z, Continuation<? super Result<ConnectedDevice>> continuation)`  L68
### `com.tuwinsmart.tuwin.domain.usecase.device.RefreshConnectionUseCase$invoke$1`
L16 · [class] final RefreshConnectionUseCase$invoke$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/usecase/device/RefreshConnectionUseCase$invoke$1.java`
注解：

字段/常量（11）：
- `int I$0`  L17
- `Object L$0`  L18
- `Object L$1`  L19
- `Object L$2`  L20
- `Object L$3`  L21
- `Object L$4`  L22
- `Object L$5`  L23
- `boolean Z$0`  L24
- `int label`  L25
- `Object result`  L26
- `RefreshConnectionUseCase this$0`  L27

方法（1）：
- `Object invokeSuspend(Object obj)`  L36 @Override
### `com.tuwinsmart.tuwin.domain.usecase.device.RefreshConnectionUseCase$invoke$2`
L19 · [class] public final RefreshConnectionUseCase$invoke$2 · extends `SuspendLambda implements Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · implements `Function2<ConnectionProgressUpdate, Continuation<? super Unit>, Object>` · `com/tuwinsmart/tuwin/domain/usecase/device/RefreshConnectionUseCase$invoke$2.java`
注解：

字段/常量（1）：
- `int label`  L20

方法（3）：
- `Continuation<Unit> create(Object obj, Continuation<?> continuation)`  L27 @Override
- `Object invoke(ConnectionProgressUpdate connectionProgressUpdate, Continuation<? super Unit> continuation)`  L32 @Override
- `Object invokeSuspend(Object obj)`  L37 @Override
    - 体内字面量："call to 'resume' before 'invoke' with coroutine"
### `com.tuwinsmart.tuwin.domain.usecase.device.SaveDeviceUseCase`
L19 · [class] public final SaveDeviceUseCase · `com/tuwinsmart/tuwin/domain/usecase/device/SaveDeviceUseCase.java`
注解：

字段/常量（10）：
- `DeviceRepository deviceRepository`  L20
- `DeviceVersionRepository deviceVersionRepository`  L21
- `SdCardFormatReminderUseCase sdCardFormatReminderUseCase`  L22
- `SaveDeviceUseCase$invoke$1 saveDeviceUseCase$invoke$1`  L36
- `SaveDeviceUseCase saveDeviceUseCase`  L37
- `Object objSaveDevice = saveDeviceUseCase$invoke$1.result`  L48
- `int i = saveDeviceUseCase$invoke$1.label`  L50
- `DeviceRepository deviceRepository = this.deviceRepository`  L54
- `Result.Companion companion = Result.INSTANCE`  L80
- `Result.Companion companion2 = Result.INSTANCE`  L85

方法（2）：
- `public SaveDeviceUseCase(DeviceRepository deviceRepository, DeviceVersionRepository deviceVersionRepository, SdCardFormatReminderUseCase sdCardFormatReminderUseCase)`  L24
    - 体内字面量："deviceRepository" · "deviceVersionRepository" · "sdCardFormatReminderUseCase"
- `Object m2882invokegIAlus(ConnectedDevice connectedDevice, Continuation<? super Result<? extends List<ConnectedDevice>>> continuation)`  L35
### `com.tuwinsmart.tuwin.domain.usecase.device.SaveDeviceUseCase$invoke$1`
L15 · [class] final SaveDeviceUseCase$invoke$1 · extends `ContinuationImpl` · `com/tuwinsmart/tuwin/domain/usecase/device/SaveDeviceUseCase$invoke$1.java`
注解：

字段/常量（5）：
- `Object L$0`  L16
- `Object L$1`  L17
- `int label`  L18
- `Object result`  L19
- `SaveDeviceUseCase this$0`  L20

方法（1）：
- `Object invokeSuspend(Object obj)`  L29 @Override
### `com.tuwinsmart.tuwin.domain.usecase.device.SdCardFormatReminderUseCase`
L15 · [class] public final SdCardFormatReminderUseCase · `com/tuwinsmart/tuwin/domain/usecase/device/SdCardFormatReminderUseCase.java`
注解：

字段/常量（4）：
- `SdCardFormatReminderRepository repository`  L16
- `String strReminderDeviceKey`  L31
- `String strReminderDeviceKey`  L46
- `String strReminderDeviceKey`  L54

方法（8）：
- `public SdCardFormatReminderUseCase(SdCardFormatReminderRepository repository)`  L18
    - 体内字面量："repository"
- `void recordConnectionIfNeeded$default(SdCardFormatReminderUseCase sdCardFormatReminderUseCase, ConnectedDevice connectedDevice, long j, int i, Object obj)`  L23
- `void recordConnectionIfNeeded(ConnectedDevice device, long nowMillis)`  L30
- `void recordFormatSuccess$default(SdCardFormatReminderUseCase sdCardFormatReminderUseCase, ConnectedDevice connectedDevice, long j, int i, Object obj)`  L38
- `void recordFormatSuccess(ConnectedDevice device, long nowMillis)`  L45
- `Long getReminderStartMillis(ConnectedDevice device)`  L53
- `boolean shouldTrack(DeviceType deviceType)`  L62
- `String reminderDeviceKey(ConnectedDevice connectedDevice)`  L66