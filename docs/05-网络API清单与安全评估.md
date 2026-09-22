# 网络 API 清单与安全评估

> 对象：`TUWIN 1.6.4`、`XTU GO 8.4.3`、`idGoLive 1.3.6` 三个官方 App 的反编译产物 + 真实固件镜像。
> 结论标 `path:line`；CONFIRMED = 读到代码，INFERRED = 推断，**UNVERIFIED = 需联网或真机才能确认，本次刻意未测**。

## 0. 我的方法边界（先说清楚）

**做了**：静态读代码/读资源/读 `.so` 字符串；对**我们自己的桌面模拟器**做本地探测验证攻击面形态；对厂商公开固件索引做只读 GET（这些接口本就无鉴权、面向终端用户，且我们已有真实镜像在手）。

**没做，也不建议做**：对厂商线上服务的任何实际利用、越权写入、批量枚举、压测；对他人相机或他人所在子网的探测；任何攻击脚本。凡"要打通才能确认"的一律标 UNVERIFIED 并说明怎么在**自己的设备**上安全验证。

**为什么这条线重要**：本文一半的发现属于"厂商自己的安全缺陷"。它们的价值在于**指导我们的实现不要重犯**，以及**告诉你复用哪个接口会踩到什么**，不在于拿去打别人系统。看到 `api.dashcamplayer.net` 能白拿 OSS 写凭据，正确反应是"我们绝不调它"，不是"试试能塞多少"。

**提取层自身的坑（本轮全量复现档案新增，读下面所有表格都要带着它）**：域名/host 类线索文件**只能当线索，不能当清单**。`_work/re/tuwin/signals-hosts.tsv` 的 1,088 行里 **约 95% 是正则误报**——`.kt` 源文件名、全限定类名（`com.tuwinsmart.tuwin.core.device.DeviceSessionManager`）、系统属性与资源键（`ro.product.model`、`line.separator`）都被当成了主机名（复核式：`cut -f4 signals-hosts.tsv | sort -u` 后按点分尾缀过滤，实测 1,088 行中 1,021 行落在 `.kt`/`.java`/`com.tuwinsmart` 三类）。`_work/re/xtugo/signals-hosts.tsv` 的 501 条更极端：**一个公网域名都没有**（`grep -iE "gkuvision|amap|aliyuncs|bugly|douyin|volc"` 只命中 1 行，而且是 `BroadcastDouyinFragment2.java` 这个文件名），它实际是"点号分隔标识符"桶。⇒ 本文证据列凡写 `host 扫描` 的一律视为**弱证据**（§2.1 第 27–28 行已按此改判）；XTU 侧的域名判定改从 `own-literals.tsv` + 库源码 `"http…"` 字面量 + `natives-strings.tsv` 三处重建。

**还有一条判定纪律**：一个域名出现在 APK 里 ≠ 这个 App 会访问它。本轮对三家逐个给了三档结论——**运行时真访问 / 库自带但未触发 / 死字符串**——下面每个云端域名都带档，不带档的旧写法（"Umeng 全家桶"这种一句带过）已逐条改掉。

---

## 1. 结论先行

1. **真正属于我们、可以放手复用的接口，只有相机本地那一套 HTTP/TCP。** 云端的三家 API 里，只有两个是"公开、无鉴权、面向终端用户、且我们确实需要"的：**XTU 的固件索引**和 **idGoLive 的固件清单**。其余云端接口要么需要账号、要么需要冒充官方 App 身份、要么会往厂商基础设施里写垃圾数据。
2. **三家云端接口的传输安全都不合格**，但程度不同：TUWIN **整条 OTA 控制面是明文 HTTP**（`http://ali.tuwinsmart.com/`）；XTU 索引是 HTTPS 但**返回的固件下载地址是 `http://`**（同一对象其实支持 HTTPS，我实测两者都 200 —— 纯配置错误），此外它还有 **3 个**公网明文口在真发（`121.40.107.215:8041`、`www.gkuvision.com:8882`、`api.dashcamplayer.net`；原列的第 4 条 `api.shhc-yh.com` 本轮判为**零消费者死常量**，不算明文面）；idGoLive **固件清单是 HTTPS（这三家里最好的一点）**，但上一版据以批评它的两条明文"自家账号/客服接口"（`http://usa.boi.tinyai.top:3006`、`http://api.idstore.idalbum.com`）**经逐个判定都没有调用点**（前者是白标 TinyAI 库自带常量、后者是 `RequestInfo` 死常量）⇒ 它的实际明文面比上一版写的小；但**没有一家可以按"它用了 HTTPS"来判断可信**，因为前两家是真在发。
3. **没有任何一家对我们关心的通道做证书固定（certificate pinning）**，三家都全局 `cleartextTrafficPermitted=true`。⇒ 只要走明文，链路上任何人都能替换固件。**本轮补强**：XTU 的 `res/xml/network_security_config.xml` 全文只有 4 行、`<domain>` 0 条、`<pin>` 0 条、未声明 `<trust-anchors>`，旁边还躺着一份**清单没引用**的 `network_config_base.xml`（多一段 `debug-overrides` + `certificates src="user"`）——厂商写过可抓包的 debug 版本但最终没接上；全 APK 唯一成体系的固定材料是 3 个华为 BKS 容器（`grs_sp.bks`/`hmsincas.bks`/`hmsrootcas.bks`），属 ML Kit，与相机协议无关。⇒ 相机侧与厂商自己的全部公网后端**天然可中间人**；也正因 release 包不放行用户 CA，本轮全部判定只能靠静态，没有抓包佐证。
4. **相机本地控制面零鉴权，而且破坏性动作用 GET 触发、不绑定 Host。** 我在自己的模拟器上实测：`reset.cgi` / `deleteallfiles.cgi` / `sdcommand.cgi?-format` 对任意 `Host:`/`Origin:`/`Referer:` 一律 200，无 `WWW-Authenticate`。这是 DNS 重绑定"路过格卡/刷机"的完整前提。真机是否如此 **UNVERIFIED**。
5. **最有复用价值的信息不是 API，是固件镜像本身**：XTU 的 `.bin` 有 256 字节自描述头（型号串 + 版本串 + 文件长度），iCatch 的 `.BRN` 是 `SUNP BURN FILE` 容器且内嵌带 A/B 双槽与 SD 卡恢复的 bootcode。**读头部就能防错刷，三家 App 都没读。**
6. **我们自己的 App 在这一项上已经比三家好**（无凭据落盘、文件名消毒、无日志泄密），原列 4 处要改的**已闭环 2 处**（App 自更新模块连同它的 FileProvider 路径与未校验下载整块被删），剩下 2 处见 §5。
7. **idGoLive 的审计把一个方法论问题摆到台面上**：反编译包里看到的域名 ≠ 这个 App 的 API。它包里的 `169.254.169.254` 来自 Google API Client 库、几十个 OAuth 域名来自 scribejava 的 **179 个 provider 类**、MQTT 只被借用了 `"/"` 常量（活证据：`_work/idgo_live_src/sources/com/icatch/golive/entity/FirmwareInfo.java:58` 用 `MqttTopic.TOPIC_LEVEL_SEPARATOR` 切 URL）——**全是死重量**（详见 §2.3 末尾）。**本轮把这条纪律反过来量了三家**：TUWIN 侧 43 个判定单元里**运行时真访问只有 15 个**（厂商自有 6 + 服务器内容驱动的条件面 2 + 友盟 7），其余 28 个是库自带未触发或死字符串；idGoLive 侧真在用的第一方域名收敛到 **6 个**，连账号层和推送层都算死重量。⇒ 上一版"真正的第一方接口只有十几个、其中明文两条"要改写为：**能用的公开接口更少，且明文那两条根本不发请求**（见 §1 第 2 条与 H-8）；可利用的路径穿越一条（C-3）不变。

---

## 2. 云端 API 清单

### 2.1 XTU GO（`server4.gkuvision.com` 为主，共 4 代接口并存）

| # | 端点 | 方法/参数 | 鉴权 | 用途 | 判定 | 证据 |
|---|---|---|---|---|---|---|
| 1 | **https** `server4.gkuvision.com/v1/push/api/getNewestVersion` | GET `firm_ware_model`,`region`,`hardware_version`（CSV 列表） | 无（登录前发空 `Bearer `） | 当前代固件索引，响应含 `file_url`/**`size`**/`force`/`release_notes[]` | **真访问**（基址在 `BaseApplication` 的 Retrofit 初始化链上） | `loginmodule/api/ApiService.java:45-46`、`manage/DeviceVersionManager.java:287`；基址 `module_base_xtugo/BuildConfig.java:8`→`api/ApiUtils.java:12`→`network/NetworkApi.java:44`，init 在 `com/gku/BaseApplication.java:53` |
| 2 | https `/push/api/getNewestVersion?firmWareModel=` | GET | 无 | 二代固件索引 `{retCode,data:{updates,url}}` | **真访问**（由 `…/firm/Ui/*` 页面驱动） | `sigmastar/upgrade/firm/Presenter/UpgradePresenter.java:165` |
| 3 | https 同上，`firmWareModel=XTUGO_Android` | GET | 无 | **App 自更新** | **真访问**：`:634` `INSTALL_PACKAGE` / `:639` `ACTION_VIEW` 紧随其后 | `upgrade/app/UpgradeViewManager.java:648` |
| 4–15 | https `/v1/login`、`/v1/register`、`/v1/vcode`、`/v1/forgot_password`、`/v1/modify_password`、**`/v1/delete`（注销账号）**、`/v1/logout`、`/v1/users/profile`、`/v1/device_models`、`/v1/feedback/qs_type_options`、`/v1/feedback`、`/v1/upload/image` | POST，多为 Bearer | 账号 | 账户体系 | 基址同 #1 = **真访问**；**逐端点调用点本轮未复核 ⇒ 待判**（`v1/delete` 至少声明在活接口上） | `ApiService.java:36-112` |
| 16–18 | https `/api/getLanguages`、`/api/promotions`、`/api/sendCode`、`/api/login`、`/api/regist`、`/api/upload` | POST | Bearer | 老版账户/营销 | **待判**（与 #4–15 同一份声明文件，未逐个查调用点） | `ApiService.java:42-95` |
| 19 | **`@Url` 注入点**：`postGetVerifyCode(@Url …)`、`postRegisterAccount(@Url …)` | POST | Bearer | URL 不绑定 server4 ⇒ 可能把 Bearer 发到外部主机 | **待判**（声明确认；喂什么 URL 未查调用点） | `ApiService.java:73-75,85-87` |
| 20 | **http** `www.gkuvision.com:8882/upload/update.xml` | GET | 无 | 老 App 更新源 | **真访问（条件）**：仅 `com.gku.rxt`（iCatch 记录仪）流程可达 | `rxt/net/AppService.java:22`（常量）、`:101`（消费者） |
| 21 | ~~**http** `api.shhc-yh.com/`~~ | – | – | ~~RXT/记录仪老接口~~ | **死常量（厂商侧）**：`AppService.java:23`/`:24` 声明后**全树零消费者**（`grep -rn API_FW_SERVICE_HOST_IP` 只命中声明行；`:40` 那处命中是 Kotlin `@Metadata` 反射元数据）⇒ **从 API 清单里剔除**，上一版"GET/POST 老接口"是把它当活的写了 | `AppService.java:23-24` |
| 22 | **http** `api.dashcamplayer.net/api/aliyun/uptoken` | POST `{key:"Tag.log",fileType:4,mid}` | **无** | **签发阿里云 OSS 写凭据**（`access_key`/`access_secret`/`security_token`/`endpoint`/`bucket`/`callback_url`/`callback_body` 六项全部被直接采用） | **真访问**：`ossPost` 唯一调用点在 `HomeActivity:843`，回调 `:859` 建 `OSSClient` | `AppService.java:97-105`、`HomeActivity.java:840-866` |
| 23 | **http** `121.40.107.215:8041/firmware/`（+`info.json`） | GET | 无 | 老固件分发，IP 直连 | **真访问（两处，不止一条产品线）**：SigmaStar 与海思各存一份同值常量，`info.json` 的返回串直接进 `parseServerFileList()` | `sigmastar/upgrade/app/UpgradeTaskManager.java:35`、`hisilicon/dv/updateapp/UpgradeManager.java:35`、`info.json` `:843`；调用者 `dv/setting/AboutCameraActivity.java:41`、`dv/updateapp/DownloadActivity.java:89,128,180,184` |
| 24 | https `device.gkuvision.com/static/xtugo_privacy_{cn,en}.html`、`xtugo_useragreement_{cn,en}.html` | GET | 无 | 隐私/用户协议正文 | **真访问**，但**协议页其实有 3 个地址位**：①代码常量 `device.gkuvision.com/static/…`，②asset 注释泄露的**真实线上** `www.gkuvision.com/special/…`（子域与路径都不同），③`assets/xtugo_*.html` 离线兜底，且 `loadUrlAndAssets` 是**网络优先、失败才用本地** | `module_my/ConstantsMy.java:10-17`（4 条 URL 与 4 个同名 asset 成对）、`:19-27`（`loadPrivacy`/`loadUserAgreement`）、`base/webview/WebViewUtils.java:201`；②见 `assets-content.md:1957,2078,2136` |
| 25 | ICMP `8.8.8.8`（`Runtime.exec("ping -c 1 …")`） | – | – | "有没有外网"的唯一探测点 | **真发包**：国内网络常超时 ⇒ 该连通性判定本身不可靠，是我们做"假成功"检测时的反面教材 | `loginmodule/utils/NetworkUtils.java:23` |
| 26 | https `play.google.com/store/apps/details?id=com.gku.yutupro` | – | – | 跳**另一品牌**（YUTU）的 App | **真访问（仅外链）**，与清单 `queries{com.gku.yutupro}` 配套 | `dv/setting/AboutClientActivity.java:164`；`_work/re/xtugo/manifest.md:113-120` |
| 27–28 | https `www.xtucam.com`（**另有一条 `http://` 同路径变体**）、`xtucp.tmall.com`、`shop183741064.m.taobao.com`、`h5.m.jd.com`、`m.weibo.cn`、`mobile.yangkeduo.com`、`z.douyin.com`（内含 `snssdk1128://` 深链）、`facebook.com`、`youtube.com`、`baidu.com`、`www.google.com/` | – | – | 营销/店铺/社媒链接，非 API | **真访问（仅外链，不发 API）**：用户中心列表项点击走 WebView；`UserCenterWebView` 的初始 URL 常量是 `http://www.google.com/`（国内不可达）；`HomeActivity:2077` 用 `https://www.baidu.com` 兜底 | ~~host 扫描~~（旧证据按 §0 的纪律作废）→ 真实调用点 `sigmastar/newUi/userCenter/ui/fragment/UserCenter.java:204,205,206,208,212,219,221,224`、`loginmodule/ui/fragment/UserCenterNewFragment.java:198,199,200,201,203,204`、`dv/ui/UserCenterWebView.java:37` |
| 29 | 明确判**死字符串**的三条：`https://github.com/danikula/AndroidVideoCache/issues/{43,88,134}`、`http://schemas.android.com/apk/res/android`、`http://i2.hdslb.com/bfs/archive/….jpg`；以及内网地址残留 `172.18.1.19` | – | – | 报错文案 / XML 命名空间 / 空占位类里的图床 / 作者调试地址 | **死字符串**，零网络语义（`172.18.1.19` 是源码里留着的**内网调试地址**，属信息泄露但不是端点） | `com/gku/videocache/HttpUrlSource.java:108,111`、`videocache/Pinger.java:54`、`sigmastar/widget/TabLayout/SegmentTabLayout.java:104`、`m/mifan/acase/core/EmptyCase.java:103`、`base/utils/NetWorkInfoUtils.java:83` |

