# 网络 API 清单与安全评估

> 对象：`TUWIN 1.6.4`、`XTU GO 8.4.3`、`idGoLive 1.3.6` 三个官方 App 的反编译产物 + 真实固件镜像。
> 结论标 `path:line`；CONFIRMED = 读到代码，INFERRED = 推断，**UNVERIFIED = 需联网或真机才能确认，本次刻意未测**。

## 0. 我的方法边界（先说清楚）

**做了**：静态读代码/读资源/读 `.so` 字符串；对**我们自己的桌面模拟器**做本地探测验证攻击面形态；对厂商公开固件索引做只读 GET（这些接口本就无鉴权、面向终端用户，且我们已有真实镜像在手）。

**没做，也不建议做**：对厂商线上服务的任何实际利用、越权写入、批量枚举、压测；对他人相机或他人所在子网的探测；任何攻击脚本。凡"要打通才能确认"的一律标 UNVERIFIED 并说明怎么在**自己的设备**上安全验证。

**为什么这条线重要**：本文一半的发现属于"厂商自己的安全缺陷"。它们的价值在于**指导我们的实现不要重犯**，以及**告诉你复用哪个接口会踩到什么**，不在于拿去打别人系统。看到 `api.dashcamplayer.net` 能白拿 OSS 写凭据，正确反应是"我们绝不调它"，不是"试试能塞多少"。

---

## 1. 结论先行

1. **真正属于我们、可以放手复用的接口，只有相机本地那一套 HTTP/TCP。** 云端的三家 API 里，只有两个是"公开、无鉴权、面向终端用户、且我们确实需要"的：**XTU 的固件索引**和 **idGoLive 的固件清单**。其余云端接口要么需要账号、要么需要冒充官方 App 身份、要么会往厂商基础设施里写垃圾数据。
2. **三家云端接口的传输安全都不合格**，但程度不同：TUWIN **整条 OTA 控制面是明文 HTTP**（`http://ali.tuwinsmart.com/`）；XTU 索引是 HTTPS 但**返回的固件下载地址是 `http://`**（同一对象其实支持 HTTPS，我实测两者都 200 —— 纯配置错误）；idGoLive **固件清单是 HTTPS（这三家里最好的一点），但同一 App 里连自家账号服务器和客服接口都是明文**（`http://usa.boi.tinyai.top:3006`、`http://api.idstore.idalbum.com`）⇒ 没有一家可以按"它用了 HTTPS"来判断可信。
3. **没有任何一家做证书固定（certificate pinning）**，三家都全局 `cleartextTrafficPermitted=true`。⇒ 只要走明文，链路上任何人都能替换固件。
4. **相机本地控制面零鉴权，而且破坏性动作用 GET 触发、不绑定 Host。** 我在自己的模拟器上实测：`reset.cgi` / `deleteallfiles.cgi` / `sdcommand.cgi?-format` 对任意 `Host:`/`Origin:`/`Referer:` 一律 200，无 `WWW-Authenticate`。这是 DNS 重绑定"路过格卡/刷机"的完整前提。真机是否如此 **UNVERIFIED**。
5. **最有复用价值的信息不是 API，是固件镜像本身**：XTU 的 `.bin` 有 256 字节自描述头（型号串 + 版本串 + 文件长度），iCatch 的 `.BRN` 是 `SUNP BURN FILE` 容器且内嵌带 A/B 双槽与 SD 卡恢复的 bootcode。**读头部就能防错刷，三家 App 都没读。**
6. **我们自己的 App 在这一项上已经比三家好**（无凭据落盘、文件名消毒、无日志泄密），但有 4 处要改，见 §5。
7. **idGoLive 的审计把一个方法论问题摆到台面上**：反编译包里看到的域名 ≠ 这个 App 的 API。它包里的 `169.254.169.254` 来自 Google API Client 库、几十个 OAuth 域名来自 scribejava 的 **179 个 provider 类**、MQTT 只被借用了 `"/"` 常量——**全是死重量**（详见 §2.3 末尾）。真正的第一方接口只有十几个，其中明文两条、可利用的路径穿越一条（C-3 新增）。

---

## 2. 云端 API 清单

### 2.1 XTU GO（`server4.gkuvision.com` 为主，共 4 代接口并存）

