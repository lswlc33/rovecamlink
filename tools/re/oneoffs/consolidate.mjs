/**
 * One-off consolidation: fold each app's prose appendices back into its main
 * dossier so docs/evidence is six readable documents instead of eighteen.
 *
 * The machine-generated tables under data/ are left exactly as they are - several
 * dossiers cite individual `api/com__*.md` files by name, and those references
 * must keep resolving.
 *
 * Usage: node tools/re/consolidate.mjs [--apply]
 */
import fs from 'node:fs';
import path from 'node:path';

const DIR = 'docs/evidence';
const apply = process.argv.includes('--apply');

const MERGES = [
  { into: '01-TUWIN-档案.md', parts: ['01-TUWIN-档案-附录-协议面.md', '01-TUWIN-档案-附录-设置与操作.md', '01-TUWIN-档案-附录-传输OTA与联网.md'] },
  { into: '02-XTUGO-档案.md', parts: ['02-XTUGO-档案-附录-海思CGI全表.md', '02-XTUGO-档案-附录-Ambarella报文全表.md', '02-XTUGO-档案-附录-SigmaStar8080与播放层.md', '02-XTUGO-档案-附录-操作复现表.md', '02-XTUGO-档案-附录-权限组件与域名.md'] },
  { into: '03-idGoLive-档案.md', parts: ['03-idGoLive-档案-附录-PTP属性表.md', '03-idGoLive-档案-附录-HTTP与TCP命令.md', '03-idGoLive-档案-附录-原生层与PTPIP.md', '03-idGoLive-档案-附录-UI与端点判定.md'] },
];
const RENAMES = [['附录A-我们已实现的命令面.md', '05-我们已实现的命令面.md']];

const read = (f) => fs.readFileSync(path.join(DIR, f), 'utf8');
const write = (f, s) => { if (apply) fs.writeFileSync(path.join(DIR, f), s); };

// any appendix file -> the dossier that now contains it
const owner = new Map();
for (const m of MERGES) for (const p of m.parts) owner.set(p, m.into);
for (const [from, to] of RENAMES) owner.set(from, to);

function retarget(text) {
  let n = 0;
  const out = text.replace(/\]\(([^)#\s]+\.md)(#[^)\s]*)?\)/g, (whole, file, anchor) => {
    const base = decodeURIComponent(file.split('/').pop());
    const target = owner.get(base);
    if (!target) return whole;
    n++;
    return `](${target}${anchor ?? ''})`;
  });
  return { out, n };
}

let totalLinks = 0;
for (const m of MERGES) {
  let doc = read(m.into);
  const chunks = [doc.trimEnd()];
  for (const part of m.parts) {
    const body = read(part);
    const firstHeading = body.split('\n').findIndex((l) => l.startsWith('# '));
    const banner = ['', '---', '', `<!-- 以下整段合并自原 ${part}（2026-09-22 文档归并，内容未改） -->`, ''];
    chunks.push(banner.join('\n') + body.split('\n').slice(firstHeading).join('\n').trimEnd());
    if (apply) fs.unlinkSync(path.join(DIR, part));
  }
  let merged = chunks.join('\n') + '\n';
  const { out, n } = retarget(merged);
  merged = out;
  totalLinks += n;
  write(m.into, merged);
  console.log(`${m.into}: +${m.parts.length} 份附录，${(merged.length / 1024) | 0} KiB，改写链接 ${n} 条`);
}

for (const [from, to] of RENAMES) {
  if (apply) fs.renameSync(path.join(DIR, from), path.join(DIR, to));
}

// the remaining standalone docs may still point at files that moved
for (const f of apply ? fs.readdirSync(DIR).filter((x) => x.endsWith('.md')) : []) {
  const text = read(f);
  const { out, n } = retarget(text);
  if (n) { write(f, out); console.log(`  ${f}: 修链接 ${n} 条`); totalLinks += n; }
}
console.log(apply ? '已落盘' : '试运行（未写盘），加 --apply 生效');