**未找到**：设备注册/归属/共享的云端 REST 接口（共享是在**本地经 BLE** 完成的，`module_camera/bluetooth/BluetoothLive.java:92` 直接下发 `("gkuvision-5G","gku88888")`）；天气 API；云存储/4G 套餐的 API（"商业化"体现为店铺链接 + `/api/promotions`）。**"推送服务"要分两层说**：外网侧只有 Bugly 的崩溃上报（`android.bugly.qq.com/rqd/async`，AppId `0324406337`）和字节 zeus 的 `:push` **插件进程**（不是消息推送），厂商**没有**自建推送通道；本地侧真正"推"的是相机回拨的 **5678 TCP**，`MessageService` 收到后转成 App 内广播（见 §4 的 M-9）。另外 iCatch 记录仪线用**组播 `234.168.168.168`** 做设备发现（判定 **B 条件触发**，需 `CHANGE_WIFI_STATE` + 组播锁；`com/icatchtek/control/core/CoreMulticast.java:15`，标签串 `multicast.test`/`multicast.receive`），这是本地面不是云面。

**第三方 SDK 面**（都不是 XTU 的，也不该由我们调用；**判定档 = 谁在什么条件下会发**）：

| SDK | 端点 | 判定 | 关键证据 |
|---|---|---|---|
| **腾讯 Bugly** | `android.bugly.qq.com/rqd/async` | **真在用**（崩溃/ANR 主通道），AppId **明文** `0324406337` | `com/gku/crashhandle/CrashReportManager.java:14-48`、`xtugo/BuildConfig.java:7`、native `libBugly_Native.so` |
| ~~Umeng~~ | – | **不存在**：全树无友盟 SDK，唯一残留是 Bugly 读自家清单里的渠道号 `UMENG_CHANNEL=product_GooglePlay`（**该 meta-data 真实存在且读成功**，"必然抛异常"是错的） | `AndroidManifest.xml:123`、`CrashReportManager.java:40`（`initCrashReport` 在 `:48`） |
| **字节 zeus / 抖音 OpenLive / APMPlus** | `apmplus.volces.com`（**含明文 http 变体**）、`dispatch-api-online.vemarsdev.com`、`zeus-api.vemarsdev.com` | **条件触发**：只在 `:bytelive`/`:push`/`:downloader` 三个插件进程、且**仅 Ambarella 机型直播页**可达；抖音 AppKey `"780679"` 明文且 `isDebug(true)` | `amba/ui/stream/DouyinStreamController.java:158`、清单 4 组 `ZEUS_PLUGIN_*`（`:648,787,790,1012`） |
| **高德 AMap v10.0.600** | `restsdk.amap.com/v3/iasdkauth`（**一定发**）、`apilocate.amap.com/mobile/binary`、`cgicol.amap.com/collection/collectData`、`adiu.amap.com/ws/device/adius`、native `m5.amap.com`/`mpsapi.amap.com` 瓦片 | **会发请求但因无 key 必然鉴权失败**（清单 19 条 `<application>` 级 meta-data 里**没有** `com.amap.api.v2.apikey`，全树无 `setApiKey`）；`maps.testing.amap.com` 是测试域残留 | `dv/localimage/TrackActivity.java:389,497,667`、`_work/re/xtugo/manifest.md:418-428`（漏采 19 条 app 级）、`natives-strings.tsv` |
| **阿里 OSS SDK** | `*.aliyuncs.com` 5 个 region、`location-readonly.aliyuncs.com` | **条件**：endpoint/bucket/AK/SK **APK 内无硬编码**，全部由 #22 运行期下发。⚠️ `com.aliyun.oss.internal.OSSConstants.PROTOCOL_HTTP`（值就是 `"http://"`）被厂商当**字符串别名**到处拼相机 URL（4 处），**互操作时不要误读成 OSS 依赖** | `HomeActivity.java:859`；拼用处 `rxt/net/CheckAppVersionUtils.java:324`、`dv/biz/Setting.java:311`、`dv/net/HttpProxy.java:143,181`、`dv/biz/DV.java:332` |
| **华为 HMS / ML Kit / AGConnect（GRS）** | `grs.dbankcloud.{com,cn,asia,eu}`、`grs.platform.dbankcloud.ru`、`metrics{1,5}.data.hicloud.com:6447` | **条件且必然空返回**（无 `com.huawei.hms.client.appid`，只有 `scanplus` 服务名）；端口 **6447** 是非标 HTTPS | `assets/grs_sdk_server_config.json`、`grs_sdk_global_route_config_mlkit.json`、清单 `:1190` |
| **APM Insight**（`libapminsight{a,b}.so`） | – | **未触发**：厂商代码里**没有任何 `ApmInsight.init`**，只有抖音/zeus 插件被拉起时才可能自举 | `com/apm/insight/**`（Java 侧只有文件自举 `h/b.java:16,20,76,96`） |
| **MSA/OAID**、Google Play Ads ID | 无域名（Binder 跨进程） | **条件**：MSA 仅华硕机型（`ca/da/da/a.java:13,25,45`）；Ads ID 是绑 GMS 服务（`base/utils/AdvertisingIdClient.java:40,43`） | 同左 |
| **通用分享 SDK（微信/QQ）** | 无域名，`ACTION_SEND` 外跳 | 真在用（`queries{com.tencent.mm,com.tencent.qq}`） | `base/utils/ShareUtils.java:17,45,49` |

⇒ **XTU 侧汇总（`§4.6` 口径）**：A 运行时会访问 **29 条**（厂商后端/外链 24 + 本地与 ICMP 5）、B 库条件触发 **10 族约 35 端点**、C 库死字符串 **6**、D 厂商死常量 **3**。真正与相机协议无关的公网访问，全是商店/客服/协议链接。

### 2.2 TUWIN（`com.tuwinsmart.tuwin`）

| # | 端点 | 方法/参数 | 鉴权 | 用途 | 判定 | 证据 |
|---|---|---|---|---|---|---|
| C1 | **http** `ali.tuwinsmart.com/newota` | GET `version`,`boardversion` | **无** | 固件版本 + `fw_url` | **真访问（明文）** | `data/source/remote/api/TuwinSuspendApi.java:23`；base URL 见 `gateway/FeedbackApiEndpoint.java:10`，作为默认参数注入 `gateway/RoutedInternetCloudGateway.java:96` → `:323` `retrofitProvider.create(lease, baseUrl, TuwinSuspendApi…)` |
| C2 | **http** `ali.tuwinsmart.com/banner` | GET | 无 | 首页轮播/提示 | **真访问（明文）**；下发的 `link` 必须过 `bannerPagePolicy.authorize` | `TuwinSuspendApi.java:20`；`RoutedInternetCloudGateway.java:564` |
| C3 | **http** `ali.tuwinsmart.com/appupdatecheker` | GET `version`,`platform` | 无 | App 自更新（返回 URL + MD5）。⚠️ 官方端点拼写**少一个 `c`** | **真访问（明文）** | `TuwinSuspendApi.java:17`、`gateway/RoutedAppUpdateGateway.java:26` |
| C4 | **http** `ali.tuwinsmart.com/feedback` | **POST** JSON | 无 | 反馈上传（含设备日志） | **真访问（明文）** | `gateway/FeedbackApi.java:16-17`；链路 `RoutedLegacyFeedbackGateway.java:85`→`:186`，入口 `mine/FeedbackActivity.java` |
| C5 | `fw_url` 指向的任意主机/任意 scheme | GET | 无 | 固件下载 | **真访问（条件，服务器内容驱动）** | `core/util/UpgradeHelper.java:531-533`（只 `HttpUrl.parse`，**不查白名单**） |
| C6 | `appdownload.tuwinsmart.com` | GET | 无 | 二进制分发（在白名单内） | **真访问（条件）**：客户端从不自行拼接该 host，只有 banner 内容驱动它 | `core/internet/ExternalUrlPolicy.java:23`（6 host 白名单成员）、`ExternalWebCompatibilityPolicy.java:47`；消费点 `internet/ExternalWebActivity.java:119-123`→`:371` |
| – | `tuwinwifihelp.tuwinsmart.com/#/`、`ride5helpnew.tuwinsmart.com/#/` | **http://** 硬编码 | 无 | 帮助 Vue SPA | **真访问（明文，用户点击）** | `home/HomeTipsWebsiteCachePolicy.java:17`（`TIPS_URL`）→ `device/detail/DeviceDetailActivity.java:884` 交 `ExternalWebActivity.launch`；`mine/fragment/MineFragment.java:150` |
| – | **同一 host 上的 10 条预热字面量**：`tuwinwifihelp…/#/pages/detail/detail`、`…/assets/`（`ASSET_BASE_URL`）、加 8 条带 hash 的 `.css`/`.js` 文件名 | – | – | 曾是"帮助站资源预下载"清单 | **死字符串（预热功能整体已死）**：唯一消费方 `HomeTipsWebsiteCacheCoordinator.cacheIfNeeded`（`:35-69`）**在全 APK 内零构造零调用**，`CACHE_MARK_KEY` 无任何读写点，配套预加载库 `ren.yale` CacheWebView 零引用；文件名里的 hash 还停在旧版本 | `home/HomeTipsWebsiteCachePolicy.java:13,28` |
| – | **`https://yomu.atlasmeta.one/<locale>/privacy.html`** | GET | 无 | **TUWIN 的隐私政策正文托管在第三方域名上**（6 个语言目录分支） | **真访问** | `home/PrivacyPolicySource.java:16,33` → `HomePrivacyPolicyContentLoader.java:235` → `RoutedInternetTextFetcher.java:88`（`ExternalUrlPolicy authorize`）→ `:91` OkHttp GET |
| – | `tuwin.tmall.com`、`work.weixin.qq.com/kfid/kfc…` | – | – | 店铺/企业客服 | **真访问（用户点击）**：tmall 那条是三级回退 `tbopen://` → `tmall://page.tm/shop?shopId=255736524` → ACTION_VIEW | `connect/fragment/ConnectFragment.java:360`（含 `:355`/`:358` 两级）、`:318` |
| – | 白名单里的**条件外链项**：`intelligentassistant.tuwinsmart.com`（自家"智能助理"页，port 80 + path `/` 整体匹配）、`v.douyin.com`、`xhslink.com`、`mp.weixin.qq.com`（两篇公众号文章）、`apps.apple.com/app/id6740312738` | – | – | 帮助/客服页的外跳目标 | **真访问（条件，仅白名单判定项）**——客户端自己不请求，用户点链接时才放行外跳；`apps.apple.com` 那条在安卓上永远不会命中 | `core/internet/ExternalWebCompatibilityPolicy.java:24,26-30` + `:201-211`；判定消费在 `internet/ExternalWebActivity.java:139-167,371,450` |
| – | 跨域子资源白名单：裸 IP **`111.179.38.202:1369`**（banner 图床）、`2005.sunwingroup.com.cn:1371`、`cdn.dcloud.net.cn`（只 6 张 `img/shadow-*.png`） | – | – | banner 图与 uni-app 前端资源 | **真访问（条件）**：`isAllowedBannerImage` 过滤 → `authorizeBannerImage` → Glide 下载 | `core/internet/ExternalResourceAllowlist.java:18-30,35,44`、`ExternalWebResourcePolicy.java:14`、`RoutedInternetCloudGateway.java:577`、`core/glide/RoutedInternetImage.java:83` |
| – | 阿里云 OSS（AK/SK 由 `BuildConfig` 注入） | PUT | AK/SK | 反馈日志上云 | **真访问（条件）**：`isOssConfigured()` 为真且**用户在反馈页主动点"上传日志"**才传；**五元组实值缺证**（jadx 未产出 `BuildConfig`）⇒ 仍列 UNVERIFIED，补证手段：baksmali 抽 `com/tuwinsmart/tuwin/BuildConfig`，或真机看日志里有没有 `feedback_log_upload_unavailable reason=local_oss_config_missing` | `gateway/LegacyDirectCloudConfig.java:22-23,103,128-132,149-151,165`；链路 `core/util/wifi/LogHelper.java:293-301` → `gateway/RoutedLegacyDiagnosticUploadGateway.java:195-200,295-301,467` |

**⚠️ 之前"base URL 找不到"的空白已补齐**：就是 `http://ali.tuwinsmart.com/`，作为云网关构造器的**默认参数**注入（`RoutedInternetCloudGateway.java:96`、`NetworkRuntime.java:271`）。⇒ `newota`/`banner`/`appupdatecheker` **全部明文、无鉴权、无签名**。

**第三方：友盟确实在用**（上一版"Umeng 全家桶 + 一堆域名"的笼统写法按 §6.2 逐条拆开了）：

