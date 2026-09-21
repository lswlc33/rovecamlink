# idGoLive — 类与成员明细：com.icatch.golive.SdkApi

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 19 个文件 / 20 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.SdkApi.CameraAction`
L22 · [class] public CameraAction · `com/icatch/golive/SdkApi/CameraAction.java`

字段/常量（22）：
- `String TAG = "CameraAction"`  L23
- `ICatchCameraAssist cameraAssist`  L24
- `ICatchCameraControl cameraControl`  L25
- `boolean zAddEventListener`  L33
- `boolean zAddCustomEventListener`  L54
- `boolean zAddEventListener`  L70
- `boolean zCapturePhoto`  L88
- `boolean zChangePreviewMode`  L102
- `ICatchCameraControl iCatchCameraControl = this.cameraControl`  L116
- `boolean zDelCustomEventListener = false`  L117
- `ICatchCameraControl iCatchCameraControl = this.cameraControl`  L134
- `boolean zDelEventListener = false`  L135
- `boolean z = false`  L154
- `boolean standbyMode = false`  L203
- `boolean z = false`  L223
- `boolean zStartTimeLapse`  L243
- `boolean zStopTimeLapse`  L257
- `boolean z = false`  L280
- `boolean zTriggerCapturePhoto`  L300
- `boolean zUpdateFw`  L326
- `boolean zZoomIn`  L364
- `boolean zZoomOut`  L386

方法（23）：
- `public CameraAction(ICatchCameraControl iCatchCameraControl, ICatchCameraAssist iCatchCameraAssist)`  L27
- `boolean addGlobalEventListener(int i, ICatchCameraListener iCatchCameraListener, Boolean bool)`  L32
- `boolean delGlobalEventListener(int i, ICatchCameraListener iCatchCameraListener, Boolean bool)`  L44
- `boolean addCustomEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L53
- `boolean addEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L69
- `boolean capturePhoto()`  L87
- `boolean changePreviewMode(int i)`  L101
- `boolean delCustomEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L114
    - 体内字面量："begin delEventListener eventID="
- `boolean delEventListener(int i, ICatchCameraListener iCatchCameraListener)`  L132
    - 体内字面量："begin delEventListener eventID="
- `boolean formatStorage()`  L152
    - 体内字面量："begin formatSD timeout is 15s"
- `String getCameraMacAddress()`  L176
- `int getCurrentCameraMode()`  L180
    - 体内字面量："begin getCurrentCameraMode" · "end getCurrentCameraMode ret = "
- `boolean previewMove(int i, int i2)`  L187
    - 体内字面量："begin previewMove" · "end previewMove ret = "
- `boolean resetPreviewMove()`  L194
    - 体内字面量："begin resetPreviewMove" · "end resetPreviewMove ret = "
- `boolean sleepCamera()`  L201
    - 体内字面量："begin sleepCamera"
- `boolean startMovieRecord()`  L221
    - 体内字面量："begin startVideoCapture"
- `boolean startTimeLapse()`  L242
- `boolean stopTimeLapse()`  L256
- `boolean stopVideoCapture()`  L278
    - 体内字面量："begin stopVideoCapture"
- `boolean triggerCapturePhoto()`  L299
- `boolean updateFW(String str)`  L325
- `boolean zoomIn()`  L363
- `boolean zoomOut()`  L385
### `com.icatch.golive.SdkApi.CameraFixedInfo`
L8 · [class] public CameraFixedInfo · `com/icatch/golive/SdkApi/CameraFixedInfo.java`

字段/常量（5）：
- `ICatchCameraInfo cameraInfo`  L9
- `String tag = "CameraFixedInfo"`  L10
- `String cameraProductName`  L17
- `String cameraFWVersion`  L30
- `String sDKVersion`  L44

方法（4）：
- `public CameraFixedInfo(ICatchCameraInfo iCatchCameraInfo)`  L12
- `String getCameraName()`  L16
- `String getCameraVersion()`  L29
- `String getSDKVersion()`  L43
### `com.icatch.golive.SdkApi.CameraProperties`
L26 · [class] public CameraProperties · `com/icatch/golive/SdkApi/CameraProperties.java`

