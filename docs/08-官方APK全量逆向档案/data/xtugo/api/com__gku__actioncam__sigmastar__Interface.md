# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar.Interface

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 14 个文件 / 14 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.Interface.ISBTHeartbeatModel`
L4 · [interface] public ISBTHeartbeatModel · `com/gku/actioncam/sigmastar/Interface/ISBTHeartbeatModel.java`

方法（1）：
- `void updateBTHeartbeat()`  L5
### `com.gku.actioncam.sigmastar.Interface.ISBTHeartbeatModelCallBack`
L4 · [interface] public ISBTHeartbeatModelCallBack · `com/gku/actioncam/sigmastar/Interface/ISBTHeartbeatModelCallBack.java`

方法（1）：
- `void updateBTHeartbeatSuccess()`  L5
### `com.gku.actioncam.sigmastar.Interface.ISSetting`
L9 · [interface] public ISSetting · `com/gku/actioncam/sigmastar/Interface/ISSetting.java`

方法（12）：
- `void formatList(ArrayList<SSettingItemBean> settingList)`  L10
- `void formatSDSuccess(String result)`  L12
- `void getDataError(Exception e, String methodName)`  L14
- `void getPrimaryMenuItemSuccess(ArrayList<SSettingItemBean> sSettingItemBeans)`  L16
- `void getSecondMenuItemSuccess(SSecondItemBean sSecondItemBean, String name)`  L18
- `void getWifiSuccess(SSWiFiInfo ssWiFiInfo, String name)`  L20
- `void loadCameraInfoSuccess()`  L22
- `void requestList()`  L24
- `void resetSuccess(String result)`  L26
- `void setCurParamSuccess(String result, String name, String value)`  L28
- `void setWiFiSuccess(String result)`  L30
- `void updateList(String itemName)`  L32
### `com.gku.actioncam.sigmastar.Interface.ISSettingModel`
L4 · [interface] public ISSettingModel · `com/gku/actioncam/sigmastar/Interface/ISSettingModel.java`

方法（8）：
- `void formatSD()`  L5
- `void getPrimaryMenuItem(String curMode, String itemName)`  L7
- `void getSecondMenuItem(String curMode, String name)`  L9
- `void getWifi(String name)`  L11
- `void loadCameraInfo()`  L13
- `void reset()`  L15
- `void setCurParam(String curMode, String name, String value)`  L17
- `void setWiFi(String outputSSID, String password)`  L19
### `com.gku.actioncam.sigmastar.Interface.ISSettingModelCallBack`
L9 · [interface] public ISSettingModelCallBack · `com/gku/actioncam/sigmastar/Interface/ISSettingModelCallBack.java`

方法（9）：
- `void formatSDSuccess(String result)`  L10
- `void getDataError(Exception e, String methodName)`  L12
- `void getPrimaryMenuItemSuccess(ArrayList<SSettingItemBean> sSettingItemBeans)`  L14
- `void getSecondMenuItemSuccess(SSecondItemBean sSecondItemBean, String name)`  L16
- `void getWifiSuccess(SSWiFiInfo ssWiFiInfo, String name)`  L18
- `void loadCameraInfoSuccess()`  L20
- `void resetSuccess(String result)`  L22
- `void setCurParamSuccess(String result, String name, String value)`  L24
- `void setWiFiSuccess(String result)`  L26
### `com.gku.actioncam.sigmastar.Interface.ISSPlayback`
L8 · [interface] public ISSPlayback · `com/gku/actioncam/sigmastar/Interface/ISSPlayback.java`

方法（15）：
- `void autoRefresh()`  L9
- `void closeSelectMode()`  L11
- `void delOneFileSuccess(SSFileInfoBean ssFileInfoBean)`  L13
- `void finishRefresh()`  L15
- `String getType()`  L17
- `void loadThumbSuccess(String thumbPath, ImageView imageView, String videoPath)`  L19
- `void noDataTip()`  L21
- `void notifyAllDataInMainThread()`  L23
- `void onSDCardRemove()`  L25
- `void openDeleteSelectMode()`  L27
- `void openDownloadSelectMode()`  L29
- `void refreshFileList()`  L31
- `void startBackgroundDownloadTask(ArrayList<SSFileInfoBean> fileList)`  L33
- `void updateDownloadState(String savePath)`  L35
- `void updateThumbList(ArrayList<SSFileInfoBean> thumbList)`  L37
### `com.gku.actioncam.sigmastar.Interface.ISSPlayback2`
L4 · [interface] public ISSPlayback2 · `com/gku/actioncam/sigmastar/Interface/ISSPlayback2.java`

方法（2）：
- `void onBackFinish()`  L5
- `void onShowLoading(Boolean show)`  L7
### `com.gku.actioncam.sigmastar.Interface.ISSPlaybackModel`
L9 · [interface] public ISSPlaybackModel · `com/gku/actioncam/sigmastar/Interface/ISSPlaybackModel.java`

方法（12）：
- `void clearThumb()`  L10
- `void delFile(int position, Map<Integer, SSFileInfoBean> fileMap)`  L12
- `void delFile(SSFileInfoBean fileInfo, ArrayList<SSFileInfoBean> ssFileInfoBeans)`  L14
- `void delFile(Map<Integer, SSFileInfoBean> fileMap)`  L16
- `void loadData(String type)`  L18
- `void loadFileInfo(SSFileInfoBean fileInfo)`  L20
- `void loadThumb(String thumbPath, String savePath, String createTime, int position, ImageView view)`  L22
- `void loadThumbRetry(String thumbPath)`  L24
- `void startLoadThumb()`  L26
- `void stopData()`  L28
- `void stopDelete()`  L30
- `void stopLoadThumb()`  L32
### `com.gku.actioncam.sigmastar.Interface.ISSPlaybackModelCallback`
L10 · [interface] public ISSPlaybackModelCallback · `com/gku/actioncam/sigmastar/Interface/ISSPlaybackModelCallback.java`

方法（11）：
- `void delFileError(int position, Map<Integer, SSFileInfoBean> fileMap)`  L11
- `void delFileError(SSFileInfoBean fileInfo, ArrayList<SSFileInfoBean> fileInfoBeanArrayList)`  L13
- `void delFileSuccess(int position, Map<Integer, SSFileInfoBean> fileMap)`  L15
- `void delFileSuccess(SSFileInfoBean fileInfo, ArrayList<SSFileInfoBean> fileInfoBeanArrayList)`  L17
- `void loadDataCancel()`  L19
- `void loadDataError(Exception e)`  L21
- `void loadDataFinish()`  L23
- `void loadFileInfoSuccess(SSFileInfoBean fileInfo, SSRemoteFileInfo info)`  L25
- `void loadThumbSuccess(String thumbPath, ImageView imageView, String videoPath)`  L27
- `void startLoadData()`  L29
- `void updateData(ArrayList<SSFileInfoBean> data)`  L31
### `com.gku.actioncam.sigmastar.Interface.ISSPreview`
L8 · [interface] public ISSPreview · `com/gku/actioncam/sigmastar/Interface/ISSPreview.java`

方法（22）：
- `void destroyVideoView()`  L9
- `void dismissFastSetting()`  L11
- `void dismissProgress()`  L13
- `void dismissResolution()`  L15
- `void dumpToPlayback()`  L17
- `void dumpToSetting()`  L19
- `void hideBatteryUI()`  L21
- `void hideMainUI()`  L23
- `void hideSdCardUI()`  L25
- `void initIjkVideoView()`  L27
- `void showBatteryState(SSBatteryInfo batteryInfo)`  L29
- `void showExitQuickVideoOperateUI()`  L31
- `void showFastSetting(String workMode, String value)`  L33
- `void showMainUI()`  L35
- `void showProgress()`  L37
- `void showQuickStoriesOperateUI()`  L39
- `void showResolution(String resolution)`  L41
- `void showSdCardState(SSTFCardInfo tfCardInfo)`  L43
- `void startRecordCountDown(int currentTime)`  L45
- `void updateModeMenuIcon(int resId)`  L47
- `void updateOperateCommandUI(SSystemWorkState sSystemWorkState)`  L49
- `void updateWiFiLevel(int level)`  L51
### `com.gku.actioncam.sigmastar.Interface.ISSPreviewModel`
L10 · [interface] public ISSPreviewModel · `com/gku/actioncam/sigmastar/Interface/ISSPreviewModel.java`

方法（22）：
- `void commandOperation(HashMap<String, ArrayList<String>> allWorkMode, String curWorkMode, SSystemWorkState workState)`  L11
- `void exitQuickRec()`  L13
- `void getAllWorkMode()`  L15
- `void getBattery()`  L17
- `void getBluetoothTX()`  L19
- `void getCurModeParam(String curWorkMode, String itemName)`  L21
- `void getCurWorkMode()`  L23
- `void getRotate()`  L25
- `void getSecondMenuItem(String curWorkMode, String itemName, View view)`  L27
- `void getSysWorkstate()`  L29
- `void getTFCard()`  L31
- `void loadCameraInfo(String requestMethod)`  L33
- `void pairAndGetBluetoothTX()`  L35
- `void quickStoriesAddTime()`  L37
- `void requestPreviewParams()`  L39
- `void setCurMode(String mode, HttpRequestUtils.StringCallBack callBack)`  L41
- `void setCurModeParam(String workMode, String itemName, String value)`  L43
- `void setSystemTime()`  L45
- `void startRecord()`  L47
- `void stopPhoto()`  L49
- `void stopRecord()`  L51
- `void takePhoto()`  L53
### `com.gku.actioncam.sigmastar.Interface.ISSPreviewModelCallback`
L12 · [interface] public ISSPreviewModelCallback · `com/gku/actioncam/sigmastar/Interface/ISSPreviewModelCallback.java`

方法（13）：
- `void getAllWorkModeSuccess(HashMap<String, ArrayList<String>> allWorkMode)`  L13
- `void getBatterySuccess(SSBatteryInfo ssBatteryInfo)`  L15
- `void getBluetoothTXSuccess(String tx1Name, String tx2Name)`  L17
- `void getCurModeParamSuccess(String param, String itemName)`  L19
- `void getCurWorkModeSuccess(String curMode, String params)`  L21
- `void getRotateSuccess(int rotate)`  L23
- `void getSecondMenuItemSuccess(SSecondItemBean bean, View view)`  L25
- `void getSysWorkstateSuccess(SSystemWorkState sSystemWorkState)`  L27
- `void getTFCardSuccess(SSTFCardInfo tfCardInfo)`  L29
- `void httpRequestError(Exception e, String method)`  L31
- `void loadCameraInfoSuccess(String requestMethod)`  L33
- `void setCurModeParamSuccess(String result, String value)`  L35
- `void setSystemTimeSuccess()`  L37
### `com.gku.actioncam.sigmastar.Interface.ISSPreviewNew`
L9 · [interface] public ISSPreviewNew · `com/gku/actioncam/sigmastar/Interface/ISSPreviewNew.java`

方法（31）：
- `void destroyVideoView()`  L10
- `void dismissFastSetting()`  L12
- `void dismissProgress()`  L14
- `void dismissRecordCountUI()`  L16
- `void dismissResolution()`  L18
- `void dumpToPlayback()`  L20
- `void dumpToSetting()`  L22
- `void hideBatteryUI()`  L24
- `void hideMainUI(boolean isDelayed)`  L26
- `void hideSdCardUI()`  L28
- `void initIjkVideoView(int time)`  L30
- `void loadBluetoothTXSuccess(String tx1Name, String tx2Name)`  L32
- `void loadCameraInfoSuccess(String requestMethod)`  L34
- `void loadRotateSuccess(int rotate)`  L36
- `void requestDataError(Exception e)`  L38
- `void settDelayedRecordingTime()`  L40
- `void showBatteryState(SSBatteryInfo batteryInfo)`  L42
- `void showExitQuickVideoOperateUI()`  L44
- `void showFastSetting(String workMode, String value)`  L46
- `void showMainUI()`  L48
- `void showProgress()`  L50
- `void showQuickStoriesOperateUI()`  L52
- `void showQuickStoriesRestTime(int time)`  L54
- `void showRecordCountUI()`  L56
- `void showResolution(String resolution)`  L58
- `void showSdCardState(SSTFCardInfo tfCardInfo)`  L60
- `void updateCDTimeString(int time)`  L62
- `void updateModeMenuIcon(int resId)`  L64
- `void updateOperateCommandUI(SSystemWorkState sSystemWorkState)`  L66
- `void updateWiFiLevel(int level)`  L68
- `void updateWiFiRssiUI(WifiManager wifiManager)`  L70
### `com.gku.actioncam.sigmastar.Interface.IStartView`
L4 · [interface] public IStartView · `com/gku/actioncam/sigmastar/Interface/IStartView.java`

方法（3）：
- `void addData()`  L5
- `void initView()`  L7
- `int setContentRes()`  L9