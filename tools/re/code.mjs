/**
 * Source scanner: turns jadx-decompiled Java into a complete, queryable record
 * of every type, every constant, every method signature, every string literal
 * and every "signal" (URLs, HTTP paths, JSON keys, prefs keys, intents, SQL).
 *
 * Line-oriented + brace-depth tracking rather than a full Java grammar: decompiled
 * code is machine-formatted (one declaration per line, braces balanced), which
 * makes this both robust and fast on 35k files.
 *
 * Outputs (scratch _work/re/<app>/, docs copies noted):
 *   classes-all.tsv        every type in the apk                    (scratch)
 *   own-types.md           per-class API dump for vendor packages   (docs, split by package)
 *   own-constants.tsv      static final fields with literal values   (scratch)
 *   own-methods.tsv        method signatures + annotations           (scratch)
 *   own-literals.tsv       string literals with type/member context  (scratch)
 *   packages.md            package inventory: classes, kind, owner   (docs)
 *   signals-*.md/tsv       mined protocol surface                    (docs)
 *
 * Usage: node tools/re/code.mjs <appKey>
 */
import fs from 'node:fs';
import path from 'node:path';
import { p, exists, walk, writeOut, mdTable, tsv, header, log, isMain, appArg, classifyPkg, NOISE_ANNOTATIONS } from './lib.mjs';

const MOD_RE = /^(public|protected|private|static|final|abstract|synchronized|native|default|strictfp|transient|volatile|bridge|synthetic|)\s*/;
const TYPE_RE = /^((?:(?:public|protected|private|static|final|abstract|strictfp)\s+)*)(class|interface|enum|@interface|record)\s+([\w$]+)([^{;]*)/;
const FIELD_RE = /^((?:(?:public|protected|private|static|final|transient|volatile|synchronized)\s+)*)([\w$.<>\[\],? ]+?)\s+([\w$]+)\s*(?:=\s*(.+?))?\s*;\s*$/;
const METHOD_RE = /^((?:(?:public|protected|private|static|final|abstract|synchronized|native|default|strictfp)\s+)*)(<[^>]*>\s*)?([\w$.<>\[\],? ]+?)\s+([\w$]+)\s*\(([^)]*)\)\s*(?:throws [\w$.,\s]+)?\s*(?:\{|;)\s*$/;
const ENUM_RE = /^\s{2,}([\w$]+)\s*\((.{0,400}?)\)\s*[,;{]?\s*$/;
const ENUM_BARE_RE = /^\s{2,}([\w$]+)\s*(?:\{[\s\S]*\})?\s*([,;])\s*$/;
const ANNOT_RE = /^\s*@([\w$.]+)\s*(\(([^)]*)\))?\s*$/;
const STR_RE = /"(?:[^"\\\n]|\\.)*"/g;

/** Replace comments with spaces and string/char literals with placeholders. */
function mask(src) {
  const literals = [];
  let out = '';
  let i = 0;
  const n = src.length;
  let line = 1;
  while (i < n) {
    const c = src[i];
    const c2 = src[i + 1];
    if (c === '/' && c2 === '/') {
      while (i < n && src[i] !== '\n') { out += ' '; i++; }
      continue;
    }
    if (c === '/' && c2 === '*') {
      while (i < n && !(src[i] === '*' && src[i + 1] === '/')) {
        if (src[i] === '\n') { out += '\n'; line++; } else out += ' ';
        i++;
      }
      out += '  ';
      i += 2;
      continue;
    }
    if (c === '"') {
      let j = i + 1;
      let raw = '';
      while (j < n) {
        if (src[j] === '\\') { raw += src[j] + (src[j + 1] ?? ''); j += 2; continue; }
        if (src[j] === '"') break;
        raw += src[j];
        j++;
      }
      const value = unescapeJava(raw);
      literals.push({ value, line, kind: raw.startsWith('"""') ? 'text' : 'string' });
      out += `\u0000${literals.length - 1}\u0000`;
      line += countNl(raw);
      i = j + 1;
      continue;
    }
    if (c === "'") {
      let j = i + 1;
      let raw = '';
      while (j < n && src[j] !== "'") {
        if (src[j] === '\\') { raw += src[j] + (src[j + 1] ?? ''); j += 2; continue; }
        raw += src[j];
        j++;
      }
      literals.push({ value: raw, line, kind: 'char' });
      out += `\u0000${literals.length - 1}\u0000`;
      i = j + 1;
      continue;
    }
    if (c === '\n') line++;
    out += c;
    i++;
  }
  return { masked: out, literals };
}

