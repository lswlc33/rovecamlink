# TUWIN — 常量字面值全量目录

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 740 个 static final 常量，分布在 211 个类里；按类分组，值为 jadx 反编译后的字面量
> 数值常量是端口/超时/枚举 id/缓冲大小的唯一真相来源；字符串常量常在 `catalog-http.md`/`catalog-templates.md` 里再出现一次

---

### `com.flyco.tablayout.CommonTabLayout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `STYLE_BLOCK` | int | 2 | 35 |
| `STYLE_NORMAL` | int | 0 | 36 |
| `STYLE_TRIANGLE` | int | 1 | 37 |
| `TEXT_BOLD_BOTH` | int | 2 | 38 |
| `TEXT_BOLD_NONE` | int | 0 | 39 |
| `TEXT_BOLD_WHEN_SELECT` | int | 1 | 40 |

### `com.flyco.tablayout.SegmentTabLayout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TEXT_BOLD_BOTH` | int | 2 | 32 |
| `TEXT_BOLD_NONE` | int | 0 | 33 |
| `TEXT_BOLD_WHEN_SELECT` | int | 1 | 34 |

### `com.flyco.tablayout.SlidingTabLayout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `STYLE_BLOCK` | int | 2 | 33 |
| `STYLE_NORMAL` | int | 0 | 34 |
| `STYLE_TRIANGLE` | int | 1 | 35 |
| `TEXT_BOLD_BOTH` | int | 2 | 36 |
| `TEXT_BOLD_NONE` | int | 0 | 37 |
| `TEXT_BOLD_WHEN_SELECT` | int | 1 | 38 |

### `com.tuwinsmart.tuwin.core.constants.M3Constants$ShootingMode`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PHOTO_BURST` | int | 17 | 24 |
| `PHOTO_LONG_EXPOSURE` | int | 20 | 25 |
| `PHOTO_SINGLE` | int | 16 | 26 |
| `PHOTO_TIMELAPSE` | int | 18 | 27 |
| `PHOTO_TIMER` | int | 19 | 28 |
| `VIDEO_FAST_MOTION` | int | 25 | 29 |
| `VIDEO_LOOP` | int | 22 | 30 |
| `VIDEO_NORMAL` | int | 21 | 31 |
| `VIDEO_SLOW_MOTION` | int | 24 | 32 |
| `VIDEO_TIMELAPSE` | int | 23 | 33 |

### `com.tuwinsmart.tuwin.core.device.p005m3.ByteAccumulator`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_MAX_BYTES` | int | 262144 | 14 |

### `com.tuwinsmart.tuwin.core.device.p005m3.M3DynamicEndpointPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RTSP_DEFAULT_PORT` | int | 554 | 21 |

### `com.tuwinsmart.tuwin.core.device.p005m3.M3HttpClientCompatibilityKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `M3_CONNECT_TIMEOUT_SECONDS` | long | 5 | 18 |
| `M3_DIAGNOSTIC_CLIENT_NAME` | String | "m3" | 19 |
| `M3_READ_TIMEOUT_SECONDS` | long | 120 | 20 |
| `M3_WRITE_TIMEOUT_SECONDS` | long | 120 | 21 |

### `com.tuwinsmart.tuwin.core.device.p005m3.M3SessionConnectorKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `M3_HTTP_CONTROL_CAPABILITY` | String | "M3_HTTP_CONTROL" | 44 |
| `M3_PRODUCT_INFO_PROBE_MAX_ATTEMPTS` | int | 5 | 45 |
| `M3_PRODUCT_INFO_PROBE_RETRY_DELAY_MILLIS` | long | 2000 | 46 |

### `com.tuwinsmart.tuwin.core.device.p005m3.M3SessionReadiness`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `M3_HTTP_CONTROL_CAPABILITY` | String | "M3_HTTP_CONTROL" | 25 |
| `M3_MEDIA_ENDPOINT_CAPABILITY` | String | "M3_MEDIA_ENDPOINT" | 26 |

### `com.tuwinsmart.tuwin.core.device.p005m3.M3SessionRecoveryController`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `M3_HTTP_CONTROL_CAPABILITY` | String | "M3_HTTP_CONTROL" | 42 |

### `com.tuwinsmart.tuwin.core.device.p005m3.M3SessionRepositoryFactory`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `M3_OTA_PATH_PREFIX` | String | "/upload" | 79 |

### `com.tuwinsmart.tuwin.core.device.ride3pro.Ride3ProDeviceAdapterSession`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RTSP_PREVIEW_PORT` | int | 8080 | 62 |

### `com.tuwinsmart.tuwin.core.device.ride3pro.Ride3ProPollingStatusChannel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_INTERVAL_MS` | long | 30000 | 37 |
| `DEFAULT_MAX_RETRY_COUNT` | int | 3 | 40 |
| `DEFAULT_RETRY_DELAY_MS` | long | 500 | 43 |

### `com.tuwinsmart.tuwin.core.device.ride3pro.Ride3ProSessionTransport`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MENU_CONNECT_TIMEOUT_MILLIS` | int | 5000 | 66 |
| `MENU_MAX_RESPONSE_BYTES` | int | 524288 | 69 |
| `MENU_READ_BUFFER_SIZE` | int | 8192 | 72 |
| `MENU_READ_TIMEOUT_MILLIS` | int | 30000 | 75 |

### `com.tuwinsmart.tuwin.core.device.ride5.Ride5CallbackMessagePolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `NORM_REC_ARG` | String | "\"arg2\":\"NORM_REC\"" | 15 |
| `SWITCH_WORKMODE_EVENT` | String | "\"eventid\":\"STATEMNG_SWITCH_WORKMODE\"" | 16 |

### `com.tuwinsmart.tuwin.core.device.ride5.Ride5DeviceAdapterSession`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CALLBACK_PORT` | int | 9002 | 53 |
| `RTSP_LIVE_PORT` | int | 554 | 57 |

### `com.tuwinsmart.tuwin.core.internet.ExternalResourceAllowlist`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ANDROID_DOWNLOAD_HOST` | String | "2005.sunwingroup.com.cn" | 18 |
| `ANDROID_DOWNLOAD_PATH` | String | "/pcn_manager/download_static_file" | 19 |
| `ANDROID_DOWNLOAD_PORT` | int | 1371 | 20 |
| `ANDROID_DOWNLOAD_SCHEME` | String | "https" | 21 |
| `ASSET_CDN_HOST` | String | "cdn.dcloud.net.cn" | 22 |
| `ASSET_CDN_PORT` | int | 443 | 23 |
| `ASSET_CDN_SCHEME` | String | "https" | 24 |
| `MEDIA_HOST` | String | "111.179.38.202" | 25 |
| `MEDIA_PATH` | String | "/pcn_manager/download_static_file" | 26 |
| `MEDIA_PORT` | int | 1369 | 27 |
| `MEDIA_SCHEME` | String | "http" | 28 |

### `com.tuwinsmart.tuwin.core.internet.ExternalWebCompatibilityPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTERNAL_TARGET_ANDROID_DOWNLOAD_HOST` | String | "2005.sunwingroup.com.cn" | 23 |
| `EXTERNAL_TARGET_APP_STORE_HOST` | String | "apps.apple.com" | 24 |
| `EXTERNAL_TARGET_APP_STORE_PATH` | String | "/app/id6740312738" | 25 |
| `EXTERNAL_TARGET_ASSISTANT_HOST` | String | "intelligentassistant.tuwinsmart.com" | 26 |
| `EXTERNAL_TARGET_DOUYIN_HOST` | String | "v.douyin.com" | 27 |
| `EXTERNAL_TARGET_DOUYIN_PATH` | String | "/twoBbgH2l4Y" | 28 |
| `EXTERNAL_TARGET_WECHAT_HOST` | String | "mp.weixin.qq.com" | 29 |
| `EXTERNAL_TARGET_XIAOHONGSHU_HOST` | String | "xhslink.com" | 30 |
| `EXTERNAL_TARGET_XIAOHONGSHU_PATH` | String | "/m/8acYvvtd8S4" | 31 |
| `INTERNAL_COMMAND_BACK` | String | "back" | 32 |
| `INTERNAL_COMMAND_FEEDBACK` | String | "feedback" | 33 |
| `INTERNAL_COMMAND_SCHEME` | String | "tuwin-help" | 34 |

### `com.tuwinsmart.tuwin.core.internet.ExternalWebResourcePolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HELP_MEDIA_HOST` | String | "111.179.38.202" | 14 |
| `HELP_MEDIA_PATH` | String | "/pcn_manager/download_static_file" | 15 |
| `HELP_MEDIA_PORT` | int | 1369 | 16 |
| `HELP_MEDIA_SCHEME` | String | "http" | 17 |

### `com.tuwinsmart.tuwin.core.internet.InternetProcessRuntime`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `REVISION_CHECK_INTERVAL_MS` | long | 1000 | 31 |

