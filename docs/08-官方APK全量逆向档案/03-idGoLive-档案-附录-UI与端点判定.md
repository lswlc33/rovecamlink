# 附录 D · idGoLive UI 面、云端端点判定、native 字符串真伪

> 返回 [主档案](03-idGoLive-档案.md)。
> 证据：`_work/re/idgolive/{layouts.md,res-strings-default.md,res-strings-zh.md,res-locales.md,natives-strings.tsv,signals-*.tsv}`、`_work/idgo_live_src/sources/**`。

---

## 1. 语言与本地化面

`_work/re/idgolive/res-locales.md`：仅 **default（英文）+ values-zh（简体中文）** 两套字符串；布局 XML 里出现 `values-sw`（`sw` = 「Swahili 斯瓦希里语」）的 **只有一个尺寸别名 `values-sw600dp` 之类的宽度限定符**（不是语言）。⇒ App 实际只有英/中两种文案，且中文不是靠 `values-zh` 自动切换，而是靠 **`ChangeLanguageActivity` + App 内语言开关**（`R.string.text_change_language`）。
`layouts.md:78`（`activity_wifi_ap.xml`）里 SSID/Password 提示语直接用中文字面量「开启wifi热点 / 关闭wifi热点」写死在布局里 —— 说明该页未走 string 资源，是**开发者调试页遗留**。

---

## 2. 页面清单（316 个 layout，App 自有 ~35 个，其余为 AppCompat/Material/album/exo 三方）

### 2.1 主流程页（名称 = `res/layout/<name>.xml`）