字段/常量（87）：
- `ICatchCameraControl cameraAction`  L27
- `ICatchCameraProperty cameraProperty`  L28
- `List<Integer> fuction`  L29
- `List<Integer> modeList`  L30
- `List<ICatchVideoFormat> resolutionList`  L31
- `String tag = "CameraProperties"`  L32
- `int cacheDateStamp = -1`  L33
- `boolean zCheckCameraCapabilities`  L51
- `int currentBatteryLevel`  L65
- `String currentStringPropertyValue`  L98
- `String currentStringPropertyValue`  L124
- `String currentStringPropertyValue`  L157
- `String currentStringPropertyValue`  L183
- `String currentStringPropertyValue`  L209
- `String currentStringPropertyValue`  L235
- `String currentStringPropertyValue`  L261
- `int currentBurstNumber`  L287
- `int currentBurstNumber`  L314
- `int currentCaptureDelay`  L340
- `int currentDateStamp`  L366
- `String currentImageSize`  L393
- `int currentLightFrequency`  L419
- `int currentPropertyValue`  L445
- `int currentSlowMotion`  L459
- `ICatchVideoFormat currentStreamingInfo`  L485
- `String str = null`  L487
- `String currentStringPropertyValue`  L527
- `int currentTimeLapseDuration`  L553
- `int currentTimeLapseInterval`  L579
- `int currentUpsideDown`  L605
- `String currentVideoSize`  L631
- `int currentWhiteBalance`  L657
- `float currentZoomRatio`  L683
- `List<Integer> supportedDateStamps`  L709
- `ICatchVideoFormat currentStreamingInfo`  L735
- `String str = null`  L737
- `float maxZoomRatio`  L769
- `int numberOfSensors`  L795
- `int previewCacheTime`  L809
- `int remainRecordingTime`  L835
- `int freeSpaceInImages`  L864
- `List<Integer> arrayList`  L933
- `List<Integer> supportedCaptureDelays`  L963
- `List<Integer> supportedLightFrequencies`  L997
- `List<String> supportedImageSizes`  L1023
- `List<Integer> supportedLightFrequencies`  L1055
- `List<Integer> supportedModes`  L1090
- `List<Integer> supportedPropertyValues`  L1112
- `List<Integer> supportedTimeLapseDurations`  L1142
- `List<Integer> supportedTimeLapseIntervals`  L1171
- `List<String> supportedVideoSizes`  L1200
- `List<Integer> supportedWhiteBalances`  L1230
- `int currentPropertyValue`  L1260
- `int currentPropertyValue`  L1274
- `List<Integer> supportedBurstNumbers`  L1288
- `List<Integer> supportedDateStamps`  L1322
- `boolean zIsSDCardExist`  L1358
- `int currentPropertyValue`  L1380
- `boolean propertyValue`  L1394
- `boolean propertyValue`  L1420
- `boolean stringPropertyValue`  L1446
- `String cameraName`  L1473
- `boolean stringPropertyValue = false`  L1475
- `boolean stringPropertyValue`  L1503
- `boolean stringPropertyValue`  L1529
- `boolean stringPropertyValue`  L1555
- `boolean stringPropertyValue`  L1581
- `boolean stringPropertyValue`  L1607
- `boolean stringPropertyValue`  L1633
- `boolean captureDelay = false`  L1660
- `boolean propertyValue`  L1683
- `boolean burstNumber = false`  L1710
- `Boolean boolValueOf = false`  L1734
- `boolean imageSize`  L1758
- `boolean lightFrequency = false`  L1785
- `boolean propertyValue`  L1808
- `boolean stringPropertyValue`  L1834
- `boolean stringPropertyValue`  L1860
- `boolean slowMotion`  L1886
- `boolean streamingInfo`  L1912
- `boolean stringPropertyValue`  L1938
- `boolean timeLapseDuration = false`  L1965
- `boolean timeLapseInterval`  L1988
- `boolean upsideDown`  L2014
- `boolean videoSize`  L2040
- `boolean whiteBalance = false`  L2067
- `boolean zSupportVideoPlayback`  L2090

方法（84）：
- `public CameraProperties(ICatchCameraProperty iCatchCameraProperty, ICatchCameraControl iCatchCameraControl)`  L35
- `boolean cameraModeSupport(int i)`  L40
    - 体内字面量："CameraProperties" · "begin cameraModeSupport  mode=" · "CameraProperties" · "end cameraModeSupport retValue ="
- `boolean checkCameraCapabilities(int i)`  L50
- `int getBatteryElectric()`  L64
- `int getCacheDateStamp()`  L90
- `String getCameraEssidName()`  L97
- `String getCameraEssidPassword()`  L123
- `String getCameraMacAddress()`  L149
    - 体内字面量："CameraProperties" · "begin getCameraMacAddress macAddress macAddress " · "CameraProperties" · "end getCameraMacAddress macAddress ="
- `String getCameraName()`  L156
- `String getCameraName(ICatchCameraProperty iCatchCameraProperty)`  L182
- `String getCameraPassword()`  L208
- `String getCameraPasswordNew()`  L234
- `String getCameraSsid()`  L260
- `int getCurrentAppBurstNum()`  L286
- `int getCurrentBurstNum()`  L313
- `int getCurrentCaptureDelay()`  L339
- `int getCurrentDateStamp()`  L365
- `String getCurrentImageSize()`  L392
- `int getCurrentLightFrequency()`  L418
- `int getCurrentPropertyValue(int i)`  L444
- `int getCurrentSlowMotion()`  L458
- `String getCurrentStreamInfo()`  L484
- `String getCurrentStringPropertyValue(int i)`  L526
- `int getCurrentTimeLapseDuration()`  L552
- `int getCurrentTimeLapseInterval()`  L578
- `int getCurrentUpsideDown()`  L604
- `String getCurrentVideoSize()`  L630
- `int getCurrentWhiteBalance()`  L656
- `float getCurrentZoomRatio()`  L682
- `List<Integer> getDateStampList()`  L708
- `String getFWDefaultResolution()`  L734
- `float getMaxZoomRatio()`  L768
- `int getNumberOfSensors()`  L794
- `int getPreviewCacheTime()`  L808
- `int getRecordingRemainTime()`  L834
- `int getRemainImageNum()`  L863
- `List<ICatchVideoFormat> getResolutionList()`  L893
    - 体内字面量："CameraProperties" · "start getResolution" · "CameraProperties" · "Exception e:" · "CameraProperties" · "end getResolution retList=" · "CameraProperties" · "end getResolution format="
