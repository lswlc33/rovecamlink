# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv.biz

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 18 个文件 / 28 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.biz.Command`
L8 · [class] public Command · `com/gku/actioncam/hisilicon/dv/biz/Command.java`

字段/常量（24）：
- `int ACTION_BURST = 3`  L9
- `int ACTION_BUTT = 21`  L10
- `int ACTION_CONTINUOUS_START = 8`  L11
- `int ACTION_CONTINUOUS_STOP = 9`  L12
- `int ACTION_PHOTO = 2`  L13
- `int ACTION_RECORD_START = 0`  L14
- `int ACTION_RECORD_STOP = 1`  L15
- `int ACTION_TIMELAPSE_START = 4`  L16
- `int ACTION_TIMELAPSE_STOP = 5`  L17
- `int ACTION_TIMER_START = 6`  L18
- `int ACTION_TIMER_STOP = 7`  L19
- `int ACTION_VIDEO_COMMON_START = 11`  L20
- `int ACTION_VIDEO_COMMON_STOP = 12`  L21
- `int ACTION_VIDEO_LOOP_START = 13`  L22
- `int ACTION_VIDEO_LOOP_STOP = 14`  L23
- `int ACTION_VIDEO_QUICK_EXIT = 10`  L24
- `int ACTION_VIDEO_SLOW_START = 19`  L25
- `int ACTION_VIDEO_SLOW_STOP = 20`  L26
- `int ACTION_VIDEO_SNAP_START = 17`  L27
- `int ACTION_VIDEO_SNAP_STOP = 18`  L28
- `int ACTION_VIDEO_TIMELAPSE_START = 15`  L29
- `int ACTION_VIDEO_TIMELAPSE_STOP = 16`  L30
- `String[] cgiFilesParams = {"/record.cgi?&-cmd=start", "/record.cgi?&-cmd=stop", "/photo.cgi?&-type=photo", "/photo.cgi?&-type=photoburst", "/photo.cgi?&-type=phototimelapse&-cmd=start", "/photo.cgi?&-type=phototimelapse&-cmd=stop", "/photo.cgi?&-type=phototimer&-cmd=start", "/photo.cgi?&-type=phototimer&-cmd=stop", "/photo.cgi?&-type=continuous&-cmd=start", "/photo.cgi?&-type=continuous&-cmd=stop", "/exitquickrec.cgi", "/record2.cgi?&-type=common&-cmd=start", "/record2.cgi?&-type=common&-cmd=stop", "/record2.cgi?&-type=loop&-cmd=start", "/record2.cgi?&-type=loop&-cmd=stop", "/record2.cgi?&-type=timelapse&-cmd=start", "/record2.cgi?&-type=timelapse&-cmd=stop", "/record2.cgi?&-type=recsnap&-cmd=start", "/record2.cgi?&-type=recsnap&-cmd=stop", "/record2.cgi?&-type=slow&-cmd=start", "/record2.cgi?&-type=slow&-cmd=stop"}`  L31
- `int i = httpResultDoHttpGetForContent.statusCode`  L60

方法（1）：
- `Common.Result executeCommand(String ip, int cmd)`  L33
    - 体内字面量："http://%s%s%s" · "SvrFuncResult" · "\"" · "sd is not ready" · "sd is full"
### `com.gku.actioncam.hisilicon.dv.biz.Common`
L7 · [class] public Common · `com/gku/actioncam/hisilicon/dv/biz/Common.java`

字段/常量（165）：
- `String BOOT_ACTION_IDLE = "idle"`  L8
- `String BOOT_ACTION_RECORD = "record"`  L9
- `String BOOT_ACTION_TIMELAPSE = "timelapse"`  L10
- `String CGI_PATH = "/cgi-bin/hi3510"`  L11
- `int CONFIG_MULTI_BURST_RATE = 1`  L12
- `int CONFIG_MULTI_CONTINUOUS_RATE = 3`  L13
- `int CONFIG_MULTI_RESOLUTION = 0`  L14
- `int CONFIG_MULTI_TIMELAPSE_INTERVAL = 2`  L15
- `int CONFIG_PHOTO_RESOLUTION = 0`  L16
- `int CONFIG_PHOTO_SCENE = 2`  L17
- `int CONFIG_PHOTO_TIMER = 1`  L18
- `int CONFIG_VIDEO_LOOP_TYPE = 7`  L19
- `int CONFIG_VIDEO_PHOTO_MODE = 6`  L20
- `int CONFIG_VIDEO_PHOTO_PHOTO_RESOLUTION = 4`  L21
- `int CONFIG_VIDEO_PHOTO_SNAP_INTERVAL = 3`  L22
- `int CONFIG_VIDEO_PHOTO_SNAP_MODE = 2`  L23
- `int CONFIG_VIDEO_PHOTO_VIDEO_RESOLUTION = 5`  L24
- `int CONFIG_VIDEO_TIMELAPSE_INTERVAL = 1`  L25
- `int CONFIG_VIDEO_VIDEO_RESOLUTION = 0`  L26
- `String DATA_DIRECTORY_NAME = "ActionCam"`  L27
- `int ERR_CHANNEL_BUSY = -1560182777`  L28
- `int ERR_GET_CHANNEL_STATE_FAIL = -1560182778`  L29
- `int ERR_LOOP_NO_SPACE = -1560182780`  L30
- `int ERR_NO_SD = -1560182784`  L31
- `int ERR_RECORD_NO_SPACE = -1560182781`  L32
- `int ERR_RECORD_SPACE_FULL = -1610579967`  L33
- `int ERR_SANPSHOT_NO_SPACE = -1560182779`  L34
- `int ERR_SD_ERROR = -1560182782`  L35
- `int ERR_SD_FULL = -1560182783`  L36
- `int ERR_SNAPSHOT_PRARM_ERROR = -1560182774`  L37
- `int ERR_START_CHANNEL_FAIL = -1560182776`  L38
- `int ERR_STOP_CHANNEL_FAIL = -1560182775`  L39
- `int EVENT_AC_OFF = 18`  L40
- `int EVENT_AC_ON = 17`  L41
- `int EVENT_BATTERY_TEMPERATURE_ALARM = 14`  L42
- `int EVENT_BATTERY_TEMPERATURE_HIGH = 8`  L43
- `int EVENT_CHIP_TEMPERATURE_ALARM = 13`  L44
- `int EVENT_CHIP_TEMPERATURE_HIGH = 7`  L45
- `int EVENT_INVALID = 19`  L46
- `int EVENT_LOW_POWER = 9`  L47
- `int EVENT_LOW_POWER_ALARM = 15`  L48
- `int EVENT_NORMAL = 0`  L49
- `int EVENT_RECORD_ERROR = 2`  L50
- `int EVENT_RECORD_SPACE_FULL = 1`  L51
- `int EVENT_SDCARD_ERROR = 6`  L52
- `int EVENT_SDCARD_MOUNTED = 16`  L53
- `int EVENT_SDCARD_NOT_EXIST = 5`  L54
- `int EVENT_SHUTDOWN = 11`  L55
- `int EVENT_SNAPSHOT_ERROR = 4`  L56
- `int EVENT_SNAPSHOT_SPACE_FULL = 3`  L57
- `int EVENT_USB_CONNECTED = 10`  L58
- `int EVENT_USB_DISCONNECTED = 12`  L59
- `int FAILURE = -1`  L60
- `String ICGI_PATH = "/cgi-bin"`  L61
- `String KEY_ABOUT_CAMERA = "about_camera"`  L62
- `String KEY_AUDIO_CODEC = "audio_codec"`  L63
- `String KEY_AUTO_SHUTDOWN = "auto_shutdown"`  L64
- `String KEY_BOOT_ACTION = "boot_action"`  L65
- `String KEY_BURST_RATE = "burst_rate"`  L66
- `String KEY_BUZZER_PROMPT = "buzzer_prompt"`  L67
- `String KEY_CLEAR_CACHE = "clear_cache"`  L68
- `String KEY_DELETE_ALL_FILES = "delete_all_files"`  L69
- `String KEY_DOWNLOAD_VIDEO = "download_video"`  L70
- `String KEY_FIELD_OF_VIEW = "field_of_view"`  L71
- `String KEY_FILE_DOWNLOAD_SAVE_PATH = "file_download_save_path"`  L72
- `String KEY_FORMAT_SD_CARD = "format_sd_card"`  L73
- `String KEY_FRAME_RATE = "frame_rate"`  L74
- `String KEY_IMAGE_UPSIDEDOWN = "image_upsidedown"`  L75
- `String KEY_LED_FLICKER = "led_flicker"`  L76
- `String KEY_MASTER_MODE_MULTI_GROUP = "key_master_mode_multi_group"`  L77
- `String KEY_MASTER_MODE_PHOTO_GROUP = "key_master_mode_photo_group"`  L78
- `String KEY_MASTER_MODE_VIDEO_GROUP = "key_master_mode_video_group"`  L79
- `String KEY_MODE_MULTI_BURST_GROUP = "key_mode_multi_burst_group"`  L80
- `String KEY_MODE_MULTI_BURST_RATE = "key_mode_multi_burst_rate"`  L81
- `String KEY_MODE_MULTI_BURST_RESOLUTION = "key_mode_multi_burst_resolution"`  L82
- `String KEY_MODE_MULTI_CONTINUOUS_GROUP = "key_mode_multi_continuous_group"`  L83
- `String KEY_MODE_MULTI_CONTINUOUS_RATE = "key_mode_multi_continuous_rate"`  L84
- `String KEY_MODE_MULTI_CONTINUOUS_RESOLUTION = "key_mode_multi_continuous_resolution"`  L85
- `String KEY_MODE_MULTI_TIMELAPSE_GROUP = "key_mode_multi_timelapse_group"`  L86
- `String KEY_MODE_MULTI_TIMELAPSE_INTERVAL = "key_mode_multi_timelapse_interval"`  L87
- `String KEY_MODE_MULTI_TIMELAPSE_RESOLUTION = "key_mode_multi_timelapse_resolution"`  L88
- `String KEY_MODE_PHOTO_RAW_GROUP = "key_mode_photo_raw_group"`  L89
- `String KEY_MODE_PHOTO_RAW_RESOLUTION = "key_mode_photo_raw_resolution"`  L90
- `String KEY_MODE_PHOTO_SINGLE_GROUP = "key_mode_photo_single_group"`  L91
- `String KEY_MODE_PHOTO_SINGLE_RESOLUTION = "key_mode_photo_single_resolution"`  L92
- `String KEY_MODE_PHOTO_SINGLE_SCENE = "key_mode_photo_single_scene"`  L93
- `String KEY_MODE_PHOTO_TIMER_GROUP = "key_mode_photo_timer_group"`  L94
- `String KEY_MODE_PHOTO_TIMER_RESOLUTION = "key_mode_photo_timer_resolution"`  L95
- `String KEY_MODE_PHOTO_TIMER_SCENE = "key_mode_photo_timer_scene"`  L96
- `String KEY_MODE_PHOTO_TIMER_TIME = "key_mode_photo_timer_time"`  L97
- `String KEY_MODE_VIDEO_LOOP_GROUP = "key_mode_video_loop_group"`  L98
- `String KEY_MODE_VIDEO_LOOP_RESOLUTION = "key_mode_video_loop_resolution"`  L99
- `String KEY_MODE_VIDEO_LOOP_TYPE = "key_mode_video_loop_type"`  L100
- `String KEY_MODE_VIDEO_NORMAL_GROUP = "key_mode_video_normal_group"`  L101
- `String KEY_MODE_VIDEO_NORMAL_RESOLUTION = "key_mode_video_normal_resolution"`  L102
- `String KEY_MODE_VIDEO_PHOTO_GROUP = "key_mode_video_photo_group"`  L103
- `String KEY_MODE_VIDEO_PHOTO_LAPSE_INTERVAL = "key_mode_video_photo_lapse_interval"`  L104
- `String KEY_MODE_VIDEO_PHOTO_MODE = "key_mode_video_photo_mode"`  L105
- `String KEY_MODE_VIDEO_PHOTO_PHOTO_RESOLUTION = "key_mode_video_photo_photo_resolution"`  L106
- `String KEY_MODE_VIDEO_PHOTO_SNAP_INTERVAL = "key_mode_video_photo_snap_interval"`  L107
- `String KEY_MODE_VIDEO_PHOTO_SNAP_MODE = "key_mode_video_photo_snap_mode"`  L108
- `String KEY_MODE_VIDEO_PHOTO_VIDEO_RESOLUTION = "key_mode_video_photo_video_resolution"`  L109
- `String KEY_MODE_VIDEO_SLOW_GROUP = "key_mode_video_slow_group"`  L110
- `String KEY_MODE_VIDEO_SLOW_RESOLUTION = "key_mode_video_slow_resolution"`  L111
- `String KEY_MODE_VIDEO_TIMELAPSE_GROUP = "key_mode_video_timelapse_group"`  L112
- `String KEY_MODE_VIDEO_TIMELAPSE_INTERVAL = "key_mode_video_timelapse_interval"`  L113
- `String KEY_MODE_VIDEO_TIMELAPSE_RESOLUTION = "key_mode_video_timelapse_resolution"`  L114
- `String KEY_MODIFY_DV_NAME = "modify_dv_name"`  L115
- `String KEY_PHOTO_RESOLUTION = "photo_resolution"`  L116
- `String KEY_POWERON_UI_MODE = "poweron_ui_mode"`  L117
- `String KEY_PREVIEW_VIDEO = "preview_video"`  L118
- `String KEY_REC_SETTING = "rec_setting"`  L119
- `String KEY_RESTORE_SETTINGS = "restore_settings"`  L120
- `String KEY_SCREEN_AUTO_SLEEP = "screen_auto_sleep"`  L121
- `String KEY_SCREEN_BRIGHTNESS = "screen_brightness"`  L122
- `String KEY_SDCARD_LEFT = "sdcard_left"`  L123
- `String KEY_SDCARD_TOTAL = "sdcard_total"`  L124
- `String KEY_SET_DATETIME = "set_datetime"`  L125
- `String KEY_SOUND_PROMPT = "sound_prompt"`  L126
- `String KEY_SPOT_METERING = "spot_metering"`  L127
- `String KEY_TIMELAPSE_INTERVAL = "timelapse_interval"`  L128
- `String KEY_TIMER_COUNT_DOWN = "timer_count_down"`  L129
- `String KEY_TIME_TAG = "time_tag"`  L130
- `String KEY_UPDATE_VERSION = "update_version"`  L131
- `String KEY_VIDEO_MODE = "video_mode"`  L132
- `String KEY_VIDEO_RESOLUTION = "video_resolution"`  L133
- `String KEY_WIFI_PASSWORD = "wifi_password"`  L134
- `String KEY_WIFI_SSID = "wifi_ssid"`  L135
- `int MASTER_MODE_MULTI = 1`  L136
- `int MASTER_MODE_PHOTO = 0`  L137
- `int MASTER_MODE_PLAY = 3`  L138
- `int MASTER_MODE_VIDEO = 2`  L139
- `int SD_STATE_ERROR = 3`  L140
- `int SD_STATE_FULL = 1`  L141
- `int SD_STATE_NONE = 2`  L142
- `int SD_STATE_OK = 0`  L143
- `String SENSOR_117 = "117"`  L144
- `String SENSOR_34220 = "34220"`  L145
- `int SUCCESS = 0`  L146
- `String VIDEO_MODE_NTSC = "NTSC"`  L147
- `String VIDEO_MODE_PAL = "PAL"`  L148
- `int WORK_MODE_MULTI_BURST = 10`  L149
- `int WORK_MODE_MULTI_CONTINUOUS = 12`  L150
- `int WORK_MODE_MULTI_TIMELAPSE = 11`  L151
- `String WORK_MODE_NOMAL_VIDEO = "NormalVideo"`  L152
- `int WORK_MODE_PHOTO_RAW = 2`  L153
- `int WORK_MODE_PHOTO_SINGLE = 0`  L154
- `int WORK_MODE_PHOTO_TIMER = 1`  L155
- `int WORK_MODE_VIDEO_LAPSE_BURST = 26`  L156
- `int WORK_MODE_VIDEO_LOOP = 21`  L157
- `int WORK_MODE_VIDEO_NORMAL = 20`  L158
- `int WORK_MODE_VIDEO_PHOTO = 23`  L159
- `int WORK_MODE_VIDEO_QUICK = 25`  L160
- `int WORK_MODE_VIDEO_SLOW = 24`  L161
- `int WORK_MODE_VIDEO_TIMELAPSE = 22`  L162
- `int WORK_STATE_IDLE = 3`  L163
- `int WORK_STATE_RECORD = 0`  L164
- `int WORK_STATE_TIMELAPSE = 1`  L165
- `int WORK_STATE_TIMER = 2`  L166
- `int WORK_STATE_VIDEO_BURST = 6`  L167
- `int WORK_STATE_VIDEO_LOOP = 4`  L168
- `int WORK_STATE_VIDEO_TIMELAPSE = 5`  L169
- `int[] aEventStringRes = {R.string.event_normal, R.string.event_record_space_full, R.string.event_record_error, R.string.event_snapshot_space_full, R.string.event_snapshot_error, R.string.event_sdcard_not_exist, R.string.event_sdcard_error, R.string.event_chip_temperature_high, R.string.event_battery_temperature_high, R.string.event_low_power, R.string.event_usb_connected, R.string.event_shutdown, R.string.event_usb_disconnected, R.string.event_chip_temperature_alarm, R.string.event_battery_temperature_alarm, R.string.event_low_power_alarm, R.string.event_sdcard_mounted, R.string.event_ac_on, R.string.event_ac_off}`  L177
- `String CURRENT_AV_TRANSPORT_URI = "currentPath"`  L178
- `String CURRENT_MEDIA_PATHS = "currentPaths"`  L179
### `com.gku.actioncam.hisilicon.dv.biz.Common$BatteryInfo`
L181 · [class] public static BatteryInfo · `com/gku/actioncam/hisilicon/dv/biz/Common.java`

字段/常量（3）：
- `int capactiy = 0`  L182
- `boolean bCharging = false`  L183
- `boolean bAC = false`  L184
### `com.gku.actioncam.hisilicon.dv.biz.Common$DeviceAttr`
L198 · [class] public static DeviceAttr · `com/gku/actioncam/hisilicon/dv/biz/Common.java`

字段/常量（5）：
- `String name = "<binary/metadata>"`  L199
- `String serialNum = "<binary/metadata>"`  L200
- `String softVersion = "<binary/metadata>"`  L201
- `String hardVersion = "<binary/metadata>"`  L202
- `String type = Common.SENSOR_117`  L203

方法（1）：
- `String toString()`  L205
    - 体内字面量："DeviceAttr{name='" · "', serialNum='" · "', softVersion='" · "', hardVersion='" · "', type='" · "'}"
### `com.gku.actioncam.hisilicon.dv.biz.Common$Result`
L187 · [class] public static Result · `com/gku/actioncam/hisilicon/dv/biz/Common.java`

字段/常量（2）：
- `int returnCode = -1`  L188
- `int errorCode = -1`  L189
### `com.gku.actioncam.hisilicon.dv.biz.Common$SdCardInfo`
L192 · [class] public static SdCardInfo · `com/gku/actioncam/hisilicon/dv/biz/Common.java`

字段/常量（3）：
- `int sdState = 0`  L193
- `int total = -1`  L194
- `int used = -1`  L195
### `com.gku.actioncam.hisilicon.dv.biz.DV`
L32 · [class] public DV · `com/gku/actioncam/hisilicon/dv/biz/DV.java`

字段/常量（34）：
- `int AMBA_SESSION_ID`  L33
- `String CurItemValue`  L34
- `boolean IsConnectCamera`  L35
- `boolean IsSouport`  L36
- `int MAX_GET_FILE_COUNT`  L37
- `int Nomode`  L38
- `String Strmode`  L39
- `String TAG`  L40
- `CameraActivateInfors activateInfors`  L41
- `Common.BatteryInfo batteryInfo`  L42
- `CameraInfors cameraInfors`  L43
- `CameraStatus cameraStatus`  L44
- `String capability`  L45
- `String defaultIP`  L46
- `Common.DeviceAttr deviceAttr`  L47
- `String ip`  L48
- `boolean isDrive`  L49
- `boolean isDriveSupportBatch`  L50
- `boolean isSleeping`  L51
- `String macAddress`  L52
- `String mode`  L53
- `WorkModeConfig modeConfig`  L54
- `Prefer prefer`  L55
- `Common.SdCardInfo sdCardInfo`  L56
- `int workState`  L57
- `int workStateStr`  L58
- `String[] strArrSplit`  L149
- `int fileList = 0`  L375
- `int i = 0`  L392
- `String str = this.macAddress`  L699
- `String str = this.capability`  L737
- `Common.DeviceAttr deviceAttr = this.deviceAttr`  L741
- `String str = this.capability`  L749
- `String str = "<binary/metadata>"`  L778

方法（136）：
- `int getMAX_GET_FILE_COUNT()`  L60
- `private DV()`  L64
    - 体内字面量："DV" · "192.168.0.1" · "192.168.0.1" · "null"
- `DV getInstance()`  L96
- `boolean isLostConnectByBug(Context context)`  L100
    - 体内字面量："192.168.0.1"
- `boolean isDownloadBigVideo()`  L104
    - 体内字面量："Small" · "Big" · "Small" · "Small"
- `boolean isPreviewBigBitRate()`  L119
    - 体内字面量："Small" · "Big" · "Small" · "Small"
- `void loadLocalPreferences(Context context)`  L134
    - 体内字面量："1080P" · "Small" · "Small"
- `void setDownloadViewSize(Context context, String str)`  L142
- `void loadRemoteWorkModeConfig()`  L148
- `void loadRemotePreferences()`  L214
    - 体内字面量："fps" · "count" · "DV" · "loadRemotePreferences: "
- `void getWorkModeNewApp()`  L315
- `String getVideoRtspURL()`  L319
    - 体内字面量："rtsp://" · ":554/livestream/" · "11" · "12"
- `String getVideoHttpURL()`  L331
    - 体内字面量：":80/" · "11?" · "12?" · "trans=tcp&action=play&media=video_data"
- `String getDownloadPath()`  L344
    - 体内字面量："/"
- `Common.Result executeCommand(int cmd)`  L348
- `int getFileList(int start, int end, ArrayList<MediaModel> list)`  L358
- `int getFileNameList(int start, int end, ArrayList<String> list)`  L362
- `int getFileCount()`  L366
- `int getAllFileNames(ArrayList<MediaModel> list)`  L370
- `int getFileInfo(String file, Map<String, String> map)`  L382
- `int deleteFile(String file)`  L386
- `int deleteFiles(List<String> list)`  L390
- `int getVideoInfo(Map<String, String> map)`  L401
- `int setVideoInfo(String resolution, int frameRate)`  L405
- `int getBatteryInfo()`  L409
- `int getWorkState()`  L419
- `int getSdCardInfo()`  L424
- `String getIP()`  L434
- `void setIP(String ip)`  L438
- `int getViewField()`  L442
- `int setViewField(int viewField)`  L446
- `Boolean getLoopRecord()`  L450
- `int setLoopRecord(boolean isLoopOn)`  L454
- `Boolean getFlip()`  L458
- `int setFlip(boolean isUpsideDown)`  L462
- `int getBurstInfo(Map<String, Integer> map)`  L466
- `int setBurstInfo(int time, int count)`  L470
- `int getTimelapseInfo()`  L474
- `int setTimelapseInfo(int time)`  L478
- `int getTimerInfo()`  L482
- `int setTimerInfo(int time)`  L486
- `int getRecordTimelapseInfo()`  L490
- `int setRecordTimelapseInfo(int time)`  L494
- `String getBootAction()`  L498
- `int setBootAction(String action)`  L502
- `Boolean getAudioEncode()`  L506
- `int setAudioEncode(boolean isAudioOn)`  L510
- `String getVideoMode()`  L514
- `int setVideoMode(String videoMode)`  L518
- `int getDeviceAttr(Common.DeviceAttr attr)`  L522
    - 体内字面量："model" · "model" · "timeout" · "name" · "serialnum" · "softversion" · "hardversion" · "type"
- `int getNewDeviceAttr(Common.DeviceAttr deviceAttr)`  L555
    - 体内字面量："http://%s%s/" · "model" · "model" · "timeout" · "name" · "serialnum" · "softversion" · "hardversion" · "type"
- `int setPhoneTime2Camera()`  L587
- `Boolean getSpotMeter()`  L591
- `int setSpotMeter(boolean enabled)`  L595
- `Boolean getTimeOsd()`  L599
- `int setTimeOsd(boolean enabled)`  L603
- `Boolean getLedState()`  L607
- `int setLedState(boolean enabled)`  L614
- `Boolean getBuzzerState()`  L618
- `int setBuzzerState(boolean enabled)`  L622
- `int deleteAllFiles()`  L626
- `int upgrade()`  L630
- `int formatSdCard(Map<String, String> map)`  L634
    - 体内字面量："sdstatus"
- `void restoreFactorySettings()`  L643
- `void setWifiSsidPassword(String ssid, String pwd)`  L647
- `int setWifiToSta(String ssid, String password)`  L651
- `int setWifiToAp()`  L655
- `int getAutoShutdown()`  L659
- `int setAutoShutdown(int time)`  L663
- `int getScreenAutoSleep()`  L667
- `int setScreenAutoSleep(int time)`  L671
- `int getScreenBrightness()`  L675
- `int setScreenBrightness(int brightness)`  L679
- `int getPowerOnUiMode()`  L683
- `int setPowerOnUiMode(int uimode)`  L687
- `int sleep()`  L694
- `int wakeup()`  L698
- `int setBitRate(int bitrate)`  L714
- `int getBitRate()`  L718
- `int setWifiChannel(int channel)`  L722
- `int getWifiChannel()`  L726
- `String getDevCapabilities()`  L730
- `boolean supportWakeSleep()`  L736
- `boolean supportWorkMode()`  L745
- `int getWorkMode()`  L753
    - 体内字面量："workmode"
- `int setWorkMode(int workmode)`  L765
- `String getCapability(int workmode, int type)`  L769
- `String getNewAppCapability(String ItemName)`  L776
- `String getCurrentItemValue(Context mContext, String ItemName)`  L787
- `boolean curModeHasItem()`  L797
- `TreeMap<String, String> getItemListName()`  L803
    - 体内字面量："item" · "item" · "value"
- `void isNewAppDevice()`  L816
- `String getParameter(int workmode, int type)`  L822
- `int setParameter(int workmode, int type, String value)`  L829
- `String getTAG()`  L833
    - 体内字面量："DV"
- `String getIp()`  L837
- `void setIp(String ip)`  L841
    - 体内字面量："192"
- `String getMacAddress()`  L848
- `void setMacAddress(String macAddress)`  L852
- `void setWorkState(int workState)`  L856
- `int getWorkStateStr()`  L860
- `void setWorkStateStr(int workStateStr)`  L864
- `int getNomode()`  L868
- `void setNomode(int nomode)`  L872
- `String getStrmode()`  L876
- `void setStrmode(String strmode)`  L880
- `void setBatteryInfo(Common.BatteryInfo batteryInfo)`  L884
- `Common.DeviceAttr getDeviceAttr()`  L888
- `void setDeviceAttr(Common.DeviceAttr deviceAttr)`  L892
- `void setSdCardInfo(Common.SdCardInfo sdCardInfo)`  L896
- `WorkModeConfig getModeConfig()`  L900
- `void setModeConfig(WorkModeConfig modeConfig)`  L904
- `Prefer getPrefer()`  L908
- `void setPrefer(Prefer prefer)`  L912
- `boolean isSleeping()`  L916
- `void setSleeping(boolean sleeping)`  L920
- `String getCapability()`  L924
- `void setCapability(String capability)`  L928
- `boolean isConnectCamera()`  L932
- `void setConnectCamera(boolean connectCamera)`  L936
- `CameraInfors getCameraInfors()`  L940
- `void setCameraInfors(CameraInfors cameraInfors)`  L944
- `CameraStatus getCameraStatus()`  L948
- `void setCameraStatus(CameraStatus cameraStatus)`  L952
- `int getAMBA_SESSION_ID()`  L956
- `void setAMBA_SESSION_ID(int AMBA_SESSION_ID)`  L960
- `boolean isDrive()`  L964
- `void setDrive(boolean drive)`  L968
- `String getMode()`  L972
- `void setMode(String mode)`  L976
- `boolean isDriveSupportBatch()`  L980
- `void setDriveSupportBatch(boolean driveSupportBatch)`  L984
- `String getCurItemValue()`  L988
- `void setCurItemValue(String curItemValue)`  L992
- `boolean isSouport()`  L996
- `void setSouport(boolean souport)`  L1000
### `com.gku.actioncam.hisilicon.dv.biz.DV$DVHolder`
L89 · [class] private static DVHolder · `com/gku/actioncam/hisilicon/dv/biz/DV.java`

方法（1）：
- `private DVHolder()`  L92
### `com.gku.actioncam.hisilicon.dv.biz.FileListManager`
L20 · [class] public FileListManager · `com/gku/actioncam/hisilicon/dv/biz/FileListManager.java`

字段/常量（78）：
- `int FILE_ALL = 3`  L21
- `int FILE_IMAGE = 1`  L22
- `int FILE_VIDEO = 2`  L23
- `int LOAD_FILE_LIMIT = 49`  L24
- `int PAGE_FILE_COUNT = 200`  L25
- `String TAG = "FileListManager"`  L26
- `int mDVPathID`  L27
- `FileListManagerListener mFilelistManagerListen`  L28
- `Handler mHandler`  L29
- `ArrayList<String> strPathList`  L30
- `int mFileCount = -1`  L33
- `String strFilePath = null`  L35
- `Map<String, String> mapFileInfo = null`  L36
- `boolean bGetAllFileList = false`  L37
- `boolean bStopRunning = true`  L38
- `Thread mGetFilelist = null`  L39
- `int mFreshState = -1`  L40
- `boolean isLoadFileInfoDone = false`  L42
- `Thread thread = this.mGetFilelist`  L59
- `Thread thread = this.mGetFilelist`  L111
- `int i4 = this.mDVPathID`  L137
- `int i = 0`  L155
- `FileListManagerListener fileListManagerListener = this.mFilelistManagerListen`  L203
- `int i = 0`  L217
- `int i = 0`  L265
- `int i = -1`  L309
- `int i2 = 0`  L317
- `int i = 0`  L336
- `File file = G.localAppDataPath`  L372
- `String[] strArr = {"<binary/metadata>"}`  L377
- `int length = 0`  L382
- `int i = 2`  L424
- `FileListManager fileListManager = FileListManager.this`  L442
- `int i3 = fileListManager.mDVPathID`  L443
- `File file = G.localAppDataPath`  L503
- `File file = G.localAppDataPath`  L530
- `int size`  L578
- `String str`  L579
- `String str2`  L580
- `String str3`  L581
- `String str4`  L582
- `String str5`  L583
- `String str6 = "yunqi_debug"`  L584
- `int i = FileListManager.this.mFileCount - 199`  L601
- `String str7 = "run:  ----------------   "`  L611
- `String str8 = "12354652132"`  L612
- `String str9 = HiDefine.FILE_SUFIX_MP4`  L613
- `String str10 = "run: nFileCount:"`  L614
- `FileListManager fileListManager = FileListManager.this`  L629
- `int i3 = fileListManager.mDVPathID`  L630
- `String str11 = str8`  L631
- `FileListManager fileListManager2 = FileListManager.this`  L641
- `int i4 = fileListManager2.mDVPathID`  L642
- `FileListManager fileListManager3 = FileListManager.this`  L653
- `int i5 = fileListManager3.mDVPathID`  L654
- `String str12 = HiDefine.FILE_SUFIX_MP4`  L673
- `String str13 = "12354652132"`  L674
- `int i6 = iMin`  L675
- `String str14 = str6`  L685
- `String str15 = str12`  L686
- `String str16 = str13`  L690
- `FileListManager fileListManager4 = FileListManager.this`  L694
- `String str17 = str7`  L695
- `int i8 = fileListManager4.mDVPathID`  L696
- `FileListManager fileListManager5 = FileListManager.this`  L707
- `int i9 = fileListManager5.mDVPathID`  L708
- `FileListManager fileListManager6 = FileListManager.this`  L718
- `int i10 = fileListManager6.mDVPathID`  L719
- `int size`  L798
- `FileListManager fileListManager = FileListManager.this`  L830
- `int i2 = fileListManager.mDVPathID`  L831
- `Handler handler = this.mHandler`  L888
- `int i = FileListManager.this.mFileCount - 199`  L928
- `FileListManager fileListManager = FileListManager.this`  L945
- `int i3 = fileListManager.mDVPathID`  L946
- `File file = G.localAppDataPath`  L968
- `String str = this.strFilePath`  L1108
- `FileListManager fileListManager = FileListManager.this`  L1118

方法（43）：
- `void exit()`  L56
- `void setFileListManagerListen(FileListManagerListener fileListManagerlisten)`  L69
- `void onSaveInstanceState(Bundle savedInstanceState)`  L73
    - 体内字面量："fileCount" · "photo_size" · "DV_size" · "bGetAllFileList" · "photoListFile" · "photoSelect" · "DVListFile" · "DVSelect"
- `void getRemainderFileList()`  L89
- `void setHandler(Handler handler)`  L96
- `void refresh(int nRefreshState, int typetest)`  L100
    - 体内字面量："7894654222777" · "clearFileList:  ----------è¢«æ¸ç11111-------------    "
- `void clearFileList(int type)`  L107
    - 体内字面量："7894654222777" · "clearFileList:  ----------è¢«æ¸ç-------------    "
- `void onRestoreInstanceState(Bundle savedInstanceState)`  L128
    - 体内字面量："fileCount" · "DV_size" · "photo_size" · "bGetAllFileList" · "DVSelect" · "DVListFile"
- `int setSelectStatusAll(int bDVorPhoto, boolean bSelectStatus)`  L154 @Deprecated
- `int selectAllItem(ArrayList<HiDefine.PathConnection> arrayList, boolean bSelect)`  L172
- `void deleteSelectFile(int bDVorPhoto)`  L183
    - 体内字面量："mstrPhotoListFile.size() = " · " delete failed" · " delete failed"
- `ArrayList<String> getSelectPath(int bDVorPhoto, boolean bSelectStatus, ArrayList<Integer> listID)`  L212
- `ArrayList<String> getSelectPath(ArrayList<HiDefine.PathConnection> list, ArrayList<Integer> listID)`  L246
- `ArrayList<SelectModel> getSelectPathUpdate(int bDVorPhoto, boolean bSelectStatus, ArrayList<Integer> listID)`  L263
- `void setSelectStatus(int nID, boolean bDVorPhoto, boolean bSelectStatus)`  L292
- `int splitHalfSort(ArrayList<HiDefine.PathConnection> arrayPath, int nID)`  L307
- `void setSelectStatus(String strPath, boolean bDVorPhoto, boolean bSelectStatus)`  L332
- `ArrayList<HiDefine.PathConnection> getPathList(int bDVorPhoto)`  L356
- `int clearDownloadCache()`  L363
- `void clearDownloadCache(String StrSSID)`  L367
    - 体内字面量："cache/"
- `int clearCache(String strType)`  L371
- `void getAllFileList()`  L409
    - 体内字面量："55555555555555" · "getAllFileList:  -------------------------11111 " · "mstrDVListFile????????" · "getAllFileList:"
- `void run()`  L415 @Override
- `ArrayList<String> getImageUrl(int bDV, ArrayList<HiDefine.PathConnection> listImageUrl, int fileType)`  L465
    - 体内字面量："7894654222777" · "getImageUrl:  ---------------   FILE_VIDEO" · "dng" · "dng"
- `ArrayList<HiDefine.PathConnection> getCurrentIndexUrl(boolean isPhoto)`  L486 @Deprecated
    - 体内字面量："jpg" · "dng" · "png" · "lrv" · "mp4"
- `ArrayList<HiDefine.PathConnection> getPhoneVideoUrl()`  L501
- `ArrayList<HiDefine.PathConnection> getPhoneImageUrl()`  L528
- `ArrayList<HiDefine.PathConnection> getDVImageUrl(final boolean isPhoto, final LoadFileCallback loadFileCallback)`  L557
    - 体内字面量："mFileCount="
- `void run()`  L577 @Override
- `ArrayList<HiDefine.PathConnection> getDVImageUrl_justFileName(final boolean isPhoto, final LoadFileCallback loadFileCallback)`  L778
- `void run()`  L797 @Override
- `ArrayList<HiDefine.PathConnection> itemSelector(boolean isPhoto)`  L872
    - 体内字面量："jpg" · "dng" · "png" · "lrv" · "mp4"
- `ArrayList<HiDefine.PathConnection> getImageUrl(int bDV)`  L899
    - 体内字面量："mstrDVListFile.size = "
- `void run()`  L913 @Override
- `void deletePhotoFileList(String strPath)`  L990
- `void deletePhotoFileList(int nID)`  L999
- `void deleteDVFileList(String strPath)`  L1006
- `void deleteDVFileList(int nID)`  L1017
    - 体内字面量："453412311111" · "deleteDVFileList:  ---------è¢«æ¥æ¾æºçID--------   " · "        è¦æ¥æ¾çIDæ¯  ----------   " · "453412311111" · "deleteDVFileList:  ------------  remove bitmap" · "453412311111" · "å é¤æå:" · ".." · "deleteDVFileList: ---------------------   " · "453412311111" · "453412311111" · "deleteDVFileList:  ----------------------    è¦æ¥æ¾çIDæ¥å°äº å é¤äºIDä¸º" · "çæä»¶" · "453412311111" · "deleteDVFileList:  --------------------   " · "453412311111" · "deleteDVFileList:  ----------------------    æ²¡æ¥å°è¦æ¥æ¾çIDä¸º" · "çæä»¶"
- `void getLastFile()`  L1048
- `void run()`  L1051 @Override
- `void getFileInfo(String strPath, Map<String, String> mapInf)`  L1097
- `void run()`  L1117 @Override
- `void getFileInfoThread(Map<String, String> mapInfo)`  L1156
### `com.gku.actioncam.hisilicon.dv.biz.FileListManager$fileFilter`
L1130 · [class] public static fileFilter · implements `FilenameFilter` · `com/gku/actioncam/hisilicon/dv/biz/FileListManager.java`

字段/常量（2）：
- `boolean bGetDir = true`  L1131
- `String[] mtype`  L1132

方法（3）：
- `public fileFilter()`  L1134
- `public fileFilter(String[] type)`  L1137
- `boolean accept(File dir, String name)`  L1142 @Override
### `com.gku.actioncam.hisilicon.dv.biz.FileListManager$FileListManagerListener`
L44 · [interface] public FileListManagerListener · `com/gku/actioncam/hisilicon/dv/biz/FileListManager.java`

方法（2）：
- `void onRemoveAllBitmap()`  L45
- `void onRemoveBitmap(int position)`  L47
### `com.gku.actioncam.hisilicon.dv.biz.FileListManager$LoadFileCallback`
L50 · [interface] public LoadFileCallback · `com/gku/actioncam/hisilicon/dv/biz/FileListManager.java`

方法（2）：
- `void loadDone()`  L51
- `void startLoad()`  L53
### `com.gku.actioncam.hisilicon.dv.biz.GetLocalPath`
L12 · [class] public GetLocalPath · `com/gku/actioncam/hisilicon/dv/biz/GetLocalPath.java`

字段/常量（9）：
- `String TAG = "GetLocalPath"`  L13
- `Context mContext`  L14
- `String mStrSSID = "<binary/metadata>"`  L15
- `String str2 = str + this.mStrSSID + "/" + strArrSplit[strArrSplit.length - 2] + "/"`  L37
- `int i = 0`  L54
- `int i = 0`  L81
- `String str = this.mStrSSID`  L99
- `String str2 = this.mStrSSID`  L103
- `String str3 = this.mStrSSID`  L109

方法（7）：
- `public GetLocalPath(Context context)`  L17
- `String getImagePath(String imageUrl)`  L21
    - 体内字面量："/" · "G.localDCIMDataPath is null" · "/cache/" · " mkdirs() failed" · "/"
- `String getStrSSID()`  L45
- `void setClearSSID()`  L49
- `int getFileAttr(String strUrlImage)`  L53
- `int getDVFileAttr(String strUrlImage)`  L80
- `String getWifiName()`  L98
### `com.gku.actioncam.hisilicon.dv.biz.HiDefine`
L8 · [class] public HiDefine · `com/gku/actioncam/hisilicon/dv/biz/HiDefine.java`

字段/常量（68）：
- `int BACK_PAGE = 1`  L9
- `int BROWSER_MENU = 0`  L10
- `String CHACH_PATH = "cache"`  L11
- `int DLG_FOR_DELETE_CONFIRM = 3`  L12
- `int DLG_FOR_DOWNLOAD_EXCEPTION = 5`  L13
- `int DLG_FOR_PROGRESS_PATH_LIST = 4`  L14
- `int DLG_POPUP_FOR_WINDOW = 1`  L15
- `int DLG_SWITCH_IMAGE = 2`  L16
- `int DOUBLE_CLICK_TIME = 350`  L17
- `int DOWNLOAD = 3`  L18
- `String DOWNLOAD_APK_PATH = "apk"`  L19
- `int DOWNLOAD_CONNECT_TIMEOUT = 5000`  L20
- `String DOWNLOAD_PATH = "download"`  L21
- `int DOWNLOAD_READ_TIMEOUT = 6000`  L22
- `int DV_DEVICE_LINK = 2`  L23
- `String DV_NETWORK_PREFIX = "3516A"`  L24
- `String DV_NETWORK_PREFIX2 = "himc"`  L25
- `String DV_NETWORK_PREFIX3 = "YUTU"`  L26
- `int ERROR_TOUCH_MOVE = 10`  L27
- `int FILEBROESER_TYPE_DV = 2`  L28
- `int FILEBROESER_TYPE_PHONE = 1`  L29
- `String FILE_SUFFIX_THM = ".THM"`  L30
- `String FILE_SUFIX_JPG = ".JPG"`  L31
- `String FILE_SUFIX_LRV = ".LRV"`  L32
- `String FILE_SUFIX_MP4 = ".MP4"`  L33
- `int HIDE_TOOLBAR = 3`  L34
- `int INTERNET_LINK = 1`  L35
- `int LONG_CLICK = 2`  L36
- `int MENU_SHOW_TIME = 10`  L37
- `int NEXT_PAGE = 2`  L38
- `int NOT_CONNECT = 2`  L39
- `int NOT_DV = 1`  L40
- `int OPERATE_WIFI_CONNECT = 2`  L41
- `int OPERATE_WIFI_DISCONNECT = 1`  L42
- `int PLAY_ICON_ID = 5`  L43
- `int PLAY_STATUS_DOWNLOAD = 6`  L44
- `int POPUP_MENU = 1`  L45
- `int PREVIEW_GET_FILE_LIST = 7`  L46
- `int PREVIEW_GET_REMAINDER_FILE = 5`  L47
- `int PREVIEW_GET_SD_STATE = 8`  L48
- `int PREVIEW_PULL_TO_REFRESH = 6`  L49
- `int PREVIEW_SWITCH_TO_WIFI = 10`  L50
- `int PROGRESS_DELETE = 1`  L51
- `int PROGRESS_DOWNLOAD = 2`  L52
- `int REFRESH_HEAD = 2`  L53
- `int RELOAD_OP = 1`  L54
- `int RENAME_OP = 2`  L55
- `int SELECT_MASK_LAYER_ID = 4`  L56
- `int SELECT_STATUS_IMG_ID = 2`  L57
- `int SHORT_CLICK = 1`  L58
- `int SHOW_PICTURE_IMG_ID = 3`  L59
- `int SKIP_OP = 3`  L60
- `int TYPE_DELETE = 1`  L61
- `int TYPE_DLNA_PUSH = 5`  L62
- `int TYPE_DOWNLOAD = 3`  L63
- `int TYPE_EDIT = 6`  L64
- `int TYPE_FILEINFO = 4`  L65
- `int TYPE_NO_NULL = 0`  L66
- `int TYPE_SHARE = 2`  L67
- `int VIDEO_TIME_TEXT_ID = 1`  L68
- `int WIFI_CONNECT = 2`  L69
- `int WIFI_FORGET = 3`  L70
- `int WIFI_NO_CONFIG = -1`  L71
- `int WIFI_NO_ERROR = 0`  L72
- `int WIFI_NO_SCAN = -2`  L73
- `int WIFI_NO_SSID = -3`  L74
- `int WIFI_REVERIFY = 4`  L75
- `int WIFI_UNDO = 1`  L76
### `com.gku.actioncam.hisilicon.dv.biz.HiDefine$PathConnection`
L80 · [class] public static PathConnection · implements `Parcelable` · `com/gku/actioncam/hisilicon/dv/biz/HiDefine.java`

字段/常量（5）：
- `boolean bSelect`  L94
- `long length`  L95
- `MediaModel mediaModel`  L96
- `int nPathID`  L97
- `String strPath`  L98

方法（6）：
- `PathConnection createFromParcel(Parcel source)`  L84 @Override
- `PathConnection[] newArray(int size)`  L90 @Override
- `int describeContents()`  L101 @Override
- `void writeToParcel(Parcel parcel, int i)`  L106 @Override
- `public PathConnection()`  L114
- `protected PathConnection(Parcel in)`  L118
### `com.gku.actioncam.hisilicon.dv.biz.HiDeleteFile`
L12 · [class] public HiDeleteFile · `com/gku/actioncam/hisilicon/dv/biz/HiDeleteFile.java`

方法（2）：
- `void confirmDeletefile(Activity context)`  L13
- `void startDeleteDlg(ArrayList<String> listPath, ArrayList<Integer> listID, Activity context)`  L17
    - 体内字面量："progressType" · "453412311111" · "startDeleteDlg:  ----------éä¸­è¦å é¤æä»¶çID---------   " · "nTaskIDArray"
### `com.gku.actioncam.hisilicon.dv.biz.HiDownloadFile`
L23 · [class] public HiDownloadFile · `com/gku/actioncam/hisilicon/dv/biz/HiDownloadFile.java`

字段/常量（4）：
- `ArrayList<String> mListPath`  L24
- `String TAG = "HiDownloadFile"`  L25
- `int i4 = 0`  L194
- `int i4 = 0`  L260

方法（14）：
- `void onSaveInstanceState(Bundle savedInstanceState)`  L30
    - 体内字面量："mListPath" · "mNoExistList"
- `void onRestoreInstanceState(Bundle savedInstanceState)`  L35
    - 体内字面量："mListPath" · "mNoExistList"
- `void showSizeDialog(final ArrayList<String> listPath, final String strSSID, final Activity context, int type)`  L40
    - 体内字面量："Big"
- `void onClick(View view)`  L62 @Override
- `void onClick(View view)`  L69 @Override
- `void onClick(View view)`  L76 @Override
    - 体内字面量："Big" · "Small"
- `void showSizeDialogUpdate(final ArrayList<String> listPath, final String strSSID, final Activity context, int type, final ArrayList<Long> lengths)`  L94
    - 体内字面量："Big"
- `void onClick(View view)`  L116 @Override
- `void onClick(View view)`  L132 @Override
- `void onClick(View view)`  L139 @Override
    - 体内字面量："Big" · "Small"
- `void downloadExceptionDlg(ArrayList<String> listPath, String strSSID, Activity context, boolean IsHeigh)`  L158
    - 体内字面量："/" · "5213213" · " æä»¶å¤¹å·²å­å¨" · "5213213" · " mkdirs() sucessful" · "5213213" · " mkdirs() failed" · "5213213" · "listPath:  -----------åæ¬å°åä¸º   " · "\n" · "5213213" · "replace:  -----------æ æ¸----------   æ¿æ¢å°åä¸º   " · "5213213" · "replace: --------æ æ¸-------   æ²¡æ æ¿æ¢å°å   " · "5213213" · "replace:  ---------é«æ¸------------   æ¿æ¢å°åä¸º   " · "5213213" · "replace: ---------é«æ¸------   æ²¡æ æ¿æ¢å°å   "
- `void downloadExceptionDlgUpdate(ArrayList<String> listPath, String strSSID, Activity context, boolean IsHeigh, ArrayList<Long> lengths)`  L223
    - 体内字面量："/" · "5213213" · " æä»¶å¤¹å·²å­å¨" · "5213213" · " mkdirs() sucessful" · "5213213" · " mkdirs() failed" · "5213213" · "listPath:  -----------åæ¬å°åä¸º   " · "\n" · "5213213" · "replace:  -----------æ æ¸----------   æ¿æ¢å°åä¸º   " · "5213213" · "replace: --------æ æ¸-------   æ²¡æ æ¿æ¢å°å   " · "5213213" · "replace:  ---------é«æ¸------------   æ¿æ¢å°åä¸º   " · "5213213" · "replace: ---------é«æ¸------   æ²¡æ æ¿æ¢å°å   "
- `void downloadFileDialg(Activity context, String strSSID, int nOption)`  L288
    - 体内字面量："453412311" · "downloadFileDialg:  -----------------  hahahahha" · "downloadFileDialg:  ----------------   " · "453412311" · "453412311" · "downloadFileDialg:  ---------1-----------   " · "453412311" · "downloadFileDialg:  ----------2----------   " · "progressType" · "option" · "SSID"
- `void downloadFileDialgUpdate(Activity context, String strSSID, int nOption, ArrayList<Long> lengths, boolean IsHeigh)`  L311
    - 体内字面量："453412311" · "downloadFileDialg:  -----------------  hahahahha: " · "downloadFileDialg:  ----------------   " · "453412311" · "453412311" · "downloadFileDialg:  ---------1-----------   " · "453412311" · "downloadFileDialg:  ----------2----------   " · "progressType" · "option" · "SSID" · "IsHeigh"
### `com.gku.actioncam.hisilicon.dv.biz.HiFileInfo`
L16 · [class] public HiFileInfo · `com/gku/actioncam/hisilicon/dv/biz/HiFileInfo.java`

字段/常量（4）：
- `String TAG = "HiFileInfo"`  L17
- `long length`  L20
- `String dateTime = "<binary/metadata>"`  L30
- `long jCharAt = 0`  L96

方法（3）：
- `void fileInfoDialog(Context context, String strPath)`  L19
- `String formatDateTime(String strDatetime)`  L76
    - 体内字面量："/" · ":" · "yyyyMMddHHmmss" · "yyyy/MM/dd HH:mm:ss"
- `long stringToLong(String strData)`  L95
### `com.gku.actioncam.hisilicon.dv.biz.HiShareFile`
L13 · [class] public HiShareFile · `com/gku/actioncam/hisilicon/dv/biz/HiShareFile.java`

方法（3）：
- `void shareImage(Context context, String strPath)`  L14
    - 体内字面量："android.intent.action.SEND" · "dng" · "image/jpg" · "android.intent.extra.SUBJECT" · "video/mp4" · "android.intent.extra.SUBJECT" · "android.intent.extra.STREAM"
- `void shareImage(Context context, ArrayList<String> strPath, int shareType)`  L27
    - 体内字面量："android.intent.action.SEND_MULTIPLE" · "android.intent.extra.STREAM" · "*/*" · "image/jpg"
- `void shareImg(Context context, ArrayList<String> strListImgUrl, int shareType)`  L46
### `com.gku.actioncam.hisilicon.dv.biz.HiWifiManager`
L18 · [class] public HiWifiManager · `com/gku/actioncam/hisilicon/dv/biz/HiWifiManager.java`

字段/常量（13）：
- `String ALL_SSID = "all_dv_device_ssid_list"`  L19
- `String TAG = "HiWifiManager"`  L20
- `String WIFI_CONNECT_SSID = "start_wifi_ssid"`  L21
- `String WIFI_ENABLE = "dv_device_wifi_enable"`  L22
- `String WIFI_LAST_CONNECT_SSID = "wifi_last_Connected_SSID"`  L23
- `boolean mBEnable`  L24
- `Context mConext`  L25
- `Handler mHandler`  L26
- `List<ScanResult> mListScanResult`  L27
- `WifiManager mWifiManager`  L28
- `int iAddNetwork`  L285
- `WifiConfiguration wifiConfigurationFindConfigration`  L378
- `WifiManager wifiManager = this.mWifiManager`  L401

方法（29）：
- `public HiWifiManager(Context context, boolean bOpenWifi)`  L30
    - 体内字面量："wifi" · "bOpenWifi mBEnable = "
- `public HiWifiManager(Context context)`  L40
    - 体内字面量："wifi"
- `void setEnableState(boolean bEnable)`  L46
    - 体内字面量："strSSID:"
- `void removeEnableState()`  L62
    - 体内字面量："openWifi strSSID:"
- `String getLastConnectDeviceInfo()`  L84
    - 体内字面量："getLastConnectDeviceInfo ssid:"
- `void removeDeviceInfo(String SSID)`  L90
    - 体内字面量：";"
- `void updateDeviceInfo(String oldSSID, String newSSID, String newPasswd)`  L107
- `void saveDeviceInfo(String SSID, String password)`  L123
    - 体内字面量："saveDeviceInfo:" · ":password" · "allSSID:" · ";"
- `String[] getAllSSID()`  L140
    - 体内字面量：";"
- `String getDevicePassword(String SSID)`  L148
    - 体内字面量："getDevicePassword SSID:" · "getDevicePassword strPassWord:"
- `WifiInfo getConnectWifiInfo()`  L158
- `boolean openWifi()`  L162
- `boolean isWifiEnabled()`  L171
    - 体内字面量："mBEnable = "
- `void closeWifi()`  L176
- `boolean isWifiConnectState()`  L182
- `boolean isWifiConnected(Context context)`  L187
    - 体内字面量："connectivity"
- `boolean isDVDevice()`  L195
    - 体内字面量："\"" · "\""
- `String getConnectWifiName()`  L206
    - 体内字面量："tagyxq" · "getConnectWifiName:" · "\"" · "\""
- `void startScan()`  L219
- `List<ScanResult> getWifiScanResult()`  L224
- `int findScanResult(String SSID)`  L228
    - 体内字面量："\"" · "\""
- `WifiConfiguration findConfigration(String SSID)`  L252
    - 体内字面量："findConfigration:null" · "wifiConfig.size = " · "find device configuration failed! "
- `void enableNetwork(String SSID)`  L268
    - 体内字面量："\"" · "\"" · "wifiConfig.SSID:"
- `void connectStartInternet()`  L276
    - 体内字面量："strSSID = "
- `int connectNetwork(String SSID, String password)`  L284
- `void setConfigInfo(WifiConfiguration wifiConfig)`  L338
- `boolean disconnectWifi()`  L354
    - 体内字面量："disconnectWifi" · "disconnectWifi failed!" · "\"" · "\"" · "disconnect failed! "
- `void clearConfigure(String SSID)`  L377
- `void disconnectCurWifi(int nID)`  L400
### `com.gku.actioncam.hisilicon.dv.biz.NewDV`
L4 · [class] public NewDV · `com/gku/actioncam/hisilicon/dv/biz/NewDV.java`

字段/常量（2）：
- `NewDV instance`  L5
- `boolean mIsConnectCamera = false`  L6

方法（4）：
- `private NewDV()`  L8
- `NewDV getInstance()`  L11
- `void setConnectStatus(boolean connectStatus)`  L22
- `boolean getConnectStatus()`  L26
### `com.gku.actioncam.hisilicon.dv.biz.Prefer`
L6 · [class] public Prefer · `com/gku/actioncam/hisilicon/dv/biz/Prefer.java`

字段/常量（28）：
- `String generalCurrentValue`  L7
- `String videoResolution = "1080P"`  L8
- `String frameRate = "30"`  L9
- `String fieldOfView = "150"`  L10
- `String videoMode = Common.VIDEO_MODE_NTSC`  L11
- `int burstTime = 1`  L12
- `int burstCount = 5`  L13
- `int timelapseInterval = 10`  L14
- `int timerCountDown = 10`  L15
- `int recordTimelapse = 10`  L16
- `int screenAutoSleep = 0`  L17
- `int screenBrightness = 100`  L18
- `int powerOnUiMode = 0`  L19
- `String wifiSSID = "<binary/metadata>"`  L20
- `String wifiPassword = "<binary/metadata>"`  L21
- `String autoShutdown = SessionDescription.SUPPORTED_SDP_VERSION`  L22
- `String bootAction = Common.BOOT_ACTION_IDLE`  L23
- `boolean audioCodec = false`  L24
- `boolean imageUpsidedown = false`  L25
- `boolean spotMetering = false`  L26
- `boolean timeTag = false`  L27
- `boolean ledFlicker = true`  L28
- `boolean buzzerPrompt = true`  L29
- `String photoResolution = "1080P"`  L30
- `String downloadVideo = "Small"`  L31
- `String previewVideo = "Small"`  L32
- `boolean soundPrompt = true`  L33
- `String dvName = "<binary/metadata>"`  L34
### `com.gku.actioncam.hisilicon.dv.biz.RemoteFileManager`
L12 · [class] public RemoteFileManager · `com/gku/actioncam/hisilicon/dv/biz/RemoteFileManager.java`

方法（8）：
- `int getFileCount(String ip)`  L13
    - 体内字面量："http://%s%s%s" · "/getfilecount.cgi?" · "mstrDVListFile?????????" · "getFileCount:  ------------------  ????" · "count"
- `int getFileList(String ip, int start, int end, ArrayList<MediaModel> list1)`  L19
    - 体内字面量："http://%s%s/getfilelistinfoios.cgi?&-start=%d&-end=%d" · "852652111" · "getFileList:  -----666666----------   " · "852652111" · "852652111" · "getFileList:  -----666666----------   "
- `int getFileNameList(String ip, int start, int end, ArrayList<String> list)`  L32
    - 体内字面量："http://%s%s/getfilelist.cgi?&-start=%d&-end=%d" · ";" · "mp4" · "lrv" · "dng" · "png" · "jpg"
- `int getFileInfo(String ip, String file, Map<String, String> map)`  L45
    - 体内字面量："http://%s%s/getfileinfo.cgi?&-name=%s"
- `int deleteFile(String ip, String file)`  L49
    - 体内字面量："http://%s%s/deletefile.cgi?&-name=%s"
- `int deleteAllFiles(String ip)`  L53
    - 体内字面量："http://%s%s/deleteallfiles.cgi?"
- `int formatSdCard(String ip, Map<String, String> map)`  L57
    - 体内字面量："http://%s%s/sdcommand.cgi?-format&-partition=1"
- `int upgrade(String ip)`  L61
    - 体内字面量："http://%s%s/upgrade.cgi"
### `com.gku.actioncam.hisilicon.dv.biz.Setting`
L26 · [class] public Setting · `com/gku/actioncam/hisilicon/dv/biz/Setting.java`

字段/常量（6）：
- `String TAG = "Setting"`  L27
- `boolean z = CameraParameters.IsNewDevice`  L275
- `Socket socket = null`  L377
- `OutputStream outputStream = null`  L380
- `byte[] bArr = new byte[6]`  L468
- `byte[] bArr = new byte[102]`  L488

方法（61）：
- `int getWorkState(String ip)`  L29
    - 体内字面量："http://%s%s/getallinfo.cgi??"
- `int getVideoInfo(String ip, Map<String, String> map)`  L33
    - 体内字面量："http://%s%s/getvideoinfo.cgi?"
- `int setVideoInfo(String ip, String resolution, int frameRate)`  L37
    - 体内字面量："http://%s%s/setvideoinfo.cgi?&-resolution=%s&-fps=%d"
- `Common.BatteryInfo getBatteryInfo(String ip)`  L43
    - 体内字面量："http://%s%s/getbatterycapacity.cgi?" · "è·åçµé" · "è·åçµé" · "getBatteryInfo:  -------------------  " · "capacity" · "charge" · "ac" · "è·åå°çµé" · "capacity = " · ",charge = " · ",ac = "
- `Common.SdCardInfo getSdState(String ip)`  L87
    - 体内字面量："http://%s%s/getsdstate.cgi?" · "sdstate" · "sdstate" · "total" · "used" · "SDOK" · "SDFULL" · "SDNONE" · "SDERROR" · " MB" · " MB"
- `int getViewField(String ip)`  L121
    - 体内字面量："http://%s%s/getviewfield.cgi?" · "fov"
- `int setViewField(String ip, int viewField)`  L129
    - 体内字面量："http://%s%s/setviewfield.cgi?&-fov=%d"
- `Boolean getLoopRecord(String ip)`  L136
    - 体内字面量："http://%s%s/getlooprecord.cgi?"
- `int setLoopRecord(String str, boolean z)`  L140
    - 体内字面量："http://%s%s/setlooprecord.cgi?&-enable=%d"
- `Boolean getFlip(String ip)`  L144
    - 体内字面量："http://%s%s/getflip.cgi?"
- `int setFlip(String str, boolean z)`  L148
    - 体内字面量："http://%s%s/setflip.cgi?&-enable=%d"
- `int getBurstInfo(String ip, Map<String, Integer> map)`  L152
    - 体内字面量："http://%s%s/getburstinfo.cgi?" · "getBurstInfo" · "count" · "getBurstInfo" · "count"
- `int setBurstInfo(String ip, int time, int count)`  L178
    - 体内字面量："setBurstInfo" · "Invalid args" · "http://%s%s/setburstinfo.cgi?&-time=%d&-count=%d"
- `int getTimelapseInfo(String ip)`  L186
    - 体内字面量："http://%s%s/gettimelapseinfo.cgi?"
- `int setTimelapseInfo(String ip, int time)`  L190
    - 体内字面量："http://%s%s/settimelapseinfo.cgi?&-time=%d"
- `int getTimerInfo(String ip)`  L194
    - 体内字面量："http://%s%s/gettimerinfo.cgi?"
- `int setTimerInfo(String ip, int time)`  L198
    - 体内字面量："http://%s%s/settimerinfo.cgi?&-time=%d"
- `int getRecordTimelapseInfo(String ip)`  L202
    - 体内字面量："http://%s%s/getrecordtimelapse.cgi?"
- `int setRecordTimelapseInfo(String ip, int time)`  L206
    - 体内字面量："http://%s%s/setrecordtimelapse.cgi?&-time=%d"
- `String getBootAction(String ip)`  L210
    - 体内字面量："http://%s%s/getbootaction.cgi?" · "action"
- `int setBootAction(String ip, String action)`  L214
    - 体内字面量："http://%s%s/setbootaction.cgi?&-action=%s"
- `Boolean getAudioEncode(String ip)`  L218
    - 体内字面量："http://%s%s/getaudioencode.cgi?"
- `int setAudioEncode(String str, boolean z)`  L222
    - 体内字面量："http://%s%s/setaudioencode.cgi?&-enable=%d"
- `String getVideoMode(String ip)`  L226
    - 体内字面量："http://%s%s/getvideonorm.cgi?" · "videonorm"
- `int setVideoMode(String ip, String videoMode)`  L237
    - 体内字面量："http://%s%s/setvideonorm.cgi?&-videonorm=%s"
- `int getDeviceAttr(String ip, Map<String, String> map)`  L241
    - 体内字面量："http://%s%s/getdeviceattr.cgi"
- `int setSystemTime(String ip, GregorianCalendar calendar)`  L248
    - 体内字面量："http://%s%s/setsystime.cgi?&-time=%04d%02d%02d%02d%02d%02d"
- `Boolean getSpotMeter(String ip)`  L255
    - 体内字面量："http://%s%s/getspotmeter.cgi?"
- `int setSpotMeter(String str, boolean z)`  L259
    - 体内字面量："http://%s%s/setspotmeter.cgi?&-enable=%d"
- `Boolean getTimeOsd(String ip)`  L263
    - 体内字面量："http://%s%s/gettimeosd.cgi?"
- `int setTimeOsd(String str, boolean z)`  L267
    - 体内字面量："http://%s%s/settimeosd.cgi?&-enable=%d"
- `Boolean getLedState(String ip)`  L271
- `int setLedState(String str, boolean z)`  L279
    - 体内字面量："http://%s%s/setledstate.cgi?&-enable=%d"
- `Boolean getBuzzerState(String ip)`  L283
    - 体内字面量："http://%s%s/getbuzzer.cgi?"
- `int setBuzzerState(String str, boolean z)`  L287
    - 体内字面量："http://%s%s/setbuzzer.cgi?&-enable=%d"
- `void restoreFactorySettings(String ip)`  L291
    - 体内字面量："/reset.cgi?"
- `void setWifi(String ip, String ssid, String password)`  L295
    - 体内字面量："/setwifi.cgi?" · "&-wifissid=" · "setWifi:ssid = " · "&-wifikey=" · "setWifi:passwd = "
- `int setWifiToSta(String ip, String ssid, String password)`  L310
    - 体内字面量："/cgi-bin/setwifista.cgi?" · "&-ssid=" · "&-key="
- `int setWifiToAp(String ip)`  L325
    - 体内字面量："http://%s%s/setwifista.cgi?"
- `int getAutoShutdown(String ip)`  L329
    - 体内字面量："http://%s%s/getautoshutdown.cgi?"
- `int setAutoShutdown(String ip, int time)`  L333
    - 体内字面量："http://%s%s/setautoshutdown.cgi?&-time=%d"
- `int getScreenAutoSleep(String ip)`  L337
    - 体内字面量："http://%s%s/getscreenautosleep.cgi?"
- `int setScreenAutoSleep(String ip, int time)`  L341
    - 体内字面量："http://%s%s/setscreenautosleep.cgi?&-time=%d"
- `int getScreenBrightness(String ip)`  L345
    - 体内字面量："http://%s%s/getscreenbrightness.cgi?" · "brightness"
- `int setScreenBrightness(String ip, int brightness)`  L349
    - 体内字面量："http://%s%s/setscreenbrightness.cgi?&-brightness=%d"
- `int getPowerOnUiMode(String ip)`  L353
    - 体内字面量："http://%s%s/getpoweronuimode.cgi?" · "uimode"
- `int setPowerOnUiMode(String ip, int uimode)`  L357
    - 体内字面量："http://%s%s/setpoweronuimode.cgi?&-uimode=%d"
- `void setSocketNoReply(String str, String str2)`  L375
    - 体内字面量："strUrl:"
- `int sleep(String ip)`  L463
    - 体内字面量："http://%s%s/wifisleep.cgi?"
- `byte[] macAddres2ByteArray(String macAddress)`  L467
- `void wakeupDevice(String ip, byte[] mac)`  L483
    - 体内字面量："mac address byte[] is null"
- `int getBitRate(String ip)`  L513
    - 体内字面量："http://%s%s/getbitrate.cgi?"
- `int setBitRate(String ip, int bitrate)`  L517
    - 体内字面量："http://%s%s/setbitrate.cgi?&-bitrate=%d"
- `int getWifiChannel(String ip)`  L521
    - 体内字面量："http://%s%s/getwifichannel.cgi?" · "wifichannel"
- `int setWifiChannel(String ip, int channel)`  L525
    - 体内字面量："http://%s%s/setwifichannel.cgi?&-wifichannel=%d"
- `String getDevCapabilities(String ip)`  L529
    - 体内字面量："http://%s%s/getdevcapabilities.cgi?" · "devcapabilities"
- `int getWorkMode(String ip, Map<String, String> map)`  L533
    - 体内字面量："http://%s%s/getworkmode.cgi?"
- `int setWorkMode(String ip, int workmode)`  L537
    - 体内字面量："http://%s%s/setworkmode.cgi?&-workmode=%d?"
- `String getCapability(String ip, int workmode, int type)`  L541
    - 体内字面量："http://%s%s/getcapability.cgi?&-workmode=%d&-type=%d" · "capability"
- `String getParameter(String ip, int workmode, int type)`  L545
    - 体内字面量："http://%s%s/getparameter.cgi?&-workmode=%d&-type=%d" · "value"
- `int setParameter(String ip, int workmode, int type, String value)`  L549
    - 体内字面量："http://%s%s/setparameter.cgi?&-workmode=%d&-type=%d&-value=%s"
### `com.gku.actioncam.hisilicon.dv.biz.ToastManager`
L7 · [class] public ToastManager · `com/gku/actioncam/hisilicon/dv/biz/ToastManager.java`

字段/常量（2）：
- `Toast mToast`  L8
- `Toast toast = mToast`  L11

方法（2）：
- `void displayToast(Context context, String msg)`  L10
- `void displayToast(Context context, int resID)`  L21
### `com.gku.actioncam.hisilicon.dv.biz.Utility`
L14 · [class] public Utility · `com/gku/actioncam/hisilicon/dv/biz/Utility.java`

字段/常量（7）：
- `int SOUND_CAMERA_CLICK = R.raw.sound_camera_click`  L15
- `int SOUND_VIDEO_RECORD = R.raw.sound_video_record`  L16
- `String TAG = "Utility"`  L17
- `int i = time / 3600`  L29
- `int i2 = time % 3600`  L30
- `File filesDir`  L87
- `File filesDir`  L101

方法（8）：
- `boolean isDeviceAvailable(Context context)`  L19
    - 体内字面量："wifi" · "tagying" · "isDeviceAvailable:  -------------------------   isDeviceAvailable() WIFI Disabled" · "isDeviceAvailable() WIFI Disabled"
- `String time2String(int time)`  L28
- `void playSound(final Context context, final int sound)`  L68
- `String removeDoubleQuote(String value)`  L72
    - 体内字面量："\"" · "\""
- `String doubleQuote(String value)`  L79
    - 体内字面量："\"" · "\"" · "\"%s\""
- `File getLocalDCIMDataPath(Context context, String incomingPath)`  L86
- `File getLocalAppDataPath(Context context)`  L100
- `boolean isCameraWifi(String ssid)`  L114
### `com.gku.actioncam.hisilicon.dv.biz.Utility$AnonymousClass1`
L35 · [class] AnonymousClass1 · extends `Thread` · `com/gku/actioncam/hisilicon/dv/biz/Utility.java`

字段/常量（2）：
- `Context val$context`  L36
- `int val$sound`  L37

方法（2）：
- `void run()`  L45 @Override
- `void onCompletion(MediaPlayer mediaPlayer2)`  L52 @Override
    - 体内字面量："run:  --------------------   Sound url :  " · "file:///system/media/audio/ui/camera_click.ogg" · "file:///system/media/audio/ui/camera_click.ogg"
### `com.gku.actioncam.hisilicon.dv.biz.WorkModeConfig`
L4 · [class] public WorkModeConfig · `com/gku/actioncam/hisilicon/dv/biz/WorkModeConfig.java`

字段/常量（52）：
- `String GeneralPurposeCurrentValue`  L5
- `String GeneralPurposeValuesList`  L6
- `String multiBurstRate`  L7
- `String multiBurstRateValues`  L8
- `String multiBurstResolution`  L9
- `String multiBurstResolutionValues`  L10
- `String multiContinuousRate`  L11
- `String multiContinuousRateValues`  L12
- `String multiContinuousResolution`  L13
- `String multiContinuousResolutionValues`  L14
- `String multiTimelapseInterval`  L15
- `String multiTimelapseIntervalValues`  L16
- `String multiTimelapseResolution`  L17
- `String multiTimelapseResolutionValues`  L18
- `String photoRawResolution`  L19
- `String photoRawResolutionValues`  L20
- `String photoSingleResolution`  L21
- `String photoSingleResolutionValues`  L22
- `String photoSingleScene`  L23
- `String photoSingleSceneValues`  L24
- `String photoTimerResolution`  L25
- `String photoTimerResolutionValues`  L26
- `String photoTimerScene`  L27
- `String photoTimerSceneValues`  L28
- `String photoTimerTime`  L29
- `String photoTimerTimeValues`  L30
- `String videoLoopResolution`  L31
- `String videoLoopResolutionValues`  L32
- `String videoNormalResolution`  L33
- `String videoNormalResolutionValues`  L34
- `String videoPhotoLapseInteral`  L35
- `String videoPhotoLapseInteralValues`  L36
- `String videoPhotoMode`  L37
- `String videoPhotoModeValues`  L38
- `String videoPhotoPhotoResolution`  L39
- `String videoPhotoPhotoResolutionValues`  L40
- `String videoPhotoSnapInterval`  L41
- `String videoPhotoSnapIntervalValues`  L42
- `String videoPhotoSnapMode`  L43
- `String videoPhotoSnapModeValues`  L44
- `String videoPhotoVideoResolution`  L45
- `String videoPhotoVideoResolutionValues`  L46
- `String videoSlowResolution`  L47
- `String videoSlowResolutionValues`  L48
- `String videoTimelapseInterval`  L49
- `String videoTimelapseIntervalValues`  L50
- `String videoTimelapseResolution`  L51
- `String videoTimelapseResolutionValues`  L52
- `String videoLoopTypeValues = "<binary/metadata>"`  L53
- `String videoLoopType = "<binary/metadata>"`  L54
- `String GeneralPurposeItemName = "<binary/metadata>"`  L55
- `String GeneralPurposeResolution = "<binary/metadata>"`  L56