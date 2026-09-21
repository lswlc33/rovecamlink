# idGoLive — AndroidManifest 全量清单

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 来源：jadx 解码：_work/idgo_live_src/resources/AndroidManifest.xml
> APK：`相机 app/idGoLive_1.3.6.apk`

---

## 1. 包与版本

| 字段 | 值 |
|---|---|
| package | com.id221.golive |
| versionCode | 75 |
| versionName | 1.3.6 |
| platformBuildVersion | 35/15 |
| compileSdk | () |
| installLocation | default |
| split |  |
| minSdk | 28 |
| targetSdk | 35 |
| maxSdk |  |
| featureSplit |  |

## 2. `<application>` 属性

| 属性 | 值 |
|---|---|
| theme | @style/FullScreenTheme |
| label | @string/app_name |
| icon | @drawable/app_icon |
| name | com.icatch.golive.Application.PanoramaApp |
| allowBackup | true |
| hardwareAccelerated | true |
| supportsRtl | true |
| extractNativeLibs | true |
| networkSecurityConfig | @xml/network_security_config |
| appComponentFactory | androidx.core.app.CoreComponentFactory |
| requestLegacyExternalStorage | true |

## 3. 申请的权限（uses-permission）

共 35 条。

| 权限 | maxSdkVersion |
|---|---|
| android.permission.INTERNET |  |
| android.permission.ACCESS_NETWORK_STATE |  |
| android.permission.ACCESS_WIFI_STATE |  |
| android.permission.READ_EXTERNAL_STORAGE | 32 |
| android.permission.WRITE_EXTERNAL_STORAGE | 32 |
| android.permission.READ_MEDIA_VISUAL_USER_SELECTED |  |
| android.permission.SYSTEM_ALERT_WINDOW |  |
| android.permission.KILL_BACKGROUND_PROCESSES |  |
| android.permission.WAKE_LOCK |  |
| android.permission.CHANGE_NETWORK_STATE |  |
| android.permission.CHANGE_WIFI_STATE |  |
| android.permission.ACCESS_NETWORK_STATE |  |
| android.permission.ACCESS_WIFI_STATE |  |
| android.permission.READ_PHONE_STATE |  |
| android.permission.RECEIVE_BOOT_COMPLETED |  |
| android.permission.VIBRATE |  |
| android.permission.ACCESS_DOWNLOAD_MANAGER |  |
| android.permission.DOWNLOAD_WITHOUT_NOTIFICATION |  |
| android.permission.DISABLE_KEYGUARD |  |
| android.permission.MODIFY_AUDIO_SETTINGS |  |
| android.permission.BLUETOOTH |  |
| android.permission.BLUETOOTH_ADMIN |  |
| android.permission.CHANGE_WIFI_MULTICAST_STAT |  |
| android.permission.CHANGE_WIFI_STATE |  |
| android.permission.CHANGE_WIMAX_STATE |  |
| android.permission.ACCESS_COARSE_LOCATION |  |
| android.permission.ACCESS_FINE_LOCATION |  |
| android.permission.CAMERA |  |
| android.permission.RECORD_AUDIO |  |
| android.permission.ACCESS_ADSERVICES_ATTRIBUTION |  |
| android.permission.ACCESS_ADSERVICES_AD_ID |  |
| android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE |  |
| android.permission.ACCESS_ADSERVICES_TOPICS |  |
| com.id221.golive.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION |  |
| com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE |  |

## 4. 自定义权限（permission）

| 权限 | protectionLevel | group | label |
|---|---|---|---|
| com.id221.golive.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION | signature |  |  |

## 5. 硬件特性与库

| uses-feature | required | glEsVersion |
|---|---|---|
| android.hardware.usb.host | true(default) |  |


无 uses-library。


### 包可见性声明（queries）

| 条目 |
|---|
| package:com.facebook.katana |


## 6. 组件总览

| 类型 | 数量 |
|---|---|
| activity | 43 |
| service | 1 |
| receiver | 3 |
| provider | 4 |
| activity-alias | 0 |
| queries | 0 |


### activity（43 个，其中厂商/自有 41 个）

