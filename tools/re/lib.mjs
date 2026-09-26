/**
 * Shared helpers for the APK reverse-engineering extractors.
 *
 * Everything here is dependency-free (Node >= 20) so the pipeline can be
 * re-run on a clean checkout with nothing but a JDK (for jadx) and Node.
 *
 * Corpus layout expected on disk (all git-ignored, produced by jadx):
 *   _work/<app>_src/sources      decompiled Java sources
 *   _work/<app>_res/resources    decoded resources (AndroidManifest.xml, res/, assets/)
 *   相机 app/<APK>               the original vendor APKs (analysis inputs only)
 */
import fs from 'node:fs';
import path from 'node:path';
import crypto from 'node:crypto';
import { pathToFileURL } from 'node:url';

export const REPO = path.resolve(import.meta.dirname, '../..');

/** The three official apps we hold binaries for. */
export const APPS = {
  tuwin: {
    key: 'tuwin',
    label: 'TUWIN',
    apk: '相机 app/TUWIN.apk',
    sources: '_work/tuwin_src/sources',
    resources: '_work/tuwin_res/resources',
    /** Packages we are sure belong to the vendor (analyser writes the details). */
    ownPackages: ['com/tuwinsmart'],
    /** Root package of the app itself, used to disambiguate bare file names. */
    appRootPkg: 'com/tuwinsmart',
  },
  xtugo: {
    key: 'xtugo',
    label: 'XTU GO',
    apk: '相机 app/XTU GO_8.4.3_243_2026-08-19-17-05-43.apk',
    sources: '_work/xtu_src/sources',
    resources: '_work/xtu_res/resources',
    ownPackages: ['com/gku', 'com/icatchtek', 'icatch', 'com/example', 'com/hisi', 'm/mifan'],
    appRootPkg: 'com/gku',
  },
  idgolive: {
    key: 'idgolive',
    label: 'idGoLive',
    apk: '相机 app/idGoLive_1.3.6.apk',
    sources: '_work/idgo_live_src/sources',
    resources: '_work/idgo_live_src/resources',
    ownPackages: ['com/icatch', 'com/icatchtek', 'com/id221', 'com/tinyai'],
    appRootPkg: 'com/icatch',
  },
};

/**
 * Package prefixes that are definitely somebody else's library. Anything that is
 * neither a vendor package nor on this list is bucketed as UNKNOWN and still gets
 * mined for literals — that is where obfuscated app code hides.
 */
export const LIB_PREFIXES = [
  'android.', 'androidx.', 'kotlin', 'kotlinx.', 'coil.', 'co.', 'io.reactivex', 'io.netty', 'io.opentelemetry', 
  'okhttp3.', 'okio.', 'retrofit2.', 'org.json', 'org.apache', 'org.bouncycastle', 'org.greenrobot', 'org.jetbrains',
  'org.simple', 'org.sunflow', 'org.tensorflow', 'org.webrtc', 'org.opencv', 'org.checkerframework', 'org.jacoco',
  'org.hamcrest', 'org.junit', 'org.robolectric', 'org.conscrypt', 'org.ccil', 'org.dom4j', 'org.jsoup', 'org.yaml',
  'org.intellij', 'org.w3c', 'org.mozilla', 'org.bson', 'org.reactivestreams', 'org.threeten',
  'com.google.', 'com.squareup.', 'com.bumptech.', 'com.umeng.', 'com.efs.', 'com.alibaba.', 'com.aliyun', 'com.amap.',
  'com.autonavi.', 'com.huawei.', 'com.hihonor.', 'com.samsung.', 'com.vivo.', 'com.heytap.', 'com.oppo.', 'com.xiaomi.',
  'com.meizu.', 'com.lenovo.', 'com.transsion.', 'com.tencent.', 'com.bytedance.', 'com.byted.', 'com.pangle.',
  'com.volcengine.', 'com.nostra13.', 'com.shuyu.', 'com.lzy.', 'com.zhy.', 'com.hjq.',
  'com.noober.', 'com.azhon.', 'com.danikula.', 'com.ihsanbal.', 'com.thanosfisherman', 'com.github.', 'com.blankj.',
  'com.facebook.', 'com.fasterxml.', 'com.jakewharton.', 'de.', 'rx.', 'p022rx.',
  'tv.danmaku.', 'jp.', 'ca.', 'uk.', 'me.leolin.', 'com.pingan.', 'net.gotev', 'net.', 'javax.', 'jakarta.', 'sun.',
  'com.mapzen', 'com.tankery', 'cn.', 'pl.', 'fr.', 'ru.',
  // vendor-bundled open-source UI / infra libraries seen in these three APKs
  'com.luck.', 'com.apm', 'org.jdom2', 'org.xutils', 'com.chad.', 'org.litepal', 'com.blakequ', 'org.ini4j',
  'com.scwang.', 'com.yalantis.', 'com.haibin', 'com.dhao.', 'io.opentracing', 'com.bigkoo', 'com.contrarywind',
  'com.tbruyelle', 'com.orhanobut', 'com.suke', 'me.yokeyword', 'me.gujun', 'io.supercharge', 'org.codehaus',
  'org.slf4j', 'org.ahocorasick', 'com.davemorrissey', 'org.jspecify', 'timber', 'dagger', 'hilt_aggregated_deps',
  '_COROUTINE', 'com.sun.', 'com.yanzhenjie', 'org.eclipse', 'com.handmark', 'com.arthenica', 'cafe.adriel',
  'org.jzvd', 'moe.codeest', 'shuyu.com', 'com.king.', 'com.ss.', 'com.cy.', 'com.gyf', 'com.xuexiang',
];