- **接入方式是反射桥**，编译期不依赖友盟：`core/util/UmengSdkBridge.java:19` 存类名串，`:198-212` 用 `Class.forName` 解析、类不存在就静默 `false`；本包里 `com/umeng/commonsdk/UMConfigure.java` 真实存在 ⇒ 反射**必然命中**。AppKey 常量 `UMENG_APP_KEY = "6781b8f38f232a05f1f56ef5"`（`TuwinApplication.java:148`），渠道 `Umeng`（`:149`）。清单里**没有任何友盟 appkey meta-data**（全应用级 meta-data 只有 6 条，全是 androidx/azhon），key 只在运行时经反射注入 ⇒ 静态扫清单是查不到的，这是隐私对照时值得点名的形态。
- **两道闸门**：`TuwinApplication.onCreate:269` 先 `preInit`（同意前，按友盟契约不落网）；`:305 initThirdLibs()` 整体被 `:306 PreferenceHelper.isAgreePrivacy()` 门住，同意后由 `HomeActivity.java:331` 补跑，`:352` 才反射调 `UMConfigure.init(ctx, appKey, channel, 1, null)`（`UmengSdkBridge.java:140`）。init 之后 U-APM 全家桶（崩溃/ANR/内存泄漏/启动/页面）随 `UMCrash.init` 激活。
- **友盟侧 7 个域名真访问**：`errnewlog.umeng.com/api/crashsdk/logcollect`（CN 线路，license `28ef1713347d`；`ControllerCenter.java:110-115`）、`ulogs`/`cnlogs.umeng.com`（会话与 envelope；完整 URL 常量类在未喂给 jadx 的 `classes3.dex`，属已知缺证面）、`ucc.umeng.com/v2/inn/fetch`、`utoken.umeng.com`（zid 设备指纹）、`resolve.umeng.com`（兜底路径，正常网络不命中）、`aspect-upush.umeng.com/occa/v1/event/report`（**弱依据**，受远端开关控制，需抓包定证）。
- **友盟侧 4 个域名是死重**：`errnewlogos`（国际分支，CN 包不命中）、`preulogs`（灰度内测）、`one.umops.com`（DDL 归因，`UMCommonDeepLink` 零调用）、`htls.umeng.com/push_cloud_activation`（本包无推送组件，`PushAgent` 类不存在）。
- **阿里 HTTPDNS 被厂商自己关掉**（"库自带但被 App 阉了"的范例）：`203.107.1.1/181345/d?host=` 的唯一 OSSClient 构造点显式 `setHttpDnsEnable(false)`（`RoutedLegacyDiagnosticUploadGateway.java:298`）。
- **三个友盟 `.so`**：`libucrash`(+`libucrash-core`)/`libumonitor` 由同意后的 init 链驱动；`libumeng-spy.so`（UMID 设备标识，398 KB）导出 3 个 `Java_*`：`Java_com_umeng_umzid_Spy_getNativeTag`/`getNativeLibraryVersion`/`getNativeID`。但 `libumonitor`/`libumeng-spy` 的 `loadLibrary` **在反编译树里查不到**（loader 在未喂 jadx 的 `classes3.dex`）⇒ 服务已注册（`UMonitorService`，`process=:u_heap`）但加载点缺证。
- 清单残留：友盟 OAID 需求往清单塞了 `com.google.android.gms.permission.AD_ID` 与 `freemme.permission.msa`（`_work/re/tuwin/manifest.md:68-69`），OAID SDK 以 `org.repackage.*` 打进 analytics。
- **全 APK 只有一套统计+崩溃上报**（= 友盟 U-App + U-APM/com.efs）：**没有** Bugly、Sentry、Firebase、Countly、GrowingIO，厂商自建埋点也是零（厂商代码对 `MobclickAgent` 零命中）。厂商自己的"上报"只有两件：崩溃**先写本地文件**（`AppCrashHandler`，全程零网络）与 §2.2 C4/OSS 两条上云通道（属功能不是统计）。

### 2.3 idGoLive（`com.id221.golive`）

> 这一家的网络面比前两家小得多，**但包体里的 90% 主机名是库自带的，不是它的 API**。先划清这一点，否则清单会误导。本轮逐个判定后收敛为一句话：**真在用的第一方域名只有 6 个**（固件清单、地区开关、法律文本两域、`www.baidu.com` 探测、YouTube 推流），账号层与推送层**整体算死重量**。判定档沿用 §0：**真在用 / 声明未用 / 死重量**。

**账号/推送层（第三方白标 SDK `com.icatchtek.baseutil` + `com.tinyai.*`，不是 id221 自己的服务）**

| 端点 | 用途 | 判定 | 安全形态与依据 |
|---|---|---|---|
| `https://api.bpsc.tinyai.top:3026` | 账号服务器（CN 区，`ACCOUNT_SERVER_BASE_URL_CN`） | **死重量**：App 自有包 `com/icatch/**` 零引用；唯一读它的是白标库内部 `com/icatchtek/baseutil/download/DownLoadUtils.java:27`（`baseUrl = AppInfo.ACCOUNT_SERVER_BASE_URL`），而 `DownLoadUtils` 自身**全树零调用点** | HTTPS；但 base URL 是**可变的非 final 静态字段**（`AppInfo.java:8`）。⇒ 上一版把它当"在用账号层"是错的 |
| **`http://usa.boi.tinyai.top:3006`** | 账号服务器（USA 区，`ACCOUNT_SERVER_BASE_URL_USA`） | **死重量**（同上，零调用点） | **明文 HTTP + 非标准端口 3006**，但**当前没有代码会去连它** ⇒ 只能记为"库里埋着的降级隐患"，不能当实测明文面（`AppInfo.java:13`） |
| `push.smarthome.icatchtek.com` | icatchtek 自有推送 | **死重量**：`PUSH_SERVER_ADDRESS` 在两份 `AppInfo` 里各出现一次，**零消费者** | 同处硬编码 `ICATCH_PUSH_APP_KEY="XXXXXXX1C5262CC1"` / `SECRET="784DDA534A18B1AE76"`（`AppInfo.java:28-29`）⇒ 凭据泄露成立，但**没有承载它的功能** |
| `ACCOUNT_SERVER_REGION` = `cn-northwest-1` / `ap-northeast-1` / `us-west-1` / `ap-east-1` | AWS 区域路由；同一份 `AppInfo` 里还有 `KVS_WEBRTC_REGION`（`ap-northeast-1`/`ap-east-1`，`:30-32`）⇒ 该 SDK 家族用 **AWS Kinesis Video Streams WebRTC** 做远程图传。**但 idGoLive 这个包里没找到 KVS 客户端类，只有常量** ⇒ 后端存在、本 App 未必启用（INFERRED） | **仅常量**，与上面同属未接入的白标层 | 需要 icatchtek 账号 + 凭据，对我们无价值；另有 `ACCOUNT_SERVER_BASE_URL_INDEX`（0..255，前缀 `URL_`，`:10-12`）这套"换 256 个地址"的机制 |

证据：`_work/idgo_live_src/sources/com/icatchtek/baseutil/info/AppInfo.java:5,8-15,21,28-32,37`（`com/tinyai/libmediacomponent/utils/AppInfo.java` 是同一份的拷贝，两份都在 `classes3.dex`）。

**内容/反馈层（id221 第一方）**

| 端点 | 用途 | 判定 | 备注与证据 |
|---|---|---|---|
| `https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json` | **固件清单**，无参数 | **真在用** | `ui/activity/DownloadFirmwareActivity.java:220` 直接 `new OkHttpClient()` GET；响应顶层键 `firmware_list`，每项取 `product`/`name`/`region`/`version`/`download` 五个字段（`:171-173` 构造 `FirmwareInfo`）。**没有 checksum/size 字段** ⇒ §6 的"必须自己校验"成立 |
| `https://www.id221.com/api/app/firmware/area_check` | 按地区开关固件推送 | **真在用** | `net/ConnectDeviceManager.java:362`；响应 `{code:int, data:{area_support:String}}`，`code==200` 才存（`:376-381` → `SPUtil.saveUserArea()`） |
| `https://api.idalbum.com/album.php/api/getIdCamSoftwareVersionInfo` | **App 自身**版本检查 | **声明未用**：全仓无引用点（App 版本检查实际走 native `FW_UPDATE_CHECK` 事件 + `firmware.json`） | `net/RequestInfo.java:29`。我们不做 App 自更新 ⇒ 本来也不用 |
| `https://api.idalbum.com/album.php/api/addIdCamFeedback` | 提交反馈 | **声明未用**：常量 `urlAddIdCamFeedback` 没被读取；反馈页存在但走别的地址（本轮未追到实际提交 URL ⇒ **待判**，别当既成事实） | `RequestInfo.java:13` |
| **`http://api.idstore.idalbum.com/api/getCustomerServiceInfo`** | 客服/售后信息 | **声明未用**，且是**明文 HTTP**（若被启用即为降级风险）——上一版把它写成"第一方明文接口在用"，这里降级为隐患 | `RequestInfo.java:26` |
| `https://id221.com/`、`https://id221.com/idGoLive/privacyPolicy-en.html`、`https://idcam.idalbum.com.cn/idGoLive/{privacyPolicy,UserAgreement}-{en,zh_CN}.html`、`file:///android_asset/{privacyPolicy,reminder}{-zh_CN,}.html` | 法律文本 | **真在用**：`isShowedGlobalContent` 决定境内（`idcam.idalbum.com.cn`）还是境外（`id221.com`）、`zh` 决定后缀；**每个协议都配了同名 asset 做离线兜底**（与 XTU 同一模式） | `ui/activity/StartPageActivity.java:124-128`、`ui/activity/WebActivity.java:65-67`、`_work/re/idgolive/assets-index.md` |
| **`https://www.baidu.com` + `ping("www.baidu.com")`** | 连上相机热点后判"是否真有外网" | **真在用（ICMP）**：对运动相机热点几乎必然失败 ⇒ 这正是官方"连上了却像没连上"的来源，我们做连接判定时当反面教材 | `utils/WifiNetworkSpecifierUtil.java:43,285,294` |
| **`rtmp://a.rtmp.youtube.com/live2`**、**`rtmp://a.rtmp.youtube.com/live2/3fur-h6bh-as8j-w7wd-d7us`** | 直播推流地址；后者是**写死的示例 stream key**（厂商测试残留，属信息泄露） | **真在用**：推流设置页把整串直接 `setText` 进输入框 | `Presenter/PreviewPresenter.java:1952` |
| YouTube Data API v3 全套（`https://www.googleapis.com/oauth2/v4/token`、`/youtube/v3/liveStreams?part=…` ×3、`/liveBroadcasts` 的 create/get/bind/transition、`youtube.com/{channel/,watch?v=}`） | 整条 YouTube 直播链路（取 token → 建 stream → 建 broadcast → bind → transition → 回 watch/channel 链接） | **真在用，但在 native 层**：端点全在 `lib/arm64-v8a/libpanorama_vr.so` 的 `.rodata`，Java 侧只调 `JStreamPublish`/`ICatchStreamPublish`。**只看 Java 常量会整块漏掉这条链**，这是本轮最大的结构性教训 | `_work/re/idgolive/natives-strings.tsv`（category=url）、`natives-jni.md` 的 `Java_com_icatchtek_pancam_core_jni_JStream*` 105 条 |
| Google OAuth client ID `168811923581-u0njo0me7v4dd2ihb1n1c5hbkk0d1v9d.apps.googleusercontent.com`、`982555336638-vis3bioouhq71m4logk3qo525dpt3b37.apps.googleusercontent.com` | 两个 Google 客户端标识（一个给直播、一个给旧版登录） | **真在用**；client ID 本身是**公开标识符不是密钥** | `Function/live/google/GoogleAuthTool.java:13`、`Credentials.java:8`。**但同两处把 `CLIENT_SECRET` 也写死了**（`GoogleAuthTool.java:14` = `6sMzO0akSmW2GOcSyQPGkm4o`、`Credentials.java:9`）⇒ 见 H-5 |
| Facebook / Google Drive 分享与上传（Graph API、Drive/YouTube Data API） | 社交分享 | **部分在用**：Facebook 登录/分享是真的（`LoginFacebookActivity`、清单注册 `CustomTabActivity` + `fbconnect://cct.com.id221.golive`）；**未发现 Firebase/Crashlytics/GA**，遥测主要落在日志文件 | `_work/re/idgolive/manifest.md:161-163`、`com/facebook/appevents/**` |

**设备本地面（这才是我们的互操作面）**：`http://192.168.1.254/?custom=1&cmd=<n>[&par=|&str=]` 共 **59 条硬编码常量、38 个不同 cmd**（`com/icatch/golive/net/RequestInfo.java:8-66`；另有一条 `cmd=` 空模板 `urlQueryStatus` @ `:52`）。几个要点：

- `cmd=3003` 设 SSID、**`cmd=3004&str=` 设 WiFi 口令**、`cmd=3029` 读 SSID ⇒ **明文 GET 改 AP 凭据，无鉴权**。
- `cmd=3010&par=1` 格卡、`cmd=4003&str=` 删单文件、**`cmd=4004` 删全部**、`cmd=3011` 恢复出厂、`cmd=3018` 重连 WiFi。
- `cmd=3031&str=all` = 菜单项自描述、`cmd=3021` = 保存菜单设置（与 XTU 的 `getprimarymenuitem` 同一思路）；`cmd=8888`/`3016` 心跳；`cmd=3012` 读版本；`cmd=3017` 剩余容量、`3024` 卡状态、`8013` 电量。
- 另有 **`http://192.168.169.1` / `:80`** 一组（M3 系相机形态，走 `/app/*`），说明这个包同时接行车记录仪（1.254）和运动相机（1.169.1）两类设备。
- **⚠️ 上一版"靠哪个 IP 应答 ping 就选哪个 handler"只对了一半**：ping 只区分 `.254` / `.169.1`；**`192.168.1.1` 那台 PTP 机不参与 ping 探测**，由 `MyCamera.connect(true)` 的成败决定，且 connect 成功后不再走 ping。⇒ 完整选择逻辑是四层：PTP 会话成败 → ICMP 应答者 → `getSSID` 成败 → 相机名黑名单。另有两条实现坑：① 两路 ping **共享同一个失败计数器** `failure_connect_count`（`net/ConnectDeviceManager.java:28,34-35`），`== 2` 就整体判 404（`:58`、`:72`），一路失败会把另一路一起拖死；② **`.254` 上其实并存两套 API**（`?custom=1&cmd=` XML 与 `/app/` JSON），后者由 `LyWyzRequestInfo`+`LyCmdWithYzIC` 实现但 **`try2connectLywyzIC` 零调用点 ⇒ 死代码**，所以官方只会选中 Novatek 那套。
- **HTTP 通道零鉴权已复核**：`net/ApiCaller.java:95-137` 无任何 `Authorization`/Cookie/签名头，**且**它把 client 绑到 `WifiNetwork.getSocketFactory()`（两个分支都绑）⇒ 请求只可能从已连上的相机 AP 出网，这条绑定是我们复现时的正确做法（顺带解释了为什么它扫不到外网）。
- 发现机制只有三种：**UDP 组播 `234.168.168.168:5002` + ping + 手输 IP**，**没有 mDNS/SSDP**（`libcontrol.so` 内零 mDNS 串，唯一 6 条 `mdnsDiscovery` 全落在 ffmpeg 家族）。

