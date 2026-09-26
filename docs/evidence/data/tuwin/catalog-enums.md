# TUWIN — 枚举常量全量目录

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 350 个枚举常量，分布在 88 个枚举类型；括号内是构造实参（命令号、端口、路径等）

---

### `com.release.alert.Alert$Type`

| 常量 | 实参 | 行 |
|---|---|---|
| `NORMAL` |  | 74 |
| `PROGRESS` |  | 75 |
| `BOTTOM` |  | 76 |
| `INPUT` |  | 77 |
| `TWO_INPUT` |  | 78 |

### `com.tuwinsmart.tuwin.core.device.DeviceSessionState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `WAITING_FOR_ROUTE` |  | 13 |
| `PROBING_IDENTITY` |  | 14 |
| `ROUTE_VERIFIED` |  | 15 |
| `OPENING_CONTROL_CHANNEL` |  | 16 |
| `LOADING_CAPABILITIES` |  | 17 |
| `READY` |  | 18 |
| `DEGRADED` |  | 19 |
| `CLOSING` |  | 20 |
| `CLOSED` |  | 21 |
| `FAILED` |  | 22 |

### `com.tuwinsmart.tuwin.core.device.p005m3.M3ControlChannelState`

| 常量 | 实参 | 行 |
|---|---|---|
| `READY` |  | 12 |
| `RECOVERING` |  | 13 |
| `RECOVERABLE` |  | 14 |
| `UNAVAILABLE` |  | 15 |

### `com.tuwinsmart.tuwin.core.device.p005m3.M3SessionRepositoryFactory$RepositoryRouteKind`

| 常量 | 实参 | 行 |
|---|---|---|
| `CONTROL` | DeviceOperationKind.CONTROL, HttpClientProfile.DEVICE_CONTROL, EndpointPurpose.CONTROL | 680 |
| `OTA` | DeviceOperationKind.OTA, HttpClientProfile.DEVICE_UPLOAD, EndpointPurpose.OTA | 681 |
| `RepositoryRouteKind` | DeviceOperationKind deviceOperationKind, HttpClientProfile httpClientProfile, EndpointPurpose endpointPurpose | 692 |
| `if` | this == OTA | 713 |

### `com.tuwinsmart.tuwin.core.device.ride3pro.Ride3ProRequestPriority`

| 常量 | 实参 | 行 |
|---|---|---|
| `CRITICAL` | 5 | 12 |
| `HIGH` | 4 | 13 |
| `NORMAL` | 3 | 14 |
| `LOW` | 2 | 15 |
| `EXCLUSIVE` | 1 | 16 |
| `Ride3ProRequestPriority` | int i | 25 |

### `com.tuwinsmart.tuwin.core.internet.ExternalWebCommand`

| 常量 | 实参 | 行 |
|---|---|---|
| `BACK` |  | 12 |
| `FEEDBACK` |  | 13 |

### `com.tuwinsmart.tuwin.core.media.MediaEndpointProtocol`

| 常量 | 实参 | 行 |
|---|---|---|
| `RTSP` |  | 12 |
| `HTTP` |  | 13 |

### `com.tuwinsmart.tuwin.core.media.MediaState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `PREPARING_DEVICE` |  | 13 |
| `ACQUIRING_DEVICE_BINDING` |  | 14 |
| `CONNECTING_MEDIA` |  | 15 |
| `PLAYING` |  | 16 |
| `FIRST_FRAME_RECEIVED` |  | 17 |
| `BUFFERING` |  | 18 |
| `STOPPING` |  | 19 |
| `CLOSED` |  | 20 |
| `FAILED` |  | 21 |

### `com.tuwinsmart.tuwin.core.media.RtspTransport`

| 常量 | 实参 | 行 |
|---|---|---|
| `AUTO` |  | 12 |
| `TCP` |  | 13 |
| `UDP` |  | 14 |

### `com.tuwinsmart.tuwin.core.network.DeviceEndpointProtocol`

