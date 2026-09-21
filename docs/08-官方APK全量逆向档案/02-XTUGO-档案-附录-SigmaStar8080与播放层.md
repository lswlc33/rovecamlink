# 附录 C · SigmaStar 8080 帧与播放层

> 归属：`02-XTUGO-档案.md` 附录 C。样本 APK `com.gku.xtugo` 8.4.3_243。
> 取证基线：`_work/re/xtugo/api/*.md`（逐类明细）、`_work/re/xtugo/catalog-*.md`、`_work/xtu_src/sources/**`（jadx 反编译）、`_work/xtu_bad/sources/**`（jadx 失败补齐）。
> 本文所有行号均为对应 `.java` 文件内的真实行号，写前已用 Read 核对。

## 目录

- C.1 SigmaStar 平台归属判定
- C.2 控制面：HTTP CGI 与 `ClientThread` 空壳
- C.3 8080 二进制帧：字段逐位
- C.4 事件 / 推送通道与 5678 的归属
- C.5 播放层：`SSVideoView` 全参数与预览 URL
- C.6 回放与文件：列表 / 缩略图 / 下载
- C.7 设置项在 SigmaStar 侧的落地（自描述菜单 + `SSResponseParse` 字段映射）
- C.8 未解之谜
- C.9 对主文档的补充与纠正

---

## C.1 SigmaStar 平台归属判定

### C.1.1 `type` 的全部取值（严格照抄）

判定键只有设备自报的 `type`（来自 `GET /cgi-bin/hi3510/getdeviceattr.cgi`，见主文档 §2.3）。芯片常量全在 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java`：

| 常量 | 值（完整字面量） | 行 | 归属平台 |
|---|---|---|---|
| `CHIP` | `"SSC8838"` | `:6` | SigmaStar |
| `CHIP_26` | `"SSC8826"` | `:7` | SigmaStar |
| `CHIP_38c` | `"SSC8838C"` | `:8` | SigmaStar |
| `AMBA` | `"H75N"` | `:5` | Ambarella |
| （无常量） | `"CV75"` | 裸字面量，散见各分派点 | Ambarella |
| `HAISI` | `"Hi"`（只被 `contains` 用） | `:9` | 海思 |
| `SSEnable` | `true`（全库无读取点） | `:12` | — |
| `SS_IP` | `"192.168.0.1"`（**非 final，`public static String`**） | `:13` | SigmaStar/海思共用 |
| `LOCAL_DOWNLOAD_DIR` | `"/mnt/sdcard/DCIM/ActionCam/"` | `:10` | — |
| `LOCAL_THUMB_CACHE_DIR` | `"/mnt/sdcard/Android/data/com.gku.xtugo/cache/"` | `:11` | — |
| `SSFileFormat` | `mp4` / `jpg` / `dng` | `:15-19` | 回放过滤用 |

**走 SigmaStar 的 `type` 值集合恒等于 {`SSC8838`, `SSC8826`, `SSC8838C`}** —— 三值全等（`String.equals`，非 `contains`、非前缀、非大小写不敏感）。除此之外的任何非 AMBA 值（含真机 `Hi3519DV500`）都落海思分支。

### C.1.2 判定发生点（逐处，含真实行号与代码形状）

| # | 判定点 | file:line | SigmaStar 条件 | 命中后 |
|---|---|---|---|---|
| 1 | 语言表选择（最早的一次分派） | `_work/xtu_src/sources/com/gku/HomeActivity.java:1751` | `type.equals(CHIP) \|\| equals(CHIP_26) \|\| equals(CHIP_38c)` | `SSFileUtils.getLanguageJson()` → 8080 拉 `/tmp/FL0/language.json`；否则 `FileUtils.getLanguageXml()`（8080 拉 `/mnt/language.xml`） |
| 2 | 预览 model 工厂 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/PreviewModelManage.java:20` | **反写**：`if (!equals(CHIP) && !equals(CHIP_26) && !equals(CHIP_38c))` → 内层再判 AMBA/`"CV75"`（`:21`）→ `HaisiPreviewModel`（`:22`）/ `AmbaPreviewModel`（`:25`）；三值命中才 `SigmastartPreviewModel`（`:28`） | 整段被 `try/catch(Exception)` 包住，`cameraInfors` 为 null 时静默失败并打日志 `"获取相机参数失败"`（`:29-31`） |
| 3 | 设置 model 工厂 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SettingModelManage.java:17` | 三值或判定 | `SigmastartSettingModel`（`:18`）；AMBA/`"CV75"` → `AmbaSettingModel`（`:19-20`）；else → `HaisiSettingModel`（`:22`） |
| 4 | 回放 model 工厂 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/PlaybackModelManage.java:23` | 三值或判定 | `SigmastartPlaybackModel`（`:24`）/ `AmbaPlaybackModel`（`:26`）/ `HisiPlaybackModel`（`:28`） |
| 5 | 快设 model 工厂 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingModelManage.java:19` | **只判 `CHIP`/`CHIP_26`**（无 `CHIP_38c`） | `:20` 是裸 `return;`；`:22` 写了 `cameraInfors.getType().equals(SSConstant.CHIP_38c);` **结果被丢弃、无任何副作用** → SSC8838C 与非 SS/AMBA 机型一样保持 `isFastSettingModel=null`，`getModel()`（`:27-42`）返回匿名 no-op |
| 6 | 蓝牙心跳开关 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/common/model/BTHeartbeatManage.java:16` | 三值或判定 | `isBTHeartbeatModel = null`（`:17`）—— **SigmaStar 无 BLE 心跳**；AMBA/`"CV75"` 且 `name.toUpperCase().endsWith("S7")` 才装 `AmbaBTHeartbeatModel`（`:18-19`） |
| 7 | 缩略图 URL | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:82` | 三值或判定 | `http://192.168.0.1/thumb<path>`（`:83`） |
| 8 | 下载远程 URL | `…/bean/SSFileInfoBean.java:114` | 三值或判定 | `http://192.168.0.1<path>`，小码流把 `.MP4`→`-s.MP4`、`.mp4`→`-s.mp4`（`:116-121`） |
| 9 | 在线播放 URL | `…/bean/SSFileInfoBean.java:154` | 三值或判定 | `http://192.168.0.1<path>` 并把扩展名换成 `-s.MP4`/`-s.mp4`（`:155`） |
| 10 | 语言表分派（二次兜底） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:86`（`cameraInfors!=null`）与 `:100`（缓存 `lastCamerInfoType` 兜底） | 三值或判定 | `getReplaceValueForJson()`；AMBA → `AmbaLangHolder.getStr()`（`:90,97-98`）；`type.contains("Hi")` → `getReplaceValueForXml()`（`:91-95`）；**都不match → 原样返回 `value`**（`:92`） |
| 11 | 快设「加时长按钮」UI 抑制 | `…/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:1152` 与 `…/AmbaActionCameraPreviewActivity.java:1144` | 三值或判定 | SigmaStar 机型在 `Quick Stories` 模式下 `return`（不弹长按 UI） |
| 12 | 预览 presenter 分支 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:514` | **反写**三值与判定 | 非 SigmaStar 才走那段逻辑 |
| 13 | SSC8838 专属设置修正 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:119` | **只判 `CHIP`（= `"SSC8838"`）** | 唯一一处「只认 SSC8838」的设置逻辑（对 `sSettingItemBeans` 做处理） |
| 14 | 老海思机型能力位 | `_work/xtu_src/sources/com/gku/module_base_xtugo/HisiApiUtils.java:30` | `SSConstant.CHIP.equals(device_type) \|\| SSConstant.CHIP_26.equals(device_type)`（**无 `CHIP_38c`**） | 与 `"Hi3518EV300".equals(device_name)` 一起决定「不是老机型」→ 返回 true |

> 结论：**`SSC8838C` 在 5 处判定里被系统性漏掉**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingModelManage.java:19`、`_work/xtu_src/sources/com/gku/module_base_xtugo/HisiApiUtils.java:30`，以及 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:119` 只认 `SSC8838`）。复现时应按「三值等价」实现，不要照抄这些漏项。

### C.1.3 与海思 / Ambarella 探测顺序的衔接

不重复推导（见主文档 §2.3）。与本平台相关的三点硬事实：

1. **SigmaStar 与海思走同一个入口**：`GET http://<ip>/cgi-bin/hi3510/getdeviceattr.cgi`（`_work/xtu_src/sources/com/gku/HomeActivity.java:1707-1773`）。SigmaStar 的固件把 CGI 目录也叫 `hi3510`，因此**探测阶段无法区分二者**，只有解析出的 `type` 字段能区分。
2. `type` 读出后立刻决定语言表通道（`_work/xtu_src/sources/com/gku/HomeActivity.java:1751`），两条通道**都走 8080 二进制帧**（§C.3），只有路径不同。
3. Ambarella 只在 `getdeviceattr.cgi` 解析失败时才被建链（7878 socket），因此 **SigmaStar 机型永远不会碰 7878/8787**。

## C.2 控制面

### C.2.1 SigmaStar 是不是纯 HTTP CGI？—— 是（命令面），但语言表例外

**结论**：SigmaStar 的**命令面 100% 是 HTTP GET CGI**，端口 80、无鉴权、无自定义 header；`ClientThread` 是空壳。唯一的非 CGI 通道是**拉语言表**（8080 二进制帧，§C.3）。

**证据链**：

1. `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:9` `SS_BASE_PATH = "/cgi-bin/hi3510/"`，`:10` `SS_CGI = ".cgi"`，`:45-47` `UNIVERSAL_PART(command) = SS_BASE_PATH + command + SS_CGI` —— 该类 **33 个 `public static synchronized String` 方法**里除 `previewLiveStream()`（`:49-51`，RTSP）外全部返回相对 CGI 路径，没有一条 socket。（孪生类 `HaisiCommandUtil.java` 是 32 个。）
2. 发命令的类全部只用 HTTP：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:28,43,58,73,88,103,152,169` 八处 `DeviceHttpUtils.get(SSCommandUtil.xxx()).enqueueLifecycle(...)`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/SigmastartPreviewModel.java:179`（`getCurAllInfo` 轮询）、`:273`（`setCurWorkMode`）同款。`DeviceHttpUtils.get(str)` 就是 `"http://" + NetworkDeviceUtils.getInstance().getIpDevice() + str` 的 xUtils GET（`_work/xtu_src/sources/com/gku/base/device/DeviceHttpUtils.java:14-15`）→ **SigmaStar 的 CGI 用的是探测到的网关 IP，而 `SSCommandUtil.previewLiveStream()` 与 `SSFileInfoBean` 用的是硬编码 `SSConstant.SS_IP`**（两处不同源，见 §C.9 纠正项）。

### C.2.2 `ClientThread.java` 是空壳：结论与证据

**结论：是空壳，且两份（SigmaStar 版 / 海思版）都是。** `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/ClientThread.java` 全文 17 行：

| 行 | 内容 | 判定 |
|---|---|---|
| `:8` | `public class ClientThread implements Runnable` | 只实现 `Runnable` |
| `:9` | `private static final String TAG = "lzy"` | 无任何日志调用使用它 |
| `:10-12` | 字段 `BufferedReader br` / `OutputStream os` / `Socket socket` | 三者**只声明、从不赋值、从不读取** |
| `:14-16` | `public void run() { }` | **方法体为空** |