**⚠️ 四个"看起来像 API 其实不是"的坑**（上一版本文在这里留白，容易被误读成攻击面）：

1. **`http://169.254.169.254`（云元数据地址）不是 idGoLive 的代码**，是打包进来的 **Google API Client 库**自带的 `DEFAULT_METADATA_SERVER_URL`（`com/google/api/client/googleapis/auth/oauth2/OAuth2Utils.java:19`，唯一读它的 `getMetadataServerUrl()` 只在同库里）。配套的 `ComputeCredential`/`DefaultCredentialProvider`/`MockMetadataServerTransport` 是库代码 + 测试代码。手机上既不在 GCE 也不在 Lambda 里，`169.254.169.254` 拿不到任何凭据 ⇒ **降级为 Low，只是包体卫生问题**。
2. **一大串 OAuth 供应商域名**（Facebook/Google/Instagram/VK/Yandex/WeChat/… 几十个）是打包进来的 **scribejava 提供方目录**：`com/github/scribejava/apis/*Api.java` 共 **179 个类**，绝大多数从没被引用。真正用的只有 idGoLive 自己那 3 个。
3. `org.eclipse.paho.*`（MQTT 客户端）也在包里，但业务代码只借用了 `MqttTopic.TOPIC_LEVEL_SEPARATOR` 这个 **`"/"` 常量**（见 §4 的 C-3 与 M-10 两处路径拼接）——没有任何 broker 地址，**MQTT 是死重量**。
4. **`http://demo.xarx.rocks/` 是死重量**（本轮新增）：它是 `Credentials.FACEBOOK_REDIRECT_URI`，出自被 vendor 进来的桌面时代 Xarxlib，`FACEBOOK_APP_ID`/`APP_SECRET`/`REDIRECT_URI` 三个常量**在整棵 idGoLive 源码树里零消费者**（`grep "Credentials\."` 只命中 okhttp3 与 facebook cloudbridge 的同名无关类）。Facebook 真正走的清单注册的 `fbconnect://cct.com.id221.golive` 自定义 tab 回调。`GOOGLE_REDIRECT_URI = "http://localhost:8080"` 同属桌面遗留——手机上无法监听 8080，Google 登录实际依赖 `AuthActivity` 弹窗。⇒ **H-7 据此从"授权码回落到攻击者地址"降级为"密钥入库 + 死常量"**。

⇒ **方法论收获**：反编译包里的字符串≠API 清单。下一步若再扩大清点，必须先按"是否被第一方类引用**且有真实调用点**"过滤，否则清单里 9 成是库。本轮三家都吃了这个亏：idGoLive 把白标库的账号/推送常量当自家接口、TUWIN 把 `one.umops.com`/`aspect-upush`/`ren.yale` 预热清单当遥测面、XTU 直接引用了一份**不含任何公网域名**的 `signals-hosts.tsv`。另一条对称教训：**只看 Java 会漏掉 native 层**（idGoLive 的整条 YouTube 直播链在 `libpanorama_vr.so` 的 `.rodata` 里）。

---

## 3. 相机本地控制面 —— 这才是我们的互操作面

三家全部**零鉴权**，凭据走 URL query。完整命令表见 [03-品牌型号与协议矩阵](03-品牌型号与协议矩阵.md)，此处只列安全相关的形态：

| 能力 | TUWIN | XTU | idGoLive |
|---|---|---|---|
| 读设备属性/序列号 | `getdeviceattr.cgi`、`/api/device/info`、`/app/getproductinfo` | `getdeviceattr.cgi` | `/app/getdeviceattr`、`?custom=1&cmd=3012` |
| **读 AP 密码** | `getwifi.cgi` | `setwifista.cgi` 族 | `/app/getdeviceattr` |
| **改 AP SSID+密码** | `setwifi.cgi?-wifissid=&-wifikey=`、`/app/setwifi?wifissid=&wifipwd=` | `setwifista.cgi?` | `/app/setwifi`、**`?custom=1&cmd=3003&str=` / `cmd=3004&str=`**（明文 GET 改口令，无鉴权） |
| **格式化 SD** | `sdcommand.cgi?&-format`、`/app/sdformat`、`/api/system/formatsd` | `sdcommand.cgi?-format&-partition=1` | `?custom=1&cmd=3010&par=1`、`/app/sdformat` |
| **删除媒体** | `deletefile.cgi?-name=`、`/app/deletefile?file=` | `deletefile.cgi?-name=<远端路径>`、**`deleteallfiles.cgi`（清空）** | `?custom=1&cmd=4003&str=`、**`cmd=4004`（清空）** |
| 恢复出厂 | `reset.cgi`、`/app/reset` | `reset.cgi` | `?custom=1&cmd=3011` |
| 重启 | `/api/reboot` | – | `?custom=1&cmd=3018` |
| **推固件** | `POST /api/firmware/upload`、`POST /upload/{savepath}/{filesize}` | `fileupload.cgi` + `upgrade.cgi`、8080 帧 | native FTP |
| 端口 | 80 / RTSP 8080 / 推送 TCP | 80 / 7878 / 8787 / 8080 / 5678 | 80 / **3333** / 5002(UDP) / FTP |

**共同形态问题（三家一致）**：破坏性动作是 **GET**、**无鉴权**、**不绑定 Host**、**参数里带明文口令**。⇒ 一旦用户浏览器/WebView 连着相机 AP，一个 `<img>` 就能触发格式化。

**本轮对 TUWIN 补三条本地面事实（都影响"零鉴权"这句话的读法）**：

1. **设备侧确实零鉴权**：Ride3Pro/Ride6 的 `/api/*`（Retrofit 接口 24 个方法，`Ride3ProApiService.java:21-101`）、M3 的 `/app/*`（`M3ApiService.java:46-138`，27 个方法）、Ride5 的 `cgi-bin/hisnet/*.cgi` **没有任何** `Authorization`/Cookie/签名/时间戳头注入逻辑（`01-TUWIN-档案.md 附录一（协议面） §2.6` 第 1 条）。
2. **但 App 侧有一层厂商自己的端点授权**：Ride3Pro 每个请求都过 `DeviceEndpointAuthority.authorizeUrl`（`_work/tuwin_src/sources/com/tuwinsmart/tuwin/core/network/DeviceEndpointAuthority.java:116+`），M3 由 `M3DeviceAdapter.java:905-914` 生成的 `endpointInterceptor` 兜，未授权直接抛 `EndpointNotAuthorizedException`。⇒ 这是**纯客户端自律**，对路过格卡毫无阻挡力，但它是三家唯一值得抄的形态：**我们 App 里对破坏性路径也该有一张"哪些端点允许出现"的白名单**，别把它误读成设备有鉴权。
3. **能力开关在设备侧**：`/api/reboot` 只有当 `/api/device/info` 的 `features` 数组（trim + 小写归一，`Ride3ProProtocolFeatures.java:19-36`）含 `"reboot"` 才允许发。⇒ 上表"重启"一行不是所有 TUWIN 机型都能用。
4. **被声明但没有任何调用方的本地端点，要从"API 清单"里剔除或标注**（否则我们照抄会实现一堆死接口）：M3 `/app/getparamitems` 的 `getAllParamItems`（`M3ApiService.java:54`）、`/app/getparamvalue` 的 `getAllParamValues`/`getParamValue`（`:57`、`:93`）、`downloadFile(@Url)`（`:49-51`，见 M-6）——四处**全仓零调用**；`Ride3Pro /api/setmode` 的 `mode=1` **没有任何字面实参**（只有 `0` 预览、`2` 回放）；`/api/rtspstatus` 见 H-3。注意 `getAllParamItems`/`getAllParamValues` **有**默认参数生成器（`param="all"`，`M3ApiService.java:173-195`），像是"写好但忘了接"，我们要一次性拉全量参数可以照它做，但要清楚官方当前没走这条路。

---

## 4. 安全发现汇总（按严重性）

只列跨厂商有意义的；单厂商细节附证据行号。

### Critical

| ID | 发现 | 厂商 | 证据 |
|---|---|---|---|
| **C-1** | **整条 OTA 控制面走明文 HTTP、无签名**。攻击者可决定手机下载并安装什么。 | TUWIN：`http://ali.tuwinsmart.com/`（`newota`/`banner`/`appupdatecheker`）；XTU：**2 条**公网明文更新口 `http://121.40.107.215:8041/firmware/`、`http://www.gkuvision.com:8882/upload/update.xml`（第三条明文口 `api.dashcamplayer.net` 是日志凭据，归 C-4），且**当前代索引返回的 `file_url` 也是 `http://`**。（原列的第 4 条 `api.shhc-yh.com` 本轮判定为**零消费者死常量**，不算明文面，见 §2.1 #21） | `TuwinSuspendApi.java:17,20,23` + `FeedbackApiEndpoint.java:10`；`UpgradeTaskManager.java:35`+`hisilicon/dv/updateapp/UpgradeManager.java:35`、`AppService.java:22`+消费者 `:101`；`file_url` 协议为**我实测确认** |
| **C-2** | **`fw_url` 不查下载白名单** ⇒ 云端响应（可被 MITM 改写）能指定任意主机/scheme 让手机去下载固件 | TUWIN | `UpgradeHelper.java:373,521,528-533`；`ExternalUrlPolicy` 的引用点里**没有** `UpgradeHelper`/`DownloadUtil` |
| **C-3** | **服务端可控的路径组件未消毒 → 目录穿越/任意写** | TUWIN：`expectedFileName = fw_url.substringAfterLast('/')` 无 `..` 过滤，且 M3 的 `POST /upload/{savepath}/{filesize}` 用 **`@Path(encoded=true)`** 关掉转义，`../` 能一路活到设备；XTU：`getPathDir()` 把云端 JSON 的 `region`/`pcbrevision` 直接拼进保存路径；**idGoLive：`onDownload()` 把云端 URL 按 `/` 切开后，用 `[len-2]` 那一段当目录名**（`getExternalCacheDir()+"/Firmware/"+段+"/"`），既不过滤 `..` 也不做 canonicalize，文件名同样来自服务端 | `M3ApiService.java:134-135`、`UpgradeHelper.java:377`；`DeviceVersionManager.java:644-669`；**`DownloadFirmwareActivity.java:322-334`**、**`LYDownloadFileActivity.java:165-171`**（相机 JSON 的 `name`+`furl` 直接决定落盘文件名与下载地址） |
| **C-4** | **无鉴权地签发云存储写凭据，且经明文 HTTP 交付、六项字段全部照单采用**（含 `callback_url`，等于让阿里云替攻击者发请求） | XTU | `rxt/net/AppService.java:97-105`、`HomeActivity.java:840-866`、`OssPostResult.java:18,107,126` |

### High

