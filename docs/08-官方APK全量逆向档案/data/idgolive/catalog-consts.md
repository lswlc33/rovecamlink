# idGoLive — 常量字面值全量目录

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 10974 个 static final 常量，分布在 345 个类里；按类分组，值为 jadx 反编译后的字面量
> 数值常量是端口/超时/枚举 id/缓冲大小的唯一真相来源；字符串常量常在 `catalog-http.md`/`catalog-templates.md` 里再出现一次

---

### `com.android.installreferrer.api.InstallReferrerClient$InstallReferrerResponse`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEVELOPER_ERROR` | int | 3 | 28 |
| `FEATURE_NOT_SUPPORTED` | int | 2 | 29 |
| `OK` | int | 0 | 30 |
| `SERVICE_DISCONNECTED` | int | -1 | 31 |
| `SERVICE_UNAVAILABLE` | int | 1 | 32 |

### `com.android.installreferrer.api.InstallReferrerClientImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PLAY_STORE_MIN_APP_VER` | int | 80837300 | 20 |
| `SERVICE_ACTION_NAME` | String | "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE" | 21 |
| `SERVICE_NAME` | String | "com.google.android.finsky.externalreferrer.GetInstallReferrerService" | 22 |
| `SERVICE_PACKAGE_NAME` | String | "com.android.vending" | 23 |
| `TAG` | String | "InstallReferrerClient" | 24 |

### `com.android.installreferrer.api.InstallReferrerClientImpl$ClientState`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CLOSED` | int | 3 | 32 |
| `CONNECTED` | int | 2 | 33 |
| `CONNECTING` | int | 1 | 34 |
| `DISCONNECTED` | int | 0 | 35 |

### `com.android.installreferrer.api.ReferrerDetails`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_INSTALL_BEGIN_TIMESTAMP` | String | "install_begin_timestamp_seconds" | 7 |
| `KEY_INSTALL_REFERRER` | String | "install_referrer" | 8 |
| `KEY_REFERRER_CLICK_TIMESTAMP` | String | "referrer_click_timestamp_seconds" | 9 |

### `com.android.installreferrer.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APPLICATION_ID` | String | "com.android.installreferrer" | 5 |
| `BUILD_TYPE` | String | "release" | 6 |
| `DEBUG` | boolean | false | 7 |
| `FLAVOR` | String | "<binary/metadata>" | 8 |
| `VERSION_CODE` | int | -1 | 9 |
| `VERSION_NAME` | String | "<binary/metadata>" | 10 |

### `com.icatch.bluetooth.sdk.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APPLICATION_ID` | String | "com.icatch.bluetooth.sdk" | 7 |
| `BUILD_TYPE` | String | "debug" | 8 |
| `FLAVOR` | String | "<binary/metadata>" | 10 |
| `VERSION_CODE` | int | 1 | 11 |
| `VERSION_NAME` | String | "<binary/metadata>" | 12 |

### `com.icatch.golive.Application.PanoramaApp`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaApp" | 19 |

### `com.icatch.golive.data.AppInfo.AppInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APP_LOG_DIRECTORY_PATH` | String | "/idGoLive/MobileCam_APP_Log/" | 14 |
| `APP_PATH` | String | "/idGoLive/" | 15 |
| `APP_VERSION` | String | "V1.4.3" | 16 |
| `AUTO_DOWNLOAD_PATH` | String | "/DCIM/idGoLive/photo/" | 17 |
| `DOWNLOAD_PATH` | String | "/DCIM/idGoLive/" | 18 |
| `DOWNLOAD_PATH_PHOTO` | String | "/DCIM/idGoLive/photo/" | 19 |
| `DOWNLOAD_PATH_VIDEO` | String | "/DCIM/idGoLive/video/" | 20 |
| `EULA_VERSION` | String | "1.3" | 21 |
| `FILE_GOOGLE_TOKEN` | String | "file_googleToken.dat" | 22 |
| `FW_UPGRADE_FILENAME` | String | "SPHOST.BRN" | 23 |
| `PROPERTY_CFG_DIRECTORY_PATH` | String | "/idGoLive/Resoure/" | 24 |
| `PROPERTY_CFG_FILE_NAME` | String | "netconfig.properties" | 25 |
| `SDK_LOG_DIRECTORY_PATH` | String | "/idGoLive/MobileCam_SDK_Log/" | 26 |
| `SDK_VERSION` | String | "V3.6.0.39" | 27 |
| `STREAM_OUTPUT_DIRECTORY_PATH` | String | "/idGoLive/Resoure/Raw/" | 28 |
| `TAG` | String | "AppInfo" | 29 |

### `com.icatch.golive.data.AppInfo.AppSharedPreferences`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_NAME` | String | "storeInfo" | 8 |
| `OBJECT_NAME_DEFAULT_PWD` | String | "default_pwd" | 9 |
| `OBJECT_NAME_INPUT_IP` | String | "inputIp" | 10 |
| `OBJECT_NAME_LIVE_URL` | String | "liveUrl" | 11 |

### `com.icatch.golive.data.AppInfo.ConfigureInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ConfigureInfo" | 18 |

### `com.icatch.golive.data.entity.MultiPbItemInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MultiPbItemInfo" | 7 |

### `com.icatch.golive.data.entity.PropertyTypeInteger`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PropertyTypeInteger" | 21 |

### `com.icatch.golive.data.GlobalApp.ExitApp`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ExitApp" | 12 |

### `com.icatch.golive.data.GlobalApp.GlobalInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "GlobalInfo" | 18 |

### `com.icatch.golive.data.Message.AppMessage`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTIVITY_MESSAGE` | int | 0 | 5 |
| `AP_MODE_TO_STA_MODE_FAILURE` | int | 4098 | 6 |
| `AP_MODE_TO_STA_MODE_SUSSED` | int | 4097 | 7 |
| `CANCEL_DOWNLOAD_ALL` | int | 772 | 8 |
| `CANCEL_DOWNLOAD_SINGLE` | int | 771 | 9 |
| `DOWNLOAD_BEGIN` | int | 775 | 10 |
| `DOWNLOAD_FAILURE` | int | 778 | 11 |
| `DOWNLOAD_FINISHED` | int | 776 | 12 |
| `DOWNLOAD_SUCCEED` | int | 777 | 13 |
| `EVENT_CACHE_PROGRESS_NOTIFY` | int | 1538 | 14 |
| `EVENT_CACHE_STATE_CHANGED` | int | 1537 | 15 |
| `EVENT_VIDEO_PLAY_COMPLETED` | int | 1539 | 16 |
| `FACEBOOK_LOGIN_SUCCEED` | int | 4101 | 17 |
| `FUNCTION_MESSAGE` | int | 4096 | 18 |
| `GOOGLE_LOGIN_SUCCEED` | int | 6 | 19 |
| `LAUNCH_ACTIVITY` | int | 0 | 20 |
| `LOCAL_ACTIVITY` | int | 256 | 21 |
| `LOCAL_VIDEO_PBACTIVITY` | int | 1536 | 22 |
| `MESSAGE_CAMERA_CONNECT_FAIL` | int | 3 | 24 |
| `MESSAGE_CAMERA_CONNECT_SUCCESS` | int | 4 | 25 |
| `MESSAGE_CAMERA_CONNECTING_START` | int | 5 | 23 |
| `MESSAGE_CAMERA_SCAN_TIME_OUT` | int | 2 | 26 |
| `MESSAGE_CANCEL_DOWNLOAD_SINGLE` | int | 769 | 27 |
| `MESSAGE_CANCEL_VIDEO_DOWNLOAD` | int | 1541 | 28 |
| `MESSAGE_CONNECTED` | int | 4100 | 29 |
| `MESSAGE_DELETE_CAMERA` | int | 1 | 30 |
| `MESSAGE_DISCONNECTED` | int | 4099 | 31 |
| `MESSAGE_LIVE_NETWORK_DISCONNECT` | int | 514 | 32 |
| `MESSAGE_UPDATE_VIDEOPB_BAR` | int | 1540 | 33 |
| `MESSAGE_VIDEO_STREAM_CODEC_INFO` | int | 1543 | 34 |
| `MESSAGE_VIDEO_STREAM_NO_EIS_INFORMATION` | int | 1542 | 35 |
| `MESSAGE_WIFI_PASSWORD_ERROR` | int | 4103 | 36 |
| `MPB_ACTIVITY` | int | 768 | 37 |
| `OPEN_WIFI_HOTSPOT_FAILED` | int | 4102 | 38 |
| `PHOTO_PBACTIVITY` | int | 1024 | 39 |
| `PREVIEW_ACTIVITY` | int | 512 | 40 |
| `SETTING_OPTION_AUTO_DOWNLOAD` | int | 513 | 41 |
| `UPDATE_LOADING_PROGRESS` | int | 770 | 42 |
| `UPDATE_TOTAL_PROGRESS` | int | 773 | 43 |
| `VIDEO_PBACTIVITY` | int | 1280 | 44 |

### `com.icatch.golive.data.Mode.CameraNetworkMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AP` | int | 1 | 7 |
| `ETHERNET` | int | 2 | 8 |
| `STATION` | int | 0 | 9 |

### `com.icatch.golive.data.Mode.PreviewLaunchMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RT_PREVIEW_MODE` | int | 2 | 5 |
| `VIDEO_PB_MODE` | int | 1 | 6 |

### `com.icatch.golive.data.Mode.PreviewMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APP_STATE_NONE_MODE` | int | 0 | 5 |
| `APP_STATE_STILL_CAPTURE` | int | 2 | 6 |
| `APP_STATE_STILL_MODE` | int | 4097 | 7 |
| `APP_STATE_STILL_PREVIEW` | int | 1 | 8 |
| `APP_STATE_TIMELAPSE_MODE` | int | 4099 | 9 |
| `APP_STATE_TIMELAPSE_STILL_CAPTURE` | int | 6 | 10 |
| `APP_STATE_TIMELAPSE_STILL_PREVIEW` | int | 8 | 11 |
| `APP_STATE_TIMELAPSE_VIDEO_CAPTURE` | int | 5 | 12 |
| `APP_STATE_TIMELAPSE_VIDEO_PREVIEW` | int | 7 | 13 |
| `APP_STATE_VIDEO_CAPTURE` | int | 4 | 14 |
| `APP_STATE_VIDEO_MODE` | int | 4098 | 15 |
| `APP_STATE_VIDEO_PREVIEW` | int | 3 | 16 |

### `com.icatch.golive.data.PropertyId.PropertyId`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AP_MODE_TO_STA_MODE` | int | 55291 | 5 |
| `AUTO_POWER_OFF` | int | 55073 | 6 |
| `BLUETOOTH_AUDIO_RECORDING` | int | 55221 | 7 |
| `BURST_NUMBER` | int | 20504 | 8 |
| `CAMERA_CONNECT_CHANGE` | int | 55201 | 9 |
| `CAMERA_DATE` | int | 20497 | 10 |
| `CAMERA_DATE_TIMEZONE` | int | 55358 | 11 |
| `CAMERA_ESSID` | int | 55356 | 12 |
| `CAMERA_IMAGE_SWITCHING` | int | 55222 | 13 |
| `CAMERA_NAME` | int | 55345 | 14 |
| `CAMERA_PASSWORD` | int | 55357 | 15 |
| `CAMERA_PASSWORD_NEW` | int | 55346 | 16 |
| `CAMERA_PB_LIMIT_NUMBER` | int | 55359 | 17 |
| `CAMERA_SWITCH` | int | 55091 | 18 |
| `CAPTURE_DELAY` | int | 20498 | 19 |
| `CAPTURE_DELAY_MODE` | int | 55280 | 20 |
| `CAPTURE_IN_VIDEO_RECORD` | int | 55082 | 21 |
| `DATE_STAMP` | int | 54791 | 22 |
| `DEFALUT_TO_PREVIEW` | int | 55084 | 23 |
| `ESSID_NAME` | int | 55348 | 24 |
| `ESSID_PASSWORD` | int | 55349 | 25 |
| `EXPOSURE_COMPENSATION` | int | 55075 | 26 |
| `FAST_MOTION_MOVIE` | int | 55078 | 27 |
| `G_SENSOR` | int | 55228 | 28 |
| `IMAGE_SIZE` | int | 20483 | 29 |
| `IMAGE_STABILIZATION` | int | 55076 | 30 |
| `LIGHT_FREQUENCY` | int | 54790 | 31 |
| `MICROPHONE_RECEPTION` | int | 55220 | 32 |
| `MULTIPLE_CAMERA_SENSOR` | int | 55081 | 33 |
| `NOTIFY_FW_TO_SHARE_MODE` | int | 55291 | 34 |
| `POWER_ON_AUTO_RECORD` | int | 55074 | 35 |
| `RESET_DEVICE` | int | 55217 | 36 |
| `SCREEN_SAVER` | int | 55072 | 37 |
| `SD_SPACE` | int | 55218 | 38 |
| `SD_SPACE_REMAIN` | int | 55219 | 39 |
| `SERVICE_ESSID` | int | 55350 | 40 |
| `SERVICE_PASSWORD` | int | 55351 | 41 |
| `SLOW_MOTION` | int | 54805 | 42 |
| `STA_MODE_PASSWORD` | int | 55349 | 43 |
| `STA_MODE_SSID` | int | 55348 | 44 |
| `SUPPORT_PREVIEW` | int | 55295 | 45 |
| `TIMELAPSE_MODE` | int | 60928 | 46 |
| `TIMELAPSE_VIDEO_SIZE_LIST_MASK` | int | 55291 | 47 |
| `UP_SIDE` | int | 55216 | 48 |
| `VIDEO_FILE_LENGTH` | int | 55077 | 49 |
| `VIDEO_RECORDING_TIME` | int | 55293 | 50 |
| `VIDEO_SIZE` | int | 54789 | 51 |
| `VIDEO_SIZE_FLOW` | int | 55292 | 52 |
| `VIDEO_WARNING_QUERY` | int | 55224 | 53 |
| `WHITE_BALANCE` | int | 20485 | 54 |
| `WIND_NOISE_REDUCTION` | int | 55079 | 55 |

### `com.icatch.golive.data.SystemInfo.HotSpot`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "HotSpot" | 16 |
| `WIFI_AP_STATE_DISABLED` | int | 11 | 17 |
| `WIFI_AP_STATE_DISABLING` | int | 10 | 18 |
| `WIFI_AP_STATE_ENABLED` | int | 13 | 19 |
| `WIFI_AP_STATE_ENABLING` | int | 12 | 20 |
| `WIFI_AP_STATE_FAILED` | int | 14 | 21 |

### `com.icatch.golive.data.SystemInfo.SystemInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SystemInfo" | 18 |

### `com.icatch.golive.data.type.CameraSwitch`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CAMERA_BACK` | int | 1 | 5 |
| `CAMERA_FRONT` | int | 0 | 6 |

### `com.icatch.golive.data.type.TimeLapseDuration`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TIME_LAPSE_DURATION_10MIN` | int | 10 | 12 |
| `TIME_LAPSE_DURATION_15MIN` | int | 15 | 13 |
| `TIME_LAPSE_DURATION_20MIN` | int | 20 | 14 |
| `TIME_LAPSE_DURATION_2MIN` | int | 2 | 15 |
| `TIME_LAPSE_DURATION_30MIN` | int | 30 | 16 |
| `TIME_LAPSE_DURATION_5MIN` | int | 5 | 17 |
| `TIME_LAPSE_DURATION_60MIN` | int | 60 | 18 |
| `TIME_LAPSE_DURATION_UNLIMITED` | int | 65535 | 19 |

### `com.icatch.golive.data.type.TimeLapseInterval`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TIME_LAPSE_INTERVAL_OFF` | int | 0 | 10 |

### `com.icatch.golive.data.type.TimeLapseMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TIME_LAPSE_MODE_STILL` | int | 0 | 5 |
| `TIME_LAPSE_MODE_VIDEO` | int | 1 | 6 |

### `com.icatch.golive.data.type.Upside`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `UPSIDE_OFF` | int | 0 | 5 |
| `UPSIDE_ON` | int | 1 | 6 |

### `com.icatch.golive.DataConvert.CameraNetworkMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AP` | int | 1 | 7 |
| `ETHERNET` | int | 2 | 8 |
| `STATION` | int | 0 | 9 |

### `com.icatch.golive.db.CameraSlotSQLiteHelper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DATABASE_NAME` | String | "cameraSlotDb112.db" | 10 |
| `DATABASE_TABLE` | String | "cameraSlotInfo" | 11 |
| `DATABASE_VERSION` | int | 2 | 12 |

### `com.icatch.golive.entity.FileInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `kTakePhotoType` | String | "kTakePhotoType" | 10 |
| `kVideoNormalType` | String | "kVideoNormalType" | 11 |
| `kVideoWarningType` | String | "kVideoWarningType" | 12 |

### `com.icatch.golive.entity.FirmwareInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_FIRMWARE_LIST` | String | "firmware_list" | 17 |
| `PREFS_NAME` | String | "firmware_prefs" | 18 |

### `com.icatch.golive.entity.LanguageInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `kLanguageEn` | String | "language_english_new" | 5 |
| `kLanguageJa` | String | "language_japanese_new" | 6 |
| `kLanguageKr` | String | "language_korean_new" | 7 |
| `kLanguageTh` | String | "language_thai_new" | 8 |
| `kLanguageZh` | String | "language_zh_cn_new" | 9 |
| `kLanguageZhHant` | String | "language_zh_hant_new" | 10 |

### `com.icatch.golive.Function.CameraAction.PhotoCapture`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhotoCapture" | 18 |
| `TYPE_BURST_CAPTURE` | int | 1 | 19 |
| `TYPE_NORMAL_CAPTURE` | int | 2 | 20 |

### `com.icatch.golive.Function.GlobalEvent`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EVENT_SDCARD_INSERT` | int | 17 | 14 |
| `EVENT_SDCARD_REMOVED` | int | 16 | 15 |
| `EVENT_SEARCHED_NEW_CAMERA` | int | 15 | 16 |

### `com.icatch.golive.Function.live.Facebook.GraphOperation`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "GraphOperation" | 18 |

### `com.icatch.golive.Function.live.google.Credentials`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FACEBOOK_APP_ID` | String | "1540807289473122" | 5 |
| `FACEBOOK_APP_SECRET` | String | "236e282277e8ee3150c447cf0307bcb3" | 6 |
| `FACEBOOK_REDIRECT_URI` | String | "http://demo.xarx.rocks/" | 7 |
| `GOOGLE_CLIENT_ID` | String | "982555336638-vis3bioouhq71m4logk3qo525dpt3b37.apps.googleusercontent.com" | 8 |
| `GOOGLE_CLIENT_SECRET` | String | "RsVLvlB509wjbY4clv5ih_mn" | 9 |
| `GOOGLE_REDIRECT_URI` | String | "http://localhost:8080" | 10 |

### `com.icatch.golive.Function.live.google.GoogleAuthTool`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CLIENT_ID` | String | "168811923581-u0njo0me7v4dd2ihb1n1c5hbkk0d1v9d.apps.googleusercontent.com" | 13 |
| `CLIENT_SECRET` | String | "6sMzO0akSmW2GOcSyQPGkm4o" | 14 |

### `com.icatch.golive.Function.SDKEvent`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EVENT_BATTERY_ELETRIC_CHANGED` | int | 0 | 19 |
| `EVENT_CAPTURE_COMPLETED` | int | 1 | 20 |
| `EVENT_CAPTURE_START` | int | 3 | 21 |
| `EVENT_CONNECTION_FAILURE` | int | 8 | 22 |
| `EVENT_FILE_ADDED` | int | 7 | 23 |
| `EVENT_FILE_DOWNLOAD` | int | 11 | 24 |
| `EVENT_FW_UPDATE_CHECK` | int | 25 | 25 |
| `EVENT_FW_UPDATE_CHKSUMERR` | int | 26 | 26 |
| `EVENT_FW_UPDATE_COMPLETED` | int | 13 | 27 |
| `EVENT_FW_UPDATE_NG` | int | 27 | 28 |
| `EVENT_FW_UPDATE_POWEROFF` | int | 14 | 29 |
| `EVENT_SD_CARD_FULL` | int | 4 | 32 |
| `EVENT_SDCARD_INSERT` | int | 17 | 30 |
| `EVENT_SDCARD_REMOVED` | int | 16 | 31 |
| `EVENT_SEARCHED_NEW_CAMERA` | int | 15 | 33 |
| `EVENT_SERVER_STREAM_ERROR` | int | 10 | 34 |
| `EVENT_TIME_LAPSE_STOP` | int | 9 | 35 |
| `EVENT_VIDEO_OFF` | int | 5 | 36 |
| `EVENT_VIDEO_ON` | int | 6 | 37 |
| `EVENT_VIDEO_PLAY_CLOSED` | int | 24 | 38 |
| `EVENT_VIDEO_PLAY_PTS` | int | 23 | 39 |
| `EVENT_VIDEO_RECORDING_TIME` | int | 12 | 40 |
| `TAG` | String | "SDKEvent" | 41 |

### `com.icatch.golive.Function.Setting.OptionSetting`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "OptionSetting" | 52 |

### `com.icatch.golive.Function.Setting.UIDisplaySource`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CAPTURE_SETTING_MENU` | int | 1 | 23 |
| `TIMELAPSE_SETTING_MENU` | int | 3 | 24 |
| `VIDEO_SETTING_MENU` | int | 2 | 25 |

### `com.icatch.golive.Function.streaming.H264DecoderThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "H264DecoderThread" | 21 |

### `com.icatch.golive.Function.streaming.MjpgDecoderThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MjpgDecoderThread" | 21 |

### `com.icatch.golive.Function.USB.DeviceFilter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DeviceFilter" | 19 |

### `com.icatch.golive.Function.USB.USBHost_Feature`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_USB_PERMISSION_BASE` | String | "com.example.USB_PERMISSION." | 23 |
| `HANDLER_USB_DEVICE_ATTACHED_ID` | int | 1 | 24 |
| `HANDLER_USB_DEVICE_ATTACHED_KEY` | String | "HANDLER_USB_DEVICE_ATTACHED" | 25 |
| `HANDLER_USB_DEVICE_DETACHED_ID` | int | 2 | 26 |
| `HANDLER_USB_DEVICE_DETACHED_KEY` | String | "HANDLER_USB_DEVICE_DETACHED" | 27 |
| `USB_PRODUCT_ID` | int | 25427 | 28 |
| `USB_UAC_FREQUENCY` | int | 48000 | 29 |
| `USB_UAC_NCHANNELS` | int | 2 | 30 |
| `USB_UAC_SAMPLEBIT` | int | 16 | 31 |
| `USB_VENDOR_ID` | int | 10925 | 32 |

### `com.icatch.golive.Function.USB.USBMonitor`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_USB_PERMISSION_BASE` | String | "com.serenegiant.USB_PERMISSION." | 28 |
| `DEBUG` | boolean | true | 29 |
| `TAG` | String | "USBMonitor" | 30 |

### `com.icatch.golive.Listener.MyOrientoinListener`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MyOrientoinListener" | 11 |

### `com.icatch.golive.Log.AppLog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `maxFileSize` | long | 52428800 | 23 |

### `com.icatch.golive.MyCamera.CommandSession`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `tag` | String | "CommandSession" | 16 |
| `TAG` | String | "CommandSession" | 14 |

### `com.icatch.golive.MyCamera.LocalSession`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LocalSession" | 13 |

### `com.icatch.golive.MyCamera.PanoramaSession`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaSession" | 15 |

### `com.icatch.golive.net.ConnectDeviceManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `$assertionsDisabled` | boolean | false | 363 |
| `TAG` | String | "ConnectDeviceManager" | 21 |

### `com.icatch.golive.net.LyCmdWithYzIC`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "QzIntegratedCircuit" | 23 |

### `com.icatch.golive.net.LyIC`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `kReceivedLySocketMsg` | String | "ReceivedLySocketMsg" | 21 |
| `TAG` | String | "LyIntegratedCircuit" | 20 |

### `com.icatch.golive.net.LySocketClient`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LySocketClient" | 23 |

### `com.icatch.golive.net.LyWyzRequestInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `urlCmdReady2RemoteFile` | String | "http://192.168.1.254/?custom=1&cmd=2001,8010,3001&str=0,0,10" | 6 |
| `urlDeleteOneFile` | String | "http://192.168.1.254/app/deletefile?file=" | 7 |
| `urlFileEmrList` | String | "http://192.168.1.254/app/getfilelist?folder=emr&start=0&end=99999" | 8 |
| `urlFileList` | String | "http://192.168.1.254/app/getfilelist?folder=loop" | 9 |
| `urlFileListAll` | String | "http://192.168.1.254/?custom=1&cmd=3015&str=REC" | 10 |
| `urlFilePhotoList` | String | "http://192.168.1.254/app/getfilelist?folder=event&start=0&end=99999" | 11 |
| `urlFormat` | String | "http://192.168.1.254/app/sdformat" | 12 |
| `urlGetCapability` | String | "http://192.168.1.254/app/capability" | 13 |
| `urlGetDeviceStatus` | String | "http://192.168.1.254/api/getdeviceinfo/?custom=1&cmd=2002" | 14 |
| `urlGetItemsRecResolution` | String | "http://192.168.1.254/app/getparamitems?param=rec_resolution" | 15 |
| `urlGetMediaInfo` | String | "http://192.168.1.254/app/getmediainfo" | 16 |
| `urlGetParamItems` | String | "http://192.168.1.254/app/getparamitems?param=all" | 17 |
| `urlGetParamValueAll` | String | "http://192.168.1.254/app/getparamvalue?param=all" | 18 |
| `urlGetProductInfo` | String | "http://192.168.1.254/app/getproductinfo?" | 19 |
| `urlGetRecDuration` | String | "http://192.168.1.254/app/getrecduration" | 20 |
| `urlGetSDcardStatus` | String | "http://192.168.1.254/api/getdeviceinfo/?custom=1&cmd=2004" | 22 |
| `urlGetSDInfo` | String | "http://192.168.1.254/app/getsdinfo" | 21 |
| `urlGetSSID` | String | "http://192.168.1.254/app/getdeviceattr" | 23 |
| `urlGetValueRecResolution` | String | "http://192.168.1.254/app/getparamvalue?param=rec_resolution" | 24 |
| `urlHeartbeatPackage` | String | "http://192.168.1.254/app/getparamvalue?param=rec" | 26 |
| `urlHeartbeatStart` | String | "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=4016&par=1" | 27 |
| `urlHOST` | String | "http://192.168.1.254/" | 25 |
| `urlModeChangeOther` | String | "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=3033&par=1" | 28 |
| `urlModePlaybackEnter` | String | "http://192.168.1.254/app/playback?param=enter" | 29 |
| `urlModePlaybackExit` | String | "http://192.168.1.254/app/playback?param=exit" | 30 |
| `urlModeRecorderEnter` | String | "http://192.168.1.254/app/enterrecorder" | 31 |
| `urlModeRecorderExit` | String | "http://192.168.1.254/app/exitrecorder" | 32 |
| `urlModeSettingEnter` | String | "http://192.168.1.254/app/setting?param=enter" | 33 |
| `urlModeSettingExit` | String | "http://192.168.1.254/app/setting?param=exit" | 34 |
| `urlMovieRecordStart` | String | "http://192.168.1.254/?custom=1&cmd=2001&str=1" | 35 |
| `urlMovieRecordStop` | String | "http://192.168.1.254/?custom=1&cmd=2001&str=0" | 36 |
| `urlQueryMenuItem` | String | "http://192.168.1.254/api/getdeviceinfo/?custom=1&cmd=3031" | 37 |
| `urlReconnectWiFi` | String | "http://192.168.1.254/app/wifireboot" | 38 |
| `urlSetDate` | String | "http://192.168.1.254/?custom=1&cmd=3005&str=" | 39 |
| `urlSetLanguageEn` | String | "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=1008&par=1" | 40 |
| `urlSetLanguageZh` | String | "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=1008&par=0" | 41 |
| `urlSetTime` | String | "http://192.168.1.254/?custom=1&cmd=3006&str=" | 42 |
| `urlSettingBase` | String | "http://192.168.1.254/app/setwifi?" | 43 |
| `urlSettingParamValue` | String | "http://192.168.1.254/app/setparamvalue?" | 44 |
| `urlSwitchBackCam` | String | "http://192.168.1.254/app/setparamvalue?param=switchcam&value=1" | 45 |
| `urlSwitchFrontCam` | String | "http://192.168.1.254/app/setparamvalue?param=switchcam&value=0" | 46 |
| `urlSystemReset` | String | "http://192.168.1.254/app/reset" | 47 |
| `urlTriggerRAWencode` | String | "http://192.168.1.254/app/snapshot" | 48 |
| `urPhtotCapture` | String | "http://192.168.1.254/api/setdeviceinfo/?custom=1&cmd=1100&par=0" | 5 |

### `com.icatch.golive.net.M1RequestInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `urlDeleteOneFile` | String | "http://192.168.169.1/app/deletefile?file=" | 6 |
| `urlFileEmrList` | String | "http://192.168.169.1/app/getfilelist?folder=emr&start=0&end=99999" | 7 |
| `urlFileList` | String | "http://192.168.169.1/app/getfilelist?folder=loop" | 8 |
| `urlFilePhotoList` | String | "http://192.168.169.1/app/getfilelist?folder=event&start=0&end=99999" | 9 |
| `urlFormat` | String | "http://192.168.169.1/app/sdformat" | 10 |
| `urlGetCapability` | String | "http://192.168.169.1/app/capability" | 11 |
| `urlGetDeviceStatus` | String | "http://192.168.169.1/api/getdeviceinfo/?custom=1&cmd=2002" | 12 |
| `urlGetItemsRecResolution` | String | "http://192.168.169.1/app/getparamitems?param=rec_resolution" | 13 |
| `urlGetMediaInfo` | String | "http://192.168.169.1/app/getmediainfo" | 14 |
| `urlGetParamItems` | String | "http://192.168.169.1/app/getparamitems?param=all" | 15 |
| `urlGetParamValueAll` | String | "http://192.168.169.1/app/getparamvalue?param=all" | 16 |
| `urlGetProductInfo` | String | "http://192.168.169.1/app/getproductinfo?" | 17 |
| `urlGetRecDuration` | String | "http://192.168.169.1/app/getrecduration" | 18 |
| `urlGetSDcardStatus` | String | "http://192.168.169.1/api/getdeviceinfo/?custom=1&cmd=2004" | 20 |
| `urlGetSDInfo` | String | "http://192.168.169.1/app/getsdinfo" | 19 |
| `urlGetSSID` | String | "http://192.168.169.1/app/getdeviceattr" | 21 |
| `urlGetValueRecResolution` | String | "http://192.168.169.1/app/getparamvalue?param=rec_resolution" | 22 |
| `urlHeartbeatPackage` | String | "http://192.168.169.1/app/getparamvalue?param=rec" | 24 |
| `urlHeartbeatStart` | String | "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=4016&par=1" | 25 |
| `urlHOST` | String | "http://192.168.169.1/" | 23 |
| `urlModeChangeOther` | String | "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=3033&par=1" | 26 |
| `urlModePlaybackEnter` | String | "http://192.168.169.1/app/playback?param=enter" | 27 |
| `urlModePlaybackExit` | String | "http://192.168.169.1/app/playback?param=exit" | 28 |
| `urlModeRecorderEnter` | String | "http://192.168.169.1/app/enterrecorder" | 29 |
| `urlModeRecorderExit` | String | "http://192.168.169.1/app/exitrecorder" | 30 |
| `urlModeSettingEnter` | String | "http://192.168.169.1/app/setting?param=enter" | 31 |
| `urlModeSettingExit` | String | "http://192.168.169.1/app/setting?param=exit" | 32 |
| `urlMovieRecordStart` | String | "http://192.168.169.1/app/setparamvalue?param=rec&value=1" | 33 |
| `urlMovieRecordStop` | String | "http://192.168.169.1/app/setparamvalue?param=rec&value=0" | 34 |
| `urlQueryMenuItem` | String | "http://192.168.169.1/api/getdeviceinfo/?custom=1&cmd=3031" | 35 |
| `urlReconnectWiFi` | String | "http://192.168.169.1/app/wifireboot" | 36 |
| `urlSetDate` | String | "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=3005&str=" | 37 |
| `urlSetLanguageEn` | String | "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=1008&par=1" | 38 |
| `urlSetLanguageZh` | String | "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=1008&par=0" | 39 |
| `urlSetTime` | String | "http://192.168.169.1/app/setsystime?date=" | 40 |
| `urlSettingBase` | String | "http://192.168.169.1/app/setwifi?" | 41 |
| `urlSettingParamValue` | String | "http://192.168.169.1/app/setparamvalue?" | 42 |
| `urlSwitchBackCam` | String | "http://192.168.169.1/app/setparamvalue?param=switchcam&value=1" | 43 |
| `urlSwitchFrontCam` | String | "http://192.168.169.1/app/setparamvalue?param=switchcam&value=0" | 44 |
| `urlSystemReset` | String | "http://192.168.169.1/app/reset" | 45 |
| `urlTriggerRAWencode` | String | "http://192.168.169.1/app/snapshot" | 46 |
| `urPhtotCapture` | String | "http://192.168.169.1/api/setdeviceinfo/?custom=1&cmd=1100&par=0" | 5 |

### `com.icatch.golive.net.OkHttpDownUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "OkHttpDownUtil" | 22 |

### `com.icatch.golive.net.QzIC`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "QzIntegratedCircuit" | 24 |

### `com.icatch.golive.net.RequestInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `codeFailure` | int | 404 | 5 |
| `codeGetSSID` | int | 20001 | 6 |
| `codeSuccess` | int | 200 | 7 |
| `urlAddIdCamFeedback` | String | "https://api.idalbum.com/album.php/api/addIdCamFeedback" | 13 |
| `urlCyclicRecordCustom` | String | "http://192.168.1.254/?custom=1&cmd=2003&par=" | 14 |
| `urlDeleteAll` | String | "http://192.168.1.254/?custom=1&cmd=4004" | 15 |
| `urlDeleteOneFile` | String | "http://192.168.1.254/?custom=1&cmd=4003&str=" | 16 |
| `urlFileList` | String | "http://192.168.1.254/?custom=1&cmd=3015" | 17 |
| `urlFormat` | String | "http://192.168.1.254/?custom=1&cmd=3010&par=1" | 18 |
| `urlGetBatteryState` | String | "http://192.168.1.254/?custom=1&cmd=8013" | 24 |
| `urlGetCardStatus` | String | "http://192.168.1.254/?custom=1&cmd=3024" | 25 |
| `urlGetCustomerServiceInfo` | String | "http://api.idstore.idalbum.com/api/getCustomerServiceInfo" | 26 |
| `urlGetFreeSpace` | String | "http://192.168.1.254/?custom=1&cmd=3017" | 27 |
| `urlGetHeadphoneState` | String | "http://192.168.1.254/?custom=1&cmd=8012" | 28 |
| `urlGetIdCamSoftwareVersionInfo` | String | "https://api.idalbum.com/album.php/api/getIdCamSoftwareVersionInfo" | 29 |
| `urlGetMoveSizeCapacity` | String | "http://192.168.1.254/?custom=1&cmd=3030" | 30 |
| `urlGetRAWencodeJPEG` | String | "http://192.168.1.254/?custom=1&cmd=2018" | 31 |
| `urlGetSSID` | String | "http://192.168.1.254/?custom=1&cmd=3029" | 32 |
| `urlGetVersion` | String | "http://192.168.1.254/?custom=1&cmd=3012" | 33 |
| `urlGSensorHigh` | String | "http://192.168.1.254/?custom=1&cmd=2011&par=3" | 19 |
| `urlGSensorIdMax` | String | "http://192.168.1.254/?custom=1&cmd=2011&par=4" | 20 |
| `urlGSensorLow` | String | "http://192.168.1.254/?custom=1&cmd=2011&par=1" | 21 |
| `urlGSensorMed` | String | "http://192.168.1.254/?custom=1&cmd=2011&par=2" | 22 |
| `urlGSensorOff` | String | "http://192.168.1.254/?custom=1&cmd=2011&par=0" | 23 |
| `urlHeartbeatPackage` | String | "http://192.168.1.254/?custom=1&cmd=8888" | 35 |
| `urlHeartbeatPackage2` | String | "http://192.168.1.254/?custom=1&cmd=3016" | 36 |
| `urlHOST` | String | "http://192.168.1.254/" | 34 |
| `urlLensRotationOff` | String | "http://192.168.1.254/?custom=1&cmd=3044&par=0" | 37 |
| `urlLensRotationOn` | String | "http://192.168.1.254/?custom=1&cmd=3044&par=1" | 38 |
| `urlMicrophoneModeHeadphone` | String | "http://192.168.1.254/?custom=1&cmd=8010&par=1" | 39 |
| `urlMicrophoneModeNoumenon` | String | "http://192.168.1.254/?custom=1&cmd=8010&par=0" | 40 |
| `urlModeChangeMovie` | String | "http://192.168.1.254/?custom=1&cmd=3001&par=1" | 41 |
| `urlModeChangePhoto` | String | "http://192.168.1.254/?custom=1&cmd=3001&par=0" | 42 |
| `urlModeChangePlayback` | String | "http://192.168.1.254/?custom=1&cmd=3001&par=2" | 43 |
| `urlMovieLiveStart` | String | "http://192.168.1.254/?custom=1&cmd=2015&par=1" | 44 |
| `urlMovieLiveStop` | String | "http://192.168.1.254/?custom=1&cmd=2015&par=0" | 45 |
| `urlMovieRecordingTime` | String | "http://192.168.1.254/?custom=1&cmd=2016" | 49 |
| `urlMovieRecordSizeCustom` | String | "http://192.168.1.254/?custom=1&cmd=2002&par=" | 46 |
| `urlMovieRecordStart` | String | "http://192.168.1.254/?custom=1&cmd=2001&par=1" | 47 |
| `urlMovieRecordStop` | String | "http://192.168.1.254/?custom=1&cmd=2001&par=0" | 48 |
| `urlQueryCurrentStatus` | String | "http://192.168.1.254/?custom=1&cmd=3014" | 50 |
| `urlQueryMenuItem` | String | "http://192.168.1.254/?custom=1&cmd=3031&str=all" | 51 |
| `urlQueryStatus` | String | "http://192.168.1.254/?custom=1&cmd=" | 52 |
| `urlReconnectWiFi` | String | "http://192.168.1.254/?custom=1&cmd=3018" | 53 |
| `urlRecordAudioOff` | String | "http://192.168.1.254/?custom=1&cmd=8011&par=0" | 54 |
| `urlRecordAudioOn` | String | "http://192.168.1.254/?custom=1&cmd=8011&par=1" | 55 |
| `urlSaveMenuSettings` | String | "http://192.168.1.254/?custom=1&cmd=3021" | 56 |
| `urlSetDate` | String | "http://192.168.1.254/?custom=1&cmd=3005&str=" | 57 |
| `urlSetPassphrase` | String | "http://192.168.1.254/?custom=1&cmd=3004&str=" | 58 |
| `urlSetSSID` | String | "http://192.168.1.254/?custom=1&cmd=3003&str=" | 59 |
| `urlSetTime` | String | "http://192.168.1.254/?custom=1&cmd=3006&str=" | 60 |
| `urlSystemReset` | String | "http://192.168.1.254/?custom=1&cmd=3011" | 61 |
| `urlTimeImprintOff` | String | "http://192.168.1.254/?custom=1&cmd=2008&par=0" | 62 |
| `urlTimeImprintOn` | String | "http://192.168.1.254/?custom=1&cmd=2008&par=1" | 63 |
| `urlTriggerRAWencode` | String | "http://192.168.1.254/?custom=1&cmd=2017" | 64 |
| `urlWDROff` | String | "http://192.168.1.254/?custom=1&cmd=2004&par=0" | 65 |
| `urlWDROn` | String | "http://192.168.1.254/?custom=1&cmd=2004&par=1" | 66 |
| `urPhtotCapture` | String | "http://192.168.1.254/?custom=1&cmd=1001" | 8 |
| `urPhtotCaptureSize10M` | String | "http://192.168.1.254/?custom=1&cmd=1002&par=1" | 9 |
| `urPhtotCaptureSize12M` | String | "http://192.168.1.254/?custom=1&cmd=1002&par=0" | 10 |
| `urPhtotCaptureSize5M` | String | "http://192.168.1.254/?custom=1&cmd=1002&par=3" | 11 |
| `urPhtotCaptureSize8M` | String | "http://192.168.1.254/?custom=1&cmd=1002&par=2" | 12 |

### `com.icatch.golive.Presenter.BTPairBeginPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BLUETOOTH_SCAN_TIME_OUT` | int | 4 | 39 |
| `CONNECT_CAMERA_FAILED` | int | 7 | 40 |
| `CONNECT_WIFI_FAILED` | int | 6 | 41 |
| `GET_BLUETOOTH_CLIENT` | int | 3 | 42 |
| `GET_BLUETOOTH_CLIENT_FAILED` | int | 9 | 43 |
| `GET_BLUETOOTH_CLIENT_SUCCESS` | int | 8 | 44 |
| `GET_BLUETOOTH_DEVICE` | int | 2 | 45 |
| `REQUEST_BLUETOOTH_SCAN` | int | 0 | 46 |

### `com.icatch.golive.Presenter.LaunchPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LaunchPresenter" | 73 |

### `com.icatch.golive.Presenter.LocalMultiPbPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LocalMultiPbPresenter" | 17 |

### `com.icatch.golive.Presenter.LocalPhotoPbPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DIRECTION_LEFT` | int | 2 | 48 |
| `DIRECTION_RIGHT` | int | 1 | 49 |
| `DIRECTION_UNKNOWN` | int | 4 | 50 |
| `FIXED_INSIDE_DISTANCE` | float | 0.45454544f | 51 |
| `FIXED_INSIDE_FOCUS` | float | 2.0f | 52 |
| `FIXED_NEAR_DISTANCE` | float | 0.6f | 53 |
| `FIXED_OUTSIDE_DISTANCE` | float | 2.0f | 54 |
| `FIXED_OUTSIDE_FOCUS` | float | 1.0f | 55 |
| `MAX_ZOOM` | float | 2.2f | 56 |
| `MIN_ZOOM` | float | 0.5f | 57 |

### `com.icatch.golive.Presenter.LocalVideoPbPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FIXED_INSIDE_DISTANCE` | float | 0.45454544f | 37 |
| `FIXED_OUTSIDE_DISTANCE` | float | 2.0f | 38 |
| `MAX_ZOOM` | float | 2.2f | 39 |
| `MIN_ZOOM` | float | 0.5f | 40 |

### `com.icatch.golive.Presenter.PhotoPbPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DIRECTION_LEFT` | int | 2 | 61 |
| `DIRECTION_RIGHT` | int | 1 | 62 |
| `DIRECTION_UNKNOWN` | int | 4 | 63 |
| `FIXED_INSIDE_DISTANCE` | float | 0.45454544f | 64 |
| `FIXED_INSIDE_FOCUS` | float | 2.0f | 65 |
| `FIXED_NEAR_DISTANCE` | float | 0.6f | 66 |
| `FIXED_OUTSIDE_DISTANCE` | float | 2.0f | 67 |
| `FIXED_OUTSIDE_FOCUS` | float | 1.0f | 68 |
| `MAX_ZOOM` | float | 2.2f | 69 |
| `MIN_ZOOM` | float | 0.5f | 70 |

### `com.icatch.golive.Presenter.PreviewPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FIXED_INSIDE_DISTANCE` | float | 0.5f | 118 |
| `FIXED_OUTSIDE_DISTANCE` | float | 3.0f | 119 |
| `MAX_ZOOM` | float | 2.2f | 120 |
| `MIN_ZOOM` | float | 0.4f | 121 |
| `TAG` | String | "PanoramaPreviewPresenter" | 122 |

### `com.icatch.golive.Presenter.RemoteDeviceFilesFragmentPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `$assertionsDisabled` | boolean | false | 46 |

### `com.icatch.golive.Presenter.RemoteMultiPbPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RemoteMultiPbPresenter" | 37 |

### `com.icatch.golive.Presenter.RemoteMultiPbPresenter2`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RemoteMultiPbPresenter2" | 32 |

### `com.icatch.golive.Presenter.USBPreviewPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FIXED_INSIDE_DISTANCE` | float | 0.5f | 92 |
| `FIXED_OUTSIDE_DISTANCE` | float | 3.0f | 93 |
| `MAX_ZOOM` | float | 2.2f | 94 |
| `MIN_ZOOM` | float | 0.4f | 95 |
| `TAG` | String | "USBPreviewPresenter" | 96 |

### `com.icatch.golive.Presenter.VideoPbPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_ZOOM` | float | 2.2f | 60 |
| `MIN_ZOOM` | float | 0.5f | 61 |

### `com.icatch.golive.SdkApi.CameraAction`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CameraAction" | 23 |

### `com.icatch.golive.SdkApi.mobileapi.MediaPlayListenerManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CACHE_LOADED` | int | 2 | 15 |
| `CACHE_LOADING` | int | 1 | 16 |
| `TAG` | String | "MediaPlayListenerManager" | 17 |

### `com.icatch.golive.SdkApi.mobileapi.PanoramaControl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaControl" | 17 |

### `com.icatch.golive.SdkApi.mobileapi.PanoramaSession`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaSession" | 34 |

### `com.icatch.golive.SdkApi.mobileapi.PreviewStreamingControl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PreviewStreamingControl" | 28 |

### `com.icatch.golive.SdkApi.mobileapi.VideoStreamingControl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "VideoStreamingControl" | 26 |

### `com.icatch.golive.SdkApi.PanoramaPhotoPlayback`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaPhotoPlayback" | 23 |

### `com.icatch.golive.SdkApi.PanoramaPreviewPlayback`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaPreviewPlayback" | 42 |

### `com.icatch.golive.SdkApi.PanoramaVideoPlayback`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaVideoPlayback" | 29 |

### `com.icatch.golive.ui.activity.CommonVideoPlayerActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CommonVideoPlayerActivity" | 29 |

### `com.icatch.golive.ui.activity.DownloadFirmwareActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DownloadFirmwareActivity" | 43 |

### `com.icatch.golive.ui.activity.FeedbackActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FeedbackActivity" | 33 |

### `com.icatch.golive.ui.activity.LaunchActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `kPublishGooglePlay` | boolean | false | 66 |
| `TAG` | String | "LaunchActivity" | 64 |

### `com.icatch.golive.ui.activity.LdeviceSettingActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `$assertionsDisabled` | boolean | false | 43 |
| `TAG` | String | "LdeviceSettingActivity" | 44 |

### `com.icatch.golive.ui.activity.LocalPhotoPbActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LocalPhotoPbActivity" | 26 |

### `com.icatch.golive.ui.activity.LocalVideoPlayerActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `kVideoPlayTitle` | String | "VideoPlayTitle" | 15 |
| `kVideoPlayURL` | String | "VideoPlayURL" | 16 |

### `com.icatch.golive.ui.activity.LoginGoogleActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RC_GET_AUTH_CODE` | int | 9003 | 38 |
| `TAG` | String | "LoginGoogleActivity" | 39 |

### `com.icatch.golive.ui.activity.LYDownloadFileActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `kDownloadFiles` | String | "DownloadFiles" | 38 |
| `kDownloadFileType` | String | "DownloadFileType" | 37 |
| `TAG` | String | "LYDownloadFileActivity" | 36 |

### `com.icatch.golive.ui.activity.LYLiveVideoActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LYLiveVideoActivity" | 55 |

### `com.icatch.golive.ui.activity.LYRemoteFileActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LYRemoteFileActivity" | 29 |

### `com.icatch.golive.ui.activity.LYVideoPlayerActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `kVideoPlayTitle` | String | "VideoPlayTitle" | 23 |
| `kVideoPlayURL` | String | "VideoPlayURL" | 24 |
| `kVideoPlayUrlThumbnail` | String | "VideoPlayUrlThumbnail" | 25 |

### `com.icatch.golive.ui.activity.PhotoPbActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhotoPbActivity" | 24 |

### `com.icatch.golive.ui.activity.PreviewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PreviewActivity" | 62 |

### `com.icatch.golive.ui.activity.StartPageActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "StartPageActivity" | 33 |

### `com.icatch.golive.ui.activity.USBPreviewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "USBPreviewActivity" | 40 |

### `com.icatch.golive.ui.activity.WifiApActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEBUG` | boolean | true | 21 |

### `com.icatch.golive.ui.activity.YdeviceSettingActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `kHiddenBackMirrorKey` | String | "isHiddenBackMirror" | 44 |
| `TAG` | String | "YdeviceSettingActivity" | 43 |

### `com.icatch.golive.ui.adapter.LocalDeviceFilesAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DATE` | int | 0 | 32 |
| `PHOTO` | int | 1 | 33 |

### `com.icatch.golive.ui.adapter.LocalPhotoPbViewPagerAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhotoPbViewPagerAdapter" | 18 |

### `com.icatch.golive.ui.adapter.LYRemoteFileAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DATE` | int | 0 | 24 |
| `PHOTO` | int | 1 | 25 |

### `com.icatch.golive.ui.adapter.MultiPbRecyclerViewAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_GRID` | int | 1 | 26 |
| `TYPE_LIST` | int | 2 | 27 |
| `TYPE_QUICK_LIST` | int | 3 | 28 |

### `com.icatch.golive.ui.adapter.PhotoPbViewPagerAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhotoPbViewPagerAdapter" | 20 |

### `com.icatch.golive.ui.adapter.RemoteDeviceFilesAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DATE` | int | 0 | 29 |
| `PHOTO` | int | 1 | 30 |

### `com.icatch.golive.ui.adapter.SettingListAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SettingListAdapter" | 26 |

### `com.icatch.golive.ui.appdialog.AppDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AppDialog" | 16 |

### `com.icatch.golive.ui.ExtendComponent.NumberProgressBar`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INSTANCE_MAX` | String | "max" | 21 |
| `INSTANCE_PREFIX` | String | "prefix" | 22 |
| `INSTANCE_PROGRESS` | String | "progress" | 23 |
| `INSTANCE_REACHED_BAR_COLOR` | String | "reached_bar_color" | 24 |
| `INSTANCE_REACHED_BAR_HEIGHT` | String | "reached_bar_height" | 25 |
| `INSTANCE_STATE` | String | "saved_instance" | 26 |
| `INSTANCE_SUFFIX` | String | "suffix" | 27 |
| `INSTANCE_TEXT_COLOR` | String | "text_color" | 28 |
| `INSTANCE_TEXT_SIZE` | String | "text_size" | 29 |
| `INSTANCE_TEXT_VISIBILITY` | String | "text_visibility" | 30 |
| `INSTANCE_UNREACHED_BAR_COLOR` | String | "unreached_bar_color" | 31 |
| `INSTANCE_UNREACHED_BAR_HEIGHT` | String | "unreached_bar_height" | 32 |
| `PROGRESS_TEXT_VISIBLE` | int | 0 | 33 |

### `com.icatch.golive.ui.ExtendComponent.ZoomView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DISPLAY_DURATION` | int | 5000 | 21 |
| `TAG` | String | "ZoomView" | 24 |

### `com.icatch.golive.ui.Fragment.BTPairCompletedFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONNECT_CAMERA_FAILED` | int | 17 | 36 |
| `CONNECT_WIFI_FAILED` | int | 16 | 37 |
| `ENABLE_WIFI_FAILED` | int | 14 | 38 |
| `START_CHECK_CONNECT_WIFI` | int | 19 | 39 |

### `com.icatch.golive.ui.Fragment.DialogFragmentFromBottom`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ANIM` | String | "anim_style" | 36 |
| `BOTTOM` | String | "show_bottom" | 37 |
| `CANCEL` | String | "out_cancel" | 38 |
| `DIM` | String | "dim_amount" | 39 |
| `formatType` | String | "yyyy-MM-dd HH:mm:ss" | 45 |
| `HEIGHT` | String | "height" | 40 |
| `LAYOUT` | String | "layout_id" | 41 |
| `MARGIN` | String | "margin" | 42 |
| `TAG` | String | "DialogFragmentFromBottom" | 43 |
| `WIDTH` | String | "width" | 44 |

### `com.icatch.golive.ui.Fragment.LocalDeviceFilesFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LocalDeviceFilesFragment" | 31 |

### `com.icatch.golive.ui.Fragment.LocalMultiPbFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LocalMultiPbFragment" | 23 |

### `com.icatch.golive.ui.Fragment.RemoteDeviceFilesFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RemoteMultiPbFragment2" | 37 |

### `com.icatch.golive.ui.Fragment.RemoteMultiPbFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RemoteMultiPbFragment" | 30 |

### `com.icatch.golive.ui.Fragment.RemoteMultiPbFragment2`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RemoteMultiPbFragment2" | 24 |

### `com.icatch.golive.ui.Fragment.RemoteMultiPbPhotoFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RemoteMultiPbPhotoFragment" | 33 |

### `com.icatch.golive.utils.BitmapTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LIMITED_IMGAE_SIZE` | long | 10485760 | 11 |
| `THUMBNAIL_HEIGHT` | int | 100 | 13 |
| `THUMBNAIL_WIDTH` | int | 100 | 14 |

### `com.icatch.golive.utils.ClickUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MIN_CLICK_DELAY_TIME` | long | 500 | 8 |

### `com.icatch.golive.utils.CrashHandler`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CrashHandler" | 25 |

### `com.icatch.golive.utils.DisplayHelper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "Devices" | 19 |

### `com.icatch.golive.utils.FileFilter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `formatType` | String | "yyyy-MM-dd HH:mm:ss" | 18 |
| `TIME_TYPE_ALL_TIME` | int | 6 | 11 |
| `TIME_TYPE_ALMOST_A_MONTH` | int | 3 | 12 |
| `TIME_TYPE_ALMOST_A_WEEK` | int | 2 | 13 |
| `TIME_TYPE_CUSTOMIZE` | int | 5 | 14 |
| `TIME_TYPE_LAST_HALF_YEAR` | int | 4 | 15 |
| `TIME_TYPE_LAST_THREE_DAY` | int | 1 | 16 |
| `TIME_TYPE_TODAY` | int | 0 | 17 |

### `com.icatch.golive.utils.fileutils.FileOper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileOper" | 12 |

### `com.icatch.golive.utils.fileutils.FileTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILENAME_SEQUENCE_SEPARATOR` | String | "-" | 27 |
| `TAG` | String | "FileTools" | 28 |

### `com.icatch.golive.utils.fileutils.FileUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileUtil" | 27 |

### `com.icatch.golive.utils.fileutils.MFileTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MFileTools" | 10 |

### `com.icatch.golive.utils.imageloader.ICatchtekImageDownloader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HTTP_SOCKET_TIMEOUT_MS` | int | 10000 | 20 |

### `com.icatch.golive.utils.imageloader.ImageLoaderConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ImageLoaderConfig" | 20 |

### `com.icatch.golive.utils.imageloader.Md5FileNameGeneratorMatchFaceName`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HASH_ALGORITHM` | String | "MD5" | 11 |
| `RADIX` | int | 36 | 12 |

### `com.icatch.golive.utils.imageloader.TutkUriUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `URI_PREFIX` | String | "tutk://" | 8 |

### `com.icatch.golive.utils.LruCacheTool`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LruCacheTool" | 9 |

### `com.icatch.golive.utils.MediaRefresh`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_MEDIA_SCANNER_SCAN_DIR` | String | "android.intent.action.MEDIA_SCANNER_SCAN_DIR" | 18 |
| `TAG` | String | "MediaRefresh" | 19 |

### `com.icatch.golive.utils.PanoramaTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaTools" | 11 |

### `com.icatch.golive.utils.PermissionTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ALL_REQUEST_CODE` | int | 102 | 13 |
| `CAMERA_REQUEST_CODE` | int | 103 | 14 |
| `WRITE_OR_READ_EXTERNAL_STORAGE_REQUEST_CODE` | int | 102 | 16 |

### `com.icatch.golive.utils.SharedPreferencesUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONFIG_FILE` | String | "appLocalInfo" | 12 |
| `isDebug` | boolean | false | 16 |
| `SETUP_WIFI_LIST` | String | "setup_wifi_list" | 14 |
| `TAG` | String | "SharedPreferencesUtil" | 15 |

### `com.icatch.golive.utils.SPUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_AREA` | String | "local-user-area" | 16 |
| `KEY_LANGUAGE` | String | "local-language" | 17 |
| `KEY_VIDEOS` | String | "local-private-videos" | 18 |

### `com.icatch.golive.utils.VersionChecker`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "VersionChecker" | 10 |

### `com.icatch.golive.utils.WifiAPUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONNECTIVITY_CHANGE_ACTION` | String | "android.net.conn.CONNECTIVITY_CHANGE" | 20 |
| `DEBUG` | boolean | true | 21 |
| `DEFAULT_AP_PASSWORD` | String | "12345678" | 22 |
| `EXTRA_WIFI_AP_STATE` | String | "wifi_state" | 23 |
| `MESSAGE_AP_STATE_ENABLED` | int | 1 | 24 |
| `MESSAGE_AP_STATE_FAILED` | int | 2 | 25 |
| `TAG` | String | "WifiAPUtil" | 26 |
| `WIFI_AP_STATE_CHANGED_ACTION` | String | "android.net.wifi.WIFI_AP_STATE_CHANGED" | 27 |

### `com.icatch.golive.utils.WifiCheck`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONNECT_FAILED` | int | 2 | 26 |
| `IN_BACKGROUND` | int | 3 | 27 |
| `RECONNECT_CAMERA` | int | 9 | 28 |
| `RECONNECT_FAILED` | int | 5 | 30 |
| `RECONNECT_SUCCESS` | int | 4 | 31 |
| `WIFICIPHER_NOPASS` | int | 6 | 34 |
| `WIFICIPHER_WAP` | int | 8 | 35 |
| `WIFICIPHER_WEP` | int | 7 | 36 |

### `com.icatch.golive.utils.WifiNetworkSpecifierUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "WifiNetworkSpecifierUtil" | 22 |

### `com.icatch.golive.utils.XmlParseUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `keyCmd2003` | String | "Cmd2003" | 16 |
| `keyCmd2011` | String | "Cmd2011" | 17 |
| `keyCmd8010` | String | "Cmd8010" | 18 |
| `keyCmd8011` | String | "Cmd8011" | 19 |

### `com.icatchtek.basecomponent.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APPLICATION_ID` | String | "com.icatchtek.basecomponent" | 7 |
| `BUILD_TYPE` | String | "debug" | 8 |
| `FLAVOR` | String | "<binary/metadata>" | 10 |
| `VERSION_CODE` | int | 1 | 11 |
| `VERSION_NAME` | String | "V0.0.1" | 12 |

### `com.icatchtek.basecomponent.customcomponent.ImageProgressView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_ALPHA` | int | 255 | 19 |
| `MIN_ALPHA` | int | 0 | 20 |

### `com.icatchtek.basecomponent.customcomponent.PhotoCropView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACCURACY` | int | 15 | 18 |
| `EDGE_WIDTH` | float | 1.8f | 19 |
| `minHeight` | int | 200 | 27 |
| `minWidth` | int | 100 | 28 |
| `MODE_ILLEGAL` | int | 221 | 20 |
| `MODE_INSIDE` | int | 187 | 21 |
| `MODE_OUTSIDE` | int | 170 | 22 |
| `MODE_POINT` | int | 204 | 23 |
| `START_X` | int | 200 | 24 |
| `START_Y` | int | 200 | 25 |
| `TAG` | String | "PhotoCropView" | 26 |

### `com.icatchtek.basecomponent.customcomponent.RadarView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `height` | int | 600 | 21 |
| `LINE_NUM` | int | 6 | 18 |
| `Max_X` | int | 680 | 19 |
| `Max_Y` | int | 680 | 20 |
| `startX` | int | 80 | 23 |
| `startY` | int | 80 | 24 |
| `width` | int | 600 | 25 |

### `com.icatchtek.basecomponent.customcomponent.RadarView3`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LINE_NUM` | int | 6 | 20 |
| `startX` | int | 80 | 22 |
| `startY` | int | 80 | 23 |

### `com.icatchtek.basecomponent.customcomponent.RadarView4`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ASSISTANGLE` | int | 12 | 21 |
| `INTERVAL_MM` | float | 2000.0f | 22 |
| `LINE_NUM_X` | float | 6.0f | 23 |
| `LINE_NUM_Y` | float | 3.0f | 24 |

### `com.icatchtek.basecomponent.customcomponent.zones.AreaType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_POLYGON` | int | 1 | 5 |
| `TYPE_RECTANGLE` | int | 0 | 6 |

### `com.icatchtek.basecomponent.customcomponent.zones.BitmapUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "BitmapUtil" | 15 |

### `com.icatchtek.basecomponent.customcomponent.zones.DragPolygonView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_DISTANCE_FOR_CLICK` | int | 100 | 25 |
| `MAX_INTERVAL_FOR_CLICK` | int | 200 | 26 |
| `TAG` | String | "DragPolygonView" | 27 |
| `TOUCH_CENTER` | int | 18 | 28 |
| `TOUCH_PAINT` | int | 17 | 29 |

### `com.icatchtek.basecomponent.customcomponent.zones.DragRectView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BOTTOM` | int | 35 | 27 |
| `CENTER` | int | 37 | 28 |
| `LEFT` | int | 34 | 29 |
| `LEFT_BOTTOM` | int | 25 | 30 |
| `LEFT_TOP` | int | 23 | 31 |
| `RIGHT` | int | 36 | 32 |
| `RIGHT_BOTTOM` | int | 32 | 33 |
| `RIGHT_TOP` | int | 24 | 34 |
| `TAG` | String | "DragRectView" | 35 |
| `TOP` | int | 33 | 36 |

### `com.icatchtek.basecomponent.customcomponent.zones.PrivacyZonesView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PrivacyZonesView" | 20 |

### `com.icatchtek.basecomponent.dialog.SimpleCalendarDialogFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_CROSS_YEARS` | int | 3 | 36 |
| `TAG` | String | "SimpleCalendarDialogFragment" | 37 |

### `com.icatchtek.basecomponent.imageview.CircleImageView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BITMAP_CONFIG` | Bitmap.Config | Bitmap.Config.ARGB_8888 | 53 |
| `COLORDRAWABLE_DIMENSION` | int | 2 | 27 |
| `DEFAULT_BORDER_COLOR` | int | -16777216 | 28 |
| `DEFAULT_BORDER_OVERLAY` | boolean | false | 29 |
| `DEFAULT_BORDER_WIDTH` | int | 0 | 30 |
| `DEFAULT_CIRCLE_BACKGROUND_COLOR` | int | 0 | 31 |
| `SCALE_TYPE` | ImageView.ScaleType | ImageView.ScaleType.CENTER_CROP | 52 |

### `com.icatchtek.basecomponent.prompt.AppDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AppDialog" | 13 |

### `com.icatchtek.basecomponent.utils.LongClickUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LongClickUtils" | 12 |

### `com.icatchtek.baseutil.AudioFocusUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AudioFocusUtil" | 10 |

### `com.icatchtek.baseutil.awss3v4signer.auth.AWS4SignerBase`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ALGORITHM` | String | "HMAC-SHA256" | 21 |
| `DateStringFormat` | String | "yyyyMMdd" | 22 |
| `EMPTY_BODY_SHA256` | String | "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855" | 23 |
| `ISO8601BasicFormat` | String | "yyyyMMdd'T'HHmmss'Z'" | 24 |
| `SCHEME` | String | "AWS4" | 25 |
| `TERMINATOR` | String | "aws4_request" | 26 |
| `UNSIGNED_PAYLOAD` | String | "UNSIGNED-PAYLOAD" | 27 |

### `com.icatchtek.baseutil.awss3v4signer.auth.AWS4SignerForChunkedUpload`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CHUNK_SIGNATURE_HEADER` | String | ";chunk-signature=" | 13 |
| `CHUNK_STRING_TO_SIGN_PREFIX` | String | "AWS4-HMAC-SHA256-PAYLOAD" | 14 |
| `CLRF` | String | "\r\n" | 15 |
| `SIGNATURE_LENGTH` | int | 64 | 17 |
| `STREAMING_BODY_SHA256` | String | "STREAMING-AWS4-HMAC-SHA256-PAYLOAD" | 18 |

### `com.icatchtek.baseutil.Base64Utils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `$assertionsDisabled` | boolean | false | 7 |
| `CRLF` | int | 4 | 8 |
| `DEFAULT` | int | 0 | 9 |
| `NO_CLOSE` | int | 16 | 10 |
| `NO_PADDING` | int | 1 | 11 |
| `NO_WRAP` | int | 2 | 12 |
| `URL_SAFE` | int | 8 | 13 |

### `com.icatchtek.baseutil.Base64Utils$Decoder`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DECODE` | int[] | {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1} | 28 |
| `DECODE_WEBSAFE` | int[] | {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1} | 29 |
| `EQUALS` | int | -2 | 30 |
| `SKIP` | int | -1 | 31 |

### `com.icatchtek.baseutil.Base64Utils$Encoder`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `$assertionsDisabled` | boolean | false | 172 |
| `ENCODE` | byte[] | {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47} | 173 |
| `ENCODE_WEBSAFE` | byte[] | {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95} | 174 |
| `LINE_GROUPS` | int | 19 | 175 |

### `com.icatchtek.baseutil.bitmap.BitmapTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LIMITED_IMGAE_SIZE` | long | 10485760 | 21 |
| `THUMBNAIL_HEIGHT` | int | 100 | 23 |
| `THUMBNAIL_WIDTH` | int | 100 | 24 |

### `com.icatchtek.baseutil.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APPLICATION_ID` | String | "com.icatchtek.baseutil" | 7 |
| `BUILD_TYPE` | String | "debug" | 8 |
| `FLAVOR` | String | "<binary/metadata>" | 10 |
| `VERSION_CODE` | int | 1 | 11 |
| `VERSION_NAME` | String | "V0.0.1" | 12 |

### `com.icatchtek.baseutil.date.DateConverter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACCOUNT_SERVER_FORMAT` | String | "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" | 12 |
| `DAY_FORMAT` | String | "yyyy/MM/dd" | 13 |
| `DEVICE_DAY_FORMAT` | String | "yyyy-MM-dd" | 14 |
| `DEVICE_FORMAT` | String | "yyyyMMdd'T'HHmmss" | 15 |
| `FILE_NAME_FORMAT` | String | "yyyy-MM-dd_HH-mm-ss" | 16 |
| `MONTH_FORMAT` | String | "yyyy/MM" | 17 |
| `TAG` | String | "DateConverter" | 18 |
| `TIME` | String | "HH:mm:ss" | 19 |
| `TIME_FORMAT` | String | "yyyy/MM/dd HH:mm:ss" | 20 |
| `UI_FORMAT` | String | "yyyy-MM-dd HH:mm:ss" | 21 |

### `com.icatchtek.baseutil.date.DateUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CamDayFormat` | String | "yyyy/MM/dd" | 11 |
| `DayFormat` | String | "yyyy-MM-dd" | 12 |
| `TAG` | String | "DateUtil" | 13 |
| `TIME_FORMAT` | String | "yyyy/MM/dd HH:mm:ss" | 14 |
| `TimeFormat` | String | "HH:mm:ss" | 15 |

### `com.icatchtek.baseutil.download.ApiHelper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ApiHelper" | 9 |

### `com.icatchtek.baseutil.download.DownLoadUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DownloadUtil" | 26 |

### `com.icatchtek.baseutil.exceptions.AppNullPointerException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AppNullPointerException" | 7 |

### `com.icatchtek.baseutil.exceptions.CommunicateException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CommunicateException" | 7 |

### `com.icatchtek.baseutil.exceptions.IchInvalidArgumentException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.baseutil.FileUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileUtil" | 9 |

### `com.icatchtek.baseutil.imageloader.ImageLoaderConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ImageLoaderConfig" | 19 |

### `com.icatchtek.baseutil.imageloader.Md5FileNameGeneratorMatchFaceName`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HASH_ALGORITHM` | String | "MD5" | 11 |
| `RADIX` | int | 36 | 12 |

### `com.icatchtek.baseutil.info.AppInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACCOUNT_SERVER_ADDRESS_CN` | String | "api.bpsc.tinyai.top" | 6 |
| `ACCOUNT_SERVER_ADDRESS_USA` | String | "usa.boi.tinyai.top" | 7 |
| `ACCOUNT_SERVER_BASE_URL_CN` | String | "https://api.bpsc.tinyai.top:3026" | 9 |
| `ACCOUNT_SERVER_BASE_URL_INDEX_MAX` | int | 255 | 11 |
| `ACCOUNT_SERVER_BASE_URL_INDEX_PREFIX` | String | "URL_" | 12 |
| `ACCOUNT_SERVER_BASE_URL_USA` | String | "http://usa.boi.tinyai.top:3006" | 13 |
| `ACCOUNT_SERVER_DEFAULT_REGION` | String | "ap-northeast-1" | 14 |
| `ACCOUNT_SERVER_REGION_AP_EAST_1` | String | "ap-east-1" | 16 |
| `ACCOUNT_SERVER_REGION_AP_NORTHEAST_1` | String | "ap-northeast-1" | 17 |
| `ACCOUNT_SERVER_REGION_CN_NORTHWEST_1` | String | "cn-northwest-1" | 18 |
| `ACCOUNT_SERVER_REGION_CUSTOMIZATION_PREFIX` | String | "customization-" | 19 |
| `ACCOUNT_SERVER_REGION_US_WEST_1` | String | "us-west-1" | 20 |
| `APP_LOG_DIRECTORY_PATH` | String | "/BpSCam_APP_Log/" | 21 |
| `APP_LOG_TAG` | String | "BpSCamAPP_" | 22 |
| `CUSTOMER_PRIVACY_POLICY_VERSION` | String | "1.0" | 24 |
| `DEFAULT_PUSH_TYPE` | int | 2 | 25 |
| `DOWNLOAD_PATH` | String | "/DCIM/BpSCam/" | 26 |
| `enableMsgCenter` | boolean | true | 48 |
| `enableTalk` | boolean | true | 49 |
| `FILE_FILTER_FILE_NAME` | String | "file_filter.dat" | 27 |
| `ICATCH_PUSH_APP_KEY` | String | "XXXXXXX1C5262CC1" | 28 |
| `ICATCH_PUSH_APP_SECRET` | String | "784DDA534A18B1AE76" | 29 |
| `KVS_WEBRTC_REGION_HK` | String | "ap-east-1" | 31 |
| `KVS_WEBRTC_REGION_TOKYO` | String | "ap-northeast-1" | 32 |
| `NOT_AVAILABLE_DEVICE_NAME` | String | "NA" | 33 |
| `PROPERTY_CFG_DIRECTORY_PATH` | String | "/BpSCamResoure/" | 34 |
| `PROPERTY_CFG_FILE_NAME` | String | "netconfig.properties" | 35 |
| `PUSH_SERVER_ADDRESS` | String | "push.smarthome.icatchtek.com" | 37 |
| `PV_THUMB_PATH` | String | "/PVThumb/" | 39 |
| `SDK_LOG_DIRECTORY_PATH` | String | "/BpSCam_SDK_Log/" | 40 |
| `SETUP_DEFAULT_DEVICE_NAME_PREFIX` | String | "BpSCam_" | 42 |
| `SHARE_CAMERA_DEADLINE_DAYS` | int | 7 | 43 |
| `SHARE_QR_CODE_PATH` | String | "/ShareQrCode/" | 44 |
| `showBatteryIcon` | boolean | true | 59 |
| `SIMPLELINK_LOG_DIRECTORY_PATH` | String | "/BpSCam_SimpleLink_Log/" | 45 |
| `STREAM_OUTPUT_DIRECTORY_PATH` | String | "/BpSCamResoure/Raw/" | 46 |
| `useUSAServer` | boolean | false | 61 |

### `com.icatchtek.baseutil.info.PushMessage`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `STRATEGY_ATTACHMENT_TYPE_JPG` | int | 2 | 8 |
| `STRATEGY_ATTACHMENT_TYPE_JPG_TS` | int | 3 | 9 |
| `STRATEGY_ATTACHMENT_TYPE_NON` | int | 0 | 10 |
| `STRATEGY_ATTACHMENT_TYPE_TS` | int | 1 | 11 |

### `com.icatchtek.baseutil.info.PushServer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `GCM` | int | 4 | 5 |
| `ICATCH` | int | 1 | 6 |
| `JG` | int | 3 | 7 |
| `MI` | int | 6 | 8 |
| `TUTK` | int | 2 | 9 |
| `UNKNOWN` | int | 0 | 10 |
| `XG` | int | 5 | 11 |

### `com.icatchtek.baseutil.info.PushType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FCM_PUSH` | int | 1 | 5 |
| `JGUANG_PUSH` | int | 2 | 6 |
| `MI_PUSH` | int | 3 | 7 |
| `UNKNOWN` | int | 0 | 8 |
| `XG_PUSH` | int | 4 | 9 |

### `com.icatchtek.baseutil.info.SystemInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SystemInfo" | 33 |

### `com.icatchtek.baseutil.JumpPermissionManagement`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MANUFACTURER_HUAWEI` | String | "Huawei" | 18 |
| `MANUFACTURER_LENOVO` | String | "LENOVO" | 19 |
| `MANUFACTURER_LETV` | String | "Letv" | 20 |
| `MANUFACTURER_LG` | String | "LG" | 21 |
| `MANUFACTURER_MEIZU` | String | "Meizu" | 22 |
| `MANUFACTURER_OPPO` | String | "OPPO" | 23 |
| `MANUFACTURER_SAMSUNG` | String | "samsung" | 24 |
| `MANUFACTURER_SONY` | String | "Sony" | 25 |
| `MANUFACTURER_VIVO` | String | "vivo" | 26 |
| `MANUFACTURER_XIAOMI` | String | "Xiaomi" | 27 |
| `MANUFACTURER_YULONG` | String | "YuLong" | 28 |
| `MANUFACTURER_ZTE` | String | "ZTE" | 29 |
| `TAG` | String | "JumpPermissionManagement" | 30 |

### `com.icatchtek.baseutil.log.AppLog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `maxFileSize` | long | 52428800 | 24 |
| `TAG` | String | "AppLog" | 20 |

### `com.icatchtek.baseutil.mediacodec.PhoenixAVDemuxer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhoenixAVDemuxer" | 10 |

### `com.icatchtek.baseutil.MyOrientationEventListener`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SENSOR_ANGLE` | int | 10 | 8 |
| `TAG` | String | "MyOrientationEventListener" | 9 |

### `com.icatchtek.baseutil.network.NetWorkUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACCOUNT_SERVER` | String | AppInfo.ACCOUNT_SERVER_ADDRESS | 28 |
| `PUSH_SERVER` | String | "push.smarthome.icatchtek.com" | 29 |

### `com.icatchtek.baseutil.perference.BasePreferences`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_NAME` | String | "storeInfo" | 23 |
| `isDebug` | boolean | true | 27 |
| `PUSH_TEST` | String | "pushTest" | 25 |
| `TAG` | String | "CameraPreferences" | 26 |

### `com.icatchtek.baseutil.PermissionTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE` | int | 108 | 15 |
| `ALL_REQUEST_CODE` | int | 102 | 16 |
| `CAMERA_REQUEST_CODE` | int | 104 | 17 |
| `LOCATION_REQUEST_CODE` | int | 105 | 18 |
| `MICROPHONE_REQUEST_CODE` | int | 106 | 19 |
| `PHONE_REQUEST_CODE` | int | 107 | 20 |
| `STORAGE_REQUEST_CODE` | int | 103 | 21 |

### `com.icatchtek.baseutil.SaveWiFiInfoUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SaveWiFiInfoUtil" | 18 |

### `com.icatchtek.baseutil.SharedPreferencesUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONFIG_FILE` | String | "appLocalInfo" | 16 |
| `isDebug` | boolean | true | 20 |
| `SETUP_WIFI_LIST` | String | "setup_wifi_list" | 18 |
| `TAG` | String | "SharedPreferencesUtil" | 19 |

### `com.icatchtek.baseutil.ThreadPoolUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ThreadPoolUtils" | 15 |

### `com.icatchtek.baseutil.ThreadPoolUtils$ThreadPeriod`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PERIOD_HIGHT` | int | 10 | 76 |
| `PERIOD_LOW` | int | 1 | 77 |
| `PERIOD_MIDDLE` | int | 5 | 78 |

### `com.icatchtek.baseutil.ZipUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ZipUtil" | 17 |

### `com.icatchtek.bluetooth.core.base.BluetoothCondition`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "BluetoothCondition" | 11 |

### `com.icatchtek.bluetooth.core.base.BluetoothContext`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "BluetoothContext" | 15 |

### `com.icatchtek.bluetooth.core.base.BluetoothMutex`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "BluetoothMutex" | 9 |

### `com.icatchtek.bluetooth.core.client.bt.ICatchCoreBluetoothClient`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "ICatchCoreBluetoothClient" | 21 |

### `com.icatchtek.bluetooth.core.client.btle.ICatchCoreBluetoothLeClient`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HM10_UUID_CHAR_READ` | String | "0000ffe1-0000-1000-8000-00805f9b34fb" | 31 |
| `HM10_UUID_CHAR_WRITE` | String | "0000ffe1-0000-1000-8000-00805f9b34fb" | 32 |
| `ICAT_UUID_CHAR_READ` | String | "e44b82fb-f3a6-4c72-ab3f-bf94abfd9930" | 33 |
| `ICAT_UUID_CHAR_WRITE` | String | "e44b82fb-f3a6-4c72-ab3f-bf94abfd9930" | 34 |
| `icatch_bluetooth_tag` | String | "ICatchCoreBluetoothLeClient" | 38 |
| `STATE_CONNECTED` | int | 2 | 35 |
| `STATE_CONNECTING` | int | 1 | 36 |
| `STATE_DISCONNECTED` | int | 0 | 37 |

### `com.icatchtek.bluetooth.core.client.transfer.bt.BluetoothBinaryTransfer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "BluetoothBinaryTransfer" | 12 |

### `com.icatchtek.bluetooth.core.client.transfer.bt.ICatchCoreBluetoothTextTransfer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "ICatchCoreBluetoothTextTransfer" | 15 |

### `com.icatchtek.bluetooth.core.client.transfer.btle.ICatchCoreBluetoothLeGattTransfer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ICatchCoreBluetoothLeGattTransfer" | 13 |

### `com.icatchtek.bluetooth.core.client.transfer.btle.ICatchCoreBluetoothLeTextTransfer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "ICatchCoreBluetoothLeTextTransfer" | 20 |

### `com.icatchtek.bluetooth.core.event.BluetoothBroadcastHandler`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "BluetoothBroadcastHandler" | 14 |

### `com.icatchtek.bluetooth.core.event.BluetoothSystemBroadcastHandler`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "BluetoothSystemBroadcastHandler" | 17 |

### `com.icatchtek.bluetooth.core.ICatchCoreBluetoothAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "ICatchCoreBluetoothAdapter" | 24 |

### `com.icatchtek.bluetooth.core.ICatchCoreBluetoothCommand`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BT_CMD_BT_REQ_INFORM` | String | "{\"mode\": \"bt\", \"action\": \"info\"}" | 14 |
| `BT_CMD_BT_REQ_INFORM_NAME_PWD` | String | "{\"mode\": \"bt\", \"action\": \"info\", \"name\": \"\", \"pwd\": \"\"}" | 15 |
| `BT_CMD_BT_SET_INFORM` | String | "{\"mode\": \"bt\", \"action\": \"set\"}" | 16 |
| `BT_CMD_EVENT_KEY_CAPTURE` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"s2\"}" | 17 |
| `BT_CMD_EVENT_KEY_CAPTURE_HALF_PRESS` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"s1\"}" | 18 |
| `BT_CMD_EVENT_KEY_DEL` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"del\"}" | 19 |
| `BT_CMD_EVENT_KEY_DOWN` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"down\"}" | 20 |
| `BT_CMD_EVENT_KEY_LEFT` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"left\"}" | 21 |
| `BT_CMD_EVENT_KEY_MENU` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"menu\"}" | 22 |
| `BT_CMD_EVENT_KEY_MODE` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"mode\"}" | 23 |
| `BT_CMD_EVENT_KEY_RIGHT` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"right\"}" | 24 |
| `BT_CMD_EVENT_KEY_SET` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"set\"}" | 25 |
| `BT_CMD_EVENT_KEY_TELE` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"tele\"}" | 26 |
| `BT_CMD_EVENT_KEY_UP` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"up\"}" | 27 |
| `BT_CMD_EVENT_KEY_WIDE` | String | "{\"mode\": \"event\", \"action\": \"key\", \"type\": \"wide\"}" | 28 |
| `BT_CMD_REPLY_ERR` | String | "err=1" | 29 |
| `BT_CMD_REPLY_NOERR` | String | "err=0" | 30 |
| `BT_CMD_SYSTEM_POWER_DOWN` | String | "{\"mode\": \"system\", \"action\": \"power\", \"type\": \"down\"}" | 31 |
| `BT_CMD_SYSTEM_POWER_HIBER` | String | "{\"mode\": \"system\", \"action\": \"power\", \"type\": \"hiber\"}" | 32 |
| `BT_CMD_TAIL` | char | 0 | 33 |
| `BT_CMD_WIFI_REQ_DISABLE` | String | "{\"mode\": \"wifi\", \"action\": \"disable\"}" | 34 |
| `BT_CMD_WIFI_REQ_ENABLE` | String | "{\"mode\": \"wifi\", \"action\": \"enable\", \"type\": \"ap\"}" | 35 |
| `BT_CMD_WIFI_REQ_INFORM` | String | "{\"mode\": \"wifi\", \"action\": \"info\"}" | 36 |
| `BT_CMD_WIFI_REQ_INFORM_ESSID_PWD_IP` | String | "{\"mode\": \"wifi\", \"action\": \"info\", \"essid\": \"\", \"pwd\": \"\", \"ipaddr\": \"\"}" | 37 |
| `BT_CMD_WIFI_SET_INFORM` | String | "{\"mode\": \"wifi\", \"action\": \"set\"}" | 38 |
| `icatch_bluetooth_tag` | String | "ICatchCoreBluetoothCommand" | 39 |

### `com.icatchtek.bluetooth.customer.exception.IchBluetoothContextInvalidException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.bluetooth.customer.exception.IchBluetoothDeviceBusyException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.bluetooth.customer.exception.IchBluetoothDeviceDisabledException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.bluetooth.customer.exception.IchBluetoothNotBondedException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.bluetooth.customer.exception.IchBluetoothNotSupportedException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.bluetooth.customer.exception.IchBluetoothTimeoutException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.bluetooth.customer.ICatchBluetoothAssist`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "ICatchBluetoothAssist" | 25 |

### `com.icatchtek.bluetooth.customer.ICatchBluetoothManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `icatch_bluetooth_tag` | String | "ICatchBluetoothManager" | 27 |

### `com.icatchtek.bluetooth.customer.listener.ICatchBroadcastReceiverID`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BT_ACTION_ADAPTER_STATE_CHANGED` | String | "com.icatchtek.bluetooth.__icatch_bt_action_adapter_state_changed" | 5 |
| `BT_ACTION_BOND_STATE_CHANGED` | String | "com.icatchtek.bluetooth.__icatch_bt_action_bond_state_changed" | 6 |
| `BT_ADAPTER_ADDRESS` | String | "com.icatchtek.bluetooth.__icatch_bt_adapter_address" | 7 |
| `BT_ADAPTER_STATE` | String | "com.icatchtek.bluetooth.__icatch_bt_adapter_state" | 8 |
| `BT_ADAPTER_STATE_OFF` | int | 18 | 9 |
| `BT_ADAPTER_STATE_ON` | int | 17 | 10 |
| `BT_ADAPTER_STATE_TURNING_OFF` | int | 20 | 11 |
| `BT_ADAPTER_STATE_TURNING_ON` | int | 19 | 12 |
| `BT_BOND_STATE` | String | "com.icatchtek.bluetooth.__icatch_bt_bond_state" | 13 |
| `BT_BOND_STATE_BONDED` | int | 3 | 14 |
| `BT_BOND_STATE_BONDING` | int | 2 | 15 |
| `BT_BOND_STATE_NONE` | int | 1 | 16 |
| `BT_LE_GATT_ACTION_CONNECTION_STATE_CHANGED` | String | "com.icatchtek.bluetooth.__icatch_bt_le_gatt_action_connection_changed" | 17 |
| `BT_LE_GATT_ACTION_DATA_AVAILABLE` | String | "com.icatchtek.bluetooth.__icatch_bt_le_gatt_action_data_avaliable" | 18 |
| `BT_LE_GATT_ACTION_SERVICE_DISCOVERY_STATE_CHANGED` | String | "com.icatchtek.bluetooth.__icatch_bt_le_gatt_action_service_discovered" | 19 |
| `BT_LE_GATT_CONNECTED` | int | 33 | 20 |
| `BT_LE_GATT_CONNECTION_STATE` | String | "com.icatchtek.bluetooth.__icatch_bt_le_gatt_connection_state" | 21 |
| `BT_LE_GATT_DATA` | String | "com.icatchtek.bluetooth.__icatch_bt_le_gatt_data" | 22 |
| `BT_LE_GATT_DATA_CHANGED_AVAILABLE` | int | 39 | 23 |
| `BT_LE_GATT_DATA_READ_AVAILABLE` | int | 37 | 24 |
| `BT_LE_GATT_DATA_TYPE` | String | "com.icatchtek.bluetooth.__icatch_bt_le_gatt_data_type" | 25 |
| `BT_LE_GATT_DATA_WRITE_AVAILABLE` | int | 38 | 26 |
| `BT_LE_GATT_DISCONNECTED` | int | 34 | 27 |
| `BT_LE_GATT_NO_SERVICES_DISCOVERED` | int | 36 | 28 |
| `BT_LE_GATT_SERVICE_DISCOVERY_STATE` | String | "com.icatchtek.bluetooth.__icatch_bt_le_gatt_service_discovery_state" | 30 |
| `BT_LE_GATT_SERVICES_DISCOVERED` | int | 35 | 29 |
| `BT_LE_GATT_STATUS` | String | "com.icatchtek.bluetooth.__icatch_bt_le_gatt_status" | 31 |

### `com.icatchtek.bluetooth.customer.type.ICatchBluetoothDevice`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEVICE_TYPE_CLASSIC` | int | 1 | 5 |
| `DEVICE_TYPE_DUAL` | int | 3 | 6 |
| `DEVICE_TYPE_LE` | int | 2 | 7 |
| `DEVICE_TYPE_UNKNOWN` | int | 0 | 8 |

### `com.icatchtek.control.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "debug" | 7 |
| `LIBRARY_PACKAGE_NAME` | String | "com.icatchtek.control" | 9 |
| `VERSION_CODE` | int | 1 | 10 |
| `VERSION_NAME` | String | "1.0" | 11 |

### `com.icatchtek.control.core.CoreMulticast`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MULTI_CAST_ADDR` | String | "234.168.168.168" | 15 |
| `MULTI_CAST_PORT` | int | 5002 | 16 |

### `com.icatchtek.control.core.feature.ICatchCameraAssistImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TRANSPORT_TYPE_MSDC_SCSI` | int | 4 | 32 |
| `TRANSPORT_TYPE_NET_COMMON` | int | 1 | 33 |
| `TRANSPORT_TYPE_UVC_BULK` | int | 3 | 34 |
| `TRANSPORT_TYPE_UVC_ISO` | int | 2 | 35 |

### `com.icatchtek.control.core.feature.ICatchCameraConfigImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TRANSPORT_TYPE_MSDC_SCSI` | int | 4 | 13 |
| `TRANSPORT_TYPE_NET_COMMON` | int | 1 | 14 |
| `TRANSPORT_TYPE_UVC_BULK` | int | 3 | 15 |
| `TRANSPORT_TYPE_UVC_ISO` | int | 2 | 16 |

### `com.icatchtek.control.core.jni.extractor.NativeValueTag`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RETURN_BOOL_TAG` | String | "RET_BOOL" | 5 |
| `RETURN_DOUBLE_TAG` | String | "RET_DOUBLE" | 6 |
| `RETURN_ERR_TAG` | String | "RET_ERR" | 7 |
| `RETURN_INT_TAG` | String | "RET_INT" | 8 |
| `RETURN_LONG_TAG` | String | "RET_LONG" | 9 |
| `RETURN_STRING_TAG` | String | "RET_STRING" | 10 |
| `SEPARATOR_TAG` | String | "::" | 11 |

### `com.icatchtek.control.core.jni.JCameraLog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LOG_LEVEL_CONNECT` | int | 0 | 7 |
| `LOG_LEVEL_ERROR` | int | 3 | 8 |
| `LOG_LEVEL_INFO` | int | 1 | 9 |
| `LOG_LEVEL_WARN` | int | 2 | 10 |

### `com.icatchtek.control.core.jni.util.ExceptionErr`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_ALREADY_INIT` | int | -221 | 5 |
| `ICH_AUDIO_STREAM_CLOSED` | int | -91 | 6 |
| `ICH_BUF_TOO_SMALL` | int | -7 | 7 |
| `ICH_CALLBACK_EXISTS` | int | -40 | 8 |
| `ICH_CAM_BATTERY_LEVEL_NOT_SUPPORTED` | int | -300 | 9 |
| `ICH_CAM_BURST_NUMBER_GET_FAILED` | int | -322 | 10 |
| `ICH_CAM_BURST_NUMBER_NOT_SUPPORTED` | int | -321 | 11 |
| `ICH_CAM_BURST_NUMBER_SET_FAILED` | int | -323 | 12 |
| `ICH_CAM_CAP_DELAY_GET_FAILED` | int | -310 | 14 |
| `ICH_CAM_CAP_DELAY_NOT_SUPPORTED` | int | -309 | 15 |
| `ICH_CAM_CAP_DELAY_SET_FAILED` | int | -311 | 16 |
| `ICH_CAM_CAPTURE_ERROR` | int | -324 | 13 |
| `ICH_CAM_FREE_SPACE_IN_IMAGE_NOT_SUPPORTED` | int | -329 | 17 |
| `ICH_CAM_IMAGE_SIZE_FORMAT_ERROR` | int | -326 | 18 |
| `ICH_CAM_IMAGE_SIZE_GET_FAILED` | int | -313 | 19 |
| `ICH_CAM_IMAGE_SIZE_NOT_SUPPORTED` | int | -312 | 20 |
| `ICH_CAM_IMAGE_SIZE_SET_FAILED` | int | -314 | 21 |
| `ICH_CAM_LIGHT_FREQ_GET_FAILED` | int | -319 | 22 |
| `ICH_CAM_LIGHT_FREQ_NOT_SUPPORTED` | int | -318 | 23 |
| `ICH_CAM_LIGHT_FREQ_SET_FAILED` | int | -320 | 24 |
| `ICH_CAM_MODE_CAMERA_BUSY` | int | -303 | 25 |
| `ICH_CAM_MODE_CHANGE_FAILED` | int | -305 | 26 |
| `ICH_CAM_MODE_NOT_SUPPORT` | int | -301 | 27 |
| `ICH_CAM_MODE_PTP_CLIENT_INVALID` | int | -304 | 28 |
| `ICH_CAM_MODE_SET_ILLEGAL` | int | -302 | 29 |
| `ICH_CAM_MTP_GET_OBJECTS_ERROR` | int | -331 | 30 |
| `ICH_CAM_PROP_NOT_EXIST` | int | -332 | 31 |
| `ICH_CAM_PROP_PARSE_ERROR` | int | -335 | 32 |
| `ICH_CAM_PROP_TYPE_ERROR` | int | -333 | 33 |
| `ICH_CAM_PROP_VALUE_ERROR` | int | -334 | 34 |
| `ICH_CAM_PTP_INIT_FAILED` | int | -337 | 35 |
| `ICH_CAM_REMAIN_RECORD_TIME_NOT_SUPPORTED` | int | -330 | 36 |
| `ICH_CAM_SD_CARD_NOT_EXIST` | int | -328 | 37 |
| `ICH_CAM_SESSION_PASSWORD_ERR` | int | -336 | 38 |
| `ICH_CAM_STORAGE_FORMAT_ERROR` | int | -325 | 39 |
| `ICH_CAM_TUTK_INIT_FAILED` | int | -338 | 40 |
| `ICH_CAM_VIDEO_SIZE_FORMAT_ERROR` | int | -327 | 41 |
| `ICH_CAM_VIDEO_SIZE_GET_FAILED` | int | -316 | 42 |
| `ICH_CAM_VIDEO_SIZE_NOT_SUPPORTED` | int | -315 | 43 |
| `ICH_CAM_VIDEO_SIZE_SET_FAILED` | int | -317 | 44 |
| `ICH_CAM_WAIT_TIME_OUT` | int | -339 | 45 |
| `ICH_CAM_WB_GET_FAILED` | int | -307 | 46 |
| `ICH_CAM_WB_NOT_SUPPORTED` | int | -306 | 47 |
| `ICH_CAM_WB_SET_FAILED` | int | -308 | 48 |
| `ICH_DEVICE_BUSY` | int | -1 | 49 |
| `ICH_DEVICE_ERROR` | int | -2 | 50 |
| `ICH_ERROR_ACCESS` | int | -22 | 51 |
| `ICH_ERROR_BUSY` | int | -25 | 52 |
| `ICH_ERROR_INTERRUPTED` | int | -29 | 53 |
| `ICH_ERROR_INVALID_DEVICE` | int | -30 | 54 |
| `ICH_ERROR_INVALID_MODE` | int | -31 | 55 |
| `ICH_ERROR_IO` | int | -21 | 56 |
| `ICH_ERROR_NO_DEVICE` | int | -23 | 58 |
| `ICH_ERROR_NOT_FOUND` | int | -24 | 57 |
| `ICH_ERROR_OVERFLOW` | int | -27 | 59 |
| `ICH_ERROR_PIPE` | int | -28 | 60 |
| `ICH_ERROR_TIMEOUT` | int | -26 | 61 |
| `ICH_FILE_NOT_FOUND` | int | -9 | 62 |
| `ICH_FORMAT_NOT_SPECIFIED` | int | -217 | 63 |
| `ICH_FORMAT_NOT_SUPPORTED` | int | -216 | 64 |
| `ICH_INVALID_ARGUMENT` | int | -12 | 65 |
| `ICH_INVALID_SESSION` | int | -11 | 66 |
| `ICH_JNI_EXP` | int | -41 | 67 |
| `ICH_LISTENER_EXISTS` | int | -60 | 68 |
| `ICH_LISTENER_NOT_EXISTS` | int | -61 | 69 |
| `ICH_MUXER_ALREADY_STARTED` | int | -110 | 70 |
| `ICH_MUXER_NOT_STARTED` | int | -112 | 71 |
| `ICH_MUXER_START_FAILED` | int | -111 | 72 |
| `ICH_MUXER_WAITING_KEY_FRAME` | int | -113 | 73 |
| `ICH_NO_USB_ENDPOINT` | int | -43 | 77 |
| `ICH_NO_USB_FRAME_INFO` | int | -44 | 78 |
| `ICH_NO_USB_INTERFACE` | int | -42 | 79 |
| `ICH_NO_USB_STREAM` | int | -45 | 80 |
| `ICH_NOT_IMPLEMENTED` | int | -4 | 74 |
| `ICH_NOT_INIT` | int | -220 | 75 |
| `ICH_NOT_SUPPORTED` | int | -3 | 76 |
| `ICH_OPEN_FAIL` | int | -120 | 81 |
| `ICH_OUT_OF_MEMORY` | int | -8 | 82 |
| `ICH_PATH_NOT_FOUND` | int | -10 | 83 |
| `ICH_PAUSE_FAILED` | int | -72 | 84 |
| `ICH_PB_CACHING` | int | -82 | 85 |
| `ICH_PB_MEM_FULL` | int | -81 | 86 |
| `ICH_PB_PLAY_END` | int | -83 | 87 |
| `ICH_PB_STREAM_PAUSED` | int | -84 | 88 |
| `ICH_PERMISSION_DENIED` | int | -5 | 89 |
| `ICH_PICTURE_NOT_SPECIFIED` | int | -218 | 90 |
| `ICH_PTP_INIT_FAILED` | int | -101 | 91 |
| `ICH_PUBLISH_ALREADY_START` | int | -103 | 92 |
| `ICH_PUBLISH_ALREADY_STOP` | int | -104 | 93 |
| `ICH_RENDER_ALREADY_INIT` | int | -211 | 94 |
| `ICH_RENDER_ALREADY_STARTED` | int | -213 | 95 |
| `ICH_RENDER_NOT_INIT` | int | -210 | 96 |
| `ICH_RENDER_NOT_STARTED` | int | -212 | 97 |
| `ICH_RESOURCE_NOT_READY` | int | -202 | 98 |
| `ICH_RESUME_FAILED` | int | -73 | 99 |
| `ICH_SEEK_FAILED` | int | -71 | 100 |
| `ICH_SESSION_EXISTS` | int | -203 | 101 |
| `ICH_SESSION_NOT_EXISTS` | int | -204 | 102 |
| `ICH_SESSION_PASSWORD_ERR` | int | -100 | 103 |
| `ICH_SOCKET_ERROR` | int | -13 | 104 |
| `ICH_SPHERE_TYPE_NOT_SUPPORTED` | int | -219 | 105 |
| `ICH_STREAM_ALREADY_STARTED` | int | -206 | 106 |
| `ICH_STREAM_NOT_RUNNING` | int | -92 | 107 |
| `ICH_STREAM_NOT_SUPPORT` | int | -93 | 108 |
| `ICH_STREAM_PLAYING_ENDED` | int | -205 | 109 |
| `ICH_SURFACE_ALREADY_SET` | int | -215 | 110 |
| `ICH_SURFACE_NOT_SET` | int | -214 | 111 |
| `ICH_TRANSPORT_ERROR` | int | -207 | 112 |
| `ICH_TRY_AGAIN` | int | -6 | 113 |
| `ICH_UNKNOWN_ERROR` | int | -255 | 114 |
| `ICH_VIDEO_STREAM_CLOSED` | int | -90 | 115 |
| `ICH_WAIT_TIME_OUT` | int | -102 | 116 |
| `ICH_WIFI_DISCONNECTED` | int | -14 | 117 |

### `com.icatchtek.control.core.jni.util.ExceptionMsg`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_ALREADY_INIT_MSG` | String | "already init" | 5 |
| `ICH_AUDIO_STREAM_CLOSED_MSG` | String | "audio stream closed" | 6 |
| `ICH_BUF_TOO_SMALL_MSG` | String | "buffer too small" | 7 |
| `ICH_CALLBACK_EXISTS_MSG` | String | "call back exception" | 8 |
| `ICH_DEVICE_BUSY_MSG` | String | "device busy" | 9 |
| `ICH_DEVICE_ERROR_MSG` | String | "device error" | 10 |
| `ICH_ERROR_ACCESS_MSG` | String | "access denied" | 11 |
| `ICH_ERROR_BUSY_MSG` | String | "device or resource busy" | 12 |
| `ICH_ERROR_INTERRUPTED_MSG` | String | "operation interrupted" | 13 |
| `ICH_ERROR_INVALID_DEVICE_MSG` | String | "invalid device" | 14 |
| `ICH_ERROR_INVALID_MODE_MSG` | String | "invalid mode" | 15 |
| `ICH_ERROR_IO_MSG` | String | "io failed" | 16 |
| `ICH_ERROR_NO_DEVICE_MSG` | String | "no such device" | 18 |
| `ICH_ERROR_NOT_FOUND_MSG` | String | "device not found" | 17 |
| `ICH_ERROR_OVERFLOW_MSG` | String | "memory or resource overflow" | 19 |
| `ICH_ERROR_PIPE_MSG` | String | "pipe error" | 20 |
| `ICH_ERROR_TIMEOUT_MSG` | String | "operation timeout" | 21 |
| `ICH_FILE_NOT_FOUND_MSG` | String | "file not found" | 22 |
| `ICH_FORMAT_NOT_SPECIFIED_MSG` | String | "format not specified" | 23 |
| `ICH_FORMAT_NOT_SUPPORTED_MSG` | String | "format not supported" | 24 |
| `ICH_INVALID_ARGUMENT_MSG` | String | "invalid argument" | 25 |
| `ICH_INVALID_SESSION_MSG` | String | "invalid session" | 26 |
| `ICH_JNI_EXP_MSG` | String | "native (java) operation failed" | 27 |
| `ICH_LISTENER_EXISTS_MSG` | String | "listener exists" | 28 |
| `ICH_LISTENER_NOT_EXISTS_MSG` | String | "listener not exists" | 29 |
| `ICH_MUXER_ALREADY_STARTED_MSG` | String | "muxer already started" | 30 |
| `ICH_MUXER_NOT_STARTED_MSG` | String | "muxer not started" | 31 |
| `ICH_MUXER_START_FAILED_MSG` | String | "muxer start failed" | 32 |
| `ICH_MUXER_WAITING_KEY_FRAME_MSG` | String | "muxer waiting key frame" | 33 |
| `ICH_NO_USB_ENDPOINT_MSG` | String | "no such usb endpoint" | 37 |
| `ICH_NO_USB_FRAME_INFO_MSG` | String | "usb frame info error" | 38 |
| `ICH_NO_USB_INTERFACE_MSG` | String | "no such usb interface" | 39 |
| `ICH_NO_USB_STREAM_MSG` | String | "usb stream error" | 40 |
| `ICH_NOT_IMPLEMENTED_MSG` | String | "not implemented" | 34 |
| `ICH_NOT_INIT_MSG` | String | "not init" | 35 |
| `ICH_NOT_SUPPORTED_MSG` | String | "not supported" | 36 |
| `ICH_OPEN_FAIL_MSG` | String | "open failed" | 41 |
| `ICH_OUT_OF_MEMORY_MSG` | String | "out of memory" | 42 |
| `ICH_PATH_NOT_FOUND_MSG` | String | "path not found" | 43 |
| `ICH_PAUSE_FAILED_MSG` | String | "pause failed" | 44 |
| `ICH_PB_CACHING_MSG` | String | "playback caching" | 45 |
| `ICH_PB_MEM_FULL_MSG` | String | "playback memory full" | 46 |
| `ICH_PB_PLAY_END_MSG` | String | "playback ended" | 47 |
| `ICH_PB_STREAM_PAUSED_MSG` | String | "playback stream paused" | 48 |
| `ICH_PERMISSION_DENIED_MSG` | String | "permission denied" | 49 |
| `ICH_PICTURE_NOT_SPECIFIED_MSG` | String | "picture not specified" | 50 |
| `ICH_PTP_INIT_FAILED_MSG` | String | "setup ptp connection failed" | 51 |
| `ICH_PUBLISH_ALREADY_START_MSG` | String | "publish already started" | 52 |
| `ICH_PUBLISH_ALREADY_STOP_MSG` | String | "publish already stopped" | 53 |
| `ICH_RENDER_ALREADY_INIT_MSG` | String | "render already init" | 54 |
| `ICH_RENDER_ALREADY_STARTED_MSG` | String | "render already started" | 55 |
| `ICH_RENDER_NOT_INIT_MSG` | String | "render not init" | 56 |
| `ICH_RENDER_NOT_STARTED_MSG` | String | "render not started" | 57 |
| `ICH_RESOURCE_NOT_READY_MSG` | String | "resource not ready" | 58 |
| `ICH_RESUME_FAILED_MSG` | String | "resume failed" | 59 |
| `ICH_SEEK_FAILED_MSG` | String | "seek failed" | 60 |
| `ICH_SESSION_EXISTS_MSG_MSG` | String | "session exists" | 61 |
| `ICH_SESSION_NOT_EXISTS_MSG` | String | "session not exists" | 62 |
| `ICH_SESSION_PASSWORD_ERR_MSG` | String | "session's password not correct" | 63 |
| `ICH_SOCKET_ERROR_MSG` | String | "socket error" | 64 |
| `ICH_SPHERE_TYPE_NOT_SUPPORTED_MSG` | String | "sphere type not supported" | 65 |
| `ICH_STREAM_ALREADY_STARTED_MSG` | String | "stream already started" | 66 |
| `ICH_STREAM_NOT_RUNNING_MSG` | String | "stream not running" | 67 |
| `ICH_STREAM_NOT_SUPPORT_MSG` | String | "stream not supported" | 68 |
| `ICH_STREAM_PLAYING_ENDED_MSG` | String | "stream playing ended" | 69 |
| `ICH_SURFACE_ALREADY_SET_MSG` | String | "surface already set" | 70 |
| `ICH_SURFACE_NOT_SET_MSG` | String | "surface not set" | 71 |
| `ICH_TRANSPORT_ERROR_MSG` | String | "transport error" | 72 |
| `ICH_TRY_AGAIN_MSG` | String | "try again" | 73 |
| `ICH_UNKNOWN_ERROR_MSG` | String | "unknown error" | 74 |
| `ICH_VIDEO_STREAM_CLOSED_MSG` | String | "video stream closed" | 75 |
| `ICH_WAIT_TIME_OUT_MSG` | String | "wait timeout" | 76 |
| `ICH_WIFI_DISCONNECTED_MSG` | String | "connection disconnected(wifi)" | 77 |

### `com.icatchtek.control.core.jni.util.NativeLibraryLoader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `intelArch` | String | "x86" | 6 |
| `neonArmArchArray` | String[] | {"armv7a", "armeabi-v7a"} | 7 |

### `com.icatchtek.control.customer.exception.IchCameraModeException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.control.customer.exception.IchCaptureImageException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.control.customer.exception.IchDevicePropException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.control.customer.exception.IchInvalidPasswdException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.control.customer.exception.IchNoSDCardException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.control.customer.exception.IchNoSuchPathException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.control.customer.exception.IchStorageFormatException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.control.customer.type.ICatchCamBurstNumber`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_BURST_NUMBER_10` | int | 4 | 5 |
| `ICH_CAM_BURST_NUMBER_15` | int | 6 | 6 |
| `ICH_CAM_BURST_NUMBER_3` | int | 2 | 7 |
| `ICH_CAM_BURST_NUMBER_30` | int | 7 | 8 |
| `ICH_CAM_BURST_NUMBER_5` | int | 3 | 9 |
| `ICH_CAM_BURST_NUMBER_7` | int | 5 | 10 |
| `ICH_CAM_BURST_NUMBER_HS` | int | 0 | 11 |
| `ICH_CAM_BURST_NUMBER_OFF` | int | 1 | 12 |
| `ICH_CAM_BURST_NUMBER_UNDEFINED` | int | 65535 | 13 |

### `com.icatchtek.control.customer.type.ICatchCamCaptureDelay`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_CAP_DELAY_10S` | int | 10000 | 5 |
| `ICH_CAM_CAP_DELAY_2S` | int | 2000 | 6 |
| `ICH_CAM_CAP_DELAY_NO` | int | 0 | 7 |
| `ICH_CAM_CAP_DELAY_UNDEFINED` | int | 65535 | 8 |

### `com.icatchtek.control.customer.type.ICatchCamDateStamp`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_DATE_STAMP_DATE` | int | 2 | 5 |
| `ICH_CAM_DATE_STAMP_DATE_TIME` | int | 3 | 6 |
| `ICH_CAM_DATE_STAMP_OFF` | int | 1 | 7 |
| `ICH_CAM_DATE_STAMP_UNDEFINED` | int | 255 | 8 |

### `com.icatchtek.control.customer.type.ICatchCamEventID`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICATCH_EVENT_DEVICE_SCAN_ADD` | int | 85 | 5 |
| `ICH_CAM_EVENT_BATTERY_LEVEL_CHANGED` | int | 36 | 6 |
| `ICH_CAM_EVENT_BURST_NUMBER_PROP_CHANGED` | int | 55 | 7 |
| `ICH_CAM_EVENT_CAPTURE_COMPLETE` | int | 35 | 8 |
| `ICH_CAM_EVENT_CAPTURE_DELAY_PROP_CHANGED` | int | 51 | 9 |
| `ICH_CAM_EVENT_CAPTURE_START` | int | 82 | 10 |
| `ICH_CAM_EVENT_CONNECTION_DISCONNECTED` | int | 74 | 11 |
| `ICH_CAM_EVENT_CONNECTION_INITIALIZE_FAILED` | int | 76 | 12 |
| `ICH_CAM_EVENT_CONNECTION_INITIALIZE_SUCCEED` | int | 75 | 13 |
| `ICH_CAM_EVENT_DEVICE_INFO_CHANGED` | int | 49 | 14 |
| `ICH_CAM_EVENT_FILE_ADDED` | int | 1 | 15 |
| `ICH_CAM_EVENT_FILE_DOWNLOAD` | int | 103 | 16 |
| `ICH_CAM_EVENT_FILE_INFO_CHANGED` | int | 3 | 17 |
| `ICH_CAM_EVENT_FILE_REMOVED` | int | 2 | 18 |
| `ICH_CAM_EVENT_FW_UPDATE_CHECK` | int | 96 | 19 |
| `ICH_CAM_EVENT_FW_UPDATE_CHKSUMERR` | int | 99 | 20 |
| `ICH_CAM_EVENT_FW_UPDATE_COMPLETED` | int | 97 | 21 |
| `ICH_CAM_EVENT_FW_UPDATE_NG` | int | 100 | 22 |
| `ICH_CAM_EVENT_FW_UPDATE_POWEROFF` | int | 98 | 23 |
| `ICH_CAM_EVENT_IMAGE_SIZE_PROP_CHANGED` | int | 52 | 24 |
| `ICH_CAM_EVENT_INSUFFICIENT_DISK_SPACE` | int | 133 | 25 |
| `ICH_CAM_EVENT_LIGHT_FREQUENCY_PROP_CHANGED` | int | 54 | 26 |
| `ICH_CAM_EVENT_SD_CARD_ERR` | int | 130 | 32 |
| `ICH_CAM_EVENT_SD_CARD_IN` | int | 129 | 33 |
| `ICH_CAM_EVENT_SD_CARD_LOCKED` | int | 131 | 34 |
| `ICH_CAM_EVENT_SD_CARD_MEMORY_FULL` | int | 132 | 35 |
| `ICH_CAM_EVENT_SD_CARD_OUT` | int | 128 | 36 |
| `ICH_CAM_EVENT_SD_CARD_SPEED_TOO_SLOW` | int | 134 | 37 |
| `ICH_CAM_EVENT_SDCARD_ERROR` | int | 18 | 27 |
| `ICH_CAM_EVENT_SDCARD_FULL` | int | 17 | 28 |
| `ICH_CAM_EVENT_SDCARD_IN` | int | 20 | 29 |
| `ICH_CAM_EVENT_SDCARD_INFO_CHANGED` | int | 21 | 30 |
| `ICH_CAM_EVENT_SDCARD_REMOVED` | int | 19 | 31 |
| `ICH_CAM_EVENT_TIMELAPSE_STOP` | int | 81 | 38 |
| `ICH_CAM_EVENT_UNDEFINED` | int | 255 | 39 |
| `ICH_CAM_EVENT_VIDEO_OFF` | int | 34 | 40 |
| `ICH_CAM_EVENT_VIDEO_ON` | int | 33 | 41 |
| `ICH_CAM_EVENT_VIDEO_SIZE_PROP_CHANGED` | int | 53 | 42 |
| `ICH_CAM_EVENT_VIDEO_THUMB_DONE` | int | 105 | 43 |
| `ICH_CAM_EVENT_VIDEO_THUMB_READY` | int | 104 | 44 |
| `ICH_CAM_EVENT_VIDEO_TRIM_DONE` | int | 106 | 45 |
| `ICH_CAM_EVENT_VIDREC_TIME_CHANGE` | int | 101 | 46 |
| `ICH_CAM_EVENT_WHITE_BALANCE_PROP_CHANGED` | int | 50 | 47 |

### `com.icatchtek.control.customer.type.ICatchCamFeatureID`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_APP_DEFAULT_TO_PLAYBACK` | int | 1 | 5 |
| `ICH_CAM_NEW_PAGINATION_GET_FILE` | int | 2 | 6 |
| `ICH_CAM_TIMELAPSE_USING_MS_VALUE` | int | 4 | 7 |

### `com.icatchtek.control.customer.type.ICatchCamImageSize`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_IMAGE_SIZE_10M` | int | 10 | 5 |
| `ICH_CAM_IMAGE_SIZE_2M` | int | 2 | 6 |
| `ICH_CAM_IMAGE_SIZE_3M` | int | 3 | 7 |
| `ICH_CAM_IMAGE_SIZE_5M` | int | 5 | 8 |
| `ICH_CAM_IMAGE_SIZE_6M` | int | 6 | 9 |
| `ICH_CAM_IMAGE_SIZE_8M` | int | 8 | 10 |
| `ICH_CAM_IMAGE_SIZE_UNDEFINED` | int | 255 | 11 |
| `ICH_CAM_IMAGE_SIZE_VGA` | int | 0 | 12 |

### `com.icatchtek.control.customer.type.ICatchCamLightFrequency`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_LIGHT_FREQUENCY_50HZ` | int | 0 | 5 |
| `ICH_CAM_LIGHT_FREQUENCY_60HZ` | int | 1 | 6 |
| `ICH_CAM_LIGHT_FREQUENCY_AUTO` | int | 2 | 7 |
| `ICH_CAM_LIGHT_FREQUENCY_UNDEFINED` | int | 255 | 8 |

### `com.icatchtek.control.customer.type.ICatchCamListFileFilter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_COMPOSITE_FILE_TAKEN_BY_ALL_SENSORS` | int | 3 | 5 |
| `ICH_OFC_FILE_TYPE_ALL_MEDIA` | int | 255 | 6 |
| `ICH_OFC_TYPE_EMERGENCY_IMAGE` | int | 34 | 7 |
| `ICH_OFC_TYPE_EMERGENCY_MEDIA` | int | 35 | 8 |
| `ICH_OFC_TYPE_EMERGENCY_VIDEO` | int | 33 | 9 |
| `ICH_OFC_TYPE_IMAGE` | int | 18 | 10 |
| `ICH_OFC_TYPE_MEDIA` | int | 19 | 11 |
| `ICH_OFC_TYPE_VIDEO` | int | 17 | 12 |
| `ICH_SORT_TYPE_ASCENDING` | int | 2 | 13 |
| `ICH_SORT_TYPE_DESCENDING` | int | 1 | 14 |
| `ICH_TAKEN_BY_ALL_SENSORS` | int | 0 | 15 |
| `ICH_TAKEN_BY_BACK_SENSOR` | int | 2 | 16 |
| `ICH_TAKEN_BY_FRONT_SENSOR` | int | 1 | 17 |

### `com.icatchtek.control.customer.type.ICatchCamLogLevel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_LOG_LEVEL_DEBUG` | int | 0 | 5 |
| `ICH_CAM_LOG_LEVEL_ERROR` | int | 5 | 6 |
| `ICH_CAM_LOG_LEVEL_INFO` | int | 1 | 7 |
| `ICH_CAM_LOG_LEVEL_WARN` | int | 3 | 8 |

### `com.icatchtek.control.customer.type.ICatchCamLogType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_LOG_TYPE_APP` | int | 2 | 5 |
| `ICH_CAM_LOG_TYPE_COMMON` | int | 0 | 6 |
| `ICH_CAM_LOG_TYPE_THIRDLIB` | int | 1 | 7 |

### `com.icatchtek.control.customer.type.ICatchCamMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_MODE_CAMERA` | int | 3 | 5 |
| `ICH_CAM_MODE_IDLE` | int | 4 | 6 |
| `ICH_CAM_MODE_SHARED` | int | 2 | 7 |
| `ICH_CAM_MODE_TIMELAPSE` | int | 43 | 8 |
| `ICH_CAM_MODE_TIMELAPSE_STILL` | int | 7 | 9 |
| `ICH_CAM_MODE_TIMELAPSE_STILL_OFF` | int | 9 | 10 |
| `ICH_CAM_MODE_TIMELAPSE_VIDEO` | int | 8 | 11 |
| `ICH_CAM_MODE_TIMELAPSE_VIDEO_OFF` | int | 10 | 12 |
| `ICH_CAM_MODE_UNDEFINED` | int | 65471 | 13 |
| `ICH_CAM_MODE_VIDEO` | int | 42 | 14 |
| `ICH_CAM_MODE_VIDEO_OFF` | int | 1 | 15 |
| `ICH_CAM_MODE_VIDEO_ON` | int | 17 | 16 |

### `com.icatchtek.control.customer.type.ICatchCamPhotoExif`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ORIENTATION_FLIP_HORIZONTAL` | int | 2 | 15 |
| `ORIENTATION_FLIP_VERTICAL` | int | 4 | 16 |
| `ORIENTATION_NORMAL` | int | 1 | 17 |
| `ORIENTATION_ROTATE_180` | int | 3 | 18 |
| `ORIENTATION_ROTATE_270` | int | 8 | 19 |
| `ORIENTATION_ROTATE_90` | int | 6 | 20 |
| `ORIENTATION_TRANSPOSE` | int | 5 | 21 |
| `ORIENTATION_TRANSVERSE` | int | 7 | 22 |
| `ORIENTATION_UNDEFINED` | int | 0 | 23 |
| `TAG_APERTURE` | String | "FNumber" | 24 |
| `TAG_DATETIME` | String | "DateTime" | 25 |
| `TAG_EXPOSURE_TIME` | String | "ExposureTime" | 26 |
| `TAG_FLASH` | String | "Flash" | 27 |
| `TAG_FOCAL_LENGTH` | String | "FocalLength" | 28 |
| `TAG_GPS_ALTITUDE` | String | "GPSAltitude" | 29 |
| `TAG_GPS_ALTITUDE_REF` | String | "GPSAltitudeRef" | 30 |
| `TAG_GPS_DATESTAMP` | String | "GPSDateStamp" | 31 |
| `TAG_GPS_LATITUDE` | String | "GPSLatitude" | 32 |
| `TAG_GPS_LATITUDE_REF` | String | "GPSLatitudeRef" | 33 |
| `TAG_GPS_LONGITUDE` | String | "GPSLongitude" | 34 |
| `TAG_GPS_LONGITUDE_REF` | String | "GPSLongitudeRef" | 35 |
| `TAG_GPS_PROCESSING_METHOD` | String | "GPSProcessingMethod" | 36 |
| `TAG_GPS_TIMESTAMP` | String | "GPSTimeStamp" | 37 |
| `TAG_IMAGE_LENGTH` | String | "ImageLength" | 38 |
| `TAG_IMAGE_WIDTH` | String | "ImageWidth" | 39 |
| `TAG_ISO` | String | "ISOSpeedRatings" | 40 |
| `TAG_MAKE` | String | "Make" | 41 |
| `TAG_MODEL` | String | "Model" | 42 |
| `TAG_ORIENTATION` | String | "Orientation" | 43 |
| `TAG_WHITE_BALANCE` | String | "WhiteBalance" | 44 |
| `WHITEBALANCE_AUTO` | int | 0 | 45 |
| `WHITEBALANCE_MANUAL` | int | 1 | 46 |

### `com.icatchtek.control.customer.type.ICatchCamPreviewMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_STILL_PREVIEW_MODE` | int | 1 | 5 |
| `ICH_CAM_TIMELAPSE_STILL_PREVIEW_MODE` | int | 3 | 6 |
| `ICH_CAM_TIMELAPSE_VIDEO_PREVIEW_MODE` | int | 4 | 7 |
| `ICH_CAM_VIDEO_PREVIEW_MODE` | int | 2 | 8 |

### `com.icatchtek.control.customer.type.ICatchCamProperty`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_CAP_BATTERY_LEVEL` | int | 20481 | 5 |
| `ICH_CAM_CAP_BURST_NUMBER` | int | 20504 | 6 |
| `ICH_CAM_CAP_CAPTURE_DELAY` | int | 20498 | 7 |
| `ICH_CAM_CAP_DATE_STAMP` | int | 54791 | 8 |
| `ICH_CAM_CAP_DIGITAL_ZOOM` | int | 20502 | 9 |
| `ICH_CAM_CAP_FW_VERSION` | int | 20511 | 10 |
| `ICH_CAM_CAP_GET_CAMERA_CAPABILITIES` | int | 55084 | 11 |
| `ICH_CAM_CAP_GET_NUMBER_OF_SENSORS` | int | 55083 | 12 |
| `ICH_CAM_CAP_IMAGE_SIZE` | int | 20483 | 13 |
| `ICH_CAM_CAP_LIGHT_FREQUENCY` | int | 54790 | 14 |
| `ICH_CAM_CAP_MOVIE_REC` | int | 58884 | 15 |
| `ICH_CAM_CAP_PRODUCT_NAME` | int | 20510 | 16 |
| `ICH_CAM_CAP_SLOW_MOTION` | int | 54805 | 17 |
| `ICH_CAM_CAP_TIMELAPSE_STILL` | int | 20507 | 18 |
| `ICH_CAM_CAP_TIMELAPSE_VIDEO` | int | 54801 | 19 |
| `ICH_CAM_CAP_UNDEFINED` | int | 65535 | 20 |
| `ICH_CAM_CAP_UPSIDE_DOWN` | int | 54804 | 21 |
| `ICH_CAM_CAP_VIDEO_SIZE` | int | 54789 | 22 |
| `ICH_CAM_CAP_WHITE_BALANCE` | int | 20485 | 23 |

### `com.icatchtek.control.customer.type.ICatchCamTimeLapseDuration`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_TIMELPS_DURATION_10M` | int | 3 | 5 |
| `ICH_CAM_TIMELPS_DURATION_15M` | int | 4 | 6 |
| `ICH_CAM_TIMELPS_DURATION_20M` | int | 5 | 7 |
| `ICH_CAM_TIMELPS_DURATION_30M` | int | 6 | 8 |
| `ICH_CAM_TIMELPS_DURATION_5M` | int | 2 | 9 |
| `ICH_CAM_TIMELPS_DURATION_60M` | int | 7 | 10 |
| `ICH_CAM_TIMELPS_DURATION_OFF` | int | 1 | 11 |
| `ICH_CAM_TIMELPS_DURATION_UNLMT` | int | 65535 | 12 |

### `com.icatchtek.control.customer.type.ICatchCamTimeLapseInterval`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_TIMELPS_INTERVAL_10M` | int | 9 | 5 |
| `ICH_CAM_TIMELPS_INTERVAL_10S` | int | 4 | 6 |
| `ICH_CAM_TIMELPS_INTERVAL_1HR` | int | 11 | 7 |
| `ICH_CAM_TIMELPS_INTERVAL_1M` | int | 7 | 8 |
| `ICH_CAM_TIMELPS_INTERVAL_1S` | int | 2 | 9 |
| `ICH_CAM_TIMELPS_INTERVAL_20S` | int | 5 | 10 |
| `ICH_CAM_TIMELPS_INTERVAL_30M` | int | 10 | 11 |
| `ICH_CAM_TIMELPS_INTERVAL_30S` | int | 6 | 12 |
| `ICH_CAM_TIMELPS_INTERVAL_5M` | int | 8 | 13 |
| `ICH_CAM_TIMELPS_INTERVAL_5S` | int | 3 | 14 |
| `ICH_CAM_TIMELPS_INTERVAL_OFF` | int | 1 | 15 |

### `com.icatchtek.control.customer.type.ICatchCamVideoSize`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_VIDEO_SIZE_1080P_WITH_30FPS` | int | 3 | 5 |
| `ICH_CAM_VIDEO_SIZE_1080P_WITH_60FPS` | int | 4 | 6 |
| `ICH_CAM_VIDEO_SIZE_1280P_30FPS` | int | 21 | 7 |
| `ICH_CAM_VIDEO_SIZE_1280P_60FPS` | int | 22 | 8 |
| `ICH_CAM_VIDEO_SIZE_1440P_30FPS` | int | 6 | 9 |
| `ICH_CAM_VIDEO_SIZE_2K7_1_25FPS` | int | 19 | 10 |
| `ICH_CAM_VIDEO_SIZE_2K7_2_25FPS` | int | 20 | 11 |
| `ICH_CAM_VIDEO_SIZE_4K_15FPS` | int | 17 | 12 |
| `ICH_CAM_VIDEO_SIZE_4K_30FPS` | int | 18 | 13 |
| `ICH_CAM_VIDEO_SIZE_640_360_240FPS` | int | 16 | 15 |
| `ICH_CAM_VIDEO_SIZE_640P_15FPS` | int | 25 | 14 |
| `ICH_CAM_VIDEO_SIZE_720P_120FPS` | int | 5 | 16 |
| `ICH_CAM_VIDEO_SIZE_720P_WITH_30FPS` | int | 1 | 17 |
| `ICH_CAM_VIDEO_SIZE_720P_WITH_60FPS` | int | 2 | 18 |
| `ICH_CAM_VIDEO_SIZE_960P_1_30FPS` | int | 23 | 19 |
| `ICH_CAM_VIDEO_SIZE_960P_2_30FPS` | int | 24 | 20 |
| `ICH_CAM_VIDEO_SIZE_960P_60FPS` | int | 7 | 21 |
| `ICH_CAM_VIDEO_SIZE_FULL_30FPS` | int | 10 | 22 |
| `ICH_CAM_VIDEO_SIZE_HD_15FPS` | int | 26 | 23 |
| `ICH_CAM_VIDEO_SIZE_QVGA_240FPS` | int | 9 | 24 |
| `ICH_CAM_VIDEO_SIZE_UNDEFINED` | int | 0 | 25 |
| `ICH_CAM_VIDEO_SIZE_UNDEFINED1` | int | 255 | 26 |
| `ICH_CAM_VIDEO_SIZE_VGA_120FPS` | int | 8 | 27 |

### `com.icatchtek.control.customer.type.ICatchCamWhiteBalance`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_WB_AUTO` | int | 1 | 5 |
| `ICH_CAM_WB_CLOUDY` | int | 3 | 6 |
| `ICH_CAM_WB_DAYLIGHT` | int | 2 | 7 |
| `ICH_CAM_WB_FLUORESCENT` | int | 4 | 8 |
| `ICH_CAM_WB_TUNGSTEN` | int | 5 | 9 |
| `ICH_CAM_WB_UNDEFINED` | int | 65471 | 10 |

### `com.icatchtek.control.customer.type.ICatchCamWifiMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CAM_WIFI_MODE_AP` | int | 1 | 5 |
| `ICH_CAM_WIFI_MODE_ETHERNET` | int | 3 | 6 |
| `ICH_CAM_WIFI_MODE_STATION` | int | 2 | 7 |
| `ICH_CAM_WIFI_MODE_UNDEFINED` | int | 65535 | 8 |

### `com.icatchtek.pancam.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "debug" | 7 |
| `LIBRARY_PACKAGE_NAME` | String | "com.icatchtek.pancam" | 9 |
| `VERSION_CODE` | int | 1 | 10 |
| `VERSION_NAME` | String | "1.0" | 11 |

### `com.icatchtek.pancam.core.feature.type.VrGLStreamSettings`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PAN_MINE_CODE_H264` | String | "video/avc" | 10 |
| `PAN_MINE_CODE_HEVC` | String | "video/hevc" | 11 |
| `PAN_MINE_CODE_I420` | String | "video/raw" | 12 |
| `PAN_MINE_CODE_JPEG` | String | "video/jpeg" | 13 |
| `PAN_MINE_CODE_PCM` | String | "audio/raw" | 14 |
| `PAN_MINE_CODE_RGBA` | String | "video/raw" | 15 |

### `com.icatchtek.pancam.core.jni.extractor.ExceptionErr`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_ALREADY_INIT` | int | -221 | 5 |
| `ICH_AUDIO_STREAM_CLOSED` | int | -91 | 6 |
| `ICH_BUF_TOO_SMALL` | int | -7 | 7 |
| `ICH_CALLBACK_EXISTS` | int | -40 | 8 |
| `ICH_DEVICE_BUSY` | int | -1 | 9 |
| `ICH_DEVICE_ERROR` | int | -2 | 10 |
| `ICH_ERROR_ACCESS` | int | -22 | 11 |
| `ICH_ERROR_BUSY` | int | -25 | 12 |
| `ICH_ERROR_INTERRUPTED` | int | -29 | 13 |
| `ICH_ERROR_INVALID_DEVICE` | int | -30 | 14 |
| `ICH_ERROR_INVALID_MODE` | int | -31 | 15 |
| `ICH_ERROR_IO` | int | -21 | 16 |
| `ICH_ERROR_NO_DEVICE` | int | -23 | 18 |
| `ICH_ERROR_NOT_FOUND` | int | -24 | 17 |
| `ICH_ERROR_OVERFLOW` | int | -27 | 19 |
| `ICH_ERROR_PIPE` | int | -28 | 20 |
| `ICH_ERROR_TIMEOUT` | int | -26 | 21 |
| `ICH_FILE_NOT_FOUND` | int | -9 | 22 |
| `ICH_FORMAT_NOT_SPECIFIED` | int | -217 | 23 |
| `ICH_FORMAT_NOT_SUPPORTED` | int | -216 | 24 |
| `ICH_INVALID_ARGUMENT` | int | -12 | 25 |
| `ICH_INVALID_SESSION` | int | -11 | 26 |
| `ICH_JNI_EXP` | int | -41 | 27 |
| `ICH_LISTENER_EXISTS` | int | -60 | 28 |
| `ICH_LISTENER_NOT_EXISTS` | int | -61 | 29 |
| `ICH_MUXER_ALREADY_STARTED` | int | -110 | 30 |
| `ICH_MUXER_NOT_STARTED` | int | -112 | 31 |
| `ICH_MUXER_START_FAILED` | int | -111 | 32 |
| `ICH_MUXER_WAITING_KEY_FRAME` | int | -113 | 33 |
| `ICH_NO_USB_ENDPOINT` | int | -43 | 37 |
| `ICH_NO_USB_FRAME_INFO` | int | -44 | 38 |
| `ICH_NO_USB_INTERFACE` | int | -42 | 39 |
| `ICH_NO_USB_STREAM` | int | -45 | 40 |
| `ICH_NOT_IMPLEMENTED` | int | -4 | 34 |
| `ICH_NOT_INIT` | int | -220 | 35 |
| `ICH_NOT_SUPPORTED` | int | -3 | 36 |
| `ICH_OPEN_FAIL` | int | -120 | 41 |
| `ICH_OUT_OF_MEMORY` | int | -8 | 42 |
| `ICH_PATH_NOT_FOUND` | int | -10 | 43 |
| `ICH_PAUSE_FAILED` | int | -72 | 44 |
| `ICH_PB_CACHING` | int | -82 | 45 |
| `ICH_PB_MEM_FULL` | int | -81 | 46 |
| `ICH_PB_PLAY_END` | int | -83 | 47 |
| `ICH_PB_STREAM_PAUSED` | int | -84 | 48 |
| `ICH_PERMISSION_DENIED` | int | -5 | 49 |
| `ICH_PICTURE_NOT_SPECIFIED` | int | -218 | 50 |
| `ICH_PTP_INIT_FAILED` | int | -101 | 51 |
| `ICH_PUBLISH_ALREADY_START` | int | -103 | 52 |
| `ICH_PUBLISH_ALREADY_STOP` | int | -104 | 53 |
| `ICH_RENDER_ALREADY_INIT` | int | -211 | 54 |
| `ICH_RENDER_ALREADY_STARTED` | int | -213 | 55 |
| `ICH_RENDER_NOT_INIT` | int | -210 | 56 |
| `ICH_RENDER_NOT_STARTED` | int | -212 | 57 |
| `ICH_RESOURCE_NOT_READY` | int | -202 | 58 |
| `ICH_RESUME_FAILED` | int | -73 | 59 |
| `ICH_SEEK_FAILED` | int | -71 | 60 |
| `ICH_SESSION_EXISTS` | int | -203 | 61 |
| `ICH_SESSION_NOT_EXISTS` | int | -204 | 62 |
| `ICH_SESSION_PASSWORD_ERR` | int | -100 | 63 |
| `ICH_SOCKET_ERROR` | int | -13 | 64 |
| `ICH_SPHERE_TYPE_NOT_SUPPORTED` | int | -219 | 65 |
| `ICH_STREAM_ALREADY_STARTED` | int | -206 | 66 |
| `ICH_STREAM_NOT_RUNNING` | int | -92 | 67 |
| `ICH_STREAM_NOT_SUPPORT` | int | -93 | 68 |
| `ICH_STREAM_PLAYING_ENDED` | int | -205 | 69 |
| `ICH_SURFACE_ALREADY_SET` | int | -215 | 70 |
| `ICH_SURFACE_NOT_SET` | int | -214 | 71 |
| `ICH_TRANSPORT_ERROR` | int | -207 | 72 |
| `ICH_TRY_AGAIN` | int | -6 | 73 |
| `ICH_UNKNOWN_ERROR` | int | -255 | 74 |
| `ICH_VIDEO_STREAM_CLOSED` | int | -90 | 75 |
| `ICH_WAIT_TIME_OUT` | int | -102 | 76 |
| `ICH_WIFI_DISCONNECTED` | int | -14 | 77 |

### `com.icatchtek.pancam.core.jni.extractor.ExceptionMsg`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_ALREADY_INIT_MSG` | String | "already init" | 5 |
| `ICH_AUDIO_STREAM_CLOSED_MSG` | String | "audio stream closed" | 6 |
| `ICH_BUF_TOO_SMALL_MSG` | String | "buffer too small" | 7 |
| `ICH_CALLBACK_EXISTS_MSG` | String | "call back exception" | 8 |
| `ICH_DEVICE_BUSY_MSG` | String | "device busy" | 9 |
| `ICH_DEVICE_ERROR_MSG` | String | "device error" | 10 |
| `ICH_ERROR_ACCESS_MSG` | String | "access denied" | 11 |
| `ICH_ERROR_BUSY_MSG` | String | "device or resource busy" | 12 |
| `ICH_ERROR_INTERRUPTED_MSG` | String | "operation interrupted" | 13 |
| `ICH_ERROR_INVALID_DEVICE_MSG` | String | "invalid device" | 14 |
| `ICH_ERROR_INVALID_MODE_MSG` | String | "invalid mode" | 15 |
| `ICH_ERROR_IO_MSG` | String | "io failed" | 16 |
| `ICH_ERROR_NO_DEVICE_MSG` | String | "no such device" | 18 |
| `ICH_ERROR_NOT_FOUND_MSG` | String | "device not found" | 17 |
| `ICH_ERROR_OVERFLOW_MSG` | String | "memory or resource overflow" | 19 |
| `ICH_ERROR_PIPE_MSG` | String | "pipe error" | 20 |
| `ICH_ERROR_TIMEOUT_MSG` | String | "operation timeout" | 21 |
| `ICH_FILE_NOT_FOUND_MSG` | String | "file not found" | 22 |
| `ICH_FORMAT_NOT_SPECIFIED_MSG` | String | "format not specified" | 23 |
| `ICH_FORMAT_NOT_SUPPORTED_MSG` | String | "format not supported" | 24 |
| `ICH_INVALID_ARGUMENT_MSG` | String | "invalid argument" | 25 |
| `ICH_INVALID_SESSION_MSG` | String | "invalid session" | 26 |
| `ICH_JNI_EXP_MSG` | String | "native (java) operation failed" | 27 |
| `ICH_LISTENER_EXISTS_MSG` | String | "listener exists" | 28 |
| `ICH_LISTENER_NOT_EXISTS_MSG` | String | "listener not exists" | 29 |
| `ICH_MUXER_ALREADY_STARTED_MSG` | String | "muxer already started" | 30 |
| `ICH_MUXER_NOT_STARTED_MSG` | String | "muxer not started" | 31 |
| `ICH_MUXER_START_FAILED_MSG` | String | "muxer start failed" | 32 |
| `ICH_MUXER_WAITING_KEY_FRAME_MSG` | String | "muxer waiting key frame" | 33 |
| `ICH_NO_USB_ENDPOINT_MSG` | String | "no such usb endpoint" | 37 |
| `ICH_NO_USB_FRAME_INFO_MSG` | String | "usb frame info error" | 38 |
| `ICH_NO_USB_INTERFACE_MSG` | String | "no such usb interface" | 39 |
| `ICH_NO_USB_STREAM_MSG` | String | "usb stream error" | 40 |
| `ICH_NOT_IMPLEMENTED_MSG` | String | "not implemented" | 34 |
| `ICH_NOT_INIT_MSG` | String | "not init" | 35 |
| `ICH_NOT_SUPPORTED_MSG` | String | "not supported" | 36 |
| `ICH_OPEN_FAIL_MSG` | String | "open failed" | 41 |
| `ICH_OUT_OF_MEMORY_MSG` | String | "out of memory" | 42 |
| `ICH_PATH_NOT_FOUND_MSG` | String | "path not found" | 43 |
| `ICH_PAUSE_FAILED_MSG` | String | "pause failed" | 44 |
| `ICH_PB_CACHING_MSG` | String | "playback caching" | 45 |
| `ICH_PB_MEM_FULL_MSG` | String | "playback memory full" | 46 |
| `ICH_PB_PLAY_END_MSG` | String | "playback ended" | 47 |
| `ICH_PB_STREAM_PAUSED_MSG` | String | "playback stream paused" | 48 |
| `ICH_PERMISSION_DENIED_MSG` | String | "permission denied" | 49 |
| `ICH_PICTURE_NOT_SPECIFIED_MSG` | String | "picture not specified" | 50 |
| `ICH_PTP_INIT_FAILED_MSG` | String | "setup ptp connection failed" | 51 |
| `ICH_PUBLISH_ALREADY_START_MSG` | String | "publish already started" | 52 |
| `ICH_PUBLISH_ALREADY_STOP_MSG` | String | "publish already stopped" | 53 |
| `ICH_RENDER_ALREADY_INIT_MSG` | String | "render already init" | 54 |
| `ICH_RENDER_ALREADY_STARTED_MSG` | String | "render already started" | 55 |
| `ICH_RENDER_NOT_INIT_MSG` | String | "render not init" | 56 |
| `ICH_RENDER_NOT_STARTED_MSG` | String | "render not started" | 57 |
| `ICH_RESOURCE_NOT_READY_MSG` | String | "resource not ready" | 58 |
| `ICH_RESUME_FAILED_MSG` | String | "resume failed" | 59 |
| `ICH_SEEK_FAILED_MSG` | String | "seek failed" | 60 |
| `ICH_SESSION_EXISTS_MSG_MSG` | String | "session exists" | 61 |
| `ICH_SESSION_NOT_EXISTS_MSG` | String | "session not exists" | 62 |
| `ICH_SESSION_PASSWORD_ERR_MSG` | String | "session's password not correct" | 63 |
| `ICH_SOCKET_ERROR_MSG` | String | "socket error" | 64 |
| `ICH_SPHERE_TYPE_NOT_SUPPORTED_MSG` | String | "sphere type not supported" | 65 |
| `ICH_STREAM_ALREADY_STARTED_MSG` | String | "stream already started" | 66 |
| `ICH_STREAM_NOT_RUNNING_MSG` | String | "stream not running" | 67 |
| `ICH_STREAM_NOT_SUPPORT_MSG` | String | "stream not supported" | 68 |
| `ICH_STREAM_PLAYING_ENDED_MSG` | String | "stream playing ended" | 69 |
| `ICH_SURFACE_ALREADY_SET_MSG` | String | "surface already set" | 70 |
| `ICH_SURFACE_NOT_SET_MSG` | String | "surface not set" | 71 |
| `ICH_TRANSPORT_ERROR_MSG` | String | "transport error" | 72 |
| `ICH_TRY_AGAIN_MSG` | String | "try again" | 73 |
| `ICH_UNKNOWN_ERROR_MSG` | String | "unknown error" | 74 |
| `ICH_VIDEO_STREAM_CLOSED_MSG` | String | "video stream closed" | 75 |
| `ICH_WAIT_TIME_OUT_MSG` | String | "wait timeout" | 76 |
| `ICH_WIFI_DISCONNECTED_MSG` | String | "connection disconnected(wifi)" | 77 |

### `com.icatchtek.pancam.core.jni.extractor.NativeValueTag`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RETURN_BOOL_TAG` | String | "RET_BOOL" | 5 |
| `RETURN_DOUBLE_TAG` | String | "RET_DOUBLE" | 6 |
| `RETURN_ERR_TAG` | String | "RET_ERR" | 7 |
| `RETURN_INT_TAG` | String | "RET_INT" | 8 |
| `RETURN_LONG_TAG` | String | "RET_LONG" | 9 |
| `RETURN_STRING_TAG` | String | "RET_STRING" | 10 |
| `SEPARATOR_TAG` | String | "::" | 11 |

### `com.icatchtek.pancam.core.jni.NativeLibraryLoader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `intelArch` | String | "x86" | 6 |
| `neonArmArchArray` | String[] | {"armv7a", "armeabi-v7a"} | 7 |

### `com.icatchtek.pancam.core.util.type.NativeFile`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_ALL` | int | 15 | 14 |
| `TYPE_AUDIO` | int | 4 | 15 |
| `TYPE_IMAGE` | int | 1 | 16 |
| `TYPE_TEXT` | int | 8 | 17 |
| `TYPE_UNKNOWN` | int | 16 | 18 |
| `TYPE_VIDEO` | int | 2 | 19 |

### `com.icatchtek.pancam.core.VrImageRAW`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `VR_RAW_IMAGE_KEY_A_RGB` | int | 1 | 13 |
| `VR_RAW_IMAGE_KEY_RGB_A` | int | 2 | 14 |
| `VR_RAW_IMAGE_KEY_YUV_U` | int | 18 | 15 |
| `VR_RAW_IMAGE_KEY_YUV_V` | int | 19 | 16 |
| `VR_RAW_IMAGE_KEY_YUV_Y` | int | 17 | 17 |

### `com.icatchtek.pancam.customer.type.ICatchGLEventID`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_GL_EVENT_AUDIO_PLAYBACK_CACHING_CHANGED` | int | 74 | 5 |
| `ICH_GL_EVENT_AUDIO_PLAYBACK_CACHING_PROGRESS` | int | 73 | 6 |
| `ICH_GL_EVENT_AUDIO_STREAM_PLAYING_ENDED` | int | 70 | 7 |
| `ICH_GL_EVENT_AUDIO_STREAM_PLAYING_STATUS` | int | 68 | 8 |
| `ICH_GL_EVENT_COLOR_SPACE_STATUS` | int | 18 | 9 |
| `ICH_GL_EVENT_FRAME_INTERVAL_INFO` | int | 19 | 10 |
| `ICH_GL_EVENT_H264_FRAME_RANGE_DROPPED` | int | 75 | 11 |
| `ICH_GL_EVENT_LIVE_NETWORK_DISCONNECT` | int | 97 | 12 |
| `ICH_GL_EVENT_REMOTE_STREAM_CLOSED` | int | 66 | 13 |
| `ICH_GL_EVENT_RENDER_STATUS` | int | 16 | 14 |
| `ICH_GL_EVENT_SERVER_STREAM_ERROR` | int | 65 | 15 |
| `ICH_GL_EVENT_STREAM_CLOSED` | int | 66 | 16 |
| `ICH_GL_EVENT_TRANSPORT_AUDIO_STREAM_STATUS` | int | 77 | 17 |
| `ICH_GL_EVENT_TRANSPORT_VIDEO_STREAM_STATUS` | int | 76 | 18 |
| `ICH_GL_EVENT_USB_FRAME_TRANSFER_FAILED` | int | 79 | 19 |
| `ICH_GL_EVENT_VIDEO_CODEC_INSUFFICIENT_PERFORMANCE` | int | 80 | 20 |
| `ICH_GL_EVENT_VIDEO_PLAYBACK_CACHING_CHANGED` | int | 72 | 21 |
| `ICH_GL_EVENT_VIDEO_PLAYBACK_CACHING_PROGRESS` | int | 71 | 22 |
| `ICH_GL_EVENT_VIDEO_STREAM_NO_EIS_INFORMATION` | int | 78 | 23 |
| `ICH_GL_EVENT_VIDEO_STREAM_PLAYING_ENDED` | int | 69 | 24 |
| `ICH_GL_EVENT_VIDEO_STREAM_PLAYING_STATUS` | int | 67 | 25 |

### `com.icatchtek.pancam.customer.type.ICatchGLLogLevel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_GL_LOG_LEVEL_DEBUG` | int | 0 | 5 |
| `ICH_GL_LOG_LEVEL_ERROR` | int | 5 | 6 |
| `ICH_GL_LOG_LEVEL_FATAL_ERROR` | int | 6 | 7 |
| `ICH_GL_LOG_LEVEL_INFO` | int | 1 | 8 |
| `ICH_GL_LOG_LEVEL_WARN` | int | 3 | 9 |

### `com.icatchtek.pancam.customer.type.ICatchGLLogType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_GL_LOG_TYPE_COMMON` | int | 2 | 5 |
| `ICH_GL_LOG_TYPE_DEVELOP` | int | 3 | 6 |
| `ICH_GL_LOG_TYPE_OPENGL` | int | 0 | 7 |
| `ICH_GL_LOG_TYPE_STREAM` | int | 1 | 8 |

### `com.icatchtek.pancam.customer.type.ICatchGLPanoramaType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_GL_PANORAMA_TYPE_ASTEROID` | int | 4 | 5 |
| `ICH_GL_PANORAMA_TYPE_FISH_EYE` | int | 0 | 6 |
| `ICH_GL_PANORAMA_TYPE_PERSPECTIVE` | int | 1 | 7 |
| `ICH_GL_PANORAMA_TYPE_SPHERE` | int | 1 | 8 |
| `ICH_GL_PANORAMA_TYPE_VIRTUAL_R` | int | 6 | 9 |

### `com.icatchtek.pancam.customer.type.ICatchGLRotation`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_GL_ROTATION_0` | int | 0 | 5 |
| `ICH_GL_ROTATION_180` | int | 2 | 6 |
| `ICH_GL_ROTATION_270` | int | 3 | 7 |
| `ICH_GL_ROTATION_90` | int | 1 | 8 |

### `com.icatchtek.pancam.customer.type.ICatchGLSurfaceType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_GL_SURFACE_TYPE_SPHERE` | int | 1 | 5 |
| `ICH_GL_SURFACE_TYPE_SPHERE_VR1` | int | 1 | 6 |
| `ICH_GL_SURFACE_TYPE_SPHERE_VR2` | int | 2 | 7 |

### `com.icatchtek.reliant.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "debug" | 7 |
| `LIBRARY_PACKAGE_NAME` | String | "com.icatchtek.reliant" | 9 |
| `VERSION_CODE` | int | 1 | 10 |
| `VERSION_NAME` | String | "1.0" | 11 |

### `com.icatchtek.reliant.core.jni.JUsbTransportCore`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `USB_TRANSPORT_SUCCESS` | int | 0 | 8 |

### `com.icatchtek.reliant.core.jni.routines.NativeLibraryLoader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `intelArch` | String | "x86" | 6 |
| `neonArmArchArray` | String[] | {"armv7a", "armeabi-v7a"} | 7 |

### `com.icatchtek.reliant.customer.exception.IchBufferTooSmallException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchDeviceBusyException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchDeviceException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchNoSuchFileException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchNoSuchPathException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchNotImplementedException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchNotSupportedException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchPauseFailedException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchPbStreamPausedException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchPermissionDeniedException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchResumeFailedException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchSeekFailedException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchSocketException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchTimeOutException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.exception.IchUnknownException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.icatchtek.reliant.customer.transport.ICatchUsbScsiTransport`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `USB_TRANSPORT_ERROR_TRY_AGAIN` | int | -200 | 15 |

### `com.icatchtek.reliant.customer.type.ICatchAudioFormat`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_AUDIO_STREAM_NO` | int | 0 | 9 |

### `com.icatchtek.reliant.customer.type.ICatchCodec`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_CODEC_AC3` | int | 16 | 5 |
| `ICH_CODEC_AMR` | int | 2 | 6 |
| `ICH_CODEC_AMR_WB` | int | 3 | 7 |
| `ICH_CODEC_ARGB_8888` | int | 148 | 8 |
| `ICH_CODEC_BGR888` | int | 147 | 9 |
| `ICH_CODEC_BITMAP` | int | 130 | 10 |
| `ICH_CODEC_DAT12` | int | 112 | 11 |
| `ICH_CODEC_DV` | int | 48 | 12 |
| `ICH_CODEC_DVI4` | int | 69 | 13 |
| `ICH_CODEC_EAC3` | int | 33 | 14 |
| `ICH_CODEC_G726_16` | int | 98 | 15 |
| `ICH_CODEC_G726_24` | int | 99 | 16 |
| `ICH_CODEC_G726_32` | int | 100 | 17 |
| `ICH_CODEC_G726_40` | int | 101 | 18 |
| `ICH_CODEC_GSM` | int | 68 | 19 |
| `ICH_CODEC_H261` | int | 38 | 20 |
| `ICH_CODEC_H263_1998` | int | 39 | 21 |
| `ICH_CODEC_H263_2000` | int | 40 | 22 |
| `ICH_CODEC_H264` | int | 41 | 23 |
| `ICH_CODEC_HEVC` | int | 49 | 24 |
| `ICH_CODEC_ILBC` | int | 103 | 25 |
| `ICH_CODEC_JPEG` | int | 64 | 26 |
| `ICH_CODEC_L16` | int | 80 | 27 |
| `ICH_CODEC_L20` | int | 96 | 28 |
| `ICH_CODEC_L24` | int | 97 | 29 |
| `ICH_CODEC_L8` | int | 73 | 30 |
| `ICH_CODEC_MP1S` | int | 71 | 31 |
| `ICH_CODEC_MP2P` | int | 72 | 32 |
| `ICH_CODEC_MP2T` | int | 37 | 33 |
| `ICH_CODEC_MP4A_LATM` | int | 7 | 34 |
| `ICH_CODEC_MP4V_ES` | int | 34 | 35 |
| `ICH_CODEC_MPA` | int | 4 | 36 |
| `ICH_CODEC_MPA_ROBUST` | int | 5 | 37 |
| `ICH_CODEC_MPEG4_GENERIC` | int | 35 | 38 |
| `ICH_CODEC_MPV` | int | 36 | 39 |
| `ICH_CODEC_OPUS` | int | 104 | 40 |
| `ICH_CODEC_PCM` | int | 144 | 41 |
| `ICH_CODEC_PCMA` | int | 70 | 42 |
| `ICH_CODEC_PCMU` | int | 67 | 43 |
| `ICH_CODEC_QCELP` | int | 1 | 44 |
| `ICH_CODEC_RGB565` | int | 145 | 45 |
| `ICH_CODEC_RGB888` | int | 146 | 46 |
| `ICH_CODEC_RGBA_8888` | int | 149 | 47 |
| `ICH_CODEC_SPEEX` | int | 102 | 48 |
| `ICH_CODEC_T140` | int | 105 | 49 |
| `ICH_CODEC_UNKNOWN` | int | 255 | 50 |
| `ICH_CODEC_VND_ONVIF_METADATA` | int | 129 | 51 |
| `ICH_CODEC_VORBIS` | int | 8 | 52 |
| `ICH_CODEC_VP8` | int | 9 | 53 |
| `ICH_CODEC_X_MP3_DRAFT_00` | int | 6 | 54 |
| `ICH_CODEC_X_QT` | int | 65 | 55 |
| `ICH_CODEC_X_QT_QUICKTIME` | int | 66 | 56 |
| `ICH_CODEC_YUV_I420` | int | 150 | 57 |
| `ICH_CODEC_YUV_NV12` | int | 151 | 58 |

### `com.icatchtek.reliant.customer.type.ICatchError`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_ALREADY_INIT` | int | -221 | 5 |
| `ICH_AUDIO_STREAM_CLOSED` | int | -91 | 6 |
| `ICH_BUF_TOO_SMALL` | int | -7 | 7 |
| `ICH_CALLBACK_EXISTS` | int | -40 | 8 |
| `ICH_DEVICE_BUSY` | int | -1 | 9 |
| `ICH_DEVICE_ERROR` | int | -2 | 10 |
| `ICH_ERROR_ACCESS` | int | -22 | 11 |
| `ICH_ERROR_BUSY` | int | -25 | 12 |
| `ICH_ERROR_INTERRUPTED` | int | -29 | 13 |
| `ICH_ERROR_INVALID_DEVICE` | int | -30 | 14 |
| `ICH_ERROR_INVALID_MODE` | int | -31 | 15 |
| `ICH_ERROR_IO` | int | -21 | 16 |
| `ICH_ERROR_NO_DEVICE` | int | -23 | 18 |
| `ICH_ERROR_NOT_FOUND` | int | -24 | 17 |
| `ICH_ERROR_NULL` | int | -121 | 19 |
| `ICH_ERROR_OVERFLOW` | int | -27 | 20 |
| `ICH_ERROR_PIPE` | int | -28 | 21 |
| `ICH_ERROR_TIMEOUT` | int | -26 | 22 |
| `ICH_FILE_NOT_FOUND` | int | -9 | 23 |
| `ICH_FORMAT_NOT_SPECIFIED` | int | -217 | 24 |
| `ICH_FORMAT_NOT_SUPPORTED` | int | -216 | 25 |
| `ICH_GL_PICTURE_SIZE_NOT_SPECIFIED` | int | -223 | 26 |
| `ICH_GL_RENDER_NEED_SETUP` | int | -222 | 27 |
| `ICH_INVALID_ARGUMENT` | int | -12 | 28 |
| `ICH_INVALID_SESSION` | int | -11 | 29 |
| `ICH_JNI_EXP` | int | -41 | 30 |
| `ICH_LISTENER_EXISTS` | int | -60 | 31 |
| `ICH_LISTENER_NOT_EXISTS` | int | -61 | 32 |
| `ICH_MUXER_ALREADY_STARTED` | int | -110 | 33 |
| `ICH_MUXER_NOT_STARTED` | int | -112 | 34 |
| `ICH_MUXER_START_FAILED` | int | -111 | 35 |
| `ICH_MUXER_WAINTING_KEY_FRAME` | int | -113 | 36 |
| `ICH_NO_USB_ENDPOINT` | int | -43 | 40 |
| `ICH_NO_USB_FRAME_INFO` | int | -44 | 41 |
| `ICH_NO_USB_INTERFACE` | int | -42 | 42 |
| `ICH_NO_USB_STREAM` | int | -45 | 43 |
| `ICH_NOT_IMPLEMENTED` | int | -4 | 37 |
| `ICH_NOT_INIT` | int | -220 | 38 |
| `ICH_NOT_SUPPORTED` | int | -3 | 39 |
| `ICH_OPEN_FAIL` | int | -120 | 44 |
| `ICH_OUT_OF_MEMORY` | int | -8 | 45 |
| `ICH_PATH_NOT_FOUND` | int | -10 | 46 |
| `ICH_PAUSE_FAILED` | int | -72 | 47 |
| `ICH_PB_CACHING` | int | -82 | 48 |
| `ICH_PB_MEM_FULL` | int | -81 | 49 |
| `ICH_PB_PLAY_END` | int | -83 | 50 |
| `ICH_PB_STREAM_PAUSED` | int | -84 | 51 |
| `ICH_PERMISSION_DENIED` | int | -5 | 52 |
| `ICH_PICTURE_NOT_SPECIFIED` | int | -218 | 53 |
| `ICH_PTP_INIT_FAILED` | int | -101 | 54 |
| `ICH_PUBLISH_ALREADY_START` | int | -103 | 55 |
| `ICH_PUBLISH_ALREADY_STOP` | int | -104 | 56 |
| `ICH_RENDER_ALREADY_INIT` | int | -211 | 57 |
| `ICH_RENDER_ALREADY_STARTED` | int | -213 | 58 |
| `ICH_RENDER_NOT_INIT` | int | -210 | 59 |
| `ICH_RENDER_NOT_STARTED` | int | -212 | 60 |
| `ICH_RESOURCE_NOT_READY` | int | -202 | 61 |
| `ICH_RESUME_FAILED` | int | -73 | 62 |
| `ICH_SEEK_FAILED` | int | -71 | 63 |
| `ICH_SESSION_EXISTS` | int | -203 | 64 |
| `ICH_SESSION_NOT_EXISTS` | int | -204 | 65 |
| `ICH_SESSION_PASSWORD_ERR` | int | -100 | 66 |
| `ICH_SOCKET_ERROR` | int | -13 | 67 |
| `ICH_SPHERE_TYPE_NOT_SUPPORTED` | int | -219 | 68 |
| `ICH_STREAM_ALREADY_STARTED` | int | -206 | 69 |
| `ICH_STREAM_NOT_RUNNING` | int | -92 | 70 |
| `ICH_STREAM_NOT_SUPPORT` | int | -93 | 71 |
| `ICH_STREAM_PLAYING_ENDED` | int | -205 | 72 |
| `ICH_SUCCEED` | int | 0 | 73 |
| `ICH_SURFACE_ALREADY_SET` | int | -215 | 74 |
| `ICH_SURFACE_NOT_SET` | int | -214 | 75 |
| `ICH_TRANSPORT_ERROR` | int | -207 | 76 |
| `ICH_TRY_AGAIN` | int | -6 | 77 |
| `ICH_UNKNOWN_ERROR` | int | -255 | 78 |
| `ICH_USB_W_ADD_FAILTER_FAILED` | int | -233 | 79 |
| `ICH_USB_W_BUILD_FILTER_CHAIN_FAILED` | int | -239 | 80 |
| `ICH_USB_W_CONNECT_TWO_PINS_FAILED` | int | -240 | 81 |
| `ICH_USB_W_CREATE_FGRAPH_FAILED` | int | -232 | 82 |
| `ICH_USB_W_DEVICE_NOT_FOUND` | int | -230 | 83 |
| `ICH_USB_W_DSHOW_BOJECT_FAILED` | int | -236 | 84 |
| `ICH_USB_W_FIND_INTERFACE_FAILED` | int | -238 | 85 |
| `ICH_USB_W_FIND_STILL_PIN_FAILED` | int | -237 | 86 |
| `ICH_USB_W_GENERAL_UNKNOWN_ERROR` | int | -235 | 87 |
| `ICH_USB_W_PLATFORM_NOT_READY` | int | -231 | 88 |
| `ICH_USB_W_REMOVE_FAILTER_FAILED` | int | -234 | 89 |
| `ICH_USB_W_RENDER_STREAM_FAILED` | int | -241 | 90 |
| `ICH_USB_W_SEND_EXU_COMMAND_FAILED` | int | -243 | 91 |
| `ICH_USB_W_START_STREAM_FAILED` | int | -244 | 92 |
| `ICH_USB_W_TRIGGER_CAPTURE_IMAGE_FAILED` | int | -242 | 93 |
| `ICH_VIDEO_STREAM_CLOSED` | int | -90 | 94 |
| `ICH_WAIT_TIME_OUT` | int | -102 | 95 |
| `ICH_WIFI_DISCONNECTED` | int | -14 | 96 |

### `com.icatchtek.reliant.customer.type.ICatchFileType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_FILE_TYPE_ALL` | int | 15 | 5 |
| `ICH_FILE_TYPE_AUDIO` | int | 4 | 6 |
| `ICH_FILE_TYPE_IMAGE` | int | 1 | 7 |
| `ICH_FILE_TYPE_TEXT` | int | 8 | 8 |
| `ICH_FILE_TYPE_UNKNOWN` | int | 16 | 9 |
| `ICH_FILE_TYPE_VIDEO` | int | 2 | 10 |

### `com.icatchtek.reliant.customer.type.ICatchScsiCommandInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `cdbLength` | int | 16 | 11 |
| `fwMode` | int | 0 | 12 |
| `scsiCmd` | int | 192 | 13 |
| `USB_DIR_IN` | int | 1 | 8 |
| `USB_DIR_NONE` | int | 3 | 9 |
| `USB_DIR_OUT` | int | 2 | 10 |

### `com.icatchtek.reliant.customer.type.ICatchScsiMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SCSI_MODE_PLAYBACK` | int | 1 | 5 |
| `SCSI_MODE_PREVIEW` | int | 0 | 6 |

### `com.icatchtek.reliant.customer.type.ICatchTransportType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICH_GL_TRANSPORT_NET` | int | 2 | 5 |
| `ICH_GL_TRANSPORT_USB` | int | 1 | 6 |

### `com.icatchtek.reliant.customer.type.ICatchVideoFormat`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_VIDEO_STREAM_NO` | int | 0 | 9 |

### `com.id221.golive.R$anim`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_fade_in` | int | 0x7f010000 | 7 |
| `abc_fade_out` | int | 0x7f010001 | 8 |
| `abc_grow_fade_in_from_bottom` | int | 0x7f010002 | 9 |
| `abc_popup_enter` | int | 0x7f010003 | 10 |
| `abc_popup_exit` | int | 0x7f010004 | 11 |
| `abc_shrink_fade_out_from_bottom` | int | 0x7f010005 | 12 |
| `abc_slide_in_bottom` | int | 0x7f010006 | 13 |
| `abc_slide_in_top` | int | 0x7f010007 | 14 |
| `abc_slide_out_bottom` | int | 0x7f010008 | 15 |
| `abc_slide_out_top` | int | 0x7f010009 | 16 |
| `abc_tooltip_enter` | int | 0x7f01000a | 17 |
| `abc_tooltip_exit` | int | 0x7f01000b | 18 |
| `btn_checkbox_to_checked_box_inner_merged_animation` | int | 0x7f01000c | 19 |
| `btn_checkbox_to_checked_box_outer_merged_animation` | int | 0x7f01000d | 20 |
| `btn_checkbox_to_checked_icon_null_animation` | int | 0x7f01000e | 21 |
| `btn_checkbox_to_unchecked_box_inner_merged_animation` | int | 0x7f01000f | 22 |
| `btn_checkbox_to_unchecked_check_path_merged_animation` | int | 0x7f010010 | 23 |
| `btn_checkbox_to_unchecked_icon_null_animation` | int | 0x7f010011 | 24 |
| `btn_radio_to_off_mtrl_dot_group_animation` | int | 0x7f010012 | 25 |
| `btn_radio_to_off_mtrl_ring_outer_animation` | int | 0x7f010013 | 26 |
| `btn_radio_to_off_mtrl_ring_outer_path_animation` | int | 0x7f010014 | 27 |
| `btn_radio_to_on_mtrl_dot_group_animation` | int | 0x7f010015 | 28 |
| `btn_radio_to_on_mtrl_ring_outer_animation` | int | 0x7f010016 | 29 |
| `btn_radio_to_on_mtrl_ring_outer_path_animation` | int | 0x7f010017 | 30 |
| `design_bottom_sheet_slide_in` | int | 0x7f010018 | 31 |
| `design_bottom_sheet_slide_out` | int | 0x7f010019 | 32 |
| `design_snackbar_in` | int | 0x7f01001a | 33 |
| `design_snackbar_out` | int | 0x7f01001b | 34 |
| `dialog_enter` | int | 0x7f01001c | 35 |
| `dialog_exit` | int | 0x7f01001d | 36 |
| `enter` | int | 0x7f01001e | 37 |
| `enter_anim` | int | 0x7f01001f | 38 |
| `exit` | int | 0x7f010020 | 39 |
| `exit_anim` | int | 0x7f010021 | 40 |
| `fragment_fast_out_extra_slow_in` | int | 0x7f010022 | 41 |
| `linear_indeterminate_line1_head_interpolator` | int | 0x7f010023 | 42 |
| `linear_indeterminate_line1_tail_interpolator` | int | 0x7f010024 | 43 |
| `linear_indeterminate_line2_head_interpolator` | int | 0x7f010025 | 44 |
| `linear_indeterminate_line2_tail_interpolator` | int | 0x7f010026 | 45 |
| `m3_bottom_sheet_slide_in` | int | 0x7f010027 | 46 |
| `m3_bottom_sheet_slide_out` | int | 0x7f010028 | 47 |
| `m3_motion_fade_enter` | int | 0x7f010029 | 48 |
| `m3_motion_fade_exit` | int | 0x7f01002a | 49 |
| `m3_side_sheet_enter_from_left` | int | 0x7f01002b | 50 |
| `m3_side_sheet_enter_from_right` | int | 0x7f01002c | 51 |
| `m3_side_sheet_exit_to_left` | int | 0x7f01002d | 52 |
| `m3_side_sheet_exit_to_right` | int | 0x7f01002e | 53 |
| `mtrl_bottom_sheet_slide_in` | int | 0x7f01002f | 54 |
| `mtrl_bottom_sheet_slide_out` | int | 0x7f010030 | 55 |
| `mtrl_card_lowers_interpolator` | int | 0x7f010031 | 56 |
| `pickerview_dialog_scale_in` | int | 0x7f010032 | 57 |
| `pickerview_dialog_scale_out` | int | 0x7f010033 | 58 |
| `pickerview_slide_in_bottom` | int | 0x7f010034 | 59 |
| `pickerview_slide_out_bottom` | int | 0x7f010035 | 60 |
| `pop_from_bottom_anim_in` | int | 0x7f010036 | 61 |
| `pop_from_bottom_anim_out` | int | 0x7f010037 | 62 |
| `slide_in_from_bottom` | int | 0x7f010038 | 63 |
| `slide_in_from_top` | int | 0x7f010039 | 64 |
| `slide_out_to_bottom` | int | 0x7f01003a | 65 |
| `slide_out_to_top` | int | 0x7f01003b | 66 |

### `com.id221.golive.R$animator`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `chevron_checked_unchecked` | int | 0x7f020000 | 70 |
| `chevron_unchecked_checked` | int | 0x7f020001 | 71 |
| `design_appbar_state_list_animator` | int | 0x7f020002 | 72 |
| `design_fab_hide_motion_spec` | int | 0x7f020003 | 73 |
| `design_fab_show_motion_spec` | int | 0x7f020004 | 74 |
| `fragment_close_enter` | int | 0x7f020005 | 75 |
| `fragment_close_exit` | int | 0x7f020006 | 76 |
| `fragment_fade_enter` | int | 0x7f020007 | 77 |
| `fragment_fade_exit` | int | 0x7f020008 | 78 |
| `fragment_open_enter` | int | 0x7f020009 | 79 |
| `fragment_open_exit` | int | 0x7f02000a | 80 |
| `m3_appbar_state_list_animator` | int | 0x7f02000b | 81 |
| `m3_btn_elevated_btn_state_list_anim` | int | 0x7f02000c | 82 |
| `m3_btn_state_list_anim` | int | 0x7f02000d | 83 |
| `m3_card_elevated_state_list_anim` | int | 0x7f02000e | 84 |
| `m3_card_state_list_anim` | int | 0x7f02000f | 85 |
| `m3_chip_state_list_anim` | int | 0x7f020010 | 86 |
| `m3_elevated_chip_state_list_anim` | int | 0x7f020011 | 87 |
| `m3_extended_fab_change_size_collapse_motion_spec` | int | 0x7f020012 | 88 |
| `m3_extended_fab_change_size_expand_motion_spec` | int | 0x7f020013 | 89 |
| `m3_extended_fab_hide_motion_spec` | int | 0x7f020014 | 90 |
| `m3_extended_fab_show_motion_spec` | int | 0x7f020015 | 91 |
| `m3_extended_fab_state_list_animator` | int | 0x7f020016 | 92 |
| `m3_fab_state_list_animator` | int | 0x7f020017 | 93 |
| `m3_split_button_chevron_overshoot_interpolator` | int | 0x7f020018 | 94 |
| `m3_split_button_chevron_reverse_rotation` | int | 0x7f020019 | 95 |
| `m3_split_button_chevron_rotation` | int | 0x7f02001a | 96 |
| `mtrl_btn_state_list_anim` | int | 0x7f02001b | 97 |
| `mtrl_btn_unelevated_state_list_anim` | int | 0x7f02001c | 98 |
| `mtrl_card_state_list_anim` | int | 0x7f02001d | 99 |
| `mtrl_chip_state_list_anim` | int | 0x7f02001e | 100 |
| `mtrl_extended_fab_change_size_collapse_motion_spec` | int | 0x7f02001f | 101 |
| `mtrl_extended_fab_change_size_expand_motion_spec` | int | 0x7f020020 | 102 |
| `mtrl_extended_fab_hide_motion_spec` | int | 0x7f020021 | 103 |
| `mtrl_extended_fab_show_motion_spec` | int | 0x7f020022 | 104 |
| `mtrl_extended_fab_state_list_animator` | int | 0x7f020023 | 105 |
| `mtrl_fab_hide_motion_spec` | int | 0x7f020024 | 106 |
| `mtrl_fab_show_motion_spec` | int | 0x7f020025 | 107 |
| `mtrl_fab_transformation_sheet_collapse_spec` | int | 0x7f020026 | 108 |
| `mtrl_fab_transformation_sheet_expand_spec` | int | 0x7f020027 | 109 |

### `com.id221.golive.R$array`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `burst_values` | int | 0x7f030000 | 113 |
| `exo_controls_playback_speeds` | int | 0x7f030001 | 114 |
| `pref_example_list_titles` | int | 0x7f030002 | 115 |
| `pref_example_list_values` | int | 0x7f030003 | 116 |
| `pref_sync_frequency_titles` | int | 0x7f030004 | 117 |
| `pref_sync_frequency_values` | int | 0x7f030005 | 118 |
| `setting_awb_list` | int | 0x7f030006 | 119 |
| `setting_awb_list_values` | int | 0x7f030007 | 120 |
| `setting_burst_interval_fps` | int | 0x7f030008 | 121 |
| `setting_burst_interval_list` | int | 0x7f030009 | 122 |
| `setting_burst_interval_list_values` | int | 0x7f03000a | 123 |
| `setting_burst_list` | int | 0x7f03000b | 124 |
| `setting_burst_list_shots` | int | 0x7f03000c | 125 |
| `setting_burst_list_values` | int | 0x7f03000d | 126 |
| `setting_cap_timescape_duration_list` | int | 0x7f03000e | 127 |
| `setting_cap_timescape_duration_list_values` | int | 0x7f03000f | 128 |
| `setting_cap_timescape_interval_list` | int | 0x7f030010 | 129 |
| `setting_cap_timescape_interval_list_values` | int | 0x7f030011 | 130 |
| `setting_datestamp_list` | int | 0x7f030012 | 131 |
| `setting_datestamp_list_values` | int | 0x7f030013 | 132 |
| `setting_delaytime_list_values` | int | 0x7f030014 | 133 |
| `setting_power_supply_list` | int | 0x7f030015 | 134 |
| `setting_power_supply_list_values` | int | 0x7f030016 | 135 |
| `setting_vid_timescape_duration_list` | int | 0x7f030017 | 136 |
| `setting_vid_timescape_duration_list_values` | int | 0x7f030018 | 137 |
| `setting_vid_timescape_interval_list` | int | 0x7f030019 | 138 |
| `setting_vid_timescape_interval_list_values` | int | 0x7f03001a | 139 |

### `com.id221.golive.R$attr`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `actionBarDivider` | int | 0x7f040002 | 145 |
| `actionBarItemBackground` | int | 0x7f040003 | 146 |
| `actionBarPopupTheme` | int | 0x7f040004 | 147 |
| `actionBarSize` | int | 0x7f040005 | 148 |
| `actionBarSplitStyle` | int | 0x7f040006 | 149 |
| `actionBarStyle` | int | 0x7f040007 | 150 |
| `actionBarTabBarStyle` | int | 0x7f040008 | 151 |
| `actionBarTabStyle` | int | 0x7f040009 | 152 |
| `actionBarTabTextStyle` | int | 0x7f04000a | 153 |
| `actionBarTheme` | int | 0x7f04000b | 154 |
| `actionBarWidgetTheme` | int | 0x7f04000c | 155 |
| `actionButtonStyle` | int | 0x7f04000d | 156 |
| `actionDropDownStyle` | int | 0x7f04000e | 157 |
| `actionLayout` | int | 0x7f04000f | 158 |
| `actionMenuTextAppearance` | int | 0x7f040010 | 159 |
| `actionMenuTextColor` | int | 0x7f040011 | 160 |
| `actionModeBackground` | int | 0x7f040012 | 161 |
| `actionModeCloseButtonStyle` | int | 0x7f040013 | 162 |
| `actionModeCloseContentDescription` | int | 0x7f040014 | 163 |
| `actionModeCloseDrawable` | int | 0x7f040015 | 164 |
| `actionModeCopyDrawable` | int | 0x7f040016 | 165 |
| `actionModeCutDrawable` | int | 0x7f040017 | 166 |
| `actionModeFindDrawable` | int | 0x7f040018 | 167 |
| `actionModePasteDrawable` | int | 0x7f040019 | 168 |
| `actionModePopupWindowStyle` | int | 0x7f04001a | 169 |
| `actionModeSelectAllDrawable` | int | 0x7f04001b | 170 |
| `actionModeShareDrawable` | int | 0x7f04001c | 171 |
| `actionModeSplitBackground` | int | 0x7f04001d | 172 |
| `actionModeStyle` | int | 0x7f04001e | 173 |
| `actionModeTheme` | int | 0x7f04001f | 174 |
| `actionModeWebSearchDrawable` | int | 0x7f040020 | 175 |
| `actionOverflowButtonStyle` | int | 0x7f040021 | 176 |
| `actionOverflowMenuStyle` | int | 0x7f040022 | 177 |
| `actionProviderClass` | int | 0x7f040023 | 178 |
| `actionTextColorAlpha` | int | 0x7f040024 | 179 |
| `actionViewClass` | int | 0x7f040025 | 180 |
| `activeIndicatorLabelPadding` | int | 0x7f040026 | 181 |
| `activityChooserViewStyle` | int | 0x7f040027 | 182 |
| `ad_marker_color` | int | 0x7f040028 | 183 |
| `ad_marker_width` | int | 0x7f040029 | 184 |
| `addElevationShadow` | int | 0x7f04002a | 185 |
| `alertDialogButtonGroupStyle` | int | 0x7f04002b | 186 |
| `alertDialogCenterButtons` | int | 0x7f04002c | 187 |
| `alertDialogStyle` | int | 0x7f04002d | 188 |
| `alertDialogTheme` | int | 0x7f04002e | 189 |
| `allowStacking` | int | 0x7f04002f | 190 |
| `alpha` | int | 0x7f040030 | 191 |
| `alphabeticModifiers` | int | 0x7f040031 | 192 |
| `altSrc` | int | 0x7f040032 | 193 |
| `always_hide_bar` | int | 0x7f040033 | 194 |
| `animateCircleAngleTo` | int | 0x7f040034 | 195 |
| `animateMenuItems` | int | 0x7f040035 | 196 |
| `animateNavigationIcon` | int | 0x7f040036 | 197 |
| `animateRelativeTo` | int | 0x7f040037 | 198 |
| `animation_enabled` | int | 0x7f040039 | 200 |
| `animationMode` | int | 0x7f040038 | 199 |
| `appBarLayoutStyle` | int | 0x7f04003a | 201 |
| `applyMotionScene` | int | 0x7f04003b | 202 |
| `arcMode` | int | 0x7f04003c | 203 |
| `arrowHeadLength` | int | 0x7f04003d | 204 |
| `arrowShaftLength` | int | 0x7f04003e | 205 |
| `artwork_display_mode` | int | 0x7f04003f | 206 |
| `attributeName` | int | 0x7f040040 | 207 |
| `auto_hide_bar` | int | 0x7f04004b | 218 |
| `auto_show` | int | 0x7f04004c | 219 |
| `autoAdjustToWithinGrandparentBounds` | int | 0x7f040041 | 208 |
| `autoCompleteMode` | int | 0x7f040042 | 209 |
| `autoCompleteTextViewStyle` | int | 0x7f040043 | 210 |
| `autoShowKeyboard` | int | 0x7f040044 | 211 |
| `autoSizeMaxTextSize` | int | 0x7f040045 | 212 |
| `autoSizeMinTextSize` | int | 0x7f040046 | 213 |
| `autoSizePresetSizes` | int | 0x7f040047 | 214 |
| `autoSizeStepGranularity` | int | 0x7f040048 | 215 |
| `autoSizeTextType` | int | 0x7f040049 | 216 |
| `autoTransition` | int | 0x7f04004a | 217 |
| `background` | int | 0x7f04004e | 221 |
| `backgroundColor` | int | 0x7f04004f | 222 |
| `backgroundInsetBottom` | int | 0x7f040050 | 223 |
| `backgroundInsetEnd` | int | 0x7f040051 | 224 |
| `backgroundInsetStart` | int | 0x7f040052 | 225 |
| `backgroundInsetTop` | int | 0x7f040053 | 226 |
| `backgroundOverlayColorAlpha` | int | 0x7f040054 | 227 |
| `backgroundSplit` | int | 0x7f040055 | 228 |
| `backgroundStacked` | int | 0x7f040056 | 229 |
| `backgroundTint` | int | 0x7f040057 | 230 |
| `backgroundTintMode` | int | 0x7f040058 | 231 |
| `backHandlingEnabled` | int | 0x7f04004d | 220 |
| `badgeFixedEdge` | int | 0x7f040059 | 232 |
| `badgeGravity` | int | 0x7f04005a | 233 |
| `badgeHeight` | int | 0x7f04005b | 234 |
| `badgeRadius` | int | 0x7f04005c | 235 |
| `badgeShapeAppearance` | int | 0x7f04005d | 236 |
| `badgeShapeAppearanceOverlay` | int | 0x7f04005e | 237 |
| `badgeStyle` | int | 0x7f04005f | 238 |
| `badgeText` | int | 0x7f040060 | 239 |
| `badgeTextAppearance` | int | 0x7f040061 | 240 |
| `badgeTextColor` | int | 0x7f040062 | 241 |
| `badgeVerticalPadding` | int | 0x7f040063 | 242 |
| `badgeWidePadding` | int | 0x7f040064 | 243 |
| `badgeWidth` | int | 0x7f040065 | 244 |
| `badgeWithTextHeight` | int | 0x7f040066 | 245 |
| `badgeWithTextRadius` | int | 0x7f040067 | 246 |
| `badgeWithTextShapeAppearance` | int | 0x7f040068 | 247 |
| `badgeWithTextShapeAppearanceOverlay` | int | 0x7f040069 | 248 |
| `badgeWithTextWidth` | int | 0x7f04006a | 249 |
| `bar_gravity` | int | 0x7f04006f | 254 |
| `bar_height` | int | 0x7f040070 | 255 |
| `barColor` | int | 0x7f04006b | 250 |
| `barLength` | int | 0x7f04006c | 251 |
| `barLengthP` | int | 0x7f04006d | 252 |
| `barrierAllowsGoneWidgets` | int | 0x7f040071 | 256 |
| `barrierDirection` | int | 0x7f040072 | 257 |
| `barrierMargin` | int | 0x7f040073 | 258 |
| `barWidth` | int | 0x7f04006e | 253 |
| `behavior_autoHide` | int | 0x7f040074 | 259 |
| `behavior_autoShrink` | int | 0x7f040075 | 260 |
| `behavior_draggable` | int | 0x7f040076 | 261 |
| `behavior_draggableOnNestedScroll` | int | 0x7f040077 | 262 |
| `behavior_expandedOffset` | int | 0x7f040078 | 263 |
| `behavior_fitToContents` | int | 0x7f040079 | 264 |
| `behavior_halfExpandedRatio` | int | 0x7f04007a | 265 |
| `behavior_hideable` | int | 0x7f04007b | 266 |
| `behavior_overlapTop` | int | 0x7f04007c | 267 |
| `behavior_peekHeight` | int | 0x7f04007d | 268 |
| `behavior_saveFlags` | int | 0x7f04007e | 269 |
| `behavior_significantVelocityThreshold` | int | 0x7f04007f | 270 |
| `behavior_skipCollapsed` | int | 0x7f040080 | 271 |
| `blendSrc` | int | 0x7f040081 | 272 |
| `borderlessButtonStyle` | int | 0x7f040085 | 276 |
| `borderRound` | int | 0x7f040082 | 273 |
| `borderRoundPercent` | int | 0x7f040083 | 274 |
| `borderWidth` | int | 0x7f040084 | 275 |
| `bottomAppBarStyle` | int | 0x7f040086 | 277 |
| `bottomInsetScrimEnabled` | int | 0x7f040087 | 278 |
| `bottomNavigationStyle` | int | 0x7f040088 | 279 |
| `bottomSheetDialogTheme` | int | 0x7f040089 | 280 |
| `bottomSheetDragHandleStyle` | int | 0x7f04008a | 281 |
| `bottomSheetStyle` | int | 0x7f04008b | 282 |
| `boxBackgroundColor` | int | 0x7f04008c | 283 |
| `boxBackgroundMode` | int | 0x7f04008d | 284 |
| `boxCollapsedPaddingTop` | int | 0x7f04008e | 285 |
| `boxCornerRadiusBottomEnd` | int | 0x7f04008f | 286 |
| `boxCornerRadiusBottomStart` | int | 0x7f040090 | 287 |
| `boxCornerRadiusTopEnd` | int | 0x7f040091 | 288 |
| `boxCornerRadiusTopStart` | int | 0x7f040092 | 289 |
| `boxStrokeColor` | int | 0x7f040093 | 290 |
| `boxStrokeErrorColor` | int | 0x7f040094 | 291 |
| `boxStrokeWidth` | int | 0x7f040095 | 292 |
| `boxStrokeWidthFocused` | int | 0x7f040096 | 293 |
| `brightness` | int | 0x7f040097 | 294 |
| `buffered_color` | int | 0x7f040098 | 295 |
| `buttonBarButtonStyle` | int | 0x7f040099 | 296 |
| `buttonBarNegativeButtonStyle` | int | 0x7f04009a | 297 |
| `buttonBarNeutralButtonStyle` | int | 0x7f04009b | 298 |
| `buttonBarPositiveButtonStyle` | int | 0x7f04009c | 299 |
| `buttonBarStyle` | int | 0x7f04009d | 300 |
| `buttonCompat` | int | 0x7f04009e | 301 |
| `buttonGravity` | int | 0x7f04009f | 302 |
| `buttonIcon` | int | 0x7f0400a0 | 303 |
| `buttonIconDimen` | int | 0x7f0400a1 | 304 |
| `buttonIconTint` | int | 0x7f0400a2 | 305 |
| `buttonIconTintMode` | int | 0x7f0400a3 | 306 |
| `buttonPanelSideLayout` | int | 0x7f0400a4 | 307 |
| `buttonSize` | int | 0x7f0400a5 | 308 |
| `buttonSizeChange` | int | 0x7f0400a6 | 309 |
| `buttonStyle` | int | 0x7f0400a7 | 310 |
| `buttonStyleSmall` | int | 0x7f0400a8 | 311 |
| `buttonTint` | int | 0x7f0400a9 | 312 |
| `buttonTintMode` | int | 0x7f0400aa | 313 |
| `camera_name_color` | int | 0x7f0400ab | 314 |
| `camera_name_size` | int | 0x7f0400ac | 315 |
| `cardBackgroundColor` | int | 0x7f0400ad | 316 |
| `cardCornerRadius` | int | 0x7f0400ae | 317 |
| `cardElevation` | int | 0x7f0400af | 318 |
| `cardForegroundColor` | int | 0x7f0400b0 | 319 |
| `cardMaxElevation` | int | 0x7f0400b1 | 320 |
| `cardPreventCornerOverlap` | int | 0x7f0400b2 | 321 |
| `cardUseCompatPadding` | int | 0x7f0400b3 | 322 |
| `cardViewStyle` | int | 0x7f0400b4 | 323 |
| `carousel_alignment` | int | 0x7f0400b5 | 324 |
| `carousel_backwardTransition` | int | 0x7f0400b6 | 325 |
| `carousel_emptyViewsBehavior` | int | 0x7f0400b7 | 326 |
| `carousel_firstView` | int | 0x7f0400b8 | 327 |
| `carousel_forwardTransition` | int | 0x7f0400b9 | 328 |
| `carousel_infinite` | int | 0x7f0400ba | 329 |
| `carousel_nextState` | int | 0x7f0400bb | 330 |
| `carousel_previousState` | int | 0x7f0400bc | 331 |
| `carousel_touchUp_dampeningFactor` | int | 0x7f0400be | 333 |
| `carousel_touchUp_velocityThreshold` | int | 0x7f0400bf | 334 |
| `carousel_touchUpMode` | int | 0x7f0400bd | 332 |
| `centered` | int | 0x7f0400c1 | 336 |
| `centerIfNoTextEnabled` | int | 0x7f0400c0 | 335 |
| `chainUseRtl` | int | 0x7f0400c2 | 337 |
| `checkboxStyle` | int | 0x7f0400c6 | 341 |
| `checked_img` | int | 0x7f0400d2 | 353 |
| `checkedButton` | int | 0x7f0400c7 | 342 |
| `checkedChip` | int | 0x7f0400c8 | 343 |
| `checkedIcon` | int | 0x7f0400c9 | 344 |
| `checkedIconEnabled` | int | 0x7f0400ca | 345 |
| `checkedIconGravity` | int | 0x7f0400cb | 346 |
| `checkedIconMargin` | int | 0x7f0400cc | 347 |
| `checkedIconSize` | int | 0x7f0400cd | 348 |
| `checkedIconTint` | int | 0x7f0400ce | 349 |
| `checkedIconVisible` | int | 0x7f0400cf | 350 |
| `checkedState` | int | 0x7f0400d0 | 351 |
| `checkedTextViewStyle` | int | 0x7f0400d1 | 352 |
| `checkMarkCompat` | int | 0x7f0400c3 | 338 |
| `checkMarkTint` | int | 0x7f0400c4 | 339 |
| `checkMarkTintMode` | int | 0x7f0400c5 | 340 |
| `chipBackgroundColor` | int | 0x7f0400d3 | 354 |
| `chipCornerRadius` | int | 0x7f0400d4 | 355 |
| `chipEndPadding` | int | 0x7f0400d5 | 356 |
| `chipGroupStyle` | int | 0x7f0400d6 | 357 |
| `chipIcon` | int | 0x7f0400d7 | 358 |
| `chipIconEnabled` | int | 0x7f0400d8 | 359 |
| `chipIconSize` | int | 0x7f0400d9 | 360 |
| `chipIconTint` | int | 0x7f0400da | 361 |
| `chipIconVisible` | int | 0x7f0400db | 362 |
| `chipMinHeight` | int | 0x7f0400dc | 363 |
| `chipMinTouchTargetSize` | int | 0x7f0400dd | 364 |
| `chipSpacing` | int | 0x7f0400de | 365 |
| `chipSpacingHorizontal` | int | 0x7f0400df | 366 |
| `chipSpacingVertical` | int | 0x7f0400e0 | 367 |
| `chipStandaloneStyle` | int | 0x7f0400e1 | 368 |
| `chipStartPadding` | int | 0x7f0400e2 | 369 |
| `chipStrokeColor` | int | 0x7f0400e3 | 370 |
| `chipStrokeWidth` | int | 0x7f0400e4 | 371 |
| `chipStyle` | int | 0x7f0400e5 | 372 |
| `chipSurfaceColor` | int | 0x7f0400e6 | 373 |
| `circleColor` | int | 0x7f0400e7 | 374 |
| `circleCrop` | int | 0x7f0400e8 | 375 |
| `circleRadius` | int | 0x7f0400e9 | 376 |
| `circular_color` | int | 0x7f0400eb | 378 |
| `circularflow_angles` | int | 0x7f0400ec | 379 |
| `circularflow_defaultAngle` | int | 0x7f0400ed | 380 |
| `circularflow_defaultRadius` | int | 0x7f0400ee | 381 |
| `circularflow_radiusInDP` | int | 0x7f0400ef | 382 |
| `circularflow_viewCenter` | int | 0x7f0400f0 | 383 |
| `circularProgressIndicatorStyle` | int | 0x7f0400ea | 377 |
| `civ_border_color` | int | 0x7f0400f1 | 384 |
| `civ_border_overlay` | int | 0x7f0400f2 | 385 |
| `civ_border_width` | int | 0x7f0400f3 | 386 |
| `civ_circle_background_color` | int | 0x7f0400f4 | 387 |
| `civ_fill_color` | int | 0x7f0400f5 | 388 |
| `clearsTag` | int | 0x7f0400f6 | 389 |
| `clickAction` | int | 0x7f0400f7 | 390 |
| `clockFaceBackgroundColor` | int | 0x7f0400f8 | 391 |
| `clockHandColor` | int | 0x7f0400f9 | 392 |
| `clockIcon` | int | 0x7f0400fa | 393 |
| `clockNumberTextColor` | int | 0x7f0400fb | 394 |
| `closeIcon` | int | 0x7f0400fc | 395 |
| `closeIconEnabled` | int | 0x7f0400fd | 396 |
| `closeIconEndPadding` | int | 0x7f0400fe | 397 |
| `closeIconSize` | int | 0x7f0400ff | 398 |
| `closeIconStartPadding` | int | 0x7f040100 | 399 |
| `closeIconTint` | int | 0x7f040101 | 400 |
| `closeIconVisible` | int | 0x7f040102 | 401 |
| `closeItemLayout` | int | 0x7f040103 | 402 |
| `collapseContentDescription` | int | 0x7f040104 | 403 |
| `collapsedItemMinHeight` | int | 0x7f040106 | 405 |
| `collapsedSize` | int | 0x7f040107 | 406 |
| `collapsedSubtitleTextAppearance` | int | 0x7f040108 | 407 |
| `collapsedSubtitleTextColor` | int | 0x7f040109 | 408 |
| `collapsedTitleGravity` | int | 0x7f04010a | 409 |
| `collapsedTitleGravityMode` | int | 0x7f04010b | 410 |
| `collapsedTitleTextAppearance` | int | 0x7f04010c | 411 |
| `collapsedTitleTextColor` | int | 0x7f04010d | 412 |
| `collapseIcon` | int | 0x7f040105 | 404 |
| `collapsingToolbarLayoutLargeSize` | int | 0x7f04010e | 413 |
| `collapsingToolbarLayoutLargeStyle` | int | 0x7f04010f | 414 |
| `collapsingToolbarLayoutMediumSize` | int | 0x7f040110 | 415 |
| `collapsingToolbarLayoutMediumStyle` | int | 0x7f040111 | 416 |
| `collapsingToolbarLayoutStyle` | int | 0x7f040112 | 417 |
| `color` | int | 0x7f040113 | 418 |
| `colorAccent` | int | 0x7f040114 | 419 |
| `colorBackgroundFloating` | int | 0x7f040115 | 420 |
| `colorButtonNormal` | int | 0x7f040116 | 421 |
| `colorContainer` | int | 0x7f040117 | 422 |
| `colorContainerChecked` | int | 0x7f040118 | 423 |
| `colorContainerUnchecked` | int | 0x7f040119 | 424 |
| `colorControlActivated` | int | 0x7f04011a | 425 |
| `colorControlHighlight` | int | 0x7f04011b | 426 |
| `colorControlNormal` | int | 0x7f04011c | 427 |
| `colorError` | int | 0x7f04011d | 428 |
| `colorErrorContainer` | int | 0x7f04011e | 429 |
| `colorOnBackground` | int | 0x7f04011f | 430 |
| `colorOnContainer` | int | 0x7f040120 | 431 |
| `colorOnContainerChecked` | int | 0x7f040121 | 432 |
| `colorOnContainerUnchecked` | int | 0x7f040122 | 433 |
| `colorOnError` | int | 0x7f040123 | 434 |
| `colorOnErrorContainer` | int | 0x7f040124 | 435 |
| `colorOnPrimary` | int | 0x7f040125 | 436 |
| `colorOnPrimaryContainer` | int | 0x7f040126 | 437 |
| `colorOnPrimaryFixed` | int | 0x7f040127 | 438 |
| `colorOnPrimaryFixedVariant` | int | 0x7f040128 | 439 |
| `colorOnPrimarySurface` | int | 0x7f040129 | 440 |
| `colorOnSecondary` | int | 0x7f04012a | 441 |
| `colorOnSecondaryContainer` | int | 0x7f04012b | 442 |
| `colorOnSecondaryFixed` | int | 0x7f04012c | 443 |
| `colorOnSecondaryFixedVariant` | int | 0x7f04012d | 444 |
| `colorOnSurface` | int | 0x7f04012e | 445 |
| `colorOnSurfaceInverse` | int | 0x7f04012f | 446 |
| `colorOnSurfaceVariant` | int | 0x7f040130 | 447 |
| `colorOnTertiary` | int | 0x7f040131 | 448 |
| `colorOnTertiaryContainer` | int | 0x7f040132 | 449 |
| `colorOnTertiaryFixed` | int | 0x7f040133 | 450 |
| `colorOnTertiaryFixedVariant` | int | 0x7f040134 | 451 |
| `colorOutline` | int | 0x7f040135 | 452 |
| `colorOutlineVariant` | int | 0x7f040136 | 453 |
| `colorPrimary` | int | 0x7f040137 | 454 |
| `colorPrimaryContainer` | int | 0x7f040138 | 455 |
| `colorPrimaryDark` | int | 0x7f040139 | 456 |
| `colorPrimaryFixed` | int | 0x7f04013a | 457 |
| `colorPrimaryFixedDim` | int | 0x7f04013b | 458 |
| `colorPrimaryInverse` | int | 0x7f04013c | 459 |
| `colorPrimarySurface` | int | 0x7f04013d | 460 |
| `colorPrimaryVariant` | int | 0x7f04013e | 461 |
| `colorScheme` | int | 0x7f04013f | 462 |
| `colorSecondary` | int | 0x7f040140 | 463 |
| `colorSecondaryContainer` | int | 0x7f040141 | 464 |
| `colorSecondaryFixed` | int | 0x7f040142 | 465 |
| `colorSecondaryFixedDim` | int | 0x7f040143 | 466 |
| `colorSecondaryVariant` | int | 0x7f040144 | 467 |
| `colorSurface` | int | 0x7f040145 | 468 |
| `colorSurfaceBright` | int | 0x7f040146 | 469 |
| `colorSurfaceContainer` | int | 0x7f040147 | 470 |
| `colorSurfaceContainerHigh` | int | 0x7f040148 | 471 |
| `colorSurfaceContainerHighest` | int | 0x7f040149 | 472 |
| `colorSurfaceContainerLow` | int | 0x7f04014a | 473 |
| `colorSurfaceContainerLowest` | int | 0x7f04014b | 474 |
| `colorSurfaceDim` | int | 0x7f04014c | 475 |
| `colorSurfaceInverse` | int | 0x7f04014d | 476 |
| `colorSurfaceVariant` | int | 0x7f04014e | 477 |
| `colorSwitchThumbNormal` | int | 0x7f04014f | 478 |
| `colorTertiary` | int | 0x7f040150 | 479 |
| `colorTertiaryContainer` | int | 0x7f040151 | 480 |
| `colorTertiaryFixed` | int | 0x7f040152 | 481 |
| `colorTertiaryFixedDim` | int | 0x7f040153 | 482 |
| `com_facebook_auxiliary_view_position` | int | 0x7f040154 | 483 |
| `com_facebook_confirm_logout` | int | 0x7f040155 | 484 |
| `com_facebook_foreground_color` | int | 0x7f040156 | 485 |
| `com_facebook_horizontal_alignment` | int | 0x7f040157 | 486 |
| `com_facebook_is_cropped` | int | 0x7f040158 | 487 |
| `com_facebook_login_button_radius` | int | 0x7f040159 | 488 |
| `com_facebook_login_button_transparency` | int | 0x7f04015a | 489 |
| `com_facebook_login_text` | int | 0x7f04015b | 490 |
| `com_facebook_logout_text` | int | 0x7f04015c | 491 |
| `com_facebook_object_id` | int | 0x7f04015d | 492 |
| `com_facebook_object_type` | int | 0x7f04015e | 493 |
| `com_facebook_preset_size` | int | 0x7f04015f | 494 |
| `com_facebook_style` | int | 0x7f040160 | 495 |
| `com_facebook_tooltip_mode` | int | 0x7f040161 | 496 |
| `commitIcon` | int | 0x7f040162 | 497 |
| `compatShadowEnabled` | int | 0x7f040163 | 498 |
| `constraint_referenced_ids` | int | 0x7f040168 | 503 |
| `constraint_referenced_tags` | int | 0x7f040169 | 504 |
| `constraintRotate` | int | 0x7f040164 | 499 |
| `constraints` | int | 0x7f04016a | 505 |
| `constraintSet` | int | 0x7f040165 | 500 |
| `constraintSetEnd` | int | 0x7f040166 | 501 |
| `constraintSetStart` | int | 0x7f040167 | 502 |
| `containerColor` | int | 0x7f04016b | 506 |
| `containerHeight` | int | 0x7f04016c | 507 |
| `containerIconPadding` | int | 0x7f04016d | 508 |
| `containerIconSize` | int | 0x7f04016e | 509 |
| `containerInsetBottom` | int | 0x7f04016f | 510 |
| `containerInsetLeft` | int | 0x7f040170 | 511 |
| `containerInsetRight` | int | 0x7f040171 | 512 |
| `containerInsetTop` | int | 0x7f040172 | 513 |
| `containerPaddingBottom` | int | 0x7f040173 | 514 |
| `containerPaddingEnd` | int | 0x7f040174 | 515 |
| `containerPaddingStart` | int | 0x7f040175 | 516 |
| `containerPaddingTop` | int | 0x7f040176 | 517 |
| `containerShapeChecked` | int | 0x7f040177 | 518 |
| `containerShapeDefault` | int | 0x7f040178 | 519 |
| `containerShapePressed` | int | 0x7f040179 | 520 |
| `containerStrokeWidth` | int | 0x7f04017a | 521 |
| `containerWidth` | int | 0x7f04017b | 522 |
| `content` | int | 0x7f04017c | 523 |
| `contentDescription` | int | 0x7f04017d | 524 |
| `contentInsetEnd` | int | 0x7f04017e | 525 |
| `contentInsetEndWithActions` | int | 0x7f04017f | 526 |
| `contentInsetLeft` | int | 0x7f040180 | 527 |
| `contentInsetRight` | int | 0x7f040181 | 528 |
| `contentInsetStart` | int | 0x7f040182 | 529 |
| `contentInsetStartWithNavigation` | int | 0x7f040183 | 530 |
| `contentMarginTop` | int | 0x7f040184 | 531 |
| `contentPadding` | int | 0x7f040185 | 532 |
| `contentPaddingBottom` | int | 0x7f040186 | 533 |
| `contentPaddingEnd` | int | 0x7f040187 | 534 |
| `contentPaddingLeft` | int | 0x7f040188 | 535 |
| `contentPaddingRight` | int | 0x7f040189 | 536 |
| `contentPaddingStart` | int | 0x7f04018a | 537 |
| `contentPaddingTop` | int | 0x7f04018b | 538 |
| `contentScrim` | int | 0x7f04018c | 539 |
| `contourColor` | int | 0x7f04018d | 540 |
| `contourSize` | int | 0x7f04018e | 541 |
| `contrast` | int | 0x7f04018f | 542 |
| `control_icon_size` | int | 0x7f040191 | 544 |
| `controlBackground` | int | 0x7f040190 | 543 |
| `controller_layout_id` | int | 0x7f040192 | 545 |
| `coordinatorLayoutStyle` | int | 0x7f040193 | 546 |
| `coplanarSiblingViewId` | int | 0x7f040194 | 547 |
| `cornerFamily` | int | 0x7f040195 | 548 |
| `cornerFamilyBottomLeft` | int | 0x7f040196 | 549 |
| `cornerFamilyBottomRight` | int | 0x7f040197 | 550 |
| `cornerFamilyTopLeft` | int | 0x7f040198 | 551 |
| `cornerFamilyTopRight` | int | 0x7f040199 | 552 |
| `cornerRadius` | int | 0x7f04019a | 553 |
| `cornerSize` | int | 0x7f04019b | 554 |
| `cornerSizeBottomLeft` | int | 0x7f04019c | 555 |
| `cornerSizeBottomRight` | int | 0x7f04019d | 556 |
| `cornerSizeTopLeft` | int | 0x7f04019e | 557 |
| `cornerSizeTopRight` | int | 0x7f04019f | 558 |
| `counterEnabled` | int | 0x7f0401a0 | 559 |
| `counterMaxLength` | int | 0x7f0401a1 | 560 |
| `counterOverflowTextAppearance` | int | 0x7f0401a2 | 561 |
| `counterOverflowTextColor` | int | 0x7f0401a3 | 562 |
| `counterTextAppearance` | int | 0x7f0401a4 | 563 |
| `counterTextColor` | int | 0x7f0401a5 | 564 |
| `crossfade` | int | 0x7f0401a6 | 565 |
| `currentState` | int | 0x7f0401a7 | 566 |
| `cursorColor` | int | 0x7f0401a8 | 567 |
| `cursorErrorColor` | int | 0x7f0401a9 | 568 |
| `curveFit` | int | 0x7f0401aa | 569 |
| `customBoolean` | int | 0x7f0401ab | 570 |
| `customColorDrawableValue` | int | 0x7f0401ac | 571 |
| `customColorValue` | int | 0x7f0401ad | 572 |
| `customDimension` | int | 0x7f0401ae | 573 |
| `customFloatValue` | int | 0x7f0401af | 574 |
| `customIntegerValue` | int | 0x7f0401b0 | 575 |
| `customNavigationLayout` | int | 0x7f0401b1 | 576 |
| `customPixelDimension` | int | 0x7f0401b2 | 577 |
| `customReference` | int | 0x7f0401b3 | 578 |
| `customStringValue` | int | 0x7f0401b4 | 579 |
| `damping` | int | 0x7f0401b5 | 580 |
| `dayInvalidStyle` | int | 0x7f0401b6 | 581 |
| `daySelectedStyle` | int | 0x7f0401b7 | 582 |
| `dayStyle` | int | 0x7f0401b8 | 583 |
| `dayTodayStyle` | int | 0x7f0401b9 | 584 |
| `defaule_preview_icon` | int | 0x7f0401ba | 585 |
| `default_artwork` | int | 0x7f0401c0 | 591 |
| `defaultDuration` | int | 0x7f0401bb | 586 |
| `defaultMarginsEnabled` | int | 0x7f0401bc | 587 |
| `defaultQueryHint` | int | 0x7f0401bd | 588 |
| `defaultScrollFlagsEnabled` | int | 0x7f0401be | 589 |
| `defaultState` | int | 0x7f0401bf | 590 |
| `delayMillis` | int | 0x7f0401c1 | 592 |
| `delete_icon` | int | 0x7f0401c2 | 593 |
| `delete_img` | int | 0x7f0401c3 | 594 |
| `deltaPolarAngle` | int | 0x7f0401c4 | 595 |
| `deltaPolarRadius` | int | 0x7f0401c5 | 596 |
| `deriveConstraintsFrom` | int | 0x7f0401c6 | 597 |
| `device_offline_icon` | int | 0x7f0401c7 | 598 |
| `device_online_icon` | int | 0x7f0401c8 | 599 |
| `dialogCornerRadius` | int | 0x7f0401c9 | 600 |
| `dialogPreferredPadding` | int | 0x7f0401ca | 601 |
| `dialogTheme` | int | 0x7f0401cb | 602 |
| `displayOptions` | int | 0x7f0401cc | 603 |
| `divider` | int | 0x7f0401cd | 604 |
| `divider_color` | int | 0x7f0401d5 | 612 |
| `divider_higiht` | int | 0x7f0401d6 | 613 |
| `dividerColor` | int | 0x7f0401ce | 605 |
| `dividerHorizontal` | int | 0x7f0401cf | 606 |
| `dividerInsetEnd` | int | 0x7f0401d0 | 607 |
| `dividerInsetStart` | int | 0x7f0401d1 | 608 |
| `dividerPadding` | int | 0x7f0401d2 | 609 |
| `dividerThickness` | int | 0x7f0401d3 | 610 |
| `dividerVertical` | int | 0x7f0401d4 | 611 |
| `dockedToolbarStyle` | int | 0x7f0401d7 | 614 |
| `dockedToolbarVibrantStyle` | int | 0x7f0401d8 | 615 |
| `download_bg_line_color` | int | 0x7f0401d9 | 616 |
| `download_bg_line_width` | int | 0x7f0401da | 617 |
| `download_img` | int | 0x7f0401db | 618 |
| `download_line_color` | int | 0x7f0401dc | 619 |
| `download_line_width` | int | 0x7f0401dd | 620 |
| `download_text_color` | int | 0x7f0401de | 621 |
| `download_text_size` | int | 0x7f0401df | 622 |
| `dragDirection` | int | 0x7f0401e0 | 623 |
| `dragScale` | int | 0x7f0401e1 | 624 |
| `dragThreshold` | int | 0x7f0401e2 | 625 |
| `drawableBottomCompat` | int | 0x7f0401e4 | 627 |
| `drawableEndCompat` | int | 0x7f0401e5 | 628 |
| `drawableLeftCompat` | int | 0x7f0401e6 | 629 |
| `drawableRightCompat` | int | 0x7f0401e7 | 630 |
| `drawableSize` | int | 0x7f0401e8 | 631 |
| `drawableStartCompat` | int | 0x7f0401e9 | 632 |
| `drawableTint` | int | 0x7f0401ea | 633 |
| `drawableTintMode` | int | 0x7f0401eb | 634 |
| `drawableTopCompat` | int | 0x7f0401ec | 635 |
| `drawerArrowStyle` | int | 0x7f0401ed | 636 |
| `drawerLayoutCornerSize` | int | 0x7f0401ee | 637 |
| `drawerLayoutStyle` | int | 0x7f0401ef | 638 |
| `drawPath` | int | 0x7f0401e3 | 626 |
| `dropDownBackgroundTint` | int | 0x7f0401f0 | 639 |
| `dropdownListPreferredItemHeight` | int | 0x7f0401f2 | 641 |
| `dropDownListViewStyle` | int | 0x7f0401f1 | 640 |
| `duration` | int | 0x7f0401f3 | 642 |
| `dynamicColorThemeOverlay` | int | 0x7f0401f4 | 643 |
| `edit_bar_background` | int | 0x7f0401f8 | 647 |
| `edit_bar_cancel_all_icon` | int | 0x7f0401f9 | 648 |
| `edit_bar_delete_icon` | int | 0x7f0401fa | 649 |
| `edit_bar_download_icon` | int | 0x7f0401fb | 650 |
| `edit_bar_height` | int | 0x7f0401fc | 651 |
| `edit_bar_select_all_icon` | int | 0x7f0401fd | 652 |
| `editTextBackground` | int | 0x7f0401f5 | 644 |
| `editTextColor` | int | 0x7f0401f6 | 645 |
| `editTextStyle` | int | 0x7f0401f7 | 646 |
| `elevation` | int | 0x7f0401fe | 653 |
| `elevationOverlayAccentColor` | int | 0x7f0401ff | 654 |
| `elevationOverlayColor` | int | 0x7f040200 | 655 |
| `elevationOverlayEnabled` | int | 0x7f040201 | 656 |
| `emojiCompatEnabled` | int | 0x7f040202 | 657 |
| `enable_checked` | int | 0x7f040204 | 659 |
| `enable_delete` | int | 0x7f040205 | 660 |
| `enable_download` | int | 0x7f040206 | 661 |
| `enableEdgeToEdge` | int | 0x7f040203 | 658 |
| `endIconCheckable` | int | 0x7f040207 | 662 |
| `endIconContentDescription` | int | 0x7f040208 | 663 |
| `endIconDrawable` | int | 0x7f040209 | 664 |
| `endIconMinSize` | int | 0x7f04020a | 665 |
| `endIconMode` | int | 0x7f04020b | 666 |
| `endIconScaleType` | int | 0x7f04020c | 667 |
| `endIconTint` | int | 0x7f04020d | 668 |
| `endIconTintMode` | int | 0x7f04020e | 669 |
| `endInsetScrimEnabled` | int | 0x7f04020f | 670 |
| `enforceMaterialTheme` | int | 0x7f040210 | 671 |
| `enforceTextAppearance` | int | 0x7f040211 | 672 |
| `ensureMinTouchTargetSize` | int | 0x7f040212 | 673 |
| `errorAccessibilityLabel` | int | 0x7f040213 | 674 |
| `errorAccessibilityLiveRegion` | int | 0x7f040214 | 675 |
| `errorContentDescription` | int | 0x7f040215 | 676 |
| `errorEnabled` | int | 0x7f040216 | 677 |
| `errorIconDrawable` | int | 0x7f040217 | 678 |
| `errorIconTint` | int | 0x7f040218 | 679 |
| `errorIconTintMode` | int | 0x7f040219 | 680 |
| `errorShown` | int | 0x7f04021a | 681 |
| `errorTextAppearance` | int | 0x7f04021b | 682 |
| `errorTextColor` | int | 0x7f04021c | 683 |
| `expandActivityOverflowButtonDrawable` | int | 0x7f04021d | 684 |
| `expanded` | int | 0x7f04021e | 685 |
| `expandedActiveIndicatorPaddingBottom` | int | 0x7f04021f | 686 |
| `expandedActiveIndicatorPaddingEnd` | int | 0x7f040220 | 687 |
| `expandedActiveIndicatorPaddingStart` | int | 0x7f040221 | 688 |
| `expandedActiveIndicatorPaddingTop` | int | 0x7f040222 | 689 |
| `expandedHeight` | int | 0x7f040223 | 690 |
| `expandedHintEnabled` | int | 0x7f040224 | 691 |
| `expandedItemMinHeight` | int | 0x7f040225 | 692 |
| `expandedMarginHorizontal` | int | 0x7f040226 | 693 |
| `expandedMaxWidth` | int | 0x7f040227 | 694 |
| `expandedMinWidth` | int | 0x7f040228 | 695 |
| `expandedSubtitleTextAppearance` | int | 0x7f040229 | 696 |
| `expandedSubtitleTextColor` | int | 0x7f04022a | 697 |
| `expandedTitleGravity` | int | 0x7f04022b | 698 |
| `expandedTitleMargin` | int | 0x7f04022c | 699 |
| `expandedTitleMarginBottom` | int | 0x7f04022d | 700 |
| `expandedTitleMarginEnd` | int | 0x7f04022e | 701 |
| `expandedTitleMarginStart` | int | 0x7f04022f | 702 |
| `expandedTitleMarginTop` | int | 0x7f040230 | 703 |
| `expandedTitleSpacing` | int | 0x7f040231 | 704 |
| `expandedTitleTextAppearance` | int | 0x7f040232 | 705 |
| `expandedTitleTextColor` | int | 0x7f040233 | 706 |
| `expandedWidth` | int | 0x7f040234 | 707 |
| `extendedFloatingActionButtonLargeStyle` | int | 0x7f040237 | 710 |
| `extendedFloatingActionButtonMediumStyle` | int | 0x7f040238 | 711 |
| `extendedFloatingActionButtonPrimaryStyle` | int | 0x7f040239 | 712 |
| `extendedFloatingActionButtonSecondaryStyle` | int | 0x7f04023a | 713 |
| `extendedFloatingActionButtonSmallStyle` | int | 0x7f04023b | 714 |
| `extendedFloatingActionButtonStyle` | int | 0x7f04023c | 715 |
| `extendedFloatingActionButtonSurfaceStyle` | int | 0x7f04023d | 716 |
| `extendedFloatingActionButtonTertiaryStyle` | int | 0x7f04023e | 717 |
| `extendMotionSpec` | int | 0x7f040235 | 708 |
| `extendStrategy` | int | 0x7f040236 | 709 |
| `extraMultilineHeightEnabled` | int | 0x7f04023f | 718 |
| `fabAlignmentMode` | int | 0x7f040240 | 719 |
| `fabAlignmentModeEndMargin` | int | 0x7f040241 | 720 |
| `fabAnchorMode` | int | 0x7f040242 | 721 |
| `fabAnimationMode` | int | 0x7f040243 | 722 |
| `fabCradleMargin` | int | 0x7f040244 | 723 |
| `fabCradleRoundedCornerRadius` | int | 0x7f040245 | 724 |
| `fabCradleVerticalOffset` | int | 0x7f040246 | 725 |
| `fabCustomSize` | int | 0x7f040247 | 726 |
| `fabSize` | int | 0x7f040248 | 727 |
| `fastScrollEnabled` | int | 0x7f040249 | 728 |
| `fastScrollHorizontalThumbDrawable` | int | 0x7f04024a | 729 |
| `fastScrollHorizontalTrackDrawable` | int | 0x7f04024b | 730 |
| `fastScrollVerticalThumbDrawable` | int | 0x7f04024c | 731 |
| `fastScrollVerticalTrackDrawable` | int | 0x7f04024d | 732 |
| `file_icon` | int | 0x7f04024e | 733 |
| `firstBaselineToTopHeight` | int | 0x7f04024f | 734 |
| `floatingActionButtonLargePrimaryStyle` | int | 0x7f040250 | 735 |
| `floatingActionButtonLargeSecondaryStyle` | int | 0x7f040251 | 736 |
| `floatingActionButtonLargeStyle` | int | 0x7f040252 | 737 |
| `floatingActionButtonLargeSurfaceStyle` | int | 0x7f040253 | 738 |
| `floatingActionButtonLargeTertiaryStyle` | int | 0x7f040254 | 739 |
| `floatingActionButtonMediumStyle` | int | 0x7f040255 | 740 |
| `floatingActionButtonPrimaryStyle` | int | 0x7f040256 | 741 |
| `floatingActionButtonSecondaryStyle` | int | 0x7f040257 | 742 |
| `floatingActionButtonSmallPrimaryStyle` | int | 0x7f040258 | 743 |
| `floatingActionButtonSmallSecondaryStyle` | int | 0x7f040259 | 744 |
| `floatingActionButtonSmallStyle` | int | 0x7f04025a | 745 |
| `floatingActionButtonSmallSurfaceStyle` | int | 0x7f04025b | 746 |
| `floatingActionButtonSmallTertiaryStyle` | int | 0x7f04025c | 747 |
| `floatingActionButtonStyle` | int | 0x7f04025d | 748 |
| `floatingActionButtonSurfaceStyle` | int | 0x7f04025e | 749 |
| `floatingActionButtonTertiaryStyle` | int | 0x7f04025f | 750 |
| `floatingToolbarStyle` | int | 0x7f040260 | 751 |
| `floatingToolbarVibrantStyle` | int | 0x7f040261 | 752 |
| `flow_firstHorizontalBias` | int | 0x7f040262 | 753 |
| `flow_firstHorizontalStyle` | int | 0x7f040263 | 754 |
| `flow_firstVerticalBias` | int | 0x7f040264 | 755 |
| `flow_firstVerticalStyle` | int | 0x7f040265 | 756 |
| `flow_horizontalAlign` | int | 0x7f040266 | 757 |
| `flow_horizontalBias` | int | 0x7f040267 | 758 |
| `flow_horizontalGap` | int | 0x7f040268 | 759 |
| `flow_horizontalStyle` | int | 0x7f040269 | 760 |
| `flow_lastHorizontalBias` | int | 0x7f04026a | 761 |
| `flow_lastHorizontalStyle` | int | 0x7f04026b | 762 |
| `flow_lastVerticalBias` | int | 0x7f04026c | 763 |
| `flow_lastVerticalStyle` | int | 0x7f04026d | 764 |
| `flow_maxElementsWrap` | int | 0x7f04026e | 765 |
| `flow_padding` | int | 0x7f04026f | 766 |
| `flow_verticalAlign` | int | 0x7f040270 | 767 |
| `flow_verticalBias` | int | 0x7f040271 | 768 |
| `flow_verticalGap` | int | 0x7f040272 | 769 |
| `flow_verticalStyle` | int | 0x7f040273 | 770 |
| `flow_wrapMode` | int | 0x7f040274 | 771 |
| `font` | int | 0x7f040275 | 772 |
| `fontFamily` | int | 0x7f040276 | 773 |
| `fontProviderAuthority` | int | 0x7f040277 | 774 |
| `fontProviderCerts` | int | 0x7f040278 | 775 |
| `fontProviderFetchStrategy` | int | 0x7f040279 | 776 |
| `fontProviderFetchTimeout` | int | 0x7f04027a | 777 |
| `fontProviderPackage` | int | 0x7f04027b | 778 |
| `fontProviderQuery` | int | 0x7f04027c | 779 |
| `fontProviderSystemFontFamily` | int | 0x7f04027d | 780 |
| `fontStyle` | int | 0x7f04027e | 781 |
| `fontVariationSettings` | int | 0x7f04027f | 782 |
| `fontWeight` | int | 0x7f040280 | 783 |
| `forceApplySystemWindowInsetTop` | int | 0x7f040281 | 784 |
| `forceDefaultNavigationOnClickListener` | int | 0x7f040282 | 785 |
| `foregroundInsidePadding` | int | 0x7f040283 | 786 |
| `framePosition` | int | 0x7f040284 | 787 |
| `fullscreen_imv` | int | 0x7f040285 | 788 |
| `gapBetweenBars` | int | 0x7f040286 | 789 |
| `gestureInsetBottomIgnored` | int | 0x7f040287 | 790 |
| `goIcon` | int | 0x7f040288 | 791 |
| `grid_columns` | int | 0x7f04028a | 793 |
| `grid_columnWeights` | int | 0x7f040289 | 792 |
| `grid_horizontalGaps` | int | 0x7f04028b | 794 |
| `grid_orientation` | int | 0x7f04028c | 795 |
| `grid_rows` | int | 0x7f04028e | 797 |
| `grid_rowWeights` | int | 0x7f04028d | 796 |
| `grid_skips` | int | 0x7f04028f | 798 |
| `grid_span_count` | int | 0x7f040290 | 799 |
| `grid_spans` | int | 0x7f040291 | 800 |
| `grid_useRtl` | int | 0x7f040292 | 801 |
| `grid_validateInputs` | int | 0x7f040293 | 802 |
| `grid_verticalGaps` | int | 0x7f040294 | 803 |
| `guidelineUseRtl` | int | 0x7f040295 | 804 |
| `haloColor` | int | 0x7f040296 | 805 |
| `haloRadius` | int | 0x7f040297 | 806 |
| `headerLayout` | int | 0x7f040298 | 807 |
| `headerMarginBottom` | int | 0x7f040299 | 808 |
| `height` | int | 0x7f04029a | 809 |
| `helperText` | int | 0x7f04029b | 810 |
| `helperTextEnabled` | int | 0x7f04029c | 811 |
| `helperTextTextAppearance` | int | 0x7f04029d | 812 |
| `helperTextTextColor` | int | 0x7f04029e | 813 |
| `hide_during_ads` | int | 0x7f0402a4 | 819 |
| `hide_on_touch` | int | 0x7f0402a5 | 820 |
| `hideAnimationBehavior` | int | 0x7f04029f | 814 |
| `hideMotionSpec` | int | 0x7f0402a0 | 815 |
| `hideNavigationIcon` | int | 0x7f0402a1 | 816 |
| `hideOnContentScroll` | int | 0x7f0402a2 | 817 |
| `hideOnScroll` | int | 0x7f0402a3 | 818 |
| `hintAnimationEnabled` | int | 0x7f0402a6 | 821 |
| `hintEnabled` | int | 0x7f0402a7 | 822 |
| `hintMaxLines` | int | 0x7f0402a8 | 823 |
| `hintTextAppearance` | int | 0x7f0402a9 | 824 |
| `hintTextColor` | int | 0x7f0402aa | 825 |
| `homeAsUpIndicator` | int | 0x7f0402ab | 826 |
| `homeLayout` | int | 0x7f0402ac | 827 |
| `horizontalItemSpacing` | int | 0x7f0402ad | 828 |
| `horizontalItemTextAppearanceActive` | int | 0x7f0402ae | 829 |
| `horizontalItemTextAppearanceInactive` | int | 0x7f0402af | 830 |
| `horizontalOffset` | int | 0x7f0402b0 | 831 |
| `horizontalOffsetWithText` | int | 0x7f0402b1 | 832 |
| `hoveredFocusedTranslationZ` | int | 0x7f0402b2 | 833 |
| `icon` | int | 0x7f0402b3 | 834 |
| `icon_padding` | int | 0x7f0402bc | 843 |
| `icon_size` | int | 0x7f0402bd | 844 |
| `iconEndPadding` | int | 0x7f0402b4 | 835 |
| `iconGravity` | int | 0x7f0402b5 | 836 |
| `iconifiedByDefault` | int | 0x7f0402be | 845 |
| `iconLabelHorizontalSpacing` | int | 0x7f0402b6 | 837 |
| `iconPadding` | int | 0x7f0402b7 | 838 |
| `iconSize` | int | 0x7f0402b8 | 839 |
| `iconStartPadding` | int | 0x7f0402b9 | 840 |
| `iconTint` | int | 0x7f0402ba | 841 |
| `iconTintMode` | int | 0x7f0402bb | 842 |
| `ifTagNotSet` | int | 0x7f0402bf | 846 |
| `ifTagSet` | int | 0x7f0402c0 | 847 |
| `image_radius` | int | 0x7f0402c8 | 855 |
| `imageAspectRatio` | int | 0x7f0402c1 | 848 |
| `imageAspectRatioAdjust` | int | 0x7f0402c2 | 849 |
| `imageButtonStyle` | int | 0x7f0402c3 | 850 |
| `imagePanX` | int | 0x7f0402c4 | 851 |
| `imagePanY` | int | 0x7f0402c5 | 852 |
| `imageRotate` | int | 0x7f0402c6 | 853 |
| `imageZoom` | int | 0x7f0402c7 | 854 |
| `indeterminateAnimationType` | int | 0x7f0402c9 | 856 |
| `indeterminateAnimationTypeCircular` | int | 0x7f0402ca | 857 |
| `indeterminateAnimatorDurationScale` | int | 0x7f0402cb | 858 |
| `indeterminateProgressStyle` | int | 0x7f0402cc | 859 |
| `indeterminateTrackVisible` | int | 0x7f0402cd | 860 |
| `indicatorColor` | int | 0x7f0402ce | 861 |
| `indicatorDirectionCircular` | int | 0x7f0402cf | 862 |
| `indicatorDirectionLinear` | int | 0x7f0402d0 | 863 |
| `indicatorInset` | int | 0x7f0402d1 | 864 |
| `indicatorSize` | int | 0x7f0402d2 | 865 |
| `indicatorTrackGapSize` | int | 0x7f0402d3 | 866 |
| `initialActivityCount` | int | 0x7f0402d4 | 867 |
| `innerCornerSize` | int | 0x7f0402d5 | 868 |
| `insetForeground` | int | 0x7f0402d6 | 869 |
| `isLightTheme` | int | 0x7f0402d7 | 870 |
| `isMaterial3DynamicColorApplied` | int | 0x7f0402d8 | 871 |
| `isMaterial3Theme` | int | 0x7f0402d9 | 872 |
| `isMaterialTheme` | int | 0x7f0402da | 873 |
| `item_background` | int | 0x7f0402fb | 906 |
| `item_height` | int | 0x7f0402fc | 907 |
| `item_icon` | int | 0x7f0402fd | 908 |
| `item_layout` | int | 0x7f0402fe | 909 |
| `item_padding_left_right` | int | 0x7f0402ff | 910 |
| `item_padding_top_bottom` | int | 0x7f040300 | 911 |
| `itemActiveIndicatorStyle` | int | 0x7f0402db | 874 |
| `itemBackground` | int | 0x7f0402dc | 875 |
| `itemFillColor` | int | 0x7f0402dd | 876 |
| `itemGravity` | int | 0x7f0402de | 877 |
| `itemHorizontalPadding` | int | 0x7f0402df | 878 |
| `itemHorizontalTranslationEnabled` | int | 0x7f0402e0 | 879 |
| `itemIconGravity` | int | 0x7f0402e1 | 880 |
| `itemIconPadding` | int | 0x7f0402e2 | 881 |
| `itemIconSize` | int | 0x7f0402e3 | 882 |
| `itemIconTint` | int | 0x7f0402e4 | 883 |
| `itemMaxLines` | int | 0x7f0402e5 | 884 |
| `itemMinHeight` | int | 0x7f0402e6 | 885 |
| `itemPadding` | int | 0x7f0402e7 | 886 |
| `itemPaddingBottom` | int | 0x7f0402e8 | 887 |
| `itemPaddingTop` | int | 0x7f0402e9 | 888 |
| `itemRippleColor` | int | 0x7f0402ea | 889 |
| `itemShapeAppearance` | int | 0x7f0402eb | 890 |
| `itemShapeAppearanceOverlay` | int | 0x7f0402ec | 891 |
| `itemShapeFillColor` | int | 0x7f0402ed | 892 |
| `itemShapeInsetBottom` | int | 0x7f0402ee | 893 |
| `itemShapeInsetEnd` | int | 0x7f0402ef | 894 |
| `itemShapeInsetStart` | int | 0x7f0402f0 | 895 |
| `itemShapeInsetTop` | int | 0x7f0402f1 | 896 |
| `itemSpacing` | int | 0x7f0402f2 | 897 |
| `itemStrokeColor` | int | 0x7f0402f3 | 898 |
| `itemStrokeWidth` | int | 0x7f0402f4 | 899 |
| `itemTextAppearance` | int | 0x7f0402f5 | 900 |
| `itemTextAppearanceActive` | int | 0x7f0402f6 | 901 |
| `itemTextAppearanceActiveBoldEnabled` | int | 0x7f0402f7 | 902 |
| `itemTextAppearanceInactive` | int | 0x7f0402f8 | 903 |
| `itemTextColor` | int | 0x7f0402f9 | 904 |
| `itemVerticalPadding` | int | 0x7f0402fa | 905 |
| `keep_content_on_player_reset` | int | 0x7f040301 | 912 |
| `keyboardIcon` | int | 0x7f040303 | 914 |
| `keylines` | int | 0x7f040304 | 915 |
| `keyPositionType` | int | 0x7f040302 | 913 |
| `labelBehavior` | int | 0x7f040306 | 917 |
| `labelFontScalingEnabled` | int | 0x7f040307 | 918 |
| `labelMaxLines` | int | 0x7f040308 | 919 |
| `labelStyle` | int | 0x7f040309 | 920 |
| `labelTextAppearance` | int | 0x7f04030a | 921 |
| `labelVisibilityMode` | int | 0x7f04030b | 922 |
| `largeFontVerticalOffsetAdjustment` | int | 0x7f04030c | 923 |
| `lastBaselineToBottomHeight` | int | 0x7f04030d | 924 |
| `lastItemDecorated` | int | 0x7f04030e | 925 |
| `layout` | int | 0x7f04030f | 926 |
| `layout_anchor` | int | 0x7f040313 | 930 |
| `layout_anchorGravity` | int | 0x7f040314 | 931 |
| `layout_behavior` | int | 0x7f040315 | 932 |
| `layout_collapseMode` | int | 0x7f040316 | 933 |
| `layout_collapseParallaxMultiplier` | int | 0x7f040317 | 934 |
| `layout_constrainedHeight` | int | 0x7f040318 | 935 |
| `layout_constrainedWidth` | int | 0x7f040319 | 936 |
| `layout_constraintBaseline_creator` | int | 0x7f04031a | 937 |
| `layout_constraintBaseline_toBaselineOf` | int | 0x7f04031b | 938 |
| `layout_constraintBaseline_toBottomOf` | int | 0x7f04031c | 939 |
| `layout_constraintBaseline_toTopOf` | int | 0x7f04031d | 940 |
| `layout_constraintBottom_creator` | int | 0x7f04031e | 941 |
| `layout_constraintBottom_toBottomOf` | int | 0x7f04031f | 942 |
| `layout_constraintBottom_toTopOf` | int | 0x7f040320 | 943 |
| `layout_constraintCircle` | int | 0x7f040321 | 944 |
| `layout_constraintCircleAngle` | int | 0x7f040322 | 945 |
| `layout_constraintCircleRadius` | int | 0x7f040323 | 946 |
| `layout_constraintDimensionRatio` | int | 0x7f040324 | 947 |
| `layout_constraintEnd_toEndOf` | int | 0x7f040325 | 948 |
| `layout_constraintEnd_toStartOf` | int | 0x7f040326 | 949 |
| `layout_constraintGuide_begin` | int | 0x7f040327 | 950 |
| `layout_constraintGuide_end` | int | 0x7f040328 | 951 |
| `layout_constraintGuide_percent` | int | 0x7f040329 | 952 |
| `layout_constraintHeight` | int | 0x7f04032a | 953 |
| `layout_constraintHeight_default` | int | 0x7f04032b | 954 |
| `layout_constraintHeight_max` | int | 0x7f04032c | 955 |
| `layout_constraintHeight_min` | int | 0x7f04032d | 956 |
| `layout_constraintHeight_percent` | int | 0x7f04032e | 957 |
| `layout_constraintHorizontal_bias` | int | 0x7f04032f | 958 |
| `layout_constraintHorizontal_chainStyle` | int | 0x7f040330 | 959 |
| `layout_constraintHorizontal_weight` | int | 0x7f040331 | 960 |
| `layout_constraintLeft_creator` | int | 0x7f040332 | 961 |
| `layout_constraintLeft_toLeftOf` | int | 0x7f040333 | 962 |
| `layout_constraintLeft_toRightOf` | int | 0x7f040334 | 963 |
| `layout_constraintRight_creator` | int | 0x7f040335 | 964 |
| `layout_constraintRight_toLeftOf` | int | 0x7f040336 | 965 |
| `layout_constraintRight_toRightOf` | int | 0x7f040337 | 966 |
| `layout_constraintStart_toEndOf` | int | 0x7f040338 | 967 |
| `layout_constraintStart_toStartOf` | int | 0x7f040339 | 968 |
| `layout_constraintTag` | int | 0x7f04033a | 969 |
| `layout_constraintTop_creator` | int | 0x7f04033b | 970 |
| `layout_constraintTop_toBottomOf` | int | 0x7f04033c | 971 |
| `layout_constraintTop_toTopOf` | int | 0x7f04033d | 972 |
| `layout_constraintVertical_bias` | int | 0x7f04033e | 973 |
| `layout_constraintVertical_chainStyle` | int | 0x7f04033f | 974 |
| `layout_constraintVertical_weight` | int | 0x7f040340 | 975 |
| `layout_constraintWidth` | int | 0x7f040341 | 976 |
| `layout_constraintWidth_default` | int | 0x7f040342 | 977 |
| `layout_constraintWidth_max` | int | 0x7f040343 | 978 |
| `layout_constraintWidth_min` | int | 0x7f040344 | 979 |
| `layout_constraintWidth_percent` | int | 0x7f040345 | 980 |
| `layout_dodgeInsetEdges` | int | 0x7f040346 | 981 |
| `layout_editor_absoluteX` | int | 0x7f040347 | 982 |
| `layout_editor_absoluteY` | int | 0x7f040348 | 983 |
| `layout_goneMarginBaseline` | int | 0x7f040349 | 984 |
| `layout_goneMarginBottom` | int | 0x7f04034a | 985 |
| `layout_goneMarginEnd` | int | 0x7f04034b | 986 |
| `layout_goneMarginLeft` | int | 0x7f04034c | 987 |
| `layout_goneMarginRight` | int | 0x7f04034d | 988 |
| `layout_goneMarginStart` | int | 0x7f04034e | 989 |
| `layout_goneMarginTop` | int | 0x7f04034f | 990 |
| `layout_insetEdge` | int | 0x7f040350 | 991 |
| `layout_keyline` | int | 0x7f040351 | 992 |
| `layout_marginBaseline` | int | 0x7f040352 | 993 |
| `layout_optimizationLevel` | int | 0x7f040353 | 994 |
| `layout_scrollEffect` | int | 0x7f040354 | 995 |
| `layout_scrollFlags` | int | 0x7f040355 | 996 |
| `layout_scrollInterpolator` | int | 0x7f040356 | 997 |
| `layout_type` | int | 0x7f040357 | 998 |
| `layout_wrapBehaviorInParent` | int | 0x7f040358 | 999 |
| `layoutDescription` | int | 0x7f040310 | 927 |
| `layoutDuringTransition` | int | 0x7f040311 | 928 |
| `layoutManager` | int | 0x7f040312 | 929 |
| `liftOnScroll` | int | 0x7f040359 | 1000 |
| `liftOnScrollColor` | int | 0x7f04035a | 1001 |
| `liftOnScrollTargetViewId` | int | 0x7f04035b | 1002 |
| `limitBoundsTo` | int | 0x7f04035c | 1003 |
| `linearProgressIndicatorStyle` | int | 0x7f04035f | 1006 |
| `lineHeight` | int | 0x7f04035d | 1004 |
| `lineSpacing` | int | 0x7f04035e | 1005 |
| `listChoiceBackgroundIndicator` | int | 0x7f040360 | 1007 |
| `listChoiceIndicatorMultipleAnimated` | int | 0x7f040361 | 1008 |
| `listChoiceIndicatorSingleAnimated` | int | 0x7f040362 | 1009 |
| `listDividerAlertDialog` | int | 0x7f040363 | 1010 |
| `listItemLayout` | int | 0x7f040364 | 1011 |
| `listLayout` | int | 0x7f040365 | 1012 |
| `listMenuViewStyle` | int | 0x7f040366 | 1013 |
| `listPopupWindowStyle` | int | 0x7f040367 | 1014 |
| `listPreferredItemHeight` | int | 0x7f040368 | 1015 |
| `listPreferredItemHeightLarge` | int | 0x7f040369 | 1016 |
| `listPreferredItemHeightSmall` | int | 0x7f04036a | 1017 |
| `listPreferredItemPaddingEnd` | int | 0x7f04036b | 1018 |
| `listPreferredItemPaddingLeft` | int | 0x7f04036c | 1019 |
| `listPreferredItemPaddingRight` | int | 0x7f04036d | 1020 |
| `listPreferredItemPaddingStart` | int | 0x7f04036e | 1021 |
| `loadingIndicatorStyle` | int | 0x7f04036f | 1022 |
| `logo` | int | 0x7f040370 | 1023 |
| `logoAdjustViewBounds` | int | 0x7f040371 | 1024 |
| `logoDescription` | int | 0x7f040372 | 1025 |
| `logoScaleType` | int | 0x7f040373 | 1026 |
| `lStar` | int | 0x7f040305 | 916 |
| `marginBottomSystemWindowInsets` | int | 0x7f040374 | 1027 |
| `marginHorizontal` | int | 0x7f040375 | 1028 |
| `marginLeftSystemWindowInsets` | int | 0x7f040376 | 1029 |
| `marginRightSystemWindowInsets` | int | 0x7f040377 | 1030 |
| `marginTopSystemWindowInsets` | int | 0x7f040378 | 1031 |
| `materialAlertDialogBodyTextStyle` | int | 0x7f040379 | 1032 |
| `materialAlertDialogButtonSpacerVisibility` | int | 0x7f04037a | 1033 |
| `materialAlertDialogTheme` | int | 0x7f04037b | 1034 |
| `materialAlertDialogTitleIconStyle` | int | 0x7f04037c | 1035 |
| `materialAlertDialogTitlePanelStyle` | int | 0x7f04037d | 1036 |
| `materialAlertDialogTitleTextStyle` | int | 0x7f04037e | 1037 |
| `materialButtonElevatedStyle` | int | 0x7f04037f | 1038 |
| `materialButtonGroupStyle` | int | 0x7f040380 | 1039 |
| `materialButtonOutlinedStyle` | int | 0x7f040381 | 1040 |
| `materialButtonStyle` | int | 0x7f040382 | 1041 |
| `materialButtonToggleGroupStyle` | int | 0x7f040383 | 1042 |
| `materialButtonTonalStyle` | int | 0x7f040384 | 1043 |
| `materialCalendarDay` | int | 0x7f040385 | 1044 |
| `materialCalendarDayOfWeekLabel` | int | 0x7f040386 | 1045 |
| `materialCalendarFullscreenTheme` | int | 0x7f040387 | 1046 |
| `materialCalendarHeaderCancelButton` | int | 0x7f040388 | 1047 |
| `materialCalendarHeaderConfirmButton` | int | 0x7f040389 | 1048 |
| `materialCalendarHeaderDivider` | int | 0x7f04038a | 1049 |
| `materialCalendarHeaderLayout` | int | 0x7f04038b | 1050 |
| `materialCalendarHeaderSelection` | int | 0x7f04038c | 1051 |
| `materialCalendarHeaderTitle` | int | 0x7f04038d | 1052 |
| `materialCalendarHeaderToggleButton` | int | 0x7f04038e | 1053 |
| `materialCalendarMonth` | int | 0x7f04038f | 1054 |
| `materialCalendarMonthNavigationButton` | int | 0x7f040390 | 1055 |
| `materialCalendarStyle` | int | 0x7f040391 | 1056 |
| `materialCalendarTheme` | int | 0x7f040392 | 1057 |
| `materialCalendarYearNavigationButton` | int | 0x7f040393 | 1058 |
| `materialCardViewElevatedStyle` | int | 0x7f040394 | 1059 |
| `materialCardViewFilledStyle` | int | 0x7f040395 | 1060 |
| `materialCardViewOutlinedStyle` | int | 0x7f040396 | 1061 |
| `materialCardViewStyle` | int | 0x7f040397 | 1062 |
| `materialCircleRadius` | int | 0x7f040398 | 1063 |
| `materialClockStyle` | int | 0x7f040399 | 1064 |
| `materialDisplayDividerStyle` | int | 0x7f04039a | 1065 |
| `materialDividerHeavyStyle` | int | 0x7f04039b | 1066 |
| `materialDividerStyle` | int | 0x7f04039c | 1067 |
| `materialIconButtonFilledStyle` | int | 0x7f04039d | 1068 |
| `materialIconButtonFilledTonalStyle` | int | 0x7f04039e | 1069 |
| `materialIconButtonOutlinedStyle` | int | 0x7f04039f | 1070 |
| `materialIconButtonStyle` | int | 0x7f0403a0 | 1071 |
| `materialSearchBarStyle` | int | 0x7f0403a1 | 1072 |
| `materialSearchViewPrefixStyle` | int | 0x7f0403a2 | 1073 |
| `materialSearchViewStyle` | int | 0x7f0403a3 | 1074 |
| `materialSearchViewToolbarHeight` | int | 0x7f0403a4 | 1075 |
| `materialSearchViewToolbarStyle` | int | 0x7f0403a5 | 1076 |
| `materialSizeOverlay` | int | 0x7f0403a6 | 1077 |
| `materialSplitButtonIconFilledStyle` | int | 0x7f0403a7 | 1078 |
| `materialSplitButtonIconFilledTonalStyle` | int | 0x7f0403a8 | 1079 |
| `materialSplitButtonLeadingFilledStyle` | int | 0x7f0403a9 | 1080 |
| `materialSplitButtonLeadingFilledTonalStyle` | int | 0x7f0403aa | 1081 |
| `materialSplitButtonStyle` | int | 0x7f0403ab | 1082 |
| `materialSwitchStyle` | int | 0x7f0403ac | 1083 |
| `materialThemeOverlay` | int | 0x7f0403ad | 1084 |
| `materialTimePickerStyle` | int | 0x7f0403ae | 1085 |
| `materialTimePickerTheme` | int | 0x7f0403af | 1086 |
| `materialTimePickerTitleStyle` | int | 0x7f0403b0 | 1087 |
| `maxAcceleration` | int | 0x7f0403b1 | 1088 |
| `maxActionInlineWidth` | int | 0x7f0403b2 | 1089 |
| `maxButtonHeight` | int | 0x7f0403b3 | 1090 |
| `maxCharacterCount` | int | 0x7f0403b4 | 1091 |
| `maxHeight` | int | 0x7f0403b5 | 1092 |
| `maxImageSize` | int | 0x7f0403b6 | 1093 |
| `maxLines` | int | 0x7f0403b7 | 1094 |
| `maxNumber` | int | 0x7f0403b8 | 1095 |
| `maxVelocity` | int | 0x7f0403b9 | 1096 |
| `maxWidth` | int | 0x7f0403ba | 1097 |
| `measureBottomPaddingFromLabelBaseline` | int | 0x7f0403bb | 1098 |
| `measureWithLargestChild` | int | 0x7f0403bc | 1099 |
| `menu` | int | 0x7f0403bd | 1100 |
| `menuAlignmentMode` | int | 0x7f0403be | 1101 |
| `menuGravity` | int | 0x7f0403bf | 1102 |
| `message_icon` | int | 0x7f0403c0 | 1103 |
| `metaButtonBarButtonStyle` | int | 0x7f0403c1 | 1104 |
| `metaButtonBarStyle` | int | 0x7f0403c2 | 1105 |
| `methodName` | int | 0x7f0403c3 | 1106 |
| `minHeight` | int | 0x7f0403c4 | 1107 |
| `minHideDelay` | int | 0x7f0403c5 | 1108 |
| `minSeparation` | int | 0x7f0403c6 | 1109 |
| `minTouchTargetSize` | int | 0x7f0403c7 | 1110 |
| `minWidth` | int | 0x7f0403c8 | 1111 |
| `mock_diagonalsColor` | int | 0x7f0403c9 | 1112 |
| `mock_label` | int | 0x7f0403ca | 1113 |
| `mock_labelBackgroundColor` | int | 0x7f0403cb | 1114 |
| `mock_labelColor` | int | 0x7f0403cc | 1115 |
| `mock_showDiagonals` | int | 0x7f0403cd | 1116 |
| `mock_showLabel` | int | 0x7f0403ce | 1117 |
| `motion_postLayoutCollision` | int | 0x7f040400 | 1167 |
| `motion_triggerOnCollision` | int | 0x7f040401 | 1168 |
| `motionDebug` | int | 0x7f0403cf | 1118 |
| `motionDurationExtraLong1` | int | 0x7f0403d0 | 1119 |
| `motionDurationExtraLong2` | int | 0x7f0403d1 | 1120 |
| `motionDurationExtraLong3` | int | 0x7f0403d2 | 1121 |
| `motionDurationExtraLong4` | int | 0x7f0403d3 | 1122 |
| `motionDurationLong1` | int | 0x7f0403d4 | 1123 |
| `motionDurationLong2` | int | 0x7f0403d5 | 1124 |
| `motionDurationLong3` | int | 0x7f0403d6 | 1125 |
| `motionDurationLong4` | int | 0x7f0403d7 | 1126 |
| `motionDurationMedium1` | int | 0x7f0403d8 | 1127 |
| `motionDurationMedium2` | int | 0x7f0403d9 | 1128 |
| `motionDurationMedium3` | int | 0x7f0403da | 1129 |
| `motionDurationMedium4` | int | 0x7f0403db | 1130 |
| `motionDurationShort1` | int | 0x7f0403dc | 1131 |
| `motionDurationShort2` | int | 0x7f0403dd | 1132 |
| `motionDurationShort3` | int | 0x7f0403de | 1133 |
| `motionDurationShort4` | int | 0x7f0403df | 1134 |
| `motionEasingAccelerated` | int | 0x7f0403e0 | 1135 |
| `motionEasingDecelerated` | int | 0x7f0403e1 | 1136 |
| `motionEasingEmphasized` | int | 0x7f0403e2 | 1137 |
| `motionEasingEmphasizedAccelerateInterpolator` | int | 0x7f0403e3 | 1138 |
| `motionEasingEmphasizedDecelerateInterpolator` | int | 0x7f0403e4 | 1139 |
| `motionEasingEmphasizedInterpolator` | int | 0x7f0403e5 | 1140 |
| `motionEasingLinear` | int | 0x7f0403e6 | 1141 |
| `motionEasingLinearInterpolator` | int | 0x7f0403e7 | 1142 |
| `motionEasingStandard` | int | 0x7f0403e8 | 1143 |
| `motionEasingStandardAccelerateInterpolator` | int | 0x7f0403e9 | 1144 |
| `motionEasingStandardDecelerateInterpolator` | int | 0x7f0403ea | 1145 |
| `motionEasingStandardInterpolator` | int | 0x7f0403eb | 1146 |
| `motionEffect_alpha` | int | 0x7f0403ec | 1147 |
| `motionEffect_end` | int | 0x7f0403ed | 1148 |
| `motionEffect_move` | int | 0x7f0403ee | 1149 |
| `motionEffect_start` | int | 0x7f0403ef | 1150 |
| `motionEffect_strict` | int | 0x7f0403f0 | 1151 |
| `motionEffect_translationX` | int | 0x7f0403f1 | 1152 |
| `motionEffect_translationY` | int | 0x7f0403f2 | 1153 |
| `motionEffect_viewTransition` | int | 0x7f0403f3 | 1154 |
| `motionInterpolator` | int | 0x7f0403f4 | 1155 |
| `motionPath` | int | 0x7f0403f5 | 1156 |
| `motionPathRotate` | int | 0x7f0403f6 | 1157 |
| `motionProgress` | int | 0x7f0403f7 | 1158 |
| `motionSpringDefaultEffects` | int | 0x7f0403f8 | 1159 |
| `motionSpringDefaultSpatial` | int | 0x7f0403f9 | 1160 |
| `motionSpringFastEffects` | int | 0x7f0403fa | 1161 |
| `motionSpringFastSpatial` | int | 0x7f0403fb | 1162 |
| `motionSpringSlowEffects` | int | 0x7f0403fc | 1163 |
| `motionSpringSlowSpatial` | int | 0x7f0403fd | 1164 |
| `motionStagger` | int | 0x7f0403fe | 1165 |
| `motionTarget` | int | 0x7f0403ff | 1166 |
| `moveWhenScrollAtTop` | int | 0x7f040402 | 1169 |
| `multiChoiceItemLayout` | int | 0x7f040403 | 1170 |
| `navigationContentDescription` | int | 0x7f040404 | 1171 |
| `navigationIcon` | int | 0x7f040405 | 1172 |
| `navigationIconTint` | int | 0x7f040406 | 1173 |
| `navigationMode` | int | 0x7f040407 | 1174 |
| `navigationRailStyle` | int | 0x7f040408 | 1175 |
| `navigationViewStyle` | int | 0x7f040409 | 1176 |
| `nestedScrollable` | int | 0x7f04040c | 1179 |
| `nestedScrollFlags` | int | 0x7f04040a | 1177 |
| `nestedScrollViewStyle` | int | 0x7f04040b | 1178 |
| `number` | int | 0x7f04040d | 1180 |
| `numberProgressBarStyle` | int | 0x7f04040e | 1181 |
| `numericModifiers` | int | 0x7f04040f | 1182 |
| `offsetAlignmentMode` | int | 0x7f040410 | 1183 |
| `onCross` | int | 0x7f040411 | 1184 |
| `onHide` | int | 0x7f040412 | 1185 |
| `onNegativeCross` | int | 0x7f040413 | 1186 |
| `onPositiveCross` | int | 0x7f040414 | 1187 |
| `onShow` | int | 0x7f040415 | 1188 |
| `onStateTransition` | int | 0x7f040416 | 1189 |
| `onTouchUp` | int | 0x7f040417 | 1190 |
| `opticalCenterEnabled` | int | 0x7f040418 | 1191 |
| `overlapAnchor` | int | 0x7f040419 | 1192 |
| `overlay` | int | 0x7f04041a | 1193 |
| `paddingBottomNoButtons` | int | 0x7f04041b | 1194 |
| `paddingBottomSystemWindowInsets` | int | 0x7f04041c | 1195 |
| `paddingEnd` | int | 0x7f04041d | 1196 |
| `paddingLeftSystemWindowInsets` | int | 0x7f04041e | 1197 |
| `paddingRightSystemWindowInsets` | int | 0x7f04041f | 1198 |
| `paddingStart` | int | 0x7f040420 | 1199 |
| `paddingStartSystemWindowInsets` | int | 0x7f040421 | 1200 |
| `paddingTopNoTitle` | int | 0x7f040422 | 1201 |
| `paddingTopSystemWindowInsets` | int | 0x7f040423 | 1202 |
| `panelBackground` | int | 0x7f040424 | 1203 |
| `panelMenuListTheme` | int | 0x7f040425 | 1204 |
| `panelMenuListWidth` | int | 0x7f040426 | 1205 |
| `passwordToggleContentDescription` | int | 0x7f040427 | 1206 |
| `passwordToggleDrawable` | int | 0x7f040428 | 1207 |
| `passwordToggleEnabled` | int | 0x7f040429 | 1208 |
| `passwordToggleTint` | int | 0x7f04042a | 1209 |
| `passwordToggleTintMode` | int | 0x7f04042b | 1210 |
| `path_percent` | int | 0x7f04042d | 1212 |
| `pathMotionArc` | int | 0x7f04042c | 1211 |
| `percentHeight` | int | 0x7f04042e | 1213 |
| `percentWidth` | int | 0x7f04042f | 1214 |
| `percentX` | int | 0x7f040430 | 1215 |
| `percentY` | int | 0x7f040431 | 1216 |
| `perpendicularPath_percent` | int | 0x7f040432 | 1217 |
| `perview_player_layout_id` | int | 0x7f040433 | 1218 |
| `pivotAnchor` | int | 0x7f040434 | 1219 |
| `placeholder_emptyVisibility` | int | 0x7f040438 | 1223 |
| `placeholderText` | int | 0x7f040435 | 1220 |
| `placeholderTextAppearance` | int | 0x7f040436 | 1221 |
| `placeholderTextColor` | int | 0x7f040437 | 1222 |
| `play_bg_line_color` | int | 0x7f040439 | 1224 |
| `play_bg_line_width` | int | 0x7f04043a | 1225 |
| `play_icon` | int | 0x7f04043b | 1226 |
| `play_line_color` | int | 0x7f04043c | 1227 |
| `play_line_width` | int | 0x7f04043d | 1228 |
| `played_ad_marker_color` | int | 0x7f04043e | 1229 |
| `played_color` | int | 0x7f04043f | 1230 |
| `player_layout_id` | int | 0x7f040440 | 1231 |
| `polarRelativeTo` | int | 0x7f040441 | 1232 |
| `popupMenuBackground` | int | 0x7f040442 | 1233 |
| `popupMenuStyle` | int | 0x7f040443 | 1234 |
| `popupTheme` | int | 0x7f040444 | 1235 |
| `popupWindowStyle` | int | 0x7f040445 | 1236 |
| `prefixText` | int | 0x7f040446 | 1237 |
| `prefixTextAppearance` | int | 0x7f040447 | 1238 |
| `prefixTextColor` | int | 0x7f040448 | 1239 |
| `preserveIconSpacing` | int | 0x7f040449 | 1240 |
| `pressedTranslationZ` | int | 0x7f04044a | 1241 |
| `preview_back_icon` | int | 0x7f04044b | 1242 |
| `preview_buttombar_background` | int | 0x7f04044c | 1243 |
| `preview_buttombar_height` | int | 0x7f04044d | 1244 |
| `preview_buttombar_visibility` | int | 0x7f04044e | 1245 |
| `preview_fullscreen_enter_icon` | int | 0x7f040450 | 1247 |
| `preview_fullscreen_exit_icon` | int | 0x7f040451 | 1248 |
| `preview_fullScreen_img_btn_visibility` | int | 0x7f04044f | 1246 |
| `preview_render_type` | int | 0x7f040452 | 1249 |
| `preview_show_size_btn` | int | 0x7f040453 | 1250 |
| `preview_surface_type` | int | 0x7f040454 | 1251 |
| `preview_time_color` | int | 0x7f040455 | 1252 |
| `preview_time_size` | int | 0x7f040456 | 1253 |
| `preview_title` | int | 0x7f040457 | 1254 |
| `preview_title_color` | int | 0x7f040458 | 1255 |
| `preview_topbar_background` | int | 0x7f040459 | 1256 |
| `preview_topbar_height` | int | 0x7f04045a | 1257 |
| `preview_topbar_visibility` | int | 0x7f04045b | 1258 |
| `progress_current` | int | 0x7f04045e | 1261 |
| `progress_max` | int | 0x7f04045f | 1262 |
| `progress_reached_bar_height` | int | 0x7f040460 | 1263 |
| `progress_reached_color` | int | 0x7f040461 | 1264 |
| `progress_text_color` | int | 0x7f040462 | 1265 |
| `progress_text_offset` | int | 0x7f040463 | 1266 |
| `progress_text_size` | int | 0x7f040464 | 1267 |
| `progress_text_visibility` | int | 0x7f040465 | 1268 |
| `progress_unreached_bar_height` | int | 0x7f040466 | 1269 |
| `progress_unreached_color` | int | 0x7f040467 | 1270 |
| `progressBarPadding` | int | 0x7f04045c | 1259 |
| `progressBarStyle` | int | 0x7f04045d | 1260 |
| `ptrAdapterViewBackground` | int | 0x7f040468 | 1271 |
| `ptrAnimationStyle` | int | 0x7f040469 | 1272 |
| `ptrDrawable` | int | 0x7f04046a | 1273 |
| `ptrDrawableBottom` | int | 0x7f04046b | 1274 |
| `ptrDrawableEnd` | int | 0x7f04046c | 1275 |
| `ptrDrawableStart` | int | 0x7f04046d | 1276 |
| `ptrDrawableTop` | int | 0x7f04046e | 1277 |
| `ptrHeaderBackground` | int | 0x7f04046f | 1278 |
| `ptrHeaderSubTextColor` | int | 0x7f040470 | 1279 |
| `ptrHeaderTextAppearance` | int | 0x7f040471 | 1280 |
| `ptrHeaderTextColor` | int | 0x7f040472 | 1281 |
| `ptrListViewExtrasEnabled` | int | 0x7f040473 | 1282 |
| `ptrMode` | int | 0x7f040474 | 1283 |
| `ptrOverScroll` | int | 0x7f040475 | 1284 |
| `ptrRefreshableViewBackground` | int | 0x7f040476 | 1285 |
| `ptrRotateDrawableWhilePulling` | int | 0x7f040477 | 1286 |
| `ptrScrollingWhileRefreshingEnabled` | int | 0x7f040478 | 1287 |
| `ptrShowIndicator` | int | 0x7f040479 | 1288 |
| `ptrSubHeaderTextAppearance` | int | 0x7f04047a | 1289 |
| `pw_radius` | int | 0x7f04047b | 1290 |
| `quantizeMotionInterpolator` | int | 0x7f04047c | 1291 |
| `quantizeMotionPhase` | int | 0x7f04047d | 1292 |
| `quantizeMotionSteps` | int | 0x7f04047e | 1293 |
| `queryBackground` | int | 0x7f04047f | 1294 |
| `queryHint` | int | 0x7f040480 | 1295 |
| `queryPatterns` | int | 0x7f040481 | 1296 |
| `radioButtonStyle` | int | 0x7f040482 | 1297 |
| `rangeFillColor` | int | 0x7f040483 | 1298 |
| `ratingBarStyle` | int | 0x7f040484 | 1299 |
| `ratingBarStyleIndicator` | int | 0x7f040485 | 1300 |
| `ratingBarStyleSmall` | int | 0x7f040486 | 1301 |
| `reactiveGuide_animateChange` | int | 0x7f040487 | 1302 |
| `reactiveGuide_applyToAllConstraintSets` | int | 0x7f040488 | 1303 |
| `reactiveGuide_applyToConstraintSet` | int | 0x7f040489 | 1304 |
| `reactiveGuide_valueId` | int | 0x7f04048a | 1305 |
| `recyclerViewStyle` | int | 0x7f04048b | 1306 |
| `refresh_mode` | int | 0x7f04048c | 1307 |
| `region_heightLessThan` | int | 0x7f04048d | 1308 |
| `region_heightMoreThan` | int | 0x7f04048e | 1309 |
| `region_widthLessThan` | int | 0x7f04048f | 1310 |
| `region_widthMoreThan` | int | 0x7f040490 | 1311 |
| `removeEmbeddedFabElevation` | int | 0x7f040491 | 1312 |
| `repeat_toggle_modes` | int | 0x7f040492 | 1313 |
| `resize_mode` | int | 0x7f040493 | 1314 |
| `reverseLayout` | int | 0x7f040494 | 1315 |
| `right_switch_color` | int | 0x7f040495 | 1316 |
| `right_text_background` | int | 0x7f040496 | 1317 |
| `right_text_color` | int | 0x7f040497 | 1318 |
| `right_text_content` | int | 0x7f040498 | 1319 |
| `right_text_size` | int | 0x7f040499 | 1320 |
| `rimColor` | int | 0x7f04049a | 1321 |
| `rimWidth` | int | 0x7f04049b | 1322 |
| `ripple_auto_running` | int | 0x7f04049d | 1324 |
| `ripple_center_icon` | int | 0x7f04049e | 1325 |
| `ripple_color` | int | 0x7f04049f | 1326 |
| `ripple_count` | int | 0x7f0404a0 | 1327 |
| `ripple_inner_spacing` | int | 0x7f0404a1 | 1328 |
| `ripple_spacing` | int | 0x7f0404a2 | 1329 |
| `rippleColor` | int | 0x7f04049c | 1323 |
| `rotationCenterId` | int | 0x7f0404a3 | 1330 |
| `round` | int | 0x7f0404a4 | 1331 |
| `roundHeight` | int | 0x7f0404a5 | 1332 |
| `roundPercent` | int | 0x7f0404a6 | 1333 |
| `roundWidth` | int | 0x7f0404a7 | 1334 |
| `saturation` | int | 0x7f0404a8 | 1335 |
| `scaleFromTextSize` | int | 0x7f0404a9 | 1336 |
| `scopeUris` | int | 0x7f0404aa | 1337 |
| `scrimAnimationDuration` | int | 0x7f0404ab | 1338 |
| `scrimBackground` | int | 0x7f0404ac | 1339 |
| `scrimVisibleHeightTrigger` | int | 0x7f0404ad | 1340 |
| `scrollingEnabled` | int | 0x7f0404ae | 1341 |
| `scrubber_color` | int | 0x7f0404af | 1342 |
| `scrubber_disabled_size` | int | 0x7f0404b0 | 1343 |
| `scrubber_dragged_size` | int | 0x7f0404b1 | 1344 |
| `scrubber_drawable` | int | 0x7f0404b2 | 1345 |
| `scrubber_enabled_size` | int | 0x7f0404b3 | 1346 |
| `searchHintIcon` | int | 0x7f0404b4 | 1347 |
| `searchIcon` | int | 0x7f0404b5 | 1348 |
| `searchPrefixText` | int | 0x7f0404b6 | 1349 |
| `searchViewStyle` | int | 0x7f0404b7 | 1350 |
| `seekBarStyle` | int | 0x7f0404b8 | 1351 |
| `selectableItemBackground` | int | 0x7f0404b9 | 1352 |
| `selectableItemBackgroundBorderless` | int | 0x7f0404ba | 1353 |
| `selectionRequired` | int | 0x7f0404bb | 1354 |
| `selectorSize` | int | 0x7f0404bc | 1355 |
| `setsTag` | int | 0x7f0404bd | 1356 |
| `setting_icon` | int | 0x7f0404be | 1357 |
| `shapeAppearance` | int | 0x7f0404bf | 1358 |
| `shapeAppearanceCornerExtraExtraLarge` | int | 0x7f0404c0 | 1359 |
| `shapeAppearanceCornerExtraLarge` | int | 0x7f0404c1 | 1360 |
| `shapeAppearanceCornerExtraLargeIncreased` | int | 0x7f0404c2 | 1361 |
| `shapeAppearanceCornerExtraSmall` | int | 0x7f0404c3 | 1362 |
| `shapeAppearanceCornerLarge` | int | 0x7f0404c4 | 1363 |
| `shapeAppearanceCornerLargeIncreased` | int | 0x7f0404c5 | 1364 |
| `shapeAppearanceCornerMedium` | int | 0x7f0404c6 | 1365 |
| `shapeAppearanceCornerSmall` | int | 0x7f0404c7 | 1366 |
| `shapeAppearanceLargeComponent` | int | 0x7f0404c8 | 1367 |
| `shapeAppearanceMediumComponent` | int | 0x7f0404c9 | 1368 |
| `shapeAppearanceOverlay` | int | 0x7f0404ca | 1369 |
| `shapeAppearanceSmallComponent` | int | 0x7f0404cb | 1370 |
| `shapeCornerFamily` | int | 0x7f0404cc | 1371 |
| `shapeCornerSizeExtraExtraLarge` | int | 0x7f0404cd | 1372 |
| `shapeCornerSizeExtraLarge` | int | 0x7f0404ce | 1373 |
| `shapeCornerSizeExtraLargeIncreased` | int | 0x7f0404cf | 1374 |
| `shapeCornerSizeExtraSmall` | int | 0x7f0404d0 | 1375 |
| `shapeCornerSizeLarge` | int | 0x7f0404d1 | 1376 |
| `shapeCornerSizeLargeIncreased` | int | 0x7f0404d2 | 1377 |
| `shapeCornerSizeMedium` | int | 0x7f0404d3 | 1378 |
| `shapeCornerSizeSmall` | int | 0x7f0404d4 | 1379 |
| `share_icon` | int | 0x7f0404d5 | 1380 |
| `SharedValue` | int | 0x7f040000 | 143 |
| `SharedValueId` | int | 0x7f040001 | 144 |
| `shortcutMatchRequired` | int | 0x7f0404d6 | 1381 |
| `shouldRemoveExpandedCorners` | int | 0x7f0404d7 | 1382 |
| `show_arrow_right` | int | 0x7f0404e1 | 1392 |
| `show_buffering` | int | 0x7f0404e2 | 1393 |
| `show_divider_bottom` | int | 0x7f0404e3 | 1394 |
| `show_divider_top` | int | 0x7f0404e4 | 1395 |
| `show_fastforward_button` | int | 0x7f0404e5 | 1396 |
| `show_group` | int | 0x7f0404e6 | 1397 |
| `show_icon` | int | 0x7f0404e7 | 1398 |
| `show_next_button` | int | 0x7f0404e8 | 1399 |
| `show_previous_button` | int | 0x7f0404e9 | 1400 |
| `show_rewind_button` | int | 0x7f0404ea | 1401 |
| `show_right_switch` | int | 0x7f0404eb | 1402 |
| `show_right_text` | int | 0x7f0404ec | 1403 |
| `show_shuffle_button` | int | 0x7f0404ed | 1404 |
| `show_subtitle_button` | int | 0x7f0404ee | 1405 |
| `show_timeout` | int | 0x7f0404ef | 1406 |
| `show_vr_button` | int | 0x7f0404f0 | 1407 |
| `showAnimationBehavior` | int | 0x7f0404d8 | 1383 |
| `showAsAction` | int | 0x7f0404d9 | 1384 |
| `showDelay` | int | 0x7f0404da | 1385 |
| `showDividers` | int | 0x7f0404db | 1386 |
| `showMarker` | int | 0x7f0404dc | 1387 |
| `showMotionSpec` | int | 0x7f0404dd | 1388 |
| `showPaths` | int | 0x7f0404de | 1389 |
| `showText` | int | 0x7f0404df | 1390 |
| `showTitle` | int | 0x7f0404e0 | 1391 |
| `shrinkMotionSpec` | int | 0x7f0404f1 | 1408 |
| `shutter_background_color` | int | 0x7f0404f2 | 1409 |
| `sideSheetDialogTheme` | int | 0x7f0404f3 | 1410 |
| `sideSheetModalStyle` | int | 0x7f0404f4 | 1411 |
| `simpleItemLayout` | int | 0x7f0404f5 | 1412 |
| `simpleItems` | int | 0x7f0404f8 | 1415 |
| `simpleItemSelectedColor` | int | 0x7f0404f6 | 1413 |
| `simpleItemSelectedRippleColor` | int | 0x7f0404f7 | 1414 |
| `singleChoiceItemLayout` | int | 0x7f0404f9 | 1416 |
| `singleLine` | int | 0x7f0404fa | 1417 |
| `singleSelection` | int | 0x7f0404fb | 1418 |
| `sizePercent` | int | 0x7f0404fc | 1419 |
| `sliderStyle` | int | 0x7f0404fd | 1420 |
| `snackbarButtonStyle` | int | 0x7f0404fe | 1421 |
| `snackbarStyle` | int | 0x7f0404ff | 1422 |
| `snackbarTextViewStyle` | int | 0x7f040500 | 1423 |
| `spanCount` | int | 0x7f040501 | 1424 |
| `spinBars` | int | 0x7f040502 | 1425 |
| `spinnerDropDownItemStyle` | int | 0x7f040504 | 1427 |
| `spinnerStyle` | int | 0x7f040505 | 1428 |
| `spinSpeed` | int | 0x7f040503 | 1426 |
| `splitTrack` | int | 0x7f040506 | 1429 |
| `springBoundary` | int | 0x7f040507 | 1430 |
| `springDamping` | int | 0x7f040508 | 1431 |
| `springMass` | int | 0x7f040509 | 1432 |
| `springStiffness` | int | 0x7f04050a | 1433 |
| `springStopThreshold` | int | 0x7f04050b | 1434 |
| `srcCompat` | int | 0x7f04050c | 1435 |
| `stackFromEnd` | int | 0x7f04050d | 1436 |
| `staggered` | int | 0x7f04050e | 1437 |
| `startIconCheckable` | int | 0x7f04050f | 1438 |
| `startIconContentDescription` | int | 0x7f040510 | 1439 |
| `startIconDrawable` | int | 0x7f040511 | 1440 |
| `startIconMinSize` | int | 0x7f040512 | 1441 |
| `startIconScaleType` | int | 0x7f040513 | 1442 |
| `startIconTint` | int | 0x7f040514 | 1443 |
| `startIconTintMode` | int | 0x7f040515 | 1444 |
| `startInsetScrimEnabled` | int | 0x7f040516 | 1445 |
| `state_above_anchor` | int | 0x7f040518 | 1447 |
| `state_collapsed` | int | 0x7f040519 | 1448 |
| `state_collapsible` | int | 0x7f04051a | 1449 |
| `state_dragged` | int | 0x7f04051b | 1450 |
| `state_error` | int | 0x7f04051c | 1451 |
| `state_indeterminate` | int | 0x7f04051d | 1452 |
| `state_liftable` | int | 0x7f04051e | 1453 |
| `state_lifted` | int | 0x7f04051f | 1454 |
| `state_with_icon` | int | 0x7f040520 | 1455 |
| `stateLabels` | int | 0x7f040517 | 1446 |
| `statusBarBackground` | int | 0x7f040521 | 1456 |
| `statusBarForeground` | int | 0x7f040522 | 1457 |
| `statusBarScrim` | int | 0x7f040523 | 1458 |
| `stiffness` | int | 0x7f040524 | 1459 |
| `strokeColor` | int | 0x7f040525 | 1460 |
| `strokeWidth` | int | 0x7f040526 | 1461 |
| `subheaderColor` | int | 0x7f040528 | 1463 |
| `subheaderInsetEnd` | int | 0x7f040529 | 1464 |
| `subheaderInsetStart` | int | 0x7f04052a | 1465 |
| `subheaderTextAppearance` | int | 0x7f04052b | 1466 |
| `subMenuArrow` | int | 0x7f040527 | 1462 |
| `submenuDividersEnabled` | int | 0x7f04052c | 1467 |
| `submitBackground` | int | 0x7f04052d | 1468 |
| `subtitle` | int | 0x7f04052e | 1469 |
| `subtitleCentered` | int | 0x7f04052f | 1470 |
| `subtitleMaxLines` | int | 0x7f040530 | 1471 |
| `subtitleTextAppearance` | int | 0x7f040531 | 1472 |
| `subtitleTextColor` | int | 0x7f040532 | 1473 |
| `subtitleTextStyle` | int | 0x7f040533 | 1474 |
| `suffixText` | int | 0x7f040534 | 1475 |
| `suffixTextAppearance` | int | 0x7f040535 | 1476 |
| `suffixTextColor` | int | 0x7f040536 | 1477 |
| `suggestionRowLayout` | int | 0x7f040537 | 1478 |
| `surface_type` | int | 0x7f040538 | 1479 |
| `switchMinWidth` | int | 0x7f040539 | 1480 |
| `switchPadding` | int | 0x7f04053a | 1481 |
| `switchStyle` | int | 0x7f04053b | 1482 |
| `switchTextAppearance` | int | 0x7f04053c | 1483 |
| `tabBackground` | int | 0x7f04053d | 1484 |
| `tabContentStart` | int | 0x7f04053e | 1485 |
| `tabGravity` | int | 0x7f04053f | 1486 |
| `tabIconTint` | int | 0x7f040540 | 1487 |
| `tabIconTintMode` | int | 0x7f040541 | 1488 |
| `tabIndicator` | int | 0x7f040542 | 1489 |
| `tabIndicatorAnimationDuration` | int | 0x7f040543 | 1490 |
| `tabIndicatorAnimationMode` | int | 0x7f040544 | 1491 |
| `tabIndicatorColor` | int | 0x7f040545 | 1492 |
| `tabIndicatorFullWidth` | int | 0x7f040546 | 1493 |
| `tabIndicatorGravity` | int | 0x7f040547 | 1494 |
| `tabIndicatorHeight` | int | 0x7f040548 | 1495 |
| `tabInlineLabel` | int | 0x7f040549 | 1496 |
| `tabMaxWidth` | int | 0x7f04054a | 1497 |
| `tabMinWidth` | int | 0x7f04054b | 1498 |
| `tabMode` | int | 0x7f04054c | 1499 |
| `tabPadding` | int | 0x7f04054d | 1500 |
| `tabPaddingBottom` | int | 0x7f04054e | 1501 |
| `tabPaddingEnd` | int | 0x7f04054f | 1502 |
| `tabPaddingStart` | int | 0x7f040550 | 1503 |
| `tabPaddingTop` | int | 0x7f040551 | 1504 |
| `tabRippleColor` | int | 0x7f040552 | 1505 |
| `tabSecondaryStyle` | int | 0x7f040553 | 1506 |
| `tabSelectedTextAppearance` | int | 0x7f040554 | 1507 |
| `tabSelectedTextColor` | int | 0x7f040555 | 1508 |
| `tabStyle` | int | 0x7f040556 | 1509 |
| `tabTextAppearance` | int | 0x7f040557 | 1510 |
| `tabTextColor` | int | 0x7f040558 | 1511 |
| `tabUnboundedRipple` | int | 0x7f040559 | 1512 |
| `targetId` | int | 0x7f04055a | 1513 |
| `telltales_tailColor` | int | 0x7f04055b | 1514 |
| `telltales_tailScale` | int | 0x7f04055c | 1515 |
| `telltales_velocityMode` | int | 0x7f04055d | 1516 |
| `text` | int | 0x7f04055e | 1517 |
| `text_content` | int | 0x7f0405ae | 1597 |
| `textAllCaps` | int | 0x7f04055f | 1518 |
| `textAppearanceBody1` | int | 0x7f040560 | 1519 |
| `textAppearanceBody2` | int | 0x7f040561 | 1520 |
| `textAppearanceBodyLarge` | int | 0x7f040562 | 1521 |
| `textAppearanceBodyLargeEmphasized` | int | 0x7f040563 | 1522 |
| `textAppearanceBodyMedium` | int | 0x7f040564 | 1523 |
| `textAppearanceBodyMediumEmphasized` | int | 0x7f040565 | 1524 |
| `textAppearanceBodySmall` | int | 0x7f040566 | 1525 |
| `textAppearanceBodySmallEmphasized` | int | 0x7f040567 | 1526 |
| `textAppearanceButton` | int | 0x7f040568 | 1527 |
| `textAppearanceCaption` | int | 0x7f040569 | 1528 |
| `textAppearanceDisplayLarge` | int | 0x7f04056a | 1529 |
| `textAppearanceDisplayLargeEmphasized` | int | 0x7f04056b | 1530 |
| `textAppearanceDisplayMedium` | int | 0x7f04056c | 1531 |
| `textAppearanceDisplayMediumEmphasized` | int | 0x7f04056d | 1532 |
| `textAppearanceDisplaySmall` | int | 0x7f04056e | 1533 |
| `textAppearanceDisplaySmallEmphasized` | int | 0x7f04056f | 1534 |
| `textAppearanceHeadline1` | int | 0x7f040570 | 1535 |
| `textAppearanceHeadline2` | int | 0x7f040571 | 1536 |
| `textAppearanceHeadline3` | int | 0x7f040572 | 1537 |
| `textAppearanceHeadline4` | int | 0x7f040573 | 1538 |
| `textAppearanceHeadline5` | int | 0x7f040574 | 1539 |
| `textAppearanceHeadline6` | int | 0x7f040575 | 1540 |
| `textAppearanceHeadlineLarge` | int | 0x7f040576 | 1541 |
| `textAppearanceHeadlineLargeEmphasized` | int | 0x7f040577 | 1542 |
| `textAppearanceHeadlineMedium` | int | 0x7f040578 | 1543 |
| `textAppearanceHeadlineMediumEmphasized` | int | 0x7f040579 | 1544 |
| `textAppearanceHeadlineSmall` | int | 0x7f04057a | 1545 |
| `textAppearanceHeadlineSmallEmphasized` | int | 0x7f04057b | 1546 |
| `textAppearanceLabelLarge` | int | 0x7f04057c | 1547 |
| `textAppearanceLabelLargeEmphasized` | int | 0x7f04057d | 1548 |
| `textAppearanceLabelMedium` | int | 0x7f04057e | 1549 |
| `textAppearanceLabelMediumEmphasized` | int | 0x7f04057f | 1550 |
| `textAppearanceLabelSmall` | int | 0x7f040580 | 1551 |
| `textAppearanceLabelSmallEmphasized` | int | 0x7f040581 | 1552 |
| `textAppearanceLargePopupMenu` | int | 0x7f040582 | 1553 |
| `textAppearanceLineHeightEnabled` | int | 0x7f040583 | 1554 |
| `textAppearanceListItem` | int | 0x7f040584 | 1555 |
| `textAppearanceListItemSecondary` | int | 0x7f040585 | 1556 |
| `textAppearanceListItemSmall` | int | 0x7f040586 | 1557 |
| `textAppearanceOverline` | int | 0x7f040587 | 1558 |
| `textAppearancePopupMenuHeader` | int | 0x7f040588 | 1559 |
| `textAppearanceSearchResultSubtitle` | int | 0x7f040589 | 1560 |
| `textAppearanceSearchResultTitle` | int | 0x7f04058a | 1561 |
| `textAppearanceSmallPopupMenu` | int | 0x7f04058b | 1562 |
| `textAppearanceSubtitle1` | int | 0x7f04058c | 1563 |
| `textAppearanceSubtitle2` | int | 0x7f04058d | 1564 |
| `textAppearanceTitleLarge` | int | 0x7f04058e | 1565 |
| `textAppearanceTitleLargeEmphasized` | int | 0x7f04058f | 1566 |
| `textAppearanceTitleMedium` | int | 0x7f040590 | 1567 |
| `textAppearanceTitleMediumEmphasized` | int | 0x7f040591 | 1568 |
| `textAppearanceTitleSmall` | int | 0x7f040592 | 1569 |
| `textAppearanceTitleSmallEmphasized` | int | 0x7f040593 | 1570 |
| `textBackground` | int | 0x7f040594 | 1571 |
| `textBackgroundPanX` | int | 0x7f040595 | 1572 |
| `textBackgroundPanY` | int | 0x7f040596 | 1573 |
| `textBackgroundRotate` | int | 0x7f040597 | 1574 |
| `textBackgroundZoom` | int | 0x7f040598 | 1575 |
| `textCentered` | int | 0x7f040599 | 1576 |
| `textColor` | int | 0x7f04059a | 1577 |
| `textColorAlertDialogListItem` | int | 0x7f04059b | 1578 |
| `textColorSearchUrl` | int | 0x7f04059c | 1579 |
| `textEndPadding` | int | 0x7f04059d | 1580 |
| `textFillColor` | int | 0x7f04059e | 1581 |
| `textInputFilledDenseStyle` | int | 0x7f04059f | 1582 |
| `textInputFilledExposedDropdownMenuStyle` | int | 0x7f0405a0 | 1583 |
| `textInputFilledStyle` | int | 0x7f0405a1 | 1584 |
| `textInputLayoutFocusedRectEnabled` | int | 0x7f0405a2 | 1585 |
| `textInputOutlinedDenseStyle` | int | 0x7f0405a3 | 1586 |
| `textInputOutlinedExposedDropdownMenuStyle` | int | 0x7f0405a4 | 1587 |
| `textInputOutlinedStyle` | int | 0x7f0405a5 | 1588 |
| `textInputStyle` | int | 0x7f0405a6 | 1589 |
| `textLocale` | int | 0x7f0405a7 | 1590 |
| `textOutlineColor` | int | 0x7f0405a8 | 1591 |
| `textOutlineThickness` | int | 0x7f0405a9 | 1592 |
| `textPanX` | int | 0x7f0405aa | 1593 |
| `textPanY` | int | 0x7f0405ab | 1594 |
| `textSize` | int | 0x7f0405ac | 1595 |
| `textStartPadding` | int | 0x7f0405ad | 1596 |
| `textureBlurFactor` | int | 0x7f0405af | 1598 |
| `textureEffect` | int | 0x7f0405b0 | 1599 |
| `textureHeight` | int | 0x7f0405b1 | 1600 |
| `textureWidth` | int | 0x7f0405b2 | 1601 |
| `theme` | int | 0x7f0405b3 | 1602 |
| `thickness` | int | 0x7f0405b4 | 1603 |
| `thumbColor` | int | 0x7f0405b5 | 1604 |
| `thumbElevation` | int | 0x7f0405b6 | 1605 |
| `thumbHeight` | int | 0x7f0405b7 | 1606 |
| `thumbIcon` | int | 0x7f0405b8 | 1607 |
| `thumbIconSize` | int | 0x7f0405b9 | 1608 |
| `thumbIconTint` | int | 0x7f0405ba | 1609 |
| `thumbIconTintMode` | int | 0x7f0405bb | 1610 |
| `thumbRadius` | int | 0x7f0405bc | 1611 |
| `thumbStrokeColor` | int | 0x7f0405bd | 1612 |
| `thumbStrokeWidth` | int | 0x7f0405be | 1613 |
| `thumbTextPadding` | int | 0x7f0405bf | 1614 |
| `thumbTint` | int | 0x7f0405c0 | 1615 |
| `thumbTintMode` | int | 0x7f0405c1 | 1616 |
| `thumbTrackGapSize` | int | 0x7f0405c2 | 1617 |
| `thumbWidth` | int | 0x7f0405c3 | 1618 |
| `tickColor` | int | 0x7f0405c4 | 1619 |
| `tickColorActive` | int | 0x7f0405c5 | 1620 |
| `tickColorInactive` | int | 0x7f0405c6 | 1621 |
| `tickMark` | int | 0x7f0405c7 | 1622 |
| `tickMarkTint` | int | 0x7f0405c8 | 1623 |
| `tickMarkTintMode` | int | 0x7f0405c9 | 1624 |
| `tickRadiusActive` | int | 0x7f0405ca | 1625 |
| `tickRadiusInactive` | int | 0x7f0405cb | 1626 |
| `tickVisibilityMode` | int | 0x7f0405cc | 1627 |
| `tickVisible` | int | 0x7f0405cd | 1628 |
| `time_bar_min_update_interval` | int | 0x7f0405ce | 1629 |
| `tint` | int | 0x7f0405cf | 1630 |
| `tintMode` | int | 0x7f0405d0 | 1631 |
| `tintNavigationIcon` | int | 0x7f0405d1 | 1632 |
| `title` | int | 0x7f0405d2 | 1633 |
| `title_color` | int | 0x7f0405e2 | 1649 |
| `title_size` | int | 0x7f0405e3 | 1650 |
| `titleCentered` | int | 0x7f0405d3 | 1634 |
| `titleCollapseMode` | int | 0x7f0405d4 | 1635 |
| `titleEnabled` | int | 0x7f0405d5 | 1636 |
| `titleMargin` | int | 0x7f0405d6 | 1637 |
| `titleMarginBottom` | int | 0x7f0405d7 | 1638 |
| `titleMarginEnd` | int | 0x7f0405d8 | 1639 |
| `titleMargins` | int | 0x7f0405db | 1642 |
| `titleMarginStart` | int | 0x7f0405d9 | 1640 |
| `titleMarginTop` | int | 0x7f0405da | 1641 |
| `titleMaxLines` | int | 0x7f0405dc | 1643 |
| `titlePositionInterpolator` | int | 0x7f0405dd | 1644 |
| `titleTextAppearance` | int | 0x7f0405de | 1645 |
| `titleTextColor` | int | 0x7f0405df | 1646 |
| `titleTextEllipsize` | int | 0x7f0405e0 | 1647 |
| `titleTextStyle` | int | 0x7f0405e1 | 1648 |
| `toggleCheckedStateOnClick` | int | 0x7f0405e4 | 1651 |
| `toolbarId` | int | 0x7f0405e5 | 1652 |
| `toolbarNavigationButtonStyle` | int | 0x7f0405e6 | 1653 |
| `toolbarStyle` | int | 0x7f0405e7 | 1654 |
| `toolbarSurfaceStyle` | int | 0x7f0405e8 | 1655 |
| `tooltipForegroundColor` | int | 0x7f0405e9 | 1656 |
| `tooltipFrameBackground` | int | 0x7f0405ea | 1657 |
| `tooltipStyle` | int | 0x7f0405eb | 1658 |
| `tooltipText` | int | 0x7f0405ec | 1659 |
| `topInsetScrimEnabled` | int | 0x7f0405ed | 1660 |
| `touch_target_height` | int | 0x7f0405f1 | 1664 |
| `touchAnchorId` | int | 0x7f0405ee | 1661 |
| `touchAnchorSide` | int | 0x7f0405ef | 1662 |
| `touchRegionId` | int | 0x7f0405f0 | 1663 |
| `track` | int | 0x7f0405f2 | 1665 |
| `trackColor` | int | 0x7f0405f3 | 1666 |
| `trackColorActive` | int | 0x7f0405f4 | 1667 |
| `trackColorInactive` | int | 0x7f0405f5 | 1668 |
| `trackCornerRadius` | int | 0x7f0405f6 | 1669 |
| `trackCornerSize` | int | 0x7f0405f7 | 1670 |
| `trackDecoration` | int | 0x7f0405f8 | 1671 |
| `trackDecorationTint` | int | 0x7f0405f9 | 1672 |
| `trackDecorationTintMode` | int | 0x7f0405fa | 1673 |
| `trackHeight` | int | 0x7f0405fb | 1674 |
| `trackIconActiveColor` | int | 0x7f0405fc | 1675 |
| `trackIconActiveEnd` | int | 0x7f0405fd | 1676 |
| `trackIconActiveStart` | int | 0x7f0405fe | 1677 |
| `trackIconInactiveColor` | int | 0x7f0405ff | 1678 |
| `trackIconInactiveEnd` | int | 0x7f040600 | 1679 |
| `trackIconInactiveStart` | int | 0x7f040601 | 1680 |
| `trackIconSize` | int | 0x7f040602 | 1681 |
| `trackInnerCornerRadius` | int | 0x7f040603 | 1682 |
| `trackInsideCornerSize` | int | 0x7f040604 | 1683 |
| `trackStopIndicatorPadding` | int | 0x7f040605 | 1684 |
| `trackStopIndicatorSize` | int | 0x7f040606 | 1685 |
| `trackThickness` | int | 0x7f040607 | 1686 |
| `trackTint` | int | 0x7f040608 | 1687 |
| `trackTintMode` | int | 0x7f040609 | 1688 |
| `transformPivotTarget` | int | 0x7f04060a | 1689 |
| `transitionDisable` | int | 0x7f04060b | 1690 |
| `transitionEasing` | int | 0x7f04060c | 1691 |
| `transitionFlags` | int | 0x7f04060d | 1692 |
| `transitionPathRotate` | int | 0x7f04060e | 1693 |
| `transitionShapeAppearance` | int | 0x7f04060f | 1694 |
| `trigger_type_pir_img` | int | 0x7f040613 | 1698 |
| `trigger_type_ring_img` | int | 0x7f040614 | 1699 |
| `triggerId` | int | 0x7f040610 | 1695 |
| `triggerReceiver` | int | 0x7f040611 | 1696 |
| `triggerSlack` | int | 0x7f040612 | 1697 |
| `ttcIndex` | int | 0x7f040615 | 1700 |
| `unchecked_img` | int | 0x7f040616 | 1701 |
| `unplayed_color` | int | 0x7f040617 | 1702 |
| `upDuration` | int | 0x7f040618 | 1703 |
| `use_artwork` | int | 0x7f04061c | 1707 |
| `use_controller` | int | 0x7f04061d | 1708 |
| `useCompatPadding` | int | 0x7f040619 | 1704 |
| `useDrawerArrowDrawable` | int | 0x7f04061a | 1705 |
| `useMaterialThemeColors` | int | 0x7f04061b | 1706 |
| `values` | int | 0x7f04061e | 1709 |
| `verticalOffset` | int | 0x7f04061f | 1710 |
| `verticalOffsetWithText` | int | 0x7f040620 | 1711 |
| `video_always_hide_bar` | int | 0x7f040621 | 1712 |
| `video_always_hide_top_bar` | int | 0x7f040622 | 1713 |
| `video_auto_hide_bar` | int | 0x7f040623 | 1714 |
| `video_back_icon` | int | 0x7f040624 | 1715 |
| `video_buttombar_background` | int | 0x7f040625 | 1716 |
| `video_buttombar_height` | int | 0x7f040626 | 1717 |
| `video_buttombar_visibility` | int | 0x7f040627 | 1718 |
| `video_circe_play_icon` | int | 0x7f040628 | 1719 |
| `video_controller_layout_id` | int | 0x7f040629 | 1720 |
| `video_delete_btn_visibility` | int | 0x7f04062a | 1721 |
| `video_delete_icon` | int | 0x7f04062b | 1722 |
| `video_download_btn_visibility` | int | 0x7f04062c | 1723 |
| `video_download_icon` | int | 0x7f04062d | 1724 |
| `video_fullscreen_enter_icon` | int | 0x7f04062f | 1726 |
| `video_fullscreen_exit_icon` | int | 0x7f040630 | 1727 |
| `video_fullScreen_img_btn_visibility` | int | 0x7f04062e | 1725 |
| `video_pause_icon` | int | 0x7f040631 | 1728 |
| `video_play_icon` | int | 0x7f040632 | 1729 |
| `video_render_type` | int | 0x7f040633 | 1730 |
| `video_seekbar_drawable` | int | 0x7f040634 | 1731 |
| `video_surface_type` | int | 0x7f040635 | 1732 |
| `video_time_color` | int | 0x7f040636 | 1733 |
| `video_title` | int | 0x7f040637 | 1734 |
| `video_title_color` | int | 0x7f040638 | 1735 |
| `video_topbar_background` | int | 0x7f040639 | 1736 |
| `video_topbar_height` | int | 0x7f04063a | 1737 |
| `video_topbar_visibility` | int | 0x7f04063b | 1738 |
| `viewInflaterClass` | int | 0x7f04063c | 1739 |
| `viewTransitionMode` | int | 0x7f04063d | 1740 |
| `viewTransitionOnCross` | int | 0x7f04063e | 1741 |
| `viewTransitionOnNegativeCross` | int | 0x7f04063f | 1742 |
| `viewTransitionOnPositiveCross` | int | 0x7f040640 | 1743 |
| `visibilityMode` | int | 0x7f040641 | 1744 |
| `voiceIcon` | int | 0x7f040642 | 1745 |
| `warmth` | int | 0x7f040643 | 1746 |
| `waveAmplitude` | int | 0x7f040644 | 1747 |
| `waveDecay` | int | 0x7f040645 | 1748 |
| `wavelength` | int | 0x7f04064c | 1755 |
| `wavelengthDeterminate` | int | 0x7f04064d | 1756 |
| `wavelengthIndeterminate` | int | 0x7f04064e | 1757 |
| `waveOffset` | int | 0x7f040646 | 1749 |
| `wavePeriod` | int | 0x7f040647 | 1750 |
| `wavePhase` | int | 0x7f040648 | 1751 |
| `waveShape` | int | 0x7f040649 | 1752 |
| `waveSpeed` | int | 0x7f04064a | 1753 |
| `waveVariesBy` | int | 0x7f04064b | 1754 |
| `wheelview_dividerColor` | int | 0x7f04064f | 1758 |
| `wheelview_dividerWidth` | int | 0x7f040650 | 1759 |
| `wheelview_gravity` | int | 0x7f040651 | 1760 |
| `wheelview_lineSpacingMultiplier` | int | 0x7f040652 | 1761 |
| `wheelview_textColorCenter` | int | 0x7f040653 | 1762 |
| `wheelview_textColorOut` | int | 0x7f040654 | 1763 |
| `wheelview_textSize` | int | 0x7f040655 | 1764 |
| `widthChange` | int | 0x7f040656 | 1765 |
| `windowActionBar` | int | 0x7f040657 | 1766 |
| `windowActionBarOverlay` | int | 0x7f040658 | 1767 |
| `windowActionModeOverlay` | int | 0x7f040659 | 1768 |
| `windowFixedHeightMajor` | int | 0x7f04065a | 1769 |
| `windowFixedHeightMinor` | int | 0x7f04065b | 1770 |
| `windowFixedWidthMajor` | int | 0x7f04065c | 1771 |
| `windowFixedWidthMinor` | int | 0x7f04065d | 1772 |
| `windowMinWidthMajor` | int | 0x7f04065e | 1773 |
| `windowMinWidthMinor` | int | 0x7f04065f | 1774 |
| `windowNoTitle` | int | 0x7f040660 | 1775 |
| `yearSelectedStyle` | int | 0x7f040661 | 1776 |
| `yearStyle` | int | 0x7f040662 | 1777 |
| `yearTodayStyle` | int | 0x7f040663 | 1778 |

### `com.id221.golive.R$bool`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_action_bar_embed_tabs` | int | 0x7f050000 | 1782 |
| `abc_config_actionMenuItemAllCaps` | int | 0x7f050001 | 1783 |
| `mtrl_btn_textappearance_all_caps` | int | 0x7f050002 | 1784 |

### `com.id221.golive.R$color`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_background_cache_hint_selector_material_dark` | int | 0x7f060000 | 1788 |
| `abc_background_cache_hint_selector_material_light` | int | 0x7f060001 | 1789 |
| `abc_btn_colored_borderless_text_material` | int | 0x7f060002 | 1790 |
| `abc_btn_colored_text_material` | int | 0x7f060003 | 1791 |
| `abc_color_highlight_material` | int | 0x7f060004 | 1792 |
| `abc_decor_view_status_guard` | int | 0x7f060005 | 1793 |
| `abc_decor_view_status_guard_light` | int | 0x7f060006 | 1794 |
| `abc_hint_foreground_material_dark` | int | 0x7f060007 | 1795 |
| `abc_hint_foreground_material_light` | int | 0x7f060008 | 1796 |
| `abc_primary_text_disable_only_material_dark` | int | 0x7f060009 | 1797 |
| `abc_primary_text_disable_only_material_light` | int | 0x7f06000a | 1798 |
| `abc_primary_text_material_dark` | int | 0x7f06000b | 1799 |
| `abc_primary_text_material_light` | int | 0x7f06000c | 1800 |
| `abc_search_url_text` | int | 0x7f06000d | 1801 |
| `abc_search_url_text_normal` | int | 0x7f06000e | 1802 |
| `abc_search_url_text_pressed` | int | 0x7f06000f | 1803 |
| `abc_search_url_text_selected` | int | 0x7f060010 | 1804 |
| `abc_secondary_text_material_dark` | int | 0x7f060011 | 1805 |
| `abc_secondary_text_material_light` | int | 0x7f060012 | 1806 |
| `abc_tint_btn_checkable` | int | 0x7f060013 | 1807 |
| `abc_tint_default` | int | 0x7f060014 | 1808 |
| `abc_tint_edittext` | int | 0x7f060015 | 1809 |
| `abc_tint_seek_thumb` | int | 0x7f060016 | 1810 |
| `abc_tint_spinner` | int | 0x7f060017 | 1811 |
| `abc_tint_switch_track` | int | 0x7f060018 | 1812 |
| `accent` | int | 0x7f060019 | 1813 |
| `accent_material_dark` | int | 0x7f06001a | 1814 |
| `accent_material_light` | int | 0x7f06001b | 1815 |
| `action_sheet_blue` | int | 0x7f06001c | 1816 |
| `albumColorPrimary` | int | 0x7f06001d | 1817 |
| `albumColorPrimaryBlack` | int | 0x7f06001e | 1818 |
| `albumColorPrimaryDark` | int | 0x7f06001f | 1819 |
| `albumFontDark` | int | 0x7f060020 | 1820 |
| `albumFontHint` | int | 0x7f060021 | 1821 |
| `albumFontLight` | int | 0x7f060022 | 1822 |
| `albumIconDark` | int | 0x7f060023 | 1823 |
| `albumLoadingDark` | int | 0x7f060024 | 1824 |
| `albumPageLight` | int | 0x7f060025 | 1825 |
| `albumSelectorNormal` | int | 0x7f060026 | 1826 |
| `albumSheetBottom` | int | 0x7f060027 | 1827 |
| `albumSheetLayer` | int | 0x7f060028 | 1828 |
| `albumTransparent` | int | 0x7f060029 | 1829 |
| `androidx_core_ripple_material_light` | int | 0x7f06002a | 1830 |
| `androidx_core_secondary_text_default_material_light` | int | 0x7f06002b | 1831 |
| `author_text` | int | 0x7f06002c | 1832 |
| `background` | int | 0x7f06002d | 1833 |
| `background_floating_material_dark` | int | 0x7f06002e | 1834 |
| `background_floating_material_light` | int | 0x7f06002f | 1835 |
| `background_material_dark` | int | 0x7f060030 | 1836 |
| `background_material_light` | int | 0x7f060031 | 1837 |
| `black` | int | 0x7f060032 | 1838 |
| `black_overlay` | int | 0x7f060033 | 1839 |
| `blue` | int | 0x7f060034 | 1840 |
| `blue_grey_500` | int | 0x7f060035 | 1841 |
| `blue_grey_600` | int | 0x7f060036 | 1842 |
| `blue_grey_700` | int | 0x7f060037 | 1843 |
| `blue_grey_800` | int | 0x7f060038 | 1844 |
| `blue_grey_900` | int | 0x7f060039 | 1845 |
| `bottom_container_bg` | int | 0x7f06003a | 1846 |
| `box` | int | 0x7f06003b | 1847 |
| `box_fill` | int | 0x7f06003c | 1848 |
| `box_select` | int | 0x7f06003d | 1849 |
| `box_select_fill` | int | 0x7f06003e | 1850 |
| `bright_foreground_disabled_material_dark` | int | 0x7f06003f | 1851 |
| `bright_foreground_disabled_material_light` | int | 0x7f060040 | 1852 |
| `bright_foreground_inverse_material_dark` | int | 0x7f060041 | 1853 |
| `bright_foreground_inverse_material_light` | int | 0x7f060042 | 1854 |
| `bright_foreground_light` | int | 0x7f060043 | 1855 |
| `bright_foreground_light_disabled` | int | 0x7f060044 | 1856 |
| `bright_foreground_light_inverse` | int | 0x7f060045 | 1857 |
| `bright_foreground_material_dark` | int | 0x7f060046 | 1858 |
| `bright_foreground_material_light` | int | 0x7f060047 | 1859 |
| `browser_actions_bg_grey` | int | 0x7f060048 | 1860 |
| `browser_actions_divider_color` | int | 0x7f060049 | 1861 |
| `browser_actions_text_color` | int | 0x7f06004a | 1862 |
| `browser_actions_title_color` | int | 0x7f06004b | 1863 |
| `btn_disabled` | int | 0x7f06004c | 1864 |
| `btn_pressed` | int | 0x7f06004d | 1865 |
| `button_material_dark` | int | 0x7f06004e | 1866 |
| `button_material_light` | int | 0x7f06004f | 1867 |
| `call_notification_answer_color` | int | 0x7f060050 | 1868 |
| `call_notification_decline_color` | int | 0x7f060051 | 1869 |
| `cambridge_blue` | int | 0x7f060052 | 1870 |
| `cardview_dark_background` | int | 0x7f060053 | 1871 |
| `cardview_light_background` | int | 0x7f060054 | 1872 |
| `cardview_shadow_end_color` | int | 0x7f060055 | 1873 |
| `cardview_shadow_start_color` | int | 0x7f060056 | 1874 |
| `charcoal_gray` | int | 0x7f060057 | 1875 |
| `color_anomaly` | int | 0x7f06005e | 1882 |
| `colorAccent` | int | 0x7f060058 | 1876 |
| `colorFileStatusGreen` | int | 0x7f060059 | 1877 |
| `colorGray` | int | 0x7f06005a | 1878 |
| `colorMainBlue` | int | 0x7f06005b | 1879 |
| `colorPrimary` | int | 0x7f06005c | 1880 |
| `colorPrimaryDark` | int | 0x7f06005d | 1881 |
| `com_facebook_blue` | int | 0x7f06005f | 1883 |
| `com_facebook_button_background_color` | int | 0x7f060060 | 1884 |
| `com_facebook_button_background_color_disabled` | int | 0x7f060061 | 1885 |
| `com_facebook_button_background_color_pressed` | int | 0x7f060062 | 1886 |
| `com_facebook_button_send_background_color` | int | 0x7f060063 | 1887 |
| `com_facebook_button_send_background_color_pressed` | int | 0x7f060064 | 1888 |
| `com_facebook_button_text_color` | int | 0x7f060065 | 1889 |
| `com_facebook_device_auth_text` | int | 0x7f060066 | 1890 |
| `com_facebook_likeboxcountview_border_color` | int | 0x7f060067 | 1891 |
| `com_facebook_likeboxcountview_text_color` | int | 0x7f060068 | 1892 |
| `com_facebook_likeview_text_color` | int | 0x7f060069 | 1893 |
| `com_facebook_messenger_blue` | int | 0x7f06006a | 1894 |
| `com_facebook_primary_button_disabled_text_color` | int | 0x7f06006b | 1895 |
| `com_facebook_primary_button_pressed_text_color` | int | 0x7f06006c | 1896 |
| `com_facebook_primary_button_text_color` | int | 0x7f06006d | 1897 |
| `com_facebook_send_button_text_color` | int | 0x7f06006e | 1898 |
| `com_smart_login_code` | int | 0x7f06006f | 1899 |
| `common_google_signin_btn_text_dark` | int | 0x7f060070 | 1900 |
| `common_google_signin_btn_text_dark_default` | int | 0x7f060071 | 1901 |
| `common_google_signin_btn_text_dark_disabled` | int | 0x7f060072 | 1902 |
| `common_google_signin_btn_text_dark_focused` | int | 0x7f060073 | 1903 |
| `common_google_signin_btn_text_dark_pressed` | int | 0x7f060074 | 1904 |
| `common_google_signin_btn_text_light` | int | 0x7f060075 | 1905 |
| `common_google_signin_btn_text_light_default` | int | 0x7f060076 | 1906 |
| `common_google_signin_btn_text_light_disabled` | int | 0x7f060077 | 1907 |
| `common_google_signin_btn_text_light_focused` | int | 0x7f060078 | 1908 |
| `common_google_signin_btn_text_light_pressed` | int | 0x7f060079 | 1909 |
| `common_google_signin_btn_tint` | int | 0x7f06007a | 1910 |
| `dark_gray` | int | 0x7f06007b | 1911 |
| `dark_grey` | int | 0x7f06007c | 1912 |
| `design_bottom_navigation_shadow_color` | int | 0x7f06007d | 1913 |
| `design_box_stroke_color` | int | 0x7f06007e | 1914 |
| `design_dark_default_color_background` | int | 0x7f06007f | 1915 |
| `design_dark_default_color_error` | int | 0x7f060080 | 1916 |
| `design_dark_default_color_on_background` | int | 0x7f060081 | 1917 |
| `design_dark_default_color_on_error` | int | 0x7f060082 | 1918 |
| `design_dark_default_color_on_primary` | int | 0x7f060083 | 1919 |
| `design_dark_default_color_on_secondary` | int | 0x7f060084 | 1920 |
| `design_dark_default_color_on_surface` | int | 0x7f060085 | 1921 |
| `design_dark_default_color_primary` | int | 0x7f060086 | 1922 |
| `design_dark_default_color_primary_dark` | int | 0x7f060087 | 1923 |
| `design_dark_default_color_primary_variant` | int | 0x7f060088 | 1924 |
| `design_dark_default_color_secondary` | int | 0x7f060089 | 1925 |
| `design_dark_default_color_secondary_variant` | int | 0x7f06008a | 1926 |
| `design_dark_default_color_surface` | int | 0x7f06008b | 1927 |
| `design_default_color_background` | int | 0x7f06008c | 1928 |
| `design_default_color_error` | int | 0x7f06008d | 1929 |
| `design_default_color_on_background` | int | 0x7f06008e | 1930 |
| `design_default_color_on_error` | int | 0x7f06008f | 1931 |
| `design_default_color_on_primary` | int | 0x7f060090 | 1932 |
| `design_default_color_on_secondary` | int | 0x7f060091 | 1933 |
| `design_default_color_on_surface` | int | 0x7f060092 | 1934 |
| `design_default_color_primary` | int | 0x7f060093 | 1935 |
| `design_default_color_primary_dark` | int | 0x7f060094 | 1936 |
| `design_default_color_primary_variant` | int | 0x7f060095 | 1937 |
| `design_default_color_secondary` | int | 0x7f060096 | 1938 |
| `design_default_color_secondary_variant` | int | 0x7f060097 | 1939 |
| `design_default_color_surface` | int | 0x7f060098 | 1940 |
| `design_error` | int | 0x7f060099 | 1941 |
| `design_fab_shadow_end_color` | int | 0x7f06009a | 1942 |
| `design_fab_shadow_mid_color` | int | 0x7f06009b | 1943 |
| `design_fab_shadow_start_color` | int | 0x7f06009c | 1944 |
| `design_fab_stroke_end_inner_color` | int | 0x7f06009d | 1945 |
| `design_fab_stroke_end_outer_color` | int | 0x7f06009e | 1946 |
| `design_fab_stroke_top_inner_color` | int | 0x7f06009f | 1947 |
| `design_fab_stroke_top_outer_color` | int | 0x7f0600a0 | 1948 |
| `design_icon_tint` | int | 0x7f0600a1 | 1949 |
| `design_snackbar_background_color` | int | 0x7f0600a2 | 1950 |
| `dim_foreground_disabled_material_dark` | int | 0x7f0600a3 | 1951 |
| `dim_foreground_disabled_material_light` | int | 0x7f0600a4 | 1952 |
| `dim_foreground_light` | int | 0x7f0600a5 | 1953 |
| `dim_foreground_light_disabled` | int | 0x7f0600a6 | 1954 |
| `dim_foreground_light_inverse` | int | 0x7f0600a7 | 1955 |
| `dim_foreground_light_inverse_disabled` | int | 0x7f0600a8 | 1956 |
| `dim_foreground_material_dark` | int | 0x7f0600a9 | 1957 |
| `dim_foreground_material_light` | int | 0x7f0600aa | 1958 |
| `divider` | int | 0x7f0600ab | 1959 |
| `dottedline_bg` | int | 0x7f0600ac | 1960 |
| `draw_transparent_bar` | int | 0x7f0600ad | 1961 |
| `draw_view_bg` | int | 0x7f0600ae | 1962 |
| `error_color_material_dark` | int | 0x7f0600af | 1963 |
| `error_color_material_light` | int | 0x7f0600b0 | 1964 |
| `exo_black_opacity_60` | int | 0x7f0600b1 | 1965 |
| `exo_black_opacity_70` | int | 0x7f0600b2 | 1966 |
| `exo_bottom_bar_background` | int | 0x7f0600b3 | 1967 |
| `exo_edit_mode_background_color` | int | 0x7f0600b4 | 1968 |
| `exo_error_message_background_color` | int | 0x7f0600b5 | 1969 |
| `exo_styled_error_message_background` | int | 0x7f0600b6 | 1970 |
| `exo_white` | int | 0x7f0600b7 | 1971 |
| `exo_white_opacity_70` | int | 0x7f0600b8 | 1972 |
| `face_bg` | int | 0x7f0600b9 | 1973 |
| `foreground_material_dark` | int | 0x7f0600ba | 1974 |
| `foreground_material_light` | int | 0x7f0600bb | 1975 |
| `frame_button_text_nor` | int | 0x7f0600bc | 1976 |
| `frame_button_text_select` | int | 0x7f0600bd | 1977 |
| `full_transparent` | int | 0x7f0600be | 1978 |
| `gold` | int | 0x7f0600bf | 1979 |
| `gray` | int | 0x7f0600c0 | 1980 |
| `grayslate` | int | 0x7f0600c1 | 1981 |
| `graywhite` | int | 0x7f0600c2 | 1982 |
| `green` | int | 0x7f0600c3 | 1983 |
| `greyish_white` | int | 0x7f0600c4 | 1984 |
| `guide_pages_hint` | int | 0x7f0600c5 | 1985 |
| `guide_pages_text` | int | 0x7f0600c6 | 1986 |
| `half_transparent` | int | 0x7f0600c7 | 1987 |
| `half_transparent_bar` | int | 0x7f0600c8 | 1988 |
| `half_transparent_grey` | int | 0x7f0600c9 | 1989 |
| `half_transparent_primary` | int | 0x7f0600ca | 1990 |
| `head_text` | int | 0x7f0600cb | 1991 |
| `highlighted_text_material_dark` | int | 0x7f0600cc | 1992 |
| `highlighted_text_material_light` | int | 0x7f0600cd | 1993 |
| `hint` | int | 0x7f0600ce | 1994 |
| `icons` | int | 0x7f0600cf | 1995 |
| `lemonyellow` | int | 0x7f0600d0 | 1996 |
| `lightblue` | int | 0x7f0600d1 | 1997 |
| `lightgray` | int | 0x7f0600d2 | 1998 |
| `lightgreeny` | int | 0x7f0600d3 | 1999 |
| `listitem_black` | int | 0x7f0600d4 | 2000 |
| `listitem_blue` | int | 0x7f0600d5 | 2001 |
| `listitem_gray` | int | 0x7f0600d6 | 2002 |
| `listitem_green` | int | 0x7f0600d7 | 2003 |
| `listitem_greenyellow` | int | 0x7f0600d8 | 2004 |
| `listitem_transparent` | int | 0x7f0600d9 | 2005 |
| `listitem_white` | int | 0x7f0600da | 2006 |
| `listitem_yellow` | int | 0x7f0600db | 2007 |
| `m3_appbar_overlay_color` | int | 0x7f0600dc | 2008 |
| `m3_assist_chip_icon_tint_color` | int | 0x7f0600dd | 2009 |
| `m3_assist_chip_stroke_color` | int | 0x7f0600de | 2010 |
| `m3_bottom_sheet_drag_handle_color` | int | 0x7f0600df | 2011 |
| `m3_button_background_color_selector` | int | 0x7f0600e0 | 2012 |
| `m3_button_foreground_color_selector` | int | 0x7f0600e1 | 2013 |
| `m3_button_outline_color_selector` | int | 0x7f0600e2 | 2014 |
| `m3_button_ripple_color` | int | 0x7f0600e3 | 2015 |
| `m3_button_ripple_color_selector` | int | 0x7f0600e4 | 2016 |
| `m3_calendar_item_disabled_text` | int | 0x7f0600e5 | 2017 |
| `m3_calendar_item_stroke_color` | int | 0x7f0600e6 | 2018 |
| `m3_card_foreground_color` | int | 0x7f0600e7 | 2019 |
| `m3_card_ripple_color` | int | 0x7f0600e8 | 2020 |
| `m3_card_stroke_color` | int | 0x7f0600e9 | 2021 |
| `m3_checkbox_button_icon_tint` | int | 0x7f0600ea | 2022 |
| `m3_checkbox_button_tint` | int | 0x7f0600eb | 2023 |
| `m3_chip_assist_text_color` | int | 0x7f0600ec | 2024 |
| `m3_chip_background_color` | int | 0x7f0600ed | 2025 |
| `m3_chip_ripple_color` | int | 0x7f0600ee | 2026 |
| `m3_chip_stroke_color` | int | 0x7f0600ef | 2027 |
| `m3_chip_text_color` | int | 0x7f0600f0 | 2028 |
| `m3_dark_default_color_primary_text` | int | 0x7f0600f1 | 2029 |
| `m3_dark_default_color_secondary_text` | int | 0x7f0600f2 | 2030 |
| `m3_dark_highlighted_text` | int | 0x7f0600f3 | 2031 |
| `m3_dark_hint_foreground` | int | 0x7f0600f4 | 2032 |
| `m3_dark_primary_text_disable_only` | int | 0x7f0600f5 | 2033 |
| `m3_default_color_primary_text` | int | 0x7f0600f6 | 2034 |
| `m3_default_color_secondary_text` | int | 0x7f0600f7 | 2035 |
| `m3_dynamic_dark_default_color_primary_text` | int | 0x7f0600f8 | 2036 |
| `m3_dynamic_dark_default_color_secondary_text` | int | 0x7f0600f9 | 2037 |
| `m3_dynamic_dark_highlighted_text` | int | 0x7f0600fa | 2038 |
| `m3_dynamic_dark_hint_foreground` | int | 0x7f0600fb | 2039 |
| `m3_dynamic_dark_primary_text_disable_only` | int | 0x7f0600fc | 2040 |
| `m3_dynamic_default_color_primary_text` | int | 0x7f0600fd | 2041 |
| `m3_dynamic_default_color_secondary_text` | int | 0x7f0600fe | 2042 |
| `m3_dynamic_highlighted_text` | int | 0x7f0600ff | 2043 |
| `m3_dynamic_hint_foreground` | int | 0x7f060100 | 2044 |
| `m3_dynamic_primary_text_disable_only` | int | 0x7f060101 | 2045 |
| `m3_efab_ripple_color_selector` | int | 0x7f060102 | 2046 |
| `m3_elevated_chip_background_color` | int | 0x7f060103 | 2047 |
| `m3_fab_efab_background_color_selector` | int | 0x7f060104 | 2048 |
| `m3_fab_efab_foreground_color_selector` | int | 0x7f060105 | 2049 |
| `m3_fab_ripple_color_selector` | int | 0x7f060106 | 2050 |
| `m3_filled_icon_button_container_color_selector` | int | 0x7f060107 | 2051 |
| `m3_floating_toolbar_vibrant_icon_button_container_color_selector` | int | 0x7f060108 | 2052 |
| `m3_floating_toolbar_vibrant_icon_button_text_color_selector` | int | 0x7f060109 | 2053 |
| `m3_highlighted_text` | int | 0x7f06010a | 2054 |
| `m3_hint_foreground` | int | 0x7f06010b | 2055 |
| `m3_icon_button_icon_color_selector` | int | 0x7f06010c | 2056 |
| `m3_navigation_bar_item_with_indicator_icon_tint` | int | 0x7f06010d | 2057 |
| `m3_navigation_bar_item_with_indicator_label_tint` | int | 0x7f06010e | 2058 |
| `m3_navigation_bar_ripple_color_selector` | int | 0x7f06010f | 2059 |
| `m3_navigation_item_background_color` | int | 0x7f060110 | 2060 |
| `m3_navigation_item_icon_tint` | int | 0x7f060111 | 2061 |
| `m3_navigation_item_ripple_color` | int | 0x7f060112 | 2062 |
| `m3_navigation_item_text_color` | int | 0x7f060113 | 2063 |
| `m3_navigation_rail_item_with_indicator_icon_tint` | int | 0x7f060114 | 2064 |
| `m3_navigation_rail_item_with_indicator_label_tint` | int | 0x7f060115 | 2065 |
| `m3_navigation_rail_ripple_color_selector` | int | 0x7f060116 | 2066 |
| `m3_popupmenu_overlay_color` | int | 0x7f060117 | 2067 |
| `m3_primary_text_disable_only` | int | 0x7f060118 | 2068 |
| `m3_radiobutton_button_tint` | int | 0x7f060119 | 2069 |
| `m3_radiobutton_ripple_tint` | int | 0x7f06011a | 2070 |
| `m3_ref_palette_black` | int | 0x7f06011b | 2071 |
| `m3_ref_palette_blue_variant0` | int | 0x7f060129 | 2085 |
| `m3_ref_palette_blue_variant10` | int | 0x7f06012a | 2086 |
| `m3_ref_palette_blue_variant100` | int | 0x7f06012b | 2087 |
| `m3_ref_palette_blue_variant20` | int | 0x7f06012c | 2088 |
| `m3_ref_palette_blue_variant30` | int | 0x7f06012d | 2089 |
| `m3_ref_palette_blue_variant40` | int | 0x7f06012e | 2090 |
| `m3_ref_palette_blue_variant50` | int | 0x7f06012f | 2091 |
| `m3_ref_palette_blue_variant60` | int | 0x7f060130 | 2092 |
| `m3_ref_palette_blue_variant70` | int | 0x7f060131 | 2093 |
| `m3_ref_palette_blue_variant80` | int | 0x7f060132 | 2094 |
| `m3_ref_palette_blue_variant90` | int | 0x7f060133 | 2095 |
| `m3_ref_palette_blue_variant95` | int | 0x7f060134 | 2096 |
| `m3_ref_palette_blue_variant98` | int | 0x7f060135 | 2097 |
| `m3_ref_palette_blue0` | int | 0x7f06011c | 2072 |
| `m3_ref_palette_blue10` | int | 0x7f06011d | 2073 |
| `m3_ref_palette_blue100` | int | 0x7f06011e | 2074 |
| `m3_ref_palette_blue20` | int | 0x7f06011f | 2075 |
| `m3_ref_palette_blue30` | int | 0x7f060120 | 2076 |
| `m3_ref_palette_blue40` | int | 0x7f060121 | 2077 |
| `m3_ref_palette_blue50` | int | 0x7f060122 | 2078 |
| `m3_ref_palette_blue60` | int | 0x7f060123 | 2079 |
| `m3_ref_palette_blue70` | int | 0x7f060124 | 2080 |
| `m3_ref_palette_blue80` | int | 0x7f060125 | 2081 |
| `m3_ref_palette_blue90` | int | 0x7f060126 | 2082 |
| `m3_ref_palette_blue95` | int | 0x7f060127 | 2083 |
| `m3_ref_palette_blue98` | int | 0x7f060128 | 2084 |
| `m3_ref_palette_cyan0` | int | 0x7f060136 | 2098 |
| `m3_ref_palette_cyan10` | int | 0x7f060137 | 2099 |
| `m3_ref_palette_cyan100` | int | 0x7f060138 | 2100 |
| `m3_ref_palette_cyan20` | int | 0x7f060139 | 2101 |
| `m3_ref_palette_cyan30` | int | 0x7f06013a | 2102 |
| `m3_ref_palette_cyan40` | int | 0x7f06013b | 2103 |
| `m3_ref_palette_cyan50` | int | 0x7f06013c | 2104 |
| `m3_ref_palette_cyan60` | int | 0x7f06013d | 2105 |
| `m3_ref_palette_cyan70` | int | 0x7f06013e | 2106 |
| `m3_ref_palette_cyan80` | int | 0x7f06013f | 2107 |
| `m3_ref_palette_cyan90` | int | 0x7f060140 | 2108 |
| `m3_ref_palette_cyan95` | int | 0x7f060141 | 2109 |
| `m3_ref_palette_cyan98` | int | 0x7f060142 | 2110 |
| `m3_ref_palette_dynamic_neutral_variant0` | int | 0x7f06015b | 2135 |
| `m3_ref_palette_dynamic_neutral_variant10` | int | 0x7f06015c | 2136 |
| `m3_ref_palette_dynamic_neutral_variant100` | int | 0x7f06015d | 2137 |
| `m3_ref_palette_dynamic_neutral_variant12` | int | 0x7f06015e | 2138 |
| `m3_ref_palette_dynamic_neutral_variant17` | int | 0x7f06015f | 2139 |
| `m3_ref_palette_dynamic_neutral_variant20` | int | 0x7f060160 | 2140 |
| `m3_ref_palette_dynamic_neutral_variant22` | int | 0x7f060161 | 2141 |
| `m3_ref_palette_dynamic_neutral_variant24` | int | 0x7f060162 | 2142 |
| `m3_ref_palette_dynamic_neutral_variant30` | int | 0x7f060163 | 2143 |
| `m3_ref_palette_dynamic_neutral_variant4` | int | 0x7f060164 | 2144 |
| `m3_ref_palette_dynamic_neutral_variant40` | int | 0x7f060165 | 2145 |
| `m3_ref_palette_dynamic_neutral_variant50` | int | 0x7f060166 | 2146 |
| `m3_ref_palette_dynamic_neutral_variant6` | int | 0x7f060167 | 2147 |
| `m3_ref_palette_dynamic_neutral_variant60` | int | 0x7f060168 | 2148 |
| `m3_ref_palette_dynamic_neutral_variant70` | int | 0x7f060169 | 2149 |
| `m3_ref_palette_dynamic_neutral_variant80` | int | 0x7f06016a | 2150 |
| `m3_ref_palette_dynamic_neutral_variant87` | int | 0x7f06016b | 2151 |
| `m3_ref_palette_dynamic_neutral_variant90` | int | 0x7f06016c | 2152 |
| `m3_ref_palette_dynamic_neutral_variant92` | int | 0x7f06016d | 2153 |
| `m3_ref_palette_dynamic_neutral_variant94` | int | 0x7f06016e | 2154 |
| `m3_ref_palette_dynamic_neutral_variant95` | int | 0x7f06016f | 2155 |
| `m3_ref_palette_dynamic_neutral_variant96` | int | 0x7f060170 | 2156 |
| `m3_ref_palette_dynamic_neutral_variant98` | int | 0x7f060171 | 2157 |
| `m3_ref_palette_dynamic_neutral_variant99` | int | 0x7f060172 | 2158 |
| `m3_ref_palette_dynamic_neutral0` | int | 0x7f060143 | 2111 |
| `m3_ref_palette_dynamic_neutral10` | int | 0x7f060144 | 2112 |
| `m3_ref_palette_dynamic_neutral100` | int | 0x7f060145 | 2113 |
| `m3_ref_palette_dynamic_neutral12` | int | 0x7f060146 | 2114 |
| `m3_ref_palette_dynamic_neutral17` | int | 0x7f060147 | 2115 |
| `m3_ref_palette_dynamic_neutral20` | int | 0x7f060148 | 2116 |
| `m3_ref_palette_dynamic_neutral22` | int | 0x7f060149 | 2117 |
| `m3_ref_palette_dynamic_neutral24` | int | 0x7f06014a | 2118 |
| `m3_ref_palette_dynamic_neutral30` | int | 0x7f06014b | 2119 |
| `m3_ref_palette_dynamic_neutral4` | int | 0x7f06014c | 2120 |
| `m3_ref_palette_dynamic_neutral40` | int | 0x7f06014d | 2121 |
| `m3_ref_palette_dynamic_neutral50` | int | 0x7f06014e | 2122 |
| `m3_ref_palette_dynamic_neutral6` | int | 0x7f06014f | 2123 |
| `m3_ref_palette_dynamic_neutral60` | int | 0x7f060150 | 2124 |
| `m3_ref_palette_dynamic_neutral70` | int | 0x7f060151 | 2125 |
| `m3_ref_palette_dynamic_neutral80` | int | 0x7f060152 | 2126 |
| `m3_ref_palette_dynamic_neutral87` | int | 0x7f060153 | 2127 |
| `m3_ref_palette_dynamic_neutral90` | int | 0x7f060154 | 2128 |
| `m3_ref_palette_dynamic_neutral92` | int | 0x7f060155 | 2129 |
| `m3_ref_palette_dynamic_neutral94` | int | 0x7f060156 | 2130 |
| `m3_ref_palette_dynamic_neutral95` | int | 0x7f060157 | 2131 |
| `m3_ref_palette_dynamic_neutral96` | int | 0x7f060158 | 2132 |
| `m3_ref_palette_dynamic_neutral98` | int | 0x7f060159 | 2133 |
| `m3_ref_palette_dynamic_neutral99` | int | 0x7f06015a | 2134 |
| `m3_ref_palette_dynamic_primary0` | int | 0x7f060173 | 2159 |
| `m3_ref_palette_dynamic_primary10` | int | 0x7f060174 | 2160 |
| `m3_ref_palette_dynamic_primary100` | int | 0x7f060175 | 2161 |
| `m3_ref_palette_dynamic_primary20` | int | 0x7f060176 | 2162 |
| `m3_ref_palette_dynamic_primary30` | int | 0x7f060177 | 2163 |
| `m3_ref_palette_dynamic_primary40` | int | 0x7f060178 | 2164 |
| `m3_ref_palette_dynamic_primary50` | int | 0x7f060179 | 2165 |
| `m3_ref_palette_dynamic_primary60` | int | 0x7f06017a | 2166 |
| `m3_ref_palette_dynamic_primary70` | int | 0x7f06017b | 2167 |
| `m3_ref_palette_dynamic_primary80` | int | 0x7f06017c | 2168 |
| `m3_ref_palette_dynamic_primary90` | int | 0x7f06017d | 2169 |
| `m3_ref_palette_dynamic_primary95` | int | 0x7f06017e | 2170 |
| `m3_ref_palette_dynamic_primary98` | int | 0x7f06017f | 2171 |
| `m3_ref_palette_dynamic_primary99` | int | 0x7f060180 | 2172 |
| `m3_ref_palette_dynamic_secondary0` | int | 0x7f060181 | 2173 |
| `m3_ref_palette_dynamic_secondary10` | int | 0x7f060182 | 2174 |
| `m3_ref_palette_dynamic_secondary100` | int | 0x7f060183 | 2175 |
| `m3_ref_palette_dynamic_secondary20` | int | 0x7f060184 | 2176 |
| `m3_ref_palette_dynamic_secondary30` | int | 0x7f060185 | 2177 |
| `m3_ref_palette_dynamic_secondary40` | int | 0x7f060186 | 2178 |
| `m3_ref_palette_dynamic_secondary50` | int | 0x7f060187 | 2179 |
| `m3_ref_palette_dynamic_secondary60` | int | 0x7f060188 | 2180 |
| `m3_ref_palette_dynamic_secondary70` | int | 0x7f060189 | 2181 |
| `m3_ref_palette_dynamic_secondary80` | int | 0x7f06018a | 2182 |
| `m3_ref_palette_dynamic_secondary90` | int | 0x7f06018b | 2183 |
| `m3_ref_palette_dynamic_secondary95` | int | 0x7f06018c | 2184 |
| `m3_ref_palette_dynamic_secondary98` | int | 0x7f06018d | 2185 |
| `m3_ref_palette_dynamic_secondary99` | int | 0x7f06018e | 2186 |
| `m3_ref_palette_dynamic_tertiary0` | int | 0x7f06018f | 2187 |
| `m3_ref_palette_dynamic_tertiary10` | int | 0x7f060190 | 2188 |
| `m3_ref_palette_dynamic_tertiary100` | int | 0x7f060191 | 2189 |
| `m3_ref_palette_dynamic_tertiary20` | int | 0x7f060192 | 2190 |
| `m3_ref_palette_dynamic_tertiary30` | int | 0x7f060193 | 2191 |
| `m3_ref_palette_dynamic_tertiary40` | int | 0x7f060194 | 2192 |
| `m3_ref_palette_dynamic_tertiary50` | int | 0x7f060195 | 2193 |
| `m3_ref_palette_dynamic_tertiary60` | int | 0x7f060196 | 2194 |
| `m3_ref_palette_dynamic_tertiary70` | int | 0x7f060197 | 2195 |
| `m3_ref_palette_dynamic_tertiary80` | int | 0x7f060198 | 2196 |
| `m3_ref_palette_dynamic_tertiary90` | int | 0x7f060199 | 2197 |
| `m3_ref_palette_dynamic_tertiary95` | int | 0x7f06019a | 2198 |
| `m3_ref_palette_dynamic_tertiary98` | int | 0x7f06019b | 2199 |
| `m3_ref_palette_dynamic_tertiary99` | int | 0x7f06019c | 2200 |
| `m3_ref_palette_error0` | int | 0x7f06019d | 2201 |
| `m3_ref_palette_error10` | int | 0x7f06019e | 2202 |
| `m3_ref_palette_error100` | int | 0x7f06019f | 2203 |
| `m3_ref_palette_error20` | int | 0x7f0601a0 | 2204 |
| `m3_ref_palette_error30` | int | 0x7f0601a1 | 2205 |
| `m3_ref_palette_error40` | int | 0x7f0601a2 | 2206 |
| `m3_ref_palette_error50` | int | 0x7f0601a3 | 2207 |
| `m3_ref_palette_error60` | int | 0x7f0601a4 | 2208 |
| `m3_ref_palette_error70` | int | 0x7f0601a5 | 2209 |
| `m3_ref_palette_error80` | int | 0x7f0601a6 | 2210 |
| `m3_ref_palette_error90` | int | 0x7f0601a7 | 2211 |
| `m3_ref_palette_error95` | int | 0x7f0601a8 | 2212 |
| `m3_ref_palette_error98` | int | 0x7f0601a9 | 2213 |
| `m3_ref_palette_error99` | int | 0x7f0601aa | 2214 |
| `m3_ref_palette_green0` | int | 0x7f0601ab | 2215 |
| `m3_ref_palette_green10` | int | 0x7f0601ac | 2216 |
| `m3_ref_palette_green100` | int | 0x7f0601ad | 2217 |
| `m3_ref_palette_green20` | int | 0x7f0601ae | 2218 |
| `m3_ref_palette_green30` | int | 0x7f0601af | 2219 |
| `m3_ref_palette_green40` | int | 0x7f0601b0 | 2220 |
| `m3_ref_palette_green50` | int | 0x7f0601b1 | 2221 |
| `m3_ref_palette_green60` | int | 0x7f0601b2 | 2222 |
| `m3_ref_palette_green70` | int | 0x7f0601b3 | 2223 |
| `m3_ref_palette_green80` | int | 0x7f0601b4 | 2224 |
| `m3_ref_palette_green90` | int | 0x7f0601b5 | 2225 |
| `m3_ref_palette_green95` | int | 0x7f0601b6 | 2226 |
| `m3_ref_palette_green98` | int | 0x7f0601b7 | 2227 |
| `m3_ref_palette_grey_variant0` | int | 0x7f0601c5 | 2241 |
| `m3_ref_palette_grey_variant10` | int | 0x7f0601c6 | 2242 |
| `m3_ref_palette_grey_variant100` | int | 0x7f0601c7 | 2243 |
| `m3_ref_palette_grey_variant20` | int | 0x7f0601c8 | 2244 |
| `m3_ref_palette_grey_variant30` | int | 0x7f0601c9 | 2245 |
| `m3_ref_palette_grey_variant40` | int | 0x7f0601ca | 2246 |
| `m3_ref_palette_grey_variant50` | int | 0x7f0601cb | 2247 |
| `m3_ref_palette_grey_variant60` | int | 0x7f0601cc | 2248 |
| `m3_ref_palette_grey_variant70` | int | 0x7f0601cd | 2249 |
| `m3_ref_palette_grey_variant80` | int | 0x7f0601ce | 2250 |
| `m3_ref_palette_grey_variant90` | int | 0x7f0601cf | 2251 |
| `m3_ref_palette_grey_variant95` | int | 0x7f0601d0 | 2252 |
| `m3_ref_palette_grey_variant98` | int | 0x7f0601d1 | 2253 |
| `m3_ref_palette_grey0` | int | 0x7f0601b8 | 2228 |
| `m3_ref_palette_grey10` | int | 0x7f0601b9 | 2229 |
| `m3_ref_palette_grey100` | int | 0x7f0601ba | 2230 |
| `m3_ref_palette_grey20` | int | 0x7f0601bb | 2231 |
| `m3_ref_palette_grey30` | int | 0x7f0601bc | 2232 |
| `m3_ref_palette_grey40` | int | 0x7f0601bd | 2233 |
| `m3_ref_palette_grey50` | int | 0x7f0601be | 2234 |
| `m3_ref_palette_grey60` | int | 0x7f0601bf | 2235 |
| `m3_ref_palette_grey70` | int | 0x7f0601c0 | 2236 |
| `m3_ref_palette_grey80` | int | 0x7f0601c1 | 2237 |
| `m3_ref_palette_grey90` | int | 0x7f0601c2 | 2238 |
| `m3_ref_palette_grey95` | int | 0x7f0601c3 | 2239 |
| `m3_ref_palette_grey98` | int | 0x7f0601c4 | 2240 |
| `m3_ref_palette_neutral_variant0` | int | 0x7f0601ea | 2278 |
| `m3_ref_palette_neutral_variant10` | int | 0x7f0601eb | 2279 |
| `m3_ref_palette_neutral_variant100` | int | 0x7f0601ec | 2280 |
| `m3_ref_palette_neutral_variant20` | int | 0x7f0601ed | 2281 |
| `m3_ref_palette_neutral_variant30` | int | 0x7f0601ee | 2282 |
| `m3_ref_palette_neutral_variant40` | int | 0x7f0601ef | 2283 |
| `m3_ref_palette_neutral_variant50` | int | 0x7f0601f0 | 2284 |
| `m3_ref_palette_neutral_variant60` | int | 0x7f0601f1 | 2285 |
| `m3_ref_palette_neutral_variant70` | int | 0x7f0601f2 | 2286 |
| `m3_ref_palette_neutral_variant80` | int | 0x7f0601f3 | 2287 |
| `m3_ref_palette_neutral_variant90` | int | 0x7f0601f4 | 2288 |
| `m3_ref_palette_neutral_variant95` | int | 0x7f0601f5 | 2289 |
| `m3_ref_palette_neutral_variant98` | int | 0x7f0601f6 | 2290 |
| `m3_ref_palette_neutral_variant99` | int | 0x7f0601f7 | 2291 |
| `m3_ref_palette_neutral0` | int | 0x7f0601d2 | 2254 |
| `m3_ref_palette_neutral10` | int | 0x7f0601d3 | 2255 |
| `m3_ref_palette_neutral100` | int | 0x7f0601d4 | 2256 |
| `m3_ref_palette_neutral12` | int | 0x7f0601d5 | 2257 |
| `m3_ref_palette_neutral17` | int | 0x7f0601d6 | 2258 |
| `m3_ref_palette_neutral20` | int | 0x7f0601d7 | 2259 |
| `m3_ref_palette_neutral22` | int | 0x7f0601d8 | 2260 |
| `m3_ref_palette_neutral24` | int | 0x7f0601d9 | 2261 |
| `m3_ref_palette_neutral30` | int | 0x7f0601da | 2262 |
| `m3_ref_palette_neutral4` | int | 0x7f0601db | 2263 |
| `m3_ref_palette_neutral40` | int | 0x7f0601dc | 2264 |
| `m3_ref_palette_neutral50` | int | 0x7f0601dd | 2265 |
| `m3_ref_palette_neutral6` | int | 0x7f0601de | 2266 |
| `m3_ref_palette_neutral60` | int | 0x7f0601df | 2267 |
| `m3_ref_palette_neutral70` | int | 0x7f0601e0 | 2268 |
| `m3_ref_palette_neutral80` | int | 0x7f0601e1 | 2269 |
| `m3_ref_palette_neutral87` | int | 0x7f0601e2 | 2270 |
| `m3_ref_palette_neutral90` | int | 0x7f0601e3 | 2271 |
| `m3_ref_palette_neutral92` | int | 0x7f0601e4 | 2272 |
| `m3_ref_palette_neutral94` | int | 0x7f0601e5 | 2273 |
| `m3_ref_palette_neutral95` | int | 0x7f0601e6 | 2274 |
| `m3_ref_palette_neutral96` | int | 0x7f0601e7 | 2275 |
| `m3_ref_palette_neutral98` | int | 0x7f0601e8 | 2276 |
| `m3_ref_palette_neutral99` | int | 0x7f0601e9 | 2277 |
| `m3_ref_palette_orange0` | int | 0x7f0601f8 | 2292 |
| `m3_ref_palette_orange10` | int | 0x7f0601f9 | 2293 |
| `m3_ref_palette_orange100` | int | 0x7f0601fa | 2294 |
| `m3_ref_palette_orange20` | int | 0x7f0601fb | 2295 |
| `m3_ref_palette_orange30` | int | 0x7f0601fc | 2296 |
| `m3_ref_palette_orange40` | int | 0x7f0601fd | 2297 |
| `m3_ref_palette_orange50` | int | 0x7f0601fe | 2298 |
| `m3_ref_palette_orange60` | int | 0x7f0601ff | 2299 |
| `m3_ref_palette_orange70` | int | 0x7f060200 | 2300 |
| `m3_ref_palette_orange80` | int | 0x7f060201 | 2301 |
| `m3_ref_palette_orange90` | int | 0x7f060202 | 2302 |
| `m3_ref_palette_orange95` | int | 0x7f060203 | 2303 |
| `m3_ref_palette_orange98` | int | 0x7f060204 | 2304 |
| `m3_ref_palette_pink0` | int | 0x7f060205 | 2305 |
| `m3_ref_palette_pink10` | int | 0x7f060206 | 2306 |
| `m3_ref_palette_pink100` | int | 0x7f060207 | 2307 |
| `m3_ref_palette_pink20` | int | 0x7f060208 | 2308 |
| `m3_ref_palette_pink30` | int | 0x7f060209 | 2309 |
| `m3_ref_palette_pink40` | int | 0x7f06020a | 2310 |
| `m3_ref_palette_pink50` | int | 0x7f06020b | 2311 |
| `m3_ref_palette_pink60` | int | 0x7f06020c | 2312 |
| `m3_ref_palette_pink70` | int | 0x7f06020d | 2313 |
| `m3_ref_palette_pink80` | int | 0x7f06020e | 2314 |
| `m3_ref_palette_pink90` | int | 0x7f06020f | 2315 |
| `m3_ref_palette_pink95` | int | 0x7f060210 | 2316 |
| `m3_ref_palette_pink98` | int | 0x7f060211 | 2317 |
| `m3_ref_palette_primary0` | int | 0x7f060212 | 2318 |
| `m3_ref_palette_primary10` | int | 0x7f060213 | 2319 |
| `m3_ref_palette_primary100` | int | 0x7f060214 | 2320 |
| `m3_ref_palette_primary20` | int | 0x7f060215 | 2321 |
| `m3_ref_palette_primary30` | int | 0x7f060216 | 2322 |
| `m3_ref_palette_primary40` | int | 0x7f060217 | 2323 |
| `m3_ref_palette_primary50` | int | 0x7f060218 | 2324 |
| `m3_ref_palette_primary60` | int | 0x7f060219 | 2325 |
| `m3_ref_palette_primary70` | int | 0x7f06021a | 2326 |
| `m3_ref_palette_primary80` | int | 0x7f06021b | 2327 |
| `m3_ref_palette_primary90` | int | 0x7f06021c | 2328 |
| `m3_ref_palette_primary95` | int | 0x7f06021d | 2329 |
| `m3_ref_palette_primary98` | int | 0x7f06021e | 2330 |
| `m3_ref_palette_primary99` | int | 0x7f06021f | 2331 |
| `m3_ref_palette_purple0` | int | 0x7f060220 | 2332 |
| `m3_ref_palette_purple10` | int | 0x7f060221 | 2333 |
| `m3_ref_palette_purple100` | int | 0x7f060222 | 2334 |
| `m3_ref_palette_purple20` | int | 0x7f060223 | 2335 |
| `m3_ref_palette_purple30` | int | 0x7f060224 | 2336 |
| `m3_ref_palette_purple40` | int | 0x7f060225 | 2337 |
| `m3_ref_palette_purple50` | int | 0x7f060226 | 2338 |
| `m3_ref_palette_purple60` | int | 0x7f060227 | 2339 |
| `m3_ref_palette_purple70` | int | 0x7f060228 | 2340 |
| `m3_ref_palette_purple80` | int | 0x7f060229 | 2341 |
| `m3_ref_palette_purple90` | int | 0x7f06022a | 2342 |
| `m3_ref_palette_purple95` | int | 0x7f06022b | 2343 |
| `m3_ref_palette_purple98` | int | 0x7f06022c | 2344 |
| `m3_ref_palette_red0` | int | 0x7f06022d | 2345 |
| `m3_ref_palette_red10` | int | 0x7f06022e | 2346 |
| `m3_ref_palette_red100` | int | 0x7f06022f | 2347 |
| `m3_ref_palette_red20` | int | 0x7f060230 | 2348 |
| `m3_ref_palette_red30` | int | 0x7f060231 | 2349 |
| `m3_ref_palette_red40` | int | 0x7f060232 | 2350 |
| `m3_ref_palette_red50` | int | 0x7f060233 | 2351 |
| `m3_ref_palette_red60` | int | 0x7f060234 | 2352 |
| `m3_ref_palette_red70` | int | 0x7f060235 | 2353 |
| `m3_ref_palette_red80` | int | 0x7f060236 | 2354 |
| `m3_ref_palette_red90` | int | 0x7f060237 | 2355 |
| `m3_ref_palette_red95` | int | 0x7f060238 | 2356 |
| `m3_ref_palette_red98` | int | 0x7f060239 | 2357 |
| `m3_ref_palette_secondary0` | int | 0x7f06023a | 2358 |
| `m3_ref_palette_secondary10` | int | 0x7f06023b | 2359 |
| `m3_ref_palette_secondary100` | int | 0x7f06023c | 2360 |
| `m3_ref_palette_secondary20` | int | 0x7f06023d | 2361 |
| `m3_ref_palette_secondary30` | int | 0x7f06023e | 2362 |
| `m3_ref_palette_secondary40` | int | 0x7f06023f | 2363 |
| `m3_ref_palette_secondary50` | int | 0x7f060240 | 2364 |
| `m3_ref_palette_secondary60` | int | 0x7f060241 | 2365 |
| `m3_ref_palette_secondary70` | int | 0x7f060242 | 2366 |
| `m3_ref_palette_secondary80` | int | 0x7f060243 | 2367 |
| `m3_ref_palette_secondary90` | int | 0x7f060244 | 2368 |
| `m3_ref_palette_secondary95` | int | 0x7f060245 | 2369 |
| `m3_ref_palette_secondary98` | int | 0x7f060246 | 2370 |
| `m3_ref_palette_secondary99` | int | 0x7f060247 | 2371 |
| `m3_ref_palette_tertiary0` | int | 0x7f060248 | 2372 |
| `m3_ref_palette_tertiary10` | int | 0x7f060249 | 2373 |
| `m3_ref_palette_tertiary100` | int | 0x7f06024a | 2374 |
| `m3_ref_palette_tertiary20` | int | 0x7f06024b | 2375 |
| `m3_ref_palette_tertiary30` | int | 0x7f06024c | 2376 |
| `m3_ref_palette_tertiary40` | int | 0x7f06024d | 2377 |
| `m3_ref_palette_tertiary50` | int | 0x7f06024e | 2378 |
| `m3_ref_palette_tertiary60` | int | 0x7f06024f | 2379 |
| `m3_ref_palette_tertiary70` | int | 0x7f060250 | 2380 |
| `m3_ref_palette_tertiary80` | int | 0x7f060251 | 2381 |
| `m3_ref_palette_tertiary90` | int | 0x7f060252 | 2382 |
| `m3_ref_palette_tertiary95` | int | 0x7f060253 | 2383 |
| `m3_ref_palette_tertiary98` | int | 0x7f060254 | 2384 |
| `m3_ref_palette_tertiary99` | int | 0x7f060255 | 2385 |
| `m3_ref_palette_white` | int | 0x7f060256 | 2386 |
| `m3_ref_palette_yellow0` | int | 0x7f060257 | 2387 |
| `m3_ref_palette_yellow10` | int | 0x7f060258 | 2388 |
| `m3_ref_palette_yellow100` | int | 0x7f060259 | 2389 |
| `m3_ref_palette_yellow20` | int | 0x7f06025a | 2390 |
| `m3_ref_palette_yellow30` | int | 0x7f06025b | 2391 |
| `m3_ref_palette_yellow40` | int | 0x7f06025c | 2392 |
| `m3_ref_palette_yellow50` | int | 0x7f06025d | 2393 |
| `m3_ref_palette_yellow60` | int | 0x7f06025e | 2394 |
| `m3_ref_palette_yellow70` | int | 0x7f06025f | 2395 |
| `m3_ref_palette_yellow80` | int | 0x7f060260 | 2396 |
| `m3_ref_palette_yellow90` | int | 0x7f060261 | 2397 |
| `m3_ref_palette_yellow95` | int | 0x7f060262 | 2398 |
| `m3_ref_palette_yellow98` | int | 0x7f060263 | 2399 |
| `m3_selection_control_ripple_color_selector` | int | 0x7f060264 | 2400 |
| `m3_simple_item_ripple_color` | int | 0x7f060265 | 2401 |
| `m3_slider_active_tick_marks_color` | int | 0x7f060266 | 2402 |
| `m3_slider_active_track_color` | int | 0x7f060267 | 2403 |
| `m3_slider_active_track_color_legacy` | int | 0x7f060268 | 2404 |
| `m3_slider_halo_color_legacy` | int | 0x7f060269 | 2405 |
| `m3_slider_inactive_tick_marks_color` | int | 0x7f06026a | 2406 |
| `m3_slider_inactive_track_color` | int | 0x7f06026b | 2407 |
| `m3_slider_inactive_track_color_legacy` | int | 0x7f06026c | 2408 |
| `m3_slider_thumb_color` | int | 0x7f06026d | 2409 |
| `m3_slider_thumb_color_legacy` | int | 0x7f06026e | 2410 |
| `m3_standard_toolbar_button_text_color_selector` | int | 0x7f06026f | 2411 |
| `m3_standard_toolbar_icon_button_container_color_selector` | int | 0x7f060270 | 2412 |
| `m3_standard_toolbar_icon_button_icon_color_selector` | int | 0x7f060271 | 2413 |
| `m3_standard_toolbar_icon_button_ripple_color_selector` | int | 0x7f060272 | 2414 |
| `m3_switch_thumb_tint` | int | 0x7f060273 | 2415 |
| `m3_switch_track_tint` | int | 0x7f060274 | 2416 |
| `m3_sys_color_dark_background` | int | 0x7f060275 | 2417 |
| `m3_sys_color_dark_error` | int | 0x7f060276 | 2418 |
| `m3_sys_color_dark_error_container` | int | 0x7f060277 | 2419 |
| `m3_sys_color_dark_inverse_on_surface` | int | 0x7f060278 | 2420 |
| `m3_sys_color_dark_inverse_primary` | int | 0x7f060279 | 2421 |
| `m3_sys_color_dark_inverse_surface` | int | 0x7f06027a | 2422 |
| `m3_sys_color_dark_on_background` | int | 0x7f06027b | 2423 |
| `m3_sys_color_dark_on_error` | int | 0x7f06027c | 2424 |
| `m3_sys_color_dark_on_error_container` | int | 0x7f06027d | 2425 |
| `m3_sys_color_dark_on_primary` | int | 0x7f06027e | 2426 |
| `m3_sys_color_dark_on_primary_container` | int | 0x7f06027f | 2427 |
| `m3_sys_color_dark_on_secondary` | int | 0x7f060280 | 2428 |
| `m3_sys_color_dark_on_secondary_container` | int | 0x7f060281 | 2429 |
| `m3_sys_color_dark_on_surface` | int | 0x7f060282 | 2430 |
| `m3_sys_color_dark_on_surface_variant` | int | 0x7f060283 | 2431 |
| `m3_sys_color_dark_on_tertiary` | int | 0x7f060284 | 2432 |
| `m3_sys_color_dark_on_tertiary_container` | int | 0x7f060285 | 2433 |
| `m3_sys_color_dark_outline` | int | 0x7f060286 | 2434 |
| `m3_sys_color_dark_outline_variant` | int | 0x7f060287 | 2435 |
| `m3_sys_color_dark_primary` | int | 0x7f060288 | 2436 |
| `m3_sys_color_dark_primary_container` | int | 0x7f060289 | 2437 |
| `m3_sys_color_dark_secondary` | int | 0x7f06028a | 2438 |
| `m3_sys_color_dark_secondary_container` | int | 0x7f06028b | 2439 |
| `m3_sys_color_dark_surface` | int | 0x7f06028c | 2440 |
| `m3_sys_color_dark_surface_bright` | int | 0x7f06028d | 2441 |
| `m3_sys_color_dark_surface_container` | int | 0x7f06028e | 2442 |
| `m3_sys_color_dark_surface_container_high` | int | 0x7f06028f | 2443 |
| `m3_sys_color_dark_surface_container_highest` | int | 0x7f060290 | 2444 |
| `m3_sys_color_dark_surface_container_low` | int | 0x7f060291 | 2445 |
| `m3_sys_color_dark_surface_container_lowest` | int | 0x7f060292 | 2446 |
| `m3_sys_color_dark_surface_dim` | int | 0x7f060293 | 2447 |
| `m3_sys_color_dark_surface_variant` | int | 0x7f060294 | 2448 |
| `m3_sys_color_dark_tertiary` | int | 0x7f060295 | 2449 |
| `m3_sys_color_dark_tertiary_container` | int | 0x7f060296 | 2450 |
| `m3_sys_color_dynamic_dark_background` | int | 0x7f060297 | 2451 |
| `m3_sys_color_dynamic_dark_error` | int | 0x7f060298 | 2452 |
| `m3_sys_color_dynamic_dark_error_container` | int | 0x7f060299 | 2453 |
| `m3_sys_color_dynamic_dark_inverse_on_surface` | int | 0x7f06029a | 2454 |
| `m3_sys_color_dynamic_dark_inverse_primary` | int | 0x7f06029b | 2455 |
| `m3_sys_color_dynamic_dark_inverse_surface` | int | 0x7f06029c | 2456 |
| `m3_sys_color_dynamic_dark_on_background` | int | 0x7f06029d | 2457 |
| `m3_sys_color_dynamic_dark_on_error` | int | 0x7f06029e | 2458 |
| `m3_sys_color_dynamic_dark_on_error_container` | int | 0x7f06029f | 2459 |
| `m3_sys_color_dynamic_dark_on_primary` | int | 0x7f0602a0 | 2460 |
| `m3_sys_color_dynamic_dark_on_primary_container` | int | 0x7f0602a1 | 2461 |
| `m3_sys_color_dynamic_dark_on_secondary` | int | 0x7f0602a2 | 2462 |
| `m3_sys_color_dynamic_dark_on_secondary_container` | int | 0x7f0602a3 | 2463 |
| `m3_sys_color_dynamic_dark_on_surface` | int | 0x7f0602a4 | 2464 |
| `m3_sys_color_dynamic_dark_on_surface_variant` | int | 0x7f0602a5 | 2465 |
| `m3_sys_color_dynamic_dark_on_tertiary` | int | 0x7f0602a6 | 2466 |
| `m3_sys_color_dynamic_dark_on_tertiary_container` | int | 0x7f0602a7 | 2467 |
| `m3_sys_color_dynamic_dark_outline` | int | 0x7f0602a8 | 2468 |
| `m3_sys_color_dynamic_dark_outline_variant` | int | 0x7f0602a9 | 2469 |
| `m3_sys_color_dynamic_dark_primary` | int | 0x7f0602aa | 2470 |
| `m3_sys_color_dynamic_dark_primary_container` | int | 0x7f0602ab | 2471 |
| `m3_sys_color_dynamic_dark_secondary` | int | 0x7f0602ac | 2472 |
| `m3_sys_color_dynamic_dark_secondary_container` | int | 0x7f0602ad | 2473 |
| `m3_sys_color_dynamic_dark_surface` | int | 0x7f0602ae | 2474 |
| `m3_sys_color_dynamic_dark_surface_bright` | int | 0x7f0602af | 2475 |
| `m3_sys_color_dynamic_dark_surface_container` | int | 0x7f0602b0 | 2476 |
| `m3_sys_color_dynamic_dark_surface_container_high` | int | 0x7f0602b1 | 2477 |
| `m3_sys_color_dynamic_dark_surface_container_highest` | int | 0x7f0602b2 | 2478 |
| `m3_sys_color_dynamic_dark_surface_container_low` | int | 0x7f0602b3 | 2479 |
| `m3_sys_color_dynamic_dark_surface_container_lowest` | int | 0x7f0602b4 | 2480 |
| `m3_sys_color_dynamic_dark_surface_dim` | int | 0x7f0602b5 | 2481 |
| `m3_sys_color_dynamic_dark_surface_variant` | int | 0x7f0602b6 | 2482 |
| `m3_sys_color_dynamic_dark_tertiary` | int | 0x7f0602b7 | 2483 |
| `m3_sys_color_dynamic_dark_tertiary_container` | int | 0x7f0602b8 | 2484 |
| `m3_sys_color_dynamic_light_background` | int | 0x7f0602b9 | 2485 |
| `m3_sys_color_dynamic_light_error` | int | 0x7f0602ba | 2486 |
| `m3_sys_color_dynamic_light_error_container` | int | 0x7f0602bb | 2487 |
| `m3_sys_color_dynamic_light_inverse_on_surface` | int | 0x7f0602bc | 2488 |
| `m3_sys_color_dynamic_light_inverse_primary` | int | 0x7f0602bd | 2489 |
| `m3_sys_color_dynamic_light_inverse_surface` | int | 0x7f0602be | 2490 |
| `m3_sys_color_dynamic_light_on_background` | int | 0x7f0602bf | 2491 |
| `m3_sys_color_dynamic_light_on_error` | int | 0x7f0602c0 | 2492 |
| `m3_sys_color_dynamic_light_on_error_container` | int | 0x7f0602c1 | 2493 |
| `m3_sys_color_dynamic_light_on_primary` | int | 0x7f0602c2 | 2494 |
| `m3_sys_color_dynamic_light_on_primary_container` | int | 0x7f0602c3 | 2495 |
| `m3_sys_color_dynamic_light_on_secondary` | int | 0x7f0602c4 | 2496 |
| `m3_sys_color_dynamic_light_on_secondary_container` | int | 0x7f0602c5 | 2497 |
| `m3_sys_color_dynamic_light_on_surface` | int | 0x7f0602c6 | 2498 |
| `m3_sys_color_dynamic_light_on_surface_variant` | int | 0x7f0602c7 | 2499 |
| `m3_sys_color_dynamic_light_on_tertiary` | int | 0x7f0602c8 | 2500 |
| `m3_sys_color_dynamic_light_on_tertiary_container` | int | 0x7f0602c9 | 2501 |
| `m3_sys_color_dynamic_light_outline` | int | 0x7f0602ca | 2502 |
| `m3_sys_color_dynamic_light_outline_variant` | int | 0x7f0602cb | 2503 |
| `m3_sys_color_dynamic_light_primary` | int | 0x7f0602cc | 2504 |
| `m3_sys_color_dynamic_light_primary_container` | int | 0x7f0602cd | 2505 |
| `m3_sys_color_dynamic_light_secondary` | int | 0x7f0602ce | 2506 |
| `m3_sys_color_dynamic_light_secondary_container` | int | 0x7f0602cf | 2507 |
| `m3_sys_color_dynamic_light_surface` | int | 0x7f0602d0 | 2508 |
| `m3_sys_color_dynamic_light_surface_bright` | int | 0x7f0602d1 | 2509 |
| `m3_sys_color_dynamic_light_surface_container` | int | 0x7f0602d2 | 2510 |
| `m3_sys_color_dynamic_light_surface_container_high` | int | 0x7f0602d3 | 2511 |
| `m3_sys_color_dynamic_light_surface_container_highest` | int | 0x7f0602d4 | 2512 |
| `m3_sys_color_dynamic_light_surface_container_low` | int | 0x7f0602d5 | 2513 |
| `m3_sys_color_dynamic_light_surface_container_lowest` | int | 0x7f0602d6 | 2514 |
| `m3_sys_color_dynamic_light_surface_dim` | int | 0x7f0602d7 | 2515 |
| `m3_sys_color_dynamic_light_surface_variant` | int | 0x7f0602d8 | 2516 |
| `m3_sys_color_dynamic_light_tertiary` | int | 0x7f0602d9 | 2517 |
| `m3_sys_color_dynamic_light_tertiary_container` | int | 0x7f0602da | 2518 |
| `m3_sys_color_dynamic_on_primary_fixed` | int | 0x7f0602db | 2519 |
| `m3_sys_color_dynamic_on_primary_fixed_variant` | int | 0x7f0602dc | 2520 |
| `m3_sys_color_dynamic_on_secondary_fixed` | int | 0x7f0602dd | 2521 |
| `m3_sys_color_dynamic_on_secondary_fixed_variant` | int | 0x7f0602de | 2522 |
| `m3_sys_color_dynamic_on_tertiary_fixed` | int | 0x7f0602df | 2523 |
| `m3_sys_color_dynamic_on_tertiary_fixed_variant` | int | 0x7f0602e0 | 2524 |
| `m3_sys_color_dynamic_primary_fixed` | int | 0x7f0602e1 | 2525 |
| `m3_sys_color_dynamic_primary_fixed_dim` | int | 0x7f0602e2 | 2526 |
| `m3_sys_color_dynamic_secondary_fixed` | int | 0x7f0602e3 | 2527 |
| `m3_sys_color_dynamic_secondary_fixed_dim` | int | 0x7f0602e4 | 2528 |
| `m3_sys_color_dynamic_tertiary_fixed` | int | 0x7f0602e5 | 2529 |
| `m3_sys_color_dynamic_tertiary_fixed_dim` | int | 0x7f0602e6 | 2530 |
| `m3_sys_color_light_background` | int | 0x7f0602e7 | 2531 |
| `m3_sys_color_light_error` | int | 0x7f0602e8 | 2532 |
| `m3_sys_color_light_error_container` | int | 0x7f0602e9 | 2533 |
| `m3_sys_color_light_inverse_on_surface` | int | 0x7f0602ea | 2534 |
| `m3_sys_color_light_inverse_primary` | int | 0x7f0602eb | 2535 |
| `m3_sys_color_light_inverse_surface` | int | 0x7f0602ec | 2536 |
| `m3_sys_color_light_on_background` | int | 0x7f0602ed | 2537 |
| `m3_sys_color_light_on_error` | int | 0x7f0602ee | 2538 |
| `m3_sys_color_light_on_error_container` | int | 0x7f0602ef | 2539 |
| `m3_sys_color_light_on_primary` | int | 0x7f0602f0 | 2540 |
| `m3_sys_color_light_on_primary_container` | int | 0x7f0602f1 | 2541 |
| `m3_sys_color_light_on_secondary` | int | 0x7f0602f2 | 2542 |
| `m3_sys_color_light_on_secondary_container` | int | 0x7f0602f3 | 2543 |
| `m3_sys_color_light_on_surface` | int | 0x7f0602f4 | 2544 |
| `m3_sys_color_light_on_surface_variant` | int | 0x7f0602f5 | 2545 |
| `m3_sys_color_light_on_tertiary` | int | 0x7f0602f6 | 2546 |
| `m3_sys_color_light_on_tertiary_container` | int | 0x7f0602f7 | 2547 |
| `m3_sys_color_light_outline` | int | 0x7f0602f8 | 2548 |
| `m3_sys_color_light_outline_variant` | int | 0x7f0602f9 | 2549 |
| `m3_sys_color_light_primary` | int | 0x7f0602fa | 2550 |
| `m3_sys_color_light_primary_container` | int | 0x7f0602fb | 2551 |
| `m3_sys_color_light_secondary` | int | 0x7f0602fc | 2552 |
| `m3_sys_color_light_secondary_container` | int | 0x7f0602fd | 2553 |
| `m3_sys_color_light_surface` | int | 0x7f0602fe | 2554 |
| `m3_sys_color_light_surface_bright` | int | 0x7f0602ff | 2555 |
| `m3_sys_color_light_surface_container` | int | 0x7f060300 | 2556 |
| `m3_sys_color_light_surface_container_high` | int | 0x7f060301 | 2557 |
| `m3_sys_color_light_surface_container_highest` | int | 0x7f060302 | 2558 |
| `m3_sys_color_light_surface_container_low` | int | 0x7f060303 | 2559 |
| `m3_sys_color_light_surface_container_lowest` | int | 0x7f060304 | 2560 |
| `m3_sys_color_light_surface_dim` | int | 0x7f060305 | 2561 |
| `m3_sys_color_light_surface_variant` | int | 0x7f060306 | 2562 |
| `m3_sys_color_light_tertiary` | int | 0x7f060307 | 2563 |
| `m3_sys_color_light_tertiary_container` | int | 0x7f060308 | 2564 |
| `m3_sys_color_on_primary_fixed` | int | 0x7f060309 | 2565 |
| `m3_sys_color_on_primary_fixed_variant` | int | 0x7f06030a | 2566 |
| `m3_sys_color_on_secondary_fixed` | int | 0x7f06030b | 2567 |
| `m3_sys_color_on_secondary_fixed_variant` | int | 0x7f06030c | 2568 |
| `m3_sys_color_on_tertiary_fixed` | int | 0x7f06030d | 2569 |
| `m3_sys_color_on_tertiary_fixed_variant` | int | 0x7f06030e | 2570 |
| `m3_sys_color_primary_fixed` | int | 0x7f06030f | 2571 |
| `m3_sys_color_primary_fixed_dim` | int | 0x7f060310 | 2572 |
| `m3_sys_color_secondary_fixed` | int | 0x7f060311 | 2573 |
| `m3_sys_color_secondary_fixed_dim` | int | 0x7f060312 | 2574 |
| `m3_sys_color_tertiary_fixed` | int | 0x7f060313 | 2575 |
| `m3_sys_color_tertiary_fixed_dim` | int | 0x7f060314 | 2576 |
| `m3_tabs_icon_color` | int | 0x7f060315 | 2577 |
| `m3_tabs_icon_color_secondary` | int | 0x7f060316 | 2578 |
| `m3_tabs_ripple_color` | int | 0x7f060317 | 2579 |
| `m3_tabs_ripple_color_secondary` | int | 0x7f060318 | 2580 |
| `m3_tabs_text_color` | int | 0x7f060319 | 2581 |
| `m3_tabs_text_color_secondary` | int | 0x7f06031a | 2582 |
| `m3_text_button_background_color_selector` | int | 0x7f06031b | 2583 |
| `m3_text_button_foreground_color_selector` | int | 0x7f06031c | 2584 |
| `m3_text_button_ripple_color_selector` | int | 0x7f06031d | 2585 |
| `m3_textfield_filled_background_color` | int | 0x7f06031e | 2586 |
| `m3_textfield_indicator_text_color` | int | 0x7f06031f | 2587 |
| `m3_textfield_input_text_color` | int | 0x7f060320 | 2588 |
| `m3_textfield_label_color` | int | 0x7f060321 | 2589 |
| `m3_textfield_stroke_color` | int | 0x7f060322 | 2590 |
| `m3_timepicker_button_background_color` | int | 0x7f060323 | 2591 |
| `m3_timepicker_button_ripple_color` | int | 0x7f060324 | 2592 |
| `m3_timepicker_button_text_color` | int | 0x7f060325 | 2593 |
| `m3_timepicker_clock_text_color` | int | 0x7f060326 | 2594 |
| `m3_timepicker_display_background_color` | int | 0x7f060327 | 2595 |
| `m3_timepicker_display_ripple_color` | int | 0x7f060328 | 2596 |
| `m3_timepicker_display_text_color` | int | 0x7f060329 | 2597 |
| `m3_timepicker_secondary_text_button_ripple_color` | int | 0x7f06032a | 2598 |
| `m3_timepicker_secondary_text_button_text_color` | int | 0x7f06032b | 2599 |
| `m3_timepicker_time_input_stroke_color` | int | 0x7f06032c | 2600 |
| `m3_tonal_button_ripple_color_selector` | int | 0x7f06032d | 2601 |
| `m3_vibrant_toolbar_button_text_color_selector` | int | 0x7f06032e | 2602 |
| `m3_vibrant_toolbar_icon_button_container_color_selector` | int | 0x7f06032f | 2603 |
| `m3_vibrant_toolbar_icon_button_icon_color_selector` | int | 0x7f060330 | 2604 |
| `m3_vibrant_toolbar_icon_button_ripple_color_selector` | int | 0x7f060331 | 2605 |
| `m3expressive_bottom_nav_item_icon_tint` | int | 0x7f060332 | 2606 |
| `m3expressive_bottom_nav_item_label_tint` | int | 0x7f060333 | 2607 |
| `m3expressive_bottom_nav_item_ripple_tint` | int | 0x7f060334 | 2608 |
| `m3expressive_button_outline_color_selector` | int | 0x7f060335 | 2609 |
| `m3expressive_button_outlined_background_color_selector` | int | 0x7f060336 | 2610 |
| `m3expressive_nav_rail_item_icon_tint` | int | 0x7f060337 | 2611 |
| `m3expressive_nav_rail_item_label_tint` | int | 0x7f060338 | 2612 |
| `m3expressive_nav_rail_item_ripple_tint` | int | 0x7f060339 | 2613 |
| `material_blue_grey_800` | int | 0x7f06033a | 2614 |
| `material_blue_grey_900` | int | 0x7f06033b | 2615 |
| `material_blue_grey_950` | int | 0x7f06033c | 2616 |
| `material_cursor_color` | int | 0x7f06033d | 2617 |
| `material_deep_teal_200` | int | 0x7f06033e | 2618 |
| `material_deep_teal_500` | int | 0x7f06033f | 2619 |
| `material_divider_color` | int | 0x7f060340 | 2620 |
| `material_dynamic_color_dark_error` | int | 0x7f060341 | 2621 |
| `material_dynamic_color_dark_error_container` | int | 0x7f060342 | 2622 |
| `material_dynamic_color_dark_on_error` | int | 0x7f060343 | 2623 |
| `material_dynamic_color_dark_on_error_container` | int | 0x7f060344 | 2624 |
| `material_dynamic_color_light_error` | int | 0x7f060345 | 2625 |
| `material_dynamic_color_light_error_container` | int | 0x7f060346 | 2626 |
| `material_dynamic_color_light_on_error` | int | 0x7f060347 | 2627 |
| `material_dynamic_color_light_on_error_container` | int | 0x7f060348 | 2628 |
| `material_dynamic_neutral_variant0` | int | 0x7f060356 | 2642 |
| `material_dynamic_neutral_variant10` | int | 0x7f060357 | 2643 |
| `material_dynamic_neutral_variant100` | int | 0x7f060358 | 2644 |
| `material_dynamic_neutral_variant20` | int | 0x7f060359 | 2645 |
| `material_dynamic_neutral_variant30` | int | 0x7f06035a | 2646 |
| `material_dynamic_neutral_variant40` | int | 0x7f06035b | 2647 |
| `material_dynamic_neutral_variant50` | int | 0x7f06035c | 2648 |
| `material_dynamic_neutral_variant60` | int | 0x7f06035d | 2649 |
| `material_dynamic_neutral_variant70` | int | 0x7f06035e | 2650 |
| `material_dynamic_neutral_variant80` | int | 0x7f06035f | 2651 |
| `material_dynamic_neutral_variant90` | int | 0x7f060360 | 2652 |
| `material_dynamic_neutral_variant95` | int | 0x7f060361 | 2653 |
| `material_dynamic_neutral_variant99` | int | 0x7f060362 | 2654 |
| `material_dynamic_neutral0` | int | 0x7f060349 | 2629 |
| `material_dynamic_neutral10` | int | 0x7f06034a | 2630 |
| `material_dynamic_neutral100` | int | 0x7f06034b | 2631 |
| `material_dynamic_neutral20` | int | 0x7f06034c | 2632 |
| `material_dynamic_neutral30` | int | 0x7f06034d | 2633 |
| `material_dynamic_neutral40` | int | 0x7f06034e | 2634 |
| `material_dynamic_neutral50` | int | 0x7f06034f | 2635 |
| `material_dynamic_neutral60` | int | 0x7f060350 | 2636 |
| `material_dynamic_neutral70` | int | 0x7f060351 | 2637 |
| `material_dynamic_neutral80` | int | 0x7f060352 | 2638 |
| `material_dynamic_neutral90` | int | 0x7f060353 | 2639 |
| `material_dynamic_neutral95` | int | 0x7f060354 | 2640 |
| `material_dynamic_neutral99` | int | 0x7f060355 | 2641 |
| `material_dynamic_primary0` | int | 0x7f060363 | 2655 |
| `material_dynamic_primary10` | int | 0x7f060364 | 2656 |
| `material_dynamic_primary100` | int | 0x7f060365 | 2657 |
| `material_dynamic_primary20` | int | 0x7f060366 | 2658 |
| `material_dynamic_primary30` | int | 0x7f060367 | 2659 |
| `material_dynamic_primary40` | int | 0x7f060368 | 2660 |
| `material_dynamic_primary50` | int | 0x7f060369 | 2661 |
| `material_dynamic_primary60` | int | 0x7f06036a | 2662 |
| `material_dynamic_primary70` | int | 0x7f06036b | 2663 |
| `material_dynamic_primary80` | int | 0x7f06036c | 2664 |
| `material_dynamic_primary90` | int | 0x7f06036d | 2665 |
| `material_dynamic_primary95` | int | 0x7f06036e | 2666 |
| `material_dynamic_primary99` | int | 0x7f06036f | 2667 |
| `material_dynamic_secondary0` | int | 0x7f060370 | 2668 |
| `material_dynamic_secondary10` | int | 0x7f060371 | 2669 |
| `material_dynamic_secondary100` | int | 0x7f060372 | 2670 |
| `material_dynamic_secondary20` | int | 0x7f060373 | 2671 |
| `material_dynamic_secondary30` | int | 0x7f060374 | 2672 |
| `material_dynamic_secondary40` | int | 0x7f060375 | 2673 |
| `material_dynamic_secondary50` | int | 0x7f060376 | 2674 |
| `material_dynamic_secondary60` | int | 0x7f060377 | 2675 |
| `material_dynamic_secondary70` | int | 0x7f060378 | 2676 |
| `material_dynamic_secondary80` | int | 0x7f060379 | 2677 |
| `material_dynamic_secondary90` | int | 0x7f06037a | 2678 |
| `material_dynamic_secondary95` | int | 0x7f06037b | 2679 |
| `material_dynamic_secondary99` | int | 0x7f06037c | 2680 |
| `material_dynamic_tertiary0` | int | 0x7f06037d | 2681 |
| `material_dynamic_tertiary10` | int | 0x7f06037e | 2682 |
| `material_dynamic_tertiary100` | int | 0x7f06037f | 2683 |
| `material_dynamic_tertiary20` | int | 0x7f060380 | 2684 |
| `material_dynamic_tertiary30` | int | 0x7f060381 | 2685 |
| `material_dynamic_tertiary40` | int | 0x7f060382 | 2686 |
| `material_dynamic_tertiary50` | int | 0x7f060383 | 2687 |
| `material_dynamic_tertiary60` | int | 0x7f060384 | 2688 |
| `material_dynamic_tertiary70` | int | 0x7f060385 | 2689 |
| `material_dynamic_tertiary80` | int | 0x7f060386 | 2690 |
| `material_dynamic_tertiary90` | int | 0x7f060387 | 2691 |
| `material_dynamic_tertiary95` | int | 0x7f060388 | 2692 |
| `material_dynamic_tertiary99` | int | 0x7f060389 | 2693 |
| `material_grey_100` | int | 0x7f06038a | 2694 |
| `material_grey_300` | int | 0x7f06038b | 2695 |
| `material_grey_50` | int | 0x7f06038c | 2696 |
| `material_grey_600` | int | 0x7f06038d | 2697 |
| `material_grey_800` | int | 0x7f06038e | 2698 |
| `material_grey_850` | int | 0x7f06038f | 2699 |
| `material_grey_900` | int | 0x7f060390 | 2700 |
| `material_harmonized_color_error` | int | 0x7f060391 | 2701 |
| `material_harmonized_color_error_container` | int | 0x7f060392 | 2702 |
| `material_harmonized_color_on_error` | int | 0x7f060393 | 2703 |
| `material_harmonized_color_on_error_container` | int | 0x7f060394 | 2704 |
| `material_on_background_disabled` | int | 0x7f060395 | 2705 |
| `material_on_background_emphasis_high_type` | int | 0x7f060396 | 2706 |
| `material_on_background_emphasis_medium` | int | 0x7f060397 | 2707 |
| `material_on_primary_disabled` | int | 0x7f060398 | 2708 |
| `material_on_primary_emphasis_high_type` | int | 0x7f060399 | 2709 |
| `material_on_primary_emphasis_medium` | int | 0x7f06039a | 2710 |
| `material_on_surface_disabled` | int | 0x7f06039b | 2711 |
| `material_on_surface_emphasis_high_type` | int | 0x7f06039c | 2712 |
| `material_on_surface_emphasis_medium` | int | 0x7f06039d | 2713 |
| `material_on_surface_stroke` | int | 0x7f06039e | 2714 |
| `material_personalized__highlighted_text` | int | 0x7f06039f | 2715 |
| `material_personalized__highlighted_text_inverse` | int | 0x7f0603a0 | 2716 |
| `material_personalized_color_background` | int | 0x7f0603a1 | 2717 |
| `material_personalized_color_control_activated` | int | 0x7f0603a2 | 2718 |
| `material_personalized_color_control_highlight` | int | 0x7f0603a3 | 2719 |
| `material_personalized_color_control_normal` | int | 0x7f0603a4 | 2720 |
| `material_personalized_color_error` | int | 0x7f0603a5 | 2721 |
| `material_personalized_color_error_container` | int | 0x7f0603a6 | 2722 |
| `material_personalized_color_on_background` | int | 0x7f0603a7 | 2723 |
| `material_personalized_color_on_error` | int | 0x7f0603a8 | 2724 |
| `material_personalized_color_on_error_container` | int | 0x7f0603a9 | 2725 |
| `material_personalized_color_on_primary` | int | 0x7f0603aa | 2726 |
| `material_personalized_color_on_primary_container` | int | 0x7f0603ab | 2727 |
| `material_personalized_color_on_secondary` | int | 0x7f0603ac | 2728 |
| `material_personalized_color_on_secondary_container` | int | 0x7f0603ad | 2729 |
| `material_personalized_color_on_surface` | int | 0x7f0603ae | 2730 |
| `material_personalized_color_on_surface_inverse` | int | 0x7f0603af | 2731 |
| `material_personalized_color_on_surface_variant` | int | 0x7f0603b0 | 2732 |
| `material_personalized_color_on_tertiary` | int | 0x7f0603b1 | 2733 |
| `material_personalized_color_on_tertiary_container` | int | 0x7f0603b2 | 2734 |
| `material_personalized_color_outline` | int | 0x7f0603b3 | 2735 |
| `material_personalized_color_outline_variant` | int | 0x7f0603b4 | 2736 |
| `material_personalized_color_primary` | int | 0x7f0603b5 | 2737 |
| `material_personalized_color_primary_container` | int | 0x7f0603b6 | 2738 |
| `material_personalized_color_primary_inverse` | int | 0x7f0603b7 | 2739 |
| `material_personalized_color_primary_text` | int | 0x7f0603b8 | 2740 |
| `material_personalized_color_primary_text_inverse` | int | 0x7f0603b9 | 2741 |
| `material_personalized_color_secondary` | int | 0x7f0603ba | 2742 |
| `material_personalized_color_secondary_container` | int | 0x7f0603bb | 2743 |
| `material_personalized_color_secondary_text` | int | 0x7f0603bc | 2744 |
| `material_personalized_color_secondary_text_inverse` | int | 0x7f0603bd | 2745 |
| `material_personalized_color_surface` | int | 0x7f0603be | 2746 |
| `material_personalized_color_surface_bright` | int | 0x7f0603bf | 2747 |
| `material_personalized_color_surface_container` | int | 0x7f0603c0 | 2748 |
| `material_personalized_color_surface_container_high` | int | 0x7f0603c1 | 2749 |
| `material_personalized_color_surface_container_highest` | int | 0x7f0603c2 | 2750 |
| `material_personalized_color_surface_container_low` | int | 0x7f0603c3 | 2751 |
| `material_personalized_color_surface_container_lowest` | int | 0x7f0603c4 | 2752 |
| `material_personalized_color_surface_dim` | int | 0x7f0603c5 | 2753 |
| `material_personalized_color_surface_inverse` | int | 0x7f0603c6 | 2754 |
| `material_personalized_color_surface_variant` | int | 0x7f0603c7 | 2755 |
| `material_personalized_color_tertiary` | int | 0x7f0603c8 | 2756 |
| `material_personalized_color_tertiary_container` | int | 0x7f0603c9 | 2757 |
| `material_personalized_color_text_hint_foreground_inverse` | int | 0x7f0603ca | 2758 |
| `material_personalized_color_text_primary_inverse` | int | 0x7f0603cb | 2759 |
| `material_personalized_color_text_primary_inverse_disable_only` | int | 0x7f0603cc | 2760 |
| `material_personalized_color_text_secondary_and_tertiary_inverse` | int | 0x7f0603cd | 2761 |
| `material_personalized_color_text_secondary_and_tertiary_inverse_disabled` | int | 0x7f0603ce | 2762 |
| `material_personalized_hint_foreground` | int | 0x7f0603cf | 2763 |
| `material_personalized_hint_foreground_inverse` | int | 0x7f0603d0 | 2764 |
| `material_personalized_primary_inverse_text_disable_only` | int | 0x7f0603d1 | 2765 |
| `material_personalized_primary_text_disable_only` | int | 0x7f0603d2 | 2766 |
| `material_slider_active_tick_marks_color` | int | 0x7f0603d3 | 2767 |
| `material_slider_active_track_color` | int | 0x7f0603d4 | 2768 |
| `material_slider_halo_color` | int | 0x7f0603d5 | 2769 |
| `material_slider_inactive_tick_marks_color` | int | 0x7f0603d6 | 2770 |
| `material_slider_inactive_track_color` | int | 0x7f0603d7 | 2771 |
| `material_slider_thumb_color` | int | 0x7f0603d8 | 2772 |
| `material_timepicker_button_background` | int | 0x7f0603d9 | 2773 |
| `material_timepicker_button_stroke` | int | 0x7f0603da | 2774 |
| `material_timepicker_clock_text_color` | int | 0x7f0603db | 2775 |
| `material_timepicker_clockface` | int | 0x7f0603dc | 2776 |
| `material_timepicker_modebutton_tint` | int | 0x7f0603dd | 2777 |
| `media_black` | int | 0x7f0603de | 2778 |
| `media_gray` | int | 0x7f0603df | 2779 |
| `media_half_transparent_grey` | int | 0x7f0603e0 | 2780 |
| `media_lightgray` | int | 0x7f0603e1 | 2781 |
| `media_primary` | int | 0x7f0603e2 | 2782 |
| `media_red` | int | 0x7f0603e3 | 2783 |
| `media_transparent` | int | 0x7f0603e4 | 2784 |
| `media_white` | int | 0x7f0603e5 | 2785 |
| `meida_item_divider` | int | 0x7f0603e6 | 2786 |
| `mtrl_btn_bg_color_selector` | int | 0x7f0603e7 | 2787 |
| `mtrl_btn_ripple_color` | int | 0x7f0603e8 | 2788 |
| `mtrl_btn_stroke_color_selector` | int | 0x7f0603e9 | 2789 |
| `mtrl_btn_text_btn_bg_color_selector` | int | 0x7f0603ea | 2790 |
| `mtrl_btn_text_btn_ripple_color` | int | 0x7f0603eb | 2791 |
| `mtrl_btn_text_color_disabled` | int | 0x7f0603ec | 2792 |
| `mtrl_btn_text_color_selector` | int | 0x7f0603ed | 2793 |
| `mtrl_btn_transparent_bg_color` | int | 0x7f0603ee | 2794 |
| `mtrl_calendar_item_stroke_color` | int | 0x7f0603ef | 2795 |
| `mtrl_calendar_selected_range` | int | 0x7f0603f0 | 2796 |
| `mtrl_card_view_foreground` | int | 0x7f0603f1 | 2797 |
| `mtrl_card_view_ripple` | int | 0x7f0603f2 | 2798 |
| `mtrl_chip_background_color` | int | 0x7f0603f3 | 2799 |
| `mtrl_chip_close_icon_tint` | int | 0x7f0603f4 | 2800 |
| `mtrl_chip_surface_color` | int | 0x7f0603f5 | 2801 |
| `mtrl_chip_text_color` | int | 0x7f0603f6 | 2802 |
| `mtrl_choice_chip_background_color` | int | 0x7f0603f7 | 2803 |
| `mtrl_choice_chip_ripple_color` | int | 0x7f0603f8 | 2804 |
| `mtrl_choice_chip_text_color` | int | 0x7f0603f9 | 2805 |
| `mtrl_error` | int | 0x7f0603fa | 2806 |
| `mtrl_fab_bg_color_selector` | int | 0x7f0603fb | 2807 |
| `mtrl_fab_icon_text_color_selector` | int | 0x7f0603fc | 2808 |
| `mtrl_fab_ripple_color` | int | 0x7f0603fd | 2809 |
| `mtrl_filled_background_color` | int | 0x7f0603fe | 2810 |
| `mtrl_filled_icon_tint` | int | 0x7f0603ff | 2811 |
| `mtrl_filled_stroke_color` | int | 0x7f060400 | 2812 |
| `mtrl_indicator_text_color` | int | 0x7f060401 | 2813 |
| `mtrl_navigation_bar_colored_item_tint` | int | 0x7f060402 | 2814 |
| `mtrl_navigation_bar_colored_ripple_color` | int | 0x7f060403 | 2815 |
| `mtrl_navigation_bar_item_tint` | int | 0x7f060404 | 2816 |
| `mtrl_navigation_bar_ripple_color` | int | 0x7f060405 | 2817 |
| `mtrl_navigation_item_background_color` | int | 0x7f060406 | 2818 |
| `mtrl_navigation_item_icon_tint` | int | 0x7f060407 | 2819 |
| `mtrl_navigation_item_text_color` | int | 0x7f060408 | 2820 |
| `mtrl_on_primary_text_btn_text_color_selector` | int | 0x7f060409 | 2821 |
| `mtrl_on_surface_ripple_color` | int | 0x7f06040a | 2822 |
| `mtrl_outlined_icon_tint` | int | 0x7f06040b | 2823 |
| `mtrl_outlined_stroke_color` | int | 0x7f06040c | 2824 |
| `mtrl_popupmenu_overlay_color` | int | 0x7f06040d | 2825 |
| `mtrl_scrim_color` | int | 0x7f06040e | 2826 |
| `mtrl_switch_thumb_icon_tint` | int | 0x7f06040f | 2827 |
| `mtrl_switch_thumb_tint` | int | 0x7f060410 | 2828 |
| `mtrl_switch_track_decoration_tint` | int | 0x7f060411 | 2829 |
| `mtrl_switch_track_tint` | int | 0x7f060412 | 2830 |
| `mtrl_tabs_colored_ripple_color` | int | 0x7f060413 | 2831 |
| `mtrl_tabs_icon_color_selector` | int | 0x7f060414 | 2832 |
| `mtrl_tabs_icon_color_selector_colored` | int | 0x7f060415 | 2833 |
| `mtrl_tabs_legacy_text_color_selector` | int | 0x7f060416 | 2834 |
| `mtrl_tabs_ripple_color` | int | 0x7f060417 | 2835 |
| `mtrl_text_btn_text_color_selector` | int | 0x7f060418 | 2836 |
| `mtrl_textinput_default_box_stroke_color` | int | 0x7f060419 | 2837 |
| `mtrl_textinput_disabled_color` | int | 0x7f06041a | 2838 |
| `mtrl_textinput_filled_box_default_background_color` | int | 0x7f06041b | 2839 |
| `mtrl_textinput_focused_box_stroke_color` | int | 0x7f06041c | 2840 |
| `mtrl_textinput_hovered_box_stroke_color` | int | 0x7f06041d | 2841 |
| `notification_action_color_filter` | int | 0x7f06041e | 2842 |
| `notification_icon_bg_color` | int | 0x7f06041f | 2843 |
| `notification_material_background_media_default_color` | int | 0x7f060420 | 2844 |
| `orange` | int | 0x7f060421 | 2845 |
| `pale_blue` | int | 0x7f060422 | 2846 |
| `pale_blue02` | int | 0x7f060423 | 2847 |
| `pickerview_bg_topbar` | int | 0x7f060426 | 2850 |
| `pickerview_bgColor_default` | int | 0x7f060424 | 2848 |
| `pickerview_bgColor_overlay` | int | 0x7f060425 | 2849 |
| `pickerview_timebtn_nor` | int | 0x7f060427 | 2851 |
| `pickerview_timebtn_pre` | int | 0x7f060428 | 2852 |
| `pickerview_topbar_title` | int | 0x7f060429 | 2853 |
| `pickerview_wheelview_textcolor_center` | int | 0x7f06042a | 2854 |
| `pickerview_wheelview_textcolor_divider` | int | 0x7f06042b | 2855 |
| `pickerview_wheelview_textcolor_out` | int | 0x7f06042c | 2856 |
| `pink` | int | 0x7f06042d | 2857 |
| `primary` | int | 0x7f06042e | 2858 |
| `primary_checked` | int | 0x7f06042f | 2859 |
| `primary_dark` | int | 0x7f060430 | 2860 |
| `primary_dark_material_dark` | int | 0x7f060431 | 2861 |
| `primary_dark_material_light` | int | 0x7f060432 | 2862 |
| `primary_idle` | int | 0x7f060433 | 2863 |
| `primary_light` | int | 0x7f060434 | 2864 |
| `primary_material_dark` | int | 0x7f060435 | 2865 |
| `primary_material_light` | int | 0x7f060436 | 2866 |
| `primary_text` | int | 0x7f060437 | 2867 |
| `primary_text_default_material_dark` | int | 0x7f060438 | 2868 |
| `primary_text_default_material_light` | int | 0x7f060439 | 2869 |
| `primary_text_disabled_material_dark` | int | 0x7f06043a | 2870 |
| `primary_text_disabled_material_light` | int | 0x7f06043b | 2871 |
| `prompt_text` | int | 0x7f06043c | 2872 |
| `purple` | int | 0x7f06043d | 2873 |
| `red` | int | 0x7f06043e | 2874 |
| `ripple_material_dark` | int | 0x7f06043f | 2875 |
| `ripple_material_light` | int | 0x7f060440 | 2876 |
| `secondary_text` | int | 0x7f060441 | 2877 |
| `secondary_text_default_material_dark` | int | 0x7f060442 | 2878 |
| `secondary_text_default_material_light` | int | 0x7f060443 | 2879 |
| `secondary_text_disabled_material_dark` | int | 0x7f060444 | 2880 |
| `secondary_text_disabled_material_light` | int | 0x7f060445 | 2881 |
| `setting_mainmenu_overlay` | int | 0x7f060446 | 2882 |
| `setting_overlay` | int | 0x7f060447 | 2883 |
| `status_bar_dark` | int | 0x7f060448 | 2884 |
| `style_color` | int | 0x7f060449 | 2885 |
| `switch_thumb_disabled_material_dark` | int | 0x7f06044a | 2886 |
| `switch_thumb_disabled_material_light` | int | 0x7f06044b | 2887 |
| `switch_thumb_material_dark` | int | 0x7f06044c | 2888 |
| `switch_thumb_material_light` | int | 0x7f06044d | 2889 |
| `switch_thumb_normal_material_dark` | int | 0x7f06044e | 2890 |
| `switch_thumb_normal_material_light` | int | 0x7f06044f | 2891 |
| `test` | int | 0x7f060450 | 2892 |
| `text` | int | 0x7f060451 | 2893 |
| `text_video_selected_state` | int | 0x7f060452 | 2894 |
| `text_w` | int | 0x7f060453 | 2895 |
| `tooltip_background_dark` | int | 0x7f060454 | 2896 |
| `tooltip_background_light` | int | 0x7f060455 | 2897 |
| `transparent` | int | 0x7f060456 | 2898 |
| `white` | int | 0x7f060457 | 2899 |
| `white_text` | int | 0x7f060458 | 2900 |
| `yellow` | int | 0x7f060459 | 2901 |

### `com.id221.golive.R$dimen`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_action_bar_content_inset_material` | int | 0x7f070000 | 2905 |
| `abc_action_bar_content_inset_with_nav` | int | 0x7f070001 | 2906 |
| `abc_action_bar_default_height_material` | int | 0x7f070002 | 2907 |
| `abc_action_bar_default_padding_end_material` | int | 0x7f070003 | 2908 |
| `abc_action_bar_default_padding_start_material` | int | 0x7f070004 | 2909 |
| `abc_action_bar_elevation_material` | int | 0x7f070005 | 2910 |
| `abc_action_bar_icon_vertical_padding_material` | int | 0x7f070006 | 2911 |
| `abc_action_bar_overflow_padding_end_material` | int | 0x7f070007 | 2912 |
| `abc_action_bar_overflow_padding_start_material` | int | 0x7f070008 | 2913 |
| `abc_action_bar_stacked_max_height` | int | 0x7f070009 | 2914 |
| `abc_action_bar_stacked_tab_max_width` | int | 0x7f07000a | 2915 |
| `abc_action_bar_subtitle_bottom_margin_material` | int | 0x7f07000b | 2916 |
| `abc_action_bar_subtitle_top_margin_material` | int | 0x7f07000c | 2917 |
| `abc_action_button_min_height_material` | int | 0x7f07000d | 2918 |
| `abc_action_button_min_width_material` | int | 0x7f07000e | 2919 |
| `abc_action_button_min_width_overflow_material` | int | 0x7f07000f | 2920 |
| `abc_alert_dialog_button_bar_height` | int | 0x7f070010 | 2921 |
| `abc_alert_dialog_button_dimen` | int | 0x7f070011 | 2922 |
| `abc_button_inset_horizontal_material` | int | 0x7f070012 | 2923 |
| `abc_button_inset_vertical_material` | int | 0x7f070013 | 2924 |
| `abc_button_padding_horizontal_material` | int | 0x7f070014 | 2925 |
| `abc_button_padding_vertical_material` | int | 0x7f070015 | 2926 |
| `abc_cascading_menus_min_smallest_width` | int | 0x7f070016 | 2927 |
| `abc_config_prefDialogWidth` | int | 0x7f070017 | 2928 |
| `abc_control_corner_material` | int | 0x7f070018 | 2929 |
| `abc_control_inset_material` | int | 0x7f070019 | 2930 |
| `abc_control_padding_material` | int | 0x7f07001a | 2931 |
| `abc_dialog_corner_radius_material` | int | 0x7f07001b | 2932 |
| `abc_dialog_fixed_height_major` | int | 0x7f07001c | 2933 |
| `abc_dialog_fixed_height_minor` | int | 0x7f07001d | 2934 |
| `abc_dialog_fixed_width_major` | int | 0x7f07001e | 2935 |
| `abc_dialog_fixed_width_minor` | int | 0x7f07001f | 2936 |
| `abc_dialog_list_padding_bottom_no_buttons` | int | 0x7f070020 | 2937 |
| `abc_dialog_list_padding_top_no_title` | int | 0x7f070021 | 2938 |
| `abc_dialog_min_width_major` | int | 0x7f070022 | 2939 |
| `abc_dialog_min_width_minor` | int | 0x7f070023 | 2940 |
| `abc_dialog_padding_material` | int | 0x7f070024 | 2941 |
| `abc_dialog_padding_top_material` | int | 0x7f070025 | 2942 |
| `abc_dialog_title_divider_material` | int | 0x7f070026 | 2943 |
| `abc_disabled_alpha_material_dark` | int | 0x7f070027 | 2944 |
| `abc_disabled_alpha_material_light` | int | 0x7f070028 | 2945 |
| `abc_dropdownitem_icon_width` | int | 0x7f070029 | 2946 |
| `abc_dropdownitem_text_padding_left` | int | 0x7f07002a | 2947 |
| `abc_dropdownitem_text_padding_right` | int | 0x7f07002b | 2948 |
| `abc_edit_text_inset_bottom_material` | int | 0x7f07002c | 2949 |
| `abc_edit_text_inset_horizontal_material` | int | 0x7f07002d | 2950 |
| `abc_edit_text_inset_top_material` | int | 0x7f07002e | 2951 |
| `abc_floating_window_z` | int | 0x7f07002f | 2952 |
| `abc_list_item_height_large_material` | int | 0x7f070030 | 2953 |
| `abc_list_item_height_material` | int | 0x7f070031 | 2954 |
| `abc_list_item_height_small_material` | int | 0x7f070032 | 2955 |
| `abc_list_item_padding_horizontal_material` | int | 0x7f070033 | 2956 |
| `abc_panel_menu_list_width` | int | 0x7f070034 | 2957 |
| `abc_progress_bar_height_material` | int | 0x7f070035 | 2958 |
| `abc_search_view_preferred_height` | int | 0x7f070036 | 2959 |
| `abc_search_view_preferred_width` | int | 0x7f070037 | 2960 |
| `abc_seekbar_track_background_height_material` | int | 0x7f070038 | 2961 |
| `abc_seekbar_track_progress_height_material` | int | 0x7f070039 | 2962 |
| `abc_select_dialog_padding_start_material` | int | 0x7f07003a | 2963 |
| `abc_star_big` | int | 0x7f07003b | 2964 |
| `abc_star_medium` | int | 0x7f07003c | 2965 |
| `abc_star_small` | int | 0x7f07003d | 2966 |
| `abc_switch_padding` | int | 0x7f07003e | 2967 |
| `abc_text_size_body_1_material` | int | 0x7f07003f | 2968 |
| `abc_text_size_body_2_material` | int | 0x7f070040 | 2969 |
| `abc_text_size_button_material` | int | 0x7f070041 | 2970 |
| `abc_text_size_caption_material` | int | 0x7f070042 | 2971 |
| `abc_text_size_display_1_material` | int | 0x7f070043 | 2972 |
| `abc_text_size_display_2_material` | int | 0x7f070044 | 2973 |
| `abc_text_size_display_3_material` | int | 0x7f070045 | 2974 |
| `abc_text_size_display_4_material` | int | 0x7f070046 | 2975 |
| `abc_text_size_headline_material` | int | 0x7f070047 | 2976 |
| `abc_text_size_large_material` | int | 0x7f070048 | 2977 |
| `abc_text_size_medium_material` | int | 0x7f070049 | 2978 |
| `abc_text_size_menu_header_material` | int | 0x7f07004a | 2979 |
| `abc_text_size_menu_material` | int | 0x7f07004b | 2980 |
| `abc_text_size_small_material` | int | 0x7f07004c | 2981 |
| `abc_text_size_subhead_material` | int | 0x7f07004d | 2982 |
| `abc_text_size_subtitle_material_toolbar` | int | 0x7f07004e | 2983 |
| `abc_text_size_title_material` | int | 0x7f07004f | 2984 |
| `abc_text_size_title_material_toolbar` | int | 0x7f070050 | 2985 |
| `activity_horizontal_margin` | int | 0x7f070051 | 2986 |
| `activity_vertical_margin` | int | 0x7f070052 | 2987 |
| `album_dp_0` | int | 0x7f070053 | 2988 |
| `album_dp_1` | int | 0x7f070054 | 2989 |
| `album_dp_10` | int | 0x7f070055 | 2990 |
| `album_dp_100` | int | 0x7f070056 | 2991 |
| `album_dp_15` | int | 0x7f070057 | 2992 |
| `album_dp_2` | int | 0x7f070058 | 2993 |
| `album_dp_20` | int | 0x7f070059 | 2994 |
| `album_dp_200` | int | 0x7f07005a | 2995 |
| `album_dp_30` | int | 0x7f07005b | 2996 |
| `album_dp_35` | int | 0x7f07005c | 2997 |
| `album_dp_4` | int | 0x7f07005d | 2998 |
| `album_dp_40` | int | 0x7f07005e | 2999 |
| `album_dp_45` | int | 0x7f07005f | 3000 |
| `album_dp_50` | int | 0x7f070060 | 3001 |
| `album_dp_6` | int | 0x7f070061 | 3002 |
| `album_dp_80` | int | 0x7f070062 | 3003 |
| `album_sp_14` | int | 0x7f070063 | 3004 |
| `album_sp_16` | int | 0x7f070064 | 3005 |
| `album_sp_18` | int | 0x7f070065 | 3006 |
| `album_sp_20` | int | 0x7f070066 | 3007 |
| `appcompat_dialog_background_inset` | int | 0x7f070067 | 3008 |
| `bottom_bar_height` | int | 0x7f070068 | 3009 |
| `brightness_icon` | int | 0x7f070069 | 3010 |
| `browser_actions_context_menu_max_width` | int | 0x7f07006a | 3011 |
| `browser_actions_context_menu_min_padding` | int | 0x7f07006b | 3012 |
| `cardview_compat_inset_shadow` | int | 0x7f07006c | 3013 |
| `cardview_default_elevation` | int | 0x7f07006d | 3014 |
| `cardview_default_radius` | int | 0x7f07006e | 3015 |
| `clock_face_margin_start` | int | 0x7f07006f | 3016 |
| `com_facebook_auth_dialog_corner_radius` | int | 0x7f070070 | 3017 |
| `com_facebook_auth_dialog_corner_radius_oversized` | int | 0x7f070071 | 3018 |
| `com_facebook_button_corner_radius` | int | 0x7f070072 | 3019 |
| `com_facebook_button_login_corner_radius` | int | 0x7f070073 | 3020 |
| `com_facebook_likeboxcountview_border_radius` | int | 0x7f070074 | 3021 |
| `com_facebook_likeboxcountview_border_width` | int | 0x7f070075 | 3022 |
| `com_facebook_likeboxcountview_caret_height` | int | 0x7f070076 | 3023 |
| `com_facebook_likeboxcountview_caret_width` | int | 0x7f070077 | 3024 |
| `com_facebook_likeboxcountview_text_padding` | int | 0x7f070078 | 3025 |
| `com_facebook_likeboxcountview_text_size` | int | 0x7f070079 | 3026 |
| `com_facebook_likeview_edge_padding` | int | 0x7f07007a | 3027 |
| `com_facebook_likeview_internal_padding` | int | 0x7f07007b | 3028 |
| `com_facebook_likeview_text_size` | int | 0x7f07007c | 3029 |
| `com_facebook_profilepictureview_preset_size_large` | int | 0x7f07007d | 3030 |
| `com_facebook_profilepictureview_preset_size_normal` | int | 0x7f07007e | 3031 |
| `com_facebook_profilepictureview_preset_size_small` | int | 0x7f07007f | 3032 |
| `compat_button_inset_horizontal_material` | int | 0x7f070080 | 3033 |
| `compat_button_inset_vertical_material` | int | 0x7f070081 | 3034 |
| `compat_button_padding_horizontal_material` | int | 0x7f070082 | 3035 |
| `compat_button_padding_vertical_material` | int | 0x7f070083 | 3036 |
| `compat_control_corner_material` | int | 0x7f070084 | 3037 |
| `compat_notification_large_icon_max_height` | int | 0x7f070085 | 3038 |
| `compat_notification_large_icon_max_width` | int | 0x7f070086 | 3039 |
| `def_drawer_elevation` | int | 0x7f070087 | 3040 |
| `default_navigation_active_text_size` | int | 0x7f070088 | 3041 |
| `default_navigation_text_size` | int | 0x7f070089 | 3042 |
| `design_appbar_elevation` | int | 0x7f07008a | 3043 |
| `design_bottom_navigation_active_item_max_width` | int | 0x7f07008b | 3044 |
| `design_bottom_navigation_active_item_min_width` | int | 0x7f07008c | 3045 |
| `design_bottom_navigation_active_text_size` | int | 0x7f07008d | 3046 |
| `design_bottom_navigation_elevation` | int | 0x7f07008e | 3047 |
| `design_bottom_navigation_height` | int | 0x7f07008f | 3048 |
| `design_bottom_navigation_icon_size` | int | 0x7f070090 | 3049 |
| `design_bottom_navigation_item_max_width` | int | 0x7f070091 | 3050 |
| `design_bottom_navigation_item_min_width` | int | 0x7f070092 | 3051 |
| `design_bottom_navigation_label_padding` | int | 0x7f070093 | 3052 |
| `design_bottom_navigation_margin` | int | 0x7f070094 | 3053 |
| `design_bottom_navigation_shadow_height` | int | 0x7f070095 | 3054 |
| `design_bottom_navigation_text_size` | int | 0x7f070096 | 3055 |
| `design_bottom_sheet_elevation` | int | 0x7f070097 | 3056 |
| `design_bottom_sheet_modal_elevation` | int | 0x7f070098 | 3057 |
| `design_bottom_sheet_peek_height_min` | int | 0x7f070099 | 3058 |
| `design_fab_border_width` | int | 0x7f07009a | 3059 |
| `design_fab_elevation` | int | 0x7f07009b | 3060 |
| `design_fab_image_size` | int | 0x7f07009c | 3061 |
| `design_fab_size_mini` | int | 0x7f07009d | 3062 |
| `design_fab_size_normal` | int | 0x7f07009e | 3063 |
| `design_fab_translation_z_hovered_focused` | int | 0x7f07009f | 3064 |
| `design_fab_translation_z_pressed` | int | 0x7f0700a0 | 3065 |
| `design_navigation_elevation` | int | 0x7f0700a1 | 3066 |
| `design_navigation_icon_padding` | int | 0x7f0700a2 | 3067 |
| `design_navigation_icon_size` | int | 0x7f0700a3 | 3068 |
| `design_navigation_item_horizontal_padding` | int | 0x7f0700a4 | 3069 |
| `design_navigation_item_icon_padding` | int | 0x7f0700a5 | 3070 |
| `design_navigation_item_vertical_padding` | int | 0x7f0700a6 | 3071 |
| `design_navigation_max_width` | int | 0x7f0700a7 | 3072 |
| `design_navigation_padding_bottom` | int | 0x7f0700a8 | 3073 |
| `design_navigation_separator_vertical_padding` | int | 0x7f0700a9 | 3074 |
| `design_snackbar_action_inline_max_width` | int | 0x7f0700aa | 3075 |
| `design_snackbar_action_text_color_alpha` | int | 0x7f0700ab | 3076 |
| `design_snackbar_background_corner_radius` | int | 0x7f0700ac | 3077 |
| `design_snackbar_elevation` | int | 0x7f0700ad | 3078 |
| `design_snackbar_extra_spacing_horizontal` | int | 0x7f0700ae | 3079 |
| `design_snackbar_max_width` | int | 0x7f0700af | 3080 |
| `design_snackbar_min_width` | int | 0x7f0700b0 | 3081 |
| `design_snackbar_padding_horizontal` | int | 0x7f0700b1 | 3082 |
| `design_snackbar_padding_vertical` | int | 0x7f0700b2 | 3083 |
| `design_snackbar_padding_vertical_2lines` | int | 0x7f0700b3 | 3084 |
| `design_snackbar_text_size` | int | 0x7f0700b4 | 3085 |
| `design_tab_max_width` | int | 0x7f0700b5 | 3086 |
| `design_tab_scrollable_min_width` | int | 0x7f0700b6 | 3087 |
| `design_tab_text_size` | int | 0x7f0700b7 | 3088 |
| `design_tab_text_size_2line` | int | 0x7f0700b8 | 3089 |
| `design_textinput_caption_translate_y` | int | 0x7f0700b9 | 3090 |
| `disabled_alpha_material_dark` | int | 0x7f0700ba | 3091 |
| `disabled_alpha_material_light` | int | 0x7f0700bb | 3092 |
| `dottedline_dashGap_width` | int | 0x7f0700bc | 3093 |
| `dottedline_dashWidth` | int | 0x7f0700bd | 3094 |
| `dottedline_stroke_height` | int | 0x7f0700be | 3095 |
| `dottedline_stroke_width` | int | 0x7f0700bf | 3096 |
| `exo_error_message_height` | int | 0x7f0700c0 | 3097 |
| `exo_error_message_margin_bottom` | int | 0x7f0700c1 | 3098 |
| `exo_error_message_text_padding_horizontal` | int | 0x7f0700c2 | 3099 |
| `exo_error_message_text_padding_vertical` | int | 0x7f0700c3 | 3100 |
| `exo_error_message_text_size` | int | 0x7f0700c4 | 3101 |
| `exo_icon_horizontal_margin` | int | 0x7f0700c5 | 3102 |
| `exo_icon_padding` | int | 0x7f0700c6 | 3103 |
| `exo_icon_padding_bottom` | int | 0x7f0700c7 | 3104 |
| `exo_icon_size` | int | 0x7f0700c8 | 3105 |
| `exo_icon_text_size` | int | 0x7f0700c9 | 3106 |
| `exo_media_button_height` | int | 0x7f0700ca | 3107 |
| `exo_media_button_width` | int | 0x7f0700cb | 3108 |
| `exo_setting_width` | int | 0x7f0700cc | 3109 |
| `exo_settings_height` | int | 0x7f0700cd | 3110 |
| `exo_settings_icon_size` | int | 0x7f0700ce | 3111 |
| `exo_settings_main_text_size` | int | 0x7f0700cf | 3112 |
| `exo_settings_offset` | int | 0x7f0700d0 | 3113 |
| `exo_settings_sub_text_size` | int | 0x7f0700d1 | 3114 |
| `exo_settings_text_height` | int | 0x7f0700d2 | 3115 |
| `exo_small_icon_height` | int | 0x7f0700d3 | 3116 |
| `exo_small_icon_horizontal_margin` | int | 0x7f0700d4 | 3117 |
| `exo_small_icon_padding_horizontal` | int | 0x7f0700d5 | 3118 |
| `exo_small_icon_padding_vertical` | int | 0x7f0700d6 | 3119 |
| `exo_small_icon_width` | int | 0x7f0700d7 | 3120 |
| `exo_styled_bottom_bar_height` | int | 0x7f0700d8 | 3121 |
| `exo_styled_bottom_bar_margin_top` | int | 0x7f0700d9 | 3122 |
| `exo_styled_bottom_bar_time_padding` | int | 0x7f0700da | 3123 |
| `exo_styled_controls_padding` | int | 0x7f0700db | 3124 |
| `exo_styled_minimal_controls_margin_bottom` | int | 0x7f0700dc | 3125 |
| `exo_styled_progress_bar_height` | int | 0x7f0700dd | 3126 |
| `exo_styled_progress_dragged_thumb_size` | int | 0x7f0700de | 3127 |
| `exo_styled_progress_enabled_thumb_size` | int | 0x7f0700df | 3128 |
| `exo_styled_progress_layout_height` | int | 0x7f0700e0 | 3129 |
| `exo_styled_progress_margin_bottom` | int | 0x7f0700e1 | 3130 |
| `exo_styled_progress_touch_target_height` | int | 0x7f0700e2 | 3131 |
| `fab_margin` | int | 0x7f0700e3 | 3132 |
| `fastscroll_default_thickness` | int | 0x7f0700e4 | 3133 |
| `fastscroll_margin` | int | 0x7f0700e5 | 3134 |
| `fastscroll_minimum_range` | int | 0x7f0700e6 | 3135 |
| `first_title_size` | int | 0x7f0700e7 | 3136 |
| `header_footer_left_right_padding` | int | 0x7f0700e8 | 3137 |
| `header_footer_top_bottom_padding` | int | 0x7f0700e9 | 3138 |
| `highlight_alpha_material_colored` | int | 0x7f0700ea | 3139 |
| `highlight_alpha_material_dark` | int | 0x7f0700eb | 3140 |
| `highlight_alpha_material_light` | int | 0x7f0700ec | 3141 |
| `hint_alpha_material_dark` | int | 0x7f0700ed | 3142 |
| `hint_alpha_material_light` | int | 0x7f0700ee | 3143 |
| `hint_pressed_alpha_material_dark` | int | 0x7f0700ef | 3144 |
| `hint_pressed_alpha_material_light` | int | 0x7f0700f0 | 3145 |
| `indicator_corner_radius` | int | 0x7f0700f1 | 3146 |
| `indicator_internal_padding` | int | 0x7f0700f2 | 3147 |
| `indicator_right_padding` | int | 0x7f0700f3 | 3148 |
| `item_height` | int | 0x7f0700f4 | 3149 |
| `item_space` | int | 0x7f0700f5 | 3150 |
| `item_touch_helper_max_drag_scroll_per_frame` | int | 0x7f0700f6 | 3151 |
| `item_touch_helper_swipe_escape_max_velocity` | int | 0x7f0700f7 | 3152 |
| `item_touch_helper_swipe_escape_velocity` | int | 0x7f0700f8 | 3153 |
| `jz_start_button_w_h_fullscreen` | int | 0x7f0700f9 | 3154 |
| `jz_start_button_w_h_normal` | int | 0x7f0700fa | 3155 |
| `least_title_size` | int | 0x7f0700fb | 3156 |
| `m3_alert_dialog_action_bottom_padding` | int | 0x7f0700fc | 3157 |
| `m3_alert_dialog_action_top_padding` | int | 0x7f0700fd | 3158 |
| `m3_alert_dialog_corner_size` | int | 0x7f0700fe | 3159 |
| `m3_alert_dialog_elevation` | int | 0x7f0700ff | 3160 |
| `m3_alert_dialog_icon_margin` | int | 0x7f070100 | 3161 |
| `m3_alert_dialog_icon_size` | int | 0x7f070101 | 3162 |
| `m3_alert_dialog_title_bottom_margin` | int | 0x7f070102 | 3163 |
| `m3_appbar_expanded_title_margin_bottom` | int | 0x7f070103 | 3164 |
| `m3_appbar_expanded_title_margin_horizontal` | int | 0x7f070104 | 3165 |
| `m3_appbar_scrim_height_trigger` | int | 0x7f070105 | 3166 |
| `m3_appbar_scrim_height_trigger_large` | int | 0x7f070106 | 3167 |
| `m3_appbar_scrim_height_trigger_medium` | int | 0x7f070107 | 3168 |
| `m3_appbar_size_compact` | int | 0x7f070108 | 3169 |
| `m3_appbar_size_large` | int | 0x7f070109 | 3170 |
| `m3_appbar_size_large_with_subtitle` | int | 0x7f07010a | 3171 |
| `m3_appbar_size_medium` | int | 0x7f07010b | 3172 |
| `m3_appbar_size_medium_with_subtitle` | int | 0x7f07010c | 3173 |
| `m3_back_progress_bottom_container_max_scale_x_distance` | int | 0x7f07010d | 3174 |
| `m3_back_progress_bottom_container_max_scale_y_distance` | int | 0x7f07010e | 3175 |
| `m3_back_progress_main_container_max_translation_y` | int | 0x7f07010f | 3176 |
| `m3_back_progress_main_container_min_edge_gap` | int | 0x7f070110 | 3177 |
| `m3_back_progress_side_container_max_scale_x_distance_grow` | int | 0x7f070111 | 3178 |
| `m3_back_progress_side_container_max_scale_x_distance_shrink` | int | 0x7f070112 | 3179 |
| `m3_back_progress_side_container_max_scale_y_distance` | int | 0x7f070113 | 3180 |
| `m3_badge_horizontal_offset` | int | 0x7f070114 | 3181 |
| `m3_badge_offset` | int | 0x7f070115 | 3182 |
| `m3_badge_size` | int | 0x7f070116 | 3183 |
| `m3_badge_vertical_offset` | int | 0x7f070117 | 3184 |
| `m3_badge_with_text_horizontal_offset` | int | 0x7f070118 | 3185 |
| `m3_badge_with_text_offset` | int | 0x7f070119 | 3186 |
| `m3_badge_with_text_size` | int | 0x7f07011a | 3187 |
| `m3_badge_with_text_vertical_offset` | int | 0x7f07011b | 3188 |
| `m3_badge_with_text_vertical_padding` | int | 0x7f07011c | 3189 |
| `m3_bottom_nav_item_active_indicator_height` | int | 0x7f07011d | 3190 |
| `m3_bottom_nav_item_active_indicator_margin_horizontal` | int | 0x7f07011e | 3191 |
| `m3_bottom_nav_item_active_indicator_width` | int | 0x7f07011f | 3192 |
| `m3_bottom_nav_item_expanded_active_indicator_height` | int | 0x7f070120 | 3193 |
| `m3_bottom_nav_item_padding_bottom` | int | 0x7f070121 | 3194 |
| `m3_bottom_nav_item_padding_top` | int | 0x7f070122 | 3195 |
| `m3_bottom_nav_min_height` | int | 0x7f070123 | 3196 |
| `m3_bottom_sheet_drag_handle_bottom_padding` | int | 0x7f070124 | 3197 |
| `m3_bottom_sheet_elevation` | int | 0x7f070125 | 3198 |
| `m3_bottom_sheet_modal_elevation` | int | 0x7f070126 | 3199 |
| `m3_bottomappbar_fab_cradle_margin` | int | 0x7f070127 | 3200 |
| `m3_bottomappbar_fab_cradle_rounded_corner_radius` | int | 0x7f070128 | 3201 |
| `m3_bottomappbar_fab_cradle_vertical_offset` | int | 0x7f070129 | 3202 |
| `m3_bottomappbar_fab_end_margin` | int | 0x7f07012a | 3203 |
| `m3_bottomappbar_height` | int | 0x7f07012b | 3204 |
| `m3_bottomappbar_horizontal_padding` | int | 0x7f07012c | 3205 |
| `m3_btn_dialog_btn_min_width` | int | 0x7f07012d | 3206 |
| `m3_btn_dialog_btn_spacing` | int | 0x7f07012e | 3207 |
| `m3_btn_disabled_elevation` | int | 0x7f07012f | 3208 |
| `m3_btn_disabled_translation_z` | int | 0x7f070130 | 3209 |
| `m3_btn_elevated_translation_z_hovered` | int | 0x7f070131 | 3210 |
| `m3_btn_elevation` | int | 0x7f070132 | 3211 |
| `m3_btn_icon_btn_padding_left` | int | 0x7f070133 | 3212 |
| `m3_btn_icon_btn_padding_right` | int | 0x7f070134 | 3213 |
| `m3_btn_icon_only_default_padding` | int | 0x7f070135 | 3214 |
| `m3_btn_icon_only_default_size` | int | 0x7f070136 | 3215 |
| `m3_btn_icon_only_icon_padding` | int | 0x7f070137 | 3216 |
| `m3_btn_icon_only_min_width` | int | 0x7f070138 | 3217 |
| `m3_btn_inset` | int | 0x7f070139 | 3218 |
| `m3_btn_max_width` | int | 0x7f07013a | 3219 |
| `m3_btn_padding_bottom` | int | 0x7f07013b | 3220 |
| `m3_btn_padding_left` | int | 0x7f07013c | 3221 |
| `m3_btn_padding_right` | int | 0x7f07013d | 3222 |
| `m3_btn_padding_top` | int | 0x7f07013e | 3223 |
| `m3_btn_stroke_size` | int | 0x7f07013f | 3224 |
| `m3_btn_text_btn_icon_padding_left` | int | 0x7f070140 | 3225 |
| `m3_btn_text_btn_icon_padding_right` | int | 0x7f070141 | 3226 |
| `m3_btn_text_btn_padding_left` | int | 0x7f070142 | 3227 |
| `m3_btn_text_btn_padding_right` | int | 0x7f070143 | 3228 |
| `m3_btn_translation_z_base` | int | 0x7f070144 | 3229 |
| `m3_btn_translation_z_hovered` | int | 0x7f070145 | 3230 |
| `m3_card_disabled_z` | int | 0x7f070146 | 3231 |
| `m3_card_dragged_z` | int | 0x7f070147 | 3232 |
| `m3_card_elevated_disabled_z` | int | 0x7f070148 | 3233 |
| `m3_card_elevated_dragged_z` | int | 0x7f070149 | 3234 |
| `m3_card_elevated_elevation` | int | 0x7f07014a | 3235 |
| `m3_card_elevated_hovered_z` | int | 0x7f07014b | 3236 |
| `m3_card_elevation` | int | 0x7f07014c | 3237 |
| `m3_card_hovered_z` | int | 0x7f07014d | 3238 |
| `m3_card_stroke_width` | int | 0x7f07014e | 3239 |
| `m3_carousel_debug_keyline_width` | int | 0x7f07014f | 3240 |
| `m3_carousel_extra_small_item_size` | int | 0x7f070150 | 3241 |
| `m3_carousel_gone_size` | int | 0x7f070151 | 3242 |
| `m3_carousel_small_item_default_corner_size` | int | 0x7f070152 | 3243 |
| `m3_carousel_small_item_size_max` | int | 0x7f070153 | 3244 |
| `m3_carousel_small_item_size_min` | int | 0x7f070154 | 3245 |
| `m3_chip_checked_hovered_translation_z` | int | 0x7f070155 | 3246 |
| `m3_chip_corner_size` | int | 0x7f070156 | 3247 |
| `m3_chip_disabled_translation_z` | int | 0x7f070157 | 3248 |
| `m3_chip_dragged_translation_z` | int | 0x7f070158 | 3249 |
| `m3_chip_elevated_elevation` | int | 0x7f070159 | 3250 |
| `m3_chip_hovered_translation_z` | int | 0x7f07015a | 3251 |
| `m3_chip_icon_size` | int | 0x7f07015b | 3252 |
| `m3_comp_app_bar_container_elevation` | int | 0x7f07015c | 3253 |
| `m3_comp_app_bar_large_container_height` | int | 0x7f07015d | 3254 |
| `m3_comp_app_bar_large_flexible_container_height` | int | 0x7f07015e | 3255 |
| `m3_comp_app_bar_medium_container_height` | int | 0x7f07015f | 3256 |
| `m3_comp_app_bar_medium_flexible_container_height` | int | 0x7f070160 | 3257 |
| `m3_comp_app_bar_on_scroll_container_elevation` | int | 0x7f070161 | 3258 |
| `m3_comp_app_bar_small_container_height` | int | 0x7f070162 | 3259 |
| `m3_comp_assist_chip_container_height` | int | 0x7f070163 | 3260 |
| `m3_comp_assist_chip_elevated_container_elevation` | int | 0x7f070164 | 3261 |
| `m3_comp_assist_chip_flat_container_elevation` | int | 0x7f070165 | 3262 |
| `m3_comp_assist_chip_flat_outline_width` | int | 0x7f070166 | 3263 |
| `m3_comp_assist_chip_with_icon_icon_size` | int | 0x7f070167 | 3264 |
| `m3_comp_badge_large_size` | int | 0x7f070168 | 3265 |
| `m3_comp_badge_size` | int | 0x7f070169 | 3266 |
| `m3_comp_bottom_app_bar_container_elevation` | int | 0x7f07016a | 3267 |
| `m3_comp_bottom_app_bar_container_height` | int | 0x7f07016b | 3268 |
| `m3_comp_button_elevated_container_elevation` | int | 0x7f07016c | 3269 |
| `m3_comp_button_elevated_disabled_container_elevation` | int | 0x7f07016d | 3270 |
| `m3_comp_button_filled_container_elevation` | int | 0x7f07016e | 3271 |
| `m3_comp_button_filled_disabled_container_elevation` | int | 0x7f07016f | 3272 |
| `m3_comp_button_group_connected_small_between_space` | int | 0x7f070170 | 3273 |
| `m3_comp_button_group_standard_small_between_space` | int | 0x7f070171 | 3274 |
| `m3_comp_button_large_icon_label_space` | int | 0x7f070172 | 3275 |
| `m3_comp_button_large_icon_size` | int | 0x7f070173 | 3276 |
| `m3_comp_button_large_leading_space` | int | 0x7f070174 | 3277 |
| `m3_comp_button_large_outlined_outline_width` | int | 0x7f070175 | 3278 |
| `m3_comp_button_large_trailing_space` | int | 0x7f070176 | 3279 |
| `m3_comp_button_medium_icon_label_space` | int | 0x7f070177 | 3280 |
| `m3_comp_button_medium_icon_size` | int | 0x7f070178 | 3281 |
| `m3_comp_button_medium_leading_space` | int | 0x7f070179 | 3282 |
| `m3_comp_button_medium_outlined_outline_width` | int | 0x7f07017a | 3283 |
| `m3_comp_button_medium_trailing_space` | int | 0x7f07017b | 3284 |
| `m3_comp_button_outlined_focused_state_layer_opacity` | int | 0x7f07017c | 3285 |
| `m3_comp_button_outlined_hovered_state_layer_opacity` | int | 0x7f07017d | 3286 |
| `m3_comp_button_outlined_pressed_state_layer_opacity` | int | 0x7f07017e | 3287 |
| `m3_comp_button_small_icon_label_space` | int | 0x7f07017f | 3288 |
| `m3_comp_button_small_icon_size` | int | 0x7f070180 | 3289 |
| `m3_comp_button_small_leading_space` | int | 0x7f070181 | 3290 |
| `m3_comp_button_small_outlined_outline_width` | int | 0x7f070182 | 3291 |
| `m3_comp_button_small_trailing_space` | int | 0x7f070183 | 3292 |
| `m3_comp_button_text_focused_state_layer_opacity` | int | 0x7f070184 | 3293 |
| `m3_comp_button_text_hovered_state_layer_opacity` | int | 0x7f070185 | 3294 |
| `m3_comp_button_text_pressed_state_layer_opacity` | int | 0x7f070186 | 3295 |
| `m3_comp_button_tonal_container_elevation` | int | 0x7f070187 | 3296 |
| `m3_comp_button_xlarge_icon_label_space` | int | 0x7f070188 | 3297 |
| `m3_comp_button_xlarge_icon_size` | int | 0x7f070189 | 3298 |
| `m3_comp_button_xlarge_leading_space` | int | 0x7f07018a | 3299 |
| `m3_comp_button_xlarge_outlined_outline_width` | int | 0x7f07018b | 3300 |
| `m3_comp_button_xlarge_trailing_space` | int | 0x7f07018c | 3301 |
| `m3_comp_button_xsmall_icon_label_space` | int | 0x7f07018d | 3302 |
| `m3_comp_button_xsmall_icon_size` | int | 0x7f07018e | 3303 |
| `m3_comp_button_xsmall_leading_space` | int | 0x7f07018f | 3304 |
| `m3_comp_button_xsmall_outlined_outline_width` | int | 0x7f070190 | 3305 |
| `m3_comp_button_xsmall_trailing_space` | int | 0x7f070191 | 3306 |
| `m3_comp_checkbox_selected_disabled_container_opacity` | int | 0x7f070192 | 3307 |
| `m3_comp_date_picker_modal_date_today_container_outline_width` | int | 0x7f070193 | 3308 |
| `m3_comp_date_picker_modal_header_container_height` | int | 0x7f070194 | 3309 |
| `m3_comp_date_picker_modal_range_selection_header_container_height` | int | 0x7f070195 | 3310 |
| `m3_comp_divider_thickness` | int | 0x7f070196 | 3311 |
| `m3_comp_elevated_card_container_elevation` | int | 0x7f070197 | 3312 |
| `m3_comp_elevated_card_icon_size` | int | 0x7f070198 | 3313 |
| `m3_comp_extended_fab_large_container_height` | int | 0x7f070199 | 3314 |
| `m3_comp_extended_fab_large_icon_label_space` | int | 0x7f07019a | 3315 |
| `m3_comp_extended_fab_large_icon_size` | int | 0x7f07019b | 3316 |
| `m3_comp_extended_fab_large_leading_space` | int | 0x7f07019c | 3317 |
| `m3_comp_extended_fab_large_trailing_space` | int | 0x7f07019d | 3318 |
| `m3_comp_extended_fab_medium_container_height` | int | 0x7f07019e | 3319 |
| `m3_comp_extended_fab_medium_icon_label_space` | int | 0x7f07019f | 3320 |
| `m3_comp_extended_fab_medium_icon_size` | int | 0x7f0701a0 | 3321 |
| `m3_comp_extended_fab_medium_leading_space` | int | 0x7f0701a1 | 3322 |
| `m3_comp_extended_fab_medium_trailing_space` | int | 0x7f0701a2 | 3323 |
| `m3_comp_extended_fab_primary_container_container_elevation` | int | 0x7f0701a3 | 3324 |
| `m3_comp_extended_fab_primary_container_focused_container_elevation` | int | 0x7f0701a4 | 3325 |
| `m3_comp_extended_fab_primary_container_focused_state_layer_opacity` | int | 0x7f0701a5 | 3326 |
| `m3_comp_extended_fab_primary_container_hovered_container_elevation` | int | 0x7f0701a6 | 3327 |
| `m3_comp_extended_fab_primary_container_hovered_state_layer_opacity` | int | 0x7f0701a7 | 3328 |
| `m3_comp_extended_fab_primary_container_pressed_container_elevation` | int | 0x7f0701a8 | 3329 |
| `m3_comp_extended_fab_primary_container_pressed_state_layer_opacity` | int | 0x7f0701a9 | 3330 |
| `m3_comp_extended_fab_small_container_height` | int | 0x7f0701aa | 3331 |
| `m3_comp_extended_fab_small_icon_label_space` | int | 0x7f0701ab | 3332 |
| `m3_comp_extended_fab_small_icon_size` | int | 0x7f0701ac | 3333 |
| `m3_comp_extended_fab_small_leading_space` | int | 0x7f0701ad | 3334 |
| `m3_comp_extended_fab_small_trailing_space` | int | 0x7f0701ae | 3335 |
| `m3_comp_fab_container_height` | int | 0x7f0701af | 3336 |
| `m3_comp_fab_icon_size` | int | 0x7f0701b0 | 3337 |
| `m3_comp_fab_large_container_height` | int | 0x7f0701b1 | 3338 |
| `m3_comp_fab_large_icon_size` | int | 0x7f0701b2 | 3339 |
| `m3_comp_fab_medium_container_height` | int | 0x7f0701b3 | 3340 |
| `m3_comp_fab_medium_icon_size` | int | 0x7f0701b4 | 3341 |
| `m3_comp_fab_primary_container_container_elevation` | int | 0x7f0701b5 | 3342 |
| `m3_comp_fab_primary_container_focused_container_elevation` | int | 0x7f0701b6 | 3343 |
| `m3_comp_fab_primary_container_focused_state_layer_opacity` | int | 0x7f0701b7 | 3344 |
| `m3_comp_fab_primary_container_hovered_container_elevation` | int | 0x7f0701b8 | 3345 |
| `m3_comp_fab_primary_container_hovered_state_layer_opacity` | int | 0x7f0701b9 | 3346 |
| `m3_comp_fab_primary_container_pressed_container_elevation` | int | 0x7f0701ba | 3347 |
| `m3_comp_fab_primary_container_pressed_state_layer_opacity` | int | 0x7f0701bb | 3348 |
| `m3_comp_fab_small_container_height` | int | 0x7f0701bc | 3349 |
| `m3_comp_fab_small_icon_size` | int | 0x7f0701bd | 3350 |
| `m3_comp_filled_autocomplete_menu_container_elevation` | int | 0x7f0701be | 3351 |
| `m3_comp_filled_card_container_elevation` | int | 0x7f0701bf | 3352 |
| `m3_comp_filled_card_dragged_state_layer_opacity` | int | 0x7f0701c0 | 3353 |
| `m3_comp_filled_card_focus_state_layer_opacity` | int | 0x7f0701c1 | 3354 |
| `m3_comp_filled_card_hover_state_layer_opacity` | int | 0x7f0701c2 | 3355 |
| `m3_comp_filled_card_icon_size` | int | 0x7f0701c3 | 3356 |
| `m3_comp_filled_card_pressed_state_layer_opacity` | int | 0x7f0701c4 | 3357 |
| `m3_comp_filled_text_field_disabled_active_indicator_opacity` | int | 0x7f0701c5 | 3358 |
| `m3_comp_filter_chip_container_height` | int | 0x7f0701c6 | 3359 |
| `m3_comp_filter_chip_elevated_container_elevation` | int | 0x7f0701c7 | 3360 |
| `m3_comp_filter_chip_flat_container_elevation` | int | 0x7f0701c8 | 3361 |
| `m3_comp_filter_chip_flat_unselected_outline_width` | int | 0x7f0701c9 | 3362 |
| `m3_comp_filter_chip_with_icon_icon_size` | int | 0x7f0701ca | 3363 |
| `m3_comp_icon_button_large_default_leading_space` | int | 0x7f0701cb | 3364 |
| `m3_comp_icon_button_large_default_trailing_space` | int | 0x7f0701cc | 3365 |
| `m3_comp_icon_button_large_icon_size` | int | 0x7f0701cd | 3366 |
| `m3_comp_icon_button_large_narrow_leading_space` | int | 0x7f0701ce | 3367 |
| `m3_comp_icon_button_large_narrow_trailing_space` | int | 0x7f0701cf | 3368 |
| `m3_comp_icon_button_large_outlined_outline_width` | int | 0x7f0701d0 | 3369 |
| `m3_comp_icon_button_large_wide_leading_space` | int | 0x7f0701d1 | 3370 |
| `m3_comp_icon_button_large_wide_trailing_space` | int | 0x7f0701d2 | 3371 |
| `m3_comp_icon_button_medium_default_leading_space` | int | 0x7f0701d3 | 3372 |
| `m3_comp_icon_button_medium_default_trailing_space` | int | 0x7f0701d4 | 3373 |
| `m3_comp_icon_button_medium_icon_size` | int | 0x7f0701d5 | 3374 |
| `m3_comp_icon_button_medium_narrow_leading_space` | int | 0x7f0701d6 | 3375 |
| `m3_comp_icon_button_medium_narrow_trailing_space` | int | 0x7f0701d7 | 3376 |
| `m3_comp_icon_button_medium_outlined_outline_width` | int | 0x7f0701d8 | 3377 |
| `m3_comp_icon_button_medium_wide_leading_space` | int | 0x7f0701d9 | 3378 |
| `m3_comp_icon_button_medium_wide_trailing_space` | int | 0x7f0701da | 3379 |
| `m3_comp_icon_button_small_default_leading_space` | int | 0x7f0701db | 3380 |
| `m3_comp_icon_button_small_default_trailing_space` | int | 0x7f0701dc | 3381 |
| `m3_comp_icon_button_small_icon_size` | int | 0x7f0701dd | 3382 |
| `m3_comp_icon_button_small_narrow_leading_space` | int | 0x7f0701de | 3383 |
| `m3_comp_icon_button_small_narrow_trailing_space` | int | 0x7f0701df | 3384 |
| `m3_comp_icon_button_small_outlined_outline_width` | int | 0x7f0701e0 | 3385 |
| `m3_comp_icon_button_small_wide_leading_space` | int | 0x7f0701e1 | 3386 |
| `m3_comp_icon_button_small_wide_trailing_space` | int | 0x7f0701e2 | 3387 |
| `m3_comp_icon_button_xlarge_default_leading_space` | int | 0x7f0701e3 | 3388 |
| `m3_comp_icon_button_xlarge_default_trailing_space` | int | 0x7f0701e4 | 3389 |
| `m3_comp_icon_button_xlarge_icon_size` | int | 0x7f0701e5 | 3390 |
| `m3_comp_icon_button_xlarge_narrow_leading_space` | int | 0x7f0701e6 | 3391 |
| `m3_comp_icon_button_xlarge_narrow_trailing_space` | int | 0x7f0701e7 | 3392 |
| `m3_comp_icon_button_xlarge_outlined_outline_width` | int | 0x7f0701e8 | 3393 |
| `m3_comp_icon_button_xlarge_wide_leading_space` | int | 0x7f0701e9 | 3394 |
| `m3_comp_icon_button_xlarge_wide_trailing_space` | int | 0x7f0701ea | 3395 |
| `m3_comp_icon_button_xsmall_default_leading_space` | int | 0x7f0701eb | 3396 |
| `m3_comp_icon_button_xsmall_default_trailing_space` | int | 0x7f0701ec | 3397 |
| `m3_comp_icon_button_xsmall_icon_size` | int | 0x7f0701ed | 3398 |
| `m3_comp_icon_button_xsmall_narrow_leading_space` | int | 0x7f0701ee | 3399 |
| `m3_comp_icon_button_xsmall_narrow_trailing_space` | int | 0x7f0701ef | 3400 |
| `m3_comp_icon_button_xsmall_outlined_outline_width` | int | 0x7f0701f0 | 3401 |
| `m3_comp_icon_button_xsmall_wide_leading_space` | int | 0x7f0701f1 | 3402 |
| `m3_comp_icon_button_xsmall_wide_trailing_space` | int | 0x7f0701f2 | 3403 |
| `m3_comp_input_chip_container_elevation` | int | 0x7f0701f3 | 3404 |
| `m3_comp_input_chip_container_height` | int | 0x7f0701f4 | 3405 |
| `m3_comp_input_chip_unselected_outline_width` | int | 0x7f0701f5 | 3406 |
| `m3_comp_input_chip_with_avatar_avatar_size` | int | 0x7f0701f6 | 3407 |
| `m3_comp_input_chip_with_leading_icon_leading_icon_size` | int | 0x7f0701f7 | 3408 |
| `m3_comp_loading_indicator_container_height` | int | 0x7f0701f8 | 3409 |
| `m3_comp_loading_indicator_container_width` | int | 0x7f0701f9 | 3410 |
| `m3_comp_menu_container_elevation` | int | 0x7f0701fa | 3411 |
| `m3_comp_nav_bar_container_elevation` | int | 0x7f0701fb | 3412 |
| `m3_comp_nav_bar_container_height` | int | 0x7f0701fc | 3413 |
| `m3_comp_nav_bar_item_active_indicator_icon_label_space` | int | 0x7f0701fd | 3414 |
| `m3_comp_nav_bar_item_horizontal_active_indicator_height` | int | 0x7f0701fe | 3415 |
| `m3_comp_nav_bar_item_icon_size` | int | 0x7f0701ff | 3416 |
| `m3_comp_nav_bar_item_vertical_active_indicator_height` | int | 0x7f070200 | 3417 |
| `m3_comp_nav_bar_item_vertical_active_indicator_width` | int | 0x7f070201 | 3418 |
| `m3_comp_nav_bar_item_vertical_container_between_space` | int | 0x7f070202 | 3419 |
| `m3_comp_nav_rail_collapsed_container_elevation` | int | 0x7f070203 | 3420 |
| `m3_comp_nav_rail_collapsed_container_width` | int | 0x7f070204 | 3421 |
| `m3_comp_nav_rail_collapsed_item_vertical_space` | int | 0x7f070205 | 3422 |
| `m3_comp_nav_rail_collapsed_narrow_container_width` | int | 0x7f070206 | 3423 |
| `m3_comp_nav_rail_collapsed_top_space` | int | 0x7f070207 | 3424 |
| `m3_comp_nav_rail_expanded_container_width_maximum` | int | 0x7f070208 | 3425 |
| `m3_comp_nav_rail_expanded_container_width_minimum` | int | 0x7f070209 | 3426 |
| `m3_comp_nav_rail_item_active_focused_state_layer_opacity` | int | 0x7f07020a | 3427 |
| `m3_comp_nav_rail_item_active_hovered_state_layer_opacity` | int | 0x7f07020b | 3428 |
| `m3_comp_nav_rail_item_active_pressed_state_layer_opacity` | int | 0x7f07020c | 3429 |
| `m3_comp_nav_rail_item_container_height` | int | 0x7f07020d | 3430 |
| `m3_comp_nav_rail_item_container_vertical_space` | int | 0x7f07020e | 3431 |
| `m3_comp_nav_rail_item_header_space_minimum` | int | 0x7f07020f | 3432 |
| `m3_comp_nav_rail_item_horizontal_active_indicator_height` | int | 0x7f070210 | 3433 |
| `m3_comp_nav_rail_item_horizontal_full_width_leading_space` | int | 0x7f070211 | 3434 |
| `m3_comp_nav_rail_item_horizontal_full_width_trailing_space` | int | 0x7f070212 | 3435 |
| `m3_comp_nav_rail_item_horizontal_icon_label_space` | int | 0x7f070213 | 3436 |
| `m3_comp_nav_rail_item_icon_size` | int | 0x7f070214 | 3437 |
| `m3_comp_nav_rail_item_short_container_height` | int | 0x7f070215 | 3438 |
| `m3_comp_nav_rail_item_vertical_active_indicator_height` | int | 0x7f070216 | 3439 |
| `m3_comp_nav_rail_item_vertical_active_indicator_width` | int | 0x7f070217 | 3440 |
| `m3_comp_nav_rail_item_vertical_icon_label_space` | int | 0x7f070218 | 3441 |
| `m3_comp_nav_rail_item_vertical_leading_space` | int | 0x7f070219 | 3442 |
| `m3_comp_nav_rail_item_vertical_trailing_space` | int | 0x7f07021a | 3443 |
| `m3_comp_navigation_drawer_container_width` | int | 0x7f07021b | 3444 |
| `m3_comp_navigation_drawer_focus_state_layer_opacity` | int | 0x7f07021c | 3445 |
| `m3_comp_navigation_drawer_hover_state_layer_opacity` | int | 0x7f07021d | 3446 |
| `m3_comp_navigation_drawer_icon_size` | int | 0x7f07021e | 3447 |
| `m3_comp_navigation_drawer_modal_container_elevation` | int | 0x7f07021f | 3448 |
| `m3_comp_navigation_drawer_pressed_state_layer_opacity` | int | 0x7f070220 | 3449 |
| `m3_comp_navigation_drawer_standard_container_elevation` | int | 0x7f070221 | 3450 |
| `m3_comp_outlined_autocomplete_menu_container_elevation` | int | 0x7f070222 | 3451 |
| `m3_comp_outlined_card_container_elevation` | int | 0x7f070223 | 3452 |
| `m3_comp_outlined_card_disabled_outline_opacity` | int | 0x7f070224 | 3453 |
| `m3_comp_outlined_card_icon_size` | int | 0x7f070225 | 3454 |
| `m3_comp_outlined_card_outline_width` | int | 0x7f070226 | 3455 |
| `m3_comp_outlined_text_field_disabled_input_text_opacity` | int | 0x7f070227 | 3456 |
| `m3_comp_outlined_text_field_disabled_label_text_opacity` | int | 0x7f070228 | 3457 |
| `m3_comp_outlined_text_field_disabled_supporting_text_opacity` | int | 0x7f070229 | 3458 |
| `m3_comp_outlined_text_field_focus_outline_width` | int | 0x7f07022a | 3459 |
| `m3_comp_outlined_text_field_outline_width` | int | 0x7f07022b | 3460 |
| `m3_comp_primary_navigation_tab_active_focus_state_layer_opacity` | int | 0x7f07022c | 3461 |
| `m3_comp_primary_navigation_tab_active_hover_state_layer_opacity` | int | 0x7f07022d | 3462 |
| `m3_comp_primary_navigation_tab_active_indicator_height` | int | 0x7f07022e | 3463 |
| `m3_comp_primary_navigation_tab_active_pressed_state_layer_opacity` | int | 0x7f07022f | 3464 |
| `m3_comp_primary_navigation_tab_inactive_focus_state_layer_opacity` | int | 0x7f070230 | 3465 |
| `m3_comp_primary_navigation_tab_inactive_hover_state_layer_opacity` | int | 0x7f070231 | 3466 |
| `m3_comp_primary_navigation_tab_inactive_pressed_state_layer_opacity` | int | 0x7f070232 | 3467 |
| `m3_comp_primary_navigation_tab_with_icon_icon_size` | int | 0x7f070233 | 3468 |
| `m3_comp_progress_indicator_circular_active_indicator_wave_amplitude` | int | 0x7f070234 | 3469 |
| `m3_comp_progress_indicator_circular_active_indicator_wave_wavelength` | int | 0x7f070235 | 3470 |
| `m3_comp_progress_indicator_circular_size` | int | 0x7f070236 | 3471 |
| `m3_comp_progress_indicator_circular_track_active_indicator_space` | int | 0x7f070237 | 3472 |
| `m3_comp_progress_indicator_circular_track_thickness` | int | 0x7f070238 | 3473 |
| `m3_comp_progress_indicator_circular_with_wave_size` | int | 0x7f070239 | 3474 |
| `m3_comp_progress_indicator_linear_active_indicator_wave_amplitude` | int | 0x7f07023a | 3475 |
| `m3_comp_progress_indicator_linear_active_indicator_wave_wavelength` | int | 0x7f07023b | 3476 |
| `m3_comp_progress_indicator_linear_indeterminate_active_indicator_wave_wavelength` | int | 0x7f07023c | 3477 |
| `m3_comp_progress_indicator_linear_stop_indicator_size` | int | 0x7f07023d | 3478 |
| `m3_comp_progress_indicator_linear_track_active_indicator_space` | int | 0x7f07023e | 3479 |
| `m3_comp_progress_indicator_linear_track_thickness` | int | 0x7f07023f | 3480 |
| `m3_comp_radio_button_disabled_selected_icon_opacity` | int | 0x7f070240 | 3481 |
| `m3_comp_radio_button_disabled_unselected_icon_opacity` | int | 0x7f070241 | 3482 |
| `m3_comp_radio_button_selected_focus_state_layer_opacity` | int | 0x7f070242 | 3483 |
| `m3_comp_radio_button_selected_hover_state_layer_opacity` | int | 0x7f070243 | 3484 |
| `m3_comp_radio_button_selected_pressed_state_layer_opacity` | int | 0x7f070244 | 3485 |
| `m3_comp_radio_button_unselected_focus_state_layer_opacity` | int | 0x7f070245 | 3486 |
| `m3_comp_radio_button_unselected_hover_state_layer_opacity` | int | 0x7f070246 | 3487 |
| `m3_comp_radio_button_unselected_pressed_state_layer_opacity` | int | 0x7f070247 | 3488 |
| `m3_comp_scrim_container_opacity` | int | 0x7f070248 | 3489 |
| `m3_comp_search_bar_avatar_size` | int | 0x7f070249 | 3490 |
| `m3_comp_search_bar_container_elevation` | int | 0x7f07024a | 3491 |
| `m3_comp_search_bar_container_height` | int | 0x7f07024b | 3492 |
| `m3_comp_search_bar_hover_state_layer_opacity` | int | 0x7f07024c | 3493 |
| `m3_comp_search_bar_pressed_state_layer_opacity` | int | 0x7f07024d | 3494 |
| `m3_comp_search_view_container_elevation` | int | 0x7f07024e | 3495 |
| `m3_comp_search_view_docked_header_container_height` | int | 0x7f07024f | 3496 |
| `m3_comp_search_view_full_screen_header_container_height` | int | 0x7f070250 | 3497 |
| `m3_comp_secondary_navigation_tab_active_indicator_height` | int | 0x7f070251 | 3498 |
| `m3_comp_secondary_navigation_tab_focus_state_layer_opacity` | int | 0x7f070252 | 3499 |
| `m3_comp_secondary_navigation_tab_hover_state_layer_opacity` | int | 0x7f070253 | 3500 |
| `m3_comp_secondary_navigation_tab_pressed_state_layer_opacity` | int | 0x7f070254 | 3501 |
| `m3_comp_sheet_bottom_docked_drag_handle_height` | int | 0x7f070255 | 3502 |
| `m3_comp_sheet_bottom_docked_drag_handle_width` | int | 0x7f070256 | 3503 |
| `m3_comp_sheet_bottom_docked_modal_container_elevation` | int | 0x7f070257 | 3504 |
| `m3_comp_sheet_bottom_docked_standard_container_elevation` | int | 0x7f070258 | 3505 |
| `m3_comp_sheet_side_docked_container_width` | int | 0x7f070259 | 3506 |
| `m3_comp_sheet_side_docked_modal_container_elevation` | int | 0x7f07025a | 3507 |
| `m3_comp_sheet_side_docked_standard_container_elevation` | int | 0x7f07025b | 3508 |
| `m3_comp_slider_active_handle_height` | int | 0x7f07025c | 3509 |
| `m3_comp_slider_active_handle_leading_space` | int | 0x7f07025d | 3510 |
| `m3_comp_slider_active_handle_width` | int | 0x7f07025e | 3511 |
| `m3_comp_slider_active_stop_indicator_container_opacity` | int | 0x7f07025f | 3512 |
| `m3_comp_slider_disabled_active_track_opacity` | int | 0x7f070260 | 3513 |
| `m3_comp_slider_disabled_handle_opacity` | int | 0x7f070261 | 3514 |
| `m3_comp_slider_disabled_inactive_track_opacity` | int | 0x7f070262 | 3515 |
| `m3_comp_slider_inactive_stop_indicator_container_opacity` | int | 0x7f070263 | 3516 |
| `m3_comp_slider_inactive_track_height` | int | 0x7f070264 | 3517 |
| `m3_comp_slider_large_active_handle_height` | int | 0x7f070265 | 3518 |
| `m3_comp_slider_large_active_track_height` | int | 0x7f070266 | 3519 |
| `m3_comp_slider_large_active_track_shape_leading` | int | 0x7f070267 | 3520 |
| `m3_comp_slider_large_icon_size` | int | 0x7f070268 | 3521 |
| `m3_comp_slider_medium_active_handle_height` | int | 0x7f070269 | 3522 |
| `m3_comp_slider_medium_active_track_height` | int | 0x7f07026a | 3523 |
| `m3_comp_slider_medium_active_track_shape_leading` | int | 0x7f07026b | 3524 |
| `m3_comp_slider_medium_icon_size` | int | 0x7f07026c | 3525 |
| `m3_comp_slider_small_active_handle_height` | int | 0x7f07026d | 3526 |
| `m3_comp_slider_small_active_track_height` | int | 0x7f07026e | 3527 |
| `m3_comp_slider_small_active_track_shape_leading` | int | 0x7f07026f | 3528 |
| `m3_comp_slider_stop_indicator_size` | int | 0x7f070270 | 3529 |
| `m3_comp_slider_value_indicator_active_bottom_space` | int | 0x7f070271 | 3530 |
| `m3_comp_slider_xlarge_active_handle_height` | int | 0x7f070272 | 3531 |
| `m3_comp_slider_xlarge_active_track_height` | int | 0x7f070273 | 3532 |
| `m3_comp_slider_xlarge_active_track_shape_leading` | int | 0x7f070274 | 3533 |
| `m3_comp_slider_xlarge_icon_size` | int | 0x7f070275 | 3534 |
| `m3_comp_slider_xsmall_active_handle_height` | int | 0x7f070276 | 3535 |
| `m3_comp_slider_xsmall_active_track_height` | int | 0x7f070277 | 3536 |
| `m3_comp_slider_xsmall_active_track_shape_leading` | int | 0x7f070278 | 3537 |
| `m3_comp_snackbar_container_elevation` | int | 0x7f070279 | 3538 |
| `m3_comp_split_button_large_leading_button_leading_space` | int | 0x7f07027a | 3539 |
| `m3_comp_split_button_large_leading_button_trailing_space` | int | 0x7f07027b | 3540 |
| `m3_comp_split_button_large_trailing_button_icon_size` | int | 0x7f07027c | 3541 |
| `m3_comp_split_button_large_trailing_button_leading_space` | int | 0x7f07027d | 3542 |
| `m3_comp_split_button_large_trailing_button_trailing_space` | int | 0x7f07027e | 3543 |
| `m3_comp_split_button_medium_leading_button_leading_space` | int | 0x7f07027f | 3544 |
| `m3_comp_split_button_medium_leading_button_trailing_space` | int | 0x7f070280 | 3545 |
| `m3_comp_split_button_medium_trailing_button_icon_size` | int | 0x7f070281 | 3546 |
| `m3_comp_split_button_medium_trailing_button_leading_space` | int | 0x7f070282 | 3547 |
| `m3_comp_split_button_medium_trailing_button_trailing_space` | int | 0x7f070283 | 3548 |
| `m3_comp_split_button_small_leading_button_leading_space` | int | 0x7f070284 | 3549 |
| `m3_comp_split_button_small_leading_button_trailing_space` | int | 0x7f070285 | 3550 |
| `m3_comp_split_button_small_trailing_button_icon_size` | int | 0x7f070286 | 3551 |
| `m3_comp_split_button_small_trailing_button_leading_space` | int | 0x7f070287 | 3552 |
| `m3_comp_split_button_small_trailing_button_trailing_space` | int | 0x7f070288 | 3553 |
| `m3_comp_split_button_xlarge_leading_button_leading_space` | int | 0x7f070289 | 3554 |
| `m3_comp_split_button_xlarge_leading_button_trailing_space` | int | 0x7f07028a | 3555 |
| `m3_comp_split_button_xlarge_trailing_button_icon_size` | int | 0x7f07028b | 3556 |
| `m3_comp_split_button_xlarge_trailing_button_leading_space` | int | 0x7f07028c | 3557 |
| `m3_comp_split_button_xlarge_trailing_button_trailing_space` | int | 0x7f07028d | 3558 |
| `m3_comp_split_button_xsmall_leading_button_leading_space` | int | 0x7f07028e | 3559 |
| `m3_comp_split_button_xsmall_leading_button_trailing_space` | int | 0x7f07028f | 3560 |
| `m3_comp_split_button_xsmall_trailing_button_icon_size` | int | 0x7f070290 | 3561 |
| `m3_comp_split_button_xsmall_trailing_button_leading_space` | int | 0x7f070291 | 3562 |
| `m3_comp_split_button_xsmall_trailing_button_trailing_space` | int | 0x7f070292 | 3563 |
| `m3_comp_suggestion_chip_container_height` | int | 0x7f070293 | 3564 |
| `m3_comp_suggestion_chip_elevated_container_elevation` | int | 0x7f070294 | 3565 |
| `m3_comp_suggestion_chip_flat_container_elevation` | int | 0x7f070295 | 3566 |
| `m3_comp_suggestion_chip_flat_outline_width` | int | 0x7f070296 | 3567 |
| `m3_comp_suggestion_chip_with_leading_icon_leading_icon_size` | int | 0x7f070297 | 3568 |
| `m3_comp_switch_disabled_selected_handle_opacity` | int | 0x7f070298 | 3569 |
| `m3_comp_switch_disabled_selected_icon_opacity` | int | 0x7f070299 | 3570 |
| `m3_comp_switch_disabled_track_opacity` | int | 0x7f07029a | 3571 |
| `m3_comp_switch_disabled_unselected_handle_opacity` | int | 0x7f07029b | 3572 |
| `m3_comp_switch_disabled_unselected_icon_opacity` | int | 0x7f07029c | 3573 |
| `m3_comp_switch_selected_focus_state_layer_opacity` | int | 0x7f07029d | 3574 |
| `m3_comp_switch_selected_hover_state_layer_opacity` | int | 0x7f07029e | 3575 |
| `m3_comp_switch_selected_pressed_state_layer_opacity` | int | 0x7f07029f | 3576 |
| `m3_comp_switch_track_height` | int | 0x7f0702a0 | 3577 |
| `m3_comp_switch_track_width` | int | 0x7f0702a1 | 3578 |
| `m3_comp_switch_unselected_focus_state_layer_opacity` | int | 0x7f0702a2 | 3579 |
| `m3_comp_switch_unselected_hover_state_layer_opacity` | int | 0x7f0702a3 | 3580 |
| `m3_comp_switch_unselected_pressed_state_layer_opacity` | int | 0x7f0702a4 | 3581 |
| `m3_comp_time_input_time_input_field_focus_outline_width` | int | 0x7f0702a5 | 3582 |
| `m3_comp_time_picker_container_elevation` | int | 0x7f0702a6 | 3583 |
| `m3_comp_time_picker_period_selector_focus_state_layer_opacity` | int | 0x7f0702a7 | 3584 |
| `m3_comp_time_picker_period_selector_hover_state_layer_opacity` | int | 0x7f0702a8 | 3585 |
| `m3_comp_time_picker_period_selector_outline_width` | int | 0x7f0702a9 | 3586 |
| `m3_comp_time_picker_period_selector_pressed_state_layer_opacity` | int | 0x7f0702aa | 3587 |
| `m3_comp_time_picker_time_selector_focus_state_layer_opacity` | int | 0x7f0702ab | 3588 |
| `m3_comp_time_picker_time_selector_hover_state_layer_opacity` | int | 0x7f0702ac | 3589 |
| `m3_comp_time_picker_time_selector_pressed_state_layer_opacity` | int | 0x7f0702ad | 3590 |
| `m3_comp_toolbar_docked_container_height` | int | 0x7f0702ae | 3591 |
| `m3_comp_toolbar_docked_container_leading_space` | int | 0x7f0702af | 3592 |
| `m3_comp_toolbar_docked_container_trailing_space` | int | 0x7f0702b0 | 3593 |
| `m3_comp_toolbar_floating_container_elevation` | int | 0x7f0702b1 | 3594 |
| `m3_comp_toolbar_floating_container_leading_space` | int | 0x7f0702b2 | 3595 |
| `m3_comp_toolbar_floating_container_trailing_space` | int | 0x7f0702b3 | 3596 |
| `m3_comp_toolbar_floating_horizontal_container_height` | int | 0x7f0702b4 | 3597 |
| `m3_comp_toolbar_floating_vertical_container_width` | int | 0x7f0702b5 | 3598 |
| `m3_comp_toolbar_standard_disabled_icon_opacity` | int | 0x7f0702b6 | 3599 |
| `m3_comp_toolbar_standard_disabled_label_text_opacity` | int | 0x7f0702b7 | 3600 |
| `m3_comp_toolbar_vibrant_disabled_icon_opacity` | int | 0x7f0702b8 | 3601 |
| `m3_comp_toolbar_vibrant_disabled_label_text_opacity` | int | 0x7f0702b9 | 3602 |
| `m3_datepicker_elevation` | int | 0x7f0702ba | 3603 |
| `m3_divider_heavy_thickness` | int | 0x7f0702bb | 3604 |
| `m3_extended_fab_bottom_padding` | int | 0x7f0702bc | 3605 |
| `m3_extended_fab_disabled_elevation` | int | 0x7f0702bd | 3606 |
| `m3_extended_fab_disabled_translation_z` | int | 0x7f0702be | 3607 |
| `m3_extended_fab_end_padding` | int | 0x7f0702bf | 3608 |
| `m3_extended_fab_icon_padding` | int | 0x7f0702c0 | 3609 |
| `m3_extended_fab_min_height` | int | 0x7f0702c1 | 3610 |
| `m3_extended_fab_start_padding` | int | 0x7f0702c2 | 3611 |
| `m3_extended_fab_top_padding` | int | 0x7f0702c3 | 3612 |
| `m3_extended_fab_translation_z_base` | int | 0x7f0702c4 | 3613 |
| `m3_extended_fab_translation_z_focused` | int | 0x7f0702c5 | 3614 |
| `m3_extended_fab_translation_z_hovered` | int | 0x7f0702c6 | 3615 |
| `m3_extended_fab_translation_z_pressed` | int | 0x7f0702c7 | 3616 |
| `m3_fab_border_width` | int | 0x7f0702c8 | 3617 |
| `m3_fab_corner_size` | int | 0x7f0702c9 | 3618 |
| `m3_fab_disabled_elevation` | int | 0x7f0702ca | 3619 |
| `m3_fab_disabled_translation_z` | int | 0x7f0702cb | 3620 |
| `m3_fab_translation_z_base` | int | 0x7f0702cc | 3621 |
| `m3_fab_translation_z_focused` | int | 0x7f0702cd | 3622 |
| `m3_fab_translation_z_hovered` | int | 0x7f0702ce | 3623 |
| `m3_fab_translation_z_pressed` | int | 0x7f0702cf | 3624 |
| `m3_floatingtoolbar_min_height` | int | 0x7f0702d0 | 3625 |
| `m3_floatingtoolbar_min_width` | int | 0x7f0702d1 | 3626 |
| `m3_large_fab_max_image_size` | int | 0x7f0702d2 | 3627 |
| `m3_large_fab_size` | int | 0x7f0702d3 | 3628 |
| `m3_large_text_vertical_offset_adjustment` | int | 0x7f0702d4 | 3629 |
| `m3_loading_indicator_container_size` | int | 0x7f0702d5 | 3630 |
| `m3_loading_indicator_shape_size` | int | 0x7f0702d6 | 3631 |
| `m3_menu_elevation` | int | 0x7f0702d7 | 3632 |
| `m3_multiline_hint_filled_text_extra_space` | int | 0x7f0702d8 | 3633 |
| `m3_nav_badge_with_text_vertical_offset` | int | 0x7f0702d9 | 3634 |
| `m3_navigation_content_horizontal_margin` | int | 0x7f0702da | 3635 |
| `m3_navigation_divider_bottom_margin` | int | 0x7f0702db | 3636 |
| `m3_navigation_divider_top_margin` | int | 0x7f0702dc | 3637 |
| `m3_navigation_drawer_layout_corner_size` | int | 0x7f0702dd | 3638 |
| `m3_navigation_item_active_indicator_label_padding` | int | 0x7f0702de | 3639 |
| `m3_navigation_item_expanded_active_indicator_height_default` | int | 0x7f0702df | 3640 |
| `m3_navigation_item_horizontal_padding` | int | 0x7f0702e0 | 3641 |
| `m3_navigation_item_icon_padding` | int | 0x7f0702e1 | 3642 |
| `m3_navigation_item_leading_trailing_space` | int | 0x7f0702e2 | 3643 |
| `m3_navigation_item_shape_inset_bottom` | int | 0x7f0702e3 | 3644 |
| `m3_navigation_item_shape_inset_end` | int | 0x7f0702e4 | 3645 |
| `m3_navigation_item_shape_inset_start` | int | 0x7f0702e5 | 3646 |
| `m3_navigation_item_shape_inset_top` | int | 0x7f0702e6 | 3647 |
| `m3_navigation_item_vertical_padding` | int | 0x7f0702e7 | 3648 |
| `m3_navigation_menu_divider_horizontal_padding` | int | 0x7f0702e8 | 3649 |
| `m3_navigation_menu_headline_horizontal_padding` | int | 0x7f0702e9 | 3650 |
| `m3_navigation_rail_default_width` | int | 0x7f0702ea | 3651 |
| `m3_navigation_rail_elevation` | int | 0x7f0702eb | 3652 |
| `m3_navigation_rail_expanded_active_indicator_height` | int | 0x7f0702ec | 3653 |
| `m3_navigation_rail_expanded_item_spacing` | int | 0x7f0702ed | 3654 |
| `m3_navigation_rail_expanded_leading_trailing_space` | int | 0x7f0702ee | 3655 |
| `m3_navigation_rail_icon_label_horizontal_padding` | int | 0x7f0702ef | 3656 |
| `m3_navigation_rail_icon_label_padding` | int | 0x7f0702f0 | 3657 |
| `m3_navigation_rail_icon_size` | int | 0x7f0702f1 | 3658 |
| `m3_navigation_rail_item_active_indicator_height` | int | 0x7f0702f2 | 3659 |
| `m3_navigation_rail_item_active_indicator_margin_horizontal` | int | 0x7f0702f3 | 3660 |
| `m3_navigation_rail_item_active_indicator_width` | int | 0x7f0702f4 | 3661 |
| `m3_navigation_rail_item_min_height` | int | 0x7f0702f5 | 3662 |
| `m3_navigation_rail_item_padding_bottom` | int | 0x7f0702f6 | 3663 |
| `m3_navigation_rail_item_padding_bottom_with_large_font` | int | 0x7f0702f7 | 3664 |
| `m3_navigation_rail_item_padding_top` | int | 0x7f0702f8 | 3665 |
| `m3_navigation_rail_item_padding_top_with_large_font` | int | 0x7f0702f9 | 3666 |
| `m3_navigation_rail_label_padding_horizontal` | int | 0x7f0702fa | 3667 |
| `m3_navigation_rail_max_expanded_width` | int | 0x7f0702fb | 3668 |
| `m3_navigation_rail_min_expanded_width` | int | 0x7f0702fc | 3669 |
| `m3_navigation_subheader_horizontal_padding` | int | 0x7f0702fd | 3670 |
| `m3_navigation_subheader_top_margin` | int | 0x7f0702fe | 3671 |
| `m3_navigation_subheader_vertical_padding` | int | 0x7f0702ff | 3672 |
| `m3_ripple_default_alpha` | int | 0x7f070300 | 3673 |
| `m3_ripple_focused_alpha` | int | 0x7f070301 | 3674 |
| `m3_ripple_hovered_alpha` | int | 0x7f070302 | 3675 |
| `m3_ripple_pressed_alpha` | int | 0x7f070303 | 3676 |
| `m3_ripple_selectable_pressed_alpha` | int | 0x7f070304 | 3677 |
| `m3_searchbar_elevation` | int | 0x7f070305 | 3678 |
| `m3_searchbar_height` | int | 0x7f070306 | 3679 |
| `m3_searchbar_margin_horizontal` | int | 0x7f070307 | 3680 |
| `m3_searchbar_margin_vertical` | int | 0x7f070308 | 3681 |
| `m3_searchbar_outlined_stroke_width` | int | 0x7f070309 | 3682 |
| `m3_searchbar_padding_start` | int | 0x7f07030a | 3683 |
| `m3_searchbar_text_margin_start_no_navigation_icon` | int | 0x7f07030b | 3684 |
| `m3_searchbar_text_size` | int | 0x7f07030c | 3685 |
| `m3_searchview_divider_size` | int | 0x7f07030d | 3686 |
| `m3_searchview_elevation` | int | 0x7f07030e | 3687 |
| `m3_searchview_height` | int | 0x7f07030f | 3688 |
| `m3_side_sheet_margin_detached` | int | 0x7f070310 | 3689 |
| `m3_side_sheet_modal_elevation` | int | 0x7f070311 | 3690 |
| `m3_side_sheet_standard_elevation` | int | 0x7f070312 | 3691 |
| `m3_side_sheet_width` | int | 0x7f070313 | 3692 |
| `m3_simple_item_color_hovered_alpha` | int | 0x7f070314 | 3693 |
| `m3_simple_item_color_selected_alpha` | int | 0x7f070315 | 3694 |
| `m3_slider_thumb_elevation` | int | 0x7f070316 | 3695 |
| `m3_slider_track_icon_padding` | int | 0x7f070317 | 3696 |
| `m3_small_fab_max_image_size` | int | 0x7f070318 | 3697 |
| `m3_small_fab_size` | int | 0x7f070319 | 3698 |
| `m3_snackbar_action_text_color_alpha` | int | 0x7f07031a | 3699 |
| `m3_snackbar_margin` | int | 0x7f07031b | 3700 |
| `m3_sys_elevation_level0` | int | 0x7f07031c | 3701 |
| `m3_sys_elevation_level1` | int | 0x7f07031d | 3702 |
| `m3_sys_elevation_level2` | int | 0x7f07031e | 3703 |
| `m3_sys_elevation_level3` | int | 0x7f07031f | 3704 |
| `m3_sys_elevation_level4` | int | 0x7f070320 | 3705 |
| `m3_sys_elevation_level5` | int | 0x7f070321 | 3706 |
| `m3_sys_motion_easing_emphasized_accelerate_control_x1` | int | 0x7f070322 | 3707 |
| `m3_sys_motion_easing_emphasized_accelerate_control_x2` | int | 0x7f070323 | 3708 |
| `m3_sys_motion_easing_emphasized_accelerate_control_y1` | int | 0x7f070324 | 3709 |
| `m3_sys_motion_easing_emphasized_accelerate_control_y2` | int | 0x7f070325 | 3710 |
| `m3_sys_motion_easing_emphasized_decelerate_control_x1` | int | 0x7f070326 | 3711 |
| `m3_sys_motion_easing_emphasized_decelerate_control_x2` | int | 0x7f070327 | 3712 |
| `m3_sys_motion_easing_emphasized_decelerate_control_y1` | int | 0x7f070328 | 3713 |
| `m3_sys_motion_easing_emphasized_decelerate_control_y2` | int | 0x7f070329 | 3714 |
| `m3_sys_motion_easing_legacy_accelerate_control_x1` | int | 0x7f07032a | 3715 |
| `m3_sys_motion_easing_legacy_accelerate_control_x2` | int | 0x7f07032b | 3716 |
| `m3_sys_motion_easing_legacy_accelerate_control_y1` | int | 0x7f07032c | 3717 |
| `m3_sys_motion_easing_legacy_accelerate_control_y2` | int | 0x7f07032d | 3718 |
| `m3_sys_motion_easing_legacy_control_x1` | int | 0x7f07032e | 3719 |
| `m3_sys_motion_easing_legacy_control_x2` | int | 0x7f07032f | 3720 |
| `m3_sys_motion_easing_legacy_control_y1` | int | 0x7f070330 | 3721 |
| `m3_sys_motion_easing_legacy_control_y2` | int | 0x7f070331 | 3722 |
| `m3_sys_motion_easing_legacy_decelerate_control_x1` | int | 0x7f070332 | 3723 |
| `m3_sys_motion_easing_legacy_decelerate_control_x2` | int | 0x7f070333 | 3724 |
| `m3_sys_motion_easing_legacy_decelerate_control_y1` | int | 0x7f070334 | 3725 |
| `m3_sys_motion_easing_legacy_decelerate_control_y2` | int | 0x7f070335 | 3726 |
| `m3_sys_motion_easing_linear_control_x1` | int | 0x7f070336 | 3727 |
| `m3_sys_motion_easing_linear_control_x2` | int | 0x7f070337 | 3728 |
| `m3_sys_motion_easing_linear_control_y1` | int | 0x7f070338 | 3729 |
| `m3_sys_motion_easing_linear_control_y2` | int | 0x7f070339 | 3730 |
| `m3_sys_motion_easing_standard_accelerate_control_x1` | int | 0x7f07033a | 3731 |
| `m3_sys_motion_easing_standard_accelerate_control_x2` | int | 0x7f07033b | 3732 |
| `m3_sys_motion_easing_standard_accelerate_control_y1` | int | 0x7f07033c | 3733 |
| `m3_sys_motion_easing_standard_accelerate_control_y2` | int | 0x7f07033d | 3734 |
| `m3_sys_motion_easing_standard_control_x1` | int | 0x7f07033e | 3735 |
| `m3_sys_motion_easing_standard_control_x2` | int | 0x7f07033f | 3736 |
| `m3_sys_motion_easing_standard_control_y1` | int | 0x7f070340 | 3737 |
| `m3_sys_motion_easing_standard_control_y2` | int | 0x7f070341 | 3738 |
| `m3_sys_motion_easing_standard_decelerate_control_x1` | int | 0x7f070342 | 3739 |
| `m3_sys_motion_easing_standard_decelerate_control_x2` | int | 0x7f070343 | 3740 |
| `m3_sys_motion_easing_standard_decelerate_control_y1` | int | 0x7f070344 | 3741 |
| `m3_sys_motion_easing_standard_decelerate_control_y2` | int | 0x7f070345 | 3742 |
| `m3_sys_motion_standard_spring_default_effects_damping` | int | 0x7f070346 | 3743 |
| `m3_sys_motion_standard_spring_default_effects_stiffness` | int | 0x7f070347 | 3744 |
| `m3_sys_motion_standard_spring_default_spatial_damping` | int | 0x7f070348 | 3745 |
| `m3_sys_motion_standard_spring_default_spatial_stiffness` | int | 0x7f070349 | 3746 |
| `m3_sys_motion_standard_spring_fast_effects_damping` | int | 0x7f07034a | 3747 |
| `m3_sys_motion_standard_spring_fast_effects_stiffness` | int | 0x7f07034b | 3748 |
| `m3_sys_motion_standard_spring_fast_spatial_damping` | int | 0x7f07034c | 3749 |
| `m3_sys_motion_standard_spring_fast_spatial_stiffness` | int | 0x7f07034d | 3750 |
| `m3_sys_motion_standard_spring_slow_effects_damping` | int | 0x7f07034e | 3751 |
| `m3_sys_motion_standard_spring_slow_effects_stiffness` | int | 0x7f07034f | 3752 |
| `m3_sys_motion_standard_spring_slow_spatial_damping` | int | 0x7f070350 | 3753 |
| `m3_sys_motion_standard_spring_slow_spatial_stiffness` | int | 0x7f070351 | 3754 |
| `m3_sys_shape_corner_value_extra_extra_large` | int | 0x7f070352 | 3755 |
| `m3_sys_shape_corner_value_extra_large` | int | 0x7f070353 | 3756 |
| `m3_sys_shape_corner_value_extra_large_increased` | int | 0x7f070354 | 3757 |
| `m3_sys_shape_corner_value_extra_small` | int | 0x7f070355 | 3758 |
| `m3_sys_shape_corner_value_large` | int | 0x7f070356 | 3759 |
| `m3_sys_shape_corner_value_large_increased` | int | 0x7f070357 | 3760 |
| `m3_sys_shape_corner_value_medium` | int | 0x7f070358 | 3761 |
| `m3_sys_shape_corner_value_none` | int | 0x7f070359 | 3762 |
| `m3_sys_shape_corner_value_small` | int | 0x7f07035a | 3763 |
| `m3_sys_state_dragged_state_layer_opacity` | int | 0x7f07035b | 3764 |
| `m3_sys_state_focus_state_layer_opacity` | int | 0x7f07035c | 3765 |
| `m3_sys_state_hover_state_layer_opacity` | int | 0x7f07035d | 3766 |
| `m3_sys_state_pressed_state_layer_opacity` | int | 0x7f07035e | 3767 |
| `m3_timepicker_display_stroke_width` | int | 0x7f07035f | 3768 |
| `m3_timepicker_window_elevation` | int | 0x7f070360 | 3769 |
| `m3_toolbar_text_size_title` | int | 0x7f070361 | 3770 |
| `material_bottom_sheet_max_width` | int | 0x7f070362 | 3771 |
| `material_clock_display_height` | int | 0x7f070363 | 3772 |
| `material_clock_display_padding` | int | 0x7f070364 | 3773 |
| `material_clock_display_width` | int | 0x7f070365 | 3774 |
| `material_clock_face_margin_bottom` | int | 0x7f070366 | 3775 |
| `material_clock_face_margin_top` | int | 0x7f070367 | 3776 |
| `material_clock_hand_center_dot_radius` | int | 0x7f070368 | 3777 |
| `material_clock_hand_padding` | int | 0x7f070369 | 3778 |
| `material_clock_hand_stroke_width` | int | 0x7f07036a | 3779 |
| `material_clock_number_text_size` | int | 0x7f07036b | 3780 |
| `material_clock_period_toggle_height` | int | 0x7f07036c | 3781 |
| `material_clock_period_toggle_horizontal_gap` | int | 0x7f07036d | 3782 |
| `material_clock_period_toggle_vertical_gap` | int | 0x7f07036e | 3783 |
| `material_clock_period_toggle_width` | int | 0x7f07036f | 3784 |
| `material_clock_size` | int | 0x7f070370 | 3785 |
| `material_cursor_inset` | int | 0x7f070371 | 3786 |
| `material_cursor_width` | int | 0x7f070372 | 3787 |
| `material_divider_thickness` | int | 0x7f070373 | 3788 |
| `material_emphasis_disabled` | int | 0x7f070374 | 3789 |
| `material_emphasis_disabled_background` | int | 0x7f070375 | 3790 |
| `material_emphasis_high_type` | int | 0x7f070376 | 3791 |
| `material_emphasis_medium` | int | 0x7f070377 | 3792 |
| `material_filled_edittext_font_1_3_padding_bottom` | int | 0x7f070378 | 3793 |
| `material_filled_edittext_font_1_3_padding_top` | int | 0x7f070379 | 3794 |
| `material_filled_edittext_font_2_0_padding_bottom` | int | 0x7f07037a | 3795 |
| `material_filled_edittext_font_2_0_padding_top` | int | 0x7f07037b | 3796 |
| `material_font_1_3_box_collapsed_padding_top` | int | 0x7f07037c | 3797 |
| `material_font_2_0_box_collapsed_padding_top` | int | 0x7f07037d | 3798 |
| `material_helper_text_default_padding_top` | int | 0x7f07037e | 3799 |
| `material_helper_text_font_1_3_padding_horizontal` | int | 0x7f07037f | 3800 |
| `material_helper_text_font_1_3_padding_top` | int | 0x7f070380 | 3801 |
| `material_input_text_to_prefix_suffix_padding` | int | 0x7f070381 | 3802 |
| `material_textinput_default_width` | int | 0x7f070382 | 3803 |
| `material_textinput_max_width` | int | 0x7f070383 | 3804 |
| `material_textinput_min_width` | int | 0x7f070384 | 3805 |
| `material_textinput_min_width_with_label` | int | 0x7f070385 | 3806 |
| `material_time_picker_minimum_screen_height` | int | 0x7f070386 | 3807 |
| `material_time_picker_minimum_screen_width` | int | 0x7f070387 | 3808 |
| `media_space_12` | int | 0x7f070388 | 3809 |
| `mtrl_alert_dialog_background_inset_bottom` | int | 0x7f070389 | 3810 |
| `mtrl_alert_dialog_background_inset_end` | int | 0x7f07038a | 3811 |
| `mtrl_alert_dialog_background_inset_start` | int | 0x7f07038b | 3812 |
| `mtrl_alert_dialog_background_inset_top` | int | 0x7f07038c | 3813 |
| `mtrl_alert_dialog_picker_background_inset` | int | 0x7f07038d | 3814 |
| `mtrl_badge_horizontal_edge_offset` | int | 0x7f07038e | 3815 |
| `mtrl_badge_long_text_horizontal_padding` | int | 0x7f07038f | 3816 |
| `mtrl_badge_size` | int | 0x7f070390 | 3817 |
| `mtrl_badge_text_horizontal_edge_offset` | int | 0x7f070391 | 3818 |
| `mtrl_badge_text_size` | int | 0x7f070392 | 3819 |
| `mtrl_badge_toolbar_action_menu_item_horizontal_offset` | int | 0x7f070393 | 3820 |
| `mtrl_badge_toolbar_action_menu_item_vertical_offset` | int | 0x7f070394 | 3821 |
| `mtrl_badge_with_text_size` | int | 0x7f070395 | 3822 |
| `mtrl_bottomappbar_fab_bottom_margin` | int | 0x7f070397 | 3824 |
| `mtrl_bottomappbar_fab_cradle_margin` | int | 0x7f070398 | 3825 |
| `mtrl_bottomappbar_fab_cradle_rounded_corner_radius` | int | 0x7f070399 | 3826 |
| `mtrl_bottomappbar_fab_cradle_vertical_offset` | int | 0x7f07039a | 3827 |
| `mtrl_bottomappbar_fabOffsetEndMode` | int | 0x7f070396 | 3823 |
| `mtrl_bottomappbar_height` | int | 0x7f07039b | 3828 |
| `mtrl_btn_corner_radius` | int | 0x7f07039c | 3829 |
| `mtrl_btn_dialog_btn_min_width` | int | 0x7f07039d | 3830 |
| `mtrl_btn_disabled_elevation` | int | 0x7f07039e | 3831 |
| `mtrl_btn_disabled_z` | int | 0x7f07039f | 3832 |
| `mtrl_btn_elevation` | int | 0x7f0703a0 | 3833 |
| `mtrl_btn_focused_z` | int | 0x7f0703a1 | 3834 |
| `mtrl_btn_hovered_z` | int | 0x7f0703a2 | 3835 |
| `mtrl_btn_icon_btn_padding_left` | int | 0x7f0703a3 | 3836 |
| `mtrl_btn_icon_padding` | int | 0x7f0703a4 | 3837 |
| `mtrl_btn_inset` | int | 0x7f0703a5 | 3838 |
| `mtrl_btn_letter_spacing` | int | 0x7f0703a6 | 3839 |
| `mtrl_btn_max_width` | int | 0x7f0703a7 | 3840 |
| `mtrl_btn_padding_bottom` | int | 0x7f0703a8 | 3841 |
| `mtrl_btn_padding_left` | int | 0x7f0703a9 | 3842 |
| `mtrl_btn_padding_right` | int | 0x7f0703aa | 3843 |
| `mtrl_btn_padding_top` | int | 0x7f0703ab | 3844 |
| `mtrl_btn_pressed_z` | int | 0x7f0703ac | 3845 |
| `mtrl_btn_snackbar_margin_horizontal` | int | 0x7f0703ad | 3846 |
| `mtrl_btn_stroke_size` | int | 0x7f0703ae | 3847 |
| `mtrl_btn_text_btn_icon_padding` | int | 0x7f0703af | 3848 |
| `mtrl_btn_text_btn_padding_left` | int | 0x7f0703b0 | 3849 |
| `mtrl_btn_text_btn_padding_right` | int | 0x7f0703b1 | 3850 |
| `mtrl_btn_text_size` | int | 0x7f0703b2 | 3851 |
| `mtrl_btn_z` | int | 0x7f0703b3 | 3852 |
| `mtrl_calendar_action_confirm_button_min_width` | int | 0x7f0703b4 | 3853 |
| `mtrl_calendar_action_height` | int | 0x7f0703b5 | 3854 |
| `mtrl_calendar_action_padding` | int | 0x7f0703b6 | 3855 |
| `mtrl_calendar_bottom_padding` | int | 0x7f0703b7 | 3856 |
| `mtrl_calendar_content_padding` | int | 0x7f0703b8 | 3857 |
| `mtrl_calendar_day_corner` | int | 0x7f0703b9 | 3858 |
| `mtrl_calendar_day_height` | int | 0x7f0703ba | 3859 |
| `mtrl_calendar_day_horizontal_padding` | int | 0x7f0703bb | 3860 |
| `mtrl_calendar_day_today_stroke` | int | 0x7f0703bc | 3861 |
| `mtrl_calendar_day_vertical_padding` | int | 0x7f0703bd | 3862 |
| `mtrl_calendar_day_width` | int | 0x7f0703be | 3863 |
| `mtrl_calendar_days_of_week_height` | int | 0x7f0703bf | 3864 |
| `mtrl_calendar_dialog_background_inset` | int | 0x7f0703c0 | 3865 |
| `mtrl_calendar_header_content_padding` | int | 0x7f0703c1 | 3866 |
| `mtrl_calendar_header_content_padding_fullscreen` | int | 0x7f0703c2 | 3867 |
| `mtrl_calendar_header_divider_thickness` | int | 0x7f0703c3 | 3868 |
| `mtrl_calendar_header_height` | int | 0x7f0703c4 | 3869 |
| `mtrl_calendar_header_height_fullscreen` | int | 0x7f0703c5 | 3870 |
| `mtrl_calendar_header_selection_line_height` | int | 0x7f0703c6 | 3871 |
| `mtrl_calendar_header_text_padding` | int | 0x7f0703c7 | 3872 |
| `mtrl_calendar_header_toggle_margin_bottom` | int | 0x7f0703c8 | 3873 |
| `mtrl_calendar_header_toggle_margin_top` | int | 0x7f0703c9 | 3874 |
| `mtrl_calendar_landscape_header_width` | int | 0x7f0703ca | 3875 |
| `mtrl_calendar_maximum_default_fullscreen_minor_axis` | int | 0x7f0703cb | 3876 |
| `mtrl_calendar_month_horizontal_padding` | int | 0x7f0703cc | 3877 |
| `mtrl_calendar_month_vertical_padding` | int | 0x7f0703cd | 3878 |
| `mtrl_calendar_navigation_bottom_padding` | int | 0x7f0703ce | 3879 |
| `mtrl_calendar_navigation_height` | int | 0x7f0703cf | 3880 |
| `mtrl_calendar_navigation_top_padding` | int | 0x7f0703d0 | 3881 |
| `mtrl_calendar_selection_baseline_to_top_fullscreen` | int | 0x7f0703d1 | 3882 |
| `mtrl_calendar_selection_text_baseline_to_bottom` | int | 0x7f0703d2 | 3883 |
| `mtrl_calendar_selection_text_baseline_to_bottom_fullscreen` | int | 0x7f0703d3 | 3884 |
| `mtrl_calendar_selection_text_baseline_to_top` | int | 0x7f0703d4 | 3885 |
| `mtrl_calendar_text_input_padding_top` | int | 0x7f0703d5 | 3886 |
| `mtrl_calendar_title_baseline_to_top` | int | 0x7f0703d6 | 3887 |
| `mtrl_calendar_title_baseline_to_top_fullscreen` | int | 0x7f0703d7 | 3888 |
| `mtrl_calendar_year_corner` | int | 0x7f0703d8 | 3889 |
| `mtrl_calendar_year_height` | int | 0x7f0703d9 | 3890 |
| `mtrl_calendar_year_horizontal_padding` | int | 0x7f0703da | 3891 |
| `mtrl_calendar_year_vertical_padding` | int | 0x7f0703db | 3892 |
| `mtrl_calendar_year_width` | int | 0x7f0703dc | 3893 |
| `mtrl_card_checked_icon_margin` | int | 0x7f0703dd | 3894 |
| `mtrl_card_checked_icon_size` | int | 0x7f0703de | 3895 |
| `mtrl_card_corner_radius` | int | 0x7f0703df | 3896 |
| `mtrl_card_dragged_z` | int | 0x7f0703e0 | 3897 |
| `mtrl_card_elevation` | int | 0x7f0703e1 | 3898 |
| `mtrl_card_spacing` | int | 0x7f0703e2 | 3899 |
| `mtrl_chip_pressed_translation_z` | int | 0x7f0703e3 | 3900 |
| `mtrl_chip_text_size` | int | 0x7f0703e4 | 3901 |
| `mtrl_exposed_dropdown_menu_popup_elevation` | int | 0x7f0703e5 | 3902 |
| `mtrl_exposed_dropdown_menu_popup_vertical_offset` | int | 0x7f0703e6 | 3903 |
| `mtrl_exposed_dropdown_menu_popup_vertical_padding` | int | 0x7f0703e7 | 3904 |
| `mtrl_extended_fab_bottom_padding` | int | 0x7f0703e8 | 3905 |
| `mtrl_extended_fab_disabled_elevation` | int | 0x7f0703e9 | 3906 |
| `mtrl_extended_fab_disabled_translation_z` | int | 0x7f0703ea | 3907 |
| `mtrl_extended_fab_elevation` | int | 0x7f0703eb | 3908 |
| `mtrl_extended_fab_end_padding` | int | 0x7f0703ec | 3909 |
| `mtrl_extended_fab_end_padding_icon` | int | 0x7f0703ed | 3910 |
| `mtrl_extended_fab_icon_size` | int | 0x7f0703ee | 3911 |
| `mtrl_extended_fab_icon_text_spacing` | int | 0x7f0703ef | 3912 |
| `mtrl_extended_fab_min_height` | int | 0x7f0703f0 | 3913 |
| `mtrl_extended_fab_min_width` | int | 0x7f0703f1 | 3914 |
| `mtrl_extended_fab_start_padding` | int | 0x7f0703f2 | 3915 |
| `mtrl_extended_fab_start_padding_icon` | int | 0x7f0703f3 | 3916 |
| `mtrl_extended_fab_top_padding` | int | 0x7f0703f4 | 3917 |
| `mtrl_extended_fab_translation_z_base` | int | 0x7f0703f5 | 3918 |
| `mtrl_extended_fab_translation_z_hovered_focused` | int | 0x7f0703f6 | 3919 |
| `mtrl_extended_fab_translation_z_pressed` | int | 0x7f0703f7 | 3920 |
| `mtrl_fab_elevation` | int | 0x7f0703f8 | 3921 |
| `mtrl_fab_min_touch_target` | int | 0x7f0703f9 | 3922 |
| `mtrl_fab_translation_z_hovered_focused` | int | 0x7f0703fa | 3923 |
| `mtrl_fab_translation_z_pressed` | int | 0x7f0703fb | 3924 |
| `mtrl_high_ripple_default_alpha` | int | 0x7f0703fc | 3925 |
| `mtrl_high_ripple_focused_alpha` | int | 0x7f0703fd | 3926 |
| `mtrl_high_ripple_hovered_alpha` | int | 0x7f0703fe | 3927 |
| `mtrl_high_ripple_pressed_alpha` | int | 0x7f0703ff | 3928 |
| `mtrl_low_ripple_default_alpha` | int | 0x7f070400 | 3929 |
| `mtrl_low_ripple_focused_alpha` | int | 0x7f070401 | 3930 |
| `mtrl_low_ripple_hovered_alpha` | int | 0x7f070402 | 3931 |
| `mtrl_low_ripple_pressed_alpha` | int | 0x7f070403 | 3932 |
| `mtrl_min_touch_target_size` | int | 0x7f070404 | 3933 |
| `mtrl_navigation_bar_item_default_icon_size` | int | 0x7f070405 | 3934 |
| `mtrl_navigation_bar_item_default_margin` | int | 0x7f070406 | 3935 |
| `mtrl_navigation_elevation` | int | 0x7f070407 | 3936 |
| `mtrl_navigation_item_horizontal_padding` | int | 0x7f070408 | 3937 |
| `mtrl_navigation_item_icon_padding` | int | 0x7f070409 | 3938 |
| `mtrl_navigation_item_icon_size` | int | 0x7f07040a | 3939 |
| `mtrl_navigation_item_shape_horizontal_margin` | int | 0x7f07040b | 3940 |
| `mtrl_navigation_item_shape_vertical_margin` | int | 0x7f07040c | 3941 |
| `mtrl_navigation_rail_active_text_size` | int | 0x7f07040d | 3942 |
| `mtrl_navigation_rail_compact_width` | int | 0x7f07040e | 3943 |
| `mtrl_navigation_rail_default_width` | int | 0x7f07040f | 3944 |
| `mtrl_navigation_rail_elevation` | int | 0x7f070410 | 3945 |
| `mtrl_navigation_rail_icon_margin` | int | 0x7f070411 | 3946 |
| `mtrl_navigation_rail_icon_size` | int | 0x7f070412 | 3947 |
| `mtrl_navigation_rail_margin` | int | 0x7f070413 | 3948 |
| `mtrl_navigation_rail_text_bottom_margin` | int | 0x7f070414 | 3949 |
| `mtrl_navigation_rail_text_size` | int | 0x7f070415 | 3950 |
| `mtrl_progress_circular_inset` | int | 0x7f070416 | 3951 |
| `mtrl_progress_circular_inset_extra_small` | int | 0x7f070417 | 3952 |
| `mtrl_progress_circular_inset_medium` | int | 0x7f070418 | 3953 |
| `mtrl_progress_circular_inset_small` | int | 0x7f070419 | 3954 |
| `mtrl_progress_circular_radius` | int | 0x7f07041a | 3955 |
| `mtrl_progress_circular_size` | int | 0x7f07041b | 3956 |
| `mtrl_progress_circular_size_extra_small` | int | 0x7f07041c | 3957 |
| `mtrl_progress_circular_size_medium` | int | 0x7f07041d | 3958 |
| `mtrl_progress_circular_size_small` | int | 0x7f07041e | 3959 |
| `mtrl_progress_circular_track_thickness_extra_small` | int | 0x7f07041f | 3960 |
| `mtrl_progress_circular_track_thickness_medium` | int | 0x7f070420 | 3961 |
| `mtrl_progress_circular_track_thickness_small` | int | 0x7f070421 | 3962 |
| `mtrl_progress_indicator_full_rounded_corner_radius` | int | 0x7f070422 | 3963 |
| `mtrl_progress_track_thickness` | int | 0x7f070423 | 3964 |
| `mtrl_shape_corner_size_large_component` | int | 0x7f070424 | 3965 |
| `mtrl_shape_corner_size_medium_component` | int | 0x7f070425 | 3966 |
| `mtrl_shape_corner_size_small_component` | int | 0x7f070426 | 3967 |
| `mtrl_slider_halo_radius` | int | 0x7f070427 | 3968 |
| `mtrl_slider_label_padding` | int | 0x7f070428 | 3969 |
| `mtrl_slider_label_radius` | int | 0x7f070429 | 3970 |
| `mtrl_slider_label_square_side` | int | 0x7f07042a | 3971 |
| `mtrl_slider_thumb_elevation` | int | 0x7f07042b | 3972 |
| `mtrl_slider_thumb_radius` | int | 0x7f07042c | 3973 |
| `mtrl_slider_tick_min_spacing` | int | 0x7f07042d | 3974 |
| `mtrl_slider_tick_radius` | int | 0x7f07042e | 3975 |
| `mtrl_slider_track_height` | int | 0x7f07042f | 3976 |
| `mtrl_slider_track_side_padding` | int | 0x7f070430 | 3977 |
| `mtrl_slider_widget_height` | int | 0x7f070431 | 3978 |
| `mtrl_snackbar_action_text_color_alpha` | int | 0x7f070432 | 3979 |
| `mtrl_snackbar_background_corner_radius` | int | 0x7f070433 | 3980 |
| `mtrl_snackbar_background_overlay_color_alpha` | int | 0x7f070434 | 3981 |
| `mtrl_snackbar_margin` | int | 0x7f070435 | 3982 |
| `mtrl_snackbar_message_margin_horizontal` | int | 0x7f070436 | 3983 |
| `mtrl_snackbar_padding_horizontal` | int | 0x7f070437 | 3984 |
| `mtrl_switch_text_padding` | int | 0x7f070438 | 3985 |
| `mtrl_switch_thumb_elevation` | int | 0x7f070439 | 3986 |
| `mtrl_switch_thumb_icon_size` | int | 0x7f07043a | 3987 |
| `mtrl_switch_thumb_size` | int | 0x7f07043b | 3988 |
| `mtrl_switch_track_height` | int | 0x7f07043c | 3989 |
| `mtrl_switch_track_width` | int | 0x7f07043d | 3990 |
| `mtrl_textinput_box_corner_radius_medium` | int | 0x7f07043e | 3991 |
| `mtrl_textinput_box_corner_radius_small` | int | 0x7f07043f | 3992 |
| `mtrl_textinput_box_label_cutout_padding` | int | 0x7f070440 | 3993 |
| `mtrl_textinput_box_stroke_width_default` | int | 0x7f070441 | 3994 |
| `mtrl_textinput_box_stroke_width_focused` | int | 0x7f070442 | 3995 |
| `mtrl_textinput_counter_margin_start` | int | 0x7f070443 | 3996 |
| `mtrl_textinput_end_icon_margin_start` | int | 0x7f070444 | 3997 |
| `mtrl_textinput_outline_box_expanded_padding` | int | 0x7f070445 | 3998 |
| `mtrl_textinput_start_icon_margin_end` | int | 0x7f070446 | 3999 |
| `mtrl_toolbar_default_height` | int | 0x7f070447 | 4000 |
| `mtrl_tooltip_arrowSize` | int | 0x7f070448 | 4001 |
| `mtrl_tooltip_cornerSize` | int | 0x7f070449 | 4002 |
| `mtrl_tooltip_minHeight` | int | 0x7f07044a | 4003 |
| `mtrl_tooltip_minWidth` | int | 0x7f07044b | 4004 |
| `mtrl_tooltip_padding` | int | 0x7f07044c | 4005 |
| `mtrl_transition_shared_axis_slide_distance` | int | 0x7f07044d | 4006 |
| `nav_header_height` | int | 0x7f07044e | 4007 |
| `nav_header_vertical_spacing` | int | 0x7f07044f | 4008 |
| `navigation_size` | int | 0x7f070450 | 4009 |
| `notification_action_icon_size` | int | 0x7f070451 | 4010 |
| `notification_action_text_size` | int | 0x7f070452 | 4011 |
| `notification_big_circle_margin` | int | 0x7f070453 | 4012 |
| `notification_content_margin_start` | int | 0x7f070454 | 4013 |
| `notification_large_icon_height` | int | 0x7f070455 | 4014 |
| `notification_large_icon_width` | int | 0x7f070456 | 4015 |
| `notification_main_column_padding_top` | int | 0x7f070457 | 4016 |
| `notification_media_narrow_margin` | int | 0x7f070458 | 4017 |
| `notification_right_icon_size` | int | 0x7f070459 | 4018 |
| `notification_right_side_padding_top` | int | 0x7f07045a | 4019 |
| `notification_small_icon_background_padding` | int | 0x7f07045b | 4020 |
| `notification_small_icon_size_as_large` | int | 0x7f07045c | 4021 |
| `notification_subtext_size` | int | 0x7f07045d | 4022 |
| `notification_top_pad` | int | 0x7f07045e | 4023 |
| `notification_top_pad_large_text` | int | 0x7f07045f | 4024 |
| `pickerview_textsize` | int | 0x7f070460 | 4025 |
| `pickerview_topbar_btn_textsize` | int | 0x7f070461 | 4026 |
| `pickerview_topbar_height` | int | 0x7f070462 | 4027 |
| `pickerview_topbar_padding` | int | 0x7f070463 | 4028 |
| `pickerview_topbar_title_textsize` | int | 0x7f070464 | 4029 |
| `second_title_size` | int | 0x7f070465 | 4030 |
| `seek_bar_image` | int | 0x7f070466 | 4031 |
| `shadow_width` | int | 0x7f070467 | 4032 |
| `space_1` | int | 0x7f070468 | 4033 |
| `space_10` | int | 0x7f070469 | 4034 |
| `space_11` | int | 0x7f07046a | 4035 |
| `space_12` | int | 0x7f07046b | 4036 |
| `space_13` | int | 0x7f07046c | 4037 |
| `space_14` | int | 0x7f07046d | 4038 |
| `space_15` | int | 0x7f07046e | 4039 |
| `space_16` | int | 0x7f07046f | 4040 |
| `space_17` | int | 0x7f070470 | 4041 |
| `space_18` | int | 0x7f070471 | 4042 |
| `space_19` | int | 0x7f070472 | 4043 |
| `space_2` | int | 0x7f070473 | 4044 |
| `space_20` | int | 0x7f070474 | 4045 |
| `space_21` | int | 0x7f070475 | 4046 |
| `space_22` | int | 0x7f070476 | 4047 |
| `space_23` | int | 0x7f070477 | 4048 |
| `space_24` | int | 0x7f070478 | 4049 |
| `space_25` | int | 0x7f070479 | 4050 |
| `space_26` | int | 0x7f07047a | 4051 |
| `space_27` | int | 0x7f07047b | 4052 |
| `space_28` | int | 0x7f07047c | 4053 |
| `space_29` | int | 0x7f07047d | 4054 |
| `space_3` | int | 0x7f07047e | 4055 |
| `space_30` | int | 0x7f07047f | 4056 |
| `space_4` | int | 0x7f070480 | 4057 |
| `space_5` | int | 0x7f070481 | 4058 |
| `space_6` | int | 0x7f070482 | 4059 |
| `space_7` | int | 0x7f070483 | 4060 |
| `space_8` | int | 0x7f070484 | 4061 |
| `space_9` | int | 0x7f070485 | 4062 |
| `text_size_10` | int | 0x7f070486 | 4063 |
| `text_size_11` | int | 0x7f070487 | 4064 |
| `text_size_12` | int | 0x7f070488 | 4065 |
| `text_size_13` | int | 0x7f070489 | 4066 |
| `text_size_14` | int | 0x7f07048a | 4067 |
| `text_size_15` | int | 0x7f07048b | 4068 |
| `text_size_16` | int | 0x7f07048c | 4069 |
| `text_size_17` | int | 0x7f07048d | 4070 |
| `text_size_18` | int | 0x7f07048e | 4071 |
| `text_size_19` | int | 0x7f07048f | 4072 |
| `text_size_20` | int | 0x7f070490 | 4073 |
| `text_size_21` | int | 0x7f070491 | 4074 |
| `text_size_22` | int | 0x7f070492 | 4075 |
| `text_size_23` | int | 0x7f070493 | 4076 |
| `text_size_24` | int | 0x7f070494 | 4077 |
| `text_size_25` | int | 0x7f070495 | 4078 |
| `text_size_26` | int | 0x7f070496 | 4079 |
| `text_size_27` | int | 0x7f070497 | 4080 |
| `text_size_28` | int | 0x7f070498 | 4081 |
| `text_size_29` | int | 0x7f070499 | 4082 |
| `text_size_30` | int | 0x7f07049a | 4083 |
| `text_size_31` | int | 0x7f07049b | 4084 |
| `text_size_32` | int | 0x7f07049c | 4085 |
| `text_size_7` | int | 0x7f07049d | 4086 |
| `text_size_8` | int | 0x7f07049e | 4087 |
| `text_size_9` | int | 0x7f07049f | 4088 |
| `title_height` | int | 0x7f0704a0 | 4089 |
| `tooltip_corner_radius` | int | 0x7f0704a1 | 4090 |
| `tooltip_horizontal_padding` | int | 0x7f0704a2 | 4091 |
| `tooltip_margin` | int | 0x7f0704a3 | 4092 |
| `tooltip_precise_anchor_extra_offset` | int | 0x7f0704a4 | 4093 |
| `tooltip_precise_anchor_threshold` | int | 0x7f0704a5 | 4094 |
| `tooltip_vertical_padding` | int | 0x7f0704a6 | 4095 |
| `tooltip_y_offset_non_touch` | int | 0x7f0704a7 | 4096 |
| `tooltip_y_offset_touch` | int | 0x7f0704a8 | 4097 |
| `video_progress_dialog_margin_top` | int | 0x7f0704a9 | 4098 |
| `video_volume_dialog_margin_left` | int | 0x7f0704aa | 4099 |

### `com.id221.golive.R$drawable`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `_avd_hide_password__0_res_0x7f080000` | int | 0x7f080000 | 4103 |
| `_avd_hide_password__1_res_0x7f080001` | int | 0x7f080001 | 4104 |
| `_avd_hide_password__2_res_0x7f080002` | int | 0x7f080002 | 4105 |
| `_avd_show_password__0_res_0x7f080003` | int | 0x7f080003 | 4106 |
| `_avd_show_password__1_res_0x7f080004` | int | 0x7f080004 | 4107 |
| `_avd_show_password__2_res_0x7f080005` | int | 0x7f080005 | 4108 |
| `_m3_avd_hide_password__0_res_0x7f080006` | int | 0x7f080006 | 4109 |
| `_m3_avd_hide_password__1_res_0x7f080007` | int | 0x7f080007 | 4110 |
| `_m3_avd_hide_password__2_res_0x7f080008` | int | 0x7f080008 | 4111 |
| `_m3_avd_show_password__0_res_0x7f080009` | int | 0x7f080009 | 4112 |
| `_m3_avd_show_password__1_res_0x7f08000a` | int | 0x7f08000a | 4113 |
| `_m3_avd_show_password__2_res_0x7f08000b` | int | 0x7f08000b | 4114 |
| `_mtrl_checkbox_button_checked_unchecked__0_res_0x7f08000c` | int | 0x7f08000c | 4115 |
| `_mtrl_checkbox_button_checked_unchecked__1_res_0x7f08000d` | int | 0x7f08000d | 4116 |
| `_mtrl_checkbox_button_checked_unchecked__2_res_0x7f08000e` | int | 0x7f08000e | 4117 |
| `_mtrl_checkbox_button_icon_checked_indeterminate__0_res_0x7f08000f` | int | 0x7f08000f | 4118 |
| `_mtrl_checkbox_button_icon_checked_unchecked__0_res_0x7f080010` | int | 0x7f080010 | 4119 |
| `_mtrl_checkbox_button_icon_checked_unchecked__1_res_0x7f080011` | int | 0x7f080011 | 4120 |
| `_mtrl_checkbox_button_icon_checked_unchecked__2_res_0x7f080012` | int | 0x7f080012 | 4121 |
| `_mtrl_checkbox_button_icon_indeterminate_checked__0_res_0x7f080013` | int | 0x7f080013 | 4122 |
| `_mtrl_checkbox_button_icon_indeterminate_unchecked__0_res_0x7f080014` | int | 0x7f080014 | 4123 |
| `_mtrl_checkbox_button_icon_indeterminate_unchecked__1_res_0x7f080015` | int | 0x7f080015 | 4124 |
| `_mtrl_checkbox_button_icon_indeterminate_unchecked__2_res_0x7f080016` | int | 0x7f080016 | 4125 |
| `_mtrl_checkbox_button_icon_unchecked_checked__0_res_0x7f080017` | int | 0x7f080017 | 4126 |
| `_mtrl_checkbox_button_icon_unchecked_checked__1_res_0x7f080018` | int | 0x7f080018 | 4127 |
| `_mtrl_checkbox_button_icon_unchecked_checked__2_res_0x7f080019` | int | 0x7f080019 | 4128 |
| `_mtrl_checkbox_button_icon_unchecked_indeterminate__0_res_0x7f08001a` | int | 0x7f08001a | 4129 |
| `_mtrl_checkbox_button_icon_unchecked_indeterminate__1_res_0x7f08001b` | int | 0x7f08001b | 4130 |
| `_mtrl_checkbox_button_icon_unchecked_indeterminate__2_res_0x7f08001c` | int | 0x7f08001c | 4131 |
| `_mtrl_checkbox_button_unchecked_checked__0_res_0x7f08001d` | int | 0x7f08001d | 4132 |
| `_mtrl_checkbox_button_unchecked_checked__1_res_0x7f08001e` | int | 0x7f08001e | 4133 |
| `_mtrl_checkbox_button_unchecked_checked__2_res_0x7f08001f` | int | 0x7f08001f | 4134 |
| `_mtrl_switch_thumb_checked_pressed__0_res_0x7f080020` | int | 0x7f080020 | 4135 |
| `_mtrl_switch_thumb_checked_unchecked__0_res_0x7f080021` | int | 0x7f080021 | 4136 |
| `_mtrl_switch_thumb_checked_unchecked__1_res_0x7f080022` | int | 0x7f080022 | 4137 |
| `_mtrl_switch_thumb_pressed_checked__0_res_0x7f080023` | int | 0x7f080023 | 4138 |
| `_mtrl_switch_thumb_pressed_unchecked__0_res_0x7f080024` | int | 0x7f080024 | 4139 |
| `_mtrl_switch_thumb_unchecked_checked__0_res_0x7f080025` | int | 0x7f080025 | 4140 |
| `_mtrl_switch_thumb_unchecked_checked__1_res_0x7f080026` | int | 0x7f080026 | 4141 |
| `_mtrl_switch_thumb_unchecked_pressed__0_res_0x7f080027` | int | 0x7f080027 | 4142 |
| `abc_ab_share_pack_mtrl_alpha` | int | 0x7f080028 | 4143 |
| `abc_action_bar_item_background_material` | int | 0x7f080029 | 4144 |
| `abc_btn_borderless_material` | int | 0x7f08002a | 4145 |
| `abc_btn_check_material` | int | 0x7f08002b | 4146 |
| `abc_btn_check_material_anim` | int | 0x7f08002c | 4147 |
| `abc_btn_check_to_on_mtrl_000` | int | 0x7f08002d | 4148 |
| `abc_btn_check_to_on_mtrl_015` | int | 0x7f08002e | 4149 |
| `abc_btn_colored_material` | int | 0x7f08002f | 4150 |
| `abc_btn_default_mtrl_shape` | int | 0x7f080030 | 4151 |
| `abc_btn_radio_material` | int | 0x7f080031 | 4152 |
| `abc_btn_radio_material_anim` | int | 0x7f080032 | 4153 |
| `abc_btn_radio_to_on_mtrl_000` | int | 0x7f080033 | 4154 |
| `abc_btn_radio_to_on_mtrl_015` | int | 0x7f080034 | 4155 |
| `abc_btn_switch_to_on_mtrl_00001` | int | 0x7f080035 | 4156 |
| `abc_btn_switch_to_on_mtrl_00012` | int | 0x7f080036 | 4157 |
| `abc_cab_background_internal_bg` | int | 0x7f080037 | 4158 |
| `abc_cab_background_top_material` | int | 0x7f080038 | 4159 |
| `abc_cab_background_top_mtrl_alpha` | int | 0x7f080039 | 4160 |
| `abc_control_background_material` | int | 0x7f08003a | 4161 |
| `abc_dialog_material_background` | int | 0x7f08003b | 4162 |
| `abc_edit_text_material` | int | 0x7f08003c | 4163 |
| `abc_ic_ab_back_material` | int | 0x7f08003d | 4164 |
| `abc_ic_arrow_drop_right_black_24dp` | int | 0x7f08003e | 4165 |
| `abc_ic_clear_material` | int | 0x7f08003f | 4166 |
| `abc_ic_commit_search_api_mtrl_alpha` | int | 0x7f080040 | 4167 |
| `abc_ic_go_search_api_material` | int | 0x7f080041 | 4168 |
| `abc_ic_menu_copy_mtrl_am_alpha` | int | 0x7f080042 | 4169 |
| `abc_ic_menu_cut_mtrl_alpha` | int | 0x7f080043 | 4170 |
| `abc_ic_menu_overflow_material` | int | 0x7f080044 | 4171 |
| `abc_ic_menu_paste_mtrl_am_alpha` | int | 0x7f080045 | 4172 |
| `abc_ic_menu_selectall_mtrl_alpha` | int | 0x7f080046 | 4173 |
| `abc_ic_menu_share_mtrl_alpha` | int | 0x7f080047 | 4174 |
| `abc_ic_search_api_material` | int | 0x7f080048 | 4175 |
| `abc_ic_voice_search_api_material` | int | 0x7f080049 | 4176 |
| `abc_item_background_holo_dark` | int | 0x7f08004a | 4177 |
| `abc_item_background_holo_light` | int | 0x7f08004b | 4178 |
| `abc_list_divider_material` | int | 0x7f08004c | 4179 |
| `abc_list_divider_mtrl_alpha` | int | 0x7f08004d | 4180 |
| `abc_list_focused_holo` | int | 0x7f08004e | 4181 |
| `abc_list_longpressed_holo` | int | 0x7f08004f | 4182 |
| `abc_list_pressed_holo_dark` | int | 0x7f080050 | 4183 |
| `abc_list_pressed_holo_light` | int | 0x7f080051 | 4184 |
| `abc_list_selector_background_transition_holo_dark` | int | 0x7f080052 | 4185 |
| `abc_list_selector_background_transition_holo_light` | int | 0x7f080053 | 4186 |
| `abc_list_selector_disabled_holo_dark` | int | 0x7f080054 | 4187 |
| `abc_list_selector_disabled_holo_light` | int | 0x7f080055 | 4188 |
| `abc_list_selector_holo_dark` | int | 0x7f080056 | 4189 |
| `abc_list_selector_holo_light` | int | 0x7f080057 | 4190 |
| `abc_menu_hardkey_panel_mtrl_mult` | int | 0x7f080058 | 4191 |
| `abc_popup_background_mtrl_mult` | int | 0x7f080059 | 4192 |
| `abc_ratingbar_indicator_material` | int | 0x7f08005a | 4193 |
| `abc_ratingbar_material` | int | 0x7f08005b | 4194 |
| `abc_ratingbar_small_material` | int | 0x7f08005c | 4195 |
| `abc_scrubber_control_off_mtrl_alpha` | int | 0x7f08005d | 4196 |
| `abc_scrubber_control_to_pressed_mtrl_000` | int | 0x7f08005e | 4197 |
| `abc_scrubber_control_to_pressed_mtrl_005` | int | 0x7f08005f | 4198 |
| `abc_scrubber_primary_mtrl_alpha` | int | 0x7f080060 | 4199 |
| `abc_scrubber_track_mtrl_alpha` | int | 0x7f080061 | 4200 |
| `abc_seekbar_thumb_material` | int | 0x7f080062 | 4201 |
| `abc_seekbar_tick_mark_material` | int | 0x7f080063 | 4202 |
| `abc_seekbar_track_material` | int | 0x7f080064 | 4203 |
| `abc_spinner_mtrl_am_alpha` | int | 0x7f080065 | 4204 |
| `abc_spinner_textfield_background_material` | int | 0x7f080066 | 4205 |
| `abc_star_black_48dp` | int | 0x7f080067 | 4206 |
| `abc_star_half_black_48dp` | int | 0x7f080068 | 4207 |
| `abc_switch_thumb_material` | int | 0x7f080069 | 4208 |
| `abc_switch_track_mtrl_alpha` | int | 0x7f08006a | 4209 |
| `abc_tab_indicator_material` | int | 0x7f08006b | 4210 |
| `abc_tab_indicator_mtrl_alpha` | int | 0x7f08006c | 4211 |
| `abc_text_cursor_material` | int | 0x7f08006d | 4212 |
| `abc_text_select_handle_left_mtrl` | int | 0x7f08006e | 4213 |
| `abc_text_select_handle_middle_mtrl` | int | 0x7f08006f | 4214 |
| `abc_text_select_handle_right_mtrl` | int | 0x7f080070 | 4215 |
| `abc_textfield_activated_mtrl_alpha` | int | 0x7f080071 | 4216 |
| `abc_textfield_default_mtrl_alpha` | int | 0x7f080072 | 4217 |
| `abc_textfield_search_activated_mtrl_alpha` | int | 0x7f080073 | 4218 |
| `abc_textfield_search_default_mtrl_alpha` | int | 0x7f080074 | 4219 |
| `abc_textfield_search_material` | int | 0x7f080075 | 4220 |
| `abc_vector_test` | int | 0x7f080076 | 4221 |
| `action_about` | int | 0x7f080077 | 4222 |
| `actionbar_add_icon` | int | 0x7f080078 | 4223 |
| `actionbar_border` | int | 0x7f080079 | 4224 |
| `actionbar_border1` | int | 0x7f08007a | 4225 |
| `actionbar_more_icon` | int | 0x7f08007b | 4226 |
| `add` | int | 0x7f08007c | 4227 |
| `add_slot` | int | 0x7f08007d | 4228 |
| `addcamicon` | int | 0x7f08007e | 4229 |
| `after_play` | int | 0x7f08007f | 4230 |
| `album_abc_spinner_white` | int | 0x7f080080 | 4231 |
| `album_ic_add_photo_white` | int | 0x7f080081 | 4232 |
| `album_ic_back_white` | int | 0x7f080082 | 4233 |
| `album_ic_done_white` | int | 0x7f080083 | 4234 |
| `album_ic_eye_white` | int | 0x7f080084 | 4235 |
| `album_ic_image_camera_white` | int | 0x7f080085 | 4236 |
| `album_ic_video_camera_white` | int | 0x7f080086 | 4237 |
| `album_tag_video_white` | int | 0x7f080087 | 4238 |
| `app_icon` | int | 0x7f080088 | 4239 |
| `apple_dialog_bg` | int | 0x7f080089 | 4240 |
| `asteroid` | int | 0x7f08008a | 4241 |
| `avd_hide_password` | int | 0x7f08008b | 4242 |
| `avd_show_password` | int | 0x7f08008c | 4243 |
| `awb_auto` | int | 0x7f08008d | 4244 |
| `awb_cloudy` | int | 0x7f08008e | 4245 |
| `awb_daylight` | int | 0x7f08008f | 4246 |
| `awb_fluoresecent` | int | 0x7f080090 | 4247 |
| `awb_incadescent` | int | 0x7f080091 | 4248 |
| `backscreen` | int | 0x7f080092 | 4249 |
| `battery_0` | int | 0x7f080093 | 4250 |
| `battery_1` | int | 0x7f080094 | 4251 |
| `battery_2` | int | 0x7f080095 | 4252 |
| `battery_3` | int | 0x7f080096 | 4253 |
| `battery_4` | int | 0x7f080097 | 4254 |
| `before_play` | int | 0x7f080098 | 4255 |
| `bg_cursor` | int | 0x7f080099 | 4256 |
| `bg_dottedline` | int | 0x7f08009a | 4257 |
| `bg_view` | int | 0x7f08009b | 4258 |
| `bg_view_select` | int | 0x7f08009c | 4259 |
| `bg_view_select2` | int | 0x7f08009d | 4260 |
| `bg_white_box` | int | 0x7f08009e | 4261 |
| `btn_checkbox_checked_mtrl` | int | 0x7f08009f | 4262 |
| `btn_checkbox_checked_to_unchecked_mtrl_animation` | int | 0x7f0800a0 | 4263 |
| `btn_checkbox_unchecked_mtrl` | int | 0x7f0800a1 | 4264 |
| `btn_checkbox_unchecked_to_checked_mtrl_animation` | int | 0x7f0800a2 | 4265 |
| `btn_next` | int | 0x7f0800a3 | 4266 |
| `btn_next_2` | int | 0x7f0800a4 | 4267 |
| `btn_previous` | int | 0x7f0800a5 | 4268 |
| `btn_previous_2` | int | 0x7f0800a6 | 4269 |
| `btn_radio_off_mtrl` | int | 0x7f0800a7 | 4270 |
| `btn_radio_off_to_on_mtrl_animation` | int | 0x7f0800a8 | 4271 |
| `btn_radio_on_mtrl` | int | 0x7f0800a9 | 4272 |
| `btn_radio_on_to_off_mtrl_animation` | int | 0x7f0800aa | 4273 |
| `btn_selftimer` | int | 0x7f0800ab | 4274 |
| `btn_selftimer_10n` | int | 0x7f0800ac | 4275 |
| `btn_selftimer_n` | int | 0x7f0800ad | 4276 |
| `btn_selftimer_n_focus` | int | 0x7f0800ae | 4277 |
| `button` | int | 0x7f0800af | 4278 |
| `camera` | int | 0x7f0800b0 | 4279 |
| `camera_capture_focus` | int | 0x7f0800b1 | 4280 |
| `camera_disconnect` | int | 0x7f0800b2 | 4281 |
| `camera_off` | int | 0x7f0800b3 | 4282 |
| `camera_on` | int | 0x7f0800b4 | 4283 |
| `camera_sel` | int | 0x7f0800b5 | 4284 |
| `camera_start` | int | 0x7f0800b6 | 4285 |
| `camera_start_disabled` | int | 0x7f0800b7 | 4286 |
| `camera_toggle_focus` | int | 0x7f0800b8 | 4287 |
| `camera_wifi_connected` | int | 0x7f0800b9 | 4288 |
| `camera_wifi_disconnected` | int | 0x7f0800ba | 4289 |
| `cancel` | int | 0x7f0800bb | 4290 |
| `cancel_all` | int | 0x7f0800bc | 4291 |
| `cancel_task` | int | 0x7f0800bd | 4292 |
| `capture_delay_btn` | int | 0x7f0800be | 4293 |
| `capture_toggle_btn_off` | int | 0x7f0800bf | 4294 |
| `capture_toggle_btn_on` | int | 0x7f0800c0 | 4295 |
| `checkbox_off` | int | 0x7f0800c1 | 4296 |
| `checkbox_on` | int | 0x7f0800c2 | 4297 |
| `checkbox_style` | int | 0x7f0800c3 | 4298 |
| `circle` | int | 0x7f0800c4 | 4299 |
| `color_progress` | int | 0x7f0800c5 | 4300 |
| `com_facebook_auth_dialog_background` | int | 0x7f0800c6 | 4301 |
| `com_facebook_auth_dialog_cancel_background` | int | 0x7f0800c7 | 4302 |
| `com_facebook_auth_dialog_header_background` | int | 0x7f0800c8 | 4303 |
| `com_facebook_button_background` | int | 0x7f0800c9 | 4304 |
| `com_facebook_button_icon` | int | 0x7f0800ca | 4305 |
| `com_facebook_button_like_background` | int | 0x7f0800cb | 4306 |
| `com_facebook_button_like_icon_selected` | int | 0x7f0800cc | 4307 |
| `com_facebook_button_send_background` | int | 0x7f0800cd | 4308 |
| `com_facebook_button_send_icon_blue` | int | 0x7f0800ce | 4309 |
| `com_facebook_button_send_icon_white` | int | 0x7f0800cf | 4310 |
| `com_facebook_close` | int | 0x7f0800d0 | 4311 |
| `com_facebook_favicon_blue` | int | 0x7f0800d1 | 4312 |
| `com_facebook_profile_picture_blank_portrait` | int | 0x7f0800d2 | 4313 |
| `com_facebook_profile_picture_blank_square` | int | 0x7f0800d3 | 4314 |
| `com_facebook_send_button_icon` | int | 0x7f0800d4 | 4315 |
| `com_facebook_tooltip_black_background` | int | 0x7f0800d5 | 4316 |
| `com_facebook_tooltip_black_bottomnub` | int | 0x7f0800d6 | 4317 |
| `com_facebook_tooltip_black_topnub` | int | 0x7f0800d7 | 4318 |
| `com_facebook_tooltip_black_xout` | int | 0x7f0800d8 | 4319 |
| `com_facebook_tooltip_blue_background` | int | 0x7f0800d9 | 4320 |
| `com_facebook_tooltip_blue_bottomnub` | int | 0x7f0800da | 4321 |
| `com_facebook_tooltip_blue_topnub` | int | 0x7f0800db | 4322 |
| `com_facebook_tooltip_blue_xout` | int | 0x7f0800dc | 4323 |
| `common_full_open_on_phone` | int | 0x7f0800dd | 4324 |
| `common_google_signin_btn_icon_dark` | int | 0x7f0800de | 4325 |
| `common_google_signin_btn_icon_dark_focused` | int | 0x7f0800df | 4326 |
| `common_google_signin_btn_icon_dark_normal` | int | 0x7f0800e0 | 4327 |
| `common_google_signin_btn_icon_dark_normal_background` | int | 0x7f0800e1 | 4328 |
| `common_google_signin_btn_icon_disabled` | int | 0x7f0800e2 | 4329 |
| `common_google_signin_btn_icon_light` | int | 0x7f0800e3 | 4330 |
| `common_google_signin_btn_icon_light_focused` | int | 0x7f0800e4 | 4331 |
| `common_google_signin_btn_icon_light_normal` | int | 0x7f0800e5 | 4332 |
| `common_google_signin_btn_icon_light_normal_background` | int | 0x7f0800e6 | 4333 |
| `common_google_signin_btn_text_dark` | int | 0x7f0800e7 | 4334 |
| `common_google_signin_btn_text_dark_focused` | int | 0x7f0800e8 | 4335 |
| `common_google_signin_btn_text_dark_normal` | int | 0x7f0800e9 | 4336 |
| `common_google_signin_btn_text_dark_normal_background` | int | 0x7f0800ea | 4337 |
| `common_google_signin_btn_text_disabled` | int | 0x7f0800eb | 4338 |
| `common_google_signin_btn_text_light` | int | 0x7f0800ec | 4339 |
| `common_google_signin_btn_text_light_focused` | int | 0x7f0800ed | 4340 |
| `common_google_signin_btn_text_light_normal` | int | 0x7f0800ee | 4341 |
| `common_google_signin_btn_text_light_normal_background` | int | 0x7f0800ef | 4342 |
| `connect_course_line` | int | 0x7f0800f0 | 4343 |
| `continuous_shot_1` | int | 0x7f0800f1 | 4344 |
| `continuous_shot_15` | int | 0x7f0800f2 | 4345 |
| `continuous_shot_2` | int | 0x7f0800f3 | 4346 |
| `continuous_shot_3` | int | 0x7f0800f4 | 4347 |
| `continuous_shot_30` | int | 0x7f0800f5 | 4348 |
| `continuous_shot_7` | int | 0x7f0800f6 | 4349 |
| `continuous_shot_continuous` | int | 0x7f0800f7 | 4350 |
| `default_btn` | int | 0x7f0800f8 | 4351 |
| `default_btn_disabled` | int | 0x7f0800f9 | 4352 |
| `default_btn_pre` | int | 0x7f0800fa | 4353 |
| `default_logo` | int | 0x7f0800fb | 4354 |
| `default_ptr_flip` | int | 0x7f0800fc | 4355 |
| `default_ptr_rotate` | int | 0x7f0800fd | 4356 |
| `delete` | int | 0x7f0800fe | 4357 |
| `design_fab_background` | int | 0x7f0800ff | 4358 |
| `design_ic_visibility` | int | 0x7f080100 | 4359 |
| `design_ic_visibility_off` | int | 0x7f080101 | 4360 |
| `design_password_eye` | int | 0x7f080102 | 4361 |
| `design_snackbar_background` | int | 0x7f080103 | 4362 |
| `dialog_line` | int | 0x7f080104 | 4363 |
| `dialog_loading` | int | 0x7f080105 | 4364 |
| `dialog_loading_img` | int | 0x7f080106 | 4365 |
| `direction_down_arrow` | int | 0x7f080107 | 4366 |
| `direction_left_arrow` | int | 0x7f080108 | 4367 |
| `direction_right_arrow` | int | 0x7f080109 | 4368 |
| `direction_up_arrow` | int | 0x7f08010a | 4369 |
| `divider` | int | 0x7f08010b | 4370 |
| `down` | int | 0x7f08010c | 4371 |
| `down_arrow` | int | 0x7f08010d | 4372 |
| `down_arrow_down` | int | 0x7f08010e | 4373 |
| `down_press` | int | 0x7f08010f | 4374 |
| `edit_note_bg` | int | 0x7f080110 | 4375 |
| `empty_drawable` | int | 0x7f080111 | 4376 |
| `empty_photo` | int | 0x7f080112 | 4377 |
| `exo_controls_fastforward` | int | 0x7f080113 | 4378 |
| `exo_controls_fullscreen_enter` | int | 0x7f080114 | 4379 |
| `exo_controls_fullscreen_exit` | int | 0x7f080115 | 4380 |
| `exo_controls_next` | int | 0x7f080116 | 4381 |
| `exo_controls_pause` | int | 0x7f080117 | 4382 |
| `exo_controls_play` | int | 0x7f080118 | 4383 |
| `exo_controls_previous` | int | 0x7f080119 | 4384 |
| `exo_controls_repeat_all` | int | 0x7f08011a | 4385 |
| `exo_controls_repeat_off` | int | 0x7f08011b | 4386 |
| `exo_controls_repeat_one` | int | 0x7f08011c | 4387 |
| `exo_controls_rewind` | int | 0x7f08011d | 4388 |
| `exo_controls_shuffle_off` | int | 0x7f08011e | 4389 |
| `exo_controls_shuffle_on` | int | 0x7f08011f | 4390 |
| `exo_controls_vr` | int | 0x7f080120 | 4391 |
| `exo_edit_mode_logo` | int | 0x7f080121 | 4392 |
| `exo_ic_audiotrack` | int | 0x7f080122 | 4393 |
| `exo_ic_check` | int | 0x7f080123 | 4394 |
| `exo_ic_chevron_left` | int | 0x7f080124 | 4395 |
| `exo_ic_chevron_right` | int | 0x7f080125 | 4396 |
| `exo_ic_default_album_image` | int | 0x7f080126 | 4397 |
| `exo_ic_forward` | int | 0x7f080127 | 4398 |
| `exo_ic_fullscreen_enter` | int | 0x7f080128 | 4399 |
| `exo_ic_fullscreen_exit` | int | 0x7f080129 | 4400 |
| `exo_ic_pause_circle_filled` | int | 0x7f08012a | 4401 |
| `exo_ic_play_circle_filled` | int | 0x7f08012b | 4402 |
| `exo_ic_rewind` | int | 0x7f08012c | 4403 |
| `exo_ic_settings` | int | 0x7f08012d | 4404 |
| `exo_ic_skip_next` | int | 0x7f08012e | 4405 |
| `exo_ic_skip_previous` | int | 0x7f08012f | 4406 |
| `exo_ic_speed` | int | 0x7f080130 | 4407 |
| `exo_ic_subtitle_off` | int | 0x7f080131 | 4408 |
| `exo_ic_subtitle_on` | int | 0x7f080132 | 4409 |
| `exo_icon_circular_play` | int | 0x7f080133 | 4410 |
| `exo_icon_fastforward` | int | 0x7f080134 | 4411 |
| `exo_icon_fullscreen_enter` | int | 0x7f080135 | 4412 |
| `exo_icon_fullscreen_exit` | int | 0x7f080136 | 4413 |
| `exo_icon_next` | int | 0x7f080137 | 4414 |
| `exo_icon_pause` | int | 0x7f080138 | 4415 |
| `exo_icon_play` | int | 0x7f080139 | 4416 |
| `exo_icon_previous` | int | 0x7f08013a | 4417 |
| `exo_icon_repeat_all` | int | 0x7f08013b | 4418 |
| `exo_icon_repeat_off` | int | 0x7f08013c | 4419 |
| `exo_icon_repeat_one` | int | 0x7f08013d | 4420 |
| `exo_icon_rewind` | int | 0x7f08013e | 4421 |
| `exo_icon_shuffle_off` | int | 0x7f08013f | 4422 |
| `exo_icon_shuffle_on` | int | 0x7f080140 | 4423 |
| `exo_icon_stop` | int | 0x7f080141 | 4424 |
| `exo_icon_vr` | int | 0x7f080142 | 4425 |
| `exo_notification_fastforward` | int | 0x7f080143 | 4426 |
| `exo_notification_next` | int | 0x7f080144 | 4427 |
| `exo_notification_pause` | int | 0x7f080145 | 4428 |
| `exo_notification_play` | int | 0x7f080146 | 4429 |
| `exo_notification_previous` | int | 0x7f080147 | 4430 |
| `exo_notification_rewind` | int | 0x7f080148 | 4431 |
| `exo_notification_small_icon` | int | 0x7f080149 | 4432 |
| `exo_notification_stop` | int | 0x7f08014a | 4433 |
| `exo_rounded_rectangle` | int | 0x7f08014b | 4434 |
| `exo_styled_controls_audiotrack` | int | 0x7f08014c | 4435 |
| `exo_styled_controls_check` | int | 0x7f08014d | 4436 |
| `exo_styled_controls_fastforward` | int | 0x7f08014e | 4437 |
| `exo_styled_controls_fullscreen_enter` | int | 0x7f08014f | 4438 |
| `exo_styled_controls_fullscreen_exit` | int | 0x7f080150 | 4439 |
| `exo_styled_controls_next` | int | 0x7f080151 | 4440 |
| `exo_styled_controls_overflow_hide` | int | 0x7f080152 | 4441 |
| `exo_styled_controls_overflow_show` | int | 0x7f080153 | 4442 |
| `exo_styled_controls_pause` | int | 0x7f080154 | 4443 |
| `exo_styled_controls_play` | int | 0x7f080155 | 4444 |
| `exo_styled_controls_previous` | int | 0x7f080156 | 4445 |
| `exo_styled_controls_repeat_all` | int | 0x7f080157 | 4446 |
| `exo_styled_controls_repeat_off` | int | 0x7f080158 | 4447 |
| `exo_styled_controls_repeat_one` | int | 0x7f080159 | 4448 |
| `exo_styled_controls_rewind` | int | 0x7f08015a | 4449 |
| `exo_styled_controls_settings` | int | 0x7f08015b | 4450 |
| `exo_styled_controls_shuffle_off` | int | 0x7f08015c | 4451 |
| `exo_styled_controls_shuffle_on` | int | 0x7f08015d | 4452 |
| `exo_styled_controls_speed` | int | 0x7f08015e | 4453 |
| `exo_styled_controls_subtitle_off` | int | 0x7f08015f | 4454 |
| `exo_styled_controls_subtitle_on` | int | 0x7f080160 | 4455 |
| `exo_styled_controls_vr` | int | 0x7f080161 | 4456 |
| `file_grid_item_selector` | int | 0x7f080162 | 4457 |
| `file_mgr_btn` | int | 0x7f080163 | 4458 |
| `file_status_green` | int | 0x7f080164 | 4459 |
| `flag_timelapse_capture` | int | 0x7f080165 | 4460 |
| `flag_timelapse_video` | int | 0x7f080166 | 4461 |
| `frame` | int | 0x7f080167 | 4462 |
| `ftp_switch_showstyle_toggle` | int | 0x7f080168 | 4463 |
| `full_scree_top` | int | 0x7f080169 | 4464 |
| `full_screen_video_btn_mute` | int | 0x7f08016a | 4465 |
| `full_screen_video_btn_mute_1` | int | 0x7f08016b | 4466 |
| `full_screen_video_btn_mute_pre` | int | 0x7f08016c | 4467 |
| `full_screen_video_btn_mute_pre_1` | int | 0x7f08016d | 4468 |
| `full_screen_video_btn_screenshot` | int | 0x7f08016e | 4469 |
| `full_screen_video_btn_screenshot_pre` | int | 0x7f08016f | 4470 |
| `full_screen_video_btn_speak` | int | 0x7f080170 | 4471 |
| `full_screen_video_btn_speak_1` | int | 0x7f080171 | 4472 |
| `full_screen_video_btn_speak_pre` | int | 0x7f080172 | 4473 |
| `full_screen_video_btn_speak_pre_1` | int | 0x7f080173 | 4474 |
| `fullscreen` | int | 0x7f080174 | 4475 |
| `googleg_color` | int | 0x7f080175 | 4476 |
| `googleg_disabled_color_18` | int | 0x7f080176 | 4477 |
| `googleg_standard_color_18` | int | 0x7f080177 | 4478 |
| `home_button` | int | 0x7f080178 | 4479 |
| `ic_3d_rotation_black_48dp` | int | 0x7f080179 | 4480 |
| `ic_add_circle_24dp` | int | 0x7f08017a | 4481 |
| `ic_add_circle_greyish_white_36dp` | int | 0x7f08017b | 4482 |
| `ic_add_white_24dp` | int | 0x7f08017c | 4483 |
| `ic_all_out_ball_white_24dp` | int | 0x7f08017d | 4484 |
| `ic_arrow_back_black_18dp` | int | 0x7f08017e | 4485 |
| `ic_arrow_back_black_24` | int | 0x7f08017f | 4486 |
| `ic_arrow_back_white_24dp` | int | 0x7f080180 | 4487 |
| `ic_arrow_back_white_36dp` | int | 0x7f080181 | 4488 |
| `ic_battery_20_24dp` | int | 0x7f080182 | 4489 |
| `ic_battery_30_24dp` | int | 0x7f080183 | 4490 |
| `ic_battery_30_green_24dp` | int | 0x7f080184 | 4491 |
| `ic_battery_50_24dp` | int | 0x7f080185 | 4492 |
| `ic_battery_60_24dp` | int | 0x7f080186 | 4493 |
| `ic_battery_60_green_24dp` | int | 0x7f080187 | 4494 |
| `ic_battery_80_24dp` | int | 0x7f080188 | 4495 |
| `ic_battery_90_24dp` | int | 0x7f080189 | 4496 |
| `ic_battery_alert_24dp` | int | 0x7f08018a | 4497 |
| `ic_battery_alert_green_24dp` | int | 0x7f08018b | 4498 |
| `ic_battery_charging_full_24dp` | int | 0x7f08018c | 4499 |
| `ic_battery_charging_full_green_24dp` | int | 0x7f08018d | 4500 |
| `ic_battery_charging_green24dp` | int | 0x7f08018e | 4501 |
| `ic_battery_full_24dp` | int | 0x7f08018f | 4502 |
| `ic_battery_full_green_24dp` | int | 0x7f080190 | 4503 |
| `ic_calendar_green` | int | 0x7f080191 | 4504 |
| `ic_call_answer` | int | 0x7f080192 | 4505 |
| `ic_call_answer_low` | int | 0x7f080193 | 4506 |
| `ic_call_answer_video` | int | 0x7f080194 | 4507 |
| `ic_call_answer_video_low` | int | 0x7f080195 | 4508 |
| `ic_call_decline` | int | 0x7f080196 | 4509 |
| `ic_call_decline_low` | int | 0x7f080197 | 4510 |
| `ic_check_box_blank_grey` | int | 0x7f080198 | 4511 |
| `ic_check_box_blue` | int | 0x7f080199 | 4512 |
| `ic_check_box_outline_blank_blue_400_24dp` | int | 0x7f08019a | 4513 |
| `ic_chevron_left_48dp` | int | 0x7f08019b | 4514 |
| `ic_chevron_right_48dp` | int | 0x7f08019c | 4515 |
| `ic_clear_black_24` | int | 0x7f08019d | 4516 |
| `ic_clear_black_24dp` | int | 0x7f08019e | 4517 |
| `ic_clear_white_24dp` | int | 0x7f08019f | 4518 |
| `ic_clock_black_24dp` | int | 0x7f0801a0 | 4519 |
| `ic_close_black` | int | 0x7f0801a1 | 4520 |
| `ic_delete` | int | 0x7f0801a2 | 4521 |
| `ic_delete_white_18dp` | int | 0x7f0801a3 | 4522 |
| `ic_delete_white_24dp` | int | 0x7f0801a4 | 4523 |
| `ic_delete_white_36dp` | int | 0x7f0801a5 | 4524 |
| `ic_done_black` | int | 0x7f0801a6 | 4525 |
| `ic_done_blue_grey_900_48dp` | int | 0x7f0801a7 | 4526 |
| `ic_done_cyan` | int | 0x7f0801a8 | 4527 |
| `ic_done_grey_100_48dp` | int | 0x7f0801a9 | 4528 |
| `ic_download` | int | 0x7f0801aa | 4529 |
| `ic_downloads` | int | 0x7f0801ab | 4530 |
| `ic_effect_list` | int | 0x7f0801ac | 4531 |
| `ic_effect_list_press` | int | 0x7f0801ad | 4532 |
| `ic_expand_less_22px` | int | 0x7f0801ae | 4533 |
| `ic_expand_more_22px` | int | 0x7f0801af | 4534 |
| `ic_file_download_grey_600_24dp` | int | 0x7f0801b0 | 4535 |
| `ic_file_download_white_24dp` | int | 0x7f0801b1 | 4536 |
| `ic_filter_list_white_24dp` | int | 0x7f0801b2 | 4537 |
| `ic_image` | int | 0x7f0801b3 | 4538 |
| `ic_image_focus` | int | 0x7f0801b4 | 4539 |
| `ic_info_black_24dp` | int | 0x7f0801b5 | 4540 |
| `ic_info_white_36dp` | int | 0x7f0801b6 | 4541 |
| `ic_inside_ball_white_24dp` | int | 0x7f0801b7 | 4542 |
| `ic_keyboard_black_24dp` | int | 0x7f0801b8 | 4543 |
| `ic_launcher` | int | 0x7f0801b9 | 4544 |
| `ic_m3_chip_check` | int | 0x7f0801ba | 4545 |
| `ic_m3_chip_checked_circle` | int | 0x7f0801bb | 4546 |
| `ic_m3_chip_close` | int | 0x7f0801bc | 4547 |
| `ic_more_vert_white_24dp` | int | 0x7f0801bd | 4548 |
| `ic_mtrl_arrow_circle` | int | 0x7f0801be | 4549 |
| `ic_mtrl_checked_circle` | int | 0x7f0801bf | 4550 |
| `ic_mtrl_chip_checked_black` | int | 0x7f0801c0 | 4551 |
| `ic_mtrl_chip_checked_circle` | int | 0x7f0801c1 | 4552 |
| `ic_mtrl_chip_close_circle` | int | 0x7f0801c2 | 4553 |
| `ic_navigate_before_white_18dp` | int | 0x7f0801c3 | 4554 |
| `ic_navigate_before_white_36dp` | int | 0x7f0801c4 | 4555 |
| `ic_notifications_black_24dp` | int | 0x7f0801c5 | 4556 |
| `ic_panorama_18dp` | int | 0x7f0801c6 | 4557 |
| `ic_panorama_flag` | int | 0x7f0801c7 | 4558 |
| `ic_panorama_green_500_48dp` | int | 0x7f0801c8 | 4559 |
| `ic_pause_white` | int | 0x7f0801c9 | 4560 |
| `ic_pause_white_36dp` | int | 0x7f0801ca | 4561 |
| `ic_photo_camera_48dp` | int | 0x7f0801cb | 4562 |
| `ic_play_arrow_white` | int | 0x7f0801cc | 4563 |
| `ic_play_arrow_white_24dp` | int | 0x7f0801cd | 4564 |
| `ic_play_arrow_white_36dp` | int | 0x7f0801ce | 4565 |
| `ic_play_circle_outline_blue_grey` | int | 0x7f0801cf | 4566 |
| `ic_play_circle_outline_blue_grey_48dp` | int | 0x7f0801d0 | 4567 |
| `ic_refresh_white_24dp` | int | 0x7f0801d1 | 4568 |
| `ic_remove_circle_red_24dp` | int | 0x7f0801d2 | 4569 |
| `ic_remove_white_24dp` | int | 0x7f0801d3 | 4570 |
| `ic_search_black_24` | int | 0x7f0801d4 | 4571 |
| `ic_select` | int | 0x7f0801d5 | 4572 |
| `ic_select_all_white_24dp` | int | 0x7f0801d6 | 4573 |
| `ic_settings_power` | int | 0x7f0801d7 | 4574 |
| `ic_settings_white` | int | 0x7f0801d8 | 4575 |
| `ic_share_white_24dp` | int | 0x7f0801d9 | 4576 |
| `ic_share_white_36dp` | int | 0x7f0801da | 4577 |
| `ic_signal_wifi_0_bar_24dp` | int | 0x7f0801db | 4578 |
| `ic_signal_wifi_0_bar_green_24dp` | int | 0x7f0801dc | 4579 |
| `ic_signal_wifi_1_bar_24dp` | int | 0x7f0801dd | 4580 |
| `ic_signal_wifi_1_bar_green_24dp` | int | 0x7f0801de | 4581 |
| `ic_signal_wifi_2_bar_24dp` | int | 0x7f0801df | 4582 |
| `ic_signal_wifi_2_bar_green_24dp` | int | 0x7f0801e0 | 4583 |
| `ic_signal_wifi_3_bar_24dp` | int | 0x7f0801e1 | 4584 |
| `ic_signal_wifi_3_bar_green_24dp` | int | 0x7f0801e2 | 4585 |
| `ic_signal_wifi_4_bar_24dp` | int | 0x7f0801e3 | 4586 |
| `ic_signal_wifi_4_bar_green_24dp` | int | 0x7f0801e4 | 4587 |
| `ic_stop_white_24dp` | int | 0x7f0801e5 | 4588 |
| `ic_stop_white_36dp` | int | 0x7f0801e6 | 4589 |
| `ic_sync_black_24dp` | int | 0x7f0801e7 | 4590 |
| `ic_unselected_white_24dp` | int | 0x7f0801e8 | 4591 |
| `ic_view_grid_white_24dp` | int | 0x7f0801e9 | 4592 |
| `ic_view_list_white_24dp` | int | 0x7f0801ea | 4593 |
| `icatch_launcher` | int | 0x7f0801eb | 4594 |
| `icon_gray` | int | 0x7f0801ec | 4595 |
| `icon_language_switch_false` | int | 0x7f0801ed | 4596 |
| `icon_language_switch_true` | int | 0x7f0801ee | 4597 |
| `icon_list_image` | int | 0x7f0801ef | 4598 |
| `image_video` | int | 0x7f0801f0 | 4599 |
| `indicator_arrow` | int | 0x7f0801f1 | 4600 |
| `indicator_bg_bottom` | int | 0x7f0801f2 | 4601 |
| `indicator_bg_top` | int | 0x7f0801f3 | 4602 |
| `jz_add_volume` | int | 0x7f0801f4 | 4603 |
| `jz_back_normal` | int | 0x7f0801f5 | 4604 |
| `jz_back_pressed` | int | 0x7f0801f6 | 4605 |
| `jz_back_tiny_normal` | int | 0x7f0801f7 | 4606 |
| `jz_back_tiny_pressed` | int | 0x7f0801f8 | 4607 |
| `jz_backward_icon` | int | 0x7f0801f9 | 4608 |
| `jz_battery_level_10` | int | 0x7f0801fa | 4609 |
| `jz_battery_level_100` | int | 0x7f0801fb | 4610 |
| `jz_battery_level_30` | int | 0x7f0801fc | 4611 |
| `jz_battery_level_50` | int | 0x7f0801fd | 4612 |
| `jz_battery_level_70` | int | 0x7f0801fe | 4613 |
| `jz_battery_level_90` | int | 0x7f0801ff | 4614 |
| `jz_bottom_bg` | int | 0x7f080200 | 4615 |
| `jz_bottom_progress` | int | 0x7f080201 | 4616 |
| `jz_bottom_seek_poster` | int | 0x7f080202 | 4617 |
| `jz_bottom_seek_progress` | int | 0x7f080203 | 4618 |
| `jz_brightness_video` | int | 0x7f080204 | 4619 |
| `jz_clarity_popwindow_bg` | int | 0x7f080205 | 4620 |
| `jz_click_back_selector` | int | 0x7f080206 | 4621 |
| `jz_click_back_tiny_selector` | int | 0x7f080207 | 4622 |
| `jz_click_pause_selector` | int | 0x7f080208 | 4623 |
| `jz_click_play_selector` | int | 0x7f080209 | 4624 |
| `jz_click_replay_selector` | int | 0x7f08020a | 4625 |
| `jz_click_share_selector` | int | 0x7f08020b | 4626 |
| `jz_close_volume` | int | 0x7f08020c | 4627 |
| `jz_dialog_progress` | int | 0x7f08020d | 4628 |
| `jz_dialog_progress_bg` | int | 0x7f08020e | 4629 |
| `jz_enlarge` | int | 0x7f08020f | 4630 |
| `jz_forward_icon` | int | 0x7f080210 | 4631 |
| `jz_loading` | int | 0x7f080211 | 4632 |
| `jz_loading_bg` | int | 0x7f080212 | 4633 |
| `jz_pause_normal` | int | 0x7f080213 | 4634 |
| `jz_pause_pressed` | int | 0x7f080214 | 4635 |
| `jz_play_normal` | int | 0x7f080215 | 4636 |
| `jz_play_pressed` | int | 0x7f080216 | 4637 |
| `jz_restart_normal` | int | 0x7f080217 | 4638 |
| `jz_restart_pressed` | int | 0x7f080218 | 4639 |
| `jz_retry` | int | 0x7f080219 | 4640 |
| `jz_seek_poster_normal` | int | 0x7f08021a | 4641 |
| `jz_seek_poster_pressed` | int | 0x7f08021b | 4642 |
| `jz_share_normal` | int | 0x7f08021c | 4643 |
| `jz_share_pressed` | int | 0x7f08021d | 4644 |
| `jz_shrink` | int | 0x7f08021e | 4645 |
| `jz_title_bg` | int | 0x7f08021f | 4646 |
| `jz_volume_icon` | int | 0x7f080220 | 4647 |
| `jz_volume_progress_bg` | int | 0x7f080221 | 4648 |
| `language_checkbox` | int | 0x7f080222 | 4649 |
| `left` | int | 0x7f080223 | 4650 |
| `left_arrow` | int | 0x7f080224 | 4651 |
| `left_arrow_down` | int | 0x7f080225 | 4652 |
| `left_drawable` | int | 0x7f080226 | 4653 |
| `left_press` | int | 0x7f080227 | 4654 |
| `loading_round_bg` | int | 0x7f080228 | 4655 |
| `local_default_thumbnail` | int | 0x7f080229 | 4656 |
| `local_video_item_selector` | int | 0x7f08022a | 4657 |
| `lock` | int | 0x7f08022b | 4658 |
| `logo_icatchtek_alpha` | int | 0x7f08022c | 4659 |
| `logo_startapp` | int | 0x7f08022d | 4660 |
| `logo_wificamera` | int | 0x7f08022e | 4661 |
| `m3_avd_hide_password` | int | 0x7f08022f | 4662 |
| `m3_avd_show_password` | int | 0x7f080230 | 4663 |
| `m3_bottom_sheet_drag_handle` | int | 0x7f080231 | 4664 |
| `m3_password_eye` | int | 0x7f080232 | 4665 |
| `m3_popupmenu_background_overlay` | int | 0x7f080233 | 4666 |
| `m3_radiobutton_ripple` | int | 0x7f080234 | 4667 |
| `m3_selection_control_ripple` | int | 0x7f080235 | 4668 |
| `m3_split_button_chevron_avd` | int | 0x7f080236 | 4669 |
| `m3_tabs_background` | int | 0x7f080237 | 4670 |
| `m3_tabs_line_indicator` | int | 0x7f080238 | 4671 |
| `m3_tabs_rounded_line_indicator` | int | 0x7f080239 | 4672 |
| `m3_tabs_transparent_background` | int | 0x7f08023a | 4673 |
| `material_cursor_drawable` | int | 0x7f08023b | 4674 |
| `material_ic_calendar_black_24dp` | int | 0x7f08023c | 4675 |
| `material_ic_clear_black_24dp` | int | 0x7f08023d | 4676 |
| `material_ic_edit_black_24dp` | int | 0x7f08023e | 4677 |
| `material_ic_keyboard_arrow_left_black_24dp` | int | 0x7f08023f | 4678 |
| `material_ic_keyboard_arrow_next_black_24dp` | int | 0x7f080240 | 4679 |
| `material_ic_keyboard_arrow_previous_black_24dp` | int | 0x7f080241 | 4680 |
| `material_ic_keyboard_arrow_right_black_24dp` | int | 0x7f080242 | 4681 |
| `material_ic_menu_arrow_down_black_24dp` | int | 0x7f080243 | 4682 |
| `material_ic_menu_arrow_up_black_24dp` | int | 0x7f080244 | 4683 |
| `media_home_btn_play` | int | 0x7f080245 | 4684 |
| `media_select` | int | 0x7f080246 | 4685 |
| `media_shape_bg_circle` | int | 0x7f080247 | 4686 |
| `media_shape_bg_round` | int | 0x7f080248 | 4687 |
| `media_unselect` | int | 0x7f080249 | 4688 |
| `media_video_btn_delect` | int | 0x7f08024a | 4689 |
| `media_video_btn_download` | int | 0x7f08024b | 4690 |
| `media_video_btn_download_press` | int | 0x7f08024c | 4691 |
| `media_video_btn_full_screen` | int | 0x7f08024d | 4692 |
| `media_video_btn_full_screen_eixt` | int | 0x7f08024e | 4693 |
| `media_video_btn_full_screen_exit` | int | 0x7f08024f | 4694 |
| `media_video_btn_more` | int | 0x7f080250 | 4695 |
| `media_video_btn_pause` | int | 0x7f080251 | 4696 |
| `media_video_btn_play` | int | 0x7f080252 | 4697 |
| `meida_add_setting` | int | 0x7f080253 | 4698 |
| `meida_btn_delect` | int | 0x7f080254 | 4699 |
| `meida_btn_delect_pre` | int | 0x7f080255 | 4700 |
| `meida_camera_roll_btn_photo_1` | int | 0x7f080256 | 4701 |
| `meida_camera_roll_btn_photo_loading` | int | 0x7f080257 | 4702 |
| `meida_camera_roll_btn_photo_pre_1` | int | 0x7f080258 | 4703 |
| `meida_camera_roll_btn_video_1` | int | 0x7f080259 | 4704 |
| `meida_camera_roll_btn_video_loading` | int | 0x7f08025a | 4705 |
| `meida_camera_roll_btn_video_pre_1` | int | 0x7f08025b | 4706 |
| `meida_check_box_blank_grey` | int | 0x7f08025c | 4707 |
| `meida_check_box_blue` | int | 0x7f08025d | 4708 |
| `meida_check_box_blue_400_24dp` | int | 0x7f08025e | 4709 |
| `meida_check_box_outline_blank_blue_400_24dp` | int | 0x7f08025f | 4710 |
| `meida_delete_white_24dp` | int | 0x7f080260 | 4711 |
| `meida_file_download_white_24dp` | int | 0x7f080261 | 4712 |
| `meida_home_btn_camera_roll_1` | int | 0x7f080262 | 4713 |
| `meida_home_btn_camera_roll_pre_1` | int | 0x7f080263 | 4714 |
| `meida_home_btn_delect_1` | int | 0x7f080264 | 4715 |
| `meida_home_btn_delect_pre_1` | int | 0x7f080265 | 4716 |
| `meida_home_btn_message_center` | int | 0x7f080266 | 4717 |
| `meida_home_btn_message_center_pre` | int | 0x7f080267 | 4718 |
| `meida_home_btn_play` | int | 0x7f080268 | 4719 |
| `meida_home_btn_share_1` | int | 0x7f080269 | 4720 |
| `meida_home_btn_share_disabled_1` | int | 0x7f08026a | 4721 |
| `meida_home_btn_share_pre_1` | int | 0x7f08026b | 4722 |
| `meida_home_btn_wifi` | int | 0x7f08026c | 4723 |
| `meida_home_btn_wifi_disable` | int | 0x7f08026d | 4724 |
| `meida_home_btn_wifi_pre` | int | 0x7f08026e | 4725 |
| `meida_item_right_arrow` | int | 0x7f08026f | 4726 |
| `meida_offline` | int | 0x7f080270 | 4727 |
| `meida_online` | int | 0x7f080271 | 4728 |
| `meida_po_seekbar` | int | 0x7f080272 | 4729 |
| `meida_select_all_white_24dp` | int | 0x7f080273 | 4730 |
| `meida_selecter_share_btn` | int | 0x7f080274 | 4731 |
| `meida_selector_album_btn` | int | 0x7f080275 | 4732 |
| `meida_selector_bg_circle_primary` | int | 0x7f080276 | 4733 |
| `meida_selector_delete_btn` | int | 0x7f080277 | 4734 |
| `meida_selector_download_btn` | int | 0x7f080278 | 4735 |
| `meida_selector_home_btn_message` | int | 0x7f080279 | 4736 |
| `meida_selector_home_btn_primary` | int | 0x7f08027a | 4737 |
| `meida_selector_home_delete_btn` | int | 0x7f08027b | 4738 |
| `meida_selector_primary` | int | 0x7f08027c | 4739 |
| `meida_selector_white2lightred` | int | 0x7f08027d | 4740 |
| `meida_selector_wifi_btn` | int | 0x7f08027e | 4741 |
| `meida_shape_bg_round_white` | int | 0x7f08027f | 4742 |
| `meida_shape_bg_white_red_circle` | int | 0x7f080280 | 4743 |
| `meida_video_btn_download` | int | 0x7f080281 | 4744 |
| `meida_video_btn_download_press` | int | 0x7f080282 | 4745 |
| `meida_video_item_btn` | int | 0x7f080283 | 4746 |
| `message_center_btn_action_detection` | int | 0x7f080284 | 4747 |
| `message_center_btn_ring` | int | 0x7f080285 | 4748 |
| `message_center_no_video` | int | 0x7f080286 | 4749 |
| `messenger_bubble_large_blue` | int | 0x7f080287 | 4750 |
| `messenger_bubble_large_white` | int | 0x7f080288 | 4751 |
| `messenger_bubble_small_blue` | int | 0x7f080289 | 4752 |
| `messenger_bubble_small_white` | int | 0x7f08028a | 4753 |
| `messenger_button_blue_bg_round` | int | 0x7f08028b | 4754 |
| `messenger_button_blue_bg_selector` | int | 0x7f08028c | 4755 |
| `messenger_button_send_round_shadow` | int | 0x7f08028d | 4756 |
| `messenger_button_white_bg_round` | int | 0x7f08028e | 4757 |
| `messenger_button_white_bg_selector` | int | 0x7f08028f | 4758 |
| `mosaic` | int | 0x7f080290 | 4759 |
| `mosaic2` | int | 0x7f080291 | 4760 |
| `mpb_download_btn` | int | 0x7f080292 | 4761 |
| `mtrl_bottomsheet_drag_handle` | int | 0x7f080293 | 4762 |
| `mtrl_checkbox_button` | int | 0x7f080294 | 4763 |
| `mtrl_checkbox_button_checked_unchecked` | int | 0x7f080295 | 4764 |
| `mtrl_checkbox_button_icon` | int | 0x7f080296 | 4765 |
| `mtrl_checkbox_button_icon_checked_indeterminate` | int | 0x7f080297 | 4766 |
| `mtrl_checkbox_button_icon_checked_unchecked` | int | 0x7f080298 | 4767 |
| `mtrl_checkbox_button_icon_indeterminate_checked` | int | 0x7f080299 | 4768 |
| `mtrl_checkbox_button_icon_indeterminate_unchecked` | int | 0x7f08029a | 4769 |
| `mtrl_checkbox_button_icon_unchecked_checked` | int | 0x7f08029b | 4770 |
| `mtrl_checkbox_button_icon_unchecked_indeterminate` | int | 0x7f08029c | 4771 |
| `mtrl_checkbox_button_unchecked_checked` | int | 0x7f08029d | 4772 |
| `mtrl_dialog_background` | int | 0x7f08029e | 4773 |
| `mtrl_dropdown_arrow` | int | 0x7f08029f | 4774 |
| `mtrl_ic_arrow_drop_down` | int | 0x7f0802a0 | 4775 |
| `mtrl_ic_arrow_drop_up` | int | 0x7f0802a1 | 4776 |
| `mtrl_ic_cancel` | int | 0x7f0802a2 | 4777 |
| `mtrl_ic_check_mark` | int | 0x7f0802a3 | 4778 |
| `mtrl_ic_checkbox_checked` | int | 0x7f0802a4 | 4779 |
| `mtrl_ic_checkbox_unchecked` | int | 0x7f0802a5 | 4780 |
| `mtrl_ic_error` | int | 0x7f0802a6 | 4781 |
| `mtrl_ic_indeterminate` | int | 0x7f0802a7 | 4782 |
| `mtrl_navigation_bar_item_background` | int | 0x7f0802a8 | 4783 |
| `mtrl_popupmenu_background` | int | 0x7f0802a9 | 4784 |
| `mtrl_popupmenu_background_overlay` | int | 0x7f0802aa | 4785 |
| `mtrl_switch_thumb` | int | 0x7f0802ab | 4786 |
| `mtrl_switch_thumb_checked` | int | 0x7f0802ac | 4787 |
| `mtrl_switch_thumb_checked_pressed` | int | 0x7f0802ad | 4788 |
| `mtrl_switch_thumb_checked_unchecked` | int | 0x7f0802ae | 4789 |
| `mtrl_switch_thumb_pressed` | int | 0x7f0802af | 4790 |
| `mtrl_switch_thumb_pressed_checked` | int | 0x7f0802b0 | 4791 |
| `mtrl_switch_thumb_pressed_unchecked` | int | 0x7f0802b1 | 4792 |
| `mtrl_switch_thumb_unchecked` | int | 0x7f0802b2 | 4793 |
| `mtrl_switch_thumb_unchecked_checked` | int | 0x7f0802b3 | 4794 |
| `mtrl_switch_thumb_unchecked_pressed` | int | 0x7f0802b4 | 4795 |
| `mtrl_switch_track` | int | 0x7f0802b5 | 4796 |
| `mtrl_switch_track_decoration` | int | 0x7f0802b6 | 4797 |
| `mtrl_tabs_default_indicator` | int | 0x7f0802b7 | 4798 |
| `mute` | int | 0x7f0802b8 | 4799 |
| `nav_btn_back` | int | 0x7f0802b9 | 4800 |
| `nav_btn_cancel_black` | int | 0x7f0802ba | 4801 |
| `navigation_empty_icon` | int | 0x7f0802bb | 4802 |
| `notification_action_background` | int | 0x7f0802bc | 4803 |
| `notification_bg` | int | 0x7f0802bd | 4804 |
| `notification_bg_low` | int | 0x7f0802be | 4805 |
| `notification_bg_low_normal` | int | 0x7f0802bf | 4806 |
| `notification_bg_low_pressed` | int | 0x7f0802c0 | 4807 |
| `notification_bg_normal` | int | 0x7f0802c1 | 4808 |
| `notification_bg_normal_pressed` | int | 0x7f0802c2 | 4809 |
| `notification_icon_background` | int | 0x7f0802c3 | 4810 |
| `notification_oversize_large_icon_bg` | int | 0x7f0802c4 | 4811 |
| `notification_template_icon_bg` | int | 0x7f0802c5 | 4812 |
| `notification_template_icon_low_bg` | int | 0x7f0802c6 | 4813 |
| `notification_tile_bg` | int | 0x7f0802c7 | 4814 |
| `notify_panel_notification_icon_bg` | int | 0x7f0802c8 | 4815 |
| `option_off` | int | 0x7f0802c9 | 4816 |
| `option_on` | int | 0x7f0802ca | 4817 |
| `option_setting_focus` | int | 0x7f0802cb | 4818 |
| `panorama` | int | 0x7f0802cc | 4819 |
| `pb_btn` | int | 0x7f0802cd | 4820 |
| `pictures_no` | int | 0x7f0802ce | 4821 |
| `po_seekbar_02` | int | 0x7f0802cf | 4822 |
| `progressbar` | int | 0x7f0802d0 | 4823 |
| `progressbar_refresh` | int | 0x7f0802d1 | 4824 |
| `rader` | int | 0x7f0802d2 | 4825 |
| `rectangle_drawable` | int | 0x7f0802d3 | 4826 |
| `recycler_divider` | int | 0x7f0802d4 | 4827 |
| `right` | int | 0x7f0802d5 | 4828 |
| `right_angle` | int | 0x7f0802d6 | 4829 |
| `right_angle2` | int | 0x7f0802d7 | 4830 |
| `right_arrow` | int | 0x7f0802d8 | 4831 |
| `right_arrow_down` | int | 0x7f0802d9 | 4832 |
| `right_drawable` | int | 0x7f0802da | 4833 |
| `right_press` | int | 0x7f0802db | 4834 |
| `rotate_progressbar` | int | 0x7f0802dc | 4835 |
| `round_angle_point` | int | 0x7f0802dd | 4836 |
| `round_angle_point_selected` | int | 0x7f0802de | 4837 |
| `round_angle_record_time_bg` | int | 0x7f0802df | 4838 |
| `round_angle_video_state_bg` | int | 0x7f0802e0 | 4839 |
| `round_angle_video_state_change_bg` | int | 0x7f0802e1 | 4840 |
| `round_angle_video_state_null_bg` | int | 0x7f0802e2 | 4841 |
| `round_angle_view` | int | 0x7f0802e3 | 4842 |
| `round_angle_view_about_app` | int | 0x7f0802ef | 4854 |
| `round_angle_view_language` | int | 0x7f0802f0 | 4855 |
| `round_angle_view01` | int | 0x7f0802e4 | 4843 |
| `round_angle_view02` | int | 0x7f0802e5 | 4844 |
| `round_angle_view03` | int | 0x7f0802e6 | 4845 |
| `round_angle_view04` | int | 0x7f0802e7 | 4846 |
| `round_angle_view05` | int | 0x7f0802e8 | 4847 |
| `round_angle_view06` | int | 0x7f0802e9 | 4848 |
| `round_angle_view07` | int | 0x7f0802ea | 4849 |
| `round_angle_view08` | int | 0x7f0802eb | 4850 |
| `round_angle_view09` | int | 0x7f0802ec | 4851 |
| `round_angle_view10` | int | 0x7f0802ed | 4852 |
| `round_angle_view11` | int | 0x7f0802ee | 4853 |
| `second_progress` | int | 0x7f0802f1 | 4856 |
| `seekbar_thumb` | int | 0x7f0802f2 | 4857 |
| `selector_btn_bg_color_grad` | int | 0x7f0802f3 | 4858 |
| `selector_btn_primary` | int | 0x7f0802f4 | 4859 |
| `selector_mute_off_btn` | int | 0x7f0802f5 | 4860 |
| `selector_mute_off_btn_full` | int | 0x7f0802f6 | 4861 |
| `selector_mute_on_btn` | int | 0x7f0802f7 | 4862 |
| `selector_mute_on_btn_full` | int | 0x7f0802f8 | 4863 |
| `selector_pickerview_btn` | int | 0x7f0802f9 | 4864 |
| `selector_primary` | int | 0x7f0802fa | 4865 |
| `selector_primary01` | int | 0x7f0802fb | 4866 |
| `selector_radio_capture` | int | 0x7f0802fc | 4867 |
| `selector_radio_timelapse` | int | 0x7f0802fd | 4868 |
| `selector_radio_video` | int | 0x7f0802fe | 4869 |
| `selector_switch_btn` | int | 0x7f0802ff | 4870 |
| `selector_transparent2gray` | int | 0x7f080300 | 4871 |
| `selector_video_btn_screenshot` | int | 0x7f080301 | 4872 |
| `selector_video_btn_screenshot_full` | int | 0x7f080302 | 4873 |
| `selector_video_btn_speak_off` | int | 0x7f080303 | 4874 |
| `selector_video_btn_speak_off_full` | int | 0x7f080304 | 4875 |
| `selector_video_btn_speak_on` | int | 0x7f080305 | 4876 |
| `selector_video_btn_speak_on_full` | int | 0x7f080306 | 4877 |
| `selector_white` | int | 0x7f080307 | 4878 |
| `selector_white2gray` | int | 0x7f080308 | 4879 |
| `selector_white2paleblue` | int | 0x7f080309 | 4880 |
| `setup_user_guide` | int | 0x7f08030a | 4881 |
| `shape_bg_blue_circle` | int | 0x7f08030b | 4882 |
| `shape_bg_c` | int | 0x7f08030c | 4883 |
| `shape_bg_round_red` | int | 0x7f08030d | 4884 |
| `shape_bg_transparent_circle` | int | 0x7f08030e | 4885 |
| `shape_corner` | int | 0x7f08030f | 4886 |
| `shape_dialog_bg` | int | 0x7f080310 | 4887 |
| `shape_edit_bg` | int | 0x7f080311 | 4888 |
| `shape_hollow_rectangle` | int | 0x7f080312 | 4889 |
| `shape_solid_dialog` | int | 0x7f080313 | 4890 |
| `shape_solid_select_ablum_size_dialog` | int | 0x7f080314 | 4891 |
| `size_bg` | int | 0x7f080315 | 4892 |
| `size_bg_focus` | int | 0x7f080316 | 4893 |
| `slow_motion` | int | 0x7f080317 | 4894 |
| `still_capture_btn` | int | 0x7f080318 | 4895 |
| `still_capture_btn_off` | int | 0x7f080319 | 4896 |
| `stop_off` | int | 0x7f08031a | 4897 |
| `stop_on` | int | 0x7f08031b | 4898 |
| `stretch_0` | int | 0x7f08031c | 4899 |
| `stretch_135` | int | 0x7f08031d | 4900 |
| `stretch_45` | int | 0x7f08031e | 4901 |
| `stretch_90` | int | 0x7f08031f | 4902 |
| `stretch_bottom` | int | 0x7f080320 | 4903 |
| `stretch_right` | int | 0x7f080321 | 4904 |
| `te_car_mode` | int | 0x7f080322 | 4905 |
| `test_level_drawable` | int | 0x7f080323 | 4906 |
| `timelapse_focus` | int | 0x7f080324 | 4907 |
| `timelapse_off` | int | 0x7f080325 | 4908 |
| `timelapse_on` | int | 0x7f080326 | 4909 |
| `timelapse_toggle_btn_off` | int | 0x7f080327 | 4910 |
| `timelapse_toggle_btn_on` | int | 0x7f080328 | 4911 |
| `toggle_btn_checked` | int | 0x7f080329 | 4912 |
| `toggle_btn_unchecked` | int | 0x7f08032a | 4913 |
| `tooltip_frame_dark` | int | 0x7f08032b | 4914 |
| `tooltip_frame_light` | int | 0x7f08032c | 4915 |
| `transition_recording` | int | 0x7f08032d | 4916 |
| `unlock` | int | 0x7f08032e | 4917 |
| `up_arrow` | int | 0x7f08032f | 4918 |
| `up_arrow_down` | int | 0x7f080330 | 4919 |
| `up_press` | int | 0x7f080331 | 4920 |
| `video_back` | int | 0x7f080332 | 4921 |
| `video_backward_icon` | int | 0x7f080333 | 4922 |
| `video_brightness_6_white_36dp` | int | 0x7f080334 | 4923 |
| `video_btn_full_screen` | int | 0x7f080335 | 4924 |
| `video_btn_mute` | int | 0x7f080336 | 4925 |
| `video_btn_mute_1` | int | 0x7f080337 | 4926 |
| `video_btn_mute_pre` | int | 0x7f080338 | 4927 |
| `video_btn_mute_pre_1` | int | 0x7f080339 | 4928 |
| `video_btn_screenshot` | int | 0x7f08033a | 4929 |
| `video_btn_screenshot_pre` | int | 0x7f08033b | 4930 |
| `video_btn_speak` | int | 0x7f08033c | 4931 |
| `video_btn_speak_1` | int | 0x7f08033d | 4932 |
| `video_btn_speak_pre` | int | 0x7f08033e | 4933 |
| `video_btn_speak_pre_1` | int | 0x7f08033f | 4934 |
| `video_buttery_0` | int | 0x7f080340 | 4935 |
| `video_buttery_10` | int | 0x7f080341 | 4936 |
| `video_buttery_100` | int | 0x7f080342 | 4937 |
| `video_buttery_20` | int | 0x7f080343 | 4938 |
| `video_buttery_30` | int | 0x7f080344 | 4939 |
| `video_buttery_40` | int | 0x7f080345 | 4940 |
| `video_buttery_50` | int | 0x7f080346 | 4941 |
| `video_buttery_60` | int | 0x7f080347 | 4942 |
| `video_buttery_70` | int | 0x7f080348 | 4943 |
| `video_buttery_80` | int | 0x7f080349 | 4944 |
| `video_buttery_90` | int | 0x7f08034a | 4945 |
| `video_charging` | int | 0x7f08034b | 4946 |
| `video_click_error_selector` | int | 0x7f08034c | 4947 |
| `video_click_pause_selector` | int | 0x7f08034d | 4948 |
| `video_click_play_selector` | int | 0x7f08034e | 4949 |
| `video_dialog_progress` | int | 0x7f08034f | 4950 |
| `video_dialog_progress_bg` | int | 0x7f080350 | 4951 |
| `video_enlarge` | int | 0x7f080351 | 4952 |
| `video_error_normal` | int | 0x7f080352 | 4953 |
| `video_error_pressed` | int | 0x7f080353 | 4954 |
| `video_fast_search_nomal` | int | 0x7f080354 | 4955 |
| `video_forward_icon` | int | 0x7f080355 | 4956 |
| `video_jump_btn_bg` | int | 0x7f080356 | 4957 |
| `video_loading` | int | 0x7f080357 | 4958 |
| `video_loading_bg` | int | 0x7f080358 | 4959 |
| `video_off` | int | 0x7f080359 | 4960 |
| `video_on` | int | 0x7f08035a | 4961 |
| `video_pause_normal` | int | 0x7f08035b | 4962 |
| `video_pause_pressed` | int | 0x7f08035c | 4963 |
| `video_play_normal` | int | 0x7f08035d | 4964 |
| `video_play_pressed` | int | 0x7f08035e | 4965 |
| `video_progress` | int | 0x7f08035f | 4966 |
| `video_recording_btn_off` | int | 0x7f080360 | 4967 |
| `video_recording_btn_on` | int | 0x7f080361 | 4968 |
| `video_recording_focus` | int | 0x7f080362 | 4969 |
| `video_seek_progress` | int | 0x7f080363 | 4970 |
| `video_seek_thumb` | int | 0x7f080364 | 4971 |
| `video_seek_thumb_normal` | int | 0x7f080365 | 4972 |
| `video_seek_thumb_pressed` | int | 0x7f080366 | 4973 |
| `video_seekbare_style` | int | 0x7f080367 | 4974 |
| `video_shrink` | int | 0x7f080368 | 4975 |
| `video_small_close` | int | 0x7f080369 | 4976 |
| `video_start` | int | 0x7f08036a | 4977 |
| `video_start_pressed` | int | 0x7f08036b | 4978 |
| `video_title_bg` | int | 0x7f08036c | 4979 |
| `video_toggle_btn_off` | int | 0x7f08036d | 4980 |
| `video_toggle_btn_on` | int | 0x7f08036e | 4981 |
| `video_toggle_focus` | int | 0x7f08036f | 4982 |
| `video_volume_icon` | int | 0x7f080370 | 4983 |
| `video_volume_progress_bg` | int | 0x7f080371 | 4984 |
| `videooverlay` | int | 0x7f080372 | 4985 |
| `vr` | int | 0x7f080373 | 4986 |
| `warning` | int | 0x7f080374 | 4987 |
| `widget_bar_more_nor` | int | 0x7f080375 | 4988 |
| `widget_bar_more_over` | int | 0x7f080376 | 4989 |
| `wifi_1` | int | 0x7f080377 | 4990 |
| `wifi_2` | int | 0x7f080378 | 4991 |
| `wifi_3` | int | 0x7f080379 | 4992 |
| `wifi_4` | int | 0x7f08037a | 4993 |
| `wifi_supported_ip` | int | 0x7f08037b | 4994 |

### `com.id221.golive.R$font`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `roboto_medium_numbers` | int | 0x7f090000 | 4998 |

### `com.id221.golive.R$id`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `above` | int | 0x7f0a001c | 5030 |
| `accelerate` | int | 0x7f0a001d | 5031 |
| `accessibility_action_clickable_span` | int | 0x7f0a001e | 5032 |
| `accessibility_custom_action_0` | int | 0x7f0a001f | 5033 |
| `accessibility_custom_action_1` | int | 0x7f0a0020 | 5034 |
| `accessibility_custom_action_10` | int | 0x7f0a0021 | 5035 |
| `accessibility_custom_action_11` | int | 0x7f0a0022 | 5036 |
| `accessibility_custom_action_12` | int | 0x7f0a0023 | 5037 |
| `accessibility_custom_action_13` | int | 0x7f0a0024 | 5038 |
| `accessibility_custom_action_14` | int | 0x7f0a0025 | 5039 |
| `accessibility_custom_action_15` | int | 0x7f0a0026 | 5040 |
| `accessibility_custom_action_16` | int | 0x7f0a0027 | 5041 |
| `accessibility_custom_action_17` | int | 0x7f0a0028 | 5042 |
| `accessibility_custom_action_18` | int | 0x7f0a0029 | 5043 |
| `accessibility_custom_action_19` | int | 0x7f0a002a | 5044 |
| `accessibility_custom_action_2` | int | 0x7f0a002b | 5045 |
| `accessibility_custom_action_20` | int | 0x7f0a002c | 5046 |
| `accessibility_custom_action_21` | int | 0x7f0a002d | 5047 |
| `accessibility_custom_action_22` | int | 0x7f0a002e | 5048 |
| `accessibility_custom_action_23` | int | 0x7f0a002f | 5049 |
| `accessibility_custom_action_24` | int | 0x7f0a0030 | 5050 |
| `accessibility_custom_action_25` | int | 0x7f0a0031 | 5051 |
| `accessibility_custom_action_26` | int | 0x7f0a0032 | 5052 |
| `accessibility_custom_action_27` | int | 0x7f0a0033 | 5053 |
| `accessibility_custom_action_28` | int | 0x7f0a0034 | 5054 |
| `accessibility_custom_action_29` | int | 0x7f0a0035 | 5055 |
| `accessibility_custom_action_3` | int | 0x7f0a0036 | 5056 |
| `accessibility_custom_action_30` | int | 0x7f0a0037 | 5057 |
| `accessibility_custom_action_31` | int | 0x7f0a0038 | 5058 |
| `accessibility_custom_action_4` | int | 0x7f0a0039 | 5059 |
| `accessibility_custom_action_5` | int | 0x7f0a003a | 5060 |
| `accessibility_custom_action_6` | int | 0x7f0a003b | 5061 |
| `accessibility_custom_action_7` | int | 0x7f0a003c | 5062 |
| `accessibility_custom_action_8` | int | 0x7f0a003d | 5063 |
| `accessibility_custom_action_9` | int | 0x7f0a003e | 5064 |
| `action_about` | int | 0x7f0a0043 | 5069 |
| `action_bar` | int | 0x7f0a0044 | 5070 |
| `action_bar_activity_content` | int | 0x7f0a0045 | 5071 |
| `action_bar_container` | int | 0x7f0a0046 | 5072 |
| `action_bar_root` | int | 0x7f0a0047 | 5073 |
| `action_bar_spinner` | int | 0x7f0a0048 | 5074 |
| `action_bar_subtitle` | int | 0x7f0a0049 | 5075 |
| `action_bar_title` | int | 0x7f0a004a | 5076 |
| `action_container` | int | 0x7f0a004b | 5077 |
| `action_context_bar` | int | 0x7f0a004c | 5078 |
| `action_delete` | int | 0x7f0a004d | 5079 |
| `action_device_pwd` | int | 0x7f0a004e | 5080 |
| `action_divider` | int | 0x7f0a004f | 5081 |
| `action_done` | int | 0x7f0a0050 | 5082 |
| `action_download` | int | 0x7f0a0051 | 5083 |
| `action_help` | int | 0x7f0a0052 | 5084 |
| `action_image` | int | 0x7f0a0053 | 5085 |
| `action_input_ip` | int | 0x7f0a0054 | 5086 |
| `action_license` | int | 0x7f0a0055 | 5087 |
| `action_menu_divider` | int | 0x7f0a0056 | 5088 |
| `action_menu_presenter` | int | 0x7f0a0057 | 5089 |
| `action_mode_bar` | int | 0x7f0a0058 | 5090 |
| `action_mode_bar_stub` | int | 0x7f0a0059 | 5091 |
| `action_mode_close_button` | int | 0x7f0a005a | 5092 |
| `action_refresh` | int | 0x7f0a005b | 5093 |
| `action_search` | int | 0x7f0a005c | 5094 |
| `action_select` | int | 0x7f0a005d | 5095 |
| `action_setting` | int | 0x7f0a005e | 5096 |
| `action_share` | int | 0x7f0a005f | 5097 |
| `action_text` | int | 0x7f0a0060 | 5098 |
| `action0` | int | 0x7f0a003f | 5065 |
| `actionDown` | int | 0x7f0a0040 | 5066 |
| `actionDownUp` | int | 0x7f0a0041 | 5067 |
| `actions` | int | 0x7f0a0061 | 5099 |
| `actionUp` | int | 0x7f0a0042 | 5068 |
| `activity_chooser_view_content` | int | 0x7f0a0062 | 5100 |
| `ad_full_id` | int | 0x7f0a0063 | 5101 |
| `ad_small_id` | int | 0x7f0a0064 | 5102 |
| `ad_time` | int | 0x7f0a0065 | 5103 |
| `add` | int | 0x7f0a0066 | 5104 |
| `adjust_height` | int | 0x7f0a0067 | 5105 |
| `adjust_width` | int | 0x7f0a0068 | 5106 |
| `advance` | int | 0x7f0a0069 | 5107 |
| `album_btn` | int | 0x7f0a006a | 5108 |
| `album_layout` | int | 0x7f0a006b | 5109 |
| `album_menu_camera_image` | int | 0x7f0a006c | 5110 |
| `album_menu_camera_video` | int | 0x7f0a006d | 5111 |
| `album_menu_finish` | int | 0x7f0a006e | 5112 |
| `alertTitle` | int | 0x7f0a006f | 5113 |
| `aligned` | int | 0x7f0a0070 | 5114 |
| `all` | int | 0x7f0a0071 | 5115 |
| `allStates` | int | 0x7f0a0072 | 5116 |
| `ALT` | int | 0x7f0a0000 | 5002 |
| `always` | int | 0x7f0a0073 | 5117 |
| `animateToEnd` | int | 0x7f0a0074 | 5118 |
| `animateToStart` | int | 0x7f0a0075 | 5119 |
| `anticipate` | int | 0x7f0a0077 | 5121 |
| `antiClockwise` | int | 0x7f0a0076 | 5120 |
| `app_bar_layout` | int | 0x7f0a0078 | 5122 |
| `APP_RENDER` | int | 0x7f0a0001 | 5003 |
| `app_video_brightness` | int | 0x7f0a0079 | 5123 |
| `app_video_brightness_box` | int | 0x7f0a007a | 5124 |
| `app_video_brightness_icon` | int | 0x7f0a007b | 5125 |
| `appbar` | int | 0x7f0a007c | 5126 |
| `AppBarLayout` | int | 0x7f0a0002 | 5004 |
| `arc` | int | 0x7f0a007d | 5127 |
| `asConfigured` | int | 0x7f0a007e | 5128 |
| `async` | int | 0x7f0a007f | 5129 |
| `audioSwitcher` | int | 0x7f0a0080 | 5130 |
| `auto` | int | 0x7f0a0081 | 5131 |
| `auto_download_imageview` | int | 0x7f0a0087 | 5137 |
| `autoComplete` | int | 0x7f0a0082 | 5132 |
| `autoCompleteToEnd` | int | 0x7f0a0083 | 5133 |
| `autoCompleteToStart` | int | 0x7f0a0084 | 5134 |
| `autoHide` | int | 0x7f0a0085 | 5135 |
| `autoLimit` | int | 0x7f0a0086 | 5136 |
| `automatic` | int | 0x7f0a0088 | 5138 |
| `availableSpace` | int | 0x7f0a0089 | 5139 |
| `axisRelative` | int | 0x7f0a008a | 5140 |
| `back` | int | 0x7f0a008b | 5141 |
| `back_btn` | int | 0x7f0a008c | 5142 |
| `back_tiny` | int | 0x7f0a008d | 5143 |
| `barrier` | int | 0x7f0a008e | 5144 |
| `baseline` | int | 0x7f0a008f | 5145 |
| `battery_level` | int | 0x7f0a0090 | 5146 |
| `battery_status` | int | 0x7f0a0091 | 5147 |
| `battery_time_layout` | int | 0x7f0a0092 | 5148 |
| `beginning` | int | 0x7f0a0094 | 5150 |
| `beginOnFirstDraw` | int | 0x7f0a0093 | 5149 |
| `below` | int | 0x7f0a0095 | 5151 |
| `bestChoice` | int | 0x7f0a0096 | 5152 |
| `blocking` | int | 0x7f0a0097 | 5153 |
| `bluetooth_connect` | int | 0x7f0a0098 | 5154 |
| `bluetooth_mac` | int | 0x7f0a0099 | 5155 |
| `bluetooth_name` | int | 0x7f0a009a | 5156 |
| `both` | int | 0x7f0a009b | 5157 |
| `BOTH` | int | 0x7f0a0003 | 5005 |
| `bottom` | int | 0x7f0a009c | 5158 |
| `BOTTOM_END` | int | 0x7f0a0004 | 5006 |
| `bottom_progress` | int | 0x7f0a009d | 5159 |
| `bottom_progressbar` | int | 0x7f0a009e | 5160 |
| `bottom_seek_progress` | int | 0x7f0a009f | 5161 |
| `BOTTOM_START` | int | 0x7f0a0005 | 5007 |
| `bounce` | int | 0x7f0a00a0 | 5162 |
| `bounceBoth` | int | 0x7f0a00a1 | 5163 |
| `bounceEnd` | int | 0x7f0a00a2 | 5164 |
| `bounceStart` | int | 0x7f0a00a3 | 5165 |
| `box_count` | int | 0x7f0a00a4 | 5166 |
| `brightness_progressbar` | int | 0x7f0a00a5 | 5167 |
| `browser_actions_header_text` | int | 0x7f0a00a6 | 5168 |
| `browser_actions_menu_item_icon` | int | 0x7f0a00a7 | 5169 |
| `browser_actions_menu_item_text` | int | 0x7f0a00a8 | 5170 |
| `browser_actions_menu_items` | int | 0x7f0a00a9 | 5171 |
| `browser_actions_menu_view` | int | 0x7f0a00aa | 5172 |
| `bt_header` | int | 0x7f0a00ab | 5173 |
| `bt_pair` | int | 0x7f0a00ac | 5174 |
| `bt_start_wifiap` | int | 0x7f0a00ad | 5175 |
| `bt_stop_wifiap` | int | 0x7f0a00ae | 5176 |
| `bt_wifisetup` | int | 0x7f0a00af | 5177 |
| `bt_wifisetup_camera_password` | int | 0x7f0a00b0 | 5178 |
| `bt_wifisetup_camera_ssid` | int | 0x7f0a00b1 | 5179 |
| `btn_camera_image` | int | 0x7f0a00b4 | 5182 |
| `btn_camera_video` | int | 0x7f0a00b5 | 5183 |
| `btn_emergency` | int | 0x7f0a00b6 | 5184 |
| `btn_format` | int | 0x7f0a00b7 | 5185 |
| `btn_photo` | int | 0x7f0a00b8 | 5186 |
| `btn_preview` | int | 0x7f0a00b9 | 5187 |
| `btn_reset` | int | 0x7f0a00ba | 5188 |
| `btn_submit` | int | 0x7f0a00bb | 5189 |
| `btn_switch_dir` | int | 0x7f0a00bc | 5190 |
| `btn_video` | int | 0x7f0a00bd | 5191 |
| `btnCancel` | int | 0x7f0a00b2 | 5180 |
| `btndown12` | int | 0x7f0a00be | 5192 |
| `btndown14` | int | 0x7f0a00bf | 5193 |
| `btnSubmit` | int | 0x7f0a00b3 | 5181 |
| `burst_status` | int | 0x7f0a00c0 | 5194 |
| `buttomBar` | int | 0x7f0a00c1 | 5195 |
| `button` | int | 0x7f0a00c2 | 5196 |
| `button_ble_search` | int | 0x7f0a00c4 | 5198 |
| `button_bluetooth_search` | int | 0x7f0a00c5 | 5199 |
| `button_optional_action` | int | 0x7f0a00c6 | 5200 |
| `buttonPanel` | int | 0x7f0a00c3 | 5197 |
| `cache_measures` | int | 0x7f0a00c7 | 5201 |
| `calendar_spinner` | int | 0x7f0a00c9 | 5203 |
| `calendarView` | int | 0x7f0a00c8 | 5202 |
| `callMeasure` | int | 0x7f0a00ca | 5204 |
| `cam_slot_listview` | int | 0x7f0a00cb | 5205 |
| `camera_name` | int | 0x7f0a00cc | 5206 |
| `camera_pv_image` | int | 0x7f0a00cd | 5207 |
| `camera_type_list` | int | 0x7f0a00ce | 5208 |
| `cancel_action` | int | 0x7f0a00cf | 5209 |
| `cancel_all_txv` | int | 0x7f0a00d0 | 5210 |
| `cancel_btn` | int | 0x7f0a00d1 | 5211 |
| `cancel_button` | int | 0x7f0a00d2 | 5212 |
| `capture_radio` | int | 0x7f0a00d3 | 5213 |
| `car_mode` | int | 0x7f0a00d4 | 5214 |
| `carryVelocity` | int | 0x7f0a00d5 | 5215 |
| `cb_chinese_s` | int | 0x7f0a00d6 | 5216 |
| `cb_chinese_t` | int | 0x7f0a00d7 | 5217 |
| `cb_english` | int | 0x7f0a00d8 | 5218 |
| `cb_japanese` | int | 0x7f0a00d9 | 5219 |
| `cb_korean` | int | 0x7f0a00da | 5220 |
| `cb_select_item` | int | 0x7f0a00db | 5221 |
| `cb_thai` | int | 0x7f0a00dc | 5222 |
| `center` | int | 0x7f0a00dd | 5223 |
| `center_horizontal` | int | 0x7f0a00e0 | 5226 |
| `center_vertical` | int | 0x7f0a00e1 | 5227 |
| `centerCrop` | int | 0x7f0a00de | 5224 |
| `centerInside` | int | 0x7f0a00df | 5225 |
| `chain` | int | 0x7f0a00e2 | 5228 |
| `chain2` | int | 0x7f0a00e3 | 5229 |
| `chains` | int | 0x7f0a00e4 | 5230 |
| `check_box` | int | 0x7f0a00e5 | 5231 |
| `checkbox` | int | 0x7f0a00e6 | 5232 |
| `checked` | int | 0x7f0a00e7 | 5233 |
| `choose_blutTooth_list` | int | 0x7f0a00e8 | 5234 |
| `chronometer` | int | 0x7f0a00e9 | 5235 |
| `circle_center` | int | 0x7f0a00ea | 5236 |
| `clarity` | int | 0x7f0a00eb | 5237 |
| `clear_text` | int | 0x7f0a00ec | 5238 |
| `clip_horizontal` | int | 0x7f0a00ed | 5239 |
| `clip_vertical` | int | 0x7f0a00ee | 5240 |
| `clockwise` | int | 0x7f0a00ef | 5241 |
| `closest` | int | 0x7f0a00f0 | 5242 |
| `codec_info_txv` | int | 0x7f0a00f1 | 5243 |
| `collapseActionView` | int | 0x7f0a00f2 | 5244 |
| `com_facebook_body_frame` | int | 0x7f0a00f3 | 5245 |
| `com_facebook_button_xout` | int | 0x7f0a00f4 | 5246 |
| `com_facebook_device_auth_instructions` | int | 0x7f0a00f5 | 5247 |
| `com_facebook_fragment_container` | int | 0x7f0a00f6 | 5248 |
| `com_facebook_login_fragment_progress_bar` | int | 0x7f0a00f7 | 5249 |
| `com_facebook_smart_instructions_0` | int | 0x7f0a00f8 | 5250 |
| `com_facebook_smart_instructions_or` | int | 0x7f0a00f9 | 5251 |
| `com_facebook_tooltip_bubble_view_bottom_pointer` | int | 0x7f0a00fa | 5252 |
| `com_facebook_tooltip_bubble_view_text_body` | int | 0x7f0a00fb | 5253 |
| `com_facebook_tooltip_bubble_view_top_pointer` | int | 0x7f0a00fc | 5254 |
| `common_item_view` | int | 0x7f0a00fd | 5255 |
| `commont_layout` | int | 0x7f0a00fe | 5256 |
| `compress` | int | 0x7f0a00ff | 5257 |
| `confirm_button` | int | 0x7f0a0100 | 5258 |
| `confirmation_code` | int | 0x7f0a0101 | 5259 |
| `constraint` | int | 0x7f0a0102 | 5260 |
| `container` | int | 0x7f0a0103 | 5261 |
| `content` | int | 0x7f0a0104 | 5262 |
| `content_container` | int | 0x7f0a0106 | 5264 |
| `content_icon` | int | 0x7f0a0107 | 5265 |
| `contentPanel` | int | 0x7f0a0105 | 5263 |
| `contiguous` | int | 0x7f0a0108 | 5266 |
| `continuousVelocity` | int | 0x7f0a0109 | 5267 |
| `controller_placeholder` | int | 0x7f0a010a | 5268 |
| `coordinator` | int | 0x7f0a010b | 5269 |
| `cos` | int | 0x7f0a010c | 5270 |
| `counterclockwise` | int | 0x7f0a010d | 5271 |
| `cradle` | int | 0x7f0a010e | 5272 |
| `CTRL` | int | 0x7f0a0006 | 5008 |
| `current` | int | 0x7f0a010f | 5273 |
| `currentState` | int | 0x7f0a0110 | 5274 |
| `custom` | int | 0x7f0a0111 | 5275 |
| `customer_live_btn` | int | 0x7f0a0113 | 5277 |
| `customPanel` | int | 0x7f0a0112 | 5276 |
| `cut` | int | 0x7f0a0114 | 5278 |
| `dark` | int | 0x7f0a0115 | 5279 |
| `date_picker_actions` | int | 0x7f0a0116 | 5280 |
| `day` | int | 0x7f0a0117 | 5281 |
| `decelerate` | int | 0x7f0a0118 | 5282 |
| `decelerateAndComplete` | int | 0x7f0a0119 | 5283 |
| `decor_content_parent` | int | 0x7f0a011a | 5284 |
| `default_activity_button` | int | 0x7f0a011b | 5285 |
| `delay_capture_iv` | int | 0x7f0a011c | 5286 |
| `delay_capture_layout` | int | 0x7f0a011d | 5287 |
| `delay_capture_text` | int | 0x7f0a011e | 5288 |
| `delete_btn` | int | 0x7f0a0120 | 5290 |
| `delete_camera` | int | 0x7f0a0121 | 5291 |
| `delete_layout` | int | 0x7f0a0122 | 5292 |
| `delete_txv` | int | 0x7f0a0123 | 5293 |
| `deleteBtn` | int | 0x7f0a011f | 5289 |
| `deltaRelative` | int | 0x7f0a0124 | 5294 |
| `demovideotextView` | int | 0x7f0a0125 | 5295 |
| `dependency_ordering` | int | 0x7f0a0126 | 5296 |
| `design_bottom_sheet` | int | 0x7f0a0127 | 5297 |
| `design_menu_item_action_area` | int | 0x7f0a0128 | 5298 |
| `design_menu_item_action_area_stub` | int | 0x7f0a0129 | 5299 |
| `design_menu_item_text` | int | 0x7f0a012a | 5300 |
| `design_navigation_view` | int | 0x7f0a012b | 5301 |
| `detail` | int | 0x7f0a012c | 5302 |
| `detail_player` | int | 0x7f0a012d | 5303 |
| `device_status` | int | 0x7f0a012e | 5304 |
| `dialog_button` | int | 0x7f0a012f | 5305 |
| `dialog_loading_view` | int | 0x7f0a0130 | 5306 |
| `dimensions` | int | 0x7f0a0131 | 5307 |
| `direct` | int | 0x7f0a0132 | 5308 |
| `disabled` | int | 0x7f0a0137 | 5313 |
| `DISABLED` | int | 0x7f0a0007 | 5009 |
| `disableHome` | int | 0x7f0a0133 | 5309 |
| `disableIntraAutoTransition` | int | 0x7f0a0134 | 5310 |
| `disablePostScroll` | int | 0x7f0a0135 | 5311 |
| `disableScroll` | int | 0x7f0a0136 | 5312 |
| `disconnect_button` | int | 0x7f0a0138 | 5314 |
| `disjoint` | int | 0x7f0a0139 | 5315 |
| `display_always` | int | 0x7f0a013a | 5316 |
| `divider_bottom` | int | 0x7f0a013b | 5317 |
| `divider_top` | int | 0x7f0a013c | 5318 |
| `do_next` | int | 0x7f0a013f | 5321 |
| `do_previous` | int | 0x7f0a0140 | 5322 |
| `doAction` | int | 0x7f0a013d | 5319 |
| `doCapture` | int | 0x7f0a013e | 5320 |
| `done_txv` | int | 0x7f0a0141 | 5323 |
| `download_imv` | int | 0x7f0a0143 | 5325 |
| `download_size` | int | 0x7f0a0144 | 5326 |
| `download_state_layout` | int | 0x7f0a0145 | 5327 |
| `downloaded_txv` | int | 0x7f0a0146 | 5328 |
| `downloadStatus` | int | 0x7f0a0142 | 5324 |
| `dragAnticlockwise` | int | 0x7f0a0147 | 5329 |
| `dragClockwise` | int | 0x7f0a0148 | 5330 |
| `dragDown` | int | 0x7f0a0149 | 5331 |
| `dragEnd` | int | 0x7f0a014a | 5332 |
| `dragLeft` | int | 0x7f0a014b | 5333 |
| `dragRight` | int | 0x7f0a014c | 5334 |
| `dragStart` | int | 0x7f0a014d | 5335 |
| `dragUp` | int | 0x7f0a014e | 5336 |
| `draw_view` | int | 0x7f0a014f | 5337 |
| `dropdown_menu` | int | 0x7f0a0150 | 5338 |
| `duration_image_tip` | int | 0x7f0a0151 | 5339 |
| `duration_progressbar` | int | 0x7f0a0152 | 5340 |
| `easeIn` | int | 0x7f0a0153 | 5341 |
| `easeInOut` | int | 0x7f0a0154 | 5342 |
| `easeOut` | int | 0x7f0a0155 | 5343 |
| `east` | int | 0x7f0a0156 | 5344 |
| `edge` | int | 0x7f0a0157 | 5345 |
| `edit_layout` | int | 0x7f0a0158 | 5346 |
| `edit_query` | int | 0x7f0a0159 | 5347 |
| `edit_text_id` | int | 0x7f0a015a | 5348 |
| `eis_layout` | int | 0x7f0a015b | 5349 |
| `eis_switch` | int | 0x7f0a015c | 5350 |
| `eis_txv` | int | 0x7f0a015d | 5351 |
| `elastic` | int | 0x7f0a015e | 5352 |
| `embed` | int | 0x7f0a015f | 5353 |
| `end` | int | 0x7f0a0160 | 5354 |
| `end_padder` | int | 0x7f0a0162 | 5356 |
| `endToStart` | int | 0x7f0a0161 | 5355 |
| `enterAlways` | int | 0x7f0a0163 | 5357 |
| `enterAlwaysCollapsed` | int | 0x7f0a0164 | 5358 |
| `entireSpace` | int | 0x7f0a0165 | 5359 |
| `escape` | int | 0x7f0a0166 | 5360 |
| `et_content` | int | 0x7f0a0167 | 5361 |
| `et_device_name` | int | 0x7f0a0168 | 5362 |
| `et_device_pwd` | int | 0x7f0a0169 | 5363 |
| `et_device_type` | int | 0x7f0a016a | 5364 |
| `et_device_usage_region` | int | 0x7f0a016b | 5365 |
| `et_email` | int | 0x7f0a016c | 5366 |
| `et_password` | int | 0x7f0a016d | 5367 |
| `et_phone` | int | 0x7f0a016e | 5368 |
| `et_ssid` | int | 0x7f0a016f | 5369 |
| `exit` | int | 0x7f0a0170 | 5370 |
| `exitUntilCollapsed` | int | 0x7f0a0171 | 5371 |
| `exo_ad_overlay` | int | 0x7f0a0172 | 5372 |
| `exo_artwork` | int | 0x7f0a0173 | 5373 |
| `exo_audio_track` | int | 0x7f0a0174 | 5374 |
| `exo_basic_controls` | int | 0x7f0a0175 | 5375 |
| `exo_bottom_bar` | int | 0x7f0a0176 | 5376 |
| `exo_buffering` | int | 0x7f0a0177 | 5377 |
| `exo_center_controls` | int | 0x7f0a0178 | 5378 |
| `exo_check` | int | 0x7f0a0179 | 5379 |
| `exo_content_frame` | int | 0x7f0a017a | 5380 |
| `exo_controller` | int | 0x7f0a017b | 5381 |
| `exo_controller_placeholder` | int | 0x7f0a017c | 5382 |
| `exo_controls_background` | int | 0x7f0a017d | 5383 |
| `exo_duration` | int | 0x7f0a017e | 5384 |
| `exo_error_message` | int | 0x7f0a017f | 5385 |
| `exo_extra_controls` | int | 0x7f0a0180 | 5386 |
| `exo_extra_controls_scroll_view` | int | 0x7f0a0181 | 5387 |
| `exo_ffwd` | int | 0x7f0a0182 | 5388 |
| `exo_ffwd_with_amount` | int | 0x7f0a0183 | 5389 |
| `exo_fullscreen` | int | 0x7f0a0184 | 5390 |
| `exo_fullscreen_button` | int | 0x7f0a0185 | 5391 |
| `exo_icon` | int | 0x7f0a0186 | 5392 |
| `exo_main_text` | int | 0x7f0a0187 | 5393 |
| `exo_minimal_controls` | int | 0x7f0a0188 | 5394 |
| `exo_minimal_fullscreen` | int | 0x7f0a0189 | 5395 |
| `exo_next` | int | 0x7f0a018a | 5396 |
| `exo_overflow_hide` | int | 0x7f0a018b | 5397 |
| `exo_overflow_show` | int | 0x7f0a018c | 5398 |
| `exo_overlay` | int | 0x7f0a018d | 5399 |
| `exo_pause` | int | 0x7f0a018e | 5400 |
| `exo_play` | int | 0x7f0a018f | 5401 |
| `exo_play_pause` | int | 0x7f0a0190 | 5402 |
| `exo_playback_speed` | int | 0x7f0a0191 | 5403 |
| `exo_position` | int | 0x7f0a0192 | 5404 |
| `exo_prev` | int | 0x7f0a0193 | 5405 |
| `exo_progress` | int | 0x7f0a0194 | 5406 |
| `exo_progress_placeholder` | int | 0x7f0a0195 | 5407 |
| `exo_repeat_toggle` | int | 0x7f0a0196 | 5408 |
| `exo_rew` | int | 0x7f0a0197 | 5409 |
| `exo_rew_with_amount` | int | 0x7f0a0198 | 5410 |
| `exo_settings` | int | 0x7f0a0199 | 5411 |
| `exo_settings_listview` | int | 0x7f0a019a | 5412 |
| `exo_shuffle` | int | 0x7f0a019b | 5413 |
| `exo_shutter` | int | 0x7f0a019c | 5414 |
| `exo_sub_text` | int | 0x7f0a019d | 5415 |
| `exo_subtitle` | int | 0x7f0a019e | 5416 |
| `exo_subtitles` | int | 0x7f0a019f | 5417 |
| `exo_text` | int | 0x7f0a01a0 | 5418 |
| `exo_time` | int | 0x7f0a01a1 | 5419 |
| `exo_track_selection_view` | int | 0x7f0a01a2 | 5420 |
| `exo_vr` | int | 0x7f0a01a3 | 5421 |
| `expand_activities_button` | int | 0x7f0a01a4 | 5422 |
| `expanded_menu` | int | 0x7f0a01a5 | 5423 |
| `EXTERNAL_RENDER` | int | 0x7f0a0008 | 5010 |
| `facebook_live_btn` | int | 0x7f0a01a6 | 5424 |
| `fade` | int | 0x7f0a01a7 | 5425 |
| `FBtextView` | int | 0x7f0a0009 | 5011 |
| `file_duration_tv` | int | 0x7f0a01a9 | 5427 |
| `file_list_view` | int | 0x7f0a01aa | 5428 |
| `file_name` | int | 0x7f0a01ab | 5429 |
| `file_time_tv` | int | 0x7f0a01ac | 5430 |
| `file_type_imv` | int | 0x7f0a01ad | 5431 |
| `fileName` | int | 0x7f0a01a8 | 5426 |
| `fill` | int | 0x7f0a01ae | 5432 |
| `fill_horizontal` | int | 0x7f0a01af | 5433 |
| `fill_vertical` | int | 0x7f0a01b0 | 5434 |
| `filled` | int | 0x7f0a01b1 | 5435 |
| `filter_layout` | int | 0x7f0a01b2 | 5436 |
| `filter_reset` | int | 0x7f0a01b3 | 5437 |
| `filter_sure` | int | 0x7f0a01b4 | 5438 |
| `fit` | int | 0x7f0a01b5 | 5439 |
| `fitCenter` | int | 0x7f0a01b6 | 5440 |
| `fitEnd` | int | 0x7f0a01b7 | 5441 |
| `fitStart` | int | 0x7f0a01b8 | 5442 |
| `fitToContents` | int | 0x7f0a01b9 | 5443 |
| `fitXY` | int | 0x7f0a01ba | 5444 |
| `fixed` | int | 0x7f0a01bb | 5445 |
| `fixed_height` | int | 0x7f0a01bc | 5446 |
| `fixed_width` | int | 0x7f0a01bd | 5447 |
| `fl_inner` | int | 0x7f0a01be | 5448 |
| `flip` | int | 0x7f0a01bf | 5449 |
| `floating` | int | 0x7f0a01c0 | 5450 |
| `forever` | int | 0x7f0a01c1 | 5451 |
| `fragment_container_view_tag` | int | 0x7f0a01c2 | 5452 |
| `fromBackground` | int | 0x7f0a01c3 | 5453 |
| `frost` | int | 0x7f0a01c4 | 5454 |
| `full_id` | int | 0x7f0a01c5 | 5455 |
| `fullscreen` | int | 0x7f0a01c6 | 5456 |
| `fullscreen_header` | int | 0x7f0a01c7 | 5457 |
| `FUNCTION` | int | 0x7f0a000a | 5012 |
| `ghost_view` | int | 0x7f0a01c8 | 5458 |
| `ghost_view_holder` | int | 0x7f0a01c9 | 5459 |
| `glide_custom_view_target_tag` | int | 0x7f0a01ca | 5460 |
| `gone` | int | 0x7f0a01cb | 5461 |
| `google_account_btn` | int | 0x7f0a01cc | 5462 |
| `google_icon` | int | 0x7f0a01cd | 5463 |
| `graph` | int | 0x7f0a01ce | 5464 |
| `graph_wrap` | int | 0x7f0a01cf | 5465 |
| `grid` | int | 0x7f0a01d0 | 5466 |
| `GRID` | int | 0x7f0a000b | 5013 |
| `gridview` | int | 0x7f0a01d1 | 5467 |
| `group_divider` | int | 0x7f0a01d2 | 5468 |
| `grouping` | int | 0x7f0a01d3 | 5469 |
| `groups` | int | 0x7f0a01d4 | 5470 |
| `header` | int | 0x7f0a01d5 | 5471 |
| `header_title` | int | 0x7f0a01d6 | 5472 |
| `hidden` | int | 0x7f0a01d7 | 5473 |
| `hide_ime_id` | int | 0x7f0a01d8 | 5474 |
| `hideable` | int | 0x7f0a01d9 | 5475 |
| `home` | int | 0x7f0a01da | 5476 |
| `homeAsUp` | int | 0x7f0a01db | 5477 |
| `honorRequest` | int | 0x7f0a01dc | 5478 |
| `horizontal` | int | 0x7f0a01dd | 5479 |
| `horizontal_only` | int | 0x7f0a01de | 5480 |
| `hour` | int | 0x7f0a01df | 5481 |
| `hwversion_new` | int | 0x7f0a01e0 | 5482 |
| `ib_delete` | int | 0x7f0a01e1 | 5483 |
| `ib_download` | int | 0x7f0a01e2 | 5484 |
| `ib_live` | int | 0x7f0a01e3 | 5485 |
| `ib_photograph` | int | 0x7f0a01e4 | 5486 |
| `ib_shot_cut` | int | 0x7f0a01e5 | 5487 |
| `ib_state_camera` | int | 0x7f0a01e6 | 5488 |
| `ib_state_record` | int | 0x7f0a01e7 | 5489 |
| `ib_video_zoom` | int | 0x7f0a01e8 | 5490 |
| `ib_video_zoom_in` | int | 0x7f0a01e9 | 5491 |
| `ib_video_zoom_out` | int | 0x7f0a01ea | 5492 |
| `icon` | int | 0x7f0a01eb | 5493 |
| `icon_group` | int | 0x7f0a01ec | 5494 |
| `icon_only` | int | 0x7f0a01ed | 5495 |
| `ifRoom` | int | 0x7f0a01ee | 5496 |
| `ignore` | int | 0x7f0a01ef | 5497 |
| `ignoreRequest` | int | 0x7f0a01f0 | 5498 |
| `image` | int | 0x7f0a01f1 | 5499 |
| `image_size_layout` | int | 0x7f0a01f4 | 5502 |
| `image_size_setting_txv` | int | 0x7f0a01f5 | 5503 |
| `image_size_txv` | int | 0x7f0a01f6 | 5504 |
| `imageProgressView` | int | 0x7f0a01f2 | 5500 |
| `imageView` | int | 0x7f0a01f3 | 5501 |
| `immediateStop` | int | 0x7f0a01f7 | 5505 |
| `imv` | int | 0x7f0a01f8 | 5506 |
| `included` | int | 0x7f0a01f9 | 5507 |
| `indeterminate` | int | 0x7f0a01fa | 5508 |
| `info` | int | 0x7f0a01fb | 5509 |
| `info_layout` | int | 0x7f0a01fc | 5510 |
| `info_selected_num` | int | 0x7f0a01fd | 5511 |
| `inline` | int | 0x7f0a01fe | 5512 |
| `invisible` | int | 0x7f0a01ff | 5513 |
| `inward` | int | 0x7f0a0200 | 5514 |
| `ip_address` | int | 0x7f0a0201 | 5515 |
| `ip_txv` | int | 0x7f0a0202 | 5516 |
| `is_panorama` | int | 0x7f0a0203 | 5517 |
| `is_pooling_container_tag` | int | 0x7f0a0204 | 5518 |
| `italic` | int | 0x7f0a0205 | 5519 |
| `item_layout` | int | 0x7f0a0206 | 5520 |
| `item_name` | int | 0x7f0a0207 | 5521 |
| `item_text` | int | 0x7f0a0208 | 5522 |
| `item_touch_helper_previous_elevation` | int | 0x7f0a0209 | 5523 |
| `item_value` | int | 0x7f0a020a | 5524 |
| `iv_album_content_button` | int | 0x7f0a020b | 5525 |
| `iv_album_content_image` | int | 0x7f0a020c | 5526 |
| `iv_arrow_right` | int | 0x7f0a020d | 5527 |
| `iv_back` | int | 0x7f0a020e | 5528 |
| `iv_battery_state` | int | 0x7f0a020f | 5529 |
| `iv_connect_course_page` | int | 0x7f0a0210 | 5530 |
| `iv_download` | int | 0x7f0a0211 | 5531 |
| `iv_gallery_preview_image` | int | 0x7f0a0212 | 5532 |
| `iv_hint` | int | 0x7f0a0213 | 5533 |
| `iv_right_arrow` | int | 0x7f0a0214 | 5534 |
| `iv_select` | int | 0x7f0a0215 | 5535 |
| `iv_setting` | int | 0x7f0a0216 | 5536 |
| `iv_state_camera` | int | 0x7f0a0217 | 5537 |
| `iv_state_record` | int | 0x7f0a0218 | 5538 |
| `iv_video_file` | int | 0x7f0a0219 | 5539 |
| `iv_watermark` | int | 0x7f0a021a | 5540 |
| `jump_ad` | int | 0x7f0a021d | 5543 |
| `jumpToEnd` | int | 0x7f0a021b | 5541 |
| `jumpToStart` | int | 0x7f0a021c | 5542 |
| `jz_video` | int | 0x7f0a021e | 5544 |
| `labeled` | int | 0x7f0a021f | 5545 |
| `large` | int | 0x7f0a0220 | 5546 |
| `last_preview_time` | int | 0x7f0a0221 | 5547 |
| `launch_setting_frame` | int | 0x7f0a0222 | 5548 |
| `launch_view` | int | 0x7f0a0223 | 5549 |
| `layout` | int | 0x7f0a0224 | 5550 |
| `layout_bottom` | int | 0x7f0a0226 | 5552 |
| `layout_layer` | int | 0x7f0a0227 | 5553 |
| `layout_loading` | int | 0x7f0a0228 | 5554 |
| `layout_progress_wheel` | int | 0x7f0a0229 | 5555 |
| `layout_top` | int | 0x7f0a022a | 5556 |
| `layout01` | int | 0x7f0a0225 | 5551 |
| `left` | int | 0x7f0a022b | 5557 |
| `left_icon` | int | 0x7f0a022d | 5559 |
| `leftToRight` | int | 0x7f0a022c | 5558 |
| `legacy` | int | 0x7f0a022e | 5560 |
| `light` | int | 0x7f0a022f | 5561 |
| `line1` | int | 0x7f0a0230 | 5562 |
| `line3` | int | 0x7f0a0231 | 5563 |
| `linear` | int | 0x7f0a0232 | 5564 |
| `liner` | int | 0x7f0a0233 | 5565 |
| `LIST` | int | 0x7f0a000c | 5014 |
| `list_item` | int | 0x7f0a0235 | 5567 |
| `list_view` | int | 0x7f0a0236 | 5568 |
| `listMode` | int | 0x7f0a0234 | 5566 |
| `live_layout` | int | 0x7f0a0237 | 5569 |
| `ll_about_app` | int | 0x7f0a0238 | 5570 |
| `ll_bottom_but` | int | 0x7f0a0239 | 5571 |
| `ll_change_device_info` | int | 0x7f0a023a | 5572 |
| `ll_chinese_s` | int | 0x7f0a023b | 5573 |
| `ll_chinese_t` | int | 0x7f0a023c | 5574 |
| `ll_connect_course` | int | 0x7f0a023d | 5575 |
| `ll_download_firmware` | int | 0x7f0a023e | 5576 |
| `ll_end` | int | 0x7f0a023f | 5577 |
| `ll_english` | int | 0x7f0a0240 | 5578 |
| `ll_feedback` | int | 0x7f0a0241 | 5579 |
| `ll_file_option` | int | 0x7f0a0242 | 5580 |
| `ll_hint` | int | 0x7f0a0243 | 5581 |
| `ll_japanese` | int | 0x7f0a0244 | 5582 |
| `ll_korean` | int | 0x7f0a0245 | 5583 |
| `ll_language` | int | 0x7f0a0246 | 5584 |
| `ll_middle_btn` | int | 0x7f0a0247 | 5585 |
| `ll_resolution_fps` | int | 0x7f0a0248 | 5586 |
| `ll_shot_cut` | int | 0x7f0a0249 | 5587 |
| `ll_software_protocol` | int | 0x7f0a024a | 5588 |
| `ll_state_camera` | int | 0x7f0a024b | 5589 |
| `ll_state_record` | int | 0x7f0a024c | 5590 |
| `ll_thai` | int | 0x7f0a024d | 5591 |
| `ll_title` | int | 0x7f0a024e | 5592 |
| `ll_wait_upload` | int | 0x7f0a024f | 5593 |
| `ll_watermark` | int | 0x7f0a0250 | 5594 |
| `ll_web_view` | int | 0x7f0a0251 | 5595 |
| `loading` | int | 0x7f0a0252 | 5596 |
| `local_pb_back` | int | 0x7f0a0253 | 5597 |
| `local_pb_bottom_layout` | int | 0x7f0a0254 | 5598 |
| `local_pb_photo_name` | int | 0x7f0a0255 | 5599 |
| `local_pb_play_btn` | int | 0x7f0a0256 | 5600 |
| `local_pb_seekBar` | int | 0x7f0a0257 | 5601 |
| `local_pb_spinner` | int | 0x7f0a0258 | 5602 |
| `local_pb_time_duration` | int | 0x7f0a0259 | 5603 |
| `local_pb_time_lapsed` | int | 0x7f0a025a | 5604 |
| `local_pb_top_layout` | int | 0x7f0a025b | 5605 |
| `local_pb_video_name` | int | 0x7f0a025c | 5606 |
| `local_pb_view` | int | 0x7f0a025d | 5607 |
| `local_photo` | int | 0x7f0a025e | 5608 |
| `local_photo_date` | int | 0x7f0a025f | 5609 |
| `local_photo_inside_panorama` | int | 0x7f0a0260 | 5610 |
| `local_photo_name` | int | 0x7f0a0261 | 5611 |
| `local_photo_outside_panorama` | int | 0x7f0a0262 | 5612 |
| `local_photo_pb_delete` | int | 0x7f0a0263 | 5613 |
| `local_photo_pb_info` | int | 0x7f0a0264 | 5614 |
| `local_photo_pb_share` | int | 0x7f0a0265 | 5615 |
| `local_photo_size` | int | 0x7f0a0266 | 5616 |
| `local_photo_thumbnail_list` | int | 0x7f0a0267 | 5617 |
| `local_photo_wall_grid_edit` | int | 0x7f0a0268 | 5618 |
| `local_photo_wall_grid_item` | int | 0x7f0a0269 | 5619 |
| `local_photo_wall_grid_view` | int | 0x7f0a026a | 5620 |
| `local_photo_wall_header_layout` | int | 0x7f0a026b | 5621 |
| `local_photo_wall_list_edit` | int | 0x7f0a026c | 5622 |
| `local_photo_wall_list_layout` | int | 0x7f0a026d | 5623 |
| `local_photo_wall_list_view` | int | 0x7f0a026e | 5624 |
| `local_video` | int | 0x7f0a026f | 5625 |
| `local_video_date` | int | 0x7f0a0270 | 5626 |
| `local_video_duration` | int | 0x7f0a0271 | 5627 |
| `local_video_name` | int | 0x7f0a0272 | 5628 |
| `local_video_size` | int | 0x7f0a0273 | 5629 |
| `local_video_thumbnail_grid` | int | 0x7f0a0274 | 5630 |
| `local_video_thumbnail_list` | int | 0x7f0a0275 | 5631 |
| `local_video_wall_grid_edit` | int | 0x7f0a0276 | 5632 |
| `local_video_wall_header_layout` | int | 0x7f0a0277 | 5633 |
| `local_video_wall_list_edit` | int | 0x7f0a0278 | 5634 |
| `lock_screen` | int | 0x7f0a0279 | 5635 |
| `login_button` | int | 0x7f0a027a | 5636 |
| `m_surfaceView` | int | 0x7f0a027c | 5638 |
| `m3_side_sheet` | int | 0x7f0a027b | 5637 |
| `main_layout` | int | 0x7f0a027d | 5639 |
| `manualOnly` | int | 0x7f0a027e | 5640 |
| `marquee` | int | 0x7f0a027f | 5641 |
| `masked` | int | 0x7f0a0280 | 5642 |
| `match_constraint` | int | 0x7f0a0281 | 5643 |
| `match_parent` | int | 0x7f0a0282 | 5644 |
| `material_clock_display` | int | 0x7f0a0283 | 5645 |
| `material_clock_display_and_toggle` | int | 0x7f0a0284 | 5646 |
| `material_clock_face` | int | 0x7f0a0285 | 5647 |
| `material_clock_hand` | int | 0x7f0a0286 | 5648 |
| `material_clock_level` | int | 0x7f0a0287 | 5649 |
| `material_clock_period_am_button` | int | 0x7f0a0288 | 5650 |
| `material_clock_period_pm_button` | int | 0x7f0a0289 | 5651 |
| `material_clock_period_toggle` | int | 0x7f0a028a | 5652 |
| `material_hour_text_input` | int | 0x7f0a028b | 5653 |
| `material_hour_tv` | int | 0x7f0a028c | 5654 |
| `material_label` | int | 0x7f0a028d | 5655 |
| `material_minute_text_input` | int | 0x7f0a028e | 5656 |
| `material_minute_tv` | int | 0x7f0a028f | 5657 |
| `material_textinput_timepicker` | int | 0x7f0a0290 | 5658 |
| `material_timepicker_cancel_button` | int | 0x7f0a0291 | 5659 |
| `material_timepicker_container` | int | 0x7f0a0292 | 5660 |
| `material_timepicker_mode_button` | int | 0x7f0a0293 | 5661 |
| `material_timepicker_ok_button` | int | 0x7f0a0294 | 5662 |
| `material_timepicker_view` | int | 0x7f0a0295 | 5663 |
| `material_value_index` | int | 0x7f0a0296 | 5664 |
| `matrix` | int | 0x7f0a0297 | 5665 |
| `max_time_edt` | int | 0x7f0a0298 | 5666 |
| `media_actions` | int | 0x7f0a0299 | 5667 |
| `media_bottom_layout` | int | 0x7f0a029a | 5668 |
| `media_camera_preview_loading` | int | 0x7f0a029b | 5669 |
| `media_camera_pv_image` | int | 0x7f0a029c | 5670 |
| `media_connect_loading_bar` | int | 0x7f0a029d | 5671 |
| `media_connect_loading_layout` | int | 0x7f0a029e | 5672 |
| `media_connect_loading_txt` | int | 0x7f0a029f | 5673 |
| `media_controller_compat_view_tag` | int | 0x7f0a02a0 | 5674 |
| `media_file_size_tv` | int | 0x7f0a02a1 | 5675 |
| `media_fullscreen_imgbtn` | int | 0x7f0a02a2 | 5676 |
| `media_last_preview_time` | int | 0x7f0a02a3 | 5677 |
| `media_pb_seekBar` | int | 0x7f0a02a4 | 5678 |
| `media_pb_spinner` | int | 0x7f0a02a5 | 5679 |
| `media_pb_time_duration` | int | 0x7f0a02a6 | 5680 |
| `media_pb_time_lapsed` | int | 0x7f0a02a7 | 5681 |
| `media_play_bottom_layout` | int | 0x7f0a02a8 | 5682 |
| `media_play_imgbtn` | int | 0x7f0a02a9 | 5683 |
| `media_play_imgv` | int | 0x7f0a02aa | 5684 |
| `media_scale_txt` | int | 0x7f0a02ab | 5685 |
| `media_stop_btn` | int | 0x7f0a02ac | 5686 |
| `media_thumbnail` | int | 0x7f0a02ad | 5687 |
| `media_thumbnail_layout` | int | 0x7f0a02ae | 5688 |
| `media_top_bar_back` | int | 0x7f0a02af | 5689 |
| `media_top_bar_delete` | int | 0x7f0a02b0 | 5690 |
| `media_top_bar_download` | int | 0x7f0a02b1 | 5691 |
| `media_top_bar_layout` | int | 0x7f0a02b2 | 5692 |
| `media_top_bar_more` | int | 0x7f0a02b3 | 5693 |
| `media_top_bar_title` | int | 0x7f0a02b4 | 5694 |
| `media_txv_container` | int | 0x7f0a02b5 | 5695 |
| `menu_multi_pb_filter` | int | 0x7f0a02b6 | 5696 |
| `menu_multi_pb_preview_type` | int | 0x7f0a02b7 | 5697 |
| `menu_photo_wall_type` | int | 0x7f0a02b8 | 5698 |
| `menu_video_wall_type` | int | 0x7f0a02b9 | 5699 |
| `message` | int | 0x7f0a02ba | 5700 |
| `message_btn` | int | 0x7f0a02bb | 5701 |
| `message_layout` | int | 0x7f0a02bc | 5702 |
| `message_new` | int | 0x7f0a02bd | 5703 |
| `message_text` | int | 0x7f0a02be | 5704 |
| `messenger_send_button` | int | 0x7f0a02bf | 5705 |
| `META` | int | 0x7f0a000d | 5015 |
| `middle` | int | 0x7f0a02c0 | 5706 |
| `min` | int | 0x7f0a02c1 | 5707 |
| `min_time_edt` | int | 0x7f0a02c2 | 5708 |
| `mini` | int | 0x7f0a02c3 | 5709 |
| `month` | int | 0x7f0a02c4 | 5710 |
| `month_grid` | int | 0x7f0a02c5 | 5711 |
| `month_navigation_bar` | int | 0x7f0a02c6 | 5712 |
| `month_navigation_fragment_toggle` | int | 0x7f0a02c7 | 5713 |
| `month_navigation_next` | int | 0x7f0a02c8 | 5714 |
| `month_navigation_previous` | int | 0x7f0a02c9 | 5715 |
| `month_title` | int | 0x7f0a02ca | 5716 |
| `more_btn` | int | 0x7f0a02cb | 5717 |
| `more_setting_layout` | int | 0x7f0a02cc | 5718 |
| `motion_base` | int | 0x7f0a02cd | 5719 |
| `mtrl_calendar_day_selector_frame` | int | 0x7f0a02ce | 5720 |
| `mtrl_calendar_days_of_week` | int | 0x7f0a02cf | 5721 |
| `mtrl_calendar_frame` | int | 0x7f0a02d0 | 5722 |
| `mtrl_calendar_main_pane` | int | 0x7f0a02d1 | 5723 |
| `mtrl_calendar_months` | int | 0x7f0a02d2 | 5724 |
| `mtrl_calendar_selection_frame` | int | 0x7f0a02d3 | 5725 |
| `mtrl_calendar_text_input_frame` | int | 0x7f0a02d4 | 5726 |
| `mtrl_calendar_year_selector_frame` | int | 0x7f0a02d5 | 5727 |
| `mtrl_card_checked_layer_id` | int | 0x7f0a02d6 | 5728 |
| `mtrl_child_content_container` | int | 0x7f0a02d7 | 5729 |
| `mtrl_internal_children_alpha_tag` | int | 0x7f0a02d8 | 5730 |
| `mtrl_motion_snapshot_view` | int | 0x7f0a02d9 | 5731 |
| `mtrl_picker_fullscreen` | int | 0x7f0a02da | 5732 |
| `mtrl_picker_header` | int | 0x7f0a02db | 5733 |
| `mtrl_picker_header_selection_text` | int | 0x7f0a02dc | 5734 |
| `mtrl_picker_header_title_and_selection` | int | 0x7f0a02dd | 5735 |
| `mtrl_picker_header_toggle` | int | 0x7f0a02de | 5736 |
| `mtrl_picker_text_input_date` | int | 0x7f0a02df | 5737 |
| `mtrl_picker_text_input_range_end` | int | 0x7f0a02e0 | 5738 |
| `mtrl_picker_text_input_range_start` | int | 0x7f0a02e1 | 5739 |
| `mtrl_picker_title_text` | int | 0x7f0a02e2 | 5740 |
| `mtrl_view_tag_bottom_padding` | int | 0x7f0a02e3 | 5741 |
| `multi_pb` | int | 0x7f0a02e4 | 5742 |
| `multi_pb_photo_grid_view` | int | 0x7f0a02e5 | 5743 |
| `multi_pb_photo_list_layout` | int | 0x7f0a02e6 | 5744 |
| `multi_pb_photo_list_view` | int | 0x7f0a02e7 | 5745 |
| `multi_pb_video_grid_view` | int | 0x7f0a02e8 | 5746 |
| `multi_pb_video_list_layout` | int | 0x7f0a02e9 | 5747 |
| `multi_pb_video_list_view` | int | 0x7f0a02ea | 5748 |
| `multiply` | int | 0x7f0a02eb | 5749 |
| `myExoPlayer` | int | 0x7f0a02ec | 5750 |
| `name_txv` | int | 0x7f0a02ed | 5751 |
| `navigation_bar_item_active_indicator_view` | int | 0x7f0a02ee | 5752 |
| `navigation_bar_item_content_container` | int | 0x7f0a02ef | 5753 |
| `navigation_bar_item_icon_container` | int | 0x7f0a02f0 | 5754 |
| `navigation_bar_item_icon_view` | int | 0x7f0a02f1 | 5755 |
| `navigation_bar_item_inner_content_container` | int | 0x7f0a02f2 | 5756 |
| `navigation_bar_item_labels_group` | int | 0x7f0a02f3 | 5757 |
| `navigation_bar_item_large_label_view` | int | 0x7f0a02f4 | 5758 |
| `navigation_bar_item_small_label_view` | int | 0x7f0a02f5 | 5759 |
| `navigation_header_container` | int | 0x7f0a02f6 | 5760 |
| `navigation_menu_subheader_label` | int | 0x7f0a02f7 | 5761 |
| `never` | int | 0x7f0a02f8 | 5762 |
| `never_display` | int | 0x7f0a02fb | 5765 |
| `neverCompleteToEnd` | int | 0x7f0a02f9 | 5763 |
| `neverCompleteToStart` | int | 0x7f0a02fa | 5764 |
| `no_content_txv` | int | 0x7f0a02fe | 5768 |
| `NO_DEBUG` | int | 0x7f0a000e | 5016 |
| `no_local_photos` | int | 0x7f0a02ff | 5769 |
| `no_local_videos` | int | 0x7f0a0300 | 5770 |
| `none` | int | 0x7f0a0301 | 5771 |
| `normal` | int | 0x7f0a0302 | 5772 |
| `north` | int | 0x7f0a0303 | 5773 |
| `noScroll` | int | 0x7f0a02fc | 5766 |
| `noState` | int | 0x7f0a02fd | 5767 |
| `not_support_preview_txv` | int | 0x7f0a0304 | 5774 |
| `notification_background` | int | 0x7f0a0305 | 5775 |
| `notification_main_column` | int | 0x7f0a0306 | 5776 |
| `notification_main_column_container` | int | 0x7f0a0307 | 5777 |
| `numberbar` | int | 0x7f0a0308 | 5778 |
| `off` | int | 0x7f0a0309 | 5779 |
| `on` | int | 0x7f0a030a | 5780 |
| `one` | int | 0x7f0a030c | 5782 |
| `onInterceptTouchReturnSwipe` | int | 0x7f0a030b | 5781 |
| `open_graph` | int | 0x7f0a030d | 5783 |
| `open_search_bar_placeholder_text_view` | int | 0x7f0a030e | 5784 |
| `open_search_bar_text_view` | int | 0x7f0a030f | 5785 |
| `open_search_bar_text_view_container` | int | 0x7f0a0310 | 5786 |
| `open_search_view_background` | int | 0x7f0a0311 | 5787 |
| `open_search_view_clear_button` | int | 0x7f0a0312 | 5788 |
| `open_search_view_content_container` | int | 0x7f0a0313 | 5789 |
| `open_search_view_divider` | int | 0x7f0a0314 | 5790 |
| `open_search_view_dummy_toolbar` | int | 0x7f0a0315 | 5791 |
| `open_search_view_edit_text` | int | 0x7f0a0316 | 5792 |
| `open_search_view_header_container` | int | 0x7f0a0317 | 5793 |
| `open_search_view_root` | int | 0x7f0a0318 | 5794 |
| `open_search_view_scrim` | int | 0x7f0a0319 | 5795 |
| `open_search_view_search_prefix` | int | 0x7f0a031a | 5796 |
| `open_search_view_status_bar_spacer` | int | 0x7f0a031b | 5797 |
| `open_search_view_text_container` | int | 0x7f0a031c | 5798 |
| `open_search_view_toolbar` | int | 0x7f0a031d | 5799 |
| `open_search_view_toolbar_container` | int | 0x7f0a031e | 5800 |
| `options1` | int | 0x7f0a031f | 5801 |
| `options2` | int | 0x7f0a0320 | 5802 |
| `options3` | int | 0x7f0a0321 | 5803 |
| `optionspicker` | int | 0x7f0a0322 | 5804 |
| `outline` | int | 0x7f0a0323 | 5805 |
| `outmost_container` | int | 0x7f0a0324 | 5806 |
| `outward` | int | 0x7f0a0325 | 5807 |
| `overshoot` | int | 0x7f0a0326 | 5808 |
| `packed` | int | 0x7f0a0327 | 5809 |
| `page` | int | 0x7f0a0328 | 5810 |
| `panorama_flag` | int | 0x7f0a0329 | 5811 |
| `panorama_type_btn` | int | 0x7f0a032a | 5812 |
| `parallax` | int | 0x7f0a032b | 5813 |
| `parent` | int | 0x7f0a032c | 5814 |
| `parent_matrix` | int | 0x7f0a032f | 5817 |
| `parentPanel` | int | 0x7f0a032d | 5815 |
| `parentRelative` | int | 0x7f0a032e | 5816 |
| `password` | int | 0x7f0a0330 | 5818 |
| `password_toggle` | int | 0x7f0a0331 | 5819 |
| `path` | int | 0x7f0a0332 | 5820 |
| `pathRelative` | int | 0x7f0a0333 | 5821 |
| `pb_back` | int | 0x7f0a0334 | 5822 |
| `pb_bottom_layout` | int | 0x7f0a0335 | 5823 |
| `pb_index_info` | int | 0x7f0a0336 | 5824 |
| `pb_load` | int | 0x7f0a0337 | 5825 |
| `pb_loading` | int | 0x7f0a0338 | 5826 |
| `pb_progress` | int | 0x7f0a0339 | 5827 |
| `pb_top_layout` | int | 0x7f0a033a | 5828 |
| `peekHeight` | int | 0x7f0a033b | 5829 |
| `percent` | int | 0x7f0a033c | 5830 |
| `photo` | int | 0x7f0a033d | 5831 |
| `photo_pb_delete` | int | 0x7f0a033e | 5832 |
| `photo_pb_download` | int | 0x7f0a033f | 5833 |
| `photo_pb_share` | int | 0x7f0a0340 | 5834 |
| `photo_surfaceView` | int | 0x7f0a0341 | 5835 |
| `photo_wall_grid_edit` | int | 0x7f0a0342 | 5836 |
| `photo_wall_header` | int | 0x7f0a0343 | 5837 |
| `photo_wall_list_edit` | int | 0x7f0a0344 | 5838 |
| `pin` | int | 0x7f0a0345 | 5839 |
| `play_btn` | int | 0x7f0a0346 | 5840 |
| `pooling_container_listener_holder_tag` | int | 0x7f0a0347 | 5841 |
| `position` | int | 0x7f0a0348 | 5842 |
| `poster` | int | 0x7f0a034a | 5844 |
| `postLayout` | int | 0x7f0a0349 | 5843 |
| `pressed` | int | 0x7f0a034b | 5845 |
| `preview` | int | 0x7f0a034c | 5846 |
| `preview_client_count_txv` | int | 0x7f0a034d | 5847 |
| `preview_container` | int | 0x7f0a034e | 5848 |
| `preview_controller` | int | 0x7f0a034f | 5849 |
| `preview_fullscreen_switch` | int | 0x7f0a0350 | 5850 |
| `preview_layout` | int | 0x7f0a0351 | 5851 |
| `preview_player_view` | int | 0x7f0a0352 | 5852 |
| `preview_render_view` | int | 0x7f0a0353 | 5853 |
| `preview_size_txv` | int | 0x7f0a0354 | 5854 |
| `preview_video_bitrate_txv` | int | 0x7f0a0355 | 5855 |
| `preview_view` | int | 0x7f0a0356 | 5856 |
| `progress` | int | 0x7f0a0357 | 5857 |
| `progress_bar` | int | 0x7f0a035b | 5861 |
| `progress_circular` | int | 0x7f0a035c | 5862 |
| `progress_horizontal` | int | 0x7f0a035d | 5863 |
| `progress_wheel` | int | 0x7f0a035e | 5864 |
| `progressBar` | int | 0x7f0a0358 | 5858 |
| `progressBar1` | int | 0x7f0a0359 | 5859 |
| `progressText` | int | 0x7f0a035a | 5860 |
| `PULL_FROM_END` | int | 0x7f0a000f | 5017 |
| `PULL_FROM_START` | int | 0x7f0a0010 | 5018 |
| `pull_to_refresh_image` | int | 0x7f0a0363 | 5869 |
| `pull_to_refresh_progress` | int | 0x7f0a0364 | 5870 |
| `pull_to_refresh_sub_text` | int | 0x7f0a0365 | 5871 |
| `pull_to_refresh_text` | int | 0x7f0a0366 | 5872 |
| `pullDownFromTop` | int | 0x7f0a035f | 5865 |
| `pullFromEnd` | int | 0x7f0a0360 | 5866 |
| `pullFromStart` | int | 0x7f0a0361 | 5867 |
| `pullUpFromBottom` | int | 0x7f0a0362 | 5868 |
| `pv_mode` | int | 0x7f0a0367 | 5873 |
| `pw_load_more` | int | 0x7f0a0368 | 5874 |
| `pw_spinner` | int | 0x7f0a0369 | 5875 |
| `quick_liner` | int | 0x7f0a036a | 5876 |
| `QUICK_LIST` | int | 0x7f0a0011 | 5019 |
| `radio` | int | 0x7f0a036b | 5877 |
| `ratio` | int | 0x7f0a036c | 5878 |
| `rb_gallery_preview_check` | int | 0x7f0a036d | 5879 |
| `rd_no` | int | 0x7f0a036e | 5880 |
| `rd_wpa` | int | 0x7f0a036f | 5881 |
| `rd_wpa2` | int | 0x7f0a0370 | 5882 |
| `recording_time` | int | 0x7f0a0371 | 5883 |
| `rectangles` | int | 0x7f0a0372 | 5884 |
| `recycler_view` | int | 0x7f0a0373 | 5885 |
| `refresh_btn` | int | 0x7f0a0374 | 5886 |
| `refresh_token_button` | int | 0x7f0a0375 | 5887 |
| `relativeLayout1` | int | 0x7f0a0376 | 5888 |
| `remain_capture_count_text` | int | 0x7f0a0377 | 5889 |
| `remain_recording_time_text` | int | 0x7f0a0378 | 5890 |
| `render_fl` | int | 0x7f0a0379 | 5891 |
| `replay_text` | int | 0x7f0a037a | 5892 |
| `report_drawn` | int | 0x7f0a037b | 5893 |
| `retreat` | int | 0x7f0a037c | 5894 |
| `retry_btn` | int | 0x7f0a037d | 5895 |
| `retry_layout` | int | 0x7f0a037e | 5896 |
| `reverseSawtooth` | int | 0x7f0a037f | 5897 |
| `rg_security` | int | 0x7f0a0380 | 5898 |
| `right` | int | 0x7f0a0381 | 5899 |
| `right_icon` | int | 0x7f0a0383 | 5901 |
| `right_icon_imv` | int | 0x7f0a0384 | 5902 |
| `right_side` | int | 0x7f0a0385 | 5903 |
| `right_switch` | int | 0x7f0a0386 | 5904 |
| `right_text_txv` | int | 0x7f0a0387 | 5905 |
| `rightToLeft` | int | 0x7f0a0382 | 5900 |
| `rl_local_photo` | int | 0x7f0a0388 | 5906 |
| `rl_local_video` | int | 0x7f0a0389 | 5907 |
| `root_layout` | int | 0x7f0a038a | 5908 |
| `rotate` | int | 0x7f0a038b | 5909 |
| `rounded` | int | 0x7f0a038c | 5910 |
| `row_index_key` | int | 0x7f0a038d | 5911 |
| `rv_content_list` | int | 0x7f0a038e | 5912 |
| `rv_firmwares` | int | 0x7f0a038f | 5913 |
| `rv_remote_files` | int | 0x7f0a0390 | 5914 |
| `rv_settings` | int | 0x7f0a0391 | 5915 |
| `rv_topbar` | int | 0x7f0a0392 | 5916 |
| `save` | int | 0x7f0a0393 | 5917 |
| `save_non_transition_alpha` | int | 0x7f0a0394 | 5918 |
| `save_overlay_view` | int | 0x7f0a0395 | 5919 |
| `sawtooth` | int | 0x7f0a0396 | 5920 |
| `scale` | int | 0x7f0a0397 | 5921 |
| `screen` | int | 0x7f0a0398 | 5922 |
| `scroll` | int | 0x7f0a0399 | 5923 |
| `scrollable` | int | 0x7f0a039d | 5927 |
| `scrollIndicatorDown` | int | 0x7f0a039a | 5924 |
| `scrollIndicatorUp` | int | 0x7f0a039b | 5925 |
| `scrollview` | int | 0x7f0a039e | 5928 |
| `scrollView` | int | 0x7f0a039c | 5926 |
| `SDK_RENDER` | int | 0x7f0a0012 | 5020 |
| `search_badge` | int | 0x7f0a039f | 5929 |
| `search_bar` | int | 0x7f0a03a0 | 5930 |
| `search_button` | int | 0x7f0a03a1 | 5931 |
| `search_close_btn` | int | 0x7f0a03a2 | 5932 |
| `search_edit_frame` | int | 0x7f0a03a3 | 5933 |
| `search_go_btn` | int | 0x7f0a03a4 | 5934 |
| `search_mag_icon` | int | 0x7f0a03a5 | 5935 |
| `search_plate` | int | 0x7f0a03a6 | 5936 |
| `search_src_text` | int | 0x7f0a03a7 | 5937 |
| `search_voice_btn` | int | 0x7f0a03a8 | 5938 |
| `second` | int | 0x7f0a03a9 | 5939 |
| `select_dialog_listview` | int | 0x7f0a03aa | 5940 |
| `selected` | int | 0x7f0a03ab | 5941 |
| `selection_type` | int | 0x7f0a03ac | 5942 |
| `sensors_type_txv` | int | 0x7f0a03ad | 5943 |
| `separator1` | int | 0x7f0a03ae | 5944 |
| `separator2` | int | 0x7f0a03af | 5945 |
| `setting_imv` | int | 0x7f0a03b0 | 5946 |
| `setting_layout` | int | 0x7f0a03b1 | 5947 |
| `setting_listView` | int | 0x7f0a03b2 | 5948 |
| `setupMainMenu` | int | 0x7f0a03b3 | 5949 |
| `share_imv` | int | 0x7f0a03b5 | 5951 |
| `share_layout` | int | 0x7f0a03b6 | 5952 |
| `shareBtn` | int | 0x7f0a03b4 | 5950 |
| `shared_url` | int | 0x7f0a03b9 | 5955 |
| `shared_url_qrcode` | int | 0x7f0a03ba | 5956 |
| `sharedValueSet` | int | 0x7f0a03b7 | 5953 |
| `sharedValueUnset` | int | 0x7f0a03b8 | 5954 |
| `SHIFT` | int | 0x7f0a0013 | 5021 |
| `shortcut` | int | 0x7f0a03bb | 5957 |
| `SHOW_ALL` | int | 0x7f0a0014 | 5022 |
| `SHOW_PATH` | int | 0x7f0a0015 | 5023 |
| `SHOW_PROGRESS` | int | 0x7f0a0016 | 5024 |
| `showCustom` | int | 0x7f0a03bc | 5958 |
| `showHome` | int | 0x7f0a03bd | 5959 |
| `showTitle` | int | 0x7f0a03be | 5960 |
| `sign_in_button` | int | 0x7f0a03bf | 5961 |
| `sign_out_and_disconnect` | int | 0x7f0a03c0 | 5962 |
| `sign_out_button` | int | 0x7f0a03c1 | 5963 |
| `sin` | int | 0x7f0a03c2 | 5964 |
| `skip_txv` | int | 0x7f0a03c4 | 5966 |
| `skipCollapsed` | int | 0x7f0a03c3 | 5965 |
| `skipped` | int | 0x7f0a03c5 | 5967 |
| `slide` | int | 0x7f0a03c6 | 5968 |
| `slot_add_camera` | int | 0x7f0a03c8 | 5970 |
| `slot_camera_name` | int | 0x7f0a03c9 | 5971 |
| `slot_connect_sign` | int | 0x7f0a03ca | 5972 |
| `slot_connect_state` | int | 0x7f0a03cb | 5973 |
| `slot_layout` | int | 0x7f0a03cc | 5974 |
| `slot_layout_add` | int | 0x7f0a03cd | 5975 |
| `slotPhoto` | int | 0x7f0a03c7 | 5969 |
| `slow_motion` | int | 0x7f0a03ce | 5976 |
| `small` | int | 0x7f0a03cf | 5977 |
| `small_close` | int | 0x7f0a03d0 | 5978 |
| `small_id` | int | 0x7f0a03d1 | 5979 |
| `snackbar_action` | int | 0x7f0a03d2 | 5980 |
| `snackbar_text` | int | 0x7f0a03d3 | 5981 |
| `snap` | int | 0x7f0a03d4 | 5982 |
| `snapMargins` | int | 0x7f0a03d5 | 5983 |
| `south` | int | 0x7f0a03d6 | 5984 |
| `spacer` | int | 0x7f0a03d7 | 5985 |
| `special_effects_controller_view_tag` | int | 0x7f0a03d8 | 5986 |
| `spherical_gl_surface_view` | int | 0x7f0a03d9 | 5987 |
| `spline` | int | 0x7f0a03da | 5988 |
| `split_action_bar` | int | 0x7f0a03db | 5989 |
| `spread` | int | 0x7f0a03dc | 5990 |
| `spread_inside` | int | 0x7f0a03dd | 5991 |
| `spring` | int | 0x7f0a03de | 5992 |
| `square` | int | 0x7f0a03df | 5993 |
| `src_atop` | int | 0x7f0a03e0 | 5994 |
| `src_in` | int | 0x7f0a03e1 | 5995 |
| `src_over` | int | 0x7f0a03e2 | 5996 |
| `standard` | int | 0x7f0a03e3 | 5997 |
| `start` | int | 0x7f0a03e4 | 5998 |
| `start_center` | int | 0x7f0a03e8 | 6002 |
| `start_layout` | int | 0x7f0a03e9 | 6003 |
| `start_pv` | int | 0x7f0a03ea | 6004 |
| `startHorizontal` | int | 0x7f0a03e5 | 5999 |
| `startToEnd` | int | 0x7f0a03e6 | 6000 |
| `startVertical` | int | 0x7f0a03e7 | 6001 |
| `staticLayout` | int | 0x7f0a03eb | 6005 |
| `staticPostLayout` | int | 0x7f0a03ec | 6006 |
| `status` | int | 0x7f0a03ed | 6007 |
| `status_bar_latest_event_content` | int | 0x7f0a03f1 | 6011 |
| `status_bar1` | int | 0x7f0a03ee | 6008 |
| `status_bar2` | int | 0x7f0a03ef | 6009 |
| `status_bar3` | int | 0x7f0a03f0 | 6010 |
| `stillToggle` | int | 0x7f0a03f2 | 6012 |
| `stop` | int | 0x7f0a03f3 | 6013 |
| `stretch` | int | 0x7f0a03f4 | 6014 |
| `submenuarrow` | int | 0x7f0a03f5 | 6015 |
| `submit_area` | int | 0x7f0a03f6 | 6016 |
| `supportScrollUp` | int | 0x7f0a03f7 | 6017 |
| `surface_container` | int | 0x7f0a03f8 | 6018 |
| `surface_view` | int | 0x7f0a03f9 | 6019 |
| `SURFACE_VIEW` | int | 0x7f0a0017 | 5025 |
| `swipe_refresh_layout` | int | 0x7f0a03fa | 6020 |
| `switch_right` | int | 0x7f0a03fc | 6022 |
| `switchCompat` | int | 0x7f0a03fb | 6021 |
| `switcher` | int | 0x7f0a03fd | 6023 |
| `SYM` | int | 0x7f0a0018 | 5026 |
| `tabMode` | int | 0x7f0a03fe | 6024 |
| `tabs` | int | 0x7f0a03ff | 6025 |
| `tag_accessibility_actions` | int | 0x7f0a0400 | 6026 |
| `tag_accessibility_clickable_spans` | int | 0x7f0a0401 | 6027 |
| `tag_accessibility_heading` | int | 0x7f0a0402 | 6028 |
| `tag_accessibility_pane_title` | int | 0x7f0a0403 | 6029 |
| `tag_on_apply_window_listener` | int | 0x7f0a0404 | 6030 |
| `tag_on_receive_content_listener` | int | 0x7f0a0405 | 6031 |
| `tag_on_receive_content_mime_types` | int | 0x7f0a0406 | 6032 |
| `tag_screen_reader_focusable` | int | 0x7f0a0407 | 6033 |
| `tag_state_description` | int | 0x7f0a0408 | 6034 |
| `tag_transition_group` | int | 0x7f0a0409 | 6035 |
| `tag_unhandled_key_event_manager` | int | 0x7f0a040a | 6036 |
| `tag_unhandled_key_listeners` | int | 0x7f0a040b | 6037 |
| `tag_window_insets_animation_callback` | int | 0x7f0a040c | 6038 |
| `text` | int | 0x7f0a040d | 6039 |
| `text_input_end_icon` | int | 0x7f0a0415 | 6047 |
| `text_input_error_icon` | int | 0x7f0a0416 | 6048 |
| `text_input_start_icon` | int | 0x7f0a0417 | 6049 |
| `text_percentage` | int | 0x7f0a0418 | 6050 |
| `text2` | int | 0x7f0a040e | 6040 |
| `textEnd` | int | 0x7f0a040f | 6041 |
| `textinput_counter` | int | 0x7f0a0419 | 6051 |
| `textinput_error` | int | 0x7f0a041a | 6052 |
| `textinput_helper_text` | int | 0x7f0a041b | 6053 |
| `textinput_placeholder` | int | 0x7f0a041c | 6054 |
| `textinput_prefix_text` | int | 0x7f0a041d | 6055 |
| `textinput_suffix_text` | int | 0x7f0a041e | 6056 |
| `textSpacerNoButtons` | int | 0x7f0a0410 | 6042 |
| `textSpacerNoTitle` | int | 0x7f0a0411 | 6043 |
| `textStart` | int | 0x7f0a0412 | 6044 |
| `textTop` | int | 0x7f0a0413 | 6045 |
| `texture_view` | int | 0x7f0a041f | 6057 |
| `TEXTURE_VIEW` | int | 0x7f0a0019 | 5027 |
| `textView` | int | 0x7f0a0414 | 6046 |
| `thumb` | int | 0x7f0a0420 | 6058 |
| `thumbnail_layout` | int | 0x7f0a0421 | 6059 |
| `time` | int | 0x7f0a0422 | 6060 |
| `time_list` | int | 0x7f0a0425 | 6063 |
| `timelapse_mode` | int | 0x7f0a0426 | 6064 |
| `timeLapse_radio` | int | 0x7f0a0424 | 6062 |
| `timeLapseToggle` | int | 0x7f0a0423 | 6061 |
| `timepicker` | int | 0x7f0a0427 | 6065 |
| `tipTextView` | int | 0x7f0a0428 | 6066 |
| `title` | int | 0x7f0a0429 | 6067 |
| `title_content_txv` | int | 0x7f0a042b | 6069 |
| `title_template` | int | 0x7f0a042c | 6070 |
| `title_text` | int | 0x7f0a042d | 6071 |
| `titleDividerNoCustom` | int | 0x7f0a042a | 6068 |
| `toast_layout_root` | int | 0x7f0a042f | 6073 |
| `toBackground` | int | 0x7f0a042e | 6072 |
| `toggle` | int | 0x7f0a0430 | 6074 |
| `toolbar` | int | 0x7f0a0431 | 6075 |
| `toolbar_layout` | int | 0x7f0a0432 | 6076 |
| `top` | int | 0x7f0a0433 | 6077 |
| `top_center` | int | 0x7f0a0435 | 6079 |
| `TOP_END` | int | 0x7f0a001a | 5028 |
| `TOP_START` | int | 0x7f0a001b | 5029 |
| `topPanel` | int | 0x7f0a0434 | 6078 |
| `total` | int | 0x7f0a0436 | 6080 |
| `touch_outside` | int | 0x7f0a0437 | 6081 |
| `transition_clip` | int | 0x7f0a043a | 6084 |
| `transition_current_scene` | int | 0x7f0a043b | 6085 |
| `transition_image_transform` | int | 0x7f0a043c | 6086 |
| `transition_layout_save` | int | 0x7f0a043d | 6087 |
| `transition_pause_alpha` | int | 0x7f0a043e | 6088 |
| `transition_position` | int | 0x7f0a043f | 6089 |
| `transition_scene_layoutid_cache` | int | 0x7f0a0440 | 6090 |
| `transition_transform` | int | 0x7f0a0441 | 6091 |
| `transitionToEnd` | int | 0x7f0a0438 | 6082 |
| `transitionToStart` | int | 0x7f0a0439 | 6083 |
| `triangle` | int | 0x7f0a0442 | 6092 |
| `tv_battery_value` | int | 0x7f0a0444 | 6094 |
| `tv_brightness` | int | 0x7f0a0445 | 6095 |
| `tv_cancel` | int | 0x7f0a0446 | 6096 |
| `tv_confirm` | int | 0x7f0a0447 | 6097 |
| `tv_current` | int | 0x7f0a0448 | 6098 |
| `tv_date` | int | 0x7f0a0449 | 6099 |
| `tv_device_name` | int | 0x7f0a044a | 6100 |
| `tv_device_name_pwd` | int | 0x7f0a044b | 6101 |
| `tv_device_pwd` | int | 0x7f0a044c | 6102 |
| `tv_duration` | int | 0x7f0a044d | 6103 |
| `tv_file_downloaded` | int | 0x7f0a044e | 6104 |
| `tv_file_info` | int | 0x7f0a044f | 6105 |
| `tv_file_name` | int | 0x7f0a0450 | 6106 |
| `tv_file_size` | int | 0x7f0a0451 | 6107 |
| `tv_firmware_name` | int | 0x7f0a0452 | 6108 |
| `tv_firmware_region` | int | 0x7f0a0453 | 6109 |
| `tv_firmware_version` | int | 0x7f0a0454 | 6110 |
| `tv_fps` | int | 0x7f0a0455 | 6111 |
| `tv_gallery_preview_title` | int | 0x7f0a0456 | 6112 |
| `tv_hd_hint` | int | 0x7f0a0457 | 6113 |
| `tv_hint` | int | 0x7f0a0458 | 6114 |
| `tv_left` | int | 0x7f0a0459 | 6115 |
| `tv_load_dialog` | int | 0x7f0a045a | 6116 |
| `tv_loading` | int | 0x7f0a045b | 6117 |
| `tv_message` | int | 0x7f0a045c | 6118 |
| `tv_recording_time` | int | 0x7f0a045d | 6119 |
| `tv_resolution` | int | 0x7f0a045e | 6120 |
| `tv_right` | int | 0x7f0a045f | 6121 |
| `tv_select_all` | int | 0x7f0a0460 | 6122 |
| `tv_selector` | int | 0x7f0a0461 | 6123 |
| `tv_space` | int | 0x7f0a0462 | 6124 |
| `tv_state` | int | 0x7f0a0463 | 6125 |
| `tv_state_camera` | int | 0x7f0a0464 | 6126 |
| `tv_state_record` | int | 0x7f0a0465 | 6127 |
| `tv_step_one` | int | 0x7f0a0466 | 6128 |
| `tv_step_one_content` | int | 0x7f0a0467 | 6129 |
| `tv_step_one_description` | int | 0x7f0a0468 | 6130 |
| `tv_step_three` | int | 0x7f0a0469 | 6131 |
| `tv_step_three_content` | int | 0x7f0a046a | 6132 |
| `tv_step_two` | int | 0x7f0a046b | 6133 |
| `tv_step_two_content` | int | 0x7f0a046c | 6134 |
| `tv_title` | int | 0x7f0a046d | 6135 |
| `tv_version_info` | int | 0x7f0a046e | 6136 |
| `tv_video_state` | int | 0x7f0a046f | 6137 |
| `tv_volume` | int | 0x7f0a0470 | 6138 |
| `tv_watermark` | int | 0x7f0a0471 | 6139 |
| `tvTitle` | int | 0x7f0a0443 | 6093 |
| `txturl14` | int | 0x7f0a0472 | 6140 |
| `txv_privacy_policy` | int | 0x7f0a0473 | 6141 |
| `unchecked` | int | 0x7f0a0474 | 6142 |
| `uniform` | int | 0x7f0a0475 | 6143 |
| `unknown` | int | 0x7f0a0476 | 6144 |
| `unlabeled` | int | 0x7f0a0477 | 6145 |
| `up` | int | 0x7f0a0478 | 6146 |
| `usb_connect_camera` | int | 0x7f0a0479 | 6147 |
| `useLogo` | int | 0x7f0a047a | 6148 |
| `vertical` | int | 0x7f0a047c | 6150 |
| `vertical_only` | int | 0x7f0a047d | 6151 |
| `video_codec_group` | int | 0x7f0a047f | 6153 |
| `video_codec_h264` | int | 0x7f0a0480 | 6154 |
| `video_codec_mjpg` | int | 0x7f0a0481 | 6155 |
| `video_current_time` | int | 0x7f0a0482 | 6156 |
| `video_decoder_gl_surface_view` | int | 0x7f0a0483 | 6157 |
| `video_fps_10` | int | 0x7f0a0484 | 6158 |
| `video_fps_15` | int | 0x7f0a0485 | 6159 |
| `video_fps_30` | int | 0x7f0a0486 | 6160 |
| `video_fps_group` | int | 0x7f0a0487 | 6161 |
| `video_item` | int | 0x7f0a0488 | 6162 |
| `video_player_view` | int | 0x7f0a0489 | 6163 |
| `video_quality_wrapper_area` | int | 0x7f0a048a | 6164 |
| `video_radio` | int | 0x7f0a048b | 6165 |
| `video_sign` | int | 0x7f0a048c | 6166 |
| `video_size_group` | int | 0x7f0a048d | 6167 |
| `video_size_layout` | int | 0x7f0a048e | 6168 |
| `video_size_txv` | int | 0x7f0a048f | 6169 |
| `video_type_flag` | int | 0x7f0a0490 | 6170 |
| `video_view` | int | 0x7f0a0491 | 6171 |
| `videoToggle` | int | 0x7f0a047e | 6152 |
| `view_divider` | int | 0x7f0a0492 | 6172 |
| `view_line_one` | int | 0x7f0a0493 | 6173 |
| `view_line_two` | int | 0x7f0a0494 | 6174 |
| `view_offset_helper` | int | 0x7f0a0495 | 6175 |
| `view_pager` | int | 0x7f0a0496 | 6176 |
| `view_transition` | int | 0x7f0a0497 | 6177 |
| `view_tree_lifecycle_owner` | int | 0x7f0a0498 | 6178 |
| `view_tree_on_back_pressed_dispatcher_owner` | int | 0x7f0a0499 | 6179 |
| `view_tree_saved_state_registry_owner` | int | 0x7f0a049a | 6180 |
| `view_tree_view_model_store_owner` | int | 0x7f0a049b | 6181 |
| `viewpager` | int | 0x7f0a049c | 6182 |
| `visible` | int | 0x7f0a049d | 6183 |
| `visible_removing_fragment_view_tag` | int | 0x7f0a049e | 6184 |
| `volume_image_tip` | int | 0x7f0a049f | 6185 |
| `volume_progressbar` | int | 0x7f0a04a0 | 6186 |
| `vPager` | int | 0x7f0a047b | 6149 |
| `wb_status` | int | 0x7f0a04a1 | 6187 |
| `webview` | int | 0x7f0a04a2 | 6188 |
| `west` | int | 0x7f0a04a3 | 6189 |
| `when_playing` | int | 0x7f0a04a4 | 6190 |
| `wide` | int | 0x7f0a04a5 | 6191 |
| `widget_container` | int | 0x7f0a04a6 | 6192 |
| `wifi_auto_connect` | int | 0x7f0a04a7 | 6193 |
| `wifi_connect_camera` | int | 0x7f0a04a8 | 6194 |
| `wifi_imv` | int | 0x7f0a04a9 | 6195 |
| `wifi_layout` | int | 0x7f0a04aa | 6196 |
| `wifi_password` | int | 0x7f0a04ab | 6197 |
| `wifi_ssid` | int | 0x7f0a04ac | 6198 |
| `wifi_status` | int | 0x7f0a04ad | 6199 |
| `wifi_supported_ip` | int | 0x7f0a04ae | 6200 |
| `with_icon` | int | 0x7f0a04b0 | 6202 |
| `withinBounds` | int | 0x7f0a04b1 | 6203 |
| `withText` | int | 0x7f0a04af | 6201 |
| `wrap` | int | 0x7f0a04b2 | 6204 |
| `wrap_content` | int | 0x7f0a04b3 | 6205 |
| `wrap_content_constrained` | int | 0x7f0a04b4 | 6206 |
| `wv_policy` | int | 0x7f0a04b5 | 6207 |
| `x_left` | int | 0x7f0a04b6 | 6208 |
| `x_right` | int | 0x7f0a04b7 | 6209 |
| `year` | int | 0x7f0a04b8 | 6210 |
| `youtube_live_btn` | int | 0x7f0a04b9 | 6211 |
| `zoom` | int | 0x7f0a04ba | 6212 |
| `zoom_in` | int | 0x7f0a04bc | 6214 |
| `zoom_layout` | int | 0x7f0a04bd | 6215 |
| `zoom_out` | int | 0x7f0a04be | 6216 |
| `zoom_rate` | int | 0x7f0a04bf | 6217 |
| `zoom_view` | int | 0x7f0a04c0 | 6218 |
| `zoomBar` | int | 0x7f0a04bb | 6213 |

### `com.id221.golive.R$integer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_config_activityDefaultDur` | int | 0x7f0b0000 | 6222 |
| `abc_config_activityShortDur` | int | 0x7f0b0001 | 6223 |
| `animation_default_duration` | int | 0x7f0b0002 | 6224 |
| `app_bar_elevation_anim_duration` | int | 0x7f0b0003 | 6225 |
| `bottom_sheet_slide_duration` | int | 0x7f0b0004 | 6226 |
| `cancel_button_image_alpha` | int | 0x7f0b0005 | 6227 |
| `config_tooltipAnimTime` | int | 0x7f0b0006 | 6228 |
| `design_snackbar_text_max_lines` | int | 0x7f0b0007 | 6229 |
| `design_tab_indicator_anim_duration_ms` | int | 0x7f0b0008 | 6230 |
| `exo_media_button_opacity_percentage_disabled` | int | 0x7f0b0009 | 6231 |
| `exo_media_button_opacity_percentage_enabled` | int | 0x7f0b000a | 6232 |
| `google_play_services_version` | int | 0x7f0b000b | 6233 |
| `hide_password_duration` | int | 0x7f0b000c | 6234 |
| `m3_badge_max_number` | int | 0x7f0b000d | 6235 |
| `m3_btn_anim_delay_ms` | int | 0x7f0b000e | 6236 |
| `m3_btn_anim_duration_ms` | int | 0x7f0b000f | 6237 |
| `m3_card_anim_delay_ms` | int | 0x7f0b0010 | 6238 |
| `m3_card_anim_duration_ms` | int | 0x7f0b0011 | 6239 |
| `m3_chip_anim_duration` | int | 0x7f0b0012 | 6240 |
| `m3_sys_motion_duration_extra_long1` | int | 0x7f0b0013 | 6241 |
| `m3_sys_motion_duration_extra_long2` | int | 0x7f0b0014 | 6242 |
| `m3_sys_motion_duration_extra_long3` | int | 0x7f0b0015 | 6243 |
| `m3_sys_motion_duration_extra_long4` | int | 0x7f0b0016 | 6244 |
| `m3_sys_motion_duration_long1` | int | 0x7f0b0017 | 6245 |
| `m3_sys_motion_duration_long2` | int | 0x7f0b0018 | 6246 |
| `m3_sys_motion_duration_long3` | int | 0x7f0b0019 | 6247 |
| `m3_sys_motion_duration_long4` | int | 0x7f0b001a | 6248 |
| `m3_sys_motion_duration_medium1` | int | 0x7f0b001b | 6249 |
| `m3_sys_motion_duration_medium2` | int | 0x7f0b001c | 6250 |
| `m3_sys_motion_duration_medium3` | int | 0x7f0b001d | 6251 |
| `m3_sys_motion_duration_medium4` | int | 0x7f0b001e | 6252 |
| `m3_sys_motion_duration_short1` | int | 0x7f0b001f | 6253 |
| `m3_sys_motion_duration_short2` | int | 0x7f0b0020 | 6254 |
| `m3_sys_motion_duration_short3` | int | 0x7f0b0021 | 6255 |
| `m3_sys_motion_duration_short4` | int | 0x7f0b0022 | 6256 |
| `m3_sys_motion_path` | int | 0x7f0b0023 | 6257 |
| `m3_sys_shape_corner_extra_extra_large_corner_family` | int | 0x7f0b0024 | 6258 |
| `m3_sys_shape_corner_extra_large_corner_family` | int | 0x7f0b0025 | 6259 |
| `m3_sys_shape_corner_extra_large_increased_corner_family` | int | 0x7f0b0026 | 6260 |
| `m3_sys_shape_corner_extra_small_corner_family` | int | 0x7f0b0027 | 6261 |
| `m3_sys_shape_corner_full_corner_family` | int | 0x7f0b0028 | 6262 |
| `m3_sys_shape_corner_large_corner_family` | int | 0x7f0b0029 | 6263 |
| `m3_sys_shape_corner_large_increased_corner_family` | int | 0x7f0b002a | 6264 |
| `m3_sys_shape_corner_medium_corner_family` | int | 0x7f0b002b | 6265 |
| `m3_sys_shape_corner_small_corner_family` | int | 0x7f0b002c | 6266 |
| `material_motion_duration_long_1` | int | 0x7f0b002d | 6267 |
| `material_motion_duration_long_2` | int | 0x7f0b002e | 6268 |
| `material_motion_duration_medium_1` | int | 0x7f0b002f | 6269 |
| `material_motion_duration_medium_2` | int | 0x7f0b0030 | 6270 |
| `material_motion_duration_short_1` | int | 0x7f0b0031 | 6271 |
| `material_motion_duration_short_2` | int | 0x7f0b0032 | 6272 |
| `material_motion_path` | int | 0x7f0b0033 | 6273 |
| `mtrl_badge_max_character_count` | int | 0x7f0b0034 | 6274 |
| `mtrl_btn_anim_delay_ms` | int | 0x7f0b0035 | 6275 |
| `mtrl_btn_anim_duration_ms` | int | 0x7f0b0036 | 6276 |
| `mtrl_calendar_header_orientation` | int | 0x7f0b0037 | 6277 |
| `mtrl_calendar_selection_text_lines` | int | 0x7f0b0038 | 6278 |
| `mtrl_calendar_year_selector_span` | int | 0x7f0b0039 | 6279 |
| `mtrl_card_anim_delay_ms` | int | 0x7f0b003a | 6280 |
| `mtrl_card_anim_duration_ms` | int | 0x7f0b003b | 6281 |
| `mtrl_chip_anim_duration` | int | 0x7f0b003c | 6282 |
| `mtrl_switch_thumb_motion_duration` | int | 0x7f0b003d | 6283 |
| `mtrl_switch_thumb_post_morphing_duration` | int | 0x7f0b003e | 6284 |
| `mtrl_switch_thumb_pre_morphing_duration` | int | 0x7f0b003f | 6285 |
| `mtrl_switch_thumb_pressed_duration` | int | 0x7f0b0040 | 6286 |
| `mtrl_switch_thumb_viewport_center_coordinate` | int | 0x7f0b0041 | 6287 |
| `mtrl_switch_thumb_viewport_size` | int | 0x7f0b0042 | 6288 |
| `mtrl_switch_track_viewport_height` | int | 0x7f0b0043 | 6289 |
| `mtrl_switch_track_viewport_width` | int | 0x7f0b0044 | 6290 |
| `mtrl_tab_indicator_anim_duration_ms` | int | 0x7f0b0045 | 6291 |
| `mtrl_view_gone` | int | 0x7f0b0046 | 6292 |
| `mtrl_view_invisible` | int | 0x7f0b0047 | 6293 |
| `mtrl_view_visible` | int | 0x7f0b0048 | 6294 |
| `show_password_duration` | int | 0x7f0b0049 | 6295 |
| `status_bar_notification_info_maxnum` | int | 0x7f0b004a | 6296 |

### `com.id221.golive.R$interpolator`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `btn_checkbox_checked_mtrl_animation_interpolator_0` | int | 0x7f0c0000 | 6300 |
| `btn_checkbox_checked_mtrl_animation_interpolator_1` | int | 0x7f0c0001 | 6301 |
| `btn_checkbox_unchecked_mtrl_animation_interpolator_0` | int | 0x7f0c0002 | 6302 |
| `btn_checkbox_unchecked_mtrl_animation_interpolator_1` | int | 0x7f0c0003 | 6303 |
| `btn_radio_to_off_mtrl_animation_interpolator_0` | int | 0x7f0c0004 | 6304 |
| `btn_radio_to_on_mtrl_animation_interpolator_0` | int | 0x7f0c0005 | 6305 |
| `fast_out_slow_in` | int | 0x7f0c0006 | 6306 |
| `m3_sys_motion_easing_emphasized` | int | 0x7f0c0007 | 6307 |
| `m3_sys_motion_easing_emphasized_accelerate` | int | 0x7f0c0008 | 6308 |
| `m3_sys_motion_easing_emphasized_decelerate` | int | 0x7f0c0009 | 6309 |
| `m3_sys_motion_easing_linear` | int | 0x7f0c000a | 6310 |
| `m3_sys_motion_easing_standard` | int | 0x7f0c000b | 6311 |
| `m3_sys_motion_easing_standard_accelerate` | int | 0x7f0c000c | 6312 |
| `m3_sys_motion_easing_standard_decelerate` | int | 0x7f0c000d | 6313 |
| `mtrl_fast_out_linear_in` | int | 0x7f0c000e | 6314 |
| `mtrl_fast_out_slow_in` | int | 0x7f0c000f | 6315 |
| `mtrl_linear` | int | 0x7f0c0010 | 6316 |
| `mtrl_linear_out_slow_in` | int | 0x7f0c0011 | 6317 |

### `com.id221.golive.R$layout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_action_bar_title_item` | int | 0x7f0d0000 | 6321 |
| `abc_action_bar_up_container` | int | 0x7f0d0001 | 6322 |
| `abc_action_menu_item_layout` | int | 0x7f0d0002 | 6323 |
| `abc_action_menu_layout` | int | 0x7f0d0003 | 6324 |
| `abc_action_mode_bar` | int | 0x7f0d0004 | 6325 |
| `abc_action_mode_close_item_material` | int | 0x7f0d0005 | 6326 |
| `abc_activity_chooser_view` | int | 0x7f0d0006 | 6327 |
| `abc_activity_chooser_view_list_item` | int | 0x7f0d0007 | 6328 |
| `abc_alert_dialog_button_bar_material` | int | 0x7f0d0008 | 6329 |
| `abc_alert_dialog_material` | int | 0x7f0d0009 | 6330 |
| `abc_alert_dialog_title_material` | int | 0x7f0d000a | 6331 |
| `abc_cascading_menu_item_layout` | int | 0x7f0d000b | 6332 |
| `abc_dialog_title_material` | int | 0x7f0d000c | 6333 |
| `abc_expanded_menu_layout` | int | 0x7f0d000d | 6334 |
| `abc_list_menu_item_checkbox` | int | 0x7f0d000e | 6335 |
| `abc_list_menu_item_icon` | int | 0x7f0d000f | 6336 |
| `abc_list_menu_item_layout` | int | 0x7f0d0010 | 6337 |
| `abc_list_menu_item_radio` | int | 0x7f0d0011 | 6338 |
| `abc_popup_menu_header_item_layout` | int | 0x7f0d0012 | 6339 |
| `abc_popup_menu_item_layout` | int | 0x7f0d0013 | 6340 |
| `abc_screen_content_include` | int | 0x7f0d0014 | 6341 |
| `abc_screen_simple` | int | 0x7f0d0015 | 6342 |
| `abc_screen_simple_overlay_action_mode` | int | 0x7f0d0016 | 6343 |
| `abc_screen_toolbar` | int | 0x7f0d0017 | 6344 |
| `abc_search_dropdown_item_icons_2line` | int | 0x7f0d0018 | 6345 |
| `abc_search_view` | int | 0x7f0d0019 | 6346 |
| `abc_select_dialog_material` | int | 0x7f0d001a | 6347 |
| `abc_tooltip` | int | 0x7f0d001b | 6348 |
| `activity_about_app` | int | 0x7f0d001c | 6349 |
| `activity_change_language` | int | 0x7f0d001d | 6350 |
| `activity_common_video_player` | int | 0x7f0d001e | 6351 |
| `activity_connect_course` | int | 0x7f0d001f | 6352 |
| `activity_device_settings_ly` | int | 0x7f0d0020 | 6353 |
| `activity_download_file_ly` | int | 0x7f0d0021 | 6354 |
| `activity_download_firmware` | int | 0x7f0d0022 | 6355 |
| `activity_exo_test` | int | 0x7f0d0023 | 6356 |
| `activity_feedback` | int | 0x7f0d0024 | 6357 |
| `activity_launch` | int | 0x7f0d0025 | 6358 |
| `activity_launch_help` | int | 0x7f0d0026 | 6359 |
| `activity_license` | int | 0x7f0d0027 | 6360 |
| `activity_live_video_ly` | int | 0x7f0d0028 | 6361 |
| `activity_local_files` | int | 0x7f0d0029 | 6362 |
| `activity_local_multi_pb` | int | 0x7f0d002a | 6363 |
| `activity_local_photo_pb` | int | 0x7f0d002b | 6364 |
| `activity_local_photo_wall` | int | 0x7f0d002c | 6365 |
| `activity_login_facebook` | int | 0x7f0d002d | 6366 |
| `activity_login_google` | int | 0x7f0d002e | 6367 |
| `activity_multi_pb` | int | 0x7f0d002f | 6368 |
| `activity_multi_pb2` | int | 0x7f0d0030 | 6369 |
| `activity_panorama_local_photo_pb` | int | 0x7f0d0031 | 6370 |
| `activity_panorama_local_video_pb` | int | 0x7f0d0032 | 6371 |
| `activity_panorama_photo_pb` | int | 0x7f0d0033 | 6372 |
| `activity_pb_local_video` | int | 0x7f0d0034 | 6373 |
| `activity_photo_pb` | int | 0x7f0d0035 | 6374 |
| `activity_preview` | int | 0x7f0d0036 | 6375 |
| `activity_pv_size_setting` | int | 0x7f0d0037 | 6376 |
| `activity_remote_file_ly` | int | 0x7f0d0038 | 6377 |
| `activity_remote_files` | int | 0x7f0d0039 | 6378 |
| `activity_start_page` | int | 0x7f0d003a | 6379 |
| `activity_usb_preview` | int | 0x7f0d003b | 6380 |
| `activity_video_pb` | int | 0x7f0d003c | 6381 |
| `activity_video_player` | int | 0x7f0d003d | 6382 |
| `activity_video_player_ly` | int | 0x7f0d003e | 6383 |
| `activity_web` | int | 0x7f0d003f | 6384 |
| `activity_wifi_ap` | int | 0x7f0d0040 | 6385 |
| `album_activity_album_dark` | int | 0x7f0d0041 | 6386 |
| `album_activity_album_light` | int | 0x7f0d0042 | 6387 |
| `album_activity_gallery` | int | 0x7f0d0043 | 6388 |
| `album_activity_null` | int | 0x7f0d0044 | 6389 |
| `album_content_album` | int | 0x7f0d0045 | 6390 |
| `album_dialog_floder` | int | 0x7f0d0046 | 6391 |
| `album_dialog_loading` | int | 0x7f0d0047 | 6392 |
| `album_item_content_button` | int | 0x7f0d0048 | 6393 |
| `album_item_content_image` | int | 0x7f0d0049 | 6394 |
| `album_item_content_video` | int | 0x7f0d004a | 6395 |
| `album_item_dialog_folder` | int | 0x7f0d004b | 6396 |
| `album_toolbar_dark` | int | 0x7f0d004c | 6397 |
| `album_toolbar_light` | int | 0x7f0d004d | 6398 |
| `alert_dialog_change_device_info` | int | 0x7f0d004e | 6399 |
| `audio_switch_layout` | int | 0x7f0d004f | 6400 |
| `auto_download_layout` | int | 0x7f0d0050 | 6401 |
| `auto_download_layout_size` | int | 0x7f0d0051 | 6402 |
| `bluetooth_header` | int | 0x7f0d0052 | 6403 |
| `bluetooth_status` | int | 0x7f0d0053 | 6404 |
| `browser_actions_context_menu_page` | int | 0x7f0d0054 | 6405 |
| `browser_actions_context_menu_row` | int | 0x7f0d0055 | 6406 |
| `cam_slot_item` | int | 0x7f0d0056 | 6407 |
| `cam_slot_item_add` | int | 0x7f0d0057 | 6408 |
| `camer_mode_switch_layout` | int | 0x7f0d0058 | 6409 |
| `camera_name_password_set` | int | 0x7f0d0059 | 6410 |
| `com_facebook_activity_layout` | int | 0x7f0d005a | 6411 |
| `com_facebook_device_auth_dialog_fragment` | int | 0x7f0d005b | 6412 |
| `com_facebook_login_fragment` | int | 0x7f0d005c | 6413 |
| `com_facebook_smart_device_dialog_fragment` | int | 0x7f0d005d | 6414 |
| `com_facebook_tooltip_bubble` | int | 0x7f0d005e | 6415 |
| `common_item_layout` | int | 0x7f0d005f | 6416 |
| `common_setting_layout` | int | 0x7f0d0060 | 6417 |
| `content_download_size_dialog` | int | 0x7f0d0061 | 6418 |
| `content_launch` | int | 0x7f0d0062 | 6419 |
| `content_launch_help_img` | int | 0x7f0d0063 | 6420 |
| `content_local_multi_pb` | int | 0x7f0d0064 | 6421 |
| `content_local_photo_wall` | int | 0x7f0d0065 | 6422 |
| `content_multi_pb` | int | 0x7f0d0066 | 6423 |
| `content_panorama_local_photo_pb` | int | 0x7f0d0067 | 6424 |
| `content_panorama_local_video_pb` | int | 0x7f0d0068 | 6425 |
| `content_panorama_photo_pb` | int | 0x7f0d0069 | 6426 |
| `content_panorama_preview` | int | 0x7f0d006a | 6427 |
| `content_panorama_video_pb` | int | 0x7f0d006b | 6428 |
| `content_pb_local_video` | int | 0x7f0d006c | 6429 |
| `content_photo_pb` | int | 0x7f0d006d | 6430 |
| `content_usb_preview` | int | 0x7f0d006e | 6431 |
| `custom_dialog` | int | 0x7f0d006f | 6432 |
| `custom_toast` | int | 0x7f0d0070 | 6433 |
| `design_bottom_navigation_item` | int | 0x7f0d0071 | 6434 |
| `design_bottom_sheet_dialog` | int | 0x7f0d0072 | 6435 |
| `design_layout_snackbar` | int | 0x7f0d0073 | 6436 |
| `design_layout_snackbar_include` | int | 0x7f0d0074 | 6437 |
| `design_layout_tab_icon` | int | 0x7f0d0075 | 6438 |
| `design_layout_tab_text` | int | 0x7f0d0076 | 6439 |
| `design_menu_item_action_area` | int | 0x7f0d0077 | 6440 |
| `design_navigation_item` | int | 0x7f0d0078 | 6441 |
| `design_navigation_item_header` | int | 0x7f0d0079 | 6442 |
| `design_navigation_item_separator` | int | 0x7f0d007a | 6443 |
| `design_navigation_item_subheader` | int | 0x7f0d007b | 6444 |
| `design_navigation_menu` | int | 0x7f0d007c | 6445 |
| `design_navigation_menu_item` | int | 0x7f0d007d | 6446 |
| `design_text_input_end_icon` | int | 0x7f0d007e | 6447 |
| `design_text_input_start_icon` | int | 0x7f0d007f | 6448 |
| `dialog_basic` | int | 0x7f0d0080 | 6449 |
| `dialog_loading` | int | 0x7f0d0081 | 6450 |
| `dialog_privacy_policy` | int | 0x7f0d0082 | 6451 |
| `dialog_progress` | int | 0x7f0d0083 | 6452 |
| `dialog_web` | int | 0x7f0d0084 | 6453 |
| `download` | int | 0x7f0d0085 | 6454 |
| `download_content_dialog` | int | 0x7f0d0086 | 6455 |
| `download_dialog_title` | int | 0x7f0d0087 | 6456 |
| `download_single_dialog_title` | int | 0x7f0d0088 | 6457 |
| `empty_control_video` | int | 0x7f0d0089 | 6458 |
| `exo_list_divider` | int | 0x7f0d008a | 6459 |
| `exo_player_control_view` | int | 0x7f0d008b | 6460 |
| `exo_player_view` | int | 0x7f0d008c | 6461 |
| `exo_styled_player_control_ffwd_button` | int | 0x7f0d008d | 6462 |
| `exo_styled_player_control_rewind_button` | int | 0x7f0d008e | 6463 |
| `exo_styled_player_control_view` | int | 0x7f0d008f | 6464 |
| `exo_styled_player_view` | int | 0x7f0d0090 | 6465 |
| `exo_styled_settings_list` | int | 0x7f0d0091 | 6466 |
| `exo_styled_settings_list_item` | int | 0x7f0d0092 | 6467 |
| `exo_styled_sub_settings_list_item` | int | 0x7f0d0093 | 6468 |
| `exo_track_selection_dialog` | int | 0x7f0d0094 | 6469 |
| `file_filter` | int | 0x7f0d0095 | 6470 |
| `file_list_layout` | int | 0x7f0d0096 | 6471 |
| `fragment_add_new_cam` | int | 0x7f0d0097 | 6472 |
| `fragment_btpair_begin` | int | 0x7f0d0098 | 6473 |
| `fragment_btpair_completed` | int | 0x7f0d0099 | 6474 |
| `fragment_btpair_setup` | int | 0x7f0d009a | 6475 |
| `fragment_device_files` | int | 0x7f0d009b | 6476 |
| `fragment_item` | int | 0x7f0d009c | 6477 |
| `fragment_item_grid` | int | 0x7f0d009d | 6478 |
| `fragment_item_list` | int | 0x7f0d009e | 6479 |
| `fragment_local_device_files` | int | 0x7f0d009f | 6480 |
| `fragment_local_pb_list` | int | 0x7f0d00a0 | 6481 |
| `fragment_multi_pb` | int | 0x7f0d00a1 | 6482 |
| `fragment_multi_pb_photo` | int | 0x7f0d00a3 | 6484 |
| `fragment_multi_pb_video` | int | 0x7f0d00a4 | 6485 |
| `fragment_multi_pb2` | int | 0x7f0d00a2 | 6483 |
| `fragment_remote_device_files` | int | 0x7f0d00a5 | 6486 |
| `ime_base_split_test_activity` | int | 0x7f0d00a6 | 6487 |
| `ime_secondary_split_test_activity` | int | 0x7f0d00a7 | 6488 |
| `include_pickerview_topbar` | int | 0x7f0d00a8 | 6489 |
| `input_ip` | int | 0x7f0d00a9 | 6490 |
| `input_password` | int | 0x7f0d00aa | 6491 |
| `item_device_setting` | int | 0x7f0d00ab | 6492 |
| `item_file_date` | int | 0x7f0d00ac | 6493 |
| `item_filter` | int | 0x7f0d00ad | 6494 |
| `item_firmware_info` | int | 0x7f0d00ae | 6495 |
| `item_local_photo_wall_grid` | int | 0x7f0d00af | 6496 |
| `item_local_photo_wall_list` | int | 0x7f0d00b0 | 6497 |
| `item_local_photo_wall_list_header` | int | 0x7f0d00b1 | 6498 |
| `item_local_video_wall_list` | int | 0x7f0d00b2 | 6499 |
| `item_local_wall_grid_header` | int | 0x7f0d00b3 | 6500 |
| `item_pb_recyclerview_grid` | int | 0x7f0d00b4 | 6501 |
| `item_pb_recyclerview_list` | int | 0x7f0d00b5 | 6502 |
| `item_video_file` | int | 0x7f0d00b6 | 6503 |
| `item_video_file_ly` | int | 0x7f0d00b7 | 6504 |
| `iten_local_video_wall_grid` | int | 0x7f0d00b8 | 6505 |
| `jz_dialog_brightness` | int | 0x7f0d00b9 | 6506 |
| `jz_dialog_progress` | int | 0x7f0d00ba | 6507 |
| `jz_dialog_volume` | int | 0x7f0d00bb | 6508 |
| `jz_layout_clarity` | int | 0x7f0d00bc | 6509 |
| `jz_layout_clarity_item` | int | 0x7f0d00bd | 6510 |
| `jz_layout_std` | int | 0x7f0d00be | 6511 |
| `layout_basepickerview` | int | 0x7f0d00bf | 6512 |
| `layout_progress_wheel_large` | int | 0x7f0d00c0 | 6513 |
| `layout_progress_wheel_small` | int | 0x7f0d00c1 | 6514 |
| `layout_refresh_footer` | int | 0x7f0d00c2 | 6515 |
| `license_agreement_layout` | int | 0x7f0d00c3 | 6516 |
| `listview_item` | int | 0x7f0d00c4 | 6517 |
| `listview_item_header` | int | 0x7f0d00c5 | 6518 |
| `live_shared_url` | int | 0x7f0d00c6 | 6519 |
| `load_dialog` | int | 0x7f0d00c7 | 6520 |
| `local_multi_pb_edit_view` | int | 0x7f0d00c8 | 6521 |
| `m3_alert_dialog` | int | 0x7f0d00c9 | 6522 |
| `m3_alert_dialog_actions` | int | 0x7f0d00ca | 6523 |
| `m3_alert_dialog_title` | int | 0x7f0d00cb | 6524 |
| `m3_auto_complete_simple_item` | int | 0x7f0d00cc | 6525 |
| `m3_navigation_menu_divider` | int | 0x7f0d00cd | 6526 |
| `m3_navigation_menu_subheader` | int | 0x7f0d00ce | 6527 |
| `m3_side_sheet_dialog` | int | 0x7f0d00cf | 6528 |
| `material_chip_input_combo` | int | 0x7f0d00d0 | 6529 |
| `material_clock_display` | int | 0x7f0d00d1 | 6530 |
| `material_clock_display_divider` | int | 0x7f0d00d2 | 6531 |
| `material_clock_period_toggle` | int | 0x7f0d00d3 | 6532 |
| `material_clock_period_toggle_land` | int | 0x7f0d00d4 | 6533 |
| `material_clockface_textview` | int | 0x7f0d00d5 | 6534 |
| `material_clockface_view` | int | 0x7f0d00d6 | 6535 |
| `material_radial_view_group` | int | 0x7f0d00d7 | 6536 |
| `material_textinput_timepicker` | int | 0x7f0d00d8 | 6537 |
| `material_time_chip` | int | 0x7f0d00d9 | 6538 |
| `material_time_input` | int | 0x7f0d00da | 6539 |
| `material_timepicker` | int | 0x7f0d00db | 6540 |
| `material_timepicker_dialog` | int | 0x7f0d00dc | 6541 |
| `material_timepicker_textinput_display` | int | 0x7f0d00dd | 6542 |
| `media_audio_player_view_layout` | int | 0x7f0d00de | 6543 |
| `media_camera_item` | int | 0x7f0d00df | 6544 |
| `media_file_list_item` | int | 0x7f0d00e0 | 6545 |
| `media_file_recycler_list_layout` | int | 0x7f0d00e1 | 6546 |
| `media_item_pb_recyclerview_grid` | int | 0x7f0d00e2 | 6547 |
| `media_layout_refresh_footer` | int | 0x7f0d00e3 | 6548 |
| `media_render_view_layout` | int | 0x7f0d00e4 | 6549 |
| `meida_camera_list_layout` | int | 0x7f0d00e5 | 6550 |
| `messenger_button_send_blue_large` | int | 0x7f0d00e6 | 6551 |
| `messenger_button_send_blue_round` | int | 0x7f0d00e7 | 6552 |
| `messenger_button_send_blue_small` | int | 0x7f0d00e8 | 6553 |
| `messenger_button_send_white_large` | int | 0x7f0d00e9 | 6554 |
| `messenger_button_send_white_round` | int | 0x7f0d00ea | 6555 |
| `messenger_button_send_white_small` | int | 0x7f0d00eb | 6556 |
| `mtrl_alert_dialog` | int | 0x7f0d00ec | 6557 |
| `mtrl_alert_dialog_actions` | int | 0x7f0d00ed | 6558 |
| `mtrl_alert_dialog_title` | int | 0x7f0d00ee | 6559 |
| `mtrl_alert_select_dialog_item` | int | 0x7f0d00ef | 6560 |
| `mtrl_alert_select_dialog_multichoice` | int | 0x7f0d00f0 | 6561 |
| `mtrl_alert_select_dialog_singlechoice` | int | 0x7f0d00f1 | 6562 |
| `mtrl_auto_complete_simple_item` | int | 0x7f0d00f2 | 6563 |
| `mtrl_calendar_day` | int | 0x7f0d00f3 | 6564 |
| `mtrl_calendar_day_of_week` | int | 0x7f0d00f4 | 6565 |
| `mtrl_calendar_days_of_week` | int | 0x7f0d00f5 | 6566 |
| `mtrl_calendar_horizontal` | int | 0x7f0d00f6 | 6567 |
| `mtrl_calendar_month` | int | 0x7f0d00f7 | 6568 |
| `mtrl_calendar_month_labeled` | int | 0x7f0d00f8 | 6569 |
| `mtrl_calendar_month_navigation` | int | 0x7f0d00f9 | 6570 |
| `mtrl_calendar_months` | int | 0x7f0d00fa | 6571 |
| `mtrl_calendar_vertical` | int | 0x7f0d00fb | 6572 |
| `mtrl_calendar_year` | int | 0x7f0d00fc | 6573 |
| `mtrl_layout_snackbar` | int | 0x7f0d00fd | 6574 |
| `mtrl_layout_snackbar_include` | int | 0x7f0d00fe | 6575 |
| `mtrl_navigation_rail_item` | int | 0x7f0d00ff | 6576 |
| `mtrl_picker_actions` | int | 0x7f0d0100 | 6577 |
| `mtrl_picker_dialog` | int | 0x7f0d0101 | 6578 |
| `mtrl_picker_fullscreen` | int | 0x7f0d0102 | 6579 |
| `mtrl_picker_header_dialog` | int | 0x7f0d0103 | 6580 |
| `mtrl_picker_header_fullscreen` | int | 0x7f0d0104 | 6581 |
| `mtrl_picker_header_selection_text` | int | 0x7f0d0105 | 6582 |
| `mtrl_picker_header_title_text` | int | 0x7f0d0106 | 6583 |
| `mtrl_picker_header_toggle` | int | 0x7f0d0107 | 6584 |
| `mtrl_picker_text_input_date` | int | 0x7f0d0108 | 6585 |
| `mtrl_picker_text_input_date_range` | int | 0x7f0d0109 | 6586 |
| `mtrl_search_bar` | int | 0x7f0d010a | 6587 |
| `mtrl_search_view` | int | 0x7f0d010b | 6588 |
| `multi_pb_edit_view` | int | 0x7f0d010c | 6589 |
| `my_exo_player_control_view` | int | 0x7f0d010d | 6590 |
| `my_toast` | int | 0x7f0d010e | 6591 |
| `notification_action` | int | 0x7f0d010f | 6592 |
| `notification_action_tombstone` | int | 0x7f0d0110 | 6593 |
| `notification_media_action` | int | 0x7f0d0111 | 6594 |
| `notification_media_cancel_action` | int | 0x7f0d0112 | 6595 |
| `notification_template_big_media` | int | 0x7f0d0113 | 6596 |
| `notification_template_big_media_custom` | int | 0x7f0d0114 | 6597 |
| `notification_template_big_media_narrow` | int | 0x7f0d0115 | 6598 |
| `notification_template_big_media_narrow_custom` | int | 0x7f0d0116 | 6599 |
| `notification_template_custom_big` | int | 0x7f0d0117 | 6600 |
| `notification_template_icon_group` | int | 0x7f0d0118 | 6601 |
| `notification_template_lines_media` | int | 0x7f0d0119 | 6602 |
| `notification_template_media` | int | 0x7f0d011a | 6603 |
| `notification_template_media_custom` | int | 0x7f0d011b | 6604 |
| `notification_template_part_chronometer` | int | 0x7f0d011c | 6605 |
| `notification_template_part_time` | int | 0x7f0d011d | 6606 |
| `pb_photo_item` | int | 0x7f0d011e | 6607 |
| `percentage_dialog` | int | 0x7f0d011f | 6608 |
| `pickerview_options` | int | 0x7f0d0120 | 6609 |
| `pickerview_time` | int | 0x7f0d0121 | 6610 |
| `preview_control_view` | int | 0x7f0d0122 | 6611 |
| `preview_player_view` | int | 0x7f0d0123 | 6612 |
| `privacy_zones_view_layout` | int | 0x7f0d0124 | 6613 |
| `pull_to_refresh_header_horizontal` | int | 0x7f0d0125 | 6614 |
| `pull_to_refresh_header_vertical` | int | 0x7f0d0126 | 6615 |
| `sample_video_land` | int | 0x7f0d0127 | 6616 |
| `sample_video_normal` | int | 0x7f0d0128 | 6617 |
| `select_dialog_item_material` | int | 0x7f0d0129 | 6618 |
| `select_dialog_multichoice_material` | int | 0x7f0d012a | 6619 |
| `select_dialog_singlechoice_material` | int | 0x7f0d012b | 6620 |
| `setting_enable_wifi_hotspot` | int | 0x7f0d012c | 6621 |
| `setting_listview_item` | int | 0x7f0d012d | 6622 |
| `setting_menu` | int | 0x7f0d012e | 6623 |
| `setting_menu_item` | int | 0x7f0d012f | 6624 |
| `setting_switch_layout` | int | 0x7f0d0130 | 6625 |
| `single_download_content_dialog` | int | 0x7f0d0131 | 6626 |
| `support_simple_spinner_dropdown_item` | int | 0x7f0d0132 | 6627 |
| `video_brightness` | int | 0x7f0d0133 | 6628 |
| `video_control_view` | int | 0x7f0d0134 | 6629 |
| `video_layout_ad` | int | 0x7f0d0135 | 6630 |
| `video_layout_custom` | int | 0x7f0d0136 | 6631 |
| `video_layout_normal` | int | 0x7f0d0137 | 6632 |
| `video_layout_sample_ad` | int | 0x7f0d0138 | 6633 |
| `video_layout_standard` | int | 0x7f0d0139 | 6634 |
| `video_player_view` | int | 0x7f0d013a | 6635 |
| `video_progress_dialog` | int | 0x7f0d013b | 6636 |
| `video_volume_dialog` | int | 0x7f0d013c | 6637 |
| `zoombar_view` | int | 0x7f0d013d | 6638 |

### `com.id221.golive.R$menu`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `album_menu_album` | int | 0x7f0f0000 | 6642 |
| `album_menu_gallery` | int | 0x7f0f0001 | 6643 |
| `album_menu_item_camera` | int | 0x7f0f0002 | 6644 |
| `menu_launch` | int | 0x7f0f0003 | 6645 |
| `menu_local_multi_pb` | int | 0x7f0f0004 | 6646 |
| `menu_local_photo_wall` | int | 0x7f0f0005 | 6647 |
| `menu_local_video_wall` | int | 0x7f0f0006 | 6648 |
| `menu_multi_pb` | int | 0x7f0f0007 | 6649 |
| `menu_preview` | int | 0x7f0f0008 | 6650 |

### `com.id221.golive.R$mipmap`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `custom_enlarge` | int | 0x7f100000 | 6654 |
| `custom_shrink` | int | 0x7f100001 | 6655 |
| `dialog_loading_img` | int | 0x7f100002 | 6656 |
| `ic_launcher` | int | 0x7f100003 | 6657 |
| `ic_remove_connected` | int | 0x7f100004 | 6658 |
| `icon_about_app_arrow` | int | 0x7f100005 | 6659 |
| `icon_about_app_feedback` | int | 0x7f100006 | 6660 |
| `icon_about_app_language` | int | 0x7f100007 | 6661 |
| `icon_about_app_logo` | int | 0x7f100008 | 6662 |
| `icon_about_app_protocol` | int | 0x7f100009 | 6663 |
| `icon_about_download_firmware` | int | 0x7f10000a | 6664 |
| `icon_aieryou_logo` | int | 0x7f10000b | 6665 |
| `icon_camera_device` | int | 0x7f10000c | 6666 |
| `icon_connect_course_page` | int | 0x7f10000d | 6667 |
| `icon_connect_course_wifi` | int | 0x7f10000e | 6668 |
| `icon_device` | int | 0x7f10000f | 6669 |
| `icon_device_bc1` | int | 0x7f100010 | 6670 |
| `icon_device_bc2` | int | 0x7f100011 | 6671 |
| `icon_device_c2` | int | 0x7f100012 | 6672 |
| `icon_device_c3` | int | 0x7f100013 | 6673 |
| `icon_device_c3p` | int | 0x7f100014 | 6674 |
| `icon_device_c5` | int | 0x7f100015 | 6675 |
| `icon_device_c5s` | int | 0x7f100016 | 6676 |
| `icon_device_c6` | int | 0x7f100017 | 6677 |
| `icon_device_dc1` | int | 0x7f100018 | 6678 |
| `icon_device_default` | int | 0x7f100019 | 6679 |
| `icon_device_file` | int | 0x7f10001a | 6680 |
| `icon_device_zeeho` | int | 0x7f10001b | 6681 |
| `icon_file_delete` | int | 0x7f10001c | 6682 |
| `icon_file_download` | int | 0x7f10001d | 6683 |
| `icon_id221_logo` | int | 0x7f10001e | 6684 |
| `icon_load_default` | int | 0x7f10001f | 6685 |
| `icon_load_default_idcam` | int | 0x7f100020 | 6686 |
| `icon_lock` | int | 0x7f100021 | 6687 |
| `icon_main_bg_about` | int | 0x7f100022 | 6688 |
| `icon_main_bg_logo` | int | 0x7f100023 | 6689 |
| `icon_main_bg_phone` | int | 0x7f100024 | 6690 |
| `icon_main_bg_photo` | int | 0x7f100025 | 6691 |
| `icon_main_bg_video` | int | 0x7f100026 | 6692 |
| `icon_main_bg_wifi` | int | 0x7f100027 | 6693 |
| `icon_main_page_arrow` | int | 0x7f100028 | 6694 |
| `icon_main_page_logo` | int | 0x7f100029 | 6695 |
| `icon_main_page_phone` | int | 0x7f10002a | 6696 |
| `icon_main_page_photo` | int | 0x7f10002b | 6697 |
| `icon_main_page_video` | int | 0x7f10002c | 6698 |
| `icon_main_page_wifi` | int | 0x7f10002d | 6699 |
| `icon_page_back` | int | 0x7f10002e | 6700 |
| `icon_page_delete` | int | 0x7f10002f | 6701 |
| `icon_preview_back` | int | 0x7f100030 | 6702 |
| `icon_setting` | int | 0x7f100031 | 6703 |
| `icon_shot_cut` | int | 0x7f100032 | 6704 |
| `icon_state_camera` | int | 0x7f100033 | 6705 |
| `icon_state_camera_selected` | int | 0x7f100034 | 6706 |
| `icon_state_record` | int | 0x7f100035 | 6707 |
| `icon_state_record_selected` | int | 0x7f100036 | 6708 |
| `icon_video_zoom_in` | int | 0x7f100037 | 6709 |
| `icon_video_zoom_out` | int | 0x7f100038 | 6710 |
| `id_start_page` | int | 0x7f100039 | 6711 |
| `item_download_firmware` | int | 0x7f10003a | 6712 |
| `item_download_firmware_done` | int | 0x7f10003b | 6713 |
| `select_cancel` | int | 0x7f10003c | 6714 |
| `select_state` | int | 0x7f10003d | 6715 |
| `start_page_golive` | int | 0x7f10003e | 6716 |
| `tmp_photo` | int | 0x7f10003f | 6717 |
| `tmp_video` | int | 0x7f100040 | 6718 |
| `video_buttery_new_100` | int | 0x7f100041 | 6719 |
| `video_buttery_new_20` | int | 0x7f100042 | 6720 |
| `video_buttery_new_50` | int | 0x7f100043 | 6721 |
| `video_buttery_new_75` | int | 0x7f100044 | 6722 |

### `com.id221.golive.R$plurals`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `album_check_album_limit` | int | 0x7f110000 | 6726 |
| `album_check_album_limit_camera` | int | 0x7f110001 | 6727 |
| `album_check_image_limit` | int | 0x7f110002 | 6728 |
| `album_check_image_limit_camera` | int | 0x7f110003 | 6729 |
| `album_check_video_limit` | int | 0x7f110004 | 6730 |
| `album_check_video_limit_camera` | int | 0x7f110005 | 6731 |
| `exo_controls_fastforward_by_amount_description` | int | 0x7f110006 | 6732 |
| `exo_controls_rewind_by_amount_description` | int | 0x7f110007 | 6733 |
| `mtrl_badge_content_description` | int | 0x7f110008 | 6734 |

### `com.id221.golive.R$raw`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `camera_click` | int | 0x7f120000 | 6738 |
| `camera_timer` | int | 0x7f120001 | 6739 |
| `captureburst` | int | 0x7f120002 | 6740 |
| `captureshutter` | int | 0x7f120003 | 6741 |
| `client_secret` | int | 0x7f120004 | 6742 |
| `delay_beep` | int | 0x7f120005 | 6743 |
| `focusbeep` | int | 0x7f120006 | 6744 |
| `license` | int | 0x7f120007 | 6745 |
| `license_cpu_features` | int | 0x7f120008 | 6746 |
| `license_dav1d` | int | 0x7f120009 | 6747 |
| `license_expat` | int | 0x7f12000a | 6748 |
| `license_fontconfig` | int | 0x7f12000b | 6749 |
| `license_freetype` | int | 0x7f12000c | 6750 |
| `license_fribidi` | int | 0x7f12000d | 6751 |
| `license_giflib` | int | 0x7f12000e | 6752 |
| `license_gmp` | int | 0x7f12000f | 6753 |
| `license_gnutls` | int | 0x7f120010 | 6754 |
| `license_harfbuzz` | int | 0x7f120011 | 6755 |
| `license_jpeg` | int | 0x7f120012 | 6756 |
| `license_kvazaar` | int | 0x7f120013 | 6757 |
| `license_lame` | int | 0x7f120014 | 6758 |
| `license_libass` | int | 0x7f120015 | 6759 |
| `license_libiconv` | int | 0x7f120016 | 6760 |
| `license_libilbc` | int | 0x7f120017 | 6761 |
| `license_libogg` | int | 0x7f120018 | 6762 |
| `license_libpng` | int | 0x7f120019 | 6763 |
| `license_libsndfile` | int | 0x7f12001a | 6764 |
| `license_libtheora` | int | 0x7f12001b | 6765 |
| `license_libuuid` | int | 0x7f12001c | 6766 |
| `license_libvorbis` | int | 0x7f12001d | 6767 |
| `license_libvpx` | int | 0x7f12001e | 6768 |
| `license_libwebp` | int | 0x7f12001f | 6769 |
| `license_libxml2` | int | 0x7f120020 | 6770 |
| `license_nettle` | int | 0x7f120021 | 6771 |
| `license_opencore_amr` | int | 0x7f120022 | 6772 |
| `license_opus` | int | 0x7f120023 | 6773 |
| `license_shine` | int | 0x7f120024 | 6774 |
| `license_snappy` | int | 0x7f120025 | 6775 |
| `license_soxr` | int | 0x7f120026 | 6776 |
| `license_speex` | int | 0x7f120027 | 6777 |
| `license_tiff` | int | 0x7f120028 | 6778 |
| `license_twolame` | int | 0x7f120029 | 6779 |
| `license_vo_amrwbenc` | int | 0x7f12002a | 6780 |
| `license_zimg` | int | 0x7f12002b | 6781 |
| `sencha` | int | 0x7f12002c | 6782 |
| `shutter` | int | 0x7f12002d | 6783 |
| `source` | int | 0x7f12002e | 6784 |

### `com.id221.golive.R$string`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_action_bar_home_description` | int | 0x7f130000 | 6788 |
| `abc_action_bar_up_description` | int | 0x7f130001 | 6789 |
| `abc_action_menu_overflow_description` | int | 0x7f130002 | 6790 |
| `abc_action_mode_done` | int | 0x7f130003 | 6791 |
| `abc_activity_chooser_view_see_all` | int | 0x7f130004 | 6792 |
| `abc_activitychooserview_choose_application` | int | 0x7f130005 | 6793 |
| `abc_capital_off` | int | 0x7f130006 | 6794 |
| `abc_capital_on` | int | 0x7f130007 | 6795 |
| `abc_menu_alt_shortcut_label` | int | 0x7f130008 | 6796 |
| `abc_menu_ctrl_shortcut_label` | int | 0x7f130009 | 6797 |
| `abc_menu_delete_shortcut_label` | int | 0x7f13000a | 6798 |
| `abc_menu_enter_shortcut_label` | int | 0x7f13000b | 6799 |
| `abc_menu_function_shortcut_label` | int | 0x7f13000c | 6800 |
| `abc_menu_meta_shortcut_label` | int | 0x7f13000d | 6801 |
| `abc_menu_shift_shortcut_label` | int | 0x7f13000e | 6802 |
| `abc_menu_space_shortcut_label` | int | 0x7f13000f | 6803 |
| `abc_menu_sym_shortcut_label` | int | 0x7f130010 | 6804 |
| `abc_prepend_shortcut_label` | int | 0x7f130011 | 6805 |
| `abc_search_hint` | int | 0x7f130012 | 6806 |
| `abc_searchview_description_clear` | int | 0x7f130013 | 6807 |
| `abc_searchview_description_query` | int | 0x7f130014 | 6808 |
| `abc_searchview_description_search` | int | 0x7f130015 | 6809 |
| `abc_searchview_description_submit` | int | 0x7f130016 | 6810 |
| `abc_searchview_description_voice` | int | 0x7f130017 | 6811 |
| `abc_shareactionprovider_share_with` | int | 0x7f130018 | 6812 |
| `abc_shareactionprovider_share_with_application` | int | 0x7f130019 | 6813 |
| `abc_toolbar_collapse_description` | int | 0x7f13001a | 6814 |
| `about_app` | int | 0x7f13001b | 6815 |
| `action_back` | int | 0x7f13001c | 6816 |
| `action_device_pwd` | int | 0x7f13001d | 6817 |
| `action_device_pwd_error` | int | 0x7f13001e | 6818 |
| `action_input_device_pwd` | int | 0x7f13001f | 6819 |
| `action_input_ip` | int | 0x7f130020 | 6820 |
| `action_processing` | int | 0x7f130021 | 6821 |
| `action_save` | int | 0x7f130022 | 6822 |
| `action_search` | int | 0x7f130023 | 6823 |
| `action_setting` | int | 0x7f130024 | 6824 |
| `action_settings` | int | 0x7f130025 | 6825 |
| `action_title_date_stamp` | int | 0x7f130026 | 6826 |
| `add_to` | int | 0x7f130027 | 6827 |
| `album_all_images` | int | 0x7f130028 | 6828 |
| `album_all_images_videos` | int | 0x7f130029 | 6829 |
| `album_all_videos` | int | 0x7f13002a | 6830 |
| `album_camera_image_capture` | int | 0x7f13002b | 6831 |
| `album_camera_video_capture` | int | 0x7f13002c | 6832 |
| `album_cancel` | int | 0x7f13002d | 6833 |
| `album_check` | int | 0x7f13002e | 6834 |
| `album_check_album_little` | int | 0x7f13002f | 6835 |
| `album_check_image_little` | int | 0x7f130030 | 6836 |
| `album_check_video_little` | int | 0x7f130031 | 6837 |
| `album_confirm` | int | 0x7f130032 | 6838 |
| `album_converting` | int | 0x7f130033 | 6839 |
| `album_item_unavailable` | int | 0x7f130034 | 6840 |
| `album_loading` | int | 0x7f130035 | 6841 |
| `album_menu_finish` | int | 0x7f130036 | 6842 |
| `album_not_found_album` | int | 0x7f130037 | 6843 |
| `album_not_found_image` | int | 0x7f130038 | 6844 |
| `album_not_found_video` | int | 0x7f130039 | 6845 |
| `album_ok` | int | 0x7f13003a | 6846 |
| `album_permission_camera_image_failed_hint` | int | 0x7f13003b | 6847 |
| `album_permission_camera_video_failed_hint` | int | 0x7f13003c | 6848 |
| `album_permission_storage_failed_hint` | int | 0x7f13003d | 6849 |
| `album_take_file_unavailable` | int | 0x7f13003e | 6850 |
| `album_thumbnail` | int | 0x7f13003f | 6851 |
| `album_title` | int | 0x7f130040 | 6852 |
| `album_title_permission_failed` | int | 0x7f130041 | 6853 |
| `alert_camera_name_needed` | int | 0x7f130042 | 6854 |
| `alert_is_capturing_or_recording` | int | 0x7f130043 | 6855 |
| `alert_no_camera_found` | int | 0x7f130044 | 6856 |
| `alert_not_same_password` | int | 0x7f130045 | 6857 |
| `alert_old_pwd_verify_failed` | int | 0x7f130046 | 6858 |
| `alert_pwd_needed` | int | 0x7f130047 | 6859 |
| `alert_uid_needed` | int | 0x7f130048 | 6860 |
| `alert_uid_repeated` | int | 0x7f130049 | 6861 |
| `all` | int | 0x7f13004a | 6862 |
| `androidx_startup` | int | 0x7f13004b | 6863 |
| `app_exception` | int | 0x7f13004c | 6864 |
| `app_license` | int | 0x7f13004d | 6865 |
| `app_name` | int | 0x7f13004e | 6866 |
| `appbar_scrolling_view_behavior` | int | 0x7f13004f | 6867 |
| `auth_code_fmt` | int | 0x7f130050 | 6868 |
| `bluetooth_audio_recording` | int | 0x7f130051 | 6869 |
| `bottom_sheet_behavior` | int | 0x7f130052 | 6870 |
| `bottomsheet_action_collapse` | int | 0x7f130053 | 6871 |
| `bottomsheet_action_expand` | int | 0x7f130054 | 6872 |
| `bottomsheet_action_expand_halfway` | int | 0x7f130055 | 6873 |
| `bottomsheet_drag_handle_content_description` | int | 0x7f130056 | 6874 |
| `burst_10` | int | 0x7f130057 | 6875 |
| `burst_15` | int | 0x7f130058 | 6876 |
| `burst_3` | int | 0x7f130059 | 6877 |
| `burst_30` | int | 0x7f13005a | 6878 |
| `burst_5` | int | 0x7f13005b | 6879 |
| `burst_7` | int | 0x7f13005c | 6880 |
| `burst_hs` | int | 0x7f13005d | 6881 |
| `burst_off` | int | 0x7f13005e | 6882 |
| `button_check_current_wifi_list` | int | 0x7f13005f | 6883 |
| `call_notification_answer_action` | int | 0x7f130060 | 6884 |
| `call_notification_answer_video_action` | int | 0x7f130061 | 6885 |
| `call_notification_decline_action` | int | 0x7f130062 | 6886 |
| `call_notification_hang_up_action` | int | 0x7f130063 | 6887 |
| `call_notification_incoming_text` | int | 0x7f130064 | 6888 |
| `call_notification_ongoing_text` | int | 0x7f130065 | 6889 |
| `call_notification_screening_text` | int | 0x7f130066 | 6890 |
| `camera_abnormal` | int | 0x7f130067 | 6891 |
| `camera_awake` | int | 0x7f130068 | 6892 |
| `camera_awake_failed` | int | 0x7f130069 | 6893 |
| `camera_awake_success` | int | 0x7f13006a | 6894 |
| `camera_configuration_set` | int | 0x7f13006b | 6895 |
| `camera_inversion` | int | 0x7f13006c | 6896 |
| `camera_name_limit` | int | 0x7f13006d | 6897 |
| `camera_permission_is_denied_info` | int | 0x7f13006e | 6898 |
| `camera_pwd_setting` | int | 0x7f13006f | 6899 |
| `camera_setting` | int | 0x7f130070 | 6900 |
| `camera_sleep` | int | 0x7f130071 | 6901 |
| `camera_sleep_alert` | int | 0x7f130072 | 6902 |
| `camera_wifi_configuration` | int | 0x7f130073 | 6903 |
| `camera_wifi_name` | int | 0x7f130074 | 6904 |
| `camera_wifi_password` | int | 0x7f130075 | 6905 |
| `can_not_be_empty` | int | 0x7f130076 | 6906 |
| `cancel` | int | 0x7f130077 | 6907 |
| `cancel_all` | int | 0x7f130078 | 6908 |
| `capture` | int | 0x7f130079 | 6909 |
| `capture_completed` | int | 0x7f13007a | 6910 |
| `capture_start` | int | 0x7f13007b | 6911 |
| `change_device_info` | int | 0x7f13007c | 6912 |
| `character_counter_content_description` | int | 0x7f13007d | 6913 |
| `character_counter_overflowed_content_description` | int | 0x7f13007e | 6914 |
| `character_counter_pattern` | int | 0x7f13007f | 6915 |
| `check_mac_fail` | int | 0x7f130080 | 6916 |
| `check_wifi_policy` | int | 0x7f130081 | 6917 |
| `clear_text_end_icon_content_description` | int | 0x7f130082 | 6918 |
| `click_to_restart` | int | 0x7f130083 | 6919 |
| `client_count` | int | 0x7f130084 | 6920 |
| `com_facebook_device_auth_instructions` | int | 0x7f130085 | 6921 |
| `com_facebook_image_download_unknown_error` | int | 0x7f130086 | 6922 |
| `com_facebook_internet_permission_error_message` | int | 0x7f130087 | 6923 |
| `com_facebook_internet_permission_error_title` | int | 0x7f130088 | 6924 |
| `com_facebook_like_button_liked` | int | 0x7f130089 | 6925 |
| `com_facebook_like_button_not_liked` | int | 0x7f13008a | 6926 |
| `com_facebook_loading` | int | 0x7f13008b | 6927 |
| `com_facebook_loginview_cancel_action` | int | 0x7f13008c | 6928 |
| `com_facebook_loginview_log_in_button` | int | 0x7f13008d | 6929 |
| `com_facebook_loginview_log_in_button_continue` | int | 0x7f13008e | 6930 |
| `com_facebook_loginview_log_in_button_long` | int | 0x7f13008f | 6931 |
| `com_facebook_loginview_log_out_action` | int | 0x7f130090 | 6932 |
| `com_facebook_loginview_log_out_button` | int | 0x7f130091 | 6933 |
| `com_facebook_loginview_logged_in_as` | int | 0x7f130092 | 6934 |
| `com_facebook_loginview_logged_in_using_facebook` | int | 0x7f130093 | 6935 |
| `com_facebook_send_button_text` | int | 0x7f130094 | 6936 |
| `com_facebook_share_button_text` | int | 0x7f130095 | 6937 |
| `com_facebook_smart_device_instructions` | int | 0x7f130096 | 6938 |
| `com_facebook_smart_device_instructions_or` | int | 0x7f130097 | 6939 |
| `com_facebook_smart_login_confirmation_cancel` | int | 0x7f130098 | 6940 |
| `com_facebook_smart_login_confirmation_continue_as` | int | 0x7f130099 | 6941 |
| `com_facebook_smart_login_confirmation_title` | int | 0x7f13009a | 6942 |
| `com_facebook_tooltip_default` | int | 0x7f13009b | 6943 |
| `comfirm` | int | 0x7f13009c | 6944 |
| `common_google_play_services_enable_button` | int | 0x7f13009d | 6945 |
| `common_google_play_services_enable_text` | int | 0x7f13009e | 6946 |
| `common_google_play_services_enable_title` | int | 0x7f13009f | 6947 |
| `common_google_play_services_install_button` | int | 0x7f1300a0 | 6948 |
| `common_google_play_services_install_text` | int | 0x7f1300a1 | 6949 |
| `common_google_play_services_install_title` | int | 0x7f1300a2 | 6950 |
| `common_google_play_services_notification_channel_name` | int | 0x7f1300a3 | 6951 |
| `common_google_play_services_notification_ticker` | int | 0x7f1300a4 | 6952 |
| `common_google_play_services_unknown_issue` | int | 0x7f1300a5 | 6953 |
| `common_google_play_services_unsupported_text` | int | 0x7f1300a6 | 6954 |
| `common_google_play_services_update_button` | int | 0x7f1300a7 | 6955 |
| `common_google_play_services_update_text` | int | 0x7f1300a8 | 6956 |
| `common_google_play_services_update_title` | int | 0x7f1300a9 | 6957 |
| `common_google_play_services_updating_text` | int | 0x7f1300aa | 6958 |
| `common_google_play_services_wear_update_text` | int | 0x7f1300ab | 6959 |
| `common_open_on_phone` | int | 0x7f1300ac | 6960 |
| `common_signin_button_text` | int | 0x7f1300ad | 6961 |
| `common_signin_button_text_long` | int | 0x7f1300ae | 6962 |
| `connect_control` | int | 0x7f1300af | 6963 |
| `connect_course` | int | 0x7f1300b0 | 6964 |
| `content_privacy_policy_1` | int | 0x7f1300b1 | 6965 |
| `content_privacy_policy_2` | int | 0x7f1300b2 | 6966 |
| `content_privacy_policy_3` | int | 0x7f1300b3 | 6967 |
| `copy` | int | 0x7f1300b4 | 6968 |
| `current_setting_need_reconnect` | int | 0x7f1300b5 | 6969 |
| `current_size_not_support_image_stabilization` | int | 0x7f1300b6 | 6970 |
| `current_size_not_supported_sound_off` | int | 0x7f1300b7 | 6971 |
| `dateStamp_date` | int | 0x7f1300b8 | 6972 |
| `dateStamp_date_and_time` | int | 0x7f1300b9 | 6973 |
| `dateStamp_off` | int | 0x7f1300ba | 6974 |
| `delay_capture` | int | 0x7f1300bb | 6975 |
| `delete` | int | 0x7f1300bc | 6976 |
| `delete_done` | int | 0x7f1300bd | 6977 |
| `desc_google_icon` | int | 0x7f1300be | 6978 |
| `device_cannot_lens_rotation` | int | 0x7f1300bf | 6979 |
| `device_free_space` | int | 0x7f1300c0 | 6980 |
| `device_info` | int | 0x7f1300c1 | 6981 |
| `device_info_connect` | int | 0x7f1300c2 | 6982 |
| `device_info_live` | int | 0x7f1300c3 | 6983 |
| `device_info_modify` | int | 0x7f1300c4 | 6984 |
| `device_info_subtitle_offline` | int | 0x7f1300c5 | 6985 |
| `device_info_subtitle_online` | int | 0x7f1300c6 | 6986 |
| `device_info_title_offline` | int | 0x7f1300c7 | 6987 |
| `device_info_title_online` | int | 0x7f1300c8 | 6988 |
| `device_name` | int | 0x7f1300c9 | 6989 |
| `device_name_pwd` | int | 0x7f1300ca | 6990 |
| `device_not_support_current_region` | int | 0x7f1300cb | 6991 |
| `device_pwd` | int | 0x7f1300cc | 6992 |
| `device_pwd_length_need_8` | int | 0x7f1300cd | 6993 |
| `device_storage_space` | int | 0x7f1300ce | 6994 |
| `device_version_info` | int | 0x7f1300cf | 6995 |
| `devices_offline` | int | 0x7f1300d0 | 6996 |
| `devices_online` | int | 0x7f1300d1 | 6997 |
| `devices_wif_name` | int | 0x7f1300d2 | 6998 |
| `dialog_awake_all` | int | 0x7f1300d3 | 6999 |
| `dialog_btn_continue` | int | 0x7f1300d4 | 7000 |
| `dialog_btn_exit` | int | 0x7f1300d5 | 7001 |
| `dialog_btn_reconnect` | int | 0x7f1300d6 | 7002 |
| `dialog_cancel_downloading_failed` | int | 0x7f1300d7 | 7003 |
| `dialog_cancel_downloading_succeeded` | int | 0x7f1300d8 | 7004 |
| `dialog_capturing` | int | 0x7f1300d9 | 7005 |
| `dialog_card_error` | int | 0x7f1300da | 7006 |
| `dialog_card_full` | int | 0x7f1300db | 7007 |
| `dialog_card_inserted` | int | 0x7f1300dc | 7008 |
| `dialog_card_lose` | int | 0x7f1300dd | 7009 |
| `dialog_card_not_exist` | int | 0x7f1300de | 7010 |
| `dialog_card_removed` | int | 0x7f1300df | 7011 |
| `dialog_card_removed_and_back` | int | 0x7f1300e0 | 7012 |
| `dialog_card_removed_and_back_photo_pb` | int | 0x7f1300e1 | 7013 |
| `dialog_configuring` | int | 0x7f1300e2 | 7014 |
| `dialog_connect_failed` | int | 0x7f1300e3 | 7015 |
| `dialog_connecting` | int | 0x7f1300e4 | 7016 |
| `dialog_connecting_to_cam` | int | 0x7f1300e5 | 7017 |
| `dialog_delete_all` | int | 0x7f1300e6 | 7018 |
| `dialog_delete_failed_single` | int | 0x7f1300e7 | 7019 |
| `dialog_deleting` | int | 0x7f1300e8 | 7020 |
| `dialog_deleting_failed_multi` | int | 0x7f1300e9 | 7021 |
| `dialog_downloaded` | int | 0x7f1300ea | 7022 |
| `dialog_downloaded_2` | int | 0x7f1300eb | 7023 |
| `dialog_downloaded_single` | int | 0x7f1300ec | 7024 |
| `dialog_downloaded_skipped` | int | 0x7f1300ed | 7025 |
| `dialog_downloaded_skipped_2` | int | 0x7f1300ee | 7026 |
| `dialog_downloading` | int | 0x7f1300ef | 7027 |
| `dialog_downloading_single` | int | 0x7f1300f0 | 7028 |
| `dialog_failed` | int | 0x7f1300f1 | 7029 |
| `dialog_init_network` | int | 0x7f1300f2 | 7030 |
| `dialog_invalid_ap` | int | 0x7f1300f3 | 7031 |
| `dialog_local_memory_not_enough` | int | 0x7f1300f4 | 7032 |
| `dialog_no_sd` | int | 0x7f1300f5 | 7033 |
| `dialog_not_enough_space` | int | 0x7f1300f6 | 7034 |
| `dialog_preview` | int | 0x7f1300f7 | 7035 |
| `dialog_reconnect` | int | 0x7f1300f8 | 7036 |
| `dialog_reconnect_failed` | int | 0x7f1300f9 | 7037 |
| `dialog_recording_card_full` | int | 0x7f1300fa | 7038 |
| `dialog_refreshing` | int | 0x7f1300fb | 7039 |
| `dialog_sd_card_is_full` | int | 0x7f1300fc | 7040 |
| `dialog_select_wifi` | int | 0x7f1300fd | 7041 |
| `dialog_timeout` | int | 0x7f1300fe | 7042 |
| `dialog_timeout_2` | int | 0x7f1300ff | 7043 |
| `dialog_wifi_lost` | int | 0x7f130100 | 7044 |
| `disconnect` | int | 0x7f130101 | 7045 |
| `download` | int | 0x7f130102 | 7046 |
| `download_cancel_all_tips` | int | 0x7f130103 | 7047 |
| `download_complete_result` | int | 0x7f130104 | 7048 |
| `download_done` | int | 0x7f130105 | 7049 |
| `download_firmware` | int | 0x7f130106 | 7050 |
| `download_manager` | int | 0x7f130107 | 7051 |
| `download_progress` | int | 0x7f130108 | 7052 |
| `downloaded` | int | 0x7f130109 | 7053 |
| `downloading_file` | int | 0x7f13010a | 7054 |
| `downloading_quit` | int | 0x7f13010b | 7055 |
| `dummy_button` | int | 0x7f13010c | 7056 |
| `dummy_content` | int | 0x7f13010d | 7057 |
| `editing_unable_switch` | int | 0x7f13010e | 7058 |
| `email_cannot_empty` | int | 0x7f13010f | 7059 |
| `end_youtube_live` | int | 0x7f130110 | 7060 |
| `error_a11y_label` | int | 0x7f130111 | 7061 |
| `error_icon_content_description` | int | 0x7f130112 | 7062 |
| `event_stream_abnormal` | int | 0x7f130113 | 7063 |
| `exo_controls_cc_disabled_description` | int | 0x7f130114 | 7064 |
| `exo_controls_cc_enabled_description` | int | 0x7f130115 | 7065 |
| `exo_controls_custom_playback_speed` | int | 0x7f130116 | 7066 |
| `exo_controls_fastforward_description` | int | 0x7f130117 | 7067 |
| `exo_controls_fullscreen_enter_description` | int | 0x7f130118 | 7068 |
| `exo_controls_fullscreen_exit_description` | int | 0x7f130119 | 7069 |
| `exo_controls_hide` | int | 0x7f13011a | 7070 |
| `exo_controls_next_description` | int | 0x7f13011b | 7071 |
| `exo_controls_overflow_hide_description` | int | 0x7f13011c | 7072 |
| `exo_controls_overflow_show_description` | int | 0x7f13011d | 7073 |
| `exo_controls_pause_description` | int | 0x7f13011e | 7074 |
| `exo_controls_play_description` | int | 0x7f13011f | 7075 |
| `exo_controls_playback_speed` | int | 0x7f130120 | 7076 |
| `exo_controls_previous_description` | int | 0x7f130121 | 7077 |
| `exo_controls_repeat_all_description` | int | 0x7f130122 | 7078 |
| `exo_controls_repeat_off_description` | int | 0x7f130123 | 7079 |
| `exo_controls_repeat_one_description` | int | 0x7f130124 | 7080 |
| `exo_controls_rewind_description` | int | 0x7f130125 | 7081 |
| `exo_controls_seek_bar_description` | int | 0x7f130126 | 7082 |
| `exo_controls_settings_description` | int | 0x7f130127 | 7083 |
| `exo_controls_show` | int | 0x7f130128 | 7084 |
| `exo_controls_shuffle_off_description` | int | 0x7f130129 | 7085 |
| `exo_controls_shuffle_on_description` | int | 0x7f13012a | 7086 |
| `exo_controls_stop_description` | int | 0x7f13012b | 7087 |
| `exo_controls_time_placeholder` | int | 0x7f13012c | 7088 |
| `exo_controls_vr_description` | int | 0x7f13012d | 7089 |
| `exo_download_completed` | int | 0x7f13012e | 7090 |
| `exo_download_description` | int | 0x7f13012f | 7091 |
| `exo_download_downloading` | int | 0x7f130130 | 7092 |
| `exo_download_failed` | int | 0x7f130131 | 7093 |
| `exo_download_notification_channel_name` | int | 0x7f130132 | 7094 |
| `exo_download_paused` | int | 0x7f130133 | 7095 |
| `exo_download_paused_for_network` | int | 0x7f130134 | 7096 |
| `exo_download_paused_for_wifi` | int | 0x7f130135 | 7097 |
| `exo_download_removing` | int | 0x7f130136 | 7098 |
| `exo_item_list` | int | 0x7f130137 | 7099 |
| `exo_track_bitrate` | int | 0x7f130138 | 7100 |
| `exo_track_mono` | int | 0x7f130139 | 7101 |
| `exo_track_resolution` | int | 0x7f13013a | 7102 |
| `exo_track_role_alternate` | int | 0x7f13013b | 7103 |
| `exo_track_role_closed_captions` | int | 0x7f13013c | 7104 |
| `exo_track_role_commentary` | int | 0x7f13013d | 7105 |
| `exo_track_role_supplementary` | int | 0x7f13013e | 7106 |
| `exo_track_selection_auto` | int | 0x7f13013f | 7107 |
| `exo_track_selection_none` | int | 0x7f130140 | 7108 |
| `exo_track_selection_title_audio` | int | 0x7f130141 | 7109 |
| `exo_track_selection_title_text` | int | 0x7f130142 | 7110 |
| `exo_track_selection_title_video` | int | 0x7f130143 | 7111 |
| `exo_track_stereo` | int | 0x7f130144 | 7112 |
| `exo_track_surround` | int | 0x7f130145 | 7113 |
| `exo_track_surround_5_point_1` | int | 0x7f130146 | 7114 |
| `exo_track_surround_7_point_1` | int | 0x7f130147 | 7115 |
| `exo_track_unknown` | int | 0x7f130148 | 7116 |
| `exposed_dropdown_menu_content_description` | int | 0x7f130149 | 7117 |
| `fab_transformation_scrim_behavior` | int | 0x7f13014a | 7118 |
| `fab_transformation_sheet_behavior` | int | 0x7f13014b | 7119 |
| `facebook_app_id` | int | 0x7f13014c | 7120 |
| `facebook_end_live` | int | 0x7f13014d | 7121 |
| `facebook_input_page_name` | int | 0x7f13014e | 7122 |
| `facebook_page_setting` | int | 0x7f13014f | 7123 |
| `facebook_start_live` | int | 0x7f130150 | 7124 |
| `fb_login_protocol_scheme` | int | 0x7f130151 | 7125 |
| `feedback` | int | 0x7f130152 | 7126 |
| `feedback_content` | int | 0x7f130153 | 7127 |
| `feedback_content_cannot_empty` | int | 0x7f130154 | 7128 |
| `feedback_content_not_nil` | int | 0x7f130155 | 7129 |
| `feedback_device_type_not_nil` | int | 0x7f130156 | 7130 |
| `feedback_email` | int | 0x7f130157 | 7131 |
| `feedback_emial_not_nil` | int | 0x7f130158 | 7132 |
| `feedback_success` | int | 0x7f130159 | 7133 |
| `feedbacl_device_use_region_not_nil` | int | 0x7f13015a | 7134 |
| `first_connect_devices_then_live` | int | 0x7f13015b | 7135 |
| `format_device` | int | 0x7f13015c | 7136 |
| `format_success` | int | 0x7f13015d | 7137 |
| `formatting_sd_card` | int | 0x7f13015e | 7138 |
| `frequency_50HZ` | int | 0x7f13015f | 7139 |
| `frequency_60HZ` | int | 0x7f130160 | 7140 |
| `front_lens_rotation` | int | 0x7f130161 | 7141 |
| `g_sensor` | int | 0x7f130162 | 7142 |
| `g_sensor_high` | int | 0x7f130163 | 7143 |
| `g_sensor_low` | int | 0x7f130164 | 7144 |
| `g_sensor_max` | int | 0x7f130165 | 7145 |
| `g_sensor_med` | int | 0x7f130166 | 7146 |
| `g_sensor_off` | int | 0x7f130167 | 7147 |
| `gallery_cancel` | int | 0x7f130168 | 7148 |
| `gallery_cannot_download_video` | int | 0x7f130169 | 7149 |
| `gallery_cannot_view_video` | int | 0x7f13016a | 7150 |
| `gallery_delete` | int | 0x7f13016b | 7151 |
| `gallery_delete_des` | int | 0x7f13016c | 7152 |
| `gallery_download` | int | 0x7f13016d | 7153 |
| `gallery_download_msg` | int | 0x7f13016e | 7154 |
| `gallery_download_msg_2` | int | 0x7f13016f | 7155 |
| `gallery_download_pic_msg` | int | 0x7f130170 | 7156 |
| `gallery_download_video_not_supported` | int | 0x7f130171 | 7157 |
| `gallery_download_with_vid_msg` | int | 0x7f130172 | 7158 |
| `gallery_exiting_share` | int | 0x7f130173 | 7159 |
| `gallery_no_file_selected` | int | 0x7f130174 | 7160 |
| `gallery_no_image` | int | 0x7f130175 | 7161 |
| `gallery_selection_count` | int | 0x7f130176 | 7162 |
| `gallery_share_in_process` | int | 0x7f130177 | 7163 |
| `gallery_share_to` | int | 0x7f130178 | 7164 |
| `gallery_share_wifi` | int | 0x7f130179 | 7165 |
| `gallery_test_content` | int | 0x7f13017a | 7166 |
| `gallery_view_video_not_supported` | int | 0x7f13017b | 7167 |
| `google_account` | int | 0x7f13017c | 7168 |
| `hd_quality_hint` | int | 0x7f13017d | 7169 |
| `help` | int | 0x7f13017e | 7170 |
| `hide_bottom_view_on_scroll_behavior` | int | 0x7f13017f | 7171 |
| `icon_content_description` | int | 0x7f130180 | 7172 |
| `idcam_need_call_storage_space` | int | 0x7f130181 | 7173 |
| `ijkplayer_dummy` | int | 0x7f130182 | 7174 |
| `image_delete_des` | int | 0x7f130183 | 7175 |
| `image_download_msg` | int | 0x7f130184 | 7176 |
| `input_device_name` | int | 0x7f130185 | 7177 |
| `input_device_pwd` | int | 0x7f130186 | 7178 |
| `input_device_type` | int | 0x7f130187 | 7179 |
| `input_device_usage_region` | int | 0x7f130188 | 7180 |
| `input_email` | int | 0x7f130189 | 7181 |
| `input_live_url` | int | 0x7f13018a | 7182 |
| `input_phone` | int | 0x7f13018b | 7183 |
| `input_your_feedback_content` | int | 0x7f13018c | 7184 |
| `invalid_device` | int | 0x7f13018d | 7185 |
| `is_change_language` | int | 0x7f13018e | 7186 |
| `is_del_this_device` | int | 0x7f13018f | 7187 |
| `item_view_role_description` | int | 0x7f130190 | 7188 |
| `jump_ad` | int | 0x7f130191 | 7189 |
| `language` | int | 0x7f130192 | 7190 |
| `launch_help_qa` | int | 0x7f130193 | 7191 |
| `launch_help_qa_1` | int | 0x7f130194 | 7192 |
| `launch_help_qa_10` | int | 0x7f130195 | 7193 |
| `launch_help_qa_2` | int | 0x7f130196 | 7194 |
| `launch_help_qa_3` | int | 0x7f130197 | 7195 |
| `launch_help_qa_4` | int | 0x7f130198 | 7196 |
| `launch_help_qa_5` | int | 0x7f130199 | 7197 |
| `launch_help_qa_6` | int | 0x7f13019a | 7198 |
| `launch_help_qa_7` | int | 0x7f13019b | 7199 |
| `launch_help_qa_8` | int | 0x7f13019c | 7200 |
| `launch_help_qa_8_2` | int | 0x7f13019d | 7201 |
| `launch_help_qa_9` | int | 0x7f13019e | 7202 |
| `launch_help_qa_end` | int | 0x7f13019f | 7203 |
| `lens_rotation` | int | 0x7f1301a0 | 7204 |
| `loading` | int | 0x7f1301a1 | 7205 |
| `loading_data_waiting` | int | 0x7f1301a2 | 7206 |
| `loading_live_wait` | int | 0x7f1301a3 | 7207 |
| `loading_resource_wait` | int | 0x7f1301a4 | 7208 |
| `loading_wait` | int | 0x7f1301a5 | 7209 |
| `local_file` | int | 0x7f1301a6 | 7210 |
| `loop_recording_time` | int | 0x7f1301a7 | 7211 |
| `low_battery` | int | 0x7f1301a8 | 7212 |
| `m3_exceed_max_badge_text_suffix` | int | 0x7f1301a9 | 7213 |
| `m3_loading_indicator_content_description` | int | 0x7f1301aa | 7214 |
| `m3_ref_typeface_brand_medium` | int | 0x7f1301ab | 7215 |
| `m3_ref_typeface_brand_regular` | int | 0x7f1301ac | 7216 |
| `m3_ref_typeface_plain_medium` | int | 0x7f1301ad | 7217 |
| `m3_ref_typeface_plain_regular` | int | 0x7f1301ae | 7218 |
| `m3_sys_motion_easing_emphasized` | int | 0x7f1301af | 7219 |
| `m3_sys_motion_easing_emphasized_accelerate` | int | 0x7f1301b0 | 7220 |
| `m3_sys_motion_easing_emphasized_decelerate` | int | 0x7f1301b1 | 7221 |
| `m3_sys_motion_easing_emphasized_path_data` | int | 0x7f1301b2 | 7222 |
| `m3_sys_motion_easing_legacy` | int | 0x7f1301b3 | 7223 |
| `m3_sys_motion_easing_legacy_accelerate` | int | 0x7f1301b4 | 7224 |
| `m3_sys_motion_easing_legacy_decelerate` | int | 0x7f1301b5 | 7225 |
| `m3_sys_motion_easing_linear` | int | 0x7f1301b6 | 7226 |
| `m3_sys_motion_easing_standard` | int | 0x7f1301b7 | 7227 |
| `m3_sys_motion_easing_standard_accelerate` | int | 0x7f1301b8 | 7228 |
| `m3_sys_motion_easing_standard_decelerate` | int | 0x7f1301b9 | 7229 |
| `main_page_name` | int | 0x7f1301ba | 7230 |
| `material_clock_display_divider` | int | 0x7f1301bb | 7231 |
| `material_clock_toggle_content_description` | int | 0x7f1301bc | 7232 |
| `material_hour_24h_suffix` | int | 0x7f1301bd | 7233 |
| `material_hour_selection` | int | 0x7f1301be | 7234 |
| `material_hour_suffix` | int | 0x7f1301bf | 7235 |
| `material_minute_selection` | int | 0x7f1301c0 | 7236 |
| `material_minute_suffix` | int | 0x7f1301c1 | 7237 |
| `material_motion_easing_accelerated` | int | 0x7f1301c2 | 7238 |
| `material_motion_easing_decelerated` | int | 0x7f1301c3 | 7239 |
| `material_motion_easing_emphasized` | int | 0x7f1301c4 | 7240 |
| `material_motion_easing_linear` | int | 0x7f1301c5 | 7241 |
| `material_motion_easing_standard` | int | 0x7f1301c6 | 7242 |
| `material_slider_range_end` | int | 0x7f1301c7 | 7243 |
| `material_slider_range_start` | int | 0x7f1301c8 | 7244 |
| `material_slider_value` | int | 0x7f1301c9 | 7245 |
| `material_timepicker_am` | int | 0x7f1301ca | 7246 |
| `material_timepicker_clock_mode_description` | int | 0x7f1301cb | 7247 |
| `material_timepicker_hour` | int | 0x7f1301cc | 7248 |
| `material_timepicker_minute` | int | 0x7f1301cd | 7249 |
| `material_timepicker_pm` | int | 0x7f1301ce | 7250 |
| `material_timepicker_select_time` | int | 0x7f1301cf | 7251 |
| `material_timepicker_text_input_mode_description` | int | 0x7f1301d0 | 7252 |
| `media_dialog_cancel` | int | 0x7f1301d1 | 7253 |
| `media_dialog_connecting` | int | 0x7f1301d2 | 7254 |
| `media_dialog_sure` | int | 0x7f1301d3 | 7255 |
| `media_failed` | int | 0x7f1301d4 | 7256 |
| `media_selected_num` | int | 0x7f1301d5 | 7257 |
| `media_text_downloaded` | int | 0x7f1301d6 | 7258 |
| `media_text_operation_failed` | int | 0x7f1301d7 | 7259 |
| `media_text_previewing_by_other` | int | 0x7f1301d8 | 7260 |
| `media_text_stream_launch_failed` | int | 0x7f1301d9 | 7261 |
| `meida_text_album` | int | 0x7f1301da | 7262 |
| `meida_text_resolution_hd` | int | 0x7f1301db | 7263 |
| `meida_text_resolution_smooth` | int | 0x7f1301dc | 7264 |
| `meida_text_share` | int | 0x7f1301dd | 7265 |
| `menu_list` | int | 0x7f1301de | 7266 |
| `message_binding` | int | 0x7f1301df | 7267 |
| `message_binding_exception` | int | 0x7f1301e0 | 7268 |
| `message_binding_failed` | int | 0x7f1301e1 | 7269 |
| `message_ble_device_connected` | int | 0x7f1301e2 | 7270 |
| `message_ble_device_not_connected_please_tryagain_` | int | 0x7f1301e3 | 7271 |
| `message_ble_service_discovered` | int | 0x7f1301e4 | 7272 |
| `message_bounded_is_ok` | int | 0x7f1301e5 | 7273 |
| `message_btpair_search` | int | 0x7f1301e6 | 7274 |
| `message_click_disconnect_and_relogin` | int | 0x7f1301e7 | 7275 |
| `message_connecting` | int | 0x7f1301e8 | 7276 |
| `message_download_failed` | int | 0x7f1301e9 | 7277 |
| `message_download_to` | int | 0x7f1301ea | 7278 |
| `message_failed_to_bounded` | int | 0x7f1301ee | 7282 |
| `message_failed_to_connect_camera` | int | 0x7f1301ef | 7283 |
| `message_failed_to_connect_please_tyragain` | int | 0x7f1301f0 | 7284 |
| `message_failed_to_connect_wifi` | int | 0x7f1301f1 | 7285 |
| `message_failed_to_start_living_publish` | int | 0x7f1301f2 | 7286 |
| `message_failed_to_start_publish_streaming` | int | 0x7f1301f3 | 7287 |
| `message_failed_to_stop_living_publish` | int | 0x7f1301f4 | 7288 |
| `message_failed_to_Youtube_live_OAuth2AccessToken_is_null` | int | 0x7f1301ec | 7280 |
| `message_failed_to_Youtube_live_pushUrl_is_null` | int | 0x7f1301ed | 7281 |
| `message_failed_to_YouTube_live_shareUrl_is_null` | int | 0x7f1301eb | 7279 |
| `message_go_back_and_start_YouTube_live` | int | 0x7f1301f5 | 7289 |
| `message_loading` | int | 0x7f1301f6 | 7290 |
| `message_login_cancel` | int | 0x7f1301f7 | 7291 |
| `message_login_error` | int | 0x7f1301f8 | 7292 |
| `message_login_to_google_account` | int | 0x7f1301f9 | 7293 |
| `message_no_ble_service_discovered` | int | 0x7f1301fa | 7294 |
| `message_please_stop_live` | int | 0x7f1301fb | 7295 |
| `message_reconnect` | int | 0x7f1301fc | 7296 |
| `message_reconnect_timeout` | int | 0x7f1301fd | 7297 |
| `message_refreshAccessToken_IOException` | int | 0x7f1301fe | 7298 |
| `message_setup_false` | int | 0x7f1301ff | 7299 |
| `message_start_live` | int | 0x7f130200 | 7300 |
| `message_succeed_to_start_living_publish` | int | 0x7f130201 | 7301 |
| `message_succeed_to_stop_living_publish` | int | 0x7f130202 | 7302 |
| `messenger_send_button_text` | int | 0x7f130203 | 7303 |
| `microphone_mode` | int | 0x7f130204 | 7304 |
| `mode_headphone` | int | 0x7f130205 | 7305 |
| `mode_noumenon` | int | 0x7f130206 | 7306 |
| `more_settings` | int | 0x7f130207 | 7307 |
| `mpb` | int | 0x7f130208 | 7308 |
| `mtrl_badge_numberless_content_description` | int | 0x7f130209 | 7309 |
| `mtrl_button_collapsed_content_description` | int | 0x7f13020a | 7310 |
| `mtrl_button_expanded_content_description` | int | 0x7f13020b | 7311 |
| `mtrl_checkbox_button_icon_path_checked` | int | 0x7f13020c | 7312 |
| `mtrl_checkbox_button_icon_path_group_name` | int | 0x7f13020d | 7313 |
| `mtrl_checkbox_button_icon_path_indeterminate` | int | 0x7f13020e | 7314 |
| `mtrl_checkbox_button_icon_path_name` | int | 0x7f13020f | 7315 |
| `mtrl_checkbox_button_path_checked` | int | 0x7f130210 | 7316 |
| `mtrl_checkbox_button_path_group_name` | int | 0x7f130211 | 7317 |
| `mtrl_checkbox_button_path_name` | int | 0x7f130212 | 7318 |
| `mtrl_checkbox_button_path_unchecked` | int | 0x7f130213 | 7319 |
| `mtrl_checkbox_state_description_checked` | int | 0x7f130214 | 7320 |
| `mtrl_checkbox_state_description_indeterminate` | int | 0x7f130215 | 7321 |
| `mtrl_checkbox_state_description_unchecked` | int | 0x7f130216 | 7322 |
| `mtrl_chip_close_icon_content_description` | int | 0x7f130217 | 7323 |
| `mtrl_exceed_max_badge_number_content_description` | int | 0x7f130218 | 7324 |
| `mtrl_exceed_max_badge_number_suffix` | int | 0x7f130219 | 7325 |
| `mtrl_picker_a11y_next_month` | int | 0x7f13021a | 7326 |
| `mtrl_picker_a11y_prev_month` | int | 0x7f13021b | 7327 |
| `mtrl_picker_announce_current_range_selection` | int | 0x7f13021c | 7328 |
| `mtrl_picker_announce_current_selection` | int | 0x7f13021d | 7329 |
| `mtrl_picker_announce_current_selection_none` | int | 0x7f13021e | 7330 |
| `mtrl_picker_cancel` | int | 0x7f13021f | 7331 |
| `mtrl_picker_confirm` | int | 0x7f130220 | 7332 |
| `mtrl_picker_date_header_selected` | int | 0x7f130221 | 7333 |
| `mtrl_picker_date_header_title` | int | 0x7f130222 | 7334 |
| `mtrl_picker_date_header_unselected` | int | 0x7f130223 | 7335 |
| `mtrl_picker_day_of_week_column_header` | int | 0x7f130224 | 7336 |
| `mtrl_picker_end_date_description` | int | 0x7f130225 | 7337 |
| `mtrl_picker_invalid_format` | int | 0x7f130226 | 7338 |
| `mtrl_picker_invalid_format_example` | int | 0x7f130227 | 7339 |
| `mtrl_picker_invalid_format_use` | int | 0x7f130228 | 7340 |
| `mtrl_picker_invalid_range` | int | 0x7f130229 | 7341 |
| `mtrl_picker_navigate_to_current_year_description` | int | 0x7f13022a | 7342 |
| `mtrl_picker_navigate_to_year_description` | int | 0x7f13022b | 7343 |
| `mtrl_picker_out_of_range` | int | 0x7f13022c | 7344 |
| `mtrl_picker_range_header_only_end_selected` | int | 0x7f13022d | 7345 |
| `mtrl_picker_range_header_only_start_selected` | int | 0x7f13022e | 7346 |
| `mtrl_picker_range_header_selected` | int | 0x7f13022f | 7347 |
| `mtrl_picker_range_header_title` | int | 0x7f130230 | 7348 |
| `mtrl_picker_range_header_unselected` | int | 0x7f130231 | 7349 |
| `mtrl_picker_save` | int | 0x7f130232 | 7350 |
| `mtrl_picker_start_date_description` | int | 0x7f130233 | 7351 |
| `mtrl_picker_text_input_date_hint` | int | 0x7f130234 | 7352 |
| `mtrl_picker_text_input_date_range_end_hint` | int | 0x7f130235 | 7353 |
| `mtrl_picker_text_input_date_range_start_hint` | int | 0x7f130236 | 7354 |
| `mtrl_picker_text_input_day_abbr` | int | 0x7f130237 | 7355 |
| `mtrl_picker_text_input_month_abbr` | int | 0x7f130238 | 7356 |
| `mtrl_picker_text_input_year_abbr` | int | 0x7f130239 | 7357 |
| `mtrl_picker_today_description` | int | 0x7f13023a | 7358 |
| `mtrl_picker_toggle_to_calendar_input_mode` | int | 0x7f13023b | 7359 |
| `mtrl_picker_toggle_to_day_selection` | int | 0x7f13023c | 7360 |
| `mtrl_picker_toggle_to_text_input_mode` | int | 0x7f13023d | 7361 |
| `mtrl_picker_toggle_to_year_selection` | int | 0x7f13023e | 7362 |
| `mtrl_picker_toggled_to_day_selection` | int | 0x7f13023f | 7363 |
| `mtrl_picker_toggled_to_year_selection` | int | 0x7f130240 | 7364 |
| `mtrl_switch_thumb_group_name` | int | 0x7f130241 | 7365 |
| `mtrl_switch_thumb_path_checked` | int | 0x7f130242 | 7366 |
| `mtrl_switch_thumb_path_morphing` | int | 0x7f130243 | 7367 |
| `mtrl_switch_thumb_path_name` | int | 0x7f130244 | 7368 |
| `mtrl_switch_thumb_path_pressed` | int | 0x7f130245 | 7369 |
| `mtrl_switch_thumb_path_unchecked` | int | 0x7f130246 | 7370 |
| `mtrl_switch_track_decoration_path` | int | 0x7f130247 | 7371 |
| `mtrl_switch_track_path` | int | 0x7f130248 | 7372 |
| `mtrl_timepicker_cancel` | int | 0x7f130249 | 7373 |
| `mtrl_timepicker_confirm` | int | 0x7f13024a | 7374 |
| `multil_client_connection_tips` | int | 0x7f13024b | 7375 |
| `multil_client_talking_tips` | int | 0x7f13024c | 7376 |
| `multil_client_upgrade_tips` | int | 0x7f13024d | 7377 |
| `nav_rail_collapsed_a11y_label` | int | 0x7f13024e | 7378 |
| `nav_rail_expanded_a11y_label` | int | 0x7f13024f | 7379 |
| `navigation_drawer_close` | int | 0x7f130250 | 7380 |
| `navigation_drawer_open` | int | 0x7f130251 | 7381 |
| `nearby_camera` | int | 0x7f130252 | 7382 |
| `need_permition` | int | 0x7f130253 | 7383 |
| `network_error_please_check` | int | 0x7f130254 | 7384 |
| `no_connect` | int | 0x7f130255 | 7385 |
| `no_content` | int | 0x7f130256 | 7386 |
| `no_data` | int | 0x7f130257 | 7387 |
| `no_files_found` | int | 0x7f130258 | 7388 |
| `no_net` | int | 0x7f130259 | 7389 |
| `no_pics` | int | 0x7f13025a | 7390 |
| `no_url` | int | 0x7f13025b | 7391 |
| `no_video` | int | 0x7f13025c | 7392 |
| `non_360_picture_not_support_switch` | int | 0x7f13025d | 7393 |
| `none` | int | 0x7f13025e | 7394 |
| `not_support_preview` | int | 0x7f13025f | 7395 |
| `off` | int | 0x7f130260 | 7396 |
| `ok` | int | 0x7f130261 | 7397 |
| `once_download_five` | int | 0x7f130262 | 7398 |
| `open_preview_failed` | int | 0x7f130263 | 7399 |
| `over_down_check_wifi` | int | 0x7f130264 | 7400 |
| `password_limit` | int | 0x7f130265 | 7401 |
| `password_toggle_content_description` | int | 0x7f130266 | 7402 |
| `path_password_eye` | int | 0x7f130267 | 7403 |
| `path_password_eye_mask_strike_through` | int | 0x7f130268 | 7404 |
| `path_password_eye_mask_visible` | int | 0x7f130269 | 7405 |
| `path_password_strike_through` | int | 0x7f13026a | 7406 |
| `pause_record` | int | 0x7f13026b | 7407 |
| `pb_video` | int | 0x7f13026c | 7408 |
| `permission_is_denied_info` | int | 0x7f13026d | 7409 |
| `photo` | int | 0x7f13026e | 7410 |
| `photo_definition` | int | 0x7f13026f | 7411 |
| `pickerview_cancel` | int | 0x7f130270 | 7412 |
| `pickerview_day` | int | 0x7f130271 | 7413 |
| `pickerview_hours` | int | 0x7f130272 | 7414 |
| `pickerview_minutes` | int | 0x7f130273 | 7415 |
| `pickerview_month` | int | 0x7f130274 | 7416 |
| `pickerview_seconds` | int | 0x7f130275 | 7417 |
| `pickerview_submit` | int | 0x7f130276 | 7418 |
| `pickerview_year` | int | 0x7f130277 | 7419 |
| `please_choose_headset` | int | 0x7f130278 | 7420 |
| `please_open_wifi` | int | 0x7f130279 | 7421 |
| `please_open_wifi_tips` | int | 0x7f13027a | 7422 |
| `please_set_the_correct_resolution_and_fps` | int | 0x7f13027b | 7423 |
| `plug_in_headset` | int | 0x7f13027c | 7424 |
| `preview` | int | 0x7f13027d | 7425 |
| `ptp_connected` | int | 0x7f13027e | 7426 |
| `pull_to_refresh_from_bottom_pull_label` | int | 0x7f13027f | 7427 |
| `pull_to_refresh_from_bottom_refreshing_label` | int | 0x7f130280 | 7428 |
| `pull_to_refresh_from_bottom_release_label` | int | 0x7f130281 | 7429 |
| `pull_to_refresh_pull_label` | int | 0x7f130282 | 7430 |
| `pull_to_refresh_refreshing_label` | int | 0x7f130283 | 7431 |
| `pull_to_refresh_release_label` | int | 0x7f130284 | 7432 |
| `rear_lens_mirror_image` | int | 0x7f130285 | 7433 |
| `record_time` | int | 0x7f130286 | 7434 |
| `recording` | int | 0x7f130287 | 7435 |
| `refresh_token` | int | 0x7f130288 | 7436 |
| `remote_file` | int | 0x7f130289 | 7437 |
| `replay` | int | 0x7f13028a | 7438 |
| `request_camera_permission_warn_info` | int | 0x7f13028b | 7439 |
| `reset_device` | int | 0x7f13028c | 7440 |
| `reset_device_hint_info` | int | 0x7f13028d | 7441 |
| `reset_device_ing` | int | 0x7f13028e | 7442 |
| `return_app_then_use` | int | 0x7f13028f | 7443 |
| `save_to_album` | int | 0x7f130290 | 7444 |
| `saved_photos` | int | 0x7f130291 | 7445 |
| `saving_file` | int | 0x7f130292 | 7446 |
| `sd_saved_space` | int | 0x7f130293 | 7447 |
| `search_menu_title` | int | 0x7f130294 | 7448 |
| `search_wifi_list_then_connect` | int | 0x7f130295 | 7449 |
| `searchbar_scrolling_view_behavior` | int | 0x7f130296 | 7450 |
| `searchview_clear_text_content_description` | int | 0x7f130297 | 7451 |
| `searchview_navigation_content_description` | int | 0x7f130298 | 7452 |
| `select` | int | 0x7f130299 | 7453 |
| `select_files` | int | 0x7f13029a | 7454 |
| `select_need_delete_file` | int | 0x7f13029b | 7455 |
| `select_need_download_file` | int | 0x7f13029c | 7456 |
| `setting` | int | 0x7f13029d | 7457 |
| `setting_about` | int | 0x7f13029e | 7458 |
| `setting_app_version` | int | 0x7f13029f | 7459 |
| `setting_audio_switch` | int | 0x7f1302a0 | 7460 |
| `setting_auto_download` | int | 0x7f1302a1 | 7461 |
| `setting_auto_download_size_limit` | int | 0x7f1302a2 | 7462 |
| `setting_burst_interval` | int | 0x7f1302a3 | 7463 |
| `setting_burst_set` | int | 0x7f1302a4 | 7464 |
| `setting_camera_back` | int | 0x7f1302a5 | 7465 |
| `setting_camera_front` | int | 0x7f1302a6 | 7466 |
| `setting_cap_timescape_duration` | int | 0x7f1302a7 | 7467 |
| `setting_cap_timescape_interval` | int | 0x7f1302a8 | 7468 |
| `setting_capture_delay` | int | 0x7f1302a9 | 7469 |
| `setting_car_mode_set` | int | 0x7f1302aa | 7470 |
| `setting_card_removed` | int | 0x7f1302ab | 7471 |
| `setting_datestamp` | int | 0x7f1302ac | 7472 |
| `setting_enable_wifi_hotspot` | int | 0x7f1302ad | 7473 |
| `setting_firmware_version` | int | 0x7f1302ae | 7474 |
| `setting_format` | int | 0x7f1302af | 7475 |
| `setting_format_confirm` | int | 0x7f1302b0 | 7476 |
| `setting_format_desc` | int | 0x7f1302b1 | 7477 |
| `setting_formating` | int | 0x7f1302b2 | 7478 |
| `setting_formatted` | int | 0x7f1302b3 | 7479 |
| `setting_image_size` | int | 0x7f1302b4 | 7480 |
| `setting_internal_storage` | int | 0x7f1302b5 | 7481 |
| `setting_live_address` | int | 0x7f1302b6 | 7482 |
| `setting_live_switch` | int | 0x7f1302b7 | 7483 |
| `setting_no` | int | 0x7f1302b8 | 7484 |
| `setting_no_sd` | int | 0x7f1302b9 | 7485 |
| `setting_off` | int | 0x7f1302ba | 7486 |
| `setting_on` | int | 0x7f1302bb | 7487 |
| `setting_power_supply` | int | 0x7f1302bc | 7488 |
| `setting_preview_cache_duration` | int | 0x7f1302bd | 7489 |
| `setting_product_name` | int | 0x7f1302be | 7490 |
| `setting_sd_card_storage` | int | 0x7f1302bf | 7491 |
| `setting_slow_mo` | int | 0x7f1302c0 | 7492 |
| `setting_slow_motion_set` | int | 0x7f1302c1 | 7493 |
| `setting_storage_location` | int | 0x7f1302c2 | 7494 |
| `setting_success` | int | 0x7f1302c3 | 7495 |
| `setting_time_lapse_duration` | int | 0x7f1302c4 | 7496 |
| `setting_time_lapse_duration_10M` | int | 0x7f1302c5 | 7497 |
| `setting_time_lapse_duration_15M` | int | 0x7f1302c6 | 7498 |
| `setting_time_lapse_duration_20M` | int | 0x7f1302c7 | 7499 |
| `setting_time_lapse_duration_2M` | int | 0x7f1302c8 | 7500 |
| `setting_time_lapse_duration_30M` | int | 0x7f1302c9 | 7501 |
| `setting_time_lapse_duration_5M` | int | 0x7f1302ca | 7502 |
| `setting_time_lapse_duration_60M` | int | 0x7f1302cb | 7503 |
| `setting_time_lapse_duration_unlimit` | int | 0x7f1302cc | 7504 |
| `setting_time_lapse_interval` | int | 0x7f1302cd | 7505 |
| `setting_time_lapse_interval_10M` | int | 0x7f1302ce | 7506 |
| `setting_time_lapse_interval_10s` | int | 0x7f1302cf | 7507 |
| `setting_time_lapse_interval_1HR` | int | 0x7f1302d0 | 7508 |
| `setting_time_lapse_interval_1M` | int | 0x7f1302d1 | 7509 |
| `setting_time_lapse_interval_20s` | int | 0x7f1302d2 | 7510 |
| `setting_time_lapse_interval_2s` | int | 0x7f1302d3 | 7511 |
| `setting_time_lapse_interval_30M` | int | 0x7f1302d4 | 7512 |
| `setting_time_lapse_interval_30s` | int | 0x7f1302d5 | 7513 |
| `setting_time_lapse_interval_5M` | int | 0x7f1302d6 | 7514 |
| `setting_time_lapse_interval_5s` | int | 0x7f1302d7 | 7515 |
| `setting_time_lapse_interval_off` | int | 0x7f1302d8 | 7516 |
| `setting_timelapse_set` | int | 0x7f1302d9 | 7517 |
| `setting_title_auto_power_off` | int | 0x7f1302da | 7518 |
| `setting_title_camera_switch` | int | 0x7f1302db | 7519 |
| `setting_title_choose_wifi` | int | 0x7f1302dc | 7520 |
| `setting_title_exposure_compensation` | int | 0x7f1302dd | 7521 |
| `setting_title_fast_motion_movie` | int | 0x7f1302de | 7522 |
| `setting_title_image_stabilization` | int | 0x7f1302df | 7523 |
| `setting_title_power_on_auto_record` | int | 0x7f1302e0 | 7524 |
| `setting_title_screen_saver` | int | 0x7f1302e1 | 7525 |
| `setting_title_stream` | int | 0x7f1302e2 | 7526 |
| `setting_title_video_file_length` | int | 0x7f1302e3 | 7527 |
| `setting_title_wind_noise_reduction` | int | 0x7f1302e4 | 7528 |
| `setting_type_custom` | int | 0x7f1302e5 | 7529 |
| `setting_type_other` | int | 0x7f1302e6 | 7530 |
| `setting_update_fw` | int | 0x7f1302e8 | 7532 |
| `setting_updatefw_chec_sum_failed` | int | 0x7f1302e9 | 7533 |
| `setting_updatefw_closeAppInfo` | int | 0x7f1302ea | 7534 |
| `setting_updatefw_completedInfo` | int | 0x7f1302eb | 7535 |
| `setting_updatefw_failed` | int | 0x7f1302ec | 7536 |
| `setting_updatefw_failedInfo` | int | 0x7f1302ed | 7537 |
| `setting_updatefw_no_resource` | int | 0x7f1302ee | 7538 |
| `setting_updateFW_prompt` | int | 0x7f1302e7 | 7531 |
| `setting_updatefw_start` | int | 0x7f1302ef | 7539 |
| `setting_updatefw_success` | int | 0x7f1302f0 | 7540 |
| `setting_updatefw_title` | int | 0x7f1302f1 | 7541 |
| `setting_updatefw_upgrade_file_not_exist` | int | 0x7f1302f2 | 7542 |
| `setting_used` | int | 0x7f1302f3 | 7543 |
| `setting_vid_timescape_duration` | int | 0x7f1302f4 | 7544 |
| `setting_vid_timescape_interval` | int | 0x7f1302f5 | 7545 |
| `setting_video_size` | int | 0x7f1302f6 | 7546 |
| `setting_wait` | int | 0x7f1302f7 | 7547 |
| `setting_yes` | int | 0x7f1302f8 | 7548 |
| `side_sheet_accessibility_pane_title` | int | 0x7f1302f9 | 7549 |
| `side_sheet_behavior` | int | 0x7f1302fa | 7550 |
| `sign_out` | int | 0x7f1302fb | 7551 |
| `signed_in` | int | 0x7f1302fc | 7552 |
| `signed_out` | int | 0x7f1302fd | 7553 |
| `signing_in` | int | 0x7f1302fe | 7554 |
| `slowmotion` | int | 0x7f1302ff | 7555 |
| `software_protocol` | int | 0x7f130300 | 7556 |
| `spb` | int | 0x7f130301 | 7557 |
| `start_record` | int | 0x7f130302 | 7558 |
| `start_youtube_live` | int | 0x7f130303 | 7559 |
| `state_camera` | int | 0x7f130304 | 7560 |
| `state_record` | int | 0x7f130305 | 7561 |
| `status_bar_notification_info_overflow` | int | 0x7f130306 | 7562 |
| `step_one` | int | 0x7f130307 | 7563 |
| `step_three` | int | 0x7f130308 | 7564 |
| `step_two` | int | 0x7f130309 | 7565 |
| `stop_live_hint` | int | 0x7f13030a | 7566 |
| `stop_other_live_hint` | int | 0x7f13030b | 7567 |
| `stream_capture_failed` | int | 0x7f13030c | 7568 |
| `stream_capturing` | int | 0x7f13030d | 7569 |
| `stream_error_cannot_open_gallery` | int | 0x7f13030e | 7570 |
| `stream_error_capturing` | int | 0x7f13030f | 7571 |
| `stream_error_capturing_capture` | int | 0x7f130310 | 7572 |
| `stream_error_not_enough_space` | int | 0x7f130311 | 7573 |
| `stream_error_recording` | int | 0x7f130312 | 7574 |
| `stream_exit_recording` | int | 0x7f130313 | 7575 |
| `stream_exit_wait` | int | 0x7f130314 | 7576 |
| `stream_exiting` | int | 0x7f130315 | 7577 |
| `stream_failed` | int | 0x7f130316 | 7578 |
| `stream_reconnect` | int | 0x7f130317 | 7579 |
| `stream_set_complete` | int | 0x7f130318 | 7580 |
| `stream_set_error` | int | 0x7f130319 | 7581 |
| `stream_set_res_photo` | int | 0x7f13031a | 7582 |
| `stream_set_res_vid` | int | 0x7f13031b | 7583 |
| `stream_set_timer` | int | 0x7f13031c | 7584 |
| `stream_set_timer_off` | int | 0x7f13031d | 7585 |
| `stream_title` | int | 0x7f13031e | 7586 |
| `stream_wait_for_video` | int | 0x7f13031f | 7587 |
| `stream_zoom_wait` | int | 0x7f130320 | 7588 |
| `submit` | int | 0x7f130321 | 7589 |
| `submiting_feedback_content_waiting` | int | 0x7f130322 | 7590 |
| `take_photo_ing_wait` | int | 0x7f130323 | 7591 |
| `take_photo_success` | int | 0x7f130324 | 7592 |
| `take_photos` | int | 0x7f130325 | 7593 |
| `take_pictures` | int | 0x7f130326 | 7594 |
| `text_add_camaera_usb` | int | 0x7f130327 | 7595 |
| `text_add_new_camera` | int | 0x7f130328 | 7596 |
| `text_agree` | int | 0x7f130329 | 7597 |
| `text_asteroid` | int | 0x7f13032a | 7598 |
| `text_auto_connect_tips` | int | 0x7f13032b | 7599 |
| `text_ble_devices` | int | 0x7f13032c | 7600 |
| `text_btpair` | int | 0x7f13032d | 7601 |
| `text_btpair_already_connect_cam` | int | 0x7f13032e | 7602 |
| `text_btpair_auto_connect_wifi` | int | 0x7f13032f | 7603 |
| `text_btpair_auto_connect_wifi_btn` | int | 0x7f130330 | 7604 |
| `text_btpair_connect_cam` | int | 0x7f130331 | 7605 |
| `text_btpair_connect_operationsteps` | int | 0x7f130332 | 7606 |
| `text_btpair_connect_wifi` | int | 0x7f130333 | 7607 |
| `text_btpair_done` | int | 0x7f130334 | 7608 |
| `text_btpair_next` | int | 0x7f130335 | 7609 |
| `text_btpair_search_ble` | int | 0x7f130336 | 7610 |
| `text_btpair_search_camera` | int | 0x7f130337 | 7611 |
| `text_btpair_setup` | int | 0x7f130338 | 7612 |
| `text_btpair_setup_camwifi` | int | 0x7f130339 | 7613 |
| `text_btpair_skip` | int | 0x7f13033a | 7614 |
| `text_btpair_support_bt` | int | 0x7f13033b | 7615 |
| `text_btpair_try_again` | int | 0x7f13033c | 7616 |
| `text_camera_connected` | int | 0x7f13033d | 7617 |
| `text_camera_connection_failed` | int | 0x7f13033e | 7618 |
| `text_camera_has_been_registered` | int | 0x7f13033f | 7619 |
| `text_camera_is_connecting` | int | 0x7f130340 | 7620 |
| `text_camera_not_ready` | int | 0x7f130341 | 7621 |
| `text_classic_bluetooth_devices` | int | 0x7f130342 | 7622 |
| `text_connect_camera_by_usb` | int | 0x7f130343 | 7623 |
| `text_connected` | int | 0x7f130344 | 7624 |
| `text_disagree` | int | 0x7f130345 | 7625 |
| `text_disconnect` | int | 0x7f130346 | 7626 |
| `text_exception_info` | int | 0x7f130347 | 7627 |
| `text_file_length_unlimited` | int | 0x7f130348 | 7628 |
| `text_hint_pwd_needed` | int | 0x7f130349 | 7629 |
| `text_in_clipboard` | int | 0x7f13034a | 7630 |
| `text_init_failed` | int | 0x7f13034b | 7631 |
| `text_not_support_preview` | int | 0x7f13034c | 7632 |
| `text_operation_failed` | int | 0x7f13034d | 7633 |
| `text_operation_success` | int | 0x7f13034e | 7634 |
| `text_otg_tips` | int | 0x7f13034f | 7635 |
| `text_panorama` | int | 0x7f130350 | 7636 |
| `text_password` | int | 0x7f130351 | 7637 |
| `text_please_connect_camera` | int | 0x7f130352 | 7638 |
| `text_ready_pair` | int | 0x7f130353 | 7639 |
| `text_reconnect_timeout` | int | 0x7f130354 | 7640 |
| `text_resolution_adjust` | int | 0x7f130355 | 7641 |
| `text_resolution_lowest` | int | 0x7f130356 | 7642 |
| `text_return` | int | 0x7f130357 | 7643 |
| `text_rich_media_management_center` | int | 0x7f130358 | 7644 |
| `text_sd_card_memory_shortage` | int | 0x7f130359 | 7645 |
| `text_selected` | int | 0x7f13035a | 7646 |
| `text_stablization` | int | 0x7f13035b | 7647 |
| `text_stream_launch_failed` | int | 0x7f13035c | 7648 |
| `text_usb_device_detected` | int | 0x7f13035d | 7649 |
| `text_usb_device_disconnected` | int | 0x7f13035e | 7650 |
| `text_usb_device_not_detected` | int | 0x7f13035f | 7651 |
| `text_usb_permission_has_been_denied` | int | 0x7f130360 | 7652 |
| `text_vr` | int | 0x7f130361 | 7653 |
| `time_imprint` | int | 0x7f130366 | 7658 |
| `time_minutes` | int | 0x7f130367 | 7659 |
| `timeLapse_capture_mode` | int | 0x7f130362 | 7654 |
| `timeLapse_not_allow` | int | 0x7f130363 | 7655 |
| `timeLapse_stop` | int | 0x7f130364 | 7656 |
| `timeLapse_video_mode` | int | 0x7f130365 | 7657 |
| `tips_not_wifi` | int | 0x7f130368 | 7660 |
| `tips_not_wifi_cancel` | int | 0x7f130369 | 7661 |
| `tips_not_wifi_confirm` | int | 0x7f13036a | 7662 |
| `titie_cancel` | int | 0x7f13036b | 7663 |
| `title_activity_add_new_cam` | int | 0x7f13036c | 7664 |
| `title_activity_local_pb` | int | 0x7f13036d | 7665 |
| `title_activity_local_photo` | int | 0x7f13036e | 7666 |
| `title_activity_local_photo_wall` | int | 0x7f13036f | 7667 |
| `title_activity_local_video` | int | 0x7f130370 | 7668 |
| `title_activity_local_video_wall` | int | 0x7f130371 | 7669 |
| `title_activity_multi_pb` | int | 0x7f130372 | 7670 |
| `title_activity_panorama_photo_pb` | int | 0x7f130373 | 7671 |
| `title_activity_panorama_video_pb` | int | 0x7f130374 | 7672 |
| `title_activity_pb_local_video` | int | 0x7f130375 | 7673 |
| `title_activity_photo_pb` | int | 0x7f130376 | 7674 |
| `title_activity_preview` | int | 0x7f130377 | 7675 |
| `title_activity_pv_param_setting` | int | 0x7f130378 | 7676 |
| `title_activity_usbpreview` | int | 0x7f130379 | 7677 |
| `title_activity_video_pb` | int | 0x7f13037a | 7678 |
| `title_audio_switch` | int | 0x7f13037b | 7679 |
| `title_awb` | int | 0x7f13037c | 7680 |
| `title_burst` | int | 0x7f13037d | 7681 |
| `title_car_mode` | int | 0x7f13037e | 7682 |
| `title_delay_capture` | int | 0x7f13037f | 7683 |
| `title_emergency` | int | 0x7f130380 | 7684 |
| `title_emergency_video` | int | 0x7f130381 | 7685 |
| `title_fragment_btpair_begin` | int | 0x7f130382 | 7686 |
| `title_fragment_btpair_completed` | int | 0x7f130383 | 7687 |
| `title_fragment_btpair_wifisetup` | int | 0x7f130384 | 7688 |
| `title_local_media` | int | 0x7f130385 | 7689 |
| `title_ok` | int | 0x7f130386 | 7690 |
| `title_photo` | int | 0x7f130387 | 7691 |
| `title_photo_size` | int | 0x7f130388 | 7692 |
| `title_preview` | int | 0x7f130389 | 7693 |
| `title_privacy_policy` | int | 0x7f13038a | 7694 |
| `title_setting` | int | 0x7f13038b | 7695 |
| `title_slow_motion` | int | 0x7f13038c | 7696 |
| `title_text` | int | 0x7f13038d | 7697 |
| `title_timeLapse_mode` | int | 0x7f13038e | 7698 |
| `title_video` | int | 0x7f13038f | 7699 |
| `title_video_size` | int | 0x7f130390 | 7700 |
| `title_warning` | int | 0x7f130391 | 7701 |
| `toast_device_offline` | int | 0x7f130392 | 7702 |
| `trip_recorder` | int | 0x7f130393 | 7703 |
| `turn_on_location_information_tips` | int | 0x7f130394 | 7704 |
| `turn_on_mobile_data` | int | 0x7f130395 | 7705 |
| `type_grid_view` | int | 0x7f130396 | 7706 |
| `type_list_view` | int | 0x7f130397 | 7707 |
| `type_quick_list_view` | int | 0x7f130398 | 7708 |
| `unable_to_determine_region_try_again` | int | 0x7f130399 | 7709 |
| `unsupported_mode` | int | 0x7f13039a | 7710 |
| `upside` | int | 0x7f13039b | 7711 |
| `version_info` | int | 0x7f13039c | 7712 |
| `version_upgrade` | int | 0x7f13039d | 7713 |
| `version_upgrade_info` | int | 0x7f13039e | 7714 |
| `video_definition` | int | 0x7f13039f | 7715 |
| `video_format_not_support` | int | 0x7f1303a0 | 7716 |
| `video_frame_rate` | int | 0x7f1303a1 | 7717 |
| `video_loading_failed` | int | 0x7f1303a2 | 7718 |
| `video_normal` | int | 0x7f1303a3 | 7719 |
| `video_play_err` | int | 0x7f1303a4 | 7720 |
| `video_quality` | int | 0x7f1303a5 | 7721 |
| `video_resolution` | int | 0x7f1303a6 | 7722 |
| `video_warning` | int | 0x7f1303a7 | 7723 |
| `video_watermarking` | int | 0x7f1303a8 | 7724 |
| `wait` | int | 0x7f1303a9 | 7725 |
| `warm_reminder` | int | 0x7f1303aa | 7726 |
| `warm_reminder_content` | int | 0x7f1303ab | 7727 |
| `wb_auto` | int | 0x7f1303ac | 7728 |
| `wb_cloudy` | int | 0x7f1303ad | 7729 |
| `wb_daylight` | int | 0x7f1303ae | 7730 |
| `wb_fluorescent` | int | 0x7f1303af | 7731 |
| `wb_incandescent` | int | 0x7f1303b0 | 7732 |
| `welcome_agree` | int | 0x7f1303b1 | 7733 |
| `welcome_exit_idCam` | int | 0x7f1303b2 | 7734 |
| `welcome_introduce` | int | 0x7f1303b3 | 7735 |
| `whether_delete_lacal_file` | int | 0x7f1303b4 | 7736 |
| `whether_format_device` | int | 0x7f1303b5 | 7737 |
| `whether_stop_download` | int | 0x7f1303b6 | 7738 |
| `wifi_auto_connect_cannot_used` | int | 0x7f1303b7 | 7739 |
| `wifi_hotspot_open_failed_info` | int | 0x7f1303b8 | 7740 |
| `wifi_or_password_cannot_be_empty` | int | 0x7f1303b9 | 7741 |

### `com.id221.golive.R$style`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `Album` | int | 0x7f140000 | 7745 |
| `Album_AppBar` | int | 0x7f140001 | 7746 |
| `Album_AppBar_General` | int | 0x7f140002 | 7747 |
| `Album_AppBar_General_Transparent` | int | 0x7f140003 | 7748 |
| `Album_Button` | int | 0x7f140004 | 7749 |
| `Album_Button_WrapContent` | int | 0x7f140005 | 7750 |
| `Album_CheckBox` | int | 0x7f140006 | 7751 |
| `Album_CheckBox_WrapContent` | int | 0x7f140007 | 7752 |
| `Album_Dialog` | int | 0x7f140008 | 7753 |
| `Album_Dialog_Folder` | int | 0x7f140009 | 7754 |
| `Album_Item` | int | 0x7f14000a | 7755 |
| `Album_Item_Card` | int | 0x7f14000b | 7756 |
| `Album_Item_Card_MatchParent` | int | 0x7f14000c | 7757 |
| `Album_MatchParent` | int | 0x7f14000d | 7758 |
| `Album_MatchParent_SheetBottom` | int | 0x7f14000e | 7759 |
| `Album_Progress` | int | 0x7f14000f | 7760 |
| `Album_Progress_Loading` | int | 0x7f140010 | 7761 |
| `Album_TextButton` | int | 0x7f140011 | 7762 |
| `Album_TextButton_WrapContent` | int | 0x7f140012 | 7763 |
| `Album_TextButton_WrapContent_SheetBottom` | int | 0x7f140013 | 7764 |
| `Album_Theme` | int | 0x7f140014 | 7765 |
| `Album_Theme_Activity` | int | 0x7f140015 | 7766 |
| `Album_Theme_Activity_Transparent` | int | 0x7f140016 | 7767 |
| `Album_Theme_Button` | int | 0x7f140017 | 7768 |
| `Album_Theme_Toolbar` | int | 0x7f140018 | 7769 |
| `Album_Theme_Toolbar_Dark` | int | 0x7f140019 | 7770 |
| `Album_Theme_Toolbar_Light` | int | 0x7f14001a | 7771 |
| `Album_Theme_Toolbar_Popup` | int | 0x7f14001b | 7772 |
| `Album_Toolbar` | int | 0x7f14001c | 7773 |
| `Album_Toolbar_Dark` | int | 0x7f14001d | 7774 |
| `Album_Toolbar_Light` | int | 0x7f14001e | 7775 |
| `Album_WrapContent` | int | 0x7f14001f | 7776 |
| `Album_WrapContent_Transfer` | int | 0x7f140020 | 7777 |
| `Album_WrapContent_WidthMatchParent` | int | 0x7f140021 | 7778 |
| `AlertDialog` | int | 0x7f140022 | 7779 |
| `AlertDialog_AppCompat` | int | 0x7f140023 | 7780 |
| `AlertDialog_AppCompat_Light` | int | 0x7f140024 | 7781 |
| `Animation_AppCompat_Dialog` | int | 0x7f140025 | 7782 |
| `Animation_AppCompat_DropDownUp` | int | 0x7f140026 | 7783 |
| `Animation_AppCompat_Tooltip` | int | 0x7f140027 | 7784 |
| `Animation_Design_BottomSheetDialog` | int | 0x7f140028 | 7785 |
| `Animation_Material3_BottomSheetDialog` | int | 0x7f140029 | 7786 |
| `Animation_Material3_SideSheetDialog` | int | 0x7f14002a | 7787 |
| `Animation_Material3_SideSheetDialog_Left` | int | 0x7f14002b | 7788 |
| `Animation_Material3_SideSheetDialog_Right` | int | 0x7f14002c | 7789 |
| `Animation_MaterialComponents_BottomSheetDialog` | int | 0x7f14002d | 7790 |
| `AppTheme` | int | 0x7f14002e | 7791 |
| `AppTheme_AppBarOverlay` | int | 0x7f14002f | 7792 |
| `AppTheme_NoActionBar` | int | 0x7f140030 | 7793 |
| `AppTheme_PopupOverlay` | int | 0x7f140031 | 7794 |
| `Base_AlertDialog_AppCompat` | int | 0x7f140032 | 7795 |
| `Base_AlertDialog_AppCompat_Light` | int | 0x7f140033 | 7796 |
| `Base_Animation_AppCompat_Dialog` | int | 0x7f140034 | 7797 |
| `Base_Animation_AppCompat_DropDownUp` | int | 0x7f140035 | 7798 |
| `Base_Animation_AppCompat_Tooltip` | int | 0x7f140036 | 7799 |
| `Base_CardView` | int | 0x7f140037 | 7800 |
| `base_common_dialog_style` | int | 0x7f140539 | 9082 |
| `Base_DialogWindowTitle_AppCompat` | int | 0x7f140038 | 7801 |
| `Base_DialogWindowTitleBackground_AppCompat` | int | 0x7f140039 | 7802 |
| `Base_MaterialAlertDialog_MaterialComponents_Title_Icon` | int | 0x7f14003a | 7803 |
| `Base_MaterialAlertDialog_MaterialComponents_Title_Panel` | int | 0x7f14003b | 7804 |
| `Base_MaterialAlertDialog_MaterialComponents_Title_Text` | int | 0x7f14003c | 7805 |
| `Base_TextAppearance_AppCompat` | int | 0x7f14003d | 7806 |
| `Base_TextAppearance_AppCompat_Body1` | int | 0x7f14003e | 7807 |
| `Base_TextAppearance_AppCompat_Body2` | int | 0x7f14003f | 7808 |
| `Base_TextAppearance_AppCompat_Button` | int | 0x7f140040 | 7809 |
| `Base_TextAppearance_AppCompat_Caption` | int | 0x7f140041 | 7810 |
| `Base_TextAppearance_AppCompat_Display1` | int | 0x7f140042 | 7811 |
| `Base_TextAppearance_AppCompat_Display2` | int | 0x7f140043 | 7812 |
| `Base_TextAppearance_AppCompat_Display3` | int | 0x7f140044 | 7813 |
| `Base_TextAppearance_AppCompat_Display4` | int | 0x7f140045 | 7814 |
| `Base_TextAppearance_AppCompat_Headline` | int | 0x7f140046 | 7815 |
| `Base_TextAppearance_AppCompat_Inverse` | int | 0x7f140047 | 7816 |
| `Base_TextAppearance_AppCompat_Large` | int | 0x7f140048 | 7817 |
| `Base_TextAppearance_AppCompat_Large_Inverse` | int | 0x7f140049 | 7818 |
| `Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Large` | int | 0x7f14004a | 7819 |
| `Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Small` | int | 0x7f14004b | 7820 |
| `Base_TextAppearance_AppCompat_Medium` | int | 0x7f14004c | 7821 |
| `Base_TextAppearance_AppCompat_Medium_Inverse` | int | 0x7f14004d | 7822 |
| `Base_TextAppearance_AppCompat_Menu` | int | 0x7f14004e | 7823 |
| `Base_TextAppearance_AppCompat_SearchResult` | int | 0x7f14004f | 7824 |
| `Base_TextAppearance_AppCompat_SearchResult_Subtitle` | int | 0x7f140050 | 7825 |
| `Base_TextAppearance_AppCompat_SearchResult_Title` | int | 0x7f140051 | 7826 |
| `Base_TextAppearance_AppCompat_Small` | int | 0x7f140052 | 7827 |
| `Base_TextAppearance_AppCompat_Small_Inverse` | int | 0x7f140053 | 7828 |
| `Base_TextAppearance_AppCompat_Subhead` | int | 0x7f140054 | 7829 |
| `Base_TextAppearance_AppCompat_Subhead_Inverse` | int | 0x7f140055 | 7830 |
| `Base_TextAppearance_AppCompat_Title` | int | 0x7f140056 | 7831 |
| `Base_TextAppearance_AppCompat_Title_Inverse` | int | 0x7f140057 | 7832 |
| `Base_TextAppearance_AppCompat_Tooltip` | int | 0x7f140058 | 7833 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Menu` | int | 0x7f140059 | 7834 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle` | int | 0x7f14005a | 7835 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse` | int | 0x7f14005b | 7836 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Title` | int | 0x7f14005c | 7837 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse` | int | 0x7f14005d | 7838 |
| `Base_TextAppearance_AppCompat_Widget_ActionMode_Subtitle` | int | 0x7f14005e | 7839 |
| `Base_TextAppearance_AppCompat_Widget_ActionMode_Title` | int | 0x7f14005f | 7840 |
| `Base_TextAppearance_AppCompat_Widget_Button` | int | 0x7f140060 | 7841 |
| `Base_TextAppearance_AppCompat_Widget_Button_Borderless_Colored` | int | 0x7f140061 | 7842 |
| `Base_TextAppearance_AppCompat_Widget_Button_Colored` | int | 0x7f140062 | 7843 |
| `Base_TextAppearance_AppCompat_Widget_Button_Inverse` | int | 0x7f140063 | 7844 |
| `Base_TextAppearance_AppCompat_Widget_DropDownItem` | int | 0x7f140064 | 7845 |
| `Base_TextAppearance_AppCompat_Widget_PopupMenu_Header` | int | 0x7f140065 | 7846 |
| `Base_TextAppearance_AppCompat_Widget_PopupMenu_Large` | int | 0x7f140066 | 7847 |
| `Base_TextAppearance_AppCompat_Widget_PopupMenu_Small` | int | 0x7f140067 | 7848 |
| `Base_TextAppearance_AppCompat_Widget_Switch` | int | 0x7f140068 | 7849 |
| `Base_TextAppearance_AppCompat_Widget_TextView_SpinnerItem` | int | 0x7f140069 | 7850 |
| `Base_TextAppearance_Material3_Search` | int | 0x7f14006a | 7851 |
| `Base_TextAppearance_MaterialComponents_Button` | int | 0x7f14006b | 7852 |
| `Base_TextAppearance_MaterialComponents_Headline6` | int | 0x7f14006c | 7853 |
| `Base_TextAppearance_MaterialComponents_Subtitle2` | int | 0x7f14006d | 7854 |
| `Base_TextAppearance_Widget_AppCompat_ExpandedMenu_Item` | int | 0x7f14006e | 7855 |
| `Base_TextAppearance_Widget_AppCompat_Toolbar_Subtitle` | int | 0x7f14006f | 7856 |
| `Base_TextAppearance_Widget_AppCompat_Toolbar_Title` | int | 0x7f140070 | 7857 |
| `Base_Theme_AppCompat` | int | 0x7f140071 | 7858 |
| `Base_Theme_AppCompat_CompactMenu` | int | 0x7f140072 | 7859 |
| `Base_Theme_AppCompat_Dialog` | int | 0x7f140073 | 7860 |
| `Base_Theme_AppCompat_Dialog_Alert` | int | 0x7f140074 | 7861 |
| `Base_Theme_AppCompat_Dialog_FixedSize` | int | 0x7f140075 | 7862 |
| `Base_Theme_AppCompat_Dialog_MinWidth` | int | 0x7f140076 | 7863 |
| `Base_Theme_AppCompat_DialogWhenLarge` | int | 0x7f140077 | 7864 |
| `Base_Theme_AppCompat_Light` | int | 0x7f140078 | 7865 |
| `Base_Theme_AppCompat_Light_DarkActionBar` | int | 0x7f140079 | 7866 |
| `Base_Theme_AppCompat_Light_Dialog` | int | 0x7f14007a | 7867 |
| `Base_Theme_AppCompat_Light_Dialog_Alert` | int | 0x7f14007b | 7868 |
| `Base_Theme_AppCompat_Light_Dialog_FixedSize` | int | 0x7f14007c | 7869 |
| `Base_Theme_AppCompat_Light_Dialog_MinWidth` | int | 0x7f14007d | 7870 |
| `Base_Theme_AppCompat_Light_DialogWhenLarge` | int | 0x7f14007e | 7871 |
| `Base_Theme_Material3_Dark` | int | 0x7f14007f | 7872 |
| `Base_Theme_Material3_Dark_BottomSheetDialog` | int | 0x7f140080 | 7873 |
| `Base_Theme_Material3_Dark_Dialog` | int | 0x7f140081 | 7874 |
| `Base_Theme_Material3_Dark_Dialog_FixedSize` | int | 0x7f140082 | 7875 |
| `Base_Theme_Material3_Dark_DialogWhenLarge` | int | 0x7f140083 | 7876 |
| `Base_Theme_Material3_Dark_SideSheetDialog` | int | 0x7f140084 | 7877 |
| `Base_Theme_Material3_Light` | int | 0x7f140085 | 7878 |
| `Base_Theme_Material3_Light_BottomSheetDialog` | int | 0x7f140086 | 7879 |
| `Base_Theme_Material3_Light_Dialog` | int | 0x7f140087 | 7880 |
| `Base_Theme_Material3_Light_Dialog_FixedSize` | int | 0x7f140088 | 7881 |
| `Base_Theme_Material3_Light_DialogWhenLarge` | int | 0x7f140089 | 7882 |
| `Base_Theme_Material3_Light_SideSheetDialog` | int | 0x7f14008a | 7883 |
| `Base_Theme_MaterialComponents` | int | 0x7f14008b | 7884 |
| `Base_Theme_MaterialComponents_Bridge` | int | 0x7f14008c | 7885 |
| `Base_Theme_MaterialComponents_CompactMenu` | int | 0x7f14008d | 7886 |
| `Base_Theme_MaterialComponents_Dialog` | int | 0x7f14008e | 7887 |
| `Base_Theme_MaterialComponents_Dialog_Alert` | int | 0x7f14008f | 7888 |
| `Base_Theme_MaterialComponents_Dialog_Bridge` | int | 0x7f140090 | 7889 |
| `Base_Theme_MaterialComponents_Dialog_FixedSize` | int | 0x7f140091 | 7890 |
| `Base_Theme_MaterialComponents_Dialog_MinWidth` | int | 0x7f140092 | 7891 |
| `Base_Theme_MaterialComponents_DialogWhenLarge` | int | 0x7f140093 | 7892 |
| `Base_Theme_MaterialComponents_Light` | int | 0x7f140094 | 7893 |
| `Base_Theme_MaterialComponents_Light_Bridge` | int | 0x7f140095 | 7894 |
| `Base_Theme_MaterialComponents_Light_DarkActionBar` | int | 0x7f140096 | 7895 |
| `Base_Theme_MaterialComponents_Light_DarkActionBar_Bridge` | int | 0x7f140097 | 7896 |
| `Base_Theme_MaterialComponents_Light_Dialog` | int | 0x7f140098 | 7897 |
| `Base_Theme_MaterialComponents_Light_Dialog_Alert` | int | 0x7f140099 | 7898 |
| `Base_Theme_MaterialComponents_Light_Dialog_Bridge` | int | 0x7f14009a | 7899 |
| `Base_Theme_MaterialComponents_Light_Dialog_FixedSize` | int | 0x7f14009b | 7900 |
| `Base_Theme_MaterialComponents_Light_Dialog_MinWidth` | int | 0x7f14009c | 7901 |
| `Base_Theme_MaterialComponents_Light_DialogWhenLarge` | int | 0x7f14009d | 7902 |
| `Base_ThemeOverlay_AppCompat` | int | 0x7f14009e | 7903 |
| `Base_ThemeOverlay_AppCompat_ActionBar` | int | 0x7f14009f | 7904 |
| `Base_ThemeOverlay_AppCompat_Dark` | int | 0x7f1400a0 | 7905 |
| `Base_ThemeOverlay_AppCompat_Dark_ActionBar` | int | 0x7f1400a1 | 7906 |
| `Base_ThemeOverlay_AppCompat_Dialog` | int | 0x7f1400a2 | 7907 |
| `Base_ThemeOverlay_AppCompat_Dialog_Alert` | int | 0x7f1400a3 | 7908 |
| `Base_ThemeOverlay_AppCompat_Light` | int | 0x7f1400a4 | 7909 |
| `Base_ThemeOverlay_Material3_AutoCompleteTextView` | int | 0x7f1400a5 | 7910 |
| `Base_ThemeOverlay_Material3_BottomSheetDialog` | int | 0x7f1400a6 | 7911 |
| `Base_ThemeOverlay_Material3_Dialog` | int | 0x7f1400a7 | 7912 |
| `Base_ThemeOverlay_Material3_SideSheetDialog` | int | 0x7f1400a8 | 7913 |
| `Base_ThemeOverlay_Material3_TextInputEditText` | int | 0x7f1400a9 | 7914 |
| `Base_ThemeOverlay_MaterialComponents_Dialog` | int | 0x7f1400aa | 7915 |
| `Base_ThemeOverlay_MaterialComponents_Dialog_Alert` | int | 0x7f1400ab | 7916 |
| `Base_ThemeOverlay_MaterialComponents_Dialog_Alert_Framework` | int | 0x7f1400ac | 7917 |
| `Base_ThemeOverlay_MaterialComponents_Light_Dialog_Alert_Framework` | int | 0x7f1400ad | 7918 |
| `Base_ThemeOverlay_MaterialComponents_MaterialAlertDialog` | int | 0x7f1400ae | 7919 |
| `Base_V14_Theme_Material3_Dark` | int | 0x7f1400af | 7920 |
| `Base_V14_Theme_Material3_Dark_BottomSheetDialog` | int | 0x7f1400b0 | 7921 |
| `Base_V14_Theme_Material3_Dark_Dialog` | int | 0x7f1400b1 | 7922 |
| `Base_V14_Theme_Material3_Dark_SideSheetDialog` | int | 0x7f1400b2 | 7923 |
| `Base_V14_Theme_Material3_Light` | int | 0x7f1400b3 | 7924 |
| `Base_V14_Theme_Material3_Light_BottomSheetDialog` | int | 0x7f1400b4 | 7925 |
| `Base_V14_Theme_Material3_Light_Dialog` | int | 0x7f1400b5 | 7926 |
| `Base_V14_Theme_Material3_Light_SideSheetDialog` | int | 0x7f1400b6 | 7927 |
| `Base_V14_Theme_MaterialComponents` | int | 0x7f1400b7 | 7928 |
| `Base_V14_Theme_MaterialComponents_Bridge` | int | 0x7f1400b8 | 7929 |
| `Base_V14_Theme_MaterialComponents_Dialog` | int | 0x7f1400b9 | 7930 |
| `Base_V14_Theme_MaterialComponents_Dialog_Bridge` | int | 0x7f1400ba | 7931 |
| `Base_V14_Theme_MaterialComponents_Light` | int | 0x7f1400bb | 7932 |
| `Base_V14_Theme_MaterialComponents_Light_Bridge` | int | 0x7f1400bc | 7933 |
| `Base_V14_Theme_MaterialComponents_Light_DarkActionBar_Bridge` | int | 0x7f1400bd | 7934 |
| `Base_V14_Theme_MaterialComponents_Light_Dialog` | int | 0x7f1400be | 7935 |
| `Base_V14_Theme_MaterialComponents_Light_Dialog_Bridge` | int | 0x7f1400bf | 7936 |
| `Base_V14_ThemeOverlay_Material3_BottomSheetDialog` | int | 0x7f1400c0 | 7937 |
| `Base_V14_ThemeOverlay_Material3_SideSheetDialog` | int | 0x7f1400c1 | 7938 |
| `Base_V14_ThemeOverlay_MaterialComponents_Dialog` | int | 0x7f1400c2 | 7939 |
| `Base_V14_ThemeOverlay_MaterialComponents_Dialog_Alert` | int | 0x7f1400c3 | 7940 |
| `Base_V14_ThemeOverlay_MaterialComponents_MaterialAlertDialog` | int | 0x7f1400c4 | 7941 |
| `Base_V14_Widget_MaterialComponents_AutoCompleteTextView` | int | 0x7f1400c5 | 7942 |
| `Base_V21_Theme_AppCompat` | int | 0x7f1400c6 | 7943 |
| `Base_V21_Theme_AppCompat_Dialog` | int | 0x7f1400c7 | 7944 |
| `Base_V21_Theme_AppCompat_Light` | int | 0x7f1400c8 | 7945 |
| `Base_V21_Theme_AppCompat_Light_Dialog` | int | 0x7f1400c9 | 7946 |
| `Base_V21_Theme_MaterialComponents` | int | 0x7f1400ca | 7947 |
| `Base_V21_Theme_MaterialComponents_Dialog` | int | 0x7f1400cb | 7948 |
| `Base_V21_Theme_MaterialComponents_Light` | int | 0x7f1400cc | 7949 |
| `Base_V21_Theme_MaterialComponents_Light_Dialog` | int | 0x7f1400cd | 7950 |
| `Base_V21_ThemeOverlay_AppCompat_Dialog` | int | 0x7f1400ce | 7951 |
| `Base_V21_ThemeOverlay_Material3_BottomSheetDialog` | int | 0x7f1400cf | 7952 |
| `Base_V21_ThemeOverlay_Material3_SideSheetDialog` | int | 0x7f1400d0 | 7953 |
| `Base_V22_Theme_AppCompat` | int | 0x7f1400d1 | 7954 |
| `Base_V22_Theme_AppCompat_Light` | int | 0x7f1400d2 | 7955 |
| `Base_V23_Theme_AppCompat` | int | 0x7f1400d3 | 7956 |
| `Base_V23_Theme_AppCompat_Light` | int | 0x7f1400d4 | 7957 |
| `Base_V24_Theme_Material3_Dark` | int | 0x7f1400d5 | 7958 |
| `Base_V24_Theme_Material3_Dark_Dialog` | int | 0x7f1400d6 | 7959 |
| `Base_V24_Theme_Material3_Light` | int | 0x7f1400d7 | 7960 |
| `Base_V24_Theme_Material3_Light_Dialog` | int | 0x7f1400d8 | 7961 |
| `Base_V26_Theme_AppCompat` | int | 0x7f1400d9 | 7962 |
| `Base_V26_Theme_AppCompat_Light` | int | 0x7f1400da | 7963 |
| `Base_V26_Widget_AppCompat_Toolbar` | int | 0x7f1400db | 7964 |
| `Base_V28_Theme_AppCompat` | int | 0x7f1400dc | 7965 |
| `Base_V28_Theme_AppCompat_Light` | int | 0x7f1400dd | 7966 |
| `Base_V7_Theme_AppCompat` | int | 0x7f1400de | 7967 |
| `Base_V7_Theme_AppCompat_Dialog` | int | 0x7f1400df | 7968 |
| `Base_V7_Theme_AppCompat_Light` | int | 0x7f1400e0 | 7969 |
| `Base_V7_Theme_AppCompat_Light_Dialog` | int | 0x7f1400e1 | 7970 |
| `Base_V7_ThemeOverlay_AppCompat_Dialog` | int | 0x7f1400e2 | 7971 |
| `Base_V7_Widget_AppCompat_AutoCompleteTextView` | int | 0x7f1400e3 | 7972 |
| `Base_V7_Widget_AppCompat_EditText` | int | 0x7f1400e4 | 7973 |
| `Base_V7_Widget_AppCompat_Toolbar` | int | 0x7f1400e5 | 7974 |
| `Base_Widget_AppCompat_ActionBar` | int | 0x7f1400e6 | 7975 |
| `Base_Widget_AppCompat_ActionBar_Solid` | int | 0x7f1400e7 | 7976 |
| `Base_Widget_AppCompat_ActionBar_TabBar` | int | 0x7f1400e8 | 7977 |
| `Base_Widget_AppCompat_ActionBar_TabText` | int | 0x7f1400e9 | 7978 |
| `Base_Widget_AppCompat_ActionBar_TabView` | int | 0x7f1400ea | 7979 |
| `Base_Widget_AppCompat_ActionButton` | int | 0x7f1400eb | 7980 |
| `Base_Widget_AppCompat_ActionButton_CloseMode` | int | 0x7f1400ec | 7981 |
| `Base_Widget_AppCompat_ActionButton_Overflow` | int | 0x7f1400ed | 7982 |
| `Base_Widget_AppCompat_ActionMode` | int | 0x7f1400ee | 7983 |
| `Base_Widget_AppCompat_ActivityChooserView` | int | 0x7f1400ef | 7984 |
| `Base_Widget_AppCompat_AutoCompleteTextView` | int | 0x7f1400f0 | 7985 |
| `Base_Widget_AppCompat_Button` | int | 0x7f1400f1 | 7986 |
| `Base_Widget_AppCompat_Button_Borderless` | int | 0x7f1400f2 | 7987 |
| `Base_Widget_AppCompat_Button_Borderless_Colored` | int | 0x7f1400f3 | 7988 |
| `Base_Widget_AppCompat_Button_ButtonBar_AlertDialog` | int | 0x7f1400f4 | 7989 |
| `Base_Widget_AppCompat_Button_Colored` | int | 0x7f1400f5 | 7990 |
| `Base_Widget_AppCompat_Button_Small` | int | 0x7f1400f6 | 7991 |
| `Base_Widget_AppCompat_ButtonBar` | int | 0x7f1400f7 | 7992 |
| `Base_Widget_AppCompat_ButtonBar_AlertDialog` | int | 0x7f1400f8 | 7993 |
| `Base_Widget_AppCompat_CompoundButton_CheckBox` | int | 0x7f1400f9 | 7994 |
| `Base_Widget_AppCompat_CompoundButton_RadioButton` | int | 0x7f1400fa | 7995 |
| `Base_Widget_AppCompat_CompoundButton_Switch` | int | 0x7f1400fb | 7996 |
| `Base_Widget_AppCompat_DrawerArrowToggle` | int | 0x7f1400fc | 7997 |
| `Base_Widget_AppCompat_DrawerArrowToggle_Common` | int | 0x7f1400fd | 7998 |
| `Base_Widget_AppCompat_DropDownItem_Spinner` | int | 0x7f1400fe | 7999 |
| `Base_Widget_AppCompat_EditText` | int | 0x7f1400ff | 8000 |
| `Base_Widget_AppCompat_ImageButton` | int | 0x7f140100 | 8001 |
| `Base_Widget_AppCompat_Light_ActionBar` | int | 0x7f140101 | 8002 |
| `Base_Widget_AppCompat_Light_ActionBar_Solid` | int | 0x7f140102 | 8003 |
| `Base_Widget_AppCompat_Light_ActionBar_TabBar` | int | 0x7f140103 | 8004 |
| `Base_Widget_AppCompat_Light_ActionBar_TabText` | int | 0x7f140104 | 8005 |
| `Base_Widget_AppCompat_Light_ActionBar_TabText_Inverse` | int | 0x7f140105 | 8006 |
| `Base_Widget_AppCompat_Light_ActionBar_TabView` | int | 0x7f140106 | 8007 |
| `Base_Widget_AppCompat_Light_PopupMenu` | int | 0x7f140107 | 8008 |
| `Base_Widget_AppCompat_Light_PopupMenu_Overflow` | int | 0x7f140108 | 8009 |
| `Base_Widget_AppCompat_ListMenuView` | int | 0x7f140109 | 8010 |
| `Base_Widget_AppCompat_ListPopupWindow` | int | 0x7f14010a | 8011 |
| `Base_Widget_AppCompat_ListView` | int | 0x7f14010b | 8012 |
| `Base_Widget_AppCompat_ListView_DropDown` | int | 0x7f14010c | 8013 |
| `Base_Widget_AppCompat_ListView_Menu` | int | 0x7f14010d | 8014 |
| `Base_Widget_AppCompat_PopupMenu` | int | 0x7f14010e | 8015 |
| `Base_Widget_AppCompat_PopupMenu_Overflow` | int | 0x7f14010f | 8016 |
| `Base_Widget_AppCompat_PopupWindow` | int | 0x7f140110 | 8017 |
| `Base_Widget_AppCompat_ProgressBar` | int | 0x7f140111 | 8018 |
| `Base_Widget_AppCompat_ProgressBar_Horizontal` | int | 0x7f140112 | 8019 |
| `Base_Widget_AppCompat_RatingBar` | int | 0x7f140113 | 8020 |
| `Base_Widget_AppCompat_RatingBar_Indicator` | int | 0x7f140114 | 8021 |
| `Base_Widget_AppCompat_RatingBar_Small` | int | 0x7f140115 | 8022 |
| `Base_Widget_AppCompat_SearchView` | int | 0x7f140116 | 8023 |
| `Base_Widget_AppCompat_SearchView_ActionBar` | int | 0x7f140117 | 8024 |
| `Base_Widget_AppCompat_SeekBar` | int | 0x7f140118 | 8025 |
| `Base_Widget_AppCompat_SeekBar_Discrete` | int | 0x7f140119 | 8026 |
| `Base_Widget_AppCompat_Spinner` | int | 0x7f14011a | 8027 |
| `Base_Widget_AppCompat_Spinner_Underlined` | int | 0x7f14011b | 8028 |
| `Base_Widget_AppCompat_TextView` | int | 0x7f14011c | 8029 |
| `Base_Widget_AppCompat_TextView_SpinnerItem` | int | 0x7f14011d | 8030 |
| `Base_Widget_AppCompat_Toolbar` | int | 0x7f14011e | 8031 |
| `Base_Widget_AppCompat_Toolbar_Button_Navigation` | int | 0x7f14011f | 8032 |
| `Base_Widget_Design_TabLayout` | int | 0x7f140120 | 8033 |
| `Base_Widget_Material3_ActionBar_Solid` | int | 0x7f140121 | 8034 |
| `Base_Widget_Material3_ActionMode` | int | 0x7f140122 | 8035 |
| `Base_Widget_Material3_BottomNavigationView` | int | 0x7f140123 | 8036 |
| `Base_Widget_Material3_CardView` | int | 0x7f140124 | 8037 |
| `Base_Widget_Material3_Chip` | int | 0x7f140125 | 8038 |
| `Base_Widget_Material3_CollapsingToolbar` | int | 0x7f140126 | 8039 |
| `Base_Widget_Material3_CompoundButton_CheckBox` | int | 0x7f140127 | 8040 |
| `Base_Widget_Material3_CompoundButton_RadioButton` | int | 0x7f140128 | 8041 |
| `Base_Widget_Material3_CompoundButton_Switch` | int | 0x7f140129 | 8042 |
| `Base_Widget_Material3_DockedToolbar` | int | 0x7f14012a | 8043 |
| `Base_Widget_Material3_ExtendedFloatingActionButton` | int | 0x7f14012b | 8044 |
| `Base_Widget_Material3_ExtendedFloatingActionButton_Icon` | int | 0x7f14012c | 8045 |
| `Base_Widget_Material3_ExtendedFloatingActionButton_Large` | int | 0x7f14012d | 8046 |
| `Base_Widget_Material3_ExtendedFloatingActionButton_Medium` | int | 0x7f14012e | 8047 |
| `Base_Widget_Material3_ExtendedFloatingActionButton_Small` | int | 0x7f14012f | 8048 |
| `Base_Widget_Material3_FloatingActionButton` | int | 0x7f140130 | 8049 |
| `Base_Widget_Material3_FloatingActionButton_Large` | int | 0x7f140131 | 8050 |
| `Base_Widget_Material3_FloatingActionButton_Medium` | int | 0x7f140132 | 8051 |
| `Base_Widget_Material3_FloatingActionButton_Small` | int | 0x7f140133 | 8052 |
| `Base_Widget_Material3_FloatingToolbar` | int | 0x7f140134 | 8053 |
| `Base_Widget_Material3_Light_ActionBar_Solid` | int | 0x7f140135 | 8054 |
| `Base_Widget_Material3_MaterialCalendar_NavigationButton` | int | 0x7f140136 | 8055 |
| `Base_Widget_Material3_Snackbar` | int | 0x7f140137 | 8056 |
| `Base_Widget_Material3_TabLayout` | int | 0x7f140138 | 8057 |
| `Base_Widget_Material3_TabLayout_OnSurface` | int | 0x7f140139 | 8058 |
| `Base_Widget_Material3_TabLayout_Secondary` | int | 0x7f14013a | 8059 |
| `Base_Widget_MaterialComponents_AutoCompleteTextView` | int | 0x7f14013b | 8060 |
| `Base_Widget_MaterialComponents_CheckedTextView` | int | 0x7f14013c | 8061 |
| `Base_Widget_MaterialComponents_Chip` | int | 0x7f14013d | 8062 |
| `Base_Widget_MaterialComponents_MaterialCalendar_HeaderToggleButton` | int | 0x7f14013e | 8063 |
| `Base_Widget_MaterialComponents_MaterialCalendar_NavigationButton` | int | 0x7f14013f | 8064 |
| `Base_Widget_MaterialComponents_PopupMenu` | int | 0x7f140140 | 8065 |
| `Base_Widget_MaterialComponents_PopupMenu_ContextMenu` | int | 0x7f140141 | 8066 |
| `Base_Widget_MaterialComponents_PopupMenu_ListPopupWindow` | int | 0x7f140142 | 8067 |
| `Base_Widget_MaterialComponents_PopupMenu_Overflow` | int | 0x7f140143 | 8068 |
| `Base_Widget_MaterialComponents_Slider` | int | 0x7f140144 | 8069 |
| `Base_Widget_MaterialComponents_Snackbar` | int | 0x7f140145 | 8070 |
| `Base_Widget_MaterialComponents_TextInputEditText` | int | 0x7f140146 | 8071 |
| `Base_Widget_MaterialComponents_TextInputLayout` | int | 0x7f140147 | 8072 |
| `Base_Widget_MaterialComponents_TextView` | int | 0x7f140148 | 8073 |
| `CardView` | int | 0x7f140149 | 8074 |
| `CardView_Dark` | int | 0x7f14014a | 8075 |
| `CardView_Light` | int | 0x7f14014b | 8076 |
| `com_facebook_activity_theme` | int | 0x7f14053a | 9083 |
| `com_facebook_auth_dialog` | int | 0x7f14053b | 9084 |
| `com_facebook_auth_dialog_instructions_textview` | int | 0x7f14053c | 9085 |
| `com_facebook_button` | int | 0x7f14053d | 9086 |
| `com_facebook_button_like` | int | 0x7f14053e | 9087 |
| `com_facebook_button_send` | int | 0x7f14053f | 9088 |
| `com_facebook_button_share` | int | 0x7f140540 | 9089 |
| `com_facebook_loginview_default_style` | int | 0x7f140541 | 9090 |
| `common_dialog_style` | int | 0x7f140542 | 9091 |
| `custom_dialog2` | int | 0x7f14054d | 9102 |
| `customButtonPrimary` | int | 0x7f140543 | 9092 |
| `customButtonStyle01` | int | 0x7f140544 | 9093 |
| `customButtonStyle02` | int | 0x7f140545 | 9094 |
| `CustomCheckboxTheme` | int | 0x7f14014c | 8077 |
| `CustomDialog` | int | 0x7f14014d | 8078 |
| `customEditPrimary` | int | 0x7f140546 | 9095 |
| `customEditPrimary2` | int | 0x7f140547 | 9096 |
| `customEditTextTheme` | int | 0x7f140548 | 9097 |
| `customHollowTextviewPrimary` | int | 0x7f140549 | 9098 |
| `CustomSecondaryTxvTheme` | int | 0x7f14014e | 8079 |
| `customTextviewStyleDack` | int | 0x7f14054a | 9099 |
| `customTextviewStyleLight` | int | 0x7f14054b | 9100 |
| `customTextviewStyleLightSmall` | int | 0x7f14054c | 9101 |
| `DefaultAnimation` | int | 0x7f14014f | 8080 |
| `Dialog` | int | 0x7f140150 | 8081 |
| `errorTextview` | int | 0x7f14054e | 9103 |
| `ExoMediaButton` | int | 0x7f140151 | 8082 |
| `ExoMediaButton_FastForward` | int | 0x7f140152 | 8083 |
| `ExoMediaButton_Next` | int | 0x7f140153 | 8084 |
| `ExoMediaButton_Pause` | int | 0x7f140154 | 8085 |
| `ExoMediaButton_Play` | int | 0x7f140155 | 8086 |
| `ExoMediaButton_Previous` | int | 0x7f140156 | 8087 |
| `ExoMediaButton_Rewind` | int | 0x7f140157 | 8088 |
| `ExoMediaButton_VR` | int | 0x7f140158 | 8089 |
| `ExoStyledControls` | int | 0x7f140159 | 8090 |
| `ExoStyledControls_Button` | int | 0x7f14015a | 8091 |
| `ExoStyledControls_Button_Bottom` | int | 0x7f14015b | 8092 |
| `ExoStyledControls_Button_Bottom_AudioTrack` | int | 0x7f14015c | 8093 |
| `ExoStyledControls_Button_Bottom_CC` | int | 0x7f14015d | 8094 |
| `ExoStyledControls_Button_Bottom_FullScreen` | int | 0x7f14015e | 8095 |
| `ExoStyledControls_Button_Bottom_OverflowHide` | int | 0x7f14015f | 8096 |
| `ExoStyledControls_Button_Bottom_OverflowShow` | int | 0x7f140160 | 8097 |
| `ExoStyledControls_Button_Bottom_PlaybackSpeed` | int | 0x7f140161 | 8098 |
| `ExoStyledControls_Button_Bottom_RepeatToggle` | int | 0x7f140162 | 8099 |
| `ExoStyledControls_Button_Bottom_Settings` | int | 0x7f140163 | 8100 |
| `ExoStyledControls_Button_Bottom_Shuffle` | int | 0x7f140164 | 8101 |
| `ExoStyledControls_Button_Bottom_VR` | int | 0x7f140165 | 8102 |
| `ExoStyledControls_Button_Center` | int | 0x7f140166 | 8103 |
| `ExoStyledControls_Button_Center_FfwdWithAmount` | int | 0x7f140167 | 8104 |
| `ExoStyledControls_Button_Center_Next` | int | 0x7f140168 | 8105 |
| `ExoStyledControls_Button_Center_PlayPause` | int | 0x7f140169 | 8106 |
| `ExoStyledControls_Button_Center_Previous` | int | 0x7f14016a | 8107 |
| `ExoStyledControls_Button_Center_RewWithAmount` | int | 0x7f14016b | 8108 |
| `ExoStyledControls_TimeBar` | int | 0x7f14016c | 8109 |
| `ExoStyledControls_TimeText` | int | 0x7f14016d | 8110 |
| `ExoStyledControls_TimeText_Duration` | int | 0x7f14016e | 8111 |
| `ExoStyledControls_TimeText_Position` | int | 0x7f14016f | 8112 |
| `ExoStyledControls_TimeText_Separator` | int | 0x7f140170 | 8113 |
| `firstTextviewGray` | int | 0x7f14054f | 9104 |
| `firstTextviewPrimary` | int | 0x7f140550 | 9105 |
| `FullscreenActionBarStyle` | int | 0x7f140176 | 8119 |
| `FullscreenTheme` | int | 0x7f140177 | 8120 |
| `FullScreenTheme` | int | 0x7f140171 | 8114 |
| `FullScreenTheme_AppBarOverlay` | int | 0x7f140172 | 8115 |
| `FullScreenTheme_AppBarOverlayNoElevation` | int | 0x7f140173 | 8116 |
| `FullScreenTheme_NoActionBar` | int | 0x7f140174 | 8117 |
| `FullScreenTheme_PopupOverlay` | int | 0x7f140175 | 8118 |
| `jz_popup_toast_anim` | int | 0x7f140551 | 9106 |
| `jz_style_dialog_progress` | int | 0x7f140552 | 9107 |
| `leastTextviewPrimary` | int | 0x7f140553 | 9108 |
| `MaterialAlertDialog_Material3` | int | 0x7f140178 | 8121 |
| `MaterialAlertDialog_Material3_Animation` | int | 0x7f140179 | 8122 |
| `MaterialAlertDialog_Material3_Body_Text` | int | 0x7f14017a | 8123 |
| `MaterialAlertDialog_Material3_Body_Text_CenterStacked` | int | 0x7f14017b | 8124 |
| `MaterialAlertDialog_Material3_Title_Icon` | int | 0x7f14017c | 8125 |
| `MaterialAlertDialog_Material3_Title_Icon_CenterStacked` | int | 0x7f14017d | 8126 |
| `MaterialAlertDialog_Material3_Title_Panel` | int | 0x7f14017e | 8127 |
| `MaterialAlertDialog_Material3_Title_Panel_CenterStacked` | int | 0x7f14017f | 8128 |
| `MaterialAlertDialog_Material3_Title_Text` | int | 0x7f140180 | 8129 |
| `MaterialAlertDialog_Material3_Title_Text_CenterStacked` | int | 0x7f140181 | 8130 |
| `MaterialAlertDialog_MaterialComponents` | int | 0x7f140182 | 8131 |
| `MaterialAlertDialog_MaterialComponents_Body_Text` | int | 0x7f140183 | 8132 |
| `MaterialAlertDialog_MaterialComponents_Picker_Date_Calendar` | int | 0x7f140184 | 8133 |
| `MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner` | int | 0x7f140185 | 8134 |
| `MaterialAlertDialog_MaterialComponents_Title_Icon` | int | 0x7f140186 | 8135 |
| `MaterialAlertDialog_MaterialComponents_Title_Icon_CenterStacked` | int | 0x7f140187 | 8136 |
| `MaterialAlertDialog_MaterialComponents_Title_Panel` | int | 0x7f140188 | 8137 |
| `MaterialAlertDialog_MaterialComponents_Title_Panel_CenterStacked` | int | 0x7f140189 | 8138 |
| `MaterialAlertDialog_MaterialComponents_Title_Text` | int | 0x7f14018a | 8139 |
| `MaterialAlertDialog_MaterialComponents_Title_Text_CenterStacked` | int | 0x7f14018b | 8140 |
| `MessengerButton` | int | 0x7f14018c | 8141 |
| `MessengerButton_Blue` | int | 0x7f14018d | 8142 |
| `MessengerButton_Blue_Large` | int | 0x7f14018e | 8143 |
| `MessengerButton_Blue_Small` | int | 0x7f14018f | 8144 |
| `MessengerButton_White` | int | 0x7f140190 | 8145 |
| `MessengerButton_White_Large` | int | 0x7f140191 | 8146 |
| `MessengerButton_White_Small` | int | 0x7f140192 | 8147 |
| `MessengerButtonText` | int | 0x7f140193 | 8148 |
| `MessengerButtonText_Blue` | int | 0x7f140194 | 8149 |
| `MessengerButtonText_Blue_Large` | int | 0x7f140195 | 8150 |
| `MessengerButtonText_Blue_Small` | int | 0x7f140196 | 8151 |
| `MessengerButtonText_White` | int | 0x7f140197 | 8152 |
| `MessengerButtonText_White_Large` | int | 0x7f140198 | 8153 |
| `MessengerButtonText_White_Small` | int | 0x7f140199 | 8154 |
| `Motion_Material3_Spring_Standard_Default_Effects` | int | 0x7f14019a | 8155 |
| `Motion_Material3_Spring_Standard_Default_Spatial` | int | 0x7f14019b | 8156 |
| `Motion_Material3_Spring_Standard_Fast_Effects` | int | 0x7f14019c | 8157 |
| `Motion_Material3_Spring_Standard_Fast_Spatial` | int | 0x7f14019d | 8158 |
| `Motion_Material3_Spring_Standard_Slow_Effects` | int | 0x7f14019e | 8159 |
| `Motion_Material3_Spring_Standard_Slow_Spatial` | int | 0x7f14019f | 8160 |
| `MyDialogStyle` | int | 0x7f1401a0 | 8161 |
| `MyTabLayoutTextAppearanceInverse` | int | 0x7f1401a1 | 8162 |
| `navigationTextviewPrimary` | int | 0x7f140554 | 9109 |
| `NiceDialog` | int | 0x7f1401a2 | 8163 |
| `NumberProgressBar_Relax_Blue` | int | 0x7f1401a3 | 8164 |
| `picker_view_scale_anim` | int | 0x7f140555 | 9110 |
| `picker_view_slide_anim` | int | 0x7f140556 | 9111 |
| `Platform_AppCompat` | int | 0x7f1401a4 | 8165 |
| `Platform_AppCompat_Light` | int | 0x7f1401a5 | 8166 |
| `Platform_MaterialComponents` | int | 0x7f1401a6 | 8167 |
| `Platform_MaterialComponents_Dialog` | int | 0x7f1401a7 | 8168 |
| `Platform_MaterialComponents_Light` | int | 0x7f1401a8 | 8169 |
| `Platform_MaterialComponents_Light_Dialog` | int | 0x7f1401a9 | 8170 |
| `Platform_ThemeOverlay_AppCompat` | int | 0x7f1401aa | 8171 |
| `Platform_ThemeOverlay_AppCompat_Dark` | int | 0x7f1401ab | 8172 |
| `Platform_ThemeOverlay_AppCompat_Light` | int | 0x7f1401ac | 8173 |
| `Platform_V21_AppCompat` | int | 0x7f1401ad | 8174 |
| `Platform_V21_AppCompat_Light` | int | 0x7f1401ae | 8175 |
| `Platform_V25_AppCompat` | int | 0x7f1401af | 8176 |
| `Platform_V25_AppCompat_Light` | int | 0x7f1401b0 | 8177 |
| `Platform_Widget_AppCompat_Spinner` | int | 0x7f1401b1 | 8178 |
| `pop_animation` | int | 0x7f140557 | 9112 |
| `PopWindowAnimStyle` | int | 0x7f1401b2 | 8179 |
| `RtlOverlay_DialogWindowTitle_AppCompat` | int | 0x7f1401b3 | 8180 |
| `RtlOverlay_Widget_AppCompat_ActionBar_TitleItem` | int | 0x7f1401b4 | 8181 |
| `RtlOverlay_Widget_AppCompat_DialogTitle_Icon` | int | 0x7f1401b5 | 8182 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem` | int | 0x7f1401b6 | 8183 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_InternalGroup` | int | 0x7f1401b7 | 8184 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_Shortcut` | int | 0x7f1401b8 | 8185 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_SubmenuArrow` | int | 0x7f1401b9 | 8186 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_Text` | int | 0x7f1401ba | 8187 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_Title` | int | 0x7f1401bb | 8188 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown` | int | 0x7f1401bc | 8189 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown_Icon1` | int | 0x7f1401bd | 8190 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown_Icon2` | int | 0x7f1401be | 8191 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown_Query` | int | 0x7f1401bf | 8192 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown_Text` | int | 0x7f1401c0 | 8193 |
| `RtlOverlay_Widget_AppCompat_SearchView_MagIcon` | int | 0x7f1401c1 | 8194 |
| `RtlUnderlay_Widget_AppCompat_ActionButton` | int | 0x7f1401c2 | 8195 |
| `RtlUnderlay_Widget_AppCompat_ActionButton_Overflow` | int | 0x7f1401c3 | 8196 |
| `secondTextviewGray` | int | 0x7f140558 | 9113 |
| `secondTextviewPrimary` | int | 0x7f140559 | 9114 |
| `setupEditPrimary` | int | 0x7f14055a | 9115 |
| `ShapeAppearance_M3_Comp_Badge_Large_Shape` | int | 0x7f1401c4 | 8197 |
| `ShapeAppearance_M3_Comp_Badge_Shape` | int | 0x7f1401c5 | 8198 |
| `ShapeAppearance_M3_Comp_BottomAppBar_Container_Shape` | int | 0x7f1401c6 | 8199 |
| `ShapeAppearance_M3_Comp_Button_Large_Container_Shape_Round` | int | 0x7f1401c7 | 8200 |
| `ShapeAppearance_M3_Comp_Button_Large_Selected_Container_Shape_Square` | int | 0x7f1401c8 | 8201 |
| `ShapeAppearance_M3_Comp_Button_Medium_Container_Shape_Round` | int | 0x7f1401c9 | 8202 |
| `ShapeAppearance_M3_Comp_Button_Medium_Selected_Container_Shape_Square` | int | 0x7f1401ca | 8203 |
| `ShapeAppearance_M3_Comp_Button_Small_Container_Shape_Round` | int | 0x7f1401cb | 8204 |
| `ShapeAppearance_M3_Comp_Button_Small_Selected_Container_Shape_Square` | int | 0x7f1401cc | 8205 |
| `ShapeAppearance_M3_Comp_Button_Xlarge_Container_Shape_Round` | int | 0x7f1401cd | 8206 |
| `ShapeAppearance_M3_Comp_Button_Xlarge_Selected_Container_Shape_Square` | int | 0x7f1401ce | 8207 |
| `ShapeAppearance_M3_Comp_Button_Xsmall_Container_Shape_Round` | int | 0x7f1401cf | 8208 |
| `ShapeAppearance_M3_Comp_Button_Xsmall_Selected_Container_Shape_Square` | int | 0x7f1401d0 | 8209 |
| `ShapeAppearance_M3_Comp_ButtonGroup_Connected_Small_Container_Shape` | int | 0x7f1401d1 | 8210 |
| `ShapeAppearance_M3_Comp_DatePicker_Modal_Date_Container_Shape` | int | 0x7f1401d2 | 8211 |
| `ShapeAppearance_M3_Comp_IconButton_Large_Container_Shape_Round` | int | 0x7f1401d3 | 8212 |
| `ShapeAppearance_M3_Comp_IconButton_Large_Selected_Container_Shape_Square` | int | 0x7f1401d4 | 8213 |
| `ShapeAppearance_M3_Comp_IconButton_Medium_Container_Shape_Round` | int | 0x7f1401d5 | 8214 |
| `ShapeAppearance_M3_Comp_IconButton_Medium_Selected_Container_Shape_Square` | int | 0x7f1401d6 | 8215 |
| `ShapeAppearance_M3_Comp_IconButton_Small_Container_Shape_Round` | int | 0x7f1401d7 | 8216 |
| `ShapeAppearance_M3_Comp_IconButton_Small_Selected_Container_Shape_Square` | int | 0x7f1401d8 | 8217 |
| `ShapeAppearance_M3_Comp_IconButton_Xlarge_Container_Shape_Round` | int | 0x7f1401d9 | 8218 |
| `ShapeAppearance_M3_Comp_IconButton_Xlarge_Selected_Container_Shape_Square` | int | 0x7f1401da | 8219 |
| `ShapeAppearance_M3_Comp_IconButton_Xsmall_Container_Shape_Round` | int | 0x7f1401db | 8220 |
| `ShapeAppearance_M3_Comp_IconButton_Xsmall_Selected_Container_Shape_Square` | int | 0x7f1401dc | 8221 |
| `ShapeAppearance_M3_Comp_NavBar_Container_Shape` | int | 0x7f1401dd | 8222 |
| `ShapeAppearance_M3_Comp_NavBar_Item_ActiveIndicator_Shape` | int | 0x7f1401de | 8223 |
| `ShapeAppearance_M3_Comp_NavigationDrawer_ActiveIndicator_Shape` | int | 0x7f1401e2 | 8227 |
| `ShapeAppearance_M3_Comp_NavRail_Collapsed_Container_Shape` | int | 0x7f1401df | 8224 |
| `ShapeAppearance_M3_Comp_NavRail_Expanded_Container_Shape` | int | 0x7f1401e0 | 8225 |
| `ShapeAppearance_M3_Comp_NavRail_Item_ActiveIndicator_Shape` | int | 0x7f1401e1 | 8226 |
| `ShapeAppearance_M3_Comp_SearchBar_Avatar_Shape` | int | 0x7f1401e3 | 8228 |
| `ShapeAppearance_M3_Comp_SearchBar_Container_Shape` | int | 0x7f1401e4 | 8229 |
| `ShapeAppearance_M3_Comp_SearchView_FullScreen_Container_Shape` | int | 0x7f1401e5 | 8230 |
| `ShapeAppearance_M3_Comp_Sheet_Side_Docked_Container_Shape` | int | 0x7f1401e6 | 8231 |
| `ShapeAppearance_M3_Comp_Switch_Handle_Shape` | int | 0x7f1401e7 | 8232 |
| `ShapeAppearance_M3_Comp_Switch_StateLayer_Shape` | int | 0x7f1401e8 | 8233 |
| `ShapeAppearance_M3_Comp_Switch_Track_Shape` | int | 0x7f1401e9 | 8234 |
| `ShapeAppearance_M3_Comp_Toolbar_Docked_Container_Shape` | int | 0x7f1401ea | 8235 |
| `ShapeAppearance_M3_Comp_Toolbar_Floating_Container_Shape` | int | 0x7f1401eb | 8236 |
| `ShapeAppearance_M3_Comp_Toolbar_Vibrant_Vibrant_Container_Shape` | int | 0x7f1401ec | 8237 |
| `ShapeAppearance_M3_Sys_Shape_Corner_ExtraExtraLarge` | int | 0x7f1401ed | 8238 |
| `ShapeAppearance_M3_Sys_Shape_Corner_ExtraLarge` | int | 0x7f1401ee | 8239 |
| `ShapeAppearance_M3_Sys_Shape_Corner_ExtraLargeIncreased` | int | 0x7f1401ef | 8240 |
| `ShapeAppearance_M3_Sys_Shape_Corner_ExtraSmall` | int | 0x7f1401f0 | 8241 |
| `ShapeAppearance_M3_Sys_Shape_Corner_Full` | int | 0x7f1401f1 | 8242 |
| `ShapeAppearance_M3_Sys_Shape_Corner_Large` | int | 0x7f1401f2 | 8243 |
| `ShapeAppearance_M3_Sys_Shape_Corner_LargeIncreased` | int | 0x7f1401f3 | 8244 |
| `ShapeAppearance_M3_Sys_Shape_Corner_Medium` | int | 0x7f1401f4 | 8245 |
| `ShapeAppearance_M3_Sys_Shape_Corner_None` | int | 0x7f1401f5 | 8246 |
| `ShapeAppearance_M3_Sys_Shape_Corner_Small` | int | 0x7f1401f6 | 8247 |
| `ShapeAppearance_Material3_Corner_ExtraExtraLarge` | int | 0x7f1401f7 | 8248 |
| `ShapeAppearance_Material3_Corner_ExtraLarge` | int | 0x7f1401f8 | 8249 |
| `ShapeAppearance_Material3_Corner_ExtraLargeIncreased` | int | 0x7f1401f9 | 8250 |
| `ShapeAppearance_Material3_Corner_ExtraSmall` | int | 0x7f1401fa | 8251 |
| `ShapeAppearance_Material3_Corner_Full` | int | 0x7f1401fb | 8252 |
| `ShapeAppearance_Material3_Corner_Large` | int | 0x7f1401fc | 8253 |
| `ShapeAppearance_Material3_Corner_LargeIncreased` | int | 0x7f1401fd | 8254 |
| `ShapeAppearance_Material3_Corner_Medium` | int | 0x7f1401fe | 8255 |
| `ShapeAppearance_Material3_Corner_None` | int | 0x7f1401ff | 8256 |
| `ShapeAppearance_Material3_Corner_Small` | int | 0x7f140200 | 8257 |
| `ShapeAppearance_Material3_LargeComponent` | int | 0x7f140201 | 8258 |
| `ShapeAppearance_Material3_MediumComponent` | int | 0x7f140202 | 8259 |
| `ShapeAppearance_Material3_NavigationBarView_ActiveIndicator` | int | 0x7f140203 | 8260 |
| `ShapeAppearance_Material3_SmallComponent` | int | 0x7f140204 | 8261 |
| `ShapeAppearance_Material3_Tooltip` | int | 0x7f140205 | 8262 |
| `ShapeAppearance_MaterialComponents` | int | 0x7f140206 | 8263 |
| `ShapeAppearance_MaterialComponents_Badge` | int | 0x7f140207 | 8264 |
| `ShapeAppearance_MaterialComponents_LargeComponent` | int | 0x7f140208 | 8265 |
| `ShapeAppearance_MaterialComponents_MediumComponent` | int | 0x7f140209 | 8266 |
| `ShapeAppearance_MaterialComponents_SmallComponent` | int | 0x7f14020a | 8267 |
| `ShapeAppearance_MaterialComponents_Tooltip` | int | 0x7f14020b | 8268 |
| `ShapeAppearanceOverlay_Material3_Button` | int | 0x7f14020c | 8269 |
| `ShapeAppearanceOverlay_Material3_Chip` | int | 0x7f14020d | 8270 |
| `ShapeAppearanceOverlay_Material3_Corner_Bottom` | int | 0x7f14020e | 8271 |
| `ShapeAppearanceOverlay_Material3_Corner_Left` | int | 0x7f14020f | 8272 |
| `ShapeAppearanceOverlay_Material3_Corner_Right` | int | 0x7f140210 | 8273 |
| `ShapeAppearanceOverlay_Material3_Corner_Top` | int | 0x7f140211 | 8274 |
| `ShapeAppearanceOverlay_Material3_FloatingActionButton` | int | 0x7f140212 | 8275 |
| `ShapeAppearanceOverlay_Material3_NavigationView_Item` | int | 0x7f140213 | 8276 |
| `ShapeAppearanceOverlay_Material3_SearchBar` | int | 0x7f140214 | 8277 |
| `ShapeAppearanceOverlay_Material3_SearchView` | int | 0x7f140215 | 8278 |
| `ShapeAppearanceOverlay_MaterialAlertDialog_Material3` | int | 0x7f140216 | 8279 |
| `ShapeAppearanceOverlay_MaterialComponents_BottomSheet` | int | 0x7f140217 | 8280 |
| `ShapeAppearanceOverlay_MaterialComponents_Chip` | int | 0x7f140218 | 8281 |
| `ShapeAppearanceOverlay_MaterialComponents_ExtendedFloatingActionButton` | int | 0x7f140219 | 8282 |
| `ShapeAppearanceOverlay_MaterialComponents_FloatingActionButton` | int | 0x7f14021a | 8283 |
| `ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Day` | int | 0x7f14021b | 8284 |
| `ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Window_Fullscreen` | int | 0x7f14021c | 8285 |
| `ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Year` | int | 0x7f14021d | 8286 |
| `ShapeAppearanceOverlay_MaterialComponents_TextInputLayout_FilledBox` | int | 0x7f14021e | 8287 |
| `sn_CheckBox` | int | 0x7f14055b | 9116 |
| `TextAppearance_AppCompat` | int | 0x7f14021f | 8288 |
| `TextAppearance_AppCompat_Body1` | int | 0x7f140220 | 8289 |
| `TextAppearance_AppCompat_Body2` | int | 0x7f140221 | 8290 |
| `TextAppearance_AppCompat_Button` | int | 0x7f140222 | 8291 |
| `TextAppearance_AppCompat_Caption` | int | 0x7f140223 | 8292 |
| `TextAppearance_AppCompat_Display1` | int | 0x7f140224 | 8293 |
| `TextAppearance_AppCompat_Display2` | int | 0x7f140225 | 8294 |
| `TextAppearance_AppCompat_Display3` | int | 0x7f140226 | 8295 |
| `TextAppearance_AppCompat_Display4` | int | 0x7f140227 | 8296 |
| `TextAppearance_AppCompat_Headline` | int | 0x7f140228 | 8297 |
| `TextAppearance_AppCompat_Inverse` | int | 0x7f140229 | 8298 |
| `TextAppearance_AppCompat_Large` | int | 0x7f14022a | 8299 |
| `TextAppearance_AppCompat_Large_Inverse` | int | 0x7f14022b | 8300 |
| `TextAppearance_AppCompat_Light_SearchResult_Subtitle` | int | 0x7f14022c | 8301 |
| `TextAppearance_AppCompat_Light_SearchResult_Title` | int | 0x7f14022d | 8302 |
| `TextAppearance_AppCompat_Light_Widget_PopupMenu_Large` | int | 0x7f14022e | 8303 |
| `TextAppearance_AppCompat_Light_Widget_PopupMenu_Small` | int | 0x7f14022f | 8304 |
| `TextAppearance_AppCompat_Medium` | int | 0x7f140230 | 8305 |
| `TextAppearance_AppCompat_Medium_Inverse` | int | 0x7f140231 | 8306 |
| `TextAppearance_AppCompat_Menu` | int | 0x7f140232 | 8307 |
| `TextAppearance_AppCompat_SearchResult_Subtitle` | int | 0x7f140233 | 8308 |
| `TextAppearance_AppCompat_SearchResult_Title` | int | 0x7f140234 | 8309 |
| `TextAppearance_AppCompat_Small` | int | 0x7f140235 | 8310 |
| `TextAppearance_AppCompat_Small_Inverse` | int | 0x7f140236 | 8311 |
| `TextAppearance_AppCompat_Subhead` | int | 0x7f140237 | 8312 |
| `TextAppearance_AppCompat_Subhead_Inverse` | int | 0x7f140238 | 8313 |
| `TextAppearance_AppCompat_Title` | int | 0x7f140239 | 8314 |
| `TextAppearance_AppCompat_Title_Inverse` | int | 0x7f14023a | 8315 |
| `TextAppearance_AppCompat_Tooltip` | int | 0x7f14023b | 8316 |
| `TextAppearance_AppCompat_Widget_ActionBar_Menu` | int | 0x7f14023c | 8317 |
| `TextAppearance_AppCompat_Widget_ActionBar_Subtitle` | int | 0x7f14023d | 8318 |
| `TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse` | int | 0x7f14023e | 8319 |
| `TextAppearance_AppCompat_Widget_ActionBar_Title` | int | 0x7f14023f | 8320 |
| `TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse` | int | 0x7f140240 | 8321 |
| `TextAppearance_AppCompat_Widget_ActionMode_Subtitle` | int | 0x7f140241 | 8322 |
| `TextAppearance_AppCompat_Widget_ActionMode_Subtitle_Inverse` | int | 0x7f140242 | 8323 |
| `TextAppearance_AppCompat_Widget_ActionMode_Title` | int | 0x7f140243 | 8324 |
| `TextAppearance_AppCompat_Widget_ActionMode_Title_Inverse` | int | 0x7f140244 | 8325 |
| `TextAppearance_AppCompat_Widget_Button` | int | 0x7f140245 | 8326 |
| `TextAppearance_AppCompat_Widget_Button_Borderless_Colored` | int | 0x7f140246 | 8327 |
| `TextAppearance_AppCompat_Widget_Button_Colored` | int | 0x7f140247 | 8328 |
| `TextAppearance_AppCompat_Widget_Button_Inverse` | int | 0x7f140248 | 8329 |
| `TextAppearance_AppCompat_Widget_DropDownItem` | int | 0x7f140249 | 8330 |
| `TextAppearance_AppCompat_Widget_PopupMenu_Header` | int | 0x7f14024a | 8331 |
| `TextAppearance_AppCompat_Widget_PopupMenu_Large` | int | 0x7f14024b | 8332 |
| `TextAppearance_AppCompat_Widget_PopupMenu_Small` | int | 0x7f14024c | 8333 |
| `TextAppearance_AppCompat_Widget_Switch` | int | 0x7f14024d | 8334 |
| `TextAppearance_AppCompat_Widget_TextView_SpinnerItem` | int | 0x7f14024e | 8335 |
| `TextAppearance_Compat_Notification` | int | 0x7f14024f | 8336 |
| `TextAppearance_Compat_Notification_Info` | int | 0x7f140250 | 8337 |
| `TextAppearance_Compat_Notification_Info_Media` | int | 0x7f140251 | 8338 |
| `TextAppearance_Compat_Notification_Line2` | int | 0x7f140252 | 8339 |
| `TextAppearance_Compat_Notification_Line2_Media` | int | 0x7f140253 | 8340 |
| `TextAppearance_Compat_Notification_Media` | int | 0x7f140254 | 8341 |
| `TextAppearance_Compat_Notification_Time` | int | 0x7f140255 | 8342 |
| `TextAppearance_Compat_Notification_Time_Media` | int | 0x7f140256 | 8343 |
| `TextAppearance_Compat_Notification_Title` | int | 0x7f140257 | 8344 |
| `TextAppearance_Compat_Notification_Title_Media` | int | 0x7f140258 | 8345 |
| `TextAppearance_Design_CollapsingToolbar_Expanded` | int | 0x7f140259 | 8346 |
| `TextAppearance_Design_Counter` | int | 0x7f14025a | 8347 |
| `TextAppearance_Design_Counter_Overflow` | int | 0x7f14025b | 8348 |
| `TextAppearance_Design_Error` | int | 0x7f14025c | 8349 |
| `TextAppearance_Design_HelperText` | int | 0x7f14025d | 8350 |
| `TextAppearance_Design_Hint` | int | 0x7f14025e | 8351 |
| `TextAppearance_Design_Placeholder` | int | 0x7f14025f | 8352 |
| `TextAppearance_Design_Prefix` | int | 0x7f140260 | 8353 |
| `TextAppearance_Design_Snackbar_Message` | int | 0x7f140261 | 8354 |
| `TextAppearance_Design_Suffix` | int | 0x7f140262 | 8355 |
| `TextAppearance_Design_Tab` | int | 0x7f140263 | 8356 |
| `TextAppearance_M3_Sys_Typescale_BodyLarge` | int | 0x7f140264 | 8357 |
| `TextAppearance_M3_Sys_Typescale_BodyLarge_Emphasized` | int | 0x7f140265 | 8358 |
| `TextAppearance_M3_Sys_Typescale_BodyMedium` | int | 0x7f140266 | 8359 |
| `TextAppearance_M3_Sys_Typescale_BodyMedium_Emphasized` | int | 0x7f140267 | 8360 |
| `TextAppearance_M3_Sys_Typescale_BodySmall` | int | 0x7f140268 | 8361 |
| `TextAppearance_M3_Sys_Typescale_BodySmall_Emphasized` | int | 0x7f140269 | 8362 |
| `TextAppearance_M3_Sys_Typescale_DisplayLarge` | int | 0x7f14026a | 8363 |
| `TextAppearance_M3_Sys_Typescale_DisplayLarge_Emphasized` | int | 0x7f14026b | 8364 |
| `TextAppearance_M3_Sys_Typescale_DisplayMedium` | int | 0x7f14026c | 8365 |
| `TextAppearance_M3_Sys_Typescale_DisplayMedium_Emphasized` | int | 0x7f14026d | 8366 |
| `TextAppearance_M3_Sys_Typescale_DisplaySmall` | int | 0x7f14026e | 8367 |
| `TextAppearance_M3_Sys_Typescale_DisplaySmall_Emphasized` | int | 0x7f14026f | 8368 |
| `TextAppearance_M3_Sys_Typescale_HeadlineLarge` | int | 0x7f140270 | 8369 |
| `TextAppearance_M3_Sys_Typescale_HeadlineLarge_Emphasized` | int | 0x7f140271 | 8370 |
| `TextAppearance_M3_Sys_Typescale_HeadlineMedium` | int | 0x7f140272 | 8371 |
| `TextAppearance_M3_Sys_Typescale_HeadlineMedium_Emphasized` | int | 0x7f140273 | 8372 |
| `TextAppearance_M3_Sys_Typescale_HeadlineSmall` | int | 0x7f140274 | 8373 |
| `TextAppearance_M3_Sys_Typescale_HeadlineSmall_Emphasized` | int | 0x7f140275 | 8374 |
| `TextAppearance_M3_Sys_Typescale_LabelLarge` | int | 0x7f140276 | 8375 |
| `TextAppearance_M3_Sys_Typescale_LabelLarge_Emphasized` | int | 0x7f140277 | 8376 |
| `TextAppearance_M3_Sys_Typescale_LabelMedium` | int | 0x7f140278 | 8377 |
| `TextAppearance_M3_Sys_Typescale_LabelMedium_Emphasized` | int | 0x7f140279 | 8378 |
| `TextAppearance_M3_Sys_Typescale_LabelSmall` | int | 0x7f14027a | 8379 |
| `TextAppearance_M3_Sys_Typescale_LabelSmall_Emphasized` | int | 0x7f14027b | 8380 |
| `TextAppearance_M3_Sys_Typescale_TitleLarge` | int | 0x7f14027c | 8381 |
| `TextAppearance_M3_Sys_Typescale_TitleLarge_Emphasized` | int | 0x7f14027d | 8382 |
| `TextAppearance_M3_Sys_Typescale_TitleMedium` | int | 0x7f14027e | 8383 |
| `TextAppearance_M3_Sys_Typescale_TitleMedium_Emphasized` | int | 0x7f14027f | 8384 |
| `TextAppearance_M3_Sys_Typescale_TitleSmall` | int | 0x7f140280 | 8385 |
| `TextAppearance_M3_Sys_Typescale_TitleSmall_Emphasized` | int | 0x7f140281 | 8386 |
| `TextAppearance_Material3_ActionBar_Subtitle` | int | 0x7f140282 | 8387 |
| `TextAppearance_Material3_ActionBar_Title` | int | 0x7f140283 | 8388 |
| `TextAppearance_Material3_BodyLarge` | int | 0x7f140284 | 8389 |
| `TextAppearance_Material3_BodyLarge_Emphasized` | int | 0x7f140285 | 8390 |
| `TextAppearance_Material3_BodyMedium` | int | 0x7f140286 | 8391 |
| `TextAppearance_Material3_BodyMedium_Emphasized` | int | 0x7f140287 | 8392 |
| `TextAppearance_Material3_BodySmall` | int | 0x7f140288 | 8393 |
| `TextAppearance_Material3_BodySmall_Emphasized` | int | 0x7f140289 | 8394 |
| `TextAppearance_Material3_DisplayLarge` | int | 0x7f14028a | 8395 |
| `TextAppearance_Material3_DisplayLarge_Emphasized` | int | 0x7f14028b | 8396 |
| `TextAppearance_Material3_DisplayMedium` | int | 0x7f14028c | 8397 |
| `TextAppearance_Material3_DisplayMedium_Emphasized` | int | 0x7f14028d | 8398 |
| `TextAppearance_Material3_DisplaySmall` | int | 0x7f14028e | 8399 |
| `TextAppearance_Material3_DisplaySmall_Emphasized` | int | 0x7f14028f | 8400 |
| `TextAppearance_Material3_HeadlineLarge` | int | 0x7f140290 | 8401 |
| `TextAppearance_Material3_HeadlineLarge_Emphasized` | int | 0x7f140291 | 8402 |
| `TextAppearance_Material3_HeadlineMedium` | int | 0x7f140292 | 8403 |
| `TextAppearance_Material3_HeadlineMedium_Emphasized` | int | 0x7f140293 | 8404 |
| `TextAppearance_Material3_HeadlineSmall` | int | 0x7f140294 | 8405 |
| `TextAppearance_Material3_HeadlineSmall_Emphasized` | int | 0x7f140295 | 8406 |
| `TextAppearance_Material3_LabelLarge` | int | 0x7f140296 | 8407 |
| `TextAppearance_Material3_LabelLarge_Emphasized` | int | 0x7f140297 | 8408 |
| `TextAppearance_Material3_LabelMedium` | int | 0x7f140298 | 8409 |
| `TextAppearance_Material3_LabelMedium_Emphasized` | int | 0x7f140299 | 8410 |
| `TextAppearance_Material3_LabelSmall` | int | 0x7f14029a | 8411 |
| `TextAppearance_Material3_LabelSmall_Emphasized` | int | 0x7f14029b | 8412 |
| `TextAppearance_Material3_MaterialTimePicker_Title` | int | 0x7f14029c | 8413 |
| `TextAppearance_Material3_SearchBar` | int | 0x7f14029d | 8414 |
| `TextAppearance_Material3_SearchView` | int | 0x7f14029e | 8415 |
| `TextAppearance_Material3_SearchView_Prefix` | int | 0x7f14029f | 8416 |
| `TextAppearance_Material3_TitleLarge` | int | 0x7f1402a0 | 8417 |
| `TextAppearance_Material3_TitleLarge_Emphasized` | int | 0x7f1402a1 | 8418 |
| `TextAppearance_Material3_TitleMedium` | int | 0x7f1402a2 | 8419 |
| `TextAppearance_Material3_TitleMedium_Emphasized` | int | 0x7f1402a3 | 8420 |
| `TextAppearance_Material3_TitleSmall` | int | 0x7f1402a4 | 8421 |
| `TextAppearance_Material3_TitleSmall_Emphasized` | int | 0x7f1402a5 | 8422 |
| `TextAppearance_MaterialComponents_Badge` | int | 0x7f1402a6 | 8423 |
| `TextAppearance_MaterialComponents_Body1` | int | 0x7f1402a7 | 8424 |
| `TextAppearance_MaterialComponents_Body2` | int | 0x7f1402a8 | 8425 |
| `TextAppearance_MaterialComponents_Button` | int | 0x7f1402a9 | 8426 |
| `TextAppearance_MaterialComponents_Caption` | int | 0x7f1402aa | 8427 |
| `TextAppearance_MaterialComponents_Chip` | int | 0x7f1402ab | 8428 |
| `TextAppearance_MaterialComponents_Headline1` | int | 0x7f1402ac | 8429 |
| `TextAppearance_MaterialComponents_Headline2` | int | 0x7f1402ad | 8430 |
| `TextAppearance_MaterialComponents_Headline3` | int | 0x7f1402ae | 8431 |
| `TextAppearance_MaterialComponents_Headline4` | int | 0x7f1402af | 8432 |
| `TextAppearance_MaterialComponents_Headline5` | int | 0x7f1402b0 | 8433 |
| `TextAppearance_MaterialComponents_Headline6` | int | 0x7f1402b1 | 8434 |
| `TextAppearance_MaterialComponents_Overline` | int | 0x7f1402b2 | 8435 |
| `TextAppearance_MaterialComponents_Subtitle1` | int | 0x7f1402b3 | 8436 |
| `TextAppearance_MaterialComponents_Subtitle2` | int | 0x7f1402b4 | 8437 |
| `TextAppearance_MaterialComponents_TimePicker_Title` | int | 0x7f1402b5 | 8438 |
| `TextAppearance_MaterialComponents_Tooltip` | int | 0x7f1402b6 | 8439 |
| `TextAppearance_Widget_AppCompat_ExpandedMenu_Item` | int | 0x7f1402b7 | 8440 |
| `TextAppearance_Widget_AppCompat_Toolbar_Subtitle` | int | 0x7f1402b8 | 8441 |
| `TextAppearance_Widget_AppCompat_Toolbar_Title` | int | 0x7f1402b9 | 8442 |
| `Theme_AppCompat` | int | 0x7f1402ba | 8443 |
| `Theme_AppCompat_CompactMenu` | int | 0x7f1402bb | 8444 |
| `Theme_AppCompat_DayNight` | int | 0x7f1402bc | 8445 |
| `Theme_AppCompat_DayNight_DarkActionBar` | int | 0x7f1402bd | 8446 |
| `Theme_AppCompat_DayNight_Dialog` | int | 0x7f1402be | 8447 |
| `Theme_AppCompat_DayNight_Dialog_Alert` | int | 0x7f1402bf | 8448 |
| `Theme_AppCompat_DayNight_Dialog_MinWidth` | int | 0x7f1402c0 | 8449 |
| `Theme_AppCompat_DayNight_DialogWhenLarge` | int | 0x7f1402c1 | 8450 |
| `Theme_AppCompat_DayNight_NoActionBar` | int | 0x7f1402c2 | 8451 |
| `Theme_AppCompat_Dialog` | int | 0x7f1402c3 | 8452 |
| `Theme_AppCompat_Dialog_Alert` | int | 0x7f1402c4 | 8453 |
| `Theme_AppCompat_Dialog_MinWidth` | int | 0x7f1402c5 | 8454 |
| `Theme_AppCompat_DialogWhenLarge` | int | 0x7f1402c6 | 8455 |
| `Theme_AppCompat_Empty` | int | 0x7f1402c7 | 8456 |
| `Theme_AppCompat_Light` | int | 0x7f1402c8 | 8457 |
| `Theme_AppCompat_Light_DarkActionBar` | int | 0x7f1402c9 | 8458 |
| `Theme_AppCompat_Light_Dialog` | int | 0x7f1402ca | 8459 |
| `Theme_AppCompat_Light_Dialog_Alert` | int | 0x7f1402cb | 8460 |
| `Theme_AppCompat_Light_Dialog_MinWidth` | int | 0x7f1402cc | 8461 |
| `Theme_AppCompat_Light_DialogWhenLarge` | int | 0x7f1402cd | 8462 |
| `Theme_AppCompat_Light_NoActionBar` | int | 0x7f1402ce | 8463 |
| `Theme_AppCompat_NoActionBar` | int | 0x7f1402cf | 8464 |
| `Theme_Design` | int | 0x7f1402d0 | 8465 |
| `Theme_Design_BottomSheetDialog` | int | 0x7f1402d1 | 8466 |
| `Theme_Design_Light` | int | 0x7f1402d2 | 8467 |
| `Theme_Design_Light_BottomSheetDialog` | int | 0x7f1402d3 | 8468 |
| `Theme_Design_Light_NoActionBar` | int | 0x7f1402d4 | 8469 |
| `Theme_Design_NoActionBar` | int | 0x7f1402d5 | 8470 |
| `Theme_Material3_Dark` | int | 0x7f1402d6 | 8471 |
| `Theme_Material3_Dark_BottomSheetDialog` | int | 0x7f1402d7 | 8472 |
| `Theme_Material3_Dark_Dialog` | int | 0x7f1402d8 | 8473 |
| `Theme_Material3_Dark_Dialog_Alert` | int | 0x7f1402d9 | 8474 |
| `Theme_Material3_Dark_Dialog_MinWidth` | int | 0x7f1402da | 8475 |
| `Theme_Material3_Dark_DialogWhenLarge` | int | 0x7f1402db | 8476 |
| `Theme_Material3_Dark_NoActionBar` | int | 0x7f1402dc | 8477 |
| `Theme_Material3_Dark_SideSheetDialog` | int | 0x7f1402dd | 8478 |
| `Theme_Material3_DayNight` | int | 0x7f1402de | 8479 |
| `Theme_Material3_DayNight_BottomSheetDialog` | int | 0x7f1402df | 8480 |
| `Theme_Material3_DayNight_Dialog` | int | 0x7f1402e0 | 8481 |
| `Theme_Material3_DayNight_Dialog_Alert` | int | 0x7f1402e1 | 8482 |
| `Theme_Material3_DayNight_Dialog_MinWidth` | int | 0x7f1402e2 | 8483 |
| `Theme_Material3_DayNight_DialogWhenLarge` | int | 0x7f1402e3 | 8484 |
| `Theme_Material3_DayNight_NoActionBar` | int | 0x7f1402e4 | 8485 |
| `Theme_Material3_DayNight_SideSheetDialog` | int | 0x7f1402e5 | 8486 |
| `Theme_Material3_DynamicColors_Dark` | int | 0x7f1402e6 | 8487 |
| `Theme_Material3_DynamicColors_Dark_NoActionBar` | int | 0x7f1402e7 | 8488 |
| `Theme_Material3_DynamicColors_DayNight` | int | 0x7f1402e8 | 8489 |
| `Theme_Material3_DynamicColors_DayNight_NoActionBar` | int | 0x7f1402e9 | 8490 |
| `Theme_Material3_DynamicColors_Light` | int | 0x7f1402ea | 8491 |
| `Theme_Material3_DynamicColors_Light_NoActionBar` | int | 0x7f1402eb | 8492 |
| `Theme_Material3_Light` | int | 0x7f1402ec | 8493 |
| `Theme_Material3_Light_BottomSheetDialog` | int | 0x7f1402ed | 8494 |
| `Theme_Material3_Light_Dialog` | int | 0x7f1402ee | 8495 |
| `Theme_Material3_Light_Dialog_Alert` | int | 0x7f1402ef | 8496 |
| `Theme_Material3_Light_Dialog_MinWidth` | int | 0x7f1402f0 | 8497 |
| `Theme_Material3_Light_DialogWhenLarge` | int | 0x7f1402f1 | 8498 |
| `Theme_Material3_Light_NoActionBar` | int | 0x7f1402f2 | 8499 |
| `Theme_Material3_Light_SideSheetDialog` | int | 0x7f1402f3 | 8500 |
| `Theme_MaterialComponents` | int | 0x7f1402f4 | 8501 |
| `Theme_MaterialComponents_BottomSheetDialog` | int | 0x7f1402f5 | 8502 |
| `Theme_MaterialComponents_Bridge` | int | 0x7f1402f6 | 8503 |
| `Theme_MaterialComponents_CompactMenu` | int | 0x7f1402f7 | 8504 |
| `Theme_MaterialComponents_DayNight` | int | 0x7f1402f8 | 8505 |
| `Theme_MaterialComponents_DayNight_BottomSheetDialog` | int | 0x7f1402f9 | 8506 |
| `Theme_MaterialComponents_DayNight_Bridge` | int | 0x7f1402fa | 8507 |
| `Theme_MaterialComponents_DayNight_DarkActionBar` | int | 0x7f1402fb | 8508 |
| `Theme_MaterialComponents_DayNight_DarkActionBar_Bridge` | int | 0x7f1402fc | 8509 |
| `Theme_MaterialComponents_DayNight_Dialog` | int | 0x7f1402fd | 8510 |
| `Theme_MaterialComponents_DayNight_Dialog_Alert` | int | 0x7f1402fe | 8511 |
| `Theme_MaterialComponents_DayNight_Dialog_Alert_Bridge` | int | 0x7f1402ff | 8512 |
| `Theme_MaterialComponents_DayNight_Dialog_Bridge` | int | 0x7f140300 | 8513 |
| `Theme_MaterialComponents_DayNight_Dialog_FixedSize` | int | 0x7f140301 | 8514 |
| `Theme_MaterialComponents_DayNight_Dialog_FixedSize_Bridge` | int | 0x7f140302 | 8515 |
| `Theme_MaterialComponents_DayNight_Dialog_MinWidth` | int | 0x7f140303 | 8516 |
| `Theme_MaterialComponents_DayNight_Dialog_MinWidth_Bridge` | int | 0x7f140304 | 8517 |
| `Theme_MaterialComponents_DayNight_DialogWhenLarge` | int | 0x7f140305 | 8518 |
| `Theme_MaterialComponents_DayNight_NoActionBar` | int | 0x7f140306 | 8519 |
| `Theme_MaterialComponents_DayNight_NoActionBar_Bridge` | int | 0x7f140307 | 8520 |
| `Theme_MaterialComponents_Dialog` | int | 0x7f140308 | 8521 |
| `Theme_MaterialComponents_Dialog_Alert` | int | 0x7f140309 | 8522 |
| `Theme_MaterialComponents_Dialog_Alert_Bridge` | int | 0x7f14030a | 8523 |
| `Theme_MaterialComponents_Dialog_Bridge` | int | 0x7f14030b | 8524 |
| `Theme_MaterialComponents_Dialog_FixedSize` | int | 0x7f14030c | 8525 |
| `Theme_MaterialComponents_Dialog_FixedSize_Bridge` | int | 0x7f14030d | 8526 |
| `Theme_MaterialComponents_Dialog_MinWidth` | int | 0x7f14030e | 8527 |
| `Theme_MaterialComponents_Dialog_MinWidth_Bridge` | int | 0x7f14030f | 8528 |
| `Theme_MaterialComponents_DialogWhenLarge` | int | 0x7f140310 | 8529 |
| `Theme_MaterialComponents_Light` | int | 0x7f140311 | 8530 |
| `Theme_MaterialComponents_Light_BottomSheetDialog` | int | 0x7f140312 | 8531 |
| `Theme_MaterialComponents_Light_Bridge` | int | 0x7f140313 | 8532 |
| `Theme_MaterialComponents_Light_DarkActionBar` | int | 0x7f140314 | 8533 |
| `Theme_MaterialComponents_Light_DarkActionBar_Bridge` | int | 0x7f140315 | 8534 |
| `Theme_MaterialComponents_Light_Dialog` | int | 0x7f140316 | 8535 |
| `Theme_MaterialComponents_Light_Dialog_Alert` | int | 0x7f140317 | 8536 |
| `Theme_MaterialComponents_Light_Dialog_Alert_Bridge` | int | 0x7f140318 | 8537 |
| `Theme_MaterialComponents_Light_Dialog_Bridge` | int | 0x7f140319 | 8538 |
| `Theme_MaterialComponents_Light_Dialog_FixedSize` | int | 0x7f14031a | 8539 |
| `Theme_MaterialComponents_Light_Dialog_FixedSize_Bridge` | int | 0x7f14031b | 8540 |
| `Theme_MaterialComponents_Light_Dialog_MinWidth` | int | 0x7f14031c | 8541 |
| `Theme_MaterialComponents_Light_Dialog_MinWidth_Bridge` | int | 0x7f14031d | 8542 |
| `Theme_MaterialComponents_Light_DialogWhenLarge` | int | 0x7f14031e | 8543 |
| `Theme_MaterialComponents_Light_NoActionBar` | int | 0x7f14031f | 8544 |
| `Theme_MaterialComponents_Light_NoActionBar_Bridge` | int | 0x7f140320 | 8545 |
| `Theme_MaterialComponents_NoActionBar` | int | 0x7f140321 | 8546 |
| `Theme_MaterialComponents_NoActionBar_Bridge` | int | 0x7f140322 | 8547 |
| `ThemeOverlay_AppCompat` | int | 0x7f140323 | 8548 |
| `ThemeOverlay_AppCompat_ActionBar` | int | 0x7f140324 | 8549 |
| `ThemeOverlay_AppCompat_Dark` | int | 0x7f140325 | 8550 |
| `ThemeOverlay_AppCompat_Dark_ActionBar` | int | 0x7f140326 | 8551 |
| `ThemeOverlay_AppCompat_DayNight` | int | 0x7f140327 | 8552 |
| `ThemeOverlay_AppCompat_DayNight_ActionBar` | int | 0x7f140328 | 8553 |
| `ThemeOverlay_AppCompat_Dialog` | int | 0x7f140329 | 8554 |
| `ThemeOverlay_AppCompat_Dialog_Alert` | int | 0x7f14032a | 8555 |
| `ThemeOverlay_AppCompat_Light` | int | 0x7f14032b | 8556 |
| `ThemeOverlay_Design_TextInputEditText` | int | 0x7f14032c | 8557 |
| `ThemeOverlay_Material3` | int | 0x7f14032d | 8558 |
| `ThemeOverlay_Material3_ActionBar` | int | 0x7f14032e | 8559 |
| `ThemeOverlay_Material3_AutoCompleteTextView` | int | 0x7f14032f | 8560 |
| `ThemeOverlay_Material3_AutoCompleteTextView_FilledBox` | int | 0x7f140330 | 8561 |
| `ThemeOverlay_Material3_AutoCompleteTextView_FilledBox_Dense` | int | 0x7f140331 | 8562 |
| `ThemeOverlay_Material3_AutoCompleteTextView_OutlinedBox` | int | 0x7f140332 | 8563 |
| `ThemeOverlay_Material3_AutoCompleteTextView_OutlinedBox_Dense` | int | 0x7f140333 | 8564 |
| `ThemeOverlay_Material3_BottomAppBar` | int | 0x7f140334 | 8565 |
| `ThemeOverlay_Material3_BottomAppBar_Legacy` | int | 0x7f140335 | 8566 |
| `ThemeOverlay_Material3_BottomNavigationView` | int | 0x7f140336 | 8567 |
| `ThemeOverlay_Material3_BottomSheetDialog` | int | 0x7f140337 | 8568 |
| `ThemeOverlay_Material3_Button` | int | 0x7f140338 | 8569 |
| `ThemeOverlay_Material3_Button_ElevatedButton` | int | 0x7f140339 | 8570 |
| `ThemeOverlay_Material3_Button_IconButton` | int | 0x7f14033a | 8571 |
| `ThemeOverlay_Material3_Button_IconButton_Filled` | int | 0x7f14033b | 8572 |
| `ThemeOverlay_Material3_Button_IconButton_Filled_Tonal` | int | 0x7f14033c | 8573 |
| `ThemeOverlay_Material3_Button_TextButton` | int | 0x7f14033d | 8574 |
| `ThemeOverlay_Material3_Button_TextButton_Snackbar` | int | 0x7f14033e | 8575 |
| `ThemeOverlay_Material3_Button_TonalButton` | int | 0x7f14033f | 8576 |
| `ThemeOverlay_Material3_Chip` | int | 0x7f140340 | 8577 |
| `ThemeOverlay_Material3_Chip_Assist` | int | 0x7f140341 | 8578 |
| `ThemeOverlay_Material3_Dark` | int | 0x7f140342 | 8579 |
| `ThemeOverlay_Material3_Dark_ActionBar` | int | 0x7f140343 | 8580 |
| `ThemeOverlay_Material3_DayNight_BottomSheetDialog` | int | 0x7f140344 | 8581 |
| `ThemeOverlay_Material3_DayNight_SideSheetDialog` | int | 0x7f140345 | 8582 |
| `ThemeOverlay_Material3_Dialog` | int | 0x7f140346 | 8583 |
| `ThemeOverlay_Material3_Dialog_Alert` | int | 0x7f140347 | 8584 |
| `ThemeOverlay_Material3_Dialog_Alert_Framework` | int | 0x7f140348 | 8585 |
| `ThemeOverlay_Material3_DockedToolbar` | int | 0x7f140349 | 8586 |
| `ThemeOverlay_Material3_DockedToolbar_Vibrant` | int | 0x7f14034a | 8587 |
| `ThemeOverlay_Material3_DynamicColors_Dark` | int | 0x7f14034b | 8588 |
| `ThemeOverlay_Material3_DynamicColors_DayNight` | int | 0x7f14034c | 8589 |
| `ThemeOverlay_Material3_DynamicColors_Light` | int | 0x7f14034d | 8590 |
| `ThemeOverlay_Material3_ExtendedFloatingActionButton_Primary` | int | 0x7f14034e | 8591 |
| `ThemeOverlay_Material3_ExtendedFloatingActionButton_Secondary` | int | 0x7f14034f | 8592 |
| `ThemeOverlay_Material3_ExtendedFloatingActionButton_Surface` | int | 0x7f140350 | 8593 |
| `ThemeOverlay_Material3_ExtendedFloatingActionButton_Tertiary` | int | 0x7f140351 | 8594 |
| `ThemeOverlay_Material3_FloatingActionButton_Primary` | int | 0x7f140352 | 8595 |
| `ThemeOverlay_Material3_FloatingActionButton_Secondary` | int | 0x7f140353 | 8596 |
| `ThemeOverlay_Material3_FloatingActionButton_Surface` | int | 0x7f140354 | 8597 |
| `ThemeOverlay_Material3_FloatingActionButton_Tertiary` | int | 0x7f140355 | 8598 |
| `ThemeOverlay_Material3_FloatingToolbar` | int | 0x7f140356 | 8599 |
| `ThemeOverlay_Material3_FloatingToolbar_Vibrant` | int | 0x7f140357 | 8600 |
| `ThemeOverlay_Material3_HarmonizedColors` | int | 0x7f140358 | 8601 |
| `ThemeOverlay_Material3_HarmonizedColors_Empty` | int | 0x7f140359 | 8602 |
| `ThemeOverlay_Material3_Light` | int | 0x7f14035a | 8603 |
| `ThemeOverlay_Material3_Light_Dialog_Alert_Framework` | int | 0x7f14035b | 8604 |
| `ThemeOverlay_Material3_MaterialAlertDialog` | int | 0x7f14035c | 8605 |
| `ThemeOverlay_Material3_MaterialAlertDialog_Centered` | int | 0x7f14035d | 8606 |
| `ThemeOverlay_Material3_MaterialCalendar` | int | 0x7f14035e | 8607 |
| `ThemeOverlay_Material3_MaterialCalendar_Fullscreen` | int | 0x7f14035f | 8608 |
| `ThemeOverlay_Material3_MaterialCalendar_HeaderCancelButton` | int | 0x7f140360 | 8609 |
| `ThemeOverlay_Material3_MaterialTimePicker` | int | 0x7f140361 | 8610 |
| `ThemeOverlay_Material3_MaterialTimePicker_Display_TextInputEditText` | int | 0x7f140362 | 8611 |
| `ThemeOverlay_Material3_NavigationRailView` | int | 0x7f140363 | 8612 |
| `ThemeOverlay_Material3_NavigationView` | int | 0x7f140364 | 8613 |
| `ThemeOverlay_Material3_PersonalizedColors` | int | 0x7f140365 | 8614 |
| `ThemeOverlay_Material3_Search` | int | 0x7f140366 | 8615 |
| `ThemeOverlay_Material3_SideSheetDialog` | int | 0x7f140367 | 8616 |
| `ThemeOverlay_Material3_Snackbar` | int | 0x7f140368 | 8617 |
| `ThemeOverlay_Material3_SplitButton_IconButton_Filled` | int | 0x7f140369 | 8618 |
| `ThemeOverlay_Material3_SplitButton_IconButton_Filled_Tonal` | int | 0x7f14036a | 8619 |
| `ThemeOverlay_Material3_TabLayout` | int | 0x7f14036b | 8620 |
| `ThemeOverlay_Material3_TextInputEditText` | int | 0x7f14036c | 8621 |
| `ThemeOverlay_Material3_TextInputEditText_FilledBox` | int | 0x7f14036d | 8622 |
| `ThemeOverlay_Material3_TextInputEditText_FilledBox_Dense` | int | 0x7f14036e | 8623 |
| `ThemeOverlay_Material3_TextInputEditText_OutlinedBox` | int | 0x7f14036f | 8624 |
| `ThemeOverlay_Material3_TextInputEditText_OutlinedBox_Dense` | int | 0x7f140370 | 8625 |
| `ThemeOverlay_Material3_Toolbar_Surface` | int | 0x7f140371 | 8626 |
| `ThemeOverlay_MaterialAlertDialog_Material3_Title_Icon` | int | 0x7f140372 | 8627 |
| `ThemeOverlay_MaterialComponents` | int | 0x7f140373 | 8628 |
| `ThemeOverlay_MaterialComponents_ActionBar` | int | 0x7f140374 | 8629 |
| `ThemeOverlay_MaterialComponents_ActionBar_Primary` | int | 0x7f140375 | 8630 |
| `ThemeOverlay_MaterialComponents_ActionBar_Surface` | int | 0x7f140376 | 8631 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView` | int | 0x7f140377 | 8632 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView_FilledBox` | int | 0x7f140378 | 8633 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView_FilledBox_Dense` | int | 0x7f140379 | 8634 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView_OutlinedBox` | int | 0x7f14037a | 8635 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView_OutlinedBox_Dense` | int | 0x7f14037b | 8636 |
| `ThemeOverlay_MaterialComponents_BottomAppBar_Primary` | int | 0x7f14037c | 8637 |
| `ThemeOverlay_MaterialComponents_BottomAppBar_Surface` | int | 0x7f14037d | 8638 |
| `ThemeOverlay_MaterialComponents_BottomSheetDialog` | int | 0x7f14037e | 8639 |
| `ThemeOverlay_MaterialComponents_Dark` | int | 0x7f14037f | 8640 |
| `ThemeOverlay_MaterialComponents_Dark_ActionBar` | int | 0x7f140380 | 8641 |
| `ThemeOverlay_MaterialComponents_DayNight_BottomSheetDialog` | int | 0x7f140381 | 8642 |
| `ThemeOverlay_MaterialComponents_Dialog` | int | 0x7f140382 | 8643 |
| `ThemeOverlay_MaterialComponents_Dialog_Alert` | int | 0x7f140383 | 8644 |
| `ThemeOverlay_MaterialComponents_Dialog_Alert_Framework` | int | 0x7f140384 | 8645 |
| `ThemeOverlay_MaterialComponents_Light` | int | 0x7f140385 | 8646 |
| `ThemeOverlay_MaterialComponents_Light_Dialog_Alert_Framework` | int | 0x7f140386 | 8647 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog` | int | 0x7f140387 | 8648 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Centered` | int | 0x7f140388 | 8649 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date` | int | 0x7f140389 | 8650 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date_Calendar` | int | 0x7f14038a | 8651 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date_Header_Text` | int | 0x7f14038b | 8652 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date_Header_Text_Day` | int | 0x7f14038c | 8653 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date_Spinner` | int | 0x7f14038d | 8654 |
| `ThemeOverlay_MaterialComponents_MaterialCalendar` | int | 0x7f14038e | 8655 |
| `ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen` | int | 0x7f14038f | 8656 |
| `ThemeOverlay_MaterialComponents_TextInputEditText` | int | 0x7f140390 | 8657 |
| `ThemeOverlay_MaterialComponents_TextInputEditText_FilledBox` | int | 0x7f140391 | 8658 |
| `ThemeOverlay_MaterialComponents_TextInputEditText_FilledBox_Dense` | int | 0x7f140392 | 8659 |
| `ThemeOverlay_MaterialComponents_TextInputEditText_OutlinedBox` | int | 0x7f140393 | 8660 |
| `ThemeOverlay_MaterialComponents_TextInputEditText_OutlinedBox_Dense` | int | 0x7f140394 | 8661 |
| `ThemeOverlay_MaterialComponents_TimePicker` | int | 0x7f140395 | 8662 |
| `ThemeOverlay_MaterialComponents_TimePicker_Display` | int | 0x7f140396 | 8663 |
| `ThemeOverlay_MaterialComponents_TimePicker_Display_TextInputEditText` | int | 0x7f140397 | 8664 |
| `ThemeOverlay_MaterialComponents_Toolbar_Popup_Primary` | int | 0x7f140398 | 8665 |
| `ThemeOverlay_MaterialComponents_Toolbar_Primary` | int | 0x7f140399 | 8666 |
| `ThemeOverlay_MaterialComponents_Toolbar_Surface` | int | 0x7f14039a | 8667 |
| `ThemeOverlay_MyDarkButton` | int | 0x7f14039b | 8668 |
| `tooltip_bubble_text` | int | 0x7f14055c | 9117 |
| `video_popup_toast_anim` | int | 0x7f14055d | 9118 |
| `video_style_dialog_progress` | int | 0x7f14055e | 9119 |
| `video_vertical_progressBar` | int | 0x7f14055f | 9120 |
| `Widget_AppCompat_ActionBar` | int | 0x7f14039c | 8669 |
| `Widget_AppCompat_ActionBar_Solid` | int | 0x7f14039d | 8670 |
| `Widget_AppCompat_ActionBar_TabBar` | int | 0x7f14039e | 8671 |
| `Widget_AppCompat_ActionBar_TabText` | int | 0x7f14039f | 8672 |
| `Widget_AppCompat_ActionBar_TabView` | int | 0x7f1403a0 | 8673 |
| `Widget_AppCompat_ActionButton` | int | 0x7f1403a1 | 8674 |
| `Widget_AppCompat_ActionButton_CloseMode` | int | 0x7f1403a2 | 8675 |
| `Widget_AppCompat_ActionButton_Overflow` | int | 0x7f1403a3 | 8676 |
| `Widget_AppCompat_ActionMode` | int | 0x7f1403a4 | 8677 |
| `Widget_AppCompat_ActivityChooserView` | int | 0x7f1403a5 | 8678 |
| `Widget_AppCompat_AutoCompleteTextView` | int | 0x7f1403a6 | 8679 |
| `Widget_AppCompat_Button` | int | 0x7f1403a7 | 8680 |
| `Widget_AppCompat_Button_Borderless` | int | 0x7f1403a8 | 8681 |
| `Widget_AppCompat_Button_Borderless_Colored` | int | 0x7f1403a9 | 8682 |
| `Widget_AppCompat_Button_ButtonBar_AlertDialog` | int | 0x7f1403aa | 8683 |
| `Widget_AppCompat_Button_Colored` | int | 0x7f1403ab | 8684 |
| `Widget_AppCompat_Button_Small` | int | 0x7f1403ac | 8685 |
| `Widget_AppCompat_ButtonBar` | int | 0x7f1403ad | 8686 |
| `Widget_AppCompat_ButtonBar_AlertDialog` | int | 0x7f1403ae | 8687 |
| `Widget_AppCompat_CompoundButton_CheckBox` | int | 0x7f1403af | 8688 |
| `Widget_AppCompat_CompoundButton_RadioButton` | int | 0x7f1403b0 | 8689 |
| `Widget_AppCompat_CompoundButton_Switch` | int | 0x7f1403b1 | 8690 |
| `Widget_AppCompat_DrawerArrowToggle` | int | 0x7f1403b2 | 8691 |
| `Widget_AppCompat_DropDownItem_Spinner` | int | 0x7f1403b3 | 8692 |
| `Widget_AppCompat_EditText` | int | 0x7f1403b4 | 8693 |
| `Widget_AppCompat_ImageButton` | int | 0x7f1403b5 | 8694 |
| `Widget_AppCompat_Light_ActionBar` | int | 0x7f1403b6 | 8695 |
| `Widget_AppCompat_Light_ActionBar_Solid` | int | 0x7f1403b7 | 8696 |
| `Widget_AppCompat_Light_ActionBar_Solid_Inverse` | int | 0x7f1403b8 | 8697 |
| `Widget_AppCompat_Light_ActionBar_TabBar` | int | 0x7f1403b9 | 8698 |
| `Widget_AppCompat_Light_ActionBar_TabBar_Inverse` | int | 0x7f1403ba | 8699 |
| `Widget_AppCompat_Light_ActionBar_TabText` | int | 0x7f1403bb | 8700 |
| `Widget_AppCompat_Light_ActionBar_TabText_Inverse` | int | 0x7f1403bc | 8701 |
| `Widget_AppCompat_Light_ActionBar_TabView` | int | 0x7f1403bd | 8702 |
| `Widget_AppCompat_Light_ActionBar_TabView_Inverse` | int | 0x7f1403be | 8703 |
| `Widget_AppCompat_Light_ActionButton` | int | 0x7f1403bf | 8704 |
| `Widget_AppCompat_Light_ActionButton_CloseMode` | int | 0x7f1403c0 | 8705 |
| `Widget_AppCompat_Light_ActionButton_Overflow` | int | 0x7f1403c1 | 8706 |
| `Widget_AppCompat_Light_ActionMode_Inverse` | int | 0x7f1403c2 | 8707 |
| `Widget_AppCompat_Light_ActivityChooserView` | int | 0x7f1403c3 | 8708 |
| `Widget_AppCompat_Light_AutoCompleteTextView` | int | 0x7f1403c4 | 8709 |
| `Widget_AppCompat_Light_DropDownItem_Spinner` | int | 0x7f1403c5 | 8710 |
| `Widget_AppCompat_Light_ListPopupWindow` | int | 0x7f1403c6 | 8711 |
| `Widget_AppCompat_Light_ListView_DropDown` | int | 0x7f1403c7 | 8712 |
| `Widget_AppCompat_Light_PopupMenu` | int | 0x7f1403c8 | 8713 |
| `Widget_AppCompat_Light_PopupMenu_Overflow` | int | 0x7f1403c9 | 8714 |
| `Widget_AppCompat_Light_SearchView` | int | 0x7f1403ca | 8715 |
| `Widget_AppCompat_Light_Spinner_DropDown_ActionBar` | int | 0x7f1403cb | 8716 |
| `Widget_AppCompat_ListMenuView` | int | 0x7f1403cc | 8717 |
| `Widget_AppCompat_ListPopupWindow` | int | 0x7f1403cd | 8718 |
| `Widget_AppCompat_ListView` | int | 0x7f1403ce | 8719 |
| `Widget_AppCompat_ListView_DropDown` | int | 0x7f1403cf | 8720 |
| `Widget_AppCompat_ListView_Menu` | int | 0x7f1403d0 | 8721 |
| `Widget_AppCompat_PopupMenu` | int | 0x7f1403d1 | 8722 |
| `Widget_AppCompat_PopupMenu_Overflow` | int | 0x7f1403d2 | 8723 |
| `Widget_AppCompat_PopupWindow` | int | 0x7f1403d3 | 8724 |
| `Widget_AppCompat_ProgressBar` | int | 0x7f1403d4 | 8725 |
| `Widget_AppCompat_ProgressBar_Horizontal` | int | 0x7f1403d5 | 8726 |
| `Widget_AppCompat_RatingBar` | int | 0x7f1403d6 | 8727 |
| `Widget_AppCompat_RatingBar_Indicator` | int | 0x7f1403d7 | 8728 |
| `Widget_AppCompat_RatingBar_Small` | int | 0x7f1403d8 | 8729 |
| `Widget_AppCompat_SearchView` | int | 0x7f1403d9 | 8730 |
| `Widget_AppCompat_SearchView_ActionBar` | int | 0x7f1403da | 8731 |
| `Widget_AppCompat_SeekBar` | int | 0x7f1403db | 8732 |
| `Widget_AppCompat_SeekBar_Discrete` | int | 0x7f1403dc | 8733 |
| `Widget_AppCompat_Spinner` | int | 0x7f1403dd | 8734 |
| `Widget_AppCompat_Spinner_DropDown` | int | 0x7f1403de | 8735 |
| `Widget_AppCompat_Spinner_DropDown_ActionBar` | int | 0x7f1403df | 8736 |
| `Widget_AppCompat_Spinner_Underlined` | int | 0x7f1403e0 | 8737 |
| `Widget_AppCompat_TextView` | int | 0x7f1403e1 | 8738 |
| `Widget_AppCompat_TextView_SpinnerItem` | int | 0x7f1403e2 | 8739 |
| `Widget_AppCompat_Toolbar` | int | 0x7f1403e3 | 8740 |
| `Widget_AppCompat_Toolbar_Button_Navigation` | int | 0x7f1403e4 | 8741 |
| `Widget_Compat_NotificationActionContainer` | int | 0x7f1403e5 | 8742 |
| `Widget_Compat_NotificationActionText` | int | 0x7f1403e6 | 8743 |
| `Widget_Design_AppBarLayout` | int | 0x7f1403e7 | 8744 |
| `Widget_Design_BottomNavigationView` | int | 0x7f1403e8 | 8745 |
| `Widget_Design_BottomSheet_Modal` | int | 0x7f1403e9 | 8746 |
| `Widget_Design_CollapsingToolbar` | int | 0x7f1403ea | 8747 |
| `Widget_Design_FloatingActionButton` | int | 0x7f1403eb | 8748 |
| `Widget_Design_NavigationView` | int | 0x7f1403ec | 8749 |
| `Widget_Design_ScrimInsetsFrameLayout` | int | 0x7f1403ed | 8750 |
| `Widget_Design_Snackbar` | int | 0x7f1403ee | 8751 |
| `Widget_Design_TabLayout` | int | 0x7f1403ef | 8752 |
| `Widget_Design_TextInputEditText` | int | 0x7f1403f0 | 8753 |
| `Widget_Design_TextInputLayout` | int | 0x7f1403f1 | 8754 |
| `Widget_Material3_ActionBar_Solid` | int | 0x7f1403f2 | 8755 |
| `Widget_Material3_ActionMode` | int | 0x7f1403f3 | 8756 |
| `Widget_Material3_AppBarLayout` | int | 0x7f1403f4 | 8757 |
| `Widget_Material3_AutoCompleteTextView_FilledBox` | int | 0x7f1403f5 | 8758 |
| `Widget_Material3_AutoCompleteTextView_FilledBox_Dense` | int | 0x7f1403f6 | 8759 |
| `Widget_Material3_AutoCompleteTextView_OutlinedBox` | int | 0x7f1403f7 | 8760 |
| `Widget_Material3_AutoCompleteTextView_OutlinedBox_Dense` | int | 0x7f1403f8 | 8761 |
| `Widget_Material3_Badge` | int | 0x7f1403f9 | 8762 |
| `Widget_Material3_Badge_AdjustToBounds` | int | 0x7f1403fa | 8763 |
| `Widget_Material3_BottomAppBar` | int | 0x7f1403fb | 8764 |
| `Widget_Material3_BottomAppBar_Button_Navigation` | int | 0x7f1403fc | 8765 |
| `Widget_Material3_BottomAppBar_Legacy` | int | 0x7f1403fd | 8766 |
| `Widget_Material3_BottomNavigation_Badge` | int | 0x7f1403fe | 8767 |
| `Widget_Material3_BottomNavigationView` | int | 0x7f1403ff | 8768 |
| `Widget_Material3_BottomNavigationView_ActiveIndicator` | int | 0x7f140400 | 8769 |
| `Widget_Material3_BottomSheet` | int | 0x7f140401 | 8770 |
| `Widget_Material3_BottomSheet_DragHandle` | int | 0x7f140402 | 8771 |
| `Widget_Material3_BottomSheet_Modal` | int | 0x7f140403 | 8772 |
| `Widget_Material3_Button` | int | 0x7f140404 | 8773 |
| `Widget_Material3_Button_ElevatedButton` | int | 0x7f140405 | 8774 |
| `Widget_Material3_Button_ElevatedButton_Icon` | int | 0x7f140406 | 8775 |
| `Widget_Material3_Button_Icon` | int | 0x7f140407 | 8776 |
| `Widget_Material3_Button_IconButton` | int | 0x7f140408 | 8777 |
| `Widget_Material3_Button_IconButton_Filled` | int | 0x7f140409 | 8778 |
| `Widget_Material3_Button_IconButton_Filled_Tonal` | int | 0x7f14040a | 8779 |
| `Widget_Material3_Button_IconButton_Outlined` | int | 0x7f14040b | 8780 |
| `Widget_Material3_Button_OutlinedButton` | int | 0x7f14040c | 8781 |
| `Widget_Material3_Button_OutlinedButton_Icon` | int | 0x7f14040d | 8782 |
| `Widget_Material3_Button_TextButton` | int | 0x7f14040e | 8783 |
| `Widget_Material3_Button_TextButton_Dialog` | int | 0x7f14040f | 8784 |
| `Widget_Material3_Button_TextButton_Dialog_Flush` | int | 0x7f140410 | 8785 |
| `Widget_Material3_Button_TextButton_Dialog_Icon` | int | 0x7f140411 | 8786 |
| `Widget_Material3_Button_TextButton_Icon` | int | 0x7f140412 | 8787 |
| `Widget_Material3_Button_TextButton_Snackbar` | int | 0x7f140413 | 8788 |
| `Widget_Material3_Button_TonalButton` | int | 0x7f140414 | 8789 |
| `Widget_Material3_Button_TonalButton_Icon` | int | 0x7f140415 | 8790 |
| `Widget_Material3_Button_UnelevatedButton` | int | 0x7f140416 | 8791 |
| `Widget_Material3_CardView_Elevated` | int | 0x7f140417 | 8792 |
| `Widget_Material3_CardView_Filled` | int | 0x7f140418 | 8793 |
| `Widget_Material3_CardView_Outlined` | int | 0x7f140419 | 8794 |
| `Widget_Material3_CheckedTextView` | int | 0x7f14041a | 8795 |
| `Widget_Material3_Chip_Assist` | int | 0x7f14041b | 8796 |
| `Widget_Material3_Chip_Assist_Elevated` | int | 0x7f14041c | 8797 |
| `Widget_Material3_Chip_Filter` | int | 0x7f14041d | 8798 |
| `Widget_Material3_Chip_Filter_Elevated` | int | 0x7f14041e | 8799 |
| `Widget_Material3_Chip_Input` | int | 0x7f14041f | 8800 |
| `Widget_Material3_Chip_Input_Elevated` | int | 0x7f140420 | 8801 |
| `Widget_Material3_Chip_Input_Icon` | int | 0x7f140421 | 8802 |
| `Widget_Material3_Chip_Input_Icon_Elevated` | int | 0x7f140422 | 8803 |
| `Widget_Material3_Chip_Suggestion` | int | 0x7f140423 | 8804 |
| `Widget_Material3_Chip_Suggestion_Elevated` | int | 0x7f140424 | 8805 |
| `Widget_Material3_ChipGroup` | int | 0x7f140425 | 8806 |
| `Widget_Material3_CircularProgressIndicator` | int | 0x7f140426 | 8807 |
| `Widget_Material3_CircularProgressIndicator_ExtraSmall` | int | 0x7f140427 | 8808 |
| `Widget_Material3_CircularProgressIndicator_Legacy` | int | 0x7f140428 | 8809 |
| `Widget_Material3_CircularProgressIndicator_Legacy_ExtraSmall` | int | 0x7f140429 | 8810 |
| `Widget_Material3_CircularProgressIndicator_Legacy_Medium` | int | 0x7f14042a | 8811 |
| `Widget_Material3_CircularProgressIndicator_Legacy_Small` | int | 0x7f14042b | 8812 |
| `Widget_Material3_CircularProgressIndicator_Medium` | int | 0x7f14042c | 8813 |
| `Widget_Material3_CircularProgressIndicator_Small` | int | 0x7f14042d | 8814 |
| `Widget_Material3_CollapsingToolbar` | int | 0x7f14042e | 8815 |
| `Widget_Material3_CollapsingToolbar_Large` | int | 0x7f14042f | 8816 |
| `Widget_Material3_CollapsingToolbar_Medium` | int | 0x7f140430 | 8817 |
| `Widget_Material3_CompoundButton_CheckBox` | int | 0x7f140431 | 8818 |
| `Widget_Material3_CompoundButton_MaterialSwitch` | int | 0x7f140432 | 8819 |
| `Widget_Material3_CompoundButton_RadioButton` | int | 0x7f140433 | 8820 |
| `Widget_Material3_CompoundButton_Switch` | int | 0x7f140434 | 8821 |
| `Widget_Material3_DockedToolbar` | int | 0x7f140435 | 8822 |
| `Widget_Material3_DockedToolbar_Button` | int | 0x7f140436 | 8823 |
| `Widget_Material3_DockedToolbar_Button_Vibrant` | int | 0x7f140437 | 8824 |
| `Widget_Material3_DockedToolbar_IconButton` | int | 0x7f140438 | 8825 |
| `Widget_Material3_DockedToolbar_IconButton_Vibrant` | int | 0x7f140439 | 8826 |
| `Widget_Material3_DockedToolbar_TextButton` | int | 0x7f14043a | 8827 |
| `Widget_Material3_DockedToolbar_TextButton_Vibrant` | int | 0x7f14043b | 8828 |
| `Widget_Material3_DockedToolbar_Vibrant` | int | 0x7f14043c | 8829 |
| `Widget_Material3_DrawerLayout` | int | 0x7f14043d | 8830 |
| `Widget_Material3_ExtendedFloatingActionButton_Icon_Primary` | int | 0x7f14043e | 8831 |
| `Widget_Material3_ExtendedFloatingActionButton_Icon_Secondary` | int | 0x7f14043f | 8832 |
| `Widget_Material3_ExtendedFloatingActionButton_Icon_Surface` | int | 0x7f140440 | 8833 |
| `Widget_Material3_ExtendedFloatingActionButton_Icon_Tertiary` | int | 0x7f140441 | 8834 |
| `Widget_Material3_ExtendedFloatingActionButton_Large` | int | 0x7f140442 | 8835 |
| `Widget_Material3_ExtendedFloatingActionButton_Medium` | int | 0x7f140443 | 8836 |
| `Widget_Material3_ExtendedFloatingActionButton_Primary` | int | 0x7f140444 | 8837 |
| `Widget_Material3_ExtendedFloatingActionButton_Secondary` | int | 0x7f140445 | 8838 |
| `Widget_Material3_ExtendedFloatingActionButton_Small` | int | 0x7f140446 | 8839 |
| `Widget_Material3_ExtendedFloatingActionButton_Surface` | int | 0x7f140447 | 8840 |
| `Widget_Material3_ExtendedFloatingActionButton_Tertiary` | int | 0x7f140448 | 8841 |
| `Widget_Material3_FloatingActionButton_Large_Primary` | int | 0x7f140449 | 8842 |
| `Widget_Material3_FloatingActionButton_Large_Secondary` | int | 0x7f14044a | 8843 |
| `Widget_Material3_FloatingActionButton_Large_Surface` | int | 0x7f14044b | 8844 |
| `Widget_Material3_FloatingActionButton_Large_Tertiary` | int | 0x7f14044c | 8845 |
| `Widget_Material3_FloatingActionButton_Medium` | int | 0x7f14044d | 8846 |
| `Widget_Material3_FloatingActionButton_Primary` | int | 0x7f14044e | 8847 |
| `Widget_Material3_FloatingActionButton_Secondary` | int | 0x7f14044f | 8848 |
| `Widget_Material3_FloatingActionButton_Small_Primary` | int | 0x7f140450 | 8849 |
| `Widget_Material3_FloatingActionButton_Small_Secondary` | int | 0x7f140451 | 8850 |
| `Widget_Material3_FloatingActionButton_Small_Surface` | int | 0x7f140452 | 8851 |
| `Widget_Material3_FloatingActionButton_Small_Tertiary` | int | 0x7f140453 | 8852 |
| `Widget_Material3_FloatingActionButton_Surface` | int | 0x7f140454 | 8853 |
| `Widget_Material3_FloatingActionButton_Tertiary` | int | 0x7f140455 | 8854 |
| `Widget_Material3_FloatingToolbar` | int | 0x7f140456 | 8855 |
| `Widget_Material3_FloatingToolbar_Button` | int | 0x7f140457 | 8856 |
| `Widget_Material3_FloatingToolbar_Button_Vibrant` | int | 0x7f140458 | 8857 |
| `Widget_Material3_FloatingToolbar_IconButton` | int | 0x7f140459 | 8858 |
| `Widget_Material3_FloatingToolbar_IconButton_Vibrant` | int | 0x7f14045a | 8859 |
| `Widget_Material3_FloatingToolbar_TextButton` | int | 0x7f14045b | 8860 |
| `Widget_Material3_FloatingToolbar_TextButton_Vibrant` | int | 0x7f14045c | 8861 |
| `Widget_Material3_FloatingToolbar_Vibrant` | int | 0x7f14045d | 8862 |
| `Widget_Material3_Light_ActionBar_Solid` | int | 0x7f14045e | 8863 |
| `Widget_Material3_LinearProgressIndicator` | int | 0x7f14045f | 8864 |
| `Widget_Material3_LinearProgressIndicator_Legacy` | int | 0x7f140460 | 8865 |
| `Widget_Material3_LoadingIndicator` | int | 0x7f140461 | 8866 |
| `Widget_Material3_LoadingIndicator_Contained` | int | 0x7f140462 | 8867 |
| `Widget_Material3_MaterialButtonGroup` | int | 0x7f140463 | 8868 |
| `Widget_Material3_MaterialButtonGroup_Connected` | int | 0x7f140464 | 8869 |
| `Widget_Material3_MaterialButtonToggleGroup` | int | 0x7f140465 | 8870 |
| `Widget_Material3_MaterialCalendar` | int | 0x7f140466 | 8871 |
| `Widget_Material3_MaterialCalendar_Day` | int | 0x7f140467 | 8872 |
| `Widget_Material3_MaterialCalendar_Day_Invalid` | int | 0x7f140468 | 8873 |
| `Widget_Material3_MaterialCalendar_Day_Selected` | int | 0x7f140469 | 8874 |
| `Widget_Material3_MaterialCalendar_Day_Today` | int | 0x7f14046a | 8875 |
| `Widget_Material3_MaterialCalendar_DayOfWeekLabel` | int | 0x7f14046b | 8876 |
| `Widget_Material3_MaterialCalendar_DayTextView` | int | 0x7f14046c | 8877 |
| `Widget_Material3_MaterialCalendar_Fullscreen` | int | 0x7f14046d | 8878 |
| `Widget_Material3_MaterialCalendar_HeaderCancelButton` | int | 0x7f14046e | 8879 |
| `Widget_Material3_MaterialCalendar_HeaderDivider` | int | 0x7f14046f | 8880 |
| `Widget_Material3_MaterialCalendar_HeaderLayout` | int | 0x7f140470 | 8881 |
| `Widget_Material3_MaterialCalendar_HeaderLayout_Fullscreen` | int | 0x7f140471 | 8882 |
| `Widget_Material3_MaterialCalendar_HeaderSelection` | int | 0x7f140472 | 8883 |
| `Widget_Material3_MaterialCalendar_HeaderSelection_Fullscreen` | int | 0x7f140473 | 8884 |
| `Widget_Material3_MaterialCalendar_HeaderTitle` | int | 0x7f140474 | 8885 |
| `Widget_Material3_MaterialCalendar_HeaderToggleButton` | int | 0x7f140475 | 8886 |
| `Widget_Material3_MaterialCalendar_Item` | int | 0x7f140476 | 8887 |
| `Widget_Material3_MaterialCalendar_MonthNavigationButton` | int | 0x7f140477 | 8888 |
| `Widget_Material3_MaterialCalendar_MonthTextView` | int | 0x7f140478 | 8889 |
| `Widget_Material3_MaterialCalendar_Year` | int | 0x7f140479 | 8890 |
| `Widget_Material3_MaterialCalendar_Year_Selected` | int | 0x7f14047a | 8891 |
| `Widget_Material3_MaterialCalendar_Year_Today` | int | 0x7f14047b | 8892 |
| `Widget_Material3_MaterialCalendar_YearNavigationButton` | int | 0x7f14047c | 8893 |
| `Widget_Material3_MaterialDivider` | int | 0x7f14047d | 8894 |
| `Widget_Material3_MaterialDivider_Heavy` | int | 0x7f14047e | 8895 |
| `Widget_Material3_MaterialSplitButton` | int | 0x7f14047f | 8896 |
| `Widget_Material3_MaterialTimePicker` | int | 0x7f140480 | 8897 |
| `Widget_Material3_MaterialTimePicker_Button` | int | 0x7f140481 | 8898 |
| `Widget_Material3_MaterialTimePicker_Clock` | int | 0x7f140482 | 8899 |
| `Widget_Material3_MaterialTimePicker_Display` | int | 0x7f140483 | 8900 |
| `Widget_Material3_MaterialTimePicker_Display_Divider` | int | 0x7f140484 | 8901 |
| `Widget_Material3_MaterialTimePicker_Display_HelperText` | int | 0x7f140485 | 8902 |
| `Widget_Material3_MaterialTimePicker_Display_TextInputEditText` | int | 0x7f140486 | 8903 |
| `Widget_Material3_MaterialTimePicker_Display_TextInputLayout` | int | 0x7f140487 | 8904 |
| `Widget_Material3_MaterialTimePicker_ImageButton` | int | 0x7f140488 | 8905 |
| `Widget_Material3_NavigationRailView` | int | 0x7f140489 | 8906 |
| `Widget_Material3_NavigationRailView_ActiveIndicator` | int | 0x7f14048a | 8907 |
| `Widget_Material3_NavigationRailView_Badge` | int | 0x7f14048b | 8908 |
| `Widget_Material3_NavigationView` | int | 0x7f14048c | 8909 |
| `Widget_Material3_PopupMenu` | int | 0x7f14048d | 8910 |
| `Widget_Material3_PopupMenu_ContextMenu` | int | 0x7f14048e | 8911 |
| `Widget_Material3_PopupMenu_ListPopupWindow` | int | 0x7f14048f | 8912 |
| `Widget_Material3_PopupMenu_Overflow` | int | 0x7f140490 | 8913 |
| `Widget_Material3_Search_ActionButton_Overflow` | int | 0x7f140491 | 8914 |
| `Widget_Material3_Search_Toolbar_Button_Navigation` | int | 0x7f140492 | 8915 |
| `Widget_Material3_SearchBar` | int | 0x7f140493 | 8916 |
| `Widget_Material3_SearchBar_Outlined` | int | 0x7f140494 | 8917 |
| `Widget_Material3_SearchView` | int | 0x7f140495 | 8918 |
| `Widget_Material3_SearchView_Prefix` | int | 0x7f140496 | 8919 |
| `Widget_Material3_SearchView_Toolbar` | int | 0x7f140497 | 8920 |
| `Widget_Material3_SideSheet` | int | 0x7f140498 | 8921 |
| `Widget_Material3_SideSheet_Detached` | int | 0x7f140499 | 8922 |
| `Widget_Material3_SideSheet_Modal` | int | 0x7f14049a | 8923 |
| `Widget_Material3_SideSheet_Modal_Detached` | int | 0x7f14049b | 8924 |
| `Widget_Material3_Slider` | int | 0x7f14049c | 8925 |
| `Widget_Material3_Slider_Label` | int | 0x7f14049d | 8926 |
| `Widget_Material3_Slider_Legacy` | int | 0x7f14049e | 8927 |
| `Widget_Material3_Slider_Legacy_Label` | int | 0x7f14049f | 8928 |
| `Widget_Material3_Snackbar` | int | 0x7f1404a0 | 8929 |
| `Widget_Material3_Snackbar_FullWidth` | int | 0x7f1404a1 | 8930 |
| `Widget_Material3_Snackbar_TextView` | int | 0x7f1404a2 | 8931 |
| `Widget_Material3_SplitButton_IconButton_Filled` | int | 0x7f1404a3 | 8932 |
| `Widget_Material3_SplitButton_IconButton_Filled_Tonal` | int | 0x7f1404a4 | 8933 |
| `Widget_Material3_SplitButton_LeadingButton_Filled` | int | 0x7f1404a5 | 8934 |
| `Widget_Material3_SplitButton_LeadingButton_Filled_Tonal` | int | 0x7f1404a6 | 8935 |
| `Widget_Material3_TabLayout` | int | 0x7f1404a7 | 8936 |
| `Widget_Material3_TabLayout_OnSurface` | int | 0x7f1404a8 | 8937 |
| `Widget_Material3_TabLayout_Secondary` | int | 0x7f1404a9 | 8938 |
| `Widget_Material3_TextInputEditText_FilledBox` | int | 0x7f1404aa | 8939 |
| `Widget_Material3_TextInputEditText_FilledBox_Dense` | int | 0x7f1404ab | 8940 |
| `Widget_Material3_TextInputEditText_OutlinedBox` | int | 0x7f1404ac | 8941 |
| `Widget_Material3_TextInputEditText_OutlinedBox_Dense` | int | 0x7f1404ad | 8942 |
| `Widget_Material3_TextInputLayout_FilledBox` | int | 0x7f1404ae | 8943 |
| `Widget_Material3_TextInputLayout_FilledBox_Dense` | int | 0x7f1404af | 8944 |
| `Widget_Material3_TextInputLayout_FilledBox_Dense_ExposedDropdownMenu` | int | 0x7f1404b0 | 8945 |
| `Widget_Material3_TextInputLayout_FilledBox_ExposedDropdownMenu` | int | 0x7f1404b1 | 8946 |
| `Widget_Material3_TextInputLayout_OutlinedBox` | int | 0x7f1404b2 | 8947 |
| `Widget_Material3_TextInputLayout_OutlinedBox_Dense` | int | 0x7f1404b3 | 8948 |
| `Widget_Material3_TextInputLayout_OutlinedBox_Dense_ExposedDropdownMenu` | int | 0x7f1404b4 | 8949 |
| `Widget_Material3_TextInputLayout_OutlinedBox_ExposedDropdownMenu` | int | 0x7f1404b5 | 8950 |
| `Widget_Material3_Toolbar` | int | 0x7f1404b6 | 8951 |
| `Widget_Material3_Toolbar_OnSurface` | int | 0x7f1404b7 | 8952 |
| `Widget_Material3_Toolbar_Surface` | int | 0x7f1404b8 | 8953 |
| `Widget_Material3_Tooltip` | int | 0x7f1404b9 | 8954 |
| `Widget_MaterialComponents_ActionBar_Primary` | int | 0x7f1404ba | 8955 |
| `Widget_MaterialComponents_ActionBar_PrimarySurface` | int | 0x7f1404bb | 8956 |
| `Widget_MaterialComponents_ActionBar_Solid` | int | 0x7f1404bc | 8957 |
| `Widget_MaterialComponents_ActionBar_Surface` | int | 0x7f1404bd | 8958 |
| `Widget_MaterialComponents_ActionMode` | int | 0x7f1404be | 8959 |
| `Widget_MaterialComponents_AppBarLayout_Primary` | int | 0x7f1404bf | 8960 |
| `Widget_MaterialComponents_AppBarLayout_PrimarySurface` | int | 0x7f1404c0 | 8961 |
| `Widget_MaterialComponents_AppBarLayout_Surface` | int | 0x7f1404c1 | 8962 |
| `Widget_MaterialComponents_AutoCompleteTextView_FilledBox` | int | 0x7f1404c2 | 8963 |
| `Widget_MaterialComponents_AutoCompleteTextView_FilledBox_Dense` | int | 0x7f1404c3 | 8964 |
| `Widget_MaterialComponents_AutoCompleteTextView_OutlinedBox` | int | 0x7f1404c4 | 8965 |
| `Widget_MaterialComponents_AutoCompleteTextView_OutlinedBox_Dense` | int | 0x7f1404c5 | 8966 |
| `Widget_MaterialComponents_Badge` | int | 0x7f1404c6 | 8967 |
| `Widget_MaterialComponents_BottomAppBar` | int | 0x7f1404c7 | 8968 |
| `Widget_MaterialComponents_BottomAppBar_Colored` | int | 0x7f1404c8 | 8969 |
| `Widget_MaterialComponents_BottomAppBar_PrimarySurface` | int | 0x7f1404c9 | 8970 |
| `Widget_MaterialComponents_BottomNavigationView` | int | 0x7f1404ca | 8971 |
| `Widget_MaterialComponents_BottomNavigationView_Colored` | int | 0x7f1404cb | 8972 |
| `Widget_MaterialComponents_BottomNavigationView_PrimarySurface` | int | 0x7f1404cc | 8973 |
| `Widget_MaterialComponents_BottomSheet` | int | 0x7f1404cd | 8974 |
| `Widget_MaterialComponents_BottomSheet_Modal` | int | 0x7f1404ce | 8975 |
| `Widget_MaterialComponents_Button` | int | 0x7f1404cf | 8976 |
| `Widget_MaterialComponents_Button_Icon` | int | 0x7f1404d0 | 8977 |
| `Widget_MaterialComponents_Button_OutlinedButton` | int | 0x7f1404d1 | 8978 |
| `Widget_MaterialComponents_Button_OutlinedButton_Icon` | int | 0x7f1404d2 | 8979 |
| `Widget_MaterialComponents_Button_TextButton` | int | 0x7f1404d3 | 8980 |
| `Widget_MaterialComponents_Button_TextButton_Dialog` | int | 0x7f1404d4 | 8981 |
| `Widget_MaterialComponents_Button_TextButton_Dialog_Flush` | int | 0x7f1404d5 | 8982 |
| `Widget_MaterialComponents_Button_TextButton_Dialog_Icon` | int | 0x7f1404d6 | 8983 |
| `Widget_MaterialComponents_Button_TextButton_Icon` | int | 0x7f1404d7 | 8984 |
| `Widget_MaterialComponents_Button_TextButton_Snackbar` | int | 0x7f1404d8 | 8985 |
| `Widget_MaterialComponents_Button_UnelevatedButton` | int | 0x7f1404d9 | 8986 |
| `Widget_MaterialComponents_Button_UnelevatedButton_Icon` | int | 0x7f1404da | 8987 |
| `Widget_MaterialComponents_CardView` | int | 0x7f1404db | 8988 |
| `Widget_MaterialComponents_CheckedTextView` | int | 0x7f1404dc | 8989 |
| `Widget_MaterialComponents_Chip_Action` | int | 0x7f1404dd | 8990 |
| `Widget_MaterialComponents_Chip_Choice` | int | 0x7f1404de | 8991 |
| `Widget_MaterialComponents_Chip_Entry` | int | 0x7f1404df | 8992 |
| `Widget_MaterialComponents_Chip_Filter` | int | 0x7f1404e0 | 8993 |
| `Widget_MaterialComponents_ChipGroup` | int | 0x7f1404e1 | 8994 |
| `Widget_MaterialComponents_CircularProgressIndicator` | int | 0x7f1404e2 | 8995 |
| `Widget_MaterialComponents_CircularProgressIndicator_ExtraSmall` | int | 0x7f1404e3 | 8996 |
| `Widget_MaterialComponents_CircularProgressIndicator_Medium` | int | 0x7f1404e4 | 8997 |
| `Widget_MaterialComponents_CircularProgressIndicator_Small` | int | 0x7f1404e5 | 8998 |
| `Widget_MaterialComponents_CollapsingToolbar` | int | 0x7f1404e6 | 8999 |
| `Widget_MaterialComponents_CompoundButton_CheckBox` | int | 0x7f1404e7 | 9000 |
| `Widget_MaterialComponents_CompoundButton_RadioButton` | int | 0x7f1404e8 | 9001 |
| `Widget_MaterialComponents_CompoundButton_Switch` | int | 0x7f1404e9 | 9002 |
| `Widget_MaterialComponents_ExtendedFloatingActionButton` | int | 0x7f1404ea | 9003 |
| `Widget_MaterialComponents_ExtendedFloatingActionButton_Icon` | int | 0x7f1404eb | 9004 |
| `Widget_MaterialComponents_FloatingActionButton` | int | 0x7f1404ec | 9005 |
| `Widget_MaterialComponents_Light_ActionBar_Solid` | int | 0x7f1404ed | 9006 |
| `Widget_MaterialComponents_LinearProgressIndicator` | int | 0x7f1404ee | 9007 |
| `Widget_MaterialComponents_MaterialButtonToggleGroup` | int | 0x7f1404ef | 9008 |
| `Widget_MaterialComponents_MaterialCalendar` | int | 0x7f1404f0 | 9009 |
| `Widget_MaterialComponents_MaterialCalendar_Day` | int | 0x7f1404f1 | 9010 |
| `Widget_MaterialComponents_MaterialCalendar_Day_Invalid` | int | 0x7f1404f2 | 9011 |
| `Widget_MaterialComponents_MaterialCalendar_Day_Selected` | int | 0x7f1404f3 | 9012 |
| `Widget_MaterialComponents_MaterialCalendar_Day_Today` | int | 0x7f1404f4 | 9013 |
| `Widget_MaterialComponents_MaterialCalendar_DayOfWeekLabel` | int | 0x7f1404f5 | 9014 |
| `Widget_MaterialComponents_MaterialCalendar_DayTextView` | int | 0x7f1404f6 | 9015 |
| `Widget_MaterialComponents_MaterialCalendar_Fullscreen` | int | 0x7f1404f7 | 9016 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderCancelButton` | int | 0x7f1404f8 | 9017 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderConfirmButton` | int | 0x7f1404f9 | 9018 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderDivider` | int | 0x7f1404fa | 9019 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderLayout` | int | 0x7f1404fb | 9020 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderLayout_Fullscreen` | int | 0x7f1404fc | 9021 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderSelection` | int | 0x7f1404fd | 9022 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderSelection_Fullscreen` | int | 0x7f1404fe | 9023 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderTitle` | int | 0x7f1404ff | 9024 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderToggleButton` | int | 0x7f140500 | 9025 |
| `Widget_MaterialComponents_MaterialCalendar_Item` | int | 0x7f140501 | 9026 |
| `Widget_MaterialComponents_MaterialCalendar_MonthNavigationButton` | int | 0x7f140502 | 9027 |
| `Widget_MaterialComponents_MaterialCalendar_MonthTextView` | int | 0x7f140503 | 9028 |
| `Widget_MaterialComponents_MaterialCalendar_Year` | int | 0x7f140504 | 9029 |
| `Widget_MaterialComponents_MaterialCalendar_Year_Selected` | int | 0x7f140505 | 9030 |
| `Widget_MaterialComponents_MaterialCalendar_Year_Today` | int | 0x7f140506 | 9031 |
| `Widget_MaterialComponents_MaterialCalendar_YearNavigationButton` | int | 0x7f140507 | 9032 |
| `Widget_MaterialComponents_MaterialDivider` | int | 0x7f140508 | 9033 |
| `Widget_MaterialComponents_NavigationRailView` | int | 0x7f140509 | 9034 |
| `Widget_MaterialComponents_NavigationRailView_Colored` | int | 0x7f14050a | 9035 |
| `Widget_MaterialComponents_NavigationRailView_Colored_Compact` | int | 0x7f14050b | 9036 |
| `Widget_MaterialComponents_NavigationRailView_Compact` | int | 0x7f14050c | 9037 |
| `Widget_MaterialComponents_NavigationRailView_PrimarySurface` | int | 0x7f14050d | 9038 |
| `Widget_MaterialComponents_NavigationView` | int | 0x7f14050e | 9039 |
| `Widget_MaterialComponents_PopupMenu` | int | 0x7f14050f | 9040 |
| `Widget_MaterialComponents_PopupMenu_ContextMenu` | int | 0x7f140510 | 9041 |
| `Widget_MaterialComponents_PopupMenu_ListPopupWindow` | int | 0x7f140511 | 9042 |
| `Widget_MaterialComponents_PopupMenu_Overflow` | int | 0x7f140512 | 9043 |
| `Widget_MaterialComponents_ProgressIndicator` | int | 0x7f140513 | 9044 |
| `Widget_MaterialComponents_ShapeableImageView` | int | 0x7f140514 | 9045 |
| `Widget_MaterialComponents_Slider` | int | 0x7f140515 | 9046 |
| `Widget_MaterialComponents_Snackbar` | int | 0x7f140516 | 9047 |
| `Widget_MaterialComponents_Snackbar_FullWidth` | int | 0x7f140517 | 9048 |
| `Widget_MaterialComponents_Snackbar_TextView` | int | 0x7f140518 | 9049 |
| `Widget_MaterialComponents_TabLayout` | int | 0x7f140519 | 9050 |
| `Widget_MaterialComponents_TabLayout_Colored` | int | 0x7f14051a | 9051 |
| `Widget_MaterialComponents_TabLayout_PrimarySurface` | int | 0x7f14051b | 9052 |
| `Widget_MaterialComponents_TextInputEditText_FilledBox` | int | 0x7f14051c | 9053 |
| `Widget_MaterialComponents_TextInputEditText_FilledBox_Dense` | int | 0x7f14051d | 9054 |
| `Widget_MaterialComponents_TextInputEditText_OutlinedBox` | int | 0x7f14051e | 9055 |
| `Widget_MaterialComponents_TextInputEditText_OutlinedBox_Dense` | int | 0x7f14051f | 9056 |
| `Widget_MaterialComponents_TextInputLayout_FilledBox` | int | 0x7f140520 | 9057 |
| `Widget_MaterialComponents_TextInputLayout_FilledBox_Dense` | int | 0x7f140521 | 9058 |
| `Widget_MaterialComponents_TextInputLayout_FilledBox_Dense_ExposedDropdownMenu` | int | 0x7f140522 | 9059 |
| `Widget_MaterialComponents_TextInputLayout_FilledBox_ExposedDropdownMenu` | int | 0x7f140523 | 9060 |
| `Widget_MaterialComponents_TextInputLayout_OutlinedBox` | int | 0x7f140524 | 9061 |
| `Widget_MaterialComponents_TextInputLayout_OutlinedBox_Dense` | int | 0x7f140525 | 9062 |
| `Widget_MaterialComponents_TextInputLayout_OutlinedBox_Dense_ExposedDropdownMenu` | int | 0x7f140526 | 9063 |
| `Widget_MaterialComponents_TextInputLayout_OutlinedBox_ExposedDropdownMenu` | int | 0x7f140527 | 9064 |
| `Widget_MaterialComponents_TextView` | int | 0x7f140528 | 9065 |
| `Widget_MaterialComponents_TimePicker` | int | 0x7f140529 | 9066 |
| `Widget_MaterialComponents_TimePicker_Button` | int | 0x7f14052a | 9067 |
| `Widget_MaterialComponents_TimePicker_Clock` | int | 0x7f14052b | 9068 |
| `Widget_MaterialComponents_TimePicker_Display` | int | 0x7f14052c | 9069 |
| `Widget_MaterialComponents_TimePicker_Display_Divider` | int | 0x7f14052d | 9070 |
| `Widget_MaterialComponents_TimePicker_Display_HelperText` | int | 0x7f14052e | 9071 |
| `Widget_MaterialComponents_TimePicker_Display_TextInputEditText` | int | 0x7f14052f | 9072 |
| `Widget_MaterialComponents_TimePicker_Display_TextInputLayout` | int | 0x7f140530 | 9073 |
| `Widget_MaterialComponents_TimePicker_ImageButton` | int | 0x7f140531 | 9074 |
| `Widget_MaterialComponents_TimePicker_ImageButton_ShapeAppearance` | int | 0x7f140532 | 9075 |
| `Widget_MaterialComponents_Toolbar` | int | 0x7f140533 | 9076 |
| `Widget_MaterialComponents_Toolbar_Primary` | int | 0x7f140534 | 9077 |
| `Widget_MaterialComponents_Toolbar_PrimarySurface` | int | 0x7f140535 | 9078 |
| `Widget_MaterialComponents_Toolbar_Surface` | int | 0x7f140536 | 9079 |
| `Widget_MaterialComponents_Tooltip` | int | 0x7f140537 | 9080 |
| `Widget_Support_CoordinatorLayout` | int | 0x7f140538 | 9081 |

### `com.id221.golive.R$xml`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ad_services_config` | int | 0x7f160000 | 9124 |
| `album_camera_provider` | int | 0x7f160001 | 9125 |
| `device_filter` | int | 0x7f160002 | 9126 |
| `file_provider_path` | int | 0x7f160003 | 9127 |
| `jz_network_security_config` | int | 0x7f160004 | 9128 |
| `m3_button_group_child_size_change` | int | 0x7f160005 | 9129 |
| `m3_split_button_inner_corner_size_state_list` | int | 0x7f160006 | 9130 |
| `m3expressive_button_shape_state_list` | int | 0x7f160007 | 9131 |
| `m3expressive_connected_buttons_inner_corner_size_state_list` | int | 0x7f160008 | 9132 |
| `network_security_config` | int | 0x7f160009 | 9133 |

### `com.tinyai.libmediacomponent.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APPLICATION_ID` | String | "com.tinyai.libmediacomponent" | 7 |
| `BUILD_TYPE` | String | "debug" | 8 |
| `FLAVOR` | String | "<binary/metadata>" | 10 |
| `VERSION_CODE` | int | 1 | 11 |
| `VERSION_NAME` | String | "V0.0.1" | 12 |

### `com.tinyai.libmediacomponent.components.cameralist.DeviceListView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileListView" | 16 |

### `com.tinyai.libmediacomponent.components.cameralist.DeviceType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_LOCAL` | int | 0 | 5 |
| `TYPE_REMOTE` | int | 1 | 6 |

### `com.tinyai.libmediacomponent.components.filelist.FileListRecyclerViewAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileListRecyclerViewAdapter" | 32 |
| `TYPE_GRID` | int | 1 | 33 |
| `TYPE_LIST` | int | 2 | 34 |
| `TYPE_QUICK_LIST` | int | 3 | 35 |

### `com.tinyai.libmediacomponent.components.filelist.FileListView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileListView" | 25 |

### `com.tinyai.libmediacomponent.components.filelist.FileListView2`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileListView" | 22 |

### `com.tinyai.libmediacomponent.components.filelist.FileListViewAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileListViewAdapter" | 31 |

### `com.tinyai.libmediacomponent.components.filelist.MultiPbRecyclerViewAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_GRID` | int | 1 | 23 |
| `TYPE_LIST` | int | 2 | 24 |
| `TYPE_QUICK_LIST` | int | 3 | 25 |

### `com.tinyai.libmediacomponent.components.filelist.PhotoWallLayoutType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PREVIEW_TYPE_GRID` | int | 1 | 5 |
| `PREVIEW_TYPE_LIST` | int | 0 | 6 |
| `PREVIEW_TYPE_QUICK_LIST` | int | 2 | 7 |

### `com.tinyai.libmediacomponent.components.filelist.RefreshMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BOTH` | int | 3 | 5 |
| `DISABLED` | int | 0 | 6 |
| `MANUAL_REFRESH_ONLY` | int | 4 | 7 |
| `PULL_FROM_END` | int | 2 | 8 |
| `PULL_FROM_START` | int | 1 | 9 |

### `com.tinyai.libmediacomponent.components.media.audio.AudioPlayerView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AudioPlayerView" | 19 |

### `com.tinyai.libmediacomponent.components.media.MPreviewView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DRAG` | int | 1 | 40 |
| `MAX_SCALE` | float | 5.0f | 41 |
| `MID_SCALE` | float | 2.5f | 42 |
| `MIN_DISTANCE` | float | 100.0f | 43 |
| `MIN_SCALE` | float | 1.0f | 44 |
| `NONE` | int | 0 | 45 |
| `ZOOM` | int | 2 | 47 |

### `com.tinyai.libmediacomponent.components.media.PanoramaTouchTool`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_ZOOM` | float | 2.2f | 11 |
| `MIN_ZOOM` | float | 0.5f | 12 |

### `com.tinyai.libmediacomponent.components.media.PreviewControlView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_SHOW_TIMEOUT_MS` | int | 5000 | 22 |
| `MAX_UPDATE_INTERVAL_MS` | int | 1000 | 23 |

### `com.tinyai.libmediacomponent.components.media.type.PreviewRenderType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APP_RENDER` | int | 1 | 5 |
| `EXTERNAL_RENDER` | int | 2 | 6 |
| `SDK_RENDER` | int | 0 | 7 |

### `com.tinyai.libmediacomponent.components.media.VideoControlView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CACHE_LOADED` | int | 2 | 37 |
| `CACHE_LOADING` | int | 1 | 38 |
| `DEFAULT_SHOW_TIMEOUT_MS` | int | 5000 | 39 |
| `ENLARGE_RATE` | int | 100 | 40 |
| `MAX_UPDATE_INTERVAL_MS` | int | 1000 | 41 |
| `TAG` | String | "VideoControlView" | 42 |

### `com.tinyai.libmediacomponent.components.setting.CategoryAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_CATEGORY_ITEM` | int | 0 | 16 |
| `TYPE_ITEM` | int | 1 | 17 |

### `com.tinyai.libmediacomponent.components.setting.CommonItemLayout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CommonItemLayout" | 16 |

### `com.tinyai.libmediacomponent.components.setting.CustomDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CustomDialog" | 12 |

### `com.tinyai.libmediacomponent.components.setting.SettingAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SettingAdapter" | 16 |
| `TYPE_CATEGORY_ITEM` | int | 0 | 17 |
| `TYPE_ITEM` | int | 1 | 18 |

### `com.tinyai.libmediacomponent.engine.CameraPreferences`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_NAME` | String | "storeInfo" | 19 |
| `isDebug` | boolean | true | 23 |
| `PUSH_TEST` | String | "pushTest" | 21 |
| `TAG` | String | "CameraPreferences" | 22 |

### `com.tinyai.libmediacomponent.engine.streaming.exception.PreviewingByOthersException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | 1 | 5 |

### `com.tinyai.libmediacomponent.engine.streaming.Headset.HeadsetBase`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "HeadsetBase" | 13 |

### `com.tinyai.libmediacomponent.engine.streaming.render.CodecType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CODEC_H264` | int | 41 | 5 |
| `CODEC_RGBA_8888` | int | 149 | 6 |

### `com.tinyai.libmediacomponent.engine.streaming.render.RgbaDecoderThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MjpgDecoderThread" | 21 |

### `com.tinyai.libmediacomponent.engine.streaming.type.FileType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_TYPE_ALL` | int | 31 | 5 |
| `FILE_TYPE_AUDIO` | int | 4 | 6 |
| `FILE_TYPE_EMERGENCY_VIDEO` | int | 16 | 7 |
| `FILE_TYPE_IMAGE` | int | 1 | 8 |
| `FILE_TYPE_TEXT` | int | 8 | 9 |
| `FILE_TYPE_VIDEO` | int | 2 | 10 |

### `com.tinyai.libmediacomponent.engine.streaming.type.StreamMessage`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EVENT_AUDIO_TIMEOUT` | int | 4102 | 5 |
| `EVENT_CACHE_PROGRESS_NOTIFY` | int | 4098 | 6 |
| `EVENT_CACHE_STATE_CHANGED` | int | 4097 | 7 |
| `EVENT_VIDEO_PLAY_COMPLETED` | int | 4099 | 8 |
| `EVENT_VIDEO_PLAY_PTS` | int | 4104 | 9 |
| `EVENT_VIDEO_TIMEOUT` | int | 4103 | 10 |
| `MESSAGE_CANCEL_VIDEO_DOWNLOAD` | int | 4101 | 11 |
| `MESSAGE_UPDATE_VIDEOPB_BAR` | int | 4100 | 12 |
| `STREAM_MESSAGE` | int | 4096 | 13 |

### `com.tinyai.libmediacomponent.engine.streaming.type.StreamType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PREVIEW_STREAM` | int | 0 | 5 |
| `VIDEO_STREAM` | int | 1 | 6 |

### `com.tinyai.libmediacomponent.engine.streaming.type.SurfaceType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SURFACE_TYPE_SURFACE_VIEW` | int | 1 | 5 |
| `SURFACE_TYPE_TEXTURE_VIEW` | int | 2 | 6 |

### `com.tinyai.libmediacomponent.utils.AppInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACCOUNT_SERVER_ADDRESS_CN` | String | "api.bpsc.tinyai.top" | 6 |
| `ACCOUNT_SERVER_ADDRESS_USA` | String | "usa.boi.tinyai.top" | 7 |
| `ACCOUNT_SERVER_BASE_URL_CN` | String | "https://api.bpsc.tinyai.top:3026" | 9 |
| `ACCOUNT_SERVER_BASE_URL_INDEX_MAX` | int | 255 | 11 |
| `ACCOUNT_SERVER_BASE_URL_INDEX_PREFIX` | String | "URL_" | 12 |
| `ACCOUNT_SERVER_BASE_URL_USA` | String | "http://usa.boi.tinyai.top:3006" | 13 |
| `ACCOUNT_SERVER_DEFAULT_REGION` | String | "ap-northeast-1" | 14 |
| `ACCOUNT_SERVER_REGION_AP_EAST_1` | String | "ap-east-1" | 16 |
| `ACCOUNT_SERVER_REGION_AP_NORTHEAST_1` | String | "ap-northeast-1" | 17 |
| `ACCOUNT_SERVER_REGION_CN_NORTHWEST_1` | String | "cn-northwest-1" | 18 |
| `ACCOUNT_SERVER_REGION_CUSTOMIZATION_PREFIX` | String | "customization-" | 19 |
| `ACCOUNT_SERVER_REGION_US_WEST_1` | String | "us-west-1" | 20 |
| `APP_LOG_DIRECTORY_PATH` | String | "/BpSCam_APP_Log/" | 21 |
| `APP_LOG_TAG` | String | "BpSCamAPP_" | 22 |
| `CUSTOMER_PRIVACY_POLICY_VERSION` | String | "1.0" | 24 |
| `DOWNLOAD_PATH` | String | "/DCIM/BpSCam/" | 25 |
| `enableMsgCenter` | boolean | true | 46 |
| `enableTalk` | boolean | true | 47 |
| `FILE_FILTER_FILE_NAME` | String | "file_filter.dat" | 26 |
| `ICATCH_PUSH_APP_KEY` | String | "XXXXXXX1C5262CC1" | 27 |
| `ICATCH_PUSH_APP_SECRET` | String | "784DDA534A18B1AE76" | 28 |
| `KVS_WEBRTC_REGION_HK` | String | "ap-east-1" | 30 |
| `KVS_WEBRTC_REGION_TOKYO` | String | "ap-northeast-1" | 31 |
| `NOT_AVAILABLE_DEVICE_NAME` | String | "NA" | 32 |
| `PROPERTY_CFG_DIRECTORY_PATH` | String | "/BpSCamResoure/" | 33 |
| `PROPERTY_CFG_FILE_NAME` | String | "netconfig.properties" | 34 |
| `PUSH_SERVER_ADDRESS` | String | "push.smarthome.icatchtek.com" | 35 |
| `PV_THUMB_PATH` | String | "/PVThumb/" | 37 |
| `SDK_LOG_DIRECTORY_PATH` | String | "/BpSCam_SDK_Log/" | 38 |
| `SETUP_DEFAULT_DEVICE_NAME_PREFIX` | String | "BpSCam_" | 40 |
| `SHARE_CAMERA_DEADLINE_DAYS` | int | 7 | 41 |
| `SHARE_QR_CODE_PATH` | String | "/ShareQrCode/" | 42 |
| `showBatteryIcon` | boolean | true | 56 |
| `SIMPLELINK_LOG_DIRECTORY_PATH` | String | "/BpSCam_SimpleLink_Log/" | 43 |
| `STREAM_OUTPUT_DIRECTORY_PATH` | String | "/BpSCamResoure/Raw/" | 44 |
| `useUSAServer` | boolean | false | 58 |

### `com.tinyai.libmediacomponent.utils.AudioFocusUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AudioFocusUtil" | 10 |

### `com.tinyai.libmediacomponent.utils.log.MediaLog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `maxFileSize` | long | 52428800 | 24 |
| `TAG` | String | "AppLog [Media]" | 20 |

### `com.tonicartos.widget.stickygridheaders.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APPLICATION_ID` | String | "com.tonicartos.widget.stickygridheaders" | 5 |
| `BUILD_TYPE` | String | "release" | 6 |
| `DEBUG` | boolean | false | 7 |
| `FLAVOR` | String | "<binary/metadata>" | 8 |
| `VERSION_CODE` | int | 1 | 9 |
| `VERSION_NAME` | String | "1.0" | 10 |

### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersBaseAdapterWrapper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ID_FILLER` | int | -2 | 13 |
| `ID_HEADER` | int | -1 | 14 |
| `ID_HEADER_FILLER` | int | -3 | 15 |
| `POSITION_FILLER` | int | -1 | 16 |
| `POSITION_HEADER` | int | -2 | 17 |
| `POSITION_HEADER_FILLER` | int | -3 | 18 |
| `sNumViewTypes` | int | 3 | 22 |
| `VIEW_TYPE_FILLER` | int | 0 | 19 |
| `VIEW_TYPE_HEADER` | int | 1 | 20 |
| `VIEW_TYPE_HEADER_FILLER` | int | 2 | 21 |

### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ERROR_PLATFORM` | String | "Error supporting platform " + Build.VERSION.SDK_INT + "." | 69 |
| `MATCHED_STICKIED_HEADER` | int | -2 | 28 |
| `NO_MATCHED_HEADER` | int | -1 | 29 |
| `TAG` | String | "StickyGridHeadersGridView" | 70 |
| `TOUCH_MODE_DONE_WAITING` | int | 2 | 30 |
| `TOUCH_MODE_DOWN` | int | 0 | 31 |
| `TOUCH_MODE_FINISHED_LONG_PRESS` | int | -2 | 32 |
| `TOUCH_MODE_REST` | int | -1 | 33 |
| `TOUCH_MODE_TAP` | int | 1 | 34 |

### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersGridView$RuntimePlatformSupportException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `serialVersionUID` | long | -6512098808936536538L | 157 |

### `com.tonicartos.widget.stickygridheaders.StickyGridHeadersSimpleArrayAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "StickyGridHeadersSimpleArrayAdapter" | 15 |
