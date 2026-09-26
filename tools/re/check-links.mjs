/**
 * Link checker for the docs tree: every relative `](xxx.md)` link, `` `NN-xxx.md` ``
 * mention and `docs/…md` path inside documentation must point at a file that exists.
 *
 * Why: the docs were written by several authors in parallel, and one of them
 * published a table of contents with three appendices it never got to write.
 *
 * 2026-09-26 扩展：目录改递归；另报「目标里带空格」的链接（形如 `](xxx.md 附录A（…）)`）——
 * GitHub 会把它当 404，而原来的 `[^)\s#]+` 正则会静默跳过，正好漏掉这一类。
 *
 * Usage: node tools/re/check-links.mjs [dir]   # 默认 docs/evidence
 */
import fs from 'node:fs';
import path from 'node:path';

const root = process.cwd();
const start = path.resolve(process.argv[2] ?? 'docs/evidence');
const rel = (p) => path.relative(root, p).replace(/\\/g, '/');

function walk(dir) {
  const out = [];
  for (const e of fs.readdirSync(dir, { withFileTypes: true })) {
    const p = path.join(dir, e.name);
    if (e.isDirectory()) out.push(...walk(p));
    else if (e.name.endsWith('.md')) out.push(p);
  }
  return out;
}

function exists(target, base) {
  const abs = target.startsWith('docs/') ? path.join(root, target) : path.join(base, target);
  return fs.existsSync(abs);
}

const files = walk(start);
let checked = 0;
const broken = [];
const malformed = [];

for (const file of files) {
  const base = path.dirname(file);
  const text = fs.readFileSync(file, 'utf8');
  const refs = new Set();
  for (const m of text.matchAll(/\]\(([^)\s#]+\.md)[)#]/g)) refs.add(m[1]);
  for (const m of text.matchAll(/`(\d\d-[^`\n]{2,120}\.md)`/g)) refs.add(m[1]);
  for (const m of text.matchAll(/`(docs\/[^`\n]{2,160}?\.md)`/g)) refs.add(m[1]);
  for (const m of text.matchAll(/见 (0\d-[^`\s，。;；)]+\.md)/g)) refs.add(m[1]);
  for (const r of refs) {
    if (/^https?:/.test(r)) continue;
    checked++;
    if (!exists(r, base)) broken.push([rel(file), r]);
  }
  // `](xxx.md "标题")` 是合法的 Markdown 标题，其余「.md 后面还有内容」的都是断链。
  for (const m of text.matchAll(/\]\((\S+\.md)\s+([^)]*)\)/g)) {
    const target = m[1];
    if (/^https?:/.test(target) || /^["']/.test(m[2])) continue;
    malformed.push([rel(file), `${target} ${m[2]}`]);
    if (!exists(target, base)) broken.push([rel(file), target]);
  }
}

console.log(`目录 ${rel(start) || '.'}：${files.length} 个文档，${checked} 条内部链接`);
if (malformed.length) {
  for (const [from, to] of malformed) console.log(`  目标里带空格（GitHub 上会 404）: ${from} -> ${to}`);
}
if (broken.length) {
  for (const [from, to] of broken) console.log(`  断链: ${from} -> ${to}`);
  process.exit(1);
}
if (malformed.length) process.exit(1);
console.log('  全部可达。');
