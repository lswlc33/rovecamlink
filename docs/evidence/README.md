# 证据层（evidence）

三个官方 APK 穷尽式拆解后的**证据**：方法与总览、三家档案、操作对照、机器提取表。**档案可推翻结论层**：与 `docs/analysis/*` 冲突时以本层为准，并回写结论层。

> **doc-id** `evidence` · **层** 证据（索引）· **修订** 2026-09-26
> 文档系统 [`docs/README.md`](../README.md) · 方法与总览正文在 `docs/evidence/method`

## 本层文档

| doc-id | 内容 | 状态 |
|---|---|---|
| `docs/evidence/method` | 取证对象、方法与工具链、覆盖度、目录结构、按问题找答案、边界与已知空白、复跑与校验 | **本层入口，先读它** |
| `docs/evidence/tuwin` | TUWIN 1.6.4 全量事实（含内嵌附录一／二／三：协议面、设置与操作、传输·OTA·联网） | 权威 |
| `docs/evidence/xtugo` | XTU GO 8.4.3 全量事实（含内嵌附录 A-E：海思 CGI、Ambarella 报文、SigmaStar 与播放层、操作复现表、权限·组件·域名） | 权威 |
| `docs/evidence/idgolive` | idGoLive 1.3.6 全量事实（含内嵌附录 A-D：PTP 属性表、HTTP 与 TCP 命令、原生层与 PTP-IP、UI 与端点判定） | 权威 |
| `docs/evidence/operations-matrix` | 三家操作对照与我们的复现清单（我们侧状态台账，done 的判据是真机跑通） | 唯一台账 |
| `docs/evidence/data` | 机器提取表（生成物，勿手改；目录树在 `method` §4，契约在 `data/README.md`） | 生成物 |

## 阅读顺序

1. 先读 `method`：怎么取的证、覆盖了什么、边界在哪。
2. 查具体事实：对应档案（`tuwin` / `xtugo` / `idgolive`），长表在各自下半部的「附录」。
3. 查「某个操作官方发了什么 / 我们做到哪一步」：`operations-matrix`。
4. 查原始值：`data/<app>/catalog-*.md`（按问题找答案的总表在 `method` §5）。

## 回写规则

- 本层与 `docs/analysis/*` 冲突：以本层为准，并把错误改回结论层。
- 本层与代码冲突：以代码为准（`docs/impl/command-surface` 是我们侧快照）。
- 复跑与校验命令、已知空白、`_work` scratch 的关系：见 `method` §8 与 §6。
