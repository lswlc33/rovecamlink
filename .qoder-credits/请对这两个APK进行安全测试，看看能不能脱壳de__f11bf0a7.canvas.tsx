import {
  BarChart,
  Callout,
  ChartComparisonGrid,
  ChartContainer,
  H1,
  LineChart,
  MetricsGrid,
  PieChart,
  ReportSection,
  ReportShell,
  Stack,
  Table,
  Text,
  type MetricItem,
} from "qoder/canvas";

// —— 报告数据契约（由 scripts/lib/breakdown.mjs 产出，plugin 注入）——
interface CatRow {
  key: string;
  label: string;
  tokens: number;
  share: number;
}
interface ToolRow {
  tool: string;
  tokens: number;
  calls: number;
  /** 平均每次调用带来的重发 token；无调用记录时 null（不给 0） */
  perCall?: number | null;
  share: number;
}
interface FileRow {
  attr: string;
  label: string;
  kind: string;
  tool: string | null;
  selfTokens: number;
  reads: number;
  trips: number;
  billed: number;
  /** 单次读取的总代价（含此后每一程重发）；reads=0 时 null */
  perRead?: number | null;
  share: number;
}
interface ReqRow {
  index: number;
  time: string | null;
  ratio: number;
  inputTokens: number;
  /** 代理或转录任一有真值即非 null；两者都没则 null（不写 0） */
  outputTokens?: number | null;
  /** proxy=代理实测 / transcript-tokens=转录 input_tokens / transcript-ratio=转录 ratio×window */
  usageSource?: "proxy" | "transcript-tokens" | "transcript-ratio" | "transcript";
  credits: number;
  originalCredits: number;
  afterCompact: boolean;
}
interface CatChild {
  tool: string | null;
  label: string;
  kind: string | null;
  tokens: number;
  share: number;
  catShare: number;
  trips: number;
}
interface CatDetail {
  key: string;
  label: string;
  tokens: number;
  share: number;
  children: CatChild[];
}
interface SubagentRow {
  agentId: string;
  agentType: string | null;
  description: string | null;
  toolUseId: string | null;
  roundTrips: number;
  billedInputTokens: number;
  peakContextRatio: number;
  credits: number;
  originalCredits: number;
  error: string | null;
}
interface SubagentTotals {
  roundTrips: number;
  billedInputTokens: number;
  credits: number;
  originalCredits: number;
}
interface Subagents {
  scanned: boolean;
  dir: string | null;
  /** 试过的候选目录；用于区分「真没子代理」与「路径没找对」。 */
  probedPaths?: string[];
  /** ok=已汇总 / no-dir=无子代理目录 / dir-empty=目录在但无 agent 文件 / no-usage=有文件但转录无 usage / error=读取抛错 */
  reason?: string;
  count: number;
  items: SubagentRow[];
  totals: SubagentTotals;
  combined: SubagentTotals;
}
/** 逐项可用性：报告里每个数字到底是模型上报的真值、按真值推导、回退默认、手工录入，还是本地根本没有。
 *  v2 旧报告没这个对象，故全部字段可选，读取时一律走默认值（旧报告只可能来自桌面端富转录）。 */
type Avail = "measured" | "derived" | "fallback" | "manual" | "unavailable";
interface Availability {
  credits?: Avail;
  roundTrips?: Avail;
  contextRatio?: Avail;
  tokens?: Avail;
  /** 输出 token：代理或转录 output_tokens 任一有真值即 measured */
  outputTokens?: Avail;
  /** 缓存命中 token：代理或转录 cache_read_input_tokens 任一有真值即 measured */
  cachedTokens?: Avail;
  categoryShare?: Avail;
  toolShare?: Avail;
  fileShare?: Avail;
  systemPrompt?: Avail;
  contextWindow?: Avail;
  compactions?: Avail;
  compactionCost?: Avail;
  model?: Avail;
  title?: Avail;
  toolCalls?: Avail;
  fileReads?: Avail;
  userTurns?: Avail;
  /** 用户压缩阈值：manual 覆盖 → manual；默认 200K → fallback */
  userContextLimit?: Avail;
}
/** 官方 UI 真值（手工录入，来自 .qoder-credits/overrides/<sessionId>.json）。
 *  IDE 端转录不含 usage，本地算不出 Credits，这是唯一的真值通道；绝不覆盖 totals，只并列展示。 */
interface ManualTruth {
  file?: string;
  credits: number | null;
  originalCredits: number | null;
  model: string | null;
  startedAt: string | null;
  endedAt: string | null;
  durationMin: number | null;
  note: string | null;
  /** 手工锁定模型窗口（如 qwen3-max=1000000），优先于 runtime-config / 反推 / fallback */
  contextWindow?: number | null;
  /** 手工指定 Qoder 压缩触发阈值（默认 200000），驱动 peakUserAdvice */
  userContextLimit?: number | null;
  /** 本地 credits ÷ 官方真值。有子代理时拿 combined 比（官方 UI 扣费 = 主链 + 子代理），
   *  否则覆盖率会被系统性低估（实测 ca2f7834：主链比 0.46、combined 比 0.89）。 */
  localCoverage?: number | null;
  /** main=只比主链 / combined=比主链+子代理 */
  localScope?: "main" | "combined";
  /** 参与对账的本地 credits（按 localScope 取 totals.credits 或 subagents.combined.credits） */
  localCredits?: number | null;
}
/** 峰值占比的「该不该压」结论。阈值算在数据层（breakdown.mjs peakAdvice），
 *  这里只管展示——否则 Canvas 与终端各持一套阈值迟早走偏。tone 直接喂 Callout。 */
interface PeakAdvice {
  level: "low" | "mid" | "sweet" | "high" | "over";
  tone: "info" | "success" | "warning" | "danger";
  text: string;
}
/** 一次压缩 = 一笔普通模型调用（整份上下文当 prompt、摘要当 completion），是会话里单笔最贵的开销。
 *  pre/post 是客户端自估口径；proxy 是能在代理日志里唯一对上时回填的供应商实测值，对不上就 null。 */
interface CompactionEvent {
  index: number;
  at: string | null;
  trigger: string | null;
  preTokens: number | null;
  postTokens: number | null;
  messagesSummarized: number | null;
  /** 压缩后首轮的往返序号与实测输入 = 压缩把上下文压到的地板 */
  nextRequestIndex: number | null;
  nextInputTokens: number | null;
  savedTokens: number | null;
  /** 数据层归一后的生效值：有代理实测就用实测，否则是客户端自估。
   *  渲染端直接取这两个，别自己按 proxy 分支——否则会与合计的口径分叉。 */
  effectiveInputTokens?: number | null;
  effectiveOutputTokens?: number | null;
  proxy?: {
    promptTokens: number;
    completionTokens: number;
    cachedTokens: number | null;
    ms: number | null;
    matchedBy: string;
  } | null;
}
interface CompactionCost {
  count: number;
  items: CompactionEvent[];
  /** measured = items 里有几笔拿到了供应商实测（其余为客户端自估） */
  totals: { preTokens: number; postTokens: number; savedTokens: number; measured?: number };
}
/** 链路健康度：代理覆盖率 + 最近记录时间 + 最近若干笔的三方归因计数。
 *  逐笔明细属于排障（CLI --request-log），报告只给一行结论。 */
