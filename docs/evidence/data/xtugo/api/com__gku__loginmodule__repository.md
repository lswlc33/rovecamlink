# XTU GO — 类与成员明细：com.gku.loginmodule.repository

> 本文件由 `tools/re/` 自动生成，请勿手工编辑；重跑方式见 `tools/re/README.md`。
> 输出不带时间戳：同版本工具重跑应逐字节一致，git diff 里出现的差异都是真实取证差异。
> 35 个文件 / 52 个类型（含内部类）
> 每类给出：声明与父类型、有效注解、字段（含字面值）、枚举实参、方法签名，以及该方法体内出现的全部字符串字面量
> `L<n>` 为 jadx 输出文件内行号，配合源码目录可定位

---

归属：OWN
### `com.gku.loginmodule.repository.AnnouncementRepository`
L15 · [class] public AnnouncementRepository · `com/gku/loginmodule/repository/AnnouncementRepository.java`

字段/常量（1）：
- `String TAG = "AnnouncementRepository"`  L16

方法（34）：
- `public AnnouncementRepository()`  L22 @Inject
- `MutableLiveData<List<Announcement>> getAnnouncementList()`  L25
- `void accept(Object obj)`  L28 @Override
- `void lambda$getAnnouncementList$0(List list)`  L36
    - 体内字面量："-1"
- `MutableLiveData<Announcement> getAnnouncementByTitle(String title)`  L44
- `void accept(Object obj)`  L47 @Override
- `void lambda$getAnnouncementByTitle$1(Announcement announcement)`  L55
    - 体内字面量："-1"
- `MutableLiveData<Announcement> getAnnouncementByContent(String content)`  L63
- `void accept(Object obj)`  L66 @Override
- `void lambda$getAnnouncementByContent$2(Announcement announcement)`  L74
    - 体内字面量："-1"
- `MutableLiveData<Announcement> getAnnouncementByLinkUrl(String linkUrl)`  L82
- `void accept(Object obj)`  L85 @Override
- `void lambda$getAnnouncementByLinkUrl$3(Announcement announcement)`  L93
    - 体内字面量："-1"
- `MutableLiveData<Announcement> getAnnouncementByIconUrl(String iconUrl)`  L101
- `void accept(Object obj)`  L104 @Override
- `void lambda$getAnnouncementByIconUrl$4(Announcement announcement)`  L112
    - 体内字面量："-1"
- `MutableLiveData<Announcement> getAnnouncementByCreateTime(String createTime)`  L120
- `void accept(Object obj)`  L123 @Override
- `void lambda$getAnnouncementByCreateTime$5(Announcement announcement)`  L131
    - 体内字面量："-1"
- `void updateAnnouncement(Announcement announcement)`  L139
- `void run()`  L142 @Override
- `void lambda$updateAnnouncement$6()`  L149
    - 体内字面量："updateAnnouncement: å¬åæ°æ®æ´æ°æå"
- `void updateAnnouncementList(List<Announcement> announcementList)`  L154
- `void run()`  L157 @Override
- `void lambda$updateAnnouncementList$7()`  L164
    - 体内字面量："updateAnnouncementList: å¬åæ°æ®æ´æ°æå"
- `void insertAnnouncement(Announcement announcement)`  L169
- `void run()`  L172 @Override
- `void lambda$insertAnnouncement$8()`  L179
    - 体内字面量："insertAnnouncement: å¬åæ°æ®æå¥å®æ"
- `void deleteAllAnnouncement()`  L184
- `void run()`  L187 @Override
- `void lambda$deleteAllAnnouncement$9()`  L194
    - 体内字面量："deleteAllAnnouncement: å¬åæ°æ®å é¤æå"
- `void deleteAnnouncementByTitle(final String title)`  L199
- `void run()`  L202 @Override
- `void lambda$deleteAnnouncementByTitle$10(String str)`  L209
    - 体内字面量："deleteAnnouncementByTitle: " · " å¬åæ°æ®å é¤æå"
### `com.gku.loginmodule.repository.AnnouncementRepository_Factory`
L6 · [class] public final AnnouncementRepository_Factory · implements `Factory<AnnouncementRepository>` · `com/gku/loginmodule/repository/AnnouncementRepository_Factory.java`