### `com.tuwinsmart.tuwin.core.internet.InternetRouteRevisionProvider`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_MATCHES` | String | "matches" | 22 |
| `KEY_NETWORK_HANDLE` | String | "network_handle" | 23 |
| `KEY_REVISION` | String | "revision" | 24 |
| `KEY_STATE` | String | "state" | 25 |
| `METHOD_MATCHES` | String | "matches" | 26 |
| `METHOD_PUBLISH` | String | "publish" | 27 |

### `com.tuwinsmart.tuwin.core.network.DeviceNetworkController`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_REPLACEMENT_TEARDOWN_POLL_MS` | long | 50 | 61 |
| `DEFAULT_REPLACEMENT_TEARDOWN_TIMEOUT_MS` | long | 3000 | 62 |
| `REDACTED_BSSID` | String | "02:00:00:00:00:00" | 63 |
| `UNKNOWN_SSID` | String | "<unknown ssid>" | 64 |

### `com.tuwinsmart.tuwin.core.network.DeviceWifiConnectionCoordinator`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEVICE_WIFI_REPLACEMENT_REASON` | String | "device Wi-Fi request replacement" | 34 |

### `com.tuwinsmart.tuwin.core.network.DeviceWifiScanner`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_SCAN_TIMEOUT_MS` | long | 8000 | 42 |

### `com.tuwinsmart.tuwin.core.process.AppProcessRole`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INTERNET_PROCESS_SUFFIX` | String | ":internet" | 20 |

### `com.tuwinsmart.tuwin.core.transfer.InternetTransferQueue`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INTERNET_NAMESPACE` | String | "internet" | 31 |

### `com.tuwinsmart.tuwin.core.transfer.ScopedTransferQueue`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_NAMESPACE` | String | "default" | 36 |

### `com.tuwinsmart.tuwin.core.transfer.StreamingTransferEngine`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_REDIRECTS` | int | 3 | 76 |
| `RIDE3PRO_RAWDATA_PATH` | String | "/api/playback/rawdata" | 79 |
| `UNEXPECTED_END_OF_STREAM_PREFIX` | String | "unexpected end of stream on " | 82 |

### `com.tuwinsmart.tuwin.core.transfer.VerifiedDeviceFileCatalogKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONTENT_KEY_NAMESPACE` | String | "device-image" | 10 |
| `CONTENT_KEY_SEPARATOR` | String | "\\|" | 11 |

### `com.tuwinsmart.tuwin.core.util.ConnectUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "fingdo" | 30 |

### `com.tuwinsmart.tuwin.core.util.download.DeviceTransferSpeedTracker`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `NANOS_PER_SECOND` | long | 1000000000 | 18 |
| `PREVIOUS_SAMPLE_WEIGHT` | long | 3 | 21 |
| `SAMPLE_INTERVAL_NANOS` | long | 1000000000 | 24 |

### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BACKGROUND_INTERRUPTION_MESSAGE` | String | "Download interrupted because the app entered background" | 121 |
| `DEVICE_HTTP_TIMEOUT_SECONDS` | long | 5 | 122 |
| `RESUME_PART_SUFFIX` | String | ".tuwin.part" | 123 |

### `com.tuwinsmart.tuwin.core.util.download.Ride3ProPlaybackDownloadResumePolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_RETRY_COUNT` | int | 5 | 23 |
| `MINIMUM_FIRMWARE_VERSION` | String | "v1.20260708.101448" | 24 |
| `RAW_DATA_PATH` | String | "/api/playback/rawdata" | 25 |

### `com.tuwinsmart.tuwin.core.util.logging.AppCrashHandler`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "TUWIN_LOG" | 25 |

### `com.tuwinsmart.tuwin.core.util.logging.DiagnosticHttpLogPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ERROR_BODY_LIMIT_BYTES` | long | 16384 | 46 |
| `SUCCESS_BODY_LIMIT_BYTES` | long | 4096 | 47 |

### `com.tuwinsmart.tuwin.core.util.logging.FullHttpLoggingInterceptorKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LOG_SOURCE` | String | "HTTP_FULL" | 13 |
| `REQUEST` | String | "REQUEST" | 14 |
| `RESPONSE` | String | "RESPONSE" | 15 |
| `TAG_PREFIX` | String | "HTTP_FULL\\|" | 16 |
| `TAG_SEPARATOR` | String | "\\|" | 17 |

### `com.tuwinsmart.tuwin.core.util.logging.Timber`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CRASH` | String | "crash" | 5 |
| `ONLY_US` | String | "only_us" | 6 |
| `RUNTIME` | String | "runtime" | 7 |

### `com.tuwinsmart.tuwin.core.util.logging.TimberInterface`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_STACK_TRACE_LENGTH` | int | 10240 | 18 |
| `TAG` | String | "TUWIN_LOG" | 19 |

### `com.tuwinsmart.tuwin.core.util.logging.TimberInterface$DebugTree`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_LOG_LENGTH` | int | 4000 | 251 |
| `MAX_TAG_LENGTH` | int | 23 | 252 |

### `com.tuwinsmart.tuwin.core.util.logging.WriteRuntimeLogTree`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_LOG_FILE_BYTES` | long | 2097152 | 25 |
| `MAX_RETAINED_LOG_FILES` | int | 7 | 26 |
| `MAX_RETAINED_SNAPSHOTS` | int | 3 | 27 |
| `TAG` | String | "TUWIN_LOG" | 28 |

### `com.tuwinsmart.tuwin.core.util.M3OtaVersionPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BOARD_VERSION` | String | "M3" | 19 |

### `com.tuwinsmart.tuwin.core.util.M3ThumbnailCache`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CACHE_DIR_NAME` | String | "m3_thumbnails" | 23 |
| `JPEG_EXTENSION` | String | ".jpg" | 24 |
| `JPEG_QUALITY` | int | 85 | 25 |

### `com.tuwinsmart.tuwin.core.util.OtaPackageIdentity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MODEL_NONE` | String | "MODEL_NONE" | 24 |

### `com.tuwinsmart.tuwin.core.util.Ride3ProFirmwareMeta`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_HW_VERSION` | String | "1.1" | 17 |
| `DEFAULT_MODEL` | String | "R3Pro" | 18 |

### `com.tuwinsmart.tuwin.core.util.SpanUtils`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ALIGN_BASELINE` | int | 1 | 49 |
| `ALIGN_BOTTOM` | int | 0 | 50 |
| `ALIGN_CENTER` | int | 2 | 51 |
| `ALIGN_TOP` | int | 3 | 52 |
| `COLOR_DEFAULT` | int | -65536 | 53 |

### `com.tuwinsmart.tuwin.core.util.SpanUtils$CustomDynamicDrawableSpan`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ALIGN_BASELINE` | int | 1 | 787 |
| `ALIGN_BOTTOM` | int | 0 | 788 |
| `ALIGN_CENTER` | int | 2 | 789 |
| `ALIGN_TOP` | int | 3 | 790 |

### `com.tuwinsmart.tuwin.core.util.SpanUtils$CustomLineHeightSpan`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ALIGN_CENTER` | int | 2 | 536 |
| `ALIGN_TOP` | int | 3 | 537 |

### `com.tuwinsmart.tuwin.core.util.UmengSdkBridge`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEVICE_TYPE_PHONE_FIELD_NAME` | String | "DEVICE_TYPE_PHONE" | 17 |
| `UM_CONFIGURE_CLASS_NAME` | String | "com.umeng.commonsdk.UMConfigure" | 19 |

### `com.tuwinsmart.tuwin.core.util.UpgradeDevice`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MSG_UPLOAD_FAILED` | int | 10003 | 38 |
| `TAG` | String | "UpgradeDevice" | 39 |

### `com.tuwinsmart.tuwin.core.util.UpgradeHelper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DOWNLOAD_COMPLETE_DISPLAY_MILLIS` | long | 2000 | 72 |
| `UPGRADE_DIRECTORY_NAME` | String | "upgrade" | 73 |

### `com.tuwinsmart.tuwin.core.util.wifi.DeviceLogReusePolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RECENT_LOG_MAX_AGE_MS` | long | 30000 | 13 |

### `com.tuwinsmart.tuwin.data.repository.DeviceVersionRepositoryImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_ALL_DEVICE_IDS` | String | "device_version_all_ids" | 22 |
| `KEY_PREFIX` | String | "device_version_" | 23 |