interface LinkHealth {
  matched: number;
  requests: number;
  coverage: number;
  /** proxy / transcript-tokens / transcript-ratio / mixed / transcript（v3 旧报告）/ null */
  usageSource?: "proxy" | "transcript-tokens" | "transcript-ratio" | "mixed" | "transcript" | null;
  /** 三档拆分：代理实测 / 转录 input_tokens / 转录 ratio×window */
  breakdown?: { proxy: number; transcriptTokens: number; transcriptRatio: number };
  logRecords?: number;
  lastRecordAt?: string | null;
  /** 参与归因的最近笔数；0 = 运行中的代理是旧版或还没记到诊断 */
  recentRequests?: number;
  proxyErrors?: number | null;
  upstreamRejected?: number | null;
  aborted?: number | null;
  truncated?: number | null;
  noUsage?: number | null;
  slowestMs?: number | null;
  /** 被更新流量推翻的那条陈旧拉起失败记录；null = 没有 */
  supersededFailure?: { error: string; port?: number; at?: string | null } | null;
}
interface Report {
  schemaVersion: number;
  generatedAt: string;
  pluginVersion?: string;
  /** 转录来自哪一代客户端：桌面端富转录有 usage 真值，IDE 端精简转录没有。v2 旧报告无此字段。 */
  source?: "desktop-rich" | "ide-lite" | "unknown";
  /** usage 数字的来源：proxy=代理实测 / transcript-tokens=转录 input_tokens 真值 /
   *  transcript-ratio=转录 ratio×window 推导 / mixed=多档混合 / transcript=v3 旧报告兼容。无 usage 时 null。 */
  usageSource?: "proxy" | "transcript-tokens" | "transcript-ratio" | "mixed" | "transcript" | null;
  /** 可直接粘贴执行的插件入口命令（generate.mjs 用 proxy.mjs 的 selfCmd() 注入）。
   *  Windows 上是插件自带启动器的绝对路径，不要求用户装 Node；模板是静态文本，拿不到就只能硬编码。 */
  selfCmd?: string | null;
  /** 链路健康度一行结论（逐笔明细留给 CLI --request-log） */
  linkHealth?: LinkHealth | null;
  /** 代理 join 诊断（lib/proxylog.mjs）+ 配置/状态（generate.mjs 注入） */
  proxy?: {
    matched: number;
    requests: number;
    /** 三档拆分：代理实测 / 转录 input_tokens / 转录 ratio×window */
    breakdown?: { proxy: number; transcriptTokens: number; transcriptRatio: number };
    logPath?: string;
    logExists?: boolean;
    logRecords?: number;
    /** config.json 里 upstream 合法 = 用户已配置代理 */
    configured?: boolean;
    enabled?: boolean;
    port?: number;
    /** 最近一条代理记录的时间；null = 从无流量 */
    lastRecordAt?: string | null;
    /** 已配置但长期零流量（多半已改回官方模型）——软提示可 --stop-proxy */
    dormant?: boolean;
    /** 最近一次自动拉起失败（如端口被占）；ok 时为 null */
    status?: { error: string; port?: number; at?: string | null } | null;
    /** status 那条失败记录是否已被更新的流量推翻（代理在它之后还记到了流量）。
     *  status.json 只写不清，陈旧失败会把用户推去改本来正确的 Base URL，故必须判掉。 */
    statusSuperseded?: boolean;
  };
  availability?: Availability;
  manual?: ManualTruth | null;
  session: {
    id: string | null;
    title: string | null;
    /** custom-title / first-user / session-id —— 令产物文件名可解释 */
    titleSource?: string;
    model: string | null;
    /** runtime-config / manual / unavailable */
    modelSource?: string;
    cwd: string | null;
    turns: number;
    roundTrips: number;
    compactions: number;
    startedAt: string | null;
    endedAt: string | null;
  };
  context: {
    contextWindow: number;
    /** runtime-config=实测 / derived-from-usage=从 usage 反推 / manual=ManualTruth 手工锁定 /
     *  fallback=读不到静默回退 200000 / caller=调用方传入（旧枚举，兼容）。
     *  报告里每个 token 数字都要乘它，回退时必须标出来。 */
    contextWindowSource?: string;
    systemPromptTokens: number;
    netContextTokens: number;
    /** 峰值 = 当前窗口口径：自最近一次压缩起算，压缩边界处归零重新累积 */
    peakContextTokens: number;
    peakContextRatio: number;
    /** 本场历史峰值（跨压缩）；整场没压缩过时与上面相等 */
    peakSessionTokens?: number;
    peakSessionRatio?: number;
    /** 历史峰值是否值得单独交代（与当前窗口峰值相差 ≥1 个百分点），渲染端直接取用不再自判 */
    peakSessionNotable?: boolean;
    /** 峰值占比的「该不该压」结论（对模型窗口）；无有效占比时 null */
    peakAdvice?: PeakAdvice | null;
    /** 用户压缩阈值（Qoder 自动触发点），与模型窗口独立。默认 200000，ManualTruth 可覆盖 */
    userContextLimit?: number;
    /** default=内置 200K / manual=overrides 手写 / config=插件配置 / derived=实测反推 */
    userContextLimitSource?: "default" | "manual" | "config" | "derived";
    /** peakContextTokens ÷ userContextLimit */
    peakUserRatio?: number;
    /** 对用户阈值的「快自动压缩了吗」结论；与 peakAdvice 可矛盾（模型窗口未满但用户阈值已超） */
    peakUserAdvice?: PeakAdvice | null;
    /** v3.2 当前占用头条口径：段内单调递增 ⇒ 峰值≡当前，故以 netContextTokens 作头条，peak 退灰字 */
    currentContextTokens?: number;
    netUserRatio?: number;
    netUserAdvice?: PeakAdvice | null;
    netWindowRatio?: number;
    /** v3.2 自动压缩自校准：本场 trigger=auto 的实际触发点（无需外部配置）与「阈值是否被强制」判定 */
    observedAutoCompactions?: number;
    observedAutoTriggerTokens?: number | null;
    autoTriggerRatio?: number | null;
    thresholdNotEnforced?: boolean;
  };
  totals: {
    billedInputTokens: number;
    netContextTokens: number;
    peakContextTokens: number;
    amplification: number;
    attributedTokens: number;
    coverage: number;
    credits: number;
    originalCredits: number;
    /** 输出 token 总量：仅代理路径有真值，否则 0 且 availability.outputTokens=unavailable */
    outputTokens?: number;
    /** 供应商上下文缓存命中的那部分 prompt：仅代理路径有真值 */
    cachedTokens?: number;
    cachedTrips?: number;
    /** 缓存命中 ÷ 计费输入总量（全局实测约 91.5%：重复叠加的前缀正是缓存的命中对象） */
    cachedShare?: number;
    /** 两个不依赖 usage 的计数，IDE 端占比全缺时仍有可展示的真值 */
    toolCalls?: number;
    fileReads?: number;
  };
  /** credits 的分子到底覆盖了多少：与计费输入总量并排展示时，部分覆盖不说就等于把局部真值当全量。 */
  creditsCoverage?: {
    /** 真正累加进 totals.credits 的往返数 */
    trips: number;
    roundTrips: number;
    /** 这些往返的计费输入之和 */
    tokens: number;
    tokenShare: number;
    /** trips === roundTrips：全覆盖时不必再啰嗦覆盖范围 */
    full: boolean;
  };
  /** 压缩单笔成本（此前只显示「压缩 N 次」，而它是会话里单笔最贵的调用） */
  compactionCost?: CompactionCost;
  byCategory: CatRow[];
  byCategoryDetail: CatDetail[];
  byTool: ToolRow[];
  byFile: FileRow[];
  byRequest: ReqRow[];
  subagents?: Subagents;
  identity: { sumAttributed: number; billedInputTokens: number; absDiff: number; ok: boolean | null };
}