- `List<ICatchVideoFormat> getResolutionList(int i)`  L911
    - 体内字面量："CameraProperties" · "start getResolution" · "CameraProperties" · "Exception e:" · "CameraProperties" · "end getResolution retList=" · "CameraProperties" · "end getResolution format="
- `List<Integer> getSupportFuction()`  L932
- `List<Integer> getSupportedCaptureDelays()`  L962
- `List<Integer> getSupportedFrequencies()`  L996
- `List<String> getSupportedImageSizes()`  L1022
- `List<Integer> getSupportedLightFrequencys()`  L1054
- `List<Integer> getSupportedModes()`  L1089
- `List<Integer> getSupportedPropertyValues(int i)`  L1111
- `List<Integer> getSupportedTimeLapseDurations()`  L1141
- `List<Integer> getSupportedTimeLapseIntervals()`  L1170
- `List<String> getSupportedVideoSizes()`  L1199
- `List<Integer> getSupportedWhiteBalances()`  L1229
- `int getVideoRecordingTime()`  L1259
- `int getVideoSizeFlow()`  L1273
- `List<Integer> getsupportedBurstNums()`  L1287
- `List<Integer> getsupportedDateStamps()`  L1321
- `boolean hasFuction(int i)`  L1347
    - 体内字面量："CameraProperties" · "begin hasFuction query fuction = " · "CameraProperties" · "end hasFuction retValue ="
- `boolean isSDCardExist()`  L1357
- `boolean isSupportPreview()`  L1379
- `boolean notifyCameraConnectChnage(int i)`  L1393
- `boolean notifyFwToShareMode(int i)`  L1419
- `boolean setCameraDate()`  L1445
- `boolean setCameraDateTimeZone()`  L1472
- `boolean setCameraEssidName(String str)`  L1502
- `boolean setCameraEssidPassword(String str)`  L1528
- `boolean setCameraName(String str)`  L1554
- `boolean setCameraPassword(String str)`  L1580
- `boolean setCameraPasswordNew(String str)`  L1606
- `boolean setCameraSsid(String str)`  L1632
- `boolean setCaptureDelay(int i)`  L1658
    - 体内字面量："CameraProperties" · "begin setCaptureDelay set value ="
- `boolean setCaptureDelayMode(int i)`  L1682
- `boolean setCurrentBurst(int i)`  L1708
    - 体内字面量："CameraProperties" · "begin setCurrentBurst set value = "
- `boolean setDateStamp(int i)`  L1732
    - 体内字面量："CameraProperties" · "begin setDateStampType set value = "
- `boolean setImageSize(String str)`  L1757
- `boolean setLightFrequency(int i)`  L1783
    - 体内字面量："CameraProperties" · "begin setLightFrequency set value ="
- `boolean setPropertyValue(int i, int i2)`  L1807
- `boolean setServiceEssid(String str)`  L1833
- `boolean setServicePassword(String str)`  L1859
- `boolean setSlowMotion(int i)`  L1885
- `boolean setStreamingInfo(ICatchVideoFormat iCatchVideoFormat)`  L1911
- `boolean setStringPropertyValue(int i, String str)`  L1937
- `boolean setTimeLapseDuration(int i)`  L1963
    - 体内字面量："CameraProperties" · "begin setTimeLapseDuration videoDuration ="
- `boolean setTimeLapseInterval(int i)`  L1987
- `boolean setUpsideDown(int i)`  L2013
- `boolean setVideoSize(String str)`  L2039
- `boolean setWhiteBalance(int i)`  L2065
    - 体内字面量："CameraProperties" · "begin setWhiteBalanceset value ="
- `boolean supportVideoPlayback()`  L2089
### `com.icatch.golive.SdkApi.CameraState`
L8 · [class] public CameraState · `com/icatch/golive/SdkApi/CameraState.java`

字段/常量（6）：
- `ICatchCameraState cameraState`  L9
- `String tag = "CameraState"`  L10
- `boolean zIsMovieRecording`  L17
- `boolean zSupportImageAutoDownload`  L31
- `boolean zIsTimeLapseStillOn`  L45
- `boolean zIsTimeLapseVideoOn`  L59

方法（5）：
- `public CameraState(ICatchCameraState iCatchCameraState)`  L12
- `boolean isMovieRecording()`  L16
- `boolean isSupportImageAutoDownload()`  L30
- `boolean isTimeLapseStillOn()`  L44
- `boolean isTimeLapseVideoOn()`  L58
### `com.icatch.golive.SdkApi.FileOperation`
L18 · [class] public FileOperation · `com/icatch/golive/SdkApi/FileOperation.java`

字段/常量（14）：
- `ICatchCameraPlayback cameraPlayback`  L19
- `String tag = "FileOperation"`  L20
- `boolean zCancelFileDownload`  L27
- `ICatchCameraPlayback iCatchCameraPlayback = this.cameraPlayback`  L29
- `boolean zDeleteFile`  L57
- `ICatchFrameBuffer iCatchFrameBufferDownloadFile`  L86
- `boolean zDownloadFile`  L119
- `int fileCount`  L149
- `List<ICatchFile> listListFiles`  L163
- `List<ICatchFile> listListFiles`  L194
- `ICatchFrameBuffer quickview`  L224
- `ICatchFrameBuffer thumbnail`  L289
- `boolean fileListAttribute = false`  L327
- `boolean fileListAttribute = false`  L341