持有者 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:31` 声明了 `private ClientThread clientThread;`，但**同文件内没有任何 `new ClientThread(...)`、`.run()`、`.start()`**；真正建立 8080 连接的是 `connect()` 里的内联匿名 `Runnable`（`:52-102`）。海思孪生类在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ClientThread.java`（同构空壳）。→ **`ClientThread` 不参与任何协议，删掉它不影响行为。**

### C.2.3 CGI 路径 / 参数名与海思方言的差异（成对）

APK 里其实有**三套**方言，两套并列在 `sigmastar` 包内（同名孪生类），第三套是老海思：

- **A · SigmaStar 方言** = `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java`（`Sigmastart*Model` 用）
- **B · 海思新 UI 方言** = `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java`（`Haisi*Model` / `HisiPlaybackModel` 用）
- **C · 海思老方言** = `com/gku/actioncam/hisilicon/dv/net/HttpProxy.java` + `com/gku/actioncam/hisilicon/dv/biz/Command.java`（`IsNewAPP==false`）

| 语义 | A · SigmaStar（file:line，完整路径） | B · 海思（file:line，完整路径） | 差异 |
|---|---|---|---|
| 设备属性 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:53-55` → `/cgi-bin/hi3510/getdeviceattr.cgi` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:71-73` → 同串 | 无 |
| **文件数** | `:57-59` → `/cgi-bin/hi3510/getfiletypecount.cgi`（常量 `SS_GET_FILE_COUNT`，`:22`） | `:75-77` → `/cgi-bin/hi3510/getfilecount.cgi`（`:23`） | **CGI 名不同**；响应键 A 侧读 `imagecount`/`videocount`/`eventcount`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:72,83-90`） |
| **文件列表** | `:65-71` → `…/getfilelist.cgi?-start=<i>&-end=<i>&-type=Photo\|Video`（`type==0?"Photo":"Video"`） | `:79-81` → `…/getfilelist.cgi?-start=<i>&-end=<i>`（**无 `-type`**） | 参数个数不同 |
| 列表+信息（iOS 版） | `:73-75` → `…/getfilelistinfoios.cgi?-start=&-end=`（常量 `SS_GET_FILE_LIST_IOS`，`:25`） | `:83-85` → 同串 | 无 |
| 单文件信息 | `:81-83` → `…/getfileinfo.cgi?-name=<path>` | `:91-93` → 同串 | 无 |
| 删除 | `:77-79` → `…/deletefile.cgi?-name=<path>` | `:87-89` → 同串 | 无 |
| 目录名 | `:61-63` → `…/getdirname.cgi`（常量 `SS_GET_DIRNAME`，`:21`） | **无此方法** | B 侧缺失 |
| 全部工作模式 | `:85-87` → `…/getallworkmode.cgi` | `:95-97` → 同串 | 无 |
| 当前工作模式 | `:89-91` → `…/getcurworkmode.cgi` | `:99-105` → 同串（**同一方法写了两个名字** `getCurworkmode()` 与 `getCurWorkMode()`） | B 有冗余 API |
| 切模式 | `:93-95` → `…/setcurworkmode.cgi?-workmode=<mode>`（**不做空格编码**） | `:107-109` → 同串（同样不编码） | 两边都不编码；编码在 C 方言里 |
| 一级菜单 | `:105-107` → `…/getprimarymenuitem.cgi?-workmode=<mode>` | `:119-121` → 同串 | 无 |
| 二级菜单 | `:109-111` → `…/getsecondmenuitem.cgi?-workmode=&-name=` | `:123-125` → 同串（此处直接写字面量 `"getsecondmenuitem"` 而不用常量） | 无 |
| **读某项当前值** | `:113-115` → `…/getcurparameter.cgi?-workmode=&-name=`（常量 `SS_GET_CUR_PARAM="getcurparameter"`，`:18`） | `:127-134` → **`…/getsecondmenuitem.cgi?-workmode=&-name=`**（`:20` 把 `SS_GET_CUR_PARAM` 重定义成 `getsecondmenuitem`），且**含空格则 `replaceAll(" ", "%20")`**（`:130-132`） | **同语义不同 CGI + 不同转义策略** |
| 写某项 | `:117-119` → `…/setcurparameter.cgi?-workmode=&-name=&-value=` | `:136-138` → 同串（**不编码空格**） | 转义差异 |
| WiFi 读/写 | `:121-127` → `…/getwifi.cgi`、`…/setwifi.cgi?&-wifissid=<s>&-wifikey=<k>`（**注意 `?&` 双符**） | `:140-146` → 同串（同样 `?&`） | 无 |
| 格式化 SD | `:129-131` → `…/sdcommand.cgi?-format&-partition=1`（`-format` 是**无值裸键**） | `:148-150` → 同串 | 无 |
| 恢复出厂 | `:133-135` → `…/reset.cgi` | `:152-154` → 同串 | 无 |
| 对时 | `:137-139` → `…/setsystime.cgi?-time=<t>` | `:156-158` → 同串 | 无 |
| 开始/停止录像 | `:141-147` → `…/record.cgi?-cmd=start` / `?‑cmd=stop`（`Common.BOOT_ACTION_RECORD`） | `:160-166` → 同串 | 无 |
| 拍照 | `:149-155` → `…/photo.cgi?-type=<type>&-cmd=start\|stop` | `:168-174` → 同串 | 无 |
| 退出快录 | `:157-159` → `…/exitquickrec.cgi` | `:176-178` → 同串 | 无 |
| 相机状态 | `:161-167` → `…/getcamerastatus.cgi`、`…/setcamerastatus.cgi?-status=<s>` | `:180-186` → 同串 | 无 |
| 全量状态 | `:169-171` → `…/getcurallinfo.cgi` | `:188-190` → 同串 | 无（C 方言按 `VERSION` 在 `getcurallinfo.cgi`/`getallinfo.cgi` 间切换，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:306`） |
| **当前旋转** | `:173-175` → `…/getcurrotation.cgi`（常量 `SS_GET_ROTATE`，`:27`） | **无此方法** | A 独有 |
| **快设加时长** | `:177-184` → `…/record.cgi?-cmd=` 后接 `DV.cameraInfors.getName()` 以 `"S7PRO"`/`"S7PRO MAX"` 结尾时为 `"Storie"`，否则为 `SSExchangeWorkMode.SS_QUICK_STORIES`（=`"Quick Stories"`） | `:192-194` → 固定 `…/record.cgi?-cmd=Quick Stories`（**含空格、未编码**） | A 有按机型的 `"Storie"` 特例 |
| **老方言命令号→路径** | **无** | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:53-69`：`getexecuteCommand(int cmd)` 先过 `executeCommand()`（NewAPP 且 `cmd>=10 && cmd!=10` 时 `cmd%2==0?1:0`，`:54-57`）再取 `Common.CGI_PATH + Command.cgiFilesParams[cmd]` | B 独有；A 侧无命令号概念 |
| 老方言（C）命令号表 | — | `com/gku/actioncam/hisilicon/dv/biz/Command.java:31` 21 条：`/record.cgi?&-cmd=start`、`/record.cgi?&-cmd=stop`、`/photo.cgi?&-type=photo`、`/photo.cgi?&-type=photoburst`、`/photo.cgi?&-type=phototimelapse&-cmd=start`、`/photo.cgi?&-type=phototimelapse&-cmd=stop`、`/photo.cgi?&-type=phototimer&-cmd=start`、`/photo.cgi?&-type=phototimer&-cmd=stop`、`/photo.cgi?&-type=continuous&-cmd=start`、`/photo.cgi?&-type=continuous&-cmd=stop`、`/exitquickrec.cgi`、`/record2.cgi?&-type=common&-cmd=start`、`/record2.cgi?&-type=common&-cmd=stop`、`/record2.cgi?&-type=loop&-cmd=start`、`/record2.cgi?&-type=loop&-cmd=stop`、`/record2.cgi?&-type=timelapse&-cmd=start`、`/record2.cgi?&-type=timelapse&-cmd=stop`、`/record2.cgi?&-type=recsnap&-cmd=start`、`/record2.cgi?&-type=recsnap&-cmd=stop`、`/record2.cgi?&-type=slow&-cmd=start`、`/record2.cgi?&-type=slow&-cmd=stop` | C 用 `?&-`（问号后紧跟 and），A/B 用 `?-` |

### C.2.4 新固件方言（`NewAPP` / `"Normal Video"`）在代码里的体现

| 体现 | 事实 | file:line |
|---|---|---|
| 方言开关 | `CameraParameters.IsNewAPP = hardversion.equals("NewAPP")`；开关位本身声明在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:29`，赋值在 `_work/xtu_src/sources/com/gku/HomeActivity.java:1746-1750`（主文档 §2.3 第 4 步） | 同上 |
| 带空格模式名（15 条，全抄） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:11-25`：`SS_BURST_PHOTO="Burst Photo"`、`SS_CAR_LOOPING="Car Looping"`、`SS_LAPSE_PHOTO="Lapse Photo"`、`SS_LAPSE_PHOTO_OLD="Timelapse Photo"`、`SS_LAPSE_VIDEO="Timelapse Video"`、`SS_LONG_EXPOSURE="Long Exposure"`、`SS_NORMAL_PHOTO="Normal Photo"`、`SS_NORMAL_VIDEO="Normal Video"`、`SS_QUICK_STORIES="Quick Stories"`、`SS_QUICK_VIDEO="Quick Video"`、`SS_RAW_PHOTO="Raw Photo"`、`SS_SLOW_MOTION="Slow Motion"`、`SS_TIMING_PHOTO="Timing Photo"`、`SS_UNDER_WATER="Under Water"`、`SS_VIDEO_PHOTO="Video and Photo"` | 同上 |
| 海思侧别名表（19 条，含 5 条 SSExchangeWorkMode 里没有的） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:57-74`：`NewNormalPhoto`、`NewTimerPhoto`、`NewPhotoLapse`(=`"Timelapse Photo"`)、`NewBurst`、`NewNightPhoto="Night Photo"`、`NewNightTimeLapsePhoto="Night Timelapse Photo"`、`NewRawPhoto`、`NewNormalVideo`(=`"Normal Video"`)、`NewTimeLapseVideo`、`NewSlowMotion`、`NewCarLooping`、`NewVideoAndPhoto`、`NewQuickStories`、`NewUnderWater`、`NewTimeStretch="Time Stretch"`、`NewQuickVideo`、`NewManualRecsnap="Manual Recsnap"`、`NewLapseBurst="Lapse Burst"`；孪生类 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParmeras.java:63` 同值 | 同上 |
| 空格→`%20` 的唯一发生处 | 方言 B：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:130-132`；方言 C：`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:226-228`（`setcurworkmode`）、`:251-253`（`setcurparameter`）；系统项用 `Uri.encode(x,"utf-8")`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:259-264`）。**方言 A（SigmaStar）完全不做转义**：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:94`、`:118` 直接拼 | 同上 |
| 为什么 C 必须自己转 `%20` | `HttpProxy.doHttpGetForContent()` 在发请求前把 URL 里的空格**全删**（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:60-61` `url.replaceAll(StringUtils.SPACE, "")`），所以 `"Normal Video"` 若不成 `%20` 会变成 `"NormalVideo"` → 固件不识别 | 同上 |
| 无空格写法的后果 | 代码里对 `-2222` 的**唯一**处理仍是 `SSResponseParse.parseGetAllInfo(String)` 的 `if (message.contains("-222")) return null;`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:511-513`）→ 「当作没有状态」，不报错 | 同主文档 §3.1 |
| 品牌改写 | `APP_CADDX` 分支把 `"Normal Video"` 改写成 `"Normal Video_caddx"`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:90-93`）；XTU（`CURRENT_APP_TYPE==0`）不触发 | 同上 |

## C.3 8080 二进制帧

### C.3.1 结论

**静态证据支持主文档 §3.3 的 72B/200B 小端定长头说法，且 SigmaStar 机型确实会收到它。** 两处直接落到 SigmaStar 链路：

| 用途 | 触发条件 | 发起代码 | 帧 |
|---|---|---|---|
| 拉语言表 `/tmp/FL0/language.json` | 仅当 `type ∈ {SSC8838,SSC8826,SSC8838C}`（`_work/xtu_src/sources/com/gku/HomeActivity.java:1751` → `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:65`） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:57`（`socket.connect(new InetSocketAddress("192.168.0.1", 8080), 10000)`）、`:62-66`（`CMD=0`、`DATA="/tmp/FL0/language.json"`、`DATA_LENTH=DATA.length()`）、`:66`（`new RegisterDeviceToServer(CMD,LEN,DATA).getBuf()` → `outputStream.write`） | 上行 **72B**（§C.3.2） |
| 下载 ≥2 GiB 的相机文件 | SigmaStar 与海思共用（`SSDownloadUtil` 判大小） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:85-87` → `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:34-35`（`IP="192.168.0.1"`、`port=8080`）、`:67`（`new Socket(IP, port)`）、`:73-77`（`CMD=0`、`DATA=<去掉 `http://192.168.0.1/` 前缀后的路径>`、`DATA_LENTH=DATA.length()`、`write(RegisterDeviceToServer(...).getBuf())`） | 上行 **72B** + 下行 **72B 头** + 裸文件流（§C.3.3） |
| 固件推送 | 老机型升级页 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/FirmwareClientThread.java:64`（`192.168.0.1:8080`）、`:76-82`（`CMD=2`、`DATA=file.getName()`、`DATA_LENTH=FileLength`、`MD5=getFileMD5(file)` → 200B 版构造器） | 上行 **200B** |
| 海思语言表 `/mnt/language.xml` | `type.contains("Hi")` 且非 SS | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ConnectDevice.java:44,50-53` | 上行 **72B** |
| 通用取文件（新 UI） | `com/gku/hisi/**` 文件页 | `_work/xtu_src/sources/com/gku/module_camera/hisi/HisiDownloader.java:341`（`start(networkDevice, ipDevice, 8080, 5000, path, savePath, cb)`）→ `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:111-119` | 上行 **72B**（`ByteBuffer` 写法） |

### C.3.2 上行头：72 字节（无 MD5 版）

`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/model/RegisterDeviceToServer.java:12-23`：

| 偏移 | 长度 | 字节序 / 类型 | 含义 | 出处 |
|---|---|---|---|---|
| `[0..3]` | 4 | `int32` **小端** | `cmd_type`：`0`=取文件（把路径当参数交给相机），`2`=推固件 | `:17-18` `System.arraycopy(toLH(cmd_type),0,buf,0,4)`；`toLH` 定义 `:44-46`（`n&255, n>>8, n>>16, n>>24`）；取值见 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:63`、`DownLoadFileUtils.java:71`、`FirmwareClientThread.java:76` |
| `[4..7]` | 4 | `int32` **小端** | `length` = **后面那个字符串的字符数**（Java `String.length()`，非 UTF-8 字节数） | `:19-20`；赋值点 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:65` `DATA_LENTH = DATA.length()`、`DownLoadFileUtils.java:73` 同款；固件路径下这里是**文件字节数**（`FirmwareClientThread.java:78` `= FileLength`） |
| `[8..71]` | 64 | UTF-8（实为 `str.getBytes()`，**平台默认字符集**） | 文件路径 / 文件名，**零填充与否取决于字符串长度**：不足 64 字节时尾部是 Java 新数组的 `0x00`；`StringtoLH` 只是 `str.getBytes()`（`:48-50`） | `:21-22` `System.arraycopy(StringtoLH(data),0,buf,8,len)`；`buf = new byte[72]`（`:13`） |
| — | — | — | **无魔术字、无版本、无校验和、无结束符** | 全类只有 4 个字段（`:7-10`） |

> 隐患（复现时要防）：`:22` 的 `System.arraycopy` 不做截断，路径 ≥65 字节直接 `ArrayIndexOutOfBoundsException`；`_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:117` 的现代写法用 `Math.min(bytes.length, 64)` 截断，两者行为不一致。

`ByteBuffer` 等价写法（`_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:111-119`）：

```
ByteBuffer.allocate(72) → order(LITTLE_ENDIAN) → putInt(0)            // cmd=0
                        → putInt(path.getBytes("UTF-8").length)      // 长度 = UTF-8 字节数
                        → put(拷 64B，Math.min(len,64))              // 路径
                        → outputStream.write(buffer.array())
```
注意：这条路径的 `[4..7]` 是 **UTF-8 字节数**，而 `RegisterDeviceToServer` 是 **字符数** —— 同一段 4 字节在两个实现里语义不同（ASCII 路径下二者相等）。

### C.3.3 上行头：200 字节（带 MD5，固件推送）

`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/model/RegisterDeviceToServer.java:25-38`，`buf = new byte[200]`（`:29`）：

| 偏移 | 长度 | 内容 | 出处 |
|---|---|---|---|
| `[0..3]` | 4 | `cmd_type` int32 LE，固件推送恒为 `2` | `:30-31`；值来自 `FirmwareClientThread.java:76` |
| `[4..7]` | 4 | `length` int32 LE = **固件文件字节数** | `:32-33`；值来自 `FirmwareClientThread.java:78` |
| `[8..71]` | 64 | 固件文件名（`file.getName()`） | `:34-35`；`FirmwareClientThread.java:77` |
| `[72..199]` | 128 | MD5 字符串 | `:36-37` `System.arraycopy(StringtoLH(md5),0,buf,72,len)`；MD5 由 `FirmwareClientThread.java:183-204` `getFileMD5()` 算，实现是 `new BigInteger(1, digest).toString(16)` → **前导 0 会被吃掉、长度可能不是 32** |
| 握手 | — | 发完 200B 后，App **等相机回一行以文件名开头的数据**（256B 缓冲 `read` + `startsWith(file.getName())`）才开始 `sendFile()` 以 10240B 分块写文件，写完 `socket.shutdownOutput()` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/FirmwareClientThread.java:100-118`、`:121-171` |

### C.3.4 下行头：72 字节 + 裸文件流

`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:308-351`（`getDataFromSer()`）逐段 `read`：4B（`:315-316`）→ 4B（`:317-318`）→ 64B（`:319-320`）（SigmaStar 包内孪生实现 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:167-209` 同构，读段在 `:172-179`）。

| 偏移 | 长度 | 解析 | 含义 |
|---|---|---|---|
| `[0..3]` | 4 | `bytesToInt(bArr,0)`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:338`） | `CMD`（回显 0） |
| `[4..7]` | 4 | `bytesToInt(bArr2,0)`（`:324`）再过「负数修正」（`:326-330`） | **文件字节数**；小端读法 `(src[o]&255)|(src[o+1]<<8)|(src[o+2]<<16)|((src[o+3]&255)<<24)`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:360-362`；孪生 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:218-220`）→ 与 `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:131` 的 `getInt() & 4294967295L` 一致（按无符号 32 位读） |
| `[8..71]` | 64 | `new String(bytes).trim()`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:353-358`；孪生 `…/sigmastar/data/connect/DownLoadFileUtils.java:211-216`） | 文件名/路径回显 |
| `[72…]` | = 上面的长度 | 循环 `socketReader.read(buf)` 追加写盘 | 裸文件字节流，**无分帧、无 CRC** |

> **`((i>>>1)<<1)|1` 修正的真实形状**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:184-194`，海思版同构于 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:326-336`）：`if (i < 0) { j = ((i>>>1)<<1); if (i%2 != 0) j++; }` —— 把负数长度**向 0 方向取偶**（等价于清掉最低位；奇数再 +1），结果是**仍然是负数**的偶数值，随后 `if (i >= 0) j = i;` 不会覆盖它。也就是说：长度 >2 GiB 时这个「修正」得不到正确的无符号值；只有新写的 `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:131` 读对了。**复现时按 `[4..7]` = uint32 LE 文件长度实现，不要照抄这段修正。**

### C.3.5 一个关键差异：语言表响应用「文本行」读，不用 72B 头

`SSConnectDevice` 发出 72B 头后，读回调用的是 `BufferedReader.readLine()` 循环拼串（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:59`、`:70-97`），再用 `subStr(context, "[", "]")` 截取 JSON 数组（`:113`、`:155-162`），落盘为 `<localAppDataPath>/<VersionNo>.txt`（`:107-113`）。即：**相机在 8080 上对 cmd=0 的响应格式并不统一** —— 语言表请求是「头 + 文本」，文件下载是「72B 二进制头 + 裸流」。同一份代码里两种读法并存，`ClientThread`（本该承担统一读帧逻辑）是空壳（§C.2.2）。

## C.4 事件 / 推送通道

### C.4.1 SigmaStar 侧有没有 socket 推送？—— 有，但不是 SigmaStar 专属，且与 CGI 无关

| 通道 | 方向 | 端口 | 是否对 SigmaStar 生效 | 证据 |
|---|---|---|---|---|
| **`HisiSocketServer`（App 侧 `ServerSocket`，回拨）** | 相机 → 手机 | **5678** | **是**。它由「非 Amba 设备共用的预览页」在 `onCreate` 里**无条件**启动，而该页就是 SigmaStar 的预览页 | `_work/xtu_src/sources/com/gku/module_camera/hisi/HisiSocketServer.java:19`（`SERVER_PORT = 5678`）、`:70-73`（`new ServerSocket()` + `setReuseAddress(true)` + `bind(new InetSocketAddress(5678))`）、`:75-77`（`while(isRunning) accept()`，`setSoTimeout(5000)`）、`:87-97`（65536B 缓冲读到 `-1`）、`:109`（`new String(baos.toByteArray())`，平台默认字符集）、`:117-121`（`runOnUIThread(callback.onReceiveMsg(str))`）；启动点 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:307-312`，回调落到 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:150-156`（`SSResponseParse.parseGetAllInfo(msg)` → `preview.updateOperateCommandUI()`） |
| **`MessageService`（老海思 UI 的 `ServerSocket`）** | 相机 → 手机 | **5678** | 与 SigmaStar 无关，而且**本 APK 里从不启动**（见 §C.4.2 纠正） | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/MessageService.java:19`、`:32`、`:59` |
| 8080 取文件 / 取语言表 | 手机 → 相机（App 主动 `connect`） | 8080 | 是 | §C.3.1 |
| RTSP 554 | 手机 → 相机 | 554 | 是 | §C.5.3 |
| 蓝牙心跳 | 手机 → 相机 | — | **否**，`type ∈ {SSC8838,SSC8826,SSC8838C}` 时 `isBTHeartbeatModel = null` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/common/model/BTHeartbeatManage.java:16-17` |

**报文格式**：5678 上**没有任何帧结构**，读满整条连接后把整段当字符串交给 `SSResponseParse.parseGetAllInfo(String)`。该函数对推送内容做**三态判定**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:497-530`）：

1. 含 `"var"` → 按海思 `var K="V";\r\n` 方言解析（`:502-509`）；
2. 含 `"-222"` → **直接 `return null`**（`:511-513`，即「无状态」，不报错）；
3. 否则按 **真 JSON** `{"mode":…,"state":…,"event":…,"pasttime":…}` 用 `JSONTokener` 解析（`:516-525`），`event` 不是数字时兜 `0` 并打日志 `"event 不是有效的数字: …"`（`:521-523`）。

→ **SigmaStar 的推送体是 JSON**（第 3 态），海思老方言是伪 JSON `var`（第 1 态）。`mode` 是 String、`state`/`event`/`pasttime` 是 int（`SSystemWorkState` 构造，`:525`）。

### C.4.2 5678 到底属于海思还是 SigmaStar？—— 代码在「hisi」包里，行为对两者都开

- 名字/包名归属：两个 5678 实现都在海思命名空间下（`com.gku.module_camera.hisi.HisiSocketServer`、`com.gku.actioncam.hisilicon.dv.net.MessageService`），`sigmastar` 包内**没有**自己的 5678 实现。
- 运行期归属：**SigmaStar 也开**。`HisiActionCameraPreviewActivity` 是 `CameraParameters.IsAmbaDevice == false` 时唯一的预览页（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:265-266`），SigmaStar 机型的 `IsAmbaDevice` 在连接成功时被置 false（主文档 §2.3 副作用 3），因此 `:307` 的 `HisiSocketServer.getInstance().start(this, …)` 对 SigmaStar 必然执行；生命周期绑定在 Activity 的 `ON_DESTROY`（`_work/xtu_src/sources/com/gku/module_camera/hisi/HisiSocketServer.java:48-57`）。
- **`MessageService` 是死服务**：全 18195 个反编译文件里 `MessageService.class` 与 `KeepAliveService.class` **零引用**（只有同包 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/HttpProxy.java:314` 广播它的 action 字符串、以及 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/filebrowser/Hi3518PriviewImageActivity.java:576-578` / `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/filebrowser/PreviewImageActivity.java:632-634` 注册 `MESSAGE_ACTION` 接收器），厂商代码里唯一的 `startService(...)` 在 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/service/DownloadIntentService.java:87`。清单确实注册了这两个 service（`_work/re/xtugo/components.tsv:194-195`），但没有任何代码启动它们 → **5678 的真实监听者是 `HisiSocketServer`，不是 `MessageService`**（见 §C.9）。

### C.4.3 主动轮询与自愈（SigmaStar 预览页）

| 机制 | 周期 / 阈值 | 做什么 | file:line |
|---|---|---|---|
| 旋转轮询 | **500 ms** | `presenter.subscribeScreenRotate()` → `GET …/getcurrotation.cgi`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:173-175`） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:142-150`（`handler.postDelayed(this, 500L)`）；起停 `:252-258`/`:260-263`，`onResume` 启、`onPause` 停（`:332`、`:338`） |
| 卡流自愈 | 每 **1200 ms** 检查一次，`lastStreamTime` 超过 **1500 ms** 未更新即重连 | 重新 `initIjkVideoView(400)`；首次还会 Toast `R.string.text_please_near_device` | `…_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:176-197`、`:849`；`lastStreamTime` 由 ijk `onInfo(what==0 && extra==0)` 刷新（`:792-794`） |
| ijk 内部重连 | `reconnect=5` | 播放器层重连（非 HTTP 层） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java:611` |
| 预览重开 | `Math.max(time, 300)` ms 延时 | `initIjkVideoView(0)`（`onResume`）/ `(400)`（自愈）/ 由 `taskRunnable` 触发 | `…_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:152-158`、`:691-692`、`:844` |
| 设备存活探测 | 2000 ms / 5000 ms 两档 tick，连续 >5 次失败广播 `com.gku.xtugo.DV_ISALIVE_ACTION`（extra `networkpast`=true） | **HTTP 探测**（`Utility.isDeviceAvailable`），不是 socket 心跳；服务未被启动 → 实际不运行 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/net/KeepAliveService.java:12-16,28-33,43-59` |
| 电池 / SD 卡轮询（基类） | — | `ActionCameraPreviewPresenter` 的 `registerMessageReceiver()`、`startBatteryPolling()`、`startSDCardPolling()`、`stopBatteryPolling()`、`stopSDCardPolling()` **五个方法体全空**；对应 what 常量 `WHAT_BATTERY_POLLING=211059`、`WHAT_SD_POLLING=211058` 已无人使用 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/presenter/ActionCameraPreviewPresenter.java:47-48,80-93` |
| 状态获取 | 事件驱动 | `SigmastartPreviewModel` 只在被调用时发一次 `getcurallinfo.cgi`（无自建定时器） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/model/SigmastartPreviewModel.java:179` |
| SigmaStar 专属 socket 工具 | — | `SSHttpClientUtil.SOCKET_WRITE` / `SOCKET_READ` / `SOCKET_DOWNLOAD` **全库零调用**（`SOCKET_READ` 用 `Okio` 逐行读文本；`SOCKET_DOWNLOAD` 用 `available()` 估总量、以 `read()==1` 判结束，逻辑本身不可用） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSHttpClientUtil.java:214-253`、`:256-308`、`:324-425` |

### C.4.4 状态语义（推送与轮询共用）

`state`：**20 = 工作中（`CAMERA_STATE_WORKING_STR`），21 = 待机/结束（`CAMERA_STATE_WORKING_END`）**，常量在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/config/CameraParameters.java:23-24`；SigmaStar 预览页的实际用法：录像开始判定 `state==20`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:1143`）、保存结束判定 `state==21`（`:1160`）。`event` 侧在这两处出现的魔数全集：`11800001`（操作成功，`:1140-1141`）、`1`、`268763137`（开始录像，`:1143`）、`11700002`、`273420290`、`273420291`、`273420315`、`272642051`、`2`、`268763138`（结束/保存，`:1160`）。**其中 `268763137`/`268763138` 是 Amba 风格的事件号出现在共用判定里 —— 说明这套 `event` 值在两条链路上混用**（复现时按机型实测，见 §C.8）。

## C.5 播放层

### C.5.1 `SSVideoView.openVideo()` 的播放器初始化参数（全抄，逐条带类目）

文件：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java`，方法 `openVideo()` 定义于 `:578`，参数段 `:591-613`。类目号语义取自 `_work/xtu_src/sources/tv/danmaku/ijk/media/player/IjkMediaPlayer.java:89-92`（`OPT_CATEGORY_FORMAT=1`、`OPT_CATEGORY_CODEC=2`、`OPT_CATEGORY_SWS=3`、`OPT_CATEGORY_PLAYER=4`）。

| # | 行 | category | key | value | 类型 | 作用 |
|---|---|---|---|---|---|---|
| 1 | `:592` | 2 (CODEC) | `skip_loop_filter` | `48` | long | 跳过环路滤波（`48` = `AVDiscard` 序列里的非标准值，用于降延迟） |
| 2 | `:593` | 1 (FORMAT) | `analyzemaxduration` | `100` | long | 探测最长 100 ms |
| 3 | `:594` | 1 (FORMAT) | `probesize` | `100` | long | 探测只读 100 字节（极小 → 起流快） |
| 4 | `:595` | 1 (FORMAT) | `flush_packets` | `1` | long | 输出包立即 flush |
| 5 | `:596` | 4 (PLAYER) | `packet-buffering` | `0` | long | **关缓冲 = 低延迟核心开关** |
| 6 | `:597` | 4 (PLAYER) | `framedrop` | `12` | long | 落后 12 ms 起丢帧 |
| 7 | `:598` | 4 (PLAYER) | `mediacodec-handle-resolution-change` | `0` | long | 关硬解动态分辨率切换 |
| 8 | `:599` | 1 (FORMAT) | `max-buffer-size` | `1024` | long | 格式层缓冲 1 KB |
| 9 | `:600` | 4 (PLAYER) | `find_stream_info` | `0` | long | **不做流信息探测** |
| 10 | `:601` | 4 (PLAYER) | `render-wait-start` | `1` | long | 等 start 再渲染 |
| 11 | `:604` **或** `:606` | 1 (FORMAT) | `rtsp_transport` = `udp`（AMBA 分支）**/** `rtsp_flags` = `prefer_tcp`（其它分支） | 见 §C.5.2 | String | RTSP 传输选择 |
| 12 | `:611` | 4 (PLAYER) | `reconnect` | `5` | long | ijk 内部重连次数 |
| 13 | `:612` | 4 (PLAYER) | `mediacodec` | `0` | long | **强制软解**（AMMediaCodec 关闭） |
| 14 | `:613` | 1 (FORMAT) | `dns_cache_clear` | `1` | long | 每次清 DNS 缓存 |

