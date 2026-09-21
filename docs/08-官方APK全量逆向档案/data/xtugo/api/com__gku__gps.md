# XTU GO — 类与成员明细：com.gku.gps

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.gps.GPSConversion`
L6 · [class] public GPSConversion · `com/gku/gps/GPSConversion.java`

字段/常量（10）：
- `double a = 6378245.0d`  L7
- `double ee = 0.006693421622965943d`  L8
- `double pi = 3.141592653589793d`  L9
- `double x_pi = 52.35987755982988d`  L10
- `GPSInfoBean.GpsBean gpsBean = null`  L26
- `double d = x * 2.0d`  L54
- `double d = x * 0.1d`  L59
- `double d = lon - 105.0d`  L67
- `double d2 = lat - 35.0d`  L68
- `double d5 = a`  L75

方法（7）：
- `double exchangeUnit(double degrees)`  L12
- `boolean outOfChina(double lat, double lon)`  L18
- `void supplement(GPSInfoBean gpsInfoBean)`  L22
    - 体内字面量："Get GPS Info"
- `double[] conversion(double latitude, double longitude)`  L45
- `double transformLat(double x, double y)`  L53
- `double transformLon(double x, double y)`  L58
- `double[] gps84_To_Gcj02(double lat, double lon)`  L63
### `com.gku.gps.GpsInfo`
L4 · [class] public GpsInfo · `com/gku/gps/GpsInfo.java`

字段/常量（3）：
- `String GET_GPS_INFO = "Get GPS Info"`  L5
- `String NOT_HISILICON_GKU = "Not GKUVISION"`  L6
- `String NO_FILE_FOUND = "No File Found"`  L7

方法（1）：
- `String getGpsInfo(String path)`  L9
### `com.gku.gps.GPSInfoBean`
L8 · [class] public GPSInfoBean · implements `Parcelable` · `com/gku/gps/GPSInfoBean.java`

字段/常量（2）：
- `String Message`  L22
- `List<GpsBean> gps`  L23

方法（10）：
- `GPSInfoBean createFromParcel(Parcel in)`  L12 @Override
- `GPSInfoBean[] newArray(int size)`  L18 @Override
- `int describeContents()`  L26 @Override
- `protected GPSInfoBean(Parcel in)`  L30
- `String getMessage()`  L35
- `void setMessage(String Message)`  L39
- `List<GpsBean> getGps()`  L43
- `void setGps(List<GpsBean> gps)`  L47
- `void writeToParcel(Parcel dest, int flags)`  L52 @Override
- `String toString()`  L342
    - 体内字面量："ICatchGPSInfoBean{Message='" · "', gps=" · "}"
### `com.gku.gps.GPSInfoBean$GpsBean`
L57 · [class] public static GpsBean · implements `Parcelable` · `com/gku/gps/GPSInfoBean.java`

字段/常量（23）：
- `int Day`  L71
- `String EW`  L72
- `double GsensorX`  L73
- `double GsensorY`  L74
- `double GsensorZ`  L75
- `int Hour`  L76
- `String Latitude`  L77
- `String Longitude`  L78
- `double MDay`  L79
- `double MHour`  L80
- `double MMinute`  L81
- `double MMonth`  L82
- `double MSecond`  L83
- `double MYear`  L84
- `int Minute`  L85
- `int Month`  L86
- `String NS`  L87
- `double OLatitude`  L88
- `double OLongitude`  L89
- `int Second`  L90
- `double Speed`  L91
- `int Year`  L92
- `String status`  L93

方法（52）：
- `GpsBean createFromParcel(Parcel in)`  L61 @Override
- `GpsBean[] newArray(int size)`  L67 @Override
- `int describeContents()`  L96 @Override
- `protected GpsBean(Parcel in)`  L100
- `int getHour()`  L126
- `void setHour(int hour)`  L130
- `int getMinute()`  L134
- `void setMinute(int minute)`  L138
- `int getSecond()`  L142
- `void setSecond(int second)`  L146
- `int getYear()`  L150
- `void setYear(int year)`  L154
- `int getMonth()`  L158
- `void setMonth(int month)`  L162
- `int getDay()`  L166
- `void setDay(int day)`  L170
- `String getStatus()`  L174
- `void setStatus(String status)`  L178
- `String getNS()`  L182
- `void setNS(String NS)`  L186
- `String getEW()`  L190
- `void setEW(String EW)`  L194
- `String getLatitude()`  L198
- `void setLatitude(String latitude)`  L202
- `String getLongitude()`  L206
- `void setLongitude(String longitude)`  L210
- `double getSpeed()`  L214
- `void setSpeed(double speed)`  L218
- `double getGsensorX()`  L222
- `void setGsensorX(double gsensorX)`  L226
- `double getGsensorY()`  L230
- `void setGsensorY(double gsensorY)`  L234
- `double getGsensorZ()`  L238
- `void setGsensorZ(double gsensorZ)`  L242
- `double getMHour()`  L246
- `void setMHour(double MHour)`  L250
- `double getMMinute()`  L254
- `void setMMinute(double MMinute)`  L258
- `double getMSecond()`  L262
- `void setMSecond(double MSecond)`  L266
- `double getMYear()`  L270
- `void setMYear(double MYear)`  L274
- `double getMMonth()`  L278
- `void setMMonth(double MMonth)`  L282
- `double getMDay()`  L286
- `void setMDay(double MDay)`  L290
- `double getOLatitude()`  L294
- `void setOLatitude(double OLatitude)`  L298
- `double getOLongitude()`  L302
- `void setOLongitude(double OLongitude)`  L306
- `void writeToParcel(Parcel dest, int flags)`  L311 @Override
- `String toString()`  L337
    - 体内字面量："GpsBean{Hour=" · ", Minute=" · ", Second=" · ", Year=" · ", Month=" · ", Day=" · ", status='" · "', NS='" · "', EW='" · "', Latitude='" · "', Longitude='" · "', Speed=" · ", GsensorX=" · ", GsensorY=" · ", GsensorZ=" · ", MHour=" · ", MMinute=" · ", MSecond=" · ", MYear=" · ", MMonth=" · ", MDay=" · ", OLatitude=" · ", OLongitude=" · "}"
### `com.gku.gps.ICatchGpsInfo`
L4 · [class] public ICatchGpsInfo · `com/gku/gps/ICatchGpsInfo.java`

字段/常量（3）：
- `String GET_GPS_INFO = "Get GPS Info"`  L5
- `String NOT_HISILICON_GKU = "Not GKUVISION"`  L6
- `String NO_FILE_FOUND = "No File Found"`  L7