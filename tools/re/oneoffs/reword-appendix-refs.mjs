/**
 * Reword references to the appendix files that were folded into their dossiers
 * (2026-09-22 文档归并), so no document points at a path that no longer exists.
 */
import fs from 'node:fs';
import path from 'node:path';

const MAP = {
  '01-TUWIN-档案-附录-协议面.md': 'docs/evidence/tuwin 附录一（协议面）',
  '01-TUWIN-档案-附录-设置与操作.md': 'docs/evidence/tuwin 附录二（设置与操作）',
  '01-TUWIN-档案-附录-传输OTA与联网.md': 'docs/evidence/tuwin 附录三（传输·OTA·联网）',
  '02-XTUGO-档案-附录-海思CGI全表.md': '`docs/evidence/xtugo` 附录A（海思 CGI 全表）',
  '02-XTUGO-档案-附录-Ambarella报文全表.md': '`docs/evidence/xtugo` 附录B（Ambarella 报文全表）',
  '02-XTUGO-档案-附录-SigmaStar8080与播放层.md': '`docs/evidence/xtugo` 附录C（SigmaStar 与播放层）',
  '02-XTUGO-档案-附录-操作复现表.md': '`docs/evidence/xtugo` 附录D（操作复现表）',
  '02-XTUGO-档案-附录-权限组件与域名.md': '`docs/evidence/xtugo` 附录E（权限·组件·域名）',
  '03-idGoLive-档案-附录-PTP属性表.md': 'docs/evidence/idgolive 附录A（PTP 属性表）',
  '03-idGoLive-档案-附录-HTTP与TCP命令.md': 'docs/evidence/idgolive 附录B（HTTP 与 TCP 命令）',
  '03-idGoLive-档案-附录-原生层与PTPIP.md': 'docs/evidence/idgolive 附录C（原生层与 PTP-IP）',
  '03-idGoLive-档案-附录-UI与端点判定.md': 'docs/evidence/idgolive 附录D（UI 与端点判定）',
  '附录A-我们已实现的命令面.md': '05-我们已实现的命令面.md',
};

const roots = ['docs', 'docs/evidence', '.'];
const files = new Set();
for (const r of roots) {
  const abs = path.resolve(r);
  const st = fs.existsSync(abs) ? fs.statSync(abs) : null;
  if (!st) continue;
  if (st.isFile()) { if (abs.endsWith('.md')) files.add(abs); continue; }
  for (const name of fs.readdirSync(abs)) {
    if (!name.endsWith('.md')) continue;
    const full = path.join(abs, name);
    if (fs.statSync(full).isFile() && !full.includes(`${path.sep}_work${path.sep}`)) files.add(full);
  }
}

for (const file of files) {
  const lines = fs.readFileSync(file, 'utf8').split('\n');
  let changed = 0;
  const out = lines.map((line) => {
    if (line.trimStart().startsWith('<!--')) return line;      // keep the merge banners as history
    let next = line;
    for (const [from, to] of Object.entries(MAP)) {
      if (next.includes(from)) { next = next.split(from).join(to); changed++; }
    }
    return next;
  });
  if (changed) {
    fs.writeFileSync(file, out.join('\n'));
    console.log(`${path.basename(file)}: 改写 ${changed} 处`);
  }
}