| layout | 可见控件与文案（原样） | 对应 Activity / Presenter | 承担的操作 |
|---|---|---|---|
| `activity_start_page` | 只有一个 `ImageFilterView`（无文案） | `ui.activity.StartPageActivity`（launcher，`manifest.md:124`） | 冷启动 → 隐私协议判定（`:124-128` 三个 URL）→ `LaunchActivity` |
| `activity_launch` | `AppBarLayout` + `Toolbar`（`@+id/appbar`,`@+id/toolbar`），无静态文案 | `ui.activity.LaunchActivity`（`exported=true`，且注册 `USB_DEVICE_ATTACHED`，`manifest.md:138`） | 设备列表主页（4 个机位槽）、加机、BT 配对入口 |
| `activity_preview` | `@string/title_preview` + toolbar + `@+id/tv_title` | `ui.activity.PreviewActivity`（1225 行）+ `Presenter.PreviewPresenter`（2507 行，最大类） | 预览/拍照/录像/设置抽屉 |
| `preview_control_view` `preview_player_view` `video_control_view` `content_panorama_preview` | 被上面的 include | 同上 | 快门、模式切换、变焦、录制时长、电量、SD 图标 |
| `activity_usb_preview` | 仅 toolbar | `ui.activity.USBPreviewActivity`(608) + `Presenter.USBPreviewPresenter`(1450) | USB(UVC) 预览 |
| `activity_remote_files` / `activity_remote_file_ly` | `@string/remote_file`、`@string/all`、`@string/select`、`@string/title_video`、`@string/title_photo`、`@string/title_emergency`；id：`tv_select_all` `tv_selector` `btn_video` `btn_photo` `btn_emergency` `vPager` | `ui.activity.LYRemoteFileActivity` + `ui.Fragment.RemoteDeviceFilesFragment`/`LYRemoteFileFragment` + `Presenter.RemoteDeviceFilesFragmentPresenter` | **Novatek/Qz 白牌机的回放墙**（视频/照片/紧急三 tab + 全选） |
| `activity_device_settings_ly` | `@string/title_setting`、`@string/device_name_pwd`、占位 `id221_Device_model_one`、`********`、`@string/format_device`、`@string/reset_device`；id：`tv_device_name` `tv_device_pwd` `rv_settings` `btn_format` `btn_reset` | `ui.activity.LdeviceSettingActivity`(1034 行) / `YdeviceSettingActivity`(780 行) | 白牌机设置页：**设备名/密码显示 + SD 格式化 + 恢复出厂 + 参数 RecyclerView** |
| `activity_live_video_ly` | `@string/title_preview`、字面量 `4K`、`30fps`、`@string/hd_quality_hint`、字面量 `00:00:00`、`@string/pause_record`、`@string/setting_title_camera_switch`、`@string/remote_file`、`@string/take_pictures`；控件 `com.icatch.golive.video.EmptyControlVideo` | `ui.activity.LYLiveVideoActivity`(780 行) | **白牌机直播页**：RTSP 播放 + 录制计时 + 前后镜头切换 + 拍照 |
| `activity_download_file_ly` / `activity_download_firmware` | `item_firmware_info` | `LYDownloadFileActivity` / `DownloadFirmwareActivity` | 下载管理 / 固件列表 |
| `activity_multi_pb` `activity_multi_pb2` `activity_photo_pb` `activity_video_pb` `activity_local_*_pb` `activity_local_photo_wall` `activity_common_video_player` `activity_pb_local_video` `activity_video_player_ly` `activity_local_files` | — | `MultiPbFragmentPresenter` / `PhotoPbPresenter`(728 行) / `VideoPbPresenter` / `LocalPhotoPbPresenter` / `LocalVideoPbPresenter` / `LocalDeviceFilesFragmentPresenter` / `CommonVideoPlayerActivity` | PTP 机的回放墙、单张/单条详情、本地相册、本地播放器 |
| `fragment_add_new_cam` | `@string/title_activity_add_new_cam`、`text_btpair_done`、`text_btpair_auto_connect_wifi`、`text_auto_connect_tips`、`text_btpair_auto_connect_wifi_btn`、`text_btpair_already_connect_cam`、`text_btpair_connect_wifi`、`text_connect_camera_by_usb`、`text_otg_tips`、`text_add_camaera_usb`（**原文拼写 `camaera`**）、`text_btpair_support_bt`、`text_btpair`；id：`save` `wifi_auto_connect` `wifi_connect_camera` `usb_connect_camera` `bt_pair` | `ui.Fragment.AddNewCamFragment`（`pwd = AppInfo.default_pwd`，`:42`） | **加机页：WiFi 自动连 / WiFi 手动连 / USB(OTG) 连 / 蓝牙配对 四入口** |
| `fragment_btpair_begin` | `text_ready_pair`、`text_btpair_search_camera`、`text_btpair_search_ble`；按钮 `button_bluetooth_search` `button_ble_search` | `Presenter.BTPairBeginPresenter`(444 行) | **经典 BT + BLE 双搜索** |
| `fragment_btpair_setup` | `Ssid` `Password` 输入框 + `text_btpair_skip`、`text_btpair_setup_camwifi`、`text_btpair_setup`；id `bt_wifisetup_camera_ssid` `bt_wifisetup_camera_password` `bt_wifisetup` | `BTPairBeginPresenter` | **通过蓝牙把手机要连的 WiFi SSID/密码写给相机** |
| `fragment_btpair_completed` | `text_btpair_done`、`text_btpair_connect_cam`、`text_btpair_connect_operationsteps` | 同上 | 配对完成提示 |
| `fragment_remote_device_files` | `@string/no_content` + `rv_remote_files` + **`ProgressWheel @+id/pw_load_more`** | `RemoteDeviceFilesFragmentPresenter` | 无限滚动分页取文件 |
| `fragment_local_pb_list` `fragment_multi_pb2` | 控件 `com.tinyai.libmediacomponent.components.filelist.FileListView` | `LocalMultiPbFragmentPresenter` 等 | TinyAI 文件列表控件（该库自带的 UI，`@+id/file_list_view`） |
| `activity_pv_size_setting` | — | `PvParamSettingActivity` | 预览参数（分辨率/帧率/码率）选择 |
| `activity_wifi_ap` | `SSID`/`test01`/`Password`/`1234567890`/`no`/`wpa`/`wpa2`/`开启wifi热点`/`关闭wifi热点` | `WifiApActivity` | **手机开热点让相机连（反向配网）**，加密三态：no/wpa/wpa2 |
| `activity_about_app` `activity_change_language` `activity_feedback` `activity_web` `activity_license` `activity_launch_help` `activity_connect_course` | — | `AboutAppActivity` `ChangeLanguageActivity` `FeedbackActivity` `WebActivity` `LicenseAgreementActivity` `LaunchHelpActivity` `ConnectCourseActivity` | 关于/语言/反馈(→`addIdCamFeedback`)/协议/教程 |
| `activity_login_facebook` `activity_login_google` `exo_test` `activity_video_player` | — | `LoginFacebookActivity` `LoginGoogleActivity` `ExoTestActivity?` | 第三方直播账号登录 |
| `album_*`（22 个）| — | `com.yanzhenjie.album` | 系统相册选图（分享用） |

