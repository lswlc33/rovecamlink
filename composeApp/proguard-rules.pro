# R8 的补充规则。多数第三方库自带 consumer rules（Compose、kotlinx.serialization、Ktor、
# Media3 的 aar 里都附了 proguard.txt），这里只写「库自己没声明、R8 因此直接报错」的那几条，
# 外加一条本项目的主动取舍（-dontobfuscate）。

# slf4j-api 的 LoggerFactory.bind() 有一条静态初始化路径去找 org.slf4j.impl.StaticLoggerBinder：
# 那是 slf4j 1.7 时代的绑定实现，Ktor 只依赖 slf4j-api 不带实现，所以这个类在整张依赖图里
# 根本不存在。运行时的真实行为是「找不到绑定就退化成 NOP logger」，R8 只在编译期看不到实现，
# 于是把它当成缺失类。放行即可，无需引一个日志实现进来。
-dontwarn org.slf4j.impl.StaticLoggerBinder

# 只裁代码，不改类名/方法名。
#
# 理由是本项目把「导出可读的崩溃现场」当功能做：CrashRecorder 在进程被杀前把未捕获异常
# 连同最多 24 帧堆栈写进诊断 TXT（见 core/log/CrashRecorder.kt，2026-09-22 现场丢过四次崩溃
# 才补上的）。混淆之后那 24 帧会变成 a.b.c 这样的名字，没有 mapping.txt 就完全读不出来，
# 而现场的测试同学不会去下载 CI 的 mapping 再跑 retrace——功能等于废掉。
#
# 代价很小，所以这个取舍很划算：混淆在这里几乎不省体积，省体积的是裁剪。同一个包，
# 只把这一行加/去掉各构建一次：
#   release 混淆   = 3.58MB
#   release 不混淆 = 3.64MB   (+0.06MB，+1.7%)
# 原因是体积大头来自「整包未裁剪」（19.93MB，见 build.gradle.kts 的 buildTypes 注释），
# 而 Compose/KMP 的类名本来就短，改名省不下多少；裁剪（usage.txt 里裁掉 Guava 1998/2107、
# Compose foundation 2672、miuix 1014、Media3 exoplayer 1101、Ktor 587、zxing 310）才是关键。
#
# 结论：用 0.06MB 换「现场日志里的堆栈直接可读」，值得。若哪天要上架商店、要求必须混淆，
# 删掉这一行即可，其余配置不用动（release 仍会产出 mapping.txt 供 retrace）。
-dontobfuscate
