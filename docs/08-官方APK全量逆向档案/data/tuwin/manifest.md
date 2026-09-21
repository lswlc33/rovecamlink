# TUWIN — AndroidManifest 全量清单

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 来源：aapt2 dump xmltree（相机 app/TUWIN.apk）
> APK：`相机 app/TUWIN.apk`

---

## 1. 包与版本

| 字段 | 值 |
|---|---|
| package | com.tuwinsmart.tuwin |
| versionCode | 250 |
| versionName | 1.6.4 |
| platformBuildVersion | 36/16 |
| compileSdk | () |
| installLocation | default |
| split |  |
| minSdk | 24 |
| targetSdk | 36 |
| maxSdk |  |
| featureSplit |  |

## 2. `<application>` 属性

| 属性 | 值 |
|---|---|
| theme | @0x7f12000e |
| label | @0x7f110023 |
| icon | @0x7f0e0000 |
| name | com.tuwinsmart.tuwin.TuwinApplication |
| screenOrientation | 1 |
| allowBackup | false |
| supportsRtl | false |
| extractNativeLibs | true |
| usesCleartextTraffic | true |
| networkSecurityConfig | @0x7f140003 |
| appComponentFactory | androidx.core.app.CoreComponentFactory |
| requestLegacyExternalStorage | true |
| localeConfig | @0x7f140002 |

## 3. 申请的权限（uses-permission）

共 20 条。

| 权限 | maxSdkVersion |
|---|---|
| android.permission.INTERNET |  |
| android.permission.READ_PHONE_STATE |  |
| android.permission.READ_EXTERNAL_STORAGE | 28 |
| android.permission.WRITE_EXTERNAL_STORAGE | 28 |
| android.permission.ACCESS_COARSE_LOCATION |  |
| android.permission.ACCESS_FINE_LOCATION |  |
| android.permission.ACCESS_NETWORK_STATE |  |
| android.permission.CHANGE_NETWORK_STATE |  |
| android.permission.ACCESS_WIFI_STATE |  |
| android.permission.CHANGE_WIFI_STATE |  |
| android.permission.ACCESS_LOCATION_EXTRA_COMMANDS |  |
| android.permission.POST_NOTIFICATIONS |  |
| android.permission.FOREGROUND_SERVICE |  |
| android.permission.FOREGROUND_SERVICE_REMOTE_MESSAGING |  |
| android.permission.NEARBY_WIFI_DEVICES |  |
| com.tuwinsmart.tuwin.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION |  |
| android.permission.REQUEST_INSTALL_PACKAGES |  |
| android.permission.MOUNT_UNMOUNT_FILESYSTEMS |  |
| com.google.android.gms.permission.AD_ID |  |
| freemme.permission.msa |  |

## 4. 自定义权限（permission）

| 权限 | protectionLevel | group | label |
|---|---|---|---|
| com.tuwinsmart.tuwin.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION | 0x00000002 |  |  |

## 5. 硬件特性与库

| uses-feature | required | glEsVersion |
|---|---|---|


无 uses-library。


### 包可见性声明（queries）

| 条目 |
|---|
| intent action:android.intent.action.VIEW |
| intent action:android.intent.action.VIEW |


## 6. 组件总览

| 类型 | 数量 |
|---|---|
| activity | 33 |
| service | 3 |
| receiver | 1 |
| provider | 5 |
| activity-alias | 0 |
| queries | 0 |


### activity（33 个，其中厂商/自有 33 个）

| activity 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.tuwinsmart.tuwin.presentation.ui.common.FlashActivity | exported=true; screenOrientation=1 | [intent.action.MAIN] cat:intent.category.LAUNCHER |  |
| com.tuwinsmart.tuwin.presentation.ui.home.HomeActivity | launchMode=2; screenOrientation=1; configChanges=0x00000fb0 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.device.detail.DeviceDetailActivity | screenOrientation=5; configChanges=0x00000fb0 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.device.detail.M3DeviceDetailActivity | screenOrientation=1; configChanges=0x00000fb0 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.mine.MoreSettingsActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.storage.StorageManagerActivity | screenOrientation=1; configChanges=0x000004a0 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.download.DownloadListActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.album.DailyDetailActivity | screenOrientation=1; configChanges=0x00000fb0 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.album.Ride3ProDailyDetailActivity | screenOrientation=1; configChanges=0x00000fb0 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.album.ride5.Ride5HourlyPlaybackActivity | screenOrientation=1; configChanges=0x00000fb0 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.album.ride5.Ride5HourDetailActivity | screenOrientation=1; configChanges=0x00000fb0 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.storage.StorageTabActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.storage.m3.M3StorageActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.storage.ride3pro.Ride3ProStorageActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.storage.ride3pro.Ride3ProIndexedStorageActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.storage.ride3pro.Ride3ProHourDetailActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.device.settings.M3DeviceSettingsActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.device.settings.Ride3ProSettingsActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.device.settings.M3WifiSettingsActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.device.settings.M3StorageSettingsActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.device.settings.M3FactoryResetActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.internet.ExternalWebActivity | exported=false; process=:internet; screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.connect.ConnectHelperDetailActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.mine.PrivacyActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.mine.AboutActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.album.ShowPicsActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.mine.UpgradeActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.mine.FeedbackActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.device.list.DeviceListActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.connect.ConnectHelperActivity | screenOrientation=1 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.album.VideoPlayActivity | screenOrientation=1; configChanges=0x00000fb0 |  |  |
| com.tuwinsmart.tuwin.presentation.ui.storage.m3.M3VideoPlayActivity | screenOrientation=1; configChanges=0x00000fb0 |  |  |
| com.azhon.appupdate.view.UpdateDialogActivity | theme=@0x7f120012 |  |  |


