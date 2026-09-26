# XTU GO — AndroidManifest 全量清单

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 来源：jadx 解码：_work/xtu_res/resources/AndroidManifest.xml
> APK：`相机 app/XTU GO_8.4.3_243_2026-08-19-17-05-43.apk`

---

## 1. 包与版本

| 字段 | 值 |
|---|---|
| package | com.gku.xtugo |
| versionCode | 243 |
| versionName | 8.4.3_243_2026-08-19-17-05-43 |
| platformBuildVersion | 34/14 |
| compileSdk | () |
| installLocation | default |
| split |  |
| minSdk | 23 |
| targetSdk | 35 |
| maxSdk |  |
| featureSplit |  |

## 2. `<application>` 属性

| 属性 | 值 |
|---|---|
| theme | @style/AppTheme |
| label | XTU GO |
| icon | @mipmap/icon |
| name | com.gku.BaseApplication |
| allowBackup | true |
| hardwareAccelerated | true |
| supportsRtl | true |
| extractNativeLibs | false |
| usesCleartextTraffic | true |
| networkSecurityConfig | @xml/network_security_config |
| roundIcon | @mipmap/icon_round |
| appComponentFactory | androidx.core.app.CoreComponentFactory |
| requestLegacyExternalStorage | true |
| allowNativeHeapPointerTagging | false |

## 3. 申请的权限（uses-permission）

共 38 条。

| 权限 | maxSdkVersion |
|---|---|
| android.permission.ACCESS_NETWORK_STATE |  |
| android.permission.INTERNET |  |
| android.permission.READ_PRIVILEGED_PHONE_STATE |  |
| android.permission.READ_EXTERNAL_STORAGE |  |
| android.permission.WRITE_EXTERNAL_STORAGE | 29 |
| android.permission.MANAGE_MEDIA |  |
| android.permission.ACCESS_MEDIA_LOCATION |  |
| android.permission.ACCESS_WIFI_STATE |  |
| android.permission.CHANGE_WIFI_STATE |  |
| android.permission.CHANGE_NETWORK_STATE |  |
| android.permission.READ_PHONE_STATE |  |
| android.permission.ACCESS_COARSE_LOCATION |  |
| android.permission.ACCESS_FINE_LOCATION |  |
| android.permission.GET_ACCOUNTS |  |
| android.permission.FOREGROUND_SERVICE |  |
| android.permission.WAKE_LOCK |  |
| android.permission.BLUETOOTH_CONNECT |  |
| android.permission.BLUETOOTH_SCAN |  |
| android.permission.BLUETOOTH | 30 |
| android.permission.BLUETOOTH_ADMIN | 30 |
| android.permission.BLUETOOTH_ADVERTISE |  |
| android.permission.READ_MEDIA_IMAGES |  |
| android.permission.READ_MEDIA_AUDIO |  |
| android.permission.READ_MEDIA_VIDEO |  |
| android.permission.WRITE_MEDIA_STORAGE |  |
| android.permission.WRITE_SETTINGS |  |
| android.permission.MODIFY_AUDIO_SETTINGS |  |
| android.permission.RECORD_AUDIO |  |
| android.permission.CAMERA |  |
| android.permission.VIBRATE |  |
| android.permission.CALL_PHONE |  |
| android.permission.CHANGE_CONFIGURATION |  |
| android.permission.READ_LOGS |  |
| android.permission.SYSTEM_ALERT_WINDOW |  |
| android.permission.GET_TASKS |  |
| android.permission.FLASHLIGHT |  |
| com.gku.xtugo.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION |  |
| com.asus.msa.SupplementaryDID.ACCESS |  |

## 4. 自定义权限（permission）

| 权限 | protectionLevel | group | label |
|---|---|---|---|
| com.gku.xtugo.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION | signature |  |  |

## 5. 硬件特性与库

| uses-feature | required | glEsVersion |
|---|---|---|
| android.hardware.camera | false |  |
| android.hardware.camera.autofocus | true(default) |  |
| android.hardware.camera.flash | false |  |
|  | true | 0x20000 |