方法（3）：
- `AnnouncementRepository get()`  L8 @Override
- `AnnouncementRepository_Factory create()`  L12
- `AnnouncementRepository newInstance()`  L16
### `com.gku.loginmodule.repository.AnnouncementRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/AnnouncementRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.CustomDisposable`
L13 · [class] public CustomDisposable · `com/gku/loginmodule/repository/CustomDisposable.java`

方法（4）：
- `void addDisposable(Flowable<T> flowable, Consumer<T> consumer)`  L17
- `void addDisposable(Flowable<T> flowable, Consumer<T> onNext, Consumer<Throwable> onError, Action onComplete)`  L22
- `void addDisposable(Completable completable, Action action)`  L26
- `void addDisposable(Maybe<T> maybe, Consumer<T> onSuccess, Consumer<Throwable> onError, Action onComplete)`  L31
### `com.gku.loginmodule.repository.DeleteAccountRepository`
L14 · [class] public DeleteAccountRepository · `com/gku/loginmodule/repository/DeleteAccountRepository.java`

字段/常量（1）：
- `String TAG = "DeleteAccountRepository"`  L15

方法（4）：
- `public DeleteAccountRepository()`  L20 @Inject
- `SingleLiveEvent<DeleteUserResponse> getDeleteUserResponse(String email, String pwd, String verifyCode)`  L23
    - 体内字面量："email" · "password" · "vcode"
- `void onSuccess(DeleteUserResponse response)`  L30 @Override
    - 体内字面量："response onSuccess: "
- `void onFailure(Throwable e)`  L37 @Override
    - 体内字面量："-1" · "onFailure: "
### `com.gku.loginmodule.repository.DeleteAccountRepository_Factory`
L6 · [class] public final DeleteAccountRepository_Factory · implements `Factory<DeleteAccountRepository>` · `com/gku/loginmodule/repository/DeleteAccountRepository_Factory.java`

方法（3）：
- `DeleteAccountRepository get()`  L8 @Override
- `DeleteAccountRepository_Factory create()`  L12
- `DeleteAccountRepository newInstance()`  L16
### `com.gku.loginmodule.repository.DeleteAccountRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/DeleteAccountRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.DeviceInfoRepository`
L13 · [class] public DeviceInfoRepository · `com/gku/loginmodule/repository/DeviceInfoRepository.java`

字段/常量（1）：
- `String TAG = "DeviceInfoRepository"`  L14

方法（33）：
- `public DeviceInfoRepository()`  L20 @Inject
- `void insertDevice(final DeviceVersionInfo deviceInfo)`  L23
- `void accept(Object obj)`  L26 @Override
- `void accept(Object obj)`  L31 @Override
- `void run()`  L36 @Override
- `void lambda$insertDevice$1(DeviceVersionInfo deviceVersionInfo, DeviceVersionInfo deviceVersionInfo2)`  L43
- `void run()`  L55 @Override
- `void lambda$insertDevice$0()`  L63
- `void lambda$insertDevice$3(DeviceVersionInfo deviceVersionInfo, Throwable th)`  L68
- `void run()`  L71 @Override
- `void lambda$insertDevice$2()`  L78
- `void lambda$insertDevice$5(DeviceVersionInfo deviceVersionInfo)`  L83
- `void run()`  L86 @Override
- `void lambda$insertDevice$4()`  L93
- `boolean isEqual(String version1, String version2)`  L97
- `MutableLiveData<List<DeviceVersionInfo>> getAllDevices()`  L107
- `void accept(Object obj)`  L110 @Override
- `void lambda$getAllDevices$6(List list)`  L118
    - 体内字面量："-1"
