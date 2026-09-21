/**
 * Catalog generator: re-reads the raw scratch tables and emits curated,
 * de-duplicated "every value in one place" documents.
 *
 * These are mechanical listings (no interpretation) whose job is to make sure a
 * human writing the protocol profile can never be told "字符串没读出来":
 *   catalog-http.md      every HTTP path / CGI command / query template + who uses it
 *   catalog-templates.md every literal containing %s/%d/%d format slots (URL & param templates)
 *   catalog-consts.md    every static-final constant with its literal value, per class
 *   catalog-enums.md     every enum constant with its constructor arguments
 *   catalog-ports.md     every numeric literal that plausibly is a port/timeout/size, per class
 *
 * Usage: node tools/re/catalog.mjs <appKey>
 */
import fs from 'node:fs';
import path from 'node:path';
import { p, exists, read, writeOut, mdTable, header, log, isMain, appArg, OUT_WORK } from './lib.mjs';

function rows(file) {
  const full = p(OUT_WORK, file);
  if (!exists(full)) return [];
  const [head, ...body] = read(full).split('\n').filter(Boolean);
  const cols = head.split('\t');
  return body.map((line) => {
    const parts = line.split('\t');
    const o = {};
    cols.forEach((c, i) => { o[c] = parts[i] ?? ''; });
    return o;
  });
}

const isOwn = (r) => r.owner !== 'lib';

