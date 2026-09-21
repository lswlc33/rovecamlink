/**
 * aapt2 fallback path.
 *
 * When a vendor APK cannot be decoded by jadx (its resource stage hangs), aapt2
 * from the Android SDK build-tools still gives us the two things the extractors
 * need: the manifest tree (`dump xmltree --file AndroidManifest.xml`) and every
 * resource value per configuration (`dump resources`).
 *
 * This module converts both into the same intermediate shapes that
 * manifest.mjs / resstrings.mjs emit, so the generated documents are identical
 * regardless of which decoder produced them.
 *
 * Usage: node tools/re/aapt2.mjs <appKey>
 */
import path from 'node:path';
import { execFileSync } from 'node:child_process';
import fs from 'node:fs';
import { p, exists, writeOut, mdTable, header, log, isMain, appArg, OUT_WORK } from './lib.mjs';
import { emitManifest } from './manifest.mjs';
import { emitValues } from './resstrings.mjs';

const AAPT2_CANDIDATES = [
  process.env.AAPT2,
  'E:/Android/Sdk/build-tools/36.0.0/aapt2.exe',
  'E:/Android/Sdk/build-tools/37.0.0/aapt2.exe',
  'E:/Android/Sdk/build-tools/34.0.0/aapt2.exe',
].filter(Boolean);

function aapt2() {
  const found = AAPT2_CANDIDATES.find((c) => exists(c));
  if (!found) throw new Error('aapt2 not found — set AAPT2=<path to aapt2.exe>');
  return found;
}

function dump(args) {
  return execFileSync(aapt2(), ['dump', ...args], { encoding: 'utf8', maxBuffer: 512 * 1024 * 1024 });
}

/* ---------------------------------------------------------- xmltree -> tree */

const NS_URI = 'http://schemas.android.com/apk/res/android';

export function xmltreeToNode(text) {
  const root = { name: '#document', attrs: {}, children: [], text: '' };
  const stack = [{ node: root, indent: -2 }];
  for (const rawLine of text.split(/\r?\n/)) {
    if (!rawLine.trim()) continue;
    const indent = rawLine.match(/^\s*/)[0].length;
    const el = /^E: ([\w.:-]+)\s*(\(line=(\d+)\))?\s*$/.exec(rawLine.trim());
    const at = /^A: (.*?)\((?:0x[0-9a-f]+)\)?=(.*)$/.exec(rawLine.trim());
    if (el) {
      while (stack.length > 1 && stack[stack.length - 1].indent >= indent) stack.pop();
      const node = { name: el[1], attrs: el[3] ? { _line: el[3] } : {}, children: [], text: '' };
      stack[stack.length - 1].node.children.push(node);
      stack.push({ node, indent });
    } else if (at && stack.length > 1) {
      const node = stack[stack.length - 1].node;
      let key = at[1];
      let value = at[2];
      const raw = /\(Raw: "(.*)"\)\s*$/.exec(value);
      if (raw) value = raw[1];
      value = value.replace(/^"|"$/g, '').trim();
      if (key.startsWith('http://schemas.android.com/apk/res/android:')) key = 'android:' + key.slice(NS_URI.length + 1);
      else if (key === 'http://schemas.android.com/apk/res/android') continue;
      node.attrs[key] = decodeAapt(value);
    } else {
      const plain = /^A: ([\w.:-]+)\s*=\s*(.*)$/.exec(rawLine.trim());
      if (plain && stack.length > 1) {
        const node = stack[stack.length - 1].node;
        let value = plain[2];
        const raw = /\(Raw: "(.*)"\)\s*$/.exec(value);
        if (raw) value = raw[1];
        node.attrs[plain[1]] = decodeAapt(value.replace(/^"|"$/g, '').trim());
      }
    }
  }
  return root;
}

function decodeAapt(v) {
  return v
    .replace(/\\n/g, '\n')
    .replace(/\\t/g, '\t')
    .replace(/\\'/g, "'")
    .replace(/\\"/g, '"')
    .replace(/\\(\d{3})/g, (_, o) => String.fromCharCode(parseInt(o, 8)))
    .replace(/\\u([0-9a-fA-F]{4})/g, (_, h) => String.fromCharCode(parseInt(h, 16)));
}

/* ------------------------------------------------------- resources -> rows */

export function parseResourceDump(text) {
  const rows = [];
  let pkg = '';
  let type = '';
  let cur = null;
  for (const line of text.split(/\r?\n/)) {
    const t = line.trim();
    const pkgM = /^Package name=(\S+)/.exec(t);
    if (pkgM) { pkg = pkgM[1]; continue; }
    const typeM = /^type (\S+) id=(\S+) entryCount=(\d+)/.exec(t);
    if (typeM) { type = typeM[1]; cur = null; continue; }
    const resM = /^resource 0x([0-9a-f]+) ([\w.-]+)\/([\w.$-]+)(.*)$/.exec(t);
    if (resM) {
      cur = { id: `0x${resM[1]}`, type: resM[2], name: resM[3] };
      continue;
    }
    const valM = /^\(([^)]*)\)\s*(.*)$/.exec(t);
    if (valM && cur) {
      const cfg = valM[1];
      let v = valM[2];
      let file = '';
      const fileM = /^\(file\) (\S+) type=(\S+)/.exec(v);
      if (fileM) { file = fileM[1]; v = `<file:${fileM[2]}>`; }
      else if (/^@/.test(v)) v = v;
      else {
        const q = /^"([\s\S]*)"$/.exec(v);
        if (q) v = decodeAapt(q[1]);
        const item = /^item\((.*)\)$/.exec(v);
        if (item) v = `item(${item[1]})`;
      }
      rows.push({ ...cur, locale: cfg ? `values-${cfg.replace(/-/g, '-')}` : 'values', value: v.replace(/\s+/g, ' ').trim(), file });
      continue;
    }
  }
  return { pkg, rows };
}

export function run(app) {
  const apk = p(app.apk);
  log(`${app.label}: aapt2 fallback for ${path.basename(apk)}`);
  const work = p(OUT_WORK, app.key);
  fs.mkdirSync(work, { recursive: true });

  const tree = dump(['xmltree', '--file', 'AndroidManifest.xml', apk]);
  fs.writeFileSync(path.join(work, 'manifest-xmltree.txt'), tree);
  const node = xmltreeToNode(tree);
  const manifestEl = node.children.find((c) => c.name === 'manifest');
  if (!manifestEl) { log(`!! ${app.label}: no manifest element in aapt2 output`); return; }
  emitManifest(app, manifestEl, `aapt2 dump xmltree（${app.apk}）`);

  const res = dump(['resources', apk]);
  fs.writeFileSync(path.join(work, 'resources-dump.txt'), res);
  const { rows } = parseResourceDump(res);
  emitValues(app, rows, 'aapt2 dump resources');
  log(`${app.label}: aapt2 — ${rows.length} 条资源值`);
}

if (isMain(import.meta.url)) run(appArg());
