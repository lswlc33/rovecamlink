/**
 * assets/ inventory + inline content capture.
 *
 * Produces
 *   assets-index.md      every asset: path, bytes, sha1, kind, first-line preview (docs)
 *   assets-content.md    full text of every small text asset (docs, truncated per file)
 *   assets/<path>        raw copies of text assets (scratch only)
 *   assets-binary.tsv    the large/binary assets (scratch only)
 *
 * Usage: node tools/re/assets.mjs <appKey>
 */
import fs from 'node:fs';
import path from 'node:path';
import crypto from 'node:crypto';
import { execFileSync } from 'node:child_process';
import { p, exists, walk, writeOut, mdTable, tsv, header, log, isMain, appArg, OUT_WORK } from './lib.mjs';
import { readCentralDirectory } from './apk.mjs';

const TEXT_EXT = new Set(['.json', '.xml', '.txt', '.cfg', '.conf', '.ini', '.properties', '.html', '.htm', '.js', '.css', '.csv', '.yaml', '.yml', '.lua', '.py', '.dic', '.list', '.dat', '.model', '.gradle', '.md', '.tmpl', '.tpl', '.lang', '.keys', '.st']);

function looksTextic(buf) {
  const n = Math.min(buf.length, 1024);
  let weird = 0;
  for (let i = 0; i < n; i++) {
    const c = buf[i];
    if (c === 0) return false;
    if (c < 9 || (c > 13 && c < 32 && c !== 27)) weird++;
  }
  return weird / Math.max(1, n) < 0.02;
}

export function run(app) {
  // assets come out of the APK itself (authoritative bytes), not jadx's copy
  const extractDir = p(OUT_WORK, app.key, 'apk-files');
  const assetsDir = path.join(extractDir, 'assets');
  if (!exists(assetsDir)) {
    const entries = readCentralDirectory(fs.readFileSync(p(app.apk)));
    const names = entries.map((e) => e.name).filter((n) => n.startsWith('assets/') && !n.endsWith('/'));
    fs.mkdirSync(extractDir, { recursive: true });
    for (let i = 0; i < names.length; i += 40) {
      try { execFileSync('unzip', ['-o', '-q', p(app.apk), ...names.slice(i, i + 40), '-d', extractDir], { stdio: 'inherit' }); } catch { /* keep going */ }
    }
  }
  if (!exists(assetsDir)) {
    log(`!! ${app.label}: no assets in ${app.apk}`);
    return;
  }
  const files = walk(assetsDir).sort();
  const rows = [];
  const textFiles = [];
  for (const f of files) {
    const rel = path.relative(assetsDir, f).replace(/\\/g, '/');
    const st = fs.statSync(f);
    if (st.isDirectory()) continue;
    const buf = fs.readFileSync(f);
    const ext = path.extname(f).toLowerCase();
    const isText = (TEXT_EXT.has(ext) || buf.length < 4096) && looksTextic(buf);
    rows.push({
      rel,
      bytes: st.size,
      sha1: crypto.createHash('sha1').update(buf).digest('hex').slice(0, 12),
      kind: isText ? 'text' : 'binary',
      preview: isText ? buf.toString('utf8').replace(/\s+/g, ' ').slice(0, 90) : '',
      file: isText ? f : null,
      buf: isText ? buf : null,
    });
    if (isText) textFiles.push(rel);
  }
  rows.sort((a, b) => a.rel.localeCompare(b.rel));

  writeOut(app, 'assets-index.md', [
    header(`${app.label} — assets/ 全量清单`, [
      `共 ${rows.length} 个文件，合计 ${(rows.reduce((s, r) => s + r.bytes, 0) / 1024 / 1024).toFixed(1)} MiB`,
      `其中文本 ${rows.filter((r) => r.kind === 'text').length} 个（内容内联在 \`assets-content.md\`），二进制 ${rows.filter((r) => r.kind === 'binary').length} 个`,
      'sha1 为前 12 位；重跑可校验一致性',
    ]),
    mdTable(['assets/ 路径', '字节', 'sha1', '类型', '文本首段预览'],
      rows.map((r) => [r.rel, r.bytes.toLocaleString('en-US'), r.sha1, r.kind, r.kind === 'text' ? `\`${r.preview.replace(/`/g, '‘')}\`` : ''])),
  ].join('\n'), { docs: true });

  const MAX_INLINE = 60 * 1024;
  const content = [];
  for (const r of rows) {
    if (r.kind !== 'text') continue;
    let text = r.buf.toString('utf8');
    const truncated = text.length > MAX_INLINE;
    if (truncated) text = text.slice(0, MAX_INLINE);
    content.push([
      `### assets/${r.rel}`,
      '',
      `字节 ${r.bytes}｜sha1 ${r.sha1}${truncated ? `｜**已截断到 ${MAX_INLINE} 字节，全文见 _work/re/${app.key}/assets/${r.rel}**` : ''}`,
      '',
      '```',
      text.replace(/```\s*$/g, '').replace(/^```/g, ''),
      truncated ? '\n… (truncated)' : '',
      '```',
      '',
    ].join('\n'));
    const copy = path.join(p(OUT_WORK, app.key, 'text-assets'), r.rel);
    fs.mkdirSync(path.dirname(copy), { recursive: true });
    fs.writeFileSync(copy, r.buf);
  }
  writeOut(app, 'assets-content.md', [
    header(`${app.label} — assets/ 文本文件全文`, [
      `内联 ${content.length} 个文本 asset；协议相关的菜单/配置定义是 \`docs/analysis/protocol-matrix\` 参数表的一手来源`,
    ]),
    ...content,
  ].join('\n'), { docs: content.length <= 60 });

  writeOut(app, 'assets-binary.tsv', tsv(['path', 'bytes', 'sha1'],
    rows.filter((r) => r.kind === 'binary').map((r) => [r.rel, r.bytes, r.sha1])));
  log(`${app.label}: assets — ${rows.length} 文件 / 文本 ${textFiles.length}`);
}

function OUT(app) {
  return path.join('_work/re', app.key);
}

if (isMain(import.meta.url)) run(appArg());