| # | 端点 | 方法/参数 | 鉴权 | 用途 | 证据 |
|---|---|---|---|---|---|
| 1 | **https** `server4.gkuvision.com/v1/push/api/getNewestVersion` | GET `firm_ware_model`,`region`,`hardware_version`（CSV 列表） | 无（登录前发空 `Bearer `） | 当前代固件索引，响应含 `file_url`/**`size`**/`force`/`release_notes[]` | `loginmodule/api/ApiService.java:45-46`、`manage/DeviceVersionManager.java:287` |
| 2 | https `/push/api/getNewestVersion?firmWareModel=` | GET | 无 | 二代固件索引 `{retCode,data:{updates,url}}` | `sigmastar/upgrade/firm/Presenter/UpgradePresenter.java:165` |
| 3 | https 同上，`firmWareModel=XTUGO_Android` | GET | 无 | **App 自更新** | `upgrade/app/UpgradeViewManager.java:648` |
| 4–15 | https `/v1/login`、`/v1/register`、`/v1/vcode`、`/v1/forgot_password`、`/v1/modify_password`、**`/v1/delete`（注销账号）**、`/v1/logout`、`/v1/users/profile`、`/v1/device_models`、`/v1/feedback/qs_type_options`、`/v1/feedback`、`/v1/upload/image` | POST，多为 Bearer | 账号 | 账户体系 | `ApiService.java:36-112` |
| 16–18 | https `/api/getLanguages`、`/api/promotions`、`/api/sendCode`、`/api/login`、`/api/regist`、`/api/upload` | POST | Bearer | 老版账户/营销 | `ApiService.java:42-95` |
| 19 | **`@Url` 注入点**：`postGetVerifyCode(@Url …)`、`postRegisterAccount(@Url …)` | POST | Bearer | URL 不绑定 server4 ⇒ 可能把 Bearer 发到外部主机 | `ApiService.java:73-75,85-87` |
| 20 | **http** `www.gkuvision.com:8882/upload/update.xml` | GET | 无 | 老 App 更新源 | `rxt/net/AppService.java:22` |
| 21 | **http** `api.shhc-yh.com/` | GET/POST | 无 | RXT/记录仪老接口 | `AppService.java:23-24` |
| 22 | **http** `api.dashcamplayer.net/api/aliyun/uptoken` | POST `{key:"Tag.log",fileType:4,mid}` | **无** | **签发阿里云 OSS 写凭据**（`access_key`/`access_secret`/`security_token`/`endpoint`/`bucket`/`callback_url`/`callback_body` 六项全部被直接采用） | `AppService.java:97-105`、`HomeActivity.java:840-866` |
| 23 | **http** `121.40.107.215:8041/firmware/`（+`info.json`） | GET | 无 | 老固件分发，IP 直连 | `hisilicon/dv/updateapp/UpgradeManager.java:35` |
| 24 | https `device.gkuvision.com/static/xtugo_privacy_{cn,en}.html` 等 | GET | 无 | 隐私/用户协议正文 | `module_my/ConstantsMy.java:10-16` |
| 27–28 | https `www.xtucam.com`、`xtucp.tmall.com`、`shop…taobao.com`、`h5.m.jd.com` | – | – | 营销/店铺链接，非 API | host 扫描 |

**未找到**：设备注册/归属/共享的云端 REST 接口（共享是在**本地经 BLE** 完成的，`module_camera/bluetooth/BluetoothLive.java:92` 直接下发 `("gkuvision-5G","gku88888")`）；天气 API；推送服务；云存储/4G 套餐的 API（"商业化"体现为店铺链接 + `/api/promotions`）。

**第三方 SDK 面**（都不是 XTU 的，也不该由我们调用）：ByteDance APMPlus（`apmplus.volces.com`，**含一个明文 http 变体**，10 个上报路径）、Zeus/抖音直播（`*.vemarsdev.com`、`*.snssdk.com`）、腾讯 Bugly、Umeng、**高德 AMap（`restsdk.amap.com` 明文 + `apilocate.*` 上传定位）**、Google、华为 HMS scanplus/GRS、通用分享 SDK。

### 2.2 TUWIN（`com.tuwinsmart.tuwin`）

| # | 端点 | 方法/参数 | 鉴权 | 用途 | 证据 |
|---|---|---|---|---|---|
| C1 | **http** `ali.tuwinsmart.com/newota` | GET `version`,`boardversion` | **无** | 固件版本 + `fw_url` | `data/source/remote/api/TuwinSuspendApi.java:23`；base URL 见 `gateway/FeedbackApiEndpoint.java:10` |
| C2 | **http** `ali.tuwinsmart.com/banner` | GET | 无 | 首页轮播/提示 | `TuwinSuspendApi.java:20` |
| C3 | **http** `ali.tuwinsmart.com/appupdatecheker` | GET `version`,`platform` | 无 | App 自更新（返回 URL + MD5） | `TuwinSuspendApi.java:17`、`gateway/RoutedAppUpdateGateway.java:26` |
| C4 | **http** `ali.tuwinsmart.com/feedback` | **POST** JSON | 无 | 反馈上传（含设备日志） | `gateway/FeedbackApi.java:16-17` |
| C5 | `fw_url` 指向的任意主机/任意 scheme | GET | 无 | 固件下载 | `core/util/UpgradeHelper.java:531-533`（只 `HttpUrl.parse`，**不查白名单**） |
| C6 | `appdownload.tuwinsmart.com` | GET | 无 | 二进制分发（在白名单内） | `core/internet/ExternalUrlPolicy.java:23` |
| – | `tuwinwifihelp.tuwinsmart.com`、`ride5helpnew.tuwinsmart.com` | **http://** 硬编码 | 无 | 帮助 Vue SPA + 资源缓存 | `presentation/p010ui/home/HomeTipsWebsiteCachePolicy.java:13,17` |
| – | **`https://yomu.atlasmeta.one/<locale>/privacy.html`** | GET | 无 | **TUWIN 的隐私政策正文托管在第三方域名上** | `presentation/p010ui/home/PrivacyPolicySource.java:16,33` |
| – | `tuwin.tmall.com`、`work.weixin.qq.com/kfid/…` | – | – | 店铺/企业客服 | `ExternalUrlPolicy.java:23` |
| – | 阿里云 OSS（AK/SK 由 `BuildConfig` 注入） | – | AK/SK | 云上传 | `gateway/LegacyDirectCloudConfig.java:22-23,103,128-132,149-151`；**值未验证**（jadx 未产出 BuildConfig） |