- `void deleteAllDevices()`  L126
- `void run()`  L129 @Override
- `void lambda$deleteAllDevices$7()`  L136
- `void updateDevice(DeviceVersionInfo deviceInfo)`  L140
- `void run()`  L143 @Override
- `void lambda$updateDevice$8()`  L150
- `void updateDeviceList(List<DeviceVersionInfo> deviceInfos)`  L154
- `void run()`  L157 @Override
- `void lambda$updateDeviceList$9()`  L164
- `void deleteDevice(DeviceVersionInfo deviceInfo)`  L168
- `void run()`  L171 @Override
- `void lambda$deleteDevice$10()`  L178
- `void deleteDeviceList(List<DeviceVersionInfo> deviceInfos)`  L182
- `void run()`  L185 @Override
- `void lambda$deleteDeviceList$11()`  L192
### `com.gku.loginmodule.repository.DeviceInfoRepository_Factory`
L6 · [class] public final DeviceInfoRepository_Factory · implements `Factory<DeviceInfoRepository>` · `com/gku/loginmodule/repository/DeviceInfoRepository_Factory.java`

方法（3）：
- `DeviceInfoRepository get()`  L8 @Override
- `DeviceInfoRepository_Factory create()`  L12
- `DeviceInfoRepository newInstance()`  L16
### `com.gku.loginmodule.repository.DeviceInfoRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/DeviceInfoRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.ForgetPasswordRepository`
L14 · [class] public ForgetPasswordRepository · `com/gku/loginmodule/repository/ForgetPasswordRepository.java`

字段/常量（1）：
- `String TAG = "ForgetPwdRepository"`  L15

方法（4）：
- `public ForgetPasswordRepository()`  L20 @Inject
- `SingleLiveEvent<ForgetPwdResponse> getForgetPwdResponse(String emailAddress, String pwd, String opType)`  L23
    - 体内字面量："email" · "password" · "vcode"
- `void onSuccess(ForgetPwdResponse response)`  L30 @Override
    - 体内字面量："response onSuccess: "
- `void onFailure(Throwable e)`  L37 @Override
    - 体内字面量："-1" · "onFailure: "
### `com.gku.loginmodule.repository.ForgetPasswordRepository_Factory`
L6 · [class] public final ForgetPasswordRepository_Factory · implements `Factory<ForgetPasswordRepository>` · `com/gku/loginmodule/repository/ForgetPasswordRepository_Factory.java`

方法（3）：
- `ForgetPasswordRepository get()`  L8 @Override
- `ForgetPasswordRepository_Factory create()`  L12
- `ForgetPasswordRepository newInstance()`  L16
### `com.gku.loginmodule.repository.ForgetPasswordRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/ForgetPasswordRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.GetLanguageListRepository`
L19 · [class] public GetLanguageListRepository · `com/gku/loginmodule/repository/GetLanguageListRepository.java`

字段/常量（1）：
- `String TAG = "GetLanguagesRepository"`  L20

方法（11）：
- `public GetLanguageListRepository()`  L25 @Inject
- `MutableLiveData<GetLanguagesResponse> getLanguageListFromCloud()`  L28
- `void onSuccess(GetLanguagesResponse response)`  L31 @Override
- `void onFailure(Throwable e)`  L41 @Override
    - 体内字面量："onFailure: "
- `MutableLiveData<List<CloudLanguages>> getLanguageListFromRoom()`  L52
- `void accept(Object obj)`  L55 @Override
- `void lambda$getLanguageListFromRoom$0(List list)`  L63
- `void saveLanguageListToRoom(List<CloudLanguages> cloudLanguages)`  L71
- `void run()`  L76 @Override
    - 体内字面量："saveLanguageListToRoom: ä¿å­æå"
- `void clearLanguageListFromRoom(CloudLanguagesDao cloudLanguagesDao)`  L82
- `void run()`  L85 @Override
    - 体内字面量："clearLanguageListFromRoom: æ¸ç©ºæå"
### `com.gku.loginmodule.repository.GetLanguageListRepository_Factory`
L6 · [class] public final GetLanguageListRepository_Factory · implements `Factory<GetLanguageListRepository>` · `com/gku/loginmodule/repository/GetLanguageListRepository_Factory.java`

方法（3）：
- `GetLanguageListRepository get()`  L8 @Override
- `GetLanguageListRepository_Factory create()`  L12
- `GetLanguageListRepository newInstance()`  L16
### `com.gku.loginmodule.repository.GetLanguageListRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/GetLanguageListRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.GetPromotionListRepository`
L14 · [class] public GetPromotionListRepository · `com/gku/loginmodule/repository/GetPromotionListRepository.java`

