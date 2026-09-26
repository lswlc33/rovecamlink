# data/ — 机器提取表（生成物）

> ⚠️ **本目录由 `tools/re/` 自动生成，勿手工编辑。** 要改先改提取器，再按 `tools/re/README.md` 重跑：
> `node tools/re/run-all.mjs`（三家全跑，约 3–5 分钟）、`node tools/re/run-all.mjs tuwin`（单家）、
> `node tools/re/code.mjs xtugo`（单个提取器）。
> 输出是确定性的：除 `_corpus/corpus.md` 里一行生成时间外不含时间戳，所以重跑后 `git diff` 里出现的差异必然是真实取证差异。

> **doc-id** `evidence/data` · **层** 证据（生成物）· **修订** 2026-09-26
> 文档系统 [`docs/README.md`](../../README.md) · 本层入口 [`../README.md`](../README.md)

## 目录约定

- `_corpus/corpus.md` — 语料指纹：每家 APK 的体积、sha256 前 16 位、产出与入库规模。**换包 / 升级版本后先比这张表**，确认分析对象没被换掉。
- `tuwin/` `xtugo/` `idgolive/` — 每家一目录。每个文件是什么、`api/<包>.md` 与 `signals-*.tsv` 各装什么，见 [`docs/evidence/method`](../method.md) §4 的目录树。
- 本目录是**入库副本**；更大的原始表（全量字面值、符号表、解出的 `assets/` 与 `lib/`）留在 `_work/re/`（gitignore 的 scratch），需要时按同一份 README 重跑。

## 表怎么读

按问题找答案的总表在 [`docs/evidence/method`](../method.md) §5，这里只列最常用的几条：

| 你想知道 | 先看 |
|---|---|
| 某个 HTTP 路径 / CGI / URL 存不存在 | `catalog-http.md`、`catalog-templates.md`（带格式化槽位的模板） |
| 某个参数有哪些取值 | `catalog-enums.md` + `res-strings-default.md`（entries / values 成对）；设置项绝大多数是设备自描述，别只信静态表 |
| 某个端口 / 超时 / 缓冲区数值 | `catalog-ports.md` → `api/<包>.md` 找调用点 |
| 某条结论的证据 | 档案正文的 `path:line` 引用，照行号读 `_work/<app>_src/sources/…` |
| 这些表还可不可信 | `node tools/re/check-citations.mjs docs`（引用能否定位）+ `node tools/re/check-tables.mjs docs`（表格列数） |

## 边界

只记录事实、常量与控制流描述，不搬运厂商源码，重实现走干净室路线；方法声明见 `docs/analysis/network-api` §0，边界与已知空白见 [`docs/evidence/method`](../method.md) §6。
