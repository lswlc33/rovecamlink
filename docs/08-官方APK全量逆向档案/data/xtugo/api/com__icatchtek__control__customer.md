# XTU GO — 类与成员明细：com.icatchtek.control.customer

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 41 个文件 / 41 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.control.customer.exception.IchCameraModeException`
L4 · [class] public IchCameraModeException · extends `Exception` · `com/icatchtek/control/customer/exception/IchCameraModeException.java`

字段/常量（1）：
- `long serialVersionUID = 1`  L5

方法（2）：
- `public IchCameraModeException()`  L7
- `public IchCameraModeException(String str)`  L10
### `com.icatchtek.control.customer.exception.IchCaptureImageException`
L4 · [class] public IchCaptureImageException · extends `Exception` · `com/icatchtek/control/customer/exception/IchCaptureImageException.java`

字段/常量（1）：
- `long serialVersionUID = 1`  L5

方法（2）：
- `public IchCaptureImageException()`  L7
- `public IchCaptureImageException(String str)`  L10
### `com.icatchtek.control.customer.exception.IchDevicePropException`
L4 · [class] public IchDevicePropException · extends `Exception` · `com/icatchtek/control/customer/exception/IchDevicePropException.java`

字段/常量（1）：
- `long serialVersionUID = 1`  L5

方法（2）：
- `public IchDevicePropException()`  L7
- `public IchDevicePropException(String str)`  L10
### `com.icatchtek.control.customer.exception.IchInvalidPasswdException`
L4 · [class] public IchInvalidPasswdException · extends `Exception` · `com/icatchtek/control/customer/exception/IchInvalidPasswdException.java`

字段/常量（1）：
- `long serialVersionUID = 1`  L5

方法（2）：
- `public IchInvalidPasswdException()`  L7
- `public IchInvalidPasswdException(String str)`  L10
### `com.icatchtek.control.customer.exception.IchNoSDCardException`
L4 · [class] public IchNoSDCardException · extends `Exception` · `com/icatchtek/control/customer/exception/IchNoSDCardException.java`

字段/常量（1）：
- `long serialVersionUID = 1`  L5

方法（2）：
- `public IchNoSDCardException()`  L7
- `public IchNoSDCardException(String str)`  L10
### `com.icatchtek.control.customer.exception.IchNoSuchPathException`
L4 · [class] public IchNoSuchPathException · extends `Exception` · `com/icatchtek/control/customer/exception/IchNoSuchPathException.java`

字段/常量（1）：
- `long serialVersionUID = 1`  L5

方法（2）：
- `public IchNoSuchPathException()`  L7
- `public IchNoSuchPathException(String str)`  L10
### `com.icatchtek.control.customer.exception.IchStorageFormatException`
L4 · [class] public IchStorageFormatException · extends `Exception` · `com/icatchtek/control/customer/exception/IchStorageFormatException.java`

字段/常量（1）：
- `long serialVersionUID = 1`  L5

方法（2）：
- `public IchStorageFormatException()`  L7
- `public IchStorageFormatException(String str)`  L10
### `com.icatchtek.control.customer.ICatchCameraAssist`
L18 · [class] public abstract ICatchCameraAssist · `com/icatchtek/control/customer/ICatchCameraAssist.java`

方法（15）：
- `boolean deviceInit(String str)`  L19
- `boolean loadLibrary(Context context, String str, String str2)`  L21
- `void notifyUpdateFw()`  L23
- `String simpleConfig(Context context, String str, String str2, String str3, String str4)`  L25
- `String simpleConfig(Context context, String str, String str2, String str3, String str4, int i)`  L27
- `String simpleConfig(Context context, String str, String str2, byte[] bArr, String str3, String str4, int i)`  L29
- `boolean simpleConfigCancel()`  L31
- `boolean startDeviceScan()`  L33
- `boolean stopDeviceScan()`  L35
- `boolean updateFw(ICatchCameraSession iCatchCameraSession, String str)`  L37
- `boolean wakeUpCamera(String str)`  L39
- `boolean addEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L41
- `boolean delEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L45
- `boolean addEventListener(int i, ICatchCameraListener iCatchCameraListener, boolean z)`  L49
- `boolean delEventListener(int i, ICatchCameraListener iCatchCameraListener, boolean z)`  L53
### `com.icatchtek.control.customer.ICatchCameraConfig`
L4 · [interface] public ICatchCameraConfig · `com/icatchtek/control/customer/ICatchCameraConfig.java`

方法（9）：
- `boolean disablePTPIP()`  L5
- `boolean disableSocketIO()`  L7
- `boolean enablePTPIP()`  L9
- `boolean enablePTPReconnection(boolean z)`  L11
- `boolean enableSocketIO()`  L13
- `int getPtpTimeoutCheckCount()`  L15
- `double getPtpTimeoutCheckIntervalInSecs()`  L17
- `boolean setConnectionCheckParam(int i)`  L19
- `boolean setConnectionCheckParam(int i, double d, int i2)`  L21
### `com.icatchtek.control.customer.ICatchCameraControl`
L21 · [interface] public ICatchCameraControl · `com/icatchtek/control/customer/ICatchCameraControl.java`

方法（38）：
- `boolean addCustomEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L22
- `boolean addEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L24
- `boolean capturePhoto()`  L26
- `boolean capturePhoto(int i)`  L28
- `boolean changePreviewMode(int i)`  L30
- `boolean delCustomEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L32
- `boolean delEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L34
- `int extensionUnitGet(int i, byte[] bArr)`  L36
- `int extensionUnitGetLength(int i)`  L38
- `boolean extensionUnitSet(int i, byte[] bArr, int i2)`  L40
- `int formatStorage()`  L42
- `int formatStorage(int i)`  L44
- `int getCurrentBatteryLevel()`  L46
- `int getCurrentCameraMode()`  L48
- `int getFreeSpaceInImages()`  L50
- `String getMacAddress()`  L52
- `int getRemainRecordingTime()`  L54
- `List<Integer> getSupportedModes()`  L56
- `ICatchCamVideoRecordStatus getVideoRecordStatus()`  L58
- `boolean isSDCardExist()`  L60
- `boolean pan(int i, int i2)`  L62
- `boolean panReset()`  L64
- `boolean setAudioMute()`  L66
- `boolean setAudioUnMute()`  L68
- `boolean setEventTrigger()`  L70
- `boolean setExtensionUnitID(int i)`  L72
- `boolean setFileProtection(ICatchFile iCatchFile, int i)`  L74
- `boolean setVideoStreamInterface(int i)`  L76
- `int startMovieRecord()`  L78
- `boolean startTimeLapse()`  L80
- `int stopMovieRecord()`  L82
- `int stopMovieRecord(int i)`  L84
- `boolean stopTimeLapse()`  L86
- `boolean supportVideoPlayback()`  L88
- `boolean toStandbyMode()`  L90
- `boolean triggerCapturePhoto()`  L92
- `boolean zoomIn()`  L94
- `boolean zoomOut()`  L96
### `com.icatchtek.control.customer.ICatchCameraInfo`
L6 · [interface] public ICatchCameraInfo · `com/icatchtek/control/customer/ICatchCameraInfo.java`

方法（3）：
- `String getCameraFWVersion()`  L7
- `String getCameraProductName()`  L9
- `String getSDKVersion()`  L11
### `com.icatchtek.control.customer.ICatchCameraListener`
L6 · [interface] public ICatchCameraListener · `com/icatchtek/control/customer/ICatchCameraListener.java`

方法（1）：
- `void eventNotify(ICatchCamEvent iCatchCamEvent)`  L7
### `com.icatchtek.control.customer.ICatchCameraLog`
L7 · [class] public ICatchCameraLog · `com/icatchtek/control/customer/ICatchCameraLog.java`

方法（9）：
- `private ICatchCameraLog()`  L10
- `ICatchCameraLog getInstance()`  L13
- `void setSystemLogOutput(boolean z)`  L17
- `void setFileLogPath(String str)`  L21
- `void setFileLogOutput(boolean z)`  L25
- `void setDebugMode(boolean z)`  L29
- `void setLog(int i, boolean z)`  L33
- `void setLogLevel(int i, int i2)`  L37
- `void logI(String str, String str2)`  L41
### `com.icatchtek.control.customer.ICatchCameraPlayback`
L16 · [interface] public ICatchCameraPlayback · `com/icatchtek/control/customer/ICatchCameraPlayback.java`

方法（18）：
- `boolean cancelFileDownload()`  L17
- `boolean closeFileTransChannel()`  L19
- `boolean deleteFile(ICatchFile iCatchFile)`  L21
- `ICatchFrameBuffer downloadFile(ICatchFile iCatchFile)`  L23
- `boolean downloadFile(ICatchFile iCatchFile, String str)`  L25
- `boolean downloadFile(String str, String str2)`  L27
- `boolean downloadFileQuick(ICatchFile iCatchFile, String str)`  L29
- `int getFileCount()`  L31
- `ICatchFrameBuffer getQuickview(ICatchFile iCatchFile)`  L33
- `ICatchFrameBuffer getThumbnail(ICatchFile iCatchFile)`  L35
- `List<ICatchFile> listFiles(int i)`  L37
- `List<ICatchFile> listFiles(int i, int i2)`  L39
- `List<ICatchFile> listFiles(int i, int i2, int i3, int i4)`  L41
- `boolean openFileTransChannel()`  L43
- `boolean setFileListAttribute(int i, int i2)`  L45
- `boolean setFileListAttribute(int i, int i2, int i3)`  L47
- `boolean uploadFile(String str, String str2)`  L49
- `boolean uploadFileQuick(String str, String str2)`  L51
### `com.icatchtek.control.customer.ICatchCameraProperty`
L14 · [interface] public ICatchCameraProperty · `com/icatchtek/control/customer/ICatchCameraProperty.java`

方法（59）：
- `boolean checkCameraCapabilities(int i)`  L15
- `int getCurrentBurstNumber()`  L17
- `ICatchCamByteArray getCurrentByteArrayPropertyValue(int i, int i2)`  L19
- `int getCurrentCaptureDelay()`  L21
- `int getCurrentDateStamp()`  L23
- `String getCurrentImageSize()`  L25
- `int getCurrentLightFrequency()`  L27
- `int getCurrentPropertyValue(int i)`  L29
- `int getCurrentPropertyValue(int i, int i2)`  L31
- `int getCurrentSeamless()`  L33
- `int getCurrentSlowMotion()`  L35
- `ICatchVideoFormat getCurrentStreamingInfo()`  L37
- `String getCurrentStringPropertyValue(int i)`  L39
- `String getCurrentStringPropertyValue(int i, int i2)`  L41
- `int getCurrentTimeLapseDuration()`  L43
- `int getCurrentTimeLapseInterval()`  L45
- `int getCurrentUpsideDown()`  L47
- `String getCurrentVideoSize()`  L49
- `int getCurrentWhiteBalance()`  L51
- `int getCurrentZoomRatio()`  L53
- `int getMaxZoomRatio()`  L55
- `int getNumberOfSensors()`  L57
- `int getPreviewCacheTime()`  L59
- `int getProperty(int i, byte[] bArr)`  L61
- `List<Integer> getSupportedBurstNumbers()`  L63
- `List<Integer> getSupportedCaptureDelays()`  L65
- `List<Integer> getSupportedDateStamps()`  L67
- `List<String> getSupportedImageSizes()`  L69
- `List<Integer> getSupportedLightFrequencies()`  L71
- `List<Integer> getSupportedProperties()`  L73
- `List<Integer> getSupportedPropertyValues(int i)`  L75
- `List<Integer> getSupportedPropertyValues(int i, int i2)`  L77
- `List<Integer> getSupportedSeamlesses()`  L79
- `List<ICatchVideoFormat> getSupportedStreamingInfos()`  L81
- `List<String> getSupportedStringPropertyValues(int i)`  L83
- `List<String> getSupportedStringPropertyValues(int i, int i2)`  L85
- `List<Integer> getSupportedTimeLapseDurations()`  L87
- `List<Integer> getSupportedTimeLapseIntervals()`  L89
- `List<String> getSupportedVideoSizes()`  L91
- `List<Integer> getSupportedWhiteBalances()`  L93
- `boolean setBurstNumber(int i)`  L95
- `boolean setByteArrayPropertyValue(int i, ICatchCamByteArray iCatchCamByteArray, int i2)`  L97
- `boolean setCaptureDelay(int i)`  L99
- `boolean setDateStamp(int i)`  L101
- `boolean setImageSize(String str)`  L103
- `boolean setLightFrequency(int i)`  L105
- `boolean setProperty(int i, byte[] bArr, int i2)`  L107
- `boolean setPropertyValue(int i, int i2)`  L109
- `boolean setPropertyValue(int i, int i2, int i3)`  L111
- `boolean setSeamless(int i)`  L113
- `boolean setSlowMotion(int i)`  L115
- `boolean setStreamingInfo(ICatchVideoFormat iCatchVideoFormat)`  L117
- `boolean setStringPropertyValue(int i, String str)`  L119
- `boolean setStringPropertyValue(int i, String str, int i2)`  L121
- `boolean setTimeLapseDuration(int i)`  L123
- `boolean setTimeLapseInterval(int i)`  L125
- `boolean setUpsideDown(int i)`  L127
- `boolean setVideoSize(String str)`  L129
- `boolean setWhiteBalance(int i)`  L131
### `com.icatchtek.control.customer.ICatchCameraSession`
L20 · [class] public ICatchCameraSession · `com/icatchtek/control/customer/ICatchCameraSession.java`

字段/常量（6）：
- `ICatchCameraControl controlClient`  L21
- `ICatchCameraInfo infoClient`  L22
- `ICatchCameraPlayback playbackClient`  L23
- `ICatchCameraProperty propertyClient`  L24
- `ICatchCameraState stateClient`  L26
- `int i = this.sessionID`  L75

方法（15）：
- `ICatchCameraSession createSession()`  L28
- `ICatchCameraConfig getCameraConfig(ICatchITransport iCatchITransport)`  L32
- `ICatchCameraAssist getCameraAssist(ICatchITransport iCatchITransport)`  L36
- `int getSessionID()`  L41 @Deprecated
- `boolean prepareSession(ICatchITransport iCatchITransport)`  L45
- `throw new IchTransportException( 2  + iCatchITransport +  3 )`  L64
- `boolean destroySession()`  L74
- `boolean checkConnection()`  L82
- `ICatchCameraInfo getInfoClient()`  L87
- `ICatchCameraState getStateClient()`  L92
- `ICatchCameraControl getControlClient()`  L97
- `ICatchCameraProperty getPropertyClient()`  L102
- `ICatchCameraPlayback getPlaybackClient()`  L107
- `void checkSession()`  L112
- `throw new IchInvalidSessionException()`  L114
### `com.icatchtek.control.customer.ICatchCameraState`
L7 · [interface] public ICatchCameraState · `com/icatchtek/control/customer/ICatchCameraState.java`

方法（7）：
- `boolean isCameraBusy()`  L8
- `boolean isMoviePlaying()`  L11 @Deprecated
- `boolean isMovieRecording()`  L13
- `boolean isStreaming()`  L16 @Deprecated
- `boolean isTimeLapseStillOn()`  L18
- `boolean isTimeLapseVideoOn()`  L20
- `boolean supportImageAutoDownload()`  L22
### `com.icatchtek.control.customer.ICatchCameraUtil`
L10 · [class] public ICatchCameraUtil · `com/icatchtek/control/customer/ICatchCameraUtil.java`

方法（4）：
- `int convertImageSize(String str)`  L11
- `List<Integer> convertImageSizes(List<String> list)`  L15
- `int convertVideoSize(String str)`  L24
- `List<Integer> convertVideoSizes(List<String> list)`  L28
### `com.icatchtek.control.customer.type.ICatchCamBurstNumber`
L4 · [class] public ICatchCamBurstNumber · `com/icatchtek/control/customer/type/ICatchCamBurstNumber.java`

字段/常量（9）：
- `int ICH_CAM_BURST_NUMBER_10 = 4`  L5
- `int ICH_CAM_BURST_NUMBER_15 = 6`  L6
- `int ICH_CAM_BURST_NUMBER_3 = 2`  L7
- `int ICH_CAM_BURST_NUMBER_30 = 7`  L8
- `int ICH_CAM_BURST_NUMBER_5 = 3`  L9
- `int ICH_CAM_BURST_NUMBER_7 = 5`  L10
- `int ICH_CAM_BURST_NUMBER_HS = 0`  L11
- `int ICH_CAM_BURST_NUMBER_OFF = 1`  L12
- `int ICH_CAM_BURST_NUMBER_UNDEFINED = 65535`  L13
### `com.icatchtek.control.customer.type.ICatchCamByteArray`
L4 · [class] public ICatchCamByteArray · `com/icatchtek/control/customer/type/ICatchCamByteArray.java`

字段/常量（2）：
- `int dataSize`  L5
- `byte[] value`  L6

方法（5）：
- `public ICatchCamByteArray()`  L8
- `public ICatchCamByteArray(byte[] bArr, int i)`  L11
- `void setValue(byte[] bArr, int i)`  L16
- `byte[] getValue()`  L21
- `int getDataSize()`  L25
### `com.icatchtek.control.customer.type.ICatchCamCaptureDelay`
L4 · [class] public ICatchCamCaptureDelay · `com/icatchtek/control/customer/type/ICatchCamCaptureDelay.java`

字段/常量（4）：
- `int ICH_CAM_CAP_DELAY_10S = 10000`  L5
- `int ICH_CAM_CAP_DELAY_2S = 2000`  L6
- `int ICH_CAM_CAP_DELAY_NO = 0`  L7
- `int ICH_CAM_CAP_DELAY_UNDEFINED = 65535`  L8
### `com.icatchtek.control.customer.type.ICatchCamDateStamp`
L4 · [class] public ICatchCamDateStamp · `com/icatchtek/control/customer/type/ICatchCamDateStamp.java`

字段/常量（4）：
- `int ICH_CAM_DATE_STAMP_DATE = 2`  L5
- `int ICH_CAM_DATE_STAMP_DATE_TIME = 3`  L6
- `int ICH_CAM_DATE_STAMP_OFF = 1`  L7
- `int ICH_CAM_DATE_STAMP_UNDEFINED = 255`  L8
### `com.icatchtek.control.customer.type.ICatchCamEvent`
L6 · [class] public ICatchCamEvent · `com/icatchtek/control/customer/type/ICatchCamEvent.java`

字段/常量（12）：
- `double doubleValue1`  L7
- `double doubleValue2`  L8
- `double doubleValue3`  L9
- `int eventID`  L10
- `ICatchFile fileValue1`  L11
- `int intValue1`  L12
- `int intValue2`  L13
- `int intValue3`  L14
- `int sessionID`  L15
- `String stringValue1`  L16
- `String stringValue2`  L17
- `String stringValue3`  L18

方法（25）：
- `int getEventID()`  L20
- `void setEventID(int i)`  L24
- `int getSessionID()`  L28
- `void setSessionID(int i)`  L32
- `int getIntValue1()`  L36
- `void setIntValue1(int i)`  L40
- `int getIntValue2()`  L44
- `void setIntValue2(int i)`  L48
- `int getIntValue3()`  L52
- `void setIntValue3(int i)`  L56
- `double getDoubleValue1()`  L60
- `void setDoubleValue1(double d)`  L64
- `double getDoubleValue2()`  L68
- `void setDoubleValue2(double d)`  L72
- `double getDoubleValue3()`  L76
- `void setDoubleValue3(double d)`  L80
- `String getStringValue1()`  L84
- `void setStringValue1(String str)`  L88
- `void setStringValue2(String str)`  L92
- `String getStringValue2()`  L96
- `void setStringValue3(String str)`  L100
- `String getStringValue3()`  L104
- `ICatchFile getFileValue1()`  L108
- `void setFileValue1(ICatchFile iCatchFile)`  L112
- `String toString()`  L116
    - 体内字面量："eventID: " · "; sessionID: " · "; intValue1: " · "; intValue2: " · "; intValue2: " · "; doubleValue1: " · "; doubleValue2: " · "; doubleValue3: " · "; stringValue1: " · "; stringValue2: " · "; stringValue3: " · "; "
### `com.icatchtek.control.customer.type.ICatchCamEventID`
L4 · [class] public ICatchCamEventID · `com/icatchtek/control/customer/type/ICatchCamEventID.java`

字段/常量（43）：
- `int ICATCH_EVENT_DEVICE_SCAN_ADD = 85`  L5
- `int ICH_CAM_EVENT_BATTERY_LEVEL_CHANGED = 36`  L6
- `int ICH_CAM_EVENT_BURST_NUMBER_PROP_CHANGED = 55`  L7
- `int ICH_CAM_EVENT_CAPTURE_COMPLETE = 35`  L8
- `int ICH_CAM_EVENT_CAPTURE_DELAY_PROP_CHANGED = 51`  L9
- `int ICH_CAM_EVENT_CAPTURE_START = 82`  L10
- `int ICH_CAM_EVENT_CONNECTION_DISCONNECTED = 74`  L11
- `int ICH_CAM_EVENT_CONNECTION_INITIALIZE_FAILED = 76`  L12
- `int ICH_CAM_EVENT_CONNECTION_INITIALIZE_SUCCEED = 75`  L13
- `int ICH_CAM_EVENT_DEVICE_INFO_CHANGED = 49`  L14
- `int ICH_CAM_EVENT_FILE_ADDED = 1`  L15
- `int ICH_CAM_EVENT_FILE_DOWNLOAD = 103`  L16
- `int ICH_CAM_EVENT_FILE_INFO_CHANGED = 3`  L17
- `int ICH_CAM_EVENT_FILE_REMOVED = 2`  L18
- `int ICH_CAM_EVENT_FW_UPDATE_CHECK = 96`  L19
- `int ICH_CAM_EVENT_FW_UPDATE_CHKSUMERR = 99`  L20
- `int ICH_CAM_EVENT_FW_UPDATE_COMPLETED = 97`  L21
- `int ICH_CAM_EVENT_FW_UPDATE_NG = 100`  L22
- `int ICH_CAM_EVENT_FW_UPDATE_POWEROFF = 98`  L23
- `int ICH_CAM_EVENT_IMAGE_SIZE_PROP_CHANGED = 52`  L24
- `int ICH_CAM_EVENT_INSUFFICIENT_DISK_SPACE = 133`  L25
- `int ICH_CAM_EVENT_LIGHT_FREQUENCY_PROP_CHANGED = 54`  L26
- `int ICH_CAM_EVENT_SDCARD_ERROR = 18`  L27
- `int ICH_CAM_EVENT_SDCARD_FULL = 17`  L28
- `int ICH_CAM_EVENT_SDCARD_IN = 20`  L29
- `int ICH_CAM_EVENT_SDCARD_INFO_CHANGED = 21`  L30
- `int ICH_CAM_EVENT_SDCARD_REMOVED = 19`  L31
- `int ICH_CAM_EVENT_SD_CARD_ERR = 130`  L32
- `int ICH_CAM_EVENT_SD_CARD_IN = 129`  L33
- `int ICH_CAM_EVENT_SD_CARD_LOCKED = 131`  L34
- `int ICH_CAM_EVENT_SD_CARD_MEMORY_FULL = 132`  L35
- `int ICH_CAM_EVENT_SD_CARD_OUT = 128`  L36
- `int ICH_CAM_EVENT_SD_CARD_SPEED_TOO_SLOW = 134`  L37
- `int ICH_CAM_EVENT_TIMELAPSE_STOP = 81`  L38
- `int ICH_CAM_EVENT_UNDEFINED = 255`  L39
- `int ICH_CAM_EVENT_VIDEO_OFF = 34`  L40
- `int ICH_CAM_EVENT_VIDEO_ON = 33`  L41
- `int ICH_CAM_EVENT_VIDEO_SIZE_PROP_CHANGED = 53`  L42
- `int ICH_CAM_EVENT_VIDEO_THUMB_DONE = 105`  L43
- `int ICH_CAM_EVENT_VIDEO_THUMB_READY = 104`  L44
- `int ICH_CAM_EVENT_VIDEO_TRIM_DONE = 106`  L45
- `int ICH_CAM_EVENT_VIDREC_TIME_CHANGE = 101`  L46
- `int ICH_CAM_EVENT_WHITE_BALANCE_PROP_CHANGED = 50`  L47
### `com.icatchtek.control.customer.type.ICatchCamFeatureID`
L4 · [class] public ICatchCamFeatureID · `com/icatchtek/control/customer/type/ICatchCamFeatureID.java`

字段/常量（3）：
- `int ICH_CAM_APP_DEFAULT_TO_PLAYBACK = 1`  L5
- `int ICH_CAM_NEW_PAGINATION_GET_FILE = 2`  L6
- `int ICH_CAM_TIMELAPSE_USING_MS_VALUE = 4`  L7
### `com.icatchtek.control.customer.type.ICatchCamFrameSize`
L4 · [class] public ICatchCamFrameSize · `com/icatchtek/control/customer/type/ICatchCamFrameSize.java`

字段/常量（2）：
- `int frameHeight`  L5
- `int frameWidth`  L6

方法（5）：
- `public ICatchCamFrameSize(int i, int i2)`  L8
- `int getFrameWidth()`  L13
- `void setFrameWidth(int i)`  L17
- `int getFrameHeight()`  L21
- `void setFrameHeight(int i)`  L25
### `com.icatchtek.control.customer.type.ICatchCamImageSize`
L4 · [class] public ICatchCamImageSize · `com/icatchtek/control/customer/type/ICatchCamImageSize.java`

字段/常量（8）：
- `int ICH_CAM_IMAGE_SIZE_10M = 10`  L5
- `int ICH_CAM_IMAGE_SIZE_2M = 2`  L6
- `int ICH_CAM_IMAGE_SIZE_3M = 3`  L7
- `int ICH_CAM_IMAGE_SIZE_5M = 5`  L8
- `int ICH_CAM_IMAGE_SIZE_6M = 6`  L9
- `int ICH_CAM_IMAGE_SIZE_8M = 8`  L10
- `int ICH_CAM_IMAGE_SIZE_UNDEFINED = 255`  L11
- `int ICH_CAM_IMAGE_SIZE_VGA = 0`  L12
### `com.icatchtek.control.customer.type.ICatchCamLightFrequency`
L4 · [class] public ICatchCamLightFrequency · `com/icatchtek/control/customer/type/ICatchCamLightFrequency.java`

字段/常量（4）：
- `int ICH_CAM_LIGHT_FREQUENCY_50HZ = 0`  L5
- `int ICH_CAM_LIGHT_FREQUENCY_60HZ = 1`  L6
- `int ICH_CAM_LIGHT_FREQUENCY_AUTO = 2`  L7
- `int ICH_CAM_LIGHT_FREQUENCY_UNDEFINED = 255`  L8
### `com.icatchtek.control.customer.type.ICatchCamListFileFilter`
L4 · [class] public ICatchCamListFileFilter · `com/icatchtek/control/customer/type/ICatchCamListFileFilter.java`

字段/常量（13）：
- `int ICH_COMPOSITE_FILE_TAKEN_BY_ALL_SENSORS = 3`  L5
- `int ICH_OFC_FILE_TYPE_ALL_MEDIA = 255`  L6
- `int ICH_OFC_TYPE_EMERGENCY_IMAGE = 34`  L7
- `int ICH_OFC_TYPE_EMERGENCY_MEDIA = 35`  L8
- `int ICH_OFC_TYPE_EMERGENCY_VIDEO = 33`  L9
- `int ICH_OFC_TYPE_IMAGE = 18`  L10
- `int ICH_OFC_TYPE_MEDIA = 19`  L11
- `int ICH_OFC_TYPE_VIDEO = 17`  L12
- `int ICH_SORT_TYPE_ASCENDING = 2`  L13
- `int ICH_SORT_TYPE_DESCENDING = 1`  L14
- `int ICH_TAKEN_BY_ALL_SENSORS = 0`  L15
- `int ICH_TAKEN_BY_BACK_SENSOR = 2`  L16
- `int ICH_TAKEN_BY_FRONT_SENSOR = 1`  L17
### `com.icatchtek.control.customer.type.ICatchCamLogLevel`
L4 · [class] public ICatchCamLogLevel · `com/icatchtek/control/customer/type/ICatchCamLogLevel.java`

字段/常量（4）：
- `int ICH_CAM_LOG_LEVEL_DEBUG = 0`  L5
- `int ICH_CAM_LOG_LEVEL_ERROR = 5`  L6
- `int ICH_CAM_LOG_LEVEL_INFO = 1`  L7
- `int ICH_CAM_LOG_LEVEL_WARN = 3`  L8
### `com.icatchtek.control.customer.type.ICatchCamLogType`
L4 · [class] public ICatchCamLogType · `com/icatchtek/control/customer/type/ICatchCamLogType.java`

字段/常量（3）：
- `int ICH_CAM_LOG_TYPE_APP = 2`  L5
- `int ICH_CAM_LOG_TYPE_COMMON = 0`  L6
- `int ICH_CAM_LOG_TYPE_THIRDLIB = 1`  L7
### `com.icatchtek.control.customer.type.ICatchCamMode`
L4 · [class] public ICatchCamMode · `com/icatchtek/control/customer/type/ICatchCamMode.java`

字段/常量（12）：
- `int ICH_CAM_MODE_CAMERA = 3`  L5
- `int ICH_CAM_MODE_IDLE = 4`  L6
- `int ICH_CAM_MODE_SHARED = 2`  L7
- `int ICH_CAM_MODE_TIMELAPSE = 43`  L8
- `int ICH_CAM_MODE_TIMELAPSE_STILL = 7`  L9
- `int ICH_CAM_MODE_TIMELAPSE_STILL_OFF = 9`  L10
- `int ICH_CAM_MODE_TIMELAPSE_VIDEO = 8`  L11
- `int ICH_CAM_MODE_TIMELAPSE_VIDEO_OFF = 10`  L12
- `int ICH_CAM_MODE_UNDEFINED = 65471`  L13
- `int ICH_CAM_MODE_VIDEO = 42`  L14
- `int ICH_CAM_MODE_VIDEO_OFF = 1`  L15
- `int ICH_CAM_MODE_VIDEO_ON = 17`  L16
### `com.icatchtek.control.customer.type.ICatchCamPhotoExif`
L16 · [class] public ICatchCamPhotoExif · `com/icatchtek/control/customer/type/ICatchCamPhotoExif.java`

字段/常量（37）：
- `int ORIENTATION_FLIP_HORIZONTAL = 2`  L17
- `int ORIENTATION_FLIP_VERTICAL = 4`  L18
- `int ORIENTATION_NORMAL = 1`  L19
- `int ORIENTATION_ROTATE_180 = 3`  L20
- `int ORIENTATION_ROTATE_270 = 8`  L21
- `int ORIENTATION_ROTATE_90 = 6`  L22
- `int ORIENTATION_TRANSPOSE = 5`  L23
- `int ORIENTATION_TRANSVERSE = 7`  L24
- `int ORIENTATION_UNDEFINED = 0`  L25
- `String TAG_APERTURE = "FNumber"`  L26
- `String TAG_DATETIME = "DateTime"`  L27
- `String TAG_EXPOSURE_TIME = "ExposureTime"`  L28
- `String TAG_FLASH = "Flash"`  L29
- `String TAG_FOCAL_LENGTH = "FocalLength"`  L30
- `String TAG_GPS_ALTITUDE = "GPSAltitude"`  L31
- `String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef"`  L32
- `String TAG_GPS_DATESTAMP = "GPSDateStamp"`  L33
- `String TAG_GPS_LATITUDE = "GPSLatitude"`  L34
- `String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef"`  L35
- `String TAG_GPS_LONGITUDE = "GPSLongitude"`  L36
- `String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef"`  L37
- `String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod"`  L38
- `String TAG_GPS_TIMESTAMP = "GPSTimeStamp"`  L39
- `String TAG_IMAGE_LENGTH = "ImageLength"`  L40
- `String TAG_IMAGE_WIDTH = "ImageWidth"`  L41
- `String TAG_ISO = "ISOSpeedRatings"`  L42
- `String TAG_MAKE = "Make"`  L43
- `String TAG_MODEL = "Model"`  L44
- `String TAG_ORIENTATION = "Orientation"`  L45
- `String TAG_WHITE_BALANCE = "WhiteBalance"`  L46
- `int WHITEBALANCE_AUTO = 0`  L47
- `int WHITEBALANCE_MANUAL = 1`  L48
- `SimpleDateFormat sFormatter`  L49
- `HashMap<String, String> mAttributes`  L50
- `boolean mHasThumbnail`  L51
- `String str3 = strArrSplit[0]`  L104
- `String str4 = strArrSplit[1]`  L105