**⚠️ 之前"base URL 找不到"的空白已补齐**：就是 `http://ali.tuwinsmart.com/`，作为云网关构造器的**默认参数**注入（`RoutedInternetCloudGateway.java:96`、`NetworkRuntime.java:271`）。⇒ `newota`/`banner`/`appupdatecheker` **全部明文、无鉴权、无签名**。

**第三方**：Umeng 全家桶（`utoken`/`resolve`/`ucc`/`htls`/`ulogs`/`errnewlog[os]`/`one.umops.com`）+ `com.efs.sdk` 内存泄漏监控服务。

### 2.3 idGoLive（`com.id221.golive`）

> 这一家的网络面比前两家小得多，**但包体里的 90% 主机名是库自带的，不是它的 API**。先划清这一点，否则清单会误导。

**账号/推送层（第三方白标 SDK `com.icatchtek.baseutil` + `com.tinyai.*`，不是 id221 自己的服务）**

| 端点 | 用途 | 安全形态 |
|---|---|---|
| `https://api.bpsc.tinyai.top:3026` | 账号服务器（CN 区，`ACCOUNT_SERVER_BASE_URL_CN`） | HTTPS；但 base URL 是**可变的非 final 静态字段** |
| **`http://usa.boi.tinyai.top:3006`** | 账号服务器（USA 区，`ACCOUNT_SERVER_BASE_URL_USA`） | **明文 HTTP，第一方账号接口** ⇒ 登录凭据/令牌可被链路读取 |
| `push.smarthome.icatchtek.com` | icatchtek 自有推送 | `ICATCH_PUSH_APP_KEY="XXXXXXX1C5262CC1"` / `SECRET="784DDA534A18B1AE76"` **硬编码**（`AppInfo.java:28-29`） |
| `ACCOUNT_SERVER_REGION` = `cn-northwest-1` / `ap-northeast-1` / `us-west-1` / `ap-east-1` | AWS 区域路由；同一份 `AppInfo` 里还有 `KVS_WEBRTC_REGION`（`ap-northeast-1`/`ap-east-1`）⇒ 该 SDK 家族用 **AWS Kinesis Video Streams WebRTC** 做远程图传。**但 idGoLive 这个包里我没找到 KVS 客户端类，只有常量** ⇒ 后端存在、本 App 未必启用（INFERRED） | 需要 icatchtek 账号 + 凭据，对我们无价值 |

证据：`com/icatchtek/baseutil/info/AppInfo.java:5-15,21,28-30,37`（`com/tinyai/libmediacomponent/utils/AppInfo.java` 是同一份的拷贝）。

**内容/反馈层（id221 第一方）**

| 端点 | 用途 | 备注 |
|---|---|---|
| `https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json` | **固件清单**，无参数 | §6 判定为可用 |
| `https://www.id221.com/api/app/firmware/area_check` | 按地区开关固件推送 | 公开可读 |
| `https://api.idalbum.com/album.php/api/getIdCamSoftwareVersionInfo` | **App 自身**版本检查 | 我们不做 App 自更新 ⇒ 不用 |
| `https://api.idalbum.com/album.php/api/addIdCamFeedback` | 提交反馈 | 写厂商队列 ⇒ 不用 |
| **`http://api.idstore.idalbum.com/api/getCustomerServiceInfo`** | 客服/售后信息 | **明文 HTTP 的第一方接口**（`RequestInfo.java:26`） |
| `https://idcam.idalbum.com.cn/idGoLive/{privacyPolicy,userAgreement}-{en,zh_CN}.html`、`https://id221.com/idGoLive/privacyPolicy-en.html` | 法律文本 | 公开、只读 |
| Google OAuth + Drive/YouTube 上传、Facebook Graph | 社交分享 | 见下"第三方" |

**设备本地面（这才是我们的互操作面）**：`http://192.168.1.254/?custom=1&cmd=<n>[&par=|&str=]` 共 **59 条硬编码常量、38 个不同 cmd**（`com/icatch/golive/net/RequestInfo.java:8-60`）。几个要点：

- `cmd=3003` 设 SSID、**`cmd=3004&str=` 设 WiFi 口令**、`cmd=3029` 读 SSID ⇒ **明文 GET 改 AP 凭据，无鉴权**。
- `cmd=3010&par=1` 格卡、`cmd=4003&str=` 删单文件、**`cmd=4004` 删全部**、`cmd=3011` 恢复出厂、`cmd=3018` 重连 WiFi。
- `cmd=3031&str=all` = 菜单项自描述、`cmd=3021` = 保存菜单设置（与 XTU 的 `getprimarymenuitem` 同一思路）；`cmd=8888`/`3016` 心跳；`cmd=3012` 读版本；`cmd=3017` 剩余容量、`3024` 卡状态、`8013` 电量。
- 另有 **`http://192.168.169.1` / `:80`** 一组（M3 系相机形态，走 `/app/*`），说明这个包同时接行车记录仪（1.254）和运动相机（1.169.1）两类设备。

**⚠️ 三个"看起来像 API 其实不是"的坑**（上一版本文在这里留白，容易被误读成攻击面）：