**计数结论：`SSVideoView` 的 `setOption` 调用点共 15 处（14 条无条件 + 1 条二选一分支）**，一次实际播放只会执行 **15 条**中的 15 个 setter 调用（分支只落一个键）。

其它同方法事实：`new IjkMediaPlayer()`（`:591`）；`setDataSource(mUri.toString())`（`:627`）；`setDisplay(mSurfaceHolder)`（`:629`）；`setScreenOnWhilePlaying(true)`（`:630`）；`prepareAsync()`（`:631`）；状态置 `MP_STATE_PREPARED=1`（`:632`）。方法开头还会发一次音乐暂停广播 `Intent("com.android.music.musicservicecommand")` + extra `command="pause"`（`:583-585`）。`setUserAgent(String)`（`:562-564`）写入字段 `mUserAgent`（`:73`）后**从未被读取** → UA 设置是死的。整个 `openVideo()` 里 **没有任何 `rtsp_flags`/`rtsp_transport` 以外的 URL 参数拼接**。

### C.5.2 按 `type` 选 UDP / prefer_tcp 的完整分支

`_work/xtu_src/sources/com/gku/actioncam/sigmastar/widget/SSVideoView.java:602-610`：

```
try {
    if (DV.getInstance().cameraInfors.getType().equals(SSConstant.AMBA)
        || DV.getInstance().cameraInfors.getType().equals("CV75")) {   // :603
        ijkMediaPlayer.setOption(1, "rtsp_transport", "udp");           // :604
    } else {
        ijkMediaPlayer.setOption(1, "rtsp_flags", "prefer_tcp");        // :606
    }
} catch (Exception e) { Log.e(TAG, "openVideo: " + e.toString()); }     // :608-610
```

