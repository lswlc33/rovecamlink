/**
 * AndroidManifest extractor.
 *
 * Reads the jadx-decoded `AndroidManifest.xml` and emits a complete inventory:
 * package identity, SDK floors, every permission (declared + used), every
 * feature/library, every application attribute, and every component with its
 * intent filters, guarding permissions and meta-data.
 *
 * Usage: node tools/re/manifest.mjs <appKey>
 */
import path from 'node:path';
import { APPS, p, exists, read, parseXml, children, writeOut, mdTable, tsv, header, log, isMain, appArg } from './lib.mjs';

const KINDS = ['activity', 'service', 'receiver', 'provider', 'activity-alias', 'queries'];

function shortClass(name) {
  return name || '';
}

function collectFilters(node) {
  return children(node, 'intent-filter').map((f) => {
    const actions = children(f, 'action').map((a) => a.attrs['android:name'] ?? a.attrs.name ?? '');
    const categories = children(f, 'category').map((c) => c.attrs['android:name'] ?? '');
    const data = children(f, 'data').map((d) =>
      Object.entries(d.attrs)
        .filter(([, v]) => v !== '')
        .map(([k, v]) => `${k.replace('android:', '')}=${v}`)
        .join(' '),
    );
    const flags = Object.entries(f.attrs)
      .filter(([k]) => k.startsWith('android:'))
      .map(([k, v]) => `${k.replace('android:', '')}=${v}`);
    return { actions, categories, data, flags: flags.join(',') };
  });
}

function collectMeta(node) {
  return children(node, 'meta-data').map((m) => {
    const a = m.attrs;
    const val = a['android:value'] ?? a['android:resource'] ?? a['android:assetPath'] ?? '';
    return {
      name: a['android:name'] ?? '',
      value: val.startsWith('@') ? val.replace('@', '@') : val,
      extra: Object.entries(a)
        .filter(([k]) => k !== 'android:name' && k !== 'android:value' && k !== 'android:resource' && k !== 'android:assetPath')
        .map(([k, v]) => `${k.replace('android:', '')}=${v}`)
        .join(','),
    };
  });
}

function nodeFlags(node) {
  return Object.entries(node.attrs)
    .filter(([k]) => k.startsWith('android:') && k !== 'android:name')
    .map(([k, v]) => `${k.replace('android:', '')}=${v}`)
    .join('; ');
}

function walkComponents(appNode, packageName, prefix = '') {
  const out = [];
  for (const kind of KINDS) {
    for (const node of children(appNode, kind)) {
      let name = node.attrs['android:name'] ?? '';
      if (name.startsWith('.')) name = packageName + name;
      else if (name && !name.includes('.') && !name.startsWith('#')) name = packageName + '.' + name;
      out.push({
        kind,
        name: prefix ? `${prefix}/${name}` : name,
        raw: node.attrs['android:name'] ?? '',
        flags: nodeFlags(node),
        filters: collectFilters(node),
        meta: collectMeta(node),
      });
      // providers/activities can nest sub-components in some tools' output
      out.push(...walkComponents(node, packageName, kind));
    }
  }
  return out;
}

export function run(app) {
  const manifestPath = path.join(p(app.resources), 'AndroidManifest.xml');
  if (!exists(manifestPath)) {
    log(`!! ${app.label}: no decoded AndroidManifest.xml at ${manifestPath} — run jadx --no-src or \`node tools/re/aapt2.mjs ${app.key}\``);
    return null;
  }
  const doc = parseXml(read(manifestPath));
  const manifest = children(doc, 'manifest')[0];
  if (!manifest) throw new Error('manifest element not found');
  return emitManifest(app, manifest, `jadx 解码：${path.relative(p('.'), manifestPath).replace(/\\/g, '/')}`);
}

