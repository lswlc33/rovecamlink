# XTU GO — 带格式化槽位的字面量全量（URL / 报文 / 参数模板）

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 218 条。这一张表是「参数值到底怎么拼」的直接证据：%s/%d 的位置就是运行时代码填进去的值

---

| 模板 | 所在类型 | 文件:行 |
|---|---|---|
| è¿åº¦: %.2f%% (%d/%d) | MultiDownloader | MultiDownloader.java:478 |
| (%d/%d) | VideoControlActivity | VideoControlActivity.java:506 |
| -%s | AmbaDeviceSettingPresenter | AmbaDeviceSettingPresenter.java:237 |
| -%s | AmbaFastSettingModel | AmbaFastSettingModel.java:295 |
| -%s | AmbaSettingModel | AmbaSettingModel.java:191 |
| "%s" | Utility | Utility.java:83 |
| [speed=%.2f, pitch=%.2f] | EventLogger | EventLogger.java:320 |
| /img%3d.png -filter_complex [0][1]overlay=60:main_h-overlay_h-30 -y -q:v 1 -max_muxing_queue_size 1080 -vcodec libx264 -acodec copy -crf 35 -preset ultrafast -r 15 -qp 20 -threads 10 | CutActivity | CutActivity.java:538 |
| /img%3d.png -filter_complex [0][1]overlay=60:main_h-overlay_h-30 -y -q:v 1 -max_muxing_queue_size 1080 -vcodec libx264 -acodec copy -crf 35 -preset ultrafast -r 15 -qp 20 -threads 10 | VideoEditActivity | VideoEditActivity.java:542 |
| /tmp/SD0/DCIM/%s/%s | AmbaPlaybackUtil | AmbaPlaybackUtil.java:58 |
| %.02f | TrackActivity | TrackActivity.java:416 |
| %.02f | TrackActivity.GoogleMapMarkerThread | TrackActivity.java:595 |
| %.03f | TrackActivity | TrackActivity.java:418 |
| %.03f | TrackActivity.GoogleMapMarkerThread | TrackActivity.java:597 |
| %.0f | AudioCollectAdapter | AudioCollectAdapter.java:121 |
| %.0f | CutActivity | CutActivity.java:179 |
| %.0f | CutAudioDialog | CutAudioDialog.java:150 |
| %.0f | VideoEditActivity | VideoEditActivity.java:196 |
| %.1f | PhoneSpaceActivity | PhoneSpaceActivity.java:42 |
| %.1f | SSRemoteFileInfo | SSRemoteFileInfo.java:58 |
| %.1f %s | DialogHisiSDMediaDownload | DialogHisiSDMediaDownload.java:200 |
| %.1f B | SSRemoteFileInfo | SSRemoteFileInfo.java:61 |
| %.1f GB | SSRemoteFileInfo | SSRemoteFileInfo.java:66 |
| %.1f KB | SSRemoteFileInfo | SSRemoteFileInfo.java:64 |
| %.1f MB | SSRemoteFileInfo | SSRemoteFileInfo.java:66 |
| %.1fäº¿ | AlgorithmUtils | AlgorithmUtils.java:28 |
| %.1fG/%.1fG | AmbaPreviewActivity | AmbaPreviewActivity.java:247 |
| %.1fG/%.1fG | AmbaActionCameraPreviewActivity | AmbaActionCameraPreviewActivity.java:919 |
| %.1fG/%.1fG | HisiActionCameraPreviewActivity | HisiActionCameraPreviewActivity.java:942 |
| %.1fK | AlgorithmUtils | AlgorithmUtils.java:33 |
| %.1fW | AlgorithmUtils | AlgorithmUtils.java:31 |
| %.2f | ENDownloadView | ENDownloadView.java:261 |
| %.3f | SSPlaybackNewPresenter.AnonymousClass2 | SSPlaybackNewPresenter.java:360 |
| %02d:%02d | BroadcastDouyinFragment4 | BroadcastDouyinFragment4.java:134 |
| %02d:%02d | SSMediaController | SSMediaController.java:477 |
| %02d:%02d | MediaController | MediaController.java:476 |
| %02d:%02d | StringUtils | StringUtils.java:86 |
| %02d:%02d | CommonUtil | CommonUtil.java:31 |
| %02d:%02d | IjkPlayerController | IjkPlayerController.java:128 |
| %02d:%02d:%02d | AmbaPreviewPresenter | AmbaPreviewPresenter.java:660 |
| %02d:%02d:%02d | BroadcastDouyinFragment4 | BroadcastDouyinFragment4.java:125 |
| %02d:%02d:%02d | Utility | Utility.java:31 |
| %02d:%02d:%02d | TrackActivity | TrackActivity.java:688 |
| %02d:%02d:%02d | SJCamTools | SJCamTools.java:148 |
| %02d:%02d:%02d | VideoControlActivity | VideoControlActivity.java:620 |
| %02d:%02d:%02d | SubNewAdapter | SubNewAdapter.java:140 |
| %02d:%02d:%02d | ActionCameraPreviewPresenter | ActionCameraPreviewPresenter.java:431 |
| %02d:%02d:%02d | SSMediaController | SSMediaController.java:475 |
| %02d:%02d:%02d | MediaController | MediaController.java:474 |
| %02d:%02d:%02d | StringUtils | StringUtils.java:86 |
| %02d:%02d:%02d | TimeUtils | TimeUtils.java:698 |
| %02d:%02d:%02d | DialogHisiSDMediaDownload | DialogHisiSDMediaDownload.java:185 |
| %02d:%02d:%02d | UtilsKt | UtilsKt.java:21 |
| %02x | BLEConnectUtils | BLEConnectUtils.java:362 |
| %02x | BluetoothLive | BluetoothLive.java:237 |
| %02x | ProxyCacheUtils | ProxyCacheUtils.java:81 |
| %04d | DeviceAddDeviceListFragment | DeviceAddDeviceListFragment.java:458 |
| %d:%02d:%02d | CommonUtil | CommonUtil.java:31 |
| %d:%02d:%02d | IjkPlayerController | IjkPlayerController.java:124 |
| %d.%d.%d.%d | WifiUtils | WifiUtils.java:10 |
| %s | EventLogger | EventLogger.java:412 |
| %s_ | AmbaDlgOrDeletePresenter | AmbaDlgOrDeletePresenter.java:146 |
| %s_ | SSPlaybackNewPresenter | SSPlaybackNewPresenter.java:834 |
| %s_%s | AmbaDeviceSettingPresenter | AmbaDeviceSettingPresenter.java:201 |
| %s- | AmbaDeviceSettingPresenter | AmbaDeviceSettingPresenter.java:239 |
| %s- | AmbaFastSettingModel | AmbaFastSettingModel.java:297 |
| %s- | AmbaSettingModel | AmbaSettingModel.java:193 |
| %s, %s | AmbaPlaybackActivity | AmbaPlaybackActivity.java:443 |
| %s: language=%s, description=%s | EventLogger | EventLogger.java:410 |
| %s: mimeType=%s, description=%s | EventLogger | EventLogger.java:407 |
| %s: mimeType=%s, filename=%s, description=%s | EventLogger | EventLogger.java:404 |
| %s: owner=%s | EventLogger | EventLogger.java:401 |
| %s: url=%s | EventLogger | EventLogger.java:398 |
| %s: value=%s | EventLogger | EventLogger.java:395 |
| %s:%s, %s | DownloadIntentService.AnonymousClass1 | DownloadIntentService.java:134 |
| %s' will be used. | StorageUtils | StorageUtils.java:32 |
| %s/%s | SSPlayerControlView | SSPlayerControlView.java:273 |
| %s/%s | YunqiPlayerControlView | YunqiPlayerControlView.java:300 |
| %s/%s/%s | AmbaPlaybackUtil | AmbaPlaybackUtil.java:95 |
| %s%03d%03d%s%s | BLEConnectUtils | BLEConnectUtils.java:318 |
| %s%03d%03d%s%s | BluetoothLive | BluetoothLive.java:225 |
| %s%03d001%s%s | BLEConnectUtils | BLEConnectUtils.java:316 |
| %s%03d001%s%s | BluetoothLive | BluetoothLive.java:211 |
| 00:%02d | BroadcastDouyinFragment4 | BroadcastDouyinFragment4.java:139 |
| å¾çå®½åº¦ï¼%s  å¾çé«åº¦ï¼%s | ImageEditClipActivity | ImageEditClipActivity.java:149 |
| æä»¶å¤§å°: %d bytes, Rangeæ¯æ: %s%n | MultiDownloader | MultiDownloader.java:166 |
| Burst Values:%s, value:%s | DV | DV.java:193 |
| capacity:%s, charge:%s, ac:%s | AmbaPreviewPresenter | AmbaPreviewPresenter.java:303 |
| çº¿ç¨ %d ä¸è½½å®æ%n | MultiDownloader | MultiDownloader.java:296 |
| çº¿ç¨ %d ä¸è½½å¤±è´¥ï¼éè¯ %d/%d%n | MultiDownloader | MultiDownloader.java:412 |
| çº¿ç¨ %d ä¸è½½æç»å¤±è´¥%n | MultiDownloader | MultiDownloader.java:417 |
| çº¿ç¨ %d ä¸è½½åºé´: %d - %d%n | MultiDownloader | MultiDownloader.java:235 |
| Content-Length: %d | HttpProxyCache | HttpProxyCache.java:57 |
| Content-Range: bytes %d-%d/%d | HttpProxyCache | HttpProxyCache.java:61 |
| Content-Type: %s | HttpProxyCache | HttpProxyCache.java:65 |
| current mode: %s, current status:%s/%s | AmbaPreviewActivity | AmbaPreviewActivity.java:522 |
| curWorkMode:%s | AmbaCmdModel | AmbaCmdModel.java:741 |
| Directory %s can't be created | Files | Files.java:27 |
| EMSG: scheme=%s, id=%d, value=%s | EventLogger | EventLogger.java:415 |
| Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s | Pinger | Pinger.java:54 |
| Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes] | FileCache | FileCache.java:56 |
| Error writing %d bytes to %s from buffer with size %d | FileCache | FileCache.java:70 |
| Error: %d, %d | SSVideoView | SSVideoView.java:366 |
| Error: %d, %d | VideoTextureView | VideoTextureView.java:365 |
| Error: %d, %d | VideoView | VideoView.java:363 |
| first:%s, visible:%s, total:%s | AmbaPlaybackActivity | AmbaPlaybackActivity.java:447 |
| get current work mode:%s, isRecording:%s | AmbaPreviewPresenter | AmbaPreviewPresenter.java:241 |
| GMT%s%02d:%02d | TimeUtils | TimeUtils.java:61 |
| gradientCenterColorWidth value must be higher than %d and less than %d | ShimmerFrameLayout | ShimmerFrameLayout.java:175 |
| http://%s:%d/%s | HttpProxyCacheServer | HttpProxyCacheServer.java:140 |
| http://%s:%d/%s | Pinger | Pinger.java:97 |
| http://%s/%s | SSFileInfoBean | SSFileInfoBean.java:160 |
| http://%s/%s | AmbaCameraRecordFragment.AnonymousClass1 | AmbaCameraRecordFragment.java:222 |
| http://%s/%s | Hisi_CameraRecordFragment.AnonymousClass1 | Hisi_CameraRecordFragment.java:191 |
| http://%s/%s | HisiDownloader | HisiDownloader.java:200 |
| http://%s/thumb%s | SSFileInfoBean | SSFileInfoBean.java:83 |
| http://%s%s | AmbaPlaybackActivity | AmbaPlaybackActivity.java:750 |
| http://%s%s | AmbaRemoteVideoActivity | AmbaRemoteVideoActivity.java:178 |
| http://%s%s | SSFileInfoBean | SSFileInfoBean.java:158 |
| http://%s%s | AmbaCameraRecordFragment.AnonymousClass1 | AmbaCameraRecordFragment.java:220 |
| http://%s%s | Hisi_CameraRecordFragment.AnonymousClass1 | Hisi_CameraRecordFragment.java:189 |
| http://%s%s/ | DV | DV.java:556 |
| http://%s%s/deleteallfiles.cgi? | RemoteFileManager | RemoteFileManager.java:54 |
| http://%s%s/deletefile.cgi?&-name=%s | RemoteFileManager | RemoteFileManager.java:50 |
| http://%s%s/getallinfo.cgi?? | Setting | Setting.java:30 |
| http://%s%s/getaudioencode.cgi? | Setting | Setting.java:219 |
| http://%s%s/getautoshutdown.cgi? | Setting | Setting.java:330 |
| http://%s%s/getbatterycapacity.cgi? | Setting | Setting.java:45 |
| http://%s%s/getbitrate.cgi? | Setting | Setting.java:514 |
| http://%s%s/getbootaction.cgi? | Setting | Setting.java:211 |
| http://%s%s/getburstinfo.cgi? | Setting | Setting.java:153 |
| http://%s%s/getbuzzer.cgi? | Setting | Setting.java:284 |
| http://%s%s/getcapability.cgi?&-workmode=%d&-type=%d | Setting | Setting.java:542 |
| http://%s%s/getdevcapabilities.cgi? | Setting | Setting.java:530 |
| http://%s%s/getdeviceattr.cgi | Setting | Setting.java:245 |
| http://%s%s/getfileinfo.cgi?&-name=%s | RemoteFileManager | RemoteFileManager.java:46 |
| http://%s%s/getfilelist.cgi?&-start=%d&-end=%d | RemoteFileManager | RemoteFileManager.java:33 |
| http://%s%s/getfilelistinfoios.cgi?&-start=%d&-end=%d | RemoteFileManager | RemoteFileManager.java:20 |
| http://%s%s/getflip.cgi? | Setting | Setting.java:145 |
| http://%s%s/getledstate.cgi? | Setting | Setting.java:276 |
| http://%s%s/getlooprecord.cgi? | Setting | Setting.java:137 |
| http://%s%s/getparameter.cgi?&-workmode=%d&-type=%d | Setting | Setting.java:546 |
| http://%s%s/getpoweronuimode.cgi? | Setting | Setting.java:354 |
| http://%s%s/getrecordtimelapse.cgi? | Setting | Setting.java:203 |
| http://%s%s/getscreenautosleep.cgi? | Setting | Setting.java:338 |
| http://%s%s/getscreenbrightness.cgi? | Setting | Setting.java:346 |
| http://%s%s/getsdstate.cgi? | Setting | Setting.java:89 |
| http://%s%s/getspotmeter.cgi? | Setting | Setting.java:256 |
| http://%s%s/gettimelapseinfo.cgi? | Setting | Setting.java:187 |
| http://%s%s/gettimeosd.cgi? | Setting | Setting.java:264 |
| http://%s%s/gettimerinfo.cgi? | Setting | Setting.java:195 |
| http://%s%s/getvideoinfo.cgi? | Setting | Setting.java:34 |
| http://%s%s/getvideonorm.cgi? | Setting | Setting.java:227 |
| http://%s%s/getviewfield.cgi? | Setting | Setting.java:122 |
| http://%s%s/getwifichannel.cgi? | Setting | Setting.java:522 |
| http://%s%s/getworkmode.cgi? | Setting | Setting.java:534 |
| http://%s%s/sdcommand.cgi?-format&-partition=1 | RemoteFileManager | RemoteFileManager.java:58 |
| http://%s%s/setaudioencode.cgi?&-enable=%d | Setting | Setting.java:223 |
| http://%s%s/setautoshutdown.cgi?&-time=%d | Setting | Setting.java:334 |
| http://%s%s/setbitrate.cgi?&-bitrate=%d | Setting | Setting.java:518 |
| http://%s%s/setbootaction.cgi?&-action=%s | Setting | Setting.java:215 |
| http://%s%s/setburstinfo.cgi?&-time=%d&-count=%d | Setting | Setting.java:183 |
| http://%s%s/setbuzzer.cgi?&-enable=%d | Setting | Setting.java:288 |
| http://%s%s/setflip.cgi?&-enable=%d | Setting | Setting.java:149 |
| http://%s%s/setledstate.cgi?&-enable=%d | Setting | Setting.java:280 |
| http://%s%s/setlooprecord.cgi?&-enable=%d | Setting | Setting.java:141 |
| http://%s%s/setparameter.cgi?&-workmode=%d&-type=%d&-value=%s | Setting | Setting.java:550 |
| http://%s%s/setpoweronuimode.cgi?&-uimode=%d | Setting | Setting.java:358 |
| http://%s%s/setrecordtimelapse.cgi?&-time=%d | Setting | Setting.java:207 |
| http://%s%s/setscreenautosleep.cgi?&-time=%d | Setting | Setting.java:342 |
| http://%s%s/setscreenbrightness.cgi?&-brightness=%d | Setting | Setting.java:350 |
| http://%s%s/setspotmeter.cgi?&-enable=%d | Setting | Setting.java:260 |
| http://%s%s/setsystime.cgi?&-time=%04d%02d%02d%02d%02d%02d | Setting | Setting.java:252 |
| http://%s%s/settimelapseinfo.cgi?&-time=%d | Setting | Setting.java:191 |
| http://%s%s/settimeosd.cgi?&-enable=%d | Setting | Setting.java:268 |
| http://%s%s/settimerinfo.cgi?&-time=%d | Setting | Setting.java:199 |
| http://%s%s/setvideoinfo.cgi?&-resolution=%s&-fps=%d | Setting | Setting.java:38 |
| http://%s%s/setvideonorm.cgi?&-videonorm=%s | Setting | Setting.java:238 |
| http://%s%s/setviewfield.cgi?&-fov=%d | Setting | Setting.java:131 |
| http://%s%s/setwifichannel.cgi?&-wifichannel=%d | Setting | Setting.java:526 |
| http://%s%s/setwifista.cgi? | Setting | Setting.java:326 |
| http://%s%s/setworkmode.cgi?&-workmode=%d? | Setting | Setting.java:538 |
| http://%s%s/upgrade.cgi | RemoteFileManager | RemoteFileManager.java:62 |
| http://%s%s/wifisleep.cgi? | Setting | Setting.java:464 |
| http://%s%s%s | Command | Command.java:36 |
| http://%s%s%s | RemoteFileManager | RemoteFileManager.java:14 |
| index:%s, fileName:%s, fileCreateTime:%s, fileSize:%s | AmbaPlaybackPresenter | AmbaPlaybackPresenter.java:239 |
| interface%d:%s | USBMonitor | USBMonitor.java:223 |
| key:%s, value:%s | AlbumNormalFragment | AlbumNormalFragment.java:185 |
| live_type:%s;res:%d;fps:%d;bitrate:%d;rtmp_url:%s; | BLEConnectUtils | BLEConnectUtils.java:285 |
| live_type:%s;res:%d;fps:%d;bitrate:%d;rtmp_url:%s; | BluetoothLive | BluetoothLive.java:193 |
| maskWidth value must be higher than %d and less or equal to %d | ShimmerFrameLayout | ShimmerFrameLayout.java:167 |
| name:%s, isChecked:%s | SSDeviceSettingActivity.AnonymousClass1 | SSDeviceSettingActivity.java:189 |
| name:%s, isChecked:%s | SSModeSettingActivity | SSModeSettingActivity.java:225 |
| onInfo: (%d, %d) | VideoView | VideoView.java:388 |
| onVideoSizeChanged: (%dx%d) | SSVideoView | SSVideoView.java:291 |
| onVideoSizeChanged: (%dx%d) | VideoTextureView | VideoTextureView.java:276 |
| onVideoSizeChanged: (%dx%d) | VideoView | VideoView.java:290 |
| path:%s, progress:%s | DownloadIntentService.AnonymousClass1 | DownloadIntentService.java:137 |
| photo:%s, video:%s | AmbaCmdModel | AmbaCmdModel.java:733 |
| rtsp://%s:554/livestream/12 | AmbaPreviewActivity | AmbaPreviewActivity.java:972 |
| Screen:[%d,%d], Video:[%d,%d], Set Surface:[%d,%d] | VideoControlActivity | VideoControlActivity.java:643 |
| setactivateinfo.cgi?-status=%d&-version=%s | HttpRequest | HttpRequest.java:54 |
| settrial.cgi?-status=%d&-version=%s | HttpRequest | HttpRequest.java:55 |
| shimmerAngle value must be between %d and %d | ShimmerFrameLayout | ShimmerFrameLayout.java:159 |
| ssid:%s;pwd:%s; | BLEConnectUtils | BLEConnectUtils.java:278 |
| ssid:%s;pwd:%s; | BluetoothLive | BluetoothLive.java:189 |
| ssid:%s;pwd:%s;live_type:%s;res:%s;fps:%s;rtmp_url:%s; | TCPClient | TCPClient.java:27 |
| start:%s, end:%s | FileListManager | FileListManager.java:677 |
| start:%s, end:%s, count:%s | FileListManager | FileListManager.java:609 |
| startFocusAndMetering: %f, %f | SimpleCameraScan | SimpleCameraScan.java:181 |
| surfaceChanged(), [%d,%d], format:%d | VideoControlActivity.SurfaceHolderCallback | VideoControlActivity.java:667 |
| time: %.4f, raw: %.4f, roll: %.4f, pitch: %.4f | ICatchGLStablizationInfo | ICatchGLStablizationInfo.java:45 |
| USB[VID:0x%04x PID:0x%04x] | USBHost_Feature | USBHost_Feature.java:175 |
| VIDEO: %dx%dx%f[SAR:%d:%d], Surface: %dx%d, LP: %dx%d, Window: %dx%dx%f | SSVideoView | SSVideoView.java:523 |
| VIDEO: %dx%dx%f[SAR:%d:%d], Surface: %dx%d, LP: %dx%d, Window: %dx%dx%f | VideoTextureView | VideoTextureView.java:758 |
| VIDEO: %dx%dx%f[SAR:%d:%d], Surface: %dx%d, LP: %dx%d, Window: %dx%dx%f | VideoView | VideoView.java:513 |
| Warning, Insufficient performance. codec: %d,Video width:%d,height: %d,Frame interval: %.4f,decode time: %.4f The playback will stutter. | SDKEvent.VideoCodecInformationListener | SDKEvent.java:613 |