方法（13）：
- `public FileOperation(ICatchCameraPlayback iCatchCameraPlayback)`  L22
- `boolean cancelDownload()`  L26
- `boolean deleteFile(ICatchFile iCatchFile)`  L56
- `ICatchFrameBuffer downloadFile(ICatchFile iCatchFile)`  L85
- `boolean downloadFile(ICatchFile iCatchFile, String str)`  L118
- `int getFileCount()`  L148
- `List<ICatchFile> getFileList(int i)`  L162
- `List<ICatchFile> getFileList(int i, int i2, int i3)`  L193
- `ICatchFrameBuffer getQuickview(ICatchFile iCatchFile)`  L223
- `ICatchFrameBuffer getThumbnail(ICatchFile iCatchFile)`  L259
    - 体内字面量："FileOperation" · "IchCameraModeException" · "FileOperation" · "IchBufferTooSmallException" · "FileOperation" · "IchDeviceException" · "FileOperation" · "IchInvalidSessionException" · "FileOperation" · "IchNoSuchFileException" · "FileOperation" · "IchSocketException"
- `ICatchFrameBuffer getThumbnail(String str)`  L288
- `boolean setFileListAttribute(int i)`  L325
    - 体内字面量："FileOperation" · "begin setFileListAttribute filterType="
- `boolean setFileListAttribute(int i, int i2)`  L339
    - 体内字面量："FileOperation" · "begin setFileListAttribute filterType=" · " sensorsType="
### `com.icatch.golive.SdkApi.ICatchCustomerMJPGStreamParam`
L9 · [class] public ICatchCustomerMJPGStreamParam · implements `ICatchStreamParam` · `com/icatch/golive/SdkApi/ICatchCustomerMJPGStreamParam.java`

字段/常量（6）：
- `int bitRate`  L10
- `int codec`  L11
- `int frameRate`  L12
- `int height`  L13
- `int qSize`  L14
- `int width`  L15

方法（12）：
- `public ICatchCustomerMJPGStreamParam()`  L17
- `public ICatchCustomerMJPGStreamParam(int i, int i2)`  L26
- `public ICatchCustomerMJPGStreamParam(int i, int i2, int i3)`  L35
- `public ICatchCustomerMJPGStreamParam(int i, int i2, int i3, int i4)`  L44
- `int getBitRate()`  L54 @Override
- `String getCmdLineParam()`  L59 @Override
    - 体内字面量："MJPG?W=" · "&H=" · "&Q=" · "&BR="
- `int getCodec()`  L69 @Override
- `int getFrameRate()`  L74 @Override
- `int getHeight()`  L79 @Override
- `int getTransportType()`  L84 @Override
- `int getWidth()`  L89 @Override
- `String toString()`  L93
    - 体内字面量："codecName" · "JPEG" · "codec" · "qSize" · "videoW" · "videoH" · "bitRate" · "frameRate"
### `com.icatch.golive.SdkApi.mobileapi.MediaPlayListenerManager`
L14 · [class] public MediaPlayListenerManager · `com/icatch/golive/SdkApi/mobileapi/MediaPlayListenerManager.java`

字段/常量（9）：
- `int CACHE_LOADED = 2`  L15
- `int CACHE_LOADING = 1`  L16
- `String TAG = "MediaPlayListenerManager"`  L17
- `EventListener eventListener`  L18
- `ICatchIPancamControl pancamControl`  L19
- `StreamStateListener streamStateListener`  L20
- `String str = TAG`  L69
- `String str = TAG`  L89
- `StreamStateListener streamStateListener = this.streamStateListener`  L92

方法（4）：
- `public MediaPlayListenerManager(EventListener eventListener, ICatchIPancamControl iCatchIPancamControl)`  L63
- `void addListener()`  L68
- `void removeListener()`  L88
- `void setEventListener(EventListener eventListener)`  L110
### `com.icatch.golive.SdkApi.mobileapi.MediaPlayListenerManager$StreamStateListener`
L22 · [class] public StreamStateListener · implements `ICatchIPancamListener` · `com/icatch/golive/SdkApi/mobileapi/MediaPlayListenerManager.java`

方法（2）：
- `public StreamStateListener()`  L23
- `void eventNotify(ICatchGLEvent iCatchGLEvent)`  L27 @Override
    - 体内字面量："--------------receive ICH_GL_EVENT_VIDEO_STREAM_PLAYING_ENDED" · "receive ICH_GL_EVENT_VIDEO_PLAYBACK_CACHING_PROGRESS.......value=" · " value2=" · "receive ICH_GL_EVENT_VIDEO_PLAYBACK_CACHING_CHANGED.......value="
### `com.icatch.golive.SdkApi.mobileapi.PanoramaControl`
L16 · [class] public PanoramaControl · implements `IPanoramaControl` · `com/icatch/golive/SdkApi/mobileapi/PanoramaControl.java`

字段/常量（15）：
- `String TAG = "PanoramaControl"`  L17
- `ICatchSurfaceContext iCatchSurfaceContext`  L18
- `ICatchIPancamGL pancamGL`  L19
- `int surfaceType = 1`  L20
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L27
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L41
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L89
- `boolean zInit = false`  L90
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L106
- `boolean zRelease = false`  L107
- `ICatchSurfaceContext iCatchSurfaceContext`  L123
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L124
- `boolean zRemoveSurface = false`  L125
- `boolean surface2 = false`  L157
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L176

