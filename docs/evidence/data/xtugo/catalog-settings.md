# XTU GO — 选项数组配对表（UI 文案 ↔ 协议值）

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 3 组 `*_entries` / `*_values` 配对，展开成 11 行
> 官方设置页就是按位置索引把 label 映射到 value 的：这一张表给出「界面上那个选项」对应的「真正发给相机的值」
> 中文列只在 `values-zh-rCN`/`values-zh` 与默认文本不同时才有值

---

| 设置组（数组基名） | labels 资源名 | 序号 | 界面文案（默认语言） | 协议值 | 中文文案 |
|---|---|---|---|---|---|
| boot_action | boot_action_entries | 0 | Idle | idle | 空闲 |
| boot_action | boot_action_entries | 1 | Record | record | 录像 |
| boot_action | boot_action_entries | 2 | Timelapse Record | recordlapse | 延时录像 |
| boot_action | boot_action_entries | 3 | Loop Record | recordloop | 循环录像 |
| boot_action | boot_action_entries | 4 | Slow Motion | recordslow | 慢速录像 |
| screen_auto_sleep | screen_auto_sleep_entries | 0 | OFF | 0 | 关闭 |
| screen_auto_sleep | screen_auto_sleep_entries | 1 | 1min | 1 | 1分钟 |
| screen_auto_sleep | screen_auto_sleep_entries | 2 | 3min | 3 | 3分钟 |
| screen_auto_sleep | screen_auto_sleep_entries | 3 | 5min | 5 | 5分钟 |
| video_mode | video_mode_entries | 0 | NTSC | NTSC |  |
| video_mode | video_mode_entries | 1 | PAL | PAL |  |
