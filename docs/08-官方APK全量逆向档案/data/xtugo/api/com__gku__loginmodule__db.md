# XTU GO — 类与成员明细：com.gku.loginmodule.db

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 14 个文件 / 14 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.db.AppDatabase`
L14 · [class] public abstract AppDatabase · extends `RoomDatabase` · `com/gku/loginmodule/db/AppDatabase.java`

字段/常量（9）：
- `String DATABASE_NAME = "XTU GO_Room_DB"`  L15
- `Migration MIGRATION_1_2`  L16
- `Migration MIGRATION_2_3`  L17
- `Migration MIGRATION_3_4`  L18
- `Migration MIGRATION_4_5`  L19
- `AppDatabase mInstance`  L20
- `int i = 4`  L42
- `int i2 = 3`  L49
- `int i3 = 2`  L56

方法（9）：
- `AnnouncementDao announcementDao()`  L22
- `CloudLanguagesDao cloudLanguagesDao()`  L24
- `DeviceVersionInfoDao deviceInfoDao()`  L26
- `GKUUserDao gkuUserDao()`  L28
- `AppDatabase getInstance()`  L30
- `void migrate(SupportSQLiteDatabase database)`  L45 @Override
    - 体内字面量："CREATE TABLE `DeviceVersionInfo` (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, model TEXT, version TEXT, name TEXT, pcbrevision TEXT, region TEXT, isAmba INTEGER NOT NULL DEFAULT 0)"
- `void migrate(SupportSQLiteDatabase database)`  L52 @Override
    - 体内字面量："CREATE TABLE `cloud_languages` (roomId INTEGER NOT NULL, lanCode TEXT, remark TEXT, PRIMARY KEY(`roomId`))"
- `void migrate(SupportSQLiteDatabase database)`  L59 @Override
    - 体内字面量："CREATE TABLE `announcement` (roomId INTEGER NOT NULL, title TEXT, content TEXT, linkUrl TEXT, iconUrl TEXT, createTime TEXT, PRIMARY KEY(`roomId`))"
- `void migrate(SupportSQLiteDatabase database)`  L65 @Override
### `com.gku.loginmodule.db.AppDatabase_Impl`
L32 · [class] public final AppDatabase_Impl · extends `AppDatabase` · `com/gku/loginmodule/db/AppDatabase_Impl.java`

字段/常量（8）：
- `AnnouncementDao _announcementDao`  L33
- `CloudLanguagesDao _cloudLanguagesDao`  L34
- `DeviceVersionInfoDao _deviceVersionInfoDao`  L35
- `GKUUserDao _gKUUserDao`  L36
- `GKUUserDao gKUUserDao`  L214
- `AnnouncementDao announcementDao`  L229
- `CloudLanguagesDao cloudLanguagesDao`  L244
- `DeviceVersionInfoDao deviceVersionInfoDao`  L259

方法（17）：
- `SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration)`  L39 @Override
- `void onPostMigrate(SupportSQLiteDatabase _db)`  L42 @Override
- `void createAllTables(SupportSQLiteDatabase _db)`  L46 @Override
    - 体内字面量："CREATE TABLE IF NOT EXISTS `Announcement` (`roomId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `content` TEXT, `linkUrl` TEXT, `iconUrl` TEXT, `createTime` TEXT)" · "CREATE TABLE IF NOT EXISTS `CloudLanguages` (`roomId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `lanCode` TEXT, `remark` TEXT)" · "CREATE UNIQUE INDEX IF NOT EXISTS `index_CloudLanguages_lanCode` ON `CloudLanguages` (`lanCode`)" · "CREATE TABLE IF NOT EXISTS `DeviceVersionInfo` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `model` TEXT, `version` TEXT, `name` TEXT, `pcbrevision` TEXT, `region` TEXT, `isAmba` INTEGER NOT NULL)" · "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1de06687ab42c88d9689b803e413409d')"
- `void dropAllTables(SupportSQLiteDatabase _db)`  L57 @Override
    - 体内字面量："DROP TABLE IF EXISTS `GKUUser`" · "DROP TABLE IF EXISTS `Announcement`" · "DROP TABLE IF EXISTS `CloudLanguages`" · "DROP TABLE IF EXISTS `DeviceVersionInfo`"
- `void onCreate(SupportSQLiteDatabase _db)`  L71 @Override
- `void onOpen(SupportSQLiteDatabase _db)`  L81 @Override
- `void onPreMigrate(SupportSQLiteDatabase _db)`  L93 @Override
- `RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db)`  L98 @Override
    - 体内字面量："uid" · "uid" · "INTEGER" · "searchValue" · "searchValue" · "TEXT" · "createBy" · "createBy" · "TEXT" · "createTime" · "createTime" · "TEXT" · "updateBy" · "updateBy" · "TEXT" · "updateTime" · "updateTime" · "TEXT" · "remark" · "remark" · "TEXT" · "TEXT" · "userPwd" · "userPwd" · "TEXT" · "email" · "email" · "TEXT" · "mobile" · "mobile" · "TEXT" · "lanCode" · "lanCode" · "TEXT" · "registTime" · "registTime" · "TEXT" · "activeTime" · "activeTime" · "TEXT" · "loginTimes" · "loginTimes" · "INTEGER" · "productModel" · "productModel" · "TEXT" · "habits" · "habits" · "TEXT" · "userdata1" · "userdata1" · "TEXT" · "userdata2" · "userdata2" · "TEXT" · "userdata3" · "userdata3" · "TEXT" · "GKUUser" · "GKUUser" · "GKUUser(com.gku.loginmodule.db.bean.GKUUser).\n Expected:\n" · "\n Found:\n" · "roomId" · "roomId" · "INTEGER" · "TEXT" · "content" · "content" · "TEXT" · "linkUrl" · "linkUrl" · "TEXT" · "TEXT" · "createTime" · "createTime" · "TEXT" · "Announcement" · "Announcement" · "Announcement(com.gku.loginmodule.db.bean.Announcement).\n Expected:\n" · "\n Found:\n" · "roomId" · "roomId" · "INTEGER" · "lanCode" · "lanCode" · "TEXT" · "remark" · "remark" · "TEXT" · "index_CloudLanguages_lanCode" · "lanCode" · "ASC" · "CloudLanguages" · "CloudLanguages" · "CloudLanguages(com.gku.loginmodule.db.bean.CloudLanguages).\n Expected:\n" · "\n Found:\n" · "INTEGER" · "model" · "model" · "TEXT" · "version" · "version" · "TEXT" · "name" · "name" · "TEXT" · "pcbrevision" · "pcbrevision" · "TEXT" · "region" · "region" · "TEXT" · "isAmba" · "isAmba" · "INTEGER" · "DeviceVersionInfo" · "DeviceVersionInfo" · "DeviceVersionInfo(com.gku.loginmodule.db.bean.DeviceVersionInfo).\n Expected:\n" · "\n Found:\n" · "1de06687ab42c88d9689b803e413409d" · "700c90df181c774e850c9902cf8dd633"
- `InvalidationTracker createInvalidationTracker()`  L168 @Override
    - 体内字面量："GKUUser" · "Announcement" · "CloudLanguages" · "DeviceVersionInfo"
- `void clearAllTables()`  L173 @Override
    - 体内字面量："DELETE FROM `GKUUser`" · "DELETE FROM `Announcement`" · "DELETE FROM `CloudLanguages`" · "DELETE FROM `DeviceVersionInfo`" · "PRAGMA wal_checkpoint(FULL)" · "VACUUM"
- `Map<Class<?>, List<Class<?>>> getRequiredTypeConverters()`  L193 @Override
- `Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs()`  L203 @Override
- `List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap)`  L208 @Override
- `GKUUserDao gkuUserDao()`  L213 @Override
- `AnnouncementDao announcementDao()`  L228 @Override
- `CloudLanguagesDao cloudLanguagesDao()`  L243 @Override
- `DeviceVersionInfoDao deviceInfoDao()`  L258 @Override
### `com.gku.loginmodule.db.bean.Announcement`
L8 · [class] public Announcement · extends `BaseObservable` · `com/gku/loginmodule/db/bean/Announcement.java`

字段/常量（6）：
- `String content`  L9
- `String createTime`  L10
- `String iconUrl`  L11
- `String linkUrl`  L12
- `int roomId`  L13
- `String title`  L14

方法（16）：
- `int getRoomId()`  L17 @Bindable
- `void setRoomId(int roomId)`  L21
- `String getTitle()`  L26 @Bindable
- `void setTitle(String title)`  L30
- `String getContent()`  L35 @Bindable
- `void setContent(String content)`  L39
- `String getLinkUrl()`  L44 @Bindable
- `void setLinkUrl(String linkUrl)`  L48
- `String getIconUrl()`  L53 @Bindable
- `void setIconUrl(String iconUrl)`  L57
- `String getCreateTime()`  L62 @Bindable
- `void setCreateTime(String createTime)`  L66
- `public Announcement()`  L70
- `public Announcement(String title, String content, String linkUrl, String iconUrl, String createTime)`  L73
- `boolean equals(Object obj)`  L81
- `int hashCode()`  L89
### `com.gku.loginmodule.db.bean.CloudLanguages`
L7 · [class] public CloudLanguages · extends `BaseObservable` · `com/gku/loginmodule/db/bean/CloudLanguages.java`

字段/常量（3）：
- `String lanCode`  L8
- `String remark`  L9
- `int roomId`  L10

方法（8）：
- `int getRoomId()`  L13 @Bindable
- `void setRoomId(int roomId)`  L17
- `String getLanCode()`  L22 @Bindable
- `void setLanCode(String lanCode)`  L26
- `String getRemark()`  L31 @Bindable
- `void setRemark(String remark)`  L35
- `public CloudLanguages()`  L39
- `public CloudLanguages(String lanCode, String remark)`  L42
### `com.gku.loginmodule.db.bean.DeviceVersionInfo`
L6 · [class] public DeviceVersionInfo · implements `Serializable` · `com/gku/loginmodule/db/bean/DeviceVersionInfo.java`

字段/常量（9）：
- `int id`  L7
- `boolean isAmba`  L8
- `boolean isSelected`  L9
- `String model`  L10
- `String name`  L11
- `String pcbrevision`  L12
- `float progress`  L13
- `String region`  L14
- `String version`  L15

方法（20）：
- `int getId()`  L17
- `void setId(int id)`  L21
- `String getModel()`  L25
- `void setModel(String model)`  L29
- `String getVersion()`  L33
- `void setVersion(String version)`  L37
- `String getPcbrevision()`  L41
- `void setPcbrevision(String pcbrevision)`  L45
- `String getRegion()`  L49
- `void setRegion(String region)`  L53
- `String getName()`  L57
- `void setName(String name)`  L61
- `boolean isSelected()`  L65
- `void setSelected(boolean selected)`  L69
- `float getProgress()`  L73
- `void setProgress(float progress)`  L77
- `boolean isAmba()`  L81
- `void setAmba(boolean amba)`  L85
- `public DeviceVersionInfo()`  L89
- `public DeviceVersionInfo(int id, String model, String version, String name, boolean isAmba)`  L92
### `com.gku.loginmodule.db.bean.GKUUser`
L7 · [class] public GKUUser · extends `BaseObservable` · `com/gku/loginmodule/db/bean/GKUUser.java`

字段/常量（20）：
- `String activeTime`  L8
- `String createBy`  L9
- `String createTime`  L10
- `String email`  L11
- `String habits`  L12
- `String id`  L13
- `String lanCode`  L14
- `int loginTimes`  L15
- `String mobile`  L16
- `String productModel`  L17
- `String registTime`  L18
- `String remark`  L19
- `String searchValue`  L20
- `int uid`  L21
- `String updateBy`  L22
- `String updateTime`  L23
- `String userPwd`  L24
- `String userdata1`  L25
- `String userdata2`  L26
- `String userdata3`  L27

方法（42）：
- `int getUid()`  L30 @Bindable
- `void setUid(int uid)`  L34
- `String getSearchValue()`  L39 @Bindable
- `void setSearchValue(String searchValue)`  L43
- `String getCreateBy()`  L48 @Bindable
- `void setCreateBy(String createBy)`  L52
- `String getCreateTime()`  L57 @Bindable
- `void setCreateTime(String createTime)`  L61
- `String getUpdateBy()`  L66 @Bindable
- `void setUpdateBy(String updateBy)`  L70
- `String getUpdateTime()`  L75 @Bindable
- `void setUpdateTime(String updateTime)`  L79
- `String getRemark()`  L84 @Bindable
- `void setRemark(String remark)`  L88
- `String getId()`  L93 @Bindable
- `void setId(String id)`  L97
- `String getUserPwd()`  L102 @Bindable
- `void setUserPwd(String userPwd)`  L106
- `String getEmail()`  L111 @Bindable
- `void setEmail(String email)`  L115
- `String getMobile()`  L120 @Bindable
- `void setMobile(String mobile)`  L124
- `String getLanCode()`  L129 @Bindable
- `void setLanCode(String lanCode)`  L134 @Bindable
- `String getRegistTime()`  L139 @Bindable
- `void setRegistTime(String registTime)`  L143
- `String getActiveTime()`  L148 @Bindable
- `void setActiveTime(String activeTime)`  L152
- `int getLoginTimes()`  L157 @Bindable
- `void setLoginTimes(int loginTimes)`  L161
- `String getProductModel()`  L166 @Bindable
- `void setProductModel(String productModel)`  L170
- `String getHabits()`  L175 @Bindable
- `void setHabits(String habits)`  L179
- `String getUserdata1()`  L184 @Bindable
- `void setUserdata1(String userdata1)`  L188
- `String getUserdata2()`  L193 @Bindable
- `void setUserdata2(String userdata2)`  L197
- `String getUserdata3()`  L202 @Bindable
- `void setUserdata3(String userdata3)`  L206
- `public GKUUser()`  L210
- `public GKUUser(String id, String userPwd, String email, String mobile, String registTime)`  L230
### `com.gku.loginmodule.db.dao.AnnouncementDao`
L9 · [interface] public AnnouncementDao · `com/gku/loginmodule/db/dao/AnnouncementDao.java`

方法（12）：
- `Completable deleteAll()`  L10
- `Completable deleteAnnouncementByTitle(String title)`  L12
- `Flowable<List<Announcement>> getAll()`  L14
- `Completable insert(Announcement announcement)`  L16
- `Completable insertList(Announcement... announcement)`  L18
- `Flowable<Announcement> queryAnnouncementByContent(String content)`  L20
- `Flowable<Announcement> queryAnnouncementByCreateTime(String createTime)`  L22
- `Flowable<Announcement> queryAnnouncementByIconUrl(String iconUrl)`  L24
- `Flowable<Announcement> queryAnnouncementByLinkUrl(String linkUrl)`  L26
- `Flowable<Announcement> queryAnnouncementByTitle(String title)`  L28
- `Completable update(Announcement announcement)`  L30
- `Completable update(List<Announcement> announcementList)`  L32
### `com.gku.loginmodule.db.dao.AnnouncementDao_Impl`
L23 · [class] public final AnnouncementDao_Impl · implements `AnnouncementDao` · `com/gku/loginmodule/db/dao/AnnouncementDao_Impl.java`

字段/常量（16）：
- `RoomDatabase __db`  L24
- `EntityInsertionAdapter<Announcement> __insertionAdapterOfAnnouncement`  L25
- `SharedSQLiteStatement __preparedStmtOfDeleteAll`  L26
- `SharedSQLiteStatement __preparedStmtOfDeleteAnnouncementByTitle`  L27
- `EntityDeletionOrUpdateAdapter<Announcement> __updateAdapterOfAnnouncement`  L28
- `String str = title`  L212
- `Announcement announcement = null`  L280
- `String string = null`  L281
- `Announcement announcement = null`  L327
- `String string = null`  L328
- `Announcement announcement = null`  L374
- `String string = null`  L375
- `Announcement announcement = null`  L421
- `String string = null`  L422
- `Announcement announcement = null`  L468
- `String string = null`  L469

方法（38）：
- `public AnnouncementDao_Impl(RoomDatabase __db)`  L30
- `String createQuery()`  L34 @Override
    - 体内字面量："INSERT OR REPLACE INTO `Announcement` (`roomId`,`title`,`content`,`linkUrl`,`iconUrl`,`createTime`) VALUES (nullif(?, 0),?,?,?,?,?)"
- `void bind(SupportSQLiteStatement stmt, Announcement value)`  L39 @Override
- `String createQuery()`  L70 @Override
    - 体内字面量："UPDATE OR ABORT `Announcement` SET `roomId` = ?,`title` = ?,`content` = ?,`linkUrl` = ?,`iconUrl` = ?,`createTime` = ? WHERE `roomId` = ?"
- `void bind(SupportSQLiteStatement stmt, Announcement value)`  L75 @Override
- `String createQuery()`  L107 @Override
    - 体内字面量："DELETE FROM Announcement"
- `String createQuery()`  L113 @Override
    - 体内字面量："DELETE FROM Announcement WHERE title = ?"
- `Completable insert(final Announcement announcement)`  L120 @Override
- `Void call()`  L123 @Override
- `Completable insertList(final Announcement... announcement)`  L137 @Override
- `Void call()`  L140 @Override
- `Completable update(final List<Announcement> announcementList)`  L154 @Override
- `Void call()`  L157 @Override
- `Completable update(final Announcement announcement)`  L171 @Override
- `Void call()`  L174 @Override
- `Completable deleteAll()`  L188 @Override
- `Void call()`  L191 @Override
- `Completable deleteAnnouncementByTitle(final String title)`  L207 @Override
- `Void call()`  L210 @Override
- `Flowable<List<Announcement>> getAll()`  L232 @Override
    - 体内字面量："SELECT * FROM Announcement" · "Announcement"
- `List<Announcement> call()`  L236 @Override
    - 体内字面量："roomId" · "content" · "linkUrl" · "createTime"
- `void finalize()`  L262
- `Flowable<Announcement> queryAnnouncementByTitle(final String title)`  L269 @Override
    - 体内字面量："SELECT * FROM Announcement WHERE title=?" · "Announcement"
- `Announcement call()`  L279 @Override
- `void finalize()`  L309
- `Flowable<Announcement> queryAnnouncementByContent(final String content)`  L316 @Override
    - 体内字面量："SELECT * FROM Announcement WHERE content=?" · "Announcement"
- `Announcement call()`  L326 @Override
- `void finalize()`  L356
- `Flowable<Announcement> queryAnnouncementByLinkUrl(final String linkUrl)`  L363 @Override
    - 体内字面量："SELECT * FROM Announcement WHERE linkUrl=?" · "Announcement"
- `Announcement call()`  L373 @Override
- `void finalize()`  L403
- `Flowable<Announcement> queryAnnouncementByIconUrl(final String iconUrl)`  L410 @Override
    - 体内字面量："SELECT * FROM Announcement WHERE iconUrl=?" · "Announcement"
- `Announcement call()`  L420 @Override
- `void finalize()`  L450
- `Flowable<Announcement> queryAnnouncementByCreateTime(final String createTime)`  L457 @Override
    - 体内字面量："SELECT * FROM Announcement WHERE createTime=?" · "Announcement"
- `Announcement call()`  L467 @Override
- `void finalize()`  L497
- `List<Class<?>> getRequiredConverters()`  L503
### `com.gku.loginmodule.db.dao.CloudLanguagesDao`
L9 · [interface] public CloudLanguagesDao · `com/gku/loginmodule/db/dao/CloudLanguagesDao.java`

方法（5）：
- `Completable deleteAll()`  L10
- `Flowable<List<CloudLanguages>> getAll()`  L12
- `Completable insert(CloudLanguages cloudLanguages)`  L14
- `Completable insertList(List<CloudLanguages> cloudLanguages)`  L16
- `Completable update(List<CloudLanguages> cloudLanguages)`  L18
### `com.gku.loginmodule.db.dao.CloudLanguagesDao_Impl`
L22 · [class] public final CloudLanguagesDao_Impl · implements `CloudLanguagesDao` · `com/gku/loginmodule/db/dao/CloudLanguagesDao_Impl.java`

字段/常量（4）：
- `RoomDatabase __db`  L23
- `EntityInsertionAdapter<CloudLanguages> __insertionAdapterOfCloudLanguages`  L24
- `SharedSQLiteStatement __preparedStmtOfDeleteAll`  L25
- `EntityDeletionOrUpdateAdapter<CloudLanguages> __updateAdapterOfCloudLanguages`  L26

方法（18）：
- `public CloudLanguagesDao_Impl(RoomDatabase __db)`  L28
- `String createQuery()`  L32 @Override
    - 体内字面量："INSERT OR REPLACE INTO `CloudLanguages` (`roomId`,`lanCode`,`remark`) VALUES (nullif(?, 0),?,?)"
- `void bind(SupportSQLiteStatement stmt, CloudLanguages value)`  L37 @Override
- `String createQuery()`  L53 @Override
    - 体内字面量："UPDATE OR ABORT `CloudLanguages` SET `roomId` = ?,`lanCode` = ?,`remark` = ? WHERE `roomId` = ?"
- `void bind(SupportSQLiteStatement stmt, CloudLanguages value)`  L58 @Override
- `String createQuery()`  L75 @Override
    - 体内字面量："DELETE FROM CloudLanguages"
- `Completable insert(final CloudLanguages cloudLanguages)`  L82 @Override
- `Void call()`  L85 @Override
- `Completable insertList(final List<CloudLanguages> cloudLanguages)`  L99 @Override
- `Void call()`  L102 @Override
- `Completable update(final List<CloudLanguages> cloudLanguages)`  L116 @Override
- `Void call()`  L119 @Override
- `Completable deleteAll()`  L133 @Override
- `Void call()`  L136 @Override
- `Flowable<List<CloudLanguages>> getAll()`  L152 @Override
    - 体内字面量："SELECT * FROM CloudLanguages" · "CloudLanguages"
- `List<CloudLanguages> call()`  L156 @Override
    - 体内字面量："roomId" · "lanCode" · "remark"
- `void finalize()`  L176
- `List<Class<?>> getRequiredConverters()`  L182
### `com.gku.loginmodule.db.dao.DeviceVersionInfoDao`
L10 · [interface] public DeviceVersionInfoDao · `com/gku/loginmodule/db/dao/DeviceVersionInfoDao.java`

方法（9）：
- `Completable delete(DeviceVersionInfo user)`  L11
- `Completable deleteAll()`  L13
- `Completable deleteList(List<DeviceVersionInfo> user)`  L15
- `Flowable<List<DeviceVersionInfo>> getAll()`  L17
- `Flowable<DeviceVersionInfo> getDeviceInfoByName(String name)`  L19
- `Maybe<DeviceVersionInfo> getDeviceInfoByNameMaybe(String name)`  L21
- `Completable insert(DeviceVersionInfo info)`  L23
- `Completable update(DeviceVersionInfo user)`  L25
- `Completable updateList(List<DeviceVersionInfo> user)`  L27
### `com.gku.loginmodule.db.dao.DeviceVersionInfoDao_Impl`
L24 · [class] public final DeviceVersionInfoDao_Impl · implements `DeviceVersionInfoDao` · `com/gku/loginmodule/db/dao/DeviceVersionInfoDao_Impl.java`

字段/常量（9）：
- `RoomDatabase __db`  L25
- `EntityDeletionOrUpdateAdapter<DeviceVersionInfo> __deletionAdapterOfDeviceVersionInfo`  L26
- `EntityInsertionAdapter<DeviceVersionInfo> __insertionAdapterOfDeviceVersionInfo`  L27
- `SharedSQLiteStatement __preparedStmtOfDeleteAll`  L28
- `EntityDeletionOrUpdateAdapter<DeviceVersionInfo> __updateAdapterOfDeviceVersionInfo`  L29
- `DeviceVersionInfo deviceVersionInfo = null`  L282
- `String string = null`  L283
- `DeviceVersionInfo deviceVersionInfo = null`  L331
- `String string = null`  L332

方法（30）：
- `public DeviceVersionInfoDao_Impl(RoomDatabase __db)`  L31
- `String createQuery()`  L35 @Override
    - 体内字面量："INSERT OR REPLACE INTO `DeviceVersionInfo` (`id`,`model`,`version`,`name`,`pcbrevision`,`region`,`isAmba`) VALUES (nullif(?, 0),?,?,?,?,?,?)"
- `void bind(SupportSQLiteStatement supportSQLiteStatement, DeviceVersionInfo deviceVersionInfo)`  L40 @Override
- `String createQuery()`  L72 @Override
    - 体内字面量："DELETE FROM `DeviceVersionInfo` WHERE `id` = ?"
- `void bind(SupportSQLiteStatement stmt, DeviceVersionInfo value)`  L77 @Override
- `String createQuery()`  L83 @Override
    - 体内字面量："UPDATE OR ABORT `DeviceVersionInfo` SET `id` = ?,`model` = ?,`version` = ?,`name` = ?,`pcbrevision` = ?,`region` = ?,`isAmba` = ? WHERE `id` = ?"
- `void bind(SupportSQLiteStatement supportSQLiteStatement, DeviceVersionInfo deviceVersionInfo)`  L88 @Override
- `String createQuery()`  L121 @Override
    - 体内字面量："DELETE FROM DeviceVersionInfo"
- `Completable insert(final DeviceVersionInfo info)`  L128 @Override
- `Void call()`  L131 @Override
- `Completable delete(final DeviceVersionInfo user)`  L145 @Override
- `Void call()`  L148 @Override
- `Completable deleteList(final List<DeviceVersionInfo> user)`  L162 @Override
- `Void call()`  L165 @Override
- `Completable update(final DeviceVersionInfo user)`  L179 @Override
- `Void call()`  L182 @Override
- `Completable updateList(final List<DeviceVersionInfo> user)`  L196 @Override
- `Void call()`  L199 @Override
- `Completable deleteAll()`  L213 @Override
- `Void call()`  L216 @Override
- `Flowable<List<DeviceVersionInfo>> getAll()`  L232 @Override
    - 体内字面量："SELECT * FROM DeviceVersionInfo ORDER BY id DESC" · "DeviceVersionInfo"
- `List<DeviceVersionInfo> call()`  L236 @Override
    - 体内字面量："model" · "version" · "name" · "pcbrevision" · "region" · "isAmba"
- `void finalize()`  L264
- `Flowable<DeviceVersionInfo> getDeviceInfoByName(final String name)`  L271 @Override
    - 体内字面量："SELECT * FROM DeviceVersionInfo WHERE name=?" · "DeviceVersionInfo"
- `DeviceVersionInfo call()`  L281 @Override
- `void finalize()`  L313
- `Maybe<DeviceVersionInfo> getDeviceInfoByNameMaybe(final String name)`  L320 @Override
    - 体内字面量："SELECT * FROM DeviceVersionInfo WHERE name=?"
- `DeviceVersionInfo call()`  L330 @Override
- `void finalize()`  L362
- `List<Class<?>> getRequiredConverters()`  L368
### `com.gku.loginmodule.db.dao.GKUUserDao`
L9 · [interface] public GKUUserDao · `com/gku/loginmodule/db/dao/GKUUserDao.java`

方法（4）：
- `Completable deleteAll()`  L10
- `Flowable<List<GKUUser>> getAll()`  L12
- `Completable insert(GKUUser user)`  L14
- `Completable update(GKUUser user)`  L16
### `com.gku.loginmodule.db.dao.GKUUserDao_Impl`
L23 · [class] public final GKUUserDao_Impl · implements `GKUUserDao` · `com/gku/loginmodule/db/dao/GKUUserDao_Impl.java`

字段/常量（9）：
- `RoomDatabase __db`  L24
- `EntityInsertionAdapter<GKUUser> __insertionAdapterOfGKUUser`  L25
- `SharedSQLiteStatement __preparedStmtOfDeleteAll`  L26
- `EntityDeletionOrUpdateAdapter<GKUUser> __updateAdapterOfGKUUser`  L27
- `int i = columnIndexOrThrow14`  L325
- `ArrayList arrayList2 = arrayList`  L329
- `int i2 = i`  L343
- `int i3 = columnIndexOrThrow15`  L346
- `int i4 = columnIndexOrThrow16`  L348

方法（16）：
- `public GKUUserDao_Impl(RoomDatabase __db)`  L29
- `String createQuery()`  L33 @Override
- `void bind(SupportSQLiteStatement stmt, GKUUser value)`  L38 @Override
- `String createQuery()`  L135 @Override
- `void bind(SupportSQLiteStatement stmt, GKUUser value)`  L140 @Override
- `String createQuery()`  L238 @Override
    - 体内字面量："DELETE FROM GKUUser"
- `Completable insert(final GKUUser user)`  L245 @Override
- `Void call()`  L248 @Override
- `Completable update(final GKUUser user)`  L262 @Override
- `Void call()`  L265 @Override
- `Completable deleteAll()`  L279 @Override
- `Void call()`  L282 @Override
- `Flowable<List<GKUUser>> getAll()`  L298 @Override
    - 体内字面量："SELECT * FROM GKUUser" · "GKUUser"
- `List<GKUUser> call()`  L302 @Override
    - 体内字面量："uid" · "searchValue" · "createBy" · "createTime" · "updateBy" · "updateTime" · "remark" · "userPwd" · "email" · "mobile" · "lanCode" · "registTime" · "activeTime" · "loginTimes" · "productModel" · "habits" · "userdata1" · "userdata2" · "userdata3"
- `void finalize()`  L370
- `List<Class<?>> getRequiredConverters()`  L376