### 2.2 用户可见文案（中文，原样抄自 `res-strings-zh.md`）
错误/进度类：
`dialog_connecting = 连接中...`｜`dialog_connecting_to_cam = 连接相机...`｜`dialog_connect_failed = 连接失败，请重试.`（**句末是半角点**）｜`dialog_reconnect = 重新连接`｜`dialog_reconnect_failed = 重新连接失败!`｜`dialog_btn_reconnect = 重新连接`｜
`alert_is_capturing_or_recording = 正在拍照或录影，操作失败！`｜`alert_not_same_password = 两次输入的新密码不同！`｜`current_setting_need_reconnect = 当前设置需要重连设备！`｜
`dialog_card_removed_and_back_photo_pb = SD已移除，将退出图片预览`｜`dialog_recording_card_full = 警告： SD卡已满，录像停止。`｜
`formatting_sd_card = 正在格式化SD卡`｜`format_success = 格式化成功`｜`format_device = SD卡格式化`｜
`delete = 删除`｜`delete_done = 删除完成`｜`dialog_delete_all = 全部删除`｜`dialog_delete_failed_single = 删除失败`｜
`dialog_downloading = 下载$1$ / $2$ ...`｜`dialog_downloaded_single = 图片已被下载到 $1$`｜`dialog_downloaded = $2$ $3$图片下载`｜`dialog_downloaded_skipped = $2$图片下载， （下一个$1$视频和$4$下载的图片）`｜`dialog_cancel_downloading_succeeded = 取消下载成功`｜`dialog_cancel_downloading_failed = 取消下载失败`｜`download = 下载(最多5个)`（**并发上限 5**）｜`download_complete_result = 完成下载，成功:$1$个, 失败:$2$个`｜`download_progress = 已完成: $1$个 等待下载: $2$个 失败： $3$个`｜`downloading_quit = 退出会取消当前正在下载任务，确定要退出吗？`｜
`dialog_preview = 预览数据加载中...`｜`first_connect_devices_then_live = 请先连接您的设备，再查看视频！`｜`gallery_cannot_download_video = 无法下载视频`｜`bluetooth_audio_recording = 蓝牙音频录制`｜`camera_wifi_password = 相机无线网络密码`｜`connect_course = 连接教程`｜`device_info_connect = 立即连接`｜`disconnect = 断开`｜`download_firmware = 下载固件`｜`download_manager = 下载管理`｜`downloading_file = 正在下载文件`。

### 2.3 入口 → 操作映射（复现时的导航图）

| 入口 | 目标 | 参数来源 |
|---|---|---|
| `StartPageActivity` → `LaunchActivity` | 机位槽 1..4 列表 | `CameraSlotSQLite`（`db/`）+ `CameraManager` |
| 长按/点击机位槽 → `AddNewCamFragment` | 四选一：`wifi_auto_connect` / `wifi_connect_camera` / `usb_connect_camera` / `bt_pair` | `AppInfo.inputIp`（默认 `192.168.1.1`）、`AppInfo.default_pwd`（`1234567890`），两者都可在 `LaunchPresenter.inputIp()`(`:630`) / 密码输入框(`:843-851`) 改并存 SP |
| `LaunchActivity` → `PreviewActivity` | PTP 机预览 | `MyCamera.connect(true)` |
| `LaunchActivity` → `LYLiveVideoActivity` | 白牌机预览 | `ConnectDeviceManager.getFrontCamLiveURL()` → RTSP |
| `LaunchActivity` → `LdeviceSettingActivity` / `YdeviceSettingActivity` | 白牌机设置（L=LyIC，Y=QzIC） | `AppInfo.isSupportSetting`（`net/QzIC.java:487` 的 `toSettings`） |
| `PreviewActivity` 工具条 → `PvParamSettingActivity` | 预览参数 | `getSupportedStreamingInfos()` |
| `AboutAppActivity` → `DownloadFirmwareActivity` | 固件列表 | `https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json` |

