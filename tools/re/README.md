# tools/re — 官方 APK 全量提取流水线

把 `相机 app/` 里的三个官方 APK 变成可查询的档案：清单、资源值、assets、类与方法、常量字面值、
字符串字面量、native 符号、布局文案。产出直接落到 `docs/08-官方APK全量逆向档案/data/`（生成物，勿手改），
更大的原始表留在 `_work/re/`（gitignore）。

**用途边界**：仅静态分析自有设备上安装过的官方包，用于互操作（协议/参数/取值）。产出里只记录事实与
常量，不搬运厂商源码；重实现走干净室路线，见 `docs/05` §0 的方法声明。

## 前置条件

| 依赖 | 位置 | 说明 |
|---|---|---|
| Node ≥ 20 | `node -v` | 脚本零第三方依赖 |
| JDK（跑 jadx） | `java -version` | 17 即可 |
| jadx 1.5.6 | `_work/jadx/lib/jadx-1.5.6-all.jar` | 反编译产物在 `_work/{tuwin_src,xtu_src,idgo_live_src}` |
| aapt2 | `E:/Android/Sdk/build-tools/36.0.0/aapt2.exe` | 用环境变量 `AAPT2=<path>` 覆盖 |
| unzip | Git Bash 自带 | 从 APK 里取 `assets/`、`lib/` |

## 语料准备（只需一次）

```sh
export JADX_CACHE_DIR='E:\rovecamlink\_work\jadxcache'   # 别写到 C 盘
export JADX_TMP_DIR='E:\rovecamlink\_work\jdextmp'
java -Xmx4g -jar _work/jadx/lib/jadx-1.5.6-all.jar -j 4 --show-bad-code \
     -d _work/xtu_src "相机 app/XTU GO_8.4.3_243_2026-08-19-17-05-43.apk"
```

`XTU GO` 有 127 个类 jadx 报错，另存一份 `--show-bad-code` 版本在 `_work/xtu_bad/`；
`TUWIN.apk` 的 jadx 资源阶段会卡在 “Resetting disk code cache”，所以它的清单/资源值改走
`aapt2.mjs`，源码仍在 `_work/tuwin_src/`。

## 跑

```sh
node tools/re/run-all.mjs            # 三个 App 全跑
node tools/re/run-all.mjs tuwin      # 只跑一个
node tools/re/code.mjs xtugo         # 只重跑某个提取器
```

`run-all.mjs` 结束时写 `_corpus/corpus.md`：APK 体积、sha256 前 16 位、每家产出行数，
换包/升级版本后先比这张表。

**输出是确定性的**：生成的 md/tsv 里不写时间戳（只有 `corpus.md` 带一行生成时间），所以重跑一遍后
`git diff` 里出现的差异必然是真实的取证差异，而不是噪声。已用 `node tools/re/apk.mjs tuwin` 重跑验证过逐字节一致。

引用可核对性由 `node tools/re/check-citations.mjs [路径…]` 保证：它把文档里所有 `文件:行号` 引用
拿去比对语料，报出「定位不到」和「行号越界」，退出码非 0。默认扫 `docs/08-官方APK全量逆向档案/`。

## 每个提取器

| 脚本 | 输入 | 产出 |
|---|---|---|
| `apk.mjs` | APK 的 ZIP 中央目录 | `apk-entries.md/tsv`：全部条目、压缩方式、大小、CRC32 |
| `manifest.mjs` | jadx 解码的 `AndroidManifest.xml` | `manifest.md`（包/版本/权限/组件/intent-filter/meta-data 全量）、`manifest.json`、`components.tsv` |
| `resstrings.mjs` | jadx 解码的 res values 文件 | `res-strings-default.md`（默认配置全量 string/array/plurals）、`res-strings-zh.md`（中文差异）、`res-locales.md`（语言覆盖矩阵）、`res-inventory.md`、`values-all.tsv` |
| `aapt2.mjs` | `aapt2 dump xmltree` + `dump resources` | 上面两者的兜底（jadx 解不动时），产出形状一致；另存 `manifest-xmltree.txt`、`resources-dump.txt` |
| `assets.mjs` | 直接从 APK 解出的 `assets/` | `assets-index.md`（路径/字节/sha1/文本预览）、`assets-content.md`（小文本 asset 全文）、`text-assets/` |
| `code.mjs` | jadx 源码 | `classes-all.tsv`（全部类型）、`packages.md`（OWN/UNKNOWN/lib 归属）、`api/<包>.md`（逐类：注解、字段字面值、枚举实参、方法签名、方法体内字面量）、`own-constants.tsv`、`own-methods.tsv`、`own-literals.tsv`、`signals-*.tsv` |
| `elf.mjs` | 从 APK 解出的 `lib/*/*.so` | `natives.md`（ELF 类别/DT_NEEDED/符号数）、`natives-symbols.tsv`（全部 .dynsym）、`natives-jni.md`（`Java_*` 导出）、`natives-strings.tsv`（.so 内嵌协议字符串） |
| `layouts.mjs` | jadx 的 res XML，或 `aapt2 dump xmltree` | `layouts.md/tsv`：每个布局/菜单的控件、可见文案（`@0x…` 会回解成 `string/名字`）、id/key |

`code.mjs` 的分类口径写在 `lib.mjs`：`ownPackages` 是确认的厂商包，`LIB_PREFIXES` 是确认的第三方库，
两者都不是的归 `UNKNOWN`（混淆后的应用层）——`UNKNOWN` 和 `OWN` 一样逐类展开，避免漏掉应用层。

## 已知的坑

- Git Bash 的 `unzip`：`*` 不跨 `/`，所以 `lib/*` 匹配不到东西 → `elf.mjs`/`assets.mjs` 按 ABI、按显式文件名列表分批解。
- jadx 复制 store-only 的 `.so` 时可能截断 → ELF 一律从 APK 直接取字节。
- 顶层块注释里别写 `*/`（例如 `res/values*/*.xml`），会提前结束注释导致语法错误。
- Node 的 `require`/`import.meta.url` 比较在 Windows 下要用 `pathToFileURL`（见 `lib.mjs` 的 `isMain`）。
- Kotlin 的 `@Metadata`/`@DebugMetadata` 里全是二进制字面量，已在 `NOISE_ANNOTATIONS` 与
  `printableLiteral()` 里过滤，否则产出会被垃圾淹没。
