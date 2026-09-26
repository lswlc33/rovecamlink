# 结论层（analysis）

人写的结论：速查表、研究报告、差距分析。**这一层的读者是「想知道结论的人」**，证据在 `docs/evidence/*`，我们自己的实现说明在 `docs/impl/*`。

> **doc-id** `analysis` · **层** 结论 · **修订** 2026-09-26
> 文档系统 [`docs/README.md`](../README.md)

## 本层文档

| doc-id | 内容 | 状态 |
|---|---|---|
| `docs/analysis/apk-overview` | 三家官方 App 的技术栈、值得借鉴的设计、要避开的坑（首次逆向报告，概览） | 概览；取值细节以 `docs/evidence/*` 为准 |
| `docs/analysis/protocol-matrix` | 品牌 → 型号 → 协议能力矩阵：有哪些型号、怎么识别、怎么连、怎么通讯、有哪些设置项 | **速查，权威** |
| `docs/analysis/ota-and-gaps` | 三家固件更新（OTA）的通道、版本比对、变砖护栏，以及我们的功能差距与优先级 | **权威** |
| `docs/analysis/network-api` | 厂商云端 API 清单、可用 / 不可用判定、厂商侧安全缺陷（只用于指导我们不重犯） | **权威** |
| `docs/analysis/ble-and-vpn` | 蓝牙发现 → 唤醒相机热点 → 自动入网的取证，以及 VPN / 代理抢默认网络的机理与对策 | 研究报告；§5 的建议已部分落地 |

## 阅读顺序

1. 想快速了解全貌：`apk-overview` → `protocol-matrix` §0。
2. 要动手接一个新机型：`protocol-matrix` 对应小节 → `docs/evidence/operations-matrix` §5 的落地顺序。
3. 要碰 OTA：`ota-and-gaps` §0（结论先行）→ §6 护栏 → §7 我们的现状。
4. 要调网络 / 连接策略：`ble-and-vpn` §0 与 §4。

## 回写规则

- 本层与 `docs/evidence/*` 冲突：以证据层为准，并把错误改回本层。
- 本层与代码冲突：以代码为准（尤其 `ota-and-gaps` §7 的「现状」段，它按工作区写，会随提交过期）。