---

## 3. 云端与遥测端点逐个判定

判定方法：**是否在厂商包（`com/icatch/**`、`com/id221/**`、`com/icatchtek/**`、`com/tinyai/**`）里有真实调用点**；有调用点 = 「真在用」；只在常量表里 = 「声明未用」；在三方库里 = 「死重量」。

| 端点 | 出现位置 | 方法/字段 | 判定 |
|---|---|---|---|
| `https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json` | `ui/activity/DownloadFirmwareActivity.java:220`（GET，成功回调日志在 `:93`） | GET | **真在用**。响应字段：顶层数组/对象的 `product`、`name`、`region`、`version`、`download`（`_work/idgo_live_src/sources/com/icatch/golive/ui/activity/DownloadFirmwareActivity.java:173` 构造 `FirmwareInfo`） |
| `https://www.id221.com/api/app/firmware/area_check` | `net/ConnectDeviceManager.java:362` | GET | **真在用**，响应 `{code:int, data:{area_support:String}}`，`code==200` 才存（`:376-381`）→ `SPUtil.saveUserArea()` |
| `https://api.idalbum.com/album.php/api/addIdCamFeedback` | `net/RequestInfo.java:13` | — | **声明未用**：全仓无引用点（反馈页走 `FeedbackActivity`，实际提交地址需在 `FeedbackActivity` 内确认；常量本身没被读取） |
| `https://api.idalbum.com/album.php/api/getIdCamSoftwareVersionInfo` | `net/RequestInfo.java:29` | — | **声明未用**（App 版本检查走 native `FW_UPDATE_CHECK` 事件 + `firmware.json`） |
| `http://api.idstore.idalbum.com/api/getCustomerServiceInfo` | `net/RequestInfo.java:26` | — | **声明未用**，且是 **明文 HTTP**（若被启用即为降级风险） |
| `https://id221.com/` `https://id221.com/idGoLive/privacyPolicy-en.html` `https://idcam.idalbum.com.cn/idGoLive/{UserAgreement,privacyPolicy}-{en,zh_CN}.html` `file:///android_asset/{privacyPolicy,reminder}{-zh_CN,}.html` | `ui/activity/StartPageActivity.java:124-128`、`ui/activity/WebActivity.java:65-67`、`assets-index.md` | WebView | **真在用**。逻辑：`isShowedGlobalContent` 决定 境内(`idcam.idalbum.com.cn`) 还是 境外(`id221.com`)，`zh` 决定后缀 |
| `https://www.baidu.com` / `ping("www.baidu.com")` | `utils/WifiNetworkSpecifierUtil.java:43/285/294` | ICMP ping | **真在用**：作为「连上相机热点后是否真的有外网」的探测（对运动相机热点来说几乎必然失败，是「假成功」判定的来源） |
| `https://push.smarthome.icatchtek.com` | `com/tinyai/libmediacomponent/utils/AppInfo.java:35` | `PUSH_SERVER_ADDRESS` | **死重量**（TinyAI 库自带常量，`com/icatch/**` 无引用） |
| `https://api.bpsc.tinyai.top:3026` / `http://usa.boi.tinyai.top:3006` | `com/tinyai/libmediacomponent/utils/AppInfo.java:5-13` | `ACCOUNT_SERVER_BASE_URL{,_CN,_USA}` | **死重量**（同上；注意 USA 版是明文 http + 非标准端口 3006） |
| `https://www.googleapis.com/auth/plus.login`、`.../user.birthday.read`、`.../youtube` | `Function/live/google/*`、`signals-fullUrls.tsv` | OAuth scope | **真在用**（Google 直播推流授权）；`plus.login`/`birthday.read` 属已废弃 scope，复现时应剔除 |
| `http://localhost:8080` | `Function/live/google/Credentials.java:10` (`GOOGLE_REDIRECT_URI`) | OAuth 回调 | **真但在桌面语义**：手机上无法监听 localhost:8080 ⇒ Google 登录在移动端实际依赖 `AuthActivity` 弹窗，回调 URI 是遗留 |
| `rtmp://a.rtmp.youtube.com/live2`、`rtmp://a.rtmp.youtube.com/live2/3fur-h6bh-as8j-w7wd-d7us` | `signals-fullUrls.tsv`（Java 侧） | RTMP 推流 | **真在用**；后者是**写死的示例 stream key**（厂商测试残留，属信息泄露） |
| YouTube Data API v3：`https://www.googleapis.com/oauth2/v4/token`、`/youtube/v3/liveStreams?part=snippet,cdn`、`/liveStreams?part=id,status&id=%s`、`/liveStreams?part=id,snippet,status,cdn&id=%s`、`/liveBroadcasts?part=id,snippet,status,contentDetails`、`/liveBroadcasts?id=%s`、`/liveBroadcasts?part=id,status&id=%s`、`/liveBroadcasts/bind?...&id=%s&streamId=%s`、`/liveBroadcasts/transition?broadcastStatus=%s&id=%s&...`、`https://www.youtube.com/channel/`、`https://www.youtube.com/watch?v=` | **`lib/arm64-v8a/libpanorama_vr.so` .rodata**（`natives-strings.tsv` category=url） | native 实现 | **真在用，且在 native 层**：整条 YouTube 直播链路（取 token→建 stream→建 broadcast→bind→transition→给出 watch/channel 链接）由 `libpanorama_vr.so` 完成，Java 侧只调 `JStreamPublish`/`ICatchStreamPublish`。**这是本次深挖的最大结构发现** |
| Google OAuth Client ID `168811923581-u0njo0me7v4dd2ihb1n1c5hbkk0d1v9d.apps.googleusercontent.com`、`982555336638-vis3bioouhq71m4logk3qo525dpt3b37.apps.googleusercontent.com` | `signals-hosts.tsv` | 两个 client id | 两个都随包（一个给 Google 直播、一个给旧版登录），属**公开标识符**非密钥 |
| `http://demo.xarx.rocks/` | 三方库 Xarxlib | — | **死重量** |
| `http://www.w3.org/2000/xmlns/`、`.../XML/1998/namespace`、`http://www.w3.org/ns/ttml`、`http://dashif.org/guidelines/last-segment-number`、`http://www.smpte-ra.org/schemas/2067-3/2013#standard-markers` | `libavformat.so` / `libavfilter.so` | 命名空间常量 | **死重量（XML 命名空间，不是网络端点）** |
| `http://libusb.info` | `libusb_transport.so` | 文档链接 | **死重量** |
| `169.254.169.254`（GCE metadata）、scribejava 的 179 个 provider 域名 | `com/github/ferfalkun*/…`、`oauth-service` 库 | — | **死重量**，与相机无关（正是此前踩过的坑，保持原判） |
| Firebase / Crashlytics / GA / Facebook AppEvents | `com/facebook/appevents/**`（有 `FacebookSdk`）、`manifest.md:161-163` 注册 `CustomTabActivity` + `fbconnect://cct.com.id221.golive` | — | **部分在用**：Facebook 分享/登录是真的（`LoginFacebookActivity`、`queries: com.facebook.katana`）；**未发现 Firebase/Crashlytics/GA**，遥测主要落在日志文件与 `addIdCamFeedback` |