字段/常量（1）：
- `String TAG = "GetPromotionsRepository"`  L15

方法（4）：
- `public GetPromotionListRepository()`  L20 @Inject
- `MutableLiveData<GetPromotionListResponse> getPromotionList(String language)`  L23
    - 体内字面量："lanCode"
- `void onSuccess(GetPromotionListResponse response)`  L28 @Override
    - 体内字面量："response onSuccess: "
- `void onFailure(Throwable e)`  L35 @Override
    - 体内字面量："-1" · "onFailure: "
### `com.gku.loginmodule.repository.GetPromotionListRepository_Factory`
L6 · [class] public final GetPromotionListRepository_Factory · implements `Factory<GetPromotionListRepository>` · `com/gku/loginmodule/repository/GetPromotionListRepository_Factory.java`

方法（3）：
- `GetPromotionListRepository get()`  L8 @Override
- `GetPromotionListRepository_Factory create()`  L12
- `GetPromotionListRepository newInstance()`  L16
### `com.gku.loginmodule.repository.GetPromotionListRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/GetPromotionListRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.GKUUserRepository`
L20 · [class] public GKUUserRepository · `com/gku/loginmodule/repository/GKUUserRepository.java`

字段/常量（3）：
- `String TAG = "GKUUserRepository"`  L21
- `Login_Register_Activity login_Register_Activity2 = login_Register_Activity`  L94
- `UserInfoActivity userInfoActivity2 = userInfoActivity`  L116

方法（17）：
- `public GKUUserRepository()`  L26 @Inject
- `MutableLiveData<GKUUser> getGKUUser()`  L29
- `void accept(Object obj)`  L32 @Override
- `void lambda$getGKUUser$0(List list)`  L40
    - 体内字面量："-1"
- `void updateGKUUser(GKUUser gkuUser)`  L55
- `void run()`  L58 @Override
- `void lambda$updateGKUUser$1()`  L65
    - 体内字面量："updateGKUUser: ç¨æ·æ°æ®æ´æ°æå" · "update_0"
- `void saveGKUUser(final Login_Register_Activity mActivity, final GKUUser gkuUser)`  L70
- `void run()`  L73 @Override
- `void lambda$saveGKUUser$4(GKUUser gKUUser, final Login_Register_Activity login_Register_Activity)`  L80
- `void run()`  L83 @Override
- `void lambda$saveGKUUser$3(final Login_Register_Activity login_Register_Activity)`  L90
- `void run()`  L93 @Override
- `void deleteGKUUser(final UserInfoActivity mActivity, final boolean isJumpToLoginFragment)`  L101
- `void run()`  L104 @Override
- `void lambda$deleteGKUUser$6(final UserInfoActivity userInfoActivity, boolean z)`  L111
    - 体内字面量："deleteGKUUser: æ¬å°å é¤è´¦å·æå"
- `void run()`  L115 @Override
### `com.gku.loginmodule.repository.GKUUserRepository_Factory`
L6 · [class] public final GKUUserRepository_Factory · implements `Factory<GKUUserRepository>` · `com/gku/loginmodule/repository/GKUUserRepository_Factory.java`

方法（3）：
- `GKUUserRepository get()`  L8 @Override
- `GKUUserRepository_Factory create()`  L12
- `GKUUserRepository newInstance()`  L16
### `com.gku.loginmodule.repository.GKUUserRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/GKUUserRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.LoginRepository`
L14 · [class] public LoginRepository · `com/gku/loginmodule/repository/LoginRepository.java`

字段/常量（1）：
- `String TAG = "LoginRepository"`  L15

方法（3）：
- `SingleLiveEvent<LoginResponse> getLoginResponse(String emailAddress, String password, String language, String productModel, String habits)`  L23
    - 体内字面量："email" · "password" · "lanCode" · "productModel" · "habits"
- `void onSuccess(LoginResponse loginResponse)`  L32 @Override
    - 体内字面量："onSuccess: "