| ID | 发现 | 厂商 | 证据 |
|---|---|---|---|
| **H-1** | **相机本地控制面零鉴权**，任何 AP 子内主机可改 WiFi、格卡、删媒体、推固件；默认口令是常量（`12345678` / `gku88888`） | 三家 | TUWIN `Ride5CgiApi.java:22,25,64,73,85`、`M3ApiService.java:47,100,103,127,134`；XTU `HttpProxy.java:143,181`、`Setting.java:313`、`WifiAPUtil.java:20`；idGoLive `RequestInfo.java:15,18,58,59,61`（`cmd=3003` 改 SSID @`:59`、**`cmd=3004&str=` 改 WiFi 口令 @`:58`**、`cmd=3010&par=1` 格卡 @`:18`、`cmd=4004` 删全部 @`:15`、`cmd=3011` 恢复出厂 @`:61`，全是无凭据明文 GET。**上一版引的 `:33-35` 是版本号/心跳三条，行号错，已按文件实况改**）；App 侧请求无 `Authorization` = CONFIRMED，设备侧是否强制校验 = **UNVERIFIED** |
| **H-2** | **下载的 APK 无安装前完整性校验**；MD5 与 URL 来自同一份明文响应 ⇒ 校验值本身可被攻击者提供 | TUWIN（`com.azhon.appupdate` 完成路径不调 `checkApkMd5`，且 MD5 为空时静默跳过）；XTU（`UpgradeViewManager.java:425-450` 直接 `new File(mSavePath, apkName)`，`apkName` 来自服务端） | `DownloadService.java:80,101-133,368-385`；`UpgradeViewManager.java:425-450` |
| **H-3** | **"认证"是摆设**：TUWIN 的 `seed` 是客户端自选的 `kotlin.random.Random.nextLong(Long.MAX_VALUE)`（非 `SecureRandom`），发给 `/api/authdevice` 后**应用侧从不派生、保存、比对任何凭据**（auth 响应的 `info` 声明为 `Any?` 且不解析，调用点只读 `result`），RTSP URL 里也不含 seed。⚠️ **两条口径修正**：① 「seed 用于让相机授权本次 RTSP 连接」是**推断**不是事实，「挑战值」是拟人化表述——它不参与任何计算、不校验回显，**不构成挑战-应答**；② 常被并列成"第二道鉴权"的 `/api/rtspstatus?seed=` **在官方 App 里没有任何业务调用点**（只被两个 `implements Ride3ProApiService` 的包装类 override 着），实际起流前不发它 ⇒ 从鉴权链里删掉；真实握手是 `authdevice` → `vendor/send-time`（失败仅告警）→ `setmode?mode=0`（失败硬抛）→ 起播 | TUWIN | `Ride3ProStreamRepositoryImpl.java:239,380`、`Ride3ProPlaybackRepositoryImpl.java:1049,1094`、`Ride3ProApiResponse.java:15-19`、`DocumentedRide3ProMediaEndpointResolver.java:31`；`Ride3ProApiService.java:22-23`（authdevice）、`:57-58`+`Ride3ProSessionApiService.java:688,703`+`QueuedRide3ProApiService.java:431,446`（rtspstatus 全为声明/override）；`com/tuwinsmart/**` 内 `SecureRandom` **0 命中** |
| **H-4** | **密钥/口令进日志，日志再被上传出设备**：`Log.d("saveDeviceInfo:"+SSID+":password"+password)`、BLE pin、MAC、完整登录响应；日志包经 C-4 的 OSS 通道上传 | XTU | `HiWifiManager.java:127,154`、`BroadcastDouyinFragment2.java:483,997`、`DV.java:706,709`、`LoginRepository.java:33`、`LogSaveUtils.java:18,67` |
| **H-5** | **硬编码第三方凭据**（本轮把"数量"核准了）：**XTU 共 9 处标识/密钥** = 4 组字节跳动 Zeus `appKey`+`appSecretKey`（清单里明文，另各带一张 2048-bit 插件签名证书）+ **3 枚 Google 地图 key**（**不是上一版说的 2 枚**：清单 `com.google.android.geo.API_KEY` 1 枚，`WelcomeActivity` 又按品牌分支在运行期把 `com.google.android.maps.v2.API_KEY` **塞进自己的 `ApplicationInfo.metaData`**，XTU 分支与 YUTU 分支各一枚）+ 抖音 OpenLive AppKey `"780679"`（且 `isDebug(true)`）+ **Bugly AppId `0324406337`**；TUWIN Umeng `APP_KEY`（**清单里查不到，只经反射注入**，见 §2.2）；**idGoLive icatchtek 推送 `APP_KEY`/`SECRET` + 两组 Google `CLIENT_SECRET` + Facebook `APP_SECRET`** | 三家 | XTU：`RES/AndroidManifest.xml:648,787,790,1012`（4 组 zeus）、`:273-274`（geo key）、`WelcomeActivity.java:96`（XTU 分支）与 `:106`（YUTU 分支）——**上一版漏了 `:96` 那枚，也没认出这是运行期改写 metaData 的形态**、`DouyinStreamController.java:158`、`xtugo/BuildConfig.java:7`；TUWIN：`TuwinApplication.java:148` `APP_KEY="6781b8f38f232a05f1f56ef5"` + `UmengSdkBridge.java:140`；idGoLive：`AppInfo.java:28-29`、`Credentials.java:5-10`（含 `FACEBOOK_APP_SECRET`）、`GoogleAuthTool.java:13-14`。⇒ 三家无一例外把"第三方身份"打进包里；我们自己的实现里这类东西应当**结构上不存在**（见 §5） |
| **H-6** | **OAuth 长期凭据写进日志，日志落在共享存储**：Google **refresh token**、Facebook access token、设备 WiFi 口令、SSID 全被 `AppLog` 打印；落盘路径按 `SDK_INT` 分支——**Android 10+ 写 `getExternalCacheDir()/BpSCam_APP_Log/`（尚可），9 及以下写 `Environment.getExternalStorageDirectory()/BpSCam_APP_Log/`**，那目录任何有存储权限的 App 都能读。refresh token 是可长期换发访问令牌的那一枚，泄露后果比 access token 重 | idGoLive | `GoogleAuthTool.java:25`、`PreviewPresenter.java:2101,2266`、`USBPreviewPresenter.java:1115`、`GraphOperation.java:31`、`BTPairCompletedFragment.java:167`（`password=[…]`）、`MWifiManager.java:42,70`；落盘分支 `Log/AppLog.java:81-85` + `AppInfo.java:21` |
| **H-7** | **OAuth 常量指向第三方域名与明文 localhost——但本轮判定它们是"死重量 + 密钥入库"，不是可落地的授权码劫持**：`FACEBOOK_REDIRECT_URI = "http://demo.xarx.rocks/"`（别人的域名，明文 HTTP）、`GOOGLE_REDIRECT_URI = "http://localhost:8080"`（手机上根本无法监听），两个 URI 都出自 vendor 进来的桌面时代 Xarxlib，**`Credentials.java` 那 6 个常量在全树零消费者**；Facebook 实际回调是清单注册的 `fbconnect://cct.com.id221.golive`，Google 实际走 `AuthActivity` 弹窗。⇒ **上一版"授权码回落到攻击者可控/可截获的地址"这个结论不成立**（没有代码把授权码往那儿送）；仍然成立且要记住的是**配套 app/client secret 直接嵌在 APK 里**（`FACEBOOK_APP_SECRET`、`GOOGLE_CLIENT_SECRET`、`GoogleAuthTool.CLIENT_SECRET`），以及"我们绝不用别人泄露在包里的凭据"这条红线 | idGoLive | `Function/live/google/Credentials.java:5-10`（全文 6 行常量，已逐个查无引用点）、`GoogleAuthTool.java:13-14`、`_work/re/idgolive/manifest.md:161-163` |
| **H-8** | **明文账号/客服地址确实写在代码里，但都是"未接入"的常量——本项从 High 降级为 Low（包体卫生 + 埋着的降级隐患）**：`http://usa.boi.tinyai.top:3006`（USA 区账号服务器）、`http://api.idstore.idalbum.com/api/getCustomerServiceInfo`（客服），本轮逐个查调用点：前者所在的那组 `ACCOUNT_SERVER_*` 常量在 App 自有包 `com/icatch/**` 里**零引用**，唯一读它的 `com/icatchtek/baseutil/download/DownLoadUtils.java:27` 自身也**零调用点**；后者的常量 `urlGetCustomerServiceInfo` 同样没被读取。同处还留着 `ACCOUNT_SERVER_BASE_URL_INDEX`（0..255，前缀 `URL_`）这套"换 256 个地址"的机制，说明这套白标 SDK 的地址本就是可注入的——但**是设计遗留，不是 idGoLive 的在用明文面** | idGoLive | `AppInfo.java:5-16`（`BASE_URL` 非 final @`:8`、`_USA` @`:13`、INDEX 三件套 @`:10-12`）、`RequestInfo.java:26`、`DownLoadUtils.java:27`。**注**：也仍**没有**找到运行期改写 `ACCOUNT_SERVER_BASE_URL` 的调用点 ⇒ "可被第三方 App 改写"不成立（这条原判不变）。真正在发的明文只有 TUWIN 与 XTU 那几条（C-1/C-4） |

### Medium

| ID | 发现 | 厂商 | 证据 |
|---|---|---|---|
| M-1 | **FileProvider 暴露整棵存储树**——⚠️ 本轮把"谁的锅"核准了，两家的 `root-path` 来源不同：**XTU 厂商自己的 `paths_base.xml`（6 条全 `path="."`）里没有 `root-path`**，最宽的是 `<external-path name="external_root" path="."/>` = 整张外置卡 + 两个 app 私目录；**文件系统根 `<root-path>` 出自 LuckPicture 库的 `ps_file_paths.xml`**（authority `com.gku.xtugo.luckProvider`，`external-path` 与 `root-path` 都 `path=""`，比厂商那份更宽）。⇒ 结论"一次 URI 泄漏 = 任意文件读（含存 Bearer 的 SharedPreferences、H-6 那个日志目录）"不变，但**整改责任方不同**：改厂商自己的 paths 就能收窄到外置卡，去掉 `root-path` 得动依赖库。两个 provider 都是 `exported=false` + `grantUriPermissions=true`，外部拿不到 URI 除非本 App 主动授权（分享/安装 APK 时确实会授权） | XTU、**idGoLive** | XTU：`res/xml/paths_base.xml`（6 条，已逐行核）挂 `AndroidManifest.xml:606-614`→`com.gku.base.BaseFileProvider`；`res/xml/ps_file_paths.xml`（2 条含 `root-path`）挂 `:625-633`→`com.luck.picture.lib.basic.PictureFileProvider`；实际分享/安装出口 `ShareUtils.java:17,45,49`、`HiShareFile.java:15,36`、`UpgradeViewManager.java:634,639`。**idGoLive `res/xml/file_provider_path.xml`**（7 条里 6 条是 `path="."`，第 7 条才是 `<root-path name="sdcard1" path="."/>`，另有一条正确收窄的 `external-path DCIM/idGoLive`） |
| M-2 | ~~**Provider 未声明 `android:exported`** ⇒ 默认导出~~ ⇒ **这条判据错了，改判为"不构成暴露面"**：`<provider>` 自 API 17 起默认 `exported=false`，本包 `minSdk=23/targetSdk=35`，因此**未写该属性的 provider 是私有的**，外部 App 解析不到（Android 12+ 若真带 intent-filter 而未声明 exported 会直接装不上，本包能装说明清单自洽）。原引用的 `com.volcengine.zeus.FileProvider` 那份声明确实**没有** `android:exported`（自闭合标签），但同清单里 12 个 zeus/库 provider 都显式写了 `exported="false"` ⇒ 一致按私有处理。**真正导出的组件只有 7 个**：2 个厂商 activity + 4 个抖音 OAuth 回跳页（无权限保护，属 SDK 设计所需）+ 1 个受 `DUMP` 保护的 `ProfileInstallReceiver`，见 M-11 | XTU（原判定作废） | `AndroidManifest.xml:1097-1100`（该 provider 原文）、`_work/re/xtugo/components.tsv` 第 4 列 grep `exported=true` = 7 行（`02-XTUGO-档案.md 附录E（权限·组件·域名） §2.6` E1–E7） |
| M-3 | **桥接 WebView 加载 Intent 传入的 URL**：`loadUrl(getIntent().getStringExtra("url"))` + `addJavascriptInterface(...,"android")`。⚠️ 可达性收窄：`UserCenterWebView` **未声明 exported（=false）**，所以外部 App 不能直接把它拉起来喂 URL；风险落在**同 App 内的跳转链**与 M-4 的混合内容叠加时 | XTU | `UserCenterWebView.java:74-88`；清单侧 `components.tsv` 该 activity 无 `exported=true`（`§2.4`，导出组件全表见 `§2.6`） |
| M-4 | **混合内容强制放行**：`setMixedContentMode(MIXED_CONTENT_ALWAYS_ALLOW)` ⇒ 连隐私协议页面都可被降级篡改。**本轮补强：隐私页有 3 个地址位**——代码常量 `device.gkuvision.com/static/…`、asset 注释里泄露的**真实线上** `www.gkuvision.com/special/…`（子域与路径都不同）、以及 `assets/xtugo_*.html` 离线兜底，而加载顺序是**网络优先**，所以明文链路上的降级是有意义的攻击路径。⇒ 我们做合规弹窗该抄的是"**本地 asset 兜底 + 网络优先**"这个模式，但**必须把 MixedContent 收成 NEVER** | XTU（TUWIN 是 `COMPATIBILITY_MODE`，稍好） | `base/webview/WebViewActivity.java:55-58`；`ExternalWebActivity.java:274-283`；协议页三地址位 `module_my/ConstantsMy.java:10-17`+`WebViewUtils.java:201`+`_work/re/xtugo/assets-content.md:1957,2078,2136` |
| M-5 | **日志脱敏不完整**：`sensitiveNames` 覆盖了 `pwd`/`secret`/`wifikey`，却**漏了 `seed`、`ssid`、`wifissid`、`wifipwd`、`md5sum`、`serial`、`mac`、`bssid`**；而这些都在 GET 的 query 里。**补一条同类形态**：XTU 的 `LogService` 是**主动跑 `logcat` 子进程抓全量日志再落盘**（`LogService.java:152,277` 起 logcat、`:196` 按进程名找自己那条、`:84,135` 持 WakeLock），第二个抓取点 `LogSwitchUtils.java:31,32`（`logcat --pid=<myPid> -v time -f <file>`）⇒ 清单里的 `READ_LOGS` 因此**不是死声明而是"冗余声明"**（Android 4.1+ 读自身日志不需要它，系统也不授予），这条判据变化见 `§8 C-10` | TUWIN（XTU 的 logcat 侧是同一类问题的更重形态） | `DiagnosticHttpLogPolicy.java:46-62,87-120`；XTU 侧 `dv/LogService.java:60,84,91-92,135,152,196,277,588`、`base/utils/LogSwitchUtils.java:31,32` |
| M-6 | **`@GET downloadFile(@Url String)`** 允许调用方（最终是设备 JSON）提供完整绝对 URL，绕过 base URL 约束。⚠️ **本轮判定：该 Retrofit 方法在官方 App 里没有任何调用方**（全仓对 `M3ApiService.downloadFile` 零调用；`DownloadUtil.java:1140` 那个 `downloadFile` 是**同名不同类**的业务方法，已排除）⇒ 它和 §3 第 4 条那批"声明未接"端点一样，属**潜在设计缺陷而非可达缺陷**；我们复现时**不要**跟着开"@Url 由对端给"这个口子（同 M-10 与 C-3 的教训） | TUWIN | `M3ApiService.java:49-51`；零调用证据见 `01-TUWIN-档案.md 附录一（协议面） §2.7`；grant 拦截器是否兜住 = 因无调用点而**无从测** |
| M-7 | **明文口令持久化 + `allowBackup=true`**：设备 WiFi 口令以 JSON 明文存 DataStore，OTA 元数据（含被投毒的 `fw_url`）缓存进 `ACache` 离线重放。**XTU 侧同一形态本轮核准**：`allowBackup=true` 而 targetSdk=35 **既没有 `fullBackupOnly` 也没有 `dataExtractionRules`** ⇒ 走旧的 `adb backup` 全量语义，可导出 `com.gku.xtugo.xml`（**明文 `bt_pin<设备名>` BLE 配对码**）、`SaveSsidAndPwd`（相机 WiFi 凭据 StringSet）、`RTMPBean`（含 `pwd` 与推流地址） | TUWIN、XTU | TUWIN：`StartupOtaCheckCohort.java:102`、`PreferenceHelper.java:758,779`、`UpgradeHelper.java:470,482`；XTU：清单 `<application>` 属性表（`§3.1`）+ `BLEConnectUtils.java:906,909`、`SharedPreferencesUtils.java:26,33` |
| M-8 | **TLS 旁路 sink**：`SSLContext.getInstance("SSL")` + 可注入的 `TrustManager[]`/`HostnameVerifier`（当前未发现第一方传入天真信任库）。**本轮补一句全局事实**：`network_security_config.xml` 全文 4 行、`<pin>` 0 条、`<domain>` 0 条，旁边还有一份**清单没引用**的 `network_config_base.xml`（含 `debug-overrides` + `certificates src="user"`）⇒ 厂商写过可抓包版本但最终没接上，这既是"公网明文后端（§2.1 的 #20/#22/#23 三条）与全部相机 HTTP 均可中间人"的根据，也是本轮只能静态判定的原因 | XTU | `videocache/HttpUrlSource.java:199-210`；XTU 配置文件 `res/xml/network_security_config.xml`、`res/xml/network_config_base.xml`（`§3.2` 全文） |
| M-9 | **App 内广播可被伪造/窃听（Android ≤12）**——本轮把机制核准了：厂商**注册侧其实是对的**（一律 `SDK_INT>=33` 显式传 `RECEIVER_NOT_EXPORTED(=2)`、否则走老 API 的双分支，如 `PreviewImageActivity.java:631-635`），**缺口在发送侧**：`sendBroadcast(intent)` **不带 receiverPermission** ⇒ 任意 App 可监听；且 **Android ≤32 时接收侧用老 API 注册，广播也可被任意 App 伪造注入**。泄露内容 = 相机推送的状态原文（录制计时、SD 卡状态）。⇒ 上一版"未加 `RECEIVER_NOT_EXPORTED`"的表述不准，真正该抄的是这个**双分支注册**、该避免的是**不带 receiverPermission 的 sendBroadcast**。厂商自定义广播其实**只有 2 条**：`com.gku.xtugo.MESSAGE_ACTION`（5678 回拨转发）、`DV_ISALIVE_ACTION`（心跳），另 3 条 `OldUi.playback.*` 是 Intent extra key 不是广播 | XTU | `MessageService.java:18,127`、`KeepAliveService.java:14,58,73`、`HttpProxy.java:314-316`；接收点 `IjkBaseActivity.java:47`、`PreviewImageActivity.java:631-634,1006`、`Hi3518PriviewImageActivity.java:575-578,916`、`SwitchImageActivity.java:475`；双分支写法 `PreviewImageActivity.java:631-635`。另有 22 处 WiFi 状态广播（`STATE_CHANGE`+`supplicant.STATE_CHANGE`）是官方"断连即掉线"观感的来源，我们必须同样监听 |
| M-10 | **两处下载落盘的文件名/URL 全部来自对端 JSON，且没有同源校验**：`OkHttpDownUtil.getRenewalDownRequest(fileInfo.getFurl(), file, …)` —— 相机（或路上任何人）给什么 URL 就去下什么，落到 `DCIM/idGoLive/…` 下任意文件名。**本轮补两处细节**：① `FirmwareInfo.isDownloaded()` 也用同一个 `split("/")[len-2]` 反推已下载路径（`:58-59`），即**落盘目录名被服务端字符串决定两次**；② 续传 header 名写的是**大写 `RANGE`**（`OkHttpDownUtil.java:119`），且 `:242` 把同一 header 用在 **POST** 上（服务端多半忽略）⇒ HTTP 头大小写不敏感，功能无碍，但说明这条路没被测过 | idGoLive | `LYDownloadFileActivity.java:165-171`；`FirmwareDownloader.downloadFile(download, new File(str2, str), …)`（`DownloadFirmwareActivity.java:322-334`）；`entity/FirmwareInfo.java:58-59`；`OkHttpDownUtil.java:119,242` |
| **M-11** | **导出 Activity 直接吃外部 Intent 参数当播放地址**（本轮新增，`02-XTUGO-档案.md 附录E（权限·组件·域名） §5.4` 明说"安全评估归 docs/05"）：`com.gku.gkucamplayer.GKUCamPlayer` 是全清单里**唯一可被任意 App 拉起、且会吃外部参数的厂商 Activity**——`onCreate` 读 `getStringExtra("kPlayFilePath")`/`"kPlayFileName"` 后**原样**交给 `GSYVideoOptionBuilder.setUrl(...)`，播放器实参是 ExoPlayer。配合 `usesCleartextTraffic=true` 与零证书固定，**外部 App 可以让它去拉任意 `http://` / `file://` / `rtsp://`**。⇒ 记在这里是为了**我们自己别重犯**：导出的 Activity 一律不接收裸 URL/路径参数，要接收就得过 scheme + host 白名单（对齐我们在 §5 第 1/3 条的改法） | XTU | `gkucamplayer/GKUCamPlayer.java:35`（`PlayerFactory.setPlayManager(Exo2PlayerManager.class)`）、`:38`、`:39`、`:47`（`.setUrl(this.url)`）、`:139`（重播同一路径）；导出事实见 `_work/re/xtugo/components.tsv`（`exported=true`、无 intent-filter、无权限）与 `§2.6` E2、`§5.4` 矩阵 |
| **M-12** | **清单/权限的"拼写与代际"错误**（本轮新增，纯包体卫生但会咬到功能）：① idGoLive 清单把权限名写错——`android.permission.CHANGE_WIFI_MULTICAST_STAT`（正字 `…_MULTICAST_CAST`），`PackageManager` 对未知权限**安装时静默忽略**，所以**功能上没坏**（`MulticastLock` 本来不需要该权限，`CoreMulticast.java:21-23` 照样拿到锁）——真正缺的是 `ACCESS_WIFI_STATE`(已有) 之外的 `CHANGE_WIFI_MULTICAST_CAST`；② idGoLive **只声明 legacy `BLUETOOTH`/`BLUETOOTH_ADMIN`（API ≤30）而没有 `BLUETOOTH_SCAN`/`BLUETOOTH_CONNECT`，偏偏 `targetSdk=35`** ⇒ **Android 12+ 上它的蓝牙配对功能是坏的**（这是官方 App 自己的缺陷，不是我们的）。⇒ 两条都是"我们别照抄"的具体靶子，见 §5 | idGoLive | `_work/re/idgolive/manifest.md:68-70`（三条原文）；组播锁 `_work/idgo_live_src/sources/com/icatchtek/control/core/CoreMulticast.java:15-16,21-23`；对照 XTU 的正确写法：它在 4 处申请点分别按 API 30/31/32+ 切换三套数组（含 `BLUETOOTH_SCAN`/`CONNECT`/`ADVERTISE`，`02-XTUGO-档案.md 附录E（权限·组件·域名） §1.1` #18） |