// 注入点：下一行的 REPORT 初值会被 render-canvas.mjs 按整行替换为真实报告 JSON。
const REPORT = {"schemaVersion":3.2,"generatedAt":"2026-09-23T02:24:26.742Z","source":"desktop-rich","usageSource":"transcript-ratio","availability":{"credits":"measured","roundTrips":"measured","contextRatio":"measured","tokens":"derived","outputTokens":"unavailable","cachedTokens":"unavailable","categoryShare":"derived","toolShare":"derived","fileShare":"derived","systemPrompt":"derived","contextWindow":"measured","compactions":"measured","compactionCost":"measured","model":"measured","title":"measured","toolCalls":"measured","fileReads":"measured","userTurns":"measured","userContextLimit":"fallback"},"session":{"id":"f11bf0a7-813e-4182-819e-140646307583","title":"请对这两个APK进行安全测试，看看能不能脱壳de","titleSource":"first-user","model":"qfmodel","modelSource":"runtime-config","cwd":"C:\\Users\\lswlc\\.qoder-cn\\worktrees\\app\\6cad8b\\rovecamlink","turns":3,"roundTrips":99,"compactions":0,"startedAt":"2026-09-23T01:31:24.328Z","endedAt":"2026-09-23T02:24:21.118Z"},"context":{"contextWindow":1000000,"contextWindowSource":"runtime-config","systemPromptTokens":19792,"netContextTokens":225747,"peakContextTokens":225747,"peakContextRatio":0.225747,"peakSessionTokens":225747,"peakSessionRatio":0.225747,"peakSessionNotable":false,"peakAdvice":{"level":"low","tone":"info","text":"低于盈亏线（39%）。此时压缩在 token 上是亏的：省下的还不够付摘要输出加压缩后重读，别压"},"userContextLimit":200000,"userContextLimitSource":"default","peakUserRatio":1.128735,"peakUserAdvice":{"level":"over","tone":"danger","text":"已经超过上下文窗口本身，随时可能被截断或由客户端在最糟的时机自动压缩，立刻手动压一次"},"currentContextTokens":225747,"netUserRatio":1.128735,"netUserAdvice":{"level":"over","tone":"danger","text":"已经超过上下文窗口本身，随时可能被截断或由客户端在最糟的时机自动压缩，立刻手动压一次"},"netWindowRatio":0.225747,"observedAutoCompactions":0,"observedAutoTriggerTokens":null,"autoTriggerRatio":null,"thresholdNotEnforced":true},"totals":{"billedInputTokens":13538583,"netContextTokens":225747,"peakContextTokens":225747,"amplification":59.97,"attributedTokens":13538583,"coverage":1,"credits":50.897,"originalCredits":50.897,"outputTokens":0,"cachedTokens":0,"cachedTrips":0,"cachedShare":0,"toolCalls":122,"fileReads":38},"creditsCoverage":{"trips":99,"roundTrips":99,"tokens":13538583,"tokenShare":1,"full":true},"compactionCost":{"count":0,"items":[],"totals":{"preTokens":0,"postTokens":0,"savedTokens":0,"measured":0}},"proxy":{"matched":0,"requests":99,"breakdown":{"proxy":0,"transcriptTokens":0,"transcriptRatio":99},"logPath":"C:\\Users\\lswlc\\.qoder-credits-proxy\\usage.jsonl","logExists":false,"logRecords":0,"configured":false,"enabled":true,"port":49787,"lastRecordAt":null,"dormant":false,"status":null,"statusSuperseded":false},"byCategory":[{"key":"tool_result","label":"工具返回","tokens":2540524,"share":0.18765062862102871},{"key":"system","label":"系统提示词","tokens":1959408,"share":0.14472770156226836},{"key":"assistant_thinking","label":"模型思考","tokens":2934200,"share":0.21672871080594552},{"key":"assistant_tool_use","label":"工具调用","tokens":2423667,"share":0.17901927387834882},{"key":"assistant_text","label":"模型回复","tokens":152841,"share":0.011289266106176648},{"key":"user_input","label":"用户输入","tokens":33298,"share":0.0024594938048936353},{"key":"attachment","label":"附件/技能","tokens":3494646,"share":0.25812492522133873}],"byCategoryDetail":[{"key":"tool_result","label":"工具返回","tokens":2540524,"share":0.18765062862102871,"children":[{"tool":"Bash","label":"（无路径）","kind":"shell","tokens":2014020,"share":0.1487615089301494,"catShare":0.7927578501779594,"trips":3862},{"tool":"Read","label":"E:/apksec/manifest/FINDINGS.md","kind":"read","tokens":315113,"share":0.023275160737856845,"catShare":0.12403454712034233,"trips":50},{"tool":"Read","label":"D:/Users/Desktop/安全测试/APK安全测试报告.md","kind":"read","tokens":90719,"share":0.006700765787417488,"catShare":0.035708730829514417,"trips":57},{"tool":"Agent","label":"（无路径）","kind":"other","tokens":50334,"share":0.003717794234994176,"catShare":0.01981231964057246,"trips":243},{"tool":"Edit","label":"D:/Users/Desktop/安全测试/APK安全测试报告.md","kind":"write","tokens":14052,"share":0.0010379353330448127,"catShare":0.005531211596103858,"trips":280},{"tool":"Read","label":"C:/Users/lswlc/.qoder-cn/memory/user-profile.md","kind":"read","tokens":10325,"share":0.0007626721311572696,"catShare":0.004064319617588546,"trips":10},{"tool":"TaskCreate","label":"（无路径）","kind":"other","tokens":9593,"share":0.0007085588964826707,"catShare":0.0037759473639368745,"trips":479},{"tool":"Edit","label":"E:/apksec/dexstrings.js","kind":"write","tokens":7183,"share":0.0005305701742006116,"catShare":0.002827436167411561,"trips":177},{"tool":"Read","label":"C:/Users/lswlc/.qoder-cn/memory/MEMORY.md","kind":"read","tokens":5066,"share":0.0003741726556981892,"catShare":0.0019939856234313636,"trips":5},{"tool":"Read","label":"C:/Users/lswlc/.qoder-cn/memory/reference-windows-scripting.md","kind":"read","tokens":3867,"share":0.00028561101246864825,"catShare":0.001522036001517779,"trips":8},{"tool":"TaskUpdate","label":"（无路径）","kind":"other","tokens":3234,"share":0.00023885472922263642,"catShare":0.0012728693262467952,"trips":452},{"tool":"Write","label":"（无路径）","kind":"write","tokens":1533,"share":0.0001132655311696069,"catShare":0.0006035979309099635,"trips":56},{"tool":"Write","label":"D:/Users/Desktop/安全测试/APK安全测试报告.md","kind":"write","tokens":1533,"share":0.00011324221002353593,"catShare":0.0006034736513046014,"trips":48},{"tool":"Write","label":"E:/apksec/dexscan.js","kind":"write","tokens":1384,"share":0.0001022449252069476,"catShare":0.0005448685461823693,"trips":89},{"tool":"Write","label":"E:/apksec/dexdump.js","kind":"write","tokens":1323,"share":0.00009773496822386528,"catShare":0.0005208347498864323,"trips":85},{"tool":null,"label":"其他 13 项","kind":null,"tokens":11244,"share":0.0008305363637115458,"catShare":0.004425971657088674,"trips":667}]},{"key":"system","label":"系统提示词","tokens":1959408,"share":0.14472770156226836,"children":[]},{"key":"assistant_thinking","label":"模型思考","tokens":2934200,"share":0.21672871080594552,"children":[]},{"key":"assistant_tool_use","label":"工具调用","tokens":2423667,"share":0.17901927387834882,"children":[{"tool":"Bash","label":"（无路径）","kind":"shell","tokens":483920,"share":0.03574376333584035,"catShare":0.19966432977562937,"trips":3862},{"tool":"Edit","label":"D:/Users/Desktop/安全测试/APK安全测试报告.md","kind":"write","tokens":390683,"share":0.028857000032467335,"catShare":0.16119493397161744,"trips":280},{"tool":"Write","label":"D:/Users/Desktop/安全测试/APK安全测试报告.md","kind":"write","tokens":374086,"share":0.02763109924574276,"catShare":0.15434706357103906,"trips":48},{"tool":"Agent","label":"（无路径）","kind":"other","tokens":372508,"share":0.027514542690968435,"catShare":0.15369597973939797,"trips":243},{"tool":"Write","label":"E:/apksec/cryptoprobe.js","kind":"write","tokens":103473,"share":0.0076428451726913834,"catShare":0.04269286209866442,"trips":77},{"tool":"Write","label":"E:/apksec/dexscan.js","kind":"write","tokens":86462,"share":0.0063863753283108825,"catShare":0.035674233226142424,"trips":89},{"tool":"Write","label":"E:/apksec/soshell.js","kind":"write","tokens":81433,"share":0.0060148548062646376,"catShare":0.03359892304306846,"trips":79},{"tool":"Write","label":"E:/apksec/dexstrings.js","kind":"write","tokens":65195,"share":0.004815472648616284,"catShare":0.02689918545803399,"trips":62},{"tool":"Write","label":"E:/apksec/dexhunt.js","kind":"write","tokens":64023,"share":0.004728955208690419,"catShare":0.026415899842739527,"trips":69},{"tool":"Write","label":"E:/apksec/dexstrings2.js","kind":"write","tokens":54627,"share":0.004034939522262643,"catShare":0.022539134668843285,"trips":55},{"tool":"Write","label":"E:/apksec/dexdump.js","kind":"write","tokens":44887,"share":0.0033154708451326614,"catShare":0.018520189325455898,"trips":85},{"tool":"Write","label":"E:/apksec/carve.js","kind":"write","tokens":40163,"share":0.0029665372586740435,"catShare":0.016571049554641427,"trips":75},{"tool":"Write","label":"E:/apksec/entscan2.js","kind":"write","tokens":38481,"share":0.002842328123683122,"catShare":0.01587721848103688,"trips":65},{"tool":"Edit","label":"E:/apksec/dexstrings.js","kind":"write","tokens":37958,"share":0.0028036748682825534,"catShare":0.015661301755629783,"trips":177},{"tool":"Write","label":"E:/apksec/maplist.js","kind":"write","tokens":37691,"share":0.0027839571020639377,"catShare":0.015551158496798253,"trips":47},{"tool":null,"label":"其他 13 项","kind":null,"tokens":148078,"share":0.010937457688657734,"catShare":0.06109653699126386,"trips":1255}]},{"key":"assistant_text","label":"模型回复","tokens":152841,"share":0.011289266106176648,"children":[]},{"key":"user_input","label":"用户输入","tokens":33298,"share":0.0024594938048936353,"children":[]},{"key":"attachment","label":"附件/技能","tokens":3494646,"share":0.25812492522133873,"children":[]}],"byTool":[{"tool":"Bash","tokens":2497940,"calls":63,"perCall":39650,"share":0.18450527226599003},{"tool":"Write","tokens":1108579,"calls":15,"perCall":73905,"share":0.08188295831964237},{"tool":"Edit","tokens":458087,"calls":17,"perCall":26946,"share":0.03383567285274469},{"tool":"Read","tokens":428221,"calls":7,"perCall":61174,"share":0.03162964445132363},{"tool":"Agent","tokens":422842,"calls":3,"perCall":140947,"share":0.031232336925962594},{"tool":"TaskCreate","tokens":40438,"calls":9,"perCall":4493,"share":0.0029868808606580317},{"tool":"TaskUpdate","tokens":8084,"calls":8,"perCall":1011,"share":0.0005971368230565886}],"byFile":[{"attr":"file:D:\\Users\\Desktop\\安全测试\\APK安全测试报告.md","label":"D:/Users/Desktop/安全测试/APK安全测试报告.md","kind":"write","tool":"Write","selfTokens":25483,"reads":15,"trips":770,"billed":873013,"perRead":58201,"share":0.06448331071347993},{"attr":"file:E:\\apksec\\manifest\\FINDINGS.md","label":"E:/apksec/manifest/FINDINGS.md","kind":"read","tool":"Read","selfTokens":5335,"reads":1,"trips":100,"billed":315823,"perRead":315823,"share":0.02332763151164123},{"attr":"file:E:\\apksec\\dexstrings.js","label":"E:/apksec/dexstrings.js","kind":"write","tool":"Write","selfTokens":1535,"reads":4,"trips":478,"billed":111300,"perRead":27825,"share":0.008220936285447589},{"attr":"file:E:\\apksec\\cryptoprobe.js","label":"E:/apksec/cryptoprobe.js","kind":"write","tool":"Write","selfTokens":1134,"reads":1,"trips":154,"billed":104767,"perRead":104767,"share":0.007738380737350022},{"attr":"file:E:\\apksec\\dexscan.js","label":"E:/apksec/dexscan.js","kind":"write","tool":"Write","selfTokens":825,"reads":1,"trips":178,"billed":87847,"perRead":87847,"share":0.006488620253517829},{"attr":"file:E:\\apksec\\soshell.js","label":"E:/apksec/soshell.js","kind":"write","tool":"Write","selfTokens":873,"reads":1,"trips":158,"billed":82664,"perRead":82664,"share":0.006105777030080264},{"attr":"file:E:\\apksec\\dexhunt.js","label":"E:/apksec/dexhunt.js","kind":"write","tool":"Write","selfTokens":786,"reads":1,"trips":138,"billed":65100,"perRead":65100,"share":0.004808484856443299},{"attr":"file:E:\\apksec\\dexstrings2.js","label":"E:/apksec/dexstrings2.js","kind":"write","tool":"Write","selfTokens":849,"reads":1,"trips":110,"billed":55543,"perRead":55543,"share":0.004102591202875429},{"attr":"file:E:\\apksec\\dexdump.js","label":"E:/apksec/dexdump.js","kind":"write","tool":"Write","selfTokens":454,"reads":1,"trips":170,"billed":46210,"perRead":46210,"share":0.0034132058133565274},{"attr":"file:E:\\apksec\\carve.js","label":"E:/apksec/carve.js","kind":"write","tool":"Write","selfTokens":458,"reads":1,"trips":150,"billed":41243,"perRead":41243,"share":0.0030463544046473376},{"attr":"file:E:\\apksec\\entscan2.js","label":"E:/apksec/entscan2.js","kind":"write","tool":"Write","selfTokens":507,"reads":1,"trips":130,"billed":39494,"perRead":39494,"share":0.002917126232201101},{"attr":"file:E:\\apksec\\maplist.js","label":"E:/apksec/maplist.js","kind":"write","tool":"Write","selfTokens":691,"reads":1,"trips":94,"billed":38414,"perRead":38414,"share":0.0028373368105105924},{"attr":"file:E:\\apksec\\literals.js","label":"E:/apksec/literals.js","kind":"write","tool":"Write","selfTokens":703,"reads":1,"trips":90,"billed":37398,"perRead":37398,"share":0.0027623587963408434},{"attr":"file:E:\\apksec\\entscan.js","label":"E:/apksec/entscan.js","kind":"write","tool":"Write","selfTokens":465,"reads":1,"trips":134,"billed":37371,"perRead":37371,"share":0.0027602992428315026},{"attr":"file:C:\\Users\\lswlc\\.qoder-cn\\memory\\reference-windows-scripting.md","label":"C:/Users/lswlc/.qoder-cn/memory/reference-windows-scripting.md","kind":"read","tool":"Read","selfTokens":1395,"reads":3,"trips":42,"billed":11352,"perRead":3784,"share":0.0008384966538080276},{"attr":"file:C:\\Users\\lswlc\\.qoder-cn\\memory\\user-profile.md","label":"C:/Users/lswlc/.qoder-cn/memory/user-profile.md","kind":"read","tool":"Read","selfTokens":913,"reads":1,"trips":20,"billed":10521,"perRead":10521,"share":0.0007771424729314587},{"attr":"file:C:\\Users\\lswlc\\.qoder-cn\\memory\\MEMORY.md","label":"C:/Users/lswlc/.qoder-cn/memory/MEMORY.md","kind":"read","tool":"Read","selfTokens":1101,"reads":2,"trips":18,"billed":6077,"perRead":3038,"share":0.0004488323654907868},{"attr":"file:C:\\Users\\lswlc\\.qoder-cn\\memory\\user-apk-security-testing.md","label":"C:/Users/lswlc/.qoder-cn/memory/user-apk-security-testing.md","kind":"write","tool":"Write","selfTokens":574,"reads":1,"trips":18,"billed":5949,"perRead":5949,"share":0.000439443388796158}],"byAttr":[{"attr":"attachment","tokens":3494646,"share":0.25812492522133873},{"attr":"assistant_thinking","tokens":2934200,"share":0.21672871080594552},{"attr":"tool_result|Bash","tokens":2014020,"share":0.1487615089301494},{"attr":"system","tokens":1959408,"share":0.14472770156226836},{"attr":"tool_use|Write","tokens":1092533,"share":0.0806977579697507},{"attr":"tool_use|Bash","tokens":483920,"share":0.03574376333584035},{"attr":"tool_use|Edit","tokens":435879,"share":0.03219534369705526},{"attr":"tool_result|Read","tokens":425090,"share":0.031398382324598455},{"attr":"tool_use|Agent","tokens":372508,"share":0.027514542690968435},{"attr":"assistant_text","tokens":152841,"share":0.011289266106176648},{"attr":"tool_result|Agent","tokens":50334,"share":0.003717794234994176},{"attr":"user_input","tokens":33298,"share":0.0024594938048936353},{"attr":"tool_use|TaskCreate","tokens":30845,"share":0.002278321964175361},{"attr":"tool_result|Edit","tokens":22208,"share":0.001640329155689378},{"attr":"tool_result|Write","tokens":16046,"share":0.0011852003498915452},{"attr":"tool_result|TaskCreate","tokens":9593,"share":0.0007085588964826707},{"attr":"tool_use|TaskUpdate","tokens":4851,"share":0.00035828209383395403},{"attr":"tool_result|TaskUpdate","tokens":3234,"share":0.00023885472922263642},{"attr":"tool_use|Read","tokens":3131,"share":0.0002312621267251763}],"byRequest":[{"index":1,"time":"09:31","ratio":0.030544,"inputTokens":30544,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.865,"originalCredits":0.865,"afterCompact":false},{"index":2,"time":"09:31","ratio":0.031016,"inputTokens":31016,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.15,"originalCredits":0.15,"afterCompact":false},{"index":3,"time":"09:32","ratio":0.032714,"inputTokens":32714,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.127,"originalCredits":0.127,"afterCompact":false},{"index":4,"time":"09:32","ratio":0.033035,"inputTokens":33035,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.143,"originalCredits":0.143,"afterCompact":false},{"index":5,"time":"09:32","ratio":0.034163,"inputTokens":34163,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.132,"originalCredits":0.132,"afterCompact":false},{"index":6,"time":"09:32","ratio":0.034824,"inputTokens":34824,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.128,"originalCredits":0.128,"afterCompact":false},{"index":7,"time":"09:33","ratio":0.038096,"inputTokens":38096,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.302,"originalCredits":0.302,"afterCompact":false},{"index":8,"time":"09:34","ratio":0.046077,"inputTokens":46077,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.614,"originalCredits":0.614,"afterCompact":false},{"index":9,"time":"09:34","ratio":0.052678,"inputTokens":52678,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.313,"originalCredits":0.313,"afterCompact":false},{"index":10,"time":"09:35","ratio":0.053891,"inputTokens":53891,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.271,"originalCredits":0.271,"afterCompact":false},{"index":11,"time":"09:35","ratio":0.056105,"inputTokens":56105,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.194,"originalCredits":0.194,"afterCompact":false},{"index":12,"time":"09:36","ratio":0.057385,"inputTokens":57385,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.258,"originalCredits":0.258,"afterCompact":false},{"index":13,"time":"09:36","ratio":0.062548,"inputTokens":62548,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.286,"originalCredits":0.286,"afterCompact":false},{"index":14,"time":"09:36","ratio":0.062825,"inputTokens":62825,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.195,"originalCredits":0.195,"afterCompact":false},{"index":15,"time":"09:36","ratio":0.063659,"inputTokens":63659,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.175,"originalCredits":0.175,"afterCompact":false},{"index":16,"time":"09:36","ratio":0.065482,"inputTokens":65482,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.264,"originalCredits":0.264,"afterCompact":false},{"index":17,"time":"09:37","ratio":0.06833,"inputTokens":68330,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.268,"originalCredits":0.268,"afterCompact":false},{"index":18,"time":"09:38","ratio":0.069701,"inputTokens":69701,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.465,"originalCredits":0.465,"afterCompact":false},{"index":19,"time":"09:38","ratio":0.080028,"inputTokens":80028,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.49,"originalCredits":0.49,"afterCompact":false},{"index":20,"time":"09:39","ratio":0.080862,"inputTokens":80862,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.281,"originalCredits":0.281,"afterCompact":false},{"index":21,"time":"09:39","ratio":0.082217,"inputTokens":82217,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.228,"originalCredits":0.228,"afterCompact":false},{"index":22,"time":"09:40","ratio":0.083182,"inputTokens":83182,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.431,"originalCredits":0.431,"afterCompact":false},{"index":23,"time":"09:40","ratio":0.086896,"inputTokens":86896,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.299,"originalCredits":0.299,"afterCompact":false},{"index":24,"time":"09:41","ratio":0.089286,"inputTokens":89286,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.394,"originalCredits":0.394,"afterCompact":false},{"index":25,"time":"09:41","ratio":0.091555,"inputTokens":91555,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.305,"originalCredits":0.305,"afterCompact":false},{"index":26,"time":"09:42","ratio":0.093238,"inputTokens":93238,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.389,"originalCredits":0.389,"afterCompact":false},{"index":27,"time":"09:42","ratio":0.097122,"inputTokens":97122,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.375,"originalCredits":0.375,"afterCompact":false},{"index":28,"time":"09:43","ratio":0.099396,"inputTokens":99396,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.426,"originalCredits":0.426,"afterCompact":false},{"index":29,"time":"09:43","ratio":0.102077,"inputTokens":102077,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.411,"originalCredits":0.411,"afterCompact":false},{"index":30,"time":"09:43","ratio":0.104355,"inputTokens":104355,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.369,"originalCredits":0.369,"afterCompact":false},{"index":31,"time":"09:44","ratio":0.105697,"inputTokens":105697,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.311,"originalCredits":0.311,"afterCompact":false},{"index":32,"time":"09:44","ratio":0.10766,"inputTokens":107660,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.433,"originalCredits":0.433,"afterCompact":false},{"index":33,"time":"09:44","ratio":0.110088,"inputTokens":110088,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.328,"originalCredits":0.328,"afterCompact":false},{"index":34,"time":"09:45","ratio":0.110885,"inputTokens":110885,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.354,"originalCredits":0.354,"afterCompact":false},{"index":35,"time":"09:45","ratio":0.112363,"inputTokens":112363,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.307,"originalCredits":0.307,"afterCompact":false},{"index":36,"time":"09:45","ratio":0.113976,"inputTokens":113976,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.403,"originalCredits":0.403,"afterCompact":false},{"index":37,"time":"09:46","ratio":0.11681,"inputTokens":116810,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.477,"originalCredits":0.477,"afterCompact":false},{"index":38,"time":"09:46","ratio":0.119247,"inputTokens":119247,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.336,"originalCredits":0.336,"afterCompact":false},{"index":39,"time":"09:46","ratio":0.120082,"inputTokens":120082,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.341,"originalCredits":0.341,"afterCompact":false},{"index":40,"time":"09:46","ratio":0.121012,"inputTokens":121012,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.303,"originalCredits":0.303,"afterCompact":false},{"index":41,"time":"09:47","ratio":0.121229,"inputTokens":121229,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.307,"originalCredits":0.307,"afterCompact":false},{"index":42,"time":"09:47","ratio":0.121803,"inputTokens":121803,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.295,"originalCredits":0.295,"afterCompact":false},{"index":43,"time":"09:47","ratio":0.122563,"inputTokens":122563,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.441,"originalCredits":0.441,"afterCompact":false},{"index":44,"time":"09:48","ratio":0.124507,"inputTokens":124507,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.402,"originalCredits":0.402,"afterCompact":false},{"index":45,"time":"09:48","ratio":0.12579,"inputTokens":125790,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.321,"originalCredits":0.321,"afterCompact":false},{"index":46,"time":"09:48","ratio":0.12662,"inputTokens":126620,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.378,"originalCredits":0.378,"afterCompact":false},{"index":47,"time":"09:48","ratio":0.128879,"inputTokens":128879,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.39,"originalCredits":0.39,"afterCompact":false},{"index":48,"time":"09:49","ratio":0.130107,"inputTokens":130107,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.387,"originalCredits":0.387,"afterCompact":false},{"index":49,"time":"09:54","ratio":0.136923,"inputTokens":136923,"outputTokens":null,"usageSource":"transcript-ratio","credits":3.822,"originalCredits":3.822,"afterCompact":false},{"index":50,"time":"09:54","ratio":0.14322,"inputTokens":143220,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.563,"originalCredits":0.563,"afterCompact":false},{"index":51,"time":"09:56","ratio":0.144654,"inputTokens":144654,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.742,"originalCredits":0.742,"afterCompact":false},{"index":52,"time":"09:56","ratio":0.151081,"inputTokens":151081,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.635,"originalCredits":0.635,"afterCompact":false},{"index":53,"time":"09:56","ratio":0.153366,"inputTokens":153366,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.406,"originalCredits":0.406,"afterCompact":false},{"index":54,"time":"09:57","ratio":0.15352,"inputTokens":153520,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.457,"originalCredits":0.457,"afterCompact":false},{"index":55,"time":"09:57","ratio":0.155412,"inputTokens":155412,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.407,"originalCredits":0.407,"afterCompact":false},{"index":56,"time":"09:57","ratio":0.157358,"inputTokens":157358,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.423,"originalCredits":0.423,"afterCompact":false},{"index":57,"time":"09:58","ratio":0.159461,"inputTokens":159461,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.447,"originalCredits":0.447,"afterCompact":false},{"index":58,"time":"09:58","ratio":0.160996,"inputTokens":160996,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.443,"originalCredits":0.443,"afterCompact":false},{"index":59,"time":"09:58","ratio":0.16212,"inputTokens":162120,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.413,"originalCredits":0.413,"afterCompact":false},{"index":60,"time":"09:58","ratio":0.163931,"inputTokens":163931,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.454,"originalCredits":0.454,"afterCompact":false},{"index":61,"time":"09:59","ratio":0.166115,"inputTokens":166115,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.531,"originalCredits":0.531,"afterCompact":false},{"index":62,"time":"09:59","ratio":0.167928,"inputTokens":167928,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.454,"originalCredits":0.454,"afterCompact":false},{"index":63,"time":"09:59","ratio":0.168562,"inputTokens":168562,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.479,"originalCredits":0.479,"afterCompact":false},{"index":64,"time":"10:00","ratio":0.170082,"inputTokens":170082,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.474,"originalCredits":0.474,"afterCompact":false},{"index":65,"time":"10:00","ratio":0.171265,"inputTokens":171265,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.469,"originalCredits":0.469,"afterCompact":false},{"index":66,"time":"10:01","ratio":0.176094,"inputTokens":176094,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.577,"originalCredits":0.577,"afterCompact":false},{"index":67,"time":"10:01","ratio":0.177855,"inputTokens":177855,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.45,"originalCredits":0.45,"afterCompact":false},{"index":68,"time":"10:01","ratio":0.178261,"inputTokens":178261,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.426,"originalCredits":0.426,"afterCompact":false},{"index":69,"time":"10:01","ratio":0.178639,"inputTokens":178639,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.419,"originalCredits":0.419,"afterCompact":false},{"index":70,"time":"10:01","ratio":0.179249,"inputTokens":179249,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.472,"originalCredits":0.472,"afterCompact":false},{"index":71,"time":"10:02","ratio":0.18031,"inputTokens":180310,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.452,"originalCredits":0.452,"afterCompact":false},{"index":72,"time":"10:02","ratio":0.181384,"inputTokens":181384,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.479,"originalCredits":0.479,"afterCompact":false},{"index":73,"time":"10:02","ratio":0.182593,"inputTokens":182593,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.459,"originalCredits":0.459,"afterCompact":false},{"index":74,"time":"10:02","ratio":0.184421,"inputTokens":184421,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.521,"originalCredits":0.521,"afterCompact":false},{"index":75,"time":"10:03","ratio":0.186008,"inputTokens":186008,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.55,"originalCredits":0.55,"afterCompact":false},{"index":76,"time":"10:03","ratio":0.187675,"inputTokens":187675,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.465,"originalCredits":0.465,"afterCompact":false},{"index":77,"time":"10:03","ratio":0.188386,"inputTokens":188386,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.48,"originalCredits":0.48,"afterCompact":false},{"index":78,"time":"10:04","ratio":0.189136,"inputTokens":189136,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.597,"originalCredits":0.597,"afterCompact":false},{"index":79,"time":"10:04","ratio":0.19198,"inputTokens":191980,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.589,"originalCredits":0.589,"afterCompact":false},{"index":80,"time":"10:04","ratio":0.193508,"inputTokens":193508,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.477,"originalCredits":0.477,"afterCompact":false},{"index":81,"time":"10:04","ratio":0.194787,"inputTokens":194787,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.508,"originalCredits":0.508,"afterCompact":false},{"index":82,"time":"10:05","ratio":0.196108,"inputTokens":196108,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.517,"originalCredits":0.517,"afterCompact":false},{"index":83,"time":"10:05","ratio":0.196933,"inputTokens":196933,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.505,"originalCredits":0.505,"afterCompact":false},{"index":84,"time":"10:05","ratio":0.197742,"inputTokens":197742,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.466,"originalCredits":0.466,"afterCompact":false},{"index":85,"time":"10:06","ratio":0.200877,"inputTokens":200877,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.663,"originalCredits":0.663,"afterCompact":false},{"index":86,"time":"10:06","ratio":0.203189,"inputTokens":203189,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.525,"originalCredits":0.525,"afterCompact":false},{"index":87,"time":"10:06","ratio":0.203551,"inputTokens":203551,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.481,"originalCredits":0.481,"afterCompact":false},{"index":88,"time":"10:06","ratio":0.209021,"inputTokens":209021,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.611,"originalCredits":0.611,"afterCompact":false},{"index":89,"time":"10:07","ratio":0.20917,"inputTokens":209170,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.5,"originalCredits":0.5,"afterCompact":false},{"index":90,"time":"10:07","ratio":0.210506,"inputTokens":210506,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.543,"originalCredits":0.543,"afterCompact":false},{"index":91,"time":"10:07","ratio":0.211235,"inputTokens":211235,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.495,"originalCredits":0.495,"afterCompact":false},{"index":92,"time":"10:07","ratio":0.211889,"inputTokens":211889,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.531,"originalCredits":0.531,"afterCompact":false},{"index":93,"time":"10:07","ratio":0.212687,"inputTokens":212687,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.517,"originalCredits":0.517,"afterCompact":false},{"index":94,"time":"10:07","ratio":0.21315,"inputTokens":213150,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.492,"originalCredits":0.492,"afterCompact":false},{"index":95,"time":"10:08","ratio":0.214108,"inputTokens":214108,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.514,"originalCredits":0.514,"afterCompact":false},{"index":96,"time":"10:08","ratio":0.215018,"inputTokens":215018,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.548,"originalCredits":0.548,"afterCompact":false},{"index":97,"time":"10:23","ratio":0.223583,"inputTokens":223583,"outputTokens":null,"usageSource":"transcript-ratio","credits":6.29,"originalCredits":6.29,"afterCompact":false},{"index":98,"time":"10:24","ratio":0.225184,"inputTokens":225184,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.569,"originalCredits":0.569,"afterCompact":false},{"index":99,"time":"10:24","ratio":0.225747,"inputTokens":225747,"outputTokens":null,"usageSource":"transcript-ratio","credits":0.531,"originalCredits":0.531,"afterCompact":false}],"identity":{"sumAttributed":13538583,"billedInputTokens":13538583,"absDiff":0,"ok":true},"pluginVersion":"2.7.4","selfCmd":"\"C:\\Users\\lswlc\\.qoder-cn\\plugins\\cache\\qoder-marketplace\\qoder-credits-inspector\\2.7.4\\bin\\credits-inspector.cmd\" cli","linkHealth":{"matched":0,"requests":99,"coverage":0,"usageSource":"transcript-ratio","breakdown":{"proxy":0,"transcriptTokens":0,"transcriptRatio":99},"logRecords":0,"lastRecordAt":null,"recentRequests":0,"proxyErrors":null,"clientAbort":null,"clientAbortMaxMs":null,"upstreamRejected":null,"aborted":null,"truncated":null,"noUsage":null,"slowestMs":null,"supersededFailure":null},"subagents":{"scanned":true,"dir":"C:\\Users\\lswlc\\.qoder-cn\\projects\\D--Users-Desktop-----\\dcde6d4f-09d8-4d1c-a360-93133d06c392\\subagents","probedPaths":["C:\\Users\\lswlc\\.qoder-cn\\projects\\D--Users-Desktop-----\\dcde6d4f-09d8-4d1c-a360-93133d06c392\\subagents","C:\\Users\\lswlc\\.qoder-cn\\projects\\dcde6d4f-09d8-4d1c-a360-93133d06c392\\subagents"],"reason":"ok","count":3,"items":[{"agentId":"ageneral-purpose-a308077fa33d7415","agentType":"general-purpose","description":"Scan APK assets for exposed secrets","toolUseId":"call_3bfae95e9dc345b8a9d12f78","roundTrips":52,"billedInputTokens":944096,"peakContextRatio":0.1444,"credits":17.356,"originalCredits":17.356,"error":null},{"agentId":"ageneral-purpose-c78a568127893a0f","agentType":"general-purpose","description":"Audit APK manifests","toolUseId":"call_b9582a8063f14e09a50fbdbe","roundTrips":39,"billedInputTokens":385888,"peakContextRatio":0.0811,"credits":8.345,"originalCredits":8.345,"error":null},{"agentId":"ageneral-purpose-3319833ed63094e3","agentType":"general-purpose","description":"Install RE toolchain to E:","toolUseId":"call_2852fe41fdf8412e8cd1588a","roundTrips":8,"billedInputTokens":29867,"peakContextRatio":0.0222,"credits":1.283,"originalCredits":1.283,"error":null}],"totals":{"roundTrips":99,"billedInputTokens":1359851,"credits":26.984,"originalCredits":26.984},"combined":{"roundTrips":198,"billedInputTokens":14898434,"credits":77.881,"originalCredits":77.881}},"manual":null,"artifacts":{"report":"report.json","canvas":"请对这两个APK进行安全测试，看看能不能脱壳de__f11bf0a7.canvas.tsx"}} as unknown as Report;