| 常量 | 实参 | 行 |
|---|---|---|
| `HTTP` |  | 12 |
| `RTSP` |  | 13 |
| `TCP` |  | 14 |

### `com.tuwinsmart.tuwin.core.network.DeviceOperationKind`

| 常量 | 实参 | 行 |
|---|---|---|
| `PROBE` |  | 12 |
| `CONTROL` |  | 13 |
| `FILE` |  | 14 |
| `IMAGE` |  | 15 |
| `MEDIA` |  | 16 |
| `CALLBACK` |  | 17 |
| `OTA` |  | 18 |
| `DIAGNOSTIC` |  | 19 |

### `com.tuwinsmart.tuwin.core.network.DeviceRouteState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `CANDIDATE` |  | 13 |
| `PROBING` |  | 14 |
| `VERIFIED` |  | 15 |
| `REJECTED` |  | 16 |
| `LOST` |  | 17 |

### `com.tuwinsmart.tuwin.core.network.DeviceWifiRequestFailure`

| 常量 | 实参 | 行 |
|---|---|---|
| `DISABLED` |  | 12 |
| `UNSUPPORTED_ANDROID_VERSION` |  | 13 |
| `INVALID_REQUEST` |  | 14 |
| `PERMISSION_DENIED` |  | 15 |
| `UNAVAILABLE` |  | 16 |

### `com.tuwinsmart.tuwin.core.network.DynamicEndpointHostPolicy`

| 常量 | 实参 | 行 |
|---|---|---|
| `SAME_AS_CONTROL_HOST` |  | 12 |

### `com.tuwinsmart.tuwin.core.network.EndpointGrantSource`

| 常量 | 实参 | 行 |
|---|---|---|
| `PROFILE_BOOTSTRAP` |  | 12 |
| `DEVICE_PROBE_RESPONSE` |  | 13 |
| `DEVICE_MEDIA_RESPONSE` |  | 14 |
| `DEVICE_FILE_LIST` |  | 15 |
| `USER_SELECTED_ENDPOINT` |  | 16 |

### `com.tuwinsmart.tuwin.core.network.EndpointPurpose`

| 常量 | 实参 | 行 |
|---|---|---|
| `PROBE` |  | 12 |
| `CONTROL` |  | 13 |
| `FILE` |  | 14 |
| `IMAGE` |  | 15 |
| `MEDIA` |  | 16 |
| `CALLBACK` |  | 17 |
| `MENU` |  | 18 |
| `OTA` |  | 19 |
| `DIAGNOSTIC` |  | 20 |

### `com.tuwinsmart.tuwin.core.network.HttpClientProfile`

| 常量 | 实参 | 行 |
|---|---|---|
| `INTERNET_API` |  | 12 |
| `INTERNET_DOWNLOAD` |  | 13 |
| `INTERNET_UPLOAD` |  | 14 |
| `DEVICE_PROBE` |  | 15 |
| `DEVICE_CONTROL` |  | 16 |
| `DEVICE_DIAGNOSTIC` |  | 17 |
| `DEVICE_LONG_OPERATION` |  | 18 |
| `DEVICE_FILE` |  | 19 |
| `DEVICE_MENU` |  | 20 |
| `DEVICE_UPLOAD` |  | 21 |
| `DEVICE_IMAGE` |  | 22 |

### `com.tuwinsmart.tuwin.core.network.NetworkPlane`

| 常量 | 实参 | 行 |
|---|---|---|
| `INTERNET` |  | 12 |
| `DEVICE` |  | 13 |

### `com.tuwinsmart.tuwin.core.network.ProcessBindingType`

| 常量 | 实参 | 行 |
|---|---|---|
| `TEMPORARY_PROBE` |  | 12 |
| `VERIFIED_DEVICE_SESSION` |  | 13 |
| `MEDIA_SESSION` |  | 14 |
| `CALLBACK_SESSION` |  | 15 |
| `INTERNET_PROCESS` |  | 16 |

### `com.tuwinsmart.tuwin.core.network.RoutePermission`

