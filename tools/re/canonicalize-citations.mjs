/**
 * Citation canonicaliser: rewrites bare `Foo.java:123` references inside a
 * per-app archive doc into full corpus paths (`_work/xtu_src/sources/.../Foo.java:123`),
 * so every citation names exactly one file. A bare name is ambiguous in this repo:
 * the same class exists in both `xtu_src` and `xtu_bad`, and `BuildConfig.java`
 * exists 209 times.
 *
 * Resolution order for a bare name: the doc's primary source tree, then the
 * decompile-fallback tree, then any other corpus tree. Only a unique hit inside
 * the primary tree is rewritten; otherwise the reference is left alone and
 * reported, so a human (or check-citations.mjs) can decide.
 *
 * Usage: node tools/re/canonicalize-citations.mjs <doc.md> <appKey> [--apply]
 */
import fs from 'node:fs';
import path from 'node:path';
import { p, APPS, walk, log } from './lib.mjs';

const docArg = process.argv[2];
const appKey = process.argv[3];
const apply = process.argv.includes('--apply');
if (!docArg || !appKey || !APPS[appKey]) {
  console.error('usage: node tools/re/canonicalize-citations.mjs <doc.md> <appKey> [--apply]');
  process.exit(2);
}
const app = APPS[appKey];
const TREES = [app.sources, '_work/xtu_bad/sources', '_work/tuwin_src/sources', '_work/idgo_live_src/sources'].filter((t, i, a) => a.indexOf(t) === i);

const byName = new Map();
for (const tree of TREES) {
  const root = p(tree);
  if (!fs.existsSync(root)) continue;
  for (const f of walk(root, (x) => /\.(java|kt)$/.test(x))) {
    const rel = path.relative(root, f).replace(/\\/g, '/');
    const base = rel.split('/').pop();
    if (!byName.has(base)) byName.set(base, []);
    byName.get(base).push(`${tree}/${rel}`);
  }
}

const text = fs.readFileSync(docArg, 'utf8');
const RE = /(?<![\w./-])([A-Za-z0-9_$.[\]-]+\.(?:java|kt))[:：](\d+)/g;
const stats = { rewritten: 0, ambiguous: [], notfound: [], alreadyFull: 0 };

const out = text.replace(RE, (whole, name, line, offset) => {
  let cands = byName.get(name) ?? [];
  if (!cands.length && name.includes('$')) {
    cands = [...byName.entries()].filter(([k]) => k.endsWith(name)).flatMap(([, v]) => v);
  }
  if (!cands.length) { stats.notfound.push(`${name}:${line}`); return whole; }
  // same-line package hint: `com.gku.xtugo.Foo` in the surrounding text pins the tree
  const eol = text.indexOf('\n', offset);
  const lineStart = text.lastIndexOf('\n', offset) + 1;
  const lineText = text.slice(lineStart, eol < 0 ? text.length : eol);
  const hints = [...lineText.matchAll(/\b((?:com|org|cn|io|m|icatch|net|jp|de)(?:\.[\w$]+){2,})\b/g)].map((x) => x[1].replace(/\.[\w$]+$/, ''));
  let narrowed = cands;
  for (const hint of hints) {
    const asPath = hint.replace(/\./g, '/');
    const hit = cands.filter((c) => c.includes(`/${asPath}/`));
    if (hit.length === 1) { narrowed = hit; break; }
    if (hit.length) { narrowed = hit; }
  }
  const primary = narrowed.filter((c) => c.startsWith(app.sources));
  let pick = primary.length === 1 ? primary[0] : narrowed.length === 1 ? narrowed[0] : null;
  if (!pick) {
    // last resort: prefer the candidate under the app's own root package
    const rootPkg = app.appRootPkg;
    const underApp = narrowed.filter((c) => c.includes(`/${rootPkg}/`));
    if (underApp.length === 1) pick = underApp[0];
  }
  if (!pick) { stats.ambiguous.push(`${name}:${line} (${cands.length} 个候选)`); return whole; }
  stats.rewritten++;
  return `${pick}:${line}`;
});

void stats;
if (apply) fs.writeFileSync(docArg, out);
console.log(`${path.basename(docArg)}: 改写 ${stats.rewritten} 条，仍有歧义 ${stats.ambiguous.length} 条，找不到 ${stats.notfound.length} 条${apply ? '' : '（未落盘，加 --apply）'}`);
for (const a of stats.ambiguous.slice(0, 25)) console.log('  歧义:', a);
for (const a of stats.notfound.slice(0, 25)) console.log('  找不到:', a);
