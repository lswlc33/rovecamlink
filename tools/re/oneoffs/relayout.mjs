/**
 * One-off docs relayout (2026-09-26): turn the flat `docs/NN-标题.md` pile into a
 * four-layer system, and rewrite every reference to it — docs prose, code comments,
 * tools, the hosted page.
 *
 * Why a script and not hand edits: the old names are referenced from ~250 places across
 * `composeApp/`, `simulator/`, `tools/`, `README.md` and the docs themselves. A missed
 * reference is a stale pointer; this walks the repo instead of trusting an eyeball.
 *
 *   node tools/re/relayout.mjs            # dry run: print the plan
 *   node tools/re/relayout.mjs --apply    # move files, rewrite references
 *
 * The MAPPING table below is also the machine copy of the old→new mapping; the
 * reader-facing copy lives in `docs/README.md`. Generated tables under
 * `docs/evidence/data/` are skipped on purpose — they are regenerated from the
 * updated extractors, not patched in place.
 */
import fs from 'node:fs';
import path from 'node:path';
import { execFileSync } from 'node:child_process';

const REPO = process.cwd();
const apply = process.argv.includes('--apply');
const OLD = 'docs/08-官方APK全量逆向档案';

/** old repo-relative path (file or directory) -> new repo-relative path. */
const MAPPING = [
  ['docs/01-APK逆向分析报告.md', 'docs/analysis/apk-overview.md'],
  ['docs/02-KMP架构与开发计划.md', 'docs/design/roadmap.md'],
  ['docs/03-品牌型号与协议矩阵.md', 'docs/analysis/protocol-matrix.md'],
  ['docs/04-固件更新与功能差距.md', 'docs/analysis/ota-and-gaps.md'],
  ['docs/05-网络API清单与安全评估.md', 'docs/analysis/network-api.md'],
  ['docs/06-诊断日志系统.md', 'docs/impl/diagnostics-log.md'],
  ['docs/07-蓝牙发现与自动连网及VPN共存研究报告.md', 'docs/analysis/ble-and-vpn.md'],
  [`${OLD}/data`, 'docs/evidence/data'],
  [`${OLD}/00-总览与方法.md`, 'docs/evidence/README.md'],
  [`${OLD}/01-TUWIN-档案.md`, 'docs/evidence/tuwin.md'],
  [`${OLD}/02-XTUGO-档案.md`, 'docs/evidence/xtugo.md'],
  [`${OLD}/03-idGoLive-档案.md`, 'docs/evidence/idgolive.md'],
  [`${OLD}/04-三家操作对照与复现清单.md`, 'docs/evidence/operations-matrix.md'],
  [`${OLD}/05-我们已实现的命令面.md`, 'docs/impl/command-surface.md'],
  ['docs/superpowers/specs/2026-09-25-icatch-http-profiles-design.md', 'docs/design/specs/2026-09-25-icatch-http-profiles.md'],
];