方法（14）：
- `public ICatchCamPhotoExif(String str)`  L59
- `String getAttribute(String str)`  L63
- `int getAttributeInt(String str, int i)`  L67
- `double getAttributeDouble(String str, double d)`  L78
    - 体内字面量："/"
- `void setAttribute(String str, String str2)`  L95
- `void loadAttributes(String str)`  L99
    - 体内字面量：";" · ":"
- `boolean hasThumbnail()`  L115
- `boolean getLatLong(float[] fArr)`  L119
    - 体内字面量："GPSLatitude" · "GPSLatitudeRef" · "GPSLongitude" · "GPSLongitudeRef"
- `double getAltitude(double d)`  L135
    - 体内字面量："GPSAltitude" · "GPSAltitudeRef"
- `long getDateTime()`  L144
    - 体内字面量："DateTime"
- `long getGpsDateTime()`  L160
    - 体内字面量："GPSDateStamp" · "GPSTimeStamp"
- `float convertRationalLatLonToFloat(String str, String str2)`  L176
    - 体内字面量："/" · "/" · "/"
- `throw new IllegalArgumentException()`  L187
- `throw new IllegalArgumentException()`  L189
### `com.icatchtek.control.customer.type.ICatchCamPreviewMode`
L4 · [class] public ICatchCamPreviewMode · `com/icatchtek/control/customer/type/ICatchCamPreviewMode.java`