| 常量 | 实参 | 行 |
|---|---|---|
| `PROBE_ONLY` |  | 12 |
| `DEVICE_OPERATION` |  | 13 |

### `com.tuwinsmart.tuwin.core.network.RouteState`

| 常量 | 实参 | 行 |
|---|---|---|
| `UNAVAILABLE` |  | 12 |
| `CANDIDATE` |  | 13 |
| `PROBING` |  | 14 |
| `VERIFIED` |  | 15 |
| `READY` |  | 16 |
| `LOST` |  | 17 |
| `REJECTED` |  | 18 |

### `com.tuwinsmart.tuwin.core.network.TopologyChangeKind`

| 常量 | 实参 | 行 |
|---|---|---|
| `AVAILABLE` |  | 12 |
| `CAPABILITIES_CHANGED` |  | 13 |
| `LINK_PROPERTIES_CHANGED` |  | 14 |
| `LOST` |  | 15 |

### `com.tuwinsmart.tuwin.core.transfer.TransferHttpMethod`

| 常量 | 实参 | 行 |
|---|---|---|
| `POST` |  | 12 |
| `PUT` |  | 13 |

### `com.tuwinsmart.tuwin.core.update.AppUpdateCheckState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `WAITING_FOR_INTERNET_ROUTE` |  | 13 |
| `CHECKING` |  | 14 |
| `NO_UPDATE` |  | 15 |
| `UPDATE_AVAILABLE` |  | 16 |
| `CHECK_FAILED` |  | 17 |
| `CHECK_CANCELLED` |  | 18 |

### `com.tuwinsmart.tuwin.core.update.DeviceOtaState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `QUERYING` |  | 13 |
| `UPDATE_AVAILABLE` |  | 14 |
| `DOWNLOADING_PACKAGE` |  | 15 |
| `VERIFYING_PACKAGE` |  | 16 |
| `WAITING_FOR_DEVICE` |  | 17 |
| `UPLOADING_TO_DEVICE` |  | 18 |
| `INSTALLING` |  | 19 |
| `WAITING_FOR_REBOOT` |  | 20 |
| `RECONNECTING` |  | 21 |
| `CONFIRMING_VERSION` |  | 22 |
| `COMPLETED` |  | 23 |
| `FAILED` |  | 24 |
| `CANCELLED` |  | 25 |

### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$DownloadFileTaskPhase`

| 常量 | 实参 | 行 |
|---|---|---|
| `DOWNLOADING` |  | 163 |
| `TRANSCODING` |  | 164 |

### `com.tuwinsmart.tuwin.core.util.download.DownloadUtil$DownloadRestartMode`

| 常量 | 实参 | 行 |
|---|---|---|
| `REDOWNLOAD` |  | 176 |
| `CONTINUE` |  | 177 |

### `com.tuwinsmart.tuwin.core.util.download.Ride3ProPlaybackDownloadResumePolicy$Reason`

| 常量 | 实参 | 行 |
|---|---|---|
| `SUPPORTED` |  | 32 |
| `NOT_RAW_DATA` |  | 33 |
| `VERSION_UNAVAILABLE` |  | 34 |
| `VERSION_INVALID` |  | 35 |
| `LEGACY_FIRMWARE` |  | 36 |

### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedPageDecision`

| 常量 | 实参 | 行 |
|---|---|---|
| `CONTINUE` |  | 12 |
| `COMPLETE` |  | 13 |
| `NO_VALID_RECORDINGS` |  | 14 |
| `FAILURE` |  | 15 |

### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedScanOutcome`

| 常量 | 实参 | 行 |
|---|---|---|
| `LOADED` |  | 12 |
| `NO_VALID_RECORDINGS` |  | 13 |
| `FAILURE` |  | 14 |

### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedScreen`

| 常量 | 实参 | 行 |
|---|---|---|
| `STORAGE_ENTRY` |  | 12 |
| `INDEXED_STORAGE` |  | 13 |

### `com.tuwinsmart.tuwin.core.util.logging.Ride3ProIndexedVisibilityOutcome`

