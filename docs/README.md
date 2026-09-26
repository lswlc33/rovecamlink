# RoveCamLink 文档系统

`docs/` 的全部文档按**层**组织，每篇文档有一个稳定的 **doc-id**，正文与代码一律用 doc-id 互相引用。这份文件是系统的总纲：地图、约定、维护规矩、旧编号对照。

> 摘要三行：**结论看 `analysis/`，取证看 `evidence/`，我们自己的实现看 `impl/`，计划与设计看 `design/`。**
> 引用写法：`` `docs/<层>/<slug>` ``（例：`docs/analysis/ota-and-gaps §6.1`）。
> 检查器见 §7：CI 跑三个，本地跑四个。

## 1. 分层与目录

```
docs/
├── README.md            本文件（系统总纲）
├── analysis/            ① 结论层——人写的结论、速查表、研究报告
│   ├── README.md            层索引
│   ├── apk-overview.md      首次逆向报告（概览）
│   ├── protocol-matrix.md   品牌 → 型号 → 协议能力矩阵（速查，权威）
│   ├── ota-and-gaps.md      固件更新（OTA）与功能差距
│   ├── network-api.md       网络 API 清单与安全评估
│   └── ble-and-vpn.md       蓝牙发现 / 自动连网 / VPN 共存研究
├── design/              ② 计划与设计层——快照，不承诺
│   ├── README.md
│   ├── roadmap.md           架构与开发计划（2026-09-20 决策快照）
│   └── specs/               设计文档（按日期命名，如 icatch-http-profiles）
├── impl/                ③ 实现层——我们自己的实现说明
│   ├── README.md
│   ├── diagnostics-log.md   诊断日志系统（语法、脱敏、排障读法）
│   └── command-surface.md   我们已实现的命令面（协议方法 / 请求 / 设置项台账）
├── evidence/            ④ 证据层——三个官方 APK 的穷尽式拆解（权威）
│   ├── README.md            层索引
│   ├── method.md            档案总览与方法（本层入口，先读它）
│   ├── tuwin.md             TUWIN 1.6.4 全量事实（含内嵌附录）
│   ├── xtugo.md             XTU GO 8.4.3 全量事实（含内嵌附录）
│   ├── idgolive.md          idGoLive 1.3.6 全量事实（含内嵌附录）
│   ├── operations-matrix.md 三家操作对照 + 我们侧状态台账
│   └── data/                机器提取表（生成物，勿手改；见 data/README.md）
├── index.html           官网首页（GitHub Pages 从 main 分支的 /docs 发布，必须留在根下）
├── 404.html             旧 URL 重定向页（docs/01…08 编号时代的地址自动跳新位置）
├── .nojekyll            关掉 Pages 的 Jekyll，.md 按原样以纯文本提供
└── app-icon-512.png     商店 / 宣传图标素材（由 tools/IconGen.java 写到这里）
```

根下的非文档文件都是部署约束：Pages 的发布源是 `/docs`，`index.html` 必须在根；`.nojekyll` 让 `.md` 链接直接给纯文本（Jekyll 默认会把它转成 `.html`，链接就 404 了）；`404.html` 承接重整前的旧地址；图标由 `tools/IconGen.java` 生成。

## 2. 每篇回答什么、该信谁

| doc-id | 层 | 回答什么问题 | 冲突时 |
|---|---|---|---|
| `analysis/apk-overview` | 结论 | 三家官方 App 各是什么技术栈、值得借鉴什么、要避开什么（概览） | 取值细节以 `evidence/*` 为准 |
| `analysis/protocol-matrix` | 结论 | 有哪些型号、怎么识别、怎么连、怎么通讯、有哪些设置项 | **权威**；档案发现的错回写本文 |
| `analysis/ota-and-gaps` | 结论 | 三家固件更新（OTA）机制、变砖护栏、我们还缺什么 | **权威**；命令层台账不在这里 |
| `analysis/network-api` | 结论 | 厂商云端 API 清单、能用哪些、厂商侧安全缺陷 | **权威**；§0 是方法边界 |
| `analysis/ble-and-vpn` | 结论 | BLE 发现 → 唤醒热点 → 自动入网的取证，VPN 抢默认网络的对策 | 研究报告；§5 是当时建议 |
| `design/roadmap` | 计划 | 分期计划、模块划分、平台边界、风险 | 计划快照，进度以根 README 为准 |
| `design/specs/2026-09-25-icatch-http-profiles` | 计划 | iCatch 系（idGoLive 白标）双 profile 插件设计 | 已落地 |
| `impl/diagnostics-log` | 实现 | 诊断 TXT 的语法、采样、脱敏，一次排障怎么读 | 与代码冲突以代码为准 |
| `impl/command-surface` | 实现 | 协议接口每个方法、每条实际请求、设置项 id、UI 入口映射 | 与代码冲突以代码为准 |
| `evidence` | 证据 | 本层索引：有哪些档案、按什么顺序读 | 索引 |
| `evidence/method` | 证据 | 档案怎么建的、覆盖了多少、怎么复跑、按问题翻哪张表 | 本层入口，先读它 |
| `evidence/tuwin` `evidence/xtugo` `evidence/idgolive` | 证据 | 某家 App 每条命令、每个取值、每个类的证据 | **权威**，可推翻结论层 |
| `evidence/operations-matrix` | 证据 | 同一操作三家各发了什么、我们做到哪一步 | 我们侧状态的唯一台账 |
| `evidence/data` | 生成物 | 机器提取表怎么读、怎么重跑 | 生成物，改提取器不改表 |