| 位置 | uses-library | required |
|---|---|---|
| application | org.apache.http.legacy | false |
| application | androidx.window.extensions | false |
| application | androidx.window.sidecar | false |


### 包可见性声明（queries）

| 条目 |
|---|
| package:com.tencent.mm |
| package:com.tencent.qq |
| package:com.gku.xtugo |
| package:com.gku.yutupro |
| package:com.ss.android.ugc.aweme |
| package:com.ss.android.ugc.aweme.lite |
| package:com.ss.android.ugc.live |
| package:com.google.android.apps.maps |
| package:com.huawei.hff |
| package:com.huawei.hms |
| package:com.huawei.hwid |
| package:com.huawei.hwid.tv |
| package:com.huawei.works |
| intent action:android.media.action.IMAGE_CAPTURE |
| intent action:android.media.action.ACTION_VIDEO_CAPTURE |
| provider:androidx.car.app.connection |


## 6. 组件总览

| 类型 | 数量 |
|---|---|
| activity | 188 |
| service | 15 |
| receiver | 2 |
| provider | 14 |
| activity-alias | 0 |
| queries | 0 |


### activity（188 个，其中厂商/自有 185 个）

| activity 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.gku.SendSoftActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.loginmodule.ui.activity.DeviceUpgradeActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.actioncam.amba.ui.stream.SelectLiveWifiActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.actioncam.amba.ui.stream.SelectLiveDeviceActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.loginmodule.ui.activity.DeviceManagerActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.amba.AmbaPicPreviewActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.amba.AmbaCameraFileActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.hisi.Hisi_PicPreviewActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.hisi.Hisi_CameraFileActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.ui.ExceptionActivity | theme=@style/Theme.Design.NoActionBar |  |  |
| com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSDownloadStateDialogActivity | theme=@style/SSActivityDialog |  |  |
| com.gku.actioncam.hisilicon.dv.ui.data.connect.HWScaningActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSDeviceSettingActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSModeSettingActivity | theme=@style/Theme.AppCompat.NoActionBar; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSPhotoRemotePlayActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSVideoRemotePlayActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.gkucamplayer.GKUCamPlayer | exported=true; screenOrientation=fullSensor |  |  |
| com.gku.actioncam.sigmastar.OldUi.playback.model.player.OnlineAndOfflinePlayer | theme=@style/CustomActionBar; screenOrientation=portrait; configChanges=smallestScreenSize\|screenSize\|uiMode\|screenLayout\|orientation\|keyboardHidden\|keyboard |  |  |
| com.gku.actioncam.sigmastar.OldUi.playback.ui.activity.SSPlaybackActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.OldUi.preview.ui.activity.HisiActionCameraPreviewActivity | theme=@style/Theme.Design.NoActionBar; launchMode=singleTop; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.gku.actioncam.sigmastar.OldUi.preview.ui.activity.AmbaActionCameraPreviewActivity | theme=@style/Theme.Design.NoActionBar; launchMode=singleTop; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSCameraAboutActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.OldUi.setting.ui.activity.SSBluetoothTXActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.filebrowser.Hi3518PriviewImageActivity |  |  |  |
| com.gku.actioncam.amba.ui.playback.AmbaDlgOrDeleteActivity | theme=@style/Dialog; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.gku.actioncam.amba.ui.playback.remote.photo.AmbaRemotePhotoActivity | theme=@style/Theme.Design.NoActionBar |  |  |
| com.gku.actioncam.amba.ui.setting.device_setting.AmbaDeviceSettingActivity | theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.amba.ui.playback.remote.video.AmbaRemoteVideoActivity | theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.amba.ui.playback.AmbaPlaybackActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.amba.ui.setting.mode_setting.AmbaWorkSettingActivity | theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.amba.ui.preview.AmbaPreviewActivity |  |  |  |
| com.gku.actioncam.hisilicon.dv.setting.PrivacyAgreementActivity | theme=@style/Theme.AppCompat.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.remote_live.QRShowActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.remote_live.ScanWifiActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.ui.WelcomeActivity | theme=@style/welcomeTheme_XTU; exported=true; screenOrientation=portrait | [intent.action.MAIN] cat:intent.category.LAUNCHER |  |
| com.gku.actioncam.hisilicon.dv.ui.PermissionActivity | theme=@style/Theme.AppCompat.Light.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.live.MainActivity | theme=@style/Theme.Design.NoActionBar; configChanges=screenSize\|orientation\|keyboardHidden\|keyboard |  |  |
| com.gku.actioncam.hisilicon.dv.filebrowser.PreviewImageActivity |  |  |  |
| com.gku.actioncam.hisilicon.dv.wifi.WifiDeviceActivity |  |  |  |
| com.gku.actioncam.hisilicon.dv.setting.SettingPreferActivity | theme=@style/Theme.AppCompat.Light.NoActionBar |  |  |
| com.gku.actioncam.hisilicon.dv.imagelookover.SwitchImageActivity | configChanges=screenSize\|orientation\|keyboardHidden\|keyboard |  |  |
| com.gku.actioncam.hisilicon.dv.setting.PreferActivity | theme=@style/preference_set_activity; label=@string/settings; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.gku.actioncam.hisilicon.dv.dlg.FileInfoActivity | theme=@style/Dialog |  |  |
| com.gku.actioncam.hisilicon.dv.ui.ModifyWifiActivity | theme=@style/Dialog; configChanges=screenSize\|orientation\|keyboardHidden\|keyboard |  |  |
| com.gku.actioncam.hisilicon.dv.dlg.PopupWinforPreviewActivity | theme=@style/Dialog |  |  |
| com.gku.actioncam.hisilicon.dv.dlg.ConfirmForActivity | theme=@style/Dialog |  |  |
| com.gku.actioncam.hisilicon.dv.dlg.DlgForProcessActivity | theme=@style/Dialog; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.gku.actioncam.hisilicon.dv.dlg.DlgForDeleteProcessActivity | theme=@style/Dialog; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.gku.actioncam.hisilicon.dv.localimage.weight.DlgForDeleteLocalProcessActivity | theme=@style/Dialog; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.gku.actioncam.hisilicon.dv.dlg.DownloadExceptionActivity | theme=@style/Dialog |  |  |
| com.gku.actioncam.hisilicon.dv.player.VideoControlActivity | theme=@android:style/Theme.NoTitleBar.Fullscreen; configChanges=screenSize\|orientation\|keyboardHidden\|keyboard |  |  |
| com.gku.actioncam.hisilicon.dv.devicemanage.DeviceManageActivity | label=@string/device_manage; exported=false; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.live.TelevisionActivity | screenOrientation=landscape |  |  |
| com.gku.actioncam.hisilicon.dv.setting.BitRateActivity |  |  |  |
| com.gku.actioncam.hisilicon.dv.setting.WifiChannelActivity | screenOrientation=portrait; configChanges=screenSize\|orientation\|keyboardHidden\|keyboard |  |  |
| com.gku.actioncam.hisilicon.dv.setting.AboutClientActivity | theme=@style/CustomActionBar; label=@string/about_app; screenOrientation=portrait; parentActivityName=com.gku.actioncam.hisilicon.dv.setting.SettingPreferActivity |  |  |
| com.gku.actioncam.hisilicon.dv.setting.AboutCameraActivity | label=@string/about_camera; screenOrientation=portrait; parentActivityName=com.gku.actioncam.hisilicon.dv.setting.PreferActivity |  |  |
| com.gku.actioncam.sigmastar.upgrade.app.DownloadActivity | label=@string/action_download; screenOrientation=portrait; parentActivityName=com.gku.actioncam.hisilicon.dv.setting.AboutClientActivity |  |  |
| com.gku.actioncam.hisilicon.dv.localimage.AlbumPreviewActivity | theme=@style/HomeAppTheme; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditClipActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.localimage.ImageEditLib.ImageEditEffectActivity | theme=@style/CustomActionBar |  |  |
| com.gku.actioncam.sigmastar.videoedit.VideoEditActivity | theme=@style/CustomActionBar |  |  |
| com.gku.actioncam.hisilicon.dv.localimage.LocalAlbumActivity | theme=@style/HomeAppTheme; screenOrientation=portrait |  |  |
| com.gku.HomeActivity | theme=@style/CustomActionBar; launchMode=singleTask; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.ui.PreferModelActivityStr | theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.ui.UserCenterWebView | theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.ui.PreferDeviceActivityStr | theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.upgrade.firm.Ui.UpgradeVersionReadyActivity | theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.upgrade.firm.Ui.UpgradeSendFirmActivity | theme=@style/Theme.Design.NoActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.videoedit.CutActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.videoedit.AudioCollectActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.videoedit.CameraVideoActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.videoedit.VideoShareActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.setting.PhoneSpaceActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.bluetooth.ui.PopupDialogActivity | theme=@style/popupDialogStyle |  |  |
| com.gku.actioncam.sigmastar.newUi.deviceAdd.Activity.DeviceAddActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.newUi.deviceAdd.Activity.DeviceAddNewActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.newUi.deviceAdd.Activity.UserGuideActivity | theme=@style/CustomActionBar |  |  |
| com.gku.actioncam.sigmastar.newUi.album.Ui.Activity.ActivityNewPreview | theme=@style/CustomActionBar; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.gku.actioncam.sigmastar.newUi.userCenter.ui.activity.QuestionSelect | theme=@style/CustomActionBar |  |  |
| com.gku.actioncam.sigmastar.newUi.userCenter.ui.activity.QuestionDescription | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.dashcam.icatch.ui.activity.PreviewActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.dashcam.icatch.ui.activity.RemoteMultiPbActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.dashcam.icatch.ui.activity.VideoPb2Activity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.dashcam.icatch.ui.activity.PhotoPbActivity | theme=@style/CustomActionBar; screenOrientation=portrait |  |  |
| com.gku.loginmodule.ui.activity.Login_Register_Activity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.loginmodule.ui.activity.Report_Feedback_Activity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.loginmodule.ui.activity.UserInfoActivity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.loginmodule.ui.activity.AnnouncementLatestActivity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.loginmodule.ui.activity.WebViewActivity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.actioncam.hisilicon.dv.localimage.TrackActivity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.actioncam.remote_live.SelectLiveActivity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.actioncam.remote_live.custom.CustomLiveActivity | theme=@style/CustomActionBar; exported=false |  |  |
| com.gku.actioncam.amba.ui.stream.StreamConfigActivity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.actioncam.amba.ui.stream.StreamingActivity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.actioncam.amba.ui.stream.wifi.WIFITypeinActivity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.gku.actioncam.amba.ui.stream.wifi.WIFIListActivity | theme=@style/CustomActionBar; exported=false; screenOrientation=portrait |  |  |
| com.my.AppSettingActivity | theme=@style/ThemeNoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| cn.rxt.qscase.ui.home.AgreementPermissionActivity | theme=@style/IcatchAppTheme; exported=false; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| cn.rxt.qscase.ui.camera.album.CameraAlbumActivity | theme=@style/IcatchAppTheme; exported=false; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| cn.rxt.qscase.ui.album.AlbumActivity | theme=@style/IcatchAppTheme; exported=false; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| cn.rxt.qscase.ui.camera.preferences.PreferencesActivity | theme=@style/IcatchAppTheme; label=@string/text_settings; exported=false; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| cn.rxt.qscase.ui.camera.ControlActivity | theme=@style/IcatchAppTheme; exported=false; screenOrientation=portrait; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| cn.rxt.qscase.Main2Activity |  |  |  |
| cn.rxt.qscase.MainActivity | theme=@style/IcatchAppTheme; exported=false; screenOrientation=portrait |  |  |
| com.example.icatchplayerlibrary.VideoPbActivity | theme=@style/IcatchAppTheme; exported=false; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| m.mifan.acase.icatch.IcatchVideoPlayerActivity |  |  |  |
| cn.rxt.caeuicore.album.page.preview.VideoPlayerActivity | theme=@style/ThemeNoActionBar; launchMode=singleTop |  |  |
| com.gku.base.permission.PermissionActivity | theme=@style/PermissionNiubility_TranslucentTheme; launchMode=singleInstance |  |  |
| com.gku.base.webview.WebViewActivity | theme=@style/ThemeNoActionBar; exported=false; launchMode=singleTop; screenOrientation=portrait |  |  |
| com.luck.picture.lib.basic.PictureSelectorSupporterActivity | theme=@style/Base.Theme.NoActionBar; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.luck.picture.lib.basic.PictureSelectorTransparentActivity | theme=@style/Picture.Theme.Translucent; configChanges=screenSize\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait2 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait3 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait4 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait5 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait6 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait7 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait8 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait9 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait10 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait11 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait12 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait13 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait14 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait15 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait16 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait17 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait18 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait19 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Portrait20 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Landscape1 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=landscape; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Landscape2 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=landscape; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Landscape3 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=landscape; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Landscape4 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=landscape; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.VideoStubActivity.Activity_Landscape5 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=landscape; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.dy.sdk.stub.Video_Standard_Activity_DouyinWebAuthorizeActivity | theme=@android:style/Theme.NoTitleBar.Fullscreen; screenOrientation=portrait; configChanges=screenSize\|orientation |  |  |
| com.bytedance.android.dy.sdk.stub.VideoAuthorizeActivityProxy | exported=true |  |  |
| com.bytedance.android.openliveplugin.stub.activity.DouyinAuthorizeActivityProxy | exported=true |  |  |
| com.bytedance.android.openliveplugin.stub.activity.DouyinAuthorizeActivityLiveProcessProxy | exported=true; process=:bytelive |  |  |
| com.bytedance.android.openliveplugin.stub.activity.StubActivity.Activity_Portrait | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.openliveplugin.stub.activity.StubActivity.Activity_Portrait2 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.openliveplugin.stub.activity.StubActivity.Activity_Portrait3 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.openliveplugin.stub.activity.StubActivity.Activity_Portrait4 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.openliveplugin.stub.activity.StubActivity.Activity_Portrait5 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.byted.live.lite.Activity_bytelive_standard | exported=false; process=:bytelive; launchMode=standard; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_standard | exported=false; process=:bytelive; launchMode=standard; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTask4 | exported=false; process=:bytelive; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTop3 | exported=false; process=:bytelive; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTop2 | exported=false; process=:bytelive; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTop5 | exported=false; process=:bytelive; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_standard | exported=false; launchMode=standard; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_standard | exported=false; launchMode=standard; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTop4 | exported=false; process=:bytelive; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTop1 | exported=false; process=:bytelive; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTask1 | exported=false; process=:bytelive; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTop6 | exported=false; process=:bytelive; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTask2 | exported=false; process=:bytelive; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleTask3 | exported=false; process=:bytelive; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTask1 | exported=false; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTask2 | exported=false; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTask3 | exported=false; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTask4 | exported=false; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTop1 | exported=false; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTop2 | exported=false; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleInstance1 | exported=false; launchMode=singleInstance; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTop5 | exported=false; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTop6 | exported=false; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTop3 | exported=false; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_main_singleTop4 | exported=false; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.live.lite.Activity_bytelive_singleInstance1 | exported=false; process=:bytelive; launchMode=singleInstance; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.bytedance.android.openlive.broadcast.stub.activity.DouyinAuthorizeActivityProxy | exported=true |  |  |
| com.bytedance.android.openlive.broadcast.stub.activity.StubActivity.Activity_Portrait | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.openlive.broadcast.stub.activity.StubActivity.Activity_Landscape | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=landscape; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.openlive.broadcast.stub.activity.StubActivity.Activity_Portrait2 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.openlive.broadcast.stub.activity.StubActivity.Activity_Portrait3 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.openlive.broadcast.stub.activity.StubActivity.Activity_Portrait4 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.android.openlive.broadcast.stub.activity.StubActivity.Activity_Portrait5 | theme=@android:style/Theme.Light.NoTitleBar; screenOrientation=portrait; configChanges=colorMode\|uiMode\|orientation\|keyboardHidden |  |  |
| com.bytedance.bdinstall.migrate.MigrateDetectorActivity |  |  |  |
| com.byted.broadcast.lite.Activity_main_standard | exported=false; launchMode=standard; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.broadcast.lite.Activity_main_singleTask1 | exported=false; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.broadcast.lite.Activity_main_singleTask2 | exported=false; launchMode=singleTask; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |
| com.byted.broadcast.lite.Activity_main_singleTop1 | exported=false; launchMode=singleTop; configChanges=screenSize\|orientation\|navigation\|keyboardHidden; windowSoftInputMode=adjustResize\|stateHidden |  |  |