### `com.tuwinsmart.tuwin.data.repository.M3DeviceAttrCompatibilityCache`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `M3_OTA_QUERY_VERSION_KEY` | String | "m3_ota_query_version" | 15 |
| `M3_OTA_VERSION_KEY` | String | "m3_otaver" | 16 |
| `M3_SOFTWARE_VERSION_KEY` | String | "m3_softver" | 17 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProHourFilesLoader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CANCELLATION_REASON` | String | "CANCELLED" | 41 |
| `DEVICE_DEFAULT_YEAR` | int | 2017 | 43 |
| `FILE_LIST_MODE` | int | 0 | 44 |
| `MAX_FILE_INDEX` | int | 9999 | 45 |
| `MIN_FILE_INDEX` | int | 0 | 46 |
| `YEAR_DIVISOR` | int | 10000 | 47 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProHourScanCursor`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_TIME_LIMIT` | int | 60 | 25 |
| `MAX_FILE_INDEX` | int | 9999 | 27 |
| `MIN_FILE_INDEX` | int | 0 | 28 |
| `PAGE_SIZE` | int | 16 | 29 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProIndexedDeviceKeyResolver`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MIN_QUOTED_LENGTH` | int | 2 | 16 |
| `QUOTE` | char | "\\\"" | 17 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProIndexedPlaybackRepositoryImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DAY_INFO_ENDPOINT` | String | "/api/playback/dayinfo" | 34 |
| `DELETE_ENDPOINT` | String | "/api/playback/delete" | 35 |
| `FILE_COUNT_ENDPOINT` | String | "/api/playback/filecount" | 36 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProPlaybackCatalogPersistentCacheStore`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CACHE_DIRECTORY_NAME` | String | "ride3pro_indexed_playback_cache" | 45 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProPlaybackFileMapper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `AVI_FILE_TYPE` | String | "A" | 24 |
| `JPEG_FILE_TYPE` | String | "J" | 26 |
| `MAX_DURATION_SECONDS` | int | 60 | 27 |
| `MAX_FILE_INDEX` | int | 9999 | 28 |
| `MIN_DURATION_SECONDS` | int | 0 | 29 |
| `MIN_FILE_INDEX` | int | 0 | 30 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProPlaybackPersistentCacheStore`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CACHE_DIRECTORY_NAME` | String | "ride3pro_playback_cache" | 39 |
| `DEFAULT_DEVICE_KEY` | String | "default" | 41 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProPlaybackRepositoryImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ERROR_INVALID_COMMAND` | int | -2 | 49 |
| `FILE_TYPE_AVI` | int | 0 | 50 |
| `MAX_FILE_INDEX` | int | 9999 | 51 |
| `MODE_FIRST_PAGE` | int | 0 | 52 |
| `MODE_NEXT_PAGE` | int | 0 | 53 |
| `MODE_PLAYBACK` | int | 2 | 54 |
| `PAGE_SIZE` | int | 16 | 55 |
| `PLAYBACK_STOP_DELAY_MS` | long | 0 | 56 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProPlaybackTimestampParser`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DAY_GROUP` | int | 3 | 14 |
| `HOUR_GROUP` | int | 4 | 15 |
| `MINUTE_GROUP` | int | 5 | 16 |
| `MONTH_GROUP` | int | 2 | 17 |
| `MONTH_MULTIPLIER` | int | 100 | 18 |
| `YEAR_GROUP` | int | 1 | 19 |
| `YEAR_MULTIPLIER` | int | 10000 | 20 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProPreviewHandshakeCache`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `NANOSECONDS_PER_MILLISECOND` | long | 1000000 | 17 |
| `VALIDITY_DURATION_MS` | long | 600000 | 18 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProStreamRepositoryImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ERROR_INVALID_COMMAND` | int | -2 | 37 |
| `MODE_PREVIEW` | int | 0 | 38 |

### `com.tuwinsmart.tuwin.data.repository.ride5.Ride5FileInfoResponseParser`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INVALID_LONG` | long | -1 | 15 |
| `KEY_PATH` | String | "path" | 16 |
| `KEY_SIZE` | String | "size" | 17 |
| `KEY_TIME` | String | "time" | 18 |

### `com.tuwinsmart.tuwin.data.repository.ride5.Ride5HourFilesLoader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_CONCURRENCY` | int | 4 | 36 |

### `com.tuwinsmart.tuwin.data.repository.SdCardFormatReminderRepositoryImpl`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_PREFIX` | String | "sd_card_format_reminder_start_" | 18 |

### `com.tuwinsmart.tuwin.data.source.local.preferences.UserPreferencesRepositoryKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DATASTORE_NAME` | String | "user_preferences" | 28 |
| `DEFAULT_CONNECTED_DEVICES_JSON` | String | "[]" | 24 |
| `DEFAULT_RECORDING_CONTROL_EVENTS_JSON` | String | "[]" | 25 |
| `LEGACY_PREFERENCES_NAME` | String | "TUWIN" | 26 |

### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProHttpRequestQueueKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RIDE3_PRO_FORMAT_SD_PATH` | String | "/api/system/formatsd" | 14 |
| `RIDE3_PRO_FORMAT_SD_TIMEOUT_SECONDS` | long | 60 | 15 |
| `RIDE3_PRO_PLAYBACK_RAW_DATA_PATH` | String | "/api/playback/rawdata" | 16 |
| `RIDE3_PRO_PLAYBACK_THUMBNAIL_PATH` | String | "/api/playback/thumbnail" | 18 |
| `RIDE3_PRO_REQUEST_ID_HEADER` | String | "X-Request-Id" | 17 |

### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProPlaybackIndexValidator`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DAY_MODULUS` | int | 100 | 18 |
| `MAX_FILE_INDEX` | int | 9999 | 20 |
| `MAX_HOUR` | int | 23 | 21 |
| `MAX_YYYYMMDD` | int | 99999999 | 22 |
| `MIN_FILE_INDEX` | int | 0 | 23 |
| `MIN_HOUR` | int | 0 | 24 |
| `MIN_YYYYMMDD` | int | 10000000 | 25 |
| `MONTH_DIVISOR` | int | 100 | 26 |
| `MONTH_MODULUS` | int | 100 | 27 |
| `YEAR_DIVISOR` | int | 10000 | 28 |

### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProProtocolFeatures`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `NV` | String | "nv" | 19 |
| `REBOOT` | String | "reboot" | 20 |

### `com.tuwinsmart.tuwin.data.source.remote.api.ride3pro.Ride3ProThumbnailRetryInterceptor`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RETRY_DELAY_MILLIS` | long | 500 | 22 |

### `com.tuwinsmart.tuwin.data.source.remote.exception.ApiException$ERROR`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CAST_ERROR` | int | 1004 | 26 |
| `ILLEGAL_STATE_ERROR` | int | 1006 | 27 |
| `NULL_POINTER_EXCEPTION` | int | 1002 | 28 |
| `PARSE_ERROR` | int | 1005 | 29 |
| `SSL_ERROR` | int | 1003 | 30 |
| `TIMEOUT_ERROR` | int | 1001 | 31 |
| `UNKNOWN` | int | 1000 | 32 |

### `com.tuwinsmart.tuwin.data.source.remote.exception.Ride3ProConnectionException`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `UNKNOWN_ERROR` | String | "unknown error" | 23 |

### `com.tuwinsmart.tuwin.data.source.remote.gateway.FeedbackApiEndpoint`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BASE_URL` | String | "http://ali.tuwinsmart.com/" | 10 |
| `URL` | String | "http://ali.tuwinsmart.com/feedback" | 12 |

### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedDeviceLogGateway`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEVICE_HTTP_PORT` | int | 80 | 60 |

### `com.tuwinsmart.tuwin.data.source.remote.gateway.RoutedInternetCloudGateway`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BANNER_ACTIVE_STATUS` | String | "active" | 54 |
| `BANNER_SUCCESS_CODE` | int | 200 | 57 |

### `com.tuwinsmart.tuwin.domain.model.ConnectedDevice`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_WIFI_PASSWORD` | String | "12345678" | 22 |

### `com.tuwinsmart.tuwin.domain.model.Ride3ProPlaybackTimestamp`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DAY_MODULUS` | int | 100 | 14 |
| `MAX_HOUR` | int | 23 | 15 |
| `MAX_MINUTE` | int | 59 | 16 |
| `MAX_YYYYMMDD` | int | 99999999 | 17 |
| `MIN_HOUR` | int | 0 | 18 |
| `MIN_MINUTE` | int | 0 | 19 |
| `MIN_YYYYMMDD` | int | 10000000 | 20 |
| `MONTH_DIVISOR` | int | 100 | 21 |
| `MONTH_MODULUS` | int | 100 | 22 |
| `YEAR_DIVISOR` | int | 10000 | 23 |

### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5FileInfo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MILLIS_PER_SECOND` | long | 1000 | 18 |

### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5HourRecording`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HOUR_SECONDS` | int | 3600 | 16 |
| `LAST_SECOND_OF_HOUR` | int | 3599 | 17 |
| `SECONDS_PER_MINUTE` | int | 60 | 18 |