### Low / 只需知道、不必处理

| ID | 项 | 说明 |
|---|---|---|
| L-1 | **包体死重量把攻击面看着比实际大** | idGoLive 里 `169.254.169.254` 来自 Google API Client 库、几十个 OAuth 域名来自 scribejava 的 **179 个 `*Api.java`**、MQTT（`org.eclipse.paho`）无 broker 只借了个 `"/"` 常量。三处都是**没被第一方调用的库代码** ⇒ 云元数据窃取在这类 App 上不成立（手机不在 GCE/Lambda 网络里）。真正的害处只有包体积和"审计时误判"。**本轮把同一结论推广到三家**：TUWIN 43 个域名判定单元里 **28 个属这一类**（`one.umops.com`、`errnewlogos`、`htls`、`203.107.1.1` HTTPDNS（还被厂商显式关掉）、`ren.yale` 整个预加载面、8 条 assets 预热文件名、`github.com`/`code.google.com` 等 90 余处注释链接）；XTU 侧最典型的是 `api.shhc-yh.com`（死常量）与 `172.18.1.19`（作者内网调试地址残留） |
| L-2 | 网络配置区分 CN/海外两套地址与区域枚举 | 本身不是缺陷，但对我们是**信号**：idGoLive 的账号层是按区域可换址的白标 SDK，我们不该假设厂商云端接口稳定。**本轮补一句**：整套 `ACCOUNT_SERVER_*`/`PUSH_*` 都属未接入的死重量（见 H-8），所以"厂商云端接口稳定性"这个判断的依据其实比上一版更弱——真正的教训是**别把白标库的常量当厂商的接口** |
| **L-3** | **只看 Java 会整块漏掉 native 层的网络面**（本轮新增的方法教训，非厂商缺陷） | 三家都有：idGoLive 的**整条 YouTube 直播链**（取 token→建 stream→建 broadcast→bind→transition）在 `libpanorama_vr.so` 的 `.rodata` 里，Java 侧只有 `JStream*` JNI；XTU 的高德瓦片口 `m5.amap.com`/`mpsapi.amap.com` 也只在 `libAMapSDK_MAP_v10_0_600.so`；TUWIN 的 `.so` 里 `Java_*` 符号会**系统性漏掉** ijkplayer/ucrash/umonitor（它们靠 `JNI_OnLoad`+`RegisterNatives` 动态注册，符号表里没有 `Java_` 前缀）。⇒ 域名清点必须同时扫 `natives-strings.tsv` 的 `url` 类，判断某 `.so` 是否真被用到要看 `JNI_OnLoad` |
| **L-4** | **清单里"看着像在用"的三条**（信息性，供互操作时不踩） | ① XTU 的 `activate.html` 里注释泄露了"设备激活用户协议"真实托管在第三方转换服务 `sulu.cdkm.com`、文件 ID 硬编码，且**无任何 Java 引用**（与 `getactivateinfo.cgi`/`setactivateinfo.cgi` 同一业务）；② `title_condition*.html`、`ly_menu.json.json`（文件名重复 `.json.json`）同样零引用，后者那份 4 位 `cmd` 表仍是未解之谜；③ XTU release 包里嵌了 **debug 构建的子模块**（`gkucamplayer/BuildConfig.java:5,6,8` = `BUILD_TYPE="debug"`、`DEBUG=true`，iCatch 三个 SDK 模块同） |

**三家共同、值得单独记住的一条**：**没有任何形式的证书固定**，且都全局允许明文。⇒ 明文不是个别接口的疏忽，是默认姿态。**本轮修正**：上一版举的 idGoLive 同类证据（"连自家账号服务器和客服接口都敢走 `http://`"）**不成立**——那两条都是零调用点的死常量（H-8 已降级）。真正的共同证据应当是：XTU 的 `network_security_config.xml` 全文 4 行、`<pin>` 0 条、`<domain>` 0 条（还有一份没接上的 debug 用户 CA 版本），TUWIN 的整条 OTA 面走明文（C-1），idGoLive 的清单本身全域放行明文（`res/xml/network_security_config.xml` 仅一行 `cleartextTrafficPermitted="true"`）。

---

## 5. 我们自己的 App 自查

对照上面这些，`E:\rovecamlink` 现状（含工作树里未提交的第一批改动）：

**已经做对的**：
- **凭据完全不落盘** —— 全仓无 `DataStore`/`SharedPreferences`，WiFi 口令只活在内存（比 M-7 好）。
- **文件名消毒** —— `core/storage/FileSaver.kt:24 sanitizeFileName()` 显式处理 `/` 与 `\`，注释写明"设备返回的文件名不可信"（比 C-3 好）。
- **不往系统日志里写东西** —— 主源集里零 `android.util.Log`/`println`（全仓仅一处 `println`，在 `composeApp/src/desktopTest/kotlin/com/rovecamlink/app/core/log/DiagHttpTraceTest.kt:112` 打印测试产出的日志包，不进设备日志），更没有任何“把凭据写进共享存储日志”的形态（比 idGoLive 的 H-6 好）。
- 只有一个 `MainActivity` 导出，`FileProvider` 是 `exported=false` 且只放开日志目录（`res/xml/file_paths.xml` 三个 root 全部指向 `logs/`：`external-files-path`/`files-path`/`cache-path`；原来那条 `cache-path app-update/` 随自更新模块一起删了）（比 M-1/M-2 好——注意 idGoLive 那份 `file_provider_path.xml` 里 7 条中 6 条是 `path="."`，XTU 的 `root-path` 则来自 LuckPicture，见 M-1）。
- **没有账号层、没有第三方 SDK** —— 无 OAuth、无推送、无统计、无地图 ⇒ 上面 H-5/H-6/H-7/L-1 那一整类问题在我们这里**结构上不存在**（不是"修好了"，是根本没有承载它的代码）。这条要守住：以后任何"加个登录/加个云备份"的提议，都会一次性把这三家的坑全部引进来。**本轮再加一条对照**：三家的"云上报"实际入口都只有 2 个（统计 SDK + 日志上云），我们两个都没有 ⇒ 只要不新增依赖，H-4/H-5/H-6 这一类不可能被"改出来"。
- **清单权限的代际与拼写已经是对的**（对照 idGoLive 的 M-12）—— `composeApp/src/androidMain/AndroidManifest.xml:22-31` 已按现代写法声明：`BLUETOOTH_SCAN` 带 `neverForLocation`、`BLUETOOTH_CONNECT`，legacy `BLUETOOTH`/`BLUETOOTH_ADMIN` 各自加 `maxSdkVersion="30"`。⇒ idGoLive 那种"targetSdk=35 却只声明 legacy 权限，Android 12+ 蓝牙配对直接坏"的坑我们没有；`CHANGE_WIFI_MULTICAST_STAT` 这类拼错的权限名也不存在（我们当前不申请组播权限，若将来做 idGoLive 的 UDP 5002 发现，要写的是正字 `CHANGE_WIFI_MULTICAST_CAST`，同时知道 `MulticastLock` 本身不需要它）。
- **导出面只有 1 个 Activity，且不接收裸 URL/路径参数**（对照 M-3/M-11）—— 只有 `MainActivity` 导出；XTU 的 `GKUCamPlayer` 是"导出 activity + 吃外部 URL 参数"的反面教材，我们没有任何等价形态。
- 下载**截断即失败**、只有 `206` 才认续传（`CameraHttp.kt:196-200` 判 `status == 206`，否则整档从 0 重来；`:244-245` 字节数不符即 `truncated` 失败）——这条比 XTU 严谨。**（旧版写的 `:140-148` 是加诊断日志前的行号，已按现状核准）**

**要改的 4 条**（本轮顺手把"现状"核准了：第 2、4 条随 `9048c35 Drop app self-update…` 已闭环，位置随代码演进有漂移，已在表里标出）：

| # | 问题 | 位置 | 改法 |
|---|---|---|---|
| 1 | `usesCleartextTraffic="true"` 是**全局**的。我核实过：Android 的 network security config **只支持按域名，没有 `<subnet-entry>`**，所以无法"只放行 192.168.x.x 明文"。 | `androidMain/AndroidManifest.xml:53`（原文写的 `:35` 已随清单增长漂移） | 保留全局明文（相机必须），但**在代码层强制 scheme**：所有非相机主机的 URL 必须 `https://` 才发；给 `CameraHttp` 加一个"仅私有 IP 允许 http"的守卫 |
| 2 | ~~`AppUpdate` 从 GitHub JSON 取 `apkUrl` 时**不断言 `https://`**，也没有 `browser_download_url` 主机白名单~~ ⇒ **已闭环**：整个自更新模块随提交 `9048c35` 删除，全仓已无 `AppUpdate.kt`/`REQUEST_INSTALL_PACKAGES`（`check-citations` 报的唯一"文件不存在"就是这条旧路径） | ~~`commonMain/…/core/update/AppUpdate.kt` 的第 67–70 行~~（文件已不存在） | 已按第 4 条的建议整块删除 ⇒ 三家 C-2/H-2 那类"自己给自己引入供应链"的形态在我们这里**代码已不存在**，守住别加回来 |
| 3 | `CameraHttp` 的 `getText/getBytes/post/download` 接受**任意 URL 字符串**，而 `RemoteFile.downloadUrl` 直接来自相机响应 ⇒ 一台恶意相机能让我们去 GET 任意外部地址 | `core/transport/CameraHttp.kt`：`getText:97`、`getBytes:117`、`post:142`、`download:180`（原文写的 `:74-135` 是加诊断日志之前的行号，已漂移） | 下载 URL 必须与 session 的 host 同源；跨主机就拒 |
| 4 | ~~**App 自更新整块与产品决定冲突**：你已决定不做（"不使用 APP 了"），但工作树里已实现~~ ⇒ **已闭环**：模块与 `AppUpdate.android.kt`/`.desktop.kt`/`.ios.kt` 一并删除；`res/xml/file_paths.xml` 现在只剩三个指向 `logs/` 的 root，不再有 `app-update/` | ~~上述 4 处~~ | 已删。这条的价值留作**决策记录**：任何"加回 App 自更新"的提议都要连带重新评估 C-2/H-2/C-4 三家的坑 |

