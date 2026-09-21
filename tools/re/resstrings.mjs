/**
 * Resource-value extractor: every entry in every res values-<locale> folder, plus
 * the locale coverage matrix and a whole-resource inventory.
 *
 * Two input paths feed the same emitter:
 *   run()        reads jadx-decoded res values XML files
 *   emitValues() is also called by aapt2.mjs with rows parsed from `aapt2 dump resources`
 *
 * Emits
 *   res-strings-default.md  full key/value table of the default configuration
 *   res-strings-zh.md       Chinese overlay (rows that differ from default)
 *   res-locales.md          per-locale coverage counters
 *   res-inventory.md        resource inventory by type / configuration
 *   values-all.tsv          every typed entry, every locale (scratch)
 *
 * Usage: node tools/re/resstrings.mjs <appKey>
 */
import fs from 'node:fs';
import path from 'node:path';
import { p, exists, read, walk, parseXml, children, writeOut, mdTable, tsv, header, log, isMain, appArg } from './lib.mjs';

function textOf(node) {
  let out = node.text;
  for (const c of node.children) out += (c.name === '#cdata' ? c.text : textOf(c));
  return out;
}

const normalize = (v) => v.replace(/\s+/g, ' ').trim();

function parseValuesFile(file) {
  const rows = [];
  const doc = parseXml(read(file));
  for (const res of children(doc, 'resources')) {
    for (const node of res.children) {
      if (node.name === '#cdata' || node.name === '#comment') continue;
      const name = node.attrs.name ?? '';
      if (['string', 'color', 'dimen', 'bool', 'integer', 'fraction'].includes(node.name)) {
        rows.push({ type: node.name, name, value: normalize(textOf(node)), note: node.attrs.translatable === 'false' ? 'translatable=false' : '' });
      } else if (['plurals', 'string-array', 'integer-array', 'array'].includes(node.name)) {
        const items = children(node, 'item').map((i, idx) => {
          const qualifier = i.attrs.quantity ?? i.attrs.name;
          return `${idx}${qualifier !== undefined ? `(${qualifier})` : ''}=${normalize(textOf(i))}`;
        });
        rows.push({ type: node.name, name, value: items.join(' | '), note: '' });
      } else if (node.name === 'style') {
        const items = children(node, 'item').map((i) => `${(i.attrs.name ?? '').replace('android:', '@android:')}=${normalize(textOf(i))}`);
        rows.push({ type: 'style', name, value: items.join('; '), note: node.attrs.parent ? `parent=${node.attrs.parent}` : '' });
      } else if (node.name === 'declare-styleable') {
        rows.push({ type: 'declare-styleable', name, value: children(node, 'attr').map((a) => a.attrs.name).join(','), note: '' });
      } else if (node.name === 'attr' || node.name === 'public') {
        rows.push({ type: node.name, name: name || Object.values(node.attrs).join(' '), value: normalize(JSON.stringify(node.attrs)), note: '' });
      } else if (node.name === 'item') {
        rows.push({ type: `item:${node.attrs.type ?? ''}`, name, value: normalize(textOf(node)), note: Object.entries(node.attrs).filter(([k]) => k !== 'name' && k !== 'type').map(([k, v]) => `${k}=${v}`).join(',') });
      } else {
        rows.push({ type: node.name, name, value: normalize(textOf(node)), note: '' });
      }
    }
  }
  return rows;
}

export function run(app) {
  const resDir = path.join(p(app.resources), 'res');
  if (!exists(resDir)) {
    log(`!! ${app.label}: no ${resDir} — run \`node tools/re/aapt2.mjs ${app.key}\` instead`);
    return;
  }
  const valueDirs = fs.readdirSync(resDir, { withFileTypes: true })
    .filter((d) => d.isDirectory() && d.name.startsWith('values'))
    .map((d) => d.name).sort();
  const all = [];
  for (const dir of valueDirs) {
    for (const file of walk(path.join(resDir, dir), (f) => f.endsWith('.xml'))) {
      for (const row of parseValuesFile(file)) {
        all.push({ ...row, locale: dir, file: path.relative(resDir, file).replace(/\\/g, '/') });
      }
    }
  }
  const files = walk(resDir, () => true).map((f) => path.relative(resDir, f).replace(/\\/g, '/'));
  emitValues(app, all, `jadx 解码：${app.resources}/res`, files);
}