### `com.tuwinsmart.tuwin.domain.repository.Ride3ProDeviceRepository`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INSTANCE` | Companion | Companion.$$INSTANCE | 23 |
| `TODO_API_RIDE3PRO_FACTORY_RESET` | String | "TODO_API_RIDE3PRO_FACTORY_RESET" | 24 |
| `TODO_API_RIDE3PRO_FORMAT_SD_CARD` | String | "TODO_API_RIDE3PRO_FORMAT_SD_CARD" | 25 |
| `TODO_API_RIDE3PRO_GET_BATTERY_INFO` | String | "TODO_API_RIDE3PRO_GET_BATTERY_INFO" | 26 |
| `TODO_API_RIDE3PRO_GET_MEDIA_INFO` | String | "TODO_API_RIDE3PRO_GET_MEDIA_INFO" | 27 |
| `TODO_API_RIDE3PRO_GET_SD_INFO` | String | "TODO_API_RIDE3PRO_GET_SD_INFO" | 28 |

### `com.tuwinsmart.tuwin.domain.repository.Ride3ProDeviceRepository$Companion`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TODO_API_RIDE3PRO_FACTORY_RESET` | String | "TODO_API_RIDE3PRO_FACTORY_RESET" | 97 |
| `TODO_API_RIDE3PRO_FORMAT_SD_CARD` | String | "TODO_API_RIDE3PRO_FORMAT_SD_CARD" | 98 |
| `TODO_API_RIDE3PRO_GET_BATTERY_INFO` | String | "TODO_API_RIDE3PRO_GET_BATTERY_INFO" | 99 |
| `TODO_API_RIDE3PRO_GET_MEDIA_INFO` | String | "TODO_API_RIDE3PRO_GET_MEDIA_INFO" | 100 |
| `TODO_API_RIDE3PRO_GET_SD_INFO` | String | "TODO_API_RIDE3PRO_GET_SD_INFO" | 101 |

### `com.tuwinsmart.tuwin.domain.strategy.M3ConnectionStrategy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `M3_CONTROL_PORT` | int | 80 | 76 |
| `M3_TIME_PATTERN` | String | "yyyyMMddHHmmss" | 79 |
| `MILLIS_PER_HOUR` | int | 3600000 | 82 |

### `com.tuwinsmart.tuwin.domain.strategy.Ride5ConnectionStrategy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RIDE5_TIME_PATTERN` | String | "yyyyMMddHHmmss" | 78 |

### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialog2`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_DEVICE_TYPE` | String | "arg_device_type" | 107 |
| `ARG_WIFI_BSSID` | String | "arg_wifi_bssid" | 108 |
| `ARG_WIFI_PWD` | String | "arg_wifi_pwd" | 109 |
| `ARG_WIFI_SSID` | String | "arg_wifi_ssid" | 110 |
| `CONNECTION_PROGRESS_TAG` | String | "ConnectionProgressDialog" | 111 |
| `DEVICE_WIFI_SCAN_TAG` | String | "DeviceWifiScanDialog" | 115 |
| `RECONNECT_CONNECTION_FLOW_TIMEOUT_MS` | long | 8000 | 116 |
| `WIFI_DISABLED_GUIDE_PANEL_RATIO` | float | 0.44f | 117 |
| `WIFI_DISABLED_PANEL_SCREEN_RATIO` | float | 0.5f | 118 |
| `WIFI_GUIDE_SOURCE_HEIGHT` | int | 696 | 119 |
| `WIFI_GUIDE_SOURCE_WIDTH` | int | 674 | 120 |

### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_CONNECTION_FLOW_TIMEOUT_MS` | long | 30000 | 64 |
| `FAILURE_NOTICE_MS` | long | 500 | 65 |
| `RETRY_NOTICE_MS` | long | 500 | 66 |
| `RIDE3PRO_MAX_ATTEMPTS` | int | 3 | 67 |

### `com.tuwinsmart.tuwin.presentation.dialog.DeviceWifiScanDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_CANCEL` | String | "cancel" | 36 |
| `ACTION_FALLBACK` | String | "fallback" | 37 |
| `ACTION_RETRY` | String | "retry" | 38 |
| `ACTION_SELECT` | String | "select" | 39 |
| `REQUEST_KEY` | String | "device_wifi_scan" | 40 |
| `RESULT_ACTION` | String | "action" | 41 |
| `RESULT_BSSID` | String | "bssid" | 42 |
| `RESULT_SSID` | String | "ssid" | 43 |
| `TAG` | String | "DeviceWifiScanDialog" | 44 |

### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareDownloadDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BACKGROUND_DIM_AMOUNT` | float | 0.6f | 25 |

### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareDownloadUiState`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_PROGRESS` | int | 100 | 16 |
| `MIN_PROGRESS` | int | 0 | 17 |

### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUpdateBottomSheet`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TAG` | String | "FirmwareUpdateBottomSheet" | 35 |

### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUploadDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BACKGROUND_DIM_AMOUNT` | float | 0.55f | 33 |
| `UNAVAILABLE_VALUE` | String | "--" | 34 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.adapter.DailyListAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_ENTER_SELECT_MODE` | int | 4 | 49 |
| `ACTION_EXIT_SELECT_MODE` | int | 5 | 50 |
| `ACTION_IS_ALL_SELECT_MODE` | int | 1 | 51 |
| `ACTION_NOT_ALL_SELECT_MODE` | int | 2 | 52 |
| `ACTION_VIDEO_ITEM_CLICK` | int | 3 | 53 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.DailyDetailActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_SESSION_ID` | String | "device_session_id" | 91 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProDailyDetailActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_DELETE_CAPABILITY` | String | "delete_capability" | 142 |
| `EXTRA_DELETED_FILE_INDEX` | String | "deleted_file_index" | 141 |
| `EXTRA_DEVICE_TYPE_CODE` | String | "device_type_code" | 143 |
| `EXTRA_PHOTO_MODE` | String | "photo" | 144 |
| `EXTRA_RETURN_TO_PLAYBACK_LIST` | String | "return_to_playback_list" | 145 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 146 |
| `EXTRA_USE_HOUR_PLAYBACK_LAYOUT` | String | "use_hour_playback_layout" | 147 |
| `EXTRA_VIDEO_ITEM` | String | "videoItem" | 148 |
| `FULL_EFFECT_CARD_SPAN` | float | 2.0f | 149 |
| `HOUR_IDENTITY_FORMAT` | String | "yyyyMMddHH" | 151 |
| `HOURS_PER_DAY` | int | 24 | 150 |
| `NO_SELECTED_VIDEO_SCROLL_TARGET` | int | -1 | 152 |
| `PLAYBACK_CONTROLS_HIDE_DELAY_MS` | long | 3000 | 153 |
| `PLAYBACK_PROGRESS_TICK_MS` | long | 250 | 154 |
| `PLAYBACK_START_DELAY_MS` | long | 500 | 155 |
| `SELECTED_VIDEO_CAMERA_DISTANCE_DP` | float | 1000.0f | 156 |
| `SELECTED_VIDEO_MAX_ELEVATION_DP` | float | 12.0f | 157 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProHourPlaybackTimelinePolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONTIGUOUS_TOLERANCE_SECONDS` | int | 1 | 22 |
| `HOUR_SECONDS` | int | 3600 | 23 |
| `LAST_SECOND_OF_HOUR` | int | 3599 | 25 |
| `MAX_RECORDING_DURATION_SECONDS` | int | 60 | 26 |
| `MILLIS_PER_SECOND` | long | 1000 | 27 |
| `MIN_RECORDING_DURATION_SECONDS` | int | 1 | 28 |
| `SECONDS_PER_MINUTE` | int | 60 | 29 |
| `SNAP_WINDOW_SECONDS` | int | 60 | 30 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProHourRecordingCarouselPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CENTER_ALPHA` | float | 1.0f | 11 |
| `CENTER_SCALE` | float | 1.0f | 12 |
| `EDGE_ALPHA` | float | 0.68f | 13 |
| `EDGE_SCALE` | float | 0.86f | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProHourRecordingSmoothScroller`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_DECELERATION_DURATION_MS` | int | 520 | 20 |
| `MAX_SCROLL_DURATION_MS` | int | 360 | 23 |
| `MILLISECONDS_PER_INCH` | float | 110.0f | 26 |
| `MIN_DECELERATION_DURATION_MS` | int | 220 | 29 |
| `MIN_SCROLL_DURATION_MS` | int | 120 | 32 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProHourTimelineView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LAST_SECOND_OF_HOUR` | int | 3599 | 43 |
| `MIN_SEGMENT_WIDTH_DP` | float | 4.0f | 46 |
| `POINTER_ANIMATION_MILLIS` | long | 180 | 49 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProLocalVideoTranscoder`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PROGRESS_POLL_INTERVAL_MILLIS` | long | 50 | 43 |
| `PROGRESS_TOTAL` | int | 100 | 44 |
| `STALE_INITIAL_PROGRESS` | int | 99 | 45 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProPlaybackGestureSeekPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_FULL_SWIPE_SEEK_MS` | long | 60000 | 13 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProPlaybackInternalNavigationGate`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_SUPPRESSION_MS` | long | 2000 | 11 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProSelectedVideoAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CREATE_TIME_FORMAT` | String | "yyyy-MM-dd HH:mm:ss" | 41 |
| `MILLIS_PER_SECOND` | long | 1000 | 45 |
| `START_TIME_FORMAT` | String | "HH:mm" | 48 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProSelectedVideoCarouselPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CENTER_ALPHA` | float | 1.0f | 11 |
| `CENTER_SCALE` | float | 1.0f | 12 |
| `SIDE_ALPHA` | float | 0.52f | 14 |
| `SIDE_OVERLAP_FRACTION` | float | 0.26f | 15 |
| `SIDE_ROTATION_Y_DEGREES` | float | 12.0f | 16 |
| `SIDE_SCALE` | float | 0.85f | 17 |
| `SIDE_VERTICAL_OFFSET_FRACTION` | float | 0.025f | 18 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5HourDetailActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `COLUMN_COUNT` | int | 3 | 77 |
| `DISABLED_ALPHA` | float | 0.5f | 81 |
| `EXTRA_DEVICE_TYPE` | String | "deviceType" | 82 |
| `EXTRA_PRELOADED_RECORDINGS` | String | "preloaded_recordings" | 83 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 84 |
| `EXTRA_VIDEO_ITEM` | String | "videoItem" | 85 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5HourFileAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TIME_DISPLAY_FORMAT` | String | "%02d:%02d" | 39 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5HourlyPlaybackActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_DELETED_FILE_PATH` | String | "deleted_file_path" | 130 |
| `EXTRA_DEVICE_TYPE` | String | "deviceType" | 131 |
| `EXTRA_PHOTO_MODE` | String | "photo" | 132 |
| `EXTRA_PRELOADED_RECORDINGS` | String | "preloaded_recordings" | 133 |
| `EXTRA_RETURN_TO_PLAYBACK_LIST` | String | "return_to_playback_list" | 134 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 135 |
| `EXTRA_VIDEO_ITEM` | String | "videoItem" | 136 |
| `FULL_EFFECT_CARD_SPAN` | float | 2.0f | 137 |
| `HOURS_PER_DAY` | int | 24 | 138 |
| `NO_SELECTED_VIDEO_SCROLL_TARGET` | int | -1 | 139 |
| `PLAYBACK_CONTROLS_HIDE_DELAY_MS` | long | 3000 | 140 |
| `SELECTED_VIDEO_CAMERA_DISTANCE_DP` | float | 1000.0f | 141 |
| `SELECTED_VIDEO_MAX_ELEVATION_DP` | float | 12.0f | 142 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5HourlyPlaybackController`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PROGRESS_TICK_MS` | long | 250 | 44 |
| `SEEK_MAX_HOLD_TICKS` | int | 32 | 47 |
| `SEEK_SETTLE_TIMEOUT_MS` | long | 250 | 50 |
| `SEEK_SETTLE_TOLERANCE_MS` | long | 1000 | 53 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5HourPlaybackTimelinePolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONTIGUOUS_TOLERANCE_SECONDS` | int | 1 | 24 |
| `HOUR_SECONDS` | int | 3600 | 25 |
| `LAST_SECOND_OF_HOUR` | int | 3599 | 27 |
| `SNAP_WINDOW_SECONDS` | int | 60 | 28 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5HourRecordingAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MILLIS_PER_SECOND` | long | 1000 | 40 |
| `START_TIME_FORMAT` | String | "HH:mm" | 43 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5HourRecordingCarouselPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CENTER_ALPHA` | float | 1.0f | 11 |
| `CENTER_SCALE` | float | 1.0f | 12 |
| `EDGE_ALPHA` | float | 0.68f | 13 |
| `EDGE_SCALE` | float | 0.86f | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5HourRecordingSmoothScroller`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_DECELERATION_DURATION_MS` | int | 520 | 20 |
| `MAX_SCROLL_DURATION_MS` | int | 360 | 23 |
| `MILLISECONDS_PER_INCH` | float | 110.0f | 26 |
| `MIN_DECELERATION_DURATION_MS` | int | 220 | 29 |
| `MIN_SCROLL_DURATION_MS` | int | 120 | 32 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5HourTimelineView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LAST_SECOND_OF_HOUR` | int | 3599 | 44 |
| `MIN_SEGMENT_WIDTH_DP` | float | 4.0f | 47 |
| `POINTER_ANIMATION_MILLIS` | long | 180 | 50 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5SelectedVideoAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CREATE_TIME_FORMAT` | String | "yyyy-MM-dd HH:mm:ss" | 40 |
| `MILLIS_PER_SECOND` | long | 1000 | 44 |
| `START_TIME_FORMAT` | String | "HH:mm" | 47 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5SelectedVideoCarouselPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CENTER_ALPHA` | float | 1.0f | 11 |
| `CENTER_SCALE` | float | 1.0f | 12 |
| `SIDE_ALPHA` | float | 0.52f | 14 |
| `SIDE_OVERLAP_FRACTION` | float | 0.26f | 15 |
| `SIDE_ROTATION_Y_DEGREES` | float | 12.0f | 16 |
| `SIDE_SCALE` | float | 0.85f | 17 |
| `SIDE_VERTICAL_OFFSET_FRACTION` | float | 0.025f | 18 |

### `com.tuwinsmart.tuwin.presentation.p010ui.common.WebViewActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_TITLE` | String | "title" | 26 |
| `EXTRA_URL` | String | "url" | 27 |

### `com.tuwinsmart.tuwin.presentation.p010ui.connect.ConnectFlowLifecycleGate`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_DURATION_MS` | long | 120000 | 11 |

### `com.tuwinsmart.tuwin.presentation.p010ui.connect.ConnectHelperActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_DEVICE_TYPE` | String | "extra_device_type" | 42 |

### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BANNER_CACHE_KEY` | String | "BANNER_CACHE_KEY" | 100 |
| `FIRMWARE_RECONNECT_TIMEOUT_MILLIS` | long | 120000 | 101 |
| `RECONNECT_POLL_INTERVAL_MILLIS` | long | 1000 | 102 |
| `RECONNECT_RETRY_DELAY_MILLIS` | long | 2000 | 103 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_DEVICE_ID` | String | "device_id" | 149 |
| `EXTRA_DEVICE_TYPE_CODE` | String | "extra_device_type_code" | 150 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 151 |
| `REQUEST_CODE_MORE_SETTINGS` | int | 1001 | 152 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailRide3ProExceptionPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RECORDING_WRITE_ERROR_MASK` | int | 4 | 13 |
| `SD_FULL_MASK` | int | 2 | 14 |
| `SENSOR_BAD_MASK` | int | 1 | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailSdCardFormatReminderPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MILLIS_PER_DAY` | long | 86400000 | 11 |
| `REMINDER_DAYS` | int | 30 | 12 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailWatermarkPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FULLSCREEN_OFFSET_REFERENCE` | String | "2000-00-00 00:00:00" | 18 |
| `FULLSCREEN_OFFSET_RETRACT_CHARS` | int | 3 | 19 |
| `refreshIntervalMs` | long | 1000 | 21 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.M3DeviceDetailActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CAPTURE_START_COOLDOWN_MS` | long | 1000 | 127 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 128 |
| `MAX_RETRY_COUNT` | int | 5 | 129 |
| `MIN_STAY_DURATION_MS` | long | 2000 | 130 |
| `MODE_SWITCH_LOADING_TIMEOUT_MS` | long | 10000 | 131 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.M3DeviceDetailViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BURST_PHOTO_SOCKET_TIMEOUT_MS` | long | 35000 | 75 |
| `DEFAULT_SD_FREE_MB` | int | 0 | 76 |
| `DEFAULT_SD_STATUS` | int | 99 | 77 |
| `PHOTO_FREE_MB_THRESHOLD` | int | 0 | 78 |
| `PHOTO_SOCKET_TIMEOUT_MS` | long | 5000 | 79 |
| `PREF_KEY_LOOP_RECORDING_START_TIME` | String | "m3_loop_recording_start_time" | 80 |
| `RECORDING_FREE_MB_THRESHOLD` | int | 0 | 81 |
| `SOCKET_RECONNECT_INITIAL_DELAY_MS` | long | 1000 | 82 |
| `SOCKET_RECONNECT_MAX_DELAY_MS` | long | 15000 | 83 |
| `TAG` | String | "M3DeviceDetailViewModel" | 84 |
| `TIMED_PHOTO_SOCKET_TIMEOUT_MS` | long | 15000 | 85 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.M3PreviewRatioPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PHOTO_LANDSCAPE_RATIO` | String | "4:3" | 12 |
| `PHOTO_PORTRAIT_RATIO` | String | "3:4" | 13 |
| `VIDEO_LANDSCAPE_RATIO` | String | "16:9" | 14 |
| `VIDEO_PORTRAIT_RATIO` | String | "9:16" | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.list.adapter.DeviceTypeAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `VIEW_TYPE_DEVICE` | int | 1 | 25 |
| `VIEW_TYPE_HEADER` | int | 0 | 26 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.M3DeviceSettingsActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_IDENTITY_SESSION_ID` | String | "device_identity_session_id" | 65 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 66 |
| `TAG` | String | "M3DeviceSettingsActivity" | 67 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.M3SettingsAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `VIEW_TYPE_GENERAL` | int | 2 | 41 |
| `VIEW_TYPE_HEADER` | int | 0 | 42 |
| `VIEW_TYPE_PARAM` | int | 1 | 43 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.Ride3ProSettingsActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_DEVICE_TYPE_CODE` | String | "device_type_code" | 81 |
| `EXTRA_IDENTITY_SESSION_ID` | String | "device_identity_session_id" | 82 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 83 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.Ride3ProSettingsActivityKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PASSWORD_MASK` | String | "********" | 10 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.Ride3ProSettingsAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `VIEW_TYPE_ITEM` | int | 1 | 27 |
| `VIEW_TYPE_SECTION` | int | 0 | 28 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.Ride3ProSettingsOtaEntryPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `OTA_ENTRY_ID` | String | "__ride3pro_ota_upgrade__" | 16 |
| `OTA_ENTRY_TYPE` | String | "__ride3pro_action__" | 17 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.Ride3ProWifiSettingsPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `WIFI_PASSWORD_LENGTH` | int | 8 | 12 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.Ride6ParameterRequestIds`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ALL` | String | "all" | 18 |
| `FACTORY_RESET` | String | "factory_reset" | 19 |
| `RECORD_EXPOSURE` | String | "record_exposure" | 21 |
| `RECORD_LOOP_RECORDING` | String | "record_loop_recording" | 22 |
| `RECORD_RESOLUTION` | String | "record_resolution" | 23 |
| `SYSTEM_FREQUENCY` | String | "system_frequency" | 24 |
| `SYSTEM_VERSION` | String | "system_version" | 25 |
| `WIFI_NAME` | String | "wifi_name" | 26 |
| `WIFI_PASSWD` | String | "wifi_passwd" | 27 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.Ride6SettingsCompatibilityPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FACTORY_RESET_ID` | String | "0x0000208" | 17 |
| `WIFI_PASSWORD_ID` | String | "0x0000301" | 19 |

### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadFileTaskAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `VIDEO_FRAME_EXTENSIONS` | String[] | {".mp4", ".ts", ".mov", ".avi"} | 55 |
| `VIEW_TYPE_DOWNLOAD_ITEM` | int | 2 | 56 |
| `VIEW_TYPE_DOWNLOAD_TITLE` | int | 1 | 57 |

### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadListAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `VIEW_TYPE_DOWNLOAD_ITEM` | int | 2 | 52 |
| `VIEW_TYPE_DOWNLOAD_TITLE` | int | 1 | 53 |

### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.DownloadTagInfoParser`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FIELD_DEVICE_TYPE` | String | "device_type" | 17 |
| `FIELD_FILE_INDEX` | String | "file_index" | 19 |
| `FIELD_FILENAME` | String | "filename" | 18 |
| `FIELD_THUMBNAIL_CACHE_KEY` | String | "thumbnail_cache_key" | 20 |
| `FIELD_THUMBNAIL_URL` | String | "thumbnail_url" | 21 |
| `FIELD_URL` | String | "url" | 22 |
| `MIN_FILE_INDEX` | int | 0 | 24 |

### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.LocalDownloadListAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_ENTER_SELECT_MODE` | int | 1 | 45 |
| `ACTION_EXIT_SELECT_MODE` | int | 2 | 46 |
| `ACTION_RETRY_LOAD` | int | 6 | 47 |
| `ACTION_VIDEO_ITEM_CLICK` | int | 3 | 48 |
| `VIEW_TYPE_DATE_TITLE` | int | 5 | 49 |
| `VIEW_TYPE_SECTION_TITLE` | int | 3 | 50 |
| `VIEW_TYPE_VIDEO_ITEM` | int | 6 | 51 |

### `com.tuwinsmart.tuwin.presentation.p010ui.download.adapter.Ride3ProAviThumbnailCache`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CACHE_DIR_NAME` | String | "ride3pro_avi_thumbnails" | 25 |
| `EXTRACTOR_OK` | int | 0 | 26 |

### `com.tuwinsmart.tuwin.presentation.p010ui.download.CompletedDownloadPlaybackPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `PHOTO_EXTENSIONS` | String[] | {".jpg", ".jpeg", ".png"} | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.download.DownloadListActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_ENTRY_DEVICE_TYPE` | String | "extra_entry_device_type" | 67 |

### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_ADD_DEVICE` | int | 3 | 85 |
| `ACTION_ADD_SPECIAL_DEVICE` | int | 4 | 86 |
| `ACTION_CONTACT_SERVICE` | int | 7 | 87 |
| `ACTION_JUMP_DEEPLINK` | int | 5 | 88 |
| `ACTION_JUMP_TO_DEVICE_DETAIL` | int | 1 | 89 |
| `ACTION_PLAY_VIDEO` | int | 2 | 90 |
| `ACTION_REMOVE_SPECIAL_DEVICE` | int | 6 | 91 |
| `TAG` | String | "HomeListAdapter" | 92 |
| `VIEW_TYPE_ADD_DEVICE` | int | 5 | 93 |
| `VIEW_TYPE_DEVICE_ITEM` | int | 4 | 94 |
| `VIEW_TYPE_DEVICE_TITLE` | int | 2 | 95 |
| `VIEW_TYPE_SERVICE_CARD` | int | 3 | 96 |
| `VIEW_TYPE_WEATHER` | int | 1 | 97 |

### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomeActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FRAGMENT_TAG_ALBUM` | String | "album" | 51 |
| `FRAGMENT_TAG_CONNECT` | String | "connect" | 50 |
| `FRAGMENT_TAG_HELPER` | String | "helper" | 52 |
| `FRAGMENT_TAGS` | String[] | {FRAGMENT_TAG_CONNECT, FRAGMENT_TAG_ALBUM, FRAGMENT_TAG_HELPER} | 53 |
| `STATE_CURRENT_INDEX` | String | "current_index" | 45 |

### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomePrivacyPolicyContentLoader`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_PROMINENT_LOCATION_DISCLOSURE_HTML` | String | "<binary/metadata>" | 39 |
| `ROUTE_RETRY_DELAY_MILLIS` | long | 200 | 40 |
| `ROUTE_WAIT_TIMEOUT_MILLIS` | long | 10000 | 41 |

### `com.tuwinsmart.tuwin.presentation.p010ui.home.HomeTipsWebsiteCachePolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ASSET_BASE_URL` | String | "http://tuwinwifihelp.tuwinsmart.com/assets/" | 13 |
| `CACHE_MARK_KEY` | String | "HOME_TIPS_WEBSITE_CACHE_URL" | 14 |
| `TIPS_URL` | String | "http://tuwinwifihelp.tuwinsmart.com/#/" | 17 |

### `com.tuwinsmart.tuwin.presentation.p010ui.home.PrivacyPolicySource`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `baseUrl` | String | "https://yomu.atlasmeta.one" | 16 |