| 常量 | 实参 | 行 |
|---|---|---|
| `CONTENT` |  | 12 |
| `EMPTY` |  | 13 |
| `ERROR` |  | 14 |
| `LEGACY_ROUTE` |  | 15 |

### `com.tuwinsmart.tuwin.core.util.StartupOtaCheckCohort$StartupDeviceIdentity$Kind`

| 常量 | 实参 | 行 |
|---|---|---|
| `DEVICE_ID` |  | 216 |
| `SSID` |  | 217 |
| `SESSION_ID` |  | 218 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProHourScanCompletionReason`

| 常量 | 实参 | 行 |
|---|---|---|
| `EMPTY_PAGE` |  | 12 |
| `SHORT_PAGE` |  | 13 |
| `NON_TARGET_BOUNDARY` |  | 14 |
| `AVAILABLE_FILES_CYCLE` |  | 15 |
| `DEFAULT_TIME_LIMIT` |  | 16 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProHourScanFailureReason`

| 常量 | 实参 | 行 |
|---|---|---|
| `ALREADY_TERMINAL` |  | 12 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProHourTimeRelation`

| 常量 | 实参 | 行 |
|---|---|---|
| `OLDER` |  | 12 |
| `TARGET` |  | 13 |
| `NEWER` |  | 14 |

### `com.tuwinsmart.tuwin.data.repository.Ride3ProPreviewPrepareWarning`

| 常量 | 实参 | 行 |
|---|---|---|
| `SEND_TIME_FAILED` |  | 12 |
| `RECORDING_START_FAILED` |  | 13 |

### `com.tuwinsmart.tuwin.data.source.remote.gateway.DeviceLogDownloadStatus`

| 常量 | 实参 | 行 |
|---|---|---|
| `DOWNLOADED` |  | 12 |
| `SKIPPED_NOT_READY` |  | 13 |
| `FAILED` |  | 14 |

### `com.tuwinsmart.tuwin.data.source.remote.gateway.DiagnosticUploadStatus`

| 常量 | 实参 | 行 |
|---|---|---|
| `UPLOADED` |  | 12 |
| `UNAVAILABLE` |  | 13 |
| `FAILED` |  | 14 |

### `com.tuwinsmart.tuwin.domain.model.ConnectionProgress`

| 常量 | 实参 | 行 |
|---|---|---|
| `CONNECTING` |  | 12 |
| `AUTHENTICATING` |  | 13 |
| `SYNCING_TIME` |  | 14 |
| `FETCHING_DEVICE_INFO` |  | 15 |
| `RIDE5_IDENTIFYING_NETWORK` |  | 16 |
| `RIDE5_REGISTERING_DEVICE` |  | 17 |
| `RIDE5_VERIFYING_ONLINE` |  | 18 |
| `RIDE5_FETCHING_DEVICE_INFO` |  | 19 |
| `M3_DETECTING_HTTP` |  | 20 |
| `M3_VALIDATING_DEVICE` |  | 21 |
| `M3_FETCHING_MEDIA_INFO` |  | 22 |
| `M3_CONNECTING_CONTROL` |  | 23 |
| `M3_FETCHING_DEVICE_INFO` |  | 24 |

### `com.tuwinsmart.tuwin.domain.model.DeviceType`

| 常量 | 实参 | 行 |
|---|---|---|
| `RIDE5` | "RIDE5", C1870R.string.riding_recorder, C1870R.string.ride5, C1870R.drawable.img_ride5 | 15 |
| `RIDE3PRO` | "RIDE3PRO", C1870R.string.riding_recorder, C1870R.string.ride3pro, C1870R.drawable.img_ride3pro | 16 |
| `M3` | M3OtaVersionPolicy.BOARD_VERSION, C1870R.string.thumb_camera, C1870R.string.device_m3, C1870R.drawable.img_m3 | 17 |
| `RIDE6` | "RIDE6", C1870R.string.riding_recorder, C1870R.string.ride6, C1870R.drawable.img_ride6 | 18 |
| `DeviceType` | String str, int i, int i2, int i3 | 30 |

### `com.tuwinsmart.tuwin.domain.model.RecordingControlAction`

| 常量 | 实参 | 行 |
|---|---|---|
| `STARTED` |  | 12 |
| `STOPPED` |  | 13 |
| `PLAYBACK_MODE_ENTERED` |  | 14 |

### `com.tuwinsmart.tuwin.domain.model.Ride3ProGroupLoadState`

| 常量 | 实参 | 行 |
|---|---|---|
| `NOT_LOADED` |  | 12 |
| `LOADING` |  | 13 |
| `LOADED` |  | 14 |
| `FAILED` |  | 15 |

### `com.tuwinsmart.tuwin.domain.model.ride5.Ride5FileInfo$LoadState`

| 常量 | 实参 | 行 |
|---|---|---|
| `OK` |  | 27 |
| `FAILED` |  | 28 |

### `com.tuwinsmart.tuwin.domain.strategy.ConnectionCheckMode`

| 常量 | 实参 | 行 |
|---|---|---|
| `FULL` |  | 12 |
| `LIGHTWEIGHT_REFRESH` |  | 13 |

### `com.tuwinsmart.tuwin.presentation.dialog.ConnectDialogViewModel$WifiScanUiEvent`

| 常量 | 实参 | 行 |
|---|---|---|
| `TOO_FREQUENT` |  | 113 |

### `com.tuwinsmart.tuwin.presentation.dialog.ConnectionProgressDialog$Mode`

| 常量 | 实参 | 行 |
|---|---|---|
| `RUNNING` |  | 35 |
| `FAILED` |  | 36 |
| `RETRYING` |  | 37 |
| `WARNING` |  | 38 |

### `com.tuwinsmart.tuwin.presentation.dialog.DeviceWifiScanDialog$Mode`

| 常量 | 实参 | 行 |
|---|---|---|
| `SCANNING` |  | 69 |
| `READY` |  | 70 |
| `EMPTY` |  | 71 |

### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareDownloadStatus`

