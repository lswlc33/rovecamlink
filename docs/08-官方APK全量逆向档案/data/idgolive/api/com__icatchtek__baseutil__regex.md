# idGoLive — 类与成员明细：com.icatchtek.baseutil.regex

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 1 个文件 / 1 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.icatchtek.baseutil.regex.RegexUtils`
L7 · [class] public final RegexUtils · `com/icatchtek/baseutil/regex/RegexUtils.java`

字段/常量（1）：
- `String TAG = "RegexUtils"`  L8

方法（18）：
- `boolean checkBirthday(String str)`  L10
    - 体内字面量："[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}"
- `boolean checkBlankSpace(String str)`  L14
    - 体内字面量："\\s+"
- `boolean checkChinese(String str)`  L18
    - 体内字面量："^[ä¸-é¾¥]+$"
- `boolean checkDecimals(String str)`  L22
    - 体内字面量："\\-?[1-9]\\d+(\\.\\d+)?"
- `boolean checkDigit(String str)`  L26
    - 体内字面量："\\-?[1-9]\\d+"
- `boolean checkEmail(String str)`  L30
    - 体内字面量："\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"
- `boolean checkIdCard(String str)`  L34
    - 体内字面量："[1-9]\\d{13,16}[a-zA-Z0-9]{1}"
- `boolean checkIpAddress(String str)`  L38
    - 体内字面量："[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))"
- `boolean checkMobile(String str)`  L42
    - 体内字面量："(\\+\\d+)?1[3458]\\d{9}$" · "checkMobile  mobile:" · " isMobile:"
- `boolean checkMobile02(String str)`  L48
    - 体内字面量："^[1][3-9]\\d{9}$|^([6|9])\\d{7}$|^[0][9]\\d{8}$|^[6]([8|6])\\d{5}$" · "checkMobile02 mobile:" · " isMobile:"
- `boolean checkNickname(String str)`  L54
    - 体内字面量："^[a-zA-Z0-9ä¸-é¾¥_]+$"
- `boolean checkPhone(String str)`  L58
    - 体内字面量："^1\\d{10}$"
- `boolean checkPostcode(String str)`  L62
    - 体内字面量："[1-9]\\d{5}"
- `boolean checkURL(String str)`  L66
    - 体内字面量："^((https|http)://)(([0-9a-z_!~*â().&=+$%-]+: )?[0-9a-z_!~*â().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*â()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,5})?((/?)|(/[0-9a-z_!~*â().;?:@&=+$,%#-]+)+/?)$"
- `boolean hasCrossSciptRiskInAddress(String str)`  L70
    - 体内字面量："[`~!@#$%^&*+=|{}':;',\\[\\].<>~ï¼@#ï¿¥%â¦â¦&*ââ+|{}ããâï¼ï¼âââãï¼ãï¼-]"
- `boolean isAllowedCharacter(String str)`  L77
    - 体内字面量："^[a-zA-Z0-9_一-龥]+$"
- `boolean isEmail(String str)`  L81
    - 体内字面量："^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
- `boolean isTinyaiDeviceToken(String str)`  L85
    - 体内字面量："^[0-9a-zA-Z]{22}"