/** Literal text rewrites, applied in this order (longest forms first). */
const LITERAL = [
  // bare archive paths (no `docs/` prefix) cited inside code spans
  ['`08-官方APK全量逆向档案/00-总览与方法.md`', '`docs/evidence/README`'],
  ['`08-官方APK全量逆向档案/01-TUWIN-档案.md`', '`docs/evidence/tuwin`'],
  ['`08-官方APK全量逆向档案/02-XTUGO-档案.md`', '`docs/evidence/xtugo`'],
  ['`08-官方APK全量逆向档案/03-idGoLive-档案.md`', '`docs/evidence/idgolive`'],
  ['`08-官方APK全量逆向档案/04-三家操作对照与复现清单.md`', '`docs/evidence/operations-matrix`'],
  ['`08-官方APK全量逆向档案/05-我们已实现的命令面.md`', '`docs/impl/command-surface`'],
  ['`08-官方APK全量逆向档案/data/', '`docs/evidence/data/'],
  ['`08-官方APK全量逆向档案/', '`docs/evidence/'],
  // link labels and prose that still carry the old names (second pass)
  ['[03-品牌型号与协议矩阵](', '[品牌型号与协议矩阵]('],
  ['[01-APK逆向分析报告](', '[APK 逆向分析报告]('],
  ['[08/04 · 三家操作对照与复现清单](', '[三家操作对照]('],
  ['[08/05 · 我们已实现的命令面](', '[我们已实现的命令面]('],
  ['[02-XTUGO-档案.md](', '[XTU GO 档案]('],
  ['[`08-官方APK全量逆向档案/04-三家操作对照与复现清单.md`](', '[三家操作对照]('],
  ['[`08-官方APK全量逆向档案/05-我们已实现的命令面.md`](', '[我们已实现的命令面]('],
  ['[`docs/impl/command-surface · 我们已实现的命令面`](', '[我们已实现的命令面]('],
  ['[`docs/evidence/xtugo · 海思 CGI 全表`](', '[XTU GO 档案]('],
  ['[`docs/evidence/operations-matrix · 三家操作对照与复现清单`](', '[三家操作对照]('],
  // clean up the double backtick the earlier pass left behind
  ['``docs/evidence/xtugo` 附录', '`docs/evidence/xtugo 附录'],
  // archive file names cited inline (backticked first, then bare inside a code span)
  ['`02-XTUGO-档案.md', '`docs/evidence/xtugo'],
  ['`03-idGoLive-档案.md', '`docs/evidence/idgolive'],
  ['`01-TUWIN-档案.md', '`docs/evidence/tuwin'],
  ['`00-总览与方法.md', '`docs/evidence/README'],
  ['`04-三家操作对照与复现清单.md', '`docs/evidence/operations-matrix'],
  ['`05-我们已实现的命令面.md', '`docs/impl/command-surface'],
  ['02-XTUGO-档案.md 附录', 'docs/evidence/xtugo 附录'],
  ['03-idGoLive-档案.md 附录', 'docs/evidence/idgolive 附录'],
  ['01-TUWIN-档案.md 附录', 'docs/evidence/tuwin 附录'],
  ['02-XTUGO-档案.md §', 'docs/evidence/xtugo §'],
  ['03-idGoLive-档案.md §', 'docs/evidence/idgolive §'],
  ['01-TUWIN-档案.md §', 'docs/evidence/tuwin §'],
  ['`docs/design/specs/2026-09-25-icatch-http-profiles-design.md`', '`docs/design/specs/2026-09-25-icatch-http-profiles`'],
  ['2026-09-25-icatch-http-profiles-design.md', '2026-09-25-icatch-http-profiles.md'],
  ['docs/evidence 01-TUWIN-档案.md', 'docs/evidence/tuwin'],
  ['docs/evidence 02-XTUGO-档案.md', 'docs/evidence/xtugo'],
  ['docs/evidence 03-idGoLive-档案.md', 'docs/evidence/idgolive'],
  ['docs/evidence 02-XTUGO ', 'docs/evidence/xtugo '],
  // full paths
  ['docs/01-APK逆向分析报告.md', 'docs/analysis/apk-overview.md'],
  ['docs/02-KMP架构与开发计划.md', 'docs/design/roadmap.md'],
  ['docs/03-品牌型号与协议矩阵.md', 'docs/analysis/protocol-matrix.md'],
  ['docs/04-固件更新与功能差距.md', 'docs/analysis/ota-and-gaps.md'],
  ['docs/05-网络API清单与安全评估.md', 'docs/analysis/network-api.md'],
  ['docs/06-诊断日志系统.md', 'docs/impl/diagnostics-log.md'],
  ['docs/07-蓝牙发现与自动连网及VPN共存研究报告.md', 'docs/analysis/ble-and-vpn.md'],
  [`${OLD}/data/`, 'docs/evidence/data/'],
  [`${OLD}/00-总览与方法.md`, 'docs/evidence/README.md'],
  [`${OLD}/01-TUWIN-档案.md`, 'docs/evidence/tuwin.md'],
  [`${OLD}/02-XTUGO-档案.md`, 'docs/evidence/xtugo.md'],
  [`${OLD}/03-idGoLive-档案.md`, 'docs/evidence/idgolive.md'],
  [`${OLD}/04-三家操作对照与复现清单.md`, 'docs/evidence/operations-matrix.md'],
  [`${OLD}/05-我们已实现的命令面.md`, 'docs/impl/command-surface.md'],
  [`${OLD}/`, 'docs/evidence/'],
  ['docs/superpowers/specs/', 'docs/design/specs/'],
  // number shorthands inside the archive
  ['`08/00', '`docs/evidence'],
  ['`08/01', '`docs/evidence/tuwin'],
  ['`08/02', '`docs/evidence/xtugo'],
  ['`08/03', '`docs/evidence/idgolive'],
  ['`08/04', '`docs/evidence/operations-matrix'],
  ['`08/05', '`docs/impl/command-surface'],
  // top-level number shorthands
  ['docs/01', 'docs/analysis/apk-overview'],
  ['docs/02', 'docs/design/roadmap'],
  ['docs/03', 'docs/analysis/protocol-matrix'],
  ['docs/04', 'docs/analysis/ota-and-gaps'],
  ['docs/05', 'docs/analysis/network-api'],
  ['docs/06', 'docs/impl/diagnostics-log'],
  ['docs/07', 'docs/analysis/ble-and-vpn'],
  ['docs/08', 'docs/evidence'],
  // old basenames still cited without a `docs/` prefix
  ['`01-APK逆向分析报告.md`', '`docs/analysis/apk-overview`'],
  ['`02-KMP架构与开发计划.md`', '`docs/design/roadmap`'],
  ['`03-品牌型号与协议矩阵.md`', '`docs/analysis/protocol-matrix`'],
  ['`04-固件更新与功能差距.md`', '`docs/analysis/ota-and-gaps`'],
  ['`05-网络API清单与安全评估.md`', '`docs/analysis/network-api`'],
  ['`06-诊断日志系统.md`', '`docs/impl/diagnostics-log`'],
  ['`07-蓝牙发现与自动连网及VPN共存研究报告.md`', '`docs/analysis/ble-and-vpn`'],
  ['`00-总览与方法.md`', '`docs/evidence/README`'],
  ['`01-TUWIN-档案.md`', '`docs/evidence/tuwin`'],
  ['`02-XTUGO-档案.md`', '`docs/evidence/xtugo`'],
  ['`03-idGoLive-档案.md`', '`docs/evidence/idgolive`'],
  ['`04-三家操作对照与复现清单.md`', '`docs/evidence/operations-matrix`'],
  ['`05-我们已实现的命令面.md`', '`docs/impl/command-surface`'],
  ['`2026-09-25-icatch-http-profiles-design.md`', '`docs/design/specs/2026-09-25-icatch-http-profiles`'],
];