方法（11）：
- `public PanoramaControl(ICatchIPancamGL iCatchIPancamGL)`  L22
- `ICatchIPancamGLTransform getPancamGLTransform()`  L26
- `boolean changePanoramaType(int i)`  L40 @Override
- `boolean glTransformLocate(float f)`  L54 @Override
- `boolean glTransformLocate(int i, float f, float f2, float f3, long j)`  L71 @Override
- `boolean init(int i)`  L88 @Override
- `boolean release()`  L105 @Override
- `boolean removeSurface(int i)`  L122 @Override
- `boolean rotate(GLPoint gLPoint, GLPoint gLPoint2)`  L139 @Override
- `boolean setSurface(int i, Surface surface)`  L156 @Override
- `boolean setViewPort(int i, int i2)`  L175 @Override
### `com.icatch.golive.SdkApi.mobileapi.PanoramaSession`
L33 · [class] public PanoramaSession · `com/icatch/golive/SdkApi/mobileapi/PanoramaSession.java`

字段/常量（19）：
- `String TAG = "PanoramaSession"`  L34
- `ICatchCameraSession iCatchCameraSession`  L35
- `ICatchPancamSession iCatchPancamSession`  L36
- `ICatchINETTransport transport`  L37
- `boolean isConnected = false`  L38
- `boolean cameraSessionPrepared = false`  L39
- `String str3 = TAG`  L42
- `String str = TAG`  L62
- `Boolean boolValueOf = false`  L64
- `ICatchPancamSession iCatchPancamSession = this.iCatchPancamSession`  L75
- `boolean zDestroySession = false`  L76
- `ICatchINETTransport iCatchINETTransport = this.transport`  L92
- `ICatchCameraPlayback playbackClient`  L107
- `List<ICatchFile> listListFiles`  L108
- `String str = TAG`  L118
- `ICatchCameraControl controlClient`  L149
- `boolean zPrepareSession`  L169
- `boolean zPrepareSession`  L206
- `boolean stringPropertyValue`  L220

方法（11）：
- `boolean connect(boolean z, String str, String str2)`  L41
- `boolean destroyCameraSession()`  L61
- `boolean destroySession()`  L74
- `boolean disconnect()`  L88
- `DeviceFile getCameraFile()`  L106
- `IStreamingControl getPreviewStream()`  L148
- `ICatchPancamSession getSession()`  L160
- `IStreamingControl getVideoStream()`  L164
- `boolean prepareCameraSession(ICatchITransport iCatchITransport, boolean z)`  L168
- `boolean prepareSession(ICatchITransport iCatchITransport)`  L205
- `boolean setCameraDate()`  L219
### `com.icatch.golive.SdkApi.mobileapi.PreviewStreamingControl`
L27 · [class] public PreviewStreamingControl · implements `IStreamingControl` · `com/icatch/golive/SdkApi/mobileapi/PreviewStreamingControl.java`

字段/常量（12）：
- `String TAG = "PreviewStreamingControl"`  L28
- `ICatchCameraControl cameraControl`  L29
- `ICatchSurfaceContext iCatchSurfaceContext`  L30
- `ICatchIPancamPreview pancamPreview`  L31
- `IPanoramaControl panoramaControl`  L32
- `ICatchIStreamProvider iCatchIStreamProviderDisableRender`  L41
- `boolean zEnableRender`  L71
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L142
- `ICatchStreamParam iCatchJPEGStreamParam`  L156
- `boolean zStart`  L157
- `String str = TAG`  L159
- `boolean zStop`  L194

方法（18）：
- `public PreviewStreamingControl(ICatchIPancamPreview iCatchIPancamPreview, ICatchCameraControl iCatchCameraControl)`  L34
- `IStreamProvider disableRender()`  L40 @Override
- `IPanoramaControl enableGLRender()`  L57 @Override
- `boolean enableRender(Surface surface)`  L70 @Override
- `double getDuration()`  L87 @Override
- `IPanoramaControl getPanoramaControl()`  L92 @Override
- `boolean isMute()`  L97 @Override
- `boolean isOpenStream()`  L102 @Override
- `int mute(boolean z)`  L107 @Override
- `int pause()`  L112 @Override
- `int play()`  L117 @Override
- `int resume()`  L122 @Override
- `int seek(double d)`  L127 @Override
- `void setEventListener(EventListener eventListener)`  L132 @Override
- `boolean setVideoQuality(VideoQuality videoQuality)`  L136 @Override
- `boolean setViewPort(int i, int i2)`  L141 @Override
- `int start(StreamRequest streamRequest)`  L155 @Override
- `int stop()`  L193 @Override
### `com.icatch.golive.SdkApi.mobileapi.StreamProvider`
L19 · [class] public StreamProvider · implements `IStreamProvider` · `com/icatch/golive/SdkApi/mobileapi/StreamProvider.java`

字段/常量（5）：
- `String TAG = "StreamProvider"`  L20
- `ICatchIStreamProvider streamProvider`  L21
- `ICatchAudioFormat audioFormat`  L67
- `ICatchVideoFormat videoFormat`  L129
- `MVideoFormat mVideoFormat = null`  L130

