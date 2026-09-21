/**
 * Link checker for the archive: every relative `](xxx.md)` or `` `NN-xxx.md` ``
 * mention inside a documentation folder must point at a file that exists.
 *
 * Why: the docs were written by several authors in parallel, and one of them
 * published a table of contents with three appendices it never got to write.
 *
 * Usage: node tools/re/check-links.mjs [dir]
 */
import fs from 'node:fs';
import path from 'node:path';

const dir = path.resolve(process.argv[2] ?? 'docs/08-官方APK全量逆向档案');
const files = fs.readdirSync(dir).filter((f) => f.endsWith('.md'));
let checked = 0;
const broken = [];

for (const f of files) {
  const text = fs.readFileSync(path.join(dir, f), 'utf8');
  const refs = new Set();
  for (const m of text.matchAll(/\]\(([^)\s#]+\.md)[)#]/g)) refs.add(m[1]);
  for (const m of text.matchAll(/`(\d\d-[^`\n]{2,120}\.md)`/g)) refs.add(m[1]);
  for (const m of text.matchAll(/见 (0\d-[^`\s，。;；)]+\.md)/g)) refs.add(m[1]);
  for (const r of refs) {
    if (/^https?:/.test(r)) continue;
    checked++;
    if (!fs.existsSync(path.join(dir, r))) broken.push([f, r]);
  }
}

console.log(`目录 ${path.relative(process.cwd(), dir)}：${files.length} 个文档，${checked} 条内部链接`);
if (broken.length) {
  for (const [from, to] of broken) console.log(`  断链: ${from} -> ${to}`);
  process.exit(1);
}
console.log('  全部可达。');