export const NOISE_ANNOTATIONS = new Set([
  'Metadata', 'DebugMetadata', 'Signature', 'KotlinMetadata', 'JvmName', 'JvmStatic', 'JvmField', 'JvmOverloads',
  'NotNull', 'Nullable', 'Contract', 'SourceFile', 'RuntimeVisibleAnnotations', 'KotlinSerialization',
]);

export function classifyPkg(pkg, ownPackages) {
  const asPath = pkg.replace(/\./g, '/');
  if (ownPackages.some((o) => asPath === o || asPath.startsWith(o + '/'))) return 'OWN';
  const dotted = pkg + '.';
  if (LIB_PREFIXES.some((pfx) => dotted.startsWith(pfx))) return 'lib';
  if (/^(com|net|org|io)\.[a-z0-9_]+\./.test(pkg)) return 'UNKNOWN';
  return 'UNKNOWN';
}

export const isMain = (metaUrl) => {
  const arg = process.argv[1];
  return !!arg && metaUrl === pathToFileURL(path.resolve(arg)).href;
};

export function p(...parts) { return path.join(REPO, ...parts); }

export function exists(target) {
  try { fs.accessSync(target); return true; } catch { return false; }
}

export function walk(dir, filter = () => true, acc = []) {
  if (!exists(dir)) return acc;
  for (const entry of fs.readdirSync(dir, { withFileTypes: true })) {
    const full = path.join(dir, entry.name);
    if (entry.isDirectory()) walk(full, filter, acc);
    else if (filter(full, entry)) acc.push(full);
  }
  return acc;
}

export const read = (file) => fs.readFileSync(file, 'utf8');

export function ensureDir(file) { fs.mkdirSync(path.dirname(file), { recursive: true }); }

export const OUT_WORK = '_work/re';
export const OUT_DOCS = 'docs/evidence';

/** Write a generated artefact to scratch, and optionally into the committed docs set. */
export function writeOut(app, name, text, { docs = false } = {}) {
  const work = p(OUT_WORK, app.key, name);
  ensureDir(work);
  fs.writeFileSync(work, text);
  const written = [work];
  if (docs) {
    const doc = p(OUT_DOCS, 'data', app.key, name);
    ensureDir(doc);
    fs.writeFileSync(doc, text);
    written.push(doc);
  }
  return written;
}

export function sha256(file) {
  const h = crypto.createHash('sha256');
  h.update(fs.readFileSync(file));
  return h.digest('hex');
}

/* ------------------------------------------------------------------ XML ---
 * A deliberately small, tolerant XML reader: Android resource tables and the
 * jadx-decoded manifest are plain XML, so we need ordering + tolerance rather
 * than validation.
 */