function human(n: number): string {
  if (!isFinite(n)) return "—";
  const abs = Math.abs(n);
  if (abs >= 1e9) return (n / 1e9).toFixed(2) + "B";
  if (abs >= 1e6) return (n / 1e6).toFixed(2) + "M";
  if (abs >= 1e3) return (n / 1e3).toFixed(1) + "K";
  return String(Math.round(n));
}

function pct(x: number): string {
  return (x * 100).toFixed(1) + "%";
}

// —— 可用性口径：把 report.availability 翻成人话，并决定某个数字该显示值、「≈」还是「—」——
const AVAIL_LABEL: Record<string, string> = {
  measured: "实测",
  derived: "推导",
  fallback: "回退",
  manual: "手工",
  unavailable: "不可用",
};

const SOURCE_LABEL: Record<string, string> = {
  "desktop-rich": "桌面端富转录",
  "ide-lite": "IDE 端精简转录",
  unknown: "来源未知",
};

function availOf(av: Availability | undefined, key: keyof Availability, dflt: Avail = "measured"): Avail {
  return (av?.[key] as Avail | undefined) ?? dflt;
}

/** 段标题旁的性质标注：实测不标（默认就是实测），其余标出来。 */
function availTag(av: Availability | undefined, key: keyof Availability, dflt: Avail = "measured"): string {
  const v = availOf(av, key, dflt);
  return v === "measured" ? "" : `（${AVAIL_LABEL[v]}）`;
}