export function run(app) {
  const lits = rows(path.join(app.key, 'own-literals.tsv'));
  const consts = rows(path.join(app.key, 'own-constants.tsv'));
  const enums = rows(path.join(app.key, 'own-enum-constants.tsv'));
  const types = rows(path.join(app.key, 'classes-all.tsv'));
  if (!lits.length) { log(`!! ${app.label}: run code.mjs first (no own-literals.tsv)`); return; }

  const typeOwner = new Map(types.map((t) => [t.type, t.owner]));
  const short = (fqn) => fqn.split('.').pop().replace(/\$/g, '.');

  /* ---- http surface ---- */
  const httpish = lits.filter((l) => {
    const v = l.literal;
    return /^\/[\w\-./]*$/.test(v) || /\.cgi|\.json\b|action=|cmd=|param=|custom=1/.test(v) || /^[a-z][\w+.-]*:\/\//i.test(v);
  });
  const seen = new Set();
  const httpRows = [];
  for (const l of httpish) {
    const key = `${l.type}|${l.literal}`;
    if (seen.has(key)) continue;
    seen.add(key);
    httpRows.push([l.literal, short(l.type), `${path.basename(l.file)}:${l.line}`, typeOwner.get(l.type) ?? 'UNKNOWN']);
  }
  httpRows.sort((a, b) => a[0].localeCompare(b[0]));
  writeOut(app, 'catalog-http.md', [
    header(`${app.label} — HTTP/CGI 面全量目录`, [
      `${httpRows.length} 条去重后的路径/命令/URL 字面量（同一常量在多个类里出现会各列一行）`,
      '本目录只保证「不漏」，不解释语义；语义与取值范围见本 App 的档案正文',
    ]),
    mdTable(['字面量', '所在类型', '文件:行', '归属'], httpRows),
  ].join('\n'), { docs: true });

  /* ---- printf-style templates ---- */
  const templates = [...new Map(
    lits.filter((l) => /%[-#0-9.]*[sdxf]/.test(l.literal) && l.literal.length < 200)
      .map((l) => [`${l.type}|${l.literal}`, [l.literal, short(l.type), `${path.basename(l.file)}:${l.line}`]]),
  ).values()].sort((a, b) => a[0].localeCompare(b[0]));
  writeOut(app, 'catalog-templates.md', [
    header(`${app.label} — 带格式化槽位的字面量全量（URL / 报文 / 参数模板）`, [
      `${templates.length} 条。这一张表是「参数值到底怎么拼」的直接证据：%s/%d 的位置就是运行时代码填进去的值`,
    ]),
    mdTable(['模板', '所在类型', '文件:行'], templates),
  ].join('\n'), { docs: true });

  /* ---- constants with literal values ---- */
  const constRows = consts.filter((c) => c.isConst === 'Y' && c.value && !/^(new |R\.)/.test(c.value));
  const byClass = new Map();
  for (const c of constRows) {
    if (!byClass.has(c.type)) byClass.set(c.type, []);
    byClass.get(c.type).push(c);
  }
  writeOut(app, 'catalog-consts.md', [
    header(`${app.label} — 常量字面值全量目录`, [
      `${constRows.length} 个 static final 常量，分布在 ${byClass.size} 个类里；按类分组，值为 jadx 反编译后的字面量`,
      '数值常量是端口/超时/枚举 id/缓冲大小的唯一真相来源；字符串常量常在 `catalog-http.md`/`catalog-templates.md` 里再出现一次',
    ]),
    ...[...byClass.entries()].sort((a, b) => a[0].localeCompare(b[0])).map(([type, list]) => [
      `### \`${type}\``,
      '',
      mdTable(['常量', '类型', '值', '行'], list.sort((x, y) => x.name.localeCompare(y.name)).map((c) => [`\`${c.name}\``, c.javaType, c.value.replace(/\|/g, '\\|'), c.line])),
    ].join('\n')),
  ].join('\n'), { docs: byClass.size < 800 });

  /* ---- enum constants ---- */
  const enumByType = new Map();
  for (const e of enums) {
    if (!enumByType.has(e.type)) enumByType.set(e.type, []);
    enumByType.get(e.type).push(e);
  }
  if (enumByType.size) {
    writeOut(app, 'catalog-enums.md', [
      header(`${app.label} — 枚举常量全量目录`, [
        `${enums.length} 个枚举常量，分布在 ${enumByType.size} 个枚举类型；括号内是构造实参（命令号、端口、路径等）`,
      ]),
      ...[...enumByType.entries()].sort((a, b) => a[0].localeCompare(b[0])).map(([type, list]) => [
        `### \`${type}\``,
        '',
        mdTable(['常量', '实参', '行'], list.map((e) => [`\`${e.name}\``, e.args, e.line])),
      ].join('\n')),
    ].join('\n'), { docs: true });
  }

  /* ---- plausible port / timeout / size numbers ---- */
  const numeric = consts.filter((c) => c.isConst === 'Y' && /^-?(0x[0-9a-fA-F]+|\d+)$/.test(c.value));
  const interesting = numeric.filter((c) => {
    const n = /^(0x)/i.test(c.value) ? parseInt(c.value, 16) : parseInt(c.value, 10);
    if (!Number.isFinite(n)) return false;
    const name = c.name.toLowerCase();
    return (n >= 1 && n <= 65535 && /(port|timeout|size|max|min|count|len|id|code|retry|delay|interval|flag|mode|cmd)/.test(name))
      || (Math.abs(n) > 1000 && Math.abs(n) < 100000);
  });
  writeOut(app, 'catalog-ports.md', [
    header(`${app.label} — 数值常量目录（端口 / 超时 / 大小 / 命令号）`, [
      `筛选自 ${numeric.length} 个数值常量，命中 ${interesting.length} 个：名字含 port/timeout/size/max/min/count/len/id/code/retry/delay/interval/flag/mode/cmd，或量级在 1e3–1e5`,
      '十六进制按原样保留，另附十进制，便于和错误码（如 0xFFFFF752 = -2222）对表',
    ]),
    mdTable(['类型', '常量', '值(十六/十)', '归属'],
      [...new Map(interesting.map((c) => [`${c.type}|${c.name}`, [short(c.type), `\`${c.name}\``, `${c.value} = ${/^(0x)/i.test(c.value) ? parseInt(c.value, 16) : c.value}`, typeOwner.get(c.type) ?? 'UNKNOWN']])).values()]
        .sort((a, b) => a[0].localeCompare(b[0]) || a[1].localeCompare(b[1]))),
  ].join('\n'), { docs: true });

  /* ---- settings option pairs: <name>_entries / <name>_values ---- */
  const valuesAll = rows(path.join(app.key, 'values-all.tsv'));
  const arr = new Map();                       // name -> {type, locale -> value}
  for (const v of valuesAll) {
    if (!['string-array', 'array', 'integer-array', 'plurals'].includes(v.type)) continue;
    const key = `${v.type}:${v.name}`;
    if (!arr.has(key)) arr.set(key, {});
    arr.get(key)[v.locale] = v.value;
  }
  const zhLocale = (name) => {
    for (const loc of ['values-zh-rCN', 'values-zh']) if (arr.get(name)?.[loc]) return loc;
    return null;
  };
  const pairs = [];
  for (const key of arr.keys()) {
    const name = key.split(':')[1];
    const base = name.replace(/_(entries|labels|options|titles|summaries|values|keys)$/, '');
    if (base === name) continue;                       // not an *_entries/*_values pair
    const isLabels = !/_(values|keys)$/.test(name);
    if (!isLabels) continue;                            // emit one row group per labels array
    let valueKey = null;
    for (const cand of [`array:${base}_values`, `string-array:${base}_values`, `integer-array:${base}_values`]) {
      if (arr.has(cand)) { valueKey = cand; break; }
    }
    const splitItems = (s) => (s ?? '').split(' | ').map((x) => {
      const i = x.indexOf('=');
      return { idx: x.slice(0, i), text: x.slice(i + 1) };
    });
    const labels = splitItems(arr.get(key)?.values);
    const values = valueKey ? splitItems(arr.get(valueKey)?.values) : [];
    const zhKey = zhLocale(key);
    const zhLabels = zhKey ? splitItems(arr.get(key)[zhKey]) : [];
    pairs.push({ base, keyName: name, valueName: valueKey ? valueKey.split(':')[1] : '', labels, values, zhLabels });
  }
  const settingRows = [];
  for (const g of pairs) {
    g.labels.forEach((l, i) => {
      settingRows.push([
        g.base,
        g.keyName,
        l.idx,
        l.text || '(空)',
        g.values[i]?.text ?? '',
        g.zhLabels[i]?.text && g.zhLabels[i].text !== l.text ? g.zhLabels[i].text : '',
      ]);
    });
  }
  if (settingRows.length) {
    writeOut(app, 'catalog-settings.md', [
      header(`${app.label} — 选项数组配对表（UI 文案 ↔ 协议值）`, [
        `${pairs.length} 组 ` + '`*_entries` / `*_values`' + ` 配对，展开成 ${settingRows.length} 行`,
        '官方设置页就是按位置索引把 label 映射到 value 的：这一张表给出「界面上那个选项」对应的「真正发给相机的值」',
        '中文列只在 `values-zh-rCN`/`values-zh` 与默认文本不同时才有值',
      ]),
      mdTable(['设置组（数组基名）', 'labels 资源名', '序号', '界面文案（默认语言）', '协议值', '中文文案'], settingRows),
    ].join('\n'), { docs: true });
  }

  log(`${app.label}: catalog — http ${httpRows.length}, templates ${templates.length}, consts ${constRows.length}, enums ${enums.length}, numeric ${interesting.length}, settings ${settingRows.length}`);
}

if (isMain(import.meta.url)) run(appArg());
