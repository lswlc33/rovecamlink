# idGoLive — 枚举常量全量目录

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 80 个枚举常量，分布在 23 个枚举类型；括号内是构造实参（命令号、端口、路径等）

---

### `com.icatch.golive.data.Mode.LiveMode`

| 常量 | 实参 | 行 |
|---|---|---|
| `MODE_YOUTUBE_LIVE` |  | 5 |
| `MODE_FACEBOOK_LIVE` |  | 6 |
| `MODE_OTHER_LIVE` |  | 7 |

### `com.icatch.golive.data.Mode.OperationMode`

| 常量 | 实参 | 行 |
|---|---|---|
| `MODE_BROWSE` |  | 5 |

### `com.icatch.golive.data.Mode.TouchMode`

| 常量 | 实参 | 行 |
|---|---|---|
| `MOVE` |  | 5 |
| `DRAG` |  | 6 |
| `NONE` |  | 7 |

### `com.icatch.golive.data.Mode.VideoPbMode`

| 常量 | 实参 | 行 |
|---|---|---|
| `MODE_VIDEO_PLAY` |  | 5 |
| `MODE_VIDEO_IDLE` |  | 6 |

### `com.icatch.golive.data.type.FileType`

| 常量 | 实参 | 行 |
|---|---|---|
| `FILE_VIDEO` |  | 5 |
| `FILE_PHOTO` |  | 6 |

### `com.icatch.golive.data.type.PhotoWallLayoutType`

| 常量 | 实参 | 行 |
|---|---|---|
| `PREVIEW_TYPE_LIST` |  | 5 |
| `PREVIEW_TYPE_GRID` |  | 6 |

### `com.icatch.golive.data.type.Tristate`

| 常量 | 实参 | 行 |
|---|---|---|
| `FALSE` |  | 5 |
| `NORMAL` |  | 6 |
| `SIZE_NOT_SUPPORT` |  | 7 |

### `com.icatch.golive.Function.streaming.RenderType`

| 常量 | 实参 | 行 |
|---|---|---|
| `NO_RENDER` |  | 5 |
| `PANORAMA_RENDER` |  | 6 |

### `com.icatch.golive.Listener.MyOrientoinListener$ScreenOrientation`

| 常量 | 实参 | 行 |
|---|---|---|
| `SCREEN_ORIENTATION_PORTRAIT` |  | 16 |
| `SCREEN_ORIENTATION_REVERSE_PORTRAIT` |  | 17 |
| `SCREEN_ORIENTATION_LANDSCAPE` |  | 18 |

### `com.icatch.golive.ui.ExtendComponent.DragImageView$MODE`

| 常量 | 实参 | 行 |
|---|---|---|
| `NONE` |  | 48 |
| `DRAG` |  | 49 |

### `com.icatch.golive.ui.ExtendComponent.NumberProgressBar$ProgressTextVisibility`

| 常量 | 实参 | 行 |
|---|---|---|
| `Visible` |  | 67 |

### `com.icatch.golive.utils.WifiAPUtil$WifiSecurityType`

| 常量 | 实参 | 行 |
|---|---|---|
| `WIFICIPHER_NOPASS` |  | 84 |
| `WIFICIPHER_WPA` |  | 85 |
| `WIFICIPHER_WEP` |  | 86 |
| `WIFICIPHER_INVALID` |  | 87 |

### `com.icatchtek.baseutil.imageloader.ImageUri`