1. **`http://169.254.169.254`（云元数据地址）不是 idGoLive 的代码**，是打包进来的 **Google API Client 库**自带的 `DEFAULT_METADATA_SERVER_URL`（`com/google/api/client/googleapis/auth/oauth2/OAuth2Utils.java:19`，唯一读它的 `getMetadataServerUrl()` 只在同库里）。配套的 `ComputeCredential`/`DefaultCredentialProvider`/`MockMetadataServerTransport` 是库代码 + 测试代码。手机上既不在 GCE 也不在 Lambda 里，`169.254.169.254` 拿不到任何凭据 ⇒ **降级为 Low，只是包体卫生问题**。
2. **一大串 OAuth 供应商域名**（Facebook/Google/Instagram/VK/Yandex/WeChat/… 几十个）是打包进来的 **scribejava 提供方目录**：`com/github/scribejava/apis/*Api.java` 共 **179 个类**，绝大多数从没被引用。真正用的只有 idGoLive 自己那 3 个。
3. `org.eclipse.paho.*`（MQTT 客户端）也在包里，但业务代码只借用了 `MqttTopic.TOPIC_LEVEL_SEPARATOR` 这个 **`"/"` 常量**（见 §4 的 C-3 与 M-10 两处路径拼接）——没有任何 broker 地址，**MQTT 是死重量**。

⇒ **方法论收获**：反编译包里的字符串≠API 清单。下一步若再扩大清点，必须先按"是否被第一方类引用"过滤，否则清单里 9 成是库。

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

---

## 4. 安全发现汇总（按严重性）

只列跨厂商有意义的；单厂商细节附证据行号。

### Critical

| ID | 发现 | 厂商 | 证据 |
|---|---|---|---|
| **C-1** | **整条 OTA 控制面走明文 HTTP、无签名**。攻击者可决定手机下载并安装什么。 | TUWIN：`http://ali.tuwinsmart.com/`（`newota`/`banner`/`appupdatecheker`）；XTU：`http://121.40.107.215:8041/firmware/`、`http://www.gkuvision.com:8882/upload/update.xml`，且**当前代索引返回的 `file_url` 也是 `http://`** | `TuwinSuspendApi.java:17,20,23` + `FeedbackApiEndpoint.java:10`；`UpgradeManager.java:35`、`AppService.java:22-24`；`file_url` 协议为**我实测确认** |
| **C-2** | **`fw_url` 不查下载白名单** ⇒ 云端响应（可被 MITM 改写）能指定任意主机/scheme 让手机去下载固件 | TUWIN | `UpgradeHelper.java:373,521,528-533`；`ExternalUrlPolicy` 的引用点里**没有** `UpgradeHelper`/`DownloadUtil` |
| **C-3** | **服务端可控的路径组件未消毒 → 目录穿越/任意写** | TUWIN：`expectedFileName = fw_url.substringAfterLast('/')` 无 `..` 过滤，且 M3 的 `POST /upload/{savepath}/{filesize}` 用 **`@Path(encoded=true)`** 关掉转义，`../` 能一路活到设备；XTU：`getPathDir()` 把云端 JSON 的 `region`/`pcbrevision` 直接拼进保存路径；**idGoLive：`onDownload()` 把云端 URL 按 `/` 切开后，用 `[len-2]` 那一段当目录名**（`getExternalCacheDir()+"/Firmware/"+段+"/"`），既不过滤 `..` 也不做 canonicalize，文件名同样来自服务端 | `M3ApiService.java:134-135`、`UpgradeHelper.java:377`；`DeviceVersionManager.java:644-669`；**`DownloadFirmwareActivity.java:322-334`**、**`LYDownloadFileActivity.java:165-171`**（相机 JSON 的 `name`+`furl` 直接决定落盘文件名与下载地址） |
| **C-4** | **无鉴权地签发云存储写凭据，且经明文 HTTP 交付、六项字段全部照单采用**（含 `callback_url`，等于让阿里云替攻击者发请求） | XTU | `rxt/net/AppService.java:97-105`、`HomeActivity.java:840-866`、`OssPostResult.java:18,107,126` |

### High