方法（7）：
- `public StreamProvider(ICatchIStreamProvider iCatchIStreamProvider)`  L23
- `boolean containsAudioStream()`  L28 @Override
- `boolean containsVideoStream()`  L47 @Override
- `MAudioFormat getAudioFormat()`  L66 @Override
- `boolean getNextAudioFrame(FrameBuffer frameBuffer)`  L90 @Override
- `boolean getNextVideoFrame(FrameBuffer frameBuffer)`  L109 @Override
- `MVideoFormat getVideoFormat()`  L128 @Override
### `com.icatch.golive.SdkApi.mobileapi.SurfaceContext`
L7 · [class] public SurfaceContext · implements `ISurfaceContext` · `com/icatch/golive/SdkApi/mobileapi/SurfaceContext.java`

字段/常量（1）：
- `Surface surface`  L8

方法（4）：
- `public SurfaceContext(Surface surface)`  L10
- `Surface getSurface()`  L15 @Override
- `int getSurfaceID()`  L20 @Override
- `boolean setViewPort(int i, int i2, int i3, int i4)`  L25 @Override
### `com.icatch.golive.SdkApi.mobileapi.VideoStreamingControl`
L25 · [class] public VideoStreamingControl · implements `IStreamingControl` · `com/icatch/golive/SdkApi/mobileapi/VideoStreamingControl.java`

字段/常量（23）：
- `String TAG = "VideoStreamingControl"`  L26
- `EventListener eventListener`  L27
- `ICatchSurfaceContext iCatchSurfaceContext`  L28
- `boolean isStreaming = false`  L29
- `MediaPlayListenerManager mediaPlayListenerManager`  L30
- `ICatchIPancamControl pancamControl`  L31
- `IPanoramaControl panoramaControl`  L32
- `ICatchIPancamVideoPlayback videoPlayback`  L33
- `ICatchIStreamProvider iCatchIStreamProviderDisableRender`  L42
- `String str = TAG`  L60
- `boolean zEnableRender`  L75
- `double length`  L93
- `boolean zPause`  L128
- `boolean zResume`  L148
- `boolean zSeek`  L163
- `MediaPlayListenerManager mediaPlayListenerManager = this.mediaPlayListenerManager`  L179
- `ICatchSurfaceContext iCatchSurfaceContext = this.iCatchSurfaceContext`  L194
- `boolean zPlay`  L208
- `MediaPlayListenerManager mediaPlayListenerManager`  L209
- `String str = TAG`  L221
- `boolean zStop`  L258
- `MediaPlayListenerManager mediaPlayListenerManager`  L259
- `String str = TAG`  L275

方法（18）：
- `public VideoStreamingControl(ICatchIPancamVideoPlayback iCatchIPancamVideoPlayback, ICatchIPancamControl iCatchIPancamControl)`  L35
- `IStreamProvider disableRender()`  L41 @Override
- `IPanoramaControl enableGLRender()`  L59 @Override
- `boolean enableRender(Surface surface)`  L74 @Override
- `double getDuration()`  L92 @Override
- `IPanoramaControl getPanoramaControl()`  L107 @Override
- `boolean isMute()`  L112 @Override
- `boolean isOpenStream()`  L117 @Override
- `int mute(boolean z)`  L122 @Override
- `int pause()`  L127 @Override
- `int play()`  L142 @Override
- `int resume()`  L147 @Override
- `int seek(double d)`  L162 @Override
- `void setEventListener(EventListener eventListener)`  L177 @Override
- `boolean setVideoQuality(VideoQuality videoQuality)`  L188 @Override
- `boolean setViewPort(int i, int i2)`  L193 @Override
- `int start(StreamRequest streamRequest)`  L207 @Override
- `int stop()`  L257 @Override
### `com.icatch.golive.SdkApi.PanoramaControl`
L11 · [class] public PanoramaControl · `com/icatch/golive/SdkApi/PanoramaControl.java`

字段/常量（3）：
- `String TAG = "PanoramaControl"`  L12
- `ICatchIPancamControl iCatchIPancamControl`  L13
- `ICatchIPancamControl iCatchIPancamControl = this.iCatchIPancamControl`  L34

方法（3）：
- `public PanoramaControl(ICatchPancamSession iCatchPancamSession)`  L15
- `void addEventListener(int i, ICatchIPancamListener iCatchIPancamListener)`  L19
    - 体内字面量："addEventListener var1:" · "addEventListener e:" · "addEventListener ret:"
- `void removeEventListener(int i, ICatchIPancamListener iCatchIPancamListener)`  L33
### `com.icatch.golive.SdkApi.PanoramaPhotoPlayback`
L22 · [class] public PanoramaPhotoPlayback · `com/icatch/golive/SdkApi/PanoramaPhotoPlayback.java`

字段/常量（20）：
- `String TAG = "PanoramaPhotoPlayback"`  L23
- `ICatchIPancamGL pancamGL`  L24
- `ICatchIPancamImage photoPlayback`  L25
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L41
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L56
- `boolean zChangePanoramaType = false`  L57
- `String str = TAG`  L75
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L104
- `boolean zClearFormat = false`  L105
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L121
- `boolean zInit = false`  L122
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L141
- `boolean format = false`  L142
- `boolean zLocate = false`  L159
- `boolean zRelease`  L207
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L224
- `boolean zRemoveSurface = false`  L225
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L244
- `boolean surface = false`  L245
- `boolean zUpdate`  L263

方法（17）：
- `public PanoramaPhotoPlayback(ICatchPancamSession iCatchPancamSession)`  L27
    - 体内字面量："photoPlayback = "
- `ICatchIPancamGLTransform getPancamGLTransform()`  L40
- `boolean changePanoramaType(int i)`  L54
    - 体内字面量："start changePanoramaType"