- **只有两个取值**：`H75N` 与 `"CV75"` → `rtsp_transport=udp`；**其余全部（含 `SSC8838`/`SSC8826`/`SSC8838C` 与所有 `Hi*`）→ `rtsp_flags=prefer_tcp`**。
- 判据是 `DV.getInstance().cameraInfors`，**`cameraInfors` 为 null 或未连接时抛 NPE，被 `:608` 的 `catch (Exception)` 吞掉** → 此时两个键**都不会被设置**（ijk 用默认 `prefer_tcp` 前的 udp 优先行为）。这是「偶发预览只有画面无流」的静态解释候选。
- 注意键不同：AMBA 设的是 `rtsp_transport`（强制），SS/海思设的是 `rtsp_flags=prefer_tcp`（偏好，仍可回落）。

### C.5.3 预览 URL 的构造代码：`/12` 与 `/11`

| 平台 | 构造代码 | 结果串 | 是否有 `/11` |
|---|---|---|---|
| SigmaStar（与海思新 UI 共用） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:49-51` `return SS_PROTOCOL_RTSP + SSConstant.SS_IP + ":554/livestream/12";`；常量 `:31 SS_LIVE_STREAM_PATH="/livestream/12"`、`:32 SS_LIVE_STREAM_PORT="554"`、`:34 SS_PROTOCOL_HTTP="http://"`、`:35 SS_PROTOCOL_RTSP="rtsp://"` | `rtsp://192.168.0.1:554/livestream/12`（IP 是 `SSConstant.SS_IP`，**非 `CameraParameters.baseIp`**，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:13` 该字段还**不是 final**） | **否**，`/12` 是字面量硬编码，`SS_LIVE_STREAM_PATH` 常量本身在全库无人引用（`catalog-http.md:170-171` 只登记了两处定义） |
| 海思新 UI 孪生类 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:49-51` 完全同串（`:31`、`:32 SS_LIVE_STREAM_PORT=554`（**这里是 `int`**）） | 同上 | 否 |
| **海思老 UI（唯一有 `/11` 的地方）** | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:319-329` `new StringBuilder("rtsp://") + ip + ":554/livestream/" + (isPreviewBigBitRate() ? "11" : "12")` | `rtsp://<ip>:554/livestream/11` 或 `/12` | **是**，开关 `isPreviewBigBitRate()`（`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:119`） |
| 海思老 UI 的 HTTP 预览 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:331-342` `http://<ip>:80/` + (`11?`/`12?`) + `trans=tcp&action=play&media=video_data` | `http://<ip>:80/12?trans=tcp&action=play&media=video_data` | 是（同一开关） |
| Ambarella 预览页 | `String.format("rtsp://%s:554/livestream/12", ip==null?"192.168.0.1":ip)`（`_work/xtu_src/sources/com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:972`） | `rtsp://<ip>:554/livestream/12` | 否 |

