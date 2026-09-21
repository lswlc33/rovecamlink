/**
 * APK container inventory: reads the ZIP central directory of the original APK
 * and emits a complete entry list (name, method, sizes, CRC), plus grouped
 * summaries (dex / resources / native libs / META-INF / unknown).
 *
 * Usage: node tools/re/apk.mjs <appKey>
 */
import fs from 'node:fs';
import path from 'node:path';
import { p, exists, writeOut, mdTable, tsv, header, log, isMain, appArg } from './lib.mjs';

const MB = (n) => (n / 1024 / 1024).toFixed(2);

export function readCentralDirectory(buf) {
  // locate End Of Central Directory record (signature 0x06054b50), search backwards
  let eocd = -1;
  for (let i = buf.length - 22; i >= Math.max(0, buf.length - 66000); i--) {
    if (buf.readUInt32LE(i) === 0x06054b50) { eocd = i; break; }
  }
  if (eocd < 0) throw new Error('EOCD not found — not a zip?');
  let total = buf.readUInt16LE(eocd + 10);
  let cdOffset = buf.readUInt32LE(eocd + 16);
  if (total === 0xffff || cdOffset === 0xffffffff) {
    // ZIP64: find the locator right before the EOCD64
    for (let i = eocd - 20; i >= Math.max(0, eocd - 4000); i--) {
      if (buf.readUInt32LE(i) === 0x07064b50) {
        const cd64 = buf.readBigUInt64LE(i + 8);
        const rec = buf.readBigUInt64LE(Number(cd64) + 4);
        total = Number(buf.readBigUInt64LE(Number(cd64) + 32));
        cdOffset = Number(buf.readBigUInt64LE(Number(cd64) + 48));
        break;
      }
    }
  }
  const METHODS = { 0: 'stored', 1: 'shrunk', 8: 'deflate', 9: 'bzip2', 12: 'lzma', 14: 'zstd' };
  const entries = [];
  let off = cdOffset;
  for (let n = 0; n < total; n++) {
    if (buf.readUInt32LE(off) !== 0x02014b50) break;
    const method = buf.readUInt16LE(off + 10);
    const crc = buf.readUInt32LE(off + 16);
    const comp = buf.readUInt32LE(off + 20);
    const size = buf.readUInt32LE(off + 24);
    const nameLen = buf.readUInt16LE(off + 28);
    const extraLen = buf.readUInt16LE(off + 30);
    const commentLen = buf.readUInt16LE(off + 32);
    let uncomp = size;
    let local = buf.readUInt32LE(off + 42);
    if (uncomp === 0xffffffff || comp === 0xffffffff || local === 0xffffffff) {
      const extra = buf.subarray(off + 46, off + 46 + extraLen);
      for (let e = 0; e + 4 <= extra.length;) {
        const id = extra.readUInt16LE(e);
        const len = extra.readUInt16LE(e + 2);
        if (id === 0x0001 && len >= 8) {
          if (size === 0xffffffff) uncomp = Number(extra.readBigUInt64LE(e + 12));
          if (comp === 0xffffffff) { /* compressed size at +20 if present */ }
        }
        e += 4 + len;
      }
    }
    const name = buf.subarray(off + 46, off + 46 + nameLen).toString('utf8');
    entries.push({ name, method: METHODS[method] ?? `m${method}`, crc: crc.toString(16).padStart(8, '0'), comp, size: uncomp, local });
    off += 46 + nameLen + extraLen + commentLen;
  }
  return entries;
}

function groupOf(name) {
  if (name.endsWith('.dex')) return 'dex';
  if (name.startsWith('lib/')) return 'native (' + name.split('/')[2] + ')';
  if (name.startsWith('assets/')) return 'assets';
  if (name.startsWith('res/')) return 'res';
  if (name === 'resources.arsc') return 'resources.arsc';
  if (name === 'AndroidManifest.xml') return 'AndroidManifest.xml';
  if (name.startsWith('META-INF/services/')) return 'META-INF/services';
  if (name.startsWith('META-INF/')) return 'META-INF';
  if (name.startsWith('kotlin/')) return 'kotlin metadata';
  if (name.endsWith('.version') || name.startsWith('kotlinx/')) return 'kotlin metadata';
  return '其它';
}

export function run(app) {
  const apk = p(app.apk);
  if (!exists(apk)) { log(`!! ${app.label}: missing ${app.apk}`); return; }
  const buf = fs.readFileSync(apk);
  const entries = readCentralDirectory(buf);
  const groups = new Map();
  for (const e of entries) {
    const g = groupOf(e.name);
    const cur = groups.get(g) ?? { g, n: 0, size: 0, comp: 0 };
    cur.n++; cur.size += e.size; cur.comp += e.comp;
    groups.set(g, cur);
  }
  const natives = entries.filter((e) => e.name.startsWith('lib/'));
  const totalSize = entries.reduce((s, e) => s + e.size, 0);

  writeOut(app, 'apk-entries.md', [
    header(`${app.label} — APK 容器全量条目`, [
      `\`${app.apk}\`：${(buf.length / 1024 / 1024).toFixed(1)} MiB，${entries.length} 个条目，解压后 ${(totalSize / 1024 / 1024).toFixed(1)} MiB`,
      'CRC-32 取自 ZIP 中央目录，可用于确认两个 APK 中同名文件是否逐字节一致',
    ]),
    '## 分组统计\n',
    mdTable(['分组', '条目数', '解压后 MiB', '压缩后 MiB'],
      [...groups.values()].sort((a, b) => b.size - a.size).map((x) => [x.g, x.n, MB(x.size), MB(x.comp)])),
    `## 原生库（${natives.length}）\n`,
    mdTable(['ABI 条目', '压缩后 KiB', '解压后 KiB', 'CRC32'],
      natives.sort((a, b) => a.name.localeCompare(b.name)).map((e) => [e.name, MB(e.comp) * 1024 | 0, MB(e.size) * 1024 | 0, e.crc])),
    '## 全部条目\n',
    mdTable(['路径', '压缩方式', '压缩后 B', '解压后 B', 'CRC32'],
      entries.sort((a, b) => a.name.localeCompare(b.name)).map((e) => [e.name, e.method, e.comp, e.size, e.crc])),
  ].join('\n'), { docs: true });

  writeOut(app, 'apk-entries.tsv', tsv(['name', 'method', 'compressed', 'size', 'crc32', 'localHeader'],
    entries.map((e) => [e.name, e.method, e.comp, e.size, e.crc, e.local])));
  log(`${app.label}: apk entries — ${entries.length} (${natives.length} native)`);
}

if (isMain(import.meta.url)) run(appArg());