- `void onFailure(Throwable e)`  L39 @Override
    - 体内字面量："Network Error: " · "News Error: "
### `com.gku.loginmodule.repository.LoginRepository_Factory`
L6 · [class] public final LoginRepository_Factory · implements `Factory<LoginRepository>` · `com/gku/loginmodule/repository/LoginRepository_Factory.java`

方法（3）：
- `LoginRepository get()`  L8 @Override
- `LoginRepository_Factory create()`  L12
- `LoginRepository newInstance()`  L16
### `com.gku.loginmodule.repository.LoginRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/LoginRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.LogoutRepository`
L14 · [class] public LogoutRepository · `com/gku/loginmodule/repository/LogoutRepository.java`

字段/常量（1）：
- `String TAG = "LogoutRepository"`  L15

方法（3）：
- `MutableLiveData<LogoutResponse> getLogoutResponse(String emailAddress)`  L23
    - 体内字面量："email"
- `void onSuccess(LogoutResponse logoutResponse)`  L28 @Override
    - 体内字面量："onSuccess: "
- `void onFailure(Throwable e)`  L35 @Override
    - 体内字面量："Network Error: " · "News Error: "
### `com.gku.loginmodule.repository.LogoutRepository_Factory`
L6 · [class] public final LogoutRepository_Factory · implements `Factory<LogoutRepository>` · `com/gku/loginmodule/repository/LogoutRepository_Factory.java`

方法（3）：
- `LogoutRepository get()`  L8 @Override
- `LogoutRepository_Factory create()`  L12
- `LogoutRepository newInstance()`  L16
### `com.gku.loginmodule.repository.LogoutRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/LogoutRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.ModifyPasswordRepository`
L14 · [class] public ModifyPasswordRepository · `com/gku/loginmodule/repository/ModifyPasswordRepository.java`

字段/常量（1）：
- `String TAG = "ModifyPwdRepository"`  L15

方法（4）：
- `public ModifyPasswordRepository()`  L20 @Inject
- `SingleLiveEvent<ModifyPwdResponse> getModifyPwdResponse(String id, String oldPassword, String newPassword)`  L23
    - 体内字面量："email" · "old_password" · "new_password"
- `void onSuccess(ModifyPwdResponse response)`  L30 @Override
    - 体内字面量："response onSuccess: "
- `void onFailure(Throwable e)`  L37 @Override
    - 体内字面量："-1" · "onFailure: "
### `com.gku.loginmodule.repository.ModifyPasswordRepository_Factory`
L6 · [class] public final ModifyPasswordRepository_Factory · implements `Factory<ModifyPasswordRepository>` · `com/gku/loginmodule/repository/ModifyPasswordRepository_Factory.java`

方法（3）：
- `ModifyPasswordRepository get()`  L8 @Override
- `ModifyPasswordRepository_Factory create()`  L12
- `ModifyPasswordRepository newInstance()`  L16
### `com.gku.loginmodule.repository.ModifyPasswordRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/ModifyPasswordRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.ProblemTypesRepository`
L12 · [class] public ProblemTypesRepository · `com/gku/loginmodule/repository/ProblemTypesRepository.java`

字段/常量（1）：
- `String TAG = "ProblemTypesRepository"`  L13

方法（4）：
- `public ProblemTypesRepository()`  L18 @Inject
- `MutableLiveData<GetProblemTypesResponse> getProblemTypes(String language)`  L21
- `void onSuccess(GetProblemTypesResponse response)`  L24 @Override
    - 体内字面量："response onSuccess: "
- `void onFailure(Throwable e)`  L31 @Override
    - 体内字面量："-1" · "onFailure: "
### `com.gku.loginmodule.repository.ProblemTypesRepository_Factory`
L6 · [class] public final ProblemTypesRepository_Factory · implements `Factory<ProblemTypesRepository>` · `com/gku/loginmodule/repository/ProblemTypesRepository_Factory.java`

方法（3）：
- `ProblemTypesRepository get()`  L8 @Override
- `ProblemTypesRepository_Factory create()`  L12
- `ProblemTypesRepository newInstance()`  L16
### `com.gku.loginmodule.repository.ProblemTypesRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/ProblemTypesRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.PTAndPMRepository`
L25 · [class] public PTAndPMRepository · `com/gku/loginmodule/repository/PTAndPMRepository.java`