字段/常量（4）：
- `int ICH_CAM_STILL_PREVIEW_MODE = 1`  L5
- `int ICH_CAM_TIMELAPSE_STILL_PREVIEW_MODE = 3`  L6
- `int ICH_CAM_TIMELAPSE_VIDEO_PREVIEW_MODE = 4`  L7
- `int ICH_CAM_VIDEO_PREVIEW_MODE = 2`  L8
### `com.icatchtek.control.customer.type.ICatchCamProperty`
L4 · [class] public ICatchCamProperty · `com/icatchtek/control/customer/type/ICatchCamProperty.java`

字段/常量（19）：
- `int ICH_CAM_CAP_BATTERY_LEVEL = 20481`  L5
- `int ICH_CAM_CAP_BURST_NUMBER = 20504`  L6
- `int ICH_CAM_CAP_CAPTURE_DELAY = 20498`  L7
- `int ICH_CAM_CAP_DATE_STAMP = 54791`  L8
- `int ICH_CAM_CAP_DIGITAL_ZOOM = 20502`  L9
- `int ICH_CAM_CAP_FW_VERSION = 20511`  L10
- `int ICH_CAM_CAP_GET_CAMERA_CAPABILITIES = 55084`  L11
- `int ICH_CAM_CAP_GET_NUMBER_OF_SENSORS = 55083`  L12
- `int ICH_CAM_CAP_IMAGE_SIZE = 20483`  L13
- `int ICH_CAM_CAP_LIGHT_FREQUENCY = 54790`  L14
- `int ICH_CAM_CAP_MOVIE_REC = 58884`  L15
- `int ICH_CAM_CAP_PRODUCT_NAME = 20510`  L16
- `int ICH_CAM_CAP_SLOW_MOTION = 54805`  L17
- `int ICH_CAM_CAP_TIMELAPSE_STILL = 20507`  L18
- `int ICH_CAM_CAP_TIMELAPSE_VIDEO = 54801`  L19
- `int ICH_CAM_CAP_UNDEFINED = 65535`  L20
- `int ICH_CAM_CAP_UPSIDE_DOWN = 54804`  L21
- `int ICH_CAM_CAP_VIDEO_SIZE = 54789`  L22
- `int ICH_CAM_CAP_WHITE_BALANCE = 20485`  L23
### `com.icatchtek.control.customer.type.ICatchCamTimeLapseDuration`
L4 · [class] public ICatchCamTimeLapseDuration · `com/icatchtek/control/customer/type/ICatchCamTimeLapseDuration.java`