回写规则（只有这一份）：**档案与结论层冲突以档案为准；结论层与代码冲突以代码为准；`impl/*` 与代码冲突以代码为准。** 每次回写当轮完成，不留两份互相矛盾的表。

## 3. 按问题找答案

| 你想知道 | 先看 |
|---|---|
| 新接一个品牌 / 机型要动哪些地方 | `analysis/protocol-matrix` §0 → 对应档案的「机型与识别」→ `evidence/operations-matrix` §5 |
| 某个操作官方到底发了什么（URL / 参数 / 时序） | 对应档案的「操作复现表」→ `evidence/data/<app>/catalog-http.md` |
| 某个参数有哪些取值 | 档案的「设置项全表」→ `evidence/data/<app>/catalog-enums.md` + `res-strings-default.md` |
| 某个端口 / 超时 / 缓冲区数值 | `evidence/data/<app>/catalog-ports.md` → `api/<包>.md` 找调用点 |
| 我们侧现在发哪些请求、成功判据是什么 | `impl/command-surface` |
| 我们离官方还差什么、优先级 | `analysis/ota-and-gaps` §7 + `evidence/operations-matrix` §3 |
| 相机连不上 / 传输出错怎么定位 | `impl/diagnostics-log`（把导出的诊断 TXT 附上） |
| 官方有什么我们**明确不做** | `evidence/operations-matrix` §4 |
| 某条结论有没有证据 | 档案里每条事实都带 `_work/<app>_src/sources/…:行号`；引用由 `tools/re/check-citations.mjs` 机器核 |

## 4. 命名与引用约定

- **doc-id = 文件路径去掉 `docs/` 与 `.md`**：`analysis/ota-and-gaps`、`evidence/xtugo`、`design/specs/2026-09-25-icatch-http-profiles`。id 稳定、自描述、可 grep。
- **引用一律写全 `docs/<层>/<slug>`**，指向小节时接 `§`：`docs/analysis/ota-and-gaps §6.1`、`docs/evidence/xtugo §8.4`。不再用 `docs/04`、`08/03` 这类编号——历史上 `docs/03`（协议矩阵）与 idGoLive 档案都写作「03」，是这套系统要消灭的歧义。
- **Markdown 相对链接**用中文标题做标签（如 `[本层索引](analysis/README.md)`）；跨层用相对路径，别写仓库绝对路径。
- **档案内嵌附录**：`evidence/tuwin` `evidence/xtugo` `evidence/idgolive` 各自的下半部是 `# 附录 A · …` 长表（2026-09-22 从 18 个文件归并而来）。所以「附录 A」默认指**同一文件内**的附录。
- **行号引用** `path:line` 必须是语料里的真实行号，写前机器核过，不靠人眼。
- **每篇文档的头部块**是约定的状态声明：`doc-id`、层、状态、建档日、修订日，第二行指向本文件。改文档时同步它。

## 5. 新增与修改

1. **新增文档**：放进对应层，文件名用 ASCII 的 kebab-case slug（URL 与 grep 友好），H1 用中文标题，写上头部块；在该层 `README.md` 的索引里登记一行（`check-refs` 会检查这行在不在）；跨层引用写全 `docs/<层>/<slug>`。设计文档放 `design/specs/`，按 `YYYY-MM-DD-主题.md` 命名。
2. **移动或改名**：先 `grep -rn "docs/<层>/<slug>" --include='*.kt' --include='*.md' --include='*.mjs' .` 看清引用面再动。整体重整过一次，映射表见 §6。
3. **回写**：按 §2 的规则，发现别的文档写错，当轮改过去。
4. **只读文件**：`evidence/data/**`（生成物）、`index.html`、`app-icon-512.png`。生成物说明在 `evidence/data/README.md`。

