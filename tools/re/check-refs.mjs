/**
 * Reference checker for the docs system: every `docs/<layer>/<slug>` mention — in
 * docs prose, Kotlin comments, tools and the hosted page — must resolve to a real
 * document, and every document must be registered in its layer's README.
 *
 * This is the guard that makes "cite a doc by id" machine-verifiable. The old
 * numbered layout (`docs/04`, `08/03`) died in the 2026-09-26 relayout precisely
 * because nothing could check those shorthands; ids are paths now, so resolution
 * is a filesystem lookup.
 *
 * A `docs/<ref>` mention resolves when ANY of these holds:
 *   - `docs/<ref>.md` exists (a document)
 *   - `docs/<ref>/README.md` exists (a layer index: analysis/design/impl/evidence(/data))
 *   - `docs/<ref>` is a directory (e.g. `docs/evidence/data/tuwin` for `dir/**` prose)
 *   - the mention ends in a wildcard/placeholder (`*`, `**`, `<app>`)
 *
 * Also checks, for every non-index doc under analysis/design/impl/evidence:
 *   - it carries the `**doc-id**` header block
 *   - its layer README mentions it (as `docs/<id>` or `<slug>.md`) — no orphans
 *
 * Usage: node tools/re/check-refs.mjs [dir]   # 默认 docs
 */
import fs from 'node:fs';
import path from 'node:path';

const REPO = process.cwd();
const DOCS = path.join(REPO, 'docs');
const LAYERS = ['analysis', 'design', 'impl', 'evidence'];
const REL = new RegExp(
  `docs\\/(?:${LAYERS.join('|')})(?:\\/[A-Za-z0-9-]+)*\\b`,
  'g',
);
const SKIP_DIRS = new Set(['_work', 'build', '.git', 'node_modules', '_tools', '.kotlin', '.gradle', '.workbuddy', '.zcode', '.trae', 'logs', 'downloads', '相机 app']);
// files whose text mentions old/new paths by design
const SKIP_FILES = new Set(['tools/re/oneoffs/relayout.mjs']);
const TEXT_EXT = new Set(['.md', '.kt', '.kts', '.mjs', '.html', '.java', '.yml', '.py']);

const norm = (p) => p.replace(/\\/g, '/');
const rel = (p) => norm(path.relative(REPO, p));

function walk(dir, out = []) {
  for (const e of fs.readdirSync(dir, { withFileTypes: true })) {
    const p = path.join(dir, e.name);
    if (e.isDirectory()) {
      if (SKIP_DIRS.has(e.name)) continue;
      walk(p, out);
    } else if (TEXT_EXT.has(path.extname(e.name))) {
      out.push(p);
    }
  }
  return out;
}