字段/常量（8）：
- `int ICH_CAM_TIMELPS_DURATION_10M = 3`  L5
- `int ICH_CAM_TIMELPS_DURATION_15M = 4`  L6
- `int ICH_CAM_TIMELPS_DURATION_20M = 5`  L7
- `int ICH_CAM_TIMELPS_DURATION_30M = 6`  L8
- `int ICH_CAM_TIMELPS_DURATION_5M = 2`  L9
- `int ICH_CAM_TIMELPS_DURATION_60M = 7`  L10
- `int ICH_CAM_TIMELPS_DURATION_OFF = 1`  L11
- `int ICH_CAM_TIMELPS_DURATION_UNLMT = 65535`  L12
### `com.icatchtek.control.customer.type.ICatchCamTimeLapseInterval`
L4 · [class] public ICatchCamTimeLapseInterval · `com/icatchtek/control/customer/type/ICatchCamTimeLapseInterval.java`

字段/常量（11）：
- `int ICH_CAM_TIMELPS_INTERVAL_10M = 9`  L5
- `int ICH_CAM_TIMELPS_INTERVAL_10S = 4`  L6
- `int ICH_CAM_TIMELPS_INTERVAL_1HR = 11`  L7
- `int ICH_CAM_TIMELPS_INTERVAL_1M = 7`  L8
- `int ICH_CAM_TIMELPS_INTERVAL_1S = 2`  L9
- `int ICH_CAM_TIMELPS_INTERVAL_20S = 5`  L10
- `int ICH_CAM_TIMELPS_INTERVAL_30M = 10`  L11
- `int ICH_CAM_TIMELPS_INTERVAL_30S = 6`  L12
- `int ICH_CAM_TIMELPS_INTERVAL_5M = 8`  L13
- `int ICH_CAM_TIMELPS_INTERVAL_5S = 3`  L14
- `int ICH_CAM_TIMELPS_INTERVAL_OFF = 1`  L15
### `com.icatchtek.control.customer.type.ICatchCamVideoRecordStatus`
L7 · [class] public ICatchCamVideoRecordStatus · `com/icatchtek/control/customer/type/ICatchCamVideoRecordStatus.java`