| activity 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.icatch.golive.ui.activity.CommonVideoPlayerActivity | theme=@style/FullScreenTheme.NoActionBar; label=@string/title_activity_pb_local_video; launchMode=singleTask; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.StartPageActivity | theme=@style/Theme.AppCompat.NoActionBar; exported=true; launchMode=standard | [intent.action.MAIN] cat:intent.category.LAUNCHER |  |
| com.icatch.golive.ui.activity.ConnectCourseActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.LdeviceSettingActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.YdeviceSettingActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.LYRemoteFileActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.LYDownloadFileActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.LYVideoPlayerActivity | theme=@style/Theme.AppCompat.NoActionBar; screenOrientation=portrait; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.RtspPlayerActivity | theme=@style/Theme.AppCompat.NoActionBar; screenOrientation=portrait; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.AboutAppActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.DownloadFirmwareActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.FeedbackActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.WebActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.ChangeLanguageActivity | theme=@style/Theme.AppCompat.NoActionBar |  |  |
| com.icatch.golive.ui.activity.LocalVideoPlayerActivity | screenOrientation=portrait; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.LaunchActivity | theme=@style/Theme.AppCompat.NoActionBar; exported=true; launchMode=standard; screenOrientation=sensorPortrait | [hardware.usb.action.USB_DEVICE_ATTACHED] | android.hardware.usb.action.USB_DEVICE_ATTACHED=@xml/device_filter |
| com.icatch.golive.ui.activity.LaunchHelpActivity | theme=@style/AppTheme.NoActionBar; label=@string/help; launchMode=singleTask; screenOrientation=sensorPortrait |  |  |
| com.icatch.golive.ui.activity.LicenseAgreementActivity | theme=@style/FullScreenTheme.NoActionBar; label=@string/title_privacy_policy; launchMode=singleTask |  |  |
| com.icatch.golive.ui.activity.PreviewActivity | theme=@style/Theme.AppCompat.NoActionBar; label=@string/title_activity_preview; launchMode=standard; screenOrientation=portrait; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.LYLiveVideoActivity | theme=@style/Theme.AppCompat.NoActionBar; label=@string/title_activity_preview; launchMode=standard; screenOrientation=portrait; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.LocalVideoPbActivity | theme=@style/Theme.AppCompat.NoActionBar; label=@string/title_activity_pb_local_video; launchMode=singleTask; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.RemoteMultiPbActivity | theme=@style/FullScreenTheme.NoActionBar; label=@string/title_activity_multi_pb; launchMode=singleTask; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.RemoteMultiPbActivity2 | theme=@style/Theme.AppCompat.NoActionBar; label=@string/title_activity_multi_pb; launchMode=standard; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.PhotoPbActivity | theme=@style/FullScreenTheme.NoActionBar; label=@string/title_activity_photo_pb; launchMode=singleTask; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.VideoPbActivity | theme=@style/FullScreenTheme.NoActionBar; label=@string/title_activity_panorama_video_pb; launchMode=singleTask; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.LocalPhotoPbActivity | theme=@style/Theme.AppCompat.NoActionBar; label=@string/title_activity_local_photo; launchMode=singleTask; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.icatch.golive.ui.activity.WifiApActivity | launchMode=singleTask |  |  |
| com.icatch.golive.ui.activity.LoginFacebookActivity | launchMode=singleTask |  |  |
| com.icatch.golive.ui.activity.LoginGoogleActivity |  |  |  |
| com.icatch.golive.ui.activity.PvParamSettingActivity | label=@string/title_activity_pv_param_setting; launchMode=singleTask |  |  |
| com.icatch.golive.ui.activity.USBPreviewActivity | theme=@style/FullScreenTheme.NoActionBar; label=@string/title_activity_usbpreview; launchMode=singleTask |  |  |
| com.icatch.golive.ui.activity.LocalMultiPbActivity | theme=@style/Theme.AppCompat.NoActionBar; label=@string/title_activity_local_pb; launchMode=singleTask; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.yanzhenjie.album.app.album.AlbumActivity | theme=@style/Album.Theme.Activity; configChanges=screenSize\|orientation; windowSoftInputMode=stateAlwaysHidden |  |  |
| com.yanzhenjie.album.app.album.GalleryActivity | theme=@style/Album.Theme.Activity; configChanges=screenSize\|orientation; windowSoftInputMode=stateAlwaysHidden |  |  |
| com.yanzhenjie.album.app.album.NullActivity | theme=@style/Album.Theme.Activity; configChanges=screenSize\|orientation; windowSoftInputMode=stateAlwaysHidden |  |  |
| com.yanzhenjie.album.app.gallery.GalleryActivity | theme=@style/Album.Theme.Activity; configChanges=screenSize\|orientation; windowSoftInputMode=stateAlwaysHidden |  |  |
| com.yanzhenjie.album.app.gallery.GalleryAlbumActivity | theme=@style/Album.Theme.Activity; configChanges=screenSize\|orientation; windowSoftInputMode=stateAlwaysHidden |  |  |
| com.yanzhenjie.album.app.camera.CameraActivity | theme=@style/Album.Theme.Activity.Transparent; configChanges=screenSize\|orientation; windowSoftInputMode=stateAlwaysHidden |  |  |
| com.facebook.FacebookActivity | theme=@style/com_facebook_activity_theme; configChanges=screenSize\|screenLayout\|orientation\|keyboardHidden\|keyboard |  |  |
| com.facebook.CustomTabMainActivity |  |  |  |
| com.facebook.CustomTabActivity | exported=true | [intent.action.VIEW] cat:intent.category.DEFAULT+intent.category.BROWSABLE data:scheme=fbconnect host=cct.com.id221.golive |  |


