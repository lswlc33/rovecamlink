# Lessons —— 踩过的坑与不再犯的规矩

这份文件只记**真实发生过、且有代码/构建证据**的问题，不写感想。每条末尾的「规矩」是硬约束。

---

## 1. 文档里写了没验证过的功能

README 与官网的状态清单把「断点续传」勾成已完成，实际情况是：`AppState` 算出了已下载字节数却从没传下去，两个协议插件的 `download()` 把 `alreadyHaveBytes` 硬编码成 `0`，`CameraHttp` 里那段 Range 分支从写下来就没执行过一次。

同类问题还有「可安装调试 APK」——`gradlew` 从 Windows 入库时没有执行位，Linux 上根本跑不起来。

> **规矩**：状态清单里每一项都要能回答「在哪台设备、哪次运行里跑通过」。答不上来就写「未验证」，不许打勾。

## 2. 把「能构建」当成「能发布」

在真机从没连上过（`CHANGE_NETWORK_STATE` 没声明，`requestNetwork` 被系统直接拒绝）、下载会中途静默截断、iOS 从没编译过的状态下，提议推 `v0.1.0` 正式 tag。

> **规矩**：发正式 tag 前，第 10 节的发布前检查清单必须逐条打勾。缺任何一条就不发，也不提议发。

## 3. 跨平台 API 靠猜，本地还验不出来

| 我写的 | 真实情况 | 后果 |
|---|---|---|
| `String(bytes)` | Kotlin/Native 解析到已废弃的 `String(CharArray)` | iOS 编译失败 |
| `resp.readText()` | Ktor 2.3 没有这个方法（3.x 才有） | Android 一起编译失败 |
| `set(HttpTimeout.Request, …)` | 2.3.12 没有这个属性键 | 我写的「每请求超时」是幻觉 |
| `Dispatchers.IO` | 在非 JVM 目标上是 internal | 只有 macOS runner 抓得到 |

关键陷阱：`gradle.properties` 里有 `kotlin.native.ignoreDisabledTargets=true`，**Windows 本地会把 iOS 目标静默跳过并报告 BUILD SUCCESSFUL**。本地绿不等于跨平台绿。

> **规矩**：不确定的跨平台 API 先 `javap -cp <jar>` 查真实签名，别照记忆写。iOS 只能由 CI 的 macOS job 证明。

## 4. 流式读取把「暂时没数据」当 EOF

`ByteReadChannel.readAvailable()` 返回 `0` 表示缓冲区暂时为空、`-1` 才是流结束。旧循环写的是 `if (n <= 0) break`，于是网络一打嗝就提前收尾，还把截断当成功返回。

> **规矩**：传输字节数与 `Content-Length` 不一致一律判失败；`0` 要 `awaitContent()` 后继续等。

## 5. Range 续传的追加陷阱

服务端忽略 `Range` 时会返回 `200` 带完整文件。若此时按「已有一部分」去追加，得到的就是损坏文件。只有 `206` 才允许 append。

## 6. 工具报「写入成功」≠ 文件真的存在

一次 Write 新建测试文件、一次 Edit 往 `build.gradle.kts` 加 `commonTest` 依赖，工具都返回了成功，但文件/改动实际不在盘上，直到编译报 `Unresolved reference` 才暴露。

> **规矩**：新建源文件后 `ls` 确认；改构建脚本后 `grep` 确认；判断测试结果看 XML 的 mtime，不看上一次。

## 7. 浅克隆拿不到 tag

CI 的 verify 用 `git merge-base --is-ancestor <tag> FETCH_HEAD`，而 `actions/checkout` 默认 `fetch-depth: 1` 不带 tag，于是报 `Not a valid object name`，被误读成「tag 不在 main 历史里」。

> **规矩**：凡是要解析 tag 的 job，checkout 一律 `fetch-depth: 0`。

## 8. PKCS12 keystore 会忽略 `-keypass`

用 keytool 生成 PKCS12 库时，key 密码实际等于 store 密码；单独设的 key 密码无效，签名时报 `Given final block not properly padded`。

## 9. 仍是推测、没被真机证实的事

- **XTU 二维码的内容格式**：解析器按 Android `WIFI:` 标准 + JSON + 键值对 + 裸两词写的，真机那个码到底长什么样没验证过。扫不出来时界面会显示原文前 24 字符。
- **各机型 SSID 命名规则**、seed 鉴权细节、M3 帧分隔符、Ambarella `msg_id` 对照表、SigmaStar 报文——见 `01-APK逆向分析报告.md` 第 4 节，都还需要抓包证实。

> **规矩**：推测出来的东西在代码注释和文档里显式标「未验证」，不许和跑通的功能混在一起写。

---

## 10. 发布前检查清单（发 `vX.Y.Z` 前逐条打勾）

- [ ] 真机上 App 能扫到相机热点并连上
- [ ] 连上后能识别机型、显示实时状态
- [ ] RTSP 实时预览在真机上出画面
- [ ] 文件列表能加载、缩略图能显示
- [ ] 下载一个视频到相册，**校验落盘字节数与相机报告的一致**
- [ ] 中途断开 Wi-Fi，App 报失败而不是报完成；重连后能续传
- [ ] 相机断电后 App 能报「无响应」，不会永远显示已连接
- [ ] 扫码连接在真机二维码上跑通（或明确标注该功能未验证）
- [ ] CI 的 Android 与 iOS job 全绿
- [ ] 版本号已随本次发布更新

任何一条没勾上，就不发版。