字段/常量（7）：
- `int cardStatus`  L8
- `int days`  L9
- `int hours`  L10
- `int minutes`  L11
- `int months`  L12
- `int seconds`  L13
- `int years`  L14

方法（16）：
- `int getCardStatus()`  L16
- `void setCardStatus(int i)`  L20
- `int getYears()`  L24
- `void setYears(int i)`  L28
- `int getMonths()`  L32
- `void setMonths(int i)`  L36
- `int getDays()`  L40
- `void setDays(int i)`  L44
- `int getHours()`  L48
- `void setHours(int i)`  L52
- `int getMinutes()`  L56
- `void setMinutes(int i)`  L60
- `int getSeconds()`  L64
- `void setSeconds(int i)`  L68
- `String toString()`  L72
    - 体内字面量："cardStatus" · "years" · "months" · "days" · "hours" · "minutes" · "seconds"
- `ICatchCamVideoRecordStatus fromString(String str)`  L89
    - 体内字面量："cardStatus" · "years" · "months" · "days" · "hours" · "minutes" · "seconds"
### `com.icatchtek.control.customer.type.ICatchCamVideoSize`
L4 · [class] public ICatchCamVideoSize · `com/icatchtek/control/customer/type/ICatchCamVideoSize.java`

字段/常量（23）：
- `int ICH_CAM_VIDEO_SIZE_1080P_WITH_30FPS = 3`  L5
- `int ICH_CAM_VIDEO_SIZE_1080P_WITH_60FPS = 4`  L6
- `int ICH_CAM_VIDEO_SIZE_1280P_30FPS = 21`  L7
- `int ICH_CAM_VIDEO_SIZE_1280P_60FPS = 22`  L8
- `int ICH_CAM_VIDEO_SIZE_1440P_30FPS = 6`  L9
- `int ICH_CAM_VIDEO_SIZE_2K7_1_25FPS = 19`  L10
- `int ICH_CAM_VIDEO_SIZE_2K7_2_25FPS = 20`  L11
- `int ICH_CAM_VIDEO_SIZE_4K_15FPS = 17`  L12
- `int ICH_CAM_VIDEO_SIZE_4K_30FPS = 18`  L13
- `int ICH_CAM_VIDEO_SIZE_640P_15FPS = 25`  L14
- `int ICH_CAM_VIDEO_SIZE_640_360_240FPS = 16`  L15
- `int ICH_CAM_VIDEO_SIZE_720P_120FPS = 5`  L16
- `int ICH_CAM_VIDEO_SIZE_720P_WITH_30FPS = 1`  L17
- `int ICH_CAM_VIDEO_SIZE_720P_WITH_60FPS = 2`  L18
- `int ICH_CAM_VIDEO_SIZE_960P_1_30FPS = 23`  L19
- `int ICH_CAM_VIDEO_SIZE_960P_2_30FPS = 24`  L20
- `int ICH_CAM_VIDEO_SIZE_960P_60FPS = 7`  L21
- `int ICH_CAM_VIDEO_SIZE_FULL_30FPS = 10`  L22
- `int ICH_CAM_VIDEO_SIZE_HD_15FPS = 26`  L23
- `int ICH_CAM_VIDEO_SIZE_QVGA_240FPS = 9`  L24
- `int ICH_CAM_VIDEO_SIZE_UNDEFINED = 0`  L25
- `int ICH_CAM_VIDEO_SIZE_UNDEFINED1 = 255`  L26
- `int ICH_CAM_VIDEO_SIZE_VGA_120FPS = 8`  L27
### `com.icatchtek.control.customer.type.ICatchCamWhiteBalance`
L4 · [class] public ICatchCamWhiteBalance · `com/icatchtek/control/customer/type/ICatchCamWhiteBalance.java`

字段/常量（6）：
- `int ICH_CAM_WB_AUTO = 1`  L5
- `int ICH_CAM_WB_CLOUDY = 3`  L6
- `int ICH_CAM_WB_DAYLIGHT = 2`  L7
- `int ICH_CAM_WB_FLUORESCENT = 4`  L8
- `int ICH_CAM_WB_TUNGSTEN = 5`  L9
- `int ICH_CAM_WB_UNDEFINED = 65471`  L10
### `com.icatchtek.control.customer.type.ICatchCamWifiMode`
L4 · [class] public ICatchCamWifiMode · `com/icatchtek/control/customer/type/ICatchCamWifiMode.java`

字段/常量（4）：
- `int ICH_CAM_WIFI_MODE_AP = 1`  L5
- `int ICH_CAM_WIFI_MODE_ETHERNET = 3`  L6
- `int ICH_CAM_WIFI_MODE_STATION = 2`  L7
- `int ICH_CAM_WIFI_MODE_UNDEFINED = 65535`  L8