---

## 4. `natives-strings.tsv` 4879 条兴趣字符串的真伪判定汇总

分类计数（`natives.md:76-90`）：`cryptoKey` 819 / `protocolSymbol` 1124 / `ip` 41 / `httpPath` 23 / `filesystem` 20 / `socketApi` 10 / `url` 19 / `rtsp` 1 / `mdnsDiscovery` 6 / `jpegExif` 17。

| 判定 | 条目集合 | 依据 |
|---|---|---|
| **真在用** | `libcontrol.so` 的 167 条里全部 `ptp*` / `ptpip*` / `icatch_*` / `socket*` / `multicast` / `AES_*` / `simpleconfig*` / `234.168.168.168` / `stream_dump_*.raw` / `icatch_%s_sdk_%s_%s.log` / `mediumName=%s;codec=%d;…` / `fw_not_support` | 与 `natives-jni.md` 的 `Java_com_icatchtek_control_core_jni_JCamera*` 一一有对应实现；且 `CommandSession`/`ICatchCameraAssistImpl`/`CameraAction`/`FileOperation` 都调到了对应方法 |
| **真在用** | `libpanorama_vr.so` 的 YouTube API 全套 + `libphoenix` aac 码表 | 与 `Java_com_icatchtek_pancam_core_jni_JStream*`（105 条）配对 |
| **库里死字符串** | `libavformat/libavfilter/libffmpeg/libijkffmpeg` 的 `http://`、`https://`、w3c/dashif/smpte 命名空间、`http://libusb.info` | FFmpeg/libusb 上游自带，App 从不调用这些 demuxer |
| **库里死字符串** | `libcontrol.so` 的 `ptp_chdk_*`（7 个符号 + 对应串）、`ptp_nikon_getptpipguid` | 上游 libptp/libptp2 带入；**Java 侧 `JCameraControl`/`JCameraProperty` 无任何 chdk/nikon 方法**，故不可能被触发 |
| **库里死字符串** | `libcontrol.so` 的 `cryptoKey` 类 819 条中的绝大多数 | 该分类是按「像 key/password」的正则筛出来的，真正成体系的只有 `AES_set_key`/`AES_cbc_encrypt_sdk`/`AES_convert_key`/`AES_generateSBox`/`AES_display` + 4 条日志，服务于 §附录 B 5.1 的组播配网；其余是 C++ 符号名噪声 |
| **需真机验证** | `libcontrol.so` 的 `filesystem` 20 条（`/mnt/sdcard` 等）、`ip` 41 条（`127.0.0.1` + `234.168.168.168` + 其余散落在 ffmpeg 里的 0.0.0.0/224.x/239.x 组播地址） | 部分是 ffmpeg 的 RTP/RTSP 多播表，非相机逻辑 |