字段/常量（1）：
- `String TAG = "PTAndPMRepository"`  L26

方法（7）：
- `public PTAndPMRepository()`  L32 @Inject
- `MutableLiveData<GetProductTypesResponse> getPTAndPM(final FragmentActivity mActivity)`  L35
- `void onSuccess(GetProductTypesResponse response)`  L38 @Override
- `void onFailure(Throwable e)`  L52 @Override
    - 体内字面量："-1" · "onFailure: "
- `void deleteGKUUser(final FragmentActivity mActivity)`  L64
- `void run()`  L67 @Override
- `void lambda$deleteGKUUser$0(FragmentActivity fragmentActivity)`  L74
    - 体内字面量："deleteGKUUser: æ¬å°å é¤è´¦å·æå"
### `com.gku.loginmodule.repository.PTAndPMRepository_Factory`
L6 · [class] public final PTAndPMRepository_Factory · implements `Factory<PTAndPMRepository>` · `com/gku/loginmodule/repository/PTAndPMRepository_Factory.java`

方法（3）：
- `PTAndPMRepository get()`  L8 @Override
- `PTAndPMRepository_Factory create()`  L12
- `PTAndPMRepository newInstance()`  L16
### `com.gku.loginmodule.repository.PTAndPMRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/PTAndPMRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.RegisterRepository`
L14 · [class] public RegisterRepository · `com/gku/loginmodule/repository/RegisterRepository.java`

字段/常量（1）：
- `String TAG = "RegisterRepository"`  L15

方法（3）：
- `SingleLiveEvent<RegisterResponse> getRegister(String emailAddress, String code, String pwd, String language)`  L23
    - 体内字面量："email" · "vcode" · "password" · "lanCode"
- `void onSuccess(RegisterResponse response)`  L31 @Override
    - 体内字面量："onSuccess: "
- `void onFailure(Throwable e)`  L38 @Override
    - 体内字面量："News Error: "
### `com.gku.loginmodule.repository.RegisterRepository_Factory`
L6 · [class] public final RegisterRepository_Factory · implements `Factory<RegisterRepository>` · `com/gku/loginmodule/repository/RegisterRepository_Factory.java`

方法（3）：
- `RegisterRepository get()`  L8 @Override
- `RegisterRepository_Factory create()`  L12
- `RegisterRepository newInstance()`  L16
### `com.gku.loginmodule.repository.RegisterRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/RegisterRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.ReportFeedbackRepository`
L14 · [class] public ReportFeedbackRepository · `com/gku/loginmodule/repository/ReportFeedbackRepository.java`

字段/常量（1）：
- `String TAG = "ReportFbRepository"`  L15

方法（4）：
- `public ReportFeedbackRepository()`  L20 @Inject
- `MutableLiveData<ReportFeedbackResponse> getReportFeedbackResponse(String productType, String product, String problemTypeID, String attachmentUrl, String logUrl, String problemDesc, String language)`  L23
    - 体内字面量："qs_type_id" · "product" · "product_type" · "image" · "log_file" · "description" · "lang"
- `void onSuccess(ReportFeedbackResponse response)`  L34 @Override
- `void onFailure(Throwable e)`  L40 @Override
    - 体内字面量："onFailure: "
### `com.gku.loginmodule.repository.ReportFeedbackRepository_Factory`
L6 · [class] public final ReportFeedbackRepository_Factory · implements `Factory<ReportFeedbackRepository>` · `com/gku/loginmodule/repository/ReportFeedbackRepository_Factory.java`

方法（3）：
- `ReportFeedbackRepository get()`  L8 @Override
- `ReportFeedbackRepository_Factory create()`  L12
- `ReportFeedbackRepository newInstance()`  L16
### `com.gku.loginmodule.repository.ReportFeedbackRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/ReportFeedbackRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.UpdateUserInfoRepository`
L15 · [class] public UpdateUserInfoRepository · `com/gku/loginmodule/repository/UpdateUserInfoRepository.java`