| ID | 发现 | 厂商 | 证据 |
|---|---|---|---|
| **H-1** | **相机本地控制面零鉴权**，任何 AP 子内主机可改 WiFi、格卡、删媒体、推固件；默认口令是常量（`12345678` / `gku88888`） | 三家 | TUWIN `Ride5CgiApi.java:22,25,64,73,85`、`M3ApiService.java:47,100,103,127,134`；XTU `HttpProxy.java:143,181`、`Setting.java:313`、`WifiAPUtil.java:20`；idGoLive `RequestInfo.java:33-35`（`cmd=3003` 改 SSID、**`cmd=3004&str=` 改 WiFi 口令**、`cmd=3010` 格卡、`cmd=4004` 删全部，全是无凭据明文 GET）；App 侧请求无 `Authorization` = CONFIRMED，设备侧是否强制校验 = **UNVERIFIED** |
| **H-2** | **下载的 APK 无安装前完整性校验**；MD5 与 URL 来自同一份明文响应 ⇒ 校验值本身可被攻击者提供 | TUWIN（`com.azhon.appupdate` 完成路径不调 `checkApkMd5`，且 MD5 为空时静默跳过）；XTU（`UpgradeViewManager.java:425-450` 直接 `new File(mSavePath, apkName)`，`apkName` 来自服务端） | `DownloadService.java:80,101-133,368-385`；`UpgradeViewManager.java:425-450` |
| **H-3** | **"认证"是摆设**：TUWIN 的 `seed` 是客户端自选的 `kotlin.random.Random.nextLong()`（非 `SecureRandom`），发给 `/api/authdevice` 后**应用侧从不派生、保存、比对任何凭据**，RTSP 也不带令牌 | TUWIN | `Ride3ProStreamRepositoryImpl.java:239`、`Ride3ProPlaybackRepositoryImpl.java:1049`、`Ride3ProApiService.java:22-23,57-58`；`com/tuwinsmart/**` 内 `SecureRandom` **0 命中** |
| **H-4** | **密钥/口令进日志，日志再被上传出设备**：`Log.d("saveDeviceInfo:"+SSID+":password"+password)`、BLE pin、MAC、完整登录响应；日志包经 C-4 的 OSS 通道上传 | XTU | `HiWifiManager.java:127,154`、`BroadcastDouyinFragment2.java:483,997`、`DV.java:706,709`、`LoginRepository.java:33`、`LogSaveUtils.java:18,67` |
| **H-5** | **硬编码第三方凭据**：XTU 4 组字节跳动 Zeus `appKey`+`appSecretKey` + 2 个 Google API Key；TUWIN Umeng `APP_KEY`；**idGoLive icatchtek 推送 `APP_KEY`/`SECRET` + Facebook/Google OAuth `client_secret`** | 三家 | `RES/AndroidManifest.xml:648,787,790,1012`、`:273-274`、`WelcomeActivity.java:106`；`APP_KEY="6781b8f38f232a05f1f56ef5"`；`AppInfo.java:28-29`、`Function/live/google/Credentials.java:4-10` |
| **H-6** | **OAuth 长期凭据写进日志，日志落在共享存储**：Google **refresh token**、Facebook access token、设备 WiFi 口令、SSID 全被 `AppLog` 打印；落盘路径按 `SDK_INT` 分支——**Android 10+ 写 `getExternalCacheDir()/BpSCam_APP_Log/`（尚可），9 及以下写 `Environment.getExternalStorageDirectory()/BpSCam_APP_Log/`**，那目录任何有存储权限的 App 都能读。refresh token 是可长期换发访问令牌的那一枚，泄露后果比 access token 重 | idGoLive | `GoogleAuthTool.java:25`、`PreviewPresenter.java:2101,2266`、`USBPreviewPresenter.java:1115`、`GraphOperation.java:31`、`BTPairCompletedFragment.java:167`（`password=[…]`）、`MWifiManager.java:42,70`；落盘分支 `Log/AppLog.java:81-85` + `AppInfo.java:21` |
| **H-7** | **OAuth 重定向到第三方域名与明文 localhost**：`FACEBOOK_REDIRECT_URI = "http://demo.xarx.rocks/"`（别人的域名，托管在明文 HTTP 上）、`GOOGLE_REDIRECT_URI = "http://localhost:8080"`，配套 app secret 直接嵌在 APK 里 ⇒ 授权码回落到攻击者可控/可截获的地址 | idGoLive | `Function/live/google/Credentials.java:5,7,10` |
| **H-8** | **第一方账号/客服接口走明文，且 base URL 是运行期可改的 `static`（非 final）**：`http://usa.boi.tinyai.top:3006`（账号服务器 USA 区）、`http://api.idstore.idalbum.com/api/getCustomerServiceInfo`；同处还留着 `ACCOUNT_SERVER_BASE_URL_INDEX`（0..255，前缀 `URL_`）这套"换 256 个地址"的机制，说明地址本就是可注入的 | idGoLive | `AppInfo.java:5-16`；`RequestInfo.java:26`。**注**：我在包里没找到运行期改写 `ACCOUNT_SERVER_BASE_URL` 的调用点 ⇒ "可被第三方 App 改写"不成立，这里的问题是**明文 + 设计上允许换址**，不是可利用的写入点（CONFIRMED 明文，INFERRED 影响面） |

### Medium