### `com.tuwinsmart.tuwin.presentation.p010ui.internet.ExternalWebActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_EXPIRES_AT` | String | "internet_route_expires_at" | 60 |
| `EXTRA_NETWORK_HANDLE` | String | "internet_network_handle" | 61 |
| `EXTRA_ROUTE_REVISION` | String | "internet_route_revision" | 62 |
| `EXTRA_TITLE` | String | "external_title" | 63 |
| `EXTRA_TOKEN` | String | "internet_route_token" | 64 |
| `EXTRA_URL` | String | "external_url" | 65 |
| `HELP_SITE_COMPATIBILITY_SCRIPT` | String | "<binary/metadata>" | 66 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_FEEDBACK_CONTACT` | String | "feedback_contact_cache" | 74 |
| `KEY_FEEDBACK_CONTENT` | String | "feedback_content_cache" | 75 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackSubmitFlow`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SUBMIT_START_DELAY_MS` | long | 100 | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.fragment.MineFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `SYSTEM_LANGUAGE_POSITION` | int | 0 | 42 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_DEVICE_TYPE_CODE` | String | "extra_device_type_code" | 82 |
| `EXTRA_IDENTITY_SESSION_ID` | String | "device_identity_session_id" | 83 |
| `EXTRA_RESULT_MEDIA_MODE` | String | "extra_result_media_mode" | 84 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 85 |
| `NORMAL_RECORD_MODE` | String | "NORM_REC" | 86 |
| `WIFI_DEFAULT_STATE` | String | "WIFI_DEAULT_STATE" | 87 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaFailurePolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CONNECTION_RESET` | String | "connection reset" | 17 |
| `EXTERNAL_POWER_ERROR_CODE` | String | "result=-10" | 18 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `COUNTDOWN_SECONDS` | int | 30 | 96 |
| `EXTRA_DEVICE_TYPE_CODE` | String | "device_type_code" | 97 |
| `EXTRA_IDENTITY_SESSION_ID` | String | "device_identity_session_id" | 98 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 99 |
| `M3_RESULT_DISPLAY_MILLIS` | long | 1500 | 100 |

### `com.tuwinsmart.tuwin.presentation.p010ui.ride3pro.Ride3ProHeartbeatManager`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `HEARTBEAT_INTERVAL_MS` | long | 30000 | 36 |
| `MAX_RETRY_COUNT` | int | 3 | 37 |
| `RETRY_DELAY_MS` | long | 500 | 38 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.adapter.StorageListAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ACTION_ENTER_SELECT_MODE` | int | 1 | 42 |
| `ACTION_EXIT_SELECT_MODE` | int | 2 | 43 |
| `ACTION_RETRY_LOAD` | int | 6 | 44 |
| `ACTION_VIDEO_ITEM_CLICK` | int | 3 | 45 |
| `VIEW_TYPE_DATE_TITLE` | int | 5 | 46 |
| `VIEW_TYPE_VIDEO_ITEM` | int | 6 | 47 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.fragment.StorageSdcardItemFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_SESSION_ID` | String | "device_session_id" | 89 |
| `RIDE3PRO_PAGE_SIZE` | int | 16 | 93 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.p011m3.M3FileAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `VIEW_TYPE_DATE_HEADER` | int | 0 | 52 |
| `VIEW_TYPE_FILE_ITEM` | int | 1 | 53 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.p011m3.M3StorageActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_SESSION_ID` | String | "device_session_id" | 95 |
| `MIN_STAY_DURATION_MS` | long | 2000 | 96 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.p011m3.M3StorageFileFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_FOLDER` | String | "folder" | 67 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.p011m3.M3StorageViewModel`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FOLDER_ALL` | String | "all" | 53 |
| `RECORDING_FREE_MB_THRESHOLD` | int | 0 | 54 |
| `TAG` | String | "M3StorageViewModel" | 55 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.p011m3.M3VideoPlayActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_CREATE_TIME` | String | "extra_create_time" | 100 |
| `EXTRA_DELETED_FILE_NAME` | String | "extra_deleted_file_name" | 101 |
| `EXTRA_DURATION` | String | "extra_duration" | 102 |
| `EXTRA_FILE_NAME` | String | "extra_file_name" | 103 |
| `EXTRA_FILE_SIZE` | String | "extra_file_size" | 104 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 105 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProHourDetailActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `COLUMN_COUNT` | int | 3 | 98 |
| `DISABLED_ALPHA` | float | 0.5f | 102 |
| `EXTRA_DATE` | String | "ride3pro_indexed_date" | 103 |
| `EXTRA_DEVICE_KEY` | String | "ride3pro_indexed_device_key" | 104 |
| `EXTRA_DEVICE_TYPE_CODE` | String | "device_type_code" | 105 |
| `EXTRA_HOUR` | String | "ride3pro_indexed_hour" | 106 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 107 |
| `INVALID_DATE` | int | -1 | 108 |
| `INVALID_HOUR` | int | -1 | 109 |
| `STATE_HOUR_TRACE_FINISHED` | String | "hour_trace_finished" | 110 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProHourDetailTitleFormatter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DAY_MODULUS` | int | 100 | 17 |
| `MONTH_DIVISOR` | int | 100 | 19 |
| `MONTH_MODULUS` | int | 100 | 20 |
| `TITLE_FORMAT` | String | "%04d-%02d-%02d %02d:00" | 21 |
| `YEAR_DIVISOR` | int | 10000 | 22 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProHourFileAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TIME_DISPLAY_FORMAT` | String | "%02d:%02d" | 37 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProHourFileThumbnailRequestFactory`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CACHE_KEY_NAMESPACE` | String | "ride3pro-hour-file" | 15 |
| `CACHE_KEY_SEPARATOR` | String | "\\|" | 16 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProHourPlaybackVideoItemMapper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DAY_DISPLAY_FORMAT` | String | "%04d-%02d-%02d" | 28 |
| `DAY_MODULUS` | int | 100 | 29 |
| `MILLIS_PER_SECOND` | long | 1000 | 30 |
| `MONTH_DIVISOR` | int | 100 | 31 |
| `MONTH_MODULUS` | int | 100 | 32 |
| `TIME_DISPLAY_FORMAT` | String | "%02d:%02d:00" | 33 |
| `YEAR_DIVISOR` | int | 10000 | 34 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProIndexedPlaybackModeAction`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MODE_PLAYBACK` | int | 2 | 25 |
| `SET_MODE_ENDPOINT` | String | "/api/setmode" | 28 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProIndexedStorageActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_DEVICE_KEY` | String | "ride3pro_indexed_device_key" | 59 |
| `EXTRA_DEVICE_TYPE_CODE` | String | "device_type_code" | 60 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 61 |
| `PLAYBACK_MODE_READY_REQUEST` | String | "ride3pro_indexed_playback_mode_ready" | 62 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProIndexedStorageAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DATE_HEADER_SPAN_SIZE` | int | 3 | 35 |
| `HOUR_GROUP_SPAN_SIZE` | int | 1 | 36 |
| `IDLE_ALPHA` | float | 1.0f | 37 |
| `INTERACTION_PAYLOAD` | String | "ride3pro-indexed-interaction" | 52 |
| `LOADING_ALPHA` | float | 0.5f | 38 |
| `THUMBNAIL_PAYLOAD` | String | "ride3pro-indexed-thumbnail" | 53 |
| `VIEW_TYPE_DATE_HEADER` | int | 0 | 39 |
| `VIEW_TYPE_HOUR_GROUP` | int | 1 | 40 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProIndexedStorageFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_DEVICE_KEY` | String | "ride3pro_indexed_device_key" | 93 |
| `ARG_SESSION_ID` | String | "device_session_id" | 94 |
| `COLUMN_COUNT` | int | 3 | 95 |
| `MONTH_MULTIPLIER` | int | 100 | 99 |
| `STATE_STORAGE_TRACE_FINISHED` | String | "storage_trace_finished" | 100 |
| `YEAR_MULTIPLIER` | int | 10000 | 101 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProIndexedStorageListMapper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DATE_DISPLAY_FORMAT` | String | "%04d-%02d-%02d" | 29 |
| `DAY_BEFORE_YESTERDAY_OFFSET_DAYS` | long | 2 | 30 |
| `DAY_MODULUS` | int | 100 | 31 |
| `HOUR_DISPLAY_FORMAT` | String | "%02d:00" | 32 |
| `MILLIS_PER_DAY` | long | 86400000 | 33 |
| `MONTH_DIVISOR` | int | 100 | 34 |
| `MONTH_MODULUS` | int | 100 | 35 |
| `TODAY_OFFSET_DAYS` | long | 0 | 36 |
| `YEAR_DIVISOR` | int | 10000 | 38 |
| `YESTERDAY_OFFSET_DAYS` | long | 1 | 39 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProIndexedThumbnailRequestFactory`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `CACHE_KEY_NAMESPACE` | String | "ride3pro-indexed-hour" | 14 |
| `CACHE_KEY_SEPARATOR` | String | "\\|" | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProIndexedTraceContextExtrasKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_PREFIX` | String | "ride3pro_indexed_trace" | 15 |
| `INVALID_TRACE_VALUE` | long | -1 | 16 |
| `TRACE_ID_KEY` | String | "ride3pro_indexed_trace.trace_id" | 17 |
| `TRACE_STARTED_AT_KEY` | String | "ride3pro_indexed_trace.started_at_elapsed_ms" | 18 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProPendingHourTraceStateKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_PENDING_HOUR_TRACE_PREFIX` | String | "ride3pro_pending_hour_trace" | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProStorageActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_DEVICE_TYPE_CODE` | String | "device_type_code" | 97 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 98 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProStorageCapabilityProbe`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_COUNT_ENDPOINT` | String | "/api/playback/filecount" | 29 |
| `MODE_PLAYBACK` | int | 2 | 32 |
| `SET_MODE_ENDPOINT` | String | "/api/setmode" | 35 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProStorageEntryTraceSessionStateKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `TRACE_CONTEXT_PREFIX` | String | "ride3pro_storage_entry_trace_session" | 13 |
| `TRACE_FINISHED_KEY` | String | "ride3pro_storage_entry_trace_session.finished" | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProStorageFileAdapter`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FILE_ID_MASK` | long | 4294967295L | 53 |
| `FILE_ID_NAMESPACE` | long | 4611686018427387904L | 54 |
| `FNV_64_OFFSET_BASIS` | long | -3750763034362895579L | 55 |
| `FNV_64_PRIME` | long | 1099511628211L | 56 |
| `HEADER_ID_NAMESPACE` | long | Long.MIN_VALUE | 57 |
| `PAYLOAD_SELECT_MODE` | String | "payload_select_mode" | 59 |
| `PAYLOAD_SELECTION_STATE` | String | "payload_selection_state" | 58 |
| `VIEW_TYPE_DATE_HEADER` | int | 0 | 60 |
| `VIEW_TYPE_FILE_ITEM` | int | 1 | 61 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProStorageFileFragment`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_TAB` | String | "tab" | 82 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProStorageLoadingDialog`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ARG_DEVICE_TYPE_CODE` | String | "device_type_code" | 72 |
| `TAG` | String | "Ride3ProStorageLoadingDialog" | 76 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProThumbnailPrefetchScheduler`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `RETRY_DELAY_MS` | long | 1000 | 29 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.StorageManagerActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_FORMAT_SUCCESS` | String | "extra_format_success" | 60 |
| `EXTRA_SESSION_ID` | String | "device_session_id" | 61 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.StorageSdFormatReminderPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MILLIS_PER_DAY` | long | 86400000 | 12 |
| `OVERDUE_DAYS` | int | 30 | 13 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.StorageSdInfoPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `UI_STATUS_ABNORMAL` | int | -1 | 17 |
| `UI_STATUS_NO_CARD` | int | 0 | 19 |
| `UI_STATUS_NORMAL` | int | 1 | 18 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.StorageTabActivity`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `EXTRA_SESSION_ID` | String | "device_session_id" | 66 |
| `REQUEST_STORAGE_MANAGER` | int | 1001 | 67 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.StorageTabKeys`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BACK_EMR` | String | "back_emr" | 10 |
| `BACK_NORM` | String | "back_norm" | 11 |
| `BACK_PHOTO` | String | "back_photo" | 12 |
| `EMR` | String | "emr" | 13 |
| `NORM` | String | "norm" | 15 |
| `PHOTO` | String | "photo" | 16 |
| `RIDE3PRO_PHOTO` | String | "ride3pro_photo" | 17 |
| `RIDE3PRO_VIDEO` | String | "ride3pro_video" | 18 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.StorageTabPolicy`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BOARD_COMPANY_MARKER` | String | "SYX" | 17 |

### `com.tuwinsmart.tuwin.presentation.widget.FirmwareUploadRingView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FULL_SWEEP` | float | 360.0f | 25 |
| `START_ANGLE` | float | -90.0f | 28 |
| `STROKE_WIDTH_DP` | float | 5.0f | 31 |

### `com.tuwinsmart.tuwin.presentation.widget.LoadingTextView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DOT_COUNT` | int | 3 | 11 |

### `com.tuwinsmart.tuwin.presentation.widget.RecordingControlEventsView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MARKER_RADIUS_DP` | float | 5.5f | 74 |

### `com.tuwinsmart.tuwin.presentation.widget.Ride3ProLoadingCardView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BOTTOM_PADDING_DP` | int | 22 | 23 |
| `ELEVATION_DP` | int | 6 | 27 |
| `HORIZONTAL_PADDING_DP` | int | 22 | 28 |
| `HORIZONTAL_WINDOW_INSET_DP` | int | 32 | 29 |
| `TOP_PADDING_DP` | int | 24 | 30 |
| `WINDOW_COORDINATE_COUNT` | int | 2 | 31 |
| `Y_COORDINATE` | int | 1 | 32 |

### `com.tuwinsmart.tuwin.presentation.widget.ride5.Ride5LoadingCardView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BOTTOM_PADDING_DP` | int | 22 | 23 |
| `ELEVATION_DP` | int | 6 | 25 |
| `HORIZONTAL_PADDING_DP` | int | 22 | 26 |
| `HORIZONTAL_WINDOW_INSET_DP` | int | 32 | 27 |
| `TOP_PADDING_DP` | int | 24 | 28 |
| `WINDOW_COORDINATE_COUNT` | int | 2 | 29 |
| `Y_COORDINATE` | int | 1 | 30 |

### `com.tuwinsmart.tuwin.presentation.widget.roundcorners.RoundImageView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MODE_CIRCLE` | int | 1 | 13 |
| `MODE_NONE` | int | 0 | 14 |
| `MODE_ROUND` | int | 2 | 15 |

### `com.tuwinsmart.tuwin.presentation.widget.video.FFDecodeFrame`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FFDECODE_FORMAT_YUV420P` | int | 0 | 14 |
| `FFDECODE_FORMAT_YUV422P` | int | 1 | 15 |
| `FFDECODE_FORMAT_YUV444P` | int | 2 | 16 |
| `FFDECODE_FORMAT_YUVJ420P` | int | 3 | 17 |
| `FFDECODE_FORMAT_YUVJ422P` | int | 4 | 18 |
| `FFDECODE_FORMAT_YUVJ444P` | int | 5 | 19 |

