/**
 * Native library reader: parses the ELF32/ELF64 headers of every lib/<abi>/*.so
 * in the APK and reports sections, dependencies and symbol tables, plus the
 * strings inside that carry protocol evidence (URLs, IPs, paths, syscalls).
 *
 * The camera command paths of all three vendors partly live in native code
 * (idGoLive's PTP/IP stack, TUWIN's FFmpeg/RTSP, XTU's socket framing), so this
 * is the only way to see those values without dynamic instrumentation.
 *
 * Usage: node tools/re/elf.mjs <appKey>
 */
import fs from 'node:fs';
import path from 'node:path';
import { execFileSync } from 'node:child_process';
import { p, exists, walk, writeOut, tsv, mdTable, header, log, isMain, appArg, OUT_WORK } from './lib.mjs';
import { readCentralDirectory } from './apk.mjs';

const SHT = { PROGBITS: 1, SYMTAB: 2, STRTAB: 3, DYNSYM: 11, GNU_HASH: 0x6ffffff6 };

function parseElf(buf) {
  if (buf.length < 64 || buf.readUInt32LE(0) !== 0x464c457f) return null;
  const is64 = buf[4] === 2;
  const le = buf[5] === 1;
  const rd16 = (o) => (le ? buf.readUInt16LE(o) : buf.readUInt16BE(o));
  const rd32 = (o) => (le ? buf.readUInt32LE(o) : buf.readUInt32BE(o));
  const rd64 = (o) => (le ? Number(buf.readBigUInt64LE(o)) : Number(buf.readBigUInt64BE(o)));
  const read = is64 ? rd64 : rd32;
  const e = {
    class: is64 ? 64 : 32,
    little: le,
    type: rd16(16),
    machine: rd16(18),
    entry: read(24),
    shoff: read(40),
    shentsize: rd16(58),
    shnum: rd16(60),
    shstrndx: rd16(62),
  };
  const sections = [];
  let truncated = false;
  if (!Number.isFinite(e.shoff) || e.shoff + e.shnum * e.shentsize > buf.length) {
    truncated = true;
    e.shnum = Math.max(0, Math.floor((buf.length - e.shoff) / e.shentsize));
  }
  for (let i = 0; i < e.shnum; i++) {
    const o = e.shoff + i * e.shentsize;
    sections.push({
      nameOff: rd32(o),
      type: rd32(o + 4),
      flags: read(o + 8),
      addr: read(o + 16),
      offset: read(o + 24),
      size: read(o + 32),
      link: rd32(o + 40),
      entsize: read(o + 56),
    });
  }
  const shstr = sections[e.shstrndx];
  const strAt = (s, off) => {
    const end = buf.indexOf(0, s.offset + off);
    return buf.subarray(s.offset + off, end < 0 ? s.offset + s.size : end).toString('utf8');
  };
  for (const s of sections) s.name = shstr ? strAt(shstr, s.nameOff) : '';
  const byName = new Map(sections.map((s) => [s.name, s]));

  const symbols = [];
  for (const s of sections) {
    if (s.type !== SHT.SYMTAB && s.type !== SHT.DYNSYM) continue;
    const strtab = sections[s.link];
    if (!strtab) continue;
    const entsize = s.entsize || (is64 ? 24 : 16);
    const symEnd = Math.min(s.offset + s.size, buf.length - entsize);
    for (let o = s.offset; o + entsize <= symEnd; o += entsize) {
      const nameIdx = rd32(o);
      const info = buf[o + (is64 ? 4 : 8)];
      const shndx = rd16(o + (is64 ? 6 : 12));
      if (!nameIdx) continue;
      symbols.push({
        section: s.name,
        name: strAt(strtab, nameIdx),
        bind: info >> 4,
        type: info & 0xf,
        defined: shndx !== 0,
        value: read(o + (is64 ? 8 : 4)),
      });
    }
  }

  const needed = [];
  let soname = '';
  const dyn = byName.get('.dynamic');
  if (dyn) {
    const dynstr = byName.get('.dynstr') ?? byName.get('.strtab');
    if (dynstr) {
      const entsize = is64 ? 16 : 8;
      for (let o = dyn.offset; o + entsize <= dyn.offset + dyn.size; o += entsize) {
        const tag = read(o);
        const val = read(o + (is64 ? 8 : 4));
        if (tag === 0) break;
        if (tag === 1) needed.push(strAt(dynstr, val));
        if (tag === 14) soname = strAt(dynstr, val);
      }
    }
  }
  return { e, sections, symbols, needed, soname };
}

