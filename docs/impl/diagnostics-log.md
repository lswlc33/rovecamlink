# 诊断日志系统

> **doc-id** `impl/diagnostics-log` · **层** 实现 · **状态** 随代码演进，与代码冲突时以代码为准并回写本文（语法 `rovdiag/1`）· **建档** 2026-09-21 · **修订** 2026-09-26
> 文档系统 [`docs/README.md`](../README.md)

> 目的：让「相机连不上 / 传输出错」这类问题可以被**一份文本文件**说清楚。
> 用户导出 TXT → 提交给开发者或 AI 助手 → 不需要复现就能定位到具体是哪一次 HTTP 交换、哪一行协议判断出了问题。
>
> 代码位置：`composeApp/src/commonMain/kotlin/com/rovecamlink/app/core/log/`
> （`Diag.kt` 写入器、`LogRecord.kt` 模型与开关、`LogFormat.kt` 文本语法、`LogStats.kt` 统计摘要、`LogPlatform.kt` 各平台出口）。

## 1. 怎么用

1. 顶部栏右侧的 **终端图标**（任何标签页都在）→ 打开 **Diagnostics** 全屏页。
2. 页面里是**实时滚动预览**：每 400ms 从写入器取一次快照；`Follow` 关掉即可暂停阅读；点任意一行看完整内容。
3. 复现问题（连接、拍照、下载、OTA……）。
4. 点 **Share TXT**（安卓弹系统分享面板）或 **Save TXT**（写进公共下载目录）。两个按钮导出的内容完全一致。
5. **Snapshot** 按钮会把「当前会话环境」（机型/固件/host/网关/SD 状态/队列长度…）逐条写进日志——导出前点一下，头部信息一定最新。
6. **Logging settings** 里可改：记录级别、是否记录响应体、是否保留敏感参数、是否折叠重复交换、是否写盘，以及当前会话文件的路径。

**问题发生前**把级别调到 `trace`（Verbose）再复现，能看到每一次交换的完整明细；默认 `debug` 下重复轮询会被折叠（见 §3）。

### 日志文件落在哪里

| 平台 | 会话滚动文件 | 导出的 TXT |
| --- | --- | --- |
| Android | `Android/data/com.rovecamlink.app/files/logs/rovcamlink-<时间戳>.txt`（文件管理器可直接进） | 分享面板发出；或 `Downloads/RoveCamLink/`（API 29+ 经 MediaStore，无需权限） |
| 桌面 | `./logs/rovcamlink-<时间戳>.txt` | 同目录；Share 动作为「用系统默认程序打开」 |
| iOS | `Documents/RoveCamLink/logs/`（Files.app 可见） | 分享面板未接（无设备可验），Save 可用 |

滚动文件保留最近 10 个会话；每条约 2s 落盘 flush 一次，`W/E` 级别立即 flush —— 进程崩溃最多丢最后两秒。

## 2. 文件语法（`rovdiag/1`）

导出文件分四段：

```
==== ROVECAMLINK DIAGNOSTIC LOG ====
format=rovdiag/1
grammar=...            ← 自愈式说明：拿着文件不看文档也能读懂
config: level=DEBUG bodies=on secrets=redacted file=on sampling=on
<平台字段 app.version / os.android / device / app.locale ...>
<会话字段 session.phase / camera.model / camera.host / wifi.gateway / files / ota>
==== RECORDS (163 in memory) ====
<记录行>
==== SUMMARY ====
<统计>
==== END ====
```

### 记录行

一行一条记录，列之间是**对齐的固定宽度**，用连续空格分隔（按 ` +` 切分即可）：

```
000125 2026-09-21T19:39:48.158+08:00 +0.702s I HTTP  op=c1:test-session #125 GET http://192.168.0.1:80/cgi-bin/hi3510/getcamerastatus.cgi  -> 200 3ms 17ch ct=text/plain h=Server=...; Date=...   run=21 since +0.232s avg=3ms max=8ms
|  var status="1";
```