**SigmaStar 的取流调用点**（`SSCommandUtil.previewLiveStream()` 的两个调用方）：
`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:767`（SigmaStar 机型走这里）与 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:752`。

### C.5.4 SigmaStar 预览**实际用的不是 `SSVideoView`**

- `HisiActionCameraPreviewActivity` 自建 `this.preview_texture_video_view = new VideoTextureView(this)` 并塞进 `preview_container`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:757-760`，字段声明 `:109`，import `:59`）。
- `VideoTextureView` 的实现体在 `_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java`，`openVideo(boolean isAmba)` 定义于 `:606`，参数段 `:617-646`。
- `SSVideoView` 的**唯一**引用是布局 `activity_s_s_video_remote_play.xml`（`_work/re/xtugo/layouts.tsv:93`，节点 `@+id/video_remote_play_video`）与其 DataBinding 类 `_work/xtu_src/sources/com/gku/xtugo/databinding/ActivitySSVideoRemotePlayBinding.java:35`；**全树没有任何 Activity/Fragment 使用该 Binding**（`RemotePlay` 相关 Binding 只有 `ActivitySSVideoRemotePlayBinding`、`ActivitySSPhotoRemotePlayBinding` 两个类文件，二者都无调用方）→ `SSVideoView` 在当前 8.4.3 包里是**可执行但不可达**的旧播放层。

`VideoTextureView` 的参数全集（21 条无条件 + 分支 2 条，逐条，`_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java`）：

| 行 | cat | key | value | | 行 | cat | key | value |
|---|---|---|---|---|---|---|---|---|
| `:619` | 4 | `mediacodec-hevc` | `1` | | `:629` | 2 | `flags` | `"low_delay"`（String） |
| `:620` | 1 | `analyzeduration` | `1` | | `:630` | 1 | `dns_cache_clear` | `1` |
| `:621` | 1 | `fflags` | `"nobuffer"`（String） | | `:631` | 4 | `mediacodec` | `0` |
| `:622` | 1 | `analyzemaxduration` | `5000` | | `:632` | 4 | `mediacodec-auto-rotate` | `0` |
| `:623` | 1 | `flush_packets` | `1` | | `:633` | 4 | `mediacodec-handle-resolution-change` | `0` |
| `:624` | 1 | `probesize` | `4096` | | `:634` | 2 | `skip_loop_filter` | `0` |
| `:625` | 4 | `start-on-prepared` | `1` | | `:635` | 1 | `http-detect-range-support` | `0` |
| `:626` | 4 | `packet-buffering` | `0` | | `:636` | 4 | `max-buffer-size` | `1024` |
| `:627` | 4 | `infbuf` | `1` | | `:637` | 4 | `min-frames` | `2` |
| `:628` | 4 | `no_delay` | `1` | | `:638` | 4 | `max_cached_duration` | `300` |

分支（**判据是入参 `isAmba`，不再是 `type` 字符串**）`:639-646`：`!isAmba` → `setOption(1,"rtsp_transport","tcp")` + `setOption(4,"framedrop",5)`（并打日志 `"当前设置的丢帧数为5"`）；`isAmba` → `setOption(1,"rtsp_transport","udp")` + `setOption(4,"framedrop",100)`。

`isAmba` 的来源（完整分支）`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:817-838`：`cameraInfors == null` → 先发 Amba 命令 `msg_id=11`（`AmbaConnector.sendCmdQueue(..., 11, CameraInfoResponseBean.class, ...)`，`:820`）并在成功回调里以 `isAmba=true` 起播（`:828`）；`cameraInfors != null` 且 `type.equals("H75N") || type.equals("CV75")` → `isAmba=true`（`:833-834`）；**否则（含全部 SigmaStar 三值与 `Hi*`）→ `isAmba=false` → `rtsp_transport=tcp` + `framedrop=5`**（`:836`）。`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/AmbaActionCameraPreviewActivity.java:812-815` 同构。签名：`setVideoPath(String path, boolean isAmba, String flipValue)`（`_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java:423-426`）→ `setVideoURI(Uri, boolean)`（`:429-432`）→ `openVideo(isAmba)`。

**因此对 SigmaStar 真机而言：走的是 `rtsp_transport=tcp`（不是 `SSVideoView` 的 `rtsp_flags=prefer_tcp`）。** 镜像/翻转由 `flipValue` 字符串（`"0°"`/`"90°"`/`"180°"`/`"270°"`）在 View 层做矩阵处理（`_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java:746-754`），初值 `"0°"`（`:99`、`:270`），预览页传入 `previewFlipValue`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:828/834/836`）。

### C.5.5 ijkplayer 与 ExoPlayer 各自用在哪

| 播放器 | 用在哪 | 证据 |
|---|---|---|
| **ijkplayer（`IjkMediaPlayer`，`libijkplayer.so`/`libijkffmpeg.so`/`libijksdl.so`）** | ① SigmaStar/海思预览实际链路：`VideoTextureView.openVideo()` `:617`；② 旧播放层 `SSVideoView.openVideo()` `:591`；③ `com/gku/actioncam/widget/VideoView.java:596-624`（Amba 预览页与远程回放页 `AmbaRemoteVideoActivity`、轨迹页 `TrackActivity` 用）与 `:666-687`（第二个 `openVideo` 变体）；④ 预览页显式加载：`IjkMediaPlayer.loadLibrariesOnce(null)` + `native_profileBegin("libijkplayer.so")`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:770-771`） | 行号如左 |
| **ExoPlayer（`com.google.android.exoplayer2`）** | **只有一处**：`GKUCamPlayer`（清单里 `exported=true` 的对外播放页）在 `onCreate` 里 `PlayerFactory.setPlayManager(Exo2PlayerManager.class)` 把 GSY（`com.gku.ffm.zqvideo`）的后端整体切到 Exo2（`_work/xtu_src/sources/com/gku/gkucamplayer/GKUCamPlayer.java:35`），播放器视图是 `LandLayoutVideo`（`:42`），输入来自 intent extra `"kPlayFilePath"` / `"kPlayFileName"`（`:38-39`）。真正 `new ExoPlayer.Builder(...)` 的位置在 `_work/xtu_src/sources/com/gku/mediacodec/exo2/IjkExo2MediaPlayer.java:897`（由 `Exo2PlayerManager` 持有，`_work/xtu_src/sources/com/gku/mediacodec/exo2/Exo2PlayerManager.java:18`） | 行号如左 |
| GSY（`com.gku.ffm.zqvideo`） | 只被 `GKUCamPlayer` 使用（`import com.gku.ffm.zqvideo.video.base.GSYVideoPlayer`，`_work/xtu_src/sources/com/gku/gkucamplayer/GKUCamPlayer.java:15-18`）；`com.gku.actioncam.**` 下**零引用** | `grep GSYVideoManager com/gku/actioncam/` 无命中 |

> `com/gku/**` 里其余 30+ 个 `import com.google.android.exoplayer2.*` 的文件**全是把 Exo 常量当字符串常量大用**（如 `SessionDescription.SUPPORTED_SDP_VERSION=="0"`、`IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE=="1"`、`IjkMediaMeta.AV_CH_WIDE_LEFT==2147483648`），不是真的在用 ExoPlayer —— 例：`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:17,77,85`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:124`。

### C.5.6 在线回放的 URL（与预览不同源）

SigmaStar 文件在线播放走 **HTTP 而非 RTSP**：`http://192.168.0.1<originPath>` 且把 `.MP4`→`-s.MP4`、`.mp4`→`-s.mp4`（小码流），见 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:154-155`。同一函数另两分支：AMBA/`"CV75"` 用 `http://192.168.0.1<path 去 "/tmp/SD0">` 且 `.MP4`→`.LRV`（`:157-158`）；其它（海思）用 `http://192.168.0.1/<path>`（**多一个斜杠**）且 `.MP4`→`.LRV`（`:160`）。

## C.6 回放与文件

### C.6.1 取列表（SigmaStar = `SigmastartPlaybackModel`）

| 步骤 | 请求（完整串） | 解析 | 分页 | file:line |
|---|---|---|---|---|
| 1. 取总数 | `GET http://<探测IP>/cgi-bin/hi3510/getfiletypecount.cgi` | `SSResponseParse.parseGetFileCount(body, type)`：`type=="Video"\|\|"Normal"` → `videocount`；`"Emr"` → `eventcount`；`"Photo"` → `imagecount`；其它 → `0`；解析异常返回 `0` | — | 请求 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/SigmastartPlaybackModel.java:68`（`DeviceHttpUtils.get(SSCommandUtil.getFileCount())`），路径 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:57-59`，解析 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:79-95` |
| 2. 取一页 | `GET …/cgi-bin/hi3510/getfilelist.cgi?-start=<curIndex>&-end=<curIndex+49 或 count-1>&-type=<Photo\|Video>` | `SSResponseParse.parseGetFileListAndInfo(body, type)` | **每页 50 条**，`-end = curIndex+49 > count ? count-1 : curIndex+49`；本页返回 ≥50 条则 `curIndex += size` 递归续拉（`:228-231`），否则 `loadDataFinish()` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/SigmastartPlaybackModel.java:202-241`（分页算式 `:205`），URL `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:69-71` |
| 3. 列表体解析 | — | **响应是 JSON 数组**（不是 `var` 方言）：逐元素取 `path` / `time` / `size` / `create`；若首元素的 `create` 含 `-` 则把**所有元素**的 `create` 里 `-` 全换成 `/`；按扩展名分派 `type`：`"Normal"`/`"Video"` 直收，`"Event"` 只收 `.mp4`，`"Photo"` 只收 `.jpg` 或 `.dng`（`SSConstant.SSFileFormat`）；同时用 `isFileLocalExists(localPath)`（视频额外看 `localPathLRV`）标记已下载 | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:132-173`（键名来自被复用的三方常量：`ClientCookie.PATH_ATTR=="path"` `org/apache/http/cookie/ClientCookie.java:11`、`RequestParameters.COMP_CREATE=="create"` `com/aliyun/oss/internal/RequestParameters.java:7`、`CrashHianalyticsData.TIME=="time"`、`"size"` 字面量） |
| 4. 目录名（可选） | `GET …/cgi-bin/hi3510/getdirname.cgi` | `parseDirname()` → `parseMessageToMap(...).get("value")` 按 `,` 切 | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:61-63`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:54-66` |
| 5. 删除 | `GET …/cgi-bin/hi3510/deletefile.cgi?-name=<originPath>`（**逐个文件一次请求，无批量 CGI**） | 只看回调成功/失败 | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/SigmastartPlaybackModel.java:184-199`（`for` 循环逐个发），`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:77-79` |
| 6. 单文件信息 | `GET …/cgi-bin/hi3510/getfileinfo.cgi?-name=<originPath>` | `parseGetFileInfo()` → `path`/`size`/`create`/`time` | — | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:81-83`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:117-130` |