/** Printable strings from a binary, like `strings(1)` but in-process. */
function binStrings(buf, min = 5) {
  const out = [];
  let cur = '';
  for (let i = 0; i < buf.length; i++) {
    const c = buf[i];
    if (c >= 32 && c < 127) { cur += String.fromCharCode(c); continue; }
    if (cur.length >= min) out.push(cur);
    cur = '';
  }
  if (cur.length >= min) out.push(cur);
  return out;
}

const INTERESTING = [
  ['url', /^https?:\/\//],
  ['rtsp', /^rtsp:\/\//],
  ['ip', /^(?:\d{1,3}\.){3}\d{1,3}$/],
  ['httpPath', /^\?[\w-]+=[\w-]*&?/],
  ['cgi', /\.cgi/],
  ['filesystem', /^\/(?:sdcard|storage|data|mnt|proc|sys|vendor|tmp)\b/],
  ['socketApi', /^(?:socket|connect|bind|listen|accept|sendto|recvfrom|setsockopt|getsockname|inet_pton|inet_ntop|send|recv)$/],
  ['protocolSymbol', /^(?:ptp|icatch|mtp|ptpip|chdk|rtsp|rtp|h264|aac|soc|hi351|ssc|amba)/],
  ['jpegExif', /^(?:EXIF|Jpeg|APP1|IFD)/],
  ['mdnsDiscovery', /_(?:http|rtsp|ptp|mftp|ipp|tcp|udp)\._tcp|_local$/],
  ['cryptoKey', /^(?:-----BEGIN|[0-9a-f]{16,}$|.*secret.*|.*password.*|.*aes.*)/i],
];

export function run(app) {
  // read the native libraries straight out of the APK: jadx's copy of a
  // store-only entry can be truncated, and we need the real bytes.
  const extractDir = p(OUT_WORK, app.key, 'apk-files');
  const entries = readCentralDirectory(fs.readFileSync(p(app.apk)));
  const abis = [...new Set(entries.filter((e) => e.name.startsWith('lib/') && e.name.endsWith('.so')).map((e) => e.name.split('/')[1]))];
  for (const abi of abis) {
    if (exists(path.join(extractDir, 'lib', abi))) continue;
    fs.mkdirSync(path.join(extractDir, 'lib', abi), { recursive: true });
    // this unzip build's '*' does not cross '/', so enumerate per ABI
    execFileSync('unzip', ['-o', '-q', p(app.apk), `lib/${abi}/*`, '-d', extractDir], { stdio: 'inherit' });
  }
  let libs = walk(path.join(extractDir, 'lib'), (f) => f.endsWith('.so'));
  if (!libs.length) libs = walk(path.join(p(app.resources), 'lib'), (f) => f.endsWith('.so'));
  if (!libs.length) { log(`${app.label}: no .so found`); return; }
  libs = libs.sort();
  const baseDir = libs[0].includes('apk-files') ? extractDir : p(app.resources);

  const rows = [];
  const symbolRows = [];
  const stringRows = [];
  for (const f of libs) {
    const rel = path.relative(baseDir, f).replace(/\\/g, '/');
    const buf = fs.readFileSync(f);
    const parsed = parseElf(buf);
    const strings = binStrings(buf);
    const interesting = new Map();
    for (const s of strings) {
      for (const [cat, re] of INTERESTING) {
        if (!re.test(s)) continue;
        if (s.length > 160) continue;
        if (!interesting.has(cat)) interesting.set(cat, new Set());
        interesting.get(cat).add(s);
      }
    }
    const exported = parsed ? parsed.symbols.filter((s) => s.section === '.dynsym' && s.defined) : [];
    const imports = parsed ? parsed.symbols.filter((s) => s.section === '.dynsym' && !s.defined) : [];
    const jni = exported.filter((s) => s.name.startsWith('Java_')).map((s) => s.name);
    rows.push({
      lib: rel,
      bytes: buf.length,
      elf: parsed ? `${parsed.e.class}-bit ${parsed.e.machine === 183 ? 'AArch64' : parsed.e.machine === 40 ? 'ARM' : parsed.e.machine === 62 ? 'x86_64' : parsed.e.machine === 3 ? 'x86' : 'mach' + parsed.e.machine}` : 'not-elf',
      soname: parsed?.soname ?? '',
      needed: (parsed?.needed ?? []).join(' '),
      exports: exported.length,
      imports: imports.length,
      jni: jni.length,
      strings: strings.length,
    });
    for (const s of exported) symbolRows.push([rel, 'export', s.name]);
    for (const s of imports) symbolRows.push([rel, 'import', s.name]);
    for (const [cat, set] of interesting) for (const v of set) stringRows.push([rel, cat, v]);
  }

  writeOut(app, 'natives.md', [
    header(`${app.label} — 原生库（lib/*.so）全量清点`, [
      `${libs.length} 个 .so；符号与字符串来自 ELF .dynsym / .rodata，直接反映 Java 层看不到的协议实现`,
      '`JNI 导出` 数即该库为 Java 侧提供的 native 方法数量，明细见 `natives-symbols.tsv`',
    ]),
    mdTable(['库', '字节', 'ELF', 'DT_NEEDED', '导出符号', '导入符号', 'JNI 导出', '可读字符串'],
      rows.map((r) => [r.lib, r.bytes.toLocaleString('en-US'), r.elf, r.needed, r.exports, r.imports, r.jni, r.strings])),
    `## 库内协议相关字符串（分类计数）\n`,
    mdTable(['分类', '去重条数', '含义'], [
      ['url', dedupe(stringRows.filter((r) => r[1] === 'url')), '硬编码的 http(s) 端点'],
      ['rtsp', dedupe(stringRows.filter((r) => r[1] === 'rtsp')), 'RTSP 拉流地址模板'],
      ['ip', dedupe(stringRows.filter((r) => r[1] === 'ip')), '点分四元组常量'],
      ['httpPath', dedupe(stringRows.filter((r) => r[1] === 'httpPath')), '查询串'],
      ['cgi', dedupe(stringRows.filter((r) => r[1] === 'cgi')), '.cgi 路径'],
      ['filesystem', dedupe(stringRows.filter((r) => r[1] === 'filesystem')), '文件系统路径'],
      ['socketApi', dedupe(stringRows.filter((r) => r[1] === 'socketApi')), 'libc socket 系列导入'],
      ['protocolSymbol', dedupe(stringRows.filter((r) => r[1] === 'protocolSymbol')), '协议前缀符号（ptp/icatch/rtsp/h264/…）'],
      ['mdnsDiscovery', dedupe(stringRows.filter((r) => r[1] === 'mdnsDiscovery')), 'mDNS/服务发现'],
      ['cryptoKey', dedupe(stringRows.filter((r) => r[1] === 'cryptoKey')), '密钥/口令样式'],
    ]),
    '## 逐条明细（最多每类每库 400 条，全量见 natives-strings.tsv）\n',
    ...groupDetail(stringRows),
  ].join('\n'), { docs: true });

  writeOut(app, 'natives-symbols.tsv', tsv(['lib', 'direction', 'symbol'], symbolRows));
  writeOut(app, 'natives-strings.tsv', tsv(['lib', 'category', 'string'], stringRows));
  const jniRows = symbolRows.filter((r) => r[2].startsWith('Java_'));
  writeOut(app, 'natives-jni.md', [
    header(`${app.label} — native 方法（JNI 导出符号）全量`, [
      `共 ${jniRows.length} 个；命名规则 \`Java_<包>_<类>_<方法>\`，下划线即包名里的点，反解后即 Java 声明`,
    ]),
    mdTable(['库', 'JNI 符号'], jniRows.map((r) => [r[0], r[2]])),
  ].join('\n'), { docs: true });
  log(`${app.label}: natives — ${libs.length} 库, ${symbolRows.length} 符号, ${stringRows.length} 兴趣字符串`);
}

function dedupe(list) { return new Set(list.map((r) => r[2])).size; }
function groupDetail(rows) {
  const byCat = new Map();
  for (const [lib, cat, v] of rows) {
    if (!byCat.has(cat)) byCat.set(cat, []);
    byCat.get(cat).push([lib, v]);
  }
  const out = [];
  for (const [cat, list] of [...byCat.entries()].sort((a, b) => a[0].localeCompare(b[0]))) {
    const uniq = [...new Map(list.map((r) => [r[0] + '|' + r[1], r])).values()];
    out.push(`### ${cat}（${uniq.length} 条）\n`);
    out.push(mdTable(['库', '字符串'], uniq.slice(0, 400).sort((a, b) => a[0].localeCompare(b[0]) || a[1].localeCompare(b[1]))));
    if (uniq.length > 400) out.push(`_其余 ${uniq.length - 400} 条见 natives-strings.tsv_\n`);
  }
  return out;
}

if (isMain(import.meta.url)) run(appArg());