### `com.tuwinsmart.tuwin.presentation.widget.video.FFmpegPlayerView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `MAX_RETRY_COUNT` | int | 5 | 49 |
| `RETRY_DELAY_MS` | long | 500 | 50 |
| `RTSP_CLOSE_POLL_INTERVAL_MS` | long | 20 | 51 |
| `RTSP_CLOSE_TIMEOUT_MS` | long | 5000 | 52 |
| `SNAPSHOT_TIMEOUT_MS` | long | 3000 | 53 |
| `STATUS_BUFFERING` | int | 4 | 54 |
| `STATUS_PLAYING` | int | 0 | 55 |
| `STATUS_STOPPED` | int | 1 | 56 |
| `TAG` | String | "FFmpegPlayerView" | 57 |

### `com.tuwinsmart.tuwin.presentation.widget.video.FFmpegRtspOptions`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_ANALYZE_DURATION_US` | int | 1000000 | 19 |
| `DEFAULT_PROBE_SIZE_BYTES` | int | 32768 | 20 |

### `com.tuwinsmart.tuwin.presentation.widget.video.FFmpegTexturePlayerView`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `FRAME_DELAY_MS` | long | 16 | 51 |
| `MAX_RETRY_COUNT` | int | 5 | 52 |
| `RETRY_DELAY_MS` | long | 500 | 53 |
| `TAG` | String | "FFmpegTexturePlayerView" | 54 |

### `com.tuwinsmart.tuwin.presentation.widget.video.PlayListControlVideo`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `GESTURE_TAG` | String | "PlayListGesture" | 40 |

### `com.tuwinsmart.tuwin.Ride3ProPreviewHandshakeBackgroundController`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `BACKGROUND_CACHE_CLEAR_DELAY_MS` | long | 5000 | 18 |

### `com.tuwinsmart.tuwin.TuwinApplication`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `INTERNET_WEBVIEW_DATA_DIRECTORY_SUFFIX` | String | "internet" | 145 |
| `RELEASE_CHANNEL` | String | "stable" | 146 |
| `SERVER_ENVIRONMENT` | String | "production" | 147 |
| `UMENG_APP_KEY` | String | "6781b8f38f232a05f1f56ef5" | 148 |
| `UMENG_CHANNEL` | String | "Umeng" | 149 |

### `com.xuliwen.zoom.ZoomLayout`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `DEFAULT_DOUBLE_CLICK_ZOOM` | float | 2.0f | 23 |
| `DEFAULT_MAX_ZOOM` | float | 4.0f | 24 |
| `DEFAULT_MIN_ZOOM` | float | 1.0f | 25 |
| `TAG` | String | "ZoomLayout" | 26 |

### `es.dmoral.toasty.Toasty`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `LENGTH_LONG` | int | 1 | 17 |
| `LENGTH_SHORT` | int | 0 | 18 |

### `org.koin.android.ext.koin.ModuleExtKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ERROR_MSG` | String | "Please use androidContext() function in your KoinApplication configuration." | 17 |

### `org.koin.core.instance.InstanceFactory`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ERROR_SEPARATOR` | String | "\n\t" | 19 |

### `org.koin.core.logger.LoggerKt`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KOIN_TAG` | String | "[Koin]" | 10 |

### `org.koin.core.registry.ScopeRegistry`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ROOT_SCOPE_ID` | String | "_root_" | 29 |

### `org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `f3865a` | String | "OpenIdHelper" | 11 |

### `ren.yale.android.cachewebviewlib.utils.OKHttpFile`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `ENTRY_BODY` | int | 1 | 16 |
| `ENTRY_METADATA` | int | 0 | 17 |

### `ren.yale.android.cachewebviewlib.WebViewCacheInterceptor`

| 常量 | 类型 | 值 | 行 |
|---|---|---|---|
| `KEY_CACHE` | String | "WebResourceInterceptor-Key-Cache" | 35 |