**清单里唯一一条 mdnsDiscovery** 类别（6 条）全部落在 ffmpeg 家族（`_http._tcp`、`_rtsp._tcp` 类），`libcontrol.so` 内**没有** mDNS/SSD/SSDP ⇒ idGoLive **不做 mDNS 发现**，发现只有 UDP 组播 5002 + ping + 手输 IP 三种。

---

## 5. 清单里拼错的权限名（原样）

`_work/re/idgolive/manifest.md:70`：

```
android.permission.CHANGE_WIFI_MULTICAST_STAT
```

正字应为 `android.permission.CHANGE_WIFI_MULTICAST_CAST`。
后果：Android 只识别已知权限，未知 `CHANGE_WIFI_MULTICAST_STAT` 在安装时被静默忽略（`PackageManager` 不授予、也不报错），
但 **`MulticastLock` 不需要权限**（`_work/idgo_live_src/sources/com/icatchtek/control/core/CoreMulticast.java:21-23` 的 `createMulticastLock("multicast.test").acquire()` 依然能拿到锁），
所以组播接收**看起来是好的** —— 真正需要的 `android.permission.ACCESS_WIFI_STATE`（`:60`，已声明）与 `CHANGE_WIFI_MULTICAST_CAST` 中后者缺失。
影响面：`WifiManager.setMulticastEnabled(true)`（API 29+，App 未用）会被拒；对 idGoLive 当前实现**无功能影响**，复现时**不要**跟着抄这条拼错的权限。

其它原样保留的拼写错误（不是权限，但影响搜索）：
`DEFALUT_TO_PREVIEW`（`_work/idgo_live_src/sources/com/icatch/golive/data/PropertyId/PropertyId.java:23`，应为 DEFAULT）、`notifyCameraConnectChnage`（`_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:1393`）、
`Function/BaseProrertys.java`（类名，应为 BaseProperties）、`fuction` 字段（`_work/idgo_live_src/sources/com/icatch/golive/SdkApi/CameraProperties.java:29`）、
`AppInfo.PROPERTY_CFG_DIRECTORY_PATH = "/idGoLive/Resoure/"`（`Resoure`，`data/AppInfo/AppInfo.java:24`）、
`text_add_camaera_usb`（layout string）、`param=encodec`（`_work/idgo_live_src/sources/com/icatch/golive/ui/activity/YdeviceSettingActivity.java:585`）、
`mineType`（`ICatchVideoFormat.java` 字段名，应为 mimeType）。
