# idGoLive — 类与成员明细：com.icatch.golive.db

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 2 个文件 / 2 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatch.golive.db.CameraSlotSQLite`
L17 · [class] public CameraSlotSQLite · `com/icatch/golive/db/CameraSlotSQLite.java`

字段/常量（8）：
- `CameraSlotSQLite instance`  L18
- `String TAG = "CameraSlotSQLite"`  L19
- `ArrayList<CameraSlot> camSlotList`  L20
- `Context context`  L21
- `SQLiteDatabase db`  L22
- `boolean z = false`  L67
- `Cursor cursor = cursorRawQuery`  L86
- `ArrayList<CameraSlot> arrayList = this.camSlotList`  L98

方法（11）：
- `private CameraSlotSQLite()`  L24
- `void creatTable(Context context)`  L28
    - 体内字面量："start creatTable" · "end creatTable"
- `CameraSlotSQLite getInstance()`  L35
- `int switchBoolToInt(Boolean bool)`  L42
- `Boolean switchIntToBool(int i)`  L46
- `void closeDB()`  L50
- `void deleteByPosition(int i)`  L54
    - 体内字面量："start delete slotPosition=" · "end delete"
- `ArrayList<CameraSlot> getAllCameraSlotFormDb()`  L60
    - 体内字面量："start getAllCameraSlotFormDb" · "select * from cameraSlotInfo" · "end rawQuery ="
- `boolean insert(CameraSlot cameraSlot)`  L105
    - 体内字面量："start insert isOccupied=" · "isOccupied" · "cameraName" · "imageBuffer" · "cameraType" · "addType" · "wifiPassword" · "failed to insert!" · "end: insert success"
- `void update(CameraSlot cameraSlot)`  L122
    - 体内字面量："start update slotPosition=" · "isOccupied" · "imageBuffer" · "cameraName" · "cameraType" · "addType" · "wifiPassword" · "_id=?" · "end update"
- `void updateImage(Bitmap bitmap)`  L137
### `com.icatch.golive.db.CameraSlotSQLiteHelper`
L9 · [class] public CameraSlotSQLiteHelper · extends `SQLiteOpenHelper` · `com/icatch/golive/db/CameraSlotSQLiteHelper.java`

字段/常量（6）：
- `String DATABASE_NAME = "cameraSlotDb112.db"`  L10
- `String DATABASE_TABLE = "cameraSlotInfo"`  L11
- `int DATABASE_VERSION = 2`  L12
- `String CREATE_CAMINFODB`  L13
- `String databaseCreate`  L14
- `String tableDrop`  L15

方法（3）：
- `public CameraSlotSQLiteHelper(Context context)`  L17
    - 体内字面量："CREATE TABLE IF NOT EXISTS cameraSlotDb112.db (_id INTEGER PRIMARY KEY AUTOINCREMENT, isOccupied INTEGER, cameraName VARCHAR, imageBuffer BLOB)" · "drop table if exists cameraSlotInfo" · "CREATE TABLE IF NOT EXISTS cameraSlotInfo (_id integer primary key autoincrement, isOccupied integer, cameraName varchar, cameraType integer, imageBuffer blob, addType integer, wifiPassword varchar)"
- `void onCreate(SQLiteDatabase sQLiteDatabase)`  L25 @Override
    - 体内字面量："tigertiger" · "start CREATE_CAMINFODB" · "tigertiger" · "end CREATE_CAMINFODB"
- `void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2)`  L32 @Override