本地落盘路径（`SSFileInfoBean`）：`getLocalPath()` = `G.localDCIMActionCamVideoDataPath`（文件名以 `.mp4` 结尾时）或 `G.localDCIMActionCamPhotoDataPath`，再 `+ "/" + fileSize + "_" + fileName`（**用文件大小做前缀做去重/断点判据**，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:187-197`）；小码流本地路径 `getLocalPathLRV()` = `FileUtils.getMediaPath() + "/" + fileName` 把 `.MP4→s.MP4`、`.mp4→s.mp4`（`:199-201`）；`fileName = SSFileUtil.pathShortName(originPath)`（`:53`）。

### C.6.2 缩略图

| 维度 | SigmaStar | 海思（对照） | Ambarella（对照） |
|---|---|---|---|
| URL 生成 | `String.format("http://%s/thumb%s", SSConstant.SS_IP, originPath)` → `http://192.168.0.1/thumb/tmp/SD0/DCIM/…` | `http://192.168.0.1/<originPath>` 且扩展名换成 `.THM`（`HiDefine.FILE_SUFFIX_THM`，`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/HiDefine.java:30`） | 直接用 `originPath`（走 msg 1285 + 8787） |
| 代码 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:82-83` | `…/bean/SSFileInfoBean.java:87-92` | `…/bean/SSFileInfoBean.java:84-85` |
| 取回方式 | **HTTP GET（OkHttp，非 8080）**：`SSDownloadUtil.singleSyncDownload(thumbPath, 本地缓存路径, cb)` → `SSHttpClientUtil.SYNC(SSHttpClientUtil.GET(url))` → `HTTP_DOWNLOAD` | 同一函数（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/HisiPlaybackModel.java:157`） | `AmbaPlaybackModel` 走 socket |
| 调用点 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/SigmastartPlaybackModel.java:89-135`（`loadThumb`），本地缓存路径由 `AmbaPlaybackUtil.remotePathExchangeLocalCache_dcf(thumbPath)` 换算（`:96`），成功回调 `loadThumbSuccess`（`:103,132`），失败 `downloadTaskFailure`（`:115`）；另有 `loadThumbRetry(thumbPath)`（`:45`） | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/HisiPlaybackModel.java:136-181` | — |
| 缓存目录 | `FileUtils.getExternalCacheDirectory() + "/" + fileName` 把 `.MP4`/`.JPG`/`.mp4`/`.jpg` 一律换成 `.THM`（`getCachePath()`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:203-207`）；另有常量 `SSConstant.LOCAL_THUMB_CACHE_DIR = "/mnt/sdcard/Android/data/com.gku.xtugo/cache/"`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:11`） | 同 | 同 |
| 缩略图 CGI | **不存在**（无 `getthumbnail.cgi`；`catalog-http.md` 405 条里也无） | 不存在 | 不存在 |

### C.6.3 下载原文件与「续传」

| 环节 | 事实 | file:line |
|---|---|---|
| 入口 | `SSPlaybackNewPresenter` → `SSDownloadUtil.getInstance().multipleSyncDownload(list, isAmba = model instanceof AmbaPlaybackModel, cb)` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/presenter/SSPlaybackNewPresenter.java:268` |
| 空间预检 | `StatFs(externalStorage).availableBlocks * blockSize < fileSize` → 回调 `notEnoughSpace()` 并直接返回 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:77-81`、`:231-234` |
| 队列持久化 | 下载前把整个 `ArrayList<SSFileInfoBean>` 用 Gson 写进 SP 文件 `"download_file_list"` 的键 `"file_list"`；队列被清空时从那里回灌 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:83`、`:236-250` |
| **≥2 GiB 分支** | `fileSize >= IjkMediaMeta.AV_CH_WIDE_LEFT(=2147483648L，`_work/xtu_src/sources/tv/danmaku/ijk/media/player/IjkMediaMeta.java:60`)` 且 remotePath 不含 `.LRV` → 走 **8080 二进制** `DownLoadFileUtils.getInstance(app).createConnection(remotePath, savePath)` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:85-88`；实现见 §C.3 |
| **<2 GiB 分支** | 纯 HTTP：`SSHttpClientUtil.GET(remotePath)` + `SYNC(...)` + `HTTP_DOWNLOAD(response, savePath, cb)` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:152-159` |
| **续传方式（HTTP）** | **没有 Range/断点续传**。`HTTP_DOWNLOAD` 先删掉临时文件 `savePath + ".MP4"`，整份重写到临时文件，按 `getContentLength()` 算进度（≥300 ms 才回调一次），完成后 `renameTo(savePath)`；改名失败回调 `"临时文件替换失败！警告：此时源文件已丢失！！"` | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSHttpClientUtil.java:138-197`（删除 `:147-150`、节流 `:166-170`、改名 `:173-181`） |
| **续传方式（8080）** | 以 **append 模式**打开目标文件（`new FileOutputStream(file, true)`）后从流头开始追加，**不查询已落盘字节数、不发 offset** → 同一文件重复下载会产生重复内容；唯一「已下过」判据是上层用 `localPath` 里带的 `fileSize` 前缀做存在性检查 | `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/DownLoadFileUtils.java:213-219`（`downloadFile2`）；存在性判定 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:158-164` |
| 取消 | HTTP：`currentDownloadCall.cancel()` + `isSyncMultipleDownloadTaskCancel=true`；8080：`DownLoadFileUtils.disConnect()` 把 `Tag=false`，下一轮循环回调 `onItemClick(-1.0f, null)` 并**删除已落盘文件** | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:61-69`；`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/presenter/SSPlaybackNewPresenter.java:279-281`；`DownLoadFileUtils.java:107-113`（hisi 版 `disConnect()` 置 `Tag=false`）；失败删文件 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:133-136` |
| 完成后入库 | `Build.VERSION.SDK_INT >= 29` → `SSPlaybackNewPresenter.downloadToDcimNoLessThan29(ctx, savePath, Common.DATA_DIRECTORY_NAME)`，否则 `downloadToDcimNoMoreThan28(...)`；8080 路径下进度到 `100.0f` 才触发 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:99-103`、`:160-164` |
| 后台服务版 | `DownloadIntentService`（OldUi）也调 `SSDownloadUtil.multipleSyncDownload(fileList, false, …)`，即服务路径同样按 2 GiB 分流 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/service/DownloadIntentService.java:178` |

### C.6.4 与海思的结构性差异（回放面）

| 维度 | SigmaStar（`SigmastartPlaybackModel`） | 海思新 UI（`HisiPlaybackModel`） |
|---|---|---|
| HTTP 客户端 | `DeviceHttpUtils.get(...)`（xUtils，URL 绝对化用**探测到的网关 IP**，`_work/xtu_src/sources/com/gku/base/device/DeviceHttpUtils.java:14-15`） | `HttpRequestUtils.getInstance().doRequest(相对 CGI 路径, cb)`（OkHttpUtils，60 s 三超时，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/HttpRequestUtils.java:60-64`；调用点 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/HisiPlaybackModel.java:83,188,203,235,281`） |
| 列表命令 | `getfilelist.cgi?-start=&-end=&-type=`（带 `-type`） | `getfilelistinfoios.cgi?-start=&-end=`（分页 50，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/playback/model/HisiPlaybackModel.java:281` 用 `i+50 > count ? count : i+50`，**边界与 SS 的 `count-1` 不同**） |
| 计数命令 | `getfiletypecount.cgi` | `getfilecount.cgi`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:75-77`） |
| 缩略图 | `http://ip/thumb<path>` | `http://ip/<path 换 .THM>` |
| 小码流文件 | `-s.MP4` / `-s.mp4` | `.LRV` |
| 命令工具类 | `SSCommandUtil` | `HaisiCommandUtil`（含 `getexecuteCommand(int)` 命令号方言，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:53-69`） |

## C.7 设置项在 SigmaStar 侧的落地

### C.7.1 自描述菜单 → UI 的完整链路

```
SSDeviceSettingActivity / SSFastSettingPopupWindow
  └ SettingModelManage.getModel() → SigmastartSettingModel
      ├ getPrimaryMenuItem(curMode, itemName)                       _work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:151
      │    GET http://<探测IP>/cgi-bin/hi3510/getprimarymenuitem.cgi?-workmode=<curMode>   （_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:105-107）
      │    → SSResponseParse.parseGetPrimaryMenuItem(body)          _work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:155
      │    → recombinationData(list, itemName)   ← SSC8838 专属修正  :156 / 定义 :117-148
      │    → callback.getPrimaryMenuItemSuccess(list)               :157
      ├ getSecondMenuItem(curMode, name)                            :87
      │    GET …/getsecondmenuitem.cgi?-workmode=&-name=           （_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:109-111）
      │    → SSResponseParse.parseGetSecondItem(body) → SSecondItemBean(itemList, curValue)  :91
      └ setCurParam(curMode, name, value)                           :102
           GET …/setcurparameter.cgi?-workmode=&-name=&-value=     （_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:117-119）
           → callback.setCurParamSuccess(body, name, value)        :106   ← 只看 HTTP 成功，不校验响应体
```

`parseGetPrimaryMenuItem(String)` 的类型推断（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:423-465`）：

| 步 | 规则 | 行 |
|---|---|---|
| 1 | 用 `parseMessageToMap2`（只要求 `";` 收尾，**不要求 `\r\n`**）取 `item` 与 `cur` | `:426` |
| 2 | `cur.replace(",,", ",-,")` —— 空位补占位符 `-` | `:428` |
| 3 | 若 `cur` 以 `,` 开头 → 前面补 `-`；以 `,` 结尾 → 后面补 `-` | `:429-434` |
| 4 | `item.split(",")`；若 `cur` 段数少于 `item` 段数，尾部按差额逐个追加 `",-"`（**`String` 重载独有；`Response` 重载 `:384-421` 不补**） | `:435-441` |
| 5 | 段数仍不等 → **整表返回 `null`**（UI 空白） | `:442-444` |
| 6 | 逐项定型：值 `=="ON"` 或 `=="OFF"` → `SWITCH`；值非空且 `!="-"` → `SELECT`；否则 → `CLICK` | `:446-453` |
| 7 | `CLICK` 项**不写 `itemValue`**（保持 null） | `:454-457` |