## 6. 旧编号对照（2026-09-26 重整）

重整前是扁平的 `docs/01…08`，编号同时被代码注释、其它文档与官网引用（表里旧路径省略 `.md` 后缀）。**手上若有旧链接或旧注释，按这张表换算：**

| 旧 | 新 doc-id |
|---|---|
| `docs/01-APK逆向分析报告` | `analysis/apk-overview` |
| `docs/02-KMP架构与开发计划` | `design/roadmap` |
| `docs/03-品牌型号与协议矩阵` | `analysis/protocol-matrix` |
| `docs/04-固件更新与功能差距` | `analysis/ota-and-gaps` |
| `docs/05-网络API清单与安全评估` | `analysis/network-api` |
| `docs/06-诊断日志系统` | `impl/diagnostics-log` |
| `docs/07-蓝牙发现与自动连网及VPN共存研究报告` | `analysis/ble-and-vpn` |
| `docs/08-官方APK全量逆向档案/00-总览与方法` | `evidence/method`（层索引是 `evidence/README.md`） |
| `docs/08-官方APK全量逆向档案/01-TUWIN-档案` | `evidence/tuwin` |
| `docs/08-官方APK全量逆向档案/02-XTUGO-档案` | `evidence/xtugo` |
| `docs/08-官方APK全量逆向档案/03-idGoLive-档案` | `evidence/idgolive` |
| `docs/08-官方APK全量逆向档案/04-三家操作对照与复现清单` | `evidence/operations-matrix` |
| `docs/08-官方APK全量逆向档案/05-我们已实现的命令面` | `impl/command-surface` |
| `docs/08-官方APK全量逆向档案/data/**` | `evidence/data/**` |
| `docs/superpowers/specs/2026-09-25-icatch-http-profiles-design` | `design/specs/2026-09-25-icatch-http-profiles` |

改写由已归档的一次性脚本 `tools/re/oneoffs/relayout.mjs` 完成（映射表与上表一致），扫过全仓 60 多个文件、约 480 处引用：docs 正文、`composeApp/` 与 `simulator/` 的代码注释、测试注释、根 README、官网首页、`tools/re/` 自身。

## 7. 检查器（CI 上跑三个，本地跑四个）

CI（`.github/workflows/docs-check.yml`）在每次推 main / PR 时跑三个自包含检查器；`check-citations` 依赖 gitignore 的本地语料（`_work/*_src` 与厂商 APK），只能在本地跑：

```sh
node tools/re/check-refs.mjs             # doc-id 引用解析 + § 小节号存在性 + 层索引孤儿检查
node tools/re/check-links.mjs docs       # 相对链接可达（含「目标里带空格」这类 404 写法）
node tools/re/check-tables.mjs docs      # 表格列数与表头一致（--fix 只修反引号内的竖线）
node tools/re/check-citations.mjs docs   # 每条 path:line 引用是否能在语料里定位（仅本地）
```

四个都是零第三方依赖、秒级。`check-refs` 是这套系统的守卫：它让「引用一个 doc-id / 一个 § 小节」永远可以机器验证。§ 校验的口径：`§` 必须紧跟在 doc-id 引用后面（中间只允许反引号、空格或一处「附录X（…）」式限定语），引用的小节号在目标文档的标题里存在（或落在某个已存在小节之下，如 §5.2.2 → §5.2）；隔了其它行文的小节号不在校验范围。

## 8. 生成物与工具

- `evidence/data/` 由 `tools/re/` 从 `相机 app/` 的三个官方 APK 静态提取，**确定性输出**（除 `_corpus/corpus.md` 一行生成时间外不带时间戳），重跑后 `git diff` 里的差异必然是真实取证差异。重跑方式、每个提取器的输入输出、已知的坑：`tools/re/README.md`。
- 更大的原始表（全量字面值、符号表、解出的 `assets/`、`lib/`）留在 `_work/re/`（gitignore 的 scratch），需要时按同一份 README 重跑。
- 方法边界沿用 `analysis/network-api` §0：只做静态分析与自有设备 / 自建模拟器上的验证，不碰他人设备与厂商线上服务；分析记录随仓库提供，不代表获得对应厂商的任何权利。
