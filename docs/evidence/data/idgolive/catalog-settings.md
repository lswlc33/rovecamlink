# idGoLive — 选项数组配对表（UI 文案 ↔ 协议值）

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 组 `*_entries` / `*_values` 配对，展开成 9 行
> 官方设置页就是按位置索引把 label 映射到 value 的：这一张表给出「界面上那个选项」对应的「真正发给相机的值」
> 中文列只在 `values-zh-rCN`/`values-zh` 与默认文本不同时才有值

---

| 设置组（数组基名） | labels 资源名 | 序号 | 界面文案（默认语言） | 协议值 | 中文文案 |
|---|---|---|---|---|---|
| pref_example_list | pref_example_list_titles | 0 | Always | 1 |  |
| pref_example_list | pref_example_list_titles | 1 | When possible | 0 |  |
| pref_example_list | pref_example_list_titles | 2 | Never | -1 |  |
| pref_sync_frequency | pref_sync_frequency_titles | 0 | 15 minutes | 15 |  |
| pref_sync_frequency | pref_sync_frequency_titles | 1 | 30 minutes | 30 |  |
| pref_sync_frequency | pref_sync_frequency_titles | 2 | 1 hour | 60 |  |
| pref_sync_frequency | pref_sync_frequency_titles | 3 | 3 hours | 180 |  |
| pref_sync_frequency | pref_sync_frequency_titles | 4 | 6 hours | 360 |  |
| pref_sync_frequency | pref_sync_frequency_titles | 5 | Never | -1 |  |