UI 侧只有 3 种 viewType，按 `SettingItemType.ordinal()`（声明顺序 `SELECT=0, SWITCH=1, CLICK=2`，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/ui/adapter/SettingRecycleAdapter.java:27-31`）分派：`SELECT` 分支 `:63`、`SWITCH` 分支 `:66`；点击回调仅对 `CLICK` 生效（`:105`）、选择弹窗仅对 `SELECT`（`:113`）、开关回调要求 `compoundButton.isPressed() && type==SWITCH`（`:121`）。承载数据的是 `SSettingItemBean{type, itemName, itemValue}`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSettingItemBean.java:7-9`）与 `SSecondItemBean{itemList, curValue}`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSecondItemBean.java:8-9`）。

**SSC8838 专属的菜单裁剪 `recombinationData()`**（`cameraInfors.getType().equals(SSConstant.CHIP)` 为假即整体 return，`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:119`）：

| 条件 | 动作 | 行 |
|---|---|---|
| 任一项 `itemValue` 含 `"P120"` | 从列表删除 `itemName` 含 `"EIS"` 的项 | `:123-130` |
| `itemName` 含 `"EIS"` 且 `itemValue.equals("ON")` | 删除 `itemName` 含 `"LDC"` 的项 | `:131-138` |
| `itemName` 含 `"LDC"` 且 `itemValue.equals("ON")` | 删除 `itemName` 含 `"EIS"` 的项 | `:139-146` |

（对比：老海思方言同类规则靠 `"Resolution"` 的 8 个高帧率值 + `"ImageStabilize"` 判定，见主文档 §4.1 的 type=2 行。）

### C.7.2 `SSResponseParse` 字段映射表（字段名 → 语义 → 单位）

解析底座：`HEAD_VAR="var "`、`MID_EQUAL_MARK="=\""`、`TAIL_SEMICOLON="\";\r\n"`、`SS_SUCCESS="Success"`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:39-43`）。两个解析器：`parseMessageToMap` 要求行尾 `";\r\n`（`:532-545`）、`parseMessageToMap2` 只要求 `";`（`:547-560`）；两者在 `indexOf` 顺序不合法时 **break 并返回已解析部分**（不抛错）。

| CGI | 响应键 | 目标字段 / 返回 | 语义 | 单位与取值 | 行 |
|---|---|---|---|---|---|
| `getdeviceattr.cgi`（**不在此类**，走 `HttpRequest.getMap()`） | `type` / `name` / `softversion` / `hardversion` | `CameraInfors` | 平台判定键 / 机型名 / 软版 / 硬版（`=="NewAPP"` 决定方言） | String | 主文档 §2.3 |
| `getdirname.cgi` | `value` | `String[]` | 目录名列表 | 逗号分隔 | `:54-66` |
| `getfiletypecount.cgi` | `imagecount` | int | 照片数 | 张；解析失败 = `0` | `:68-95` |
| 同上 | `videocount` | int | 视频数（`type=="Video"\|\|"Normal"`） | 条 | `:68-95` |
| 同上 | `eventcount` | int | 事件/紧急录像数（`type=="Emr"`） | 条 | `:81-84` |
| 同上（无 type 重载） | 三键求和 | int | 文件总数 | 个 | `:97-115` |
| `getfileinfo.cgi` | `path` / `size` / `create` / `time` | `SSRemoteFileInfo.path/size/createTime/time` | 路径 / 大小 / 创建时间 / 时长 | `size` 字节(String)；`create` `yyyy-MM-dd HH:mm:ss` 或 `yyyy/MM/dd HH:mm:ss`；`time` 秒(String) | `:117-130` |
| `getfilelist.cgi`（**JSON 数组**，非 `var` 方言） | `path` | `SSFileInfoBean.originPath` | SD 卡绝对路径，形如 `/tmp/SD0/DCIM/…/xxx.MP4` | String | `:132-173` |
| 同上 | `create` | `createTime` | 拍摄时间；**首元素含 `-` 时全表 `-`→`/`** | String | `:140,151-155` |
| 同上 | `time` | `videoTime` | 视频时长 | 秒（String） | `:148,156` |
| 同上 | `size` | `fileSize` | 字节数；也参与本地文件名前缀 | 字节（String，消费方 `Long.parseLong`） | `:149,157` |
| 同上 | （扩展名） | 是否入列表 | `Photo` 只收 `.jpg`/`.dng`；`Normal`/`Video` 全收；`Event` 只收 `.mp4` | — | `:159-166` |
| `getfilelistinfoios.cgi`（重载 `parseGetFileInfo(Response,String)`） | `path`/`create`/`time`/`size` | 追加进 `PlaybackModelManage.imageThumbList` / `videoThumbList` | 同上；差异：**不修正 `create` 的 `-`**，直接塞静态表 | — | `:175-201` |
| `getallworkmode.cgi` | `video` / `photo` | `HashMap<String,ArrayList<String>>` | 两类工作模式名（**值带空格**，如 `Normal Video`） | 逗号分隔 | `:203-216`；消费 `SSExchangeWorkMode.isVideoMode/isPhotoMode`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSExchangeWorkMode.java:27-35`） |
| `getcurworkmode.cgi` | `workmode` | String | 当前模式 | 带空格串 | `:218-234` |
| 同上 | 整表 | `HashMap<String,String>`（`parseGetCurWorkModeForMap`） | 当前响应全部键值 | — | `:236-243` |
| `getbatterycapacity.cgi` | `capacity` | `SSBatteryInfo.capacity` | 电量百分比；**`>100` 或 `<0` 一律折成 `0`** | `%`（int） | `:245-279`（钳位 `:253,271`） |
| 同上 | `capacity`（二次消费） | `SSBatteryInfo.bCharging` | 「是否充电中」= **`capacity` 字符串恰好 `=="1"`** | 布尔；语义可疑（§C.8 #4） | `:250,268`；构造 `SSBatteryInfo(int capacity, boolean bCharging, boolean bAC)`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSBatteryInfo.java:30`） |
| 同上 | `ac` | `SSBatteryInfo.bAC` | 是否接外接电源 | `"1"`=是 | `:251,269` |
| `getsdstate.cgi` | `sdstatus` | `SSTFCardInfo.sdState` | 卡状态 | `"1"`→`NORMAL`；`"3"`→`FULL`；`"0"` 或 `"2"`→`NONE`；其它→`ERROR`；`sdtotalspace==0` 时（**仅 String 重载**）强制 `NONE` | `:281-323`；枚举 `SSTFCardInfo.TFCardState{NORMAL,FULL,NONE,ERROR}`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSTFCardInfo.java:25-30`） |
| 同上 | `sdtotalspace` | `SSTFCardInfo.total` | 卡总容量 | **MB**；设备回 `"xxxx MB"`，代码 `replace(" MB","")` 后 `parseInt`；缺键 → `-1` | `:294,314` |
| 同上 | `sdfreespace` | `SSTFCardInfo.used`（**算出来的**） | 已用 = `total - free` | MB；缺键 → `-1` | `:295,315` |
| `getcurparameter.cgi` / `getsecondmenuitem.cgi` | `value` | String（`parseGetResolution`、`parseGetFastSetting`） | 当前值 | 原样 | `:325-341`、`:366-382` |
| `getsecondmenuitem.cgi` | `item` | `SSecondItemBean.itemList` | 可选值列表 | 逗号分隔 | `:343-364` |
| 同上 | `value` | `SSecondItemBean.curValue` | 当前值 | String | `:348,359` |
| `getprimarymenuitem.cgi` | `item` | `SSettingItemBean.itemName` 序列 | 一级菜单项名（**英文原词**） | 逗号分隔 | `:384-465` |
| 同上 | `cur` | `SSettingItemBean.itemValue` + 决定 type | 当前值序列；空位写作 `,,`，缺位用 `-` 补 | 逗号分隔 | 同上 |
| `setwifi.cgi` / `getwifi.cgi` | `wifissid` / `wifikey` | `SSWiFiInfo` | 热点名 / 密码 | String | `:467-485` |
| `getcurallinfo.cgi`（+ 5678 推送） | `mode` / `state` / `event` / `pasttime` | `SSystemWorkState` | 当前模式 / 状态 / 事件号 / 已录时长 | `mode` String；`state` int（20=WORKING、21=STANDBY）；`event` int/long 魔数；`pasttime` **原样 int，无单位换算** | `:487-530` |
| 任意写命令 | 响应体 `Success` | — | 唯一被认的「成功」字面量，但**各调用点并不校验** | String | 常量 `:41` |

### C.7.3 菜单文案的翻译（设备自描述的第二层）

`SSFileUtils.changeStr(value)`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:77-113`）：取 `Locale.getDefault().getLanguage()`，国家码 `HK` 时后缀 `_HK`（`:80-82`）→ SigmaStar 走 `getReplaceValueForJson(en, lang)`：读 **`<localAppDataPath>/<CameraParameters.VersionNo>.txt`**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:141-158`，与海思 XML 共用同一文件名，`getReplaceValueForXml` 在 `:160-183`），`JSONArray` 逐元素 `getString("en")` 精确等于原文才返回 `getString(<lang>)`，否则原样返回英文。语言表来源见 §C.3（8080 拉 `/tmp/FL0/language.json`，落盘 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:107-113`，并只截取首个 `[` 到末个 `]` 之间的内容，`:113`+`:155-162`）。海思 XML 表节点是 `<lanstr en="…" zh="…" …/>` 且需先 `escapeXml`（`:169-182`、`:185-190`）。**结论与主文档 §4.2 一致：SigmaStar 的中文文案不在 APK 里。**

## C.8 未解之谜（SigmaStar 专属，不含主文档 §10 已列的通用项）