<details><summary>第三方 / 库注册的 2 个 activity</summary>

| activity 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.google.android.gms.auth.api.signin.internal.SignInHubActivity | theme=@android:style/Theme.Translucent.NoTitleBar; exported=false; excludeFromRecents=true |  |  |
| com.google.android.gms.common.api.GoogleApiActivity | theme=@android:style/Theme.Translucent.NoTitleBar; exported=false |  |  |

</details>

### service（1 个，其中厂商/自有 0 个）



<details><summary>第三方 / 库注册的 1 个 service</summary>

| service 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.google.android.gms.auth.api.signin.RevocationBoundService | permission=com.google.android.gms.auth.api.signin.permission.REVOCATION_NOTIFICATION; exported=true; visibleToInstantApps=true |  |  |

</details>

### receiver（3 个，其中厂商/自有 2 个）

| receiver 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.facebook.CurrentAccessTokenExpirationBroadcastReceiver | exported=false | [com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED] |  |
| com.facebook.AuthenticationTokenManager.CurrentAuthenticationTokenChangedBroadcastReceiver | exported=false | [com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED] |  |


<details><summary>第三方 / 库注册的 1 个 receiver</summary>

| receiver 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| androidx.profileinstaller.ProfileInstallReceiver | permission=android.permission.DUMP; enabled=true; exported=true; directBootAware=false | [androidx.profileinstaller.action.INSTALL_PROFILE] [androidx.profileinstaller.action.SKIP_FILE] [androidx.profileinstaller.action.SAVE_PROFILE] [androidx.profileinstaller.action.BENCHMARK_OPERATION] |  |

</details>

### provider（4 个，其中厂商/自有 2 个）

| provider 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.yanzhenjie.album.provider.CameraFileProvider | exported=false; multiprocess=true; authorities=com.id221.golive.app.file.provider; grantUriPermissions=true |  | android.support.FILE_PROVIDER_PATHS=@xml/album_camera_provider |
| com.facebook.internal.FacebookInitProvider | exported=false; authorities=com.id221.golive.FacebookInitProvider |  |  |


<details><summary>第三方 / 库注册的 2 个 provider</summary>

| provider 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| androidx.core.content.FileProvider | exported=false; authorities=com.id221.golive.provider; grantUriPermissions=true |  | android.support.FILE_PROVIDER_PATHS=@xml/file_provider_path |
| androidx.startup.InitializationProvider | exported=false; authorities=com.id221.golive.androidx-startup |  | androidx.emoji2.text.EmojiCompatInitializer=androidx.startup androidx.lifecycle.ProcessLifecycleInitializer=androidx.startup androidx.profileinstaller.ProfileInstallerInitializer=androidx.startup |

</details>

### activity-alias（0 个）

## 7. 全应用 meta-data

| 挂载点 | name | value | 其它 |
|---|---|---|---|
| activity:com.icatch.golive.ui.activity.LaunchActivity | android.hardware.usb.action.USB_DEVICE_ATTACHED | @xml/device_filter |  |
| provider:androidx.core.content.FileProvider | android.support.FILE_PROVIDER_PATHS | @xml/file_provider_path |  |
| provider:com.yanzhenjie.album.provider.CameraFileProvider | android.support.FILE_PROVIDER_PATHS | @xml/album_camera_provider |  |
| provider:androidx.startup.InitializationProvider | androidx.emoji2.text.EmojiCompatInitializer | androidx.startup |  |
| provider:androidx.startup.InitializationProvider | androidx.lifecycle.ProcessLifecycleInitializer | androidx.startup |  |
| provider:androidx.startup.InitializationProvider | androidx.profileinstaller.ProfileInstallerInitializer | androidx.startup |  |
