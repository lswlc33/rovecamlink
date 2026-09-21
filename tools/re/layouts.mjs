/**
 * Layout / menu XML miner: what the user actually sees and taps.
 *
 * For every `res/layout*`, `res/menu*`, `res/xml*` file we record the view classes
 * used, every visible text (android:text / hint / contentDescription / title /
 * tooltipText), the resource ids, and any custom-view class — that is the raw
 * material for reproducing the official UI flows.
 *
 * Works from jadx-decoded res/ when available, otherwise falls back to
 * `aapt2 dump xmltree` using the layout->file map in `resources-dump.txt`.
 *
 * Usage: node tools/re/layouts.mjs <appKey>
 */
import fs from 'node:fs';
import path from 'node:path';
import { execFileSync } from 'node:child_process';
import { p, exists, read, walk, parseXml, writeOut, mdTable, tsv, header, log, isMain, appArg, OUT_WORK } from './lib.mjs';

const TEXT_ATTRS = ['android:text', 'android:hint', 'android:contentDescription', 'android:title', 'android:summary', 'android:tooltipText', 'android:label', 'app:barrierLength'];
const ID_ATTRS = ['android:id', 'android:key', 'android:entryValues'];
const AAPT2 = ['E:/Android/Sdk/build-tools/36.0.0/aapt2.exe', 'E:/Android/Sdk/build-tools/37.0.0/aapt2.exe', 'E:/Android/Sdk/build-tools/34.0.0/aapt2.exe'].find(exists);

function collect(node, out) {
  const name = node.name;
  if (name === 'item' || name === 'TextView' || name === 'Button' || name === 'EditText' || name === 'CheckedTextView' || name === 'RadioButton' || name === 'CheckBox' || name === 'Switch' || name === 'MenuItem' || name.includes('.')) {
    const texts = TEXT_ATTRS.map((a) => node.attrs[a]).filter((v) => v && v !== '');
    const ids = ID_ATTRS.map((a) => node.attrs[a]).filter(Boolean);
    out.views.push(name);
    if (texts.length) out.texts.push(...texts);
    if (ids.length) out.ids.push(...ids);
  }
  for (const c of node.children) collect(c, out);
}

function analyzeXml(text) {
  const doc = parseXml(text);
  const out = { views: [], texts: [], ids: [] };
  for (const c of doc.children) collect(c, out);
  const root = doc.children[0];
  return {
    root: root ? root.name : '',
    views: [...new Set(out.views)],
    texts: [...new Set(out.texts)],
    ids: [...new Set(out.ids)],
  };
}

/** aapt2 xmltree -> same shape (elements + android: attributes). */
function analyzeAapt2Tree(text) {
  const out = { views: [], texts: [], ids: [] };
  let cur = null;
  const lines = text.split(/\r?\n/);
  for (const raw of lines) {
    const el = /^\s*E: ([\w.:-]+)\s/.exec(raw);
    if (el) {
      cur = { name: el[1], attrs: {} };
      out.views.push(el[1]);
      continue;
    }
    const at = /^\s*A: (?:http:\/\/schemas\.android\.com\/apk\/res\/)?android:([\w]+)(?:\(0x[0-9a-f]+\))?=(.*)$/.exec(raw);
    if (at && cur) {
      const raw2 = /\(Raw: "(.*)"\)\s*$/.exec(at[2]);
      const v = (raw2 ? raw2[1] : at[2]).replace(/^"|"$/g, '').trim();
      if (TEXT_ATTRS.includes(`android:${at[1]}`) && v) out.texts.push(v);
      if (ID_ATTRS.includes(`android:${at[1]}`) && v) out.ids.push(v);
    }
  }
  return { root: out.views[0] ?? '', views: [...new Set(out.views)], texts: [...new Set(out.texts)], ids: [...new Set(out.ids)] };
}

function layoutMapFromAapt2Dump(app) {
  const dump = path.join(p(OUT_WORK, app.key), 'resources-dump.txt');
  if (!exists(dump)) return null;
  const map = new Map();
  let type = '';
  let name = '';
  for (const line of read(dump).split(/\r?\n/)) {
    const t = /^\s*type (\S+) id=/.exec(line);
    if (t) { type = t[1]; continue; }
    const r = /^\s*resource 0x[0-9a-f]+ ([\w.-]+)\/([\w.$-]+)/.exec(line);
    if (r) { type = r[1]; name = r[2]; continue; }
    const f = /^\s*\(\S*\) \(file\) (res\/\S+)/.exec(line);
    if (f && /^(layout|menu|xml)$/.test(type)) map.set(`${type}/${name}`, f[1]);
  }
  return map;
}