const SKIP_DIRS = new Set(['_work', 'build', '.git', 'node_modules', '_tools', 'logs', 'downloads', '相机 app', '.kotlin', '.gradle', '.workbuddy', '.zcode']);
const TEXT_EXT = new Set(['.md', '.kt', '.kts', '.mjs', '.js', '.java', '.yml', '.yaml', '.html', '.py', '.toml', '.properties']);

const norm = (p) => p.replace(/\\/g, '/');
const absOf = (rel) => path.join(REPO, rel);
const exists = (rel) => fs.existsSync(absOf(rel));
/** Did this path exist in the pre-move layout? (After `git mv` the old path is gone.) */
const existedBefore = (rel) => {
  const r = norm(rel);
  return MAPPING.some(([from]) => norm(from) === r || r.startsWith(norm(from) + '/')) || fs.existsSync(absOf(r));
};

function walk(dirRel = '.', out = []) {
  for (const e of fs.readdirSync(absOf(dirRel), { withFileTypes: true })) {
    const rel = norm(path.join(dirRel, e.name));
    if (e.isDirectory()) {
      if (SKIP_DIRS.has(e.name)) continue;
      walk(rel, out);
    } else if (TEXT_EXT.has(path.extname(e.name))) {
      out.push(rel);
    }
  }
  return out;
}

/** repo-relative old path -> new path, for anything covered by MAPPING. */
function newPathOf(rel) {
  const r = norm(rel);
  for (const [from, to] of MAPPING) {
    if (r === from) return to;
    if (r.startsWith(from + '/')) return to + r.slice(from.length);
  }
  return r;
}

