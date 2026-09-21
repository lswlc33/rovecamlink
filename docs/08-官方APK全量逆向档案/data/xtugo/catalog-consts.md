# XTU GO — 常量字面值全量目录

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 13517 个 static final 常量，分布在 563 个类里；按类分组，值为 jadx 反编译后的字面量
> 数值常量是端口/超时/枚举 id/缓冲大小的唯一真相来源；字符串常量常在 `catalog-http.md`/`catalog-templates.md` 里再出现一次

---

### `com.example.icatchlibrary.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "release" | 5 |
| `DEBUG` | boolean | false | 6 |
| `LIBRARY_PACKAGE_NAME` | String | "com.example.icatchlibrary" | 7 |

### `com.example.icatchplayerlibrary.AppInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APP_VERSION` | String | "R1.4.14_beta3_3" | 10 |
| `AUTO_DOWNLOAD_PATH` | String | "/DCIM/GoLiveCam/" | 11 |
| `DOWNLOAD_PATH` | String | "/DCIM/QSLyCamera/" | 12 |
| `EULA_VERSION` | String | "1.1" | 13 |
| `FILE_GOOGLE_TOKEN` | String | "file_googleToken.dat" | 14 |
| `PROPERTY_CFG_DIRECTORY_PATH` | String | "/SportCamResoure/" | 15 |
| `PROPERTY_CFG_FILE_NAME` | String | "netconfig.properties" | 16 |
| `SDK_LOG_DIRECTORY_PATH` | String | "/IcatchSportCamera_SDK_Log" | 17 |
| `STREAM_OUTPUT_DIRECTORY_PATH` | String | "/SportCamResoure/Raw/" | 18 |
| `UPDATEFW_FILENAME` | String | "/SportCamResoure/tactacam50.BRN" | 19 |

### `com.example.icatchplayerlibrary.GlobalInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `THRESHOLD_TIME` | double | 0.1d | 5 |

### `com.example.icatchplayerlibrary.H264DecoderThread1`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "H264DecoderThread--" | 29 |

### `com.example.icatchplayerlibrary.MjpgDecoderThread1`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MjpgDecoderThread" | 21 |

### `com.example.icatchplayerlibrary.MPreview`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MPreview" | 13 |

### `com.gku.actioncam.amba.AmbaConstant`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_CMD_PORT` | int | 7878 | 5 |
| `AMBA_DATA_PORT` | int | 8787 | 6 |
| `ENABLE_AMBA` | boolean | true | 7 |

### `com.gku.actioncam.amba.model.AmbaCmdModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_BATTERY_LEVEL` | int | 13 | 46 |
| `AMBA_BURN_FW` | int | 8 | 47 |
| `AMBA_CANCLE_XFER` | int | 1287 | 48 |
| `AMBA_CD` | int | 1283 | 49 |
| `AMBA_DEL` | int | 1281 | 50 |
| `AMBA_DELETE_ALL_FILE` | int | 268435487 | 51 |
| `AMBA_DELETE_FILE` | int | 268435486 | 52 |
| `AMBA_FORCE_SPLIT` | int | 516 | 53 |
| `AMBA_FORMAT_SD` | int | 4 | 54 |
| `AMBA_GET_ALL` | int | 3 | 55 |
| `AMBA_GET_ALL_WORKMODE` | int | 268435457 | 56 |
| `AMBA_GET_APP_CONNECT_STATE` | int | 268435469 | 57 |
| `AMBA_GET_BLUETOOTH_TX` | int | 268435507 | 58 |
| `AMBA_GET_BTATERY_INFO` | int | 268435480 | 59 |
| `AMBA_GET_CAMERA_STATE` | int | 268435470 | 60 |
| `AMBA_GET_CUR_PARAMETER` | int | 268435462 | 61 |
| `AMBA_GET_CUR_WORKMODE` | int | 268435458 | 62 |
| `AMBA_GET_DEVICE_INFO` | int | 11 | 63 |
| `AMBA_GET_DEVINFO` | int | 11 | 64 |
| `AMBA_GET_FILE` | int | 1285 | 65 |
| `AMBA_GET_FILE_COUNT` | int | 268435482 | 69 |
| `AMBA_GET_FILE_INFO` | int | 268435484 | 70 |
| `AMBA_GET_FILE_LIST` | int | 268435483 | 71 |
| `AMBA_GET_FILELIST_INFO` | int | 268435465 | 66 |
| `AMBA_GET_FILELIST_INFO_IOS` | int | 268435485 | 67 |
| `AMBA_GET_FILETYPE_COUNT` | int | 268435464 | 68 |
| `AMBA_GET_GPS_STATE` | int | 268435468 | 72 |
| `AMBA_GET_MEDIAINFO` | int | 1026 | 73 |
| `AMBA_GET_NUM_FILES` | int | 6 | 74 |
| `AMBA_GET_OPTIONS` | int | 9 | 75 |
| `AMBA_GET_PRIMARY_MENU_ITEM` | int | 268435460 | 76 |
| `AMBA_GET_ROTATE` | int | 268435489 | 77 |
| `AMBA_GET_SD_STATE` | int | 268435475 | 78 |
| `AMBA_GET_SECOND_MENU_ITEM` | int | 268435461 | 79 |
| `AMBA_GET_SETTING` | int | 1 | 80 |
| `AMBA_GET_SPACE` | int | 5 | 81 |
| `AMBA_GET_SYSTEM_WORK_STATE` | int | 268435466 | 82 |
| `AMBA_GET_THUMB` | int | 1025 | 83 |
| `AMBA_GET_WIFI_INFO` | int | 268435478 | 84 |
| `AMBA_GET_WIFI_SETTING` | int | 1539 | 85 |
| `AMBA_GET_WIFI_STATUS` | int | 1542 | 86 |
| `AMBA_HEART_BEAT` | int | 268435467 | 87 |
| `AMBA_LS` | int | 1282 | 88 |
| `AMBA_NOTIFICATION` | int | 7 | 89 |
| `AMBA_POWER_MANAGE` | int | 12 | 90 |
| `AMBA_PUT_FILE` | int | 1286 | 91 |
| `AMBA_PWD` | int | 1284 | 92 |
| `AMBA_QS_ADD_TIME` | int | 268435488 | 93 |
| `AMBA_QUERY_SESSION_HOLDER` | int | 1793 | 94 |
| `AMBA_RECORD_START` | int | 513 | 95 |
| `AMBA_RECORD_STOP` | int | 514 | 96 |
| `AMBA_RECORD_TIME` | int | 515 | 97 |
| `AMBA_RESET_FACTORY` | int | 268435477 | 99 |
| `AMBA_RESETVF` | int | 259 | 98 |
| `AMBA_SD_FORMAT` | int | 268435476 | 100 |
| `AMBA_SET_ATTRIBUTE` | int | 1027 | 101 |
| `AMBA_SET_BITRATE` | int | 16 | 102 |
| `AMBA_SET_CAMERA_STATE` | int | 268435471 | 103 |
| `AMBA_SET_CLINT_INFO` | int | 261 | 104 |
| `AMBA_SET_CUR_PARAMETER` | int | 268435463 | 105 |
| `AMBA_SET_CUR_WORKMODE` | int | 268435459 | 106 |
| `AMBA_SET_SETTING` | int | 2 | 107 |
| `AMBA_SET_WIFI_INFO` | int | 268435479 | 108 |
| `AMBA_SET_WIFI_SETTING` | int | 1538 | 109 |
| `AMBA_START_SESSION` | int | 257 | 110 |
| `AMBA_STOP_PHOTO` | int | 770 | 111 |
| `AMBA_STOP_SESSION` | int | 258 | 112 |
| `AMBA_STOP_VF` | int | 260 | 113 |
| `AMBA_SYNC_SYSTEM_TIME` | int | 268435474 | 114 |
| `AMBA_TAKE_PHOTO` | int | 769 | 115 |
| `AMBA_TAKE_PHOTO_END` | int | 268632078 | 116 |
| `AMBA_TAKE_PHOTO_START` | int | 268632077 | 117 |
| `AMBA_WIFI_RESTART` | int | 1537 | 118 |
| `AMBA_WIFI_START` | int | 1541 | 119 |
| `AMBA_WIFI_STOP` | int | 1540 | 120 |
| `AMBA_ZOOM` | int | 14 | 121 |
| `AMBA_ZOOM_INFO` | int | 15 | 122 |
| `CARD_PROTECTED` | int | -18 | 123 |
| `ERR_INVALID_TOKEN` | int | -4 | 126 |
| `ERR_MAX_NUM` | int | 26 | 127 |
| `ERROR_NO_SUPPORT_PARAM` | int | -34 | 124 |
| `ERROR_UNKNOW` | int | -1 | 125 |
| `LINK_REFUSE` | int | -444 | 128 |
| `NO_MORE_SPACE` | int | -17 | 129 |
| `NO_SD_CARD` | int | -33 | 130 |

### `com.gku.actioncam.amba.model.AmbaDataModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AmbaDataModel" | 15 |

### `com.gku.actioncam.amba.socket.DataChannel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PROGRESS_MIN_STEP` | int | 1 | 15 |
| `TAG` | String | "DataChannel" | 16 |

### `com.gku.actioncam.amba.socket.DataChannelWIFI`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONN_TIME_OUT` | int | 3000 | 8 |
| `READ_TIME_OUT` | int | 3000 | 9 |
| `TAG` | String | "DataChannelWIFI" | 10 |

### `com.gku.actioncam.amba.socket.IChannelListener`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CMD_CHANNEL_ERROR_BLE_DISABLED` | int | 131 | 5 |
| `CMD_CHANNEL_ERROR_BLE_INVALID_ADDR` | int | 130 | 6 |
| `CMD_CHANNEL_ERROR_BROKEN_CHANNEL` | int | 132 | 7 |
| `CMD_CHANNEL_ERROR_CONNECT` | int | 134 | 8 |
| `CMD_CHANNEL_ERROR_CONTENT` | int | 135 | 9 |
| `CMD_CHANNEL_ERROR_INVALID_TOKEN` | int | 129 | 10 |
| `CMD_CHANNEL_ERROR_LINK_REFUSE` | int | 137 | 11 |
| `CMD_CHANNEL_ERROR_TIMEOUT` | int | 128 | 12 |
| `CMD_CHANNEL_ERROR_UNKNOW` | int | 136 | 13 |
| `CMD_CHANNEL_ERROR_WAKEUP` | int | 133 | 14 |
| `CMD_CHANNEL_EVENT_BATTERY_LEVEL` | int | 20 | 15 |
| `CMD_CHANNEL_EVENT_CONNECTED` | int | 13 | 16 |
| `CMD_CHANNEL_EVENT_DEL` | int | 6 | 17 |
| `CMD_CHANNEL_EVENT_DELETE_ALL_TYPE_FILE` | int | 63 | 18 |
| `CMD_CHANNEL_EVENT_DELETE_FILE` | int | 62 | 19 |
| `CMD_CHANNEL_EVENT_FORMAT_SD` | int | 18 | 20 |
| `CMD_CHANNEL_EVENT_GET_ALL_SETTINGS` | int | 10 | 21 |
| `CMD_CHANNEL_EVENT_GET_ALL_WORK_MODE` | int | 48 | 22 |
| `CMD_CHANNEL_EVENT_GET_BATTERY_INFO` | int | 56 | 23 |
| `CMD_CHANNEL_EVENT_GET_BLUETOOTH_TX` | int | 71 | 24 |
| `CMD_CHANNEL_EVENT_GET_CUR_WORK_MODE` | int | 49 | 25 |
| `CMD_CHANNEL_EVENT_GET_DEVINFO` | int | 17 | 26 |
| `CMD_CHANNEL_EVENT_GET_FILE` | int | 7 | 27 |
| `CMD_CHANNEL_EVENT_GET_FILE_COUNT` | int | 59 | 28 |
| `CMD_CHANNEL_EVENT_GET_FILE_INFO` | int | 69 | 29 |
| `CMD_CHANNEL_EVENT_GET_FILE_LIST` | int | 68 | 30 |
| `CMD_CHANNEL_EVENT_GET_FILE_LIST_INFO_IOS` | int | 60 | 31 |
| `CMD_CHANNEL_EVENT_GET_INFO` | int | 8 | 32 |
| `CMD_CHANNEL_EVENT_GET_NUM_FILES` | int | 16 | 33 |
| `CMD_CHANNEL_EVENT_GET_OPTIONS` | int | 11 | 34 |
| `CMD_CHANNEL_EVENT_GET_PRIMARY_MENU_ITEM` | int | 58 | 35 |
| `CMD_CHANNEL_EVENT_GET_ROTATE` | int | 70 | 36 |
| `CMD_CHANNEL_EVENT_GET_SD_STATE` | int | 57 | 37 |
| `CMD_CHANNEL_EVENT_GET_SECOND_MENU_ITEM` | int | 64 | 38 |
| `CMD_CHANNEL_EVENT_GET_SPACE` | int | 15 | 39 |
| `CMD_CHANNEL_EVENT_GET_SYSTEM_WORK_STATE` | int | 55 | 40 |
| `CMD_CHANNEL_EVENT_GET_THUMB` | int | 37 | 41 |
| `CMD_CHANNEL_EVENT_GET_WIFI_SETTING` | int | 41 | 42 |
| `CMD_CHANNEL_EVENT_GET_ZOOM_INFO` | int | 39 | 43 |
| `CMD_CHANNEL_EVENT_INIT` | int | 1 | 44 |
| `CMD_CHANNEL_EVENT_LOG` | int | 3 | 45 |
| `CMD_CHANNEL_EVENT_LS` | int | 5 | 46 |
| `CMD_CHANNEL_EVENT_PUT_FILE` | int | 19 | 47 |
| `CMD_CHANNEL_EVENT_QS_ADD_TIME` | int | 67 | 48 |
| `CMD_CHANNEL_EVENT_QUERY_SESSION_HOLDER` | int | 40 | 49 |
| `CMD_CHANNEL_EVENT_RECORD_TIME` | int | 21 | 50 |
| `CMD_CHANNEL_EVENT_RESET_FACTORY` | int | 66 | 52 |
| `CMD_CHANNEL_EVENT_RESETVF` | int | 9 | 51 |
| `CMD_CHANNEL_EVENT_SET_ATTRIBUTE` | int | 36 | 53 |
| `CMD_CHANNEL_EVENT_SET_CUR_PARAMETER` | int | 65 | 54 |
| `CMD_CHANNEL_EVENT_SET_CUR_WORK_MODE` | int | 50 | 55 |
| `CMD_CHANNEL_EVENT_SET_SETTING` | int | 12 | 56 |
| `CMD_CHANNEL_EVENT_SET_ZOOM` | int | 38 | 57 |
| `CMD_CHANNEL_EVENT_SHOW_ALERT` | int | 4 | 58 |
| `CMD_CHANNEL_EVENT_SHUTDOWN` | int | 2 | 59 |
| `CMD_CHANNEL_EVENT_START_CONNECT` | int | 32 | 60 |
| `CMD_CHANNEL_EVENT_START_LS` | int | 33 | 61 |
| `CMD_CHANNEL_EVENT_START_RECORD` | int | 53 | 62 |
| `CMD_CHANNEL_EVENT_START_SESSION` | int | 23 | 63 |
| `CMD_CHANNEL_EVENT_STOP_PHOTO` | int | 52 | 64 |
| `CMD_CHANNEL_EVENT_STOP_RECORD` | int | 54 | 65 |
| `CMD_CHANNEL_EVENT_STOP_SESSION` | int | 24 | 66 |
| `CMD_CHANNEL_EVENT_STOP_VF` | int | 22 | 67 |
| `CMD_CHANNEL_EVENT_SYNC_SYSTEM_TIME` | int | 61 | 68 |
| `CMD_CHANNEL_EVENT_TAKE_PHOTO` | int | 51 | 69 |
| `CMD_CHANNEL_EVENT_WAKEUP_OK` | int | 35 | 70 |
| `CMD_CHANNEL_EVENT_WAKEUP_START` | int | 34 | 71 |
| `CMD_CHANNEL_MSG` | int | 0 | 72 |
| `DATA_CHANNEL_EVENT_GET_FINISH` | int | 514 | 73 |
| `DATA_CHANNEL_EVENT_GET_PROGRESS` | int | 513 | 74 |
| `DATA_CHANNEL_EVENT_GET_START` | int | 512 | 75 |
| `DATA_CHANNEL_EVENT_PUT_FINISH` | int | 517 | 76 |
| `DATA_CHANNEL_EVENT_PUT_MD5` | int | 518 | 77 |
| `DATA_CHANNEL_EVENT_PUT_PROGRESS` | int | 516 | 78 |
| `DATA_CHANNEL_EVENT_PUT_START` | int | 515 | 79 |
| `DATA_CHANNEL_MSG` | int | 512 | 80 |
| `MSG_MASK` | int | 2147483392 | 81 |
| `STREAM_CHANNEL_ERROR_PLAYING` | int | 1026 | 82 |
| `STREAM_CHANNEL_EVENT_BUFFERING` | int | 1024 | 83 |
| `STREAM_CHANNEL_EVENT_PHOTOEND` | int | 1028 | 84 |
| `STREAM_CHANNEL_EVENT_PHOTOSTART` | int | 1027 | 85 |
| `STREAM_CHANNEL_EVENT_PLAYING` | int | 1025 | 86 |
| `STREAM_CHANNEL_MSG` | int | 1024 | 87 |

### `com.gku.actioncam.amba.ui.AmbaFWUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_FW_DIR` | String | "fw_amba" | 27 |

### `com.gku.actioncam.amba.ui.LanguageUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LanguageUtil" | 25 |

### `com.gku.actioncam.amba.ui.playback.AmbaDlgOrDeleteActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_DLG_RESULT` | String | "amba_result" | 20 |
| `DIALOG_DELETE_TYPE_NORMAL` | Integer | 11060 | 33 |
| `DIALOG_DELETE_TYPE_PHOTO` | Integer | 11062 | 35 |
| `DIALOG_DELETE_TYPE_VIDEO` | Integer | 11061 | 34 |
| `DIALOG_DOWNLOAD_TYPE_HD` | Integer | 11064 | 32 |
| `DIALOG_DOWNLOAD_TYPE_NORMAL` | Integer | 11063 | 31 |
| `DIALOG_FILE_LIST` | String | "amba_list" | 21 |
| `DIALOG_TYPE` | String | "amba_type" | 22 |

### `com.gku.actioncam.amba.ui.playback.AmbaDlgOrDeletePresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_DELETE_TYPE_PHOTO` | int | 0 | 17 |
| `AMBA_DELETE_TYPE_VIDEO` | int | 2 | 18 |
| `AMBA_DELETE_TYPE_VOICE` | int | 1 | 19 |

### `com.gku.actioncam.amba.ui.playback.AmbaImageAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_IMAGE_WIDTH_HEIGHT` | int | 85 | 26 |
| `AMBA_SELECT_X_POS` | int | 2 | 27 |
| `AMBA_SELECT_Y_POS` | int | 2 | 28 |
| `AMBA_TIME_TEXT_SIZE` | int | 7 | 29 |

### `com.gku.actioncam.amba.ui.playback.AmbaPlaybackPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `GET_FILE_INFO_LIST_END_HANDLER_WHAT` | int | 10211 | 33 |
| `GET_FILE_INFO_LIST_START_HANDLER_WHAT` | int | 10210 | 34 |

### `com.gku.actioncam.amba.ui.playback.AmbaPlaybackUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AmbaPlaybackUtil" | 40 |

### `com.gku.actioncam.amba.ui.playback.remote.photo.AmbaRemotePhotoActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_CONTROL_PHOTO_PARAM` | String | "amba_control_photo_param" | 30 |

### `com.gku.actioncam.amba.ui.playback.remote.video.AmbaRemoteVideoActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_CONTROL_VIDEO_PARAM` | String | "amba_control_video_param" | 25 |

### `com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_PREVIEW_DATE` | String | "amba_preview_save_date" | 46 |
| `HIDE_MAIN_ICON` | int | 12101110 | 47 |
| `SHOW_MAIN_ICON` | int | 12101112 | 48 |
| `TAG` | String | "AmbaPreviewActivity" | 49 |

### `com.gku.actioncam.amba.ui.preview.AmbaPreviewPopupWindowWorkMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AmbaPreviewPopupWindowWorkMode" | 33 |

### `com.gku.actioncam.amba.ui.preview.AmbaPreviewPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AmbaPreviewPresenter" | 38 |
| `WORK_MODE_START` | int | 20 | 39 |
| `WORK_MODE_STOP` | int | 21 | 40 |

### `com.gku.actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_GET_SYSTEM_SETTING_LIST` | String | "System" | 30 |

### `com.gku.actioncam.amba.ui.setting.mode_setting.AmbaWorkSettingActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_PRIMARY_SETTING_PAGE_MODE` | String | "amba_setting_page_mode" | 25 |

### `com.gku.actioncam.amba.ui.stream.BroadcastDouyinFragment3`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUNDLE_RETURN_FROM_OLD_LIVE` | String | "BUNDLE_RETURN_FROM_OLD_LIVE" | 35 |
| `BUNDLE_RTMP` | String | "BUNDLE_RTMP" | 36 |

### `com.gku.actioncam.amba.ui.stream.BroadcastDouyinFragment4`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARGUMENT_IS_AUTO_LIVE` | String | "ARGUMENT_IS_AUTO_LIVE" | 34 |
| `ARGUMENT_ROOM_ID` | String | "ARGUMENT_ROOM_ID" | 35 |
| `EXIT_TIMEOUT` | long | 2000 | 36 |
| `MSG_EXIT` | int | 101 | 37 |
| `MSG_TIMER` | int | 100 | 38 |

### `com.gku.actioncam.amba.ui.stream.DouyinStreamController`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CODE_ERROR_DOUYIN_RTMPPUSHURL_ERROR` | int | SocketErrorCode.BROKEN_PIPE | 55 |
| `CODE_ERROR_DOUYIN_STARTBROADCAST_RETURN_NULL` | int | -10003 | 54 |
| `CODE_ERROR_DOUYIN_UNAUTH` | int | -10002 | 53 |
| `CODE_ERROR_DOUYIN_UNINIT` | int | -10001 | 52 |

### `com.gku.actioncam.amba.ui.stream.SelectLiveDeviceActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARGUMENT_DATA` | String | "ARGUMENT_DATA" | 24 |

### `com.gku.actioncam.amba.ui.stream.SelectLiveWifiActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARGUMENT_ISNEWLIVE` | String | "ARGUMENT_ISNEWLIVE" | 41 |
| `ARGUMENT_PWD` | String | "ARGUMENT_PWD" | 42 |
| `ARGUMENT_SSID` | String | "ARGUMENT_SSID" | 43 |

### `com.gku.actioncam.amba.ui.stream.wifi.WIFIListActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `REQUEST_CODE_LOCATION_PERMISSION` | int | 1001 | 34 |
| `TAG` | String | "WiFiScan" | 35 |
| `TAG_WIFI_RETURN` | String | "TAG_WIFI_RETURN" | 36 |
| `TAG_WIFI_SSID` | String | "TAG_WIFI_SELECTED" | 37 |

### `com.gku.actioncam.amba.ui.stream.wifi.WIFITypeinActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "WIFITypein" | 17 |
| `TAG_WIFI_RETURN` | String | "TAG_WIFI_RETURN" | 18 |

### `com.gku.actioncam.hisilicon.camplayer.HiCamPlayer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MEDIA_ASR_CHANGE` | int | 300 | 15 |
| `MEDIA_BUFFERING_UPDATE` | int | 3 | 16 |
| `MEDIA_ERROR` | int | 100 | 17 |
| `MEDIA_ERROR_SERVER_DIED` | int | 100 | 18 |
| `MEDIA_ERROR_UNKNOWN` | int | 1 | 19 |
| `MEDIA_FILE_EOF` | int | 400 | 20 |
| `MEDIA_INFO` | int | 200 | 21 |
| `MEDIA_PLAYBACK_BUFFERING_END` | int | 702 | 22 |
| `MEDIA_PLAYBACK_BUFFERING_START` | int | 701 | 23 |
| `MEDIA_PLAYBACK_INFO` | int | 2 | 24 |
| `MEDIA_PLAYBACK_LOADING_PERCNT` | int | 711 | 25 |
| `MEDIA_PLAYBACK_PAUSED` | int | 7 | 26 |
| `MEDIA_PLAYBACK_PREPARED` | int | 1 | 27 |
| `MEDIA_PLAYBACK_STARTED` | int | 6 | 28 |
| `MEDIA_PLAYBACK_STOPPED` | int | 8 | 29 |
| `MEDIA_PREPARED` | int | 1 | 30 |
| `MEDIA_STREAM_TYPE_AUDIO` | int | 2 | 31 |
| `MEDIA_STREAM_TYPE_METADATA` | int | 3 | 32 |
| `MEDIA_STREAM_TYPE_UNKOWN` | int | 4 | 33 |
| `MEDIA_STREAM_TYPE_VIDEO` | int | 1 | 34 |
| `TAG` | String | "HICAMPlayer" | 35 |

### `com.gku.actioncam.hisilicon.dv.biz.Command`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_BURST` | int | 3 | 9 |
| `ACTION_BUTT` | int | 21 | 10 |
| `ACTION_CONTINUOUS_START` | int | 8 | 11 |
| `ACTION_CONTINUOUS_STOP` | int | 9 | 12 |
| `ACTION_PHOTO` | int | 2 | 13 |
| `ACTION_RECORD_START` | int | 0 | 14 |
| `ACTION_RECORD_STOP` | int | 1 | 15 |
| `ACTION_TIMELAPSE_START` | int | 4 | 16 |
| `ACTION_TIMELAPSE_STOP` | int | 5 | 17 |
| `ACTION_TIMER_START` | int | 6 | 18 |
| `ACTION_TIMER_STOP` | int | 7 | 19 |
| `ACTION_VIDEO_COMMON_START` | int | 11 | 20 |
| `ACTION_VIDEO_COMMON_STOP` | int | 12 | 21 |
| `ACTION_VIDEO_LOOP_START` | int | 13 | 22 |
| `ACTION_VIDEO_LOOP_STOP` | int | 14 | 23 |
| `ACTION_VIDEO_QUICK_EXIT` | int | 10 | 24 |
| `ACTION_VIDEO_SLOW_START` | int | 19 | 25 |
| `ACTION_VIDEO_SLOW_STOP` | int | 20 | 26 |
| `ACTION_VIDEO_SNAP_START` | int | 17 | 27 |
| `ACTION_VIDEO_SNAP_STOP` | int | 18 | 28 |
| `ACTION_VIDEO_TIMELAPSE_START` | int | 15 | 29 |
| `ACTION_VIDEO_TIMELAPSE_STOP` | int | 16 | 30 |
| `cgiFilesParams` | String[] | {"/record.cgi?&-cmd=start", "/record.cgi?&-cmd=stop", "/photo.cgi?&-type=photo", "/photo.cgi?&-type=photoburst", "/photo.cgi?&-type=phototimelapse&-cmd=start", "/photo.cgi?&-type=phototimelapse&-cmd=stop", "/photo.cgi?&-type=phototimer&-cmd=start", "/photo.cgi?&-type=phototimer&-cmd=stop", "/photo.cgi?&-type=continuous&-cmd=start", "/photo.cgi?&-type=continuous&-cmd=stop", "/exitquickrec.cgi", "/record2.cgi?&-type=common&-cmd=start", "/record2.cgi?&-type=common&-cmd=stop", "/record2.cgi?&-type=loop&-cmd=start", "/record2.cgi?&-type=loop&-cmd=stop", "/record2.cgi?&-type=timelapse&-cmd=start", "/record2.cgi?&-type=timelapse&-cmd=stop", "/record2.cgi?&-type=recsnap&-cmd=start", "/record2.cgi?&-type=recsnap&-cmd=stop", "/record2.cgi?&-type=slow&-cmd=start", "/record2.cgi?&-type=slow&-cmd=stop"} | 31 |

### `com.gku.actioncam.hisilicon.dv.biz.Common`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `aEventStringRes` | int[] | {R.string.event_normal, R.string.event_record_space_full, R.string.event_record_error, R.string.event_snapshot_space_full, R.string.event_snapshot_error, R.string.event_sdcard_not_exist, R.string.event_sdcard_error, R.string.event_chip_temperature_high, R.string.event_battery_temperature_high, R.string.event_low_power, R.string.event_usb_connected, R.string.event_shutdown, R.string.event_usb_disconnected, R.string.event_chip_temperature_alarm, R.string.event_battery_temperature_alarm, R.string.event_low_power_alarm, R.string.event_sdcard_mounted, R.string.event_ac_on, R.string.event_ac_off} | 177 |
| `BOOT_ACTION_IDLE` | String | "idle" | 8 |
| `BOOT_ACTION_RECORD` | String | "record" | 9 |
| `BOOT_ACTION_TIMELAPSE` | String | "timelapse" | 10 |
| `CGI_PATH` | String | "/cgi-bin/hi3510" | 11 |
| `CONFIG_MULTI_BURST_RATE` | int | 1 | 12 |
| `CONFIG_MULTI_CONTINUOUS_RATE` | int | 3 | 13 |
| `CONFIG_MULTI_RESOLUTION` | int | 0 | 14 |
| `CONFIG_MULTI_TIMELAPSE_INTERVAL` | int | 2 | 15 |
| `CONFIG_PHOTO_RESOLUTION` | int | 0 | 16 |
| `CONFIG_PHOTO_SCENE` | int | 2 | 17 |
| `CONFIG_PHOTO_TIMER` | int | 1 | 18 |
| `CONFIG_VIDEO_LOOP_TYPE` | int | 7 | 19 |
| `CONFIG_VIDEO_PHOTO_MODE` | int | 6 | 20 |
| `CONFIG_VIDEO_PHOTO_PHOTO_RESOLUTION` | int | 4 | 21 |
| `CONFIG_VIDEO_PHOTO_SNAP_INTERVAL` | int | 3 | 22 |
| `CONFIG_VIDEO_PHOTO_SNAP_MODE` | int | 2 | 23 |
| `CONFIG_VIDEO_PHOTO_VIDEO_RESOLUTION` | int | 5 | 24 |
| `CONFIG_VIDEO_TIMELAPSE_INTERVAL` | int | 1 | 25 |
| `CONFIG_VIDEO_VIDEO_RESOLUTION` | int | 0 | 26 |
| `DATA_DIRECTORY_NAME` | String | "ActionCam" | 27 |
| `ERR_CHANNEL_BUSY` | int | -1560182777 | 28 |
| `ERR_GET_CHANNEL_STATE_FAIL` | int | -1560182778 | 29 |
| `ERR_LOOP_NO_SPACE` | int | -1560182780 | 30 |
| `ERR_NO_SD` | int | -1560182784 | 31 |
| `ERR_RECORD_NO_SPACE` | int | -1560182781 | 32 |
| `ERR_RECORD_SPACE_FULL` | int | -1610579967 | 33 |
| `ERR_SANPSHOT_NO_SPACE` | int | -1560182779 | 34 |
| `ERR_SD_ERROR` | int | -1560182782 | 35 |
| `ERR_SD_FULL` | int | -1560182783 | 36 |
| `ERR_SNAPSHOT_PRARM_ERROR` | int | -1560182774 | 37 |
| `ERR_START_CHANNEL_FAIL` | int | -1560182776 | 38 |
| `ERR_STOP_CHANNEL_FAIL` | int | -1560182775 | 39 |
| `EVENT_AC_OFF` | int | 18 | 40 |
| `EVENT_AC_ON` | int | 17 | 41 |
| `EVENT_BATTERY_TEMPERATURE_ALARM` | int | 14 | 42 |
| `EVENT_BATTERY_TEMPERATURE_HIGH` | int | 8 | 43 |
| `EVENT_CHIP_TEMPERATURE_ALARM` | int | 13 | 44 |
| `EVENT_CHIP_TEMPERATURE_HIGH` | int | 7 | 45 |
| `EVENT_INVALID` | int | 19 | 46 |
| `EVENT_LOW_POWER` | int | 9 | 47 |
| `EVENT_LOW_POWER_ALARM` | int | 15 | 48 |
| `EVENT_NORMAL` | int | 0 | 49 |
| `EVENT_RECORD_ERROR` | int | 2 | 50 |
| `EVENT_RECORD_SPACE_FULL` | int | 1 | 51 |
| `EVENT_SDCARD_ERROR` | int | 6 | 52 |
| `EVENT_SDCARD_MOUNTED` | int | 16 | 53 |
| `EVENT_SDCARD_NOT_EXIST` | int | 5 | 54 |
| `EVENT_SHUTDOWN` | int | 11 | 55 |
| `EVENT_SNAPSHOT_ERROR` | int | 4 | 56 |
| `EVENT_SNAPSHOT_SPACE_FULL` | int | 3 | 57 |
| `EVENT_USB_CONNECTED` | int | 10 | 58 |
| `EVENT_USB_DISCONNECTED` | int | 12 | 59 |
| `FAILURE` | int | -1 | 60 |
| `ICGI_PATH` | String | "/cgi-bin" | 61 |
| `KEY_ABOUT_CAMERA` | String | "about_camera" | 62 |
| `KEY_AUDIO_CODEC` | String | "audio_codec" | 63 |
| `KEY_AUTO_SHUTDOWN` | String | "auto_shutdown" | 64 |
| `KEY_BOOT_ACTION` | String | "boot_action" | 65 |
| `KEY_BURST_RATE` | String | "burst_rate" | 66 |
| `KEY_BUZZER_PROMPT` | String | "buzzer_prompt" | 67 |
| `KEY_CLEAR_CACHE` | String | "clear_cache" | 68 |
| `KEY_DELETE_ALL_FILES` | String | "delete_all_files" | 69 |
| `KEY_DOWNLOAD_VIDEO` | String | "download_video" | 70 |
| `KEY_FIELD_OF_VIEW` | String | "field_of_view" | 71 |
| `KEY_FILE_DOWNLOAD_SAVE_PATH` | String | "file_download_save_path" | 72 |
| `KEY_FORMAT_SD_CARD` | String | "format_sd_card" | 73 |
| `KEY_FRAME_RATE` | String | "frame_rate" | 74 |
| `KEY_IMAGE_UPSIDEDOWN` | String | "image_upsidedown" | 75 |
| `KEY_LED_FLICKER` | String | "led_flicker" | 76 |
| `KEY_MASTER_MODE_MULTI_GROUP` | String | "key_master_mode_multi_group" | 77 |
| `KEY_MASTER_MODE_PHOTO_GROUP` | String | "key_master_mode_photo_group" | 78 |
| `KEY_MASTER_MODE_VIDEO_GROUP` | String | "key_master_mode_video_group" | 79 |
| `KEY_MODE_MULTI_BURST_GROUP` | String | "key_mode_multi_burst_group" | 80 |
| `KEY_MODE_MULTI_BURST_RATE` | String | "key_mode_multi_burst_rate" | 81 |
| `KEY_MODE_MULTI_BURST_RESOLUTION` | String | "key_mode_multi_burst_resolution" | 82 |
| `KEY_MODE_MULTI_CONTINUOUS_GROUP` | String | "key_mode_multi_continuous_group" | 83 |
| `KEY_MODE_MULTI_CONTINUOUS_RATE` | String | "key_mode_multi_continuous_rate" | 84 |
| `KEY_MODE_MULTI_CONTINUOUS_RESOLUTION` | String | "key_mode_multi_continuous_resolution" | 85 |
| `KEY_MODE_MULTI_TIMELAPSE_GROUP` | String | "key_mode_multi_timelapse_group" | 86 |
| `KEY_MODE_MULTI_TIMELAPSE_INTERVAL` | String | "key_mode_multi_timelapse_interval" | 87 |
| `KEY_MODE_MULTI_TIMELAPSE_RESOLUTION` | String | "key_mode_multi_timelapse_resolution" | 88 |
| `KEY_MODE_PHOTO_RAW_GROUP` | String | "key_mode_photo_raw_group" | 89 |
| `KEY_MODE_PHOTO_RAW_RESOLUTION` | String | "key_mode_photo_raw_resolution" | 90 |
| `KEY_MODE_PHOTO_SINGLE_GROUP` | String | "key_mode_photo_single_group" | 91 |
| `KEY_MODE_PHOTO_SINGLE_RESOLUTION` | String | "key_mode_photo_single_resolution" | 92 |
| `KEY_MODE_PHOTO_SINGLE_SCENE` | String | "key_mode_photo_single_scene" | 93 |
| `KEY_MODE_PHOTO_TIMER_GROUP` | String | "key_mode_photo_timer_group" | 94 |
| `KEY_MODE_PHOTO_TIMER_RESOLUTION` | String | "key_mode_photo_timer_resolution" | 95 |
| `KEY_MODE_PHOTO_TIMER_SCENE` | String | "key_mode_photo_timer_scene" | 96 |
| `KEY_MODE_PHOTO_TIMER_TIME` | String | "key_mode_photo_timer_time" | 97 |
| `KEY_MODE_VIDEO_LOOP_GROUP` | String | "key_mode_video_loop_group" | 98 |
| `KEY_MODE_VIDEO_LOOP_RESOLUTION` | String | "key_mode_video_loop_resolution" | 99 |
| `KEY_MODE_VIDEO_LOOP_TYPE` | String | "key_mode_video_loop_type" | 100 |
| `KEY_MODE_VIDEO_NORMAL_GROUP` | String | "key_mode_video_normal_group" | 101 |
| `KEY_MODE_VIDEO_NORMAL_RESOLUTION` | String | "key_mode_video_normal_resolution" | 102 |
| `KEY_MODE_VIDEO_PHOTO_GROUP` | String | "key_mode_video_photo_group" | 103 |
| `KEY_MODE_VIDEO_PHOTO_LAPSE_INTERVAL` | String | "key_mode_video_photo_lapse_interval" | 104 |
| `KEY_MODE_VIDEO_PHOTO_MODE` | String | "key_mode_video_photo_mode" | 105 |
| `KEY_MODE_VIDEO_PHOTO_PHOTO_RESOLUTION` | String | "key_mode_video_photo_photo_resolution" | 106 |
| `KEY_MODE_VIDEO_PHOTO_SNAP_INTERVAL` | String | "key_mode_video_photo_snap_interval" | 107 |
| `KEY_MODE_VIDEO_PHOTO_SNAP_MODE` | String | "key_mode_video_photo_snap_mode" | 108 |
| `KEY_MODE_VIDEO_PHOTO_VIDEO_RESOLUTION` | String | "key_mode_video_photo_video_resolution" | 109 |
| `KEY_MODE_VIDEO_SLOW_GROUP` | String | "key_mode_video_slow_group" | 110 |
| `KEY_MODE_VIDEO_SLOW_RESOLUTION` | String | "key_mode_video_slow_resolution" | 111 |
| `KEY_MODE_VIDEO_TIMELAPSE_GROUP` | String | "key_mode_video_timelapse_group" | 112 |
| `KEY_MODE_VIDEO_TIMELAPSE_INTERVAL` | String | "key_mode_video_timelapse_interval" | 113 |
| `KEY_MODE_VIDEO_TIMELAPSE_RESOLUTION` | String | "key_mode_video_timelapse_resolution" | 114 |
| `KEY_MODIFY_DV_NAME` | String | "modify_dv_name" | 115 |
| `KEY_PHOTO_RESOLUTION` | String | "photo_resolution" | 116 |
| `KEY_POWERON_UI_MODE` | String | "poweron_ui_mode" | 117 |
| `KEY_PREVIEW_VIDEO` | String | "preview_video" | 118 |
| `KEY_REC_SETTING` | String | "rec_setting" | 119 |
| `KEY_RESTORE_SETTINGS` | String | "restore_settings" | 120 |
| `KEY_SCREEN_AUTO_SLEEP` | String | "screen_auto_sleep" | 121 |
| `KEY_SCREEN_BRIGHTNESS` | String | "screen_brightness" | 122 |
| `KEY_SDCARD_LEFT` | String | "sdcard_left" | 123 |
| `KEY_SDCARD_TOTAL` | String | "sdcard_total" | 124 |
| `KEY_SET_DATETIME` | String | "set_datetime" | 125 |
| `KEY_SOUND_PROMPT` | String | "sound_prompt" | 126 |
| `KEY_SPOT_METERING` | String | "spot_metering" | 127 |
| `KEY_TIME_TAG` | String | "time_tag" | 130 |
| `KEY_TIMELAPSE_INTERVAL` | String | "timelapse_interval" | 128 |
| `KEY_TIMER_COUNT_DOWN` | String | "timer_count_down" | 129 |
| `KEY_UPDATE_VERSION` | String | "update_version" | 131 |
| `KEY_VIDEO_MODE` | String | "video_mode" | 132 |
| `KEY_VIDEO_RESOLUTION` | String | "video_resolution" | 133 |
| `KEY_WIFI_PASSWORD` | String | "wifi_password" | 134 |
| `KEY_WIFI_SSID` | String | "wifi_ssid" | 135 |
| `MASTER_MODE_MULTI` | int | 1 | 136 |
| `MASTER_MODE_PHOTO` | int | 0 | 137 |
| `MASTER_MODE_PLAY` | int | 3 | 138 |
| `MASTER_MODE_VIDEO` | int | 2 | 139 |
| `SD_STATE_ERROR` | int | 3 | 140 |
| `SD_STATE_FULL` | int | 1 | 141 |
| `SD_STATE_NONE` | int | 2 | 142 |
| `SD_STATE_OK` | int | 0 | 143 |
| `SENSOR_117` | String | "117" | 144 |
| `SENSOR_34220` | String | "34220" | 145 |
| `SUCCESS` | int | 0 | 146 |
| `VIDEO_MODE_NTSC` | String | "NTSC" | 147 |
| `VIDEO_MODE_PAL` | String | "PAL" | 148 |
| `WORK_MODE_MULTI_BURST` | int | 10 | 149 |
| `WORK_MODE_MULTI_CONTINUOUS` | int | 12 | 150 |
| `WORK_MODE_MULTI_TIMELAPSE` | int | 11 | 151 |
| `WORK_MODE_NOMAL_VIDEO` | String | "NormalVideo" | 152 |
| `WORK_MODE_PHOTO_RAW` | int | 2 | 153 |
| `WORK_MODE_PHOTO_SINGLE` | int | 0 | 154 |
| `WORK_MODE_PHOTO_TIMER` | int | 1 | 155 |
| `WORK_MODE_VIDEO_LAPSE_BURST` | int | 26 | 156 |
| `WORK_MODE_VIDEO_LOOP` | int | 21 | 157 |
| `WORK_MODE_VIDEO_NORMAL` | int | 20 | 158 |
| `WORK_MODE_VIDEO_PHOTO` | int | 23 | 159 |
| `WORK_MODE_VIDEO_QUICK` | int | 25 | 160 |
| `WORK_MODE_VIDEO_SLOW` | int | 24 | 161 |
| `WORK_MODE_VIDEO_TIMELAPSE` | int | 22 | 162 |
| `WORK_STATE_IDLE` | int | 3 | 163 |
| `WORK_STATE_RECORD` | int | 0 | 164 |
| `WORK_STATE_TIMELAPSE` | int | 1 | 165 |
| `WORK_STATE_TIMER` | int | 2 | 166 |
| `WORK_STATE_VIDEO_BURST` | int | 6 | 167 |
| `WORK_STATE_VIDEO_LOOP` | int | 4 | 168 |
| `WORK_STATE_VIDEO_TIMELAPSE` | int | 5 | 169 |

### `com.gku.actioncam.hisilicon.dv.biz.FileListManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_ALL` | int | 3 | 21 |
| `FILE_IMAGE` | int | 1 | 22 |
| `FILE_VIDEO` | int | 2 | 23 |
| `LOAD_FILE_LIMIT` | int | 49 | 24 |
| `PAGE_FILE_COUNT` | int | 200 | 25 |
| `TAG` | String | "FileListManager" | 26 |

### `com.gku.actioncam.hisilicon.dv.biz.GetLocalPath`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "GetLocalPath" | 13 |

### `com.gku.actioncam.hisilicon.dv.biz.HiDefine`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BACK_PAGE` | int | 1 | 9 |
| `BROWSER_MENU` | int | 0 | 10 |
| `CHACH_PATH` | String | "cache" | 11 |
| `DLG_FOR_DELETE_CONFIRM` | int | 3 | 12 |
| `DLG_FOR_DOWNLOAD_EXCEPTION` | int | 5 | 13 |
| `DLG_FOR_PROGRESS_PATH_LIST` | int | 4 | 14 |
| `DLG_POPUP_FOR_WINDOW` | int | 1 | 15 |
| `DLG_SWITCH_IMAGE` | int | 2 | 16 |
| `DOUBLE_CLICK_TIME` | int | 350 | 17 |
| `DOWNLOAD` | int | 3 | 18 |
| `DOWNLOAD_APK_PATH` | String | "apk" | 19 |
| `DOWNLOAD_CONNECT_TIMEOUT` | int | 5000 | 20 |
| `DOWNLOAD_PATH` | String | "download" | 21 |
| `DOWNLOAD_READ_TIMEOUT` | int | 6000 | 22 |
| `DV_DEVICE_LINK` | int | 2 | 23 |
| `DV_NETWORK_PREFIX` | String | "3516A" | 24 |
| `DV_NETWORK_PREFIX2` | String | "himc" | 25 |
| `DV_NETWORK_PREFIX3` | String | "YUTU" | 26 |
| `ERROR_TOUCH_MOVE` | int | 10 | 27 |
| `FILE_SUFFIX_THM` | String | ".THM" | 30 |
| `FILE_SUFIX_JPG` | String | ".JPG" | 31 |
| `FILE_SUFIX_LRV` | String | ".LRV" | 32 |
| `FILE_SUFIX_MP4` | String | ".MP4" | 33 |
| `HIDE_TOOLBAR` | int | 3 | 34 |
| `INTERNET_LINK` | int | 1 | 35 |
| `LONG_CLICK` | int | 2 | 36 |
| `MENU_SHOW_TIME` | int | 10 | 37 |
| `NEXT_PAGE` | int | 2 | 38 |
| `NOT_CONNECT` | int | 2 | 39 |
| `NOT_DV` | int | 1 | 40 |
| `OPERATE_WIFI_CONNECT` | int | 2 | 41 |
| `OPERATE_WIFI_DISCONNECT` | int | 1 | 42 |
| `PLAY_ICON_ID` | int | 5 | 43 |
| `PLAY_STATUS_DOWNLOAD` | int | 6 | 44 |
| `POPUP_MENU` | int | 1 | 45 |
| `PREVIEW_GET_FILE_LIST` | int | 7 | 46 |
| `PREVIEW_GET_REMAINDER_FILE` | int | 5 | 47 |
| `PREVIEW_GET_SD_STATE` | int | 8 | 48 |
| `PREVIEW_PULL_TO_REFRESH` | int | 6 | 49 |
| `PREVIEW_SWITCH_TO_WIFI` | int | 10 | 50 |
| `PROGRESS_DELETE` | int | 1 | 51 |
| `PROGRESS_DOWNLOAD` | int | 2 | 52 |
| `REFRESH_HEAD` | int | 2 | 53 |
| `RELOAD_OP` | int | 1 | 54 |
| `RENAME_OP` | int | 2 | 55 |
| `SELECT_MASK_LAYER_ID` | int | 4 | 56 |
| `SELECT_STATUS_IMG_ID` | int | 2 | 57 |
| `SHORT_CLICK` | int | 1 | 58 |
| `SHOW_PICTURE_IMG_ID` | int | 3 | 59 |
| `SKIP_OP` | int | 3 | 60 |
| `TYPE_DELETE` | int | 1 | 61 |
| `TYPE_DLNA_PUSH` | int | 5 | 62 |
| `TYPE_DOWNLOAD` | int | 3 | 63 |
| `TYPE_EDIT` | int | 6 | 64 |
| `TYPE_FILEINFO` | int | 4 | 65 |
| `TYPE_NO_NULL` | int | 0 | 66 |
| `TYPE_SHARE` | int | 2 | 67 |
| `VIDEO_TIME_TEXT_ID` | int | 1 | 68 |
| `WIFI_CONNECT` | int | 2 | 69 |
| `WIFI_FORGET` | int | 3 | 70 |
| `WIFI_NO_CONFIG` | int | -1 | 71 |
| `WIFI_NO_ERROR` | int | 0 | 72 |
| `WIFI_NO_SCAN` | int | -2 | 73 |
| `WIFI_NO_SSID` | int | -3 | 74 |
| `WIFI_REVERIFY` | int | 4 | 75 |
| `WIFI_UNDO` | int | 1 | 76 |

### `com.gku.actioncam.hisilicon.dv.biz.HiFileInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "HiFileInfo" | 17 |

### `com.gku.actioncam.hisilicon.dv.biz.HiWifiManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ALL_SSID` | String | "all_dv_device_ssid_list" | 19 |
| `TAG` | String | "HiWifiManager" | 20 |
| `WIFI_CONNECT_SSID` | String | "start_wifi_ssid" | 21 |
| `WIFI_ENABLE` | String | "dv_device_wifi_enable" | 22 |
| `WIFI_LAST_CONNECT_SSID` | String | "wifi_last_Connected_SSID" | 23 |

### `com.gku.actioncam.hisilicon.dv.biz.Setting`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "Setting" | 27 |

### `com.gku.actioncam.hisilicon.dv.biz.Utility`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "Utility" | 17 |

### `com.gku.actioncam.hisilicon.dv.devicemanage.DeviceManageActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_CONNECT_AP` | int | 5002 | 63 |
| `MSG_CONNECT_TIMEOUT` | int | 5001 | 64 |
| `MSG_SCAN_WIFI` | int | 5000 | 65 |
| `TAG` | String | "DeviceManageActivity" | 66 |

### `com.gku.actioncam.hisilicon.dv.dlg.DlgForDeleteProcessActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DELETE_FINISH` | int | 1 | 48 |
| `DELETE_PROCESS` | int | 0 | 49 |
| `DOWNLOAD_CANCEL` | int | 3 | 50 |
| `DOWNLOAD_FINISH` | int | 2 | 51 |
| `DOWNLOAD_PROCESS` | int | 5 | 52 |
| `DOWNLOAD_TOTAL_PROCESS` | int | 4 | 53 |
| `TAG` | String | "DlgForProcessActivity" | 54 |

### `com.gku.actioncam.hisilicon.dv.dlg.DlgForProcessActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DELETE_FINISH` | int | 1 | 43 |
| `DELETE_PROCESS` | int | 0 | 44 |
| `DOWNLOAD_CANCEL` | int | 3 | 45 |
| `DOWNLOAD_FINISH` | int | 2 | 46 |
| `DOWNLOAD_PROCESS` | int | 5 | 47 |
| `DOWNLOAD_TOTAL_PROCESS` | int | 4 | 48 |
| `TAG` | String | "DlgForProcessActivity" | 49 |

### `com.gku.actioncam.hisilicon.dv.filebrowser.Hi3518PriviewImageActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_FRESH_COUNT` | int | 3 | 150 |
| `TAG` | String | "BH01PriviewImageActvity" | 62 |
| `TIME_REFRESH_DELAY` | int | 350 | 63 |
| `WHAT_REFRESH_DELAY` | int | 922 | 64 |

### `com.gku.actioncam.hisilicon.dv.filebrowser.HiGridView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MOVE_EVENT_DOWN` | int | 0 | 10 |
| `MOVE_EVENT_UP` | int | 1 | 11 |

### `com.gku.actioncam.hisilicon.dv.filebrowser.HiImageView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "HiImageView" | 11 |

### `com.gku.actioncam.hisilicon.dv.filebrowser.ImageAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `IMAGE_WIDTH_HEIGHT` | int | 85 | 38 |
| `SELECT_X_POS` | int | 2 | 39 |
| `SELECT_Y_POS` | int | 2 | 40 |
| `TAG` | String | "ImageAdapter" | 41 |
| `TIME_TEXT_SIZE` | int | 7 | 42 |

### `com.gku.actioncam.hisilicon.dv.filebrowser.ImageLoader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ImageLoader" | 30 |

### `com.gku.actioncam.hisilicon.dv.filebrowser.PreviewImageActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_FRESH_COUNT` | int | 3 | 112 |
| `TAG` | String | "PriviewImageActvity" | 65 |
| `TIME_REFRESH_DELAY` | int | 350 | 66 |
| `WHAT_REFRESH_DELAY` | int | 922 | 67 |

### `com.gku.actioncam.hisilicon.dv.filebrowser.RefreshHeadView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SCROLL_SPEED` | int | -20 | 22 |
| `STATUS_PULL_TO_REFRESH` | int | 0 | 23 |
| `STATUS_REFRESH_FINISHED` | int | 3 | 25 |
| `STATUS_REFRESHING` | int | 2 | 24 |
| `STATUS_RELEASE_TO_REFRESH` | int | 1 | 26 |
| `TAG` | String | "RefreshHeadView" | 27 |

### `com.gku.actioncam.hisilicon.dv.imagelookover.SwitchImageActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DOWNLOAD_FINISH` | int | 3 | 63 |
| `DOWNLOAD_PROGRESS` | int | 2 | 64 |
| `DOWNLOAD_START` | int | 1 | 65 |
| `MIN_WIDTH` | int | 320 | 66 |
| `NEED_SELECT_DMR` | int | 2 | 67 |
| `TAG` | String | "SwitchImageActivity" | 68 |

### `com.gku.actioncam.hisilicon.dv.imagelookover.SwitchImageView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CUR_IMAGE_STEP_NUM` | int | 10 | 19 |
| `ERROR_VALUE` | int | 12 | 20 |
| `HIDE_TOOLBAR_COUNT` | int | 40 | 21 |
| `HIDE_TOOLBAR_TIME` | int | 100 | 22 |
| `REF_TIMES` | float | 2.0f | 23 |
| `SHOW_CURIMAGE` | int | 1 | 24 |
| `STATUS_BACK` | int | 8 | 25 |
| `STATUS_CHECK` | int | 5 | 26 |
| `STATUS_INIT` | int | 1 | 27 |
| `STATUS_MOVE` | int | 4 | 28 |
| `STATUS_MOVEUP` | int | 6 | 29 |
| `STATUS_NO_NULL` | int | 0 | 30 |
| `STATUS_SHOW_DOUBLE_ZOOM` | int | 2 | 31 |
| `STATUS_SHOW_NORMAL` | int | 9 | 32 |
| `STATUS_UPDATE` | int | 7 | 33 |
| `STATUS_ZOOM` | int | 3 | 34 |
| `STEP_TIME` | int | 30 | 35 |
| `SWITCH_IMAGE` | int | 2 | 36 |
| `SWITCH_STEP_NUM` | int | 8 | 37 |
| `TAG` | String | "SwitchImageView" | 38 |
| `WIDTH_WEIGHT` | int | 8 | 39 |
| `ZOOM_IMAGE` | int | 3 | 40 |
| `ZOOM_MAX_TIMES` | int | 4 | 41 |
| `ZOOM_STEP_NUM` | int | 10 | 42 |

### `com.gku.actioncam.hisilicon.dv.live.SyncMessageManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_SYNC_SETTING` | int | 1 | 12 |
| `MSG_SYNC_STATE` | int | 0 | 13 |
| `REMOTE_STATE_START_BURST` | int | 9 | 14 |
| `REMOTE_STATE_START_LOOPRECORD` | int | 0 | 15 |
| `REMOTE_STATE_START_RECORD` | int | 1 | 16 |
| `REMOTE_STATE_START_RECORD_TIMELAPSE` | int | 8 | 17 |
| `REMOTE_STATE_START_TIMELAPSE` | int | 2 | 18 |
| `REMOTE_STATE_START_TIMER` | int | 3 | 19 |
| `REMOTE_STATE_STOP_BURST` | int | 10 | 20 |
| `REMOTE_STATE_STOP_RECORD` | int | 4 | 21 |
| `REMOTE_STATE_STOP_TIMELAPSE` | int | 5 | 22 |
| `REMOTE_STATE_STOP_TIMER` | int | 6 | 23 |
| `REMOTE_STATE_UPDATE` | int | 11 | 24 |
| `TAG` | String | "SyncMessageManager" | 25 |

### `com.gku.actioncam.hisilicon.dv.live.TelevisionActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_CHECK_WAKEUP` | int | 4097 | 41 |
| `MSG_START_PLAYER` | int | 4096 | 42 |
| `MSG_WAKE_SUCCESSS` | int | 4098 | 43 |
| `TAG` | String | "TelevisionActivity" | 44 |

### `com.gku.actioncam.hisilicon.dv.localimage.adapter.AlbumSubAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AlbumSubAdapter" | 15 |

### `com.gku.actioncam.hisilicon.dv.localimage.adapter.SectionAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_SECTION` | int | 0 | 14 |

### `com.gku.actioncam.hisilicon.dv.localimage.AlbumPreviewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_DATA` | String | "data" | 38 |
| `ARG_POSITION` | String | "position" | 39 |
| `ARG_TYPE` | String | "TYPE" | 40 |
| `TAG` | String | "AlbumPreviewActivity" | 41 |

### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_PATH` | String | "imagepath" | 35 |
| `TAG` | String | "ImageEditActivity" | 36 |

### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditClipActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_PATH` | String | "path" | 29 |
| `ARG_ROTATION` | String | "rotation" | 30 |
| `CROP_RESULT_ASPECT_RATIO` | String | "cropResultAspectRatio" | 31 |
| `TAG` | String | "ImageEditClipActivity" | 32 |

### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditEffectActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_EFFECT_TYPE` | String | "effect_type" | 25 |
| `ARG_PATH` | String | "path" | 26 |

### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CACHE_DIR` | String | "filterPreviewImages_cache" | 23 |
| `DIR` | String | "filterPreviewImages" | 24 |

### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory$Effect`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BEAUTY` | int | 17 | 27 |
| `BLUR` | int | 18 | 28 |
| `CARTOON` | int | 19 | 29 |
| `FILTER` | int | 273 | 30 |
| `RELIEF` | int | 20 | 31 |
| `THE_SKETCH` | int | 22 | 32 |
| `WHITE_BALANCE` | int | 21 | 33 |

### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory$FilterEffect`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `color_danya` | float[] | {0.6f, 0.3f, 0.1f, 0.0f, 73.3f, 0.2f, 0.7f, 0.1f, 0.0f, 73.3f, 0.2f, 0.3f, 0.4f, 0.0f, 73.3f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 42 |
| `color_fugu` | float[] | {0.2f, 0.5f, 0.1f, 0.0f, 40.8f, 0.2f, 0.5f, 0.1f, 0.0f, 40.8f, 0.2f, 0.5f, 0.1f, 0.0f, 40.8f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 39 |
| `color_gete` | float[] | {1.9f, -0.3f, -0.2f, 0.0f, -87.0f, -0.2f, 1.7f, -0.1f, 0.0f, -87.0f, -0.1f, -0.6f, 2.0f, 0.0f, -87.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 40 |
| `color_guangyun` | float[] | {0.9f, 0.0f, 0.0f, 0.0f, 64.9f, 0.0f, 0.9f, 0.0f, 0.0f, 64.9f, 0.0f, 0.0f, 0.9f, 0.0f, 64.9f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 46 |
| `color_heibai` | float[] | {0.8f, 1.6f, 0.2f, 0.0f, -163.9f, 0.8f, 1.6f, 0.2f, 0.0f, -163.9f, 0.8f, 1.6f, 0.2f, 0.0f, -163.9f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 38 |
| `color_jiuhong` | float[] | {1.2f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 43 |
| `color_landiao` | float[] | {2.1f, -1.4f, 0.6f, 0.0f, -31.0f, -0.3f, 2.0f, -0.3f, 0.0f, -31.0f, -1.1f, -0.2f, 2.6f, 0.0f, -31.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 47 |
| `color_langman` | float[] | {0.9f, 0.0f, 0.0f, 0.0f, 63.0f, 0.0f, 0.9f, 0.0f, 0.0f, 63.0f, 0.0f, 0.0f, 0.9f, 0.0f, 63.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 45 |
| `color_lomo` | float[] | {1.7f, 0.1f, 0.1f, 0.0f, -73.1f, 0.0f, 1.7f, 0.1f, 0.0f, -73.1f, 0.0f, 0.1f, 1.6f, 0.0f, -73.1f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 37 |
| `color_menghuan` | float[] | {0.8f, 0.3f, 0.1f, 0.0f, 46.5f, 0.1f, 0.9f, 0.0f, 0.0f, 46.5f, 0.1f, 0.3f, 0.7f, 0.0f, 46.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 48 |
| `color_qingning` | float[] | {0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 44 |
| `color_ruihua` | float[] | {4.8f, -1.0f, -0.1f, 0.0f, -388.4f, -0.5f, 4.4f, -0.1f, 0.0f, -388.4f, -0.5f, -1.0f, 5.2f, 0.0f, -388.4f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 41 |
| `color_yese` | float[] | {1.0f, 0.0f, 0.0f, 0.0f, -66.6f, 0.0f, 1.1f, 0.0f, 0.0f, -66.6f, 0.0f, 0.0f, 1.0f, 0.0f, -66.6f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f} | 49 |

### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory$Mode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EFFECT` | int | 3 | 53 |
| `FILTER` | int | 2 | 54 |
| `TOOLS` | int | 1 | 55 |

### `com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditFactory$Tools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACUTANCE` | int | 7 | 59 |
| `BRIGHTNESS` | int | 4 | 60 |
| `CHROMA` | int | 9 | 61 |
| `CLIP` | int | 3 | 62 |
| `CONTRAST` | int | 5 | 63 |
| `EXPOSURE` | int | 8 | 64 |
| `LEFT_ROTATE` | int | 1 | 65 |
| `RIGHT_ROTATE` | int | 2 | 66 |
| `SATURABILITY` | int | 6 | 67 |

### `com.gku.actioncam.hisilicon.dv.localimage.TrackActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MESSAGE_WHAT_CONTROL_BAR` | int | 620 | 50 |
| `MESSAGE_WHAT_SEEK_CHANGE` | int | 615 | 51 |
| `TAG` | String | "TrackActivity" | 52 |

### `com.gku.actioncam.hisilicon.dv.localimage.utils.SJCamTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SJCamTools" | 25 |

### `com.gku.actioncam.hisilicon.dv.localimage.weight.AlbumFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_TYPE` | String | "type" | 40 |

### `com.gku.actioncam.hisilicon.dv.localimage.weight.AlbumHDFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_TYPE` | String | "type" | 39 |

### `com.gku.actioncam.hisilicon.dv.localimage.weight.AlbumNormalFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_TYPE` | String | "type" | 40 |

### `com.gku.actioncam.hisilicon.dv.localimage.weight.DlgForDeleteLocalProcessActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DELETE_FINISH` | int | 1 | 25 |
| `DELETE_PROCESS` | int | 0 | 26 |
| `DOWNLOAD_CANCEL` | int | 3 | 27 |
| `DOWNLOAD_FINISH` | int | 2 | 28 |
| `DOWNLOAD_PROCESS` | int | 5 | 29 |
| `DOWNLOAD_TOTAL_PROCESS` | int | 4 | 30 |
| `TAG` | String | "DlgForProcessActivity" | 31 |

### `com.gku.actioncam.hisilicon.dv.localimage.weight.FragmentNavigator`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_CURRENT_POSITION` | String | "extra_current_position" | 10 |

### `com.gku.actioncam.hisilicon.dv.LogService`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MEMORY_LOG_FILE_MAX_SIZE` | int | 10485760 | 42 |
| `MEMORY_LOG_FILE_MONITOR_INTERVAL` | int | 600000 | 43 |
| `SDCARD_LOG_FILE_SAVE_DAYS` | int | 7 | 45 |
| `TAG` | String | "LogService" | 47 |

### `com.gku.actioncam.hisilicon.dv.net.HttpProxy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "HttpProxy" | 38 |

### `com.gku.actioncam.hisilicon.dv.net.HttpResult`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HTTP_EXCEPTION` | int | -1 | 5 |
| `HTTP_OK` | int | 200 | 6 |

### `com.gku.actioncam.hisilicon.dv.net.KeepAliveService`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FAST_CHECK_TICK_TIME` | int | 2000 | 12 |
| `MAX_TICK_COUNT` | int | 5 | 13 |
| `MESSAGE_DV_ISALIVE_ACTION` | String | "com.gku.xtugo.DV_ISALIVE_ACTION" | 14 |
| `MESSAGE_STRING_NETWORK_PAST` | String | "networkpast" | 15 |
| `SLOW_CHECK_TICK_TIME` | int | 5000 | 16 |
| `TAG` | String | "KeepAliveService" | 17 |

### `com.gku.actioncam.hisilicon.dv.net.MessageService`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MESSAGE_ACTION` | String | "com.gku.xtugo.MESSAGE_ACTION" | 18 |
| `SERVER_PORT` | int | 5678 | 19 |
| `TAG` | String | "MessageService" | 20 |

### `com.gku.actioncam.hisilicon.dv.net.MessageService$RecvThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUFFER_LENGTH` | int | 512 | 93 |

### `com.gku.actioncam.hisilicon.dv.net.StringParser`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HEAD_VAR` | String | "var " | 17 |
| `MID_EQUAL_MARK` | String | "=\"" | 18 |
| `TAIL_SEMICOLON` | String | "\";\r\n" | 19 |

### `com.gku.actioncam.hisilicon.dv.player.PlayControlThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONTROL_FAIL` | int | 101 | 14 |
| `CONTROL_SUCCESS` | int | 100 | 15 |
| `IMAGE_PLAY` | int | 103 | 16 |
| `IMAGE_PLAY_RESULT` | int | 104 | 17 |
| `IMAGE_STOP_RESULT` | int | 105 | 18 |
| `LOCAL_PLAY_SET_URI_RESULT` | int | 26 | 19 |
| `PLAY_ERROR` | int | 400 | 20 |
| `SEEK_BUFFERRING_END` | int | 302 | 22 |
| `SEEK_BUFFERRING_LOAD` | int | 301 | 23 |
| `SEEK_BUFFERRING_START` | int | 300 | 24 |
| `SEEKBAR_MAX` | int | 100 | 21 |
| `SET_VOLUME` | int | 17 | 25 |
| `SET_VOLUME_RESULT` | int | 24 | 26 |
| `TAG` | String | "PlayControlThread" | 27 |
| `UNSUPPORT_OPERATE` | int | 200 | 28 |
| `UPDATE_PLAY_STATE_NO_MEDIA_PRESENT` | int | 206 | 29 |
| `UPDATE_PLAY_STATE_PAUSED` | int | 204 | 30 |
| `UPDATE_PLAY_STATE_PLAYING` | int | 203 | 31 |
| `UPDATE_PLAY_STATE_STOPPED` | int | 205 | 32 |
| `UPDATE_POSITION` | int | 201 | 33 |
| `UPDATE_VOLUME` | int | 202 | 34 |
| `VIDEO_PAUSE` | int | 15 | 35 |
| `VIDEO_PAUSE_RESULT` | int | 21 | 36 |
| `VIDEO_PLAY` | int | 13 | 37 |
| `VIDEO_PLAY_RESULT` | int | 22 | 38 |
| `VIDEO_PULL` | int | 12 | 39 |
| `VIDEO_SEEK` | int | 16 | 40 |
| `VIDEO_SEEK_RESULT` | int | 23 | 41 |
| `VIDEO_STOP` | int | 14 | 42 |
| `VIDEO_STOP_RESULT` | int | 106 | 43 |

### `com.gku.actioncam.hisilicon.dv.player.VideoControlActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INTENT_FLAG_LIST` | String | "list" | 36 |
| `INTENT_FLAG_START_INDEX` | String | "start" | 37 |
| `MSG_HIDE_OVERLAY` | int | 3 | 38 |
| `MSG_REFRESH_PROGRESS` | int | 1 | 39 |
| `MSG_SHOW_OVERLAY` | int | 2 | 40 |
| `TAG` | String | "VideoControlActivity" | 41 |

### `com.gku.actioncam.hisilicon.dv.refesh.AlbumItemModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_HD_VIDEO` | int | 3 | 21 |
| `TYPE_IMAGE` | int | 1 | 22 |
| `TYPE_VIDEO` | int | 2 | 23 |

### `com.gku.actioncam.hisilicon.dv.setting.AboutClientActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_GET_SERVER_INFO_FAILED` | int | 4098 | 40 |
| `MSG_GET_SERVER_INFO_SUCCESS` | int | 4097 | 41 |

### `com.gku.actioncam.hisilicon.dv.setting.BitRateActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_GOT_BITRATE` | int | 0 | 18 |
| `MSG_SET_FAIL` | int | 2 | 19 |
| `MSG_SET_OK` | int | 1 | 20 |

### `com.gku.actioncam.hisilicon.dv.setting.HiListPreference`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "HiListPreference" | 15 |

### `com.gku.actioncam.hisilicon.dv.setting.WifiChannelActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_GOT_WIFI_CHANNEL` | int | 0 | 18 |
| `MSG_SET_FAIL` | int | 2 | 19 |
| `MSG_SET_OK` | int | 1 | 20 |

### `com.gku.actioncam.hisilicon.dv.ui.data.connect.ClientThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "lzy" | 5 |

### `com.gku.actioncam.hisilicon.dv.ui.data.connect.ConnectDevice`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ConnectDevice" | 27 |

### `com.gku.actioncam.hisilicon.dv.ui.data.connect.HWScaningActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SCAN_RESULT` | String | "scanResult" | 26 |

### `com.gku.actioncam.hisilicon.dv.ui.data.FileUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileUtils" | 28 |

### `com.gku.actioncam.hisilicon.dv.ui.fragment.FragmentConnectedCamera`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `REQUEST_PERMISSION_STORAGE` | int | 0 | 54 |
| `TAG` | String | "FragmentConnectedCamera" | 55 |

### `com.gku.actioncam.hisilicon.dv.ui.HiwifiInfoScrollView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LEFT_MARGIN` | int | 30 | 13 |
| `TEXT_SIZE_CODE_HEIGHT` | int | 25 | 14 |
| `TEXT_SIZE_KEY_HEIGHT` | int | 20 | 15 |
| `TOP_BOTTOM_MARGIN` | int | 20 | 16 |

### `com.gku.actioncam.hisilicon.dv.ui.Internetcheckfrag`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "Internetcheckfrag" | 17 |

### `com.gku.actioncam.hisilicon.dv.ui.ModifyWifiActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_MODIFY_RESULT` | int | 0 | 24 |
| `TAG` | String | "ModifyWifiActivity" | 25 |

### `com.gku.actioncam.hisilicon.dv.ui.weight.rec.SwipeItemLayout$ScrollRunnable`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FLING_DURATION` | int | 200 | 302 |

### `com.gku.actioncam.hisilicon.dv.ui.weight.WeChatSwitchButton`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEF_H` | int | 26 | 23 |
| `DEF_W` | int | 52 | 24 |

### `com.gku.actioncam.hisilicon.dv.ui.WelcomeActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "WelcomeActivity" | 47 |

### `com.gku.actioncam.hisilicon.dv.updateapp.ApkInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ApkInfo" | 7 |

### `com.gku.actioncam.hisilicon.dv.updateapp.DownloadActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_DOWNLOAD_SUCCESS` | int | 2002 | 28 |
| `MSG_QUERY_PROGRESS` | int | 2001 | 29 |
| `MSG_REFRESH_UI` | int | 2003 | 30 |
| `TAG` | String | "DownloadActivity" | 31 |

### `com.gku.actioncam.hisilicon.dv.updateapp.FirmwareInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FirmwareInfo" | 9 |

### `com.gku.actioncam.hisilicon.dv.updateapp.UpgradeFirmwareActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_UPLOAD_CANCELED` | int | 10004 | 28 |
| `MSG_UPLOAD_FAILED` | int | 10003 | 29 |
| `MSG_UPLOAD_PROGRESS` | int | 10001 | 30 |
| `MSG_UPLOAD_SUCCESS` | int | 10002 | 31 |
| `TAG` | String | "UpgradeFirmwareActivity" | 32 |

### `com.gku.actioncam.hisilicon.dv.updateapp.UpgradeManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SERVER_BASE_URL` | String | "http://121.40.107.215:8041/firmware/" | 35 |
| `SERVER_INFO_FILE` | String | "info.json" | 36 |
| `TAG` | String | "UpgradeManager" | 37 |

### `com.gku.actioncam.hisilicon.dv.wifi.HiWifiScrollView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BREAK_LINE_BOTTOM` | int | 5 | 37 |
| `BREAK_LINE_LEFT` | int | 30 | 38 |
| `BREAK_LINE_RIGHT` | int | 4 | 39 |
| `BREAK_LINE_TOP` | int | 5 | 40 |
| `CHECK_CONNECT_TIMES` | int | 60 | 41 |
| `CHECK_GET_IP` | int | 3 | 42 |
| `CHECK_IDENTIFING` | int | 5 | 43 |
| `CHECK_LINKING` | int | 2 | 44 |
| `CHECK_POPUP_DLG` | int | 1 | 45 |
| `CHECK_PWD_ID` | int | 1 | 46 |
| `CHECK_TEXT_SIZE` | int | 14 | 47 |
| `CHECK_VERIFY` | int | 4 | 48 |
| `DEVICE_HEIGHT` | int | 55 | 49 |
| `DEVICE_LEFT_MARGIN` | int | 15 | 50 |
| `DEVICE_MARGIN` | int | 1 | 51 |
| `DEVICE_RIGHT_MARGIN` | int | 20 | 52 |
| `DEVICE_TEXT_SIZE` | int | 18 | 53 |
| `ENCRY_WPA` | String | "WPA-" | 54 |
| `ENCRY_WPA2` | String | "WPA2-" | 55 |
| `ERROR_VALUE` | int | 10 | 56 |
| `MAX_COUNT_TIMEOUT` | int | 250 | 57 |
| `MIN_COUNT_TIMEOUT` | int | 100 | 58 |
| `TAG` | String | "HiWifiScrollView" | 59 |

### `com.gku.actioncam.hisilicon.dv.wifi.WifiConnUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "WifiConnUtil" | 13 |

### `com.gku.actioncam.hisilicon.dv.wifi.WifiDisconnectReceiver`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONNECT_TIMES_COUNT` | int | 250 | 19 |
| `CONNECT_TIMES_TIME` | int | 60 | 20 |
| `TAG` | String | "WifiDisconnectReceiver" | 21 |

### `com.gku.actioncam.hisilicon.dv.wifi.WifiUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `$assertionsDisabled` | boolean | false | 29 |
| `ALL_SSID` | String | "all_dv_device_ssid_list" | 30 |
| `TAG` | String | "WifiUtils" | 31 |
| `WIFI_CONNECT_SSID` | String | "start_wifi_ssid" | 32 |
| `WIFI_ENABLE` | String | "dv_device_wifi_enable" | 33 |
| `WIFI_LAST_CONNECT_SSID` | String | "wifi_last_Connected_SSID" | 34 |
| `WIFI_NO_CONFIG` | int | -1 | 35 |
| `WIFI_NO_ERROR` | int | 0 | 36 |
| `WIFI_NO_SCAN` | int | -2 | 37 |
| `WIFI_NO_SSID` | int | -3 | 38 |

### `com.gku.actioncam.remote_live.QRShowActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "QRShowActivity" | 15 |

### `com.gku.actioncam.remote_live.ScanWifiActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SCAN_WIFI_DIALOG_TYPE_ONLY_PWD` | int | 0 | 44 |
| `SCAN_WIFI_DIALOG_TYPE_SSID_PWD` | int | 1 | 45 |

### `com.gku.actioncam.remote_live.SelectLiveActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `IMAGE_ID` | int[] | {R.drawable.ic_bilibili, R.drawable.ic_huya, R.drawable.ic_cn_others} | 21 |

### `com.gku.actioncam.remote_live.widget.UserInfoView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ATTENTION_NUMBER_TEXT_ID` | int | 72915 | 14 |
| `ATTENTION_TEXT_TEXT` | int | 72916 | 15 |
| `FANS_NUMBER_TEXT_ID` | int | 72913 | 16 |
| `FANS_TEXT_TEXT_ID` | int | 72914 | 17 |
| `QR_IMAGE_TEXT` | int | 72917 | 18 |
| `USER_INFO_AVATAR_ID` | int | 72911 | 19 |
| `USER_NAME_TEXT_ID` | int | 72912 | 20 |

### `com.gku.actioncam.sigmastar.base.CameraBaseActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "BaseSSActivity" | 28 |

### `com.gku.actioncam.sigmastar.bean.SSDownloadState`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ALL_DOWNLOAD_FINISH` | String | "ALL_DOWNLOAD_FINISH" | 8 |
| `DOWNLOAD_FAILURE` | String | "DOWNLOAD_FAILURE" | 23 |
| `DOWNLOADING` | String | "DOWNLOADING" | 22 |
| `FINISH_DOWNLOAD` | String | "FINISH_DOWNLOAD" | 24 |
| `START_DOWNLOAD` | String | "START_DOWNLOAD" | 25 |

### `com.gku.actioncam.sigmastar.bean.SSystemWorkState`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SS_EVENT_AMBA_PHOTO_END` | int | 268632078 | 21 |
| `SS_EVENT_AMBA_PHOTO_START` | int | 268632077 | 22 |
| `SS_EVENT_AMBA_VIDEO_END` | int | 268763138 | 23 |
| `SS_EVENT_AMBA_VIDEO_START` | int | 268763137 | 24 |
| `SS_EVENT_END` | int | 11700002 | 25 |
| `SS_EVENT_MODE` | int | 11800001 | 26 |
| `SS_EVENT_PHOTO_END` | int | 4 | 27 |
| `SS_EVENT_PHOTO_START` | int | 3 | 28 |
| `SS_EVENT_START` | int | 11700001 | 29 |
| `SS_EVENT_VIDEO_END` | int | 2 | 30 |
| `SS_EVENT_VIDEO_START` | int | 1 | 31 |
| `SS_STATE_STANDBY` | int | 21 | 32 |
| `SS_STATE_WORKING` | int | 20 | 33 |

### `com.gku.actioncam.sigmastar.bluetooth.Constants`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILTER_NAME` | String | "name" | 8 |
| `FILTER_RSSI` | String | "rssi" | 9 |
| `FILTER_SWITCH` | String | "switch" | 10 |
| `PAUSE_PERIOD` | String | "pause" | 11 |
| `SCAN_PERIOD` | String | "scan" | 12 |
| `SHOW_SPINNER` | String | "spinner" | 13 |
| `TIME_FORMAT` | String | "yyyy-MM-dd HH:mm:ss" | 14 |

### `com.gku.actioncam.sigmastar.bluetooth.Permission.PermissionRequest`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `REQUEST_PERMISSION_CODE` | int | 1 | 11 |
| `TAG` | String | "PermissionRequest" | 12 |

### `com.gku.actioncam.sigmastar.bluetooth.ui.PopupDialogActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `$assertionsDisabled` | boolean | false | 178 |
| `FLING_MIN_DISTANCE` | int | 40 | 34 |
| `FLING_MIN_VELOCITY` | int | 400 | 35 |
| `TAG` | String | "PopupDialogActivity" | 36 |

### `com.gku.actioncam.sigmastar.bluetooth.utils.BluetoothUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `REQUEST_ENABLE_BT` | int | 2001 | 10 |

### `com.gku.actioncam.sigmastar.bluetooth.utils.ByteUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HEXES` | String | "0123456789ABCDEF" | 20 |

### `com.gku.actioncam.sigmastar.bluetooth.utils.GattAttributeResolver`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTIVESYNC` | String | "831c4071-7bc8-4a9c-a01c-15df25a4adbc" | 10 |
| `ADVANCED_AUDIO` | String | "0000110d-0000-1000-8000-00805f9b34fb" | 11 |
| `ALERT_CATEGORY_ID` | String | "00002a43-0000-1000-8000-00805f9b34fb" | 12 |
| `ALERT_CATEGORY_ID_BIT_MASK` | String | "00002a42-0000-1000-8000-00805f9b34fb" | 13 |
| `ALERT_LEVEL` | String | "00002a06-0000-1000-8000-00805f9b34fb" | 14 |
| `ALERT_NOTIFICATION_CONTROL_POINT` | String | "00002a44-0000-1000-8000-00805f9b34fb" | 15 |
| `ALERT_STATUS` | String | "00002a3f-0000-1000-8000-00805f9b34fb" | 16 |
| `APPEARANCE` | String | "00002a01-0000-1000-8000-00805f9b34fb" | 17 |
| `AUDIO_SINK` | String | "0000110b-0000-1000-8000-00805f9b34fb" | 18 |
| `AUDIO_SOURCE` | String | "0000110a-0000-1000-8000-00805f9b34fb" | 19 |
| `AUDIO_VIDEO` | String | "0000112c-0000-1000-8000-00805f9b34fb" | 20 |
| `AV_REMOTE_CONTROL_TARGET` | String | "0000110c-0000-1000-8000-00805f9b34fb" | 22 |
| `AVRCP_REMOTE` | String | "0000110e-0000-1000-8000-00805f9b34fb" | 21 |
| `BASE_GUID` | String | "00000000-0000-1000-8000-00805f9b34fb" | 23 |
| `BASIC_PRINTING` | String | "00001122-0000-1000-8000-00805f9b34fb" | 24 |
| `BLOOD_PRESSURE_FEATURE` | String | "00002a49-0000-1000-8000-00805f9b34fb" | 25 |
| `BLOOD_PRESSURE_MEASUREMENT` | String | "00002a35-0000-1000-8000-00805f9b34fb" | 26 |
| `BNEP_SVC` | String | "0000000f-0000-1000-8000-00805f9b34fb" | 27 |
| `BODY_SENSOR_LOCATION` | String | "00002a38-0000-1000-8000-00805f9b34fb" | 28 |
| `BROWSE_GROUP_DESCRIPTOR` | String | "00001001-0000-1000-8000-00805f9b34fb" | 29 |
| `CLIENT_CHARACTERISTIC_CONFIG` | String | "00002902-0000-1000-8000-00805f9b34fb" | 30 |
| `CMPT_PROTOCOL` | String | "0000001b-0000-1000-8000-00805f9b34fb" | 31 |
| `COMMON_ISDN_ACCESS` | String | "00001128-0000-1000-8000-00805f9b34fb" | 32 |
| `CORDLESS_TELEPHONY` | String | "00001109-0000-1000-8000-00805f9b34fb" | 33 |
| `CSC_FEATURE` | String | "00002a5c-0000-1000-8000-00805f9b34fb" | 34 |
| `CSC_MEASUREMENT` | String | "00002a5b-0000-1000-8000-00805f9b34fb" | 35 |
| `CURRENT_TIME` | String | "00002a2b-0000-1000-8000-00805f9b34fb" | 36 |
| `CYCLING_SC` | String | "00001816-0000-1000-8000-00805f9b34fb" | 37 |
| `DATE_TIME` | String | "00002a08-0000-1000-8000-00805f9b34fb" | 38 |
| `DAY_DATE_TIME` | String | "00002a0a-0000-1000-8000-00805f9b34fb" | 39 |
| `DAY_OF_WEEK` | String | "00002a09-0000-1000-8000-00805f9b34fb" | 40 |
| `DEVICE_INFORMATION` | String | "0000180a-0000-1000-8000-00805f9b34fb" | 41 |
| `DEVICE_NAME` | String | "00002a00-0000-1000-8000-00805f9b34fb" | 42 |
| `DIRECT_PRINTING` | String | "00001118-0000-1000-8000-00805f9b34fb" | 43 |
| `DIRECT_PRINTING_REFERENCE_OBJECTS` | String | "00001120-0000-1000-8000-00805f9b34fb" | 44 |
| `DST_OFFSET` | String | "00002a0d-0000-1000-8000-00805f9b34fb" | 45 |
| `DUN_GW` | String | "00001103-0000-1000-8000-00805f9b34fb" | 46 |
| `ESDP_UPNP_IP_LAP` | String | "00001301-0000-1000-8000-00805f9b34fb" | 47 |
| `ESDP_UPNP_IP_PAN` | String | "00001300-0000-1000-8000-00805f9b34fb" | 48 |
| `ESDP_UPNP_L2CAP` | String | "00001302-0000-1000-8000-00805f9b34fb" | 49 |
| `ESTIMOTE_ADVERTISING_INTERVAL` | String | "b9403012-f5f8-466e-aff9-25556b57fe6d" | 50 |
| `ESTIMOTE_ADVERTISING_SEED` | String | "b9402001-f5f8-466e-aff9-25556b57fe6d" | 51 |
| `ESTIMOTE_ADVERTISING_VECTOR` | String | "b9402002-f5f8-466e-aff9-25556b57fe6d" | 52 |
| `ESTIMOTE_AUTHENTICATION_SERVICE` | String | "b9402000-f5f8-466e-aff9-25556b57fe6d" | 53 |
| `ESTIMOTE_BATTERY` | String | "b9403041-f5f8-466e-aff9-25556b57fe6d" | 54 |
| `ESTIMOTE_HARDWARE_VERSION` | String | "b9404002-f5f8-466e-aff9-25556b57fe6d" | 55 |
| `ESTIMOTE_MAJOR` | String | "b9403001-f5f8-466e-aff9-25556b57fe6d" | 56 |
| `ESTIMOTE_MINOR` | String | "b9403002-f5f8-466e-aff9-25556b57fe6d" | 57 |
| `ESTIMOTE_POWER` | String | "b9403011-f5f8-466e-aff9-25556b57fe6d" | 58 |
| `ESTIMOTE_SERVICE` | String | "b9403000-f5f8-466e-aff9-25556b57fe6d" | 59 |
| `ESTIMOTE_SOFTWARE_VERSION` | String | "b9404001-f5f8-466e-aff9-25556b57fe6d" | 60 |
| `ESTIMOTE_TEMPERATURE` | String | "b9403021-f5f8-466e-aff9-25556b57fe6d" | 61 |
| `ESTIMOTE_UUID` | String | "b9403003-f5f8-466e-aff9-25556b57fe6d" | 62 |
| `ESTIMOTE_VERSION_SERVICE` | String | "b9404000-f5f8-466e-aff9-25556b57fe6d" | 63 |
| `EXACT_TIME_256` | String | "00002a0c-0000-1000-8000-00805f9b34fb" | 64 |
| `FAX` | String | "00001111-0000-1000-8000-00805f9b34fb" | 65 |
| `FIRMWARE_REVISION_STRING` | String | "00002a26-0000-1000-8000-00805f9b34fb" | 66 |
| `FTP` | String | "0000000a-0000-1000-8000-00805f9b34fb" | 67 |
| `GAP` | String | "00001800-0000-1000-8000-00805f9b34fb" | 68 |
| `GATT` | String | "00001801-0000-1000-8000-00805f9b34fb" | 69 |
| `GENERIC_AUDIO` | String | "00001203-0000-1000-8000-00805f9b34fb" | 70 |
| `GENERIC_FILE_TRANSFER` | String | "00001202-0000-1000-8000-00805f9b34fb" | 71 |
| `GENERIC_NETWORKING` | String | "00001201-0000-1000-8000-00805f9b34fb" | 72 |
| `GENERIC_TELEPHONY` | String | "00001204-0000-1000-8000-00805f9b34fb" | 73 |
| `GN` | String | "00001117-0000-1000-8000-00805f9b34fb" | 74 |
| `HANDS_FREE_PROFILE_HFP` | String | "0000111e-0000-1000-8000-00805f9b34fb" | 75 |
| `HANDS_FREE_PROFILE_HFP_AUDIO_GATEWAY` | String | "0000111f-0000-1000-8000-00805f9b34fb" | 76 |
| `HARDCOPY_CABLE_REPLACEMENT` | String | "00001125-0000-1000-8000-00805f9b34fb" | 77 |
| `HARDCOPY_CONTROL_CHANNEL_PROTOCOL` | String | "00000012-0000-1000-8000-00805f9b34fb" | 78 |
| `HARDCOPY_DATA_CHANNEL_PROTOCOL` | String | "00000014-0000-1000-8000-00805f9b34fb" | 79 |
| `HARDCOPY_NOTIFICATION_PROTOCOL` | String | "00000016-0000-1000-8000-00805f9b34fb" | 80 |
| `HARDWARE_REVISION_STRING` | String | "00002a27-0000-1000-8000-00805f9b34fb" | 81 |
| `HCR_PRINT` | String | "00001126-0000-1000-8000-00805f9b34fb" | 82 |
| `HCR_SCAN` | String | "00001127-0000-1000-8000-00805f9b34fb" | 83 |
| `HEADSET_PROFILE_HSP_AUDIO_GATEWAY` | String | "00001112-0000-1000-8000-00805f9b34fb" | 84 |
| `HEALTH_DEVICE_PROFILE_HDP` | String | "00001400-0000-1000-8000-00805f9b34fb" | 85 |
| `HEALTH_DEVICE_PROFILE_HDP_SINK` | String | "00001402-0000-1000-8000-00805f9b34fb" | 86 |
| `HEALTH_DEVICE_PROFILE_HDP_SOURCE` | String | "00001401-0000-1000-8000-00805f9b34fb" | 87 |
| `HEALTH_THERMOMETER` | String | "00001809-0000-1000-8000-00805f9b34fb" | 88 |
| `HEART_RATE` | String | "0000180d-0000-1000-8000-00805f9b34fb" | 89 |
| `HEART_RATE_CONTROL_POINT` | String | "00002a39-0000-1000-8000-00805f9b34fb" | 90 |
| `HEART_RATE_MEASUREMENT` | String | "00002a37-0000-1000-8000-00805f9b34fb" | 91 |
| `HID` | String | "00001124-0000-1000-8000-00805f9b34fb" | 92 |
| `HIDP` | String | "00000011-0000-1000-8000-00805f9b34fb" | 93 |
| `HSP_HS` | String | "00001108-0000-1000-8000-00805f9b34fb" | 94 |
| `HTTP` | String | "0000000c-0000-1000-8000-00805f9b34fb" | 95 |
| `IEEE_1107320601_REGULATORY` | String | "00002a2a-0000-1000-8000-00805f9b34fb" | 96 |
| `IMAGING` | String | "0000111a-0000-1000-8000-00805f9b34fb" | 97 |
| `IMAGING_AUTOMATIC_ARCHIVE` | String | "0000111c-0000-1000-8000-00805f9b34fb" | 98 |
| `IMAGING_REFERENCE_OBJECTS` | String | "0000111d-0000-1000-8000-00805f9b34fb" | 99 |
| `IMAGING_RESPONDER` | String | "0000111b-0000-1000-8000-00805f9b34fb" | 100 |
| `IMMEDIATE_ALERT` | String | "00001802-0000-1000-8000-00805f9b34fb" | 101 |
| `INTERCOM` | String | "00001110-0000-1000-8000-00805f9b34fb" | 102 |
| `INTERMEDIATE_CUFF_PRESSURE` | String | "00002a36-0000-1000-8000-00805f9b34fb" | 103 |
| `INTERMEDIATE_TEMPERATURE` | String | "00002a1e-0000-1000-8000-00805f9b34fb" | 104 |
| `IP` | String | "00000009-0000-1000-8000-00805f9b34fb" | 105 |
| `IRMC_SYNC_COMMAND` | String | "00001107-0000-1000-8000-00805f9b34fb" | 106 |
| `L2CAP` | String | "00000100-0000-1000-8000-00805f9b34fb" | 107 |
| `LAN_ACCESS_USING_PPP` | String | "00001102-0000-1000-8000-00805f9b34fb" | 108 |
| `LINK_LOSS` | String | "00001803-0000-1000-8000-00805f9b34fb" | 109 |
| `LOCAL_TIME_INFORMATION` | String | "00002a0f-0000-1000-8000-00805f9b34fb" | 110 |
| `MANUFACTURER_NAME_STRING` | String | "00002a29-0000-1000-8000-00805f9b34fb" | 111 |
| `MCAP_CONTROL_CHANNEL` | String | "0000001e-0000-1000-8000-00805f9b34fb" | 112 |
| `MCAP_DATA_CHANNEL` | String | "0000001f-0000-1000-8000-00805f9b34fb" | 113 |
| `MEASUREMENT_INTERVAL` | String | "00002a21-0000-1000-8000-00805f9b34fb" | 114 |
| `MODEL_NUMBER_STRING` | String | "00002a24-0000-1000-8000-00805f9b34fb" | 115 |
| `NAP` | String | "00001116-0000-1000-8000-00805f9b34fb" | 116 |
| `NEW_ALERT` | String | "00002a46-0000-1000-8000-00805f9b34fb" | 117 |
| `OBEX_FILE_TRANSFER` | String | "00001106-0000-1000-8000-00805f9b34fb" | 118 |
| `OBEX_MAP` | String | "00001134-0000-1000-8000-00805f9b34fb" | 119 |
| `OBEX_MAS` | String | "00001132-0000-1000-8000-00805f9b34fb" | 120 |
| `OBEX_MNS` | String | "00001133-0000-1000-8000-00805f9b34fb" | 121 |
| `OBEX_OBJECT_PUSH` | String | "00001105-0000-1000-8000-00805f9b34fb" | 122 |
| `OBEX_PBAP` | String | "00001130-0000-1000-8000-00805f9b34fb" | 123 |
| `OBEX_PCE` | String | "0000112e-0000-1000-8000-00805f9b34fb" | 124 |
| `OBEX_PSE` | String | "0000112f-0000-1000-8000-00805f9b34fb" | 125 |
| `OBEX_SYNC` | String | "00001104-0000-1000-8000-00805f9b34fb" | 126 |
| `OBJECT_EXCHANGE_PROTOCOL_OBEX` | String | "00000008-0000-1000-8000-00805f9b34fb" | 127 |
| `PANU` | String | "00001115-0000-1000-8000-00805f9b34fb" | 128 |
| `PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS` | String | "00002a04-0000-1000-8000-00805f9b34fb" | 129 |
| `PERIPHERAL_PRIVACY_FLAG` | String | "00002a02-0000-1000-8000-00805f9b34fb" | 130 |
| `PNP` | String | "00001200-0000-1000-8000-00805f9b34fb" | 131 |
| `PNPID` | String | "00002a50-0000-1000-8000-00805f9b34fb" | 132 |
| `PRINTING_STATUS` | String | "00001123-0000-1000-8000-00805f9b34fb" | 133 |
| `PUBLIC_BROWSE_GROUP` | String | "00001002-0000-1000-8000-00805f9b34fb" | 134 |
| `RADIO_FREQUENCY_COMMUNICATION_PROTOCOL_RFCOMM` | String | "00000003-0000-1000-8000-00805f9b34fb" | 135 |
| `RECONNECTION_ADDRESS` | String | "00002a03-0000-1000-8000-00805f9b34fb" | 136 |
| `REFERENCE_PRINTING` | String | "00001119-0000-1000-8000-00805f9b34fb" | 137 |
| `REFERENCE_TIME_INFORMATION` | String | "00002a14-0000-1000-8000-00805f9b34fb" | 138 |
| `REFLECTED_UI` | String | "00001121-0000-1000-8000-00805f9b34fb" | 139 |
| `RINGER_CONTROL_POINT` | String | "00002a40-0000-1000-8000-00805f9b34fb" | 140 |
| `RINGER_SETTING` | String | "00002a41-0000-1000-8000-00805f9b34fb" | 141 |
| `SC_CONTROL_POINT` | String | "00002a55-0000-1000-8000-00805f9b34fb" | 142 |
| `SENSOR_LOCATION` | String | "00002a5d-0000-1000-8000-00805f9b34fb" | 143 |
| `SERIAL_NUMBER_STRING` | String | "00002a25-0000-1000-8000-00805f9b34fb" | 144 |
| `SERVICE_CHANGED` | String | "00002a05-0000-1000-8000-00805f9b34fb" | 145 |
| `SERVICE_DISCOVERY_PROTOCOL_SDP` | String | "00000001-0000-1000-8000-00805f9b34fb" | 146 |
| `SERVICE_DISCOVERY_SERVER` | String | "00001000-0000-1000-8000-00805f9b34fb" | 147 |
| `SIM_ACCESS` | String | "0000112d-0000-1000-8000-00805f9b34fb" | 148 |
| `SOFTWARE_REVISION_STRING` | String | "00002a28-0000-1000-8000-00805f9b34fb" | 149 |
| `SPP` | String | "00001101-0000-1000-8000-00805f9b34fb" | 150 |
| `SUPPORTED_NEW_ALERT_CATEGORY` | String | "00002a47-0000-1000-8000-00805f9b34fb" | 151 |
| `SUPPORTED_UNREAD_ALERT_CATEGORY` | String | "00002a48-0000-1000-8000-00805f9b34fb" | 152 |
| `SYSTEM_ID` | String | "00002a23-0000-1000-8000-00805f9b34fb" | 153 |
| `TCP` | String | "00000004-0000-1000-8000-00805f9b34fb" | 154 |
| `TCSAT` | String | "00000006-0000-1000-8000-00805f9b34fb" | 155 |
| `TCSBIN` | String | "00000005-0000-1000-8000-00805f9b34fb" | 156 |
| `TEMPERATURE_MEASUREMENT` | String | "00002a1c-0000-1000-8000-00805f9b34fb" | 157 |
| `TEMPERATURE_TYPE` | String | "00002a1d-0000-1000-8000-00805f9b34fb" | 158 |
| `TIME_ACCURACY` | String | "00002a12-0000-1000-8000-00805f9b34fb" | 159 |
| `TIME_SOURCE` | String | "00002a13-0000-1000-8000-00805f9b34fb" | 160 |
| `TIME_UPDATE_CONTROL_POINT` | String | "00002a16-0000-1000-8000-00805f9b34fb" | 161 |
| `TIME_UPDATE_STATE` | String | "00002a17-0000-1000-8000-00805f9b34fb" | 162 |
| `TIME_WITH_DST` | String | "00002a11-0000-1000-8000-00805f9b34fb" | 163 |
| `TIME_ZONE` | String | "00002a0e-0000-1000-8000-00805f9b34fb" | 164 |
| `TX_POWER` | String | "00001804-0000-1000-8000-00805f9b34fb" | 165 |
| `TX_POWER_LEVEL` | String | "00002a07-0000-1000-8000-00805f9b34fb" | 166 |
| `UDI_C_PLANE_PROTOCOL` | String | "0000001d-0000-1000-8000-00805f9b34fb" | 169 |
| `UDIMT` | String | "0000112a-0000-1000-8000-00805f9b34fb" | 167 |
| `UDITA` | String | "0000112b-0000-1000-8000-00805f9b34fb" | 168 |
| `UNREAD_ALERT_STATUS` | String | "00002a45-0000-1000-8000-00805f9b34fb" | 170 |
| `UPNP` | String | "00001205-0000-1000-8000-00805f9b34fb" | 171 |
| `UPNP_IP` | String | "00001206-0000-1000-8000-00805f9b34fb" | 172 |
| `UPNP_PROTOCOL` | String | "00000010-0000-1000-8000-00805f9b34fb" | 173 |
| `USER_DATAGRAM_PROTOCOL_UDP` | String | "00000002-0000-1000-8000-00805f9b34fb" | 174 |
| `VCTP_PROTOCOL` | String | "00000017-0000-1000-8000-00805f9b34fb" | 175 |
| `VDTP_PROTOCOL` | String | "00000019-0000-1000-8000-00805f9b34fb" | 176 |
| `VIDEO_CONFERENCING` | String | "0000110f-0000-1000-8000-00805f9b34fb" | 177 |
| `VIDEO_CONFERENCING_GATEWAY` | String | "00001129-0000-1000-8000-00805f9b34fb" | 178 |
| `VIDEO_DISTRIBUTION_PROFILE_VDP` | String | "00001305-0000-1000-8000-00805f9b34fb" | 179 |
| `VIDEO_DISTRIBUTION_PROFILE_VDP_SINK` | String | "00001304-0000-1000-8000-00805f9b34fb" | 180 |
| `VIDEO_DISTRIBUTION_PROFILE_VDP_SOURCE` | String | "00001303-0000-1000-8000-00805f9b34fb" | 181 |
| `WAP` | String | "00001113-0000-1000-8000-00805f9b34fb" | 182 |
| `WAP_CLIENT` | String | "00001114-0000-1000-8000-00805f9b34fb" | 183 |
| `WSP` | String | "0000000e-0000-1000-8000-00805f9b34fb" | 184 |

### `com.gku.actioncam.sigmastar.bluetooth.utils.WIFIUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `$assertionsDisabled` | boolean | false | 21 |
| `TAG` | String | "WIFIUtils" | 22 |

### `com.gku.actioncam.sigmastar.bluetooth.widget.CustomPopupDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CustomPopupDialog" | 19 |

### `com.gku.actioncam.sigmastar.bluetooth.widget.TopPopupWindow`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "TopPopupWindow" | 20 |

### `com.gku.actioncam.sigmastar.data.connect.ClientThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "lzy" | 9 |

### `com.gku.actioncam.sigmastar.data.connect.SSConnectDevice`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SSConnectDevice" | 29 |

### `com.gku.actioncam.sigmastar.data.SSFileUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SSFileUtils" | 42 |

### `com.gku.actioncam.sigmastar.data.SSResponseParse`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HEAD_VAR` | String | "var " | 39 |
| `MID_EQUAL_MARK` | String | "=\"" | 40 |
| `SS_SUCCESS` | String | "Success" | 41 |
| `TAG` | String | "SSResponseParse" | 42 |
| `TAIL_SEMICOLON` | String | "\";\r\n" | 43 |

### `com.gku.actioncam.sigmastar.HaisiCommandUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SS_BASE_PATH` | String | "/cgi-bin/hi3510/" | 11 |
| `SS_CGI` | String | ".cgi" | 12 |
| `SS_DELETE_FILE` | String | "deletefile" | 13 |
| `SS_EXIT_QUICK_REC` | String | "exitquickrec" | 14 |
| `SS_FORMAT_SD` | String | "sdcommand" | 15 |
| `SS_GET_ALL_WORK_MODE` | String | "getallworkmode" | 16 |
| `SS_GET_BATTERY_INFO` | String | "getbatterycapacity" | 17 |
| `SS_GET_CAMERA_STATUS` | String | "getcamerastatus" | 18 |
| `SS_GET_CUR_ALL_INFO` | String | "getcurallinfo" | 19 |
| `SS_GET_CUR_PARAM` | String | "getsecondmenuitem" | 20 |
| `SS_GET_CUR_WORK_MODE` | String | "getcurworkmode" | 21 |
| `SS_GET_DEVICE_ATTR` | String | "getdeviceattr" | 22 |
| `SS_GET_FILE_COUNT` | String | "getfilecount" | 23 |
| `SS_GET_FILE_INFO` | String | "getfileinfo" | 24 |
| `SS_GET_FILE_LIST` | String | "getfilelist" | 25 |
| `SS_GET_FILE_LIST_IOS` | String | "getfilelistinfoios" | 26 |
| `SS_GET_PRIMARY_MENU_ITEM` | String | "getprimarymenuitem" | 27 |
| `SS_GET_SD_STATUS` | String | "getsdstate" | 28 |
| `SS_GET_SECOND_MENU_ITEM` | String | "getsecondmenuitem" | 29 |
| `SS_GET_WIFI` | String | "getwifi" | 30 |
| `SS_LIVE_STREAM_PATH` | String | "/livestream/12" | 31 |
| `SS_LIVE_STREAM_PORT` | int | 554 | 32 |
| `SS_PHOTO` | String | "photo" | 33 |
| `SS_PROTOCOL_HTTP` | String | "http://" | 34 |
| `SS_PROTOCOL_RTSP` | String | "rtsp://" | 35 |
| `SS_QUICK_STORIES_ADD_TIME` | String | "record" | 36 |
| `SS_RECORD` | String | "record" | 37 |
| `SS_REST` | String | "reset" | 38 |
| `SS_SET_CAMERA_STATUS` | String | "setcamerastatus" | 39 |
| `SS_SET_CUR_PARAM` | String | "setcurparameter" | 40 |
| `SS_SET_CUR_WORK_MODE` | String | "setcurworkmode" | 41 |
| `SS_SET_SYSTEM_TIME` | String | "setsystime" | 42 |
| `SS_SET_WIFI` | String | "setwifi" | 43 |

### `com.gku.actioncam.sigmastar.newUi.album.Data.AlbumNewItemModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_HD_VIDEO` | int | 3 | 22 |
| `TYPE_IMAGE` | int | 1 | 23 |
| `TYPE_VIDEO` | int | 2 | 24 |

### `com.gku.actioncam.sigmastar.newUi.album.Data.MediaNewScanTask`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MediaNewScanTask" | 25 |

### `com.gku.actioncam.sigmastar.newUi.album.Ui.Activity.ActivityNewPreview`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_DATA` | String | "data" | 47 |
| `ARG_POSITION` | String | "position" | 48 |
| `ARG_TYPE` | String | "TYPE" | 49 |
| `TAG` | String | "ActivityNewPreview" | 50 |

### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.SectionNewAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_SECTION` | int | 0 | 23 |

### `com.gku.actioncam.sigmastar.newUi.album.Ui.Adapter.SubNewAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SubNewAdapter" | 28 |

### `com.gku.actioncam.sigmastar.newUi.album.Ui.Fragment.CommonFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CommonFragment" | 54 |

### `com.gku.actioncam.sigmastar.newUi.album.Ui.Fragment.FragmentFavorites`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FragmentFavorites" | 37 |

### `com.gku.actioncam.sigmastar.newUi.album.Ui.Fragment.FragmentNewAlbum`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `REQUEST_PERMISSION_ALBUM` | int | 321 | 19 |
| `TAG` | String | "FragmentNewAlbum" | 20 |

### `com.gku.actioncam.sigmastar.newUi.album.Ui.Fragment.FragmentNewNormalAlbum`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_TYPE` | String | "type" | 45 |
| `TAG` | String | "FragmentNewNormalAlbum" | 46 |

### `com.gku.actioncam.sigmastar.newUi.album.Utils.FavoriteDatabaseHelper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FavoriteDatabaseHelper" | 21 |

### `com.gku.actioncam.sigmastar.newUi.album.Utils.FileNewUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FileNewUtils" | 40 |

### `com.gku.actioncam.sigmastar.newUi.common.presenter.SBTHeartbeatPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SBTHeartbeatPresenter" | 13 |

### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Activity.DeviceAddNewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CALLBACK_SCANWIFI_RESULT_FOR_THIS` | String | "DeviceAddNewActivity" | 60 |
| `CODE_SCAN_WIFI` | int | 321 | 61 |

### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Activity.UserGuideActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UserGuideActivity" | 24 |

### `com.gku.actioncam.sigmastar.newUi.deviceAdd.base.BaseActivateActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "BaseActivateActivity" | 23 |

### `com.gku.actioncam.sigmastar.newUi.deviceAdd.base.BasePermissionActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `btPermissionList` | String[] | {"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN"} | 18 |
| `btPermissionList1` | String[] | {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_ADVERTISE"} | 20 |
| `wifiPermissionList` | String[] | {"android.permission.ACCESS_COARSE_LOCATION", PermissionUtils.LOCATION} | 19 |
| `wifiPermissionList1` | String[] | {"android.permission.ACCESS_COARSE_LOCATION", PermissionUtils.LOCATION} | 21 |

### `com.gku.actioncam.sigmastar.newUi.deviceAdd.BLEManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "BLEManager" | 19 |

### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.connect.BLEConnectUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CHUNK_SIZE` | int | 100 | 43 |
| `TAG` | String | "BLEConnectUtils" | 44 |
| `TIMEOUT_MS` | long | 1000 | 45 |

### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddBottomSheetDialogFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARGUMENT_LIVE` | String | "ARGUMENT_LIVE" | 30 |
| `TAG` | String | "DeviceAddBottomSheetDialogFragment" | 31 |

### `com.gku.actioncam.sigmastar.newUi.deviceAdd.Fragment.DeviceAddWaveFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DeviceAddWaveFragment" | 58 |

### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.AmbaFastSettingModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AmbaFastSettingModel" | 28 |

### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.Base.BaseDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "BaseDialog" | 19 |

### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FastSettingPresenter" | 11 |

### `com.gku.actioncam.sigmastar.newUi.deviceFastSetting.FastSettingRecycleAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FastSettingRecycleAdapter" | 21 |

### `com.gku.actioncam.sigmastar.OldUi.playback.model.AmbaPlaybackModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PAGECOUNT` | int | 50 | 46 |
| `TAG` | String | "AmbaPlaybackModel" | 47 |

### `com.gku.actioncam.sigmastar.OldUi.playback.model.HisiPlaybackModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PAGECOUNT` | int | 50 | 46 |
| `TAG` | String | "HisiPlaybackModel" | 47 |

### `com.gku.actioncam.sigmastar.OldUi.playback.model.service.DownloadIntentService`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DOWNLOAD_NOTIFICATION_ID` | int | 1741 | 24 |
| `DOWNLOAD_PATH` | String | "com.gku.actioncam.sigmastar.OldUi.playback.path" | 25 |
| `DOWNLOAD_STATE` | String | "com.gku.actioncam.sigmastar.OldUi.playback.state" | 26 |
| `DOWNLOAD_TASK` | String | "com.gku.actioncam.sigmastar.OldUi.playback.action.DOWNLOAD_TASK" | 27 |
| `TAG` | String | "DownloadIntentService" | 28 |

### `com.gku.actioncam.sigmastar.OldUi.playback.model.SigmastartPlaybackModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PAGECOUNT` | int | 50 | 32 |
| `TAG` | String | "SigmastartPlaybackModel" | 33 |

### `com.gku.actioncam.sigmastar.OldUi.playback.presenter.SSPlaybackNewPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SSPlaybackNewPresenter" | 80 |

### `com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSDownloadStateDialogActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RESULT_CODE_DOWNLOAD_DIALOG` | int | 87865 | 26 |
| `RESULT_DOWNLOAD_DATA` | String | "doneFileList" | 27 |
| `TAG` | String | "SSDownloadStateDialogActivity" | 28 |

### `com.gku.actioncam.sigmastar.OldUi.playback.ui.adapter.SSPlaybackRecycleAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PAYLOAD_UPDATE_DOWNLOAD` | String | "update_download" | 33 |
| `PAYLOAD_UPDATE_SELECT_STATE` | String | "update_select_state" | 34 |
| `TAG` | String | "SSPlaybackRecycleAdapter" | 35 |

### `com.gku.actioncam.sigmastar.OldUi.preview.model.AmbaPreviewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AmbaPreviewModel" | 47 |

### `com.gku.actioncam.sigmastar.OldUi.preview.model.HaisiPreviewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SigmastartPreviewModel" | 31 |

### `com.gku.actioncam.sigmastar.OldUi.preview.model.PreviewModelManage`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PreviewModelManage" | 12 |

### `com.gku.actioncam.sigmastar.OldUi.preview.model.SigmastartPreviewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SigmastartPreviewModel" | 22 |

### `com.gku.actioncam.sigmastar.OldUi.preview.presenter.ActionCameraPreviewPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ActionCameraPreviewPresenter" | 46 |
| `WHAT_BATTERY_POLLING` | int | 211059 | 47 |
| `WHAT_SD_POLLING` | int | 211058 | 48 |

### `com.gku.actioncam.sigmastar.OldUi.preview.ui.activity.AmbaActionCameraPreviewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HANDLER_WHAT_HIDE_MAIN_UI` | int | 1320 | 86 |
| `HANDLER_WHAT_SHOW_MAIN_UI` | int | 1319 | 87 |
| `STATE_RECORDING` | int | 1 | 88 |
| `STATE_UNRECORDING` | int | 0 | 89 |
| `TAG` | String | "SSPreviewNewActivity" | 90 |
| `TAG_SS_PREVIEW_SAVE` | String | "ss_preview_save" | 91 |

### `com.gku.actioncam.sigmastar.OldUi.preview.ui.activity.HisiActionCameraPreviewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HANDLER_WHAT_HIDE_MAIN_UI` | int | 1320 | 88 |
| `HANDLER_WHAT_SHOW_MAIN_UI` | int | 1319 | 89 |
| `STATE_RECORDING` | int | 1 | 90 |
| `STATE_UNRECORDING` | int | 0 | 91 |
| `TAG` | String | "SSPreviewNewActivity" | 92 |
| `TAG_SS_PREVIEW_SAVE` | String | "ss_preview_save" | 93 |

### `com.gku.actioncam.sigmastar.OldUi.setting.presenter.SSettingPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SSettingPresenter" | 39 |

### `com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSDeviceSettingActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CALLBACK_GET_PRIMARY_FAIL` | String | "CALLBACK_GET_PRIMARY_FAIL" | 48 |
| `CALLBACK_GET_PRIMARY_SUCCUSS` | String | "CALLBACK_GET_PRIMARY_SUCCUSS" | 49 |
| `curMode` | String | "System" | 51 |
| `supportSwitchType` | String[] | {"Inversion Mode", "Date Stamp", "Brand Stamp", "Key Tone", "Cap Tone", "Power Tone", "Remote Control", "Face Detection", "Grid", "Auto Sync Time", "Voice Control", "Time Stamp"} | 52 |
| `TAG` | String | "SSDeviceSettingActivity" | 50 |

### `com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSModeSettingActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SSModeSettingActivity" | 49 |
| `TAG_MODE_SETTING_WORK_MODE` | String | "mode_setting_work_mode" | 50 |

### `com.gku.actioncam.sigmastar.OldUi.setting.ui.adapter.SettingRecycleAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SettingRecycleAdapter" | 17 |

### `com.gku.actioncam.sigmastar.SSCommandUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SS_BASE_PATH` | String | "/cgi-bin/hi3510/" | 9 |
| `SS_CGI` | String | ".cgi" | 10 |
| `SS_DELETE_FILE` | String | "deletefile" | 11 |
| `SS_EXIT_QUICK_REC` | String | "exitquickrec" | 12 |
| `SS_FORMAT_SD` | String | "sdcommand" | 13 |
| `SS_GET_ALL_WORK_MODE` | String | "getallworkmode" | 14 |
| `SS_GET_BATTERY_INFO` | String | "getbatterycapacity" | 15 |
| `SS_GET_CAMERA_STATUS` | String | "getcamerastatus" | 16 |
| `SS_GET_CUR_ALL_INFO` | String | "getcurallinfo" | 17 |
| `SS_GET_CUR_PARAM` | String | "getcurparameter" | 18 |
| `SS_GET_CUR_WORK_MODE` | String | "getcurworkmode" | 19 |
| `SS_GET_DEVICE_ATTR` | String | "getdeviceattr" | 20 |
| `SS_GET_DIRNAME` | String | "getdirname" | 21 |
| `SS_GET_FILE_COUNT` | String | "getfiletypecount" | 22 |
| `SS_GET_FILE_INFO` | String | "getfileinfo" | 23 |
| `SS_GET_FILE_LIST` | String | "getfilelist" | 24 |
| `SS_GET_FILE_LIST_IOS` | String | "getfilelistinfoios" | 25 |
| `SS_GET_PRIMARY_MENU_ITEM` | String | "getprimarymenuitem" | 26 |
| `SS_GET_ROTATE` | String | "getcurrotation" | 27 |
| `SS_GET_SD_STATUS` | String | "getsdstate" | 28 |
| `SS_GET_SECOND_MENU_ITEM` | String | "getsecondmenuitem" | 29 |
| `SS_GET_WIFI` | String | "getwifi" | 30 |
| `SS_LIVE_STREAM_PATH` | String | "/livestream/12" | 31 |
| `SS_LIVE_STREAM_PORT` | String | "554" | 32 |
| `SS_PHOTO` | String | "photo" | 33 |
| `SS_PROTOCOL_HTTP` | String | "http://" | 34 |
| `SS_PROTOCOL_RTSP` | String | "rtsp://" | 35 |
| `SS_QUICK_STORIES_ADD_TIME` | String | "record" | 36 |
| `SS_RECORD` | String | "record" | 37 |
| `SS_REST` | String | "reset" | 38 |
| `SS_SET_CAMERA_STATUS` | String | "setcamerastatus" | 39 |
| `SS_SET_CUR_PARAM` | String | "setcurparameter" | 40 |
| `SS_SET_CUR_WORK_MODE` | String | "setcurworkmode" | 41 |
| `SS_SET_SYSTEM_TIME` | String | "setsystime" | 42 |
| `SS_SET_WIFI` | String | "setwifi" | 43 |

### `com.gku.actioncam.sigmastar.SSConstant`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA` | String | "H75N" | 5 |
| `CHIP` | String | "SSC8838" | 6 |
| `CHIP_26` | String | "SSC8826" | 7 |
| `CHIP_38c` | String | "SSC8838C" | 8 |
| `HAISI` | String | "Hi" | 9 |
| `LOCAL_DOWNLOAD_DIR` | String | "/mnt/sdcard/DCIM/ActionCam/" | 10 |
| `LOCAL_THUMB_CACHE_DIR` | String | "/mnt/sdcard/Android/data/com.gku.xtugo/cache/" | 11 |
| `SSEnable` | boolean | true | 12 |

### `com.gku.actioncam.sigmastar.upgrade.app.ApkInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ApkInfo" | 7 |

### `com.gku.actioncam.sigmastar.upgrade.app.DownloadActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_DOWNLOAD_SUCCESS` | int | 2002 | 28 |
| `MSG_QUERY_PROGRESS` | int | 2001 | 29 |
| `MSG_REFRESH_UI` | int | 2003 | 30 |
| `TAG` | String | "DownloadActivity" | 31 |

### `com.gku.actioncam.sigmastar.upgrade.app.UpgradeTaskManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SERVER_BASE_URL` | String | "http://121.40.107.215:8041/firmware/" | 35 |
| `SERVER_INFO_FILE` | String | "info.json" | 36 |
| `TAG` | String | "UpgradeManager" | 37 |

### `com.gku.actioncam.sigmastar.upgrade.app.UpgradeViewManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APK_ORIGINAL_NAME` | String | "xtugo_newui" | 47 |
| `CHECK_UPDATE` | int | 4 | 48 |
| `CHECK_UPDATE_FAIL` | int | 6 | 49 |
| `CHECK_UPDATE_FINISH` | int | 5 | 50 |
| `DOWNLOAD_FAIL` | int | 3 | 51 |
| `DOWNLOAD_FINISH` | int | 2 | 52 |
| `DOWNLOAD_PERCENT` | int | 1 | 53 |
| `DOWNLOAD_START` | int | 0 | 54 |
| `INSTALL_APK` | int | 7 | 55 |
| `SUCCESS` | int | 0 | 56 |
| `TAG` | String | "UpgradeViewManager" | 57 |

### `com.gku.actioncam.sigmastar.upgrade.firm.Presenter.UpgradePresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DOWNLOAD_FILE_CODE` | int | 100001 | 58 |
| `DOWNLOAD_FILE_ContectCamera_CODE` | int | 100008 | 59 |
| `DOWNLOAD_FILE_DOWNLOADirmware_CODE` | int | 100007 | 60 |
| `DOWNLOAD_FILE_FAILE_CODE` | int | 100002 | 61 |
| `DOWNLOAD_FILE_FAILE_FINISH_CODE` | int | 100003 | 62 |
| `DOWNLOAD_FILE_FAILE_GETMODELNAME_CODE` | int | 100004 | 63 |
| `DOWNLOAD_FILE_FAILE_GETPATHERROR_CODE` | int | 100005 | 64 |
| `DOWNLOAD_FILE_FAILE_SVGreaterThan_LV_CODE` | int | 100006 | 65 |
| `DOWNLOAD_FILE_NotExistFileInfo_CODE` | int | 100009 | 66 |
| `TAG` | String | "UpgradePresenter" | 67 |

### `com.gku.actioncam.sigmastar.upgrade.firm.Ui.UpgradeSendFirmActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UpgradeSendFirmActivity" | 42 |

### `com.gku.actioncam.sigmastar.upgrade.firm.Utils.DownloadUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "com.gku.actioncam.sigmastar.upgrade.firm.Utils.DownloadUtil" | 17 |

### `com.gku.actioncam.sigmastar.upgrade.firm.Utils.UpdateVersionUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UpdateVersionUtils" | 24 |

### `com.gku.actioncam.sigmastar.util.ClearGlideCacheTask`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ClearGlideCacheTask" | 10 |

### `com.gku.actioncam.sigmastar.util.FileUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MEDIA_DIR` | String | "SportCam" | 28 |

### `com.gku.actioncam.sigmastar.util.SSDownloadUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SSDownloadUtil" | 29 |

### `com.gku.actioncam.sigmastar.util.SSExchangeWorkMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SS_BURST_PHOTO` | String | "Burst Photo" | 11 |
| `SS_CAR_LOOPING` | String | "Car Looping" | 12 |
| `SS_LAPSE_PHOTO` | String | "Lapse Photo" | 13 |
| `SS_LAPSE_PHOTO_OLD` | String | "Timelapse Photo" | 14 |
| `SS_LAPSE_VIDEO` | String | "Timelapse Video" | 15 |
| `SS_LONG_EXPOSURE` | String | "Long Exposure" | 16 |
| `SS_NORMAL_PHOTO` | String | "Normal Photo" | 17 |
| `SS_NORMAL_VIDEO` | String | "Normal Video" | 18 |
| `SS_QUICK_STORIES` | String | "Quick Stories" | 19 |
| `SS_QUICK_VIDEO` | String | "Quick Video" | 20 |
| `SS_RAW_PHOTO` | String | "Raw Photo" | 21 |
| `SS_SLOW_MOTION` | String | "Slow Motion" | 22 |
| `SS_TIMING_PHOTO` | String | "Timing Photo" | 23 |
| `SS_UNDER_WATER` | String | "Under Water" | 24 |
| `SS_VIDEO_PHOTO` | String | "Video and Photo" | 25 |

### `com.gku.actioncam.sigmastar.util.SSFileUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SSFileUtil" | 29 |

### `com.gku.actioncam.sigmastar.util.SSHttpClientUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SSHttpClientUtil" | 35 |
| `TIMEOUT_SECONDS` | int | 3 | 36 |

### `com.gku.actioncam.sigmastar.videoedit.AudioCollectActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AudioCollectActivity" | 40 |

### `com.gku.actioncam.sigmastar.videoedit.AudioCollectAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AudioCollectAdapter" | 32 |

### `com.gku.actioncam.sigmastar.videoedit.CameraVideoActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CameraVideoActivity" | 33 |

### `com.gku.actioncam.sigmastar.videoedit.CloudMusicLoadingView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_MIN_WIDTH` | int | 65 | 15 |
| `DEFAULT_RAIL_COUNT` | int | 4 | 16 |

### `com.gku.actioncam.sigmastar.videoedit.CutAudioDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CutAudioDialog" | 30 |

### `com.gku.actioncam.sigmastar.videoedit.FilePathUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FilePathUtils" | 27 |

### `com.gku.actioncam.sigmastar.videoedit.MediaDecoder`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MediaDecoder" | 10 |

### `com.gku.actioncam.sigmastar.videoedit.RangeSeekBar`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_POINTER_INDEX_MASK` | int | 65280 | 23 |
| `ACTION_POINTER_INDEX_SHIFT` | int | 8 | 24 |
| `INVALID_POINTER_ID` | int | 255 | 25 |
| `TAG` | String | "RangeSeekBar" | 26 |

### `com.gku.actioncam.sigmastar.videoedit.VideoEditActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_NAME` | String | "videoName" | 47 |
| `ARG_PATH` | String | "videoPath" | 48 |
| `TAG` | String | "VideoEditActivity" | 49 |

### `com.gku.actioncam.sigmastar.widget.controller.SSMediaController`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FADE_OUT` | int | 1 | 27 |
| `sDefaultTimeout` | int | 3000 | 30 |
| `SHOW_PROGRESS` | int | 2 | 28 |
| `TAG` | String | "SSMediaController" | 29 |

### `com.gku.actioncam.sigmastar.widget.MyCircleProgress`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MyCircleProgress" | 16 |

### `com.gku.actioncam.sigmastar.widget.RadarView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SCAN_ANGLE` | int | 60 | 20 |

### `com.gku.actioncam.sigmastar.widget.roundview.RoundImageView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_CIRCLE` | int | 0 | 23 |
| `TYPE_OVAL` | int | 2 | 24 |
| `TYPE_ROUND` | int | 1 | 25 |

### `com.gku.actioncam.sigmastar.widget.SSDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SSDialog" | 26 |

### `com.gku.actioncam.sigmastar.widget.SSVideoView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `STATE_ERROR` | int | -1 | 28 |
| `STATE_IDLE` | int | 0 | 29 |
| `STATE_PAUSED` | int | 4 | 30 |
| `STATE_PLAYBACK_COMPLETED` | int | 5 | 31 |
| `STATE_PLAYING` | int | 3 | 32 |
| `STATE_PREPARED` | int | 2 | 33 |
| `STATE_PREPARING` | int | 1 | 34 |
| `STATE_RESUME` | int | 7 | 35 |
| `STATE_SUSPEND` | int | 6 | 36 |
| `STATE_SUSPEND_UNSUPPORTED` | int | 8 | 37 |
| `TAG` | String | "com.gku.actioncam.sigmastar.widget.SSVideoView" | 38 |
| `VIDEO_LAYOUT_ORIGIN` | int | 0 | 39 |
| `VIDEO_LAYOUT_SCALE` | int | 1 | 40 |
| `VIDEO_LAYOUT_STRETCH` | int | 2 | 41 |
| `VIDEO_LAYOUT_ZOOM` | int | 3 | 42 |

### `com.gku.actioncam.sigmastar.widget.StateView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SHORT_TIME` | int | 1500 | 19 |

### `com.gku.actioncam.sigmastar.widget.TabLayout.SegmentTabLayout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TEXT_BOLD_BOTH` | int | 2 | 28 |
| `TEXT_BOLD_NONE` | int | 0 | 29 |
| `TEXT_BOLD_WHEN_SELECT` | int | 1 | 30 |

### `com.gku.actioncam.sigmastar.wifi.beforeQ.WifiConnector`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "WifiConnector" | 21 |

### `com.gku.actioncam.widget.MediaController`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FADE_OUT` | int | 1 | 26 |
| `sDefaultTimeout` | int | 3000 | 29 |
| `SHOW_PROGRESS` | int | 2 | 27 |
| `TAG` | String | "MediaController" | 28 |

### `com.gku.actioncam.widget.SimpleCameraScan`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HOVER_TAP_SLOP` | int | 20 | 38 |
| `HOVER_TAP_TIMEOUT` | int | 150 | 39 |
| `ZOOM_STEP_SIZE` | float | 0.1f | 40 |

### `com.gku.actioncam.widget.VideoTextureView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `STATE_ERROR` | int | -1 | 23 |
| `STATE_IDLE` | int | 0 | 24 |
| `STATE_PAUSED` | int | 4 | 25 |
| `STATE_PLAYBACK_COMPLETED` | int | 5 | 26 |
| `STATE_PLAYING` | int | 3 | 27 |
| `STATE_PREPARED` | int | 2 | 28 |
| `STATE_PREPARING` | int | 1 | 29 |
| `STATE_RESUME` | int | 7 | 30 |
| `STATE_SUSPEND` | int | 6 | 31 |
| `STATE_SUSPEND_UNSUPPORTED` | int | 8 | 32 |
| `TAG` | String | "VideoTextureView" | 33 |
| `VIDEO_LAYOUT_ORIGIN` | int | 0 | 34 |
| `VIDEO_LAYOUT_SCALE` | int | 1 | 35 |
| `VIDEO_LAYOUT_STRETCH` | int | 2 | 36 |
| `VIDEO_LAYOUT_ZOOM` | int | 3 | 37 |

### `com.gku.actioncam.widget.VideoView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `STATE_ERROR` | int | -1 | 27 |
| `STATE_IDLE` | int | 0 | 28 |
| `STATE_PAUSED` | int | 4 | 29 |
| `STATE_PLAYBACK_COMPLETED` | int | 5 | 30 |
| `STATE_PLAYING` | int | 3 | 31 |
| `STATE_PREPARED` | int | 2 | 32 |
| `STATE_PREPARING` | int | 1 | 33 |
| `STATE_RESUME` | int | 7 | 34 |
| `STATE_SUSPEND` | int | 6 | 35 |
| `STATE_SUSPEND_UNSUPPORTED` | int | 8 | 36 |
| `TAG` | String | "com.gku.actioncam.widget.VideoView" | 37 |
| `VIDEO_LAYOUT_ORIGIN` | int | 0 | 38 |
| `VIDEO_LAYOUT_SCALE` | int | 1 | 39 |
| `VIDEO_LAYOUT_STRETCH` | int | 2 | 40 |
| `VIDEO_LAYOUT_ZOOM` | int | 3 | 41 |

### `com.gku.amba.AmbaCameraFileActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CALLBACK_CHOOSE_CLICK` | String | "CALLBACK_CHOOSE_CLICK" | 35 |

### `com.gku.amba.AmbaCameraPicFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CALLBACK_DELETE_ONE` | String | "CALLBACK_DELETE_ONE" | 37 |
| `CALLBACK_DOWNLOAD_ONE` | String | "CALLBACK_DOWNLOAD_ONE" | 38 |
| `CALLBACK_UPDATE_LIST_PIC_POSITION` | String | "CALLBACK_UPDATE_LIST_POSITION" | 39 |

### `com.gku.amba.AmbaPicPreviewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_INTENT` | String | "KEY_INTENT" | 24 |
| `KEY_LIST` | String | "KEY_LIST" | 25 |
| `KEY_POSITION` | String | "KEY_POSITION" | 26 |

### `com.gku.base.BaseFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `STATE_SAVE_IS_HIDDEN` | String | "STATE_SAVE_IS_HIDDEN" | 19 |

### `com.gku.base.BR`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `_all` | int | 0 | 6 |
| `activeTime` | int | 2 | 7 |
| `announcementLatestViewModel` | int | 3 | 8 |
| `content` | int | 4 | 9 |
| `createBy` | int | 5 | 10 |
| `createTime` | int | 6 | 11 |
| `email` | int | 7 | 12 |
| `forgetPwdViewModel` | int | 8 | 13 |
| `fragmentDeleteAccountViewModel` | int | 9 | 14 |
| `habits` | int | 10 | 15 |
| `iconUrl` | int | 11 | 16 |
| `id` | int | 12 | 17 |
| `lanCode` | int | 13 | 18 |
| `linkUrl` | int | 14 | 19 |
| `LoginFragmentViewModel` | int | 1 | 5 |
| `loginTimes` | int | 15 | 20 |
| `loginViewModel` | int | 16 | 21 |
| `mobile` | int | 17 | 22 |
| `modifyPwdViewModel` | int | 18 | 23 |
| `operationFail` | int | 19 | 24 |
| `operationSuccess` | int | 20 | 25 |
| `phoneNumberFragmentViewModel` | int | 21 | 26 |
| `productModel` | int | 22 | 27 |
| `register` | int | 24 | 29 |
| `registTime` | int | 23 | 28 |
| `remark` | int | 25 | 30 |
| `reportFeedbackViewModel` | int | 26 | 31 |
| `roomId` | int | 27 | 32 |
| `searchValue` | int | 28 | 33 |
| `title` | int | 29 | 34 |
| `uid` | int | 30 | 35 |
| `updateBy` | int | 31 | 36 |
| `updateTime` | int | 32 | 37 |
| `userCenterNewFragmentViewModel` | int | 33 | 38 |
| `userdata1` | int | 37 | 42 |
| `userdata2` | int | 38 | 43 |
| `userdata3` | int | 39 | 44 |
| `userInfoFragmentViewModel` | int | 34 | 39 |
| `userInfoViewModel` | int | 35 | 40 |
| `userPwd` | int | 36 | 41 |

### `com.gku.base.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "release" | 5 |
| `DEBUG` | boolean | false | 6 |
| `LIBRARY_PACKAGE_NAME` | String | "com.gku.base" | 7 |

### `com.gku.base.ConstantsBase`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SD_RECORD_TYPE_ALL` | int | 0 | 5 |
| `SD_RECORD_TYPE_COLLISION_LOCK` | int | 4 | 6 |
| `SD_RECORD_TYPE_CRASH_WAKE_UP` | int | 5 | 7 |
| `SD_RECORD_TYPE_MANUAL_LOCKING` | int | 3 | 8 |
| `SD_RECORD_TYPE_NORMAL` | int | 1 | 9 |
| `SD_RECORD_TYPE_PIR` | int | 2 | 10 |

### `com.gku.base.device.DeviceHttpUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CODE_JSON_PARSE_ERROR` | int | -200 | 9 |
| `CODE_NO_DATA` | int | -100 | 10 |
| `CODE_OK` | int | 0 | 11 |
| `HTTP` | String | "http://" | 12 |

### `com.gku.base.eventbus.MsgEventConstants`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_EDIT_COLOR` | String | "KEY_EDIT_COLOR" | 5 |
| `KEY_EDIT_COMPRESS` | String | "KEY_EDIT_COMPRESS" | 6 |
| `KEY_EDIT_CUT` | String | "KEY_EDIT_CUT" | 7 |
| `KEY_EDIT_FILTER` | String | "KEY_EDIT_FILTER" | 8 |
| `KEY_EDIT_ROTATE` | String | "key_edit_rotate" | 9 |

### `com.gku.base.okhttputils.HttpUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CODE_RESPONSE_ERROR_NO_NET` | int | -10001 | 18 |
| `CODE_RESPONSE_ERROR_OTHERS` | int | -10002 | 19 |
| `CODE_RESPONSE_ERROR_URL_ILLEGAL` | int | -10003 | 20 |
| `METHOD_DELETE` | String | "DELETE" | 21 |
| `METHOD_GET` | String | "GET" | 22 |
| `METHOD_HEAD` | String | "HEAD" | 23 |
| `METHOD_OPTIONS` | String | "OPTIONS" | 24 |
| `METHOD_POST` | String | "POST" | 25 |
| `METHOD_PUT` | String | "PUT" | 26 |
| `METHOD_TRACE` | String | "TRACE" | 27 |
| `TIME_OUT_DEFAULT` | int | 60000 | 28 |

### `com.gku.base.okhttputils.MultiDownloader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUFFER_SIZE` | int | 8192 | 31 |
| `RETRY_LIMIT` | int | 3 | 32 |
| `THREAD_COUNT` | int | 4 | 33 |

### `com.gku.base.permission.PermissionManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_MANAGE_WRITE_SETTINGS` | String | "ACTION_MANAGE_WRITE_SETTINGS" | 5 |
| `BUNDLE_KEY_PERMISSIONS` | String | "bundle_key_permissions" | 6 |
| `INTENT_KEY_ASK` | String | "intent_key_ask" | 7 |
| `INTENT_KEY_PERMISSIONS` | String | "intent_key_permissions" | 8 |
| `STORAGE_11` | String | "STORAGE_11" | 9 |

### `com.gku.base.permission.PermissionUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LOCATION_PERMISSIONS_BASIC` | String[] | {com.gku.loginmodule.utils.PermissionUtils.LOCATION, "android.permission.ACCESS_COARSE_LOCATION"} | 19 |

### `com.gku.base.SocketErrorCode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BROKEN_PIPE` | int | -10004 | 11 |
| `CONNECTION_ABORT` | int | -10007 | 12 |
| `CONNECTION_REFUSED` | int | -10008 | 13 |
| `CONNECTION_RESET` | int | -10003 | 14 |
| `EOF` | int | -10005 | 15 |
| `FAILED_TO_CONNECT` | int | -10009 | 16 |
| `IO_ERROR` | int | -10006 | 17 |
| `SOCKET_CLOSED` | int | -10002 | 18 |
| `SOCKET_EXCEPTION` | int | -100011 | 19 |
| `TIMEOUT` | int | -10001 | 20 |
| `UNKNOWN` | int | -100099 | 21 |
| `UNREACHABLE` | int | -100010 | 22 |

### `com.gku.base.utils.AESUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AES_MODE` | String | "AES/CBC/PKCS5Padding" | 9 |
| `CHARSET` | String | "UTF-8" | 10 |

### `com.gku.base.utils.AlbumUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CODE_COPY_FILE_2_DCIM_DEVICE_NOT_FOUND` | int | -6 | 26 |
| `CODE_COPY_FILE_2_DCIM_FILE_NOT_FOUND` | int | -4 | 27 |
| `CODE_COPY_FILE_2_DCIM_INVALID_ARGUMENT` | int | -7 | 28 |
| `CODE_COPY_FILE_2_DCIM_IO` | int | -2 | 29 |
| `CODE_COPY_FILE_2_DCIM_NO_PERMISSION` | int | -8 | 30 |
| `CODE_COPY_FILE_2_DCIM_NO_SPACE` | int | -1 | 31 |
| `CODE_COPY_FILE_2_DCIM_READ_ONLY` | int | -5 | 32 |
| `CODE_COPY_FILE_2_DCIM_SECURITY` | int | -3 | 33 |
| `CODE_COPY_FILE_2_DCIM_SUCCESS` | int | 0 | 34 |
| `CODE_COPY_FILE_2_DCIM_UNKNOWN` | int | -20 | 35 |
| `COPY_BUFFER_SIZE` | int | 65536 | 36 |

### `com.gku.base.utils.FileUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_TYPE_7Z` | String | "7z" | 20 |
| `FILE_TYPE_APK` | String | "apk" | 21 |
| `FILE_TYPE_CSV` | String | "csv" | 22 |
| `FILE_TYPE_DOC` | String | "doc" | 23 |
| `FILE_TYPE_DOCX` | String | "docx" | 24 |
| `FILE_TYPE_DOT` | String | "dot" | 25 |
| `FILE_TYPE_LOG` | String | "log" | 26 |
| `FILE_TYPE_LRC` | String | "lrc" | 27 |
| `FILE_TYPE_PDF` | String | "pdf" | 28 |
| `FILE_TYPE_PPT` | String | "ppt" | 29 |
| `FILE_TYPE_PPTX` | String | "pptx" | 30 |
| `FILE_TYPE_RAR` | String | "rar" | 31 |
| `FILE_TYPE_RTF` | String | "rtf" | 32 |
| `FILE_TYPE_TORRENT` | String | "torrent" | 33 |
| `FILE_TYPE_TXT` | String | "txt" | 34 |
| `FILE_TYPE_WPL` | String | "wpl" | 35 |
| `FILE_TYPE_WPS` | String | "wps" | 36 |
| `FILE_TYPE_XLS` | String | "xls" | 37 |
| `FILE_TYPE_XLSB` | String | "xlsb" | 38 |
| `FILE_TYPE_XLSM` | String | "xlsm" | 39 |
| `FILE_TYPE_XLSX` | String | "xlsx" | 40 |
| `FILE_TYPE_XLTX` | String | "xltx" | 41 |
| `FILE_TYPE_XML` | String | "xml" | 42 |
| `FILE_TYPE_XPS` | String | "xps" | 43 |
| `FILE_TYPE_ZIP` | String | "zip" | 44 |

### `com.gku.base.utils.LanguageUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FOLLOW_SYSTEM` | String | "FOLLOW_SYSTEM" | 17 |
| `KEY_LANGUAGE` | String | "KEY_LANGUAGE" | 18 |

### `com.gku.base.utils.LogSaveUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DAYS_OVER` | long | 7 | 19 |
| `FLUSH_INTERVAL_MS` | long | 3000 | 20 |
| `KEY_DATE` | String | "d-e-3-gf-43-g" | 21 |
| `LOG_INTERVAL` | long | 5 | 22 |

### `com.gku.base.utils.LogSwitchUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_LOG_SWITCH` | String | "KEY_LOG_SWITCH" | 9 |

### `com.gku.base.utils.MyMathUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `COMPARE_EQUAL` | short | 100 | 10 |
| `COMPARE_LESS` | short | 102 | 11 |
| `COMPARE_MORE` | short | 101 | 12 |

### `com.gku.base.utils.NetWorkInfoUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `NET_TYPE_MOBILE` | String | "NET_TYPE_MOBILE" | 26 |
| `NET_TYPE_NO` | String | "NET_TYPE_NO" | 27 |
| `NET_TYPE_WIFI` | String | "NET_TYPE_WIFI" | 28 |

### `com.gku.base.utils.OrientationUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ORIENTATION_0` | int | 0 | 14 |
| `ORIENTATION_180` | int | 180 | 15 |
| `ORIENTATION_270` | int | 270 | 16 |
| `ORIENTATION_90` | int | 90 | 17 |

### `com.gku.base.utils.ScreenUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `NOTCH_IN_SCREEN_VOIO` | int | 32 | 15 |
| `ROUNDED_IN_SCREEN_VOIO` | int | 8 | 16 |

### `com.gku.base.utils.StringUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `URL_REGEX` | String | "^(http\\|https)://[a-zA-Z0-9\\-]+(\\.[a-zA-Z0-9\\-]+)+(/\\S*)?$" | 13 |

### `com.gku.base.utils.UUIDUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `UUID_` | String | "uuid" | 7 |

### `com.gku.base.utils.WallpagerUtils$OnWallpagerCallback`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FLAG_DESKTOP` | int | 1 | 15 |
| `FLAG_LOCK` | int | 0 | 16 |

### `com.gku.base.view.calendarview.CustomMonthView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_VIDEO_EMERGENCY` | int | 1001 | 14 |
| `TYPE_VIDEO_NORMAL` | int | 1000 | 15 |

### `com.gku.base.view.HideShowFrameLayout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AUTO_HIDE_DELAY` | long | 5000 | 14 |

### `com.gku.base.view.ShimmerFrameLayout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_ANGLE` | byte | 20 | 24 |
| `DEFAULT_ANIMATION_DURATION` | int | 1500 | 25 |
| `MAX_ANGLE_VALUE` | byte | 45 | 26 |
| `MAX_GRADIENT_CENTER_COLOR_WIDTH_VALUE` | byte | 1 | 27 |
| `MAX_MASK_WIDTH_VALUE` | byte | 1 | 28 |
| `MIN_ANGLE_VALUE` | byte | -45 | 29 |
| `MIN_GRADIENT_CENTER_COLOR_WIDTH_VALUE` | byte | 0 | 30 |
| `MIN_MASK_WIDTH_VALUE` | byte | 0 | 31 |

### `com.gku.base.view.ShimmerLayoutSimple`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MODE_LOAD` | int | 0 | 30 |
| `MODE_LOADMORE` | int | 2 | 31 |
| `MODE_REFRESH` | int | 1 | 32 |

### `com.gku.base.webview.WebViewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INTENT_WEBVIEW_URL` | String | "INTENT_WEBVIEW_URL" | 24 |
| `KYE_TITLE` | String | "KYE_TITLE" | 25 |

### `com.gku.base.webview.WebViewUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "IntentUtils" | 26 |

### `com.gku.BaseApplication`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ActionCamApp" | 29 |

### `com.gku.codeest.enviews.ENDownloadView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_BG_LINE_COLOR` | int | -12959931 | 21 |
| `DEFAULT_BG_LINE_WIDTH` | int | 9 | 22 |
| `DEFAULT_DOWNLOAD_TIME` | int | 2000 | 23 |
| `DEFAULT_DOWNLOAD_UNIT` | DownloadUnit | DownloadUnit.B | 24 |
| `DEFAULT_LINE_COLOR` | int | -1 | 25 |
| `DEFAULT_LINE_WIDTH` | int | 9 | 26 |
| `DEFAULT_RIPPLE_SPEED` | int | 2 | 27 |
| `DEFAULT_STATE` | int | 0 | 28 |
| `DEFAULT_TEXT_COLOR` | int | -1 | 29 |
| `DEFAULT_TEXT_SIZE` | int | 14 | 30 |
| `STATE_DOWNLOADING` | int | 1 | 31 |
| `STATE_END` | int | 2 | 32 |
| `STATE_PRE` | int | 0 | 33 |
| `STATE_RESET` | int | 3 | 34 |

### `com.gku.dashcam.icatch.appinfo.AppInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APP_LOG_DIRECTORY_PATH` | String | "/ActionCam/ActionCam_APP_Log/" | 11 |
| `APP_PATH` | String | "/ActionCam/" | 12 |
| `APP_VERSION` | String | "V1.2.0_beta34" | 13 |
| `AUTO_DOWNLOAD_PATH` | String | "/DCIM/ActionCam/photo/" | 14 |
| `DOWNLOAD_PATH` | String | "/DCIM/ActionCam/" | 15 |
| `DOWNLOAD_PATH_PHOTO` | String | "/DCIM/ActionCam/photo/" | 16 |
| `DOWNLOAD_PATH_VIDEO` | String | "/DCIM/ActionCam/video/" | 17 |
| `EULA_VERSION` | String | "1.3" | 18 |
| `FILE_GOOGLE_TOKEN` | String | "file_googleToken.dat" | 19 |
| `FW_UPGRADE_FILENAME` | String | "sphost.BRN" | 20 |
| `PROPERTY_CFG_DIRECTORY_PATH` | String | "/ActionCam/Resoure/" | 21 |
| `PROPERTY_CFG_FILE_NAME` | String | "netconfig.properties" | 22 |
| `SDK_LOG_DIRECTORY_PATH` | String | "/ActionCam/ActionCam_SDK_Log/" | 23 |
| `SDK_VERSION` | String | "V3.6.0.35" | 24 |
| `STREAM_OUTPUT_DIRECTORY_PATH` | String | "/ActionCam/Resoure/Raw/" | 25 |
| `TAG` | String | "AppInfo" | 26 |

### `com.gku.dashcam.icatch.appinfo.ExitApp`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ExitApp" | 12 |

### `com.gku.dashcam.icatch.appinfo.GlobalInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "GlobalInfo" | 17 |

### `com.gku.dashcam.icatch.appinfo.SystemInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SystemInfo" | 15 |

### `com.gku.dashcam.icatch.CameraSlotSQLiteHelper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DATABASE_NAME` | String | "cameraSlotDb112.db" | 9 |
| `DATABASE_TABLE` | String | "cameraSlotInfo" | 10 |
| `DATABASE_VERSION` | int | 1 | 11 |

### `com.gku.dashcam.icatch.CommandSession`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `tag` | String | "CommandSession" | 14 |
| `TAG` | String | "CommandSession" | 12 |

### `com.gku.dashcam.icatch.data.IcatchClientThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ClientThread" | 19 |

### `com.gku.dashcam.icatch.data.IcatchConnectDevice`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "IcatchConnectDevice" | 20 |

### `com.gku.dashcam.icatch.entity.MultiPbItemInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MultiPbItemInfo" | 23 |

### `com.gku.dashcam.icatch.entity.PropertyTypeInteger`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PropertyTypeInteger" | 18 |

### `com.gku.dashcam.icatch.LocalSession`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LocalSession" | 13 |

### `com.gku.dashcam.icatch.message.AppMessage`

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
| `FUNCTION_MESSAGE` | int | 4096 | 17 |
| `GOOGLE_LOGIN_SUCCEED` | int | 6 | 18 |
| `LAUNCH_ACTIVITY` | int | 0 | 19 |
| `LOCAL_ACTIVITY` | int | 256 | 20 |
| `LOCAL_VIDEO_PBACTIVITY` | int | 1536 | 21 |
| `MESSAGE_CAMERA_CONNECT_FAIL` | int | 3 | 23 |
| `MESSAGE_CAMERA_CONNECT_SUCCESS` | int | 4 | 24 |
| `MESSAGE_CAMERA_CONNECTING_START` | int | 5 | 22 |
| `MESSAGE_CAMERA_SCAN_TIME_OUT` | int | 2 | 25 |
| `MESSAGE_CANCEL_DOWNLOAD_SINGLE` | int | 769 | 26 |
| `MESSAGE_CANCEL_VIDEO_DOWNLOAD` | int | 1541 | 27 |
| `MESSAGE_CONNECTED` | int | 4100 | 28 |
| `MESSAGE_DELETE_CAMERA` | int | 1 | 29 |
| `MESSAGE_DISCONNECTED` | int | 4099 | 30 |
| `MESSAGE_LIVE_NETWORK_DISCONNECT` | int | 514 | 31 |
| `MESSAGE_UPDATE_VIDEOPB_BAR` | int | 1540 | 32 |
| `MESSAGE_VIDEO_STREAM_CODEC_INFO` | int | 1543 | 33 |
| `MESSAGE_VIDEO_STREAM_NO_EIS_INFORMATION` | int | 1542 | 34 |
| `MPB_ACTIVITY` | int | 768 | 35 |
| `OPEN_WIFI_HOTSPOT_FAILED` | int | 4102 | 36 |
| `PHOTO_PBACTIVITY` | int | 1024 | 37 |
| `PREVIEW_ACTIVITY` | int | 512 | 38 |
| `SETTING_OPTION_AUTO_DOWNLOAD` | int | 513 | 39 |
| `UPDATE_LOADING_PROGRESS` | int | 770 | 40 |
| `UPDATE_TOTAL_PROGRESS` | int | 773 | 41 |
| `VIDEO_PBACTIVITY` | int | 1280 | 42 |

### `com.gku.dashcam.icatch.mode.CameraNetworkMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AP` | int | 1 | 7 |
| `ETHERNET` | int | 2 | 8 |
| `STATION` | int | 0 | 9 |

### `com.gku.dashcam.icatch.mode.PreviewLaunchMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RT_PREVIEW_MODE` | int | 2 | 5 |
| `VIDEO_PB_MODE` | int | 1 | 6 |

### `com.gku.dashcam.icatch.mode.PreviewMode`

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

### `com.gku.dashcam.icatch.PanoramaSession`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaSession" | 15 |

### `com.gku.dashcam.icatch.PhotoCapture`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhotoCapture" | 11 |
| `TYPE_BURST_CAPTURE` | int | 1 | 12 |
| `TYPE_NORMAL_CAPTURE` | int | 2 | 13 |

### `com.gku.dashcam.icatch.presenter.PhotoPbPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DIRECTION_LEFT` | int | 2 | 56 |
| `DIRECTION_RIGHT` | int | 1 | 57 |
| `DIRECTION_UNKNOWN` | int | 4 | 58 |
| `FIXED_INSIDE_DISTANCE` | float | 0.45454544f | 59 |
| `FIXED_INSIDE_FOCUS` | float | 2.0f | 60 |
| `FIXED_NEAR_DISTANCE` | float | 0.6f | 61 |
| `FIXED_OUTSIDE_DISTANCE` | float | 2.0f | 62 |
| `FIXED_OUTSIDE_FOCUS` | float | 1.0f | 63 |
| `MAX_ZOOM` | float | 2.2f | 64 |
| `MIN_ZOOM` | float | 0.5f | 65 |

### `com.gku.dashcam.icatch.presenter.PreviewPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FIXED_INSIDE_DISTANCE` | float | 0.5f | 80 |
| `FIXED_OUTSIDE_DISTANCE` | float | 3.0f | 81 |
| `MAX_ZOOM` | float | 2.2f | 82 |
| `MIN_ZOOM` | float | 0.4f | 83 |
| `TAG` | String | "PreviewPresenter" | 84 |

### `com.gku.dashcam.icatch.presenter.RemoteMultiPbPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RemoteMultiPbPresenter" | 35 |

### `com.gku.dashcam.icatch.presenter.VideoPbPresenter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FIXED_INSIDE_DISTANCE` | float | 0.45454544f | 65 |
| `FIXED_OUTSIDE_DISTANCE` | float | 2.0f | 66 |
| `MAX_ZOOM` | float | 2.2f | 67 |
| `MIN_ZOOM` | float | 0.5f | 68 |

### `com.gku.dashcam.icatch.PropertyId`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AP_MODE_TO_STA_MODE` | int | 55291 | 5 |
| `AUTO_POWER_OFF` | int | 55073 | 6 |
| `BURST_NUMBER` | int | 20504 | 7 |
| `CAMERA_CONNECT_CHANGE` | int | 55201 | 8 |
| `CAMERA_DATE` | int | 20497 | 9 |
| `CAMERA_DATE_TIMEZONE` | int | 55358 | 10 |
| `CAMERA_ESSID` | int | 55356 | 11 |
| `CAMERA_NAME` | int | 55345 | 12 |
| `CAMERA_PASSWORD` | int | 55357 | 13 |
| `CAMERA_PASSWORD_NEW` | int | 55346 | 14 |
| `CAMERA_PB_LIMIT_NUMBER` | int | 55359 | 15 |
| `CAMERA_SWITCH` | int | 55091 | 16 |
| `CAPTURE_DELAY` | int | 20498 | 17 |
| `CAPTURE_DELAY_MODE` | int | 55280 | 18 |
| `CAPTURE_IN_VIDEO_RECORD` | int | 55082 | 19 |
| `DATE_STAMP` | int | 54791 | 20 |
| `DEFALUT_TO_PREVIEW` | int | 55084 | 21 |
| `DEL_FILE` | int | 55299 | 22 |
| `ESSID_NAME` | int | 55348 | 23 |
| `ESSID_PASSWORD` | int | 55349 | 24 |
| `EXPOSURE_COMPENSATION` | int | 55075 | 25 |
| `FAST_MOTION_MOVIE` | int | 55078 | 26 |
| `IMAGE_SIZE` | int | 20483 | 27 |
| `IMAGE_STABILIZATION` | int | 55076 | 28 |
| `LIGHT_FREQUENCY` | int | 54790 | 29 |
| `MULTIPLE_CAMERA_SENSOR` | int | 55081 | 30 |
| `NOTIFY_FW_TO_SHARE_MODE` | int | 55291 | 31 |
| `POWER_ON_AUTO_RECORD` | int | 55074 | 32 |
| `SCREEN_SAVER` | int | 55072 | 33 |
| `SERVICE_ESSID` | int | 55350 | 34 |
| `SERVICE_PASSWORD` | int | 55351 | 35 |
| `SLOW_MOTION` | int | 54805 | 36 |
| `STA_MODE_PASSWORD` | int | 55349 | 37 |
| `STA_MODE_SSID` | int | 55348 | 38 |
| `SUPPORT_PREVIEW` | int | 55295 | 39 |
| `TIMELAPSE_MODE` | int | 60928 | 40 |
| `TIMELAPSE_VIDEO_SIZE_LIST_MASK` | int | 55291 | 41 |
| `UP_SIDE` | int | 54804 | 42 |
| `USB_PIMA_DCP_Custom_AudioRec` | int | 55217 | 44 |
| `USB_PIMA_DCP_Custom_BeepSound` | int | 55222 | 45 |
| `USB_PIMA_DCP_Custom_BooTSound` | int | 55223 | 46 |
| `USB_PIMA_DCP_Custom_GKU_PDT_STRING` | int | 55298 | 47 |
| `USB_PIMA_DCP_Custom_GKU_PDT_STRING_new` | int | 55296 | 48 |
| `USB_PIMA_DCP_Custom_Gsensor` | int | 55218 | 49 |
| `USB_PIMA_DCP_Custom_Language` | int | 55221 | 50 |
| `USB_PIMA_DCP_Custom_MotionDetect` | int | 55216 | 51 |
| `USB_PIMA_DCP_CUSTOM_PV_DISP_TYPE` | int | 55232 | 43 |
| `USB_PIMA_DCP_Custom_RESET_FACTORY` | int | 55224 | 52 |
| `USB_PIMA_DCP_Custom_SPEEDUNIT` | int | 55225 | 53 |
| `VIDEO_FILE_LENGTH` | int | 55077 | 54 |
| `VIDEO_RECORDING_TIME` | int | 55293 | 55 |
| `VIDEO_SIZE` | int | 54789 | 56 |
| `VIDEO_SIZE_FLOW` | int | 55292 | 57 |
| `WHITE_BALANCE` | int | 20485 | 58 |
| `WIND_NOISE_REDUCTION` | int | 55079 | 59 |

### `com.gku.dashcam.icatch.sdkapi.CameraAction`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "CameraAction" | 22 |

### `com.gku.dashcam.icatch.sdkapi.PanoramaPhotoPlayback`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaPhotoPlayback" | 23 |

### `com.gku.dashcam.icatch.sdkapi.PanoramaPreviewPlayback`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaPreviewPlayback" | 41 |

### `com.gku.dashcam.icatch.sdkapi.PanoramaVideoPlayback`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaVideoPlayback" | 29 |

### `com.gku.dashcam.icatch.sdkapi.SDKEvent`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EVENT_BATTERY_ELETRIC_CHANGED` | int | 0 | 15 |
| `EVENT_CAPTURE_COMPLETED` | int | 1 | 16 |
| `EVENT_CAPTURE_START` | int | 3 | 17 |
| `EVENT_CONNECTION_FAILURE` | int | 8 | 18 |
| `EVENT_FILE_ADDED` | int | 7 | 19 |
| `EVENT_FILE_DOWNLOAD` | int | 11 | 20 |
| `EVENT_FW_UPDATE_CHECK` | int | 25 | 21 |
| `EVENT_FW_UPDATE_CHKSUMERR` | int | 26 | 22 |
| `EVENT_FW_UPDATE_COMPLETED` | int | 13 | 23 |
| `EVENT_FW_UPDATE_NG` | int | 27 | 24 |
| `EVENT_FW_UPDATE_POWEROFF` | int | 14 | 25 |
| `EVENT_RCONNECT_SUCC` | int | 28 | 26 |
| `EVENT_SD_CARD_FULL` | int | 4 | 29 |
| `EVENT_SDCARD_INSERT` | int | 17 | 27 |
| `EVENT_SDCARD_REMOVED` | int | 16 | 28 |
| `EVENT_SEARCHED_NEW_CAMERA` | int | 15 | 30 |
| `EVENT_SERVER_STREAM_ERROR` | int | 10 | 31 |
| `EVENT_TIME_LAPSE_STOP` | int | 9 | 32 |
| `EVENT_VIDEO_OFF` | int | 5 | 33 |
| `EVENT_VIDEO_ON` | int | 6 | 34 |
| `EVENT_VIDEO_PLAY_CLOSED` | int | 24 | 35 |
| `EVENT_VIDEO_PLAY_PTS` | int | 23 | 36 |
| `EVENT_VIDEO_RECORDING_TIME` | int | 12 | 37 |
| `TAG` | String | "SDKEvent" | 38 |

### `com.gku.dashcam.icatch.streaming.H264DecoderThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "H264DecoderThread" | 21 |

### `com.gku.dashcam.icatch.streaming.MjpgDecoderThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MjpgDecoderThread" | 20 |

### `com.gku.dashcam.icatch.type.CameraSwitch`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CAMERA_BACK` | int | 1 | 5 |
| `CAMERA_FRONT` | int | 0 | 6 |

### `com.gku.dashcam.icatch.type.TimeLapseDuration`

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

### `com.gku.dashcam.icatch.type.TimeLapseInterval`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TIME_LAPSE_INTERVAL_OFF` | int | 0 | 10 |

### `com.gku.dashcam.icatch.type.TimeLapseMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TIME_LAPSE_MODE_STILL` | int | 0 | 5 |
| `TIME_LAPSE_MODE_VIDEO` | int | 1 | 6 |

### `com.gku.dashcam.icatch.type.Upside`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `UPSIDE_OFF` | int | 0 | 5 |
| `UPSIDE_ON` | int | 1 | 6 |

### `com.gku.dashcam.icatch.ui.activity.PhotoPbActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhotoPbActivity" | 24 |

### `com.gku.dashcam.icatch.ui.activity.PreviewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PreviewActivity" | 47 |

### `com.gku.dashcam.icatch.ui.adapter.MultiPbRecyclerViewAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_GRID` | int | 1 | 28 |
| `TYPE_LIST` | int | 2 | 29 |
| `TYPE_QUICK_LIST` | int | 3 | 30 |

### `com.gku.dashcam.icatch.ui.adapter.PhotoPbViewPagerAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhotoPbViewPagerAdapter" | 19 |

### `com.gku.dashcam.icatch.ui.adapter.SettingListAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SettingListAdapter" | 24 |

### `com.gku.dashcam.icatch.ui.customview.ZoomView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DISPLAY_DURATION` | int | 5000 | 20 |
| `TAG` | String | "ZoomView" | 23 |

### `com.gku.dashcam.icatch.ui.fragment.DialogFragmentFromBottom`

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

### `com.gku.dashcam.icatch.ui.fragment.RemoteMultiPbFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RemoteMultiPbFragment" | 33 |

### `com.gku.dashcam.icatch.ui.setting.OptionSetting`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "OptionSetting" | 48 |

### `com.gku.dashcam.icatch.ui.setting.UIDisplaySource`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CAPTURE_SETTING_MENU` | int | 1 | 21 |
| `TIMELAPSE_SETTING_MENU` | int | 3 | 22 |
| `VIDEO_SETTING_MENU` | int | 2 | 23 |

### `com.gku.dashcam.icatch.usb.DeviceFilter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DeviceFilter" | 19 |

### `com.gku.dashcam.icatch.usb.USBHost_Feature`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_USB_PERMISSION_BASE` | String | "com.example.USB_PERMISSION." | 22 |
| `HANDLER_USB_DEVICE_ATTACHED_ID` | int | 1 | 23 |
| `HANDLER_USB_DEVICE_ATTACHED_KEY` | String | "HANDLER_USB_DEVICE_ATTACHED" | 24 |
| `HANDLER_USB_DEVICE_DETACHED_ID` | int | 2 | 25 |
| `HANDLER_USB_DEVICE_DETACHED_KEY` | String | "HANDLER_USB_DEVICE_DETACHED" | 26 |
| `USB_PRODUCT_ID` | int | 25427 | 27 |
| `USB_UAC_FREQUENCY` | int | 48000 | 28 |
| `USB_UAC_NCHANNELS` | int | 2 | 29 |
| `USB_UAC_SAMPLEBIT` | int | 16 | 30 |
| `USB_VENDOR_ID` | int | 10925 | 31 |

### `com.gku.dashcam.icatch.usb.USBMonitor`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_USB_PERMISSION_BASE` | String | "com.serenegiant.USB_PERMISSION." | 27 |
| `DEBUG` | boolean | true | 28 |
| `TAG` | String | "USBMonitor" | 29 |

### `com.gku.dashcam.icatch.utils.AppDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `tag` | String | "AppDialog" | 16 |

### `com.gku.dashcam.icatch.utils.BitmapTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LIMITED_IMGAE_SIZE` | long | 10485760 | 11 |
| `THUMBNAIL_HEIGHT` | int | 100 | 13 |
| `THUMBNAIL_WIDTH` | int | 100 | 14 |

### `com.gku.dashcam.icatch.utils.ClickUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MIN_CLICK_DELAY_TIME` | long | 500 | 7 |

### `com.gku.dashcam.icatch.utils.DisplayHelper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "Devices" | 20 |

### `com.gku.dashcam.icatch.utils.fileutils.FileFilter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `formatType` | String | "yyyy-MM-dd HH:mm:ss" | 20 |
| `TIME_TYPE_ALL_TIME` | int | 6 | 13 |
| `TIME_TYPE_ALMOST_A_MONTH` | int | 3 | 14 |
| `TIME_TYPE_ALMOST_A_WEEK` | int | 2 | 15 |
| `TIME_TYPE_CUSTOMIZE` | int | 5 | 16 |
| `TIME_TYPE_LAST_HALF_YEAR` | int | 4 | 17 |
| `TIME_TYPE_LAST_THREE_DAY` | int | 1 | 18 |
| `TIME_TYPE_TODAY` | int | 0 | 19 |

### `com.gku.dashcam.icatch.utils.fileutils.FileTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILENAME_SEQUENCE_SEPARATOR` | String | "-" | 32 |
| `TAG` | String | "FileTools" | 33 |

### `com.gku.dashcam.icatch.utils.fileutils.MFileTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MFileTools" | 11 |

### `com.gku.dashcam.icatch.utils.imageloader.ICatchtekImageDownloader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HTTP_SOCKET_TIMEOUT_MS` | int | 10000 | 19 |

### `com.gku.dashcam.icatch.utils.imageloader.ImageLoaderConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ImageLoaderConfig" | 18 |

### `com.gku.dashcam.icatch.utils.imageloader.Md5FileNameGeneratorMatchFaceName`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HASH_ALGORITHM` | String | "MD5" | 11 |
| `RADIX` | int | 36 | 12 |
| `TAG` | String | "Md5FileNameGeneratorMat" | 13 |

### `com.gku.dashcam.icatch.utils.imageloader.TutkUriUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `URI_PREFIX` | String | "tutk://" | 9 |

### `com.gku.dashcam.icatch.utils.MediaRefresh`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_MEDIA_SCANNER_SCAN_DIR` | String | "android.intent.action.MEDIA_SCANNER_SCAN_DIR" | 22 |
| `TAG` | String | "MediaRefresh" | 23 |

### `com.gku.dashcam.icatch.utils.NumberProgressBar`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INSTANCE_MAX` | String | "max" | 20 |
| `INSTANCE_PREFIX` | String | "prefix" | 21 |
| `INSTANCE_PROGRESS` | String | "progress" | 22 |
| `INSTANCE_REACHED_BAR_COLOR` | String | "reached_bar_color" | 23 |
| `INSTANCE_REACHED_BAR_HEIGHT` | String | "reached_bar_height" | 24 |
| `INSTANCE_STATE` | String | "saved_instance" | 25 |
| `INSTANCE_SUFFIX` | String | "suffix" | 26 |
| `INSTANCE_TEXT_COLOR` | String | "text_color" | 27 |
| `INSTANCE_TEXT_SIZE` | String | "text_size" | 28 |
| `INSTANCE_TEXT_VISIBILITY` | String | "text_visibility" | 29 |
| `INSTANCE_UNREACHED_BAR_COLOR` | String | "unreached_bar_color" | 30 |
| `INSTANCE_UNREACHED_BAR_HEIGHT` | String | "unreached_bar_height" | 31 |
| `PROGRESS_TEXT_VISIBLE` | int | 0 | 32 |

### `com.gku.dashcam.icatch.utils.PanoramaTools`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaTools" | 10 |

### `com.gku.dashcam.icatch.utils.WifiAPUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONNECTIVITY_CHANGE_ACTION` | String | "android.net.conn.CONNECTIVITY_CHANGE" | 18 |
| `DEBUG` | boolean | true | 19 |
| `DEFAULT_AP_PASSWORD` | String | "12345678" | 20 |
| `EXTRA_WIFI_AP_STATE` | String | "wifi_state" | 21 |
| `MESSAGE_AP_STATE_ENABLED` | int | 1 | 22 |
| `MESSAGE_AP_STATE_FAILED` | int | 2 | 23 |
| `TAG` | String | "WifiAPUtil" | 24 |
| `WIFI_AP_STATE_CHANGED_ACTION` | String | "android.net.wifi.WIFI_AP_STATE_CHANGED" | 25 |

### `com.gku.dashcam.icatch.utils.WifiCheck`

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

### `com.gku.ffm.zqvideo.GSYVideoBaseManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUFFER_TIME_OUT_ERROR` | int | -192 | 29 |
| `HANDLER_PREPARE` | int | 0 | 30 |
| `HANDLER_RELEASE` | int | 2 | 31 |
| `HANDLER_RELEASE_SURFACE` | int | 3 | 32 |
| `HANDLER_SETDISPLAY` | int | 1 | 33 |

### `com.gku.ffm.zqvideo.model.VideoOptionModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `VALUE_TYPE_INT` | int | 0 | 5 |
| `VALUE_TYPE_STRING` | int | 1 | 6 |

### `com.gku.ffm.zqvideo.render.effect.GaussianBlurEffect`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPEX` | int | 1 | 8 |
| `TYPEXY` | int | 3 | 9 |
| `TYPEY` | int | 2 | 10 |

### `com.gku.ffm.zqvideo.render.glrender.GSYVideoGLViewSimpleRender`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FLOAT_SIZE_BYTES` | int | 4 | 19 |
| `GL_TEXTURE_EXTERNAL_OES` | int | 36197 | 20 |
| `TRIANGLE_VERTICES_DATA_POS_OFFSET` | int | 0 | 21 |
| `TRIANGLE_VERTICES_DATA_STRIDE_BYTES` | int | 20 | 22 |
| `TRIANGLE_VERTICES_DATA_UV_OFFSET` | int | 3 | 23 |

### `com.gku.ffm.zqvideo.render.view.GSYVideoGLView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MODE_LAYOUT_SIZE` | int | 0 | 27 |
| `MODE_RENDER_SIZE` | int | 1 | 28 |
| `TAG` | String | "com.gku.ffm.zqvideo.render.view.GSYVideoGLView" | 29 |

### `com.gku.ffm.zqvideo.utils.Debuger`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LOG_TAG` | String | "GSYVideoPlayer" | 11 |

### `com.gku.ffm.zqvideo.utils.FileUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `NAME` | String | "GSYVideo" | 11 |
| `NAME_TEST` | String | "GSYVideoTest" | 12 |

### `com.gku.ffm.zqvideo.utils.GSYVideoType`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `GLSURFACE` | int | 2 | 5 |
| `SCREEN_MATCH_FULL` | int | -4 | 7 |
| `SCREEN_TYPE_16_9` | int | 1 | 8 |
| `SCREEN_TYPE_18_9` | int | 6 | 9 |
| `SCREEN_TYPE_4_3` | int | 2 | 10 |
| `SCREEN_TYPE_CUSTOM` | int | -5 | 11 |
| `SCREEN_TYPE_DEFAULT` | int | 0 | 12 |
| `SCREEN_TYPE_FULL` | int | 4 | 13 |
| `SUFRACE` | int | 1 | 14 |
| `TEXTURE` | int | 0 | 15 |

### `com.gku.ffm.zqvideo.utils.LZWEncoder`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BITS` | int | 12 | 11 |
| `EOF` | int | -1 | 12 |
| `HSIZE` | int | 5003 | 13 |

### `com.gku.ffm.zqvideo.utils.NetInfoModule`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONNECTION_TYPE_NONE` | String | "NONE" | 14 |
| `CONNECTION_TYPE_UNKNOWN` | String | "UNKNOWN" | 15 |
| `ERROR_MISSING_PERMISSION` | String | "E_MISSING_PERMISSION" | 16 |
| `MISSING_PERMISSION_MESSAGE` | String | "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />" | 17 |

### `com.gku.ffm.zqvideo.utils.NetworkUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `NETWORK_2G` | int | 2 | 11 |
| `NETWORK_3G` | int | 3 | 12 |
| `NETWORK_4G` | int | 4 | 13 |
| `NETWORK_NO` | int | -1 | 14 |
| `NETWORK_TYPE_GSM` | int | 16 | 15 |
| `NETWORK_TYPE_IWLAN` | int | 18 | 16 |
| `NETWORK_TYPE_TD_SCDMA` | int | 17 | 17 |
| `NETWORK_UNKNOWN` | int | 5 | 18 |
| `NETWORK_WIFI` | int | 1 | 19 |

### `com.gku.ffm.zqvideo.utils.NeuQuant`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `alphabiasshift` | int | 10 | 6 |
| `alpharadbias` | int | 262144 | 7 |
| `alpharadbshift` | int | 18 | 8 |
| `beta` | int | 64 | 9 |
| `betagamma` | int | 65536 | 10 |
| `betashift` | int | 10 | 11 |
| `gamma` | int | 1024 | 12 |
| `gammashift` | int | 10 | 13 |
| `initalpha` | int | 1024 | 14 |
| `initrad` | int | 32 | 15 |
| `initradius` | int | 2048 | 16 |
| `intbias` | int | 65536 | 17 |
| `intbiasshift` | int | 16 | 18 |
| `maxnetpos` | int | 255 | 19 |
| `minpicturebytes` | int | 1509 | 20 |
| `ncycles` | int | 100 | 21 |
| `netbiasshift` | int | 4 | 22 |
| `netsize` | int | 256 | 23 |
| `prime1` | int | 499 | 24 |
| `prime2` | int | 491 | 25 |
| `prime3` | int | 487 | 26 |
| `prime4` | int | 503 | 27 |
| `radbias` | int | 256 | 28 |
| `radbiasshift` | int | 8 | 29 |
| `radiusbias` | int | 64 | 30 |
| `radiusbiasshift` | int | 6 | 31 |
| `radiusdec` | int | 30 | 32 |

### `com.gku.ffm.zqvideo.utils.OrientationUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LAND_TYPE_NORMAL` | int | 1 | 13 |
| `LAND_TYPE_NULL` | int | 0 | 14 |
| `LAND_TYPE_REVERSE` | int | 2 | 15 |

### `com.gku.ffm.zqvideo.video.base.GSYVideoView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CHANGE_DELAY_TIME` | int | 2000 | 30 |
| `CURRENT_STATE_AUTO_COMPLETE` | int | 6 | 31 |
| `CURRENT_STATE_ERROR` | int | 7 | 32 |
| `CURRENT_STATE_NORMAL` | int | 0 | 33 |
| `CURRENT_STATE_PAUSE` | int | 5 | 34 |
| `CURRENT_STATE_PLAYING` | int | 2 | 35 |
| `CURRENT_STATE_PLAYING_BUFFERING_START` | int | 3 | 36 |
| `CURRENT_STATE_PREPAREING` | int | 1 | 37 |

### `com.gku.G`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "G" | 12 |

### `com.gku.gkucamplayer.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "debug" | 5 |
| `DEBUG` | boolean | true | 6 |
| `LIBRARY_PACKAGE_NAME` | String | "com.gku.gkucamplayer" | 7 |
| `LIBRARY_VERSION` | String | ". Version: 8.1.2" | 8 |

### `com.gku.gps.GpsInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `GET_GPS_INFO` | String | "Get GPS Info" | 5 |
| `NO_FILE_FOUND` | String | "No File Found" | 7 |
| `NOT_HISILICON_GKU` | String | "Not GKUVISION" | 6 |

### `com.gku.gps.ICatchGpsInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `GET_GPS_INFO` | String | "Get GPS Info" | 5 |
| `NO_FILE_FOUND` | String | "No File Found" | 7 |
| `NOT_HISILICON_GKU` | String | "Not GKUVISION" | 6 |

### `com.gku.hisi.Hisi_CameraFileActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CALLBACK_CHOOSE_CLICK` | String | "CALLBACK_CHOOSE_CLICK" | 22 |

### `com.gku.hisi.Hisi_CameraPicFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CALLBACK_DELETE_ONE` | String | "CALLBACK_DELETE_ONE" | 50 |
| `CALLBACK_DOWNLOAD_ONE` | String | "CALLBACK_DOWNLOAD_ONE" | 51 |
| `CALLBACK_UPDATE_LIST_PIC_POSITION` | String | "CALLBACK_UPDATE_LIST_POSITION" | 52 |

### `com.gku.hisi.Hisi_PicPreviewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_INTENT` | String | "KEY_INTENT" | 29 |
| `KEY_LIST` | String | "KEY_LIST" | 30 |
| `KEY_POSITION` | String | "KEY_POSITION" | 31 |

### `com.gku.HomeActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CALLBACK_SCANWIFI_RESULT` | String | "df-efg-32-5-rg-dfg" | 171 |
| `CODE_SCAN_WIFI` | int | 321 | 172 |
| `INTENT_RTMP_TASK` | String | "INTENT_RTMP_TASK" | 173 |
| `READY_FOR_RTMP` | String | "ready..." | 174 |
| `STREAMING_FOR_RTMP` | String | "streaming..." | 175 |
| `TAG` | String | "HomeActivity" | 176 |
| `WAITING_FOR_RTMP` | String | "waiting..." | 177 |
| `WHAT_AMBA_RECONNECT_FAILURE` | int | 1141548 | 178 |
| `WHAT_AMBA_RECONNECT_SUCCESS` | int | 1141549 | 179 |

### `com.gku.loginmodule.db.AppDatabase`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DATABASE_NAME` | String | "XTU GO_Room_DB" | 15 |

### `com.gku.loginmodule.network.errorhandler.ExceptionHandle`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BAD_GATEWAY` | int | 502 | 14 |
| `FORBIDDEN` | int | 403 | 15 |
| `GATEWAY_TIMEOUT` | int | 504 | 16 |
| `INTERNAL_SERVER_ERROR` | int | 500 | 17 |
| `NOT_FOUND` | int | 404 | 18 |
| `REQUEST_TIMEOUT` | int | 408 | 19 |
| `SERVICE_UNAVAILABLE` | int | 503 | 20 |
| `UNAUTHORIZED` | int | 401 | 21 |

### `com.gku.loginmodule.network.errorhandler.ExceptionHandle$ERROR`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HTTP_ERROR` | int | 1003 | 104 |
| `NETWORK_ERROR` | int | 1002 | 105 |
| `PARSE_ERROR` | int | 1001 | 106 |
| `SSL_ERROR` | int | 1005 | 107 |
| `TIMEOUT_ERROR` | int | 1006 | 108 |
| `UNKNOWN` | int | 1000 | 109 |

### `com.gku.loginmodule.network.interceptor.ResponseInterceptor`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ResponseInterceptor" | 10 |

### `com.gku.loginmodule.network.interceptor.TokenInterceptor`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TOKEN_KEY` | String | "token" | 14 |

### `com.gku.loginmodule.network.utils.DateUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DAY` | String | "dd" | 13 |
| `FRIDAY` | String | "ææäº" | 34 |
| `FULL_TIME` | String | "yyyy-MM-dd HH:mm:ss.SSS" | 14 |
| `HOUR` | String | "HH" | 15 |
| `HOUR_MINUTE_SECOND` | String | "HH:mm:ss" | 16 |
| `HOUR_MINUTE_SECOND_CN` | String | "HHæ¶mmåssç§" | 17 |
| `MILLISECOND` | String | "SSS" | 18 |
| `MINUTE` | String | "mm" | 19 |
| `MONDAY` | String | "ææä¸" | 30 |
| `MONTH` | String | "MM" | 20 |
| `SATURDAY` | String | "ææå­" | 35 |
| `SECOND` | String | "ss" | 21 |
| `STANDARD_TIME` | String | "yyyy-MM-dd HH:mm:ss" | 22 |
| `SUNDAY` | String | "æææ¥" | 29 |
| `THURSDAY` | String | "ææå" | 33 |
| `TODAY` | String | "ä»å¤©" | 23 |
| `TOMORROW` | String | "æå¤©" | 24 |
| `TUESDAY` | String | "ææäº" | 31 |
| `WEDNESDAY` | String | "ææä¸" | 32 |
| `WEEK_DAYS` | String[] | {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY} | 36 |
| `YEAR` | String | "yyyy" | 25 |
| `YEAR_MONTH_DAY` | String | "yyyy-MM-dd" | 26 |
| `YEAR_MONTH_DAY_CN` | String | "yyyyå¹´MMæddå·" | 27 |
| `YESTERDAY` | String | "æ¨å¤©" | 28 |

### `com.gku.loginmodule.network.utils.KLog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `A` | int | 6 | 11 |
| `D` | int | 2 | 12 |
| `DEFAULT_MESSAGE` | String | "execute" | 13 |
| `E` | int | 5 | 14 |
| `I` | int | 3 | 15 |
| `JSON` | int | 7 | 17 |
| `JSON_INDENT` | int | 4 | 18 |
| `V` | int | 1 | 20 |
| `W` | int | 4 | 21 |

### `com.gku.loginmodule.repository.AnnouncementRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AnnouncementRepository" | 16 |

### `com.gku.loginmodule.repository.DeleteAccountRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DeleteAccountRepository" | 15 |

### `com.gku.loginmodule.repository.DeviceInfoRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DeviceInfoRepository" | 14 |

### `com.gku.loginmodule.repository.ForgetPasswordRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ForgetPwdRepository" | 15 |

### `com.gku.loginmodule.repository.GetLanguageListRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "GetLanguagesRepository" | 20 |

### `com.gku.loginmodule.repository.GetPromotionListRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "GetPromotionsRepository" | 15 |

### `com.gku.loginmodule.repository.GKUUserRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "GKUUserRepository" | 21 |

### `com.gku.loginmodule.repository.LoginRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LoginRepository" | 15 |

### `com.gku.loginmodule.repository.LogoutRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LogoutRepository" | 15 |

### `com.gku.loginmodule.repository.ModifyPasswordRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ModifyPwdRepository" | 15 |

### `com.gku.loginmodule.repository.ProblemTypesRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ProblemTypesRepository" | 13 |

### `com.gku.loginmodule.repository.PTAndPMRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PTAndPMRepository" | 26 |

### `com.gku.loginmodule.repository.RegisterRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RegisterRepository" | 15 |

### `com.gku.loginmodule.repository.ReportFeedbackRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ReportFbRepository" | 15 |

### `com.gku.loginmodule.repository.UpdateUserInfoRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UpdateUInfoRepository" | 16 |

### `com.gku.loginmodule.repository.UploadAttachmentRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UploadRepository" | 26 |

### `com.gku.loginmodule.repository.VerifyCodeRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "VerifyCodeRepository" | 15 |

### `com.gku.loginmodule.ui.activity.AnnouncementLatestActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AmLatestActivity" | 28 |

### `com.gku.loginmodule.ui.activity.BaseActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SELECT_PHOTO_CODE` | int | 2000 | 24 |
| `TAG` | String | "BaseActivity" | 25 |
| `TAKE_PHOTO_CODE` | int | 2001 | 26 |

### `com.gku.loginmodule.ui.activity.DeviceUpgradeActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARGUMENT_DATA` | String | "ARGUMENT_DATA" | 43 |
| `ARGUMENT_FILE_PATH` | String | "ARGUMENT_FILE_PATH" | 44 |
| `ARGUMENT_NEW_VERSION` | String | "ARGUMENT_NEW_VERSION" | 45 |
| `ARGUMENT_UPDATE_INFO` | String | "ARGUMENT_UPDATE_INFO" | 46 |

### `com.gku.loginmodule.ui.activity.Report_Feedback_Activity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "Report_Feedback_Activity" | 20 |

### `com.gku.loginmodule.ui.activity.WebViewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "WebViewActivity" | 14 |

### `com.gku.loginmodule.ui.fragment.DeleteAccountFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DeleteAccountFragment" | 24 |

### `com.gku.loginmodule.ui.fragment.ForgetPasswordFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ForgetPasswordFragment" | 22 |

### `com.gku.loginmodule.ui.fragment.LoginFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LoginFragment" | 43 |

### `com.gku.loginmodule.ui.fragment.ModifyPasswordFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ModifyPasswordFragment" | 23 |

### `com.gku.loginmodule.ui.fragment.OperationFailFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "OperationFailFragment" | 22 |

### `com.gku.loginmodule.ui.fragment.OperationSuccessFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "OperationSuccess" | 23 |

### `com.gku.loginmodule.ui.fragment.PhoneNumberFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhoneNumberFragment" | 28 |

### `com.gku.loginmodule.ui.fragment.RegisterFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RegisterFragment" | 34 |

### `com.gku.loginmodule.ui.fragment.ReportFeedbackFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ReportFeedbackFragment" | 121 |

### `com.gku.loginmodule.ui.fragment.UserCenterNewFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UserInfoFragment" | 55 |

### `com.gku.loginmodule.ui.fragment.UserInfoFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UserInfoFragment" | 24 |

### `com.gku.loginmodule.ui.model.ReportFeedBackItem`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TYPE_ADD` | int | 3 | 22 |
| `TYPE_IMAGE` | int | 1 | 23 |
| `TYPE_TEXT` | int | 0 | 24 |
| `TYPE_VIDEO` | int | 2 | 25 |

### `com.gku.loginmodule.utils.Constant`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTIVITY_RESULT` | int | 1 | 5 |
| `CALLBACK_RESULT` | int | 2 | 6 |
| `IS_FORGET_PASSWORD_FRAGMENT` | String | "isForgetPasswordFragment" | 7 |
| `IS_FORGET_PASSWORD_OPERATION_SUCCESS_FRAGMENT` | String | "isForgetPasswordOperationSuccessFragment" | 8 |
| `IS_LOGIN` | String | "isLogin" | 9 |
| `IS_LOGIN_FRAGMENT` | String | "isLoginFragment" | 10 |
| `IS_LOGOUT_ACCOUNT_FRAGMENT` | String | "isLogoutAccountFragment" | 11 |
| `IS_OPERATION_FAILED_FRAGMENT` | String | "isOperationFailedFragment" | 12 |
| `IS_OPERATION_SUCCESS_FRAGMENT` | String | "isOperationSuccessFragment" | 13 |
| `IS_REGISTER_FRAGMENT` | String | "isRegisterFragment" | 14 |
| `IS_REPORT_FEEDBACK_FRAGMENT` | String | "isReportFeedbackFragment" | 15 |
| `IS_SHOW_RED_POINT` | String | "isShowRedPoint" | 16 |
| `IS_SHOW_VISITOR_LOGIN` | String | "isShowVisitorLogin" | 17 |
| `IS_TECH_SUPPORT_FRAGMENT_OR_NOT` | String | "isTechSupportFragment" | 18 |
| `IS_TODAY_REQUEST` | String | "isTodayRequest" | 19 |
| `IS_TODAY_REQUEST_WALLPAPER` | String | "isTodayRequestWallPaper" | 20 |
| `IS_USER_CENTER_INTRODUCE` | String | "isUserCenterIntroduce" | 21 |
| `IS_USER_CENTER_PRODUCT_IMPROVE` | String | "isUserCenterProductImprove" | 22 |
| `IS_USER_CENTER_TECH_SUPPORT` | String | "isUserCenterTechSupport" | 23 |
| `IS_USER_INFO_FRAGMENT_OR_NOT` | String | "isUserInfoFragment" | 24 |
| `LAUNCHER_RESULT` | int | 3 | 25 |
| `PROBLEM_CONTENT` | String | "problemContent" | 26 |
| `REQUEST_TIMESTAMP` | String | "requestTimestamp" | 27 |
| `REQUEST_TIMESTAMP_WALLPAPER` | String | "wallpaperRequestTimestamp" | 28 |
| `TAG_EXPLAIN_VIEW` | String | "TAG_EXPLAIN_VIEW" | 29 |
| `WHICH_FRAGMENT` | String | "whichFragment" | 30 |

### `com.gku.loginmodule.utils.PermissionUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CAMERA` | String | "android.permission.CAMERA" | 20 |
| `LOCATION` | String | "android.permission.ACCESS_FINE_LOCATION" | 21 |
| `READ_EXTERNAL_STORAGE` | String | "android.permission.READ_EXTERNAL_STORAGE" | 22 |
| `REQUEST_CAMERA_CODE` | int | 1002 | 23 |
| `REQUEST_LOCATION_CODE` | int | 1003 | 24 |
| `REQUEST_MANAGE_EXTERNAL_STORAGE_CODE` | int | 1000 | 25 |
| `REQUEST_STORAGE_CODE` | int | 1001 | 26 |
| `WRITE_EXTERNAL_STORAGE` | String | "android.permission.WRITE_EXTERNAL_STORAGE" | 27 |

### `com.gku.loginmodule.viewmodels.AnnouncementLatestViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "AnnouncementLatestVM" | 12 |

### `com.gku.loginmodule.viewmodels.BaseViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ERR_ACCOUNT_NOT_EXIST` | int | 10015 | 15 |
| `ERR_ACCOUNT_OR_PASSWORD` | int | 10012 | 16 |
| `ERR_EMAIL` | int | 10010 | 17 |
| `ERR_EMAIL_REGISTERD` | int | 10014 | 18 |
| `ERR_INVALID_TOKEN` | int | 10016 | 19 |
| `ERR_OLD_PASSWORD` | int | 10022 | 20 |
| `ERR_VCODE_PREQUENT` | int | 10017 | 21 |
| `ERR_VCOED` | int | 10011 | 22 |
| `ERR_VODE_EXPIRED` | int | 10018 | 23 |

### `com.gku.loginmodule.viewmodels.DeleteAccountViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DeleteAccountViewModel" | 23 |

### `com.gku.loginmodule.viewmodels.ForgetPasswordFragmentViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ForgetPwdFragmentVM" | 21 |

### `com.gku.loginmodule.viewmodels.HomeActivityViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "HomeActivityViewModel" | 29 |

### `com.gku.loginmodule.viewmodels.LoginFragmentViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "LoginFragmentViewModel" | 29 |

### `com.gku.loginmodule.viewmodels.ModifyPasswordFragmentViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ModifyPwdFV" | 19 |

### `com.gku.loginmodule.viewmodels.PhoneNumberFragmentViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PhoneNumberFmViewModel" | 20 |

### `com.gku.loginmodule.viewmodels.RegisterFragmentViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "RegisterFragmentVM" | 23 |

### `com.gku.loginmodule.viewmodels.ReportFeedbackViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ReportFeedbackViewModel" | 34 |

### `com.gku.loginmodule.viewmodels.SingleLiveEvent`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "SingleLiveEvent" | 10 |

### `com.gku.loginmodule.viewmodels.UserCenterNewFragmentViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UserInfoFmViewModel" | 26 |

### `com.gku.loginmodule.viewmodels.UserInfoFragmentViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UserInfoFmViewModel" | 17 |

### `com.gku.loginmodule.viewmodels.UserInfoViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "UserInfoViewModel" | 12 |

### `com.gku.mediacodec.exo2.demo.EventLogger`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_TIMELINE_ITEM_LINES` | int | 3 | 51 |
| `TAG` | String | "EventLogger" | 52 |

### `com.gku.mediacodec.exo2.ExoSourceManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_MAX_SIZE` | long | 536870912 | 43 |
| `TAG` | String | "ExoSourceManager" | 44 |
| `TYPE_RTMP` | int | 14 | 45 |

### `com.gku.mediacodec.exo2.IjkExo2MediaPlayer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "IjkExo2MediaPlayer" | 52 |

### `com.gku.module_base_xtugo.api.ApiUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CODE_JSON_PARSE_ERROR` | int | 200 | 9 |
| `CODE_NO_DATA` | int | 100 | 10 |
| `CODE_OK` | int | 0 | 11 |
| `URL_SERVER` | String | "https://server4.gkuvision.com" | 12 |

### `com.gku.module_base_xtugo.BR`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `_all` | int | 0 | 6 |
| `activeTime` | int | 2 | 7 |
| `announcementLatestViewModel` | int | 3 | 8 |
| `content` | int | 4 | 9 |
| `createBy` | int | 5 | 10 |
| `createTime` | int | 6 | 11 |
| `email` | int | 7 | 12 |
| `forgetPwdViewModel` | int | 8 | 13 |
| `fragmentDeleteAccountViewModel` | int | 9 | 14 |
| `habits` | int | 10 | 15 |
| `iconUrl` | int | 11 | 16 |
| `id` | int | 12 | 17 |
| `lanCode` | int | 13 | 18 |
| `linkUrl` | int | 14 | 19 |
| `LoginFragmentViewModel` | int | 1 | 5 |
| `loginTimes` | int | 15 | 20 |
| `loginViewModel` | int | 16 | 21 |
| `mobile` | int | 17 | 22 |
| `modifyPwdViewModel` | int | 18 | 23 |
| `operationFail` | int | 19 | 24 |
| `operationSuccess` | int | 20 | 25 |
| `phoneNumberFragmentViewModel` | int | 21 | 26 |
| `productModel` | int | 22 | 27 |
| `register` | int | 24 | 29 |
| `registTime` | int | 23 | 28 |
| `remark` | int | 25 | 30 |
| `reportFeedbackViewModel` | int | 26 | 31 |
| `roomId` | int | 27 | 32 |
| `searchValue` | int | 28 | 33 |
| `title` | int | 29 | 34 |
| `uid` | int | 30 | 35 |
| `updateBy` | int | 31 | 36 |
| `updateTime` | int | 32 | 37 |
| `userCenterNewFragmentViewModel` | int | 33 | 38 |
| `userdata1` | int | 37 | 42 |
| `userdata2` | int | 38 | 43 |
| `userdata3` | int | 39 | 44 |
| `userInfoFragmentViewModel` | int | 34 | 39 |
| `userInfoViewModel` | int | 35 | 40 |
| `userPwd` | int | 36 | 41 |

### `com.gku.module_base_xtugo.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "release" | 5 |
| `DEBUG` | boolean | false | 6 |
| `LIBRARY_PACKAGE_NAME` | String | "com.gku.module_base_xtugo" | 7 |
| `URL_SERVER` | String | "https://server4.gkuvision.com" | 8 |

### `com.gku.module_base_xtugo.ConstansXtuGo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CALLBACK_DEVICE_CONNECT` | String | "CALLBACK_DEVICE_CONNECTED" | 5 |

### `com.gku.module_base_xtugo.HisiApiUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HTTP` | String | "http://" | 9 |

### `com.gku.module_camera.amba.connector.AmbaConnector`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_ID_BLUETOOTH_HEARTBEAT` | int | 268435492 | 35 |
| `MSG_ID_CANCLE_XFER` | int | 1287 | 36 |
| `MSG_ID_DELETE_ALL_FILE` | int | 268435487 | 37 |
| `MSG_ID_DELETE_FILE` | int | 268435486 | 38 |
| `MSG_ID_FORMAT_SD` | int | 4 | 39 |
| `MSG_ID_GET_ACTIVATE` | int | 268435505 | 40 |
| `MSG_ID_GET_ALL_WORK_MODE` | int | 268435457 | 41 |
| `MSG_ID_GET_BLUETOOTH_TX` | int | 268435507 | 42 |
| `MSG_ID_GET_BTATERY_INFO` | int | 268435480 | 43 |
| `MSG_ID_GET_CAMERA_INFO` | int | 11 | 44 |
| `MSG_ID_GET_CURRENT_WORK_MODE` | int | 268435458 | 45 |
| `MSG_ID_GET_FILE` | int | 1285 | 46 |
| `MSG_ID_GET_FILE_COUNT` | int | 268435482 | 48 |
| `MSG_ID_GET_FILE_INFO` | int | 268435484 | 49 |
| `MSG_ID_GET_FILE_LIST` | int | 268435483 | 50 |
| `MSG_ID_GET_FILELIST_INFO_IOS` | int | 268435485 | 47 |
| `MSG_ID_GET_PRIMARY_MENU_ITEM` | int | 268435460 | 51 |
| `MSG_ID_GET_ROTATE` | int | 268435489 | 52 |
| `MSG_ID_GET_SD_STATE` | int | 268435475 | 53 |
| `MSG_ID_GET_SECOND_MENU_ITEM` | int | 268435461 | 54 |
| `MSG_ID_GET_SYSTEM_WORK_STATE` | int | 268435466 | 55 |
| `MSG_ID_GET_THUMB` | int | 1025 | 56 |
| `MSG_ID_GET_WIFI_SETTING` | int | 1539 | 57 |
| `MSG_ID_HEART_BEAT` | int | 268435467 | 58 |
| `MSG_ID_PAIR_AND_GET_BLUETOOTH_TX` | int | 268435508 | 59 |
| `MSG_ID_PUT_FILE` | int | 1286 | 60 |
| `MSG_ID_QS_ADD_TIME` | int | 268435488 | 61 |
| `MSG_ID_RECORD_START` | int | 513 | 62 |
| `MSG_ID_RECORD_STOP` | int | 514 | 63 |
| `MSG_ID_RESET_FACTORY` | int | 268435477 | 65 |
| `MSG_ID_RESETVF` | int | 259 | 64 |
| `MSG_ID_SET_ACTIVATE` | int | 268435506 | 66 |
| `MSG_ID_SET_CLINT_INFO` | int | 261 | 67 |
| `MSG_ID_SET_CUR_PARAMETER` | int | 268435463 | 69 |
| `MSG_ID_SET_CURRENT_WORK_MODE` | int | 268435459 | 68 |
| `MSG_ID_SET_STREAM_DATA` | int | 268435490 | 70 |
| `MSG_ID_SET_WIFI_SETTING` | int | 1538 | 71 |
| `MSG_ID_START_SESSION` | int | 257 | 72 |
| `MSG_ID_STOP_PHOTO` | int | 770 | 73 |
| `MSG_ID_STOP_SESSION` | int | 258 | 74 |
| `MSG_ID_STOP_VF` | int | 260 | 75 |
| `MSG_ID_SYNC_SYSTEM_TIME` | int | 268435474 | 76 |
| `MSG_ID_TAKE_PHOTO` | int | 769 | 77 |

### `com.gku.module_camera.amba.connector.AmbaDownloader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_TYPE_PIC` | int | 1 | 42 |
| `FILE_TYPE_UNKNOWN` | int | -1 | 43 |
| `FILE_TYPE_VIDEO` | int | 0 | 44 |

### `com.gku.module_camera.amba.ConstantsAmba`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AMBA_DATA_PORT` | int | 8787 | 5 |
| `CALLBACK_AMBA_GET_INFOED` | String | "dfdfew3434gf" | 6 |
| `CODE_ERROR_AMBA_CONNECT` | int | -104 | 7 |
| `CODE_ERROR_AMBA_COPYFILETODCIM_9_NO_PERMISSION` | int | -111 | 8 |
| `CODE_ERROR_AMBA_DOWNLOAD_CONTENTLENGTH_NOT_EQUALS` | int | -106 | 9 |
| `CODE_ERROR_AMBA_FILE_OUTPUT_STREAM_CREATE` | int | -105 | 10 |
| `CODE_ERROR_AMBA_JSON_PARSE` | int | -103 | 11 |
| `CODE_ERROR_AMBA_MSG_CANCELED` | int | -115 | 12 |
| `CODE_ERROR_AMBA_MSG_CLEARED` | int | -116 | 13 |
| `CODE_ERROR_AMBA_MSG_ID_PUT_FILE_FAIL` | int | -114 | 14 |
| `CODE_ERROR_AMBA_NO_RETRY_TIMES` | int | -109 | 15 |
| `CODE_ERROR_AMBA_READ` | int | -102 | 16 |
| `CODE_ERROR_AMBA_RVAL_NOT_0` | int | -108 | 17 |
| `CODE_ERROR_AMBA_SESSIONID_INVALID` | int | -107 | 18 |
| `CODE_ERROR_AMBA_TEMP_RENAME` | int | -117 | 19 |
| `CODE_ERROR_AMBA_UPLOAD_CONTENTLENGTH_NOT_EQUALS` | int | -112 | 20 |
| `CODE_ERROR_AMBA_UPLOAD_INPUT_STREAM_CREATE` | int | -113 | 21 |
| `CODE_ERROR_AMBA_WRITE` | int | -101 | 22 |

### `com.gku.module_camera.amba.dialog.DialogAmbaSDMediaDownload`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "DialogAmbaSDMediaDownload" | 22 |

### `com.gku.module_camera.bluetooth.BluetoothConnector`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CODE_CHARACTERISTIC_NOT_FOUND` | int | -2 | 33 |
| `CODE_SERVICE_NOT_FOUND` | int | -1 | 34 |

### `com.gku.module_camera.bluetooth.BluetoothLive`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CHAR_UUID` | String | "00008888-0000-1000-8000-00805f9b34fb" | 23 |
| `CHUNK_SIZE` | int | 100 | 24 |
| `SERVICE_UUID` | String | "0000180a-0000-1000-8000-00805f9b34fb" | 25 |

### `com.gku.module_camera.hisi.ConstantsHisi`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CODE_ERROR_HISI_CONNECT` | int | -1004 | 5 |
| `CODE_ERROR_HISI_COPYFILETODCIM_9_NO_PERMISSION` | int | -1011 | 6 |
| `CODE_ERROR_HISI_DOWNLOAD_CONTENTLENGTH_NOT_EQUALS` | int | -1006 | 7 |
| `CODE_ERROR_HISI_FILE_OUTPUT_STREAM_CREATE` | int | -1005 | 8 |
| `CODE_ERROR_HISI_GET_FILE_COUNT_ERROR` | int | -1013 | 9 |
| `CODE_ERROR_HISI_JSON_PARSE` | int | -1003 | 10 |
| `CODE_ERROR_HISI_LENGTH_GET` | int | -1009 | 11 |
| `CODE_ERROR_HISI_LENGTH_INVALID` | int | -1008 | 12 |
| `CODE_ERROR_HISI_NOT_SUCCESS` | int | -1012 | 13 |
| `CODE_ERROR_HISI_READ` | int | -1002 | 14 |
| `CODE_ERROR_HISI_WRITE` | int | -1001 | 15 |

### `com.gku.module_camera.hisi.HisiDownloader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_TYPE_PIC` | int | 1 | 37 |
| `FILE_TYPE_UNKNOWN` | int | -1 | 38 |
| `FILE_TYPE_VIDEO` | int | 0 | 39 |

### `com.gku.module_camera.hisi.HisiSocketServer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SERVER_PORT` | int | 5678 | 19 |

### `com.gku.module_my.ConstantsMy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `XTUGO_PRIVACY_CN` | String | "https://device.gkuvision.com/static/xtugo_privacy_cn.html" | 10 |
| `XTUGO_PRIVACY_CN_ASSETS` | String | "xtugo_privacy_cn.html" | 11 |
| `XTUGO_PRIVACY_EN` | String | "https://device.gkuvision.com/static/xtugo_privacy_en.html" | 12 |
| `XTUGO_PRIVACY_EN_ASSETS` | String | "xtugo_privacy_en.html" | 13 |
| `XTUGO_USERAGREEMENT_CN` | String | "https://device.gkuvision.com/static/xtugo_useragreement_cn.html" | 14 |
| `XTUGO_USERAGREEMENT_CN_ASSETS` | String | "xtugo_useragreement_cn.html" | 15 |
| `XTUGO_USERAGREEMENT_EN` | String | "https://device.gkuvision.com/static/xtugo_useragreement_en.html" | 16 |
| `XTUGO_USERAGREEMENT_EN_ASSETS` | String | "xtugo_useragreement_en.html" | 17 |

### `com.gku.rxt.FwUpload2`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HOST` | String | "192.168.0.1" | 18 |
| `PORT` | int | 8080 | 19 |
| `TIME_OUT` | int | 5000 | 20 |

### `com.gku.rxt.MediaRepositoryKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `QUERY_TYPE_ALL` | int | 1 | 9 |
| `QUERY_TYPE_IMAGE` | int | 3 | 10 |
| `QUERY_TYPE_VIDEO` | int | 2 | 11 |
| `SELECTION` | String | "_data like ? AND (media_type=1 OR media_type=3)" | 12 |
| `SELECTION_ALL_VIDEO` | String | "_data like ? AND (media_type=0 OR media_type=3)" | 13 |
| `SORT_ORDER` | String | "date_added desc" | 14 |

### `com.gku.rxt.net.AppService`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `API_APP_SERVICE_HOST_IP` | String | "http://www.gkuvision.com:8882/upload/update.xml" | 22 |
| `API_FW_SERVICE_HOST_IP` | String | "http://api.shhc-yh.com/api/" | 23 |
| `API_SERVICE_HOST_IP` | String | "http://api.shhc-yh.com/" | 24 |

### `com.gku.rxt.ThumbHelp`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "ThumbHelp" | 19 |

### `com.gku.videocache.file.FileCache`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TEMP_POSTFIX` | String | ".download" | 12 |

### `com.gku.videocache.file.Md5FileNameGenerator`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_EXTENSION_LENGTH` | int | 4 | 9 |

### `com.gku.videocache.HttpProxyCache`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `NO_CACHE_BARRIER` | float | 0.2f | 14 |

### `com.gku.videocache.HttpProxyCacheDebuger`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LOG_TAG` | String | "HttpProxyCacheDebuger" | 11 |

### `com.gku.videocache.HttpProxyCacheServer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PROXY_HOST` | String | "127.0.0.1" | 32 |

### `com.gku.videocache.HttpProxyCacheServer$Builder`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_MAX_SIZE` | long | 536870912 | 311 |

### `com.gku.videocache.HttpUrlSource`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_REDIRECTS` | int | 5 | 27 |

### `com.gku.videocache.Pinger`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PING_REQUEST` | String | "ping" | 22 |
| `PING_RESPONSE` | String | "ping ok" | 23 |

### `com.gku.videocache.ProxyCache`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_READ_SOURCE_ATTEMPTS` | int | 1 | 7 |

### `com.gku.videocache.ProxyCacheUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_BUFFER_SIZE` | int | 8192 | 17 |
| `MAX_ARRAY_PREVIEW` | int | 16 | 18 |

### `com.gku.videocache.sourcestorage.DatabaseSourceInfoStorage`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ALL_COLUMNS` | String[] | {"_id", "url", "length", "mime"} | 13 |
| `COLUMN_ID` | String | "_id" | 14 |
| `COLUMN_LENGTH` | String | "length" | 15 |
| `COLUMN_MIME` | String | "mime" | 16 |
| `COLUMN_URL` | String | "url" | 17 |
| `CREATE_SQL` | String | "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);" | 18 |
| `TABLE` | String | "SourceInfo" | 19 |

### `com.gku.videocache.StorageUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INDIVIDUAL_DIR_NAME` | String | "video-cache" | 11 |

### `com.gku.xtugo.BR`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `_all` | int | 0 | 6 |
| `activeTime` | int | 2 | 7 |
| `announcementLatestViewModel` | int | 3 | 8 |
| `content` | int | 4 | 9 |
| `createBy` | int | 5 | 10 |
| `createTime` | int | 6 | 11 |
| `email` | int | 7 | 12 |
| `forgetPwdViewModel` | int | 8 | 13 |
| `fragmentDeleteAccountViewModel` | int | 9 | 14 |
| `habits` | int | 10 | 15 |
| `iconUrl` | int | 11 | 16 |
| `id` | int | 12 | 17 |
| `lanCode` | int | 13 | 18 |
| `linkUrl` | int | 14 | 19 |
| `LoginFragmentViewModel` | int | 1 | 5 |
| `loginTimes` | int | 15 | 20 |
| `loginViewModel` | int | 16 | 21 |
| `mobile` | int | 17 | 22 |
| `modifyPwdViewModel` | int | 18 | 23 |
| `operationFail` | int | 19 | 24 |
| `operationSuccess` | int | 20 | 25 |
| `phoneNumberFragmentViewModel` | int | 21 | 26 |
| `productModel` | int | 22 | 27 |
| `register` | int | 24 | 29 |
| `registTime` | int | 23 | 28 |
| `remark` | int | 25 | 30 |
| `reportFeedbackViewModel` | int | 26 | 31 |
| `roomId` | int | 27 | 32 |
| `searchValue` | int | 28 | 33 |
| `title` | int | 29 | 34 |
| `uid` | int | 30 | 35 |
| `updateBy` | int | 31 | 36 |
| `updateTime` | int | 32 | 37 |
| `userCenterNewFragmentViewModel` | int | 33 | 38 |
| `userdata1` | int | 37 | 42 |
| `userdata2` | int | 38 | 43 |
| `userdata3` | int | 39 | 44 |
| `userInfoFragmentViewModel` | int | 34 | 39 |
| `userInfoViewModel` | int | 35 | 40 |
| `userPwd` | int | 36 | 41 |

### `com.gku.xtugo.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APPLICATION_ID` | String | "com.gku.xtugo" | 5 |
| `BuglyId` | String | "0324406337" | 7 |
| `BUILD_TYPE` | String | "release" | 6 |
| `CURRENT_APP_TYPE` | int | 0 | 8 |
| `DEBUG` | boolean | false | 9 |
| `FLAVOR` | String | "XTUGO" | 10 |
| `isDebuggable` | Boolean | false | 13 |
| `VERSION_CODE` | int | 243 | 11 |
| `VERSION_NAME` | String | "8.4.3_243_2026-08-19-17-05-43" | 12 |

### `com.gku.xtugo.DataBinderMapperImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LAYOUT_ACTIVITYANNOUNCEMENTLATEST` | int | 1 | 40 |
| `LAYOUT_ACTIVITYDEVICEMANAGER` | int | 2 | 41 |
| `LAYOUT_ACTIVITYLOGINREGISTERMODULE` | int | 3 | 42 |
| `LAYOUT_ACTIVITYREPORTFEEDBACK` | int | 4 | 43 |
| `LAYOUT_ACTIVITYSELECTLIVEDEVICE` | int | 5 | 44 |
| `LAYOUT_ACTIVITYSELECTLIVEWIFI` | int | 6 | 45 |
| `LAYOUT_ACTIVITYUSERINFO` | int | 7 | 46 |
| `LAYOUT_ACTIVITYWEB` | int | 8 | 47 |
| `LAYOUT_FRAGMENTDELETEACCOUNT` | int | 9 | 48 |
| `LAYOUT_FRAGMENTFORGETPWD` | int | 10 | 49 |
| `LAYOUT_FRAGMENTLOGIN` | int | 11 | 50 |
| `LAYOUT_FRAGMENTMODIFYPWD` | int | 12 | 51 |
| `LAYOUT_FRAGMENTOPERATIONFAIL` | int | 13 | 52 |
| `LAYOUT_FRAGMENTOPERATIONSUCCESS` | int | 14 | 53 |
| `LAYOUT_FRAGMENTPHONENUMBER` | int | 15 | 54 |
| `LAYOUT_FRAGMENTREGISTER` | int | 16 | 55 |
| `LAYOUT_FRAGMENTREPORTFEEDBACK` | int | 17 | 56 |
| `LAYOUT_FRAGMENTSTREAMSETTINGFOUR` | int | 18 | 57 |
| `LAYOUT_FRAGMENTUSERCENTERNEW` | int | 19 | 58 |
| `LAYOUT_FRAGMENTUSERINFO` | int | 20 | 59 |
| `LAYOUT_ITEMDEVICEMANAGER` | int | 21 | 60 |
| `LAYOUT_ITEMSELECTLIVEDEVICE` | int | 22 | 61 |

### `com.gku.xtugo.databinding.ActivityAnnouncementLatestBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 16 |

### `com.gku.xtugo.databinding.ActivityDeviceManagerBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 18 |

### `com.gku.xtugo.databinding.ActivityLoginRegisterModuleBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 14 |

### `com.gku.xtugo.databinding.ActivityReportFeedbackBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 14 |

### `com.gku.xtugo.databinding.ActivitySelectLiveDeviceBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 15 |

### `com.gku.xtugo.databinding.ActivitySelectLiveWifiBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 19 |

### `com.gku.xtugo.databinding.ActivityUserInfoBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 14 |

### `com.gku.xtugo.databinding.ActivityWebBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 15 |

### `com.gku.xtugo.databinding.FragmentDeleteAccountBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 22 |

### `com.gku.xtugo.databinding.FragmentForgetPwdBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 17 |

### `com.gku.xtugo.databinding.FragmentLoginBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 24 |

### `com.gku.xtugo.databinding.FragmentModifyPwdBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 22 |

### `com.gku.xtugo.databinding.FragmentOperationFailBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 15 |

### `com.gku.xtugo.databinding.FragmentOperationSuccessBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 15 |

### `com.gku.xtugo.databinding.FragmentPhoneNumberBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 17 |

### `com.gku.xtugo.databinding.FragmentRegisterBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 23 |

### `com.gku.xtugo.databinding.FragmentReportFeedbackBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 17 |

### `com.gku.xtugo.databinding.FragmentStreamSettingFourBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 15 |

### `com.gku.xtugo.databinding.FragmentUserCenterNewBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 14 |

### `com.gku.xtugo.databinding.FragmentUserInfoBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 16 |

### `com.gku.xtugo.databinding.ItemDeviceManagerBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 15 |

### `com.gku.xtugo.databinding.ItemSelectLiveDeviceBindingImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `sIncludes` | ViewDataBinding.IncludedLayouts | null | 14 |

### `com.gku.xtugo.R$anim`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_fade_in` | int | 0x7f010000 | 24 |
| `abc_fade_out` | int | 0x7f010001 | 27 |
| `abc_grow_fade_in_from_bottom` | int | 0x7f010002 | 30 |
| `abc_popup_enter` | int | 0x7f010003 | 33 |
| `abc_popup_exit` | int | 0x7f010004 | 36 |
| `abc_shrink_fade_out_from_bottom` | int | 0x7f010005 | 39 |
| `abc_slide_in_bottom` | int | 0x7f010006 | 42 |
| `abc_slide_in_top` | int | 0x7f010007 | 45 |
| `abc_slide_out_bottom` | int | 0x7f010008 | 48 |
| `abc_slide_out_top` | int | 0x7f010009 | 51 |
| `abc_tooltip_enter` | int | 0x7f01000a | 54 |
| `abc_tooltip_exit` | int | 0x7f01000b | 57 |
| `btn_checkbox_to_checked_box_inner_merged_animation` | int | 0x7f01000c | 60 |
| `btn_checkbox_to_checked_box_outer_merged_animation` | int | 0x7f01000d | 63 |
| `btn_checkbox_to_checked_icon_null_animation` | int | 0x7f01000e | 66 |
| `btn_checkbox_to_unchecked_box_inner_merged_animation` | int | 0x7f01000f | 69 |
| `btn_checkbox_to_unchecked_check_path_merged_animation` | int | 0x7f010010 | 72 |
| `btn_checkbox_to_unchecked_icon_null_animation` | int | 0x7f010011 | 75 |
| `btn_radio_to_off_mtrl_dot_group_animation` | int | 0x7f010012 | 78 |
| `btn_radio_to_off_mtrl_ring_outer_animation` | int | 0x7f010013 | 81 |
| `btn_radio_to_off_mtrl_ring_outer_path_animation` | int | 0x7f010014 | 84 |
| `btn_radio_to_on_mtrl_dot_group_animation` | int | 0x7f010015 | 87 |
| `btn_radio_to_on_mtrl_ring_outer_animation` | int | 0x7f010016 | 90 |
| `btn_radio_to_on_mtrl_ring_outer_path_animation` | int | 0x7f010017 | 93 |
| `bullet_bottom_dialog_enter` | int | 0x7f010018 | 96 |
| `bullet_bottom_dialog_exit` | int | 0x7f010019 | 99 |
| `cj_pay_activity_add_in_animation` | int | 0x7f01001a | 102 |
| `cj_pay_activity_fade_in_animation` | int | 0x7f01001b | 105 |
| `cj_pay_activity_fade_out_animation` | int | 0x7f01001c | 108 |
| `cj_pay_activity_remove_out_animation` | int | 0x7f01001d | 111 |
| `cj_pay_expo_easeout_interpolator` | int | 0x7f01001e | 114 |
| `cj_pay_fragment_down_out_animation` | int | 0x7f01001f | 117 |
| `cj_pay_fragment_up_in_animation` | int | 0x7f010020 | 120 |
| `cj_pay_quadratic_easein_interpolator` | int | 0x7f010021 | 123 |
| `cj_pay_slide_in_from_bottom_with_bezier` | int | 0x7f010022 | 126 |
| `cj_pay_slide_out_to_bottom_with_bezier` | int | 0x7f010023 | 129 |
| `cj_pay_slide_right_in` | int | 0x7f010024 | 132 |
| `design_bottom_sheet_slide_in` | int | 0x7f010025 | 135 |
| `design_bottom_sheet_slide_out` | int | 0x7f010026 | 138 |
| `design_snackbar_in` | int | 0x7f010027 | 141 |
| `design_snackbar_out` | int | 0x7f010028 | 144 |
| `dialog_bottom_in` | int | 0x7f010029 | 147 |
| `dialog_bottom_out` | int | 0x7f01002a | 150 |
| `dialog_left_in` | int | 0x7f01002d | 153 |
| `dialog_left_out` | int | 0x7f01002e | 156 |
| `dialog_right_in` | int | 0x7f01002f | 159 |
| `dialog_right_out` | int | 0x7f010030 | 162 |
| `dialog_scale_in` | int | 0x7f010033 | 165 |
| `dialog_scale_out` | int | 0x7f010034 | 168 |
| `dialog_top_in` | int | 0x7f010035 | 171 |
| `dialog_top_out` | int | 0x7f010036 | 174 |
| `ec_alpha_in` | int | 0x7f010037 | 177 |
| `ec_alpha_out` | int | 0x7f010038 | 180 |
| `ec_base_enter` | int | 0x7f010039 | 183 |
| `ec_base_exit` | int | 0x7f01003a | 186 |
| `ec_bottom_in` | int | 0x7f01003b | 189 |
| `ec_bottom_out` | int | 0x7f01003c | 192 |
| `ec_commerce_activity_in` | int | 0x7f01003d | 195 |
| `ec_commerce_activity_out` | int | 0x7f01003e | 198 |
| `ec_commerce_pre_out` | int | 0x7f01003f | 201 |
| `ec_pop_bottom_in` | int | 0x7f010040 | 204 |
| `ec_pop_bottom_out` | int | 0x7f010041 | 207 |
| `ec_pop_slide_in` | int | 0x7f010042 | 210 |
| `ec_pop_slide_out` | int | 0x7f010043 | 213 |
| `ec_slide_in` | int | 0x7f010044 | 216 |
| `ec_slide_out` | int | 0x7f010045 | 219 |
| `ec_zoom_in` | int | 0x7f010046 | 222 |
| `ec_zoom_out` | int | 0x7f010047 | 225 |
| `fragment_fast_out_extra_slow_in` | int | 0x7f01004a | 228 |
| `linear_indeterminate_line1_head_interpolator` | int | 0x7f01004b | 231 |
| `linear_indeterminate_line1_tail_interpolator` | int | 0x7f01004c | 234 |
| `linear_indeterminate_line2_head_interpolator` | int | 0x7f01004d | 237 |
| `linear_indeterminate_line2_tail_interpolator` | int | 0x7f01004e | 240 |
| `m3_bottom_sheet_slide_in` | int | 0x7f010050 | 243 |
| `m3_bottom_sheet_slide_out` | int | 0x7f010051 | 246 |
| `m3_motion_fade_enter` | int | 0x7f010052 | 249 |
| `m3_motion_fade_exit` | int | 0x7f010053 | 252 |
| `m3_side_sheet_enter_from_left` | int | 0x7f010054 | 255 |
| `m3_side_sheet_enter_from_right` | int | 0x7f010055 | 258 |
| `m3_side_sheet_exit_to_left` | int | 0x7f010056 | 261 |
| `m3_side_sheet_exit_to_right` | int | 0x7f010057 | 264 |
| `mtrl_bottom_sheet_slide_in` | int | 0x7f010058 | 267 |
| `mtrl_bottom_sheet_slide_out` | int | 0x7f010059 | 270 |
| `mtrl_card_lowers_interpolator` | int | 0x7f01005a | 273 |
| `nav_default_enter_anim` | int | 0x7f01005b | 276 |
| `nav_default_exit_anim` | int | 0x7f01005c | 279 |
| `nav_default_pop_enter_anim` | int | 0x7f01005d | 282 |
| `nav_default_pop_exit_anim` | int | 0x7f01005e | 285 |
| `pickerview_dialog_scale_in` | int | 0x7f01005f | 288 |
| `pickerview_dialog_scale_out` | int | 0x7f010060 | 291 |
| `pickerview_slide_in_bottom` | int | 0x7f010061 | 294 |
| `pickerview_slide_out_bottom` | int | 0x7f010062 | 297 |
| `ps_anim_album_dismiss` | int | 0x7f010069 | 300 |
| `ps_anim_album_show` | int | 0x7f01006a | 303 |
| `ps_anim_alpha_enter` | int | 0x7f01006b | 306 |
| `ps_anim_alpha_exit` | int | 0x7f01006c | 309 |
| `ps_anim_anticipate_interpolator` | int | 0x7f01006d | 312 |
| `ps_anim_down_out` | int | 0x7f01006e | 315 |
| `ps_anim_enter` | int | 0x7f01006f | 318 |
| `ps_anim_exit` | int | 0x7f010070 | 321 |
| `ps_anim_fade_in` | int | 0x7f010071 | 324 |
| `ps_anim_fade_out` | int | 0x7f010072 | 327 |
| `ps_anim_fall_enter` | int | 0x7f010073 | 330 |
| `ps_anim_layout_fall_enter` | int | 0x7f010074 | 333 |
| `ps_anim_modal_in` | int | 0x7f010075 | 336 |
| `ps_anim_modal_out` | int | 0x7f010076 | 339 |
| `ps_anim_overshoot_interpolator` | int | 0x7f010077 | 342 |
| `ps_anim_up_in` | int | 0x7f010078 | 345 |
| `shopping_popup_fade_in` | int | 0x7f010079 | 348 |
| `shopping_popup_fade_out` | int | 0x7f01007a | 351 |
| `slide_in_right` | int | 0x7f01007b | 354 |
| `slide_out_right` | int | 0x7f01007c | 357 |
| `ucrop_loader_circle_path` | int | 0x7f01007f | 360 |
| `ucrop_loader_circle_scale` | int | 0x7f010080 | 363 |
| `window_fade_close_enter` | int | 0x7f010081 | 366 |
| `window_fade_close_exit` | int | 0x7f010082 | 369 |

### `com.gku.xtugo.R$animator`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `design_appbar_state_list_animator` | int | 0x7f020000 | 379 |
| `design_fab_hide_motion_spec` | int | 0x7f020001 | 382 |
| `design_fab_show_motion_spec` | int | 0x7f020002 | 385 |
| `fragment_close_enter` | int | 0x7f020003 | 388 |
| `fragment_close_exit` | int | 0x7f020004 | 391 |
| `fragment_fade_enter` | int | 0x7f020005 | 394 |
| `fragment_fade_exit` | int | 0x7f020006 | 397 |
| `fragment_open_enter` | int | 0x7f020007 | 400 |
| `fragment_open_exit` | int | 0x7f020008 | 403 |
| `m3_appbar_state_list_animator` | int | 0x7f020009 | 406 |
| `m3_btn_elevated_btn_state_list_anim` | int | 0x7f02000a | 409 |
| `m3_btn_state_list_anim` | int | 0x7f02000b | 412 |
| `m3_card_elevated_state_list_anim` | int | 0x7f02000c | 415 |
| `m3_card_state_list_anim` | int | 0x7f02000d | 418 |
| `m3_chip_state_list_anim` | int | 0x7f02000e | 421 |
| `m3_elevated_chip_state_list_anim` | int | 0x7f02000f | 424 |
| `m3_extended_fab_change_size_collapse_motion_spec` | int | 0x7f020010 | 427 |
| `m3_extended_fab_change_size_expand_motion_spec` | int | 0x7f020011 | 430 |
| `m3_extended_fab_hide_motion_spec` | int | 0x7f020012 | 433 |
| `m3_extended_fab_show_motion_spec` | int | 0x7f020013 | 436 |
| `m3_extended_fab_state_list_animator` | int | 0x7f020014 | 439 |
| `mtrl_btn_state_list_anim` | int | 0x7f020015 | 442 |
| `mtrl_btn_unelevated_state_list_anim` | int | 0x7f020016 | 445 |
| `mtrl_card_state_list_anim` | int | 0x7f020017 | 448 |
| `mtrl_chip_state_list_anim` | int | 0x7f020018 | 451 |
| `mtrl_extended_fab_change_size_collapse_motion_spec` | int | 0x7f020019 | 454 |
| `mtrl_extended_fab_change_size_expand_motion_spec` | int | 0x7f02001a | 457 |
| `mtrl_extended_fab_hide_motion_spec` | int | 0x7f02001b | 460 |
| `mtrl_extended_fab_show_motion_spec` | int | 0x7f02001c | 463 |
| `mtrl_extended_fab_state_list_animator` | int | 0x7f02001d | 466 |
| `mtrl_fab_hide_motion_spec` | int | 0x7f02001e | 469 |
| `mtrl_fab_show_motion_spec` | int | 0x7f02001f | 472 |
| `mtrl_fab_transformation_sheet_collapse_spec` | int | 0x7f020020 | 475 |
| `mtrl_fab_transformation_sheet_expand_spec` | int | 0x7f020021 | 478 |
| `nav_default_enter_anim` | int | 0x7f020022 | 481 |
| `nav_default_exit_anim` | int | 0x7f020023 | 484 |
| `nav_default_pop_enter_anim` | int | 0x7f020024 | 487 |
| `nav_default_pop_exit_anim` | int | 0x7f020025 | 490 |

### `com.gku.xtugo.R$array`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `area_codes` | int | 0x7f030000 | 497 |
| `boot_action_entries` | int | 0x7f030001 | 500 |
| `boot_action_values` | int | 0x7f030002 | 503 |
| `branch_integer_array` | int | 0x7f030003 | 506 |
| `branch_string_array` | int | 0x7f030004 | 509 |
| `exo_controls_playback_speeds` | int | 0x7f030005 | 512 |
| `hosts_allowlist_sample` | int | 0x7f030006 | 515 |
| `indexable_letter` | int | 0x7f030007 | 518 |
| `lunar_first_of_month` | int | 0x7f030008 | 521 |
| `lunar_str` | int | 0x7f030009 | 524 |
| `month_string_array` | int | 0x7f03000a | 527 |
| `paths` | int | 0x7f03000b | 530 |
| `screen_auto_sleep_entries` | int | 0x7f03000c | 533 |
| `screen_auto_sleep_values` | int | 0x7f03000d | 536 |
| `solar_festival` | int | 0x7f03000e | 539 |
| `solar_term` | int | 0x7f03000f | 542 |
| `special_festivals` | int | 0x7f030010 | 545 |
| `tradition_festival` | int | 0x7f030011 | 548 |
| `trunk_integer_array` | int | 0x7f030012 | 551 |
| `trunk_string_array` | int | 0x7f030013 | 554 |
| `video_mode_entries` | int | 0x7f030014 | 557 |
| `video_mode_values` | int | 0x7f030015 | 560 |
| `video_resolution_entries_ntsc` | int | 0x7f030016 | 563 |
| `video_resolution_entries_pal` | int | 0x7f030017 | 566 |
| `video_resolution_values_ntsc` | int | 0x7f030018 | 569 |
| `video_resolution_values_pal` | int | 0x7f030019 | 572 |
| `week_string_array` | int | 0x7f03001a | 575 |
| `year_view_week_string_array` | int | 0x7f03001b | 578 |

### `com.gku.xtugo.R$attr`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `action` | int | 0x7f040004 | 702 |
| `actionBarDivider` | int | 0x7f040005 | 705 |
| `actionBarItemBackground` | int | 0x7f040006 | 708 |
| `actionBarPopupTheme` | int | 0x7f040007 | 711 |
| `actionBarSize` | int | 0x7f040008 | 714 |
| `actionBarSplitStyle` | int | 0x7f040009 | 717 |
| `actionBarStyle` | int | 0x7f04000a | 720 |
| `actionBarTabBarStyle` | int | 0x7f04000b | 723 |
| `actionBarTabStyle` | int | 0x7f04000c | 726 |
| `actionBarTabTextStyle` | int | 0x7f04000d | 729 |
| `actionBarTheme` | int | 0x7f04000e | 732 |
| `actionBarWidgetTheme` | int | 0x7f04000f | 735 |
| `actionButtonStyle` | int | 0x7f040010 | 738 |
| `actionDropDownStyle` | int | 0x7f040011 | 741 |
| `actionIcon` | int | 0x7f040012 | 744 |
| `actionLayout` | int | 0x7f040013 | 747 |
| `actionMenuTextAppearance` | int | 0x7f040014 | 750 |
| `actionMenuTextColor` | int | 0x7f040015 | 753 |
| `actionModeBackground` | int | 0x7f040016 | 756 |
| `actionModeCloseButtonStyle` | int | 0x7f040017 | 759 |
| `actionModeCloseContentDescription` | int | 0x7f040018 | 762 |
| `actionModeCloseDrawable` | int | 0x7f040019 | 765 |
| `actionModeCopyDrawable` | int | 0x7f04001a | 768 |
| `actionModeCutDrawable` | int | 0x7f04001b | 771 |
| `actionModeFindDrawable` | int | 0x7f04001c | 774 |
| `actionModePasteDrawable` | int | 0x7f04001d | 777 |
| `actionModePopupWindowStyle` | int | 0x7f04001e | 780 |
| `actionModeSelectAllDrawable` | int | 0x7f04001f | 783 |
| `actionModeShareDrawable` | int | 0x7f040020 | 786 |
| `actionModeSplitBackground` | int | 0x7f040021 | 789 |
| `actionModeStyle` | int | 0x7f040022 | 792 |
| `actionModeTheme` | int | 0x7f040023 | 795 |
| `actionModeWebSearchDrawable` | int | 0x7f040024 | 798 |
| `actionOverflowButtonStyle` | int | 0x7f040025 | 801 |
| `actionOverflowMenuStyle` | int | 0x7f040026 | 804 |
| `actionProviderClass` | int | 0x7f040027 | 807 |
| `actionTextColorAlpha` | int | 0x7f040028 | 810 |
| `actionViewClass` | int | 0x7f040029 | 813 |
| `activeIndicatorLabelPadding` | int | 0x7f04002a | 816 |
| `activityAction` | int | 0x7f04002b | 819 |
| `activityChooserViewStyle` | int | 0x7f04002c | 822 |
| `activityName` | int | 0x7f04002d | 825 |
| `ad_marker_color` | int | 0x7f04002e | 828 |
| `ad_marker_width` | int | 0x7f04002f | 831 |
| `addElevationShadow` | int | 0x7f040030 | 834 |
| `alertDialogButtonGroupStyle` | int | 0x7f040031 | 837 |
| `alertDialogCenterButtons` | int | 0x7f040032 | 840 |
| `alertDialogStyle` | int | 0x7f040033 | 843 |
| `alertDialogTheme` | int | 0x7f040034 | 846 |
| `allowStacking` | int | 0x7f040035 | 849 |
| `alpha` | int | 0x7f040036 | 852 |
| `alphabeticModifiers` | int | 0x7f040037 | 855 |
| `altSrc` | int | 0x7f040038 | 858 |
| `alwaysExpand` | int | 0x7f040039 | 861 |
| `ambientEnabled` | int | 0x7f04003a | 864 |
| `animateCircleAngleTo` | int | 0x7f04003b | 867 |
| `animateMenuItems` | int | 0x7f04003c | 870 |
| `animateNavigationIcon` | int | 0x7f04003d | 873 |
| `animateRelativeTo` | int | 0x7f04003e | 876 |
| `animation_enabled` | int | 0x7f040040 | 882 |
| `animationMode` | int | 0x7f04003f | 879 |
| `appBarLayoutStyle` | int | 0x7f040041 | 885 |
| `applyMotionScene` | int | 0x7f040042 | 888 |
| `arcMode` | int | 0x7f040043 | 891 |
| `argType` | int | 0x7f040044 | 894 |
| `arrowHeadLength` | int | 0x7f040045 | 897 |
| `arrowShaftLength` | int | 0x7f040046 | 900 |
| `assetName` | int | 0x7f040047 | 903 |
| `attributeName` | int | 0x7f040048 | 906 |
| `auto_show` | int | 0x7f040053 | 939 |
| `autoAdjustToWithinGrandparentBounds` | int | 0x7f040049 | 909 |
| `autoCompleteMode` | int | 0x7f04004a | 912 |
| `autoCompleteTextViewStyle` | int | 0x7f04004b | 915 |
| `autoShowKeyboard` | int | 0x7f04004c | 918 |
| `autoSizeMaxTextSize` | int | 0x7f04004d | 921 |
| `autoSizeMinTextSize` | int | 0x7f04004e | 924 |
| `autoSizePresetSizes` | int | 0x7f04004f | 927 |
| `autoSizeStepGranularity` | int | 0x7f040050 | 930 |
| `autoSizeTextType` | int | 0x7f040051 | 933 |
| `autoTransition` | int | 0x7f040052 | 936 |
| `background` | int | 0x7f040055 | 945 |
| `backgroundColor` | int | 0x7f040056 | 948 |
| `backgroundInsetBottom` | int | 0x7f040057 | 951 |
| `backgroundInsetEnd` | int | 0x7f040058 | 954 |
| `backgroundInsetStart` | int | 0x7f040059 | 957 |
| `backgroundInsetTop` | int | 0x7f04005a | 960 |
| `backgroundOverlayColorAlpha` | int | 0x7f04005b | 963 |
| `backgroundSplit` | int | 0x7f04005c | 966 |
| `backgroundStacked` | int | 0x7f04005d | 969 |
| `backgroundTint` | int | 0x7f04005e | 972 |
| `backgroundTintMode` | int | 0x7f04005f | 975 |
| `backHandlingEnabled` | int | 0x7f040054 | 942 |
| `badgeGravity` | int | 0x7f040060 | 978 |
| `badgeHeight` | int | 0x7f040061 | 981 |
| `badgeRadius` | int | 0x7f040062 | 984 |
| `badgeShapeAppearance` | int | 0x7f040063 | 987 |
| `badgeShapeAppearanceOverlay` | int | 0x7f040064 | 990 |
| `badgeStyle` | int | 0x7f040065 | 993 |
| `badgeText` | int | 0x7f040066 | 996 |
| `badgeTextAppearance` | int | 0x7f040067 | 999 |
| `badgeTextColor` | int | 0x7f040068 | 1002 |
| `badgeVerticalPadding` | int | 0x7f040069 | 1005 |
| `badgeWidePadding` | int | 0x7f04006a | 1008 |
| `badgeWidth` | int | 0x7f04006b | 1011 |
| `badgeWithTextHeight` | int | 0x7f04006c | 1014 |
| `badgeWithTextRadius` | int | 0x7f04006d | 1017 |
| `badgeWithTextShapeAppearance` | int | 0x7f04006e | 1020 |
| `badgeWithTextShapeAppearanceOverlay` | int | 0x7f04006f | 1023 |
| `badgeWithTextWidth` | int | 0x7f040070 | 1026 |
| `bar_gravity` | int | 0x7f040075 | 1032 |
| `bar_height` | int | 0x7f040076 | 1035 |
| `barLength` | int | 0x7f040072 | 1029 |
| `barrierAllowsGoneWidgets` | int | 0x7f040077 | 1038 |
| `barrierDirection` | int | 0x7f040078 | 1041 |
| `barrierMargin` | int | 0x7f040079 | 1044 |
| `behavior_autoHide` | int | 0x7f04007a | 1047 |
| `behavior_autoShrink` | int | 0x7f04007b | 1050 |
| `behavior_draggable` | int | 0x7f04007c | 1053 |
| `behavior_expandedOffset` | int | 0x7f04007d | 1056 |
| `behavior_fitToContents` | int | 0x7f04007e | 1059 |
| `behavior_halfExpandedRatio` | int | 0x7f04007f | 1062 |
| `behavior_hideable` | int | 0x7f040080 | 1065 |
| `behavior_overlapTop` | int | 0x7f040081 | 1068 |
| `behavior_peekHeight` | int | 0x7f040082 | 1071 |
| `behavior_saveFlags` | int | 0x7f040083 | 1074 |
| `behavior_significantVelocityThreshold` | int | 0x7f040084 | 1077 |
| `behavior_skipCollapsed` | int | 0x7f040085 | 1080 |
| `blendSrc` | int | 0x7f040086 | 1083 |
| `borderlessButtonStyle` | int | 0x7f04008a | 1095 |
| `borderRound` | int | 0x7f040087 | 1086 |
| `borderRoundPercent` | int | 0x7f040088 | 1089 |
| `borderWidth` | int | 0x7f040089 | 1092 |
| `bottomAppBarStyle` | int | 0x7f04008b | 1098 |
| `bottomInsetScrimEnabled` | int | 0x7f04008c | 1101 |
| `bottomLeftRadius` | int | 0x7f04008d | 1104 |
| `bottomNavigationStyle` | int | 0x7f04008e | 1107 |
| `bottomRightRadius` | int | 0x7f04008f | 1110 |
| `bottomSheetDialogTheme` | int | 0x7f040090 | 1113 |
| `bottomSheetDragHandleStyle` | int | 0x7f040091 | 1116 |
| `bottomSheetStyle` | int | 0x7f040092 | 1119 |
| `boxBackgroundColor` | int | 0x7f040093 | 1122 |
| `boxBackgroundMode` | int | 0x7f040094 | 1125 |
| `boxCollapsedPaddingTop` | int | 0x7f040095 | 1128 |
| `boxCornerRadiusBottomEnd` | int | 0x7f040096 | 1131 |
| `boxCornerRadiusBottomStart` | int | 0x7f040097 | 1134 |
| `boxCornerRadiusTopEnd` | int | 0x7f040098 | 1137 |
| `boxCornerRadiusTopStart` | int | 0x7f040099 | 1140 |
| `boxStrokeColor` | int | 0x7f04009a | 1143 |
| `boxStrokeErrorColor` | int | 0x7f04009b | 1146 |
| `boxStrokeWidth` | int | 0x7f04009c | 1149 |
| `boxStrokeWidthFocused` | int | 0x7f04009d | 1152 |
| `brightness` | int | 0x7f04009e | 1155 |
| `buffered_color` | int | 0x7f04009f | 1158 |
| `buttonBarButtonStyle` | int | 0x7f0400a0 | 1161 |
| `buttonBarNegativeButtonStyle` | int | 0x7f0400a1 | 1164 |
| `buttonBarNeutralButtonStyle` | int | 0x7f0400a2 | 1167 |
| `buttonBarPositiveButtonStyle` | int | 0x7f0400a3 | 1170 |
| `buttonBarStyle` | int | 0x7f0400a4 | 1173 |
| `buttonCompat` | int | 0x7f0400a5 | 1176 |
| `buttonGravity` | int | 0x7f0400a6 | 1179 |
| `buttonIcon` | int | 0x7f0400a7 | 1182 |
| `buttonIconDimen` | int | 0x7f0400a8 | 1185 |
| `buttonIconTint` | int | 0x7f0400a9 | 1188 |
| `buttonIconTintMode` | int | 0x7f0400aa | 1191 |
| `buttonPanelSideLayout` | int | 0x7f0400ab | 1194 |
| `buttonSize` | int | 0x7f0400ac | 1197 |
| `buttonStyle` | int | 0x7f0400ad | 1200 |
| `buttonStyleSmall` | int | 0x7f0400ae | 1203 |
| `buttonTint` | int | 0x7f0400af | 1206 |
| `buttonTintMode` | int | 0x7f0400b0 | 1209 |
| `calendar_content_view_id` | int | 0x7f0400b1 | 1212 |
| `calendar_height` | int | 0x7f0400b2 | 1215 |
| `calendar_match_parent` | int | 0x7f0400b3 | 1218 |
| `calendar_padding` | int | 0x7f0400b4 | 1221 |
| `calendar_padding_left` | int | 0x7f0400b5 | 1224 |
| `calendar_padding_right` | int | 0x7f0400b6 | 1227 |
| `calendar_show_mode` | int | 0x7f0400b7 | 1230 |
| `cameraBearing` | int | 0x7f0400b8 | 1233 |
| `cameraMaxZoomPreference` | int | 0x7f0400b9 | 1236 |
| `cameraMinZoomPreference` | int | 0x7f0400ba | 1239 |
| `cameraTargetLat` | int | 0x7f0400bb | 1242 |
| `cameraTargetLng` | int | 0x7f0400bc | 1245 |
| `cameraTilt` | int | 0x7f0400bd | 1248 |
| `cameraZoom` | int | 0x7f0400be | 1251 |
| `carColorPrimary` | int | 0x7f0400bf | 1254 |
| `carColorPrimaryDark` | int | 0x7f0400c0 | 1257 |
| `carColorSecondary` | int | 0x7f0400c1 | 1260 |
| `carColorSecondaryDark` | int | 0x7f0400c2 | 1263 |
| `cardBackgroundColor` | int | 0x7f0400c4 | 1269 |
| `cardCornerRadius` | int | 0x7f0400c5 | 1272 |
| `cardElevation` | int | 0x7f0400c6 | 1275 |
| `cardForegroundColor` | int | 0x7f0400c7 | 1278 |
| `cardMaxElevation` | int | 0x7f0400c8 | 1281 |
| `cardPreventCornerOverlap` | int | 0x7f0400c9 | 1284 |
| `cardUseCompatPadding` | int | 0x7f0400ca | 1287 |
| `cardViewStyle` | int | 0x7f0400cb | 1290 |
| `carousel_backwardTransition` | int | 0x7f0400cc | 1293 |
| `carousel_emptyViewsBehavior` | int | 0x7f0400cd | 1296 |
| `carousel_firstView` | int | 0x7f0400ce | 1299 |
| `carousel_forwardTransition` | int | 0x7f0400cf | 1302 |
| `carousel_infinite` | int | 0x7f0400d0 | 1305 |
| `carousel_nextState` | int | 0x7f0400d1 | 1308 |
| `carousel_previousState` | int | 0x7f0400d2 | 1311 |
| `carousel_touchUp_dampeningFactor` | int | 0x7f0400d4 | 1317 |
| `carousel_touchUp_velocityThreshold` | int | 0x7f0400d5 | 1320 |
| `carousel_touchUpMode` | int | 0x7f0400d3 | 1314 |
| `carPermissionActivityLayout` | int | 0x7f0400c3 | 1266 |
| `centerIfNoTextEnabled` | int | 0x7f0400d6 | 1323 |
| `chainUseRtl` | int | 0x7f0400d7 | 1326 |
| `checkboxStyle` | int | 0x7f0400db | 1338 |
| `checkedButton` | int | 0x7f0400dc | 1341 |
| `checkedChip` | int | 0x7f0400dd | 1344 |
| `checkedIcon` | int | 0x7f0400de | 1347 |
| `checkedIconEnabled` | int | 0x7f0400df | 1350 |
| `checkedIconGravity` | int | 0x7f0400e0 | 1353 |
| `checkedIconMargin` | int | 0x7f0400e1 | 1356 |
| `checkedIconSize` | int | 0x7f0400e2 | 1359 |
| `checkedIconTint` | int | 0x7f0400e3 | 1362 |
| `checkedIconVisible` | int | 0x7f0400e4 | 1365 |
| `checkedState` | int | 0x7f0400e5 | 1368 |
| `checkedTextViewStyle` | int | 0x7f0400e6 | 1371 |
| `checkMarkCompat` | int | 0x7f0400d8 | 1329 |
| `checkMarkTint` | int | 0x7f0400d9 | 1332 |
| `checkMarkTintMode` | int | 0x7f0400da | 1335 |
| `chipBackgroundColor` | int | 0x7f0400e7 | 1374 |
| `chipCornerRadius` | int | 0x7f0400e8 | 1377 |
| `chipEndPadding` | int | 0x7f0400e9 | 1380 |
| `chipGroupStyle` | int | 0x7f0400ea | 1383 |
| `chipIcon` | int | 0x7f0400eb | 1386 |
| `chipIconEnabled` | int | 0x7f0400ec | 1389 |
| `chipIconSize` | int | 0x7f0400ed | 1392 |
| `chipIconTint` | int | 0x7f0400ee | 1395 |
| `chipIconVisible` | int | 0x7f0400ef | 1398 |
| `chipMinHeight` | int | 0x7f0400f0 | 1401 |
| `chipMinTouchTargetSize` | int | 0x7f0400f1 | 1404 |
| `chipSpacing` | int | 0x7f0400f2 | 1407 |
| `chipSpacingHorizontal` | int | 0x7f0400f3 | 1410 |
| `chipSpacingVertical` | int | 0x7f0400f4 | 1413 |
| `chipStandaloneStyle` | int | 0x7f0400f5 | 1416 |
| `chipStartPadding` | int | 0x7f0400f6 | 1419 |
| `chipStrokeColor` | int | 0x7f0400f7 | 1422 |
| `chipStrokeWidth` | int | 0x7f0400f8 | 1425 |
| `chipStyle` | int | 0x7f0400f9 | 1428 |
| `chipSurfaceColor` | int | 0x7f0400fa | 1431 |
| `circleCrop` | int | 0x7f0400fc | 1434 |
| `circleRadius` | int | 0x7f0400fd | 1437 |
| `circularflow_angles` | int | 0x7f0400ff | 1443 |
| `circularflow_defaultAngle` | int | 0x7f040100 | 1446 |
| `circularflow_defaultRadius` | int | 0x7f040101 | 1449 |
| `circularflow_radiusInDP` | int | 0x7f040102 | 1452 |
| `circularflow_viewCenter` | int | 0x7f040103 | 1455 |
| `circularProgressIndicatorStyle` | int | 0x7f0400fe | 1440 |
| `clearsTag` | int | 0x7f040105 | 1461 |
| `clearTop` | int | 0x7f040104 | 1458 |
| `clickAction` | int | 0x7f040106 | 1464 |
| `clockFaceBackgroundColor` | int | 0x7f040107 | 1467 |
| `clockHandColor` | int | 0x7f040108 | 1470 |
| `clockIcon` | int | 0x7f040109 | 1473 |
| `clockNumberTextColor` | int | 0x7f04010a | 1476 |
| `closeIcon` | int | 0x7f04010b | 1479 |
| `closeIconEnabled` | int | 0x7f04010c | 1482 |
| `closeIconEndPadding` | int | 0x7f04010d | 1485 |
| `closeIconSize` | int | 0x7f04010e | 1488 |
| `closeIconStartPadding` | int | 0x7f04010f | 1491 |
| `closeIconTint` | int | 0x7f040110 | 1494 |
| `closeIconVisible` | int | 0x7f040111 | 1497 |
| `closeItemLayout` | int | 0x7f040112 | 1500 |
| `collapseContentDescription` | int | 0x7f040116 | 1503 |
| `collapsedSize` | int | 0x7f040118 | 1509 |
| `collapsedTitleGravity` | int | 0x7f040119 | 1512 |
| `collapsedTitleTextAppearance` | int | 0x7f04011a | 1515 |
| `collapsedTitleTextColor` | int | 0x7f04011b | 1518 |
| `collapseIcon` | int | 0x7f040117 | 1506 |
| `collapsingToolbarLayoutLargeSize` | int | 0x7f04011c | 1521 |
| `collapsingToolbarLayoutLargeStyle` | int | 0x7f04011d | 1524 |
| `collapsingToolbarLayoutMediumSize` | int | 0x7f04011e | 1527 |
| `collapsingToolbarLayoutMediumStyle` | int | 0x7f04011f | 1530 |
| `collapsingToolbarLayoutStyle` | int | 0x7f040120 | 1533 |
| `color` | int | 0x7f040121 | 1536 |
| `color_bar` | int | 0x7f04015f | 1722 |
| `color_indicator` | int | 0x7f040160 | 1725 |
| `color_one` | int | 0x7f040161 | 1728 |
| `color_second` | int | 0x7f040162 | 1731 |
| `colorAccent` | int | 0x7f040122 | 1539 |
| `colorBackgroundFloating` | int | 0x7f040123 | 1542 |
| `colorButtonNormal` | int | 0x7f040124 | 1545 |
| `colorContainer` | int | 0x7f040125 | 1548 |
| `colorControlActivated` | int | 0x7f040126 | 1551 |
| `colorControlHighlight` | int | 0x7f040127 | 1554 |
| `colorControlNormal` | int | 0x7f040128 | 1557 |
| `colorError` | int | 0x7f040129 | 1560 |
| `colorErrorContainer` | int | 0x7f04012a | 1563 |
| `colorOnBackground` | int | 0x7f04012b | 1566 |
| `colorOnContainer` | int | 0x7f04012c | 1569 |
| `colorOnContainerUnchecked` | int | 0x7f04012d | 1572 |
| `colorOnError` | int | 0x7f04012e | 1575 |
| `colorOnErrorContainer` | int | 0x7f04012f | 1578 |
| `colorOnPrimary` | int | 0x7f040130 | 1581 |
| `colorOnPrimaryContainer` | int | 0x7f040131 | 1584 |
| `colorOnPrimaryFixed` | int | 0x7f040132 | 1587 |
| `colorOnPrimaryFixedVariant` | int | 0x7f040133 | 1590 |
| `colorOnPrimarySurface` | int | 0x7f040134 | 1593 |
| `colorOnSecondary` | int | 0x7f040135 | 1596 |
| `colorOnSecondaryContainer` | int | 0x7f040136 | 1599 |
| `colorOnSecondaryFixed` | int | 0x7f040137 | 1602 |
| `colorOnSecondaryFixedVariant` | int | 0x7f040138 | 1605 |
| `colorOnSurface` | int | 0x7f040139 | 1608 |
| `colorOnSurfaceInverse` | int | 0x7f04013a | 1611 |
| `colorOnSurfaceVariant` | int | 0x7f04013b | 1614 |
| `colorOnTertiary` | int | 0x7f04013c | 1617 |
| `colorOnTertiaryContainer` | int | 0x7f04013d | 1620 |
| `colorOnTertiaryFixed` | int | 0x7f04013e | 1623 |
| `colorOnTertiaryFixedVariant` | int | 0x7f04013f | 1626 |
| `colorOutline` | int | 0x7f040140 | 1629 |
| `colorOutlineVariant` | int | 0x7f040141 | 1632 |
| `colorPrimary` | int | 0x7f040142 | 1635 |
| `colorPrimaryContainer` | int | 0x7f040143 | 1638 |
| `colorPrimaryDark` | int | 0x7f040144 | 1641 |
| `colorPrimaryFixed` | int | 0x7f040145 | 1644 |
| `colorPrimaryFixedDim` | int | 0x7f040146 | 1647 |
| `colorPrimaryInverse` | int | 0x7f040147 | 1650 |
| `colorPrimarySurface` | int | 0x7f040148 | 1653 |
| `colorPrimaryVariant` | int | 0x7f040149 | 1656 |
| `colorScheme` | int | 0x7f04014a | 1659 |
| `colorSecondary` | int | 0x7f04014b | 1662 |
| `colorSecondaryContainer` | int | 0x7f04014c | 1665 |
| `colorSecondaryFixed` | int | 0x7f04014d | 1668 |
| `colorSecondaryFixedDim` | int | 0x7f04014e | 1671 |
| `colorSecondaryVariant` | int | 0x7f04014f | 1674 |
| `colorSurface` | int | 0x7f040150 | 1677 |
| `colorSurfaceBright` | int | 0x7f040151 | 1680 |
| `colorSurfaceContainer` | int | 0x7f040152 | 1683 |
| `colorSurfaceContainerHigh` | int | 0x7f040153 | 1686 |
| `colorSurfaceContainerHighest` | int | 0x7f040154 | 1689 |
| `colorSurfaceContainerLow` | int | 0x7f040155 | 1692 |
| `colorSurfaceContainerLowest` | int | 0x7f040156 | 1695 |
| `colorSurfaceDim` | int | 0x7f040157 | 1698 |
| `colorSurfaceInverse` | int | 0x7f040158 | 1701 |
| `colorSurfaceVariant` | int | 0x7f040159 | 1704 |
| `colorSwitchThumbNormal` | int | 0x7f04015a | 1707 |
| `colorTertiary` | int | 0x7f04015b | 1710 |
| `colorTertiaryContainer` | int | 0x7f04015c | 1713 |
| `colorTertiaryFixed` | int | 0x7f04015d | 1716 |
| `colorTertiaryFixedDim` | int | 0x7f04015e | 1719 |
| `commitIcon` | int | 0x7f040163 | 1734 |
| `compatShadowEnabled` | int | 0x7f040164 | 1737 |
| `constraint_referenced_ids` | int | 0x7f04016c | 1752 |
| `constraint_referenced_tags` | int | 0x7f04016d | 1755 |
| `constraintRotate` | int | 0x7f040168 | 1740 |
| `constraints` | int | 0x7f04016e | 1758 |
| `constraintSet` | int | 0x7f040169 | 1743 |
| `constraintSetEnd` | int | 0x7f04016a | 1746 |
| `constraintSetStart` | int | 0x7f04016b | 1749 |
| `content` | int | 0x7f04016f | 1761 |
| `contentDescription` | int | 0x7f040170 | 1764 |
| `contentInsetEnd` | int | 0x7f040171 | 1767 |
| `contentInsetEndWithActions` | int | 0x7f040172 | 1770 |
| `contentInsetLeft` | int | 0x7f040173 | 1773 |
| `contentInsetRight` | int | 0x7f040174 | 1776 |
| `contentInsetStart` | int | 0x7f040175 | 1779 |
| `contentInsetStartWithNavigation` | int | 0x7f040176 | 1782 |
| `contentPadding` | int | 0x7f040177 | 1785 |
| `contentPaddingBottom` | int | 0x7f040178 | 1788 |
| `contentPaddingEnd` | int | 0x7f040179 | 1791 |
| `contentPaddingLeft` | int | 0x7f04017a | 1794 |
| `contentPaddingRight` | int | 0x7f04017b | 1797 |
| `contentPaddingStart` | int | 0x7f04017c | 1800 |
| `contentPaddingTop` | int | 0x7f04017d | 1803 |
| `contentScrim` | int | 0x7f04017e | 1806 |
| `contrast` | int | 0x7f040181 | 1809 |
| `controlBackground` | int | 0x7f040182 | 1812 |
| `controller_layout_id` | int | 0x7f040183 | 1815 |
| `coordinatorLayoutStyle` | int | 0x7f040184 | 1818 |
| `coplanarSiblingViewId` | int | 0x7f040185 | 1821 |
| `cornerFamily` | int | 0x7f040186 | 1824 |
| `cornerFamilyBottomLeft` | int | 0x7f040187 | 1827 |
| `cornerFamilyBottomRight` | int | 0x7f040188 | 1830 |
| `cornerFamilyTopLeft` | int | 0x7f040189 | 1833 |
| `cornerFamilyTopRight` | int | 0x7f04018a | 1836 |
| `cornerRadius` | int | 0x7f04018b | 1839 |
| `cornerSize` | int | 0x7f04018c | 1842 |
| `cornerSizeBottomLeft` | int | 0x7f04018d | 1845 |
| `cornerSizeBottomRight` | int | 0x7f04018e | 1848 |
| `cornerSizeTopLeft` | int | 0x7f04018f | 1851 |
| `cornerSizeTopRight` | int | 0x7f040190 | 1854 |
| `counterEnabled` | int | 0x7f040191 | 1857 |
| `counterMaxLength` | int | 0x7f040192 | 1860 |
| `counterOverflowTextAppearance` | int | 0x7f040193 | 1863 |
| `counterOverflowTextColor` | int | 0x7f040194 | 1866 |
| `counterTextAppearance` | int | 0x7f040195 | 1869 |
| `counterTextColor` | int | 0x7f040196 | 1872 |
| `crossfade` | int | 0x7f040197 | 1875 |
| `current_day_lunar_text_color` | int | 0x7f040199 | 1881 |
| `current_day_text_color` | int | 0x7f04019a | 1884 |
| `current_month_lunar_text_color` | int | 0x7f04019b | 1887 |
| `current_month_text_color` | int | 0x7f04019c | 1890 |
| `currentState` | int | 0x7f040198 | 1878 |
| `cursorColor` | int | 0x7f04019d | 1893 |
| `cursorErrorColor` | int | 0x7f04019e | 1896 |
| `curveFit` | int | 0x7f04019f | 1899 |
| `customBoolean` | int | 0x7f0401a0 | 1902 |
| `customColorDrawableValue` | int | 0x7f0401a1 | 1905 |
| `customColorValue` | int | 0x7f0401a2 | 1908 |
| `customDimension` | int | 0x7f0401a3 | 1911 |
| `customFloatValue` | int | 0x7f0401a4 | 1914 |
| `customIntegerValue` | int | 0x7f0401a5 | 1917 |
| `customNavigationLayout` | int | 0x7f0401a6 | 1920 |
| `customPixelDimension` | int | 0x7f0401a7 | 1923 |
| `customReference` | int | 0x7f0401a8 | 1926 |
| `customStringValue` | int | 0x7f0401a9 | 1929 |
| `cy_angle` | int | 0x7f0401aa | 1932 |
| `cy_backgroundChecked` | int | 0x7f0401ab | 1935 |
| `cy_backgroundUnChecked` | int | 0x7f0401ac | 1938 |
| `cy_baseOnWidthOrHeight` | int | 0x7f0401ad | 1941 |
| `cy_bgChecked` | int | 0x7f0401ae | 1944 |
| `cy_bgColor` | int | 0x7f0401af | 1947 |
| `cy_bgUnChecked` | int | 0x7f0401b0 | 1950 |
| `cy_blur_radius` | int | 0x7f0401b1 | 1953 |
| `cy_buttonChecked` | int | 0x7f0401b2 | 1956 |
| `cy_buttonUnChecked` | int | 0x7f0401b3 | 1959 |
| `cy_cardBackgroundColor` | int | 0x7f0401b4 | 1962 |
| `cy_cardCornerRadius` | int | 0x7f0401b5 | 1965 |
| `cy_cardElevation` | int | 0x7f0401b6 | 1968 |
| `cy_cardMaxElevation` | int | 0x7f0401b7 | 1971 |
| `cy_cardPreventCornerOverlap` | int | 0x7f0401b8 | 1974 |
| `cy_cardUseCompatPadding` | int | 0x7f0401b9 | 1977 |
| `cy_centerX` | int | 0x7f0401ba | 1980 |
| `cy_centerY` | int | 0x7f0401bb | 1983 |
| `cy_checked` | int | 0x7f0401bc | 1986 |
| `cy_checked_` | int | 0x7f0401bd | 1989 |
| `cy_clip_background` | int | 0x7f0401be | 1992 |
| `cy_color_bg` | int | 0x7f0401c3 | 2007 |
| `cy_color_end` | int | 0x7f0401c4 | 2010 |
| `cy_color_fg` | int | 0x7f0401c5 | 2013 |
| `cy_color_filter` | int | 0x7f0401c6 | 2016 |
| `cy_color_indicator` | int | 0x7f0401c7 | 2019 |
| `cy_color_progress` | int | 0x7f0401c8 | 2022 |
| `cy_color_shadow` | int | 0x7f0401c9 | 2025 |
| `cy_color_start` | int | 0x7f0401ca | 2028 |
| `cy_color_stroke` | int | 0x7f0401cb | 2031 |
| `cy_color_tint` | int | 0x7f0401cc | 2034 |
| `cy_colorEnd` | int | 0x7f0401bf | 1995 |
| `cy_colorFill` | int | 0x7f0401c0 | 1998 |
| `cy_colorRipple` | int | 0x7f0401c1 | 2001 |
| `cy_colorStart` | int | 0x7f0401c2 | 2004 |
| `cy_contentPadding` | int | 0x7f0401cd | 2037 |
| `cy_contentPaddingBottom` | int | 0x7f0401ce | 2040 |
| `cy_contentPaddingLeft` | int | 0x7f0401cf | 2043 |
| `cy_contentPaddingRight` | int | 0x7f0401d0 | 2046 |
| `cy_contentPaddingTop` | int | 0x7f0401d1 | 2049 |
| `cy_cornerRadius` | int | 0x7f0401d2 | 2052 |
| `cy_gradientType` | int | 0x7f0401d3 | 2055 |
| `cy_haveFilter` | int | 0x7f0401d4 | 2058 |
| `cy_haveRipple` | int | 0x7f0401d5 | 2061 |
| `cy_height_indicator` | int | 0x7f0401d7 | 2067 |
| `cy_height_percent` | int | 0x7f0401d8 | 2070 |
| `cy_heightWidthRatio` | int | 0x7f0401d6 | 2064 |
| `cy_indicator_radius_normal` | int | 0x7f0401d9 | 2073 |
| `cy_indicator_radius_selected` | int | 0x7f0401da | 2076 |
| `cy_indicator_space` | int | 0x7f0401db | 2079 |
| `cy_indicator_style` | int | 0x7f0401dc | 2082 |
| `cy_isMax2Height` | int | 0x7f0401dd | 2085 |
| `cy_isMax2Width` | int | 0x7f0401de | 2088 |
| `cy_leftTextColor` | int | 0x7f0401df | 2091 |
| `cy_lightNumber` | int | 0x7f0401e0 | 2094 |
| `cy_lightOrDark` | int | 0x7f0401e1 | 2097 |
| `cy_mask_type` | int | 0x7f0401e2 | 2100 |
| `cy_maxProgress` | int | 0x7f0401e3 | 2103 |
| `cy_orientationGradient` | int | 0x7f0401e4 | 2106 |
| `cy_paint_stroke_width` | int | 0x7f0401e5 | 2109 |
| `cy_paint_style` | int | 0x7f0401e6 | 2112 |
| `cy_progress` | int | 0x7f0401e7 | 2115 |
| `cy_progressColor` | int | 0x7f0401e8 | 2118 |
| `cy_radius_indicator` | int | 0x7f0401ef | 2139 |
| `cy_radiusBottomLeft` | int | 0x7f0401e9 | 2121 |
| `cy_radiusBottomRight` | int | 0x7f0401ea | 2124 |
| `cy_radiusCorner` | int | 0x7f0401eb | 2127 |
| `cy_radiusGradient` | int | 0x7f0401ec | 2130 |
| `cy_radiusTopLeft` | int | 0x7f0401ed | 2133 |
| `cy_radiusTopRight` | int | 0x7f0401ee | 2136 |
| `cy_rightTextColor` | int | 0x7f0401f0 | 2142 |
| `cy_round_as_circle` | int | 0x7f0401f1 | 2145 |
| `cy_scaleType` | int | 0x7f0401f2 | 2148 |
| `cy_scrollable` | int | 0x7f0401f3 | 2151 |
| `cy_shadow_dx` | int | 0x7f0401f4 | 2154 |
| `cy_shadow_dy` | int | 0x7f0401f5 | 2157 |
| `cy_shadow_limit` | int | 0x7f0401f6 | 2160 |
| `cy_shadow_radius` | int | 0x7f0401f7 | 2163 |
| `cy_shapeType` | int | 0x7f0401f8 | 2166 |
| `cy_shimmer_angle` | int | 0x7f0401f9 | 2169 |
| `cy_shimmer_animation_duration` | int | 0x7f0401fa | 2172 |
| `cy_shimmer_auto_start` | int | 0x7f0401fb | 2175 |
| `cy_shimmer_color` | int | 0x7f0401fc | 2178 |
| `cy_shimmer_gradient_center_color_width` | int | 0x7f0401fd | 2181 |
| `cy_shimmer_mask_width` | int | 0x7f0401fe | 2184 |
| `cy_shimmer_reverse_animation` | int | 0x7f0401ff | 2187 |
| `cy_space_horizontal` | int | 0x7f040200 | 2190 |
| `cy_space_vertical` | int | 0x7f040201 | 2193 |
| `cy_src` | int | 0x7f040202 | 2196 |
| `cy_srcChecked` | int | 0x7f040203 | 2199 |
| `cy_srcUnChecked` | int | 0x7f040204 | 2202 |
| `cy_stroke_color` | int | 0x7f04020d | 2229 |
| `cy_stroke_width` | int | 0x7f04020e | 2232 |
| `cy_strokeColor` | int | 0x7f040205 | 2205 |
| `cy_strokeDashGap` | int | 0x7f040206 | 2208 |
| `cy_strokeDashWidth` | int | 0x7f040207 | 2211 |
| `cy_strokePaddingBottom` | int | 0x7f040208 | 2214 |
| `cy_strokePaddingLeft` | int | 0x7f040209 | 2217 |
| `cy_strokePaddingRight` | int | 0x7f04020a | 2220 |
| `cy_strokePaddingTop` | int | 0x7f04020b | 2223 |
| `cy_strokeWidth` | int | 0x7f04020c | 2226 |
| `cy_textChecked` | int | 0x7f04020f | 2235 |
| `cy_textColorChecked` | int | 0x7f040210 | 2238 |
| `cy_textColorNormal` | int | 0x7f040211 | 2241 |
| `cy_textColorSelected` | int | 0x7f040212 | 2244 |
| `cy_textColorUnChecked` | int | 0x7f040213 | 2247 |
| `cy_textUnChecked` | int | 0x7f040214 | 2250 |
| `cy_width_indicator_max` | int | 0x7f040215 | 2253 |
| `cy_width_indicator_selected` | int | 0x7f040216 | 2256 |
| `cy_width_percent` | int | 0x7f040217 | 2259 |
| `cy_width_stroke` | int | 0x7f040218 | 2262 |
| `data` | int | 0x7f040219 | 2265 |
| `dataPattern` | int | 0x7f04021a | 2268 |
| `day_text_size` | int | 0x7f04021f | 2283 |
| `dayInvalidStyle` | int | 0x7f04021b | 2271 |
| `daySelectedStyle` | int | 0x7f04021c | 2274 |
| `dayStyle` | int | 0x7f04021d | 2277 |
| `dayTodayStyle` | int | 0x7f04021e | 2280 |
| `decorationColor` | int | 0x7f040220 | 2286 |
| `default_artwork` | int | 0x7f040227 | 2307 |
| `default_status` | int | 0x7f040228 | 2310 |
| `defaultDuration` | int | 0x7f040221 | 2289 |
| `defaultMarginsEnabled` | int | 0x7f040222 | 2292 |
| `defaultNavHost` | int | 0x7f040223 | 2295 |
| `defaultQueryHint` | int | 0x7f040224 | 2298 |
| `defaultScrollFlagsEnabled` | int | 0x7f040225 | 2301 |
| `defaultState` | int | 0x7f040226 | 2304 |
| `deltaPolarAngle` | int | 0x7f04022a | 2313 |
| `deltaPolarRadius` | int | 0x7f04022b | 2316 |
| `deriveConstraintsFrom` | int | 0x7f04022c | 2319 |
| `destination` | int | 0x7f04022d | 2322 |
| `dialogCornerRadius` | int | 0x7f04022f | 2325 |
| `dialogPreferredPadding` | int | 0x7f040231 | 2328 |
| `dialogTheme` | int | 0x7f040232 | 2331 |
| `displayOptions` | int | 0x7f04023c | 2334 |
| `divider` | int | 0x7f04023d | 2337 |
| `dividerColor` | int | 0x7f04023e | 2340 |
| `dividerHorizontal` | int | 0x7f04023f | 2343 |
| `dividerInsetEnd` | int | 0x7f040240 | 2346 |
| `dividerInsetStart` | int | 0x7f040241 | 2349 |
| `dividerPadding` | int | 0x7f040242 | 2352 |
| `dividerThickness` | int | 0x7f040243 | 2355 |
| `dividerVertical` | int | 0x7f040244 | 2358 |
| `download_bg_line_color` | int | 0x7f040245 | 2361 |
| `download_bg_line_width` | int | 0x7f040246 | 2364 |
| `download_line_color` | int | 0x7f040247 | 2367 |
| `download_line_width` | int | 0x7f040248 | 2370 |
| `download_text_color` | int | 0x7f040249 | 2373 |
| `download_text_size` | int | 0x7f04024a | 2376 |
| `dragDirection` | int | 0x7f04024b | 2379 |
| `dragScale` | int | 0x7f04024c | 2382 |
| `dragThreshold` | int | 0x7f04024d | 2385 |
| `drawableBottomCompat` | int | 0x7f04024f | 2391 |
| `drawableEndCompat` | int | 0x7f040250 | 2394 |
| `drawableLeftCompat` | int | 0x7f040251 | 2397 |
| `drawableRightCompat` | int | 0x7f040252 | 2400 |
| `drawableSize` | int | 0x7f040253 | 2403 |
| `drawableStartCompat` | int | 0x7f040254 | 2406 |
| `drawableTint` | int | 0x7f040255 | 2409 |
| `drawableTintMode` | int | 0x7f040256 | 2412 |
| `drawableTopCompat` | int | 0x7f040257 | 2415 |
| `drawerArrowStyle` | int | 0x7f040258 | 2418 |
| `drawerLayoutCornerSize` | int | 0x7f040259 | 2421 |
| `drawerLayoutStyle` | int | 0x7f04025a | 2424 |
| `drawPath` | int | 0x7f04024e | 2388 |
| `dropDownBackgroundTint` | int | 0x7f04025b | 2427 |
| `dropdownListPreferredItemHeight` | int | 0x7f04025d | 2433 |
| `dropDownListViewStyle` | int | 0x7f04025c | 2430 |
| `duration` | int | 0x7f04025e | 2436 |
| `dynamicColorThemeOverlay` | int | 0x7f04025f | 2439 |
| `editTextBackground` | int | 0x7f040260 | 2442 |
| `editTextColor` | int | 0x7f040261 | 2445 |
| `editTextStyle` | int | 0x7f040262 | 2448 |
| `elevation` | int | 0x7f040263 | 2451 |
| `elevationOverlayAccentColor` | int | 0x7f040264 | 2454 |
| `elevationOverlayColor` | int | 0x7f040265 | 2457 |
| `elevationOverlayEnabled` | int | 0x7f040266 | 2460 |
| `emojiCompatEnabled` | int | 0x7f040267 | 2463 |
| `enableEdgeToEdge` | int | 0x7f040268 | 2466 |
| `endIconCheckable` | int | 0x7f040269 | 2469 |
| `endIconContentDescription` | int | 0x7f04026a | 2472 |
| `endIconDrawable` | int | 0x7f04026b | 2475 |
| `endIconMinSize` | int | 0x7f04026c | 2478 |
| `endIconMode` | int | 0x7f04026d | 2481 |
| `endIconScaleType` | int | 0x7f04026e | 2484 |
| `endIconTint` | int | 0x7f04026f | 2487 |
| `endIconTintMode` | int | 0x7f040270 | 2490 |
| `enforceMaterialTheme` | int | 0x7f040271 | 2493 |
| `enforceTextAppearance` | int | 0x7f040272 | 2496 |
| `ensureMinTouchTargetSize` | int | 0x7f040273 | 2499 |
| `enterAnim` | int | 0x7f040274 | 2502 |
| `errorAccessibilityLabel` | int | 0x7f040275 | 2505 |
| `errorAccessibilityLiveRegion` | int | 0x7f040276 | 2508 |
| `errorContentDescription` | int | 0x7f040277 | 2511 |
| `errorEnabled` | int | 0x7f040278 | 2514 |
| `errorIconDrawable` | int | 0x7f040279 | 2517 |
| `errorIconTint` | int | 0x7f04027a | 2520 |
| `errorIconTintMode` | int | 0x7f04027b | 2523 |
| `errorShown` | int | 0x7f04027c | 2526 |
| `errorTextAppearance` | int | 0x7f04027d | 2529 |
| `errorTextColor` | int | 0x7f04027e | 2532 |
| `exitAnim` | int | 0x7f04027f | 2535 |
| `expandActivityOverflowButtonDrawable` | int | 0x7f040280 | 2538 |
| `expanded` | int | 0x7f040281 | 2541 |
| `expandedHintEnabled` | int | 0x7f040282 | 2544 |
| `expandedTitleGravity` | int | 0x7f040283 | 2547 |
| `expandedTitleMargin` | int | 0x7f040284 | 2550 |
| `expandedTitleMarginBottom` | int | 0x7f040285 | 2553 |
| `expandedTitleMarginEnd` | int | 0x7f040286 | 2556 |
| `expandedTitleMarginStart` | int | 0x7f040287 | 2559 |
| `expandedTitleMarginTop` | int | 0x7f040288 | 2562 |
| `expandedTitleTextAppearance` | int | 0x7f040289 | 2565 |
| `expandedTitleTextColor` | int | 0x7f04028a | 2568 |
| `extendedFloatingActionButtonPrimaryStyle` | int | 0x7f04028d | 2577 |
| `extendedFloatingActionButtonSecondaryStyle` | int | 0x7f04028e | 2580 |
| `extendedFloatingActionButtonStyle` | int | 0x7f04028f | 2583 |
| `extendedFloatingActionButtonSurfaceStyle` | int | 0x7f040290 | 2586 |
| `extendedFloatingActionButtonTertiaryStyle` | int | 0x7f040291 | 2589 |
| `extendMotionSpec` | int | 0x7f04028b | 2571 |
| `extendStrategy` | int | 0x7f04028c | 2574 |
| `extraMultilineHeightEnabled` | int | 0x7f040292 | 2592 |
| `fabAlignmentMode` | int | 0x7f040293 | 2595 |
| `fabAlignmentModeEndMargin` | int | 0x7f040294 | 2598 |
| `fabAnchorMode` | int | 0x7f040295 | 2601 |
| `fabAnimationMode` | int | 0x7f040296 | 2604 |
| `fabCradleMargin` | int | 0x7f040297 | 2607 |
| `fabCradleRoundedCornerRadius` | int | 0x7f040298 | 2610 |
| `fabCradleVerticalOffset` | int | 0x7f040299 | 2613 |
| `fabCustomSize` | int | 0x7f04029a | 2616 |
| `fabSize` | int | 0x7f04029b | 2619 |
| `fastScrollEnabled` | int | 0x7f04029c | 2622 |
| `fastScrollHorizontalThumbDrawable` | int | 0x7f04029d | 2625 |
| `fastScrollHorizontalTrackDrawable` | int | 0x7f04029e | 2628 |
| `fastScrollVerticalThumbDrawable` | int | 0x7f04029f | 2631 |
| `fastScrollVerticalTrackDrawable` | int | 0x7f0402a0 | 2634 |
| `finishPrimaryWithSecondary` | int | 0x7f0402a1 | 2637 |
| `finishSecondaryWithPrimary` | int | 0x7f0402a2 | 2640 |
| `firstBaselineToTopHeight` | int | 0x7f0402a3 | 2643 |
| `floatingActionButtonLargePrimaryStyle` | int | 0x7f0402a4 | 2646 |
| `floatingActionButtonLargeSecondaryStyle` | int | 0x7f0402a5 | 2649 |
| `floatingActionButtonLargeStyle` | int | 0x7f0402a6 | 2652 |
| `floatingActionButtonLargeSurfaceStyle` | int | 0x7f0402a7 | 2655 |
| `floatingActionButtonLargeTertiaryStyle` | int | 0x7f0402a8 | 2658 |
| `floatingActionButtonPrimaryStyle` | int | 0x7f0402a9 | 2661 |
| `floatingActionButtonSecondaryStyle` | int | 0x7f0402aa | 2664 |
| `floatingActionButtonSmallPrimaryStyle` | int | 0x7f0402ab | 2667 |
| `floatingActionButtonSmallSecondaryStyle` | int | 0x7f0402ac | 2670 |
| `floatingActionButtonSmallStyle` | int | 0x7f0402ad | 2673 |
| `floatingActionButtonSmallSurfaceStyle` | int | 0x7f0402ae | 2676 |
| `floatingActionButtonSmallTertiaryStyle` | int | 0x7f0402af | 2679 |
| `floatingActionButtonStyle` | int | 0x7f0402b0 | 2682 |
| `floatingActionButtonSurfaceStyle` | int | 0x7f0402b1 | 2685 |
| `floatingActionButtonTertiaryStyle` | int | 0x7f0402b2 | 2688 |
| `flow_firstHorizontalBias` | int | 0x7f0402b3 | 2691 |
| `flow_firstHorizontalStyle` | int | 0x7f0402b4 | 2694 |
| `flow_firstVerticalBias` | int | 0x7f0402b5 | 2697 |
| `flow_firstVerticalStyle` | int | 0x7f0402b6 | 2700 |
| `flow_horizontalAlign` | int | 0x7f0402b7 | 2703 |
| `flow_horizontalBias` | int | 0x7f0402b8 | 2706 |
| `flow_horizontalGap` | int | 0x7f0402b9 | 2709 |
| `flow_horizontalStyle` | int | 0x7f0402ba | 2712 |
| `flow_lastHorizontalBias` | int | 0x7f0402bb | 2715 |
| `flow_lastHorizontalStyle` | int | 0x7f0402bc | 2718 |
| `flow_lastVerticalBias` | int | 0x7f0402bd | 2721 |
| `flow_lastVerticalStyle` | int | 0x7f0402be | 2724 |
| `flow_maxElementsWrap` | int | 0x7f0402bf | 2727 |
| `flow_padding` | int | 0x7f0402c0 | 2730 |
| `flow_verticalAlign` | int | 0x7f0402c1 | 2733 |
| `flow_verticalBias` | int | 0x7f0402c2 | 2736 |
| `flow_verticalGap` | int | 0x7f0402c3 | 2739 |
| `flow_verticalStyle` | int | 0x7f0402c4 | 2742 |
| `flow_wrapMode` | int | 0x7f0402c5 | 2745 |
| `font` | int | 0x7f0402c6 | 2748 |
| `fontFamily` | int | 0x7f0402c7 | 2751 |
| `fontProviderAuthority` | int | 0x7f0402c8 | 2754 |
| `fontProviderCerts` | int | 0x7f0402c9 | 2757 |
| `fontProviderFetchStrategy` | int | 0x7f0402ca | 2760 |
| `fontProviderFetchTimeout` | int | 0x7f0402cb | 2763 |
| `fontProviderPackage` | int | 0x7f0402cc | 2766 |
| `fontProviderQuery` | int | 0x7f0402cd | 2769 |
| `fontProviderSystemFontFamily` | int | 0x7f0402ce | 2772 |
| `fontStyle` | int | 0x7f0402cf | 2775 |
| `fontVariationSettings` | int | 0x7f0402d0 | 2778 |
| `fontWeight` | int | 0x7f0402d1 | 2781 |
| `forceApplySystemWindowInsetTop` | int | 0x7f0402d2 | 2784 |
| `forceDefaultNavigationOnClickListener` | int | 0x7f0402d3 | 2787 |
| `foregroundInsidePadding` | int | 0x7f0402d4 | 2790 |
| `framePosition` | int | 0x7f0402d5 | 2793 |
| `gapBetweenBars` | int | 0x7f0402d6 | 2796 |
| `gesture_mode` | int | 0x7f0402d8 | 2802 |
| `gestureInsetBottomIgnored` | int | 0x7f0402d7 | 2799 |
| `goIcon` | int | 0x7f0402d9 | 2805 |
| `graph` | int | 0x7f0402da | 2808 |
| `grid_columns` | int | 0x7f0402dc | 2814 |
| `grid_columnWeights` | int | 0x7f0402db | 2811 |
| `grid_horizontalGaps` | int | 0x7f0402dd | 2817 |
| `grid_orientation` | int | 0x7f0402de | 2820 |
| `grid_rows` | int | 0x7f0402e0 | 2826 |
| `grid_rowWeights` | int | 0x7f0402df | 2823 |
| `grid_skips` | int | 0x7f0402e1 | 2829 |
| `grid_spans` | int | 0x7f0402e2 | 2832 |
| `grid_useRtl` | int | 0x7f0402e3 | 2835 |
| `grid_validateInputs` | int | 0x7f0402e4 | 2838 |
| `grid_verticalGaps` | int | 0x7f0402e5 | 2841 |
| `guidelineUseRtl` | int | 0x7f0402e6 | 2844 |
| `haloColor` | int | 0x7f0402e7 | 2847 |
| `haloRadius` | int | 0x7f0402e8 | 2850 |
| `headerLayout` | int | 0x7f0402e9 | 2853 |
| `height` | int | 0x7f0402ea | 2856 |
| `height_bar` | int | 0x7f0402eb | 2859 |
| `helperText` | int | 0x7f0402ec | 2862 |
| `helperTextEnabled` | int | 0x7f0402ed | 2865 |
| `helperTextTextAppearance` | int | 0x7f0402ee | 2868 |
| `helperTextTextColor` | int | 0x7f0402ef | 2871 |
| `hide_during_ads` | int | 0x7f0402f5 | 2889 |
| `hide_on_touch` | int | 0x7f0402f6 | 2892 |
| `hideAnimationBehavior` | int | 0x7f0402f0 | 2874 |
| `hideMotionSpec` | int | 0x7f0402f1 | 2877 |
| `hideNavigationIcon` | int | 0x7f0402f2 | 2880 |
| `hideOnContentScroll` | int | 0x7f0402f3 | 2883 |
| `hideOnScroll` | int | 0x7f0402f4 | 2886 |
| `hintAnimationEnabled` | int | 0x7f0402f7 | 2895 |
| `hintEnabled` | int | 0x7f0402f8 | 2898 |
| `hintTextAppearance` | int | 0x7f0402f9 | 2901 |
| `hintTextColor` | int | 0x7f0402fa | 2904 |
| `homeAsUpIndicator` | int | 0x7f0402fb | 2907 |
| `homeLayout` | int | 0x7f0402fc | 2910 |
| `horizontalOffset` | int | 0x7f0402fd | 2913 |
| `horizontalOffsetWithText` | int | 0x7f0402fe | 2916 |
| `hoveredFocusedTranslationZ` | int | 0x7f0402ff | 2919 |
| `icon` | int | 0x7f040300 | 2922 |
| `iconEndPadding` | int | 0x7f040301 | 2925 |
| `iconGravity` | int | 0x7f040302 | 2928 |
| `iconifiedByDefault` | int | 0x7f04030a | 2946 |
| `iconPadding` | int | 0x7f040305 | 2931 |
| `iconSize` | int | 0x7f040306 | 2934 |
| `iconStartPadding` | int | 0x7f040307 | 2937 |
| `iconTint` | int | 0x7f040308 | 2940 |
| `iconTintMode` | int | 0x7f040309 | 2943 |
| `ifTagNotSet` | int | 0x7f04030b | 2949 |
| `ifTagSet` | int | 0x7f04030c | 2952 |
| `imageAspectRatio` | int | 0x7f04030d | 2955 |
| `imageAspectRatioAdjust` | int | 0x7f04030e | 2958 |
| `imageButtonStyle` | int | 0x7f04030f | 2961 |
| `imagePanX` | int | 0x7f040310 | 2964 |
| `imagePanY` | int | 0x7f040311 | 2967 |
| `imageRotate` | int | 0x7f040312 | 2970 |
| `imageZoom` | int | 0x7f040313 | 2973 |
| `implementationMode` | int | 0x7f040314 | 2976 |
| `indeterminateAnimationType` | int | 0x7f040315 | 2979 |
| `indeterminateProgressStyle` | int | 0x7f040316 | 2982 |
| `indexBar_background` | int | 0x7f040317 | 2985 |
| `indexBar_layout_width` | int | 0x7f040318 | 2988 |
| `indexBar_selectedTextColor` | int | 0x7f040319 | 2991 |
| `indexBar_textColor` | int | 0x7f04031a | 2994 |
| `indexBar_textSize` | int | 0x7f04031b | 2997 |
| `indexBar_textSpace` | int | 0x7f04031c | 3000 |
| `indicatorColor` | int | 0x7f04031d | 3003 |
| `indicatorDirectionCircular` | int | 0x7f04031e | 3006 |
| `indicatorDirectionLinear` | int | 0x7f04031f | 3009 |
| `indicatorInset` | int | 0x7f040320 | 3012 |
| `indicatorSize` | int | 0x7f040321 | 3015 |
| `initialActivityCount` | int | 0x7f040322 | 3018 |
| `insetForeground` | int | 0x7f040323 | 3021 |
| `isLightTheme` | int | 0x7f040324 | 3024 |
| `isMaterial3DynamicColorApplied` | int | 0x7f040325 | 3027 |
| `isMaterial3Theme` | int | 0x7f040326 | 3030 |
| `isMaterialTheme` | int | 0x7f040327 | 3033 |
| `itemActiveIndicatorStyle` | int | 0x7f040328 | 3036 |
| `itemBackground` | int | 0x7f040329 | 3039 |
| `itemFillColor` | int | 0x7f04032a | 3042 |
| `itemHorizontalPadding` | int | 0x7f04032b | 3045 |
| `itemHorizontalTranslationEnabled` | int | 0x7f04032c | 3048 |
| `itemIconPadding` | int | 0x7f04032d | 3051 |
| `itemIconSize` | int | 0x7f04032e | 3054 |
| `itemIconTint` | int | 0x7f04032f | 3057 |
| `itemMaxLines` | int | 0x7f040330 | 3060 |
| `itemMinHeight` | int | 0x7f040331 | 3063 |
| `itemPadding` | int | 0x7f040332 | 3066 |
| `itemPaddingBottom` | int | 0x7f040333 | 3069 |
| `itemPaddingTop` | int | 0x7f040334 | 3072 |
| `itemRippleColor` | int | 0x7f040335 | 3075 |
| `itemShapeAppearance` | int | 0x7f040336 | 3078 |
| `itemShapeAppearanceOverlay` | int | 0x7f040337 | 3081 |
| `itemShapeFillColor` | int | 0x7f040338 | 3084 |
| `itemShapeInsetBottom` | int | 0x7f040339 | 3087 |
| `itemShapeInsetEnd` | int | 0x7f04033a | 3090 |
| `itemShapeInsetStart` | int | 0x7f04033b | 3093 |
| `itemShapeInsetTop` | int | 0x7f04033c | 3096 |
| `itemSpacing` | int | 0x7f04033d | 3099 |
| `itemStrokeColor` | int | 0x7f04033e | 3102 |
| `itemStrokeWidth` | int | 0x7f04033f | 3105 |
| `itemTextAppearance` | int | 0x7f040340 | 3108 |
| `itemTextAppearanceActive` | int | 0x7f040341 | 3111 |
| `itemTextAppearanceActiveBoldEnabled` | int | 0x7f040342 | 3114 |
| `itemTextAppearanceInactive` | int | 0x7f040343 | 3117 |
| `itemTextColor` | int | 0x7f040344 | 3120 |
| `itemVerticalPadding` | int | 0x7f040345 | 3123 |
| `keep_content_on_player_reset` | int | 0x7f040346 | 3126 |
| `keyboardIcon` | int | 0x7f040348 | 3132 |
| `keylines` | int | 0x7f040349 | 3135 |
| `keyPositionType` | int | 0x7f040347 | 3129 |
| `labelBehavior` | int | 0x7f04034b | 3141 |
| `labelStyle` | int | 0x7f04034c | 3144 |
| `labelVisibilityMode` | int | 0x7f04034d | 3147 |
| `largeFontVerticalOffsetAdjustment` | int | 0x7f04034e | 3150 |
| `lastBaselineToBottomHeight` | int | 0x7f04034f | 3153 |
| `lastItemDecorated` | int | 0x7f040350 | 3156 |
| `latLngBoundsNorthEastLatitude` | int | 0x7f040351 | 3159 |
| `latLngBoundsNorthEastLongitude` | int | 0x7f040352 | 3162 |
| `latLngBoundsSouthWestLatitude` | int | 0x7f040353 | 3165 |
| `latLngBoundsSouthWestLongitude` | int | 0x7f040354 | 3168 |
| `launchSingleTop` | int | 0x7f040355 | 3171 |
| `layout` | int | 0x7f040356 | 3174 |
| `layout_anchor` | int | 0x7f04035a | 3186 |
| `layout_anchorGravity` | int | 0x7f04035b | 3189 |
| `layout_behavior` | int | 0x7f04035c | 3192 |
| `layout_collapseMode` | int | 0x7f04035d | 3195 |
| `layout_collapseParallaxMultiplier` | int | 0x7f04035e | 3198 |
| `layout_constrainedHeight` | int | 0x7f04035f | 3201 |
| `layout_constrainedWidth` | int | 0x7f040360 | 3204 |
| `layout_constraintBaseline_creator` | int | 0x7f040361 | 3207 |
| `layout_constraintBaseline_toBaselineOf` | int | 0x7f040362 | 3210 |
| `layout_constraintBaseline_toBottomOf` | int | 0x7f040363 | 3213 |
| `layout_constraintBaseline_toTopOf` | int | 0x7f040364 | 3216 |
| `layout_constraintBottom_creator` | int | 0x7f040365 | 3219 |
| `layout_constraintBottom_toBottomOf` | int | 0x7f040366 | 3222 |
| `layout_constraintBottom_toTopOf` | int | 0x7f040367 | 3225 |
| `layout_constraintCircle` | int | 0x7f040368 | 3228 |
| `layout_constraintCircleAngle` | int | 0x7f040369 | 3231 |
| `layout_constraintCircleRadius` | int | 0x7f04036a | 3234 |
| `layout_constraintDimensionRatio` | int | 0x7f04036b | 3237 |
| `layout_constraintEnd_toEndOf` | int | 0x7f04036c | 3240 |
| `layout_constraintEnd_toStartOf` | int | 0x7f04036d | 3243 |
| `layout_constraintGuide_begin` | int | 0x7f04036e | 3246 |
| `layout_constraintGuide_end` | int | 0x7f04036f | 3249 |
| `layout_constraintGuide_percent` | int | 0x7f040370 | 3252 |
| `layout_constraintHeight` | int | 0x7f040371 | 3255 |
| `layout_constraintHeight_default` | int | 0x7f040372 | 3258 |
| `layout_constraintHeight_max` | int | 0x7f040373 | 3261 |
| `layout_constraintHeight_min` | int | 0x7f040374 | 3264 |
| `layout_constraintHeight_percent` | int | 0x7f040375 | 3267 |
| `layout_constraintHorizontal_bias` | int | 0x7f040376 | 3270 |
| `layout_constraintHorizontal_chainStyle` | int | 0x7f040377 | 3273 |
| `layout_constraintHorizontal_weight` | int | 0x7f040378 | 3276 |
| `layout_constraintLeft_creator` | int | 0x7f040379 | 3279 |
| `layout_constraintLeft_toLeftOf` | int | 0x7f04037a | 3282 |
| `layout_constraintLeft_toRightOf` | int | 0x7f04037b | 3285 |
| `layout_constraintRight_creator` | int | 0x7f04037c | 3288 |
| `layout_constraintRight_toLeftOf` | int | 0x7f04037d | 3291 |
| `layout_constraintRight_toRightOf` | int | 0x7f04037e | 3294 |
| `layout_constraintStart_toEndOf` | int | 0x7f04037f | 3297 |
| `layout_constraintStart_toStartOf` | int | 0x7f040380 | 3300 |
| `layout_constraintTag` | int | 0x7f040381 | 3303 |
| `layout_constraintTop_creator` | int | 0x7f040382 | 3306 |
| `layout_constraintTop_toBottomOf` | int | 0x7f040383 | 3309 |
| `layout_constraintTop_toTopOf` | int | 0x7f040384 | 3312 |
| `layout_constraintVertical_bias` | int | 0x7f040385 | 3315 |
| `layout_constraintVertical_chainStyle` | int | 0x7f040386 | 3318 |
| `layout_constraintVertical_weight` | int | 0x7f040387 | 3321 |
| `layout_constraintWidth` | int | 0x7f040388 | 3324 |
| `layout_constraintWidth_default` | int | 0x7f040389 | 3327 |
| `layout_constraintWidth_max` | int | 0x7f04038a | 3330 |
| `layout_constraintWidth_min` | int | 0x7f04038b | 3333 |
| `layout_constraintWidth_percent` | int | 0x7f04038c | 3336 |
| `layout_dodgeInsetEdges` | int | 0x7f04038d | 3339 |
| `layout_editor_absoluteX` | int | 0x7f04038e | 3342 |
| `layout_editor_absoluteY` | int | 0x7f04038f | 3345 |
| `layout_goneMarginBaseline` | int | 0x7f040390 | 3348 |
| `layout_goneMarginBottom` | int | 0x7f040391 | 3351 |
| `layout_goneMarginEnd` | int | 0x7f040392 | 3354 |
| `layout_goneMarginLeft` | int | 0x7f040393 | 3357 |
| `layout_goneMarginRight` | int | 0x7f040394 | 3360 |
| `layout_goneMarginStart` | int | 0x7f040395 | 3363 |
| `layout_goneMarginTop` | int | 0x7f040396 | 3366 |
| `layout_insetEdge` | int | 0x7f040397 | 3369 |
| `layout_keyline` | int | 0x7f040398 | 3372 |
| `layout_marginBaseline` | int | 0x7f040399 | 3375 |
| `layout_optimizationLevel` | int | 0x7f04039a | 3378 |
| `layout_scrollEffect` | int | 0x7f04039b | 3381 |
| `layout_scrollFlags` | int | 0x7f04039c | 3384 |
| `layout_scrollInterpolator` | int | 0x7f04039d | 3387 |
| `layout_srlBackgroundColor` | int | 0x7f04039e | 3390 |
| `layout_srlSpinnerStyle` | int | 0x7f04039f | 3393 |
| `layout_wrapBehaviorInParent` | int | 0x7f0403a0 | 3396 |
| `layoutDescription` | int | 0x7f040357 | 3177 |
| `layoutDuringTransition` | int | 0x7f040358 | 3180 |
| `layoutManager` | int | 0x7f040359 | 3183 |
| `liftOnScroll` | int | 0x7f0403a1 | 3399 |
| `liftOnScrollColor` | int | 0x7f0403a2 | 3402 |
| `liftOnScrollTargetViewId` | int | 0x7f0403a3 | 3405 |
| `limitBoundsTo` | int | 0x7f0403a4 | 3408 |
| `linearProgressIndicatorStyle` | int | 0x7f0403a8 | 3417 |
| `lineHeight` | int | 0x7f0403a6 | 3411 |
| `lineSpacing` | int | 0x7f0403a7 | 3414 |
| `listChoiceBackgroundIndicator` | int | 0x7f0403a9 | 3420 |
| `listChoiceIndicatorMultipleAnimated` | int | 0x7f0403aa | 3423 |
| `listChoiceIndicatorSingleAnimated` | int | 0x7f0403ab | 3426 |
| `listDividerAlertDialog` | int | 0x7f0403ac | 3429 |
| `listItemLayout` | int | 0x7f0403ad | 3432 |
| `listLayout` | int | 0x7f0403ae | 3435 |
| `listMenuViewStyle` | int | 0x7f0403af | 3438 |
| `listPopupWindowStyle` | int | 0x7f0403b0 | 3441 |
| `listPreferredItemHeight` | int | 0x7f0403b1 | 3444 |
| `listPreferredItemHeightLarge` | int | 0x7f0403b2 | 3447 |
| `listPreferredItemHeightSmall` | int | 0x7f0403b3 | 3450 |
| `listPreferredItemPaddingEnd` | int | 0x7f0403b4 | 3453 |
| `listPreferredItemPaddingLeft` | int | 0x7f0403b5 | 3456 |
| `listPreferredItemPaddingRight` | int | 0x7f0403b6 | 3459 |
| `listPreferredItemPaddingStart` | int | 0x7f0403b7 | 3462 |
| `liteMode` | int | 0x7f0403b8 | 3465 |
| `loadingDialogProgressDrawable` | int | 0x7f0403b9 | 3468 |
| `logo` | int | 0x7f0403ba | 3471 |
| `logoAdjustViewBounds` | int | 0x7f0403bb | 3474 |
| `logoDescription` | int | 0x7f0403bc | 3477 |
| `logoScaleType` | int | 0x7f0403bd | 3480 |
| `lStar` | int | 0x7f04034a | 3138 |
| `lunar_text_size` | int | 0x7f0403be | 3483 |
| `mapColorScheme` | int | 0x7f0403bf | 3486 |
| `mapId` | int | 0x7f0403c0 | 3489 |
| `mapType` | int | 0x7f0403c1 | 3492 |
| `marginHorizontal` | int | 0x7f0403c2 | 3495 |
| `marginLeftSystemWindowInsets` | int | 0x7f0403c3 | 3498 |
| `marginRightSystemWindowInsets` | int | 0x7f0403c4 | 3501 |
| `marginTopSystemWindowInsets` | int | 0x7f0403c5 | 3504 |
| `materialAlertDialogBodyTextStyle` | int | 0x7f0403c6 | 3507 |
| `materialAlertDialogButtonSpacerVisibility` | int | 0x7f0403c7 | 3510 |
| `materialAlertDialogTheme` | int | 0x7f0403c8 | 3513 |
| `materialAlertDialogTitleIconStyle` | int | 0x7f0403c9 | 3516 |
| `materialAlertDialogTitlePanelStyle` | int | 0x7f0403ca | 3519 |
| `materialAlertDialogTitleTextStyle` | int | 0x7f0403cb | 3522 |
| `materialButtonOutlinedStyle` | int | 0x7f0403cc | 3525 |
| `materialButtonStyle` | int | 0x7f0403cd | 3528 |
| `materialButtonToggleGroupStyle` | int | 0x7f0403ce | 3531 |
| `materialCalendarDay` | int | 0x7f0403cf | 3534 |
| `materialCalendarDayOfWeekLabel` | int | 0x7f0403d0 | 3537 |
| `materialCalendarFullscreenTheme` | int | 0x7f0403d1 | 3540 |
| `materialCalendarHeaderCancelButton` | int | 0x7f0403d2 | 3543 |
| `materialCalendarHeaderConfirmButton` | int | 0x7f0403d3 | 3546 |
| `materialCalendarHeaderDivider` | int | 0x7f0403d4 | 3549 |
| `materialCalendarHeaderLayout` | int | 0x7f0403d5 | 3552 |
| `materialCalendarHeaderSelection` | int | 0x7f0403d6 | 3555 |
| `materialCalendarHeaderTitle` | int | 0x7f0403d7 | 3558 |
| `materialCalendarHeaderToggleButton` | int | 0x7f0403d8 | 3561 |
| `materialCalendarMonth` | int | 0x7f0403d9 | 3564 |
| `materialCalendarMonthNavigationButton` | int | 0x7f0403da | 3567 |
| `materialCalendarStyle` | int | 0x7f0403db | 3570 |
| `materialCalendarTheme` | int | 0x7f0403dc | 3573 |
| `materialCalendarYearNavigationButton` | int | 0x7f0403dd | 3576 |
| `materialCardViewElevatedStyle` | int | 0x7f0403de | 3579 |
| `materialCardViewFilledStyle` | int | 0x7f0403df | 3582 |
| `materialCardViewOutlinedStyle` | int | 0x7f0403e0 | 3585 |
| `materialCardViewStyle` | int | 0x7f0403e1 | 3588 |
| `materialCircleRadius` | int | 0x7f0403e2 | 3591 |
| `materialClockStyle` | int | 0x7f0403e3 | 3594 |
| `materialDisplayDividerStyle` | int | 0x7f0403e4 | 3597 |
| `materialDividerHeavyStyle` | int | 0x7f0403e5 | 3600 |
| `materialDividerStyle` | int | 0x7f0403e6 | 3603 |
| `materialIconButtonFilledStyle` | int | 0x7f0403e7 | 3606 |
| `materialIconButtonFilledTonalStyle` | int | 0x7f0403e8 | 3609 |
| `materialIconButtonOutlinedStyle` | int | 0x7f0403e9 | 3612 |
| `materialIconButtonStyle` | int | 0x7f0403ea | 3615 |
| `materialSearchBarStyle` | int | 0x7f0403eb | 3618 |
| `materialSearchViewPrefixStyle` | int | 0x7f0403ec | 3621 |
| `materialSearchViewStyle` | int | 0x7f0403ed | 3624 |
| `materialSearchViewToolbarHeight` | int | 0x7f0403ee | 3627 |
| `materialSearchViewToolbarStyle` | int | 0x7f0403ef | 3630 |
| `materialSwitchStyle` | int | 0x7f0403f0 | 3633 |
| `materialThemeOverlay` | int | 0x7f0403f1 | 3636 |
| `materialTimePickerStyle` | int | 0x7f0403f2 | 3639 |
| `materialTimePickerTheme` | int | 0x7f0403f3 | 3642 |
| `materialTimePickerTitleStyle` | int | 0x7f0403f4 | 3645 |
| `max_multi_select_size` | int | 0x7f0403ff | 3678 |
| `max_select_range` | int | 0x7f040400 | 3681 |
| `max_year` | int | 0x7f040401 | 3684 |
| `max_year_day` | int | 0x7f040402 | 3687 |
| `max_year_month` | int | 0x7f040403 | 3690 |
| `maxAcceleration` | int | 0x7f0403f5 | 3648 |
| `maxActionInlineWidth` | int | 0x7f0403f6 | 3651 |
| `maxButtonHeight` | int | 0x7f0403f7 | 3654 |
| `maxCharacterCount` | int | 0x7f0403f8 | 3657 |
| `maxHeight` | int | 0x7f0403f9 | 3660 |
| `maxImageSize` | int | 0x7f0403fa | 3663 |
| `maxLines` | int | 0x7f0403fb | 3666 |
| `maxNumber` | int | 0x7f0403fc | 3669 |
| `maxVelocity` | int | 0x7f0403fd | 3672 |
| `maxWidth` | int | 0x7f0403fe | 3675 |
| `measureWithLargestChild` | int | 0x7f040404 | 3693 |
| `menu` | int | 0x7f040405 | 3696 |
| `menuAlignmentMode` | int | 0x7f040406 | 3699 |
| `menuGravity` | int | 0x7f040407 | 3702 |
| `methodName` | int | 0x7f040408 | 3705 |
| `mimeType` | int | 0x7f040409 | 3708 |
| `min_select_range` | int | 0x7f04040f | 3726 |
| `min_year` | int | 0x7f040410 | 3729 |
| `min_year_day` | int | 0x7f040411 | 3732 |
| `min_year_month` | int | 0x7f040412 | 3735 |
| `minHeight` | int | 0x7f04040a | 3711 |
| `minHideDelay` | int | 0x7f04040b | 3714 |
| `minSeparation` | int | 0x7f04040c | 3717 |
| `minTouchTargetSize` | int | 0x7f04040d | 3720 |
| `minWidth` | int | 0x7f04040e | 3723 |
| `mock_diagonalsColor` | int | 0x7f040413 | 3738 |
| `mock_label` | int | 0x7f040414 | 3741 |
| `mock_labelBackgroundColor` | int | 0x7f040415 | 3744 |
| `mock_labelColor` | int | 0x7f040416 | 3747 |
| `mock_showDiagonals` | int | 0x7f040417 | 3750 |
| `mock_showLabel` | int | 0x7f040418 | 3753 |
| `month_view` | int | 0x7f040419 | 3756 |
| `month_view_auto_select_day` | int | 0x7f04041a | 3759 |
| `month_view_scrollable` | int | 0x7f04041b | 3762 |
| `month_view_show_mode` | int | 0x7f04041c | 3765 |
| `motion_postLayoutCollision` | int | 0x7f040448 | 3897 |
| `motion_triggerOnCollision` | int | 0x7f040449 | 3900 |
| `motionDebug` | int | 0x7f04041d | 3768 |
| `motionDurationExtraLong1` | int | 0x7f04041e | 3771 |
| `motionDurationExtraLong2` | int | 0x7f04041f | 3774 |
| `motionDurationExtraLong3` | int | 0x7f040420 | 3777 |
| `motionDurationExtraLong4` | int | 0x7f040421 | 3780 |
| `motionDurationLong1` | int | 0x7f040422 | 3783 |
| `motionDurationLong2` | int | 0x7f040423 | 3786 |
| `motionDurationLong3` | int | 0x7f040424 | 3789 |
| `motionDurationLong4` | int | 0x7f040425 | 3792 |
| `motionDurationMedium1` | int | 0x7f040426 | 3795 |
| `motionDurationMedium2` | int | 0x7f040427 | 3798 |
| `motionDurationMedium3` | int | 0x7f040428 | 3801 |
| `motionDurationMedium4` | int | 0x7f040429 | 3804 |
| `motionDurationShort1` | int | 0x7f04042a | 3807 |
| `motionDurationShort2` | int | 0x7f04042b | 3810 |
| `motionDurationShort3` | int | 0x7f04042c | 3813 |
| `motionDurationShort4` | int | 0x7f04042d | 3816 |
| `motionEasingAccelerated` | int | 0x7f04042e | 3819 |
| `motionEasingDecelerated` | int | 0x7f04042f | 3822 |
| `motionEasingEmphasized` | int | 0x7f040430 | 3825 |
| `motionEasingEmphasizedAccelerateInterpolator` | int | 0x7f040431 | 3828 |
| `motionEasingEmphasizedDecelerateInterpolator` | int | 0x7f040432 | 3831 |
| `motionEasingEmphasizedInterpolator` | int | 0x7f040433 | 3834 |
| `motionEasingLinear` | int | 0x7f040434 | 3837 |
| `motionEasingLinearInterpolator` | int | 0x7f040435 | 3840 |
| `motionEasingStandard` | int | 0x7f040436 | 3843 |
| `motionEasingStandardAccelerateInterpolator` | int | 0x7f040437 | 3846 |
| `motionEasingStandardDecelerateInterpolator` | int | 0x7f040438 | 3849 |
| `motionEasingStandardInterpolator` | int | 0x7f040439 | 3852 |
| `motionEffect_alpha` | int | 0x7f04043a | 3855 |
| `motionEffect_end` | int | 0x7f04043b | 3858 |
| `motionEffect_move` | int | 0x7f04043c | 3861 |
| `motionEffect_start` | int | 0x7f04043d | 3864 |
| `motionEffect_strict` | int | 0x7f04043e | 3867 |
| `motionEffect_translationX` | int | 0x7f04043f | 3870 |
| `motionEffect_translationY` | int | 0x7f040440 | 3873 |
| `motionEffect_viewTransition` | int | 0x7f040441 | 3876 |
| `motionInterpolator` | int | 0x7f040442 | 3879 |
| `motionPath` | int | 0x7f040443 | 3882 |
| `motionPathRotate` | int | 0x7f040444 | 3885 |
| `motionProgress` | int | 0x7f040445 | 3888 |
| `motionStagger` | int | 0x7f040446 | 3891 |
| `motionTarget` | int | 0x7f040447 | 3894 |
| `moveWhenScrollAtTop` | int | 0x7f04044a | 3903 |
| `multiChoiceItemLayout` | int | 0x7f04044b | 3906 |
| `navGraph` | int | 0x7f040452 | 3909 |
| `navIcon` | int | 0x7f040453 | 3912 |
| `navigationContentDescription` | int | 0x7f040454 | 3915 |
| `navigationIcon` | int | 0x7f040455 | 3918 |
| `navigationIconTint` | int | 0x7f040456 | 3921 |
| `navigationMode` | int | 0x7f040457 | 3924 |
| `navigationRailStyle` | int | 0x7f040458 | 3927 |
| `navigationViewStyle` | int | 0x7f040459 | 3930 |
| `negativeTextColor` | int | 0x7f04045a | 3933 |
| `nestedScrollable` | int | 0x7f04045d | 3942 |
| `nestedScrollFlags` | int | 0x7f04045b | 3936 |
| `nestedScrollViewStyle` | int | 0x7f04045c | 3939 |
| `normalBackgroundColor` | int | 0x7f04045e | 3945 |
| `nullable` | int | 0x7f04045f | 3948 |
| `number` | int | 0x7f040460 | 3951 |
| `numericModifiers` | int | 0x7f040462 | 3954 |
| `offsetAlignmentMode` | int | 0x7f040463 | 3957 |
| `onCross` | int | 0x7f040464 | 3960 |
| `onHide` | int | 0x7f040465 | 3963 |
| `onNegativeCross` | int | 0x7f040466 | 3966 |
| `onPositiveCross` | int | 0x7f040467 | 3969 |
| `onShow` | int | 0x7f040468 | 3972 |
| `onStateTransition` | int | 0x7f040469 | 3975 |
| `onTouchUp` | int | 0x7f04046a | 3978 |
| `other_month_lunar_text_color` | int | 0x7f04046b | 3981 |
| `other_month_text_color` | int | 0x7f04046c | 3984 |
| `overlapAnchor` | int | 0x7f04046d | 3987 |
| `overlay` | int | 0x7f04046e | 3990 |
| `paddingBottomNoButtons` | int | 0x7f04046f | 3993 |
| `paddingBottomSystemWindowInsets` | int | 0x7f040470 | 3996 |
| `paddingEnd` | int | 0x7f040471 | 3999 |
| `paddingLeftSystemWindowInsets` | int | 0x7f040472 | 4002 |
| `paddingRightSystemWindowInsets` | int | 0x7f040473 | 4005 |
| `paddingStart` | int | 0x7f040474 | 4008 |
| `paddingStartSystemWindowInsets` | int | 0x7f040475 | 4011 |
| `paddingTopNoTitle` | int | 0x7f040476 | 4014 |
| `paddingTopSystemWindowInsets` | int | 0x7f040477 | 4017 |
| `panelBackground` | int | 0x7f04047b | 4023 |
| `panelMenuListTheme` | int | 0x7f04047c | 4026 |
| `panelMenuListWidth` | int | 0x7f04047d | 4029 |
| `panEnabled` | int | 0x7f04047a | 4020 |
| `passwordToggleContentDescription` | int | 0x7f04047e | 4032 |
| `passwordToggleDrawable` | int | 0x7f04047f | 4035 |
| `passwordToggleEnabled` | int | 0x7f040480 | 4038 |
| `passwordToggleTint` | int | 0x7f040481 | 4041 |
| `passwordToggleTintMode` | int | 0x7f040482 | 4044 |
| `path_percent` | int | 0x7f040484 | 4050 |
| `pathMotionArc` | int | 0x7f040483 | 4047 |
| `percentHeight` | int | 0x7f040485 | 4053 |
| `percentWidth` | int | 0x7f040486 | 4056 |
| `percentX` | int | 0x7f040487 | 4059 |
| `percentY` | int | 0x7f040488 | 4062 |
| `perpendicularPath_percent` | int | 0x7f040489 | 4065 |
| `pivotAnchor` | int | 0x7f04048a | 4068 |
| `placeholder_emptyVisibility` | int | 0x7f04048f | 4083 |
| `placeholderActivityName` | int | 0x7f04048b | 4071 |
| `placeholderText` | int | 0x7f04048c | 4074 |
| `placeholderTextAppearance` | int | 0x7f04048d | 4077 |
| `placeholderTextColor` | int | 0x7f04048e | 4080 |
| `play_bg_line_color` | int | 0x7f040490 | 4086 |
| `play_bg_line_width` | int | 0x7f040491 | 4089 |
| `play_line_color` | int | 0x7f040492 | 4092 |
| `play_line_width` | int | 0x7f040493 | 4095 |
| `played_ad_marker_color` | int | 0x7f040494 | 4098 |
| `played_color` | int | 0x7f040495 | 4101 |
| `player_layout_id` | int | 0x7f040496 | 4104 |
| `polarRelativeTo` | int | 0x7f040497 | 4107 |
| `popEnterAnim` | int | 0x7f040498 | 4110 |
| `popExitAnim` | int | 0x7f040499 | 4113 |
| `popupMenuBackground` | int | 0x7f04049d | 4125 |
| `popupMenuStyle` | int | 0x7f04049e | 4128 |
| `popupTheme` | int | 0x7f04049f | 4131 |
| `popUpTo` | int | 0x7f04049a | 4116 |
| `popUpToInclusive` | int | 0x7f04049b | 4119 |
| `popUpToSaveState` | int | 0x7f04049c | 4122 |
| `popupWindowStyle` | int | 0x7f0404a0 | 4134 |
| `positiveTextColor` | int | 0x7f0404a1 | 4137 |
| `postSplashScreenTheme` | int | 0x7f0404a2 | 4140 |
| `prefDecorationColor` | int | 0x7f0404a3 | 4143 |
| `prefDecorationHeight` | int | 0x7f0404a4 | 4146 |
| `prefHeaderTextColor` | int | 0x7f0404a5 | 4149 |
| `prefHeaderTextSize` | int | 0x7f0404a6 | 4152 |
| `prefItemBackgroundColor` | int | 0x7f0404a7 | 4155 |
| `prefItemLRPadding` | int | 0x7f0404a8 | 4158 |
| `prefItemTBPadding` | int | 0x7f0404a9 | 4161 |
| `prefixText` | int | 0x7f0404af | 4179 |
| `prefixTextAppearance` | int | 0x7f0404b0 | 4182 |
| `prefixTextColor` | int | 0x7f0404b1 | 4185 |
| `prefSummary2Color` | int | 0x7f0404aa | 4164 |
| `prefSummaryColor` | int | 0x7f0404ab | 4167 |
| `prefSummarySize` | int | 0x7f0404ac | 4170 |
| `prefTitleColor` | int | 0x7f0404ad | 4173 |
| `prefTitleSize` | int | 0x7f0404ae | 4176 |
| `preserveIconSpacing` | int | 0x7f0404b2 | 4188 |
| `pressedTranslationZ` | int | 0x7f0404b3 | 4191 |
| `primaryActivityName` | int | 0x7f0404b4 | 4194 |
| `progressBarPadding` | int | 0x7f0404b5 | 4197 |
| `progressBarStyle` | int | 0x7f0404b6 | 4200 |
| `psBottomNormal` | int | 0x7f0404c1 | 4203 |
| `psCorners` | int | 0x7f0404c2 | 4206 |
| `psTopNormal` | int | 0x7f0404c3 | 4209 |
| `quantizeMotionInterpolator` | int | 0x7f0404c5 | 4212 |
| `quantizeMotionPhase` | int | 0x7f0404c6 | 4215 |
| `quantizeMotionSteps` | int | 0x7f0404c7 | 4218 |
| `queryBackground` | int | 0x7f0404c8 | 4221 |
| `queryHint` | int | 0x7f0404c9 | 4224 |
| `queryPatterns` | int | 0x7f0404ca | 4227 |
| `quickScaleEnabled` | int | 0x7f0404cb | 4230 |
| `radioButtonStyle` | int | 0x7f0404d4 | 4233 |
| `radius` | int | 0x7f0404d5 | 4236 |
| `radius_bar` | int | 0x7f0404d6 | 4239 |
| `radius_indicator_normal` | int | 0x7f0404d7 | 4242 |
| `radius_indicator_touch` | int | 0x7f0404d8 | 4245 |
| `rangeFillColor` | int | 0x7f0404d9 | 4248 |
| `ratingBarStyle` | int | 0x7f0404da | 4251 |
| `ratingBarStyleIndicator` | int | 0x7f0404db | 4254 |
| `ratingBarStyleSmall` | int | 0x7f0404dc | 4257 |
| `reactiveGuide_animateChange` | int | 0x7f0404dd | 4260 |
| `reactiveGuide_applyToAllConstraintSets` | int | 0x7f0404de | 4263 |
| `reactiveGuide_applyToConstraintSet` | int | 0x7f0404df | 4266 |
| `reactiveGuide_valueId` | int | 0x7f0404e0 | 4269 |
| `recyclerViewStyle` | int | 0x7f0404e1 | 4272 |
| `region_heightLessThan` | int | 0x7f0404e2 | 4275 |
| `region_heightMoreThan` | int | 0x7f0404e3 | 4278 |
| `region_widthLessThan` | int | 0x7f0404e4 | 4281 |
| `region_widthMoreThan` | int | 0x7f0404e5 | 4284 |
| `removeEmbeddedFabElevation` | int | 0x7f0404e6 | 4287 |
| `repeat_toggle_modes` | int | 0x7f0404e7 | 4290 |
| `resize_mode` | int | 0x7f0404e8 | 4293 |
| `restoreState` | int | 0x7f0404e9 | 4296 |
| `reverseLayout` | int | 0x7f0404ea | 4299 |
| `rippleColor` | int | 0x7f0404ed | 4302 |
| `rotationCenterId` | int | 0x7f0404ee | 4305 |
| `round` | int | 0x7f0404ef | 4308 |
| `roundPercent` | int | 0x7f0404f0 | 4311 |
| `route` | int | 0x7f0404f1 | 4314 |
| `saturation` | int | 0x7f040502 | 4317 |
| `sb_background` | int | 0x7f040503 | 4320 |
| `sb_border_width` | int | 0x7f040504 | 4323 |
| `sb_button_color` | int | 0x7f040505 | 4326 |
| `sb_checked` | int | 0x7f040506 | 4329 |
| `sb_checked_color` | int | 0x7f040507 | 4332 |
| `sb_checkline_color` | int | 0x7f040508 | 4335 |
| `sb_checkline_width` | int | 0x7f040509 | 4338 |
| `sb_effect_duration` | int | 0x7f04050a | 4341 |
| `sb_enable_effect` | int | 0x7f04050b | 4344 |
| `sb_shadow_color` | int | 0x7f04050c | 4347 |
| `sb_shadow_effect` | int | 0x7f04050d | 4350 |
| `sb_shadow_offset` | int | 0x7f04050e | 4353 |
| `sb_shadow_radius` | int | 0x7f04050f | 4356 |
| `sb_show_indicator` | int | 0x7f040510 | 4359 |
| `sb_uncheck_color` | int | 0x7f040511 | 4362 |
| `sb_uncheckcircle_color` | int | 0x7f040512 | 4365 |
| `sb_uncheckcircle_radius` | int | 0x7f040513 | 4368 |
| `sb_uncheckcircle_width` | int | 0x7f040514 | 4371 |
| `scaleFromTextSize` | int | 0x7f040515 | 4374 |
| `scaleType` | int | 0x7f040516 | 4377 |
| `scankit_cornerColor` | int | 0x7f040517 | 4380 |
| `scankit_frameColor` | int | 0x7f040518 | 4383 |
| `scankit_frameHeight` | int | 0x7f040519 | 4386 |
| `scankit_frameWidth` | int | 0x7f04051a | 4389 |
| `scankit_gridColumn` | int | 0x7f04051b | 4392 |
| `scankit_gridHeight` | int | 0x7f04051c | 4395 |
| `scankit_labelText` | int | 0x7f04051d | 4398 |
| `scankit_labelTextColor` | int | 0x7f04051e | 4401 |
| `scankit_labelTextLocation` | int | 0x7f04051f | 4404 |
| `scankit_labelTextPadding` | int | 0x7f040520 | 4407 |
| `scankit_labelTextSize` | int | 0x7f040521 | 4410 |
| `scankit_laserColor` | int | 0x7f040522 | 4413 |
| `scankit_laserStyle` | int | 0x7f040523 | 4416 |
| `scankit_line_anim` | int | 0x7f040524 | 4419 |
| `scankit_maskColor` | int | 0x7f040525 | 4422 |
| `scankit_resultPointColor` | int | 0x7f040526 | 4425 |
| `scankit_showResultPoint` | int | 0x7f040527 | 4428 |
| `scankit_titleColor` | int | 0x7f040528 | 4431 |
| `scankit_titleSize` | int | 0x7f040529 | 4434 |
| `scheme_lunar_text_color` | int | 0x7f04052a | 4437 |
| `scheme_month_text_color` | int | 0x7f04052b | 4440 |
| `scheme_text` | int | 0x7f04052c | 4443 |
| `scheme_text_color` | int | 0x7f04052d | 4446 |
| `scheme_theme_color` | int | 0x7f04052e | 4449 |
| `scopeUris` | int | 0x7f04052f | 4452 |
| `scrimAnimationDuration` | int | 0x7f040530 | 4455 |
| `scrimBackground` | int | 0x7f040531 | 4458 |
| `scrimVisibleHeightTrigger` | int | 0x7f040532 | 4461 |
| `scrubber_color` | int | 0x7f040533 | 4464 |
| `scrubber_disabled_size` | int | 0x7f040534 | 4467 |
| `scrubber_dragged_size` | int | 0x7f040535 | 4470 |
| `scrubber_drawable` | int | 0x7f040536 | 4473 |
| `scrubber_enabled_size` | int | 0x7f040537 | 4476 |
| `searchHintIcon` | int | 0x7f040538 | 4479 |
| `searchIcon` | int | 0x7f040539 | 4482 |
| `searchPrefixText` | int | 0x7f04053a | 4485 |
| `searchViewStyle` | int | 0x7f04053b | 4488 |
| `secondaryActivityAction` | int | 0x7f04053c | 4491 |
| `secondaryActivityName` | int | 0x7f04053d | 4494 |
| `seekBarStyle` | int | 0x7f04053e | 4497 |
| `select_mode` | int | 0x7f04053f | 4500 |
| `selectableItemBackground` | int | 0x7f040540 | 4503 |
| `selectableItemBackgroundBorderless` | int | 0x7f040541 | 4506 |
| `selected_lunar_text_color` | int | 0x7f040542 | 4509 |
| `selected_text_color` | int | 0x7f040543 | 4512 |
| `selected_theme_color` | int | 0x7f040544 | 4515 |
| `selectionRequired` | int | 0x7f040545 | 4518 |
| `selectorSize` | int | 0x7f040546 | 4521 |
| `setsTag` | int | 0x7f040547 | 4524 |
| `shapeAppearance` | int | 0x7f04054c | 4527 |
| `shapeAppearanceCornerExtraLarge` | int | 0x7f04054d | 4530 |
| `shapeAppearanceCornerExtraSmall` | int | 0x7f04054e | 4533 |
| `shapeAppearanceCornerLarge` | int | 0x7f04054f | 4536 |
| `shapeAppearanceCornerMedium` | int | 0x7f040550 | 4539 |
| `shapeAppearanceCornerSmall` | int | 0x7f040551 | 4542 |
| `shapeAppearanceLargeComponent` | int | 0x7f040552 | 4545 |
| `shapeAppearanceMediumComponent` | int | 0x7f040553 | 4548 |
| `shapeAppearanceOverlay` | int | 0x7f040554 | 4551 |
| `shapeAppearanceSmallComponent` | int | 0x7f040555 | 4554 |
| `shapeCornerFamily` | int | 0x7f040556 | 4557 |
| `SharedValue` | int | 0x7f040001 | 696 |
| `SharedValueId` | int | 0x7f040002 | 699 |
| `shimmer_angle` | int | 0x7f040557 | 4560 |
| `shimmer_animation_duration` | int | 0x7f040558 | 4563 |
| `shimmer_auto_start` | int | 0x7f040559 | 4566 |
| `shimmer_color` | int | 0x7f04055a | 4569 |
| `shimmer_gradient_center_color_width` | int | 0x7f04055b | 4572 |
| `shimmer_mask_width` | int | 0x7f04055c | 4575 |
| `shimmer_reverse_animation` | int | 0x7f04055d | 4578 |
| `shortcutMatchRequired` | int | 0x7f04055e | 4581 |
| `shouldRemoveExpandedCorners` | int | 0x7f04055f | 4584 |
| `show_buffering` | int | 0x7f040568 | 4611 |
| `show_fastforward_button` | int | 0x7f040569 | 4614 |
| `show_next_button` | int | 0x7f04056a | 4617 |
| `show_previous_button` | int | 0x7f04056b | 4620 |
| `show_rewind_button` | int | 0x7f04056c | 4623 |
| `show_shuffle_button` | int | 0x7f04056d | 4626 |
| `show_subtitle_button` | int | 0x7f04056e | 4629 |
| `show_timeout` | int | 0x7f04056f | 4632 |
| `show_vr_button` | int | 0x7f040570 | 4635 |
| `showAnimationBehavior` | int | 0x7f040560 | 4587 |
| `showAsAction` | int | 0x7f040561 | 4590 |
| `showDelay` | int | 0x7f040562 | 4593 |
| `showDividers` | int | 0x7f040563 | 4596 |
| `showMotionSpec` | int | 0x7f040564 | 4599 |
| `showPaths` | int | 0x7f040565 | 4602 |
| `showText` | int | 0x7f040566 | 4605 |
| `showTitle` | int | 0x7f040567 | 4608 |
| `shrinkMotionSpec` | int | 0x7f040571 | 4638 |
| `shutter_background_color` | int | 0x7f040572 | 4641 |
| `sideSheetDialogTheme` | int | 0x7f040573 | 4644 |
| `sideSheetModalStyle` | int | 0x7f040574 | 4647 |
| `simpleItemLayout` | int | 0x7f040575 | 4650 |
| `simpleItems` | int | 0x7f040578 | 4659 |
| `simpleItemSelectedColor` | int | 0x7f040576 | 4653 |
| `simpleItemSelectedRippleColor` | int | 0x7f040577 | 4656 |
| `simpleToolbarStyle` | int | 0x7f040579 | 4662 |
| `singleChoiceItemLayout` | int | 0x7f04057a | 4665 |
| `singleLine` | int | 0x7f04057b | 4668 |
| `singleSelection` | int | 0x7f04057c | 4671 |
| `sizePercent` | int | 0x7f04057d | 4674 |
| `sliderStyle` | int | 0x7f04057e | 4677 |
| `snackbarButtonStyle` | int | 0x7f040580 | 4680 |
| `snackbarStyle` | int | 0x7f040581 | 4683 |
| `snackbarTextViewStyle` | int | 0x7f040582 | 4686 |
| `solidActivePadding` | int | 0x7f040583 | 4689 |
| `solidColor` | int | 0x7f040584 | 4692 |
| `solidColorCapture` | int | 0x7f040585 | 4695 |
| `solidPadding` | int | 0x7f040586 | 4698 |
| `spanCount` | int | 0x7f040587 | 4701 |
| `spinBars` | int | 0x7f040588 | 4704 |
| `spinnerDropDownItemStyle` | int | 0x7f04058a | 4707 |
| `spinnerStyle` | int | 0x7f04058b | 4710 |
| `splashScreenIconSize` | int | 0x7f04058c | 4713 |
| `splitLayoutDirection` | int | 0x7f04058d | 4716 |
| `splitMinSmallestWidth` | int | 0x7f04058e | 4719 |
| `splitMinWidth` | int | 0x7f04058f | 4722 |
| `splitRatio` | int | 0x7f040590 | 4725 |
| `splitTrack` | int | 0x7f040591 | 4728 |
| `springBoundary` | int | 0x7f040592 | 4731 |
| `springDamping` | int | 0x7f040593 | 4734 |
| `springMass` | int | 0x7f040594 | 4737 |
| `springStiffness` | int | 0x7f040595 | 4740 |
| `springStopThreshold` | int | 0x7f040596 | 4743 |
| `src` | int | 0x7f040597 | 4746 |
| `srcCompat` | int | 0x7f040598 | 4749 |
| `srlAccentColor` | int | 0x7f040599 | 4752 |
| `srlClassicsSpinnerStyle` | int | 0x7f04059a | 4755 |
| `srlDisableContentWhenLoading` | int | 0x7f04059b | 4758 |
| `srlDisableContentWhenRefresh` | int | 0x7f04059c | 4761 |
| `srlDragRate` | int | 0x7f04059d | 4764 |
| `srlDrawableArrow` | int | 0x7f04059e | 4767 |
| `srlDrawableArrowSize` | int | 0x7f04059f | 4770 |
| `srlDrawableMarginRight` | int | 0x7f0405a0 | 4773 |
| `srlDrawableProgress` | int | 0x7f0405a1 | 4776 |
| `srlDrawableProgressSize` | int | 0x7f0405a2 | 4779 |
| `srlDrawableSize` | int | 0x7f0405a3 | 4782 |
| `srlEnableAutoLoadMore` | int | 0x7f0405a4 | 4785 |
| `srlEnableClipFooterWhenFixedBehind` | int | 0x7f0405a5 | 4788 |
| `srlEnableClipHeaderWhenFixedBehind` | int | 0x7f0405a6 | 4791 |
| `srlEnableFooterFollowWhenLoadFinished` | int | 0x7f0405a7 | 4794 |
| `srlEnableFooterFollowWhenNoMoreData` | int | 0x7f0405a8 | 4797 |
| `srlEnableFooterTranslationContent` | int | 0x7f0405a9 | 4800 |
| `srlEnableHeaderTranslationContent` | int | 0x7f0405aa | 4803 |
| `srlEnableHorizontalDrag` | int | 0x7f0405ab | 4806 |
| `srlEnableLastTime` | int | 0x7f0405ac | 4809 |
| `srlEnableLoadMore` | int | 0x7f0405ad | 4812 |
| `srlEnableLoadMoreWhenContentNotFull` | int | 0x7f0405ae | 4815 |
| `srlEnableNestedScrolling` | int | 0x7f0405af | 4818 |
| `srlEnableOverScrollBounce` | int | 0x7f0405b0 | 4821 |
| `srlEnableOverScrollDrag` | int | 0x7f0405b1 | 4824 |
| `srlEnablePreviewInEditMode` | int | 0x7f0405b2 | 4827 |
| `srlEnablePureScrollMode` | int | 0x7f0405b3 | 4830 |
| `srlEnableRefresh` | int | 0x7f0405b4 | 4833 |
| `srlEnableScrollContentWhenLoaded` | int | 0x7f0405b5 | 4836 |
| `srlEnableScrollContentWhenRefreshed` | int | 0x7f0405b6 | 4839 |
| `srlFinishDuration` | int | 0x7f0405b7 | 4842 |
| `srlFixedFooterViewId` | int | 0x7f0405b8 | 4845 |
| `srlFixedHeaderViewId` | int | 0x7f0405b9 | 4848 |
| `srlFooterHeight` | int | 0x7f0405ba | 4851 |
| `srlFooterInsetStart` | int | 0x7f0405bb | 4854 |
| `srlFooterMaxDragRate` | int | 0x7f0405bc | 4857 |
| `srlFooterTranslationViewId` | int | 0x7f0405bd | 4860 |
| `srlFooterTriggerRate` | int | 0x7f0405be | 4863 |
| `srlHeaderHeight` | int | 0x7f0405bf | 4866 |
| `srlHeaderInsetStart` | int | 0x7f0405c0 | 4869 |
| `srlHeaderMaxDragRate` | int | 0x7f0405c1 | 4872 |
| `srlHeaderTranslationViewId` | int | 0x7f0405c2 | 4875 |
| `srlHeaderTriggerRate` | int | 0x7f0405c3 | 4878 |
| `srlPrimaryColor` | int | 0x7f0405c4 | 4881 |
| `srlReboundDuration` | int | 0x7f0405c5 | 4884 |
| `srlStyle` | int | 0x7f0405c6 | 4887 |
| `srlTextFailed` | int | 0x7f0405c7 | 4890 |
| `srlTextFinish` | int | 0x7f0405c8 | 4893 |
| `srlTextLoading` | int | 0x7f0405c9 | 4896 |
| `srlTextNothing` | int | 0x7f0405ca | 4899 |
| `srlTextPulling` | int | 0x7f0405cb | 4902 |
| `srlTextRefreshing` | int | 0x7f0405cc | 4905 |
| `srlTextRelease` | int | 0x7f0405cd | 4908 |
| `srlTextSecondary` | int | 0x7f0405ce | 4911 |
| `srlTextSizeTime` | int | 0x7f0405cf | 4914 |
| `srlTextSizeTitle` | int | 0x7f0405d0 | 4917 |
| `srlTextTimeMarginTop` | int | 0x7f0405d1 | 4920 |
| `srlTextUpdate` | int | 0x7f0405d2 | 4923 |
| `stackFromEnd` | int | 0x7f0405d3 | 4926 |
| `staggered` | int | 0x7f0405d4 | 4929 |
| `startDestination` | int | 0x7f0405d5 | 4932 |
| `startIconCheckable` | int | 0x7f0405d6 | 4935 |
| `startIconContentDescription` | int | 0x7f0405d7 | 4938 |
| `startIconDrawable` | int | 0x7f0405d8 | 4941 |
| `startIconMinSize` | int | 0x7f0405d9 | 4944 |
| `startIconScaleType` | int | 0x7f0405da | 4947 |
| `startIconTint` | int | 0x7f0405db | 4950 |
| `startIconTintMode` | int | 0x7f0405dc | 4953 |
| `state_above_anchor` | int | 0x7f0405de | 4959 |
| `state_collapsed` | int | 0x7f0405df | 4962 |
| `state_collapsible` | int | 0x7f0405e0 | 4965 |
| `state_dragged` | int | 0x7f0405e1 | 4968 |
| `state_error` | int | 0x7f0405e2 | 4971 |
| `state_indeterminate` | int | 0x7f0405e3 | 4974 |
| `state_liftable` | int | 0x7f0405e4 | 4977 |
| `state_lifted` | int | 0x7f0405e5 | 4980 |
| `state_with_icon` | int | 0x7f0405e6 | 4983 |
| `stateLabels` | int | 0x7f0405dd | 4956 |
| `statusBarBackground` | int | 0x7f0405e7 | 4986 |
| `statusBarForeground` | int | 0x7f0405e8 | 4989 |
| `statusBarScrim` | int | 0x7f0405e9 | 4992 |
| `stroke_Width` | int | 0x7f0405ec | 5001 |
| `strokeColor` | int | 0x7f0405ea | 4995 |
| `strokeWidth` | int | 0x7f0405eb | 4998 |
| `subheaderColor` | int | 0x7f0405ee | 5007 |
| `subheaderInsetEnd` | int | 0x7f0405ef | 5010 |
| `subheaderInsetStart` | int | 0x7f0405f0 | 5013 |
| `subheaderTextAppearance` | int | 0x7f0405f1 | 5016 |
| `subMenuArrow` | int | 0x7f0405ed | 5004 |
| `submitBackground` | int | 0x7f0405f2 | 5019 |
| `subtitle` | int | 0x7f0405f3 | 5022 |
| `subtitleCentered` | int | 0x7f0405f4 | 5025 |
| `subtitleTextAppearance` | int | 0x7f0405f5 | 5028 |
| `subtitleTextColor` | int | 0x7f0405f6 | 5031 |
| `subtitleTextStyle` | int | 0x7f0405f7 | 5034 |
| `suffixText` | int | 0x7f0405f8 | 5037 |
| `suffixTextAppearance` | int | 0x7f0405f9 | 5040 |
| `suffixTextColor` | int | 0x7f0405fa | 5043 |
| `suggestionRowLayout` | int | 0x7f0405fb | 5046 |
| `surface_type` | int | 0x7f0405fc | 5049 |
| `switchMinWidth` | int | 0x7f0405fd | 5052 |
| `switchPadding` | int | 0x7f0405fe | 5055 |
| `switchStyle` | int | 0x7f0405ff | 5058 |
| `switchTextAppearance` | int | 0x7f040600 | 5061 |
| `tabBackground` | int | 0x7f040603 | 5064 |
| `tabContentStart` | int | 0x7f040604 | 5067 |
| `tabGravity` | int | 0x7f040605 | 5070 |
| `tabIconTint` | int | 0x7f040606 | 5073 |
| `tabIconTintMode` | int | 0x7f040607 | 5076 |
| `tabIndicator` | int | 0x7f040608 | 5079 |
| `tabIndicatorAnimationDuration` | int | 0x7f040609 | 5082 |
| `tabIndicatorAnimationMode` | int | 0x7f04060a | 5085 |
| `tabIndicatorColor` | int | 0x7f04060b | 5088 |
| `tabIndicatorFullWidth` | int | 0x7f04060c | 5091 |
| `tabIndicatorGravity` | int | 0x7f04060d | 5094 |
| `tabIndicatorHeight` | int | 0x7f04060e | 5097 |
| `tabInlineLabel` | int | 0x7f04060f | 5100 |
| `tabMaxWidth` | int | 0x7f040610 | 5103 |
| `tabMinWidth` | int | 0x7f040611 | 5106 |
| `tabMode` | int | 0x7f040612 | 5109 |
| `tabPadding` | int | 0x7f040613 | 5112 |
| `tabPaddingBottom` | int | 0x7f040614 | 5115 |
| `tabPaddingEnd` | int | 0x7f040615 | 5118 |
| `tabPaddingStart` | int | 0x7f040616 | 5121 |
| `tabPaddingTop` | int | 0x7f040617 | 5124 |
| `tabRippleColor` | int | 0x7f040618 | 5127 |
| `tabSecondaryStyle` | int | 0x7f040619 | 5130 |
| `tabSelectedTextAppearance` | int | 0x7f04061a | 5133 |
| `tabSelectedTextColor` | int | 0x7f04061b | 5136 |
| `tabStyle` | int | 0x7f04061c | 5139 |
| `tabTextAppearance` | int | 0x7f04061d | 5142 |
| `tabTextColor` | int | 0x7f04061e | 5145 |
| `tabUnboundedRipple` | int | 0x7f04061f | 5148 |
| `targetId` | int | 0x7f040620 | 5151 |
| `targetPackage` | int | 0x7f040621 | 5154 |
| `telltales_tailColor` | int | 0x7f040622 | 5157 |
| `telltales_tailScale` | int | 0x7f040623 | 5160 |
| `telltales_velocityMode` | int | 0x7f040624 | 5163 |
| `textAllCaps` | int | 0x7f040626 | 5166 |
| `textAppearanceBody1` | int | 0x7f040627 | 5169 |
| `textAppearanceBody2` | int | 0x7f040628 | 5172 |
| `textAppearanceBodyLarge` | int | 0x7f040629 | 5175 |
| `textAppearanceBodyMedium` | int | 0x7f04062a | 5178 |
| `textAppearanceBodySmall` | int | 0x7f04062b | 5181 |
| `textAppearanceButton` | int | 0x7f04062c | 5184 |
| `textAppearanceCaption` | int | 0x7f04062d | 5187 |
| `textAppearanceDisplayLarge` | int | 0x7f04062e | 5190 |
| `textAppearanceDisplayMedium` | int | 0x7f04062f | 5193 |
| `textAppearanceDisplaySmall` | int | 0x7f040630 | 5196 |
| `textAppearanceHeadline1` | int | 0x7f040631 | 5199 |
| `textAppearanceHeadline2` | int | 0x7f040632 | 5202 |
| `textAppearanceHeadline3` | int | 0x7f040633 | 5205 |
| `textAppearanceHeadline4` | int | 0x7f040634 | 5208 |
| `textAppearanceHeadline5` | int | 0x7f040635 | 5211 |
| `textAppearanceHeadline6` | int | 0x7f040636 | 5214 |
| `textAppearanceHeadlineLarge` | int | 0x7f040637 | 5217 |
| `textAppearanceHeadlineMedium` | int | 0x7f040638 | 5220 |
| `textAppearanceHeadlineSmall` | int | 0x7f040639 | 5223 |
| `textAppearanceLabelLarge` | int | 0x7f04063a | 5226 |
| `textAppearanceLabelMedium` | int | 0x7f04063b | 5229 |
| `textAppearanceLabelSmall` | int | 0x7f04063c | 5232 |
| `textAppearanceLargePopupMenu` | int | 0x7f04063d | 5235 |
| `textAppearanceLineHeightEnabled` | int | 0x7f04063e | 5238 |
| `textAppearanceListItem` | int | 0x7f04063f | 5241 |
| `textAppearanceListItemSecondary` | int | 0x7f040640 | 5244 |
| `textAppearanceListItemSmall` | int | 0x7f040641 | 5247 |
| `textAppearanceOverline` | int | 0x7f040642 | 5250 |
| `textAppearancePopupMenuHeader` | int | 0x7f040643 | 5253 |
| `textAppearanceSearchResultSubtitle` | int | 0x7f040644 | 5256 |
| `textAppearanceSearchResultTitle` | int | 0x7f040645 | 5259 |
| `textAppearanceSmallPopupMenu` | int | 0x7f040646 | 5262 |
| `textAppearanceSubtitle1` | int | 0x7f040647 | 5265 |
| `textAppearanceSubtitle2` | int | 0x7f040648 | 5268 |
| `textAppearanceTitleLarge` | int | 0x7f040649 | 5271 |
| `textAppearanceTitleMedium` | int | 0x7f04064a | 5274 |
| `textAppearanceTitleSmall` | int | 0x7f04064b | 5277 |
| `textBackground` | int | 0x7f04064c | 5280 |
| `textBackgroundPanX` | int | 0x7f04064d | 5283 |
| `textBackgroundPanY` | int | 0x7f04064e | 5286 |
| `textBackgroundRotate` | int | 0x7f04064f | 5289 |
| `textBackgroundZoom` | int | 0x7f040650 | 5292 |
| `textColorAlertDialogListItem` | int | 0x7f040652 | 5295 |
| `textColorSearchUrl` | int | 0x7f040653 | 5298 |
| `textEndPadding` | int | 0x7f040654 | 5301 |
| `textFillColor` | int | 0x7f040655 | 5304 |
| `textInputFilledDenseStyle` | int | 0x7f040656 | 5307 |
| `textInputFilledExposedDropdownMenuStyle` | int | 0x7f040657 | 5310 |
| `textInputFilledStyle` | int | 0x7f040658 | 5313 |
| `textInputLayoutFocusedRectEnabled` | int | 0x7f040659 | 5316 |
| `textInputOutlinedDenseStyle` | int | 0x7f04065a | 5319 |
| `textInputOutlinedExposedDropdownMenuStyle` | int | 0x7f04065b | 5322 |
| `textInputOutlinedStyle` | int | 0x7f04065c | 5325 |
| `textInputStyle` | int | 0x7f04065d | 5328 |
| `textLocale` | int | 0x7f04065e | 5331 |
| `textOutlineColor` | int | 0x7f04065f | 5334 |
| `textOutlineThickness` | int | 0x7f040660 | 5337 |
| `textPanX` | int | 0x7f040661 | 5340 |
| `textPanY` | int | 0x7f040662 | 5343 |
| `textStartPadding` | int | 0x7f040664 | 5346 |
| `textureBlurFactor` | int | 0x7f040665 | 5349 |
| `textureEffect` | int | 0x7f040666 | 5352 |
| `textureHeight` | int | 0x7f040667 | 5355 |
| `textureWidth` | int | 0x7f040668 | 5358 |
| `theme` | int | 0x7f040669 | 5361 |
| `thickness` | int | 0x7f04066a | 5364 |
| `thumbColor` | int | 0x7f04066b | 5367 |
| `thumbElevation` | int | 0x7f04066c | 5370 |
| `thumbIcon` | int | 0x7f04066d | 5373 |
| `thumbIconSize` | int | 0x7f04066e | 5376 |
| `thumbIconTint` | int | 0x7f04066f | 5379 |
| `thumbIconTintMode` | int | 0x7f040670 | 5382 |
| `thumbRadius` | int | 0x7f040671 | 5385 |
| `thumbStrokeColor` | int | 0x7f040672 | 5388 |
| `thumbStrokeWidth` | int | 0x7f040673 | 5391 |
| `thumbTextPadding` | int | 0x7f040674 | 5394 |
| `thumbTint` | int | 0x7f040675 | 5397 |
| `thumbTintMode` | int | 0x7f040676 | 5400 |
| `tickColor` | int | 0x7f040677 | 5403 |
| `tickColorActive` | int | 0x7f040678 | 5406 |
| `tickColorInactive` | int | 0x7f040679 | 5409 |
| `tickMark` | int | 0x7f04067a | 5412 |
| `tickMarkTint` | int | 0x7f04067b | 5415 |
| `tickMarkTintMode` | int | 0x7f04067c | 5418 |
| `tickRadiusActive` | int | 0x7f04067d | 5421 |
| `tickRadiusInactive` | int | 0x7f04067e | 5424 |
| `tickVisible` | int | 0x7f04067f | 5427 |
| `tileBackgroundColor` | int | 0x7f040680 | 5430 |
| `time_bar_min_update_interval` | int | 0x7f040681 | 5433 |
| `tint` | int | 0x7f040682 | 5436 |
| `tintMode` | int | 0x7f040683 | 5439 |
| `tintNavigationIcon` | int | 0x7f040684 | 5442 |
| `title` | int | 0x7f040685 | 5445 |
| `titleCentered` | int | 0x7f040686 | 5448 |
| `titleCollapseMode` | int | 0x7f040687 | 5451 |
| `titleEnabled` | int | 0x7f040688 | 5454 |
| `titleMargin` | int | 0x7f040689 | 5457 |
| `titleMarginBottom` | int | 0x7f04068a | 5460 |
| `titleMarginEnd` | int | 0x7f04068b | 5463 |
| `titleMargins` | int | 0x7f04068e | 5472 |
| `titleMarginStart` | int | 0x7f04068c | 5466 |
| `titleMarginTop` | int | 0x7f04068d | 5469 |
| `titlePositionInterpolator` | int | 0x7f04068f | 5475 |
| `titleTextAppearance` | int | 0x7f040690 | 5478 |
| `titleTextColor` | int | 0x7f040691 | 5481 |
| `titleTextEllipsize` | int | 0x7f040692 | 5484 |
| `titleTextStyle` | int | 0x7f040693 | 5487 |
| `toggleCheckedStateOnClick` | int | 0x7f0406ad | 5490 |
| `toolbarId` | int | 0x7f0406ae | 5493 |
| `toolbarNavigationButtonStyle` | int | 0x7f0406af | 5496 |
| `toolbarStyle` | int | 0x7f0406b0 | 5499 |
| `toolbarSurfaceStyle` | int | 0x7f0406b1 | 5502 |
| `tooltipForegroundColor` | int | 0x7f0406b3 | 5505 |
| `tooltipFrameBackground` | int | 0x7f0406b4 | 5508 |
| `tooltipStyle` | int | 0x7f0406b5 | 5511 |
| `tooltipText` | int | 0x7f0406b6 | 5514 |
| `topInsetScrimEnabled` | int | 0x7f0406b7 | 5517 |
| `topLeftRadius` | int | 0x7f0406b8 | 5520 |
| `topRightRadius` | int | 0x7f0406b9 | 5523 |
| `touch_target_height` | int | 0x7f0406bd | 5535 |
| `touchAnchorId` | int | 0x7f0406ba | 5526 |
| `touchAnchorSide` | int | 0x7f0406bb | 5529 |
| `touchRegionId` | int | 0x7f0406bc | 5532 |
| `track` | int | 0x7f0406be | 5538 |
| `trackColor` | int | 0x7f0406bf | 5541 |
| `trackColorActive` | int | 0x7f0406c0 | 5544 |
| `trackColorInactive` | int | 0x7f0406c1 | 5547 |
| `trackCornerRadius` | int | 0x7f0406c2 | 5550 |
| `trackDecoration` | int | 0x7f0406c3 | 5553 |
| `trackDecorationTint` | int | 0x7f0406c4 | 5556 |
| `trackDecorationTintMode` | int | 0x7f0406c5 | 5559 |
| `trackHeight` | int | 0x7f0406c6 | 5562 |
| `trackThickness` | int | 0x7f0406c7 | 5565 |
| `trackTint` | int | 0x7f0406c8 | 5568 |
| `trackTintMode` | int | 0x7f0406c9 | 5571 |
| `transformPivotTarget` | int | 0x7f0406ca | 5574 |
| `transitionDisable` | int | 0x7f0406cb | 5577 |
| `transitionEasing` | int | 0x7f0406cc | 5580 |
| `transitionFlags` | int | 0x7f0406cd | 5583 |
| `transitionPathRotate` | int | 0x7f0406ce | 5586 |
| `transitionShapeAppearance` | int | 0x7f0406cf | 5589 |
| `triggerId` | int | 0x7f0406d0 | 5592 |
| `triggerReceiver` | int | 0x7f0406d1 | 5595 |
| `triggerSlack` | int | 0x7f0406d2 | 5598 |
| `ttcIndex` | int | 0x7f0406d3 | 5601 |
| `ucrop_artv_ratio_title` | int | 0x7f0406d4 | 5604 |
| `ucrop_artv_ratio_x` | int | 0x7f0406d5 | 5607 |
| `ucrop_artv_ratio_y` | int | 0x7f0406d6 | 5610 |
| `ucrop_aspect_ratio_x` | int | 0x7f0406d7 | 5613 |
| `ucrop_aspect_ratio_y` | int | 0x7f0406d8 | 5616 |
| `ucrop_circle_dimmed_layer` | int | 0x7f0406d9 | 5619 |
| `ucrop_dimmed_color` | int | 0x7f0406da | 5622 |
| `ucrop_frame_color` | int | 0x7f0406db | 5625 |
| `ucrop_frame_stroke_size` | int | 0x7f0406dc | 5628 |
| `ucrop_grid_color` | int | 0x7f0406dd | 5631 |
| `ucrop_grid_column_count` | int | 0x7f0406de | 5634 |
| `ucrop_grid_row_count` | int | 0x7f0406df | 5637 |
| `ucrop_grid_stroke_size` | int | 0x7f0406e0 | 5640 |
| `ucrop_show_frame` | int | 0x7f0406e1 | 5643 |
| `ucrop_show_grid` | int | 0x7f0406e2 | 5646 |
| `ucrop_show_oval_crop_frame` | int | 0x7f0406e3 | 5649 |
| `uiCompass` | int | 0x7f0406e4 | 5652 |
| `uiMapToolbar` | int | 0x7f0406e5 | 5655 |
| `uiRotateGestures` | int | 0x7f0406e6 | 5658 |
| `uiScrollGestures` | int | 0x7f0406e7 | 5661 |
| `uiScrollGesturesDuringRotateOrZoom` | int | 0x7f0406e8 | 5664 |
| `uiTiltGestures` | int | 0x7f0406e9 | 5667 |
| `uiZoomControls` | int | 0x7f0406ea | 5670 |
| `uiZoomGestures` | int | 0x7f0406eb | 5673 |
| `unplayed_color` | int | 0x7f0406ec | 5676 |
| `upDuration` | int | 0x7f0406ed | 5679 |
| `uri` | int | 0x7f0406ee | 5682 |
| `use_artwork` | int | 0x7f0406f3 | 5697 |
| `use_controller` | int | 0x7f0406f4 | 5700 |
| `useCompatPadding` | int | 0x7f0406ef | 5685 |
| `useDrawerArrowDrawable` | int | 0x7f0406f0 | 5688 |
| `useMaterialThemeColors` | int | 0x7f0406f1 | 5691 |
| `useViewLifecycle` | int | 0x7f0406f2 | 5694 |
| `values` | int | 0x7f0406f5 | 5703 |
| `verticalOffset` | int | 0x7f0406f6 | 5706 |
| `verticalOffsetWithText` | int | 0x7f0406f7 | 5709 |
| `viewInflaterClass` | int | 0x7f0406f8 | 5712 |
| `viewTransitionMode` | int | 0x7f0406f9 | 5715 |
| `viewTransitionOnCross` | int | 0x7f0406fa | 5718 |
| `viewTransitionOnNegativeCross` | int | 0x7f0406fb | 5721 |
| `viewTransitionOnPositiveCross` | int | 0x7f0406fc | 5724 |
| `visibilityMode` | int | 0x7f0406fd | 5727 |
| `voiceIcon` | int | 0x7f0406fe | 5730 |
| `vvFrameColor` | int | 0x7f0406ff | 5733 |
| `vvFrameCornerColor` | int | 0x7f040700 | 5736 |
| `vvFrameCornerSize` | int | 0x7f040701 | 5739 |
| `vvFrameCornerStrokeWidth` | int | 0x7f040702 | 5742 |
| `vvFrameDrawable` | int | 0x7f040703 | 5745 |
| `vvFrameGravity` | int | 0x7f040704 | 5748 |
| `vvFrameHeight` | int | 0x7f040705 | 5751 |
| `vvFrameLineStrokeWidth` | int | 0x7f040706 | 5754 |
| `vvFramePaddingBottom` | int | 0x7f040707 | 5757 |
| `vvFramePaddingLeft` | int | 0x7f040708 | 5760 |
| `vvFramePaddingRight` | int | 0x7f040709 | 5763 |
| `vvFramePaddingTop` | int | 0x7f04070a | 5766 |
| `vvFrameRatio` | int | 0x7f04070b | 5769 |
| `vvFrameWidth` | int | 0x7f04070c | 5772 |
| `vvLabelText` | int | 0x7f04070d | 5775 |
| `vvLabelTextColor` | int | 0x7f04070e | 5778 |
| `vvLabelTextLocation` | int | 0x7f04070f | 5781 |
| `vvLabelTextPadding` | int | 0x7f040710 | 5784 |
| `vvLabelTextSize` | int | 0x7f040711 | 5787 |
| `vvLabelTextWidth` | int | 0x7f040712 | 5790 |
| `vvLaserAnimationInterval` | int | 0x7f040713 | 5793 |
| `vvLaserColor` | int | 0x7f040714 | 5796 |
| `vvLaserDrawable` | int | 0x7f040715 | 5799 |
| `vvLaserDrawableRatio` | int | 0x7f040716 | 5802 |
| `vvLaserGridColumn` | int | 0x7f040717 | 5805 |
| `vvLaserGridHeight` | int | 0x7f040718 | 5808 |
| `vvLaserLineHeight` | int | 0x7f040719 | 5811 |
| `vvLaserMovementSpeed` | int | 0x7f04071a | 5814 |
| `vvLaserStyle` | int | 0x7f04071b | 5817 |
| `vvMaskColor` | int | 0x7f04071c | 5820 |
| `vvPointAnimation` | int | 0x7f04071d | 5823 |
| `vvPointAnimationInterval` | int | 0x7f04071e | 5826 |
| `vvPointColor` | int | 0x7f04071f | 5829 |
| `vvPointDrawable` | int | 0x7f040720 | 5832 |
| `vvPointRadius` | int | 0x7f040721 | 5835 |
| `vvPointStrokeColor` | int | 0x7f040722 | 5838 |
| `vvPointStrokeRatio` | int | 0x7f040723 | 5841 |
| `vvViewfinderStyle` | int | 0x7f040724 | 5844 |
| `warmth` | int | 0x7f040725 | 5847 |
| `waveDecay` | int | 0x7f040726 | 5850 |
| `waveOffset` | int | 0x7f040727 | 5853 |
| `wavePeriod` | int | 0x7f040728 | 5856 |
| `wavePhase` | int | 0x7f040729 | 5859 |
| `waveShape` | int | 0x7f04072a | 5862 |
| `waveVariesBy` | int | 0x7f04072b | 5865 |
| `week_background` | int | 0x7f04072c | 5868 |
| `week_bar_height` | int | 0x7f04072d | 5871 |
| `week_bar_view` | int | 0x7f04072e | 5874 |
| `week_line_background` | int | 0x7f04072f | 5877 |
| `week_line_margin` | int | 0x7f040730 | 5880 |
| `week_start_with` | int | 0x7f040731 | 5883 |
| `week_text_color` | int | 0x7f040732 | 5886 |
| `week_text_size` | int | 0x7f040733 | 5889 |
| `week_view` | int | 0x7f040734 | 5892 |
| `week_view_scrollable` | int | 0x7f040735 | 5895 |
| `wheelview_dividerColor` | int | 0x7f040736 | 5898 |
| `wheelview_dividerWidth` | int | 0x7f040737 | 5901 |
| `wheelview_gravity` | int | 0x7f040738 | 5904 |
| `wheelview_lineSpacingMultiplier` | int | 0x7f040739 | 5907 |
| `wheelview_textColorCenter` | int | 0x7f04073a | 5910 |
| `wheelview_textColorOut` | int | 0x7f04073b | 5913 |
| `wheelview_textSize` | int | 0x7f04073c | 5916 |
| `windowActionBar` | int | 0x7f04073d | 5919 |
| `windowActionBarOverlay` | int | 0x7f04073e | 5922 |
| `windowActionModeOverlay` | int | 0x7f04073f | 5925 |
| `windowFixedHeightMajor` | int | 0x7f040740 | 5928 |
| `windowFixedHeightMinor` | int | 0x7f040741 | 5931 |
| `windowFixedWidthMajor` | int | 0x7f040742 | 5934 |
| `windowFixedWidthMinor` | int | 0x7f040743 | 5937 |
| `windowMinWidthMajor` | int | 0x7f040744 | 5940 |
| `windowMinWidthMinor` | int | 0x7f040745 | 5943 |
| `windowNoTitle` | int | 0x7f040746 | 5946 |
| `windowSplashScreenAnimatedIcon` | int | 0x7f040747 | 5949 |
| `windowSplashScreenAnimationDuration` | int | 0x7f040748 | 5952 |
| `windowSplashScreenBackground` | int | 0x7f040749 | 5955 |
| `windowSplashScreenIconBackgroundColor` | int | 0x7f04074a | 5958 |
| `year_view` | int | 0x7f04074e | 5970 |
| `year_view_background` | int | 0x7f04074f | 5973 |
| `year_view_current_day_text_color` | int | 0x7f040750 | 5976 |
| `year_view_day_text_color` | int | 0x7f040751 | 5979 |
| `year_view_day_text_size` | int | 0x7f040752 | 5982 |
| `year_view_month_height` | int | 0x7f040753 | 5985 |
| `year_view_month_padding_bottom` | int | 0x7f040754 | 5988 |
| `year_view_month_padding_left` | int | 0x7f040755 | 5991 |
| `year_view_month_padding_right` | int | 0x7f040756 | 5994 |
| `year_view_month_padding_top` | int | 0x7f040757 | 5997 |
| `year_view_month_text_color` | int | 0x7f040758 | 6000 |
| `year_view_month_text_size` | int | 0x7f040759 | 6003 |
| `year_view_padding` | int | 0x7f04075a | 6006 |
| `year_view_padding_left` | int | 0x7f04075b | 6009 |
| `year_view_padding_right` | int | 0x7f04075c | 6012 |
| `year_view_scheme_color` | int | 0x7f04075d | 6015 |
| `year_view_scrollable` | int | 0x7f04075e | 6018 |
| `year_view_select_text_color` | int | 0x7f04075f | 6021 |
| `year_view_week_height` | int | 0x7f040760 | 6024 |
| `year_view_week_text_color` | int | 0x7f040761 | 6027 |
| `year_view_week_text_size` | int | 0x7f040762 | 6030 |
| `yearSelectedStyle` | int | 0x7f04074b | 5961 |
| `yearStyle` | int | 0x7f04074c | 5964 |
| `yearTodayStyle` | int | 0x7f04074d | 5967 |
| `zoomEnabled` | int | 0x7f040764 | 6036 |
| `zOrderOnTop` | int | 0x7f040763 | 6033 |

### `com.gku.xtugo.R$bool`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_action_bar_embed_tabs` | int | 0x7f050000 | 6046 |
| `abc_config_actionMenuItemAllCaps` | int | 0x7f050001 | 6049 |
| `mtrl_btn_textappearance_all_caps` | int | 0x7f050002 | 6052 |

### `com.gku.xtugo.R$color`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_background_cache_hint_selector_material_dark` | int | 0x7f060000 | 6133 |
| `abc_background_cache_hint_selector_material_light` | int | 0x7f060001 | 6136 |
| `abc_btn_colored_borderless_text_material` | int | 0x7f060002 | 6139 |
| `abc_btn_colored_text_material` | int | 0x7f060003 | 6142 |
| `abc_color_highlight_material` | int | 0x7f060004 | 6145 |
| `abc_decor_view_status_guard` | int | 0x7f060005 | 6148 |
| `abc_decor_view_status_guard_light` | int | 0x7f060006 | 6151 |
| `abc_hint_foreground_material_dark` | int | 0x7f060007 | 6154 |
| `abc_hint_foreground_material_light` | int | 0x7f060008 | 6157 |
| `abc_primary_text_disable_only_material_dark` | int | 0x7f060009 | 6160 |
| `abc_primary_text_disable_only_material_light` | int | 0x7f06000a | 6163 |
| `abc_primary_text_material_dark` | int | 0x7f06000b | 6166 |
| `abc_primary_text_material_light` | int | 0x7f06000c | 6169 |
| `abc_search_url_text` | int | 0x7f06000d | 6172 |
| `abc_search_url_text_normal` | int | 0x7f06000e | 6175 |
| `abc_search_url_text_pressed` | int | 0x7f06000f | 6178 |
| `abc_search_url_text_selected` | int | 0x7f060010 | 6181 |
| `abc_secondary_text_material_dark` | int | 0x7f060011 | 6184 |
| `abc_secondary_text_material_light` | int | 0x7f060012 | 6187 |
| `abc_tint_btn_checkable` | int | 0x7f060013 | 6190 |
| `abc_tint_default` | int | 0x7f060014 | 6193 |
| `abc_tint_edittext` | int | 0x7f060015 | 6196 |
| `abc_tint_seek_thumb` | int | 0x7f060016 | 6199 |
| `abc_tint_spinner` | int | 0x7f060017 | 6202 |
| `abc_tint_switch_track` | int | 0x7f060018 | 6205 |
| `accent_material_dark` | int | 0x7f06001a | 6208 |
| `accent_material_light` | int | 0x7f06001b | 6211 |
| `action_bar_title_color` | int | 0x7f06001c | 6214 |
| `alertButtonTextColor` | int | 0x7f06001d | 6217 |
| `androidx_core_ripple_material_light` | int | 0x7f06001e | 6220 |
| `androidx_core_secondary_text_default_material_light` | int | 0x7f06001f | 6223 |
| `background_floating_material_dark` | int | 0x7f060022 | 6226 |
| `background_floating_material_light` | int | 0x7f060023 | 6229 |
| `background_light_dark` | int | 0x7f060024 | 6232 |
| `background_material_dark` | int | 0x7f060025 | 6235 |
| `background_material_light` | int | 0x7f060026 | 6238 |
| `ball1_color` | int | 0x7f060027 | 6241 |
| `ball2_color` | int | 0x7f060028 | 6244 |
| `ball3_color` | int | 0x7f060029 | 6247 |
| `ball4_color` | int | 0x7f06002a | 6250 |
| `black_010101` | int | 0x7f06002c | 6253 |
| `black_181818` | int | 0x7f06002d | 6256 |
| `black_2b2b2b` | int | 0x7f06002e | 6259 |
| `black_313131` | int | 0x7f06002f | 6262 |
| `black_333333` | int | 0x7f060030 | 6265 |
| `black_414141` | int | 0x7f060031 | 6268 |
| `black_515151` | int | 0x7f060032 | 6271 |
| `black_616161` | int | 0x7f060033 | 6274 |
| `black_transparency_50` | int | 0x7f060034 | 6277 |
| `blue_0090FF` | int | 0x7f060036 | 6280 |
| `bottom_container_bg` | int | 0x7f060037 | 6283 |
| `bottom_navigation_select_color` | int | 0x7f060038 | 6286 |
| `bright_foreground_disabled_material_dark` | int | 0x7f060039 | 6289 |
| `bright_foreground_disabled_material_light` | int | 0x7f06003a | 6292 |
| `bright_foreground_inverse_material_dark` | int | 0x7f06003b | 6295 |
| `bright_foreground_inverse_material_light` | int | 0x7f06003c | 6298 |
| `bright_foreground_material_dark` | int | 0x7f06003d | 6301 |
| `bright_foreground_material_light` | int | 0x7f06003e | 6304 |
| `btn_start_color` | int | 0x7f060040 | 6307 |
| `button_material_dark` | int | 0x7f060042 | 6310 |
| `button_material_light` | int | 0x7f060043 | 6313 |
| `call_notification_answer_color` | int | 0x7f060045 | 6316 |
| `call_notification_decline_color` | int | 0x7f060046 | 6319 |
| `camera_scan_navigation_bar_color` | int | 0x7f060048 | 6322 |
| `camera_scan_status_bar_color` | int | 0x7f060049 | 6325 |
| `carColorBlue` | int | 0x7f06004a | 6328 |
| `carColorGreen` | int | 0x7f06004b | 6331 |
| `carColorRed` | int | 0x7f06004c | 6334 |
| `carColorYellow` | int | 0x7f06004d | 6337 |
| `cardview_dark_background` | int | 0x7f06004e | 6340 |
| `cardview_light_background` | int | 0x7f06004f | 6343 |
| `cardview_shadow_end_color` | int | 0x7f060050 | 6346 |
| `cardview_shadow_start_color` | int | 0x7f060051 | 6349 |
| `clearColor` | int | 0x7f060052 | 6352 |
| `color_E15151` | int | 0x7f060062 | 6400 |
| `colorAccent` | int | 0x7f060053 | 6355 |
| `colorAccentSecondary` | int | 0x7f060054 | 6358 |
| `colorControlActivated` | int | 0x7f060055 | 6361 |
| `colorPrimary` | int | 0x7f060056 | 6364 |
| `colorPrimaryDark` | int | 0x7f060057 | 6367 |
| `colorRed` | int | 0x7f060058 | 6370 |
| `colorSplashBackground` | int | 0x7f060059 | 6373 |
| `colorTheme` | int | 0x7f06005a | 6376 |
| `colorTheme_selected` | int | 0x7f06005b | 6379 |
| `colorTheme_selected_2` | int | 0x7f06005c | 6382 |
| `colorTheme_switch` | int | 0x7f06005d | 6385 |
| `colorToolbarText` | int | 0x7f06005e | 6388 |
| `colorTransparent` | int | 0x7f06005f | 6391 |
| `colorWhite` | int | 0x7f060060 | 6394 |
| `colorWhite_3f` | int | 0x7f060061 | 6397 |
| `common_google_signin_btn_text_dark` | int | 0x7f060063 | 6403 |
| `common_google_signin_btn_text_dark_default` | int | 0x7f060064 | 6406 |
| `common_google_signin_btn_text_dark_disabled` | int | 0x7f060065 | 6409 |
| `common_google_signin_btn_text_dark_focused` | int | 0x7f060066 | 6412 |
| `common_google_signin_btn_text_dark_pressed` | int | 0x7f060067 | 6415 |
| `common_google_signin_btn_text_light` | int | 0x7f060068 | 6418 |
| `common_google_signin_btn_text_light_default` | int | 0x7f060069 | 6421 |
| `common_google_signin_btn_text_light_disabled` | int | 0x7f06006a | 6424 |
| `common_google_signin_btn_text_light_focused` | int | 0x7f06006b | 6427 |
| `common_google_signin_btn_text_light_pressed` | int | 0x7f06006c | 6430 |
| `common_google_signin_btn_tint` | int | 0x7f06006d | 6433 |
| `confirm_button_text_color` | int | 0x7f06006e | 6436 |
| `cyan` | int | 0x7f06006f | 6439 |
| `danger_color` | int | 0x7f060070 | 6442 |
| `default_indexBar_selectedTextColor` | int | 0x7f060075 | 6457 |
| `default_indexBar_textColor` | int | 0x7f060076 | 6460 |
| `defaultDivisionLine` | int | 0x7f060071 | 6445 |
| `defaultHintText` | int | 0x7f060072 | 6448 |
| `defaultLinkText` | int | 0x7f060073 | 6451 |
| `defaultMainText` | int | 0x7f060074 | 6454 |
| `desc` | int | 0x7f060077 | 6463 |
| `design_bottom_navigation_shadow_color` | int | 0x7f060078 | 6466 |
| `design_box_stroke_color` | int | 0x7f060079 | 6469 |
| `design_dark_default_color_background` | int | 0x7f06007a | 6472 |
| `design_dark_default_color_error` | int | 0x7f06007b | 6475 |
| `design_dark_default_color_on_background` | int | 0x7f06007c | 6478 |
| `design_dark_default_color_on_error` | int | 0x7f06007d | 6481 |
| `design_dark_default_color_on_primary` | int | 0x7f06007e | 6484 |
| `design_dark_default_color_on_secondary` | int | 0x7f06007f | 6487 |
| `design_dark_default_color_on_surface` | int | 0x7f060080 | 6490 |
| `design_dark_default_color_primary` | int | 0x7f060081 | 6493 |
| `design_dark_default_color_primary_dark` | int | 0x7f060082 | 6496 |
| `design_dark_default_color_primary_variant` | int | 0x7f060083 | 6499 |
| `design_dark_default_color_secondary` | int | 0x7f060084 | 6502 |
| `design_dark_default_color_secondary_variant` | int | 0x7f060085 | 6505 |
| `design_dark_default_color_surface` | int | 0x7f060086 | 6508 |
| `design_default_color_background` | int | 0x7f060087 | 6511 |
| `design_default_color_error` | int | 0x7f060088 | 6514 |
| `design_default_color_on_background` | int | 0x7f060089 | 6517 |
| `design_default_color_on_error` | int | 0x7f06008a | 6520 |
| `design_default_color_on_primary` | int | 0x7f06008b | 6523 |
| `design_default_color_on_secondary` | int | 0x7f06008c | 6526 |
| `design_default_color_on_surface` | int | 0x7f06008d | 6529 |
| `design_default_color_primary` | int | 0x7f06008e | 6532 |
| `design_default_color_primary_dark` | int | 0x7f06008f | 6535 |
| `design_default_color_primary_variant` | int | 0x7f060090 | 6538 |
| `design_default_color_secondary` | int | 0x7f060091 | 6541 |
| `design_default_color_secondary_variant` | int | 0x7f060092 | 6544 |
| `design_default_color_surface` | int | 0x7f060093 | 6547 |
| `design_error` | int | 0x7f060094 | 6550 |
| `design_fab_shadow_end_color` | int | 0x7f060095 | 6553 |
| `design_fab_shadow_mid_color` | int | 0x7f060096 | 6556 |
| `design_fab_shadow_start_color` | int | 0x7f060097 | 6559 |
| `design_fab_stroke_end_inner_color` | int | 0x7f060098 | 6562 |
| `design_fab_stroke_end_outer_color` | int | 0x7f060099 | 6565 |
| `design_fab_stroke_top_inner_color` | int | 0x7f06009a | 6568 |
| `design_fab_stroke_top_outer_color` | int | 0x7f06009b | 6571 |
| `design_icon_tint` | int | 0x7f06009c | 6574 |
| `design_snackbar_background_color` | int | 0x7f06009d | 6577 |
| `dev_add_text_color` | int | 0x7f06009e | 6580 |
| `dev_liveview_btn_bg` | int | 0x7f06009f | 6583 |
| `dev_switch_page_bg` | int | 0x7f0600a0 | 6586 |
| `dialog_bg` | int | 0x7f0600a2 | 6589 |
| `dim_foreground_disabled_material_dark` | int | 0x7f0600a8 | 6592 |
| `dim_foreground_disabled_material_light` | int | 0x7f0600a9 | 6595 |
| `dim_foreground_material_dark` | int | 0x7f0600aa | 6598 |
| `dim_foreground_material_light` | int | 0x7f0600ab | 6601 |
| `disableStateColor` | int | 0x7f0600ac | 6604 |
| `drawerSplitColor` | int | 0x7f0600af | 6607 |
| `ec_store_window_background` | int | 0x7f0600b0 | 6610 |
| `edit_bg_color` | int | 0x7f0600b1 | 6613 |
| `edit_line` | int | 0x7f0600b2 | 6616 |
| `error_color_material_dark` | int | 0x7f0600b3 | 6619 |
| `error_color_material_light` | int | 0x7f0600b4 | 6622 |
| `exo_black_opacity_60` | int | 0x7f0600b5 | 6625 |
| `exo_black_opacity_70` | int | 0x7f0600b6 | 6628 |
| `exo_bottom_bar_background` | int | 0x7f0600b7 | 6631 |
| `exo_edit_mode_background_color` | int | 0x7f0600b8 | 6634 |
| `exo_error_message_background_color` | int | 0x7f0600b9 | 6637 |
| `exo_styled_error_message_background` | int | 0x7f0600ba | 6640 |
| `exo_white` | int | 0x7f0600bb | 6643 |
| `exo_white_opacity_70` | int | 0x7f0600bc | 6646 |
| `font_black` | int | 0x7f0600bd | 6649 |
| `foreground_material_dark` | int | 0x7f0600be | 6652 |
| `foreground_material_light` | int | 0x7f0600bf | 6655 |
| `full_transparent` | int | 0x7f0600c0 | 6658 |
| `general_background_color` | int | 0x7f0600cd | 6697 |
| `general_highlight_color` | int | 0x7f0600ce | 6700 |
| `generalCellBackgroundColor` | int | 0x7f0600c1 | 6661 |
| `generalDetailTextColor` | int | 0x7f0600c2 | 6664 |
| `generalEditHintColor` | int | 0x7f0600c3 | 6667 |
| `generalLineBgColor` | int | 0x7f0600c4 | 6670 |
| `generalLineColor` | int | 0x7f0600c5 | 6673 |
| `generalSplitColor` | int | 0x7f0600c6 | 6676 |
| `generalTextBlackColor` | int | 0x7f0600c7 | 6679 |
| `generalTextBlueColor` | int | 0x7f0600c8 | 6682 |
| `generalTextColor` | int | 0x7f0600c9 | 6685 |
| `generalTextRedColor` | int | 0x7f0600ca | 6688 |
| `generalTipTextColor` | int | 0x7f0600cb | 6691 |
| `generalTitleColor` | int | 0x7f0600cc | 6694 |
| `gray_252525` | int | 0x7f0600d0 | 6703 |
| `gray_58575d` | int | 0x7f0600d1 | 6706 |
| `gray_656565` | int | 0x7f0600d2 | 6709 |
| `gray_8E8D93` | int | 0x7f0600d3 | 6712 |
| `gray_959595` | int | 0x7f0600d4 | 6715 |
| `gray_999999` | int | 0x7f0600d5 | 6718 |
| `gray_B1B1B1` | int | 0x7f0600d6 | 6721 |
| `gray_line` | int | 0x7f0600d8 | 6724 |
| `gray_line_another` | int | 0x7f0600d9 | 6727 |
| `green` | int | 0x7f0600de | 6730 |
| `green_4EB107` | int | 0x7f0600df | 6733 |
| `green_A5DF29` | int | 0x7f0600e0 | 6736 |
| `green_B0F916` | int | 0x7f0600e1 | 6739 |
| `green_google_play` | int | 0x7f0600e2 | 6742 |
| `guide_color_bg` | int | 0x7f0600e4 | 6745 |
| `highlighted_text_material_dark` | int | 0x7f0600e8 | 6748 |
| `highlighted_text_material_light` | int | 0x7f0600e9 | 6751 |
| `line` | int | 0x7f0600f0 | 6754 |
| `line_color` | int | 0x7f0600f1 | 6757 |
| `liveview_display_color` | int | 0x7f0600f5 | 6760 |
| `liveview_display_manager_color` | int | 0x7f0600f6 | 6763 |
| `liveview_setting_mode_text` | int | 0x7f0600f7 | 6766 |
| `login_code_text_color` | int | 0x7f0600f9 | 6769 |
| `login_logo_bg` | int | 0x7f0600fa | 6772 |
| `login_phone_left_bg_color` | int | 0x7f0600fb | 6775 |
| `m3_appbar_overlay_color` | int | 0x7f0600fc | 6778 |
| `m3_assist_chip_icon_tint_color` | int | 0x7f0600fd | 6781 |
| `m3_assist_chip_stroke_color` | int | 0x7f0600fe | 6784 |
| `m3_bottom_sheet_drag_handle_color` | int | 0x7f0600ff | 6787 |
| `m3_button_background_color_selector` | int | 0x7f060100 | 6790 |
| `m3_button_foreground_color_selector` | int | 0x7f060101 | 6793 |
| `m3_button_outline_color_selector` | int | 0x7f060102 | 6796 |
| `m3_button_ripple_color` | int | 0x7f060103 | 6799 |
| `m3_button_ripple_color_selector` | int | 0x7f060104 | 6802 |
| `m3_calendar_item_disabled_text` | int | 0x7f060105 | 6805 |
| `m3_calendar_item_stroke_color` | int | 0x7f060106 | 6808 |
| `m3_card_foreground_color` | int | 0x7f060107 | 6811 |
| `m3_card_ripple_color` | int | 0x7f060108 | 6814 |
| `m3_card_stroke_color` | int | 0x7f060109 | 6817 |
| `m3_checkbox_button_icon_tint` | int | 0x7f06010a | 6820 |
| `m3_checkbox_button_tint` | int | 0x7f06010b | 6823 |
| `m3_chip_assist_text_color` | int | 0x7f06010c | 6826 |
| `m3_chip_background_color` | int | 0x7f06010d | 6829 |
| `m3_chip_ripple_color` | int | 0x7f06010e | 6832 |
| `m3_chip_stroke_color` | int | 0x7f06010f | 6835 |
| `m3_chip_text_color` | int | 0x7f060110 | 6838 |
| `m3_dark_default_color_primary_text` | int | 0x7f060111 | 6841 |
| `m3_dark_default_color_secondary_text` | int | 0x7f060112 | 6844 |
| `m3_dark_highlighted_text` | int | 0x7f060113 | 6847 |
| `m3_dark_hint_foreground` | int | 0x7f060114 | 6850 |
| `m3_dark_primary_text_disable_only` | int | 0x7f060115 | 6853 |
| `m3_default_color_primary_text` | int | 0x7f060116 | 6856 |
| `m3_default_color_secondary_text` | int | 0x7f060117 | 6859 |
| `m3_dynamic_dark_default_color_primary_text` | int | 0x7f060118 | 6862 |
| `m3_dynamic_dark_default_color_secondary_text` | int | 0x7f060119 | 6865 |
| `m3_dynamic_dark_highlighted_text` | int | 0x7f06011a | 6868 |
| `m3_dynamic_dark_hint_foreground` | int | 0x7f06011b | 6871 |
| `m3_dynamic_dark_primary_text_disable_only` | int | 0x7f06011c | 6874 |
| `m3_dynamic_default_color_primary_text` | int | 0x7f06011d | 6877 |
| `m3_dynamic_default_color_secondary_text` | int | 0x7f06011e | 6880 |
| `m3_dynamic_highlighted_text` | int | 0x7f06011f | 6883 |
| `m3_dynamic_hint_foreground` | int | 0x7f060120 | 6886 |
| `m3_dynamic_primary_text_disable_only` | int | 0x7f060121 | 6889 |
| `m3_efab_ripple_color_selector` | int | 0x7f060122 | 6892 |
| `m3_elevated_chip_background_color` | int | 0x7f060123 | 6895 |
| `m3_fab_efab_background_color_selector` | int | 0x7f060124 | 6898 |
| `m3_fab_efab_foreground_color_selector` | int | 0x7f060125 | 6901 |
| `m3_fab_ripple_color_selector` | int | 0x7f060126 | 6904 |
| `m3_filled_icon_button_container_color_selector` | int | 0x7f060127 | 6907 |
| `m3_highlighted_text` | int | 0x7f060128 | 6910 |
| `m3_hint_foreground` | int | 0x7f060129 | 6913 |
| `m3_icon_button_icon_color_selector` | int | 0x7f06012a | 6916 |
| `m3_navigation_bar_item_with_indicator_icon_tint` | int | 0x7f06012b | 6919 |
| `m3_navigation_bar_item_with_indicator_label_tint` | int | 0x7f06012c | 6922 |
| `m3_navigation_bar_ripple_color_selector` | int | 0x7f06012d | 6925 |
| `m3_navigation_item_background_color` | int | 0x7f06012e | 6928 |
| `m3_navigation_item_icon_tint` | int | 0x7f06012f | 6931 |
| `m3_navigation_item_ripple_color` | int | 0x7f060130 | 6934 |
| `m3_navigation_item_text_color` | int | 0x7f060131 | 6937 |
| `m3_navigation_rail_item_with_indicator_icon_tint` | int | 0x7f060132 | 6940 |
| `m3_navigation_rail_item_with_indicator_label_tint` | int | 0x7f060133 | 6943 |
| `m3_navigation_rail_ripple_color_selector` | int | 0x7f060134 | 6946 |
| `m3_popupmenu_overlay_color` | int | 0x7f060135 | 6949 |
| `m3_primary_text_disable_only` | int | 0x7f060136 | 6952 |
| `m3_radiobutton_button_tint` | int | 0x7f060137 | 6955 |
| `m3_radiobutton_ripple_tint` | int | 0x7f060138 | 6958 |
| `m3_ref_palette_black` | int | 0x7f060139 | 6961 |
| `m3_ref_palette_dynamic_neutral_variant0` | int | 0x7f060152 | 7036 |
| `m3_ref_palette_dynamic_neutral_variant10` | int | 0x7f060153 | 7039 |
| `m3_ref_palette_dynamic_neutral_variant100` | int | 0x7f060154 | 7042 |
| `m3_ref_palette_dynamic_neutral_variant20` | int | 0x7f060155 | 7045 |
| `m3_ref_palette_dynamic_neutral_variant30` | int | 0x7f060156 | 7048 |
| `m3_ref_palette_dynamic_neutral_variant40` | int | 0x7f060157 | 7051 |
| `m3_ref_palette_dynamic_neutral_variant50` | int | 0x7f060158 | 7054 |
| `m3_ref_palette_dynamic_neutral_variant60` | int | 0x7f060159 | 7057 |
| `m3_ref_palette_dynamic_neutral_variant70` | int | 0x7f06015a | 7060 |
| `m3_ref_palette_dynamic_neutral_variant80` | int | 0x7f06015b | 7063 |
| `m3_ref_palette_dynamic_neutral_variant90` | int | 0x7f06015c | 7066 |
| `m3_ref_palette_dynamic_neutral_variant95` | int | 0x7f06015d | 7069 |
| `m3_ref_palette_dynamic_neutral_variant99` | int | 0x7f06015e | 7072 |
| `m3_ref_palette_dynamic_neutral0` | int | 0x7f06013a | 6964 |
| `m3_ref_palette_dynamic_neutral10` | int | 0x7f06013b | 6967 |
| `m3_ref_palette_dynamic_neutral100` | int | 0x7f06013c | 6970 |
| `m3_ref_palette_dynamic_neutral12` | int | 0x7f06013d | 6973 |
| `m3_ref_palette_dynamic_neutral17` | int | 0x7f06013e | 6976 |
| `m3_ref_palette_dynamic_neutral20` | int | 0x7f06013f | 6979 |
| `m3_ref_palette_dynamic_neutral22` | int | 0x7f060140 | 6982 |
| `m3_ref_palette_dynamic_neutral24` | int | 0x7f060141 | 6985 |
| `m3_ref_palette_dynamic_neutral30` | int | 0x7f060142 | 6988 |
| `m3_ref_palette_dynamic_neutral4` | int | 0x7f060143 | 6991 |
| `m3_ref_palette_dynamic_neutral40` | int | 0x7f060144 | 6994 |
| `m3_ref_palette_dynamic_neutral50` | int | 0x7f060145 | 6997 |
| `m3_ref_palette_dynamic_neutral6` | int | 0x7f060146 | 7000 |
| `m3_ref_palette_dynamic_neutral60` | int | 0x7f060147 | 7003 |
| `m3_ref_palette_dynamic_neutral70` | int | 0x7f060148 | 7006 |
| `m3_ref_palette_dynamic_neutral80` | int | 0x7f060149 | 7009 |
| `m3_ref_palette_dynamic_neutral87` | int | 0x7f06014a | 7012 |
| `m3_ref_palette_dynamic_neutral90` | int | 0x7f06014b | 7015 |
| `m3_ref_palette_dynamic_neutral92` | int | 0x7f06014c | 7018 |
| `m3_ref_palette_dynamic_neutral94` | int | 0x7f06014d | 7021 |
| `m3_ref_palette_dynamic_neutral95` | int | 0x7f06014e | 7024 |
| `m3_ref_palette_dynamic_neutral96` | int | 0x7f06014f | 7027 |
| `m3_ref_palette_dynamic_neutral98` | int | 0x7f060150 | 7030 |
| `m3_ref_palette_dynamic_neutral99` | int | 0x7f060151 | 7033 |
| `m3_ref_palette_dynamic_primary0` | int | 0x7f06015f | 7075 |
| `m3_ref_palette_dynamic_primary10` | int | 0x7f060160 | 7078 |
| `m3_ref_palette_dynamic_primary100` | int | 0x7f060161 | 7081 |
| `m3_ref_palette_dynamic_primary20` | int | 0x7f060162 | 7084 |
| `m3_ref_palette_dynamic_primary30` | int | 0x7f060163 | 7087 |
| `m3_ref_palette_dynamic_primary40` | int | 0x7f060164 | 7090 |
| `m3_ref_palette_dynamic_primary50` | int | 0x7f060165 | 7093 |
| `m3_ref_palette_dynamic_primary60` | int | 0x7f060166 | 7096 |
| `m3_ref_palette_dynamic_primary70` | int | 0x7f060167 | 7099 |
| `m3_ref_palette_dynamic_primary80` | int | 0x7f060168 | 7102 |
| `m3_ref_palette_dynamic_primary90` | int | 0x7f060169 | 7105 |
| `m3_ref_palette_dynamic_primary95` | int | 0x7f06016a | 7108 |
| `m3_ref_palette_dynamic_primary99` | int | 0x7f06016b | 7111 |
| `m3_ref_palette_dynamic_secondary0` | int | 0x7f06016c | 7114 |
| `m3_ref_palette_dynamic_secondary10` | int | 0x7f06016d | 7117 |
| `m3_ref_palette_dynamic_secondary100` | int | 0x7f06016e | 7120 |
| `m3_ref_palette_dynamic_secondary20` | int | 0x7f06016f | 7123 |
| `m3_ref_palette_dynamic_secondary30` | int | 0x7f060170 | 7126 |
| `m3_ref_palette_dynamic_secondary40` | int | 0x7f060171 | 7129 |
| `m3_ref_palette_dynamic_secondary50` | int | 0x7f060172 | 7132 |
| `m3_ref_palette_dynamic_secondary60` | int | 0x7f060173 | 7135 |
| `m3_ref_palette_dynamic_secondary70` | int | 0x7f060174 | 7138 |
| `m3_ref_palette_dynamic_secondary80` | int | 0x7f060175 | 7141 |
| `m3_ref_palette_dynamic_secondary90` | int | 0x7f060176 | 7144 |
| `m3_ref_palette_dynamic_secondary95` | int | 0x7f060177 | 7147 |
| `m3_ref_palette_dynamic_secondary99` | int | 0x7f060178 | 7150 |
| `m3_ref_palette_dynamic_tertiary0` | int | 0x7f060179 | 7153 |
| `m3_ref_palette_dynamic_tertiary10` | int | 0x7f06017a | 7156 |
| `m3_ref_palette_dynamic_tertiary100` | int | 0x7f06017b | 7159 |
| `m3_ref_palette_dynamic_tertiary20` | int | 0x7f06017c | 7162 |
| `m3_ref_palette_dynamic_tertiary30` | int | 0x7f06017d | 7165 |
| `m3_ref_palette_dynamic_tertiary40` | int | 0x7f06017e | 7168 |
| `m3_ref_palette_dynamic_tertiary50` | int | 0x7f06017f | 7171 |
| `m3_ref_palette_dynamic_tertiary60` | int | 0x7f060180 | 7174 |
| `m3_ref_palette_dynamic_tertiary70` | int | 0x7f060181 | 7177 |
| `m3_ref_palette_dynamic_tertiary80` | int | 0x7f060182 | 7180 |
| `m3_ref_palette_dynamic_tertiary90` | int | 0x7f060183 | 7183 |
| `m3_ref_palette_dynamic_tertiary95` | int | 0x7f060184 | 7186 |
| `m3_ref_palette_dynamic_tertiary99` | int | 0x7f060185 | 7189 |
| `m3_ref_palette_error0` | int | 0x7f060186 | 7192 |
| `m3_ref_palette_error10` | int | 0x7f060187 | 7195 |
| `m3_ref_palette_error100` | int | 0x7f060188 | 7198 |
| `m3_ref_palette_error20` | int | 0x7f060189 | 7201 |
| `m3_ref_palette_error30` | int | 0x7f06018a | 7204 |
| `m3_ref_palette_error40` | int | 0x7f06018b | 7207 |
| `m3_ref_palette_error50` | int | 0x7f06018c | 7210 |
| `m3_ref_palette_error60` | int | 0x7f06018d | 7213 |
| `m3_ref_palette_error70` | int | 0x7f06018e | 7216 |
| `m3_ref_palette_error80` | int | 0x7f06018f | 7219 |
| `m3_ref_palette_error90` | int | 0x7f060190 | 7222 |
| `m3_ref_palette_error95` | int | 0x7f060191 | 7225 |
| `m3_ref_palette_error99` | int | 0x7f060192 | 7228 |
| `m3_ref_palette_neutral_variant0` | int | 0x7f0601ab | 7303 |
| `m3_ref_palette_neutral_variant10` | int | 0x7f0601ac | 7306 |
| `m3_ref_palette_neutral_variant100` | int | 0x7f0601ad | 7309 |
| `m3_ref_palette_neutral_variant20` | int | 0x7f0601ae | 7312 |
| `m3_ref_palette_neutral_variant30` | int | 0x7f0601af | 7315 |
| `m3_ref_palette_neutral_variant40` | int | 0x7f0601b0 | 7318 |
| `m3_ref_palette_neutral_variant50` | int | 0x7f0601b1 | 7321 |
| `m3_ref_palette_neutral_variant60` | int | 0x7f0601b2 | 7324 |
| `m3_ref_palette_neutral_variant70` | int | 0x7f0601b3 | 7327 |
| `m3_ref_palette_neutral_variant80` | int | 0x7f0601b4 | 7330 |
| `m3_ref_palette_neutral_variant90` | int | 0x7f0601b5 | 7333 |
| `m3_ref_palette_neutral_variant95` | int | 0x7f0601b6 | 7336 |
| `m3_ref_palette_neutral_variant99` | int | 0x7f0601b7 | 7339 |
| `m3_ref_palette_neutral0` | int | 0x7f060193 | 7231 |
| `m3_ref_palette_neutral10` | int | 0x7f060194 | 7234 |
| `m3_ref_palette_neutral100` | int | 0x7f060195 | 7237 |
| `m3_ref_palette_neutral12` | int | 0x7f060196 | 7240 |
| `m3_ref_palette_neutral17` | int | 0x7f060197 | 7243 |
| `m3_ref_palette_neutral20` | int | 0x7f060198 | 7246 |
| `m3_ref_palette_neutral22` | int | 0x7f060199 | 7249 |
| `m3_ref_palette_neutral24` | int | 0x7f06019a | 7252 |
| `m3_ref_palette_neutral30` | int | 0x7f06019b | 7255 |
| `m3_ref_palette_neutral4` | int | 0x7f06019c | 7258 |
| `m3_ref_palette_neutral40` | int | 0x7f06019d | 7261 |
| `m3_ref_palette_neutral50` | int | 0x7f06019e | 7264 |
| `m3_ref_palette_neutral6` | int | 0x7f06019f | 7267 |
| `m3_ref_palette_neutral60` | int | 0x7f0601a0 | 7270 |
| `m3_ref_palette_neutral70` | int | 0x7f0601a1 | 7273 |
| `m3_ref_palette_neutral80` | int | 0x7f0601a2 | 7276 |
| `m3_ref_palette_neutral87` | int | 0x7f0601a3 | 7279 |
| `m3_ref_palette_neutral90` | int | 0x7f0601a4 | 7282 |
| `m3_ref_palette_neutral92` | int | 0x7f0601a5 | 7285 |
| `m3_ref_palette_neutral94` | int | 0x7f0601a6 | 7288 |
| `m3_ref_palette_neutral95` | int | 0x7f0601a7 | 7291 |
| `m3_ref_palette_neutral96` | int | 0x7f0601a8 | 7294 |
| `m3_ref_palette_neutral98` | int | 0x7f0601a9 | 7297 |
| `m3_ref_palette_neutral99` | int | 0x7f0601aa | 7300 |
| `m3_ref_palette_primary0` | int | 0x7f0601b8 | 7342 |
| `m3_ref_palette_primary10` | int | 0x7f0601b9 | 7345 |
| `m3_ref_palette_primary100` | int | 0x7f0601ba | 7348 |
| `m3_ref_palette_primary20` | int | 0x7f0601bb | 7351 |
| `m3_ref_palette_primary30` | int | 0x7f0601bc | 7354 |
| `m3_ref_palette_primary40` | int | 0x7f0601bd | 7357 |
| `m3_ref_palette_primary50` | int | 0x7f0601be | 7360 |
| `m3_ref_palette_primary60` | int | 0x7f0601bf | 7363 |
| `m3_ref_palette_primary70` | int | 0x7f0601c0 | 7366 |
| `m3_ref_palette_primary80` | int | 0x7f0601c1 | 7369 |
| `m3_ref_palette_primary90` | int | 0x7f0601c2 | 7372 |
| `m3_ref_palette_primary95` | int | 0x7f0601c3 | 7375 |
| `m3_ref_palette_primary99` | int | 0x7f0601c4 | 7378 |
| `m3_ref_palette_secondary0` | int | 0x7f0601c5 | 7381 |
| `m3_ref_palette_secondary10` | int | 0x7f0601c6 | 7384 |
| `m3_ref_palette_secondary100` | int | 0x7f0601c7 | 7387 |
| `m3_ref_palette_secondary20` | int | 0x7f0601c8 | 7390 |
| `m3_ref_palette_secondary30` | int | 0x7f0601c9 | 7393 |
| `m3_ref_palette_secondary40` | int | 0x7f0601ca | 7396 |
| `m3_ref_palette_secondary50` | int | 0x7f0601cb | 7399 |
| `m3_ref_palette_secondary60` | int | 0x7f0601cc | 7402 |
| `m3_ref_palette_secondary70` | int | 0x7f0601cd | 7405 |
| `m3_ref_palette_secondary80` | int | 0x7f0601ce | 7408 |
| `m3_ref_palette_secondary90` | int | 0x7f0601cf | 7411 |
| `m3_ref_palette_secondary95` | int | 0x7f0601d0 | 7414 |
| `m3_ref_palette_secondary99` | int | 0x7f0601d1 | 7417 |
| `m3_ref_palette_tertiary0` | int | 0x7f0601d2 | 7420 |
| `m3_ref_palette_tertiary10` | int | 0x7f0601d3 | 7423 |
| `m3_ref_palette_tertiary100` | int | 0x7f0601d4 | 7426 |
| `m3_ref_palette_tertiary20` | int | 0x7f0601d5 | 7429 |
| `m3_ref_palette_tertiary30` | int | 0x7f0601d6 | 7432 |
| `m3_ref_palette_tertiary40` | int | 0x7f0601d7 | 7435 |
| `m3_ref_palette_tertiary50` | int | 0x7f0601d8 | 7438 |
| `m3_ref_palette_tertiary60` | int | 0x7f0601d9 | 7441 |
| `m3_ref_palette_tertiary70` | int | 0x7f0601da | 7444 |
| `m3_ref_palette_tertiary80` | int | 0x7f0601db | 7447 |
| `m3_ref_palette_tertiary90` | int | 0x7f0601dc | 7450 |
| `m3_ref_palette_tertiary95` | int | 0x7f0601dd | 7453 |
| `m3_ref_palette_tertiary99` | int | 0x7f0601de | 7456 |
| `m3_ref_palette_white` | int | 0x7f0601df | 7459 |
| `m3_selection_control_ripple_color_selector` | int | 0x7f0601e0 | 7462 |
| `m3_simple_item_ripple_color` | int | 0x7f0601e1 | 7465 |
| `m3_slider_active_track_color` | int | 0x7f0601e2 | 7468 |
| `m3_slider_halo_color` | int | 0x7f0601e3 | 7471 |
| `m3_slider_inactive_track_color` | int | 0x7f0601e4 | 7474 |
| `m3_slider_thumb_color` | int | 0x7f0601e5 | 7477 |
| `m3_switch_thumb_tint` | int | 0x7f0601e6 | 7480 |
| `m3_switch_track_tint` | int | 0x7f0601e7 | 7483 |
| `m3_sys_color_dark_background` | int | 0x7f0601e8 | 7486 |
| `m3_sys_color_dark_error` | int | 0x7f0601e9 | 7489 |
| `m3_sys_color_dark_error_container` | int | 0x7f0601ea | 7492 |
| `m3_sys_color_dark_inverse_on_surface` | int | 0x7f0601eb | 7495 |
| `m3_sys_color_dark_inverse_primary` | int | 0x7f0601ec | 7498 |
| `m3_sys_color_dark_inverse_surface` | int | 0x7f0601ed | 7501 |
| `m3_sys_color_dark_on_background` | int | 0x7f0601ee | 7504 |
| `m3_sys_color_dark_on_error` | int | 0x7f0601ef | 7507 |
| `m3_sys_color_dark_on_error_container` | int | 0x7f0601f0 | 7510 |
| `m3_sys_color_dark_on_primary` | int | 0x7f0601f1 | 7513 |
| `m3_sys_color_dark_on_primary_container` | int | 0x7f0601f2 | 7516 |
| `m3_sys_color_dark_on_secondary` | int | 0x7f0601f3 | 7519 |
| `m3_sys_color_dark_on_secondary_container` | int | 0x7f0601f4 | 7522 |
| `m3_sys_color_dark_on_surface` | int | 0x7f0601f5 | 7525 |
| `m3_sys_color_dark_on_surface_variant` | int | 0x7f0601f6 | 7528 |
| `m3_sys_color_dark_on_tertiary` | int | 0x7f0601f7 | 7531 |
| `m3_sys_color_dark_on_tertiary_container` | int | 0x7f0601f8 | 7534 |
| `m3_sys_color_dark_outline` | int | 0x7f0601f9 | 7537 |
| `m3_sys_color_dark_outline_variant` | int | 0x7f0601fa | 7540 |
| `m3_sys_color_dark_primary` | int | 0x7f0601fb | 7543 |
| `m3_sys_color_dark_primary_container` | int | 0x7f0601fc | 7546 |
| `m3_sys_color_dark_secondary` | int | 0x7f0601fd | 7549 |
| `m3_sys_color_dark_secondary_container` | int | 0x7f0601fe | 7552 |
| `m3_sys_color_dark_surface` | int | 0x7f0601ff | 7555 |
| `m3_sys_color_dark_surface_bright` | int | 0x7f060200 | 7558 |
| `m3_sys_color_dark_surface_container` | int | 0x7f060201 | 7561 |
| `m3_sys_color_dark_surface_container_high` | int | 0x7f060202 | 7564 |
| `m3_sys_color_dark_surface_container_highest` | int | 0x7f060203 | 7567 |
| `m3_sys_color_dark_surface_container_low` | int | 0x7f060204 | 7570 |
| `m3_sys_color_dark_surface_container_lowest` | int | 0x7f060205 | 7573 |
| `m3_sys_color_dark_surface_dim` | int | 0x7f060206 | 7576 |
| `m3_sys_color_dark_surface_variant` | int | 0x7f060207 | 7579 |
| `m3_sys_color_dark_tertiary` | int | 0x7f060208 | 7582 |
| `m3_sys_color_dark_tertiary_container` | int | 0x7f060209 | 7585 |
| `m3_sys_color_dynamic_dark_background` | int | 0x7f06020a | 7588 |
| `m3_sys_color_dynamic_dark_inverse_on_surface` | int | 0x7f06020b | 7591 |
| `m3_sys_color_dynamic_dark_inverse_primary` | int | 0x7f06020c | 7594 |
| `m3_sys_color_dynamic_dark_inverse_surface` | int | 0x7f06020d | 7597 |
| `m3_sys_color_dynamic_dark_on_background` | int | 0x7f06020e | 7600 |
| `m3_sys_color_dynamic_dark_on_primary` | int | 0x7f06020f | 7603 |
| `m3_sys_color_dynamic_dark_on_primary_container` | int | 0x7f060210 | 7606 |
| `m3_sys_color_dynamic_dark_on_secondary` | int | 0x7f060211 | 7609 |
| `m3_sys_color_dynamic_dark_on_secondary_container` | int | 0x7f060212 | 7612 |
| `m3_sys_color_dynamic_dark_on_surface` | int | 0x7f060213 | 7615 |
| `m3_sys_color_dynamic_dark_on_surface_variant` | int | 0x7f060214 | 7618 |
| `m3_sys_color_dynamic_dark_on_tertiary` | int | 0x7f060215 | 7621 |
| `m3_sys_color_dynamic_dark_on_tertiary_container` | int | 0x7f060216 | 7624 |
| `m3_sys_color_dynamic_dark_outline` | int | 0x7f060217 | 7627 |
| `m3_sys_color_dynamic_dark_outline_variant` | int | 0x7f060218 | 7630 |
| `m3_sys_color_dynamic_dark_primary` | int | 0x7f060219 | 7633 |
| `m3_sys_color_dynamic_dark_primary_container` | int | 0x7f06021a | 7636 |
| `m3_sys_color_dynamic_dark_secondary` | int | 0x7f06021b | 7639 |
| `m3_sys_color_dynamic_dark_secondary_container` | int | 0x7f06021c | 7642 |
| `m3_sys_color_dynamic_dark_surface` | int | 0x7f06021d | 7645 |
| `m3_sys_color_dynamic_dark_surface_bright` | int | 0x7f06021e | 7648 |
| `m3_sys_color_dynamic_dark_surface_container` | int | 0x7f06021f | 7651 |
| `m3_sys_color_dynamic_dark_surface_container_high` | int | 0x7f060220 | 7654 |
| `m3_sys_color_dynamic_dark_surface_container_highest` | int | 0x7f060221 | 7657 |
| `m3_sys_color_dynamic_dark_surface_container_low` | int | 0x7f060222 | 7660 |
| `m3_sys_color_dynamic_dark_surface_container_lowest` | int | 0x7f060223 | 7663 |
| `m3_sys_color_dynamic_dark_surface_dim` | int | 0x7f060224 | 7666 |
| `m3_sys_color_dynamic_dark_surface_variant` | int | 0x7f060225 | 7669 |
| `m3_sys_color_dynamic_dark_tertiary` | int | 0x7f060226 | 7672 |
| `m3_sys_color_dynamic_dark_tertiary_container` | int | 0x7f060227 | 7675 |
| `m3_sys_color_dynamic_light_background` | int | 0x7f060228 | 7678 |
| `m3_sys_color_dynamic_light_inverse_on_surface` | int | 0x7f060229 | 7681 |
| `m3_sys_color_dynamic_light_inverse_primary` | int | 0x7f06022a | 7684 |
| `m3_sys_color_dynamic_light_inverse_surface` | int | 0x7f06022b | 7687 |
| `m3_sys_color_dynamic_light_on_background` | int | 0x7f06022c | 7690 |
| `m3_sys_color_dynamic_light_on_primary` | int | 0x7f06022d | 7693 |
| `m3_sys_color_dynamic_light_on_primary_container` | int | 0x7f06022e | 7696 |
| `m3_sys_color_dynamic_light_on_secondary` | int | 0x7f06022f | 7699 |
| `m3_sys_color_dynamic_light_on_secondary_container` | int | 0x7f060230 | 7702 |
| `m3_sys_color_dynamic_light_on_surface` | int | 0x7f060231 | 7705 |
| `m3_sys_color_dynamic_light_on_surface_variant` | int | 0x7f060232 | 7708 |
| `m3_sys_color_dynamic_light_on_tertiary` | int | 0x7f060233 | 7711 |
| `m3_sys_color_dynamic_light_on_tertiary_container` | int | 0x7f060234 | 7714 |
| `m3_sys_color_dynamic_light_outline` | int | 0x7f060235 | 7717 |
| `m3_sys_color_dynamic_light_outline_variant` | int | 0x7f060236 | 7720 |
| `m3_sys_color_dynamic_light_primary` | int | 0x7f060237 | 7723 |
| `m3_sys_color_dynamic_light_primary_container` | int | 0x7f060238 | 7726 |
| `m3_sys_color_dynamic_light_secondary` | int | 0x7f060239 | 7729 |
| `m3_sys_color_dynamic_light_secondary_container` | int | 0x7f06023a | 7732 |
| `m3_sys_color_dynamic_light_surface` | int | 0x7f06023b | 7735 |
| `m3_sys_color_dynamic_light_surface_bright` | int | 0x7f06023c | 7738 |
| `m3_sys_color_dynamic_light_surface_container` | int | 0x7f06023d | 7741 |
| `m3_sys_color_dynamic_light_surface_container_high` | int | 0x7f06023e | 7744 |
| `m3_sys_color_dynamic_light_surface_container_highest` | int | 0x7f06023f | 7747 |
| `m3_sys_color_dynamic_light_surface_container_low` | int | 0x7f060240 | 7750 |
| `m3_sys_color_dynamic_light_surface_container_lowest` | int | 0x7f060241 | 7753 |
| `m3_sys_color_dynamic_light_surface_dim` | int | 0x7f060242 | 7756 |
| `m3_sys_color_dynamic_light_surface_variant` | int | 0x7f060243 | 7759 |
| `m3_sys_color_dynamic_light_tertiary` | int | 0x7f060244 | 7762 |
| `m3_sys_color_dynamic_light_tertiary_container` | int | 0x7f060245 | 7765 |
| `m3_sys_color_dynamic_on_primary_fixed` | int | 0x7f060246 | 7768 |
| `m3_sys_color_dynamic_on_primary_fixed_variant` | int | 0x7f060247 | 7771 |
| `m3_sys_color_dynamic_on_secondary_fixed` | int | 0x7f060248 | 7774 |
| `m3_sys_color_dynamic_on_secondary_fixed_variant` | int | 0x7f060249 | 7777 |
| `m3_sys_color_dynamic_on_tertiary_fixed` | int | 0x7f06024a | 7780 |
| `m3_sys_color_dynamic_on_tertiary_fixed_variant` | int | 0x7f06024b | 7783 |
| `m3_sys_color_dynamic_primary_fixed` | int | 0x7f06024c | 7786 |
| `m3_sys_color_dynamic_primary_fixed_dim` | int | 0x7f06024d | 7789 |
| `m3_sys_color_dynamic_secondary_fixed` | int | 0x7f06024e | 7792 |
| `m3_sys_color_dynamic_secondary_fixed_dim` | int | 0x7f06024f | 7795 |
| `m3_sys_color_dynamic_tertiary_fixed` | int | 0x7f060250 | 7798 |
| `m3_sys_color_dynamic_tertiary_fixed_dim` | int | 0x7f060251 | 7801 |
| `m3_sys_color_light_background` | int | 0x7f060252 | 7804 |
| `m3_sys_color_light_error` | int | 0x7f060253 | 7807 |
| `m3_sys_color_light_error_container` | int | 0x7f060254 | 7810 |
| `m3_sys_color_light_inverse_on_surface` | int | 0x7f060255 | 7813 |
| `m3_sys_color_light_inverse_primary` | int | 0x7f060256 | 7816 |
| `m3_sys_color_light_inverse_surface` | int | 0x7f060257 | 7819 |
| `m3_sys_color_light_on_background` | int | 0x7f060258 | 7822 |
| `m3_sys_color_light_on_error` | int | 0x7f060259 | 7825 |
| `m3_sys_color_light_on_error_container` | int | 0x7f06025a | 7828 |
| `m3_sys_color_light_on_primary` | int | 0x7f06025b | 7831 |
| `m3_sys_color_light_on_primary_container` | int | 0x7f06025c | 7834 |
| `m3_sys_color_light_on_secondary` | int | 0x7f06025d | 7837 |
| `m3_sys_color_light_on_secondary_container` | int | 0x7f06025e | 7840 |
| `m3_sys_color_light_on_surface` | int | 0x7f06025f | 7843 |
| `m3_sys_color_light_on_surface_variant` | int | 0x7f060260 | 7846 |
| `m3_sys_color_light_on_tertiary` | int | 0x7f060261 | 7849 |
| `m3_sys_color_light_on_tertiary_container` | int | 0x7f060262 | 7852 |
| `m3_sys_color_light_outline` | int | 0x7f060263 | 7855 |
| `m3_sys_color_light_outline_variant` | int | 0x7f060264 | 7858 |
| `m3_sys_color_light_primary` | int | 0x7f060265 | 7861 |
| `m3_sys_color_light_primary_container` | int | 0x7f060266 | 7864 |
| `m3_sys_color_light_secondary` | int | 0x7f060267 | 7867 |
| `m3_sys_color_light_secondary_container` | int | 0x7f060268 | 7870 |
| `m3_sys_color_light_surface` | int | 0x7f060269 | 7873 |
| `m3_sys_color_light_surface_bright` | int | 0x7f06026a | 7876 |
| `m3_sys_color_light_surface_container` | int | 0x7f06026b | 7879 |
| `m3_sys_color_light_surface_container_high` | int | 0x7f06026c | 7882 |
| `m3_sys_color_light_surface_container_highest` | int | 0x7f06026d | 7885 |
| `m3_sys_color_light_surface_container_low` | int | 0x7f06026e | 7888 |
| `m3_sys_color_light_surface_container_lowest` | int | 0x7f06026f | 7891 |
| `m3_sys_color_light_surface_dim` | int | 0x7f060270 | 7894 |
| `m3_sys_color_light_surface_variant` | int | 0x7f060271 | 7897 |
| `m3_sys_color_light_tertiary` | int | 0x7f060272 | 7900 |
| `m3_sys_color_light_tertiary_container` | int | 0x7f060273 | 7903 |
| `m3_sys_color_on_primary_fixed` | int | 0x7f060274 | 7906 |
| `m3_sys_color_on_primary_fixed_variant` | int | 0x7f060275 | 7909 |
| `m3_sys_color_on_secondary_fixed` | int | 0x7f060276 | 7912 |
| `m3_sys_color_on_secondary_fixed_variant` | int | 0x7f060277 | 7915 |
| `m3_sys_color_on_tertiary_fixed` | int | 0x7f060278 | 7918 |
| `m3_sys_color_on_tertiary_fixed_variant` | int | 0x7f060279 | 7921 |
| `m3_sys_color_primary_fixed` | int | 0x7f06027a | 7924 |
| `m3_sys_color_primary_fixed_dim` | int | 0x7f06027b | 7927 |
| `m3_sys_color_secondary_fixed` | int | 0x7f06027c | 7930 |
| `m3_sys_color_secondary_fixed_dim` | int | 0x7f06027d | 7933 |
| `m3_sys_color_tertiary_fixed` | int | 0x7f06027e | 7936 |
| `m3_sys_color_tertiary_fixed_dim` | int | 0x7f06027f | 7939 |
| `m3_tabs_icon_color` | int | 0x7f060280 | 7942 |
| `m3_tabs_icon_color_secondary` | int | 0x7f060281 | 7945 |
| `m3_tabs_ripple_color` | int | 0x7f060282 | 7948 |
| `m3_tabs_ripple_color_secondary` | int | 0x7f060283 | 7951 |
| `m3_tabs_text_color` | int | 0x7f060284 | 7954 |
| `m3_tabs_text_color_secondary` | int | 0x7f060285 | 7957 |
| `m3_text_button_background_color_selector` | int | 0x7f060286 | 7960 |
| `m3_text_button_foreground_color_selector` | int | 0x7f060287 | 7963 |
| `m3_text_button_ripple_color_selector` | int | 0x7f060288 | 7966 |
| `m3_textfield_filled_background_color` | int | 0x7f060289 | 7969 |
| `m3_textfield_indicator_text_color` | int | 0x7f06028a | 7972 |
| `m3_textfield_input_text_color` | int | 0x7f06028b | 7975 |
| `m3_textfield_label_color` | int | 0x7f06028c | 7978 |
| `m3_textfield_stroke_color` | int | 0x7f06028d | 7981 |
| `m3_timepicker_button_background_color` | int | 0x7f06028e | 7984 |
| `m3_timepicker_button_ripple_color` | int | 0x7f06028f | 7987 |
| `m3_timepicker_button_text_color` | int | 0x7f060290 | 7990 |
| `m3_timepicker_clock_text_color` | int | 0x7f060291 | 7993 |
| `m3_timepicker_display_background_color` | int | 0x7f060292 | 7996 |
| `m3_timepicker_display_ripple_color` | int | 0x7f060293 | 7999 |
| `m3_timepicker_display_text_color` | int | 0x7f060294 | 8002 |
| `m3_timepicker_secondary_text_button_ripple_color` | int | 0x7f060295 | 8005 |
| `m3_timepicker_secondary_text_button_text_color` | int | 0x7f060296 | 8008 |
| `m3_timepicker_time_input_stroke_color` | int | 0x7f060297 | 8011 |
| `m3_tonal_button_ripple_color_selector` | int | 0x7f060298 | 8014 |
| `magenta` | int | 0x7f060299 | 8017 |
| `main_tab_color` | int | 0x7f06029a | 8020 |
| `material_blue_grey_800` | int | 0x7f06029b | 8023 |
| `material_blue_grey_900` | int | 0x7f06029c | 8026 |
| `material_blue_grey_950` | int | 0x7f06029d | 8029 |
| `material_cursor_color` | int | 0x7f06029e | 8032 |
| `material_deep_teal_200` | int | 0x7f06029f | 8035 |
| `material_deep_teal_500` | int | 0x7f0602a0 | 8038 |
| `material_divider_color` | int | 0x7f0602a1 | 8041 |
| `material_dynamic_neutral_variant0` | int | 0x7f0602af | 8083 |
| `material_dynamic_neutral_variant10` | int | 0x7f0602b0 | 8086 |
| `material_dynamic_neutral_variant100` | int | 0x7f0602b1 | 8089 |
| `material_dynamic_neutral_variant20` | int | 0x7f0602b2 | 8092 |
| `material_dynamic_neutral_variant30` | int | 0x7f0602b3 | 8095 |
| `material_dynamic_neutral_variant40` | int | 0x7f0602b4 | 8098 |
| `material_dynamic_neutral_variant50` | int | 0x7f0602b5 | 8101 |
| `material_dynamic_neutral_variant60` | int | 0x7f0602b6 | 8104 |
| `material_dynamic_neutral_variant70` | int | 0x7f0602b7 | 8107 |
| `material_dynamic_neutral_variant80` | int | 0x7f0602b8 | 8110 |
| `material_dynamic_neutral_variant90` | int | 0x7f0602b9 | 8113 |
| `material_dynamic_neutral_variant95` | int | 0x7f0602ba | 8116 |
| `material_dynamic_neutral_variant99` | int | 0x7f0602bb | 8119 |
| `material_dynamic_neutral0` | int | 0x7f0602a2 | 8044 |
| `material_dynamic_neutral10` | int | 0x7f0602a3 | 8047 |
| `material_dynamic_neutral100` | int | 0x7f0602a4 | 8050 |
| `material_dynamic_neutral20` | int | 0x7f0602a5 | 8053 |
| `material_dynamic_neutral30` | int | 0x7f0602a6 | 8056 |
| `material_dynamic_neutral40` | int | 0x7f0602a7 | 8059 |
| `material_dynamic_neutral50` | int | 0x7f0602a8 | 8062 |
| `material_dynamic_neutral60` | int | 0x7f0602a9 | 8065 |
| `material_dynamic_neutral70` | int | 0x7f0602aa | 8068 |
| `material_dynamic_neutral80` | int | 0x7f0602ab | 8071 |
| `material_dynamic_neutral90` | int | 0x7f0602ac | 8074 |
| `material_dynamic_neutral95` | int | 0x7f0602ad | 8077 |
| `material_dynamic_neutral99` | int | 0x7f0602ae | 8080 |
| `material_dynamic_primary0` | int | 0x7f0602bc | 8122 |
| `material_dynamic_primary10` | int | 0x7f0602bd | 8125 |
| `material_dynamic_primary100` | int | 0x7f0602be | 8128 |
| `material_dynamic_primary20` | int | 0x7f0602bf | 8131 |
| `material_dynamic_primary30` | int | 0x7f0602c0 | 8134 |
| `material_dynamic_primary40` | int | 0x7f0602c1 | 8137 |
| `material_dynamic_primary50` | int | 0x7f0602c2 | 8140 |
| `material_dynamic_primary60` | int | 0x7f0602c3 | 8143 |
| `material_dynamic_primary70` | int | 0x7f0602c4 | 8146 |
| `material_dynamic_primary80` | int | 0x7f0602c5 | 8149 |
| `material_dynamic_primary90` | int | 0x7f0602c6 | 8152 |
| `material_dynamic_primary95` | int | 0x7f0602c7 | 8155 |
| `material_dynamic_primary99` | int | 0x7f0602c8 | 8158 |
| `material_dynamic_secondary0` | int | 0x7f0602c9 | 8161 |
| `material_dynamic_secondary10` | int | 0x7f0602ca | 8164 |
| `material_dynamic_secondary100` | int | 0x7f0602cb | 8167 |
| `material_dynamic_secondary20` | int | 0x7f0602cc | 8170 |
| `material_dynamic_secondary30` | int | 0x7f0602cd | 8173 |
| `material_dynamic_secondary40` | int | 0x7f0602ce | 8176 |
| `material_dynamic_secondary50` | int | 0x7f0602cf | 8179 |
| `material_dynamic_secondary60` | int | 0x7f0602d0 | 8182 |
| `material_dynamic_secondary70` | int | 0x7f0602d1 | 8185 |
| `material_dynamic_secondary80` | int | 0x7f0602d2 | 8188 |
| `material_dynamic_secondary90` | int | 0x7f0602d3 | 8191 |
| `material_dynamic_secondary95` | int | 0x7f0602d4 | 8194 |
| `material_dynamic_secondary99` | int | 0x7f0602d5 | 8197 |
| `material_dynamic_tertiary0` | int | 0x7f0602d6 | 8200 |
| `material_dynamic_tertiary10` | int | 0x7f0602d7 | 8203 |
| `material_dynamic_tertiary100` | int | 0x7f0602d8 | 8206 |
| `material_dynamic_tertiary20` | int | 0x7f0602d9 | 8209 |
| `material_dynamic_tertiary30` | int | 0x7f0602da | 8212 |
| `material_dynamic_tertiary40` | int | 0x7f0602db | 8215 |
| `material_dynamic_tertiary50` | int | 0x7f0602dc | 8218 |
| `material_dynamic_tertiary60` | int | 0x7f0602dd | 8221 |
| `material_dynamic_tertiary70` | int | 0x7f0602de | 8224 |
| `material_dynamic_tertiary80` | int | 0x7f0602df | 8227 |
| `material_dynamic_tertiary90` | int | 0x7f0602e0 | 8230 |
| `material_dynamic_tertiary95` | int | 0x7f0602e1 | 8233 |
| `material_dynamic_tertiary99` | int | 0x7f0602e2 | 8236 |
| `material_grey_100` | int | 0x7f0602e3 | 8239 |
| `material_grey_300` | int | 0x7f0602e4 | 8242 |
| `material_grey_50` | int | 0x7f0602e5 | 8245 |
| `material_grey_600` | int | 0x7f0602e6 | 8248 |
| `material_grey_800` | int | 0x7f0602e7 | 8251 |
| `material_grey_850` | int | 0x7f0602e8 | 8254 |
| `material_grey_900` | int | 0x7f0602e9 | 8257 |
| `material_harmonized_color_error` | int | 0x7f0602ea | 8260 |
| `material_harmonized_color_error_container` | int | 0x7f0602eb | 8263 |
| `material_harmonized_color_on_error` | int | 0x7f0602ec | 8266 |
| `material_harmonized_color_on_error_container` | int | 0x7f0602ed | 8269 |
| `material_on_background_disabled` | int | 0x7f0602ee | 8272 |
| `material_on_background_emphasis_high_type` | int | 0x7f0602ef | 8275 |
| `material_on_background_emphasis_medium` | int | 0x7f0602f0 | 8278 |
| `material_on_primary_disabled` | int | 0x7f0602f1 | 8281 |
| `material_on_primary_emphasis_high_type` | int | 0x7f0602f2 | 8284 |
| `material_on_primary_emphasis_medium` | int | 0x7f0602f3 | 8287 |
| `material_on_surface_disabled` | int | 0x7f0602f4 | 8290 |
| `material_on_surface_emphasis_high_type` | int | 0x7f0602f5 | 8293 |
| `material_on_surface_emphasis_medium` | int | 0x7f0602f6 | 8296 |
| `material_on_surface_stroke` | int | 0x7f0602f7 | 8299 |
| `material_personalized__highlighted_text` | int | 0x7f0602f8 | 8302 |
| `material_personalized__highlighted_text_inverse` | int | 0x7f0602f9 | 8305 |
| `material_personalized_color_background` | int | 0x7f0602fa | 8308 |
| `material_personalized_color_control_activated` | int | 0x7f0602fb | 8311 |
| `material_personalized_color_control_highlight` | int | 0x7f0602fc | 8314 |
| `material_personalized_color_control_normal` | int | 0x7f0602fd | 8317 |
| `material_personalized_color_error` | int | 0x7f0602fe | 8320 |
| `material_personalized_color_error_container` | int | 0x7f0602ff | 8323 |
| `material_personalized_color_on_background` | int | 0x7f060300 | 8326 |
| `material_personalized_color_on_error` | int | 0x7f060301 | 8329 |
| `material_personalized_color_on_error_container` | int | 0x7f060302 | 8332 |
| `material_personalized_color_on_primary` | int | 0x7f060303 | 8335 |
| `material_personalized_color_on_primary_container` | int | 0x7f060304 | 8338 |
| `material_personalized_color_on_secondary` | int | 0x7f060305 | 8341 |
| `material_personalized_color_on_secondary_container` | int | 0x7f060306 | 8344 |
| `material_personalized_color_on_surface` | int | 0x7f060307 | 8347 |
| `material_personalized_color_on_surface_inverse` | int | 0x7f060308 | 8350 |
| `material_personalized_color_on_surface_variant` | int | 0x7f060309 | 8353 |
| `material_personalized_color_on_tertiary` | int | 0x7f06030a | 8356 |
| `material_personalized_color_on_tertiary_container` | int | 0x7f06030b | 8359 |
| `material_personalized_color_outline` | int | 0x7f06030c | 8362 |
| `material_personalized_color_outline_variant` | int | 0x7f06030d | 8365 |
| `material_personalized_color_primary` | int | 0x7f06030e | 8368 |
| `material_personalized_color_primary_container` | int | 0x7f06030f | 8371 |
| `material_personalized_color_primary_inverse` | int | 0x7f060310 | 8374 |
| `material_personalized_color_primary_text` | int | 0x7f060311 | 8377 |
| `material_personalized_color_primary_text_inverse` | int | 0x7f060312 | 8380 |
| `material_personalized_color_secondary` | int | 0x7f060313 | 8383 |
| `material_personalized_color_secondary_container` | int | 0x7f060314 | 8386 |
| `material_personalized_color_secondary_text` | int | 0x7f060315 | 8389 |
| `material_personalized_color_secondary_text_inverse` | int | 0x7f060316 | 8392 |
| `material_personalized_color_surface` | int | 0x7f060317 | 8395 |
| `material_personalized_color_surface_bright` | int | 0x7f060318 | 8398 |
| `material_personalized_color_surface_container` | int | 0x7f060319 | 8401 |
| `material_personalized_color_surface_container_high` | int | 0x7f06031a | 8404 |
| `material_personalized_color_surface_container_highest` | int | 0x7f06031b | 8407 |
| `material_personalized_color_surface_container_low` | int | 0x7f06031c | 8410 |
| `material_personalized_color_surface_container_lowest` | int | 0x7f06031d | 8413 |
| `material_personalized_color_surface_dim` | int | 0x7f06031e | 8416 |
| `material_personalized_color_surface_inverse` | int | 0x7f06031f | 8419 |
| `material_personalized_color_surface_variant` | int | 0x7f060320 | 8422 |
| `material_personalized_color_tertiary` | int | 0x7f060321 | 8425 |
| `material_personalized_color_tertiary_container` | int | 0x7f060322 | 8428 |
| `material_personalized_color_text_hint_foreground_inverse` | int | 0x7f060323 | 8431 |
| `material_personalized_color_text_primary_inverse` | int | 0x7f060324 | 8434 |
| `material_personalized_color_text_primary_inverse_disable_only` | int | 0x7f060325 | 8437 |
| `material_personalized_color_text_secondary_and_tertiary_inverse` | int | 0x7f060326 | 8440 |
| `material_personalized_color_text_secondary_and_tertiary_inverse_disabled` | int | 0x7f060327 | 8443 |
| `material_personalized_hint_foreground` | int | 0x7f060328 | 8446 |
| `material_personalized_hint_foreground_inverse` | int | 0x7f060329 | 8449 |
| `material_personalized_primary_inverse_text_disable_only` | int | 0x7f06032a | 8452 |
| `material_personalized_primary_text_disable_only` | int | 0x7f06032b | 8455 |
| `material_slider_active_tick_marks_color` | int | 0x7f06032c | 8458 |
| `material_slider_active_track_color` | int | 0x7f06032d | 8461 |
| `material_slider_halo_color` | int | 0x7f06032e | 8464 |
| `material_slider_inactive_tick_marks_color` | int | 0x7f06032f | 8467 |
| `material_slider_inactive_track_color` | int | 0x7f060330 | 8470 |
| `material_slider_thumb_color` | int | 0x7f060331 | 8473 |
| `material_timepicker_button_background` | int | 0x7f060332 | 8476 |
| `material_timepicker_button_stroke` | int | 0x7f060333 | 8479 |
| `material_timepicker_clock_text_color` | int | 0x7f060334 | 8482 |
| `material_timepicker_clockface` | int | 0x7f060335 | 8485 |
| `material_timepicker_modebutton_tint` | int | 0x7f060336 | 8488 |
| `mode_icon_color` | int | 0x7f060337 | 8491 |
| `mode_icon_selected_color` | int | 0x7f060338 | 8494 |
| `mtrl_btn_bg_color_selector` | int | 0x7f060339 | 8497 |
| `mtrl_btn_ripple_color` | int | 0x7f06033a | 8500 |
| `mtrl_btn_stroke_color_selector` | int | 0x7f06033b | 8503 |
| `mtrl_btn_text_btn_bg_color_selector` | int | 0x7f06033c | 8506 |
| `mtrl_btn_text_btn_ripple_color` | int | 0x7f06033d | 8509 |
| `mtrl_btn_text_color_disabled` | int | 0x7f06033e | 8512 |
| `mtrl_btn_text_color_selector` | int | 0x7f06033f | 8515 |
| `mtrl_btn_transparent_bg_color` | int | 0x7f060340 | 8518 |
| `mtrl_calendar_item_stroke_color` | int | 0x7f060341 | 8521 |
| `mtrl_calendar_selected_range` | int | 0x7f060342 | 8524 |
| `mtrl_card_view_foreground` | int | 0x7f060343 | 8527 |
| `mtrl_card_view_ripple` | int | 0x7f060344 | 8530 |
| `mtrl_chip_background_color` | int | 0x7f060345 | 8533 |
| `mtrl_chip_close_icon_tint` | int | 0x7f060346 | 8536 |
| `mtrl_chip_surface_color` | int | 0x7f060347 | 8539 |
| `mtrl_chip_text_color` | int | 0x7f060348 | 8542 |
| `mtrl_choice_chip_background_color` | int | 0x7f060349 | 8545 |
| `mtrl_choice_chip_ripple_color` | int | 0x7f06034a | 8548 |
| `mtrl_choice_chip_text_color` | int | 0x7f06034b | 8551 |
| `mtrl_error` | int | 0x7f06034c | 8554 |
| `mtrl_fab_bg_color_selector` | int | 0x7f06034d | 8557 |
| `mtrl_fab_icon_text_color_selector` | int | 0x7f06034e | 8560 |
| `mtrl_fab_ripple_color` | int | 0x7f06034f | 8563 |
| `mtrl_filled_background_color` | int | 0x7f060350 | 8566 |
| `mtrl_filled_icon_tint` | int | 0x7f060351 | 8569 |
| `mtrl_filled_stroke_color` | int | 0x7f060352 | 8572 |
| `mtrl_indicator_text_color` | int | 0x7f060353 | 8575 |
| `mtrl_navigation_bar_colored_item_tint` | int | 0x7f060354 | 8578 |
| `mtrl_navigation_bar_colored_ripple_color` | int | 0x7f060355 | 8581 |
| `mtrl_navigation_bar_item_tint` | int | 0x7f060356 | 8584 |
| `mtrl_navigation_bar_ripple_color` | int | 0x7f060357 | 8587 |
| `mtrl_navigation_item_background_color` | int | 0x7f060358 | 8590 |
| `mtrl_navigation_item_icon_tint` | int | 0x7f060359 | 8593 |
| `mtrl_navigation_item_text_color` | int | 0x7f06035a | 8596 |
| `mtrl_on_primary_text_btn_text_color_selector` | int | 0x7f06035b | 8599 |
| `mtrl_on_surface_ripple_color` | int | 0x7f06035c | 8602 |
| `mtrl_outlined_icon_tint` | int | 0x7f06035d | 8605 |
| `mtrl_outlined_stroke_color` | int | 0x7f06035e | 8608 |
| `mtrl_popupmenu_overlay_color` | int | 0x7f06035f | 8611 |
| `mtrl_scrim_color` | int | 0x7f060360 | 8614 |
| `mtrl_switch_thumb_icon_tint` | int | 0x7f060361 | 8617 |
| `mtrl_switch_thumb_tint` | int | 0x7f060362 | 8620 |
| `mtrl_switch_track_decoration_tint` | int | 0x7f060363 | 8623 |
| `mtrl_switch_track_tint` | int | 0x7f060364 | 8626 |
| `mtrl_tabs_colored_ripple_color` | int | 0x7f060365 | 8629 |
| `mtrl_tabs_icon_color_selector` | int | 0x7f060366 | 8632 |
| `mtrl_tabs_icon_color_selector_colored` | int | 0x7f060367 | 8635 |
| `mtrl_tabs_legacy_text_color_selector` | int | 0x7f060368 | 8638 |
| `mtrl_tabs_ripple_color` | int | 0x7f060369 | 8641 |
| `mtrl_text_btn_text_color_selector` | int | 0x7f06036a | 8644 |
| `mtrl_textinput_default_box_stroke_color` | int | 0x7f06036b | 8647 |
| `mtrl_textinput_disabled_color` | int | 0x7f06036c | 8650 |
| `mtrl_textinput_filled_box_default_background_color` | int | 0x7f06036d | 8653 |
| `mtrl_textinput_focused_box_stroke_color` | int | 0x7f06036e | 8656 |
| `mtrl_textinput_hovered_box_stroke_color` | int | 0x7f06036f | 8659 |
| `newNormalBackgroundColor` | int | 0x7f060370 | 8662 |
| `normalBackgroundColor` | int | 0x7f060371 | 8665 |
| `notification_action_color_filter` | int | 0x7f060372 | 8668 |
| `notification_icon_bg_color` | int | 0x7f060373 | 8671 |
| `notification_material_background_media_default_color` | int | 0x7f060374 | 8674 |
| `pet_liveview_guide_bg` | int | 0x7f060375 | 8677 |
| `pickerview_bg_topbar` | int | 0x7f060378 | 8686 |
| `pickerview_bgColor_default` | int | 0x7f060376 | 8680 |
| `pickerview_bgColor_overlay` | int | 0x7f060377 | 8683 |
| `pickerview_timebtn_nor` | int | 0x7f060379 | 8689 |
| `pickerview_timebtn_pre` | int | 0x7f06037a | 8692 |
| `pickerview_topbar_title` | int | 0x7f06037b | 8695 |
| `pickerview_wheelview_textcolor_center` | int | 0x7f06037c | 8698 |
| `pickerview_wheelview_textcolor_divider` | int | 0x7f06037d | 8701 |
| `pickerview_wheelview_textcolor_out` | int | 0x7f06037e | 8704 |
| `placeholdColor` | int | 0x7f06037f | 8707 |
| `play_item_bg_color` | int | 0x7f060380 | 8710 |
| `popup_text_color` | int | 0x7f060381 | 8713 |
| `possible_result_points` | int | 0x7f060382 | 8716 |
| `primary_dark_material_dark` | int | 0x7f060386 | 8719 |
| `primary_dark_material_light` | int | 0x7f060387 | 8722 |
| `primary_material_dark` | int | 0x7f06038a | 8725 |
| `primary_material_light` | int | 0x7f06038b | 8728 |
| `primary_text_default_material_dark` | int | 0x7f06038d | 8731 |
| `primary_text_default_material_light` | int | 0x7f06038e | 8734 |
| `primary_text_disabled_material_dark` | int | 0x7f06038f | 8737 |
| `primary_text_disabled_material_light` | int | 0x7f060390 | 8740 |
| `ps_color_0077F6` | int | 0x7f060391 | 8743 |
| `ps_color_20` | int | 0x7f060392 | 8746 |
| `ps_color_20c064` | int | 0x7f060393 | 8749 |
| `ps_color_33` | int | 0x7f060394 | 8752 |
| `ps_color_394a3e` | int | 0x7f060395 | 8755 |
| `ps_color_4d` | int | 0x7f060396 | 8758 |
| `ps_color_4e4d4e` | int | 0x7f060397 | 8761 |
| `ps_color_529BeA` | int | 0x7f060398 | 8764 |
| `ps_color_53575e` | int | 0x7f060399 | 8767 |
| `ps_color_66` | int | 0x7f06039a | 8770 |
| `ps_color_70` | int | 0x7f06039b | 8773 |
| `ps_color_80` | int | 0x7f06039c | 8776 |
| `ps_color_8D57FC` | int | 0x7f06039d | 8779 |
| `ps_color_99_black` | int | 0x7f06039e | 8782 |
| `ps_color_9b` | int | 0x7f06039f | 8785 |
| `ps_color_a83` | int | 0x7f0603a1 | 8791 |
| `ps_color_aab2bd` | int | 0x7f0603a2 | 8794 |
| `ps_color_ba3` | int | 0x7f0603a3 | 8797 |
| `ps_color_bd` | int | 0x7f0603a4 | 8800 |
| `ps_color_bfe85d` | int | 0x7f0603a5 | 8803 |
| `ps_color_black` | int | 0x7f0603a6 | 8806 |
| `ps_color_blue` | int | 0x7f0603a7 | 8809 |
| `ps_color_e` | int | 0x7f0603a8 | 8812 |
| `ps_color_e0ff6100` | int | 0x7f0603a9 | 8815 |
| `ps_color_E4E4E4` | int | 0x7f0603a0 | 8788 |
| `ps_color_eb` | int | 0x7f0603aa | 8818 |
| `ps_color_ec` | int | 0x7f0603ab | 8821 |
| `ps_color_f0` | int | 0x7f0603ac | 8824 |
| `ps_color_f2` | int | 0x7f0603ad | 8827 |
| `ps_color_fa` | int | 0x7f0603ae | 8830 |
| `ps_color_fa632d` | int | 0x7f0603af | 8833 |
| `ps_color_ff572e` | int | 0x7f0603b0 | 8836 |
| `ps_color_ffd042` | int | 0x7f0603b1 | 8839 |
| `ps_color_ffe85d` | int | 0x7f0603b2 | 8842 |
| `ps_color_grey` | int | 0x7f0603b3 | 8845 |
| `ps_color_grey_3e` | int | 0x7f0603b4 | 8848 |
| `ps_color_half_grey` | int | 0x7f0603b5 | 8851 |
| `ps_color_half_white` | int | 0x7f0603b6 | 8854 |
| `ps_color_light_grey` | int | 0x7f0603b7 | 8857 |
| `ps_color_transparent` | int | 0x7f0603b8 | 8860 |
| `ps_color_transparent_e0db` | int | 0x7f0603b9 | 8863 |
| `ps_color_transparent_white` | int | 0x7f0603ba | 8866 |
| `ps_color_white` | int | 0x7f0603bb | 8869 |
| `public_bg` | int | 0x7f0603bc | 8872 |
| `public_press_bg` | int | 0x7f0603bd | 8875 |
| `radio_button_select_color` | int | 0x7f0603be | 8878 |
| `radio_button_select_color_2` | int | 0x7f0603bf | 8881 |
| `red_text` | int | 0x7f0603c1 | 8884 |
| `reset_step_bg` | int | 0x7f0603c2 | 8887 |
| `result_view` | int | 0x7f0603c3 | 8890 |
| `ripple_color_default` | int | 0x7f0603c4 | 8893 |
| `ripple_material_dark` | int | 0x7f0603c5 | 8896 |
| `ripple_material_light` | int | 0x7f0603c6 | 8899 |
| `scankit_mask` | int | 0x7f0603c7 | 8902 |
| `scankit_viewfinder_corner` | int | 0x7f0603c8 | 8905 |
| `scankit_viewfinder_frame` | int | 0x7f0603c9 | 8908 |
| `scankit_viewfinder_lasers` | int | 0x7f0603ca | 8911 |
| `scankit_viewfinder_mask` | int | 0x7f0603cb | 8914 |
| `scankit_viewfinder_result_point_color` | int | 0x7f0603cc | 8917 |
| `scankit_viewfinder_text_color` | int | 0x7f0603cd | 8920 |
| `scankit_viewfinder_translant` | int | 0x7f0603ce | 8923 |
| `secondary_text_default_material_dark` | int | 0x7f0603d1 | 8929 |
| `secondary_text_default_material_light` | int | 0x7f0603d2 | 8932 |
| `secondary_text_disabled_material_dark` | int | 0x7f0603d3 | 8935 |
| `secondary_text_disabled_material_light` | int | 0x7f0603d4 | 8938 |
| `secondaryBackgroundColor` | int | 0x7f0603cf | 8926 |
| `seekbar_background` | int | 0x7f0603d5 | 8941 |
| `selector_time_text` | int | 0x7f0603db | 8944 |
| `shimmer_color` | int | 0x7f0603de | 8947 |
| `status_bar` | int | 0x7f0603df | 8950 |
| `style_color` | int | 0x7f0603e0 | 8953 |
| `switch_blue` | int | 0x7f0603e1 | 8956 |
| `switch_thumb_disabled_material_dark` | int | 0x7f0603e3 | 8959 |
| `switch_thumb_disabled_material_light` | int | 0x7f0603e4 | 8962 |
| `switch_thumb_material_dark` | int | 0x7f0603e5 | 8965 |
| `switch_thumb_material_light` | int | 0x7f0603e6 | 8968 |
| `switch_thumb_normal_material_dark` | int | 0x7f0603e7 | 8971 |
| `switch_thumb_normal_material_light` | int | 0x7f0603e8 | 8974 |
| `text_color_black` | int | 0x7f0603ee | 8980 |
| `text_color_font` | int | 0x7f0603ef | 8983 |
| `text_color_white` | int | 0x7f0603f1 | 8986 |
| `text_tint` | int | 0x7f0603f7 | 8989 |
| `textColorPrimary` | int | 0x7f0603ec | 8977 |
| `theamColor` | int | 0x7f0603fa | 8992 |
| `theamColor_3f` | int | 0x7f0603fb | 8995 |
| `theamHighlightColor` | int | 0x7f0603fc | 8998 |
| `theamHighlightColor_h` | int | 0x7f0603fd | 9001 |
| `theme_green` | int | 0x7f0603fe | 9004 |
| `theme_library_album` | int | 0x7f0603ff | 9007 |
| `theme_selected_red` | int | 0x7f060400 | 9010 |
| `tooltip_background_dark` | int | 0x7f060401 | 9013 |
| `tooltip_background_light` | int | 0x7f060402 | 9016 |
| `transparent_half` | int | 0x7f060404 | 9019 |
| `transparent_half1` | int | 0x7f060405 | 9022 |
| `transparent_half2` | int | 0x7f060406 | 9025 |
| `ucrop_color_active_aspect_ratio` | int | 0x7f060407 | 9028 |
| `ucrop_color_active_controls_color` | int | 0x7f060408 | 9031 |
| `ucrop_color_black` | int | 0x7f060409 | 9034 |
| `ucrop_color_blaze_orange` | int | 0x7f06040a | 9037 |
| `ucrop_color_crop_background` | int | 0x7f06040b | 9040 |
| `ucrop_color_default_crop_frame` | int | 0x7f06040c | 9043 |
| `ucrop_color_default_crop_grid` | int | 0x7f06040d | 9046 |
| `ucrop_color_default_dimmed` | int | 0x7f06040e | 9049 |
| `ucrop_color_default_logo` | int | 0x7f06040f | 9052 |
| `ucrop_color_ebony_clay` | int | 0x7f060410 | 9055 |
| `ucrop_color_heather` | int | 0x7f060411 | 9058 |
| `ucrop_color_inactive_aspect_ratio` | int | 0x7f060412 | 9061 |
| `ucrop_color_inactive_controls_color` | int | 0x7f060413 | 9064 |
| `ucrop_color_progress_wheel_line` | int | 0x7f060414 | 9067 |
| `ucrop_color_statusbar` | int | 0x7f060415 | 9070 |
| `ucrop_color_toolbar` | int | 0x7f060416 | 9073 |
| `ucrop_color_toolbar_widget` | int | 0x7f060417 | 9076 |
| `ucrop_color_white` | int | 0x7f060418 | 9079 |
| `ucrop_color_widget` | int | 0x7f060419 | 9082 |
| `ucrop_color_widget_active` | int | 0x7f06041a | 9085 |
| `ucrop_color_widget_background` | int | 0x7f06041b | 9088 |
| `ucrop_color_widget_rotate_angle` | int | 0x7f06041c | 9091 |
| `ucrop_color_widget_rotate_mid_line` | int | 0x7f06041d | 9094 |
| `ucrop_color_widget_text` | int | 0x7f06041e | 9097 |
| `ucrop_scale_text_view_selector` | int | 0x7f06041f | 9100 |
| `viewfinder_corner` | int | 0x7f060424 | 9103 |
| `viewfinder_frame` | int | 0x7f060425 | 9106 |
| `viewfinder_label_text` | int | 0x7f060426 | 9109 |
| `viewfinder_laser` | int | 0x7f060427 | 9112 |
| `viewfinder_mask` | int | 0x7f060428 | 9115 |
| `viewfinder_point` | int | 0x7f060429 | 9118 |
| `viewfinder_point_stroke` | int | 0x7f06042a | 9121 |
| `w1` | int | 0x7f06042b | 9124 |
| `w2` | int | 0x7f06042c | 9127 |
| `w3` | int | 0x7f06042d | 9130 |
| `w4` | int | 0x7f06042e | 9133 |
| `w5` | int | 0x7f06042f | 9136 |
| `white_b1b1b1` | int | 0x7f060431 | 9139 |
| `white_d9d9d9` | int | 0x7f060432 | 9142 |
| `white_dedede` | int | 0x7f060433 | 9145 |
| `white_eeeeee` | int | 0x7f060434 | 9148 |
| `yellow` | int | 0x7f060437 | 9151 |
| `yellow_F59A23` | int | 0x7f060438 | 9154 |
| `yinse_EFF0F4` | int | 0x7f060439 | 9157 |
| `zise_323150` | int | 0x7f06043c | 9160 |

### `com.gku.xtugo.R$dimen`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `_dp0_1` | int | 0x7f070000 | 9186 |
| `_dp0_16` | int | 0x7f070001 | 9189 |
| `_dp0_4` | int | 0x7f070002 | 9192 |
| `_dp0_6` | int | 0x7f070003 | 9195 |
| `_dp0_8` | int | 0x7f070004 | 9198 |
| `_dp1` | int | 0x7f070005 | 9201 |
| `_dp10` | int | 0x7f070006 | 9204 |
| `_dp14` | int | 0x7f070007 | 9207 |
| `_dp16` | int | 0x7f070008 | 9210 |
| `_dp2` | int | 0x7f070009 | 9213 |
| `_dp20` | int | 0x7f07000a | 9216 |
| `_dp22` | int | 0x7f07000b | 9219 |
| `_dp24` | int | 0x7f07000c | 9222 |
| `_dp4` | int | 0x7f07000d | 9225 |
| `_dp5_5` | int | 0x7f07000f | 9231 |
| `_dp50` | int | 0x7f07000e | 9228 |
| `_dp6` | int | 0x7f070010 | 9234 |
| `_dp70` | int | 0x7f070011 | 9237 |
| `_dp8` | int | 0x7f070012 | 9240 |
| `_dp80` | int | 0x7f070013 | 9243 |
| `abc_action_bar_content_inset_material` | int | 0x7f070014 | 9246 |
| `abc_action_bar_content_inset_with_nav` | int | 0x7f070015 | 9249 |
| `abc_action_bar_default_height_material` | int | 0x7f070016 | 9252 |
| `abc_action_bar_default_padding_end_material` | int | 0x7f070017 | 9255 |
| `abc_action_bar_default_padding_start_material` | int | 0x7f070018 | 9258 |
| `abc_action_bar_elevation_material` | int | 0x7f070019 | 9261 |
| `abc_action_bar_icon_vertical_padding_material` | int | 0x7f07001a | 9264 |
| `abc_action_bar_overflow_padding_end_material` | int | 0x7f07001b | 9267 |
| `abc_action_bar_overflow_padding_start_material` | int | 0x7f07001c | 9270 |
| `abc_action_bar_stacked_max_height` | int | 0x7f07001d | 9273 |
| `abc_action_bar_stacked_tab_max_width` | int | 0x7f07001e | 9276 |
| `abc_action_bar_subtitle_bottom_margin_material` | int | 0x7f07001f | 9279 |
| `abc_action_bar_subtitle_top_margin_material` | int | 0x7f070020 | 9282 |
| `abc_action_button_min_height_material` | int | 0x7f070021 | 9285 |
| `abc_action_button_min_width_material` | int | 0x7f070022 | 9288 |
| `abc_action_button_min_width_overflow_material` | int | 0x7f070023 | 9291 |
| `abc_alert_dialog_button_bar_height` | int | 0x7f070024 | 9294 |
| `abc_alert_dialog_button_dimen` | int | 0x7f070025 | 9297 |
| `abc_button_inset_horizontal_material` | int | 0x7f070026 | 9300 |
| `abc_button_inset_vertical_material` | int | 0x7f070027 | 9303 |
| `abc_button_padding_horizontal_material` | int | 0x7f070028 | 9306 |
| `abc_button_padding_vertical_material` | int | 0x7f070029 | 9309 |
| `abc_cascading_menus_min_smallest_width` | int | 0x7f07002a | 9312 |
| `abc_config_prefDialogWidth` | int | 0x7f07002b | 9315 |
| `abc_control_corner_material` | int | 0x7f07002c | 9318 |
| `abc_control_inset_material` | int | 0x7f07002d | 9321 |
| `abc_control_padding_material` | int | 0x7f07002e | 9324 |
| `abc_dialog_corner_radius_material` | int | 0x7f07002f | 9327 |
| `abc_dialog_fixed_height_major` | int | 0x7f070030 | 9330 |
| `abc_dialog_fixed_height_minor` | int | 0x7f070031 | 9333 |
| `abc_dialog_fixed_width_major` | int | 0x7f070032 | 9336 |
| `abc_dialog_fixed_width_minor` | int | 0x7f070033 | 9339 |
| `abc_dialog_list_padding_bottom_no_buttons` | int | 0x7f070034 | 9342 |
| `abc_dialog_list_padding_top_no_title` | int | 0x7f070035 | 9345 |
| `abc_dialog_min_width_major` | int | 0x7f070036 | 9348 |
| `abc_dialog_min_width_minor` | int | 0x7f070037 | 9351 |
| `abc_dialog_padding_material` | int | 0x7f070038 | 9354 |
| `abc_dialog_padding_top_material` | int | 0x7f070039 | 9357 |
| `abc_dialog_title_divider_material` | int | 0x7f07003a | 9360 |
| `abc_disabled_alpha_material_dark` | int | 0x7f07003b | 9363 |
| `abc_disabled_alpha_material_light` | int | 0x7f07003c | 9366 |
| `abc_dropdownitem_icon_width` | int | 0x7f07003d | 9369 |
| `abc_dropdownitem_text_padding_left` | int | 0x7f07003e | 9372 |
| `abc_dropdownitem_text_padding_right` | int | 0x7f07003f | 9375 |
| `abc_edit_text_inset_bottom_material` | int | 0x7f070040 | 9378 |
| `abc_edit_text_inset_horizontal_material` | int | 0x7f070041 | 9381 |
| `abc_edit_text_inset_top_material` | int | 0x7f070042 | 9384 |
| `abc_floating_window_z` | int | 0x7f070043 | 9387 |
| `abc_list_item_height_large_material` | int | 0x7f070044 | 9390 |
| `abc_list_item_height_material` | int | 0x7f070045 | 9393 |
| `abc_list_item_height_small_material` | int | 0x7f070046 | 9396 |
| `abc_list_item_padding_horizontal_material` | int | 0x7f070047 | 9399 |
| `abc_panel_menu_list_width` | int | 0x7f070048 | 9402 |
| `abc_progress_bar_height_material` | int | 0x7f070049 | 9405 |
| `abc_search_view_preferred_height` | int | 0x7f07004a | 9408 |
| `abc_search_view_preferred_width` | int | 0x7f07004b | 9411 |
| `abc_seekbar_track_background_height_material` | int | 0x7f07004c | 9414 |
| `abc_seekbar_track_progress_height_material` | int | 0x7f07004d | 9417 |
| `abc_select_dialog_padding_start_material` | int | 0x7f07004e | 9420 |
| `abc_star_big` | int | 0x7f07004f | 9423 |
| `abc_star_medium` | int | 0x7f070050 | 9426 |
| `abc_star_small` | int | 0x7f070051 | 9429 |
| `abc_switch_padding` | int | 0x7f070052 | 9432 |
| `abc_text_size_body_1_material` | int | 0x7f070053 | 9435 |
| `abc_text_size_body_2_material` | int | 0x7f070054 | 9438 |
| `abc_text_size_button_material` | int | 0x7f070055 | 9441 |
| `abc_text_size_caption_material` | int | 0x7f070056 | 9444 |
| `abc_text_size_display_1_material` | int | 0x7f070057 | 9447 |
| `abc_text_size_display_2_material` | int | 0x7f070058 | 9450 |
| `abc_text_size_display_3_material` | int | 0x7f070059 | 9453 |
| `abc_text_size_display_4_material` | int | 0x7f07005a | 9456 |
| `abc_text_size_headline_material` | int | 0x7f07005b | 9459 |
| `abc_text_size_large_material` | int | 0x7f07005c | 9462 |
| `abc_text_size_medium_material` | int | 0x7f07005d | 9465 |
| `abc_text_size_menu_header_material` | int | 0x7f07005e | 9468 |
| `abc_text_size_menu_material` | int | 0x7f07005f | 9471 |
| `abc_text_size_small_material` | int | 0x7f070060 | 9474 |
| `abc_text_size_subhead_material` | int | 0x7f070061 | 9477 |
| `abc_text_size_subtitle_material_toolbar` | int | 0x7f070062 | 9480 |
| `abc_text_size_title_material` | int | 0x7f070063 | 9483 |
| `abc_text_size_title_material_toolbar` | int | 0x7f070064 | 9486 |
| `appcompat_dialog_background_inset` | int | 0x7f070067 | 9489 |
| `brightness_icon` | int | 0x7f070068 | 9492 |
| `camera_scan_flashlight_margin_top` | int | 0x7f070069 | 9495 |
| `cardview_compat_inset_shadow` | int | 0x7f07006a | 9498 |
| `cardview_default_elevation` | int | 0x7f07006b | 9501 |
| `cardview_default_radius` | int | 0x7f07006c | 9504 |
| `clock_face_margin_start` | int | 0x7f07006d | 9507 |
| `compat_button_inset_horizontal_material` | int | 0x7f07006e | 9510 |
| `compat_button_inset_vertical_material` | int | 0x7f07006f | 9513 |
| `compat_button_padding_horizontal_material` | int | 0x7f070070 | 9516 |
| `compat_button_padding_vertical_material` | int | 0x7f070071 | 9519 |
| `compat_control_corner_material` | int | 0x7f070072 | 9522 |
| `compat_notification_large_icon_max_height` | int | 0x7f070073 | 9525 |
| `compat_notification_large_icon_max_width` | int | 0x7f070074 | 9528 |
| `def_drawer_elevation` | int | 0x7f070075 | 9531 |
| `def_height` | int | 0x7f070076 | 9534 |
| `default_indexBar_layout_width` | int | 0x7f070077 | 9537 |
| `default_indexBar_textSize` | int | 0x7f070078 | 9540 |
| `default_indexBar_textSpace` | int | 0x7f070079 | 9543 |
| `design_appbar_elevation` | int | 0x7f07007a | 9546 |
| `design_bottom_navigation_active_item_max_width` | int | 0x7f07007b | 9549 |
| `design_bottom_navigation_active_item_min_width` | int | 0x7f07007c | 9552 |
| `design_bottom_navigation_active_text_size` | int | 0x7f07007d | 9555 |
| `design_bottom_navigation_elevation` | int | 0x7f07007e | 9558 |
| `design_bottom_navigation_height` | int | 0x7f07007f | 9561 |
| `design_bottom_navigation_icon_size` | int | 0x7f070080 | 9564 |
| `design_bottom_navigation_item_max_width` | int | 0x7f070081 | 9567 |
| `design_bottom_navigation_item_min_width` | int | 0x7f070082 | 9570 |
| `design_bottom_navigation_label_padding` | int | 0x7f070083 | 9573 |
| `design_bottom_navigation_margin` | int | 0x7f070084 | 9576 |
| `design_bottom_navigation_shadow_height` | int | 0x7f070085 | 9579 |
| `design_bottom_navigation_text_size` | int | 0x7f070086 | 9582 |
| `design_bottom_sheet_elevation` | int | 0x7f070087 | 9585 |
| `design_bottom_sheet_modal_elevation` | int | 0x7f070088 | 9588 |
| `design_bottom_sheet_peek_height_min` | int | 0x7f070089 | 9591 |
| `design_fab_border_width` | int | 0x7f07008a | 9594 |
| `design_fab_elevation` | int | 0x7f07008b | 9597 |
| `design_fab_image_size` | int | 0x7f07008c | 9600 |
| `design_fab_size_mini` | int | 0x7f07008d | 9603 |
| `design_fab_size_normal` | int | 0x7f07008e | 9606 |
| `design_fab_translation_z_hovered_focused` | int | 0x7f07008f | 9609 |
| `design_fab_translation_z_pressed` | int | 0x7f070090 | 9612 |
| `design_navigation_elevation` | int | 0x7f070091 | 9615 |
| `design_navigation_icon_padding` | int | 0x7f070092 | 9618 |
| `design_navigation_icon_size` | int | 0x7f070093 | 9621 |
| `design_navigation_item_horizontal_padding` | int | 0x7f070094 | 9624 |
| `design_navigation_item_icon_padding` | int | 0x7f070095 | 9627 |
| `design_navigation_item_vertical_padding` | int | 0x7f070096 | 9630 |
| `design_navigation_max_width` | int | 0x7f070097 | 9633 |
| `design_navigation_padding_bottom` | int | 0x7f070098 | 9636 |
| `design_navigation_separator_vertical_padding` | int | 0x7f070099 | 9639 |
| `design_snackbar_action_inline_max_width` | int | 0x7f07009a | 9642 |
| `design_snackbar_action_text_color_alpha` | int | 0x7f07009b | 9645 |
| `design_snackbar_background_corner_radius` | int | 0x7f07009c | 9648 |
| `design_snackbar_elevation` | int | 0x7f07009d | 9651 |
| `design_snackbar_extra_spacing_horizontal` | int | 0x7f07009e | 9654 |
| `design_snackbar_max_width` | int | 0x7f07009f | 9657 |
| `design_snackbar_min_width` | int | 0x7f0700a0 | 9660 |
| `design_snackbar_padding_horizontal` | int | 0x7f0700a1 | 9663 |
| `design_snackbar_padding_vertical` | int | 0x7f0700a2 | 9666 |
| `design_snackbar_padding_vertical_2lines` | int | 0x7f0700a3 | 9669 |
| `design_snackbar_text_size` | int | 0x7f0700a4 | 9672 |
| `design_tab_max_width` | int | 0x7f0700a5 | 9675 |
| `design_tab_scrollable_min_width` | int | 0x7f0700a6 | 9678 |
| `design_tab_text_size` | int | 0x7f0700a7 | 9681 |
| `design_tab_text_size_2line` | int | 0x7f0700a8 | 9684 |
| `design_textinput_caption_translate_y` | int | 0x7f0700a9 | 9687 |
| `disabled_alpha_material_dark` | int | 0x7f0700aa | 9690 |
| `disabled_alpha_material_light` | int | 0x7f0700ab | 9693 |
| `dp_10` | int | 0x7f070111 | 9999 |
| `dp_4` | int | 0x7f070112 | 10002 |
| `dp_40` | int | 0x7f070113 | 10005 |
| `dp0_1` | int | 0x7f0700ac | 9696 |
| `dp0_2` | int | 0x7f0700ad | 9699 |
| `dp0_4` | int | 0x7f0700ae | 9702 |
| `dp0_6` | int | 0x7f0700af | 9705 |
| `dp0_8` | int | 0x7f0700b0 | 9708 |
| `dp1` | int | 0x7f0700b1 | 9711 |
| `dp10` | int | 0x7f0700b2 | 9714 |
| `dp100` | int | 0x7f0700b3 | 9717 |
| `dp11` | int | 0x7f0700b4 | 9720 |
| `dp110` | int | 0x7f0700b5 | 9723 |
| `dp12` | int | 0x7f0700b6 | 9726 |
| `dp120` | int | 0x7f0700b7 | 9729 |
| `dp13` | int | 0x7f0700b8 | 9732 |
| `dp130` | int | 0x7f0700b9 | 9735 |
| `dp14` | int | 0x7f0700ba | 9738 |
| `dp140` | int | 0x7f0700bb | 9741 |
| `dp15` | int | 0x7f0700bc | 9744 |
| `dp150` | int | 0x7f0700bd | 9747 |
| `dp16` | int | 0x7f0700be | 9750 |
| `dp160` | int | 0x7f0700bf | 9753 |
| `dp169` | int | 0x7f0700c0 | 9756 |
| `dp170` | int | 0x7f0700c1 | 9759 |
| `dp18` | int | 0x7f0700c2 | 9762 |
| `dp180` | int | 0x7f0700c3 | 9765 |
| `dp188` | int | 0x7f0700c4 | 9768 |
| `dp194` | int | 0x7f0700c5 | 9771 |
| `dp2` | int | 0x7f0700c6 | 9774 |
| `dp20` | int | 0x7f0700c7 | 9777 |
| `dp200` | int | 0x7f0700c8 | 9780 |
| `dp21` | int | 0x7f0700c9 | 9783 |
| `dp210` | int | 0x7f0700ca | 9786 |
| `dp22` | int | 0x7f0700cb | 9789 |
| `dp220` | int | 0x7f0700cc | 9792 |
| `dp23` | int | 0x7f0700cd | 9795 |
| `dp230` | int | 0x7f0700ce | 9798 |
| `dp24` | int | 0x7f0700cf | 9801 |
| `dp240` | int | 0x7f0700d0 | 9804 |
| `dp248` | int | 0x7f0700d1 | 9807 |
| `dp25` | int | 0x7f0700d2 | 9810 |
| `dp250` | int | 0x7f0700d3 | 9813 |
| `dp26` | int | 0x7f0700d4 | 9816 |
| `dp260` | int | 0x7f0700d5 | 9819 |
| `dp266` | int | 0x7f0700d6 | 9822 |
| `dp270` | int | 0x7f0700d7 | 9825 |
| `dp273` | int | 0x7f0700d8 | 9828 |
| `dp28` | int | 0x7f0700d9 | 9831 |
| `dp280` | int | 0x7f0700da | 9834 |
| `dp29` | int | 0x7f0700db | 9837 |
| `dp3` | int | 0x7f0700dc | 9840 |
| `dp30` | int | 0x7f0700dd | 9843 |
| `dp300` | int | 0x7f0700de | 9846 |
| `dp31` | int | 0x7f0700df | 9849 |
| `dp32` | int | 0x7f0700e0 | 9852 |
| `dp320` | int | 0x7f0700e1 | 9855 |
| `dp33` | int | 0x7f0700e2 | 9858 |
| `dp330` | int | 0x7f0700e3 | 9861 |
| `dp34` | int | 0x7f0700e4 | 9864 |
| `dp340` | int | 0x7f0700e5 | 9867 |
| `dp345` | int | 0x7f0700e6 | 9870 |
| `dp35` | int | 0x7f0700e7 | 9873 |
| `dp356` | int | 0x7f0700e8 | 9876 |
| `dp36` | int | 0x7f0700e9 | 9879 |
| `dp360` | int | 0x7f0700ea | 9882 |
| `dp38` | int | 0x7f0700eb | 9885 |
| `dp4` | int | 0x7f0700ec | 9888 |
| `dp4_5` | int | 0x7f0700f7 | 9921 |
| `dp40` | int | 0x7f0700ed | 9891 |
| `dp400` | int | 0x7f0700ee | 9894 |
| `dp42` | int | 0x7f0700ef | 9897 |
| `dp420` | int | 0x7f0700f0 | 9900 |
| `dp43` | int | 0x7f0700f1 | 9903 |
| `dp44` | int | 0x7f0700f2 | 9906 |
| `dp45` | int | 0x7f0700f3 | 9909 |
| `dp46` | int | 0x7f0700f4 | 9912 |
| `dp460` | int | 0x7f0700f5 | 9915 |
| `dp48` | int | 0x7f0700f6 | 9918 |
| `dp5` | int | 0x7f0700f8 | 9924 |
| `dp50` | int | 0x7f0700f9 | 9927 |
| `dp500` | int | 0x7f0700fa | 9930 |
| `dp52` | int | 0x7f0700fb | 9933 |
| `dp54` | int | 0x7f0700fc | 9936 |
| `dp540` | int | 0x7f0700fd | 9939 |
| `dp56` | int | 0x7f0700fe | 9942 |
| `dp560` | int | 0x7f0700ff | 9945 |
| `dp58` | int | 0x7f070100 | 9948 |
| `dp580` | int | 0x7f070101 | 9951 |
| `dp6` | int | 0x7f070102 | 9954 |
| `dp60` | int | 0x7f070103 | 9957 |
| `dp600` | int | 0x7f070104 | 9960 |
| `dp610` | int | 0x7f070105 | 9963 |
| `dp64` | int | 0x7f070106 | 9966 |
| `dp640` | int | 0x7f070107 | 9969 |
| `dp66` | int | 0x7f070108 | 9972 |
| `dp68` | int | 0x7f070109 | 9975 |
| `dp7` | int | 0x7f07010a | 9978 |
| `dp70` | int | 0x7f07010b | 9981 |
| `dp74` | int | 0x7f07010c | 9984 |
| `dp8` | int | 0x7f07010d | 9987 |
| `dp80` | int | 0x7f07010e | 9990 |
| `dp9` | int | 0x7f07010f | 9993 |
| `dp90` | int | 0x7f070110 | 9996 |
| `exo_error_message_height` | int | 0x7f070114 | 10008 |
| `exo_error_message_margin_bottom` | int | 0x7f070115 | 10011 |
| `exo_error_message_text_padding_horizontal` | int | 0x7f070116 | 10014 |
| `exo_error_message_text_padding_vertical` | int | 0x7f070117 | 10017 |
| `exo_error_message_text_size` | int | 0x7f070118 | 10020 |
| `exo_icon_horizontal_margin` | int | 0x7f070119 | 10023 |
| `exo_icon_padding` | int | 0x7f07011a | 10026 |
| `exo_icon_padding_bottom` | int | 0x7f07011b | 10029 |
| `exo_icon_size` | int | 0x7f07011c | 10032 |
| `exo_icon_text_size` | int | 0x7f07011d | 10035 |
| `exo_media_button_height` | int | 0x7f07011e | 10038 |
| `exo_media_button_width` | int | 0x7f07011f | 10041 |
| `exo_setting_width` | int | 0x7f070120 | 10044 |
| `exo_settings_height` | int | 0x7f070121 | 10047 |
| `exo_settings_icon_size` | int | 0x7f070122 | 10050 |
| `exo_settings_main_text_size` | int | 0x7f070123 | 10053 |
| `exo_settings_offset` | int | 0x7f070124 | 10056 |
| `exo_settings_sub_text_size` | int | 0x7f070125 | 10059 |
| `exo_settings_text_height` | int | 0x7f070126 | 10062 |
| `exo_small_icon_height` | int | 0x7f070127 | 10065 |
| `exo_small_icon_horizontal_margin` | int | 0x7f070128 | 10068 |
| `exo_small_icon_padding_horizontal` | int | 0x7f070129 | 10071 |
| `exo_small_icon_padding_vertical` | int | 0x7f07012a | 10074 |
| `exo_small_icon_width` | int | 0x7f07012b | 10077 |
| `exo_styled_bottom_bar_height` | int | 0x7f07012c | 10080 |
| `exo_styled_bottom_bar_margin_top` | int | 0x7f07012d | 10083 |
| `exo_styled_bottom_bar_time_padding` | int | 0x7f07012e | 10086 |
| `exo_styled_controls_padding` | int | 0x7f07012f | 10089 |
| `exo_styled_minimal_controls_margin_bottom` | int | 0x7f070130 | 10092 |
| `exo_styled_progress_bar_height` | int | 0x7f070131 | 10095 |
| `exo_styled_progress_dragged_thumb_size` | int | 0x7f070132 | 10098 |
| `exo_styled_progress_enabled_thumb_size` | int | 0x7f070133 | 10101 |
| `exo_styled_progress_layout_height` | int | 0x7f070134 | 10104 |
| `exo_styled_progress_margin_bottom` | int | 0x7f070135 | 10107 |
| `exo_styled_progress_touch_target_height` | int | 0x7f070136 | 10110 |
| `fastscroll_default_thickness` | int | 0x7f070137 | 10113 |
| `fastscroll_margin` | int | 0x7f070138 | 10116 |
| `fastscroll_minimum_range` | int | 0x7f070139 | 10119 |
| `height_tab_bottom` | int | 0x7f07013b | 10122 |
| `height_title` | int | 0x7f07013c | 10125 |
| `highlight_alpha_material_colored` | int | 0x7f07013d | 10128 |
| `highlight_alpha_material_dark` | int | 0x7f07013e | 10131 |
| `highlight_alpha_material_light` | int | 0x7f07013f | 10134 |
| `hint_alpha_material_dark` | int | 0x7f070140 | 10137 |
| `hint_alpha_material_light` | int | 0x7f070141 | 10140 |
| `hint_pressed_alpha_material_dark` | int | 0x7f070142 | 10143 |
| `hint_pressed_alpha_material_light` | int | 0x7f070143 | 10146 |
| `item_touch_helper_max_drag_scroll_per_frame` | int | 0x7f070147 | 10149 |
| `item_touch_helper_swipe_escape_max_velocity` | int | 0x7f070148 | 10152 |
| `item_touch_helper_swipe_escape_velocity` | int | 0x7f070149 | 10155 |
| `m3_alert_dialog_action_bottom_padding` | int | 0x7f07014b | 10158 |
| `m3_alert_dialog_action_top_padding` | int | 0x7f07014c | 10161 |
| `m3_alert_dialog_corner_size` | int | 0x7f07014d | 10164 |
| `m3_alert_dialog_elevation` | int | 0x7f07014e | 10167 |
| `m3_alert_dialog_icon_margin` | int | 0x7f07014f | 10170 |
| `m3_alert_dialog_icon_size` | int | 0x7f070150 | 10173 |
| `m3_alert_dialog_title_bottom_margin` | int | 0x7f070151 | 10176 |
| `m3_appbar_expanded_title_margin_bottom` | int | 0x7f070152 | 10179 |
| `m3_appbar_expanded_title_margin_horizontal` | int | 0x7f070153 | 10182 |
| `m3_appbar_scrim_height_trigger` | int | 0x7f070154 | 10185 |
| `m3_appbar_scrim_height_trigger_large` | int | 0x7f070155 | 10188 |
| `m3_appbar_scrim_height_trigger_medium` | int | 0x7f070156 | 10191 |
| `m3_appbar_size_compact` | int | 0x7f070157 | 10194 |
| `m3_appbar_size_large` | int | 0x7f070158 | 10197 |
| `m3_appbar_size_medium` | int | 0x7f070159 | 10200 |
| `m3_back_progress_bottom_container_max_scale_x_distance` | int | 0x7f07015a | 10203 |
| `m3_back_progress_bottom_container_max_scale_y_distance` | int | 0x7f07015b | 10206 |
| `m3_back_progress_main_container_max_translation_y` | int | 0x7f07015c | 10209 |
| `m3_back_progress_main_container_min_edge_gap` | int | 0x7f07015d | 10212 |
| `m3_back_progress_side_container_max_scale_x_distance_grow` | int | 0x7f07015e | 10215 |
| `m3_back_progress_side_container_max_scale_x_distance_shrink` | int | 0x7f07015f | 10218 |
| `m3_back_progress_side_container_max_scale_y_distance` | int | 0x7f070160 | 10221 |
| `m3_badge_horizontal_offset` | int | 0x7f070161 | 10224 |
| `m3_badge_offset` | int | 0x7f070162 | 10227 |
| `m3_badge_size` | int | 0x7f070163 | 10230 |
| `m3_badge_vertical_offset` | int | 0x7f070164 | 10233 |
| `m3_badge_with_text_horizontal_offset` | int | 0x7f070165 | 10236 |
| `m3_badge_with_text_offset` | int | 0x7f070166 | 10239 |
| `m3_badge_with_text_size` | int | 0x7f070167 | 10242 |
| `m3_badge_with_text_vertical_offset` | int | 0x7f070168 | 10245 |
| `m3_badge_with_text_vertical_padding` | int | 0x7f070169 | 10248 |
| `m3_bottom_nav_item_active_indicator_height` | int | 0x7f07016a | 10251 |
| `m3_bottom_nav_item_active_indicator_margin_horizontal` | int | 0x7f07016b | 10254 |
| `m3_bottom_nav_item_active_indicator_width` | int | 0x7f07016c | 10257 |
| `m3_bottom_nav_item_padding_bottom` | int | 0x7f07016d | 10260 |
| `m3_bottom_nav_item_padding_top` | int | 0x7f07016e | 10263 |
| `m3_bottom_nav_min_height` | int | 0x7f07016f | 10266 |
| `m3_bottom_sheet_drag_handle_bottom_padding` | int | 0x7f070170 | 10269 |
| `m3_bottom_sheet_elevation` | int | 0x7f070171 | 10272 |
| `m3_bottom_sheet_modal_elevation` | int | 0x7f070172 | 10275 |
| `m3_bottomappbar_fab_cradle_margin` | int | 0x7f070173 | 10278 |
| `m3_bottomappbar_fab_cradle_rounded_corner_radius` | int | 0x7f070174 | 10281 |
| `m3_bottomappbar_fab_cradle_vertical_offset` | int | 0x7f070175 | 10284 |
| `m3_bottomappbar_fab_end_margin` | int | 0x7f070176 | 10287 |
| `m3_bottomappbar_height` | int | 0x7f070177 | 10290 |
| `m3_bottomappbar_horizontal_padding` | int | 0x7f070178 | 10293 |
| `m3_btn_dialog_btn_min_width` | int | 0x7f070179 | 10296 |
| `m3_btn_dialog_btn_spacing` | int | 0x7f07017a | 10299 |
| `m3_btn_disabled_elevation` | int | 0x7f07017b | 10302 |
| `m3_btn_disabled_translation_z` | int | 0x7f07017c | 10305 |
| `m3_btn_elevated_btn_elevation` | int | 0x7f07017d | 10308 |
| `m3_btn_elevation` | int | 0x7f07017e | 10311 |
| `m3_btn_icon_btn_padding_left` | int | 0x7f07017f | 10314 |
| `m3_btn_icon_btn_padding_right` | int | 0x7f070180 | 10317 |
| `m3_btn_icon_only_default_padding` | int | 0x7f070181 | 10320 |
| `m3_btn_icon_only_default_size` | int | 0x7f070182 | 10323 |
| `m3_btn_icon_only_icon_padding` | int | 0x7f070183 | 10326 |
| `m3_btn_icon_only_min_width` | int | 0x7f070184 | 10329 |
| `m3_btn_inset` | int | 0x7f070185 | 10332 |
| `m3_btn_max_width` | int | 0x7f070186 | 10335 |
| `m3_btn_padding_bottom` | int | 0x7f070187 | 10338 |
| `m3_btn_padding_left` | int | 0x7f070188 | 10341 |
| `m3_btn_padding_right` | int | 0x7f070189 | 10344 |
| `m3_btn_padding_top` | int | 0x7f07018a | 10347 |
| `m3_btn_stroke_size` | int | 0x7f07018b | 10350 |
| `m3_btn_text_btn_icon_padding_left` | int | 0x7f07018c | 10353 |
| `m3_btn_text_btn_icon_padding_right` | int | 0x7f07018d | 10356 |
| `m3_btn_text_btn_padding_left` | int | 0x7f07018e | 10359 |
| `m3_btn_text_btn_padding_right` | int | 0x7f07018f | 10362 |
| `m3_btn_translation_z_base` | int | 0x7f070190 | 10365 |
| `m3_btn_translation_z_hovered` | int | 0x7f070191 | 10368 |
| `m3_card_disabled_z` | int | 0x7f070192 | 10371 |
| `m3_card_dragged_z` | int | 0x7f070193 | 10374 |
| `m3_card_elevated_disabled_z` | int | 0x7f070194 | 10377 |
| `m3_card_elevated_dragged_z` | int | 0x7f070195 | 10380 |
| `m3_card_elevated_elevation` | int | 0x7f070196 | 10383 |
| `m3_card_elevated_hovered_z` | int | 0x7f070197 | 10386 |
| `m3_card_elevation` | int | 0x7f070198 | 10389 |
| `m3_card_hovered_z` | int | 0x7f070199 | 10392 |
| `m3_card_stroke_width` | int | 0x7f07019a | 10395 |
| `m3_carousel_debug_keyline_width` | int | 0x7f07019b | 10398 |
| `m3_carousel_extra_small_item_size` | int | 0x7f07019c | 10401 |
| `m3_carousel_gone_size` | int | 0x7f07019d | 10404 |
| `m3_carousel_small_item_default_corner_size` | int | 0x7f07019e | 10407 |
| `m3_carousel_small_item_size_max` | int | 0x7f07019f | 10410 |
| `m3_carousel_small_item_size_min` | int | 0x7f0701a0 | 10413 |
| `m3_chip_checked_hovered_translation_z` | int | 0x7f0701a1 | 10416 |
| `m3_chip_corner_size` | int | 0x7f0701a2 | 10419 |
| `m3_chip_disabled_translation_z` | int | 0x7f0701a3 | 10422 |
| `m3_chip_dragged_translation_z` | int | 0x7f0701a4 | 10425 |
| `m3_chip_elevated_elevation` | int | 0x7f0701a5 | 10428 |
| `m3_chip_hovered_translation_z` | int | 0x7f0701a6 | 10431 |
| `m3_chip_icon_size` | int | 0x7f0701a7 | 10434 |
| `m3_comp_assist_chip_container_height` | int | 0x7f0701a8 | 10437 |
| `m3_comp_assist_chip_elevated_container_elevation` | int | 0x7f0701a9 | 10440 |
| `m3_comp_assist_chip_flat_container_elevation` | int | 0x7f0701aa | 10443 |
| `m3_comp_assist_chip_flat_outline_width` | int | 0x7f0701ab | 10446 |
| `m3_comp_assist_chip_with_icon_icon_size` | int | 0x7f0701ac | 10449 |
| `m3_comp_badge_large_size` | int | 0x7f0701ad | 10452 |
| `m3_comp_badge_size` | int | 0x7f0701ae | 10455 |
| `m3_comp_bottom_app_bar_container_elevation` | int | 0x7f0701af | 10458 |
| `m3_comp_bottom_app_bar_container_height` | int | 0x7f0701b0 | 10461 |
| `m3_comp_checkbox_selected_disabled_container_opacity` | int | 0x7f0701b1 | 10464 |
| `m3_comp_circular_progress_indicator_active_indicator_width` | int | 0x7f0701b2 | 10467 |
| `m3_comp_date_picker_modal_date_today_container_outline_width` | int | 0x7f0701b3 | 10470 |
| `m3_comp_date_picker_modal_header_container_height` | int | 0x7f0701b4 | 10473 |
| `m3_comp_date_picker_modal_range_selection_header_container_height` | int | 0x7f0701b5 | 10476 |
| `m3_comp_divider_thickness` | int | 0x7f0701b6 | 10479 |
| `m3_comp_elevated_button_container_elevation` | int | 0x7f0701b7 | 10482 |
| `m3_comp_elevated_button_disabled_container_elevation` | int | 0x7f0701b8 | 10485 |
| `m3_comp_elevated_card_container_elevation` | int | 0x7f0701b9 | 10488 |
| `m3_comp_elevated_card_icon_size` | int | 0x7f0701ba | 10491 |
| `m3_comp_extended_fab_primary_container_elevation` | int | 0x7f0701bb | 10494 |
| `m3_comp_extended_fab_primary_container_height` | int | 0x7f0701bc | 10497 |
| `m3_comp_extended_fab_primary_focus_container_elevation` | int | 0x7f0701bd | 10500 |
| `m3_comp_extended_fab_primary_focus_state_layer_opacity` | int | 0x7f0701be | 10503 |
| `m3_comp_extended_fab_primary_hover_container_elevation` | int | 0x7f0701bf | 10506 |
| `m3_comp_extended_fab_primary_hover_state_layer_opacity` | int | 0x7f0701c0 | 10509 |
| `m3_comp_extended_fab_primary_icon_size` | int | 0x7f0701c1 | 10512 |
| `m3_comp_extended_fab_primary_pressed_container_elevation` | int | 0x7f0701c2 | 10515 |
| `m3_comp_extended_fab_primary_pressed_state_layer_opacity` | int | 0x7f0701c3 | 10518 |
| `m3_comp_fab_primary_container_elevation` | int | 0x7f0701c4 | 10521 |
| `m3_comp_fab_primary_container_height` | int | 0x7f0701c5 | 10524 |
| `m3_comp_fab_primary_focus_state_layer_opacity` | int | 0x7f0701c6 | 10527 |
| `m3_comp_fab_primary_hover_container_elevation` | int | 0x7f0701c7 | 10530 |
| `m3_comp_fab_primary_hover_state_layer_opacity` | int | 0x7f0701c8 | 10533 |
| `m3_comp_fab_primary_icon_size` | int | 0x7f0701c9 | 10536 |
| `m3_comp_fab_primary_large_container_height` | int | 0x7f0701ca | 10539 |
| `m3_comp_fab_primary_large_icon_size` | int | 0x7f0701cb | 10542 |
| `m3_comp_fab_primary_pressed_container_elevation` | int | 0x7f0701cc | 10545 |
| `m3_comp_fab_primary_pressed_state_layer_opacity` | int | 0x7f0701cd | 10548 |
| `m3_comp_fab_primary_small_container_height` | int | 0x7f0701ce | 10551 |
| `m3_comp_fab_primary_small_icon_size` | int | 0x7f0701cf | 10554 |
| `m3_comp_filled_autocomplete_menu_container_elevation` | int | 0x7f0701d0 | 10557 |
| `m3_comp_filled_button_container_elevation` | int | 0x7f0701d1 | 10560 |
| `m3_comp_filled_button_with_icon_icon_size` | int | 0x7f0701d2 | 10563 |
| `m3_comp_filled_card_container_elevation` | int | 0x7f0701d3 | 10566 |
| `m3_comp_filled_card_dragged_state_layer_opacity` | int | 0x7f0701d4 | 10569 |
| `m3_comp_filled_card_focus_state_layer_opacity` | int | 0x7f0701d5 | 10572 |
| `m3_comp_filled_card_hover_state_layer_opacity` | int | 0x7f0701d6 | 10575 |
| `m3_comp_filled_card_icon_size` | int | 0x7f0701d7 | 10578 |
| `m3_comp_filled_card_pressed_state_layer_opacity` | int | 0x7f0701d8 | 10581 |
| `m3_comp_filled_text_field_disabled_active_indicator_opacity` | int | 0x7f0701d9 | 10584 |
| `m3_comp_filter_chip_container_height` | int | 0x7f0701da | 10587 |
| `m3_comp_filter_chip_elevated_container_elevation` | int | 0x7f0701db | 10590 |
| `m3_comp_filter_chip_flat_container_elevation` | int | 0x7f0701dc | 10593 |
| `m3_comp_filter_chip_flat_unselected_outline_width` | int | 0x7f0701dd | 10596 |
| `m3_comp_filter_chip_with_icon_icon_size` | int | 0x7f0701de | 10599 |
| `m3_comp_input_chip_container_elevation` | int | 0x7f0701df | 10602 |
| `m3_comp_input_chip_container_height` | int | 0x7f0701e0 | 10605 |
| `m3_comp_input_chip_unselected_outline_width` | int | 0x7f0701e1 | 10608 |
| `m3_comp_input_chip_with_avatar_avatar_size` | int | 0x7f0701e2 | 10611 |
| `m3_comp_input_chip_with_leading_icon_leading_icon_size` | int | 0x7f0701e3 | 10614 |
| `m3_comp_linear_progress_indicator_active_indicator_height` | int | 0x7f0701e4 | 10617 |
| `m3_comp_menu_container_elevation` | int | 0x7f0701e5 | 10620 |
| `m3_comp_navigation_bar_active_indicator_height` | int | 0x7f0701e6 | 10623 |
| `m3_comp_navigation_bar_active_indicator_width` | int | 0x7f0701e7 | 10626 |
| `m3_comp_navigation_bar_container_elevation` | int | 0x7f0701e8 | 10629 |
| `m3_comp_navigation_bar_container_height` | int | 0x7f0701e9 | 10632 |
| `m3_comp_navigation_bar_focus_state_layer_opacity` | int | 0x7f0701ea | 10635 |
| `m3_comp_navigation_bar_hover_state_layer_opacity` | int | 0x7f0701eb | 10638 |
| `m3_comp_navigation_bar_icon_size` | int | 0x7f0701ec | 10641 |
| `m3_comp_navigation_bar_pressed_state_layer_opacity` | int | 0x7f0701ed | 10644 |
| `m3_comp_navigation_drawer_container_width` | int | 0x7f0701ee | 10647 |
| `m3_comp_navigation_drawer_focus_state_layer_opacity` | int | 0x7f0701ef | 10650 |
| `m3_comp_navigation_drawer_hover_state_layer_opacity` | int | 0x7f0701f0 | 10653 |
| `m3_comp_navigation_drawer_icon_size` | int | 0x7f0701f1 | 10656 |
| `m3_comp_navigation_drawer_modal_container_elevation` | int | 0x7f0701f2 | 10659 |
| `m3_comp_navigation_drawer_pressed_state_layer_opacity` | int | 0x7f0701f3 | 10662 |
| `m3_comp_navigation_drawer_standard_container_elevation` | int | 0x7f0701f4 | 10665 |
| `m3_comp_navigation_rail_active_indicator_height` | int | 0x7f0701f5 | 10668 |
| `m3_comp_navigation_rail_active_indicator_width` | int | 0x7f0701f6 | 10671 |
| `m3_comp_navigation_rail_container_elevation` | int | 0x7f0701f7 | 10674 |
| `m3_comp_navigation_rail_container_width` | int | 0x7f0701f8 | 10677 |
| `m3_comp_navigation_rail_focus_state_layer_opacity` | int | 0x7f0701f9 | 10680 |
| `m3_comp_navigation_rail_hover_state_layer_opacity` | int | 0x7f0701fa | 10683 |
| `m3_comp_navigation_rail_icon_size` | int | 0x7f0701fb | 10686 |
| `m3_comp_navigation_rail_pressed_state_layer_opacity` | int | 0x7f0701fc | 10689 |
| `m3_comp_outlined_autocomplete_menu_container_elevation` | int | 0x7f0701fd | 10692 |
| `m3_comp_outlined_button_disabled_outline_opacity` | int | 0x7f0701fe | 10695 |
| `m3_comp_outlined_button_outline_width` | int | 0x7f0701ff | 10698 |
| `m3_comp_outlined_card_container_elevation` | int | 0x7f070200 | 10701 |
| `m3_comp_outlined_card_disabled_outline_opacity` | int | 0x7f070201 | 10704 |
| `m3_comp_outlined_card_icon_size` | int | 0x7f070202 | 10707 |
| `m3_comp_outlined_card_outline_width` | int | 0x7f070203 | 10710 |
| `m3_comp_outlined_icon_button_unselected_outline_width` | int | 0x7f070204 | 10713 |
| `m3_comp_outlined_text_field_disabled_input_text_opacity` | int | 0x7f070205 | 10716 |
| `m3_comp_outlined_text_field_disabled_label_text_opacity` | int | 0x7f070206 | 10719 |
| `m3_comp_outlined_text_field_disabled_supporting_text_opacity` | int | 0x7f070207 | 10722 |
| `m3_comp_outlined_text_field_focus_outline_width` | int | 0x7f070208 | 10725 |
| `m3_comp_outlined_text_field_outline_width` | int | 0x7f070209 | 10728 |
| `m3_comp_primary_navigation_tab_active_focus_state_layer_opacity` | int | 0x7f07020a | 10731 |
| `m3_comp_primary_navigation_tab_active_hover_state_layer_opacity` | int | 0x7f07020b | 10734 |
| `m3_comp_primary_navigation_tab_active_indicator_height` | int | 0x7f07020c | 10737 |
| `m3_comp_primary_navigation_tab_active_pressed_state_layer_opacity` | int | 0x7f07020d | 10740 |
| `m3_comp_primary_navigation_tab_inactive_focus_state_layer_opacity` | int | 0x7f07020e | 10743 |
| `m3_comp_primary_navigation_tab_inactive_hover_state_layer_opacity` | int | 0x7f07020f | 10746 |
| `m3_comp_primary_navigation_tab_inactive_pressed_state_layer_opacity` | int | 0x7f070210 | 10749 |
| `m3_comp_primary_navigation_tab_with_icon_icon_size` | int | 0x7f070211 | 10752 |
| `m3_comp_radio_button_disabled_selected_icon_opacity` | int | 0x7f070212 | 10755 |
| `m3_comp_radio_button_disabled_unselected_icon_opacity` | int | 0x7f070213 | 10758 |
| `m3_comp_radio_button_selected_focus_state_layer_opacity` | int | 0x7f070214 | 10761 |
| `m3_comp_radio_button_selected_hover_state_layer_opacity` | int | 0x7f070215 | 10764 |
| `m3_comp_radio_button_selected_pressed_state_layer_opacity` | int | 0x7f070216 | 10767 |
| `m3_comp_radio_button_unselected_focus_state_layer_opacity` | int | 0x7f070217 | 10770 |
| `m3_comp_radio_button_unselected_hover_state_layer_opacity` | int | 0x7f070218 | 10773 |
| `m3_comp_radio_button_unselected_pressed_state_layer_opacity` | int | 0x7f070219 | 10776 |
| `m3_comp_search_bar_avatar_size` | int | 0x7f07021a | 10779 |
| `m3_comp_search_bar_container_elevation` | int | 0x7f07021b | 10782 |
| `m3_comp_search_bar_container_height` | int | 0x7f07021c | 10785 |
| `m3_comp_search_bar_hover_state_layer_opacity` | int | 0x7f07021d | 10788 |
| `m3_comp_search_bar_pressed_state_layer_opacity` | int | 0x7f07021e | 10791 |
| `m3_comp_search_view_container_elevation` | int | 0x7f07021f | 10794 |
| `m3_comp_search_view_docked_header_container_height` | int | 0x7f070220 | 10797 |
| `m3_comp_search_view_full_screen_header_container_height` | int | 0x7f070221 | 10800 |
| `m3_comp_secondary_navigation_tab_active_indicator_height` | int | 0x7f070222 | 10803 |
| `m3_comp_secondary_navigation_tab_focus_state_layer_opacity` | int | 0x7f070223 | 10806 |
| `m3_comp_secondary_navigation_tab_hover_state_layer_opacity` | int | 0x7f070224 | 10809 |
| `m3_comp_secondary_navigation_tab_pressed_state_layer_opacity` | int | 0x7f070225 | 10812 |
| `m3_comp_sheet_bottom_docked_drag_handle_height` | int | 0x7f070226 | 10815 |
| `m3_comp_sheet_bottom_docked_drag_handle_width` | int | 0x7f070227 | 10818 |
| `m3_comp_sheet_bottom_docked_modal_container_elevation` | int | 0x7f070228 | 10821 |
| `m3_comp_sheet_bottom_docked_standard_container_elevation` | int | 0x7f070229 | 10824 |
| `m3_comp_sheet_side_docked_container_width` | int | 0x7f07022a | 10827 |
| `m3_comp_sheet_side_docked_modal_container_elevation` | int | 0x7f07022b | 10830 |
| `m3_comp_sheet_side_docked_standard_container_elevation` | int | 0x7f07022c | 10833 |
| `m3_comp_slider_disabled_active_track_opacity` | int | 0x7f07022d | 10836 |
| `m3_comp_slider_disabled_handle_opacity` | int | 0x7f07022e | 10839 |
| `m3_comp_slider_disabled_inactive_track_opacity` | int | 0x7f07022f | 10842 |
| `m3_comp_slider_inactive_track_height` | int | 0x7f070230 | 10845 |
| `m3_comp_snackbar_container_elevation` | int | 0x7f070231 | 10848 |
| `m3_comp_suggestion_chip_container_height` | int | 0x7f070232 | 10851 |
| `m3_comp_suggestion_chip_elevated_container_elevation` | int | 0x7f070233 | 10854 |
| `m3_comp_suggestion_chip_flat_container_elevation` | int | 0x7f070234 | 10857 |
| `m3_comp_suggestion_chip_flat_outline_width` | int | 0x7f070235 | 10860 |
| `m3_comp_suggestion_chip_with_leading_icon_leading_icon_size` | int | 0x7f070236 | 10863 |
| `m3_comp_switch_disabled_selected_handle_opacity` | int | 0x7f070237 | 10866 |
| `m3_comp_switch_disabled_selected_icon_opacity` | int | 0x7f070238 | 10869 |
| `m3_comp_switch_disabled_track_opacity` | int | 0x7f070239 | 10872 |
| `m3_comp_switch_disabled_unselected_handle_opacity` | int | 0x7f07023a | 10875 |
| `m3_comp_switch_disabled_unselected_icon_opacity` | int | 0x7f07023b | 10878 |
| `m3_comp_switch_selected_focus_state_layer_opacity` | int | 0x7f07023c | 10881 |
| `m3_comp_switch_selected_hover_state_layer_opacity` | int | 0x7f07023d | 10884 |
| `m3_comp_switch_selected_pressed_state_layer_opacity` | int | 0x7f07023e | 10887 |
| `m3_comp_switch_track_height` | int | 0x7f07023f | 10890 |
| `m3_comp_switch_track_width` | int | 0x7f070240 | 10893 |
| `m3_comp_switch_unselected_focus_state_layer_opacity` | int | 0x7f070241 | 10896 |
| `m3_comp_switch_unselected_hover_state_layer_opacity` | int | 0x7f070242 | 10899 |
| `m3_comp_switch_unselected_pressed_state_layer_opacity` | int | 0x7f070243 | 10902 |
| `m3_comp_text_button_focus_state_layer_opacity` | int | 0x7f070244 | 10905 |
| `m3_comp_text_button_hover_state_layer_opacity` | int | 0x7f070245 | 10908 |
| `m3_comp_text_button_pressed_state_layer_opacity` | int | 0x7f070246 | 10911 |
| `m3_comp_time_input_time_input_field_focus_outline_width` | int | 0x7f070247 | 10914 |
| `m3_comp_time_picker_container_elevation` | int | 0x7f070248 | 10917 |
| `m3_comp_time_picker_period_selector_focus_state_layer_opacity` | int | 0x7f070249 | 10920 |
| `m3_comp_time_picker_period_selector_hover_state_layer_opacity` | int | 0x7f07024a | 10923 |
| `m3_comp_time_picker_period_selector_outline_width` | int | 0x7f07024b | 10926 |
| `m3_comp_time_picker_period_selector_pressed_state_layer_opacity` | int | 0x7f07024c | 10929 |
| `m3_comp_time_picker_time_selector_focus_state_layer_opacity` | int | 0x7f07024d | 10932 |
| `m3_comp_time_picker_time_selector_hover_state_layer_opacity` | int | 0x7f07024e | 10935 |
| `m3_comp_time_picker_time_selector_pressed_state_layer_opacity` | int | 0x7f07024f | 10938 |
| `m3_comp_top_app_bar_large_container_height` | int | 0x7f070250 | 10941 |
| `m3_comp_top_app_bar_medium_container_height` | int | 0x7f070251 | 10944 |
| `m3_comp_top_app_bar_small_container_elevation` | int | 0x7f070252 | 10947 |
| `m3_comp_top_app_bar_small_container_height` | int | 0x7f070253 | 10950 |
| `m3_comp_top_app_bar_small_on_scroll_container_elevation` | int | 0x7f070254 | 10953 |
| `m3_datepicker_elevation` | int | 0x7f070255 | 10956 |
| `m3_divider_heavy_thickness` | int | 0x7f070256 | 10959 |
| `m3_extended_fab_bottom_padding` | int | 0x7f070257 | 10962 |
| `m3_extended_fab_end_padding` | int | 0x7f070258 | 10965 |
| `m3_extended_fab_icon_padding` | int | 0x7f070259 | 10968 |
| `m3_extended_fab_min_height` | int | 0x7f07025a | 10971 |
| `m3_extended_fab_start_padding` | int | 0x7f07025b | 10974 |
| `m3_extended_fab_top_padding` | int | 0x7f07025c | 10977 |
| `m3_fab_border_width` | int | 0x7f07025d | 10980 |
| `m3_fab_corner_size` | int | 0x7f07025e | 10983 |
| `m3_fab_translation_z_hovered_focused` | int | 0x7f07025f | 10986 |
| `m3_fab_translation_z_pressed` | int | 0x7f070260 | 10989 |
| `m3_large_fab_max_image_size` | int | 0x7f070261 | 10992 |
| `m3_large_fab_size` | int | 0x7f070262 | 10995 |
| `m3_large_text_vertical_offset_adjustment` | int | 0x7f070263 | 10998 |
| `m3_menu_elevation` | int | 0x7f070264 | 11001 |
| `m3_navigation_drawer_layout_corner_size` | int | 0x7f070265 | 11004 |
| `m3_navigation_item_active_indicator_label_padding` | int | 0x7f070266 | 11007 |
| `m3_navigation_item_horizontal_padding` | int | 0x7f070267 | 11010 |
| `m3_navigation_item_icon_padding` | int | 0x7f070268 | 11013 |
| `m3_navigation_item_shape_inset_bottom` | int | 0x7f070269 | 11016 |
| `m3_navigation_item_shape_inset_end` | int | 0x7f07026a | 11019 |
| `m3_navigation_item_shape_inset_start` | int | 0x7f07026b | 11022 |
| `m3_navigation_item_shape_inset_top` | int | 0x7f07026c | 11025 |
| `m3_navigation_item_vertical_padding` | int | 0x7f07026d | 11028 |
| `m3_navigation_menu_divider_horizontal_padding` | int | 0x7f07026e | 11031 |
| `m3_navigation_menu_headline_horizontal_padding` | int | 0x7f07026f | 11034 |
| `m3_navigation_rail_default_width` | int | 0x7f070270 | 11037 |
| `m3_navigation_rail_elevation` | int | 0x7f070271 | 11040 |
| `m3_navigation_rail_icon_size` | int | 0x7f070272 | 11043 |
| `m3_navigation_rail_item_active_indicator_height` | int | 0x7f070273 | 11046 |
| `m3_navigation_rail_item_active_indicator_margin_horizontal` | int | 0x7f070274 | 11049 |
| `m3_navigation_rail_item_active_indicator_width` | int | 0x7f070275 | 11052 |
| `m3_navigation_rail_item_min_height` | int | 0x7f070276 | 11055 |
| `m3_navigation_rail_item_padding_bottom` | int | 0x7f070277 | 11058 |
| `m3_navigation_rail_item_padding_bottom_with_large_font` | int | 0x7f070278 | 11061 |
| `m3_navigation_rail_item_padding_top` | int | 0x7f070279 | 11064 |
| `m3_navigation_rail_item_padding_top_with_large_font` | int | 0x7f07027a | 11067 |
| `m3_ripple_default_alpha` | int | 0x7f07027b | 11070 |
| `m3_ripple_focused_alpha` | int | 0x7f07027c | 11073 |
| `m3_ripple_hovered_alpha` | int | 0x7f07027d | 11076 |
| `m3_ripple_pressed_alpha` | int | 0x7f07027e | 11079 |
| `m3_ripple_selectable_pressed_alpha` | int | 0x7f07027f | 11082 |
| `m3_searchbar_elevation` | int | 0x7f070280 | 11085 |
| `m3_searchbar_height` | int | 0x7f070281 | 11088 |
| `m3_searchbar_margin_horizontal` | int | 0x7f070282 | 11091 |
| `m3_searchbar_margin_vertical` | int | 0x7f070283 | 11094 |
| `m3_searchbar_outlined_stroke_width` | int | 0x7f070284 | 11097 |
| `m3_searchbar_padding_start` | int | 0x7f070285 | 11100 |
| `m3_searchbar_text_margin_start_no_navigation_icon` | int | 0x7f070286 | 11103 |
| `m3_searchbar_text_size` | int | 0x7f070287 | 11106 |
| `m3_searchview_divider_size` | int | 0x7f070288 | 11109 |
| `m3_searchview_elevation` | int | 0x7f070289 | 11112 |
| `m3_searchview_height` | int | 0x7f07028a | 11115 |
| `m3_side_sheet_margin_detached` | int | 0x7f07028b | 11118 |
| `m3_side_sheet_modal_elevation` | int | 0x7f07028c | 11121 |
| `m3_side_sheet_standard_elevation` | int | 0x7f07028d | 11124 |
| `m3_side_sheet_width` | int | 0x7f07028e | 11127 |
| `m3_simple_item_color_hovered_alpha` | int | 0x7f07028f | 11130 |
| `m3_simple_item_color_selected_alpha` | int | 0x7f070290 | 11133 |
| `m3_slider_inactive_track_height` | int | 0x7f070291 | 11136 |
| `m3_slider_thumb_elevation` | int | 0x7f070292 | 11139 |
| `m3_small_fab_max_image_size` | int | 0x7f070293 | 11142 |
| `m3_small_fab_size` | int | 0x7f070294 | 11145 |
| `m3_snackbar_action_text_color_alpha` | int | 0x7f070295 | 11148 |
| `m3_snackbar_margin` | int | 0x7f070296 | 11151 |
| `m3_sys_elevation_level0` | int | 0x7f070297 | 11154 |
| `m3_sys_elevation_level1` | int | 0x7f070298 | 11157 |
| `m3_sys_elevation_level2` | int | 0x7f070299 | 11160 |
| `m3_sys_elevation_level3` | int | 0x7f07029a | 11163 |
| `m3_sys_elevation_level4` | int | 0x7f07029b | 11166 |
| `m3_sys_elevation_level5` | int | 0x7f07029c | 11169 |
| `m3_sys_motion_easing_emphasized_accelerate_control_x1` | int | 0x7f07029d | 11172 |
| `m3_sys_motion_easing_emphasized_accelerate_control_x2` | int | 0x7f07029e | 11175 |
| `m3_sys_motion_easing_emphasized_accelerate_control_y1` | int | 0x7f07029f | 11178 |
| `m3_sys_motion_easing_emphasized_accelerate_control_y2` | int | 0x7f0702a0 | 11181 |
| `m3_sys_motion_easing_emphasized_decelerate_control_x1` | int | 0x7f0702a1 | 11184 |
| `m3_sys_motion_easing_emphasized_decelerate_control_x2` | int | 0x7f0702a2 | 11187 |
| `m3_sys_motion_easing_emphasized_decelerate_control_y1` | int | 0x7f0702a3 | 11190 |
| `m3_sys_motion_easing_emphasized_decelerate_control_y2` | int | 0x7f0702a4 | 11193 |
| `m3_sys_motion_easing_legacy_accelerate_control_x1` | int | 0x7f0702a5 | 11196 |
| `m3_sys_motion_easing_legacy_accelerate_control_x2` | int | 0x7f0702a6 | 11199 |
| `m3_sys_motion_easing_legacy_accelerate_control_y1` | int | 0x7f0702a7 | 11202 |
| `m3_sys_motion_easing_legacy_accelerate_control_y2` | int | 0x7f0702a8 | 11205 |
| `m3_sys_motion_easing_legacy_control_x1` | int | 0x7f0702a9 | 11208 |
| `m3_sys_motion_easing_legacy_control_x2` | int | 0x7f0702aa | 11211 |
| `m3_sys_motion_easing_legacy_control_y1` | int | 0x7f0702ab | 11214 |
| `m3_sys_motion_easing_legacy_control_y2` | int | 0x7f0702ac | 11217 |
| `m3_sys_motion_easing_legacy_decelerate_control_x1` | int | 0x7f0702ad | 11220 |
| `m3_sys_motion_easing_legacy_decelerate_control_x2` | int | 0x7f0702ae | 11223 |
| `m3_sys_motion_easing_legacy_decelerate_control_y1` | int | 0x7f0702af | 11226 |
| `m3_sys_motion_easing_legacy_decelerate_control_y2` | int | 0x7f0702b0 | 11229 |
| `m3_sys_motion_easing_linear_control_x1` | int | 0x7f0702b1 | 11232 |
| `m3_sys_motion_easing_linear_control_x2` | int | 0x7f0702b2 | 11235 |
| `m3_sys_motion_easing_linear_control_y1` | int | 0x7f0702b3 | 11238 |
| `m3_sys_motion_easing_linear_control_y2` | int | 0x7f0702b4 | 11241 |
| `m3_sys_motion_easing_standard_accelerate_control_x1` | int | 0x7f0702b5 | 11244 |
| `m3_sys_motion_easing_standard_accelerate_control_x2` | int | 0x7f0702b6 | 11247 |
| `m3_sys_motion_easing_standard_accelerate_control_y1` | int | 0x7f0702b7 | 11250 |
| `m3_sys_motion_easing_standard_accelerate_control_y2` | int | 0x7f0702b8 | 11253 |
| `m3_sys_motion_easing_standard_control_x1` | int | 0x7f0702b9 | 11256 |
| `m3_sys_motion_easing_standard_control_x2` | int | 0x7f0702ba | 11259 |
| `m3_sys_motion_easing_standard_control_y1` | int | 0x7f0702bb | 11262 |
| `m3_sys_motion_easing_standard_control_y2` | int | 0x7f0702bc | 11265 |
| `m3_sys_motion_easing_standard_decelerate_control_x1` | int | 0x7f0702bd | 11268 |
| `m3_sys_motion_easing_standard_decelerate_control_x2` | int | 0x7f0702be | 11271 |
| `m3_sys_motion_easing_standard_decelerate_control_y1` | int | 0x7f0702bf | 11274 |
| `m3_sys_motion_easing_standard_decelerate_control_y2` | int | 0x7f0702c0 | 11277 |
| `m3_sys_state_dragged_state_layer_opacity` | int | 0x7f0702c1 | 11280 |
| `m3_sys_state_focus_state_layer_opacity` | int | 0x7f0702c2 | 11283 |
| `m3_sys_state_hover_state_layer_opacity` | int | 0x7f0702c3 | 11286 |
| `m3_sys_state_pressed_state_layer_opacity` | int | 0x7f0702c4 | 11289 |
| `m3_timepicker_display_stroke_width` | int | 0x7f0702c5 | 11292 |
| `m3_timepicker_window_elevation` | int | 0x7f0702c6 | 11295 |
| `m3_toolbar_text_size_title` | int | 0x7f0702c7 | 11298 |
| `material_bottom_sheet_max_width` | int | 0x7f0702c8 | 11301 |
| `material_clock_display_height` | int | 0x7f0702c9 | 11304 |
| `material_clock_display_padding` | int | 0x7f0702ca | 11307 |
| `material_clock_display_width` | int | 0x7f0702cb | 11310 |
| `material_clock_face_margin_top` | int | 0x7f0702cc | 11313 |
| `material_clock_hand_center_dot_radius` | int | 0x7f0702cd | 11316 |
| `material_clock_hand_padding` | int | 0x7f0702ce | 11319 |
| `material_clock_hand_stroke_width` | int | 0x7f0702cf | 11322 |
| `material_clock_number_text_size` | int | 0x7f0702d0 | 11325 |
| `material_clock_period_toggle_height` | int | 0x7f0702d1 | 11328 |
| `material_clock_period_toggle_horizontal_gap` | int | 0x7f0702d2 | 11331 |
| `material_clock_period_toggle_vertical_gap` | int | 0x7f0702d3 | 11334 |
| `material_clock_period_toggle_width` | int | 0x7f0702d4 | 11337 |
| `material_clock_size` | int | 0x7f0702d5 | 11340 |
| `material_cursor_inset` | int | 0x7f0702d6 | 11343 |
| `material_cursor_width` | int | 0x7f0702d7 | 11346 |
| `material_divider_thickness` | int | 0x7f0702d8 | 11349 |
| `material_emphasis_disabled` | int | 0x7f0702d9 | 11352 |
| `material_emphasis_disabled_background` | int | 0x7f0702da | 11355 |
| `material_emphasis_high_type` | int | 0x7f0702db | 11358 |
| `material_emphasis_medium` | int | 0x7f0702dc | 11361 |
| `material_filled_edittext_font_1_3_padding_bottom` | int | 0x7f0702dd | 11364 |
| `material_filled_edittext_font_1_3_padding_top` | int | 0x7f0702de | 11367 |
| `material_filled_edittext_font_2_0_padding_bottom` | int | 0x7f0702df | 11370 |
| `material_filled_edittext_font_2_0_padding_top` | int | 0x7f0702e0 | 11373 |
| `material_font_1_3_box_collapsed_padding_top` | int | 0x7f0702e1 | 11376 |
| `material_font_2_0_box_collapsed_padding_top` | int | 0x7f0702e2 | 11379 |
| `material_helper_text_default_padding_top` | int | 0x7f0702e3 | 11382 |
| `material_helper_text_font_1_3_padding_horizontal` | int | 0x7f0702e4 | 11385 |
| `material_helper_text_font_1_3_padding_top` | int | 0x7f0702e5 | 11388 |
| `material_input_text_to_prefix_suffix_padding` | int | 0x7f0702e6 | 11391 |
| `material_textinput_default_width` | int | 0x7f0702e7 | 11394 |
| `material_textinput_max_width` | int | 0x7f0702e8 | 11397 |
| `material_textinput_min_width` | int | 0x7f0702e9 | 11400 |
| `material_time_picker_minimum_screen_height` | int | 0x7f0702ea | 11403 |
| `material_time_picker_minimum_screen_width` | int | 0x7f0702eb | 11406 |
| `material_timepicker_dialog_buttons_margin_top` | int | 0x7f0702ec | 11409 |
| `mtrl_alert_dialog_background_inset_bottom` | int | 0x7f0702ee | 11412 |
| `mtrl_alert_dialog_background_inset_end` | int | 0x7f0702ef | 11415 |
| `mtrl_alert_dialog_background_inset_start` | int | 0x7f0702f0 | 11418 |
| `mtrl_alert_dialog_background_inset_top` | int | 0x7f0702f1 | 11421 |
| `mtrl_alert_dialog_picker_background_inset` | int | 0x7f0702f2 | 11424 |
| `mtrl_badge_horizontal_edge_offset` | int | 0x7f0702f3 | 11427 |
| `mtrl_badge_long_text_horizontal_padding` | int | 0x7f0702f4 | 11430 |
| `mtrl_badge_size` | int | 0x7f0702f5 | 11433 |
| `mtrl_badge_text_horizontal_edge_offset` | int | 0x7f0702f6 | 11436 |
| `mtrl_badge_text_size` | int | 0x7f0702f7 | 11439 |
| `mtrl_badge_toolbar_action_menu_item_horizontal_offset` | int | 0x7f0702f8 | 11442 |
| `mtrl_badge_toolbar_action_menu_item_vertical_offset` | int | 0x7f0702f9 | 11445 |
| `mtrl_badge_with_text_size` | int | 0x7f0702fa | 11448 |
| `mtrl_bottomappbar_fab_bottom_margin` | int | 0x7f0702fc | 11454 |
| `mtrl_bottomappbar_fab_cradle_margin` | int | 0x7f0702fd | 11457 |
| `mtrl_bottomappbar_fab_cradle_rounded_corner_radius` | int | 0x7f0702fe | 11460 |
| `mtrl_bottomappbar_fab_cradle_vertical_offset` | int | 0x7f0702ff | 11463 |
| `mtrl_bottomappbar_fabOffsetEndMode` | int | 0x7f0702fb | 11451 |
| `mtrl_bottomappbar_height` | int | 0x7f070300 | 11466 |
| `mtrl_btn_corner_radius` | int | 0x7f070301 | 11469 |
| `mtrl_btn_dialog_btn_min_width` | int | 0x7f070302 | 11472 |
| `mtrl_btn_disabled_elevation` | int | 0x7f070303 | 11475 |
| `mtrl_btn_disabled_z` | int | 0x7f070304 | 11478 |
| `mtrl_btn_elevation` | int | 0x7f070305 | 11481 |
| `mtrl_btn_focused_z` | int | 0x7f070306 | 11484 |
| `mtrl_btn_hovered_z` | int | 0x7f070307 | 11487 |
| `mtrl_btn_icon_btn_padding_left` | int | 0x7f070308 | 11490 |
| `mtrl_btn_icon_padding` | int | 0x7f070309 | 11493 |
| `mtrl_btn_inset` | int | 0x7f07030a | 11496 |
| `mtrl_btn_letter_spacing` | int | 0x7f07030b | 11499 |
| `mtrl_btn_max_width` | int | 0x7f07030c | 11502 |
| `mtrl_btn_padding_bottom` | int | 0x7f07030d | 11505 |
| `mtrl_btn_padding_left` | int | 0x7f07030e | 11508 |
| `mtrl_btn_padding_right` | int | 0x7f07030f | 11511 |
| `mtrl_btn_padding_top` | int | 0x7f070310 | 11514 |
| `mtrl_btn_pressed_z` | int | 0x7f070311 | 11517 |
| `mtrl_btn_snackbar_margin_horizontal` | int | 0x7f070312 | 11520 |
| `mtrl_btn_stroke_size` | int | 0x7f070313 | 11523 |
| `mtrl_btn_text_btn_icon_padding` | int | 0x7f070314 | 11526 |
| `mtrl_btn_text_btn_padding_left` | int | 0x7f070315 | 11529 |
| `mtrl_btn_text_btn_padding_right` | int | 0x7f070316 | 11532 |
| `mtrl_btn_text_size` | int | 0x7f070317 | 11535 |
| `mtrl_btn_z` | int | 0x7f070318 | 11538 |
| `mtrl_calendar_action_confirm_button_min_width` | int | 0x7f070319 | 11541 |
| `mtrl_calendar_action_height` | int | 0x7f07031a | 11544 |
| `mtrl_calendar_action_padding` | int | 0x7f07031b | 11547 |
| `mtrl_calendar_bottom_padding` | int | 0x7f07031c | 11550 |
| `mtrl_calendar_content_padding` | int | 0x7f07031d | 11553 |
| `mtrl_calendar_day_corner` | int | 0x7f07031e | 11556 |
| `mtrl_calendar_day_height` | int | 0x7f07031f | 11559 |
| `mtrl_calendar_day_horizontal_padding` | int | 0x7f070320 | 11562 |
| `mtrl_calendar_day_today_stroke` | int | 0x7f070321 | 11565 |
| `mtrl_calendar_day_vertical_padding` | int | 0x7f070322 | 11568 |
| `mtrl_calendar_day_width` | int | 0x7f070323 | 11571 |
| `mtrl_calendar_days_of_week_height` | int | 0x7f070324 | 11574 |
| `mtrl_calendar_dialog_background_inset` | int | 0x7f070325 | 11577 |
| `mtrl_calendar_header_content_padding` | int | 0x7f070326 | 11580 |
| `mtrl_calendar_header_content_padding_fullscreen` | int | 0x7f070327 | 11583 |
| `mtrl_calendar_header_divider_thickness` | int | 0x7f070328 | 11586 |
| `mtrl_calendar_header_height` | int | 0x7f070329 | 11589 |
| `mtrl_calendar_header_height_fullscreen` | int | 0x7f07032a | 11592 |
| `mtrl_calendar_header_selection_line_height` | int | 0x7f07032b | 11595 |
| `mtrl_calendar_header_text_padding` | int | 0x7f07032c | 11598 |
| `mtrl_calendar_header_toggle_margin_bottom` | int | 0x7f07032d | 11601 |
| `mtrl_calendar_header_toggle_margin_top` | int | 0x7f07032e | 11604 |
| `mtrl_calendar_landscape_header_width` | int | 0x7f07032f | 11607 |
| `mtrl_calendar_maximum_default_fullscreen_minor_axis` | int | 0x7f070330 | 11610 |
| `mtrl_calendar_month_horizontal_padding` | int | 0x7f070331 | 11613 |
| `mtrl_calendar_month_vertical_padding` | int | 0x7f070332 | 11616 |
| `mtrl_calendar_navigation_bottom_padding` | int | 0x7f070333 | 11619 |
| `mtrl_calendar_navigation_height` | int | 0x7f070334 | 11622 |
| `mtrl_calendar_navigation_top_padding` | int | 0x7f070335 | 11625 |
| `mtrl_calendar_pre_l_text_clip_padding` | int | 0x7f070336 | 11628 |
| `mtrl_calendar_selection_baseline_to_top_fullscreen` | int | 0x7f070337 | 11631 |
| `mtrl_calendar_selection_text_baseline_to_bottom` | int | 0x7f070338 | 11634 |
| `mtrl_calendar_selection_text_baseline_to_bottom_fullscreen` | int | 0x7f070339 | 11637 |
| `mtrl_calendar_selection_text_baseline_to_top` | int | 0x7f07033a | 11640 |
| `mtrl_calendar_text_input_padding_top` | int | 0x7f07033b | 11643 |
| `mtrl_calendar_title_baseline_to_top` | int | 0x7f07033c | 11646 |
| `mtrl_calendar_title_baseline_to_top_fullscreen` | int | 0x7f07033d | 11649 |
| `mtrl_calendar_year_corner` | int | 0x7f07033e | 11652 |
| `mtrl_calendar_year_height` | int | 0x7f07033f | 11655 |
| `mtrl_calendar_year_horizontal_padding` | int | 0x7f070340 | 11658 |
| `mtrl_calendar_year_vertical_padding` | int | 0x7f070341 | 11661 |
| `mtrl_calendar_year_width` | int | 0x7f070342 | 11664 |
| `mtrl_card_checked_icon_margin` | int | 0x7f070343 | 11667 |
| `mtrl_card_checked_icon_size` | int | 0x7f070344 | 11670 |
| `mtrl_card_corner_radius` | int | 0x7f070345 | 11673 |
| `mtrl_card_dragged_z` | int | 0x7f070346 | 11676 |
| `mtrl_card_elevation` | int | 0x7f070347 | 11679 |
| `mtrl_card_spacing` | int | 0x7f070348 | 11682 |
| `mtrl_chip_pressed_translation_z` | int | 0x7f070349 | 11685 |
| `mtrl_chip_text_size` | int | 0x7f07034a | 11688 |
| `mtrl_exposed_dropdown_menu_popup_elevation` | int | 0x7f07034b | 11691 |
| `mtrl_exposed_dropdown_menu_popup_vertical_offset` | int | 0x7f07034c | 11694 |
| `mtrl_exposed_dropdown_menu_popup_vertical_padding` | int | 0x7f07034d | 11697 |
| `mtrl_extended_fab_bottom_padding` | int | 0x7f07034e | 11700 |
| `mtrl_extended_fab_disabled_elevation` | int | 0x7f07034f | 11703 |
| `mtrl_extended_fab_disabled_translation_z` | int | 0x7f070350 | 11706 |
| `mtrl_extended_fab_elevation` | int | 0x7f070351 | 11709 |
| `mtrl_extended_fab_end_padding` | int | 0x7f070352 | 11712 |
| `mtrl_extended_fab_end_padding_icon` | int | 0x7f070353 | 11715 |
| `mtrl_extended_fab_icon_size` | int | 0x7f070354 | 11718 |
| `mtrl_extended_fab_icon_text_spacing` | int | 0x7f070355 | 11721 |
| `mtrl_extended_fab_min_height` | int | 0x7f070356 | 11724 |
| `mtrl_extended_fab_min_width` | int | 0x7f070357 | 11727 |
| `mtrl_extended_fab_start_padding` | int | 0x7f070358 | 11730 |
| `mtrl_extended_fab_start_padding_icon` | int | 0x7f070359 | 11733 |
| `mtrl_extended_fab_top_padding` | int | 0x7f07035a | 11736 |
| `mtrl_extended_fab_translation_z_base` | int | 0x7f07035b | 11739 |
| `mtrl_extended_fab_translation_z_hovered_focused` | int | 0x7f07035c | 11742 |
| `mtrl_extended_fab_translation_z_pressed` | int | 0x7f07035d | 11745 |
| `mtrl_fab_elevation` | int | 0x7f07035e | 11748 |
| `mtrl_fab_min_touch_target` | int | 0x7f07035f | 11751 |
| `mtrl_fab_translation_z_hovered_focused` | int | 0x7f070360 | 11754 |
| `mtrl_fab_translation_z_pressed` | int | 0x7f070361 | 11757 |
| `mtrl_high_ripple_default_alpha` | int | 0x7f070362 | 11760 |
| `mtrl_high_ripple_focused_alpha` | int | 0x7f070363 | 11763 |
| `mtrl_high_ripple_hovered_alpha` | int | 0x7f070364 | 11766 |
| `mtrl_high_ripple_pressed_alpha` | int | 0x7f070365 | 11769 |
| `mtrl_low_ripple_default_alpha` | int | 0x7f070366 | 11772 |
| `mtrl_low_ripple_focused_alpha` | int | 0x7f070367 | 11775 |
| `mtrl_low_ripple_hovered_alpha` | int | 0x7f070368 | 11778 |
| `mtrl_low_ripple_pressed_alpha` | int | 0x7f070369 | 11781 |
| `mtrl_min_touch_target_size` | int | 0x7f07036a | 11784 |
| `mtrl_navigation_bar_item_default_icon_size` | int | 0x7f07036b | 11787 |
| `mtrl_navigation_bar_item_default_margin` | int | 0x7f07036c | 11790 |
| `mtrl_navigation_elevation` | int | 0x7f07036d | 11793 |
| `mtrl_navigation_item_horizontal_padding` | int | 0x7f07036e | 11796 |
| `mtrl_navigation_item_icon_padding` | int | 0x7f07036f | 11799 |
| `mtrl_navigation_item_icon_size` | int | 0x7f070370 | 11802 |
| `mtrl_navigation_item_shape_horizontal_margin` | int | 0x7f070371 | 11805 |
| `mtrl_navigation_item_shape_vertical_margin` | int | 0x7f070372 | 11808 |
| `mtrl_navigation_rail_active_text_size` | int | 0x7f070373 | 11811 |
| `mtrl_navigation_rail_compact_width` | int | 0x7f070374 | 11814 |
| `mtrl_navigation_rail_default_width` | int | 0x7f070375 | 11817 |
| `mtrl_navigation_rail_elevation` | int | 0x7f070376 | 11820 |
| `mtrl_navigation_rail_icon_margin` | int | 0x7f070377 | 11823 |
| `mtrl_navigation_rail_icon_size` | int | 0x7f070378 | 11826 |
| `mtrl_navigation_rail_margin` | int | 0x7f070379 | 11829 |
| `mtrl_navigation_rail_text_bottom_margin` | int | 0x7f07037a | 11832 |
| `mtrl_navigation_rail_text_size` | int | 0x7f07037b | 11835 |
| `mtrl_progress_circular_inset` | int | 0x7f07037c | 11838 |
| `mtrl_progress_circular_inset_extra_small` | int | 0x7f07037d | 11841 |
| `mtrl_progress_circular_inset_medium` | int | 0x7f07037e | 11844 |
| `mtrl_progress_circular_inset_small` | int | 0x7f07037f | 11847 |
| `mtrl_progress_circular_radius` | int | 0x7f070380 | 11850 |
| `mtrl_progress_circular_size` | int | 0x7f070381 | 11853 |
| `mtrl_progress_circular_size_extra_small` | int | 0x7f070382 | 11856 |
| `mtrl_progress_circular_size_medium` | int | 0x7f070383 | 11859 |
| `mtrl_progress_circular_size_small` | int | 0x7f070384 | 11862 |
| `mtrl_progress_circular_track_thickness_extra_small` | int | 0x7f070385 | 11865 |
| `mtrl_progress_circular_track_thickness_medium` | int | 0x7f070386 | 11868 |
| `mtrl_progress_circular_track_thickness_small` | int | 0x7f070387 | 11871 |
| `mtrl_progress_indicator_full_rounded_corner_radius` | int | 0x7f070388 | 11874 |
| `mtrl_progress_track_thickness` | int | 0x7f070389 | 11877 |
| `mtrl_shape_corner_size_large_component` | int | 0x7f07038a | 11880 |
| `mtrl_shape_corner_size_medium_component` | int | 0x7f07038b | 11883 |
| `mtrl_shape_corner_size_small_component` | int | 0x7f07038c | 11886 |
| `mtrl_slider_halo_radius` | int | 0x7f07038d | 11889 |
| `mtrl_slider_label_padding` | int | 0x7f07038e | 11892 |
| `mtrl_slider_label_radius` | int | 0x7f07038f | 11895 |
| `mtrl_slider_label_square_side` | int | 0x7f070390 | 11898 |
| `mtrl_slider_thumb_elevation` | int | 0x7f070391 | 11901 |
| `mtrl_slider_thumb_radius` | int | 0x7f070392 | 11904 |
| `mtrl_slider_tick_radius` | int | 0x7f070393 | 11907 |
| `mtrl_slider_track_height` | int | 0x7f070394 | 11910 |
| `mtrl_slider_track_side_padding` | int | 0x7f070395 | 11913 |
| `mtrl_slider_widget_height` | int | 0x7f070396 | 11916 |
| `mtrl_snackbar_action_text_color_alpha` | int | 0x7f070397 | 11919 |
| `mtrl_snackbar_background_corner_radius` | int | 0x7f070398 | 11922 |
| `mtrl_snackbar_background_overlay_color_alpha` | int | 0x7f070399 | 11925 |
| `mtrl_snackbar_margin` | int | 0x7f07039a | 11928 |
| `mtrl_snackbar_message_margin_horizontal` | int | 0x7f07039b | 11931 |
| `mtrl_snackbar_padding_horizontal` | int | 0x7f07039c | 11934 |
| `mtrl_switch_text_padding` | int | 0x7f07039d | 11937 |
| `mtrl_switch_thumb_elevation` | int | 0x7f07039e | 11940 |
| `mtrl_switch_thumb_icon_size` | int | 0x7f07039f | 11943 |
| `mtrl_switch_thumb_size` | int | 0x7f0703a0 | 11946 |
| `mtrl_switch_track_height` | int | 0x7f0703a1 | 11949 |
| `mtrl_switch_track_width` | int | 0x7f0703a2 | 11952 |
| `mtrl_textinput_box_corner_radius_medium` | int | 0x7f0703a3 | 11955 |
| `mtrl_textinput_box_corner_radius_small` | int | 0x7f0703a4 | 11958 |
| `mtrl_textinput_box_label_cutout_padding` | int | 0x7f0703a5 | 11961 |
| `mtrl_textinput_box_stroke_width_default` | int | 0x7f0703a6 | 11964 |
| `mtrl_textinput_box_stroke_width_focused` | int | 0x7f0703a7 | 11967 |
| `mtrl_textinput_counter_margin_start` | int | 0x7f0703a8 | 11970 |
| `mtrl_textinput_end_icon_margin_start` | int | 0x7f0703a9 | 11973 |
| `mtrl_textinput_outline_box_expanded_padding` | int | 0x7f0703aa | 11976 |
| `mtrl_textinput_start_icon_margin_end` | int | 0x7f0703ab | 11979 |
| `mtrl_toolbar_default_height` | int | 0x7f0703ac | 11982 |
| `mtrl_tooltip_arrowSize` | int | 0x7f0703ad | 11985 |
| `mtrl_tooltip_cornerSize` | int | 0x7f0703ae | 11988 |
| `mtrl_tooltip_minHeight` | int | 0x7f0703af | 11991 |
| `mtrl_tooltip_minWidth` | int | 0x7f0703b0 | 11994 |
| `mtrl_tooltip_padding` | int | 0x7f0703b1 | 11997 |
| `mtrl_transition_shared_axis_slide_distance` | int | 0x7f0703b2 | 12000 |
| `notification_action_icon_size` | int | 0x7f0703b4 | 12003 |
| `notification_action_text_size` | int | 0x7f0703b5 | 12006 |
| `notification_big_circle_margin` | int | 0x7f0703b6 | 12009 |
| `notification_content_margin_start` | int | 0x7f0703b7 | 12012 |
| `notification_large_icon_height` | int | 0x7f0703b8 | 12015 |
| `notification_large_icon_width` | int | 0x7f0703b9 | 12018 |
| `notification_main_column_padding_top` | int | 0x7f0703ba | 12021 |
| `notification_media_narrow_margin` | int | 0x7f0703bb | 12024 |
| `notification_right_icon_size` | int | 0x7f0703bc | 12027 |
| `notification_right_side_padding_top` | int | 0x7f0703bd | 12030 |
| `notification_small_icon_background_padding` | int | 0x7f0703be | 12033 |
| `notification_small_icon_size_as_large` | int | 0x7f0703bf | 12036 |
| `notification_subtext_size` | int | 0x7f0703c0 | 12039 |
| `notification_top_pad` | int | 0x7f0703c1 | 12042 |
| `notification_top_pad_large_text` | int | 0x7f0703c2 | 12045 |
| `padding_icon` | int | 0x7f0703c3 | 12048 |
| `pickerview_textsize` | int | 0x7f0703c4 | 12051 |
| `pickerview_topbar_btn_textsize` | int | 0x7f0703c5 | 12054 |
| `pickerview_topbar_height` | int | 0x7f0703c6 | 12057 |
| `pickerview_topbar_padding` | int | 0x7f0703c7 | 12060 |
| `pickerview_topbar_title_textsize` | int | 0x7f0703c8 | 12063 |
| `seek_bar_image` | int | 0x7f0703cd | 12066 |
| `sliding_pane_detail_pane_width` | int | 0x7f0703ce | 12069 |
| `sp_14` | int | 0x7f0703e3 | 12132 |
| `sp10` | int | 0x7f0703cf | 12072 |
| `sp11` | int | 0x7f0703d0 | 12075 |
| `sp12` | int | 0x7f0703d1 | 12078 |
| `sp13` | int | 0x7f0703d2 | 12081 |
| `sp14` | int | 0x7f0703d3 | 12084 |
| `sp15` | int | 0x7f0703d4 | 12087 |
| `sp16` | int | 0x7f0703d5 | 12090 |
| `sp17` | int | 0x7f0703d6 | 12093 |
| `sp18` | int | 0x7f0703d7 | 12096 |
| `sp20` | int | 0x7f0703d8 | 12099 |
| `sp22` | int | 0x7f0703d9 | 12102 |
| `sp24` | int | 0x7f0703da | 12105 |
| `sp26` | int | 0x7f0703db | 12108 |
| `sp28` | int | 0x7f0703dc | 12111 |
| `sp30` | int | 0x7f0703dd | 12114 |
| `sp6` | int | 0x7f0703de | 12117 |
| `sp7` | int | 0x7f0703df | 12120 |
| `sp8` | int | 0x7f0703e0 | 12123 |
| `sp80` | int | 0x7f0703e1 | 12126 |
| `sp9` | int | 0x7f0703e2 | 12129 |
| `splashscreen_icon_mask_size_no_background` | int | 0x7f0703e4 | 12135 |
| `splashscreen_icon_mask_size_with_background` | int | 0x7f0703e5 | 12138 |
| `splashscreen_icon_mask_stroke_no_background` | int | 0x7f0703e6 | 12141 |
| `splashscreen_icon_mask_stroke_with_background` | int | 0x7f0703e7 | 12144 |
| `splashscreen_icon_size` | int | 0x7f0703e8 | 12147 |
| `splashscreen_icon_size_no_background` | int | 0x7f0703e9 | 12150 |
| `splashscreen_icon_size_with_background` | int | 0x7f0703ea | 12153 |
| `tooltip_corner_radius` | int | 0x7f0703eb | 12156 |
| `tooltip_horizontal_padding` | int | 0x7f0703ec | 12159 |
| `tooltip_margin` | int | 0x7f0703ed | 12162 |
| `tooltip_precise_anchor_extra_offset` | int | 0x7f0703ee | 12165 |
| `tooltip_precise_anchor_threshold` | int | 0x7f0703ef | 12168 |
| `tooltip_vertical_padding` | int | 0x7f0703f0 | 12171 |
| `tooltip_y_offset_non_touch` | int | 0x7f0703f1 | 12174 |
| `tooltip_y_offset_touch` | int | 0x7f0703f2 | 12177 |
| `ucrop_default_crop_frame_stoke_width` | int | 0x7f0703f3 | 12180 |
| `ucrop_default_crop_grid_stoke_width` | int | 0x7f0703f4 | 12183 |
| `ucrop_default_crop_logo_size` | int | 0x7f0703f5 | 12186 |
| `ucrop_default_crop_rect_corner_touch_area_line_length` | int | 0x7f0703f6 | 12189 |
| `ucrop_default_crop_rect_corner_touch_threshold` | int | 0x7f0703f7 | 12192 |
| `ucrop_default_crop_rect_min_size` | int | 0x7f0703f8 | 12195 |
| `ucrop_height_crop_aspect_ratio_text` | int | 0x7f0703f9 | 12198 |
| `ucrop_height_divider_shadow` | int | 0x7f0703fa | 12201 |
| `ucrop_height_horizontal_wheel_progress_line` | int | 0x7f0703fb | 12204 |
| `ucrop_height_wrapper_controls` | int | 0x7f0703fc | 12207 |
| `ucrop_height_wrapper_states` | int | 0x7f0703fd | 12210 |
| `ucrop_margin_horizontal_wheel_progress_line` | int | 0x7f0703fe | 12213 |
| `ucrop_margin_top_controls_text` | int | 0x7f0703ff | 12216 |
| `ucrop_margin_top_widget_text` | int | 0x7f070400 | 12219 |
| `ucrop_padding_crop_frame` | int | 0x7f070401 | 12222 |
| `ucrop_progress_size` | int | 0x7f070402 | 12225 |
| `ucrop_size_dot_scale_text_view` | int | 0x7f070403 | 12228 |
| `ucrop_size_wrapper_rotate_button` | int | 0x7f070404 | 12231 |
| `ucrop_text_size_controls_text` | int | 0x7f070405 | 12234 |
| `ucrop_text_size_widget_text` | int | 0x7f070406 | 12237 |
| `ucrop_width_horizontal_wheel_progress_line` | int | 0x7f070407 | 12240 |
| `ucrop_width_middle_wheel_progress_line` | int | 0x7f070408 | 12243 |
| `video_progress_dialog_margin_top` | int | 0x7f07040d | 12246 |
| `video_volume_dialog_margin_left` | int | 0x7f07040e | 12249 |

### `com.gku.xtugo.R$drawable`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `_avd_hide_password__0_res_0x7f080000` | int | 0x7f080000 | 12973 |
| `_avd_hide_password__1_res_0x7f080001` | int | 0x7f080001 | 12976 |
| `_avd_hide_password__2_res_0x7f080002` | int | 0x7f080002 | 12979 |
| `_avd_show_password__0_res_0x7f080003` | int | 0x7f080003 | 12982 |
| `_avd_show_password__1_res_0x7f080004` | int | 0x7f080004 | 12985 |
| `_avd_show_password__2_res_0x7f080005` | int | 0x7f080005 | 12988 |
| `_ic_launcher_foreground__0_res_0x7f080006` | int | 0x7f080006 | 12991 |
| `_m3_avd_hide_password__0_res_0x7f080007` | int | 0x7f080007 | 12994 |
| `_m3_avd_hide_password__1_res_0x7f080008` | int | 0x7f080008 | 12997 |
| `_m3_avd_hide_password__2_res_0x7f080009` | int | 0x7f080009 | 13000 |
| `_m3_avd_show_password__0_res_0x7f08000a` | int | 0x7f08000a | 13003 |
| `_m3_avd_show_password__1_res_0x7f08000b` | int | 0x7f08000b | 13006 |
| `_m3_avd_show_password__2_res_0x7f08000c` | int | 0x7f08000c | 13009 |
| `_mtrl_checkbox_button_checked_unchecked__0_res_0x7f08000d` | int | 0x7f08000d | 13012 |
| `_mtrl_checkbox_button_checked_unchecked__1_res_0x7f08000e` | int | 0x7f08000e | 13015 |
| `_mtrl_checkbox_button_checked_unchecked__2_res_0x7f08000f` | int | 0x7f08000f | 13018 |
| `_mtrl_checkbox_button_icon_checked_indeterminate__0_res_0x7f080010` | int | 0x7f080010 | 13021 |
| `_mtrl_checkbox_button_icon_checked_unchecked__0_res_0x7f080011` | int | 0x7f080011 | 13024 |
| `_mtrl_checkbox_button_icon_checked_unchecked__1_res_0x7f080012` | int | 0x7f080012 | 13027 |
| `_mtrl_checkbox_button_icon_checked_unchecked__2_res_0x7f080013` | int | 0x7f080013 | 13030 |
| `_mtrl_checkbox_button_icon_indeterminate_checked__0_res_0x7f080014` | int | 0x7f080014 | 13033 |
| `_mtrl_checkbox_button_icon_indeterminate_unchecked__0_res_0x7f080015` | int | 0x7f080015 | 13036 |
| `_mtrl_checkbox_button_icon_indeterminate_unchecked__1_res_0x7f080016` | int | 0x7f080016 | 13039 |
| `_mtrl_checkbox_button_icon_indeterminate_unchecked__2_res_0x7f080017` | int | 0x7f080017 | 13042 |
| `_mtrl_checkbox_button_icon_unchecked_checked__0_res_0x7f080018` | int | 0x7f080018 | 13045 |
| `_mtrl_checkbox_button_icon_unchecked_checked__1_res_0x7f080019` | int | 0x7f080019 | 13048 |
| `_mtrl_checkbox_button_icon_unchecked_checked__2_res_0x7f08001a` | int | 0x7f08001a | 13051 |
| `_mtrl_checkbox_button_icon_unchecked_indeterminate__0_res_0x7f08001b` | int | 0x7f08001b | 13054 |
| `_mtrl_checkbox_button_icon_unchecked_indeterminate__1_res_0x7f08001c` | int | 0x7f08001c | 13057 |
| `_mtrl_checkbox_button_icon_unchecked_indeterminate__2_res_0x7f08001d` | int | 0x7f08001d | 13060 |
| `_mtrl_checkbox_button_unchecked_checked__0_res_0x7f08001e` | int | 0x7f08001e | 13063 |
| `_mtrl_checkbox_button_unchecked_checked__1_res_0x7f08001f` | int | 0x7f08001f | 13066 |
| `_mtrl_checkbox_button_unchecked_checked__2_res_0x7f080020` | int | 0x7f080020 | 13069 |
| `_mtrl_switch_thumb_checked_pressed__0_res_0x7f080021` | int | 0x7f080021 | 13072 |
| `_mtrl_switch_thumb_checked_unchecked__0_res_0x7f080022` | int | 0x7f080022 | 13075 |
| `_mtrl_switch_thumb_checked_unchecked__1_res_0x7f080023` | int | 0x7f080023 | 13078 |
| `_mtrl_switch_thumb_pressed_checked__0_res_0x7f080024` | int | 0x7f080024 | 13081 |
| `_mtrl_switch_thumb_pressed_unchecked__0_res_0x7f080025` | int | 0x7f080025 | 13084 |
| `_mtrl_switch_thumb_unchecked_checked__0_res_0x7f080026` | int | 0x7f080026 | 13087 |
| `_mtrl_switch_thumb_unchecked_checked__1_res_0x7f080027` | int | 0x7f080027 | 13090 |
| `_mtrl_switch_thumb_unchecked_pressed__0_res_0x7f080028` | int | 0x7f080028 | 13093 |
| `abc_ab_share_pack_mtrl_alpha` | int | 0x7f080029 | 13096 |
| `abc_action_bar_item_background_material` | int | 0x7f08002a | 13099 |
| `abc_btn_borderless_material` | int | 0x7f08002b | 13102 |
| `abc_btn_check_material` | int | 0x7f08002c | 13105 |
| `abc_btn_check_material_anim` | int | 0x7f08002d | 13108 |
| `abc_btn_check_to_on_mtrl_000` | int | 0x7f08002e | 13111 |
| `abc_btn_check_to_on_mtrl_015` | int | 0x7f08002f | 13114 |
| `abc_btn_colored_material` | int | 0x7f080030 | 13117 |
| `abc_btn_default_mtrl_shape` | int | 0x7f080031 | 13120 |
| `abc_btn_radio_material` | int | 0x7f080032 | 13123 |
| `abc_btn_radio_material_anim` | int | 0x7f080033 | 13126 |
| `abc_btn_radio_to_on_mtrl_000` | int | 0x7f080034 | 13129 |
| `abc_btn_radio_to_on_mtrl_015` | int | 0x7f080035 | 13132 |
| `abc_btn_switch_to_on_mtrl_00001` | int | 0x7f080036 | 13135 |
| `abc_btn_switch_to_on_mtrl_00012` | int | 0x7f080037 | 13138 |
| `abc_cab_background_internal_bg` | int | 0x7f080038 | 13141 |
| `abc_cab_background_top_material` | int | 0x7f080039 | 13144 |
| `abc_cab_background_top_mtrl_alpha` | int | 0x7f08003a | 13147 |
| `abc_control_background_material` | int | 0x7f08003b | 13150 |
| `abc_dialog_material_background` | int | 0x7f08003c | 13153 |
| `abc_edit_text_material` | int | 0x7f08003d | 13156 |
| `abc_ic_ab_back_material` | int | 0x7f08003e | 13159 |
| `abc_ic_arrow_drop_right_black_24dp` | int | 0x7f08003f | 13162 |
| `abc_ic_clear_material` | int | 0x7f080040 | 13165 |
| `abc_ic_commit_search_api_mtrl_alpha` | int | 0x7f080041 | 13168 |
| `abc_ic_go_search_api_material` | int | 0x7f080042 | 13171 |
| `abc_ic_menu_copy_mtrl_am_alpha` | int | 0x7f080043 | 13174 |
| `abc_ic_menu_cut_mtrl_alpha` | int | 0x7f080044 | 13177 |
| `abc_ic_menu_overflow_material` | int | 0x7f080045 | 13180 |
| `abc_ic_menu_paste_mtrl_am_alpha` | int | 0x7f080046 | 13183 |
| `abc_ic_menu_selectall_mtrl_alpha` | int | 0x7f080047 | 13186 |
| `abc_ic_menu_share_mtrl_alpha` | int | 0x7f080048 | 13189 |
| `abc_ic_search_api_material` | int | 0x7f080049 | 13192 |
| `abc_ic_voice_search_api_material` | int | 0x7f08004a | 13195 |
| `abc_item_background_holo_dark` | int | 0x7f08004b | 13198 |
| `abc_item_background_holo_light` | int | 0x7f08004c | 13201 |
| `abc_list_divider_material` | int | 0x7f08004d | 13204 |
| `abc_list_divider_mtrl_alpha` | int | 0x7f08004e | 13207 |
| `abc_list_focused_holo` | int | 0x7f08004f | 13210 |
| `abc_list_longpressed_holo` | int | 0x7f080050 | 13213 |
| `abc_list_pressed_holo_dark` | int | 0x7f080051 | 13216 |
| `abc_list_pressed_holo_light` | int | 0x7f080052 | 13219 |
| `abc_list_selector_background_transition_holo_dark` | int | 0x7f080053 | 13222 |
| `abc_list_selector_background_transition_holo_light` | int | 0x7f080054 | 13225 |
| `abc_list_selector_disabled_holo_dark` | int | 0x7f080055 | 13228 |
| `abc_list_selector_disabled_holo_light` | int | 0x7f080056 | 13231 |
| `abc_list_selector_holo_dark` | int | 0x7f080057 | 13234 |
| `abc_list_selector_holo_light` | int | 0x7f080058 | 13237 |
| `abc_menu_hardkey_panel_mtrl_mult` | int | 0x7f080059 | 13240 |
| `abc_popup_background_mtrl_mult` | int | 0x7f08005a | 13243 |
| `abc_ratingbar_indicator_material` | int | 0x7f08005b | 13246 |
| `abc_ratingbar_material` | int | 0x7f08005c | 13249 |
| `abc_ratingbar_small_material` | int | 0x7f08005d | 13252 |
| `abc_scrubber_control_off_mtrl_alpha` | int | 0x7f08005e | 13255 |
| `abc_scrubber_control_to_pressed_mtrl_000` | int | 0x7f08005f | 13258 |
| `abc_scrubber_control_to_pressed_mtrl_005` | int | 0x7f080060 | 13261 |
| `abc_scrubber_primary_mtrl_alpha` | int | 0x7f080061 | 13264 |
| `abc_scrubber_track_mtrl_alpha` | int | 0x7f080062 | 13267 |
| `abc_seekbar_thumb_material` | int | 0x7f080063 | 13270 |
| `abc_seekbar_tick_mark_material` | int | 0x7f080064 | 13273 |
| `abc_seekbar_track_material` | int | 0x7f080065 | 13276 |
| `abc_spinner_mtrl_am_alpha` | int | 0x7f080066 | 13279 |
| `abc_spinner_textfield_background_material` | int | 0x7f080067 | 13282 |
| `abc_star_black_48dp` | int | 0x7f080068 | 13285 |
| `abc_star_half_black_48dp` | int | 0x7f080069 | 13288 |
| `abc_switch_thumb_material` | int | 0x7f08006a | 13291 |
| `abc_switch_track_mtrl_alpha` | int | 0x7f08006b | 13294 |
| `abc_tab_indicator_material` | int | 0x7f08006c | 13297 |
| `abc_tab_indicator_mtrl_alpha` | int | 0x7f08006d | 13300 |
| `abc_text_cursor_material` | int | 0x7f08006e | 13303 |
| `abc_text_select_handle_left_mtrl` | int | 0x7f08006f | 13306 |
| `abc_text_select_handle_middle_mtrl` | int | 0x7f080070 | 13309 |
| `abc_text_select_handle_right_mtrl` | int | 0x7f080071 | 13312 |
| `abc_textfield_activated_mtrl_alpha` | int | 0x7f080072 | 13315 |
| `abc_textfield_default_mtrl_alpha` | int | 0x7f080073 | 13318 |
| `abc_textfield_search_activated_mtrl_alpha` | int | 0x7f080074 | 13321 |
| `abc_textfield_search_default_mtrl_alpha` | int | 0x7f080075 | 13324 |
| `abc_textfield_search_material` | int | 0x7f080076 | 13327 |
| `abc_vector_test` | int | 0x7f080077 | 13330 |
| `action_about` | int | 0x7f08007e | 13333 |
| `add_circle_gray_999999` | int | 0x7f080080 | 13336 |
| `add_gray_999999` | int | 0x7f080081 | 13339 |
| `add_white` | int | 0x7f080082 | 13342 |
| `album` | int | 0x7f080083 | 13345 |
| `album_cb` | int | 0x7f080084 | 13348 |
| `album_cb_select` | int | 0x7f080085 | 13351 |
| `album_default` | int | 0x7f080086 | 13354 |
| `album_default_bg` | int | 0x7f080087 | 13357 |
| `album_selected` | int | 0x7f080088 | 13360 |
| `amu_bubble_mask` | int | 0x7f08008a | 13363 |
| `amu_bubble_shadow` | int | 0x7f08008b | 13366 |
| `announcement` | int | 0x7f08008d | 13369 |
| `arrow_left` | int | 0x7f080092 | 13372 |
| `audio_white` | int | 0x7f080095 | 13375 |
| `avd_hide_password` | int | 0x7f080096 | 13378 |
| `avd_show_password` | int | 0x7f080097 | 13381 |
| `back` | int | 0x7f08009d | 13384 |
| `back_black` | int | 0x7f08009e | 13387 |
| `back_black_2b2b2b` | int | 0x7f08009f | 13390 |
| `back_gray_b1b1b1` | int | 0x7f0800a0 | 13393 |
| `back_white` | int | 0x7f0800a1 | 13396 |
| `back_white2` | int | 0x7f0800a2 | 13399 |
| `bg_wiht_shadow` | int | 0x7f0800b3 | 13402 |
| `brvah_sample_footer_loading` | int | 0x7f0800b8 | 13405 |
| `brvah_sample_footer_loading_progress` | int | 0x7f0800b9 | 13408 |
| `btn_checkbox_checked_mtrl` | int | 0x7f0800ca | 13411 |
| `btn_checkbox_checked_to_unchecked_mtrl_animation` | int | 0x7f0800cb | 13414 |
| `btn_checkbox_unchecked_mtrl` | int | 0x7f0800cc | 13417 |
| `btn_checkbox_unchecked_to_checked_mtrl_animation` | int | 0x7f0800cd | 13420 |
| `btn_connect` | int | 0x7f0800ce | 13423 |
| `btn_radio_off_mtrl` | int | 0x7f0800dc | 13426 |
| `btn_radio_off_to_on_mtrl_animation` | int | 0x7f0800dd | 13429 |
| `btn_radio_on_mtrl` | int | 0x7f0800de | 13432 |
| `btn_radio_on_to_off_mtrl_animation` | int | 0x7f0800df | 13435 |
| `calendar_playback` | int | 0x7f0800f8 | 13438 |
| `camera` | int | 0x7f0800f9 | 13441 |
| `camera_scan_flashlight_off` | int | 0x7f080103 | 13444 |
| `camera_scan_flashlight_on` | int | 0x7f080104 | 13447 |
| `camera_scan_flashlight_selector` | int | 0x7f080105 | 13450 |
| `camera_view_behind` | int | 0x7f08010a | 13453 |
| `camera_view_front` | int | 0x7f08010b | 13456 |
| `camera_wifi_connected` | int | 0x7f08010d | 13459 |
| `camera_wifi_disconnected` | int | 0x7f08010e | 13462 |
| `cancel_white` | int | 0x7f08010f | 13465 |
| `cb_blue_4099ff` | int | 0x7f080114 | 13468 |
| `cb_checked_red_e15151` | int | 0x7f080115 | 13471 |
| `cb_checked_theme` | int | 0x7f080116 | 13474 |
| `cb_gray` | int | 0x7f080117 | 13477 |
| `cb_gray_4099ff` | int | 0x7f080118 | 13480 |
| `cb_gray_959595` | int | 0x7f080119 | 13483 |
| `cb_normal_2b2b2b` | int | 0x7f08011a | 13486 |
| `cb_normal_e15151` | int | 0x7f08011b | 13489 |
| `cb_selected_green` | int | 0x7f08011c | 13492 |
| `cb_selected_rect_blue` | int | 0x7f08011d | 13495 |
| `cb_unchecked_white` | int | 0x7f08011e | 13498 |
| `cb_unselected_rect_white` | int | 0x7f08011f | 13501 |
| `cb_unselected_rect_yinse` | int | 0x7f080120 | 13504 |
| `cb_zise` | int | 0x7f080121 | 13507 |
| `changzhen` | int | 0x7f080123 | 13510 |
| `check_white` | int | 0x7f080124 | 13513 |
| `circle_red_bg` | int | 0x7f080125 | 13516 |
| `circle_white_bg` | int | 0x7f080126 | 13519 |
| `close` | int | 0x7f080128 | 13522 |
| `close_ad` | int | 0x7f080129 | 13525 |
| `close_black` | int | 0x7f08012a | 13528 |
| `close_blue` | int | 0x7f08012b | 13531 |
| `close_gray_959595` | int | 0x7f08012c | 13534 |
| `close_mini_white` | int | 0x7f08012d | 13537 |
| `close_red_e15151` | int | 0x7f08012e | 13540 |
| `close_white` | int | 0x7f08012f | 13543 |
| `close_yellow` | int | 0x7f080130 | 13546 |
| `cloud_checked` | int | 0x7f080131 | 13549 |
| `cloud_expand` | int | 0x7f080132 | 13552 |
| `cloud_hide` | int | 0x7f080133 | 13555 |
| `cloud_unchecked` | int | 0x7f080134 | 13558 |
| `color_list_select` | int | 0x7f080136 | 13561 |
| `common_full_open_on_phone` | int | 0x7f080137 | 13564 |
| `common_google_signin_btn_icon_dark` | int | 0x7f080138 | 13567 |
| `common_google_signin_btn_icon_dark_focused` | int | 0x7f080139 | 13570 |
| `common_google_signin_btn_icon_dark_normal` | int | 0x7f08013a | 13573 |
| `common_google_signin_btn_icon_dark_normal_background` | int | 0x7f08013b | 13576 |
| `common_google_signin_btn_icon_disabled` | int | 0x7f08013c | 13579 |
| `common_google_signin_btn_icon_light` | int | 0x7f08013d | 13582 |
| `common_google_signin_btn_icon_light_focused` | int | 0x7f08013e | 13585 |
| `common_google_signin_btn_icon_light_normal` | int | 0x7f08013f | 13588 |
| `common_google_signin_btn_icon_light_normal_background` | int | 0x7f080140 | 13591 |
| `common_google_signin_btn_text_dark` | int | 0x7f080141 | 13594 |
| `common_google_signin_btn_text_dark_focused` | int | 0x7f080142 | 13597 |
| `common_google_signin_btn_text_dark_normal` | int | 0x7f080143 | 13600 |
| `common_google_signin_btn_text_dark_normal_background` | int | 0x7f080144 | 13603 |
| `common_google_signin_btn_text_disabled` | int | 0x7f080145 | 13606 |
| `common_google_signin_btn_text_light` | int | 0x7f080146 | 13609 |
| `common_google_signin_btn_text_light_focused` | int | 0x7f080147 | 13612 |
| `common_google_signin_btn_text_light_normal` | int | 0x7f080148 | 13615 |
| `common_google_signin_btn_text_light_normal_background` | int | 0x7f080149 | 13618 |
| `compat_splash_screen` | int | 0x7f08014a | 13621 |
| `compat_splash_screen_no_icon_background` | int | 0x7f08014b | 13624 |
| `copy_white` | int | 0x7f080154 | 13627 |
| `core_ui_ic_backspace_black_24dp` | int | 0x7f080155 | 13630 |
| `core_ui_ic_close_black_24dp` | int | 0x7f080156 | 13633 |
| `core_ui_ic_close_white_24dp` | int | 0x7f080157 | 13636 |
| `core_ui_ic_done_black_24dp` | int | 0x7f080158 | 13639 |
| `cuo_right` | int | 0x7f080159 | 13642 |
| `custom_enlarge` | int | 0x7f08015a | 13645 |
| `custom_shrink` | int | 0x7f08015b | 13648 |
| `cut_circle` | int | 0x7f08015d | 13651 |
| `cut_rectangle` | int | 0x7f08015e | 13654 |
| `cv_bg_material` | int | 0x7f080160 | 13657 |
| `dafault_indexBar_background` | int | 0x7f080161 | 13660 |
| `default_pic` | int | 0x7f080163 | 13663 |
| `delete_circle_white` | int | 0x7f080165 | 13666 |
| `delete_photo_preview` | int | 0x7f080166 | 13669 |
| `delete_playback` | int | 0x7f080167 | 13672 |
| `delete_white` | int | 0x7f080168 | 13675 |
| `design_fab_background` | int | 0x7f080169 | 13678 |
| `design_ic_visibility` | int | 0x7f08016a | 13681 |
| `design_ic_visibility_off` | int | 0x7f08016b | 13684 |
| `design_password_eye` | int | 0x7f08016c | 13687 |
| `design_snackbar_background` | int | 0x7f08016d | 13690 |
| `detail_photo_pre` | int | 0x7f08016e | 13693 |
| `detail_white` | int | 0x7f08016f | 13696 |
| `device_success` | int | 0x7f080171 | 13699 |
| `dialog_bg` | int | 0x7f080173 | 13702 |
| `dialog_btn_bg` | int | 0x7f080174 | 13705 |
| `dialog_loading` | int | 0x7f080175 | 13708 |
| `download_playback` | int | 0x7f080182 | 13711 |
| `dui_black_2b2b2b` | int | 0x7f080183 | 13714 |
| `dui_blue_0090ff` | int | 0x7f080184 | 13717 |
| `dui_gray_b1b1b1` | int | 0x7f080185 | 13720 |
| `duigou_blue` | int | 0x7f080186 | 13723 |
| `edit` | int | 0x7f080187 | 13726 |
| `edit_photo_preview` | int | 0x7f080189 | 13729 |
| `edit_selected` | int | 0x7f08018a | 13732 |
| `edit_white` | int | 0x7f08018b | 13735 |
| `eidit_white` | int | 0x7f08018c | 13738 |
| `empty_drawable` | int | 0x7f08018d | 13741 |
| `empty_gray` | int | 0x7f08018e | 13744 |
| `exo_controls_fastforward` | int | 0x7f080190 | 13747 |
| `exo_controls_fullscreen_enter` | int | 0x7f080191 | 13750 |
| `exo_controls_fullscreen_exit` | int | 0x7f080192 | 13753 |
| `exo_controls_next` | int | 0x7f080193 | 13756 |
| `exo_controls_pause` | int | 0x7f080194 | 13759 |
| `exo_controls_play` | int | 0x7f080195 | 13762 |
| `exo_controls_previous` | int | 0x7f080196 | 13765 |
| `exo_controls_repeat_all` | int | 0x7f080197 | 13768 |
| `exo_controls_repeat_off` | int | 0x7f080198 | 13771 |
| `exo_controls_repeat_one` | int | 0x7f080199 | 13774 |
| `exo_controls_rewind` | int | 0x7f08019a | 13777 |
| `exo_controls_shuffle_off` | int | 0x7f08019b | 13780 |
| `exo_controls_shuffle_on` | int | 0x7f08019c | 13783 |
| `exo_controls_vr` | int | 0x7f08019d | 13786 |
| `exo_edit_mode_logo` | int | 0x7f08019e | 13789 |
| `exo_ic_audiotrack` | int | 0x7f08019f | 13792 |
| `exo_ic_check` | int | 0x7f0801a0 | 13795 |
| `exo_ic_chevron_left` | int | 0x7f0801a1 | 13798 |
| `exo_ic_chevron_right` | int | 0x7f0801a2 | 13801 |
| `exo_ic_default_album_image` | int | 0x7f0801a3 | 13804 |
| `exo_ic_forward` | int | 0x7f0801a4 | 13807 |
| `exo_ic_fullscreen_enter` | int | 0x7f0801a5 | 13810 |
| `exo_ic_fullscreen_exit` | int | 0x7f0801a6 | 13813 |
| `exo_ic_pause_circle_filled` | int | 0x7f0801a7 | 13816 |
| `exo_ic_play_circle_filled` | int | 0x7f0801a8 | 13819 |
| `exo_ic_rewind` | int | 0x7f0801a9 | 13822 |
| `exo_ic_settings` | int | 0x7f0801aa | 13825 |
| `exo_ic_skip_next` | int | 0x7f0801ab | 13828 |
| `exo_ic_skip_previous` | int | 0x7f0801ac | 13831 |
| `exo_ic_speed` | int | 0x7f0801ad | 13834 |
| `exo_ic_subtitle_off` | int | 0x7f0801ae | 13837 |
| `exo_ic_subtitle_on` | int | 0x7f0801af | 13840 |
| `exo_icon_circular_play` | int | 0x7f0801b0 | 13843 |
| `exo_icon_fastforward` | int | 0x7f0801b1 | 13846 |
| `exo_icon_fullscreen_enter` | int | 0x7f0801b2 | 13849 |
| `exo_icon_fullscreen_exit` | int | 0x7f0801b3 | 13852 |
| `exo_icon_next` | int | 0x7f0801b4 | 13855 |
| `exo_icon_pause` | int | 0x7f0801b5 | 13858 |
| `exo_icon_play` | int | 0x7f0801b6 | 13861 |
| `exo_icon_previous` | int | 0x7f0801b7 | 13864 |
| `exo_icon_repeat_all` | int | 0x7f0801b8 | 13867 |
| `exo_icon_repeat_off` | int | 0x7f0801b9 | 13870 |
| `exo_icon_repeat_one` | int | 0x7f0801ba | 13873 |
| `exo_icon_rewind` | int | 0x7f0801bb | 13876 |
| `exo_icon_shuffle_off` | int | 0x7f0801bc | 13879 |
| `exo_icon_shuffle_on` | int | 0x7f0801bd | 13882 |
| `exo_icon_stop` | int | 0x7f0801be | 13885 |
| `exo_icon_vr` | int | 0x7f0801bf | 13888 |
| `exo_notification_fastforward` | int | 0x7f0801c0 | 13891 |
| `exo_notification_next` | int | 0x7f0801c1 | 13894 |
| `exo_notification_pause` | int | 0x7f0801c2 | 13897 |
| `exo_notification_play` | int | 0x7f0801c3 | 13900 |
| `exo_notification_previous` | int | 0x7f0801c4 | 13903 |
| `exo_notification_rewind` | int | 0x7f0801c5 | 13906 |
| `exo_notification_small_icon` | int | 0x7f0801c6 | 13909 |
| `exo_notification_stop` | int | 0x7f0801c7 | 13912 |
| `exo_rounded_rectangle` | int | 0x7f0801c8 | 13915 |
| `exo_styled_controls_audiotrack` | int | 0x7f0801c9 | 13918 |
| `exo_styled_controls_check` | int | 0x7f0801ca | 13921 |
| `exo_styled_controls_fastforward` | int | 0x7f0801cb | 13924 |
| `exo_styled_controls_fullscreen_enter` | int | 0x7f0801cc | 13927 |
| `exo_styled_controls_fullscreen_exit` | int | 0x7f0801cd | 13930 |
| `exo_styled_controls_next` | int | 0x7f0801ce | 13933 |
| `exo_styled_controls_overflow_hide` | int | 0x7f0801cf | 13936 |
| `exo_styled_controls_overflow_show` | int | 0x7f0801d0 | 13939 |
| `exo_styled_controls_pause` | int | 0x7f0801d1 | 13942 |
| `exo_styled_controls_play` | int | 0x7f0801d2 | 13945 |
| `exo_styled_controls_previous` | int | 0x7f0801d3 | 13948 |
| `exo_styled_controls_repeat_all` | int | 0x7f0801d4 | 13951 |
| `exo_styled_controls_repeat_off` | int | 0x7f0801d5 | 13954 |
| `exo_styled_controls_repeat_one` | int | 0x7f0801d6 | 13957 |
| `exo_styled_controls_rewind` | int | 0x7f0801d7 | 13960 |
| `exo_styled_controls_settings` | int | 0x7f0801d8 | 13963 |
| `exo_styled_controls_shuffle_off` | int | 0x7f0801d9 | 13966 |
| `exo_styled_controls_shuffle_on` | int | 0x7f0801da | 13969 |
| `exo_styled_controls_speed` | int | 0x7f0801db | 13972 |
| `exo_styled_controls_subtitle_off` | int | 0x7f0801dc | 13975 |
| `exo_styled_controls_subtitle_on` | int | 0x7f0801dd | 13978 |
| `exo_styled_controls_vr` | int | 0x7f0801de | 13981 |
| `file` | int | 0x7f0801e0 | 13984 |
| `file_illegal` | int | 0x7f0801e1 | 13987 |
| `file_selected` | int | 0x7f0801e2 | 13990 |
| `flashlight_off` | int | 0x7f0801e3 | 13993 |
| `flashlight_on` | int | 0x7f0801e4 | 13996 |
| `flashlight_selector` | int | 0x7f0801e5 | 13999 |
| `fullscreen_white` | int | 0x7f0801e9 | 14002 |
| `gku_about` | int | 0x7f0801ea | 14005 |
| `gku_access` | int | 0x7f0801eb | 14008 |
| `gku_account` | int | 0x7f0801ec | 14011 |
| `gku_add` | int | 0x7f0801ed | 14014 |
| `gku_add_guide` | int | 0x7f0801ee | 14017 |
| `gku_add_guide_reset` | int | 0x7f0801ef | 14020 |
| `gku_add_left` | int | 0x7f0801f0 | 14023 |
| `gku_add_right` | int | 0x7f0801f1 | 14026 |
| `gku_album_image` | int | 0x7f0801f2 | 14029 |
| `gku_album_normal` | int | 0x7f0801f3 | 14032 |
| `gku_album_selected` | int | 0x7f0801f4 | 14035 |
| `gku_album_video` | int | 0x7f0801f5 | 14038 |
| `gku_back` | int | 0x7f0801f6 | 14041 |
| `gku_back_main` | int | 0x7f0801f7 | 14044 |
| `gku_back_white` | int | 0x7f0801f8 | 14047 |
| `gku_bat_1` | int | 0x7f0801f9 | 14050 |
| `gku_bat_2` | int | 0x7f0801fa | 14053 |
| `gku_bat_3` | int | 0x7f0801fb | 14056 |
| `gku_bat_4` | int | 0x7f0801fc | 14059 |
| `gku_bat_charge` | int | 0x7f0801fd | 14062 |
| `gku_capture` | int | 0x7f0801fe | 14065 |
| `gku_checked` | int | 0x7f0801ff | 14068 |
| `gku_close` | int | 0x7f080200 | 14071 |
| `gku_close_eye` | int | 0x7f080201 | 14074 |
| `gku_cloud` | int | 0x7f080202 | 14077 |
| `gku_cloud_bg` | int | 0x7f080203 | 14080 |
| `gku_cloud_guide` | int | 0x7f080204 | 14083 |
| `gku_cloud_guide_check` | int | 0x7f080205 | 14086 |
| `gku_cloud_logo` | int | 0x7f080206 | 14089 |
| `gku_cloud_s` | int | 0x7f080207 | 14092 |
| `gku_cur_location` | int | 0x7f080208 | 14095 |
| `gku_dev_type_default` | int | 0x7f080209 | 14098 |
| `gku_device` | int | 0x7f08020a | 14101 |
| `gku_device_empty` | int | 0x7f08020b | 14104 |
| `gku_device_s` | int | 0x7f08020c | 14107 |
| `gku_feedback_add` | int | 0x7f08020d | 14110 |
| `gku_file_preview` | int | 0x7f08020e | 14113 |
| `gku_land_back` | int | 0x7f08020f | 14116 |
| `gku_land_listen` | int | 0x7f080210 | 14119 |
| `gku_land_listen_s` | int | 0x7f080211 | 14122 |
| `gku_land_res_bg` | int | 0x7f080212 | 14125 |
| `gku_land_speak` | int | 0x7f080213 | 14128 |
| `gku_launch_bg` | int | 0x7f080214 | 14131 |
| `gku_launch_bottom` | int | 0x7f080215 | 14134 |
| `gku_listen` | int | 0x7f080216 | 14137 |
| `gku_listen_land` | int | 0x7f080217 | 14140 |
| `gku_listen_land_s` | int | 0x7f080218 | 14143 |
| `gku_listen_s` | int | 0x7f080219 | 14146 |
| `gku_live_setting` | int | 0x7f08021a | 14149 |
| `gku_local` | int | 0x7f08021b | 14152 |
| `gku_local_s` | int | 0x7f08021c | 14155 |
| `gku_location` | int | 0x7f08021d | 14158 |
| `gku_location_highlight` | int | 0x7f08021e | 14161 |
| `gku_login_bg` | int | 0x7f08021f | 14164 |
| `gku_login_top` | int | 0x7f080220 | 14167 |
| `gku_logo` | int | 0x7f080221 | 14170 |
| `gku_logo_bg` | int | 0x7f080222 | 14173 |
| `gku_main_cloud` | int | 0x7f080223 | 14176 |
| `gku_main_h_flip` | int | 0x7f080224 | 14179 |
| `gku_main_location` | int | 0x7f080225 | 14182 |
| `gku_main_ptz` | int | 0x7f080226 | 14185 |
| `gku_main_rec` | int | 0x7f080227 | 14188 |
| `gku_main_sd` | int | 0x7f080228 | 14191 |
| `gku_main_v_flip` | int | 0x7f080229 | 14194 |
| `gku_mine` | int | 0x7f08022a | 14197 |
| `gku_mine_s` | int | 0x7f08022b | 14200 |
| `gku_msg` | int | 0x7f08022c | 14203 |
| `gku_msg_expand` | int | 0x7f08022d | 14206 |
| `gku_msg_share` | int | 0x7f08022e | 14209 |
| `gku_msg_valid` | int | 0x7f08022f | 14212 |
| `gku_open_eye` | int | 0x7f080230 | 14215 |
| `gku_operate` | int | 0x7f080231 | 14218 |
| `gku_playback_hint` | int | 0x7f080232 | 14221 |
| `gku_power` | int | 0x7f080233 | 14224 |
| `gku_preview` | int | 0x7f080234 | 14227 |
| `gku_preview_c600` | int | 0x7f080235 | 14230 |
| `gku_ptz_center` | int | 0x7f080236 | 14233 |
| `gku_ptz_down` | int | 0x7f080237 | 14236 |
| `gku_ptz_down_s` | int | 0x7f080238 | 14239 |
| `gku_ptz_left` | int | 0x7f080239 | 14242 |
| `gku_ptz_left_s` | int | 0x7f08023a | 14245 |
| `gku_ptz_right` | int | 0x7f08023b | 14248 |
| `gku_ptz_right_s` | int | 0x7f08023c | 14251 |
| `gku_ptz_up` | int | 0x7f08023d | 14254 |
| `gku_ptz_up_s` | int | 0x7f08023e | 14257 |
| `gku_pwd` | int | 0x7f08023f | 14260 |
| `gku_rec_flag` | int | 0x7f080240 | 14263 |
| `gku_record` | int | 0x7f080241 | 14266 |
| `gku_record_s` | int | 0x7f080242 | 14269 |
| `gku_refresh` | int | 0x7f080243 | 14272 |
| `gku_scan_bl` | int | 0x7f080244 | 14275 |
| `gku_scan_br` | int | 0x7f080245 | 14278 |
| `gku_scan_line` | int | 0x7f080246 | 14281 |
| `gku_scan_tl` | int | 0x7f080247 | 14284 |
| `gku_scan_tr` | int | 0x7f080248 | 14287 |
| `gku_screen` | int | 0x7f080249 | 14290 |
| `gku_sd_checked` | int | 0x7f08024a | 14293 |
| `gku_sd_date` | int | 0x7f08024b | 14296 |
| `gku_sd_delete` | int | 0x7f08024c | 14299 |
| `gku_sd_download` | int | 0x7f08024d | 14302 |
| `gku_sd_full` | int | 0x7f08024e | 14305 |
| `gku_sd_next` | int | 0x7f08024f | 14308 |
| `gku_sd_no_data` | int | 0x7f080250 | 14311 |
| `gku_sd_normal` | int | 0x7f080251 | 14314 |
| `gku_sd_pause` | int | 0x7f080252 | 14317 |
| `gku_sd_play` | int | 0x7f080253 | 14320 |
| `gku_sd_snap` | int | 0x7f080254 | 14323 |
| `gku_sd_thumb` | int | 0x7f080255 | 14326 |
| `gku_set_alarm` | int | 0x7f080256 | 14329 |
| `gku_set_alias` | int | 0x7f080257 | 14332 |
| `gku_set_image` | int | 0x7f080258 | 14335 |
| `gku_set_more` | int | 0x7f080259 | 14338 |
| `gku_set_push` | int | 0x7f08025a | 14341 |
| `gku_set_share` | int | 0x7f08025b | 14344 |
| `gku_share_add` | int | 0x7f08025c | 14347 |
| `gku_share_scan` | int | 0x7f08025d | 14350 |
| `gku_signal_0` | int | 0x7f08025e | 14353 |
| `gku_signal_1` | int | 0x7f08025f | 14356 |
| `gku_signal_2` | int | 0x7f080260 | 14359 |
| `gku_signal_3` | int | 0x7f080261 | 14362 |
| `gku_signal_4` | int | 0x7f080262 | 14365 |
| `gku_speak` | int | 0x7f080263 | 14368 |
| `gku_speak_land` | int | 0x7f080264 | 14371 |
| `gku_speak_land_s` | int | 0x7f080265 | 14374 |
| `gku_speak_s` | int | 0x7f080266 | 14377 |
| `gku_step` | int | 0x7f080267 | 14380 |
| `gku_step_s` | int | 0x7f080268 | 14383 |
| `gku_stream` | int | 0x7f080269 | 14386 |
| `gku_stream_land` | int | 0x7f08026a | 14389 |
| `gku_switch_off` | int | 0x7f08026b | 14392 |
| `gku_switch_on` | int | 0x7f08026c | 14395 |
| `gku_uncheck` | int | 0x7f08026d | 14398 |
| `gku_update_failed` | int | 0x7f08026e | 14401 |
| `gku_update_succeed` | int | 0x7f08026f | 14404 |
| `gku_user_header` | int | 0x7f080270 | 14407 |
| `gku_user_qrcode` | int | 0x7f080271 | 14410 |
| `gku_view_count` | int | 0x7f080272 | 14413 |
| `gku_vip` | int | 0x7f080273 | 14416 |
| `googleg_disabled_color_18` | int | 0x7f080274 | 14419 |
| `googleg_standard_color_18` | int | 0x7f080275 | 14422 |
| `grid_camera` | int | 0x7f080276 | 14425 |
| `guangpan` | int | 0x7f080278 | 14428 |
| `ic_action_right` | int | 0x7f08027e | 14431 |
| `ic_add_circle_24dp` | int | 0x7f08027f | 14434 |
| `ic_add_circle_greyish_white_36dp` | int | 0x7f080280 | 14437 |
| `ic_add_white` | int | 0x7f080281 | 14440 |
| `ic_album_activity_close_white_24dp` | int | 0x7f080283 | 14443 |
| `ic_arrow_back_black_18dp` | int | 0x7f080285 | 14446 |
| `ic_arrow_back_black_24` | int | 0x7f080286 | 14449 |
| `ic_arrow_back_white_36dp` | int | 0x7f080288 | 14452 |
| `ic_battery_state_1` | int | 0x7f080290 | 14455 |
| `ic_battery_state_2` | int | 0x7f080291 | 14458 |
| `ic_battery_state_3` | int | 0x7f080292 | 14461 |
| `ic_battery_state_charge` | int | 0x7f080293 | 14464 |
| `ic_battery_state_empty` | int | 0x7f080294 | 14467 |
| `ic_call_answer` | int | 0x7f08029d | 14470 |
| `ic_call_answer_low` | int | 0x7f08029e | 14473 |
| `ic_call_answer_video` | int | 0x7f08029f | 14476 |
| `ic_call_answer_video_low` | int | 0x7f0802a0 | 14479 |
| `ic_call_decline` | int | 0x7f0802a1 | 14482 |
| `ic_call_decline_low` | int | 0x7f0802a2 | 14485 |
| `ic_case_close_black_24dp` | int | 0x7f0802a3 | 14488 |
| `ic_case_pause_circle_filled_black_24dp` | int | 0x7f0802a4 | 14491 |
| `ic_case_play_circle_filled_black_24dp` | int | 0x7f0802a5 | 14494 |
| `ic_check_circle_black_24dp` | int | 0x7f0802aa | 14497 |
| `ic_chevron_right_black_24dp` | int | 0x7f0802ab | 14500 |
| `ic_clear_black_24` | int | 0x7f0802ac | 14503 |
| `ic_clock_black_24dp` | int | 0x7f0802ae | 14506 |
| `ic_connect_device_hint1` | int | 0x7f0802b4 | 14509 |
| `ic_connect_device_hint2` | int | 0x7f0802b5 | 14512 |
| `ic_delete_black_24dp` | int | 0x7f0802b7 | 14515 |
| `ic_delete_grey_600_24dp` | int | 0x7f0802b8 | 14518 |
| `ic_delete_white_18dp` | int | 0x7f0802b9 | 14521 |
| `ic_delete_white_36dp` | int | 0x7f0802bb | 14524 |
| `ic_done_black` | int | 0x7f0802be | 14527 |
| `ic_done_blue_grey_900_48dp` | int | 0x7f0802bf | 14530 |
| `ic_done_grey_100_48dp` | int | 0x7f0802c1 | 14533 |
| `ic_download` | int | 0x7f0802c2 | 14536 |
| `ic_downloads` | int | 0x7f0802c3 | 14539 |
| `ic_error_ijklib` | int | 0x7f0802c4 | 14542 |
| `ic_file_download_black_24dp` | int | 0x7f0802c6 | 14545 |
| `ic_home_album` | int | 0x7f0802cc | 14548 |
| `ic_home_logo` | int | 0x7f0802cd | 14551 |
| `ic_home_settings` | int | 0x7f0802ce | 14554 |
| `ic_info_white_36dp` | int | 0x7f0802f1 | 14557 |
| `ic_iro_add` | int | 0x7f0802f2 | 14560 |
| `ic_iro_album_sdcard` | int | 0x7f0802f3 | 14563 |
| `ic_iro_capture` | int | 0x7f0802f4 | 14566 |
| `ic_iro_settings` | int | 0x7f0802f5 | 14569 |
| `ic_keyboard_black_24dp` | int | 0x7f080300 | 14572 |
| `ic_launcher_background` | int | 0x7f080301 | 14575 |
| `ic_launcher_foreground` | int | 0x7f080302 | 14578 |
| `ic_m3_chip_check` | int | 0x7f080306 | 14581 |
| `ic_m3_chip_checked_circle` | int | 0x7f080307 | 14584 |
| `ic_m3_chip_close` | int | 0x7f080308 | 14587 |
| `ic_main_nav_album` | int | 0x7f080309 | 14590 |
| `ic_main_nav_car` | int | 0x7f08030a | 14593 |
| `ic_main_nav_menu` | int | 0x7f08030b | 14596 |
| `ic_mode_capture` | int | 0x7f08030e | 14599 |
| `ic_mode_video` | int | 0x7f08030f | 14602 |
| `ic_mtrl_checked_circle` | int | 0x7f080311 | 14605 |
| `ic_mtrl_chip_checked_black` | int | 0x7f080312 | 14608 |
| `ic_mtrl_chip_checked_circle` | int | 0x7f080313 | 14611 |
| `ic_mtrl_chip_close_circle` | int | 0x7f080314 | 14614 |
| `ic_navigate_before_white_18dp` | int | 0x7f080315 | 14617 |
| `ic_navigate_before_white_36dp` | int | 0x7f080316 | 14620 |
| `ic_pause_circle_ijklib` | int | 0x7f08031a | 14623 |
| `ic_pause_white` | int | 0x7f08031d | 14626 |
| `ic_photo_library_white_24dp` | int | 0x7f08031f | 14629 |
| `ic_play_arrow_white` | int | 0x7f080320 | 14632 |
| `ic_play_arrow_white_24dp` | int | 0x7f080321 | 14635 |
| `ic_play_circle_ijklib` | int | 0x7f080325 | 14638 |
| `ic_play_circle_outline_blue_grey` | int | 0x7f080326 | 14641 |
| `ic_play_circle_outline_blue_grey_48dp` | int | 0x7f080327 | 14644 |
| `ic_pref_view_more` | int | 0x7f08032c | 14647 |
| `ic_radio_button_unchecked_black` | int | 0x7f080333 | 14650 |
| `ic_refresh_white_24dp` | int | 0x7f080334 | 14653 |
| `ic_search_black_24` | int | 0x7f080337 | 14656 |
| `ic_select_all_black_24dp` | int | 0x7f080338 | 14659 |
| `ic_settings_power` | int | 0x7f08033a | 14662 |
| `ic_settings_white_24dp` | int | 0x7f08033c | 14665 |
| `ic_share_white_24dp` | int | 0x7f08033e | 14668 |
| `ic_share_white_36dp` | int | 0x7f08033f | 14671 |
| `ic_stop_white_24dp` | int | 0x7f080340 | 14674 |
| `ic_stop_white_36dp` | int | 0x7f080341 | 14677 |
| `ic_subtract_white` | int | 0x7f080342 | 14680 |
| `ic_switch_off` | int | 0x7f080343 | 14683 |
| `ic_switch_on` | int | 0x7f080344 | 14686 |
| `ic_toolbar_return` | int | 0x7f080347 | 14689 |
| `icon_1024` | int | 0x7f080352 | 14692 |
| `icon_background` | int | 0x7f080355 | 14695 |
| `icon_camera` | int | 0x7f080360 | 14698 |
| `icon_full` | int | 0x7f080366 | 14701 |
| `icon_launcher` | int | 0x7f080367 | 14704 |
| `icon_microphone` | int | 0x7f08036c | 14707 |
| `icon_microphone_close` | int | 0x7f08036d | 14710 |
| `icon_paypal` | int | 0x7f08036e | 14713 |
| `icon_sound` | int | 0x7f080390 | 14716 |
| `icon_sound_close` | int | 0x7f080391 | 14719 |
| `icon_voice_1` | int | 0x7f0803a4 | 14722 |
| `icon_wei` | int | 0x7f0803a5 | 14725 |
| `icon_zhi` | int | 0x7f0803a9 | 14728 |
| `icon_zoom` | int | 0x7f0803aa | 14731 |
| `indexable_bg_center_overlay` | int | 0x7f0803ae | 14734 |
| `indexable_bg_md_overlay` | int | 0x7f0803af | 14737 |
| `intercom_0001` | int | 0x7f0803b0 | 14740 |
| `intercom_0002` | int | 0x7f0803b1 | 14743 |
| `intercom_0003` | int | 0x7f0803b2 | 14746 |
| `intercom_0004` | int | 0x7f0803b3 | 14749 |
| `intercom_blue` | int | 0x7f0803b4 | 14752 |
| `intercom_gray` | int | 0x7f0803b5 | 14755 |
| `jiantou_right_gray` | int | 0x7f0803bb | 14758 |
| `jinatou_right_gray` | int | 0x7f0803bc | 14761 |
| `launcher` | int | 0x7f0803c0 | 14764 |
| `live_loading_anim` | int | 0x7f0803c9 | 14767 |
| `live_loading_background` | int | 0x7f0803ca | 14770 |
| `live_set_bilibili_icon` | int | 0x7f0803cf | 14773 |
| `live_set_douyin_icon` | int | 0x7f0803d0 | 14776 |
| `live_set_noselect` | int | 0x7f0803d1 | 14779 |
| `live_set_rtmp_icon` | int | 0x7f0803d2 | 14782 |
| `live_set_select` | int | 0x7f0803d3 | 14785 |
| `live_set_wechat_icon` | int | 0x7f0803d4 | 14788 |
| `live_speak_state_1` | int | 0x7f0803d5 | 14791 |
| `live_speak_state_2` | int | 0x7f0803d6 | 14794 |
| `live_speak_state_3` | int | 0x7f0803d7 | 14797 |
| `live_speak_state_4` | int | 0x7f0803d8 | 14800 |
| `lock` | int | 0x7f0803dd | 14803 |
| `lololo` | int | 0x7f0803ee | 14806 |
| `m3_appbar_background` | int | 0x7f0803ef | 14809 |
| `m3_avd_hide_password` | int | 0x7f0803f0 | 14812 |
| `m3_avd_show_password` | int | 0x7f0803f1 | 14815 |
| `m3_bottom_sheet_drag_handle` | int | 0x7f0803f2 | 14818 |
| `m3_password_eye` | int | 0x7f0803f3 | 14821 |
| `m3_popupmenu_background_overlay` | int | 0x7f0803f4 | 14824 |
| `m3_radiobutton_ripple` | int | 0x7f0803f5 | 14827 |
| `m3_selection_control_ripple` | int | 0x7f0803f6 | 14830 |
| `m3_tabs_background` | int | 0x7f0803f7 | 14833 |
| `m3_tabs_line_indicator` | int | 0x7f0803f8 | 14836 |
| `m3_tabs_rounded_line_indicator` | int | 0x7f0803f9 | 14839 |
| `m3_tabs_transparent_background` | int | 0x7f0803fa | 14842 |
| `map_mask` | int | 0x7f0803fc | 14845 |
| `material_cursor_drawable` | int | 0x7f0803fe | 14848 |
| `material_ic_calendar_black_24dp` | int | 0x7f0803ff | 14851 |
| `material_ic_clear_black_24dp` | int | 0x7f080400 | 14854 |
| `material_ic_edit_black_24dp` | int | 0x7f080401 | 14857 |
| `material_ic_keyboard_arrow_left_black_24dp` | int | 0x7f080402 | 14860 |
| `material_ic_keyboard_arrow_next_black_24dp` | int | 0x7f080403 | 14863 |
| `material_ic_keyboard_arrow_previous_black_24dp` | int | 0x7f080404 | 14866 |
| `material_ic_keyboard_arrow_right_black_24dp` | int | 0x7f080405 | 14869 |
| `material_ic_menu_arrow_down_black_24dp` | int | 0x7f080406 | 14872 |
| `material_ic_menu_arrow_up_black_24dp` | int | 0x7f080407 | 14875 |
| `menu_black` | int | 0x7f080410 | 14878 |
| `menu_playback` | int | 0x7f08041d | 14881 |
| `mtrl_bottomsheet_drag_handle` | int | 0x7f080425 | 14884 |
| `mtrl_checkbox_button` | int | 0x7f080426 | 14887 |
| `mtrl_checkbox_button_checked_unchecked` | int | 0x7f080427 | 14890 |
| `mtrl_checkbox_button_icon` | int | 0x7f080428 | 14893 |
| `mtrl_checkbox_button_icon_checked_indeterminate` | int | 0x7f080429 | 14896 |
| `mtrl_checkbox_button_icon_checked_unchecked` | int | 0x7f08042a | 14899 |
| `mtrl_checkbox_button_icon_indeterminate_checked` | int | 0x7f08042b | 14902 |
| `mtrl_checkbox_button_icon_indeterminate_unchecked` | int | 0x7f08042c | 14905 |
| `mtrl_checkbox_button_icon_unchecked_checked` | int | 0x7f08042d | 14908 |
| `mtrl_checkbox_button_icon_unchecked_indeterminate` | int | 0x7f08042e | 14911 |
| `mtrl_checkbox_button_unchecked_checked` | int | 0x7f08042f | 14914 |
| `mtrl_dialog_background` | int | 0x7f080430 | 14917 |
| `mtrl_dropdown_arrow` | int | 0x7f080431 | 14920 |
| `mtrl_ic_arrow_drop_down` | int | 0x7f080432 | 14923 |
| `mtrl_ic_arrow_drop_up` | int | 0x7f080433 | 14926 |
| `mtrl_ic_cancel` | int | 0x7f080434 | 14929 |
| `mtrl_ic_check_mark` | int | 0x7f080435 | 14932 |
| `mtrl_ic_checkbox_checked` | int | 0x7f080436 | 14935 |
| `mtrl_ic_checkbox_unchecked` | int | 0x7f080437 | 14938 |
| `mtrl_ic_error` | int | 0x7f080438 | 14941 |
| `mtrl_ic_indeterminate` | int | 0x7f080439 | 14944 |
| `mtrl_navigation_bar_item_background` | int | 0x7f08043a | 14947 |
| `mtrl_popupmenu_background` | int | 0x7f08043b | 14950 |
| `mtrl_popupmenu_background_overlay` | int | 0x7f08043c | 14953 |
| `mtrl_switch_thumb` | int | 0x7f08043d | 14956 |
| `mtrl_switch_thumb_checked` | int | 0x7f08043e | 14959 |
| `mtrl_switch_thumb_checked_pressed` | int | 0x7f08043f | 14962 |
| `mtrl_switch_thumb_checked_unchecked` | int | 0x7f080440 | 14965 |
| `mtrl_switch_thumb_pressed` | int | 0x7f080441 | 14968 |
| `mtrl_switch_thumb_pressed_checked` | int | 0x7f080442 | 14971 |
| `mtrl_switch_thumb_pressed_unchecked` | int | 0x7f080443 | 14974 |
| `mtrl_switch_thumb_unchecked` | int | 0x7f080444 | 14977 |
| `mtrl_switch_thumb_unchecked_checked` | int | 0x7f080445 | 14980 |
| `mtrl_switch_thumb_unchecked_pressed` | int | 0x7f080446 | 14983 |
| `mtrl_switch_track` | int | 0x7f080447 | 14986 |
| `mtrl_switch_track_decoration` | int | 0x7f080448 | 14989 |
| `mtrl_tabs_default_indicator` | int | 0x7f080449 | 14992 |
| `my` | int | 0x7f08044a | 14995 |
| `my_selected` | int | 0x7f08044b | 14998 |
| `navigation_empty_icon` | int | 0x7f08044d | 15001 |
| `notification_action_background` | int | 0x7f08044f | 15004 |
| `notification_bg` | int | 0x7f080450 | 15007 |
| `notification_bg_low` | int | 0x7f080451 | 15010 |
| `notification_bg_low_normal` | int | 0x7f080452 | 15013 |
| `notification_bg_low_pressed` | int | 0x7f080453 | 15016 |
| `notification_bg_normal` | int | 0x7f080454 | 15019 |
| `notification_bg_normal_pressed` | int | 0x7f080455 | 15022 |
| `notification_icon_background` | int | 0x7f080456 | 15025 |
| `notification_oversize_large_icon_bg` | int | 0x7f080457 | 15028 |
| `notification_template_icon_bg` | int | 0x7f080458 | 15031 |
| `notification_template_icon_low_bg` | int | 0x7f080459 | 15034 |
| `notification_tile_bg` | int | 0x7f08045a | 15037 |
| `notify_panel_notification_icon_bg` | int | 0x7f08045b | 15040 |
| `pause_white` | int | 0x7f08045f | 15043 |
| `pic_alpha` | int | 0x7f080465 | 15046 |
| `pic_alpha_100` | int | 0x7f080466 | 15049 |
| `pic_default_gray` | int | 0x7f080469 | 15052 |
| `pic_edit_beauty` | int | 0x7f08046d | 15055 |
| `pic_edit_color` | int | 0x7f08046e | 15058 |
| `pic_edit_layer` | int | 0x7f08046f | 15061 |
| `pic_edit_mosaic` | int | 0x7f080470 | 15064 |
| `pic_edit_painting` | int | 0x7f080471 | 15067 |
| `pic_edit_photo_frame` | int | 0x7f080472 | 15070 |
| `pic_edit_portrait` | int | 0x7f080473 | 15073 |
| `pic_edit_rotate` | int | 0x7f080474 | 15076 |
| `pic_edit_text` | int | 0x7f080475 | 15079 |
| `pic_edit_watermark` | int | 0x7f080476 | 15082 |
| `pic_launcher` | int | 0x7f080479 | 15085 |
| `play_white` | int | 0x7f080494 | 15088 |
| `play_white_album_folder` | int | 0x7f080495 | 15091 |
| `preview_white` | int | 0x7f0804aa | 15094 |
| `ps_album_bg` | int | 0x7f0804ac | 15097 |
| `ps_anim_progress` | int | 0x7f0804ad | 15100 |
| `ps_audio_placeholder` | int | 0x7f0804ae | 15103 |
| `ps_btn_left_bottom_selector` | int | 0x7f0804af | 15106 |
| `ps_btn_left_normal` | int | 0x7f0804b0 | 15109 |
| `ps_btn_left_select` | int | 0x7f0804b1 | 15112 |
| `ps_btn_right_bottom_selector` | int | 0x7f0804b2 | 15115 |
| `ps_btn_right_normal` | int | 0x7f0804b3 | 15118 |
| `ps_btn_right_select` | int | 0x7f0804b4 | 15121 |
| `ps_btn_selector` | int | 0x7f0804b5 | 15124 |
| `ps_cancel_default_bg` | int | 0x7f0804b6 | 15127 |
| `ps_checkbox_selector` | int | 0x7f0804b7 | 15130 |
| `ps_default_num_oval_normal` | int | 0x7f0804b8 | 15133 |
| `ps_default_num_oval_selected` | int | 0x7f0804b9 | 15136 |
| `ps_default_num_selector` | int | 0x7f0804ba | 15139 |
| `ps_dialog_loading_bg` | int | 0x7f0804bd | 15142 |
| `ps_dialog_shadow` | int | 0x7f0804be | 15145 |
| `ps_gif_tag` | int | 0x7f0804bf | 15148 |
| `ps_ic_audio` | int | 0x7f0804c0 | 15151 |
| `ps_ic_audio_placeholder` | int | 0x7f0804c1 | 15154 |
| `ps_ic_audio_play` | int | 0x7f0804c2 | 15157 |
| `ps_ic_audio_play_cover` | int | 0x7f0804c3 | 15160 |
| `ps_ic_audio_stop` | int | 0x7f0804c4 | 15163 |
| `ps_ic_back` | int | 0x7f0804c5 | 15166 |
| `ps_ic_black_back` | int | 0x7f0804c6 | 15169 |
| `ps_ic_camera` | int | 0x7f0804c7 | 15172 |
| `ps_ic_default_arrow` | int | 0x7f0804c8 | 15175 |
| `ps_ic_delete` | int | 0x7f0804c9 | 15178 |
| `ps_ic_editor` | int | 0x7f0804ca | 15181 |
| `ps_ic_fast_play` | int | 0x7f0804cb | 15184 |
| `ps_ic_grey_arrow` | int | 0x7f0804cc | 15187 |
| `ps_ic_no_data` | int | 0x7f0804cd | 15190 |
| `ps_ic_normal` | int | 0x7f0804ce | 15193 |
| `ps_ic_normal_back` | int | 0x7f0804cf | 15196 |
| `ps_ic_placeholder` | int | 0x7f0804d0 | 15199 |
| `ps_ic_preview_selected` | int | 0x7f0804d1 | 15202 |
| `ps_ic_progress` | int | 0x7f0804d2 | 15205 |
| `ps_ic_seek_bar_thumb` | int | 0x7f0804d3 | 15208 |
| `ps_ic_selected` | int | 0x7f0804d4 | 15211 |
| `ps_ic_shadow_bg` | int | 0x7f0804d5 | 15214 |
| `ps_ic_slow_audio` | int | 0x7f0804d6 | 15217 |
| `ps_ic_trans_1px` | int | 0x7f0804d7 | 15220 |
| `ps_ic_video` | int | 0x7f0804d8 | 15223 |
| `ps_ic_video_play` | int | 0x7f0804d9 | 15226 |
| `ps_image_placeholder` | int | 0x7f0804da | 15229 |
| `ps_item_select_bg` | int | 0x7f0804db | 15232 |
| `ps_layer_progress` | int | 0x7f0804dc | 15235 |
| `ps_num_oval` | int | 0x7f0804dd | 15238 |
| `ps_orange_oval` | int | 0x7f0804de | 15241 |
| `ps_original_checkbox` | int | 0x7f0804df | 15244 |
| `ps_original_wechat_normal` | int | 0x7f0804e0 | 15247 |
| `ps_original_wechat_selected` | int | 0x7f0804e1 | 15250 |
| `ps_preview_checkbox_selector` | int | 0x7f0804e2 | 15253 |
| `ps_preview_gallery_bg` | int | 0x7f0804e3 | 15256 |
| `ps_preview_gallery_frame` | int | 0x7f0804e4 | 15259 |
| `ps_seek_bar_thumb_normal` | int | 0x7f0804e5 | 15262 |
| `ps_seek_bar_thumb_pressed` | int | 0x7f0804e6 | 15265 |
| `ps_select_complete_bg` | int | 0x7f0804e7 | 15268 |
| `ps_select_complete_normal_bg` | int | 0x7f0804e8 | 15271 |
| `ps_transparent_space` | int | 0x7f0804e9 | 15274 |
| `ps_view_normal` | int | 0x7f0804ea | 15277 |
| `ps_view_press` | int | 0x7f0804eb | 15280 |
| `rb_checked_theme` | int | 0x7f0804ef | 15283 |
| `record_gray` | int | 0x7f0804f0 | 15286 |
| `record_preview` | int | 0x7f0804f1 | 15289 |
| `record_puse_gray` | int | 0x7f0804f2 | 15292 |
| `record_red` | int | 0x7f0804f3 | 15295 |
| `record_stop` | int | 0x7f0804f4 | 15298 |
| `right_gray` | int | 0x7f0804f7 | 15301 |
| `rmvb` | int | 0x7f0804fa | 15304 |
| `rotate_3d_white` | int | 0x7f0804fb | 15307 |
| `rotate_white` | int | 0x7f0804fd | 15310 |
| `scankit_appbar_pressed_selected` | int | 0x7f080502 | 15313 |
| `scankit_appbar_pressed_shape` | int | 0x7f080503 | 15316 |
| `scankit_back` | int | 0x7f080504 | 15319 |
| `scankit_dialog_bg` | int | 0x7f080505 | 15322 |
| `scankit_divider_h` | int | 0x7f080506 | 15325 |
| `scankit_flash_selected_selector2` | int | 0x7f080507 | 15328 |
| `scankit_flash_selector` | int | 0x7f080508 | 15331 |
| `scankit_flashlight_layer_off` | int | 0x7f080509 | 15334 |
| `scankit_flashlight_layer_on` | int | 0x7f08050a | 15337 |
| `scankit_flashlight_off` | int | 0x7f08050b | 15340 |
| `scankit_flashlight_on` | int | 0x7f08050c | 15343 |
| `scankit_hivision_light` | int | 0x7f08050d | 15346 |
| `scankit_ic_back` | int | 0x7f08050e | 15349 |
| `scankit_ic_back_mirroring` | int | 0x7f08050f | 15352 |
| `scankit_ic_light_off` | int | 0x7f080510 | 15355 |
| `scankit_ic_light_on` | int | 0x7f080511 | 15358 |
| `scankit_ic_photo` | int | 0x7f080512 | 15361 |
| `scankit_photo` | int | 0x7f080513 | 15364 |
| `scankit_scan_light` | int | 0x7f080514 | 15367 |
| `scankit_scan_tail` | int | 0x7f080515 | 15370 |
| `screenshot_playback` | int | 0x7f08051a | 15373 |
| `seek_bar_bg` | int | 0x7f08051b | 15376 |
| `sel` | int | 0x7f08051e | 15379 |
| `selector_checkbox` | int | 0x7f08052b | 15382 |
| `selector_full_screen` | int | 0x7f080530 | 15385 |
| `selector_microphone_icon` | int | 0x7f080538 | 15388 |
| `selector_pickerview_btn` | int | 0x7f08053b | 15391 |
| `selector_switch` | int | 0x7f080544 | 15394 |
| `selector_tab_circle` | int | 0x7f080545 | 15397 |
| `setting_4g_added` | int | 0x7f080555 | 15400 |
| `setting_add_device_scan` | int | 0x7f080556 | 15403 |
| `setting_arrow` | int | 0x7f080557 | 15406 |
| `setting_arrow_item` | int | 0x7f080558 | 15409 |
| `setting_assistant` | int | 0x7f080559 | 15412 |
| `setting_assistant_control` | int | 0x7f08055a | 15415 |
| `setting_black` | int | 0x7f08055b | 15418 |
| `setting_cloud` | int | 0x7f08055c | 15421 |
| `setting_copy` | int | 0x7f08055d | 15424 |
| `setting_edit` | int | 0x7f08055e | 15427 |
| `setting_electronic_fence_top` | int | 0x7f08055f | 15430 |
| `setting_factory_restore` | int | 0x7f080560 | 15433 |
| `setting_format_storage` | int | 0x7f080561 | 15436 |
| `setting_menu` | int | 0x7f080562 | 15439 |
| `setting_notice` | int | 0x7f080563 | 15442 |
| `setting_parking` | int | 0x7f080564 | 15445 |
| `setting_photo_preview` | int | 0x7f080565 | 15448 |
| `setting_pwd_close_eyes` | int | 0x7f080566 | 15451 |
| `setting_pwd_open_eyes` | int | 0x7f080567 | 15454 |
| `setting_radio_checked` | int | 0x7f080568 | 15457 |
| `setting_radio_uncheck` | int | 0x7f080569 | 15460 |
| `setting_scan_close` | int | 0x7f08056a | 15463 |
| `setting_scan_close_black` | int | 0x7f08056b | 15466 |
| `setting_share` | int | 0x7f08056c | 15469 |
| `setting_system` | int | 0x7f08056d | 15472 |
| `setting_video` | int | 0x7f08056e | 15475 |
| `setting_voice` | int | 0x7f08056f | 15478 |
| `setting_voice_add` | int | 0x7f080570 | 15481 |
| `setting_voice_sub` | int | 0x7f080571 | 15484 |
| `setting_white` | int | 0x7f080572 | 15487 |
| `setting_wifi` | int | 0x7f080573 | 15490 |
| `shadow` | int | 0x7f080576 | 15493 |
| `shadow_bottom` | int | 0x7f080577 | 15496 |
| `shadow_left` | int | 0x7f080578 | 15499 |
| `shadow_right` | int | 0x7f080579 | 15502 |
| `shadow_top` | int | 0x7f08057a | 15505 |
| `shape_bottom_sheet_dialog_bg` | int | 0x7f08057f | 15508 |
| `shape_checkbox_off` | int | 0x7f080580 | 15511 |
| `shape_checkbox_on` | int | 0x7f080581 | 15514 |
| `shape_connection_button` | int | 0x7f080582 | 15517 |
| `shape_delay_num_button` | int | 0x7f080583 | 15520 |
| `shape_normal_button` | int | 0x7f08058f | 15523 |
| `shape_snack_bar_bg` | int | 0x7f080596 | 15526 |
| `share_photo_previe` | int | 0x7f080599 | 15529 |
| `share_white` | int | 0x7f08059a | 15532 |
| `stop_record_gray` | int | 0x7f0805a3 | 15535 |
| `test_level_drawable` | int | 0x7f0805ab | 15538 |
| `text_indicator` | int | 0x7f0805ac | 15541 |
| `text_indicator_black` | int | 0x7f0805ad | 15544 |
| `tooltip_frame_dark` | int | 0x7f0805b9 | 15547 |
| `tooltip_frame_light` | int | 0x7f0805ba | 15550 |
| `ucrop_crop` | int | 0x7f0805cc | 15553 |
| `ucrop_ic_angle` | int | 0x7f0805cd | 15556 |
| `ucrop_ic_crop` | int | 0x7f0805ce | 15559 |
| `ucrop_ic_crop_unselected` | int | 0x7f0805cf | 15562 |
| `ucrop_ic_cross` | int | 0x7f0805d0 | 15565 |
| `ucrop_ic_done` | int | 0x7f0805d1 | 15568 |
| `ucrop_ic_next` | int | 0x7f0805d2 | 15571 |
| `ucrop_ic_reset` | int | 0x7f0805d3 | 15574 |
| `ucrop_ic_rotate` | int | 0x7f0805d4 | 15577 |
| `ucrop_ic_rotate_unselected` | int | 0x7f0805d5 | 15580 |
| `ucrop_ic_scale` | int | 0x7f0805d6 | 15583 |
| `ucrop_ic_scale_unselected` | int | 0x7f0805d7 | 15586 |
| `ucrop_rotate` | int | 0x7f0805d8 | 15589 |
| `ucrop_scale` | int | 0x7f0805d9 | 15592 |
| `ucrop_shadow_upside` | int | 0x7f0805da | 15595 |
| `ucrop_vector_ic_crop` | int | 0x7f0805db | 15598 |
| `ucrop_vector_loader` | int | 0x7f0805dc | 15601 |
| `ucrop_vector_loader_animated` | int | 0x7f0805dd | 15604 |
| `ucrop_wrapper_controls_shape` | int | 0x7f0805de | 15607 |
| `unlock` | int | 0x7f0805df | 15610 |
| `video_back` | int | 0x7f08061e | 15613 |
| `video_backward_icon` | int | 0x7f08061f | 15616 |
| `video_brightness_6_white_36dp` | int | 0x7f080620 | 15619 |
| `video_click_error_selector` | int | 0x7f080621 | 15622 |
| `video_click_pause_selector` | int | 0x7f080622 | 15625 |
| `video_click_play_selector` | int | 0x7f080623 | 15628 |
| `video_dialog_progress` | int | 0x7f080624 | 15631 |
| `video_dialog_progress_bg` | int | 0x7f080625 | 15634 |
| `video_enlarge` | int | 0x7f080626 | 15637 |
| `video_error_normal` | int | 0x7f080627 | 15640 |
| `video_error_pressed` | int | 0x7f080628 | 15643 |
| `video_fast_search_nomal` | int | 0x7f080629 | 15646 |
| `video_forward_icon` | int | 0x7f08062a | 15649 |
| `video_jump_btn_bg` | int | 0x7f08062c | 15652 |
| `video_loading` | int | 0x7f08062d | 15655 |
| `video_loading_bg` | int | 0x7f08062e | 15658 |
| `video_pause_normal` | int | 0x7f080633 | 15661 |
| `video_pause_pressed` | int | 0x7f080634 | 15664 |
| `video_play_normal` | int | 0x7f080635 | 15667 |
| `video_play_pressed` | int | 0x7f080636 | 15670 |
| `video_progress` | int | 0x7f080637 | 15673 |
| `video_seek_progress` | int | 0x7f08063b | 15676 |
| `video_seek_thumb` | int | 0x7f08063c | 15679 |
| `video_seek_thumb_normal` | int | 0x7f08063d | 15682 |
| `video_seek_thumb_pressed` | int | 0x7f08063e | 15685 |
| `video_shrink` | int | 0x7f08063f | 15688 |
| `video_small_close` | int | 0x7f080640 | 15691 |
| `video_title_bg` | int | 0x7f080643 | 15694 |
| `video_volume_icon` | int | 0x7f080646 | 15697 |
| `video_volume_progress_bg` | int | 0x7f080647 | 15700 |
| `white_shape` | int | 0x7f080650 | 15703 |
| `wmv` | int | 0x7f080654 | 15706 |

### `com.gku.xtugo.R$font`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `roboto_medium_numbers` | int | 0x7f090000 | 15716 |

### `com.gku.xtugo.R$id`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `aboutFragment` | int | 0x7f0a003b | 16970 |
| `above` | int | 0x7f0a003d | 16973 |
| `accelerate` | int | 0x7f0a003e | 16976 |
| `accessibility_action_clickable_span` | int | 0x7f0a003f | 16979 |
| `accessibility_custom_action_0` | int | 0x7f0a0040 | 16982 |
| `accessibility_custom_action_1` | int | 0x7f0a0041 | 16985 |
| `accessibility_custom_action_10` | int | 0x7f0a0042 | 16988 |
| `accessibility_custom_action_11` | int | 0x7f0a0043 | 16991 |
| `accessibility_custom_action_12` | int | 0x7f0a0044 | 16994 |
| `accessibility_custom_action_13` | int | 0x7f0a0045 | 16997 |
| `accessibility_custom_action_14` | int | 0x7f0a0046 | 17000 |
| `accessibility_custom_action_15` | int | 0x7f0a0047 | 17003 |
| `accessibility_custom_action_16` | int | 0x7f0a0048 | 17006 |
| `accessibility_custom_action_17` | int | 0x7f0a0049 | 17009 |
| `accessibility_custom_action_18` | int | 0x7f0a004a | 17012 |
| `accessibility_custom_action_19` | int | 0x7f0a004b | 17015 |
| `accessibility_custom_action_2` | int | 0x7f0a004c | 17018 |
| `accessibility_custom_action_20` | int | 0x7f0a004d | 17021 |
| `accessibility_custom_action_21` | int | 0x7f0a004e | 17024 |
| `accessibility_custom_action_22` | int | 0x7f0a004f | 17027 |
| `accessibility_custom_action_23` | int | 0x7f0a0050 | 17030 |
| `accessibility_custom_action_24` | int | 0x7f0a0051 | 17033 |
| `accessibility_custom_action_25` | int | 0x7f0a0052 | 17036 |
| `accessibility_custom_action_26` | int | 0x7f0a0053 | 17039 |
| `accessibility_custom_action_27` | int | 0x7f0a0054 | 17042 |
| `accessibility_custom_action_28` | int | 0x7f0a0055 | 17045 |
| `accessibility_custom_action_29` | int | 0x7f0a0056 | 17048 |
| `accessibility_custom_action_3` | int | 0x7f0a0057 | 17051 |
| `accessibility_custom_action_30` | int | 0x7f0a0058 | 17054 |
| `accessibility_custom_action_31` | int | 0x7f0a0059 | 17057 |
| `accessibility_custom_action_4` | int | 0x7f0a005a | 17060 |
| `accessibility_custom_action_5` | int | 0x7f0a005b | 17063 |
| `accessibility_custom_action_6` | int | 0x7f0a005c | 17066 |
| `accessibility_custom_action_7` | int | 0x7f0a005d | 17069 |
| `accessibility_custom_action_8` | int | 0x7f0a005e | 17072 |
| `accessibility_custom_action_9` | int | 0x7f0a005f | 17075 |
| `action_bar` | int | 0x7f0a0064 | 17090 |
| `action_bar_activity_content` | int | 0x7f0a0065 | 17093 |
| `action_bar_container` | int | 0x7f0a0066 | 17096 |
| `action_bar_root` | int | 0x7f0a0067 | 17099 |
| `action_bar_spinner` | int | 0x7f0a0068 | 17102 |
| `action_bar_subtitle` | int | 0x7f0a0069 | 17105 |
| `action_bar_title` | int | 0x7f0a006a | 17108 |
| `action_container` | int | 0x7f0a006b | 17111 |
| `action_context_bar` | int | 0x7f0a006c | 17114 |
| `action_divider` | int | 0x7f0a006e | 17117 |
| `action_image` | int | 0x7f0a0070 | 17120 |
| `action_menu_divider` | int | 0x7f0a0071 | 17123 |
| `action_menu_presenter` | int | 0x7f0a0072 | 17126 |
| `action_mode_bar` | int | 0x7f0a0073 | 17129 |
| `action_mode_bar_stub` | int | 0x7f0a0074 | 17132 |
| `action_mode_close_button` | int | 0x7f0a0075 | 17135 |
| `action_text` | int | 0x7f0a0078 | 17138 |
| `action0` | int | 0x7f0a0060 | 17078 |
| `actionDown` | int | 0x7f0a0061 | 17081 |
| `actionDownUp` | int | 0x7f0a0062 | 17084 |
| `actions` | int | 0x7f0a007a | 17141 |
| `actionUp` | int | 0x7f0a0063 | 17087 |
| `activity_chooser_view_content` | int | 0x7f0a007b | 17144 |
| `activity_detail_player` | int | 0x7f0a007c | 17147 |
| `ad_full_id` | int | 0x7f0a007e | 17150 |
| `ad_small_id` | int | 0x7f0a007f | 17153 |
| `ad_time` | int | 0x7f0a0080 | 17156 |
| `add` | int | 0x7f0a0081 | 17159 |
| `adjust_height` | int | 0x7f0a0082 | 17162 |
| `adjust_width` | int | 0x7f0a0083 | 17165 |
| `alertTitle` | int | 0x7f0a0086 | 17168 |
| `aligned` | int | 0x7f0a0087 | 17171 |
| `all` | int | 0x7f0a0088 | 17174 |
| `allStates` | int | 0x7f0a0089 | 17177 |
| `ALT` | int | 0x7f0a0000 | 16856 |
| `always` | int | 0x7f0a008a | 17180 |
| `amu_text` | int | 0x7f0a0090 | 17183 |
| `androidx_window_activity_scope` | int | 0x7f0a0091 | 17186 |
| `animateToEnd` | int | 0x7f0a0093 | 17192 |
| `animateToStart` | int | 0x7f0a0094 | 17195 |
| `animView` | int | 0x7f0a0092 | 17189 |
| `anticipate` | int | 0x7f0a009c | 17201 |
| `antiClockwise` | int | 0x7f0a009b | 17198 |
| `app_video_brightness` | int | 0x7f0a009d | 17204 |
| `app_video_brightness_box` | int | 0x7f0a009e | 17207 |
| `app_video_brightness_icon` | int | 0x7f0a009f | 17210 |
| `arc` | int | 0x7f0a00a0 | 17213 |
| `asConfigured` | int | 0x7f0a00a4 | 17216 |
| `async` | int | 0x7f0a00a5 | 17219 |
| `auto` | int | 0x7f0a00a7 | 17222 |
| `auto_focus` | int | 0x7f0a00ac | 17234 |
| `autoComplete` | int | 0x7f0a00a8 | 17225 |
| `autoCompleteToEnd` | int | 0x7f0a00a9 | 17228 |
| `autoCompleteToStart` | int | 0x7f0a00aa | 17231 |
| `axisRelative` | int | 0x7f0a00ad | 17237 |
| `back` | int | 0x7f0a00ae | 17240 |
| `back_img_in` | int | 0x7f0a00b1 | 17243 |
| `back_layout` | int | 0x7f0a00b2 | 17246 |
| `back_layout_landscape` | int | 0x7f0a00b3 | 17249 |
| `back_tiny` | int | 0x7f0a00b4 | 17252 |
| `backspaceView` | int | 0x7f0a00b6 | 17255 |
| `barrier` | int | 0x7f0a00b7 | 17258 |
| `baseline` | int | 0x7f0a00b8 | 17261 |
| `BaseQuickAdapter_databinding_support` | int | 0x7f0a0005 | 16865 |
| `BaseQuickAdapter_dragging_support` | int | 0x7f0a0006 | 16868 |
| `BaseQuickAdapter_swiping_support` | int | 0x7f0a0007 | 16871 |
| `BaseQuickAdapter_viewholder_support` | int | 0x7f0a0008 | 16874 |
| `beginning` | int | 0x7f0a00bc | 17267 |
| `beginOnFirstDraw` | int | 0x7f0a00bb | 17264 |
| `below` | int | 0x7f0a00bd | 17270 |
| `bestChoice` | int | 0x7f0a00be | 17273 |
| `bl_tr` | int | 0x7f0a00bf | 17276 |
| `blocking` | int | 0x7f0a00c1 | 17279 |
| `both_month_week_view` | int | 0x7f0a00cb | 17282 |
| `bottom` | int | 0x7f0a00cc | 17285 |
| `BOTTOM_END` | int | 0x7f0a0003 | 16859 |
| `bottom_line` | int | 0x7f0a00cf | 17288 |
| `bottom_nar_bar` | int | 0x7f0a00d1 | 17291 |
| `bottom_progressbar` | int | 0x7f0a00d4 | 17294 |
| `BOTTOM_START` | int | 0x7f0a0004 | 16862 |
| `bottom_top` | int | 0x7f0a00d7 | 17297 |
| `bounce` | int | 0x7f0a00da | 17300 |
| `bounceBoth` | int | 0x7f0a00db | 17303 |
| `bounceEnd` | int | 0x7f0a00dc | 17306 |
| `bounceStart` | int | 0x7f0a00dd | 17309 |
| `br_tl` | int | 0x7f0a00de | 17312 |
| `bt_back` | int | 0x7f0a00e0 | 17315 |
| `btn_cancel` | int | 0x7f0a00f3 | 17330 |
| `btn_commit` | int | 0x7f0a00f5 | 17333 |
| `btnCancel` | int | 0x7f0a00e4 | 17318 |
| `btnCheck` | int | 0x7f0a00e7 | 17321 |
| `btnOk` | int | 0x7f0a00ed | 17324 |
| `btnSubmit` | int | 0x7f0a00ef | 17327 |
| `buttonPanel` | int | 0x7f0a010b | 17336 |
| `cache_measures` | int | 0x7f0a010e | 17339 |
| `callMeasure` | int | 0x7f0a010f | 17342 |
| `cancel_action` | int | 0x7f0a011d | 17348 |
| `cancel_button` | int | 0x7f0a0121 | 17351 |
| `cancelButton` | int | 0x7f0a011c | 17345 |
| `carryVelocity` | int | 0x7f0a0124 | 17354 |
| `cb_original` | int | 0x7f0a0126 | 17357 |
| `center` | int | 0x7f0a0127 | 17360 |
| `center_horizontal` | int | 0x7f0a012a | 17369 |
| `center_vertical` | int | 0x7f0a012d | 17372 |
| `centerCrop` | int | 0x7f0a0128 | 17363 |
| `centerInside` | int | 0x7f0a0129 | 17366 |
| `chain` | int | 0x7f0a012e | 17375 |
| `chain2` | int | 0x7f0a012f | 17378 |
| `chains` | int | 0x7f0a0130 | 17381 |
| `checkbox` | int | 0x7f0a0132 | 17384 |
| `checked` | int | 0x7f0a0133 | 17387 |
| `chronometer` | int | 0x7f0a0134 | 17390 |
| `circle_center` | int | 0x7f0a0136 | 17393 |
| `classic` | int | 0x7f0a0137 | 17396 |
| `clear_text` | int | 0x7f0a013a | 17399 |
| `clip_horizontal` | int | 0x7f0a013c | 17402 |
| `clip_vertical` | int | 0x7f0a013d | 17405 |
| `clockwise` | int | 0x7f0a013e | 17408 |
| `closeButton` | int | 0x7f0a013f | 17411 |
| `closest` | int | 0x7f0a0140 | 17414 |
| `collapseActionView` | int | 0x7f0a0141 | 17417 |
| `compatible` | int | 0x7f0a0142 | 17420 |
| `compress` | int | 0x7f0a0143 | 17423 |
| `confirm_button` | int | 0x7f0a0144 | 17426 |
| `connectionFragment` | int | 0x7f0a014a | 17429 |
| `constraint` | int | 0x7f0a014b | 17432 |
| `container` | int | 0x7f0a014e | 17435 |
| `content_container` | int | 0x7f0a0152 | 17444 |
| `contentPanel` | int | 0x7f0a0150 | 17438 |
| `contentView` | int | 0x7f0a0151 | 17441 |
| `contiguous` | int | 0x7f0a0154 | 17447 |
| `continuousVelocity` | int | 0x7f0a0155 | 17450 |
| `controlParent` | int | 0x7f0a0156 | 17453 |
| `controls_shadow` | int | 0x7f0a0157 | 17456 |
| `controls_wrapper` | int | 0x7f0a0158 | 17459 |
| `coordinator` | int | 0x7f0a0159 | 17462 |
| `cos` | int | 0x7f0a015b | 17465 |
| `counterclockwise` | int | 0x7f0a015c | 17468 |
| `cradle` | int | 0x7f0a015d | 17471 |
| `CTRL` | int | 0x7f0a0009 | 16877 |
| `current` | int | 0x7f0a015e | 17474 |
| `currentState` | int | 0x7f0a015f | 17477 |
| `custom` | int | 0x7f0a0160 | 17480 |
| `customPanel` | int | 0x7f0a0161 | 17483 |
| `cut` | int | 0x7f0a0166 | 17486 |
| `cy_centerCrop` | int | 0x7f0a0167 | 17489 |
| `cy_centerInside` | int | 0x7f0a0168 | 17492 |
| `dark` | int | 0x7f0a0169 | 17495 |
| `dataBinding` | int | 0x7f0a016a | 17498 |
| `date_picker_actions` | int | 0x7f0a016b | 17501 |
| `day` | int | 0x7f0a016c | 17504 |
| `decelerate` | int | 0x7f0a016d | 17507 |
| `decelerateAndComplete` | int | 0x7f0a016e | 17510 |
| `decor_content_parent` | int | 0x7f0a016f | 17513 |
| `default_activity_button` | int | 0x7f0a0170 | 17516 |
| `default_mode` | int | 0x7f0a0171 | 17519 |
| `deltaRelative` | int | 0x7f0a0179 | 17522 |
| `dependency_ordering` | int | 0x7f0a017a | 17525 |
| `design_bottom_sheet` | int | 0x7f0a017b | 17528 |
| `design_menu_item_action_area` | int | 0x7f0a017c | 17531 |
| `design_menu_item_action_area_stub` | int | 0x7f0a017d | 17534 |
| `design_menu_item_text` | int | 0x7f0a017e | 17537 |
| `design_navigation_view` | int | 0x7f0a017f | 17540 |
| `detail_player` | int | 0x7f0a0182 | 17543 |
| `dialog_button` | int | 0x7f0a0189 | 17549 |
| `dialog_negative` | int | 0x7f0a018e | 17552 |
| `dialog_positive` | int | 0x7f0a018f | 17555 |
| `dialog_sure_btn` | int | 0x7f0a0191 | 17558 |
| `dialog_tilte` | int | 0x7f0a0192 | 17561 |
| `dialogMessage` | int | 0x7f0a0186 | 17546 |
| `dimensions` | int | 0x7f0a019b | 17564 |
| `direct` | int | 0x7f0a019c | 17567 |
| `disabled` | int | 0x7f0a01a1 | 17582 |
| `disableHome` | int | 0x7f0a019d | 17570 |
| `disableIntraAutoTransition` | int | 0x7f0a019e | 17573 |
| `disablePostScroll` | int | 0x7f0a019f | 17576 |
| `disableScroll` | int | 0x7f0a01a0 | 17579 |
| `disjoint` | int | 0x7f0a01a3 | 17585 |
| `doneButton` | int | 0x7f0a01a9 | 17588 |
| `dragAnticlockwise` | int | 0x7f0a01b0 | 17591 |
| `dragClockwise` | int | 0x7f0a01b1 | 17594 |
| `dragDown` | int | 0x7f0a01b2 | 17597 |
| `dragEnd` | int | 0x7f0a01b3 | 17600 |
| `dragLeft` | int | 0x7f0a01b4 | 17603 |
| `dragRight` | int | 0x7f0a01b5 | 17606 |
| `dragStart` | int | 0x7f0a01b6 | 17609 |
| `dragUp` | int | 0x7f0a01b7 | 17612 |
| `dropdown_menu` | int | 0x7f0a01b8 | 17615 |
| `duration_image_tip` | int | 0x7f0a01ba | 17621 |
| `duration_progressbar` | int | 0x7f0a01bb | 17624 |
| `durationTextView` | int | 0x7f0a01b9 | 17618 |
| `easeIn` | int | 0x7f0a01bc | 17627 |
| `easeInOut` | int | 0x7f0a01bd | 17630 |
| `easeOut` | int | 0x7f0a01be | 17633 |
| `east` | int | 0x7f0a01bf | 17636 |
| `edge` | int | 0x7f0a01c0 | 17639 |
| `edit_query` | int | 0x7f0a01c4 | 17642 |
| `edit_text_id` | int | 0x7f0a01c5 | 17645 |
| `elastic` | int | 0x7f0a01c8 | 17648 |
| `embed` | int | 0x7f0a01c9 | 17651 |
| `end` | int | 0x7f0a01ca | 17654 |
| `end_padder` | int | 0x7f0a01cc | 17660 |
| `endToStart` | int | 0x7f0a01cb | 17657 |
| `enterAlways` | int | 0x7f0a01ce | 17663 |
| `enterAlwaysCollapsed` | int | 0x7f0a01cf | 17666 |
| `exitUntilCollapsed` | int | 0x7f0a01e5 | 17669 |
| `exo_ad_overlay` | int | 0x7f0a01e7 | 17672 |
| `exo_artwork` | int | 0x7f0a01e8 | 17675 |
| `exo_audio_track` | int | 0x7f0a01e9 | 17678 |
| `exo_basic_controls` | int | 0x7f0a01ea | 17681 |
| `exo_bottom_bar` | int | 0x7f0a01eb | 17684 |
| `exo_buffering` | int | 0x7f0a01ec | 17687 |
| `exo_center_controls` | int | 0x7f0a01ed | 17690 |
| `exo_check` | int | 0x7f0a01ee | 17693 |
| `exo_content_frame` | int | 0x7f0a01ef | 17696 |
| `exo_controller` | int | 0x7f0a01f0 | 17699 |
| `exo_controller_placeholder` | int | 0x7f0a01f1 | 17702 |
| `exo_controls_background` | int | 0x7f0a01f2 | 17705 |
| `exo_duration` | int | 0x7f0a01f3 | 17708 |
| `exo_error_message` | int | 0x7f0a01f4 | 17711 |
| `exo_extra_controls` | int | 0x7f0a01f5 | 17714 |
| `exo_extra_controls_scroll_view` | int | 0x7f0a01f6 | 17717 |
| `exo_ffwd` | int | 0x7f0a01f7 | 17720 |
| `exo_ffwd_with_amount` | int | 0x7f0a01f8 | 17723 |
| `exo_fullscreen` | int | 0x7f0a01f9 | 17726 |
| `exo_icon` | int | 0x7f0a01fa | 17729 |
| `exo_main_text` | int | 0x7f0a01fb | 17732 |
| `exo_minimal_controls` | int | 0x7f0a01fc | 17735 |
| `exo_minimal_fullscreen` | int | 0x7f0a01fd | 17738 |
| `exo_next` | int | 0x7f0a01fe | 17741 |
| `exo_overflow_hide` | int | 0x7f0a01ff | 17744 |
| `exo_overflow_show` | int | 0x7f0a0200 | 17747 |
| `exo_overlay` | int | 0x7f0a0201 | 17750 |
| `exo_pause` | int | 0x7f0a0202 | 17753 |
| `exo_play` | int | 0x7f0a0203 | 17756 |
| `exo_play_pause` | int | 0x7f0a0204 | 17759 |
| `exo_playback_speed` | int | 0x7f0a0205 | 17762 |
| `exo_position` | int | 0x7f0a0206 | 17765 |
| `exo_prev` | int | 0x7f0a0207 | 17768 |
| `exo_progress` | int | 0x7f0a0208 | 17771 |
| `exo_progress_placeholder` | int | 0x7f0a0209 | 17774 |
| `exo_repeat_toggle` | int | 0x7f0a020a | 17777 |
| `exo_rew` | int | 0x7f0a020b | 17780 |
| `exo_rew_with_amount` | int | 0x7f0a020c | 17783 |
| `exo_settings` | int | 0x7f0a020d | 17786 |
| `exo_settings_listview` | int | 0x7f0a020e | 17789 |
| `exo_shuffle` | int | 0x7f0a020f | 17792 |
| `exo_shutter` | int | 0x7f0a0210 | 17795 |
| `exo_sub_text` | int | 0x7f0a0211 | 17798 |
| `exo_subtitle` | int | 0x7f0a0212 | 17801 |
| `exo_subtitles` | int | 0x7f0a0213 | 17804 |
| `exo_text` | int | 0x7f0a0214 | 17807 |
| `exo_time` | int | 0x7f0a0215 | 17810 |
| `exo_track_selection_view` | int | 0x7f0a0216 | 17813 |
| `exo_vr` | int | 0x7f0a0217 | 17816 |
| `expand` | int | 0x7f0a0218 | 17819 |
| `expand_activities_button` | int | 0x7f0a0219 | 17822 |
| `expanded_menu` | int | 0x7f0a021a | 17825 |
| `fade` | int | 0x7f0a021b | 17828 |
| `fill` | int | 0x7f0a0221 | 17831 |
| `FILL` | int | 0x7f0a000a | 16880 |
| `FILL_AND_STROKE` | int | 0x7f0a000b | 16883 |
| `fill_horizontal` | int | 0x7f0a0225 | 17843 |
| `fill_vertical` | int | 0x7f0a0226 | 17846 |
| `fillCenter` | int | 0x7f0a0222 | 17834 |
| `filled` | int | 0x7f0a0227 | 17849 |
| `fillEnd` | int | 0x7f0a0223 | 17837 |
| `fillStart` | int | 0x7f0a0224 | 17840 |
| `first_day_of_month` | int | 0x7f0a022b | 17852 |
| `first_image` | int | 0x7f0a022c | 17855 |
| `fit` | int | 0x7f0a022d | 17858 |
| `fitCenter` | int | 0x7f0a022e | 17861 |
| `fitEnd` | int | 0x7f0a022f | 17864 |
| `fitStart` | int | 0x7f0a0230 | 17867 |
| `fitToContents` | int | 0x7f0a0231 | 17870 |
| `fitXY` | int | 0x7f0a0232 | 17873 |
| `fixed` | int | 0x7f0a0233 | 17876 |
| `fixed_height` | int | 0x7f0a0234 | 17879 |
| `fixed_width` | int | 0x7f0a0235 | 17882 |
| `FixedBehind` | int | 0x7f0a000d | 16889 |
| `FixedFront` | int | 0x7f0a000e | 16892 |
| `flash_light_layout` | int | 0x7f0a0239 | 17885 |
| `flash_light_ll` | int | 0x7f0a023a | 17888 |
| `flash_light_text` | int | 0x7f0a023b | 17891 |
| `flip` | int | 0x7f0a023c | 17894 |
| `floating` | int | 0x7f0a023d | 17897 |
| `folder_list` | int | 0x7f0a023e | 17900 |
| `follow_system` | int | 0x7f0a023f | 17903 |
| `forever` | int | 0x7f0a0240 | 17906 |
| `FourCircleLoadingView` | int | 0x7f0a000f | 16895 |
| `fragment` | int | 0x7f0a0242 | 17909 |
| `fragment_container` | int | 0x7f0a0243 | 17912 |
| `fragment_container_view_tag` | int | 0x7f0a0244 | 17915 |
| `frameContent` | int | 0x7f0a0245 | 17918 |
| `frost` | int | 0x7f0a0246 | 17921 |
| `full_id` | int | 0x7f0a0247 | 17924 |
| `fullscreen` | int | 0x7f0a0248 | 17927 |
| `fullscreen_header` | int | 0x7f0a0249 | 17930 |
| `FUNCTION` | int | 0x7f0a000c | 16886 |
| `gallery_Layout` | int | 0x7f0a024a | 17933 |
| `gallery_Layout_landscape` | int | 0x7f0a024b | 17936 |
| `ghost_view` | int | 0x7f0a024e | 17939 |
| `ghost_view_holder` | int | 0x7f0a024f | 17942 |
| `glide_custom_view_target_tag` | int | 0x7f0a0250 | 17945 |
| `gone` | int | 0x7f0a0251 | 17948 |
| `graph` | int | 0x7f0a0254 | 17951 |
| `graph_wrap` | int | 0x7f0a0255 | 17954 |
| `GridRefreshLayout` | int | 0x7f0a0010 | 16898 |
| `group_divider` | int | 0x7f0a0258 | 17957 |
| `grouping` | int | 0x7f0a0259 | 17960 |
| `groups` | int | 0x7f0a025a | 17963 |
| `guideline` | int | 0x7f0a025b | 17966 |
| `guideline2` | int | 0x7f0a025c | 17969 |
| `header_title` | int | 0x7f0a0260 | 17972 |
| `hide_ime_id` | int | 0x7f0a0262 | 17975 |
| `hideable` | int | 0x7f0a0263 | 17978 |
| `home` | int | 0x7f0a0265 | 17981 |
| `homeAsUp` | int | 0x7f0a0266 | 17984 |
| `homeFragment` | int | 0x7f0a0267 | 17987 |
| `honorRequest` | int | 0x7f0a0268 | 17990 |
| `horizontal` | int | 0x7f0a0269 | 17993 |
| `horizontal_only` | int | 0x7f0a026a | 17996 |
| `hour` | int | 0x7f0a026b | 17999 |
| `hourNameTextView` | int | 0x7f0a026c | 18002 |
| `hourTextView` | int | 0x7f0a026d | 18005 |
| `hybrid` | int | 0x7f0a026e | 18008 |
| `icon` | int | 0x7f0a028d | 18011 |
| `icon_group` | int | 0x7f0a028e | 18014 |
| `icon_only` | int | 0x7f0a028f | 18017 |
| `ifRoom` | int | 0x7f0a0294 | 18020 |
| `ignore` | int | 0x7f0a0295 | 18023 |
| `ignoreRequest` | int | 0x7f0a0296 | 18026 |
| `image` | int | 0x7f0a0298 | 18029 |
| `image_view_crop` | int | 0x7f0a02a5 | 18032 |
| `image_view_logo` | int | 0x7f0a02a6 | 18035 |
| `image_view_state_aspect_ratio` | int | 0x7f0a02a7 | 18038 |
| `image_view_state_rotate` | int | 0x7f0a02a8 | 18041 |
| `image_view_state_scale` | int | 0x7f0a02a9 | 18044 |
| `img_btn` | int | 0x7f0a02ae | 18047 |
| `immediateStop` | int | 0x7f0a02b4 | 18050 |
| `included` | int | 0x7f0a02b5 | 18053 |
| `indeterminate` | int | 0x7f0a02b6 | 18056 |
| `info` | int | 0x7f0a02b8 | 18059 |
| `INNER` | int | 0x7f0a0011 | 16901 |
| `inward` | int | 0x7f0a02bc | 18062 |
| `is_pooling_container_tag` | int | 0x7f0a02be | 18065 |
| `italic` | int | 0x7f0a02c4 | 18068 |
| `item_touch_helper_previous_elevation` | int | 0x7f0a02e0 | 18071 |
| `iv_download` | int | 0x7f0a0340 | 18092 |
| `iv_menu` | int | 0x7f0a034b | 18095 |
| `iv_play_back` | int | 0x7f0a034d | 18098 |
| `iv_play_fast` | int | 0x7f0a034e | 18101 |
| `iv_play_video` | int | 0x7f0a034f | 18104 |
| `ivEditor` | int | 0x7f0a02fa | 18074 |
| `ivFlash` | int | 0x7f0a02fb | 18077 |
| `ivFlashlight` | int | 0x7f0a02fc | 18080 |
| `ivImage` | int | 0x7f0a02fe | 18083 |
| `ivPicture` | int | 0x7f0a0314 | 18086 |
| `ivs` | int | 0x7f0a0359 | 18107 |
| `ivScan` | int | 0x7f0a031a | 18089 |
| `jump_ad` | int | 0x7f0a035c | 18116 |
| `jumpToEnd` | int | 0x7f0a035a | 18110 |
| `jumpToStart` | int | 0x7f0a035b | 18113 |
| `labeled` | int | 0x7f0a035d | 18119 |
| `last_select_day` | int | 0x7f0a035e | 18122 |
| `last_select_day_ignore_current` | int | 0x7f0a035f | 18125 |
| `layout` | int | 0x7f0a0361 | 18128 |
| `layout_about_app` | int | 0x7f0a0392 | 18131 |
| `layout_aspect_ratio` | int | 0x7f0a0393 | 18134 |
| `layout_bottom` | int | 0x7f0a0396 | 18137 |
| `layout_camera_update` | int | 0x7f0a0398 | 18140 |
| `layout_check` | int | 0x7f0a0399 | 18143 |
| `layout_delete` | int | 0x7f0a039d | 18146 |
| `layout_download` | int | 0x7f0a039e | 18149 |
| `layout_error` | int | 0x7f0a039f | 18152 |
| `layout_menu` | int | 0x7f0a03a2 | 18155 |
| `layout_privacy` | int | 0x7f0a03a4 | 18158 |
| `layout_progress_wheel` | int | 0x7f0a03a6 | 18161 |
| `layout_rotate_wheel` | int | 0x7f0a03a8 | 18164 |
| `layout_scale_wheel` | int | 0x7f0a03a9 | 18167 |
| `layout_top` | int | 0x7f0a03b9 | 18170 |
| `layout_user_agreement` | int | 0x7f0a03bb | 18173 |
| `left` | int | 0x7f0a03bc | 18176 |
| `left_right` | int | 0x7f0a03bf | 18182 |
| `leftToRight` | int | 0x7f0a03bd | 18179 |
| `legacy` | int | 0x7f0a03c0 | 18185 |
| `light` | int | 0x7f0a03c1 | 18188 |
| `line` | int | 0x7f0a03c2 | 18191 |
| `line1` | int | 0x7f0a03c3 | 18194 |
| `line3` | int | 0x7f0a03c4 | 18197 |
| `linear` | int | 0x7f0a03c5 | 18200 |
| `linear_gradient` | int | 0x7f0a03c6 | 18203 |
| `list_item` | int | 0x7f0a03ca | 18209 |
| `listMode` | int | 0x7f0a03c8 | 18206 |
| `live_progress_cancel` | int | 0x7f0a03cc | 18212 |
| `ll_play_menu` | int | 0x7f0a03da | 18215 |
| `ll_week` | int | 0x7f0a03e5 | 18218 |
| `load_more_load_complete_view` | int | 0x7f0a03e6 | 18221 |
| `load_more_load_end_view` | int | 0x7f0a03e7 | 18224 |
| `load_more_load_fail_view` | int | 0x7f0a03e8 | 18227 |
| `load_more_loading_view` | int | 0x7f0a03e9 | 18230 |
| `loading` | int | 0x7f0a03ea | 18233 |
| `loading_progress` | int | 0x7f0a03ec | 18236 |
| `loading_text` | int | 0x7f0a03ed | 18239 |
| `localAlbumFragment` | int | 0x7f0a03ee | 18242 |
| `locale` | int | 0x7f0a03fb | 18245 |
| `lock_screen` | int | 0x7f0a03ff | 18248 |
| `ltr` | int | 0x7f0a0406 | 18251 |
| `m3_side_sheet` | int | 0x7f0a0407 | 18254 |
| `magical` | int | 0x7f0a040a | 18257 |
| `main` | int | 0x7f0a040b | 18260 |
| `marquee` | int | 0x7f0a0410 | 18263 |
| `masked` | int | 0x7f0a0411 | 18266 |
| `match_constraint` | int | 0x7f0a0412 | 18269 |
| `match_parent` | int | 0x7f0a0413 | 18272 |
| `MatchLayout` | int | 0x7f0a0016 | 16907 |
| `material_clock_display` | int | 0x7f0a0414 | 18275 |
| `material_clock_display_and_toggle` | int | 0x7f0a0415 | 18278 |
| `material_clock_face` | int | 0x7f0a0416 | 18281 |
| `material_clock_hand` | int | 0x7f0a0417 | 18284 |
| `material_clock_level` | int | 0x7f0a0418 | 18287 |
| `material_clock_period_am_button` | int | 0x7f0a0419 | 18290 |
| `material_clock_period_pm_button` | int | 0x7f0a041a | 18293 |
| `material_clock_period_toggle` | int | 0x7f0a041b | 18296 |
| `material_hour_text_input` | int | 0x7f0a041c | 18299 |
| `material_hour_tv` | int | 0x7f0a041d | 18302 |
| `material_label` | int | 0x7f0a041e | 18305 |
| `material_minute_text_input` | int | 0x7f0a041f | 18308 |
| `material_minute_tv` | int | 0x7f0a0420 | 18311 |
| `material_textinput_timepicker` | int | 0x7f0a0421 | 18314 |
| `material_timepicker_cancel_button` | int | 0x7f0a0422 | 18317 |
| `material_timepicker_container` | int | 0x7f0a0423 | 18320 |
| `material_timepicker_mode_button` | int | 0x7f0a0424 | 18323 |
| `material_timepicker_ok_button` | int | 0x7f0a0425 | 18326 |
| `material_timepicker_view` | int | 0x7f0a0426 | 18329 |
| `material_value_index` | int | 0x7f0a0427 | 18332 |
| `matrix` | int | 0x7f0a0428 | 18335 |
| `media_actions` | int | 0x7f0a042f | 18338 |
| `media_controller_compat_view_tag` | int | 0x7f0a0430 | 18341 |
| `menu_crop` | int | 0x7f0a043b | 18359 |
| `menu_loader` | int | 0x7f0a043c | 18362 |
| `menuDelete` | int | 0x7f0a0436 | 18344 |
| `menuDownload` | int | 0x7f0a0437 | 18347 |
| `menuSelectAll` | int | 0x7f0a0438 | 18350 |
| `menuSelectViewOn` | int | 0x7f0a0439 | 18353 |
| `menuShare` | int | 0x7f0a043a | 18356 |
| `META` | int | 0x7f0a0015 | 16904 |
| `middle` | int | 0x7f0a0447 | 18365 |
| `min` | int | 0x7f0a0448 | 18368 |
| `mini` | int | 0x7f0a044a | 18371 |
| `minuteNameTextView` | int | 0x7f0a044b | 18374 |
| `minuteTextView` | int | 0x7f0a044c | 18377 |
| `mode_all` | int | 0x7f0a0450 | 18380 |
| `mode_fix` | int | 0x7f0a0451 | 18383 |
| `mode_only_current` | int | 0x7f0a0452 | 18386 |
| `mon` | int | 0x7f0a0455 | 18389 |
| `month` | int | 0x7f0a0456 | 18392 |
| `month_grid` | int | 0x7f0a0457 | 18395 |
| `month_navigation_bar` | int | 0x7f0a0458 | 18398 |
| `month_navigation_fragment_toggle` | int | 0x7f0a0459 | 18401 |
| `month_navigation_next` | int | 0x7f0a045a | 18404 |
| `month_navigation_previous` | int | 0x7f0a045b | 18407 |
| `month_title` | int | 0x7f0a045c | 18410 |
| `motion_base` | int | 0x7f0a045f | 18413 |
| `mtrl_anchor_parent` | int | 0x7f0a0460 | 18416 |
| `mtrl_calendar_day_selector_frame` | int | 0x7f0a0461 | 18419 |
| `mtrl_calendar_days_of_week` | int | 0x7f0a0462 | 18422 |
| `mtrl_calendar_frame` | int | 0x7f0a0463 | 18425 |
| `mtrl_calendar_main_pane` | int | 0x7f0a0464 | 18428 |
| `mtrl_calendar_months` | int | 0x7f0a0465 | 18431 |
| `mtrl_calendar_selection_frame` | int | 0x7f0a0466 | 18434 |
| `mtrl_calendar_text_input_frame` | int | 0x7f0a0467 | 18437 |
| `mtrl_calendar_year_selector_frame` | int | 0x7f0a0468 | 18440 |
| `mtrl_card_checked_layer_id` | int | 0x7f0a0469 | 18443 |
| `mtrl_child_content_container` | int | 0x7f0a046a | 18446 |
| `mtrl_internal_children_alpha_tag` | int | 0x7f0a046b | 18449 |
| `mtrl_motion_snapshot_view` | int | 0x7f0a046c | 18452 |
| `mtrl_picker_fullscreen` | int | 0x7f0a046d | 18455 |
| `mtrl_picker_header` | int | 0x7f0a046e | 18458 |
| `mtrl_picker_header_selection_text` | int | 0x7f0a046f | 18461 |
| `mtrl_picker_header_title_and_selection` | int | 0x7f0a0470 | 18464 |
| `mtrl_picker_header_toggle` | int | 0x7f0a0471 | 18467 |
| `mtrl_picker_text_input_date` | int | 0x7f0a0472 | 18470 |
| `mtrl_picker_text_input_range_end` | int | 0x7f0a0473 | 18473 |
| `mtrl_picker_text_input_range_start` | int | 0x7f0a0474 | 18476 |
| `mtrl_picker_title_text` | int | 0x7f0a0475 | 18479 |
| `mtrl_view_tag_bottom_padding` | int | 0x7f0a0476 | 18482 |
| `multi_mode` | int | 0x7f0a0477 | 18485 |
| `multiply` | int | 0x7f0a0479 | 18488 |
| `music_seek_bar` | int | 0x7f0a047a | 18491 |
| `n_a_v_i_g_a_t_i_o_n_b_a_r` | int | 0x7f0a047b | 18494 |
| `nav_controller_view_tag` | int | 0x7f0a047c | 18497 |
| `nav_home` | int | 0x7f0a047d | 18500 |
| `nav_host_fragment_container` | int | 0x7f0a047e | 18503 |
| `navigation_bar_item_active_indicator_view` | int | 0x7f0a0482 | 18506 |
| `navigation_bar_item_icon_container` | int | 0x7f0a0483 | 18509 |
| `navigation_bar_item_icon_view` | int | 0x7f0a0484 | 18512 |
| `navigation_bar_item_labels_group` | int | 0x7f0a0485 | 18515 |
| `navigation_bar_item_large_label_view` | int | 0x7f0a0486 | 18518 |
| `navigation_bar_item_small_label_view` | int | 0x7f0a0487 | 18521 |
| `navigation_header_container` | int | 0x7f0a0488 | 18524 |
| `never` | int | 0x7f0a0489 | 18527 |
| `neverCompleteToEnd` | int | 0x7f0a048a | 18530 |
| `neverCompleteToStart` | int | 0x7f0a048b | 18533 |
| `NO_DEBUG` | int | 0x7f0a0019 | 16913 |
| `none` | int | 0x7f0a0490 | 18542 |
| `normal` | int | 0x7f0a0491 | 18545 |
| `NORMAL` | int | 0x7f0a0018 | 16910 |
| `normalItemView` | int | 0x7f0a0492 | 18548 |
| `normalRadioButton` | int | 0x7f0a0493 | 18551 |
| `normalTitleView` | int | 0x7f0a0494 | 18554 |
| `north` | int | 0x7f0a0495 | 18557 |
| `noScroll` | int | 0x7f0a048d | 18536 |
| `noState` | int | 0x7f0a048e | 18539 |
| `notification_background` | int | 0x7f0a0497 | 18560 |
| `notification_main_column` | int | 0x7f0a0498 | 18563 |
| `notification_main_column_container` | int | 0x7f0a0499 | 18566 |
| `number0View` | int | 0x7f0a049b | 18572 |
| `number1View` | int | 0x7f0a049c | 18575 |
| `number2View` | int | 0x7f0a049d | 18578 |
| `number3View` | int | 0x7f0a049e | 18581 |
| `number4View` | int | 0x7f0a049f | 18584 |
| `number5View` | int | 0x7f0a04a0 | 18587 |
| `number6View` | int | 0x7f0a04a1 | 18590 |
| `number7View` | int | 0x7f0a04a2 | 18593 |
| `number8View` | int | 0x7f0a04a3 | 18596 |
| `number9View` | int | 0x7f0a04a4 | 18599 |
| `numRate` | int | 0x7f0a049a | 18569 |
| `off` | int | 0x7f0a04a6 | 18602 |
| `offItemView` | int | 0x7f0a04a7 | 18605 |
| `offRadioButton` | int | 0x7f0a04a8 | 18608 |
| `offTitleView` | int | 0x7f0a04a9 | 18611 |
| `okButton` | int | 0x7f0a04ab | 18614 |
| `on` | int | 0x7f0a04ac | 18617 |
| `onAttachStateChangeListener` | int | 0x7f0a04ad | 18620 |
| `onDateChanged` | int | 0x7f0a04ae | 18623 |
| `one` | int | 0x7f0a04b0 | 18629 |
| `onInterceptTouchReturnSwipe` | int | 0x7f0a04af | 18626 |
| `only_month_view` | int | 0x7f0a04b1 | 18632 |
| `only_week_view` | int | 0x7f0a04b2 | 18635 |
| `open_search_bar_text_view` | int | 0x7f0a04b4 | 18638 |
| `open_search_view_background` | int | 0x7f0a04b5 | 18641 |
| `open_search_view_clear_button` | int | 0x7f0a04b6 | 18644 |
| `open_search_view_content_container` | int | 0x7f0a04b7 | 18647 |
| `open_search_view_divider` | int | 0x7f0a04b8 | 18650 |
| `open_search_view_dummy_toolbar` | int | 0x7f0a04b9 | 18653 |
| `open_search_view_edit_text` | int | 0x7f0a04ba | 18656 |
| `open_search_view_header_container` | int | 0x7f0a04bb | 18659 |
| `open_search_view_root` | int | 0x7f0a04bc | 18662 |
| `open_search_view_scrim` | int | 0x7f0a04bd | 18665 |
| `open_search_view_search_prefix` | int | 0x7f0a04be | 18668 |
| `open_search_view_status_bar_spacer` | int | 0x7f0a04bf | 18671 |
| `open_search_view_toolbar` | int | 0x7f0a04c0 | 18674 |
| `open_search_view_toolbar_container` | int | 0x7f0a04c1 | 18677 |
| `options1` | int | 0x7f0a04c4 | 18680 |
| `options2` | int | 0x7f0a04c5 | 18683 |
| `options3` | int | 0x7f0a04c6 | 18686 |
| `optionspicker` | int | 0x7f0a04c7 | 18689 |
| `OUTER` | int | 0x7f0a001a | 16916 |
| `outline` | int | 0x7f0a04c8 | 18692 |
| `outmost_container` | int | 0x7f0a04c9 | 18695 |
| `outward` | int | 0x7f0a04ca | 18698 |
| `overshoot` | int | 0x7f0a04cc | 18701 |
| `packed` | int | 0x7f0a04d2 | 18704 |
| `pageLoading` | int | 0x7f0a04d3 | 18707 |
| `parallax` | int | 0x7f0a04d7 | 18710 |
| `parent` | int | 0x7f0a04d8 | 18713 |
| `parent_matrix` | int | 0x7f0a04db | 18722 |
| `parentPanel` | int | 0x7f0a04d9 | 18716 |
| `parentRelative` | int | 0x7f0a04da | 18719 |
| `password_toggle` | int | 0x7f0a04dd | 18728 |
| `passwordValueView` | int | 0x7f0a04dc | 18725 |
| `path` | int | 0x7f0a04de | 18731 |
| `pathRelative` | int | 0x7f0a04df | 18734 |
| `pauseButton` | int | 0x7f0a04e0 | 18737 |
| `peekHeight` | int | 0x7f0a04e9 | 18740 |
| `percent` | int | 0x7f0a04ea | 18743 |
| `performance` | int | 0x7f0a04eb | 18746 |
| `pin` | int | 0x7f0a04f4 | 18749 |
| `playButton` | int | 0x7f0a04f5 | 18752 |
| `pooling_container_listener_holder_tag` | int | 0x7f0a04f8 | 18755 |
| `popular` | int | 0x7f0a04f9 | 18758 |
| `position` | int | 0x7f0a0501 | 18761 |
| `positionTextView` | int | 0x7f0a0504 | 18764 |
| `post_detail_nested_scroll` | int | 0x7f0a0506 | 18770 |
| `postLayout` | int | 0x7f0a0505 | 18767 |
| `pressed` | int | 0x7f0a0507 | 18773 |
| `preview_image` | int | 0x7f0a050c | 18779 |
| `preview_layout` | int | 0x7f0a050d | 18782 |
| `previewView` | int | 0x7f0a0509 | 18776 |
| `progress_circular` | int | 0x7f0a0514 | 18788 |
| `progress_horizontal` | int | 0x7f0a0515 | 18791 |
| `progressBar` | int | 0x7f0a0512 | 18785 |
| `ProgressBar` | int | 0x7f0a001b | 16919 |
| `ps_complete_select` | int | 0x7f0a0518 | 18794 |
| `ps_iv_arrow` | int | 0x7f0a0519 | 18797 |
| `ps_iv_delete` | int | 0x7f0a051a | 18800 |
| `ps_iv_left_back` | int | 0x7f0a051b | 18803 |
| `ps_rl_album_bg` | int | 0x7f0a051c | 18806 |
| `ps_rl_album_click` | int | 0x7f0a051d | 18809 |
| `ps_tv_cancel` | int | 0x7f0a051e | 18812 |
| `ps_tv_complete` | int | 0x7f0a051f | 18815 |
| `ps_tv_editor` | int | 0x7f0a0520 | 18818 |
| `ps_tv_photo` | int | 0x7f0a0521 | 18821 |
| `ps_tv_preview` | int | 0x7f0a0522 | 18824 |
| `ps_tv_select_num` | int | 0x7f0a0523 | 18827 |
| `ps_tv_selected` | int | 0x7f0a0524 | 18830 |
| `ps_tv_selected_word` | int | 0x7f0a0525 | 18833 |
| `ps_tv_title` | int | 0x7f0a0526 | 18836 |
| `ps_tv_video` | int | 0x7f0a0527 | 18839 |
| `pw_spinner` | int | 0x7f0a052c | 18842 |
| `radial_gradient` | int | 0x7f0a0533 | 18845 |
| `radio` | int | 0x7f0a0534 | 18848 |
| `range_mode` | int | 0x7f0a0538 | 18851 |
| `ratio` | int | 0x7f0a0539 | 18854 |
| `rb_taking_pictures` | int | 0x7f0a053a | 18857 |
| `rb_timelapse_image` | int | 0x7f0a053b | 18860 |
| `rb_timelapse_video` | int | 0x7f0a053c | 18863 |
| `rb_video` | int | 0x7f0a053d | 18866 |
| `rectangle` | int | 0x7f0a0547 | 18869 |
| `rectangles` | int | 0x7f0a0548 | 18872 |
| `recyclerView` | int | 0x7f0a054b | 18875 |
| `report_drawn` | int | 0x7f0a0560 | 18878 |
| `reverseSawtooth` | int | 0x7f0a0563 | 18881 |
| `rg_mode` | int | 0x7f0a0566 | 18884 |
| `right` | int | 0x7f0a0568 | 18887 |
| `right_icon` | int | 0x7f0a056c | 18893 |
| `right_left` | int | 0x7f0a056d | 18896 |
| `right_side` | int | 0x7f0a056f | 18899 |
| `rightToLeft` | int | 0x7f0a0569 | 18890 |
| `ring` | int | 0x7f0a0571 | 18902 |
| `rl_title_bar` | int | 0x7f0a0576 | 18905 |
| `rootView` | int | 0x7f0a0578 | 18908 |
| `rootViewBg` | int | 0x7f0a0579 | 18911 |
| `rotate_scroll_wheel` | int | 0x7f0a057b | 18914 |
| `round_group` | int | 0x7f0a057d | 18917 |
| `rounded` | int | 0x7f0a057e | 18920 |
| `row_index_key` | int | 0x7f0a057f | 18923 |
| `rtl` | int | 0x7f0a0580 | 18926 |
| `rv_topbar` | int | 0x7f0a0586 | 18929 |
| `s_t_a_t_u_s_b_a_r` | int | 0x7f0a0587 | 18932 |
| `sat` | int | 0x7f0a0588 | 18935 |
| `satellite` | int | 0x7f0a0589 | 18938 |
| `save_non_transition_alpha` | int | 0x7f0a058a | 18941 |
| `save_overlay_view` | int | 0x7f0a058b | 18944 |
| `sawtooth` | int | 0x7f0a058c | 18947 |
| `scale` | int | 0x7f0a0590 | 18950 |
| `Scale` | int | 0x7f0a0024 | 16943 |
| `scale_scroll_wheel` | int | 0x7f0a0591 | 18953 |
| `scan_parent_view` | int | 0x7f0a0595 | 18959 |
| `scan_title` | int | 0x7f0a0596 | 18962 |
| `scan_title_landscape` | int | 0x7f0a0597 | 18965 |
| `scan_title_layout` | int | 0x7f0a0598 | 18968 |
| `scankit_back_img_in_land` | int | 0x7f0a05a6 | 18971 |
| `scankit_decode` | int | 0x7f0a05a7 | 18974 |
| `scankit_decode_failed` | int | 0x7f0a05a8 | 18977 |
| `scankit_decode_succeeded` | int | 0x7f0a05a9 | 18980 |
| `scankit_img_btn_in_land` | int | 0x7f0a05aa | 18983 |
| `scankit_launch_product_query` | int | 0x7f0a05ab | 18986 |
| `scankit_quit` | int | 0x7f0a05ac | 18989 |
| `scankit_restart_preview` | int | 0x7f0a05ad | 18992 |
| `scankit_return_scan_result` | int | 0x7f0a05ae | 18995 |
| `scankit_title_frame` | int | 0x7f0a05af | 18998 |
| `scankit_title_scan_land` | int | 0x7f0a05b0 | 19001 |
| `scankit_title_scan_land_level_two` | int | 0x7f0a05b1 | 19004 |
| `scanLayout` | int | 0x7f0a0592 | 18956 |
| `screen` | int | 0x7f0a05b2 | 19007 |
| `scroll` | int | 0x7f0a05b3 | 19010 |
| `scrollable` | int | 0x7f0a05b7 | 19022 |
| `scrollIndicatorDown` | int | 0x7f0a05b4 | 19013 |
| `scrollIndicatorUp` | int | 0x7f0a05b5 | 19016 |
| `scrollView` | int | 0x7f0a05b6 | 19019 |
| `search_badge` | int | 0x7f0a05b9 | 19025 |
| `search_bar` | int | 0x7f0a05ba | 19028 |
| `search_button` | int | 0x7f0a05bb | 19031 |
| `search_close_btn` | int | 0x7f0a05bc | 19034 |
| `search_edit_frame` | int | 0x7f0a05bd | 19037 |
| `search_go_btn` | int | 0x7f0a05be | 19040 |
| `search_mag_icon` | int | 0x7f0a05bf | 19043 |
| `search_plate` | int | 0x7f0a05c0 | 19046 |
| `search_src_text` | int | 0x7f0a05c1 | 19049 |
| `search_voice_btn` | int | 0x7f0a05c2 | 19052 |
| `secNameTextView` | int | 0x7f0a05c4 | 19055 |
| `second` | int | 0x7f0a05c6 | 19061 |
| `secTextView` | int | 0x7f0a05c5 | 19058 |
| `seekBar` | int | 0x7f0a05c8 | 19064 |
| `seekZoomView` | int | 0x7f0a05c9 | 19067 |
| `select_click_area` | int | 0x7f0a05cc | 19073 |
| `select_dialog_listview` | int | 0x7f0a05cd | 19076 |
| `selected` | int | 0x7f0a05d4 | 19079 |
| `selection_type` | int | 0x7f0a05d5 | 19082 |
| `selectLayout` | int | 0x7f0a05ca | 19070 |
| `sharedValueSet` | int | 0x7f0a05e2 | 19085 |
| `sharedValueUnset` | int | 0x7f0a05e3 | 19088 |
| `SHIFT` | int | 0x7f0a001d | 16922 |
| `shortcut` | int | 0x7f0a05e7 | 19091 |
| `SHOW_ALL` | int | 0x7f0a001e | 16925 |
| `SHOW_PATH` | int | 0x7f0a001f | 16928 |
| `SHOW_PROGRESS` | int | 0x7f0a0020 | 16931 |
| `showCustom` | int | 0x7f0a05e8 | 19094 |
| `showHome` | int | 0x7f0a05e9 | 19097 |
| `showTitle` | int | 0x7f0a05ea | 19100 |
| `shrink` | int | 0x7f0a05eb | 19103 |
| `sin` | int | 0x7f0a05ec | 19106 |
| `single_mode` | int | 0x7f0a05ed | 19109 |
| `skipCollapsed` | int | 0x7f0a05ee | 19112 |
| `skipped` | int | 0x7f0a05ef | 19115 |
| `slide` | int | 0x7f0a05fa | 19118 |
| `sliding_pane_detail_container` | int | 0x7f0a05fb | 19121 |
| `sliding_pane_layout` | int | 0x7f0a05fc | 19124 |
| `small_close` | int | 0x7f0a05fe | 19127 |
| `small_id` | int | 0x7f0a05ff | 19130 |
| `snackbar_action` | int | 0x7f0a0601 | 19133 |
| `snackbar_text` | int | 0x7f0a0602 | 19136 |
| `snap` | int | 0x7f0a0603 | 19139 |
| `snapMargins` | int | 0x7f0a0604 | 19142 |
| `SOLID` | int | 0x7f0a0021 | 16934 |
| `south` | int | 0x7f0a0605 | 19145 |
| `spacer` | int | 0x7f0a060a | 19148 |
| `special_effects_controller_view_tag` | int | 0x7f0a060b | 19151 |
| `spherical_gl_surface_view` | int | 0x7f0a060d | 19154 |
| `splashscreen_icon_view` | int | 0x7f0a060e | 19157 |
| `spline` | int | 0x7f0a060f | 19160 |
| `split_action_bar` | int | 0x7f0a0610 | 19163 |
| `spread` | int | 0x7f0a0612 | 19166 |
| `spread_inside` | int | 0x7f0a0613 | 19169 |
| `spring` | int | 0x7f0a0614 | 19172 |
| `square` | int | 0x7f0a0615 | 19175 |
| `src_atop` | int | 0x7f0a0619 | 19178 |
| `src_in` | int | 0x7f0a061b | 19181 |
| `src_over` | int | 0x7f0a061c | 19184 |
| `srl_classics_arrow` | int | 0x7f0a061d | 19187 |
| `srl_classics_center` | int | 0x7f0a061e | 19190 |
| `srl_classics_progress` | int | 0x7f0a061f | 19193 |
| `srl_classics_title` | int | 0x7f0a0620 | 19196 |
| `srl_classics_update` | int | 0x7f0a0621 | 19199 |
| `srl_tag` | int | 0x7f0a0622 | 19202 |
| `standard` | int | 0x7f0a066f | 19205 |
| `start` | int | 0x7f0a0670 | 19208 |
| `startHorizontal` | int | 0x7f0a0671 | 19211 |
| `startToEnd` | int | 0x7f0a0672 | 19214 |
| `startVertical` | int | 0x7f0a0673 | 19217 |
| `state_aspect_ratio` | int | 0x7f0a0676 | 19220 |
| `state_rotate` | int | 0x7f0a0677 | 19223 |
| `state_scale` | int | 0x7f0a0678 | 19226 |
| `staticLayout` | int | 0x7f0a0679 | 19229 |
| `staticPostLayout` | int | 0x7f0a067a | 19232 |
| `status_bar_latest_event_content` | int | 0x7f0a067d | 19235 |
| `stop` | int | 0x7f0a067f | 19238 |
| `stretch` | int | 0x7f0a068a | 19241 |
| `STROKE` | int | 0x7f0a0022 | 16937 |
| `submenuarrow` | int | 0x7f0a068b | 19244 |
| `submit_area` | int | 0x7f0a068d | 19247 |
| `SubsamplingScaleImageView` | int | 0x7f0a0026 | 16946 |
| `summaryView` | int | 0x7f0a068e | 19250 |
| `sun` | int | 0x7f0a068f | 19253 |
| `support_container` | int | 0x7f0a0691 | 19259 |
| `supportScrollUp` | int | 0x7f0a0690 | 19256 |
| `surface_container` | int | 0x7f0a0694 | 19262 |
| `surface_view` | int | 0x7f0a0695 | 19265 |
| `sweep_gradient` | int | 0x7f0a0698 | 19268 |
| `switchTitleView` | int | 0x7f0a069a | 19271 |
| `switchView` | int | 0x7f0a069b | 19274 |
| `SYM` | int | 0x7f0a0023 | 16940 |
| `TabLayoutNoScroll` | int | 0x7f0a0029 | 16955 |
| `tabMode` | int | 0x7f0a06a2 | 19277 |
| `tag_accessibility_actions` | int | 0x7f0a06a5 | 19280 |
| `tag_accessibility_clickable_spans` | int | 0x7f0a06a6 | 19283 |
| `tag_accessibility_heading` | int | 0x7f0a06a7 | 19286 |
| `tag_accessibility_pane_title` | int | 0x7f0a06a8 | 19289 |
| `tag_on_apply_window_listener` | int | 0x7f0a06a9 | 19292 |
| `tag_on_receive_content_listener` | int | 0x7f0a06aa | 19295 |
| `tag_on_receive_content_mime_types` | int | 0x7f0a06ab | 19298 |
| `tag_screen_reader_focusable` | int | 0x7f0a06ac | 19301 |
| `tag_state_description` | int | 0x7f0a06ad | 19304 |
| `tag_transition_group` | int | 0x7f0a06ae | 19307 |
| `tag_unhandled_key_event_manager` | int | 0x7f0a06af | 19310 |
| `tag_unhandled_key_listeners` | int | 0x7f0a06b0 | 19313 |
| `tag_window_insets_animation_callback` | int | 0x7f0a06b1 | 19316 |
| `terrain` | int | 0x7f0a06b2 | 19319 |
| `text_input_end_icon` | int | 0x7f0a06ca | 19343 |
| `text_input_error_icon` | int | 0x7f0a06cb | 19346 |
| `text_input_start_icon` | int | 0x7f0a06cc | 19349 |
| `text_tip` | int | 0x7f0a06cf | 19352 |
| `text_view_crop` | int | 0x7f0a06d0 | 19355 |
| `text_view_rotate` | int | 0x7f0a06d1 | 19358 |
| `text_view_scale` | int | 0x7f0a06d2 | 19361 |
| `text2` | int | 0x7f0a06b4 | 19322 |
| `textEnd` | int | 0x7f0a06bd | 19325 |
| `textinput_counter` | int | 0x7f0a06d3 | 19364 |
| `textinput_error` | int | 0x7f0a06d4 | 19367 |
| `textinput_helper_text` | int | 0x7f0a06d5 | 19370 |
| `textinput_placeholder` | int | 0x7f0a06d6 | 19373 |
| `textinput_prefix_text` | int | 0x7f0a06d7 | 19376 |
| `textinput_suffix_text` | int | 0x7f0a06d8 | 19379 |
| `textSpacerNoButtons` | int | 0x7f0a06c3 | 19328 |
| `textSpacerNoTitle` | int | 0x7f0a06c4 | 19331 |
| `textStart` | int | 0x7f0a06c5 | 19334 |
| `textTop` | int | 0x7f0a06c6 | 19337 |
| `texture_view` | int | 0x7f0a06d9 | 19382 |
| `textWatcher` | int | 0x7f0a06c8 | 19340 |
| `time` | int | 0x7f0a06dc | 19385 |
| `timepicker` | int | 0x7f0a06e6 | 19406 |
| `timeStartItemView` | int | 0x7f0a06de | 19388 |
| `timeStartTitleView` | int | 0x7f0a06df | 19391 |
| `timeStartValueView` | int | 0x7f0a06e0 | 19394 |
| `timeStopItemView` | int | 0x7f0a06e1 | 19397 |
| `timeStopTitleView` | int | 0x7f0a06e2 | 19400 |
| `timeStopValueView` | int | 0x7f0a06e3 | 19403 |
| `title_bar` | int | 0x7f0a06ec | 19415 |
| `title_bar_line` | int | 0x7f0a06ed | 19418 |
| `title_scan` | int | 0x7f0a06f2 | 19421 |
| `title_scan_level_two` | int | 0x7f0a06f3 | 19424 |
| `title_template` | int | 0x7f0a06f4 | 19427 |
| `titleDividerNoCustom` | int | 0x7f0a06e8 | 19409 |
| `titleView` | int | 0x7f0a06ea | 19412 |
| `tl_br` | int | 0x7f0a06f9 | 19439 |
| `tlItemView` | int | 0x7f0a06f6 | 19430 |
| `tlRadioButton` | int | 0x7f0a06f7 | 19433 |
| `tlTitleView` | int | 0x7f0a06f8 | 19436 |
| `toggle` | int | 0x7f0a06fb | 19442 |
| `toolbar_title` | int | 0x7f0a06ff | 19445 |
| `top` | int | 0x7f0a0701 | 19448 |
| `top_bottom` | int | 0x7f0a0704 | 19454 |
| `TOP_END` | int | 0x7f0a0027 | 16949 |
| `top_line` | int | 0x7f0a0706 | 19457 |
| `TOP_START` | int | 0x7f0a0028 | 16952 |
| `top_status_bar` | int | 0x7f0a0709 | 19460 |
| `topPanel` | int | 0x7f0a0702 | 19451 |
| `total` | int | 0x7f0a070a | 19463 |
| `touch_outside` | int | 0x7f0a070b | 19466 |
| `tr_bl` | int | 0x7f0a070c | 19469 |
| `transition_current_scene` | int | 0x7f0a0712 | 19478 |
| `transition_layout_save` | int | 0x7f0a0713 | 19481 |
| `transition_position` | int | 0x7f0a0714 | 19484 |
| `transition_scene_layoutid_cache` | int | 0x7f0a0715 | 19487 |
| `transition_transform` | int | 0x7f0a0716 | 19490 |
| `transitionToEnd` | int | 0x7f0a0710 | 19472 |
| `transitionToStart` | int | 0x7f0a0711 | 19475 |
| `Translate` | int | 0x7f0a002a | 16958 |
| `triangle` | int | 0x7f0a0717 | 19493 |
| `tv_cancel` | int | 0x7f0a073d | 19505 |
| `tv_choose` | int | 0x7f0a0740 | 19508 |
| `tv_confirm` | int | 0x7f0a0745 | 19511 |
| `tv_count` | int | 0x7f0a0748 | 19514 |
| `tv_current` | int | 0x7f0a0749 | 19517 |
| `tv_current_data_time` | int | 0x7f0a074a | 19520 |
| `tv_current_time` | int | 0x7f0a074b | 19523 |
| `tv_data_empty` | int | 0x7f0a074e | 19526 |
| `tv_delete_count` | int | 0x7f0a0750 | 19529 |
| `tv_download_count` | int | 0x7f0a0757 | 19532 |
| `tv_download_hint` | int | 0x7f0a0758 | 19535 |
| `tv_download_percent` | int | 0x7f0a0759 | 19538 |
| `tv_download_state` | int | 0x7f0a075a | 19541 |
| `tv_download_time_left` | int | 0x7f0a075b | 19544 |
| `tv_duration` | int | 0x7f0a075d | 19547 |
| `tv_error` | int | 0x7f0a0760 | 19550 |
| `tv_file_name` | int | 0x7f0a0765 | 19553 |
| `tv_folder_name` | int | 0x7f0a0766 | 19556 |
| `tv_length` | int | 0x7f0a076a | 19559 |
| `tv_media_tag` | int | 0x7f0a0774 | 19562 |
| `tv_path` | int | 0x7f0a077e | 19565 |
| `tv_prompt` | int | 0x7f0a0784 | 19568 |
| `tv_select_tag` | int | 0x7f0a0790 | 19571 |
| `tv_total_duration` | int | 0x7f0a07a0 | 19574 |
| `tvCamera` | int | 0x7f0a0719 | 19496 |
| `tvCheck` | int | 0x7f0a071b | 19499 |
| `tvMessage` | int | 0x7f0a0728 | 19502 |
| `ucrop` | int | 0x7f0a07b0 | 19577 |
| `ucrop_frame` | int | 0x7f0a07b1 | 19580 |
| `ucrop_photobox` | int | 0x7f0a07b2 | 19583 |
| `unchecked` | int | 0x7f0a07b4 | 19586 |
| `uniform` | int | 0x7f0a07b5 | 19589 |
| `unlabeled` | int | 0x7f0a07b6 | 19592 |
| `up` | int | 0x7f0a07b7 | 19595 |
| `useLogo` | int | 0x7f0a07ba | 19598 |
| `vertical` | int | 0x7f0a07d0 | 19601 |
| `vertical_only` | int | 0x7f0a07d1 | 19604 |
| `VerticalGridRecyclerView` | int | 0x7f0a002b | 16961 |
| `video_decoder_gl_surface_view` | int | 0x7f0a07d2 | 19607 |
| `video_line` | int | 0x7f0a07d4 | 19610 |
| `video_pb_stop_btn` | int | 0x7f0a07de | 19613 |
| `video_pb_view` | int | 0x7f0a07e3 | 19616 |
| `view_mask` | int | 0x7f0a0840 | 19856 |
| `view_offset_helper` | int | 0x7f0a0841 | 19859 |
| `view_overlay` | int | 0x7f0a0842 | 19862 |
| `view_transition` | int | 0x7f0a0844 | 19865 |
| `view_tree_lifecycle_owner` | int | 0x7f0a0845 | 19868 |
| `view_tree_on_back_pressed_dispatcher_owner` | int | 0x7f0a0846 | 19871 |
| `view_tree_saved_state_registry_owner` | int | 0x7f0a0847 | 19874 |
| `view_tree_view_model_store_owner` | int | 0x7f0a0848 | 19877 |
| `viewAction1` | int | 0x7f0a07ed | 19619 |
| `viewActionAdd` | int | 0x7f0a07ee | 19622 |
| `viewActionAlbum` | int | 0x7f0a07ef | 19625 |
| `viewActionClearCache` | int | 0x7f0a07f0 | 19628 |
| `viewActionClose` | int | 0x7f0a07f1 | 19631 |
| `viewActionReturn` | int | 0x7f0a07f2 | 19634 |
| `viewActionSelectViewOn` | int | 0x7f0a07f3 | 19637 |
| `viewActionSettings` | int | 0x7f0a07f4 | 19640 |
| `viewActionShutter` | int | 0x7f0a07f5 | 19643 |
| `viewActionToolbar` | int | 0x7f0a07f6 | 19646 |
| `viewAppIcon` | int | 0x7f0a07f7 | 19649 |
| `viewBorder` | int | 0x7f0a07f8 | 19652 |
| `viewBottomNav` | int | 0x7f0a07f9 | 19655 |
| `viewButtonBack` | int | 0x7f0a07fa | 19658 |
| `viewButtonConnection` | int | 0x7f0a07fb | 19661 |
| `viewButtonFullScreen` | int | 0x7f0a07fc | 19664 |
| `viewButtonShutter` | int | 0x7f0a07fd | 19667 |
| `viewCacheValue` | int | 0x7f0a07fe | 19670 |
| `viewCheckbox` | int | 0x7f0a07ff | 19673 |
| `viewClose` | int | 0x7f0a0800 | 19676 |
| `viewCover` | int | 0x7f0a0801 | 19679 |
| `viewCoverView` | int | 0x7f0a0803 | 19682 |
| `viewDecoration` | int | 0x7f0a0804 | 19685 |
| `viewDelayNum` | int | 0x7f0a0805 | 19688 |
| `viewDownloadedIcon` | int | 0x7f0a0806 | 19691 |
| `viewDuration` | int | 0x7f0a0807 | 19694 |
| `viewError` | int | 0x7f0a0808 | 19697 |
| `viewfinderView` | int | 0x7f0a0849 | 19880 |
| `viewFragmentContainer` | int | 0x7f0a0809 | 19700 |
| `viewIconBattery` | int | 0x7f0a080a | 19703 |
| `viewIconCheckbox` | int | 0x7f0a080b | 19706 |
| `viewIconLogo` | int | 0x7f0a080c | 19709 |
| `viewIconMore` | int | 0x7f0a080d | 19712 |
| `viewIconSwitch` | int | 0x7f0a080e | 19715 |
| `viewItem1` | int | 0x7f0a080f | 19718 |
| `viewItem1Title` | int | 0x7f0a0810 | 19721 |
| `viewItem1Value` | int | 0x7f0a0811 | 19724 |
| `viewItem2` | int | 0x7f0a0812 | 19727 |
| `viewItem2Title` | int | 0x7f0a0813 | 19730 |
| `viewItem2Value` | int | 0x7f0a0814 | 19733 |
| `viewItem3` | int | 0x7f0a0815 | 19736 |
| `viewItem3Title` | int | 0x7f0a0816 | 19739 |
| `viewItem3Value` | int | 0x7f0a0817 | 19742 |
| `viewItem4` | int | 0x7f0a0818 | 19745 |
| `viewItem4Title` | int | 0x7f0a0819 | 19748 |
| `viewItem4Value` | int | 0x7f0a081a | 19751 |
| `viewListView` | int | 0x7f0a081b | 19754 |
| `viewLoading` | int | 0x7f0a081c | 19757 |
| `viewLongExposure` | int | 0x7f0a081d | 19760 |
| `viewNoFile` | int | 0x7f0a081e | 19763 |
| `viewPager` | int | 0x7f0a0820 | 19766 |
| `ViewPager` | int | 0x7f0a002d | 16964 |
| `viewPager2` | int | 0x7f0a0821 | 19769 |
| `viewPauseButton` | int | 0x7f0a0822 | 19772 |
| `viewPlayButton` | int | 0x7f0a0823 | 19775 |
| `viewPlayer` | int | 0x7f0a0824 | 19778 |
| `viewPosition` | int | 0x7f0a0825 | 19781 |
| `viewProductIcon` | int | 0x7f0a0826 | 19784 |
| `viewProgress` | int | 0x7f0a0827 | 19787 |
| `viewRecyclerView` | int | 0x7f0a0828 | 19790 |
| `viewSeekBar` | int | 0x7f0a082a | 19793 |
| `viewSize` | int | 0x7f0a082b | 19796 |
| `viewSurface` | int | 0x7f0a082c | 19799 |
| `viewTabLayout` | int | 0x7f0a082d | 19802 |
| `viewTabMode` | int | 0x7f0a082e | 19805 |
| `viewTextBurstPhotoStatus` | int | 0x7f0a082f | 19808 |
| `viewTextRecStatus` | int | 0x7f0a0830 | 19811 |
| `viewTextRes` | int | 0x7f0a0831 | 19814 |
| `viewTextSummary` | int | 0x7f0a0832 | 19817 |
| `viewTextSummary2` | int | 0x7f0a0833 | 19820 |
| `viewTextTitle` | int | 0x7f0a0834 | 19823 |
| `viewTitle` | int | 0x7f0a0835 | 19826 |
| `viewTitleBar` | int | 0x7f0a0836 | 19829 |
| `viewToolbar` | int | 0x7f0a0837 | 19832 |
| `viewToolbar2` | int | 0x7f0a0838 | 19835 |
| `viewToolbarView` | int | 0x7f0a0839 | 19838 |
| `viewTopPadding` | int | 0x7f0a083a | 19841 |
| `viewUserAgreement` | int | 0x7f0a083b | 19844 |
| `viewVersion` | int | 0x7f0a083c | 19847 |
| `viewVideoLoading` | int | 0x7f0a083d | 19850 |
| `viewVoiceRes` | int | 0x7f0a083e | 19853 |
| `visible_removing_fragment_view_tag` | int | 0x7f0a084c | 19883 |
| `volume_progressbar` | int | 0x7f0a084e | 19886 |
| `vp_month` | int | 0x7f0a0851 | 19889 |
| `vp_week` | int | 0x7f0a0852 | 19892 |
| `webView` | int | 0x7f0a0855 | 19895 |
| `WebView` | int | 0x7f0a002f | 16967 |
| `west` | int | 0x7f0a0858 | 19898 |
| `when_playing` | int | 0x7f0a0859 | 19901 |
| `wide` | int | 0x7f0a085a | 19904 |
| `widget_container` | int | 0x7f0a085b | 19907 |
| `wifiNameValueView` | int | 0x7f0a085c | 19910 |
| `window` | int | 0x7f0a0861 | 19913 |
| `with_icon` | int | 0x7f0a0863 | 19919 |
| `withinBounds` | int | 0x7f0a0864 | 19922 |
| `withText` | int | 0x7f0a0862 | 19916 |
| `wrap` | int | 0x7f0a0865 | 19925 |
| `wrap_content` | int | 0x7f0a0866 | 19928 |
| `wrap_content_constrained` | int | 0x7f0a0867 | 19931 |
| `wrapper_controls` | int | 0x7f0a0868 | 19934 |
| `wrapper_reset_rotate` | int | 0x7f0a0869 | 19937 |
| `wrapper_rotate_by_angle` | int | 0x7f0a086a | 19940 |
| `wrapper_states` | int | 0x7f0a086b | 19943 |
| `x_left` | int | 0x7f0a086c | 19946 |
| `x_right` | int | 0x7f0a086d | 19949 |
| `year` | int | 0x7f0a086e | 19952 |
| `zoom` | int | 0x7f0a0870 | 19955 |
| `zoomAddView` | int | 0x7f0a0871 | 19958 |
| `zoomRateView` | int | 0x7f0a0873 | 19961 |
| `zoomSubtractView` | int | 0x7f0a0874 | 19964 |

### `com.gku.xtugo.R$integer`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_config_activityDefaultDur` | int | 0x7f0b0000 | 19974 |
| `abc_config_activityShortDur` | int | 0x7f0b0001 | 19977 |
| `animation_default_duration` | int | 0x7f0b0002 | 19980 |
| `app_bar_elevation_anim_duration` | int | 0x7f0b0003 | 19983 |
| `bottom_sheet_slide_duration` | int | 0x7f0b0004 | 19986 |
| `cancel_button_image_alpha` | int | 0x7f0b0005 | 19989 |
| `config_navAnimTime` | int | 0x7f0b0006 | 19992 |
| `config_tooltipAnimTime` | int | 0x7f0b0007 | 19995 |
| `content_limit_grid` | int | 0x7f0b0008 | 19998 |
| `content_limit_list` | int | 0x7f0b0009 | 20001 |
| `content_limit_pane` | int | 0x7f0b000a | 20004 |
| `content_limit_place_list` | int | 0x7f0b000b | 20007 |
| `content_limit_route_list` | int | 0x7f0b000c | 20010 |
| `default_icon_animation_duration` | int | 0x7f0b000d | 20013 |
| `design_snackbar_text_max_lines` | int | 0x7f0b000e | 20016 |
| `design_tab_indicator_anim_duration_ms` | int | 0x7f0b000f | 20019 |
| `exo_media_button_opacity_percentage_disabled` | int | 0x7f0b0010 | 20022 |
| `exo_media_button_opacity_percentage_enabled` | int | 0x7f0b0011 | 20025 |
| `google_play_services_version` | int | 0x7f0b0012 | 20028 |
| `hide_password_duration` | int | 0x7f0b0013 | 20031 |
| `m3_badge_max_number` | int | 0x7f0b0014 | 20034 |
| `m3_btn_anim_delay_ms` | int | 0x7f0b0015 | 20037 |
| `m3_btn_anim_duration_ms` | int | 0x7f0b0016 | 20040 |
| `m3_card_anim_delay_ms` | int | 0x7f0b0017 | 20043 |
| `m3_card_anim_duration_ms` | int | 0x7f0b0018 | 20046 |
| `m3_chip_anim_duration` | int | 0x7f0b0019 | 20049 |
| `m3_sys_motion_duration_extra_long1` | int | 0x7f0b001a | 20052 |
| `m3_sys_motion_duration_extra_long2` | int | 0x7f0b001b | 20055 |
| `m3_sys_motion_duration_extra_long3` | int | 0x7f0b001c | 20058 |
| `m3_sys_motion_duration_extra_long4` | int | 0x7f0b001d | 20061 |
| `m3_sys_motion_duration_long1` | int | 0x7f0b001e | 20064 |
| `m3_sys_motion_duration_long2` | int | 0x7f0b001f | 20067 |
| `m3_sys_motion_duration_long3` | int | 0x7f0b0020 | 20070 |
| `m3_sys_motion_duration_long4` | int | 0x7f0b0021 | 20073 |
| `m3_sys_motion_duration_medium1` | int | 0x7f0b0022 | 20076 |
| `m3_sys_motion_duration_medium2` | int | 0x7f0b0023 | 20079 |
| `m3_sys_motion_duration_medium3` | int | 0x7f0b0024 | 20082 |
| `m3_sys_motion_duration_medium4` | int | 0x7f0b0025 | 20085 |
| `m3_sys_motion_duration_short1` | int | 0x7f0b0026 | 20088 |
| `m3_sys_motion_duration_short2` | int | 0x7f0b0027 | 20091 |
| `m3_sys_motion_duration_short3` | int | 0x7f0b0028 | 20094 |
| `m3_sys_motion_duration_short4` | int | 0x7f0b0029 | 20097 |
| `m3_sys_motion_path` | int | 0x7f0b002a | 20100 |
| `m3_sys_shape_corner_extra_large_corner_family` | int | 0x7f0b002b | 20103 |
| `m3_sys_shape_corner_extra_small_corner_family` | int | 0x7f0b002c | 20106 |
| `m3_sys_shape_corner_full_corner_family` | int | 0x7f0b002d | 20109 |
| `m3_sys_shape_corner_large_corner_family` | int | 0x7f0b002e | 20112 |
| `m3_sys_shape_corner_medium_corner_family` | int | 0x7f0b002f | 20115 |
| `m3_sys_shape_corner_small_corner_family` | int | 0x7f0b0030 | 20118 |
| `material_motion_duration_long_1` | int | 0x7f0b0031 | 20121 |
| `material_motion_duration_long_2` | int | 0x7f0b0032 | 20124 |
| `material_motion_duration_medium_1` | int | 0x7f0b0033 | 20127 |
| `material_motion_duration_medium_2` | int | 0x7f0b0034 | 20130 |
| `material_motion_duration_short_1` | int | 0x7f0b0035 | 20133 |
| `material_motion_duration_short_2` | int | 0x7f0b0036 | 20136 |
| `material_motion_path` | int | 0x7f0b0037 | 20139 |
| `mtrl_badge_max_character_count` | int | 0x7f0b0038 | 20142 |
| `mtrl_btn_anim_delay_ms` | int | 0x7f0b0039 | 20145 |
| `mtrl_btn_anim_duration_ms` | int | 0x7f0b003a | 20148 |
| `mtrl_calendar_header_orientation` | int | 0x7f0b003b | 20151 |
| `mtrl_calendar_selection_text_lines` | int | 0x7f0b003c | 20154 |
| `mtrl_calendar_year_selector_span` | int | 0x7f0b003d | 20157 |
| `mtrl_card_anim_delay_ms` | int | 0x7f0b003e | 20160 |
| `mtrl_card_anim_duration_ms` | int | 0x7f0b003f | 20163 |
| `mtrl_chip_anim_duration` | int | 0x7f0b0040 | 20166 |
| `mtrl_switch_thumb_motion_duration` | int | 0x7f0b0041 | 20169 |
| `mtrl_switch_thumb_post_morphing_duration` | int | 0x7f0b0042 | 20172 |
| `mtrl_switch_thumb_pre_morphing_duration` | int | 0x7f0b0043 | 20175 |
| `mtrl_switch_thumb_pressed_duration` | int | 0x7f0b0044 | 20178 |
| `mtrl_switch_thumb_viewport_center_coordinate` | int | 0x7f0b0045 | 20181 |
| `mtrl_switch_thumb_viewport_size` | int | 0x7f0b0046 | 20184 |
| `mtrl_switch_track_viewport_height` | int | 0x7f0b0047 | 20187 |
| `mtrl_switch_track_viewport_width` | int | 0x7f0b0048 | 20190 |
| `mtrl_tab_indicator_anim_duration_ms` | int | 0x7f0b0049 | 20193 |
| `mtrl_view_gone` | int | 0x7f0b004a | 20196 |
| `mtrl_view_invisible` | int | 0x7f0b004b | 20199 |
| `mtrl_view_visible` | int | 0x7f0b004c | 20202 |
| `show_password_duration` | int | 0x7f0b004d | 20205 |
| `status_bar_notification_info_maxnum` | int | 0x7f0b004e | 20208 |
| `ucrop_progress_loading_anim_time` | int | 0x7f0b004f | 20211 |

### `com.gku.xtugo.R$interpolator`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `btn_checkbox_checked_mtrl_animation_interpolator_0` | int | 0x7f0c0000 | 20218 |
| `btn_checkbox_checked_mtrl_animation_interpolator_1` | int | 0x7f0c0001 | 20221 |
| `btn_checkbox_unchecked_mtrl_animation_interpolator_0` | int | 0x7f0c0002 | 20224 |
| `btn_checkbox_unchecked_mtrl_animation_interpolator_1` | int | 0x7f0c0003 | 20227 |
| `btn_radio_to_off_mtrl_animation_interpolator_0` | int | 0x7f0c0004 | 20230 |
| `btn_radio_to_on_mtrl_animation_interpolator_0` | int | 0x7f0c0005 | 20233 |
| `fast_out_slow_in` | int | 0x7f0c0006 | 20236 |
| `m3_sys_motion_easing_emphasized` | int | 0x7f0c0007 | 20239 |
| `m3_sys_motion_easing_emphasized_accelerate` | int | 0x7f0c0008 | 20242 |
| `m3_sys_motion_easing_emphasized_decelerate` | int | 0x7f0c0009 | 20245 |
| `m3_sys_motion_easing_linear` | int | 0x7f0c000a | 20248 |
| `m3_sys_motion_easing_standard` | int | 0x7f0c000b | 20251 |
| `m3_sys_motion_easing_standard_accelerate` | int | 0x7f0c000c | 20254 |
| `m3_sys_motion_easing_standard_decelerate` | int | 0x7f0c000d | 20257 |
| `mtrl_fast_out_linear_in` | int | 0x7f0c000e | 20260 |
| `mtrl_fast_out_slow_in` | int | 0x7f0c000f | 20263 |
| `mtrl_linear` | int | 0x7f0c0010 | 20266 |
| `mtrl_linear_out_slow_in` | int | 0x7f0c0011 | 20269 |

### `com.gku.xtugo.R$layout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_action_bar_title_item` | int | 0x7f0d0000 | 20548 |
| `abc_action_bar_up_container` | int | 0x7f0d0001 | 20551 |
| `abc_action_menu_item_layout` | int | 0x7f0d0002 | 20554 |
| `abc_action_menu_layout` | int | 0x7f0d0003 | 20557 |
| `abc_action_mode_bar` | int | 0x7f0d0004 | 20560 |
| `abc_action_mode_close_item_material` | int | 0x7f0d0005 | 20563 |
| `abc_activity_chooser_view` | int | 0x7f0d0006 | 20566 |
| `abc_activity_chooser_view_list_item` | int | 0x7f0d0007 | 20569 |
| `abc_alert_dialog_button_bar_material` | int | 0x7f0d0008 | 20572 |
| `abc_alert_dialog_material` | int | 0x7f0d0009 | 20575 |
| `abc_alert_dialog_title_material` | int | 0x7f0d000a | 20578 |
| `abc_cascading_menu_item_layout` | int | 0x7f0d000b | 20581 |
| `abc_dialog_title_material` | int | 0x7f0d000c | 20584 |
| `abc_expanded_menu_layout` | int | 0x7f0d000d | 20587 |
| `abc_list_menu_item_checkbox` | int | 0x7f0d000e | 20590 |
| `abc_list_menu_item_icon` | int | 0x7f0d000f | 20593 |
| `abc_list_menu_item_layout` | int | 0x7f0d0010 | 20596 |
| `abc_list_menu_item_radio` | int | 0x7f0d0011 | 20599 |
| `abc_popup_menu_header_item_layout` | int | 0x7f0d0012 | 20602 |
| `abc_popup_menu_item_layout` | int | 0x7f0d0013 | 20605 |
| `abc_screen_content_include` | int | 0x7f0d0014 | 20608 |
| `abc_screen_simple` | int | 0x7f0d0015 | 20611 |
| `abc_screen_simple_overlay_action_mode` | int | 0x7f0d0016 | 20614 |
| `abc_screen_toolbar` | int | 0x7f0d0017 | 20617 |
| `abc_search_dropdown_item_icons_2line` | int | 0x7f0d0018 | 20620 |
| `abc_search_view` | int | 0x7f0d0019 | 20623 |
| `abc_select_dialog_material` | int | 0x7f0d001a | 20626 |
| `abc_tooltip` | int | 0x7f0d001b | 20629 |
| `activity_agreement_permission` | int | 0x7f0d001e | 20632 |
| `activity_album` | int | 0x7f0d001f | 20635 |
| `activity_amba_pic_preview` | int | 0x7f0d0022 | 20638 |
| `activity_camera_album` | int | 0x7f0d002b | 20641 |
| `activity_camera_album2` | int | 0x7f0d002c | 20644 |
| `activity_camera_file` | int | 0x7f0d002d | 20647 |
| `activity_control` | int | 0x7f0d002f | 20650 |
| `activity_gkucam_player` | int | 0x7f0d0039 | 20653 |
| `activity_hisi_camera_file` | int | 0x7f0d003a | 20656 |
| `activity_hisi_pic_preview` | int | 0x7f0d003b | 20659 |
| `activity_icatch_video_player` | int | 0x7f0d003e | 20662 |
| `activity_launcher` | int | 0x7f0d0042 | 20665 |
| `activity_main` | int | 0x7f0d0045 | 20668 |
| `activity_main2` | int | 0x7f0d0046 | 20671 |
| `activity_permission` | int | 0x7f0d0049 | 20674 |
| `activity_preferences` | int | 0x7f0d004d | 20677 |
| `activity_simulate` | int | 0x7f0d0061 | 20680 |
| `activity_video_pb` | int | 0x7f0d0070 | 20683 |
| `activity_video_player` | int | 0x7f0d0072 | 20686 |
| `activity_web_view` | int | 0x7f0d0075 | 20689 |
| `amu_info_window` | int | 0x7f0d0079 | 20692 |
| `amu_text_bubble` | int | 0x7f0d007a | 20695 |
| `amu_webview` | int | 0x7f0d007b | 20698 |
| `base_dialog_loading` | int | 0x7f0d007d | 20701 |
| `broadcast_init_progress_dialog` | int | 0x7f0d007f | 20704 |
| `brvah_quick_view_load_more` | int | 0x7f0d0080 | 20707 |
| `camera_scan` | int | 0x7f0d0084 | 20710 |
| `content_video_pb` | int | 0x7f0d008b | 20713 |
| `custom_dialog` | int | 0x7f0d008d | 20716 |
| `cv_layout_calendar_view` | int | 0x7f0d008f | 20719 |
| `cv_week_bar` | int | 0x7f0d0090 | 20722 |
| `cy_loadmore_horizontal_foot_default` | int | 0x7f0d0091 | 20725 |
| `cy_loadmore_vertical_foot_default` | int | 0x7f0d0092 | 20728 |
| `cy_refresh_finished_default` | int | 0x7f0d0093 | 20731 |
| `cy_staggerd_item` | int | 0x7f0d0094 | 20734 |
| `cy_staggerd_item_0` | int | 0x7f0d0095 | 20737 |
| `design_bottom_navigation_item` | int | 0x7f0d0096 | 20740 |
| `design_bottom_sheet_dialog` | int | 0x7f0d0097 | 20743 |
| `design_layout_snackbar` | int | 0x7f0d0098 | 20746 |
| `design_layout_snackbar_include` | int | 0x7f0d0099 | 20749 |
| `design_layout_tab_icon` | int | 0x7f0d009a | 20752 |
| `design_layout_tab_text` | int | 0x7f0d009b | 20755 |
| `design_menu_item_action_area` | int | 0x7f0d009c | 20758 |
| `design_navigation_item` | int | 0x7f0d009d | 20761 |
| `design_navigation_item_header` | int | 0x7f0d009e | 20764 |
| `design_navigation_item_separator` | int | 0x7f0d009f | 20767 |
| `design_navigation_item_subheader` | int | 0x7f0d00a0 | 20770 |
| `design_navigation_menu` | int | 0x7f0d00a1 | 20773 |
| `design_navigation_menu_item` | int | 0x7f0d00a2 | 20776 |
| `design_text_input_end_icon` | int | 0x7f0d00a3 | 20779 |
| `design_text_input_start_icon` | int | 0x7f0d00a4 | 20782 |
| `dialog_amba_sd_media_delete` | int | 0x7f0d00a9 | 20785 |
| `dialog_amba_sd_media_download` | int | 0x7f0d00aa | 20788 |
| `dialog_amba_sd_media_long_click` | int | 0x7f0d00ab | 20791 |
| `dialog_ask` | int | 0x7f0d00ad | 20794 |
| `dialog_bottom_settings` | int | 0x7f0d00af | 20797 |
| `dialog_common_confirm` | int | 0x7f0d00b0 | 20800 |
| `dialog_common_hint` | int | 0x7f0d00b1 | 20803 |
| `dialog_download_soft` | int | 0x7f0d00b6 | 20806 |
| `dialog_hisi_sd_media_delete` | int | 0x7f0d00b9 | 20809 |
| `dialog_hisi_sd_media_download` | int | 0x7f0d00ba | 20812 |
| `dialog_hisi_sd_media_long_click` | int | 0x7f0d00bb | 20815 |
| `dialog_ly_period_preference` | int | 0x7f0d00c0 | 20818 |
| `dialog_normal_progress` | int | 0x7f0d00c3 | 20821 |
| `dialog_notify` | int | 0x7f0d00c4 | 20824 |
| `dialog_pref_list` | int | 0x7f0d00c5 | 20827 |
| `dialog_retry` | int | 0x7f0d00c7 | 20830 |
| `dialog_screen` | int | 0x7f0d00c8 | 20833 |
| `dialog_send_soft` | int | 0x7f0d00c9 | 20836 |
| `dialog_target_time` | int | 0x7f0d00ca | 20839 |
| `dialog_time` | int | 0x7f0d00cb | 20842 |
| `dialog_timelapse` | int | 0x7f0d00cc | 20845 |
| `dialog_video_long_click` | int | 0x7f0d00cd | 20848 |
| `dialog_wifi_preferences` | int | 0x7f0d00cf | 20851 |
| `exo_list_divider` | int | 0x7f0d00d7 | 20854 |
| `exo_player_control_view` | int | 0x7f0d00d8 | 20857 |
| `exo_player_view` | int | 0x7f0d00d9 | 20860 |
| `exo_styled_player_control_ffwd_button` | int | 0x7f0d00da | 20863 |
| `exo_styled_player_control_rewind_button` | int | 0x7f0d00db | 20866 |
| `exo_styled_player_control_view` | int | 0x7f0d00dc | 20869 |
| `exo_styled_player_view` | int | 0x7f0d00dd | 20872 |
| `exo_styled_settings_list` | int | 0x7f0d00de | 20875 |
| `exo_styled_settings_list_item` | int | 0x7f0d00df | 20878 |
| `exo_styled_sub_settings_list_item` | int | 0x7f0d00e0 | 20881 |
| `exo_track_selection_dialog` | int | 0x7f0d00e1 | 20884 |
| `fragment_hisi_camera_pic` | int | 0x7f0d00ec | 20887 |
| `fragment_hisi_camera_record` | int | 0x7f0d00ed | 20890 |
| `frg_about` | int | 0x7f0d0102 | 20893 |
| `frg_album_page` | int | 0x7f0d0105 | 20896 |
| `frg_album_page_item_preview` | int | 0x7f0d0106 | 20899 |
| `frg_album_page_item_preview_wrapper` | int | 0x7f0d0107 | 20902 |
| `frg_camera_album` | int | 0x7f0d0108 | 20905 |
| `frg_connection` | int | 0x7f0d0109 | 20908 |
| `frg_dialog_agreemwnta_permission` | int | 0x7f0d010a | 20911 |
| `frg_home` | int | 0x7f0d010b | 20914 |
| `frg_local_album` | int | 0x7f0d010c | 20917 |
| `ime_base_split_test_activity` | int | 0x7f0d0115 | 20920 |
| `ime_secondary_split_test_activity` | int | 0x7f0d0116 | 20923 |
| `include_pickerview_topbar` | int | 0x7f0d0118 | 20926 |
| `item_camera_pic_amba` | int | 0x7f0d011d | 20929 |
| `item_camera_pic_hisi` | int | 0x7f0d011e | 20932 |
| `item_camera_record_amba` | int | 0x7f0d011f | 20935 |
| `item_camera_record_hisi` | int | 0x7f0d0120 | 20938 |
| `item_pic_preview_hisi` | int | 0x7f0d0125 | 20941 |
| `item_preference` | int | 0x7f0d0126 | 20944 |
| `item_preference_list_item` | int | 0x7f0d0127 | 20947 |
| `layout_basepickerview` | int | 0x7f0d012b | 20950 |
| `layout_progress_wheel_small` | int | 0x7f0d0150 | 20953 |
| `live_init_progress_dialog` | int | 0x7f0d016a | 20956 |
| `m3_alert_dialog` | int | 0x7f0d016e | 20959 |
| `m3_alert_dialog_actions` | int | 0x7f0d016f | 20962 |
| `m3_alert_dialog_title` | int | 0x7f0d0170 | 20965 |
| `m3_auto_complete_simple_item` | int | 0x7f0d0171 | 20968 |
| `m3_side_sheet_dialog` | int | 0x7f0d0172 | 20971 |
| `material_chip_input_combo` | int | 0x7f0d0176 | 20974 |
| `material_clock_display` | int | 0x7f0d0177 | 20977 |
| `material_clock_display_divider` | int | 0x7f0d0178 | 20980 |
| `material_clock_period_toggle` | int | 0x7f0d0179 | 20983 |
| `material_clock_period_toggle_land` | int | 0x7f0d017a | 20986 |
| `material_clockface_textview` | int | 0x7f0d017b | 20989 |
| `material_clockface_view` | int | 0x7f0d017c | 20992 |
| `material_radial_view_group` | int | 0x7f0d017d | 20995 |
| `material_textinput_timepicker` | int | 0x7f0d017e | 20998 |
| `material_time_chip` | int | 0x7f0d017f | 21001 |
| `material_time_input` | int | 0x7f0d0180 | 21004 |
| `material_timepicker` | int | 0x7f0d0181 | 21007 |
| `material_timepicker_dialog` | int | 0x7f0d0182 | 21010 |
| `material_timepicker_textinput_display` | int | 0x7f0d0183 | 21013 |
| `module_base_xtugo_dialog_ask` | int | 0x7f0d018b | 21016 |
| `module_camera_fragment_camera_pic` | int | 0x7f0d018c | 21019 |
| `module_camera_fragment_camera_record` | int | 0x7f0d018d | 21022 |
| `module_camera_item_pic_preview` | int | 0x7f0d018e | 21025 |
| `module_camera_item_tab_camera_file` | int | 0x7f0d018f | 21028 |
| `mtrl_alert_dialog` | int | 0x7f0d0190 | 21031 |
| `mtrl_alert_dialog_actions` | int | 0x7f0d0191 | 21034 |
| `mtrl_alert_dialog_title` | int | 0x7f0d0192 | 21037 |
| `mtrl_alert_select_dialog_item` | int | 0x7f0d0193 | 21040 |
| `mtrl_alert_select_dialog_multichoice` | int | 0x7f0d0194 | 21043 |
| `mtrl_alert_select_dialog_singlechoice` | int | 0x7f0d0195 | 21046 |
| `mtrl_auto_complete_simple_item` | int | 0x7f0d0196 | 21049 |
| `mtrl_calendar_day` | int | 0x7f0d0197 | 21052 |
| `mtrl_calendar_day_of_week` | int | 0x7f0d0198 | 21055 |
| `mtrl_calendar_days_of_week` | int | 0x7f0d0199 | 21058 |
| `mtrl_calendar_horizontal` | int | 0x7f0d019a | 21061 |
| `mtrl_calendar_month` | int | 0x7f0d019b | 21064 |
| `mtrl_calendar_month_labeled` | int | 0x7f0d019c | 21067 |
| `mtrl_calendar_month_navigation` | int | 0x7f0d019d | 21070 |
| `mtrl_calendar_months` | int | 0x7f0d019e | 21073 |
| `mtrl_calendar_vertical` | int | 0x7f0d019f | 21076 |
| `mtrl_calendar_year` | int | 0x7f0d01a0 | 21079 |
| `mtrl_layout_snackbar` | int | 0x7f0d01a1 | 21082 |
| `mtrl_layout_snackbar_include` | int | 0x7f0d01a2 | 21085 |
| `mtrl_navigation_rail_item` | int | 0x7f0d01a3 | 21088 |
| `mtrl_picker_actions` | int | 0x7f0d01a4 | 21091 |
| `mtrl_picker_dialog` | int | 0x7f0d01a5 | 21094 |
| `mtrl_picker_fullscreen` | int | 0x7f0d01a6 | 21097 |
| `mtrl_picker_header_dialog` | int | 0x7f0d01a7 | 21100 |
| `mtrl_picker_header_fullscreen` | int | 0x7f0d01a8 | 21103 |
| `mtrl_picker_header_selection_text` | int | 0x7f0d01a9 | 21106 |
| `mtrl_picker_header_title_text` | int | 0x7f0d01aa | 21109 |
| `mtrl_picker_header_toggle` | int | 0x7f0d01ab | 21112 |
| `mtrl_picker_text_input_date` | int | 0x7f0d01ac | 21115 |
| `mtrl_picker_text_input_date_range` | int | 0x7f0d01ad | 21118 |
| `mtrl_search_bar` | int | 0x7f0d01ae | 21121 |
| `mtrl_search_view` | int | 0x7f0d01af | 21124 |
| `my_activity_setting` | int | 0x7f0d01b1 | 21127 |
| `notification_action` | int | 0x7f0d01b4 | 21130 |
| `notification_action_tombstone` | int | 0x7f0d01b5 | 21133 |
| `notification_media_action` | int | 0x7f0d01b6 | 21136 |
| `notification_media_cancel_action` | int | 0x7f0d01b7 | 21139 |
| `notification_template_big_media` | int | 0x7f0d01b8 | 21142 |
| `notification_template_big_media_custom` | int | 0x7f0d01b9 | 21145 |
| `notification_template_big_media_narrow` | int | 0x7f0d01ba | 21148 |
| `notification_template_big_media_narrow_custom` | int | 0x7f0d01bb | 21151 |
| `notification_template_custom_big` | int | 0x7f0d01bc | 21154 |
| `notification_template_icon_group` | int | 0x7f0d01bd | 21157 |
| `notification_template_lines_media` | int | 0x7f0d01be | 21160 |
| `notification_template_media` | int | 0x7f0d01bf | 21163 |
| `notification_template_media_custom` | int | 0x7f0d01c0 | 21166 |
| `notification_template_part_chronometer` | int | 0x7f0d01c1 | 21169 |
| `notification_template_part_time` | int | 0x7f0d01c2 | 21172 |
| `pickerview_options` | int | 0x7f0d01c4 | 21175 |
| `pickerview_time` | int | 0x7f0d01c5 | 21178 |
| `ps_activity_container` | int | 0x7f0d01cb | 21181 |
| `ps_album_folder_item` | int | 0x7f0d01cc | 21184 |
| `ps_alert_dialog` | int | 0x7f0d01cd | 21187 |
| `ps_bottom_nav_bar` | int | 0x7f0d01ce | 21190 |
| `ps_common_dialog` | int | 0x7f0d01cf | 21193 |
| `ps_complete_selected_layout` | int | 0x7f0d01d0 | 21196 |
| `ps_custom_preview_image` | int | 0x7f0d01d1 | 21199 |
| `ps_dialog_camera_selected` | int | 0x7f0d01d2 | 21202 |
| `ps_empty` | int | 0x7f0d01d3 | 21205 |
| `ps_fragment_preview` | int | 0x7f0d01d4 | 21208 |
| `ps_fragment_selector` | int | 0x7f0d01d5 | 21211 |
| `ps_item_grid_audio` | int | 0x7f0d01d6 | 21214 |
| `ps_item_grid_camera` | int | 0x7f0d01d7 | 21217 |
| `ps_item_grid_image` | int | 0x7f0d01d8 | 21220 |
| `ps_item_grid_video` | int | 0x7f0d01d9 | 21223 |
| `ps_preview_audio` | int | 0x7f0d01da | 21226 |
| `ps_preview_gallery_item` | int | 0x7f0d01db | 21229 |
| `ps_preview_image` | int | 0x7f0d01dc | 21232 |
| `ps_preview_video` | int | 0x7f0d01dd | 21235 |
| `ps_remind_dialog` | int | 0x7f0d01de | 21238 |
| `ps_title_bar` | int | 0x7f0d01df | 21241 |
| `ps_window_folder` | int | 0x7f0d01e0 | 21244 |
| `sample_video_land` | int | 0x7f0d01e2 | 21247 |
| `sample_video_normal` | int | 0x7f0d01e3 | 21250 |
| `scankit_dialog_custom` | int | 0x7f0d01e5 | 21253 |
| `scankit_dialog_layout` | int | 0x7f0d01e6 | 21256 |
| `scankit_layout` | int | 0x7f0d01e7 | 21259 |
| `scankit_title_landscape` | int | 0x7f0d01e8 | 21262 |
| `scankit_zxl_capture` | int | 0x7f0d01e9 | 21265 |
| `scankit_zxl_capture_customed` | int | 0x7f0d01ea | 21268 |
| `scankit_zxl_capture_new` | int | 0x7f0d01eb | 21271 |
| `select_dialog_item_material` | int | 0x7f0d01ec | 21274 |
| `select_dialog_multichoice_material` | int | 0x7f0d01ed | 21277 |
| `select_dialog_singlechoice_material` | int | 0x7f0d01ee | 21280 |
| `splash_screen_view` | int | 0x7f0d01f6 | 21283 |
| `srl_classics_footer` | int | 0x7f0d01f7 | 21286 |
| `srl_classics_header` | int | 0x7f0d01f8 | 21289 |
| `support_simple_spinner_dropdown_item` | int | 0x7f0d01f9 | 21292 |
| `ucrop_activity_photobox` | int | 0x7f0d01fa | 21295 |
| `ucrop_aspect_ratio` | int | 0x7f0d01fb | 21298 |
| `ucrop_controls` | int | 0x7f0d01fc | 21301 |
| `ucrop_fragment_photobox` | int | 0x7f0d01fd | 21304 |
| `ucrop_layout_rotate_wheel` | int | 0x7f0d01fe | 21307 |
| `ucrop_layout_scale_wheel` | int | 0x7f0d01ff | 21310 |
| `ucrop_view` | int | 0x7f0d0200 | 21313 |
| `video_brightness` | int | 0x7f0d0205 | 21316 |
| `video_layout_ad` | int | 0x7f0d0206 | 21319 |
| `video_layout_custom` | int | 0x7f0d0207 | 21322 |
| `video_layout_normal` | int | 0x7f0d0208 | 21325 |
| `video_layout_sample_ad` | int | 0x7f0d0209 | 21328 |
| `video_layout_standard` | int | 0x7f0d020a | 21331 |
| `video_progress_dialog` | int | 0x7f0d020b | 21334 |
| `video_volume_dialog` | int | 0x7f0d020d | 21337 |
| `view_album_page_item_preview` | int | 0x7f0d020e | 21340 |
| `view_album_page_item_preview_wrapper` | int | 0x7f0d020f | 21343 |
| `view_camera_media_item` | int | 0x7f0d0211 | 21346 |
| `view_ijk_lib_player` | int | 0x7f0d0213 | 21349 |
| `view_local_album_item` | int | 0x7f0d0217 | 21352 |
| `view_normal_preference_view` | int | 0x7f0d0219 | 21355 |
| `view_preference_lis_item` | int | 0x7f0d021a | 21358 |
| `view_simple_toolbar` | int | 0x7f0d021b | 21361 |
| `zoom_rate_view` | int | 0x7f0d0220 | 21364 |
| `zxl_camera_scan` | int | 0x7f0d0222 | 21367 |

### `com.gku.xtugo.R$menu`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `menu_album_page_item_local` | int | 0x7f0f0000 | 21383 |
| `menu_album_page_item_preview` | int | 0x7f0f0001 | 21386 |
| `menu_camera_album` | int | 0x7f0f0003 | 21389 |
| `menu_camera_album_action_bar` | int | 0x7f0f0004 | 21392 |
| `menu_local_album_action_bar` | int | 0x7f0f0005 | 21395 |
| `menu_main_nav` | int | 0x7f0f0006 | 21398 |
| `ucrop_menu_activity` | int | 0x7f0f000d | 21401 |

### `com.gku.xtugo.R$mipmap`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `broadcast_loading` | int | 0x7f100014 | 21716 |
| `broadcast_loading_cancel` | int | 0x7f100015 | 21719 |
| `ic_launcher_round` | int | 0x7f100068 | 21722 |
| `live_loading` | int | 0x7f100098 | 21725 |
| `live_loading_cancel` | int | 0x7f100099 | 21728 |
| `scankit_back_mirroring` | int | 0x7f10010d | 21731 |
| `scankit_ic_photo` | int | 0x7f10010e | 21734 |
| `splish` | int | 0x7f10011a | 21737 |
| `xxx1` | int | 0x7f10013a | 21740 |

### `com.gku.xtugo.R$navigation`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `nav_home` | int | 0x7f110003 | 21752 |

### `com.gku.xtugo.R$plurals`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `exo_controls_fastforward_by_amount_description` | int | 0x7f120000 | 21762 |
| `exo_controls_rewind_by_amount_description` | int | 0x7f120001 | 21765 |
| `mtrl_badge_content_description` | int | 0x7f120002 | 21768 |

### `com.gku.xtugo.R$raw`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `camera_scan_beep` | int | 0x7f130000 | 21780 |
| `hisi_qs_icatch_image_preferences` | int | 0x7f130005 | 21783 |
| `hisi_qs_icatch_time_lapse_preferences` | int | 0x7f130006 | 21786 |
| `hisi_qs_icatch_video_preferences` | int | 0x7f130007 | 21789 |
| `photo_sound` | int | 0x7f130008 | 21792 |
| `ps_click_music` | int | 0x7f130009 | 21795 |
| `video_sound` | int | 0x7f13000c | 21798 |
| `xtu_icatch_common_preferences` | int | 0x7f13000d | 21801 |
| `zeus_keep_res_live` | int | 0x7f13000e | 21804 |
| `zeus_keep_res_ttm_player` | int | 0x7f13000f | 21807 |
| `zeus_keep_res_video` | int | 0x7f130010 | 21810 |

### `com.gku.xtugo.R$string`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `abc_action_bar_home_description` | int | 0x7f140011 | 21872 |
| `abc_action_bar_up_description` | int | 0x7f140012 | 21875 |
| `abc_action_menu_overflow_description` | int | 0x7f140013 | 21878 |
| `abc_action_mode_done` | int | 0x7f140014 | 21881 |
| `abc_activity_chooser_view_see_all` | int | 0x7f140015 | 21884 |
| `abc_activitychooserview_choose_application` | int | 0x7f140016 | 21887 |
| `abc_capital_off` | int | 0x7f140017 | 21890 |
| `abc_capital_on` | int | 0x7f140018 | 21893 |
| `abc_menu_alt_shortcut_label` | int | 0x7f140019 | 21896 |
| `abc_menu_ctrl_shortcut_label` | int | 0x7f14001a | 21899 |
| `abc_menu_delete_shortcut_label` | int | 0x7f14001b | 21902 |
| `abc_menu_enter_shortcut_label` | int | 0x7f14001c | 21905 |
| `abc_menu_function_shortcut_label` | int | 0x7f14001d | 21908 |
| `abc_menu_meta_shortcut_label` | int | 0x7f14001e | 21911 |
| `abc_menu_shift_shortcut_label` | int | 0x7f14001f | 21914 |
| `abc_menu_space_shortcut_label` | int | 0x7f140020 | 21917 |
| `abc_menu_sym_shortcut_label` | int | 0x7f140021 | 21920 |
| `abc_prepend_shortcut_label` | int | 0x7f140022 | 21923 |
| `abc_search_hint` | int | 0x7f140023 | 21926 |
| `abc_searchview_description_clear` | int | 0x7f140024 | 21929 |
| `abc_searchview_description_query` | int | 0x7f140025 | 21932 |
| `abc_searchview_description_search` | int | 0x7f140026 | 21935 |
| `abc_searchview_description_submit` | int | 0x7f140027 | 21938 |
| `abc_searchview_description_voice` | int | 0x7f140028 | 21941 |
| `abc_shareactionprovider_share_with` | int | 0x7f140029 | 21944 |
| `abc_shareactionprovider_share_with_application` | int | 0x7f14002a | 21947 |
| `abc_toolbar_collapse_description` | int | 0x7f14002b | 21950 |
| `about_app` | int | 0x7f14002c | 21953 |
| `about_camera` | int | 0x7f14002d | 21956 |
| `about_us` | int | 0x7f14002e | 21959 |
| `accept_failed` | int | 0x7f14002f | 21962 |
| `account_area` | int | 0x7f140030 | 21965 |
| `account_login` | int | 0x7f140031 | 21968 |
| `acquire_cloud_languages_fail` | int | 0x7f140032 | 21971 |
| `acquire_cloud_languages_success` | int | 0x7f140033 | 21974 |
| `action_delete` | int | 0x7f140034 | 21977 |
| `action_download` | int | 0x7f140035 | 21980 |
| `action_edit` | int | 0x7f140036 | 21983 |
| `action_fileInfo` | int | 0x7f140037 | 21986 |
| `action_processing` | int | 0x7f140038 | 21989 |
| `action_push` | int | 0x7f140039 | 21992 |
| `action_save` | int | 0x7f14003a | 21995 |
| `action_selectAll` | int | 0x7f14003b | 21998 |
| `action_share` | int | 0x7f14003c | 22001 |
| `activate_agree` | int | 0x7f14003d | 22004 |
| `activate_content_title` | int | 0x7f14003e | 22007 |
| `activate_success` | int | 0x7f14003f | 22010 |
| `activate_text_content` | int | 0x7f140040 | 22013 |
| `activate_title` | int | 0x7f140041 | 22016 |
| `activating` | int | 0x7f140042 | 22019 |
| `add_device` | int | 0x7f140043 | 22022 |
| `add_five_second` | int | 0x7f140044 | 22025 |
| `agree` | int | 0x7f140045 | 22028 |
| `agree_before` | int | 0x7f140046 | 22031 |
| `album` | int | 0x7f140047 | 22034 |
| `albumShare` | int | 0x7f140048 | 22037 |
| `all` | int | 0x7f140049 | 22040 |
| `all_audio` | int | 0x7f14004a | 22043 |
| `all_file` | int | 0x7f14004b | 22046 |
| `all_length_exceed` | int | 0x7f14004c | 22049 |
| `all_pic_folder_name` | int | 0x7f14004d | 22052 |
| `all_readed` | int | 0x7f14004e | 22055 |
| `all_video_folder_name` | int | 0x7f14004f | 22058 |
| `already_last` | int | 0x7f140050 | 22061 |
| `already_latest` | int | 0x7f140051 | 22064 |
| `already_the_latest_version` | int | 0x7f140052 | 22067 |
| `amba_device_occupied` | int | 0x7f140053 | 22070 |
| `amba_exit` | int | 0x7f140054 | 22073 |
| `amba_init_failed` | int | 0x7f140055 | 22076 |
| `amba_reload` | int | 0x7f140056 | 22079 |
| `and` | int | 0x7f140057 | 22082 |
| `androidx_startup` | int | 0x7f140058 | 22085 |
| `announcement` | int | 0x7f140059 | 22088 |
| `announcement_latest` | int | 0x7f14005a | 22091 |
| `app_beian_biaohao` | int | 0x7f14005c | 22097 |
| `app_name` | int | 0x7f14005d | 22100 |
| `app_version` | int | 0x7f14005e | 22103 |
| `appbar_scrolling_view_behavior` | int | 0x7f14005f | 22106 |
| `appInfo` | int | 0x7f14005b | 22094 |
| `arabic` | int | 0x7f140060 | 22109 |
| `area` | int | 0x7f140061 | 22112 |
| `area_choose_hint` | int | 0x7f140062 | 22115 |
| `audio` | int | 0x7f140063 | 22118 |
| `audio_clipping` | int | 0x7f140064 | 22121 |
| `audio_codec` | int | 0x7f140065 | 22124 |
| `audio_lower_limit` | int | 0x7f140066 | 22127 |
| `audio_record` | int | 0x7f140067 | 22130 |
| `audio_unit` | int | 0x7f140068 | 22133 |
| `auth_fail` | int | 0x7f140069 | 22136 |
| `authed` | int | 0x7f14006a | 22139 |
| `authorization` | int | 0x7f14006b | 22142 |
| `authorized` | int | 0x7f14006c | 22145 |
| `auto_rename` | int | 0x7f14006d | 22148 |
| `back_finsh_activity` | int | 0x7f14006e | 22151 |
| `back_to_register` | int | 0x7f14006f | 22154 |
| `batchSelection` | int | 0x7f140070 | 22157 |
| `be_careful` | int | 0x7f140071 | 22160 |
| `beep_sound` | int | 0x7f140072 | 22163 |
| `bilibli_live` | int | 0x7f140073 | 22166 |
| `bitrate` | int | 0x7f140074 | 22169 |
| `bitrate_flue` | int | 0x7f140075 | 22172 |
| `bitrate_high` | int | 0x7f140076 | 22175 |
| `blbl` | int | 0x7f140077 | 22178 |
| `ble_exit_app` | int | 0x7f140078 | 22181 |
| `ble_location_not_open` | int | 0x7f140079 | 22184 |
| `ble_location_notice` | int | 0x7f14007a | 22187 |
| `ble_location_open` | int | 0x7f14007b | 22190 |
| `ble_not_open` | int | 0x7f14007c | 22193 |
| `ble_not_support` | int | 0x7f14007d | 22196 |
| `ble_open` | int | 0x7f14007e | 22199 |
| `bluetooth_permission_description_hyh` | int | 0x7f14007f | 22202 |
| `bluetooth_permission_hyh` | int | 0x7f140080 | 22205 |
| `boot_action` | int | 0x7f140081 | 22208 |
| `boot_sound` | int | 0x7f140082 | 22211 |
| `bottom_sheet_behavior` | int | 0x7f140083 | 22214 |
| `bottomsheet_action_collapse` | int | 0x7f140084 | 22217 |
| `bottomsheet_action_expand` | int | 0x7f140085 | 22220 |
| `bottomsheet_action_expand_halfway` | int | 0x7f140086 | 22223 |
| `bottomsheet_drag_handle_clicked` | int | 0x7f140087 | 22226 |
| `bottomsheet_drag_handle_content_description` | int | 0x7f140088 | 22229 |
| `broadcast_in_loading` | int | 0x7f140089 | 22232 |
| `broadcast_in_loading_failed` | int | 0x7f14008a | 22235 |
| `brvah_load_complete` | int | 0x7f14008b | 22238 |
| `brvah_load_end` | int | 0x7f14008c | 22241 |
| `brvah_load_failed` | int | 0x7f14008d | 22244 |
| `brvah_loading` | int | 0x7f14008e | 22247 |
| `bt_add_device` | int | 0x7f14008f | 22250 |
| `btn_send_code_text_1` | int | 0x7f140090 | 22253 |
| `build_date` | int | 0x7f140091 | 22256 |
| `burst_10` | int | 0x7f140092 | 22259 |
| `burst_15` | int | 0x7f140093 | 22262 |
| `burst_3` | int | 0x7f140094 | 22265 |
| `burst_30` | int | 0x7f140095 | 22268 |
| `burst_5` | int | 0x7f140096 | 22271 |
| `burst_7` | int | 0x7f140097 | 22274 |
| `burst_hs` | int | 0x7f140098 | 22277 |
| `burst_off` | int | 0x7f140099 | 22280 |
| `burst_rate_1_10` | int | 0x7f14009a | 22283 |
| `burst_rate_1_15` | int | 0x7f14009b | 22286 |
| `burst_rate_1_2` | int | 0x7f14009c | 22289 |
| `burst_rate_1_20` | int | 0x7f14009d | 22292 |
| `burst_rate_1_25` | int | 0x7f14009e | 22295 |
| `burst_rate_1_3` | int | 0x7f14009f | 22298 |
| `burst_rate_1_30` | int | 0x7f1400a0 | 22301 |
| `burst_rate_1_5` | int | 0x7f1400a1 | 22304 |
| `button_allow` | int | 0x7f1400a2 | 22307 |
| `button_deny` | int | 0x7f1400a3 | 22310 |
| `cache_has_been_emptied` | int | 0x7f1400a4 | 22313 |
| `call_notification_answer_action` | int | 0x7f1400a5 | 22316 |
| `call_notification_answer_video_action` | int | 0x7f1400a6 | 22319 |
| `call_notification_decline_action` | int | 0x7f1400a7 | 22322 |
| `call_notification_hang_up_action` | int | 0x7f1400a8 | 22325 |
| `call_notification_incoming_text` | int | 0x7f1400a9 | 22328 |
| `call_notification_ongoing_text` | int | 0x7f1400aa | 22331 |
| `call_notification_screening_text` | int | 0x7f1400ab | 22334 |
| `call_phone_permission_description_hyh` | int | 0x7f1400ac | 22337 |
| `call_phone_permission_hyh` | int | 0x7f1400ad | 22340 |
| `cam_setting_1_minute` | int | 0x7f1400ae | 22343 |
| `cam_setting_1_photo` | int | 0x7f1400af | 22346 |
| `cam_setting_2_minutes` | int | 0x7f1400b0 | 22349 |
| `cam_setting_2_photos` | int | 0x7f1400b1 | 22352 |
| `cam_setting_3_minutes` | int | 0x7f1400b2 | 22355 |
| `cam_setting_3_photos` | int | 0x7f1400b3 | 22358 |
| `cam_setting_auto` | int | 0x7f1400b4 | 22361 |
| `cam_setting_auto_wifi_off` | int | 0x7f1400b5 | 22364 |
| `cam_setting_camera_name` | int | 0x7f1400b6 | 22367 |
| `cam_setting_date_stamp` | int | 0x7f1400b7 | 22370 |
| `cam_setting_default_setting` | int | 0x7f1400b8 | 22373 |
| `cam_setting_economy` | int | 0x7f1400b9 | 22376 |
| `cam_setting_exit_wifi` | int | 0x7f1400ba | 22379 |
| `cam_setting_format` | int | 0x7f1400bb | 22382 |
| `cam_setting_fw_version` | int | 0x7f1400bc | 22385 |
| `cam_setting_high` | int | 0x7f1400bd | 22388 |
| `cam_setting_image_size` | int | 0x7f1400be | 22391 |
| `cam_setting_low` | int | 0x7f1400bf | 22394 |
| `cam_setting_med` | int | 0x7f1400c0 | 22397 |
| `cam_setting_mode` | int | 0x7f1400c1 | 22400 |
| `cam_setting_movie` | int | 0x7f1400c2 | 22403 |
| `cam_setting_photo` | int | 0x7f1400c3 | 22406 |
| `cam_setting_photo_movie` | int | 0x7f1400c4 | 22409 |
| `cam_setting_picture_no` | int | 0x7f1400c5 | 22412 |
| `cam_setting_pir_interval` | int | 0x7f1400c6 | 22415 |
| `cam_setting_pir_sensitivity` | int | 0x7f1400c7 | 22418 |
| `cam_setting_record_audio` | int | 0x7f1400c8 | 22421 |
| `cam_setting_resolution` | int | 0x7f1400c9 | 22424 |
| `cam_setting_sdcard_space` | int | 0x7f1400ca | 22427 |
| `cam_setting_super_fine` | int | 0x7f1400cb | 22430 |
| `cam_setting_time_format` | int | 0x7f1400cc | 22433 |
| `cam_setting_time_lapse` | int | 0x7f1400cd | 22436 |
| `cam_setting_timing_1_start` | int | 0x7f1400ce | 22439 |
| `cam_setting_timing_1_stop` | int | 0x7f1400cf | 22442 |
| `cam_setting_timing_2_start` | int | 0x7f1400d0 | 22445 |
| `cam_setting_timing_2_stop` | int | 0x7f1400d1 | 22448 |
| `cam_setting_timing_interval` | int | 0x7f1400d2 | 22451 |
| `cam_setting_timing_mode` | int | 0x7f1400d3 | 22454 |
| `cam_setting_video_length` | int | 0x7f1400d4 | 22457 |
| `cam_setting_wifi_settings` | int | 0x7f1400d5 | 22460 |
| `cam_settings` | int | 0x7f1400d6 | 22463 |
| `camera` | int | 0x7f1400d7 | 22466 |
| `camera_configuration_set` | int | 0x7f1400d9 | 22472 |
| `camera_dash` | int | 0x7f1400da | 22475 |
| `camera_file` | int | 0x7f1400db | 22478 |
| `camera_gallery` | int | 0x7f1400dc | 22481 |
| `camera_hd_video` | int | 0x7f1400dd | 22484 |
| `camera_live_streaming` | int | 0x7f1400de | 22487 |
| `camera_max2` | int | 0x7f1400df | 22490 |
| `camera_maxpro` | int | 0x7f1400e0 | 22493 |
| `camera_mini2pro` | int | 0x7f1400e1 | 22496 |
| `camera_name` | int | 0x7f1400e2 | 22499 |
| `camera_name_limit` | int | 0x7f1400e3 | 22502 |
| `camera_no_modename` | int | 0x7f1400e4 | 22505 |
| `camera_off` | int | 0x7f1400e5 | 22508 |
| `camera_on` | int | 0x7f1400e6 | 22511 |
| `camera_permission_ask` | int | 0x7f1400e7 | 22514 |
| `camera_photo` | int | 0x7f1400e8 | 22517 |
| `camera_r1` | int | 0x7f1400e9 | 22520 |
| `camera_record_audio_storage_permission_ask` | int | 0x7f1400ea | 22523 |
| `camera_s2` | int | 0x7f1400eb | 22526 |
| `camera_s3` | int | 0x7f1400ec | 22529 |
| `camera_s3pro` | int | 0x7f1400ed | 22532 |
| `camera_s5k` | int | 0x7f1400ee | 22535 |
| `camera_s6pro` | int | 0x7f1400ef | 22538 |
| `camera_s7` | int | 0x7f1400f0 | 22541 |
| `camera_s7pro` | int | 0x7f1400f1 | 22544 |
| `camera_s7promax` | int | 0x7f1400f2 | 22547 |
| `camera_set` | int | 0x7f1400f3 | 22550 |
| `camera_video` | int | 0x7f1400f4 | 22553 |
| `camera_view_get_fail` | int | 0x7f1400f5 | 22556 |
| `camera_view_only_one` | int | 0x7f1400f6 | 22559 |
| `camera_wifi_configuration` | int | 0x7f1400f7 | 22562 |
| `camera_wifi_infor` | int | 0x7f1400f8 | 22565 |
| `camera_wifi_name` | int | 0x7f1400f9 | 22568 |
| `camera_wifi_password` | int | 0x7f1400fa | 22571 |
| `camera_xtu` | int | 0x7f1400fb | 22574 |
| `camera_xu1` | int | 0x7f1400fc | 22577 |
| `camera_xu2` | int | 0x7f1400fd | 22580 |
| `cameraInfo` | int | 0x7f1400d8 | 22469 |
| `can_open_link_url` | int | 0x7f1400fe | 22583 |
| `cancel` | int | 0x7f1400ff | 22586 |
| `cancel_fail` | int | 0x7f140100 | 22589 |
| `cancel_match` | int | 0x7f140101 | 22592 |
| `cancel_success` | int | 0x7f140102 | 22595 |
| `capture_completed` | int | 0x7f140103 | 22598 |
| `car_app_library_version` | int | 0x7f140104 | 22601 |
| `card_storage` | int | 0x7f140105 | 22604 |
| `case_ui_core_check_wifi` | int | 0x7f140106 | 22607 |
| `case_ui_core_connection_failed` | int | 0x7f140107 | 22610 |
| `case_ui_core_delete_file_tips` | int | 0x7f140108 | 22613 |
| `case_ui_core_downloader_complete_title` | int | 0x7f140109 | 22616 |
| `case_ui_core_downloader_title` | int | 0x7f14010a | 22619 |
| `case_ui_core_lost_device` | int | 0x7f14010b | 22622 |
| `case_ui_core_no_scard` | int | 0x7f14010c | 22625 |
| `case_ui_core_operation_failed` | int | 0x7f14010d | 22628 |
| `case_ui_core_storage_FULL` | int | 0x7f14010e | 22631 |
| `case_ui_core_sync_state_error` | int | 0x7f14010f | 22634 |
| `case_ui_core_wifi_connection_failed` | int | 0x7f140110 | 22637 |
| `character_counter_content_description` | int | 0x7f140111 | 22640 |
| `character_counter_overflowed_content_description` | int | 0x7f140112 | 22643 |
| `character_counter_pattern` | int | 0x7f140113 | 22646 |
| `chat_on_whatsapp` | int | 0x7f140114 | 22649 |
| `check_internet` | int | 0x7f140115 | 22652 |
| `check_net` | int | 0x7f140116 | 22655 |
| `check_net_device_click_retry` | int | 0x7f140117 | 22658 |
| `check_newest_cam_firm` | int | 0x7f140118 | 22661 |
| `check_newest_cam_firm_version` | int | 0x7f140119 | 22664 |
| `check_newest_cam_version_fail` | int | 0x7f14011a | 22667 |
| `check_newest_cam_version_fail_hint` | int | 0x7f14011b | 22670 |
| `check_update` | int | 0x7f14011c | 22673 |
| `check_version` | int | 0x7f14011d | 22676 |
| `checked_update` | int | 0x7f14011e | 22679 |
| `chinese_simplified` | int | 0x7f14011f | 22682 |
| `chinese_traditional` | int | 0x7f140120 | 22685 |
| `chinese_traditional_hk` | int | 0x7f140121 | 22688 |
| `chinese_traditional_tw` | int | 0x7f140122 | 22691 |
| `chip` | int | 0x7f140123 | 22694 |
| `chongshi` | int | 0x7f140124 | 22697 |
| `choose` | int | 0x7f140125 | 22700 |
| `choose_area_first` | int | 0x7f140126 | 22703 |
| `choose_content` | int | 0x7f140127 | 22706 |
| `choose_device` | int | 0x7f140128 | 22709 |
| `choose_device_type` | int | 0x7f140129 | 22712 |
| `choose_email_app` | int | 0x7f14012a | 22715 |
| `choose_file_first` | int | 0x7f14012b | 22718 |
| `choose_live_platform` | int | 0x7f14012c | 22721 |
| `choose_net` | int | 0x7f14012d | 22724 |
| `choose_pic_first` | int | 0x7f14012e | 22727 |
| `choose_problem_type` | int | 0x7f14012f | 22730 |
| `choose_type_first` | int | 0x7f140130 | 22733 |
| `choose_wifi` | int | 0x7f140131 | 22736 |
| `choosed` | int | 0x7f140132 | 22739 |
| `clear_cache` | int | 0x7f140133 | 22742 |
| `clear_cache_success` | int | 0x7f140134 | 22745 |
| `clear_text_end_icon_content_description` | int | 0x7f140135 | 22748 |
| `click_add_pic` | int | 0x7f140136 | 22751 |
| `click_problem_type` | int | 0x7f140137 | 22754 |
| `click_product_model` | int | 0x7f140138 | 22757 |
| `click_product_type` | int | 0x7f140139 | 22760 |
| `click_retry` | int | 0x7f14013a | 22763 |
| `client_version` | int | 0x7f14013b | 22766 |
| `close_live_room` | int | 0x7f14013c | 22769 |
| `close_live_success` | int | 0x7f14013d | 22772 |
| `close_stream` | int | 0x7f14013e | 22775 |
| `close_stream_success` | int | 0x7f14013f | 22778 |
| `collect` | int | 0x7f140140 | 22781 |
| `colon` | int | 0x7f140141 | 22784 |
| `comming_soon` | int | 0x7f140142 | 22787 |
| `comming_soon2` | int | 0x7f140143 | 22790 |
| `comming_soon3` | int | 0x7f140144 | 22793 |
| `common_error_token_invalide` | int | 0x7f140145 | 22796 |
| `common_error_vcode_prequen` | int | 0x7f140146 | 22799 |
| `common_google_play_services_enable_button` | int | 0x7f140147 | 22802 |
| `common_google_play_services_enable_text` | int | 0x7f140148 | 22805 |
| `common_google_play_services_enable_title` | int | 0x7f140149 | 22808 |
| `common_google_play_services_install_button` | int | 0x7f14014a | 22811 |
| `common_google_play_services_install_text` | int | 0x7f14014b | 22814 |
| `common_google_play_services_install_title` | int | 0x7f14014c | 22817 |
| `common_google_play_services_notification_channel_name` | int | 0x7f14014d | 22820 |
| `common_google_play_services_notification_ticker` | int | 0x7f14014e | 22823 |
| `common_google_play_services_unknown_issue` | int | 0x7f14014f | 22826 |
| `common_google_play_services_unsupported_text` | int | 0x7f140150 | 22829 |
| `common_google_play_services_update_button` | int | 0x7f140151 | 22832 |
| `common_google_play_services_update_text` | int | 0x7f140152 | 22835 |
| `common_google_play_services_update_title` | int | 0x7f140153 | 22838 |
| `common_google_play_services_updating_text` | int | 0x7f140154 | 22841 |
| `common_google_play_services_wear_update_text` | int | 0x7f140155 | 22844 |
| `common_open_on_phone` | int | 0x7f140156 | 22847 |
| `common_signin_button_text` | int | 0x7f140157 | 22850 |
| `common_signin_button_text_long` | int | 0x7f140158 | 22853 |
| `complete` | int | 0x7f140159 | 22856 |
| `config_send_firm` | int | 0x7f14015a | 22859 |
| `config_stream` | int | 0x7f14015b | 22862 |
| `confirm` | int | 0x7f14015c | 22865 |
| `confirm_0_0` | int | 0x7f14015d | 22868 |
| `confirm_clear_cache` | int | 0x7f14015e | 22871 |
| `confirm_close_stream` | int | 0x7f14015f | 22874 |
| `confirm_start_live` | int | 0x7f140160 | 22877 |
| `confirm_start_live_broken_deivce` | int | 0x7f140161 | 22880 |
| `confirm_stream_and_disconnect` | int | 0x7f140162 | 22883 |
| `connect` | int | 0x7f140163 | 22886 |
| `connect_camera` | int | 0x7f140164 | 22889 |
| `connect_camera_network` | int | 0x7f140165 | 22892 |
| `connect_device` | int | 0x7f140166 | 22895 |
| `connect_device_wifi` | int | 0x7f140167 | 22898 |
| `connect_error_hint` | int | 0x7f140168 | 22901 |
| `connect_failed` | int | 0x7f140169 | 22904 |
| `connect_motion_camera_wifi` | int | 0x7f14016a | 22907 |
| `connect_net_available_first` | int | 0x7f14016b | 22910 |
| `connect_start` | int | 0x7f14016c | 22913 |
| `connect_success` | int | 0x7f14016d | 22916 |
| `connect_timeout` | int | 0x7f14016e | 22919 |
| `connect_wifi` | int | 0x7f14016f | 22922 |
| `ConnectCameraThenConnectAvailableInternet` | int | 0x7f140000 | 21821 |
| `connected_camera` | int | 0x7f140170 | 22925 |
| `connected_camera_1` | int | 0x7f140171 | 22928 |
| `connected_for_stream` | int | 0x7f140172 | 22931 |
| `connected_not_camera` | int | 0x7f140173 | 22934 |
| `connected_start_live` | int | 0x7f140174 | 22937 |
| `connected_update_version_text` | int | 0x7f140175 | 22940 |
| `connecting` | int | 0x7f140176 | 22943 |
| `contactDetails` | int | 0x7f140177 | 22946 |
| `contactHint` | int | 0x7f140178 | 22949 |
| `contactUs` | int | 0x7f140179 | 22952 |
| `contentEmpty` | int | 0x7f14017a | 22955 |
| `contentHint` | int | 0x7f14017b | 22958 |
| `continue_live` | int | 0x7f14017c | 22961 |
| `copy_file_dialog_title` | int | 0x7f14017d | 22964 |
| `copy_finish` | int | 0x7f14017e | 22967 |
| `copy_send_version` | int | 0x7f14017f | 22970 |
| `copy_success` | int | 0x7f140180 | 22973 |
| `copyed_email` | int | 0x7f140181 | 22976 |
| `crashError` | int | 0x7f140182 | 22979 |
| `create_time_` | int | 0x7f140183 | 22982 |
| `current_day_no_record` | int | 0x7f140184 | 22985 |
| `current_size_not_support_image_stabilization` | int | 0x7f140185 | 22988 |
| `current_size_not_support_slow_motion` | int | 0x7f140186 | 22991 |
| `CurrentIsLatest` | int | 0x7f140001 | 21824 |
| `customerServiceHotline` | int | 0x7f140187 | 22994 |
| `cut` | int | 0x7f140188 | 22997 |
| `cv_app_name` | int | 0x7f140189 | 23000 |
| `dateStamp_date` | int | 0x7f14018a | 23003 |
| `dateStamp_date_and_time` | int | 0x7f14018b | 23006 |
| `dateStamp_off` | int | 0x7f14018c | 23009 |
| `decode_fail` | int | 0x7f14018d | 23012 |
| `delall_tip` | int | 0x7f14018e | 23015 |
| `delete` | int | 0x7f14018f | 23018 |
| `delete_account` | int | 0x7f140190 | 23021 |
| `delete_account_dialog_content` | int | 0x7f140191 | 23024 |
| `delete_account_dialog_title` | int | 0x7f140192 | 23027 |
| `delete_account_pt` | int | 0x7f140193 | 23030 |
| `delete_account_success` | int | 0x7f140194 | 23033 |
| `delete_all_files` | int | 0x7f140195 | 23036 |
| `delete_complete` | int | 0x7f140196 | 23039 |
| `delete_fail` | int | 0x7f140197 | 23042 |
| `delete_fail_des` | int | 0x7f140198 | 23045 |
| `delete_file_tips` | int | 0x7f140199 | 23048 |
| `delete_finish_failed` | int | 0x7f14019b | 23054 |
| `delete_finish2` | int | 0x7f14019a | 23051 |
| `delete_format` | int | 0x7f14019c | 23057 |
| `delete_success` | int | 0x7f14019d | 23060 |
| `delete_success_des` | int | 0x7f14019e | 23063 |
| `deletefile_msg` | int | 0x7f14019f | 23066 |
| `deletefile_msg2` | int | 0x7f1401a0 | 23069 |
| `deletefile_success` | int | 0x7f1401a1 | 23072 |
| `deletefile_tip` | int | 0x7f1401a2 | 23075 |
| `deletionFailure` | int | 0x7f1401a3 | 23078 |
| `des_login` | int | 0x7f1401a4 | 23081 |
| `des_register` | int | 0x7f1401a5 | 23084 |
| `desc_20` | int | 0x7f1401a6 | 23087 |
| `deselect` | int | 0x7f1401a7 | 23090 |
| `device_connect` | int | 0x7f1401a9 | 23096 |
| `device_connect_fail_try` | int | 0x7f1401aa | 23099 |
| `device_connect_fail_try_or_restart` | int | 0x7f1401ab | 23102 |
| `device_connect_fail_try_restart` | int | 0x7f1401ac | 23105 |
| `device_connected` | int | 0x7f1401ad | 23108 |
| `device_manage` | int | 0x7f1401ae | 23111 |
| `device_manager` | int | 0x7f1401af | 23114 |
| `device_no_media` | int | 0x7f1401b0 | 23117 |
| `device_no_pic` | int | 0x7f1401b1 | 23120 |
| `device_no_video` | int | 0x7f1401b2 | 23123 |
| `device_permission` | int | 0x7f1401b3 | 23126 |
| `device_searching` | int | 0x7f1401b4 | 23129 |
| `device_set` | int | 0x7f1401b5 | 23132 |
| `device_setting` | int | 0x7f1401b6 | 23135 |
| `device_shared` | int | 0x7f1401b7 | 23138 |
| `deviceConnect` | int | 0x7f1401a8 | 23093 |
| `devicer_manager_auto_clear_download` | int | 0x7f1401b8 | 23141 |
| `devicer_manager_auto_download` | int | 0x7f1401b9 | 23144 |
| `devicer_manager_check_update` | int | 0x7f1401ba | 23147 |
| `devicer_manager_delete_hint` | int | 0x7f1401bb | 23150 |
| `devicer_manager_download_fw` | int | 0x7f1401bc | 23153 |
| `devicer_manager_no_devices` | int | 0x7f1401bd | 23156 |
| `devicer_manager_ready_start` | int | 0x7f1401be | 23159 |
| `devicer_manager_start_upgrade` | int | 0x7f1401bf | 23162 |
| `devicer_manager_start_upgrade_disable` | int | 0x7f1401c0 | 23165 |
| `devicer_manager_transfer_error_hint` | int | 0x7f1401c1 | 23168 |
| `devicer_manager_transfer_failed` | int | 0x7f1401c2 | 23171 |
| `devicer_manager_transfer_success` | int | 0x7f1401c3 | 23174 |
| `devicer_manager_transfering` | int | 0x7f1401c4 | 23177 |
| `devicer_manager_transfering_hint` | int | 0x7f1401c5 | 23180 |
| `devicer_manager_update_available` | int | 0x7f1401c6 | 23183 |
| `devicer_manager_update_check` | int | 0x7f1401c7 | 23186 |
| `devicer_manager_upgrade_to` | int | 0x7f1401c8 | 23189 |
| `devicer_manager_what_new` | int | 0x7f1401c9 | 23192 |
| `dialog_cancel` | int | 0x7f1401ca | 23195 |
| `dialog_cancel_downloading_failed` | int | 0x7f1401cb | 23198 |
| `dialog_cancel_downloading_succeeded` | int | 0x7f1401cc | 23201 |
| `dialog_card_removed_and_back` | int | 0x7f1401cd | 23204 |
| `dialog_card_removed_and_back_photo_pb` | int | 0x7f1401ce | 23207 |
| `dialog_delete_failed_single` | int | 0x7f1401cf | 23210 |
| `dialog_deleting` | int | 0x7f1401d0 | 23213 |
| `dialog_download_video` | int | 0x7f1401d1 | 23216 |
| `dialog_downloading_single` | int | 0x7f1401d2 | 23219 |
| `dialog_failed` | int | 0x7f1401d3 | 23222 |
| `dialog_go_setting` | int | 0x7f1401d4 | 23225 |
| `dialog_message` | int | 0x7f1401d5 | 23228 |
| `dialog_message_no_local` | int | 0x7f1401d6 | 23231 |
| `dialog_ok` | int | 0x7f1401d7 | 23234 |
| `dialog_preview` | int | 0x7f1401d8 | 23237 |
| `dialog_time_hour` | int | 0x7f1401d9 | 23240 |
| `dialog_time_minute` | int | 0x7f1401da | 23243 |
| `dialog_time_sec` | int | 0x7f1401db | 23246 |
| `disagree` | int | 0x7f1401dc | 23249 |
| `discoverDevice` | int | 0x7f1401dd | 23252 |
| `discoverNewVersion` | int | 0x7f1401de | 23255 |
| `do_not_find_devices` | int | 0x7f1401df | 23258 |
| `douyin_live` | int | 0x7f1401e1 | 23261 |
| `douyin_live_setting` | int | 0x7f1401e2 | 23264 |
| `down_load_size_big` | int | 0x7f1401e3 | 23267 |
| `down_load_size_small` | int | 0x7f1401e4 | 23270 |
| `down_load_size_sure` | int | 0x7f1401e5 | 23273 |
| `download_cancel` | int | 0x7f1401e8 | 23282 |
| `download_cancel_all_tips` | int | 0x7f1401e9 | 23285 |
| `download_complete` | int | 0x7f1401ea | 23288 |
| `download_complete_result` | int | 0x7f1401eb | 23291 |
| `download_exception` | int | 0x7f1401ec | 23294 |
| `download_fail_may_no_space` | int | 0x7f1401ed | 23297 |
| `download_finish` | int | 0x7f1401ee | 23300 |
| `download_finish_failed` | int | 0x7f1401f0 | 23306 |
| `download_finish2` | int | 0x7f1401ef | 23303 |
| `download_format` | int | 0x7f1401f1 | 23309 |
| `download_hint` | int | 0x7f1401f2 | 23312 |
| `download_manager` | int | 0x7f1401f3 | 23315 |
| `download_message` | int | 0x7f1401f4 | 23318 |
| `download_progress` | int | 0x7f1401f5 | 23321 |
| `download_tip` | int | 0x7f1401f6 | 23324 |
| `download_tips` | int | 0x7f1401f7 | 23327 |
| `download_title` | int | 0x7f1401f8 | 23330 |
| `download_video` | int | 0x7f1401f9 | 23333 |
| `downloaded` | int | 0x7f1401fa | 23336 |
| `downloaded_fail` | int | 0x7f1401fb | 23339 |
| `downloaded_no` | int | 0x7f1401fc | 23342 |
| `DownloadFailed` | int | 0x7f140002 | 21827 |
| `downloading` | int | 0x7f1401fd | 23345 |
| `downloading_update_pack` | int | 0x7f1401fe | 23348 |
| `DownloadProgress` | int | 0x7f140003 | 21830 |
| `DownloadSuccessfully` | int | 0x7f140004 | 21833 |
| `downloadToLocal_hint` | int | 0x7f1401e6 | 23276 |
| `downloadVideoToLocal_hint` | int | 0x7f1401e7 | 23279 |
| `edit_failed` | int | 0x7f1401ff | 23351 |
| `editor_tools_brightness` | int | 0x7f140200 | 23354 |
| `editor_tools_contrast` | int | 0x7f140201 | 23357 |
| `editor_tools_crop` | int | 0x7f140202 | 23360 |
| `editor_tools_exposure` | int | 0x7f140203 | 23363 |
| `editor_tools_hue` | int | 0x7f140204 | 23366 |
| `editor_tools_rotation_left` | int | 0x7f140205 | 23369 |
| `editor_tools_rotation_right` | int | 0x7f140206 | 23372 |
| `editor_tools_saturation` | int | 0x7f140207 | 23375 |
| `editor_tools_sharpness` | int | 0x7f140208 | 23378 |
| `electronic_fence_crossing_inner` | int | 0x7f140209 | 23381 |
| `electronic_fence_crossing_outer` | int | 0x7f14020a | 23384 |
| `email` | int | 0x7f14020b | 23387 |
| `emailError` | int | 0x7f14020c | 23390 |
| `emergency_video` | int | 0x7f14020d | 23393 |
| `end_announcement` | int | 0x7f14020e | 23396 |
| `english` | int | 0x7f14020f | 23399 |
| `English` | int | 0x7f140005 | 21836 |
| `enter_app_hyh` | int | 0x7f140210 | 23402 |
| `enter_camera` | int | 0x7f140211 | 23405 |
| `enter_exchange_code` | int | 0x7f140212 | 23408 |
| `err_return_null` | int | 0x7f140213 | 23411 |
| `error_0` | int | 0x7f140214 | 23414 |
| `error_1` | int | 0x7f140215 | 23417 |
| `error_12` | int | 0x7f140216 | 23420 |
| `error_2` | int | 0x7f140217 | 23423 |
| `error_3` | int | 0x7f140218 | 23426 |
| `error_4` | int | 0x7f140219 | 23429 |
| `error_5` | int | 0x7f14021a | 23432 |
| `error_6` | int | 0x7f14021b | 23435 |
| `error_7` | int | 0x7f14021c | 23438 |
| `error_8` | int | 0x7f14021d | 23441 |
| `error_9` | int | 0x7f14021e | 23444 |
| `error_a11y_label` | int | 0x7f14021f | 23447 |
| `error_channel_busy` | int | 0x7f140220 | 23450 |
| `error_get_channel_state_fail` | int | 0x7f140221 | 23453 |
| `error_icon_content_description` | int | 0x7f140222 | 23456 |
| `error_loop_no_space` | int | 0x7f140223 | 23459 |
| `error_no_sd` | int | 0x7f140224 | 23462 |
| `error_record_no_space` | int | 0x7f140225 | 23465 |
| `error_sd_error` | int | 0x7f140226 | 23468 |
| `error_sd_full` | int | 0x7f140227 | 23471 |
| `error_snapshot_no_space` | int | 0x7f140228 | 23474 |
| `error_snapshot_param_error` | int | 0x7f140229 | 23477 |
| `error_start_channel_fail` | int | 0x7f14022a | 23480 |
| `error_stop_channel_fail` | int | 0x7f14022b | 23483 |
| `event` | int | 0x7f14022c | 23486 |
| `event_ac_off` | int | 0x7f14022d | 23489 |
| `event_ac_on` | int | 0x7f14022e | 23492 |
| `event_battery_temperature_alarm` | int | 0x7f14022f | 23495 |
| `event_battery_temperature_high` | int | 0x7f140230 | 23498 |
| `event_chip_temperature_alarm` | int | 0x7f140231 | 23501 |
| `event_chip_temperature_high` | int | 0x7f140232 | 23504 |
| `event_low_power` | int | 0x7f140233 | 23507 |
| `event_low_power_alarm` | int | 0x7f140234 | 23510 |
| `event_normal` | int | 0x7f140235 | 23513 |
| `event_record_error` | int | 0x7f140236 | 23516 |
| `event_record_space_full` | int | 0x7f140237 | 23519 |
| `event_sdcard_error` | int | 0x7f140238 | 23522 |
| `event_sdcard_mounted` | int | 0x7f140239 | 23525 |
| `event_sdcard_not_exist` | int | 0x7f14023a | 23528 |
| `event_sdcard_remove` | int | 0x7f14023b | 23531 |
| `event_shutdown` | int | 0x7f14023c | 23534 |
| `event_snapshot_error` | int | 0x7f14023d | 23537 |
| `event_snapshot_space_full` | int | 0x7f14023e | 23540 |
| `event_usb_connected` | int | 0x7f14023f | 23543 |
| `event_usb_disconnected` | int | 0x7f140240 | 23546 |
| `exception_content` | int | 0x7f140241 | 23549 |
| `exchange` | int | 0x7f140242 | 23552 |
| `exchange_code_no_empty` | int | 0x7f140243 | 23555 |
| `exchange_fail` | int | 0x7f140244 | 23558 |
| `exchange_success` | int | 0x7f140245 | 23561 |
| `exit_fastSetting` | int | 0x7f140246 | 23564 |
| `exo_controls_cc_disabled_description` | int | 0x7f140247 | 23567 |
| `exo_controls_cc_enabled_description` | int | 0x7f140248 | 23570 |
| `exo_controls_custom_playback_speed` | int | 0x7f140249 | 23573 |
| `exo_controls_fastforward_description` | int | 0x7f14024a | 23576 |
| `exo_controls_fullscreen_enter_description` | int | 0x7f14024b | 23579 |
| `exo_controls_fullscreen_exit_description` | int | 0x7f14024c | 23582 |
| `exo_controls_hide` | int | 0x7f14024d | 23585 |
| `exo_controls_next_description` | int | 0x7f14024e | 23588 |
| `exo_controls_overflow_hide_description` | int | 0x7f14024f | 23591 |
| `exo_controls_overflow_show_description` | int | 0x7f140250 | 23594 |
| `exo_controls_pause_description` | int | 0x7f140251 | 23597 |
| `exo_controls_play_description` | int | 0x7f140252 | 23600 |
| `exo_controls_playback_speed` | int | 0x7f140253 | 23603 |
| `exo_controls_previous_description` | int | 0x7f140254 | 23606 |
| `exo_controls_repeat_all_description` | int | 0x7f140255 | 23609 |
| `exo_controls_repeat_off_description` | int | 0x7f140256 | 23612 |
| `exo_controls_repeat_one_description` | int | 0x7f140257 | 23615 |
| `exo_controls_rewind_description` | int | 0x7f140258 | 23618 |
| `exo_controls_seek_bar_description` | int | 0x7f140259 | 23621 |
| `exo_controls_settings_description` | int | 0x7f14025a | 23624 |
| `exo_controls_show` | int | 0x7f14025b | 23627 |
| `exo_controls_shuffle_off_description` | int | 0x7f14025c | 23630 |
| `exo_controls_shuffle_on_description` | int | 0x7f14025d | 23633 |
| `exo_controls_stop_description` | int | 0x7f14025e | 23636 |
| `exo_controls_time_placeholder` | int | 0x7f14025f | 23639 |
| `exo_controls_vr_description` | int | 0x7f140260 | 23642 |
| `exo_download_completed` | int | 0x7f140261 | 23645 |
| `exo_download_description` | int | 0x7f140262 | 23648 |
| `exo_download_downloading` | int | 0x7f140263 | 23651 |
| `exo_download_failed` | int | 0x7f140264 | 23654 |
| `exo_download_notification_channel_name` | int | 0x7f140265 | 23657 |
| `exo_download_paused` | int | 0x7f140266 | 23660 |
| `exo_download_paused_for_network` | int | 0x7f140267 | 23663 |
| `exo_download_paused_for_wifi` | int | 0x7f140268 | 23666 |
| `exo_download_removing` | int | 0x7f140269 | 23669 |
| `exo_item_list` | int | 0x7f14026a | 23672 |
| `exo_track_bitrate` | int | 0x7f14026b | 23675 |
| `exo_track_mono` | int | 0x7f14026c | 23678 |
| `exo_track_resolution` | int | 0x7f14026d | 23681 |
| `exo_track_role_alternate` | int | 0x7f14026e | 23684 |
| `exo_track_role_closed_captions` | int | 0x7f14026f | 23687 |
| `exo_track_role_commentary` | int | 0x7f140270 | 23690 |
| `exo_track_role_supplementary` | int | 0x7f140271 | 23693 |
| `exo_track_selection_auto` | int | 0x7f140272 | 23696 |
| `exo_track_selection_none` | int | 0x7f140273 | 23699 |
| `exo_track_selection_title_audio` | int | 0x7f140274 | 23702 |
| `exo_track_selection_title_text` | int | 0x7f140275 | 23705 |
| `exo_track_selection_title_video` | int | 0x7f140276 | 23708 |
| `exo_track_stereo` | int | 0x7f140277 | 23711 |
| `exo_track_surround` | int | 0x7f140278 | 23714 |
| `exo_track_surround_5_point_1` | int | 0x7f140279 | 23717 |
| `exo_track_surround_7_point_1` | int | 0x7f14027a | 23720 |
| `exo_track_unknown` | int | 0x7f14027b | 23723 |
| `exposed_dropdown_menu_content_description` | int | 0x7f14027c | 23726 |
| `fab_transformation_scrim_behavior` | int | 0x7f14027d | 23729 |
| `fab_transformation_sheet_behavior` | int | 0x7f14027e | 23732 |
| `face_book` | int | 0x7f14027f | 23735 |
| `fail` | int | 0x7f140280 | 23738 |
| `failed` | int | 0x7f140281 | 23741 |
| `fbp` | int | 0x7f140282 | 23744 |
| `fbp_b` | int | 0x7f140283 | 23747 |
| `fbp_dp` | int | 0x7f140284 | 23750 |
| `fbp_f` | int | 0x7f140285 | 23753 |
| `fbp_pb` | int | 0x7f140286 | 23756 |
| `fbp_tp` | int | 0x7f140287 | 23759 |
| `fbp_tundef1` | int | 0x7f140288 | 23762 |
| `fbp_tundef2` | int | 0x7f140289 | 23765 |
| `fbp_undef` | int | 0x7f14028a | 23768 |
| `feedback_fail` | int | 0x7f14028d | 23777 |
| `feedback_problem_eight` | int | 0x7f14028e | 23780 |
| `feedback_problem_five` | int | 0x7f14028f | 23783 |
| `feedback_problem_four` | int | 0x7f140290 | 23786 |
| `feedback_problem_nine` | int | 0x7f140291 | 23789 |
| `feedback_problem_no_selected_hint` | int | 0x7f140292 | 23792 |
| `feedback_problem_one` | int | 0x7f140293 | 23795 |
| `feedback_problem_seven` | int | 0x7f140294 | 23798 |
| `feedback_problem_six` | int | 0x7f140295 | 23801 |
| `feedback_problem_ten` | int | 0x7f140296 | 23804 |
| `feedback_problem_three` | int | 0x7f140297 | 23807 |
| `feedback_problem_two` | int | 0x7f140298 | 23810 |
| `feedback_success` | int | 0x7f140299 | 23813 |
| `feedbackByEmail` | int | 0x7f14028b | 23771 |
| `feedbackByPhone` | int | 0x7f14028c | 23774 |
| `file_browser` | int | 0x7f14029a | 23816 |
| `file_length_` | int | 0x7f14029b | 23819 |
| `file_photo_single` | int | 0x7f14029c | 23822 |
| `filename` | int | 0x7f14029d | 23825 |
| `filesize` | int | 0x7f14029e | 23828 |
| `filesize_bytes` | int | 0x7f14029f | 23831 |
| `fillContent` | int | 0x7f1402a0 | 23834 |
| `fillQuestion` | int | 0x7f1402a1 | 23837 |
| `finish` | int | 0x7f1402a2 | 23840 |
| `fire_off` | int | 0x7f1402a3 | 23843 |
| `fire_on` | int | 0x7f1402a4 | 23846 |
| `firm_sending` | int | 0x7f1402a5 | 23849 |
| `firm_sent` | int | 0x7f1402a6 | 23852 |
| `firmware_version` | int | 0x7f1402a7 | 23855 |
| `fix_known_issues` | int | 0x7f1402a8 | 23858 |
| `follow_system` | int | 0x7f1402aa | 23864 |
| `followUs` | int | 0x7f1402a9 | 23861 |
| `forbid_ask` | int | 0x7f1402ab | 23867 |
| `forget_pwd` | int | 0x7f1402ac | 23870 |
| `format_burst_rate` | int | 0x7f1402ad | 23873 |
| `format_recordtimelapse` | int | 0x7f1402ae | 23876 |
| `format_sd_card` | int | 0x7f1402af | 23879 |
| `format_sd_failure` | int | 0x7f1402b0 | 23882 |
| `format_sd_success` | int | 0x7f1402b1 | 23885 |
| `format_timelpase` | int | 0x7f1402b2 | 23888 |
| `format_timer` | int | 0x7f1402b3 | 23891 |
| `format_tip` | int | 0x7f1402b4 | 23894 |
| `fpl` | int | 0x7f1402b5 | 23897 |
| `fps` | int | 0x7f1402b6 | 23900 |
| `french` | int | 0x7f1402b7 | 23903 |
| `French` | int | 0x7f140006 | 21839 |
| `frequency_50HZ` | int | 0x7f1402b8 | 23906 |
| `frequency_60HZ` | int | 0x7f1402b9 | 23909 |
| `fri` | int | 0x7f1402ba | 23912 |
| `g_sensor` | int | 0x7f1402bb | 23915 |
| `g_sensor_high` | int | 0x7f1402bc | 23918 |
| `g_sensor_low` | int | 0x7f1402bd | 23921 |
| `g_sensor_medium` | int | 0x7f1402be | 23924 |
| `gallery_cancel` | int | 0x7f1402bf | 23927 |
| `gallery_delete_des` | int | 0x7f1402c0 | 23930 |
| `gallery_download` | int | 0x7f1402c1 | 23933 |
| `gallery_download_with_vid_msg` | int | 0x7f1402c2 | 23936 |
| `gallery_no_file_selected` | int | 0x7f1402c3 | 23939 |
| `german` | int | 0x7f1402c4 | 23942 |
| `German` | int | 0x7f140007 | 21842 |
| `get_code_fail` | int | 0x7f1402c5 | 23945 |
| `get_server_info_fail_check_network` | int | 0x7f1402c6 | 23948 |
| `getver_failure` | int | 0x7f1402c7 | 23951 |
| `gku_4g_card_state_activated` | int | 0x7f1402c8 | 23954 |
| `gku_4g_card_state_activated_base` | int | 0x7f1402c9 | 23957 |
| `gku_4g_card_state_can_active` | int | 0x7f1402ca | 23960 |
| `gku_4g_card_state_deactivated` | int | 0x7f1402cb | 23963 |
| `gku_4g_card_state_retired` | int | 0x7f1402cc | 23966 |
| `gku_4g_card_state_title` | int | 0x7f1402cd | 23969 |
| `gku_4g_card_state_wait_active` | int | 0x7f1402ce | 23972 |
| `gku_4g_charge_service_title` | int | 0x7f1402cf | 23975 |
| `gku_4g_charge_tip` | int | 0x7f1402d0 | 23978 |
| `gku_4g_charge_title` | int | 0x7f1402d1 | 23981 |
| `gku_4g_click_copy` | int | 0x7f1402d2 | 23984 |
| `gku_4g_device_iccid` | int | 0x7f1402d3 | 23987 |
| `gku_4g_expire_time` | int | 0x7f1402d4 | 23990 |
| `gku_4g_service_detail` | int | 0x7f1402d5 | 23993 |
| `gku_4g_service_title` | int | 0x7f1402d6 | 23996 |
| `gku_4g_total_flow` | int | 0x7f1402d7 | 23999 |
| `gku_4g_used_flow` | int | 0x7f1402d8 | 24002 |
| `gku_accept` | int | 0x7f1402d9 | 24005 |
| `gku_account_did_exist` | int | 0x7f1402da | 24008 |
| `gku_account_placehold` | int | 0x7f1402db | 24011 |
| `gku_add_device` | int | 0x7f1402dc | 24014 |
| `gku_add_tip` | int | 0x7f1402dd | 24017 |
| `gku_album` | int | 0x7f1402de | 24020 |
| `gku_album_all_files` | int | 0x7f1402df | 24023 |
| `gku_album_delete_confirm` | int | 0x7f1402e0 | 24026 |
| `gku_album_delete_single_confirm` | int | 0x7f1402e1 | 24029 |
| `gku_album_delete_succeed` | int | 0x7f1402e2 | 24032 |
| `gku_album_photo` | int | 0x7f1402e3 | 24035 |
| `gku_album_tip` | int | 0x7f1402e4 | 24038 |
| `gku_album_title` | int | 0x7f1402e5 | 24041 |
| `gku_album_video` | int | 0x7f1402e6 | 24044 |
| `gku_all` | int | 0x7f1402e7 | 24047 |
| `gku_app_cache` | int | 0x7f1402e8 | 24050 |
| `gku_app_cache_analysis` | int | 0x7f1402e9 | 24053 |
| `gku_app_cache_cleared` | int | 0x7f1402ea | 24056 |
| `gku_app_cache_confirm` | int | 0x7f1402eb | 24059 |
| `gku_app_cache_failed` | int | 0x7f1402ec | 24062 |
| `gku_app_log` | int | 0x7f1402ed | 24065 |
| `gku_app_log_tip` | int | 0x7f1402ee | 24068 |
| `gku_app_name` | int | 0x7f1402ef | 24071 |
| `gku_app_version` | int | 0x7f1402f0 | 24074 |
| `gku_app_version_check` | int | 0x7f1402f1 | 24077 |
| `gku_app_version_has_new` | int | 0x7f1402f2 | 24080 |
| `gku_app_version_no_new` | int | 0x7f1402f3 | 24083 |
| `gku_back_main` | int | 0x7f1402f4 | 24086 |
| `gku_battery` | int | 0x7f1402f5 | 24089 |
| `gku_battery_charging` | int | 0x7f1402f6 | 24092 |
| `gku_cancel` | int | 0x7f1402f7 | 24095 |
| `gku_cancel_download` | int | 0x7f1402f8 | 24098 |
| `gku_cancel_share` | int | 0x7f1402f9 | 24101 |
| `gku_cancel_share_confirm` | int | 0x7f1402fa | 24104 |
| `gku_capture_failed` | int | 0x7f1402fb | 24107 |
| `gku_capture_ok` | int | 0x7f1402fc | 24110 |
| `gku_capture_permission_denied_hint` | int | 0x7f1402fd | 24113 |
| `gku_chinese_space_1` | int | 0x7f1402fe | 24116 |
| `gku_chinese_space_2` | int | 0x7f1402ff | 24119 |
| `gku_cloud` | int | 0x7f140300 | 24122 |
| `gku_cloud_30_day_event_detail` | int | 0x7f140301 | 24125 |
| `gku_cloud_30_day_event_title` | int | 0x7f140302 | 24128 |
| `gku_cloud_30_day_event_with_4g_detail` | int | 0x7f140303 | 24131 |
| `gku_cloud_30_day_event_with_4g_title` | int | 0x7f140304 | 24134 |
| `gku_cloud_7_day_event_detail` | int | 0x7f140305 | 24137 |
| `gku_cloud_7_day_event_title` | int | 0x7f140306 | 24140 |
| `gku_cloud_abnormal_order_finished` | int | 0x7f140307 | 24143 |
| `gku_cloud_apple_not_support` | int | 0x7f140308 | 24146 |
| `gku_cloud_buy_failed` | int | 0x7f140309 | 24149 |
| `gku_cloud_buy_succeed` | int | 0x7f14030a | 24152 |
| `gku_cloud_cancel_download_confirm` | int | 0x7f14030b | 24155 |
| `gku_cloud_cancel_download_ok` | int | 0x7f14030c | 24158 |
| `gku_cloud_confirm_buy` | int | 0x7f14030d | 24161 |
| `gku_cloud_continue` | int | 0x7f14030e | 24164 |
| `gku_cloud_did_cancel_order` | int | 0x7f14030f | 24167 |
| `gku_cloud_did_download` | int | 0x7f140310 | 24170 |
| `gku_cloud_download_detail` | int | 0x7f140311 | 24173 |
| `gku_cloud_download_ok` | int | 0x7f140312 | 24176 |
| `gku_cloud_download_title` | int | 0x7f140313 | 24179 |
| `gku_cloud_free_active` | int | 0x7f140314 | 24182 |
| `gku_cloud_free_active_confirm` | int | 0x7f140315 | 24185 |
| `gku_cloud_free_active_succeed` | int | 0x7f140316 | 24188 |
| `gku_cloud_free_detail` | int | 0x7f140317 | 24191 |
| `gku_cloud_free_title` | int | 0x7f140318 | 24194 |
| `gku_cloud_guide_help` | int | 0x7f140319 | 24197 |
| `gku_cloud_guide_tip` | int | 0x7f14031a | 24200 |
| `gku_cloud_guide_tip_1` | int | 0x7f14031b | 24203 |
| `gku_cloud_guide_tip_2` | int | 0x7f14031c | 24206 |
| `gku_cloud_guide_tip_3` | int | 0x7f14031d | 24209 |
| `gku_cloud_invalid` | int | 0x7f14031e | 24212 |
| `gku_cloud_no_buy` | int | 0x7f14031f | 24215 |
| `gku_cloud_no_subscrib` | int | 0x7f140320 | 24218 |
| `gku_cloud_not_finished_order` | int | 0x7f140321 | 24221 |
| `gku_cloud_order_abnormal` | int | 0x7f140322 | 24224 |
| `gku_cloud_order_id` | int | 0x7f140323 | 24227 |
| `gku_cloud_order_state` | int | 0x7f140324 | 24230 |
| `gku_cloud_order_state_effect` | int | 0x7f140325 | 24233 |
| `gku_cloud_order_state_expired` | int | 0x7f140326 | 24236 |
| `gku_cloud_order_state_wait` | int | 0x7f140327 | 24239 |
| `gku_cloud_order_title` | int | 0x7f140328 | 24242 |
| `gku_cloud_pay_price` | int | 0x7f140329 | 24245 |
| `gku_cloud_pay_service_type` | int | 0x7f14032a | 24248 |
| `gku_cloud_pay_time` | int | 0x7f14032b | 24251 |
| `gku_cloud_review` | int | 0x7f14032c | 24254 |
| `gku_cloud_service_title` | int | 0x7f14032d | 24257 |
| `gku_cloud_shop_tip` | int | 0x7f14032e | 24260 |
| `gku_cloud_show_order` | int | 0x7f14032f | 24263 |
| `gku_cloud_subscrib` | int | 0x7f140330 | 24266 |
| `gku_cloud_tip` | int | 0x7f140331 | 24269 |
| `gku_cloud_title` | int | 0x7f140332 | 24272 |
| `gku_cloud_valid_day` | int | 0x7f140333 | 24275 |
| `gku_config_path_loading` | int | 0x7f140334 | 24278 |
| `gku_config_path_not_exist` | int | 0x7f140335 | 24281 |
| `gku_confirm` | int | 0x7f140336 | 24284 |
| `gku_connect_dev_manule_scan` | int | 0x7f140337 | 24287 |
| `gku_connect_dev_manule_scan_key` | int | 0x7f140338 | 24290 |
| `gku_connect_dev_reset_tip` | int | 0x7f140339 | 24293 |
| `gku_connect_dev_scan_manule` | int | 0x7f14033a | 24296 |
| `gku_connect_dev_scan_manule_key` | int | 0x7f14033b | 24299 |
| `gku_connect_dev_scan_share_tip` | int | 0x7f14033d | 24302 |
| `gku_connect_dev_scan_tip` | int | 0x7f14033e | 24305 |
| `gku_connect_dev_start` | int | 0x7f14033f | 24308 |
| `gku_connect_dev_title` | int | 0x7f140340 | 24311 |
| `gku_connect_doing` | int | 0x7f140341 | 24314 |
| `gku_connect_exit_confirm` | int | 0x7f140342 | 24317 |
| `gku_connect_ok` | int | 0x7f140343 | 24320 |
| `gku_connect_unkown_error` | int | 0x7f140344 | 24323 |
| `gku_connecting` | int | 0x7f140345 | 24326 |
| `gku_contact_us` | int | 0x7f140346 | 24329 |
| `gku_continue` | int | 0x7f140347 | 24332 |
| `gku_crash_tip` | int | 0x7f140348 | 24335 |
| `gku_day` | int | 0x7f140349 | 24338 |
| `gku_delete` | int | 0x7f14034a | 24341 |
| `gku_delete_account` | int | 0x7f14034b | 24344 |
| `gku_delete_account_id` | int | 0x7f14034c | 24347 |
| `gku_delete_account_succeed` | int | 0x7f14034d | 24350 |
| `gku_delete_account_warning` | int | 0x7f14034e | 24353 |
| `gku_device_added_by_other` | int | 0x7f14034f | 24356 |
| `gku_device_exist` | int | 0x7f140350 | 24359 |
| `gku_device_id` | int | 0x7f140351 | 24362 |
| `gku_device_id_empty` | int | 0x7f140352 | 24365 |
| `gku_device_location` | int | 0x7f140353 | 24368 |
| `gku_device_location_descript` | int | 0x7f140354 | 24371 |
| `gku_device_location_descript_empty` | int | 0x7f140355 | 24374 |
| `gku_device_more` | int | 0x7f140356 | 24377 |
| `gku_device_name` | int | 0x7f140357 | 24380 |
| `gku_device_offline` | int | 0x7f140358 | 24383 |
| `gku_device_pwd` | int | 0x7f140359 | 24386 |
| `gku_device_sleeped` | int | 0x7f14035a | 24389 |
| `gku_device_title` | int | 0x7f14035b | 24392 |
| `gku_done` | int | 0x7f14035c | 24395 |
| `gku_download` | int | 0x7f14035d | 24398 |
| `gku_download_did_download` | int | 0x7f14035e | 24401 |
| `gku_download_doing` | int | 0x7f14035f | 24404 |
| `gku_download_failed` | int | 0x7f140360 | 24407 |
| `gku_download_no_more_date` | int | 0x7f140361 | 24410 |
| `gku_download_state_failed` | int | 0x7f140362 | 24413 |
| `gku_download_succeed` | int | 0x7f140363 | 24416 |
| `gku_downloaded` | int | 0x7f140364 | 24419 |
| `gku_edit` | int | 0x7f140365 | 24422 |
| `gku_enter_live` | int | 0x7f140366 | 24425 |
| `gku_eventtype_normal` | int | 0x7f140367 | 24428 |
| `gku_eventtype_pir` | int | 0x7f140368 | 24431 |
| `gku_exit_confirm` | int | 0x7f140369 | 24434 |
| `gku_feedback_commit` | int | 0x7f14036a | 24437 |
| `gku_feedback_empty` | int | 0x7f14036b | 24440 |
| `gku_feedback_info` | int | 0x7f14036c | 24443 |
| `gku_feedback_info_placehold` | int | 0x7f14036d | 24446 |
| `gku_feedback_ok` | int | 0x7f14036e | 24449 |
| `gku_file_all_event` | int | 0x7f14036f | 24452 |
| `gku_file_edit` | int | 0x7f140370 | 24455 |
| `gku_file_edit_empty` | int | 0x7f140371 | 24458 |
| `gku_filetype_photo` | int | 0x7f140372 | 24461 |
| `gku_filetype_video` | int | 0x7f140373 | 24464 |
| `gku_firmware_update_check_failed` | int | 0x7f140374 | 24467 |
| `gku_firmware_update_checking` | int | 0x7f140375 | 24470 |
| `gku_firmware_update_compare_ok` | int | 0x7f140376 | 24473 |
| `gku_firmware_update_compare_tip` | int | 0x7f140377 | 24476 |
| `gku_firmware_update_compare_title` | int | 0x7f140378 | 24479 |
| `gku_firmware_update_confirm` | int | 0x7f140379 | 24482 |
| `gku_firmware_update_cur_ver` | int | 0x7f14037a | 24485 |
| `gku_firmware_update_doing` | int | 0x7f14037b | 24488 |
| `gku_firmware_update_doing_tip` | int | 0x7f14037c | 24491 |
| `gku_firmware_update_downloading` | int | 0x7f14037d | 24494 |
| `gku_firmware_update_failed` | int | 0x7f14037e | 24497 |
| `gku_firmware_update_failed_battery` | int | 0x7f14037f | 24500 |
| `gku_firmware_update_failed_download` | int | 0x7f140380 | 24503 |
| `gku_firmware_update_failed_general` | int | 0x7f140381 | 24506 |
| `gku_firmware_update_failed_nocard` | int | 0x7f140382 | 24509 |
| `gku_firmware_update_failed_offline` | int | 0x7f140383 | 24512 |
| `gku_firmware_update_failed_timeout` | int | 0x7f140384 | 24515 |
| `gku_firmware_update_failed_verify` | int | 0x7f140385 | 24518 |
| `gku_firmware_update_failed_waitonline` | int | 0x7f140386 | 24521 |
| `gku_firmware_update_new_ver` | int | 0x7f140387 | 24524 |
| `gku_firmware_update_no_new` | int | 0x7f140388 | 24527 |
| `gku_firmware_update_prepare` | int | 0x7f140389 | 24530 |
| `gku_firmware_update_start` | int | 0x7f14038a | 24533 |
| `gku_firmware_update_succeed` | int | 0x7f14038b | 24536 |
| `gku_firmware_update_succeed_title` | int | 0x7f14038c | 24539 |
| `gku_firmware_update_title` | int | 0x7f14038d | 24542 |
| `gku_firmware_update_try_again` | int | 0x7f14038e | 24545 |
| `gku_firmware_update_wait` | int | 0x7f14038f | 24548 |
| `gku_forgot_pwd` | int | 0x7f140390 | 24551 |
| `gku_get_code` | int | 0x7f140391 | 24554 |
| `gku_get_code_again` | int | 0x7f140392 | 24557 |
| `gku_get_code_placehold` | int | 0x7f140393 | 24560 |
| `gku_get_identify_ok` | int | 0x7f140394 | 24563 |
| `gku_goto_open` | int | 0x7f140395 | 24566 |
| `gku_goto_setting` | int | 0x7f140396 | 24569 |
| `gku_hour_simple` | int | 0x7f140397 | 24572 |
| `gku_iccid_empty` | int | 0x7f140398 | 24575 |
| `gku_identify_code_error` | int | 0x7f140399 | 24578 |
| `gku_identify_code_timeout` | int | 0x7f14039a | 24581 |
| `gku_ignore` | int | 0x7f14039b | 24584 |
| `gku_image_not_support_snap` | int | 0x7f14039c | 24587 |
| `gku_input_placehold` | int | 0x7f14039d | 24590 |
| `gku_invalid_devid` | int | 0x7f14039e | 24593 |
| `gku_invalid_email` | int | 0x7f14039f | 24596 |
| `gku_invalid_pwd` | int | 0x7f1403a0 | 24599 |
| `gku_item_comm_24hour` | int | 0x7f1403a1 | 24602 |
| `gku_item_comm_led` | int | 0x7f1403a2 | 24605 |
| `gku_item_comm_reconnet` | int | 0x7f1403a3 | 24608 |
| `gku_item_comm_speaker` | int | 0x7f1403a4 | 24611 |
| `gku_item_comm_summer` | int | 0x7f1403a5 | 24614 |
| `gku_item_comm_tipstone` | int | 0x7f1403a6 | 24617 |
| `gku_item_comm_workmode` | int | 0x7f1403a7 | 24620 |
| `gku_item_image_filp` | int | 0x7f1403a8 | 24623 |
| `gku_item_image_mode` | int | 0x7f1403a9 | 24626 |
| `gku_item_motion_detection` | int | 0x7f1403aa | 24629 |
| `gku_item_osd` | int | 0x7f1403ab | 24632 |
| `gku_item_pdt_4gver` | int | 0x7f1403ac | 24635 |
| `gku_item_pdt_company` | int | 0x7f1403ad | 24638 |
| `gku_item_pdt_iccid` | int | 0x7f1403ae | 24641 |
| `gku_item_pdt_iccid_copyed` | int | 0x7f1403af | 24644 |
| `gku_item_pdt_imei` | int | 0x7f1403b0 | 24647 |
| `gku_item_pdt_swver` | int | 0x7f1403b1 | 24650 |
| `gku_item_pdt_type` | int | 0x7f1403b2 | 24653 |
| `gku_item_photo_number` | int | 0x7f1403b3 | 24656 |
| `gku_item_pir_envmode` | int | 0x7f1403b4 | 24659 |
| `gku_item_pir_interval` | int | 0x7f1403b5 | 24662 |
| `gku_item_pir_range` | int | 0x7f1403b6 | 24665 |
| `gku_item_pir_sens` | int | 0x7f1403b7 | 24668 |
| `gku_item_power_freq` | int | 0x7f1403b8 | 24671 |
| `gku_item_rec_sound` | int | 0x7f1403b9 | 24674 |
| `gku_item_rec_time` | int | 0x7f1403ba | 24677 |
| `gku_item_storage` | int | 0x7f1403bb | 24680 |
| `gku_item_sync_time` | int | 0x7f1403bc | 24683 |
| `gku_item_tempture_unit` | int | 0x7f1403bd | 24686 |
| `gku_language_chinese` | int | 0x7f1403be | 24689 |
| `gku_language_english` | int | 0x7f1403bf | 24692 |
| `gku_live_exit` | int | 0x7f1403c0 | 24695 |
| `gku_loading` | int | 0x7f1403c1 | 24698 |
| `gku_location_permission_denied_hint` | int | 0x7f1403c2 | 24701 |
| `gku_login_invalid_pwd` | int | 0x7f1403c3 | 24704 |
| `gku_login_pwd_error` | int | 0x7f1403c4 | 24707 |
| `gku_login_regist_succeed` | int | 0x7f1403c5 | 24710 |
| `gku_login_succeed` | int | 0x7f1403c6 | 24713 |
| `gku_login_title` | int | 0x7f1403c7 | 24716 |
| `gku_logout` | int | 0x7f1403c8 | 24719 |
| `gku_logout_confirm` | int | 0x7f1403c9 | 24722 |
| `gku_main_cloud` | int | 0x7f1403ca | 24725 |
| `gku_main_h_flip` | int | 0x7f1403cb | 24728 |
| `gku_main_location` | int | 0x7f1403cc | 24731 |
| `gku_main_location_describ` | int | 0x7f1403cd | 24734 |
| `gku_main_ptz` | int | 0x7f1403ce | 24737 |
| `gku_main_rec` | int | 0x7f1403cf | 24740 |
| `gku_main_sd` | int | 0x7f1403d0 | 24743 |
| `gku_main_v_flip` | int | 0x7f1403d1 | 24746 |
| `gku_mine_about` | int | 0x7f1403d2 | 24749 |
| `gku_mine_app_setting` | int | 0x7f1403d3 | 24752 |
| `gku_mine_feedback` | int | 0x7f1403d4 | 24755 |
| `gku_mine_net_check` | int | 0x7f1403d5 | 24758 |
| `gku_mine_online_feedback` | int | 0x7f1403d6 | 24761 |
| `gku_mine_service` | int | 0x7f1403d7 | 24764 |
| `gku_mine_share` | int | 0x7f1403d8 | 24767 |
| `gku_mine_title` | int | 0x7f1403d9 | 24770 |
| `gku_minute_simple` | int | 0x7f1403da | 24773 |
| `gku_month_1` | int | 0x7f1403db | 24776 |
| `gku_month_10` | int | 0x7f1403dc | 24779 |
| `gku_month_11` | int | 0x7f1403dd | 24782 |
| `gku_month_12` | int | 0x7f1403de | 24785 |
| `gku_month_2` | int | 0x7f1403df | 24788 |
| `gku_month_3` | int | 0x7f1403e0 | 24791 |
| `gku_month_4` | int | 0x7f1403e1 | 24794 |
| `gku_month_5` | int | 0x7f1403e2 | 24797 |
| `gku_month_6` | int | 0x7f1403e3 | 24800 |
| `gku_month_7` | int | 0x7f1403e4 | 24803 |
| `gku_month_8` | int | 0x7f1403e5 | 24806 |
| `gku_month_9` | int | 0x7f1403e6 | 24809 |
| `gku_msg_all_event` | int | 0x7f1403e7 | 24812 |
| `gku_msg_bad_gps` | int | 0x7f1403e8 | 24815 |
| `gku_msg_bad_signal` | int | 0x7f1403e9 | 24818 |
| `gku_msg_card_full` | int | 0x7f1403ea | 24821 |
| `gku_msg_charge_end` | int | 0x7f1403eb | 24824 |
| `gku_msg_electronic_fence_entry` | int | 0x7f1403ec | 24827 |
| `gku_msg_little_capacity` | int | 0x7f1403ed | 24830 |
| `gku_msg_loss_gps` | int | 0x7f1403ee | 24833 |
| `gku_msg_low_battery` | int | 0x7f1403ef | 24836 |
| `gku_msg_need_format` | int | 0x7f1403f0 | 24839 |
| `gku_msg_nocard` | int | 0x7f1403f1 | 24842 |
| `gku_msg_pir_wakeup` | int | 0x7f1403f2 | 24845 |
| `gku_msg_power_on` | int | 0x7f1403f3 | 24848 |
| `gku_msg_title` | int | 0x7f1403f4 | 24851 |
| `gku_msg_wakeup` | int | 0x7f1403f5 | 24854 |
| `gku_need_add_device` | int | 0x7f1403f6 | 24857 |
| `gku_need_camera_permission` | int | 0x7f1403f7 | 24860 |
| `gku_need_location_permission` | int | 0x7f1403f8 | 24863 |
| `gku_need_login` | int | 0x7f1403f9 | 24866 |
| `gku_need_read_storage_permission` | int | 0x7f1403fa | 24869 |
| `gku_need_record_audio_permission` | int | 0x7f1403fb | 24872 |
| `gku_net_error` | int | 0x7f1403fc | 24875 |
| `gku_new_firmware_tip` | int | 0x7f1403fd | 24878 |
| `gku_new_msg_tip` | int | 0x7f1403fe | 24881 |
| `gku_new_update_now` | int | 0x7f1403ff | 24884 |
| `gku_next` | int | 0x7f140400 | 24887 |
| `gku_nickname_too_long` | int | 0x7f140401 | 24890 |
| `gku_no_auth` | int | 0x7f140402 | 24893 |
| `gku_no_device` | int | 0x7f140403 | 24896 |
| `gku_no_location_permission` | int | 0x7f140404 | 24899 |
| `gku_no_message` | int | 0x7f140405 | 24902 |
| `gku_no_network` | int | 0x7f140406 | 24905 |
| `gku_no_order` | int | 0x7f140407 | 24908 |
| `gku_no_share_event` | int | 0x7f140408 | 24911 |
| `gku_none` | int | 0x7f140409 | 24914 |
| `gku_not_download` | int | 0x7f14040a | 24917 |
| `gku_not_online` | int | 0x7f14040b | 24920 |
| `gku_not_set` | int | 0x7f14040c | 24923 |
| `gku_notsupport` | int | 0x7f14040d | 24926 |
| `gku_offline` | int | 0x7f14040e | 24929 |
| `gku_online` | int | 0x7f14040f | 24932 |
| `gku_operation_failed` | int | 0x7f140410 | 24935 |
| `gku_operation_succeed` | int | 0x7f140411 | 24938 |
| `gku_photo_album_permission_denied_hint` | int | 0x7f140412 | 24941 |
| `gku_pir_range_selected` | int | 0x7f140413 | 24944 |
| `gku_privacy_dialog_detail` | int | 0x7f140414 | 24947 |
| `gku_privacy_dialog_title` | int | 0x7f140415 | 24950 |
| `gku_privacy_key_privacy` | int | 0x7f140416 | 24953 |
| `gku_privacy_key_service` | int | 0x7f140417 | 24956 |
| `gku_privacy_title` | int | 0x7f140418 | 24959 |
| `gku_privacy_title_viewer` | int | 0x7f140419 | 24962 |
| `gku_problem_type` | int | 0x7f14041a | 24965 |
| `gku_product_model` | int | 0x7f14041b | 24968 |
| `gku_product_type` | int | 0x7f14041c | 24971 |
| `gku_pwd_placehold` | int | 0x7f14041d | 24974 |
| `gku_quit` | int | 0x7f14041e | 24977 |
| `gku_recommend` | int | 0x7f14041f | 24980 |
| `gku_record_failed` | int | 0x7f140420 | 24983 |
| `gku_record_ok` | int | 0x7f140421 | 24986 |
| `gku_record_start` | int | 0x7f140422 | 24989 |
| `gku_recover_pwd_succeed` | int | 0x7f140423 | 24992 |
| `gku_recover_pwd_title` | int | 0x7f140424 | 24995 |
| `gku_refresh_loading` | int | 0x7f140425 | 24998 |
| `gku_refresh_pull_up` | int | 0x7f140426 | 25001 |
| `gku_refresh_pulldown_to_refresh` | int | 0x7f140427 | 25004 |
| `gku_refresh_release_to_refresh` | int | 0x7f140428 | 25007 |
| `gku_regist_part1` | int | 0x7f140429 | 25010 |
| `gku_regist_part2` | int | 0x7f14042a | 25013 |
| `gku_regist_title` | int | 0x7f14042b | 25016 |
| `gku_reject` | int | 0x7f14042c | 25019 |
| `gku_remove_device_confirm` | int | 0x7f14042d | 25022 |
| `gku_remove_device_ok` | int | 0x7f14042e | 25025 |
| `gku_request_camera_permission_failed` | int | 0x7f14042f | 25028 |
| `gku_request_location_permission_failed` | int | 0x7f140430 | 25031 |
| `gku_request_read_storage_permission_failed` | int | 0x7f140431 | 25034 |
| `gku_request_record_audio_permission_failed` | int | 0x7f140432 | 25037 |
| `gku_reset` | int | 0x7f140433 | 25040 |
| `gku_reset_confirm` | int | 0x7f140434 | 25043 |
| `gku_reset_default_doing` | int | 0x7f140435 | 25046 |
| `gku_reset_succeed` | int | 0x7f140436 | 25049 |
| `gku_save` | int | 0x7f140437 | 25052 |
| `gku_save_failed` | int | 0x7f140438 | 25055 |
| `gku_save_succeed` | int | 0x7f140439 | 25058 |
| `gku_sd_mode_event` | int | 0x7f14043a | 25061 |
| `gku_sd_mode_list` | int | 0x7f14043b | 25064 |
| `gku_sd_plaing` | int | 0x7f14043c | 25067 |
| `gku_sd_state_need_format` | int | 0x7f14043d | 25070 |
| `gku_sd_state_no_card` | int | 0x7f14043e | 25073 |
| `gku_sd_today_no_data` | int | 0x7f14043f | 25076 |
| `gku_second` | int | 0x7f140440 | 25079 |
| `gku_select_dev_type` | int | 0x7f140441 | 25082 |
| `gku_select_pay_type` | int | 0x7f140442 | 25085 |
| `gku_select_placehold` | int | 0x7f140443 | 25088 |
| `gku_setting_alarm` | int | 0x7f140444 | 25091 |
| `gku_setting_close_push_confirm` | int | 0x7f140445 | 25094 |
| `gku_setting_close_push_ok` | int | 0x7f140446 | 25097 |
| `gku_setting_devinfo` | int | 0x7f140447 | 25100 |
| `gku_setting_open_push_ok` | int | 0x7f140448 | 25103 |
| `gku_setting_picture` | int | 0x7f140449 | 25106 |
| `gku_setting_push` | int | 0x7f14044a | 25109 |
| `gku_setting_remove_device` | int | 0x7f14044b | 25112 |
| `gku_setting_share` | int | 0x7f14044c | 25115 |
| `gku_setting_title` | int | 0x7f14044d | 25118 |
| `gku_share` | int | 0x7f14044e | 25121 |
| `gku_share_accept` | int | 0x7f14044f | 25124 |
| `gku_share_accepted_ok` | int | 0x7f140450 | 25127 |
| `gku_share_account_tip` | int | 0x7f140451 | 25130 |
| `gku_share_add` | int | 0x7f140452 | 25133 |
| `gku_share_auth` | int | 0x7f140453 | 25136 |
| `gku_share_auth_audio` | int | 0x7f140454 | 25139 |
| `gku_share_auth_msg` | int | 0x7f140455 | 25142 |
| `gku_share_auth_playback` | int | 0x7f140456 | 25145 |
| `gku_share_auth_setting` | int | 0x7f140457 | 25148 |
| `gku_share_count` | int | 0x7f140458 | 25151 |
| `gku_share_device_did_remove` | int | 0x7f140459 | 25154 |
| `gku_share_did_accept` | int | 0x7f14045a | 25157 |
| `gku_share_did_reject` | int | 0x7f14045b | 25160 |
| `gku_share_edit` | int | 0x7f14045c | 25163 |
| `gku_share_event` | int | 0x7f14045d | 25166 |
| `gku_share_has_msg` | int | 0x7f14045e | 25169 |
| `gku_share_is_from` | int | 0x7f14045f | 25172 |
| `gku_share_is_mine` | int | 0x7f140460 | 25175 |
| `gku_share_is_to` | int | 0x7f140461 | 25178 |
| `gku_share_list` | int | 0x7f140462 | 25181 |
| `gku_share_master` | int | 0x7f140463 | 25184 |
| `gku_share_no_msg` | int | 0x7f140464 | 25187 |
| `gku_share_reject` | int | 0x7f140465 | 25190 |
| `gku_share_succeed` | int | 0x7f140466 | 25193 |
| `gku_share_tip` | int | 0x7f140467 | 25196 |
| `gku_share_user_detail` | int | 0x7f140468 | 25199 |
| `gku_share_user_title` | int | 0x7f140469 | 25202 |
| `gku_share_userid` | int | 0x7f14046a | 25205 |
| `gku_share_wait_accept` | int | 0x7f14046b | 25208 |
| `gku_shared_count` | int | 0x7f14046c | 25211 |
| `gku_shop_not_exist` | int | 0x7f14046d | 25214 |
| `gku_signal` | int | 0x7f14046e | 25217 |
| `gku_state_flow_expired` | int | 0x7f14046f | 25220 |
| `gku_storage_cloud_upload` | int | 0x7f140470 | 25223 |
| `gku_storage_format` | int | 0x7f140471 | 25226 |
| `gku_storage_format_confirm` | int | 0x7f140472 | 25229 |
| `gku_storage_format_doing` | int | 0x7f140473 | 25232 |
| `gku_storage_format_failed` | int | 0x7f140474 | 25235 |
| `gku_storage_format_succeed` | int | 0x7f140475 | 25238 |
| `gku_storage_format_timeout` | int | 0x7f140476 | 25241 |
| `gku_storage_status` | int | 0x7f140477 | 25244 |
| `gku_stream_hd` | int | 0x7f140478 | 25247 |
| `gku_stream_hd_changed` | int | 0x7f140479 | 25250 |
| `gku_stream_sd` | int | 0x7f14047a | 25253 |
| `gku_stream_sd_changed` | int | 0x7f14047b | 25256 |
| `gku_sync_param` | int | 0x7f14047c | 25259 |
| `gku_sync_param_ok` | int | 0x7f14047d | 25262 |
| `gku_synctime_doing` | int | 0x7f14047e | 25265 |
| `gku_synctime_succeed` | int | 0x7f14047f | 25268 |
| `gku_timezone` | int | 0x7f140480 | 25271 |
| `gku_tip` | int | 0x7f140481 | 25274 |
| `gku_try_again` | int | 0x7f140482 | 25277 |
| `gku_user_not_exist` | int | 0x7f140483 | 25280 |
| `gku_userinfo` | int | 0x7f140484 | 25283 |
| `gku_userinfo_confirm_pwd` | int | 0x7f140485 | 25286 |
| `gku_userinfo_header` | int | 0x7f140486 | 25289 |
| `gku_userinfo_header_album` | int | 0x7f140487 | 25292 |
| `gku_userinfo_header_camera` | int | 0x7f140488 | 25295 |
| `gku_userinfo_id` | int | 0x7f140489 | 25298 |
| `gku_userinfo_modify_pwd` | int | 0x7f14048a | 25301 |
| `gku_userinfo_new_pwd` | int | 0x7f14048b | 25304 |
| `gku_userinfo_new_pwd_not_match` | int | 0x7f14048c | 25307 |
| `gku_userinfo_nickname` | int | 0x7f14048d | 25310 |
| `gku_userinfo_nickname_empty` | int | 0x7f14048e | 25313 |
| `gku_userinfo_old_pwd` | int | 0x7f14048f | 25316 |
| `gku_userinfo_old_pwd_invalid` | int | 0x7f140490 | 25319 |
| `gku_userinfo_tip` | int | 0x7f140491 | 25322 |
| `gku_value_1` | int | 0x7f140492 | 25325 |
| `gku_value_10sec` | int | 0x7f140493 | 25328 |
| `gku_value_1hour` | int | 0x7f140494 | 25331 |
| `gku_value_1min` | int | 0x7f140495 | 25334 |
| `gku_value_2` | int | 0x7f140496 | 25337 |
| `gku_value_20sec` | int | 0x7f140497 | 25340 |
| `gku_value_2hour` | int | 0x7f140498 | 25343 |
| `gku_value_3` | int | 0x7f140499 | 25346 |
| `gku_value_30sec` | int | 0x7f14049a | 25349 |
| `gku_value_3hour` | int | 0x7f14049b | 25352 |
| `gku_value_3min` | int | 0x7f14049c | 25355 |
| `gku_value_4hour` | int | 0x7f14049d | 25358 |
| `gku_value_5` | int | 0x7f14049e | 25361 |
| `gku_value_50hz` | int | 0x7f14049f | 25364 |
| `gku_value_5hour` | int | 0x7f1404a0 | 25367 |
| `gku_value_5min` | int | 0x7f1404a1 | 25370 |
| `gku_value_5sec` | int | 0x7f1404a2 | 25373 |
| `gku_value_60hz` | int | 0x7f1404a3 | 25376 |
| `gku_value_celsius` | int | 0x7f1404a4 | 25379 |
| `gku_value_common` | int | 0x7f1404a5 | 25382 |
| `gku_value_fahrenheit_degree` | int | 0x7f1404a6 | 25385 |
| `gku_value_hflip` | int | 0x7f1404a7 | 25388 |
| `gku_value_high` | int | 0x7f1404a8 | 25391 |
| `gku_value_hvflip` | int | 0x7f1404a9 | 25394 |
| `gku_value_immediately` | int | 0x7f1404aa | 25397 |
| `gku_value_low` | int | 0x7f1404ab | 25400 |
| `gku_value_mid` | int | 0x7f1404ac | 25403 |
| `gku_value_night` | int | 0x7f1404ad | 25406 |
| `gku_value_normal` | int | 0x7f1404ae | 25409 |
| `gku_value_off` | int | 0x7f1404af | 25412 |
| `gku_value_on` | int | 0x7f1404b0 | 25415 |
| `gku_value_one_way` | int | 0x7f1404b1 | 25418 |
| `gku_value_photo` | int | 0x7f1404b2 | 25421 |
| `gku_value_two_way` | int | 0x7f1404b3 | 25424 |
| `gku_value_vflip` | int | 0x7f1404b4 | 25427 |
| `gku_value_video` | int | 0x7f1404b5 | 25430 |
| `gku_wait_download` | int | 0x7f1404b6 | 25433 |
| `gku_wakeup_do` | int | 0x7f1404b7 | 25436 |
| `gku_wakeup_failed` | int | 0x7f1404b8 | 25439 |
| `gku_waking` | int | 0x7f1404b9 | 25442 |
| `gku_week_1` | int | 0x7f1404ba | 25445 |
| `gku_week_2` | int | 0x7f1404bb | 25448 |
| `gku_week_3` | int | 0x7f1404bc | 25451 |
| `gku_week_4` | int | 0x7f1404bd | 25454 |
| `gku_week_5` | int | 0x7f1404be | 25457 |
| `gku_week_friday` | int | 0x7f1404bf | 25460 |
| `gku_week_monday` | int | 0x7f1404c0 | 25463 |
| `gku_week_saturday` | int | 0x7f1404c1 | 25466 |
| `gku_week_sunday` | int | 0x7f1404c2 | 25469 |
| `gku_week_thursday` | int | 0x7f1404c3 | 25472 |
| `gku_week_tuesday` | int | 0x7f1404c4 | 25475 |
| `gku_week_wednesday` | int | 0x7f1404c5 | 25478 |
| `go_wechat` | int | 0x7f1404c6 | 25481 |
| `guanbo` | int | 0x7f1404c7 | 25484 |
| `hardware` | int | 0x7f1404c8 | 25487 |
| `hardware_feature` | int | 0x7f1404c9 | 25490 |
| `has_new_version` | int | 0x7f1404ca | 25493 |
| `hd_fbl` | int | 0x7f1404cb | 25496 |
| `hello_blank_fragment` | int | 0x7f1404cc | 25499 |
| `help` | int | 0x7f1404cd | 25502 |
| `helper_forget_pwd_text_1` | int | 0x7f1404ce | 25505 |
| `helper_login_text_1` | int | 0x7f1404cf | 25508 |
| `helper_login_text_2` | int | 0x7f1404d0 | 25511 |
| `helper_register_text_1` | int | 0x7f1404d1 | 25514 |
| `helper_register_text_2` | int | 0x7f1404d2 | 25517 |
| `hide_bottom_view_on_scroll_behavior` | int | 0x7f1404d3 | 25520 |
| `high_1080p` | int | 0x7f1404d4 | 25523 |
| `high_720p` | int | 0x7f1404d5 | 25526 |
| `hour` | int | 0x7f1404d6 | 25529 |
| `html_address` | int | 0x7f1404d7 | 25532 |
| `i_known` | int | 0x7f1404d8 | 25535 |
| `ibmodifyTime` | int | 0x7f1404d9 | 25538 |
| `icon_content_description` | int | 0x7f1404da | 25541 |
| `image_delete_des` | int | 0x7f1404db | 25544 |
| `image_edit_effect` | int | 0x7f1404dc | 25547 |
| `image_edit_filter` | int | 0x7f1404dd | 25550 |
| `image_edit_tools` | int | 0x7f1404de | 25553 |
| `image_infor` | int | 0x7f1404df | 25556 |
| `image_lower_limit` | int | 0x7f1404e0 | 25559 |
| `image_unit` | int | 0x7f1404e1 | 25562 |
| `image_upsidedown` | int | 0x7f1404e2 | 25565 |
| `image_url` | int | 0x7f1404e3 | 25568 |
| `img_setting` | int | 0x7f1404e4 | 25571 |
| `immediateInstall` | int | 0x7f1404e5 | 25574 |
| `immediateUpgrade` | int | 0x7f1404e6 | 25577 |
| `improve_suggest` | int | 0x7f1404e7 | 25580 |
| `init_fail` | int | 0x7f1404e8 | 25583 |
| `initial_password` | int | 0x7f1404e9 | 25586 |
| `input_new_pwd` | int | 0x7f1404ea | 25589 |
| `input_old_pwd` | int | 0x7f1404eb | 25592 |
| `input_passwd_tip` | int | 0x7f1404ec | 25595 |
| `input_pwd` | int | 0x7f1404ed | 25598 |
| `input_pwd_again` | int | 0x7f1404ee | 25601 |
| `install_what_app` | int | 0x7f1404f0 | 25607 |
| `installAndSetUp` | int | 0x7f1404ef | 25604 |
| `intercom` | int | 0x7f1404f1 | 25610 |
| `interval` | int | 0x7f1404f2 | 25613 |
| `issueSelect` | int | 0x7f1404f3 | 25616 |
| `italian` | int | 0x7f1404f4 | 25619 |
| `Italian` | int | 0x7f140008 | 21845 |
| `item_view_role_description` | int | 0x7f1404f5 | 25622 |
| `japanese` | int | 0x7f1404f6 | 25625 |
| `Japanese` | int | 0x7f140009 | 21848 |
| `jd` | int | 0x7f1404f7 | 25628 |
| `jd_self` | int | 0x7f1404f8 | 25631 |
| `jinri` | int | 0x7f1404f9 | 25634 |
| `json_parse_error` | int | 0x7f1404fa | 25637 |
| `jump_ad` | int | 0x7f1404fb | 25640 |
| `jump_over` | int | 0x7f1404fc | 25643 |
| `kaibo` | int | 0x7f1404fd | 25646 |
| `kaibo_fail` | int | 0x7f1404fe | 25649 |
| `kaibo_fail_check_connect_retry` | int | 0x7f1404ff | 25652 |
| `korean` | int | 0x7f140500 | 25655 |
| `Korean` | int | 0x7f14000a | 21851 |
| `language` | int | 0x7f140501 | 25658 |
| `latest_announcement` | int | 0x7f140502 | 25661 |
| `liji_shengji` | int | 0x7f140503 | 25664 |
| `limit_length_max` | int | 0x7f140504 | 25667 |
| `link` | int | 0x7f140505 | 25670 |
| `link_dv` | int | 0x7f140506 | 25673 |
| `linking` | int | 0x7f140507 | 25676 |
| `list_header_fresh_down` | int | 0x7f140508 | 25679 |
| `list_header_fresh_loosen` | int | 0x7f140509 | 25682 |
| `list_header_loading` | int | 0x7f14050a | 25685 |
| `list_no_more` | int | 0x7f14050b | 25688 |
| `live_device_connect` | int | 0x7f14050c | 25691 |
| `live_device_connect_hint` | int | 0x7f14050d | 25694 |
| `live_device_select_hint` | int | 0x7f14050e | 25697 |
| `live_device_select_wifi` | int | 0x7f14050f | 25700 |
| `live_device_select_wifi_down` | int | 0x7f140510 | 25703 |
| `live_device_select_wifi_no_hint` | int | 0x7f140511 | 25706 |
| `live_device_select_wifi_nopin` | int | 0x7f140512 | 25709 |
| `live_device_select_wifi_nopwd` | int | 0x7f140513 | 25712 |
| `live_device_select_wifi_nowifi` | int | 0x7f140514 | 25715 |
| `live_in_loading` | int | 0x7f140515 | 25718 |
| `live_in_loading_failed` | int | 0x7f140516 | 25721 |
| `live_params` | int | 0x7f140517 | 25724 |
| `live_privacy_agree` | int | 0x7f140518 | 25727 |
| `live_setting` | int | 0x7f140519 | 25730 |
| `load_fail` | int | 0x7f14051a | 25733 |
| `loading` | int | 0x7f14051b | 25736 |
| `location_permission_description_hyh` | int | 0x7f14051c | 25739 |
| `location_permission_hyh` | int | 0x7f14051d | 25742 |
| `loding` | int | 0x7f14051e | 25745 |
| `loding_fail_lick_try` | int | 0x7f14051f | 25748 |
| `login_fail` | int | 0x7f140520 | 25751 |
| `login_name_or_psw_error` | int | 0x7f140521 | 25754 |
| `login_now` | int | 0x7f140522 | 25757 |
| `login_success` | int | 0x7f140523 | 25760 |
| `logout_fail` | int | 0x7f140524 | 25763 |
| `loop_type` | int | 0x7f140525 | 25766 |
| `looptype_1` | int | 0x7f140526 | 25769 |
| `looptype_3` | int | 0x7f140527 | 25772 |
| `looptype_5` | int | 0x7f140528 | 25775 |
| `low_power_shutdown` | int | 0x7f140529 | 25778 |
| `m3_exceed_max_badge_text_suffix` | int | 0x7f14052a | 25781 |
| `m3_ref_typeface_brand_medium` | int | 0x7f14052b | 25784 |
| `m3_ref_typeface_brand_regular` | int | 0x7f14052c | 25787 |
| `m3_ref_typeface_plain_medium` | int | 0x7f14052d | 25790 |
| `m3_ref_typeface_plain_regular` | int | 0x7f14052e | 25793 |
| `m3_sys_motion_easing_emphasized` | int | 0x7f14052f | 25796 |
| `m3_sys_motion_easing_emphasized_accelerate` | int | 0x7f140530 | 25799 |
| `m3_sys_motion_easing_emphasized_decelerate` | int | 0x7f140531 | 25802 |
| `m3_sys_motion_easing_emphasized_path_data` | int | 0x7f140532 | 25805 |
| `m3_sys_motion_easing_legacy` | int | 0x7f140533 | 25808 |
| `m3_sys_motion_easing_legacy_accelerate` | int | 0x7f140534 | 25811 |
| `m3_sys_motion_easing_legacy_decelerate` | int | 0x7f140535 | 25814 |
| `m3_sys_motion_easing_linear` | int | 0x7f140536 | 25817 |
| `m3_sys_motion_easing_standard` | int | 0x7f140537 | 25820 |
| `m3_sys_motion_easing_standard_accelerate` | int | 0x7f140538 | 25823 |
| `m3_sys_motion_easing_standard_decelerate` | int | 0x7f140539 | 25826 |
| `machine_goes_into_sleep_mode` | int | 0x7f14053a | 25829 |
| `main_dialog_quick_video_shutdown` | int | 0x7f14053b | 25832 |
| `main_dialog_tips` | int | 0x7f14053c | 25835 |
| `mall` | int | 0x7f14053d | 25838 |
| `manual_add_device` | int | 0x7f14053e | 25841 |
| `manual_input` | int | 0x7f14053f | 25844 |
| `manually_lock_video` | int | 0x7f140540 | 25847 |
| `master_mode_multi` | int | 0x7f140541 | 25850 |
| `master_mode_photo` | int | 0x7f140542 | 25853 |
| `master_mode_video` | int | 0x7f140543 | 25856 |
| `match_code` | int | 0x7f140544 | 25859 |
| `matching_device` | int | 0x7f140545 | 25862 |
| `material_clock_display_divider` | int | 0x7f140546 | 25865 |
| `material_clock_toggle_content_description` | int | 0x7f140547 | 25868 |
| `material_hour_24h_suffix` | int | 0x7f140548 | 25871 |
| `material_hour_selection` | int | 0x7f140549 | 25874 |
| `material_hour_suffix` | int | 0x7f14054a | 25877 |
| `material_minute_selection` | int | 0x7f14054b | 25880 |
| `material_minute_suffix` | int | 0x7f14054c | 25883 |
| `material_motion_easing_accelerated` | int | 0x7f14054d | 25886 |
| `material_motion_easing_decelerated` | int | 0x7f14054e | 25889 |
| `material_motion_easing_emphasized` | int | 0x7f14054f | 25892 |
| `material_motion_easing_linear` | int | 0x7f140550 | 25895 |
| `material_motion_easing_standard` | int | 0x7f140551 | 25898 |
| `material_slider_range_end` | int | 0x7f140552 | 25901 |
| `material_slider_range_start` | int | 0x7f140553 | 25904 |
| `material_slider_value` | int | 0x7f140554 | 25907 |
| `material_timepicker_am` | int | 0x7f140555 | 25910 |
| `material_timepicker_clock_mode_description` | int | 0x7f140556 | 25913 |
| `material_timepicker_hour` | int | 0x7f140557 | 25916 |
| `material_timepicker_minute` | int | 0x7f140558 | 25919 |
| `material_timepicker_pm` | int | 0x7f140559 | 25922 |
| `material_timepicker_select_time` | int | 0x7f14055a | 25925 |
| `material_timepicker_text_input_mode_description` | int | 0x7f14055b | 25928 |
| `media_permission_description_hyh` | int | 0x7f14055c | 25931 |
| `media_permission_hyh` | int | 0x7f14055d | 25934 |
| `MediaManagePermission_content` | int | 0x7f14000b | 21854 |
| `meet_problem` | int | 0x7f14055e | 25937 |
| `meet_problem_click_here` | int | 0x7f14055f | 25940 |
| `memory_card_ready` | int | 0x7f140560 | 25943 |
| `menu_grid` | int | 0x7f140561 | 25946 |
| `menu_list` | int | 0x7f140562 | 25949 |
| `menu_lists` | int | 0x7f140563 | 25952 |
| `menu_quick_lists` | int | 0x7f140564 | 25955 |
| `message` | int | 0x7f140565 | 25958 |
| `message_download_to` | int | 0x7f140566 | 25961 |
| `microphone_connection` | int | 0x7f140567 | 25964 |
| `minute` | int | 0x7f140568 | 25967 |
| `mobile_storage_hint` | int | 0x7f140569 | 25970 |
| `mobile_storage_title` | int | 0x7f14056a | 25973 |
| `mode_multi_burst` | int | 0x7f14056b | 25976 |
| `mode_multi_continuous` | int | 0x7f14056c | 25979 |
| `mode_multi_timelapse` | int | 0x7f14056d | 25982 |
| `mode_photo_exposure` | int | 0x7f14056e | 25985 |
| `mode_photo_raw` | int | 0x7f14056f | 25988 |
| `mode_photo_single` | int | 0x7f140570 | 25991 |
| `mode_photo_timer` | int | 0x7f140571 | 25994 |
| `mode_video_loop` | int | 0x7f140572 | 25997 |
| `mode_video_normal` | int | 0x7f140573 | 26000 |
| `mode_video_slow` | int | 0x7f140574 | 26003 |
| `mode_video_timelapse` | int | 0x7f140575 | 26006 |
| `model_set` | int | 0x7f140576 | 26009 |
| `modify_fail` | int | 0x7f140577 | 26012 |
| `modify_success` | int | 0x7f140578 | 26015 |
| `modify_wifi_info` | int | 0x7f140579 | 26018 |
| `mon` | int | 0x7f14057a | 26021 |
| `month` | int | 0x7f14057b | 26024 |
| `more_func_expect` | int | 0x7f14057c | 26027 |
| `more_music` | int | 0x7f14057d | 26030 |
| `more_settings` | int | 0x7f14057e | 26033 |
| `motion_detect` | int | 0x7f140580 | 26039 |
| `motionCamera` | int | 0x7f14057f | 26036 |
| `mtrl_badge_numberless_content_description` | int | 0x7f140581 | 26042 |
| `mtrl_checkbox_button_icon_path_checked` | int | 0x7f140582 | 26045 |
| `mtrl_checkbox_button_icon_path_group_name` | int | 0x7f140583 | 26048 |
| `mtrl_checkbox_button_icon_path_indeterminate` | int | 0x7f140584 | 26051 |
| `mtrl_checkbox_button_icon_path_name` | int | 0x7f140585 | 26054 |
| `mtrl_checkbox_button_path_checked` | int | 0x7f140586 | 26057 |
| `mtrl_checkbox_button_path_group_name` | int | 0x7f140587 | 26060 |
| `mtrl_checkbox_button_path_name` | int | 0x7f140588 | 26063 |
| `mtrl_checkbox_button_path_unchecked` | int | 0x7f140589 | 26066 |
| `mtrl_checkbox_state_description_checked` | int | 0x7f14058a | 26069 |
| `mtrl_checkbox_state_description_indeterminate` | int | 0x7f14058b | 26072 |
| `mtrl_checkbox_state_description_unchecked` | int | 0x7f14058c | 26075 |
| `mtrl_chip_close_icon_content_description` | int | 0x7f14058d | 26078 |
| `mtrl_exceed_max_badge_number_content_description` | int | 0x7f14058e | 26081 |
| `mtrl_exceed_max_badge_number_suffix` | int | 0x7f14058f | 26084 |
| `mtrl_picker_a11y_next_month` | int | 0x7f140590 | 26087 |
| `mtrl_picker_a11y_prev_month` | int | 0x7f140591 | 26090 |
| `mtrl_picker_announce_current_range_selection` | int | 0x7f140592 | 26093 |
| `mtrl_picker_announce_current_selection` | int | 0x7f140593 | 26096 |
| `mtrl_picker_announce_current_selection_none` | int | 0x7f140594 | 26099 |
| `mtrl_picker_cancel` | int | 0x7f140595 | 26102 |
| `mtrl_picker_confirm` | int | 0x7f140596 | 26105 |
| `mtrl_picker_date_header_selected` | int | 0x7f140597 | 26108 |
| `mtrl_picker_date_header_title` | int | 0x7f140598 | 26111 |
| `mtrl_picker_date_header_unselected` | int | 0x7f140599 | 26114 |
| `mtrl_picker_day_of_week_column_header` | int | 0x7f14059a | 26117 |
| `mtrl_picker_end_date_description` | int | 0x7f14059b | 26120 |
| `mtrl_picker_invalid_format` | int | 0x7f14059c | 26123 |
| `mtrl_picker_invalid_format_example` | int | 0x7f14059d | 26126 |
| `mtrl_picker_invalid_format_use` | int | 0x7f14059e | 26129 |
| `mtrl_picker_invalid_range` | int | 0x7f14059f | 26132 |
| `mtrl_picker_navigate_to_current_year_description` | int | 0x7f1405a0 | 26135 |
| `mtrl_picker_navigate_to_year_description` | int | 0x7f1405a1 | 26138 |
| `mtrl_picker_out_of_range` | int | 0x7f1405a2 | 26141 |
| `mtrl_picker_range_header_only_end_selected` | int | 0x7f1405a3 | 26144 |
| `mtrl_picker_range_header_only_start_selected` | int | 0x7f1405a4 | 26147 |
| `mtrl_picker_range_header_selected` | int | 0x7f1405a5 | 26150 |
| `mtrl_picker_range_header_title` | int | 0x7f1405a6 | 26153 |
| `mtrl_picker_range_header_unselected` | int | 0x7f1405a7 | 26156 |
| `mtrl_picker_save` | int | 0x7f1405a8 | 26159 |
| `mtrl_picker_start_date_description` | int | 0x7f1405a9 | 26162 |
| `mtrl_picker_text_input_date_hint` | int | 0x7f1405aa | 26165 |
| `mtrl_picker_text_input_date_range_end_hint` | int | 0x7f1405ab | 26168 |
| `mtrl_picker_text_input_date_range_start_hint` | int | 0x7f1405ac | 26171 |
| `mtrl_picker_text_input_day_abbr` | int | 0x7f1405ad | 26174 |
| `mtrl_picker_text_input_month_abbr` | int | 0x7f1405ae | 26177 |
| `mtrl_picker_text_input_year_abbr` | int | 0x7f1405af | 26180 |
| `mtrl_picker_today_description` | int | 0x7f1405b0 | 26183 |
| `mtrl_picker_toggle_to_calendar_input_mode` | int | 0x7f1405b1 | 26186 |
| `mtrl_picker_toggle_to_day_selection` | int | 0x7f1405b2 | 26189 |
| `mtrl_picker_toggle_to_text_input_mode` | int | 0x7f1405b3 | 26192 |
| `mtrl_picker_toggle_to_year_selection` | int | 0x7f1405b4 | 26195 |
| `mtrl_switch_thumb_group_name` | int | 0x7f1405b5 | 26198 |
| `mtrl_switch_thumb_path_checked` | int | 0x7f1405b6 | 26201 |
| `mtrl_switch_thumb_path_morphing` | int | 0x7f1405b7 | 26204 |
| `mtrl_switch_thumb_path_name` | int | 0x7f1405b8 | 26207 |
| `mtrl_switch_thumb_path_pressed` | int | 0x7f1405b9 | 26210 |
| `mtrl_switch_thumb_path_unchecked` | int | 0x7f1405ba | 26213 |
| `mtrl_switch_track_decoration_path` | int | 0x7f1405bb | 26216 |
| `mtrl_switch_track_path` | int | 0x7f1405bc | 26219 |
| `mtrl_timepicker_cancel` | int | 0x7f1405bd | 26222 |
| `mtrl_timepicker_confirm` | int | 0x7f1405be | 26225 |
| `my_feedback` | int | 0x7f1405bf | 26228 |
| `nav_app_bar_navigate_up_description` | int | 0x7f1405c0 | 26231 |
| `nav_app_bar_open_drawer_description` | int | 0x7f1405c1 | 26234 |
| `new_device` | int | 0x7f1405c2 | 26237 |
| `newest_announcement` | int | 0x7f1405c3 | 26240 |
| `next` | int | 0x7f1405c4 | 26243 |
| `next_step` | int | 0x7f1405c5 | 26246 |
| `no` | int | 0x7f1405c6 | 26249 |
| `no_account` | int | 0x7f1405c7 | 26252 |
| `no_audio_component` | int | 0x7f1405c8 | 26255 |
| `no_author` | int | 0x7f1405c9 | 26258 |
| `no_connect_camera` | int | 0x7f1405ca | 26261 |
| `no_connect_max2_wifi` | int | 0x7f1405cb | 26264 |
| `no_connected` | int | 0x7f1405cc | 26267 |
| `no_connected_max2` | int | 0x7f1405cd | 26270 |
| `no_content` | int | 0x7f1405ce | 26273 |
| `no_device` | int | 0x7f1405cf | 26276 |
| `no_file_search` | int | 0x7f1405d0 | 26279 |
| `no_matched_firmware_found` | int | 0x7f1405d1 | 26282 |
| `no_more_reminder` | int | 0x7f1405d2 | 26285 |
| `no_net` | int | 0x7f1405d3 | 26288 |
| `no_product_model` | int | 0x7f1405d4 | 26291 |
| `no_pwd_noneed_input` | int | 0x7f1405d5 | 26294 |
| `no_sd_card` | int | 0x7f1405d6 | 26297 |
| `no_space_to_downlocal` | int | 0x7f1405d7 | 26300 |
| `no_space_to_downlocal_album` | int | 0x7f1405d8 | 26303 |
| `no_storage_permmision` | int | 0x7f1405d9 | 26306 |
| `no_trial_left` | int | 0x7f1405da | 26309 |
| `no_url` | int | 0x7f1405db | 26312 |
| `no_user_info` | int | 0x7f1405dc | 26315 |
| `no_wifi` | int | 0x7f1405dd | 26318 |
| `non_360_picture_not_support_switch` | int | 0x7f1405de | 26321 |
| `not_authorized` | int | 0x7f1405df | 26324 |
| `not_enough_phone_storage` | int | 0x7f1405e0 | 26327 |
| `not_found_email_app` | int | 0x7f1405e1 | 26330 |
| `not_init` | int | 0x7f1405e2 | 26333 |
| `not_install_wechat` | int | 0x7f1405e3 | 26336 |
| `not_selected_any_media` | int | 0x7f1405e4 | 26339 |
| `not_selected_any_pictures` | int | 0x7f1405e5 | 26342 |
| `not_set_fbl` | int | 0x7f1405e6 | 26345 |
| `not_set_fps` | int | 0x7f1405e7 | 26348 |
| `not_set_rtmp` | int | 0x7f1405e8 | 26351 |
| `not_sign_in` | int | 0x7f1405e9 | 26354 |
| `ok` | int | 0x7f1405ea | 26357 |
| `open_device_wifi` | int | 0x7f1405eb | 26360 |
| `open_file_failed` | int | 0x7f1405ec | 26363 |
| `open_setting` | int | 0x7f1405ed | 26366 |
| `open_what_app_fail` | int | 0x7f1405ee | 26369 |
| `open_wifi` | int | 0x7f1405ef | 26372 |
| `open_wifi_step` | int | 0x7f1405f0 | 26375 |
| `operation_fail` | int | 0x7f1405f1 | 26378 |
| `operation_failed` | int | 0x7f1405f2 | 26381 |
| `operation_photo` | int | 0x7f1405f3 | 26384 |
| `operation_success` | int | 0x7f1405f4 | 26387 |
| `opt_failed_retry` | int | 0x7f1405f5 | 26390 |
| `origin_file` | int | 0x7f1405f6 | 26393 |
| `original_audio_off` | int | 0x7f1405f7 | 26396 |
| `original_audio_on` | int | 0x7f1405f8 | 26399 |
| `os` | int | 0x7f1405f9 | 26402 |
| `others` | int | 0x7f1405fa | 26405 |
| `over_load_file` | int | 0x7f1405fb | 26408 |
| `package_exchange` | int | 0x7f1405fc | 26411 |
| `paired` | int | 0x7f1405fd | 26414 |
| `park_alrm` | int | 0x7f1405fe | 26417 |
| `password` | int | 0x7f1405ff | 26420 |
| `password_error` | int | 0x7f140600 | 26423 |
| `password_limit` | int | 0x7f140601 | 26426 |
| `password_toggle_content_description` | int | 0x7f140602 | 26429 |
| `path_password_eye` | int | 0x7f140603 | 26432 |
| `path_password_eye_mask_strike_through` | int | 0x7f140604 | 26435 |
| `path_password_eye_mask_visible` | int | 0x7f140605 | 26438 |
| `path_password_strike_through` | int | 0x7f140606 | 26441 |
| `pathroot` | int | 0x7f140607 | 26444 |
| `permission` | int | 0x7f140609 | 26447 |
| `permission_ask` | int | 0x7f14060a | 26450 |
| `permission_dialog_info` | int | 0x7f14060b | 26453 |
| `permission_dialog_title` | int | 0x7f14060c | 26456 |
| `permission_explanation` | int | 0x7f14060d | 26459 |
| `permission_modify_fail` | int | 0x7f14060e | 26462 |
| `permission_modify_success` | int | 0x7f14060f | 26465 |
| `permission_specification_hyh` | int | 0x7f140610 | 26468 |
| `permission_title` | int | 0x7f140611 | 26471 |
| `permisson_not_allowed` | int | 0x7f140612 | 26474 |
| `permisson_tips` | int | 0x7f140613 | 26477 |
| `perspective` | int | 0x7f140614 | 26480 |
| `phone_gallery` | int | 0x7f140617 | 26489 |
| `phone_no_space` | int | 0x7f140618 | 26492 |
| `phone_number` | int | 0x7f140619 | 26495 |
| `phone_number_des_1` | int | 0x7f14061a | 26498 |
| `phoneError` | int | 0x7f140615 | 26483 |
| `phoneInfo` | int | 0x7f140616 | 26486 |
| `photo_edit_yutupro` | int | 0x7f14061b | 26501 |
| `photo_resolution` | int | 0x7f14061c | 26504 |
| `photos` | int | 0x7f14061d | 26507 |
| `pic` | int | 0x7f14061e | 26510 |
| `pic_less_than_10` | int | 0x7f14061f | 26513 |
| `pic_size` | int | 0x7f140620 | 26516 |
| `pic_video` | int | 0x7f140621 | 26519 |
| `pickerview_cancel` | int | 0x7f140622 | 26522 |
| `pickerview_day` | int | 0x7f140623 | 26525 |
| `pickerview_hours` | int | 0x7f140624 | 26528 |
| `pickerview_minutes` | int | 0x7f140625 | 26531 |
| `pickerview_month` | int | 0x7f140626 | 26534 |
| `pickerview_seconds` | int | 0x7f140627 | 26537 |
| `pickerview_submit` | int | 0x7f140628 | 26540 |
| `pickerview_year` | int | 0x7f140629 | 26543 |
| `playback_4g_low_px_hint` | int | 0x7f14062a | 26546 |
| `playback_mode_no_live_play` | int | 0x7f14062b | 26549 |
| `please_choose_live_platform` | int | 0x7f14062d | 26555 |
| `please_live_wifi_name` | int | 0x7f14062e | 26558 |
| `please_open` | int | 0x7f14062f | 26561 |
| `please_select_one_file_local_album` | int | 0x7f140630 | 26564 |
| `please_select_one_file_remote_playback_delete` | int | 0x7f140631 | 26567 |
| `please_select_one_file_remote_playback_download` | int | 0x7f140632 | 26570 |
| `please_stay_tuned` | int | 0x7f140633 | 26573 |
| `please_wait` | int | 0x7f140634 | 26576 |
| `PleaseAvailableInternet` | int | 0x7f14000c | 21857 |
| `pleaseClearFavorites` | int | 0x7f14062c | 26552 |
| `PleaseConnectCameraWifi` | int | 0x7f14000d | 21860 |
| `PleaseDoNotQuitApp` | int | 0x7f14000e | 21863 |
| `pls_open_wifi` | int | 0x7f140635 | 26579 |
| `pls_set_permissiontoapp` | int | 0x7f140636 | 26582 |
| `pls_waite_finish` | int | 0x7f140637 | 26585 |
| `popup_Window` | int | 0x7f140638 | 26588 |
| `portuguese` | int | 0x7f140639 | 26591 |
| `power` | int | 0x7f14063a | 26594 |
| `ppcs_connect_success` | int | 0x7f14063b | 26597 |
| `ppcs_device_not_online` | int | 0x7f14063c | 26600 |
| `ppcs_invalid_dsk` | int | 0x7f14063d | 26603 |
| `ppcs_invalid_id` | int | 0x7f14063e | 26606 |
| `ppcs_invalid_parameter` | int | 0x7f14063f | 26609 |
| `ppcs_invalid_prefix` | int | 0x7f140640 | 26612 |
| `ppcs_invalid_session` | int | 0x7f140641 | 26615 |
| `ppcs_max_session` | int | 0x7f140642 | 26618 |
| `ppcs_no_relay_server` | int | 0x7f140643 | 26621 |
| `ppcs_not_initialized` | int | 0x7f140644 | 26624 |
| `ppcs_remote_buffer_full` | int | 0x7f140645 | 26627 |
| `ppcs_session_closed_called` | int | 0x7f140646 | 26630 |
| `ppcs_session_closed_remote` | int | 0x7f140647 | 26633 |
| `ppcs_session_closed_timeout` | int | 0x7f140648 | 26636 |
| `ppcs_tcp_relay_failed` | int | 0x7f140649 | 26639 |
| `ppcs_time_out` | int | 0x7f14064a | 26642 |
| `ppcs_udp_bind_failed` | int | 0x7f14064b | 26645 |
| `ppcs_user_connect_break` | int | 0x7f14064c | 26648 |
| `ppcs_write_success` | int | 0x7f14064d | 26651 |
| `pref_1_hour` | int | 0x7f140653 | 26669 |
| `pref_1_min` | int | 0x7f140654 | 26672 |
| `pref_1_s` | int | 0x7f140655 | 26675 |
| `pref_1_sec` | int | 0x7f140656 | 26678 |
| `pref_10_min` | int | 0x7f14064f | 26657 |
| `pref_10_s` | int | 0x7f140650 | 26660 |
| `pref_10_sec` | int | 0x7f140651 | 26663 |
| `pref_10000` | int | 0x7f14064e | 26654 |
| `pref_15_min` | int | 0x7f140652 | 26666 |
| `pref_2_s` | int | 0x7f140659 | 26687 |
| `pref_20_min` | int | 0x7f140658 | 26684 |
| `pref_2000` | int | 0x7f140657 | 26681 |
| `pref_3_min` | int | 0x7f14065d | 26699 |
| `pref_3_s` | int | 0x7f14065e | 26702 |
| `pref_3_sec` | int | 0x7f14065f | 26705 |
| `pref_30_min` | int | 0x7f14065a | 26690 |
| `pref_30_s` | int | 0x7f14065b | 26693 |
| `pref_30_sec` | int | 0x7f14065c | 26696 |
| `pref_5_min` | int | 0x7f140661 | 26711 |
| `pref_5_s` | int | 0x7f140662 | 26714 |
| `pref_5_sec` | int | 0x7f140663 | 26717 |
| `pref_5000` | int | 0x7f140660 | 26708 |
| `pref_60_s` | int | 0x7f140664 | 26720 |
| `pref_60_sec` | int | 0x7f140665 | 26723 |
| `pref_8_s` | int | 0x7f140666 | 26726 |
| `pref_advanced_settings` | int | 0x7f140667 | 26729 |
| `pref_app_version` | int | 0x7f140668 | 26732 |
| `pref_cache_cleanup` | int | 0x7f140669 | 26735 |
| `pref_card_error` | int | 0x7f14066a | 26738 |
| `pref_card_normal` | int | 0x7f14066b | 26741 |
| `pref_center` | int | 0x7f14066c | 26744 |
| `pref_date` | int | 0x7f14066d | 26747 |
| `pref_date_and_time` | int | 0x7f14066e | 26750 |
| `pref_driving_mode` | int | 0x7f14066f | 26753 |
| `pref_figure` | int | 0x7f140670 | 26756 |
| `pref_five_shoot` | int | 0x7f140671 | 26759 |
| `pref_format` | int | 0x7f140672 | 26762 |
| `pref_fw_version` | int | 0x7f140673 | 26765 |
| `pref_general_settings` | int | 0x7f140674 | 26768 |
| `pref_high` | int | 0x7f140675 | 26771 |
| `pref_image_flip` | int | 0x7f140676 | 26774 |
| `pref_image_stabilization` | int | 0x7f140677 | 26777 |
| `pref_light_painting` | int | 0x7f140678 | 26780 |
| `pref_local_album_path` | int | 0x7f140679 | 26783 |
| `pref_low` | int | 0x7f14067a | 26786 |
| `pref_middle` | int | 0x7f14067b | 26789 |
| `pref_motion_detecting` | int | 0x7f14067c | 26792 |
| `pref_multipoint` | int | 0x7f14067d | 26795 |
| `pref_night_view` | int | 0x7f14067e | 26798 |
| `pref_no_card` | int | 0x7f14067f | 26801 |
| `pref_off` | int | 0x7f140680 | 26804 |
| `pref_point` | int | 0x7f140681 | 26807 |
| `pref_power_on_auto_record` | int | 0x7f140682 | 26810 |
| `pref_remaining_capacity` | int | 0x7f140683 | 26813 |
| `pref_res_capture_delay` | int | 0x7f140684 | 26816 |
| `pref_res_capture_iso` | int | 0x7f140685 | 26819 |
| `pref_res_date_stamp` | int | 0x7f140686 | 26822 |
| `pref_res_exposure_compensation` | int | 0x7f140687 | 26825 |
| `pref_res_fast_motion` | int | 0x7f140688 | 26828 |
| `pref_res_fast_motion_movie` | int | 0x7f140689 | 26831 |
| `pref_res_image_beautify` | int | 0x7f14068a | 26834 |
| `pref_res_image_quality` | int | 0x7f14068b | 26837 |
| `pref_res_image_sharpness` | int | 0x7f14068c | 26840 |
| `pref_res_image_size` | int | 0x7f14068d | 26843 |
| `pref_res_long_exposure` | int | 0x7f14068e | 26846 |
| `pref_res_metering_mode` | int | 0x7f14068f | 26849 |
| `pref_res_power_supply` | int | 0x7f140690 | 26852 |
| `pref_res_screen_saver` | int | 0x7f140691 | 26855 |
| `pref_res_shoot` | int | 0x7f140692 | 26858 |
| `pref_res_slow_motion` | int | 0x7f140693 | 26861 |
| `pref_res_timelapse_interval` | int | 0x7f140694 | 26864 |
| `pref_res_timelapse_length` | int | 0x7f140695 | 26867 |
| `pref_res_timelapse_mode` | int | 0x7f140696 | 26870 |
| `pref_res_vertical_screen` | int | 0x7f140697 | 26873 |
| `pref_res_video_file_length` | int | 0x7f140698 | 26876 |
| `pref_res_video_quality` | int | 0x7f140699 | 26879 |
| `pref_res_video_size` | int | 0x7f14069a | 26882 |
| `pref_res_white_balance` | int | 0x7f14069b | 26885 |
| `pref_res_wifi_name` | int | 0x7f14069c | 26888 |
| `pref_res_wifi_password` | int | 0x7f14069d | 26891 |
| `pref_reset` | int | 0x7f14069e | 26894 |
| `pref_sdcard_full` | int | 0x7f14069f | 26897 |
| `pref_sdcard_insert` | int | 0x7f1406a0 | 26900 |
| `pref_sdcard_removed` | int | 0x7f1406a1 | 26903 |
| `pref_soft` | int | 0x7f1406a2 | 26906 |
| `pref_standard` | int | 0x7f1406a3 | 26909 |
| `pref_storage` | int | 0x7f1406a4 | 26912 |
| `pref_strong` | int | 0x7f1406a5 | 26915 |
| `pref_system` | int | 0x7f1406a6 | 26918 |
| `pref_ten_shoot` | int | 0x7f1406a7 | 26921 |
| `pref_three_shoot` | int | 0x7f1406a8 | 26924 |
| `pref_time_calibration` | int | 0x7f1406a9 | 26927 |
| `pref_timelapse_mode_picture` | int | 0x7f1406aa | 26930 |
| `pref_timelapse_mode_video` | int | 0x7f1406ab | 26933 |
| `pref_unlimited` | int | 0x7f1406ac | 26936 |
| `pref_video_flip` | int | 0x7f1406ad | 26939 |
| `pref_wb_auto` | int | 0x7f1406ae | 26942 |
| `pref_wb_cloudy` | int | 0x7f1406af | 26945 |
| `pref_wb_daylight` | int | 0x7f1406b0 | 26948 |
| `pref_wb_fluorescent` | int | 0x7f1406b1 | 26951 |
| `pref_wb_incandescent` | int | 0x7f1406b2 | 26954 |
| `pref_wifi` | int | 0x7f1406b3 | 26957 |
| `preference_wifi_password_min_length_tip` | int | 0x7f1406b4 | 26960 |
| `preference_wifi_ssid_min_length_tip` | int | 0x7f1406b5 | 26963 |
| `prepare_finish_connect_wifi` | int | 0x7f1406b6 | 26966 |
| `press_again_quit` | int | 0x7f1406b7 | 26969 |
| `preview` | int | 0x7f1406b8 | 26972 |
| `previous_step` | int | 0x7f1406b9 | 26975 |
| `privacy_agreement_agree` | int | 0x7f1406ba | 26978 |
| `privacy_agreement_cancel` | int | 0x7f1406bb | 26981 |
| `privacy_agreement_content` | int | 0x7f1406bc | 26984 |
| `privacy_agreement_title` | int | 0x7f1406bd | 26987 |
| `privacy_policy` | int | 0x7f1406be | 26990 |
| `privacy_policy_` | int | 0x7f1406bf | 26993 |
| `problem_des_add_hint` | int | 0x7f1406c0 | 26996 |
| `problem_des_add_text` | int | 0x7f1406c1 | 26999 |
| `problem_des_warning` | int | 0x7f1406c2 | 27002 |
| `problem_desc` | int | 0x7f1406c3 | 27005 |
| `problem_description` | int | 0x7f1406c4 | 27008 |
| `problem_type` | int | 0x7f1406c5 | 27011 |
| `product_model` | int | 0x7f1406c6 | 27014 |
| `product_type` | int | 0x7f1406c7 | 27017 |
| `ps_all_audio` | int | 0x7f1406c8 | 27020 |
| `ps_audio` | int | 0x7f1406c9 | 27023 |
| `ps_audio_empty` | int | 0x7f1406ca | 27026 |
| `ps_audio_error` | int | 0x7f1406cb | 27029 |
| `ps_camera` | int | 0x7f1406cc | 27032 |
| `ps_camera_roll` | int | 0x7f1406cd | 27035 |
| `ps_camera_roll_num` | int | 0x7f1406ce | 27038 |
| `ps_cancel` | int | 0x7f1406cf | 27041 |
| `ps_choose_limit_seconds` | int | 0x7f1406d0 | 27044 |
| `ps_choose_max_seconds` | int | 0x7f1406d1 | 27047 |
| `ps_choose_min_seconds` | int | 0x7f1406d2 | 27050 |
| `ps_completed` | int | 0x7f1406d3 | 27053 |
| `ps_confirm` | int | 0x7f1406d4 | 27056 |
| `ps_current_month` | int | 0x7f1406d5 | 27059 |
| `ps_current_week` | int | 0x7f1406d6 | 27062 |
| `ps_data_exception` | int | 0x7f1406d7 | 27065 |
| `ps_data_null` | int | 0x7f1406d8 | 27068 |
| `ps_default_original_image` | int | 0x7f1406d9 | 27071 |
| `ps_done` | int | 0x7f1406da | 27074 |
| `ps_done_front_num` | int | 0x7f1406db | 27077 |
| `ps_editor` | int | 0x7f1406dc | 27080 |
| `ps_empty` | int | 0x7f1406dd | 27083 |
| `ps_empty_audio_title` | int | 0x7f1406de | 27086 |
| `ps_empty_title` | int | 0x7f1406df | 27089 |
| `ps_error` | int | 0x7f1406e0 | 27092 |
| `ps_gif_tag` | int | 0x7f1406e1 | 27095 |
| `ps_go_setting` | int | 0x7f1406e2 | 27098 |
| `ps_jurisdiction` | int | 0x7f1406e3 | 27101 |
| `ps_know` | int | 0x7f1406e4 | 27104 |
| `ps_long_chart` | int | 0x7f1406e5 | 27107 |
| `ps_message_audio_max_num` | int | 0x7f1406e6 | 27110 |
| `ps_message_max_num` | int | 0x7f1406e7 | 27113 |
| `ps_message_video_max_num` | int | 0x7f1406e8 | 27116 |
| `ps_min_audio_num` | int | 0x7f1406e9 | 27119 |
| `ps_min_img_num` | int | 0x7f1406ea | 27122 |
| `ps_min_video_num` | int | 0x7f1406eb | 27125 |
| `ps_not_crop_data` | int | 0x7f1406ec | 27128 |
| `ps_original_image` | int | 0x7f1406ed | 27131 |
| `ps_pause_audio` | int | 0x7f1406ee | 27134 |
| `ps_photograph` | int | 0x7f1406ef | 27137 |
| `ps_play_audio` | int | 0x7f1406f0 | 27140 |
| `ps_please` | int | 0x7f1406f1 | 27143 |
| `ps_please_select` | int | 0x7f1406f2 | 27146 |
| `ps_preview` | int | 0x7f1406f3 | 27149 |
| `ps_preview_image_num` | int | 0x7f1406f4 | 27152 |
| `ps_preview_num` | int | 0x7f1406f5 | 27155 |
| `ps_prompt` | int | 0x7f1406f6 | 27158 |
| `ps_prompt_audio_content` | int | 0x7f1406f7 | 27161 |
| `ps_prompt_image_content` | int | 0x7f1406f8 | 27164 |
| `ps_prompt_video_content` | int | 0x7f1406f9 | 27167 |
| `ps_quit_audio` | int | 0x7f1406fa | 27170 |
| `ps_record_video` | int | 0x7f1406fb | 27173 |
| `ps_rule` | int | 0x7f1406fc | 27176 |
| `ps_save_audio_error` | int | 0x7f1406fd | 27179 |
| `ps_save_image_error` | int | 0x7f1406fe | 27182 |
| `ps_save_success` | int | 0x7f1406ff | 27185 |
| `ps_save_video_error` | int | 0x7f140700 | 27188 |
| `ps_select` | int | 0x7f140701 | 27191 |
| `ps_select_audio_max_second` | int | 0x7f140702 | 27194 |
| `ps_select_audio_min_second` | int | 0x7f140703 | 27197 |
| `ps_select_max_size` | int | 0x7f140704 | 27200 |
| `ps_select_min_size` | int | 0x7f140705 | 27203 |
| `ps_select_no_support` | int | 0x7f140706 | 27206 |
| `ps_select_video_max_second` | int | 0x7f140707 | 27209 |
| `ps_select_video_min_second` | int | 0x7f140708 | 27212 |
| `ps_send` | int | 0x7f140709 | 27215 |
| `ps_send_num` | int | 0x7f14070a | 27218 |
| `ps_stop_audio` | int | 0x7f14070b | 27221 |
| `ps_take_picture` | int | 0x7f14070c | 27224 |
| `ps_tape` | int | 0x7f14070d | 27227 |
| `ps_use_camera` | int | 0x7f14070e | 27230 |
| `ps_use_sound` | int | 0x7f14070f | 27233 |
| `ps_video_error` | int | 0x7f140710 | 27236 |
| `ps_video_toast` | int | 0x7f140711 | 27239 |
| `ps_warning` | int | 0x7f140712 | 27242 |
| `ps_webp_tag` | int | 0x7f140713 | 27245 |
| `push_stream_addr` | int | 0x7f140714 | 27248 |
| `push_time` | int | 0x7f140715 | 27251 |
| `push_waiting` | int | 0x7f140716 | 27254 |
| `query_media_info_fail` | int | 0x7f140717 | 27257 |
| `questionContent` | int | 0x7f140718 | 27260 |
| `questionFeedback` | int | 0x7f140719 | 27263 |
| `radio_text_1` | int | 0x7f14071a | 27266 |
| `radio_text_2` | int | 0x7f14071b | 27269 |
| `radio_text_3` | int | 0x7f14071c | 27272 |
| `radio_text_4` | int | 0x7f14071d | 27275 |
| `radio_text_5` | int | 0x7f14071e | 27278 |
| `radio_text_6` | int | 0x7f14071f | 27281 |
| `radio_text_7` | int | 0x7f140720 | 27284 |
| `rate` | int | 0x7f140721 | 27287 |
| `ready_for_stream` | int | 0x7f140722 | 27290 |
| `reboot` | int | 0x7f140723 | 27293 |
| `rec_setting` | int | 0x7f140724 | 27296 |
| `reconnect` | int | 0x7f140725 | 27299 |
| `record_audio_permission_ask` | int | 0x7f140726 | 27302 |
| `recording_timelapse` | int | 0x7f140727 | 27305 |
| `refresh` | int | 0x7f140728 | 27308 |
| `refresh_later` | int | 0x7f140729 | 27311 |
| `register_fail_des` | int | 0x7f14072a | 27314 |
| `register_forget_pwd_success_des` | int | 0x7f14072b | 27317 |
| `register_success_des` | int | 0x7f14072c | 27320 |
| `reject_failed` | int | 0x7f14072d | 27323 |
| `rejected` | int | 0x7f14072e | 27326 |
| `remainContact` | int | 0x7f14072f | 27329 |
| `report_fail_des` | int | 0x7f140730 | 27332 |
| `report_feedback` | int | 0x7f140731 | 27335 |
| `report_success_des` | int | 0x7f140732 | 27338 |
| `request_fail` | int | 0x7f140733 | 27341 |
| `rescan` | int | 0x7f140734 | 27344 |
| `reset` | int | 0x7f140735 | 27347 |
| `reset_and_shutdown` | int | 0x7f140736 | 27350 |
| `reset_fail` | int | 0x7f140737 | 27353 |
| `reset_failed` | int | 0x7f140738 | 27356 |
| `reset_success` | int | 0x7f140739 | 27359 |
| `resolution` | int | 0x7f14073a | 27362 |
| `restore_settings` | int | 0x7f14073b | 27365 |
| `restore_tip` | int | 0x7f14073c | 27368 |
| `retry` | int | 0x7f14073d | 27371 |
| `revoke_authorization` | int | 0x7f14073e | 27374 |
| `ri` | int | 0x7f14073f | 27377 |
| `rl_camera_scan_qr` | int | 0x7f140740 | 27380 |
| `rl_custom_setting` | int | 0x7f140741 | 27383 |
| `rl_input_rtmp` | int | 0x7f140742 | 27386 |
| `rl_live_wifi` | int | 0x7f140743 | 27389 |
| `rl_location_not_turn_on` | int | 0x7f140744 | 27392 |
| `rl_rtmp_push_address` | int | 0x7f140745 | 27395 |
| `rl_scan_code_live` | int | 0x7f140746 | 27398 |
| `rl_selete_plaform` | int | 0x7f140747 | 27401 |
| `rl_selete_wifi` | int | 0x7f140748 | 27404 |
| `rl_start_live` | int | 0x7f140749 | 27407 |
| `rl_wifi_cancel` | int | 0x7f14074a | 27410 |
| `rl_wifi_confirm` | int | 0x7f14074b | 27413 |
| `rl_wifi_open_please` | int | 0x7f14074c | 27416 |
| `rotate` | int | 0x7f14074d | 27419 |
| `router_no_net` | int | 0x7f14074e | 27422 |
| `router_non_wifi` | int | 0x7f14074f | 27425 |
| `rtmp` | int | 0x7f140750 | 27428 |
| `rtmp_example` | int | 0x7f140751 | 27431 |
| `rtmp_push_address` | int | 0x7f140752 | 27434 |
| `rtmp_push_stream` | int | 0x7f140753 | 27437 |
| `russian` | int | 0x7f140754 | 27440 |
| `sat` | int | 0x7f140755 | 27443 |
| `save_to_phone` | int | 0x7f140756 | 27446 |
| `save_user_info_success` | int | 0x7f140757 | 27449 |
| `saved` | int | 0x7f140758 | 27452 |
| `saved_failed` | int | 0x7f140759 | 27455 |
| `saved_successfully` | int | 0x7f14075a | 27458 |
| `scan_add_device` | int | 0x7f14075b | 27461 |
| `scan_no_wifiinfo` | int | 0x7f14075c | 27464 |
| `scan_retry` | int | 0x7f14075d | 27467 |
| `scankit_confirm` | int | 0x7f14075e | 27470 |
| `scankit_light` | int | 0x7f14075f | 27473 |
| `scankit_light_off` | int | 0x7f140760 | 27476 |
| `scankit_no_code_tip` | int | 0x7f140761 | 27479 |
| `scankit_scan_tip` | int | 0x7f140762 | 27482 |
| `scankit_talkback_back` | int | 0x7f140763 | 27485 |
| `scankit_talkback_photo` | int | 0x7f140764 | 27488 |
| `scankit_title` | int | 0x7f140765 | 27491 |
| `scankit_title_all` | int | 0x7f140766 | 27494 |
| `scankit_title_all_level_two` | int | 0x7f140767 | 27497 |
| `scankit_title_qr` | int | 0x7f140768 | 27500 |
| `scankit_title_qr_level_two` | int | 0x7f140769 | 27503 |
| `screen_auto_sleep` | int | 0x7f14076a | 27506 |
| `screenshot` | int | 0x7f14076b | 27509 |
| `sd_card_settings` | int | 0x7f14076d | 27515 |
| `sd_fbl` | int | 0x7f14076e | 27518 |
| `sd_full` | int | 0x7f14076f | 27521 |
| `sd_no_more_space` | int | 0x7f140770 | 27524 |
| `sd_pull_out` | int | 0x7f140771 | 27527 |
| `sdCard` | int | 0x7f14076c | 27512 |
| `search_menu_title` | int | 0x7f140772 | 27530 |
| `searchbar_scrolling_view_behavior` | int | 0x7f140773 | 27533 |
| `searching` | int | 0x7f140774 | 27536 |
| `searchview_clear_text_content_description` | int | 0x7f140775 | 27539 |
| `searchview_navigation_content_description` | int | 0x7f140776 | 27542 |
| `second` | int | 0x7f140777 | 27545 |
| `select` | int | 0x7f140778 | 27548 |
| `select_add_device` | int | 0x7f14077c | 27560 |
| `select_device` | int | 0x7f14077d | 27563 |
| `select_device1` | int | 0x7f14077e | 27566 |
| `select_live_device_model` | int | 0x7f14077f | 27569 |
| `select_live_device_supprt_model` | int | 0x7f140780 | 27572 |
| `select_live_device_switch_model` | int | 0x7f140781 | 27575 |
| `select_live_device_switch_wifi` | int | 0x7f140782 | 27578 |
| `select_product_model_first` | int | 0x7f140783 | 27581 |
| `select_product_type_first` | int | 0x7f140784 | 27584 |
| `select_stream` | int | 0x7f140785 | 27587 |
| `select_stream_platform` | int | 0x7f140786 | 27590 |
| `select_wifi` | int | 0x7f140787 | 27593 |
| `select_wifi_hint` | int | 0x7f140788 | 27596 |
| `selectDevice` | int | 0x7f140779 | 27551 |
| `selectFile` | int | 0x7f14077a | 27554 |
| `selectNumberOfFiles` | int | 0x7f14077b | 27557 |
| `send_cancel` | int | 0x7f140789 | 27599 |
| `send_cmd_error` | int | 0x7f14078a | 27602 |
| `send_firm` | int | 0x7f14078b | 27605 |
| `send_soft_fail_hint` | int | 0x7f14078c | 27608 |
| `sending_soft_pack` | int | 0x7f14078d | 27611 |
| `sensor` | int | 0x7f14078e | 27614 |
| `server_error` | int | 0x7f14078f | 27617 |
| `server_timeout` | int | 0x7f140790 | 27620 |
| `set_datetime` | int | 0x7f140791 | 27623 |
| `set_pwd` | int | 0x7f140792 | 27626 |
| `set_pwd_hint` | int | 0x7f140793 | 27629 |
| `setting` | int | 0x7f140794 | 27632 |
| `setting_app_version` | int | 0x7f140795 | 27635 |
| `setting_audio_switch` | int | 0x7f140796 | 27638 |
| `setting_auto_download` | int | 0x7f140797 | 27641 |
| `setting_auto_download_size_limit` | int | 0x7f140798 | 27644 |
| `setting_camera_back` | int | 0x7f140799 | 27647 |
| `setting_camera_front` | int | 0x7f14079a | 27650 |
| `setting_capture_delay` | int | 0x7f14079b | 27653 |
| `setting_datestamp` | int | 0x7f14079c | 27656 |
| `setting_enable_wifi_hotspot` | int | 0x7f14079d | 27659 |
| `setting_fail` | int | 0x7f14079e | 27662 |
| `setting_failure_not_support_param` | int | 0x7f14079f | 27665 |
| `setting_firmware_version` | int | 0x7f1407a0 | 27668 |
| `setting_format` | int | 0x7f1407a1 | 27671 |
| `setting_format_desc` | int | 0x7f1407a2 | 27674 |
| `setting_image_size` | int | 0x7f1407a3 | 27677 |
| `setting_internal_storage` | int | 0x7f1407a4 | 27680 |
| `setting_mode_photo` | int | 0x7f1407a5 | 27683 |
| `setting_multi_burst` | int | 0x7f1407a6 | 27686 |
| `setting_multi_timelapse` | int | 0x7f1407a7 | 27689 |
| `setting_no` | int | 0x7f1407a8 | 27692 |
| `setting_off` | int | 0x7f1407a9 | 27695 |
| `setting_on` | int | 0x7f1407aa | 27698 |
| `setting_photo_timer` | int | 0x7f1407ab | 27701 |
| `setting_power_supply` | int | 0x7f1407ac | 27704 |
| `setting_product_name` | int | 0x7f1407ad | 27707 |
| `setting_sd_card_storage` | int | 0x7f1407ae | 27710 |
| `setting_sdcard_left` | int | 0x7f1407af | 27713 |
| `setting_sdcard_total` | int | 0x7f1407b0 | 27716 |
| `setting_storage_location` | int | 0x7f1407b1 | 27719 |
| `setting_success` | int | 0x7f1407b2 | 27722 |
| `setting_time_lapse_duration` | int | 0x7f1407b3 | 27725 |
| `setting_time_lapse_duration_10M` | int | 0x7f1407b4 | 27728 |
| `setting_time_lapse_duration_15M` | int | 0x7f1407b5 | 27731 |
| `setting_time_lapse_duration_20M` | int | 0x7f1407b6 | 27734 |
| `setting_time_lapse_duration_2M` | int | 0x7f1407b7 | 27737 |
| `setting_time_lapse_duration_30M` | int | 0x7f1407b8 | 27740 |
| `setting_time_lapse_duration_5M` | int | 0x7f1407b9 | 27743 |
| `setting_time_lapse_duration_60M` | int | 0x7f1407ba | 27746 |
| `setting_time_lapse_duration_unlimit` | int | 0x7f1407bb | 27749 |
| `setting_time_lapse_interval` | int | 0x7f1407bc | 27752 |
| `setting_title_auto_power_off` | int | 0x7f1407bd | 27755 |
| `setting_title_exposure_compensation` | int | 0x7f1407be | 27758 |
| `setting_title_fast_motion_movie` | int | 0x7f1407bf | 27761 |
| `setting_title_image_stabilization` | int | 0x7f1407c0 | 27764 |
| `setting_title_power_on_auto_record` | int | 0x7f1407c1 | 27767 |
| `setting_title_screen_saver` | int | 0x7f1407c2 | 27770 |
| `setting_title_video_file_length` | int | 0x7f1407c3 | 27773 |
| `setting_title_wind_noise_reduction` | int | 0x7f1407c4 | 27776 |
| `setting_updatefw_chec_sum_failed` | int | 0x7f1407c5 | 27779 |
| `setting_updatefw_closeAppInfo` | int | 0x7f1407c6 | 27782 |
| `setting_updatefw_failed` | int | 0x7f1407c7 | 27785 |
| `setting_video_loop` | int | 0x7f1407c8 | 27788 |
| `setting_video_normal` | int | 0x7f1407c9 | 27791 |
| `setting_video_size` | int | 0x7f1407ca | 27794 |
| `setting_video_slow` | int | 0x7f1407cb | 27797 |
| `setting_video_timelapse` | int | 0x7f1407cc | 27800 |
| `setting_yes` | int | 0x7f1407cd | 27803 |
| `settings` | int | 0x7f1407ce | 27806 |
| `share_failed` | int | 0x7f1407cf | 27809 |
| `share_format` | int | 0x7f1407d0 | 27812 |
| `share_image` | int | 0x7f1407d1 | 27815 |
| `share_video` | int | 0x7f1407d2 | 27818 |
| `shared_a_device` | int | 0x7f1407d3 | 27821 |
| `shared_a_device_to` | int | 0x7f1407d4 | 27824 |
| `shared_device_to_others` | int | 0x7f1407d5 | 27827 |
| `shipin_geshi_xianzhi` | int | 0x7f1407d6 | 27830 |
| `shot_save_album_fail` | int | 0x7f1407d7 | 27833 |
| `shot_saved_album` | int | 0x7f1407d8 | 27836 |
| `shutdown` | int | 0x7f1407d9 | 27839 |
| `side_sheet_accessibility_pane_title` | int | 0x7f1407da | 27842 |
| `side_sheet_behavior` | int | 0x7f1407db | 27845 |
| `sign_up_now` | int | 0x7f1407dc | 27848 |
| `SimplifiedChinese` | int | 0x7f14000f | 21866 |
| `sina_webo` | int | 0x7f1407dd | 27851 |
| `skip` | int | 0x7f1407de | 27854 |
| `sleep` | int | 0x7f1407df | 27857 |
| `slowmotion` | int | 0x7f1407e0 | 27860 |
| `soft_update_cancle` | int | 0x7f1407e1 | 27863 |
| `soft_update_checking` | int | 0x7f1407e2 | 27866 |
| `soft_update_download_fail` | int | 0x7f1407e3 | 27869 |
| `soft_update_info_gprs` | int | 0x7f1407e4 | 27872 |
| `soft_update_install` | int | 0x7f1407e5 | 27875 |
| `soft_update_no` | int | 0x7f1407e6 | 27878 |
| `soft_update_ok` | int | 0x7f1407e7 | 27881 |
| `soft_version` | int | 0x7f1407e8 | 27884 |
| `sound` | int | 0x7f1407e9 | 27887 |
| `spanish` | int | 0x7f1407ea | 27890 |
| `Spanish` | int | 0x7f140010 | 21869 |
| `spec_effect_blur` | int | 0x7f1407eb | 27893 |
| `spec_effect_emboss` | int | 0x7f1407ec | 27896 |
| `spec_effect_sketch` | int | 0x7f1407ed | 27899 |
| `spec_effect_toon` | int | 0x7f1407ee | 27902 |
| `spec_effect_white_balance` | int | 0x7f1407ef | 27905 |
| `speed_0` | int | 0x7f1407f0 | 27908 |
| `speed_unit` | int | 0x7f1407f1 | 27911 |
| `speeding` | int | 0x7f1407f2 | 27914 |
| `spinner_default_text` | int | 0x7f1407f3 | 27917 |
| `sports_30` | int | 0x7f1407f4 | 27920 |
| `sports_cameras` | int | 0x7f1407f5 | 27923 |
| `sports_fps` | int | 0x7f1407f6 | 27926 |
| `srl_component_falsify` | int | 0x7f1407f7 | 27929 |
| `srl_content_empty` | int | 0x7f1407f8 | 27932 |
| `srl_footer_failed` | int | 0x7f1407f9 | 27935 |
| `srl_footer_finish` | int | 0x7f1407fa | 27938 |
| `srl_footer_loading` | int | 0x7f1407fb | 27941 |
| `srl_footer_nothing` | int | 0x7f1407fc | 27944 |
| `srl_footer_pulling` | int | 0x7f1407fd | 27947 |
| `srl_footer_refreshing` | int | 0x7f1407fe | 27950 |
| `srl_footer_release` | int | 0x7f1407ff | 27953 |
| `srl_header_failed` | int | 0x7f140800 | 27956 |
| `srl_header_finish` | int | 0x7f140801 | 27959 |
| `srl_header_loading` | int | 0x7f140802 | 27962 |
| `srl_header_pulling` | int | 0x7f140803 | 27965 |
| `srl_header_refreshing` | int | 0x7f140804 | 27968 |
| `srl_header_release` | int | 0x7f140805 | 27971 |
| `srl_header_secondary` | int | 0x7f140806 | 27974 |
| `srl_header_update` | int | 0x7f140807 | 27977 |
| `ss_about_camera` | int | 0x7f140808 | 27980 |
| `ss_about_camera_app_version` | int | 0x7f140809 | 27983 |
| `ss_about_camera_bluetooth_bluetoothtxoneversion` | int | 0x7f14080a | 27986 |
| `ss_about_camera_bluetooth_bluetoothtxtwoversion` | int | 0x7f14080b | 27989 |
| `ss_about_camera_bluetooth_version` | int | 0x7f14080c | 27992 |
| `ss_about_camera_fw_date` | int | 0x7f14080d | 27995 |
| `ss_about_camera_fw_version` | int | 0x7f14080e | 27998 |
| `ss_bg_download_done` | int | 0x7f14080f | 28001 |
| `ss_bg_download_exists` | int | 0x7f140810 | 28004 |
| `ss_bg_download_start` | int | 0x7f140811 | 28007 |
| `ss_clear_cache` | int | 0x7f140812 | 28010 |
| `ss_clear_cache_success` | int | 0x7f140813 | 28013 |
| `ss_delete` | int | 0x7f140814 | 28016 |
| `ss_deleting` | int | 0x7f140815 | 28019 |
| `ss_device_setting` | int | 0x7f140816 | 28022 |
| `ss_download` | int | 0x7f140817 | 28025 |
| `ss_download_video` | int | 0x7f140818 | 28028 |
| `ss_downloaded` | int | 0x7f140819 | 28031 |
| `ss_downloading` | int | 0x7f14081a | 28034 |
| `ss_event_save` | int | 0x7f14081b | 28037 |
| `ss_event_start_photo` | int | 0x7f14081c | 28040 |
| `ss_event_start_record` | int | 0x7f14081d | 28043 |
| `ss_file_info` | int | 0x7f14081e | 28046 |
| `ss_file_info_create` | int | 0x7f14081f | 28049 |
| `ss_file_info_name` | int | 0x7f140820 | 28052 |
| `ss_file_info_path` | int | 0x7f140821 | 28055 |
| `ss_file_info_size` | int | 0x7f140822 | 28058 |
| `ss_format_failure` | int | 0x7f140823 | 28061 |
| `ss_format_success` | int | 0x7f140824 | 28064 |
| `ss_hd` | int | 0x7f140825 | 28067 |
| `ss_load_failure` | int | 0x7f140826 | 28070 |
| `ss_local_exists_the_same_name` | int | 0x7f140827 | 28073 |
| `ss_mode_select_photo` | int | 0x7f140828 | 28076 |
| `ss_mode_select_video` | int | 0x7f140829 | 28079 |
| `ss_normal` | int | 0x7f14082a | 28082 |
| `ss_not_downloaded` | int | 0x7f14082b | 28085 |
| `ss_operate_refuse` | int | 0x7f14082c | 28088 |
| `ss_overload` | int | 0x7f14082d | 28091 |
| `ss_rename` | int | 0x7f14082e | 28094 |
| `ss_retry` | int | 0x7f14082f | 28097 |
| `ss_retry_tip` | int | 0x7f140830 | 28100 |
| `ss_sd_full` | int | 0x7f140831 | 28103 |
| `ss_sd_in` | int | 0x7f140832 | 28106 |
| `ss_sd_out` | int | 0x7f140833 | 28109 |
| `ss_select_all` | int | 0x7f140834 | 28112 |
| `ss_set_failure` | int | 0x7f140835 | 28115 |
| `ss_set_system_time` | int | 0x7f140836 | 28118 |
| `ss_skip` | int | 0x7f140837 | 28121 |
| `ss_to_format_sd` | int | 0x7f140838 | 28124 |
| `ss_to_reset` | int | 0x7f140839 | 28127 |
| `ss_wifi_disconnected` | int | 0x7f14083a | 28130 |
| `ss_wifi_password` | int | 0x7f14083b | 28133 |
| `ss_wifi_ssid` | int | 0x7f14083c | 28136 |
| `ssid` | int | 0x7f14083d | 28139 |
| `ssis_hint` | int | 0x7f14083e | 28142 |
| `standard_25` | int | 0x7f14083f | 28145 |
| `standard_fps` | int | 0x7f140840 | 28148 |
| `start_config_stream` | int | 0x7f140841 | 28151 |
| `start_live` | int | 0x7f140842 | 28154 |
| `start_live_setting` | int | 0x7f140843 | 28157 |
| `start_live_support` | int | 0x7f140844 | 28160 |
| `start_record_fail` | int | 0x7f140845 | 28163 |
| `start_stream` | int | 0x7f140846 | 28166 |
| `start_stream_simple` | int | 0x7f140847 | 28169 |
| `status_bar_notification_info_overflow` | int | 0x7f140848 | 28172 |
| `stop_intercom` | int | 0x7f140849 | 28175 |
| `stop_record_fail` | int | 0x7f14084a | 28178 |
| `storage_path` | int | 0x7f14084b | 28181 |
| `storage_path_` | int | 0x7f14084c | 28184 |
| `storage_permission` | int | 0x7f14084d | 28187 |
| `storage_permission_ask` | int | 0x7f14084e | 28190 |
| `storage_permission_description_hyh` | int | 0x7f14084f | 28193 |
| `storage_permmision_directions` | int | 0x7f140850 | 28196 |
| `stream` | int | 0x7f140851 | 28199 |
| `stream_error_capturing` | int | 0x7f140852 | 28202 |
| `stream_error_recording` | int | 0x7f140853 | 28205 |
| `stream_parameters` | int | 0x7f140854 | 28208 |
| `stream_set_res_photo` | int | 0x7f140855 | 28211 |
| `stream_set_res_vid` | int | 0x7f140856 | 28214 |
| `stream_set_timer` | int | 0x7f140857 | 28217 |
| `stream_settings` | int | 0x7f140858 | 28220 |
| `streaming` | int | 0x7f140859 | 28223 |
| `submit` | int | 0x7f14085a | 28226 |
| `submit_fail` | int | 0x7f14085b | 28229 |
| `success` | int | 0x7f14085c | 28232 |
| `success_clean_cache` | int | 0x7f14085d | 28235 |
| `success_photo` | int | 0x7f14085e | 28238 |
| `sun` | int | 0x7f14085f | 28241 |
| `switch_camera_view_fail` | int | 0x7f140860 | 28244 |
| `switch_home_wlan` | int | 0x7f140861 | 28247 |
| `switch_language` | int | 0x7f140862 | 28250 |
| `sync_again` | int | 0x7f140863 | 28253 |
| `sync_failed` | int | 0x7f140864 | 28256 |
| `sync_file` | int | 0x7f140865 | 28259 |
| `sync_ing` | int | 0x7f140866 | 28262 |
| `sync_user_info_fail` | int | 0x7f140867 | 28265 |
| `sync_user_info_success` | int | 0x7f140868 | 28268 |
| `synchronizationTime` | int | 0x7f140869 | 28271 |
| `synec_time` | int | 0x7f14086a | 28274 |
| `taobao` | int | 0x7f14086b | 28277 |
| `technicalSupport` | int | 0x7f14086c | 28280 |
| `text_about` | int | 0x7f14086d | 28283 |
| `text_account_logout` | int | 0x7f14086e | 28286 |
| `text_add_dv` | int | 0x7f14086f | 28289 |
| `text_agree_continue` | int | 0x7f140870 | 28292 |
| `text_album` | int | 0x7f140871 | 28295 |
| `text_all` | int | 0x7f140872 | 28298 |
| `text_app_version_latest` | int | 0x7f140873 | 28301 |
| `text_asteroid` | int | 0x7f140874 | 28304 |
| `text_camera_preview` | int | 0x7f140875 | 28307 |
| `text_clear_cache` | int | 0x7f140876 | 28310 |
| `text_code_sent` | int | 0x7f140877 | 28313 |
| `text_connection_camera` | int | 0x7f140878 | 28316 |
| `text_delete_account` | int | 0x7f140879 | 28319 |
| `text_delete_des` | int | 0x7f14087a | 28322 |
| `text_delete_des_2` | int | 0x7f14087b | 28325 |
| `text_delete_tips` | int | 0x7f14087c | 28328 |
| `text_error_refresh` | int | 0x7f14087d | 28331 |
| `text_exception_info` | int | 0x7f14087e | 28334 |
| `text_exit_loading` | int | 0x7f14087f | 28337 |
| `text_find_app_new_version` | int | 0x7f140880 | 28340 |
| `text_format_card` | int | 0x7f140881 | 28343 |
| `text_hint_title` | int | 0x7f140882 | 28346 |
| `text_home` | int | 0x7f140883 | 28349 |
| `text_icp` | int | 0x7f140884 | 28352 |
| `text_loading` | int | 0x7f140885 | 28355 |
| `text_login` | int | 0x7f140886 | 28358 |
| `text_message_agreements_permission` | int | 0x7f140887 | 28361 |
| `text_message_auto_agree` | int | 0x7f140888 | 28364 |
| `text_message_user_privacy_policy` | int | 0x7f140889 | 28367 |
| `text_modify_des` | int | 0x7f14088a | 28370 |
| `text_modify_des_2` | int | 0x7f14088b | 28373 |
| `text_modify_pwd` | int | 0x7f14088c | 28376 |
| `text_need_permission` | int | 0x7f14088d | 28379 |
| `text_new_pwd` | int | 0x7f14088e | 28382 |
| `text_no_file` | int | 0x7f14088f | 28385 |
| `text_not_again` | int | 0x7f140890 | 28388 |
| `text_not_support_preview` | int | 0x7f140891 | 28391 |
| `text_old_pwd` | int | 0x7f140892 | 28394 |
| `text_panorama` | int | 0x7f140893 | 28397 |
| `text_password_tips` | int | 0x7f140894 | 28400 |
| `text_permission_location` | int | 0x7f140895 | 28403 |
| `text_permission_location_bluetooth` | int | 0x7f140896 | 28406 |
| `text_permission_location_bluetooth1` | int | 0x7f140897 | 28409 |
| `text_permission_location_bluetooth2` | int | 0x7f140898 | 28412 |
| `text_permission_location_camera` | int | 0x7f140899 | 28415 |
| `text_permission_storage` | int | 0x7f14089a | 28418 |
| `text_permission_storage1` | int | 0x7f14089b | 28421 |
| `text_phone_photo_album` | int | 0x7f14089c | 28424 |
| `text_player_tips` | int | 0x7f14089d | 28427 |
| `text_please_near_device` | int | 0x7f14089e | 28430 |
| `text_preview_tips` | int | 0x7f14089f | 28433 |
| `text_record_voice` | int | 0x7f1408a0 | 28436 |
| `text_register` | int | 0x7f1408a1 | 28439 |
| `text_reset_des` | int | 0x7f1408a2 | 28442 |
| `text_reset_pwd` | int | 0x7f1408a3 | 28445 |
| `text_reset_pwd_fail` | int | 0x7f1408a4 | 28448 |
| `text_reset_pwd_success` | int | 0x7f1408a5 | 28451 |
| `text_selected` | int | 0x7f1408a6 | 28454 |
| `text_settings` | int | 0x7f1408a7 | 28457 |
| `text_sign_out` | int | 0x7f1408a8 | 28460 |
| `text_stablization` | int | 0x7f1408a9 | 28463 |
| `text_sure` | int | 0x7f1408aa | 28466 |
| `text_taking_photo` | int | 0x7f1408ab | 28469 |
| `text_taking_pictures` | int | 0x7f1408ac | 28472 |
| `text_time_lapse` | int | 0x7f1408ad | 28475 |
| `text_time_lapse_image` | int | 0x7f1408ae | 28478 |
| `text_time_lapse_video` | int | 0x7f1408af | 28481 |
| `text_time_out` | int | 0x7f1408b0 | 28484 |
| `text_title_privacy_policy` | int | 0x7f1408b1 | 28487 |
| `text_title_user_agreement` | int | 0x7f1408b2 | 28490 |
| `text_user_agreements` | int | 0x7f1408b3 | 28493 |
| `text_user_permission` | int | 0x7f1408b4 | 28496 |
| `text_video` | int | 0x7f1408b5 | 28499 |
| `text_vr` | int | 0x7f1408b6 | 28502 |
| `text_zoom_max` | int | 0x7f1408b7 | 28505 |
| `text_zoom_min` | int | 0x7f1408b8 | 28508 |
| `theme_music` | int | 0x7f1408b9 | 28511 |
| `thu` | int | 0x7f1408ba | 28514 |
| `thumb_load_fail` | int | 0x7f1408bb | 28517 |
| `time` | int | 0x7f1408bc | 28520 |
| `time_1` | int | 0x7f1408c0 | 28532 |
| `time_10` | int | 0x7f1408c1 | 28535 |
| `time_15` | int | 0x7f1408c2 | 28538 |
| `time_3` | int | 0x7f1408c3 | 28541 |
| `time_30` | int | 0x7f1408c4 | 28544 |
| `time_45` | int | 0x7f1408c5 | 28547 |
| `time_5` | int | 0x7f1408c6 | 28550 |
| `time_60` | int | 0x7f1408c7 | 28553 |
| `time_lapse_end` | int | 0x7f1408c8 | 28556 |
| `time_lapse_start` | int | 0x7f1408c9 | 28559 |
| `time_minutes` | int | 0x7f1408ca | 28562 |
| `time_tag` | int | 0x7f1408cb | 28565 |
| `timelapse_0` | int | 0x7f1408cc | 28568 |
| `timelapse_1` | int | 0x7f1408cd | 28571 |
| `timelapse_10` | int | 0x7f1408ce | 28574 |
| `timelapse_15` | int | 0x7f1408cf | 28577 |
| `timelapse_2` | int | 0x7f1408d0 | 28580 |
| `timelapse_3` | int | 0x7f1408d1 | 28583 |
| `timelapse_30` | int | 0x7f1408d2 | 28586 |
| `timelapse_45` | int | 0x7f1408d3 | 28589 |
| `timelapse_5` | int | 0x7f1408d4 | 28592 |
| `timelapse_60` | int | 0x7f1408d5 | 28595 |
| `timeLapse_capture_mode` | int | 0x7f1408bd | 28523 |
| `timeLapse_not_allow` | int | 0x7f1408be | 28526 |
| `timeLapse_video_mode` | int | 0x7f1408bf | 28529 |
| `tips` | int | 0x7f1408d6 | 28598 |
| `tips_not_wifi` | int | 0x7f1408d7 | 28601 |
| `tips_not_wifi_cancel` | int | 0x7f1408d8 | 28604 |
| `tips_not_wifi_confirm` | int | 0x7f1408d9 | 28607 |
| `title_awb` | int | 0x7f1408da | 28610 |
| `title_burst` | int | 0x7f1408db | 28613 |
| `title_preview` | int | 0x7f1408dc | 28616 |
| `title_slow_motion` | int | 0x7f1408dd | 28619 |
| `title_timeLapse_mode` | int | 0x7f1408de | 28622 |
| `title_video` | int | 0x7f1408df | 28625 |
| `title_wifi_name` | int | 0x7f1408e0 | 28628 |
| `title_wifi_password` | int | 0x7f1408e1 | 28631 |
| `to_authorize` | int | 0x7f1408e2 | 28634 |
| `toast_max_pic_select` | int | 0x7f1408e3 | 28637 |
| `tourists_enter_text` | int | 0x7f1408e4 | 28640 |
| `track_latitude` | int | 0x7f1408e5 | 28643 |
| `track_longitude` | int | 0x7f1408e6 | 28646 |
| `track_speed` | int | 0x7f1408e7 | 28649 |
| `traditionalChinese` | int | 0x7f1408e8 | 28652 |
| `trial_left` | int | 0x7f1408e9 | 28655 |
| `tue` | int | 0x7f1408ea | 28658 |
| `tx_connected` | int | 0x7f1408eb | 28661 |
| `tx_connection_1` | int | 0x7f1408ec | 28664 |
| `tx_connection_2` | int | 0x7f1408ed | 28667 |
| `tx_connection_hint` | int | 0x7f1408ee | 28670 |
| `tx_not_connected` | int | 0x7f1408ef | 28673 |
| `ucrop_crop` | int | 0x7f1408f0 | 28676 |
| `ucrop_error_input_data_is_absent` | int | 0x7f1408f1 | 28679 |
| `ucrop_label_edit_photo` | int | 0x7f1408f2 | 28682 |
| `ucrop_label_original` | int | 0x7f1408f3 | 28685 |
| `ucrop_menu_crop` | int | 0x7f1408f4 | 28688 |
| `ucrop_mutate_exception_hint` | int | 0x7f1408f5 | 28691 |
| `ucrop_rotate` | int | 0x7f1408f6 | 28694 |
| `ucrop_scale` | int | 0x7f1408f7 | 28697 |
| `unauth` | int | 0x7f1408f8 | 28700 |
| `unchoose_net` | int | 0x7f1408f9 | 28703 |
| `unchoose_wifi` | int | 0x7f1408fa | 28706 |
| `uninit` | int | 0x7f1408fb | 28709 |
| `unknown_error` | int | 0x7f1408fc | 28712 |
| `unopen_live_platform` | int | 0x7f1408fd | 28715 |
| `update_dialog_message` | int | 0x7f1408ff | 28721 |
| `update_dialog_remind` | int | 0x7f140900 | 28724 |
| `update_pack_downloaded_to_send` | int | 0x7f140901 | 28727 |
| `update_version` | int | 0x7f140902 | 28730 |
| `updateMessage` | int | 0x7f1408fe | 28718 |
| `upgrade` | int | 0x7f140903 | 28733 |
| `upgrade_firmware` | int | 0x7f140904 | 28736 |
| `upload_attachment_failed` | int | 0x7f140905 | 28739 |
| `upload_avatar_fail` | int | 0x7f140906 | 28742 |
| `upload_fail` | int | 0x7f140907 | 28745 |
| `upload_failed` | int | 0x7f140908 | 28748 |
| `upload_feedback_attach_fail` | int | 0x7f140909 | 28751 |
| `upload_feedback_attach_success` | int | 0x7f14090a | 28754 |
| `upload_feedback_fail` | int | 0x7f14090b | 28757 |
| `upload_success` | int | 0x7f14090c | 28760 |
| `upload_title` | int | 0x7f14090d | 28763 |
| `upside` | int | 0x7f14090e | 28766 |
| `user_center` | int | 0x7f14090f | 28769 |
| `user_id_des` | int | 0x7f140910 | 28772 |
| `user_info` | int | 0x7f140911 | 28775 |
| `user_lecense` | int | 0x7f140912 | 28778 |
| `user_license_` | int | 0x7f140913 | 28781 |
| `user_shared` | int | 0x7f140914 | 28784 |
| `vehicle_collision` | int | 0x7f140915 | 28787 |
| `verify_checking` | int | 0x7f140916 | 28790 |
| `verify_code` | int | 0x7f140917 | 28793 |
| `verify_connected_device` | int | 0x7f140918 | 28796 |
| `verify_get_ip` | int | 0x7f140919 | 28799 |
| `verify_identifing` | int | 0x7f14091a | 28802 |
| `verify_msg` | int | 0x7f14091b | 28805 |
| `verify_not_range` | int | 0x7f14091c | 28808 |
| `verify_password_no` | int | 0x7f14091d | 28811 |
| `verify_password_yes` | int | 0x7f14091e | 28814 |
| `verify_wifi` | int | 0x7f14091f | 28817 |
| `version_name` | int | 0x7f140920 | 28820 |
| `video_channel_auth` | int | 0x7f140921 | 28823 |
| `video_format_not_support` | int | 0x7f140922 | 28826 |
| `video_lower_limit` | int | 0x7f140923 | 28829 |
| `video_mode` | int | 0x7f140924 | 28832 |
| `video_play_fail` | int | 0x7f140925 | 28835 |
| `video_resolution` | int | 0x7f140926 | 28838 |
| `video_unit` | int | 0x7f140927 | 28841 |
| `viewFile` | int | 0x7f140928 | 28844 |
| `wait` | int | 0x7f140929 | 28847 |
| `wakeup_failed` | int | 0x7f14092a | 28850 |
| `wakeup_start` | int | 0x7f14092b | 28853 |
| `wakeup_success` | int | 0x7f14092c | 28856 |
| `warning` | int | 0x7f14092d | 28859 |
| `wb_auto` | int | 0x7f14092e | 28862 |
| `wb_cloudy` | int | 0x7f14092f | 28865 |
| `wb_daylight` | int | 0x7f140930 | 28868 |
| `wb_fluorescent` | int | 0x7f140931 | 28871 |
| `wb_incandescent` | int | 0x7f140932 | 28874 |
| `wc_public` | int | 0x7f140933 | 28877 |
| `wechat_public` | int | 0x7f140934 | 28880 |
| `wed` | int | 0x7f140935 | 28883 |
| `weibo` | int | 0x7f140936 | 28886 |
| `weixin` | int | 0x7f140937 | 28889 |
| `weixin_short_video` | int | 0x7f140938 | 28892 |
| `welcome_agree_pr_tip` | int | 0x7f140939 | 28895 |
| `welcome_camera_xtu` | int | 0x7f14093a | 28898 |
| `welcome_pr_tip` | int | 0x7f14093b | 28901 |
| `wifi_connect_failed` | int | 0x7f14093c | 28904 |
| `wifi_connect_failed_retry` | int | 0x7f14093d | 28907 |
| `wifi_connect_ip` | int | 0x7f14093e | 28910 |
| `wifi_connect_mac` | int | 0x7f14093f | 28913 |
| `wifi_connect_not_camera` | int | 0x7f140940 | 28916 |
| `wifi_connect_singnal` | int | 0x7f140941 | 28919 |
| `wifi_connect_singnal_level1` | int | 0x7f140942 | 28922 |
| `wifi_connect_singnal_level2` | int | 0x7f140943 | 28925 |
| `wifi_connect_singnal_level3` | int | 0x7f140944 | 28928 |
| `wifi_connect_singnal_level4` | int | 0x7f140945 | 28931 |
| `wifi_connect_singnal_level5` | int | 0x7f140946 | 28934 |
| `wifi_connect_speed` | int | 0x7f140947 | 28937 |
| `wifi_connect_state` | int | 0x7f140948 | 28940 |
| `wifi_disconnected` | int | 0x7f140949 | 28943 |
| `wifi_hotspot_open_failed_info` | int | 0x7f14094a | 28946 |
| `wifi_info` | int | 0x7f14094b | 28949 |
| `wifi_lock` | int | 0x7f14094c | 28952 |
| `wifi_name` | int | 0x7f14094d | 28955 |
| `wifi_not_online` | int | 0x7f14094e | 28958 |
| `wifi_or_password_cannot_be_empty` | int | 0x7f14094f | 28961 |
| `wifi_passwd` | int | 0x7f140950 | 28964 |
| `wifi_password_valid_char` | int | 0x7f140951 | 28967 |
| `wifi_psd_tips_1` | int | 0x7f140952 | 28970 |
| `wifi_psd_tips_2` | int | 0x7f140953 | 28973 |
| `wifi_psd_tips_2_strict` | int | 0x7f140954 | 28976 |
| `wifi_scan_fail` | int | 0x7f140955 | 28979 |
| `wifi_scan_location_ask` | int | 0x7f140956 | 28982 |
| `wifi_singnal` | int | 0x7f140957 | 28985 |
| `wifi_ssid_tips_1` | int | 0x7f140958 | 28988 |
| `wifi_ssid_tips_2` | int | 0x7f140959 | 28991 |
| `wifi_toast` | int | 0x7f14095a | 28994 |
| `without_permission_no_work` | int | 0x7f14095b | 28997 |
| `xtu_max2` | int | 0x7f14095c | 29000 |
| `xtu_max3` | int | 0x7f14095d | 29003 |
| `xtu_maxpro` | int | 0x7f14095e | 29006 |
| `xtu_mini1` | int | 0x7f14095f | 29009 |
| `xtu_mini2pro` | int | 0x7f140960 | 29012 |
| `xtu_plus` | int | 0x7f140961 | 29015 |
| `xtu_r1` | int | 0x7f140962 | 29018 |
| `xtu_s2` | int | 0x7f140963 | 29021 |
| `xtu_s3pro` | int | 0x7f140964 | 29024 |
| `xtu_s5k` | int | 0x7f140965 | 29027 |
| `xtu_s6` | int | 0x7f140966 | 29030 |
| `xtu_s6pro` | int | 0x7f140967 | 29033 |
| `xtu_s7` | int | 0x7f140968 | 29036 |
| `xtu_s7pro` | int | 0x7f140969 | 29039 |
| `xtu_s7promax` | int | 0x7f14096a | 29042 |
| `xtu_x1` | int | 0x7f14096b | 29045 |
| `xtu_x2` | int | 0x7f14096c | 29048 |
| `xtu_x3` | int | 0x7f14096d | 29051 |
| `xtugo_extract_music` | int | 0x7f14096e | 29054 |
| `xtugo_local_album_favorites_nofile` | int | 0x7f14096f | 29057 |
| `xtugo_local_album_hd_nofile` | int | 0x7f140970 | 29060 |
| `xtugo_local_album_photo_nofile` | int | 0x7f140971 | 29063 |
| `xtugo_local_album_sd_nofile` | int | 0x7f140972 | 29066 |
| `xtugo_local_music` | int | 0x7f140973 | 29069 |
| `xtugo_nofile_hint` | int | 0x7f140974 | 29072 |
| `xtugo_remote_album_photo_nofile` | int | 0x7f140975 | 29075 |
| `xtugo_remote_album_video_nofile` | int | 0x7f140976 | 29078 |
| `xtugo_use` | int | 0x7f140977 | 29081 |
| `xuto_official_account` | int | 0x7f140978 | 29084 |
| `year` | int | 0x7f140979 | 29087 |
| `yes` | int | 0x7f14097a | 29090 |
| `yihouzaishuo` | int | 0x7f14097b | 29093 |
| `yikaitong` | int | 0x7f14097c | 29096 |
| `yishi_zuixin_banben` | int | 0x7f14097d | 29099 |
| `youtube` | int | 0x7f14097e | 29102 |
| `yu` | int | 0x7f14097f | 29105 |
| `yue` | int | 0x7f140980 | 29108 |

### `com.gku.xtugo.R$style`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AlertDialog_AppCompat` | int | 0x7f150000 | 29180 |
| `AlertDialog_AppCompat_Light` | int | 0x7f150001 | 29183 |
| `AlphaAnimation` | int | 0x7f150002 | 29186 |
| `amu_Bubble_TextAppearance_Dark` | int | 0x7f1504d3 | 32804 |
| `amu_Bubble_TextAppearance_Light` | int | 0x7f1504d4 | 32807 |
| `amu_ClusterIcon_TextAppearance` | int | 0x7f1504d5 | 32810 |
| `Animation_AppCompat_Dialog` | int | 0x7f150003 | 29189 |
| `Animation_AppCompat_DropDownUp` | int | 0x7f150004 | 29192 |
| `Animation_AppCompat_Tooltip` | int | 0x7f150005 | 29195 |
| `Animation_Design_BottomSheetDialog` | int | 0x7f150006 | 29198 |
| `Animation_Material3_BottomSheetDialog` | int | 0x7f150007 | 29201 |
| `Animation_Material3_SideSheetDialog` | int | 0x7f150008 | 29204 |
| `Animation_Material3_SideSheetDialog_Left` | int | 0x7f150009 | 29207 |
| `Animation_Material3_SideSheetDialog_Right` | int | 0x7f15000a | 29210 |
| `Animation_MaterialComponents_BottomSheetDialog` | int | 0x7f15000b | 29213 |
| `AppTheme2` | int | 0x7f15000e | 29216 |
| `AppToolbar` | int | 0x7f15000f | 29219 |
| `Base_AlertDialog_AppCompat` | int | 0x7f150010 | 29222 |
| `Base_AlertDialog_AppCompat_Light` | int | 0x7f150011 | 29225 |
| `Base_Animation_AppCompat_Dialog` | int | 0x7f150012 | 29228 |
| `Base_Animation_AppCompat_DropDownUp` | int | 0x7f150013 | 29231 |
| `Base_Animation_AppCompat_Tooltip` | int | 0x7f150014 | 29234 |
| `Base_CardView` | int | 0x7f150015 | 29237 |
| `Base_DialogWindowTitle_AppCompat` | int | 0x7f150016 | 29240 |
| `Base_DialogWindowTitleBackground_AppCompat` | int | 0x7f150017 | 29243 |
| `Base_MaterialAlertDialog_MaterialComponents_Title_Icon` | int | 0x7f150018 | 29246 |
| `Base_MaterialAlertDialog_MaterialComponents_Title_Panel` | int | 0x7f150019 | 29249 |
| `Base_MaterialAlertDialog_MaterialComponents_Title_Text` | int | 0x7f15001a | 29252 |
| `Base_TextAppearance_AppCompat` | int | 0x7f15001b | 29255 |
| `Base_TextAppearance_AppCompat_Body1` | int | 0x7f15001c | 29258 |
| `Base_TextAppearance_AppCompat_Body2` | int | 0x7f15001d | 29261 |
| `Base_TextAppearance_AppCompat_Button` | int | 0x7f15001e | 29264 |
| `Base_TextAppearance_AppCompat_Caption` | int | 0x7f15001f | 29267 |
| `Base_TextAppearance_AppCompat_Display1` | int | 0x7f150020 | 29270 |
| `Base_TextAppearance_AppCompat_Display2` | int | 0x7f150021 | 29273 |
| `Base_TextAppearance_AppCompat_Display3` | int | 0x7f150022 | 29276 |
| `Base_TextAppearance_AppCompat_Display4` | int | 0x7f150023 | 29279 |
| `Base_TextAppearance_AppCompat_Headline` | int | 0x7f150024 | 29282 |
| `Base_TextAppearance_AppCompat_Inverse` | int | 0x7f150025 | 29285 |
| `Base_TextAppearance_AppCompat_Large` | int | 0x7f150026 | 29288 |
| `Base_TextAppearance_AppCompat_Large_Inverse` | int | 0x7f150027 | 29291 |
| `Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Large` | int | 0x7f150028 | 29294 |
| `Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Small` | int | 0x7f150029 | 29297 |
| `Base_TextAppearance_AppCompat_Medium` | int | 0x7f15002a | 29300 |
| `Base_TextAppearance_AppCompat_Medium_Inverse` | int | 0x7f15002b | 29303 |
| `Base_TextAppearance_AppCompat_Menu` | int | 0x7f15002c | 29306 |
| `Base_TextAppearance_AppCompat_SearchResult` | int | 0x7f15002d | 29309 |
| `Base_TextAppearance_AppCompat_SearchResult_Subtitle` | int | 0x7f15002e | 29312 |
| `Base_TextAppearance_AppCompat_SearchResult_Title` | int | 0x7f15002f | 29315 |
| `Base_TextAppearance_AppCompat_Small` | int | 0x7f150030 | 29318 |
| `Base_TextAppearance_AppCompat_Small_Inverse` | int | 0x7f150031 | 29321 |
| `Base_TextAppearance_AppCompat_Subhead` | int | 0x7f150032 | 29324 |
| `Base_TextAppearance_AppCompat_Subhead_Inverse` | int | 0x7f150033 | 29327 |
| `Base_TextAppearance_AppCompat_Title` | int | 0x7f150034 | 29330 |
| `Base_TextAppearance_AppCompat_Title_Inverse` | int | 0x7f150035 | 29333 |
| `Base_TextAppearance_AppCompat_Tooltip` | int | 0x7f150036 | 29336 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Menu` | int | 0x7f150037 | 29339 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle` | int | 0x7f150038 | 29342 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse` | int | 0x7f150039 | 29345 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Title` | int | 0x7f15003a | 29348 |
| `Base_TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse` | int | 0x7f15003b | 29351 |
| `Base_TextAppearance_AppCompat_Widget_ActionMode_Subtitle` | int | 0x7f15003c | 29354 |
| `Base_TextAppearance_AppCompat_Widget_ActionMode_Title` | int | 0x7f15003d | 29357 |
| `Base_TextAppearance_AppCompat_Widget_Button` | int | 0x7f15003e | 29360 |
| `Base_TextAppearance_AppCompat_Widget_Button_Borderless_Colored` | int | 0x7f15003f | 29363 |
| `Base_TextAppearance_AppCompat_Widget_Button_Colored` | int | 0x7f150040 | 29366 |
| `Base_TextAppearance_AppCompat_Widget_Button_Inverse` | int | 0x7f150041 | 29369 |
| `Base_TextAppearance_AppCompat_Widget_DropDownItem` | int | 0x7f150042 | 29372 |
| `Base_TextAppearance_AppCompat_Widget_PopupMenu_Header` | int | 0x7f150043 | 29375 |
| `Base_TextAppearance_AppCompat_Widget_PopupMenu_Large` | int | 0x7f150044 | 29378 |
| `Base_TextAppearance_AppCompat_Widget_PopupMenu_Small` | int | 0x7f150045 | 29381 |
| `Base_TextAppearance_AppCompat_Widget_Switch` | int | 0x7f150046 | 29384 |
| `Base_TextAppearance_AppCompat_Widget_TextView_SpinnerItem` | int | 0x7f150047 | 29387 |
| `Base_TextAppearance_Material3_Search` | int | 0x7f150048 | 29390 |
| `Base_TextAppearance_MaterialComponents_Badge` | int | 0x7f150049 | 29393 |
| `Base_TextAppearance_MaterialComponents_Button` | int | 0x7f15004a | 29396 |
| `Base_TextAppearance_MaterialComponents_Headline6` | int | 0x7f15004b | 29399 |
| `Base_TextAppearance_MaterialComponents_Subtitle2` | int | 0x7f15004c | 29402 |
| `Base_TextAppearance_Widget_AppCompat_ExpandedMenu_Item` | int | 0x7f15004d | 29405 |
| `Base_TextAppearance_Widget_AppCompat_Toolbar_Subtitle` | int | 0x7f15004e | 29408 |
| `Base_TextAppearance_Widget_AppCompat_Toolbar_Title` | int | 0x7f15004f | 29411 |
| `Base_Theme_AppCompat` | int | 0x7f150050 | 29414 |
| `Base_Theme_AppCompat_CompactMenu` | int | 0x7f150051 | 29417 |
| `Base_Theme_AppCompat_Dialog` | int | 0x7f150052 | 29420 |
| `Base_Theme_AppCompat_Dialog_Alert` | int | 0x7f150053 | 29423 |
| `Base_Theme_AppCompat_Dialog_FixedSize` | int | 0x7f150054 | 29426 |
| `Base_Theme_AppCompat_Dialog_MinWidth` | int | 0x7f150055 | 29429 |
| `Base_Theme_AppCompat_DialogWhenLarge` | int | 0x7f150056 | 29432 |
| `Base_Theme_AppCompat_Light` | int | 0x7f150057 | 29435 |
| `Base_Theme_AppCompat_Light_DarkActionBar` | int | 0x7f150058 | 29438 |
| `Base_Theme_AppCompat_Light_Dialog` | int | 0x7f150059 | 29441 |
| `Base_Theme_AppCompat_Light_Dialog_Alert` | int | 0x7f15005a | 29444 |
| `Base_Theme_AppCompat_Light_Dialog_FixedSize` | int | 0x7f15005b | 29447 |
| `Base_Theme_AppCompat_Light_Dialog_MinWidth` | int | 0x7f15005c | 29450 |
| `Base_Theme_AppCompat_Light_DialogWhenLarge` | int | 0x7f15005d | 29453 |
| `Base_Theme_Material3_Dark` | int | 0x7f15005e | 29456 |
| `Base_Theme_Material3_Dark_BottomSheetDialog` | int | 0x7f15005f | 29459 |
| `Base_Theme_Material3_Dark_Dialog` | int | 0x7f150060 | 29462 |
| `Base_Theme_Material3_Dark_Dialog_FixedSize` | int | 0x7f150061 | 29465 |
| `Base_Theme_Material3_Dark_DialogWhenLarge` | int | 0x7f150062 | 29468 |
| `Base_Theme_Material3_Dark_SideSheetDialog` | int | 0x7f150063 | 29471 |
| `Base_Theme_Material3_Light` | int | 0x7f150064 | 29474 |
| `Base_Theme_Material3_Light_BottomSheetDialog` | int | 0x7f150065 | 29477 |
| `Base_Theme_Material3_Light_Dialog` | int | 0x7f150066 | 29480 |
| `Base_Theme_Material3_Light_Dialog_FixedSize` | int | 0x7f150067 | 29483 |
| `Base_Theme_Material3_Light_DialogWhenLarge` | int | 0x7f150068 | 29486 |
| `Base_Theme_Material3_Light_SideSheetDialog` | int | 0x7f150069 | 29489 |
| `Base_Theme_MaterialComponents` | int | 0x7f15006a | 29492 |
| `Base_Theme_MaterialComponents_Bridge` | int | 0x7f15006b | 29495 |
| `Base_Theme_MaterialComponents_CompactMenu` | int | 0x7f15006c | 29498 |
| `Base_Theme_MaterialComponents_Dialog` | int | 0x7f15006d | 29501 |
| `Base_Theme_MaterialComponents_Dialog_Alert` | int | 0x7f15006e | 29504 |
| `Base_Theme_MaterialComponents_Dialog_Bridge` | int | 0x7f15006f | 29507 |
| `Base_Theme_MaterialComponents_Dialog_FixedSize` | int | 0x7f150070 | 29510 |
| `Base_Theme_MaterialComponents_Dialog_MinWidth` | int | 0x7f150071 | 29513 |
| `Base_Theme_MaterialComponents_DialogWhenLarge` | int | 0x7f150072 | 29516 |
| `Base_Theme_MaterialComponents_Light` | int | 0x7f150073 | 29519 |
| `Base_Theme_MaterialComponents_Light_Bridge` | int | 0x7f150074 | 29522 |
| `Base_Theme_MaterialComponents_Light_DarkActionBar` | int | 0x7f150075 | 29525 |
| `Base_Theme_MaterialComponents_Light_DarkActionBar_Bridge` | int | 0x7f150076 | 29528 |
| `Base_Theme_MaterialComponents_Light_Dialog` | int | 0x7f150077 | 29531 |
| `Base_Theme_MaterialComponents_Light_Dialog_Alert` | int | 0x7f150078 | 29534 |
| `Base_Theme_MaterialComponents_Light_Dialog_Bridge` | int | 0x7f150079 | 29537 |
| `Base_Theme_MaterialComponents_Light_Dialog_FixedSize` | int | 0x7f15007a | 29540 |
| `Base_Theme_MaterialComponents_Light_Dialog_MinWidth` | int | 0x7f15007b | 29543 |
| `Base_Theme_MaterialComponents_Light_DialogWhenLarge` | int | 0x7f15007c | 29546 |
| `Base_Theme_NoActionBar` | int | 0x7f15007d | 29549 |
| `Base_Theme_SplashScreen` | int | 0x7f15007e | 29552 |
| `Base_Theme_SplashScreen_DayNight` | int | 0x7f15007f | 29555 |
| `Base_Theme_SplashScreen_Light` | int | 0x7f150080 | 29558 |
| `Base_ThemeOverlay_AppCompat` | int | 0x7f150081 | 29561 |
| `Base_ThemeOverlay_AppCompat_ActionBar` | int | 0x7f150082 | 29564 |
| `Base_ThemeOverlay_AppCompat_Dark` | int | 0x7f150083 | 29567 |
| `Base_ThemeOverlay_AppCompat_Dark_ActionBar` | int | 0x7f150084 | 29570 |
| `Base_ThemeOverlay_AppCompat_Dialog` | int | 0x7f150085 | 29573 |
| `Base_ThemeOverlay_AppCompat_Dialog_Alert` | int | 0x7f150086 | 29576 |
| `Base_ThemeOverlay_AppCompat_Light` | int | 0x7f150087 | 29579 |
| `Base_ThemeOverlay_Material3_AutoCompleteTextView` | int | 0x7f150088 | 29582 |
| `Base_ThemeOverlay_Material3_BottomSheetDialog` | int | 0x7f150089 | 29585 |
| `Base_ThemeOverlay_Material3_Dialog` | int | 0x7f15008a | 29588 |
| `Base_ThemeOverlay_Material3_SideSheetDialog` | int | 0x7f15008b | 29591 |
| `Base_ThemeOverlay_Material3_TextInputEditText` | int | 0x7f15008c | 29594 |
| `Base_ThemeOverlay_MaterialComponents_Dialog` | int | 0x7f15008d | 29597 |
| `Base_ThemeOverlay_MaterialComponents_Dialog_Alert` | int | 0x7f15008e | 29600 |
| `Base_ThemeOverlay_MaterialComponents_Dialog_Alert_Framework` | int | 0x7f15008f | 29603 |
| `Base_ThemeOverlay_MaterialComponents_Light_Dialog_Alert_Framework` | int | 0x7f150090 | 29606 |
| `Base_ThemeOverlay_MaterialComponents_MaterialAlertDialog` | int | 0x7f150091 | 29609 |
| `Base_V14_Theme_Material3_Dark` | int | 0x7f150092 | 29612 |
| `Base_V14_Theme_Material3_Dark_BottomSheetDialog` | int | 0x7f150093 | 29615 |
| `Base_V14_Theme_Material3_Dark_Dialog` | int | 0x7f150094 | 29618 |
| `Base_V14_Theme_Material3_Dark_SideSheetDialog` | int | 0x7f150095 | 29621 |
| `Base_V14_Theme_Material3_Light` | int | 0x7f150096 | 29624 |
| `Base_V14_Theme_Material3_Light_BottomSheetDialog` | int | 0x7f150097 | 29627 |
| `Base_V14_Theme_Material3_Light_Dialog` | int | 0x7f150098 | 29630 |
| `Base_V14_Theme_Material3_Light_SideSheetDialog` | int | 0x7f150099 | 29633 |
| `Base_V14_Theme_MaterialComponents` | int | 0x7f15009a | 29636 |
| `Base_V14_Theme_MaterialComponents_Bridge` | int | 0x7f15009b | 29639 |
| `Base_V14_Theme_MaterialComponents_Dialog` | int | 0x7f15009c | 29642 |
| `Base_V14_Theme_MaterialComponents_Dialog_Bridge` | int | 0x7f15009d | 29645 |
| `Base_V14_Theme_MaterialComponents_Light` | int | 0x7f15009e | 29648 |
| `Base_V14_Theme_MaterialComponents_Light_Bridge` | int | 0x7f15009f | 29651 |
| `Base_V14_Theme_MaterialComponents_Light_DarkActionBar_Bridge` | int | 0x7f1500a0 | 29654 |
| `Base_V14_Theme_MaterialComponents_Light_Dialog` | int | 0x7f1500a1 | 29657 |
| `Base_V14_Theme_MaterialComponents_Light_Dialog_Bridge` | int | 0x7f1500a2 | 29660 |
| `Base_V14_ThemeOverlay_Material3_BottomSheetDialog` | int | 0x7f1500a3 | 29663 |
| `Base_V14_ThemeOverlay_Material3_SideSheetDialog` | int | 0x7f1500a4 | 29666 |
| `Base_V14_ThemeOverlay_MaterialComponents_BottomSheetDialog` | int | 0x7f1500a5 | 29669 |
| `Base_V14_ThemeOverlay_MaterialComponents_Dialog` | int | 0x7f1500a6 | 29672 |
| `Base_V14_ThemeOverlay_MaterialComponents_Dialog_Alert` | int | 0x7f1500a7 | 29675 |
| `Base_V14_ThemeOverlay_MaterialComponents_MaterialAlertDialog` | int | 0x7f1500a8 | 29678 |
| `Base_V14_Widget_MaterialComponents_AutoCompleteTextView` | int | 0x7f1500a9 | 29681 |
| `Base_V21_Theme_AppCompat` | int | 0x7f1500aa | 29684 |
| `Base_V21_Theme_AppCompat_Dialog` | int | 0x7f1500ab | 29687 |
| `Base_V21_Theme_AppCompat_Light` | int | 0x7f1500ac | 29690 |
| `Base_V21_Theme_AppCompat_Light_Dialog` | int | 0x7f1500ad | 29693 |
| `Base_V21_Theme_MaterialComponents` | int | 0x7f1500ae | 29696 |
| `Base_V21_Theme_MaterialComponents_Dialog` | int | 0x7f1500af | 29699 |
| `Base_V21_Theme_MaterialComponents_Light` | int | 0x7f1500b0 | 29702 |
| `Base_V21_Theme_MaterialComponents_Light_Dialog` | int | 0x7f1500b1 | 29705 |
| `Base_v21_Theme_SplashScreen` | int | 0x7f150128 | 30062 |
| `Base_v21_Theme_SplashScreen_Light` | int | 0x7f150129 | 30065 |
| `Base_V21_ThemeOverlay_AppCompat_Dialog` | int | 0x7f1500b2 | 29708 |
| `Base_V21_ThemeOverlay_Material3_BottomSheetDialog` | int | 0x7f1500b3 | 29711 |
| `Base_V21_ThemeOverlay_Material3_SideSheetDialog` | int | 0x7f1500b4 | 29714 |
| `Base_V21_ThemeOverlay_MaterialComponents_BottomSheetDialog` | int | 0x7f1500b5 | 29717 |
| `Base_V22_Theme_AppCompat` | int | 0x7f1500b6 | 29720 |
| `Base_V22_Theme_AppCompat_Light` | int | 0x7f1500b7 | 29723 |
| `Base_V23_Theme_AppCompat` | int | 0x7f1500b8 | 29726 |
| `Base_V23_Theme_AppCompat_Light` | int | 0x7f1500b9 | 29729 |
| `Base_V24_Theme_Material3_Dark` | int | 0x7f1500ba | 29732 |
| `Base_V24_Theme_Material3_Dark_Dialog` | int | 0x7f1500bb | 29735 |
| `Base_V24_Theme_Material3_Light` | int | 0x7f1500bc | 29738 |
| `Base_V24_Theme_Material3_Light_Dialog` | int | 0x7f1500bd | 29741 |
| `Base_V26_Theme_AppCompat` | int | 0x7f1500be | 29744 |
| `Base_V26_Theme_AppCompat_Light` | int | 0x7f1500bf | 29747 |
| `Base_V26_Widget_AppCompat_Toolbar` | int | 0x7f1500c0 | 29750 |
| `Base_v27_Theme_SplashScreen` | int | 0x7f15012a | 30068 |
| `Base_v27_Theme_SplashScreen_Light` | int | 0x7f15012b | 30071 |
| `Base_V28_Theme_AppCompat` | int | 0x7f1500c1 | 29753 |
| `Base_V28_Theme_AppCompat_Light` | int | 0x7f1500c2 | 29756 |
| `Base_V7_Theme_AppCompat` | int | 0x7f1500c3 | 29759 |
| `Base_V7_Theme_AppCompat_Dialog` | int | 0x7f1500c4 | 29762 |
| `Base_V7_Theme_AppCompat_Light` | int | 0x7f1500c5 | 29765 |
| `Base_V7_Theme_AppCompat_Light_Dialog` | int | 0x7f1500c6 | 29768 |
| `Base_V7_ThemeOverlay_AppCompat_Dialog` | int | 0x7f1500c7 | 29771 |
| `Base_V7_Widget_AppCompat_AutoCompleteTextView` | int | 0x7f1500c8 | 29774 |
| `Base_V7_Widget_AppCompat_EditText` | int | 0x7f1500c9 | 29777 |
| `Base_V7_Widget_AppCompat_Toolbar` | int | 0x7f1500ca | 29780 |
| `Base_Widget_AppCompat_ActionBar` | int | 0x7f1500cb | 29783 |
| `Base_Widget_AppCompat_ActionBar_Solid` | int | 0x7f1500cc | 29786 |
| `Base_Widget_AppCompat_ActionBar_TabBar` | int | 0x7f1500cd | 29789 |
| `Base_Widget_AppCompat_ActionBar_TabText` | int | 0x7f1500ce | 29792 |
| `Base_Widget_AppCompat_ActionBar_TabView` | int | 0x7f1500cf | 29795 |
| `Base_Widget_AppCompat_ActionButton` | int | 0x7f1500d0 | 29798 |
| `Base_Widget_AppCompat_ActionButton_CloseMode` | int | 0x7f1500d1 | 29801 |
| `Base_Widget_AppCompat_ActionButton_Overflow` | int | 0x7f1500d2 | 29804 |
| `Base_Widget_AppCompat_ActionMode` | int | 0x7f1500d3 | 29807 |
| `Base_Widget_AppCompat_ActivityChooserView` | int | 0x7f1500d4 | 29810 |
| `Base_Widget_AppCompat_AutoCompleteTextView` | int | 0x7f1500d5 | 29813 |
| `Base_Widget_AppCompat_Button` | int | 0x7f1500d6 | 29816 |
| `Base_Widget_AppCompat_Button_Borderless` | int | 0x7f1500d7 | 29819 |
| `Base_Widget_AppCompat_Button_Borderless_Colored` | int | 0x7f1500d8 | 29822 |
| `Base_Widget_AppCompat_Button_ButtonBar_AlertDialog` | int | 0x7f1500d9 | 29825 |
| `Base_Widget_AppCompat_Button_Colored` | int | 0x7f1500da | 29828 |
| `Base_Widget_AppCompat_Button_Small` | int | 0x7f1500db | 29831 |
| `Base_Widget_AppCompat_ButtonBar` | int | 0x7f1500dc | 29834 |
| `Base_Widget_AppCompat_ButtonBar_AlertDialog` | int | 0x7f1500dd | 29837 |
| `Base_Widget_AppCompat_CompoundButton_CheckBox` | int | 0x7f1500de | 29840 |
| `Base_Widget_AppCompat_CompoundButton_RadioButton` | int | 0x7f1500df | 29843 |
| `Base_Widget_AppCompat_CompoundButton_Switch` | int | 0x7f1500e0 | 29846 |
| `Base_Widget_AppCompat_DrawerArrowToggle` | int | 0x7f1500e1 | 29849 |
| `Base_Widget_AppCompat_DrawerArrowToggle_Common` | int | 0x7f1500e2 | 29852 |
| `Base_Widget_AppCompat_DropDownItem_Spinner` | int | 0x7f1500e3 | 29855 |
| `Base_Widget_AppCompat_EditText` | int | 0x7f1500e4 | 29858 |
| `Base_Widget_AppCompat_ImageButton` | int | 0x7f1500e5 | 29861 |
| `Base_Widget_AppCompat_Light_ActionBar` | int | 0x7f1500e6 | 29864 |
| `Base_Widget_AppCompat_Light_ActionBar_Solid` | int | 0x7f1500e7 | 29867 |
| `Base_Widget_AppCompat_Light_ActionBar_TabBar` | int | 0x7f1500e8 | 29870 |
| `Base_Widget_AppCompat_Light_ActionBar_TabText` | int | 0x7f1500e9 | 29873 |
| `Base_Widget_AppCompat_Light_ActionBar_TabText_Inverse` | int | 0x7f1500ea | 29876 |
| `Base_Widget_AppCompat_Light_ActionBar_TabView` | int | 0x7f1500eb | 29879 |
| `Base_Widget_AppCompat_Light_PopupMenu` | int | 0x7f1500ec | 29882 |
| `Base_Widget_AppCompat_Light_PopupMenu_Overflow` | int | 0x7f1500ed | 29885 |
| `Base_Widget_AppCompat_ListMenuView` | int | 0x7f1500ee | 29888 |
| `Base_Widget_AppCompat_ListPopupWindow` | int | 0x7f1500ef | 29891 |
| `Base_Widget_AppCompat_ListView` | int | 0x7f1500f0 | 29894 |
| `Base_Widget_AppCompat_ListView_DropDown` | int | 0x7f1500f1 | 29897 |
| `Base_Widget_AppCompat_ListView_Menu` | int | 0x7f1500f2 | 29900 |
| `Base_Widget_AppCompat_PopupMenu` | int | 0x7f1500f3 | 29903 |
| `Base_Widget_AppCompat_PopupMenu_Overflow` | int | 0x7f1500f4 | 29906 |
| `Base_Widget_AppCompat_PopupWindow` | int | 0x7f1500f5 | 29909 |
| `Base_Widget_AppCompat_ProgressBar` | int | 0x7f1500f6 | 29912 |
| `Base_Widget_AppCompat_ProgressBar_Horizontal` | int | 0x7f1500f7 | 29915 |
| `Base_Widget_AppCompat_RatingBar` | int | 0x7f1500f8 | 29918 |
| `Base_Widget_AppCompat_RatingBar_Indicator` | int | 0x7f1500f9 | 29921 |
| `Base_Widget_AppCompat_RatingBar_Small` | int | 0x7f1500fa | 29924 |
| `Base_Widget_AppCompat_SearchView` | int | 0x7f1500fb | 29927 |
| `Base_Widget_AppCompat_SearchView_ActionBar` | int | 0x7f1500fc | 29930 |
| `Base_Widget_AppCompat_SeekBar` | int | 0x7f1500fd | 29933 |
| `Base_Widget_AppCompat_SeekBar_Discrete` | int | 0x7f1500fe | 29936 |
| `Base_Widget_AppCompat_Spinner` | int | 0x7f1500ff | 29939 |
| `Base_Widget_AppCompat_Spinner_Underlined` | int | 0x7f150100 | 29942 |
| `Base_Widget_AppCompat_TextView` | int | 0x7f150101 | 29945 |
| `Base_Widget_AppCompat_TextView_SpinnerItem` | int | 0x7f150102 | 29948 |
| `Base_Widget_AppCompat_Toolbar` | int | 0x7f150103 | 29951 |
| `Base_Widget_AppCompat_Toolbar_Button_Navigation` | int | 0x7f150104 | 29954 |
| `Base_Widget_Design_TabLayout` | int | 0x7f150105 | 29957 |
| `Base_Widget_Material3_ActionBar_Solid` | int | 0x7f150106 | 29960 |
| `Base_Widget_Material3_ActionMode` | int | 0x7f150107 | 29963 |
| `Base_Widget_Material3_BottomNavigationView` | int | 0x7f150108 | 29966 |
| `Base_Widget_Material3_CardView` | int | 0x7f150109 | 29969 |
| `Base_Widget_Material3_Chip` | int | 0x7f15010a | 29972 |
| `Base_Widget_Material3_CollapsingToolbar` | int | 0x7f15010b | 29975 |
| `Base_Widget_Material3_CompoundButton_CheckBox` | int | 0x7f15010c | 29978 |
| `Base_Widget_Material3_CompoundButton_RadioButton` | int | 0x7f15010d | 29981 |
| `Base_Widget_Material3_CompoundButton_Switch` | int | 0x7f15010e | 29984 |
| `Base_Widget_Material3_ExtendedFloatingActionButton` | int | 0x7f15010f | 29987 |
| `Base_Widget_Material3_ExtendedFloatingActionButton_Icon` | int | 0x7f150110 | 29990 |
| `Base_Widget_Material3_FloatingActionButton` | int | 0x7f150111 | 29993 |
| `Base_Widget_Material3_FloatingActionButton_Large` | int | 0x7f150112 | 29996 |
| `Base_Widget_Material3_FloatingActionButton_Small` | int | 0x7f150113 | 29999 |
| `Base_Widget_Material3_Light_ActionBar_Solid` | int | 0x7f150114 | 30002 |
| `Base_Widget_Material3_MaterialCalendar_NavigationButton` | int | 0x7f150115 | 30005 |
| `Base_Widget_Material3_Snackbar` | int | 0x7f150116 | 30008 |
| `Base_Widget_Material3_TabLayout` | int | 0x7f150117 | 30011 |
| `Base_Widget_Material3_TabLayout_OnSurface` | int | 0x7f150118 | 30014 |
| `Base_Widget_Material3_TabLayout_Secondary` | int | 0x7f150119 | 30017 |
| `Base_Widget_MaterialComponents_AutoCompleteTextView` | int | 0x7f15011a | 30020 |
| `Base_Widget_MaterialComponents_CheckedTextView` | int | 0x7f15011b | 30023 |
| `Base_Widget_MaterialComponents_Chip` | int | 0x7f15011c | 30026 |
| `Base_Widget_MaterialComponents_MaterialCalendar_HeaderToggleButton` | int | 0x7f15011d | 30029 |
| `Base_Widget_MaterialComponents_MaterialCalendar_NavigationButton` | int | 0x7f15011e | 30032 |
| `Base_Widget_MaterialComponents_PopupMenu` | int | 0x7f15011f | 30035 |
| `Base_Widget_MaterialComponents_PopupMenu_ContextMenu` | int | 0x7f150120 | 30038 |
| `Base_Widget_MaterialComponents_PopupMenu_ListPopupWindow` | int | 0x7f150121 | 30041 |
| `Base_Widget_MaterialComponents_PopupMenu_Overflow` | int | 0x7f150122 | 30044 |
| `Base_Widget_MaterialComponents_Slider` | int | 0x7f150123 | 30047 |
| `Base_Widget_MaterialComponents_Snackbar` | int | 0x7f150124 | 30050 |
| `Base_Widget_MaterialComponents_TextInputEditText` | int | 0x7f150125 | 30053 |
| `Base_Widget_MaterialComponents_TextInputLayout` | int | 0x7f150126 | 30056 |
| `Base_Widget_MaterialComponents_TextView` | int | 0x7f150127 | 30059 |
| `bottom_sheet_anime` | int | 0x7f1504d7 | 32813 |
| `BottomAnimation` | int | 0x7f15012c | 30074 |
| `BottomFullDialogStyle` | int | 0x7f15012d | 30077 |
| `BottomSheetDialogStyle` | int | 0x7f15012f | 30080 |
| `Bullet_Bottom_Dialog_Animation` | int | 0x7f150130 | 30083 |
| `CameraScanTheme` | int | 0x7f150131 | 30086 |
| `CardView` | int | 0x7f150132 | 30089 |
| `CardView_Dark` | int | 0x7f150133 | 30092 |
| `CardView_Light` | int | 0x7f150134 | 30095 |
| `commerce_dialog_dim_non_enter_animation` | int | 0x7f1504d8 | 32816 |
| `custom_dialog2` | int | 0x7f1504da | 32822 |
| `customDialogStyle` | int | 0x7f1504d9 | 32819 |
| `dialog_anim_bottom` | int | 0x7f1504df | 32825 |
| `dialog_anim_left` | int | 0x7f1504e0 | 32828 |
| `dialog_anim_right` | int | 0x7f1504e1 | 32831 |
| `dialog_anim_top` | int | 0x7f1504e2 | 32834 |
| `Dialog_BottomSheet_Transparent` | int | 0x7f150139 | 30098 |
| `dialog_zoom` | int | 0x7f1504f1 | 32837 |
| `ec_plugin_progress_dialog` | int | 0x7f1504f2 | 32840 |
| `ec_sku_prerender_dialog_anim` | int | 0x7f1504f3 | 32843 |
| `EC_Widget_Design_BottomSheet_Modal` | int | 0x7f15013a | 30101 |
| `ECBaseDialogFragmentAnimation` | int | 0x7f15013b | 30104 |
| `ECBottomInWindowAnimation` | int | 0x7f15013c | 30107 |
| `ECBottomOutWindowAnimation` | int | 0x7f15013d | 30110 |
| `ECHalfScreenAnchorV4Anime` | int | 0x7f15013e | 30113 |
| `ECSlideInWindowAnimation` | int | 0x7f15013f | 30116 |
| `ECSlideOutWindowAnimation` | int | 0x7f150140 | 30119 |
| `ExoMediaButton` | int | 0x7f150141 | 30122 |
| `ExoMediaButton_FastForward` | int | 0x7f150142 | 30125 |
| `ExoMediaButton_Next` | int | 0x7f150143 | 30128 |
| `ExoMediaButton_Pause` | int | 0x7f150144 | 30131 |
| `ExoMediaButton_Play` | int | 0x7f150145 | 30134 |
| `ExoMediaButton_Previous` | int | 0x7f150146 | 30137 |
| `ExoMediaButton_Rewind` | int | 0x7f150147 | 30140 |
| `ExoMediaButton_VR` | int | 0x7f150148 | 30143 |
| `ExoStyledControls` | int | 0x7f150149 | 30146 |
| `ExoStyledControls_Button` | int | 0x7f15014a | 30149 |
| `ExoStyledControls_Button_Bottom` | int | 0x7f15014b | 30152 |
| `ExoStyledControls_Button_Bottom_AudioTrack` | int | 0x7f15014c | 30155 |
| `ExoStyledControls_Button_Bottom_CC` | int | 0x7f15014d | 30158 |
| `ExoStyledControls_Button_Bottom_FullScreen` | int | 0x7f15014e | 30161 |
| `ExoStyledControls_Button_Bottom_OverflowHide` | int | 0x7f15014f | 30164 |
| `ExoStyledControls_Button_Bottom_OverflowShow` | int | 0x7f150150 | 30167 |
| `ExoStyledControls_Button_Bottom_PlaybackSpeed` | int | 0x7f150151 | 30170 |
| `ExoStyledControls_Button_Bottom_RepeatToggle` | int | 0x7f150152 | 30173 |
| `ExoStyledControls_Button_Bottom_Settings` | int | 0x7f150153 | 30176 |
| `ExoStyledControls_Button_Bottom_Shuffle` | int | 0x7f150154 | 30179 |
| `ExoStyledControls_Button_Bottom_VR` | int | 0x7f150155 | 30182 |
| `ExoStyledControls_Button_Center` | int | 0x7f150156 | 30185 |
| `ExoStyledControls_Button_Center_FfwdWithAmount` | int | 0x7f150157 | 30188 |
| `ExoStyledControls_Button_Center_Next` | int | 0x7f150158 | 30191 |
| `ExoStyledControls_Button_Center_PlayPause` | int | 0x7f150159 | 30194 |
| `ExoStyledControls_Button_Center_Previous` | int | 0x7f15015a | 30197 |
| `ExoStyledControls_Button_Center_RewWithAmount` | int | 0x7f15015b | 30200 |
| `ExoStyledControls_TimeBar` | int | 0x7f15015c | 30203 |
| `ExoStyledControls_TimeText` | int | 0x7f15015d | 30206 |
| `ExoStyledControls_TimeText_Duration` | int | 0x7f15015e | 30209 |
| `ExoStyledControls_TimeText_Position` | int | 0x7f15015f | 30212 |
| `ExoStyledControls_TimeText_Separator` | int | 0x7f150160 | 30215 |
| `ExpandAnimation` | int | 0x7f150161 | 30218 |
| `IcatchAppTheme` | int | 0x7f150167 | 30221 |
| `LauncherAppTheme` | int | 0x7f150168 | 30224 |
| `MaterialAlertDialog_Material3` | int | 0x7f15016a | 30227 |
| `MaterialAlertDialog_Material3_Animation` | int | 0x7f15016b | 30230 |
| `MaterialAlertDialog_Material3_Body_Text` | int | 0x7f15016c | 30233 |
| `MaterialAlertDialog_Material3_Body_Text_CenterStacked` | int | 0x7f15016d | 30236 |
| `MaterialAlertDialog_Material3_Title_Icon` | int | 0x7f15016e | 30239 |
| `MaterialAlertDialog_Material3_Title_Icon_CenterStacked` | int | 0x7f15016f | 30242 |
| `MaterialAlertDialog_Material3_Title_Panel` | int | 0x7f150170 | 30245 |
| `MaterialAlertDialog_Material3_Title_Panel_CenterStacked` | int | 0x7f150171 | 30248 |
| `MaterialAlertDialog_Material3_Title_Text` | int | 0x7f150172 | 30251 |
| `MaterialAlertDialog_Material3_Title_Text_CenterStacked` | int | 0x7f150173 | 30254 |
| `MaterialAlertDialog_MaterialComponents` | int | 0x7f150174 | 30257 |
| `MaterialAlertDialog_MaterialComponents_Body_Text` | int | 0x7f150175 | 30260 |
| `MaterialAlertDialog_MaterialComponents_Picker_Date_Calendar` | int | 0x7f150176 | 30263 |
| `MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner` | int | 0x7f150177 | 30266 |
| `MaterialAlertDialog_MaterialComponents_Title_Icon` | int | 0x7f150178 | 30269 |
| `MaterialAlertDialog_MaterialComponents_Title_Icon_CenterStacked` | int | 0x7f150179 | 30272 |
| `MaterialAlertDialog_MaterialComponents_Title_Panel` | int | 0x7f15017a | 30275 |
| `MaterialAlertDialog_MaterialComponents_Title_Panel_CenterStacked` | int | 0x7f15017b | 30278 |
| `MaterialAlertDialog_MaterialComponents_Title_Text` | int | 0x7f15017c | 30281 |
| `MaterialAlertDialog_MaterialComponents_Title_Text_CenterStacked` | int | 0x7f15017d | 30284 |
| `newBottomSheetStyle` | int | 0x7f1504fb | 32846 |
| `PbVideoTheme` | int | 0x7f150183 | 30287 |
| `PermissionNiubility_TranslucentTheme` | int | 0x7f150184 | 30290 |
| `picker_view_scale_anim` | int | 0x7f1504fd | 32849 |
| `picker_view_slide_anim` | int | 0x7f1504fe | 32852 |
| `Picture_Theme_AlertDialog` | int | 0x7f150185 | 30293 |
| `Picture_Theme_Dialog` | int | 0x7f150186 | 30296 |
| `Picture_Theme_Dialog_AudioStyle` | int | 0x7f150187 | 30299 |
| `Picture_Theme_Translucent` | int | 0x7f150188 | 30302 |
| `PictureThemeDialogFragmentAnim` | int | 0x7f150189 | 30305 |
| `PictureThemeDialogWindowStyle` | int | 0x7f15018a | 30308 |
| `PictureThemeWindowStyle` | int | 0x7f15018b | 30311 |
| `Platform_AppCompat` | int | 0x7f15018c | 30314 |
| `Platform_AppCompat_Light` | int | 0x7f15018d | 30317 |
| `Platform_MaterialComponents` | int | 0x7f15018e | 30320 |
| `Platform_MaterialComponents_Dialog` | int | 0x7f15018f | 30323 |
| `Platform_MaterialComponents_Light` | int | 0x7f150190 | 30326 |
| `Platform_MaterialComponents_Light_Dialog` | int | 0x7f150191 | 30329 |
| `Platform_ThemeOverlay_AppCompat` | int | 0x7f150192 | 30332 |
| `Platform_ThemeOverlay_AppCompat_Dark` | int | 0x7f150193 | 30335 |
| `Platform_ThemeOverlay_AppCompat_Light` | int | 0x7f150194 | 30338 |
| `Platform_V21_AppCompat` | int | 0x7f150195 | 30341 |
| `Platform_V21_AppCompat_Light` | int | 0x7f150196 | 30344 |
| `Platform_V25_AppCompat` | int | 0x7f150197 | 30347 |
| `Platform_V25_AppCompat_Light` | int | 0x7f150198 | 30350 |
| `Platform_Widget_AppCompat_Spinner` | int | 0x7f150199 | 30353 |
| `PlayerLoadingProgressBarStyle` | int | 0x7f15019a | 30356 |
| `PlayerLoadingStyle` | int | 0x7f15019b | 30359 |
| `PopupWindowFadeAnimationStyle` | int | 0x7f15019f | 30362 |
| `PreferenceDialogStyle` | int | 0x7f1501a2 | 30371 |
| `PrefListDialogStyle` | int | 0x7f1501a0 | 30365 |
| `PrefStyle` | int | 0x7f1501a1 | 30368 |
| `ripple_click` | int | 0x7f150501 | 32855 |
| `RtlOverlay_DialogWindowTitle_AppCompat` | int | 0x7f1501a4 | 30374 |
| `RtlOverlay_Widget_AppCompat_ActionBar_TitleItem` | int | 0x7f1501a5 | 30377 |
| `RtlOverlay_Widget_AppCompat_DialogTitle_Icon` | int | 0x7f1501a6 | 30380 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem` | int | 0x7f1501a7 | 30383 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_InternalGroup` | int | 0x7f1501a8 | 30386 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_Shortcut` | int | 0x7f1501a9 | 30389 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_SubmenuArrow` | int | 0x7f1501aa | 30392 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_Text` | int | 0x7f1501ab | 30395 |
| `RtlOverlay_Widget_AppCompat_PopupMenuItem_Title` | int | 0x7f1501ac | 30398 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown` | int | 0x7f1501ad | 30401 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown_Icon1` | int | 0x7f1501ae | 30404 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown_Icon2` | int | 0x7f1501af | 30407 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown_Query` | int | 0x7f1501b0 | 30410 |
| `RtlOverlay_Widget_AppCompat_Search_DropDown_Text` | int | 0x7f1501b1 | 30413 |
| `RtlOverlay_Widget_AppCompat_SearchView_MagIcon` | int | 0x7f1501b2 | 30416 |
| `RtlUnderlay_Widget_AppCompat_ActionButton` | int | 0x7f1501b3 | 30419 |
| `RtlUnderlay_Widget_AppCompat_ActionButton_Overflow` | int | 0x7f1501b4 | 30422 |
| `Scankit_OnClick` | int | 0x7f1501b7 | 30428 |
| `ShapeAppearance_M3_Comp_Badge_Large_Shape` | int | 0x7f1501b8 | 30431 |
| `ShapeAppearance_M3_Comp_Badge_Shape` | int | 0x7f1501b9 | 30434 |
| `ShapeAppearance_M3_Comp_BottomAppBar_Container_Shape` | int | 0x7f1501ba | 30437 |
| `ShapeAppearance_M3_Comp_DatePicker_Modal_Date_Container_Shape` | int | 0x7f1501bb | 30440 |
| `ShapeAppearance_M3_Comp_FilledButton_Container_Shape` | int | 0x7f1501bc | 30443 |
| `ShapeAppearance_M3_Comp_NavigationBar_ActiveIndicator_Shape` | int | 0x7f1501bd | 30446 |
| `ShapeAppearance_M3_Comp_NavigationBar_Container_Shape` | int | 0x7f1501be | 30449 |
| `ShapeAppearance_M3_Comp_NavigationDrawer_ActiveIndicator_Shape` | int | 0x7f1501bf | 30452 |
| `ShapeAppearance_M3_Comp_NavigationRail_ActiveIndicator_Shape` | int | 0x7f1501c0 | 30455 |
| `ShapeAppearance_M3_Comp_NavigationRail_Container_Shape` | int | 0x7f1501c1 | 30458 |
| `ShapeAppearance_M3_Comp_SearchBar_Avatar_Shape` | int | 0x7f1501c2 | 30461 |
| `ShapeAppearance_M3_Comp_SearchBar_Container_Shape` | int | 0x7f1501c3 | 30464 |
| `ShapeAppearance_M3_Comp_SearchView_FullScreen_Container_Shape` | int | 0x7f1501c4 | 30467 |
| `ShapeAppearance_M3_Comp_Sheet_Side_Docked_Container_Shape` | int | 0x7f1501c5 | 30470 |
| `ShapeAppearance_M3_Comp_Switch_Handle_Shape` | int | 0x7f1501c6 | 30473 |
| `ShapeAppearance_M3_Comp_Switch_StateLayer_Shape` | int | 0x7f1501c7 | 30476 |
| `ShapeAppearance_M3_Comp_Switch_Track_Shape` | int | 0x7f1501c8 | 30479 |
| `ShapeAppearance_M3_Comp_TextButton_Container_Shape` | int | 0x7f1501c9 | 30482 |
| `ShapeAppearance_M3_Sys_Shape_Corner_ExtraLarge` | int | 0x7f1501ca | 30485 |
| `ShapeAppearance_M3_Sys_Shape_Corner_ExtraSmall` | int | 0x7f1501cb | 30488 |
| `ShapeAppearance_M3_Sys_Shape_Corner_Full` | int | 0x7f1501cc | 30491 |
| `ShapeAppearance_M3_Sys_Shape_Corner_Large` | int | 0x7f1501cd | 30494 |
| `ShapeAppearance_M3_Sys_Shape_Corner_Medium` | int | 0x7f1501ce | 30497 |
| `ShapeAppearance_M3_Sys_Shape_Corner_None` | int | 0x7f1501cf | 30500 |
| `ShapeAppearance_M3_Sys_Shape_Corner_Small` | int | 0x7f1501d0 | 30503 |
| `ShapeAppearance_Material3_Corner_ExtraLarge` | int | 0x7f1501d1 | 30506 |
| `ShapeAppearance_Material3_Corner_ExtraSmall` | int | 0x7f1501d2 | 30509 |
| `ShapeAppearance_Material3_Corner_Full` | int | 0x7f1501d3 | 30512 |
| `ShapeAppearance_Material3_Corner_Large` | int | 0x7f1501d4 | 30515 |
| `ShapeAppearance_Material3_Corner_Medium` | int | 0x7f1501d5 | 30518 |
| `ShapeAppearance_Material3_Corner_None` | int | 0x7f1501d6 | 30521 |
| `ShapeAppearance_Material3_Corner_Small` | int | 0x7f1501d7 | 30524 |
| `ShapeAppearance_Material3_LargeComponent` | int | 0x7f1501d8 | 30527 |
| `ShapeAppearance_Material3_MediumComponent` | int | 0x7f1501d9 | 30530 |
| `ShapeAppearance_Material3_NavigationBarView_ActiveIndicator` | int | 0x7f1501da | 30533 |
| `ShapeAppearance_Material3_SmallComponent` | int | 0x7f1501db | 30536 |
| `ShapeAppearance_Material3_Tooltip` | int | 0x7f1501dc | 30539 |
| `ShapeAppearance_MaterialComponents` | int | 0x7f1501dd | 30542 |
| `ShapeAppearance_MaterialComponents_Badge` | int | 0x7f1501de | 30545 |
| `ShapeAppearance_MaterialComponents_LargeComponent` | int | 0x7f1501df | 30548 |
| `ShapeAppearance_MaterialComponents_MediumComponent` | int | 0x7f1501e0 | 30551 |
| `ShapeAppearance_MaterialComponents_SmallComponent` | int | 0x7f1501e1 | 30554 |
| `ShapeAppearance_MaterialComponents_Tooltip` | int | 0x7f1501e2 | 30557 |
| `ShapeAppearanceOverlay_Material3_Button` | int | 0x7f1501e3 | 30560 |
| `ShapeAppearanceOverlay_Material3_Chip` | int | 0x7f1501e4 | 30563 |
| `ShapeAppearanceOverlay_Material3_Corner_Bottom` | int | 0x7f1501e5 | 30566 |
| `ShapeAppearanceOverlay_Material3_Corner_Left` | int | 0x7f1501e6 | 30569 |
| `ShapeAppearanceOverlay_Material3_Corner_Right` | int | 0x7f1501e7 | 30572 |
| `ShapeAppearanceOverlay_Material3_Corner_Top` | int | 0x7f1501e8 | 30575 |
| `ShapeAppearanceOverlay_Material3_FloatingActionButton` | int | 0x7f1501e9 | 30578 |
| `ShapeAppearanceOverlay_Material3_NavigationView_Item` | int | 0x7f1501ea | 30581 |
| `ShapeAppearanceOverlay_Material3_SearchBar` | int | 0x7f1501eb | 30584 |
| `ShapeAppearanceOverlay_Material3_SearchView` | int | 0x7f1501ec | 30587 |
| `ShapeAppearanceOverlay_MaterialAlertDialog_Material3` | int | 0x7f1501ed | 30590 |
| `ShapeAppearanceOverlay_MaterialComponents_BottomSheet` | int | 0x7f1501ee | 30593 |
| `ShapeAppearanceOverlay_MaterialComponents_Chip` | int | 0x7f1501ef | 30596 |
| `ShapeAppearanceOverlay_MaterialComponents_ExtendedFloatingActionButton` | int | 0x7f1501f0 | 30599 |
| `ShapeAppearanceOverlay_MaterialComponents_FloatingActionButton` | int | 0x7f1501f1 | 30602 |
| `ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Day` | int | 0x7f1501f2 | 30605 |
| `ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Window_Fullscreen` | int | 0x7f1501f3 | 30608 |
| `ShapeAppearanceOverlay_MaterialComponents_MaterialCalendar_Year` | int | 0x7f1501f4 | 30611 |
| `ShapeAppearanceOverlay_MaterialComponents_TextInputLayout_FilledBox` | int | 0x7f1501f5 | 30614 |
| `SimpleToolbarStyle` | int | 0x7f1501f6 | 30617 |
| `SKUPanelDialogAnimation` | int | 0x7f1501b5 | 30425 |
| `SlideAnimation` | int | 0x7f1501f7 | 30620 |
| `SmartRefreshStyle` | int | 0x7f1501f8 | 30623 |
| `StoreAppBottomSheetStyle` | int | 0x7f1501f9 | 30626 |
| `TextAppearance_AppCompat` | int | 0x7f1501fb | 30629 |
| `TextAppearance_AppCompat_Body1` | int | 0x7f1501fc | 30632 |
| `TextAppearance_AppCompat_Body2` | int | 0x7f1501fd | 30635 |
| `TextAppearance_AppCompat_Button` | int | 0x7f1501fe | 30638 |
| `TextAppearance_AppCompat_Caption` | int | 0x7f1501ff | 30641 |
| `TextAppearance_AppCompat_Display1` | int | 0x7f150200 | 30644 |
| `TextAppearance_AppCompat_Display2` | int | 0x7f150201 | 30647 |
| `TextAppearance_AppCompat_Display3` | int | 0x7f150202 | 30650 |
| `TextAppearance_AppCompat_Display4` | int | 0x7f150203 | 30653 |
| `TextAppearance_AppCompat_Headline` | int | 0x7f150204 | 30656 |
| `TextAppearance_AppCompat_Inverse` | int | 0x7f150205 | 30659 |
| `TextAppearance_AppCompat_Large` | int | 0x7f150206 | 30662 |
| `TextAppearance_AppCompat_Large_Inverse` | int | 0x7f150207 | 30665 |
| `TextAppearance_AppCompat_Light_SearchResult_Subtitle` | int | 0x7f150208 | 30668 |
| `TextAppearance_AppCompat_Light_SearchResult_Title` | int | 0x7f150209 | 30671 |
| `TextAppearance_AppCompat_Light_Widget_PopupMenu_Large` | int | 0x7f15020a | 30674 |
| `TextAppearance_AppCompat_Light_Widget_PopupMenu_Small` | int | 0x7f15020b | 30677 |
| `TextAppearance_AppCompat_Medium` | int | 0x7f15020c | 30680 |
| `TextAppearance_AppCompat_Medium_Inverse` | int | 0x7f15020d | 30683 |
| `TextAppearance_AppCompat_Menu` | int | 0x7f15020e | 30686 |
| `TextAppearance_AppCompat_SearchResult_Subtitle` | int | 0x7f15020f | 30689 |
| `TextAppearance_AppCompat_SearchResult_Title` | int | 0x7f150210 | 30692 |
| `TextAppearance_AppCompat_Small` | int | 0x7f150211 | 30695 |
| `TextAppearance_AppCompat_Small_Inverse` | int | 0x7f150212 | 30698 |
| `TextAppearance_AppCompat_Subhead` | int | 0x7f150213 | 30701 |
| `TextAppearance_AppCompat_Subhead_Inverse` | int | 0x7f150214 | 30704 |
| `TextAppearance_AppCompat_Title` | int | 0x7f150215 | 30707 |
| `TextAppearance_AppCompat_Title_Inverse` | int | 0x7f150216 | 30710 |
| `TextAppearance_AppCompat_Tooltip` | int | 0x7f150217 | 30713 |
| `TextAppearance_AppCompat_Widget_ActionBar_Menu` | int | 0x7f150218 | 30716 |
| `TextAppearance_AppCompat_Widget_ActionBar_Subtitle` | int | 0x7f150219 | 30719 |
| `TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse` | int | 0x7f15021a | 30722 |
| `TextAppearance_AppCompat_Widget_ActionBar_Title` | int | 0x7f15021b | 30725 |
| `TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse` | int | 0x7f15021c | 30728 |
| `TextAppearance_AppCompat_Widget_ActionMode_Subtitle` | int | 0x7f15021d | 30731 |
| `TextAppearance_AppCompat_Widget_ActionMode_Subtitle_Inverse` | int | 0x7f15021e | 30734 |
| `TextAppearance_AppCompat_Widget_ActionMode_Title` | int | 0x7f15021f | 30737 |
| `TextAppearance_AppCompat_Widget_ActionMode_Title_Inverse` | int | 0x7f150220 | 30740 |
| `TextAppearance_AppCompat_Widget_Button` | int | 0x7f150221 | 30743 |
| `TextAppearance_AppCompat_Widget_Button_Borderless_Colored` | int | 0x7f150222 | 30746 |
| `TextAppearance_AppCompat_Widget_Button_Colored` | int | 0x7f150223 | 30749 |
| `TextAppearance_AppCompat_Widget_Button_Inverse` | int | 0x7f150224 | 30752 |
| `TextAppearance_AppCompat_Widget_DropDownItem` | int | 0x7f150225 | 30755 |
| `TextAppearance_AppCompat_Widget_PopupMenu_Header` | int | 0x7f150226 | 30758 |
| `TextAppearance_AppCompat_Widget_PopupMenu_Large` | int | 0x7f150227 | 30761 |
| `TextAppearance_AppCompat_Widget_PopupMenu_Small` | int | 0x7f150228 | 30764 |
| `TextAppearance_AppCompat_Widget_Switch` | int | 0x7f150229 | 30767 |
| `TextAppearance_AppCompat_Widget_TextView_SpinnerItem` | int | 0x7f15022a | 30770 |
| `TextAppearance_Compat_Notification` | int | 0x7f15022b | 30773 |
| `TextAppearance_Compat_Notification_Info` | int | 0x7f15022c | 30776 |
| `TextAppearance_Compat_Notification_Info_Media` | int | 0x7f15022d | 30779 |
| `TextAppearance_Compat_Notification_Line2` | int | 0x7f15022e | 30782 |
| `TextAppearance_Compat_Notification_Line2_Media` | int | 0x7f15022f | 30785 |
| `TextAppearance_Compat_Notification_Media` | int | 0x7f150230 | 30788 |
| `TextAppearance_Compat_Notification_Time` | int | 0x7f150231 | 30791 |
| `TextAppearance_Compat_Notification_Time_Media` | int | 0x7f150232 | 30794 |
| `TextAppearance_Compat_Notification_Title` | int | 0x7f150233 | 30797 |
| `TextAppearance_Compat_Notification_Title_Media` | int | 0x7f150234 | 30800 |
| `TextAppearance_Design_CollapsingToolbar_Expanded` | int | 0x7f150235 | 30803 |
| `TextAppearance_Design_Counter` | int | 0x7f150236 | 30806 |
| `TextAppearance_Design_Counter_Overflow` | int | 0x7f150237 | 30809 |
| `TextAppearance_Design_Error` | int | 0x7f150238 | 30812 |
| `TextAppearance_Design_HelperText` | int | 0x7f150239 | 30815 |
| `TextAppearance_Design_Hint` | int | 0x7f15023a | 30818 |
| `TextAppearance_Design_Placeholder` | int | 0x7f15023b | 30821 |
| `TextAppearance_Design_Prefix` | int | 0x7f15023c | 30824 |
| `TextAppearance_Design_Snackbar_Message` | int | 0x7f15023d | 30827 |
| `TextAppearance_Design_Suffix` | int | 0x7f15023e | 30830 |
| `TextAppearance_Design_Tab` | int | 0x7f15023f | 30833 |
| `TextAppearance_M3_Sys_Typescale_BodyLarge` | int | 0x7f150240 | 30836 |
| `TextAppearance_M3_Sys_Typescale_BodyMedium` | int | 0x7f150241 | 30839 |
| `TextAppearance_M3_Sys_Typescale_BodySmall` | int | 0x7f150242 | 30842 |
| `TextAppearance_M3_Sys_Typescale_DisplayLarge` | int | 0x7f150243 | 30845 |
| `TextAppearance_M3_Sys_Typescale_DisplayMedium` | int | 0x7f150244 | 30848 |
| `TextAppearance_M3_Sys_Typescale_DisplaySmall` | int | 0x7f150245 | 30851 |
| `TextAppearance_M3_Sys_Typescale_HeadlineLarge` | int | 0x7f150246 | 30854 |
| `TextAppearance_M3_Sys_Typescale_HeadlineMedium` | int | 0x7f150247 | 30857 |
| `TextAppearance_M3_Sys_Typescale_HeadlineSmall` | int | 0x7f150248 | 30860 |
| `TextAppearance_M3_Sys_Typescale_LabelLarge` | int | 0x7f150249 | 30863 |
| `TextAppearance_M3_Sys_Typescale_LabelMedium` | int | 0x7f15024a | 30866 |
| `TextAppearance_M3_Sys_Typescale_LabelSmall` | int | 0x7f15024b | 30869 |
| `TextAppearance_M3_Sys_Typescale_TitleLarge` | int | 0x7f15024c | 30872 |
| `TextAppearance_M3_Sys_Typescale_TitleMedium` | int | 0x7f15024d | 30875 |
| `TextAppearance_M3_Sys_Typescale_TitleSmall` | int | 0x7f15024e | 30878 |
| `TextAppearance_Material3_ActionBar_Subtitle` | int | 0x7f15024f | 30881 |
| `TextAppearance_Material3_ActionBar_Title` | int | 0x7f150250 | 30884 |
| `TextAppearance_Material3_BodyLarge` | int | 0x7f150251 | 30887 |
| `TextAppearance_Material3_BodyMedium` | int | 0x7f150252 | 30890 |
| `TextAppearance_Material3_BodySmall` | int | 0x7f150253 | 30893 |
| `TextAppearance_Material3_DisplayLarge` | int | 0x7f150254 | 30896 |
| `TextAppearance_Material3_DisplayMedium` | int | 0x7f150255 | 30899 |
| `TextAppearance_Material3_DisplaySmall` | int | 0x7f150256 | 30902 |
| `TextAppearance_Material3_HeadlineLarge` | int | 0x7f150257 | 30905 |
| `TextAppearance_Material3_HeadlineMedium` | int | 0x7f150258 | 30908 |
| `TextAppearance_Material3_HeadlineSmall` | int | 0x7f150259 | 30911 |
| `TextAppearance_Material3_LabelLarge` | int | 0x7f15025a | 30914 |
| `TextAppearance_Material3_LabelMedium` | int | 0x7f15025b | 30917 |
| `TextAppearance_Material3_LabelSmall` | int | 0x7f15025c | 30920 |
| `TextAppearance_Material3_MaterialTimePicker_Title` | int | 0x7f15025d | 30923 |
| `TextAppearance_Material3_SearchBar` | int | 0x7f15025e | 30926 |
| `TextAppearance_Material3_SearchView` | int | 0x7f15025f | 30929 |
| `TextAppearance_Material3_SearchView_Prefix` | int | 0x7f150260 | 30932 |
| `TextAppearance_Material3_TitleLarge` | int | 0x7f150261 | 30935 |
| `TextAppearance_Material3_TitleMedium` | int | 0x7f150262 | 30938 |
| `TextAppearance_Material3_TitleSmall` | int | 0x7f150263 | 30941 |
| `TextAppearance_MaterialComponents_Badge` | int | 0x7f150264 | 30944 |
| `TextAppearance_MaterialComponents_Body1` | int | 0x7f150265 | 30947 |
| `TextAppearance_MaterialComponents_Body2` | int | 0x7f150266 | 30950 |
| `TextAppearance_MaterialComponents_Button` | int | 0x7f150267 | 30953 |
| `TextAppearance_MaterialComponents_Caption` | int | 0x7f150268 | 30956 |
| `TextAppearance_MaterialComponents_Chip` | int | 0x7f150269 | 30959 |
| `TextAppearance_MaterialComponents_Headline1` | int | 0x7f15026a | 30962 |
| `TextAppearance_MaterialComponents_Headline2` | int | 0x7f15026b | 30965 |
| `TextAppearance_MaterialComponents_Headline3` | int | 0x7f15026c | 30968 |
| `TextAppearance_MaterialComponents_Headline4` | int | 0x7f15026d | 30971 |
| `TextAppearance_MaterialComponents_Headline5` | int | 0x7f15026e | 30974 |
| `TextAppearance_MaterialComponents_Headline6` | int | 0x7f15026f | 30977 |
| `TextAppearance_MaterialComponents_Overline` | int | 0x7f150270 | 30980 |
| `TextAppearance_MaterialComponents_Subtitle1` | int | 0x7f150271 | 30983 |
| `TextAppearance_MaterialComponents_Subtitle2` | int | 0x7f150272 | 30986 |
| `TextAppearance_MaterialComponents_TimePicker_Title` | int | 0x7f150273 | 30989 |
| `TextAppearance_MaterialComponents_Tooltip` | int | 0x7f150274 | 30992 |
| `TextAppearance_Widget_AppCompat_ExpandedMenu_Item` | int | 0x7f150275 | 30995 |
| `TextAppearance_Widget_AppCompat_Toolbar_Subtitle` | int | 0x7f150276 | 30998 |
| `TextAppearance_Widget_AppCompat_Toolbar_Title` | int | 0x7f150277 | 31001 |
| `Theme_AppCompat` | int | 0x7f150278 | 31004 |
| `Theme_AppCompat_CompactMenu` | int | 0x7f150279 | 31007 |
| `Theme_AppCompat_DayNight` | int | 0x7f15027a | 31010 |
| `Theme_AppCompat_DayNight_DarkActionBar` | int | 0x7f15027b | 31013 |
| `Theme_AppCompat_DayNight_Dialog` | int | 0x7f15027c | 31016 |
| `Theme_AppCompat_DayNight_Dialog_Alert` | int | 0x7f15027d | 31019 |
| `Theme_AppCompat_DayNight_Dialog_MinWidth` | int | 0x7f15027e | 31022 |
| `Theme_AppCompat_DayNight_DialogWhenLarge` | int | 0x7f15027f | 31025 |
| `Theme_AppCompat_DayNight_NoActionBar` | int | 0x7f150280 | 31028 |
| `Theme_AppCompat_Dialog` | int | 0x7f150281 | 31031 |
| `Theme_AppCompat_Dialog_Alert` | int | 0x7f150282 | 31034 |
| `Theme_AppCompat_Dialog_MinWidth` | int | 0x7f150283 | 31037 |
| `Theme_AppCompat_DialogWhenLarge` | int | 0x7f150284 | 31040 |
| `Theme_AppCompat_Empty` | int | 0x7f150285 | 31043 |
| `Theme_AppCompat_Light` | int | 0x7f150286 | 31046 |
| `Theme_AppCompat_Light_DarkActionBar` | int | 0x7f150287 | 31049 |
| `Theme_AppCompat_Light_Dialog` | int | 0x7f150288 | 31052 |
| `Theme_AppCompat_Light_Dialog_Alert` | int | 0x7f150289 | 31055 |
| `Theme_AppCompat_Light_Dialog_MinWidth` | int | 0x7f15028a | 31058 |
| `Theme_AppCompat_Light_DialogWhenLarge` | int | 0x7f15028b | 31061 |
| `Theme_AppCompat_Light_NoActionBar` | int | 0x7f15028c | 31064 |
| `Theme_AppCompat_NoActionBar` | int | 0x7f15028d | 31067 |
| `Theme_Design` | int | 0x7f15028e | 31070 |
| `Theme_Design_BottomSheetDialog` | int | 0x7f15028f | 31073 |
| `Theme_Design_Light` | int | 0x7f150290 | 31076 |
| `Theme_Design_Light_BottomSheetDialog` | int | 0x7f150291 | 31079 |
| `Theme_Design_Light_NoActionBar` | int | 0x7f150292 | 31082 |
| `Theme_Design_NoActionBar` | int | 0x7f150293 | 31085 |
| `Theme_Material3_Dark` | int | 0x7f150294 | 31088 |
| `Theme_Material3_Dark_BottomSheetDialog` | int | 0x7f150295 | 31091 |
| `Theme_Material3_Dark_Dialog` | int | 0x7f150296 | 31094 |
| `Theme_Material3_Dark_Dialog_Alert` | int | 0x7f150297 | 31097 |
| `Theme_Material3_Dark_Dialog_MinWidth` | int | 0x7f150298 | 31100 |
| `Theme_Material3_Dark_DialogWhenLarge` | int | 0x7f150299 | 31103 |
| `Theme_Material3_Dark_NoActionBar` | int | 0x7f15029a | 31106 |
| `Theme_Material3_Dark_SideSheetDialog` | int | 0x7f15029b | 31109 |
| `Theme_Material3_DayNight` | int | 0x7f15029c | 31112 |
| `Theme_Material3_DayNight_BottomSheetDialog` | int | 0x7f15029d | 31115 |
| `Theme_Material3_DayNight_Dialog` | int | 0x7f15029e | 31118 |
| `Theme_Material3_DayNight_Dialog_Alert` | int | 0x7f15029f | 31121 |
| `Theme_Material3_DayNight_Dialog_MinWidth` | int | 0x7f1502a0 | 31124 |
| `Theme_Material3_DayNight_DialogWhenLarge` | int | 0x7f1502a1 | 31127 |
| `Theme_Material3_DayNight_NoActionBar` | int | 0x7f1502a2 | 31130 |
| `Theme_Material3_DayNight_SideSheetDialog` | int | 0x7f1502a3 | 31133 |
| `Theme_Material3_DynamicColors_Dark` | int | 0x7f1502a4 | 31136 |
| `Theme_Material3_DynamicColors_DayNight` | int | 0x7f1502a5 | 31139 |
| `Theme_Material3_DynamicColors_Light` | int | 0x7f1502a6 | 31142 |
| `Theme_Material3_Light` | int | 0x7f1502a7 | 31145 |
| `Theme_Material3_Light_BottomSheetDialog` | int | 0x7f1502a8 | 31148 |
| `Theme_Material3_Light_Dialog` | int | 0x7f1502a9 | 31151 |
| `Theme_Material3_Light_Dialog_Alert` | int | 0x7f1502aa | 31154 |
| `Theme_Material3_Light_Dialog_MinWidth` | int | 0x7f1502ab | 31157 |
| `Theme_Material3_Light_DialogWhenLarge` | int | 0x7f1502ac | 31160 |
| `Theme_Material3_Light_NoActionBar` | int | 0x7f1502ad | 31163 |
| `Theme_Material3_Light_SideSheetDialog` | int | 0x7f1502ae | 31166 |
| `Theme_MaterialComponents` | int | 0x7f1502af | 31169 |
| `Theme_MaterialComponents_BottomSheetDialog` | int | 0x7f1502b0 | 31172 |
| `Theme_MaterialComponents_Bridge` | int | 0x7f1502b1 | 31175 |
| `Theme_MaterialComponents_CompactMenu` | int | 0x7f1502b2 | 31178 |
| `Theme_MaterialComponents_DayNight` | int | 0x7f1502b3 | 31181 |
| `Theme_MaterialComponents_DayNight_BottomSheetDialog` | int | 0x7f1502b4 | 31184 |
| `Theme_MaterialComponents_DayNight_Bridge` | int | 0x7f1502b5 | 31187 |
| `Theme_MaterialComponents_DayNight_DarkActionBar` | int | 0x7f1502b6 | 31190 |
| `Theme_MaterialComponents_DayNight_DarkActionBar_Bridge` | int | 0x7f1502b7 | 31193 |
| `Theme_MaterialComponents_DayNight_Dialog` | int | 0x7f1502b8 | 31196 |
| `Theme_MaterialComponents_DayNight_Dialog_Alert` | int | 0x7f1502b9 | 31199 |
| `Theme_MaterialComponents_DayNight_Dialog_Alert_Bridge` | int | 0x7f1502ba | 31202 |
| `Theme_MaterialComponents_DayNight_Dialog_Bridge` | int | 0x7f1502bb | 31205 |
| `Theme_MaterialComponents_DayNight_Dialog_FixedSize` | int | 0x7f1502bc | 31208 |
| `Theme_MaterialComponents_DayNight_Dialog_FixedSize_Bridge` | int | 0x7f1502bd | 31211 |
| `Theme_MaterialComponents_DayNight_Dialog_MinWidth` | int | 0x7f1502be | 31214 |
| `Theme_MaterialComponents_DayNight_Dialog_MinWidth_Bridge` | int | 0x7f1502bf | 31217 |
| `Theme_MaterialComponents_DayNight_DialogWhenLarge` | int | 0x7f1502c0 | 31220 |
| `Theme_MaterialComponents_DayNight_NoActionBar` | int | 0x7f1502c1 | 31223 |
| `Theme_MaterialComponents_DayNight_NoActionBar_Bridge` | int | 0x7f1502c2 | 31226 |
| `Theme_MaterialComponents_Dialog` | int | 0x7f1502c3 | 31229 |
| `Theme_MaterialComponents_Dialog_Alert` | int | 0x7f1502c4 | 31232 |
| `Theme_MaterialComponents_Dialog_Alert_Bridge` | int | 0x7f1502c5 | 31235 |
| `Theme_MaterialComponents_Dialog_Bridge` | int | 0x7f1502c6 | 31238 |
| `Theme_MaterialComponents_Dialog_FixedSize` | int | 0x7f1502c7 | 31241 |
| `Theme_MaterialComponents_Dialog_FixedSize_Bridge` | int | 0x7f1502c8 | 31244 |
| `Theme_MaterialComponents_Dialog_MinWidth` | int | 0x7f1502c9 | 31247 |
| `Theme_MaterialComponents_Dialog_MinWidth_Bridge` | int | 0x7f1502ca | 31250 |
| `Theme_MaterialComponents_DialogWhenLarge` | int | 0x7f1502cb | 31253 |
| `Theme_MaterialComponents_Light` | int | 0x7f1502cc | 31256 |
| `Theme_MaterialComponents_Light_BottomSheetDialog` | int | 0x7f1502cd | 31259 |
| `Theme_MaterialComponents_Light_Bridge` | int | 0x7f1502ce | 31262 |
| `Theme_MaterialComponents_Light_DarkActionBar` | int | 0x7f1502cf | 31265 |
| `Theme_MaterialComponents_Light_DarkActionBar_Bridge` | int | 0x7f1502d0 | 31268 |
| `Theme_MaterialComponents_Light_Dialog` | int | 0x7f1502d1 | 31271 |
| `Theme_MaterialComponents_Light_Dialog_Alert` | int | 0x7f1502d2 | 31274 |
| `Theme_MaterialComponents_Light_Dialog_Alert_Bridge` | int | 0x7f1502d3 | 31277 |
| `Theme_MaterialComponents_Light_Dialog_Bridge` | int | 0x7f1502d4 | 31280 |
| `Theme_MaterialComponents_Light_Dialog_FixedSize` | int | 0x7f1502d5 | 31283 |
| `Theme_MaterialComponents_Light_Dialog_FixedSize_Bridge` | int | 0x7f1502d6 | 31286 |
| `Theme_MaterialComponents_Light_Dialog_MinWidth` | int | 0x7f1502d7 | 31289 |
| `Theme_MaterialComponents_Light_Dialog_MinWidth_Bridge` | int | 0x7f1502d8 | 31292 |
| `Theme_MaterialComponents_Light_DialogWhenLarge` | int | 0x7f1502d9 | 31295 |
| `Theme_MaterialComponents_Light_NoActionBar` | int | 0x7f1502da | 31298 |
| `Theme_MaterialComponents_Light_NoActionBar_Bridge` | int | 0x7f1502db | 31301 |
| `Theme_MaterialComponents_NoActionBar` | int | 0x7f1502dc | 31304 |
| `Theme_MaterialComponents_NoActionBar_Bridge` | int | 0x7f1502dd | 31307 |
| `Theme_SdkDemo` | int | 0x7f1502de | 31310 |
| `Theme_SplashScreen` | int | 0x7f1502df | 31313 |
| `Theme_SplashScreen_Common` | int | 0x7f1502e0 | 31316 |
| `Theme_SplashScreen_IconBackground` | int | 0x7f1502e1 | 31319 |
| `ThemeControlActivity` | int | 0x7f1502e2 | 31322 |
| `ThemeDialogAnim` | int | 0x7f1502e3 | 31325 |
| `ThemeNoActionBar` | int | 0x7f1502e4 | 31328 |
| `ThemeOverlay_AppCompat` | int | 0x7f1502e5 | 31331 |
| `ThemeOverlay_AppCompat_ActionBar` | int | 0x7f1502e6 | 31334 |
| `ThemeOverlay_AppCompat_Dark` | int | 0x7f1502e7 | 31337 |
| `ThemeOverlay_AppCompat_Dark_ActionBar` | int | 0x7f1502e8 | 31340 |
| `ThemeOverlay_AppCompat_DayNight` | int | 0x7f1502e9 | 31343 |
| `ThemeOverlay_AppCompat_DayNight_ActionBar` | int | 0x7f1502ea | 31346 |
| `ThemeOverlay_AppCompat_Dialog` | int | 0x7f1502eb | 31349 |
| `ThemeOverlay_AppCompat_Dialog_Alert` | int | 0x7f1502ec | 31352 |
| `ThemeOverlay_AppCompat_Light` | int | 0x7f1502ed | 31355 |
| `ThemeOverlay_Design_TextInputEditText` | int | 0x7f1502ee | 31358 |
| `ThemeOverlay_Material3` | int | 0x7f1502ef | 31361 |
| `ThemeOverlay_Material3_ActionBar` | int | 0x7f1502f0 | 31364 |
| `ThemeOverlay_Material3_AutoCompleteTextView` | int | 0x7f1502f1 | 31367 |
| `ThemeOverlay_Material3_AutoCompleteTextView_FilledBox` | int | 0x7f1502f2 | 31370 |
| `ThemeOverlay_Material3_AutoCompleteTextView_FilledBox_Dense` | int | 0x7f1502f3 | 31373 |
| `ThemeOverlay_Material3_AutoCompleteTextView_OutlinedBox` | int | 0x7f1502f4 | 31376 |
| `ThemeOverlay_Material3_AutoCompleteTextView_OutlinedBox_Dense` | int | 0x7f1502f5 | 31379 |
| `ThemeOverlay_Material3_BottomAppBar` | int | 0x7f1502f6 | 31382 |
| `ThemeOverlay_Material3_BottomAppBar_Legacy` | int | 0x7f1502f7 | 31385 |
| `ThemeOverlay_Material3_BottomNavigationView` | int | 0x7f1502f8 | 31388 |
| `ThemeOverlay_Material3_BottomSheetDialog` | int | 0x7f1502f9 | 31391 |
| `ThemeOverlay_Material3_Button` | int | 0x7f1502fa | 31394 |
| `ThemeOverlay_Material3_Button_ElevatedButton` | int | 0x7f1502fb | 31397 |
| `ThemeOverlay_Material3_Button_IconButton` | int | 0x7f1502fc | 31400 |
| `ThemeOverlay_Material3_Button_IconButton_Filled` | int | 0x7f1502fd | 31403 |
| `ThemeOverlay_Material3_Button_IconButton_Filled_Tonal` | int | 0x7f1502fe | 31406 |
| `ThemeOverlay_Material3_Button_TextButton` | int | 0x7f1502ff | 31409 |
| `ThemeOverlay_Material3_Button_TextButton_Snackbar` | int | 0x7f150300 | 31412 |
| `ThemeOverlay_Material3_Button_TonalButton` | int | 0x7f150301 | 31415 |
| `ThemeOverlay_Material3_Chip` | int | 0x7f150302 | 31418 |
| `ThemeOverlay_Material3_Chip_Assist` | int | 0x7f150303 | 31421 |
| `ThemeOverlay_Material3_Dark` | int | 0x7f150304 | 31424 |
| `ThemeOverlay_Material3_Dark_ActionBar` | int | 0x7f150305 | 31427 |
| `ThemeOverlay_Material3_DayNight_BottomSheetDialog` | int | 0x7f150306 | 31430 |
| `ThemeOverlay_Material3_DayNight_SideSheetDialog` | int | 0x7f150307 | 31433 |
| `ThemeOverlay_Material3_Dialog` | int | 0x7f150308 | 31436 |
| `ThemeOverlay_Material3_Dialog_Alert` | int | 0x7f150309 | 31439 |
| `ThemeOverlay_Material3_Dialog_Alert_Framework` | int | 0x7f15030a | 31442 |
| `ThemeOverlay_Material3_DynamicColors_Dark` | int | 0x7f15030b | 31445 |
| `ThemeOverlay_Material3_DynamicColors_DayNight` | int | 0x7f15030c | 31448 |
| `ThemeOverlay_Material3_DynamicColors_Light` | int | 0x7f15030d | 31451 |
| `ThemeOverlay_Material3_ExtendedFloatingActionButton_Primary` | int | 0x7f15030e | 31454 |
| `ThemeOverlay_Material3_ExtendedFloatingActionButton_Secondary` | int | 0x7f15030f | 31457 |
| `ThemeOverlay_Material3_ExtendedFloatingActionButton_Surface` | int | 0x7f150310 | 31460 |
| `ThemeOverlay_Material3_ExtendedFloatingActionButton_Tertiary` | int | 0x7f150311 | 31463 |
| `ThemeOverlay_Material3_FloatingActionButton_Primary` | int | 0x7f150312 | 31466 |
| `ThemeOverlay_Material3_FloatingActionButton_Secondary` | int | 0x7f150313 | 31469 |
| `ThemeOverlay_Material3_FloatingActionButton_Surface` | int | 0x7f150314 | 31472 |
| `ThemeOverlay_Material3_FloatingActionButton_Tertiary` | int | 0x7f150315 | 31475 |
| `ThemeOverlay_Material3_HarmonizedColors` | int | 0x7f150316 | 31478 |
| `ThemeOverlay_Material3_HarmonizedColors_Empty` | int | 0x7f150317 | 31481 |
| `ThemeOverlay_Material3_Light` | int | 0x7f150318 | 31484 |
| `ThemeOverlay_Material3_Light_Dialog_Alert_Framework` | int | 0x7f150319 | 31487 |
| `ThemeOverlay_Material3_MaterialAlertDialog` | int | 0x7f15031a | 31490 |
| `ThemeOverlay_Material3_MaterialAlertDialog_Centered` | int | 0x7f15031b | 31493 |
| `ThemeOverlay_Material3_MaterialCalendar` | int | 0x7f15031c | 31496 |
| `ThemeOverlay_Material3_MaterialCalendar_Fullscreen` | int | 0x7f15031d | 31499 |
| `ThemeOverlay_Material3_MaterialCalendar_HeaderCancelButton` | int | 0x7f15031e | 31502 |
| `ThemeOverlay_Material3_MaterialTimePicker` | int | 0x7f15031f | 31505 |
| `ThemeOverlay_Material3_MaterialTimePicker_Display_TextInputEditText` | int | 0x7f150320 | 31508 |
| `ThemeOverlay_Material3_NavigationRailView` | int | 0x7f150321 | 31511 |
| `ThemeOverlay_Material3_NavigationView` | int | 0x7f150322 | 31514 |
| `ThemeOverlay_Material3_PersonalizedColors` | int | 0x7f150323 | 31517 |
| `ThemeOverlay_Material3_Search` | int | 0x7f150324 | 31520 |
| `ThemeOverlay_Material3_SideSheetDialog` | int | 0x7f150325 | 31523 |
| `ThemeOverlay_Material3_Snackbar` | int | 0x7f150326 | 31526 |
| `ThemeOverlay_Material3_TabLayout` | int | 0x7f150327 | 31529 |
| `ThemeOverlay_Material3_TextInputEditText` | int | 0x7f150328 | 31532 |
| `ThemeOverlay_Material3_TextInputEditText_FilledBox` | int | 0x7f150329 | 31535 |
| `ThemeOverlay_Material3_TextInputEditText_FilledBox_Dense` | int | 0x7f15032a | 31538 |
| `ThemeOverlay_Material3_TextInputEditText_OutlinedBox` | int | 0x7f15032b | 31541 |
| `ThemeOverlay_Material3_TextInputEditText_OutlinedBox_Dense` | int | 0x7f15032c | 31544 |
| `ThemeOverlay_Material3_Toolbar_Surface` | int | 0x7f15032d | 31547 |
| `ThemeOverlay_MaterialAlertDialog_Material3_Title_Icon` | int | 0x7f15032e | 31550 |
| `ThemeOverlay_MaterialComponents` | int | 0x7f15032f | 31553 |
| `ThemeOverlay_MaterialComponents_ActionBar` | int | 0x7f150330 | 31556 |
| `ThemeOverlay_MaterialComponents_ActionBar_Primary` | int | 0x7f150331 | 31559 |
| `ThemeOverlay_MaterialComponents_ActionBar_Surface` | int | 0x7f150332 | 31562 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView` | int | 0x7f150333 | 31565 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView_FilledBox` | int | 0x7f150334 | 31568 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView_FilledBox_Dense` | int | 0x7f150335 | 31571 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView_OutlinedBox` | int | 0x7f150336 | 31574 |
| `ThemeOverlay_MaterialComponents_AutoCompleteTextView_OutlinedBox_Dense` | int | 0x7f150337 | 31577 |
| `ThemeOverlay_MaterialComponents_BottomAppBar_Primary` | int | 0x7f150338 | 31580 |
| `ThemeOverlay_MaterialComponents_BottomAppBar_Surface` | int | 0x7f150339 | 31583 |
| `ThemeOverlay_MaterialComponents_BottomSheetDialog` | int | 0x7f15033a | 31586 |
| `ThemeOverlay_MaterialComponents_Dark` | int | 0x7f15033b | 31589 |
| `ThemeOverlay_MaterialComponents_Dark_ActionBar` | int | 0x7f15033c | 31592 |
| `ThemeOverlay_MaterialComponents_DayNight_BottomSheetDialog` | int | 0x7f15033d | 31595 |
| `ThemeOverlay_MaterialComponents_Dialog` | int | 0x7f15033e | 31598 |
| `ThemeOverlay_MaterialComponents_Dialog_Alert` | int | 0x7f15033f | 31601 |
| `ThemeOverlay_MaterialComponents_Dialog_Alert_Framework` | int | 0x7f150340 | 31604 |
| `ThemeOverlay_MaterialComponents_Light` | int | 0x7f150341 | 31607 |
| `ThemeOverlay_MaterialComponents_Light_Dialog_Alert_Framework` | int | 0x7f150342 | 31610 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog` | int | 0x7f150343 | 31613 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Centered` | int | 0x7f150344 | 31616 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date` | int | 0x7f150345 | 31619 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date_Calendar` | int | 0x7f150346 | 31622 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date_Header_Text` | int | 0x7f150347 | 31625 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date_Header_Text_Day` | int | 0x7f150348 | 31628 |
| `ThemeOverlay_MaterialComponents_MaterialAlertDialog_Picker_Date_Spinner` | int | 0x7f150349 | 31631 |
| `ThemeOverlay_MaterialComponents_MaterialCalendar` | int | 0x7f15034a | 31634 |
| `ThemeOverlay_MaterialComponents_MaterialCalendar_Fullscreen` | int | 0x7f15034b | 31637 |
| `ThemeOverlay_MaterialComponents_TextInputEditText` | int | 0x7f15034c | 31640 |
| `ThemeOverlay_MaterialComponents_TextInputEditText_FilledBox` | int | 0x7f15034d | 31643 |
| `ThemeOverlay_MaterialComponents_TextInputEditText_FilledBox_Dense` | int | 0x7f15034e | 31646 |
| `ThemeOverlay_MaterialComponents_TextInputEditText_OutlinedBox` | int | 0x7f15034f | 31649 |
| `ThemeOverlay_MaterialComponents_TextInputEditText_OutlinedBox_Dense` | int | 0x7f150350 | 31652 |
| `ThemeOverlay_MaterialComponents_TimePicker` | int | 0x7f150351 | 31655 |
| `ThemeOverlay_MaterialComponents_TimePicker_Display` | int | 0x7f150352 | 31658 |
| `ThemeOverlay_MaterialComponents_TimePicker_Display_TextInputEditText` | int | 0x7f150353 | 31661 |
| `ThemeOverlay_MaterialComponents_Toolbar_Popup_Primary` | int | 0x7f150354 | 31664 |
| `ThemeOverlay_MaterialComponents_Toolbar_Primary` | int | 0x7f150355 | 31667 |
| `ThemeOverlay_MaterialComponents_Toolbar_Surface` | int | 0x7f150356 | 31670 |
| `ucrop_ImageViewWidgetIcon` | int | 0x7f150504 | 32858 |
| `ucrop_TextViewCropAspectRatio` | int | 0x7f150505 | 32861 |
| `ucrop_TextViewWidget` | int | 0x7f150506 | 32864 |
| `ucrop_TextViewWidgetText` | int | 0x7f150507 | 32867 |
| `ucrop_WrapperIconState` | int | 0x7f150508 | 32870 |
| `ucrop_WrapperRotateButton` | int | 0x7f150509 | 32873 |
| `video_popup_toast_anim` | int | 0x7f15050b | 32876 |
| `video_style_dialog_progress` | int | 0x7f15050c | 32879 |
| `video_vertical_progressBar` | int | 0x7f15050d | 32882 |
| `WhiteColorAccent` | int | 0x7f150359 | 31673 |
| `Widget_AppCompat_ActionBar` | int | 0x7f15035a | 31676 |
| `Widget_AppCompat_ActionBar_Solid` | int | 0x7f15035b | 31679 |
| `Widget_AppCompat_ActionBar_TabBar` | int | 0x7f15035c | 31682 |
| `Widget_AppCompat_ActionBar_TabText` | int | 0x7f15035d | 31685 |
| `Widget_AppCompat_ActionBar_TabView` | int | 0x7f15035e | 31688 |
| `Widget_AppCompat_ActionButton` | int | 0x7f15035f | 31691 |
| `Widget_AppCompat_ActionButton_CloseMode` | int | 0x7f150360 | 31694 |
| `Widget_AppCompat_ActionButton_Overflow` | int | 0x7f150361 | 31697 |
| `Widget_AppCompat_ActionMode` | int | 0x7f150362 | 31700 |
| `Widget_AppCompat_ActivityChooserView` | int | 0x7f150363 | 31703 |
| `Widget_AppCompat_AutoCompleteTextView` | int | 0x7f150364 | 31706 |
| `Widget_AppCompat_Button` | int | 0x7f150365 | 31709 |
| `Widget_AppCompat_Button_Borderless` | int | 0x7f150366 | 31712 |
| `Widget_AppCompat_Button_Borderless_Colored` | int | 0x7f150367 | 31715 |
| `Widget_AppCompat_Button_ButtonBar_AlertDialog` | int | 0x7f150368 | 31718 |
| `Widget_AppCompat_Button_Colored` | int | 0x7f150369 | 31721 |
| `Widget_AppCompat_Button_Small` | int | 0x7f15036a | 31724 |
| `Widget_AppCompat_ButtonBar` | int | 0x7f15036b | 31727 |
| `Widget_AppCompat_ButtonBar_AlertDialog` | int | 0x7f15036c | 31730 |
| `Widget_AppCompat_CompoundButton_CheckBox` | int | 0x7f15036d | 31733 |
| `Widget_AppCompat_CompoundButton_RadioButton` | int | 0x7f15036e | 31736 |
| `Widget_AppCompat_CompoundButton_Switch` | int | 0x7f15036f | 31739 |
| `Widget_AppCompat_DrawerArrowToggle` | int | 0x7f150370 | 31742 |
| `Widget_AppCompat_DropDownItem_Spinner` | int | 0x7f150371 | 31745 |
| `Widget_AppCompat_EditText` | int | 0x7f150372 | 31748 |
| `Widget_AppCompat_ImageButton` | int | 0x7f150373 | 31751 |
| `Widget_AppCompat_Light_ActionBar` | int | 0x7f150374 | 31754 |
| `Widget_AppCompat_Light_ActionBar_Solid` | int | 0x7f150375 | 31757 |
| `Widget_AppCompat_Light_ActionBar_Solid_Inverse` | int | 0x7f150376 | 31760 |
| `Widget_AppCompat_Light_ActionBar_TabBar` | int | 0x7f150377 | 31763 |
| `Widget_AppCompat_Light_ActionBar_TabBar_Inverse` | int | 0x7f150378 | 31766 |
| `Widget_AppCompat_Light_ActionBar_TabText` | int | 0x7f150379 | 31769 |
| `Widget_AppCompat_Light_ActionBar_TabText_Inverse` | int | 0x7f15037a | 31772 |
| `Widget_AppCompat_Light_ActionBar_TabView` | int | 0x7f15037b | 31775 |
| `Widget_AppCompat_Light_ActionBar_TabView_Inverse` | int | 0x7f15037c | 31778 |
| `Widget_AppCompat_Light_ActionButton` | int | 0x7f15037d | 31781 |
| `Widget_AppCompat_Light_ActionButton_CloseMode` | int | 0x7f15037e | 31784 |
| `Widget_AppCompat_Light_ActionButton_Overflow` | int | 0x7f15037f | 31787 |
| `Widget_AppCompat_Light_ActionMode_Inverse` | int | 0x7f150380 | 31790 |
| `Widget_AppCompat_Light_ActivityChooserView` | int | 0x7f150381 | 31793 |
| `Widget_AppCompat_Light_AutoCompleteTextView` | int | 0x7f150382 | 31796 |
| `Widget_AppCompat_Light_DropDownItem_Spinner` | int | 0x7f150383 | 31799 |
| `Widget_AppCompat_Light_ListPopupWindow` | int | 0x7f150384 | 31802 |
| `Widget_AppCompat_Light_ListView_DropDown` | int | 0x7f150385 | 31805 |
| `Widget_AppCompat_Light_PopupMenu` | int | 0x7f150386 | 31808 |
| `Widget_AppCompat_Light_PopupMenu_Overflow` | int | 0x7f150387 | 31811 |
| `Widget_AppCompat_Light_SearchView` | int | 0x7f150388 | 31814 |
| `Widget_AppCompat_Light_Spinner_DropDown_ActionBar` | int | 0x7f150389 | 31817 |
| `Widget_AppCompat_ListMenuView` | int | 0x7f15038a | 31820 |
| `Widget_AppCompat_ListPopupWindow` | int | 0x7f15038b | 31823 |
| `Widget_AppCompat_ListView` | int | 0x7f15038c | 31826 |
| `Widget_AppCompat_ListView_DropDown` | int | 0x7f15038d | 31829 |
| `Widget_AppCompat_ListView_Menu` | int | 0x7f15038e | 31832 |
| `Widget_AppCompat_PopupMenu` | int | 0x7f15038f | 31835 |
| `Widget_AppCompat_PopupMenu_Overflow` | int | 0x7f150390 | 31838 |
| `Widget_AppCompat_PopupWindow` | int | 0x7f150391 | 31841 |
| `Widget_AppCompat_ProgressBar` | int | 0x7f150392 | 31844 |
| `Widget_AppCompat_ProgressBar_Horizontal` | int | 0x7f150393 | 31847 |
| `Widget_AppCompat_RatingBar` | int | 0x7f150394 | 31850 |
| `Widget_AppCompat_RatingBar_Indicator` | int | 0x7f150395 | 31853 |
| `Widget_AppCompat_RatingBar_Small` | int | 0x7f150396 | 31856 |
| `Widget_AppCompat_SearchView` | int | 0x7f150397 | 31859 |
| `Widget_AppCompat_SearchView_ActionBar` | int | 0x7f150398 | 31862 |
| `Widget_AppCompat_SeekBar` | int | 0x7f150399 | 31865 |
| `Widget_AppCompat_SeekBar_Discrete` | int | 0x7f15039a | 31868 |
| `Widget_AppCompat_Spinner` | int | 0x7f15039b | 31871 |
| `Widget_AppCompat_Spinner_DropDown` | int | 0x7f15039c | 31874 |
| `Widget_AppCompat_Spinner_DropDown_ActionBar` | int | 0x7f15039d | 31877 |
| `Widget_AppCompat_Spinner_Underlined` | int | 0x7f15039e | 31880 |
| `Widget_AppCompat_TextView` | int | 0x7f15039f | 31883 |
| `Widget_AppCompat_TextView_SpinnerItem` | int | 0x7f1503a0 | 31886 |
| `Widget_AppCompat_Toolbar` | int | 0x7f1503a1 | 31889 |
| `Widget_AppCompat_Toolbar_Button_Navigation` | int | 0x7f1503a2 | 31892 |
| `Widget_Compat_NotificationActionContainer` | int | 0x7f1503a3 | 31895 |
| `Widget_Compat_NotificationActionText` | int | 0x7f1503a4 | 31898 |
| `Widget_Design_AppBarLayout` | int | 0x7f1503a5 | 31901 |
| `Widget_Design_BottomNavigationView` | int | 0x7f1503a6 | 31904 |
| `Widget_Design_BottomSheet_Modal` | int | 0x7f1503a7 | 31907 |
| `Widget_Design_CollapsingToolbar` | int | 0x7f1503a8 | 31910 |
| `Widget_Design_FloatingActionButton` | int | 0x7f1503a9 | 31913 |
| `Widget_Design_NavigationView` | int | 0x7f1503aa | 31916 |
| `Widget_Design_ScrimInsetsFrameLayout` | int | 0x7f1503ab | 31919 |
| `Widget_Design_Snackbar` | int | 0x7f1503ac | 31922 |
| `Widget_Design_TabLayout` | int | 0x7f1503ad | 31925 |
| `Widget_Design_TextInputEditText` | int | 0x7f1503ae | 31928 |
| `Widget_Design_TextInputLayout` | int | 0x7f1503af | 31931 |
| `Widget_Material3_ActionBar_Solid` | int | 0x7f1503b0 | 31934 |
| `Widget_Material3_ActionMode` | int | 0x7f1503b1 | 31937 |
| `Widget_Material3_AppBarLayout` | int | 0x7f1503b2 | 31940 |
| `Widget_Material3_AutoCompleteTextView_FilledBox` | int | 0x7f1503b3 | 31943 |
| `Widget_Material3_AutoCompleteTextView_FilledBox_Dense` | int | 0x7f1503b4 | 31946 |
| `Widget_Material3_AutoCompleteTextView_OutlinedBox` | int | 0x7f1503b5 | 31949 |
| `Widget_Material3_AutoCompleteTextView_OutlinedBox_Dense` | int | 0x7f1503b6 | 31952 |
| `Widget_Material3_Badge` | int | 0x7f1503b7 | 31955 |
| `Widget_Material3_Badge_AdjustToBounds` | int | 0x7f1503b8 | 31958 |
| `Widget_Material3_BottomAppBar` | int | 0x7f1503b9 | 31961 |
| `Widget_Material3_BottomAppBar_Button_Navigation` | int | 0x7f1503ba | 31964 |
| `Widget_Material3_BottomAppBar_Legacy` | int | 0x7f1503bb | 31967 |
| `Widget_Material3_BottomNavigationView` | int | 0x7f1503bc | 31970 |
| `Widget_Material3_BottomNavigationView_ActiveIndicator` | int | 0x7f1503bd | 31973 |
| `Widget_Material3_BottomSheet` | int | 0x7f1503be | 31976 |
| `Widget_Material3_BottomSheet_DragHandle` | int | 0x7f1503bf | 31979 |
| `Widget_Material3_BottomSheet_Modal` | int | 0x7f1503c0 | 31982 |
| `Widget_Material3_Button` | int | 0x7f1503c1 | 31985 |
| `Widget_Material3_Button_ElevatedButton` | int | 0x7f1503c2 | 31988 |
| `Widget_Material3_Button_ElevatedButton_Icon` | int | 0x7f1503c3 | 31991 |
| `Widget_Material3_Button_Icon` | int | 0x7f1503c4 | 31994 |
| `Widget_Material3_Button_IconButton` | int | 0x7f1503c5 | 31997 |
| `Widget_Material3_Button_IconButton_Filled` | int | 0x7f1503c6 | 32000 |
| `Widget_Material3_Button_IconButton_Filled_Tonal` | int | 0x7f1503c7 | 32003 |
| `Widget_Material3_Button_IconButton_Outlined` | int | 0x7f1503c8 | 32006 |
| `Widget_Material3_Button_OutlinedButton` | int | 0x7f1503c9 | 32009 |
| `Widget_Material3_Button_OutlinedButton_Icon` | int | 0x7f1503ca | 32012 |
| `Widget_Material3_Button_TextButton` | int | 0x7f1503cb | 32015 |
| `Widget_Material3_Button_TextButton_Dialog` | int | 0x7f1503cc | 32018 |
| `Widget_Material3_Button_TextButton_Dialog_Flush` | int | 0x7f1503cd | 32021 |
| `Widget_Material3_Button_TextButton_Dialog_Icon` | int | 0x7f1503ce | 32024 |
| `Widget_Material3_Button_TextButton_Icon` | int | 0x7f1503cf | 32027 |
| `Widget_Material3_Button_TextButton_Snackbar` | int | 0x7f1503d0 | 32030 |
| `Widget_Material3_Button_TonalButton` | int | 0x7f1503d1 | 32033 |
| `Widget_Material3_Button_TonalButton_Icon` | int | 0x7f1503d2 | 32036 |
| `Widget_Material3_Button_UnelevatedButton` | int | 0x7f1503d3 | 32039 |
| `Widget_Material3_CardView_Elevated` | int | 0x7f1503d4 | 32042 |
| `Widget_Material3_CardView_Filled` | int | 0x7f1503d5 | 32045 |
| `Widget_Material3_CardView_Outlined` | int | 0x7f1503d6 | 32048 |
| `Widget_Material3_CheckedTextView` | int | 0x7f1503d7 | 32051 |
| `Widget_Material3_Chip_Assist` | int | 0x7f1503d8 | 32054 |
| `Widget_Material3_Chip_Assist_Elevated` | int | 0x7f1503d9 | 32057 |
| `Widget_Material3_Chip_Filter` | int | 0x7f1503da | 32060 |
| `Widget_Material3_Chip_Filter_Elevated` | int | 0x7f1503db | 32063 |
| `Widget_Material3_Chip_Input` | int | 0x7f1503dc | 32066 |
| `Widget_Material3_Chip_Input_Elevated` | int | 0x7f1503dd | 32069 |
| `Widget_Material3_Chip_Input_Icon` | int | 0x7f1503de | 32072 |
| `Widget_Material3_Chip_Input_Icon_Elevated` | int | 0x7f1503df | 32075 |
| `Widget_Material3_Chip_Suggestion` | int | 0x7f1503e0 | 32078 |
| `Widget_Material3_Chip_Suggestion_Elevated` | int | 0x7f1503e1 | 32081 |
| `Widget_Material3_ChipGroup` | int | 0x7f1503e2 | 32084 |
| `Widget_Material3_CircularProgressIndicator` | int | 0x7f1503e3 | 32087 |
| `Widget_Material3_CircularProgressIndicator_ExtraSmall` | int | 0x7f1503e4 | 32090 |
| `Widget_Material3_CircularProgressIndicator_Medium` | int | 0x7f1503e5 | 32093 |
| `Widget_Material3_CircularProgressIndicator_Small` | int | 0x7f1503e6 | 32096 |
| `Widget_Material3_CollapsingToolbar` | int | 0x7f1503e7 | 32099 |
| `Widget_Material3_CollapsingToolbar_Large` | int | 0x7f1503e8 | 32102 |
| `Widget_Material3_CollapsingToolbar_Medium` | int | 0x7f1503e9 | 32105 |
| `Widget_Material3_CompoundButton_CheckBox` | int | 0x7f1503ea | 32108 |
| `Widget_Material3_CompoundButton_MaterialSwitch` | int | 0x7f1503eb | 32111 |
| `Widget_Material3_CompoundButton_RadioButton` | int | 0x7f1503ec | 32114 |
| `Widget_Material3_CompoundButton_Switch` | int | 0x7f1503ed | 32117 |
| `Widget_Material3_DrawerLayout` | int | 0x7f1503ee | 32120 |
| `Widget_Material3_ExtendedFloatingActionButton_Icon_Primary` | int | 0x7f1503ef | 32123 |
| `Widget_Material3_ExtendedFloatingActionButton_Icon_Secondary` | int | 0x7f1503f0 | 32126 |
| `Widget_Material3_ExtendedFloatingActionButton_Icon_Surface` | int | 0x7f1503f1 | 32129 |
| `Widget_Material3_ExtendedFloatingActionButton_Icon_Tertiary` | int | 0x7f1503f2 | 32132 |
| `Widget_Material3_ExtendedFloatingActionButton_Primary` | int | 0x7f1503f3 | 32135 |
| `Widget_Material3_ExtendedFloatingActionButton_Secondary` | int | 0x7f1503f4 | 32138 |
| `Widget_Material3_ExtendedFloatingActionButton_Surface` | int | 0x7f1503f5 | 32141 |
| `Widget_Material3_ExtendedFloatingActionButton_Tertiary` | int | 0x7f1503f6 | 32144 |
| `Widget_Material3_FloatingActionButton_Large_Primary` | int | 0x7f1503f7 | 32147 |
| `Widget_Material3_FloatingActionButton_Large_Secondary` | int | 0x7f1503f8 | 32150 |
| `Widget_Material3_FloatingActionButton_Large_Surface` | int | 0x7f1503f9 | 32153 |
| `Widget_Material3_FloatingActionButton_Large_Tertiary` | int | 0x7f1503fa | 32156 |
| `Widget_Material3_FloatingActionButton_Primary` | int | 0x7f1503fb | 32159 |
| `Widget_Material3_FloatingActionButton_Secondary` | int | 0x7f1503fc | 32162 |
| `Widget_Material3_FloatingActionButton_Small_Primary` | int | 0x7f1503fd | 32165 |
| `Widget_Material3_FloatingActionButton_Small_Secondary` | int | 0x7f1503fe | 32168 |
| `Widget_Material3_FloatingActionButton_Small_Surface` | int | 0x7f1503ff | 32171 |
| `Widget_Material3_FloatingActionButton_Small_Tertiary` | int | 0x7f150400 | 32174 |
| `Widget_Material3_FloatingActionButton_Surface` | int | 0x7f150401 | 32177 |
| `Widget_Material3_FloatingActionButton_Tertiary` | int | 0x7f150402 | 32180 |
| `Widget_Material3_Light_ActionBar_Solid` | int | 0x7f150403 | 32183 |
| `Widget_Material3_LinearProgressIndicator` | int | 0x7f150404 | 32186 |
| `Widget_Material3_MaterialButtonToggleGroup` | int | 0x7f150405 | 32189 |
| `Widget_Material3_MaterialCalendar` | int | 0x7f150406 | 32192 |
| `Widget_Material3_MaterialCalendar_Day` | int | 0x7f150407 | 32195 |
| `Widget_Material3_MaterialCalendar_Day_Invalid` | int | 0x7f150408 | 32198 |
| `Widget_Material3_MaterialCalendar_Day_Selected` | int | 0x7f150409 | 32201 |
| `Widget_Material3_MaterialCalendar_Day_Today` | int | 0x7f15040a | 32204 |
| `Widget_Material3_MaterialCalendar_DayOfWeekLabel` | int | 0x7f15040b | 32207 |
| `Widget_Material3_MaterialCalendar_DayTextView` | int | 0x7f15040c | 32210 |
| `Widget_Material3_MaterialCalendar_Fullscreen` | int | 0x7f15040d | 32213 |
| `Widget_Material3_MaterialCalendar_HeaderCancelButton` | int | 0x7f15040e | 32216 |
| `Widget_Material3_MaterialCalendar_HeaderDivider` | int | 0x7f15040f | 32219 |
| `Widget_Material3_MaterialCalendar_HeaderLayout` | int | 0x7f150410 | 32222 |
| `Widget_Material3_MaterialCalendar_HeaderLayout_Fullscreen` | int | 0x7f150411 | 32225 |
| `Widget_Material3_MaterialCalendar_HeaderSelection` | int | 0x7f150412 | 32228 |
| `Widget_Material3_MaterialCalendar_HeaderSelection_Fullscreen` | int | 0x7f150413 | 32231 |
| `Widget_Material3_MaterialCalendar_HeaderTitle` | int | 0x7f150414 | 32234 |
| `Widget_Material3_MaterialCalendar_HeaderToggleButton` | int | 0x7f150415 | 32237 |
| `Widget_Material3_MaterialCalendar_Item` | int | 0x7f150416 | 32240 |
| `Widget_Material3_MaterialCalendar_MonthNavigationButton` | int | 0x7f150417 | 32243 |
| `Widget_Material3_MaterialCalendar_MonthTextView` | int | 0x7f150418 | 32246 |
| `Widget_Material3_MaterialCalendar_Year` | int | 0x7f150419 | 32249 |
| `Widget_Material3_MaterialCalendar_Year_Selected` | int | 0x7f15041a | 32252 |
| `Widget_Material3_MaterialCalendar_Year_Today` | int | 0x7f15041b | 32255 |
| `Widget_Material3_MaterialCalendar_YearNavigationButton` | int | 0x7f15041c | 32258 |
| `Widget_Material3_MaterialDivider` | int | 0x7f15041d | 32261 |
| `Widget_Material3_MaterialDivider_Heavy` | int | 0x7f15041e | 32264 |
| `Widget_Material3_MaterialTimePicker` | int | 0x7f15041f | 32267 |
| `Widget_Material3_MaterialTimePicker_Button` | int | 0x7f150420 | 32270 |
| `Widget_Material3_MaterialTimePicker_Clock` | int | 0x7f150421 | 32273 |
| `Widget_Material3_MaterialTimePicker_Display` | int | 0x7f150422 | 32276 |
| `Widget_Material3_MaterialTimePicker_Display_Divider` | int | 0x7f150423 | 32279 |
| `Widget_Material3_MaterialTimePicker_Display_HelperText` | int | 0x7f150424 | 32282 |
| `Widget_Material3_MaterialTimePicker_Display_TextInputEditText` | int | 0x7f150425 | 32285 |
| `Widget_Material3_MaterialTimePicker_Display_TextInputLayout` | int | 0x7f150426 | 32288 |
| `Widget_Material3_MaterialTimePicker_ImageButton` | int | 0x7f150427 | 32291 |
| `Widget_Material3_NavigationRailView` | int | 0x7f150428 | 32294 |
| `Widget_Material3_NavigationRailView_ActiveIndicator` | int | 0x7f150429 | 32297 |
| `Widget_Material3_NavigationRailView_Badge` | int | 0x7f15042a | 32300 |
| `Widget_Material3_NavigationView` | int | 0x7f15042b | 32303 |
| `Widget_Material3_PopupMenu` | int | 0x7f15042c | 32306 |
| `Widget_Material3_PopupMenu_ContextMenu` | int | 0x7f15042d | 32309 |
| `Widget_Material3_PopupMenu_ListPopupWindow` | int | 0x7f15042e | 32312 |
| `Widget_Material3_PopupMenu_Overflow` | int | 0x7f15042f | 32315 |
| `Widget_Material3_Search_ActionButton_Overflow` | int | 0x7f150430 | 32318 |
| `Widget_Material3_Search_Toolbar_Button_Navigation` | int | 0x7f150431 | 32321 |
| `Widget_Material3_SearchBar` | int | 0x7f150432 | 32324 |
| `Widget_Material3_SearchBar_Outlined` | int | 0x7f150433 | 32327 |
| `Widget_Material3_SearchView` | int | 0x7f150434 | 32330 |
| `Widget_Material3_SearchView_Prefix` | int | 0x7f150435 | 32333 |
| `Widget_Material3_SearchView_Toolbar` | int | 0x7f150436 | 32336 |
| `Widget_Material3_SideSheet` | int | 0x7f150437 | 32339 |
| `Widget_Material3_SideSheet_Detached` | int | 0x7f150438 | 32342 |
| `Widget_Material3_SideSheet_Modal` | int | 0x7f150439 | 32345 |
| `Widget_Material3_SideSheet_Modal_Detached` | int | 0x7f15043a | 32348 |
| `Widget_Material3_Slider` | int | 0x7f15043b | 32351 |
| `Widget_Material3_Slider_Label` | int | 0x7f15043c | 32354 |
| `Widget_Material3_Snackbar` | int | 0x7f15043d | 32357 |
| `Widget_Material3_Snackbar_FullWidth` | int | 0x7f15043e | 32360 |
| `Widget_Material3_Snackbar_TextView` | int | 0x7f15043f | 32363 |
| `Widget_Material3_TabLayout` | int | 0x7f150440 | 32366 |
| `Widget_Material3_TabLayout_OnSurface` | int | 0x7f150441 | 32369 |
| `Widget_Material3_TabLayout_Secondary` | int | 0x7f150442 | 32372 |
| `Widget_Material3_TextInputEditText_FilledBox` | int | 0x7f150443 | 32375 |
| `Widget_Material3_TextInputEditText_FilledBox_Dense` | int | 0x7f150444 | 32378 |
| `Widget_Material3_TextInputEditText_OutlinedBox` | int | 0x7f150445 | 32381 |
| `Widget_Material3_TextInputEditText_OutlinedBox_Dense` | int | 0x7f150446 | 32384 |
| `Widget_Material3_TextInputLayout_FilledBox` | int | 0x7f150447 | 32387 |
| `Widget_Material3_TextInputLayout_FilledBox_Dense` | int | 0x7f150448 | 32390 |
| `Widget_Material3_TextInputLayout_FilledBox_Dense_ExposedDropdownMenu` | int | 0x7f150449 | 32393 |
| `Widget_Material3_TextInputLayout_FilledBox_ExposedDropdownMenu` | int | 0x7f15044a | 32396 |
| `Widget_Material3_TextInputLayout_OutlinedBox` | int | 0x7f15044b | 32399 |
| `Widget_Material3_TextInputLayout_OutlinedBox_Dense` | int | 0x7f15044c | 32402 |
| `Widget_Material3_TextInputLayout_OutlinedBox_Dense_ExposedDropdownMenu` | int | 0x7f15044d | 32405 |
| `Widget_Material3_TextInputLayout_OutlinedBox_ExposedDropdownMenu` | int | 0x7f15044e | 32408 |
| `Widget_Material3_Toolbar` | int | 0x7f15044f | 32411 |
| `Widget_Material3_Toolbar_OnSurface` | int | 0x7f150450 | 32414 |
| `Widget_Material3_Toolbar_Surface` | int | 0x7f150451 | 32417 |
| `Widget_Material3_Tooltip` | int | 0x7f150452 | 32420 |
| `Widget_MaterialComponents_ActionBar_Primary` | int | 0x7f150453 | 32423 |
| `Widget_MaterialComponents_ActionBar_PrimarySurface` | int | 0x7f150454 | 32426 |
| `Widget_MaterialComponents_ActionBar_Solid` | int | 0x7f150455 | 32429 |
| `Widget_MaterialComponents_ActionBar_Surface` | int | 0x7f150456 | 32432 |
| `Widget_MaterialComponents_ActionMode` | int | 0x7f150457 | 32435 |
| `Widget_MaterialComponents_AppBarLayout_Primary` | int | 0x7f150458 | 32438 |
| `Widget_MaterialComponents_AppBarLayout_PrimarySurface` | int | 0x7f150459 | 32441 |
| `Widget_MaterialComponents_AppBarLayout_Surface` | int | 0x7f15045a | 32444 |
| `Widget_MaterialComponents_AutoCompleteTextView_FilledBox` | int | 0x7f15045b | 32447 |
| `Widget_MaterialComponents_AutoCompleteTextView_FilledBox_Dense` | int | 0x7f15045c | 32450 |
| `Widget_MaterialComponents_AutoCompleteTextView_OutlinedBox` | int | 0x7f15045d | 32453 |
| `Widget_MaterialComponents_AutoCompleteTextView_OutlinedBox_Dense` | int | 0x7f15045e | 32456 |
| `Widget_MaterialComponents_Badge` | int | 0x7f15045f | 32459 |
| `Widget_MaterialComponents_BottomAppBar` | int | 0x7f150460 | 32462 |
| `Widget_MaterialComponents_BottomAppBar_Colored` | int | 0x7f150461 | 32465 |
| `Widget_MaterialComponents_BottomAppBar_PrimarySurface` | int | 0x7f150462 | 32468 |
| `Widget_MaterialComponents_BottomNavigationView` | int | 0x7f150463 | 32471 |
| `Widget_MaterialComponents_BottomNavigationView_Colored` | int | 0x7f150464 | 32474 |
| `Widget_MaterialComponents_BottomNavigationView_PrimarySurface` | int | 0x7f150465 | 32477 |
| `Widget_MaterialComponents_BottomSheet` | int | 0x7f150466 | 32480 |
| `Widget_MaterialComponents_BottomSheet_Modal` | int | 0x7f150467 | 32483 |
| `Widget_MaterialComponents_Button` | int | 0x7f150468 | 32486 |
| `Widget_MaterialComponents_Button_Icon` | int | 0x7f150469 | 32489 |
| `Widget_MaterialComponents_Button_OutlinedButton` | int | 0x7f15046a | 32492 |
| `Widget_MaterialComponents_Button_OutlinedButton_Icon` | int | 0x7f15046b | 32495 |
| `Widget_MaterialComponents_Button_TextButton` | int | 0x7f15046c | 32498 |
| `Widget_MaterialComponents_Button_TextButton_Dialog` | int | 0x7f15046d | 32501 |
| `Widget_MaterialComponents_Button_TextButton_Dialog_Flush` | int | 0x7f15046e | 32504 |
| `Widget_MaterialComponents_Button_TextButton_Dialog_Icon` | int | 0x7f15046f | 32507 |
| `Widget_MaterialComponents_Button_TextButton_Icon` | int | 0x7f150470 | 32510 |
| `Widget_MaterialComponents_Button_TextButton_Snackbar` | int | 0x7f150471 | 32513 |
| `Widget_MaterialComponents_Button_UnelevatedButton` | int | 0x7f150472 | 32516 |
| `Widget_MaterialComponents_Button_UnelevatedButton_Icon` | int | 0x7f150473 | 32519 |
| `Widget_MaterialComponents_CardView` | int | 0x7f150474 | 32522 |
| `Widget_MaterialComponents_CheckedTextView` | int | 0x7f150475 | 32525 |
| `Widget_MaterialComponents_Chip_Action` | int | 0x7f150476 | 32528 |
| `Widget_MaterialComponents_Chip_Choice` | int | 0x7f150477 | 32531 |
| `Widget_MaterialComponents_Chip_Entry` | int | 0x7f150478 | 32534 |
| `Widget_MaterialComponents_Chip_Filter` | int | 0x7f150479 | 32537 |
| `Widget_MaterialComponents_ChipGroup` | int | 0x7f15047a | 32540 |
| `Widget_MaterialComponents_CircularProgressIndicator` | int | 0x7f15047b | 32543 |
| `Widget_MaterialComponents_CircularProgressIndicator_ExtraSmall` | int | 0x7f15047c | 32546 |
| `Widget_MaterialComponents_CircularProgressIndicator_Medium` | int | 0x7f15047d | 32549 |
| `Widget_MaterialComponents_CircularProgressIndicator_Small` | int | 0x7f15047e | 32552 |
| `Widget_MaterialComponents_CollapsingToolbar` | int | 0x7f15047f | 32555 |
| `Widget_MaterialComponents_CompoundButton_CheckBox` | int | 0x7f150480 | 32558 |
| `Widget_MaterialComponents_CompoundButton_RadioButton` | int | 0x7f150481 | 32561 |
| `Widget_MaterialComponents_CompoundButton_Switch` | int | 0x7f150482 | 32564 |
| `Widget_MaterialComponents_ExtendedFloatingActionButton` | int | 0x7f150483 | 32567 |
| `Widget_MaterialComponents_ExtendedFloatingActionButton_Icon` | int | 0x7f150484 | 32570 |
| `Widget_MaterialComponents_FloatingActionButton` | int | 0x7f150485 | 32573 |
| `Widget_MaterialComponents_Light_ActionBar_Solid` | int | 0x7f150486 | 32576 |
| `Widget_MaterialComponents_LinearProgressIndicator` | int | 0x7f150487 | 32579 |
| `Widget_MaterialComponents_MaterialButtonToggleGroup` | int | 0x7f150488 | 32582 |
| `Widget_MaterialComponents_MaterialCalendar` | int | 0x7f150489 | 32585 |
| `Widget_MaterialComponents_MaterialCalendar_Day` | int | 0x7f15048a | 32588 |
| `Widget_MaterialComponents_MaterialCalendar_Day_Invalid` | int | 0x7f15048b | 32591 |
| `Widget_MaterialComponents_MaterialCalendar_Day_Selected` | int | 0x7f15048c | 32594 |
| `Widget_MaterialComponents_MaterialCalendar_Day_Today` | int | 0x7f15048d | 32597 |
| `Widget_MaterialComponents_MaterialCalendar_DayOfWeekLabel` | int | 0x7f15048e | 32600 |
| `Widget_MaterialComponents_MaterialCalendar_DayTextView` | int | 0x7f15048f | 32603 |
| `Widget_MaterialComponents_MaterialCalendar_Fullscreen` | int | 0x7f150490 | 32606 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderCancelButton` | int | 0x7f150491 | 32609 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderConfirmButton` | int | 0x7f150492 | 32612 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderDivider` | int | 0x7f150493 | 32615 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderLayout` | int | 0x7f150494 | 32618 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderLayout_Fullscreen` | int | 0x7f150495 | 32621 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderSelection` | int | 0x7f150496 | 32624 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderSelection_Fullscreen` | int | 0x7f150497 | 32627 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderTitle` | int | 0x7f150498 | 32630 |
| `Widget_MaterialComponents_MaterialCalendar_HeaderToggleButton` | int | 0x7f150499 | 32633 |
| `Widget_MaterialComponents_MaterialCalendar_Item` | int | 0x7f15049a | 32636 |
| `Widget_MaterialComponents_MaterialCalendar_MonthNavigationButton` | int | 0x7f15049b | 32639 |
| `Widget_MaterialComponents_MaterialCalendar_MonthTextView` | int | 0x7f15049c | 32642 |
| `Widget_MaterialComponents_MaterialCalendar_Year` | int | 0x7f15049d | 32645 |
| `Widget_MaterialComponents_MaterialCalendar_Year_Selected` | int | 0x7f15049e | 32648 |
| `Widget_MaterialComponents_MaterialCalendar_Year_Today` | int | 0x7f15049f | 32651 |
| `Widget_MaterialComponents_MaterialCalendar_YearNavigationButton` | int | 0x7f1504a0 | 32654 |
| `Widget_MaterialComponents_MaterialDivider` | int | 0x7f1504a1 | 32657 |
| `Widget_MaterialComponents_NavigationRailView` | int | 0x7f1504a2 | 32660 |
| `Widget_MaterialComponents_NavigationRailView_Colored` | int | 0x7f1504a3 | 32663 |
| `Widget_MaterialComponents_NavigationRailView_Colored_Compact` | int | 0x7f1504a4 | 32666 |
| `Widget_MaterialComponents_NavigationRailView_Compact` | int | 0x7f1504a5 | 32669 |
| `Widget_MaterialComponents_NavigationRailView_PrimarySurface` | int | 0x7f1504a6 | 32672 |
| `Widget_MaterialComponents_NavigationView` | int | 0x7f1504a7 | 32675 |
| `Widget_MaterialComponents_PopupMenu` | int | 0x7f1504a8 | 32678 |
| `Widget_MaterialComponents_PopupMenu_ContextMenu` | int | 0x7f1504a9 | 32681 |
| `Widget_MaterialComponents_PopupMenu_ListPopupWindow` | int | 0x7f1504aa | 32684 |
| `Widget_MaterialComponents_PopupMenu_Overflow` | int | 0x7f1504ab | 32687 |
| `Widget_MaterialComponents_ProgressIndicator` | int | 0x7f1504ac | 32690 |
| `Widget_MaterialComponents_ShapeableImageView` | int | 0x7f1504ad | 32693 |
| `Widget_MaterialComponents_Slider` | int | 0x7f1504ae | 32696 |
| `Widget_MaterialComponents_Snackbar` | int | 0x7f1504af | 32699 |
| `Widget_MaterialComponents_Snackbar_FullWidth` | int | 0x7f1504b0 | 32702 |
| `Widget_MaterialComponents_Snackbar_TextView` | int | 0x7f1504b1 | 32705 |
| `Widget_MaterialComponents_TabLayout` | int | 0x7f1504b2 | 32708 |
| `Widget_MaterialComponents_TabLayout_Colored` | int | 0x7f1504b3 | 32711 |
| `Widget_MaterialComponents_TabLayout_PrimarySurface` | int | 0x7f1504b4 | 32714 |
| `Widget_MaterialComponents_TextInputEditText_FilledBox` | int | 0x7f1504b5 | 32717 |
| `Widget_MaterialComponents_TextInputEditText_FilledBox_Dense` | int | 0x7f1504b6 | 32720 |
| `Widget_MaterialComponents_TextInputEditText_OutlinedBox` | int | 0x7f1504b7 | 32723 |
| `Widget_MaterialComponents_TextInputEditText_OutlinedBox_Dense` | int | 0x7f1504b8 | 32726 |
| `Widget_MaterialComponents_TextInputLayout_FilledBox` | int | 0x7f1504b9 | 32729 |
| `Widget_MaterialComponents_TextInputLayout_FilledBox_Dense` | int | 0x7f1504ba | 32732 |
| `Widget_MaterialComponents_TextInputLayout_FilledBox_Dense_ExposedDropdownMenu` | int | 0x7f1504bb | 32735 |
| `Widget_MaterialComponents_TextInputLayout_FilledBox_ExposedDropdownMenu` | int | 0x7f1504bc | 32738 |
| `Widget_MaterialComponents_TextInputLayout_OutlinedBox` | int | 0x7f1504bd | 32741 |
| `Widget_MaterialComponents_TextInputLayout_OutlinedBox_Dense` | int | 0x7f1504be | 32744 |
| `Widget_MaterialComponents_TextInputLayout_OutlinedBox_Dense_ExposedDropdownMenu` | int | 0x7f1504bf | 32747 |
| `Widget_MaterialComponents_TextInputLayout_OutlinedBox_ExposedDropdownMenu` | int | 0x7f1504c0 | 32750 |
| `Widget_MaterialComponents_TextView` | int | 0x7f1504c1 | 32753 |
| `Widget_MaterialComponents_TimePicker` | int | 0x7f1504c2 | 32756 |
| `Widget_MaterialComponents_TimePicker_Button` | int | 0x7f1504c3 | 32759 |
| `Widget_MaterialComponents_TimePicker_Clock` | int | 0x7f1504c4 | 32762 |
| `Widget_MaterialComponents_TimePicker_Display` | int | 0x7f1504c5 | 32765 |
| `Widget_MaterialComponents_TimePicker_Display_Divider` | int | 0x7f1504c6 | 32768 |
| `Widget_MaterialComponents_TimePicker_Display_HelperText` | int | 0x7f1504c7 | 32771 |
| `Widget_MaterialComponents_TimePicker_Display_TextInputEditText` | int | 0x7f1504c8 | 32774 |
| `Widget_MaterialComponents_TimePicker_Display_TextInputLayout` | int | 0x7f1504c9 | 32777 |
| `Widget_MaterialComponents_TimePicker_ImageButton` | int | 0x7f1504ca | 32780 |
| `Widget_MaterialComponents_TimePicker_ImageButton_ShapeAppearance` | int | 0x7f1504cb | 32783 |
| `Widget_MaterialComponents_Toolbar` | int | 0x7f1504cc | 32786 |
| `Widget_MaterialComponents_Toolbar_Primary` | int | 0x7f1504cd | 32789 |
| `Widget_MaterialComponents_Toolbar_PrimarySurface` | int | 0x7f1504ce | 32792 |
| `Widget_MaterialComponents_Toolbar_Surface` | int | 0x7f1504cf | 32795 |
| `Widget_MaterialComponents_Tooltip` | int | 0x7f1504d0 | 32798 |
| `Widget_Support_CoordinatorLayout` | int | 0x7f1504d1 | 32801 |

### `com.gku.xtugo.R$xml`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `network_config_base` | int | 0x7f170001 | 33049 |
| `paths_base` | int | 0x7f170003 | 33052 |
| `ps_file_paths` | int | 0x7f170005 | 33055 |

### `com.hisi.hisiFW.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "release" | 5 |
| `DEBUG` | boolean | false | 6 |
| `LIBRARY_PACKAGE_NAME` | String | "com.hisi.hisiFW" | 7 |

### `com.hisi.hisiFW.FwUpload`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HOST` | String | "192.168.0.1" | 16 |
| `PORT` | int | 8080 | 17 |
| `TIME_OUT` | int | 5000 | 18 |

### `com.icatchtek.control.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "debug" | 5 |
| `DEBUG` | boolean | true | 6 |
| `LIBRARY_PACKAGE_NAME` | String | "com.icatchtek.control" | 7 |
| `VERSION_CODE` | int | 1 | 8 |
| `VERSION_NAME` | String | "1.0" | 9 |

### `com.icatchtek.control.core.CoreMulticast`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MULTI_CAST_ADDR` | String | "234.168.168.168" | 15 |
| `MULTI_CAST_PORT` | int | 5002 | 16 |

### `com.icatchtek.control.core.feature.ICatchCameraAssistImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TRANSPORT_TYPE_MSDC_SCSI` | int | 4 | 30 |
| `TRANSPORT_TYPE_NET_COMMON` | int | 1 | 31 |
| `TRANSPORT_TYPE_UVC_BULK` | int | 3 | 32 |
| `TRANSPORT_TYPE_UVC_ISO` | int | 2 | 33 |

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
| `intelArch` | String | "x86" | 8 |
| `neonArmArchArray` | String[] | {"armv7a", "armeabi-v7a"} | 9 |

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
| `ORIENTATION_FLIP_HORIZONTAL` | int | 2 | 17 |
| `ORIENTATION_FLIP_VERTICAL` | int | 4 | 18 |
| `ORIENTATION_NORMAL` | int | 1 | 19 |
| `ORIENTATION_ROTATE_180` | int | 3 | 20 |
| `ORIENTATION_ROTATE_270` | int | 8 | 21 |
| `ORIENTATION_ROTATE_90` | int | 6 | 22 |
| `ORIENTATION_TRANSPOSE` | int | 5 | 23 |
| `ORIENTATION_TRANSVERSE` | int | 7 | 24 |
| `ORIENTATION_UNDEFINED` | int | 0 | 25 |
| `TAG_APERTURE` | String | "FNumber" | 26 |
| `TAG_DATETIME` | String | "DateTime" | 27 |
| `TAG_EXPOSURE_TIME` | String | "ExposureTime" | 28 |
| `TAG_FLASH` | String | "Flash" | 29 |
| `TAG_FOCAL_LENGTH` | String | "FocalLength" | 30 |
| `TAG_GPS_ALTITUDE` | String | "GPSAltitude" | 31 |
| `TAG_GPS_ALTITUDE_REF` | String | "GPSAltitudeRef" | 32 |
| `TAG_GPS_DATESTAMP` | String | "GPSDateStamp" | 33 |
| `TAG_GPS_LATITUDE` | String | "GPSLatitude" | 34 |
| `TAG_GPS_LATITUDE_REF` | String | "GPSLatitudeRef" | 35 |
| `TAG_GPS_LONGITUDE` | String | "GPSLongitude" | 36 |
| `TAG_GPS_LONGITUDE_REF` | String | "GPSLongitudeRef" | 37 |
| `TAG_GPS_PROCESSING_METHOD` | String | "GPSProcessingMethod" | 38 |
| `TAG_GPS_TIMESTAMP` | String | "GPSTimeStamp" | 39 |
| `TAG_IMAGE_LENGTH` | String | "ImageLength" | 40 |
| `TAG_IMAGE_WIDTH` | String | "ImageWidth" | 41 |
| `TAG_ISO` | String | "ISOSpeedRatings" | 42 |
| `TAG_MAKE` | String | "Make" | 43 |
| `TAG_MODEL` | String | "Model" | 44 |
| `TAG_ORIENTATION` | String | "Orientation" | 45 |
| `TAG_WHITE_BALANCE` | String | "WhiteBalance" | 46 |
| `WHITEBALANCE_AUTO` | int | 0 | 47 |
| `WHITEBALANCE_MANUAL` | int | 1 | 48 |

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
| `BUILD_TYPE` | String | "debug" | 5 |
| `DEBUG` | boolean | true | 6 |
| `LIBRARY_PACKAGE_NAME` | String | "com.icatchtek.pancam" | 7 |
| `VERSION_CODE` | int | 1 | 8 |
| `VERSION_NAME` | String | "1.0" | 9 |

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
| `TYPE_ALL` | int | 15 | 17 |
| `TYPE_AUDIO` | int | 4 | 18 |
| `TYPE_IMAGE` | int | 1 | 19 |
| `TYPE_TEXT` | int | 8 | 20 |
| `TYPE_UNKNOWN` | int | 16 | 21 |
| `TYPE_VIDEO` | int | 2 | 22 |

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
| `BUILD_TYPE` | String | "debug" | 5 |
| `DEBUG` | boolean | true | 6 |
| `LIBRARY_PACKAGE_NAME` | String | "com.icatchtek.reliant" | 7 |
| `VERSION_CODE` | int | 1 | 8 |
| `VERSION_NAME` | String | "1.0" | 9 |

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
| `DEFAULT_AUDIO_STREAM_NO` | int | 0 | 8 |

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

### `com.sherlockshi.widget.SherlockSpinner`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEF_LINE_COLOR` | int | -12627531 | 20 |

### `icatch.AppMessage`

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
| `MESSAGE_STREAM_CLOSED` | int | 1543 | 33 |
| `MESSAGE_UPDATE_VIDEOPB_BAR` | int | 1540 | 34 |
| `MESSAGE_VIDEO_STREAM_NO_EIS_INFORMATION` | int | 1542 | 35 |
| `MESSAGE_VIDEO_STREAM_STOP` | int | 1544 | 36 |
| `MPB_ACTIVITY` | int | 768 | 37 |
| `PHOTO_PBACTIVITY` | int | 1024 | 38 |
| `PREVIEW_ACTIVITY` | int | 512 | 39 |
| `SETTING_OPTION_AUTO_DOWNLOAD` | int | 513 | 40 |
| `UPDATE_LOADING_PROGRESS` | int | 770 | 41 |
| `UPDATE_TOTAL_PROGRESS` | int | 773 | 42 |
| `VIDEO_PBACTIVITY` | int | 1280 | 43 |

### `icatch.PanoramaPreviewPlayback`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaPreviewPlayback" | 37 |

### `icatch.PanoramaVideoPlayback`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "PanoramaVideoPlayback" | 27 |

### `icatch.PreviewLaunchMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RT_PREVIEW_MODE` | int | 2 | 5 |
| `VIDEO_PB_MODE` | int | 1 | 6 |

### `icatch.SDKEvent`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EVENT_BATTERY_ELETRIC_CHANGED` | int | 0 | 14 |
| `EVENT_BURST_NUM_CHANGE` | int | 110 | 15 |
| `EVENT_CAPTURE_COMPLETED` | int | 1 | 16 |
| `EVENT_CAPTURE_START` | int | 3 | 17 |
| `EVENT_CONNECTION_FAILURE` | int | 8 | 18 |
| `EVENT_FILE_ADDED` | int | 7 | 19 |
| `EVENT_FILE_DOWNLOAD` | int | 11 | 20 |
| `EVENT_FW_UPDATE_CHECK` | int | 18 | 21 |
| `EVENT_FW_UPDATE_CHKSUMERR` | int | 19 | 22 |
| `EVENT_FW_UPDATE_COMPLETED` | int | 13 | 23 |
| `EVENT_FW_UPDATE_NG` | int | 20 | 24 |
| `EVENT_FW_UPDATE_POWEROFF` | int | 14 | 25 |
| `EVENT_SD_CARD_FULL` | int | 4 | 28 |
| `EVENT_SDCARD_INSERT` | int | 17 | 26 |
| `EVENT_SDCARD_REMOVED` | int | 16 | 27 |
| `EVENT_SEARCHED_NEW_CAMERA` | int | 15 | 29 |
| `EVENT_SERVER_STREAM_ERROR` | int | 10 | 30 |
| `EVENT_TIME_LAPSE_STOP` | int | 9 | 31 |
| `EVENT_VIDEO_OFF` | int | 5 | 32 |
| `EVENT_VIDEO_ON` | int | 6 | 33 |
| `EVENT_VIDEO_PLAY_CLOSED` | int | 24 | 34 |
| `EVENT_VIDEO_PLAY_PTS` | int | 23 | 35 |
| `EVENT_VIDEO_RECORDING_TIME` | int | 12 | 36 |
| `TAG` | String | "SDKEvent" | 37 |

### `icatch.streaming.H264DecoderThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "H264DecoderThread" | 21 |

### `icatch.streaming.MjpgDecoderThread`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "MjpgDecoderThread" | 21 |

### `icatch.Tristate`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ABNORMAL` | int | 4 | 5 |
| `FALSE` | int | 1 | 6 |
| `NORMAL` | int | 2 | 7 |
| `SIZE_NOT_SUPPORT` | int | 3 | 8 |

### `m.mifan.acase.BuildConfig`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BUILD_TYPE` | String | "release" | 5 |
| `DEBUG` | boolean | false | 6 |
| `LIBRARY_PACKAGE_NAME` | String | "m.mifan.acase" | 7 |

### `m.mifan.acase.core.CaseKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ActionAutoCaptureStart` | int | 5 | 10 |
| `ActionAutoCaptureStop` | int | 6 | 11 |
| `ActionLongExposureShotStart` | int | 10 | 12 |
| `ActionLongExposureShotStop` | int | 11 | 13 |
| `ActionNone` | int | 9 | 14 |
| `ActionOneShot` | int | 3 | 15 |
| `ActionOneShotTimer` | int | 4 | 16 |
| `ActionShutCaptureStart` | int | 7 | 17 |
| `ActionShutCaptureStop` | int | 8 | 18 |
| `ActionStart` | int | 1 | 19 |
| `ActionStop` | int | 2 | 20 |
| `BATTERY_CHARGE` | int | 5 | 21 |
| `BATTERY_EMPTY` | int | 0 | 22 |
| `BATTERY_HEIGHT` | int | 2 | 23 |
| `BATTERY_LOW` | int | 4 | 24 |
| `BATTERY_MAX` | int | 1 | 25 |
| `BATTERY_MID` | int | 3 | 26 |
| `BATTERY_UNAVAILABLE` | int | -1 | 27 |
| `CASE_MODE_NONE` | int | -1 | 28 |
| `CASE_MODE_PHOTO` | int | 5 | 29 |
| `CASE_MODE_PHOTO_AUTO` | int | 8 | 30 |
| `CASE_MODE_PHOTO_BLURT` | int | 7 | 31 |
| `CASE_MODE_PHOTO_TIMER` | int | 6 | 32 |
| `CASE_MODE_VIDEO` | int | 1 | 33 |
| `CASE_MODE_VIDEO_LOOP` | int | 3 | 34 |
| `CASE_MODE_VIDEO_SLOW` | int | 2 | 35 |
| `CASE_MODE_VIDEO_TIMELAPSE` | int | 4 | 36 |
| `MEDIA_TYPE_ALL` | int | -1 | 37 |
| `MEDIA_TYPE_NONE` | int | 0 | 38 |
| `MEDIA_TYPE_PHOTO` | int | 1 | 39 |
| `MEDIA_TYPE_VIDEO` | int | 2 | 40 |
| `PAGE_SIZE` | int | 500 | 41 |
| `PARAM_TYPE_LIST` | int | 1 | 42 |
| `PARAM_TYPE_SDCARD` | int | 3 | 43 |
| `PARAM_TYPE_SWITCH` | int | 2 | 44 |
| `SHUTTER_ERROR_CODE_NOCARD` | int | 1 | 45 |
| `SHUTTER_ERROR_CODE_NONE` | int | 0 | 46 |
| `SHUTTER_ERROR_CODE_STORAGE_FULL` | int | 2 | 47 |
| `SHUTTER_MODE_NONE` | int | -1 | 48 |
| `SHUTTER_MODE_PHOTO` | int | 5 | 49 |
| `SHUTTER_MODE_PHOTO_AUTO` | int | 8 | 51 |
| `SHUTTER_MODE_PHOTO_TIMER` | int | 6 | 52 |
| `SHUTTER_MODE_PHOTOT_BLURT` | int | 7 | 50 |
| `SHUTTER_MODE_VIDEO` | int | 1 | 53 |
| `SHUTTER_MODE_VIDEO_LOOP` | int | 3 | 54 |
| `SHUTTER_MODE_VIDEO_SLOW` | int | 2 | 55 |
| `SHUTTER_MODE_VIDEO_TIMELAPSE` | int | 4 | 56 |
| `UIActionDialog` | int | 6 | 57 |
| `UICustom` | int | -1 | 58 |
| `UIInput` | int | 7 | 59 |
| `UIList` | int | 1 | 60 |
| `UINone` | int | -1 | 61 |
| `UIReset` | int | 5 | 62 |
| `UISDFormat` | int | 4 | 63 |
| `UISwitch` | int | 2 | 64 |
| `UIText` | int | 3 | 65 |
| `UIWifiSet` | int | 8 | 66 |

### `m.mifan.acase.core.LogUtilsKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LOG_TAG` | String | "QSCamera->" | 14 |
| `logSaveLocal` | boolean | false | 16 |

### `m.mifan.acase.core.preferences.PreferenceAdapterKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ITEM_TYPE_HEADER` | int | 1 | 12 |

### `m.mifan.acase.core.preferences.PreferenceBuilderKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `UIAction` | String | "UIAction" | 9 |
| `UIHeader` | String | "UIHeader" | 10 |
| `UIInput` | String | "UIInput" | 11 |
| `UIList` | String | "UIList" | 12 |
| `UIReset` | String | "UIReset" | 13 |
| `UISDFormat` | String | "UISDFormat" | 14 |
| `UISwitch` | String | "UISwitch" | 15 |
| `UIText` | String | "UIText" | 16 |

### `m.mifan.acase.core.SocketHelper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `STATE_CLOSE` | int | 3 | 13 |
| `STATE_CONNECINT` | int | 1 | 14 |
| `STATE_NULL` | int | 0 | 15 |
| `STATE_SUCC` | int | 2 | 16 |

### `m.mifan.acase.icatch.IcatchCaseKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `API_HOST_ICATCH` | String | "192.168.1.1" | 9 |
| `CARD_STATE_INSERTED` | int | 1 | 10 |
| `CARD_STATE_LOCKED` | int | 2 | 11 |
| `CARD_STATE_REMOVE` | int | 0 | 12 |
| `CUSTOM_MODE_LAPSE_PHOTO` | int | 3 | 13 |
| `CUSTOM_MODE_LAPSE_VIDEO` | int | 2 | 14 |
| `CUSTOM_MODE_PHOTO` | int | 1 | 15 |
| `CUSTOM_MODE_VIDEO` | int | 0 | 16 |

### `m.mifan.acase.icatch.ICatchEventID`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ICATCH_EVENT_DEVICE_SCAN_ADD` | int | 85 | 9 |
| `ICH_EVENT_AUDIO_PLAYBACK_CACHING_CHANGED` | int | 72 | 10 |
| `ICH_EVENT_AUDIO_PLAYBACK_CACHING_PROGRESS` | int | 71 | 11 |
| `ICH_EVENT_AUDIO_STREAM_PLAYING_ENDED` | int | 68 | 12 |
| `ICH_EVENT_AUDIO_STREAM_STATUS` | int | 89 | 13 |
| `ICH_EVENT_BATTERY_LEVEL_CHANGED` | int | 36 | 14 |
| `ICH_EVENT_BURST_NUMBER_PROP_CHANGED` | int | 55 | 15 |
| `ICH_EVENT_CAPTURE_COMPLETE` | int | 35 | 16 |
| `ICH_EVENT_CAPTURE_DELAY_PROP_CHANGED` | int | 51 | 17 |
| `ICH_EVENT_CAPTURE_START` | int | 82 | 18 |
| `ICH_EVENT_CONNECTION_DISCONNECTED` | int | 74 | 19 |
| `ICH_EVENT_CONNECTION_INITIALIZE_FAILED` | int | 76 | 20 |
| `ICH_EVENT_CONNECTION_INITIALIZE_SUCCEED` | int | 75 | 21 |
| `ICH_EVENT_DEVICE_INFO_CHANGED` | int | 49 | 22 |
| `ICH_EVENT_FILE_ADDED` | int | 1 | 23 |
| `ICH_EVENT_FILE_DOWNLOAD` | int | 103 | 24 |
| `ICH_EVENT_FILE_INFO_CHANGED` | int | 3 | 25 |
| `ICH_EVENT_FILE_REMOVED` | int | 2 | 26 |
| `ICH_EVENT_FW_UPDATE_CHECK` | int | 96 | 27 |
| `ICH_EVENT_FW_UPDATE_CHKSUMERR` | int | 99 | 28 |
| `ICH_EVENT_FW_UPDATE_COMPLETED` | int | 97 | 29 |
| `ICH_EVENT_FW_UPDATE_NG` | int | 100 | 30 |
| `ICH_EVENT_FW_UPDATE_POWEROFF` | int | 98 | 31 |
| `ICH_EVENT_IMAGE_SIZE_PROP_CHANGED` | int | 52 | 32 |
| `ICH_EVENT_LIGHT_FREQUENCY_PROP_CHANGED` | int | 54 | 33 |
| `ICH_EVENT_MEDIA_STREAM_CLOSED` | int | 66 | 34 |
| `ICH_EVENT_SDCARD_ERROR` | int | 18 | 35 |
| `ICH_EVENT_SDCARD_FULL` | int | 17 | 36 |
| `ICH_EVENT_SDCARD_INFO_CHANGED` | int | 20 | 37 |
| `ICH_EVENT_SDCARD_REMOVED` | int | 19 | 38 |
| `ICH_EVENT_SERVER_STREAM_ERROR` | int | 65 | 39 |
| `ICH_EVENT_TIMELAPSE_START` | int | 80 | 40 |
| `ICH_EVENT_TIMELAPSE_STOP` | int | 81 | 41 |
| `ICH_EVENT_TUTK_MODE_CHANGED` | int | 86 | 42 |
| `ICH_EVENT_TUTK_SETUP_PROGRESS` | int | 87 | 43 |
| `ICH_EVENT_UNDEFINED` | int | 255 | 44 |
| `ICH_EVENT_VIDEO_OFF` | int | 34 | 45 |
| `ICH_EVENT_VIDEO_ON` | int | 33 | 46 |
| `ICH_EVENT_VIDEO_PLAYBACK_CACHING_CHANGED` | int | 70 | 47 |
| `ICH_EVENT_VIDEO_PLAYBACK_CACHING_PROGRESS` | int | 69 | 48 |
| `ICH_EVENT_VIDEO_SIZE_PROP_CHANGED` | int | 53 | 49 |
| `ICH_EVENT_VIDEO_STREAM_PLAYING_ENDED` | int | 67 | 50 |
| `ICH_EVENT_VIDEO_STREAM_STATUS` | int | 88 | 51 |
| `ICH_EVENT_VIDEO_THUMB_DONE` | int | 105 | 52 |
| `ICH_EVENT_VIDEO_THUMB_READY` | int | 104 | 53 |
| `ICH_EVENT_VIDEO_TRIM_DONE` | int | 106 | 54 |
| `ICH_EVENT_WHITE_BALANCE_PROP_CHANGED` | int | 50 | 55 |

### `m.mifan.acase.icatch.PropertyIdKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `APP_PTP_DPC_BATTERY_LEVEL` | int | 55080 | 9 |
| `AUTO_POWER_OFF` | int | 55073 | 10 |
| `BURST_PHOTO` | int | 20504 | 11 |
| `CAMERA_CONNECT_CHANGE` | int | 55201 | 12 |
| `CAMERA_CURRENT_FOCAL` | int | 20502 | 13 |
| `CAMERA_CURRENT_MODEL` | int | 55235 | 14 |
| `CAMERA_CURRENT_RESOLVING` | int | 55214 | 15 |
| `CAMERA_DATE` | int | 20497 | 16 |
| `CAMERA_DATE_TIMEZONE` | int | 55358 | 17 |
| `CAMERA_ESSID` | int | 55356 | 18 |
| `CAMERA_LED_OFF` | int | 55232 | 19 |
| `CAMERA_NAME` | int | 55345 | 20 |
| `CAMERA_PASSWORD` | int | 55357 | 21 |
| `CAMERA_PASSWORD_NEW` | int | 55346 | 22 |
| `CAMERA_PB_LIMIT_NUMBER` | int | 55359 | 23 |
| `CAMERA_RED_DOT` | int | 55234 | 24 |
| `CAMERA_VIBRATION` | int | 55233 | 25 |
| `CAPTURE_DELAY_MODE` | int | 55280 | 26 |
| `CAPTURE_ISO` | int | 55145 | 27 |
| `CAR_MODE` | int | 55137 | 28 |
| `CUSTOM_IMAGE_SIZE` | int | 55090 | 29 |
| `CUSTOM_VIDEO_SIZE` | int | 55089 | 30 |
| `DATE_STAMP` | int | 54791 | 31 |
| `DELAYED_PHOTO` | int | 20498 | 32 |
| `ESSID_NAME` | int | 55348 | 33 |
| `ESSID_PASSWORD` | int | 55349 | 34 |
| `EXPOSURE_COMPENSATION` | int | 55075 | 35 |
| `FACEBOOK_LIVE` | int | 55350 | 36 |
| `FAST_MOTION_MOVIE` | int | 55078 | 37 |
| `FORMAT` | int | 111111113 | 38 |
| `GET_MODE` | int | 55088 | 39 |
| `GKU_SYS_VIDEO_PV_ROTATE` | int | 55081 | 40 |
| `IMAGE_BEAUTIFY` | int | 55148 | 41 |
| `IMAGE_FLIP` | int | 55151 | 42 |
| `IMAGE_QUALITY` | int | 55146 | 43 |
| `IMAGE_SHARPNESS` | int | 55147 | 44 |
| `IMAGE_SIZE` | int | 20483 | 45 |
| `IMAGE_STABILIZATION` | int | 55076 | 46 |
| `IMAGE_STABILIZATION_ENABLE` | int | 55237 | 47 |
| `LIGHT_FREQUENCY` | int | 54790 | 48 |
| `LONG_EXPOSURE` | int | 55150 | 49 |
| `METERING_MODE` | int | 55149 | 50 |
| `MOTION_DETECT` | int | 55138 | 51 |
| `NEW_SLOW_MOTION` | int | 55142 | 52 |
| `NOTIFY_FW_TO_SHARE_MODE` | int | 55291 | 53 |
| `POWER_ON_AUTO_RECORD` | int | 55074 | 54 |
| `SCREEN_SAVER` | int | 55072 | 55 |
| `SERVICE_ESSID` | int | 55350 | 56 |
| `SERVICE_PASSWORD` | int | 55351 | 57 |
| `SET_DEFAULT` | int | 55224 | 58 |
| `SLOW_MOTION` | int | 54805 | 59 |
| `SLOW_MOTION_ENABLE` | int | 55238 | 60 |
| `TIME_LAPSE_DURATION` | int | 98002 | 63 |
| `TIME_LAPSE_INTERVAL` | int | 98001 | 64 |
| `TIMELAPSE_MODE` | int | 60928 | 61 |
| `TIMELAPSE_VIDEO_SIZE_LIST_MASK` | int | 55291 | 62 |
| `UP_SIDE` | int | 54804 | 65 |
| `VIDEO_FILE_LENGTH` | int | 55077 | 66 |
| `VIDEO_FLIP` | int | 55152 | 67 |
| `VIDEO_FLIPPING` | int | 55236 | 68 |
| `VIDEO_QUALITY` | int | 55144 | 69 |
| `VIDEO_RECORDING_TIME` | int | 55293 | 70 |
| `VIDEO_SIZE` | int | 54789 | 71 |
| `VIDEO_SIZE_FLOW` | int | 55292 | 72 |
| `VOICE` | int | 111111112 | 73 |
| `VOICE_REC` | int | 55139 | 74 |
| `WHITE_BALANCE` | int | 20485 | 75 |
| `WIFISET` | int | 111111114 | 76 |
| `WIND_NOISE_REDUCTION` | int | 55079 | 77 |