| 常量 | 实参 | 行 |
|---|---|---|
| `DOWNLOADING` |  | 12 |
| `COMPLETED` |  | 13 |
| `FAILED` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.dialog.FirmwareUploadUiState$Mode`

| 常量 | 实参 | 行 |
|---|---|---|
| `UPLOADING` |  | 26 |
| `AWAITING_ACKNOWLEDGEMENT` |  | 27 |
| `UPLOAD_FAILED` |  | 28 |
| `EXTERNAL_POWER_CHECK` |  | 29 |
| `INSTALLING` |  | 30 |
| `INSTALLED` |  | 31 |
| `INSTALLATION_FAILED` |  | 32 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProPlaybackDeleteCapability`

| 常量 | 实参 | 行 |
|---|---|---|
| `LEGACY_SUPPORTED` | true | 12 |
| `INDEXED_SUPPORTED` | true | 13 |
| `UNSUPPORTED` | false | 14 |
| `Ride3ProPlaybackDeleteCapability` | boolean z | 23 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProPlaybackRelation`

| 常量 | 实参 | 行 |
|---|---|---|
| `SYNCED` |  | 12 |
| `PENDING_SWITCH` |  | 13 |
| `NO_SELECTION` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProPlaybackRelationAction`

| 常量 | 实参 | 行 |
|---|---|---|
| `REPLAY` |  | 12 |
| `SWITCH` |  | 13 |
| `DISABLED` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.Ride3ProShareFlowController$ShareStage`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 27 |
| `PREPARING` |  | 28 |
| `DOWNLOADING` |  | 29 |
| `TRANSCODING` |  | 30 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ride5.Ride5PlaybackState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `PREPARING` |  | 13 |
| `PLAYING` |  | 14 |
| `PAUSED` |  | 15 |
| `COMPLETED` |  | 16 |
| `ERROR` |  | 17 |

### `com.tuwinsmart.tuwin.presentation.p010ui.album.ShareFileValidationPolicy$ShareAction`

| 常量 | 实参 | 行 |
|---|---|---|
| `SHARE_LOCAL_FILE` |  | 17 |
| `REDOWNLOAD_AND_SHARE` |  | 18 |

### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectFragmentShowRefreshAction`

| 常量 | 实参 | 行 |
|---|---|---|
| `CACHE_ONLY` |  | 12 |
| `FULL` |  | 13 |
| `NONE` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.connect.fragment.ConnectRefreshSource`

| 常量 | 实参 | 行 |
|---|---|---|
| `AUTO` |  | 12 |
| `MANUAL` |  | 13 |
| `FIRMWARE_RECONNECT` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailRide3ProSdAbnormalCardMessageType`

| 常量 | 实参 | 行 |
|---|---|---|
| `FORMAT_REQUIRED` |  | 12 |
| `NO_CARD` |  | 13 |
| `NORMAL` |  | 14 |
| `FORMAT_REMINDER` |  | 15 |
| `STORAGE_FULL` |  | 16 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailRide3ProSnapshotAction`

| 常量 | 实参 | 行 |
|---|---|---|
| `SaveVideoFrameToAlbum` |  | 12 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailRide3ProStorageException`

| 常量 | 实参 | 行 |
|---|---|---|
| `SD_FULL` |  | 12 |
| `RECORDING_WRITE` |  | 13 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailSdInfoSource`

| 常量 | 实参 | 行 |
|---|---|---|
| `RIDE3PRO` |  | 12 |
| `LEGACY` |  | 13 |
| `NONE` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailSettingsEntryRoute`

| 常量 | 实参 | 行 |
|---|---|---|
| `DEDICATED_M3` |  | 12 |
| `DEDICATED_RIDE3PRO` |  | 13 |
| `MORE_SETTINGS` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailSteamTypeSwitchDecision`

| 常量 | 实参 | 行 |
|---|---|---|
| `ALLOW` |  | 12 |
| `BLOCK_UNSUPPORTED` |  | 13 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailStorageEntryRoute`

| 常量 | 实参 | 行 |
|---|---|---|
| `CAPABILITY_ENTRY` |  | 12 |
| `LEGACY_STORAGE_TAB` |  | 13 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.DeviceDetailStreamPhase`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `PREPARING` |  | 13 |
| `BUFFERING` |  | 14 |
| `PLAYING` |  | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.detail.M3DeviceDetailViewModel$PhotoSocketTimeoutType`

| 常量 | 实参 | 行 |
|---|---|---|
| `NORMAL` |  | 178 |
| `TIMED` |  | 179 |
| `BURST` |  | 180 |

### `com.tuwinsmart.tuwin.presentation.p010ui.device.settings.Ride3ProSimpleSettingsItemType`

| 常量 | 实参 | 行 |
|---|---|---|
| `DEVICE_NAME` |  | 12 |
| `WIFI` |  | 13 |
| `STORAGE` |  | 14 |
| `FIRMWARE` |  | 15 |
| `FACTORY_RESET` |  | 16 |
| `REBOOT` |  | 17 |

### `com.tuwinsmart.tuwin.presentation.p010ui.download.CompletedDownloadPlaybackDecision`

| 常量 | 实参 | 行 |
|---|---|---|
| `IGNORE` |  | 12 |
| `SHOW_PHOTO` |  | 13 |
| `PLAY_VIDEO` |  | 14 |
| `CONFIRM_STOP` |  | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.home.adapter.HomeListPreviewState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `BUFFERING` |  | 13 |
| `PLAYING` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.FeedbackDeviceSelection`

| 常量 | 实参 | 行 |
|---|---|---|
| `RIDE3_PRO` |  | 13 |
| `RIDE5_SERIES` |  | 14 |
| `M3` |  | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.MoreSettingsUiItem`