const ENTITIES = { amp: '&', lt: '<', gt: '>', quot: '"', apos: "'", nbsp: ' ' };

export function decodeEntities(s) {
  return s.replace(/&(#x?[0-9a-fA-F]+|[a-zA-Z]+);/g, (m, body) => {
    if (body[0] === '#') {
      const code = body[1] === 'x' || body[1] === 'X' ? parseInt(body.slice(2), 16) : parseInt(body.slice(1), 10);
      return Number.isFinite(code) ? String.fromCodePoint(code) : m;
    }
    return Object.hasOwn(ENTITIES, body) ? ENTITIES[body] : m;
  });
}

/** Parse an XML document into a tiny node tree: {name, attrs, children, text}. */
export function parseXml(source) {
  const root = { name: '#document', attrs: {}, children: [], text: '' };
  const stack = [root];
  const tagRe = /<!--[\s\S]*?-->|<\?[\s\S]*?\?>|<!\[CDATA\[([\s\S]*?)\]\]>|<\/([A-Za-z_][\w.:-]*)\s*>|<([A-Za-z_][\w.:-]*)((?:\s+[\w.:-]+\s*=\s*(?:"[^"]*"|'[^']*'))*)(\s*\/?)\s*>|([^<]+)/g;
  let m;
  while ((m = tagRe.exec(source))) {
    const [, cdata, closeName, openName, attrText, selfClose, chars] = m;
    const top = stack[stack.length - 1];
    if (cdata !== undefined) {
      top.children.push({ name: '#cdata', attrs: {}, children: [], text: cdata });
    } else if (closeName) {
      for (let i = stack.length - 1; i > 0; i--) {
        if (stack[i].name === closeName) { stack.length = i; break; }
      }
    } else if (openName) {
      const node = { name: openName, attrs: parseAttrs(attrText), children: [], text: '' };
      top.children.push(node);
      if (!selfClose) stack.push(node);
    } else if (chars !== undefined) {
      top.text += decodeEntities(chars);
    }
  }
  return root;
}

function parseAttrs(text) {
  const attrs = {};
  if (!text) return attrs;
  const re = /([\w.:-]+)\s*=\s*("([^"]*)"|'([^']*)')/g;
  let m;
  while ((m = re.exec(text))) {
    const raw = m[3] !== undefined ? m[3] : m[4] ?? '';
    attrs[m[1]] = decodeEntities(raw);
  }
  return attrs;
}

export const children = (node, name) => node.children.filter((c) => c.name === name);
export const first = (node, name) => node.children.find((c) => c.name === name);

export function textOf(node) {
  return (node.text + node.children.map((c) => (c.name === '#cdata' ? c.text : textOf(c))).join('')).trim();
}

/* -------------------------------------------------------------- Markdown -- */

export function mdTable(headers, rows) {
  const esc = (v) => String(v ?? '').replace(/\|/g, '\\|').replace(/\r?\n/g, ' ').trim();
  const out = [`| ${headers.map(esc).join(' | ')} |`, `|${headers.map(() => '---').join('|')}|`];
  for (const r of rows) out.push(`| ${r.map(esc).join(' | ')} |`);
  return out.join('\n') + '\n';
}

export function tsv(headers, rows) {
  const esc = (v) => String(v ?? '').replace(/\t/g, ' ').replace(/\r?\n/g, ' ');
  return [headers.join('\t'), ...rows.map((r) => r.map(esc).join('\t'))].join('\n') + '\n';
}

export function header(title, lines = []) {
  return [
    `# ${title}`,
    '',
    '> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。',
    '> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。',
    ...lines.map((l) => `> ${l}`),
    '',
    '---',
    '',
  ].join('\n');
}

export const log = (...args) => console.log('[re]', ...args);

/** Resolve `process.argv[2]` to an APPS entry, or list the valid keys and exit. */
export function appArg(argv = process.argv) {
  const app = APPS[argv[2]];
  if (!app) {
    console.error(`usage: node tools/re/<script>.mjs <${Object.keys(APPS).join('|')}>`);
    process.exit(2);
  }
  return app;
}