<details><summary>第三方 / 库注册的 3 个 activity</summary>

| activity 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| androidx.car.app.CarAppPermissionActivity | theme=@android:style/Theme.Translucent.NoTitleBar; exported=false |  |  |
| com.google.android.gms.common.api.GoogleApiActivity | theme=@android:style/Theme.Translucent.NoTitleBar; exported=false |  |  |
| com.huawei.hms.hmsscankit.ScanKitActivity | launchMode=singleTask; configChanges=smallestScreenSize\|screenSize\|uiMode\|screenLayout\|orientation\|navigation |  |  |

</details>

### service（15 个，其中厂商/自有 12 个）

| service 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.gku.CameraSocketService |  |  |  |
| com.gku.actioncam.sigmastar.OldUi.playback.model.service.DownloadIntentService | exported=false |  |  |
| com.gku.actioncam.sigmastar.SSMessageService | enabled=true; exported=false |  |  |
| com.gku.actioncam.hisilicon.dv.LogService | enabled=true; exported=false |  |  |
| com.gku.actioncam.hisilicon.dv.net.MessageService | enabled=true; exported=false |  |  |
| com.gku.actioncam.hisilicon.dv.net.KeepAliveService | enabled=true; exported=false |  |  |
| com.luck.picture.lib.service.ForegroundService | enabled=true; foregroundServiceType=location |  |  |
| com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService | exported=false; process=:downloader | [com.ss.android.socialbase.downloader.remote] |  |
| com.ss.android.socialbase.downloader.notification.DownloadNotificationService |  |  |  |
| com.ss.android.socialbase.downloader.downloader.DownloadService |  |  |  |
| com.ss.android.socialbase.downloader.impls.DownloadHandleService |  |  |  |
| com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService |  |  |  |