---

## 6. 可以继续使用的 API —— 判定表

判定标准：**公开、无鉴权、面向终端用户、且是互操作真正需要的** → 可用；需要账号、需要冒充官方 App 身份（包名/UA/app key/Bearer）、或会往厂商基础设施写数据 → 不用。

### ✅ 可用

| 端点 | 为什么可用 | 用时要注意 |
|---|---|---|
| **XTU `GET https://server4.gkuvision.com/v1/push/api/getNewestVersion?firm_ware_model=&region=&hardware_version=`** | 公开固件索引，无鉴权，登录前就返回空 `Bearer ` 也能用；我们的 App 本来就需要它来知道目标版本 | ① **把 `file_url` 强制改成 `https://`**（实测同对象支持）；② 校验它给的 `size`；③ `region`/`pcbrevision` 当不可信输入，别拼进路径（XTU 自己就栽在这，C-3）；④ 一次用户操作一次请求，不要批量枚举型号 |
| **idGoLive `GET https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json`** | 静态公开清单，HTTPS，无参数。响应结构本轮核准：顶层键 `firmware_list`，每项 5 个字段 `product`/`name`/`region`/`version`/`download`（官方读法 `DownloadFirmwareActivity.java:171-173`；落地文件名固定 `SPHOST.BRN`） | 清单里**没有** checksum/size 字段 ⇒ 下载后必须自己校验；OSS 的 `ETag` 就是 MD5（实测逐字符相等），可直接用。**更稳的做法**：我们自己 pin 每个对象的摘要，别把 `firmware.json` 当可信来源（它无签名，且厂商会随手改型号目录）。⚠️ **别照抄它的取路径方式**：官方从 `download` 串里按 `/` 切开拿 `[len-2]` 当目录名（C-3），我们只用最后一段做**消毒后**的文件名 |
| **idGoLive `GET https://www.id221.com/api/app/firmware/area_check`** | 公开、无鉴权，可查某型号在某地区是否开放升级。响应结构本轮核准：`{code:int, data:{area_support:String}}`，官方 `code==200` 才落盘（`ConnectDeviceManager.java:362,376-381`） | **只做"提示"，不做"决定"**：它返回的是厂商运营开关，不是完整性/安全性证据。我们的刷机闸门必须是文档 04 §6 那套本地校验，不能是这里 |
| **相机本地全部 HTTP/TCP/RTSP 接口**（`/api/*`、`/app/*`、`/cgi-bin/hi3510/*`、`/cgi-bin/hisnet/*`、`?custom=1&cmd=`、7878/8787/8080/3333、RTSP） | **这是互操作的正当面**：用户自己的相机、局域网内、无云端条款。顺带白捡一份**完整命令字典**：idGoLive `RequestInfo.java:8-66` 把 **59 条常量 / 38 个不同 `cmd=`** 连语义常量名都写全了（`3012` 版本、`3017` 剩余空间、`3024` 卡状态、`3031&str=all` 菜单、`8888`/`3016` 心跳、`8013` 电量…），XTU/TUWIN 也各有同类表 | 只对**用户当前已连接**的那台调用；绝不扫描子网、绝不对第三方设备调用。同时在我们 App 里对破坏性动作加二次确认（因为设备侧根本没有鉴权，误触即生效）。⚠️ **清单要剔死接口**：TUWIN 那 4 个"声明未接"的 `/app/getparam*`、`downloadFile(@Url)` 和 `/api/rtspstatus` 官方都不发（§3 第 4 条） |
| `device.gkuvision.com/static/*.html`、`tuwinwifihelp.tuwinsmart.com`、`ride5helpnew.tuwinsmart.com`、`idcam.idalbum.com.cn/idGoLive/{privacy,userAgreement}-*.html` | 公开文档/法律文本 | **只放链接、跳浏览器**；不要热链进我们自己的 WebView（M-4 降级风险），也不要抓下来当自己的内容。隐私政策/用户协议必须**我们自写自托管**。**本轮学到的一点**：XTU 与 idGoLive 都给每个协议配了**同名 asset 做离线兜底**（`ConstantsMy.java:10-17` 的成对写法 + `WebViewUtils.loadUrlAndAssets`），这是两家少数值得抄的合规形态——我们的协议页应当**打进包里、离线可读**，而不是只放一条外链 |

### ❌ 不用

| 端点 | 为什么不用 |
|---|---|
| TUWIN `http://ali.tuwinsmart.com/newota`、`/banner` | **明文 HTTP 且响应无签名**，`fw_url` 又不过白名单 ⇒ 复用它等于把供应链交给路径上的任何人。要用必须先有 HTTPS 等价端点（**UNVERIFIED** 是否存在）。**这是唯一一条"想复用但当前不能复用"的遗憾** |
| **idGoLive `https://api.bpsc.tinyai.top:3026` / `http://usa.boi.tinyai.top:3006`**（tinyai 账号层）、`push.smarthome.icatchtek.com` | 私有账号/推送层，**只能靠冒充官方客户端身份**（硬编码 push key、区域路由、设备注册）才连得通。我们的互操作完全不需要它 —— 直连相机就能拿到实时流。**本轮改判**：这三条连同 `KVS_WEBRTC_REGION` 全是白标库的**死重量**（App 自有包零引用，`DownLoadUtils` 那个唯一读点自己也零调用），所以既不用、**也连"要不要复用"这个问题都不存在**；上一版把它当在用账号层写，是清单里最该修的一处 |
| **idGoLive `https://api.idalbum.com/album.php/api/*`、`http://api.idstore.idalbum.com/api/getCustomerServiceInfo`** | 前者是 App 自更新 + 反馈写入（都不做），后者是明文客服信息 ⇒ 直接把帮助中心做成我们自己仓库里的静态页。**本轮补判**：三条常量**都是"声明未用"**（`RequestInfo.java:13,26,29` 无人读），所以"它明文"要读成"若被启用即降级"，不是"它在明文外发" |
| **idGoLive 的 Facebook/Google OAuth 全套**（`Credentials.java`、`GraphOperation`、`GoogleAuthTool`、Drive/YouTube 上传） | 用的是**别人泄露在 APK 里的 app secret**（`FACEBOOK_APP_SECRET`、两份 Google `CLIENT_SECRET`）。任何一次复用都是"拿别人的凭据冒充别人"，绝对禁区。**本轮核准的一处细节**：`Credentials.java` 那 6 个常量零消费者（H-7），所以禁区的原因是"凭据泄露在包里"，不是"存在可用的回跳地址" |
| **idGoLive 的 YouTube 直播链**（`rtmp://a.rtmp.youtube.com/live2/…`、`liveBroadcasts`/`liveStreams` 全套、native `libpanorama_vr.so`） | 包里**硬编码了一枚厂商自己的 YouTube stream key `3fur-h6bh-as8j-w7wd-d7us`**（`PreviewPresenter.java:1952` 直接把它当默认推流地址）。**我们记录它的唯一用途是"我们自己别重犯"——绝不要把任何 stream key 写进客户端**；这**不构成**对任何人（包括厂商自己）频道的授权，也不构成"可以去推它"的理由。整条链在 native 层，Java 侧不可复用，我们也不做直播 ⇒ 彻底不碰 |
| XTU `/v1/login`、`/v1/register`、`/v1/vcode`、`/v1/forgot_password`、`/v1/modify_password`、**`/v1/delete`**、`/v1/users/profile`、`/v1/feedback`、`/v1/upload/image`、`/api/*` | 账号体系，需 Bearer；调用即把我们的用户塞进厂商账户系统。`/v1/delete` 是破坏性的，绝不可从第三方 App 触达 |
| XTU `/api/promotions`、`/v1/device_models` | 需以官方客户端身份（`RequestInterceptor.java:24-33` 那套 `os`/`appVersionCode`/`lang` 头）访问 ⇒ **冒充** |
| XTU `api.dashcamplayer.net/api/aliyun/uptoken` | **无鉴权的云凭据签发口**。调它 = 在厂商账户上铸存储 token。这是 C-4，不是我们的接口 |
| XTU `121.40.107.215:8041`、`www.gkuvision.com:8882`、~~`api.shhc-yh.com`~~ | 前两条：明文 + IP 直连 + 另一条产品线（RXT/记录仪）遗留。第三条**本轮判为厂商侧死常量**（`AppService.java:23,24` 零消费者），已不在清单里 ⇒ 连"不用"都不必说，只是别再把它当接口抄 |
| 两家的 `appupdatecheker` / `firmWareModel=XTUGO_Android` / `appdownload.tuwinsmart.com` | 服务厂商自己的 APK 分发，且我们已决定不做 App 自更新。⚠️ 端点拼写照抄要当心：官方是 `appupdatecheker`（少一个 `c`） |
| TUWIN `POST /feedback`、XTU `/v1/feedback` | 往厂商支持队列写垃圾数据，无论它多容易调 |
| `yomu.atlasmeta.one/<locale>/privacy.html` | **第三方域名托管 TUWIN 的法律文本**。我们的隐私政策必须自托管，不依赖别人的主机名 |
| 所有 Umeng / Bugly / APMPlus / 字节 Zeus / 高德 / HMS / Google 端点 | 需要厂商 SDK 身份（app key / AK / SK），用了就是冒充 + 违反其条款；高德还会**上传定位**（`apilocate.amap.com/mobile/binary`、`cgicol.amap.com/collection/collectData`）。**本轮补两点事实**：① XTU 的崩溃上报是 **Bugly**（不是 Umeng，它包里没有友盟 SDK），友盟只在 TUWIN；② XTU 那份高德**根本没有 apikey** ⇒ 它的 `restsdk.amap.com/v3/iasdkauth` 一定发、但一定鉴权失败，"复用它"这条路物理上不通 |
| 阿里云 OSS（TUWIN 的 `BuildConfig` AK/SK、XTU 的服务端下发 bucket） | 凭据复用问题。**本轮补**：XTU 侧 AK/SK **不在 APK 里**，全部由 C-4 那个明文接口下发 ⇒ 我们即使想复用也没有凭据，只能靠自己铸；TUWIN 侧是反过来的（AK/SK 编译期进包），两种都是坏示范 |

### 一句话总结

**能拿的公开信息就三块：XTU 和 idGoLive 的固件索引、idGoLive 的地区开关（只作提示），加上 idGoLive `RequestInfo.java` 里那份现成的 `cmd=` 命令字典。其余云端接口一律不碰；真正的互操作面全在相机本地。** 另外，本次最有价值的"可用信息"其实不在 API 里，而在**镜像头部**（doc 04 §5 真机固件分析 / 本文 §1 第 5 条）——那是三家都没用、而我们免费能拿到的防错刷依据。

**三家云端接口的"可用比例"低得惊人**（本轮逐个判定后重算）：**idGoLive 真在用的域名只有 6 个**，其中能复用的是 3 个（`firmware.json`、`area_check`、帮助/法律页）；账号层、推送层、KVS 图传层**整体是白标库的死重量**（不是"需冒充身份才可用"，而是**根本没有代码在用**），OAuth 那套因凭据泄露而绝对禁区。**TUWIN 侧 43 个判定单元里运行时真访问只有 15 个**，厂商自有外网域名**只有 6 个**（`ali.tuwinsmart.com` 功能面 + 5 个内容/客服面），其中能复用的**一个都没有**（要么明文要么厂商私有）。**XTU 侧 A 类 29 条**里与相机协议无关的公网访问全是商店/客服/协议链接。⇒ 这反过来证明**我们不需要厂商云端也能做完整个产品**，插件层只要把相机本地那一面覆盖住就够了。

---

## 7. 待真机验证（不联网、不碰别人设备的前提下无法确认）

1. **相机是否校验 Host**：决定 DNS 重绑定"路过格卡"在真机上是否成立。验证方式：自己的相机连着，`curl -H "Host: evil.example" http://<相机IP>/cgi-bin/.../getdeviceattr.cgi`，看是否 200。**低风险只读**。
2. **设备侧是否真的接受无凭据的破坏性命令**（H-1 目前只证明了 App 不发凭据）。验证方式：自己的相机上跑一次 `sdcommand?-format`，看是否成功。
3. TUWIN 是否存在 HTTPS 的 `newota` 等价端点（决定 §6 里那条"遗憾"能否解开）。
4. XTU **3 枚** Google 地图 key 是否有包名+SHA-1 限制（清单 1 枚 + `WelcomeActivity.java:96`/`:106` 按品牌分支运行期注入的 2 枚）。**新问题**：那两枚是 App 自己 `putString` 进 `ApplicationInfo.metaData` 的 ⇒ 谁在给哪个 key、构建期怎么选的，静态看不出限制配置。
5. TUWIN `BuildConfig` 里阿里云 AK/SK 是否真被打包进 release。
6. **idGoLive 的 `?custom=1&cmd=` 是哪套固件在响应**：这台 `192.168.1.254` 的行车记录仪形态和文档 03 里那套运动相机形态不同源，我们接之前必须确认自己手上的设备走哪一套（验证方式：自己设备上 `curl 'http://<IP>/?custom=1&cmd=3012'` 看是否返回版本串，**只读**）。**本轮补一条**：`.254` 上官方还埋了第二套 `/app/` JSON profile（`LyWyzRequestInfo`，**零调用点**）⇒ 真机探测时顺手看一眼 `curl 'http://<IP>/app/getdeviceattr'` 是否回 JSON，能回就说明我们的插件要按 `getdeviceattr` 是否 JSON 来分流两套 profile。
7. idGoLive 的 `area_check` 返回体到底是什么结构、是否随地区变化 ⇒ 我们若只当提示用，可以先不依赖它的语义。**结构本轮已静态确认**（`{code, data.area_support}`），剩下的只是 `area_support` 的取值域。
8. **友盟的 3 个"缺证"点**（本轮明确记为静态无解，别在当前文档里当已确认）：① `ulogs`/`cnlogs` 的完整 URL 常量类 `com.umeng.commonsdk.statistics.UMServerURL` 在未喂 jadx 的 `classes3.dex` 里；② `libumonitor.so` / `libumeng-spy.so` 的 `loadLibrary` 调用点同样缺证（服务已注册但加载链不可见）；③ `aspect-upush.umeng.com` 是否真发包受远端 `actionInfo` 开关控制。补证手段（都限于我们自己的设备与自家构建）：单独反编译 `classes3.dex`（`jadx --single-class`）、真机看 `:u_heap` 进程是否存活、在自己手机上开启隐私同意后抓包对照。**这些都不影响"我们不上报＝不实现这一层"的结论。**
9. **XTU `GKUCamPlayer` 的实际可达性**（M-11）：清单上它是 `exported=true` 且吃 `kPlayFilePath`，但"外部 App 拉起后能否真的播放 `file://` 任意路径"取决于运行时权限与 GSY/Exo 的实现。验证方式（只针对我们自己的设备与自家测试 App）：写一个最小 Intent 起它，看是否真的播放我们指定的本地文件。**不做任何针对他人设备的验证。**