| 常量 | 实参 | 行 |
|---|---|---|
| `EMERGENCY_RECORDING` |  | 12 |
| `PARKING_MONITOR` |  | 13 |
| `WIND_NOISE_REDUCTION` |  | 14 |
| `FLIP_VERTICAL` |  | 15 |
| `FLIP_HORIZONTAL` |  | 16 |
| `WIFI_MODE` |  | 17 |
| `FIRMWARE_UPDATE` |  | 18 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaCompletionSignal`

| 常量 | 实参 | 行 |
|---|---|---|
| `UploadAccepted` |  | 12 |
| `InstallationCompleted` |  | 13 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaFailurePrompt`

| 常量 | 实参 | 行 |
|---|---|---|
| `ExternalPowerCheck` |  | 12 |
| `M3SdCardRemoved` |  | 13 |
| `M3SdCardNotFormatted` |  | 14 |
| `M3InstallationTimeout` |  | 15 |
| `GenericInstallFailed` |  | 16 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaPreparation`

| 常量 | 实参 | 行 |
|---|---|---|
| `StopRecordingBeforeUpload` |  | 12 |
| `StopRecordingOnPageEntry` |  | 13 |
| `None` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.OtaTransportKind`

| 常量 | 实参 | 行 |
|---|---|---|
| `LegacyChunked` |  | 12 |
| `Ride3ProDirect` |  | 13 |
| `M3Direct` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeInstallConfirmButtonPolicy$ButtonPhase`

| 常量 | 实参 | 行 |
|---|---|---|
| `UpgradingCountdown` |  | 24 |
| `ConfirmReady` |  | 25 |

### `com.tuwinsmart.tuwin.presentation.p010ui.mine.UpgradeSuccessActionPolicy$ConfirmAction`

| 常量 | 实参 | 行 |
|---|---|---|
| `ReturnToHomeDeviceList` |  | 17 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.fragment.StorageRide3ProFileType`

| 常量 | 实参 | 行 |
|---|---|---|
| `VIDEO` |  | 12 |
| `PHOTO` |  | 13 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProHourDetailDeleteState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `DELETING` |  | 13 |
| `SUCCEEDED` |  | 14 |
| `FAILED` |  | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProHourDetailLoadState`

| 常量 | 实参 | 行 |
|---|---|---|
| `LOADING` |  | 12 |
| `LOADED` |  | 13 |
| `FAILED` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProIndexedStorageInitialLoadState`

| 常量 | 实参 | 行 |
|---|---|---|
| `IDLE` |  | 12 |
| `LOADING` |  | 13 |
| `LOADED` |  | 14 |
| `FAILED` |  | 15 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProRelativeDateLabel`

| 常量 | 实参 | 行 |
|---|---|---|
| `TODAY` |  | 12 |
| `YESTERDAY` |  | 13 |
| `DAY_BEFORE_YESTERDAY` |  | 14 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProStorageCapabilityRoute`

| 常量 | 实参 | 行 |
|---|---|---|
| `LEGACY` |  | 12 |
| `INDEXED` |  | 13 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProStorageTab`

| 常量 | 实参 | 行 |
|---|---|---|
| `VIDEO` | "video", C1870R.string.tab_video | 13 |
| `Ride3ProStorageTab` | String str, int i | 23 |

### `com.tuwinsmart.tuwin.presentation.p010ui.storage.ride3pro.Ride3ProThumbnailPrefetchResult`

| 常量 | 实参 | 行 |
|---|---|---|
| `COMPLETED` |  | 12 |
| `RETRY` |  | 13 |
| `FAILED` |  | 14 |

### `org.koin.core.definition.Kind`

| 常量 | 实参 | 行 |
|---|---|---|
| `Singleton` |  | 12 |
| `Factory` |  | 13 |
| `Scoped` |  | 14 |

### `org.koin.core.logger.Level`

| 常量 | 实参 | 行 |
|---|---|---|
| `DEBUG` |  | 12 |
| `INFO` |  | 13 |
| `WARNING` |  | 14 |
| `ERROR` |  | 15 |
| `NONE` |  | 16 |
