# idGoLive — 类与成员明细：com.icatch.golive.net

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 12 个文件 / 16 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.net.ApiCaller`
L27 · [class] public ApiCaller · `com/icatch/golive/net/ApiCaller.java`

字段/常量（2）：
- `ApiCaller apiCaller`  L28
- `String TAG = "ApiCallerOnResponse"`  L29

方法（13）：
- `private ApiCaller()`  L85
- `ApiCaller getInstance()`  L88
- `void doHttpRequest(final String str, final Handler handler, final int i)`  L95
- `void onFailure(Call call, IOException iOException)`  L98 @Override
    - 体内字面量："ApiCallerOnResponse" · "onResponse Failure mRequestCode:"
- `void onResponse(Call call, Response response)`  L106 @Override
    - 体内字面量："ApiCallerOnResponse" · "request_url:" · " \n response_obj:"
- `void doPostRequest(final String str, final Handler handler, final int i)`  L117
    - 体内字面量："application/json; charset=utf-8"
- `void onFailure(Call call, IOException iOException)`  L120 @Override
    - 体内字面量："ApiCallerOnResponse" · "onResponse Failure mRequestCode:"
- `void onResponse(Call call, Response response)`  L128 @Override
    - 体内字面量："ApiCallerOnResponse" · "request_url:" · " \n response_obj:"
- `void m500lambda$uploadFile$0$comicatchgolivenetApiCaller(long j, long j2)`  L140
    - 体内字面量："ApiCallerOnResponse" · "ä¸ä¼ è¿åº¦: " · "% (" · " bytes)"
- `void uploadFile(File file)`  L144
    - 体内字面量："ApiCallerOnResponse" · "æä»¶ä¸å­å¨: " · "http://192.168.1.254/upload" · "application/octet-stream"
- `void onProgress(long j, long j2)`  L150 @Override
    - 体内字面量："description" · "æä»¶æè¿°"
- `void onFailure(Call call, IOException iOException)`  L155 @Override
    - 体内字面量："ApiCallerOnResponse" · "Upload failed: "
- `void onResponse(Call call, Response response)`  L160 @Override
    - 体内字面量："ApiCallerOnResponse" · "Upload successful: " · "ApiCallerOnResponse" · "Upload failed with code: "
### `com.icatch.golive.net.ApiCaller$ProgressRequestBody`
L31 · [class] static ProgressRequestBody · extends `RequestBody` · `com/icatch/golive/net/ApiCaller.java`

字段/常量（3）：
- `BufferedSink bufferedSink`  L32
- `Listener listener`  L33
- `RequestBody requestBody`  L34

方法（4）：
- `public ProgressRequestBody(RequestBody requestBody, Listener listener)`  L59
- `long contentLength()`  L65 @Override
- `MediaType getContentType()`  L71 @Override
- `void writeTo(BufferedSink bufferedSink)`  L76 @Override
### `com.icatch.golive.net.ApiCaller$ProgressRequestBody$Listener`
L36 · [interface] public Listener · `com/icatch/golive/net/ApiCaller.java`

方法（1）：
- `void onProgress(long j, long j2)`  L37
### `com.icatch.golive.net.ApiCaller$ProgressRequestBody$ProgressSink`
L40 · [class] private ProgressSink · extends `ForwardingSink` · `com/icatch/golive/net/ApiCaller.java`

字段/常量（2）：
- `long bytesWritten`  L41
- `long totalBytes`  L42

方法（1）：
- `void write(Buffer buffer, long j)`  L49 @Override
### `com.icatch.golive.net.ConnectDeviceManager`
L20 · [class] public ConnectDeviceManager · `com/icatch/golive/net/ConnectDeviceManager.java`

字段/常量（32）：
- `String TAG = "ConnectDeviceManager"`  L21
- `ConnectDeviceManager instance`  L22
- `int pingSuccess = 200`  L23
- `int pingFailed = 100`  L24
- `IntegratedCircuit ic = null`  L25
- `Handler handlerHeartbeatPackage = null`  L26
- `String device_ssid = "<binary/metadata>"`  L27
- `int failure_connect_count = 0`  L28
- `int i = connectDeviceManager.failure_connect_count`  L34
- `IntegratedCircuit integratedCircuit = this.ic`  L156
- `IntegratedCircuit integratedCircuit = this.ic`  L164
- `IntegratedCircuit integratedCircuit = this.ic`  L172
- `IntegratedCircuit integratedCircuit = this.ic`  L177
- `IntegratedCircuit integratedCircuit = this.ic`  L185
- `IntegratedCircuit integratedCircuit = this.ic`  L190
- `IntegratedCircuit integratedCircuit = this.ic`  L198
- `IntegratedCircuit integratedCircuit = this.ic`  L203
- `IntegratedCircuit integratedCircuit = this.ic`  L211
- `IntegratedCircuit integratedCircuit = this.ic`  L219
- `IntegratedCircuit integratedCircuit = this.ic`  L227
- `IntegratedCircuit integratedCircuit = this.ic`  L235
- `String str2`  L263
- `StringBuilder sb`  L264
- `IntegratedCircuit integratedCircuit = this.ic`  L289
- `IntegratedCircuit integratedCircuit = this.ic`  L297
- `IntegratedCircuit integratedCircuit = this.ic`  L305
- `IntegratedCircuit integratedCircuit = this.ic`  L313
- `IntegratedCircuit integratedCircuit = this.ic`  L321
- `IntegratedCircuit integratedCircuit = this.ic`  L353
- `boolean $assertionsDisabled = false`  L363
- `IntegratedCircuit integratedCircuit = this.ic`  L393
- `IntegratedCircuit integratedCircuit = this.ic`  L401

方法（43）：
- `private ConnectDeviceManager()`  L30
- `int access$008(ConnectDeviceManager connectDeviceManager)`  L33
- `ConnectDeviceManager getInstance()`  L39
- `void initDevice(final Handler handler)`  L46
    - 体内字面量："192.168.1.254"
- `void handleMessage(Message message)`  L51 @Override
    - 体内字面量："192.168.169.1"
- `void handleMessage(Message message)`  L65 @Override
- `void ping(final String str, final Handler handler)`  L79
- `void run()`  L82 @Override
- `void try2connectLyIC(final Handler handler)`  L89
- `void handleMessage(Message message)`  L93 @Override
    - 体内字面量："LyIC init -> Failure" · "LyIC init state, device_ssid = "
- `void try2connectLywyzIC(final Handler handler)`  L112
- `void handleMessage(Message message)`  L116 @Override
    - 体内字面量："LyCmdWithYzIC init -> Failure" · "LyCmdWithYzIC init -> Success, device_ssid = "
- `void try2connectYzIC(final Handler handler)`  L136
- `void handleMessage(Message message)`  L140 @Override
    - 体内字面量："QzIC init -> Failure" · "QzIC init -> Success, device_ssid = "
- `void clearIC()`  L155
- `void clickLive(Handler handler, boolean z)`  L163
- `String getBackCamLiveURL()`  L171
- `void getBatteryState(Handler handler)`  L176
- `String getCurrentICName()`  L184
- `void getFileList(String str, Handler handler)`  L189
- `String getFrontCamLiveURL()`  L197
- `long getHeartbeatPeriod()`  L202
- `void getMoreFileList(Handler handler)`  L210
- `void getRecDuration(Handler handler)`  L218
- `void getRecResolution(Handler handler)`  L226
- `void getSSID(final Handler handler)`  L234
- `void handleMessage(Message message)`  L241 @Override
    - 体内字面量："ic.getSSID ic is null" · "ic.getSSID -> Failure" · "ic.getSSID -> Success, device_ssid = "
- `void m501lambda$ping$0$comicatchgolivenetConnectDeviceManager(String str, Handler handler)`  L262
- `void leaveRemoteFile()`  L288
- `void quit2RemoteFile(Handler handler)`  L296
- `void ready2CamLive(Handler handler)`  L304
- `void ready2RemoteFile(Handler handler)`  L312
- `void sendHeartbeatPackage()`  L320
- `void handleMessage(Message message)`  L327 @Override
- `void run()`  L333 @Override
- `void startHeartbeatPackage()`  L339
- `void stopHeartbeatPackage()`  L347
- `void stopMovieRecordToSettings(Handler handler)`  L352
- `void syncAreaByIP(final Context context)`  L360
    - 体内字面量："initAreaByIP start" · "https://www.id221.com/api/app/firmware/area_check"
- `void onFailure(Call call, IOException iOException)`  L366 @Override
    - 体内字面量："initAreaByIP failure mRequestCode:"
- `void onResponse(Call call, Response response)`  L371 @Override
    - 体内字面量："01 initAreaByIP str_result = " · "code" · "code" · "data" · "data" · "area_support" · "area_support" · "01 initAreaByIP str_area_support = " · "initAreaByIP end str_user_area = "
- `void syncLocalTime(Handler handler)`  L392
- `void takePicture(Handler handler)`  L400
### `com.icatch.golive.net.HttpDownListener`
L8 · [interface] public HttpDownListener · `com/icatch/golive/net/HttpDownListener.java`

方法（2）：
- `void onFailure(Call call, IOException iOException)`  L9
- `void onResponse(Call call, Response response, long j, long j2)`  L11
### `com.icatch.golive.net.IntegratedCircuit`
L6 · [class] public abstract IntegratedCircuit · `com/icatch/golive/net/IntegratedCircuit.java`

方法（22）：
- `void clearIC()`  L7
- `void clickLive(Handler handler, boolean z)`  L9
- `String getBackCamLiveURL()`  L11
- `void getBatteryState(Handler handler)`  L13
- `String getCurrentICName()`  L15
- `void getFileList(String str, Handler handler)`  L17
- `String getFrontCamLiveURL()`  L19
- `long getHeartbeatPeriod()`  L21
- `void getMoreFileList(Handler handler)`  L23
- `void getRecDuration(Handler handler)`  L25
- `void getRecResolution(Handler handler)`  L27
- `void getSSID(Handler handler)`  L29
- `void leaveRemoteFile()`  L31
- `void quit2RemoteFile(Handler handler)`  L33
- `void ready2CamLive(Handler handler)`  L35
- `void ready2RemoteFile(Handler handler)`  L37
- `void sendFailureMessage(Handler handler)`  L39
- `void sendHeartbeatPackage(Handler handler)`  L43
- `void sendSuccessMessage(Handler handler, Object obj)`  L45
- `void stopMovieRecordToSettings(Handler handler)`  L53
- `void syncLocalTime(Handler handler)`  L55
- `void takePicture(Handler handler)`  L57
### `com.icatch.golive.net.LyCmdWithYzIC`
L22 · [class] public LyCmdWithYzIC · extends `IntegratedCircuit` · `com/icatch/golive/net/LyCmdWithYzIC.java`

字段/常量（5）：
- `String TAG = "QzIntegratedCircuit"`  L23
- `int load_start_index = 0`  L24
- `int load_end_index = 99`  L25
- `int i = this.load_end_index`  L224
- `String string = "<binary/metadata>"`  L330

方法（45）：
- `void handleFileType(String str, JSONObject jSONObject, List<FileInfo> list, Handler handler)`  L75
    - 体内字面量："files" · "name" · "duration" · "createtime" · "createtimestr" · "type" · "http://192.168.1.254:80"
- `int compare(Object obj, Object obj2)`  L84 @Override
- `void handleRecResolutionValue(Handler handler, String str)`  L100
- `void startMovieRecord(final Handler handler)`  L114
- `void handleMessage(Message message)`  L117 @Override
- `void toSettings(final Handler handler)`  L129
- `void handleMessage(Message message)`  L132 @Override
- `void clearIC()`  L144 @Override
- `void clickLive(final Handler handler, boolean z)`  L148 @Override
- `void handleMessage(Message message)`  L151 @Override
- `String getBackCamLiveURL()`  L163 @Override
    - 体内字面量："rtsp://192.168.1.254"
- `void getBatteryState(Handler handler)`  L168 @Override
- `String getCurrentICName()`  L172 @Override
    - 体内字面量："QzIntegratedCircuit"
- `void getFileList(String str, Handler handler)`  L177 @Override
- `String getFrontCamLiveURL()`  L182 @Override
    - 体内字面量："rtsp://192.168.1.254"
- `long getHeartbeatPeriod()`  L187 @Override
- `void getItemsRecResolution(final Handler handler, final int i)`  L191
- `void handleMessage(Message message)`  L194 @Override
    - 体内字面量："result" · "info" · "items"
- `void getMoreFileList(final Handler handler)`  L223 @Override
- `void handleMessage(Message message)`  L229 @Override
    - 体内字面量："QzIntegratedCircuit" · "getFileList str_result -> " · "result" · "info" · "folder"
- `void getRecDuration(final Handler handler)`  L262 @Override
- `void handleMessage(Message message)`  L265 @Override
    - 体内字面量："result" · "info" · "duration"
- `void getRecResolution(final Handler handler)`  L286 @Override
- `void handleMessage(Message message)`  L289 @Override
    - 体内字面量："result" · "info"
- `void getSSID(final Handler handler)`  L310 @Override
- `void handleMessage(Message message)`  L313 @Override
    - 体内字面量："QzIntegratedCircuit" · "urlGetMediaInfo -> codeFailure" · "QzIntegratedCircuit" · "urlGetMediaInfo -> json_obj:"
- `void handleMessage(Message message)`  L324 @Override
- `void leaveRemoteFile()`  L349 @Override
- `void quit2RemoteFile(final Handler handler)`  L355 @Override
- `void handleMessage(Message message)`  L359 @Override
- `void handleMessage(Message message2)`  L366 @Override
- `void ready2CamLive(final Handler handler)`  L381 @Override
- `void handleMessage(Message message)`  L384 @Override
- `void handleMessage(Message message)`  L390 @Override
- `void ready2RemoteFile(final Handler handler)`  L402 @Override
- `void handleMessage(Message message)`  L405 @Override
- `void sendHeartbeatPackage(final Handler handler)`  L417 @Override
- `void handleMessage(Message message)`  L420 @Override
- `void stopMovieRecordToSettings(final Handler handler)`  L430 @Override
- `void handleMessage(Message message)`  L433 @Override
- `void syncLocalTime(final Handler handler)`  L445 @Override
    - 体内字面量："http://192.168.1.254/?custom=1&cmd=3005&str=" · "http://192.168.1.254/?custom=1&cmd=3006&str="
- `void handleMessage(Message message)`  L451 @Override
- `void handleMessage(Message message)`  L462 @Override
- `void takePicture(final Handler handler)`  L474 @Override
- `void handleMessage(Message message)`  L477 @Override
### `com.icatch.golive.net.LyCmdWithYzIC$AnonymousClass15`
L28 · [class] AnonymousClass15 · extends `Handler` · `com/icatch/golive/net/LyCmdWithYzIC.java`

字段/常量（1）：
- `Handler val$mHandle`  L29

方法（2）：
- `void handleMessage(Message message)`  L38 @Override
    - 体内字面量："QzIntegratedCircuit" · "getFileList str_result -> " · "status" · "list" · "REC" · "name" · "fpath" · "cover"
- `int compare(Object obj, Object obj2)`  L63 @Override
### `com.icatch.golive.net.LyIC`
L19 · [class] public LyIC · extends `IntegratedCircuit` · `com/icatch/golive/net/LyIC.java`

字段/常量（6）：
- `String TAG = "LyIntegratedCircuit"`  L20
- `String kReceivedLySocketMsg = "ReceivedLySocketMsg"`  L21
- `LySocketClient socketClient = null`  L22
- `String[] strArr = {"2160p@30fps", "1440p@30fps", "1080p@60fps", "1080p@30fps", "720p@60fps", "720p@30fps"}`  L41
- `LySocketClient lySocketClient = this.socketClient`  L144
- `String str = "2002"`  L251

方法（53）：
- `void getItemsRecResolution(final Handler handler, final String str)`  L25
- `void handleMessage(Message message)`  L28 @Override
- `void handleList3030(Handler handler, String str, List<String> list)`  L40
- `void rtStartMovieLive(final Handler handler)`  L53
- `void handleMessage(Message message)`  L56 @Override
- `void rtStartMovieRecord(final Handler handler)`  L68
- `void handleMessage(Message message)`  L71 @Override
- `void startMovieLive(final Handler handler)`  L83
- `void handleMessage(Message message)`  L86 @Override
- `void startMovieRecord(final Handler handler)`  L98
- `void handleMessage(Message message)`  L101 @Override
- `void stopMovieLive(final Handler handler)`  L113
- `void handleMessage(Message message)`  L116 @Override
- `void stopMovieRecord(final Handler handler)`  L128
- `void handleMessage(Message message)`  L131 @Override
- `void clearIC()`  L143 @Override
- `void clickLive(final Handler handler, boolean z)`  L152 @Override
- `void handleMessage(Message message)`  L155 @Override
- `String getBackCamLiveURL()`  L167 @Override
    - 体内字面量："rtsp://192.168.1.254"
- `void getBatteryState(final Handler handler)`  L172 @Override
- `void handleMessage(Message message)`  L175 @Override
    - 体内字面量："Value" · "Value" · "getBatteryState -> value = "
- `String getCurrentICName()`  L189 @Override
- `void getFileList(final String str, final Handler handler)`  L194 @Override
- `void handleMessage(Message message)`  L197 @Override
    - 体内字面量："/Movie/" · "/SOS/" · "/Photo/"
- `String getFrontCamLiveURL()`  L219 @Override
    - 体内字面量："rtsp://192.168.1.254"
- `long getHeartbeatPeriod()`  L224 @Override
- `void getMoreFileList(Handler handler)`  L229 @Override
- `void getRecDuration(final Handler handler)`  L233 @Override
- `void handleMessage(Message message)`  L236 @Override
    - 体内字面量："Value" · "Value" · "getRecordingTime -> value = "
- `void getRecResolution(final Handler handler)`  L250 @Override
- `void handleMessage(Message message)`  L254 @Override
- `void getSSID(final Handler handler)`  L266 @Override
- `void handleMessage(Message message)`  L269 @Override
    - 体内字面量："SSID" · "PASSPHRASE" · "SSID" · "PASSPHRASE" · "getSSID -> value_ssid:" · " \n value_pwd:"
- `void initSocket()`  L285
    - 体内字面量："192.168.1.254"
- `void leaveRemoteFile()`  L294 @Override
- `void handleMessage(Message message)`  L297 @Override
- `void handleMessage(Message message2)`  L301 @Override
- `void handleMessage(Message message3)`  L305 @Override
- `void quit2RemoteFile(final Handler handler)`  L317 @Override
- `void handleMessage(Message message)`  L320 @Override
- `void ready2CamLive(final Handler handler)`  L332 @Override
- `void handleMessage(Message message)`  L335 @Override
- `void ready2RemoteFile(final Handler handler)`  L347 @Override
- `void handleMessage(Message message)`  L350 @Override
- `void sendHeartbeatPackage(final Handler handler)`  L362 @Override
- `void handleMessage(Message message)`  L365 @Override
- `void stopMovieRecordToSettings(final Handler handler)`  L375 @Override
- `void handleMessage(Message message)`  L378 @Override
- `void syncLocalTime(final Handler handler)`  L390 @Override
    - 体内字面量："http://192.168.1.254/?custom=1&cmd=3005&str=" · "http://192.168.1.254/?custom=1&cmd=3006&str="
- `void handleMessage(Message message)`  L396 @Override
- `void handleMessage(Message message)`  L407 @Override
- `void takePicture(final Handler handler)`  L419 @Override
- `void handleMessage(Message message)`  L422 @Override
### `com.icatch.golive.net.LySocketClient`
L22 · [class] public LySocketClient · `com/icatch/golive/net/LySocketClient.java`

字段/常量（10）：
- `String TAG = "LySocketClient"`  L23
- `InputStream inputStream`  L24
- `Socket socket`  L25
- `boolean isConnected = false`  L26
- `int i`  L45
- `byte[] bArr = new byte[1024]`  L49
- `InputStream inputStream = this.inputStream`  L96
- `Socket socket = this.socket`  L100
- `Socket socket`  L112
- `Socket socket = this.socket`  L119

方法（11）：
- `void lambda$receiveMessages$2(String str)`  L30
    - 体内字面量："Received message: " · "Cmd" · "Status" · "Cmd" · "Status" · "Cmd" · "Status"
- `void receiveMessages()`  L44
- `void run()`  L56 @Override
- `void run()`  L65 @Override
    - 体内字面量："mainHandler Connection closed by server"
- `void run()`  L73 @Override
    - 体内字面量："mainHandler errorMsg: "
- `void connectAndReceive(final String str, final int i)`  L83
- `void run()`  L86 @Override
    - 体内字面量："connectAndReceive host = " · "; port = "
- `void disconnect()`  L93
- `boolean isConnected()`  L111
- `void m502lambda$connectAndReceive$1$comicatchgolivenetLySocketClient(String str, int i)`  L117
- `void run()`  L133 @Override
    - 体内字面量："Connection error: "
### `com.icatch.golive.net.LyWyzRequestInfo`
L4 · [class] public LyWyzRequestInfo · `com/icatch/golive/net/LyWyzRequestInfo.java`

字段/常量（44）：
- `String urPhtotCapture = "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=1100&par=0"`  L5
- `String urlCmdReady2RemoteFile = "http://192.168.1.254/?custom=1&cmd=2001,8010,3001&str=0,0,10"`  L6
- `String urlDeleteOneFile = "http://192.168.1.254/app/deletefile?file="`  L7
- `String urlFileEmrList = "http://192.168.1.254/app/getfilelist?folder=emr&start=0&end=99999"`  L8
- `String urlFileList = "http://192.168.1.254/app/getfilelist?folder=loop"`  L9
- `String urlFileListAll = "http://192.168.1.254/?custom=1&cmd=3015&str=REC"`  L10
- `String urlFilePhotoList = "http://192.168.1.254/app/getfilelist?folder=event&start=0&end=99999"`  L11
- `String urlFormat = "http://192.168.1.254/app/sdformat"`  L12
- `String urlGetCapability = "http://192.168.1.254/app/capability"`  L13
- `String urlGetDeviceStatus = "http://192.168.1.254/api/getdeviceinfo/?custom=1&cmd=2002"`  L14
- `String urlGetItemsRecResolution = "http://192.168.1.254/app/getparamitems?param=rec_resolution"`  L15
- `String urlGetMediaInfo = "http://192.168.1.254/app/getmediainfo"`  L16
- `String urlGetParamItems = "http://192.168.1.254/app/getparamitems?param=all"`  L17
- `String urlGetParamValueAll = "http://192.168.1.254/app/getparamvalue?param=all"`  L18
- `String urlGetProductInfo = "http://192.168.1.254/app/getproductinfo?"`  L19
- `String urlGetRecDuration = "http://192.168.1.254/app/getrecduration"`  L20
- `String urlGetSDInfo = "http://192.168.1.254/app/getsdinfo"`  L21
- `String urlGetSDcardStatus = "http://192.168.1.254/api/getdeviceinfo/?custom=1&cmd=2004"`  L22
- `String urlGetSSID = "http://192.168.1.254/app/getdeviceattr"`  L23
- `String urlGetValueRecResolution = "http://192.168.1.254/app/getparamvalue?param=rec_resolution"`  L24
- `String urlHOST = "http://192.168.1.254/"`  L25
- `String urlHeartbeatPackage = "http://192.168.1.254/app/getparamvalue?param=rec"`  L26
- `String urlHeartbeatStart = "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=4016&par=1"`  L27
- `String urlModeChangeOther = "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=3033&par=1"`  L28
- `String urlModePlaybackEnter = "http://192.168.1.254/app/playback?param=enter"`  L29
- `String urlModePlaybackExit = "http://192.168.1.254/app/playback?param=exit"`  L30
- `String urlModeRecorderEnter = "http://192.168.1.254/app/enterrecorder"`  L31
- `String urlModeRecorderExit = "http://192.168.1.254/app/exitrecorder"`  L32
- `String urlModeSettingEnter = "http://192.168.1.254/app/setting?param=enter"`  L33
- `String urlModeSettingExit = "http://192.168.1.254/app/setting?param=exit"`  L34
- `String urlMovieRecordStart = "http://192.168.1.254/?custom=1&cmd=2001&str=1"`  L35
- `String urlMovieRecordStop = "http://192.168.1.254/?custom=1&cmd=2001&str=0"`  L36
- `String urlQueryMenuItem = "http://192.168.1.254/api/getdeviceinfo/?custom=1&cmd=3031"`  L37
- `String urlReconnectWiFi = "http://192.168.1.254/app/wifireboot"`  L38
- `String urlSetDate = "http://192.168.1.254/?custom=1&cmd=3005&str="`  L39
- `String urlSetLanguageEn = "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=1008&par=1"`  L40
- `String urlSetLanguageZh = "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=1008&par=0"`  L41
- `String urlSetTime = "http://192.168.1.254/?custom=1&cmd=3006&str="`  L42
- `String urlSettingBase = "http://192.168.1.254/app/setwifi?"`  L43
- `String urlSettingParamValue = "http://192.168.1.254/app/setparamvalue?"`  L44
- `String urlSwitchBackCam = "http://192.168.1.254/app/setparamvalue?param=switchcam&value=1"`  L45
- `String urlSwitchFrontCam = "http://192.168.1.254/app/setparamvalue?param=switchcam&value=0"`  L46
- `String urlSystemReset = "http://192.168.1.254/app/reset"`  L47
- `String urlTriggerRAWencode = "http://192.168.1.254/app/snapshot"`  L48
### `com.icatch.golive.net.M1RequestInfo`
L4 · [class] public M1RequestInfo · `com/icatch/golive/net/M1RequestInfo.java`

字段/常量（42）：
- `String urPhtotCapture = "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=1100&par=0"`  L5
- `String urlDeleteOneFile = "http://192.168.169.1/app/deletefile?file="`  L6
- `String urlFileEmrList = "http://192.168.169.1/app/getfilelist?folder=emr&start=0&end=99999"`  L7
- `String urlFileList = "http://192.168.169.1/app/getfilelist?folder=loop"`  L8
- `String urlFilePhotoList = "http://192.168.169.1/app/getfilelist?folder=event&start=0&end=99999"`  L9
- `String urlFormat = "http://192.168.169.1/app/sdformat"`  L10
- `String urlGetCapability = "http://192.168.169.1/app/capability"`  L11
- `String urlGetDeviceStatus = "http://192.168.169.1/api/getdeviceinfo/?custom=1&cmd=2002"`  L12
- `String urlGetItemsRecResolution = "http://192.168.169.1/app/getparamitems?param=rec_resolution"`  L13
- `String urlGetMediaInfo = "http://192.168.169.1/app/getmediainfo"`  L14
- `String urlGetParamItems = "http://192.168.169.1/app/getparamitems?param=all"`  L15
- `String urlGetParamValueAll = "http://192.168.169.1/app/getparamvalue?param=all"`  L16
- `String urlGetProductInfo = "http://192.168.169.1/app/getproductinfo?"`  L17
- `String urlGetRecDuration = "http://192.168.169.1/app/getrecduration"`  L18
- `String urlGetSDInfo = "http://192.168.169.1/app/getsdinfo"`  L19
- `String urlGetSDcardStatus = "http://192.168.169.1/api/getdeviceinfo/?custom=1&cmd=2004"`  L20
- `String urlGetSSID = "http://192.168.169.1/app/getdeviceattr"`  L21
- `String urlGetValueRecResolution = "http://192.168.169.1/app/getparamvalue?param=rec_resolution"`  L22
- `String urlHOST = "http://192.168.169.1/"`  L23
- `String urlHeartbeatPackage = "http://192.168.169.1/app/getparamvalue?param=rec"`  L24
- `String urlHeartbeatStart = "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=4016&par=1"`  L25
- `String urlModeChangeOther = "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=3033&par=1"`  L26
- `String urlModePlaybackEnter = "http://192.168.169.1/app/playback?param=enter"`  L27
- `String urlModePlaybackExit = "http://192.168.169.1/app/playback?param=exit"`  L28
- `String urlModeRecorderEnter = "http://192.168.169.1/app/enterrecorder"`  L29
- `String urlModeRecorderExit = "http://192.168.169.1/app/exitrecorder"`  L30
- `String urlModeSettingEnter = "http://192.168.169.1/app/setting?param=enter"`  L31
- `String urlModeSettingExit = "http://192.168.169.1/app/setting?param=exit"`  L32
- `String urlMovieRecordStart = "http://192.168.169.1/app/setparamvalue?param=rec&value=1"`  L33
- `String urlMovieRecordStop = "http://192.168.169.1/app/setparamvalue?param=rec&value=0"`  L34
- `String urlQueryMenuItem = "http://192.168.169.1/api/getdeviceinfo/?custom=1&cmd=3031"`  L35
- `String urlReconnectWiFi = "http://192.168.169.1/app/wifireboot"`  L36
- `String urlSetDate = "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=3005&str="`  L37
- `String urlSetLanguageEn = "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=1008&par=1"`  L38
- `String urlSetLanguageZh = "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=1008&par=0"`  L39
- `String urlSetTime = "http://192.168.169.1/app/setsystime?date="`  L40
- `String urlSettingBase = "http://192.168.169.1/app/setwifi?"`  L41
- `String urlSettingParamValue = "http://192.168.169.1/app/setparamvalue?"`  L42
- `String urlSwitchBackCam = "http://192.168.169.1/app/setparamvalue?param=switchcam&value=1"`  L43
- `String urlSwitchFrontCam = "http://192.168.169.1/app/setparamvalue?param=switchcam&value=0"`  L44
- `String urlSystemReset = "http://192.168.169.1/app/reset"`  L45
- `String urlTriggerRAWencode = "http://192.168.169.1/app/snapshot"`  L46
### `com.icatch.golive.net.OkHttpDownUtil`
L21 · [class] public OkHttpDownUtil · `com/icatch/golive/net/OkHttpDownUtil.java`

字段/常量（19）：
- `String TAG = "OkHttpDownUtil"`  L22
- `Call mCall`  L23
- `String mDownUrl`  L24
- `HttpDownListener mHttpDownListener`  L25
- `JSONObject mJson`  L26
- `File mPath`  L27
- `long mAlreadyDownLength = 0`  L28
- `long mTotalLength = 0`  L29
- `int mSign = 0`  L30
- `File file = this.mPath`  L37
- `Call call = this.mCall`  L53
- `byte[] bArr = new byte[2048]`  L90
- `StringBuilder sb`  L132
- `byte[] bArr = new byte[2048]`  L143
- `byte[] bArr = new byte[2048]`  L205
- `StringBuilder sb`  L254
- `byte[] bArr = new byte[2048]`  L265
- `int i = this.mSign`  L303
- `Call call = this.mCall`  L324

方法（17）：
- `RequestBody changeJSON(JSONObject jSONObject)`  L32
    - 体内字面量："application/json; charset=utf-8"
- `void deleteCurrentFile()`  L36
- `void destroy()`  L52
- `void getDownRequest(String str, File file, HttpDownListener httpDownListener)`  L66
- `void onFailure(Call call, IOException iOException)`  L77 @Override
- `void onResponse(Call call, Response response)`  L84 @Override
- `void getRenewalDownRequest(String str, File file, HttpDownListener httpDownListener)`  L113
    - 体内字面量："RANGE" · "bytes=" · "-"
- `void onFailure(Call call, IOException iOException)`  L123 @Override
    - 体内字面量："onFailure: å¼å¸¸æ¥é="
- `void onResponse(Call call, Response response)`  L131 @Override
- `void postDownRequest(String str, File file, JSONObject jSONObject, HttpDownListener httpDownListener)`  L181
- `void onFailure(Call call, IOException iOException)`  L193 @Override
- `void onResponse(Call call, Response response)`  L200 @Override
- `void postRenewalDownRequest(String str, File file, JSONObject jSONObject, HttpDownListener httpDownListener)`  L235
    - 体内字面量："RANGE" · "bytes=" · "-"
- `void onFailure(Call call, IOException iOException)`  L246 @Override
- `void onResponse(Call call, Response response)`  L253 @Override
- `void resume()`  L302
- `void stop()`  L323
### `com.icatch.golive.net.QzIC`
L23 · [class] public QzIC · extends `IntegratedCircuit` · `com/icatch/golive/net/QzIC.java`

字段/常量（5）：
- `String TAG = "QzIntegratedCircuit"`  L24
- `int load_start_index = 0`  L25
- `int load_end_index = 99`  L26
- `String str2`  L179
- `int i = this.load_end_index`  L284

方法（49）：
- `void handleDeviceSdStatus(final Handler handler, String str)`  L29
    - 体内字面量："info" · "status"
- `void handleMessage(Message message)`  L34 @Override
    - 体内字面量："result" · "info" · "duration"
- `void handleFileType(String str, JSONObject jSONObject, List<FileInfo> list, Handler handler)`  L61
    - 体内字面量："files" · "name" · "duration" · "createtime" · "createtimestr" · "type" · "http://192.168.169.1:80"
- `int compare(Object obj, Object obj2)`  L70 @Override
- `void handleRecResolutionValue(Handler handler, String str)`  L86
- `void startMovieRecord(final Handler handler)`  L100
- `void handleMessage(Message message)`  L103 @Override
- `void startPlaybackMode(final Handler handler)`  L115
- `void handleMessage(Message message)`  L118 @Override
- `void toSettings(final Handler handler)`  L130
- `void handleMessage(Message message)`  L133 @Override
- `void clearIC()`  L145 @Override
- `void clickLive(final Handler handler, boolean z)`  L149 @Override
- `void handleMessage(Message message)`  L152 @Override
- `String getBackCamLiveURL()`  L164 @Override
    - 体内字面量："rtsp://192.168.169.1"
- `void getBatteryState(Handler handler)`  L169 @Override
- `String getCurrentICName()`  L173 @Override
    - 体内字面量："QzIntegratedCircuit"
- `void getFileList(final String str, final Handler handler)`  L178 @Override
- `void handleMessage(Message message)`  L195 @Override
    - 体内字面量："QzIntegratedCircuit" · "getFileList str_result -> " · "result" · "info" · "folder" · "loop" · "emr"
- `String getFrontCamLiveURL()`  L233 @Override
    - 体内字面量："rtsp://192.168.169.1"
- `long getHeartbeatPeriod()`  L238 @Override
- `void getItemsRecResolution(final Handler handler, final int i)`  L242
- `void handleMessage(Message message)`  L245 @Override
    - 体内字面量："result" · "info" · "name" · "rec_resolution" · "QzIntegratedCircuit" · "getItemsRecResolution json_info -> " · "items" · "@"
- `void getMoreFileList(final Handler handler)`  L283 @Override
- `void handleMessage(Message message)`  L289 @Override
    - 体内字面量："QzIntegratedCircuit" · "getFileList str_result -> " · "result" · "info" · "folder"
- `void getRecDuration(final Handler handler)`  L322 @Override
- `void handleMessage(Message message)`  L325 @Override
    - 体内字面量："QzIntegratedCircuit" · "urlGetSDInfo str_result = "
- `void getRecResolution(final Handler handler)`  L338 @Override
- `void handleMessage(Message message)`  L341 @Override
    - 体内字面量："result" · "info"
- `void getSSID(final Handler handler)`  L362 @Override
- `void handleMessage(Message message)`  L365 @Override
    - 体内字面量："QzIntegratedCircuit" · "urlGetMediaInfo -> codeFailure" · "QzIntegratedCircuit" · "getSSID -> urlGetMediaInfo.json_obj:"
- `void handleMessage(Message message)`  L380 @Override
    - 体内字面量："QzIntegratedCircuit" · "getSSID -> urlGetSSID.json_obj:" · "info" · "ssid"
- `void leaveRemoteFile()`  L398 @Override
- `void quit2RemoteFile(final Handler handler)`  L404 @Override
- `void handleMessage(Message message)`  L408 @Override
- `void handleMessage(Message message2)`  L415 @Override
- `void ready2CamLive(final Handler handler)`  L430 @Override
- `void handleMessage(Message message)`  L433 @Override
- `void handleMessage(Message message)`  L439 @Override
- `void ready2RemoteFile(final Handler handler)`  L451 @Override
- `void handleMessage(Message message)`  L454 @Override
- `void sendHeartbeatPackage(final Handler handler)`  L466 @Override
- `void handleMessage(Message message)`  L469 @Override
- `void stopMovieRecordToSettings(final Handler handler)`  L479 @Override
- `void handleMessage(Message message)`  L482 @Override
- `void syncLocalTime(final Handler handler)`  L494 @Override
    - 体内字面量："-" · ":"
- `void handleMessage(Message message)`  L498 @Override
- `void takePicture(final Handler handler)`  L510 @Override
- `void handleMessage(Message message)`  L513 @Override
### `com.icatch.golive.net.RequestInfo`
L4 · [class] public RequestInfo · `com/icatch/golive/net/RequestInfo.java`

字段/常量（62）：
- `int codeFailure = 404`  L5
- `int codeGetSSID = 20001`  L6
- `int codeSuccess = 200`  L7
- `String urPhtotCapture = "http://192.168.1.254/?custom=1&cmd=1001"`  L8
- `String urPhtotCaptureSize10M = "http://192.168.1.254/?custom=1&cmd=1002&par=1"`  L9
- `String urPhtotCaptureSize12M = "http://192.168.1.254/?custom=1&cmd=1002&par=0"`  L10
- `String urPhtotCaptureSize5M = "http://192.168.1.254/?custom=1&cmd=1002&par=3"`  L11
- `String urPhtotCaptureSize8M = "http://192.168.1.254/?custom=1&cmd=1002&par=2"`  L12
- `String urlAddIdCamFeedback = "https://api.idalbum.com/album.php/api/addIdCamFeedback"`  L13
- `String urlCyclicRecordCustom = "http://192.168.1.254/?custom=1&cmd=2003&par="`  L14
- `String urlDeleteAll = "http://192.168.1.254/?custom=1&cmd=4004"`  L15
- `String urlDeleteOneFile = "http://192.168.1.254/?custom=1&cmd=4003&str="`  L16
- `String urlFileList = "http://192.168.1.254/?custom=1&cmd=3015"`  L17
- `String urlFormat = "http://192.168.1.254/?custom=1&cmd=3010&par=1"`  L18
- `String urlGSensorHigh = "http://192.168.1.254/?custom=1&cmd=2011&par=3"`  L19
- `String urlGSensorIdMax = "http://192.168.1.254/?custom=1&cmd=2011&par=4"`  L20
- `String urlGSensorLow = "http://192.168.1.254/?custom=1&cmd=2011&par=1"`  L21
- `String urlGSensorMed = "http://192.168.1.254/?custom=1&cmd=2011&par=2"`  L22
- `String urlGSensorOff = "http://192.168.1.254/?custom=1&cmd=2011&par=0"`  L23
- `String urlGetBatteryState = "http://192.168.1.254/?custom=1&cmd=8013"`  L24
- `String urlGetCardStatus = "http://192.168.1.254/?custom=1&cmd=3024"`  L25
- `String urlGetCustomerServiceInfo = "http://api.idstore.idalbum.com/api/getCustomerServiceInfo"`  L26
- `String urlGetFreeSpace = "http://192.168.1.254/?custom=1&cmd=3017"`  L27
- `String urlGetHeadphoneState = "http://192.168.1.254/?custom=1&cmd=8012"`  L28
- `String urlGetIdCamSoftwareVersionInfo = "https://api.idalbum.com/album.php/api/getIdCamSoftwareVersionInfo"`  L29
- `String urlGetMoveSizeCapacity = "http://192.168.1.254/?custom=1&cmd=3030"`  L30
- `String urlGetRAWencodeJPEG = "http://192.168.1.254/?custom=1&cmd=2018"`  L31
- `String urlGetSSID = "http://192.168.1.254/?custom=1&cmd=3029"`  L32
- `String urlGetVersion = "http://192.168.1.254/?custom=1&cmd=3012"`  L33
- `String urlHOST = "http://192.168.1.254/"`  L34
- `String urlHeartbeatPackage = "http://192.168.1.254/?custom=1&cmd=8888"`  L35
- `String urlHeartbeatPackage2 = "http://192.168.1.254/?custom=1&cmd=3016"`  L36
- `String urlLensRotationOff = "http://192.168.1.254/?custom=1&cmd=3044&par=0"`  L37
- `String urlLensRotationOn = "http://192.168.1.254/?custom=1&cmd=3044&par=1"`  L38
- `String urlMicrophoneModeHeadphone = "http://192.168.1.254/?custom=1&cmd=8010&par=1"`  L39
- `String urlMicrophoneModeNoumenon = "http://192.168.1.254/?custom=1&cmd=8010&par=0"`  L40
- `String urlModeChangeMovie = "http://192.168.1.254/?custom=1&cmd=3001&par=1"`  L41
- `String urlModeChangePhoto = "http://192.168.1.254/?custom=1&cmd=3001&par=0"`  L42
- `String urlModeChangePlayback = "http://192.168.1.254/?custom=1&cmd=3001&par=2"`  L43
- `String urlMovieLiveStart = "http://192.168.1.254/?custom=1&cmd=2015&par=1"`  L44
- `String urlMovieLiveStop = "http://192.168.1.254/?custom=1&cmd=2015&par=0"`  L45
- `String urlMovieRecordSizeCustom = "http://192.168.1.254/?custom=1&cmd=2002&par="`  L46
- `String urlMovieRecordStart = "http://192.168.1.254/?custom=1&cmd=2001&par=1"`  L47
- `String urlMovieRecordStop = "http://192.168.1.254/?custom=1&cmd=2001&par=0"`  L48
- `String urlMovieRecordingTime = "http://192.168.1.254/?custom=1&cmd=2016"`  L49
- `String urlQueryCurrentStatus = "http://192.168.1.254/?custom=1&cmd=3014"`  L50
- `String urlQueryMenuItem = "http://192.168.1.254/?custom=1&cmd=3031&str=all"`  L51
- `String urlQueryStatus = "http://192.168.1.254/?custom=1&cmd="`  L52
- `String urlReconnectWiFi = "http://192.168.1.254/?custom=1&cmd=3018"`  L53
- `String urlRecordAudioOff = "http://192.168.1.254/?custom=1&cmd=8011&par=0"`  L54
- `String urlRecordAudioOn = "http://192.168.1.254/?custom=1&cmd=8011&par=1"`  L55
- `String urlSaveMenuSettings = "http://192.168.1.254/?custom=1&cmd=3021"`  L56
- `String urlSetDate = "http://192.168.1.254/?custom=1&cmd=3005&str="`  L57
- `String urlSetPassphrase = "http://192.168.1.254/?custom=1&cmd=3004&str="`  L58
- `String urlSetSSID = "http://192.168.1.254/?custom=1&cmd=3003&str="`  L59
- `String urlSetTime = "http://192.168.1.254/?custom=1&cmd=3006&str="`  L60
- `String urlSystemReset = "http://192.168.1.254/?custom=1&cmd=3011"`  L61
- `String urlTimeImprintOff = "http://192.168.1.254/?custom=1&cmd=2008&par=0"`  L62
- `String urlTimeImprintOn = "http://192.168.1.254/?custom=1&cmd=2008&par=1"`  L63
- `String urlTriggerRAWencode = "http://192.168.1.254/?custom=1&cmd=2017"`  L64
- `String urlWDROff = "http://192.168.1.254/?custom=1&cmd=2004&par=0"`  L65
- `String urlWDROn = "http://192.168.1.254/?custom=1&cmd=2004&par=1"`  L66