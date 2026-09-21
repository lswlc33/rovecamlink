/**
 * Orchestrator: runs every extractor for one or all apps and writes the corpus
 * fingerprint document (APK sha256/sizes, tool versions, per-artefact row counts)
 * that the overview doc links to.
 *
 * Usage:
 *   node tools/re/run-all.mjs            # all three apps
 *   node tools/re/run-all.mjs tuwin      # one app
 */
import fs from 'node:fs';
import path from 'node:path';
import { execFileSync } from 'node:child_process';
import { APPS, p, exists, walk, writeOut, mdTable, header, log, sha256, isMain } from './lib.mjs';
import { run as runApk } from './apk.mjs';
import { run as runManifest } from './manifest.mjs';
import { run as runValues } from './resstrings.mjs';
import { run as runAapt2 } from './aapt2.mjs';
import { run as runAssets } from './assets.mjs';
import { run as runCode } from './code.mjs';
import { run as runElf } from './elf.mjs';
import { run as runLayouts } from './layouts.mjs';

const JADX = '_work/jadx/lib/jadx-1.5.6-all.jar';

function line(cmd, args) {
  try { return execFileSync(cmd, args, { encoding: 'utf8' }).trim().split('\n')[0]; } catch { return '(失败)'; }
}

function countLines(file) {
  return exists(file) ? readCount(file) : 0;
}
function readCount(file) {
  const buf = fs.readFileSync(file);
  let n = 0;
  for (const b of buf) if (b === 0x0a) n++;
  return n;
}

const STEPS = [
  ['apk.mjs', runApk],
  ['manifest + values', (app) => {
    if (exists(p(app.resources, 'res'))) { runManifest(app); runValues(app); }
    else runAapt2(app);            // jadx could not decode this APK — use aapt2
  }],
  ['assets.mjs', runAssets],
  ['code.mjs', runCode],
  ['elf.mjs', runElf],
  ['layouts.mjs', runLayouts],
];

export function runApp(app) {
  console.log(`\n=== ${app.label} (${app.key}) ===`);
  for (const [name, fn] of STEPS) {
    try { fn(app); } catch (err) { log(`!! ${app.key} ${name}: ${err.message}`); }
  }
}

export function main(keys = Object.keys(APPS)) {
  const rows = [];
  for (const key of keys) {
    const app = APPS[key];
    if (!app) { console.error(`unknown app: ${key}`); continue; }
    runApp(app);
    const apkPath = p(app.apk);
    const dir = p('_work/re', key);
    const artefacts = walk(dir).filter((f) => /\.(md|tsv|json)$/.test(f));
    const docsDir = p('docs/08-官方APK全量逆向档案/data', key);
    rows.push({
      label: app.label,
      apkSize: exists(apkPath) ? (fs.statSync(apkPath).size / 1048576).toFixed(1) + ' MiB' : '缺失',
      sha: exists(apkPath) ? sha256(apkPath).slice(0, 16) : '-',
      artefacts: artefacts.length,
      committed: exists(docsDir) ? walk(docsDir).filter((f) => /\.(md|tsv)$/.test(f)).length : 0,
      bytes: artefacts.reduce((s, f) => s + fs.statSync(f).size, 0),
      values: countLines(path.join(dir, 'values-all.tsv')),
      types: countLines(path.join(dir, 'classes-all.tsv')),
      literals: countLines(path.join(dir, 'own-literals.tsv')),
    });
  }
  const jadxVersion = line('java', ['-jar', p(JADX), '--version']);
  writeOut({ key: '_corpus', label: '语料指纹' }, 'corpus.md', [
    header('反编译语料指纹与产出规模', [
      `生成时间：${new Date().toISOString()}`,
      `jadx：${jadxVersion || '1.5.6（_work/jadx）'}`,
      `node：${process.version}`,
      `aapt2：${line('E:/Android/Sdk/build-tools/36.0.0/aapt2.exe', ['version'])}`,
      'APK sha256 取前 16 位；重新取证时先比对此值，确认分析对象没有换包',
    ]),
    mdTable(['App', 'APK 体积', 'sha256(16)', '产出文件', '入库文件', '产出字节', '资源值条目', '类型数', '自有字面量'],
      rows.map((r) => [r.label, r.apkSize, r.sha, r.artefacts, r.committed, r.bytes.toLocaleString('en-US'), r.values, r.types, r.literals])),
    '_注：`产出行数` 统计 scratch 目录；`入库文件` 指 `docs/08-官方APK全量逆向档案/data/<app>/` 下实际提交的附录数。',
  ].join('\n'), { docs: true });
  log('corpus fingerprint written');
}

if (isMain(import.meta.url)) {
  const keys = process.argv.slice(2).filter((a) => !a.startsWith('-'));
  main(keys.length ? keys : Object.keys(APPS));
}