---

## 变更记录（2026-09-22 全量复现档案回写）

| 处 | 改了什么 | 依据（`docs/08-官方APK全量逆向档案/`） |
|---|---|---|
| §0 方法小节 | 新增两段：① **提取层自身的坑**——`signals-hosts.tsv`（TUWIN 1,088 行约 95% 是正则误报：`.kt` 文件名/全限定类名/系统属性键；XTU 的 501 条**一个公网域名都没有**），凡证据列写 `host 扫描` 的降为弱证据；② 三档判定纪律（真访问 / 未触发 / 死字符串） | `01-TUWIN-档案.md 附录三（传输·OTA·联网） §6.2-A` 首段、`§8.2` 第 3 行；`02-XTUGO-档案.md 附录E（权限·组件·域名） §4.0` 警告框、`§9 U3` |
| §1 第 2 条 | idGoLive 的两条明文"账号/客服接口"改判为**无调用点**（死重量/声明未用），明文面据实收窄；XTU 补 `api.shhc-yh.com` 是死常量 ⇒ 公网明文口计数明确 | 同上 + `03-idGoLive-档案.md 附录D（UI 与端点判定） §3`、`02-…-权限组件与域名.md §4.1`（shhc-yh 判 D） |
| §1 第 3 条 | 「没有任何一家做证书固定」补强：XTU `network_security_config.xml` 全文 4 行、0 `<domain>`/0 `<pin>`、另有未接上的 `network_config_base.xml`（debug 用户 CA）；唯一成体系固定材料是 3 个华为 BKS；⇒ 本轮判定只能靠静态的原因 | `02-…-权限组件与域名.md §3.2`、`§7.3`、`§8 C-05` |
| §1 第 7 条 | 「真正的第一方接口只有十几个、明文两条」重写：TUWIN 43 判定单元中真访问 15（6+2+7）；idGoLive 真在用域名收敛到 6 个 | `01-TUWIN-档案.md 附录三（传输·OTA·联网） §6.2` 汇总、`§8.2` 第 1 行；`03-idGoLive-档案.md §9` 末行 |
| §2.1 XTU 全表 | 加「判定」列（A/B/C/D→真访问/条件/死字符串/死常量）逐行落档：#21 `api.shhc-yh.com` **剔除出 API 清单**、#23 补两条产品线与 `info.json` 消费者、#24 协议页 3 个地址位、#27–28 证据从 `host 扫描` 换成真实调用点并补全 11 条外链、新增 #25 ICMP `8.8.8.8`、#26 YUTU 跳板、#29 三条死字符串含内网地址残留 `172.18.1.19` | `02-…-权限组件与域名.md §4.1`、`§4.4`、`§4.6`、`§8 C-09` |
| §2.1「未找到」+ 第三方 SDK 面 | 「推送服务」分两层说清（云端只有 Bugly；本地是 5678 回拨 + 2 条 App 内广播）；**Umeng 从 XTU 的 SDK 列表里删掉**；SDK 表逐个给判定与条件（Bugly 在用、zeus/抖音仅 `:bytelive` 且只 Ambarella 机型、高德无 key 必然鉴权失败、OSS 无硬编码三元组、HMS 无 appId、APM Insight 未触发）；补 `PROTOCOL_HTTP` 常量被当 `http://` 别名的误读陷阱 | `02-…-权限组件与域名.md §4.2`、`§5.3`、`§8 C-07/C-08`；`02-XTUGO-档案.md §11` |
| §2.2 TUWIN 表 | 加「判定」列；补 10 条 `tuwinwifihelp` 预热字面量整体已死（Coordinator 零构造）、白名单条件项 6 组（`intelligentassistant`/裸 IP `111.179.38.202`/`2005.sunwingroup`/`cdn.dcloud`/抖音小红书公众号）、`appdownload` 是"服务器内容驱动"而非客户端自拼；OSS 行的补证手段写实 | `01-TUWIN-档案.md 附录三（传输·OTA·联网） §6.2-A` 全表 |
| §2.2「第三方」段 | 由一句「Umeng 全家桶」重写为 8 条：**友盟确实在用**（反射 `UMConfigure.init`、AppKey `6781b8f38f232a05f1f56ef5`、清单无 appkey meta-data、同意后 `initThirdLibs` 两道闸门）、真访问 7 域 vs 死重 4 域、HTTPDNS 被显式关闭、3 个友盟 `.so` 与 `libumeng-spy` 的 3 个 `Java_*`、全 APK 只有一套统计+崩溃上报 | 同上 `§6.1`、`§6.2-B`、`§7.1`、`§8.2` 第 2 行 |
| §2.3 idGoLive 两张表 | 加「判定」列：账号层与推送层整体改判**死重量**（含 `DownLoadUtils` 唯一读点也零调用）、`api.idalbum.com` 与客服接口改判**声明未用**；新增 5 行真在用（法律页 + asset 兜底、`www.baidu.com` ICMP、RTMP 与硬编码 stream key、native 层 YouTube Data API 全套、两个 Google client ID 及其 `CLIENT_SECRET`） | `03-idGoLive-档案.md 附录D（UI 与端点判定） §3`、`03-idGoLive-档案.md §6.8`、`§9` 末两行 |
| §2.3 设备本地面 + 坑清单 | 行号 `RequestInfo.java:8-60`→`:8-66`（并说明第 52 行是空 `cmd=` 模板）；补四层设备选择逻辑、共享失败计数器 bug、`.254` 双 profile（`try2connectLywyzIC` 死代码）、`ApiCaller` 绑 socketFactory、发现机制无 mDNS；"三个坑"扩为四个（新增 `demo.xarx.rocks` 死重量），方法论收获补 native 侧对称教训 | `03-idGoLive-档案.md §2`、`§9` 第 5/6 行；`03-…-UI与端点判定.md §3`、`§4` |
| §3 本地控制面 | 表后新增 4 条：①「零鉴权」要说清是设备侧，TUWIN App 侧有 `EndpointAuthority` 白名单（客户端自律，值得抄）；② `/api/reboot` 受 `features` 能力开关；③ **5 个"声明但零调用方"端点从 API 清单里剔除/标注**（`getAllParamItems`/`getAllParamValues`/`getParamValue`/`downloadFile(@Url)`/`setmode mode=1`）+ `rtspstatus` | `01-TUWIN-档案.md 附录一（协议面） §2.6`、`§2.7`、`§8.1 C-1`、`§8.2 D-3`、`§8.6 G-1` |
| §4 C-1、H-1 | C-1 的明文口计数与证据行改准（XTU 两条更新口，dashcamplayer 归 C-4，shhc-yh 剔除）；**H-1 的 idGoLive 证据 `RequestInfo.java:33-35` 行号错**，按文件实况改为 `:15,18,58,59,61` | `02-…-权限组件与域名.md §4.1`；`_work/idgo_live_src/…/RequestInfo.java` 逐行核 |
| §4 H-3、H-5、H-7、H-8 | H-3 删掉"rtspstatus 是第二道鉴权"并把"seed 授权 RTSP"降级为推断（补真实握手顺序）；H-5 的 **XTU Google key「2 枚」改「3 枚」**、补抖音 AppKey 与 Bugly AppId、TUWIN 侧标"清单不可见只经反射"；**H-7 结论推翻**（redirect URI 零消费者 ⇒ 降级为"密钥入库 + 死常量"）；**H-8 从 High 降级**（明文常量存在但无人连） | `01-TUWIN-档案.md 附录三（传输·OTA·联网） §6.1`；`01-TUWIN-档案.md 附录一（协议面） §8.1 C-1`、`§8.3 E-1/E-2`；`02-…-权限组件与域名.md §3.3`、`§4.5`；`03-…-UI与端点判定.md §3` |
| §4 M-1…M-10 | M-1 把 `root-path` 的**责任方**归准（XTU 那份在 LuckPicture 的 `ps_file_paths`，厂商自己的 `paths_base` 无 root-path），清单行号改 `:606-614`/`:625-633`；**M-2 判据作废**（API 17+ provider 未写 `exported` 默认 false ⇒ 改为"导出组件只有 7 个"的准确口径）；M-3 补可达性收窄；M-4 补协议页三地址位；M-5 补 XTU `logcat` 子进程与 `READ_LOGS` 改判"冗余声明"；M-6 标"零调用点"；M-7 补 XTU `allowBackup` 三样明文内容；M-8 补全局无 pin；**M-9 机制改述**（注册侧其实用了 `RECEIVER_NOT_EXPORTED` 双分支，缺口在 `sendBroadcast` 不带 receiverPermission）；M-10 补第二处 `split[len-2]` 与大写 `RANGE`/POST | `02-…-权限组件与域名.md §1.1` #33、`§2.6`、`§3.1`、`§3.4`、`§5.3`、`§6.1`–`§6.4`、`§8 C-01/C-06/C-10`；`01-TUWIN-档案.md 附录一（协议面） §2.7` |
| §4 新增 M-11、M-12 | **M-11**：XTU `GKUCamPlayer` 是唯一导出且吃外部参数的厂商 Activity，`kPlayFilePath` 原样进 `setUrl` ⇒ 可注入任意 `http/file/rtsp`（按原口径写成"我们自己别重犯"）；**M-12**：idGoLive 清单权限名拼错 `CHANGE_WIFI_MULTICAST_STAT`（功能无碍但别照抄）+ 缺 `BLUETOOTH_SCAN`/`CONNECT` 而 targetSdk=35 ⇒ **Android 12+ 蓝牙配对坏** | `02-…-权限组件与域名.md §5.4`、`§2.4`、`§2.6` E2；`03-idGoLive-档案.md §1.3`、`§9` ⑤；`03-…-UI与端点判定.md §5` |
| §4 L 表 + 共同条目 | L-1 把"死重量"结论推广到三家（TUWIN 28 项、XTU 死常量与内网残留）；L-2 补"白标库常量 ≠ 厂商接口"；新增 **L-3**（只看 Java 会漏 native 层，含 `Java_*` 抽 JNI 的系统性盲区）与 **L-4**（`sulu.cdkm.com` 协议托管、两个零引用 asset、release 包里嵌 debug 子模块）；「三家共同」那条**删掉对 H-8 的引用**并换成三条站得住的明文证据 | `02-…-权限组件与域名.md §7.1`、`§7.2`、`§4.5`；`01-TUWIN-档案.md 附录三（传输·OTA·联网） §6.2-B`、`§7.1`；`03-…-UI与端点判定.md §3`、`§4` |
| §5 自查 | 「已经做对的」补 3 条：清单权限现代写法（`AndroidManifest.xml:22-31` 已含 `BLUETOOTH_SCAN neverForLocation`/`BLUETOOTH_CONNECT` + legacy 加 `maxSdkVersion=30`，对照 M-12）；导出面只有 1 个 Activity 且不吃裸 URL（对照 M-3/M-11）；三家云上报入口只有 2 个、我们两个都没有 | 同 M-11/M-12 依据；`composeApp/src/androidMain/AndroidManifest.xml` 实测 |
| §5「要改的 4 条」+ FileProvider/下载两条事实核准 | 用仓库自带的 `tools/re/check-citations.mjs` 跑本文，唯一"文件不存在"的引用暴露出：App 自更新模块**已随提交 `9048c35` 删除** ⇒ 第 2、4 条标为**已闭环**（保留原文与决策理由，不当作已修好的成绩）；同时把三处随代码演进的旧行号改准：`usesCleartextTraffic` `:35`→`:53`、`CameraHttp` 方法行号 `:74-135`→`:97/:117/:142/:180`、截断即失败 `:140-148`→`:196-200,244-245`；`file_paths.xml` 现在只有 3 个指向 `logs/` 的 root（不再有 `app-update/`） | `git log 9048c35`；`composeApp/src/androidMain/{AndroidManifest.xml,res/xml/file_paths.xml}`、`core/transport/CameraHttp.kt`、`core/storage/FileSaver.kt:24` 逐行核；`node tools/re/check-citations.mjs docs/05…` |
| §6 判定表 | ✅ 表：`firmware.json` 补响应结构与 `SPHOST.BRN`、`area_check` 补响应结构、命令字典行号改 `:8-66` 并加"剔死接口"提醒、法律文本行补"asset 离线兜底值得抄（但 MixedContent 收成 NEVER）"。❌ 表：tinyai 账号/推送层改判"死重量、连问题都不存在"、`idalbum`/客服三条标声明未用、OAuth 禁区理由改为凭据泄露、**新增 YouTube 直播链一行**（硬编码 stream key 仅作"我们别重犯"记录，明确不构成对任何人设备的授权）、shhc-yh 剔除、Umeng/Bugly 归属改对、高德"无 key 物理不通"、OSS 两家形态对比。总结段按新判定重算 | `03-…-UI与端点判定.md §3`、`03-idGoLive-档案.md §6.7`/`§9`；`02-…-权限组件与域名.md §4.2`、`§4.6`；`01-TUWIN-档案.md 附录三（传输·OTA·联网） §6.2` 汇总 |
| §7 待真机验证 | 第 4 条改为 3 枚 key 并补"运行期注入"新问；第 6 条补 `.254` 双 profile 探测；第 7 条标注结构已静态确认；**新增第 8 条**（友盟 3 个缺证点与补证手段，明确不许当已确认）、**第 9 条**（`GKUCamPlayer` 可达性只在自己设备自家 App 上验） | `01-TUWIN-档案.md 附录三（传输·OTA·联网） §6.1`、`§6.2-B`（缺证面）；`02-…-权限组件与域名.md §9 U1`–`U6`；`03-…-UI与端点判定.md §3` |