- `boolean clear()`  L74
- `ICatchIPancamGL enableGLRender(int i)`  L82
    - 体内字面量："start enableGLRender panoramaType:" · "Exception e:" · "end enableGLRender pancamGL:"
- `ICatchIPancamGL getPancamGL()`  L94
- `ICatchIPancamImage getPhotoPlayback()`  L98
- `boolean pancamGLClearFormat()`  L102
    - 体内字面量："start pancamGLClearFormat"
- `boolean pancamGLInit()`  L119
    - 体内字面量："start pancamGLInit"
- `boolean pancamGLSetFormat(int i, int i2, int i3)`  L139
    - 体内字面量："start pancamGLSetFormat type=" · " width=" · " height="
- `boolean pancamGLTransLocate(float f)`  L156
    - 体内字面量："start pancamGLTransLocate "
- `boolean pancamGLTransformRotate(int i, float f, float f2, float f3, long j)`  L174
- `boolean pancamGLTransformRotate(ICatchGLPoint iCatchGLPoint, ICatchGLPoint iCatchGLPoint2)`  L190
- `boolean release()`  L206
- `boolean removeSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L222
    - 体内字面量："start removeSurface "
- `boolean setSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L242
    - 体内字面量："start setSurface "
- `boolean update(ICatchGLImage iCatchGLImage)`  L262
### `com.icatch.golive.SdkApi.PanoramaPreviewPlayback`
L41 · [class] public PanoramaPreviewPlayback · `com/icatch/golive/SdkApi/PanoramaPreviewPlayback.java`

字段/常量（43）：
- `String TAG = "PanoramaPreviewPlayback"`  L42
- `ICatchIPancamPreview previewPlayback`  L43
- `ICatchIPancamGL pancamGL = null`  L44
- `List<ICatchImageSize> imageSizelist = null`  L45
- `ICatchImageSize curImageSize = null`  L46
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L53
- `ICatchIPancamPreview iCatchIPancamPreview = this.previewPlayback`  L66
- `ICatchIPancamPreview iCatchIPancamPreview = this.previewPlayback`  L85
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L104
- `boolean zChangePanoramaType = false`  L105
- `String str3 = TAG`  L123
- `String str = TAG`  L136
- `ICatchIStreamProvider iCatchIStreamProviderDisableRender`  L148
- `boolean thumbnail`  L190
- `byte[] bArr = new byte[8294400]`  L192
- `String str = TAG`  L208
- `List<ICatchImageSize> list = this.imageSizelist`  L210
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L237
- `boolean zInit = false`  L238
- `String str = TAG`  L258
- `boolean zIsStreamSupportPublish = false`  L261
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L297
- `boolean zRelease = false`  L298
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L315
- `boolean zRemoveSurface = false`  L316
- `String str = TAG`  L366
- `boolean imageSize = false`  L369
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L397
- `boolean surface = false`  L398
- `String str = TAG`  L418
- `boolean zSnapImage = false`  L421
- `Tristate tristate = Tristate.FALSE`  L450
- `boolean zStart = false`  L451
- `String str = TAG`  L465
- `String str = TAG`  L472
- `String str2 = TAG`  L485
- `boolean zStartMovieRecord = false`  L488
- `boolean zStartPublishStreaming = false`  L517
- `boolean zStop`  L534
- `String str = TAG`  L553
- `String str = TAG`  L565
- `boolean zStopMovieRecord = false`  L568
- `boolean zStopPublishStreaming = false`  L594

方法（31）：
- `public PanoramaPreviewPlayback(ICatchPancamSession iCatchPancamSession)`  L48
- `ICatchIPancamGLTransform getPancamGLTransform()`  L52
- `ICatchIStreamControl getStreamControl()`  L65
- `ICatchIStreamPublish getStreamPublish()`  L83
    - 体内字面量："getStreamPublish"
- `boolean changePanoramaType(int i)`  L102
    - 体内字面量："start changePanoramaType panoramaType="
- `String createChannel(ICatchGLCredential iCatchGLCredential, String str, String str2, boolean z)`  L122
- `void deleteChannel()`  L135
- `ICatchIStreamProvider disableRender()`  L147
- `boolean enableCommonRender(ICatchSurfaceContext iCatchSurfaceContext)`  L160
    - 体内字面量："Exception : "
- `boolean enableGLRender()`  L171
    - 体内字面量："enableGLRender" · "Exception : " · "end enableGLRender"
- `ICatchImageSize getCurImageSize()`  L184
    - 体内字面量："start getCurImageSize curImageSize="
- `Bitmap getPvThumbnail()`  L189
- `List<ICatchImageSize> getSupportedImageSize()`  L207
- `boolean init(int i)`  L235
    - 体内字面量："start init "
- `boolean isStreamSupportPublish()`  L257
- `boolean locate(float f)`  L279
- `boolean release()`  L295
    - 体内字面量："start pancamGLRelease "
- `boolean removeSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L313
    - 体内字面量："start removeSurface "
- `boolean rotate(int i, float f, float f2, float f3, long j)`  L333
- `boolean rotate(ICatchGLPoint iCatchGLPoint, ICatchGLPoint iCatchGLPoint2)`  L349
- `boolean setImageSize(ICatchImageSize iCatchImageSize)`  L365
- `boolean setSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L395
    - 体内字面量："start initSurface "
