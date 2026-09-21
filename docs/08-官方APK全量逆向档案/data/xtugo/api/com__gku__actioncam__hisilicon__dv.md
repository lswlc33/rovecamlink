# XTU GO — 类与成员明细：com.gku.actioncam.hisilicon.dv

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 7 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.hisilicon.dv.LogService`
L41 · [class] public LogService · extends `Service` · `com/gku/actioncam/hisilicon/dv/LogService.java`

字段/常量（30）：
- `int MEMORY_LOG_FILE_MAX_SIZE = 10485760`  L42
- `int MEMORY_LOG_FILE_MONITOR_INTERVAL = 600000`  L43
- `String MONITOR_LOG_SIZE_ACTION = "MONITOR_LOG_SIZE"`  L44
- `int SDCARD_LOG_FILE_SAVE_DAYS = 7`  L45
- `String SWITCH_LOG_FILE_ACTION = "SWITCH_LOG_FILE_ACTION"`  L46
- `String TAG = "LogService"`  L47
- `String CURR_INSTALL_LOG_NAME`  L48
- `String LOG_PATH_MEMORY_DIR`  L49
- `String LOG_PATH_SDCARD_DIR`  L50
- `String LOG_SERVICE_LOG_PATH`  L51
- `LogTaskReceiver logTaskReceiver`  L52
- `Process process`  L53
- `SDStateMonitorReceiver sdStateReceiver`  L54
- `PowerManager.WakeLock wakeLock`  L55
- `OutputStreamWriter writer`  L56
- `int SDCARD_TYPE = 0`  L57
- `int MEMORY_TYPE = 1`  L58
- `int CURR_LOG_TYPE = 0`  L59
- `String logServiceLogName = "Log.log"`  L60
- `boolean logSizeMoniting = false`  L63
- `Process processExec = null`  L154
- `Process process = this.process`  L190
- `Process processExec = null`  L237
- `String str = this.CURR_INSTALL_LOG_NAME`  L333
- `File file2 = fileArrListFiles[i]`  L410
- `FileOutputStream fileOutputStream`  L424
- `FileInputStream fileInputStream = null`  L425
- `byte[] bArr = new byte[8192]`  L435
- `OutputStreamWriter outputStreamWriter = this.writer`  L644
- `Process process = this.process`  L652

方法（26）：
- `IBinder onBind(Intent intent)`  L66 @Override
- `void onCreate()`  L71 @Override
- `void init()`  L79
    - 体内字面量："power" · "LogService onCreate"
- `void register()`  L89
    - 体内字面量："android.intent.action.MEDIA_MOUNTED" · "android.intent.action.MEDIA_UNMOUNTED"
- `int getCurrLogType()`  L111
    - 体内字面量："mounted"
- `void deploySwitchLogFileTask()`  L115
    - 体内字面量："deployNextTask succ,next task time is:"
- `void clearLogCache()`  L150
    - 体内字面量："logcat" · "-c"
- `void killLogcatProc(List<ProcessInfo> allProcList)`  L189
- `String getAppUser(String packName, List<ProcessInfo> allProcList)`  L202
- `List<ProcessInfo> getProcessInfoList(List<String> orgProcessList)`  L212
- `List<String> getAllProcess()`  L235
- `void createLogCollector()`  L274
    - 体内字面量：".log" · "logcat" · "-f" · "-v" · "*:w" · "start collecting the log,and log name is:" · "CollectorThread == >" · "CollectorThread == >"
- `String getLogPath()`  L292
    - 体内字面量：".log" · "Log stored in memory, the path is:" · "Log stored in SDcard, the path is:"
- `void handleLog()`  L305
- `void deployLogSizeMonitorTask()`  L316
    - 体内字面量："deployLogSizeMonitorTask() succ !"
- `void cancelLogSizeMonitorTask()`  L325
    - 体内字面量："canelLogSizeMonitorTask() succ"
- `void checkLogSize()`  L332
- `void createLogDir()`  L347
    - 体内字面量："mounted" · "move file failed,dir is not created succ"
- `void moveLogfile()`  L361
    - 体内字面量："mounted"
- `void deleteSDcardExpiredLog()`  L380
    - 体内字面量："delete expired log success,the log path is:"
- `boolean canDeleteSDLog(String createDateStr)`  L393
- `void deleteMemoryExpiredLog()`  L404
- `boolean copy(File source, File target)`  L423
- `void recordLogServiceLog(String msg)`  L516
    - 体内字面量：" : " · "\n"
- `String getFileNameWithoutExtension(String fileName)`  L531
- `void onDestroy()`  L641 @Override
    - 体内字面量："LogService onDestroy"
### `com.gku.actioncam.hisilicon.dv.LogService$FileComparator`
L620 · [class] FileComparator · implements `Comparator<File>` · `com/gku/actioncam/hisilicon/dv/LogService.java`

方法（1）：
- `int compare(File file1, File file2)`  L625 @Override
### `com.gku.actioncam.hisilicon.dv.LogService$LogCollectorThread`
L126 · [class] LogCollectorThread · extends `Thread` · `com/gku/actioncam/hisilicon/dv/LogService.java`

方法（2）：
- `public LogCollectorThread()`  L127
    - 体内字面量："LogCollectorThread" · "LogCollectorThread is create"
- `void run()`  L133 @Override
### `com.gku.actioncam.hisilicon.dv.LogService$LogTaskReceiver`
L605 · [class] LogTaskReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/hisilicon/dv/LogService.java`

方法（1）：
- `void onReceive(Context context, Intent intent)`  L610 @Override
### `com.gku.actioncam.hisilicon.dv.LogService$ProcessInfo`
L535 · [class] ProcessInfo · `com/gku/actioncam/hisilicon/dv/LogService.java`

字段/常量（4）：
- `String name`  L536
- `String pid`  L537
- `String ppid`  L538
- `String user`  L539

方法（1）：
- `String toString()`  L544
    - 体内字面量："user=" · " pid=" · " ppid=" · " name="
### `com.gku.actioncam.hisilicon.dv.LogService$SDStateMonitorReceiver`
L582 · [class] SDStateMonitorReceiver · extends `BroadcastReceiver` · `com/gku/actioncam/hisilicon/dv/LogService.java`

方法（1）：
- `void onReceive(Context context, Intent intent)`  L587 @Override
    - 体内字面量："android.intent.action.MEDIA_UNMOUNTED" · "SDcar is UNMOUNTED" · "SDcar is MOUNTED"
### `com.gku.actioncam.hisilicon.dv.LogService$StreamConsumer`
L549 · [class] StreamConsumer · extends `Thread` · `com/gku/actioncam/hisilicon/dv/LogService.java`

字段/常量（3）：
- `InputStream is`  L550
- `List<String> list`  L551
- `List<String> list = this.list`  L571

方法（1）：
- `void run()`  L563 @Override