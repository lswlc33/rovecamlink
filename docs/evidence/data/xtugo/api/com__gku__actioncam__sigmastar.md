# XTU GO — 类与成员明细：com.gku.actioncam.sigmastar

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 4 个文件 / 5 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.actioncam.sigmastar.HaisiCommandUtil`
L10 · [class] public HaisiCommandUtil · `com/gku/actioncam/sigmastar/HaisiCommandUtil.java`

字段/常量（35）：
- `String SS_BASE_PATH = "/cgi-bin/hi3510/"`  L11
- `String SS_CGI = ".cgi"`  L12
- `String SS_DELETE_FILE = "deletefile"`  L13
- `String SS_EXIT_QUICK_REC = "exitquickrec"`  L14
- `String SS_FORMAT_SD = "sdcommand"`  L15
- `String SS_GET_ALL_WORK_MODE = "getallworkmode"`  L16
- `String SS_GET_BATTERY_INFO = "getbatterycapacity"`  L17
- `String SS_GET_CAMERA_STATUS = "getcamerastatus"`  L18
- `String SS_GET_CUR_ALL_INFO = "getcurallinfo"`  L19
- `String SS_GET_CUR_PARAM = "getsecondmenuitem"`  L20
- `String SS_GET_CUR_WORK_MODE = "getcurworkmode"`  L21
- `String SS_GET_DEVICE_ATTR = "getdeviceattr"`  L22
- `String SS_GET_FILE_COUNT = "getfilecount"`  L23
- `String SS_GET_FILE_INFO = "getfileinfo"`  L24
- `String SS_GET_FILE_LIST = "getfilelist"`  L25
- `String SS_GET_FILE_LIST_IOS = "getfilelistinfoios"`  L26
- `String SS_GET_PRIMARY_MENU_ITEM = "getprimarymenuitem"`  L27
- `String SS_GET_SD_STATUS = "getsdstate"`  L28
- `String SS_GET_SECOND_MENU_ITEM = "getsecondmenuitem"`  L29
- `String SS_GET_WIFI = "getwifi"`  L30
- `String SS_LIVE_STREAM_PATH = "/livestream/12"`  L31
- `int SS_LIVE_STREAM_PORT = 554`  L32
- `String SS_PHOTO = "photo"`  L33
- `String SS_PROTOCOL_HTTP = "http://"`  L34
- `String SS_PROTOCOL_RTSP = "rtsp://"`  L35
- `String SS_QUICK_STORIES_ADD_TIME = "record"`  L36
- `String SS_RECORD = "record"`  L37
- `String SS_REST = "reset"`  L38
- `String SS_SET_CAMERA_STATUS = "setcamerastatus"`  L39
- `String SS_SET_CUR_PARAM = "setcurparameter"`  L40
- `String SS_SET_CUR_WORK_MODE = "setcurworkmode"`  L41
- `String SS_SET_SYSTEM_TIME = "setsystime"`  L42
- `String SS_SET_WIFI = "setwifi"`  L43
- `String str`  L61
- `String strReplaceAll`  L128

方法（34）：
- `String UNIVERSAL_PART(String command)`  L45
- `String previewLiveStream()`  L49
    - 体内字面量：":554/livestream/12"
- `int executeCommand(int cmd)`  L53
- `String getexecuteCommand(int cmd)`  L60
- `String getDeviceAttr()`  L71
- `String getFileCount()`  L75
- `String getFileList(int start, int end)`  L79
    - 体内字面量："?-start=" · "&-end="
- `String getFileListAndInfo(int start, int end)`  L83
    - 体内字面量："?-start=" · "&-end="
- `String deleteFile(String originPath)`  L87
    - 体内字面量："?-name="
- `String getFileInfo(String originPath)`  L91
    - 体内字面量："?-name="
- `String getAllWorkMode()`  L95
- `String getCurworkmode()`  L99
- `String getCurWorkMode()`  L103
- `String setCurWorkMode(String workMode)`  L107
    - 体内字面量："?-workmode="
- `String getBatteryInfo()`  L111
- `String getSDStatus()`  L115
- `String getPrimaryMenuItem(String workMode)`  L119
    - 体内字面量："?-workmode="
- `String getSecondMenuItem(String workMode, String itemName)`  L123
    - 体内字面量："getsecondmenuitem" · "?-workmode=" · "&-name="
- `String getCurParam(String workMode, String itemName)`  L127
- `String setCurParam(String workMode, String itemName, String itemValue)`  L136
    - 体内字面量："?-workmode=" · "&-name=" · "&-value="
- `String getWiFi()`  L140
- `String setWiFi(String ssid, String key)`  L144
    - 体内字面量："?&-wifissid=" · "&-wifikey="
- `String formatSD()`  L148
    - 体内字面量："?-format&-partition=1"
- `String reset()`  L152
- `String setSystemTime(String time)`  L156
    - 体内字面量："?-time="
- `String startRecord()`  L160
    - 体内字面量："?-cmd=start"
- `String stopRecord()`  L164
    - 体内字面量："?-cmd=stop"
- `String startPhoto(String type)`  L168
    - 体内字面量："?-type=" · "&-cmd=start"
- `String stopPhoto(String type)`  L172
    - 体内字面量："?-type=" · "&-cmd=stop"
- `String exitQuickRec()`  L176
- `String getCameraStatus()`  L180
- `String setCameraStatus(String status)`  L184
    - 体内字面量："?-status="
- `String getCurAllInfo()`  L188
- `String quickStoriesAddTime()`  L192
    - 体内字面量："?-cmd=Quick Stories"
### `com.gku.actioncam.sigmastar.IHomeView`
L4 · [interface] public IHomeView · `com/gku/actioncam/sigmastar/IHomeView.java`
### `com.gku.actioncam.sigmastar.SSCommandUtil`
L8 · [class] public SSCommandUtil · `com/gku/actioncam/sigmastar/SSCommandUtil.java`

字段/常量（36）：
- `String SS_BASE_PATH = "/cgi-bin/hi3510/"`  L9
- `String SS_CGI = ".cgi"`  L10
- `String SS_DELETE_FILE = "deletefile"`  L11
- `String SS_EXIT_QUICK_REC = "exitquickrec"`  L12
- `String SS_FORMAT_SD = "sdcommand"`  L13
- `String SS_GET_ALL_WORK_MODE = "getallworkmode"`  L14
- `String SS_GET_BATTERY_INFO = "getbatterycapacity"`  L15
- `String SS_GET_CAMERA_STATUS = "getcamerastatus"`  L16
- `String SS_GET_CUR_ALL_INFO = "getcurallinfo"`  L17
- `String SS_GET_CUR_PARAM = "getcurparameter"`  L18
- `String SS_GET_CUR_WORK_MODE = "getcurworkmode"`  L19
- `String SS_GET_DEVICE_ATTR = "getdeviceattr"`  L20
- `String SS_GET_DIRNAME = "getdirname"`  L21
- `String SS_GET_FILE_COUNT = "getfiletypecount"`  L22
- `String SS_GET_FILE_INFO = "getfileinfo"`  L23
- `String SS_GET_FILE_LIST = "getfilelist"`  L24
- `String SS_GET_FILE_LIST_IOS = "getfilelistinfoios"`  L25
- `String SS_GET_PRIMARY_MENU_ITEM = "getprimarymenuitem"`  L26
- `String SS_GET_ROTATE = "getcurrotation"`  L27
- `String SS_GET_SD_STATUS = "getsdstate"`  L28
- `String SS_GET_SECOND_MENU_ITEM = "getsecondmenuitem"`  L29
- `String SS_GET_WIFI = "getwifi"`  L30
- `String SS_LIVE_STREAM_PATH = "/livestream/12"`  L31
- `String SS_LIVE_STREAM_PORT = "554"`  L32
- `String SS_PHOTO = "photo"`  L33
- `String SS_PROTOCOL_HTTP = "http://"`  L34
- `String SS_PROTOCOL_RTSP = "rtsp://"`  L35
- `String SS_QUICK_STORIES_ADD_TIME = "record"`  L36
- `String SS_RECORD = "record"`  L37
- `String SS_REST = "reset"`  L38
- `String SS_SET_CAMERA_STATUS = "setcamerastatus"`  L39
- `String SS_SET_CUR_PARAM = "setcurparameter"`  L40
- `String SS_SET_CUR_WORK_MODE = "setcurworkmode"`  L41
- `String SS_SET_SYSTEM_TIME = "setsystime"`  L42
- `String SS_SET_WIFI = "setwifi"`  L43
- `StringBuilder sb`  L178

方法（34）：
- `String UNIVERSAL_PART(String command)`  L45
- `String previewLiveStream()`  L49
    - 体内字面量：":554/livestream/12"
- `String getDeviceAttr()`  L53
- `String getFileCount()`  L57
- `String getDirname()`  L61
- `String getFileList(int start, int end, int type)`  L65
    - 体内字面量："?-start=" · "&-end=" · "&-type=" · "Photo" · "Video"
- `String getFileList(int start, int end, String type)`  L69
    - 体内字面量："?-start=" · "&-end=" · "&-type="
- `String getFileListAndInfo(int start, int end)`  L73
    - 体内字面量："?-start=" · "&-end="
- `String deleteFile(String originPath)`  L77
    - 体内字面量："?-name="
- `String getFileInfo(String originPath)`  L81
    - 体内字面量："?-name="
- `String getAllWorkMode()`  L85
- `String getCurWorkMode()`  L89
- `String setCurWorkMode(String workMode)`  L93
    - 体内字面量："?-workmode="
- `String getBatteryInfo()`  L97
- `String getSDStatus()`  L101
- `String getPrimaryMenuItem(String workMode)`  L105
    - 体内字面量："?-workmode="
- `String getSecondMenuItem(String workMode, String itemName)`  L109
    - 体内字面量："?-workmode=" · "&-name="
- `String getCurParam(String workMode, String itemName)`  L113
    - 体内字面量："?-workmode=" · "&-name="
- `String setCurParam(String workMode, String itemName, String itemValue)`  L117
    - 体内字面量："?-workmode=" · "&-name=" · "&-value="
- `String getWiFi()`  L121
- `String setWiFi(String ssid, String key)`  L125
    - 体内字面量："?&-wifissid=" · "&-wifikey="
- `String formatSD()`  L129
    - 体内字面量："?-format&-partition=1"
- `String reset()`  L133
- `String setSystemTime(String time)`  L137
    - 体内字面量："?-time="
- `String startRecord()`  L141
    - 体内字面量："?-cmd=start"
- `String stopRecord()`  L145
    - 体内字面量："?-cmd=stop"
- `String startPhoto(String type)`  L149
    - 体内字面量："?-type=" · "&-cmd=start"
- `String stopPhoto(String type)`  L153
    - 体内字面量："?-type=" · "&-cmd=stop"
- `String exitQuickRec()`  L157
- `String getCameraStatus()`  L161
- `String setCameraStatus(String status)`  L165
    - 体内字面量："?-status="
- `String getCurAllInfo()`  L169
- `String getRotate()`  L173
- `String quickStoriesAddTime()`  L177
### `com.gku.actioncam.sigmastar.SSConstant`
L4 · [class] public SSConstant · `com/gku/actioncam/sigmastar/SSConstant.java`

字段/常量（9）：
- `String AMBA = "H75N"`  L5
- `String CHIP = "SSC8838"`  L6
- `String CHIP_26 = "SSC8826"`  L7
- `String CHIP_38c = "SSC8838C"`  L8
- `String HAISI = "Hi"`  L9
- `String LOCAL_DOWNLOAD_DIR = "/mnt/sdcard/DCIM/ActionCam/"`  L10
- `String LOCAL_THUMB_CACHE_DIR = "/mnt/sdcard/Android/data/com.gku.xtugo/cache/"`  L11
- `boolean SSEnable = true`  L12
- `String SS_IP = "192.168.0.1"`  L13
### `com.gku.actioncam.sigmastar.SSConstant$SSFileFormat`
L15 · [enum] public SSFileFormat · `com/gku/actioncam/sigmastar/SSConstant.java`

枚举常量（2）：
- `mp4()`  L16
- `jpg()`  L17