<details><summary>第三方 / 库注册的 3 个 service</summary>

| service 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| androidx.camera.core.impl.MetadataHolderService | enabled=false; exported=false |  | androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER=androidx.camera.camera2.Camera2Config$DefaultProvider |
| androidx.room.MultiInstanceInvalidationService | exported=false; directBootAware=true |  |  |
| com.huawei.agconnect.core.ServiceDiscovery | exported=false |  |  |

</details>

### receiver（2 个，其中厂商/自有 0 个）



<details><summary>第三方 / 库注册的 2 个 receiver</summary>

| receiver 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| androidx.car.app.notification.CarAppNotificationBroadcastReceiver | exported=false |  |  |
| androidx.profileinstaller.ProfileInstallReceiver | permission=android.permission.DUMP; enabled=true; exported=true; directBootAware=false | [androidx.profileinstaller.action.INSTALL_PROFILE] [androidx.profileinstaller.action.SKIP_FILE] [androidx.profileinstaller.action.SAVE_PROFILE] [androidx.profileinstaller.action.BENCHMARK_OPERATION] |  |

</details>

### provider（14 个，其中厂商/自有 11 个）

| provider 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.gku.base.BaseFileProvider | exported=false; authorities=com.gku.xtugo.FileProvider; grantUriPermissions=true |  | android.support.FILE_PROVIDER_PATHS=@xml/paths_base |
| com.luck.picture.lib.basic.PictureFileProvider | exported=false; authorities=com.gku.xtugo.luckProvider; grantUriPermissions=true |  | android.support.FILE_PROVIDER_PATHS=@xml/ps_file_paths |
| com.bytedance.android.openliveplugin.process.server.LiveServerManager | exported=false; process=:bytelive; authorities=com.gku.xtugo.bytedance.android.openliveplugin.process.server.LiveServerManager |  |  |
| com.byted.live.lite.ServerManager_bytelive | exported=false; process=:bytelive; authorities=com.gku.xtugo.zeus.servermanager.bytelive.com.byted.live.lite |  |  |
| com.byted.live.lite.ServerManager_push | exported=false; process=:push; authorities=com.gku.xtugo.zeus.servermanager.push.com.byted.live.lite |  |  |
| com.byted.broadcast.lite.ServerManager_bytelive | exported=false; process=:bytelive; authorities=com.gku.xtugo.zeus.servermanager.bytelive.com.byted.broadcast.lite |  |  |
| com.byted.broadcast.lite.ServerManager_push | exported=false; process=:push; authorities=com.gku.xtugo.zeus.servermanager.push.com.byted.broadcast.lite |  |  |
| com.byted.broadcast.lite.ServerManager_downloader | exported=false; process=:downloader; authorities=com.gku.xtugo.zeus.servermanager.downloader.com.byted.broadcast.lite |  |  |
| com.volcengine.zeus.servermanager.MainServerManager | exported=false; authorities=com.gku.xtugo.zeus.servermanager.main |  |  |
| com.volcengine.zeus.provider.MainProcessProviderProxy | exported=false; authorities=com.gku.xtugo.zeus.provider.proxy.main |  |  |
| com.volcengine.zeus.FileProvider | authorities=com.gku.xtugo.zeus.fileprovider; grantUriPermissions=true |  |  |