| # | 问题 | 静态为何定不来 | 补证手段 |
|---|---|---|---|
| 1 | 量产 SigmaStar 机型的真实 `type` 到底是三个值中的哪一个（甚至是否还有第四值，如 `SSC86xx`） | 分派键由设备自报（§C.1.1），APK 内无型号→芯片表 | 逐台 `GET /cgi-bin/hi3510/getdeviceattr.cgi` 抄 `type`/`hardversion` |
| 2 | `SSC8838C` 是否真的在跑 | 三处判定漏掉它（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/newUi/deviceFastSetting/FastSettingModelManage.java:19`、`_work/xtu_src/sources/com/gku/module_base_xtugo/HisiApiUtils.java:30`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/setting/model/SigmastartSettingModel.java:119` 只认 `SSC8838`），若某机型报 `SSC8838C`，快设/能力位/EIS-LDC 裁剪会静默失效 | 拿到该机型后专门验这三处行为 |
| 3 | 5678 上相机实际推的是 JSON 还是海思 `var` 方言 | `parseGetAllInfo(String)` 同时支持三态（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:497-530`），静态无法判定固件用哪一态 | 在预览页起 `tcpdump`/相机侧抓包，录一段像看推送体 |
| 4 | `getbatterycapacity.cgi` 的 `bCharging` 键位是否错位 | 代码用 `capacity.equals("1")` 判「充电中」（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:250,268`），而 `ac` 才像充电位（`:251,269`）；两种实现都能自圆其说 | 插/拔充电线各读一次 `getbatterycapacity.cgi`，抄原始 `var` 行 |
| 5 | `sdstatus` 的 `"2"`、`"3"` 与 `sdtotalspace` 是否总带 `" MB"` 后缀 | 只有 `replace(" MB","")` 的容错（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:294,314`），无枚举表 | 无卡 / 满卡 / 正常卡三态各读一次 `getsdstate.cgi` |
| 6 | `language.json` 的完整语言列集合（`en` 之外有哪些键）与 `zh_HK` 命名 | 只按 `Locale.getLanguage()`（+`_HK`）取值，缺列即回落英文（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSFileUtils.java:141-158`） | 拉一次 `/tmp/FL0/language.json` 全量导出 |
| 7 | `-222` 判据的误伤面 | `message.contains("-222")` 会同时吞掉 `0xFFFFF752(-2222)` 与任何含 `-222` 的正常文本（如时长 `pasttime=-2220` 或模式串） | 制造 `-2222` 与含 `-222` 的正常响应各一次，比对 UI 表现 |
| 8 | 8080 对 `cmd=0` 的响应头是否**总是** 72B 二进制 | 语言表请求（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:59,70-97`）用 `readLine()` 按文本读，文件下载（`DownLoadFileUtils`）按 4+4+64 二进制读 —— 同一命令两种读法，说明相机行为可能是「先发头再发文本」而 App 只是不校验 | 抓 8080 原始字节流，比对 `[0..3]` 是否恒为 `00 00 00 00` |
| 9 | 固件推送的 MD5 是否被相机校验 | App 侧 `getFileMD5()` 用 `new BigInteger(1,digest).toString(16)`（`FirmwareClientThread.java:197`），**前导 0 会被截掉** → 长度可能 <32；相机是否校验未知 | 故意改坏固件包再推，看是否被拒 |
| 10 | `getfiletypecount.cgi` 的 `eventcount` / `-type=Emr` 在 SigmaStar 上是否存在 | `SSCommandUtil.getFileList(int,int,int)` 只会发 `Photo`/`Video`（`:66`），`Emr` 只出现在计数侧（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:81-84`） | 触发一次紧急录像后读计数并列目录 |
| 11 | SS 预览是否真的需要 `getcurrotation.cgi` 500 ms 轮询（对相机负载的影响） | 只有代码节奏（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:142-150`），无实测 | 抓包计频 + 观察预览延迟 |

## C.9 对主文档的补充与纠正

| # | 原文（位置 + 说法） | 证据 | 应改为 |
|---|---|---|---|
| 1 | §3.3 「`SSVideoView` 的 **17 条** ijk 播放参数（键=值全部列出）见同附录 §3」 | `SSVideoView.java` 内 `setOption` 调用点**只有 15 处**（`:592,593,594,595,596,597,598,599,600,601,604,606,611,612,613`；其中 `:604` 与 `:606` 互斥），已逐条核对本附录 §C.5.1 | 改「15 个 `setOption` 调用点 = 14 条无条件 + 1 条二选一分支」；真正的**在用**播放层参数是 `_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java:619-646` 的 21+2 条（§C.5.4） |
| 2 | §2.2 表 `SSFileInfoBean` 行的行号 `:84,122,157,163` | SigmaStar 分支实际在 `:82`（thumb）、`:114`（remote）、`:154`（play）；`:84`、`:122`、`:157` 是 **AMBA 分支**；`:163` 是 `getCreateTime()` 与平台无关 | 行号改为 `:82 / :114 / :154`（并保留 AMBA 的 `:84 / :122 / :157`） |
| 3 | §3.4 标题「海思 App 侧回拨 ServerSocket 5678」+ 表内「触发：App 起 `MessageService`（前台通知 id `10121`）后无条件 accept」 | 全树唯一的 `startService(...)` 在 `OldUi/playback/model/service/DownloadIntentService.java:87`；`MessageService.class` / `KeepAliveService.class` **零引用**（仅清单注册，`_work/re/xtugo/components.tsv:194-195`）。真正在听 5678 的是 `HisiSocketServer`，且由 **SigmaStar 与海思共用的预览页** 无条件启动（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:307-312`，该页选择逻辑 `:265-266`） | 标题改「App 侧回拨 ServerSocket 5678（`HisiSocketServer`，海思与 SigmaStar 共用）」；`MessageService`/`KeepAliveService` 标注为「清单幽灵：代码不启动」，与 §10 #8 的 `SSMessageService` 同类处理 |
| 4 | §3.3 「上行 72 字节定长头：`[0..3] int32 LE cmd` + `[4..7] int32 LE 数据长度/路径长度` + `[8..71] **64 字节 UTF-8 路径**」 | `RegisterDeviceToServer.StringtoLH()` 是 `str.getBytes()`（**不带字符集参数**，`:48-50`），`[4..7]` 写的是 `String.length()`（**字符数**，见 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:65`、`DownLoadFileUtils.java:75`）；只有 `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:114-115` 才 `getBytes("UTF-8")` 且写**字节数** | 改为「路径槽 = `str.getBytes()`（平台默认字符集，Android 上即 UTF-8）；`[4..7]` 在老实现里是字符数、在新实现里是 UTF-8 字节数（ASCII 路径下等价）」 |
| 5 | §3.3 「老写法是 `com.hisi.hisiFW.RegisterDeviceToServer(int,int,String)` 的 `toLH()` 手摆，`_work/xtu_src/sources/com/hisi/hisiFW/RegisterDeviceToServer.java:12-23,40-46`」 | SigmaStar/海思预览与下载链路用的是**同名不同包**的 `com.gku.actioncam.hisilicon.dv.ui.data.model.RegisterDeviceToServer`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:13` 的 import、`DownLoadFileUtils.java:9`、`FirmwareClientThread.java:9`）；`com.hisi.hisiFW` 那份只服务 `FwUpload`（8080 上传，`_work/re/xtugo/catalog-ports.md:289`） | 补一句「有两份同名 `RegisterDeviceToServer`，字段布局相同但只有 `hisiFW` 版被 `FwUpload` 用；SigmaStar 用的是 `dv.ui.data.model` 版」 |
| 6 | §2.2 表末 `SSVideoView` RTSP 传输选择行（`…/widget/SSVideoView.java:603-607`，「非 AMBA → `rtsp_flags=prefer_tcp`」） | 代码无误，但 `SSVideoView` 在本包内**不可达**：唯一引用是 `activity_s_s_video_remote_play.xml`（`_work/re/xtugo/layouts.tsv:93`）与其 Binding（`_work/xtu_src/sources/com/gku/xtugo/databinding/ActivitySSVideoRemotePlayBinding.java:35`），无任何 Activity 使用；SigmaStar 真机预览走 `VideoTextureView` → `rtsp_transport=tcp` + `framedrop=5`（`_work/xtu_src/sources/com/gku/actioncam/widget/VideoTextureView.java:639-641`，`isAmba=false` 来自 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/OldUi/preview/ui/activity/HisiActionCameraPreviewActivity.java:817-838`） | 该行加「（仅存在于死代码）」，并把「SigmaStar 预览实际用 `rtsp_transport=tcp`」写进正文 |
| 7 | §2.5 RTSP 行「`:554/livestream/12`（小码流）/`11`（大码流）｜`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:50`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:50`、`…/dv/biz/DV.java:320-330`、`…/AmbaPreviewActivity.java:972`」 | `_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:50` 与 `_work/xtu_src/sources/com/gku/actioncam/sigmastar/HaisiCommandUtil.java:50` 是**字面量 `/livestream/12`**，无 `/11` 分支；`/11` 只在 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:319-329`（RTSP）与 `_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/biz/DV.java:331-342`（HTTP）；`_work/xtu_src/sources/com/gku/actioncam/amba/ui/preview/AmbaPreviewActivity.java:972` 也只有 `/12` | 把「/11」的来源限定为 `DV.isPreviewBigBitRate()` 一处，并注明 SigmaStar/Ambarella 路径**永远只有 /12** |
| 8 | §11 「相机默认地址常量」行：「SigmaStar/海思代码路径**硬编码** `192.168.0.1` 而非读 `baseIp`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:57`、`_work/xtu_src/sources/com/gku/actioncam/hisilicon/dv/ui/data/connect/ConnectDevice.java:44`、`DownLoadFileUtils.java:31-32`、`FirmwareClientThread.java:64`、`HisiCameraAbout` 等）」 | 精确化：**SigmaStar 的 CGI 面不硬编码** —— `DeviceHttpUtils.get()` 用 `NetworkDeviceUtils.getIpDevice()` 拼绝对 URL（`_work/xtu_src/sources/com/gku/base/device/DeviceHttpUtils.java:14-15`）；硬编码只出现在 8080（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/SSConnectDevice.java:57`、`DownLoadFileUtils.java:34-35`、`FirmwareClientThread.java:64`）与 RTSP/缩略图/下载 URL（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSCommandUtil.java:50`、`_work/xtu_src/sources/com/gku/actioncam/sigmastar/bean/SSFileInfoBean.java:83,115,155,158,160` 用 `SSConstant.SS_IP`）。另 `SSConstant.SS_IP` **不是 final**（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/SSConstant.java:13`）→ 存在被改写的可能 | 拆成「CGI 用探测 IP / RTSP+缩略图+下载+8080 用硬编码 `SSConstant.SS_IP`」两条，并注明 `SS_IP` 非 final |
| 9 | §3.3 「端序坑：`DownLoadFileUtils.bytesToInt()` 是小端读法…但老代码对负数长度做了 `((i>>>1)<<1)\|1` 的怪异修正（`:183-192`）」 | 代码形状是 `if (i<0) { j = ((long)(i>>>1))<<1; if (i%2!=0) j++; }`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/connect/DownLoadFileUtils.java:184-191`；海思版 `:326-336`），**结果仍是负数**（等价于把最低位清零），>2 GiB 时拿不到正确的无符号长度；新实现 `_work/xtu_src/sources/com/gku/module_camera/hisi/SocketHisiFile.java:131` 用 `getInt() & 4294967295L` 才正确 | 把「怪异修正」写成明确结论：「该修正不解决符号问题，是 bug；复现按 uint32 LE 读」 |
| 10 | §3.1 表最后一行「`SSResponseParse.parseMessageToMap/2`：sigmastar 侧的同款解析，另带 `cur` 的空位补齐技巧（`…/SSResponseParse.java:532-560`）」 | 补齐逻辑不在 `parseMessageToMap*`（那两者只是切 `var` 对），而在 `parseGetPrimaryMenuItem`（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/data/SSResponseParse.java:389-395`（Response 重载，不补差额）与 `:428-441`（String 重载，补 `",- "` 差额）） | 行号改为 `:389-395` + `:428-441`，并明确「两个重载行为不同：`Response` 版段数不等即整表 null，`String` 版会补齐」 |
| 11 | 主文档未提及（补充） | ① SigmaStar 与海思的差异不止 CGI 名：HTTP 客户端也不同（`DeviceHttpUtils`/xUtils vs `HttpRequestUtils`/OkHttpUtils）；② `SSDownloadUtil` 用 **2 GiB** 做 HTTP/8080 分流（`_work/xtu_src/sources/com/gku/actioncam/sigmastar/util/SSDownloadUtil.java:85`，阈值常量 `IjkMediaMeta.AV_CH_WIDE_LEFT=2147483648L`）；③ 8080 下载**无 Range、无 offset**，是 append 续写；④ 预览轮询 500 ms 只轮 `getcurrotation.cgi`；⑤ SSC8838 有 EIS/LDC/P120 互斥裁剪 | 建议把 ①②③④⑤ 分别并入主文档 §3.1 / §3.3 / §4.1 |