| 列 | 含义 |
| --- | --- |
| `000125` | 进程内序号，6 位补零。**序号有跳空**代表那一行被采样折叠了（不是丢掉了，见 §3） |
| `2026-09-21T19:39:48.158+08:00` | 设备本地挂钟，ISO-8601 带时区偏移（头部另有 `device.tz=`） |
| `+0.702s` | 距进程启动的相对秒数（单调时钟，不受改系统时间影响） |
| `I` | 级别：`V` trace / `D` 决策 / `I` 生命周期 / `W` 降级 / `E` 失败 |
| `HTTP` | 子系统标签，见下表 |
| `op=c1:test-session` | 关联号：`<序号>:<操作名>`；同一操作（含它触发的所有 HTTP）共享它。`op=-` 表示不在任何操作内 |
| 其后 | 消息本体。`#157` 是这次交换自己的请求号，`REQ/RESP` 已合并成一行：`METHOD url  -> 状态 耗时 体积 ct= h=` |
| 行首是「竖线 + 两个空格」 | **续行**：属于上一条记录。响应体、堆栈、截断说明都走续行 |

### 标签

| 标签 | 覆盖内容 | 典型行 |
| --- | --- | --- |
| `APP` | 生命周期、阶段迁移、操作 BEGIN/END | `PHASE ConnectingProtocol -> Connected`、`BEGIN capture` |
| `PERM` | 运行时权限结果 | `wifi permissions granted=false` |
| `WIFI` | 加入热点、绑定进程网络、网关解析 | `network AVAILABLE after 1432ms`、`onUnavailable` |
| `NET` | 逐候选 IP × 逐协议的探测结论 | `discover gateway_hint=192.168.0.1 candidates=...` |
| `HTTP` | 每一次相机交换 | 见上面的样例 |
| `PROTO` | 插件的端点/参数选择 | `setMode PHOTO via string-mode(newApp)` |
| `PARSE` | 响应体解析、字段映射 | `list via json: 4 entries, 4 usable` |
| `STATE` | 轮询到的状态**变化**与失败计数 | `status battery 82=>79 rec false=>true (5ms)` |
| `FILE` | 列目录、删除、缩略图 | `list 4 files (was 4) removed=0` |
| `DL` | 传输队列与字节进度 | `START ... resume_from=0`、`DONE ... 1.2 MB/s` |
| `OTA` | 固件更新状态机 | `state -> WaitingForReboot` |
| `PREV` | RTSP 预览播放器状态/错误 | `player error code=...` |
| `DEV` | 设备与运行环境快照 | `device name=... soft=... hard=...` |
| `LOG` | 日志子系统自身 | `export shared: shared rovecamlink-log-...txt` |

### 摘要段（读文件时先看这里）

```
http: requests=158 responses=157 failures=1
socket_errors=1*ConnectException
operations=hi3510-list 1ok capture 12ok/1FAIL
first_error=#162 HTTP ... throw=ConnectException: Connection refused
endpoint                    n answered fail non2xx  avg_ms  max_ms  last
cgi:getcamerastatus          25      25   0      0       3       8  HTTP 200
cgi:getbatterycapacity       25      25   0     25       3       6  HTTP 404
media:.mp4                    1       1   0      0      16      16  HTTP 200
```

端点按 `cgi:<命令名>` / `api:<路径>` / `media:.mp4` / `root:<ip>` 归一，**基数有界**（不会因文件名而爆表），所以「哪个端点在被疯狂轮询、平均多久、失败几次、最后一次什么状态」一眼可见。`avg_ms` 只按**有回复的请求**计算（`answered` 那一列），超时没回复的请求计入 `fail` 与 `max_ms`，不会把平均值假装拉低。

## 3. 采样：为什么文件不会长成砖头

状态轮询每 1.5s 发 5 个 CGI，5 分钟就是约两万次交换。规则：