/** repo-relative new path -> old path, for anything covered by MAPPING. */
function oldPathOf(rel) {
  const r = norm(rel);
  for (const [from, to] of MAPPING) {
    if (r === to) return from;
    if (r.startsWith(to + '/')) return from + r.slice(to.length);
  }
  return r;
}

/** Rewrite relative `](target.md)` links so they follow their targets to the new layout. */
function retargetLinks(rel, text) {
  const oldDir = path.posix.dirname(oldPathOf(rel));
  const newDir = path.posix.dirname(norm(rel));
  let changed = 0;
  const out = text.replace(/\]\((?!https?:|#|mailto:)([^)\s]+?)(#[^)\s]*)?\)/g, (whole, target, anchor) => {
    const decoded = decodeURI(target);
    if (!/\.md$/.test(decoded)) return whole;
    // Idempotency: a link that already resolves inside docs/ from the new location is done.
    const asWritten = path.posix.normalize(path.posix.join(newDir, decoded));
    if (asWritten.startsWith('docs/') && fs.existsSync(absOf(asWritten))) return whole;
    const oldTarget = path.posix.normalize(path.posix.join(oldDir, decoded));
    if (!existedBefore(oldTarget)) return whole;
    const relNew = path.posix.relative(newDir || '.', newPathOf(oldTarget)) || decoded;
    if (relNew === decoded) return whole;
    changed++;
    return `](${relNew}${anchor ?? ''})`;
  });
  return { text: out, changed };
}

/** Every rewrite a file needs, with counts, without touching disk. */
function rewrite(rel) {
  let text = fs.readFileSync(absOf(rel), 'utf8');
  const before = text;
  let links = 0;
  let literals = 0;
  if (rel.endsWith('.md')) {
    const r = retargetLinks(rel, text);
    text = r.text;
    links = r.changed;
  }
  for (const [from, to] of LITERAL) {
    if (!text.includes(from)) continue;
    literals += text.split(from).length - 1;
    text = text.split(from).join(to);
  }
  return { text, changed: text !== before, links, literals };
}

const targets = () => walk().filter((rel) => !rel.startsWith('docs/evidence/data/') && rel !== 'tools/re/relayout.mjs');

if (!apply) {
  console.log('移动计划：');
  for (const [from, to] of MAPPING) {
    if (to.startsWith('docs/evidence/data') && from === `${OLD}/data`) console.log(`  · ${from}/**  ->  ${to}/**`);
    else console.log(`  ${exists(from) ? ' ' : '×'} ${from}  ->  ${to}${exists(from) ? '' : '   (不存在)'}`);
  }
  const rows = [];
  let total = 0;
  for (const rel of targets()) {
    const r = rewrite(rel);
    if (r.changed) {
      rows.push([rel, r.links, r.literals]);
      total += r.links + r.literals;
    }
  }
  console.log(`\n引用改写：${rows.length} 个文件、${total} 处（${rows.reduce((a, r) => a + r[1], 0)} 条相对链接 + ${rows.reduce((a, r) => a + r[2], 0)} 处字面）`);
  for (const [rel, l, n] of rows.sort((a, b) => b[1] + b[2] - (a[1] + a[2]))) console.log(`  ${String(l + n).padStart(4)}  ${rel}  (link ${l} / literal ${n})`);
  process.exit(0);
}

for (const [, to] of MAPPING) fs.mkdirSync(path.dirname(absOf(to)), { recursive: true });

let moved = 0;
for (const [from, to] of MAPPING) {
  if (!exists(from)) { console.log(`skip (missing): ${from}`); continue; }
  execFileSync('git', ['mv', from, to], { cwd: REPO, stdio: 'inherit' });
  moved++;
}
console.log(`\n已移动 ${moved} 项。\n`);

let filesTouched = 0;
let total = 0;
for (const rel of targets()) {
  const r = rewrite(rel);
  if (!r.changed) continue;
  fs.writeFileSync(absOf(rel), r.text);
  filesTouched++;
  total += r.links + r.literals;
}
console.log(`引用改写：${filesTouched} 个文件、${total} 处。`);
console.log('接下来：同步 tools/re 常量与生成器、重跑提取器、跑 tools/re/check-refs.mjs 查残留。');
