/**
 * Markdown table sanity checker.
 *
 * Inside a table every row must have the same number of *unescaped* `|` separators
 * as the header. Docs here are full of grep commands and URL templates, and a raw
 * pipe inside a cell (`x|y`) silently turns one row into five when it renders.
 * Escaping as `\|` is the fix; this finds the ones that were missed.
 *
 * Usage: node tools/re/check-tables.mjs [file-or-dir ...]   # default: docs/
 */
import fs from 'node:fs';
import path from 'node:path';

const inputs = process.argv.slice(2).filter((a) => !a.startsWith('-'));
const roots = (inputs.length ? inputs : ['docs']).map((d) => path.resolve(d));
const files = [];
for (const root of roots) {
  const st = fs.statSync(root);
  if (!st.isDirectory()) { files.push(root); continue; }
  for (const name of fs.readdirSync(root)) {
    const full = path.join(root, name);
    const s = fs.statSync(full);
    if (s.isDirectory()) {
      for (const sub of fs.readdirSync(full)) {
        if (sub.endsWith('.md')) files.push(path.join(full, sub));
      }
      continue;
    }
    if (name.endsWith('.md')) files.push(full);
  }
}

const cells = (line) => line.trim().replace(/^\|/, '').replace(/\|$/, '').split(/(?<!\\)\|/).length;
const isRow = (line) => /^\s*\|.*\|\s*$/.test(line);
const isSep = (line) => /^\s*\|[\s:|-]+\|\s*$/.test(line) && /-/.test(line);

/** Escape `|` that sit inside `code spans` — they split table cells before Markdown escapes them. */
function escapePipesInCode(line) {
  let out = '';
  let inCode = false;
  for (let i = 0; i < line.length; i++) {
    const c = line[i];
    if (c === '`') inCode = !inCode;
    if (c === '|' && inCode && line[i - 1] !== '\\') { out += '\\|'; continue; }
    out += c;
  }
  return out;
}

const fix = process.argv.includes('--fix');

let tables = 0;
const problems = [];
const edits = new Map();
for (const file of files) {
  const lines = fs.readFileSync(file, 'utf8').split('\n');
  let dirty = false;
  for (let i = 0; i + 1 < lines.length; i++) {
    if (!isRow(lines[i]) || !isSep(lines[i + 1])) continue;
    tables++;
    const want = cells(lines[i]);
    let j = i + 2;
    for (; j < lines.length && isRow(lines[j]); j++) {
      let got = cells(lines[j]);
      if (got !== want && fix) {
        const escaped = escapePipesInCode(lines[j]);
        if (cells(escaped) === want) { lines[j] = escaped; dirty = true; got = cells(escaped); }
      }
      if (got !== want) problems.push([path.relative(process.cwd(), file), j + 1, want, got, lines[j].slice(0, 90)]);
    }
    i = j - 1;
  }
  if (dirty) edits.set(file, lines.join('\n'));
}
if (fix) for (const [file, text] of edits) fs.writeFileSync(file, text);

console.log(`检查 ${files.length} 个文档、${tables} 张表格`);
if (!problems.length) {
  console.log('  所有表格列数一致。');
  process.exit(0);
}
console.log(`  列数不一致：${problems.length} 行`);
for (const [f, line, want, got, snip] of problems.slice(0, 40)) {
  console.log(`  ${f}:${line} 期望 ${want} 列，实际 ${got} 列  ${snip}`);
}
if (problems.length > 40) console.log(`  …另 ${problems.length - 40} 行`);
process.exit(1);