### service（3 个，其中厂商/自有 2 个）

| service 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.azhon.appupdate.service.DownloadService |  |  |  |
| com.efs.sdk.memleaksdk.monitor.UMonitorService | enabled=true; exported=false; process=:u_heap |  |  |


<details><summary>第三方 / 库注册的 1 个 service</summary>

| service 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| androidx.appcompat.app.AppLocalesMetadataHolderService | enabled=false; exported=false |  | autoStoreLocales=true (_line=226) |

</details>

### receiver（1 个，其中厂商/自有 0 个）



<details><summary>第三方 / 库注册的 1 个 receiver</summary>

| receiver 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| androidx.profileinstaller.ProfileInstallReceiver | permission=android.permission.DUMP; enabled=true; exported=true; directBootAware=false | [androidx.profileinstaller.action.INSTALL_PROFILE] [androidx.profileinstaller.action.SKIP_FILE] [androidx.profileinstaller.action.SAVE_PROFILE] [androidx.profileinstaller.action.BENCHMARK_OPERATION] |  |

</details>

### provider（5 个，其中厂商/自有 3 个）

| provider 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| com.tuwinsmart.tuwin.core.internet.InternetRouteRevisionProvider | exported=false; authorities=com.tuwinsmart.tuwin.internetRouteRevision |  |  |
| com.azhon.appupdate.config.AppUpdateFileProvider | exported=false; authorities=com.tuwinsmart.tuwin.fileProvider; grantUriPermissions=true |  | android.support.FILE_PROVIDER_PATHS=@0x7f140000 (_line=257) |
| com.noober.background.BackgroundContentProvider | exported=false; multiprocess=true; authorities=com.tuwinsmart.tuwin.backgroundLibrary |  |  |


<details><summary>第三方 / 库注册的 2 个 provider</summary>

| provider 全限定名 | 属性 | intent-filter | meta-data |
|---|---|---|---|
| androidx.core.content.FileProvider | exported=false; authorities=com.tuwinsmart.tuwin.fileProvider; grantUriPermissions=true |  | android.support.FILE_PROVIDER_PATHS=@0x7f140001 (_line=213) |
| androidx.startup.InitializationProvider | exported=false; authorities=com.tuwinsmart.tuwin.androidx-startup |  | androidx.emoji2.text.EmojiCompatInitializer=androidx.startup (_line=235) androidx.lifecycle.ProcessLifecycleInitializer=androidx.startup (_line=238) androidx.profileinstaller.ProfileInstallerInitializer=androidx.startup (_line=241) |

</details>

### activity-alias（0 个）

## 7. 全应用 meta-data

| 挂载点 | name | value | 其它 |
|---|---|---|---|
| service:androidx.appcompat.app.AppLocalesMetadataHolderService | autoStoreLocales | true | _line=226 |
| provider:androidx.core.content.FileProvider | android.support.FILE_PROVIDER_PATHS | @0x7f140001 | _line=213 |
| provider:androidx.startup.InitializationProvider | androidx.emoji2.text.EmojiCompatInitializer | androidx.startup | _line=235 |
| provider:androidx.startup.InitializationProvider | androidx.lifecycle.ProcessLifecycleInitializer | androidx.startup | _line=238 |
| provider:androidx.startup.InitializationProvider | androidx.profileinstaller.ProfileInstallerInitializer | androidx.startup | _line=241 |
| provider:com.azhon.appupdate.config.AppUpdateFileProvider | android.support.FILE_PROVIDER_PATHS | @0x7f140000 | _line=257 |