/** Turn a parsed `<manifest>` element into the committed manifest documents. */
export function emitManifest(app, manifest, sourceNote) {
  const mA = manifest.attrs;
  const packageName = mA.package ?? '';

  const appNode = children(manifest, 'application')[0] ?? { children: [], attrs: {} };
  const appA = appNode.attrs;

  const identity = {
    package: packageName,
    versionCode: mA['android:versionCode'] ?? '',
    versionName: mA['android:versionName'] ?? '',
    platformBuildVersion: `${mA['platformBuildVersionCode'] ?? ''}/${mA['platformBuildVersionName'] ?? ''}`,
    compileSdk: `${mA['compileSdkVersion'] ?? ''} (${mA['compileSdkVersionCodename'] ?? ''})`,
    installLocation: mA['android:installLocation'] ?? 'default',
    split: mA['android:isSplitable'] ?? '',
    minSdk: children(manifest, 'uses-sdk')[0]?.attrs['android:minSdkVersion'] ?? '',
    targetSdk: children(manifest, 'uses-sdk')[0]?.attrs['android:targetSdkVersion'] ?? '',
    maxSdk: children(manifest, 'uses-sdk')[0]?.attrs['android:maxSdkVersion'] ?? '',
    featureSplit: children(manifest, 'uses-sdk')[0]?.attrs['android:requiredForAllUsers'] ?? '',
  };

  const usesPermissions = children(manifest, 'uses-permission').map((n) => ({
    name: n.attrs['android:name'] ?? '',
    maxSdk: n.attrs['android:maxSdkVersion'] ?? '',
  }));
  const declaredPermissions = children(manifest, 'permission').map((n) => ({
    name: n.attrs['android:name'] ?? '',
    protectionLevel: n.attrs['android:protectionLevel'] ?? '',
    label: n.attrs['android:label'] ?? '',
    description: n.attrs['android:description'] ?? '',
    permissionGroup: n.attrs['android:permissionGroup'] ?? '',
  }));
  const features = children(manifest, 'uses-feature').map((n) => ({
    name: n.attrs['android:name'] ?? '',
    required: n.attrs['android:required'] ?? 'true(default)',
    version: n.attrs['android:glEsVersion'] ?? '',
  }));
  const libraries = [
    ...children(manifest, 'uses-library').map((n) => ({ where: 'manifest', name: n.attrs['android:name'] ?? n.attrs.name ?? '', required: n.attrs['android:required'] ?? '' })),
    ...children(appNode, 'uses-library').map((n) => ({ where: 'application', name: n.attrs['android:name'] ?? n.attrs.name ?? '', required: n.attrs['android:required'] ?? '' })),
  ];
  const backgroundLimits = children(manifest, 'uses-permission-sdk-23').map((n) => n.attrs['android:name'] ?? '');
  const queries = children(manifest, 'queries').flatMap((q) =>
    [...children(q, 'package').map((n) => `package:${n.attrs['android:name']}`),
      ...children(q, 'intent').flatMap((i) => children(i, 'action').map((a) => `intent action:${a.attrs['android:name']}`)),
      ...children(q, 'provider').map((n) => `provider:${n.attrs['android:authorities']}`)]);

  const components = walkComponents(appNode, packageName);

  const appAttrs = Object.entries(appA)
    .filter(([k]) => k.startsWith('android:'))
    .map(([k, v]) => ({ attr: k.replace('android:', ''), value: v }));

  /* ------------------------------------------------------------- output --- */
  const compsOf = (kind) => components.filter((c) => c.kind === kind);
  const rowsFor = (list) => list.map((c) => [
    c.name,
    c.flags || '',
    c.filters.length ? c.filters.map((f) =>
      `[${f.actions.map((a) => a.replace(/^android\./, '')).join('+')}]${f.categories.length ? ` cat:${f.categories.map((x) => x.replace(/^android\./, '')).join('+')}` : ''}${f.data.length ? ` data:${f.data.join(' ')}` : ''}`,
    ).join(' ') : '',
    c.meta.length ? c.meta.map((m) => `${m.name}=${m.value}${m.extra ? ` (${m.extra})` : ''}`).join(' ') : '',
  ]);

  const md = [
    header(`${app.label} — AndroidManifest 全量清单`, [
      `来源：${sourceNote}`,
      `APK：\`${app.apk}\``,
    ]),
    '## 1. 包与版本\n',
    mdTable(['字段', '值'], Object.entries(identity).map(([k, v]) => [k, v])),
    '## 2. `<application>` 属性\n',
    mdTable(['属性', '值'], appAttrs.map((a) => [a.attr, a.value])),
    '## 3. 申请的权限（uses-permission）\n',
    `共 ${usesPermissions.length} 条。\n`,
    mdTable(['权限', 'maxSdkVersion'], usesPermissions.map((x) => [x.name, x.maxSdk])),
    '## 4. 自定义权限（permission）\n',
    declaredPermissions.length ? mdTable(['权限', 'protectionLevel', 'group', 'label'], declaredPermissions.map((x) => [x.name, x.protectionLevel, x.permissionGroup, x.label])) : '无。\n',
    '## 5. 硬件特性与库\n',
    mdTable(['uses-feature', 'required', 'glEsVersion'], features.map((f) => [f.name, f.required, f.version])),
    '',
    libraries.length ? mdTable(['位置', 'uses-library', 'required'], libraries.map((l) => [l.where, l.name, l.required])) : '无 uses-library。\n',
    '',
    queries.length ? `### 包可见性声明（queries）\n\n${mdTable(['条目'], queries.map((q) => [q]))}` : '',
    '',
    '## 6. 组件总览\n',
    mdTable(['类型', '数量'], [...KINDS.map((k) => [k, compsOf(k).length])]),
    '',
    ...['activity', 'service', 'receiver', 'provider', 'activity-alias'].map((kind) => {
      const list = compsOf(kind);
      if (!list.length) return `### ${kind}（0 个）\n`;
      const custom = list.filter((c) => !c.name.startsWith('android.') && !/^(androidx|com\.google|com\.tananaev|net\.gotev|com\.amap|com\.alibaba|com\.umeng|com\.tencent|com\.huawei|com\.heytap|com\.vivo|com\.samsung|com\.xiaomi|me\.leolin|com\.pingan)/.test(c.name));
      return [
        `### ${kind}（${list.length} 个，其中厂商/自有 ${custom.length} 个）\n`,
        custom.length ? mdTable([`${kind} 全限定名`, '属性', 'intent-filter', 'meta-data'], rowsFor(custom)) : '',
        list.length > custom.length ? `\n<details><summary>第三方 / 库注册的 ${list.length - custom.length} 个 ${kind}</summary>\n\n${mdTable([`${kind} 全限定名`, '属性', 'intent-filter', 'meta-data'], rowsFor(list.filter((c) => !custom.includes(c))))}\n</details>\n` : '',
      ].join('\n');
    }),
    '## 7. 全应用 meta-data\n',
    mdTable(['挂载点', 'name', 'value', '其它'], components.flatMap((c) => c.meta.map((m) => [c.kind + ':' + shortClass(c.name), m.name, m.value, m.extra]))),
  ].join('\n');

  const json = { app: app.key, identity, appAttrs, usesPermissions, declaredPermissions, features, libraries, queries, components };
  writeOut(app, 'manifest.md', md, { docs: true });
  writeOut(app, 'manifest.json', JSON.stringify(json, null, 2));
  writeOut(app, 'components.tsv', tsv(['kind', 'name', 'raw', 'flags', 'filters', 'meta'],
    components.map((c) => [c.kind, c.name, c.raw, c.flags, JSON.stringify(c.filters), JSON.stringify(c.meta)])));
  log(`${app.label}: manifest — ${components.length} 组件, ${usesPermissions.length} 权限, ${features.length} 特性`);
  return json;
}

if (isMain(import.meta.url)) {
  run(appArg());
}
