# TUWIN — 类与成员明细：com.tuwinsmart.tuwin.core.event

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 5 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.tuwinsmart.tuwin.core.event.DeviceAddedEvent`
L9 · [class] public final DeviceAddedEvent · `com/tuwinsmart/tuwin/core/event/DeviceAddedEvent.java`
注解：
### `com.tuwinsmart.tuwin.core.event.NetworkChangeEvent`
L11 · [class] public final NetworkChangeEvent · `com/tuwinsmart/tuwin/core/event/NetworkChangeEvent.java`
注解：

字段/常量（1）：
- `List<Network> networks`  L12

方法（2）：
- `public NetworkChangeEvent(List<? extends Network> list)`  L15
- `List<Network> getNetworks()`  L19
### `com.tuwinsmart.tuwin.core.event.SoftVersionUpdateCompleteEvent`
L9 · [class] public final SoftVersionUpdateCompleteEvent · `com/tuwinsmart/tuwin/core/event/SoftVersionUpdateCompleteEvent.java`
注解：
### `com.tuwinsmart.tuwin.core.event.TaskDownloadFinishEvent`
L9 · [class] public final TaskDownloadFinishEvent · `com/tuwinsmart/tuwin/core/event/TaskDownloadFinishEvent.java`
注解：
### `com.tuwinsmart.tuwin.core.event.TaskFinishInsertEvent`
L11 · [class] public final TaskFinishInsertEvent · `com/tuwinsmart/tuwin/core/event/TaskFinishInsertEvent.java`
注解：

字段/常量（1）：
- `DownloadTask task`  L12

方法（8）：
- `TaskFinishInsertEvent copy$default(TaskFinishInsertEvent taskFinishInsertEvent, DownloadTask downloadTask, int i, Object obj)`  L14
- `DownloadTask getTask()`  L22
- `TaskFinishInsertEvent copy(DownloadTask task)`  L26
    - 体内字面量："task"
- `boolean equals(Object other)`  L31
- `int hashCode()`  L38
- `String toString()`  L42
    - 体内字面量："TaskFinishInsertEvent(task=" · ")"
- `public TaskFinishInsertEvent(DownloadTask task)`  L46
    - 体内字面量："task"
- `DownloadTask getTask()`  L51