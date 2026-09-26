# 实现层（impl）

**这一层写的是我们自己仓库里的实现**：协议方法、实际发出的请求、设置项、日志格式。它随代码演进，**与代码冲突时以代码为准，并回写本文**。

> **doc-id** `impl` · **层** 实现 · **修订** 2026-09-26
> 文档系统 [`docs/README.md`](../README.md)

## 本层文档

| doc-id | 内容 | 状态 |
|---|---|---|
| `docs/impl/diagnostics-log` | 诊断日志系统：`rovdiag/1` 语法、采样与折叠、脱敏、一次排障怎么读 | 随代码演进（代码在 `core/log/`） |
| `docs/impl/command-surface` | 我们已实现的命令面：`CameraProtocol` 逐成员、逐条请求、设置项 id 全集、UI 入口映射、已知不实现清单 | 2026-09-22 盘点快照；§0 有 2026-09-26 复核 |

## 与其它层的关系

- 官方侧「应该实现什么」看 `docs/evidence/operations-matrix`（状态台账）与 `docs/analysis/protocol-matrix`。
- 两侧的差距与落地顺序看 `docs/analysis/ota-and-gaps` §7。
- 本层的两份文档都是**我们自己代码的说明书**，不重复记录官方行为；需要证据时引 `docs/evidence/*`。