| ID | 发现 | 厂商 | 证据 |
|---|---|---|---|
| M-1 | **FileProvider 暴露整棵存储树**：`<root-path path=""/>` 即文件系统根，加上 `external-path`/`external-files-path`/`cache-path`/`external-cache-path`/`files-path` 五样全是 `path="."`；一次 URI 泄漏 = 任意文件读（含存 Bearer 的 SharedPreferences，以及 H-6 那个日志目录） | XTU、**idGoLive** | XTU `res/xml/ps_file_paths.xml`、`paths_base.xml`，挂在 `AndroidManifest.xml:607-632`；**idGoLive `res/xml/file_provider_path.xml`**（7 条里 6 条是 `path="."`，`root-path name="sdcard1"`） |
| M-2 | **Provider 未声明 `android:exported`** ⇒ 默认导出 | XTU（`com.volcengine.zeus.FileProvider`） | `AndroidManifest.xml:1097-1100` |
| M-3 | **桥接 WebView 加载 Intent 传入的 URL**：`loadUrl(getIntent().getStringExtra("url"))` + `addJavascriptInterface(...,"android")` | XTU | `UserCenterWebView.java:74-88` |
| M-4 | **混合内容强制放行**：`setMixedContentMode(MIXED_CONTENT_ALWAYS_ALLOW)` ⇒ 连隐私协议页面都可被降级篡改 | XTU（TUWIN 是 `COMPATIBILITY_MODE`，稍好） | `base/webview/WebViewActivity.java:55-58`；`ExternalWebActivity.java:274-283` |
| M-5 | **日志脱敏不完整**：`sensitiveNames` 覆盖了 `pwd`/`secret`/`wifikey`，却**漏了 `seed`、`ssid`、`wifissid`、`wifipwd`、`md5sum`、`serial`、`mac`、`bssid`**；而这些都在 GET 的 query 里 | TUWIN | `DiagnosticHttpLogPolicy.java:46-62,87-120` |
| M-6 | **`@GET downloadFile(@Url String)`** 允许调用方（最终是设备 JSON）提供完整绝对 URL，绕过 base URL 约束 | TUWIN | `M3ApiService.java:52`；grant 拦截器是否兜住 = UNVERIFIED |
| M-7 | **明文口令持久化 + `allowBackup=true`**：设备 WiFi 口令以 JSON 明文存 DataStore，OTA 元数据（含被投毒的 `fw_url`）缓存进 `ACache` 离线重放 | TUWIN | `StartupOtaCheckCohort.java:102`、`PreferenceHelper.java:758,779`、`UpgradeHelper.java:470,482` |
| M-8 | **TLS 旁路 sink**：`SSLContext.getInstance("SSL")` + 可注入的 `TrustManager[]`/`HostnameVerifier`（当前未发现第一方传入天真信任库） | XTU | `videocache/HttpUrlSource.java:199-210` |
| M-9 | 隐式广播未加 `RECEIVER_NOT_EXPORTED`，可被伪造注入或观察媒体路径 | XTU | `IjkBaseActivity.java:49-51` 等 ≥7 处 |
| M-10 | **两处下载落盘的文件名/URL 全部来自对端 JSON，且没有同源校验**：`OkHttpDownUtil.getRenewalDownRequest(fileInfo.getFurl(), file, …)` —— 相机（或路上任何人）给什么 URL 就去下什么，落到 `DCIM/idGoLive/…` 下任意文件名 | idGoLive | `LYDownloadFileActivity.java:165-171`；`FirmwareDownloader.downloadFile(download, new File(str2, str), …)` 同理 |

### Low / 只需知道、不必处理

| ID | 项 | 说明 |
|---|---|---|
| L-1 | **包体死重量把攻击面看着比实际大** | idGoLive 里 `169.254.169.254` 来自 Google API Client 库、几十个 OAuth 域名来自 scribejava 的 **179 个 `*Api.java`**、MQTT（`org.eclipse.paho`）无 broker 只借了个 `"/"` 常量。三处都是**没被第一方调用的库代码** ⇒ 云元数据窃取在这类 App 上不成立（手机不在 GCE/Lambda 网络里）。真正的害处只有包体积和"审计时误判" |
| L-2 | 网络配置区分 CN/海外两套地址与区域枚举 | 本身不是缺陷，但对我们是**信号**：idGoLive 的账号层是按区域可换址的白标 SDK，我们不该假设厂商云端接口稳定 |

**三家共同、值得单独记住的一条**：**没有任何形式的证书固定**，且都全局允许明文。⇒ 明文不是个别接口的疏忽，是默认姿态。idGoLive 补了一条同类证据：连自家**账号服务器**和**客服接口**都敢走 `http://`（H-8）。

---

## 5. 我们自己的 App 自查

对照上面这些，`E:\rovecamlink` 现状（含工作树里未提交的第一批改动）：

**已经做对的**：
- **凭据完全不落盘** —— 全仓无 `DataStore`/`SharedPreferences`，WiFi 口令只活在内存（比 M-7 好）。
- **文件名消毒** —— `core/storage/FileSaver.kt:24 sanitizeFileName()` 显式处理 `/` 与 `\`，注释写明"设备返回的文件名不可信"（比 C-3 好）。
- **零日志输出** —— 全仓无 `Log.*`/`println`（比 H-4/M-5 好），更没有任何"把凭据写进共享存储日志"的形态（比 idGoLive 的 H-6 好）。
- 只有一个 `MainActivity` 导出，`FileProvider` 是 `exported=false` 且只放开 `cache-path app-update/` 一个子目录（比 M-1/M-2 好——注意 idGoLive 那份 `file_provider_path.xml` 里 6 条路径全是 `path="."`）。
- **没有账号层、没有第三方 SDK** —— 无 OAuth、无推送、无统计、无地图 ⇒ 上面 H-5/H-6/H-7/L-1 那一整类问题在我们这里**结构上不存在**（不是"修好了"，是根本没有承载它的代码）。这条要守住：以后任何"加个登录/加个云备份"的提议，都会一次性把这三家的坑全部引进来。
- 下载**截断即失败**、只有 `206` 才续传（`CameraHttp.kt:140-148`）——这条比 XTU 严谨。

**要改的 4 条**：

| # | 问题 | 位置 | 改法 |
|---|---|---|---|
| 1 | `usesCleartextTraffic="true"` 是**全局**的。我核实过：Android 的 network security config **只支持按域名，没有 `<subnet-entry>`**，所以无法"只放行 192.168.x.x 明文"。 | `androidMain/AndroidManifest.xml:35` | 保留全局明文（相机必须），但**在代码层强制 scheme**：所有非相机主机的 URL 必须 `https://` 才发；给 `CameraHttp` 加一个"仅私有 IP 允许 http"的守卫 |
| 2 | `AppUpdate` 从 GitHub JSON 取 `apkUrl` 时**不断言 `https://`**，也没有 `browser_download_url` 主机白名单 | `commonMain/.../core/update/AppUpdate.kt:67-70` | 加 `startsWith("https://api.github.com") \|\| 主机 ∈ {objects.githubusercontent.com, github.com}`；**或者按决定整块删掉**（见第 4 条） |
| 3 | `CameraHttp` 的 `getText/getBytes/post/download` 接受**任意 URL 字符串**，而 `RemoteFile.downloadUrl` 直接来自相机响应 ⇒ 一台恶意相机能让我们去 GET 任意外部地址 | `core/transport/CameraHttp.kt:74-135` | 下载 URL 必须与 session 的 host 同源；跨主机就拒 |
| 4 | **App 自更新整块与产品决定冲突**：你已决定不做（"不使用 APP 了"），但工作树里已实现（`core/update/AppUpdate.kt` + `AppUpdate.android.kt` + FileProvider + `res/xml/file_paths.xml`），而且**本来就跑不通**——清单没声明 `REQUEST_INSTALL_PACKAGES` | 上述 4 处 | 删掉这个模块（顺带消掉第 2 条），或反过来补权限并加校验。**建议删**，因为它同时是 C-4/H-2 那类"自己给自己引入供应链"的形态 |

