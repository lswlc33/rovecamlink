# TUWIN — 带格式化槽位的字面量全量（URL / 报文 / 参数模板）

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 134 条。这一张表是「参数值到底怎么拼」的直接证据：%s/%d 的位置就是运行时代码填进去的值

---

| 模板 | 所在类型 | 文件:行 |
|---|---|---|
| [RIDE5_PLAYBACK_SPEED] apply speed=%.1f soundTouch=true state=%s | Ride5HourlyPlaybackController | Ride5HourlyPlaybackController.java:220 |
| %.1fG/%.1fG | M3DeviceDetailViewModel | M3DeviceDetailViewModel.java:1150 |
| %.1fG/%.1fG | M3StorageViewModel | M3StorageViewModel.java:338 |
| %.2fGB | M3FileItem | M3FileItem.java:186 |
| %.2fMB | M3FileItem | M3FileItem.java:180 |
| %.2fTB | M3FileItem | M3FileItem.java:191 |
| %02d:%02d | M3FileItem | M3FileItem.java:211 |
| %02d:%02d | Ride3ProHourRecordingAdapter | Ride3ProHourRecordingAdapter.java:195 |
| %02d:%02d | Ride3ProHourTimelineView | Ride3ProHourTimelineView.java:234 |
| %02d:%02d | Ride5HourFileAdapter | Ride5HourFileAdapter.java:39 |
| %02d:%02d | Ride5HourRecordingAdapter | Ride5HourRecordingAdapter.java:177 |
| %02d:%02d | Ride5HourTimelineView | Ride5HourTimelineView.java:233 |
| %02d:%02d | Ride3ProHourFileAdapter | Ride3ProHourFileAdapter.java:37 |
| %02d:%02d:%02d | M3FileItem | M3FileItem.java:206 |
| %02d:%02d:%02d | Ride3ProHourTimelineView | Ride3ProHourTimelineView.java:388 |
| %02d:%02d:%02d | Ride5HourTimelineView | Ride5HourTimelineView.java:387 |
| %02d:%02d:%02d | M3DeviceDetailViewModel | M3DeviceDetailViewModel.java:3755 |
| %02d:%02d:00 | Ride3ProHourPlaybackVideoItemMapper | Ride3ProHourPlaybackVideoItemMapper.java:33 |
| %02d:00 | Ride3ProIndexedStorageListMapper | Ride3ProIndexedStorageListMapper.java:32 |
| %02x | AuthorizedTransferSource.Internet.Companion | AuthorizedTransferSource.java:134 |
| %02x | AuthorizedTransferSource.Device.Companion | AuthorizedTransferSource.java:216 |
| %02x | IntegrityVerifier | IntegrityVerifier.java:71 |
| %02x | Ride3ProFirmwareUploadRepository.uploadFirmware.3 | Ride3ProFirmwareUploadRepository$uploadFirmware$3.java:148 |
| %02x | Ride3ProPlaybackCatalogPersistentCacheStore | Ride3ProPlaybackCatalogPersistentCacheStore.java:332 |
| %02x | Ride3ProAviThumbnailCache | Ride3ProAviThumbnailCache.java:87 |
| %04d | Ride3ProApiServiceKt | Ride3ProApiServiceKt.java:131 |
| %04d-%02d-%02d | Ride3ProHourPlaybackVideoItemMapper | Ride3ProHourPlaybackVideoItemMapper.java:28 |
| %04d-%02d-%02d | Ride3ProIndexedStorageListMapper | Ride3ProIndexedStorageListMapper.java:29 |
| %04d-%02d-%02d %02d:00 | Ride3ProHourDetailTitleFormatter | Ride3ProHourDetailTitleFormatter.java:21 |
| %d:%02d | DailyListAdapter | DailyListAdapter.java:262 |
| %d:%02d | LocalDownloadListAdapter | LocalDownloadListAdapter.java:475 |
| %s åºä»¶åçº§å¥å£ç¼ºå°å¯ä¸ä¼è¯è®¾å¤èº«ä»½: session=%s | Ride3ProSettingsActivity | Ride3ProSettingsActivity.java:933 |
| %s features unavailable: session=%s | Ride3ProSettingsActivity | Ride3ProSettingsActivity.java:1242 |
| %s/s | DownloadFileItemViewHolder | DownloadFileItemViewHolder.java:108 |
| %s/s | DownloadItemViewHolder | DownloadItemViewHolder.java:102 |
| æ´å¤è®¾ç½®æç»æªç»å®åä¸è®¾å¤èº«ä»½ç RIDE5 ä¼è¯: identity=%s operation=%s | MoreSettingsActivity | MoreSettingsActivity.java:409 |
| åºä»¶åçº§æç»æªç»å®åä¸è®¾å¤èº«ä»½çä¼è¯: identity=%s operation=%s type=%s | UpgradeActivity | UpgradeActivity.java:452 |
| DeviceDetailActivity: stale session rebound to verified device session %s | DeviceDetailActivity | DeviceDetailActivity.java:545 |
| DeviceDetailActivity: unsupported preview device type: %s | DeviceDetailActivity | DeviceDetailActivity.java:1690 |
| è¯»åè®¾å¤åæ°: type=%s pType=%d | MoreSettingsActivity | MoreSettingsActivity.java:2070 |
| è¯»åè®¾å¤éç¨åæ°: type=%s | MoreSettingsActivity | MoreSettingsActivity.java:2450 |
| è®¾å¤ Wi-Fi æ¬å°éåæ´æ°è·³è¿: oldLength=%d newLength=%d | MoreSettingsActivity | MoreSettingsActivity.java:2457 |
| è®¾ç½®è®¾å¤åæ°: type=%s pType=%d | MoreSettingsActivity | MoreSettingsActivity.java:1461 |
| FILE%04d.mp4 | Ride3ProPlaybackFileMapper | Ride3ProPlaybackFileMapper.java:101 |
| from assets: %s | WebViewCacheInterceptor | WebViewCacheInterceptor.java:253 |
| from cache: %s | WebViewCacheInterceptor | WebViewCacheInterceptor.java:267 |
| from dynamic file: %s | WebViewCacheInterceptor | WebViewCacheInterceptor.java:243 |
| from server: %s | WebViewCacheInterceptor | WebViewCacheInterceptor.java:269 |
| M3 åºä»¶åçº§å¥å£ç¼ºå°å¯ä¸ä¼è¯è®¾å¤èº«ä»½: session=%s | M3DeviceSettingsActivity | M3DeviceSettingsActivity.java:245 |
| M3 download authorization failed: session=%s | M3StorageActivity | M3StorageActivity.java:742 |
| M3 download authorization failed: session=%s | M3VideoPlayActivity | M3VideoPlayActivity.java:794 |
| M3 download enqueue failed: session=%s | M3StorageActivity | M3StorageActivity.java:765 |
| M3 download enqueue failed: session=%s | M3VideoPlayActivity | M3VideoPlayActivity.java:812 |
| M3 file media start failed: session=%s | M3VideoPlayActivity.C28601 | M3VideoPlayActivity.java:688 |
| M3 media session is unavailable: session=%s | M3VideoPlayActivity.C28601 | M3VideoPlayActivity.java:666 |
| M3 reconnect rejected: network %s already belongs to another device session | M3SessionConnector | M3SessionConnector.java:1276 |
| M3: reuse active session %s on network %s | M3SessionConnector | M3SessionConnector.java:360 |
| MOVI%04d | Ride3ProPlaybackFileMapper | Ride3ProPlaybackFileMapper.java:90 |
| MOVI%04d. | Ride3ProShareVideoFilePolicy | Ride3ProShareVideoFilePolicy.java:54 |
| MOVI%04d.MP4 | Ride3ProShareVideoFilePolicy | Ride3ProShareVideoFilePolicy.java:79 |
| OTA startup check batch started: devices=%d, candidates=%d, complete=%s | UpgradeHelper | UpgradeHelper.java:163 |
| OTA startup cohort progress: checkedCandidates=%d | UpgradeHelper | UpgradeHelper.java:165 |
| PICT%04d.jpg | Ride3ProPlaybackFileMapper | Ride3ProPlaybackFileMapper.java:96 |
| PlayListGesture ACTION_DOWN, x=%.1f, y=%.1f, enabled=%s | PlayListControlVideo | PlayListControlVideo.java:308 |
| PlayListGesture ACTION_UP seek skipped, invalid duration=%d | PlayListControlVideo | PlayListControlVideo.java:366 |
| PlayListGesture ACTION_UP seekTo, start=%d, target=%d, duration=%d, dx=%.1f, width=%d | PlayListControlVideo | PlayListControlVideo.java:363 |
| PlayListGesture excluded zone hit=%s, x=%.1f, y=%.1f, rect=[%d,%d,%d,%d] | PlayListControlVideo | PlayListControlVideo.java:486 |
| PlayListGesture gesture start pos=%d, duration=%d | PlayListControlVideo | PlayListControlVideo.java:314 |
| PlayListGesture multi-pointer ignored, pointerCount=%d, action=%d | PlayListControlVideo | PlayListControlVideo.java:293 |
| PlayListGesture onDoubleTap ignored, enabled=%s, x=%.1f, y=%.1f | PlayListControlVideo | PlayListControlVideo.java:182 |
| PlayListGesture onDoubleTap triggered, x=%.1f, y=%.1f, state=%d | PlayListControlVideo | PlayListControlVideo.java:185 |
| PlayListGesture seek detected, dx=%.1f, dy=%.1f, touchSlop=%d | PlayListControlVideo | PlayListControlVideo.java:326 |
| PlayListGesture seekToFromGesture target=%d | PlayListControlVideo | PlayListControlVideo.java:420 |
| PlayListGesture togglePlayPauseFromGesture currentState=%d | PlayListControlVideo | PlayListControlVideo.java:426 |
| R6 GetParameter failed: id=%s, %s | Ride6SettingsProtocolClient | Ride6SettingsProtocolClient.java:386 |
| R6 GetParameter(all) failed: %s | Ride6SettingsProtocolClient | Ride6SettingsProtocolClient.java:417 |
| R6 SetParameter å¤±è´¥: id=%s | Ride3ProSettingsActivity.C27251 | Ride3ProSettingsActivity.java:890 |
| Ride protocol playback mode event persistence failed: session=%s | Ride3ProSessionApiService | Ride3ProSessionApiService.java:338 |
| Ride protocol recording event persistence failed: action=%s session=%s | Ride3ProRecordRepositoryImpl | Ride3ProRecordRepositoryImpl.java:717 |
| Ride3Pro daily thumbnail authorization failed: index=%s | DailyDetailActivity | DailyDetailActivity.java:1271 |
| Ride3Pro download authorization failed: session=%s | Ride3ProStorageActivity | Ride3ProStorageActivity.java:1539 |
| Ride3Pro download enqueue failed: session=%s | Ride3ProStorageActivity | Ride3ProStorageActivity.java:1568 |
| Ride3Pro hour thumbnail authorization failed: index=%s | Ride3ProHourDetailActivity | Ride3ProHourDetailActivity.java:1196 |
| Ride3Pro indexed thumbnail authorization failed: index=%s | Ride3ProIndexedStorageFragment | Ride3ProIndexedStorageFragment.java:717 |
| Ride3Pro legacy thumbnail authorization failed: index=%s | Ride3ProStorageFileFragment | Ride3ProStorageFileFragment.java:562 |
| Ride3Pro playback selection: file_index=%s accepted=%s switch_active=%s playback_active=%s current_file_index=%s | Ride3ProDailyDetailActivity | Ride3ProDailyDetailActivity.java:1804 |
| Ride3Pro playback selection: file_index=%s accepted=false reason=not_selected | Ride3ProDailyDetailActivity | Ride3ProDailyDetailActivity.java:1784 |
| Ride3Pro playback switch: stage=cancel_stale current_file_index=%s pending_file_index=%s | Ride3ProDailyDetailActivity | Ride3ProDailyDetailActivity.java:1816 |
| Ride3Pro playback switch: stage=completed file_index=%s | Ride3ProDailyDetailActivity.C24462 | Ride3ProDailyDetailActivity.java:1965 |
| Ride3Pro playback switch: stage=finished file_index=%s next_file_index=%s | Ride3ProDailyDetailActivity.C24462 | Ride3ProDailyDetailActivity.java:1978 |
| Ride3Pro playback switch: stage=finished file_index=%s next_file_index=null reason=lifecycle | Ride3ProDailyDetailActivity.C24462 | Ride3ProDailyDetailActivity.java:1984 |
| Ride3Pro playback switch: stage=start file_index=%s | Ride3ProDailyDetailActivity.C24462 | Ride3ProDailyDetailActivity.java:1900 |
| Ride3Pro playback switch: stage=stop_completed file_index=%s | Ride3ProDailyDetailActivity | Ride3ProDailyDetailActivity.java:2054 |
| Ride3Pro playback switch: stage=stop_failed file_index=%s | Ride3ProDailyDetailActivity | Ride3ProDailyDetailActivity.java:2049 |
| Ride3Pro playback switch: stage=stop_start file_index=%s | Ride3ProDailyDetailActivity | Ride3ProDailyDetailActivity.java:2020 |
| Ride3Pro playback thumbnail authorization failed: index=%s | Ride3ProDailyDetailActivity | Ride3ProDailyDetailActivity.java:2664 |
| Ride3Pro share authorization failed: session=%s | Ride3ProDailyDetailActivity | Ride3ProDailyDetailActivity.java:3821 |
| Ride3Pro storage thumbnail authorization failed: index=%s | StorageSdcardItemFragment | StorageSdcardItemFragment.java:444 |
| Ride3Pro thumbnail prefetch authorization failed: index=%s | Ride3ProStorageActivity | Ride3ProStorageActivity.java:356 |
| Ride3Pro: protocol-family takeover failed for stale session %s | Ride3ProSessionConnector | Ride3ProSessionConnector.java:2129 |
| RIDE5 å½åæ§å¶å®æ: start=%s | TuwinApplication.C18751 | TuwinApplication.java:1514 |
| RIDE5 å½åæ§å¶å¤±è´¥: start=%s errorType=%s | TuwinApplication.C18751 | TuwinApplication.java:1527 |
| RIDE5 åºä»¶åçº§å¥å£ç¼ºå°å¯ä¸ä¼è¯è®¾å¤èº«ä»½: session=%s | MoreSettingsActivity | MoreSettingsActivity.java:1332 |
| RIDE5 callback requested preview restart: session=%s | DeviceDetailActivity.C25951.AnonymousClass1 | DeviceDetailActivity.java:2797 |
| RIDE5 camera number query failed: session=%s | DeviceDetailActivity.C25871 | DeviceDetailActivity.java:930 |
| RIDE5 camera switch failed: session=%s | DeviceDetailActivity.C26111 | DeviceDetailActivity.java:1563 |
| RIDE5 camera switch precheck failed: session=%s | DeviceDetailActivity.C25851 | DeviceDetailActivity.java:1498 |
| RIDE5 delete failed: session=%s | Ride5HourlyPlaybackActivity.C25411 | Ride5HourlyPlaybackActivity.java:2819 |
| RIDE5 download authorization failed: session=%s | DailyDetailActivity | DailyDetailActivity.java:905 |
| RIDE5 download authorization failed: session=%s | Ride5HourDetailActivity | Ride5HourDetailActivity.java:1144 |
| RIDE5 download authorization failed: session=%s | Ride5HourlyPlaybackActivity | Ride5HourlyPlaybackActivity.java:2715 |
| RIDE5 download enqueue failed: session=%s | DailyDetailActivity | DailyDetailActivity.java:933 |
| RIDE5 download enqueue failed: session=%s | Ride5HourDetailActivity | Ride5HourDetailActivity.java:1167 |
| RIDE5 download enqueue failed: session=%s | Ride5HourlyPlaybackActivity | Ride5HourlyPlaybackActivity.java:2733 |
| RIDE5 è®¾ç½®æä½å¤±è´¥: operation=%s session=%s | MoreSettingsActivity | MoreSettingsActivity.java:2739 |
| RIDE5 file list failed: session=%s, directory=%s | StorageSdcardItemFragment.C28221 | StorageSdcardItemFragment.java:765 |
| RIDE5 getFileInfo failed: session=%s, pathLength=%d | Ride5FileInfoRepository | Ride5FileInfoRepository.java:125 |
| RIDE5 media mode query failed: session=%s | DeviceDetailActivity.C25881 | DeviceDetailActivity.java:1415 |
| RIDE5 media session is unavailable: session=%s | Ride5HourlyPlaybackActivity.C25631 | Ride5HourlyPlaybackActivity.java:1689 |
| RIDE5 media start failed: session=%s | Ride5HourlyPlaybackActivity.C25631 | Ride5HourlyPlaybackActivity.java:1715 |
| RIDE5 photo command failed: session=%s | DeviceDetailActivity.C26121 | DeviceDetailActivity.java:1190 |
| RIDE5 recording event persistence failed: action=%s session=%s | RecordingEventRide5SessionPort | RecordingEventRide5SessionPort.java:447 |
| RIDE5 resume recording failed: session=%s | DeviceDetailActivity.C25962 | DeviceDetailActivity.java:2256 |
| RIDE5 SD format failed: session=%s | StorageManagerActivity.showFormatConfirmDialog.1.1 | StorageManagerActivity$showFormatConfirmDialog$1$1.java:69 |
| RIDE5 SD status failed: session=%s | StorageManagerActivity.C28091 | StorageManagerActivity.java:480 |
| RIDE5 SD status query failed: session=%s | DeviceDetailActivity.C26001 | DeviceDetailActivity.java:3073 |
| RIDE5 share authorization failed: session=%s | DailyDetailActivity | DailyDetailActivity.java:1245 |
| RIDE5 share authorization failed: session=%s | Ride5HourlyPlaybackActivity | Ride5HourlyPlaybackActivity.java:2862 |
| RIDE5 stop recording before list failed: session=%s | StorageSdcardItemFragment.C28261 | StorageSdcardItemFragment.java:637 |
| RIDE5 stop recording before storage failed: session=%s | DeviceDetailActivity.C25971 | DeviceDetailActivity.java:1029 |
| RIDE5 storage status failed: session=%s | StorageTabActivity.C28131 | StorageTabActivity.java:327 |
| Ride5: callback connection ended with io noise: %s | Ride5CallbackChannel | Ride5CallbackChannel.java:674 |
| Ride5: refresh re-establishment failed: %s | Ride5ConnectionStrategy | Ride5ConnectionStrategy.java:1256 |
| Ride5: Wi-Fi password query failed (%s) | Ride5ConnectionStrategy | Ride5ConnectionStrategy.java:1435 |
