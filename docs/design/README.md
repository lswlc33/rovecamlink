# 计划与设计层（design）

**计划是快照，不是承诺。** 本层的文档记录「当时决定做什么、为什么」，落地过程中的偏差不回写原文，而是在文档头部块的状态行里标注；进度以根 `README.md` 的「状态」表为准。

> **doc-id** `design` · **层** 计划与设计 · **修订** 2026-09-26
> 文档系统 [`docs/README.md`](../README.md)

## 本层文档

| doc-id | 内容 | 状态 |
|---|---|---|
| `docs/design/roadmap` | KMP 架构与开发计划：模块划分、协议插件设计、平台边界、风险与路线图 | 2026-09-20 决策快照。§2 的技术选型多数**未采用**（UI 已迁 miuix），文中有 2026-09-24 注 |
| `docs/design/specs/2026-09-25-icatch-http-profiles` | iCatch 系（idGoLive 白标）第一阶段 HTTP 双 profile 插件设计：范围、架构、方法映射、验收 | 已批准并**已落地**（`brand/icatch/IcatchHttpProtocol.kt`） |

## 约定

- 新设计文档放 `specs/`，文件名 `YYYY-MM-DD-主题.md`，H1 写中文标题，头部块写 `doc-id`（即带日期的完整 slug）。
- 设计文档落地后**不删除**：它记录了「为什么这样切」，与 `docs/impl/*` 的实现说明互补。
- 计划里被推翻的判断保留原文 + 一行「⚠️ 注」，不静默改写历史。