---

## 6. 可以继续使用的 API —— 判定表

判定标准：**公开、无鉴权、面向终端用户、且是互操作真正需要的** → 可用；需要账号、需要冒充官方 App 身份（包名/UA/app key/Bearer）、或会往厂商基础设施写数据 → 不用。

### ✅ 可用

| 端点 | 为什么可用 | 用时要注意 |
|---|---|---|
| **XTU `GET https://server4.gkuvision.com/v1/push/api/getNewestVersion?firm_ware_model=&region=&hardware_version=`** | 公开固件索引，无鉴权，登录前就返回空 `Bearer ` 也能用；我们的 App 本来就需要它来知道目标版本 | ① **把 `file_url` 强制改成 `https://`**（实测同对象支持）；② 校验它给的 `size`；③ `region`/`pcbrevision` 当不可信输入，别拼进路径（XTU 自己就栽在这，C-3）；④ 一次用户操作一次请求，不要批量枚举型号 |
| **idGoLive `GET https://idcam.oss-cn-shenzhen.aliyuncs.com/Firmware/firmware.json`** | 静态公开清单，HTTPS，无参数 | 清单里**没有** checksum 字段 ⇒ 下载后必须自己校验；OSS 的 `ETag` 就是 MD5（实测逐字符相等），可直接用。**更稳的做法**：我们自己 pin 每个对象的摘要，别把 `firmware.json` 当可信来源（它无签名，且厂商会随手改型号目录） |
| **idGoLive `GET https://www.id221.com/api/app/firmware/area_check`** | 公开、无鉴权，可查某型号在某地区是否开放升级 | **只做"提示"，不做"决定"**：它返回的是厂商运营开关，不是完整性/安全性证据。我们的刷机闸门必须是文档 04 §6 那套本地校验，不能是这里 |
| **相机本地全部 HTTP/TCP/RTSP 接口**（`/api/*`、`/app/*`、`/cgi-bin/hi3510/*`、`/cgi-bin/hisnet/*`、`?custom=1&cmd=`、7878/8787/8080/3333、RTSP） | **这是互操作的正当面**：用户自己的相机、局域网内、无云端条款。顺带白捡一份**完整命令字典**：idGoLive `RequestInfo.java:8-60` 把 38 个 `cmd=` 连语义常量都写全了（`3012` 版本、`3017` 剩余空间、`3024` 卡状态、`3031&str=all` 菜单、`8888` 心跳…），XTU/TUWIN 也各有同类表 | 只对**用户当前已连接**的那台调用；绝不扫描子网、绝不对第三方设备调用。同时在我们 App 里对破坏性动作加二次确认（因为设备侧根本没有鉴权，误触即生效） |
| `device.gkuvision.com/static/*.html`、`tuwinwifihelp.tuwinsmart.com`、`ride5helpnew.tuwinsmart.com`、`idcam.idalbum.com.cn/idGoLive/{privacy,userAgreement}-*.html` | 公开文档/法律文本 | **只放链接、跳浏览器**；不要热链进我们自己的 WebView（M-4 降级风险），也不要抓下来当自己的内容。隐私政策/用户协议必须**我们自写自托管** |

### ❌ 不用