<details><summary>第三方 / 库注册的 3 个 provider</summary>

| provider 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| androidx.startup.InitializationProvider | exported=false; authorities=com.gku.xtugo.androidx-startup |  | androidx.emoji2.text.EmojiCompatInitializer=androidx.startup androidx.lifecycle.ProcessLifecycleInitializer=androidx.startup androidx.profileinstaller.ProfileInstallerInitializer=androidx.startup com.king.logx.initialize.LogXInitializer=androidx.startup |
| com.huawei.hms.mlsdk.common.provider.MLInitializerProvider | exported=false; authorities=com.gku.xtugo.MLInitializerProvider |  |  |
| com.huawei.agconnect.core.provider.AGConnectInitializeProvider | exported=false; authorities=com.gku.xtugo.AGCInitializeProvider |  |  |

</details>

### activity-alias（0 个）

## 7. 全应用 meta-data

| 挂载点 | name | value | 其它 |
|---|---|---|---|
| service:androidx.camera.core.impl.MetadataHolderService | androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER | androidx.camera.camera2.Camera2Config$DefaultProvider |  |
| provider:com.gku.base.BaseFileProvider | android.support.FILE_PROVIDER_PATHS | @xml/paths_base |  |
| provider:com.luck.picture.lib.basic.PictureFileProvider | android.support.FILE_PROVIDER_PATHS | @xml/ps_file_paths |  |
| provider:androidx.startup.InitializationProvider | androidx.emoji2.text.EmojiCompatInitializer | androidx.startup |  |
| provider:androidx.startup.InitializationProvider | androidx.lifecycle.ProcessLifecycleInitializer | androidx.startup |  |
| provider:androidx.startup.InitializationProvider | androidx.profileinstaller.ProfileInstallerInitializer | androidx.startup |  |
| provider:androidx.startup.InitializationProvider | com.king.logx.initialize.LogXInitializer | androidx.startup |  |
