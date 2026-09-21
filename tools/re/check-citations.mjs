/**
 * Citation checker: verifies that every `File.ext:LINE` reference inside the
 * reverse-engineering docs resolves to a real file that actually has that line.
 *
 * Exists because the whole point of docs/08 is "every value is traceable" — a
 * hallucinated line number is worse than no citation. References may be written
 * as a full repo path (`_work/xtu_src/sources/.../Foo.java:12`) or a suffix
 * (`Foo.java:12`); suffixes are resolved against an index of the corpus, and a
 * reference that matches several files is reported as ambiguous (not wrong).
 *
 * Usage:
 *   node tools/re/check-citations.mjs [path ...]     # default: docs/08-官方APK全量逆向档案
 */
import fs from 'node:fs';
import path from 'node:path';
import { REPO, walk, p } from './lib.mjs';

const REF_RE = /([A-Za-z0-9_$.[\]\-]+\.(?:java|kt|kts|xml|json|tsv|md|so|txt|arsc))[:：](\d+)/g;

const ROOTS = ['_work', 'composeApp', 'docs', 'tools', 'iosApp', 'simulator'];
const SKIP_DIRS = new Set(['apk-files', 'text-assets', 'jadxcache', 'jdextmp', 'build', '.gradle']);

const lineCounts = new Map();
function linesOf(abs) {
  if (lineCounts.has(abs)) return lineCounts.get(abs);
  let n = 1;
  try {
    const fd = fs.openSync(abs, 'r');
    const buf = Buffer.alloc(1 << 20);
    let off = 0;
    const size = fs.fstatSync(fd).size;
    while (off < size) {
      const got = fs.readSync(fd, buf, 0, Math.min(buf.length, size - off), off);
      for (let i = 0; i < got; i++) if (buf[i] === 0x0a) n++;
      off += got;
    }
    fs.closeSync(fd);
  } catch {
    lineCounts.set(abs, -1);
    return -1;
  }
  lineCounts.set(abs, n);
  return n;
}

function buildIndex() {
  const index = new Map();       // basename -> [repo-relative paths]
  for (const root of ROOTS) {
    const abs = p(root);
    if (!fs.existsSync(abs)) continue;
    for (const f of walk(abs, (x) => fs.statSync(x).size < 40 * 1024 * 1024)) {
      const rel = path.relative(REPO, f).replace(/\\/g, '/');
      if ([...SKIP_DIRS].some((s) => rel.includes(`/${s}/`))) continue;
      const base = rel.split('/').pop();
      if (!index.has(base)) index.set(base, []);
      index.get(base).push(rel);
    }
  }
  return index;
}

const index = buildIndex();
const targets = process.argv.slice(2).filter((a) => !a.startsWith('-'));
const roots = targets.length ? targets.map((t) => path.resolve(REPO, t)) : [path.resolve(REPO, 'docs/08-官方APK全量逆向档案')];
const docs = [];
for (const root of roots) {
  if (fs.statSync(root).isDirectory()) docs.push(...walk(root, (f) => f.endsWith('.md')));
  else docs.push(root);
}

let total = 0;
const unresolved = [];
const outOfRange = [];
const ambiguous = [];
const perDoc = new Map();

for (const doc of docs) {
  const text = fs.readFileSync(doc, 'utf8');
  const seen = new Set();
  let m;
  REF_RE.lastIndex = 0;
  while ((m = REF_RE.exec(text))) {
    const ref = m[1];
    const line = Number(m[2]);
    const key = `${ref}:${line}`;
    if (seen.has(key)) continue;
    seen.add(key);
    total++;
    const relDoc = path.relative(REPO, doc).replace(/\\/g, '/');
    perDoc.set(relDoc, (perDoc.get(relDoc) ?? 0) + 1);

    let candidates = [];
    const direct = path.join(REPO, ref);
    if (linesOf(direct) > 0) candidates = [ref];
    else {
      const base = ref.split('/').pop();
      let list = index.get(base) ?? [];
      if (!list.length && base.includes('$')) {
        // jadx names coroutine/lambda files `Outer$method$2.java`; docs sometimes cite
        // them without the enclosing class prefix -> match by suffix.
        list = [...index.entries()].filter(([k]) => k.endsWith(base)).flatMap(([, v]) => v);
      }
      candidates = ref.includes('/') ? list.filter((c) => c.endsWith(ref)) : list;
    }
    if (!candidates.length) { unresolved.push([relDoc, key]); continue; }
    const ok = candidates.some((c) => linesOf(path.join(REPO, c)) >= line);
    if (!ok) {
      const max = Math.max(...candidates.map((c) => linesOf(path.join(REPO, c))));
      outOfRange.push([relDoc, key, max, candidates[0]]);
    }
    if (candidates.length > 1) ambiguous.push([relDoc, key, candidates.length]);
  }
}

console.log(`检查 ${docs.length} 个文档，共 ${total} 条行号引用`);
for (const [doc, n] of [...perDoc.entries()].sort((a, b) => b[1] - a[1])) console.log(`  ${String(n).padStart(5)}  ${doc}`);
const report = (title, list, fmt) => {
  if (!list.length) return;
  console.log(`\n${title}：${list.length} 条`);
  for (const item of list.slice(0, 60)) console.log('  ' + fmt(item));
  if (list.length > 60) console.log(`  …另 ${list.length - 60} 条`);
};
report('路径/文件不存在，无法定位', unresolved, ([d, r]) => `${d} -> ${r}`);
report('行号越界', outOfRange, ([d, r, n, c]) => `${d} -> ${r} (最接近的候选 ${c} 只有 ${n} 行)`);
report('多解（写法只给了文件名或后缀，命中多个同名文件）', ambiguous, ([d, r, n]) => `${d} -> ${r} (${n} 个候选)`);
if (!unresolved.length && !outOfRange.length) console.log('\n全部行号引用可定位。');
process.exit(unresolved.length || outOfRange.length ? 1 : 0);