- 同一端点的连续重复交换（状态码相同）：第 1 次全量记录；之后每 20 次保留 1 行，带 `run=N since=+Ts avg=Xms max=Yms`。
- 被折叠的记录**降级为 `V`（trace）保留在内存环形缓冲里**，不删除：预览页切到 trace 就能回溯看到它们。
- 稳定但错误的回复（每次都 404/500 的 CGI）同样参与折叠——它同样是重复噪声；被保留的那一行仍以 `W` 出现，摘要表里的 `non2xx`/`fail` 也照常累计，所以「哪个端点一直在错」既看得见又不会淹没文件。
- 完全没拿到回复的交换（`E`，超时/连接失败/取消）**永不折叠**，并且会**终止这一轮**：故障恢复后的头几次回复必然全量记录，掉线-恢复的时间点不会被采样吃掉。
- 状态码一变（200→500、500→200）立刻重开一轮，下一条必然全量记录。
- 环形缓冲默认 12 000 条，超出丢最旧的，摘要里 `ring_evictions=` 会如实说明；文件头的 `RECORDS (n in memory, m evicted)` 同理。
- 媒体/文件类端点（`media:*`、`other:*`）**不参与折叠**：每一次下载/删除都单独成行，因为「哪一个文件出的问题」正是要看的信息。

想关掉折叠看每一条：`Logging settings → Recorded level = trace`，或 `Collapse identical repeated exchanges = off`。

## 4. 脱敏（默认开）

日志文件会离开设备，所以默认：

- URL 查询参数中名字含 `password / passwd / pwd / psk / key / wifikey / token / seed / secret / auth` 的值 → `wifikey=***#15`（`#` 后是原始长度，长度本身就是排障信息：WPA2 少于 8 位一定是密码错）。
- 响应体里同样形状的赋值也会被遮蔽（部分固件会把口令回显在 `var wifikey="…"` 里）。
- `setwifi` 一类操作只记 `ssid=... keylen=8`。
- 相机 `authToken`/seed 不落盘；固件镜像字节永不记录（只记 `sent=4194304B`）。

需要原样参数时，在 `Logging settings` 里打开 `Keep passwords/tokens verbatim`（界面会立刻写一条 `W` 级提醒：导出文件将包含相机 Wi-Fi 密码）。**给外部提交时请保持关闭。**

## 5. 一次排障该怎么读

| 症状 | 先看 | 再看 |
| --- | --- | --- |
| 连不上 | `grep ' NET '` 逐探测结论；`WIFI` 的 `onUnavailable`/`timed out` | 摘要里 `socket_errors`；`PERM` 是否 granted=false |
| 连上后频繁掉线 | `STATE poll failed (n/3)` | 相邻 `HTTP ... -> FAIL` 的 `throw=` 因果链 |
| 状态不更新 / 数值可疑 | `STATE status ...` 的变化行 | 同一时刻 `HTTP cgi:getcurallinfo -> 200` 的响应体原文 |
| 文件列表空 | `PARSE list via json/plain` 与 `FILE list 0 files` | 该交换的续行原文（是 404？还是空数组？还是 HTML 错误页？） |
| 下载不完整 | `DL START/DONE/FAILED` 的字节数与 `expected=` | `HTTP ... -> 206/200`，以及 `server ignored Range` |
| 预览黑屏 | `PREV state=BUFFERING→READY` 或 `player error code=` | `PROTO` 里 `preview_url`（头部 `camera.preview_url` 也有） |
| OTA 卡住 | `OTA state -> ...` 序列 | `fileupload.cgi` / `upgrade.cgi` 两行交换的响应体 |

提交日志时请顺带说明：**相机型号、固件版本、手机型号、做了哪几步操作**。有这几项 + 一份 TXT，通常就够定位了。

## 6. 与官方 App 的差异（为什么不直接抄）

`docs/analysis/network-api` 的审计里，三家官方 App 都有把 OAuth refresh token 等写进明文日志的问题。本系统的取向是：**默认结构化、默认脱敏、导出前给出可关的提示**，并把「日志本身会离开设备」当成设计约束。