字段/常量（1）：
- `String TAG = "UpdateUInfoRepository"`  L16

方法（4）：
- `public UpdateUserInfoRepository()`  L20 @Inject
- `MutableLiveData<UpdateUserInformationResponse> getUpdateUserInformationResponse(String id, String phoneNum, String language, String productModel, String habits, String userdata1, String userdata2, String userdata3)`  L23
    - 体内字面量："mobile" · "lanCode" · "productModel" · "habits" · "userdata1" · "userdata2" · "userdata3"
- `void onSuccess(UpdateUserInformationResponse response)`  L35 @Override
- `void onFailure(Throwable e)`  L40 @Override
    - 体内字面量："Network Error: " · "onFailure: "
### `com.gku.loginmodule.repository.UpdateUserInfoRepository_Factory`
L6 · [class] public final UpdateUserInfoRepository_Factory · implements `Factory<UpdateUserInfoRepository>` · `com/gku/loginmodule/repository/UpdateUserInfoRepository_Factory.java`

方法（3）：
- `UpdateUserInfoRepository get()`  L8 @Override
- `UpdateUserInfoRepository_Factory create()`  L12
- `UpdateUserInfoRepository newInstance()`  L16
### `com.gku.loginmodule.repository.UpdateUserInfoRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/UpdateUserInfoRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.UploadAttachmentRepository`
L25 · [class] public UploadAttachmentRepository · `com/gku/loginmodule/repository/UploadAttachmentRepository.java`

字段/常量（2）：
- `String TAG = "UploadRepository"`  L26
- `long length`  L33

方法（5）：
- `public UploadAttachmentRepository()`  L29 @Inject
- `SingleLiveEvent<UploadAttachmentResponse> getUploadAttachmentResponse(final Report_Feedback_Activity mActivity, LifecycleOwner lifecycleOwner, File uploadZipFile)`  L32
- `void run()`  L50 @Override
- `void onSuccess(UploadAttachmentResponse response)`  L62 @Override
- `void onFailure(Throwable e2)`  L67 @Override
### `com.gku.loginmodule.repository.UploadAttachmentRepository_Factory`
L6 · [class] public final UploadAttachmentRepository_Factory · implements `Factory<UploadAttachmentRepository>` · `com/gku/loginmodule/repository/UploadAttachmentRepository_Factory.java`

方法（3）：
- `UploadAttachmentRepository get()`  L8 @Override
- `UploadAttachmentRepository_Factory create()`  L12
- `UploadAttachmentRepository newInstance()`  L16
### `com.gku.loginmodule.repository.UploadAttachmentRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/UploadAttachmentRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23
### `com.gku.loginmodule.repository.VerifyCodeRepository`
L14 · [class] public VerifyCodeRepository · `com/gku/loginmodule/repository/VerifyCodeRepository.java`

字段/常量（1）：
- `String TAG = "VerifyCodeRepository"`  L15

方法（4）：
- `public VerifyCodeRepository()`  L20 @Inject
- `SingleLiveEvent<VerifyCodeResponse> getVerifyCode(String emailAddress, String opType)`  L23
    - 体内字面量："email" · "scene"
- `void onSuccess(VerifyCodeResponse response)`  L29 @Override
    - 体内字面量："response onSuccess: "
- `void onFailure(Throwable e)`  L36 @Override
    - 体内字面量："onFailure: "
### `com.gku.loginmodule.repository.VerifyCodeRepository_Factory`
L6 · [class] public final VerifyCodeRepository_Factory · implements `Factory<VerifyCodeRepository>` · `com/gku/loginmodule/repository/VerifyCodeRepository_Factory.java`

方法（3）：
- `VerifyCodeRepository get()`  L8 @Override
- `VerifyCodeRepository_Factory create()`  L12
- `VerifyCodeRepository newInstance()`  L16
### `com.gku.loginmodule.repository.VerifyCodeRepository_Factory$InstanceHolder`
L20 · [class] private static final InstanceHolder · `com/gku/loginmodule/repository/VerifyCodeRepository_Factory.java`

方法（1）：
- `private InstanceHolder()`  L23