| 端点 | 为什么不用 |
|---|---|
| TUWIN `http://ali.tuwinsmart.com/newota`、`/banner` | **明文 HTTP 且响应无签名**，`fw_url` 又不过白名单 ⇒ 复用它等于把供应链交给路径上的任何人。要用必须先有 HTTPS 等价端点（**UNVERIFIED** 是否存在）。**这是唯一一条"想复用但当前不能复用"的遗憾** |
| **idGoLive `https://api.bpsc.tinyai.top:3026` / `http://usa.boi.tinyai.top:3006`**（tinyai 账号层）、`push.smarthome.icatchtek.com` | 私有账号/推送层，**只能靠冒充官方客户端身份**（硬编码 push key、区域路由、设备注册）才连得通；USA 那条还是明文的。我们的互操作完全不需要它 —— 直连相机就能拿到实时流。（`KVS_WEBRTC_REGION` 只是常量，包里**没有** AWS KVS 客户端类，所以这边连"可试的端点"都不存在） |
| **idGoLive `https://api.idalbum.com/album.php/api/*`、`http://api.idstore.idalbum.com/api/getCustomerServiceInfo`** | 前者是 App 自更新 + 反馈写入（都不做），后者是明文客服信息 ⇒ 直接把帮助中心做成我们自己仓库里的静态页 |
| **idGoLive 的 Facebook/Google OAuth 全套**（`Credentials.java`、`GraphOperation`、`GoogleAuthTool`、Drive/YouTube 上传） | 用的是**别人泄露在 APK 里的 app secret**，redirect URI 还指向第三方域名 `demo.xarx.rocks`。任何一次复用都是"拿别人的凭据冒充别人"，绝对禁区 |
| XTU `/v1/login`、`/v1/register`、`/v1/vcode`、`/v1/forgot_password`、`/v1/modify_password`、**`/v1/delete`**、`/v1/users/profile`、`/v1/feedback`、`/v1/upload/image`、`/api/*` | 账号体系，需 Bearer；调用即把我们的用户塞进厂商账户系统。`/v1/delete` 是破坏性的，绝不可从第三方 App 触达 |
| XTU `/api/promotions`、`/v1/device_models` | 需以官方客户端身份（`RequestInterceptor.java:24-33` 那套 `os`/`appVersionCode`/`lang` 头）访问 ⇒ **冒充** |
| XTU `api.dashcamplayer.net/api/aliyun/uptoken` | **无鉴权的云凭据签发口**。调它 = 在厂商账户上铸存储 token。这是 C-4，不是我们的接口 |
| XTU `121.40.107.215:8041`、`www.gkuvision.com:8882`、`api.shhc-yh.com` | 明文 + IP 直连 + 另一条产品线（RXT/记录仪）遗留 |
| 两家的 `appupdatecheker` / `firmWareModel=XTUGO_Android` / `appdownload.tuwinsmart.com` | 服务厂商自己的 APK 分发，且我们已决定不做 App 自更新 |
| TUWIN `POST /feedback`、XTU `/v1/feedback` | 往厂商支持队列写垃圾数据，无论它多容易调 |
| `yomu.atlasmeta.one/<locale>/privacy.html` | **第三方域名托管 TUWIN 的法律文本**。我们的隐私政策必须自托管，不依赖别人的主机名 |
| 所有 Umeng / Bugly / APMPlus / 字节 Zeus / 高德 / HMS / Google 端点 | 需要厂商 SDK 身份（app key / AK / SK），用了就是冒充 + 违反其条款；高德还会**上传定位** |
| 阿里云 OSS（TUWIN 的 `BuildConfig` AK/SK、XTU 的服务端下发 bucket） | 凭据复用问题 |

### 一句话总结

**能拿的公开信息就三块：XTU 和 idGoLive 的固件索引、idGoLive 的地区开关（只作提示），加上 idGoLive `RequestInfo.java` 里那份现成的 `cmd=` 命令字典。其余云端接口一律不碰；真正的互操作面全在相机本地。** 另外，本次最有价值的"可用信息"其实不在 API 里，而在**镜像头部**（doc 04 §5 真机固件分析 / 本文 §1 第 5 条）——那是三家都没用、而我们免费能拿到的防错刷依据。

**三家云端接口的"可用比例"低得惊人**：idGoLive 约 15 个第一方 URL 里能复用的只有 3 个（`firmware.json`、`area_check`、帮助/法律页）；账号层、推送层、KVS 图传层、OAuth 全因需冒充身份而不可用。⇒ 这反过来证明**我们不需要厂商云端也能做完整个产品**，插件层只要把相机本地那一面覆盖住就够了。

---

## 7. 待真机验证（不联网、不碰别人设备的前提下无法确认）

1. **相机是否校验 Host**：决定 DNS 重绑定"路过格卡"在真机上是否成立。验证方式：自己的相机连着，`curl -H "Host: evil.example" http://<相机IP>/cgi-bin/.../getdeviceattr.cgi`，看是否 200。**低风险只读**。
2. **设备侧是否真的接受无凭据的破坏性命令**（H-1 目前只证明了 App 不发凭据）。验证方式：自己的相机上跑一次 `sdcommand?-format`，看是否成功。
3. TUWIN 是否存在 HTTPS 的 `newota` 等价端点（决定 §6 里那条"遗憾"能否解开）。
4. XTU 两个 Google API Key 是否有包名+SHA-1 限制。
5. TUWIN `BuildConfig` 里阿里云 AK/SK 是否真被打包进 release。
6. **idGoLive 的 `?custom=1&cmd=` 是哪套固件在响应**：这台 `192.168.1.254` 的行车记录仪形态和文档 03 里那套运动相机形态不同源，我们接之前必须确认自己手上的设备走哪一套（验证方式：自己设备上 `curl 'http://<IP>/?custom=1&cmd=3012'` 看是否返回版本串，**只读**）。
7. idGoLive 的 `area_check` 返回体到底是什么结构、是否随地区变化 ⇒ 我们若只当提示用，可以先不依赖它的语义。