/** Can a `docs/<ref>` mention be resolved? `mention` includes the `docs/` prefix. */
function resolves(mention) {
  if (/\*$/.test(mention) || /<app>$/.test(mention)) return true; // wildcard / placeholder prose
  const ref = mention.replace(/^docs\//, '');
  const base = path.join(REPO, 'docs', ref);
  if (ref.endsWith('.md')) return fs.existsSync(base);
  if (fs.existsSync(path.join(base, 'README.md'))) return true; // layer index
  if (fs.existsSync(base) && fs.statSync(base).isDirectory()) return true; // dir/** prose
  return fs.existsSync(`${base}.md`);
}

/** The .md file a mention points at (null for layer dirs / unresolved — no § check there). */
function targetFile(mention) {
  const ref = mention.replace(/^docs\//, '');
  if (/\*$/.test(ref) || /<app>$/.test(ref)) return null;
  const base = path.join(REPO, 'docs', ref);
  if (ref.endsWith('.md')) return fs.existsSync(base) ? base : null;
  if (fs.existsSync(`${base}.md`)) return `${base}.md`;
  if (fs.existsSync(path.join(base, 'README.md'))) return path.join(base, 'README.md');
  return null;
}

/**
 * Section numbers this document actually declares, from its ATX headings:
 * `## 8. 复跑` → "8", `### 8.4 域名` → "8.4", `### C.9 …` → "C.9".
 * Prose may cite a deeper level than the headings go (e.g. §5.2.2 where the
 * heading is 5.2), so a citation passes if a heading number equals it or is a
 * boundary-prefix of it — but a number with no matching prefix fails.
 */
const headingCache = new Map();
function sectionNumbers(file) {
  if (headingCache.has(file)) return headingCache.get(file);
  const nums = new Set();
  // /\r?\n/: the docs are CRLF on disk, and `$` never matches before a \r.
  for (const line of fs.readFileSync(file, 'utf8').split(/\r?\n/)) {
    const h = line.match(/^#{1,6}\s+(.*)$/);
    if (!h) continue;
    const t = h[1].replace(/^附录\s*[A-Za-z]?\s*·?\s*/, '').trim();
    const n = t.match(/^([A-Za-z]?[0-9]+(?:\.[0-9]+)*)\.?(?:\s|（|「|$)/);
    if (n) nums.add(n[1]);
  }
  headingCache.set(file, nums);
  return nums;
}

function sectionExists(file, sec) {
  const nums = sectionNumbers(file);
  if (nums.has(sec)) return true;
  for (const n of nums) {
    if (sec.startsWith(n + '.')) return true; // deeper citation into an existing section
  }
  return false;
}

const files = walk(REPO).filter((f) => !SKIP_FILES.has(rel(f)));
const unresolved = [];
const badSection = [];
const mentions = new Map(); // file -> count of doc-id mentions (for the summary)
const SEC = /§\s*([A-Za-z]?[0-9]+(?:\.[0-9]+)*)/;
// § must be ATTACHED to the mention: directly after it (modulo backticks, spaces and
// closing brackets), or after one short qualifier such as `附录三（传输·OTA·联网）`.
// Anything farther away is prose citing some other document's sections — not ours to judge.
const ATTACHED_SEC = /^(?:[\s`」）)]*|[^（(]{0,12}[（(][^）)]*[）)][\s`」）)]*)§/;

for (const file of files) {
  const text = fs.readFileSync(file, 'utf8');
  let n = 0;
  for (const m of text.matchAll(REL)) {
    n++;
    if (!resolves(m[0])) { unresolved.push([rel(file), m[0]]); continue; }
    // § check: only a section marker still attached to THIS mention (cut the tail at
    // the next `docs/` occurrence on the line).
    const lineEnd = text.indexOf('\n', m.index);
    let tail = text.slice(m.index + m[0].length, lineEnd === -1 ? undefined : lineEnd);
    const nextDoc = tail.indexOf('docs/');
    if (nextDoc !== -1) tail = tail.slice(0, nextDoc);
    if (!ATTACHED_SEC.test(tail)) continue;
    const sec = tail.match(SEC);
    if (!sec) continue; // § at end of line, its number continues on the next line
    const target = targetFile(m[0]);
    if (!target) continue; // layer index / dir / wildcard — nothing to validate against
    if (!sectionExists(target, sec[1])) badSection.push([rel(file), `${m[0]} §${sec[1]}`]);
  }
  if (n) mentions.set(rel(file), n);
}

// ---- per-document checks ---------------------------------------------------
const missingHeader = [];
const orphans = [];

for (const layer of LAYERS) {
  const layerDir = path.join(DOCS, layer);
  const layerReadme = fs.readFileSync(path.join(layerDir, 'README.md'), 'utf8');
  for (const e of fs.readdirSync(layerDir, { withFileTypes: true })) {
    if (!e.isFile() || !e.name.endsWith('.md') || e.name === 'README.md') continue;
    const slug = e.name.replace(/\.md$/, '');
    const docId = `docs/${layer}/${slug}`;
    const p = path.join(layerDir, e.name);
    const head = fs.readFileSync(p, 'utf8').split('\n').slice(0, 8).join('\n');
    if (!head.includes('**doc-id**')) missingHeader.push(rel(p));
    if (!layerReadme.includes(docId) && !layerReadme.includes(e.name)) orphans.push(docId);
  }
  // specs live one level deeper
  const specs = path.join(layerDir, 'specs');
  if (layer === 'design' && fs.existsSync(specs)) {
    for (const e of fs.readdirSync(specs, { withFileTypes: true })) {
      if (!e.isFile() || !e.name.endsWith('.md')) continue;
      const docId = `docs/${layer}/specs/${e.name.replace(/\.md$/, '')}`;
      const p = path.join(specs, e.name);
      const head = fs.readFileSync(p, 'utf8').split('\n').slice(0, 8).join('\n');
      if (!head.includes('**doc-id**')) missingHeader.push(rel(p));
      if (!layerReadme.includes(docId) && !layerReadme.includes(e.name)) orphans.push(docId);
    }
  }
}

console.log(`扫描 ${files.length} 个文件，其中 ${mentions.size} 个含 doc-id 引用，共 ${[...mentions.values()].reduce((a, b) => a + b, 0)} 处`);
if (unresolved.length) {
  for (const [from, ref] of unresolved) console.log(`  未解析: ${from} -> ${ref}`);
}
if (badSection.length) {
  for (const [from, ref] of badSection) console.log(`  § 小节不存在: ${from} -> ${ref}`);
}
if (missingHeader.length) for (const f of missingHeader) console.log(`  缺 doc-id 头部块: ${f}`);
if (orphans.length) for (const id of orphans) console.log(`  层索引未登记（孤儿文档）: ${id}`);
if (unresolved.length || badSection.length || missingHeader.length || orphans.length) process.exit(1);
console.log('  全部 doc-id 与 § 小节可解析，层索引无遗漏。');
