# XTU GO — 类与成员明细：com.gku.loginmodule.model

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 17 个文件 / 35 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.model.DeleteUserResponse`
L4 · [class] public DeleteUserResponse · `com/gku/loginmodule/model/DeleteUserResponse.java`

字段/常量（3）：
- `int code`  L5
- `Object data`  L6
- `String msg`  L7

方法（6）：
- `int getCode()`  L9
- `void setCode(int code)`  L13
- `String getMsg()`  L17
- `void setMsg(String msg)`  L21
- `Object getData()`  L25
- `void setData(Object data)`  L29
### `com.gku.loginmodule.model.ForgetPwdResponse`
L4 · [class] public ForgetPwdResponse · `com/gku/loginmodule/model/ForgetPwdResponse.java`

字段/常量（4）：
- `int code`  L5
- `Object data`  L6
- `String msg`  L7
- `Object page`  L8

方法（8）：
- `int getCode()`  L10
- `void setCode(int code)`  L14
- `String getMsg()`  L18
- `void setMsg(String msg)`  L22
- `Object getData()`  L26
- `void setData(Object data)`  L30
- `Object getPage()`  L34
- `void setPage(Object page)`  L38
### `com.gku.loginmodule.model.GetDeviceIdsResponse`
L6 · [class] public GetDeviceIdsResponse · `com/gku/loginmodule/model/GetDeviceIdsResponse.java`

字段/常量（3）：
- `int code`  L7
- `Data data`  L8
- `String msg`  L9

方法（6）：
- `int getCode()`  L11
- `void setCode(int code)`  L15
- `String getMsg()`  L19
- `void setMsg(String msg)`  L23
- `Data getData()`  L27
- `void setData(Data data)`  L31
### `com.gku.loginmodule.model.GetDeviceIdsResponse$Data`
L35 · [class] public static Data · `com/gku/loginmodule/model/GetDeviceIdsResponse.java`

字段/常量（1）：
- `List<DataBean> device_models`  L36

方法（2）：
- `List<DataBean> getDevice_models()`  L38
- `void setDevice_models(List<DataBean> device_models)`  L42
### `com.gku.loginmodule.model.GetDeviceIdsResponse$Data$DataBean`
L46 · [class] public static DataBean · `com/gku/loginmodule/model/GetDeviceIdsResponse.java`

字段/常量（4）：
- `String category_name`  L47
- `String category_name_en`  L48
- `String category_name_key`  L49
- `List<DeviceBean> models`  L50

方法（8）：
- `String getCategory_name()`  L52
- `void setCategory_name(String category_name)`  L56
- `String getCategory_name_en()`  L60
- `void setCategory_name_en(String category_name_en)`  L64
- `String getCategory_name_key()`  L68
- `void setCategory_name_key(String category_name_key)`  L72
- `List<DeviceBean> getModels()`  L76
- `void setModels(List<DeviceBean> models)`  L80
### `com.gku.loginmodule.model.GetDeviceIdsResponse$Data$DataBean$DeviceBean`
L84 · [class] public static DeviceBean · `com/gku/loginmodule/model/GetDeviceIdsResponse.java`

字段/常量（6）：
- `String bind_type`  L85
- `int id`  L86
- `String image`  L87
- `String model_name_en`  L88
- `String name`  L89
- `String name_key`  L90

方法（12）：
- `int getId()`  L92
- `void setId(int id)`  L96
- `String getBind_type()`  L100
- `void setBind_type(String bind_type)`  L104
- `String getImage()`  L108
- `void setImage(String image)`  L112
- `String getModel_name_en()`  L116
- `void setModel_name_en(String model_name_en)`  L120
- `String getName()`  L124
- `void setName(String name)`  L128
- `String getName_key()`  L132
- `void setName_key(String name_key)`  L136
### `com.gku.loginmodule.model.GetDeviceNewestVersionResponse`
L8 · [class] public GetDeviceNewestVersionResponse · `com/gku/loginmodule/model/GetDeviceNewestVersionResponse.java`

字段/常量（3）：
- `int code`  L9
- `DataBean data`  L10
- `String msg`  L11

方法（6）：
- `String getMsg()`  L13
- `void setMsg(String msg)`  L17
- `int getCode()`  L21
- `void setCode(int code)`  L25
- `DataBean getData()`  L29
- `void setData(DataBean data)`  L33
### `com.gku.loginmodule.model.GetDeviceNewestVersionResponse$DataBean`
L37 · [class] public static DataBean · `com/gku/loginmodule/model/GetDeviceNewestVersionResponse.java`

字段/常量（1）：
- `List<GetDeviceNewestVersionBean> list`  L38

方法（2）：
- `List<GetDeviceNewestVersionBean> getList()`  L40
- `void setList(List<GetDeviceNewestVersionBean> list)`  L44
### `com.gku.loginmodule.model.GetDeviceNewestVersionResponse$DataBean$GetDeviceNewestVersionBean`
L48 · [class] public static GetDeviceNewestVersionBean · `com/gku/loginmodule/model/GetDeviceNewestVersionResponse.java`

字段/常量（8）：
- `String file_url`  L49
- `String firm_ware_model`  L50
- `boolean force`  L51
- `String hardware_version`  L52
- `String region`  L53
- `String release_note`  L54
- `ArrayList<GetDeviceNewestVersionNote> release_notes`  L55
- `String version`  L56

方法（16）：
- `String getFile_url()`  L79
- `void setFile_url(String file_url)`  L83
- `String getFirm_ware_model()`  L87
- `void setFirm_ware_model(String firm_ware_model)`  L91
- `boolean isForce()`  L95
- `void setForce(boolean force)`  L99
- `String getRelease_note()`  L103
- `void setRelease_note(String release_note)`  L107
- `String getVersion()`  L111
- `void setVersion(String version)`  L115
- `String getHardware_version()`  L119
- `void setHardware_version(String hardware_version)`  L123
- `String getRegion()`  L127
- `void setRegion(String region)`  L131
- `ArrayList<GetDeviceNewestVersionNote> getRelease_notes()`  L135
- `void setRelease_notes(ArrayList<GetDeviceNewestVersionNote> release_notes)`  L139
### `com.gku.loginmodule.model.GetDeviceNewestVersionResponse$DataBean$GetDeviceNewestVersionBean$GetDeviceNewestVersionNote`
L58 · [class] public static GetDeviceNewestVersionNote · implements `Serializable` · `com/gku/loginmodule/model/GetDeviceNewestVersionResponse.java`

字段/常量（2）：
- `String content`  L59
- `String lang`  L60

方法（4）：
- `String getContent()`  L62
- `void setContent(String content)`  L66
- `String getLang()`  L70
- `void setLang(String lang)`  L74
### `com.gku.loginmodule.model.GetLanguagesResponse`
L6 · [class] public GetLanguagesResponse · `com/gku/loginmodule/model/GetLanguagesResponse.java`

字段/常量（4）：
- `List<DataBean> data`  L7
- `Object message`  L8
- `Object page`  L9
- `int retCode`  L10

方法（8）：
- `int getRetCode()`  L12
- `void setRetCode(int retCode)`  L16
- `Object getMessage()`  L20
- `void setMessage(Object message)`  L24
- `Object getPage()`  L28
- `void setPage(Object page)`  L32
- `List<DataBean> getData()`  L36
- `void setData(List<DataBean> data)`  L40
### `com.gku.loginmodule.model.GetLanguagesResponse$DataBean`
L44 · [class] public static DataBean · `com/gku/loginmodule/model/GetLanguagesResponse.java`

字段/常量（2）：
- `String lanCode`  L45
- `String remark`  L46

方法（4）：
- `String getLanCode()`  L48
- `void setLanCode(String lanCode)`  L52
- `String getRemark()`  L56
- `void setRemark(String remark)`  L60
### `com.gku.loginmodule.model.GetProblemTypesResponse`
L6 · [class] public GetProblemTypesResponse · `com/gku/loginmodule/model/GetProblemTypesResponse.java`

字段/常量（4）：
- `Data data`  L7
- `Object msg`  L8
- `Object page`  L9
- `int status`  L10

方法（8）：
- `int getStatus()`  L12
- `void setStatus(int status)`  L16
- `Object getMsg()`  L20
- `void setMsg(Object msg)`  L24
- `Object getPage()`  L28
- `void setPage(Object page)`  L32
- `Data getData()`  L36
- `void setData(Data data)`  L40
### `com.gku.loginmodule.model.GetProblemTypesResponse$Data`
L44 · [class] public static Data · `com/gku/loginmodule/model/GetProblemTypesResponse.java`

字段/常量（2）：
- `List<DataBean> items`  L45
- `int total`  L46

方法（4）：
- `List<DataBean> getItems()`  L48
- `void setItems(List<DataBean> items)`  L52
- `int getTotal()`  L56
- `void setTotal(int total)`  L60
### `com.gku.loginmodule.model.GetProblemTypesResponse$DataBean`
L65 · [class] public static DataBean · `com/gku/loginmodule/model/GetProblemTypesResponse.java`

字段/常量（4）：
- `int id`  L66
- `String qs_type_id`  L67
- `String qs_type_name`  L68
- `String qs_type_name_key`  L69

方法（8）：
- `String getQs_type_id()`  L71
- `void setQs_type_id(String qs_type_id)`  L75
- `int getId()`  L79
- `void setId(int id)`  L83
- `String getQs_type_name_key()`  L87
- `void setQs_type_name_key(String qs_type_name_key)`  L91
- `String getQs_type_name()`  L95
- `void setQs_type_name(String qs_type_name)`  L99
### `com.gku.loginmodule.model.GetProductTypesResponse`
L6 · [class] public GetProductTypesResponse · `com/gku/loginmodule/model/GetProductTypesResponse.java`

字段/常量（4）：
- `int code`  L7
- `Data data`  L8
- `Object msg`  L9
- `Object page`  L10

方法（8）：
- `int getCode()`  L12
- `void setCode(int code)`  L16
- `Object getMsg()`  L20
- `void setMsg(Object msg)`  L24
- `Object getPage()`  L28
- `void setPage(Object page)`  L32
- `Data getData()`  L36
- `void setData(Data data)`  L40
### `com.gku.loginmodule.model.GetProductTypesResponse$Data`
L44 · [class] public static Data · `com/gku/loginmodule/model/GetProductTypesResponse.java`

字段/常量（1）：
- `List<DataBean> device_models`  L45

方法（2）：
- `List<DataBean> getDevice_models()`  L47
- `void setDevice_models(List<DataBean> device_models)`  L51
### `com.gku.loginmodule.model.GetProductTypesResponse$DataBean`
L56 · [class] public static DataBean · `com/gku/loginmodule/model/GetProductTypesResponse.java`

字段/常量（4）：
- `String category_name`  L57
- `String category_name_en`  L58
- `String category_name_key`  L59
- `List<ModelsBean> models`  L60

方法（8）：
- `String getCategory_name_key()`  L62
- `void setCategory_name_key(String category_name_key)`  L66
- `String getCategory_name()`  L70
- `void setCategory_name(String category_name)`  L74
- `String getCategory_name_en()`  L78
- `void setCategory_name_en(String category_name_en)`  L82
- `List<ModelsBean> getModels()`  L86
- `void setModels(List<ModelsBean> models)`  L90
### `com.gku.loginmodule.model.GetProductTypesResponse$DataBean$ModelsBean`
L94 · [class] public static ModelsBean · `com/gku/loginmodule/model/GetProductTypesResponse.java`

字段/常量（6）：
- `String bind_type`  L95
- `int id`  L96
- `String image`  L97
- `String model_name_en`  L98
- `String name`  L99
- `String name_key`  L100

方法（12）：
- `int getId()`  L102
- `void setId(int id)`  L106
- `String getName()`  L110
- `void setName(String name)`  L114
- `String getBind_type()`  L118
- `void setBind_type(String bind_type)`  L122
- `String getImage()`  L126
- `void setImage(String image)`  L130
- `String getModel_name_en()`  L134
- `void setModel_name_en(String model_name_en)`  L138
- `String getName_key()`  L142
- `void setName_key(String name_key)`  L146
### `com.gku.loginmodule.model.GetPromotionListResponse`
L6 · [class] public GetPromotionListResponse · `com/gku/loginmodule/model/GetPromotionListResponse.java`

字段/常量（4）：
- `List<DataBean> data`  L7
- `Object message`  L8
- `Object page`  L9
- `int retCode`  L10

方法（8）：
- `int getRetCode()`  L12
- `void setRetCode(int retCode)`  L16
- `Object getMessage()`  L20
- `void setMessage(Object message)`  L24
- `Object getPage()`  L28
- `void setPage(Object page)`  L32
- `List<DataBean> getData()`  L36
- `void setData(List<DataBean> data)`  L40
### `com.gku.loginmodule.model.GetPromotionListResponse$DataBean`
L44 · [class] public static DataBean · `com/gku/loginmodule/model/GetPromotionListResponse.java`

字段/常量（5）：
- `String content`  L45
- `String createTime`  L46
- `String iconUrl`  L47
- `String linkUrl`  L48
- `String title`  L49

方法（10）：
- `String getTitle()`  L51
- `void setTitle(String title)`  L55
- `String getContent()`  L59
- `void setContent(String content)`  L63
- `String getLinkUrl()`  L67
- `void setLinkUrl(String linkUrl)`  L71
- `String getIconUrl()`  L75
- `void setIconUrl(String iconUrl)`  L79
- `String getCreateTime()`  L83
- `void setCreateTime(String createTime)`  L87
### `com.gku.loginmodule.model.LocalDeviceVersionInfoBean`
L7 · [class] public LocalDeviceVersionInfoBean · implements `Serializable` · `com/gku/loginmodule/model/LocalDeviceVersionInfoBean.java`

字段/常量（7）：
- `String curVersion`  L8
- `String downloadUrl`  L9
- `String model`  L10
- `String newVersion`  L11
- `String pcbrevision`  L12
- `String region`  L13
- `ArrayList<GetDeviceNewestVersionResponse.DataBean.GetDeviceNewestVersionBean.GetDeviceNewestVersionNote> release_notes`  L14

方法（14）：
- `String getModel()`  L16
- `void setModel(String model)`  L20
- `String getCurVersion()`  L24
- `void setCurVersion(String curVersion)`  L28
- `String getNewVersion()`  L32
- `void setNewVersion(String newVersion)`  L36
- `String getDownloadUrl()`  L40
- `void setDownloadUrl(String downloadUrl)`  L44
- `String getRegion()`  L48
- `void setRegion(String region)`  L52
- `String getPcbrevision()`  L56
- `void setPcbrevision(String pcbrevision)`  L60
- `ArrayList<GetDeviceNewestVersionResponse.DataBean.GetDeviceNewestVersionBean.GetDeviceNewestVersionNote> getRelease_notes()`  L64
- `void setRelease_notes(ArrayList<GetDeviceNewestVersionResponse.DataBean.GetDeviceNewestVersionBean.GetDeviceNewestVersionNote> release_notes)`  L68
### `com.gku.loginmodule.model.LoginResponse`
L4 · [class] public LoginResponse · `com/gku/loginmodule/model/LoginResponse.java`

字段/常量（4）：
- `int code`  L5
- `DataBean data`  L6
- `String msg`  L7
- `Object page`  L8

方法（9）：
- `int getCode()`  L10
- `void setCode(int code)`  L14
- `String getMsg()`  L18
- `void setMsg(String msg)`  L22
- `DataBean getData()`  L26
- `void setData(DataBean data)`  L30
- `Object getPage()`  L34
- `void setPage(Object page)`  L38
- `String toString()`  L232
    - 体内字面量："LoginResponse{retCode=" · ", message='" · "', data=" · ", page=" · "}"
### `com.gku.loginmodule.model.LoginResponse$DataBean`
L42 · [class] public static DataBean · `com/gku/loginmodule/model/LoginResponse.java`

字段/常量（20）：
- `String activeTime`  L43
- `Object createBy`  L44
- `Object createTime`  L45
- `String email`  L46
- `String habits`  L47
- `int id`  L48
- `String lanCode`  L49
- `int loginTimes`  L50
- `Object mobile`  L51
- `ParamsBean params`  L52
- `String productModel`  L53
- `String registTime`  L54
- `Object remark`  L55
- `Object searchValue`  L56
- `Object updateBy`  L57
- `Object updateTime`  L58
- `String userPwd`  L59
- `Object userdata1`  L60
- `Object userdata2`  L61
- `Object userdata3`  L62

方法（41）：
- `Object getSearchValue()`  L67
- `void setSearchValue(Object searchValue)`  L71
- `Object getCreateBy()`  L75
- `void setCreateBy(Object createBy)`  L79
- `Object getCreateTime()`  L83
- `void setCreateTime(Object createTime)`  L87
- `Object getUpdateBy()`  L91
- `void setUpdateBy(Object updateBy)`  L95
- `Object getUpdateTime()`  L99
- `void setUpdateTime(Object updateTime)`  L103
- `Object getRemark()`  L107
- `void setRemark(Object remark)`  L111
- `ParamsBean getParams()`  L115
- `void setParams(ParamsBean params)`  L119
- `int getId()`  L123
- `void setId(int id)`  L127
- `String getUserPwd()`  L131
- `void setUserPwd(String userPwd)`  L135
- `String getEmail()`  L139
- `void setEmail(String email)`  L143
- `Object getMobile()`  L147
- `void setMobile(Object mobile)`  L151
- `String getLanCode()`  L155
- `void setLanCode(String lanCode)`  L159
- `String getRegistTime()`  L163
- `void setRegistTime(String registTime)`  L167
- `String getActiveTime()`  L171
- `void setActiveTime(String activeTime)`  L175
- `int getLoginTimes()`  L179
- `void setLoginTimes(int loginTimes)`  L183
- `String getProductModel()`  L187
- `void setProductModel(String productModel)`  L191
- `String getHabits()`  L195
- `void setHabits(String habits)`  L199
- `Object getUserdata1()`  L203
- `void setUserdata1(Object userdata1)`  L207
- `Object getUserdata2()`  L211
- `void setUserdata2(Object userdata2)`  L215
- `Object getUserdata3()`  L219
- `void setUserdata3(Object userdata3)`  L223
- `String toString()`  L227
    - 体内字面量："DataBean{searchValue=" · ", createBy=" · ", createTime=" · ", updateBy=" · ", updateTime=" · ", remark=" · ", params=" · ", id=" · ", userPwd='" · "', email='" · "', mobile=" · ", lanCode='" · "', registTime='" · "', activeTime='" · "', loginTimes=" · ", productModel='" · "', habits='" · "', userdata1=" · ", userdata2=" · ", userdata3=" · "}"
### `com.gku.loginmodule.model.LoginResponse$DataBean$ParamsBean`
L64 · [class] public static ParamsBean · `com/gku/loginmodule/model/LoginResponse.java`
### `com.gku.loginmodule.model.LogoutResponse`
L4 · [class] public LogoutResponse · `com/gku/loginmodule/model/LogoutResponse.java`

字段/常量（3）：
- `int code`  L5
- `Object data`  L6
- `String msg`  L7

方法（6）：
- `int getCode()`  L9
- `void setCode(int code)`  L13
- `String getMsg()`  L17
- `void setMsg(String msg)`  L21
- `Object getData()`  L25
- `void setData(Object data)`  L29
### `com.gku.loginmodule.model.ModifyPwdResponse`
L4 · [class] public ModifyPwdResponse · `com/gku/loginmodule/model/ModifyPwdResponse.java`

字段/常量（4）：
- `int code`  L5
- `Object data`  L6
- `String msg`  L7
- `Object page`  L8

方法（8）：
- `int getCode()`  L10
- `void setCode(int code)`  L14
- `String getMsg()`  L18
- `void setMsg(String msg)`  L22
- `Object getData()`  L26
- `void setData(Object data)`  L30
- `Object getPage()`  L34
- `void setPage(Object page)`  L38
### `com.gku.loginmodule.model.RegisterResponse`
L4 · [class] public RegisterResponse · `com/gku/loginmodule/model/RegisterResponse.java`

字段/常量（4）：
- `int code`  L5
- `Object data`  L6
- `String msg`  L7
- `Object page`  L8

方法（8）：
- `int getCode()`  L10
- `void setCode(int code)`  L14
- `String getMsg()`  L18
- `void setMsg(String msg)`  L22
- `Object getData()`  L26
- `void setData(Object data)`  L30
- `Object getPage()`  L34
- `void setPage(Object page)`  L38
### `com.gku.loginmodule.model.ReportFeedbackResponse`
L4 · [class] public ReportFeedbackResponse · `com/gku/loginmodule/model/ReportFeedbackResponse.java`

字段/常量（3）：
- `int code`  L5
- `Object data`  L6
- `String msg`  L7

方法（6）：
- `int getCode()`  L9
- `void setCode(int code)`  L13
- `String getMsg()`  L17
- `void setMsg(String msg)`  L21
- `Object getData()`  L25
- `void setData(Object data)`  L29
### `com.gku.loginmodule.model.UpdateUserInformationResponse`
L4 · [class] public UpdateUserInformationResponse · `com/gku/loginmodule/model/UpdateUserInformationResponse.java`

字段/常量（4）：
- `DataBean data`  L5
- `Object message`  L6
- `Object page`  L7
- `int retCode`  L8

方法（8）：
- `int getRetCode()`  L10
- `void setRetCode(int retCode)`  L14
- `Object getMessage()`  L18
- `void setMessage(Object message)`  L22
- `DataBean getData()`  L26
- `void setData(DataBean data)`  L30
- `Object getPage()`  L34
- `void setPage(Object page)`  L38
### `com.gku.loginmodule.model.UpdateUserInformationResponse$DataBean`
L42 · [class] public static DataBean · `com/gku/loginmodule/model/UpdateUserInformationResponse.java`

字段/常量（20）：
- `String activeTime`  L43
- `Object createBy`  L44
- `Object createTime`  L45
- `String email`  L46
- `String habits`  L47
- `int id`  L48
- `String lanCode`  L49
- `int loginTimes`  L50
- `String mobile`  L51
- `ParamsBean params`  L52
- `String productModel`  L53
- `String registTime`  L54
- `Object remark`  L55
- `Object searchValue`  L56
- `Object updateBy`  L57
- `Object updateTime`  L58
- `Object userPwd`  L59
- `String userdata1`  L60
- `String userdata2`  L61
- `String userdata3`  L62

方法（40）：
- `Object getSearchValue()`  L67
- `void setSearchValue(Object searchValue)`  L71
- `Object getCreateBy()`  L75
- `void setCreateBy(Object createBy)`  L79
- `Object getCreateTime()`  L83
- `void setCreateTime(Object createTime)`  L87
- `Object getUpdateBy()`  L91
- `void setUpdateBy(Object updateBy)`  L95
- `Object getUpdateTime()`  L99
- `void setUpdateTime(Object updateTime)`  L103
- `Object getRemark()`  L107
- `void setRemark(Object remark)`  L111
- `ParamsBean getParams()`  L115
- `void setParams(ParamsBean params)`  L119
- `int getId()`  L123
- `void setId(int id)`  L127
- `Object getUserPwd()`  L131
- `void setUserPwd(Object userPwd)`  L135
- `String getEmail()`  L139
- `void setEmail(String email)`  L143
- `String getMobile()`  L147
- `void setMobile(String mobile)`  L151
- `String getLanCode()`  L155
- `void setLanCode(String lanCode)`  L159
- `String getRegistTime()`  L163
- `void setRegistTime(String registTime)`  L167
- `String getActiveTime()`  L171
- `void setActiveTime(String activeTime)`  L175
- `int getLoginTimes()`  L179
- `void setLoginTimes(int loginTimes)`  L183
- `String getProductModel()`  L187
- `void setProductModel(String productModel)`  L191
- `String getHabits()`  L195
- `void setHabits(String habits)`  L199
- `String getUserdata1()`  L203
- `void setUserdata1(String userdata1)`  L207
- `String getUserdata2()`  L211
- `void setUserdata2(String userdata2)`  L215
- `String getUserdata3()`  L219
- `void setUserdata3(String userdata3)`  L223
### `com.gku.loginmodule.model.UpdateUserInformationResponse$DataBean$ParamsBean`
L64 · [class] public static ParamsBean · `com/gku/loginmodule/model/UpdateUserInformationResponse.java`
### `com.gku.loginmodule.model.UploadAttachmentResponse`
L4 · [class] public UploadAttachmentResponse · `com/gku/loginmodule/model/UploadAttachmentResponse.java`

字段/常量（4）：
- `int code`  L5
- `Data data`  L6
- `Object msg`  L7
- `Object page`  L8

方法（8）：
- `int getCode()`  L10
- `void setCode(int code)`  L14
- `Object getMsg()`  L18
- `void setMsg(Object msg)`  L22
- `Data getData()`  L26
- `void setData(Data data)`  L30
- `Object getPage()`  L34
- `void setPage(Object page)`  L38
### `com.gku.loginmodule.model.UploadAttachmentResponse$Data`
L42 · [class] public static Data · `com/gku/loginmodule/model/UploadAttachmentResponse.java`

字段/常量（1）：
- `String url`  L43

方法（2）：
- `String getUrl()`  L45
- `void setUrl(String url)`  L49
### `com.gku.loginmodule.model.VerifyCodeResponse`
L4 · [class] public VerifyCodeResponse · `com/gku/loginmodule/model/VerifyCodeResponse.java`

字段/常量（4）：
- `int code`  L5
- `Object data`  L6
- `String msg`  L7
- `Object page`  L8

方法（9）：
- `int getCode()`  L10
- `void setCode(int code)`  L14
- `String getMsg()`  L18
- `void setMsg(String msg)`  L22
- `Object getData()`  L26
- `void setData(Object data)`  L30
- `Object getPage()`  L34
- `void setPage(Object page)`  L38
- `String toString()`  L42
    - 体内字面量："VerifyCodeResponse{retCode=" · ", message='" · "', data=" · ", page=" · "}"