/** 不可用的量显示「—」而不是 0：IDE 端的 0 是「读不到」，不是「没发生」。 */
function orDash(
  v: number,
  av: Availability | undefined,
  key: keyof Availability,
  fmt: (n: number) => string = String
): string {
  return availOf(av, key) === "unavailable" ? "—" : fmt(v);
}

function kindLabel(kind: string): string {
  switch (kind) {
    case "read":
      return "读取";
    case "write":
      return "写入";
    case "search":
      return "搜索";
    case "shell":
      return "命令";
    default:
      return "其他";
  }
}

function shortTime(iso: string | null): string {
  if (!iso) return "—";
  const d = new Date(iso);
  if (isNaN(d.getTime())) return String(iso);
  const p = (v: number) => String(v).padStart(2, "0");
  return `${p(d.getMonth() + 1)}-${p(d.getDate())} ${p(d.getHours())}:${p(d.getMinutes())}`;
}

export default function SessionTokensReport() {
  if (!REPORT) {
    return (
      <ReportShell width="wide" ariaLabel="会话 token 消耗截析">
        <Stack gap="component">
          <H1>会话 token 消耗截析</H1>
          <Text tone="secondary">报告数据尚未注入。请在会话中触发一次 Stop 钩子，或运行 CLI 生成 report.json。</Text>
        </Stack>
      </ReportShell>
    );
  }

  const r = REPORT;
  const s = r.session;
  const c = r.context;
  const t = r.totals;
  const av = r.availability;
  const manual = r.manual ?? null;
  const sourceLabel = SOURCE_LABEL[r.source ?? "unknown"] ?? "来源未知";
  // 有没有 usage 决定整份报告是「真值/推导」还是「一律 —」。手工回填的 credits 不算有 usage，
  // 否则下面按 ratio 推导的图表会照画一堆 0。
  const hasUsage = availOf(av, "roundTrips") === "measured";
  const manualCredits = manual?.credits ?? null;

  // 报告里出现的命令一律用数据层注入的插件入口（Windows 上是自带启动器的绝对路径，免装 Node）。
  // 旧报告没有这个字段时回退原写法，不比改动前更差。
  const CLI = r.selfCmd || "node scripts/cli.mjs";

  // credits 覆盖范围：credits 与「计费输入总量」并排放在头部，读者一除就得到单价。
  // 混合会话里 credits 只来自转录路径的那几笔（实测某会话 413 笔里只有 1 笔带 credits），
  // 部分覆盖不说出来 = 把局部真值当全量展示。
  const cov = r.creditsCoverage ?? null;
  const covPartial = !!(cov && !cov.full && cov.roundTrips > 0);
  const covNote = covPartial ? ` · 仅覆盖 ${cov!.trips}/${cov!.roundTrips} 笔往返（占计费输入 ${pct(cov!.tokenShare)}）` : "";

  // 缓存命中：代理记录里一直带着 cachedTokens，此前采集了却从不呈现。
  const cachedMeasured = availOf(av, "cachedTokens") === "measured";
  const cachedText = cachedMeasured
    ? `输入 ${human(t.billedInputTokens)}，其中缓存命中 ${human(t.cachedTokens ?? 0)}（${pct(t.cachedShare ?? 0)}，${t.cachedTrips ?? 0} 笔往返带缓存）——供应商对重复叠加的前缀打折，故按 token 数的节省大于按计费的节省。`
    : "";

  // 代理告警只在「失败记录仍然成立」时才报：status.json 只写不清，陈旧失败会把用户推去改
  // 本来正确的 Base URL，越修越坏；而同一份报告里的 lastRecordAt / matched 是它在跑的硬证据。
  const proxyAlarm = r.proxy?.status && !r.proxy.statusSuperseded ? r.proxy.status : null;
  const proxyAlive = !proxyAlarm && (r.proxy?.logRecords ?? 0) > 0;

  // 官方 UI 一场会话扣费 = 主链 + 子代理，故有子代理时 headline 必须给 combined，否则比 UI 少一截
  const creditScope =
    r.subagents && r.subagents.count > 0
      ? {
          credits: r.subagents.combined.credits,
          note: `主链 ${t.credits} + 子代理 ${r.subagents.totals.credits} · 原始 ${r.subagents.combined.originalCredits}`,
        }
      : { credits: t.credits, note: `原始 ${t.originalCredits}（实测）` };

  const headline: MetricItem[] = [
    {
      label: "计费输入总量",
      value: hasUsage ? human(t.billedInputTokens) : "—",
      description: hasUsage
        ? availOf(av, "tokens") === "measured"
          ? `Σ prompt_tokens（实测真值）${covPartial ? ` · 覆盖全部 ${cov!.roundTrips} 笔往返` : ""}`
          : `Σ 上下文 × 往返${availTag(av, "tokens", "derived")}${covPartial ? ` · 覆盖全部 ${cov!.roundTrips} 笔往返` : ""}`
        : "转录无 usage",
    },
    {
      label: "当前上下文",
      value: hasUsage ? human(t.netContextTokens) : "—",
      description: hasUsage
        ? `峰值 ${pct(c.peakContextRatio)}${s.compactions ? "（压缩后起算）" : ""}`
        : "转录无 usage",
    },
    {
      label: "重发放大",
      value: hasUsage ? `${t.amplification}×` : "—",
      description: `往返 ${hasUsage ? `${s.roundTrips} 次` : "—"}`,
    },
    {
      label: "Credits",
      // 代理路径（自定义模型）token 是实测真值但 credits 无来源：hasUsage 为真也要显示「—」，
      // 否则 t.credits=0 会被读成「这次没花钱」。
      value:
        manualCredits != null
          ? `${manualCredits}`
          : hasUsage && availOf(av, "credits") !== "unavailable"
            ? `${creditScope.credits}`
            : "—",
      description:
        manualCredits != null
          ? `官方 UI 手工录入 · 本地 ${creditScope.credits}`
          : hasUsage && availOf(av, "credits") !== "unavailable"
            ? `${creditScope.note}${covNote}`
            : r.usageSource === "proxy" || r.usageSource === "transcript-tokens" || r.usageSource === "mixed"
              ? "自定义模型（BYOK）不经 Qoder 计费网关，无 credits 真值"
              : hasUsage
                ? "转录带 usage 但没有 credits 字段，本地无计费真值"
                : "本地不可用，见下方告警",
    },
  ];

  const pieData = r.byCategory.map((x) => ({ label: x.label, value: x.tokens }));

  // 系统提示词是报告里少数「用户能直接动」的一项：它每轮被完整重发，总量 = 每请求规模 × 往返数，
  // 而它的大小由装了多少插件与技能决定。占比小时不必啰嗦。
  const sysCat = r.byCategory.find((x) => x.key === "system");
  const sysNote =
    hasUsage && sysCat && sysCat.share >= 0.1
      ? ` 系统提示词占 ${pct(sysCat.share)}（${human(c.systemPromptTokens)}/请求 × ${s.roundTrips} 次往返 = ${human(sysCat.tokens)}）：它每轮都被完整重发，大小由你装了多少插件与技能决定，精简技能能直接压低这一项——本插件自己的技能描述也常驻在里面（约 170 token）。`
      : "";

  const tools = r.byTool.slice(0, 8);
  const toolCategories = tools.map((x) => x.tool);
  const toolSeries = [{ name: "重发 tokens", data: tools.map((x) => x.tokens) }];
  // 「单次」= 平均每次调用带来的重发 token。总量榜会埋掉次数少但每次极贵的工具：
  // 实测 Read 只 29 次却吃 335 万，单次是 Edit 的 2.6 倍。
  const toolRows = tools.map((x) => [
    x.tool,
    human(x.tokens),
    pct(x.share),
    String(x.calls),
    x.perCall == null ? "—" : human(x.perCall),
  ]);

  const files = r.byFile.slice(0, 20);
  const fileRows = files.map((f) => [
    f.label,
    kindLabel(f.kind),
    human(f.billed),
    pct(f.share),
    f.perRead == null ? "—" : human(f.perRead),
    String(f.trips),
    String(f.reads),
  ]);

  const byReq = r.byRequest ?? [];
  const reqLabels = byReq.map((x, i) => x.time || `#${x.index ?? i + 1}`);
  const reqInputs = byReq.map((x) => x.inputTokens);
  const reqCredits = byReq.map((x) => x.credits);
  // credits 只在覆盖全部往返时才画曲线：部分覆盖（BYOK 混合会话实测 413 笔里 1 笔有 credits）
  // 画出来是一地零，既读不出形状，还会暗示「其余往返没花钱」。
  const showCreditsChart = hasUsage && !covPartial && availOf(av, "credits") !== "unavailable";

  // 按类别下钻：类别小计行（accent/neutral）+ 其工具/文件明细行（default），用 rowTone 分组着色。
  const catDetail = r.byCategoryDetail ?? [];
  const detailRows: string[][] = [];
  const detailTones: ("accent" | "neutral" | "default")[] = [];
  for (const cc of catDetail) {
    const hasKids = cc.children.length > 0;
    detailRows.push([cc.label, "—", hasKids ? "小计" : "（整体，无工具/文件归属）", human(cc.tokens), pct(cc.share), "100%", "—"]);
    detailTones.push(hasKids ? "accent" : "neutral");
    for (const k of cc.children) {
      detailRows.push(["", k.tool || "—", k.label, human(k.tokens), pct(k.share), pct(k.catShare), String(k.trips)]);
      detailTones.push("default");
    }
  }

  // 子代理账：Agent 派发的子代理消耗不在主链里，单独一段呈现（无子代理则整段不渲染）。
  const sub = r.subagents;
  const subItems = sub?.items ?? [];
  const subRows: string[][] = [];
  const subTones: ("accent" | "default")[] = [];
  for (const a of subItems) {
    subRows.push([
      a.description || a.agentId,
      a.agentType || "—",
      String(a.roundTrips),
      human(a.billedInputTokens),
      pct(a.peakContextRatio),
      String(a.credits),
      String(a.originalCredits),
      a.error || "—",
    ]);
    subTones.push("default");
  }
  if (sub && subItems.length > 0) {
    subRows.push([
      "合计（主链 + 子代理）",
      "—",
      String(sub.combined.roundTrips),
      human(sub.combined.billedInputTokens),
      "—",
      String(sub.combined.credits),
      String(sub.combined.originalCredits),
      `主链 ${t.credits} / 子代理 ${sub.totals.credits}`,
    ]);
    subTones.push("accent");
  }

  // 压缩单笔成本：输入/摘要一律取数据层归一后的生效值（有代理实测就是实测，否则是客户端自估），
  // 并用「口径」列把两者分开——混着显示会让自估值被当成实测。
  const ccost = r.compactionCost;
  const ccItems = ccost?.items ?? [];
  const compactRows: string[][] = ccItems.map((e) => [
    `#${e.index}`,
    shortTime(e.at),
    e.trigger || "—",
    e.effectiveInputTokens == null ? "—" : human(e.effectiveInputTokens),
    e.effectiveOutputTokens == null ? "—" : human(e.effectiveOutputTokens),
    e.nextInputTokens == null ? "—" : human(e.nextInputTokens),
    e.savedTokens == null ? "—" : human(e.savedTokens),
    e.proxy && e.proxy.ms != null ? `${Math.round(e.proxy.ms / 1000)}s` : "—",
    e.proxy ? "实测" : "自估",
  ]);

  // IDE 端仅剩的真值：工具调用次数与文件读取次数（不依赖 usage，两种转录都写 tool_use 块）。
  const residueRows: string[][] = [];
  if (!hasUsage) {
    for (const x of r.byTool.filter((v) => v.calls > 0).sort((a, b) => b.calls - a.calls).slice(0, 15)) {
      residueRows.push([x.tool, "工具", String(x.calls), "—", "—"]);
    }
    for (const f of r.byFile.filter((v) => v.reads > 0).sort((a, b) => b.reads - a.reads).slice(0, 15)) {
      residueRows.push([f.label, kindLabel(f.kind), "—", String(f.reads), String(f.trips)]);
    }
  }

  // A1 三值：一次带 usage 的往返都没有时 0 <= max(2,0) 恒成立，会把「没数据」判成「校验通过」，
  // 故 breakdown.mjs 在 reqCount===0 时给 null；这里必须显示「不适用」而不是绿色通过。
  const identityText =
    r.identity.ok == null
      ? "恒等式 A1 不适用（本转录没有一次带 usage 的往返）。"
      : r.identity.ok
        ? `归因覆盖 ${pct(t.coverage)}${availTag(av, "categoryShare", "derived")}，恒等式 A1 通过（|Δ|=${r.identity.absDiff}）。`
        : `归因覆盖 ${pct(t.coverage)}，恒等式 A1 未通过（|Δ|=${r.identity.absDiff}）。`;
  // 窗口读不到时是静默回退的 200000，而所有 token 数字都乘它 —— 必须显式标 ≈ 与来源。
  const cwIsFallback = availOf(av, "contextWindow") === "fallback";
  const cwText = cwIsFallback ? `≈${human(c.contextWindow)}（回退值）` : human(c.contextWindow);
  // 当前占用头条：以最新上下文（currentContextTokens）为准；段内单调递增 ⇒ 旧版峰值与当前恒等，故合并为一条。
  const curCtx = c.currentContextTokens ?? c.peakContextTokens;
  const netAdv = c.netUserAdvice || c.peakUserAdvice || c.peakAdvice || null;
  const limitSrcLabel =
    c.userContextLimitSource === "manual" ? "手工"
    : c.userContextLimitSource === "config" ? "配置"
    : c.userContextLimitSource === "derived" ? "实测反推"
    : "默认";
  // 阈值来源非 manual/config/derived ⇒ 用的是内置兜底 200K，不是用户在 Qoder 设的真值，需显式提示如何改。
  const limitIsDefault = c.userContextLimitSource !== "manual" && c.userContextLimitSource !== "config" && c.userContextLimitSource !== "derived";
  // 上下文对比表：把旧版挤成一段小字的「界面显示 / 自动压缩实况 / 历史高点」拆成可扫读的行，无数据不占位。
  const ctxRows: string[][] = [];
  if (c.userContextLimit != null && Number.isFinite(c.contextWindow)) {
    ctxRows.push(
      c.contextWindow > c.userContextLimit
        ? ["Qoder 界面进度条", pct(c.netWindowRatio ?? c.peakContextRatio), `按模型物理窗口 ${cwText} 算，比你真实占比低约 ${(c.contextWindow / c.userContextLimit).toFixed(1)} 倍——界面显得偏空、有迷惑性，别信它`]
        : ["Qoder 界面进度条", pct(c.netWindowRatio ?? c.peakContextRatio), `按模型窗口 ${cwText} 算，与你实设上限一致，显示无偏差`],
    );
  }
  if (c.observedAutoCompactions != null && c.observedAutoCompactions > 0 && c.observedAutoTriggerTokens != null) {
    ctxRows.push(["自动压缩实况", `自动 ${c.observedAutoCompactions} 次`, `触发点在 ~${human(c.observedAutoTriggerTokens)}（窗口的 ${pct(c.autoTriggerRatio ?? 0)}）`]);
  } else if (s.compactions > 0) {
    ctxRows.push(["压缩实况", `手动 ${s.compactions} 次`, "本场未见自动压缩，均为你手动触发"]);
  }
  if (c.peakSessionNotable) {
    ctxRows.push(["压缩前历史高点", `${pct(c.peakSessionRatio ?? 0)}（${human(c.peakSessionTokens ?? 0)}）`, "本场曾达到的最高占用"]);
  }

  // 链路健康度：把 --request-log 的逐笔归因压成一行结论（明细属于排障，留在 CLI）。
  // 分两档：本会话确实走在代理链路上（proxy/mixed）才印「最近 N 笔」的失败统计与排障命令；
  // token 全来自转录的会话里，那些统计说的是别的会话，印成 warning + 命令是噪音，只留覆盖率与最近记录时间。
  // 纯官方模型用户从没配过代理，整行不渲染。
  const lhRaw = r.linkHealth ?? null;
  const lh = lhRaw && (r.proxy?.configured || lhRaw.matched > 0) ? lhRaw : null;
  const lhOnPath = !!lh && (lh.matched > 0 || lh.usageSource === "proxy" || lh.usageSource === "mixed");
  const lhErrors = lh ? lh.proxyErrors ?? 0 : 0;
  const lhBad = lhOnPath && lhErrors > 0;
  const lhTone: "info" | "warning" = lhBad ? "warning" : "info";
  // 三档拆分一行说清：代理实测 / 转录 input_tokens / 转录 ratio×window 各多少笔。
  // 旧报告（v3）无 breakdown 字段时退回到只报 matched。
  const lhBd = lh?.breakdown ?? null;
  const lhBdText = lhBd
    ? `拆分：代理 ${lhBd.proxy} 笔 · 转录 input_tokens ${lhBd.transcriptTokens} 笔 · 转录 ratio×窗口 ${lhBd.transcriptRatio} 笔`
    : "";
  const lhSrcNote = !lh
    ? ""
    : lh.usageSource === "proxy"
      ? "：全部为供应商实测"
      : lh.usageSource === "transcript-tokens"
        ? "：本会话 token 全来自转录 input_tokens（BYOK，代理未在链路上）"
        : lh.usageSource === "transcript-ratio"
          ? "：本会话 token 由 ratio×窗口推导（官方模型）"
          : lh.usageSource === "mixed"
            ? "：多源混合，以下拆分列为准"
            : lh.usageSource === "transcript"
              ? "：本会话 token 全部来自转录，代理不在链路上"
              : "";
  const lhText = !lh
    ? ""
    : [
        lh.requests > 0
          ? `代理覆盖 ${lh.matched}/${lh.requests} 笔往返（${pct(lh.coverage)}）${lhSrcNote}`
          : "本会话没有带 usage 的往返，代理无从覆盖",
        lhBdText,
        lh.lastRecordAt ? `代理最近记录 ${shortTime(lh.lastRecordAt)}` : proxyAlive ? "代理有记录但无时间戳" : "代理从未记到流量",
        lhOnPath && lh.recentRequests
          ? `最近 ${lh.recentRequests} 笔：代理失败 ${lh.proxyErrors} · 上游报错 ${lh.upstreamRejected} · 客户端提前断开 ${lh.aborted} · 成功但无 usage ${lh.noUsage}${
              lh.slowestMs != null ? ` · 最慢 ${Math.round(lh.slowestMs / 1000)}s` : ""
            }`
          : lhOnPath
            ? "请求诊断日志为空（运行中的代理是旧版，或还没记到）"
            : "",
        lhBad ? `有「代理失败」= 请求没出得去或代理自己抛了，跑 ${CLI} --request-log 看归因` : "",
        !lhOnPath && lhErrors > 0 ? `代理另有 ${lhErrors} 笔失败，属于走代理的那些会话` : "",
        lh.supersededFailure
          ? `${shortTime(lh.supersededFailure.at ?? null)} 那条「拉起失败（${lh.supersededFailure.error}）」已被之后的流量推翻，无需处理`
          : "",
      ]
        .filter(Boolean)
        .join("。") + "。";

  return (
    <ReportShell width="wide" ariaLabel="会话 token 消耗截析">
      <Stack gap="sectionCompact">
        <header>
          <Stack gap="component">
            <H1>会话 token 消耗截析</H1>
            <Text tone="secondary">
              {s.model || "未知模型"}
              {s.modelSource === "manual" ? "（手工录入）" : ""} · {sourceLabel} · 会话{" "}
              {String(s.id || "").slice(0, 8)}
              {s.title ? `「${s.title}」` : ""} · {shortTime(s.startedAt)} →{" "}
              {shortTime(s.endedAt)} · 压缩{" "}
              {availOf(av, "compactions") === "unavailable" ? "—" : `${s.compactions} 次`}
              {r.usageSource ? ` · usage 来源 ${
                r.usageSource === "proxy"
                  ? "代理实测"
                  : r.usageSource === "transcript-tokens"
                    ? "转录 input_tokens"
                    : r.usageSource === "transcript-ratio"
                      ? "转录 ratio×窗口"
                      : r.usageSource === "mixed"
                        ? "多源混合"
                        : "转录"
              }` : ""}
              {r.pluginVersion ? ` · v${r.pluginVersion}` : ""} · schema v{r.schemaVersion}
            </Text>
            <MetricsGrid variant="header" columns={4} items={headline} />
          </Stack>
        </header>

        {!hasUsage && r.source === "desktop-rich" && (
          <Callout tone="danger" title="本报告数值不可用：自定义模型（BYOK）不经 Qoder 计费网关">
            转录是桌面端富布局，但 assistant entry 里没有 message.usage——自定义模型（如千问
            tokenplan）的响应不经 Qoder 计费网关，credits / context_usage_ratio 无来源，提供商返回的
            usage 客户端也不落盘（已实测扫过 ~/.qoder-cn、~/.qoder、~/.qoder-cli 与 %APPDATA%\QoderCN）。
            本地补救（改一个配置文件即可，免装 Node、之后全自动）：编辑 {"`~/.qoder-credits-proxy/config.json`"}，
            把 {"`upstream`"} 填成你的供应商根地址（= Base URL 去掉结尾 /v1），再把自定义模型 Base URL 的 host:port
            换成 {`127.0.0.1:${r.proxy?.port ?? 49787}`}（路径保留），新开一个会话即自动拉起代理、按 message.id
            精确 join 出实测 token（credits 仍无真值）。装了 Node 也可用 {"`--setup-proxy`"} / {"`--check-proxy`"} 一步到位。
            手工回填通道同样可用：
            {"`.qoder-credits/overrides/<sessionId>.json`"}。
          </Callout>
        )}

        {!hasUsage && r.source !== "desktop-rich" && (
          <Callout tone="danger" title="本报告数值不可用：转录不含 message.usage">
            这是 {sourceLabel}（IDE 端客户端）。它的转录只写 session_meta / user / assistant / progress 四种 entry，
            message.usage 整个字段不存在，也不落到本地任何其它文件（已实测扫过 ~/.qoder-cn、~/.qoder、
            ~/.qoder-cli 与 %APPDATA%\QoderCN）。因此 Credits、token 与各类占比一律显示「—」而不是 0 ——
            0 会被误读成「这次没花钱」。真值只有官方 UI 有：把它填进{" "}
            {"`.qoder-credits/overrides/<sessionId>.json`"} 后重跑，上方会出现「官方 UI 真值」一段并与本地并列对账。
          </Callout>
        )}

        {manual && (
          <Callout tone="success" title="官方 UI 真值（手工录入，未覆盖任何本地数字）">
            Credits {manual.credits ?? "—"} · 原价 {manual.originalCredits ?? "—"}
            {manual.model ? ` · 模型 ${manual.model}` : ""}
            {manual.durationMin != null ? ` · 时长 ${manual.durationMin} min` : ""}
            {manual.startedAt ? ` · ${shortTime(manual.startedAt)}` : ""}
            {manual.localCoverage != null
              ? ` · 本地${manual.localScope === "combined" ? "合计（主链+子代理）" : "主链"} ${manual.localCredits ?? t.credits}，覆盖 ${pct(manual.localCoverage)}`
              : " · 本地无 usage，无法对账"}
            {manual.note ? `。备注：${manual.note}` : ""}
          </Callout>
        )}

        {sub && sub.count === 0 && sub.reason && sub.reason !== "no-dir" && (
          <Callout tone="warning" title={`子代理账未汇总（${sub.reason}）`}>
            探测过的候选目录：{(sub.probedPaths ?? []).join("  |  ") || "（无）"}
          </Callout>
        )}

        {proxyAlarm && (
          <Callout tone="warning" title={`代理自动启动失败（${proxyAlarm.error}）`}>
            {proxyAlarm.error === "EADDRINUSE"
              ? `端口 ${proxyAlarm.port ?? "—"} 被占用，自定义模型将无法对话。请换一个空闲端口重启代理：${CLI} --setup-proxy --port <新端口>，并把模型 Base URL 改成新端口。`
              : `代理未就绪（${proxyAlarm.error}），自定义模型可能无法对话。请运行 ${CLI} --check-proxy 查看链路状态。`}
          </Callout>
        )}

        {r.proxy?.dormant && !proxyAlarm && (
          <Callout tone="info" title="代理长期空闲">
            代理已配置但超过 14 天没有记录到流量（可能你已改回官方模型）。如不再使用自定义模型，可运行{" "}
            {CLI} --stop-proxy 停用代理；保留也不影响官方模型。
          </Callout>
        )}

        {cwIsFallback && (
          <Callout tone="warning" title="上下文窗口为回退值 200K（未从 runtime-config / usage 反推 / ManualTruth 拿到真值）">
            本会话所有以窗口为分母的占比与「峰值建议」都可能偏大，而绝对 token 数（已改以 S 真值为底）不受影响。
            建议在 {"`.qoder-credits/overrides/<sessionId>.json`"} 里手工填 {"`contextWindow`"}（如 qwen3-max=1000000），或等一笔带 input_tokens+ratio 的往返写入转录后自动反推生效。
          </Callout>
        )}

        {hasUsage && netAdv && c.userContextLimit != null && (
          <Stack gap="component">
            <Callout
              tone={netAdv.tone}
              title={`你真实的上下文占用 ${pct(c.netUserRatio ?? c.peakUserRatio ?? 0)}（${human(curCtx)} / 阈值 ${human(c.userContextLimit)}・${limitSrcLabel}）`}
            >
              {netAdv.text}
              {limitIsDefault && (
                <Text tone="secondary">
                  {` ⚙ 这里的 ${human(c.userContextLimit)} 是插件内置默认值，不是你在 Qoder「模型管理」里设的真实上限（插件读不到那个设置）。想按真实阈值算：在 ~/.qoder-credits-proxy/config.json 填 "userContextLimit": <你的上限>（对所有会话生效），或对本会话在 .qoder-credits/overrides/<会话id>.json 填同名字段，重跑报告即生效。`}
                </Text>
              )}
            </Callout>
            {ctxRows.length > 0 && (
              <Table
                headers={["对比口径", "数值", "说明"]}
                rows={ctxRows}
                density="compact"
              />
            )}
          </Stack>
        )}

        {c.thresholdNotEnforced && (
          <Callout tone="warning" title="⚠ 自动压缩不会在你设的阈值触发（本条最重要）">
            你的模型物理窗口是 {cwText}，Qoder 的自动压缩要等上下文涨到窗口 ~85%（≈{human(Math.round(c.contextWindow * 0.85))}）才触发；
            你在模型管理里设的 {human(c.userContextLimit)} 上限远在其下，永远不会触发自动压缩。
            请照上面「你真实的上下文占用」那条，到点自己手动压缩，别等它自动压。
          </Callout>
        )}

        {lh && (
          <Callout tone={lhTone} title="链路健康度">
            {lhText}
          </Callout>
        )}

        <Callout tone="info" title="度量口径">
          计费输入总量逐笔锁定真值（优先级：代理 promptTokens &gt; 转录 usage.input_tokens &gt; ratio{availTag(av, "contextRatio")} × {cwText}
          {cwIsFallback ? "，未拿到真窗口、全部 token 数字随之带 ≈" : ""}）；各类别/文件按块估算规模比例分摊
          {availTag(av, "categoryShare", "derived")}。{identityText}
          {cachedText ? ` ${cachedText}` : ""}
          {covPartial
            ? ` Credits 只来自 ${cov!.trips}/${cov!.roundTrips} 笔往返（占计费输入 ${pct(cov!.tokenShare)}），其余往返走代理实测、不经 Qoder 计费，故不要拿 Credits 去除以计费输入总量算单价。`
            : ""}
        </Callout>

        {byReq.length > 0 && (
          <ReportSection
            title="逐请求明细（每一次往返）"
            description={
              showCreditsChart
                ? "每个 round-trip 的真实输入规模与 credits；曲线骤降处为上下文压缩重置（顶部四项为会话累计，此处为每一次）"
                : `每个 round-trip 的真实输入规模；曲线骤降处为上下文压缩重置。credits 曲线未画：本会话只有 ${cov?.trips ?? 0}/${cov?.roundTrips ?? byReq.length} 笔往返带 credits（其余走代理实测、不经 Qoder 计费），画出来是一地零。`
            }
            meta={`${byReq.length} 次往返 · 压缩 ${orDash(s.compactions, av, "compactions")} 次`}
            divided
          >
            {showCreditsChart ? (
              <ChartComparisonGrid>
                <ChartContainer title="每次输入 tokens" ariaLabel="每次输入 tokens">
                  <LineChart
                    categories={reqLabels}
                    series={[{ name: "输入 tokens", data: reqInputs, tone: "info" }]}
                    height={220}
                    valueFormatter={human}
                    ariaLabel="每次请求输入 tokens"
                  />
                </ChartContainer>
                <ChartContainer title="每次 credits" ariaLabel="每次 credits">
                  <LineChart
                    categories={reqLabels}
                    series={[{ name: "credits", data: reqCredits, tone: "warning" }]}
                    height={220}
                    ariaLabel="每次请求 credits"
                  />
                </ChartContainer>
              </ChartComparisonGrid>
            ) : (
              <ChartContainer title="每次输入 tokens" ariaLabel="每次输入 tokens">
                <LineChart
                  categories={reqLabels}
                  series={[{ name: "输入 tokens", data: reqInputs, tone: "info" }]}
                  height={220}
                  valueFormatter={human}
                  ariaLabel="每次请求输入 tokens"
                />
              </ChartContainer>
            )}
          </ReportSection>
        )}

        {hasUsage && ccItems.length > 0 && (
          <ReportSection
            title="压缩单笔成本（会话里最贵的那几笔调用）"
            description="每次压缩本身就是一笔普通模型调用：整份上下文当 prompt 进去、摘要当 completion 出来。此前报告只显示「压缩 N 次」，把单笔最贵的开销藏成了一个计数。「省下」= 压缩前规模 − 压缩后首轮实测输入（地板）。口径列：实测=能在代理日志里唯一对上的供应商真值；自估=客户端在压缩边界里写的前后规模。"
            meta={`${ccItems.length} 次 · 输入累计 ${human(ccost?.totals.preTokens ?? 0)} · 摘要累计 ${human(ccost?.totals.postTokens ?? 0)} · 累计省下 ${human(ccost?.totals.savedTokens ?? 0)} · 其中 ${ccost?.totals.measured ?? 0} 笔为供应商实测`}
            divided
          >
            <Table
              headers={["第几次", "时刻", "触发", "输入", "摘要输出", "压缩后首轮", "省下", "耗时", "口径"]}
              rows={compactRows}
              density="compact"
              stickyHeader
            />
          </ReportSection>
        )}

        {sub && subItems.length > 0 && (
          <ReportSection
            title="子代理账（Agent 派发）"
            description="子代理的每次往返只写进它自己的独立转录，不计入上方主链任何数字；官方 UI 的一场会话扣费 = 主链 + 各子代理。"
            meta={`${subItems.length} 个子代理 · 主链 ${t.credits} + 子代理 ${sub.totals.credits} = 合计 ${sub.combined.credits} Credits`}
            divided
          >
            <Table
              headers={["子代理", "类型", "往返", "计费输入", "峰值占比", "Credits", "原价", "备注"]}
              rows={subRows}
              rowTone={subTones}
              density="compact"
              stickyHeader
            />
          </ReportSection>
        )}

        {hasUsage && r.byCategory.length > 0 && (
          <ReportSection
            title="按类别占比"
            description={`会话计费输入 token 在各来源间的分布（完整划分，占比之和 = 100%）${sysNote}`}
            meta={human(t.billedInputTokens) + ` tokens${availTag(av, "categoryShare", "derived")}`}
            divided
          >
            <ChartContainer ariaLabel="按类别占比">
              <PieChart donut data={pieData} centerLabel="计费输入" valueFormatter={human} />
            </ChartContainer>
          </ReportSection>
        )}

        {hasUsage && catDetail.length > 0 && (
          <ReportSection
            title="按类别下钻（工具 / 文件路径）"
            description="每个类别的消耗再拆到工具与具体文件/路径：工具返回、工具调用可精确到路径，其余类别为整体（无文件归属）。数值均为重发计费 token。"
            meta={`占总额=占计费输入总量 · 占本类=占该类别 · 程数=存活往返累计${availTag(av, "fileShare", "derived")}`}
            divided
          >
            <Table
              headers={["类别", "工具", "文件 / 路径", "重发 tokens", "占总额", "占本类", "程数"]}
              rows={detailRows}
              rowTone={detailTones}
              density="compact"
              stickyHeader
            />
          </ReportSection>
        )}

        {hasUsage && tools.length > 0 && (
          <ReportSection
            title="按工具占比"
            description="各工具相关内容（调用参数 + 返回）重发累计的计费 token 占比（仅工具相关块，非完整划分，占比之和 < 100%）。「单次」= 平均每次调用带来的重发 token：总量榜会把「次数少但每次极贵」的工具埋掉，这一列专门把它捞出来。"
            meta={`token 占比${availTag(av, "toolShare", "derived")} · 调用次数为实测`}
            divided
          >
            <Stack gap="component">
              <ChartContainer ariaLabel="按工具占比">
                <BarChart horizontal categories={toolCategories} series={toolSeries} valueFormatter={human} ariaLabel="按工具占比" />
              </ChartContainer>
              <Table
                headers={["工具", "重发 tokens", "占比", "调用", "单次"]}
                rows={toolRows}
                density="compact"
                stickyHeader
              />
            </Stack>
          </ReportSection>
        )}

        {hasUsage && fileRows.length > 0 && (
          <ReportSection
            title="按文件占比"
            description="精确到路径/文件名：内容随上下文被重复发送累计的计费 token 占比（Top 20，仅可归因文件的块）。「单次读取」= 这个文件平均每次被读取最终烧掉多少（含此后每一程的重发）——读一次就烧掉十几万的文件，在按总量排序的榜上毫不起眼。"
            meta={`程数=存活往返累计 · 读取=返回次数（实测）${availTag(av, "fileShare", "derived")}`}
            divided
          >
            <Table
              headers={["文件", "种类", "重发 tokens", "占比", "单次读取", "程数", "读取"]}
              rows={fileRows}
              density="compact"
              stickyHeader
            />
          </ReportSection>
        )}

        {!hasUsage && residueRows.length > 0 && (
          <ReportSection
            title="工具调用与文件读取（计数为实测）"
            description="占比与 token 一律不可用，但 tool_use 块两种转录都写，所以「谁被调了几次、谁被读了几次」仍是真值 —— IDE 端不是一无所有。"
            meta={`${t.toolCalls ?? 0} 次工具调用${availTag(av, "toolCalls")} · ${t.fileReads ?? 0} 次文件读取${availTag(av, "fileReads")} · ${s.turns} 轮对话`}
            divided
          >
            <Table
              headers={["工具 / 文件", "种类", "调用", "读取", "程数"]}
              rows={residueRows}
              density="compact"
              stickyHeader
            />
          </ReportSection>
        )}
      </Stack>
    </ReportShell>
  );
}