/** Shared emitter for jadx- and aapt2-derived resource rows. */
export function emitValues(app, all, sourceNote, files = null) {
  const localesSeen = [...new Set(all.map((r) => r.locale))].sort();
  const def = all.filter((r) => r.locale === 'values' || r.locale === 'values-default');
  const defStrings = def.filter((r) => ['string', 'plurals', 'string-array', 'integer-array', 'array'].includes(r.type));
  const defMap = new Map(defStrings.map((r) => [`${r.type}:${r.name}`, r.value]));

  const zhDirs = localesSeen.filter((d) => /^values-zh/.test(d));
  const zh = all.filter((r) => zhDirs.includes(r.locale) && defStrings.some((s) => `${s.type}:${s.name}` === `${r.type}:${r.name}`));
  const zhDiff = zh.filter((r) => defMap.get(`${r.type}:${r.name}`) !== r.value);

  writeOut(app, 'res-strings-default.md', [
    header(`${app.label} — 默认配置字符串/数组/复数全量表`, [
      `来源：${sourceNote}`,
      `共 ${defStrings.length} 条（string / plurals / string-array / integer-array / array）`,
      '数组按索引展开为 `0=v0 | 1=v1`，复数按 quantity 展开；语言覆盖见 `res-locales.md`，中文差异见 `res-strings-zh.md`',
    ]),
    mdTable(['类型', '资源名 (R.xxx)', '值'], defStrings.map((r) => [r.type, r.name, r.value])),
  ].join('\n'), { docs: true });

  writeOut(app, 'res-strings-zh.md', [
    header(`${app.label} — 中文（values-zh*）覆盖与差异`, [
      `来源：${sourceNote}`,
      `语言目录：${zhDirs.join(', ') || '（无）'}`,
      `与默认配置同名的中文条目 ${zh.length} 条，其中 ${zhDiff.length} 条与默认文本不同（下表）`,
      '未列出的条目 = 中文环境下直接显示默认（英文）文本',
    ]),
    mdTable(['类型', '资源名', '语言目录', '中文值'], zhDiff.map((r) => [r.type, r.name, r.locale, r.value])),
  ].join('\n'), { docs: true });

  const loc = localesSeen.map((dir) => {
    const rows = all.filter((r) => r.locale === dir && r.type === 'string');
    const defNamed = new Set(def.filter((r) => r.type === 'string').map((r) => r.name));
    let same = 0;
    for (const r of rows) if (defMap.get(`string:${r.name}`) === r.value) same++;
    return { dir, entries: rows.length, covers: rows.filter((r) => defNamed.has(r.name)).length, same, extra: rows.filter((r) => !defNamed.has(r.name)).length };
  });
  writeOut(app, 'res-locales.md', [
    header(`${app.label} — 语言覆盖矩阵`, [
      `来源：${sourceNote}`,
      `values* 配置共 ${localesSeen.length} 个；下表统计 string 条目`,
      '`覆盖` = 该配置重写了多少条默认 string；`与默认相同` = 文本与英文原文一字不差的条数（未翻译或纯符号）',
    ]),
    mdTable(['配置', 'string 条目', `覆盖默认(${def.filter((r) => r.type === 'string').length})`, '与默认相同', '仅该配置存在'],
      loc.map((l) => [l.dir, l.entries, l.covers, l.same, l.extra])),
  ].join('\n'), { docs: true });

  const entriesByType = all.reduce((m, r) => { m[r.type] = (m[r.type] ?? 0) + 1; return m; }, {});
  const idRanges = new Map();
  for (const r of all) {
    if (!r.id) continue;
    const seg = r.id.slice(2, 6);
    idRanges.set(r.type, (idRanges.get(r.type) ?? new Set()).add(seg));
  }
  const sections = [
    header(`${app.label} — 资源全量清点`, [
      `来源：${sourceNote}`,
      `资源条目合计 ${all.length} 条，含所有语言/形态配置`,
      files ? `res/ 文件 ${files.length} 个，逐文件清单见 \`res-files.tsv\`` : '（本 App 由 aapt2 解码，无 res/ 目录级清单；条目 ID 见下）',
    ]),
    '## 按资源类型（所有配置合计）\n',
    mdTable(['类型', '条目数'], Object.entries(entriesByType).sort((a, b) => b[1] - a[1])),
  ];
  if (files) {
    const byType = new Map();
    const byConfig = new Map();
    const byExt = new Map();
    for (const f of files) {
      const type = f.split('/')[0];
      byType.set(type.split('-')[0], (byType.get(type.split('-')[0]) ?? 0) + 1);
      byConfig.set(type, (byConfig.get(type) ?? 0) + 1);
      const ext = path.extname(f) || '(none)';
      byExt.set(ext, (byExt.get(ext) ?? 0) + 1);
    }
    sections.push(
      '## 按资源类型（文件数）\n', mdTable(['类型', '文件数'], [...byType.entries()].sort((a, b) => b[1] - a[1])),
      '## 按目录（类型+限定符）\n', mdTable(['目录', '文件数'], [...byConfig.entries()].sort((a, b) => b[1] - a[1])),
      '## 按扩展名\n', mdTable(['扩展名', '文件数'], [...byExt.entries()].sort((a, b) => b[1] - a[1])),
    );
  }
  writeOut(app, 'res-inventory.md', sections.join('\n'), { docs: true });

  writeOut(app, 'values-all.tsv', tsv(['locale', 'type', 'name', 'value', 'note', 'file'],
    all.map((r) => [r.locale, r.type, r.name, r.value, r.note ?? '', r.file ?? ''])));
  if (files) writeOut(app, 'res-files.tsv', tsv(['path'], files.map((f) => [f])));
  log(`${app.label}: values — ${all.length} 条 / ${localesSeen.length} 配置`);
}

if (isMain(import.meta.url)) run(appArg());