- `boolean snapImage(ICatchFrameBuffer iCatchFrameBuffer, int i)`  L417
- `Tristate start(ICatchStreamParam iCatchStreamParam, boolean z)`  L448
    - 体内字面量："start Stream ICatchStreamParam=" · " enableAudio="
- `String startLive()`  L471
- `boolean startMovieRecord(String str, boolean z)`  L484
- `boolean startPublishStreaming(String str)`  L515
- `boolean stop()`  L533
- `void stopLive()`  L552
- `boolean stopMovieRecord()`  L564
- `boolean stopPublishStreaming()`  L592
### `com.icatch.golive.SdkApi.PanoramaVideoPlayback`
L28 · [class] public PanoramaVideoPlayback · `com/icatch/golive/SdkApi/PanoramaVideoPlayback.java`

字段/常量（25）：
- `String TAG = "PanoramaVideoPlayback"`  L29
- `ICatchIPancamGL pancamGL`  L30
- `StreamStablization streamStablization`  L31
- `ICatchIPancamVideoPlayback videoPlayback`  L32
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L48
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L62
- `boolean zChangePanoramaType = false`  L63
- `double length`  L123
- `String str = TAG`  L141
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L143
- `boolean zInit = false`  L144
- `boolean zPlay`  L176
- `String str = TAG`  L190
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L192
- `boolean zRelease = false`  L193
- `boolean zPause`  L209
- `String str = TAG`  L231
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L233
- `boolean zRemoveSurface = false`  L234
- `boolean zResume`  L250
- `String str = TAG`  L308
- `ICatchIPancamGL iCatchIPancamGL = this.pancamGL`  L310
- `boolean surface = false`  L311
- `boolean zStop`  L327
- `boolean zSeek`  L341

方法（22）：
- `public PanoramaVideoPlayback(ICatchPancamSession iCatchPancamSession)`  L34
- `ICatchIPancamGLTransform getPancamGLTransform()`  L47
- `boolean changePanoramaType(int i)`  L60
    - 体内字面量："start changePanoramaType panoramaType="
- `ICatchIStreamProvider disableRender()`  L80
    - 体内字面量："Exception : "
- `boolean enableCommonRender(ICatchSurfaceContext iCatchSurfaceContext)`  L90
    - 体内字面量："Exception : "
- `void enableGLRender()`  L101
    - 体内字面量："Exception : " · "enableGLRender pancamGL="
- `void enableGLRender(int i)`  L111
    - 体内字面量："begin enableGLRender var1=" · "Exception : " · "enableGLRender pancamGL="
- `int getLength()`  L122
- `StreamStablization getStreamStablization()`  L136
- `boolean initPancamGL(int i)`  L140
- `boolean locate(float f)`  L159
- `boolean openVideoStream(ICatchFile iCatchFile, boolean z, boolean z2)`  L175
- `boolean pancamGLRelease()`  L189
- `boolean pausePlayback()`  L208
- `boolean removeSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L230
- `boolean resumePlayback()`  L249
- `boolean rotate(int i, float f, float f2, float f3, long j)`  L271
- `boolean rotate(ICatchGLPoint iCatchGLPoint, ICatchGLPoint iCatchGLPoint2)`  L287
- `boolean setFormat(int i)`  L303
- `boolean setSurface(int i, ICatchSurfaceContext iCatchSurfaceContext)`  L307
- `boolean stop()`  L326
- `boolean videoSeek(double d)`  L340
### `com.icatch.golive.SdkApi.StreamProvider`
L19 · [class] public StreamProvider · `com/icatch/golive/SdkApi/StreamProvider.java`

字段/常量（9）：
- `String TAG = "StreamProvider"`  L20
- `ICatchIStreamProvider iCatchIStreamProvider`  L21
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L29
- `boolean zContainsAudioStream = false`  L30
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L44
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L58
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L73
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L102
- `ICatchIStreamProvider iCatchIStreamProvider = this.iCatchIStreamProvider`  L128

方法（7）：
- `public StreamProvider(ICatchIStreamProvider iCatchIStreamProvider)`  L23
- `boolean containsAudioStream()`  L27
    - 体内字面量："start containsAudioStream"
- `boolean containsVideoStream()`  L43
- `ICatchAudioFormat getAudioFormat()`  L57
- `boolean getNextAudioFrame(ICatchFrameBuffer iCatchFrameBuffer)`  L72
- `boolean getNextVideoFrame(ICatchFrameBuffer iCatchFrameBuffer)`  L101
- `ICatchVideoFormat getVideoFormat()`  L127
### `com.icatch.golive.SdkApi.StreamStablization`
L8 · [class] public StreamStablization · `com/icatch/golive/SdkApi/StreamStablization.java`

字段/常量（6）：
- `String TAG = "StreamStablization"`  L9
- `ICatchIStreamStablization streamStablization`  L10
- `ICatchIStreamStablization iCatchIStreamStablization = this.streamStablization`  L18
- `boolean zDisableStablization = false`  L19
- `ICatchIStreamStablization iCatchIStreamStablization = this.streamStablization`  L34
- `boolean zEnableStablization = false`  L35

方法（3）：
- `public StreamStablization(ICatchIStreamStablization iCatchIStreamStablization)`  L12
- `boolean disableStablization()`  L16
    - 体内字面量："disableStablization "
- `boolean enableStablization()`  L32
    - 体内字面量："enableStablization "