/** 0x7f… resource id -> "type/name" (and default string value when present). */
function buildIdMap(app) {
  const map = new Map();
  const dump = path.join(p(OUT_WORK, app.key), 'resources-dump.txt');
  if (!exists(dump)) return map;
  let cur = null;
  for (const line of read(dump).split(/\r?\n/)) {
    const r = /^\s*resource 0x([0-9a-f]+) ([\w.-]+)\/([\w.$-]+)/.exec(line);
    if (r) { cur = `0x${r[1]}`; map.set(cur, `${r[2]}/${r[3]}`); continue; }
    const v = /^\(\s*\)\s+"([\s\S]*)"\s*$/.exec(line.trim());
    if (v && cur) map.set(cur, `${map.get(cur)} = ${decodeAapt(v[1]).replace(/\s+/g, ' ').slice(0, 80)}`);
  }
  return map;
}

function resolveRefs(value, idMap) {
  return String(value).replace(/@0x([0-9a-f]{8})/gi, (m, hex) => (idMap.get(`0x${hex}`) ? `@${idMap.get(`0x${hex}`)}` : m));
}

export function run(app) {
  const resDir = path.join(p(app.resources), 'res');
  const rows = [];
  if (exists(resDir)) {
    for (const dir of fs.readdirSync(resDir)) {
      if (!/^(layout|menu|xml)(-|$)/.test(dir)) continue;
      for (const f of walk(path.join(resDir, dir), (x) => x.endsWith('.xml'))) {
        const rel = path.relative(resDir, f).replace(/\\/g, '/');
        const [type, config] = rel.split('/');
        const info = analyzeXml(read(f));
        rows.push({ type, config, name: path.basename(f, '.xml'), ...info });
      }
    }
  } else {
    const map = layoutMapFromAapt2Dump(app);
    if (!map) { log(`!! ${app.label}: no res dir and no resources-dump.txt — run aapt2.mjs first`); return; }
    for (const [key, file] of map) {
      const [type, name] = key.split('/');
      let text = '';
      try {
        text = execFileSync(AAPT2, ['dump', 'xmltree', '--file', file, p(app.apk)], { encoding: 'utf8', maxBuffer: 64 * 1024 * 1024 });
      } catch { continue; }
      const info = analyzeAapt2Tree(text);
      rows.push({ type, config: '(aapt2)', name, ...info });
    }
  }
  const idMap = buildIdMap(app);
  for (const r of rows) {
    r.texts = r.texts.map((t) => resolveRefs(t, idMap));
    r.ids = r.ids.map((t) => resolveRefs(t, idMap));
  }
  rows.sort((a, b) => a.type.localeCompare(b.type) || a.name.localeCompare(b.name));

  const byType = ['layout', 'menu', 'xml'];
  const md = [header(`${app.label} — 布局/菜单/配置 XML 全量解析`, [
    `${rows.length} 个 XML；逐文件列出根元素、用到的控件类、可见文案（android:text/hint/contentDescription/title/summary）与 id/key`,
    '文案若为 `@string/xxx`，其真实文本按 `res-strings-default.md` 与 `res-strings-zh.md` 查表',
  ])];
  for (const type of byType) {
    const list = rows.filter((r) => r.type === type);
    if (!list.length) continue;
    md.push(`## ${type}（${list.length} 个）\n`);
    md.push(mdTable(['名称', '限定符', '根元素/控件', '文案', 'id/key'],
      list.map((r) => [r.name, r.config, r.views.slice(0, 14).join(' ') + (r.views.length > 14 ? ` +${r.views.length - 14}` : ''), r.texts.join(' ｜ ') || '-', r.ids.join(' ') || '-'])));
  }
  writeOut(app, 'layouts.md', md.join('\n'), { docs: true });
  writeOut(app, 'layouts.tsv', tsv(['type', 'config', 'name', 'root', 'views', 'texts', 'ids'],
    rows.map((r) => [r.type, r.config, r.name, r.root, r.views.join(' '), r.texts.join(' ｜ '), r.ids.join(' ')])));
  log(`${app.label}: layouts — ${rows.length} 个 XML（${rows.reduce((s, r) => s + r.texts.length, 0)} 条文案）`);
}

if (isMain(import.meta.url)) run(appArg());