| 常量 | 实参 | 行 |
|---|---|---|
| `HTTP` | "http" | 11 |
| `HTTPS` | TournamentShareDialogURIBuilder.scheme | 12 |
| `FILE` | ShareInternalUtility.STAGING_PARAM | 13 |
| `CONTENT` | "content" | 14 |
| `ASSETS` | "assets" | 15 |
| `DRAWABLE` | "drawable" | 16 |
| `DATABASE` | "database" | 17 |
| `TUTK` | "tutk" | 18 |
| `MSGFILE` | "msgfile" | 19 |
| `DEVICEMSGFILE` | "devicemsgfile" | 20 |
| `UNKNOWN` | "<binary/metadata>" | 21 |
| `ImageUri` | String str | 26 |
| `for` | String str2 : str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR) | 48 |
| `if` | strArrSplit.length == 2 && strArrSplit[0].equals("uid") | 50 |
| `for` | String str2 : str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR) | 58 |
| `if` | strArrSplit.length == 2 && strArrSplit[0].equals("msgid") | 60 |
| `if` | str != null | 68 |
| `for` | ImageUri imageUri : values() | 69 |
| `if` | imageUri.belongsTo(str) | 70 |
| `for` | String str3 : str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR) | 81 |
| `if` | strArrSplit.length == 2 | 83 |
| `if` | strArrSplit[0].equals("uid") | 84 |
| `if` | belongsTo(str) | 98 |
| `if` | this == DEVICEMSGFILE | 105 |
| `if` | this == imageUri | 121 |
| `if` | this == imageUri2 \|\| this == (imageUri = DATABASE) | 130 |
| `if` | this == imageUri | 138 |

### `com.icatchtek.bluetooth.core.base.BluetoothLogger$AppLogLevel`

| 常量 | 实参 | 行 |
|---|---|---|
| `APP_LOG_INFO` |  | 33 |
| `APP_LOG_WARN` |  | 34 |

### `com.icatchtek.bluetooth.customer.type.ICatchWifiEncType`

| 常量 | 实参 | 行 |
|---|---|---|
| `ICATCH_WIFI_AP_ENC_TYPE_NON` |  | 5 |
| `ICATCH_WIFI_AP_ENC_TYPE_WPA` |  | 6 |

### `com.tinyai.libmediacomponent.components.filelist.OperationMode`

| 常量 | 实参 | 行 |
|---|---|---|
| `MODE_BROWSE` |  | 5 |

### `com.tinyai.libmediacomponent.components.media.type.TouchMode`

| 常量 | 实参 | 行 |
|---|---|---|
| `MOVE` |  | 5 |
| `DRAG` |  | 6 |
| `NONE` |  | 7 |

### `com.tinyai.libmediacomponent.components.media.type.VideoPbMode`

| 常量 | 实参 | 行 |
|---|---|---|
| `MODE_VIDEO_PLAY` |  | 5 |
| `MODE_VIDEO_IDLE` |  | 6 |

### `com.tinyai.libmediacomponent.components.setting.SettingItemType`

| 常量 | 实参 | 行 |
|---|---|---|
| `SETTING_TYPE_SWITCH` |  | 5 |
| `SETTING_TYPE_ARROW` |  | 6 |

### `com.tinyai.libmediacomponent.engine.streaming.render.H264DecodeThread$DecoderOperation`

| 常量 | 实参 | 行 |
|---|---|---|
| `set` |  | 30 |
| `freeze` |  | 31 |

### `com.tinyai.libmediacomponent.engine.streaming.render.H264DecodeThread$DecoderState`

| 常量 | 实参 | 行 |
|---|---|---|
| `notReady` |  | 36 |
| `ready` |  | 37 |
| `run` |  | 38 |
| `freezed` |  | 39 |

### `com.tinyai.libmediacomponent.engine.streaming.type.PlayState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDEA` |  | 5 |
| `PLAY` |  | 6 |
| `PAUSE` |  | 7 |

### `com.tinyai.libmediacomponent.engine.streaming.type.VideoQuality`

| 常量 | 实参 | 行 |
|---|---|---|
| `VIDEO_QUALITY_SMOOTH` | 0 | 5 |
| `VIDEO_QUALITY_HD` | 1 | 6 |
| `VIDEO_QUALITY_FHD` | 2 | 7 |
| `VideoQuality` | int i | 11 |