function countNl(s) { return (s.match(/\n/g) ?? []).length; }
function unescapeJava(s) {
  return s
    .replace(/\\\r\n/g, '\n')
    .replace(/\\n/g, '\n')
    .replace(/\\r/g, '\r')
    .replace(/\\t/g, '\t')
    .replace(/\\'/g, "'")
    .replace(/\\"/g, '"')
    .replace(/\\\\/g, '\\')
    .replace(/\\u([0-9a-fA-F]{4})/g, (_, h) => String.fromCharCode(parseInt(h, 16)));
}

/** Kotlin @Metadata blobs and other binary literals are noise for a reader. */
function printableLiteral(v) {
  if (!v || v.length > 300) return false;
  return !/[\u0000-\u0008\u000e-\u001f]/.test(v);
}

/** Turn \0<idx>\0 placeholders back into readable literals. */
function resolve(text, literals) {
  if (!text) return '';
  return text.replace(/\u0000(\d+)\u0000/g, (_, idx) => {
    const v = literals[+idx]?.value ?? '';
    return printableLiteral(v) ? JSON.stringify(v) : '"<binary/metadata>"';
  });
}

/** Drop Kotlin compiler metadata annotations, keep the ones that carry meaning. */
function fmtAnnots(list) {
  return list
    .filter((a) => !NOISE_ANNOTATIONS.has(a.name.split('.').pop()))
    .map((a) => `@${a.name}${a.args ? `(${a.args.slice(0, 240)})` : ''}`)
    .join(' ');
}

/** Pull real literal text out of a masked line. */
function literalsOf(maskedLine, literals) {
  const out = [];
  const re = /\u0000(\d+)\u0000/g;
  let m;
  while ((m = re.exec(maskedLine))) out.push(literals[+m[1]].value);
  return out;
}

function lineOfPos(masked, pos) {
  let line = 1;
  for (let i = 0; i < pos; i++) if (masked[i] === '\n') line++;
  return line;
}

function scanFile(file, relPath, rootPkg) {
  const src = fs.readFileSync(file, 'latin1');
  const { masked, literals } = mask(src);
  const lines = masked.split('\n');
  const res = {
    file: relPath,
    pkg: rootPkg,
    imports: [],
    types: [],
    fields: [],
    methods: [],
    enumConsts: [],
    literals: [],
    annotations: [],
  };
  let depth = 0;                 // brace depth
  const frames = [];             // [{typeIdx, openDepth}]
  let current = null;            // fqn index of the type whose body we are in
  let pendingType = null;        // type declared, waiting for its opening brace
  let pendingAnnots = [];

  const adjustDepth = (text) => {
    for (const ch of text) {
      if (ch === '{') {
        if (pendingType !== null) {
          frames.push({ typeIdx: pendingType, openDepth: depth });
          current = pendingType;
          pendingType = null;
        }
        depth++;
      } else if (ch === '}') {
        depth--;
        while (frames.length && frames[frames.length - 1].openDepth >= depth) frames.pop();
        current = frames.length ? frames[frames.length - 1].typeIdx : null;
      }
    }
  };

  for (let li = 0; li < lines.length; li++) {
    const raw = lines[li];
    const line = raw.trim();
    const lineNo = li + 1;
    const lits = literalsOf(raw, literals);
    const ctxType = current !== null ? res.types[current].fqn : res.pkg;
    for (const v of lits) if (printableLiteral(v)) res.literals.push({ type: ctxType, member: null, line: lineNo, value: v });

    if (!line) continue;
    if (line.startsWith('package ') && res.types.length === 0) { res.pkg = line.slice(8).replace(/;.*$/, '').trim(); continue; }
    if (line.startsWith('import ')) { res.imports.push(line.replace(/^import\s+(static\s+)?/, '').replace(/;.*$/, '')); continue; }

    const am = ANNOT_RE.exec(line);
    if (am) {
      const args = resolve(am[3] ?? '', literals).trim();
      pendingAnnots.push({ name: am[1], args, line: lineNo });
      res.annotations.push({ target: ctxType, name: am[1], args, line: lineNo });
      continue;
    }

    const tm = TYPE_RE.exec(line);
    if (tm) {
      const [, mods, kind, name, tail] = tm;
      const outer = current !== null ? res.types[current] : null;
      const fqn = outer ? `${outer.fqn}$${name}` : `${res.pkg}.${name}`;
      const idx = res.types.length;
      res.types.push({
        name, fqn, kind, modifiers: mods.trim(),
        extends: /\bextends\s+([^{]+)/.exec(tail)?.[1]?.trim().replace(/\s+/g, ' ') ?? '',
        implements: /\bimplements\s+([^{]+)/.exec(tail)?.[1]?.trim().replace(/\s+/g, ' ') ?? '',
        line: lineNo, outerIdx: current, depth, annotations: pendingAnnots.splice(0),
      });
      if (outer) (outer.children ??= []).push(idx);
      pendingType = idx;
      adjustDepth(raw);
      continue;
    }

    if (current !== null && res.types[current].kind === 'enum' && !/^(public|private|protected|static)/.test(line)) {
      const em = ENUM_RE.exec(raw);
      const eb = em ? null : ENUM_BARE_RE.exec(raw);
      if (em) res.enumConsts.push({ type: res.types[current].fqn, name: em[1], args: resolve(em[2], literals).trim(), line: lineNo });
      else if (eb) res.enumConsts.push({ type: res.types[current].fqn, name: eb[1], args: '', line: lineNo });
    }

    const mm = METHOD_RE.exec(line);
    if (mm && current !== null && !line.startsWith('new ') && !line.startsWith('return ')) {
      const [, mods, generics, ret, name, params] = mm;
      const idx = res.methods.length;
      res.methods.push({
        type: res.types[current].fqn, name, file: relPath,
        sig: `${ret.trim()} ${name}(${params.replace(/\s+/g, ' ').trim()})`,
        modifiers: mods.trim(), returns: ret.trim(), params: params.replace(/\s+/g, ' ').trim(),
        line: lineNo, annotations: pendingAnnots.splice(0), literals: lits.slice(),
      });
    } else if (current !== null && !line.includes('(') && FIELD_RE.test(line) && !/^(return|else|case|break|continue|throw)\b/.test(line)) {
      const fm = FIELD_RE.exec(line);
      const [, mods, type, name, value] = fm;
      const v = resolve(value ?? '', literals).trim();
      res.fields.push({
        type: res.types[current].fqn, name, javaType: type.trim(), modifiers: mods.trim(), file: relPath,
        value: v, line: lineNo, isConst: /\bstatic\b/.test(mods) && /\bfinal\b/.test(mods),
        annotations: pendingAnnots.splice(0), literals: lits.slice(),
      });
    } else if (pendingAnnots.length) {
      pendingAnnots = [];
    }

    adjustDepth(raw);
  }

  if (src.includes('JADX ERROR')) {
    const owner = res.types[0]?.fqn ?? res.pkg;
    for (const h of harvestBytecode(src)) res.literals.push({ type: owner, member: null, line: h.line, value: h.value, via: 'bytecode' });
  }
  return res;
}

function countBraces(s) {
  let open = 0, close = 0;
  for (const c of s) { if (c === '{') open++; else if (c === '}') close++; }
  return open - close;
}

/**
 * jadx leaves smali-style pseudo-code in `/* JADX ERROR *​/` blocks when a method
 * fails to decompile (e.g. XTU's `IcatchProtocol.getFileList`). The string and
 * integer constants are still readable there — recover them, otherwise the worst-
 * understood methods are exactly the ones with no evidence at all.
 */
function harvestBytecode(src) {
  const found = [];
  const lines = src.split('\n');
  let inside = false;
  for (let i = 0; i < lines.length; i++) {
    const line = lines[i];
    if (line.includes('JADX ERROR')) { inside = true; continue; }
    if (!inside) continue;
    if (/^\s{4}\}/.test(line)) { inside = false; continue; }
    const str = /=\s*"([^"]*)"|const-string(?:\/jumbo)?\s+v[\d., ]*"([^"]*)"/.exec(line);
    const value = str ? unescapeJava((str[1] ?? str[2])) : null;
    if (value !== null && printableLiteral(value)) found.push({ value, line: i + 1 });
    const num = /=\s*(0x[0-9a-fA-F]{1,8}|-?\d{2,})\s*$/.exec(line);
    if (num) {
      const n = /^0x/i.test(num[1]) ? parseInt(num[1], 16) : parseInt(num[1], 10);
      if (Number.isFinite(n) && Math.abs(n) >= 2) found.push({ value: `${num[1]} (${n})`, line: i + 1 });
    }
  }
  return found;
}

/* ------------------------------------------------------------ mining --- */

const SIGNAL_PATTERNS = [
  ['url', /https?:\/\/[^\s"'\\]+/g],
  ['rtsp', /rtsp:\/\/[^\s"'\\]+/g],
  ['host-ip', /(?:\d{1,3}\.){3}\d{1,3}/g],
  ['socket-port', /\b(?:port|PORT)\s*[=:(]\s*(\d{2,5})\b/g],
  ['scheme', /^[a-z][\w+.-]*:\/\/$/i],
];

function isOwn(pkg, ownPackages) {
  const asPath = pkg.replace(/\./g, '/');
  return ownPackages.some((o) => asPath === o || asPath.startsWith(o + '/'));
}

export function run(app) {
  const srcRoot = p(app.sources);
  if (!exists(srcRoot)) { log(`!! ${app.label}: no sources at ${srcRoot}`); return; }
  const files = walk(srcRoot, (f) => /\.(java|kt)$/.test(f));
  log(`${app.label}: scanning ${files.length} source files ...`);

  const allTypes = [];
  const own = [];
  let done = 0;
  for (const f of files) {
    const rel = path.relative(srcRoot, f).replace(/\\/g, '/');
    const rootPkg = rel.split('/').slice(0, -1).join('.');
    const info = scanFile(f, rel, rootPkg);
    done++;
    if (done % 5000 === 0) log(`  ... ${done}/${files.length}`);
    const cls = classifyPkg(info.pkg, app.ownPackages);
    info.cls = cls;
    const mCount = new Map();
    const fCount = new Map();
    for (const m of info.methods) mCount.set(m.type, (mCount.get(m.type) ?? 0) + 1);
    for (const fl of info.fields) fCount.set(fl.type, (fCount.get(fl.type) ?? 0) + 1);
    for (const t of info.types) {
      t.methods = mCount.get(t.fqn) ?? 0;
      t.fields = fCount.get(t.fqn) ?? 0;
      allTypes.push({ ...t, pkg: info.pkg, file: rel, cls });
    }
    if (cls !== 'lib') own.push(info);
  }

  writeOut(app, 'classes-all.tsv', tsv(['owner', 'package', 'type', 'kind', 'modifiers', 'extends', 'implements', 'methods', 'fields', 'file'],
    allTypes.map((t) => [t.cls, t.pkg, t.fqn, t.kind, t.modifiers, t.extends, t.implements, t.methods, t.fields, t.file])));

  const methods = own.flatMap((f) => f.methods);
  const fields = own.flatMap((f) => f.fields);
  const enums = own.flatMap((f) => f.enumConsts);
  const lits = own.flatMap((f) => f.literals.map((l) => ({ ...l, owner: f.cls, file: f.file })));

  writeOut(app, 'own-methods.tsv', tsv(['type', 'modifiers', 'signature', 'line', 'file', 'annotations'],
    methods.map((m) => [m.type, m.modifiers, m.sig, m.line, m.file, fmtAnnots(m.annotations)])));
  writeOut(app, 'own-constants.tsv', tsv(['type', 'name', 'javaType', 'value', 'modifiers', 'isConst', 'line', 'file'],
    fields.map((fl) => [fl.type, fl.name, fl.javaType, fl.value, fl.modifiers, fl.isConst ? 'Y' : '', fl.line, fl.file])));
  writeOut(app, 'own-enum-constants.tsv', tsv(['type', 'name', 'args', 'line'], enums.map((e) => [e.type, e.name, e.args, e.line])));
  writeOut(app, 'own-literals.tsv', tsv(['owner', 'type', 'file', 'line', 'literal', 'via'], lits.map((l) => [l.owner ?? 'OWN', l.type, l.file, l.line, l.value, l.via ?? ''])));

  const fileByType = new Map();
  for (const f of own) for (const t of f.types) fileByType.set(t.fqn, f.file);

  /* ---- per-package summary (docs) ---- */
  const byPkg = new Map();
  for (const t of allTypes) {
    const e = byPkg.get(t.pkg) ?? { pkg: t.pkg, cls: t.cls, classes: 0, methods: 0, fields: 0 };
    e.classes++; e.methods += t.methods; e.fields += t.fields;
    byPkg.set(t.pkg, e);
  }
  const rank = { OWN: 0, UNKNOWN: 1, lib: 2 };
  const pkgs = [...byPkg.values()].sort((a, b) => rank[a.cls] - rank[b.cls] || a.pkg.localeCompare(b.pkg));
  const sub = (cls) => pkgs.filter((x) => x.cls === cls);
  writeOut(app, 'packages.md', [
    header(`${app.label} — 包（package）全量清点`, [
      `${allTypes.length} 个类型 / ${files.length} 个反编译源文件 / ${pkgs.length} 个包`,
      'OWN = 已确认厂商代码；UNKNOWN = 既非厂商包名也非已知库（多为混淆后的应用层），两者都逐类展开在 `api/`；lib = 第三方库/平台代码，仅清点',
    ]),
    `## OWN（${sub('OWN').length} 个包 / ${sub('OWN').reduce((s, x) => s + x.classes, 0)} 个类型）\n`,
    mdTable(['包', '类型数', '方法数', '字段数'], sub('OWN').map((x) => [x.pkg, x.classes, x.methods, x.fields])),
    `## UNKNOWN（${sub('UNKNOWN').length} 个包 / ${sub('UNKNOWN').reduce((s, x) => s + x.classes, 0)} 个类型）\n`,
    mdTable(['包', '类型数', '方法数', '字段数'], sub('UNKNOWN').map((x) => [x.pkg, x.classes, x.methods, x.fields])),
    `## lib（${sub('lib').length} 个包 / ${sub('lib').reduce((s, x) => s + x.classes, 0)} 个类型）\n`,
    mdTable(['包', '类型数', '方法数'], sub('lib').map((x) => [x.pkg, x.classes, x.methods])),
  ].join('\n'), { docs: true });

  /* ---- per-class API dump (docs, split by package prefix, deepened when huge) ---- */
  const GROUP_CAP = 300;                       // types per generated file, roughly
  const segOf = (pkg, depth) => pkg.split('.').slice(0, depth).join('.');
  const bucketByDepth = (list, depth) => {
    const g = new Map();
    for (const info of list) {
      const seg = segOf(info.pkg, depth);
      if (!g.has(seg)) g.set(seg, []);
      g.get(seg).push(info);
    }
    return g;
  };
  const groups = new Map();
  const split = (list, depth) => {
    for (const [seg, fileList] of bucketByDepth(list, depth)) {
      const types = fileList.reduce((s, f) => s + f.types.length, 0);
      if (types > GROUP_CAP && seg.split('.').length < depth + 6) split(fileList, depth + 1);
      else groups.set(seg, fileList);
    }
  };
  split(own, 4);
  let apiBytes = 0;
  for (const [seg, fileList] of groups) {
    const slug = `${seg.replace(/\./g, '__')}`;
    const typeCount = fileList.reduce((s, f) => s + f.types.length, 0);
    const md = [header(`${app.label} — 类与成员明细：${seg}`, [
      `${fileList.length} 个文件 / ${typeCount} 个类型（含内部类）`,
      '每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量',
      '`L<n>` 为 jadx 输出文件内行号，配合源码目录可定位',
    ]), `归属：${[...new Set(fileList.map((f) => f.cls))].join('/')}`];
    const flat = fileList.flatMap((f) => f.types.map((t) => ({ ...t, file: f.file })));
    for (const t of flat.sort((a, b) => a.fqn.localeCompare(b.fqn))) {
      const info = fileList.find((f) => f.file === t.file);
      const tf = info.fields.filter((x) => x.type === t.fqn);
      const tms = info.methods.filter((x) => x.type === t.fqn);
      const tens = info.enumConsts.filter((x) => x.type === t.fqn);
      const myLits = info.literals.filter((x) => x.type === t.fqn);
      const memberLines = [...tf, ...tms].map((x) => x.line).sort((a, b) => a - b);
      md.push([
        `### \`${t.fqn}\``,
        '',
        `L${t.line} · [${t.kind}] ${[t.modifiers, t.name].filter(Boolean).join(' ')}`
          + `${t.extends ? ` · extends \`${t.extends}\`` : ''}`
          + `${t.implements ? ` · implements \`${t.implements}\`` : ''}`
          + ` · \`${t.file}\``,
        t.annotations.length ? `注解：${fmtAnnots(t.annotations)}` : '',
        tf.length ? `\n字段/常量（${tf.length}）：\n` + tf.map((f) => `- \`${f.javaType} ${f.name}${f.value ? ` = ${f.value}` : ''}\`  L${f.line}${f.annotations.length ? ' ' + fmtAnnots(f.annotations) : ''}`).join('\n') : '',
        tens.length ? `\n枚举常量（${tens.length}）：\n` + tens.map((e) => `- \`${e.name}(${e.args})\`  L${e.line}`).join('\n') : '',
        tms.length ? `\n方法（${tms.length}）：\n` + tms.map((m) => {
          const upper = memberLines.find((l) => l > m.line) ?? Infinity;
          const bl = myLits.filter((l) => l.line > m.line && l.line < upper).map((l) => l.value);
          return `- \`${m.sig}\`  L${m.line}${m.annotations.length ? ' ' + fmtAnnots(m.annotations) : ''}`
            + (bl.length ? `\n    - 体内字面量：${bl.map((v) => JSON.stringify(v)).join(' · ')}` : '');
        }).join('\n') : '',
        !tms.length && !tf.length && myLits.length ? `\n字面量：${myLits.map((l) => JSON.stringify(l.value)).join(' · ')}` : '',
        '',
      ].filter((s) => s !== '').join('\n'));
    }
    const text = md.join('\n');
    apiBytes += text.length;
    writeOut(app, `api/${slug}.md`, text, { docs: true });
  }

  /* ---- signal mining across vendor code ---- */
  mine(app, own, fileByType);
  log(`${app.label}: ${allTypes.length} types, ${own.reduce((s, f) => s + f.types.length, 0)} expanded types, ${lits.length} literals, ${methods.length} methods, api ${Math.round(apiBytes / 1024)} KiB`);
}

function outLit(l) {
  return [l.type, path.posix.basename(l.file ?? ''), l.line, l.value];
}

function mine(app, own, fileByType) {
  const ownLit = own.flatMap((f) => f.literals.map((l) => ({ ...l, file: f.file })));
  const uniq = (rows, key) => {
    const m = new Map();
    for (const r of rows) { const k = key(r); if (!m.has(k)) m.set(k, r); }
    return [...m.values()];
  };
  const bucket = {
    httpPaths: ownLit.filter((l) => /^\/[\w\-./?&={}]*$/.test(l.value) && l.value.length > 2),
    fullUrls: ownLit.filter((l) => /https?:\/\/|rtsp:\/\/|rtmp:\/\/|tcp:\/\/|udp:\/\/|file:\/\//.test(l.value)),
    hosts: ownLit.filter((l) => /^(?:[\w-]+\.)+[a-z]{2,}(?::\d+)?(?:\/*\S*)?$/i.test(l.value) && !/\s/.test(l.value) && !l.value.startsWith('/') && l.value.length < 120),
    ips: ownLit.filter((l) => /(?:\d{1,3}\.){3}\d{1,3}/.test(l.value)),
    fsPaths: ownLit.filter((l) => /^(?:\/sdcard|\/storage|\/data|\/mnt|\/sys|\/proc|\/tmp|\/vendor|\/etc|app_|file:)/.test(l.value)),
    cgiCmd: ownLit.filter((l) => /\.cgi|\.cgiset|\.cgiget|custom=1|cmd=\d+|param=|function=|action=/.test(l.value)),
    queryStrings: ownLit.filter((l) => /^\w+=[%$\w[\].,-]*&\w+=/.test(l.value) || /^\?\w+=/.test(l.value)),
    keyLike: ownLit.filter((l) => /^[\w$]{2,64}$/.test(l.value) && /(^|_)(enable|switch|mode|path|url|key|id|name|time|count|size|type|version|ip|port|token|secret|pwd|pass|ssid|uuid|state|result|value|width|height|angle|quality|res|lang|index|level|md5|model|hw|sw|date|sd|gps|mirror|flip|stamp|volume|mic|led|brightness|sleep|freq|format|white|exposure|iso|shutter|bitrate|gop|rotation|timezone|netlight|ap|dhcp)([_0-9]|$)/i.test(l.value)),
    actions: ownLit.filter((l) => /^(?:android\.[a-z]+\.action|com\.[\w.]+\.(?:action|intent|broadcast|permission)|[\w.]+_(?:CLICK|START|STOP|CHANGE|UPDATE)$)/.test(l.value)),
    mime: ownLit.filter((l) => /^[a-z][\w.+-]*\/[a-z0-9.+-]+$/i.test(l.value) && l.value.length < 40),
    exts: ownLit.filter((l) => /^\.[A-Za-z0-9]{2,5}$/.test(l.value)),
    uaSdk: ownLit.filter((l) => /user-?agent|Mozilla\/|^okhttp\//i.test(l.value)),
    hexMagic: ownLit.filter((l) => /^(?:0x)?[0-9a-fA-F]{6,64}$/.test(l.value)),
    wifiSsid: ownLit.filter((l) => /(SSID|ssid|wifi|WLAN|ap_|softap)/i.test(l.value) && l.value.length < 100),
    crypto: ownLit.filter((l) => /(AES|DES|RSA|MD5|SHA-?\d|Base64|Hmac|cipher|secret|password|token)/i.test(l.value) && l.value.length < 120),
  };
  const tables = [];
  for (const [name, rows] of Object.entries(bucket)) {
    const d = uniq(rows.map((r) => ({ ...r, out: outLit(r, fileByType) })), (r) => r.value + '|' + r.type);
    writeOut(app, `signals-${name}.tsv`, tsv(['type', 'file', 'line', 'literal'], d.map((r) => r.out)));
    tables.push([name, d.length]);
  }
  writeOut(app, 'signals-summary.md', [
    header(`${app.label} — 代码内字面量信号清点`, [
      `厂商自有代码字符串字面量 ${ownLit.length} 条，按语义分桶如下（明细见同名 tsv）`,
    ]),
    mdTable(['分桶', '条数', '含义'], tables.map(([n, c]) => [n, c, BUCKET_MEANING[n] ?? ''])),
  ].join('\n'), { docs: true });
  return bucket;
}

const BUCKET_MEANING = {
  httpPaths: '以 / 开头的 HTTP 路径',
  fullUrls: '完整 URL / RTSP / 自定义协议地址',
  hosts: '像域名/主机的字面量',
  ips: '含点分四元组的字面量（默认主机、网关、组播地址）',
  fsPaths: '设备/文件系统路径',
  cgiCmd: 'CGI 命令与查询串（相机 HTTP 控制面）',
  queryStrings: '查询串样式字面量（a=b&c=d）',
  keyLike: '看起来像配置/参数键名的字面量',
  actions: 'Intent action / 广播 / 自定义权限名',
  mime: 'MIME 类型',
  exts: '文件扩展名',
  uaSdk: 'User-Agent / 客户端标识',
  hexMagic: '十六进制魔术值 / 错误码样式',
  wifiSsid: 'SSID / WiFi / AP 相关字面量',
  crypto: '加密、密钥、口令相关字面量',
};

function OUTW(app) { return path.join('_work/re', app.key); }

if (isMain(import.meta.url)) run(appArg());
