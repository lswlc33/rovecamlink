# idGoLive — 类与成员明细：com.icatch.golive.MyCamera

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 7 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.MyCamera.CameraAddType`
L4 · [class] public CameraAddType · `com/icatch/golive/MyCamera/CameraAddType.java`

字段/常量（5）：
- `int BT_CONNECTION = 4`  L5
- `int DEFAULT = 0`  L6
- `int USB_CONNECTION = 3`  L7
- `int WIFI_CONNECTION_AUTO = 1`  L8
- `int WIFI_CONNECTION_MANUAL = 2`  L9
### `com.icatch.golive.MyCamera.CameraManager`
L6 · [class] public CameraManager · `com/icatch/golive/MyCamera/CameraManager.java`

字段/常量（5）：
- `CameraManager instance`  L7
- `String TAG = "CameraManager"`  L8
- `MyCamera curCamera`  L9
- `MyCamera myCamera`  L23
- `MyCamera myCamera`  L30

方法（5）：
- `CameraManager getInstance()`  L11
- `MyCamera createCamera(int i, String str, String str2, int i2, int i3, int i4, String str3)`  L22
- `MyCamera createUSBCamera(int i, UsbDevice usbDevice, int i2)`  L29
- `MyCamera getCurCamera()`  L36
- `void setCurCamera(MyCamera myCamera)`  L40
### `com.icatch.golive.MyCamera.CameraType`
L4 · [class] public CameraType · `com/icatch/golive/MyCamera/CameraType.java`

字段/常量（4）：
- `int OLD_WIFI_CAMERA = 3`  L5
- `int UNDEFIND_CAMERA = 0`  L6
- `int USB_CAMERA = 1`  L7
- `int WIFI_CAMERA = 2`  L8
### `com.icatch.golive.MyCamera.CommandSession`
L13 · [class] public CommandSession · `com/icatch/golive/MyCamera/CommandSession.java`

字段/常量（15）：
- `String TAG = "CommandSession"`  L14
- `int scanflag = 0`  L15
- `String tag = "CommandSession"`  L16
- `String ipAddress`  L17
- `String password`  L18
- `ICatchCameraSession session`  L19
- `boolean sessionPrepared = false`  L20
- `String uid`  L21
- `String username`  L22
- `boolean z = scanflag != 1`  L42
- `boolean zCheckConnection`  L48
- `Boolean boolValueOf = false`  L62
- `boolean zPrepareSession`  L78
- `boolean zPrepareSession`  L100
- `String str = TAG`  L118

方法（9）：
- `public CommandSession()`  L24
- `public CommandSession(String str, String str2, String str3, String str4)`  L27
- `boolean startDeviceScan()`  L34
    - 体内字面量："Start startDeviceScan" · "End startDeviceScan,tempStartDeviceScanValue=false"
- `void stopDeviceScan()`  L40
    - 体内字面量："Start stopDeviceScan"
- `boolean checkWifiConnection()`  L47
- `boolean destroySession()`  L60
    - 体内字面量："Start destroyPanoramaSession"
- `ICatchCameraSession getSession()`  L72
    - 体内字面量："getSDKSession ="
- `boolean prepareSession(ICatchITransport iCatchITransport)`  L77
- `boolean prepareSession(ICatchITransport iCatchITransport, boolean z)`  L99
### `com.icatch.golive.MyCamera.LocalSession`
L12 · [class] public LocalSession · `com/icatch/golive/MyCamera/LocalSession.java`

字段/常量（12）：
- `String TAG = "LocalSession"`  L13
- `LocalSession instance`  L14
- `CommandSession commandSession`  L15
- `ICatchCameraPlayback iCatchCameraPlayback`  L16
- `PanoramaControl panoramaControl`  L17
- `PanoramaPhotoPlayback panoramaPhotoPlayback`  L18
- `PanoramaSession panoramaSession`  L19
- `PanoramaVideoPlayback panoramaVideoPlayback`  L20
- `CommandSession commandSession = this.commandSession`  L33
- `boolean zDestroySession`  L43
- `String str = TAG`  L44
- `PanoramaSession panoramaSession = this.panoramaSession`  L46

方法（14）：
- `private LocalSession()`  L22
- `LocalSession getInstance()`  L25
- `boolean destroyCommandSession()`  L32
- `boolean destroyPanoramaSession()`  L42
- `CommandSession getCommandSession()`  L57
- `ICatchCameraPlayback getICatchCameraPlayback()`  L61
- `PanoramaControl getPanoramaControl()`  L65
- `PanoramaPhotoPlayback getPanoramaPhotoPlayback()`  L69
- `PanoramaSession getPanoramaSession()`  L73
- `PanoramaVideoPlayback getPanoramaVideoPlayback()`  L77
- `void initCommand()`  L81
- `void initPanorama()`  L89
- `boolean prepareCommandSession()`  L95
    - 体内字面量："192.168.1.1"
- `boolean preparePanoramaSession()`  L104
    - 体内字面量："192.168.1.1"
### `com.icatch.golive.MyCamera.MyCamera`
L28 · [class] public MyCamera · `com/icatch/golive/MyCamera/MyCamera.java`

字段/常量（29）：
- `String TAG`  L29
- `int addType`  L30
- `BaseProrertys baseProrertys`  L31
- `CameraAction cameraAction`  L32
- `CameraFixedInfo cameraFixedInfo`  L33
- `String cameraName`  L34
- `CameraProperties cameraProperties`  L35
- `CameraState cameraState`  L36
- `int cameraType`  L37
- `CommandSession commandSession`  L38
- `FileOperation fileOperation`  L39
- `String ipAddress`  L40
- `boolean isConnected`  L41
- `boolean isLoadThumbnail`  L42
- `boolean isStreamReady`  L43
- `int mode`  L44
- `boolean needInputPassword`  L45
- `PanoramaControl panoramaControl`  L46
- `PanoramaPhotoPlayback panoramaPhotoPlayback`  L47
- `PanoramaPreviewPlayback panoramaPreviewPlayback`  L48
- `PanoramaSession panoramaSession`  L49
- `PanoramaVideoPlayback panoramaVideoPlayback`  L50
- `int position`  L51
- `int timeLapsePreviewMode`  L52
- `ICatchITransport transport`  L53
- `UsbDevice usbDevice`  L54
- `String wifiPassword`  L55
- `boolean zPrepareSession = false`  L152
- `ICatchITransport iCatchITransport = this.transport`  L189

方法（29）：
- `public MyCamera(int i)`  L57
    - 体内字面量："MyCamera"
- `public MyCamera(int i, UsbDevice usbDevice, int i2)`  L67
    - 体内字面量："MyCamera" · "UsbDevice_"
- `public MyCamera(int i, String str)`  L82
    - 体内字面量："MyCamera"
- `public MyCamera(int i, String str, String str2, int i2, int i3, int i4, String str3)`  L93
    - 体内字面量："MyCamera"
- `boolean initCamera()`  L109
    - 体内字面量："Start initClient"
- `boolean connect(boolean z)`  L130
    - 体内字面量："connect cameraType=" · " enablePTPIP=" · "ICatchUVCBulkTransport IchInvalidArgumentException" · "getLocalIPAddressFromWifiInfo:"
- `boolean disconnect()`  L187
- `int getAddType()`  L204
- `BaseProrertys getBaseProrertys()`  L208
- `CameraAction getCameraAction()`  L212
- `CameraFixedInfo getCameraFixedInfo()`  L216
- `String getCameraName()`  L220
- `CameraProperties getCameraProperties()`  L224
- `CameraState getCameraState()`  L228
- `int getCameraType()`  L232
- `FileOperation getFileOperation()`  L236
- `int getMyMode()`  L240
- `PanoramaControl getPanoramaControl()`  L244
- `PanoramaPhotoPlayback getPanoramaPhotoPlayback()`  L248
- `PanoramaPreviewPlayback getPanoramaPreviewPlayback()`  L252
- `PanoramaSession getPanoramaSession()`  L256
- `PanoramaVideoPlayback getPanoramaVideoPlayback()`  L260
- `int getPosition()`  L264
- `CommandSession getSDKsession()`  L268
- `UsbDevice getUsbDevice()`  L272
- `String getWifiPassword()`  L276
- `boolean isConnected()`  L280
- `boolean isLoadThumbnail()`  L284
- `void setLoadThumbnail(boolean z)`  L288
### `com.icatch.golive.MyCamera.PanoramaSession`
L14 · [class] public PanoramaSession · `com/icatch/golive/MyCamera/PanoramaSession.java`

字段/常量（5）：
- `String TAG = "PanoramaSession"`  L15
- `ICatchPancamSession iCatchPancamSession`  L16
- `ICatchPancamSession iCatchPancamSession = this.iCatchPancamSession`  L19
- `boolean zDestroySession = false`  L20
- `boolean zPrepareSession`  L37

方法（3）：
- `boolean destroySession()`  L18
- `ICatchPancamSession getSession()`  L32
- `boolean prepareSession(ICatchITransport iCatchITransport)`  L36